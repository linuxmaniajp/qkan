package jp.or.med.orca.qkan.affair.qp.qp004;

import jp.nichicom.ac.text.ACCharacterConverter;

//[ID:0000551][Tozo TANAKA] 2009/08 add begin 
public class QP004WideCommaCharacterConverter extends ACCharacterConverter {
    /**
     * 文字変換結果を返します。
     * @param src 変換元
     * @param toCharacter 変換結果の文字種別
     * @param fromCharacter 変換対象の文字種別
     * @return 文字変換結果
     */
    public String format(String src, int toCharacter, int fromCharacter) {
        //半角","を全角"、"に置換した上で、上位クラスで全角に変換する。
        return super.format(src.replaceAll(",", "、"), toCharacter, fromCharacter);
    }

    /**
     * コンストラクタです。
     */
    public QP004WideCommaCharacterConverter() {
        super();
    }

    /**
     * コンストラクタです。
     * @param toCharacter
     * @param fromCharacter
     */
    public QP004WideCommaCharacterConverter(int toCharacter, int fromCharacter) {
        super(toCharacter, fromCharacter);
    }

    /**
     * コンストラクタです。
     * @param toCharacter
     */
    public QP004WideCommaCharacterConverter(int toCharacter) {
        super(toCharacter);
    }

}
//[ID:0000551][Tozo TANAKA] 2009/08 add end
