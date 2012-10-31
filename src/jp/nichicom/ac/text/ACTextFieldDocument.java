package jp.nichicom.ac.text;

import java.text.Format;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.StyleContext;

import jp.nichicom.vr.component.AbstractVRTextField;
import jp.nichicom.vr.text.VRTextFieldDocument;

/**
 * テキストフィールド用のドキュメントクラスです。
 * <p>
 * 改行文字を自動除去します。
 * </p>
 * <p>
 * Copyright (c) 2005 Nippon Computer Corporation. All Rights Reserved.
 * </p>
 * 
 * @author Tozo Tanaka
 * @version 1.0 2005/12/01
 * @see VRTextFieldDocument
 */

public class ACTextFieldDocument extends VRTextFieldDocument {
    private Format characterConverter;
    
    /**
     * コンストラクタです。
     * 
     * @param textField 検査対象のテキストフィールド
     */
    public ACTextFieldDocument(AbstractVRTextField textField) {
        super(textField);
    }

    /**
     * Constructs a styled document.
     * 
     * @param textField 検査対象のテキストフィールド
     * @param c the container for the content
     * @param styles resources and style definitions which may be shared across
     *            documents
     */
    public ACTextFieldDocument(AbstractVRTextField textField, Content c,
            StyleContext styles) {
        super(textField, c, styles);
    }

    /**
     * Constructs a styled document with the default content storage
     * implementation and a shared set of styles.
     * 
     * @param textField 検査対象のテキストフィールド
     * @param styles the styles
     */
    public ACTextFieldDocument(AbstractVRTextField textField,
            StyleContext styles) {
        super(textField, styles);
    }

    /**
     * 文字コード変換クラス を返します。
     * @return 文字コード変換クラス
     */
    public Format getCharacterConverter() {
        return characterConverter;
    }

    /**
     * 文字列挿入処理です。
     * 
     * @param offset オフセット
     * @param str 文字列
     * @param attr 属性
     * @throws BadLocationException 処理例外
     */
    public void insertString(int offset, String str, AttributeSet attr)
            throws BadLocationException {
        if (isInsertProcessDisabled(offset, str, attr)) {
            return;
        }
        if(str!=null){
            //VT(垂直タブ)と改行は除去
            str = str.replaceAll("\u000b", "").replaceAll(
                    "\n", "");
        }
        if(getCharacterConverter()!=null){
            //文字置換
            str = getCharacterConverter().format(str);
        }
        super.insertString(offset, str, attr);
    }
    
    /**
     * 文字コード変換クラス を設定します。
     * @param characterConverter 文字コード変換クラス
     */
    public void setCharacterConverter(Format characterConverter) {
        this.characterConverter = characterConverter;
    }



    /**
     * 変換対象の文字種別 を返します。
     * @return 変換対象の文字種別
     */
    public int getConvertFromCharacter() {
        if(getCharacterConverter() instanceof ACCharacterConverter){
            return ((ACCharacterConverter)getCharacterConverter()).getFromCharacter();
        }
        return 0;
    }

    /**
     * 変換結果の文字種別 を返します。
     * @return 変換結果の文字種別
     */
    public int getConvertToCharacter() {
        if(getCharacterConverter() instanceof ACCharacterConverter){
            return ((ACCharacterConverter)getCharacterConverter()).getToCharacter();
        }
        return 0;
    }
    /**
     * 文字変換クラスを生成して返します。
     * @return 文字変換クラス
     */
    protected ACCharacterConverter createCharacterConverter(){
        return new ACCharacterConverter();
    }

    /**
     * 変換対象の文字種別 を設定します。
     * @param fromCharacter 変換対象の文字種別
     */
    public void setConvertFromCharacter(int fromCharacter) {
        if(!(getCharacterConverter() instanceof ACCharacterConverter)){
            setCharacterConverter(createCharacterConverter());
        }
        ((ACCharacterConverter)getCharacterConverter()).setFromCharacter(fromCharacter);
    }
    
    /**
     * 変換結果の文字種別 を設定します。
     * @param toCharacter 変換結果の文字種別
     */
    public void setConvertToCharacter(int toCharacter) {
        if(!(getCharacterConverter() instanceof ACCharacterConverter)){
            setCharacterConverter(createCharacterConverter());
        }
        ((ACCharacterConverter)getCharacterConverter()).setToCharacter(toCharacter);
    }
    
    
}
