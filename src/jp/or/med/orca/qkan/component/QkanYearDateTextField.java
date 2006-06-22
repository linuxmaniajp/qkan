package jp.or.med.orca.qkan.component;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.text.Format;
import java.util.Calendar;
import java.util.Date;

import javax.swing.Action;
import javax.swing.BoundedRangeModel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.event.CaretListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.plaf.UIResource;
import javax.swing.plaf.basic.BasicArrowButton;
import javax.swing.text.BadLocationException;
import javax.swing.text.Caret;
import javax.swing.text.Document;
import javax.swing.text.Highlighter;
import javax.swing.text.Keymap;
import javax.swing.text.NavigationFilter;

import jp.nichicom.ac.component.ACTextField;
import jp.nichicom.ac.component.event.ACFollowContainerFormatEventListener;
import jp.nichicom.ac.container.ACPanel;
import jp.nichicom.vr.component.VRTextFieldar;
import jp.nichicom.vr.component.event.VRFormatEvent;
import jp.nichicom.vr.component.event.VRFormatEventListener;
import jp.nichicom.vr.layout.VRLayout;
import jp.nichicom.vr.text.VRDateFormat;
import jp.nichicom.vr.text.parsers.VRDateParser;

/**
 * 年月操作用の擬似スピナです。
 * <p>
 * Copyright (c) 2005 Nippon Computer Corpration. All Rights Reserved.
 * </p>
 * 
 * @author Tozo Tanaka
 * @version 1.0 2006/03/01
 */
public class QkanYearDateTextField extends ACPanel implements VRTextFieldar {
    private QkanBasicArrowButton downSpin = new QkanBasicArrowButton(
            BasicArrowButton.SOUTH);
    private ACFollowContainerFormatEventListener followContainerListener = new ACFollowContainerFormatEventListener(
            true);
    private Calendar maximumDate;
    private Calendar minimumDate;
    private ACPanel spins = new ACPanel();
    private ACTextField text;

    private boolean updating = false;
    private QkanBasicArrowButton upSpin = new QkanBasicArrowButton(
            BasicArrowButton.NORTH);

    /**
     * コンストラクタです。
     */
    public QkanYearDateTextField() {
        super();
        Calendar cal = Calendar.getInstance();
        // デフォルトの最小年月日は1900年
        cal.set(1900, 0, 1);
        minimumDate = (Calendar) cal.clone();
        // デフォルトの最大年月日は9999年
        cal.set(9999, 11, 31);
        maximumDate = (Calendar) cal.clone();

        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        setFollowChildEnabled(true);
    }

    public void addCaretListener(CaretListener listener) {
        getMainContent().addCaretListener(listener);
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
        return getMainContent().getCaretListeners();
    }

    public int getCaretPosition() {
        return getMainContent().getCaretPosition();
    }

    public int getColumns() {
        return getMainContent().getColumns();
    }

    /**
     * 入力された日付を取得します。
     * <p>
     * 常に1日付けになります。
     * </p>
     * 
     * @return 入力された日付
     */
    public Date getDate() {
        Object obj = getMainContent().getModel();
        Calendar cal;
        if (obj instanceof Date) {
            cal = Calendar.getInstance();
            cal.setTime((Date) obj);
            cal.set(Calendar.DAY_OF_MONTH, 1);
        } else if (obj instanceof Calendar) {
            cal = (Calendar) obj;
            cal.set(Calendar.DAY_OF_MONTH, 1);
        } else {
            return null;
        }
        return cal.getTime();
    }

    public Color getDisabledTextColor() {
        return getMainContent().getDisabledTextColor();
    }

    public Document getDocument() {
        return getMainContent().getDocument();

    }

    public boolean getDragEnabled() {
        return getMainContent().getDragEnabled();
    }

    public char getFocusAccelerator() {
        return getMainContent().getFocusAccelerator();
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
     * 最大年月日 を返します。
     * 
     * @return 最大年月日
     */
    public Calendar getMaximumDate() {
        return maximumDate;
    }

    /**
     * 最小年月日 を返します。
     * 
     * @return 最小年月日
     */
    public Calendar getMinimumDate() {
        return minimumDate;
    }

    public NavigationFilter getNavigationFilter() {
        return getMainContent().getNavigationFilter();
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

    public String getText() {
        return getMainContent().getText();

    }

    public String getText(int offs, int len) throws BadLocationException {
        return getMainContent().getText(offs, len);
    }

    /**
     * 未入力を許可するか を返します。
     * 
     * @return 未入力を許可するか
     */
    public boolean isAllowedBlank() {
        return followContainerListener.isAllowedBlank();
    }

    /**
     * 直接入力可能であるかを返します。
     * 
     * @return 直接入力可能であるか
     */
    public boolean isEditable() {
        return getMainContent().isEditable() && upSpin.isEnabled() && downSpin.isEnabled();
    }

    /**
     * 入力内容が日付として適正であるかを返します。
     * 
     * @return 入力内容が日付として適正であるか
     */
    public boolean isValidDate() {
        return followContainerListener.isValid();
    }

    public Rectangle modelToView(int pos) throws BadLocationException {
        return getMainContent().modelToView(pos);
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
        followContainerListener.setAllowedBlank(allowedBlank);
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

    public void setColumns(int columns) {
        getMainContent().setColumns(columns);
    }

    /**
     * 表示する年月を取得します。
     * <p>
     * 常に1日付けになります。
     * </p>
     * 
     * @param date 表示する年月
     * @throws Exception 処理例外
     */
    public void setDate(Date date) throws Exception {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        getMainContent().setText(VRDateParser.format(cal, "ggge年M月"));
    }

    public void setDisabledTextColor(Color c) {
        getMainContent().setDisabledTextColor(c);
    }

    public void setDocument(Document doc) {
        getMainContent().setDocument(doc);
    }

    public void setDragEnabled(boolean b) {
        getMainContent().setDragEnabled(b);
    }

    /**
     * 直接入力可能であるかを設定します。
     * 
     * @param editable 直接入力可能であるか
     */
    public void setEditable(boolean editable) {
        getMainContent().setEditable(editable);
        upSpin.setEnabled(editable);
        downSpin.setEnabled(editable);
    }

    public void setFocusAccelerator(char aKey) {
        getMainContent().setFocusAccelerator(aKey);
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
     * 最大年月日 を設定します。
     * 
     * @param maximumDate 最大年月日
     */
    public void setMaximumDate(Calendar maximumDate) {
        this.maximumDate = maximumDate;
    }

    /**
     * 最大年月日 を設定します。
     * 
     * @param maximumDate 最大年月日
     */
    public void setMaximumDate(Date maximumDate) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(maximumDate);
        setMaximumDate(cal);
    }

    /**
     * 最小年月日 を設定します。
     * 
     * @param minimumDate 最小年月日
     */
    public void setMinimumDate(Calendar minimumDate) {
        this.minimumDate = minimumDate;
    }

    /**
     * 最小年月日 を設定します。
     * 
     * @param minimumDate 最小年月日
     */
    public void setMinimumDate(Date minimumDate) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(minimumDate);
        setMinimumDate(cal);
    }

    public void setNavigationFilter(NavigationFilter filter) {
        getMainContent().setNavigationFilter(filter);
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

    public void setText(String t) {
        getMainContent().setText(t);

    }

    public int viewToModel(Point pt) {
        return getMainContent().viewToModel(pt);
    }

    public void write(Writer out) throws IOException {
        getMainContent().write(out);
    }

    private void jbInit() throws Exception {
        this.add(getMainContent(), VRLayout.CLIENT);
        this.add(spins, VRLayout.EAST);
        spins.add(upSpin, VRLayout.NORTH);
        spins.add(downSpin, VRLayout.SOUTH);

        this.setVgap(0);
        this.setHgap(0);
        spins.setVgap(0);
        spins.setHgap(0);
        downSpin.setFocusable(false);
        upSpin.setFocusable(false);

        Border buttonBorder = UIManager.getBorder("Spinner.arrowButtonBorder");
        if (buttonBorder instanceof UIResource) {
            upSpin.setBorder(new CompoundBorder(buttonBorder, null));
            downSpin.setBorder(new CompoundBorder(buttonBorder, null));
        } else {
            upSpin.setBorder(buttonBorder);
            downSpin.setBorder(buttonBorder);
        }


        ArrowButtonHandler up = new ArrowButtonHandler(1);
        upSpin.addMouseListener(up);
        upSpin.addActionListener(up);
        ArrowButtonHandler down = new ArrowButtonHandler(-1);
        downSpin.addMouseListener(down);
        downSpin.addActionListener(down);

        //スピンボタンサイズ
        int textMargin=0;
        Insets ins =  getMainContent().getInsets();
        if(ins!=null){
            textMargin+=ins.top+ins.bottom;
        }
        ins=getMainContent().getMargin();
        if(ins!=null){
            textMargin+=ins.top+ins.bottom;
        }        
        int textHeight=16;
        FontMetrics fm=getMainContent().getFontMetrics(getMainContent().getFont());
        if(fm!=null){
            textHeight = fm.getHeight();
        }
        Dimension dim = new Dimension(16, (textHeight+ textMargin) / 2);
        upSpin.setPreferredSize(dim);
        downSpin.setPreferredSize(dim);
    }

    /**
     * 表示月数を加算します。
     * 
     * @param add 加算値
     */
    protected void addValue(int add) {

        Object obj = getMainContent().getModel();
        if (obj instanceof Date) {
            int selSta = getMainContent().getSelectionStart();
            int selEnd = getMainContent().getSelectionEnd();
            Calendar cal = Calendar.getInstance();
            cal.setTime((Date) obj);
            cal.add(Calendar.MONTH, add);

            try {
                String dest = VRDateParser.format(cal, "ggge年M月");
                if (compareYMD(cal, getMaximumDate()) > 0) {
                    // 最大年月日を上回る場合
                    if (!dest.equals(getMainContent().getText())) {
                        // 異なる場合は最大にあわせる
                        dest = VRDateParser.format(getMaximumDate(), "ggge年M月");
                    } else {
                        return;
                    }
                } else if (compareYMD(cal, getMinimumDate()) < 0) {
                    // 最小年月日を下回る場合
                    if (!dest.equals(getMainContent().getText())) {
                        // 異なる場合は最小にあわせる
                        dest = VRDateParser.format(getMinimumDate(), "ggge年M月");
                    } else {
                        return;
                    }
                }

                getMainContent().setText(dest);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            getMainContent().setSelectionStart(selSta);
            getMainContent().setSelectionEnd(selEnd);
        }
    }

    /**
     * 日付を年月日のみで比較します。
     * 
     * @param x 比較元1
     * @param y 比較元2
     * @return -1(比較元1の方が前)、0(比較元1と比較元2は同一)、1(比較元1の方が後)
     */
    protected int compareYMD(Calendar x, Calendar y) {
        int xYMD = x.get(Calendar.YEAR) * 10000 + x.get(Calendar.MONTH) * 100
                + x.get(Calendar.DAY_OF_MONTH);
        int yYMD = y.get(Calendar.YEAR) * 10000 + y.get(Calendar.MONTH) * 100
                + y.get(Calendar.DAY_OF_MONTH);
        if (xYMD < yYMD) {
            return -1;
        }
        if (xYMD > yYMD) {
            return 1;
        }
        return 0;
    }

    protected class ArrowButtonHandler extends MouseAdapter implements
            ActionListener {
        private int addSize;
        private final javax.swing.Timer autoRepeatTimer;

        public ArrowButtonHandler(int addSize) {
            autoRepeatTimer = new javax.swing.Timer(60, this);
            autoRepeatTimer.setInitialDelay(300);
            this.addSize = addSize;
        }

        public void actionPerformed(ActionEvent e) {
            addValue(addSize);
        }

        public void mousePressed(MouseEvent e) {
            if (SwingUtilities.isLeftMouseButton(e)
                    && e.getComponent().isEnabled()) {
                autoRepeatTimer.start();
            }
        }

        public void mouseReleased(MouseEvent e) {
            autoRepeatTimer.stop();
        }
    }

    protected class QkanBasicArrowButton extends BasicArrowButton {
        private Dimension preferedSize;

        public QkanBasicArrowButton(int direction) {
            super(direction);
        }

        public Dimension getPreferredSize() {
            if (preferedSize != null) {
                return preferedSize;
            }
            return super.getPreferredSize();
        }

        public void setPreferredSize(Dimension preferedSize) {
            this.preferedSize = preferedSize;
        }

    }

    public void addFormatEventListener(VRFormatEventListener listener) {
        getMainContent().addFormatEventListener(listener);
    }

    public void removeFormatEventListener(VRFormatEventListener listener) {
        getMainContent().removeFormatEventListener(listener);
    }

    public Format getFormat() {
        return getMainContent().getFormat();
    }

    public void setFormat(Format format) {
        getMainContent().setFormat(format);
    }
    /**
     * 内包した主項目 を返します。
     * 
     * @return 内包した主項目
     */
    protected ACTextField getMainContent() {
        if (text == null) {
            text = createMainContent();

            text.addFormatEventListener(followContainerListener);
            text.setColumns(8);
            text.setMaxLength(8);

            text.setFormat(new VRDateFormat("ggge年M月"));

            text.addKeyListener(new KeyAdapter() {
                public void keyPressed(KeyEvent e) {
                    switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP:
                        addValue(1);
                        break;
                    case KeyEvent.VK_DOWN:
                        addValue(-1);
                        break;
                    }
                }
            });

            text.getDocument().addDocumentListener(new DocumentListener() {
                private String old = "";

                public void changedUpdate(DocumentEvent e) {
                    update();
                }

                public void insertUpdate(DocumentEvent e) {
                    update();
                }

                public void removeUpdate(DocumentEvent e) {
                    update();
                }

                private void update() {
                    if (updating) {
                        return;
                    }
                    updating = true;

                    String txt = text.getText();
                    if (VRDateParser.isValid(txt)) {
                        if (!old.equals(txt)) {
                            try {
                                int selSta = text.getSelectionStart();
                                int selEnd = text.getSelectionEnd();
                                old = txt;
                                text.setText(text.getText());
                                text.setSelectionStart(selSta);
                                text.setSelectionEnd(selEnd);

                            } catch (Exception e1) {

                            }

                        }
                    }
                    updating = false;
                }

            });
            text.addFormatEventListener(new VRFormatEventListener() {
                private Object old;

                public void formatInvalid(VRFormatEvent e) {
                }

                public void formatValid(VRFormatEvent e) {
                    // if(!followContainerListener.isValid()){
                    // formatInvalid(e);
                    // return;
                    // }

                    Object obj = text.getModel();
                    Calendar cal = null;
                    if (obj instanceof Date) {
                        cal = Calendar.getInstance();
                        cal.setTime((Date) obj);
                    } else if (obj instanceof Calendar) {
                        cal = (Calendar) obj;
                    } else {
                        // 非対応の形式
                        return;
                    }

                    if ((compareYMD(cal, getMaximumDate()) > 0)
                            || (compareYMD(cal, getMinimumDate()) < 0)) {
                        // 最大年月日を上回る場合か最小年月日を下回る場合
                        followContainerListener.changeInvalidContainer();
                        return;
                    }

                }
            }); 
            // 今月1日とする
            Calendar cal = Calendar.getInstance();
            cal.set(Calendar.DAY_OF_MONTH, 1);
            try{
                text.setText(VRDateParser.format(cal.getTime(), "ggge年M月"));
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
        return text;
    }
    public void requestFocus(){
        getMainContent().requestFocus();
    }

    /**
     * 内包した主項目 を生成して返します。
     * 
     * @return 内包した主項目
     */
    protected ACTextField createMainContent() {
        return new ACTextField();
    }

}
