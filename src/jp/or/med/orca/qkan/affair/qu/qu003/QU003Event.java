
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
 * �J����: ��i�@�a�P
 * �쐬��: 2006/04/16  ���{�R���s���[�^�[������� ��i�@�a�P �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���p�ҊǗ� (U)
 * �v���Z�X ��ÊŌ����� (003)
 * �v���O���� ��ÊŌ����� (QU003)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qu.qu003;
import java.awt.*;
import java.awt.event.*;
import java.awt.im.*;
import java.io.*;
import java.sql.SQLException;
import java.text.*;
import java.util.*;
import java.util.List;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
import jp.nichicom.ac.*;
import jp.nichicom.ac.bind.*;
import jp.nichicom.ac.component.*;
import jp.nichicom.ac.component.dnd.*;
import jp.nichicom.ac.component.dnd.event.*;
import jp.nichicom.ac.component.event.*;
import jp.nichicom.ac.component.mainmenu.*;
import jp.nichicom.ac.component.table.*;
import jp.nichicom.ac.component.table.event.*;
import jp.nichicom.ac.container.*;
import jp.nichicom.ac.core.*;
import jp.nichicom.ac.filechooser.*;
import jp.nichicom.ac.io.*;
import jp.nichicom.ac.lang.*;
import jp.nichicom.ac.pdf.*;
import jp.nichicom.ac.sql.*;
import jp.nichicom.ac.text.*;
import jp.nichicom.ac.util.*;
import jp.nichicom.ac.util.adapter.*;
import jp.nichicom.vr.*;
import jp.nichicom.vr.bind.*;
import jp.nichicom.vr.bind.event.*;
import jp.nichicom.vr.border.*;
import jp.nichicom.vr.component.*;
import jp.nichicom.vr.component.event.*;
import jp.nichicom.vr.component.table.*;
import jp.nichicom.vr.container.*;
import jp.nichicom.vr.focus.*;
import jp.nichicom.vr.image.*;
import jp.nichicom.vr.io.*;
import jp.nichicom.vr.layout.*;
import jp.nichicom.vr.text.*;
import jp.nichicom.vr.text.parsers.*;
import jp.nichicom.vr.util.*;
import jp.nichicom.vr.util.adapter.*;
import jp.nichicom.vr.util.logging.*;
import jp.or.med.orca.qkan.*;
import jp.or.med.orca.qkan.affair.*;
import jp.or.med.orca.qkan.component.*;
import jp.or.med.orca.qkan.text.*;
import jp.nichicom.ac.lib.care.claim.print.schedule.*;

/**
 * ��ÊŌ����ʃC�x���g��`(QU003) 
 */
public abstract class QU003Event extends QU003SQL {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QU003Event(){
    addEvents();
  }
  /**
   * �C�x���g�����������`���܂��B
   */
  protected void addEvents() {
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
    getUpdate().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                updateActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getMedicalInfoTable().addListSelectionListener(new ListSelectionListener(){
        private boolean lockFlag = false;
        public void valueChanged(ListSelectionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                medicalInfoTableSelectionChanged(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getMedicalInfoButtonClear().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                medicalInfoButtonClearActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getMedicalInfoButtonInsert().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                medicalInfoButtonInsertActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getMedicalInfoButtonConpile().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                medicalInfoButtonConpileActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getMedicalInfoButtonDelete().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                medicalInfoButtonDeleteActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getSpecialInstructButton2().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                specialInstructButton2ActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getMedicalInfoInsurerNo().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                medicalInfoInsurerNoFocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getMedicalInfoInsurerName().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                medicalInfoInsurerNameActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getMedicalInfoCitiesNo().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                medicalInfoCitiesNoFocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getMedicalInfoCitiesName().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                medicalInfoCitiesNameActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getMedicalTreatmentInfoOrgan().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                medicalTreatmentInfoOrganActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getMedicalInfoInsuranceVarietyRadio2().addListSelectionListener(new ListSelectionListener(){
        private boolean lockFlag = false;
        public void valueChanged(ListSelectionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                medicalInfoInsuranceVarietyRadio2SelectionChanged(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getMedicalInfoInsuranceVarietyRadio1().addListSelectionListener(new ListSelectionListener(){
        private boolean lockFlag = false;
        public void valueChanged(ListSelectionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                medicalInfoInsuranceVarietyRadio1SelectionChanged(e);
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
   * �uDB�o�^�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void insertActionPerformed(ActionEvent e) throws Exception;

  /**
   * �uDB�X�V�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void updateActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u�Ώۃ��R�[�h��\���v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void medicalInfoTableSelectionChanged(ListSelectionEvent e) throws Exception;

  /**
   * �u�N���A�����v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void medicalInfoButtonClearActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u�ǉ������v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void medicalInfoButtonInsertActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u�ҏW�����v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void medicalInfoButtonConpileActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u�폜�����v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void medicalInfoButtonDeleteActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u�N���A�����v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void specialInstructButton2ActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u��ʏ����v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void medicalInfoInsurerNoFocusLost(FocusEvent e) throws Exception;

  /**
   * �u��ʏ����v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void medicalInfoInsurerNameActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u��ʏ����v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void medicalInfoCitiesNoFocusLost(FocusEvent e) throws Exception;

  /**
   * �u��ʏ����v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void medicalInfoCitiesNameActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u��ʏ����v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void medicalTreatmentInfoOrganActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u��ʏ����v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void medicalInfoInsuranceVarietyRadio2SelectionChanged(ListSelectionEvent e) throws Exception;

  /**
   * �u��ʏ����v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void medicalInfoInsuranceVarietyRadio1SelectionChanged(ListSelectionEvent e) throws Exception;

  //�ϐ���`

  private ACPassiveKey PASSIVE_CHECK_KEY;
  private int patientId;
  private int systemDate;
  private int processMode = QkanConstants.PROCESS_MODE_INSERT;
  private int medicalTableChangeFlg;
  private int medicalDataFlg;
  private int stationDataFlg;
  private int compulsoryBackFlg;
  public static final String AFFAIR_ID = "QU003";
  public static final int CODE_BENEFIT_RATE = 17;
  public static final int CODE_INSURE_TYPE = 15;
  public static final int CODE_HONNIN_KAZOKU = 14;
  public static final int INSURE_TYPE_KOHI = 3;
  public static final int STATION_HISTORY_ID = 1;
  public static final int CHECK_MODE_INSERT = 1;
  public static final int CHECK_MODE_UPDATE = 2;
  private String processStart;
  private VRList medicalHistoryList = new VRArrayList();
  private VRList stationHistoryList = new VRArrayList();
  private VRList medicalFacilityList = new VRArrayList();
  private VRList insurerList = new VRArrayList();
  private VRMap masterCode = new VRHashMap();
  private ACTableModelAdapter medicalTableModel;
  private ACSnapshot snapShotIryo = new ACSnapshot();
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
   * systemDate��Ԃ��܂��B
   * @return systemDate
   */
  protected int getSystemDate(){
    return systemDate;
  }
  /**
   * systemDate��ݒ肵�܂��B
   * @param systemDate systemDate
   */
  protected void setSystemDate(int systemDate){
    this.systemDate = systemDate;
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
   * medicalTableChangeFlg��Ԃ��܂��B
   * @return medicalTableChangeFlg
   */
  protected int getMedicalTableChangeFlg(){
    return medicalTableChangeFlg;
  }
  /**
   * medicalTableChangeFlg��ݒ肵�܂��B
   * @param medicalTableChangeFlg medicalTableChangeFlg
   */
  protected void setMedicalTableChangeFlg(int medicalTableChangeFlg){
    this.medicalTableChangeFlg = medicalTableChangeFlg;
  }

  /**
   * medicalDataFlg��Ԃ��܂��B
   * @return medicalDataFlg
   */
  protected int getMedicalDataFlg(){
    return medicalDataFlg;
  }
  /**
   * medicalDataFlg��ݒ肵�܂��B
   * @param medicalDataFlg medicalDataFlg
   */
  protected void setMedicalDataFlg(int medicalDataFlg){
    this.medicalDataFlg = medicalDataFlg;
  }

  /**
   * stationDataFlg��Ԃ��܂��B
   * @return stationDataFlg
   */
  protected int getStationDataFlg(){
    return stationDataFlg;
  }
  /**
   * stationDataFlg��ݒ肵�܂��B
   * @param stationDataFlg stationDataFlg
   */
  protected void setStationDataFlg(int stationDataFlg){
    this.stationDataFlg = stationDataFlg;
  }

  /**
   * compulsoryBackFlg��Ԃ��܂��B
   * @return compulsoryBackFlg
   */
  protected int getCompulsoryBackFlg(){
    return compulsoryBackFlg;
  }
  /**
   * compulsoryBackFlg��ݒ肵�܂��B
   * @param compulsoryBackFlg compulsoryBackFlg
   */
  protected void setCompulsoryBackFlg(int compulsoryBackFlg){
    this.compulsoryBackFlg = compulsoryBackFlg;
  }

  /**
   * processStart��Ԃ��܂��B
   * @return processStart
   */
  protected String getProcessStart(){
    return processStart;
  }
  /**
   * processStart��ݒ肵�܂��B
   * @param processStart processStart
   */
  protected void setProcessStart(String processStart){
    this.processStart = processStart;
  }

  /**
   * medicalHistoryList��Ԃ��܂��B
   * @return medicalHistoryList
   */
  protected VRList getMedicalHistoryList(){
    return medicalHistoryList;
  }
  /**
   * medicalHistoryList��ݒ肵�܂��B
   * @param medicalHistoryList medicalHistoryList
   */
  protected void setMedicalHistoryList(VRList medicalHistoryList){
    this.medicalHistoryList = medicalHistoryList;
  }

  /**
   * stationHistoryList��Ԃ��܂��B
   * @return stationHistoryList
   */
  protected VRList getStationHistoryList(){
    return stationHistoryList;
  }
  /**
   * stationHistoryList��ݒ肵�܂��B
   * @param stationHistoryList stationHistoryList
   */
  protected void setStationHistoryList(VRList stationHistoryList){
    this.stationHistoryList = stationHistoryList;
  }

  /**
   * medicalFacilityList��Ԃ��܂��B
   * @return medicalFacilityList
   */
  protected VRList getMedicalFacilityList(){
    return medicalFacilityList;
  }
  /**
   * medicalFacilityList��ݒ肵�܂��B
   * @param medicalFacilityList medicalFacilityList
   */
  protected void setMedicalFacilityList(VRList medicalFacilityList){
    this.medicalFacilityList = medicalFacilityList;
  }

  /**
   * insurerList��Ԃ��܂��B
   * @return insurerList
   */
  protected VRList getInsurerList(){
    return insurerList;
  }
  /**
   * insurerList��ݒ肵�܂��B
   * @param insurerList insurerList
   */
  protected void setInsurerList(VRList insurerList){
    this.insurerList = insurerList;
  }

  /**
   * masterCode��Ԃ��܂��B
   * @return masterCode
   */
  protected VRMap getMasterCode(){
    return masterCode;
  }
  /**
   * masterCode��ݒ肵�܂��B
   * @param masterCode masterCode
   */
  protected void setMasterCode(VRMap masterCode){
    this.masterCode = masterCode;
  }

  /**
   * medicalTableModel��Ԃ��܂��B
   * @return medicalTableModel
   */
  protected ACTableModelAdapter getMedicalTableModel(){
    return medicalTableModel;
  }
  /**
   * medicalTableModel��ݒ肵�܂��B
   * @param medicalTableModel medicalTableModel
   */
  protected void setMedicalTableModel(ACTableModelAdapter medicalTableModel){
    this.medicalTableModel = medicalTableModel;
  }

  /**
   * snapShotIryo��Ԃ��܂��B
   * @return snapShotIryo
   */
  protected ACSnapshot getSnapShotIryo(){
    return snapShotIryo;
  }
  /**
   * snapShotIryo��ݒ肵�܂��B
   * @param snapShotIryo snapShotIryo
   */
  protected void setSnapShotIryo(ACSnapshot snapShotIryo){
    this.snapShotIryo = snapShotIryo;
  }

  //�����֐�

  /**
   * �u���̓`�F�b�N�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   * @return boolean
   */
  public abstract boolean isValidInputStation() throws Exception;

  /**
   * �u���̓`�F�b�N�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @param checkMode int
   * @throws Exception ������O
   * @return boolean
   */
  public abstract boolean isValidInputMedical(int checkMode) throws Exception;

  /**
   * �u�ۑ������v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   * @return boolean
   */
  public abstract boolean doSave() throws Exception;

  /**
   * �u���R�[�h�擾�E��ʐݒ�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   *
   */
  public abstract void doFind() throws Exception;

  /**
   * �u��Õی��������擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   *
   */
  public abstract void doFindMedical() throws Exception;

  /**
   * �u�K��Ō�X�e�[�V�����������擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   *
   */
  public abstract void doFindStation() throws Exception;

  /**
   * �u��ʏ������v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   *
   */
  public abstract void initialize() throws Exception;

  /**
   * �u��ʐݒ�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   *
   */
  public abstract void casualInitialize() throws Exception;

  /**
   * �u�f�[�^�ҏW�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @param list VRList
   * @throws Exception ������O
   * @return VRList
   */
  public abstract VRList toMedicalTableList(VRList list) throws Exception;

  /**
   * �u�f�[�^�ҏW�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @param map VRMap
   * @throws Exception ������O
   * @return VRMap
   */
  public abstract VRMap toMedicalTableList(VRMap map) throws Exception;

}
