package jp.nichicom.ac.lib.care.claim.print.schedule;

import java.util.Collection;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRMap;

/**
 * サービス単位数の計算結果です。
 * <p>
 * Copyright (c) 2005 Nippon Computer Corpration. All Rights Reserved.
 * </p>
 * 
 * @author Tozo Tanaka
 * @version 1.0 2006/03/05
 */
public class CareServiceUnitCalcurateResult extends VRArrayList {

    /**
     * Constructs an empty list with an initial capacity of ten.
     */
    public CareServiceUnitCalcurateResult() {
        super();
    }

    /**
     * Constructs a list containing the elements of the specified collection, in
     * the order they are returned by the collection's iterator. The
     * <tt>ArrayList</tt> instance has an initial capacity of 110% the size of
     * the specified collection.
     * 
     * @param c the collection whose elements are to be placed into this list.
     * @throws NullPointerException if the specified collection is null.
     */
    public CareServiceUnitCalcurateResult(Collection c) {
        super(c);
    }

    /**
     * Constructs an empty list with the specified initial capacity.
     * 
     * @param initialCapacity the initial capacity of the list.
     * @exception IllegalArgumentException if the specified initial capacity is
     *                negative
     */
    public CareServiceUnitCalcurateResult(int initialCapacity) {
        super(initialCapacity);
    }

    /**
     * 調整単位数の合計 を返します。
     * 
     * @return 調整単位数の合計
     */
    public int getAdjustTotal() {
        int total = 0;
        int end = size();
        for (int i = 0; i < end; i++) {
            total += getAdjust(i);
        }
        return total;
    }

    /**
     * 単位数の合計 を返します。
     * 
     * @return 単位数の合計
     */
    public int getManagementTotal() {
        int total = 0;
        int end = size();
        for (int i = 0; i < end; i++) {
            total += getUnit(i);
        }
        return total;
    }

    /**
     * 指定個数目のサービスの単位数を返します。
     * 
     * @param index 番号
     * @return 単位数
     */
    public int getUnit(int index) {
        return ACCastUtilities.toInt(((VRMap) get(index)).getData("UNIT"), 0);
    }

    /**
     * 指定個数目のサービスの単位数を設定します。
     * 
     * @param index 番号
     * @param unit 単位数
     */
    public void setUnit(int index, int unit) {
        ((VRMap) get(index)).setData("UNIT", new Integer(unit));
    }

    /**
     * 指定個数目のサービスの調整単位数を返します。
     * 
     * @param index 番号
     * @return 調整単位数
     */
    public int getAdjust(int index) {
        return ACCastUtilities.toInt(((VRMap) get(index)).getData("ADJUST"), 0);
    }

    /**
     * 指定個数目のサービスの調整単位数を設定します。
     * 
     * @param index 番号
     * @param adjust 調整単位数
     */
    public void setAdjust(int index, int adjust) {
        ((VRMap) get(index)).setData("ADJUST", new Integer(adjust));
    }

    /**
     * 指定個数目のサービスの調整後単位数を返します。
     * 
     * @param index 番号
     * @return 調整後単位数
     */
    public int getResult(int index) {
        return ACCastUtilities.toInt(((VRMap) get(index)).getData("RESULT"), 0);
    }

    /**
     * 指定個数目のサービスの調整後単位数を設定します。
     * 
     * @param index 番号
     * @param result 調整後単位数
     */
    public void setResult(int index, int result) {
        ((VRMap) get(index)).setData("RESULT", new Integer(result));
    }
}
