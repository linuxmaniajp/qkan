package jp.or.med.orca.qkan.text;

import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;

import jp.nichicom.ac.lang.ACCastUtilities;

public class QkanClaimStateFormat extends Format{
	
//	private static QkanClaimStateFormat format;
	
    private String affair = "01";
    
	private QkanClaimStateFormat(){
	}
    
    /**
     * コンストラクタ
     * 引数でプログラムの起動モードを指定します。<br>
     * 01:実績集計<br>
     * 02:利用者一覧（給付管理票）<br>
     * 03:利用者一覧（在宅サービス支援事業所請求）様式第二から第十<br>
     * 04:利用者一覧（在宅サービス提供事業所請求）様式第七<br>
     * 05:出荷直前の仕様変更に伴い未使用項目<br>
     * 06:利用者一覧（医療請求<br>
     * 07:利用者一覧(利用者向け印刷)<br>
     * 08:利用者一覧（介護給付費請求書）<br>
     * 
     * @param affair 業務モードを指定する。
     */
    public QkanClaimStateFormat(String affair){
        this.affair = affair;
    }
	
//	public static QkanClaimStateFormat getInstance(){
//		if(format == null){
//			format = new QkanClaimStateFormat();
//		}
//		return format;
//	}

	public Object parseObject(String source, ParsePosition pos) {
		if(source == null) return "";
		
		String result = "";
		
		//(null)
		if((source == null) || ("".equals(source))){
		//0:済
		} else if("済".equals(source)){
			result = "0";
		//1:印刷
		} else if("印刷".equals(source)){
			result = "1";
		//2:明済
		} else if("明済".equals(source)){
			result = "2";
        //4:明細CSV済
        } else if("明CSV済".equals(source)){
            result = "4";
        //8:給済
        } else if("給済".equals(source)){
            result = "8";
        //16:給CSV済
        } else if("給CSV済".equals(source)){
            result = "16";
        //32:利済
        } else if("利済".equals(source)){
            result = "32";
        //64:印刷済(医療)
        } else if("印刷済".equals(source)){
            result = "64";
        //128:請済
        } else if("請済".equals(source)){
            result = "128";
        //256:請CSV済
        } else if("明済".equals(source)){
            result = "256";
        }
		
		return result;
	}

	public StringBuffer format(Object obj, StringBuffer toAppendTo, FieldPosition pos) {
		if(obj == null) return new StringBuffer();
		
		String code = String.valueOf(obj);
		
		//(null)
		if((code == null) || ("".equals(code))){
			//空白
		//0:済
		} else if("0".equals(code)){
            if("01".equals(affair)){
                toAppendTo.append("済");
            }
		//1:印刷
		} else if("1".equals(code)){
			//toAppendTo.append("印刷");
            toAppendTo.append("印刷");
            
        } else {
            if("01".equals(affair)){
                toAppendTo.append("済");
            } else {
                int printed = ACCastUtilities.toInt(getPrintedCode(affair), 0);
                int csvOuted =  ACCastUtilities.toInt(getCSVOutCode(affair), 0);
                int printCode = ACCastUtilities.toInt(code,0);
                
                String appendStr = null;
                if((printCode & printed) > 0){
                    appendStr = "済";
                }
                if((printCode & csvOuted) > 0){
                    appendStr = "CSV";
                }
                if(appendStr != null){
                    toAppendTo.append(appendStr);
                }
            }

        }
		//2:明済
//		} else if("2".equals(code)){
//			//toAppendTo.append("明済");
//            toAppendTo.append("済");
//        //4:明細CSV済
//		} else if("4".equals(code)){
//            toAppendTo.append("CSV");
//        //8:給済
//        } else if("8".equals(code)){
//            //toAppendTo.append("給済");
//            toAppendTo.append("済");
//        //16:給CSV済
//        } else if("16".equals(code)){
//            toAppendTo.append("CSV");
//        //32:利済
//        } else if("32".equals(code)){
//            //toAppendTo.append("利済");
//            toAppendTo.append("済");
//        //64:印刷済(医療)
//        } else if("64".equals(code)){
//            //toAppendTo.append("印刷済");
//            toAppendTo.append("済");
//        //128:請済
//        } else if("128".equals(code)){
//            //toAppendTo.append("請済");
//            toAppendTo.append("済");
//        //256:請CSV済
//        } else if("256".equals(code)){
//            toAppendTo.append("CSV");
//        }
		
		return toAppendTo;
	}
    
    public static String getPrintedCode(String affair,Object presentCode) {
        int addition = 0;
        int code = 0;
        
        String codeTemp = getPrintedCode(affair);
        
        if((codeTemp != null) && (codeTemp.length() > 0)){
            try{
                code = Integer.parseInt(codeTemp);
            } catch(Exception e){}
        }
        
        //現在の印刷進捗フラグを取得
        if((presentCode != null) && (String.valueOf(presentCode).length() > 0)){
            try{
                addition = Integer.parseInt(String.valueOf(presentCode));
            } catch(Exception e){}
        }
        
        return String.valueOf(code | addition);
    }
    
    /**
     * 印刷実行後に更新するコードを取得する。
     * @param affair プログラムの起動モード
     * @param presentCode 現在の印刷進捗フラグ
     * @return
     */
    public static String getPrintedCode(String affair) {
        if((affair == null) || (affair.length() == 0)){
            return "";
        }
        
        String code = "";
        
        //実績集計
        if("01".equals(affair)){
            code = "0";
        //利用者一覧（給付管理票）
        } else if("02".equals(affair)){
            code = "8";
        //利用者一覧（在宅サービス支援事業所請求）様式第二から第十
        } else if("03".equals(affair)){
            code = "2";
        //利用者一覧（在宅サービス提供事業所請求）様式第七
        } else if("04".equals(affair)){
            code = "2";
        //出荷直前の仕様変更に伴い未使用項目
        } else if("05".equals(affair)){
            code = "";
        //利用者一覧（医療請求
        } else if("06".equals(affair)){
            code = "64";
        //利用者一覧(利用者向け印刷)
        } else if("07".equals(affair)){
            code = "32";
        //利用者一覧（介護給付費請求書）
        } else if("08".equals(affair)){
            code = "128";
        }
        
        return String.valueOf(code);
    }
    
    public static String getCSVOutCode(String affair,Object presentCode) {
        int addition = 0;
        int code = 0;
        
        String codeTemp = getCSVOutCode(affair);
        
        if((codeTemp != null) && (codeTemp.length() > 0)){
            try{
                code = Integer.parseInt(codeTemp);
            } catch(Exception e){}
        }
        
        //現在の印刷進捗フラグを取得
        if((presentCode != null) && (String.valueOf(presentCode).length() > 0)){
            try{
                addition = Integer.parseInt(String.valueOf(presentCode));
            } catch(Exception e){}
        }
        
        return String.valueOf(code | addition);
    }
    
    
    /**
     * CSV出力実行後に更新するコードを取得する。
     * @param affair プログラムの起動モード
     * @param presentCode 現在の印刷進捗フラグ
     * @return
     */
    public static String getCSVOutCode(String affair) {
        if((affair == null) || (affair.length() == 0)){
            return "";
        }
        
        String code = "";
        
        //実績集計
        if("01".equals(affair)){
            code = "";
        //利用者一覧（給付管理票）
        } else if("02".equals(affair)){
            code = "16";
        //利用者一覧（在宅サービス支援事業所請求）様式第二から第十
        } else if("03".equals(affair)){
            code = "4";
        //利用者一覧（在宅サービス提供事業所請求）様式第七
        } else if("04".equals(affair)){
            code = "4";
        //出荷直前の仕様変更に伴い未使用項目
        } else if("05".equals(affair)){
            code = "";
        //利用者一覧（医療請求
        } else if("06".equals(affair)){
            code = "";
        //利用者一覧(利用者向け印刷)
        } else if("07".equals(affair)){
            code = "";
        //利用者一覧（介護給付費請求書）
        } else if("08".equals(affair)){
            code = "256";
        }
        
        return String.valueOf(code);
        
    }

}
