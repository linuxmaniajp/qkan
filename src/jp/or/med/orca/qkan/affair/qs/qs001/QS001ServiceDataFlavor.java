package jp.or.med.orca.qkan.affair.qs.qs001;

import java.awt.datatransfer.DataFlavor;

/**
 * �T�[�r�X�N���X�p�̃f�[�^�t���[�o�ł��B
 * <p>
 * Copyright (c) 2005 Nippon Computer Corpration. All Rights Reserved.
 * </p>
 * 
 * @author Tozo Tanaka
 * @version 1.0 2006/01/11
 */
public class QS001ServiceDataFlavor extends DataFlavor {
    public static final String FLAVOR_OF_SERVICE = "application/qkan-service";
    private static QS001ServiceDataFlavor singleton;

    /**
     * �R���X�g���N�^�ł��B
     * 
     * @throws ClassNotFoundException ������O
     */
    protected QS001ServiceDataFlavor() throws ClassNotFoundException {
        super(Object.class, FLAVOR_OF_SERVICE);
    }

    /**
     * �C���X�^���X��Ԃ��܂��B
     * @return �C���X�^���X
     */
    public static QS001ServiceDataFlavor getInstance() {
        if (singleton == null) {
            try {
                singleton = new QS001ServiceDataFlavor();
            } catch (Exception ex) {
                return null;
            }
        }
        return singleton;
    }
}
