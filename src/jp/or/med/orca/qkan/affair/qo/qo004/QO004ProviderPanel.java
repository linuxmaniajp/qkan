package jp.or.med.orca.qkan.affair.qo.qo004;

import java.awt.LayoutManager;

import jp.nichicom.ac.container.ACGroupBox;
import jp.nichicom.ac.container.ACPanel;
import jp.nichicom.ac.lib.care.claim.print.schedule.CareServiceCodeCalcurater;
import jp.nichicom.ac.sql.ACDBManager;
import jp.nichicom.vr.util.VRMap;

/**
 * ���Ə��p�l���p�̊��p�l���N���X�ł��B
 * <p>
 * Copyright (c) 2005 Nippon Computer Corpration. All Rights Reserved.
 * </p>
 * 
 * @author Tozo Tanaka
 * @version 1.0 2009/02/25
 */
public class QO004ProviderPanel extends ACPanel {
    private ACDBManager dbm;
    
    /**
     * Creates a new <code>JPanel</code> with a double buffer and a flow
     * layout.
     */
    public QO004ProviderPanel() {
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
    public QO004ProviderPanel(boolean isDoubleBuffered) {
        super(isDoubleBuffered);
    }

    /**
     * Create a new buffered JPanel with the specified layout manager
     * 
     * @param layout the LayoutManager to use
     */
    public QO004ProviderPanel(LayoutManager layout) {
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
    public QO004ProviderPanel(LayoutManager layout, boolean isDoubleBuffered) {
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

    /**
     * ���@����̐ݒ荀�ڂ��擾���܂��B
     * @return ���@����̐ݒ荀��
     * @see �p�����override���Ď������邱�ƁB
     */
    public ACPanel getOldLowElementArea() {
        return null;
    }

    /**
     * ���@����̐ݒ荀�ڂ̕\����Ԃ�ݒ肵�܂��B
     * @throws Exception ������O
     */
    public void setOldLowElementAreaVisible(boolean visible) throws Exception {
        if (visible) {
            setState_OLD_LOW_ELEMENT_AREA_SHOW();
        } else {
            setState_OLD_LOW_ELEMENT_AREA_HIDE();
        }
    }

    /**
     * �u���@����̐ݒ荀�ڕ\���v�̏�Ԃɐݒ肵�܂��B
     * @throws Exception ������O
     */
    public void setState_OLD_LOW_ELEMENT_AREA_SHOW() throws Exception {
        ACPanel oldLows = getOldLowElementArea();
        if (oldLows != null) {
            oldLows.setVisible(true);
        }
    }

    /**
     * �u���@����̐ݒ荀�ڔ�\���v�̏�Ԃɐݒ肵�܂��B
     * @throws Exception ������O
     */
    public void setState_OLD_LOW_ELEMENT_AREA_HIDE() throws Exception {
        ACPanel oldLows = getOldLowElementArea();
        if (oldLows != null) {
            oldLows.setVisible(false);
        }
    }    
}
