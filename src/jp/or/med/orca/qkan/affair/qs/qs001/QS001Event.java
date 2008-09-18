
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
 * �J����: ���}�@�M�u
 * �쐬��: 2007/12/13  ���{�R���s���[�^�[������� ���}�@�M�u �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �\��Ǘ� (S)
 * �v���Z�X �T�[�r�X�\�� (001)
 * �v���O���� �T�[�r�X�\�� (QS001)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
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
 * �T�[�r�X�\��C�x���g��`(QS001) 
 */
public abstract class QS001Event extends QS001SQL implements ACDroppableListener {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001Event(){
    addEvents();
  }
  /**
   * �C�x���g�����������`���܂��B
   */
  protected void addEvents() {
    getPrintWeekly().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                printWeeklyActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getPrintMonthly().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                printMonthlyActionPerformed(e);
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
    getOpenPlan().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                openPlanActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getClearPlan().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                clearPlanActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getOpenResult().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                openResultActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getClearResult().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                clearResultActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getServiceKindList().addListSelectionListener(new ListSelectionListener(){
        private boolean lockFlag = false;
        public void valueChanged(ListSelectionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                serviceKindListSelectionChanged(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getPatternList().addListSelectionListener(new ListSelectionListener(){
        private boolean lockFlag = false;
        public void valueChanged(ListSelectionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                patternListSelectionChanged(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getPatternAdd().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                patternAddActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getPatternDelete().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                patternDeleteActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getPatternNameChange().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                patternNameChangeActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getServiceOfferEntrepreneur().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                serviceOfferEntrepreneurActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getServiceSet().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                serviceSetActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getServiceDelete().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                serviceDeleteActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getChangeChart().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                changeChartActionPerformed(e);
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
   * �u��������v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void printWeeklyActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u��������v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void printMonthlyActionPerformed(ActionEvent e) throws Exception;

  /**
   * �uDB�ւ̓o�^�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void insertActionPerformed(ActionEvent e) throws Exception;

  /**
   * �uDB�ւ̍X�V�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void updateActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u�ߋ��f�[�^�Ǎ��v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void openPlanActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u��ʃN���A�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void clearPlanActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u�\��f�[�^�Ǎ��v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void openResultActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u��ʃN���A�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void clearResultActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u�T�[�r�X��ޑI���C�x���g�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void serviceKindListSelectionChanged(ListSelectionEvent e) throws Exception;

  /**
   * �u�T�[�r�X�p�^�[���I���C�x���g�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void patternListSelectionChanged(ListSelectionEvent e) throws Exception;

  /**
   * �u�T�[�r�X�p�^�[���o�^�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void patternAddActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u�T�[�r�X�p�^�[���폜�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void patternDeleteActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u�T�[�r�X�p�^�[�����̕ύX�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void patternNameChangeActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u�T�[�r�X���e�̐ݒ�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void serviceOfferEntrepreneurActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u�T�[�r�X���㏑�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void serviceSetActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u�T�[�r�X���폜�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void serviceDeleteActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u�T�ԕ\�E���ԕ\�̐ؑցv�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void changeChartActionPerformed(ActionEvent e) throws Exception;

  //�ϐ���`

  private int processMode;
  private int processType;
  private int patientID;
  private int selectedServiceKind;
  private int inSpecialFacilityFlag;
  private int oldFacilityUserFlag;
  private Date targetDate;
  private VRMap patientInfo = new VRHashMap();
  private VRMap passiveCheckSQLParam = new VRHashMap();
  private VRMap servicePatternHash = new VRHashMap();
  private VRMap nowSelectedService = new VRHashMap();
  private VRList nowServicePatterns = new VRArrayList();
  private VRList deleteReseveServicePatterns = new VRArrayList();
  private VRList insertReserveServicePatterns = new VRArrayList();
  private VRList serviceKindsList = new VRArrayList();
  private QS001001 weeklyPanel;
  private QS001002 monthlyPanel;
  private QS001Service selectedServiceClass;
  public static final int DAYLY_LIFE_SERVICE = 90201;
  private ACPassiveKey SERVICE_PASSIVE_CHECK_KEY;
  private QS001DaySchedule selectedServiceListBox;
  private QS001ServicePatternListCellRenderer sharedFocusCellRenderer;
  private QS001FollowTimeComboDocumentListener beginTimeFollowListener;
  private QS001FollowTimeComboDocumentListener endTimeFollowListener;
  private CareServiceCodeCalcurater calcurater;
  private boolean serviceModify = false;
  private boolean serviceListLockFlag = false;
  private Dimension servicePreferredSize;
  //getter/setter

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
   * processType��Ԃ��܂��B
   * @return processType
   */
  protected int getProcessType(){
    return processType;
  }
  /**
   * processType��ݒ肵�܂��B
   * @param processType processType
   */
  protected void setProcessType(int processType){
    this.processType = processType;
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
   * selectedServiceKind��Ԃ��܂��B
   * @return selectedServiceKind
   */
  protected int getSelectedServiceKind(){
    return selectedServiceKind;
  }
  /**
   * selectedServiceKind��ݒ肵�܂��B
   * @param selectedServiceKind selectedServiceKind
   */
  protected void setSelectedServiceKind(int selectedServiceKind){
    this.selectedServiceKind = selectedServiceKind;
  }

  /**
   * inSpecialFacilityFlag��Ԃ��܂��B
   * @return inSpecialFacilityFlag
   */
  protected int getInSpecialFacilityFlag(){
    return inSpecialFacilityFlag;
  }
  /**
   * inSpecialFacilityFlag��ݒ肵�܂��B
   * @param inSpecialFacilityFlag inSpecialFacilityFlag
   */
  protected void setInSpecialFacilityFlag(int inSpecialFacilityFlag){
    this.inSpecialFacilityFlag = inSpecialFacilityFlag;
  }

  /**
   * oldFacilityUserFlag��Ԃ��܂��B
   * @return oldFacilityUserFlag
   */
  protected int getOldFacilityUserFlag(){
    return oldFacilityUserFlag;
  }
  /**
   * oldFacilityUserFlag��ݒ肵�܂��B
   * @param oldFacilityUserFlag oldFacilityUserFlag
   */
  protected void setOldFacilityUserFlag(int oldFacilityUserFlag){
    this.oldFacilityUserFlag = oldFacilityUserFlag;
  }

  /**
   * targetDate��Ԃ��܂��B
   * @return targetDate
   */
  protected Date getTargetDate(){
    return targetDate;
  }
  /**
   * targetDate��ݒ肵�܂��B
   * @param targetDate targetDate
   */
  protected void setTargetDate(Date targetDate){
    this.targetDate = targetDate;
  }

  /**
   * patientInfo��Ԃ��܂��B
   * @return patientInfo
   */
  protected VRMap getPatientInfo(){
    return patientInfo;
  }
  /**
   * patientInfo��ݒ肵�܂��B
   * @param patientInfo patientInfo
   */
  protected void setPatientInfo(VRMap patientInfo){
    this.patientInfo = patientInfo;
  }

  /**
   * passiveCheckSQLParam��Ԃ��܂��B
   * @return passiveCheckSQLParam
   */
  protected VRMap getPassiveCheckSQLParam(){
    return passiveCheckSQLParam;
  }
  /**
   * passiveCheckSQLParam��ݒ肵�܂��B
   * @param passiveCheckSQLParam passiveCheckSQLParam
   */
  protected void setPassiveCheckSQLParam(VRMap passiveCheckSQLParam){
    this.passiveCheckSQLParam = passiveCheckSQLParam;
  }

  /**
   * servicePatternHash��Ԃ��܂��B
   * @return servicePatternHash
   */
  protected VRMap getServicePatternHash(){
    return servicePatternHash;
  }
  /**
   * servicePatternHash��ݒ肵�܂��B
   * @param servicePatternHash servicePatternHash
   */
  protected void setServicePatternHash(VRMap servicePatternHash){
    this.servicePatternHash = servicePatternHash;
  }

  /**
   * nowSelectedService��Ԃ��܂��B
   * @return nowSelectedService
   */
  protected VRMap getNowSelectedService(){
    return nowSelectedService;
  }
  /**
   * nowSelectedService��ݒ肵�܂��B
   * @param nowSelectedService nowSelectedService
   */
  protected void setNowSelectedService(VRMap nowSelectedService){
    this.nowSelectedService = nowSelectedService;
  }

  /**
   * nowServicePatterns��Ԃ��܂��B
   * @return nowServicePatterns
   */
  protected VRList getNowServicePatterns(){
    return nowServicePatterns;
  }
  /**
   * nowServicePatterns��ݒ肵�܂��B
   * @param nowServicePatterns nowServicePatterns
   */
  protected void setNowServicePatterns(VRList nowServicePatterns){
    this.nowServicePatterns = nowServicePatterns;
  }

  /**
   * deleteReseveServicePatterns��Ԃ��܂��B
   * @return deleteReseveServicePatterns
   */
  protected VRList getDeleteReseveServicePatterns(){
    return deleteReseveServicePatterns;
  }
  /**
   * deleteReseveServicePatterns��ݒ肵�܂��B
   * @param deleteReseveServicePatterns deleteReseveServicePatterns
   */
  protected void setDeleteReseveServicePatterns(VRList deleteReseveServicePatterns){
    this.deleteReseveServicePatterns = deleteReseveServicePatterns;
  }

  /**
   * insertReserveServicePatterns��Ԃ��܂��B
   * @return insertReserveServicePatterns
   */
  protected VRList getInsertReserveServicePatterns(){
    return insertReserveServicePatterns;
  }
  /**
   * insertReserveServicePatterns��ݒ肵�܂��B
   * @param insertReserveServicePatterns insertReserveServicePatterns
   */
  protected void setInsertReserveServicePatterns(VRList insertReserveServicePatterns){
    this.insertReserveServicePatterns = insertReserveServicePatterns;
  }

  /**
   * serviceKindsList��Ԃ��܂��B
   * @return serviceKindsList
   */
  protected VRList getServiceKindsList(){
    return serviceKindsList;
  }
  /**
   * serviceKindsList��ݒ肵�܂��B
   * @param serviceKindsList serviceKindsList
   */
  protected void setServiceKindsList(VRList serviceKindsList){
    this.serviceKindsList = serviceKindsList;
  }

  /**
   * weeklyPanel��Ԃ��܂��B
   * @return weeklyPanel
   */
  protected QS001001 getWeeklyPanel(){
    return weeklyPanel;
  }
  /**
   * weeklyPanel��ݒ肵�܂��B
   * @param weeklyPanel weeklyPanel
   */
  protected void setWeeklyPanel(QS001001 weeklyPanel){
    this.weeklyPanel = weeklyPanel;
  }

  /**
   * monthlyPanel��Ԃ��܂��B
   * @return monthlyPanel
   */
  public QS001002 getMonthlyPanel(){
    return monthlyPanel;
  }
  /**
   * monthlyPanel��ݒ肵�܂��B
   * @param monthlyPanel monthlyPanel
   */
  public void setMonthlyPanel(QS001002 monthlyPanel){
    this.monthlyPanel = monthlyPanel;
  }

  /**
   * selectedServiceClass��Ԃ��܂��B
   * @return selectedServiceClass
   */
  protected QS001Service getSelectedServiceClass(){
    return selectedServiceClass;
  }
  /**
   * selectedServiceClass��ݒ肵�܂��B
   * @param selectedServiceClass selectedServiceClass
   */
  protected void setSelectedServiceClass(QS001Service selectedServiceClass){
    this.selectedServiceClass = selectedServiceClass;
  }

  /**
   * SERVICE_PASSIVE_CHECK_KEY��Ԃ��܂��B
   * @return SERVICE_PASSIVE_CHECK_KEY
   */
  protected ACPassiveKey getSERVICE_PASSIVE_CHECK_KEY(){
    return SERVICE_PASSIVE_CHECK_KEY;
  }
  /**
   * SERVICE_PASSIVE_CHECK_KEY��ݒ肵�܂��B
   * @param SERVICE_PASSIVE_CHECK_KEY SERVICE_PASSIVE_CHECK_KEY
   */
  protected void setSERVICE_PASSIVE_CHECK_KEY(ACPassiveKey SERVICE_PASSIVE_CHECK_KEY){
    this.SERVICE_PASSIVE_CHECK_KEY = SERVICE_PASSIVE_CHECK_KEY;
  }

  /**
   * selectedServiceListBox��Ԃ��܂��B
   * @return selectedServiceListBox
   */
  protected QS001DaySchedule getSelectedServiceListBox(){
    return selectedServiceListBox;
  }
  /**
   * selectedServiceListBox��ݒ肵�܂��B
   * @param selectedServiceListBox selectedServiceListBox
   */
  protected void setSelectedServiceListBox(QS001DaySchedule selectedServiceListBox){
    this.selectedServiceListBox = selectedServiceListBox;
  }

  /**
   * sharedFocusCellRenderer��Ԃ��܂��B
   * @return sharedFocusCellRenderer
   */
  protected QS001ServicePatternListCellRenderer getSharedFocusCellRenderer(){
    return sharedFocusCellRenderer;
  }
  /**
   * sharedFocusCellRenderer��ݒ肵�܂��B
   * @param sharedFocusCellRenderer sharedFocusCellRenderer
   */
  protected void setSharedFocusCellRenderer(QS001ServicePatternListCellRenderer sharedFocusCellRenderer){
    this.sharedFocusCellRenderer = sharedFocusCellRenderer;
  }

  /**
   * beginTimeFollowListener��Ԃ��܂��B
   * @return beginTimeFollowListener
   */
  protected QS001FollowTimeComboDocumentListener getBeginTimeFollowListener(){
    return beginTimeFollowListener;
  }
  /**
   * beginTimeFollowListener��ݒ肵�܂��B
   * @param beginTimeFollowListener beginTimeFollowListener
   */
  protected void setBeginTimeFollowListener(QS001FollowTimeComboDocumentListener beginTimeFollowListener){
    this.beginTimeFollowListener = beginTimeFollowListener;
  }

  /**
   * endTimeFollowListener��Ԃ��܂��B
   * @return endTimeFollowListener
   */
  protected QS001FollowTimeComboDocumentListener getEndTimeFollowListener(){
    return endTimeFollowListener;
  }
  /**
   * endTimeFollowListener��ݒ肵�܂��B
   * @param endTimeFollowListener endTimeFollowListener
   */
  protected void setEndTimeFollowListener(QS001FollowTimeComboDocumentListener endTimeFollowListener){
    this.endTimeFollowListener = endTimeFollowListener;
  }

  /**
   * calcurater��Ԃ��܂��B
   * @return calcurater
   */
  protected CareServiceCodeCalcurater getCalcurater(){
    return calcurater;
  }
  /**
   * calcurater��ݒ肵�܂��B
   * @param calcurater calcurater
   */
  protected void setCalcurater(CareServiceCodeCalcurater calcurater){
    this.calcurater = calcurater;
  }

  /**
   * serviceModify��Ԃ��܂��B
   * @return serviceModify
   */
  protected boolean getServiceModify(){
    return serviceModify;
  }
  /**
   * serviceModify��ݒ肵�܂��B
   * @param serviceModify serviceModify
   */
  protected void setServiceModify(boolean serviceModify){
    this.serviceModify = serviceModify;
  }

  /**
   * serviceListLockFlag��Ԃ��܂��B
   * @return serviceListLockFlag
   */
  protected boolean getServiceListLockFlag(){
    return serviceListLockFlag;
  }
  /**
   * serviceListLockFlag��ݒ肵�܂��B
   * @param serviceListLockFlag serviceListLockFlag
   */
  protected void setServiceListLockFlag(boolean serviceListLockFlag){
    this.serviceListLockFlag = serviceListLockFlag;
  }

  /**
   * servicePreferredSize��Ԃ��܂��B
   * @return servicePreferredSize
   */
  protected Dimension getServicePreferredSize(){
    return servicePreferredSize;
  }
  /**
   * servicePreferredSize��ݒ肵�܂��B
   * @param servicePreferredSize servicePreferredSize
   */
  protected void setServicePreferredSize(Dimension servicePreferredSize){
    this.servicePreferredSize = servicePreferredSize;
  }

  //�����֐�

  /**
   * �u���̓`�F�b�N�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   * @return boolean
   */
  public abstract boolean checkValidInput() throws Exception;

  /**
   * �u���������v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   *
   */
  public abstract void doFind() throws Exception;

  /**
   * �u�o�^�����v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   * @return boolean
   */
  public abstract boolean doInsert() throws Exception;

  /**
   * �u�X�V�����v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   * @return boolean
   */
  public abstract boolean doUpdate() throws Exception;

  /**
   * �u�T�ԕ\�\���v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   *
   */
  public abstract void showWeekly() throws Exception;

  /**
   * �u���ԕ\�\���v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   *
   */
  public abstract void showMonthly() throws Exception;

  /**
   * �u�T�[�r�X�p�^�[���I��/���I���`�F�b�N�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   *
   */
  public abstract void checkServicePatternSelected() throws Exception;

  /**
   * �u�ڍד��eD&D�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   *
   */
  public abstract void pictureDragAndDrop() throws Exception;

  /**
   * �u�\��f�[�^�Ǎ��v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   *
   */
  public abstract void doOpenResult() throws Exception;

  /**
   * �u�T�[�r�X�N���X�̐����v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @param targetDate Date
   * @throws Exception ������O
   * @return ACPanel
   */
  public abstract ACPanel createServicePatternClass(Date targetDate) throws Exception;

  /**
   * �u�T�[�r�X�p�l���̃f�[�^�擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   * @return VRMap
   */
  public abstract VRMap createServiceData() throws Exception;

  /**
   * �u�������[�h�̊m�F�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   *
   */
  public abstract void checkProcessMode() throws Exception;

  /**
   * �u����/�T�ԃT�[�r�X���X�g�I��ύX�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @param e ListSelectionEvent
   * @throws Exception ������O
   *
   */
  public abstract void serviceListSelectionChanged(ListSelectionEvent e) throws Exception;

  /**
   * �u����/�T�ԃT�[�r�X���X�g�L�[�����v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @param e KeyEvent
   * @throws Exception ������O
   *
   */
  public abstract void serviceListKeyDown(KeyEvent e) throws Exception;

  /**
   * �u�I���T�[�r�X�̍폜�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   *
   */
  public abstract void removeSelectedService() throws Exception;

  /**
   * �u�T�[�r�X�p�^�[���̒ǉ��폜�����s�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   *
   */
  public abstract void saveServicePattern() throws Exception;

  /**
   * �u�T�[�r�X��ނ̑I��ݒ�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   *
   */
  public abstract void refleshServiceKind() throws Exception;

  /**
   * �u�T�[�r�X���I����Ԑݒ�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   *
   */
  public abstract void clearServiceSelection() throws Exception;

  /**
   * �u�ŐV�T�ԗ\��ǂݍ��݁v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   *
   */
  public abstract void doOpenPlan() throws Exception;

  /**
   * �u�f�[�^�X�V�����v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @param isInsert boolean
   * @throws Exception ������O
   * @return boolean
   */
  public abstract boolean doUpdateImpl(boolean isInsert) throws Exception;

  /**
   * �u�f�[�^�����݂��Ă��邩�`�F�b�N���܂��v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @param bindPaths String[]
   * @param service VRMap
   * @throws Exception ������O
   * @return boolean
   */
  public abstract boolean checkValidSysteBindPath(String[] bindPaths, VRMap service) throws Exception;

}
