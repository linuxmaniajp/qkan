/** TODO <HEAD> */
package jp.nichicom.vr.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.swing.table.AbstractTableModel;

/**
 * CSVファイルをテーブルモデルとして扱うアダプタクラスです。
 * <p>
 * Copyright (c) 2005 Nippon Computer Corporation. All Rights Reserved.
 * </p>
 * 
 * @author Tozo Tanaka
 * @version 1.0 2005/10/31
 * @see AbstractTableModel
 */
public class VRCSVFile extends AbstractTableModel {
    public static final String EUC_JP = "EUC-JP";

    public static final String ISO_2022_JP = "ISO-2022-JP";

    public static final String MS932 = "MS932";

    public static final String JIS = "JIS";

    public static final String SJIS = "SJIS";

    public static final String UTF8 = "UTF8";

    protected static final char COMMA = ',';

    protected static final String ONE_QUOTE = "\"";

    protected static final char QUOTE = '\"';

    protected static final String QUOTE_AND_COMMA = "\",";

    protected static final String TWO_QUOTE = "\"\"";

    private String[] column;

    private String encode;

    private String lineSeparator = null;

    private String path;

    private ArrayList rows = new ArrayList();

    /**
     * コンストラクタです。
     * 
     * @param path ファイルパス
     */
    public VRCSVFile(String path) {
        this(path, System.getProperty("file.encoding"));
    }

    /**
     * コンストラクタです。
     * 
     * @param path ファイルパス
     * @param encode エンコード
     */
    public VRCSVFile(String path, String encode) {
        setPath(path);
        setEncode(encode);
    }

    /**
     * 指定行に行データを挿入します。
     * 
     * @param index 行番号[0..n-1]
     * @param data 行データ
     */
    public void addRow(int index, List data) {
        getRows().add(index, data);
    }

    /**
     * 指定行に行データを挿入します。
     * 
     * @param index 行番号[0..n-1]
     * @param data 行データ
     */
    public void addRow(int index, String[] data) {
        addRow(index, Arrays.asList(data));
    }

    /**
     * 行データを追加します。
     * 
     * @param data 行データ
     */
    public void addRow(List data) {
        getRows().add(data);
    }

    /**
     * 行データを追加します。
     * 
     * @param data 行データ
     */
    public void addRow(String[] data) {
        addRow(new ArrayList(Arrays.asList(data)));
    }

    /**
     * 指定行に列データを追加します。
     * 
     * @param rowIndex 行番号[0..n-1]
     * @param colIndex 列番号[0..n-1]
     * @param data データ
     */
    public void addValue(int rowIndex, int colIndex, Object data) {
        getRow(rowIndex).add(colIndex, data);
    }

    /**
     * 指定行に列データを追加します。
     * 
     * @param rowIndex 行番号[0..n-1]
     * @param data 列データ
     */
    public void addValue(int rowIndex, Object data) {
        getRow(rowIndex).add(data);
    }

    /**
     * 読み込み可能であるかを返します。
     * 
     * @return 読み込み可能であるか
     */
    public boolean canRead() {
        return new File(getPath()).canRead();
    }

    /**
     * 書き込み可能であるかを返します。
     * 
     * @return 書き込み可能であるか
     */
    public boolean canWrite() {
        return new File(getPath()).canWrite();
    }

    /**
     * 保持データを消去します。
     */
    public void clear() {
        getRows().clear();
    }

    /**
     * 指定行の行データが存在するかを返します。
     * 
     * @param rowIndex 列番号[0..n-1]
     * @return 指定行の行データが存在するか
     */
    public boolean existsRow(int rowIndex) {
        return (rowIndex >= 0) && (getRowCount() > rowIndex);
    }

    /**
     * 指定行列のデータが存在するかを返します。
     * 
     * @param rowIndex 行番号[0..n-1]
     * @param colIndex 列番号[0..n-1]
     * @return 指定行列のデータが存在するか
     */
    public boolean existsValue(int rowIndex, int colIndex) {
        if (existsRow(rowIndex)) {
            if ((colIndex >= 0) && (getColumnCount(rowIndex) > colIndex)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 指定列のデータを全行分抽出して返します。
     * <p>
     * 指定列の存在しない行はnullを追加します。
     * </p>
     * 
     * @param columnIndex 列番号[0..n-1]
     * @return 列データ
     */
    public List getColumn(int columnIndex) {
        List list = new ArrayList();
        int end = getRowCount();
        for(int i=0; i<end; i++){
            List row=getRow(i);
            if(row.size()>columnIndex){
                list.add(row.get(columnIndex));
            }else{
                list.add(null);
            }
        }
        return list;
    }

    public Class getColumnClass(int columnIndex) {
        if (existsValue(0, columnIndex)) {
            return getRow(0).get(columnIndex).getClass();
        } else {
            return String.class;
        }
    }

    public int getColumnCount() {
        if (getColumnNames() != null) {
            return getColumnNames().length;
        }
        return getRow(0).size();
    }

    /**
     * 指定行の列データ数を返します。
     * 
     * @param index 行番号[0..n-1]
     * @return 保持列数
     */
    public int getColumnCount(int index) {
        return getRow(index).size();
    }

    public String getColumnName(int column) {
        return getColumnNames()[column];
    }

    /**
     * 列定義を返します。
     * 
     * @return 列定義
     */
    public String[] getColumnNames() {
        return this.column;
    }

    /**
     * ファイルエンコードを返します。
     * 
     * @return エンコード
     */
    public String getEncode() {
        return encode;
    }

    /**
     * 改行コード を返します。
     * <p>
     * デフォルト(null)ならばシステムの改行コードを使用します。
     * </p>
     * 
     * @return 改行コード
     */
    public String getLineSeparator() {
        return lineSeparator;
    }

    /**
     * ファイルパスを返します。
     * 
     * @return ファイルパス
     */
    public String getPath() {
        return path;
    }

    /**
     * 指定行の行データを返します。
     * 
     * @param index 行番号[0..n-1]
     * @return 行データ
     */
    public List getRow(int index) {
        return (List) getRows().get(index);
    }

    /**
     * 保持行数を返します。
     * 
     * @return 保持行数
     */
    public int getRowCount() {
        return getRows().size();
    }

    /**
     * 行データ集合を返します。
     * 
     * @return 行データ集合
     */
    public ArrayList getRows() {
        return this.rows;
    }

    /**
     * 指定行列のデータを返します。
     * 
     * @param rowIndex 行番号[0..n-1]
     * @param colIndex 列番号[0..n-1]
     * @return データ
     */
    public Object getValueAt(int rowIndex, int colIndex) {
        return getRow(rowIndex).get(colIndex);
    }

    /**
     * 指定行列のデータを返します。
     * 
     * @param rowIndex 行番号[0..n-1]
     * @param colIndex 列番号[0..n-1]
     * @return データ
     */
    public boolean getValueAtBoolean(int rowIndex, int colIndex) {
        return Boolean.valueOf(getValueAtString(rowIndex, colIndex))
                .booleanValue();
    }

    /**
     * 指定行列のデータを返します。
     * 
     * @param rowIndex 行番号[0..n-1]
     * @param colIndex 列番号[0..n-1]
     * @return データ
     */
    public double getValueAtDouble(int rowIndex, int colIndex) {
        return Double.valueOf(getValueAtString(rowIndex, colIndex))
                .doubleValue();
    }

    /**
     * 指定行列のデータを返します。
     * 
     * @param rowIndex 行番号[0..n-1]
     * @param colIndex 列番号[0..n-1]
     * @return データ
     */
    public int getValueAtInteger(int rowIndex, int colIndex) {
        return Integer.valueOf(getValueAtString(rowIndex, colIndex)).intValue();
    }

    /**
     * 指定行列のデータを返します。
     * 
     * @param rowIndex 行番号[0..n-1]
     * @param colIndex 列番号[0..n-1]
     * @return データ
     */
    public String getValueAtString(int rowIndex, int colIndex) {
        return String.valueOf(getValueAt(rowIndex, colIndex));
    }

    /**
     * 指定行にデータが存在するかを返します。
     * 
     * @param rowIndex 行番号[0..n-1]
     * @param data データ
     * @return データ位置番号。該当しなければ-1
     */
    public int indexOf(int rowIndex, Object data) {
        return getRow(rowIndex).indexOf(data);
    }

    /**
     * 保持データは空であるかを返します。
     * 
     * @return 保持データは空であるか
     */
    public boolean isEmpty() {
        return getRows().isEmpty();
    }

    /**
     * 指定行の行データは空であるかを返します。
     * 
     * @param index 行番号[0..n-1]
     * @return 指定行の行データは空であるか
     */
    public boolean isEmpty(int index) {
        return getRow(index).isEmpty();
    }

    /**
     * 指定のパスにファイルが存在するかを返します。
     * 
     * @return 指定のパスにファイルが存在するか
     */
    public boolean isFile() {
        return new File(getPath()).isFile();
    }

    /**
     * CSVファイルを読み込みます。
     * 
     * @param hasHeader 開始行をヘッダとして解釈するか
     * @throws IOException 読み込みエラー
     */
    public void read(boolean hasHeader) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(
                new FileInputStream(getPath()), encode));

        // クォートでくくっているか
        final int NONE = 0;
        final int QUOTING = 1;
        final int QUOTED = 2;
        int quoteStatus = NONE;
        // クォートをエスケープしたか
        boolean quoteEscaped = false;
        
        final String LINE_SEPARATOR = System.getProperty("line.separator");
        

        StringBuilder quoteHead = new StringBuilder();
        ArrayList row = new ArrayList();
        String line;
        int cellBeginPos = 0;
        int cellEndPos = 0;
        while ((line = br.readLine()) != null) {
            char[] arr = line.toCharArray();
            int len = arr.length;
            for (int i = 0; i < len; i++) {
                if (arr[i] == QUOTE) {
                    switch (quoteStatus) {
                    case NONE:
                        // クォート以降が切り出し対象
                        cellBeginPos = i + 1;
                        quoteStatus = QUOTING;
                        quoteEscaped = false;
                        break;
                    case QUOTING:
                        // クォート中のクォート → 直前までが切り出し対象
                        cellEndPos = i;
                        quoteStatus = QUOTED;
                        break;
                    case QUOTED:
                        // クォート終了と思ったのに続けてクォート → クォートエスケープ
                        cellEndPos = i;
                        quoteStatus = QUOTING;
                        quoteEscaped = true;
                        break;
                    }
                } else if (arr[i] == COMMA) {
                    switch (quoteStatus) {
                    case NONE:
                        // クォートなしの状態でカンマ → 直前までが切り出し対象
                        cellEndPos = i;
                        row.add(line.substring(cellBeginPos, cellEndPos));
                        cellBeginPos = i + 1;
                        break;
                    case QUOTING:
                        // クォート中 → スキップ
                        break;
                    case QUOTED:
                        // クォート済みの状態でカンマ → クォートの直前までが切り出し対象

                        quoteHead.append(line.substring(cellBeginPos, cellEndPos));
                        if (quoteEscaped) {
                            // クォートエスケープを行った → [""]を["]に置換
                            row.add(quoteHead.toString().replaceAll(TWO_QUOTE,
                                    ONE_QUOTE));
                            quoteEscaped = false;
                        } else {
                            row.add(quoteHead.toString());
                        }
                        cellBeginPos = i + 1;
                        quoteStatus = NONE;
                        if(quoteHead.length()>0){
                            quoteHead = new StringBuilder();
                        }
                        break;
                    }
                }
            }

            // 改行
            if (quoteStatus == QUOTING) {
                // クォート中なので次行へまたがらせる
                quoteHead.append(line.substring(cellBeginPos));
                quoteHead.append(LINE_SEPARATOR);
            } else {
                // 列終了
                if (cellBeginPos>cellEndPos) {
                    quoteHead.append(line.substring(cellBeginPos));
                }else{
                    // 最後のセルを追加
                    quoteHead.append(line.substring(cellBeginPos, cellEndPos));
                }
                if (quoteEscaped) {
                    // クォートエスケープを行った → [""]を["]に置換
                    row.add(quoteHead.toString().replaceAll(TWO_QUOTE, ONE_QUOTE));
                    quoteEscaped = false;
                } else {
                    row.add(quoteHead.toString());
                }

                if(quoteHead.length()>0){
                    quoteHead =  new StringBuilder();
                }
                quoteStatus = NONE;

                if (hasHeader) {
                    // 開始行はヘッダ
                    int size = row.size();
                    String[] head = new String[size];
                    System.arraycopy(row.toArray(), 0, head, 0, size);
                    setColumnNames(head);
                    hasHeader = false;
                } else {
                    addRow(row);
                }
                row = new ArrayList();
            }
            cellBeginPos = 0;
            cellEndPos = 0;
        }
        if(quoteHead.length()>0){
            row.add(quoteHead.toString());
            addRow(row);
        }
        br.close();
    }

    /**
     * 指定行を削除します。
     * 
     * @param index 行番号[0..n-1]
     */
    public void removeRow(int index) {
        getRows().remove(index);
    }

    /**
     * 列定義を設定します。
     * 
     * @param column 列定義
     */
    public void setColumnNames(String[] column) {
        this.column = column;
    }

    /**
     * ファイルエンコードを設定します。
     * 
     * @param encode エンコード
     */
    public void setEncode(String encode) {
        this.encode = encode;
    }

    /**
     * 改行コード を設定します。
     * <p>
     * デフォルト(null)ならばシステムの改行コードを使用します。
     * </p>
     * 
     * @param lineSeparator 改行コード
     */
    public void setLineSeparator(String lineSeparator) {
        this.lineSeparator = lineSeparator;
    }

    /**
     * ファイルパスを設定します。
     * 
     * @param path ファイルパス
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * 指定行列のデータを設定します。行方向は必要に応じて拡張されます。
     * 
     * @param data データ
     * @param rowIndex 行番号[0..n-1]
     * @param colIndex 列番号[0..n-1]
     */
    public void setValueAt(Object data, int rowIndex, int colIndex) {
        List row = getRow(rowIndex);
        if (row.size() > colIndex) {
            row.set(colIndex, data);
        } else {
            // 範囲外なので拡張する
            int addSize = colIndex - row.size();
            Object[] addData = new Object[addSize + 1];
            for (int i = 0; i < addSize; i++) {
                addData[i] = "";
            }
            addData[addSize] = data;
            row.addAll(Arrays.asList(addData));
        }
    }

    /**
     * CSVファイルを書き出します。
     * 
     * @param putHeader ヘッダを付加するか
     * @param canOverride 上書きを許可するか
     * @throws IOException 書き込みエラー
     */
    public void write(boolean putHeader, boolean canOverride)
            throws IOException {
        File f = new File(getPath());
        if (!canOverride) {
            if (f.exists()) {
                throw new IOException("既にファイルが存在します。");
            }
        }

        // 書き出し
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(f), encode));
            bw.write(createWriteData(putHeader, canOverride));
        } finally {
            if (bw != null) {
                bw.close();
            }
        }
    }

    /**
     * 行列データをCSV書式化してStringBuilderに追加します。
     * <p>
     * 特定行列の出力を加工したい場合にoverrideします。
     * </p>
     * 
     * @param sb 追加先
     * @param value 値
     * @param rowIndex 行番号[0..n]
     * @param columnIndex 列番号[0..n]
     */
    protected void appendValue(StringBuilder sb, Object value, int rowIndex, int columnIndex) {
        appendQuoted(sb, value);
    }
    /**
     * オブジェクトの前後にクォートと最後にカンマを追加してバッファに追加します。
     * <p>
     * オブジェクト内のクォートはクォートを重ねてエスケープされます。
     * </p>
     * @param sb 追加先
     * @param value 値
     */
    protected void appendQuoted(StringBuilder sb, Object value){
        sb.append(ONE_QUOTE);
        sb.append(String.valueOf(value).replaceAll(ONE_QUOTE, TWO_QUOTE));
        sb.append(QUOTE_AND_COMMA);
    }
    
    /**
     * 行データをCSV書式化してStringBuilderに追加します。
     * <p>
     * 特定行の出力を加工したい場合にoverrideします。
     * </p>
     * 
     * @param row 行データ
     * @param sb 追加先
     * @param rowIndex 行番号[0..n]
     */
    protected void appendRow(List row, StringBuilder sb, int rowIndex) {
        Iterator colIt = row.iterator();
        if (!colIt.hasNext()) {
            return;
        }

        int columnIndex = 0;
        do {
            Object col = colIt.next();
            appendValue(sb, col, rowIndex, columnIndex++);
        } while (colIt.hasNext());

        // 末尾の','を削る
        sb.deleteCharAt(sb.length() - 1);

        sb.append(lineSeparator);
    }
        
    /**
     * CSV形式の文字列を返します。
     * 
     * @param putHeader ヘッダを付加するか
     * @param canOverride 上書きを許可するか
     * @throws IOException 書き込みエラー
     */
    protected String createWriteData(boolean putHeader, boolean canOverride) {
        if (lineSeparator == null) {
            // 遅延定数化
            lineSeparator = System.getProperty("line.separator");
        }
        StringBuilder sb = new StringBuilder();

        int rowIndex = 0;
        if (putHeader && (getColumnNames() != null)) {
            // 先にヘッダを出力
            appendRow(Arrays.asList(getColumnNames()), sb, rowIndex++);
        }

        // 保持行を走査して出力
        Iterator rowIt = getRows().iterator();
        while (rowIt.hasNext()) {
            Object row = rowIt.next();
            if (row instanceof List) {
                appendRow((List) row, sb, rowIndex++);
            }
        }
        return sb.toString();
    }

}