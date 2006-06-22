package jp.or.med.orca.qkan.affair.qs.qs001;

import java.awt.LayoutManager;

import jp.nichicom.ac.container.ACPanel;
import jp.nichicom.ac.sql.ACDBManager;

/**
 * �T�[�r�X�p�l���p�̊��p�l���N���X�ł��B
 * <p>
 * Copyright (c) 2005 Nippon Computer Corpration. All Rights Reserved.
 * </p>
 * 
 * @author Tozo Tanaka
 * @version 1.0 2006/03/31
 */
public class QS001ServicePanel extends ACPanel {
    private ACDBManager dbm;
    private boolean oldFacilityUser;
    private boolean planMode;

    /**
     * �\�胂�[�h�ł��邩 ��Ԃ��܂��B
     * @return �\�胂�[�h�ł��邩
     */
    public boolean isPlanMode() {
        return planMode;
    }

    /**
     * �\�胂�[�h�ł��邩 ��ݒ肵�܂��B
     * @param planMode �\�胂�[�h�ł��邩
     */
    public void setPlanMode(boolean planMode) {
        this.planMode = planMode;
    }

    /**
     * ���[�u�����҂ł��邩 ��Ԃ��܂��B
     * @return ���[�u�����҂ł��邩
     */
    public boolean isOldFacilityUser() {
        return oldFacilityUser;
    }

    /**
     * ���[�u�����҂ł��邩 ��ݒ肵�܂��B
     * @param oldFacilityUser ���[�u�����҂ł��邩
     */
    public void setOldFacilityUser(boolean oldFacilityUser) {
        this.oldFacilityUser = oldFacilityUser;
    }

    /**
     * Creates a new <code>JPanel</code> with a double buffer and a flow
     * layout.
     */
    public QS001ServicePanel() {
        super();
    }

    /**
     * Creates a new <code>JPanel</code> with <code>FlowLayout</code> and
     * the specified buffering strategy. If <code>isDoubleBuffered</code> is
     * true, the <code>JPanel</code> will use a double buffer.
     * 
     * @param isDoubleBuffered a boolean, true for double-buffering, which uses
     *            additional memory space to achieve fast, flicker-free updates
     */
    public QS001ServicePanel(boolean isDoubleBuffered) {
        super(isDoubleBuffered);
    }

    /**
     * Create a new buffered JPanel with the specified layout manager
     * 
     * @param layout the LayoutManager to use
     */
    public QS001ServicePanel(LayoutManager layout) {
        super(layout);
    }

    /**
     * Creates a new JPanel with the specified layout manager and buffering
     * strategy.
     * 
     * @param layout the LayoutManager to use
     * @param isDoubleBuffered a boolean, true for double-buffering, which uses
     *            additional memory space to achieve fast, flicker-free updates
     */
    public QS001ServicePanel(LayoutManager layout, boolean isDoubleBuffered) {
        super(layout, isDoubleBuffered);
    }

    /**
     * DB�}�l�[�W����ݒ肵�܂��B
     * 
     * @param dbm DB�}�l�[�W��
     */
    public void setDBManager(ACDBManager dbm) {
        this.dbm = dbm;
    }

    /**
     * DB�}�l�[�W����Ԃ��܂��B
     * 
     * @return DB�}�l�[�W��
     */
    public ACDBManager getDBManager() {
        return dbm;
    }
    /**
     * �l���o�C���h�����ۂ̏����ł��B
     * @exception Exception ������O
     */
    public void binded() throws Exception{
        
    }
}
