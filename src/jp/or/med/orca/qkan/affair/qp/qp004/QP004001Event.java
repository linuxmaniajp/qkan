
/*
 * Project code name "ORCA"
 * ���t�Ǘ��䒠�\�t�g QKANCHO�iJMA care benefit management software�j
 * Copyright(C) 2002 JMA (Japan Medical Association)
 *
 * This program is part of "QKANCHO (JMA care benefit management software)".
 *
 * This program is distributed in the hope that it will be useful
 * for further advancement in medical care, according to JMA Open
 * Source License, but WITHOUT ANY WARRANTY.
 * Everyone is granted permission to use, copy, modify and
 * redistribute this program, but only under the conditions described
 * in the JMA Open Source License. You should have received a copy of
 * this license along with this program. If not, stop using this
 * program and contact JMA, 2-28-16 Honkomagome, Bunkyo-ku, Tokyo,
 * 113-8621, Japan.
 *****************************************************************
 * �A�v��: QKANCHO
 * �J����: �c���@����
 * �쐬��: 2006/04/07  ���{�R���s���[�^�[������� �c���@���� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �����f�[�^�쐬 (P)
 * �v���Z�X �m�F�E�C�� (004)
 * �v���O���� ���莡�Ô�ҏW��� (QP004001)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qp.qp004;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import jp.nichicom.ac.ACCommon;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRList;

/**
 * ���莡�Ô�ҏW��ʃC�x���g��`(QP004001) 
 */
public abstract class QP004001Event extends QP004001SQL {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QP004001Event(){
    addEvents();
  }
  /**
   * �C�x���g�����������`���܂��B
   */
  protected void addEvents() {
    getMedicalClear().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                medicalClearActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getMedicalInsert().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                medicalInsertActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getMedicalUpdate().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                medicalUpdateActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getMedicalDelete().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                medicalDeleteActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getAplly().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                apllyActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getClose().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                closeActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getMedicalTable().addListSelectionListener(new ListSelectionListener(){
        private boolean lockFlag = false;
        public void valueChanged(ListSelectionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                medicalTableSelectionChanged(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });

  }
  //�R���|�[�l���g�C�x���g

  /**
   * �u�N���A�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void medicalClearActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u�ǉ��v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void medicalInsertActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u���ցv�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void medicalUpdateActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u�폜�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void medicalDeleteActionPerformed(ActionEvent e) throws Exception;

  /**
   * �uOK�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void apllyActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u�L�����Z���v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void closeActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u�ꗗ�I���v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void medicalTableSelectionChanged(ListSelectionEvent e) throws Exception;

  //�ϐ���`

  private boolean applied = false;
  private VRList medicalInfos = new VRArrayList();
  private VRList basicInfos = new VRArrayList();
  private VRList totalInfos = new VRArrayList();
  private VRList editMedicalInfos = new VRArrayList();
  //getter/setter

  /**
   * applied��Ԃ��܂��B
   * @return applied
   */
  protected boolean getApplied(){
    return applied;
  }
  /**
   * applied��ݒ肵�܂��B
   * @param applied applied
   */
  protected void setApplied(boolean applied){
    this.applied = applied;
  }

  /**
   * medicalInfos��Ԃ��܂��B
   * @return medicalInfos
   */
  protected VRList getMedicalInfos(){
    return medicalInfos;
  }
  /**
   * medicalInfos��ݒ肵�܂��B
   * @param medicalInfos medicalInfos
   */
  protected void setMedicalInfos(VRList medicalInfos){
    this.medicalInfos = medicalInfos;
  }

  /**
   * basicInfos��Ԃ��܂��B
   * @return basicInfos
   */
  protected VRList getBasicInfos(){
    return basicInfos;
  }
  /**
   * basicInfos��ݒ肵�܂��B
   * @param basicInfos basicInfos
   */
  protected void setBasicInfos(VRList basicInfos){
    this.basicInfos = basicInfos;
  }

  /**
   * totalInfos��Ԃ��܂��B
   * @return totalInfos
   */
  protected VRList getTotalInfos(){
    return totalInfos;
  }
  /**
   * totalInfos��ݒ肵�܂��B
   * @param totalInfos totalInfos
   */
  protected void setTotalInfos(VRList totalInfos){
    this.totalInfos = totalInfos;
  }

  /**
   * editMedicalInfos��Ԃ��܂��B
   * @return editMedicalInfos
   */
  protected VRList getEditMedicalInfos(){
    return editMedicalInfos;
  }
  /**
   * editMedicalInfos��ݒ肵�܂��B
   * @param editMedicalInfos editMedicalInfos
   */
  protected void setEditMedicalInfos(VRList editMedicalInfos){
    this.editMedicalInfos = editMedicalInfos;
  }

  //�����֐�

  /**
   * �u��ʓW�J�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @param medicalInfos VRList
   * @param basicInfos VRList
   * @param totalInfos VRList
   * @throws Exception ������O
   * @return boolean
   */
  public abstract boolean showModal(VRList medicalInfos, VRList basicInfos, VRList totalInfos) throws Exception;

}
