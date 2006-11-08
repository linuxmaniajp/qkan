
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
 * �J����: ����@��F
 * �쐬��: 2006/01/16  ���{�R���s���[�^�[������� ����@��F �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���[�Ǘ� (C)
 * �v���Z�X �K��Ō�L�^���T (004)
 * �v���O���� �K��Ō�L�^���T (QC004)
 *
 *****************************************************************
 */

package jp.or.med.orca.qkan.affair.qc.qc004;

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

/**
 * �K��Ō�L�^���T�C�x���g��`(QC004) 
 */
public abstract class QC004Event extends QC004SQL {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QC004Event(){
    addEvents();
  }
  /**
   * �C�x���g�����������`���܂��B
   */
  protected void addEvents() {
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
    getSyujiMedicalName().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                syujiMedicalNameActionPerformed(e);
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
   * �u�Ǎ��ݏ����v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void openActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u��������v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void printActionPerformed(ActionEvent e) throws Exception;

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
   * �u��ʏ����v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void syujiMedicalNameActionPerformed(ActionEvent e) throws Exception;

  //�ϐ���`

  private ACPassiveKey PASSIVE_CHECK_KEY_KIROKUSHO;
  private int patientId;
  private int processMode;
  private Date targetDate;
  private VRMap patientMap = new VRHashMap();
  private VRMap stationMap = new VRHashMap();
  private VRMap providerMap = new VRHashMap();
  private VRMap kirokushoMap = new VRHashMap();
  private VRMap affairMap = new VRHashMap();
  private VRList providerList = new VRArrayList();
  private VRList kirokushoList = new VRArrayList();
  //getter/setter

  /**
   * PASSIVE_CHECK_KEY_KIROKUSHO��Ԃ��܂��B
   * @return PASSIVE_CHECK_KEY_KIROKUSHO
   */
  protected ACPassiveKey getPASSIVE_CHECK_KEY_KIROKUSHO(){
    return PASSIVE_CHECK_KEY_KIROKUSHO;
  }
  /**
   * PASSIVE_CHECK_KEY_KIROKUSHO��ݒ肵�܂��B
   * @param PASSIVE_CHECK_KEY_KIROKUSHO PASSIVE_CHECK_KEY_KIROKUSHO
   */
  protected void setPASSIVE_CHECK_KEY_KIROKUSHO(ACPassiveKey PASSIVE_CHECK_KEY_KIROKUSHO){
    this.PASSIVE_CHECK_KEY_KIROKUSHO = PASSIVE_CHECK_KEY_KIROKUSHO;
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
   * patientMap��Ԃ��܂��B
   * @return patientMap
   */
  protected VRMap getPatientMap(){
    return patientMap;
  }
  /**
   * patientMap��ݒ肵�܂��B
   * @param patientMap patientMap
   */
  protected void setPatientMap(VRMap patientMap){
    this.patientMap = patientMap;
  }

  /**
   * stationMap��Ԃ��܂��B
   * @return stationMap
   */
  protected VRMap getStationMap(){
    return stationMap;
  }
  /**
   * stationMap��ݒ肵�܂��B
   * @param stationMap stationMap
   */
  protected void setStationMap(VRMap stationMap){
    this.stationMap = stationMap;
  }

  /**
   * providerMap��Ԃ��܂��B
   * @return providerMap
   */
  protected VRMap getProviderMap(){
    return providerMap;
  }
  /**
   * providerMap��ݒ肵�܂��B
   * @param providerMap providerMap
   */
  protected void setProviderMap(VRMap providerMap){
    this.providerMap = providerMap;
  }

  /**
   * kirokushoMap��Ԃ��܂��B
   * @return kirokushoMap
   */
  protected VRMap getKirokushoMap(){
    return kirokushoMap;
  }
  /**
   * kirokushoMap��ݒ肵�܂��B
   * @param kirokushoMap kirokushoMap
   */
  protected void setKirokushoMap(VRMap kirokushoMap){
    this.kirokushoMap = kirokushoMap;
  }

  /**
   * affairMap��Ԃ��܂��B
   * @return affairMap
   */
  protected VRMap getAffairMap(){
    return affairMap;
  }
  /**
   * affairMap��ݒ肵�܂��B
   * @param affairMap affairMap
   */
  protected void setAffairMap(VRMap affairMap){
    this.affairMap = affairMap;
  }

  /**
   * providerList��Ԃ��܂��B
   * @return providerList
   */
  protected VRList getProviderList(){
    return providerList;
  }
  /**
   * providerList��ݒ肵�܂��B
   * @param providerList providerList
   */
  protected void setProviderList(VRList providerList){
    this.providerList = providerList;
  }

  /**
   * kirokushoList��Ԃ��܂��B
   * @return kirokushoList
   */
  protected VRList getKirokushoList(){
    return kirokushoList;
  }
  /**
   * kirokushoList��ݒ肵�܂��B
   * @param kirokushoList kirokushoList
   */
  protected void setKirokushoList(VRList kirokushoList){
    this.kirokushoList = kirokushoList;
  }

  //�����֐�

  /**
   * �u�p�b�V�u�`�F�b�N�p�f�[�^�o�^�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   *
   */
  public abstract void doFindPassive() throws Exception;

  /**
   * �u�ۑ������v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   *
   */
  public abstract boolean doSave() throws Exception;

  /**
   * �u�o�^�������s���v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   *
   */
  public abstract boolean doInsert() throws Exception;

  /**
   * �u�X�V�������s���v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   *
   */
  public abstract boolean doUpdate() throws Exception;

  /**
   * �u�n���p�����[�^�[�쐬�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   *
   */
  public abstract void setParameter(VRMap parameters) throws Exception;

  /**
   * �u�K��J�n���ԁE�K��I�����ԓ��̓`�F�b�N�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   * @return boolean
   */
  public abstract boolean doCheck() throws Exception;

  /**
   * �u�K��J�n���ԓ��̓`�F�b�N�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   * @return boolean
   */
  public abstract boolean doCheckStartTime() throws Exception;

  /**
   * �u�K��I�����ԓ��̓`�F�b�N�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   * @return boolean
   */
  public abstract boolean doCheckEndTime() throws Exception;

  /**
   * �u��Ë@�֏��R���{�Z�b�g�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   *
   */
  public abstract void getMedicalFacilityInfo() throws Exception;

}
