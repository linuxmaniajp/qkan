
/*
 * Project code name "ORCA"
 * 給付管理台帳ソフト QKANCHO（JMA care benefit management software）
 * Copyright(C) 2002 JMA (Japan Medical Association)
 *
 * This program is part of "QKANCHO (JMA care benefit management software)".
 *
 * This program is distributed in the hope that it will be useful
 * for further advancement in medical care, according to JMA Open
 * Source License, but WITHOUT ANY WARRANTY.
 * Everyone is granted permission to use, copy, modify and
 * redistribute this program, but only under the conditions described
 * in the JMA Open Source License. You should have received a copy of
 * this license along with this program. If not, stop using this
 * program and contact JMA, 2-28-16 Honkomagome, Bunkyo-ku, Tokyo,
 * 113-8621, Japan.
 *****************************************************************
 * アプリ: QKANCHO
 * 開発者: 藤原　伸
 * 作成日: 2006/01/24  日本コンピューター株式会社 藤原　伸 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 請求書出力 (P)
 * プロセス 請求処理 (001)
 * プログラム レコード抽象クラス (QP001RecordAbstract)
 *
 *****************************************************************
 */

package jp.nichicom.ac.lib.care.claim.calculation;

import jp.nichicom.vr.util.VRMap;

abstract class QP001RecordAbstract {

    abstract protected String getSerialId();

    /**
     * VRMapに引数のキー、値を設定する。
     * @param result VRMap
     * @param bind_path 設定するキー
     * @param value 設定する値
     * @throws Exception
     */
    public void setData(VRMap result, String bind_path, double value)
            throws Exception {
        setData(result, bind_path, Double.toString(value));
    }
    /**
     * VRMapに引数のキー、値を設定する。
     * @param result VRMap
     * @param bind_path 設定するキー
     * @param value 設定する値
     * @throws Exception
     */
    public void setData(VRMap result, String bind_path, int value)
            throws Exception {
        setData(result, bind_path, Integer.toString(value));
    }
    /**
     * VRMapに引数のキー、値を設定する。
     * @param result VRMap
     * @param bind_path 設定するキー
     * @param value 設定する値
     * @throws Exception
     */
    public void setData(VRMap result, String bind_path, Object value)
            throws Exception {
        
        if((value != null) && ("null".equalsIgnoreCase(String.valueOf(value)))){
            value = null;
        }
        result.put(bind_path, value);
    }
}
