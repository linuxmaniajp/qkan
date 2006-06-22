package jp.or.med.orca.qkan.affair.qs.qs001;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;

import jp.nichicom.ac.component.dnd.ACTransfer;

/**
 * QS001ServiceDataFlavor�p�̃t���[�o�����N���X�ł��B
 * <p>
 * Copyright (c) 2005 Nippon Computer Corpration. All Rights Reserved.
 * </p>
 * 
 * @author Tozo Tanaka
 * @version 1.0 2006/01/11
 */
public class QS001ServiceTransfer extends ACTransfer {
    /**
     * �R���X�g���N�^�ł��B
     */
    public QS001ServiceTransfer() {
        super();
    }

    /**
     * �R���X�g���N�^�ł��B
     * 
     * @param value �����f�[�^
     */
    public QS001ServiceTransfer(Object value) {
        super(value);
    }

    /**
     * �T�|�[�g���Ă���t���[�o�N���X���Ƃɓ������\�b�h��overload���Ēl��Ԃ��܂��B
     * <p>
     * �Y������overload���Ȃ��ꍇ�AUnsupportedFlavorException�𔭍s���܂��B
     * </p>
     * 
     * @param flavor �t���[�o
     * @return �f�[�^
     * @throws UnsupportedFlavorException �T�|�[�g�ΏۊO��O
     */
    protected Object getSupportedTransferData(DataFlavor flavor)
            throws UnsupportedFlavorException {
        if (flavor instanceof QS001ServiceDataFlavor) {
            return getValue();
        }
        throw new UnsupportedFlavorException(flavor);
    }

    /**
     * �T�|�[�g�Ώۂ̃t���[�o�N���X�z���Ԃ��܂��B
     * 
     * @return �t���[�o�N���X�z��
     * @throws ClassNotFoundException �N���X������O
     */
    protected DataFlavor[] createSupportFlavors() throws ClassNotFoundException {
        return new DataFlavor[] { QS001ServiceDataFlavor.getInstance() };
    }

}
