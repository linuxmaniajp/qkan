
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
 * �쐬��: 2009/07/09  ���{�R���s���[�^�[������� ����@��F �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���̑��@�\ (O)
 * �v���Z�X �ی��ҊǗ� (002)
 * �v���O���� �ی��ғo�^ (QO002)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qo.qo002;
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
 * �ی��ғo�^�C�x���g��`(QO002) 
 */
public abstract class QO002Event extends QO002SQL {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QO002Event(){
    addEvents();
  }
  /**
   * �C�x���g�����������`���܂��B
   */
  protected void addEvents() {
    getInsurerSelectButton().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                insurerSelectButtonActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getInsurerLimitRateEnableCheck().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                insurerLimitRateEnableCheckActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getInsurerLimitRateTable().addListSelectionListener(new ListSelectionListener(){
        private boolean lockFlag = false;
        public void valueChanged(ListSelectionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                insurerLimitRateTableSelectionChanged(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getInsurerLimitRateInsertButton().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                insurerLimitRateInsertButtonActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getInsurerLimitRateEditButton().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                insurerLimitRateEditButtonActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getInsurerLimitRateDeleteButton().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                insurerLimitRateDeleteButtonActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getInsurerLimitRateRegularButton().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                insurerLimitRateRegularButtonActionPerformed(e);
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
    getNewData().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                newDataActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getClear().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                clearActionPerformed(e);
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
   * �u�ی��ґI���{�^���������v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void insurerSelectButtonActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u�敪�x�����x�z���p�l���𐧌䂷��v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void insurerLimitRateEnableCheckActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u�Ώۃ��R�[�h��\���v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void insurerLimitRateTableSelectionChanged(ListSelectionEvent e) throws Exception;

  /**
   * �u�ǉ������v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void insurerLimitRateInsertButtonActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u�ҏW�����v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void insurerLimitRateEditButtonActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u�폜�����v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void insurerLimitRateDeleteButtonActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u��x�����x�z��\�����鏈���v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void insurerLimitRateRegularButtonActionPerformed(ActionEvent e) throws Exception;

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
   * �u�V�K�o�^���[�h�ύX�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void newDataActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u��ʏ��̃N���A�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void clearActionPerformed(ActionEvent e) throws Exception;

  //�ϐ���`

  private ACPassiveKey INSURER_INFO_PASSIVE_CHECK_KEY;
  private String PROCESS_MODE;
  private String insurereId;
  private String affairMap;
  private int insurerLimitRateTableChangeFlg = 0;
  private VRMap insurerInfoMap = new VRHashMap();
  private VRMap insurerLimitRateMap = new VRHashMap();
  private VRList insurerInfoList = new VRArrayList();
  private VRList insurerLimitRateList = new VRArrayList();
  private VRList insurerLimitRateListSource = new VRArrayList();
  private ACTableModelAdapter insurerLimitRateTableModel;
  private ACSnapshot snapShotPeriod = new ACSnapshot();
  private ACDBManager masterInsurerDBManager;
  private QO002_InsurerRelation QO002_InsurerRelation;
  //getter/setter

  /**
   * INSURER_INFO_PASSIVE_CHECK_KEY��Ԃ��܂��B
   * @return INSURER_INFO_PASSIVE_CHECK_KEY
   */
  protected ACPassiveKey getINSURER_INFO_PASSIVE_CHECK_KEY(){
    return INSURER_INFO_PASSIVE_CHECK_KEY;
  }
  /**
   * INSURER_INFO_PASSIVE_CHECK_KEY��ݒ肵�܂��B
   * @param INSURER_INFO_PASSIVE_CHECK_KEY INSURER_INFO_PASSIVE_CHECK_KEY
   */
  protected void setINSURER_INFO_PASSIVE_CHECK_KEY(ACPassiveKey INSURER_INFO_PASSIVE_CHECK_KEY){
    this.INSURER_INFO_PASSIVE_CHECK_KEY = INSURER_INFO_PASSIVE_CHECK_KEY;
  }

  /**
   * PROCESS_MODE��Ԃ��܂��B
   * @return PROCESS_MODE
   */
  protected String getPROCESS_MODE(){
    return PROCESS_MODE;
  }
  /**
   * PROCESS_MODE��ݒ肵�܂��B
   * @param PROCESS_MODE PROCESS_MODE
   */
  protected void setPROCESS_MODE(String PROCESS_MODE){
    this.PROCESS_MODE = PROCESS_MODE;
  }

  /**
   * insurereId��Ԃ��܂��B
   * @return insurereId
   */
  protected String getInsurereId(){
    return insurereId;
  }
  /**
   * insurereId��ݒ肵�܂��B
   * @param insurereId insurereId
   */
  protected void setInsurereId(String insurereId){
    this.insurereId = insurereId;
  }

  /**
   * affairMap��Ԃ��܂��B
   * @return affairMap
   */
  protected String getAffairMap(){
    return affairMap;
  }
  /**
   * affairMap��ݒ肵�܂��B
   * @param affairMap affairMap
   */
  protected void setAffairMap(String affairMap){
    this.affairMap = affairMap;
  }

  /**
   * insurerLimitRateTableChangeFlg��Ԃ��܂��B
   * @return insurerLimitRateTableChangeFlg
   */
  protected int getInsurerLimitRateTableChangeFlg(){
    return insurerLimitRateTableChangeFlg;
  }
  /**
   * insurerLimitRateTableChangeFlg��ݒ肵�܂��B
   * @param insurerLimitRateTableChangeFlg insurerLimitRateTableChangeFlg
   */
  protected void setInsurerLimitRateTableChangeFlg(int insurerLimitRateTableChangeFlg){
    this.insurerLimitRateTableChangeFlg = insurerLimitRateTableChangeFlg;
  }

  /**
   * insurerInfoMap��Ԃ��܂��B
   * @return insurerInfoMap
   */
  protected VRMap getInsurerInfoMap(){
    return insurerInfoMap;
  }
  /**
   * insurerInfoMap��ݒ肵�܂��B
   * @param insurerInfoMap insurerInfoMap
   */
  protected void setInsurerInfoMap(VRMap insurerInfoMap){
    this.insurerInfoMap = insurerInfoMap;
  }

  /**
   * insurerLimitRateMap��Ԃ��܂��B
   * @return insurerLimitRateMap
   */
  protected VRMap getInsurerLimitRateMap(){
    return insurerLimitRateMap;
  }
  /**
   * insurerLimitRateMap��ݒ肵�܂��B
   * @param insurerLimitRateMap insurerLimitRateMap
   */
  protected void setInsurerLimitRateMap(VRMap insurerLimitRateMap){
    this.insurerLimitRateMap = insurerLimitRateMap;
  }

  /**
   * insurerInfoList��Ԃ��܂��B
   * @return insurerInfoList
   */
  protected VRList getInsurerInfoList(){
    return insurerInfoList;
  }
  /**
   * insurerInfoList��ݒ肵�܂��B
   * @param insurerInfoList insurerInfoList
   */
  protected void setInsurerInfoList(VRList insurerInfoList){
    this.insurerInfoList = insurerInfoList;
  }

  /**
   * insurerLimitRateList��Ԃ��܂��B
   * @return insurerLimitRateList
   */
  protected VRList getInsurerLimitRateList(){
    return insurerLimitRateList;
  }
  /**
   * insurerLimitRateList��ݒ肵�܂��B
   * @param insurerLimitRateList insurerLimitRateList
   */
  protected void setInsurerLimitRateList(VRList insurerLimitRateList){
    this.insurerLimitRateList = insurerLimitRateList;
  }

  /**
   * insurerLimitRateListSource��Ԃ��܂��B
   * @return insurerLimitRateListSource
   */
  protected VRList getInsurerLimitRateListSource(){
    return insurerLimitRateListSource;
  }
  /**
   * insurerLimitRateListSource��ݒ肵�܂��B
   * @param insurerLimitRateListSource insurerLimitRateListSource
   */
  protected void setInsurerLimitRateListSource(VRList insurerLimitRateListSource){
    this.insurerLimitRateListSource = insurerLimitRateListSource;
  }

  /**
   * insurerLimitRateTableModel��Ԃ��܂��B
   * @return insurerLimitRateTableModel
   */
  protected ACTableModelAdapter getInsurerLimitRateTableModel(){
    return insurerLimitRateTableModel;
  }
  /**
   * insurerLimitRateTableModel��ݒ肵�܂��B
   * @param insurerLimitRateTableModel insurerLimitRateTableModel
   */
  protected void setInsurerLimitRateTableModel(ACTableModelAdapter insurerLimitRateTableModel){
    this.insurerLimitRateTableModel = insurerLimitRateTableModel;
  }

  /**
   * snapShotPeriod��Ԃ��܂��B
   * @return snapShotPeriod
   */
  protected ACSnapshot getSnapShotPeriod(){
    return snapShotPeriod;
  }
  /**
   * snapShotPeriod��ݒ肵�܂��B
   * @param snapShotPeriod snapShotPeriod
   */
  protected void setSnapShotPeriod(ACSnapshot snapShotPeriod){
    this.snapShotPeriod = snapShotPeriod;
  }

  /**
   * masterInsurerDBManager��Ԃ��܂��B
   * @return masterInsurerDBManager
   */
  protected ACDBManager getMasterInsurerDBManager(){
    return masterInsurerDBManager;
  }
  /**
   * masterInsurerDBManager��ݒ肵�܂��B
   * @param masterInsurerDBManager masterInsurerDBManager
   */
  protected void setMasterInsurerDBManager(ACDBManager masterInsurerDBManager){
    this.masterInsurerDBManager = masterInsurerDBManager;
  }

  /**
   * QO002_InsurerRelation��Ԃ��܂��B
   * @return QO002_InsurerRelation
   */
  protected QO002_InsurerRelation getQO002_InsurerRelation(){
    return QO002_InsurerRelation;
  }
  /**
   * QO002_InsurerRelation��ݒ肵�܂��B
   * @param QO002_InsurerRelation QO002_InsurerRelation
   */
  protected void setQO002_InsurerRelation(QO002_InsurerRelation QO002_InsurerRelation){
    this.QO002_InsurerRelation = QO002_InsurerRelation;
  }

  //�����֐�

  /**
   * �u���R�[�h���擾����ʂɐݒ肷��B�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   *
   */
  public abstract void doFind() throws Exception;

  /**
   * �u�ی��ҏ��擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   *
   */
  public abstract void doFindInsurerInfo() throws Exception;

  /**
   * �u�x�����x�z���擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   *
   */
  public abstract void doFindInsurerLimitRate() throws Exception;

  /**
   * �u�ۑ������v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   * @return boolean
   */
  public abstract boolean doSave() throws Exception;

  /**
   * �u�x�����x�z���o�^�����v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   *
   */
  public abstract void doSaveLimitRate() throws Exception;

  /**
   * �u�n���p�����[�^�[��ݒ肷��B�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   *
   */
  public abstract void setParameter() throws Exception;

  /**
   * �u�ی��ґS�����̓`�F�b�N�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   * @return boolean
   */
  public abstract boolean doValidCheck() throws Exception;

  /**
   * �u�ی��Ҋ�{�����̓`�F�b�N�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   * @return boolean
   */
  public abstract boolean doValidInsurerInfoCheck() throws Exception;

  /**
   * �u�x�����x�z���`�F�b�N�����v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   * @return boolean
   */
  public abstract boolean doValidLimitRateCheck() throws Exception;

  /**
   * �u�V�K�o�^���[�h�ɕύX���鏈���v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   *
   */
  public abstract void insertModeChange() throws Exception;

  /**
   * �u��ʂ��N���A���鏈���v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   *
   */
  public abstract void allClear() throws Exception;

  /**
   * �u�X�i�b�v�V���b�g���B�e���鏈���v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   *
   */
  public abstract void snapshotCustom() throws Exception;

  /**
   * �u�K��x�����x�z���擾���鏈���v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   * @return VRMap
   */
  public abstract VRMap doFindRegularLImitRate() throws Exception;

}
