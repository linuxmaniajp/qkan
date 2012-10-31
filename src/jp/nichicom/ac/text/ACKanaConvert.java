package jp.nichicom.ac.text;

/**
 * 平仮名、カタカナ変換クラスです。
 * <p>
 * Copyright (c) 2005 Nippon Computer Corporation. All Rights Reserved.
 * </p>
 * 
 * @author Shin Fujihara
 * @version 1.0 2006/02/10
 */
public class ACKanaConvert {
	
	//add sta s-fujihara 2004/6/10
	/**
	 * 全角⇒半角変換用テーブル（文字コード順にソート済み）
	 */
	private static final char[][] JP_2HALF_CHAR_TBL = {
		{0x3001,0xff64}, //、､
		{0x3002,0xff61}, //。｡
		{0x300c,0xff62}, //「｢
		{0x300d,0xff63}, //」｣
		
		{0x309b,0xff9e}, //゛ﾞ
		{0x309c,0xff9f}, //゜ﾟ
		
		{0x30a1,0xff67}, //ァｧ
		{0x30a2,0xff71}, //アｱ
		{0x30a3,0xff68}, //ィｨ
		{0x30a4,0xff72}, //イｲ
		{0x30a5,0xff69}, //ゥｩ
		{0x30a6,0xff73}, //ウｳ
		{0x30a7,0xff6a}, //ェｪ
		{0x30a8,0xff74}, //エｴ
		{0x30a9,0xff6b}, //ォｫ
		{0x30aa,0xff75}, //オｵ
		{0x30ab,0xff76}, //カｶ
		{0x30ac,0xff76,0xff9e}, //ガｶﾞ
		{0x30ad,0xff77}, //キｷ
		{0x30ae,0xff77,0xff9e}, //ギｷﾞ
		{0x30af,0xff78}, //クｸ
		
		{0x30b0,0xff78,0xff9e}, //グｸﾞ
		{0x30b1,0xff79}, //ケｹ
		{0x30b2,0xff79,0xff9e}, //ゲｹﾞ
		{0x30b3,0xff7a}, //コｺ
		{0x30b4,0xff7a,0xff9e}, //ゴｺﾞ
		{0x30b5,0xff7b}, //サｻ
		{0x30b6,0xff7b,0xff9e}, //ザｻﾞ
		{0x30b7,0xff7c}, //シｼ
		{0x30b8,0xff7c,0xff9e}, //ジｼﾞ
		{0x30b9,0xff7d}, //スｽ
		{0x30ba,0xff7d,0xff9e}, //ズｽﾞ
		{0x30bb,0xff7e}, //セｾ
		{0x30bc,0xff7e,0xff9e}, //ゼｾﾞ
		{0x30bd,0xff7f}, //ソｿ
		{0x30be,0xff7f,0xff9e}, //ゾｿﾞ
		{0x30bf,0xff80}, //タﾀ
		
		{0x30c0,0xff80,0xff9e}, //ダﾀﾞ
		{0x30c1,0xff81}, //チﾁ
		{0x30c2,0xff81,0xff9e}, //ヂﾁﾞ
		{0x30c3,0xff6f}, //ッｯ
		{0x30c4,0xff82}, //ツﾂ
		{0x30c5,0xff82,0xff9e}, //ヅﾂﾞ
		{0x30c6,0xff83}, //テﾃ
		{0x30c7,0xff83,0xff9e}, //デﾃﾞ
		{0x30c8,0xff84}, //トﾄ
		{0x30c9,0xff84,0xff9e}, //ドﾄﾞ
		{0x30ca,0xff85}, //ナﾅ
		{0x30cb,0xff86}, //ニﾆ
		{0x30cc,0xff87}, //ヌﾇ
		{0x30cd,0xff88}, //ネﾈ
		{0x30ce,0xff89}, //ノﾉ
		{0x30cf,0xff8a}, //ハﾊ
		
		{0x30d0,0xff8a,0xff9e}, //バﾊﾞ
		{0x30d1,0xff8a,0xff9f}, //パﾊﾟ
		{0x30d2,0xff8b}, //ヒﾋ
		{0x30d3,0xff8b,0xff9e}, //ビﾋﾞ
		{0x30d4,0xff8b,0xff9f}, //ピﾋﾟ
		{0x30d5,0xff8c}, //フﾌ
		{0x30d6,0xff8c,0xff9e}, //ブﾌﾞ
		{0x30d7,0xff8c,0xff9f}, //プﾌﾟ
		{0x30d8,0xff8d}, //ヘﾍ
		{0x30d9,0xff8d,0xff9e}, //ベﾍﾞ
		{0x30da,0xff8d,0xff9f}, //ペﾍﾟ
		{0x30db,0xff8e}, //ホﾎ
		{0x30dc,0xff8e,0xff9e}, //ボﾎﾞ
		{0x30dd,0xff8e,0xff9f}, //ポﾎﾟ
		{0x30de,0xff8f}, //マﾏ
		{0x30df,0xff90}, //ミﾐ
		
		{0x30e0,0xff91}, //ムﾑ
		{0x30e1,0xff92}, //メﾒ
		{0x30e2,0xff93}, //モﾓ
		{0x30e3,0xff6c}, //ャｬ
		{0x30e4,0xff94}, //ヤﾔ
		{0x30e5,0xff6d}, //ュｭ
		{0x30e6,0xff95}, //ユﾕ
		{0x30e7,0xff6e}, //ョｮ
		{0x30e8,0xff96}, //ヨﾖ
		{0x30e9,0xff97}, //ラﾗ
		{0x30ea,0xff98}, //リﾘ
		{0x30eb,0xff99}, //ルﾙ
		{0x30ec,0xff9a}, //レﾚ
		{0x30ed,0xff9b}, //ロﾛ
		{0x30ef,0xff9c}, //ワﾜ
		
		{0x30f2,0xff66}, //ヲｦ
		{0x30f3,0xff9d}, //ンﾝ
		{0x30fb,0xff65}, //・･
		{0x30fc,0xff70} //ーｰ
	};
	
	/**
	 * 半角⇒全角変換用テーブル（文字コード順にソート済み）
	 */
	private static final char[][] JP_2WIDTH_CHAR_TBL = {
		{0xff61,0x3002}, //｡。
		{0xff62,0x300c}, //｢「
		{0xff63,0x300d}, //｣」
		{0xff64,0x3001}, //､、
		{0xff65,0x30fb}, //･・
		{0xff66,0x30f2}, //ｦヲ
		{0xff67,0x30a1}, //ｧァ
		{0xff68,0x30a3}, //ｨィ
		{0xff69,0x30a5}, //ｩゥ
		{0xff6a,0x30a7}, //ｪェ
		{0xff6b,0x30a9}, //ｫォ
		{0xff6c,0x30e3}, //ｬャ
		{0xff6d,0x30e5}, //ｭュ
		{0xff6e,0x30e7}, //ｮョ
		{0xff6f,0x30c3}, //ｯッ
		{0xff70,0x30fc}, //ｰー
		{0xff71,0x30a2}, //ｱア
		{0xff72,0x30a4}, //ｲイ
		{0xff73,0x30a6}, //ｳウ
		{0xff74,0x30a8}, //ｴエ
		{0xff75,0x30aa}, //ｵオ
		{0xff76,0x30ab,0x30ac}, //ｶカガ
		{0xff77,0x30ad,0x30ae}, //ｷキギ
		{0xff78,0x30af,0x30b0}, //ｸクグ
		{0xff79,0x30b1,0x30b2}, //ｹケゲ
		{0xff7a,0x30b3,0x30b4}, //ｺコゴ
		{0xff7b,0x30b5,0x30b6}, //ｻサザ
		{0xff7c,0x30b7,0x30b8}, //ｼシジ
		{0xff7d,0x30b9,0x30ba}, //ｽスズ
		{0xff7e,0x30bb,0x30bc}, //ｾセゼ
		{0xff7f,0x30bd,0x30be}, //ｿソゾ
		{0xff80,0x30bf,0x30c0}, //ﾀタダ
		{0xff81,0x30c1,0x30c2}, //ﾁチヂ
		{0xff82,0x30c4,0x30c5}, //ﾂツヅ
		{0xff83,0x30c6,0x30c7}, //ﾃテデ
		{0xff84,0x30c8,0x30c9}, //ﾄトド
		{0xff85,0x30ca}, //ﾅナ
		{0xff86,0x30cb}, //ﾆニ
		{0xff87,0x30cc}, //ﾇヌ
		{0xff88,0x30cd}, //ﾈネ
		{0xff89,0x30ce}, //ﾉノ
		{0xff8a,0x30cf,0x30d0,0x30d1}, //ﾊハバパ
		{0xff8b,0x30d2,0x30d3,0x30d4}, //ﾋヒビピ
		{0xff8c,0x30d5,0x30d6,0x30d7}, //ﾌフブプ
		{0xff8d,0x30d8,0x30d9,0x30da}, //ﾍヘベペ
		{0xff8e,0x30db,0x30dc,0x30dd}, //ﾎホボポ
		{0xff8f,0x30de}, //ﾏマ
		{0xff90,0x30df}, //ﾐミ
		{0xff91,0x30e0}, //ﾑム
		{0xff92,0x30e1}, //ﾒメ
		{0xff93,0x30e2}, //ﾓモ
		{0xff94,0x30e4}, //ﾔヤ
		{0xff95,0x30e6}, //ﾕユ
		{0xff96,0x30e8}, //ﾖヨ
		{0xff97,0x30e9}, //ﾗラ
		{0xff98,0x30ea}, //ﾘリ
		{0xff99,0x30eb}, //ﾙル
		{0xff9a,0x30ec}, //ﾚレ
		{0xff9b,0x30ed}, //ﾛロ
		{0xff9c,0x30ef}, //ﾜワ
		{0xff9d,0x30f3}, //ﾝン
		{0xff9e,0x309b}, //ﾞ゛
		{0xff9f,0x309c} //ﾟ゜
	};
	

    /**
     * 文字列中の全角片仮名を全角平仮名に変換する。<br>
     * <br>
     * 
     * @param katakana 全角片仮名を含む文字列
     * @return 全角平仮名に変換後の文字列
     */
    public static String toHiragana(String katakana) {
        // 引数チェック
        if ((katakana == null) || (katakana.length() < 1))
            return katakana;

        char[] charAry = katakana.toCharArray();
        char temp;
        for (int i = 0; i < charAry.length; i++) {
            temp = charAry[i];
            // カタカナの範囲確認
            if ((0x30a1 <= temp) && (temp <= 0x30f6)) {
                charAry[i] -= 0x60;
            }
        }

        return String.valueOf(charAry);
    }

    /**
     * 文字列中の全角平仮名を全角片仮名に変換する。<br>
     * <br>
     * 
     * @param hiragana 全角平仮名を含む文字列
     * @return 全角片仮名に変換後の文字列
     */
    public static String toKatakana(String hiragana) {
        // 引数チェック
        if ((hiragana == null) || (hiragana.length() < 1))
            return hiragana;

        char[] charAry = hiragana.toCharArray();
        char temp;
        for (int i = 0; i < charAry.length; i++) {
            temp = charAry[i];
            // ひらがなの範囲確認
            if ((0x3041 <= temp) && (temp <= 0x3096)) {
                charAry[i] += 0x60;
            }
        }

        return String.valueOf(charAry);
    }
    
	/**
	 * 可能な限り指定文字列を全角へ変換する<BR>
	 * 
	 * @param	strPara 変換対象文字列<BR>
	 * @return 変換後文字列<BR>
	 */
	public static final String toFullWidth(String strPara){
		//nullよけ
		if(strPara == null){
			return null;
		}
		
		//他のメソッドを極力呼ばず､高速化
		StringBuffer strRet = new StringBuffer();
		int intWords = strPara.length();
		int code = 0;
		int codeIndex = -1;
		
		// 記号、数値　0x20 - 0x7e
		// 半角カナ 0xff61 - 0xff9f
		for(int i = 0; i < intWords; i++){
			code = strPara.charAt(i);
			//文字が記号､英数字であった場合の処理
			if((code >= 0x20) && (code <= 0x7e)){
				switch (code){
					//' '→'　'変換
					case 0x20:
						strRet.append((char)0x3000);
						break;
					//"→”変換
					case 0x22:
						strRet.append((char)0x201D);
						break;
					//'→’変換
					case 0x27:
						strRet.append((char)0x2019);
						break;
					//\→￥変換
					case 0x5C:
						strRet.append((char)0xFFE5);
						break;
					//その他の文字は0xfee0を加算してマッピング
					default:
						strRet.append((char)(code + 0xfee0));
						break;
				}
			
			//文字が半角カナであった場合の処理
			} else if((code >= 0xff61) && (code <= 0xff9f)) {
				switch (code) {
					//濁音(ﾞ)である場合
					case 0xff9e:
						//濁音文字に変換可能な場合、変換を行い文字を設定する
						if((codeIndex != -1) &&(JP_2WIDTH_CHAR_TBL[codeIndex].length >= 3)){
							strRet.deleteCharAt(strRet.length() - 1);
							strRet.append(JP_2WIDTH_CHAR_TBL[codeIndex][2]);
						//濁音文字への変換が行えなかった場合、全角の濁音記号を登録する
						} else {
							strRet.append((char)(0x309b));
						}
						codeIndex = -1;
						break;
					
					//半濁(ﾟ)である場合
					case 0xff9f:
						//段濁音文字に変換可能な場合､変換を行い文字を設定する
						if((codeIndex != -1) &&(JP_2WIDTH_CHAR_TBL[codeIndex].length >= 4)){
							strRet.deleteCharAt(strRet.length() - 1);
							strRet.append(JP_2WIDTH_CHAR_TBL[codeIndex][3]);
						//濁音文字への変換が行えなかった場合、全角の濁音記号を登録する
						} else {
							strRet.append((char)(0x309c));
						}
						codeIndex = -1;
						break;
					
					//それ以外の半角カナ文字の場合
					default:
						codeIndex = half2width(code);
						if(codeIndex != -1){
							strRet.append(JP_2WIDTH_CHAR_TBL[codeIndex][1]);
						//コード変換が行えなかった場合､そのままの文字を追加
						} else {
							strRet.append((char)code);
						}
						break;
				}
				
			//半角文字では無かった場合
			} else {
				strRet.append((char)code);
			}
		}
		return strRet.toString();
	}
	
	/**
	 * 半角カナ文字のコードを受け取り､対応する変換テーブルのインデックスを返す<BR>
	 * <br>
	 * @param code 変換を行う半角カナ文字の文字コード<BR>
	 * @return int 変換成功 : 変換テーブルのインデックス 変換失敗 : -1<BR>
	 */
	private static final int half2width(int code){
		//サーチを行っているデータのIndex
		int DataIndex;
		int DataStart = 0;
		int DataEnd = JP_2WIDTH_CHAR_TBL.length - 1;
		int chrTemp;
		
		//あらかじめ配列内のコードをソートしておき､２分検索を行う。
		while ( DataStart <= DataEnd ) {
			DataIndex = DataStart + ( DataEnd - DataStart ) / 2;
			chrTemp = JP_2WIDTH_CHAR_TBL[DataIndex][0];
			if (chrTemp > code ){
				DataEnd = DataIndex - 1;
			} else if (chrTemp < code ){
				DataStart = DataIndex + 1;
			} else {
				return DataIndex;
			}
		}
		//カナ変換テーブルに存在しないコードの場合-1を返す
		return -1;
	}

	/**
	 * 可能な限り指定文字列を半角へ変換する<BR>
	 * <br>
	 * @param	strPara 変換対象文字列<BR>
	 * @return 変換後文字列<BR>
	 */
	public static final String toHalfWidth(String strPara){
		//nullよけ
		if(strPara == null){
			return null;
		}
		
		//他のメソッドを極力呼ばず､高速化
		StringBuffer strRet = new StringBuffer();
		int intWords = strPara.length();
		int code = 0;
		int codeIndex = -1;
		
		// 全角記号、全角数値　0xff01 - 0xff5e
		// 全角カナ 0x3001 - 0x30fc //コードが連続せず、抜けがある
		for(int i = 0; i < intWords; i++){
			code = strPara.charAt(i);
			//文字が全角記号､全角英数字であった場合の処理
			if((code >= 0xff01) && (code <= 0xff5e)){
				//0xfee0を引いてマッピング
				strRet.append((char)(code - 0xfee0));
			
			//文字が半角カナであった場合の処理
			} else if((code >= 0x3001) && (code <= 0x30fc)) {
				codeIndex = width2half(code);
				//コード変換が行えた場合
				if(codeIndex != -1){
					//変換テーブルに記載されている文字に変換
					for (int j = 1; j < JP_2HALF_CHAR_TBL[codeIndex].length; j++){
						strRet.append(JP_2HALF_CHAR_TBL[codeIndex][j]);
					}
				//コード変換が行えなかった場合､そのままの文字を追加
				} else {
					strRet.append((char)code);
				}
				
			//例外のコード置換
			} else {
				switch (code){
					//‘→'変換
					case 0x2018:
						strRet.append((char)0x27);
						break;
					//’→'変換
					case 0x2019:
						strRet.append((char)0x27);
						break;
					//”→"
					case 0x201D:
						strRet.append((char)0x22);
						break;
					//'　'→' '
					case 0x3000:
						strRet.append((char)0x20);
						break;
					//、→､
					case 0x3001:
						strRet.append((char)0xFF64);
						break;
					case 0xFFE5:
						strRet.append((char)0x5C);
						break;
					//その他の文字はそのまま
					default:
						strRet.append((char)code);
						break;
				}
			}
		}
		return strRet.toString();
	}
	
	/**
	 * 全角カナ文字のコードを受け取り､対応する変換テーブルのインデックスを返す<BR>
	 * <br>
	 * @param code 変換を行う全角カナ文字の文字コード<BR>
	 * @return int 変換成功 : 変換テーブルのインデックス 変換失敗 : -1<BR>
	 */
	private static final int width2half(int code){
		//サーチを行っているデータのIndex
		int DataIndex;
		int DataStart = 0;
		int DataEnd = JP_2HALF_CHAR_TBL.length - 1;
		int chrTemp;
		
		//あらかじめ配列内のコードをソートしておき､２分検索を行う。
		while ( DataStart <= DataEnd ) {
			DataIndex = DataStart + ( DataEnd - DataStart ) / 2;
			chrTemp = JP_2HALF_CHAR_TBL[DataIndex][0];
			if (chrTemp > code ){
				DataEnd = DataIndex - 1;
			} else if (chrTemp < code ){
				DataStart = DataIndex + 1;
			} else {
				return DataIndex;
			}
		}
		//カナ変換テーブルに存在しないコードの場合-1を返す
		return -1;
	}

}