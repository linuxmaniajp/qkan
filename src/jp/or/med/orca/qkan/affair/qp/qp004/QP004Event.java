
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
 * �쐬��: 2006/03/14  ���{�R���s���[�^�[������� ��i�@�a�P �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �����f�[�^�쐬 (P)
 * �v���Z�X �m�F�E�C�� (004)
 * �v���O���� ���׏���{���ҏW (QP004)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qp.qp004;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import jp.nichicom.ac.ACCommon;
import jp.nichicom.ac.sql.ACPassiveKey;
import jp.nichicom.ac.util.adapter.ACTableModelAdapter;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.component.QkanDateTextField;

/**
 * ���׏���{���ҏW�C�x���g��`(QP004) 
 */
public abstract class QP004Event extends QP004SQL {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QP004Event(){
    addEvents();
  }
  /**
   * �C�x���g�����������`���܂��B
   */
  protected void addEvents() {
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
    getTekiyoTable().addListSelectionListener(new ListSelectionListener(){
        private boolean lockFlag = false;
        public void valueChanged(ListSelectionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                tekiyoTableSelectionChanged(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getSinryoTable().addListSelectionListener(new ListSelectionListener(){
        private boolean lockFlag = false;
        public void valueChanged(ListSelectionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                sinryoTableSelectionChanged(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getTekiyoTekiyoColumn().addCellEditorListener(new CellEditorListener(){
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
                tekiyoTekiyoColumnCellEditing(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getSinryoTekiyoColumn().addCellEditorListener(new CellEditorListener(){
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
                sinryoTekiyoColumnCellEditing(e);
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
  protected abstract void updateActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u�ڍׁv�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void detailActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u�E�v��������\���v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void tekiyoTableSelectionChanged(ListSelectionEvent e) throws Exception;

  /**
   * �u�E�v��������\���v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void sinryoTableSelectionChanged(ListSelectionEvent e) throws Exception;

  /**
   * �u�ύX�t���O�𗧂Ă�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void tekiyoTekiyoColumnCellEditing(ChangeEvent e) throws Exception;

  /**
   * �u�ύX�t���O�𗧂Ă�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void sinryoTekiyoColumnCellEditing(ChangeEvent e) throws Exception;

  //�ϐ���`

  private ACPassiveKey PASSIVE_CHECK_KEY;
  public static final int FLAG_ON = 1;
  public static final int FLAG_OFF = 0;
  public static final Integer FLAG_START = new Integer(1);
  public static final Integer FLAG_END = new Integer(99);
  public static final int TEXT = 1;
  public static final int COMBO = 2;
  
   // ���[�l��
  
  
  public static final int CLAIM_STYLE_TYPE21 = 10211;
  public static final int CLAIM_STYLE_TYPE22	= 10212;
  public static final int CLAIM_STYLE_TYPE23	= 10213;	// 2016.7.8 add
  public static final int CLAIM_STYLE_TYPE31	= 10311;
  public static final int CLAIM_STYLE_TYPE32	= 10312;
  public static final int CLAIM_STYLE_TYPE41	= 10411;
  public static final int CLAIM_STYLE_TYPE42	= 10412;
  public static final int CLAIM_STYLE_TYPE51	= 10511;
  public static final int CLAIM_STYLE_TYPE52	= 10512;
  public static final int CLAIM_STYLE_TYPE61	= 10611;
  public static final int CLAIM_STYLE_TYPE62	= 10612;
  public static final int CLAIM_STYLE_TYPE63	= 10613;
  public static final int CLAIM_STYLE_TYPE64	= 10614;
  public static final int CLAIM_STYLE_TYPE65	= 10615;
  public static final int CLAIM_STYLE_TYPE66	= 10616;
  public static final int CLAIM_STYLE_TYPE67    = 10617;
  public static final int CLAIM_STYLE_TYPE8	= 10811;
  public static final int CLAIM_STYLE_TYPE9	= 10911;
  public static final int CLAIM_STYLE_TYPE10	= 11011;

  public static final int CATEGORY_NO2 = 2;
  public static final int CATEGORY_NO3 = 3;
  public static final int CATEGORY_NO5 = 5;
  public static final int CATEGORY_NO7 = 7;
  public static final int CATEGORY_NO18 = 18;
  
  // �V�X�e���T�[�r�X��ރR�[�h(5��)
  public static final String SYSTEM_SERVICE_KIND_CODE = "301021"; 
  public static final String SYSTEM_SERVICE_ITEM_CODE = "301022"; 
  public static final String SPECIAL_CLINIC_FLAG_CODE = "501009";
  public static final String TEKIYOU100_FLAG_CODE = "501023";
  
  public static final int HEAVY_RECUPERATION_MANAGEMENT = 35;
  private int patientId;
  private Date targetDate = new Date();
  private Date claimDate = new Date();
  private int listIndex;
  private String providerId;
  private int claimStyleType;
  private String insuredId;
  private int tableChangedFlg;
  public static final String FIRST_SUMMARY_MEMO = "���̃T�[�r�X��I�ԂƁA�E�v���ɋL�ڂ�����e�ɂ��Ă̐������\������܂��B";
  private VRMap masterCodeData = new VRHashMap();
  private VRList claimListBasic = new VRArrayList();
  private VRList claimListDetail = new VRArrayList();
  private VRList claimListHideDetail = new VRArrayList();
  private VRList claimListSpecialClinic = new VRArrayList();
  private VRList claimListTotal = new VRArrayList();
  private VRList columnListDetail = new VRArrayList();
  private VRList columnListSpecialClinic = new VRArrayList();
  private VRList snapList = new VRArrayList();
  private ACTableModelAdapter tableModelDetail;
  private ACTableModelAdapter tableModelSpecialClinic;
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
   * claimStyleType��Ԃ��܂��B
   * @return claimStyleType
   */
  protected int getClaimStyleType(){
    return claimStyleType;
  }
  /**
   * claimStyleType��ݒ肵�܂��B
   * @param claimStyleType claimStyleType
   */
  protected void setClaimStyleType(int claimStyleType){
    this.claimStyleType = claimStyleType;
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
   * tableChangedFlg��Ԃ��܂��B
   * @return tableChangedFlg
   */
  protected int getTableChangedFlg(){
    return tableChangedFlg;
  }
  /**
   * tableChangedFlg��ݒ肵�܂��B
   * @param tableChangedFlg tableChangedFlg
   */
  protected void setTableChangedFlg(int tableChangedFlg){
    this.tableChangedFlg = tableChangedFlg;
  }

  /**
   * masterCodeData��Ԃ��܂��B
   * @return masterCodeData
   */
  protected VRMap getMasterCodeData(){
    return masterCodeData;
  }
  /**
   * masterCodeData��ݒ肵�܂��B
   * @param masterCodeData masterCodeData
   */
  protected void setMasterCodeData(VRMap masterCodeData){
    this.masterCodeData = masterCodeData;
  }

  /**
   * claimListBasic��Ԃ��܂��B
   * @return claimListBasic
   */
  protected VRList getClaimListBasic(){
    return claimListBasic;
  }
  /**
   * claimListBasic��ݒ肵�܂��B
   * @param claimListBasic claimListBasic
   */
  protected void setClaimListBasic(VRList claimListBasic){
    this.claimListBasic = claimListBasic;
  }

  /**
   * claimListDetail��Ԃ��܂��B
   * @return claimListDetail
   */
  protected VRList getClaimListDetail(){
    return claimListDetail;
  }
  /**
   * claimListDetail��ݒ肵�܂��B
   * @param claimListDetail claimListDetail
   */
  protected void setClaimListDetail(VRList claimListDetail){
    this.claimListDetail = claimListDetail;
  }

  /**
   * claimListHideDetail��Ԃ��܂��B
   * @return claimListHideDetail
   */
  protected VRList getClaimListHideDetail(){
    return claimListHideDetail;
  }
  /**
   * claimListHideDetail��ݒ肵�܂��B
   * @param claimListHideDetail claimListHideDetail
   */
  protected void setClaimListHideDetail(VRList claimListHideDetail){
    this.claimListHideDetail = claimListHideDetail;
  }

  /**
   * claimListSpecialClinic��Ԃ��܂��B
   * @return claimListSpecialClinic
   */
  protected VRList getClaimListSpecialClinic(){
    return claimListSpecialClinic;
  }
  /**
   * claimListSpecialClinic��ݒ肵�܂��B
   * @param claimListSpecialClinic claimListSpecialClinic
   */
  protected void setClaimListSpecialClinic(VRList claimListSpecialClinic){
    this.claimListSpecialClinic = claimListSpecialClinic;
  }

  /**
   * claimListTotal��Ԃ��܂��B
   * @return claimListTotal
   */
  protected VRList getClaimListTotal(){
    return claimListTotal;
  }
  /**
   * claimListTotal��ݒ肵�܂��B
   * @param claimListTotal claimListTotal
   */
  protected void setClaimListTotal(VRList claimListTotal){
    this.claimListTotal = claimListTotal;
  }

  /**
   * columnListDetail��Ԃ��܂��B
   * @return columnListDetail
   */
  protected VRList getColumnListDetail(){
    return columnListDetail;
  }
  /**
   * columnListDetail��ݒ肵�܂��B
   * @param columnListDetail columnListDetail
   */
  protected void setColumnListDetail(VRList columnListDetail){
    this.columnListDetail = columnListDetail;
  }

  /**
   * columnListSpecialClinic��Ԃ��܂��B
   * @return columnListSpecialClinic
   */
  protected VRList getColumnListSpecialClinic(){
    return columnListSpecialClinic;
  }
  /**
   * columnListSpecialClinic��ݒ肵�܂��B
   * @param columnListSpecialClinic columnListSpecialClinic
   */
  protected void setColumnListSpecialClinic(VRList columnListSpecialClinic){
    this.columnListSpecialClinic = columnListSpecialClinic;
  }

  /**
   * snapList��Ԃ��܂��B
   * @return snapList
   */
  protected VRList getSnapList(){
    return snapList;
  }
  /**
   * snapList��ݒ肵�܂��B
   * @param snapList snapList
   */
  protected void setSnapList(VRList snapList){
    this.snapList = snapList;
  }
  
  /**
   * tableModelDetail��Ԃ��܂��B
   * @return tableModelDetail
   */
  protected ACTableModelAdapter getTableModelDetail(){
    return tableModelDetail;
  }
  /**
   * tableModelDetail��ݒ肵�܂��B
   * @param tableModelDetail tableModelDetail
   */
  protected void setTableModelDetail(ACTableModelAdapter tableModelDetail){
    this.tableModelDetail = tableModelDetail;
  }

  /**
   * tableModelSpecialClinic��Ԃ��܂��B
   * @return tableModelSpecialClinic
   */
  protected ACTableModelAdapter getTableModelSpecialClinic(){
    return tableModelSpecialClinic;
  }
  /**
   * tableModelSpecialClinic��ݒ肵�܂��B
   * @param tableModelSpecialClinic tableModelSpecialClinic
   */
  protected void setTableModelSpecialClinic(ACTableModelAdapter tableModelSpecialClinic){
    this.tableModelSpecialClinic = tableModelSpecialClinic;
  }

  //�����֐�

  /**
   * �u�f�[�^�̎擾�E��ʐݒ�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   *
   */
  public abstract void doFind() throws Exception;

  /**
   * �u�e���R�[�h�W���̒��o�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @param list VRList
   * @throws Exception ������O
   *
   */
  public abstract void doFindCategory(VRList list) throws Exception;

  /**
   * �u��ʂ̏�Ԑݒ�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   *
   */
  public abstract void doControlState() throws Exception;

  /**
   * �u���̓`�F�b�N�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   *
   */
  public abstract boolean isValidInput() throws Exception;

  /**
   * �u�ۑ������v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   *
   */
  public abstract boolean doSave() throws Exception;

  /**
   * �u��ʕ\���p�Ƀf�[�^�ϊ��v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   * @return VRMap
   */
  public abstract VRMap doChangeTekiyoForDisplay(VRMap claimDataMap) throws Exception;

  /**
   * �uDB�X�V�p�Ƀf�[�^�ϊ��v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   * @return VRMap
   */
  public abstract VRMap doChangeTekiyoForUpdate(VRMap claimDataMap) throws Exception;

  /**
   * �u�E�v���L�ڎ����ꗗ�e�[�u���̊e�s�̐ݒ菈���v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   *
   */
  public abstract void doSetTableRow(VRMap claimDataMap, VRList colomListDetail, int categoryType) throws Exception;

  /**
   * �u�������v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   *
   */
  public abstract void initialize() throws Exception;

	/**
	 * �u�Ó��ȓ��t�̓��̓`�F�b�N�v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
  public abstract boolean checkValidDate(QkanDateTextField dateParam, String errMsg) throws Exception;
  
	/**
	 * �u�������t�̓��̓`�F�b�N�v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public abstract boolean checkFutureDate(QkanDateTextField dateParam, String errMsg) throws Exception; 

	/**
	 * �u���t�̊J�n���ƏI�����̃`�F�b�N�v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public abstract boolean checkRelationDate(QkanDateTextField firstDateParam,
			QkanDateTextField secondDateParam, String errMsg1, String errMsg2, String errMsg3) throws Exception;

}
