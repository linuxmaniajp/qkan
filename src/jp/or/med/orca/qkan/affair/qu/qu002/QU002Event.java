
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
 * �J����: ��i �a�P
 * �쐬��: 2011/12/19  ���{�R���s���[�^�[������� ��i �a�P �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���p�ҊǗ� (U)
 * �v���Z�X ���p�ғo�^ (002)
 * �v���O���� ���p�ғo�^ (QU002)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qu.qu002;
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
 * ���p�ғo�^�C�x���g��`(QU002) 
 */
@SuppressWarnings("serial")
public abstract class QU002Event extends QU002SQL {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QU002Event(){
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
    getClearInsertMode().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                clearInsertModeActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getClearUpdateMode().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                clearUpdateModeActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getToKohiInfoButton().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                toKohiInfoButtonActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getIdouInfoTable().addListSelectionListener(new ListSelectionListener(){
        private boolean lockFlag = false;
        public void valueChanged(ListSelectionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                idouInfoTableSelectionChanged(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getIdouInfoButtonClear().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                idouInfoButtonClearActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getIdouInfoButtonInsert().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                idouInfoButtonInsertActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getIdouInfoButtonEdit().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                idouInfoButtonEditActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getIdouInfoButtonDelete().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                idouInfoButtonDeleteActionPerformed(e);
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
    getKaigoInfoButtonEdit().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                kaigoInfoButtonEditActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getKaigoInfoDelete().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                kaigoInfoDeleteActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getIdouInfoServise().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                idouInfoServiseActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getIdouInfoChangeContent().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                idouInfoChangeContentActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getIdouInfoReason().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                idouInfoReasonActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getKaigoInfoInsurerId().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                kaigoInfoInsurerIdFocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getKaigoInfoInsurerName().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                kaigoInfoInsurerNameActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getKaigoInfoKyotakuServiceRadio().addListSelectionListener(new ListSelectionListener(){
        private boolean lockFlag = false;
        public void valueChanged(ListSelectionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                kaigoInfoKyotakuServiceRadioSelectionChanged(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getKaigoInfoYokaigoInfo().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                kaigoInfoYokaigoInfoActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getKaigoInfoValidLimit1().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                kaigoInfoValidLimit1FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getKaigoInfoValidLimit3().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                kaigoInfoValidLimit3FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getBasicInfoBirth().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                basicInfoBirthFocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getInstitutionInfoTokuteiNyusho().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                institutionInfoTokuteiNyushoActionPerformed(e);
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
   * �u��ʑS�̃N���A�����v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void clearInsertModeActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u��ʑS�̃N���A�����v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void clearUpdateModeActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u��ʑJ�ڏ����v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void toKohiInfoButtonActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u�Ώۃ��R�[�h��\���v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void idouInfoTableSelectionChanged(ListSelectionEvent e) throws Exception;

  /**
   * �u�N���A�����v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void idouInfoButtonClearActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u�ǉ������v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void idouInfoButtonInsertActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u�ҏW�����v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void idouInfoButtonEditActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u�폜�����v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void idouInfoButtonDeleteActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u�Ώۃ��R�[�h��\���v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void kaigoInfoTableSelectionChanged(ListSelectionEvent e) throws Exception;

  /**
   * �u�N���A�����v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void kaigoInfoButtonClearActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u�ǉ������v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void kaigoInfoButtonInsertActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u�ҏW�����v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void kaigoInfoButtonEditActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u�폜�����v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void kaigoInfoDeleteActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u��ʏ����v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void idouInfoServiseActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u��ʏ����v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void idouInfoChangeContentActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u��ʏ����v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void idouInfoReasonActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u�ی��Җ��\���E�x�����x�z�\���v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void kaigoInfoInsurerIdFocusLost(FocusEvent e) throws Exception;

  /**
   * �u�ی��Ҕԍ��\���E�x�����x�z�\���v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void kaigoInfoInsurerNameActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u��ʏ����v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void kaigoInfoKyotakuServiceRadioSelectionChanged(ListSelectionEvent e) throws Exception;

  /**
   * �u�x�����x�z�\���v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void kaigoInfoYokaigoInfoActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u�x�����x�z�\���v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void kaigoInfoValidLimit1FocusLost(FocusEvent e) throws Exception;

  /**
   * �u�x�����x�z�\���v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void kaigoInfoValidLimit3FocusLost(FocusEvent e) throws Exception;

  /**
   * �u�N��\���v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void basicInfoBirthFocusLost(FocusEvent e) throws Exception;

  /**
   * �u��ʏ����v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void institutionInfoTokuteiNyushoActionPerformed(ActionEvent e) throws Exception;

  //�ϐ���`

  private ACPassiveKey PASSIVE_CHECK_KEY_PATIENT;
  private int patientId;
  private int processMode = QkanConstants.PROCESS_MODE_INSERT;
  private int idouTableChangeFlg;
  private int kaigoTableChangeFlg;
  private int kaigoDataFlg;
  private int idouDataFlg;
  private int shisetsuDataFlg;
  private int compulsoryBackFlg;
  private int NonCorrespondenceFlg;
  private Date systemDate;
  public static final Date TARGET_DATE_20060401 = ACCastUtilities.toDate("2006/04/01", null);
  public static final Date MAX_DATE = ACCastUtilities.toDate("9999/12/31", null);
  public static final Date MIN_DATE = ACCastUtilities.toDate("0001/01/01", null);
  public static final String AFFAIR_ID = "QU002";
  public static final int INDEX_OF_PROVIDER_SHIEN = 1;
  public static final int INDEX_OF_PROVIDER_YOBOU_SHIEN = 3;
  public static final int INSURE_RATE_SEIHO = 0;
  public static final int CHECK_MODE_INSERT = 1;
  public static final int CHECK_MODE_UPDATE = 2;
  public static final int CODE_YOKAIGODO = 204;
  public static final int CODE_SHINSEI_KUBUN = 11;
  public static final int CODE_TYUDAN_RIYU = 13;
  public static final int CODE_INSURE_RATE = 192;
  public static final int CODE_IDOU_CONTENT_KYOTAKU = 2;
  public static final int CODE_IDOU_CONTENT_SHISETSU1 = 3;
  public static final int CODE_IDOU_CONTENT_SHISETSU2 = 4;
  public static final int CODE_IDOU_CONTENT_IRYO_KANGO = 5;
  public static final int CODE_IDOU_CONTENT_SHISETSU3 = 200;
  public static final int CODE_IDOU_REASON_KYOTAKU = 6;
  public static final int CODE_IDOU_REASON_SHISETSU1 = 7;
  public static final int CODE_IDOU_REASON_SHISETSU2 = 8;
  public static final int CODE_IDOU_REASON_IRYO_KANGO = 9;
  public static final int CODE_IDOU_REASON_SHISETSU3 = 201;
  public static final int IDOU_SERVICE_KYOTAKU = 1;
  public static final int IDOU_SERVICE_SHISETSU1 = 2;
  public static final int IDOU_SERVICE_SHISETSU2 = 3;
  public static final int IDOU_SERVICE_IRYO_KANGO = 4;
  public static final int IDOU_SERVICE_SHISETSU3 = 5;
  public static final int IDOU_STOP_KYOTAKU = 2;
  public static final int IDOU_STOP_SHISETSU1 = 2;
  public static final int IDOU_STOP_SHISETSU2 = 2;
  public static final int IDOU_STOP_IRYO_KANGO = 2;
  public static final int IDOU_STOP_SHISETSU3 = 2;
  public static final int IDOU_OTHER_KYOTAKU = 5;
  public static final int IDOU_OTHER_SHISETSU1 = 5;
  public static final int IDOU_OTHER_SHISETSU2 = 5;
  public static final int IDOU_OTHER_IRYO_KANGO = 5;
  public static final int IDOU_OTHER_SHISETSU3 = 5;
  public static final int SERVICE_TYPE_SHIEN = 14311;
  public static final int SERVICE_TYPE_YOBOU_SHIEN = 14611;
  public static final int SERVICE_TYPE_SHOKIBO = 17311;
  public static final int SERVICE_TYPE_YOBOU_SHOKIBO = 17511;
  public static final int SERVICE_TYPE_OTHER = 90101;
  public static final int SERVICE_TYPE_ROUTINE = 90201;
  public static final int YOUKAIGODO_HIGAITOU = 1;
  public static final int YOUKAIGODO_KEIKATEKI_YOUKAIGO = 11;
  public static final int CODE_IDOU_REASON_NYUSYO_NYUIN = 278;
  public static final int IDOU_START_SHISETSU1 = 1;
  public static final int IDOU_START_SHISETSU2 = 1;
  public static final int IDOU_START_SHISETSU3 = 1;
  private String processStart;
  private VRMap masterService = new VRHashMap();
  private VRMap masterCode = new VRHashMap();
  private VRList patientInfoList = new VRArrayList();
  private VRList kaigoHistoryList = new VRArrayList();
  private VRList idouHistoryList = new VRArrayList();
  private VRList shisetsuHistoryList = new VRArrayList();
  private VRList providerListKaigoShien = new VRArrayList();
  private VRList providerListYobouShien = new VRArrayList();
  private ACTableModelAdapter kaigoTableModel;
  private ACTableModelAdapter idouTableModel;
  private ACSnapshot snapShotKaigo = new ACSnapshot();
  private ACSnapshot snapShotIdou = new ACSnapshot();
  //getter/setter

  /**
   * PASSIVE_CHECK_KEY_PATIENT��Ԃ��܂��B
   * @return PASSIVE_CHECK_KEY_PATIENT
   */
  protected ACPassiveKey getPASSIVE_CHECK_KEY_PATIENT(){
    return PASSIVE_CHECK_KEY_PATIENT;
  }
  /**
   * PASSIVE_CHECK_KEY_PATIENT��ݒ肵�܂��B
   * @param PASSIVE_CHECK_KEY_PATIENT PASSIVE_CHECK_KEY_PATIENT
   */
  protected void setPASSIVE_CHECK_KEY_PATIENT(ACPassiveKey PASSIVE_CHECK_KEY_PATIENT){
    this.PASSIVE_CHECK_KEY_PATIENT = PASSIVE_CHECK_KEY_PATIENT;
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
   * idouTableChangeFlg��Ԃ��܂��B
   * @return idouTableChangeFlg
   */
  protected int getIdouTableChangeFlg(){
    return idouTableChangeFlg;
  }
  /**
   * idouTableChangeFlg��ݒ肵�܂��B
   * @param idouTableChangeFlg idouTableChangeFlg
   */
  protected void setIdouTableChangeFlg(int idouTableChangeFlg){
    this.idouTableChangeFlg = idouTableChangeFlg;
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
   * kaigoDataFlg��Ԃ��܂��B
   * @return kaigoDataFlg
   */
  protected int getKaigoDataFlg(){
    return kaigoDataFlg;
  }
  /**
   * kaigoDataFlg��ݒ肵�܂��B
   * @param kaigoDataFlg kaigoDataFlg
   */
  protected void setKaigoDataFlg(int kaigoDataFlg){
    this.kaigoDataFlg = kaigoDataFlg;
  }

  /**
   * idouDataFlg��Ԃ��܂��B
   * @return idouDataFlg
   */
  protected int getIdouDataFlg(){
    return idouDataFlg;
  }
  /**
   * idouDataFlg��ݒ肵�܂��B
   * @param idouDataFlg idouDataFlg
   */
  protected void setIdouDataFlg(int idouDataFlg){
    this.idouDataFlg = idouDataFlg;
  }

  /**
   * shisetsuDataFlg��Ԃ��܂��B
   * @return shisetsuDataFlg
   */
  protected int getShisetsuDataFlg(){
    return shisetsuDataFlg;
  }
  /**
   * shisetsuDataFlg��ݒ肵�܂��B
   * @param shisetsuDataFlg shisetsuDataFlg
   */
  protected void setShisetsuDataFlg(int shisetsuDataFlg){
    this.shisetsuDataFlg = shisetsuDataFlg;
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
   * NonCorrespondenceFlg��Ԃ��܂��B
   * @return NonCorrespondenceFlg
   */
  protected int getNonCorrespondenceFlg(){
    return NonCorrespondenceFlg;
  }
  /**
   * NonCorrespondenceFlg��ݒ肵�܂��B
   * @param NonCorrespondenceFlg NonCorrespondenceFlg
   */
  protected void setNonCorrespondenceFlg(int NonCorrespondenceFlg){
    this.NonCorrespondenceFlg = NonCorrespondenceFlg;
  }

  /**
   * systemDate��Ԃ��܂��B
   * @return systemDate
   */
  protected Date getSystemDate(){
    return systemDate;
  }
  /**
   * systemDate��ݒ肵�܂��B
   * @param systemDate systemDate
   */
  protected void setSystemDate(Date systemDate){
    this.systemDate = systemDate;
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
   * patientInfoList��Ԃ��܂��B
   * @return patientInfoList
   */
  protected VRList getPatientInfoList(){
    return patientInfoList;
  }
  /**
   * patientInfoList��ݒ肵�܂��B
   * @param patientInfoList patientInfoList
   */
  protected void setPatientInfoList(VRList patientInfoList){
    this.patientInfoList = patientInfoList;
  }

  /**
   * kaigoHistoryList��Ԃ��܂��B
   * @return kaigoHistoryList
   */
  protected VRList getKaigoHistoryList(){
    return kaigoHistoryList;
  }
  /**
   * kaigoHistoryList��ݒ肵�܂��B
   * @param kaigoHistoryList kaigoHistoryList
   */
  protected void setKaigoHistoryList(VRList kaigoHistoryList){
    this.kaigoHistoryList = kaigoHistoryList;
  }

  /**
   * idouHistoryList��Ԃ��܂��B
   * @return idouHistoryList
   */
  protected VRList getIdouHistoryList(){
    return idouHistoryList;
  }
  /**
   * idouHistoryList��ݒ肵�܂��B
   * @param idouHistoryList idouHistoryList
   */
  protected void setIdouHistoryList(VRList idouHistoryList){
    this.idouHistoryList = idouHistoryList;
  }

  /**
   * shisetsuHistoryList��Ԃ��܂��B
   * @return shisetsuHistoryList
   */
  protected VRList getShisetsuHistoryList(){
    return shisetsuHistoryList;
  }
  /**
   * shisetsuHistoryList��ݒ肵�܂��B
   * @param shisetsuHistoryList shisetsuHistoryList
   */
  protected void setShisetsuHistoryList(VRList shisetsuHistoryList){
    this.shisetsuHistoryList = shisetsuHistoryList;
  }

  /**
   * providerListKaigoShien��Ԃ��܂��B
   * @return providerListKaigoShien
   */
  protected VRList getProviderListKaigoShien(){
    return providerListKaigoShien;
  }
  /**
   * providerListKaigoShien��ݒ肵�܂��B
   * @param providerListKaigoShien providerListKaigoShien
   */
  protected void setProviderListKaigoShien(VRList providerListKaigoShien){
    this.providerListKaigoShien = providerListKaigoShien;
  }

  /**
   * providerListYobouShien��Ԃ��܂��B
   * @return providerListYobouShien
   */
  protected VRList getProviderListYobouShien(){
    return providerListYobouShien;
  }
  /**
   * providerListYobouShien��ݒ肵�܂��B
   * @param providerListYobouShien providerListYobouShien
   */
  protected void setProviderListYobouShien(VRList providerListYobouShien){
    this.providerListYobouShien = providerListYobouShien;
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
   * idouTableModel��Ԃ��܂��B
   * @return idouTableModel
   */
  protected ACTableModelAdapter getIdouTableModel(){
    return idouTableModel;
  }
  /**
   * idouTableModel��ݒ肵�܂��B
   * @param idouTableModel idouTableModel
   */
  protected void setIdouTableModel(ACTableModelAdapter idouTableModel){
    this.idouTableModel = idouTableModel;
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
   * snapShotIdou��Ԃ��܂��B
   * @return snapShotIdou
   */
  protected ACSnapshot getSnapShotIdou(){
    return snapShotIdou;
  }
  /**
   * snapShotIdou��ݒ肵�܂��B
   * @param snapShotIdou snapShotIdou
   */
  protected void setSnapShotIdou(ACSnapshot snapShotIdou){
    this.snapShotIdou = snapShotIdou;
  }

  //�����֐�

  /**
   * �u���̓`�F�b�N�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   * @return boolean
   */
  public abstract boolean isValidInputPatient() throws Exception;

  /**
   * �u���̓`�F�b�N�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   * @return boolean
   */
  public abstract boolean isValidInputIdou() throws Exception;

  /**
   * �u�x�����x�z�\���v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   *
   */
  public abstract void doFindLimitRate() throws Exception;

  /**
   * �u�x�����x�z�擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   * @return int
   */
  public abstract int getLimitRate() throws Exception;

  /**
   * �u���̓`�F�b�N�E�x�����x�z�擾�p�����쐬�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   * @return VRMap
   */
  public abstract VRMap getParamForLimitRate() throws Exception;

  /**
   * �u���̓`�F�b�N�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @param checkMode int
   * @throws Exception ������O
   * @return boolean
   */
  public abstract boolean isValidInputKaigo(int checkMode) throws Exception;

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
   * �u���p�ҏ��擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   *
   */
  public abstract void doFindPatient() throws Exception;

  /**
   * �u�v��엚�����擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   *
   */
  public abstract void doFindKaigo() throws Exception;

  /**
   * �u�ٓ��������擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   *
   */
  public abstract void doFindIdou() throws Exception;

  /**
   * �u�{�ݗ������擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   *
   */
  public abstract void doFindShisetsu() throws Exception;

  /**
   * �u��ʑS�̃N���A�����v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   *
   */
  public abstract void doClear() throws Exception;

  /**
   * �u��ʏ������v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   *
   */
  public abstract void initialize() throws Exception;

  /**
   * �u��Ԑݒ�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   *
   */
  public abstract void casualInitialize() throws Exception;

}
