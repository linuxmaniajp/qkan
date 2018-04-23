package jp.nichicom.ac.lib.care.claim.servicecode;


/**
 * 
 * サービスパネルデータ逆生成クラスです。
 * <p>
 * サービス：夜間対応型訪問看護
 * </p>
 * <p>
 * 現在は変換の仕様上生成されることのないクラスです。
 * </p>
 * QkanValid17111_Yakaiです。
 * <p>
 * Copyright (c) 2007 Nippon Computer Corpration. All Rights Reserved.
 * </p>
 * @author Masahiko Higuchi
 * @version 1.0 2008/01/11
 * @since version 5.4.1
 */
public class SV_17111_201804 extends AbstractQkanValidServiceDefaultGetter {
    
    // パネルの日割りチェックのバインドパス
    @Override
    protected String getHiwariBindPath() {
        return "1710106";
    }

}
