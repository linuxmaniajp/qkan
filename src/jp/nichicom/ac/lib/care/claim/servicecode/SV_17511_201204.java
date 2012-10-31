package jp.nichicom.ac.lib.care.claim.servicecode;



/**
 * 
 * サービスパネルデータ逆生成クラスです。
 * <p>
 * サービス：介護予防小規模多機能型居宅介護
 * </p>
 * QkanValid17511_YobouKyokaiです。
 * <p>
 * Copyright (c) 2007 Nippon Computer Corpration. All Rights Reserved.
 * </p>
 * @author Masahiko Higuchi
 * @version 1.0 2008/01/11
 * @since version 5.4.1
 */
public class SV_17511_201204 extends AbstractQkanValidServiceDefaultGetter {
    
    // パネルの日割りチェックのバインドパス
    @Override
    protected String getHiwariBindPath() {
        return "1750103";
    }
    
    @Override
    protected boolean isValidDataCreateService(Integer changeMode) {
        /* 
         * 要支援→要介護に変化する場合は変換対象とする
         * 
         * 要介護→要支援の場合は開始日の特定が必要になるが
         * 開始日の条件がサービス提供日と定義されており履歴の変更日とは異なるため
         * 対象外にする。
         */
        if(QkanValidServiceManager.YOSHIEN_TO_YOKAIGO.equals(changeMode)){
            return true;
        }
        return false;
    }
}
