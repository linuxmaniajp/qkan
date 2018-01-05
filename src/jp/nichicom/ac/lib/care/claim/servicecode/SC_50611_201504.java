package jp.nichicom.ac.lib.care.claim.servicecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 通所型サービス(独自)
 * 
 * @since V7.3.0
 * @author Shinobu.Hitaka
 * 
 */
public class SC_50611_201504 extends Qkan10011_ServiceUnitGetter {
    public String getServiceName() {
        return "通所型サービス(独自)";
    }

    public String getServiceCodeKind() {
        return "A6";
    }

    public String getSystemServiceKindDetail() {
        return "50611";
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
            return new ArrayList<HashMap<String, String>>();
        }
        
        // 5060112 パターン　1,2,3,4,5
        int _5060112 = getIntValue(map, "5060112", 1);

        // 通所型サービス費　1-１ 2-２
        int _5060101 = getIntValue(map, "5060101", 1);
        
        // 事業対象者ではないとき、要介護度によって通所型サービスを決定
        if (_1 == 3) {
            // 要支援１の場合
        	_5060101 = 1; //通所型サービス１
        } else if (_1 == 4) {
            // 要支援２の場合
        	_5060101 = 2; //通所型サービス２
        }
        
        // 回数　1-回数でない 2-回数である
        int _5060102 = getIntValue(map, "5060102", 1);
        
        // 5060103 人員減算　1-なし 2-定員超過 3-看護・介護職員が欠員
        int _5060103 = getIntValue(map, "5060103", 1);

        // 5060104 日割　1-日割でない 2-日割である
        int _5060104 = getIntValue(map, "5060104", 1);

        // 5060105 生活機能向上グループ活動加算　1-なし 2-あり
        int _5060105 = getIntValue(map, "5060105", 1);

        // 5060106 運動器機能向上加算　1-なし 2-あり
        int _5060106 = getIntValue(map, "5060106", 1);

        // 5060107 栄養改善加算　1-なし 2-あり
        int _5060107 = getIntValue(map, "5060107", 1);

        // 5060108 口腔機能向上加算　1-なし 2-あり
        int _5060108 = getIntValue(map, "5060108", 1);

        // 5060109 事業所評価加算　1-なし 2-あり
        int _5060109 = getIntValue(map, "5060109", 1);

        // 5060110 若年性認知症利用者受入加算
        int _5060110 = getIntValue(map, "5060110", 1);

        // 中山間地域等でのサービス提供加算
        int _12 = getIntValue(map, "12", 1);

        // 5060111 サービス提供体制強化加算
        int _5060111 = getIntValue(map, "5060111");

        // [CCCX:03692][Shinobu Hitaka] 2016/12/01 add - begin 個別選択対応
        // 5060113 選択的サービス複数実施加算　1-なし 2-I1 3-I2 4-I3 5-II
        int _5060113 = getIntValue(map, "5060113", 1);

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

            // 加算
            setKasanServiceByPattern(_5060110, _16, _5060101, _5060105, _5060109, sysSvcCdItems, _5060112);
            
            // 運動器機能向上加算、栄養改善加算、口腔機能向上加算、選択的サービス複数実施加算
            setSentakutekiServiceByPattern(_5060113, _5060106, _5060107, _5060108, sysSvcCdItems, _5060112);
            
            // サービス提供体制強化加算
            setServiceTeikyoKasanByPattern(_5060101, _5060111, sysSvcCdItems, _5060112);
            
            // 介護職員処遇改善を返却
            switch (_17) {
            case 6:
                // 通所型サービス処遇改善加算I
                putSystemServiceCodeItem(sysSvcCdItems, "Z6100");//2017.04
                break;
            case 5:
                // 通所型サービス処遇改善加算II
                putSystemServiceCodeItem(sysSvcCdItems, "Z6110");
                break;
            case 2:
                // 通所型サービス処遇改善加算III
                putSystemServiceCodeItem(sysSvcCdItems, "Z6111");
                break;
            case 3:
                // 通所型サービス処遇改善加算IV
                putSystemServiceCodeItem(sysSvcCdItems, "Z6113");
                break;
            case 4:
                // 通所型サービス処遇改善加算V
                putSystemServiceCodeItem(sysSvcCdItems, "Z6115");
                break;
            }
            
            return sysSvcCdItems;
        }
        // [ID:0000746][Masahiko.Higuchi] 2012/06/20 add - end

        // 独自コード生成
        // ===========================================================================
        StringBuilder sb = new StringBuilder();

        // 通所型サービス費
        sb.append(CODE_CHAR[_5060101]);
        
        // 要介護度
        sb.append(CODE_CHAR[_1]);
        
        // 回数
        sb.append(CODE_CHAR[_5060102]);

        // 人員減算　1-なし 2-定員超過 3-看護・介護職員が欠員
        sb.append(CODE_CHAR[_5060103]);

        // 日割　1-日割でない 2-日割である
        sb.append(CODE_CHAR[_5060104]);

        // パターン　1,2,3,4,5
        sb.append(CODE_CHAR[_5060112]);

        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

        // 加算
        // ============================================================================
        setKasanServiceByPattern(_5060110, _16, _5060101, _5060105, _5060109, sysSvcCdItems, _5060112);
        
        // 運動器機能向上加算、栄養改善加算、口腔機能向上加算、選択的サービス複数実施加算
        setSentakutekiServiceByPattern(_5060113, _5060106, _5060107, _5060108, sysSvcCdItems, _5060112);
        
        // サービス提供体制強化加算
        setServiceTeikyoKasanByPattern(_5060101, _5060111, sysSvcCdItems, _5060112);
        
        
        // 介護職員処遇改善を返却
        switch (_17) {
        case 6:
            // 通所型サービス処遇改善加算I
            putSystemServiceCodeItem(sysSvcCdItems, "Z6100");//2017.04
            break;
        case 5:
            // 通所型サービス処遇改善加算II
            putSystemServiceCodeItem(sysSvcCdItems, "Z6110");
            break;
        case 2:
            // 通所型サービス処遇改善加算III
            putSystemServiceCodeItem(sysSvcCdItems, "Z6111");
            break;
        case 3:
            // 通所型サービス処遇改善加算IV
            putSystemServiceCodeItem(sysSvcCdItems, "Z6113");
            break;
        case 4:
            // 通所型サービス処遇改善加算V
            putSystemServiceCodeItem(sysSvcCdItems, "Z6115");
            break;
        }
        
        
        // 日割りではない場合
        if (_5060104 == 1) {
            
            // 月単位サービスの場合
            if (_5060102 == 1) {
                // 8110 通所型サービス中山間地域等提供加算
                if (_12 > 1) {
                    putSystemServiceCodeItem(sysSvcCdItems, "Z8110");
                }
                
            // 回数単位サービスの場合
            } else if (_5060102 == 2) {
                // 8112 通所型サービス中山間地域等加算回数
                if (_12 > 1) {
                    putSystemServiceCodeItem(sysSvcCdItems, "Z8112");
                }
            }
            
        // 日割りの場合
        } else {
            
            // 8111 通所型サービス中山間地域等加算日割
            if (_12 > 1) {
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
	 * @param pattern パターン
     */
    private void setSentakutekiServiceByPattern(int sentakuteki, 
    		int moveFunction, int nourishment, int mouthFunction, 
    		ArrayList<HashMap<String, String>> sysSvcCdItems,
    		int pattern) {
    	// 選択的サービス複数実施加算　1-なし 2-I1 3-I2 4-I3 5-II
        if (sentakuteki > 1) {
        	switch (sentakuteki) {
            case 2:
                // 複数サービス実施加算I１
	        	switch (pattern) {
	        	case 1:
	        		putSystemServiceCodeItem(sysSvcCdItems, "Z5006");
	        		break;
	        	case 2:
	        		putSystemServiceCodeItem(sysSvcCdItems, "Z5016");
	        		break;
	        	case 3:
	        		putSystemServiceCodeItem(sysSvcCdItems, "Z5026");
	        		break;
	        	case 4:
	        		putSystemServiceCodeItem(sysSvcCdItems, "Z5036");
	        		break;
	        	case 5:
	        		putSystemServiceCodeItem(sysSvcCdItems, "Z5046");
	        		break;
	        	}
                break;
            case 3:
            	// 複数サービス実施加算I２
	        	switch (pattern) {
	        	case 1:
	        		putSystemServiceCodeItem(sysSvcCdItems, "Z5007");
	        		break;
	        	case 2:
	        		putSystemServiceCodeItem(sysSvcCdItems, "Z5017");
	        		break;
	        	case 3:
	        		putSystemServiceCodeItem(sysSvcCdItems, "Z5027");
	        		break;
	        	case 4:
	        		putSystemServiceCodeItem(sysSvcCdItems, "Z5037");
	        		break;
	        	case 5:
	        		putSystemServiceCodeItem(sysSvcCdItems, "Z5047");
	        		break;
	        	}
	            break;
            case 4:
            	// 複数サービス実施加算I３
	        	switch (pattern) {
	        	case 1:
	        		putSystemServiceCodeItem(sysSvcCdItems, "Z5008");
	        		break;
	        	case 2:
	        		putSystemServiceCodeItem(sysSvcCdItems, "Z5018");
	        		break;
	        	case 3:
	        		putSystemServiceCodeItem(sysSvcCdItems, "Z5028");
	        		break;
	        	case 4:
	        		putSystemServiceCodeItem(sysSvcCdItems, "Z5038");
	        		break;
	        	case 5:
	        		putSystemServiceCodeItem(sysSvcCdItems, "Z5048");
	        		break;
	        	}
                break;
            case 5:
            	// 複数サービス実施加算II
	        	switch (pattern) {
	        	case 1:
	        		putSystemServiceCodeItem(sysSvcCdItems, "Z5009");
	        		break;
	        	case 2:
	        		putSystemServiceCodeItem(sysSvcCdItems, "Z5019");
	        		break;
	        	case 3:
	        		putSystemServiceCodeItem(sysSvcCdItems, "Z5029");
	        		break;
	        	case 4:
	        		putSystemServiceCodeItem(sysSvcCdItems, "Z5039");
	        		break;
	        	case 5:
	        		putSystemServiceCodeItem(sysSvcCdItems, "Z5049");
	        		break;
	        	}
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
	            // 通所型サービス運動器機能向上加算
	        	switch (pattern) {
	        	case 1:
	        		putSystemServiceCodeItem(sysSvcCdItems, "Z5002");
	        		break;
	        	case 2:
	        		putSystemServiceCodeItem(sysSvcCdItems, "Z5012");
	        		break;
	        	case 3:
	        		putSystemServiceCodeItem(sysSvcCdItems, "Z5022");
	        		break;
	        	case 4:
	        		putSystemServiceCodeItem(sysSvcCdItems, "Z5032");
	        		break;
	        	case 5:
	        		putSystemServiceCodeItem(sysSvcCdItems, "Z5042");
	        		break;
	        	}
	            break;
	        // 栄養改善加算
	        case 121:
	            // 通所型サービス栄養改善加算
	        	switch (pattern) {
	        	case 1:
		            putSystemServiceCodeItem(sysSvcCdItems, "Z5003");
		    		break;
		    	case 2:
		    		putSystemServiceCodeItem(sysSvcCdItems, "Z5013");
		    		break;
		    	case 3:
		    		putSystemServiceCodeItem(sysSvcCdItems, "Z5023");
		    		break;
		    	case 4:
		    		putSystemServiceCodeItem(sysSvcCdItems, "Z5033");
		    		break;
		    	case 5:
		    		putSystemServiceCodeItem(sysSvcCdItems, "Z5043");
		    		break;
		    	}
	            break;
	        // 口腔機能向上加算
	        case 112:
	            // 通所型サービス口腔機能向上加算
	        	switch (pattern) {
	        	case 1:
	        		putSystemServiceCodeItem(sysSvcCdItems, "Z5004");
	        		break;
	        	case 2:
	        		putSystemServiceCodeItem(sysSvcCdItems, "Z5014");
	        		break;
	        	case 3:
	        		putSystemServiceCodeItem(sysSvcCdItems, "Z5024");
	        		break;
	        	case 4:
	        		putSystemServiceCodeItem(sysSvcCdItems, "Z5034");
	        		break;
	        	case 5:
	        		putSystemServiceCodeItem(sysSvcCdItems, "Z5044");
	        		break;
	        	}
	            break;
	        // 運動器機能向上加算 + 栄養改善加算
	        case 221:
	            // 通所型複数サービス実施加算I１
	        	switch (pattern) {
	        	case 1:
	        		putSystemServiceCodeItem(sysSvcCdItems, "Z5006");
	        		break;
	        	case 2:
	        		putSystemServiceCodeItem(sysSvcCdItems, "Z5016");
	        		break;
	        	case 3:
	        		putSystemServiceCodeItem(sysSvcCdItems, "Z5026");
	        		break;
	        	case 4:
	        		putSystemServiceCodeItem(sysSvcCdItems, "Z5036");
	        		break;
	        	case 5:
	        		putSystemServiceCodeItem(sysSvcCdItems, "Z5046");
	        		break;
	        	}
	            break;
	        // 運動器機能向上加算 + 口腔機能向上加算
	        case 212:
	            // 通所型複数サービス実施加算I２
	        	switch (pattern) {
	        	case 1:
	        		putSystemServiceCodeItem(sysSvcCdItems, "Z5007");
	        		break;
	        	case 2:
	        		putSystemServiceCodeItem(sysSvcCdItems, "Z5017");
	        		break;
	        	case 3:
	        		putSystemServiceCodeItem(sysSvcCdItems, "Z5027");
	        		break;
	        	case 4:
	        		putSystemServiceCodeItem(sysSvcCdItems, "Z5037");
	        		break;
	        	case 5:
	        		putSystemServiceCodeItem(sysSvcCdItems, "Z5047");
	        		break;
	        	}
	            break;
	        // 栄養改善加算 + 口腔機能向上加算
	        case 122:
	            // 通所型複数サービス実施加算I３
	        	switch (pattern) {
	        	case 1:
	        		putSystemServiceCodeItem(sysSvcCdItems, "Z5008");
	        		break;
	        	case 2:
	        		putSystemServiceCodeItem(sysSvcCdItems, "Z5018");
	        		break;
	        	case 3:
	        		putSystemServiceCodeItem(sysSvcCdItems, "Z5028");
	        		break;
	        	case 4:
	        		putSystemServiceCodeItem(sysSvcCdItems, "Z5038");
	        		break;
	        	case 5:
	        		putSystemServiceCodeItem(sysSvcCdItems, "Z5048");
	        		break;
	        	}
	            break;
	        // 運動器機能向上加算 + 栄養改善加算 + 口腔機能向上加算
	        case 222:
	            // 通所型複数サービス実施加算II
	        	switch (pattern) {
	        	case 1:
	        		putSystemServiceCodeItem(sysSvcCdItems, "Z5009");
	        		break;
	        	case 2:
	        		putSystemServiceCodeItem(sysSvcCdItems, "Z5019");
	        		break;
	        	case 3:
	        		putSystemServiceCodeItem(sysSvcCdItems, "Z5029");
	        		break;
	        	case 4:
	        		putSystemServiceCodeItem(sysSvcCdItems, "Z5039");
	        		break;
	        	case 5:
	        		putSystemServiceCodeItem(sysSvcCdItems, "Z5049");
	        		break;
	        	}
	            break;
	        }
        }
    }

    /**
     * パターンにあった加算を設定します。
	 * @param _5060110 通所型サービス若年性認知症受入加算
	 * @param _16      通所型サービス同一建物減算
	 * @param _5060101 通所型サービス費　1-１ 2-２
	 * @param _5060105 生活機能向上グループ活動加算
	 * @param _5060109 事業所評価加算
	 * @param sysSvcCdItems サービスコードMap
	 * @param pattern パターン
     */
    private void setKasanServiceByPattern(int _5060110, int _16, int _5060101, int _5060105, int _5060109,
    		ArrayList<HashMap<String, String>> sysSvcCdItems,
    		int pattern) {
        // 通所型サービス若年性認知症受入加算
        if (_5060110 > 1) {
        	switch (pattern) {
        	case 1:
        		putSystemServiceCodeItem(sysSvcCdItems, "Z6109");
        		break;
        	case 2:
        		putSystemServiceCodeItem(sysSvcCdItems, "Z6129");
        		break;
        	case 3:
        		putSystemServiceCodeItem(sysSvcCdItems, "Z6139");
        		break;
        	case 4:
        		putSystemServiceCodeItem(sysSvcCdItems, "Z6149");
        		break;
        	case 5:
        		putSystemServiceCodeItem(sysSvcCdItems, "Z6159");
        		break;
        	}
        }
        
        // 同一建物居住者へのサービス提供がありの場合
        if (_16 > 1) {
            
            // 通所型サービス費で分岐
            switch(_5060101) {
            // 通所型サービス１
            case 1:
                // 通所型サービス同一建物減算１
            	switch (pattern) {
            	case 1:
	                putSystemServiceCodeItem(sysSvcCdItems, "Z6105");
	        		break;
	        	case 2:
	        		putSystemServiceCodeItem(sysSvcCdItems, "Z6125");
	        		break;
	        	case 3:
	        		putSystemServiceCodeItem(sysSvcCdItems, "Z6135");
	        		break;
	        	case 4:
	        		putSystemServiceCodeItem(sysSvcCdItems, "Z6145");
	        		break;
	        	case 5:
	        		putSystemServiceCodeItem(sysSvcCdItems, "Z6155");
	        		break;
            	}
                break;
            // 通所型サービス２
            case 2:
                // 通所型サービス同一建物減算２
            	switch (pattern) {
            	case 1:
	                putSystemServiceCodeItem(sysSvcCdItems, "Z6106");
	        		break;
	        	case 2:
	        		putSystemServiceCodeItem(sysSvcCdItems, "Z6126");
	        		break;
	        	case 3:
	        		putSystemServiceCodeItem(sysSvcCdItems, "Z6136");
	        		break;
	        	case 4:
	        		putSystemServiceCodeItem(sysSvcCdItems, "Z6146");
	        		break;
	        	case 5:
	        		putSystemServiceCodeItem(sysSvcCdItems, "Z6156");
	        		break;
            	}
                break;
            }
            
        }
        
        // 生活機能向上グループ活動加算　1-なし 2-あり
        if (_5060105 > 1) {
        	switch (pattern) {
        	case 1:
        		putSystemServiceCodeItem(sysSvcCdItems, "Z5010");
        		break;
        	case 2:
        		putSystemServiceCodeItem(sysSvcCdItems, "Z5020");
        		break;
        	case 3:
        		putSystemServiceCodeItem(sysSvcCdItems, "Z5030");
        		break;
        	case 4:
        		putSystemServiceCodeItem(sysSvcCdItems, "Z5040");
        		break;
        	case 5:
        		putSystemServiceCodeItem(sysSvcCdItems, "Z5050");
        		break;
        	}
        }
        
        // 事業所評価加算　1-なし 2-あり
        if (_5060109 > 1) {
        	switch (pattern) {
        	case 1:
        		putSystemServiceCodeItem(sysSvcCdItems, "Z5005");
        		break;
        	case 2:
        		putSystemServiceCodeItem(sysSvcCdItems, "Z5015");
        		break;
        	case 3:
        		putSystemServiceCodeItem(sysSvcCdItems, "Z5025");
        		break;
        	case 4:
        		putSystemServiceCodeItem(sysSvcCdItems, "Z5035");
        		break;
        	case 5:
        		putSystemServiceCodeItem(sysSvcCdItems, "Z5045");
        		break;
        	}
        }

    }
    
    /**
     * サービス提供体制強化加算を設定します。
	 * @param kihon 通所型サービス費　1-１ 2-２
	 * @param teikyokasan サービス提供体制強化加算
	 * @param sysSvcCdItems サービスコードMap
	 * @param pattern パターン
     */
    private void setServiceTeikyoKasanByPattern(int kihon, int teikyokasan,
    		ArrayList<HashMap<String, String>> sysSvcCdItems,
    		int pattern){
        switch (teikyokasan) {
        case 4:
            if (kihon == 1) {
                // 通所型サービス１の場合
                // 6101 通所型サービス提供体制加算Iイ１
            	switch (pattern) {
            	case 1:
            		putSystemServiceCodeItem(sysSvcCdItems, "Z6107");
            		break;
            	case 2:
            		putSystemServiceCodeItem(sysSvcCdItems, "Z6127");
            		break;
            	case 3:
            		putSystemServiceCodeItem(sysSvcCdItems, "Z6137");
            		break;
            	case 4:
            		putSystemServiceCodeItem(sysSvcCdItems, "Z6147");
            		break;
            	case 5:
            		putSystemServiceCodeItem(sysSvcCdItems, "Z6157");
            		break;
            	}
            } else if (kihon == 2) {
                // 通所型サービス２の場合
                // 6102 通所型サービス提供体制加算Iイ２
            	switch (pattern) {
            	case 1:
            		putSystemServiceCodeItem(sysSvcCdItems, "Z6108");
            		break;
            	case 2:
            		putSystemServiceCodeItem(sysSvcCdItems, "Z6128");
            		break;
            	case 3:
            		putSystemServiceCodeItem(sysSvcCdItems, "Z6138");
            		break;
            	case 4:
            		putSystemServiceCodeItem(sysSvcCdItems, "Z6148");
            		break;
            	case 5:
            		putSystemServiceCodeItem(sysSvcCdItems, "Z6158");
            		break;
            	}
            }
            break;
        case 2:
            if (kihon == 1) {
                // 通所型サービス１の場合
                // 6101 通所型サービス提供体制加算Iロ１
            	switch (pattern) {
            	case 1:
            		putSystemServiceCodeItem(sysSvcCdItems, "Z6101");
            		break;
            	case 2:
            		putSystemServiceCodeItem(sysSvcCdItems, "Z6121");
            		break;
            	case 3:
            		putSystemServiceCodeItem(sysSvcCdItems, "Z6131");
            		break;
            	case 4:
            		putSystemServiceCodeItem(sysSvcCdItems, "Z6141");
            		break;
            	case 5:
            		putSystemServiceCodeItem(sysSvcCdItems, "Z6151");
            		break;
            	}
            } else if (kihon == 2) {
                // 通所型サービス２の場合
                // 6102 通所型サービス提供体制加算Iロ２
            	switch (pattern) {
            	case 1:
            		putSystemServiceCodeItem(sysSvcCdItems, "Z6102");
            		break;
            	case 2:
            		putSystemServiceCodeItem(sysSvcCdItems, "Z6122");
            		break;
            	case 3:
            		putSystemServiceCodeItem(sysSvcCdItems, "Z6132");
            		break;
            	case 4:
            		putSystemServiceCodeItem(sysSvcCdItems, "Z6142");
            		break;
            	case 5:
            		putSystemServiceCodeItem(sysSvcCdItems, "Z6152");
            		break;
            	}
            }
            break;
        case 3:
            if (kihon == 1) {
                // 通所型サービス１の場合
                // 6103 通所型サービス提供体制加算II１
            	switch (pattern) {
            	case 1:
            		putSystemServiceCodeItem(sysSvcCdItems, "Z6103");
            		break;
            	case 2:
            		putSystemServiceCodeItem(sysSvcCdItems, "Z6123");
            		break;
            	case 3:
            		putSystemServiceCodeItem(sysSvcCdItems, "Z6133");
            		break;
            	case 4:
            		putSystemServiceCodeItem(sysSvcCdItems, "Z6143");
            		break;
            	case 5:
            		putSystemServiceCodeItem(sysSvcCdItems, "Z6153");
            		break;
            	}
            } else if (kihon == 2) {
                // 通所型サービス２の場合
                // 6104 通所型サービス提供体制加算II２
            	switch (pattern) {
            	case 1:
            		putSystemServiceCodeItem(sysSvcCdItems, "Z6104");
            		break;
            	case 2:
            		putSystemServiceCodeItem(sysSvcCdItems, "Z6124");
            		break;
            	case 3:
            		putSystemServiceCodeItem(sysSvcCdItems, "Z6134");
            		break;
            	case 4:
            		putSystemServiceCodeItem(sysSvcCdItems, "Z6144");
            		break;
            	case 5:
            		putSystemServiceCodeItem(sysSvcCdItems, "Z6154");
            		break;
            	}
            }
            break;
        }
    }
}
