package jp.nichicom.ac.component;

import java.text.Format;

import javax.swing.text.Document;

import jp.nichicom.ac.text.ACSimpleLongFormat;
import jp.nichicom.vr.text.VRCharType;

/**
 * 値をLongで管理するテキストフィールドです。
 * <p>
 * Copyright (c) 2005 Nippon Computer Corporation. All Rights Reserved.
 * </p>
 * 
 * @author Tozo Tanaka
 * @version 1.0 2006/03/31
 * @see ACTextField
 */
public class ACLongTextField extends ACTextField {
    private long createSourceValue;

    /**
     * Constructs a new <code>TextField</code>. A default model is created,
     * the initial string is <code>null</code>, and the number of columns is
     * set to 0.
     */
    public ACLongTextField() {
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
    public ACLongTextField(Document doc, String text, int columns) {
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
    public ACLongTextField(int columns) {
        super(columns);
    }

    /**
     * Constructs a new <code>TextField</code> initialized with the specified
     * text. A default model is created and the number of columns is 0.
     * 
     * @param text the text to be displayed, or <code>null</code>
     */
    public ACLongTextField(String text) {
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

    public ACLongTextField(String text, int columns) {
        super(text, columns);
    }

    public Object createSource() {
        return new Long(createSourceValue);
    }

    /**
     * createSourceで返却する初期値を設定します。
     * 
     * @return createSourceで返却する初期値
     */
    public long getCreateSourceValue() {
        return createSourceValue;
    }

    /**
     * createSourceで返却する初期値を設定します。
     * 
     * @param createSourceValue createSourceで返却する初期値
     */
    public void setCreateSourceValue(long createSourceValue) {
        this.createSourceValue = createSourceValue;
    }

    /**
     * デフォルトで使用するフォーマットを生成して返します。
     * 
     * @return デフォルトで使用するフォーマット
     */
    protected Format createFormat() {
        return new ACSimpleLongFormat();
    }

    protected void initComponent() {
        super.initComponent();

        setCharType(VRCharType.ONLY_NUMBER);
        setFormat(createFormat());
    }
}
