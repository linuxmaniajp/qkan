package jp.or.med.orca.qkan.affair.qs.qs001;

import java.awt.datatransfer.DataFlavor;

import javax.swing.Action;
import javax.swing.Icon;

import jp.nichicom.ac.component.dnd.ACDraggableButton;

/**
 * サービスドラッグ用ボタンです。
 * <p>
 * Copyright (c) 2005 Nippon Computer Corpration. All Rights Reserved.
 * </p>
 * @author Tozo Tanaka
 * @version 1.0 2006/01/17
 */
public class QS001DraggableButton extends ACDraggableButton {

    /**
     * Creates a button with no set text or icon.
     */
    public QS001DraggableButton() {
        super();
    }

    /**
     * Creates a button where properties are taken from the <code>Action</code>
     * supplied.
     * 
     * @param a the <code>Action</code> used to specify the new button
     * @since 1.3
     */
    public QS001DraggableButton(Action a) {
        super(a);
    }

    /**
     * Creates a button with an icon.
     * 
     * @param icon the Icon image to display on the button
     */
    public QS001DraggableButton(Icon icon) {
        super(icon);
    }

    /**
     * Creates a button with text.
     * 
     * @param text the text of the button
     */
    public QS001DraggableButton(String text) {
        super(text);
    }

    /**
     * Creates a button with initial text and an icon.
     * 
     * @param text the text of the button
     * @param icon the Icon image to display on the button
     */
    public QS001DraggableButton(String text, Icon icon) {
        super(text, icon);
    }
    
    protected DataFlavor[] createAllowdDataFlavors() {
        return new DataFlavor[] { QS001ServiceDataFlavor.getInstance() };
    }

}
