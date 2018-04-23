package jp.nichicom.ac.lib.care.claim.servicecode;


/**
 * 
 * サービスパネルデータ逆生成クラスです。
 * <p>
 * サービス：介護予防通所介護
 * </p>
 * QkanValid16511_YobouTsukaiです。
 * <p>
 * Copyright (c) 2009 Nippon Computer Corpration. All Rights Reserved.
 * </p>
 * @author Masahiko Higuchi
 * @version 1.0 2009/03/10
 * @since version 5.4.5
 */
public class SV_16511_201804 extends AbstractQkanValidServiceDefaultGetter {
    

    // パネルの日割りチェックのバインドパス
    @Override
    protected String getHiwariBindPath() {
        return "1650102";
    }
    
}
