package jp.nichicom.ac.component.mainmenu;

import javax.swing.JScrollPane;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;

import jp.nichicom.ac.container.ACPanel;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.layout.VRLayout;
import jp.nichicom.vr.util.VRMap;

/**
 * メインメニューツリーパネル生成クラスです。
 * <p>
 * Copyright (c) 2006 Nippon Computer Corpration. All Rights Reserved.
 * </p>
 * 
 * @author Masahiko Higuchi
 * @version 1.0 2006/02/04
 */
public class ACMainMenuTreeNodePanelFactory extends JScrollPane implements
        ACMainMenuTreeNodeViewer {
    private ACPanel contents = new ACPanel();
    private ACMainMenuTreeNodePanelFactoryAssistant factoryAssistant;

    /**
     * 追加処理インターフェース を返します。
     * 
     * @return 追加処理インターフェース
     */
    public ACMainMenuTreeNodePanelFactoryAssistant getFactoryAssistant() {
        return factoryAssistant;
    }

    /**
     * 追加処理インターフェース を設定します。
     * 
     * @param factoryAssistant 追加処理インターフェース
     */
    public void setFactoryAssistant(
            ACMainMenuTreeNodePanelFactoryAssistant factoryAssistant) {
        this.factoryAssistant = factoryAssistant;
    }

    /**
     * Creates an empty (no viewport view) <code>JScrollPane</code> where both
     * horizontal and vertical scrollbars appear when needed.
     */
    public ACMainMenuTreeNodePanelFactory() {
        super();
        initComponent();
    }

    /**
     * コンポーネントを初期化します。
     */
    protected void initComponent() {
        setViewportView(contents);
    }

    public void setTreeNode(TreeNode node, ACFilterableMainMenuTree tree) {
        // ノードが渡された

        contents.removeAll();

        if (node instanceof ACFilterableMainMenuTreeNode) {
            // 選択されたnodeの親に当たるnodeを取得する。
            ACFilterableMainMenuTreeNode parent = (ACFilterableMainMenuTreeNode) node;

            int end = parent.getRealChildCount();
            for (int i = 0; i < end; i++) {
                ACFilterableMainMenuTreeNode child = (ACFilterableMainMenuTreeNode) parent
                        .getRealChildAt(i);

                ACMainMenuTreeNodePanel viewr = null;
                try {
                    viewr = createElement(tree, child,
                            ((DefaultMutableTreeNode) child).getUserObject());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

                if (viewr != null) {
                    contents.add(viewr, VRLayout.NORTH);
                }

            }
            // 再描画
            revalidate();

        }

    }

    /**
     * メニュー要素パネルを生成します。
     * 
     * @param tree 親ツリー
     * @param child 対応するツリーノード
     * @param parameter 設定パラメタ
     * @return メニュー要素パネル
     * @throws Exception 処理例外
     */
    protected ACMainMenuTreeNodePanel createElement(
            ACFilterableMainMenuTree tree, ACFilterableMainMenuTreeNode child,
            Object parameter) throws Exception {
        ACMainMenuTreeNodePanel viewer = new ACMainMenuTreeNodePanel();
        // childのデータを解析してviewerを設定する
        if (parameter instanceof VRMap) {
            VRMap childMap = (VRMap) parameter;
            ACMainMenuTreeExecuteAffair hm = tree.getTransfer();
            viewer.setTranceferAffair(hm);
            // ツールチップを追加
            if (VRBindPathParser.has("TOOLTIP_TEXT", childMap)) {
                if (childMap.getData("TOOLTIP_TEXT") != null) {
                    viewer.setExplanationLabelText(String.valueOf(childMap
                            .getData("TOOLTIP_TEXT")));
                }
            }
            // キャプションを追加
            if (VRBindPathParser.has("CAPTION", childMap)) {
                viewer.setAffairButtonText(String.valueOf(childMap
                        .getData("CAPTION")));
            }
            // ボタンアイコンを追加
            if (VRBindPathParser.has("ICON", childMap)) {
                if (childMap.getData("ICON") != null) {
                    viewer.setAffairButtonIconPath(String.valueOf(childMap
                            .getData("ICON")));
                }
            }

            // 業務と判断しCAPTIONを説明と表示
            viewer.setButtonText("説明");

            // 次画面のクラス名を設定
            if (VRBindPathParser.has("NEXT_CLASS", childMap)) {
                viewer.setNextAffair(childMap.getData("NEXT_CLASS"));
            }

            // 画面遷移用パラメーター設定
            if (VRBindPathParser.has("PARAMETER_VALUE", childMap)) {
                viewer.setNextParameter(childMap.getData("PARAMETER_VALUE"));
            }

            viewer.setNode(child);
            viewer.setTree(tree);

        }
        if (getFactoryAssistant() != null) {
            // 追加処理
            getFactoryAssistant().assistCreateMainMenuPanel(viewer, tree,
                    child, parameter);
        }
        return viewer;
    }

}