
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
 * �쐬��: 2007/02/27  ���{�R���s���[�^�[������� ��i�@�a�P �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �����f�[�^�쐬 (P)
 * �v���Z�X �m�F�E�C�� (003)
 * �v���O���� ���p�Ҍ��������ڍוҏW (QP003)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qp.qp003;
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
 * ���p�Ҍ��������ڍוҏW�C�x���g��`(QP003) 
 */
public abstract class QP003Event extends QP003SQL {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QP003Event(){
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
    getOpen().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                openActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getContentJikohutanUse1().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                contentJikohutanUse1FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getContentJikohutanUse2().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                contentJikohutanUse2FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getContentJikohutanUse3().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                contentJikohutanUse3FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getContentEtcUse1().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                contentEtcUse1FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getContentEtcUse2().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                contentEtcUse2FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getContentEtcUse3().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                contentEtcUse3FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getContentEtcUse4().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                contentEtcUse4FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getContentEtcUse5().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                contentEtcUse5FocusLost(e);
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
   * �uDB�o�^�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void updateActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u���߂̖K��Ō�v�揑���̓Ǎ��v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void openActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u���v���z�̌v�Z�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void contentJikohutanUse1FocusLost(FocusEvent e) throws Exception;

  /**
   * �u���v���z�̌v�Z�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void contentJikohutanUse2FocusLost(FocusEvent e) throws Exception;

  /**
   * �u���v���z�̌v�Z�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void contentJikohutanUse3FocusLost(FocusEvent e) throws Exception;

  /**
   * �u���v���z�̌v�Z�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void contentEtcUse1FocusLost(FocusEvent e) throws Exception;

  /**
   * �u���v���z�̌v�Z�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void contentEtcUse2FocusLost(FocusEvent e) throws Exception;

  /**
   * �u���v���z�̌v�Z�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void contentEtcUse3FocusLost(FocusEvent e) throws Exception;

  /**
   * �u���v���z�̌v�Z�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void contentEtcUse4FocusLost(FocusEvent e) throws Exception;

  /**
   * �u���v���z�̌v�Z�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void contentEtcUse5FocusLost(FocusEvent e) throws Exception;

  //�ϐ���`

  private ACPassiveKey PASSIVE_CHECK_KEY;
  public static final int STYLE_TYPE_CLAIM_FOR_PATIENT = 30101;
  public static final int CATEGORY_NO_CLAIM_FOR_PATIENT = 16;
  public static final Date DATE_20070401 = ACCastUtilities.toDate("2007/04/01", null);
  private int patientId;
  private int listIndex;
  private int sum;
  private int claimId;
  private int dataFlg;
  private int processMode;
  private String providerId;
  private String insurerId;
  private String insuredId;
  private Date targetDate;
  private Date claimDate;
  private VRList claimList = new VRArrayList();
  private VRList comboSet1 = new VRArrayList();
  private VRList comboSet2 = new VRArrayList();
  private VRMap modelMap = new VRHashMap();
  private VRMap sourceMap = new VRHashMap();
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
   * listIndex��Ԃ��܂��B
   * @return listIndex
   */
  protected int getListIndex(){
    return listIndex;
  }
  /**
   * listIndex��ݒ肵�܂��B
   * @param listIndex listIndex
   */
  protected void setListIndex(int listIndex){
    this.listIndex = listIndex;
  }

  /**
   * sum��Ԃ��܂��B
   * @return sum
   */
  protected int getSum(){
    return sum;
  }
  /**
   * sum��ݒ肵�܂��B
   * @param sum sum
   */
  protected void setSum(int sum){
    this.sum = sum;
  }

  /**
   * claimId��Ԃ��܂��B
   * @return claimId
   */
  protected int getClaimId(){
    return claimId;
  }
  /**
   * claimId��ݒ肵�܂��B
   * @param claimId claimId
   */
  protected void setClaimId(int claimId){
    this.claimId = claimId;
  }

  /**
   * dataFlg��Ԃ��܂��B
   * @return dataFlg
   */
  protected int getDataFlg(){
    return dataFlg;
  }
  /**
   * dataFlg��ݒ肵�܂��B
   * @param dataFlg dataFlg
   */
  protected void setDataFlg(int dataFlg){
    this.dataFlg = dataFlg;
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
   * providerId��Ԃ��܂��B
   * @return providerId
   */
  protected String getProviderId(){
    return providerId;
  }
  /**
   * providerId��ݒ肵�܂��B
   * @param providerId providerId
   */
  protected void setProviderId(String providerId){
    this.providerId = providerId;
  }

  /**
   * insurerId��Ԃ��܂��B
   * @return insurerId
   */
  protected String getInsurerId(){
    return insurerId;
  }
  /**
   * insurerId��ݒ肵�܂��B
   * @param insurerId insurerId
   */
  protected void setInsurerId(String insurerId){
    this.insurerId = insurerId;
  }

  /**
   * insuredId��Ԃ��܂��B
   * @return insuredId
   */
  protected String getInsuredId(){
    return insuredId;
  }
  /**
   * insuredId��ݒ肵�܂��B
   * @param insuredId insuredId
   */
  protected void setInsuredId(String insuredId){
    this.insuredId = insuredId;
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
   * claimDate��Ԃ��܂��B
   * @return claimDate
   */
  protected Date getClaimDate(){
    return claimDate;
  }
  /**
   * claimDate��ݒ肵�܂��B
   * @param claimDate claimDate
   */
  protected void setClaimDate(Date claimDate){
    this.claimDate = claimDate;
  }

  /**
   * claimList��Ԃ��܂��B
   * @return claimList
   */
  protected VRList getClaimList(){
    return claimList;
  }
  /**
   * claimList��ݒ肵�܂��B
   * @param claimList claimList
   */
  protected void setClaimList(VRList claimList){
    this.claimList = claimList;
  }

  /**
   * comboSet1��Ԃ��܂��B
   * @return comboSet1
   */
  protected VRList getComboSet1(){
    return comboSet1;
  }
  /**
   * comboSet1��ݒ肵�܂��B
   * @param comboSet1 comboSet1
   */
  protected void setComboSet1(VRList comboSet1){
    this.comboSet1 = comboSet1;
  }

  /**
   * comboSet2��Ԃ��܂��B
   * @return comboSet2
   */
  protected VRList getComboSet2(){
    return comboSet2;
  }
  /**
   * comboSet2��ݒ肵�܂��B
   * @param comboSet2 comboSet2
   */
  protected void setComboSet2(VRList comboSet2){
    this.comboSet2 = comboSet2;
  }

  /**
   * modelMap��Ԃ��܂��B
   * @return modelMap
   */
  protected VRMap getModelMap(){
    return modelMap;
  }
  /**
   * modelMap��ݒ肵�܂��B
   * @param modelMap modelMap
   */
  protected void setModelMap(VRMap modelMap){
    this.modelMap = modelMap;
  }

  /**
   * sourceMap��Ԃ��܂��B
   * @return sourceMap
   */
  protected VRMap getSourceMap(){
    return sourceMap;
  }
  /**
   * sourceMap��ݒ肵�܂��B
   * @param sourceMap sourceMap
   */
  protected void setSourceMap(VRMap sourceMap){
    this.sourceMap = sourceMap;
  }

  //�����֐�

  /**
   * �u�f�[�^�擾�A��ʓW�J�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   *
   */
  public abstract void doFind() throws Exception;

  /**
   * �u���p�Ҍ��������ڍ׏����擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   *
   */
  public abstract void doFindClaimForPatient() throws Exception;

  /**
   * �u���v���z�̌v�Z�����v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   *
   */
  public abstract void calcSum() throws Exception;

  /**
   * �u�ۑ������v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   * @return boolean
   */
  public abstract boolean doSave() throws Exception;

  /**
   * �u��ʃf�[�^�`�F�b�N�E�ҏW�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   *
   */
  public abstract void doCheckInput() throws Exception;

  /**
   * �u���̓f�[�^�̒l���`�F�b�N����B�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @param himokuCombo ACComboBox
   * @param jikohutanText ACTextField
   * @throws Exception ������O
   *
   */
  public abstract void checkValue(ACComboBox himokuCombo, ACTextField jikohutanText) throws Exception;

  /**
   * �u�R���{����ݒ肷��B�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   *
   */
  public abstract void comboInitialize() throws Exception;

}
