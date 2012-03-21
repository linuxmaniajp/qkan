
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
 * �J����: �� ����
 * �쐬��: 2008/06/02  ���{�R���s���[�^�[������� �� ���� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���p�ҊǗ� (U)
 * �v���Z�X ���p�҈ꗗ (001)
 * �v���O���� ���p�҈ꗗ (QU001)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qu.qu001;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import jp.nichicom.ac.ACCommon;
import jp.nichicom.ac.component.table.ACCheckBoxTableColumnPopupMenu;
import jp.nichicom.ac.component.table.event.ACCheckBoxTableColumnPopupMenuAdapter;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.sql.ACPassiveKey;
import jp.nichicom.ac.util.adapter.ACTableModelAdapter;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;

/**
 * ���p�҈ꗗ�C�x���g��`(QU001) 
 */
public abstract class QU001Event extends QU001SQL {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QU001Event(){
    addEvents();
  }
  /**
   * �C�x���g�����������`���܂��B
   */
  protected void addEvents() {
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
    getDetail().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                detailActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getInsert().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                insertActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getPlanInsert().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                planInsertActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getResultInsert().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                resultInsertActionPerformed(e);
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
    getPrintReport().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                printReportActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getPatients().addListSelectionListener(new ListSelectionListener(){
        private boolean lockFlag = false;
        public void valueChanged(ListSelectionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                patientsSelectionChanged(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getPatients().addMouseListener(new MouseAdapter(){
        private boolean lockFlag = false;
        public void mouseClicked(MouseEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                if (e.getClickCount() == 2) {
                    patientsMouseClicked(e);
                }
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    if(getPatientChoiseColumn().getHeaderPopupMenu() instanceof ACCheckBoxTableColumnPopupMenu){      ((ACCheckBoxTableColumnPopupMenu)getPatientChoiseColumn().getHeaderPopupMenu()).addPopupMenuListener(new ACCheckBoxTableColumnPopupMenuAdapter(){
          private boolean lockFlag = false;
          public void allCheckMenuActionPerformed(ActionEvent e) {
              if (lockFlag) {
                  return;
              }
              lockFlag = true;
              try {
                  patientChoiseColumnCheckMenuActionPerformed(e);
              }catch(Throwable ex){
                  ACCommon.getInstance().showExceptionMessage(ex);
              }finally{
                  lockFlag = false;
              }
          }
       });
      ((ACCheckBoxTableColumnPopupMenu)getPatientChoiseColumn().getHeaderPopupMenu()).addPopupMenuListener(new ACCheckBoxTableColumnPopupMenuAdapter(){
          private boolean lockFlag = false;
          public void allUncheckMenuActionPerformed(ActionEvent e) {
              if (lockFlag) {
                  return;
              }
              lockFlag = true;
              try {
                  patientChoiseColumnCheckMenuActionPerformed(e);
              }catch(Throwable ex){
                  ACCommon.getInstance().showExceptionMessage(ex);
              }finally{
                  lockFlag = false;
              }
          }
       });
      ((ACCheckBoxTableColumnPopupMenu)getPatientChoiseColumn().getHeaderPopupMenu()).addPopupMenuListener(new ACCheckBoxTableColumnPopupMenuAdapter(){
          private boolean lockFlag = false;
          public void reverseCheckMenuActionPerformed(ActionEvent e) {
              if (lockFlag) {
                  return;
              }
              lockFlag = true;
              try {
                  patientChoiseColumnCheckMenuActionPerformed(e);
              }catch(Throwable ex){
                  ACCommon.getInstance().showExceptionMessage(ex);
              }finally{
                  lockFlag = false;
              }
          }
       });
    }    getProviderName().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                providerNameActionPerformed(e);
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
   * �u�����v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void findActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u�ڍ׉�ʂɑJ�ځv�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void detailActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u�o�^��ʂɑJ�ځv�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void insertActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u�T�[�r�X�\��ɑJ�ځv�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void planInsertActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u�T�[�r�X���тɑJ�ځv�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void resultInsertActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u���p�ҍ폜�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void deleteActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u���p�҈ꗗ����v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void printActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u���[����v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void printReportActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u��ʐ���v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void patientsSelectionChanged(ListSelectionEvent e) throws Exception;

  /**
   * �u��ʑJ�ڏ����v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void patientsMouseClicked(MouseEvent e) throws Exception;

  /**
   * �u�I�𑀍상�j���[�N���b�N�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void patientChoiseColumnCheckMenuActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u���Ə��I�������v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void providerNameActionPerformed(ActionEvent e) throws Exception;

  //�ϐ���`

  private ACPassiveKey PASSIVE_CHECK_KEY;
  public static final String AFFAIR_ID = "QU001";
  public static final Date TARGET_DATE_20060401 = ACCastUtilities.toDate("2006/04/01", null);
  public static final int PRINT_NORMAL = 0;
  public static final int PRINT_NO_SELECT = 1;
  public static final int PRINT_EMPTY_AND_TARGET = 2;
  public static final int PRINT_ERROR = 99;
  private int patientId;
  private String nextAffair;
  private Date findTargetDate;
  private VRList patientData = new VRArrayList();
  private VRList kyotakuData = new VRArrayList();
  private ACTableModelAdapter patientTableModel;
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
   * patientId��Ԃ��܂��B
   * @return patientId
   */
  protected int getPatientId(){
    return patientId;
  }
  /**
   * patientId��ݒ肵�܂��B
   * @param patientId patientId
   */
  protected void setPatientId(int patientId){
    this.patientId = patientId;
  }

  /**
   * nextAffair��Ԃ��܂��B
   * @return nextAffair
   */
  protected String getNextAffair(){
    return nextAffair;
  }
  /**
   * nextAffair��ݒ肵�܂��B
   * @param nextAffair nextAffair
   */
  protected void setNextAffair(String nextAffair){
    this.nextAffair = nextAffair;
  }

  /**
   * findTargetDate��Ԃ��܂��B
   * @return findTargetDate
   */
  protected Date getFindTargetDate(){
    return findTargetDate;
  }
  /**
   * findTargetDate��ݒ肵�܂��B
   * @param findTargetDate findTargetDate
   */
  protected void setFindTargetDate(Date findTargetDate){
    this.findTargetDate = findTargetDate;
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
   * kyotakuData��Ԃ��܂��B
   * @return kyotakuData
   */
  protected VRList getKyotakuData(){
    return kyotakuData;
  }
  /**
   * kyotakuData��ݒ肵�܂��B
   * @param kyotakuData kyotakuData
   */
  protected void setKyotakuData(VRList kyotakuData){
    this.kyotakuData = kyotakuData;
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

  //�����֐�

  /**
   * �u�����������v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   *
   */
  public abstract void initialize() throws Exception;

  /**
   * �u�����v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   *
   */
  public abstract void doFind() throws Exception;

  /**
   * �u��ʑJ�ڏ����v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @param patientId int
   * @throws Exception ������O
   *
   */
  public abstract void transferNext(int patientId) throws Exception;

  /**
   * �u���̓`�F�b�N�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   * @return boolean
   */
  public abstract boolean checkValue() throws Exception;

  /**
   * �u���p�҂̗v�����`�F�b�N�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @param patientId int
   * @throws Exception ������O
   * @return boolean
   */
  public abstract boolean checkInsureInfo(int patientId) throws Exception;

  /**
   * �u����×{�Ǘ��w�������������v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   *
   */
  public abstract void doInitializeQC005() throws Exception;

  /**
   * �u����×{�Ǘ��w���p�̌��������v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @param patientData VRList
   * @param sqlParam VRMap
   * @throws Exception ������O
   * @return VRList
   */
  public abstract VRList doFindQC005(VRList patientData, VRMap sqlParam) throws Exception;

  /**
   * �u�蓮���������v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @param targetList VRList
   * @param findParam VRMap
   * @param keys String[]
   * @throws Exception ������O
   * @return VRList 
   */
  public abstract VRList  doMultiFind(VRList targetList, VRMap findParam, String[] keys) throws Exception;

  /**
   * �u���������v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @param targetList VRList
   * @param findParam VRMap
   * @param filterKey String
   * @throws Exception ������O
   * @return VRList
   */
  public abstract VRList filterData(VRList targetList, VRMap findParam, String filterKey) throws Exception;

  /**
   * �u������C�������v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @param printData VRList
   * @throws Exception ������O
   * @return boolean
   */
  public abstract boolean doPrintQC005(VRList printData) throws Exception;

  /**
   * �u����Ώۃf�[�^���`�F�b�N���܂��v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @param patientData VRList
   * @throws Exception ������O
   * @return int
   */
  public abstract int checkPrintData(VRList patientData) throws Exception;

  /**
   * �u�f�[�^�ϊ������v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @param printParam VRMap
   * @throws Exception ������O
   * @return VRMap
   */
  public abstract VRMap parseQC005PrintData(VRMap printParam) throws Exception;

}
