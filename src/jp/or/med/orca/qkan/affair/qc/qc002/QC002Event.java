
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
 * �쐬��: 2006/01/24  ���{�R���s���[�^�[������� �� ���� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���[�Ǘ� (C)
 * �v���Z�X �񍐏������� (002)
 * �v���O���� �񍐏������� (QC002)
 *
 *****************************************************************
 */

package jp.or.med.orca.qkan.affair.qc.qc002;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import jp.nichicom.ac.ACCommon;
import jp.nichicom.ac.sql.ACPassiveKey;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;

/**
 * �񍐏������̓C�x���g��`(QC002) 
 */
public abstract class QC002Event extends QC002SQL {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QC002Event(){
    addEvents();
  }
  /**
   * �C�x���g�����������`���܂��B
   */
  protected void addEvents() {
    getPrint().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                printActionPerformed(e);
            }catch(Exception ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getOpen().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                openActionPerformed(e);
            }catch(Exception ex){
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
            }catch(Exception ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getUpdate().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                updateActionPerformed(e);
            }catch(Exception ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getProviderName().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                providerNameActionPerformed(e);
            }catch(Exception ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getResultReadButtonLeft().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                resultReadButtonLeftActionPerformed(e);
            }catch(Exception ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getResultReadButtonRight().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                resultReadButtonRightActionPerformed(e);
            }catch(Exception ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });

  }
  //�R���|�[�l���g�C�x���g

  /**
   * �u��������v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void printActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u���߂̖K��Ō�񍐏����̓Ǎ��v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void openActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u�o�^�����v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void insertActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u�X�V�����v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void updateActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u�I�����Ə��̊Ǘ��Ҏ����̐ݒ�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void providerNameActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u�K������i���j��W�J���鏈���v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void resultReadButtonLeftActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u�K������i�E�j��W�J���鏈���v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void resultReadButtonRightActionPerformed(ActionEvent e) throws Exception;

  //�ϐ���`

  private ACPassiveKey PASSIVE_CHECK_KEY_RESULT;
  private ACPassiveKey PASSIVE_CHECK_KEY_CALENDAR_LEFT;
  private ACPassiveKey PASSIVE_CHECK_KEY_CALENDAR_RIGHT;
  private int patientID;
  private int processMode;
  private int calendarLeftCount;
  private int calendarRightCount;
  private boolean loadedValueCalendarLeft;
  private boolean loadedValueCalendarRight;
  private boolean forciblyBackCheckFlag;
  private Date targetDateSource;
  private VRMap resultData = new VRHashMap();
  private VRList calendarData = new VRArrayList();
  //getter/setter

  /**
   * PASSIVE_CHECK_KEY_RESULT��Ԃ��܂��B
   * @return PASSIVE_CHECK_KEY_RESULT
   */
  protected ACPassiveKey getPASSIVE_CHECK_KEY_RESULT(){
    return PASSIVE_CHECK_KEY_RESULT;
  }
  /**
   * PASSIVE_CHECK_KEY_RESULT��ݒ肵�܂��B
   * @param PASSIVE_CHECK_KEY_RESULT PASSIVE_CHECK_KEY_RESULT
   */
  protected void setPASSIVE_CHECK_KEY_RESULT(ACPassiveKey PASSIVE_CHECK_KEY_RESULT){
    this.PASSIVE_CHECK_KEY_RESULT = PASSIVE_CHECK_KEY_RESULT;
  }

  /**
   * PASSIVE_CHECK_KEY_CALENDAR_LEFT��Ԃ��܂��B
   * @return PASSIVE_CHECK_KEY_CALENDAR_LEFT
   */
  protected ACPassiveKey getPASSIVE_CHECK_KEY_CALENDAR_LEFT(){
    return PASSIVE_CHECK_KEY_CALENDAR_LEFT;
  }
  /**
   * PASSIVE_CHECK_KEY_CALENDAR_LEFT��ݒ肵�܂��B
   * @param PASSIVE_CHECK_KEY_CALENDAR_LEFT PASSIVE_CHECK_KEY_CALENDAR_LEFT
   */
  protected void setPASSIVE_CHECK_KEY_CALENDAR_LEFT(ACPassiveKey PASSIVE_CHECK_KEY_CALENDAR_LEFT){
    this.PASSIVE_CHECK_KEY_CALENDAR_LEFT = PASSIVE_CHECK_KEY_CALENDAR_LEFT;
  }

  /**
   * PASSIVE_CHECK_KEY_CALENDAR_RIGHT��Ԃ��܂��B
   * @return PASSIVE_CHECK_KEY_CALENDAR_RIGHT
   */
  protected ACPassiveKey getPASSIVE_CHECK_KEY_CALENDAR_RIGHT(){
    return PASSIVE_CHECK_KEY_CALENDAR_RIGHT;
  }
  /**
   * PASSIVE_CHECK_KEY_CALENDAR_RIGHT��ݒ肵�܂��B
   * @param PASSIVE_CHECK_KEY_CALENDAR_RIGHT PASSIVE_CHECK_KEY_CALENDAR_RIGHT
   */
  protected void setPASSIVE_CHECK_KEY_CALENDAR_RIGHT(ACPassiveKey PASSIVE_CHECK_KEY_CALENDAR_RIGHT){
    this.PASSIVE_CHECK_KEY_CALENDAR_RIGHT = PASSIVE_CHECK_KEY_CALENDAR_RIGHT;
  }

  /**
   * patientID��Ԃ��܂��B
   * @return patientID
   */
  protected int getPatientID(){
    return patientID;
  }
  /**
   * patientID��ݒ肵�܂��B
   * @param patientID patientID
   */
  protected void setPatientID(int patientID){
    this.patientID = patientID;
  }

  /**
   * processMode��Ԃ��܂��B
   * @return processMode
   */
  protected int getProcessMode(){
    return processMode;
  }
  /**
   * processMode��ݒ肵�܂��B
   * @param processMode processMode
   */
  protected void setProcessMode(int processMode){
    this.processMode = processMode;
  }

  /**
   * calendarLeftCount��Ԃ��܂��B
   * @return calendarLeftCount
   */
  protected int getCalendarLeftCount(){
    return calendarLeftCount;
  }
  /**
   * calendarLeftCount��ݒ肵�܂��B
   * @param calendarLeftCount calendarLeftCount
   */
  protected void setCalendarLeftCount(int calendarLeftCount){
    this.calendarLeftCount = calendarLeftCount;
  }

  /**
   * calendarRightCount��Ԃ��܂��B
   * @return calendarRightCount
   */
  protected int getCalendarRightCount(){
    return calendarRightCount;
  }
  /**
   * calendarRightCount��ݒ肵�܂��B
   * @param calendarRightCount calendarRightCount
   */
  protected void setCalendarRightCount(int calendarRightCount){
    this.calendarRightCount = calendarRightCount;
  }

  /**
   * loadedValueCalendarLeft��Ԃ��܂��B
   * @return loadedValueCalendarLeft
   */
  protected boolean getLoadedValueCalendarLeft(){
    return loadedValueCalendarLeft;
  }
  /**
   * loadedValueCalendarLeft��ݒ肵�܂��B
   * @param loadedValueCalendarLeft loadedValueCalendarLeft
   */
  protected void setLoadedValueCalendarLeft(boolean loadedValueCalendarLeft){
    this.loadedValueCalendarLeft = loadedValueCalendarLeft;
  }

  /**
   * loadedValueCalendarRight��Ԃ��܂��B
   * @return loadedValueCalendarRight
   */
  protected boolean getLoadedValueCalendarRight(){
    return loadedValueCalendarRight;
  }
  /**
   * loadedValueCalendarRight��ݒ肵�܂��B
   * @param loadedValueCalendarRight loadedValueCalendarRight
   */
  protected void setLoadedValueCalendarRight(boolean loadedValueCalendarRight){
    this.loadedValueCalendarRight = loadedValueCalendarRight;
  }

  /**
   * forciblyBackCheckFlag��Ԃ��܂��B
   * @return forciblyBackCheckFlag
   */
  protected boolean getForciblyBackCheckFlag(){
    return forciblyBackCheckFlag;
  }
  /**
   * forciblyBackCheckFlag��ݒ肵�܂��B
   * @param forciblyBackCheckFlag forciblyBackCheckFlag
   */
  protected void setForciblyBackCheckFlag(boolean forciblyBackCheckFlag){
    this.forciblyBackCheckFlag = forciblyBackCheckFlag;
  }

  /**
   * targetDateSource��Ԃ��܂��B
   * @return targetDateSource
   */
  protected Date getTargetDateSource(){
    return targetDateSource;
  }
  /**
   * targetDateSource��ݒ肵�܂��B
   * @param targetDateSource targetDateSource
   */
  protected void setTargetDateSource(Date targetDateSource){
    this.targetDateSource = targetDateSource;
  }

  /**
   * resultData��Ԃ��܂��B
   * @return resultData
   */
  protected VRMap getResultData(){
    return resultData;
  }
  /**
   * resultData��ݒ肵�܂��B
   * @param resultData resultData
   */
  protected void setResultData(VRMap resultData){
    this.resultData = resultData;
  }

  /**
   * calendarData��Ԃ��܂��B
   * @return calendarData
   */
  protected VRList getCalendarData(){
    return calendarData;
  }
  /**
   * calendarData��ݒ肵�܂��B
   * @param calendarData calendarData
   */
  protected void setCalendarData(VRList calendarData){
    this.calendarData = calendarData;
  }

  //�����֐�

  /**
   * �u�E�B���h�E�^�C�g���̐ݒ�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   *
   */
  public abstract void doInitialize() throws Exception;

  /**
   * �u�K��Ō�񍐏����̐ݒ�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   *
   */
  public abstract void doFind() throws Exception;

  /**
   * �u�����l�̐ݒ�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   *
   */
  public abstract void setInitValue() throws Exception;

  /**
   * �u�o�^�ς݂̖K������擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @param visitDate Date
   * @throws Exception ������O
   * @return VRList
   */
  public abstract VRList getVisitDataFromResult(Date visitDate) throws Exception;

  /**
   * �u�T�[�r�X���т���K������擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @param targetDate Date
   * @param type String
   * @throws Exception ������O
   * @return VRMap
   */
  public abstract VRMap getVisitDataFromService(Date targetDate, String type) throws Exception;

  /**
   * �u�ۑ������v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   * @return boolean
   */
  public abstract boolean doInsert() throws Exception;

  /**
   * �u�ۑ������v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   * @return boolean
   */
  public abstract boolean doUpdate() throws Exception;

  /**
   * �u���Ə��̊Ǘ��Ҏ����擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @param rec VRMap
   * @throws Exception ������O
   * @return String
   */
  public abstract String getAdministratorName(VRMap rec) throws Exception;

  /**
   * �u���̓`�F�b�N�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   * @return boolean
   */
  public abstract boolean checkValidInput() throws Exception;

  /**
   * �u�K����̃R���{�f�[�^���쐬���鏈���v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @param targetDate Date
   * @param type String
   * @throws Exception ������O
   * @return VRMap
   */
  public abstract VRMap createCalendarData(Date targetDate, String type) throws Exception;

  /**
   * �u�擾�����J�����_�[����ʂɓW�J���鏈���v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   *
   */
  public abstract void findCalendar() throws Exception;

  /**
   * �u��ʂɓW�J����J�����_�[�f�[�^���쐬���鏈���v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @param targetDate Date
   * @param type String
   * @throws Exception ������O
   * @return VRMap
   */
  public abstract VRMap createBindData(Date targetDate, String type) throws Exception;

  /**
   * �u�ۑ��Ɏg�p����f�[�^���쐬���鏈���v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   * @return VRMap
   */
  public abstract VRMap createSaveData() throws Exception;

  /**
   * �u�J�����_�[����ۑ����鏈���v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @param leftList VRList
   * @param rightList VRList
   * @throws Exception ������O
   *
   */
  public abstract void doSaveCalendar(VRList leftList, VRList rightList) throws Exception;

  /**
   * �u�J�����_�[�̏����l��ݒ肷�鏈���v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   *
   */
  public abstract void initializeCalendar(boolean isLeft, boolean isRight) throws Exception;

}
