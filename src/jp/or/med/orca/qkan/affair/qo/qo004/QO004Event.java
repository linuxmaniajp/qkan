
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
 * �쐬��: 2011/12/07  ���{�R���s���[�^�[������� ����@��F �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���̑��@�\ (O)
 * �v���Z�X ���Ə��Ǘ� (004)
 * �v���O���� ���Ə��o�^ (QO004)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qo.qo004;
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
 * ���Ə��o�^�C�x���g��`(QO004) 
 */
public abstract class QO004Event extends QO004SQL {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QO004Event(){
    addEvents();
  }
  /**
   * �C�x���g�����������`���܂��B
   */
  protected void addEvents() {
    getReflection().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                reflectionActionPerformed(e);
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
    getProviderStaffTable().addListSelectionListener(new ListSelectionListener(){
        private boolean lockFlag = false;
        public void valueChanged(ListSelectionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                providerStaffTableSelectionChanged(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getServiceKindTable().addListSelectionListener(new ListSelectionListener(){
        private boolean lockFlag = false;
        public void valueChanged(ListSelectionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                serviceKindTableSelectionChanged(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getOfferCheck().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                offerCheckActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getProviderStaffInsert().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                providerStaffInsertActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getProviderStaffFind().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                providerStaffFindActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getProviderStaffDelete().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                providerStaffDeleteActionPerformed(e);
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

  }
  //�R���|�[�l���g�C�x���g

  /**
   * �u�񋟃T�[�r�X��񔽉f�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void reflectionActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u�V�K�o�^���[�h�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void newDataActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u�N���A�����v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void clearActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u�Ώۃ��R�[�h����ʂɓW�J�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void providerStaffTableSelectionChanged(ListSelectionEvent e) throws Exception;

  /**
   * �u�Ώۃ��R�[�h����ʂɓW�J�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void serviceKindTableSelectionChanged(ListSelectionEvent e) throws Exception;

  /**
   * �u�T�[�r�X�p�l���̐���v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void offerCheckActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u�S���Ғǉ��v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void providerStaffInsertActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u�S���ҕҏW�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void providerStaffFindActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u�S���ҍ폜�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void providerStaffDeleteActionPerformed(ActionEvent e) throws Exception;

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

  //�ϐ���`

  private ACPassiveKey PROVIDER_PASSIVE_CHECK_KEY;
  public static final String AFFAIR_ID = "QO004";
  public static final String KAIGO_KANGO_NAME = "�K��Ō�";
  public static final String BIND_PATH_OF_MOUNTAINOUS_AREA_RAFIO = "2";
  public static final String BIND_PATH_OF_MOUNTAINOUS_AREA_SCALE = "3";
  public static final Date TARGET_DATE_20060401 = ACCastUtilities.toDate("2006/4/1", null);
  public static final Date TARGET_DATE_20051001 = ACCastUtilities.toDate("2005/10/1", null);
  public static final Date TARGET_DATE_20120401 = ACCastUtilities.toDate("2012/4/1", null);
  public static final int SERVICE_TYPE_KAIGO_KANGO = 11311;
  public static final int SERVICE_TYPE_CARE_PLAN = 14311;
  public static final int SERVICE_TYPE_OTHER = 90101;
  public static final int SERVICE_TYPE_ROUTINE = 90201;
  public static final int CODE_PROVIDER_TYPE = 195;
  public static final int CODE_LAW_VERSION = 202;
  public static final int DEFAULT_LAW_VERSION = 0;
  public static final int PROVIDER_TYPE_JIJIGYOSHO = 1;
  public static final int CHECK_MODE_INSERT = 1;
  public static final int CHECK_MODE_UPDATE = 2;
  private int providerStaffTableChangeFlag = 0;
  private int providerServiceTableChangeFlag = 0;
  private int STAFF_PROCESS_MODE;
  private int PROCESS_MODE;
  private int compulsoryBackFlag;
  private int currentServiceType;
  private int serviceDataExistenceFlag;
  private int staffDataExistenceFlag;
  private int menuDataExistenceFlag;
  private String selectedProviderId;
  private VRList providerServiceList = new VRArrayList();
  private VRList providerList = new VRArrayList();
  private VRList providerStaffList = new VRArrayList();
  private VRList providerMenuList = new VRArrayList();
  private VRList masterMenuList = new VRArrayList();
  private VRList filteredServiceList = new VRArrayList();
  private ACTableModelAdapter providerStaffTableModel;
  private ACTableModelAdapter providerServiceTableModel;
  private iProviderServicePanel providerServiceClass;
  private ACSnapshot serviceSnapshot = new ACSnapshot();
  private ACSnapshot staffSnapshot = new ACSnapshot();
  //getter/setter

  /**
   * PROVIDER_PASSIVE_CHECK_KEY��Ԃ��܂��B
   * @return PROVIDER_PASSIVE_CHECK_KEY
   */
  protected ACPassiveKey getPROVIDER_PASSIVE_CHECK_KEY(){
    return PROVIDER_PASSIVE_CHECK_KEY;
  }
  /**
   * PROVIDER_PASSIVE_CHECK_KEY��ݒ肵�܂��B
   * @param PROVIDER_PASSIVE_CHECK_KEY PROVIDER_PASSIVE_CHECK_KEY
   */
  protected void setPROVIDER_PASSIVE_CHECK_KEY(ACPassiveKey PROVIDER_PASSIVE_CHECK_KEY){
    this.PROVIDER_PASSIVE_CHECK_KEY = PROVIDER_PASSIVE_CHECK_KEY;
  }

  /**
   * providerStaffTableChangeFlag��Ԃ��܂��B
   * @return providerStaffTableChangeFlag
   */
  protected int getProviderStaffTableChangeFlag(){
    return providerStaffTableChangeFlag;
  }
  /**
   * providerStaffTableChangeFlag��ݒ肵�܂��B
   * @param providerStaffTableChangeFlag providerStaffTableChangeFlag
   */
  protected void setProviderStaffTableChangeFlag(int providerStaffTableChangeFlag){
    this.providerStaffTableChangeFlag = providerStaffTableChangeFlag;
  }

  /**
   * providerServiceTableChangeFlag��Ԃ��܂��B
   * @return providerServiceTableChangeFlag
   */
  protected int getProviderServiceTableChangeFlag(){
    return providerServiceTableChangeFlag;
  }
  /**
   * providerServiceTableChangeFlag��ݒ肵�܂��B
   * @param providerServiceTableChangeFlag providerServiceTableChangeFlag
   */
  protected void setProviderServiceTableChangeFlag(int providerServiceTableChangeFlag){
    this.providerServiceTableChangeFlag = providerServiceTableChangeFlag;
  }

  /**
   * STAFF_PROCESS_MODE��Ԃ��܂��B
   * @return STAFF_PROCESS_MODE
   */
  protected int getSTAFF_PROCESS_MODE(){
    return STAFF_PROCESS_MODE;
  }
  /**
   * STAFF_PROCESS_MODE��ݒ肵�܂��B
   * @param STAFF_PROCESS_MODE STAFF_PROCESS_MODE
   */
  protected void setSTAFF_PROCESS_MODE(int STAFF_PROCESS_MODE){
    this.STAFF_PROCESS_MODE = STAFF_PROCESS_MODE;
  }

  /**
   * PROCESS_MODE��Ԃ��܂��B
   * @return PROCESS_MODE
   */
  protected int getPROCESS_MODE(){
    return PROCESS_MODE;
  }
  /**
   * PROCESS_MODE��ݒ肵�܂��B
   * @param PROCESS_MODE PROCESS_MODE
   */
  protected void setPROCESS_MODE(int PROCESS_MODE){
    this.PROCESS_MODE = PROCESS_MODE;
  }

  /**
   * compulsoryBackFlag��Ԃ��܂��B
   * @return compulsoryBackFlag
   */
  protected int getCompulsoryBackFlag(){
    return compulsoryBackFlag;
  }
  /**
   * compulsoryBackFlag��ݒ肵�܂��B
   * @param compulsoryBackFlag compulsoryBackFlag
   */
  protected void setCompulsoryBackFlag(int compulsoryBackFlag){
    this.compulsoryBackFlag = compulsoryBackFlag;
  }

  /**
   * currentServiceType��Ԃ��܂��B
   * @return currentServiceType
   */
  protected int getCurrentServiceType(){
    return currentServiceType;
  }
  /**
   * currentServiceType��ݒ肵�܂��B
   * @param currentServiceType currentServiceType
   */
  protected void setCurrentServiceType(int currentServiceType){
    this.currentServiceType = currentServiceType;
  }

  /**
   * serviceDataExistenceFlag��Ԃ��܂��B
   * @return serviceDataExistenceFlag
   */
  protected int getServiceDataExistenceFlag(){
    return serviceDataExistenceFlag;
  }
  /**
   * serviceDataExistenceFlag��ݒ肵�܂��B
   * @param serviceDataExistenceFlag serviceDataExistenceFlag
   */
  protected void setServiceDataExistenceFlag(int serviceDataExistenceFlag){
    this.serviceDataExistenceFlag = serviceDataExistenceFlag;
  }

  /**
   * staffDataExistenceFlag��Ԃ��܂��B
   * @return staffDataExistenceFlag
   */
  protected int getStaffDataExistenceFlag(){
    return staffDataExistenceFlag;
  }
  /**
   * staffDataExistenceFlag��ݒ肵�܂��B
   * @param staffDataExistenceFlag staffDataExistenceFlag
   */
  protected void setStaffDataExistenceFlag(int staffDataExistenceFlag){
    this.staffDataExistenceFlag = staffDataExistenceFlag;
  }

  /**
   * menuDataExistenceFlag��Ԃ��܂��B
   * @return menuDataExistenceFlag
   */
  protected int getMenuDataExistenceFlag(){
    return menuDataExistenceFlag;
  }
  /**
   * menuDataExistenceFlag��ݒ肵�܂��B
   * @param menuDataExistenceFlag menuDataExistenceFlag
   */
  protected void setMenuDataExistenceFlag(int menuDataExistenceFlag){
    this.menuDataExistenceFlag = menuDataExistenceFlag;
  }

  /**
   * selectedProviderId��Ԃ��܂��B
   * @return selectedProviderId
   */
  protected String getSelectedProviderId(){
    return selectedProviderId;
  }
  /**
   * selectedProviderId��ݒ肵�܂��B
   * @param selectedProviderId selectedProviderId
   */
  protected void setSelectedProviderId(String selectedProviderId){
    this.selectedProviderId = selectedProviderId;
  }

  /**
   * providerServiceList��Ԃ��܂��B
   * @return providerServiceList
   */
  protected VRList getProviderServiceList(){
    return providerServiceList;
  }
  /**
   * providerServiceList��ݒ肵�܂��B
   * @param providerServiceList providerServiceList
   */
  protected void setProviderServiceList(VRList providerServiceList){
    this.providerServiceList = providerServiceList;
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
   * providerStaffList��Ԃ��܂��B
   * @return providerStaffList
   */
  protected VRList getProviderStaffList(){
    return providerStaffList;
  }
  /**
   * providerStaffList��ݒ肵�܂��B
   * @param providerStaffList providerStaffList
   */
  protected void setProviderStaffList(VRList providerStaffList){
    this.providerStaffList = providerStaffList;
  }

  /**
   * providerMenuList��Ԃ��܂��B
   * @return providerMenuList
   */
  protected VRList getProviderMenuList(){
    return providerMenuList;
  }
  /**
   * providerMenuList��ݒ肵�܂��B
   * @param providerMenuList providerMenuList
   */
  protected void setProviderMenuList(VRList providerMenuList){
    this.providerMenuList = providerMenuList;
  }

  /**
   * masterMenuList��Ԃ��܂��B
   * @return masterMenuList
   */
  protected VRList getMasterMenuList(){
    return masterMenuList;
  }
  /**
   * masterMenuList��ݒ肵�܂��B
   * @param masterMenuList masterMenuList
   */
  protected void setMasterMenuList(VRList masterMenuList){
    this.masterMenuList = masterMenuList;
  }

  /**
   * filteredServiceList��Ԃ��܂��B
   * @return filteredServiceList
   */
  protected VRList getFilteredServiceList(){
    return filteredServiceList;
  }
  /**
   * filteredServiceList��ݒ肵�܂��B
   * @param filteredServiceList filteredServiceList
   */
  protected void setFilteredServiceList(VRList filteredServiceList){
    this.filteredServiceList = filteredServiceList;
  }

  /**
   * providerStaffTableModel��Ԃ��܂��B
   * @return providerStaffTableModel
   */
  protected ACTableModelAdapter getProviderStaffTableModel(){
    return providerStaffTableModel;
  }
  /**
   * providerStaffTableModel��ݒ肵�܂��B
   * @param providerStaffTableModel providerStaffTableModel
   */
  protected void setProviderStaffTableModel(ACTableModelAdapter providerStaffTableModel){
    this.providerStaffTableModel = providerStaffTableModel;
  }

  /**
   * providerServiceTableModel��Ԃ��܂��B
   * @return providerServiceTableModel
   */
  protected ACTableModelAdapter getProviderServiceTableModel(){
    return providerServiceTableModel;
  }
  /**
   * providerServiceTableModel��ݒ肵�܂��B
   * @param providerServiceTableModel providerServiceTableModel
   */
  protected void setProviderServiceTableModel(ACTableModelAdapter providerServiceTableModel){
    this.providerServiceTableModel = providerServiceTableModel;
  }

  /**
   * providerServiceClass��Ԃ��܂��B
   * @return providerServiceClass
   */
  protected iProviderServicePanel getProviderServiceClass(){
    return providerServiceClass;
  }
  /**
   * providerServiceClass��ݒ肵�܂��B
   * @param providerServiceClass providerServiceClass
   */
  protected void setProviderServiceClass(iProviderServicePanel providerServiceClass){
    this.providerServiceClass = providerServiceClass;
  }

  /**
   * serviceSnapshot��Ԃ��܂��B
   * @return serviceSnapshot
   */
  protected ACSnapshot getServiceSnapshot(){
    return serviceSnapshot;
  }
  /**
   * serviceSnapshot��ݒ肵�܂��B
   * @param serviceSnapshot serviceSnapshot
   */
  protected void setServiceSnapshot(ACSnapshot serviceSnapshot){
    this.serviceSnapshot = serviceSnapshot;
  }

  /**
   * staffSnapshot��Ԃ��܂��B
   * @return staffSnapshot
   */
  protected ACSnapshot getStaffSnapshot(){
    return staffSnapshot;
  }
  /**
   * staffSnapshot��ݒ肵�܂��B
   * @param staffSnapshot staffSnapshot
   */
  protected void setStaffSnapshot(ACSnapshot staffSnapshot){
    this.staffSnapshot = staffSnapshot;
  }

  //�����֐�

  /**
   * �u�������v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   *
   */
  public abstract void initialize() throws Exception;

  /**
   * �u��ʂ̐ݒ�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   *
   */
  public abstract void affairSetUp() throws Exception;

  /**
   * �u���Ə����擾�����v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   *
   */
  public abstract void doFind() throws Exception;

  /**
   * �u���Ə����j���[�����擾����v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   *
   */
  public abstract void doFindProviderMenu() throws Exception;

  /**
   * �u�񋟃T�[�r�X���X�g�p�̃f�[�^���쐬����v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   *
   */
  public abstract void doCreateServiceTableData() throws Exception;

  /**
   * �u�S���ҏ��擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   *
   */
  public abstract void doCreateStaffData() throws Exception;

  /**
   * �u�S���ҏ����̓`�F�b�N�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @param checkMode int
   * @throws Exception ������O
   * @return boolean
   */
  public abstract boolean isValidInputStaff(int checkMode) throws Exception;

  /**
   * �u�ۑ������v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   * @return boolean
   */
  public abstract boolean doSave() throws Exception;

  /**
   * �u�폜�\�ȃT�[�r�X�����f���鏈���v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   * @return boolean
   */
  public abstract boolean doCheckDeleteService() throws Exception;

  /**
   * �u���Ə����j���[����o�^����v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @param list VRList
   * @throws Exception ������O
   *
   */
  public abstract void insertProviderMenu(VRList list) throws Exception;

  /**
   * �u�}�X�^���j���[��������擾���鏈���v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   *
   */
  public abstract void getMasterMenu() throws Exception;

  /**
   * �u���Ə���{���`�F�b�N�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   * @return boolean
   */
  public abstract boolean doValidProviderCheck() throws Exception;

  /**
   * �u�N���A�����v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   *
   */
  public abstract void allClear() throws Exception;

  /**
   * �u�T�[�r�X�ڍ׏��̔��f�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   * @return boolean
   */
  public abstract boolean reflect() throws Exception;

  /**
   * �u�T�[�r�X�ڍ׏��ύX�`�F�b�N�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   * @return boolean
   */
  public abstract boolean isModifiedOnService() throws Exception;

}
