/** TODO <HEAD> */
package jp.nichicom.vr.component;

import java.awt.event.FocusEvent;
import java.awt.event.InputMethodEvent;
import java.awt.font.TextHitInfo;
import java.awt.im.InputSubset;
import java.text.Format;
import java.text.ParseException;

import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.text.Document;
import javax.swing.text.Element;
import javax.swing.text.StyleConstants;

import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.bind.VRBindSource;
import jp.nichicom.vr.bind.VRBindable;
import jp.nichicom.vr.bind.event.VRBindEvent;
import jp.nichicom.vr.bind.event.VRBindEventListener;
import jp.nichicom.vr.component.event.VRFormatEvent;
import jp.nichicom.vr.component.event.VRFormatEventListener;
import jp.nichicom.vr.text.AbstractVRTextDocument;
import jp.nichicom.vr.text.VRCharType;
import jp.nichicom.vr.text.VRTextFieldDocument;

/**
 * バインド機構を実装したテキストフィールドの基底クラスです。
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
 * @version 1.0 2006/03/31
 * @see JTextField
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
public abstract class AbstractVRTextField extends JTextField implements
        VRTextFieldar {

    private boolean autoApplySource = false;

    private String bindPath;

    private boolean borderless;

    private boolean byteMaxLength = false;

    private VRCharType charType;

    private boolean focusSelcetAll = false;

    private Format format;

    private int maxLength;

    private int minLength;

    private Object model = "";

    private Border oldBorder;

    private VRBindSource source;

    /**
     * Constructs a new <code>TextField</code>. A default model is created,
     * the initial string is <code>null</code>, and the number of columns is
     * set to 0.
     */
    public AbstractVRTextField() {
        super();
        initComponent();
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
    public AbstractVRTextField(Document doc, String text, int columns) {
        super(doc, text, columns);
        initComponent();
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
    public AbstractVRTextField(int columns) {
        super(columns);
        initComponent();
    }

    /**
     * Constructs a new <code>TextField</code> initialized with the specified
     * text. A default model is created and the number of columns is 0.
     * 
     * @param text the text to be displayed, or <code>null</code>
     */
    public AbstractVRTextField(String text) {
        super(text);
        initComponent();
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
    public AbstractVRTextField(String text, int columns) {
        super(text, columns);
        initComponent();
    }

    public void addBindEventListener(VRBindEventListener listener) {
        listenerList.add(VRBindEventListener.class, listener);
    }

    /**
     * フォーマットイベントリスナを追加します。
     * 
     * @param listener フォーマットイベントリスナ
     */
    public void addFormatEventListener(VRFormatEventListener listener) {
        listenerList.add(VRFormatEventListener.class, listener);
    }

    public void applySource() throws ParseException {
        if (VRBindPathParser.set(getBindPath(), getSource(), getModel())) {
            fireApplySource(new VRBindEvent(this));
        }
    }

    public void bindSource() throws ParseException {
        if(!VRBindPathParser.has(getBindPath(), getSource())){
            return;
        }
        Object obj = VRBindPathParser.get(getBindPath(), getSource());

        Document doc = getDocument();
        if (doc instanceof AbstractVRTextDocument) {
            // 入力制限解除
            ((AbstractVRTextDocument) doc).setAbsoluteEditable(true);
        }

        if (obj == null) {
            super.setText("");
            setModel(null);
        } else {

            Format fmt = getFormat();
            if (fmt != null) {
                super.setText(fmt.format(obj));
                setModel(obj);
            } else {
                String text = String.valueOf(obj);
                super.setText(text);
                setModel(text);
            }

        }
        if (doc instanceof AbstractVRTextDocument) {
            // 入力制限復帰
            ((AbstractVRTextDocument) doc).setAbsoluteEditable(false);
        }

        fireBindSource(new VRBindEvent(this));
    }

    public Object createSource() {
        if (getFormat() == null) {
            return "";
        }
        return null;
    }

    /**
     * バインドイベントリスナを返します。
     * 
     * @return バインドイベントリスナ
     */
    public synchronized VRBindEventListener[] getBindEventListeners() {
        return (VRBindEventListener[]) (getListeners(VRBindEventListener.class));
    }

    public String getBindPath() {
        return bindPath;
    }

    /**
     * 文字種制を返します。
     * 
     * @return 文字種制限
     */
    public VRCharType getCharType() {
        return this.charType;
    }

    /**
     * フォーマットを返します。
     * 
     * @return フォーマット
     */
    public Format getFormat() {
        return this.format;
    }

    /**
     * フォーマットイベントリスナを返します。
     * 
     * @return フォーマットイベントリスナ
     */
    public synchronized VRFormatEventListener[] getFormatEventListeners() {
        return (VRFormatEventListener[]) (getListeners(VRFormatEventListener.class));
    }

    /**
     * 最大文字数を返します。
     * 
     * @return 最大文字数
     */
    public int getMaxLength() {
        return this.maxLength;
    }

    /**
     * 最小文字数を返します。
     * 
     * @return 最小文字数
     */
    public int getMinLength() {
        return this.minLength;
    }

    /**
     * モデルデータを返します。
     * 
     * @return モデルデータ
     */
    public Object getModel() {
        return model;
    }

    public VRBindSource getSource() {
        return source;
    }

    public boolean isAutoApplySource() {
        return this.autoApplySource;
    }

    /**
     * ボーダーの設定を許可するか を返します。
     * 
     * @return ボーダーの設定を許可するか
     */
    public boolean isBorderless() {
        return borderless;
    }

    /**
     * 最大文字列長を文字数ではなくバイト数で判断するか を返します。
     * 
     * @return 最大文字列長をバイト数で判断するか
     */
    public boolean isByteMaxLength() {
        return byteMaxLength;
    }

    /**
     * フォーカス取得時に文字列を全選択するか を返します。
     * 
     * @return フォーカス取得時に文字列を全選択するか
     */
    public boolean isFocusSelcetAll() {
        return focusSelcetAll;
    }

    public void removeBindEventListener(VRBindEventListener listener) {
        listenerList.remove(VRBindEventListener.class, listener);
    }

    /**
     * フォーマットイベントリスナを削除します。
     * 
     * @param listener フォーマットイベントリスナ
     */
    public void removeFormatEventListener(VRFormatEventListener listener) {
        listenerList.remove(VRFormatEventListener.class, listener);
    }

    public void setAutoApplySource(boolean autoApplySource) {
        this.autoApplySource = autoApplySource;
    }

    /**
     * バインドパスを設定します。
     * 
     * @param bindPath バインドパス
     */
    public void setBindPath(String bindPath) {
        this.bindPath = bindPath;
    }

    public void setBorder(Border border) {
        oldBorder = border;
        if ((border == null) || (!isBorderless())) {
            super.setBorder(border);
        }
    }

    /**
     * ボーダーの設定を許可するか を設定します。
     * 
     * @param borderless ボーダーの設定を許可するか
     */
    public void setBorderless(boolean borderless) {
        if (this.borderless == borderless) {
            return;
        }
        if (this.borderless) {
            // 変更前がボーダレスで新たにボーダーを許可する → ボーダーを復帰する
            this.borderless = borderless;
            super.setBorder(oldBorder);
        } else {
            // 変更前はボーダーがあり、新たにボーダレスにする
            this.borderless = borderless;
            super.setBorder(null);
        }
    }

    /**
     * 最大文字列長を文字数ではなくバイト数で判断するか を設定します。
     * 
     * @param byteMaxLength 最大文字列長をバイト数で判断するか
     */
    public void setByteMaxLength(boolean byteMaxLength) {
        this.byteMaxLength = byteMaxLength;
    }

    /**
     * 文字種制を設定します。
     * 
     * @param charType 文字種制限
     */
    public void setCharType(VRCharType charType) {
        this.charType = charType;
    }

    /**
     * フォーカス取得時に文字列を全選択するか を設定します。
     * 
     * @param focusSelcetAll フォーカス取得時に文字列を全選択するか
     */
    public void setFocusSelcetAll(boolean focusSelcetAll) {
        this.focusSelcetAll = focusSelcetAll;
    }

    /**
     * フォーマットを設定します。
     * 
     * @param format フォーマット
     */
    public void setFormat(Format format) {
        this.format = format;
    }

    /**
     * 最大文字数を設定します。
     * 
     * @param maxLength 最大文字数
     */
    public void setMaxLength(int maxLength) {
        if (maxLength < getMinLength()) {
            return;
        }
        this.maxLength = maxLength;
    }

    /**
     * 最小文字数を設定します。
     * 
     * @param minLength 最小文字数
     */
    public void setMinLength(int minLength) {
        if (minLength > getMaxLength()) {
            return;
        }
        if (minLength < 0) {
            return;
        }
        this.minLength = minLength;
    }

    public void setSource(VRBindSource source) {
        this.source = source;
    }

    public void setText(String text) {

        Document doc = getDocument();
        if (doc instanceof AbstractVRTextDocument) {
            // 入力制限解除
            ((AbstractVRTextDocument) doc).setAbsoluteEditable(true);
        }

        Format fmt = getFormat();
        if (fmt != null) {
            setModelValueOnFormat(text);
        } else {
            setModel(text);
            super.setText(text);
        }

        if (doc instanceof AbstractVRTextDocument) {
            // 入力制限復帰
            ((AbstractVRTextDocument) doc).setAbsoluteEditable(false);
        }

        if (isAutoApplySource()) {
            try {
                applySource();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 入力チェックに使用するドキュメントを生成します。 <br />
     * Factory Method Pattern
     * 
     * @return ドキュメント
     */
    protected Document createDocument() {
        return new VRTextFieldDocument(this);
    }

    /**
     * バインドイベントリスナを全走査してapplySourceイベントを呼び出します。
     * 
     * @param e イベント情報
     */
    protected void fireApplySource(VRBindEvent e) {
        VRBindEventListener[] listeners = getBindEventListeners();
        for (int i = 0; i < listeners.length; i++) {
            listeners[i].applySource(e);
        }
    }

    /**
     * バインドイベントリスナを全走査してapplySourceイベントを呼び出します。
     * 
     * @param e イベント情報
     */
    protected void fireBindSource(VRBindEvent e) {
        VRBindEventListener[] listeners = getBindEventListeners();
        for (int i = 0; i < listeners.length; i++) {
            listeners[i].bindSource(e);
        }
    }

    /**
     * フォーマットイベントリスナを全走査してformatErrorイベントを発火します。
     * 
     * @param e イベント情報
     */
    protected void fireFormatInvalid(VRFormatEvent e) {
        VRFormatEventListener[] listeners = getFormatEventListeners();
        for (int i = 0; i < listeners.length; i++) {
            listeners[i].formatInvalid(e);
        }
    }

    /**
     * フォーマットイベントリスナを全走査してformatValidイベントを発火します。
     * 
     * @param e イベント情報
     */
    protected void fireFormatValid(VRFormatEvent e) {
        VRFormatEventListener[] listeners = getFormatEventListeners();
        for (int i = 0; i < listeners.length; i++) {
            listeners[i].formatValid(e);
        }
    }

    /**
     * コンストラクタ実行後に必ず呼ばれる初期化処理です。
     */
    protected void initComponent() {
        setDocument(createDocument());
    }

    protected void processFocusEvent(FocusEvent e) {
        int id = e.getID();
        switch (id) {
        case FocusEvent.FOCUS_GAINED: {
            processFocusGained(e);
            break;
        }
        case FocusEvent.FOCUS_LOST: {
            processFocusLost(e);
            break;
        }
        }

        super.processFocusEvent(e);
    }

    /**
     * フォーカス取得時の追加処理を行ないます。
     * 
     * @param e イベント情報
     */
    protected void processFocusGained(FocusEvent e) {
        if (isFocusSelcetAll()) {
            selectAll();
        }
    }

    /**
     * フォーカス喪失時の追加処理を行ないます。
     * 
     * @param e イベント情報
     */
    protected void processFocusLost(FocusEvent e) {
        removeUndecidedCharacters();

        // 変化があった場合
        String text = getText();
        setText(text);

        // エラー時に戻す場合
        Format fmt = getFormat();
        if (fmt != null) {
            // 変化がない→return
            if (text.equals(getText())) {
                // 最後に適正とされた状態に戻す
                Object mdl = getModel();
                if (mdl == null) {
                    super.setText("");
                } else {
                    super.setText(fmt.format(mdl));
                }
            }
        }
    }

    /**
     * IMEの未確定文字列を削除します。
     */
    protected void removeUndecidedCharacters() {
        if (!(getDocument() instanceof AbstractVRTextDocument)) {
            return;
        }
        AbstractVRTextDocument doc = (AbstractVRTextDocument) getDocument();

        int begin = -1; // 削除対象先頭位置
        int len = 0; // 削除する文字数

        int end = doc.getLength();
        // 文字列の属性を一文字ずつ調べる
        for (int i = 0; i < end; i++) {
            Element elem = doc.getCharacterElement(i);
            if (elem.getAttributes().isDefined(
                    StyleConstants.ComposedTextAttribute)) { // IMEの未確定文字列だった場合
                begin = i;
                break;
            }
        }
        if (begin >= 0) {
            len = 1;
            for (int i = begin + 1; i < end; i++) {
                Element elem = doc.getCharacterElement(i);
                if (elem.getAttributes().isDefined(
                        StyleConstants.ComposedTextAttribute)) { // IMEの未確定文字列だった場合
                    len++;
                } else {
                    break;
                }
            }
        }

        if (len != 0) {
            try {
                // IMEの未確定文字列を削除する
                doc.superRemove(begin, len);

                // 架空のInputEventを発生させて、キャレットを設定する
                processInputMethodEvent(new InputMethodEvent(this,
                        InputMethodEvent.INPUT_METHOD_TEXT_CHANGED, null, 0,
                        TextHitInfo.beforeOffset(0), null));

            } catch (Exception ex) {

            }
        }
    }

    /**
     * モデルデータを設定します。
     * 
     * @param model モデルデータ
     */
    protected void setModel(Object model) {
        this.model = model;
    }

    /**
     * モデルにフォーマッタを通してテキストを設定します。
     * 
     * @param text 設定値
     */
    protected void setModelValueOnFormat(String text) {
        Format fmt = getFormat();
        String val = text.trim();
        try {
            Object mdl = fmt.parseObject(val);
            String formated = fmt.format(mdl);

            // FormatValidイベント発火
            Object old = getModel();
            setModel(mdl);

            super.setText(formated);
            fireFormatValid(new VRFormatEvent(this, old, val));
        } catch (ParseException e) {
            // FormatErrorイベント発火
            Object old = getModel();
            fireFormatInvalid(new VRFormatEvent(this, old, val));
        }
    }
}