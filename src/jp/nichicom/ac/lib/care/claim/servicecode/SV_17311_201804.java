package jp.nichicom.ac.lib.care.claim.servicecode;



/**
 * 
 * サービスパネルデータ逆生成クラスです。
 * <p>
 * サービス：小規模多機能型居宅介護
 * </p>
 * QkanValid17311_Kyokaiです。
 * <p>
 * Copyright (c) 2009 Nippon Computer Corpration. All Rights Reserved.
 * </p>
 * @author Masahiko Higuchi
 * @version 1.0 2009/03/10
 * @since version 5.4.5
 */
public class SV_17311_201804 extends AbstractQkanValidServiceDefaultGetter {
    
    // パネルの日割りチェックのバインドパス
    @Override
    protected String getHiwariBindPath() {
        return "1730103";
    }
    
    @Override
    protected boolean isValidDataCreateService(Integer changeMode) {
        /* 
         * 要介護→要支援に変化する場合は変換対象とする
         * 
         * 要支援→要介護の場合は開始日の特定が必要になるが
         * 開始日の条件がサービス提供日と定義されており履歴の変更日とは異なるため
         * 対象外にする。
         */
        if (QkanValidServiceManager.YOKAIGO_TO_YOSHIEN.equals(changeMode)) {
            return true;
        }
        return false;            
    }
}
