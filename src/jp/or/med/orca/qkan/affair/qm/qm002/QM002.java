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
 * 開発者: 堤 瑞樹
 * 作成日: 2006/01/24  日本コンピューター株式会社 堤 瑞樹 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム メニュー (M)
 * プロセス メインメニュー (002)
 * プログラム メインメニュー (QM002)
 *
 *****************************************************************
 */

package jp.or.med.orca.qkan.affair.qm.qm002;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

import jp.nichicom.ac.component.mainmenu.ACFilterableMainMenuTree;
import jp.nichicom.ac.component.mainmenu.ACFilterableMainMenuTreeNode;
import jp.nichicom.ac.component.mainmenu.ACMainMenuTreeNodePanel;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.lib.care.claim.calculation.QP001;
import jp.nichicom.ac.util.ACMessageBox;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.QkanSystemInformation;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.affair.qo.qo008.QO008;
import jp.or.med.orca.qkan.affair.qv.qv001.QV001;

/**
 * メインメニュー(QM002)
 */
public class QM002 extends QM002Event {
    /**
     * コンストラクタです。
     */
    public QM002() {
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
        // ※自身の遷移パラメータをチェックし、初期展開時の処理を行う
        // ※準備
        // 自身の遷移パラメータ格納用のレコード params を生成する。
        VRMap params = new VRHashMap();
        // params に自身の遷移パラメータを設定する。
        params = affair.getParameters();

        getMenuTree().setTransfer(this);
        // TODO メニューの有効項目を制限する場合、コメントアウトを外す
        // getMenuList().setFactoryAssistant(this);

        // 2008/01/07 [Masahiko Higuchi] add - begin バージョンアップお知らせ機能
        QM002HtmlPageReader reader = new QM002HtmlPageReader();
        // 別スレッドで読込み開始
        reader.start(getEditor());
        // 2008/01/07 [Masahiko Higuchi] add - end

        // ※メニューの展開
        // システムの「メニューツリー」を取得する。
        if (QkanSystemInformation.getInstance().getMenuTree() != null) {
            // データを取得できた場合 (nullでない場合)
            // 画面の「メニューツリー(menuTree)」に、取得した「メニューツリー」データを設定する。(メニューを構成する。)
            getMenuTree().setModel(
                    QkanSystemInformation.getInstance().getMenuTree());
            // ツリーのモードを設定
            getMenuTree().setTreeMode(
                    ACFilterableMainMenuTree.TREE_MODE_NODE_ONLY);
            // 詳細表示パネルを設定
            getMenuTree().setNodeViewer(getMenuList());
            // ルートを選択状態に設定
            getMenuTree().setSelectionRow(0);

        } else {
            // 取得できなかった場合 (nullの場合)
            // ログイン事業所の「メニューツリー」データ取得用のSQL文を取得する。
            // 取得したSQL文を発行する。
            VRMap loginProviderMap = new VRHashMap();

            loginProviderMap.setData("LOGIN_PROVIDER_ID", QkanSystemInformation
                    .getInstance().getLoginProviderID());

            VRList menuTreeList = null;
            menuTreeList = getDBManager().executeQuery(getSQL_GET_MENU_TREE(loginProviderMap));
            // 医療系非表示対応 fujihara.shin 2009.1.15 edit end

            // 取得件数が0件より多い場合
            if (menuTreeList.size() > 0) {
                // 取得したデータを、画面の「メニューツリー(menuTree)」格納用に変換する。

                // 画面の「メニューツリー(menuTree)」に、取得した「メニューツリー」データを設定する。(メニューを構成する。)
                getMenuTree().setModel(menuTreeList);
                // ツリーのモードを設定
                getMenuTree().setTreeMode(
                        ACFilterableMainMenuTree.TREE_MODE_NODE_ONLY);
                // システムの「メニューツリー」に、取得した「メニューツリー」データを設定する。
                // setMenuTree((取得したメニュー情報));
                QkanSystemInformation.getInstance().setMenuTree(menuTreeList);

                getMenuTree().setNodeViewer(getMenuList());
                // ルートを選択状態に
                getMenuTree().setSelectionRow(0);
            } else {
                // 予期せぬデータ用のトラップ
                // 取得件数が0件である場合
                VRList list = getDBManager().executeQuery(
                        getSQL_GET_M_MENU(null));

                // 画面の「メニューツリー(menuTree)」に、取得した「メニューツリー」データを設定する。(メニューを構成する。)
                if (list != null) {
                    getMenuTree().setModel(list);
                } else {
                    getMenuTree().setModel(new ArrayList());
                }
                // ツリーのモードを設定
                getMenuTree().setTreeMode(
                        ACFilterableMainMenuTree.TREE_MODE_NODE_ONLY);

                getMenuTree().setNodeViewer(getMenuList());
                // ルートを選択状態に
                getMenuTree().setSelectionRow(0);

            }
            // 何もしない。
        }

        // ※ウィンドウタイトル・業務ボタンバーの設定
        // 業務情報レコードを取得する。
        // ウィンドウタイトルに、取得レコードのKEY : WINDOW_TITLEのVALUEを設定する。
        // 業務ボタンバーのテキストに、取得レコードのKEY : AFFAIR_TITLEのVALUEを設定する。
        setAffairTitle("QM002");

        // 履歴情報の有無をチェック
        if (VRBindPathParser.has("TREE_HISTORY", params)) {

            // ノードからパスを特定し画面に展開
            TreePath path = null;
            TreePath selectPath = null;
            switch (getMenuTree().getTreeMode()) {
            case ACFilterableMainMenuTree.TREE_MODE_NODE_AND_SINGLE_LEAF:
                // TODO 考慮
                break;

            case ACFilterableMainMenuTree.TREE_MODE_NODE_ONLY:
                // ツリーで選択されているノードパスを取得
                path = new TreePath(
                        ((DefaultMutableTreeNode) params
                                .getData("TREE_HISTORY")).getParent());
                selectPath = new TreePath(
                        (DefaultMutableTreeNode) params.getData("TREE_HISTORY"));
                break;

            case ACFilterableMainMenuTree.TREE_MODE_NODE_AND_ALL_LEAF:
                // TODO 全てのノードを表示する場合の強制展開処理（ノードパスは問題ない）
                getMenuTree().expandPath(path);
                break;
            default:
                // ツリーで選択されているノードの親ノードのパスを取得
                // TreeNode parent =
                // ((DefaultMutableTreeNode)params.getData("TREE_HISTORY")).getParent();
                // TreePath paths = new
                // TreePath(((DefaultMutableTreeNode)params.getData("TREE_HISTORY")));
                path = new TreePath(
                        ((DefaultMutableTreeNode) params
                                .getData("TREE_HISTORY")).getParent());

                break;
            }

            // 画面遷移前に選択状態だったnodeを選択する。
            getMenuTree().setSelectionPath(path);
            ACFrame.getInstance().removeNowAffairParameter("TREE_HISTORY");
        }

        ACAffairInfo nowAffair = ACFrame.getInstance().getNowAffair();
        if (nowAffair != null) {
            // 初回起動だけはスプラッシュを表示させるため、自分自身のスプラッシュを切る
            nowAffair.setSplashed(false);
        }

        // Macの場合はツリーの高さを直接指定する
        final String osName = String.valueOf(System.getProperty("os.name"))
                .toLowerCase();
        if (osName.indexOf("mac") >= 0) {
            getMenuTree().setRowHeight(0);
            // getMenuTree().setRowHeight(48);
        }

        if (!getEditor().isVisible()) {
            getMenuTree().setPreferredSize(null);
        }

        getContents().revalidate();
        getContents().repaint();
        getContents().paintImmediately(getContents().getX(),
                getContents().getY(), getContents().getWidth(),
                getContents().getHeight());

    }

    /**
     * 「ログアウト」イベントです。
     * 
     * @param e
     *            イベント情報
     * @throws Exception
     *             処理例外
     */
    protected void logoutActionPerformed(ActionEvent e) throws Exception {
        // システムの、ログイン事業所メニュー情報をクリアする。
        QkanSystemInformation.getInstance().setMenuTree(null);

        ACAffairInfo info = ACFrame.getInstance().getBackAffair();
        if (info != null) {
            VRMap param = ACFrame.getInstance().getBackAffair().getParameters();
            if (param == null) {
                param = new VRHashMap();
                ACFrame.getInstance().getBackAffair().setParameters(param);
            }
            param.setData("STOP_AUTO_LOGIN", Boolean.TRUE);
        }

        ACFrame.getInstance().back();
    }

    public static void main(String[] args) {
        // デフォルトデバッグ起動
        ACFrame.getInstance().setFrameEventProcesser(
                new QkanFrameEventProcesser());
        QkanCommon.debugInitialize();
        VRMap param = new VRHashMap();
        // paramに渡りパラメタを詰めて実行することで、簡易デバッグが可能です。
        ACFrame.debugStart(new ACAffairInfo(QM002.class.getName(), param));
    }

    // 内部関数

    /**      
     * 
     */
    public void goAffair(TreeNode node) throws Exception {
        // TODO 自動生成されたメソッド・スタブ
        String nextAffair = "";
        String affairDistinctionItem = "";

        if (((DefaultMutableTreeNode) node).getUserObject() instanceof VRMap) {

            VRMap userObjectMap = (VRMap) ((DefaultMutableTreeNode) node)
                    .getUserObject();
            // ノードを基盤に退避
            ACFrame.getInstance().addNowAffairParameter("TREE_HISTORY", node);

            // 業務遷移用のパラメーターを格納する変数
            VRMap transferParameter = new VRHashMap();

            // 次画面のクラスを取得する。
            if (VRBindPathParser.has("NEXT_CLASS", userObjectMap)) {

                if (userObjectMap.getData("NEXT_CLASS") == null) {
                    ACMessageBox.show("機能制限版のため、選択された業務は実行できません。",
                            ACMessageBox.BUTTON_OK, ACMessageBox.ICON_STOP,
                            ACMessageBox.FOCUS_OK);
                    getMenuTree().setSelectionPath(
                            new TreePath((DefaultMutableTreeNode) node
                                    .getParent()));
                    return;
                }

                nextAffair = String
                        .valueOf(userObjectMap.getData("NEXT_CLASS"));

            } else {
                System.out.println("フィールドが存在しませんでした。");
                return;

            }

            // 遷移パラメーターを取得
            if (VRBindPathParser.has("PARAMETER_VALUE", userObjectMap)) {
                affairDistinctionItem = String.valueOf(userObjectMap
                        .getData("PARAMETER_VALUE"));

            } else {
                System.out.println("遷移先パラメーターの取得できませんでした。");

            }

            // 次画面に遷移するための情報を格納する。
            transferParameter.setData("NEXT_AFFAIR", affairDistinctionItem);

            ACAffairInfo affair = null;
            affair = new ACAffairInfo(nextAffair, transferParameter);
            ACFrame.getInstance().next(affair);
        }
    }

    /**
     * 「バージョン情報」イベントです。
     * 
     * @param e
     *            イベント情報
     * @throws Exception
     *             処理例外
     */
    protected void showVersionActionPerformed(ActionEvent e) throws Exception {
        new QV001().setVisible(true);
    }

    public void assistCreateMainMenuPanel(ACMainMenuTreeNodePanel panel,
            ACFilterableMainMenuTree tree, ACFilterableMainMenuTreeNode child,
            Object parameter) throws Exception {
        if (parameter instanceof VRMap) {
            VRMap childMap = (VRMap) parameter;
            // 次画面のクラス名を設定
            // 請求系の業務である場合はボタンを制御し操作不能にする
            String next = String.valueOf(VRBindPathParser.get("NEXT_CLASS",
                    childMap));
            if (QP001.class.getName().equals(next)
                    || QO008.class.getName().equals(next)) {
                panel.setFollowChildEnabled(true);
                panel.setEnabled(false);
            }
        }
    }

}
