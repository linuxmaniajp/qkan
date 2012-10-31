package jp.nichicom.ac.component.table;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JSeparator;

import jp.nichicom.ac.component.table.event.ACCheckBoxTableColumnPopupMenuListener;
import jp.nichicom.vr.component.table.VRTablar;

/**
 * チェックボックステーブルカラム用のポップアップメニューです。
 * <p>
 * Copyright (c) 2005 Nippon Computer Corporation. All Rights Reserved.
 * </p>
 * 
 * @author Tozo Tanaka
 * @version 1.0 2006/03/31
 * @see JPopupMenu
 */
public class ACCheckBoxTableColumnPopupMenu extends JPopupMenu {
    private JMenuItem allCheckMenu = new JMenuItem("全選択(A)", 'A');
    private JMenuItem allUncheckMenu = new JMenuItem("全解除(N)", 'N');
    private JMenuItem cancelMenu = new JMenuItem("キャンセル(C)", 'C');
    private JSeparator cancelSeparater = new JSeparator();
    private Object checkedValue;
    private String columnName;
    private JMenuItem reverseCheckMenu = new JMenuItem("選択反転(R)", 'R');
    private JMenuItem sortMenu = new JMenuItem("ソート(S)", 'S');
    private VRTablar table;
    private Object uncheckedValue;

    /**
     * コンストラクタです。
     */
    public ACCheckBoxTableColumnPopupMenu() {
        super();
        initComponent();
    }

    /**
     * コンストラクタです。
     * 
     * @param table テーブル
     * @param columnName カラム名
     */
    public ACCheckBoxTableColumnPopupMenu(VRTablar table, String columnName) {
        this();
        setTable(table);
        setColumnName(columnName);
    }

    /**
     * コンストラクタです。
     * 
     * @param table テーブル
     * @param columnName カラム名
     * @param checkedValue チェック状態を表す値
     * @param uncheckedValue 非チェック状態を表す値
     */
    public ACCheckBoxTableColumnPopupMenu(VRTablar table, String columnName,
            Object checkedValue, Object uncheckedValue) {
        this(table, columnName);
        setCheckedValue(checkedValue);
        setUncheckedValue(uncheckedValue);
    }

    /**
     * ポップアップメニューイベントリスナを追加します。
     * 
     * @param l ポップアップメニューイベントリスナ
     */
    public void addPopupMenuListener(ACCheckBoxTableColumnPopupMenuListener l) {
        this.listenerList.add(ACCheckBoxTableColumnPopupMenuListener.class, l);
    }

    /**
     * 全選択メニュー を返します。
     * 
     * @return 全選択メニュー
     */
    public JMenuItem getAllCheckMenu() {
        return allCheckMenu;
    }

    /**
     * 全解除メニュー を返します。
     * 
     * @return 全解除メニュー
     */
    public JMenuItem getAllUncheckMenu() {
        return allUncheckMenu;
    }

    /**
     * キャンセルメニュー を返します。
     * 
     * @return キャンセルメニュー
     */
    public JMenuItem getCancelMenu() {
        return cancelMenu;
    }

    /**
     * キャンセル分割線 を返します。
     * 
     * @return キャンセル分割線
     */
    public JSeparator getCancelSeparater() {
        return cancelSeparater;
    }

    /**
     * チェック状態を表す値 を返します。
     * 
     * @return チェック状態を表す値
     */
    public Object getCheckedValue() {
        return checkedValue;
    }

    /**
     * カラム名 を返します。
     * 
     * @return カラム名
     */
    public String getColumnName() {
        return columnName;
    }

    /**
     * ドラッグイベントリスナを返します。
     * 
     * @return ドラッグイベントリスナ
     */
    public synchronized ACCheckBoxTableColumnPopupMenuListener[] getPopupMenuEventListeners() {
        return (ACCheckBoxTableColumnPopupMenuListener[]) (getListeners(ACCheckBoxTableColumnPopupMenuListener.class));
    }

    /**
     * 選択反転メニュー を返します。
     * 
     * @return 選択反転メニュー
     */
    public JMenuItem getReverseCheckMenu() {
        return reverseCheckMenu;
    }

    /**
     * ソートメニュー を返します。
     * 
     * @return ソートメニュー
     */
    public JMenuItem getSortMenu() {
        return sortMenu;
    }

    /**
     * テーブル を返します。
     * 
     * @return テーブル
     */
    public VRTablar getTable() {
        return table;
    }

    /**
     * 非チェック状態を表す値 を返します。
     * 
     * @return 非チェック状態を表す値
     */
    public Object getUncheckedValue() {
        return uncheckedValue;
    }

    /**
     * ポップアップメニューイベントリスナを削除します。
     * 
     * @param l ポップアップメニューイベントリスナ
     */
    public void removePopupMenuListener(ACCheckBoxTableColumnPopupMenuListener l) {
        this.listenerList.remove(ACCheckBoxTableColumnPopupMenuListener.class,
                l);
    }

    /**
     * 全選択メニュー を設定します。
     * 
     * @param allCheckMenu 全選択メニュー
     */
    public void setAllCheckMenu(JMenuItem allCheckMenu) {
        this.allCheckMenu = allCheckMenu;
    }

    /**
     * 全解除メニュー を設定します。
     * 
     * @param allUncheckMenu 全解除メニュー
     */
    public void setAllUncheckMenu(JMenuItem allUncheckMenu) {
        this.allUncheckMenu = allUncheckMenu;
    }

    /**
     * キャンセルメニュー を設定します。
     * 
     * @param cancelMenu キャンセルメニュー
     */
    public void setCancelMenu(JMenuItem cancelMenu) {
        this.cancelMenu = cancelMenu;
    }

    /**
     * キャンセル分割線 を設定します。
     * 
     * @param cancelSeparater キャンセル分割線
     */
    public void setCancelSeparater(JSeparator cancelSeparater) {
        this.cancelSeparater = cancelSeparater;
    }

    /**
     * チェック状態を表す値 を設定します。
     * 
     * @param checkedValue チェック状態を表す値
     */
    public void setCheckedValue(Object checkedValue) {
        this.checkedValue = checkedValue;
    }

    /**
     * カラム名 を設定します。
     * 
     * @param columnName カラム名
     */
    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    /**
     * 選択反転メニュー を設定します。
     * 
     * @param reverseCheckMenu 選択反転メニュー
     */
    public void setReverseCheckMenu(JMenuItem reverseCheckMenu) {
        this.reverseCheckMenu = reverseCheckMenu;
    }

    /**
     * ソートメニュー を設定します。
     * 
     * @param sortMenu ソートメニュー
     */
    public void setSortMenu(JMenuItem sortMenu) {
        this.sortMenu = sortMenu;
    }

    /**
     * テーブル を設定します。
     * 
     * @param table テーブル
     */
    public void setTable(VRTablar table) {
        this.table = table;
    }

    /**
     * 非チェック状態を表す値 を設定します。
     * 
     * @param uncheckedValue 非チェック状態を表す値
     */
    public void setUncheckedValue(Object uncheckedValue) {
        this.uncheckedValue = uncheckedValue;
    }

    /**
     * allCheckPopupMenuActionPerformedイベントを発火します。
     * 
     * @param e イベント情報
     */
    protected void fireAllCheckPopupMenuActionPerformed(ActionEvent e) {
        ACCheckBoxTableColumnPopupMenuListener[] listeners = getPopupMenuEventListeners();
        for (int i = 0; i < listeners.length; i++) {
            listeners[i].allCheckMenuActionPerformed(e);
        }
    }

    /**
     * allUncheckPopupMenuActionPerformedイベントを発火します。
     * 
     * @param e イベント情報
     */
    protected void fireAllUncheckPopupMenuActionPerformed(ActionEvent e) {
        ACCheckBoxTableColumnPopupMenuListener[] listeners = getPopupMenuEventListeners();
        for (int i = 0; i < listeners.length; i++) {
            listeners[i].allUncheckMenuActionPerformed(e);
        }
    }

    /**
     * cancelPopupMenuActionPerformedイベントを発火します。
     * 
     * @param e イベント情報
     */
    protected void fireCancelPopupMenuActionPerformed(ActionEvent e) {
        ACCheckBoxTableColumnPopupMenuListener[] listeners = getPopupMenuEventListeners();
        for (int i = 0; i < listeners.length; i++) {
            listeners[i].cancelMenuActionPerformed(e);
        }
    }

    /**
     * reverseCheckPopupMenuActionPerformedイベントを発火します。
     * 
     * @param e イベント情報
     */
    protected void fireReverseCheckPopupMenuActionPerformed(ActionEvent e) {
        ACCheckBoxTableColumnPopupMenuListener[] listeners = getPopupMenuEventListeners();
        for (int i = 0; i < listeners.length; i++) {
            listeners[i].reverseCheckMenuActionPerformed(e);
        }
    }

    /**
     * sortPopupMenuActionPerformedイベントを発火します。
     * 
     * @param e イベント情報
     */
    protected void fireSortPopupMenuActionPerformed(ActionEvent e) {
        ACCheckBoxTableColumnPopupMenuListener[] listeners = getPopupMenuEventListeners();
        for (int i = 0; i < listeners.length; i++) {
            listeners[i].sortMenuActionPerformed(e);
        }
    }

    /**
     * カラム名に対応したカラム番号を返します。
     * 
     * @return カラム番号
     */
    protected int getColumnIndex() {
        if (getTable() != null) {
            int end = getTable().getColumnCount();
            for (int i = 0; i < end; i++) {
                if (columnName.equals(getTable().getColumnName(i))) {
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * コンポーネントを初期化します。
     */
    protected void initComponent() {
        add(sortMenu);
        add(allCheckMenu);
        add(allUncheckMenu);
        add(reverseCheckMenu);
        add(cancelSeparater);
        add(cancelMenu);

        sortMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int column = getColumnIndex();
                if (getTable() instanceof VRTablar) {
                    ((VRTablar) table).sort(column);
                    fireSortPopupMenuActionPerformed(e);
                    getTable().revalidate();
                    getTable().repaint();
                    getTable().getTableHeader().revalidate();
                    getTable().getTableHeader().repaint();
                }
            }

        });

        allCheckMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int column = getColumnIndex();
                if (column > -1) {
                    int end = getTable().getRowCount();
                    for (int i = 0; i < end; i++) {
                        if (!getCheckedValue().equals(
                                getTable().getValueAt(i, column))) {
                            getTable().setValueAt(getCheckedValue(), i, column);
                        }
                    }
                    fireAllCheckPopupMenuActionPerformed(e);
                    getTable().revalidate();
                    getTable().repaint();
                }
            }

        });
        allUncheckMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int column = getColumnIndex();
                if (column > -1) {
                    int end = getTable().getRowCount();
                    for (int i = 0; i < end; i++) {
                        if (!getUncheckedValue().equals(
                                getTable().getValueAt(i, column))) {
                            getTable().setValueAt(getUncheckedValue(), i,
                                    column);
                        }
                    }
                    fireAllUncheckPopupMenuActionPerformed(e);
                    getTable().revalidate();
                    getTable().repaint();
                }
            }
        });
        reverseCheckMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int column = getColumnIndex();
                if (column > -1) {
                    int end = getTable().getRowCount();
                    for (int i = 0; i < end; i++) {
                        Object val = getTable().getValueAt(i, column);
                        if (getCheckedValue().equals(val)) {
                            getTable().setValueAt(getUncheckedValue(), i,
                                    column);
                        } else if (getUncheckedValue().equals(val)) {
                            getTable().setValueAt(getCheckedValue(), i, column);
                        }
                    }
                    fireReverseCheckPopupMenuActionPerformed(e);
                    getTable().revalidate();
                    getTable().repaint();
                }
            }
        });
    }
    
}
