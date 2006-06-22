package jp.or.med.orca.qkan.affair.qs.qs001;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.util.Vector;

import javax.swing.ListModel;
import javax.swing.TransferHandler;

import jp.nichicom.ac.component.dnd.ACDroppableListBox;

/**
 * ドロップ可能なリストボックスです。
 * <p>
 * Copyright (c) 2005 Nippon Computer Corpration. All Rights Reserved.
 * </p>
 * 
 * @author Tozo Tanaka
 * @version 1.0 2006/01/13
 */
public class QS001DroppableListBox extends ACDroppableListBox {

    /**
     * Constructs a <code>JList</code> with an empty model.
     */
    public QS001DroppableListBox() {
        super();
    }

    /**
     * Constructs a <code>JList</code> that displays the elements in the
     * specified, non-<code>null</code> model. All <code>JList</code>
     * constructors delegate to this one.
     * 
     * @param dataModel the data model for this list
     * @exception IllegalArgumentException if <code>dataModel</code> is
     *                <code>null</code>
     */
    public QS001DroppableListBox(ListModel dataModel) {
        super(dataModel);
    }

    /**
     * Constructs a <code>JList</code> that displays the elements in the
     * specified array. This constructor just delegates to the
     * <code>ListModel</code> constructor.
     * 
     * @param listData the array of Objects to be loaded into the data model
     */
    public QS001DroppableListBox(Object[] listData) {
        super(listData);
    }

    /**
     * Constructs a <code>JList</code> that displays the elements in the
     * specified <code>Vector</code>. This constructor just delegates to the
     * <code>ListModel</code> constructor.
     * 
     * @param listData the <code>Vector</code> to be loaded into the data
     *            model
     */
    public QS001DroppableListBox(Vector listData) {
        super(listData);
    }

    protected DataFlavor getSupportedDataFlavor(){
        return QS001ServiceDataFlavor.getInstance();
    }

    protected Transferable createTransfer(Object[] values){
        return new QS001ServiceTransfer(values);
    }

    protected TransferHandler createTransferHandler(){
        return new QS001ServiceTransferHandler();
    }
    
    protected boolean canInnerLastItemDrop(){
       return true; 
    }
}
