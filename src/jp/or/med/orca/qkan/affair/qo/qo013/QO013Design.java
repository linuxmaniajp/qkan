
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
 * �J����: �c���@����
 * �쐬��: 2012/01/24  ���{�R���s���[�^�[������� �c���@���� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���̑��@�\ (O)
 * �v���Z�X ����W�����Z�v�g�\�t�g�A�g (013)
 * �v���O���� ����W�����Z�v�g�\�t�g�A�g (QO013)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qo.qo013;
import java.awt.Component;
import java.awt.im.InputSubset;

import javax.swing.SwingConstants;
import javax.swing.table.TableColumn;

import jp.nichicom.ac.ACConstants;
import jp.nichicom.ac.component.ACAffairButton;
import jp.nichicom.ac.component.ACAffairButtonBar;
import jp.nichicom.ac.component.ACButton;
import jp.nichicom.ac.component.ACComboBox;
import jp.nichicom.ac.component.ACIntegerCheckBox;
import jp.nichicom.ac.component.ACLabel;
import jp.nichicom.ac.component.ACTextField;
import jp.nichicom.ac.component.table.ACCheckBoxTableColumnPopupMenu;
import jp.nichicom.ac.component.table.ACTable;
import jp.nichicom.ac.component.table.ACTableColumn;
import jp.nichicom.ac.container.ACBackLabelContainer;
import jp.nichicom.ac.container.ACGroupBox;
import jp.nichicom.ac.container.ACLabelContainer;
import jp.nichicom.ac.container.ACPanel;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACAffairable;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.text.ACBorderBlankDateFormat;
import jp.nichicom.ac.util.adapter.ACComboBoxModelAdapter;
import jp.nichicom.vr.component.table.VRTableCellViewer;
import jp.nichicom.vr.component.table.VRTableColumnModel;
import jp.nichicom.vr.layout.VRLayout;
import jp.nichicom.vr.text.VRCharType;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanConstants;
import jp.or.med.orca.qkan.affair.QkanAffairContainer;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
/**
 * ����W�����Z�v�g�\�t�g�A�g��ʍ��ڃf�U�C��(QO013) 
 */
public class QO013Design extends QkanAffairContainer implements ACAffairable {
  //GUI�R���|�[�l���g

  private ACAffairButtonBar buttons;

  private ACAffairButton connect;

  private ACAffairButton importPatient;

  private ACGroupBox connectSettings;

  private ACTextField hostName;

  private ACLabelContainer hostNameContainer;

  private ACTextField portNo;

  private ACLabelContainer portNoContainer;

  private ACTextField dbsVersion;

  private ACLabelContainer dbsVersionContainer;

  private ACTextField userName;

  private ACLabelContainer userNameContainer;

  private ACTextField password;

  private ACLabelContainer passwordContainer;

  private ACComboBox receiptVersionCombo;

  private ACLabelContainer receiptVersionComboContainer;

  private ACComboBoxModelAdapter receiptVersionComboModel;

  private ACGroupBox findSetting;

  private ACBackLabelContainer ageContainer;

  private ACLabel ageContainerTItle;

  private ACTextField ageStartText;

  private ACLabelContainer ageStartTextContainer;

  private ACLabel ageConnectLabel;

  private ACTextField ageEndText;

  private ACLabelContainer ageEndTextContainer;

  private ACLabel ageLabel;

  private ACIntegerCheckBox deduplicationCheck;

  private ACGroupBox importSettings;

  private ACPanel importPanel;

  private ACIntegerCheckBox toHiragana;

  private ACIntegerCheckBox allPageCheck;

  private ACButton previewPage;

  private ACButton nextPage;

  private ACPanel viewRange;

  private ACLabel totalCount;

  private ACLabel totalCountUnit;

  private ACLabel viewBeginNo;

  private ACLabel viewSpan;

  private ACLabel viewEndNo;

  private ACTable patients;

  private VRTableColumnModel patientsColumnModel;

  private ACTableColumn patientNo;

  private ACTableColumn patientImport;

  private ACTableColumn patientBatting;

  private ACTableColumn patientName;

  private ACTableColumn patientKana;

  private ACTableColumn patientSex;

  private ACTableColumn patientAge;

  private ACTableColumn patientBirth;

  private ACTableColumn patientZip;

  private ACTableColumn patientAddress;

  private ACTableColumn patientTel;

  //getter

  /**
   * �Ɩ��{�^���o�[���擾���܂��B
   * @return �Ɩ��{�^���o�[
   */
  public ACAffairButtonBar getButtons(){
    if(buttons==null){

      buttons = new ACAffairButtonBar();

      addButtons();
    }
    return buttons;

  }

  /**
   * �ʐM���擾���܂��B
   * @return �ʐM
   */
  public ACAffairButton getConnect(){
    if(connect==null){

      connect = new ACAffairButton();

      connect.setText("�ʐM(A)");

      connect.setMnemonic('A');

      connect.setIconPath(ACConstants.ICON_PATH_OPEN_24);

      addConnect();
    }
    return connect;

  }

  /**
   * ��荞�݂��擾���܂��B
   * @return ��荞��
   */
  public ACAffairButton getImportPatient(){
    if(importPatient==null){

      importPatient = new ACAffairButton();

      importPatient.setText("��荞��(I)");

      importPatient.setMnemonic('I');

      importPatient.setIconPath(ACConstants.ICON_PATH_UPDATE_24);

      addImportPatient();
    }
    return importPatient;

  }

  /**
   * �ڑ��ݒ���擾���܂��B
   * @return �ڑ��ݒ�
   */
  public ACGroupBox getConnectSettings(){
    if(connectSettings==null){

      connectSettings = new ACGroupBox();

      connectSettings.setText("�ڑ��ݒ�");

      addConnectSettings();
    }
    return connectSettings;

  }

  /**
   * �ڑ���z�X�g���擾���܂��B
   * @return �ڑ���z�X�g
   */
  public ACTextField getHostName(){
    if(hostName==null){

      hostName = new ACTextField();

      getHostNameContainer().setText("�ڑ���z�X�g");

      hostName.setBindPath("IP_ADDRESS");

      hostName.setColumns(15);

      hostName.setCharType(ACConstants.CHAR_TYPE_IP_OR_HOSTNAME);

      hostName.setIMEMode(InputSubset.LATIN);

      hostName.setMaxLength(64);

      addHostName();
    }
    return hostName;

  }

  /**
   * �ڑ���z�X�g�R���e�i���擾���܂��B
   * @return �ڑ���z�X�g�R���e�i
   */
  protected ACLabelContainer getHostNameContainer(){
    if(hostNameContainer==null){
      hostNameContainer = new ACLabelContainer();
      hostNameContainer.setFollowChildEnabled(true);
      hostNameContainer.setVAlignment(VRLayout.CENTER);
      hostNameContainer.add(getHostName(), null);
    }
    return hostNameContainer;
  }

  /**
   * �|�[�g�ԍ����擾���܂��B
   * @return �|�[�g�ԍ�
   */
  public ACTextField getPortNo(){
    if(portNo==null){

      portNo = new ACTextField();

      getPortNoContainer().setText("�|�[�g�ԍ�");

      portNo.setBindPath("PORT_NO");

      portNo.setColumns(5);

      portNo.setCharType(VRCharType.ONLY_DIGIT);

      portNo.setIMEMode(InputSubset.LATIN);

      portNo.setMaxLength(5);

      addPortNo();
    }
    return portNo;

  }

  /**
   * �|�[�g�ԍ��R���e�i���擾���܂��B
   * @return �|�[�g�ԍ��R���e�i
   */
  protected ACLabelContainer getPortNoContainer(){
    if(portNoContainer==null){
      portNoContainer = new ACLabelContainer();
      portNoContainer.setFollowChildEnabled(true);
      portNoContainer.setVAlignment(VRLayout.CENTER);
      portNoContainer.add(getPortNo(), null);
    }
    return portNoContainer;
  }

  /**
   * DBS�o�[�W�������擾���܂��B
   * @return DBS�o�[�W����
   */
  public ACTextField getDbsVersion(){
    if(dbsVersion==null){

      dbsVersion = new ACTextField();

      getDbsVersionContainer().setText("DBS�o�[�W����");

      dbsVersion.setBindPath("DBS_VERSION");

      dbsVersion.setColumns(10);

      dbsVersion.setIMEMode(InputSubset.LATIN);

      dbsVersion.setMaxLength(10);

      addDbsVersion();
    }
    return dbsVersion;

  }

  /**
   * DBS�o�[�W�����R���e�i���擾���܂��B
   * @return DBS�o�[�W�����R���e�i
   */
  protected ACLabelContainer getDbsVersionContainer(){
    if(dbsVersionContainer==null){
      dbsVersionContainer = new ACLabelContainer();
      dbsVersionContainer.setFollowChildEnabled(true);
      dbsVersionContainer.setVAlignment(VRLayout.CENTER);
      dbsVersionContainer.add(getDbsVersion(), null);
    }
    return dbsVersionContainer;
  }

  /**
   * ���[�U�[�����擾���܂��B
   * @return ���[�U�[��
   */
  public ACTextField getUserName(){
    if(userName==null){

      userName = new ACTextField();

      getUserNameContainer().setText("���[�U�[��");

      userName.setBindPath("USER_NAME");

      userName.setColumns(15);

      userName.setIMEMode(InputSubset.LATIN);

      userName.setMaxLength(255);

      addUserName();
    }
    return userName;

  }

  /**
   * ���[�U�[���R���e�i���擾���܂��B
   * @return ���[�U�[���R���e�i
   */
  protected ACLabelContainer getUserNameContainer(){
    if(userNameContainer==null){
      userNameContainer = new ACLabelContainer();
      userNameContainer.setFollowChildEnabled(true);
      userNameContainer.setVAlignment(VRLayout.CENTER);
      userNameContainer.add(getUserName(), null);
    }
    return userNameContainer;
  }

  /**
   * �p�X���[�h���擾���܂��B
   * @return �p�X���[�h
   */
  public ACTextField getPassword(){
    if(password==null){

      password = new ACTextField();

      getPasswordContainer().setText("�p�X���[�h");

      password.setBindPath("PASSWORD");

      password.setColumns(15);

      password.setIMEMode(InputSubset.LATIN);

      password.setMaxLength(255);

      addPassword();
    }
    return password;

  }

  /**
   * �p�X���[�h�R���e�i���擾���܂��B
   * @return �p�X���[�h�R���e�i
   */
  protected ACLabelContainer getPasswordContainer(){
    if(passwordContainer==null){
      passwordContainer = new ACLabelContainer();
      passwordContainer.setFollowChildEnabled(true);
      passwordContainer.setVAlignment(VRLayout.CENTER);
      passwordContainer.add(getPassword(), null);
    }
    return passwordContainer;
  }

  /**
   * ����W�����Z�v�g�\�t�g�o�[�W�������擾���܂��B
   * @return ����W�����Z�v�g�\�t�g�o�[�W����
   */
  public ACComboBox getReceiptVersionCombo(){
    if(receiptVersionCombo==null){

      receiptVersionCombo = new ACComboBox();

      getReceiptVersionComboContainer().setText("����W�����Z�v�g�\�t�g�o�[�W����");

      receiptVersionCombo.setBindPath("RECEIPT_VERSION_CONTENT");

      receiptVersionCombo.setVisible(true);

      receiptVersionCombo.setEnabled(true);

      receiptVersionCombo.setEditable(false);

      receiptVersionCombo.setColumns(12);

      receiptVersionCombo.setModelBindPath("RECEIPT_VERSION_CONTENT");

      receiptVersionCombo.setRenderBindPath("CONTENT");

      receiptVersionCombo.setBlankable(false);

      receiptVersionCombo.setModel(getReceiptVersionComboModel());

      addReceiptVersionCombo();
    }
    return receiptVersionCombo;

  }

  /**
   * ����W�����Z�v�g�\�t�g�o�[�W�����R���e�i���擾���܂��B
   * @return ����W�����Z�v�g�\�t�g�o�[�W�����R���e�i
   */
  protected ACLabelContainer getReceiptVersionComboContainer(){
    if(receiptVersionComboContainer==null){
      receiptVersionComboContainer = new ACLabelContainer();
      receiptVersionComboContainer.setFollowChildEnabled(true);
      receiptVersionComboContainer.setVAlignment(VRLayout.CENTER);
      receiptVersionComboContainer.add(getReceiptVersionCombo(), null);
    }
    return receiptVersionComboContainer;
  }

  /**
   * ����W�����Z�v�g�\�t�g�o�[�W�������f�����擾���܂��B
   * @return ����W�����Z�v�g�\�t�g�o�[�W�������f��
   */
  protected ACComboBoxModelAdapter getReceiptVersionComboModel(){
    if(receiptVersionComboModel==null){
      receiptVersionComboModel = new ACComboBoxModelAdapter();
      addReceiptVersionComboModel();
    }
    return receiptVersionComboModel;
  }

  /**
   * �擾�������擾���܂��B
   * @return �擾����
   */
  public ACGroupBox getFindSetting(){
    if(findSetting==null){

      findSetting = new ACGroupBox();

      findSetting.setText("�擾����");

      findSetting.setLabelMargin(0);

      findSetting.setVgap(0);

      addFindSetting();
    }
    return findSetting;

  }

  /**
   * �N��R���e�i���擾���܂��B
   * @return �N��R���e�i
   */
  public ACBackLabelContainer getAgeContainer(){
    if(ageContainer==null){

      ageContainer = new ACBackLabelContainer();

      addAgeContainer();
    }
    return ageContainer;

  }

  /**
   * �N��^�C�g�����擾���܂��B
   * @return �N��^�C�g��
   */
  public ACLabel getAgeContainerTItle(){
    if(ageContainerTItle==null){

      ageContainerTItle = new ACLabel();

      ageContainerTItle.setText("�N��");

      addAgeContainerTItle();
    }
    return ageContainerTItle;

  }

  /**
   * �N��w��e�L�X�g�i�J�n�j���擾���܂��B
   * @return �N��w��e�L�X�g�i�J�n�j
   */
  public ACTextField getAgeStartText(){
    if(ageStartText==null){

      ageStartText = new ACTextField();

      ageStartText.setBindPath("AGE_START");

      ageStartText.setColumns(3);

      ageStartText.setIMEMode(InputSubset.LATIN);

      ageStartText.setMaxLength(3);

      addAgeStartText();
    }
    return ageStartText;

  }

  /**
   * �N��w��e�L�X�g�i�J�n�j�R���e�i���擾���܂��B
   * @return �N��w��e�L�X�g�i�J�n�j�R���e�i
   */
  protected ACLabelContainer getAgeStartTextContainer(){
    if(ageStartTextContainer==null){
      ageStartTextContainer = new ACLabelContainer();
      ageStartTextContainer.setFollowChildEnabled(true);
      ageStartTextContainer.setVAlignment(VRLayout.CENTER);
      ageStartTextContainer.add(getAgeStartText(), null);
    }
    return ageStartTextContainer;
  }

  /**
   * �N��x�����擾���܂��B
   * @return �N��x��
   */
  public ACLabel getAgeConnectLabel(){
    if(ageConnectLabel==null){

      ageConnectLabel = new ACLabel();

      ageConnectLabel.setText("�`");

      addAgeConnectLabel();
    }
    return ageConnectLabel;

  }

  /**
   * �N��w��e�L�X�g�i�I���j���擾���܂��B
   * @return �N��w��e�L�X�g�i�I���j
   */
  public ACTextField getAgeEndText(){
    if(ageEndText==null){

      ageEndText = new ACTextField();

      ageEndText.setBindPath("AGE_END");

      ageEndText.setColumns(3);

      ageEndText.setIMEMode(InputSubset.LATIN);

      ageEndText.setMaxLength(3);

      addAgeEndText();
    }
    return ageEndText;

  }

  /**
   * �N��w��e�L�X�g�i�I���j�R���e�i���擾���܂��B
   * @return �N��w��e�L�X�g�i�I���j�R���e�i
   */
  protected ACLabelContainer getAgeEndTextContainer(){
    if(ageEndTextContainer==null){
      ageEndTextContainer = new ACLabelContainer();
      ageEndTextContainer.setFollowChildEnabled(true);
      ageEndTextContainer.setVAlignment(VRLayout.CENTER);
      ageEndTextContainer.add(getAgeEndText(), null);
    }
    return ageEndTextContainer;
  }

  /**
   * �N��I�����x�����擾���܂��B
   * @return �N��I�����x��
   */
  public ACLabel getAgeLabel(){
    if(ageLabel==null){

      ageLabel = new ACLabel();

      ageLabel.setText("��");

      addAgeLabel();
    }
    return ageLabel;

  }

  /**
   * �o�^�ςݏ��O�`�F�b�N���擾���܂��B
   * @return �o�^�ςݏ��O�`�F�b�N
   */
  public ACIntegerCheckBox getDeduplicationCheck(){
    if(deduplicationCheck==null){

      deduplicationCheck = new ACIntegerCheckBox();

      deduplicationCheck.setText("�o�^�ς݂̊��҂����O");

      deduplicationCheck.setBindPath("DEDUPLICATION");

      addDeduplicationCheck();
    }
    return deduplicationCheck;

  }

  /**
   * ��荞�ݐݒ���擾���܂��B
   * @return ��荞�ݐݒ�
   */
  public ACGroupBox getImportSettings(){
    if(importSettings==null){

      importSettings = new ACGroupBox();

      importSettings.setText("��荞�ݐݒ�");

      importSettings.setLabelMargin(0);

      importSettings.setVgap(0);

      addImportSettings();
    }
    return importSettings;

  }

  /**
   * �捞�ݒ�p�l�����擾���܂��B
   * @return �捞�ݒ�p�l��
   */
  public ACPanel getImportPanel(){
    if(importPanel==null){

      importPanel = new ACPanel();

      importPanel.setHgap(0);

      importPanel.setLabelMargin(0);

      importPanel.setVgap(0);

      addImportPanel();
    }
    return importPanel;

  }

  /**
   * �J�i�w�����Ђ炪�Ȃɕϊ����擾���܂��B
   * @return �J�i�w�����Ђ炪�Ȃɕϊ�
   */
  public ACIntegerCheckBox getToHiragana(){
    if(toHiragana==null){

      toHiragana = new ACIntegerCheckBox();

      toHiragana.setText("�J�i�������Ђ炪�Ȃɕϊ�");

      toHiragana.setBindPath("TO_HIRAGANA");

      addToHiragana();
    }
    return toHiragana;

  }

  /**
   * 500���ڈȍ~�̊��҂���荞�ނ��擾���܂��B
   * @return 500���ڈȍ~�̊��҂���荞��
   */
  public ACIntegerCheckBox getAllPageCheck(){
    if(allPageCheck==null){

      allPageCheck = new ACIntegerCheckBox();

      allPageCheck.setText("500���ڈȍ~�̊��҂���荞��");

      allPageCheck.setBindPath("ALLPAGE");

      addAllPageCheck();
    }
    return allPageCheck;

  }

  /**
   * �O�ւ��擾���܂��B
   * @return �O��
   */
  public ACButton getPreviewPage(){
    if(previewPage==null){

      previewPage = new ACButton();

      previewPage.setText("�O��");

      addPreviewPage();
    }
    return previewPage;

  }

  /**
   * ���ւ��擾���܂��B
   * @return ����
   */
  public ACButton getNextPage(){
    if(nextPage==null){

      nextPage = new ACButton();

      nextPage.setText("����");

      addNextPage();
    }
    return nextPage;

  }

  /**
   * �����\�����擾���܂��B
   * @return �����\��
   */
  public ACPanel getViewRange(){
    if(viewRange==null){

      viewRange = new ACPanel();

      viewRange.setAutoWrap(false);

      addViewRange();
    }
    return viewRange;

  }

  /**
   * �S�̌������擾���܂��B
   * @return �S�̌���
   */
  public ACLabel getTotalCount(){
    if(totalCount==null){

      totalCount = new ACLabel();

      totalCount.setText("0");

      addTotalCount();
    }
    return totalCount;

  }

  /**
   * �������擾���܂��B
   * @return ����
   */
  public ACLabel getTotalCountUnit(){
    if(totalCountUnit==null){

      totalCountUnit = new ACLabel();

      totalCountUnit.setText("����");

      addTotalCountUnit();
    }
    return totalCountUnit;

  }

  /**
   * �\���J�n�ԍ����擾���܂��B
   * @return �\���J�n�ԍ�
   */
  public ACLabel getViewBeginNo(){
    if(viewBeginNo==null){

      viewBeginNo = new ACLabel();

      viewBeginNo.setText("0");

      addViewBeginNo();
    }
    return viewBeginNo;

  }

  /**
   * �\���ԍ��͈͂��擾���܂��B
   * @return �\���ԍ��͈�
   */
  public ACLabel getViewSpan(){
    if(viewSpan==null){

      viewSpan = new ACLabel();

      viewSpan.setText("-");

      addViewSpan();
    }
    return viewSpan;

  }

  /**
   * �\���I���ԍ����擾���܂��B
   * @return �\���I���ԍ�
   */
  public ACLabel getViewEndNo(){
    if(viewEndNo==null){

      viewEndNo = new ACLabel();

      viewEndNo.setText("0");

      addViewEndNo();
    }
    return viewEndNo;

  }

  /**
   * ���p�҈ꗗ���擾���܂��B
   * @return ���p�҈ꗗ
   */
  public ACTable getPatients(){
    if(patients==null){

      patients = new ACTable();

      patients.setColumnModel(getPatientsColumnModel());

      addPatients();
    }
    return patients;

  }

  /**
   * ���p�҈ꗗ�J�������f�����擾���܂��B
   * @return ���p�҈ꗗ�J�������f��
   */
  protected VRTableColumnModel getPatientsColumnModel(){
    if(patientsColumnModel==null){
      patientsColumnModel = new VRTableColumnModel(new TableColumn[]{});
      addPatientsColumnModel();
    }
    return patientsColumnModel;
  }

  /**
   * No.���擾���܂��B
   * @return No.
   */
  public ACTableColumn getPatientNo(){
    if(patientNo==null){

      patientNo = new ACTableColumn();

      patientNo.setHeaderValue("No.");

      patientNo.setColumnName("SERIAL_ID");

      patientNo.setColumns(3);

      addPatientNo();
    }
    return patientNo;

  }

  /**
   * �Ώۂ��擾���܂��B
   * @return �Ώ�
   */
  public ACTableColumn getPatientImport(){
    if(patientImport==null){

      patientImport = new ACTableColumn();

      patientImport.setColumnName("IMPORT_FLAG");

      patientImport.setEditable(true);

      patientImport.setColumns(3);

      patientImport.setHorizontalAlignment(SwingConstants.CENTER);

      patientImport.setRendererType(VRTableCellViewer.RENDERER_TYPE_CHECK_BOX);

      patientImport.setEditorType(VRTableCellViewer.EDITOR_TYPE_CHECK_BOX);

      patientImport.setHeaderPopupMenu( new ACCheckBoxTableColumnPopupMenu(getPatients(), "IMPORT_FLAG", new Boolean(true), new Boolean(false)) );

      addPatientImport();
    }
    return patientImport;

  }

  /**
   * �d�����擾���܂��B
   * @return �d��
   */
  public ACTableColumn getPatientBatting(){
    if(patientBatting==null){

      patientBatting = new ACTableColumn();

      patientBatting.setHeaderValue("�d��");

      patientBatting.setColumnName("BATTING_FLAG");

      patientBatting.setColumns(4);

      addPatientBatting();
    }
    return patientBatting;

  }

  /**
   * �������擾���܂��B
   * @return ����
   */
  public ACTableColumn getPatientName(){
    if(patientName==null){

      patientName = new ACTableColumn();

      patientName.setHeaderValue("����");

      patientName.setColumnName("PATIENT_FAMILY_NAME+'�@'+PATIENT_FIRST_NAME");

      patientName.setColumns(9);

      addPatientName();
    }
    return patientName;

  }

  /**
   * �ӂ肪�Ȃ��擾���܂��B
   * @return �ӂ肪��
   */
  public ACTableColumn getPatientKana(){
    if(patientKana==null){

      patientKana = new ACTableColumn();

      patientKana.setHeaderValue("�ӂ肪��");

      patientKana.setColumnName("PATIENT_FAMILY_KANA+'�@'+PATIENT_FIRST_KANA");

      patientKana.setColumns(15);

      addPatientKana();
    }
    return patientKana;

  }

  /**
   * ���ʂ��擾���܂��B
   * @return ����
   */
  public ACTableColumn getPatientSex(){
    if(patientSex==null){

      patientSex = new ACTableColumn();

      patientSex.setHeaderValue("����");

      patientSex.setColumnName("PATIENT_SEX");

      patientSex.setColumns(3);

      patientSex.setHorizontalAlignment(SwingConstants.CENTER);

      patientSex.setFormat(QkanConstants.FORMAT_SEX);

      addPatientSex();
    }
    return patientSex;

  }

  /**
   * �N����擾���܂��B
   * @return �N��
   */
  public ACTableColumn getPatientAge(){
    if(patientAge==null){

      patientAge = new ACTableColumn();

      patientAge.setHeaderValue("�N��");

      patientAge.setColumnName("PATIENT_BIRTHDAY");

      patientAge.setColumns(3);

      patientAge.setHorizontalAlignment(SwingConstants.RIGHT);

      patientAge.setFormat(QkanConstants.FORMAT_NOW_AGE);

      addPatientAge();
    }
    return patientAge;

  }

  /**
   * ���N�������擾���܂��B
   * @return ���N����
   */
  public ACTableColumn getPatientBirth(){
    if(patientBirth==null){

      patientBirth = new ACTableColumn();

      patientBirth.setHeaderValue("���N����");

      patientBirth.setColumnName("PATIENT_BIRTHDAY");

      patientBirth.setColumns(10);

      patientBirth.setFormat(new ACBorderBlankDateFormat("gggee�NMM��dd��"));

      addPatientBirth();
    }
    return patientBirth;

  }

  /**
   * �X�֔ԍ����擾���܂��B
   * @return �X�֔ԍ�
   */
  public ACTableColumn getPatientZip(){
    if(patientZip==null){

      patientZip = new ACTableColumn();

      patientZip.setHeaderValue("�X�֔ԍ�");

      patientZip.setColumnName("PATIENT_ZIP_FIRST+'-'+PATIENT_ZIP_SECOND");

      patientZip.setColumns(6);

      addPatientZip();
    }
    return patientZip;

  }

  /**
   * �Z�����擾���܂��B
   * @return �Z��
   */
  public ACTableColumn getPatientAddress(){
    if(patientAddress==null){

      patientAddress = new ACTableColumn();

      patientAddress.setHeaderValue("�Z��");

      patientAddress.setColumnName("PATIENT_ADDRESS");

      patientAddress.setColumns(20);

      addPatientAddress();
    }
    return patientAddress;

  }

  /**
   * �A����(TEL)���擾���܂��B
   * @return �A����(TEL)
   */
  public ACTableColumn getPatientTel(){
    if(patientTel==null){

      patientTel = new ACTableColumn();

      patientTel.setHeaderValue("�A����(TEL)");

      patientTel.setColumnName("PATIENT_TEL_FIRST+'-'+PATIENT_TEL_SECOND+'-'+PATIENT_TEL_THIRD");

      patientTel.setColumns(20);

      addPatientTel();
    }
    return patientTel;

  }

  /**
   * �R���X�g���N�^�ł��B
   */
  public QO013Design() {

    try {
      initialize();

    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g�̐ݒ���s�Ȃ��܂��B
   */
  protected void initThis(){
  }

  /**
   * this�ɓ������ڂ�ǉ����܂��B
   */
  protected void addThis(){

    this.add(getButtons(), VRLayout.NORTH);

    this.add(getConnectSettings(), VRLayout.NORTH);

    this.add(getFindSetting(), VRLayout.NORTH);

    this.add(getImportSettings(), VRLayout.NORTH);

    this.add(getPatients(), VRLayout.CLIENT);

  }

  /**
   * �Ɩ��{�^���o�[�ɓ������ڂ�ǉ����܂��B
   */
  protected void addButtons(){

    buttons.add(getImportPatient(), VRLayout.EAST);
    buttons.add(getConnect(), VRLayout.EAST);
  }

  /**
   * �ʐM�ɓ������ڂ�ǉ����܂��B
   */
  protected void addConnect(){

  }

  /**
   * ��荞�݂ɓ������ڂ�ǉ����܂��B
   */
  protected void addImportPatient(){

  }

  /**
   * �ڑ��ݒ�ɓ������ڂ�ǉ����܂��B
   */
  protected void addConnectSettings(){

    connectSettings.add(getHostNameContainer(), VRLayout.FLOW_INSETLINE);

    connectSettings.add(getPortNoContainer(), VRLayout.FLOW_INSETLINE);

    connectSettings.add(getDbsVersionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    connectSettings.add(getUserNameContainer(), VRLayout.FLOW_INSETLINE);

    connectSettings.add(getPasswordContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    connectSettings.add(getReceiptVersionComboContainer(), VRLayout.FLOW_INSETLINE);

  }

  /**
   * �ڑ���z�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHostName(){

  }

  /**
   * �|�[�g�ԍ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addPortNo(){

  }

  /**
   * DBS�o�[�W�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addDbsVersion(){

  }

  /**
   * ���[�U�[���ɓ������ڂ�ǉ����܂��B
   */
  protected void addUserName(){

  }

  /**
   * �p�X���[�h�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPassword(){

  }

  /**
   * ����W�����Z�v�g�\�t�g�o�[�W�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addReceiptVersionCombo(){

  }

  /**
   * ����W�����Z�v�g�\�t�g�o�[�W�������f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addReceiptVersionComboModel(){

  }

  /**
   * �擾�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addFindSetting(){

    findSetting.add(getAgeContainer(), VRLayout.FLOW_INSETLINE);

    findSetting.add(getDeduplicationCheck(), VRLayout.FLOW_INSETLINE);

  }

  /**
   * �N��R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addAgeContainer(){

    ageContainer.add(getAgeContainerTItle(), VRLayout.FLOW);

    ageContainer.add(getAgeStartTextContainer(), VRLayout.FLOW);

    ageContainer.add(getAgeConnectLabel(), VRLayout.FLOW);

    ageContainer.add(getAgeEndTextContainer(), VRLayout.FLOW);

    ageContainer.add(getAgeLabel(), VRLayout.FLOW);

  }

  /**
   * �N��^�C�g���ɓ������ڂ�ǉ����܂��B
   */
  protected void addAgeContainerTItle(){

  }

  /**
   * �N��w��e�L�X�g�i�J�n�j�ɓ������ڂ�ǉ����܂��B
   */
  protected void addAgeStartText(){

  }

  /**
   * �N��x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addAgeConnectLabel(){

  }

  /**
   * �N��w��e�L�X�g�i�I���j�ɓ������ڂ�ǉ����܂��B
   */
  protected void addAgeEndText(){

  }

  /**
   * �N��I�����x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addAgeLabel(){

  }

  /**
   * �o�^�ςݏ��O�`�F�b�N�ɓ������ڂ�ǉ����܂��B
   */
  protected void addDeduplicationCheck(){

  }

  /**
   * ��荞�ݐݒ�ɓ������ڂ�ǉ����܂��B
   */
  protected void addImportSettings(){

    importSettings.add(getImportPanel(), VRLayout.FLOW);

    importSettings.add(getPreviewPage(), VRLayout.FLOW);

    importSettings.add(getNextPage(), VRLayout.FLOW);

    importSettings.add(getViewRange(), VRLayout.FLOW);

  }

  /**
   * �捞�ݒ�p�l���ɓ������ڂ�ǉ����܂��B
   */
  protected void addImportPanel(){

    importPanel.add(getToHiragana(), VRLayout.FLOW_INSETLINE_RETURN);

    importPanel.add(getAllPageCheck(), VRLayout.FLOW_INSETLINE);

  }

  /**
   * �J�i�w�����Ђ炪�Ȃɕϊ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addToHiragana(){

  }

  /**
   * 500���ڈȍ~�̊��҂���荞�ނɓ������ڂ�ǉ����܂��B
   */
  protected void addAllPageCheck(){

  }

  /**
   * �O�ւɓ������ڂ�ǉ����܂��B
   */
  protected void addPreviewPage(){

  }

  /**
   * ���ւɓ������ڂ�ǉ����܂��B
   */
  protected void addNextPage(){

  }

  /**
   * �����\���ɓ������ڂ�ǉ����܂��B
   */
  protected void addViewRange(){

    viewRange.add(getTotalCount(), null);

    viewRange.add(getTotalCountUnit(), null);

    viewRange.add(getViewBeginNo(), null);

    viewRange.add(getViewSpan(), null);

    viewRange.add(getViewEndNo(), null);

  }

  /**
   * �S�̌����ɓ������ڂ�ǉ����܂��B
   */
  protected void addTotalCount(){

  }

  /**
   * �����ɓ������ڂ�ǉ����܂��B
   */
  protected void addTotalCountUnit(){

  }

  /**
   * �\���J�n�ԍ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addViewBeginNo(){

  }

  /**
   * �\���ԍ��͈͂ɓ������ڂ�ǉ����܂��B
   */
  protected void addViewSpan(){

  }

  /**
   * �\���I���ԍ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addViewEndNo(){

  }

  /**
   * ���p�҈ꗗ�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatients(){

  }

  /**
   * ���p�҈ꗗ�J�������f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatientsColumnModel(){

    getPatientsColumnModel().addColumn(getPatientNo());

    getPatientsColumnModel().addColumn(getPatientImport());

    getPatientsColumnModel().addColumn(getPatientBatting());

    getPatientsColumnModel().addColumn(getPatientName());

    getPatientsColumnModel().addColumn(getPatientKana());

    getPatientsColumnModel().addColumn(getPatientSex());

    getPatientsColumnModel().addColumn(getPatientAge());

    getPatientsColumnModel().addColumn(getPatientBirth());

    getPatientsColumnModel().addColumn(getPatientZip());

    getPatientsColumnModel().addColumn(getPatientAddress());

    getPatientsColumnModel().addColumn(getPatientTel());

  }

  /**
   * No.�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatientNo(){

  }

  /**
   * �Ώۂɓ������ڂ�ǉ����܂��B
   */
  protected void addPatientImport(){

  }

  /**
   * �d���ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatientBatting(){

  }

  /**
   * �����ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatientName(){

  }

  /**
   * �ӂ肪�Ȃɓ������ڂ�ǉ����܂��B
   */
  protected void addPatientKana(){

  }

  /**
   * ���ʂɓ������ڂ�ǉ����܂��B
   */
  protected void addPatientSex(){

  }

  /**
   * �N��ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatientAge(){

  }

  /**
   * ���N�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatientBirth(){

  }

  /**
   * �X�֔ԍ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatientZip(){

  }

  /**
   * �Z���ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatientAddress(){

  }

  /**
   * �A����(TEL)�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatientTel(){

  }

  /**
   * �R���|�[�l���g�����������܂��B
   * @throws Exception ��������O
   */
  private void initialize() throws Exception {
    initThis();
    addThis();
  }
  public boolean canBack(VRMap parameters) throws Exception {
    return true;
  }
  public Component getFirstFocusComponent() {

    return getConnect();

  }
  public void initAffair(ACAffairInfo affair) throws Exception {
  }

  public static void main(String[] args) {
    //�f�t�H���g�f�o�b�O�N��
    try {
      ACFrame.getInstance().setFrameEventProcesser(new QkanFrameEventProcesser());
      ACFrame.debugStart(new ACAffairInfo(QO013Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QO013Design getThis() {
    return this;
  }
}
