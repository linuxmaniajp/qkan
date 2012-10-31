package jp.nichicom.ac.util.adapter;

import java.util.HashMap;
import java.util.List;

import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import jp.nichicom.ac.component.table.ACTableCellViewerCustomCell;
import jp.nichicom.ac.component.table.ACTableColumn;
import jp.nichicom.vr.bind.VRBindSource;
import jp.nichicom.vr.component.table.VRSortableTableModel;
import jp.nichicom.vr.component.table.VRTableColumn;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.adapter.VRTableModelAdapter;

/**
 * テーブルモデル用のアダプタです。
 * <p>
 * Copyright (c) 2005 Nippon Computer Corporation. All Rights Reserved.
 * </p>
 * 
 * @author Tozo Tanaka
 * @version 1.0 2005/12/01
 * @see VRSortableTableModel
 */
@SuppressWarnings("serial")
public class ACTableModelAdapter extends VRTableModelAdapter {

    private HashMap<Integer, ACTableModelAdapterColumnStatus> parsedConcatStatusCache = new HashMap<Integer, ACTableModelAdapterColumnStatus>();

    /**
     * コンストラクタです。
     */
    public ACTableModelAdapter() {
        super(new VRArrayList(), new String[] {});
    }

    /**
     * コンストラクタです。
     * 
     * @param columns カラム定義
     */
    public ACTableModelAdapter(String[] columns) {
        super(new VRArrayList(), columns);
    }

    /**
     * コンストラクタです。
     * 
     * @param adaptee アダプティーとなるバインドソース
     * @param columns カラム定義
     */
    public ACTableModelAdapter(VRBindSource adaptee, String[] columns) {
        super(adaptee, columns);
    }

    /**
     * カラム名が引数と一致する列番号を返します。
     * 
     * @param columnName カラム名
     * @return 列番号
     */
    public int getColumnIndex(String columnName) {
        if (columnName != null) {
            String[] columns = getColumns();
            if (columns != null) {
                int end = columns.length;
                for (int i = 0; i < end; i++) {
                    if (columnName.equals(columns[i])) {
                        return i;
                    }
                }
            }
        }
        return -1;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        Object obj = getParsedConcatStatusCache().get(new Integer(columnIndex));
        if ((obj instanceof ACTableModelAdapterColumnStatus)
                && (!((ACTableModelAdapterColumnStatus) obj).isEmpty())) {
            return ((ACTableModelAdapterColumnStatus) obj).getValueAt(rowIndex,
                    columnIndex, this);
        }
        // 結合設定がなされていないカラムならば標準の値取得メソッドを使用する
        return super.getValueAt(rowIndex, columnIndex);
    }

    /**
     * 指定行指定カラム名のデータを返します。
     * 
     * @param rowIndex 行番号
     * @param columnName カラム名
     * @return データ
     */
    public Object getValueAt(int rowIndex, String columnName) {
        Object obj = getData(rowIndex);
        if (obj instanceof VRBindSource) {
            return ((VRBindSource) obj).getData(columnName);
        }
        throw new IllegalArgumentException("未定義のカラム名[" + columnName
                + "]が指定されました。");
    }

    public boolean isCellEditable(int row, int column) {
        if (getTable() != null) {
            TableColumnModel model = getTable().getColumnModel();
            if (model != null) {
                int end = model.getColumnCount();
                for (int i = 0; i < end; i++) {
                    TableColumn tableColumn = model.getColumn(i);
                    if (column == tableColumn.getModelIndex()) {
                        if (tableColumn instanceof VRTableColumn) {
                            if (tableColumn instanceof ACTableColumn) {
                                // NCテーブルカラムの場合、カスタムセル設定も確認する。
                                List<ACTableColumn> cells = ((ACTableColumn) tableColumn)
                                        .getCustomCells();
                                if ((cells != null) && (cells.size() <= row)) {
                                    Object obj = cells.get(row);
                                    if (obj instanceof ACTableCellViewerCustomCell) {
                                        // カスタムセルの指定を優先する
                                        return ((ACTableCellViewerCustomCell) obj)
                                                .isEditable();
                                    }
                                }
                            }
                            VRTableColumn ncc = (VRTableColumn) tableColumn;
                            return ncc.isVisible() & ncc.isEditable();
                        }
                    }
                }
            }
        }
        return super.isCellEditable(row, column);
    }

    public void setColumns(String[] columns) {
        super.setColumns(columns);
        // キャッシュをクリア
        setParsedConcatStatusCache(new HashMap<Integer, ACTableModelAdapterColumnStatus>());
        parseConcatStatus();
    }

    /**
     * 結合設定の解析済みキャッシュ を返します。
     * <p>
     * キャッシュされるキー要素はそれぞれObject[]で構成されます。<br />
     * Object[]の要素はIntegerならばカラムの列番号、それ以外はリテラル文字と見なします。
     * </p>
     * 
     * @return 結合設定の解析済みキャッシュ
     */
    protected HashMap<Integer, ACTableModelAdapterColumnStatus> getParsedConcatStatusCache() {
        return parsedConcatStatusCache;
    }

    /**
     * 結合設定を解析します。
     */
    protected void parseConcatStatus() {
        HashMap<Integer, ACTableModelAdapterColumnStatus> map = new HashMap<Integer, ACTableModelAdapterColumnStatus>();
        String[] columns = getColumns();
        int end = columns.length;
        for (int i = 0; i < end; i++) {
            // すべてのカラムを走査する
            ACTableModelAdapterColumnStatus status = new ACTableModelAdapterColumnStatus(
                    columns[i]);
            if (status.size() > 0) {
                map.put(new Integer(i), status);
            } else {
                map.put(new Integer(i), null);
            }
        }
        // キャッシュに登録
        getParsedConcatStatusCache().putAll(map);
    }

    /**
     * 結合設定の解析済みキャッシュ を設定します。
     * 
     * @param parsedConcatStatusCache 結合設定の解析済みキャッシュ
     */
    protected void setParsedConcatStatusCache(HashMap<Integer, ACTableModelAdapterColumnStatus> parsedConcatStatusCache) {
        this.parsedConcatStatusCache = parsedConcatStatusCache;
    }

}
