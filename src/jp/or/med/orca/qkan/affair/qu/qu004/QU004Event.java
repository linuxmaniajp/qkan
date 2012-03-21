
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
 * �쐬��: 2011/12/19  ���{�R���s���[�^�[������� ����@��F �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���p�ҊǗ� (U)
 * �v���Z�X ���p�ғo�^ (004)
 * �v���O���� ����E�Е��y����� (QU004)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qu.qu004;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.Date;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import jp.nichicom.ac.ACCommon;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.sql.ACPassiveKey;
import jp.nichicom.ac.util.ACSnapshot;
import jp.nichicom.ac.util.adapter.ACTableModelAdapter;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanConstants;

/**
 * ����E�Е��y�����C�x���g��`(QU004) 
 */
@SuppressWarnings("serial")
public abstract class QU004Event extends QU004SQL {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QU004Event(){
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
    getKaigoInfoButtonClear().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                kaigoInfoButtonClearActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getKaigoInfoButtonInsert().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                kaigoInfoButtonInsertActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getKaigoInfoButtonConpile().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                kaigoInfoButtonConpileActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getKaigoInfoButtonDelete().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                kaigoInfoButtonDeleteActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getKaigoInfoInsurerNo().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                kaigoInfoInsurerNoFocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getKaigoInfoTable().addListSelectionListener(new ListSelectionListener(){
        private boolean lockFlag = false;
        public void valueChanged(ListSelectionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                kaigoInfoTableSelectionChanged(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getKaigoInfoBearName().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                kaigoInfoBearNameActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getKaigoInfoPublicExpense().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                kaigoInfoPublicExpenseActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getShahukuInfoButtonClear().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                shahukuInfoButtonClearActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getShahukuInfoButtonInsert().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                shahukuInfoButtonInsertActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getShahukuInfoButtonConpile().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                shahukuInfoButtonConpileActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getShahukuInfoButtonDelete().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                shahukuInfoButtonDeleteActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getShahukuInfoTable().addListSelectionListener(new ListSelectionListener(){
        private boolean lockFlag = false;
        public void valueChanged(ListSelectionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                shahukuInfoTableSelectionChanged(e);
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
   * �u��������N���A�����v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void kaigoInfoButtonClearActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u��������ǉ������v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void kaigoInfoButtonInsertActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u��������ҏW�����v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void kaigoInfoButtonConpileActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u��������폜�����v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void kaigoInfoButtonDeleteActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u���S�Ҕԍ����͎������v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void kaigoInfoInsurerNoFocusLost(FocusEvent e) throws Exception;

  /**
   * �u��������W�J�����v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void kaigoInfoTableSelectionChanged(ListSelectionEvent e) throws Exception;

  /**
   * �u���S�Җ��I���������v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void kaigoInfoBearNameActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u������I���������v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void kaigoInfoPublicExpenseActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u�N���A�����v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void shahukuInfoButtonClearActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u�ǉ������v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void shahukuInfoButtonInsertActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u�ҏW�����v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void shahukuInfoButtonConpileActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u�폜�����v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void shahukuInfoButtonDeleteActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u�Љ�����Ə��W�J�����v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void shahukuInfoTableSelectionChanged(ListSelectionEvent e) throws Exception;

  //�ϐ���`

  private ACPassiveKey PASSIVE_CHECK_KEY;
  public static final int INSURE_TYPE_KAIGO = 1;
  public static final int INSURE_TYPE_SHAHUKU = 3;
  public static final int CHECK_MODE_INSERT = 1;
  public static final int CHECK_MODE_UPDATE = 2;
  public static final int TYPE_SHAHUKU = 7701;
  public static final int KAIGO_OTHER_KOHI = 9999;
  public static final int IRYO_OTHER_KOHI = 9998;
  public static final Date MAX_DATE = ACCastUtilities.toDate("9999/12/31", null);
  public static final Date MIN_DATE = ACCastUtilities.toDate("0001/01/01", null);
  private int patientId;
  private int systemDate;
  private int processMode = QkanConstants.PROCESS_MODE_INSERT;
  private int kaigoTableChangeFlg;
  private int shahukuTableChangeFlg;
  private int kohiDataFlg;
  private int compulsoryBackFlg;
  private String processStart;
  public static final String AFFAIR_ID = "QU004";
  private VRList masterKohiServiceList = new VRArrayList();
  private VRList patientKohiList = new VRArrayList();
  private VRList insurerList = new VRArrayList();
  private VRList masterKohiList = new VRArrayList();
  private VRMap masterService = new VRHashMap();
  private ACTableModelAdapter kaigoTableModel;
  private ACTableModelAdapter shahukuTableModel;
  private ACTableModelAdapter kaigoServiceTableModel;
  private ACTableModelAdapter shahukuServiceTableModel;
  private ACSnapshot snapShotKaigo = new ACSnapshot();
  private ACSnapshot snapShotShahuku = new ACSnapshot();
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
   * kaigoTableChangeFlg��Ԃ��܂��B
   * @return kaigoTableChangeFlg
   */
  protected int getKaigoTableChangeFlg(){
    return kaigoTableChangeFlg;
  }
  /**
   * kaigoTableChangeFlg��ݒ肵�܂��B
   * @param kaigoTableChangeFlg kaigoTableChangeFlg
   */
  protected void setKaigoTableChangeFlg(int kaigoTableChangeFlg){
    this.kaigoTableChangeFlg = kaigoTableChangeFlg;
  }

  /**
   * shahukuTableChangeFlg��Ԃ��܂��B
   * @return shahukuTableChangeFlg
   */
  protected int getShahukuTableChangeFlg(){
    return shahukuTableChangeFlg;
  }
  /**
   * shahukuTableChangeFlg��ݒ肵�܂��B
   * @param shahukuTableChangeFlg shahukuTableChangeFlg
   */
  protected void setShahukuTableChangeFlg(int shahukuTableChangeFlg){
    this.shahukuTableChangeFlg = shahukuTableChangeFlg;
  }

  /**
   * kohiDataFlg��Ԃ��܂��B
   * @return kohiDataFlg
   */
  protected int getKohiDataFlg(){
    return kohiDataFlg;
  }
  /**
   * kohiDataFlg��ݒ肵�܂��B
   * @param kohiDataFlg kohiDataFlg
   */
  protected void setKohiDataFlg(int kohiDataFlg){
    this.kohiDataFlg = kohiDataFlg;
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
   * masterKohiServiceList��Ԃ��܂��B
   * @return masterKohiServiceList
   */
  protected VRList getMasterKohiServiceList(){
    return masterKohiServiceList;
  }
  /**
   * masterKohiServiceList��ݒ肵�܂��B
   * @param masterKohiServiceList masterKohiServiceList
   */
  protected void setMasterKohiServiceList(VRList masterKohiServiceList){
    this.masterKohiServiceList = masterKohiServiceList;
  }

  /**
   * patientKohiList��Ԃ��܂��B
   * @return patientKohiList
   */
  protected VRList getPatientKohiList(){
    return patientKohiList;
  }
  /**
   * patientKohiList��ݒ肵�܂��B
   * @param patientKohiList patientKohiList
   */
  protected void setPatientKohiList(VRList patientKohiList){
    this.patientKohiList = patientKohiList;
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
   * masterKohiList��Ԃ��܂��B
   * @return masterKohiList
   */
  protected VRList getMasterKohiList(){
    return masterKohiList;
  }
  /**
   * masterKohiList��ݒ肵�܂��B
   * @param masterKohiList masterKohiList
   */
  protected void setMasterKohiList(VRList masterKohiList){
    this.masterKohiList = masterKohiList;
  }

  /**
   * masterService��Ԃ��܂��B
   * @return masterService
   */
  protected VRMap getMasterService(){
    return masterService;
  }
  /**
   * masterService��ݒ肵�܂��B
   * @param masterService masterService
   */
  protected void setMasterService(VRMap masterService){
    this.masterService = masterService;
  }

  /**
   * kaigoTableModel��Ԃ��܂��B
   * @return kaigoTableModel
   */
  protected ACTableModelAdapter getKaigoTableModel(){
    return kaigoTableModel;
  }
  /**
   * kaigoTableModel��ݒ肵�܂��B
   * @param kaigoTableModel kaigoTableModel
   */
  protected void setKaigoTableModel(ACTableModelAdapter kaigoTableModel){
    this.kaigoTableModel = kaigoTableModel;
  }

  /**
   * shahukuTableModel��Ԃ��܂��B
   * @return shahukuTableModel
   */
  protected ACTableModelAdapter getShahukuTableModel(){
    return shahukuTableModel;
  }
  /**
   * shahukuTableModel��ݒ肵�܂��B
   * @param shahukuTableModel shahukuTableModel
   */
  protected void setShahukuTableModel(ACTableModelAdapter shahukuTableModel){
    this.shahukuTableModel = shahukuTableModel;
  }

  /**
   * kaigoServiceTableModel��Ԃ��܂��B
   * @return kaigoServiceTableModel
   */
  protected ACTableModelAdapter getKaigoServiceTableModel(){
    return kaigoServiceTableModel;
  }
  /**
   * kaigoServiceTableModel��ݒ肵�܂��B
   * @param kaigoServiceTableModel kaigoServiceTableModel
   */
  protected void setKaigoServiceTableModel(ACTableModelAdapter kaigoServiceTableModel){
    this.kaigoServiceTableModel = kaigoServiceTableModel;
  }

  /**
   * shahukuServiceTableModel��Ԃ��܂��B
   * @return shahukuServiceTableModel
   */
  protected ACTableModelAdapter getShahukuServiceTableModel(){
    return shahukuServiceTableModel;
  }
  /**
   * shahukuServiceTableModel��ݒ肵�܂��B
   * @param shahukuServiceTableModel shahukuServiceTableModel
   */
  protected void setShahukuServiceTableModel(ACTableModelAdapter shahukuServiceTableModel){
    this.shahukuServiceTableModel = shahukuServiceTableModel;
  }

  /**
   * snapShotKaigo��Ԃ��܂��B
   * @return snapShotKaigo
   */
  protected ACSnapshot getSnapShotKaigo(){
    return snapShotKaigo;
  }
  /**
   * snapShotKaigo��ݒ肵�܂��B
   * @param snapShotKaigo snapShotKaigo
   */
  protected void setSnapShotKaigo(ACSnapshot snapShotKaigo){
    this.snapShotKaigo = snapShotKaigo;
  }

  /**
   * snapShotShahuku��Ԃ��܂��B
   * @return snapShotShahuku
   */
  protected ACSnapshot getSnapShotShahuku(){
    return snapShotShahuku;
  }
  /**
   * snapShotShahuku��ݒ肵�܂��B
   * @param snapShotShahuku snapShotShahuku
   */
  protected void setSnapShotShahuku(ACSnapshot snapShotShahuku){
    this.snapShotShahuku = snapShotShahuku;
  }

  //�����֐�

  /**
   * �u���R�[�h�擾�E��ʐݒ�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   *
   */
  public abstract void doFind() throws Exception;

  /**
   * �u���p�Ҍ�����擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   *
   */
  public abstract void doFindPatientKohi() throws Exception;

  /**
   * �u���S�Җ������v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @param insureType int
   * @throws Exception ������O
   *
   */
  public abstract void doFindInsurerName(int insureType) throws Exception;

  /**
   * �u���S�Ҕԍ������v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @param insureType int
   * @throws Exception ������O
   *
   */
  public abstract void doFindInsurerId(int insureType) throws Exception;

  /**
   * �u���t�ΏۃT�[�r�X�����v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @param kohiType int
   * @param insureType int
   * @throws Exception ������O
   *
   */
  public abstract void doFindTargetService(int kohiType, int insureType) throws Exception;

  /**
   * �u���̓`�F�b�N�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @param insureType int
   * @param checkMode int
   * @throws Exception ������O
   * @return boolean
   */
  public abstract boolean isValidInput(int insureType, int checkMode) throws Exception;

  /**
   * �u������̃`�F�b�N�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @param checkMode int
   * @throws Exception ������O
   * @return boolean
   */
  public abstract boolean doCheckKaigoKohi(int checkMode) throws Exception;

  /**
   * �u�ۑ������v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   * @return boolean
   */
  public abstract boolean doSave() throws Exception;

  /**
   * �u���p�Ҍ���T�[�r�X���W�J�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @param kohiId int
   * @param insureType int
   * @throws Exception ������O
   *
   */
  public abstract void setPatientKohiService(int kohiId, int insureType) throws Exception;

  /**
   * �u���p�Ҍ���T�[�r�X������ʂ��擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @param kohiId int
   * @param insureType int
   * @throws Exception ������O
   * @return VRList
   */
  public abstract VRList getPatientKohiService(int kohiId, int insureType) throws Exception;

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
  public abstract VRList toKohiTableList(VRList list) throws Exception;

  /**
   * �u�f�[�^�ҏW�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @param map VRMap
   * @throws Exception ������O
   * @return VRMap
   */
  public abstract VRMap toKohiTableList(VRMap map) throws Exception;

  /**
   * �u�e�ی��̃f�[�^�擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @param list VRList
   * @param insureType int
   * @throws Exception ������O
   * @return VRList
   */
  public abstract VRList getListToSetTable(VRList list, int insureType) throws Exception;

  /**
   * �u�f�[�^�ҏW�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @param map VRMap
   * @param mode String
   * @throws Exception ������O
   * @return VRMap
   */
  public abstract VRMap toShahukuTableList(VRMap map, String mode) throws Exception;

  /**
   * �u����v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @param kohi VRMap
   * @param aimDate Date
   * @param showOldKohi int
   * @throws Exception ������O
   * @return boolean
   */
  public abstract boolean canShowKohi(VRMap kohi, Date aimDate, int showOldKohi) throws Exception;

}
