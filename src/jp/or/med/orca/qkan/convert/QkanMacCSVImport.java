package jp.or.med.orca.qkan.convert;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.io.File;
import java.text.FieldPosition;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import jp.nichicom.ac.ACConstants;
import jp.nichicom.ac.component.ACButton;
import jp.nichicom.ac.component.ACLabel;
import jp.nichicom.ac.component.ACTextArea;
import jp.nichicom.ac.component.ACTextField;
import jp.nichicom.ac.container.ACGroupBox;
import jp.nichicom.ac.container.ACPanel;
import jp.nichicom.ac.core.ACAffairContainer;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACAffairable;
import jp.nichicom.ac.core.ACDefaultFrameEventProcesser;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.core.ACFrameEventProcesser;
import jp.nichicom.ac.filechooser.ACFileChooser;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.sql.ACDBManager;
import jp.nichicom.ac.text.ACSQLSafeDateFormat;
import jp.nichicom.ac.text.ACSQLSafeIntegerFormat;
import jp.nichicom.ac.text.ACSQLSafeStringFormat;
import jp.nichicom.ac.util.ACDateUtilities;
import jp.nichicom.ac.util.ACMessageBox;
import jp.nichicom.bridge.sql.BridgeFirebirdDBManager;
import jp.nichicom.vr.io.VRCSVFile;
import jp.nichicom.vr.layout.VRLayout;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRMap;
import jp.nichicom.vr.util.logging.VRLogger;
import jp.or.med.orca.qkan.QkanCommon;

public class QkanMacCSVImport extends ACAffairContainer implements ACAffairable {

    private ACPanel contents = null;
    private ACLabel message = null;
    private ACPanel buttons = null;
    private ACButton execute = null;
    private ACButton exit = null;
    private ACPanel settings = null;
    private ACTextField sourceDirectory = null;
    private ACButton sourceBrowse = null;
    private ACGroupBox sourceDirectorys = null;

    public QkanMacCSVImport() throws HeadlessException {
        super();
        initialize();
    }

    /**
     * This method initializes buttons
     * 
     * @return javax.swing.JPanel
     */
    private ACPanel getButtons() {
        if (buttons == null) {
            buttons = new ACPanel();
            buttons.add(getExit(), VRLayout.EAST);
            buttons.add(getExecute(), VRLayout.EAST);
        }
        return buttons;
    }

    /**
     * This method initializes execute
     * 
     * @return javax.swing.JButton
     */
    private ACButton getExecute() {
        if (execute == null) {
            execute = new ACButton();
            execute.setText("実行(E)");
            execute.setMnemonic('E');
            execute.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    executeImport();
                }
            });
        }
        return execute;
    }

    /**
     * データ移行を実行します。
     */
    protected void executeImport() {
        // データ移行を実行可能かチェックします。
        File dir = new File(getSourceDirectory().getText());
        if ((dir == null) || (!dir.isDirectory())) {
            ACMessageBox.showExclamation("「移行元CSVファイルの場所」が不正です。"
                    + ACConstants.LINE_SEPARATOR + "「移行元CSVファイルの場所」を指定してください。");
            getSourceDirectory().requestFocus();
            return;
        }
        boolean repeated = false;
        File[] files = dir.listFiles();
        patietFile = null;
        ninteiFile = null;
        staffFile = null;
        insurerFile = null;
        providerFile = null;
        kyotakuRyoyoFile = null;
        homonKangoPlanFile = null;
        homonKangoResultFile = null;
        int end = files.length;
        for (int i = 0; i < end; i++) {
            File f = files[i];
            String name = f.getName();
            if (name == null) {
                name = "";
            } else {
                name = name.toUpperCase();
            }
            if ((name != null) && name.startsWith("SJS")) {
                if (name.endsWith("PATIENT.CSV")) {
                    // 利用者情報：PATIENT
                    if (patietFile != null) {
                        repeated = true;
                    } else {
                        patietFile = f;
                    }
                } else if (name.endsWith("NINTEI.CSV")) {
                    // 利用者要介護情報：NINTEI
                    if (ninteiFile != null) {
                        repeated = true;
                    } else {
                        ninteiFile = f;
                    }
                } else if (name.endsWith("STAFF.CSV")) {
                    // 担当者情報：STAFF
                    if (staffFile != null) {
                        repeated = true;
                    } else {
                        staffFile = f;
                    }
                } else if (name.endsWith("INSURER.CSV")) {
                    // 保険者情報：INSURER
                    if (insurerFile != null) {
                        repeated = true;
                    } else {
                        insurerFile = f;
                    }
                } else if (name.endsWith("PROVIDER.CSV")) {
                    // 事業所情報：PROVIDER
                    if (providerFile != null) {
                        repeated = true;
                    } else {
                        providerFile = f;
                    }
                } else if (name.endsWith("RYOYO.CSV")) {
                    // 居宅療養管理指導書：KYOTAKU_RYOYO
                    if (kyotakuRyoyoFile != null) {
                        repeated = true;
                    } else {
                        kyotakuRyoyoFile = f;
                    }
                } else if (name.endsWith("PLAN.CSV")) {
                    // 訪問看護計画書：HOMONKANGO_PLAN
                    if (homonKangoPlanFile != null) {
                        repeated = true;
                    } else {
                        homonKangoPlanFile = f;
                    }
                } else if (name.endsWith("RESULT.CSV")) {
                    // 訪問看護報告書：HOMONKANGO_RESULT
                    if (homonKangoResultFile != null) {
                        repeated = true;
                    } else {
                        homonKangoResultFile = f;
                    }
                }
            }
        }
        if (repeated) {
            ACMessageBox.showExclamation("2組以上の移行元データが存在します。"
                    + ACConstants.LINE_SEPARATOR
                    + "「移行元CSVファイルの場所」のファイルをいったんすべて削除し、再度移行元データを出力してください。");
            return;
        }

        // 移行するデータを一覧化
        boolean fileExists = false;
        StringBuffer sb = new StringBuffer();
        if (patietFile != null) {
            sb.append("　・利用者情報");
            sb.append(ACConstants.LINE_SEPARATOR);
            fileExists = true;
        }
        if (ninteiFile != null) {
            sb.append("　・利用者要介護情報");
            sb.append(ACConstants.LINE_SEPARATOR);
            fileExists = true;
        }
        if (staffFile != null) {
            sb.append("　・担当者情報");
            sb.append(ACConstants.LINE_SEPARATOR);
            fileExists = true;
        }
        if (insurerFile != null) {
            sb.append("　・保険者情報");
            sb.append(ACConstants.LINE_SEPARATOR);
            fileExists = true;
        }
        if (providerFile != null) {
            sb.append("　・事業所情報");
            sb.append(ACConstants.LINE_SEPARATOR);
            fileExists = true;
        }
        if (kyotakuRyoyoFile != null) {
            sb.append("　・居宅療養管理指導書");
            sb.append(ACConstants.LINE_SEPARATOR);
            fileExists = true;
        }
        if (homonKangoPlanFile != null) {
            sb.append("　・訪問看護計画書");
            sb.append(ACConstants.LINE_SEPARATOR);
            fileExists = true;
        }
        if (homonKangoResultFile != null) {
            sb.append("　・訪問看護報告書");
            sb.append(ACConstants.LINE_SEPARATOR);
            fileExists = true;
        }

        if (!fileExists) {
            ACMessageBox.showExclamation("移行元のCSVファイルが存在しません。"
                    + ACConstants.LINE_SEPARATOR
                    + "「移行元CSVファイルの場所」のファイルをいったんすべて削除し、再度移行元データを出力してください。");
            return;
        }

        dbm = null;
        try {
            dbm = new BridgeFirebirdDBManager();
            if (!dbm.canConnect()) {
                throw new Exception("データベースへ接続できません。");
            }
        } catch (Exception ex) {
            VRLogger.info(ex.getStackTrace());
            ACMessageBox.showExclamation("データベースへ接続できません。"
                    + ACConstants.LINE_SEPARATOR
                    + "給管鳥本体を起動し、データベースの設定を行ってください。");
            return;
        }

        if (ACMessageBox
                .showOkCancel("以下のデータ移行を開始します。よろしいですか？"
                        + ACConstants.LINE_SEPARATOR
                        + ACConstants.LINE_SEPARATOR + sb.toString()
                        + ACConstants.LINE_SEPARATOR
                        + "【※注意※】移行先のデータはすべて消去されます。"
                        + ACConstants.LINE_SEPARATOR
                        + "　　　　　　必ず事前にバックアップを取ってください。"
                        + ACConstants.LINE_SEPARATOR
                        + "　　　　　　※移行元(旧バージョン)のデータに影響はありません。",
                        ACMessageBox.FOCUS_CANCEL) != ACMessageBox.RESULT_OK) {
            return;
        }

        errorCount = 0;

        getExecute().setEnabled(false);
        new Thread(new Runnable() {
            public void run() {
                try {
                    setProgressTitle("　データ移行中..");
                    setProgress("[既存データの削除]");
                    VRCSVFile f = new VRCSVFile("dummy", VRCSVFile.SJIS);
                    // 訪問看護報告書
                    errorCount += executeUpdate(dbm,
                            "DELETE FROM HOMONKANGO_RESULT");
                    errorCount += executeUpdate(dbm,
                            "DELETE FROM HOMONKANGO_RESULT_CALENDAR");
                    // 訪問看護計画書
                    errorCount += executeUpdate(dbm,
                            "DELETE FROM HOMONKANGO_PLAN");
                    errorCount += executeUpdate(dbm,
                            "DELETE FROM HOMONKANGO_PLAN_NOTE");
                    // 保険者
                    errorCount += executeUpdate(dbm, "DELETE FROM INSURER");
                    errorCount += executeUpdate(dbm, "DELETE FROM PATIENT_KOHI");
                    errorCount += executeUpdate(dbm,
                            "DELETE FROM INSURER_LIMIT_RATE");
                    errorCount += executeUpdate(dbm,
                            "DELETE FROM INSURER_LIMIT_RATE_DETAIL");
                    // 居宅療養管理指導書
                    errorCount += executeUpdate(dbm,
                            "DELETE FROM KYOTAKU_RYOYO");
                    // 利用者情報
                    errorCount += executeUpdate(dbm, "DELETE FROM PATIENT");
                    errorCount += executeUpdate(dbm,
                            "DELETE FROM PATIENT_CHANGES_HISTORY");
                    errorCount += executeUpdate(dbm, "DELETE FROM PATIENT_KOHI");
                    errorCount += executeUpdate(dbm,
                            "DELETE FROM PATIENT_KOHI_SERVICE");
                    errorCount += executeUpdate(dbm,
                            "DELETE FROM PATIENT_MEDICAL_HISTORY");
                    errorCount += executeUpdate(dbm,
                            "DELETE FROM PATIENT_SHISETSU_HISTORY");
                    errorCount += executeUpdate(dbm,
                            "DELETE FROM PATIENT_STATION_HISTORY");
                    errorCount += executeUpdate(dbm,
                            "DELETE FROM PATIENT_NINTEI_HISTORY");
                    // 訪問看護情報提供書
                    errorCount += executeUpdate(dbm,
                            "DELETE FROM HOMONKANGO_JOHO_TEIKYOSHO");
                    // 訪問看護記録書
                    errorCount += executeUpdate(dbm,
                            "DELETE FROM HOMONKANGO_KIROKUSHO");
                    // 事業所
                    errorCount += executeUpdate(dbm, "DELETE FROM PROVIDER");
                    errorCount += executeUpdate(dbm,
                            "DELETE FROM PROVIDER_MENU");
                    errorCount += executeUpdate(dbm,
                            "DELETE FROM PROVIDER_SERVICE");
                    errorCount += executeUpdate(dbm,
                            "DELETE FROM PROVIDER_SERVICE_DETAIL_DATE");
                    errorCount += executeUpdate(dbm,
                            "DELETE FROM PROVIDER_SERVICE_DETAIL_INTEGER");
                    errorCount += executeUpdate(dbm,
                            "DELETE FROM PROVIDER_SERVICE_DETAIL_TEXT");
                    // 担当者
                    errorCount += executeUpdate(dbm, "DELETE FROM STAFF");
                    // サービス
                    errorCount += executeUpdate(dbm,
                            "DELETE FROM SERVICE_PASSIVE_CHECK");
                    try {
                        dbm.beginTransaction();
                        QkanCommon.updateServiceDetailCustom(dbm,
                                new VRArrayList(), null, "");
                        dbm.commitTransaction();
                    } catch (Exception ex) {
                        VRLogger.info(ex);
                        try {
                            dbm.rollbackTransaction();
                        } catch (Exception ex2) {
                            VRLogger.info(ex2);
                        }
                        errorCount++;
                    }
                    // 請求
                    errorCount += executeUpdate(dbm,
                            "DELETE FROM CLAIM_PATIENT_DETAIL");
                    try {
                        dbm.beginTransaction();
                        QkanCommon.updateClaimDetailCustom(dbm,
                                new VRArrayList(), null, "");
                        dbm.commitTransaction();
                    } catch (Exception ex) {
                        VRLogger.info(ex);
                        try {
                            dbm.rollbackTransaction();
                        } catch (Exception ex2) {
                            VRLogger.info(ex2);
                        }
                        errorCount++;
                    }
                    // 事業所情報
                    List providers = new ArrayList();
                    if (providerFile != null) {
                        f.setPath(providerFile.getAbsolutePath());
                        f.clear();
                        f.read(false);
                        addErrorCount(importProvider(dbm, f, providers));
                    }

                    // 保険者情報
                    if (insurerFile != null) {
                        f.setPath(insurerFile.getAbsolutePath());
                        f.clear();
                        f.read(false);
                        addErrorCount(importInsurer(dbm, f));
                    }

                    // 利用者情報
                    if (patietFile != null) {
                        f.setPath(patietFile.getAbsolutePath());
                        f.clear();
                        f.read(false);
                        addErrorCount(importPatient(dbm, f));
                    }

                    // 利用者認定履歴
                    if (ninteiFile != null) {
                        f.setPath(ninteiFile.getAbsolutePath());
                        f.clear();
                        f.read(false);
                        addErrorCount(importPatientNinteiHistory(dbm, f, providers));
                    }

                    // スタッフ情報
                    if (staffFile != null) {
                        f.setPath(staffFile.getAbsolutePath());
                        f.clear();
                        f.read(false);
                        addErrorCount(importStaff(dbm, f));
                    }

                    // 居宅療養管理指導書
                    if (kyotakuRyoyoFile != null) {
                        f.setPath(kyotakuRyoyoFile.getAbsolutePath());
                        f.clear();
                        f.read(false);
                        addErrorCount(importKyotakuRyoyo(dbm, f));
                    }
                    // 訪問看護計画書
                    if (homonKangoPlanFile != null) {
                        f.setPath(homonKangoPlanFile.getAbsolutePath());
                        f.clear();
                        f.read(false);
                        addErrorCount(importHomonPlan(dbm, f));
                    }
                    // 訪問看護報告書
                    if (homonKangoResultFile != null) {
                        f.setPath(homonKangoResultFile.getAbsolutePath());
                        f.clear();
                        f.read(false);
                        addErrorCount(importHomonResult(dbm, f));
                    }

                    if (errorCount > 0) {
                        ACMessageBox.show("データ移行を完了しました。"
                                + ACConstants.LINE_SEPARATOR + " " + errorCount
                                + " 件の移行に失敗しています。" + ACConstants.LINE_SEPARATOR
                                + "詳細はlogsフォルダ配下のログファイルを参照してください。");
                    } else {
                        ACMessageBox.show("データ移行を完了しました。");
                    }
                } catch (Throwable ex) {
                    ACFrame.getInstance().showExceptionMessage(ex);
                }
                setProgressTitle("　旧verから出力したCSVファイルの保存先を指定し、実行ボタンを押下してください。");
                setProgress("");
                getExecute().setEnabled(true);
            };
        }).start();
    }

    /**
     * 訪問看護報告書を移行します。
     * 
     * @param dbm DBマネージャ
     * @param f CSVファイル
     * @return エラー総数
     */
    protected int importHomonResult(ACDBManager dbm, VRCSVFile f) {
        setProgressTitle("　訪問看護報告書の移行中..");
        int error = 0;
        StringBuffer sb = new StringBuffer();
        sb.append("INSERT INTO HOMONKANGO_RESULT(");
        sb.append(" PATIENT_ID");
        sb.append(",TARGET_DATE");
        sb.append(",JOTAI_CODE");
        sb.append(",DOCTOR_NAME");
        sb.append(",CREATE_DATE");
        sb.append(",PROVIDER_NAME");
        sb.append(",ADMINISTRATOR_NAME");
        sb.append(",BYOJO_STATE");
        sb.append(",KANGO_REHA_NAIYO");
        sb.append(",RYOYO_KAIGO_STATE");
        sb.append(",REPORT_COMMENT");
        sb.append(",LAST_TIME");
        sb.append(")VALUES(");
        String header = sb.toString();
        sb = new StringBuffer();
        sb.append("INSERT INTO HOMONKANGO_RESULT_CALENDAR(");
        sb.append(" PATIENT_ID");
        sb.append(",VISIT_DATE");
        sb.append(",VISIT_VALUE");
        sb.append(",LAST_TIME");
        sb.append(")VALUES(");
        String noteHeader = sb.toString();
        // 主キーである利用者ID+作成日の重複をチェック。
        List pureList = filterRecord(f);
        int end = pureList.size();
        setProgressTitle("　訪問看護報告書の移行中..[" + end + "件中/");
        for (int i = 0; i < end; i++) {
            List list = (List) pureList.get(i);
            try {
                setProgress(i + "件目] 失敗=" + error + "件");
                if (list.size() > 10) {
                    sb = new StringBuffer(header);
                    // 利用者番号 整数
                    String patientID = INTEGER_FORMAT.format(list.get(0));
                    sb.append(patientID);
                    // 対象年月 日付
                    String targetDate = DATE_FORMAT.format(list.get(1));
                    if ("NULL".equals(targetDate)) {
                        continue;
                    }
                    sb.append(",");
                    sb.append(targetDate);
                    // 要介護度 整数
                    sb.append(",");
                    sb.append(INTEGER_FORMAT.format(list.get(2)));
                    // 主治医名 文字列
                    sb.append(",");
                    sb.append(cutLength(list, 3, 32));
                    // 作成年月日 日付
                    sb.append(",");
                    sb.append(DATE_FORMAT.format(list.get(4)));
                    // ステーション名 文字列
                    sb.append(",");
                    sb.append(cutLength(list, 5, 64));
                    // 管理者氏名 文字列
                    sb.append(",");
                    sb.append(cutLength(list, 6, 22));
                    // 病状の経過 文字列
                    sb.append(",");
                    sb.append(cutLength(list, 7, 294));
                    // 看護・リハビリテーションの内容 文字列
                    sb.append(",");
                    sb.append(cutLength(list, 8, 378));
                    // 家庭での療養・介護の状況 文字列
                    sb.append(",");
                    sb.append(cutLength(list, 9, 336));
                    // 特記すべき事項 文字列
                    sb.append(",");
                    sb.append(cutLength(list, 10, 240));
                    // 最終更新日 LAST_TIME
                    sb.append(",CURRENT_TIMESTAMP)");
                    error += executeUpdate(dbm, sb.toString());

                    int limit = list.size();
                    for (int j = 11; j < limit; j++) {
                        String[] arrays = ACCastUtilities.toString(list.get(j))
                                .split("=", 2);

                        sb = new StringBuffer(noteHeader);
                        // 利用者番号
                        sb.append(patientID);
                        // 訪問日
                        sb.append(",");
                        sb.append(DATE_FORMAT.format(arrays[0]));
                        // 値
                        sb.append(",");
                        if (arrays.length > 1) {
                            sb.append(INTEGER_FORMAT.format(arrays[1]));
                        } else {
                            sb.append("0");
                        }
                        // 最終更新日
                        sb.append(",CURRENT_TIMESTAMP)");
                        error += executeUpdate(dbm, sb.toString());
                    }
                } else {
                    throw new Exception("不正なフィールド数");
                }
            } catch (Exception ex) {
                VRLogger.info("不正なCSVレコード 訪問看護報告書(" + (i + 1) + ") = "
                        + list.toString());
                error++;
            }
        }
        return error;
    }

    /**
     * 第1・第2フィールドを主キーとして、重複を省いたリストを返します。
     * <p>
     * 重複した場合、最後に見つかったレコードが優先されます。
     * </p>
     * 
     * @param f ファイル
     * @return 抽出結果
     */
    protected List filterRecord(VRCSVFile f) {
        // 主キーである利用者ID+作成日の重複をチェック。
        // 重複する場合、最後のデータが
        int end = f.getRowCount();
        TreeMap repeatCache = new TreeMap();
        for (int i = 0; i < end; i++) {
            List list = f.getRow(i);
            if (list.size() > 2) {
                String repeatKey = INTEGER_FORMAT.format(list.get(0)) + "/"
                        + DATE_FORMAT.format(list.get(1));
                repeatCache.put(repeatKey, list);
            }
        }
        return new ArrayList(repeatCache.values());
    }

    /**
     * 訪問看護計画書を移行します。
     * 
     * @param dbm DBマネージャ
     * @param f CSVファイル
     * @return エラー総数
     */
    protected int importHomonPlan(ACDBManager dbm, VRCSVFile f) {
        setProgressTitle("　訪問看護計画書の移行中..");
        int error = 0;
        Map noteHash = new HashMap();
        StringBuffer sb = new StringBuffer();
        sb.append("INSERT INTO HOMONKANGO_PLAN(");
        sb.append(" PATIENT_ID");
        sb.append(",TARGET_DATE");
        sb.append(",JOTAI_CODE");
        sb.append(",DOCTOR_NAME");
        sb.append(",CREATE_DATE");
        sb.append(",PROVIDER_NAME");
        sb.append(",ADMINISTRATOR_NAME");
        sb.append(",PLAN_PURPOSE");
        sb.append(",PLAN_COMMENT");
        sb.append(",LAST_TIME");
        sb.append(")VALUES(");
        String header = sb.toString();
        // 主キーである利用者ID+作成日の重複をチェック。
        List pureList = filterRecord(f);
        int end = pureList.size();
        setProgressTitle("　訪問看護計画書の移行中..[" + end + "件中/");
        for (int i = 0; i < end; i++) {
            List list = (List) pureList.get(i);
            try {
                setProgress(i + "件目] 失敗=" + error + "件");
                if (list.size() > 8) {
                    sb = new StringBuffer(header);
                    // 利用者番号 整数
                    String patientID = INTEGER_FORMAT.format(list.get(0));
                    sb.append(patientID);
                    // 対象年月 日付
                    String targetDate = DATE_FORMAT.format(list.get(1));
                    if ("NULL".equals(targetDate)) {
                        continue;
                    }
                    sb.append(",");
                    sb.append(targetDate);
                    // 要介護度 整数
                    sb.append(",");
                    sb.append(INTEGER_FORMAT.format(list.get(2)));
                    // 主治医名 文字列
                    sb.append(",");
                    sb.append(cutLength(list, 3, 32));
                    // 作成年月日 日付
                    sb.append(",");
                    sb.append(DATE_FORMAT.format(list.get(4)));
                    // ステーション名 文字列
                    sb.append(",");
                    sb.append(cutLength(list, 5, 64));
                    // 管理者氏名 文字列
                    sb.append(",");
                    sb.append(cutLength(list, 6, 22));
                    // 看護・リハビリテーションの目標 文字列
                    sb.append(",");
                    sb.append(cutLength(list, 7, 572));
                    // 備考 文字列
                    sb.append(",");
                    sb.append(cutLength(list, 8, 172));
                    // 最終更新日 LAST_TIME
                    sb.append(",CURRENT_TIMESTAMP)");
                    error += executeUpdate(dbm, sb.toString());

                    noteHash.put(patientID, list);
                } else {
                    throw new Exception("不正なフィールド数");
                }
            } catch (Exception ex) {
                VRLogger.info("不正なCSVレコード 訪問看護計画書(" + (i + 1) + ") = "
                        + list.toString());
                error++;
            }
        }

        sb = new StringBuffer();
        sb.append("INSERT INTO HOMONKANGO_PLAN_NOTE(");
        sb.append(" PATIENT_ID");
        sb.append(",NOTE_ID");
        sb.append(",NOTE_DATE");
        sb.append(",NOTE_COMMENT");
        sb.append(",LAST_TIME");
        sb.append(")VALUES(");
        String noteHeader = sb.toString();
        Iterator it = noteHash.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry ent = (Map.Entry) it.next();
            List list = (List) ent.getValue();
            String patientID = ACCastUtilities.toString(ent.getKey(), "");
            try {

                int index = 1;
                int limit = list.size();
                for (int j = 9; j < limit; j++) {
                    String[] arrays = ACCastUtilities.toString(list.get(j))
                            .split("=", 2);

                    sb = new StringBuffer(noteHeader);
                    // 利用者番号
                    sb.append(patientID);
                    // 枝番
                    sb.append(",");
                    sb.append(index);
                    // 問題点・解決策・日付
                    String targetDate = DATE_FORMAT.format(arrays[0]);
                    if ("NULL".equals(targetDate)) {
                        continue;
                    }
                    sb.append(",");
                    sb.append(targetDate);

                    // 問題点・解決策・内容
                    sb.append(",");
                    if (arrays.length > 1) {
                        sb.append(cutLength(STRING_FORMAT.format(arrays[1]),
                                3000));
                    } else {
                        sb.append("''");
                    }
                    // 最終更新日
                    sb.append(",CURRENT_TIMESTAMP)");
                    int err = executeUpdate(dbm, sb.toString());
                    if (err != 0) {
                        error += err;
                    } else {
                        index++;
                    }
                }
            } catch (Exception ex) {
                VRLogger.info("不正なCSVレコード 訪問看護計画書(利用者ID=" + patientID + ") = "
                        + list.toString());
                error++;
            }
        }

        return error;
    }

    /**
     * 居宅療養管理指導書情報を移行します。
     * 
     * @param dbm DBマネージャ
     * @param f CSVファイル
     * @return エラー総数
     */
    protected int importKyotakuRyoyo(ACDBManager dbm, VRCSVFile f) {
        setProgressTitle("　居宅療養管理指導書の移行中..");
        // setProgress("[既存データの削除]");
        int error = 0;
        // error += executeUpdate(dbm, "DELETE FROM KYOTAKU_RYOYO");
        StringBuffer sb = new StringBuffer();
        sb.append("INSERT INTO KYOTAKU_RYOYO(");
        sb.append(" PATIENT_ID");
        sb.append(",TARGET_DATE");
        sb.append(",JOTAI_CODE");
        sb.append(",SHOGAI_JIRITSUDO");
        sb.append(",NINCHISHO_JIRITSUDO");
        sb.append(",PATIENT_ADDRESS");
        sb.append(",PATIENT_TEL_FIRST");
        sb.append(",PATIENT_TEL_SECOND");
        sb.append(",PATIENT_TEL_THIRD");
        sb.append(",CREATE_DATE_ZAITAKU");
        sb.append(",VISIT_THIS_MONTH_NO1");
        sb.append(",VISIT_THIS_MONTH_NO2");
        sb.append(",VISIT_THIS_MONTH_NO3");
        sb.append(",VISIT_THIS_MONTH_NO4");
        sb.append(",VISIT_THIS_MONTH_NO5");
        sb.append(",VISIT_THIS_MONTH_NO6");
        sb.append(",VISIT_NEXT_MONTH_NO1");
        sb.append(",VISIT_NEXT_MONTH_NO2");
        sb.append(",VISIT_NEXT_MONTH_NO3");
        sb.append(",VISIT_NEXT_MONTH_NO4");
        sb.append(",VISIT_NEXT_MONTH_NO5");
        sb.append(",VISIT_NEXT_MONTH_NO6");
        sb.append(",ADVICE_MONTH");
        sb.append(",ADVICE");
        sb.append(",MEDICAL_FACILITY_NAME");
        sb.append(",DOCTOR_NAME");
        sb.append(",MEDICAL_FACILITY_ADDRESS");
        sb.append(",MEDICAL_FACILITY_TEL_FIRST");
        sb.append(",MEDICAL_FACILITY_TEL_SECOND");
        sb.append(",MEDICAL_FACILITY_TEL_THIRD");
        sb.append(",SENMONIN");
        sb.append(",PROVIDER_NAME");
        sb.append(",CREATE_DATE_KYOTAKU");
        sb.append(",CONDITION");
        sb.append(",CONDITION_PASSAGE");
        sb.append(",NOTE_OF_KAIGO_SERVICE");
        sb.append(",NOTE_OF_DAILY_LIFE");
        sb.append(",REMARKS");
        sb.append(",LAST_TIME");
        sb.append(")VALUES(");
        String header = sb.toString();
        // 主キーである利用者ID+作成日の重複をチェック。
        List pureList = filterRecord(f);
        int end = pureList.size();
        setProgressTitle("　居宅療養管理指導書の移行中..[" + end + "件中/");
        for (int i = 0; i < end; i++) {
            List list = (List) pureList.get(i);
            try {
                setProgress(i + "件目] 失敗=" + error + "件");
                if (list.size() > 27) {
                    sb = new StringBuffer(header);
                    // 利用者ID
                    sb.append(INTEGER_FORMAT.format(list.get(0)));
                    // 対象年月
                    String targetDate = DATE_FORMAT.format(list.get(1));
                    if ("NULL".equals(targetDate)) {
                        continue;
                    }
                    sb.append(",");
                    sb.append(targetDate);
                    // 要介護状態区分コード
                    sb.append(",");
                    sb.append(INTEGER_FORMAT.format(list.get(2)));

                    // 障害高齢者日常生活自立度 SHOGAI_JIRITSUDO INTEGER
                    String shogaiJiritsu = "0";
                    switch (ACCastUtilities.toInt(list.get(5), 0)) {
                    case 1: // 正常
                        shogaiJiritsu = "1";
                        break;
                    case 2:// J1
                    case 3:// J2
                        shogaiJiritsu = "2";
                        break;
                    case 4:// A1
                    case 5:// A2
                        shogaiJiritsu = "3";
                        break;
                    case 6:// B1
                    case 7:// B2
                        shogaiJiritsu = "4";
                        break;
                    case 8:// C1
                    case 9:// C2
                        shogaiJiritsu = "5";
                        break;
                    }
                    sb.append(",");
                    sb.append(shogaiJiritsu);
                    // 認知症高齢者日常生活自立度 NINCHISHO_JIRITSUDO INTEGER
                    String ninchiJiritsu = "0";
                    switch (ACCastUtilities.toInt(list.get(6), 0)) {
                    case 1: // 正常
                        ninchiJiritsu = "1";
                        break;
                    case 2:// I
                        ninchiJiritsu = "2";
                        break;
                    case 3:// IIa
                    case 4:// IIb
                        ninchiJiritsu = "3";
                        break;
                    case 5:// IIIa
                    case 6:// IIIb
                        ninchiJiritsu = "4";
                        break;
                    case 7:// IV
                        ninchiJiritsu = "5";
                        break;
                    case 8:// M
                        ninchiJiritsu = "6";
                        break;
                    }
                    sb.append(",");
                    sb.append(ninchiJiritsu);
                    // 利用者住所 PATIENT_ADDRESS VARCHAR 200
                    sb.append(",''");
                    // 利用者連絡先 PATIENT_TEL_FIRST VARCHAR 6
                    sb.append(",''");
                    // 利用者連絡先 PATIENT_TEL_SECOND VARCHAR 4
                    sb.append(",''");
                    // 利用者連絡先 PATIENT_TEL_THIRD VARCHAR 4
                    sb.append(",''");
                    // 在宅療養生活のポイントの作成年月 CREATE_DATE_ZAITAKU DATE sb.append(",");
                    sb.append(",");
                    sb.append(DATE_FORMAT.format(list.get(7)));
                    // 今月の訪問日(1つ目)
                    sb.append(",");
                    sb.append(DATE_FORMAT.format(list.get(8)));
                    // 今月の訪問日(2つ目)
                    sb.append(",");
                    sb.append(DATE_FORMAT.format(list.get(9)));
                    // 今月の訪問日(3つ目)
                    sb.append(",");
                    sb.append(DATE_FORMAT.format(list.get(10)));
                    // 今月の訪問日(4つ目)
                    sb.append(",");
                    sb.append(DATE_FORMAT.format(list.get(11)));
                    // 今月の訪問日(5つ目)
                    sb.append(",");
                    sb.append(DATE_FORMAT.format(list.get(12)));
                    // 今月の訪問日(6つ目)
                    sb.append(",");
                    sb.append(DATE_FORMAT.format(list.get(13)));
                    // 来月の訪問予定(1つ目)
                    sb.append(",");
                    sb.append(DATE_FORMAT.format(list.get(14)));
                    // 来月の訪問予定(2つ目)
                    sb.append(",");
                    sb.append(DATE_FORMAT.format(list.get(15)));
                    // 来月の訪問予定(3つ目)
                    sb.append(",");
                    sb.append(DATE_FORMAT.format(list.get(16)));
                    // 来月の訪問予定(4つ目)
                    sb.append(",");
                    sb.append(DATE_FORMAT.format(list.get(17)));
                    // 来月の訪問予定(5つ目)
                    sb.append(",");
                    sb.append(DATE_FORMAT.format(list.get(18)));
                    // 来月の訪問予定(6つ目)
                    sb.append(",");
                    sb.append(DATE_FORMAT.format(list.get(19)));
                    // ( )月のアドバイス
                    sb.append(",");
                    sb.append(INTEGER_FORMAT.format(list.get(20)));
                    // アドバイス
                    sb.append(",");
                    sb.append(cutLength(list, 21, 912));
                    // 医療機関名
                    sb.append(",");
                    sb.append(cutLength(list, 22, 64));
                    // 担当医師名
                    sb.append(",");
                    sb.append(cutLength(list, 23, 32));
                    // 住所 MEDICAL_FACILITY_ADDRESS VARCHAR 150
                    sb.append(",''");
                    // 医療機関連絡先1 MEDICAL_FACILITY_TEL_FIRST VARCHAR 6
                    sb.append(",''");
                    // 医療機関連絡先2 MEDICAL_FACILITY_TEL_SECOND VARCHAR 4
                    sb.append(",''");
                    // 医療機関連絡先3 MEDICAL_FACILITY_TEL_THIRD VARCHAR 4
                    sb.append(",''");
                    // 介護支援専門員
                    sb.append(",");
                    sb.append(STRING_FORMAT.format(list.get(25)));
                    // 事業所名
                    sb.append(",");
                    sb.append(STRING_FORMAT.format(list.get(26)));
                    // 居宅療養管理指導書の作成日付
                    sb.append(",");
                    sb.append(DATE_FORMAT.format(list.get(27)));
                    // 病状 CONDITION VARCHAR 250
                    sb.append(",''");
                    // 病状経過等 CONDITION_PASSAGE VARCHAR 250
                    sb.append(",''");
                    // 介護サービスを利用する上での留意点・介護方法等 NOTE_OF_KAIGO_SERVICE VARCHAR 250
                    sb.append(",''");
                    // 利用者の日常生活上の留意点 NOTE_OF_DAILY_LIFE VARCHAR 250
                    sb.append(",''");
                    // 備考 REMARKS VARCHAR 250
                    sb.append(",''");
                    // 最終更新日 LAST_TIME
                    sb.append(",CURRENT_TIMESTAMP)");
                    error += executeUpdate(dbm, sb.toString());
                } else {
                    throw new Exception("不正なフィールド数");
                }
            } catch (Exception ex) {
                VRLogger.info("不正なCSVレコード 居宅療養管理指導書(" + (i + 1) + ") = "
                        + list.toString());
                error++;
            }
        }
        return error;
    }

    /**
     * 事業所情報を移行します。
     * 
     * @param dbm DBマネージャ
     * @param f CSVファイル
     * @return エラー総数
     */
    protected int importProvider(ACDBManager dbm, VRCSVFile f, List providers) {
        setProgressTitle("　事業所情報の移行中..");
        int error = 0;
        StringBuffer sb = new StringBuffer();
        sb.append("INSERT INTO PROVIDER(");
        sb.append(" PROVIDER_ID");
        sb.append(",PROVIDER_TYPE");
        sb.append(",MEDICAL_FLAG");
        sb.append(",PROVIDER_NAME");
        sb.append(",PROVIDER_ZIP_FIRST");
        sb.append(",PROVIDER_ZIP_SECOND");
        sb.append(",PROVIDER_ADDRESS");
        sb.append(",PROVIDER_TEL_FIRST");
        sb.append(",PROVIDER_TEL_SECOND");
        sb.append(",PROVIDER_TEL_THIRD");
        sb.append(",PROVIDER_FAX_FIRST");
        sb.append(",PROVIDER_FAX_SECOND");
        sb.append(",PROVIDER_FAX_THIRD");
        sb.append(",PROVIDER_JIJIGYOUSHO_TYPE");
        sb.append(",PROVIDER_JIGYOU_TYPE");
        sb.append(",PROVIDER_AREA_TYPE");
        sb.append(",SPECIAL_AREA_FLAG");
        sb.append(",PROVIDER_OWNER_NAME");
        sb.append(",BANK_NAME");
        sb.append(",BANK_BRANCH_NAME");
        sb.append(",ACCOUNT_NUMBER");
        sb.append(",ACCOUNT_TYPE");
        sb.append(",ACCOUNT_HOLDER");
        sb.append(",DELETE_FLAG");
        sb.append(",LAST_TIME");
        sb.append(")VALUES(");
        String header = sb.toString();
        int end = f.getRowCount();
        setProgressTitle("　事業所情報の移行中..[" + end + "件中/");
        for (int i = 0; i < end; i++) {
            List list = f.getRow(i);
            try {
                setProgress(i + "件目] 失敗=" + error + "件");
                if (list.size() > 15) {
                    sb = new StringBuffer(header);
                    // 事業所番号 PROVIDER_ID
                    String providerID = STRING_FORMAT.format(list.get(0));
                    providers.add(providerID);
                    if ("NULL".equals(providerID)) {
                        continue;
                    }
                    sb.append(cutLength(providerID, 10));
                    // 事業所種別 PROVIDER_TYPE INTEGER
                    sb.append(",0");
                    // 医療機関フラグ MEDICAL_FLAG INTEGER
                    sb.append(",2");
                    // 事業所名PROVIDER_NAME
                    sb.append(",");
                    sb.append(cutLength(list, 1, 64));
                    // 郵便番号（前）PROVIDER_ZIP_FIRST
                    sb.append(",");
                    sb.append(cutLength(list, 2, 3));
                    // 郵便番号（後）PROVIDER_ZIP_SECOND
                    sb.append(",");
                    sb.append(cutLength(list, 3, 4));
                    // 所在地PROVIDER_ADDRESS
                    sb.append(",");
                    sb.append(cutLength(list, 4, 70));
                    // 電話番号（前）PROVIDER_TEL_FIRST
                    sb.append(",");
                    sb.append(cutLength(list, 5, 6));
                    // 電話番号（中）PROVIDER_TEL_SECOND
                    sb.append(",");
                    sb.append(cutLength(list, 6, 4));
                    // 電話番号（後）PROVIDER_TEL_THIRD
                    sb.append(",");
                    sb.append(cutLength(list, 7, 4));
                    // FAX番号（前）PROVIDER_FAX_FIRST
                    sb.append(",");
                    sb.append(cutLength(list, 8, 6));
                    // FAX番号（中）PROVIDER_FAX_SECOND
                    sb.append(",");
                    sb.append(cutLength(list, 9, 4));
                    // FAX番号（後）PROVIDER_FAX_THIRD
                    sb.append(",");
                    sb.append(cutLength(list, 10, 4));
                    // 自事業所区分PROVIDER_JIJIGYOUSHO_TYPE
                    sb.append(",");
                    sb.append(INTEGER_FORMAT.format(list.get(11)));
                    // 事業区分PROVIDER_JIGYOU_TYPE
                    sb.append(",");
                    sb.append(INTEGER_FORMAT.format(list.get(12)));
                    // 地域区分PROVIDER_AREA_TYPE
                    String area = INTEGER_FORMAT.format(list.get(13));
                    if (!("1".equals(area) || "2".equals(area)
                            || "3".equals(area) || "4".equals(area) || "5"
                            .equals(area))) {
                        // 特別区、特甲地、甲地、乙地、その他 以外はその他とする。
                        area = "5";
                    }
                    sb.append(",");
                    sb.append(area);
                    // 特別地域SPECIAL_AREA_FLAG
                    sb.append(",");
                    sb.append(INTEGER_FORMAT.format(list.get(14)));
                    // 開設者氏名PROVIDER_OWNER_NAME
                    sb.append(",");
                    sb.append(cutLength(list, 15, 16));
                    // 振込先金融機関名 BANK_NAME VARCHAR
                    sb.append(",''");
                    // 振込先金融機関支店名 BANK_BRANCH_NAME VARCHAR
                    sb.append(",''");
                    // 振込先口座番号 ACCOUNT_NUMBER VARCHAR
                    sb.append(",''");
                    // 振込先口座種類 ACCOUNT_TYPE INTEGER
                    sb.append(",0");
                    // 振込先名義人 ACCOUNT_HOLDER VARCHAR
                    sb.append(",''");
                    // 削除フラグ
                    sb.append(",");
                    sb.append(INTEGER_FORMAT.format(list.get(16)));

                    // 最終更新日 LAST_TIME
                    sb.append(",CURRENT_TIMESTAMP)");
                    error += executeUpdate(dbm, sb.toString());
                } else {
                    throw new Exception("不正なフィールド数");
                }
            } catch (Exception ex) {
                VRLogger.info("不正なCSVレコード 事業所情報(" + (i + 1) + ") = "
                        + list.toString());
                error++;
            }
        }
        return error;
    }

    /**
     * 利用者要介護情報を移行します。
     * 
     * @param dbm DBマネージャ
     * @param f CSVファイル
     * @return エラー総数
     */
    protected int importPatientNinteiHistory(ACDBManager dbm, VRCSVFile f, List providers) {
        setProgressTitle("　利用者要介護情報の移行中..");
        // setProgress("[既存データの削除]");
        int error = 0;
        // error += executeUpdate(dbm, "DELETE FROM PATIENT_NINTEI_HISTORY");

        StringBuffer sb = new StringBuffer();
        sb.append("INSERT INTO PATIENT_NINTEI_HISTORY(");
        sb.append(" PATIENT_ID");
        sb.append(",NINTEI_HISTORY_ID");
        sb.append(",INSURER_ID");
        sb.append(",INSURED_ID");
        sb.append(",INSURE_RATE");
        sb.append(",PLANNER");
        sb.append(",PROVIDER_ID");
        sb.append(",SHUBETSU_CODE");
        sb.append(",CHANGE_CODE");
        sb.append(",JOTAI_CODE");
        sb.append(",SHINSEI_DATE");
        sb.append(",NINTEI_DATE");
        sb.append(",INSURE_VALID_START");
        sb.append(",INSURE_VALID_END");
        sb.append(",STOP_DATE");
        sb.append(",STOP_REASON");
        sb.append(",REPORTED_DATE");
        sb.append(",LIMIT_RATE");
        sb.append(",EXTERNAL_USE_LIMIT");
        sb.append(",LAST_TIME");
        sb.append(")VALUES(");
        String header = sb.toString();
        final Date VALID_BEGIN_DATE = ACDateUtilities.createDate(2006, 4, 1);
        int end = f.getRowCount();
        setProgressTitle("　利用者要介護情報の移行中..[" + end + "件中/");
        for (int i = 0; i < end; i++) {
            List list = f.getRow(i);
            try {
                setProgress(i + "件目] 失敗=" + error + "件");
                if (list.size() > 17) {
                    sb = new StringBuffer(header);

                    // 利用者ID PATIENT_ID
                    sb.append(INTEGER_FORMAT.format(list.get(0)));
                    // 認定履歴番号 NINTEI_HISTORY_ID
                    sb.append(",");
                    sb.append(INTEGER_FORMAT.format(list.get(1)));
                    // 保険者番号 INSURER_ID
                    sb.append(",");
                    sb.append(cutLength(list, 2, 6));
                    // 被保険者番号 INSURED_ID
                    sb.append(",");
                    sb.append(cutLength(list, 3, 10));
                    // 介護保険給付率 INSURE_RATE
                    sb.append(",");
                    sb.append(INTEGER_FORMAT.format(list.get(4)));
                    // 居宅サービス計画作成者 PLANNER
                    if("2".equals(INTEGER_FORMAT.format(list.get(4)))){
                        //被保険者の場合
                        sb.append(",2");
                    }else{
                        //それ以外は紐付け不能
                        sb.append(",0");
                    }
                    // 居宅サービス作成事業所番号 PROVIDER_ID
                    sb.append(",NULL");
                    // 申請種別コード SHUBETSU_CODE
                    sb.append(",");
                    sb.append(INTEGER_FORMAT.format(list.get(7)));
                    // 申請中コード CHANGE_CODE
                    sb.append(",");
                    sb.append(INTEGER_FORMAT.format(list.get(8)));
                    // 要介護状態区分コード JOTAI_CODE
                    Integer jotaiCode = ACCastUtilities.toInteger(list.get(9),
                            0);
                    if (jotaiCode.intValue() <= 0) {
                        // VRLogger.info("不正なCSVレコード[不正な要介護度] 利用者要介護情報(" + (i +
                        // 1)
                        // + ") = " + list.toString());
                        // error++;
                        continue;
                    }
                    sb.append(",");
                    sb.append(INTEGER_FORMAT.format(jotaiCode));
                    // 申請日 SHINSEI_DATE
                    sb.append(",");
                    sb.append(DATE_FORMAT.format(list.get(10)));
                    // 認定日 NINTEI_DATE
                    sb.append(",");
                    sb.append(DATE_FORMAT.format(list.get(11)));
                    // 有効期間開始 INSURE_VALID_START
                    sb.append(",");
                    String validStartText = DATE_FORMAT.format(list.get(12));
                    if ("NULL".equals(validStartText)) {
                        validStartText = "0001-01-01";
                    }
                    sb.append(validStartText);
                    // 有効期間終了 INSURE_VALID_END
                    Date validEnd = ACCastUtilities.toDate(list.get(13), null);
                    String validEndText = DATE_FORMAT.format(validEnd);
                    if ("NULL".equals(validEndText)) {
                        validEndText = "9999-12-31";
                    }
                    sb.append(",");
                    sb.append(validEndText);
                    // 中断年月日 STOP_DATE
                    sb.append(",");
                    sb.append(DATE_FORMAT.format(list.get(14)));
                    // 中断理由 STOP_REASON
                    sb.append(",");
                    sb.append(INTEGER_FORMAT.format(list.get(15)));
                    // 居宅サービス計画作成依頼届出日 REPORTED_DATE
                    sb.append(",");
                    sb.append(DATE_FORMAT.format(list.get(16)));
                    // 支給限度額 LIMIT_RATE
                    sb.append(",");
                    String cost = "0";
                    switch (jotaiCode.intValue()) {
                    case 11:// 11-経過的要介護（要支援）
                        cost = "6150";
                        break;
                    case 12:// 12-要支援１
                        cost = "4970";
                        break;
                    case 13:// 13-要支援２
                        cost = "10400";
                        break;
                    case 21:// 21-要介護1
                        cost = "16580";
                        break;
                    case 22:// 22-要介護２
                        cost = "19480";
                        break;
                    case 23:// 23-要介護３
                        cost = "26750";
                        break;
                    case 24:// 24-要介護4
                        cost = "30600";
                        break;
                    case 25:// 25-要介護5
                        cost = "35830";
                        break;
                    }
                    sb.append(cost);
                    // 外部利用型給付上限単位数 EXTERNAL_USE_LIMIT
                    sb.append(",");
                    cost = "0";
                    if (validEnd != null) {
                        if (ACDateUtilities.compareOnDay(VALID_BEGIN_DATE,
                                validEnd) <= 0) {
                            switch (jotaiCode.intValue()) {
                            case 11:// 11-経過的要介護（要支援）
                                cost = "6505";
                                break;
                            case 12:// 12-要支援１
                                cost = "4970";
                                break;
                            case 13:// 13-要支援２
                                cost = "10400";
                                break;
                            case 21:// 21-要介護1
                                cost = "16689";
                                break;
                            case 22:// 22-要介護２
                                cost = "18726";
                                break;
                            case 23:// 23-要介護３
                                cost = "20763";
                                break;
                            case 24:// 24-要介護4
                                cost = "22800";
                                break;
                            case 25:// 25-要介護5
                                cost = "24867";
                                break;
                            }
                        }
                    }
                    sb.append(cost);

                    // 最終更新日 LAST_TIME
                    sb.append(",CURRENT_TIMESTAMP)");
                    error += executeUpdate(dbm, sb.toString());

                } else {
                    throw new Exception("不正なフィールド数");
                }
            } catch (Exception ex) {
                VRLogger.info("不正なCSVレコード 利用者要介護情報(" + (i + 1) + ") = "
                        + list.toString());
                error++;
            }
        }
        return error;
    }

    protected ACDBManager dbm = null;
    protected File patietFile = null;
    protected File ninteiFile = null;
    protected File staffFile = null;
    protected File insurerFile = null;
    protected File providerFile = null;
    protected File provServiceFile = null;
    protected File kyotakuRyoyoFile = null;
    protected File homonKangoPlanFile = null;
    protected File homonKangoResultFile = null;
    protected int errorCount = 0;

    /**
     * エラー総数を加算します。
     * 
     * @param add 加算数
     */
    public void addErrorCount(int add) {
        errorCount += add;
    }

    /**
     * 保険者情報を移行します。
     * 
     * @param dbm DBマネージャ
     * @param f CSVファイル
     * @return エラー総数
     */
    protected int importInsurer(ACDBManager dbm, VRCSVFile f) {
        setProgressTitle("　保険者情報の移行中..");
        // setProgress("[既存データの削除]");
        int error = 0;
        // error += executeUpdate(dbm, "DELETE FROM INSURER");
        // error += executeUpdate(dbm, "DELETE FROM PATIENT_KOHI");
        // error += executeUpdate(dbm, "DELETE FROM INSURER_LIMIT_RATE");
        // error += executeUpdate(dbm, "DELETE FROM INSURER_LIMIT_RATE_DETAIL");
        StringBuffer sb = new StringBuffer();
        sb.append("INSERT INTO INSURER(");
        sb.append(" INSURER_ID");
        sb.append(",INSURER_NAME");
        sb.append(",INSURER_ZIP_FIRST");
        sb.append(",INSURER_ZIP_SECOND");
        sb.append(",INSURER_ADDRESS");
        sb.append(",INSURER_TEL_FIRST");
        sb.append(",INSURER_TEL_SECOND");
        sb.append(",INSURER_TEL_THIRD");
        sb.append(",DELETE_FLAG");
        sb.append(",LAST_TIME");
        sb.append(")VALUES(");

        String header = sb.toString();
        int end = f.getRowCount();
        setProgressTitle("　保険者情報の移行中..[" + end + "件中/");
        for (int i = 0; i < end; i++) {
            List list = f.getRow(i);
            try {
                setProgress(i + "件目] 失敗=" + error + "件");
                if (list.size() > 8) {
                    sb = new StringBuffer(header);
                    // 保険者番号
                    sb.append(cutLength(list, 0, 6));
                    // 保険者名
                    sb.append(",");
                    sb.append(cutLength(list, 1, 32));
                    // 郵便番号（前）
                    sb.append(",");
                    sb.append(cutLength(list, 2, 3));
                    // 郵便番号（後）
                    sb.append(",");
                    sb.append(cutLength(list, 3, 4));
                    // 所在地
                    sb.append(",");
                    sb.append(cutLength(list, 4, 64));
                    // 電話番号（前）
                    sb.append(",");
                    sb.append(cutLength(list, 5, 6));
                    // 電話番号（中）
                    sb.append(",");
                    sb.append(cutLength(list, 6, 4));
                    // 電話番号（後）
                    sb.append(",");
                    sb.append(cutLength(list, 7, 4));
                    // 削除フラグ
                    sb.append(",");
                    sb.append(INTEGER_FORMAT.format(list.get(8)));

                    // 最終更新日 LAST_TIME
                    sb.append(",CURRENT_TIMESTAMP)");
                    error += executeUpdate(dbm, sb.toString());
                } else {
                    throw new Exception("不正なフィールド数");
                }
            } catch (Exception ex) {
                VRLogger.info("不正なCSVレコード 保険者情報(" + (i + 1) + ") = "
                        + list.toString());
                error++;
            }
        }
        return error;
    }

    /**
     * スタッフ情報を移行します。
     * 
     * @param dbm DBマネージャ
     * @param f CSVファイル
     * @return エラー総数
     */
    protected int importStaff(ACDBManager dbm, VRCSVFile f) {
        setProgressTitle("　担当者情報の移行中..");
        // setProgress("[既存データの削除]");
        int error = 0;
        // error += executeUpdate(dbm, "DELETE FROM STAFF");
        StringBuffer sb = new StringBuffer();
        sb.append("INSERT INTO STAFF(");
        sb.append(" PROVIDER_ID");
        sb.append(",STAFF_ID");
        sb.append(",CARE_MANAGER_NO");
        sb.append(",STAFF_FAMILY_NAME");
        sb.append(",STAFF_FIRST_NAME");
        sb.append(",LAST_TIME");
        sb.append(")VALUES(");
        String header = sb.toString();
        int end = f.getRowCount();
        setProgressTitle("　担当者情報の移行中..[" + end + "件中/");
        for (int i = 0; i < end; i++) {
            List list = f.getRow(i);
            try {
                setProgress(i + "件目] 失敗=" + error + "件");
                if (list.size() > 3) {
                    sb = new StringBuffer(header);
                    // 事業所番号
                    sb.append(cutLength(list, 0, 10));
                    // スタッフID
                    sb.append(",");
                    sb.append(INTEGER_FORMAT.format(list.get(1)));
                    // 介護支援専門員番号
                    sb.append(",''");
                    // 担当者名(姓)
                    sb.append(",");
                    sb.append(cutLength(list, 2, 16));
                    // 担当者名(名)
                    sb.append(",");
                    sb.append(cutLength(list, 3, 16));

                    // 最終更新日 LAST_TIME
                    sb.append(",CURRENT_TIMESTAMP)");
                    error += executeUpdate(dbm, sb.toString());
                } else {
                    throw new Exception("不正なフィールド数");
                }
            } catch (Exception ex) {
                VRLogger.info("不正なCSVレコード 担当者情報(" + (i + 1) + ") = "
                        + list.toString());
                error++;
            }
        }
        return error;
    }

    /**
     * 指定文字数で切り詰めます。
     * 
     * @param src 検証文字
     * @param max 最大文字数
     * @return 切り詰め結果
     */
    protected String cutLength(List list, int index, int max) {
        // ''の文字数を補正
        return cutLength(STRING_FORMAT.format(list.get(index)), max);
    }

    /**
     * 指定文字数で切り詰めます。
     * 
     * @param src 検証文字
     * @param max 最大文字数
     * @return 切り詰め結果
     */
    protected String cutLength(String src, int max) {
        // ''の文字数を補正
        max += 2;
        if (src.length() <= max) {
            return src;
        }
        return src.substring(0, max - 1) + "'";
    }

    private String progressTitle = "";

    protected void setProgressTitle(String progressTitle) {
        this.progressTitle = progressTitle;
    }

    protected String getProgressTitle() {
        return progressTitle;
    }

    protected void setProgress(String progress) {
        getMessage().setText(getProgressTitle() + progress);
    }

    /**
     * 利用者情報を移行します。
     * 
     * @param dbm DBマネージャ
     * @param f CSVファイル
     * @return エラー総数
     */
    protected int importPatient(ACDBManager dbm, VRCSVFile f) {
        setProgressTitle("　利用者情報の移行中..");
        int error = 0;
        StringBuffer sb = new StringBuffer();
        sb.append("INSERT INTO PATIENT(");
        sb.append(" PATIENT_ID");
        sb.append(",PATIENT_CODE");
        sb.append(",PATIENT_FAMILY_NAME");
        sb.append(",PATIENT_FIRST_NAME");
        sb.append(",PATIENT_FAMILY_KANA");
        sb.append(",PATIENT_FIRST_KANA");
        sb.append(",PATIENT_SEX");
        sb.append(",PATIENT_BIRTHDAY");
        sb.append(",PATIENT_TEL_FIRST");
        sb.append(",PATIENT_TEL_SECOND");
        sb.append(",PATIENT_TEL_THIRD");
        sb.append(",PATIENT_ZIP_FIRST");
        sb.append(",PATIENT_ZIP_SECOND");
        sb.append(",PATIENT_ADDRESS");
        sb.append(",SHOW_FLAG");
        sb.append(",BELONG_TYPE");
        sb.append(",AREA_TYPE");
        sb.append(",DELETE_FLAG");
        sb.append(",LAST_TIME");
        sb.append(")VALUES(");
        String header = sb.toString();
        int end = f.getRowCount();
        setProgressTitle("　利用者情報の移行中..[" + end + "件中/");
        for (int i = 0; i < end; i++) {
            List list = f.getRow(i);
            try {
                setProgress(i + "件目] 失敗=" + error + "件");
                if (list.size() > 15) {
                    sb = new StringBuffer(header);
                    // 利用者ID
                    sb.append(INTEGER_FORMAT.format(list.get(0)));
                    // 利用者コード
                    sb.append(",");
                    sb.append(cutLength(list, 1, 16));
                    // 氏名(姓)
                    sb.append(",");
                    sb.append(cutLength(list, 2, 16));
                    // 氏名(名)
                    sb.append(",");
                    sb.append(cutLength(list, 3, 16));
                    // ふりがな(姓)
                    sb.append(",");
                    sb.append(cutLength(list, 4, 16));
                    // ふりがな(名)
                    sb.append(",");
                    sb.append(cutLength(list, 5, 16));
                    // 性別
                    sb.append(",");
                    sb.append(INTEGER_FORMAT.format(list.get(6)));
                    // 生年月日
                    sb.append(",");
                    sb.append(DATE_FORMAT.format(list.get(7)));
                    // 電話番号（前）
                    sb.append(",");
                    sb.append(cutLength(list, 8, 6));
                    // 電話番号（中）
                    sb.append(",");
                    sb.append(cutLength(list, 9, 4));
                    // 電話番号（後）
                    sb.append(",");
                    sb.append(cutLength(list, 10, 4));
                    // 郵便番号（前）
                    sb.append(",");
                    sb.append(cutLength(list, 11, 3));
                    // 郵便番号（後）
                    sb.append(",");
                    sb.append(cutLength(list, 12, 4));
                    // 住所
                    sb.append(",");
                    sb.append(cutLength(list, 13, 64));
                    // 一覧表示フラグ
                    sb.append(",");
                    sb.append(INTEGER_FORMAT.format(list.get(14)));
                    // 所属区分
                    sb.append(",0");
                    // 地区区分
                    sb.append(",0");
                    // 削除フラグ
                    sb.append(",");
                    sb.append(INTEGER_FORMAT.format(list.get(15)));

                    // 最終更新日 LAST_TIME
                    sb.append(",CURRENT_TIMESTAMP)");
                    error += executeUpdate(dbm, sb.toString());
                } else {
                    throw new Exception("不正なフィールド数");
                }
            } catch (Exception ex) {
                VRLogger.info("不正なCSVレコード 利用者(" + (i + 1) + ") = "
                        + list.toString());
                error++;
            }
        }
        return error;
    }

    protected ACSQLSafeStringFormat STRING_FORMAT = new ACSQLSafeStringFormat() {
        public StringBuffer format(Object obj, StringBuffer toAppendTo,
                FieldPosition pos) {
            if (("NULL".equals(obj))) {
                obj = null;
            }
            return super.format(obj, toAppendTo, pos);

        }
    };

    protected ACSQLSafeIntegerFormat INTEGER_FORMAT = new ACSQLSafeIntegerFormat() {
        public StringBuffer format(Object obj, StringBuffer toAppendTo,
                FieldPosition pos) {
            if (("NULL".equals(obj))) {
                obj = null;
            }
            return super.format(obj, toAppendTo, pos);

        }
    };

    protected ACSQLSafeDateFormat DATE_FORMAT = new ACSQLSafeDateFormat(
            "yyyy-MM-dd") {
        public StringBuffer format(Object obj, StringBuffer toAppendTo,
                FieldPosition pos) {
            if (!(obj instanceof Date)) {
                obj = ACCastUtilities.toDate(obj, null);
            } else if (("NULL".equals(obj))) {
                obj = null;
            }
            return super.format(obj, toAppendTo, pos);
        }
    };

    /**
     * 更新SQL文を発行します。
     * 
     * @param dbm DBマネージャ
     * @param sql SQL文
     */
    protected int executeUpdate(ACDBManager dbm, String sql) {
        try {
            dbm.beginTransaction();
            dbm.executeUpdate(sql);
            dbm.commitTransaction();
        } catch (Exception ex) {
            VRLogger.info(ex);
            try {
                dbm.rollbackTransaction();
            } catch (Exception ex2) {
                VRLogger.info(ex2);
            }
            return 1;
        }
        return 0;
    }

    /**
     * This method initializes exit
     * 
     * @return javax.swing.JButton
     */
    private ACButton getExit() {
        if (exit == null) {
            exit = new ACButton();
            exit.setText("終了(X)");
            exit.setMnemonic('X');
            exit.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    if (ACMessageBox.showOkCancel("終了します。よろしいですか？",
                            ACMessageBox.FOCUS_CANCEL) == ACMessageBox.RESULT_OK) {
                        System.exit(0);
                    }
                }
            });
        }
        return exit;
    }

    /**
     * This method initializes contents
     * 
     * @return javax.swing.JPanel
     */
    private ACPanel getContents() {
        if (settings == null) {
            settings = new ACPanel();
            settings.add(getDests(), VRLayout.NORTH);
            settings.add(getSourceDirectorys(), VRLayout.NORTH);
            settings.add(getInfomations(), VRLayout.CLIENT);
        }
        return settings;
    }

    /**
     * This method initializes contents
     * 
     * @return javax.swing.JPanel
     */
    private ACGroupBox getDests() {
        if (dests == null) {
            dests = new ACGroupBox();
            dests.setText("データ移行先");
            dests.add(getDest(), VRLayout.CLIENT);
        }
        return dests;
    }

    /**
     * This method initializes contents
     * 
     * @return javax.swing.JPanel
     */
    private ACLabel getDest() {
        if (dest == null) {
            dest = new ACLabel();
            dest.setText("IP： unknown" + ACConstants.LINE_SEPARATOR
                    + "データベースの場所： unknown");
        }
        return dest;
    }

    private ACGroupBox dests;
    private ACLabel dest;
    private ACGroupBox infomations;
    private ACTextArea infomation;

    /**
     * This method initializes contents
     * 
     * @return javax.swing.JPanel
     */
    private ACGroupBox getInfomations() {
        if (infomations == null) {
            infomations = new ACGroupBox();
            infomations.setText("データ移行に関するご注意");
            infomations.add(getInfomation(), VRLayout.CLIENT);
        }
        return infomations;
    }

    /**
     * This method initializes contents
     * 
     * @return javax.swing.JPanel
     */
    private ACTextArea getInfomation() {
        if (infomation == null) {
            infomation = new ACTextArea();
            infomation.setRows(10);
            infomation.setLineWrap(true);
            infomation.setEditable(false);
            infomation
                    .setText("【データ移行の前に】"
                            + ACConstants.LINE_SEPARATOR
                            + "　◇給管鳥本体を起動している場合、必ず終了させてからデータ移行を行ってください。"
                            + ACConstants.LINE_SEPARATOR
                            + "　◇データ移行先を変更する場合、給管鳥本体を起動してデータベースの設定を変更してください。"
                            + ACConstants.LINE_SEPARATOR
                            + ACConstants.LINE_SEPARATOR
                            + "【移行できないデータについて】"
                            + ACConstants.LINE_SEPARATOR
                            + "　◇保険者番号や被保険者番号のみで要介護度が設定されていない要介護認定履歴は移行されません。"
                            + ACConstants.LINE_SEPARATOR
                            + "　◇事業所番号を登録していない事業所情報は移行されません。"
                            + ACConstants.LINE_SEPARATOR
                            + "　◇事業所の提供サービス情報は移行されません。"
                            + ACConstants.LINE_SEPARATOR
                            + "　◇訪問看護報告書、訪問看護計画書、居宅療養管理指導書のうち、作成日を入力していないデータは移行されません。"
                            + ACConstants.LINE_SEPARATOR
                            + "　◇平成18年4月の法改正で変更された部分については移行されません。"
                            + ACConstants.LINE_SEPARATOR
                            + ACConstants.LINE_SEPARATOR
                            + "【移行に失敗した場合】"
                            + ACConstants.LINE_SEPARATOR
                            + "　◇「データベースへ接続できません。」というエラーが表示された場合は、給管鳥本体を起動し、データを登録できるか確認してください。"

                    );

        }
        return infomation;
    }

    /**
     * This method initializes directory
     * 
     * @return javax.swing.JTextField
     */
    private ACTextField getSourceDirectory() {
        if (sourceDirectory == null) {
            sourceDirectory = new ACTextField();
            sourceDirectory.setColumns(30);
        }
        return sourceDirectory;
    }

    /**
     * This method initializes browse
     * 
     * @return javax.swing.JButton
     */
    private ACButton getSourceBrowse() {
        if (sourceBrowse == null) {
            sourceBrowse = new ACButton();
            sourceBrowse.setText("参照(B)..");
            sourceBrowse.setMnemonic('B');
            sourceBrowse.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    ACFileChooser chooser = new ACFileChooser();
                    File f = chooser.showDirectorySelectDaialog();
                    if (f != null) {
                        getSourceDirectory().setText(f.getAbsolutePath());
                    }
                }
            });
        }
        return sourceBrowse;
    }

    /**
     * This method initializes directorys
     * 
     * @return jp.nichicom.ac.container.ACLabelContainer
     */
    private ACGroupBox getSourceDirectorys() {
        if (sourceDirectorys == null) {
            sourceDirectorys = new ACGroupBox();
            sourceDirectorys.setAutoWrap(false);
            sourceDirectorys.setText("移行元CSVファイルの場所");
            sourceDirectorys.add(getSourceDirectory(), null);
            sourceDirectorys.add(getSourceBrowse(), null);
        }
        return sourceDirectorys;
    }

    /**
     * します。
     * 
     * @param args
     */
    public static void main(String[] args) {
        try {
            ACFrame.setVRLookAndFeel();
            ACFrameEventProcesser processer = new ACDefaultFrameEventProcesser() {
                protected String getExceptionMessage() {
                    return "処理を続行できません。";
                }

                protected String getPropertyXMLPath() {
                    return "properity.xml";
                }

                public Dimension getDefaultWindowSize() {
                    return new Dimension(600, 500);
                }

                public Dimension getMinimumWindowSize() {
                    return new Dimension(600, 460);
                }

                public String getFrameIconPath() {
                    return "jp/or/med/orca/qkan/images/icon/flameicon.gif";
                }
            };
            ACFrame.getInstance().setFrameEventProcesser(processer);
            ACFrame.getInstance().next(
                    new ACAffairInfo(QkanMacCSVImport.class.getName()));
            ACFrame.getInstance().setVisible(true);
        } catch (Exception ex) {
            VRLogger.info(ex);
        }

    }

    /**
     * This method initializes this
     * 
     * @return void
     */
    private void initialize() {
        this.add(getJContentPane(), VRLayout.CLIENT);
        this.setTitle("給付管理／介護報酬請求支援ソフトVer4.5　Macintosh用データ移行ツール");
    }

    /**
     * This method initializes jContentPane
     * 
     * @return javax.swing.JPanel
     */
    private ACPanel getJContentPane() {
        if (contents == null) {
            contents = new ACPanel();
            contents.add(getMessage(), VRLayout.NORTH);
            contents.add(getButtons(), VRLayout.SOUTH);
            contents.add(getContents(), VRLayout.CLIENT);
        }
        return contents;
    }

    /**
     * This method initializes directorys
     * 
     * @return jp.nichicom.ac.component.ACLabel
     */
    private ACLabel getMessage() {
        if (message == null) {
            message = new ACLabel();
            message.setText("　旧verから出力したCSVファイルの保存先を指定し、実行ボタンを押下してください。");
        }
        return message;
    }

    public void initAffair(ACAffairInfo affair) throws Exception {

        String ip = "unknown";
        String path = "unknown";
        boolean hasError = true;
        try {
            if (ACFrame.getInstance().hasProperty("DBConfig/Server")) {
                ip = ACFrame.getInstance().getProperty("DBConfig/Server");
                if (ACFrame.getInstance().hasProperty("DBConfig/Path")) {
                    path = ACFrame.getInstance().getProperty("DBConfig/Path");
                    hasError = false;
                }
            }
        } catch (Exception ex) {

        }
        StringBuffer sb = new StringBuffer();
        sb.append("IP： ");
        sb.append(ip);
        sb.append(ACConstants.LINE_SEPARATOR);
        sb.append("データベースの場所： ");
        sb.append(path);
        if (hasError) {
            sb.append(ACConstants.LINE_SEPARATOR);
            sb.append("※移行先のデータベース設定を取得できません。給管鳥本体を起動し、設定してください。");
            getExecute().setEnabled(false);
            getDest().setForeground(Color.red);
        }
        getDest().setText(sb.toString());
    }

    public boolean canBack(VRMap parameters) throws Exception {
        return false;
    }

    public Component getFirstFocusComponent() {
        return getSourceDirectory();
    }

}
