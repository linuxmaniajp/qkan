package jp.nichicom.ac.lib.care.claim.servicecode;


/**
 * 
 * サービスパネルデータ逆生成クラスです。
 * <p>
 * サービス：予防訪問介護
 * </p>
 * QkanValid16111_YobouHokaiです。
 * <p>
 * Copyright (c) 2009 Nippon Computer Corpration. All Rights Reserved.
 * </p>
 * @author Masahiko Higuchi
 * @version 1.0 2009/03/10
 * @since version 5.4.5
 */
public class SV_16111_201204 extends AbstractQkanValidServiceDefaultGetter {

    // パネルの日割りチェックのバインドパス
    @Override
    protected String getHiwariBindPath() {
        return "1610103";
    }
    

}
