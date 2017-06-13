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
 * 開発者: 上司　和善
 * 作成日: 2006/02/16  日本コンピューター株式会社 上司　和善 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 請求データ作成 (P)
 * プロセス 確認・修正 (003)
 * プログラム 利用者向け請求詳細編集 (QP003)
 *
 *****************************************************************
 */

package jp.or.med.orca.qkan.affair.qp.qp003;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.text.Format;
import java.util.Date;

import javax.swing.event.ChangeEvent;

import jp.nichicom.ac.component.ACComboBox;
import jp.nichicom.ac.component.ACTextField;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.sql.ACPassiveKey;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.ac.util.ACDateUtilities;
import jp.nichicom.ac.util.ACMessageBox;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.QkanConstants;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.affair.QkanMessageList;

/**
 * 利用者向け請求詳細編集(QP003)
 */
public class QP003 extends QP003Event {
    /**
     * コンストラクタです。
     */
    public QP003() {
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
        // 下記の渡りパラメータを退避する。
        VRMap params = affair.getParameters();
        // ・patientId KEY：PATIENT_ID
        if (VRBindPathParser.has("PATIENT_ID", params)) {
            setPatientId(ACCastUtilities.toInt(params.getData("PATIENT_ID")));
        }
        // ・targetDate KEY：TARGET_DATE
        if (VRBindPathParser.has("TARGET_DATE", params)) {
            setTargetDate(ACCastUtilities.toDate(params.getData("TARGET_DATE")));
        }
        // ・claimDate KEY：CLAIM_DATE
        if (VRBindPathParser.has("CLAIM_DATE", params)) {
            setClaimDate(ACCastUtilities.toDate(params.getData("CLAIM_DATE")));
        }
        // ・listIndex KEY：LIST_INDEX
        if (VRBindPathParser.has("LIST_INDEX", params)) {
            setListIndex(ACCastUtilities.toInt(params.getData("LIST_INDEX")));
        }
        // ・providerId KEY：PROVIDER_ID
        if (VRBindPathParser.has("PROVIDER_ID", params)) {
            setProviderId(ACCastUtilities.toString(params
                    .getData("PROVIDER_ID")));
        }
        // ・insurerId KEY：INSURER_ID
        if (VRBindPathParser.has("INSURER_ID", params)) {
            setInsurerId(ACCastUtilities.toString(params.getData("INSURER_ID")));
        }
        // ・insuredId KEY：INSURED_ID
        if (VRBindPathParser.has("INSURED_ID", params)) {
            setInsuredId(ACCastUtilities.toString(params.getData("INSURED_ID")));
        }

        setPASSIVE_CHECK_KEY(new ACPassiveKey("CLAIM_PATIENT_DETAIL",
                new String[] { "CLAIM_ID" }, new Format[] { null },
                "LAST_TIME", "LAST_TIME"));

        // コンボ候補の設定
        comboInitialize();

        // [V5.3.4対応 利用者向け領収書] kamitsukasa.kazuyoshi add start
        if(ACDateUtilities.compareOnDay(DATE_20070401, getClaimDate()) > 0){
        	// 平成19年4月1日より過去の日付の場合
        	// 内税ラベル、テキストを非表示に設定する。
        	setState_INVISIBLE_INNER_TAX();
        	getContentEtcUseTitle().setText("利用料");
        }else{
        	// 請求年月(claimDate)が「平成19年4月」以降の場合	
        	// うち消費税テキストに初期値：0を表示する。
        	getContentInnerTaxText().setText("0");
        }
        
        // [ID:0000435][Masahiko Higuchi] 2009/07 add begin カレンダーに実績を読み込む機能の拡張
        // カレンダーの初期化
        int dayCount = 1;
        int year = ACDateUtilities.getYear(getTargetDate());
        int month = ACDateUtilities.getMonth(getTargetDate());
        // 画面状態の変更
        int lastDay = ACDateUtilities.getLastDayOfMonth(getTargetDate());
        switch(lastDay) {
        case 28:
            setState_CALENDER_MODE28();
            break;
        case 29:
            setState_CALENDER_MODE29();
            break;
        case 30:
            setState_CALENDER_MODE30();
            break;
        }
        // コンポーネントを全走査
        for (int j = 0; j < getContentCalendar().getComponentCount(); j++) {
            Component cmp = getContentCalendar().getComponent(j);
            // テーブルの場合のみ処理を
            if (cmp instanceof QP003ResultCalendar) {
                QP003ResultCalendar rc = (QP003ResultCalendar) cmp;
                // サービスマスタの設定
                // 日付を設定
                rc.setCalenderDate(ACDateUtilities.createDate(year, month,
                        dayCount));
                // 日付を+1
                dayCount++;
            }
        }
        // [ID:0000435][Masahiko Higuchi] 2009/07 add end
        
        // [V5.3.4対応 利用者向け領収書] kamitsukasa.kazuyoshi add end
        
        // 医療費控除額取得
        doFindKoujo();
        // 医療費控除非表示
        getKoujoDispCheck().setSelected(true);
        getContentHokenIryoKoujoCheck().setSelected(true);
        setState_KOUJO_ENABLE_TRUE();
        
        // 業務情報マスタより、データを取得する。
        setAffairTitle("QP003", getButtons());
        // 取得したデータのウィンドウタイトル（WINDOW_TITLE）をウィンドウに設定する。
        // 取得したデータの業務タイトル（AFFAIR_TITLE）を業務ボタンバーに設定する。
        // DBよりデータを取得し、画面に展開する。
        doFind();

    }

    /**
     * 前画面遷移処理を行います。 
     */
    public boolean canBack(VRMap parameters) throws Exception {
        if (!super.canBack(parameters)) {
            return false;
        }
        // 更新チェック（スナップショットのチェック）を行う。
        // [ID:0000435][Masahiko Higuchi] 2009/07 edit begin カレンダーに実績を読み込む機能の拡張
        if (getSnapshot().isModified() || calenderIsModified()) {
        // [ID:0000435][Masahiko Higuchi] 2009/07 edit end
            // 最後に保存されてから、項目・テーブルが変更されている場合場合(not isModified)
            // 確認メッセージを表示する。
            int msgID = 0;
            if (getProcessMode() == QkanConstants.PROCESS_MODE_INSERT) {
                msgID = QkanMessageList.getInstance()
                        .WARNING_OF_INSERT_ON_MODIFIED();
            } else {
                msgID = QkanMessageList.getInstance()
                        .WARNING_OF_UPDATE_ON_MODIFIED();
            }
            // ・メッセージID：WARNING_OF_UPDATE_ON_MODIFIED
            switch (msgID) {
            // 「はい」を選択した場合
            case ACMessageBox.RESULT_YES:
                // 保存処理を行う。
                if (!doSave()) {
                    // 保存処理が正常終了しなかった場合
                    // 処理を中断する。(終了)
                    return false;
                }
                break;
            // ｢いいえ｣を選択した場合
            case ACMessageBox.RESULT_NO:
                break;
            // ｢キャンセル｣を選択した場合
            case ACMessageBox.RESULT_CANCEL:
                return false;
            }
            // 「はい」「いいえ」以外を選択した場合
            // 処理を中断する（何もしない）。
        }

        // 下記を渡りパラメータとして、帳票(様式)・事業所選択画面（QP002）に遷移する。
        // ・KEY：PATIENT_ID VALUE：patientId
        // ・KEY：TARGET_DATE VALUE：targetDate
        // ・KEY：CLAIM_DATE VALUE：claimDate
        // ・KEY：LIST_INDEX VALUE：listIndex
        parameters.setData("PATIENT_ID", new Integer(getPatientId()));
        parameters.setData("TARGET_DATE", getTargetDate());
        parameters.setData("CLAIM_DATE", getClaimDate());
        parameters.setData("LIST_INDEX", new Integer(getListIndex()));

        // 前画面への遷移を許可するならばtrueを返す。
        return true;

    }

    // コンポーネントイベント
    /**
     * 終了処理を行います。
     */
    public boolean canClose() throws Exception {
        if (!super.canClose()) {
            return false;
        }
        // ※スナップショットチェック
        // スナップショットの更新チェックを行う。
        // [ID:0000435][Masahiko Higuchi] 2009/07 edit begin カレンダーに実績を読み込む機能の拡張
        if (!getSnapshot().isModified() || !calenderIsModified()) {
        // [ID:0000435][Masahiko Higuchi] 2009/07 edit end
            // 更新されていない場合
            return true;
            // システムを終了する。
        }
        // 更新されている場合
        // 処理を継続する。
        // ※終了確認
        // 終了確認のメッセージを表示する。※メッセージID = WARNING_OF_CLOSE_ON_MODIFIED
        int msgID = QkanMessageList.getInstance()
                .WARNING_OF_CLOSE_ON_MODIFIED();
        // 「OK」選択時
        if (ACMessageBox.RESULT_OK == msgID) {
            // システムを終了する。
            return true;
        } else {
            // 「キャンセル」選択時
            // 処理を中断する。
            return false;
        }
        // 終了を許可するならばtrueを返す。

    }

    // コンポーネントイベントk

    /**
     * 「DB登録」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void insertActionPerformed(ActionEvent e) throws Exception {
        // 登録処理を行う。
        if (doSave()) {
            // 登録処理が正常終了した場合
            // 完了メッセージを表示する。
            QkanMessageList.getInstance().INSERT_SUCCESSED();
            // ・メッセージID：INSERT_SUCCESSED
        }
        // 登録処理が正常終了しなかった場合
        // 処理を中断する（終了）

    }

    // コンポーネントイベント

    /**
     * 「DB登録」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void updateActionPerformed(ActionEvent e) throws Exception {

        // 更新処理を行う。
        if (doSave()) {
            // 更新処理が正常終了した場合
            // 完了メッセージを表示する。
            // ・メッセージID：UPDATE_SUCCESSED
            QkanMessageList.getInstance().UPDATE_SUCCESSED();
        }
        // 更新処理が正常終了しなかった場合
        // 処理を中断する。(終了)

    }

    /**
     * 「合計金額の計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void contentJikohutanUse1FocusLost(FocusEvent e) throws Exception {
        // 金額の合計を算出し、表示する。
        calcSum();

    }

    /**
     * 「合計金額の計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void contentJikohutanUse2FocusLost(FocusEvent e) throws Exception {
        // 金額の合計を算出し、表示する。
        calcSum();

    }

    /**
     * 「合計金額の計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void contentJikohutanUse3FocusLost(FocusEvent e) throws Exception {
        // 金額の合計を算出し、表示する。
        calcSum();

    }

    /**
     * 「合計金額の計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void contentEtcUse1FocusLost(FocusEvent e) throws Exception {
        // 金額の合計を算出し、表示する。
        calcSum();

    }

    /**
     * 「合計金額の計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void contentEtcUse2FocusLost(FocusEvent e) throws Exception {
        // 金額の合計を算出し、表示する。
        calcSum();

    }

    /**
     * 「合計金額の計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void contentEtcUse3FocusLost(FocusEvent e) throws Exception {
        // 金額の合計を算出し、表示する。
        calcSum();

    }

    /**
     * 「合計金額の計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void contentEtcUse4FocusLost(FocusEvent e) throws Exception {
        // 金額の合計を算出し、表示する。
        calcSum();

    }

    /**
     * 「合計金額の計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void contentEtcUse5FocusLost(FocusEvent e) throws Exception {
        // 金額の合計を算出し、表示する。
        calcSum();

    }

    public static void main(String[] args) {
        // デフォルトデバッグ起動
        ACFrame.getInstance().setFrameEventProcesser(
                new QkanFrameEventProcesser());
        QkanCommon.debugInitialize();
        VRMap param = new VRHashMap();
        param.setData("PATIENT_ID", new Integer(1));
        param.setData("CLAIM_DATE", new Date(106, 2, 1));
        param.setData("PROVIDER_ID", "0000000005");
        param.setData("TARGET_DATE", new Date(106, 1, 1));
        // paramに渡りパラメタを詰めて実行することで、簡易デバッグが可能です。
        ACFrame.debugStart(new ACAffairInfo(QP003.class.getName(), param));
    }

    // 内部関数

    /**
     * 「データ取得、画面展開」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public void doFind() throws Exception {
        // データの取得、展開を行う。
        // 利用者情報を取得する。
        VRList patientList = QkanCommon.getPatientInfo(getDBManager(),
                getPatientId());
        // 取得した利用者情報より、下記の値を抽出してデータ展開用HashMap(sourceMap)に設定する。
        if (!patientList.isEmpty()) {
            VRMap patientMap = (VRMap) patientList.getData(0);
            // ・利用者ID KEY：PATIENT_ID
            getSourceMap().setData("PATIENT_CODE",
                    patientMap.getData("PATIENT_CODE"));
            // ・利用者名 KEY：PATIENT_NAME
            getSourceMap().setData(
                    "PATIENT_NAME",
                    QkanCommon.toFullName(patientMap
                            .getData("PATIENT_FAMILY_NAME"), patientMap
                            .getData("PATIENT_FIRST_NAME")));
        }
        // 事業所情報を取得する。
        VRList providerList = QkanCommon.getProviderInfo(getDBManager(),
                getProviderId());
        // 取得した事業所情報より、下記の値を抽出してデータ展開用HashMap(sourceMap)に設定する。
        if (!providerList.isEmpty()) {
            VRMap providerMap = (VRMap) providerList.getData(0);
            // ・事業所ID KEY：PROVIDER_ID
            getSourceMap().setData("PROVIDER_ID",
                    providerMap.getData("PROVIDER_ID"));
            // ・事業所名 KEY：PROVIDER_NAME
            getSourceMap().setData("PROVIDER_NAME",
                    providerMap.getData("PROVIDER_NAME"));
        }
        // 対象年月（targetDate）をデータ展開用HashMap(sourceMap)にKEY：TARGET_DATEで設定する。
        getSourceMap().setData("TARGET_DATE", getTargetDate());
        // 利用者向け請求詳細情報を取得する。
        doFindClaimForPatient();

        VRList claimList = getClaimList();
        // 利用者向け請求詳細情報（claimList）の最初のレコードをデータ展開用HashMap(sourceMap)と結合する。
        if (!claimList.isEmpty()) {
            getSourceMap().putAll((VRMap) claimList.getData(0));
        }
        // データ展開用HashMap(sourceMap)を「クライアント領域（contents）」に設定する。
        getContents().setSource(getSourceMap());

        // [ID:0000435][Masahiko Higuchi] 2009/07 add begin カレンダーに実績を読み込む機能の拡張
        // 作成用の管理マップ
        VRHashMap dateCreateManager = new VRHashMap();
        if(getClaimList() != null && !getClaimList().isEmpty() && getClaimList().getData(0) instanceof VRMap) {
            VRMap patientData = (VRMap)getClaimList().getData(0);
            // キー設定用変数を生成
            String markServiceName = "";
            String markServiceBitKey = "";
            String[] marks = QkanConstants.CLAIM_PATIENT_DETAIL_SERVICE_MARK;
            // 記号の数ループしつつ処理
            for (int i = 1; i <= 7; i++) {
                markServiceName = "MARK" + ACCastUtilities.toString(i) +"_SERVICE_NAME";
                markServiceBitKey = "MARK" + ACCastUtilities.toString(i) +"_SERVICE_DATE_BIT";
                String markServiceNameVal = ACCastUtilities.toString(patientData.getData(markServiceName),"");
                // 日付を取得
                int bits = ACCastUtilities.toInt(patientData.getData(markServiceBitKey),0);
                // 名称と日数情報が正常な場合のみ反映する
                if(!"".equals(markServiceNameVal)) {
                    // 提供日付の2進数を取り出す
                    String dateBit = Integer.toBinaryString(bits);
                    int endIndex = dateBit.length();
                    // 最終日を取得しておく
                    int lastDay = ACDateUtilities.getLastDayOfMonth(getTargetDate());
                    int dayCount = 1;
                    // 該当月の日数分ループを行う
                    for (int j2 = 1; j2 <= lastDay; j2++) {
                        int dayFlag = 0;
                        // bitの長さを超えないようにチェック
                        if(endIndex>0) {
                            dayFlag = ACCastUtilities.toInt(dateBit.substring(endIndex-1,endIndex));
                            endIndex--;
                        }
                        // keyにするために数値を文字列にしておく
                        String dayString = ACCastUtilities.toString(dayCount);
                        // カレンダーに設定する情報の作成
                        // チェックボックス、記号、サービス略称
                        VRMap markRecord = new VRHashMap();
                        markRecord.setData("CHECK",new Boolean((dayFlag==1)));
                        markRecord.setData("MARK",marks[i-1]);
                        // サービス名称
                        markRecord.setData("SERVICE_NAME_COL",markServiceNameVal);
                        // 該当日のデータが既に作成済みかチェック
                        if(dateCreateManager.containsKey(dayString)) {
                            // 作成済み
                            VRList calenderList = (VRList)dateCreateManager.getData(dayString);
                            calenderList.add(markRecord);
                            
                        } else {
                            // 未作成
                            // 新規追加
                            VRList newCalenderList = new VRArrayList();
                            newCalenderList.add(markRecord);
                            dateCreateManager.setData(dayString,newCalenderList);
                        }
                        
                        dayCount++;
                    }
                }
            }
        }
        // コンポーネントを全走査
        for(int j=0; j< getContentCalendar().getComponentCount(); j++) {
            Component cmp = getContentCalendar().getComponent(j);
            // テーブルの場合のみ処理を
            if(cmp instanceof QP003ResultCalendar) {
                QP003ResultCalendar rc = (QP003ResultCalendar)cmp;
                // 日付を設定
                rc.setData(dateCreateManager);
            }
        }
        // [ID:0000435][Masahiko Higuchi] 2009/07 add end
        
        // 画面に展開する。
        getContents().bindSource();

        // 金額の合計を算出する。
        calcSum();

        // [ID:0000435][Masahiko Higuchi] 2009/07 add begin カレンダーに実績を読み込む機能の拡張
        // カレンダー領域のスナップショットを取る
        calenderSnapShot();
        // [ID:0000435][Masahiko Higuchi] 2009/07 add end
        // スナップショットの撮影対象を「クライアント領域（contents）」に指定する。
        getSnapshot().setRootContainer(getContents());
        // スナップショットを撮影する。
        getSnapshot().snapshot();

    }

    /**
     * 「利用者向け請求詳細情報を取得」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public void doFindClaimForPatient() throws Exception {
        // 利用者向け請求詳細情報を取得
        // SQL文取得用のVRMap paramを生成し、以下のKEY/VALUEを設定する。
        VRMap param = new VRHashMap();
        // ・KEY：PATIENT_ID VALUE：patientId
        // ・KEY：TARGET_DATE VALUE：targetDate
        // ・KEY：CLAIM_DATE VALUE：claimDate
        // ・KEY：PROVIDER_ID VALUE：providerId
        // ・KEY：CLAIM_STYLE_TYPE VALUE：claimDate
        // ・KEY：CATEGORY_NO VALUE：
        // ・KEY：INSURED_ID VALUE：insuredId
        param.setData("PATIENT_ID", new Integer(getPatientId()));
        param.setData("TARGET_DATE", getTargetDate());
        param.setData("CLAIM_DATE", getClaimDate());
        param.setData("PROVIDER_ID", getProviderId());
        param.setData("CLAIM_STYLE_TYPE", new Integer(
                STYLE_TYPE_CLAIM_FOR_PATIENT));
        param
                .setData("CATEGORY_NO", new Integer(
                        CATEGORY_NO_CLAIM_FOR_PATIENT));
        param.setData("INSURED_ID", getInsuredId());
        // 利用者向け請求詳細情報を取得するSQL文を取得する。
        // 取得したSQL文を実行し、データをclaimListに格納する。
        setClaimList(getDBManager().executeQuery(
                getSQL_GET_CLAIM_PATIENT_DETAIL(param)));
        // claimListの件数が0件の場合
        // if(getClaimList()!=null){
        if (getClaimList().size() <= 0) {
            // processMode に共通定数のPROCESS_MODE_INSERTを代入する。
            setProcessMode(QkanConstants.PROCESS_MODE_INSERT);
            // dataFlg に0を代入する。
            setDataFlg(0);
            setState_INSERT_STATE();

        } else {
            // claimListの件数が1件以上の場合
            // claimListの最初のレコードを取り出す。
            VRMap map = (VRMap) getClaimList().getData(0);
            // 取り出したレコードのKEY：CLAIM_IDの値をclaimIdへ退避する。
            setClaimId(ACCastUtilities.toInt(map.getData("CLAIM_ID")));

            setState_UPDATE_STATE();
            // 取り出したレコードのKEY：DATA_FLAGの値をチェックする。
            if (map.getData("DATA_FLAG") == null) {
                // KEY：DATA_FLAGの値がnull の場合
                // processMode に共通定数のPROCESS_MODE_INSERTを代入する。
                setProcessMode(QkanConstants.PROCESS_MODE_INSERT);
                // dataFlg に1を代入する。
                setDataFlg(1);
            } else {
                // KEY：DATA_FLAGの値がnull でない場合
                // processMode に共通定数のPROCESS_MODE_UPDATEを代入する。
                setProcessMode(QkanConstants.PROCESS_MODE_UPDATE);
                // dataFlg に１を代入する。
                setDataFlg(1);
            }
        }
        // claimListをパッシブチェック用に退避する。
        getPassiveChecker().reservedPassive(getPASSIVE_CHECK_KEY(),
                getClaimList());

    }

    /**
     * 「合計金額の計算処理」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public void calcSum() throws Exception {
        // 合計金額の計算処理
        int sum = 0;
        // 下記のフィールドのいずれかに値が表示されている場合、フィールドの値の合計を計算する。
        // ・全額自己負担分利用料１（contentJikohutanUse1）
        if (!"".equals(getContentJikohutanUse1().getText())) {
            // 2008/06/09 [Masahiko Higuchi] edit - begin V5.4.1 初期値対応
            sum += ACCastUtilities.toInt(getContentJikohutanUse1().getText(),0);
            // 2008/06/09 [Masahiko Higuchi] edit - end
        }

        // ・全額自己負担分利用料２（contentJikohutanUse2）
        if (!"".equals(getContentJikohutanUse2().getText())) {
            // 2008/06/09 [Masahiko Higuchi] edit - begin V5.4.1 初期値対応
            sum += ACCastUtilities.toInt(getContentJikohutanUse2().getText(),0);
            // 2008/06/09 [Masahiko Higuchi] edit - end
        }

        // ・全額自己負担分利用料３（contentJikohutanUse3）
        if (!"".equals(getContentJikohutanUse3().getText())) {
            // 2008/06/09 [Masahiko Higuchi] edit - begin V5.4.1 初期値対応
            sum += ACCastUtilities.toInt(getContentJikohutanUse3().getText(),0);
            // 2008/06/09 [Masahiko Higuchi] edit - end
        }

        // 計算結果を全額自己負担小計フィールド（contentJikohutanSubtotal）に表示する。
        getContentJikohutanSubtotal().setText(ACCastUtilities.toString(sum));
        // 下記のフィールドのいずれかに値が表示されている場合、フィールドの値の合計を計算する。
        int etcSum = 0;
        // ・その他利用料１（contentEtcUse1）
        if (!"".equals(getContentEtcUse1().getText())) {
            // 2008/06/09 [Masahiko Higuchi] edit - begin V5.4.1 初期値対応
            etcSum += ACCastUtilities.toInt(getContentEtcUse1().getText(),0);
            // 2008/06/09 [Masahiko Higuchi] edit - end
        }

        // ・その他利用料２（contentEtcUse2）
        if (!"".equals(getContentEtcUse2().getText())) {
            // 2008/06/09 [Masahiko Higuchi] edit - begin V5.4.1 初期値対応
            etcSum += ACCastUtilities.toInt(getContentEtcUse2().getText(),0);
            // 2008/06/09 [Masahiko Higuchi] edit - end
        }

        // ・その他利用料３（contentEtcUse3）
        if (!"".equals(getContentEtcUse3().getText())) {
            // 2008/06/09 [Masahiko Higuchi] edit - begin V5.4.1 初期値対応
            etcSum += ACCastUtilities.toInt(getContentEtcUse3().getText(),0);
            // 2008/06/09 [Masahiko Higuchi] edit - end
        }

        // ・その他利用料４（contentEtcUse4）
        if (!"".equals(getContentEtcUse4().getText())) {
            // 2008/06/09 [Masahiko Higuchi] edit - begin V5.4.1 初期値対応
            etcSum += ACCastUtilities.toInt(getContentEtcUse4().getText(),0);
            // 2008/06/09 [Masahiko Higuchi] edit - end
        }

        // ・その他利用料５（contentEtcUse5）
        if (!"".equals(getContentEtcUse5().getText())) {
            // 2008/06/09 [Masahiko Higuchi] edit - begin V5.4.1 初期値対応
            etcSum += ACCastUtilities.toInt(getContentEtcUse5().getText(),0);
            // 2008/06/09 [Masahiko Higuchi] edit - end
        }

        // 2007/11/30 [Masahiko Higuchi] add - begin Ver 5.4.1 利用者向け請求書対応
        // ・その他利用料６（contentEtcUse5）
        if (!"".equals(getContentEtcUse6().getText())) {
            // 2008/06/09 [Masahiko Higuchi] edit - begin V5.4.1 初期値対応
            etcSum += ACCastUtilities.toInt(getContentEtcUse6().getText(),0);
            // 2008/06/09 [Masahiko Higuchi] edit - end
        }        
        // 2007/11/30 [Masahiko Higuchi] add - end
        
        // 計算結果をその他費用小計フィールド（contentEtcSubtotal）に表示する。
        getContentEtcSubtotal().setText(ACCastUtilities.toString(etcSum));
        // 下記のフィールドの値とsumを合計し、合計額（contentTotalText）に表示する。
        sum = sum + etcSum;
        // ・全額自己負担小計フィールド（contentJikohutanSubtotal）
        // ・その他費用小計フィールド（contentEtcSubtotal）
        getContentTotalText().setText(ACCastUtilities.toString(sum));

        // 医療費控除の計算
        calcKoujoPrice();
    }

    /**
     * 「保存処理」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public boolean doSave() throws Exception {
        // 保存処理
        // トランザクションを開始する。
        try {
            getDBManager().beginTransaction();

            // 画面上のデータのチェックを行う。
            doCheckInput();

            if (getProcessMode() == QkanConstants.PROCESS_MODE_INSERT) {
                // 登録モードの場合（processModeが共通定数のPROCESS_MODE_INSERTの場合）
            	// 同利用者の同月のデータが作成されていないかチェックする。
            	VRMap param = new VRHashMap();
            	VRBindPathParser.set("PATIENT_ID", param, new Integer(getPatientId()));
            	VRBindPathParser.set("TARGET_DATE", param, getTargetDate());
            	VRBindPathParser.set("CLAIM_DATE", param, getClaimDate());
            	VRBindPathParser.set("PROVIDER_ID", param, getProviderId());
            	VRBindPathParser.set("CLAIM_STYLE_TYPE", param, new Integer(STYLE_TYPE_CLAIM_FOR_PATIENT));
            	VRBindPathParser.set("CATEGORY_NO", param, new Integer(CATEGORY_NO_CLAIM_FOR_PATIENT));
            	VRList list = getDBManager().executeQuery(getSQL_GET_NEW_CLAIM_PATIENT_DETAIL(param));
                // [Masahiko Higuchi] edit - begin 2007年度対応 実績集計にて全額自己負担作成時にデータ作成の可能性があるためチェック
            	if(!list.isEmpty()&&getDataFlg()==0){
                // [Masahiko Higuchi] edit - end
                    //テーブルロック解除のためロールバック
                    getDBManager().rollbackTransaction();
                    // エラーメッセージを表示する。
                    QkanMessageList.getInstance()
                            .ERROR_OF_PASSIVE_CHECK_ON_UPDATE();
                    // ・メッセージID：ERROR_OF_PASSIVE_CHECK_ON_UPDATE
            		return false;
            	}
                // （終了）
            }else if (getProcessMode() == QkanConstants.PROCESS_MODE_UPDATE) {
                // 更新モードの場合（processModeが共通定数のPROCESS_MODE_UPDATEの場合）
                // パッシブチェックのタスクをクリアする。
                // clearPassiveTask();
                getPassiveChecker().clearPassiveTask();
                // パッシブチェックを下記のパッシブキーで行う。
                // addPassiveDeleteTask();
                // ・PASSIVE_CHECK_KEY
                getPassiveChecker()
                        .addPassiveUpdateTask(getPASSIVE_CHECK_KEY());
                // パッシブエラーが発生した場合
                if (!getPassiveChecker().passiveCheck(getDBManager())) {
                    //テーブルロック解除のためロールバック
                    getDBManager().rollbackTransaction();
                    // エラーメッセージを表示する。
                    QkanMessageList.getInstance()
                            .ERROR_OF_PASSIVE_CHECK_ON_UPDATE();
                    // ・メッセージID：ERROR_OF_PASSIVE_CHECK_ON_UPDATE
                    return false;
                    // （終了）
                }
            }
            // CLAIMテーブルの更新
            // dataFlg が0の場合
            if (getDataFlg() == 0) {
                // 新たにCLAIM_IDを取得する。
                // getBookingNumber(CLAIM, CLAIM_ID, 1);
                // 取得したCLAIM_IDをclaimIdに退避する。
                setClaimId(QkanCommon.getBookingNumber(getDBManager(), "CLAIM",
                        "CLAIM_ID", 1));
                // SQL文取得用のVRMap paramを生成し、以下のKEY/VALUEを設定する。
                VRMap param = new VRHashMap();
                // ・KEY：CLAIM_ID VALUE：claimId
                // ・KEY：CLAIM_STYLE_TYPE VALUE：STYLE_TYPE_CLAIM_FOR_PATIENT
                // ・KEY：CATEGORY_NO VALUE：CATEGORY_NO_CLAIM_FOR_PATIENT
                // ・KEY：PATIENT_ID VALUE：patientId
                // ・KEY：INSURED_ID VALUE：insuredId
                // ・KEY：TARGET_DATE VALUE：targetDate
                // ・KEY：CLAIM_DATE VALUE：claimDate
                // ・KEY：INSURER_ID VALUE：insurerId
                // ・KEY：PROVIDER_ID VALUE：providerId
                // ・KEY：CLAIM_FINISH_FLAG VALUE：0
                param.setData("CLAIM_ID", new Integer(getClaimId()));
                param.setData("CLAIM_STYLE_TYPE", new Integer(
                        STYLE_TYPE_CLAIM_FOR_PATIENT));
                param.setData("CATEGORY_NO", new Integer(
                        CATEGORY_NO_CLAIM_FOR_PATIENT));
                param.setData("PATIENT_ID", new Integer(getPatientId()));
                param.setData("INSURED_ID", getInsuredId());
                param.setData("TARGET_DATE", getTargetDate());
                param.setData("CLAIM_DATE", getClaimDate());
                param.setData("INSURER_ID", getInsurerId());
                param.setData("PROVIDER_ID", getProviderId());
                param.setData("CLAIM_FINISH_FLAG", new Integer(0));

                // paramを引数として、SQL文を取得する。
                // SQL文を実行する。
                getDBManager().executeUpdate(getSQL_INSERT_CLAIM(param));
            }

            VRMap param = new VRHashMap();
            // PATIENT_CLAIM_DETAILテーブルの更新
            // 画面上のデータを取得する。
            // applySource(contents);
            getContents().setSource(param);
            getContents().applySource();
            // 画面上のデータを格納しているVRMap（以下、param）に以下のKEY/VALUEを設定する。;
            // ・KEY：CLAIM_ID VALUE：claimId
            param.setData("CLAIM_ID", new Integer(getClaimId()));
            // 登録モードの場合（processModeが共通定数のPROCESS_MODE_INSERTの場合）
            if (getProcessMode() == QkanConstants.PROCESS_MODE_INSERT) {
                // paramを引数として、SQL文を取得する。
                // SQL文を実行する。
                getDBManager().executeUpdate(
                        getSQL_INSERT_CLAIM_PATIENT_DETAIL(param));
            } else if (getProcessMode() == QkanConstants.PROCESS_MODE_UPDATE) {
                // 更新モードの場合（processModeが共通定数のPROCESS_MODE_UPDATEの場合）
                // paramを引数として、SQL文を取得する。
                // [ID:0000435][Masahiko Higuchi] 2009/07 add begin カレンダーに実績を読み込む機能の拡張
                // カレンダーデータを混ぜ込む
                VRMap dateBitMap = getCalenderBitData();
                if(dateBitMap != null) {
                    param.putAll(dateBitMap);
                }
                // [ID:0000435][Masahiko Higuchi] 2009/07 add end
                // SQL文を実行する。
                getDBManager().executeUpdate(
                        getSQL_UPDATE_CLAIM_PATIENT_DETAIL(param));
            }

            // FIXED_FORMテーブルの更新
            // 画面上のデータのを登録用に振り分ける。
            // ※自己負担分サービス
            // 画面上のデータより、以下の値を取得し、VRList selfListに追加する。
            VRList selfList = new VRArrayList();
            // ・SELF_SERVICE_NO1
            // ・SELF_SERVICE_NO2
            // ・SELF_SERVICE_NO3
            selfList.add(param.getData("SELF_SERVICE_NO1"));
            selfList.add(param.getData("SELF_SERVICE_NO2"));
            selfList.add(param.getData("SELF_SERVICE_NO3"));

            // ※その他費目
            // 画面上のデータより、以下の値を取得し、VRList otherListに追加する。
            VRList otherList = new VRArrayList();
            // ・OTHER_HIMOKU_NO1
            // ・OTHER_HIMOKU_NO2
            // ・OTHER_HIMOKU_NO3
            // ・OTHER_HIMOKU_NO4
            // ・OTHER_HIMOKU_NO5
            otherList.add(param.getData("OTHER_HIMOKU_NO1"));
            otherList.add(param.getData("OTHER_HIMOKU_NO2"));
            otherList.add(param.getData("OTHER_HIMOKU_NO3"));
            otherList.add(param.getData("OTHER_HIMOKU_NO4"));
            otherList.add(param.getData("OTHER_HIMOKU_NO5"));
            // 2007/11/30 [Masahiko Higuchi] add - begin Ver 5.4.1 利用者向け請求書対応
            otherList.add(param.getData("OTHER_HIMOKU_NO6"));
            // 2007/11/30 [Masahiko Higuchi] add - end
            // SQL文取得用のHashMap paramを生成する。
            VRMap params = new VRHashMap();
            // ※自己負担サービスの登録
            for (int i = 0; i < selfList.size(); i++) {
                // selfListの件数文ループする。
                if (!"".equals(selfList.getData(i))) {
                    // paramを初期化し、以下のKEY/VALUEを設定する。
                    param = new VRHashMap();
                    // ・KEY：FIXED_FORM_ID VALUE：1
                    // ・KEY：CONTENT VALUE：selfListの値
                    param.setData("FIXED_FORM_ID", new Integer(1));
                    param.setData("CONTENT", selfList.getData(i));
                    // 選択肢として既にテーブルに存在するかどうか確認するSQL文を取得する。
                    // SQL文を実行する。
                    VRList countList = getDBManager().executeQuery(
                            getSQL_GET_COUNT_SELF_PAY(param));
                    VRMap map = (VRMap) countList.getData(0);
                    // 取得した件数が0件の場合
                    if (ACCastUtilities.toInt(map.getData("CONTENT_SELF_PAY")) == 0) {
                        // paramを初期化し、以下のKEY/VALUEを設定する。
                        param = new VRHashMap();
                        // ・KEY：FIXED_FORM_ID VALUE：1
                        param.setData("FIXED_FORM_ID", new Integer(1));
                        // 登録に使用するCONTENT_KEYを取得するためのSQL文を取得する。
                        // SQL文を実行する。
                        countList = getDBManager().executeQuery(
                                getSQL_GET_NEW_CONTENT_KEY(param));

                        VRMap contentKeyMap = (VRMap) countList.getData(0);
                        // 登録に使用するCONTENT_SORTを取得するためのSQL文を取得する。
                        // SQL文を実行する。
                        countList = getDBManager().executeQuery(
                                getSQL_GET_NEW_CONTENT_SORT(param));
                        VRMap contentSortMap = (VRMap) countList.getData(0);

                        // paramを初期化し、以下のKEY/VALUEを設定する。
                        // ・KEY：TABLE_TYPE VALUE：1
                        // ・KEY：FIXED_FORM_ID VALUE：1
                        // ・KEY：CONTENT_KEY VALUE：（取得した新たなCONTENT_KEY）
                        // ・KEY：CONTENT VALUE：（selfListの値）
                        // ・KEY：CONTENT_SORT VALUE：（取得した新たなCONTENT_SORT）
                        param = new VRHashMap();
                        param.setData("TABLE_TYPE", new Integer(1));
                        param.setData("FIXED_FORM_ID", new Integer(1));
                        param.setData("CONTENT_KEY", contentKeyMap
                                .getData("NEW_CONTENT_KEY"));
                        param.setData("CONTENT", selfList.getData(i));
                        param.setData("CONTENT_SORT", contentSortMap
                                .getData("NEW_CONTENT_SORT"));

                        // 定型文登録用SQL文を取得する。
                        // SQL文を実行する。
                        getDBManager().executeUpdate(
                                getSQL_INSERT_FIXED_FORM(param));
                    }
                }
            }

            // ※その他費目の登録
            // otherListの件数文ループする。
            for (int j = 0; j < otherList.size(); j++) {
                if (!"".equals(otherList.getData(j))) {
                    // paramを初期化し、以下のKEY/VALUEを設定する。
                    // ・KEY：FIXED_FORM_ID VALUE：2
                    // ・KEY：CONTENT VALUE：otherListの値
                    param = new VRHashMap();
                    param.setData("FIXED_FORM_ID", new Integer(2));
                    param.setData("CONTENT", otherList.getData(j));
                    // 選択肢として既にテーブルに存在するかどうか確認するSQL文を取得する。
                    // SQL文を実行する。
                    VRList countList = getDBManager().executeQuery(
                            getSQL_GET_COUNT_SELF_PAY(param));
                    VRMap checkMap = (VRMap) countList.getData(0);
                    // 取得した件数が0件の場合
                    if (ACCastUtilities.toInt(checkMap
                            .getData("CONTENT_SELF_PAY")) == 0) {
                        // paramを初期化し、以下のKEY/VALUEを設定する。
                        param = new VRHashMap();
                        // ・KEY：FIXED_FORM_ID VALUE：2
                        param.setData("FIXED_FORM_ID", new Integer(2));
                        // 登録に使用するCONTENT_KEYを取得するためのSQL文を取得する。
                        // SQL文を実行する。
                        VRList contentKeyList = getDBManager().executeQuery(
                                getSQL_GET_NEW_CONTENT_KEY(param));
                        VRMap contentKeyMap = (VRMap) contentKeyList.getData(0);
                        // 登録に使用するCONTENT_SORTを取得するためのSQL文を取得する。
                        // SQL文を実行する。
                        VRList contentSortList = getDBManager().executeQuery(
                                getSQL_GET_NEW_CONTENT_SORT(param));
                        VRMap contentSortMap = (VRMap) contentSortList
                                .getData(0);

                        // paramを初期化し、以下のKEY/VALUEを設定する。
                        // ・KEY：TABLE_TYPE VALUE：1
                        // ・KEY：FIXED_FORM_ID VALUE：2
                        // ・KEY：CONTENT_KEY VALUE：（取得した新たなCONTENT_KEY）
                        // ・KEY：CONTENT VALUE：（selfListの値）
                        // ・KEY：CONTENT_SORT VALUE：（取得した新たなCONTENT_SORT）
                        param = new VRHashMap();
                        param.setData("TABLE_TYPE", new Integer(1));
                        param.setData("FIXED_FORM_ID", new Integer(2));
                        param.setData("CONTENT_KEY", contentKeyMap
                                .getData("NEW_CONTENT_KEY"));
                        param.setData("CONTENT", otherList.getData(j));
                        param.setData("CONTENT_SORT", contentSortMap
                                .getData("NEW_CONTENT_SORT"));
                        // 定型文登録用SQL文を取得する。
                        // SQL文を実行する。
                        getDBManager().executeUpdate(
                                getSQL_INSERT_FIXED_FORM(param));
                    }
                }
            }
            // コミット/ロールバック
            // 更新に成功した場合
            // コミットする。
            getDBManager().commitTransaction();

        } catch (Exception ex) {
            // 更新に失敗した場合
            ex.printStackTrace();
            // ロールバックを行う。
            getDBManager().rollbackTransaction();
            // 例外を投げる。
            throw ex;
            // （終了）

        }

        // コンボ候補再取り込み
        comboInitialize();
        // 最新のデータを取得し、パッシブチェック用に退避する。
        doFind();
        // 正常終了
        return true;

    }

    /**
     * 「画面データチェック・編集」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public void doCheckInput() throws Exception {
        // 画面データチェック・編集
        // 全額自己負担1列目
        // 全額自己負担分費目１（contentJikohutanHimoku1）が空文字の場合
        // 全額自己負担分利用料１（contentJikohutanUse1）が空文字でない場合
        // 全額自己負担分利用料１（contentJikohutanUse1）に0を代入する。
        // 全額自己負担分費目１（contentJikohutanHimoku1）が空文字でない場合
        // 全額自己負担分利用料１（contentJikohutanUse1）が空文字の場合
        // 全額自己負担分費目１（contentJikohutanHimoku1）を空文字を代入する。
        // 2007/11/26 [Masahiko Higuchi] edit - begin V5.4.1 利用者向け請求書 簡易版版対応
        checkValue(getContentJikohutanHimoku1(), getContentJikohutanUse1(),
                null, null);
        // 2007/11/26 [Masahiko Higuchi] edit - end
        
        // 全額自己負担2列目
        // 全額自己負担分費目２（contentJikohutanHimoku2）が空文字の場合
        // 全額自己負担分利用料２（contentJikohutanUse2）が空文字でない場合
        // 全額自己負担分利用料２（contentJikohutanUse2）に0を代入する。
        // 全額自己負担分費目２（contentJikohutanHimoku2）が空文字でない場合
        // 全額自己負担分利用料２（contentJikohutanUse2）が空文字の場合
        // 全額自己負担分費目２（contentJikohutanHimoku2）を空文字を代入する。
        // 2007/11/26 [Masahiko Higuchi] edit - begin V5.4.1 利用者向け請求書 簡易版版対応
        checkValue(getContentJikohutanHimoku2(), getContentJikohutanUse2(),
                null, null);
        // 2007/11/26 [Masahiko Higuchi] edit - end
        
        // 全額自己負担3列目
        // 全額自己負担分費目３（contentJikohutanHimoku3）が空文字の場合
        // 全額自己負担分利用料３（contentJikohutanUse3）が空文字でない場合
        // 全額自己負担分利用料３（contentJikohutanUse3）に0を代入する。
        // 全額自己負担分費目３（contentJikohutanHimoku3）が空文字でない場合
        // 全額自己負担分利用料３（contentJikohutanUse3）が空文字の場合
        // 全額自己負担分費目３（contentJikohutanHimoku3）を空文字を代入する。
        // 2007/11/26 [Masahiko Higuchi] edit - begin V5.4.1 利用者向け請求書 簡易版版対応
        checkValue(getContentJikohutanHimoku3(), getContentJikohutanUse3(),
                null, null);
        // 2007/11/26 [Masahiko Higuchi] edit - end
        
        // その他費目1列目
        // その他費目１（contentEtcHimoku1）が空文字の場合
        // その他利用料１（contentEtcUse1）が空文字でない場合
        // その他利用料１（contentEtcUse1）に0を代入する。
        // その他費目１（contentEtcHimoku1）が空文字でない場合
        // その他利用料１（contentEtcUse1）が空文字の場合
        // その他費目１（contentEtcHimoku1）を空文字を代入する。
        // 2007/11/26 [Masahiko Higuchi] edit - begin V5.4.1 利用者向け請求書 簡易版版対応
        checkValue(getContentEtcHimoku1(), getContentEtcUse1(),
                getContentEtcUnit1(), getContentEtcCount1());
        // 2007/11/26 [Masahiko Higuchi] edit - end
        
        // その他費目2列目
        // その他費目２（contentEtcHimoku2）が空文字の場合
        // その他利用料２（contentEtcUse2）が空文字でない場合
        // その他利用料２（contentEtcUse2）に0を代入する。
        // その他費目２（contentEtcHimoku2）が空文字でない場合
        // その他利用料２（contentEtcUse2）が空文字の場合
        // その他費目２（contentEtcHimoku2）を空文字を代入する。
        // 2007/11/26 [Masahiko Higuchi] edit - begin V5.4.1 利用者向け請求書 簡易版版対応
        checkValue(getContentEtcHimoku2(), getContentEtcUse2(),
                getContentEtcUnit2(), getContentEtcCount2());
        // 2007/11/26 [Masahiko Higuchi] edit - end
        
        // その他費目3列目
        // その他費目３（contentEtcHimoku3）が空文字の場合
        // その他利用料３（contentEtcUse3）が空文字でない場合
        // その他利用料３（contentEtcUse3）に0を代入する。
        // その他費目３（contentEtcHimoku3）が空文字でない場合
        // その他利用料３（contentEtcUse3）が空文字の場合
        // その他費目３（contentEtcHimoku3）を空文字を代入する。
        // 2007/11/26 [Masahiko Higuchi] edit - begin V5.4.1 利用者向け請求書 簡易版版対応
        checkValue(getContentEtcHimoku3(), getContentEtcUse3(),
                getContentEtcUnit3(), getContentEtcCount3());
        // 2007/11/26 [Masahiko Higuchi] edit - end
        
        // その他費目4列目
        // その他費目４（contentEtcHimoku4）が空文字の場合
        // その他利用料４（contentEtcUse4）が空文字でない場合
        // その他利用料４（contentEtcUse4）に0を代入する。
        // その他費目４（contentEtcHimoku4）が空文字でない場合
        // その他利用料４（contentEtcUse4）が空文字の場合
        // その他費目４（contentEtcHimoku4）を空文字を代入する。
        // 2007/11/26 [Masahiko Higuchi] edit - begin V5.4.1 利用者向け請求書 簡易版版対応
        checkValue(getContentEtcHimoku4(), getContentEtcUse4(),
                getContentEtcUnit4(), getContentEtcCount4());
        // 2007/11/26 [Masahiko Higuchi] edit - end
        
        // その他費目5列目
        // その他費目５（contentEtcHimoku5）が空文字の場合
        // その他利用料５（contentEtcUse5）が空文字でない場合
        // その他利用料５（contentEtcUse5）に0を代入する。
        // その他費目５（contentEtcHimoku5）が空文字でない場合
        // その他利用料５（contentEtcUse5）が空文字の場合
        // その他費目５（contentEtcHimoku5）を空文字を代入する。
        // 2007/11/26 [Masahiko Higuchi] edit - begin V5.4.1 利用者向け請求書 簡易版版対応
        checkValue(getContentEtcHimoku5(), getContentEtcUse5(),
                getContentEtcUnit5(), getContentEtcCount5());
        // 2007/11/26 [Masahiko Higuchi] edit - end

        // 2007/11/30 [Masahiko Higuchi] add - begin V5.4.1 利用者向け請求書 簡易版版対応
        // その他　6列目
        checkValue(getContentEtcHimoku6(), getContentEtcUse6(),
                getContentEtcUnit6(), getContentEtcCount6());        
        // 2007/11/30 [Masahiko Higuchi] add - end
        
        calcSum();

    }

    /**
     * コンボの値をチェックします。
     * 
     * @param himokuCombo
     * @param jikohutanText
     * @throws Exception
     * @version V5.4.1 2007/11/26 [Masahiko Higuchi] edit - begin 利用者向け請求書 簡易版版対応
     */
    public void checkValue(ACComboBox himokuCombo, ACTextField jikohutanText,ACTextField unitText,ACTextField countText)
            throws Exception {
        
        // 2008/06/09 [Masahiko Higuchi] add - begin V5.4.1 利用者向け請求書対応
        // 単位数と回数が存在しないチェックの場合（全額自己負担用）
        if(unitText == null || countText == null){
            // 数値の不正エラー対策
            if("-".equals(jikohutanText.getText())){
                // "-"のみは許可しない
                jikohutanText.setText("");
            }
            // 2008/06/09 [Masahiko Higuchi] add - end
            // 全額自己負担分費目(himokuCombo)が空文字の場合
            if ("".equals(himokuCombo.getText())) {
                // 全額自己負担分利用料（jikohutanText）が空文字でない場合
                if (!"".equals(jikohutanText.getText())) {
                    // 全額自己負担分利用料１（jikohutanText）に0を代入する。
                    jikohutanText.setText("");
                }
            }
            // 全額自己負担分費目（himokuCombo）が空文字でない場合
            if (!"".equals(himokuCombo.getText())) {
                // 全額自己負担分利用料（jikohutanText）が空文字の場合
                if ("".equals(jikohutanText.getText())) {
                    // 全額自己負担分費目１（himokuCombo）を空文字を代入する。
                    himokuCombo.setText("");
                }
            }
            
        // 2008/06/09 [Masahiko Higuchi] add - begin V5.4.1 利用者向け請求書対応
        }else{
            // "-"のみは許可しない
            if("-".equals(jikohutanText.getText())){
                // 利用者負担
                jikohutanText.setText("");
            }
            if("-".equals(unitText.getText())){
                // 単位数
                unitText.setText("");
            }
            if("-".equals(countText.getText())){
                // 回数
                countText.setText("");
            }
            // その他利用料のチェック
            if ("".equals(himokuCombo.getText())) {
                // 全額自己負担分利用料（jikohutanText）が空文字でない場合
                if (!"".equals(jikohutanText.getText())
                        || !"".equals(unitText.getText())
                        || !"".equals(countText.getText())) {
                    // 全額自己負担分利用料１（jikohutanText）に0を代入する。
                    jikohutanText.setText("");
                    unitText.setText("");
                    countText.setText("");
                }
            }
            // 全額自己負担分費目（himokuCombo）が空文字でない場合
            if (!"".equals(himokuCombo.getText())) {
                // 全額自己負担分利用料（jikohutanText）が空文字の場合
                // 金額部分が全て空白の場合は項目名をクリアする
                if ("".equals(jikohutanText.getText())
                        && "".equals(unitText.getText())
                        && "".equals(countText.getText())) {
                    // 全額自己負担分費目１（himokuCombo）を空文字を代入する。
                    himokuCombo.setText("");
                }
            }
        }
        // 2008/06/09 [Masahiko Higuchi] add - end

    }

    /**
     * コンボの初期設定を行います。
     */
    public void comboInitialize() throws Exception {

        // コンボの選択肢候補を取得するためのSQL文を取得する。
        // コンボの選択肢候補を取得する
        VRList list = getDBManager()
                .executeQuery(getSQL_GET_COMBO_DETAIL(null));
        // 取得したデータの件数分ループする。
        // VRList fixedForm1List = new VRArrayList();
        // VRList fixedForm2List = new VRArrayList();
        setComboSet1(new VRArrayList());
        setComboSet2(new VRArrayList());
        for (int i = 0; i < list.size(); i++) {
            VRMap map = (VRMap) list.getData(i);
            // レコードのFIXED_FORM_IDの値が、1の場合
            if (new Integer(1).equals(map.getData("FIXED_FORM_ID"))) {
                // レコードのCONTENTの値をcomboSet1に追加する。
                getComboSet1().add(map.getData("CONTENT"));
            } else if (new Integer(2).equals(map.getData("FIXED_FORM_ID"))) {
                // レコードのFIXED_FORM_IDの値が、2の場合
                // レコードのCONTENTの値をcomboSet2に追加する。
                getComboSet2().add(map.getData("CONTENT"));
            }
        }

        // コンボの選択肢を下記のKEYで、modelMapに設定する。
        VRMap modelMap = new VRHashMap();
        // ・comboSet1 KEY：SELF_PAY
        if (getComboSet1() != null) {
            modelMap.setData("SELF_PAY", getComboSet1());
        }

        // ・comboSet2 KEY：OTHER
        if (getComboSet2() != null) {
            modelMap.setData("OTHER", getComboSet2());
        }

        setModelMap(modelMap);
        // modelMapを「クライアント領域（contents）」に設定する。
        getContents().setModelSource(getModelMap());

        // modelMapを画面に展開する。
        getContents().bindModelSource();

    }

    /**
     * 利用者向け請求書前月読込みに関する処理です。
     */
    protected void openActionPerformed(ActionEvent e) throws Exception {
        // 予防時対応
        // 2006/06/05
        // ※処理実行確認
        // 処理実行の確認のため、メッセージを表示する。※メッセージID =
        // QC001_WARNING_ON_READ_OF_MOST_NEW_DATA
        int msgID = QkanMessageList.getInstance()
                .QC001_WARNING_ON_READ_OF_MOST_NEW_DATA();

        // ｢OK」選択時
        // 処理を継続する。
        if (msgID == ACMessageBox.RESULT_CANCEL) {
            // 「キャンセル」選択時
            // 処理を中断する。
            return;
        }

        VRMap sqlParam = new VRHashMap();
        // SQL文で使用するパラメーターを格納する。
        sqlParam.setData("PATIENT_ID",ACCastUtilities.toInteger(getPatientId()));
        sqlParam.setData("TARGET_DATE",getTargetDate());
        sqlParam.setData("PROVIDER_ID",getProviderId());
        sqlParam.setData("INSURER_ID",getInsurerId());
        sqlParam.setData("INSURED_ID",getInsuredId());
        // 請求テーブルより過去の直近のデータの CLAIM_ID を取得する。
        VRList lastClaimPatientNo = getDBManager().executeQuery(
                getSQL_GET_LAST_CLAIM_NO(sqlParam));
        
        // 結果が返ってきた場合
        if(!lastClaimPatientNo.isEmpty()){
            VRMap map = (VRMap)lastClaimPatientNo.getData(0);
            // CLAIM_IDを格納する。
            String lastClaimId = ACCastUtilities.toString(map
                    .getData("CLAIM_ID"));
            
            sqlParam = new VRHashMap();
            // 取得したCLAIM_IDで PATIENT_CLAIM_DETAILテーブル からデータを取得する。
            sqlParam.setData("CLAIM_ID",lastClaimId);
            VRList lastClaimPatient =  getDBManager().executeQuery(
                    getSQL_GET_LAST_CLAIM_PATIENT(sqlParam));
            // 過去のデータが取得できた場合
            if(!lastClaimPatient.isEmpty()){
                // 取得したデータを contents に設定する。
                getContents().setSource((VRMap)lastClaimPatient.getData(0));
                // データを contents に展開する。
                getContents().bindSource();
                // 再計算処理を行う。
                calcSum();
            }else{
                // 万が一取得できなかった場合の処理
                // データが存在しなかったことを表すメッセージを表示
                QkanMessageList.getInstance().QC001_NOTICE_HAS_NO_LAST_DATA();
                // 処理を終了する。（何も行わない）
                return;
            }
            
        }else{
            // データが存在しなかったことを表すメッセージを表示
            QkanMessageList.getInstance().QC001_NOTICE_HAS_NO_LAST_DATA();
            // 処理を終了する。（何も行わない）
            return;
        }
        
    }
    /**
     * 項目毎の計算処理です。
     */
    protected void contentEtcUnit1FocusLost(FocusEvent e) throws Exception {
        // 金額計算処理
        doCalcUnitPrice(getContentEtcUnit1(), getContentEtcCount1(),
                getContentEtcUse1());
        // 合計額の計算処理
        calcSum();
        
    }
    /**
     * 項目毎の計算処理です。
     */
    protected void contentEtcCount1FocusLost(FocusEvent e) throws Exception {
        // 金額計算処理
        doCalcUnitPrice(getContentEtcUnit1(), getContentEtcCount1(),
                getContentEtcUse1());
        // 合計額の計算処理
        calcSum();
    }
    /**
     * 項目毎の計算処理です。
     */
    protected void contentEtcUnit2FocusLost(FocusEvent e) throws Exception {
        // 金額計算処理
        doCalcUnitPrice(getContentEtcUnit2(), getContentEtcCount2(),
                getContentEtcUse2());
        // 合計額の計算処理
        calcSum();
    }
    /**
     * 項目毎の計算処理です。
     */
    protected void contentEtcCount2FocusLost(FocusEvent e) throws Exception {
        // 金額計算処理
        doCalcUnitPrice(getContentEtcUnit2(), getContentEtcCount2(),
                getContentEtcUse2());
        // 合計額の計算処理
        calcSum();
    }
    /**
     * 項目毎の計算処理です。
     */
    protected void contentEtcUnit3FocusLost(FocusEvent e) throws Exception {
        // 金額計算処理
        doCalcUnitPrice(getContentEtcUnit3(), getContentEtcCount3(),
                getContentEtcUse3());
        // 合計額の計算処理
        calcSum();
    }
    /**
     * 項目毎の計算処理です。
     */
    protected void contentEtcCount3FocusLost(FocusEvent e) throws Exception {
        // 金額計算処理
        doCalcUnitPrice(getContentEtcUnit3(), getContentEtcCount3(),
                getContentEtcUse3());
        // 合計額の計算処理
        calcSum();
    }
    /**
     * 項目毎の計算処理です。
     */
    protected void contentEtcUnit4FocusLost(FocusEvent e) throws Exception {
        // 金額計算処理
        doCalcUnitPrice(getContentEtcUnit4(), getContentEtcCount4(),
                getContentEtcUse4());
        // 合計額の計算処理
        calcSum();
    }
    /**
     * 項目毎の計算処理です。
     */
    protected void contentEtcCount4FocusLost(FocusEvent e) throws Exception {
        // 金額計算処理
        doCalcUnitPrice(getContentEtcUnit4(), getContentEtcCount4(),
                getContentEtcUse4());
        // 合計額の計算処理
        calcSum();
    }
    /**
     * 項目毎の計算処理です。
     */
    protected void contentEtcUnit5FocusLost(FocusEvent e) throws Exception {
        // 金額計算処理
        doCalcUnitPrice(getContentEtcUnit5(), getContentEtcCount5(),
                getContentEtcUse5());
        // 合計額の計算処理
        calcSum();
    }
    /**
     * 項目毎の計算処理です。
     */
    protected void contentEtcCount5FocusLost(FocusEvent e) throws Exception {
        // 金額計算処理
        doCalcUnitPrice(getContentEtcUnit5(), getContentEtcCount5(),
                getContentEtcUse5());
        // 合計額の計算処理
        calcSum();
    }
    /**
     * 単価と数量による計算処理を行います。
     * 
     * @param 単位数テキスト
     * @param 数量（回数）テキスト
     * @param 計算結果格納先テキスト
     * @since V5.3.8
     * @author Masahiko Higuchi
     */
    public void doCalcUnitPrice(ACTextField unit, ACTextField count,
            ACTextField price) throws Exception {
        if (ACTextUtilities.isNullText(unit)
                || ACTextUtilities.isNullText(count)) {
            // nullもしくは空白の場合は処理を中断
            return;
        }
        // 計算結果を設定する。
        price.setText(ACCastUtilities.toString(ACCastUtilities.toInt(unit
                .getText(),0)
                * ACCastUtilities.toInt(count.getText(),0), ""));

    }
    /**
     * 合計額計算処理
     */
    protected void contentEtcUse6FocusLost(FocusEvent e) throws Exception {
        // TODO 自動生成されたメソッド・スタブ
        calcSum();
    }
    /**
     * 項目毎の計算処理です。
     */
    protected void contentEtcUnit6FocusLost(FocusEvent e) throws Exception {
        // 金額計算処理
        doCalcUnitPrice(getContentEtcUnit6(), getContentEtcCount6(),
                getContentEtcUse6());
        // 合計額の計算処理
        calcSum();
        
    }
    /**
     * 項目毎の計算処理です。
     */
    protected void contentEtcCount6FocusLost(FocusEvent e) throws Exception {
        // 金額計算処理
        doCalcUnitPrice(getContentEtcUnit6(), getContentEtcCount6(),
                getContentEtcUse6());
        // 合計額の計算処理
        calcSum();
        
    }

    /**
     * タブ選択時のイベントです。
     * 
     * @author Masahiko Higuchi
     * @since V5.4.9
     */
    protected void tabsStateChanged(ChangeEvent e) throws Exception {
        if(getTabs().getSelectedIndex() == 1) {
            // カレンダータブ選択時
            setState_CALENDER_SELECT();
        } else {
            // 請求金額タブ選択時
            setState_CALENDER_UNSELECT();
        }
        
    }

    /**
     * データ登録用の形式にデータ変換し取得します。
     * 
     * @author Masahiko Higuchi
     * @since V5.4.9
     * @return カレンダーのデータ
     */
    public VRMap getCalenderBitData() throws Exception {
        // カレンダー情報を登録する数値に変換する。
        VRMap dateManager = new VRHashMap();
        // コンポーネントを全走査
        for(int i=0; i< getContentCalendar().getComponentCount(); i++) {
            Component cmp = getContentCalendar().getComponent(i);
            // テーブルの場合のみ処理を
            if(cmp instanceof QP003ResultCalendar) {
                QP003ResultCalendar rc = (QP003ResultCalendar)cmp;
                if(rc.getModel().getAdaptee() instanceof VRList) {
                    // サービスマスタの設定
                    VRList serviceList = (VRList)rc.getModel().getAdaptee();
                    if(!serviceList.isEmpty()) {
                        for(int j=0; j<serviceList.size(); j++) {
                            String markServiceBitKey = "MARK" + ACCastUtilities.toString(j+1) +"_SERVICE_DATE_BIT";
                            StringBuilder sbDateBit = new StringBuilder();
                            // テーブルからデータを取得
                            VRMap record = (VRMap)serviceList.getData(j);
                            // ビットを作成する
                            if(dateManager.containsKey(markServiceBitKey)) {
                                sbDateBit = (StringBuilder)dateManager.getData(markServiceBitKey);
                            }
                            // チェックの値を見つつBitに変換
                            if(ACCastUtilities.toBoolean(record.getData("CHECK"),false) == true) {
                                sbDateBit.insert(0, "1");
                            } else {
                                sbDateBit.insert(0, "0");
                            }
                            // Bit形式で一次作成
                            dateManager.setData(markServiceBitKey,sbDateBit);
                        }
                    }
                }
            }
        }
        // フィールド数ループ
        for (int k = 1; k <= 7; k++) {
            // バインドパス 
            String markServiceBitKey = "MARK" + ACCastUtilities.toString(k) +"_SERVICE_DATE_BIT";
            int bit = 0;
            if(dateManager.containsKey(markServiceBitKey)) {
                StringBuilder sbDateBit = (StringBuilder)dateManager.getData(markServiceBitKey);
                int dayIndex = 1;
                // 日付のビットデータを元にして計算
                for (int l = sbDateBit.length(); l > 0 ; l--) {
                    // bit演算で登録値を計算
                    if("1".equals(sbDateBit.substring(l-1,l))) {
                        bit |= (1 << (dayIndex - 1));
                    }
                    // 日付を進める
                    dayIndex++;
                }
                dateManager.setData(markServiceBitKey,ACCastUtilities.toInteger(bit));
            }
        }
        return dateManager;
    }

    /**
     * カレンダー情報に変更がないかチェックします。
     * 
     * @author Masahiko Higuchi
     * @since V5.4.9
     * @return True:変更あり False:変更なし
     */
    public boolean calenderIsModified() throws Exception {
        // データがない場合は処理をしない
        if(getSnapShotMap() == null || getSnapShotMap().isEmpty()) {
            return false;
        }
        // 現在のカレンダーデータを取得
        VRMap nowCalenderMap = getCalenderBitData();
        if(nowCalenderMap == null || nowCalenderMap.isEmpty()) {
            return true;
        }
        
        // フィールド数ループ
        for (int i = 1; i <= 7; i++) {
            String markServiceBitKey = "MARK" + ACCastUtilities.toString(i) +"_SERVICE_DATE_BIT";
            // キーが両方とも存在する場合
            if (getSnapShotMap().containsKey(markServiceBitKey)
                    && nowCalenderMap.containsKey(markServiceBitKey)) {
                Integer old = ACCastUtilities.toInteger(getSnapShotMap().getData(markServiceBitKey),0);
                Integer now = ACCastUtilities.toInteger(nowCalenderMap.getData(markServiceBitKey),0); 
                // 項目が一致しているかチェックする。
                if (!old.equals(now)) {
                    return true;
                }
            }
        }
        // 最後まで一緒なら変更なし
        return false;
    }

    /**
     * カレンダー領域のスナップショットを撮影します。
     * 
     * @author Masahiko Higuchi
     * @since V5.4.9
     */
    public void calenderSnapShot() throws Exception {
        // データを設定
        setSnapShotMap(getCalenderBitData());
        
    }

    /**
     * 「医療費控除補助の制御」イベントです。
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void koujoDispCheckActionPerformed(ActionEvent e) throws Exception {
        if(getKoujoDispCheck().isSelected()) {
            // 医療費控除補助選択時
        	setState_KOUJO_ENABLE_TRUE();
        } else {
            // 医療費控除補助非選択時
        	setState_KOUJO_ENABLE_FALSE();
        }
        
    }

    /**
     * 「医療費控除金額算出」イベントです。
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void contentHokenIryoUseFocusLost(FocusEvent e) throws Exception {
    	calcKoujoPrice();
    }

    /**
     * 「医療費控除金額算出」イベントです。
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void contentHokenFukushiUseFocusLost(FocusEvent e) throws Exception {
    	calcKoujoPrice();
    }

    /**
     * 「医療費控除金額算出」イベントです。
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void contentHokenIryoKoujoCheckActionPerformed(ActionEvent e) throws Exception {
    	calcKoujoPrice();
    }

    /**
     * 「医療費控除金額算出」イベントです。
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void contentHokenFukushiKoujoCheckActionPerformed(ActionEvent e) throws Exception {
    	calcKoujoPrice();
    }

    /**
     * 「医療費控除金額算出」イベントです。
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void contentJikohutanKoujoCheck1ActionPerformed(ActionEvent e) throws Exception {
    	calcKoujoPrice();
    }

    /**
     * 「医療費控除金額算出」イベントです。
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void contentJikohutanKoujoCheck2ActionPerformed(ActionEvent e) throws Exception {
    	calcKoujoPrice();
    }

    /**
     * 「医療費控除金額算出」イベントです。
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void contentJikohutanKoujoCheck3ActionPerformed(ActionEvent e) throws Exception {
    	calcKoujoPrice();
    }

    /**
     * 「医療費控除金額算出」イベントです。
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void contentEtcKoujoCheck1ActionPerformed(ActionEvent e) throws Exception {
    	calcKoujoPrice();
    }

    /**
     * 「医療費控除金額算出」イベントです。
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void contentEtcKoujoCheck2ActionPerformed(ActionEvent e) throws Exception {
    	calcKoujoPrice();
    }

    /**
     * 「医療費控除金額算出」イベントです。
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void contentEtcKoujoCheck3ActionPerformed(ActionEvent e) throws Exception {
    	calcKoujoPrice();
    }

    /**
     * 「医療費控除金額算出」イベントです。
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void contentEtcKoujoCheck4ActionPerformed(ActionEvent e) throws Exception {
    	calcKoujoPrice();
    }

    /**
     * 「医療費控除金額算出」イベントです。
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void contentEtcKoujoCheck5ActionPerformed(ActionEvent e) throws Exception {
    	calcKoujoPrice();
    }

    /**
     * 「医療費控除金額算出」イベントです。
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void contentEtcKoujoCheck6ActionPerformed(ActionEvent e) throws Exception {
    	calcKoujoPrice();
    }

    /**
     * 「医療費控除金額反映」イベントです。
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void reflectionActionPerformed(ActionEvent e) throws Exception {
        if (ACCastUtilities.toInt(getContentKoujyoText().getText(), 0) > 0) {
            if (QkanMessageList.getInstance()
                    .QP003_WARNING_OF_REPLACE_KOUJO() == ACMessageBox.RESULT_CANCEL) {
                // 「キャンセル」選択時
                return;
                }
        }
        getContentKoujyoText().setText(getContentKoujyoText2().getText());
    }

    /**
     * 「医療費控除計算」に関する処理を行ないます。
     *
     * @throws Exception 処理例外
     *
     */
    public void calcKoujoPrice() throws Exception {
        // 介護保険負担分合計金額の計算処理
        int hokenSum = 0;
        // 医療費控除対象がチェックされているフィールドの値の合計を計算する。
        // ・医療系サービス
        if (getContentHokenIryoKoujoCheck().isSelected() && !"".equals(getContentHokenIryoUse().getText())) {
        	hokenSum += ACCastUtilities.toInt(getContentHokenIryoUse().getText(),0);
        }
        // ・福祉系サービス
        if (getContentHokenFukushiKoujoCheck().isSelected() && !"".equals(getContentHokenFukushiUse().getText())) {
        	hokenSum += ACCastUtilities.toInt(getContentHokenFukushiUse().getText(),0);
        }
        
        // 全額自己負担分合計金額の計算処理
        int sum = 0;
        // ・全額自己負担分利用料１
        if (getContentJikohutanKoujoCheck1().isSelected() && !"".equals(getContentJikohutanUse1().getText())) {
            sum += ACCastUtilities.toInt(getContentJikohutanUse1().getText(),0);
        }
        // ・全額自己負担分利用料２
        if (getContentJikohutanKoujoCheck2().isSelected() && !"".equals(getContentJikohutanUse2().getText())) {
            sum += ACCastUtilities.toInt(getContentJikohutanUse2().getText(),0);
        }
        // ・全額自己負担分利用料３
        if (getContentJikohutanKoujoCheck3().isSelected() && !"".equals(getContentJikohutanUse3().getText())) {
            sum += ACCastUtilities.toInt(getContentJikohutanUse3().getText(),0);
        }
        // 計算結果を全額自己負担小計フィールドに表示する。
        getContentJikohutanKoujoSubtotal().setText(ACCastUtilities.toString(sum));
        
        // その他利用料合計金額の計算処理
        int etcSum = 0;
        // ・その他利用料１
        if (getContentEtcKoujoCheck1().isSelected() && !"".equals(getContentEtcUse1().getText())) {
            etcSum += ACCastUtilities.toInt(getContentEtcUse1().getText(),0);
        }
        // ・その他利用料２
        if (getContentEtcKoujoCheck2().isSelected() && !"".equals(getContentEtcUse2().getText())) {
            etcSum += ACCastUtilities.toInt(getContentEtcUse2().getText(),0);
        }
        // ・その他利用料３
        if (getContentEtcKoujoCheck3().isSelected() && !"".equals(getContentEtcUse3().getText())) {
            etcSum += ACCastUtilities.toInt(getContentEtcUse3().getText(),0);
        }
        // ・その他利用料４
        if (getContentEtcKoujoCheck4().isSelected() && !"".equals(getContentEtcUse4().getText())) {
            etcSum += ACCastUtilities.toInt(getContentEtcUse4().getText(),0);
        }
        // ・その他利用料５
        if (getContentEtcKoujoCheck5().isSelected() && !"".equals(getContentEtcUse5().getText())) {
            etcSum += ACCastUtilities.toInt(getContentEtcUse5().getText(),0);
        }
        // ・その他利用料６
        if (getContentEtcKoujoCheck6().isSelected() && !"".equals(getContentEtcUse6().getText())) {
            etcSum += ACCastUtilities.toInt(getContentEtcUse6().getText(),0);
        }        
        // 計算結果をその他費用小計フィールドに表示する。
        getContentEtcKoujoSubtotal().setText(ACCastUtilities.toString(etcSum));

        // 医療費控除チェック合計に表示する。
        sum = hokenSum + sum + etcSum;
        getContentKoujyoText2().setText(ACCastUtilities.toString(sum));

    }
    
    /**
     * 「医療費控除情報を取得」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public void doFindKoujo() throws Exception {
        // 請求詳細情報の利用者負担分を取得
        // SQL文取得用のVRMap paramを生成し、以下のKEY/VALUEを設定する。
        VRMap param = new VRHashMap();
        // ・KEY：PATIENT_ID VALUE：patientId
        // ・KEY：TARGET_DATE VALUE：targetDate
        // ・KEY：CLAIM_DATE VALUE：claimDate
        // ・KEY：PROVIDER_ID VALUE：providerId
        // ・KEY：INSURED_ID VALUE：insuredId
        param.setData("PATIENT_ID", new Integer(getPatientId()));
        param.setData("TARGET_DATE", getTargetDate());
        param.setData("CLAIM_DATE", getClaimDate());
        param.setData("PROVIDER_ID", getProviderId());
        param.setData("INSURED_ID", getInsuredId());
        // SQL文を取得する。
        // 取得したSQL文を実行し、データをkoujoListに格納する。
        VRList koujoList = getDBManager().executeQuery(getSQL_GET_RIYOUSYA_UNIT(param));
        int iryoTotal = 0;
        int fukushiTotal = 0;
        int halfTotal = 0;
        for (int i = 0; i < koujoList.size(); i++) {
            VRMap map = (VRMap) koujoList.getData(i);
            // サービス種類毎に医療系と福祉系の利用者負担合計へ設定する
            int unit = ACCastUtilities.toInt(map.get("UNIT"), 0);
            String serviceCodeKind = ACCastUtilities.toString(map.get("SERVICE_CODE_KIND"), "");
            int styleType = ACCastUtilities.toInt(map.get("CLAIM_STYLE_TYPE"), 0);
            // 医療系サービス（特養以外）
            if ("13".equals(serviceCodeKind) || "14".equals(serviceCodeKind) || "16".equals(serviceCodeKind)
                || "22".equals(serviceCodeKind) || "23".equals(serviceCodeKind)
                || "25".equals(serviceCodeKind) || "26".equals(serviceCodeKind)
                || "31".equals(serviceCodeKind) || "34".equals(serviceCodeKind)
                || "52".equals(serviceCodeKind) || "53".equals(serviceCodeKind)
                || "63".equals(serviceCodeKind) || "64".equals(serviceCodeKind) || "66".equals(serviceCodeKind)
                || ("".equals(serviceCodeKind) && styleType == QkanConstants.CLAIM_STYLE_FORMAT_4)  // 特定入所者 短期老健
                || ("".equals(serviceCodeKind) && styleType == QkanConstants.CLAIM_STYLE_FORMAT_4_2)// 特定入所者 予防短期老健
                || ("".equals(serviceCodeKind) && styleType == QkanConstants.CLAIM_STYLE_FORMAT_5)  // 特定入所者 短期療養
                || ("".equals(serviceCodeKind) && styleType == QkanConstants.CLAIM_STYLE_FORMAT_5_2)// 特定入所者 予防短期療養
                || ("".equals(serviceCodeKind) && styleType == QkanConstants.CLAIM_STYLE_FORMAT_9)  // 特定入所者 老健
                || ("".equals(serviceCodeKind) && styleType == QkanConstants.CLAIM_STYLE_FORMAT_10) // 特定入所者 療養
            	) {
            	iryoTotal = iryoTotal + unit;
            }
            // 医療系サービス
            // ※特養　最後に半額にするため別集計
            if ("51".equals(serviceCodeKind) || "54".equals(serviceCodeKind) 
            	|| ("".equals(serviceCodeKind) && styleType == QkanConstants.CLAIM_STYLE_FORMAT_8) // 特定入所者 特養
            ) {
            	halfTotal = halfTotal + unit;
            }
            // 福祉系サービス
            // ※総合事業は訪問型と通所型のみ（A1-A8）を対象とする
            if ("11".equals(serviceCodeKind) || "12".equals(serviceCodeKind) || "15".equals(serviceCodeKind) 
                || "21".equals(serviceCodeKind) || "24".equals(serviceCodeKind)
                || "61".equals(serviceCodeKind) || "62".equals(serviceCodeKind)
                || "65".equals(serviceCodeKind) || "68".equals(serviceCodeKind)
                || "69".equals(serviceCodeKind)
                || "71".equals(serviceCodeKind) || "72".equals(serviceCodeKind)
                || "73".equals(serviceCodeKind) || "74".equals(serviceCodeKind)
                || "75".equals(serviceCodeKind) || "76".equals(serviceCodeKind)
                || "77".equals(serviceCodeKind) || "78".equals(serviceCodeKind)
                || "79".equals(serviceCodeKind)
                || "A1".equals(serviceCodeKind) || "A2".equals(serviceCodeKind)
                || "A3".equals(serviceCodeKind) || "A4".equals(serviceCodeKind)
                || "A5".equals(serviceCodeKind) || "A6".equals(serviceCodeKind)
                || "A7".equals(serviceCodeKind) || "A8".equals(serviceCodeKind)
                || ("".equals(serviceCodeKind) && styleType == QkanConstants.CLAIM_STYLE_FORMAT_3)   // 特定入所者 短期生活
                || ("".equals(serviceCodeKind) && styleType == QkanConstants.CLAIM_STYLE_FORMAT_3_2) // 特定入所者 予防短期生活
                ) {
            	fukushiTotal = fukushiTotal + unit;
            }
        }
        iryoTotal = iryoTotal + (int)Math.floor(halfTotal / 2.0d);
        getContentHokenIryoUse().setText(ACCastUtilities.toString(iryoTotal));
        getContentHokenFukushiUse().setText(ACCastUtilities.toString(fukushiTotal));
    }


}
