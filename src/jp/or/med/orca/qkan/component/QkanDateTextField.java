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
 * �J�����_�[�\���{�^�����������t���͗p�e�L�X�g�t�B�[���h�ł��B
 * <p>
 * ���t�Ƃ��ĕs�K�؂Ȓl����͂����ꍇ�A���F���܂��B
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
     * �R���X�g���N�^�ł��B
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
     * ���͒l��Date�^�Ŏ擾���܂��B
     * 
     * @return ���͒l
     * @throws Exception ������O
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
     * �t�H�[�}�b�g��Ԃ��܂��B
     * 
     * @return �t�H�[�}�b�g
     */
    public Format getFormat() {
        return getMainContent().getFormat();
    }

    /**
     * �������t����̊�ƂȂ錻�ݓ��� ��Ԃ��܂��B
     * <p>
     * ���A���^�C���Ȍ��ݓ������g���ꍇ��null���w�肵�܂��B
     * </p>
     * 
     * @return �������t����̊�ƂȂ錻�ݓ���
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
     * �ő啶������Ԃ��܂��B
     * 
     * @return �ő啶����
     */
    public int getMaxLength() {
        return getMainContent().getMaxLength();
    }

    public NavigationFilter getNavigationFilter() {
        return getMainContent().getNavigationFilter();
    }

    /**
     * �G���[���Ɍ�������e�K�w�̐���Ԃ��܂��B
     * 
     * @return �G���[���Ɍ�������e�K�w
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
     * �����͂������邩 ��Ԃ��܂��B
     * 
     * @return �����͂������邩
     */
    public boolean isAllowedBlank() {
        return getMainContent().isAllowedBlank();
    }

    /**
     * �������t�������邩 ��Ԃ��܂��B
     * 
     * @return �������t�������邩
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
     * �L���ȓ��t�����͂���Ă��邩��Ԃ��܂��B
     * 
     * @return �L���ȓ��t�����͂���Ă��邩
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
     * �����͂������邩 ��ݒ肵�܂��B
     * 
     * @param allowedBlank �����͂������邩
     */
    public void setAllowedBlank(boolean allowedBlank) {
        getMainContent().setAllowedBlank(allowedBlank);
    }

    /**
     * �������t�������邩 ��ݒ肵�܂��B
     * 
     * @param allowedFutureDate �������t�������邩
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
     * ���͒l��Date�^�Őݒ肵�܂��B
     * 
     * @param value ���͒l
     * @throws Exception ������O
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
     * �t�H�[�}�b�g��ݒ肵�܂��B
     * 
     * @param format �t�H�[�}�b�g
     */
    public void setFormat(Format format) {
        getMainContent().setFormat(format);
    }

    /**
     * �������t����̊�ƂȂ錻�ݓ��� ��ݒ肵�܂��B
     * <p>
     * ���A���^�C���Ȍ��ݓ������g���ꍇ��null���w�肵�܂��B
     * </p>
     * 
     * @param futureBaseDate �������t����̊�ƂȂ錻�ݓ���
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
     * �ő啶������ݒ肵�܂��B
     * 
     * @param maxLength �ő啶����
     */
    public void setMaxLength(int maxLength) {
        getMainContent().setMaxLength(maxLength);
    }

    public void setNavigationFilter(NavigationFilter filter) {
        getMainContent().setNavigationFilter(filter);
    }

    /**
     * �G���[���Ɍ�������e�K�w�̐���ݒ肵�܂��B
     * 
     * @param parentFindCount �G���[���Ɍ�������e�K�w
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
        getMainContent().setFormat(new ACBorderBlankDateFormat("ggge�NMM��dd��"));

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
                    //���t�m��Ńt�H�[�J�X���X�g���[���I�ɔ���������
                    processFocusEvent(new FocusEvent(QkanDateTextField.this,
                            FocusEvent.FOCUS_LOST));
                }
            }

        });
        this.setToolTipText("<html>�ȉ��̂�����̌`���ł����͉\�ł��B<br>"
                +"����18�N4��1��<br>"
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
     * ������區�� �𐶐����ĕԂ��܂��B
     * 
     * @return ������區��
     */
    protected ACDateTextField createMainContent() {
        return new ACDateTextField();
    }

    /**
     * ������區�� ��Ԃ��܂��B
     * 
     * @return ������區��
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
            // �q�̃C�x���g��u��
            e.setSource(this);
        }
        super.processFocusEvent(e);
    }

    protected void processInputMethodEvent(InputMethodEvent e) {
        if (e.getSource() == getMainContent()) {
            // �q�̃C�x���g��u��
            e.setSource(this);
        }
        super.processInputMethodEvent(e);
    }

    protected void processKeyEvent(KeyEvent e) {
        if (e.getSource() == getMainContent()) {
            // �q�̃C�x���g���ԐړI�ɔ��s
            e = new KeyEvent(this, e.getID(), e.getWhen(), e.getModifiers(), e
                    .getKeyCode(), e.getKeyChar(), e.getKeyLocation());
        }
        super.processKeyEvent(e);
    }

    protected void processMouseEvent(MouseEvent e) {
        if (e.getSource() == getMainContent()) {
            // �q�̃C�x���g���ԐړI�ɔ��s
            e.setSource(this);
        }
        super.processMouseEvent(e);
    }

    protected void processMouseMotionEvent(MouseEvent e) {
        if (e.getSource() == getMainContent()) {
            // �q�̃C�x���g���ԐړI�ɔ��s
            e.setSource(this);
        }
        super.processMouseMotionEvent(e);
    }

    protected void processMouseWheelEvent(MouseWheelEvent e) {
        if (e.getSource() == getMainContent()) {
            // �q�̃C�x���g��u��
            e.setSource(this);
        }
        super.processMouseWheelEvent(e);
    }

    public void requestFocus(){
        getMainContent().requestFocus();
    }
}
