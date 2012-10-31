package jp.nichicom.ac.component;

import java.awt.Component;

import javax.swing.JList;

/**
 * フォーカス表示を複数のリスト間で共有可能なリストセルレンダラです。
 * <p>
 * Copyright (c) 2005 Nippon Computer Corpration. All Rights Reserved.
 * </p>
 * 
 * @author Tozo Tanaka
 * @version 1.0 2006/03/31
 */
public class ACFocusSharedListCellRenderer extends
        ACFocusBrighterListCellRenderer {
    private Component sharedFocusedOwner;

    /**
     * 共有フォーカスを所持しているコンポーネント を返します。
     * 
     * @return 共有フォーカスを所持しているコンポーネント
     */
    public Component getSharedFocusedOwner() {
        return sharedFocusedOwner;
    }

    /**
     * 共有フォーカスを所持しているコンポーネント を設定します。
     * 
     * @param sharedFocusedOwner 共有フォーカスを所持しているコンポーネント
     */
    public void setSharedFocusedOwner(Component sharedFocusedOwner) {
        this.sharedFocusedOwner = sharedFocusedOwner;
    }

    /**
     * コンストラクタです。
     */
    public ACFocusSharedListCellRenderer() {
        super();
    }

    public Component getListCellRendererComponent(JList list, Object value,
            int index, boolean isSelected, boolean cellHasFocus) {

        if ((list != null) && list.hasFocus()) {
            // このリストにフォーカスがあるため、共有フォーカスリストを更新する
            if (list != sharedFocusedOwner) {
                Component oldSelList = sharedFocusedOwner;
                sharedFocusedOwner = list;
                if (oldSelList != null) {
                    // フォーカス対象状態が更新されたため再描画させる
                    oldSelList.repaint();
                }
            }
            // 淡白表示とする
            setLostFocusColorMode(ACFocusBrighterListCellRenderer.COLOR_BRIGHTER);
        } else {
            // リストがフォーカスを有していない場合
            if (list == sharedFocusedOwner) {
                // 共有のフォーカスリストの場合(最後に選択されていたもの)
                // 淡白表示とする
                setLostFocusColorMode(ACFocusBrighterListCellRenderer.COLOR_BRIGHTER);
            } else {
                // 共有のフォーカスリストではない場合
                // 未選択色とする
                setLostFocusColorMode(ACFocusBrighterListCellRenderer.COLOR_CLEAR);
            }
        }

        return super.getListCellRendererComponent(list, value, index,
                isSelected, cellHasFocus);

    }
}
