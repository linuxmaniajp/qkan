/** TODO <HEAD> */
package jp.nichicom.vr.component;

import java.awt.im.InputSubset;
import java.text.Format;

import javax.swing.text.Document;

import jp.nichicom.vr.bind.VRBindSource;
import jp.nichicom.vr.bind.VRBindable;
import jp.nichicom.vr.bind.event.VRBindEventListener;
import jp.nichicom.vr.component.event.VRFormatEventListener;
import jp.nichicom.vr.text.AbstractVRTextDocument;
import jp.nichicom.vr.text.VRCharType;

/**
 * バインド機構を実装したテキストフィールドです。
 * <p>
 * AbstractVRTextDocumentの導入によって入力可能な文字種別や最小・最大文字列長を制限する機能を実装しています。
 * </p>
 * <p>
 * InputSubset指定によるIMEモード制御を実装しています。
 * </p>
 * <p>
 * Format指定による入力値のフォーマット変換処理を実装しています。
 * </p>
 * <p>
 * Copyright (c) 2005 Nippon Computer Corporation. All Rights Reserved.
 * </p>
 * 
 * @author Tozo Tanaka
 * @version 1.0 2005/10/31
 * @see AbstractVRTextField
 * @see VRBindable
 * @see VRBindEventListener
 * @see VRBindSource
 * @see InputSubset
 * @see Format
 * @see VRFormatEventListener
 * @see VRCharType
 * @see AbstractVRTextDocument
 */
@SuppressWarnings("serial")
public class VRTextField extends AbstractVRTextField {

    /**
     * Constructs a new <code>TextField</code>. A default model is created,
     * the initial string is <code>null</code>, and the number of columns is
     * set to 0.
     */
    public VRTextField() {
        super();
    }

    /**
     * Constructs a new <code>JTextField</code> that uses the given text
     * storage model and the given number of columns. This is the constructor
     * through which the other constructors feed. If the document is
     * <code>null</code>, a default model is created.
     * 
     * @param doc the text storage to use; if this is <code>null</code>, a
     *            default will be provided by calling the
     *            <code>createDefaultModel</code> method
     * @param text the initial string to display, or <code>null</code>
     * @param columns the number of columns to use to calculate the preferred
     *            width >= 0; if <code>columns</code> is set to zero, the
     *            preferred width will be whatever naturally results from the
     *            component implementation
     * @exception IllegalArgumentException if <code>columns</code> < 0
     */
    public VRTextField(Document doc, String text, int columns) {
        super(doc, text, columns);
    }


    /**
     * Constructs a new empty <code>TextField</code> with the specified number
     * of columns. A default model is created and the initial string is set to
     * <code>null</code>.
     * 
     * @param columns the number of columns to use to calculate the preferred
     *            width; if columns is set to zero, the preferred width will be
     *            whatever naturally results from the component implementation
     */
    public VRTextField(int columns) {
        super(columns);
    }

    /**
     * Constructs a new <code>TextField</code> initialized with the specified
     * text. A default model is created and the number of columns is 0.
     * 
     * @param text the text to be displayed, or <code>null</code>
     */
    public VRTextField(String text) {
        super(text);
    }

    /**
     * Constructs a new <code>TextField</code> initialized with the specified
     * text and columns. A default model is created.
     * 
     * @param text the text to be displayed, or <code>null</code>
     * @param columns the number of columns to use to calculate the preferred
     *            width; if columns is set to zero, the preferred width will be
     *            whatever naturally results from the component implementation
     */
    public VRTextField(String text, int columns) {
        super(text, columns);
    }
}