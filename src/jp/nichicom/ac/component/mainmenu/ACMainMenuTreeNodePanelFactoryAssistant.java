package jp.nichicom.ac.component.mainmenu;

/**
 * メインメニュー要素パネル生成クラスの追加処理インターフェースです。
 * <p>
 * Copyright (c) 2005 Nippon Computer Corpration. All Rights Reserved.
 * </p>
 * 
 * @author Tozo Tanaka
 * @version 1.0 2006/03/30
 */
public interface ACMainMenuTreeNodePanelFactoryAssistant {
    /**
     * メインメニュー要素パネル生成に関する追加処理を実装します。
     * 
     * @param panel メインメニュー要素パネル
     * @param tree 親ツリー
     * @param child 対応するツリーノード
     * @param parameter 設定パラメタ
     * @throws Exception 処理例外
     */
    public void assistCreateMainMenuPanel(ACMainMenuTreeNodePanel panel,
            ACFilterableMainMenuTree tree, ACFilterableMainMenuTreeNode child,
            Object parameter) throws Exception;
}
