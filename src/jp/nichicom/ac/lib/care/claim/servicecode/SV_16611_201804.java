package jp.nichicom.ac.lib.care.claim.servicecode;


/**
 * 
 * サービスパネルデータ逆生成クラスです。
 * <p>
 * サービス：介護予防通所リハ
 * </p>
 * QkanValid16611_YobouTsuriです。
 * <p>
 * Copyright (c) 2007 Nippon Computer Corpration. All Rights Reserved.
 * </p>
 * @author Masahiko Higuchi
 * @version 1.0 2008/01/11
 * @since version 5.4.1
 */
public class SV_16611_201804 extends AbstractQkanValidServiceDefaultGetter {

    // パネルの日割りチェックのバインドパス
    @Override
    protected String getHiwariBindPath() {
        return "1660102";
    }

}
