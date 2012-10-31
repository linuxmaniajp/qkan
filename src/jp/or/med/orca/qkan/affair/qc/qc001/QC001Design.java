
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
 * �쐬��: 2012/09/21  ���{�R���s���[�^�[������� �� ���� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���[�Ǘ� (C)
 * �v���Z�X �K��Ō�v�揑 (001)
 * �v���O���� �K��Ō�v�揑 (QC001)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qc.qc001;
import java.awt.Color;
import java.awt.Component;
import java.awt.im.InputSubset;

import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.table.TableColumn;

import jp.nichicom.ac.ACConstants;
import jp.nichicom.ac.component.ACAffairButton;
import jp.nichicom.ac.component.ACAffairButtonBar;
import jp.nichicom.ac.component.ACButton;
import jp.nichicom.ac.component.ACComboBox;
import jp.nichicom.ac.component.ACLabel;
import jp.nichicom.ac.component.ACRadioButtonItem;
import jp.nichicom.ac.component.ACTextArea;
import jp.nichicom.ac.component.ACTextField;
import jp.nichicom.ac.component.ACValueArrayRadioButtonGroup;
import jp.nichicom.ac.component.table.ACTable;
import jp.nichicom.ac.component.table.ACTableCellViewer;
import jp.nichicom.ac.component.table.ACTableColumn;
import jp.nichicom.ac.container.ACGroupBox;
import jp.nichicom.ac.container.ACLabelContainer;
import jp.nichicom.ac.container.ACPanel;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACAffairable;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.util.adapter.ACComboBoxModelAdapter;
import jp.nichicom.ac.util.adapter.ACListModelAdapter;
import jp.nichicom.vr.component.table.VRTableColumnModel;
import jp.nichicom.vr.layout.VRLayout;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.affair.QkanAffairContainer;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.component.QkanDateTextField;
/**
 * �K��Ō�v�揑��ʍ��ڃf�U�C��(QC001) 
 */
public class QC001Design extends QkanAffairContainer implements ACAffairable {
  //GUI�R���|�[�l���g

  private ACAffairButtonBar buttons;

  private ACAffairButton open;

  private ACAffairButton insert;

  private ACAffairButton update;

  private ACAffairButton print;

  private ACPanel contents;

  private ACPanel targetDates;

  private ACLabel targetDateCaption;

  private ACLabel targetDate;

  private ACPanel infos;

  private ACGroupBox patients;

  private ACTextField patientName;

  private ACLabelContainer patientNameContainer;

  private ACLabelContainer patientBirthContainer;

  private QkanDateTextField patientBirth;

  private ACTextField patientAge;

  private ACLabel patientAgeLabel;

  private ACValueArrayRadioButtonGroup yokaigodo;

  private ACLabelContainer yokaigodoContainer;

  private ACListModelAdapter yokaigodoModel;

  private ACRadioButtonItem yokaigodoRadioItem1;

  private ACRadioButtonItem yokaigodoRadioItem2;

  private ACRadioButtonItem yokaigodoRadioItem3;

  private ACRadioButtonItem yokaigodoRadioItem4;

  private ACRadioButtonItem yokaigodoRadioItem5;

  private ACRadioButtonItem yokaigodoRadioItem6;

  private ACRadioButtonItem yokaigodoRadioItem7;

  private ACRadioButtonItem yokaigodoRadioItem8;

  private ACRadioButtonItem yokaigodoRadioItem9;

  private ACTextField patientAddress;

  private ACLabelContainer patientAddressContainer;

  private ACTextField doctorName;

  private ACLabelContainer doctorNameContainer;

  private ACGroupBox stations;

  private QkanDateTextField createDate;

  private ACLabelContainer createDateContainer;

  private ACComboBox providerName;

  private ACLabelContainer providerNameContainer;

  private ACComboBoxModelAdapter providerNameModel;

  private ACTextField administratorName;

  private ACLabelContainer administratorNameContainer;

  private JTabbedPane tabs;

  private ACPanel tabPurposes;

  private ACGroupBox planPurposes;

  private ACTextArea planPurpose;

  private ACLabelContainer planPurposeContainer;

  private ACGroupBox planComments;

  private ACTextArea planComment;

  private ACLabelContainer planCommentContainer;

  private ACPanel tabsNotes;

  private ACPanel planNoteAreas;

  private ACTable planNotes;

  private VRTableColumnModel planNotesColumnModel;

  private ACTableColumn planNotesColumn0;

  private ACTableColumn planNotesColumn1;

  private ACTableColumn planNotesColumn2;

  private ACTableColumn planNotesColumn3;

  private ACGroupBox planNoteEdits;

  private ACPanel planPanel;

  private ACPanel planNoteEditDates;

  private QkanDateTextField planNoteEditDate;

  private ACLabelContainer planNoteEditDateContainer;

  private ACGroupBox planNoteEditComments;

  private ACTextArea planNoteEditComment;

  private ACLabelContainer planNoteEditCommentContainer;

  private ACGroupBox planAssessmentEditComments;

  private ACTextArea planAssessmentEditComment;

  private ACLabelContainer planAssessmentEditCommentContainer;

  private ACPanel planNoteEditButtons;

  private ACButton planNoteEditButtonAdd;

  private ACButton planNoteEditButtonEdit;

  private ACButton planNoteEditButtonDelete;

  private ACButton planNoteEditButtonClear;

  //getter

  /**
   * �{�^���o�[���擾���܂��B
   * @return �{�^���o�[
   */
  public ACAffairButtonBar getButtons(){
    if(buttons==null){

      buttons = new ACAffairButtonBar();

      buttons.setText("�K��Ō�v�揑");

      addButtons();
    }
    return buttons;

  }

  /**
   * �O��Ǎ����擾���܂��B
   * @return �O��Ǎ�
   */
  public ACAffairButton getOpen(){
    if(open==null){

      open = new ACAffairButton();

      open.setText("�O��Ǎ�(O)");

      open.setToolTipText("�ߋ��̃f�[�^�̒��ŁA�ŐV�̃f�[�^�������p���܂��B");

      open.setMnemonic('O');

      open.setIconPath(ACConstants.ICON_PATH_OPEN_24);

      addOpen();
    }
    return open;

  }

  /**
   * �o�^���擾���܂��B
   * @return �o�^
   */
  public ACAffairButton getInsert(){
    if(insert==null){

      insert = new ACAffairButton();

      insert.setText("�o�^(S)");

      insert.setToolTipText("���݂̓��e��o�^���܂��B");

      insert.setMnemonic('S');

      insert.setIconPath(ACConstants.ICON_PATH_UPDATE_24);

      addInsert();
    }
    return insert;

  }

  /**
   * �X�V���擾���܂��B
   * @return �X�V
   */
  public ACAffairButton getUpdate(){
    if(update==null){

      update = new ACAffairButton();

      update.setText("�X�V(S)");

      update.setToolTipText("���݂̓��e���X�V���܂��B");

      update.setMnemonic('S');

      update.setIconPath(ACConstants.ICON_PATH_UPDATE_24);

      addUpdate();
    }
    return update;

  }

  /**
   * ������擾���܂��B
   * @return ���
   */
  public ACAffairButton getPrint(){
    if(print==null){

      print = new ACAffairButton();

      print.setText("���(P)");

      print.setToolTipText("�u�K��Ō�v�揑�v��������܂��B");

      print.setMnemonic('P');

      print.setIconPath(ACConstants.ICON_PATH_PRINT_24);

      addPrint();
    }
    return print;

  }

  /**
   * �N���C�A���g�̈���擾���܂��B
   * @return �N���C�A���g�̈�
   */
  public ACPanel getContents(){
    if(contents==null){

      contents = new ACPanel();

      addContents();
    }
    return contents;

  }

  /**
   * �Ώ۔N���̈���擾���܂��B
   * @return �Ώ۔N���̈�
   */
  public ACPanel getTargetDates(){
    if(targetDates==null){

      targetDates = new ACPanel();

      addTargetDates();
    }
    return targetDates;

  }

  /**
   * �Ώ۔N���L���v�V�������擾���܂��B
   * @return �Ώ۔N���L���v�V����
   */
  public ACLabel getTargetDateCaption(){
    if(targetDateCaption==null){

      targetDateCaption = new ACLabel();

      targetDateCaption.setText("�Ώ۔N���F");

      targetDateCaption.setForeground(Color.blue);

      targetDateCaption.setHorizontalAlignment(SwingConstants.RIGHT);

      addTargetDateCaption();
    }
    return targetDateCaption;

  }

  /**
   * �Ώ۔N�����擾���܂��B
   * @return �Ώ۔N��
   */
  public ACLabel getTargetDate(){
    if(targetDate==null){

      targetDate = new ACLabel();

      targetDate.setForeground(Color.blue);

      targetDate.setHorizontalAlignment(SwingConstants.LEFT);

      addTargetDate();
    }
    return targetDate;

  }

  /**
   * ���̈���擾���܂��B
   * @return ���̈�
   */
  public ACPanel getInfos(){
    if(infos==null){

      infos = new ACPanel();

      addInfos();
    }
    return infos;

  }

  /**
   * ���p�ҏ��̈���擾���܂��B
   * @return ���p�ҏ��̈�
   */
  public ACGroupBox getPatients(){
    if(patients==null){

      patients = new ACGroupBox();

      patients.setText("���p��");

      addPatients();
    }
    return patients;

  }

  /**
   * �������擾���܂��B
   * @return ����
   */
  public ACTextField getPatientName(){
    if(patientName==null){

      patientName = new ACTextField();

      getPatientNameContainer().setText("����");

      patientName.setBindPath("PATIENT_NAME");

      patientName.setEditable(false);

      patientName.setColumns(26);

      patientName.setIMEMode(InputSubset.KANJI);

      patientName.setMaxLength(26);

      addPatientName();
    }
    return patientName;

  }

  /**
   * �����R���e�i���擾���܂��B
   * @return �����R���e�i
   */
  protected ACLabelContainer getPatientNameContainer(){
    if(patientNameContainer==null){
      patientNameContainer = new ACLabelContainer();
      patientNameContainer.setFollowChildEnabled(true);
      patientNameContainer.setVAlignment(VRLayout.CENTER);
      patientNameContainer.add(getPatientName(), null);
    }
    return patientNameContainer;
  }

  /**
   * ���N�����R���e�i���擾���܂��B
   * @return ���N�����R���e�i
   */
  public ACLabelContainer getPatientBirthContainer(){
    if(patientBirthContainer==null){

      patientBirthContainer = new ACLabelContainer();

      patientBirthContainer.setText("���N����");

      addPatientBirthContainer();
    }
    return patientBirthContainer;

  }

  /**
   * ���N�������擾���܂��B
   * @return ���N����
   */
  public QkanDateTextField getPatientBirth(){
    if(patientBirth==null){

      patientBirth = new QkanDateTextField();

      patientBirth.setBindPath("PATIENT_BIRTHDAY");

      patientBirth.setEditable(false);

      addPatientBirth();
    }
    return patientBirth;

  }

  /**
   * �N����擾���܂��B
   * @return �N��
   */
  public ACTextField getPatientAge(){
    if(patientAge==null){

      patientAge = new ACTextField();

      patientAge.setBindPath("PATIENT_AGE");

      patientAge.setEditable(false);

      patientAge.setMaxLength(5);

      addPatientAge();
    }
    return patientAge;

  }

  /**
   * �΂��擾���܂��B
   * @return ��
   */
  public ACLabel getPatientAgeLabel(){
    if(patientAgeLabel==null){

      patientAgeLabel = new ACLabel();

      patientAgeLabel.setText("��");

      addPatientAgeLabel();
    }
    return patientAgeLabel;

  }

  /**
   * �v���F����擾���܂��B
   * @return �v���F��
   */
  public ACValueArrayRadioButtonGroup getYokaigodo(){
    if(yokaigodo==null){

      yokaigodo = new ACValueArrayRadioButtonGroup();

      getYokaigodoContainer().setText("�v���F��");

      yokaigodo.setBindPath("JOTAI_CODE");

      yokaigodo.setNoSelectIndex(0);

      yokaigodo.setUseClearButton(false);

      yokaigodo.setModel(getYokaigodoModel());

      yokaigodo.setValues(new int[]{1,12,13,11,21,22,23,24,25});

      addYokaigodo();
    }
    return yokaigodo;

  }

  /**
   * �v���F��R���e�i���擾���܂��B
   * @return �v���F��R���e�i
   */
  protected ACLabelContainer getYokaigodoContainer(){
    if(yokaigodoContainer==null){
      yokaigodoContainer = new ACLabelContainer();
      yokaigodoContainer.setFollowChildEnabled(true);
      yokaigodoContainer.setVAlignment(VRLayout.CENTER);
      yokaigodoContainer.add(getYokaigodo(), null);
    }
    return yokaigodoContainer;
  }

  /**
   * �v���F�胂�f�����擾���܂��B
   * @return �v���F�胂�f��
   */
  protected ACListModelAdapter getYokaigodoModel(){
    if(yokaigodoModel==null){
      yokaigodoModel = new ACListModelAdapter();
      addYokaigodoModel();
    }
    return yokaigodoModel;
  }

  /**
   * �������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getYokaigodoRadioItem1(){
    if(yokaigodoRadioItem1==null){

      yokaigodoRadioItem1 = new ACRadioButtonItem();

      yokaigodoRadioItem1.setText("����");

      yokaigodoRadioItem1.setGroup(getYokaigodo());

      yokaigodoRadioItem1.setConstraints(VRLayout.FLOW);

      addYokaigodoRadioItem1();
    }
    return yokaigodoRadioItem1;

  }

  /**
   * �v�x���P���擾���܂��B
   * @return �v�x���P
   */
  public ACRadioButtonItem getYokaigodoRadioItem2(){
    if(yokaigodoRadioItem2==null){

      yokaigodoRadioItem2 = new ACRadioButtonItem();

      yokaigodoRadioItem2.setText("�v�x��1");

      yokaigodoRadioItem2.setGroup(getYokaigodo());

      yokaigodoRadioItem2.setConstraints(VRLayout.FLOW);

      addYokaigodoRadioItem2();
    }
    return yokaigodoRadioItem2;

  }

  /**
   * �v�x���Q���擾���܂��B
   * @return �v�x���Q
   */
  public ACRadioButtonItem getYokaigodoRadioItem3(){
    if(yokaigodoRadioItem3==null){

      yokaigodoRadioItem3 = new ACRadioButtonItem();

      yokaigodoRadioItem3.setText("�v�x��2");

      yokaigodoRadioItem3.setGroup(getYokaigodo());

      yokaigodoRadioItem3.setConstraints(VRLayout.FLOW_RETURN);

      addYokaigodoRadioItem3();
    }
    return yokaigodoRadioItem3;

  }

  /**
   * �o�ߓI�v�����擾���܂��B
   * @return �o�ߓI�v���
   */
  public ACRadioButtonItem getYokaigodoRadioItem4(){
    if(yokaigodoRadioItem4==null){

      yokaigodoRadioItem4 = new ACRadioButtonItem();

      yokaigodoRadioItem4.setText("�o�ߓI�v���");

      yokaigodoRadioItem4.setGroup(getYokaigodo());

      yokaigodoRadioItem4.setConstraints(VRLayout.FLOW);

      addYokaigodoRadioItem4();
    }
    return yokaigodoRadioItem4;

  }

  /**
   * �v���1���擾���܂��B
   * @return �v���1
   */
  public ACRadioButtonItem getYokaigodoRadioItem5(){
    if(yokaigodoRadioItem5==null){

      yokaigodoRadioItem5 = new ACRadioButtonItem();

      yokaigodoRadioItem5.setText("�v���1");

      yokaigodoRadioItem5.setGroup(getYokaigodo());

      yokaigodoRadioItem5.setConstraints(VRLayout.FLOW);

      addYokaigodoRadioItem5();
    }
    return yokaigodoRadioItem5;

  }

  /**
   * �v���2���擾���܂��B
   * @return �v���2
   */
  public ACRadioButtonItem getYokaigodoRadioItem6(){
    if(yokaigodoRadioItem6==null){

      yokaigodoRadioItem6 = new ACRadioButtonItem();

      yokaigodoRadioItem6.setText("�v���2");

      yokaigodoRadioItem6.setGroup(getYokaigodo());

      yokaigodoRadioItem6.setConstraints(VRLayout.FLOW);

      addYokaigodoRadioItem6();
    }
    return yokaigodoRadioItem6;

  }

  /**
   * �v���3���擾���܂��B
   * @return �v���3
   */
  public ACRadioButtonItem getYokaigodoRadioItem7(){
    if(yokaigodoRadioItem7==null){

      yokaigodoRadioItem7 = new ACRadioButtonItem();

      yokaigodoRadioItem7.setText("�v���3");

      yokaigodoRadioItem7.setGroup(getYokaigodo());

      yokaigodoRadioItem7.setConstraints(VRLayout.FLOW);

      addYokaigodoRadioItem7();
    }
    return yokaigodoRadioItem7;

  }

  /**
   * �v���4���擾���܂��B
   * @return �v���4
   */
  public ACRadioButtonItem getYokaigodoRadioItem8(){
    if(yokaigodoRadioItem8==null){

      yokaigodoRadioItem8 = new ACRadioButtonItem();

      yokaigodoRadioItem8.setText("�v���4");

      yokaigodoRadioItem8.setGroup(getYokaigodo());

      yokaigodoRadioItem8.setConstraints(VRLayout.FLOW);

      addYokaigodoRadioItem8();
    }
    return yokaigodoRadioItem8;

  }

  /**
   * �v���5���擾���܂��B
   * @return �v���5
   */
  public ACRadioButtonItem getYokaigodoRadioItem9(){
    if(yokaigodoRadioItem9==null){

      yokaigodoRadioItem9 = new ACRadioButtonItem();

      yokaigodoRadioItem9.setText("�v���5");

      yokaigodoRadioItem9.setGroup(getYokaigodo());

      yokaigodoRadioItem9.setConstraints(VRLayout.FLOW);

      addYokaigodoRadioItem9();
    }
    return yokaigodoRadioItem9;

  }

  /**
   * �Z�����擾���܂��B
   * @return �Z��
   */
  public ACTextField getPatientAddress(){
    if(patientAddress==null){

      patientAddress = new ACTextField();

      getPatientAddressContainer().setText("�Z��");

      patientAddress.setBindPath("PATIENT_ADDRESS");

      patientAddress.setEditable(false);

      patientAddress.setColumns(40);

      patientAddress.setIMEMode(InputSubset.KANJI);

      patientAddress.setMaxLength(40);

      addPatientAddress();
    }
    return patientAddress;

  }

  /**
   * �Z���R���e�i���擾���܂��B
   * @return �Z���R���e�i
   */
  protected ACLabelContainer getPatientAddressContainer(){
    if(patientAddressContainer==null){
      patientAddressContainer = new ACLabelContainer();
      patientAddressContainer.setFollowChildEnabled(true);
      patientAddressContainer.setVAlignment(VRLayout.CENTER);
      patientAddressContainer.add(getPatientAddress(), null);
    }
    return patientAddressContainer;
  }

  /**
   * �厡�㎁�����擾���܂��B
   * @return �厡�㎁��
   */
  public ACTextField getDoctorName(){
    if(doctorName==null){

      doctorName = new ACTextField();

      getDoctorNameContainer().setText("�厡�㎁��");

      doctorName.setBindPath("DOCTOR_NAME");

      doctorName.setColumns(26);

      doctorName.setIMEMode(InputSubset.KANJI);

      doctorName.setMaxLength(26);

      addDoctorName();
    }
    return doctorName;

  }

  /**
   * �厡�㎁���R���e�i���擾���܂��B
   * @return �厡�㎁���R���e�i
   */
  protected ACLabelContainer getDoctorNameContainer(){
    if(doctorNameContainer==null){
      doctorNameContainer = new ACLabelContainer();
      doctorNameContainer.setFollowChildEnabled(true);
      doctorNameContainer.setVAlignment(VRLayout.CENTER);
      doctorNameContainer.add(getDoctorName(), null);
    }
    return doctorNameContainer;
  }

  /**
   * �X�e�[�V�������̈���擾���܂��B
   * @return �X�e�[�V�������̈�
   */
  public ACGroupBox getStations(){
    if(stations==null){

      stations = new ACGroupBox();

      stations.setText("�X�e�[�V��������");

      stations.setHgrid(300);

      addStations();
    }
    return stations;

  }

  /**
   * �쐬�N�������擾���܂��B
   * @return �쐬�N����
   */
  public QkanDateTextField getCreateDate(){
    if(createDate==null){

      createDate = new QkanDateTextField();

      getCreateDateContainer().setText("�쐬�N����");

      createDate.setBindPath("CREATE_DATE");

      addCreateDate();
    }
    return createDate;

  }

  /**
   * �쐬�N�����R���e�i���擾���܂��B
   * @return �쐬�N�����R���e�i
   */
  protected ACLabelContainer getCreateDateContainer(){
    if(createDateContainer==null){
      createDateContainer = new ACLabelContainer();
      createDateContainer.setFollowChildEnabled(true);
      createDateContainer.setVAlignment(VRLayout.CENTER);
      createDateContainer.add(getCreateDate(), null);
    }
    return createDateContainer;
  }

  /**
   * �X�e�[�V���������擾���܂��B
   * @return �X�e�[�V������
   */
  public ACComboBox getProviderName(){
    if(providerName==null){

      providerName = new ACComboBox();

      getProviderNameContainer().setText("�X�e�[�V������");

      providerName.setBindPath("PROVIDER_NAME");

      providerName.setModelBindPath("PROVIDER_NAMES");

      providerName.setRenderBindPath("PROVIDER_NAME");

      providerName.setIMEMode(InputSubset.KANJI);

      providerName.setMaxLength(64);

      providerName.setModel(getProviderNameModel());

      addProviderName();
    }
    return providerName;

  }

  /**
   * �X�e�[�V�������R���e�i���擾���܂��B
   * @return �X�e�[�V�������R���e�i
   */
  protected ACLabelContainer getProviderNameContainer(){
    if(providerNameContainer==null){
      providerNameContainer = new ACLabelContainer();
      providerNameContainer.setFollowChildEnabled(true);
      providerNameContainer.setVAlignment(VRLayout.CENTER);
      providerNameContainer.add(getProviderName(), null);
    }
    return providerNameContainer;
  }

  /**
   * �X�e�[�V���������f�����擾���܂��B
   * @return �X�e�[�V���������f��
   */
  protected ACComboBoxModelAdapter getProviderNameModel(){
    if(providerNameModel==null){
      providerNameModel = new ACComboBoxModelAdapter();
      addProviderNameModel();
    }
    return providerNameModel;
  }

  /**
   * �Ǘ��Ҏ������擾���܂��B
   * @return �Ǘ��Ҏ���
   */
  public ACTextField getAdministratorName(){
    if(administratorName==null){

      administratorName = new ACTextField();

      getAdministratorNameContainer().setText("�Ǘ��Ҏ���");

      administratorName.setBindPath("ADMINISTRATOR_NAME");

      administratorName.setColumns(22);

      administratorName.setIMEMode(InputSubset.KANJI);

      administratorName.setMaxLength(22);

      addAdministratorName();
    }
    return administratorName;

  }

  /**
   * �Ǘ��Ҏ����R���e�i���擾���܂��B
   * @return �Ǘ��Ҏ����R���e�i
   */
  protected ACLabelContainer getAdministratorNameContainer(){
    if(administratorNameContainer==null){
      administratorNameContainer = new ACLabelContainer();
      administratorNameContainer.setFollowChildEnabled(true);
      administratorNameContainer.setVAlignment(VRLayout.CENTER);
      administratorNameContainer.add(getAdministratorName(), null);
    }
    return administratorNameContainer;
  }

  /**
   * Tab���擾���܂��B
   * @return Tab
   */
  public JTabbedPane getTabs(){
    if(tabs==null){

      tabs = new JTabbedPane();

      addTabs();
    }
    return tabs;

  }

  /**
   * Tab�u�Ō�E���n�r���e�[�V�����̖ړI�^���l�v���擾���܂��B
   * @return Tab�u�Ō�E���n�r���e�[�V�����̖ړI�^���l�v
   */
  public ACPanel getTabPurposes(){
    if(tabPurposes==null){

      tabPurposes = new ACPanel();

      addTabPurposes();
    }
    return tabPurposes;

  }

  /**
   * �Ō�E���n�r���e�[�V�����̖ړI�̈���擾���܂��B
   * @return �Ō�E���n�r���e�[�V�����̖ړI�̈�
   */
  public ACGroupBox getPlanPurposes(){
    if(planPurposes==null){

      planPurposes = new ACGroupBox();

      planPurposes.setText("�Ō�E���n�r���e�[�V�����̖ڕW(44x13)");

      addPlanPurposes();
    }
    return planPurposes;

  }

  /**
   * �Ō�E���n�r���e�[�V�����̖ړI���擾���܂��B
   * @return �Ō�E���n�r���e�[�V�����̖ړI
   */
  public ACTextArea getPlanPurpose(){
    if(planPurpose==null){

      planPurpose = new ACTextArea();

      planPurpose.setBindPath("PLAN_PURPOSE");

      planPurpose.setColumns(88);

      planPurpose.setRows(6);

      planPurpose.setMaxRows(13);

      planPurpose.setIMEMode(InputSubset.KANJI);

      planPurpose.setMaxLength(572);

      planPurpose.setLineWrap(true);

      addPlanPurpose();
    }
    return planPurpose;

  }

  /**
   * �Ō�E���n�r���e�[�V�����̖ړI�R���e�i���擾���܂��B
   * @return �Ō�E���n�r���e�[�V�����̖ړI�R���e�i
   */
  protected ACLabelContainer getPlanPurposeContainer(){
    if(planPurposeContainer==null){
      planPurposeContainer = new ACLabelContainer();
      planPurposeContainer.setFollowChildEnabled(true);
      planPurposeContainer.setVAlignment(VRLayout.CENTER);
      planPurposeContainer.add(getPlanPurpose(), null);
    }
    return planPurposeContainer;
  }

  /**
   * ���l�\���̈���擾���܂��B
   * @return ���l�\���̈�
   */
  public ACGroupBox getPlanComments(){
    if(planComments==null){

      planComments = new ACGroupBox();

      planComments.setText("���l(43x4)");

      addPlanComments();
    }
    return planComments;

  }

  /**
   * ���l���擾���܂��B
   * @return ���l
   */
  public ACTextArea getPlanComment(){
    if(planComment==null){

      planComment = new ACTextArea();

      planComment.setBindPath("PLAN_COMMENT");

      planComment.setColumns(86);

      planComment.setRows(5);

      planComment.setMaxRows(4);

      planComment.setIMEMode(InputSubset.KANJI);

      planComment.setMaxLength(172);

      planComment.setLineWrap(true);

      addPlanComment();
    }
    return planComment;

  }

  /**
   * ���l�R���e�i���擾���܂��B
   * @return ���l�R���e�i
   */
  protected ACLabelContainer getPlanCommentContainer(){
    if(planCommentContainer==null){
      planCommentContainer = new ACLabelContainer();
      planCommentContainer.setFollowChildEnabled(true);
      planCommentContainer.setVAlignment(VRLayout.CENTER);
      planCommentContainer.add(getPlanComment(), null);
    }
    return planCommentContainer;
  }

  /**
   * Tab1�u���_�E������/�]���v���擾���܂��B
   * @return Tab1�u���_�E������/�]���v
   */
  public ACPanel getTabsNotes(){
    if(tabsNotes==null){

      tabsNotes = new ACPanel();

      addTabsNotes();
    }
    return tabsNotes;

  }

  /**
   * ���_�E������E�]���̈���擾���܂��B
   * @return ���_�E������E�]���̈�
   */
  public ACPanel getPlanNoteAreas(){
    if(planNoteAreas==null){

      planNoteAreas = new ACPanel();

      addPlanNoteAreas();
    }
    return planNoteAreas;

  }

  /**
   * ���_�E������E�]���ꗗ���擾���܂��B
   * @return ���_�E������E�]���ꗗ
   */
  public ACTable getPlanNotes(){
    if(planNotes==null){

      planNotes = new ACTable();

      planNotes.setColumnModel(getPlanNotesColumnModel());

      addPlanNotes();
    }
    return planNotes;

  }

  /**
   * ���_�E������E�]���ꗗ�J�������f�����擾���܂��B
   * @return ���_�E������E�]���ꗗ�J�������f��
   */
  protected VRTableColumnModel getPlanNotesColumnModel(){
    if(planNotesColumnModel==null){
      planNotesColumnModel = new VRTableColumnModel(new TableColumn[]{});
      addPlanNotesColumnModel();
    }
    return planNotesColumnModel;
  }

  /**
   * ��FNo���擾���܂��B
   * @return ��FNo
   */
  public ACTableColumn getPlanNotesColumn0(){
    if(planNotesColumn0==null){

      planNotesColumn0 = new ACTableColumn();

      planNotesColumn0.setHeaderValue("No.");

      planNotesColumn0.setColumnName("NOTE_ID");

      planNotesColumn0.setColumns(3);

      planNotesColumn0.setRendererType(ACTableCellViewer.RENDERER_TYPE_SERIAL_NO);

      planNotesColumn0.setSortable(false);

      addPlanNotesColumn0();
    }
    return planNotesColumn0;

  }

  /**
   * ��F�N�������擾���܂��B
   * @return ��F�N����
   */
  public ACTableColumn getPlanNotesColumn1(){
    if(planNotesColumn1==null){

      planNotesColumn1 = new ACTableColumn();

      planNotesColumn1.setHeaderValue("�N����");

      planNotesColumn1.setColumnName("NOTE_DATE");

      planNotesColumn1.setColumns(10);

      addPlanNotesColumn1();
    }
    return planNotesColumn1;

  }

  /**
   * ��F���_�E��������擾���܂��B
   * @return ��F���_�E������
   */
  public ACTableColumn getPlanNotesColumn2(){
    if(planNotesColumn2==null){

      planNotesColumn2 = new ACTableColumn();

      planNotesColumn2.setHeaderValue("���_�E������");

      planNotesColumn2.setColumnName("NOTE_COMMENT");

      planNotesColumn2.setColumns(50);

      addPlanNotesColumn2();
    }
    return planNotesColumn2;

  }

  /**
   * ��F�]�����擾���܂��B
   * @return ��F�]��
   */
  public ACTableColumn getPlanNotesColumn3(){
    if(planNotesColumn3==null){

      planNotesColumn3 = new ACTableColumn();

      planNotesColumn3.setHeaderValue("�]��");

      planNotesColumn3.setColumnName("NOTE_ASSESSMENT");

      planNotesColumn3.setColumns(8);

      addPlanNotesColumn3();
    }
    return planNotesColumn3;

  }

  /**
   * ���_�E������E�]���ҏW�̈���擾���܂��B
   * @return ���_�E������E�]���ҏW�̈�
   */
  public ACGroupBox getPlanNoteEdits(){
    if(planNoteEdits==null){

      planNoteEdits = new ACGroupBox();

      planNoteEdits.setText("���_�E������^�]��");

      planNoteEdits.setHgap(0);

      planNoteEdits.setLabelMargin(0);

      planNoteEdits.setVgap(0);

      addPlanNoteEdits();
    }
    return planNoteEdits;

  }

  /**
   * �p�l�����擾���܂��B
   * @return �p�l��
   */
  public ACPanel getPlanPanel(){
    if(planPanel==null){

      planPanel = new ACPanel();

      planPanel.setAutoWrap(false);

      planPanel.setHgap(0);

      planPanel.setLabelMargin(0);

      planPanel.setVgap(0);

      addPlanPanel();
    }
    return planPanel;

  }

  /**
   * ���_�E�������ҏW/���͗̈���擾���܂��B
   * @return ���_�E�������ҏW/���͗̈�
   */
  public ACPanel getPlanNoteEditDates(){
    if(planNoteEditDates==null){

      planNoteEditDates = new ACPanel();

      planNoteEditDates.setAutoWrap(false);

      addPlanNoteEditDates();
    }
    return planNoteEditDates;

  }

  /**
   * ���_�E�������ҏW/���t���擾���܂��B
   * @return ���_�E�������ҏW/���t
   */
  public QkanDateTextField getPlanNoteEditDate(){
    if(planNoteEditDate==null){

      planNoteEditDate = new QkanDateTextField();

      getPlanNoteEditDateContainer().setText("�N����");

      planNoteEditDate.setBindPath("NOTE_DATE");

      addPlanNoteEditDate();
    }
    return planNoteEditDate;

  }

  /**
   * ���_�E�������ҏW/���t�R���e�i���擾���܂��B
   * @return ���_�E�������ҏW/���t�R���e�i
   */
  protected ACLabelContainer getPlanNoteEditDateContainer(){
    if(planNoteEditDateContainer==null){
      planNoteEditDateContainer = new ACLabelContainer();
      planNoteEditDateContainer.setFollowChildEnabled(true);
      planNoteEditDateContainer.setVAlignment(VRLayout.CENTER);
      planNoteEditDateContainer.add(getPlanNoteEditDate(), null);
    }
    return planNoteEditDateContainer;
  }

  /**
   * ���_�E�������ҏW�ʗ̈���擾���܂��B
   * @return ���_�E�������ҏW�ʗ̈�
   */
  public ACGroupBox getPlanNoteEditComments(){
    if(planNoteEditComments==null){

      planNoteEditComments = new ACGroupBox();

      planNoteEditComments.setText("���_�E������");

      addPlanNoteEditComments();
    }
    return planNoteEditComments;

  }

  /**
   * ���_�E�������ҏW/�e�L�X�g���擾���܂��B
   * @return ���_�E�������ҏW/�e�L�X�g
   */
  public ACTextArea getPlanNoteEditComment(){
    if(planNoteEditComment==null){

      planNoteEditComment = new ACTextArea();

      planNoteEditComment.setBindPath("NOTE_COMMENT");

      planNoteEditComment.setColumns(68);

      planNoteEditComment.setRows(5);

      planNoteEditComment.setMaxRows(30);

      planNoteEditComment.setIMEMode(InputSubset.KANJI);

      planNoteEditComment.setMaxLength(3000);

      planNoteEditComment.setLineWrap(true);

      addPlanNoteEditComment();
    }
    return planNoteEditComment;

  }

  /**
   * ���_�E�������ҏW/�e�L�X�g�R���e�i���擾���܂��B
   * @return ���_�E�������ҏW/�e�L�X�g�R���e�i
   */
  protected ACLabelContainer getPlanNoteEditCommentContainer(){
    if(planNoteEditCommentContainer==null){
      planNoteEditCommentContainer = new ACLabelContainer();
      planNoteEditCommentContainer.setFollowChildEnabled(true);
      planNoteEditCommentContainer.setVAlignment(VRLayout.CENTER);
      planNoteEditCommentContainer.add(getPlanNoteEditComment(), null);
    }
    return planNoteEditCommentContainer;
  }

  /**
   * �]���ҏW�ʗ̈���擾���܂��B
   * @return �]���ҏW�ʗ̈�
   */
  public ACGroupBox getPlanAssessmentEditComments(){
    if(planAssessmentEditComments==null){

      planAssessmentEditComments = new ACGroupBox();

      planAssessmentEditComments.setText("�]��");

      addPlanAssessmentEditComments();
    }
    return planAssessmentEditComments;

  }

  /**
   * �]���ҏW/�e�L�X�g���擾���܂��B
   * @return �]���ҏW/�e�L�X�g
   */
  public ACTextArea getPlanAssessmentEditComment(){
    if(planAssessmentEditComment==null){

      planAssessmentEditComment = new ACTextArea();

      planAssessmentEditComment.setBindPath("NOTE_ASSESSMENT");

      planAssessmentEditComment.setColumns(20);

      planAssessmentEditComment.setRows(5);

      planAssessmentEditComment.setMaxRows(30);

      planAssessmentEditComment.setIMEMode(InputSubset.KANJI);

      planAssessmentEditComment.setMaxLength(3000);

      planAssessmentEditComment.setLineWrap(true);

      addPlanAssessmentEditComment();
    }
    return planAssessmentEditComment;

  }

  /**
   * �]���ҏW/�e�L�X�g�R���e�i���擾���܂��B
   * @return �]���ҏW/�e�L�X�g�R���e�i
   */
  protected ACLabelContainer getPlanAssessmentEditCommentContainer(){
    if(planAssessmentEditCommentContainer==null){
      planAssessmentEditCommentContainer = new ACLabelContainer();
      planAssessmentEditCommentContainer.setFollowChildEnabled(true);
      planAssessmentEditCommentContainer.setVAlignment(VRLayout.CENTER);
      planAssessmentEditCommentContainer.add(getPlanAssessmentEditComment(), null);
    }
    return planAssessmentEditCommentContainer;
  }

  /**
   * ���_�E�������ҏW/�{�^���̈���擾���܂��B
   * @return ���_�E�������ҏW/�{�^���̈�
   */
  public ACPanel getPlanNoteEditButtons(){
    if(planNoteEditButtons==null){

      planNoteEditButtons = new ACPanel();

      addPlanNoteEditButtons();
    }
    return planNoteEditButtons;

  }

  /**
   * ���_�E�������ҏW/�{�^���E�ǉ����擾���܂��B
   * @return ���_�E�������ҏW/�{�^���E�ǉ�
   */
  public ACButton getPlanNoteEditButtonAdd(){
    if(planNoteEditButtonAdd==null){

      planNoteEditButtonAdd = new ACButton();

      planNoteEditButtonAdd.setText("�ǉ�");

      planNoteEditButtonAdd.setToolTipText("���͂��ꂽ�u���_�E������v��ǉ����܂��B");

      planNoteEditButtonAdd.setIconPath(ACConstants.ICON_PATH_RECORD_DOWNLOAD_16);

      addPlanNoteEditButtonAdd();
    }
    return planNoteEditButtonAdd;

  }

  /**
   * ���_�E�������ҏW/�{�^���E���ւ��擾���܂��B
   * @return ���_�E�������ҏW/�{�^���E����
   */
  public ACButton getPlanNoteEditButtonEdit(){
    if(planNoteEditButtonEdit==null){

      planNoteEditButtonEdit = new ACButton();

      planNoteEditButtonEdit.setText("����");

      planNoteEditButtonEdit.setToolTipText("���͂��ꂽ�u���_�E������v�ŁA�I������Ă��鍀�ڂ��㏑���܂��B");

      planNoteEditButtonEdit.setIconPath(ACConstants.ICON_PATH_STATE_UPDATE_16);

      addPlanNoteEditButtonEdit();
    }
    return planNoteEditButtonEdit;

  }

  /**
   * ���_�E�������ҏW/�{�^���E�폜���擾���܂��B
   * @return ���_�E�������ҏW/�{�^���E�폜
   */
  public ACButton getPlanNoteEditButtonDelete(){
    if(planNoteEditButtonDelete==null){

      planNoteEditButtonDelete = new ACButton();

      planNoteEditButtonDelete.setText("�폜");

      planNoteEditButtonDelete.setToolTipText("�I������Ă���u���_�E������v���폜���܂��B");

      planNoteEditButtonDelete.setIconPath(ACConstants.ICON_PATH_STATE_DELETE_16);

      addPlanNoteEditButtonDelete();
    }
    return planNoteEditButtonDelete;

  }

  /**
   * ���_�E�������ҏW/�{�^���E�N���A���擾���܂��B
   * @return ���_�E�������ҏW/�{�^���E�N���A
   */
  public ACButton getPlanNoteEditButtonClear(){
    if(planNoteEditButtonClear==null){

      planNoteEditButtonClear = new ACButton();

      planNoteEditButtonClear.setText("�N���A");

      planNoteEditButtonClear.setToolTipText("���͂���Ă��颖��_�E��������̓��t�Ɠ��e���N���A���܂��B");

      planNoteEditButtonClear.setIconPath(ACConstants.ICON_PATH_CLEAR_16);

      addPlanNoteEditButtonClear();
    }
    return planNoteEditButtonClear;

  }

  /**
   * �R���X�g���N�^�ł��B
   */
  public QC001Design() {

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

    this.add(getContents(), VRLayout.CLIENT);

  }

  /**
   * �{�^���o�[�ɓ������ڂ�ǉ����܂��B
   */
  protected void addButtons(){

    buttons.add(getPrint(), VRLayout.EAST);
    buttons.add(getUpdate(), VRLayout.EAST);
    buttons.add(getInsert(), VRLayout.EAST);
    buttons.add(getOpen(), VRLayout.EAST);
  }

  /**
   * �O��Ǎ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addOpen(){

  }

  /**
   * �o�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addInsert(){

  }

  /**
   * �X�V�ɓ������ڂ�ǉ����܂��B
   */
  protected void addUpdate(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addPrint(){

  }

  /**
   * �N���C�A���g�̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addContents(){

    contents.add(getTargetDates(), VRLayout.NORTH);

    contents.add(getInfos(), VRLayout.NORTH);

    contents.add(getTabs(), VRLayout.CLIENT);

  }

  /**
   * �Ώ۔N���̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTargetDates(){

    targetDates.add(getTargetDateCaption(), VRLayout.FLOW);

    targetDates.add(getTargetDate(), VRLayout.FLOW);

  }

  /**
   * �Ώ۔N���L���v�V�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addTargetDateCaption(){

  }

  /**
   * �Ώ۔N���ɓ������ڂ�ǉ����܂��B
   */
  protected void addTargetDate(){

  }

  /**
   * ���̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addInfos(){

    infos.add(getPatients(), VRLayout.NORTH);

    infos.add(getStations(), VRLayout.NORTH);

  }

  /**
   * ���p�ҏ��̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatients(){

    patients.add(getPatientNameContainer(), VRLayout.FLOW_INSETLINE);

    patients.add(getPatientBirthContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    patients.add(getYokaigodoContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    patients.add(getPatientAddressContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    patients.add(getDoctorNameContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * �����ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatientName(){

  }

  /**
   * ���N�����R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatientBirthContainer(){

    patientBirthContainer.add(getPatientBirth(), null);

    patientBirthContainer.add(getPatientAge(), null);

    patientBirthContainer.add(getPatientAgeLabel(), null);

  }

  /**
   * ���N�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatientBirth(){

  }

  /**
   * �N��ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatientAge(){

  }

  /**
   * �΂ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatientAgeLabel(){

  }

  /**
   * �v���F��ɓ������ڂ�ǉ����܂��B
   */
  protected void addYokaigodo(){

  }

  /**
   * �v���F�胂�f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addYokaigodoModel(){

    getYokaigodoRadioItem1().setButtonIndex(1);

    getYokaigodoModel().add(getYokaigodoRadioItem1());

    getYokaigodoRadioItem2().setButtonIndex(12);

    getYokaigodoModel().add(getYokaigodoRadioItem2());

    getYokaigodoRadioItem3().setButtonIndex(13);

    getYokaigodoModel().add(getYokaigodoRadioItem3());

    getYokaigodoRadioItem4().setButtonIndex(11);

    getYokaigodoModel().add(getYokaigodoRadioItem4());

    getYokaigodoRadioItem5().setButtonIndex(21);

    getYokaigodoModel().add(getYokaigodoRadioItem5());

    getYokaigodoRadioItem6().setButtonIndex(22);

    getYokaigodoModel().add(getYokaigodoRadioItem6());

    getYokaigodoRadioItem7().setButtonIndex(23);

    getYokaigodoModel().add(getYokaigodoRadioItem7());

    getYokaigodoRadioItem8().setButtonIndex(24);

    getYokaigodoModel().add(getYokaigodoRadioItem8());

    getYokaigodoRadioItem9().setButtonIndex(25);

    getYokaigodoModel().add(getYokaigodoRadioItem9());

  }

  /**
   * �����ɓ������ڂ�ǉ����܂��B
   */
  protected void addYokaigodoRadioItem1(){

  }

  /**
   * �v�x���P�ɓ������ڂ�ǉ����܂��B
   */
  protected void addYokaigodoRadioItem2(){

  }

  /**
   * �v�x���Q�ɓ������ڂ�ǉ����܂��B
   */
  protected void addYokaigodoRadioItem3(){

  }

  /**
   * �o�ߓI�v���ɓ������ڂ�ǉ����܂��B
   */
  protected void addYokaigodoRadioItem4(){

  }

  /**
   * �v���1�ɓ������ڂ�ǉ����܂��B
   */
  protected void addYokaigodoRadioItem5(){

  }

  /**
   * �v���2�ɓ������ڂ�ǉ����܂��B
   */
  protected void addYokaigodoRadioItem6(){

  }

  /**
   * �v���3�ɓ������ڂ�ǉ����܂��B
   */
  protected void addYokaigodoRadioItem7(){

  }

  /**
   * �v���4�ɓ������ڂ�ǉ����܂��B
   */
  protected void addYokaigodoRadioItem8(){

  }

  /**
   * �v���5�ɓ������ڂ�ǉ����܂��B
   */
  protected void addYokaigodoRadioItem9(){

  }

  /**
   * �Z���ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatientAddress(){

  }

  /**
   * �厡�㎁���ɓ������ڂ�ǉ����܂��B
   */
  protected void addDoctorName(){

  }

  /**
   * �X�e�[�V�������̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addStations(){

    stations.add(getCreateDateContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    stations.add(getProviderNameContainer(), VRLayout.FLOW_INSETLINE);

    stations.add(getAdministratorNameContainer(), VRLayout.FLOW_RETURN);

  }

  /**
   * �쐬�N�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addCreateDate(){

  }

  /**
   * �X�e�[�V�������ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderName(){

  }

  /**
   * �X�e�[�V���������f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderNameModel(){

  }

  /**
   * �Ǘ��Ҏ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addAdministratorName(){

  }

  /**
   * Tab�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTabs(){

    tabs.addTab("�Ō�E���n�r���e�[�V�����̖ڕW�^���l", getTabPurposes());

    tabs.addTab("���_�E������^�]��", getTabsNotes());

  }

  /**
   * Tab�u�Ō�E���n�r���e�[�V�����̖ړI�^���l�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTabPurposes(){

    tabPurposes.add(getPlanPurposes(), VRLayout.FLOW_RETURN);

    tabPurposes.add(getPlanComments(), VRLayout.FLOW_RETURN);

  }

  /**
   * �Ō�E���n�r���e�[�V�����̖ړI�̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPlanPurposes(){

    planPurposes.add(getPlanPurposeContainer(), VRLayout.FLOW);

  }

  /**
   * �Ō�E���n�r���e�[�V�����̖ړI�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPlanPurpose(){

  }

  /**
   * ���l�\���̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPlanComments(){

    planComments.add(getPlanCommentContainer(), VRLayout.FLOW);

  }

  /**
   * ���l�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPlanComment(){

  }

  /**
   * Tab1�u���_�E������/�]���v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTabsNotes(){

    tabsNotes.add(getPlanNoteAreas(), VRLayout.CLIENT);

  }

  /**
   * ���_�E������E�]���̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPlanNoteAreas(){

    planNoteAreas.add(getPlanNotes(), VRLayout.NORTH);

    planNoteAreas.add(getPlanNoteEdits(), VRLayout.NORTH);

  }

  /**
   * ���_�E������E�]���ꗗ�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPlanNotes(){

  }

  /**
   * ���_�E������E�]���ꗗ�J�������f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addPlanNotesColumnModel(){

    getPlanNotesColumnModel().addColumn(getPlanNotesColumn0());

    getPlanNotesColumnModel().addColumn(getPlanNotesColumn1());

    getPlanNotesColumnModel().addColumn(getPlanNotesColumn2());

    getPlanNotesColumnModel().addColumn(getPlanNotesColumn3());

  }

  /**
   * ��FNo�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPlanNotesColumn0(){

  }

  /**
   * ��F�N�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addPlanNotesColumn1(){

  }

  /**
   * ��F���_�E������ɓ������ڂ�ǉ����܂��B
   */
  protected void addPlanNotesColumn2(){

  }

  /**
   * ��F�]���ɓ������ڂ�ǉ����܂��B
   */
  protected void addPlanNotesColumn3(){

  }

  /**
   * ���_�E������E�]���ҏW�̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPlanNoteEdits(){

    planNoteEdits.add(getPlanPanel(), VRLayout.FLOW);

  }

  /**
   * �p�l���ɓ������ڂ�ǉ����܂��B
   */
  protected void addPlanPanel(){

    planPanel.add(getPlanNoteEditDates(), VRLayout.FLOW_RETURN);

    planPanel.add(getPlanNoteEditComments(), VRLayout.FLOW);

    planPanel.add(getPlanAssessmentEditComments(), VRLayout.FLOW_RETURN);

    planPanel.add(getPlanNoteEditButtons(), VRLayout.FLOW);

  }

  /**
   * ���_�E�������ҏW/���͗̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPlanNoteEditDates(){

    planNoteEditDates.add(getPlanNoteEditDateContainer(), VRLayout.FLOW);

  }

  /**
   * ���_�E�������ҏW/���t�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPlanNoteEditDate(){

  }

  /**
   * ���_�E�������ҏW�ʗ̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPlanNoteEditComments(){

    planNoteEditComments.add(getPlanNoteEditCommentContainer(), VRLayout.FLOW);

  }

  /**
   * ���_�E�������ҏW/�e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPlanNoteEditComment(){

  }

  /**
   * �]���ҏW�ʗ̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPlanAssessmentEditComments(){

    planAssessmentEditComments.add(getPlanAssessmentEditCommentContainer(), VRLayout.FLOW);

  }

  /**
   * �]���ҏW/�e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPlanAssessmentEditComment(){

  }

  /**
   * ���_�E�������ҏW/�{�^���̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPlanNoteEditButtons(){

    planNoteEditButtons.add(getPlanNoteEditButtonAdd(), VRLayout.WEST);

    planNoteEditButtons.add(getPlanNoteEditButtonEdit(), VRLayout.WEST);

    planNoteEditButtons.add(getPlanNoteEditButtonDelete(), VRLayout.WEST);

    planNoteEditButtons.add(getPlanNoteEditButtonClear(), VRLayout.WEST);

  }

  /**
   * ���_�E�������ҏW/�{�^���E�ǉ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addPlanNoteEditButtonAdd(){

  }

  /**
   * ���_�E�������ҏW/�{�^���E���ւɓ������ڂ�ǉ����܂��B
   */
  protected void addPlanNoteEditButtonEdit(){

  }

  /**
   * ���_�E�������ҏW/�{�^���E�폜�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPlanNoteEditButtonDelete(){

  }

  /**
   * ���_�E�������ҏW/�{�^���E�N���A�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPlanNoteEditButtonClear(){

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

    return null;

  }
  public void initAffair(ACAffairInfo affair) throws Exception {
  }

  public static void main(String[] args) {
    //�f�t�H���g�f�o�b�O�N��
    try {
      ACFrame.getInstance().setFrameEventProcesser(new QkanFrameEventProcesser());
      ACFrame.debugStart(new ACAffairInfo(QC001Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QC001Design getThis() {
    return this;
  }
}
