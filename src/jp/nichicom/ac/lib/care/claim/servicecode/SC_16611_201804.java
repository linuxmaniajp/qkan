package jp.nichicom.ac.lib.care.claim.servicecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SC_16611_201804 extends Qkan10011_ServiceUnitGetter {
    public String getServiceName() {
        return "介護予防通所リハ";
    }

    public String getServiceCodeKind() {
        return "66";
    }

    public String getSystemServiceKindDetail() {
        return "16611";
    }

    public ArrayList<HashMap<String, String>> getSystemServiceCodeItem(
            Map<String, String> map) {
        ArrayList<HashMap<String, String>> sysSvcCdItems = new ArrayList<HashMap<String, String>>();

        // パラメータ抽出
        // =========================================================================

        // 1 要介護度
        int _1 = convertYokaigodo(getIntValue(map, "1"));

        // 明らかに要介護度がおかしい場合は空を返す
        switch (_1) {
        case 1: // 自立
        case 2: // 経過的要介護
        case 5: // 要介護１
        case 6: // 要介護２
        case 7: // 要介護３
        case 8: // 要介護４
        case 9: // 要介護５
        case 10: // 事業対象者
            return new ArrayList<HashMap<String, String>>();
        }
        
        // 1660101 人員減算　1-なし 2-定員超過 3-医師、PT・OT・ST、看護・介護職員の欠員
        int _1660101 = getIntValue(map, "1660101", 1);

        // 1660102 日割　1-日割でない 2-日割である
        int _1660102 = getIntValue(map, "1660102", 1);

        // 1660103 運動器機能向上加算　1-なし 2-あり
        int _1660103 = getIntValue(map, "1660103", 1);

        // 1660104 栄養改善加算　1-なし 2-あり
        int _1660104 = getIntValue(map, "1660104", 1);

        // 1660105 口腔機能向上加算　1-なし 2-あり
        int _1660105 = getIntValue(map, "1660105", 1);

        // 1660106 事業所評価加算　1-なし 2-あり
        int _1660106 = getIntValue(map, "1660106", 1);

        // 1660107 若年性認知症利用者受入加算
        int _1660107 = getIntValue(map, "1660107", 1);

        // 中山間地域等でのサービス提供加算
        int _12 = getIntValue(map, "12", 1);

        // 1660108 サービス提供体制強化加算
        int _1660108 = getIntValue(map, "1660108", 1);

        // 1660110 施設区分ラジオグループ
        int _1660110 = getIntValue(map, "1660110", 1);

        // [CCCX:03692][Shinobu Hitaka] 2016/12/01 add - begin 個別選択対応
        // 1660111 選択的サービス複数実施加算　1-なし 2-I1 3-I2 4-I3 5-II
        int _1660111 = getIntValue(map, "1660111", 1);
        
        // 1660113 リハビリテーション・マネジメント加算
        int _1660113 = getIntValue(map, "1660113" ,1);

        // 1660114 生活行為向上リハビリ実施加算　1-なし 2-3月以内 3-3月超6月以内
        int _1660114 = getIntValue(map, "1660114", 1);
        
        // 1660115 生活行為向上リハビリ後の継続減算　1-なし 2-あり
        int _1660115 = getIntValue(map, "1660115", 1);
        
        // 1660112	栄養スクリーニング加算
        int _1660112 = getIntValue(map, "1660112");

        // 16 同一建物居住者へのサービス提供
        int _16 = getIntValue(map, "16", 1);

        // 17 介護職員処遇改善加算
        int _17 = getIntValue(map,
                Qkan10011_ServiceUnitGetter.SYOGUKAIZEN_KASAN, 1);
        
        // [ID:0000746][Masahiko.Higuchi] 2012/06/20 add - begin  加算のみ対応
        // 加算のみ(運動機器・栄養改善・口腔機能向上)
        int _9 = getIntValue(map,"9");

        // 単独加算のみ---------------------------------------------------------------
        // 単独加算サービス
        if(_9 == 2){
            sysSvcCdItems = new ArrayList<HashMap<String, String>>();
            
        	// 運動器機能向上加算、栄養改善加算、口腔機能向上加算、選択的サービス複数実施加算
            setSentakutekiService(_1660111, _1660103, _1660104, _1660105, sysSvcCdItems);
                        
            // 介護職員処遇改善を返却
            switch (_17) {
            case 6:
                // 予防通所リハ処遇改善加算I
                putSystemServiceCodeItem(sysSvcCdItems, "Z6100");//2017.04
                break;
            case 5:
                // 予防通所リハ処遇改善加算II
                putSystemServiceCodeItem(sysSvcCdItems, "Z6110");
                break;
            case 2:
                // 予防通所リハ処遇改善加算III
                putSystemServiceCodeItem(sysSvcCdItems, "Z6111");
                break;
            case 3:
                // 予防通所リハ処遇改善加算IV
                putSystemServiceCodeItem(sysSvcCdItems, "Z6113");
                break;
            case 4:
                // 予防通所リハ処遇改善加算V
                putSystemServiceCodeItem(sysSvcCdItems, "Z6115");
                break;
            }
            
            return sysSvcCdItems;
        }
        // [ID:0000746][Masahiko.Higuchi] 2012/06/20 add - end
        
        // 独自コード生成
        // ===========================================================================
        StringBuilder sb = new StringBuilder();

        // 施設区分 1-病院又は診療所　2-介護老人保健施設
        sb.append(CODE_CHAR[_1660110]);

        // 要介護度
        sb.append(CODE_CHAR[_1]);

        // 人員減算　1-なし 2-定員超過 3-医師、PT・OT・ST、看護・介護職員の欠員
        sb.append(CODE_CHAR[_1660101]);

        // 生活行為向上リハビリ後の継続減算 //2018.04
        sb.append(CODE_CHAR[_1660115]);
        
        // 日割　1-日割でない 2-日割である
        sb.append(CODE_CHAR[_1660102]);

        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

        // 加算
        // ============================================================================

        // 6109 予防通所リハ若年性認知症受入加算
        if (_1660107 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6109");
        }
        
        // 同一建物居住者へのサービス提供がありの場合
        if (_16 > 1) {
            
            //施設区分を確認
            switch (_1660110) {
            case 1: // 病院又は診療所
                // 要介護度
                switch(_1) {
                case 3: // 要支援１
                    // 予防通所リハ送迎減算１１
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6105");
                    break;
                case 4: // 要支援２
                    // 予防通所リハ送迎減算１２
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6106");
                    break;
                }
                break;
            case 2: // 介護老人保健施設
                // 要介護度
                switch(_1) {
                case 3: // 要支援１
                    // 予防通所リハ送迎減算２１
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6107");
                    break;
                case 4: // 要支援２
                    // 予防通所リハ送迎減算２２
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6108");
                    break;
                }
                break;
            case 3: // 介護医療院
                // 要介護度
                switch(_1) {
                case 3: // 要支援１
                    // 予防通所リハ送迎減算３１
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6119");//2018.04
                    break;
                case 4: // 要支援２
                    // 予防通所リハ送迎減算３２
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6120");//2018.04
                    break;
                }
                break;
            }
        }
        
        // 運動器機能向上加算、栄養改善加算、口腔機能向上加算、選択的サービス複数実施加算
        setSentakutekiService(_1660111, _1660103, _1660104, _1660105, sysSvcCdItems);
        
        // 事業所評価加算　1-なし 2-あり
        if (_1660106 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z5005");
        }
        
        // リハマネジメント加算
        if (_1660113 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z5615");//2018.04
        }
        
        // 1160124 生活行為向上リハビリ実施加算
        switch (_1660114) {
        case 2:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6255");//2018.04
            break;
        case 3:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6256");//2018.04
            break;
        }
        
        // 1160129	栄養スクリーニング加算
        if (_1660112 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6201");//2018.04
        }
        
        // サービス提供体制強化加算
        switch (_1660108) {
        case 4: // Iイ型
            // 要介護度
            switch (_1) {
            case 3: // 要支援１
                // 予通リハサービス提供体制加算Iイ１
                putSystemServiceCodeItem(sysSvcCdItems, "Z6117");
                break;
            case 4: // 要支援２
                // 予通リハサービス提供体制加算Iイ２
                putSystemServiceCodeItem(sysSvcCdItems, "Z6118");
                break;
            }
            break;
        case 2: // Iロ型
            // 要介護度
            switch (_1) {
            case 3: // 要支援１
                // 予通リハサービス提供体制加算Iロ１
                putSystemServiceCodeItem(sysSvcCdItems, "Z6101");
                break;
            case 4: // 要支援２
                // 予通リハサービス提供体制加算Iロ２
                putSystemServiceCodeItem(sysSvcCdItems, "Z6102");
                break;
            }
            break;
            
        case 3: // II型
            // 要介護度
            switch (_1) {
            case 3: // 要支援１
                // 予通リハサービス提供体制加算II１
                putSystemServiceCodeItem(sysSvcCdItems, "Z6103");
                break;
            case 4: // 要支援２
                // 予通リハサービス提供体制加算II２
                putSystemServiceCodeItem(sysSvcCdItems, "Z6104");
                break;
            }
            break;
        }
        
        
        // 介護職員処遇改善を返却
        switch (_17) {
        case 6:
            // 予防通所リハ処遇改善加算I
            putSystemServiceCodeItem(sysSvcCdItems, "Z6100");//2017.04
            break;
        case 5:
            // 予防通所リハ処遇改善加算II
            putSystemServiceCodeItem(sysSvcCdItems, "Z6110");
            break;
        case 2:
            // 予防通所リハ処遇改善加算III
            putSystemServiceCodeItem(sysSvcCdItems, "Z6111");
            break;
        case 3:
            // 予防通所リハ処遇改善加算IV
            putSystemServiceCodeItem(sysSvcCdItems, "Z6113");
            break;
        case 4:
            // 予防通所リハ処遇改善加算V
            putSystemServiceCodeItem(sysSvcCdItems, "Z6115");
            break;
        }
        
        
        // 日割りではない場合
        if (_1660102 == 1) {
            
            if (_12 > 1) {
                // 8110 予防通所リハ中山間地域等提供加算
                putSystemServiceCodeItem(sysSvcCdItems, "Z8110");
            }
            
            
        // 日割りの場合
        } else {
            
            if (_12 > 1) {
                // 8111 予防通所リハ中山間地域等加算日割
                putSystemServiceCodeItem(sysSvcCdItems, "Z8111");
            }
            
        }

        return sysSvcCdItems;
    }
    
    /**
     * 運動器機能向上加算、栄養改善加算、口腔機能向上加算の選択状況によって複数サービス実施加算を設定します。
	 * @param sentakuteki 複数サービス実施加算
	 * @param moveFunction 運動器機能向上加算
	 * @param nourishment 栄養改善加算
	 * @param mouthFunction 口腔機能向上加算
	 * @param sysSvcCdItems サービスコードMap
     */
    private void setSentakutekiService(int sentakuteki, 
    		int moveFunction, int nourishment, int mouthFunction, 
    		ArrayList<HashMap<String, String>> sysSvcCdItems) {
    	// 選択的サービス複数実施加算　1-なし 2-I1 3-I2 4-I3 5-II
        if (sentakuteki > 1) {
        	switch (sentakuteki) {
            case 2:
                // 複数サービス実施加算I１
                putSystemServiceCodeItem(sysSvcCdItems, "Z5006");
                break;
            case 3:
            	// 複数サービス実施加算I２
	            putSystemServiceCodeItem(sysSvcCdItems, "Z5007");
                break;
            case 4:
            	// 複数サービス実施加算I３
	            putSystemServiceCodeItem(sysSvcCdItems, "Z5008");
                break;
            case 5:
            	// 複数サービス実施加算II
	            putSystemServiceCodeItem(sysSvcCdItems, "Z5009");
                break;
            }
        } else {
	        // 運動器機能向上加算、栄養改善加算、口腔機能向上加算の例外処理
	        // 
	        // [運動器機能向上加算のフラグ][栄養改善加算のフラグ][口腔機能向上加算のフラグ]
	        // という並びの3桁の数値を作成して分岐（フラグは 1-なし 2-あり）
	        int addParam = (moveFunction * 100) + (nourishment * 10) + mouthFunction;
	        
	        switch(addParam) {
	        // 運動器機能向上加算
	        case 211:
	            // 運動器機能向上加算
	            putSystemServiceCodeItem(sysSvcCdItems, "Z5002");
	            break;
	        // 栄養改善加算
	        case 121:
	            // 栄養改善加算
	            putSystemServiceCodeItem(sysSvcCdItems, "Z5003");
	            break;
	        // 口腔機能向上加算
	        case 112:
	            // 口腔機能向上加算
	            putSystemServiceCodeItem(sysSvcCdItems, "Z5004");
	            break;
	        // 運動器機能向上加算 + 栄養改善加算
	        case 221:
	            // 複数サービス実施加算I１
	            putSystemServiceCodeItem(sysSvcCdItems, "Z5006");
	            break;
	        // 運動器機能向上加算 + 口腔機能向上加算
	        case 212:
	            // 複数サービス実施加算I２
	            putSystemServiceCodeItem(sysSvcCdItems, "Z5007");
	            break;
	        // 栄養改善加算 + 口腔機能向上加算
	        case 122:
	            // 複数サービス実施加算I３
	            putSystemServiceCodeItem(sysSvcCdItems, "Z5008");
	            break;
	        // 運動器機能向上加算 + 栄養改善加算 + 口腔機能向上加算
	        case 222:
	            // 複数サービス実施加算II
	            putSystemServiceCodeItem(sysSvcCdItems, "Z5009");
	            break;
	        }
        }
    }
}
