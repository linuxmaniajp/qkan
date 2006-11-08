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
 * 開発者: 田中　統蔵
 * 作成日: 2006/08/12  日本コンピューター株式会社 田中　統蔵 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 請求データ作成 (P)
 * プロセス 利用者一覧(訪問看護療養費領収書) (010)
 * プログラム 利用者一覧(訪問看護療養費領収書) (QP010)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qp.qp010;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.util.Date;
import java.util.Map;

import javax.swing.event.ListSelectionEvent;

import jp.nichicom.ac.bind.ACBindUtilities;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.ac.util.ACDateUtilities;
import jp.nichicom.ac.util.adapter.ACTableModelAdapter;
import jp.nichicom.ac.util.splash.ACSplashable;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.QkanConstants;
import jp.or.med.orca.qkan.QkanSystemInformation;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.affair.QkanMessageList;
import jp.or.med.orca.qkan.affair.qp.qp011.QP011;
import jp.or.med.orca.qkan.text.QkanInsurerIDToInsurerNameFormat;

/**
 * 利用者一覧(訪問看護療養費領収書)(QP010)
 */
public class QP010 extends QP010Event {
    /**
     * コンストラクタです。
     */
    public QP010() {
    }

    public void initAffair(ACAffairInfo affair) throws Exception {
        super.initAffair(affair);
        initAction(affair);
    }

    /**
     * 初期化処理を行ないます。
     * 
     * @param affair 業務情報
     * @throws Exception 処理例外
     */
    protected void initAction(ACAffairInfo affair) throws Exception {
        // 初期化を行う。
        // ※ウィンドウタイトル・業務ボタンバーの設定
        // 業務のウィンドウタイトル・ボタンバーにタイトルを設定する。
        setAffairTitle("QP010", getButtons());

        // ※ログイン事業所名を取得し、画面上の注釈にはめ込む。
        VRList loginProviderInfo = QkanCommon.getProviderInfo(getDBManager(),
                QkanSystemInformation.getInstance().getLoginProviderID());
        if ((loginProviderInfo == null) || (loginProviderInfo.isEmpty())) {
            QkanMessageList.getInstance().QP001_ERROR_OF_NO_LOGIN_PROVIDER();
            ACFrame.getInstance().back();
            return;
        } else {
            Map map = (Map) loginProviderInfo.getData();
            getLoginProviderInfo()
                    .setText(
                            "「"
                                    + map.get("PROVIDER_NAME")
                                    + "」に関する領収書作成処理を行ないます。他の事業所を対象とする場合は、ログアウトを行い事業所を選択しなおしてください。");
        }

        // ※テーブルモデルを定義する。
        ACTableModelAdapter model = new ACTableModelAdapter();

        model.setColumns(new String[] { "INSURER_ID", "INSURER_NAME",
                "PATIENT_CODE", "MEDICAL_INSURE_ID",
                "PATIENT_FAMILY_NAME+'　'+PATIENT_FIRST_NAME",
                "PATIENT_FAMILY_KANA+'　'+PATIENT_FIRST_KANA", "PATIENT_SEX",
                "PATIENT_BIRTHDAY", "JOTAI_CODE", "INSURE_TYPE", });

        setPatientTableModel(model);

        // アダプタをテーブルのモデルとして設定する。
        getPatients().setModel(getPatientTableModel());

        // ※医療系の保険者一覧を取得
        setInsurers(QkanCommon.getInsurerInfoMedicalOnly(getDBManager()));
        getInsurerName().setModel(getInsurers());

        // 保険者名カラムに保険者名フォーマットを設定
        getPatientInsurerNameColumn().setFormat(
                new QkanInsurerIDToInsurerNameFormat(getInsurers()));

        // ※「実績有無判別」にチェックをつける。
        getOnlyExistsResult().setSelected(true);

        // ※対象年月の設定
        Date targetDate = ACCastUtilities.toDate(VRBindPathParser.get(
                "TARGET_DATE", affair.getParameters()), null);
        if (targetDate != null) {
            // 遷移パラメタとして対象年月が渡されている場合
            // 画面の「対象年月(targetDate)」に、targetDateの値を設定する。
            getFindCondition().setSource(affair.getParameters());
            getFindCondition().bindSource();
            // getTargetDate().setDate(targetDate);
        } else {
            // 遷移パラメタとして対象年月が渡されていない場合
            // システムから、「システム日付」を取得する。
            // 画面の「対象年月(targetDate)」に、取得したシステム日付を設定する。
            getTargetDate().setDate(
                    QkanSystemInformation.getInstance().getSystemDate());
        }

        // ※再現情報の展開
        // 遷移パラメタにキー「REPRODUCTION_PARAM」が含まれ、かつその値がレコードの場合
        Object reproductionParam = VRBindPathParser.get("REPRODUCTION_PARAM",
                affair.getParameters());
        if (reproductionParam instanceof VRMap) {
            // 遷移パラメタのキー「REPRODUCTION_PARAM」の値を検索条件(findCondition)に割り当て・展開する。
            getFindCondition().setSource((VRMap) reproductionParam);
            getFindCondition().bindSource();
            // 遷移パラメタからキー「REPRODUCTION_PARAM」を削除する。
            affair.getParameters().remove("REPRODUCTION_PARAM");
        }

        // 検索を行う。
        doFind();

        //遷移パラメタとして利用者IDが渡されている場合
        //利用者IDに該当する利用者を選択する。
        int backID=ACBindUtilities.getMatchIndexFromValue(getPatientData(), "PATIENT_ID",VRBindPathParser.get(
                "PATIENT_ID", affair.getParameters()));
        if(backID>=0){
            getPatients().setSelectedModelRow(backID);
            getPatients().scrollSelectedToVisible();
        }
        
    }

    // コンポーネントイベント

    /**
     * 「検索」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void findActionPerformed(ActionEvent e) throws Exception {
        // 検索を行う。
        doFind();

    }

    /**
     * 「詳細画面に遷移」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void detailActionPerformed(ActionEvent e) throws Exception {
        // ※選択された利用者の情報で、次画面に遷移
        // 次画面に遷移する。
        doNext();

    }

    /**
     * 「画面制御」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void patientsSelectionChanged(ListSelectionEvent e)
            throws Exception {
        // ※画面の制御
        if (!getPatients().isSelected()) {
            // 一覧が選択されていない場合
            // 業務ボタンの状態をINVALID_DETAILに変更する。
            setState_INVALID_DETAIL();
        } else {
            // 一覧が選択されている場合
            // 業務ボタンの状態をVALID_DETAILに変更する。
            setState_VALID_DETAIL();
        }
    }

    /**
     * 「画面遷移処理」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void patientsMouseClicked(MouseEvent e) throws Exception {
        // ※選択された利用者の情報で、次画面に遷移
        // 次画面に遷移する。
        doNext();

    }

    public static void main(String[] args) {
        // デフォルトデバッグ起動
        ACFrame.getInstance().setFrameEventProcesser(
                new QkanFrameEventProcesser());
        QkanCommon.debugInitialize();
        QkanSystemInformation.getInstance().setLoginProviderID("2000000000");
        VRMap param = new VRHashMap();
        // paramに渡りパラメタを詰めて実行することで、簡易デバッグが可能です。
        ACFrame.debugStart(new ACAffairInfo(QP010.class.getName(), param));
    }

    // 内部関数

    /**
     * 「検索」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public void doFind() throws Exception {

        // ※入力チェック
        // 画面の「対象年月(targetDate)」に値が入力されているかどうかチェックする。
        if (ACTextUtilities.isNullText(getTargetDate().getText())) {
            // 入力されていない場合
            // メッセージを表示する。※メッセージID = ERROR_OF_NEED_CHECK_FOR_INPUT
            QkanMessageList.getInstance()
                    .ERROR_OF_NEED_CHECK_FOR_INPUT("対象年月");
            //対象年月(targetDate)にフォーカスをあてる。
            getTargetDate().requestFocus();
            // 処理を中断する。
            return;
        }
        // 画面の「対象年月(targetDate)」に有効な値が入力されているかどうかチェックする。
        if (!getTargetDate().isValidDate()) {
            // 有効な値が入力されていない場合
            // メッセージを表示する。※メッセージID = ERROR_OF_WRONG_DATE
            QkanMessageList.getInstance().ERROR_OF_WRONG_DATE("対象年月の");
            //対象年月(targetDate)にフォーカスをあてる。
            getTargetDate().requestFocus();
            // 処理を中断する。
            return;
        }
        
        //スプラッシュを表示する。
        ACSplashable splash = ACFrame.getInstance().getFrameEventProcesser()
                .createSplash("検索結果");

        // ※DBから利用者一覧を取得、画面に設定
        // ※検索準備
        // SQL文取得関数に渡すレコード sqlParamを生成する。
        VRMap sqlParam = new VRHashMap();

        // 対象年月をsqlParamの KEY : TARGET_DATE の VALUE として設定する。
        VRBindPathParser
                .set("TARGET_DATE", sqlParam, getTargetDate().getDate());
        VRBindPathParser.set("TARGET_DATE_START_DAY", sqlParam, ACDateUtilities
                .toFirstDayOfMonth(getTargetDate().getDate()));
        VRBindPathParser.set("TARGET_DATE_END_DAY", sqlParam, ACDateUtilities
                .toLastDayOfMonth(getTargetDate().getDate()));
        VRBindPathParser.set("LOGIN_PROVIDER_ID", sqlParam,
                QkanSystemInformation.getInstance().getLoginProviderID());

        // ※利用者コードの取得
        // 画面の「利用者コード(patientCode)」のTextを取得し、検索用に編集する。
        if (!ACTextUtilities.isNullText(getPatientCode())) {
            // 取得した文字列が存在する場合(文字列長が0より大きい場合)
            // 取得した文字列をsqlParamの KEY : PATIENT_CODE の VALUE として設定する。
            VRBindPathParser.set("PATIENT_CODE", sqlParam, getPatientCode()
                    .getText());
        }
        // ※ふりがなの取得
        // 画面の「ふりがな(patientKana)」のTextを取得し、検索用に編集する。
        if (!ACTextUtilities.isNullText(getPatientKana())) {
            // 取得した文字列が存在する場合(文字列長が0より大きい場合)
            // 取得した文字列をsqlParamの KEY : PATIENT_KANA の VALUE として設定する。
            VRBindPathParser.set("PATIENT_KANA", sqlParam, getPatientKana()
                    .getText());
        }

        // ※「実績のある利用者だけを表示」フラグの取得
        // 画面の「実績のある利用者だけを表示(onlyExistsResult)」の選択状態を取得する。
        if (getOnlyExistsResult().isSelected()) {
            // 選択されている場合
            // sqlParamに KEY : ONLY_EXISTS_RESULT, VALUE : null を設定する。
            VRBindPathParser.set("ONLY_EXISTS_RESULT", sqlParam, null);
        }
        // 未選択の場合
        // 何もしない(sqlParamには何も設定しない)。

        // ※DBからデータを取得
        // 検索用のSQL文を発行し、結果をpatientDataに格納する。
        setPatientData( getDBManager().executeQuery(
                getSQL_SELECT_PATIENT(sqlParam)));

        if (!ACTextUtilities.isNullText(getInsurerID())) {
            // 保険者番号で絞り込む場合
            String val = getInsurerID().getText();
            for (int i = getPatientData().size() - 1; i >= 0; i--) {
                // 保険者番号が後方一致しない検索結果は除外する。
                if (!ACCastUtilities.toString(
                        VRBindPathParser.get("INSURER_ID",
                                (VRMap) getPatientData().get(i))).endsWith(val)) {
                    getPatientData().remove(i);
                }
            }
        }
        if (!ACTextUtilities.isNullText(getPatientInsuredID())) {
            // 記号・番号で絞り込む場合
            String val = getPatientInsuredID().getText();
            for (int i = getPatientData().size() - 1; i >= 0; i--) {
                // 記号・番号が一致しない検索結果は除外する。
                if (!val.equals(ACCastUtilities.toString(VRBindPathParser.get(
                        "MEDICAL_INSURE_ID", (VRMap) getPatientData().get(i))))) {
                    getPatientData().remove(i);
                }
            }
        }

        // ※再現情報の退避
        // 抽出条件領域(findCondition)に検索設定(findedParam)を割り当て・収集する。
        getFindCondition().setSource(getFindedParam());
        getFindCondition().applySource();

        // 検索時の対象年月を退避する。
        setFindTargetDate(getTargetDate().getDate());
        
        // ※取得したデータを画面に展開
        getPatientTableModel().setAdaptee(getPatientData());

        // 画面の「利用者一覧(patients)」の1行目を選択する。
        getPatients().setSelectedSortedFirstRow();

        // patientDataの件数をチェックする。
        if (getPatientData().isEmpty()) {
            // patientDataの件数が0件の場合
            // 業務ボタンの状態をINVALID_DETAILに変更する。
            setState_INVALID_DETAIL();
        }

        //ステータスバーに抽出件数を表示する。※「件数」+" 件抽出されました。"
        setStatusText(getPatientData().size() + " 件抽出されました。");

        //スプラッシュを消す。
        if(splash!=null){
            splash.close();
            splash = null;
            ACFrame.getInstance().repaint();
        }
    }

    /**
     * 「画面遷移処理」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public void doNext() throws Exception {
        // ※選択された利用者の情報で、次画面に遷移
        // ※入力チェック
        // 画面の「利用者一覧(patients)」の行が選択されているかどうかチェックする。
        if (!getPatients().isSelected()) {
            // 選択されていない場合
            // 処理を中断する。
            return;
        }

        // ※再現情報の退避
        // 当業務への遷移パラメタにキー「REPRODUCTION_PARAM」で検索設定(findedParam)を追加する。
        ACFrame.getInstance().addNowAffairParameter("REPRODUCTION_PARAM", getFindedParam());
        
        
        // ※遷移パラメタの設定
        // 次画面遷移のためのパラメタ ACAffairInfo affair を定義する。
        // 次画面への遷移パラメタ格納用にレコード paramを生成する。
        VRMap param = new VRHashMap();
        // paramに選択した利用者の情報を追加する。
        param.putAll((VRMap) getPatients().getSelectedModelRowValue());
        // paramに下記パラメータを設定する。
        // KEY : TARGET_DATE, VALUE : (検索時点の請求年月)
        VRBindPathParser.set("TARGET_DATE", param, getFindTargetDate());
        // 下記パラメータにてaffairを生成する。
        // className : QP011.class.getName(), parameters : param
        // ※遷移パラメタを使用して次画面に遷移
        ACFrame.getInstance().next(
                new ACAffairInfo(QP011.class.getName(), param));
    }

    /**
     * 「保険者番号と保険者名の連動」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void insurerNameActionPerformed(ActionEvent e) throws Exception {
        // 選択した保険者の保険者番号を保険者番号テキストに設定する。
        if (getInsurerName().getSelectedModelItem() instanceof VRMap) {
            Object val = VRBindPathParser.get("INSURER_ID",
                    (VRMap) getInsurerName().getSelectedModelItem());
            if (val != null) {
                getInsurerID().setText(ACCastUtilities.toString(val));
            }
        } else {
            getInsurerID().setText("");
        }
    }

}
