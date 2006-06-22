package jp.or.med.orca.qkan.affair.qs.qs001;

import java.awt.datatransfer.Transferable;

import jp.nichicom.ac.component.dnd.ACTransferHandler;

/**
 * QS001ServiceTransfer用のデータ搬送クラスです。
 * <p>
 * Copyright (c) 2005 Nippon Computer Corpration. All Rights Reserved.
 * </p>
 * @author Tozo Tanaka
 * @version 1.0 2006/01/11
 */
public class QS001ServiceTransferHandler extends ACTransferHandler {

    /**
     * Convenience constructor for subclasses.
     */
    public QS001ServiceTransferHandler() {
        super();
    }

    /**
     * Constructs a transfer handler that can transfer a Java Bean property from
     * one component to another via the clipboard or a drag and drop operation.
     * 
     * @param property the name of the property to transfer; this can be
     *            <code>null</code> if there is no property associated with
     *            the transfer handler (a subclass that performs some other kind
     *            of transfer, for example)
     */
    public QS001ServiceTransferHandler(String property) {
        super(property);
    }

    /**
     * データ搬送体を生成して返します。
     * @param values 搬送データ
     * @return 搬送体
     */
    protected Transferable createTransferable(Object[] values){
        return new QS001ServiceTransfer(values);
    }
}
