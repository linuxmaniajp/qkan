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
 * 開発者: 樋口　雅彦
 * 作成日: 2006/01/22  日本コンピューター株式会社 樋口　雅彦 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム その他機能 (O)
 * プロセス 保険者管理 (001)
 * プログラム 保険者一覧 (QO001)
 *
 *****************************************************************
 */

package jp.or.med.orca.qkan.affair.qo.qo001;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

import javax.swing.event.ListSelectionEvent;

import jp.nichicom.ac.ACCommon;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.sql.ACPassiveKey;
import jp.nichicom.ac.util.ACMessageBox;
import jp.nichicom.ac.util.adapter.ACTableModelAdapter;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.QkanConstants;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.affair.QkanMessageList;
import jp.or.med.orca.qkan.affair.qo.qo002.QO002;

/**
 * 保険者一覧(QO001)
 */
public class QO001 extends QO001Event {
    /**
     * コンストラクタです。
     */
    public QO001() {
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
        // 画面の初期表示を行う処理
        // 取得したデータのウィンドウタイトル（WINDOW_TITLE）をウィンドウに設定する。
        // 取得したデータの業務タイトル（AFFAIR_TITLE）を業務ボタンバーに設定する。
        VRMap params = affair.getParameters();
        setAffairTitle("QO001", getButtons());

        setINSURER_INFO_PASSIVE_CHECK_KEY(new ACPassiveKey("INSURER",
                new String[] { "INSURER_ID" }, new boolean[] { true },
                "LAST_TIME", "LAST_TIME"));

        // テーブルモデルを下記の画面のテーブルに設定する。
        // ・保険者情報テーブル（insurerInfoTable) テーブルモデル：insurerTableModel
        ACTableModelAdapter insurerInfoTableModel = new ACTableModelAdapter();

        // テーブルモデルを定義
        insurerInfoTableModel
                .setColumns(new String[] { "INSURER_ID", "INSURER_NAME",
                        "INSURER_TYPE",
                        "INSURER_ZIP_FIRST+'-'+INSURER_ZIP_SECOND",
                        "INSURER_ADDRESS",
                        "INSURER_TEL_FIRST+'-'+INSURER_TEL_SECOND+'-'+INSURER_TEL_THIRD" });

        // 定義したテーブルモデルを格納
        setInsurerInfoTableModel(insurerInfoTableModel);

        // テーブルモデルをテーブルにセット
        getInsurerInfoTable().setModel(getInsurerInfoTableModel());

        // DBよりレコードを取得し、画面に展開する。
        doFind();

        // もしparamsがnullの場合処理を終了する
        if (params == null) {
            return;
        }

        // 渡りパラメーターの中に前画面の保険者IDがあるかチェックする
        if (VRBindPathParser.has("INSURER_ID", params)) {

            // 詳細画面で選択されていた保険者と合致するレコードのindexを取得する。
            int index = ACCommon.getInstance().getMatchIndexFromValue(
                    getInsurerInfoList(), "INSURER_ID",
                    String.valueOf(params.getData("INSURER_ID")));

            // 一致する
            if (index != -1) {
                // 詳細からの保険者を選択状態にする
                getInsurerInfoTable().setSelectedModelRow(index);

            } else {
                // レコードの1行目を選択状態にする。
                getInsurerInfoTable().setSelectedSortedFirstRow();

            }
            // 2重使用を防ぐため初期値に戻す
//             setInsurerId("");

        } else {
            // レコードの1行目を選択状態にする。
            getInsurerInfoTable().setSelectedSortedFirstRow();

        }
        //選択利用者にスクロールする
        getInsurerInfoTable().scrollSelectedToVisible();
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
     * 「検索処理」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void findActionPerformed(ActionEvent e) throws Exception {
        // 検索を行う処理
        // 検索を行う。
        doFindData();

    }

    /**
     * 「保険者登録画面に遷移（更新）」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void detailActionPerformed(ActionEvent e) throws Exception {
        // 保険者情報登録画面に更新モードで遷移する処理
        // 画面の｢保険者一覧｣が選択されているかチェックする。
        if (getInsurerInfoTable().isSelected()) {
            // 選択されていた場合
            // 選択保険者ＩＤをinsurerIdに格納する。
            VRMap rec = (VRMap) getInsurerInfoTable()
                    .getSelectedModelRowValue();

            // VPMap：paramを生成し下記のパラメーターを格納する。
            VRMap param = new VRHashMap();
            // KEY：PROCESS_MODE VALUE：共通定数（PROCESS_MODE_UPDATE(3)）
            // KEY：INSURER_ID VALUE：insurerId
            param.setData("INSURER_ID", rec.getData("INSURER_ID"));
            param.setData("PROCESS_MODE", new Integer(
                    QkanConstants.PROCESS_MODE_UPDATE));

            // 次画面遷移のためのパラメーターNCAffairInfo affairを定義する。
            ACAffairInfo affair = null;

            affair = new ACAffairInfo(QO002.class.getName(), param);

            // ｢QU002（保険者登録）｣に遷移する。
            ACFrame.getInstance().next(affair);

        }

    }

    /**
     * 「保険者登録画面に遷移（新規）」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void insertActionPerformed(ActionEvent e) throws Exception {
        // 保険者情報登録画面に新規登録モードで遷移する処理
        // VRMap：paramを生成し下記のパラメーターを格納する。
        VRMap param = new VRHashMap();
        // KEY：PROCESS_MODE VALUE：共通定数（PROCESS_MODE_INSERT(4)）
        param.setData("PROCESS_MODE", new Integer(
                QkanConstants.PROCESS_MODE_INSERT));

        // 次画面遷移のためのパラメーターNCAffairInfo affairを定義する。
        ACAffairInfo affair = null;
        // 下記のパラメーターでaffairを生成する。
        // className：QO002.class.getName() parameters:param
        affair = new ACAffairInfo(QO002.class.getName(), param);

        // ｢QU002（保険者登録）｣に遷移する。
        // NEXT(affair);
        ACFrame.getInstance().next(affair);

    }

    /**
     * 「削除処理」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void deleteActionPerformed(ActionEvent e) throws Exception {

        if (getInsurerInfoTable().isSelected()) {
            // 画面の｢保険者一覧｣の行が選択されているかチェックする。
            // 選択されている場合
            // 選択行の保険者IDをinsurerIdに格納する。
            VRMap tableData = (VRMap) getInsurerInfoTable()
                    .getSelectedModelRowValue();
            setInsurerId((String.valueOf(tableData.getData("INSURER_ID"))));

            // 選択保険者が既に登録されている保険者かどうかチェックする。
            if (!checkInsurerId()) {
                // 既に登録されている保険者だった場合
                // エラーメッセージを表示する。 ※メッセージID = ERROR_OF_DELETE_INSURER
                QkanMessageList.getInstance().ERROR_OF_DELETE_USED("利用者の情報");
                // 処理を抜ける。（処理を中断する）
                return;

            } else {
                // 登録されていない保険者だった場合
                // 削除確認メッセージを表示する。※メッセージID = WARNING_OF_DELETE
                int msgID = QkanMessageList.getInstance().WARNING_OF_DELETE(
                        "選択中の保険者情報");

                // ｢はい｣押下時
                if (msgID == ACMessageBox.RESULT_YES) {

                    // 現在の選択行を退避する
                    int sel = getInsurerInfoTable().getSelectedModelRow();

                    // 削除処理を行う。
                    if (!doDelete()) {
                        // 何らかのエラーが発生した場合処理を中断する
                        return;
                    }

                    // 削除後の理想となる行番号を設定する
                    getInsurerInfoTable()
                            .setSelectedSortedRowOnAfterDelete(sel);

                }

                // ｢いいえ｣押下時
                // 処理を抜ける。（処理を行わない）
                return;
            }
        }
    }

    /**
     * 「画面制御」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void insurerInfoTableSelectionChanged(ListSelectionEvent e)
            throws Exception {
        // ※画面の制御
        if (!getInsurerInfoTable().isSelected()) {
            // 選択されていない場合
            // 業務ボタンの状態を変更する。
            setState_UNSELECTED();
            // ・状態ID：UNSELECTED
        } else {
            // 選択されている場合
            // 業務ボタンの状態を変更する。
            setState_SELECTED();
            // ・状態ID：SELECTED
        }
    }

    /**
     * 「画面遷移処理」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void insurerInfoTableMouseClicked(MouseEvent e) throws Exception {
        // ※選択された保険者の情報で、次画面に遷移
        // 画面の「保険者一覧」の行が選択されているかどうかチェックする。
        VRMap param = new VRHashMap();

        if (getInsurerInfoTable().isSelected()) {
            // 選択されている場合
            // 選択されている利用者の「保険者番号」を取得する。
            param = (VRMap) getInsurerInfoTable().getSelectedModelRowValue();
            // [ID:0000520][Masahiko Higuchi] 2009/07 add begin 保険者マスタより保険者番号のエラーチェック機能を追加
            param.setData("PROCESS_MODE", new Integer(
                    QkanConstants.PROCESS_MODE_UPDATE));
            // [ID:0000520][Masahiko Higuchi] 2009/07 add end
        } else {
            // 選択されていない場合
            // 処理を中断する。
            // [ID:0000520][Masahiko Higuchi] 2009/07 add begin 保険者マスタより保険者番号のエラーチェック機能を追加
            return;
            // [ID:0000520][Masahiko Higuchi] 2009/07 add end

        }

        // ※遷移処理
        ACAffairInfo affair = null;
        affair = new ACAffairInfo(QO002.class.getName(), param);
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
        ACFrame.debugStart(new ACAffairInfo(QO001.class.getName(), param));
    }

    // 内部関数

    /**
     * 「レコードを取得し画面に設定する。」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public void doFind() throws Exception {
        // 画面展開用の情報を取得する処理
        // 保険者情報TABLEに存在する、全保険者情報を取得する。
        doFindInsurerInfo();

        if (!getInsurerInfoList().isEmpty()) {
            // 取得した全保険者情報（insurerInfoList）をinsurerTableModelに設定する。
            getInsurerInfoTableModel().setAdaptee(getInsurerInfoList());

            // insurerInfoTableのレコードが1件以上の場合

        } else {
            // 情報が取得できなかった場合
            getInsurerInfoList().clearData();
            getInsurerInfoTableModel().setAdaptee(getInsurerInfoList());

            // 画面状態を変更する
            setState_UNSELECTED();
        }

        // スナップショットを撮影する。
        getSnapshot().snapshot();

    }

    /**
     * 「全保険者情報取得」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public void doFindInsurerInfo() throws Exception {
        // 全保険者情報を取得する処理
        // 全保険者情報を取得するためのSQL文を取得する。
        // 取得したSQL文を実行する。
        VRList allInsurerInfoList = getDBManager().executeQuery(
                getSQL_GET_INSURER_INFO(null));

        // レコードが取得できた場合
        if (!allInsurerInfoList.isEmpty()) {
            // 取得したレコード配列をinsurerInfoListに格納する。
            setInsurerInfoList(allInsurerInfoList);

            // 保険者情報TABLEパッシブチェック用にデータを登録する。
            getPassiveChecker().reservedPassive(
                    getINSURER_INFO_PASSIVE_CHECK_KEY(), getInsurerInfoList());

        } else {

            allInsurerInfoList.clearData();
            setInsurerInfoList(allInsurerInfoList);

        }

    }

    /**
     * 「選択保険者削除処理」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public boolean doDelete() throws Exception {
        // 保険者情報を削除する処理
        try {
            // トランザクションを開始する。
            getDBManager().beginTransaction();
            // パッシブタスクをクリアする。
            getPassiveChecker().clearPassiveTask();
            // パッシブタスクを追加する。（保険者情報削除用）
            getPassiveChecker().addPassiveUpdateTask(
                    getINSURER_INFO_PASSIVE_CHECK_KEY());

            // パッシブチェックを実行する。
            if (!getPassiveChecker().passiveCheck(getDBManager())) {
                //テーブルロック解除のためロールバック
                getDBManager().rollbackTransaction();
                // パッシブエラーがある場合
                // エラーメッセージを表示する。
                QkanMessageList.getInstance()
                        .ERROR_OF_PASSIVE_CHECK_ON_UPDATE();
                // 処理を抜ける。（処理を中断する）
                return false;
            }

            // パッシブエラーがない場合
            // 保険者情報削除用のSQL文を取得する。
            // SQL文取得のためVRMap：paramを作成し、下記のパラメーターを設定する。
            VRMap param = new VRHashMap();
            // KEY：INSURER_ID VALUE：insurerId
            param.setData("INSURER_ID", getInsurerId());

            // 保険者情報削除用のSQL文を取得する
            // 取得したSQL文を実行する。
            getDBManager().executeUpdate(getSQL_UPDATE_TO_DELETE_INSURER(param));
            // 処理したSQL文の実行中に1つもエラーが発生しなかった場合
            // コミットする。
            getDBManager().commitTransaction();
            // 保険者関連情報を取得しパッシブチェック用に退避する。
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
     * 「検索処理を行う。」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public void doFindData() throws Exception {
        // 保険者検索処理を行う。
        // ｢保険者名称テキスト（insurerName）｣の値を取得する。
        if (!"".equals(getInsurerName().getText())) {
            //値が取得できた場合
            //SQL文取得のためVRMap：paramを作成し、下記のKEY/VALUEで設定する。
            VRMap param = new VRHashMap();
            //KEY：INSURER_NAME_FIND　VALUE：取得した値
            param.setData("INSURER_NAME_FIND", getInsurerName().getText());

            //SQL文を取得する。
            //SQL文を実行する。
            VRList list = getDBManager().executeQuery(
                    getSQL_FIND_INSURER_NAME(param));

            if (list.size() > 0) {
                //レコードが1件以上取得できた場合
                //取得したレコードをinsurerInfoListに格納する。
                setInsurerInfoList(list);

            } else {
                //レコードが1件も取得できなかった場合
                //空のリストを生成する。
                VRList initList = new VRArrayList();
                setInsurerInfoList(initList);
            }

            //取得した検索結果（insurerInfoList）をinsurerInfoTableModelに設定する。
            getInsurerInfoTableModel().setAdaptee(getInsurerInfoList());

            //レコードの1行目を選択状態にする。
            getInsurerInfoTable().setSelectedSortedFirstRow();
        } else {
            //値が取得できなかった場合（テキストが空白だった場合）
            //登録されている保険者の一覧を表示する。
            doFind();

            //レコードの1行目を選択状態にする。
            getInsurerInfoTable().setSelectedSortedFirstRow();
        }

    }

    /**
     * 「保険者番号が使用されているかチェックする」に関する処理を行ないます。
     * @throws Exception 処理例外
     */
    public boolean checkInsurerId() throws Exception {
        //利用者情報として保険者番号が使用されているかチェックする処理
        //内部変数 sqlParamを生成し下記のKEY/VALUEを設定する。
        VRMap sqlParam = new VRHashMap();
        //KEY：INSURER_ID　VALUE：insurerId
        sqlParam.setData("INSURER_ID", getInsurerId());

        //保険者番号取得のためのSQL文を取得する。    
        //取得したSQL文を実行する。
        VRList list = getDBManager().executeQuery(
                getSQL_GET_INSURER_ID(sqlParam));

        if (list.size() > 0) {
            //レコードが1件以上取得できた場合
            //削除不可能として処理を返す(false)
            return false;
        } else {
            //レコードが取得できなかった場合
            //削除可能として処理を返す(true)
            return true;
        }
    }

}
