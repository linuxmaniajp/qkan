package jp.nichicom.ac.component.mainmenu;

import javax.swing.tree.TreeNode;
/**
 * ACMainMenuTreeFilterableNodeです。
 * <p>
 * Copyright (c) 2006 Nippon Computer Corpration. All Rights Reserved.
 * </p>
 * @author Masahiko Higuchi
 * @version 1.0 2006/02/04
 */
public interface ACFilterableMainMenuTreeNode extends TreeNode {
    
    /**
     * 子の数をフィルタリングせずに取得します。
     * @return フィルタリングしない子の数
     */
    public int getRealChildCount();
    
    /**
     * フィルタリングせずに指定番号の子ノードを返します。
     * @param childIndex 子の番号
     * @return フィルタリングしない指定番号の子ノード
     */
    public TreeNode getRealChildAt(int childIndex);
}
