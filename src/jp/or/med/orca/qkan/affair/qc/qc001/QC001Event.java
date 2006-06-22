
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
 * �쐬��: 2006/02/02  ���{�R���s���[�^�[������� �� ���� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���[�Ǘ� (C)
 * �v���Z�X �v�揑������ (001)
 * �v���O���� �v�揑������ (QC001)
 *
 *****************************************************************
 */

package jp.or.med.orca.qkan.affair.qc.qc001;

import java.awt.*;
import java.awt.event.*;
import java.awt.im.*;
import java.io.*;
import java.sql.SQLException;
import java.text.*;
import java.util.*;
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
import jp.or.med.orca.qkan.lib.*;

/**
 * �v�揑�����̓C�x���g��`(QC001) 
 */
public abstract class QC001Event extends QC001SQL {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QC001Event(){
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
    getPlanNoteEditButtonAdd().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                planNoteEditButtonAddActionPerformed(e);
            }catch(Exception ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getPlanNoteEditButtonEdit().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                planNoteEditButtonEditActionPerformed(e);
            }catch(Exception ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getPlanNoteEditButtonDelete().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                planNoteEditButtonDeleteActionPerformed(e);
            }catch(Exception ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getPlanNoteEditButtonClear().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                planNoteEditButtonClearActionPerformed(e);
            }catch(Exception ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getPlanNotes().addListSelectionListener(new ListSelectionListener(){
        private boolean lockFlag = false;
        public void valueChanged(ListSelectionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                planNotesSelectionChanged(e);
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
   * �u���߂̖K��Ō�v�揑���̓Ǎ��v�C�x���g�ł��B
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
   * �u���_�E������̒ǉ��v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void planNoteEditButtonAddActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u���_�E������̍X�V�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void planNoteEditButtonEditActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u���_�E������̍폜�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void planNoteEditButtonDeleteActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u���_�E������̃N���A�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void planNoteEditButtonClearActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u�Z���I���C�x���g�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void planNotesSelectionChanged(ListSelectionEvent e) throws Exception;

  //�ϐ���`

  private ACPassiveKey PASSIVE_CHECK_KEY_PLAN;
  private int patientID;
  private int processMode;
  private int noteCount;
  private boolean planNoteChangeFlag;
  private boolean forciblyBackCheckFlag;
  private Date targetDateSource;
  private VRMap planData = new VRHashMap();
  private VRList planNoteData = new VRArrayList();
  private VRList stationList = new VRArrayList();
  //getter/setter

  /**
   * PASSIVE_CHECK_KEY_PLAN��Ԃ��܂��B
   * @return PASSIVE_CHECK_KEY_PLAN
   */
  protected ACPassiveKey getPASSIVE_CHECK_KEY_PLAN(){
    return PASSIVE_CHECK_KEY_PLAN;
  }
  /**
   * PASSIVE_CHECK_KEY_PLAN��ݒ肵�܂��B
   * @param PASSIVE_CHECK_KEY_PLAN PASSIVE_CHECK_KEY_PLAN
   */
  protected void setPASSIVE_CHECK_KEY_PLAN(ACPassiveKey PASSIVE_CHECK_KEY_PLAN){
    this.PASSIVE_CHECK_KEY_PLAN = PASSIVE_CHECK_KEY_PLAN;
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
   * noteCount��Ԃ��܂��B
   * @return noteCount
   */
  protected int getNoteCount(){
    return noteCount;
  }
  /**
   * noteCount��ݒ肵�܂��B
   * @param noteCount noteCount
   */
  protected void setNoteCount(int noteCount){
    this.noteCount = noteCount;
  }

  /**
   * planNoteChangeFlag��Ԃ��܂��B
   * @return planNoteChangeFlag
   */
  protected boolean getPlanNoteChangeFlag(){
    return planNoteChangeFlag;
  }
  /**
   * planNoteChangeFlag��ݒ肵�܂��B
   * @param planNoteChangeFlag planNoteChangeFlag
   */
  protected void setPlanNoteChangeFlag(boolean planNoteChangeFlag){
    this.planNoteChangeFlag = planNoteChangeFlag;
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
   * planData��Ԃ��܂��B
   * @return planData
   */
  protected VRMap getPlanData(){
    return planData;
  }
  /**
   * planData��ݒ肵�܂��B
   * @param planData planData
   */
  protected void setPlanData(VRMap planData){
    this.planData = planData;
  }

  /**
   * planNoteData��Ԃ��܂��B
   * @return planNoteData
   */
  protected VRList getPlanNoteData(){
    return planNoteData;
  }
  /**
   * planNoteData��ݒ肵�܂��B
   * @param planNoteData planNoteData
   */
  protected void setPlanNoteData(VRList planNoteData){
    this.planNoteData = planNoteData;
  }

  /**
   * stationList��Ԃ��܂��B
   * @return stationList
   */
  protected VRList getStationList(){
    return stationList;
  }
  /**
   * stationList��ݒ肵�܂��B
   * @param stationList stationList
   */
  protected void setStationList(VRList stationList){
    this.stationList = stationList;
  }

  //�����֐�

  /**
   * �u�E�B���h�E�^�C�g���̐ݒ�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   *
   */
  public abstract void initialize() throws Exception;

  /**
   * �u�K��Ō�v�揑���̎擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
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
   * �u���̓`�F�b�N(���_�E������)�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   * @return boolean
   */
  public abstract boolean checkNoteValue() throws Exception;

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
   * �u���_�E��������̌����擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   * @return int
   */
  public abstract int getNoteMaxCount() throws Exception;

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

}
