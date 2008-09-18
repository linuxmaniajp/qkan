package jp.nichicom.copaychecker.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

/**
 * ユーティリティクラス
 * @version 1.00 4 August
 * @author shin fujihara
 */
public class Util {

	public static boolean isNull(String str){
		return (str == null) || ("".equals(trim(str)));
	}
	/**
	 * 文字列前後の空白、改行を取り除く
	 * @param str 対象データ
	 * @return 処理後の文字列
	 */
	public static String trim(String str){
		if(str == null) return "";
		
		char[] temp = str.toCharArray();
		int start = -1;
		int end = -1;
		//空白とみなす文字
		String comp = " " + "　" + "\n";
		
		for(int i = 0; i < temp.length; i++){
			if(comp.indexOf(temp[i]) == -1){
				start = i;
				break;
			}
		}
		//全て空白
		if(start == -1) return "";
		
		for(int i = temp.length - 1; i >= 0; i--){
			if(comp.indexOf(temp[i]) == -1){
				end = i;
				break;
			}
		}
		return str.substring(start,end + 1);
	}
	/**
	 * 指定されたパスのディレクトリを作成する。
	 * @param fileName ファイルパス
	 */
	public static void makeDir(String fileName){
		if(isNull(fileName)){
			return;
		}
	    File file = new File(fileName);
	    //フォルダがあれば、作成する
	    if(file.getParent() != null){
	    	File dir = new File(file.getParent());
	    	if(!dir.exists()){
		    	dir.mkdirs();
	    	}
	    }
	}
	
	/**
	 * 引数内に含まれる数字を全角に変換する。
	 * @param value
	 * @return
	 */
	public static String toWideNumber(String value){
		if (value == null){
			return null;
		}
		
		char[] ary = value.toCharArray();
		StringBuffer rst = new StringBuffer();
		
		for(int i = 0; i < ary.length; i++){
			
			switch(ary[i]){
			case '0':
				rst.append('０');
				break;
			case '1':
				rst.append('１');
				break;
			case '2':
				rst.append('２');
				break;
			case '3':
				rst.append('３');
				break;
			case '4':
				rst.append('４');
				break;
			case '5':
				rst.append('５');
				break;
			case '6':
				rst.append('６');
				break;
			case '7':
				rst.append('７');
				break;
			case '8':
				rst.append('８');
				break;
			case '9':
				rst.append('９');
				break;
			default:
				rst.append(ary[i]);
				break;
			}
			
		}
		return rst.toString();
		
	}
	
	/**
	 * 数値変換　変換できない場合は0を返却
	 * @param value
	 * @return
	 */
	public static int toInt(Object value) {
		int result = 0;
		
		try {
			result = Integer.parseInt(value.toString());
		} catch(Exception e){}
		
		return result;
	}
	
	/**
	 * ファイルのコピーを行う
	 * @param in
	 * @param out
	 * @throws Exception
	 */
    public static void copyFile(File in, File out) throws Exception {
        FileChannel sourceChannel = new
            FileInputStream(in).getChannel();
        FileChannel destinationChannel = new
            FileOutputStream(out).getChannel();
        sourceChannel.transferTo(0, sourceChannel.size(), destinationChannel);
        sourceChannel.close();
        destinationChannel.close();
    }
    
    public static String toStr(Object obj) {
        if (obj == null) return "";
        
        return obj.toString();
    }

}
