package jp.or.med.orca.qkan.component;

import java.awt.Color;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.text.Format;
import java.util.Calendar;
import java.util.Date;

import javax.swing.Action;
import javax.swing.BoundedRangeModel;
import javax.swing.ToolTipManager;
import javax.swing.event.CaretListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Caret;
import javax.swing.text.DefaultCaret;
import javax.swing.text.Document;
import javax.swing.text.Highlighter;
import javax.swing.text.Keymap;
import javax.swing.text.NavigationFilter;

import jp.nichicom.ac.ACConstants;
import jp.nichicom.ac.component.ACButton;
import jp.nichicom.ac.component.ACDateTextField;
import jp.nichicom.ac.container.ACPanel;
import jp.nichicom.ac.text.ACBorderBlankDateFormat;
import jp.nichicom.ac.util.ACCalendarDialog;
import jp.nichicom.vr.component.VRTextFieldar;
import jp.nichicom.vr.component.event.VRFormatEventListener;
import jp.nichicom.vr.layout.VRLayout;
import jp.nichicom.vr.text.parsers.VRDateParser;

/**
 * カレンダー表示ボタンをつけた日付入力用テキストフィールドです。
 * <p>
 * 日付として不適切な値を入力した場合、着色します。
 * </p>
 * <p>
 * Copyright (c) 2005 Nippon Computer Corporation. All Rights Reserved.
 * </p>
 * 
 * @author Tozo Tanaka
 * @version 1.0 2006/03/31
 * @see ACDateTextField
 */

public class QkanDateTextField extends ACPanel implements VRTextFieldar,
        FocusListener, MouseWheelListener, MouseListener, MouseMotionListener,
        InputMethodListener, KeyListener {
    private ACButton calendarButton = new ACButton();
    private ACDateTextField textValue;

    /**
     * コンストラクタです。
     */
    public QkanDateTextField() {
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addCaretListener(CaretListener listener) {
        getMainContent().addCaretListener(listener);
    }

    public void addFormatEventListener(VRFormatEventListener listener) {
        getMainContent().addFormatEventListener(listener);
    }

    public void caretPositionChanged(InputMethodEvent event) {
        processInputMethodEvent(event);
    }

    public void copy() {
        getMainContent().copy();
    }

    public Object createSource() {
        return getMainContent().createSource();
    }

    public void cut() {
        getMainContent().cut();
    }

    public void focusGained(FocusEvent e) {
        processFocusEvent(e);
    }
    
    public void focusLost(FocusEvent e) {
        processFocusEvent(e);
    }

    public Action getAction() {
        return getMainContent().getAction();
    }

    public Action[] getActions() {
        return getMainContent().getActions();
    }

    public String getBindPath() {
        return getMainContent().getBindPath();
    }

    public Caret getCaret() {
        return getMainContent().getCaret();
    }

    public Color getCaretColor() {
        return getMainContent().getCaretColor();
    }

    public CaretListener[] getCaretListeners() {
        return textValue.getCaretListeners();
    }

    public int getCaretPosition() {
        return getMainContent().getCaretPosition();
    }

    /**
     * Returns the number of columns in this <code>TextField</code>.
     * 
     * @return the number of columns >= 0
     */
    public int getColumns() {
        return getMainContent().getColumns();
    }

    /**
     * 入力値をDate型で取得します。
     * 
     * @return 入力値
     * @throws Exception 処理例外
     */
    public Date getDate() throws Exception {
        return VRDateParser.parse(getText());
    }

    public Color getDisabledTextColor() {
        return getMainContent().getDisabledTextColor();
    }

    /**
     * Fetches the model associated with the editor. This is primarily for the
     * UI to get at the minimal amount of state required to be a text editor.
     * Subclasses will return the actual type of the model which will typically
     * be something that extends Document.
     * 
     * @return the model
     */
    public Document getDocument() {
        return getMainContent().getDocument();
    }

    public boolean getDragEnabled() {
        return getMainContent().getDragEnabled();
    }

    public char getFocusAccelerator() {
        return getMainContent().getFocusAccelerator();
    }

    /**
     * フォーマットを返します。
     * 
     * @return フォーマット
     */
    public Format getFormat() {
        return getMainContent().getFormat();
    }

    /**
     * 未来日付判定の基準となる現在日時 を返します。
     * <p>
     * リアルタイムな現在日時を使う場合はnullを指定します。
     * </p>
     * 
     * @return 未来日付判定の基準となる現在日時
     */
    public Date getFutureBaseDate() {
        return getMainContent().getFutureBaseDate();
    }

    public Highlighter getHighlighter() {
        return getMainContent().getHighlighter();
    }

    public int getHorizontalAlignment() {
        return getMainContent().getHorizontalAlignment();
    }

    public BoundedRangeModel getHorizontalVisibility() {
        return getMainContent().getHorizontalVisibility();
    }

    public Keymap getKeymap() {
        return getMainContent().getKeymap();
    }

    public Insets getMargin() {
        return getMainContent().getMargin();
    }

    /**
     * 最大文字数を返します。
     * 
     * @return 最大文字数
     */
    public int getMaxLength() {
        return getMainContent().getMaxLength();
    }

    public NavigationFilter getNavigationFilter() {
        return getMainContent().getNavigationFilter();
    }

    /**
     * エラー時に検索する親階層の数を返します。
     * 
     * @return エラー時に検索する親階層
     */
    public int getParentFindCount() {
        return getMainContent().getParentFindCount();
    }

    public int getScrollOffset() {
        return getMainContent().getScrollOffset();
    }

    public String getSelectedText() {
        return getMainContent().getSelectedText();
    }

    public Color getSelectedTextColor() {
        return getMainContent().getSelectedTextColor();
    }

    public Color getSelectionColor() {
        return getMainContent().getSelectionColor();
    }

    public int getSelectionEnd() {
        return getMainContent().getSelectionEnd();
    }

    public int getSelectionStart() {
        return getMainContent().getSelectionStart();
    }

    /**
     * Returns the text contained in this <code>TextComponent</code>. If the
     * underlying document is <code>null</code>, will give a
     * <code>NullPointerException</code>.
     * 
     * @return the text
     * @exception NullPointerException if the document is <code>null</code>
     * @see #setText
     */
    public String getText() {
        return getMainContent().getText();
    }

    public String getText(int offs, int len) throws BadLocationException {
        return getMainContent().getText(offs, len);
    }

    public void inputMethodTextChanged(InputMethodEvent event) {
        processInputMethodEvent(event);
    }

    /**
     * 未入力を許可するか を返します。
     * 
     * @return 未入力を許可するか
     */
    public boolean isAllowedBlank() {
        return getMainContent().isAllowedBlank();
    }

    /**
     * 未来日付を許可するか を返します。
     * 
     * @return 未来日付を許可するか
     * @see #setFutureBaseDate(Date)
     */
    public boolean isAllowedFutureDate() {
        return getMainContent().isAllowedFutureDate();
    }

    /**
     * Returns the boolean indicating whether this <code>TextComponent</code>
     * is editable or not.
     * 
     * @return the boolean value
     * @see #setEditable
     */
    public boolean isEditable() {
        return getMainContent().isEditable() && calendarButton.isEnabled();
    }

    /**
     * 有効な日付が入力されているかを返します。
     * 
     * @return 有効な日付が入力されているか
     */
    public boolean isValidDate() {
        return getMainContent().isValidDate();
    }

    public void keyPressed(KeyEvent e) {
        processKeyEvent(e);
    }

    public void keyReleased(KeyEvent e) {
        processKeyEvent(e);
    }

    public void keyTyped(KeyEvent e) {
        processKeyEvent(e);
    }

    public Rectangle modelToView(int pos) throws BadLocationException {
        return getMainContent().modelToView(pos);
    }

    public void mouseClicked(MouseEvent e) {
        processMouseEvent(e);
    }

    public void mouseDragged(MouseEvent e) {
        processMouseMotionEvent(e);
    }

    public void mouseEntered(MouseEvent e) {
        processMouseEvent(e);
    }

    public void mouseExited(MouseEvent e) {
        processMouseEvent(e);
    }

    public void mouseMoved(MouseEvent e) {
        processMouseMotionEvent(e);
    }

    public void mousePressed(MouseEvent e) {
        processMouseEvent(e);
    }

    public void mouseReleased(MouseEvent e) {
        processMouseEvent(e);
    }

    public void mouseWheelMoved(MouseWheelEvent e) {
        processMouseWheelEvent(e);
    }

    public void moveCaretPosition(int pos) {
        getMainContent().moveCaretPosition(pos);
    }

    public void paste() {
        getMainContent().paste();
    }

    public void postActionEvent() {
        getMainContent().postActionEvent();
    }

    public void read(Reader in, Object desc) throws IOException {
        getMainContent().read(in, desc);
    }

    public void removeCaretListener(CaretListener listener) {
        getMainContent().removeCaretListener(listener);
    }

    public void removeFormatEventListener(VRFormatEventListener listener) {
        getMainContent().removeFormatEventListener(listener);
    }

    public void replaceSelection(String content) {
        getMainContent().replaceSelection(content);
    }

    public void select(int selectionStart, int selectionEnd) {
        getMainContent().select(selectionStart, selectionEnd);
    }

    public void selectAll() {
        getMainContent().selectAll();
    }

    public void setAction(Action a) {
        getMainContent().setAction(a);
    }

    public void setActionCommand(String command) {
        getMainContent().setActionCommand(command);
    }

    /**
     * 未入力を許可するか を設定します。
     * 
     * @param allowedBlank 未入力を許可するか
     */
    public void setAllowedBlank(boolean allowedBlank) {
        getMainContent().setAllowedBlank(allowedBlank);
    }

    /**
     * 未来日付を許可するか を設定します。
     * 
     * @param allowedFutureDate 未来日付を許可するか
     */
    public void setAllowedFutureDate(boolean allowedFutureDate) {
        getMainContent().setAllowedFutureDate(allowedFutureDate);
    }

    public void setBindPath(String bindPath) {
        getMainContent().setBindPath(bindPath);
    }

    public void setCaret(Caret c) {
        getMainContent().setCaret(c);
    }

    public void setCaretColor(Color c) {
        getMainContent().setCaretColor(c);
    }

    public void setCaretPosition(int position) {
        getMainContent().setCaretPosition(position);
    }

    /**
     * Sets the number of columns in this <code>TextField</code>, and then
     * invalidate the layout.
     * 
     * @param columns the number of columns >= 0
     * @exception IllegalArgumentException if <code>columns</code> is less
     *                than 0
     * @beaninfo description: the number of columns preferred for display
     */
    public void setColumns(int columns) {
        getMainContent().setColumns(columns);
    }

    /**
     * 入力値をDate型で設定します。
     * 
     * @param value 入力値
     * @throws Exception 処理例外
     */
    public void setDate(Date value) throws Exception {
        getMainContent().setDate(value);
    }

    public void setDisabledTextColor(Color c) {
        getMainContent().setDisabledTextColor(c);
    }

    public void setDocument(Document document) {
        getMainContent().setDocument(document);
    }

    public void setDragEnabled(boolean b) {
        getMainContent().setDragEnabled(b);
    }

    public void setEditable(boolean editable) {
        getMainContent().setEditable(editable);
        calendarButton.setEnabled(editable);
    }

    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        getMainContent().setEnabled(enabled);
        calendarButton.setEnabled(enabled);
    }

    public void setFocusAccelerator(char aKey) {
        getMainContent().setFocusAccelerator(aKey);
    }

    /**
     * フォーマットを設定します。
     * 
     * @param format フォーマット
     */
    public void setFormat(Format format) {
        getMainContent().setFormat(format);
    }

    /**
     * 未来日付判定の基準となる現在日時 を設定します。
     * <p>
     * リアルタイムな現在日時を使う場合はnullを指定します。
     * </p>
     * 
     * @param futureBaseDate 未来日付判定の基準となる現在日時
     */
    public void setFutureBaseDate(Date futureBaseDate) {
        getMainContent().setFutureBaseDate(futureBaseDate);
    }

    public void setHighlighter(Highlighter h) {
        getMainContent().setHighlighter(h);
    }

    public void setHorizontalAlignment(int alignment) {
        getMainContent().setHorizontalAlignment(alignment);
    }

    public void setKeymap(Keymap map) {
        getMainContent().setKeymap(map);
    }

    public void setMargin(Insets m) {
        getMainContent().setMargin(m);
    }

    /**
     * 最大文字数を設定します。
     * 
     * @param maxLength 最大文字数
     */
    public void setMaxLength(int maxLength) {
        getMainContent().setMaxLength(maxLength);
    }

    public void setNavigationFilter(NavigationFilter filter) {
        getMainContent().setNavigationFilter(filter);
    }

    /**
     * エラー時に検索する親階層の数を設定します。
     * 
     * @param parentFindCount エラー時に検索する親階層
     */
    public void setParentFindCount(int parentFindCount) {
        getMainContent().setParentFindCount(parentFindCount);
    }

    public void setScrollOffset(int scrollOffset) {
        getMainContent().setScrollOffset(scrollOffset);
    }

    public void setSelectedTextColor(Color c) {
        getMainContent().setSelectedTextColor(c);
    }

    public void setSelectionColor(Color c) {
        getMainContent().setSelectionColor(c);
    }

    public void setSelectionEnd(int selectionEnd) {
        getMainContent().setSelectionEnd(selectionEnd);
    }

    public void setSelectionStart(int selectionStart) {
        getMainContent().setSelectionStart(selectionStart);
    }

    /**
     * Sets the text of this <code>TextComponent</code> to the specified text.
     * If the text is <code>null</code> or empty, has the effect of simply
     * deleting the old text. When text has been inserted, the resulting caret
     * location is determined by the implementation of the caret class.
     * <p>
     * This method is thread safe, although most Swing methods are not. Please
     * see <A
     * HREF="http://java.sun.com/products/jfc/swingdoc-archive/threads.html">Threads
     * and Swing</A> for more information.
     * 
     * @param t the new text to be set
     * @see #getText
     * @see DefaultCaret
     * @beaninfo description: the text of this component
     */
    public void setText(String text) {
        getMainContent().setText(text);
    }

    public int viewToModel(Point pt) {
        return getMainContent().viewToModel(pt);
    }

    public void write(Writer out) throws IOException {
        getMainContent().write(out);
    }

    private void jbInit() throws Exception {
        calendarButton.setMargin(new Insets(0, 2, 0, 2));
        getMainContent().setFormat(new ACBorderBlankDateFormat("ggge年MM月dd日"));

        calendarButton.setIconPath(ACConstants.ICON_PATH_CALENDAR_12);
        calendarButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                Calendar cal = Calendar.getInstance();
                try {
                    cal.setTime(VRDateParser.parse(getMainContent().getText()));
                } catch (Exception e1) {
                    cal = Calendar.getInstance();
                }
                cal = ACCalendarDialog.showSingleDate(cal);
                if (cal != null) {
                    getMainContent().setText(
                            getMainContent().getFormat().format(cal));
                    //日付確定でフォーカスロストを擬似的に発生させる
                    processFocusEvent(new FocusEvent(QkanDateTextField.this,
                            FocusEvent.FOCUS_LOST));
                }
            }

        });
        this.setToolTipText("<html>以下のいずれの形式でも入力可能です。<br>"
                +"平成18年4月1日<br>"
                +"H18/4/1<br>"
                +"H180401<br>"
                +"2006/4/1<br>"
                +"20060401<br>"
                +"</html>"
                );
        this.setOpaque(false);
        this.add(getMainContent(), VRLayout.CLIENT);
        this.add(calendarButton, VRLayout.EAST);
        
        if(firstInitilize){
            firstInitilize = false;
            ToolTipManager.sharedInstance().setDismissDelay(ToolTipManager.sharedInstance().getDismissDelay()+500);
        }
    }
    private static boolean firstInitilize = true;

    /**
     * 内包した主項目 を生成して返します。
     * 
     * @return 内包した主項目
     */
    protected ACDateTextField createMainContent() {
        return new ACDateTextField();
    }

    /**
     * 内包した主項目 を返します。
     * 
     * @return 内包した主項目
     */
    protected ACDateTextField getMainContent() {
        if (textValue == null) {
            textValue = createMainContent();
            textValue.addFocusListener(this);
            textValue.addInputMethodListener(this);
            textValue.addKeyListener(this);
            textValue.addMouseListener(this);
            textValue.addMouseMotionListener(this);
            textValue.addMouseWheelListener(this);
        }
        return textValue;
    }

    protected void processFocusEvent(FocusEvent e) {
        if (e.getSource() == getMainContent()) {
            // 子のイベントを置換
            e.setSource(this);
        }
        super.processFocusEvent(e);
    }

    protected void processInputMethodEvent(InputMethodEvent e) {
        if (e.getSource() == getMainContent()) {
            // 子のイベントを置換
            e.setSource(this);
        }
        super.processInputMethodEvent(e);
    }

    protected void processKeyEvent(KeyEvent e) {
        if (e.getSource() == getMainContent()) {
            // 子のイベントを間接的に発行
            e = new KeyEvent(this, e.getID(), e.getWhen(), e.getModifiers(), e
                    .getKeyCode(), e.getKeyChar(), e.getKeyLocation());
        }
        super.processKeyEvent(e);
    }

    protected void processMouseEvent(MouseEvent e) {
        if (e.getSource() == getMainContent()) {
            // 子のイベントを間接的に発行
            e.setSource(this);
        }
        super.processMouseEvent(e);
    }

    protected void processMouseMotionEvent(MouseEvent e) {
        if (e.getSource() == getMainContent()) {
            // 子のイベントを間接的に発行
            e.setSource(this);
        }
        super.processMouseMotionEvent(e);
    }

    protected void processMouseWheelEvent(MouseWheelEvent e) {
        if (e.getSource() == getMainContent()) {
            // 子のイベントを置換
            e.setSource(this);
        }
        super.processMouseWheelEvent(e);
    }

    public void requestFocus(){
        getMainContent().requestFocus();
    }
}
