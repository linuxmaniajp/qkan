package jp.nichicom.ac.component.table;

import java.awt.Component;
import java.awt.Point;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ChangeEvent;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.text.JTextComponent;

import jp.nichicom.ac.component.style.ACComponentStylizer;
import jp.nichicom.vr.bind.VRBindSource;
import jp.nichicom.vr.component.table.VRSortableTableModelar;
import jp.nichicom.vr.component.table.VRTable;
import jp.nichicom.vr.component.table.VRTableColumnar;
import jp.nichicom.vr.util.adapter.VRBindSourceAdapter;

/**
 * スタイライザおよび行単位でデータをレンダラに渡す機能に対応したテーブルです。
 * <p>
 * Copyright (c) 2005 Nippon Computer Corporation. All Rights Reserved.
 * </p>
 * 
 * @author Tozo Tanaka
 * @version 1.0 2006/03/31
 * @see VRTable
 */
public class ACCellStylizableTable extends VRTable {

    private Component editorComponent;

    private boolean useRowValueToolTip = false;

    protected FocusListener cellFocusListener = new FocusAdapter(){
        public void focusLost(FocusEvent e) {
            Component c=e.getOppositeComponent();
            if(c!=null){
                if(c==ACCellStylizableTable.this){
                    return;
                }
                //テーブル以外にフォーカスが移った場合、編集状態を解除する
                editingStopped(new ChangeEvent(ACCellStylizableTable.this));
            }
        }
        
    };

    /**
     * コンストラクタです。
     * <p>
     * デフォルトデータモデル、デフォルト列モデル、およびデフォルト選択モデルで初期化される、デフォルトの Table を構築します。
     * </p>
     */
    public ACCellStylizableTable() {
        super();
    }

    /**
     * コンストラクタです。
     * <p>
     * DefaultTableModel を使って、空のセルの numRows と numColumns で Table
     * を構築します。列は、「A」、「B」、「C」といった形式の名前を持ちます。
     * </p>
     * 
     * @param numRows テーブルが保持する行数
     * @param numColumns テーブルが保持する列数
     */
    public ACCellStylizableTable(int numRows, int numColumns) {
        super(numRows, numColumns);
    }

    /**
     * コンストラクタです。
     * <p>
     * 2 次元配列 rowData の値を表示する JTable を、列名 columnNames で構築します。
     * </p>
     * 
     * @param rowData 新しいテーブルのデータ
     * @param columnNames 各列の名前
     */
    public ACCellStylizableTable(Object[][] rowData, Object[] columnNames) {
        super(rowData, columnNames);
    }

    /**
     * コンストラクタです。
     * <p>
     * データモデル dm、デフォルト列モデル、およびデフォルト選択モデルで初期化される JTable を構築します。
     * </p>
     * 
     * @param dm テーブルのデータモデル
     */
    public ACCellStylizableTable(TableModel dm) {
        super(dm);
    }

    /**
     * コンストラクタです。
     * <p>
     * データモデル dm、列モデル cm、およびデフォルト選択モデルで初期化される JTable を構築します。
     * </p>
     * 
     * @param dm テーブルのデータモデル
     * @param cm テーブルの列モデル
     */
    public ACCellStylizableTable(TableModel dm, TableColumnModel cm) {
        super(dm, cm);
    }

    /**
     * コンストラクタです。
     * <p>
     * データモデル dm、列モデル cm、および選択モデル sm で初期化される JTable を構築します。
     * </p>
     * 
     * @param dm テーブルのデータモデル
     * @param cm テーブルの列モデル
     * @param sm テーブルの行選択モデル
     */
    public ACCellStylizableTable(TableModel dm, TableColumnModel cm,
            ListSelectionModel sm) {
        super(dm, cm, sm);
    }

    /**
     * コンストラクタです。
     * <p>
     * Vectors の Vector の値を表示する JTable、つまり rowData を、列名 columnNames で構築します。
     * </p>
     * 
     * @param rowData 新しいテーブルのデータ
     * @param columnNames 各列の名前
     */
    public ACCellStylizableTable(Vector rowData, Vector columnNames) {
        super(rowData, columnNames);
    }

    /**
     * 指定番号のカラムを返します。
     * 
     * @param columnIndex カラム番号
     * @return カラム
     */
    public TableColumn getColumn(int columnIndex) {
        return getColumnModel().getColumn(columnIndex);
    }

    /**
     * ヘッダとして確保する高さを文字数 で返します。
     * @return ヘッダとして確保する高さを文字数
     */
    public int getHeaderRows(){
        if(getTableHeader() instanceof ACTableHeader){
            return ((ACTableHeader)getTableHeader()).getRows();
        }
        return 0; 
    }

    public String getToolTipText(MouseEvent me) {
        String tip = super.getToolTipText(me);
        if (isUseRowValueToolTip()&&( tip == null)) {
            //規定のポップアップがない場合は、保持要素を列挙する。
            Point pt = me.getPoint();
            int row = rowAtPoint(pt);
            if (row >= 0) {
                StringBuilder sb = new StringBuilder();
                int end = getColumnCount();
                for(int i=0; i<end; i++){
                    TableColumn clm=getColumn(i);
                    if(clm instanceof VRTableColumnar){
                        if(!((VRTableColumnar)clm).isVisible()){
                            continue;
                        }
                    }
                    sb.append(clm.getHeaderValue());
                    sb.append(" : ");
                    TableCellRenderer r=getCellRenderer(row, i);
                    if(r!=null){
                        Object val = getValueAt(row, i);
                        Component cmp=r.getTableCellRendererComponent(this, val, false, false, row, i);
                        if(cmp instanceof JLabel){
                            val = ((JLabel)cmp).getText();
                        }else if(cmp instanceof JTextComponent){
                            val = ((JTextComponent)cmp).getText();
                        }
                        if(val!=null){
                            sb.append(val);
                        }
                    }
                    if(i+1<end){
                        sb.append("<br>");
                    }
                }
                if(sb.length()>0){
                    sb.append("</html>");
                    tip = "<html>"+sb.toString();
                }
            }
        }
        return tip;
    }
    /**
     * 行データをツールチップ表示するか を返します。
     * @return 行データをツールチップ表示するか
     */
    public boolean isUseRowValueToolTip() {
        return useRowValueToolTip;
    }
    public Component prepareEditor(TableCellEditor editor, int row, int column) {

        ACComponentStylizer style = null;
        boolean valSet = false;
        Object value = null;
        TableColumn clm = getColumn(column);
        if (clm instanceof ACTableColumn) {
            if (((ACTableColumn) clm).isCellEditorStylizeOnRowValue()) {
                // 行データを渡す場合
                try {
                    value = getModelRowValue(row);
                    valSet = true;
                } catch (Exception ex) {
                    // 失敗した場合はvalSet = falseのまま
                }
            }
            // スタイル指定を退避
            style = ((ACTableColumn) clm).getCellEditorStylizer();
        }
        if (!valSet) {
            // データが確定していなければ標準のデータ取得方法に従う
            value = getValueAt(row, column);
        }

        // 標準のエディタ処理
        boolean isSelected = isCellSelected(row, column);
        Component comp = editor.getTableCellEditorComponent(this, value,
                isSelected, row, column);
        if (comp instanceof JComponent) {
            JComponent jComp = (JComponent) comp;
            if (jComp.getNextFocusableComponent() == null) {
                jComp.setNextFocusableComponent(this);
            }
        }

        if (style != null) {
            // スタイルを適用する場合は実行
            comp = style.stylize(comp, value);
        }
        
        editorComponent = comp;
        if(comp != null) {
            comp.addFocusListener(cellFocusListener);
        }
        
        return comp;

    }
    public Component prepareRenderer(TableCellRenderer renderer, int row,
            int column) {

        ACComponentStylizer style = null;
        boolean valSet = false;
        Object value = null;
        TableColumn clm = getColumn(column);
        if (clm instanceof ACTableColumn) {
            if (((ACTableColumn) clm).isCellRendererStylizeOnRowValue()) {
                // 行データを渡す場合
                try {
                    value = getModelRowValue(row);
                    valSet = true;
                } catch (Exception ex) {
                    // 失敗した場合はvalSet = falseのまま
                }
            }
            // スタイル指定を退避
            style = ((ACTableColumn) clm).getCellRendererStylizer();
        }
        if (!valSet) {
            // データが確定していなければ標準のデータ取得方法に従う
            value = getValueAt(row, column);
        }

        // 標準のレンダラ処理
        boolean isSelected = isCellSelected(row, column);
        boolean rowIsAnchor = (selectionModel.getAnchorSelectionIndex() == row);
        boolean colIsAnchor = (columnModel.getSelectionModel()
                .getAnchorSelectionIndex() == column);
        boolean hasFocus = (rowIsAnchor && colIsAnchor) && isFocusOwner();

        Component comp = renderer.getTableCellRendererComponent(this, value,
                isSelected, hasFocus, row, column);

        if (style != null) {
            // スタイルを適用する場合は実行
            comp = style.stylize(comp, value);
        }
        return comp;
    }

//    protected TableCellRenderer createHeaderRenderer(){
//        return new ACTableHeaderViewer();
//    }    
    
    public void removeEditor() {
        if(editorComponent!=null) {
            editorComponent.removeFocusListener(cellFocusListener);
            editorComponent = null;
        }
        super.removeEditor();
    }
    
    /**
     * ヘッダとして確保する高さを文字数 を設定します。
     * @param rows ヘッダとして確保する高さを文字数
     */
    public void setHeaderRows(int rows){
        if(getTableHeader() instanceof ACTableHeader){
            ((ACTableHeader)getTableHeader()).setRows(rows);
//            if(getParent()!=null){
//                getParent().invalidate();
//                getParent().repaint();
//            }
//            getTableHeader().updateUI();
//            getTableHeader().invalidate();
//            getTableHeader().repaint();
        }
    }
//    public void removeNotify(){
//        if((getModel()!=null)&&(getModel().getRowCount()>0)){
//            setModel(new DefaultTableModel());
//        }
//        super.removeNotify();
//    }
    /**
     * 行データをツールチップ表示するか を設定します。
     * @param useRowValueToolTip 行データをツールチップ表示するか
     */
    public void setUseRowValueToolTip(boolean useRowValueToolTip) {
        this.useRowValueToolTip = useRowValueToolTip;
    }
    
    
    protected JTableHeader createDefaultTableHeader() {
        return new ACTableHeader(columnModel);
    }
    /**
     * モデルの行データを返します。
     * 
     * @param row 行番号
     * @return 行データ
     * @throws Exception 取得に失敗した場合
     */
    protected Object getModelRowValue(int row) throws Exception {
        TableModel mdl = getModel();
        if (mdl instanceof VRSortableTableModelar) {
            return ((VRSortableTableModelar) mdl).getValueAt(row);
        } else {
            VRBindSource source = null;
            if (mdl instanceof VRBindSource) {
                // ソースなら直接取得
                source = (VRBindSource) mdl;
            } else if (mdl instanceof VRBindSourceAdapter) {
                // アダプタならアダプティーから取得
                source = ((VRBindSourceAdapter) mdl).getAdaptee();
            }
            return ((VRBindSource) source).getData(row);
        }
    }
    
}
