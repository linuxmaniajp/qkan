
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
 * �J����: �����@�L
 * �쐬��: 2010/11/08  ���{�R���s���[�^�[������� �����@�L �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���ъm��/�������o�� (P)
 * �v���Z�X �������� (001)
 * �v���O���� ���p�҈ꗗ�i�����j (QP001)
 *
 *****************************************************************
 */
package jp.nichicom.ac.lib.care.claim.calculation;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;

import jp.nichicom.ac.ACCommon;
import jp.nichicom.ac.component.table.ACCheckBoxTableColumnPopupMenu;
import jp.nichicom.ac.component.table.event.ACCheckBoxTableColumnPopupMenuAdapter;
import jp.nichicom.ac.sql.ACPassiveKey;
import jp.nichicom.ac.util.adapter.ACTableModelAdapter;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;

/**
 * ���p�҈ꗗ�i�����j�C�x���g��`(QP001) 
 */
@SuppressWarnings("serial")
public abstract class QP001Event extends QP001SQL {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QP001Event(){
    addEvents();
  }
  /**
   * �C�x���g�����������`���܂��B
   */
  protected void addEvents() {
    getEntry().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                entryActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getFind().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                findActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getPrint().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                printActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getCommit().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                commitActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getCsvOut().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                csvOutActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getDelete().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                deleteActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getInfoTable().addMouseListener(new MouseAdapter(){
        private boolean lockFlag = false;
        public void mouseClicked(MouseEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
            	setButtonState();	// 2014.12.11 Hitaka add
                if (e.getClickCount() == 2) {
                	infoTableSelectionchangedDouble(e);
                }
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getInfoTableColumn3().addCellEditorListener(new CellEditorListener(){
        private boolean lockFlag = false;
        public void editingStopped(ChangeEvent e) {
          cellEditing(e);
        }
        public void editingCanceled(ChangeEvent e) {
          cellEditing(e);
        }
        public void cellEditing(ChangeEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
            	infoTableSelectionChanged(null);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getInfoTableColumn4().addCellEditorListener(new CellEditorListener(){
        private boolean lockFlag = false;
        public void editingStopped(ChangeEvent e) {
          cellEditing(e);
        }
        public void editingCanceled(ChangeEvent e) {
          cellEditing(e);
        }
        public void cellEditing(ChangeEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
            	infoTableSelectionChanged(null);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });

    getInsurerNoText().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                insurerNoTextFocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getInsurerNoConbo().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                insurerNoConboActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    if(getInfoTableColumn3().getHeaderPopupMenu() instanceof ACCheckBoxTableColumnPopupMenu){      ((ACCheckBoxTableColumnPopupMenu)getInfoTableColumn3().getHeaderPopupMenu()).addPopupMenuListener(new ACCheckBoxTableColumnPopupMenuAdapter(){
          private boolean lockFlag = false;
          public void allCheckMenuActionPerformed(ActionEvent e) {
              if (lockFlag) {
                  return;
              }
              lockFlag = true;
              try {
                  infoTableColumn3CheckMenuActionPerformed(e);
              }catch(Throwable ex){
                  ACCommon.getInstance().showExceptionMessage(ex);
              }finally{
                  lockFlag = false;
              }
          }
       });
      ((ACCheckBoxTableColumnPopupMenu)getInfoTableColumn3().getHeaderPopupMenu()).addPopupMenuListener(new ACCheckBoxTableColumnPopupMenuAdapter(){
          private boolean lockFlag = false;
          public void allUncheckMenuActionPerformed(ActionEvent e) {
              if (lockFlag) {
                  return;
              }
              lockFlag = true;
              try {
                  infoTableColumn3CheckMenuActionPerformed(e);
              }catch(Throwable ex){
                  ACCommon.getInstance().showExceptionMessage(ex);
              }finally{
                  lockFlag = false;
              }
          }
       });
      ((ACCheckBoxTableColumnPopupMenu)getInfoTableColumn3().getHeaderPopupMenu()).addPopupMenuListener(new ACCheckBoxTableColumnPopupMenuAdapter(){
          private boolean lockFlag = false;
          public void reverseCheckMenuActionPerformed(ActionEvent e) {
              if (lockFlag) {
                  return;
              }
              lockFlag = true;
              try {
                  infoTableColumn3CheckMenuActionPerformed(e);
              }catch(Throwable ex){
                  ACCommon.getInstance().showExceptionMessage(ex);
              }finally{
                  lockFlag = false;
              }
          }
       });
    }    if(getInfoTableColumn4().getHeaderPopupMenu() instanceof ACCheckBoxTableColumnPopupMenu){      ((ACCheckBoxTableColumnPopupMenu)getInfoTableColumn4().getHeaderPopupMenu()).addPopupMenuListener(new ACCheckBoxTableColumnPopupMenuAdapter(){
          private boolean lockFlag = false;
          public void allCheckMenuActionPerformed(ActionEvent e) {
              if (lockFlag) {
                  return;
              }
              lockFlag = true;
              try {
                  infoTableColumn4CheckMenuActionPerformed(e);
              }catch(Throwable ex){
                  ACCommon.getInstance().showExceptionMessage(ex);
              }finally{
                  lockFlag = false;
              }
          }
       });
      ((ACCheckBoxTableColumnPopupMenu)getInfoTableColumn4().getHeaderPopupMenu()).addPopupMenuListener(new ACCheckBoxTableColumnPopupMenuAdapter(){
          private boolean lockFlag = false;
          public void allUncheckMenuActionPerformed(ActionEvent e) {
              if (lockFlag) {
                  return;
              }
              lockFlag = true;
              try {
                  infoTableColumn4CheckMenuActionPerformed(e);
              }catch(Throwable ex){
                  ACCommon.getInstance().showExceptionMessage(ex);
              }finally{
                  lockFlag = false;
              }
          }
       });
      ((ACCheckBoxTableColumnPopupMenu)getInfoTableColumn4().getHeaderPopupMenu()).addPopupMenuListener(new ACCheckBoxTableColumnPopupMenuAdapter(){
          private boolean lockFlag = false;
          public void reverseCheckMenuActionPerformed(ActionEvent e) {
              if (lockFlag) {
                  return;
              }
              lockFlag = true;
              try {
                  infoTableColumn4CheckMenuActionPerformed(e);
              }catch(Throwable ex){
                  ACCommon.getInstance().showExceptionMessage(ex);
              }finally{
                  lockFlag = false;
              }
          }
       });
    }
    getPrintList().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                printListActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    
    getClaimDateUpdateChangePermit().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
            	claimDateChangePermitPerformed(e);
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
   * �u���[�i�l���j�E���Ə��I���ɑJ�ځv�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void entryActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u�����v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void findActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u����v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void printActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u���яW�v�����v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void commitActionPerformed(ActionEvent e) throws Exception;

  /**
   * �uCSV�t�@�C���o�́v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void csvOutActionPerformed(ActionEvent e) throws Exception;
  
  protected abstract void deleteActionPerformed(ActionEvent e) throws Exception;
  protected abstract void insurerNoConboActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u�ی��҃e�L�X�g�{�b�N�X���͎��̏����v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void insurerNoTextFocusLost(FocusEvent e) throws Exception;

  /**
   * �u�I�𑀍상�j���[�N���b�N�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void infoTableColumn3CheckMenuActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u�I�𑀍상�j���[�N���b�N�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void infoTableColumn4CheckMenuActionPerformed(ActionEvent e) throws Exception;
  
  
  protected abstract void infoTableSelectionChanged(MouseEvent e) throws Exception;
  
  protected abstract void infoTableSelectionchangedDouble(MouseEvent e) throws Exception;
  protected abstract void printListActionPerformed(ActionEvent e) throws Exception;
  protected abstract void claimDateChangePermitPerformed(ActionEvent e) throws Exception;
  
  /**
   * �ꗗ�̍s�I���i�}�E�X�N���b�N�j���̋Ɩ��{�^���\���ݒ菈���v�C�x���g�ł��B
   * 2014.12.11 Shinobu Hitaka add
   * @param �Ȃ�
   * @throws Exception ������O
   */
  protected abstract void setButtonState() throws Exception;
  
  //�ϐ���`

  private ACPassiveKey PASSIVE_CHECK_KEY;
  private String affair;
  private VRList patientData = new VRArrayList();
  private VRList insureData = new VRArrayList();
  private ACTableModelAdapter patientTableModel;
  private VRMap masterServiceCache = new VRHashMap();
  private boolean isServiceByReceipt = false;
  //getter/setter

  /**
   * PASSIVE_CHECK_KEY��Ԃ��܂��B
   * @return PASSIVE_CHECK_KEY
   */
  protected ACPassiveKey getPASSIVE_CHECK_KEY(){
    return PASSIVE_CHECK_KEY;
  }
  /**
   * PASSIVE_CHECK_KEY��ݒ肵�܂��B
   * @param PASSIVE_CHECK_KEY PASSIVE_CHECK_KEY
   */
  protected void setPASSIVE_CHECK_KEY(ACPassiveKey PASSIVE_CHECK_KEY){
    this.PASSIVE_CHECK_KEY = PASSIVE_CHECK_KEY;
  }

  /**
   * affair��Ԃ��܂��B
   * @return affair
   */
  protected String getAffair(){
    return affair;
  }
  /**
   * affair��ݒ肵�܂��B
   * @param affair affair
   */
  protected void setAffair(String affair){
    this.affair = affair;
  }

  /**
   * patientData��Ԃ��܂��B
   * @return patientData
   */
  protected VRList getPatientData(){
    return patientData;
  }
  /**
   * patientData��ݒ肵�܂��B
   * @param patientData patientData
   */
  protected void setPatientData(VRList patientData){
    this.patientData = patientData;
  }

  /**
   * insureData��Ԃ��܂��B
   * @return insureData
   */
  protected VRList getInsureData(){
    return insureData;
  }
  /**
   * insureData��ݒ肵�܂��B
   * @param insureData insureData
   */
  protected void setInsureData(VRList insureData){
    this.insureData = insureData;
  }

  /**
   * patientTableModel��Ԃ��܂��B
   * @return patientTableModel
   */
  protected ACTableModelAdapter getPatientTableModel(){
    return patientTableModel;
  }
  /**
   * patientTableModel��ݒ肵�܂��B
   * @param patientTableModel patientTableModel
   */
  protected void setPatientTableModel(ACTableModelAdapter patientTableModel){
    this.patientTableModel = patientTableModel;
  }
  /**
   * masterServiceCache��Ԃ��܂��B
   * @return
   */
  protected VRMap getMasterServiceCache() {
	  return masterServiceCache;
  }
  /**
   * masterServiceCache��ݒ肵�܂��B
   * @param masterServiceCache masterServiceCache
   */
  protected void setMasterServiceCache(VRMap masterServiceCache) {
	  this.masterServiceCache = masterServiceCache;
  }
  
  /**
   * �T�[�r�X��ނ��Ƃɗ̎����𔭍s���邩�B
   * @return
   */
  protected boolean isServiceByReceipt() {
	  return isServiceByReceipt;
  }
  /**
   * �T�[�r�X��ނ��Ƃɗ̎����𔭍s���邩�̃t���O��ݒ肵�܂��B
   * @param isServiceByReceipt isServiceByReceipt
   */
  protected void setServiceByReceipt(boolean isServiceByReceipt) {
	  this.isServiceByReceipt = isServiceByReceipt;
  }

  //�����֐�

  /**
   * �u���������̎擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   *
   */
  public abstract void doFind() throws Exception;

  /**
   * �u���уf�[�^�̎擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   *
   */
  public abstract void doTotal() throws Exception;

  /**
   * �u���ƎҖ��̎��яW�v�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @param patient VRList
   * @param serviceDetailList VRList
   * @param providerData VRList
   * @throws Exception ������O
   *
   */
  public abstract int doTotalDetail(VRMap patient, VRList servicePlanList,VRList serviceDetailList,QP001Manager manager, QP001TotalErrors errors) throws Exception;

  /**
   * �u���p�ґI���̊m�F�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @param fieldName String
   * @param processName String
   * @throws Exception ������O
   * @return boolean
   */
  public abstract boolean checkSelect(String fieldName, String processName) throws Exception;


  /**
   * �u�����O�`�F�b�N�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   * @return boolean
   */
  public abstract boolean checkFind() throws Exception;

}
