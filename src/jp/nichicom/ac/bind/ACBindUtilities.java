package jp.nichicom.ac.bind;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.bind.VRBindSource;
import jp.nichicom.vr.bind.VRBindable;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;

/**
 * バインド関連の汎用メソッドを集めたクラスです。
 * <p>
 * Copyright (c) 2005 Nippon Computer Corporation. All Rights Reserved.
 * </p>
 * 
 * @author Tozo Tanaka
 * @version 1.0 2005/12/01
 * @see VRBindable
 * @see VRBindSource
 */
public class ACBindUtilities {
    private static ACBindUtilities singleton;

    /**
     * インスタンスを取得します。
     * 
     * @deprecated 直接staticメソッドを呼んでください。
     * @return インスタンス
     */
    public static ACBindUtilities getInstance() {
        if (singleton == null) {
            singleton = new ACBindUtilities();
        }
        return singleton;
    }

    /**
     * コンストラクタです。
     * <p>
     * Singleton Pattern
     * </p>
     */
    protected ACBindUtilities() {
    }

    /**
     * バインドパスfromKeyの値をバインドパスtoKeyの値として転記します。
     * 
     * @param array 操作対象
     * @param fromKey 複写元のバンドパス
     * @param toKey 転記先のバインドパス
     * @throws Exception 処理例外
     */
    public static void copyBindPath(VRList array, String fromKey, String toKey)
            throws Exception {
        Iterator it = array.iterator();
        while (it.hasNext()) {
            VRMap row = (VRMap) it.next();
            VRBindPathParser
                    .set(toKey, row, VRBindPathParser.get(fromKey, row));
        }
    }

    /**
     * バインドパスfromKeyの値をバインドパスtoKeyの値として転記します。
     * <p>
     * 移動後にバインドパスfromKeyのキーおよび値は除去されます。
     * </p>
     * 
     * @param array 操作対象
     * @param fromKeys 移動元のバンドパス配列
     * @param toKeys 移動先のバインドパス配列
     * @throws Exception 処理例外
     */
    public static void copyBindPath(VRList array, String[] fromKeys,
            String[] toKeys) throws Exception {
        int end = fromKeys.length;
        for (int i = 0; i < end; i++) {
            copyBindPath(array, fromKeys[i], toKeys[i]);
        }
    }

    /**
     * 指定キーフィールドが一致する行マップを返します。
     * 
     * @param array データ集合
     * @param fieldName 比較フィールド名
     * @param source 比較元ソース
     * @throws ParseException 解析例外
     * @return 指定キーフィールドが一致する行マップ
     */
    public static VRMap getMatchRowFromMap(VRList array, String fieldName,
            VRMap source) throws ParseException {
        if (VRBindPathParser.has(fieldName, source)) {
            return getMatchRowFromValue(array, fieldName, VRBindPathParser.get(
                    fieldName, source));
        }
        return null;
    }

    /**
     * 指定キーフィールドが一致する行マップを返します。
     * 
     * @param array データ集合
     * @param fieldName 比較フィールド名
     * @param source 比較元ソース
     * @throws ParseException 解析例外
     * @return 指定キーフィールドが一致する行マップ
     */
    public static VRMap getMatchRowFromValue(VRList array, String fieldName,
            Object source) throws ParseException {
        int index = getMatchIndexFromValue(array, fieldName, source);
        if (index < 0) {
            return null;
        } else {
            return (VRMap) array.getData(index);
        }
    }

    /**
     * 指定キーフィールドが一致する行番号を返します。
     * 
     * @param array データ集合
     * @param fieldName 比較フィールド名
     * @param source 比較元ソース
     * @throws ParseException 解析例外
     * @return 指定キーフィールドが一致する行番号
     */
    public static int getMatchIndexFromMap(VRList array, String fieldName,
            VRMap source) throws ParseException {
        if (VRBindPathParser.has(fieldName, source)) {
            return getMatchIndexFromValue(array, fieldName, VRBindPathParser
                    .get(fieldName, source));
        }
        return -1;
    }

    /**
     * 指定キーフィールドが一致する行データの集合を返します。
     * 
     * @param array データ集合
     * @param fieldName 比較フィールド名
     * @param source 比較元ソース
     * @throws ParseException 解析例外
     * @return 一致した要素集合
     */
    public static List getMatchListFromValue(VRList array, String fieldName,
            Object source) throws ParseException {
        List result = new VRArrayList();
        int findPos = -1;
        while(true){
            findPos = getMatchIndexFromValue(array, fieldName, source, findPos+1);
            if(findPos>=0){
                result.add(array.get(findPos));
            }else{
                break;
            }
        }
        return result;
    }

    /**
     * 指定キーフィールドが一致する行番号を返します。
     * 
     * @param array データ集合
     * @param fieldName 比較フィールド名
     * @param source 比較元ソース
     * @param beginIndex 検索開始位置
     * @throws ParseException 解析例外
     * @return 指定キーフィールドが一致する行番号
     */
    public static int getMatchIndexFromValue(VRList array, String fieldName,
            Object source, int beginIndex) throws ParseException {
        int end = array.size();

        if (source == null) {
            for (int i = beginIndex; i < end; i++) {
                VRMap row = (VRMap) array.getData(i);
                if (VRBindPathParser.get(fieldName, row) == null) {
                    return i;
                }
            }

        } else {
            for (int i = beginIndex; i < end; i++) {
                VRMap row = (VRMap) array.getData(i);
                if (source.equals(VRBindPathParser.get(fieldName, row))) {
                    return i;
                }
            }
        }
        return -1;
    }
    /**
     * 指定キーフィールドが一致する行番号を返します。
     * 
     * @param array データ集合
     * @param fieldName 比較フィールド名
     * @param source 比較元ソース
     * @throws ParseException 解析例外
     * @return 指定キーフィールドが一致する行番号
     */
    public static int getMatchIndexFromValue(VRList array, String fieldName,
            Object source) throws ParseException {
        return getMatchIndexFromValue(array, fieldName, source, 0 );
    }

    /**
     * キーと値の関係にある2つの列を持つMapを集めて並列化されたListに対し、キー列の値をキーに値列の値を値として直列化したMapの集合を返します。
     * 
     * @param src 変換元
     * @param groupingConditionFieldNames グループ化条件列名
     * @param keyFieldName キーにあたるデータを格納する列名
     * @param valueFieldName 値にあたるデータを格納する列名
     * @param keyFieldValues キー列の値として想定される、直列化対象の列名
     * @param valueFieldDefaultValue 直列化対象の列に適用する初期値
     * @throws Exception 処理例外
     * @return 変換結果
     * @deprecated getSeriesedKeyListWithoutGroupFieldを使用してください。
     */
    public static VRList getSeriesedKeyList(VRList src,
            final String[] groupingConditionFieldNames,
            final String keyFieldName, final String valueFieldName,
            final String[] keyFieldValues, final Object valueFieldDefaultValue)
            throws Exception {
        return getSeriesedKeyListWithoutGroupField(src,
                groupingConditionFieldNames, keyFieldName, valueFieldName,
                keyFieldValues, valueFieldDefaultValue);

    }

    /**
     * キーと値の関係にある2つの列を持つMapを集めて並列化されたListに対し、キー列の値をキーに値列の値を値として直列化したMapの集合を返します。
     * <p>
     * グループ化のキーとなるフィールドは、整形後の列に付加されません。
     * </p>
     * 
     * @param src 変換元
     * @param groupingConditionFieldNames グループ化条件列名
     * @param keyFieldName キーにあたるデータを格納する列名
     * @param valueFieldName 値にあたるデータを格納する列名
     * @param keyFieldValues キー列の値として想定される、直列化対象の列名
     * @param valueFieldDefaultValue 直列化対象の列に適用する初期値
     * @throws Exception 処理例外
     * @return 変換結果
     */
    public static VRList getSeriesedKeyListWithoutGroupField(VRList src,
            final String[] groupingConditionFieldNames,
            final String keyFieldName, final String valueFieldName,
            final String[] keyFieldValues, final Object valueFieldDefaultValue)
            throws Exception {
        return getSeriesedKeyList(src, groupingConditionFieldNames,
                keyFieldName, valueFieldName, keyFieldValues,
                valueFieldDefaultValue, false);
    }

    /**
     * キーと値の関係にある2つの列を持つMapを集めて並列化されたListに対し、キー列の値をキーに値列の値を値として直列化したMapの集合を返します。
     * <p>
     * グループ化のキーとなるフィールドも、すべての列に付加します。
     * </p>
     * 
     * @param src 変換元
     * @param groupingConditionFieldNames グループ化条件列名
     * @param keyFieldName キーにあたるデータを格納する列名
     * @param valueFieldName 値にあたるデータを格納する列名
     * @param keyFieldValues キー列の値として想定される、直列化対象の列名
     * @param valueFieldDefaultValue 直列化対象の列に適用する初期値
     * @throws Exception 処理例外
     * @return 変換結果
     */
    public static VRList getSeriesedKeyListWithGroupField(VRList src,
            final String[] groupingConditionFieldNames,
            final String keyFieldName, final String valueFieldName,
            final String[] keyFieldValues, final Object valueFieldDefaultValue)
            throws Exception {
        return getSeriesedKeyList(src, groupingConditionFieldNames,
                keyFieldName, valueFieldName, keyFieldValues,
                valueFieldDefaultValue, true);
    }

    /**
     * キーと値の関係にある2つの列を持つMapを集めて並列化されたListに対し、キー列の値をキーに値列の値を値として直列化したMapの集合を返します。
     * <p>
     * グループ化のキーとなるフィールドも、すべての列に付加します。
     * </p>
     * 
     * @param src 変換元
     * @param groupingConditionFieldNames グループ化条件列名
     * @param keyFieldName キーにあたるデータを格納する列名
     * @param valueFieldName 値にあたるデータを格納する列名
     * @param keyFieldValues キー列の値として想定される、直列化対象の列名
     * @param valueFieldDefaultValue 直列化対象の列に適用する初期値
     * @param withGroupField グループ化フィールドを直列化した各レコードに付加するか
     * @throws Exception 処理例外
     * @return 変換結果
     */
    protected static VRList getSeriesedKeyList(VRList src,
            final String[] groupingConditionFieldNames,
            final String keyFieldName, final String valueFieldName,
            final String[] keyFieldValues, final Object valueFieldDefaultValue,
            boolean withGroupField) throws Exception {
        VRArrayList result = new VRArrayList();

        HashMap cache = new HashMap();
        int whereFieldsLength = groupingConditionFieldNames.length;
        int keyFieldValuesLength = keyFieldValues.length;
        Iterator it = src.iterator();
        while (it.hasNext()) {
            VRMap row = (VRMap) it.next();

            VRMap adder;
            // グループ化条件フィールドの値を抽出する
            Object[] where = new Object[whereFieldsLength];
            for (int i = 0; i < whereFieldsLength; i++) {
                where[i] = VRBindPathParser.get(groupingConditionFieldNames[i],
                        row);
            }
            // グループ化条件フィールドで既出かチェック
            Object map = cache.get(where);
            if (map == null) {
                // 新規であれば新たな返却列を生成する
                adder = new VRHashMap();
                result.add(adder);
                cache.put(where, adder);

                if (withGroupField) {
                    // グループ化列を転記
                    for (int i = 0; i < groupingConditionFieldNames.length; i++) {
                        VRBindPathParser.set(groupingConditionFieldNames[i],
                                adder, where[i]);
                    }
                }

                // 初期値で初期化
                for (int i = 0; i < keyFieldValuesLength; i++) {
                    VRBindPathParser.set(keyFieldValues[i], adder,
                            valueFieldDefaultValue);
                }
            } else {
                // 既存であればキャッシュで発見したものを使用する
                adder = (VRMap) map;
            }

            // 直列化
            VRBindPathParser.set(String.valueOf(VRBindPathParser.get(
                    keyFieldName, row)), adder, VRBindPathParser.get(
                    valueFieldName, row));
        }
        return result;
    }

    /**
     * キーと値の関係で直列化された列を持つMapからなるListに対し、キー列と値列に並列化したMapの集合を返します。
     * 
     * @param src 変換元
     * @param groupingConditionFieldNames グループ化条件列名
     * @param keyFieldName キーにあたるデータを格納する列名
     * @param valueFieldName 値にあたるデータを格納する列名
     * @param keyFieldValues キー列の値として想定される、直列化対象の列名
     * @param valueFieldDefaultValue 直列化対象の列に適用する初期値
     * @throws Exception 処理例外
     * @return 変換結果
     */
    public static VRList getParalleledKeyList(VRList src,
            final String[] groupingConditionFieldNames,
            final String keyFieldName, final String valueFieldName,
            final String[] keyFieldValues, final Object valueFieldDefaultValue)
            throws Exception {
        VRArrayList result = new VRArrayList();

        int whereFieldsLength = groupingConditionFieldNames.length;
        int keyFieldValuesLength = keyFieldValues.length;
        Iterator it = src.iterator();
        while (it.hasNext()) {
            VRMap row = (VRMap) it.next();
            for (int i = 0; i < keyFieldValuesLength; i++) {
                Object valColValue = VRBindPathParser.get(keyFieldValues[i],
                        row);
                if (valueFieldDefaultValue == null) {
                    if (valColValue == null) {
                        // デフォルト値と同じ場合は新たな列を作成しない
                        continue;
                    }
                } else if (valueFieldDefaultValue.equals(valColValue)) {
                    // デフォルト値と同じ場合は新たな列を作成しない
                    continue;
                }

                // 新たな並列化列を生成する
                VRMap adder = new VRHashMap();
                for (int j = 0; j < whereFieldsLength; j++) {
                    // キー列以外を転写
                    VRBindPathParser.set(groupingConditionFieldNames[j], adder,
                            VRBindPathParser.get(
                                    groupingConditionFieldNames[j], row));
                }
                VRBindPathParser.set(keyFieldName, adder, keyFieldValues[i]);
                VRBindPathParser.set(valueFieldName, adder, valColValue);

                result.add(adder);

            }
        }
        return result;
    }

    /**
     * バインドパスfromKeyの値をバインドパスtoKeyの値として移動します。
     * <p>
     * 移動後にバインドパスfromKeyのキーおよび値は除去されます。
     * </p>
     * 
     * @param array 操作対象
     * @param fromKey 移動元のバンドパス
     * @param toKey 移動先のバインドパス
     * @throws Exception 処理例外
     */
    public static void moveBindPath(VRList array, String fromKey, String toKey)
            throws Exception {
        Iterator it = array.iterator();
        while (it.hasNext()) {
            VRMap row = (VRMap) it.next();
            VRBindPathParser
                    .set(toKey, row, VRBindPathParser.get(fromKey, row));
            row.removeData(fromKey);
        }
    }

    /**
     * バインドパスfromKeyの値をバインドパスtoKeyの値として移動します。
     * <p>
     * 移動後にバインドパスfromKeyのキーおよび値は除去されます。
     * </p>
     * 
     * @param array 操作対象
     * @param fromKeys 移動元のバンドパス配列
     * @param toKeys 移動先のバインドパス配列
     * @throws Exception 処理例外
     */
    public static void moveBindPath(VRList array, String[] fromKeys,
            String[] toKeys) throws Exception {
        int end = fromKeys.length;
        for (int i = 0; i < end; i++) {
            moveBindPath(array, fromKeys[i], toKeys[i]);
        }
    }

//    /**
//     * Mapの値を連ねたListを返します。
//     * 
//     * @param src 対象のMap
//     * @throws Exception 処理例外
//     * @return Mapの値集合
//     */
//    public static VRList toListFromMap(VRMap src, VRList dest) throws Exception {
//        return new VRArrayList(src.values());
//    }

    /**
     * DBから取得した配列(ResultSet)を、[キー:key, 値:レコード]にしたHashMapとして設定します。
     * 
     * @param src DBから取得した配列(ResultSet)
     * @param dest 設定先のMap
     * @param key キーとなるフィールド名
     * @throws Exception 処理例外
     */
    public static void setMapFromArray(VRList src, VRMap dest, String key)
            throws Exception {
        Iterator it = src.iterator();
        while (it.hasNext()) {
            Object obj = it.next();
            if (obj instanceof VRMap) {
                dest.put(VRBindPathParser.get(key, (VRMap) obj), obj);
            }
        }
    }

    /**
     * DBから取得した配列(ResultSet)を、[キー:key, 値:レコード集合]にしたHashMapとして設定します。
     * <p>
     * keyの一致するレコードをグループ化します。
     * </p>
     * @param src DBから取得した配列(ResultSet)
     * @param dest 設定先のMap
     * @param key キーとなるフィールド名
     * @throws Exception 処理例外
     */
    public static void setHashListFromArray(VRList src, VRMap dest, String key)
            throws Exception {
        Iterator it = src.iterator();
        while (it.hasNext()) {
            Object obj = it.next();
            if (obj instanceof VRMap) {
                Object hashKey = VRBindPathParser.get(key, (VRMap) obj);
                Object val=dest.getData(hashKey);
                List list;
                if(val instanceof List){
                    list = (List)val;
                }else{
                    list = new VRArrayList();
                    dest.setData(hashKey, list);
                }
                list.add(obj);
            }
        }
    }

    /**
     * DBから取得した配列(ResultSet)を、[キー:srcKey,
     * 値:レコードのdestKeyフィールド値]にしたHashMapとして設定します。
     * 
     * @param src DBから取得した配列(ResultSet)
     * @param dest 設定先のMap
     * @param srckey キーとなるフィールド名
     * @param destKey 抜き出すフィールド名
     * @throws Exception 処理例外
     */
    public static void setMapFromArray(VRList src, VRMap dest, String srckey,
            String destKey) throws Exception {
        Iterator it = src.iterator();
        while (it.hasNext()) {
            Object obj = it.next();
            if (obj instanceof VRMap) {
                dest.put(VRBindPathParser.get(srckey, (VRMap) obj),
                        VRBindPathParser.get(destKey, (VRMap) obj));
            }
        }
    }
    

    /**
     * すべてのレコードから指定キーフィールドを削除します。
     * 
     * @param src データ集合
     * @param keys 削除するキー集合
     */
    public static void removeKeys(List src, List keys){
        removeKeys(src, keys.toArray());
    }
    
    /**
     * すべてのレコードから指定キーフィールドを削除します。
     * 
     * @param src データ集合
     * @param keys 削除するキー配列
     */
    public static void removeKeys(List src, Object[] keys){
        int end = keys.length;
        Iterator it=src.iterator();
        while(it.hasNext()){
            Map row=(Map)it.next();
            for(int i=0; i<end; i++){
                row.remove(keys[i]);
            }
        }
    }
    

    /**
     * 1列だけのMapを連ねたListを、Mapの値を連ねたListに抽出します。
     * 
     * @param src 抽出元のList
     * @param dest 追加先のList
     */
    public static void toListFromSingleRowMap(List src, List dest) {
        Iterator it = src.iterator();
        while (it.hasNext()) {
            Object obj = it.next();
            if (obj instanceof Map) {
                Iterator it2=((Map)obj).values().iterator();
                if(it2.hasNext()){
                    dest.add(it2.next());
                }
            }
        }
    }
    
}
