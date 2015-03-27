/*
 * Project code name "ORCA"
 * 給付管理台帳ソフト QKANCHO（JMA care benefit management software）
 * Copyright(C) 2002 JMA (Japan Medical Association)
 *
 * This program is part of "QKANCHO (JMA care benefit management software)".
 *
 * This program is distributed in the hope that it will be useful
 * for further advancement in medical care, according to JMA Open
 * Source License, but WITHOUT ANY WARRANTY.
 * Everyone is granted permission to use, copy, modify and
 * redistribute this program, but only under the conditions described
 * in the JMA Open Source License. You should have received a copy of
 * this license along with this program. If not, stop using this
 * program and contact JMA, 2-28-16 Honkomagome, Bunkyo-ku, Tokyo,
 * 113-8621, Japan.
 *****************************************************************
 * アプリ: QKANCHO
 * 開発者: 日高　しのぶ
 * 作成日: 2014/12/02  MIS九州株式会社 日高　しのぶ 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 帳票管理 (C)
 * プロセス 居宅療養管理指導書 (006)
 * プログラム 居宅療養管理指導書一覧 (QC006)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qc.qc006;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.text.Format;
import java.util.Date;
import javax.swing.event.ListSelectionEvent;

import jp.nichicom.ac.ACCommon;
//import jp.nichicom.ac.ACCommon;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.sql.ACPassiveKey;
import jp.nichicom.ac.text.ACSQLSafeDateFormat;
import jp.nichicom.ac.util.ACDateUtilities;
import jp.nichicom.ac.util.ACMessageBox;
import jp.nichicom.ac.util.adapter.ACTableModelAdapter;
import jp.nichicom.vr.bind.VRBindPathParser;
//import jp.nichicom.vr.text.VRDateFormat;
import jp.nichicom.vr.text.parsers.VRDateParser;
//import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRLinkedHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.QkanConstants;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.affair.QkanMessageList;
import jp.or.med.orca.qkan.affair.qc.qc005.QC005;
import jp.or.med.orca.qkan.text.QkanPatientListDataTypeFormat;

/**
 * 居宅療養管理指導書一覧(QC006)
 */
public class QC006 extends QC006Event {
    /**
     * コンストラクタです。
     */
    public QC006() {
    }

    public void initAffair(ACAffairInfo affair) throws Exception {
        super.initAffair(affair);
        initAction(affair);
    }

    /**
     * 初期化処理を行ないます。
     * 
     * @param affair
     *            業務情報
     * @throws Exception
     *             処理例外
     */
    protected void initAction(ACAffairInfo affair) throws Exception {
        // 画面の初期表示を行う処理
        // 取得したデータのウィンドウタイトル（WINDOW_TITLE）をウィンドウに設定する。
        // 取得したデータの業務タイトル（AFFAIR_TITLE）を業務ボタンバーに設定する。
        // 渡りデータの取得/前画面「利用者一覧」から渡されたパラメータを退避する。
        // this.patientID = PATIENT_ID(利用者ID)
        // this.targetDate = TARGET_DATE(対象年月)
        VRMap params = affair.getParameters();

        // データが存在しているかをチェック
        if (VRBindPathParser.has("PATIENT_ID", params)
                && VRBindPathParser.has("TARGET_DATE", params)) {

            // int型に型変換し利用者IDを退避
            setPatientID(Integer.parseInt(String.valueOf(VRBindPathParser.get(
                    "PATIENT_ID", params))));
            // Date型に型変換し対象年月を退避
            setTargetDate((Date) VRBindPathParser.get("TARGET_DATE", params));

        }

        setAffairTitle("QC006", getButtons());

        setPASSIVE_CHECK_KEY(new ACPassiveKey("KYOTAKU_RYOYO", new String[] {
                "PATIENT_ID", "TARGET_DATE" }, new Format[] { null,
                new ACSQLSafeDateFormat("yyyy/M/d") }, "LAST_TIME", "LAST_TIME"));

        // テーブルモデルを下記の画面のテーブルに設定する。
        // ・保険者情報テーブル（insurerInfoTable) テーブルモデル：insurerTableModel
        ACTableModelAdapter kyotakuTableModel = new ACTableModelAdapter();

        // テーブルモデルを定義
        kyotakuTableModel
                .setColumns(new String[] { "PATIENT_ID", "TARGET_DATE",
                        "MEDICAL_FACILITY_NAME", "DOCTOR_NAME",
                        "CREATE_DATE_KYOTAKU", "SENMONIN", "PROVIDER_NAME",
                        "CONDITION", "FINISH_FLAG" });

        // 定義したテーブルモデルを格納
        setKyotakuTableModel(kyotakuTableModel);

        // テーブルモデルをテーブルにセット
        getKyotakuTable().setModel(getKyotakuTableModel());

        // 画面初期表示
        // ・対象年月を表示する
        getTargetDateLabel().setText(
                VRDateParser.format(getTargetDate(), "ggge年M月"));

        // ・利用者名、利用者コードを表示する
        // 　利用者ID(patientID) を元に、利用者の基本情報を取得する。
        VRMap patient = (VRLinkedHashMap) QkanCommon.getPatientInfo(
                getDBManager(), getPatientID()).get(0);
        if (patient.isEmpty()) {
            // 利用者情報が存在しない場合
            // 戻る
            ACFrame.getInstance().back();
            return;
        }
        getPatientName().setText(
                QkanCommon.toFullName(
                        VRBindPathParser.get("PATIENT_FAMILY_NAME", patient),
                        VRBindPathParser.get("PATIENT_FIRST_NAME", patient)));
        getPatientNo().setText(
                ACCastUtilities.toString(VRBindPathParser.get("PATIENT_CODE",
                        patient)));

        // 印刷「1:済」か「0:空白」で表示する
        getKyotakuTableColumn2().setFormat(
				new QkanPatientListDataTypeFormat("QC006"));

        // DBよりレコードを取得し、画面に展開する。
        doFind();

        // もしparamsがnullの場合処理を終了する
        if (params == null) {
            return;
        }

        // providerListのレコードが1件以上の場合
        if (getKyotakuList().size() > 0) {
        	
        	// 利用者IDと対象年月日を選択状態にする
        	int index = ACCommon.getInstance().getMatchIndexFromValue(
        			getKyotakuList(), "TARGET_DATE",
					getTargetDate());
        	
        	if (index == -1) {
	            // レコードの1行目を選択状態にする。
	            getKyotakuTable().setSelectedSortedFirstRow();
        	} else {
        		// 該当する利用者がいた場合、該当利用者を選択する。
        		getKyotakuTable().setSelectedModelRow(index);
                // 選択利用者にスクロールする
                getKyotakuTable().scrollSelectedToVisible();
        	}
        }
        
        // 業務ボタンの状態を変更する
        setState();

        params.clear();
    }

    public boolean canBack(VRMap parameters) throws Exception {
        if (!super.canBack(parameters)) {
            return false;
        }
        // 前画面に遷移する処理
        // 業務基盤に記憶されている前画面に遷移する。

        // TODO 前画面への遷移を許可するならばtrueを返す。
        return true;
    }

    // コンポーネントイベント

    /**
     * 「居宅療養管理指導書画面に遷移（更新）」イベントです。
     * 
     * @param e
     *            イベント情報
     * @throws Exception
     *             処理例外
     */
    protected void detailActionPerformed(ActionEvent e) throws Exception {
        // 居宅療養管理指導書画面に更新モードで遷移する処理
        
        // 画面の「居宅療養管理指導書一覧」の行が選択されているかどうかチェックする。
        VRMap param = new VRHashMap();

        if (getKyotakuTable().isSelected()) {
            // 選択されている場合
            // 選択されている利用者の「利用者IDと対象年月日」を取得する。
            param = (VRMap) getKyotakuTable().getSelectedModelRowValue();
            param.setData("PROCESS_MODE", new Integer(
                    QkanConstants.PROCESS_MODE_UPDATE));
        } else {
            // 選択されていない場合
            // 処理を中断する。
            return;

        }

        // ※遷移処理
        ACAffairInfo affair = null;
        affair = new ACAffairInfo(QC005.class.getName(), param);
        // 次画面に遷移する。
        ACFrame.getInstance().next(affair);

    }

    /**
     * 「居宅療養管理指導書画面に遷移（新規）」イベントです。
     * 
     * @param e
     *            イベント情報
     * @throws Exception
     *             処理例外
     */
    protected void insertActionPerformed(ActionEvent e) throws Exception {
        // 居宅療養管理指導書画面に新規登録モードで遷移する処理
        // VRMap：paramを生成し下記のパラメーターを格納する。
        // ｢QC005（居宅療養管理指導書）｣に遷移する。

        // 渡しパラメーターを作成する。
        VRMap param = new VRHashMap();
        param.setData("PATIENT_ID", getPatientID());
        
        // 登録されていない日付を取得する。
        int maxDay = ACDateUtilities.getDayOfMonth(ACDateUtilities.toLastDayOfMonth(getTargetDate()));
        int targetDay = 1;
        int cnt = 0;
        
        // 対象年月日の最大＋１を取得する
    	for (int j = 0; j < getKyotakuList().size(); j++) {
            int listDay = ACDateUtilities.getDayOfMonth(
                    ACCastUtilities.toDate(VRBindPathParser.get("TARGET_DATE", (VRMap) getKyotakuList().getData(j))));
            if (listDay > targetDay) {
            	targetDay = listDay;
            }
        }
    	targetDay = targetDay + 1;
    	
    	// 月末を超えたら途中の登録されていない日を探す
    	if (targetDay > maxDay) {
	    	targetDay = 1;
	    	cnt = 0;
	        for (cnt = 1; cnt <= maxDay; cnt++) {
	        	boolean findFlg = false;
	        	for (int j = 0; j < getKyotakuList().size(); j++) {
	                int listDay = ACDateUtilities.getDayOfMonth(
	                        ACCastUtilities.toDate(VRBindPathParser.get("TARGET_DATE", (VRMap) getKyotakuList().getData(j))));
	                if (listDay == cnt) {
	                	findFlg = true;
	                    break;
	                }
	            }
	        	if (!findFlg) {
	        		break;
	        	}
	        }
	        targetDay = cnt;
    	}
        
        // 対象月の日数分を最大登録可能件数とするため、それ以上は新規登録できない。
        if (targetDay > maxDay) {
            return;
        }
        
        Date addDate = ACDateUtilities.createDate(
                ACDateUtilities.getYear(getTargetDate()), ACDateUtilities.getMonth(getTargetDate()), targetDay);
        param.setData("TARGET_DATE", addDate);
        param.setData("PROCESS_MODE", new Integer(
                QkanConstants.PROCESS_MODE_INSERT));

        // ※遷移処理
        ACAffairInfo affair = null;
        affair = new ACAffairInfo(QC005.class.getName(), param);
        // 次画面に遷移する。
        ACFrame.getInstance().next(affair);

    }

    /**
     * 「削除処理」イベントです。
     * 
     * @param e
     *            イベント情報
     * @throws Exception
     *             処理例外
     */
    protected void deleteActionPerformed(ActionEvent e) throws Exception {

        // 画面の｢居宅療養管理指導書一覧｣の行が選択されているかチェックする。
        if (getKyotakuTable().isSelected()) {
            // 選択されている場合

            // 削除確認メッセージを表示する。※メッセージID = WARNING_OF_DELETE
            int msgID = QkanMessageList.getInstance().WARNING_OF_DELETE(
                    "選択中の居宅療養管理指導書情報");

            // ｢はい｣押下時
            if (msgID == ACMessageBox.RESULT_YES) {

                // 現在の選択行を退避する
                int sel = getKyotakuTable().getSelectedModelRow();

                // 削除処理を行う。
                if (!doDelete()) {
                    // 何らかのエラーが発生した場合処理を中断する
                    return;
                }

                // 削除後の理想となる行番号を設定する
                getKyotakuTable().setSelectedSortedRowOnAfterDelete(sel);

            }

            // ｢いいえ｣押下時
            // 処理を抜ける。（処理を行わない）
            return;

        }

    }

    /**
     * 「画面制御」イベントです。
     * 
     * @param e
     *            イベント情報
     * @throws Exception
     *             処理例外
     */
    protected void kyotakuTableSelectionChanged(ListSelectionEvent e)
            throws Exception {

        // 業務ボタンの状態を変更する
        setState();

    }

    /**
     * 「画面遷移処理」イベントです。
     * 
     * @param e
     *            イベント情報
     * @throws Exception
     *             処理例外
     */
    protected void kyotakuTableMouseClicked(MouseEvent e) throws Exception {
        // ※選択された居宅療養管理指導書の情報で、次画面に遷移
        // 　画面の「居宅療養管理指導書一覧」の行が選択されているかどうかチェックする。
        VRMap param = new VRHashMap();

        if (getKyotakuTable().isSelected()) {
            // 選択されている場合
            // 選択されている利用者の「利用者IDと対象年月日」を取得する。
            param = (VRMap) getKyotakuTable().getSelectedModelRowValue();
            param.setData("PROCESS_MODE", new Integer(
                    QkanConstants.PROCESS_MODE_UPDATE));
        } else {
            // 選択されていない場合
            // 処理を中断する。
            return;

        }

        // ※遷移処理
        ACAffairInfo affair = null;
        affair = new ACAffairInfo(QC005.class.getName(), param);
        // 次画面に遷移する。
        ACFrame.getInstance().next(affair);

    }

    public static void main(String[] args) {
        // デフォルトデバッグ起動
        ACFrame.getInstance().setFrameEventProcesser(
                new QkanFrameEventProcesser());
        QkanCommon.debugInitialize();
        VRMap param = new VRHashMap();
        // paramに渡りパラメタを詰めて実行することで、簡易デバッグが可能です。
        ACFrame.debugStart(new ACAffairInfo(QC006.class.getName(), param));
    }

    // 内部関数

    /**
     * 「レコードを取得し画面に設定する。」に関する処理を行ないます。
     * 
     * @throws Exception
     *             処理例外
     */
    public void doFind() throws Exception {
        // 画面展開用の情報を取得する処理
        // 居宅療養管理指導書情報TABLEに存在する、指定利用者の指定年月から情報を取得する。
        doFindKyotaku();

        if (!getKyotakuList().isEmpty()) {
            // 取得した全保険者情報（insurerInfoList）をinsurerTableModelに設定する。
            getKyotakuTableModel().setAdaptee(getKyotakuList());
            
        } else {
            // 情報が取得できなかった場合
            getKyotakuList().clearData();
            getKyotakuTableModel().setAdaptee(getKyotakuList());
        }
        
        // 業務ボタンの状態を変更する
        setState();

        // スナップショットを撮影する。
        getSnapshot().snapshot();

    }

    /**
     * 「居宅療養管理指導書情報取得」に関する処理を行ないます。
     * 
     * @throws Exception
     *             処理例外
     */
    public void doFindKyotaku() throws Exception {
        // 居宅療養管理指導履歴情報取得を行う。

        // 取得のためにHashMap：paramを生成し、以下のKEY/VALUEを設定する。
        VRMap sqlParam = new VRHashMap();

        // KEY：PATIENT_ID　VALUE：patientId
        VRBindPathParser.set("PATIENT_ID", sqlParam,
                new Integer(getPatientID()));
        // KEY：TARGET_DATE_START VALUE：targetDate の月初
        sqlParam.setData("TARGET_DATE_START",
                ACDateUtilities.toFirstDayOfMonth(getTargetDate()));
        // KEY：TARGET_DATE_START VALUE：targetDate の月末
        sqlParam.setData("TARGET_DATE_END",
                ACDateUtilities.toLastDayOfMonth(getTargetDate()));

        // 居宅療養管理指導履歴情報を取得し、kyotakuTableListに格納する。
        String strSql = getSQL_GET_KYOTAKU_RYOYO(sqlParam);
        VRList kh = getDBManager().executeQuery(strSql);
        if (kh.size() > 0) {
            getKyotakuList().clearData();
            setKyotakuList(kh);

            // 居宅療養管理指導履歴情報TABLEパッシブチェック用にデータを登録する。
            getPassiveChecker().reservedPassive(getPASSIVE_CHECK_KEY(),
                    getKyotakuList());

        } else {
            getKyotakuList().clearData();
            setKyotakuList(kh);
        }

    }

    /**
     * 「選択居宅療養管理指導書削除処理」に関する処理を行ないます。
     * 
     * @throws Exception
     *             処理例外
     */
    public boolean doDelete() throws Exception {
        // 居宅療養管理指導書情報を削除する処理

        // 選択されているレコードのモデルのインデックスを格納するmodelRowを定義する。
        int modelRow;
        modelRow = getKyotakuTable().getSelectedModelRow();

        try {

            // トランザクションを開始する。
            getDBManager().beginTransaction();
            // パッシブタスクをクリアする。
            getPassiveChecker().clearPassiveTask();
            // パッシブタスクを追加する。（居宅療養管理指導書情報削除用）
            getPassiveChecker().addPassiveUpdateTask(getPASSIVE_CHECK_KEY(),
                    modelRow);

            // パッシブチェックを実行する。
            if (!getPassiveChecker().passiveCheck(getDBManager())) {
                // テーブルロック解除のためロールバック
                getDBManager().rollbackTransaction();
                // パッシブエラーがある場合
                // エラーメッセージを表示する。
                QkanMessageList.getInstance()
                        .ERROR_OF_PASSIVE_CHECK_ON_UPDATE();
                // 処理を抜ける。（処理を中断する）
                return false;
            }

            // パッシブエラーがない場合
            // 居宅療養管理指導書情報削除用のSQL文を取得する。
            // SQL文取得のためVRMap：paramを作成し、下記のパラメーターを設定する。
            VRMap param = new VRHashMap();
            // KEY：PATIENT_ID VALUE：patientId
            // KEY：TARGET_DATE VALUE：targetDate
            param = (VRMap) getKyotakuTable().getSelectedModelRowValue();

            // 居宅療養管理指導書情報削除用のSQL文を取得する
            // 取得したSQL文を実行する。
            getDBManager().executeUpdate(getSQL_DELETE_KYOTAKU_RYOYO(param));
            // 処理したSQL文の実行中に1つもエラーが発生しなかった場合
            // コミットする。
            getDBManager().commitTransaction();
            // 居宅療養管理指導書情報を取得しパッシブチェック用に退避する。
            doFind();
            // 正常終了
            return true;
        } catch (Exception sqlEx) {
            // 処理したSQL文の実行中に1つでもエラーが発生した場合
            // 処理をロールバックする。
            getDBManager().rollbackTransaction();
            // 処理を抜ける。（処理を中断する）
            throw sqlEx;
        }
    }
    
    /**
     * 「業務ボタンの状態」を設定する処理を行ないます。
     * 
     * @throws Exception
     *             処理例外
     */
    public void setState() throws Exception {
        
        // 最大登録数は対象年月の日数とする
        int maxDay = ACDateUtilities.getDayOfMonth(ACDateUtilities.toLastDayOfMonth(getTargetDate()));
        
        // ※画面の制御
        if (getKyotakuList().size() > 0) {
            
            if (getKyotakuList().size() < maxDay) {

                if (getKyotakuTable().isSelected()) {
                    // 新規・更新
                    setState_SELECTED();

                } else {
                    // 新規のみ
                    setState_NEWSELECTED();
                }
                
            } else {
            	
            	if (getKyotakuTable().isSelected()) {
	                // 更新のみ（新規なし）
	                setState_NEWUNSELECTED();
	                
            	} else {
                    // 選択なし
            		setState_UNSELECTED();
                }
            }
            
        } else {
            // 新規のみ
            setState_NEWSELECTED();
        }
    }

}
