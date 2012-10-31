package jp.nichicom.ac.component.mainmenu;

import javax.swing.tree.TreeNode;

/**
 * メインメニューツリーのノードを詳細に表示可能なことをあらわすインターフェースです。
 * <p>
 * Copyright (c) 2005 Nippon Computer Corpration. All Rights Reserved.
 * </p>
 * @author Masahiko Higuchi
 * @version 1.0 2006/02/04
 */
public interface ACMainMenuTreeNodeViewer {
    /**
     * メインメニューツリーで選択されたノードを選択します。
     * @param node 選択されたノード
     */
    public void setTreeNode(TreeNode node, ACFilterableMainMenuTree tree);

}
