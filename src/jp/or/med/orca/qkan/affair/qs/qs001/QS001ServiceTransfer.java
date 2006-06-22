package jp.or.med.orca.qkan.affair.qs.qs001;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;

import jp.nichicom.ac.component.dnd.ACTransfer;

/**
 * QS001ServiceDataFlavor用のフレーバ処理クラスです。
 * <p>
 * Copyright (c) 2005 Nippon Computer Corpration. All Rights Reserved.
 * </p>
 * 
 * @author Tozo Tanaka
 * @version 1.0 2006/01/11
 */
public class QS001ServiceTransfer extends ACTransfer {
    /**
     * コンストラクタです。
     */
    public QS001ServiceTransfer() {
        super();
    }

    /**
     * コンストラクタです。
     * 
     * @param value 搬送データ
     */
    public QS001ServiceTransfer(Object value) {
        super(value);
    }

    /**
     * サポートしているフレーバクラスごとに同名メソッドをoverloadして値を返します。
     * <p>
     * 該当するoverloadがない場合、UnsupportedFlavorExceptionを発行します。
     * </p>
     * 
     * @param flavor フレーバ
     * @return データ
     * @throws UnsupportedFlavorException サポート対象外例外
     */
    protected Object getSupportedTransferData(DataFlavor flavor)
            throws UnsupportedFlavorException {
        if (flavor instanceof QS001ServiceDataFlavor) {
            return getValue();
        }
        throw new UnsupportedFlavorException(flavor);
    }

    /**
     * サポート対象のフレーバクラス配列を返します。
     * 
     * @return フレーバクラス配列
     * @throws ClassNotFoundException クラス生成例外
     */
    protected DataFlavor[] createSupportFlavors() throws ClassNotFoundException {
        return new DataFlavor[] { QS001ServiceDataFlavor.getInstance() };
    }

}
