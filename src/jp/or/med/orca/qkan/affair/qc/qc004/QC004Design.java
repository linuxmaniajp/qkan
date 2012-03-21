
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
 * �쐬��: 2006/04/04  ���{�R���s���[�^�[������� ����@��F �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���[�Ǘ� (C)
 * �v���Z�X �K��Ō�̋L�^��I (004)
 * �v���O���� �K��Ō�̋L�^��I (QC004)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qc.qc004;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.im.InputSubset;

import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;

import jp.nichicom.ac.ACConstants;
import jp.nichicom.ac.component.ACAffairButton;
import jp.nichicom.ac.component.ACAffairButtonBar;
import jp.nichicom.ac.component.ACClearableRadioButtonGroup;
import jp.nichicom.ac.component.ACComboBox;
import jp.nichicom.ac.component.ACLabel;
import jp.nichicom.ac.component.ACRadioButtonItem;
import jp.nichicom.ac.component.ACTextArea;
import jp.nichicom.ac.component.ACTextField;
import jp.nichicom.ac.component.ACTimeTextField;
import jp.nichicom.ac.container.ACGroupBox;
import jp.nichicom.ac.container.ACLabelContainer;
import jp.nichicom.ac.container.ACPanel;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACAffairable;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.util.adapter.ACComboBoxModelAdapter;
import jp.nichicom.ac.util.adapter.ACListModelAdapter;
import jp.nichicom.vr.layout.VRLayout;
import jp.nichicom.vr.text.VRCharType;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanConstants;
import jp.or.med.orca.qkan.affair.QkanAffairContainer;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.component.QkanDateTextField;
/**
 * �K��Ō�̋L�^��I��ʍ��ڃf�U�C��(QC004) 
 */
public class QC004Design extends QkanAffairContainer implements ACAffairable {
  //GUI�R���|�[�l���g

  private ACAffairButtonBar buttons;

  private ACAffairButton open;

  private ACAffairButton insert;

  private ACAffairButton update;

  private ACAffairButton print;

  private ACPanel contents;

  private ACPanel patients;

  private ACGroupBox patient;

  private ACTextField patientName;

  private ACLabelContainer patientNameContainer;

  private ACTextField patientSex;

  private ACLabelContainer patientSexContainer;

  private ACLabelContainer patientBirths;

  private QkanDateTextField patientBirth;

  private ACTextField patientAge;

  private ACLabel patientAgeLabel;

  private ACTextField patientAddress;

  private ACLabelContainer patientAddressContainer;

  private ACLabelContainer patientTels;

  private ACTextField patientTel1;

  private ACLabel patientLabel1;

  private ACTextField patientTel2;

  private ACLabel patientLabel2;

  private ACTextField patientTel3;

  private ACPanel nurses;

  private ACGroupBox nurse;

  private ACTextField nurseName;

  private ACLabelContainer nurseNameContainer;

  private ACLabelContainer firstVisitDates;

  private QkanDateTextField firstVisitDateStart;

  private ACLabel firstVisitDateTimeLabel;

  private ACTimeTextField firstVisitDateStartHour;

  private ACLabel firstVisitDateLabel;

  private ACTimeTextField firstVisitDateEndHour;

  private JTabbedPane tabs;

  private ACPanel points1;

  private ACGroupBox mainDiseases;

  private ACTextArea mainDisease;

  private ACLabelContainer mainDiseaseContainer;

  private ACGroupBox diseaseConditionAndTreatments;

  private ACTextArea diseaseConditionAndTreatment;

  private ACLabelContainer diseaseConditionAndTreatmentContainer;

  private ACPanel points2;

  private ACGroupBox genbyorekis;

  private ACTextArea genbyoreki;

  private ACLabelContainer genbyorekiContainer;

  private ACGroupBox existingAddressHistorys;

  private ACTextArea existingAddressHistory;

  private ACLabelContainer existingAddressHistoryContainer;

  private ACPanel points3;

  private ACGroupBox lifeHistorys;

  private ACTextArea lifeHistory;

  private ACLabelContainer lifeHistoryContainer;

  private ACGroupBox familyStructureas;

  private GridBagLayout familyStructre;

  private ACLabel familyStructreNameHeader;

  private ACLabel familyStructreAgeHeader;

  private ACLabel familyStructreRelationHeader;

  private ACLabel familyStructreJobHeader;

  private ACLabel familyStructreCommentHeader;

  private ACTextField familyStructreName1;

  private ACTextField familyStructreAge1;

  private ACTextField familyStructreRelation1;

  private ACTextField familyStructreJob1;

  private ACTextField familyStructreComment1;

  private ACTextField familyStructreName2;

  private ACTextField familyStructreAge2;

  private ACTextField familyStructreRelation2;

  private ACTextField familyStructreJob2;

  private ACTextField familyStructreComment2;

  private ACTextField familyStructreName3;

  private ACTextField familyStructreAge3;

  private ACTextField familyStructreRelation3;

  private ACTextField familyStructreJob3;

  private ACTextField familyStructreComment3;

  private ACTextField familyStructreName4;

  private ACTextField familyStructreAge4;

  private ACTextField familyStructreRelation4;

  private ACTextField familyStructreJob4;

  private ACTextField familyStructreComment4;

  private ACTextField familyStructreName5;

  private ACTextField familyStructreAge5;

  private ACTextField familyStructreRelation5;

  private ACTextField familyStructreJob5;

  private ACTextField familyStructreComment5;

  private ACTextField familyStructreName6;

  private ACTextField familyStructreAge6;

  private ACTextField familyStructreRelation6;

  private ACTextField familyStructreJob6;

  private ACTextField familyStructreComment6;

  private ACPanel points4;

  private ACGroupBox mainCaares;

  private ACTextArea mainCare;

  private ACLabelContainer mainCareContainer;

  private ACGroupBox jyukankyos;

  private ACTextArea jyukankyo;

  private ACLabelContainer jyukankyoContainer;

  private ACPanel points5;

  private ACGroupBox patientAndFamilyRequests;

  private ACTextArea patientAndFamilyRequest;

  private ACLabelContainer patientAndFamilyRequestContainer;

  private ACGroupBox syujis;

  private ACTextField syujiName;

  private ACLabelContainer syujiNameContainer;

  private ACComboBox syujiMedicalName;

  private ACLabelContainer syujiMedicalNameContainer;

  private ACComboBoxModelAdapter syujiMedicalNameModel;

  private ACTextArea syujiAddress;

  private ACLabelContainer syujiAddressContainer;

  private ACLabelContainer suijiTels;

  private ACTextField syujiTel1;

  private ACLabel syujiLabel1;

  private ACTextField syujiTel2;

  private ACLabel syujiLabel2;

  private ACTextField syujiTel3;

  private ACPanel points6;

  private ACGroupBox RequestObjects;

  private ACClearableRadioButtonGroup RequestObjectMove;

  private ACLabelContainer RequestObjectMoveContainer;

  private ACListModelAdapter RequestObjectMoveModel;

  private ACRadioButtonItem RequestObjectMoveRadioItem1;

  private ACRadioButtonItem RequestObjectMoveRadioItem2;

  private ACRadioButtonItem RequestObjectMoveRadioItem3;

  private ACRadioButtonItem RequestObjectMoveRadioItem4;

  private ACClearableRadioButtonGroup RequestObjectDinner;

  private ACLabelContainer RequestObjectDinnerContainer;

  private ACListModelAdapter RequestObjectDinnerModel;

  private ACRadioButtonItem RequestObjectDinnerRadioItem1;

  private ACRadioButtonItem RequestObjectDinnerRadioItem2;

  private ACRadioButtonItem RequestObjectDinnerRadioItem3;

  private ACRadioButtonItem RequestObjectDinnerRadioItem4;

  private ACClearableRadioButtonGroup RequestObjectExcrete;

  private ACLabelContainer RequestObjectExcreteContainer;

  private ACListModelAdapter RequestObjectExcreteModel;

  private ACRadioButtonItem RequestObjectExcreteRadioItem1;

  private ACRadioButtonItem RequestObjectExcreteRadioItem2;

  private ACRadioButtonItem RequestObjectExcreteRadioItem3;

  private ACRadioButtonItem RequestObjectExcreteRadioItem4;

  private ACClearableRadioButtonGroup RequestObjectBath;

  private ACLabelContainer RequestObjectBathContainer;

  private ACListModelAdapter RequestObjectBathModel;

  private ACRadioButtonItem RequestObjectBathRadioItem1;

  private ACRadioButtonItem RequestObjectBathRadioItem2;

  private ACRadioButtonItem RequestObjectBathRadioItem3;

  private ACRadioButtonItem RequestObjectBathRadioItem4;

  private ACClearableRadioButtonGroup RequestObjectChangeClothes;

  private ACLabelContainer RequestObjectChangeClothesContainer;

  private ACListModelAdapter RequestObjectChangeClothesModel;

  private ACRadioButtonItem RequestObjectChangeClothesRadioItem1;

  private ACRadioButtonItem RequestObjectChangeClothesRadioItem2;

  private ACRadioButtonItem RequestObjectChangeClothesRadioItem3;

  private ACRadioButtonItem RequestObjectChangeClothesRadioItem4;

  private ACClearableRadioButtonGroup RequestObjectSeiyo;

  private ACLabelContainer RequestObjectSeiyoContainer;

  private ACListModelAdapter RequestObjectSeiyoModel;

  private ACRadioButtonItem RequestObjectSeiyoRadioItem1;

  private ACRadioButtonItem RequestObjectSeiyoRadioItem2;

  private ACRadioButtonItem RequestObjectSeiyoRadioItem3;

  private ACRadioButtonItem RequestObjectSeiyoRadioItem4;

  private ACClearableRadioButtonGroup RequestObjectIsisotu;

  private ACLabelContainer RequestObjectIsisotuContainer;

  private ACListModelAdapter RequestObjectIsisotuModel;

  private ACRadioButtonItem RequestObjectIsisotuRadioItem1;

  private ACRadioButtonItem RequestObjectIsisotuRadioItem2;

  private ACRadioButtonItem RequestObjectIsisotuRadioItem3;

  private ACRadioButtonItem RequestObjectIsisotuRadioItem4;

  private ACGroupBox emergencyContacts;

  private ACTextArea emergencyContact;

  private ACLabelContainer emergencyContactContainer;

  private ACPanel points7;

  private ACGroupBox kankeikikans;

  private GridBagLayout kankeikikanLayout;

  private ACLabel contactAddressHeader;

  private ACLabel chargeHeader;

  private ACLabel remarkHeader;

  private ACTextField contact1;

  private ACTextField charge1;

  private ACTextField remark1;

  private ACTextField contact2;

  private ACTextField charge2;

  private ACTextField remark2;

  private ACTextField contact3;

  private ACTextField charge3;

  private ACTextField remark3;

  private ACTextField contact4;

  private ACTextField charge4;

  private ACTextField remark4;

  private ACGroupBox hokenfukusis;

  private ACTextArea hokenfukusi;

  private ACLabelContainer hokenfukusiContainer;

  //getter

  /**
   * �{�^���o�[���擾���܂��B
   * @return �{�^���o�[
   */
  public ACAffairButtonBar getButtons(){
    if(buttons==null){

      buttons = new ACAffairButtonBar();

      buttons.setText("�K��Ō�L�^��I");

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

      open.setToolTipText("�ߋ��̃f�[�^�̒��ŁA�ŐV�̃f�[�^��ǂݍ��݂܂��B");

      open.setMnemonic('O');

      open.setIconPath(ACConstants.ICON_PATH_OPEN_24);

      addOpen();
    }
    return open;

  }

  /**
   * �ۑ����擾���܂��B
   * @return �ۑ�
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

      update.setToolTipText("���݂̓��e���X�V���܂�");

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

      print.setToolTipText("�u�K��Ō�̋L�^��I�v��������܂��B");

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
   * ���җ̈���擾���܂��B
   * @return ���җ̈�
   */
  public ACPanel getPatients(){
    if(patients==null){

      patients = new ACPanel();

      addPatients();
    }
    return patients;

  }

  /**
   * ���җ̈�E�O���[�v���擾���܂��B
   * @return ���җ̈�E�O���[�v
   */
  public ACGroupBox getPatient(){
    if(patient==null){

      patient = new ACGroupBox();

      patient.setText("����");

      patient.setHgap(1);

      patient.setLabelMargin(1);

      addPatient();
    }
    return patient;

  }

  /**
   * ���Ҏ������擾���܂��B
   * @return ���Ҏ���
   */
  public ACTextField getPatientName(){
    if(patientName==null){

      patientName = new ACTextField();

      getPatientNameContainer().setText("����");

      patientName.setBindPath("PATIENT_NAME");

      patientName.setEditable(false);

      patientName.setColumns(20);

      patientName.setIMEMode(InputSubset.KANJI);

      patientName.setMaxLength(50);

      addPatientName();
    }
    return patientName;

  }

  /**
   * ���Ҏ����R���e�i���擾���܂��B
   * @return ���Ҏ����R���e�i
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
   * ���Ґ��ʂ��擾���܂��B
   * @return ���Ґ���
   */
  public ACTextField getPatientSex(){
    if(patientSex==null){

      patientSex = new ACTextField();

      getPatientSexContainer().setText("����");

      patientSex.setBindPath("PATIENT_SEX");

      patientSex.setEditable(false);

      patientSex.setColumns(2);

      patientSex.setFormat(QkanConstants.FORMAT_SEX);

      patientSex.setIMEMode(InputSubset.KANJI);

      patientSex.setMaxLength(2);

      addPatientSex();
    }
    return patientSex;

  }

  /**
   * ���Ґ��ʃR���e�i���擾���܂��B
   * @return ���Ґ��ʃR���e�i
   */
  protected ACLabelContainer getPatientSexContainer(){
    if(patientSexContainer==null){
      patientSexContainer = new ACLabelContainer();
      patientSexContainer.setFollowChildEnabled(true);
      patientSexContainer.setVAlignment(VRLayout.CENTER);
      patientSexContainer.add(getPatientSex(), null);
    }
    return patientSexContainer;
  }

  /**
   * ���Ґ��N�����E�R���e�i���擾���܂��B
   * @return ���Ґ��N�����E�R���e�i
   */
  public ACLabelContainer getPatientBirths(){
    if(patientBirths==null){

      patientBirths = new ACLabelContainer();

      patientBirths.setText("���N����");

      addPatientBirths();
    }
    return patientBirths;

  }

  /**
   * ���Ґ��N�������擾���܂��B
   * @return ���Ґ��N����
   */
  public QkanDateTextField getPatientBirth(){
    if(patientBirth==null){

      patientBirth = new QkanDateTextField();

      patientBirth.setBindPath("PATIENT_BIRTHDAY");

      patientBirth.setEditable(false);

      patientBirth.setColumns(10);

      addPatientBirth();
    }
    return patientBirth;

  }

  /**
   * ���ҔN����擾���܂��B
   * @return ���ҔN��
   */
  public ACTextField getPatientAge(){
    if(patientAge==null){

      patientAge = new ACTextField();

      patientAge.setBindPath("PATIENT_AGE");

      patientAge.setEditable(false);

      patientAge.setMaxLength(4);

      addPatientAge();
    }
    return patientAge;

  }

  /**
   * �΃��x�����擾���܂��B
   * @return �΃��x��
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
   * ���ҏZ�����擾���܂��B
   * @return ���ҏZ��
   */
  public ACTextField getPatientAddress(){
    if(patientAddress==null){

      patientAddress = new ACTextField();

      getPatientAddressContainer().setText("�Z��");

      patientAddress.setBindPath("PATIENT_ADDRESS");

      patientAddress.setEditable(false);

      patientAddress.setColumns(25);

      patientAddress.setIMEMode(InputSubset.KANJI);

      patientAddress.setMaxLength(50);

      addPatientAddress();
    }
    return patientAddress;

  }

  /**
   * ���ҏZ���R���e�i���擾���܂��B
   * @return ���ҏZ���R���e�i
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
   * ���ғd�b�ԍ����擾���܂��B
   * @return ���ғd�b�ԍ�
   */
  public ACLabelContainer getPatientTels(){
    if(patientTels==null){

      patientTels = new ACLabelContainer();

      patientTels.setText("�d�b�ԍ�");

      addPatientTels();
    }
    return patientTels;

  }

  /**
   * ���ғd�b�ԍ�1���擾���܂��B
   * @return ���ғd�b�ԍ�1
   */
  public ACTextField getPatientTel1(){
    if(patientTel1==null){

      patientTel1 = new ACTextField();

      patientTel1.setBindPath("PATIENT_TEL_FIRST");

      patientTel1.setEditable(false);

      patientTel1.setColumns(4);

      patientTel1.setCharType(VRCharType.ONLY_DIGIT);

      patientTel1.setIMEMode(InputSubset.LATIN);

      patientTel1.setMaxLength(6);

      addPatientTel1();
    }
    return patientTel1;

  }

  /**
   * ���ғd�b�ԍ����x��1���擾���܂��B
   * @return ���ғd�b�ԍ����x��1
   */
  public ACLabel getPatientLabel1(){
    if(patientLabel1==null){

      patientLabel1 = new ACLabel();

      patientLabel1.setText("-");

      addPatientLabel1();
    }
    return patientLabel1;

  }

  /**
   * ���ғd�b�ԍ�2���擾���܂��B
   * @return ���ғd�b�ԍ�2
   */
  public ACTextField getPatientTel2(){
    if(patientTel2==null){

      patientTel2 = new ACTextField();

      patientTel2.setBindPath("PATIENT_TEL_SECOND");

      patientTel2.setEditable(false);

      patientTel2.setColumns(4);

      patientTel2.setCharType(VRCharType.ONLY_DIGIT);

      patientTel2.setIMEMode(InputSubset.LATIN);

      patientTel2.setMaxLength(4);

      addPatientTel2();
    }
    return patientTel2;

  }

  /**
   * ���ғd�b�ԍ����x��1���擾���܂��B
   * @return ���ғd�b�ԍ����x��1
   */
  public ACLabel getPatientLabel2(){
    if(patientLabel2==null){

      patientLabel2 = new ACLabel();

      patientLabel2.setText("-");

      addPatientLabel2();
    }
    return patientLabel2;

  }

  /**
   * ���ғd�b�ԍ�3���擾���܂��B
   * @return ���ғd�b�ԍ�3
   */
  public ACTextField getPatientTel3(){
    if(patientTel3==null){

      patientTel3 = new ACTextField();

      patientTel3.setBindPath("PATIENT_TEL_THIRD");

      patientTel3.setEditable(false);

      patientTel3.setColumns(4);

      patientTel3.setCharType(VRCharType.ONLY_DIGIT);

      patientTel3.setIMEMode(InputSubset.LATIN);

      patientTel3.setMaxLength(4);

      addPatientTel3();
    }
    return patientTel3;

  }

  /**
   * �Ō�t�̈���擾���܂��B
   * @return �Ō�t�̈�
   */
  public ACPanel getNurses(){
    if(nurses==null){

      nurses = new ACPanel();

      addNurses();
    }
    return nurses;

  }

  /**
   * �Ō�t�̈�E�O���[�v���擾���܂��B
   * @return �Ō�t�̈�E�O���[�v
   */
  public ACGroupBox getNurse(){
    if(nurse==null){

      nurse = new ACGroupBox();

      nurse.setText("�Ō�t��");

      nurse.setHgap(4);

      nurse.setLabelMargin(3);

      addNurse();
    }
    return nurse;

  }

  /**
   * �Ō�t�������擾���܂��B
   * @return �Ō�t����
   */
  public ACTextField getNurseName(){
    if(nurseName==null){

      nurseName = new ACTextField();

      getNurseNameContainer().setText("����");

      nurseName.setBindPath("NURSE_NAME");

      nurseName.setColumns(25);

      nurseName.setIMEMode(InputSubset.KANJI);

      nurseName.setMaxLength(32);

      addNurseName();
    }
    return nurseName;

  }

  /**
   * �Ō�t�����R���e�i���擾���܂��B
   * @return �Ō�t�����R���e�i
   */
  protected ACLabelContainer getNurseNameContainer(){
    if(nurseNameContainer==null){
      nurseNameContainer = new ACLabelContainer();
      nurseNameContainer.setFollowChildEnabled(true);
      nurseNameContainer.setVAlignment(VRLayout.CENTER);
      nurseNameContainer.add(getNurseName(), null);
    }
    return nurseNameContainer;
  }

  /**
   * �Ō�t����K��N�������擾���܂��B
   * @return �Ō�t����K��N����
   */
  public ACLabelContainer getFirstVisitDates(){
    if(firstVisitDates==null){

      firstVisitDates = new ACLabelContainer();

      firstVisitDates.setText("����K��N����");

      addFirstVisitDates();
    }
    return firstVisitDates;

  }

  /**
   * �Ō�t����K��N����(�J�n���ԁj���擾���܂��B
   * @return �Ō�t����K��N����(�J�n���ԁj
   */
  public QkanDateTextField getFirstVisitDateStart(){
    if(firstVisitDateStart==null){

      firstVisitDateStart = new QkanDateTextField();

      firstVisitDateStart.setBindPath("FIRST_VISIT_DATE");

      addFirstVisitDateStart();
    }
    return firstVisitDateStart;

  }

  /**
   * �Ō�t����K��N�����E�������擾���܂��B
   * @return �Ō�t����K��N�����E����
   */
  public ACLabel getFirstVisitDateTimeLabel(){
    if(firstVisitDateTimeLabel==null){

      firstVisitDateTimeLabel = new ACLabel();

      firstVisitDateTimeLabel.setText("����");

      firstVisitDateTimeLabel.setHorizontalAlignment(SwingConstants.CENTER);

      addFirstVisitDateTimeLabel();
    }
    return firstVisitDateTimeLabel;

  }

  /**
   * �Ō�t����K��N����(�����擾���܂��B
   * @return �Ō�t����K��N����(��
   */
  public ACTimeTextField getFirstVisitDateStartHour(){
    if(firstVisitDateStartHour==null){

      firstVisitDateStartHour = new ACTimeTextField();

      firstVisitDateStartHour.setBindPath("FIRST_VISIT_DATE_START");

      firstVisitDateStartHour.setColumns(3);

      firstVisitDateStartHour.setIMEMode(InputSubset.LATIN);

      firstVisitDateStartHour.setMaxLength(5);

      addFirstVisitDateStartHour();
    }
    return firstVisitDateStartHour;

  }

  /**
   * �Ō�t����K��N�����E���x�����擾���܂��B
   * @return �Ō�t����K��N�����E���x��
   */
  public ACLabel getFirstVisitDateLabel(){
    if(firstVisitDateLabel==null){

      firstVisitDateLabel = new ACLabel();

      firstVisitDateLabel.setText("����");

      firstVisitDateLabel.setHorizontalAlignment(SwingConstants.CENTER);

      addFirstVisitDateLabel();
    }
    return firstVisitDateLabel;

  }

  /**
   * �Ō�t����K��N����(�I�����ԁj���擾���܂��B
   * @return �Ō�t����K��N����(�I�����ԁj
   */
  public ACTimeTextField getFirstVisitDateEndHour(){
    if(firstVisitDateEndHour==null){

      firstVisitDateEndHour = new ACTimeTextField();

      firstVisitDateEndHour.setBindPath("FIRST_VISIT_DATE_END");

      firstVisitDateEndHour.setColumns(3);

      firstVisitDateEndHour.setIMEMode(InputSubset.LATIN);

      firstVisitDateEndHour.setMaxLength(5);

      addFirstVisitDateEndHour();
    }
    return firstVisitDateEndHour;

  }

  /**
   * �^�u���擾���܂��B
   * @return �^�u
   */
  public JTabbedPane getTabs(){
    if(tabs==null){

      tabs = new JTabbedPane();

      addTabs();
    }
    return tabs;

  }

  /**
   * NO.1 ���a���E�a��E��̈���擾���܂��B
   * @return NO.1 ���a���E�a��E��̈�
   */
  public ACPanel getPoints1(){
    if(points1==null){

      points1 = new ACPanel();

      addPoints1();
    }
    return points1;

  }

  /**
   * �傽�鏝�a���E�O���[�v���擾���܂��B
   * @return �傽�鏝�a���E�O���[�v
   */
  public ACGroupBox getMainDiseases(){
    if(mainDiseases==null){

      mainDiseases = new ACGroupBox();

      mainDiseases.setText("�傽�鏝�a��(37x4)");

      mainDiseases.setAutoWrap(false);

      mainDiseases.setHgap(0);

      mainDiseases.setLabelMargin(0);

      addMainDiseases();
    }
    return mainDiseases;

  }

  /**
   * ��ȏ��a�����擾���܂��B
   * @return ��ȏ��a��
   */
  public ACTextArea getMainDisease(){
    if(mainDisease==null){

      mainDisease = new ACTextArea();

      mainDisease.setBindPath("DISEASE");

      mainDisease.setColumns(74);

      mainDisease.setRows(5);

      mainDisease.setMaxRows(4);

      mainDisease.setIMEMode(InputSubset.KANJI);

      mainDisease.setMaxLength(148);

      mainDisease.setLineWrap(true);

      addMainDisease();
    }
    return mainDisease;

  }

  /**
   * ��ȏ��a���R���e�i���擾���܂��B
   * @return ��ȏ��a���R���e�i
   */
  protected ACLabelContainer getMainDiseaseContainer(){
    if(mainDiseaseContainer==null){
      mainDiseaseContainer = new ACLabelContainer();
      mainDiseaseContainer.setFollowChildEnabled(true);
      mainDiseaseContainer.setVAlignment(VRLayout.CENTER);
      mainDiseaseContainer.add(getMainDisease(), null);
    }
    return mainDiseaseContainer;
  }

  /**
   * �a��E���Ï�ԓ��E�O���[�v���擾���܂��B
   * @return �a��E���Ï�ԓ��E�O���[�v
   */
  public ACGroupBox getDiseaseConditionAndTreatments(){
    if(diseaseConditionAndTreatments==null){

      diseaseConditionAndTreatments = new ACGroupBox();

      diseaseConditionAndTreatments.setText("�a��E���Ï�ԓ�(37x8)");

      diseaseConditionAndTreatments.setAutoWrap(false);

      diseaseConditionAndTreatments.setHgap(0);

      diseaseConditionAndTreatments.setLabelMargin(0);

      addDiseaseConditionAndTreatments();
    }
    return diseaseConditionAndTreatments;

  }

  /**
   * �a�󥎡�Ï�ԓ����擾���܂��B
   * @return �a�󥎡�Ï�ԓ�
   */
  public ACTextArea getDiseaseConditionAndTreatment(){
    if(diseaseConditionAndTreatment==null){

      diseaseConditionAndTreatment = new ACTextArea();

      diseaseConditionAndTreatment.setBindPath("BYOJO_CHIYU_JOTAI");

      diseaseConditionAndTreatment.setColumns(74);

      diseaseConditionAndTreatment.setRows(9);

      diseaseConditionAndTreatment.setMaxRows(8);

      diseaseConditionAndTreatment.setIMEMode(InputSubset.KANJI);

      diseaseConditionAndTreatment.setMaxLength(296);

      diseaseConditionAndTreatment.setLineWrap(true);

      addDiseaseConditionAndTreatment();
    }
    return diseaseConditionAndTreatment;

  }

  /**
   * �a�󥎡�Ï�ԓ��R���e�i���擾���܂��B
   * @return �a�󥎡�Ï�ԓ��R���e�i
   */
  protected ACLabelContainer getDiseaseConditionAndTreatmentContainer(){
    if(diseaseConditionAndTreatmentContainer==null){
      diseaseConditionAndTreatmentContainer = new ACLabelContainer();
      diseaseConditionAndTreatmentContainer.setFollowChildEnabled(true);
      diseaseConditionAndTreatmentContainer.setVAlignment(VRLayout.CENTER);
      diseaseConditionAndTreatmentContainer.add(getDiseaseConditionAndTreatment(), null);
    }
    return diseaseConditionAndTreatmentContainer;
  }

  /**
   * NO.1 ���a���E�������E���������擾���܂��B
   * @return NO.1 ���a���E�������E������
   */
  public ACPanel getPoints2(){
    if(points2==null){

      points2 = new ACPanel();

      addPoints2();
    }
    return points2;

  }

  /**
   * ���a���E�O���[�v���擾���܂��B
   * @return ���a���E�O���[�v
   */
  public ACGroupBox getGenbyorekis(){
    if(genbyorekis==null){

      genbyorekis = new ACGroupBox();

      genbyorekis.setText("���a��(37x7)");

      genbyorekis.setAutoWrap(false);

      genbyorekis.setHgap(0);

      genbyorekis.setLabelMargin(0);

      addGenbyorekis();
    }
    return genbyorekis;

  }

  /**
   * ���a�����擾���܂��B
   * @return ���a��
   */
  public ACTextArea getGenbyoreki(){
    if(genbyoreki==null){

      genbyoreki = new ACTextArea();

      genbyoreki.setBindPath("GENBYOREKI");

      genbyoreki.setColumns(74);

      genbyoreki.setRows(8);

      genbyoreki.setMaxRows(7);

      genbyoreki.setIMEMode(InputSubset.KANJI);

      genbyoreki.setMaxLength(259);

      genbyoreki.setLineWrap(true);

      addGenbyoreki();
    }
    return genbyoreki;

  }

  /**
   * ���a���R���e�i���擾���܂��B
   * @return ���a���R���e�i
   */
  protected ACLabelContainer getGenbyorekiContainer(){
    if(genbyorekiContainer==null){
      genbyorekiContainer = new ACLabelContainer();
      genbyorekiContainer.setFollowChildEnabled(true);
      genbyorekiContainer.setVAlignment(VRLayout.CENTER);
      genbyorekiContainer.add(getGenbyoreki(), null);
    }
    return genbyorekiContainer;
  }

  /**
   * �������E�O���[�v���擾���܂��B
   * @return �������E�O���[�v
   */
  public ACGroupBox getExistingAddressHistorys(){
    if(existingAddressHistorys==null){

      existingAddressHistorys = new ACGroupBox();

      existingAddressHistorys.setText("������(37x7)");

      existingAddressHistorys.setAutoWrap(false);

      existingAddressHistorys.setHgap(0);

      existingAddressHistorys.setLabelMargin(0);

      addExistingAddressHistorys();
    }
    return existingAddressHistorys;

  }

  /**
   * ���������擾���܂��B
   * @return ������
   */
  public ACTextArea getExistingAddressHistory(){
    if(existingAddressHistory==null){

      existingAddressHistory = new ACTextArea();

      existingAddressHistory.setBindPath("KIOREKI");

      existingAddressHistory.setColumns(74);

      existingAddressHistory.setRows(8);

      existingAddressHistory.setMaxRows(7);

      existingAddressHistory.setIMEMode(InputSubset.KANJI);

      existingAddressHistory.setMaxLength(259);

      existingAddressHistory.setLineWrap(true);

      addExistingAddressHistory();
    }
    return existingAddressHistory;

  }

  /**
   * �������R���e�i���擾���܂��B
   * @return �������R���e�i
   */
  protected ACLabelContainer getExistingAddressHistoryContainer(){
    if(existingAddressHistoryContainer==null){
      existingAddressHistoryContainer = new ACLabelContainer();
      existingAddressHistoryContainer.setFollowChildEnabled(true);
      existingAddressHistoryContainer.setVAlignment(VRLayout.CENTER);
      existingAddressHistoryContainer.add(getExistingAddressHistory(), null);
    }
    return existingAddressHistoryContainer;
  }

  /**
   * NO.1 ���������擾���܂��B
   * @return NO.1 ������
   */
  public ACPanel getPoints3(){
    if(points3==null){

      points3 = new ACPanel();

      addPoints3();
    }
    return points3;

  }

  /**
   * �������E�O���[�v���擾���܂��B
   * @return �������E�O���[�v
   */
  public ACGroupBox getLifeHistorys(){
    if(lifeHistorys==null){

      lifeHistorys = new ACGroupBox();

      lifeHistorys.setText("������(37x7)");

      lifeHistorys.setAutoWrap(false);

      lifeHistorys.setHgap(0);

      lifeHistorys.setLabelMargin(0);

      addLifeHistorys();
    }
    return lifeHistorys;

  }

  /**
   * ���������擾���܂��B
   * @return ������
   */
  public ACTextArea getLifeHistory(){
    if(lifeHistory==null){

      lifeHistory = new ACTextArea();

      lifeHistory.setBindPath("SEIKATSUREKI");

      lifeHistory.setColumns(74);

      lifeHistory.setRows(8);

      lifeHistory.setMaxRows(7);

      lifeHistory.setIMEMode(InputSubset.KANJI);

      lifeHistory.setMaxLength(259);

      lifeHistory.setLineWrap(true);

      addLifeHistory();
    }
    return lifeHistory;

  }

  /**
   * �������R���e�i���擾���܂��B
   * @return �������R���e�i
   */
  protected ACLabelContainer getLifeHistoryContainer(){
    if(lifeHistoryContainer==null){
      lifeHistoryContainer = new ACLabelContainer();
      lifeHistoryContainer.setFollowChildEnabled(true);
      lifeHistoryContainer.setVAlignment(VRLayout.CENTER);
      lifeHistoryContainer.add(getLifeHistory(), null);
    }
    return lifeHistoryContainer;
  }

  /**
   * �Ƒ��\���E�O���[�v���擾���܂��B
   * @return �Ƒ��\���E�O���[�v
   */
  public ACGroupBox getFamilyStructureas(){
    if(familyStructureas==null){

      familyStructureas = new ACGroupBox();

      familyStructureas.setText("�Ƒ��\��");

      familyStructureas.setLayout(getFamilyStructre());

      addFamilyStructureas();
    }
    return familyStructureas;

  }

  /**
   * �Ƒ��\���E���C�A�E�g���擾���܂��B
   * @return �Ƒ��\���E���C�A�E�g
   */
  public GridBagLayout getFamilyStructre(){
    if(familyStructre==null){

      familyStructre = new GridBagLayout();

      addFamilyStructre();
    }
    return familyStructre;

  }

  /**
   * ����(�w�b�_���擾���܂��B
   * @return ����(�w�b�_
   */
  public ACLabel getFamilyStructreNameHeader(){
    if(familyStructreNameHeader==null){

      familyStructreNameHeader = new ACLabel();

      familyStructreNameHeader.setText("����");

      addFamilyStructreNameHeader();
    }
    return familyStructreNameHeader;

  }

  /**
   * �N��(�w�b�_���擾���܂��B
   * @return �N��(�w�b�_
   */
  public ACLabel getFamilyStructreAgeHeader(){
    if(familyStructreAgeHeader==null){

      familyStructreAgeHeader = new ACLabel();

      familyStructreAgeHeader.setText("�N��");

      addFamilyStructreAgeHeader();
    }
    return familyStructreAgeHeader;

  }

  /**
   * ����(�w�b�_���擾���܂��B
   * @return ����(�w�b�_
   */
  public ACLabel getFamilyStructreRelationHeader(){
    if(familyStructreRelationHeader==null){

      familyStructreRelationHeader = new ACLabel();

      familyStructreRelationHeader.setText("����");

      addFamilyStructreRelationHeader();
    }
    return familyStructreRelationHeader;

  }

  /**
   * �E��(�w�b�_���擾���܂��B
   * @return �E��(�w�b�_
   */
  public ACLabel getFamilyStructreJobHeader(){
    if(familyStructreJobHeader==null){

      familyStructreJobHeader = new ACLabel();

      familyStructreJobHeader.setText("�E��");

      addFamilyStructreJobHeader();
    }
    return familyStructreJobHeader;

  }

  /**
   * ���L���ׂ�����(�w�b�_���擾���܂��B
   * @return ���L���ׂ�����(�w�b�_
   */
  public ACLabel getFamilyStructreCommentHeader(){
    if(familyStructreCommentHeader==null){

      familyStructreCommentHeader = new ACLabel();

      familyStructreCommentHeader.setText("���L���ׂ�����");

      addFamilyStructreCommentHeader();
    }
    return familyStructreCommentHeader;

  }

  /**
   * ����1���擾���܂��B
   * @return ����1
   */
  public ACTextField getFamilyStructreName1(){
    if(familyStructreName1==null){

      familyStructreName1 = new ACTextField();

      familyStructreName1.setBindPath("FAMILY_NAME1");

      familyStructreName1.setColumns(20);

      familyStructreName1.setIMEMode(InputSubset.KANJI);

      familyStructreName1.setMaxLength(22);

      addFamilyStructreName1();
    }
    return familyStructreName1;

  }

  /**
   * �N��1���擾���܂��B
   * @return �N��1
   */
  public ACTextField getFamilyStructreAge1(){
    if(familyStructreAge1==null){

      familyStructreAge1 = new ACTextField();

      familyStructreAge1.setBindPath("FAMILY_AGE1");

      familyStructreAge1.setColumns(3);

      familyStructreAge1.setCharType(VRCharType.ONLY_DIGIT);

      familyStructreAge1.setHorizontalAlignment(SwingConstants.RIGHT);

      familyStructreAge1.setIMEMode(InputSubset.LATIN);

      familyStructreAge1.setMaxLength(3);

      addFamilyStructreAge1();
    }
    return familyStructreAge1;

  }

  /**
   * ����1���擾���܂��B
   * @return ����1
   */
  public ACTextField getFamilyStructreRelation1(){
    if(familyStructreRelation1==null){

      familyStructreRelation1 = new ACTextField();

      familyStructreRelation1.setBindPath("FAMILY_RELATION1");

      familyStructreRelation1.setColumns(6);

      familyStructreRelation1.setIMEMode(InputSubset.KANJI);

      familyStructreRelation1.setMaxLength(6);

      addFamilyStructreRelation1();
    }
    return familyStructreRelation1;

  }

  /**
   * �E��1���擾���܂��B
   * @return �E��1
   */
  public ACTextField getFamilyStructreJob1(){
    if(familyStructreJob1==null){

      familyStructreJob1 = new ACTextField();

      familyStructreJob1.setBindPath("FAMILY_JOB1");

      familyStructreJob1.setColumns(10);

      familyStructreJob1.setIMEMode(InputSubset.KANJI);

      familyStructreJob1.setMaxLength(12);

      addFamilyStructreJob1();
    }
    return familyStructreJob1;

  }

  /**
   * ���L���ׂ�����1���擾���܂��B
   * @return ���L���ׂ�����1
   */
  public ACTextField getFamilyStructreComment1(){
    if(familyStructreComment1==null){

      familyStructreComment1 = new ACTextField();

      familyStructreComment1.setBindPath("FAMILY_COMMENT1");

      familyStructreComment1.setColumns(26);

      familyStructreComment1.setIMEMode(InputSubset.KANJI);

      familyStructreComment1.setMaxLength(30);

      addFamilyStructreComment1();
    }
    return familyStructreComment1;

  }

  /**
   * ����2���擾���܂��B
   * @return ����2
   */
  public ACTextField getFamilyStructreName2(){
    if(familyStructreName2==null){

      familyStructreName2 = new ACTextField();

      familyStructreName2.setBindPath("FAMILY_NAME2");

      familyStructreName2.setColumns(20);

      familyStructreName2.setIMEMode(InputSubset.KANJI);

      familyStructreName2.setMaxLength(22);

      addFamilyStructreName2();
    }
    return familyStructreName2;

  }

  /**
   * �N��2���擾���܂��B
   * @return �N��2
   */
  public ACTextField getFamilyStructreAge2(){
    if(familyStructreAge2==null){

      familyStructreAge2 = new ACTextField();

      familyStructreAge2.setBindPath("FAMILY_AGE2");

      familyStructreAge2.setColumns(3);

      familyStructreAge2.setCharType(VRCharType.ONLY_DIGIT);

      familyStructreAge2.setHorizontalAlignment(SwingConstants.RIGHT);

      familyStructreAge2.setIMEMode(InputSubset.LATIN);

      familyStructreAge2.setMaxLength(3);

      addFamilyStructreAge2();
    }
    return familyStructreAge2;

  }

  /**
   * ����2���擾���܂��B
   * @return ����2
   */
  public ACTextField getFamilyStructreRelation2(){
    if(familyStructreRelation2==null){

      familyStructreRelation2 = new ACTextField();

      familyStructreRelation2.setBindPath("FAMILY_RELATION2");

      familyStructreRelation2.setColumns(6);

      familyStructreRelation2.setIMEMode(InputSubset.KANJI);

      familyStructreRelation2.setMaxLength(6);

      addFamilyStructreRelation2();
    }
    return familyStructreRelation2;

  }

  /**
   * �E��2���擾���܂��B
   * @return �E��2
   */
  public ACTextField getFamilyStructreJob2(){
    if(familyStructreJob2==null){

      familyStructreJob2 = new ACTextField();

      familyStructreJob2.setBindPath("FAMILY_JOB2");

      familyStructreJob2.setColumns(10);

      familyStructreJob2.setIMEMode(InputSubset.KANJI);

      familyStructreJob2.setMaxLength(12);

      addFamilyStructreJob2();
    }
    return familyStructreJob2;

  }

  /**
   * ���L���ׂ�����2���擾���܂��B
   * @return ���L���ׂ�����2
   */
  public ACTextField getFamilyStructreComment2(){
    if(familyStructreComment2==null){

      familyStructreComment2 = new ACTextField();

      familyStructreComment2.setBindPath("FAMILY_COMMENT2");

      familyStructreComment2.setColumns(26);

      familyStructreComment2.setIMEMode(InputSubset.KANJI);

      familyStructreComment2.setMaxLength(30);

      addFamilyStructreComment2();
    }
    return familyStructreComment2;

  }

  /**
   * ����3���擾���܂��B
   * @return ����3
   */
  public ACTextField getFamilyStructreName3(){
    if(familyStructreName3==null){

      familyStructreName3 = new ACTextField();

      familyStructreName3.setBindPath("FAMILY_NAME3");

      familyStructreName3.setColumns(20);

      familyStructreName3.setIMEMode(InputSubset.KANJI);

      familyStructreName3.setMaxLength(22);

      addFamilyStructreName3();
    }
    return familyStructreName3;

  }

  /**
   * �N��3���擾���܂��B
   * @return �N��3
   */
  public ACTextField getFamilyStructreAge3(){
    if(familyStructreAge3==null){

      familyStructreAge3 = new ACTextField();

      familyStructreAge3.setBindPath("FAMILY_AGE3");

      familyStructreAge3.setColumns(3);

      familyStructreAge3.setCharType(VRCharType.ONLY_DIGIT);

      familyStructreAge3.setHorizontalAlignment(SwingConstants.RIGHT);

      familyStructreAge3.setIMEMode(InputSubset.LATIN);

      familyStructreAge3.setMaxLength(3);

      addFamilyStructreAge3();
    }
    return familyStructreAge3;

  }

  /**
   * ����3���擾���܂��B
   * @return ����3
   */
  public ACTextField getFamilyStructreRelation3(){
    if(familyStructreRelation3==null){

      familyStructreRelation3 = new ACTextField();

      familyStructreRelation3.setBindPath("FAMILY_RELATION3");

      familyStructreRelation3.setColumns(6);

      familyStructreRelation3.setIMEMode(InputSubset.KANJI);

      familyStructreRelation3.setMaxLength(6);

      addFamilyStructreRelation3();
    }
    return familyStructreRelation3;

  }

  /**
   * �E��3���擾���܂��B
   * @return �E��3
   */
  public ACTextField getFamilyStructreJob3(){
    if(familyStructreJob3==null){

      familyStructreJob3 = new ACTextField();

      familyStructreJob3.setBindPath("FAMILY_JOB3");

      familyStructreJob3.setColumns(10);

      familyStructreJob3.setIMEMode(InputSubset.KANJI);

      familyStructreJob3.setMaxLength(12);

      addFamilyStructreJob3();
    }
    return familyStructreJob3;

  }

  /**
   * ���L���ׂ�����3���擾���܂��B
   * @return ���L���ׂ�����3
   */
  public ACTextField getFamilyStructreComment3(){
    if(familyStructreComment3==null){

      familyStructreComment3 = new ACTextField();

      familyStructreComment3.setBindPath("FAMILY_COMMENT3");

      familyStructreComment3.setColumns(26);

      familyStructreComment3.setIMEMode(InputSubset.KANJI);

      familyStructreComment3.setMaxLength(30);

      addFamilyStructreComment3();
    }
    return familyStructreComment3;

  }

  /**
   * ����4���擾���܂��B
   * @return ����4
   */
  public ACTextField getFamilyStructreName4(){
    if(familyStructreName4==null){

      familyStructreName4 = new ACTextField();

      familyStructreName4.setBindPath("FAMILY_NAME4");

      familyStructreName4.setColumns(20);

      familyStructreName4.setIMEMode(InputSubset.KANJI);

      familyStructreName4.setMaxLength(22);

      addFamilyStructreName4();
    }
    return familyStructreName4;

  }

  /**
   * �N��4���擾���܂��B
   * @return �N��4
   */
  public ACTextField getFamilyStructreAge4(){
    if(familyStructreAge4==null){

      familyStructreAge4 = new ACTextField();

      familyStructreAge4.setBindPath("FAMILY_AGE4");

      familyStructreAge4.setColumns(3);

      familyStructreAge4.setCharType(VRCharType.ONLY_DIGIT);

      familyStructreAge4.setHorizontalAlignment(SwingConstants.RIGHT);

      familyStructreAge4.setIMEMode(InputSubset.LATIN);

      familyStructreAge4.setMaxLength(3);

      addFamilyStructreAge4();
    }
    return familyStructreAge4;

  }

  /**
   * ����4���擾���܂��B
   * @return ����4
   */
  public ACTextField getFamilyStructreRelation4(){
    if(familyStructreRelation4==null){

      familyStructreRelation4 = new ACTextField();

      familyStructreRelation4.setBindPath("FAMILY_RELATION4");

      familyStructreRelation4.setColumns(6);

      familyStructreRelation4.setIMEMode(InputSubset.KANJI);

      familyStructreRelation4.setMaxLength(6);

      addFamilyStructreRelation4();
    }
    return familyStructreRelation4;

  }

  /**
   * �E��4���擾���܂��B
   * @return �E��4
   */
  public ACTextField getFamilyStructreJob4(){
    if(familyStructreJob4==null){

      familyStructreJob4 = new ACTextField();

      familyStructreJob4.setBindPath("FAMILY_JOB4");

      familyStructreJob4.setColumns(10);

      familyStructreJob4.setIMEMode(InputSubset.KANJI);

      familyStructreJob4.setMaxLength(12);

      addFamilyStructreJob4();
    }
    return familyStructreJob4;

  }

  /**
   * ���L���ׂ�����4���擾���܂��B
   * @return ���L���ׂ�����4
   */
  public ACTextField getFamilyStructreComment4(){
    if(familyStructreComment4==null){

      familyStructreComment4 = new ACTextField();

      familyStructreComment4.setBindPath("FAMILY_COMMENT4");

      familyStructreComment4.setColumns(26);

      familyStructreComment4.setIMEMode(InputSubset.KANJI);

      familyStructreComment4.setMaxLength(30);

      addFamilyStructreComment4();
    }
    return familyStructreComment4;

  }

  /**
   * ����5���擾���܂��B
   * @return ����5
   */
  public ACTextField getFamilyStructreName5(){
    if(familyStructreName5==null){

      familyStructreName5 = new ACTextField();

      familyStructreName5.setBindPath("FAMILY_NAME5");

      familyStructreName5.setColumns(20);

      familyStructreName5.setIMEMode(InputSubset.KANJI);

      familyStructreName5.setMaxLength(22);

      addFamilyStructreName5();
    }
    return familyStructreName5;

  }

  /**
   * �N��5���擾���܂��B
   * @return �N��5
   */
  public ACTextField getFamilyStructreAge5(){
    if(familyStructreAge5==null){

      familyStructreAge5 = new ACTextField();

      familyStructreAge5.setBindPath("FAMILY_AGE5");

      familyStructreAge5.setColumns(3);

      familyStructreAge5.setCharType(VRCharType.ONLY_DIGIT);

      familyStructreAge5.setHorizontalAlignment(SwingConstants.RIGHT);

      familyStructreAge5.setIMEMode(InputSubset.LATIN);

      familyStructreAge5.setMaxLength(3);

      addFamilyStructreAge5();
    }
    return familyStructreAge5;

  }

  /**
   * ����5���擾���܂��B
   * @return ����5
   */
  public ACTextField getFamilyStructreRelation5(){
    if(familyStructreRelation5==null){

      familyStructreRelation5 = new ACTextField();

      familyStructreRelation5.setBindPath("FAMILY_RELATION5");

      familyStructreRelation5.setColumns(6);

      familyStructreRelation5.setIMEMode(InputSubset.KANJI);

      familyStructreRelation5.setMaxLength(6);

      addFamilyStructreRelation5();
    }
    return familyStructreRelation5;

  }

  /**
   * �E��5���擾���܂��B
   * @return �E��5
   */
  public ACTextField getFamilyStructreJob5(){
    if(familyStructreJob5==null){

      familyStructreJob5 = new ACTextField();

      familyStructreJob5.setBindPath("FAMILY_JOB5");

      familyStructreJob5.setColumns(10);

      familyStructreJob5.setIMEMode(InputSubset.KANJI);

      familyStructreJob5.setMaxLength(12);

      addFamilyStructreJob5();
    }
    return familyStructreJob5;

  }

  /**
   * ���L���ׂ�����5���擾���܂��B
   * @return ���L���ׂ�����5
   */
  public ACTextField getFamilyStructreComment5(){
    if(familyStructreComment5==null){

      familyStructreComment5 = new ACTextField();

      familyStructreComment5.setBindPath("FAMILY_COMMENT5");

      familyStructreComment5.setColumns(26);

      familyStructreComment5.setIMEMode(InputSubset.KANJI);

      familyStructreComment5.setMaxLength(30);

      addFamilyStructreComment5();
    }
    return familyStructreComment5;

  }

  /**
   * ����6���擾���܂��B
   * @return ����6
   */
  public ACTextField getFamilyStructreName6(){
    if(familyStructreName6==null){

      familyStructreName6 = new ACTextField();

      familyStructreName6.setBindPath("FAMILY_NAME6");

      familyStructreName6.setColumns(20);

      familyStructreName6.setIMEMode(InputSubset.KANJI);

      familyStructreName6.setMaxLength(22);

      addFamilyStructreName6();
    }
    return familyStructreName6;

  }

  /**
   * �N��6���擾���܂��B
   * @return �N��6
   */
  public ACTextField getFamilyStructreAge6(){
    if(familyStructreAge6==null){

      familyStructreAge6 = new ACTextField();

      familyStructreAge6.setBindPath("FAMILY_AGE6");

      familyStructreAge6.setColumns(3);

      familyStructreAge6.setCharType(VRCharType.ONLY_DIGIT);

      familyStructreAge6.setHorizontalAlignment(SwingConstants.RIGHT);

      familyStructreAge6.setIMEMode(InputSubset.LATIN);

      familyStructreAge6.setMaxLength(3);

      addFamilyStructreAge6();
    }
    return familyStructreAge6;

  }

  /**
   * ����6���擾���܂��B
   * @return ����6
   */
  public ACTextField getFamilyStructreRelation6(){
    if(familyStructreRelation6==null){

      familyStructreRelation6 = new ACTextField();

      familyStructreRelation6.setBindPath("FAMILY_RELATION6");

      familyStructreRelation6.setColumns(6);

      familyStructreRelation6.setIMEMode(InputSubset.KANJI);

      familyStructreRelation6.setMaxLength(6);

      addFamilyStructreRelation6();
    }
    return familyStructreRelation6;

  }

  /**
   * �E��6���擾���܂��B
   * @return �E��6
   */
  public ACTextField getFamilyStructreJob6(){
    if(familyStructreJob6==null){

      familyStructreJob6 = new ACTextField();

      familyStructreJob6.setBindPath("FAMILY_JOB6");

      familyStructreJob6.setColumns(10);

      familyStructreJob6.setIMEMode(InputSubset.KANJI);

      familyStructreJob6.setMaxLength(12);

      addFamilyStructreJob6();
    }
    return familyStructreJob6;

  }

  /**
   * ���L���ׂ�����6���擾���܂��B
   * @return ���L���ׂ�����6
   */
  public ACTextField getFamilyStructreComment6(){
    if(familyStructreComment6==null){

      familyStructreComment6 = new ACTextField();

      familyStructreComment6.setBindPath("FAMILY_COMMENT6");

      familyStructreComment6.setColumns(26);

      familyStructreComment6.setIMEMode(InputSubset.KANJI);

      familyStructreComment6.setMaxLength(30);

      addFamilyStructreComment6();
    }
    return familyStructreComment6;

  }

  /**
   * NO.1 ��ȉ��ҁE�Z�����擾���܂��B
   * @return NO.1 ��ȉ��ҁE�Z��
   */
  public ACPanel getPoints4(){
    if(points4==null){

      points4 = new ACPanel();

      addPoints4();
    }
    return points4;

  }

  /**
   * ��ȉ��ҁE�O���[�v���擾���܂��B
   * @return ��ȉ��ҁE�O���[�v
   */
  public ACGroupBox getMainCaares(){
    if(mainCaares==null){

      mainCaares = new ACGroupBox();

      mainCaares.setText("��ȉ���(37x3)");

      mainCaares.setAutoWrap(false);

      mainCaares.setHgap(0);

      mainCaares.setLabelMargin(0);

      addMainCaares();
    }
    return mainCaares;

  }

  /**
   * ��ȉ��҂��擾���܂��B
   * @return ��ȉ���
   */
  public ACTextArea getMainCare(){
    if(mainCare==null){

      mainCare = new ACTextArea();

      mainCare.setBindPath("CAREGIVER");

      mainCare.setColumns(74);

      mainCare.setRows(4);

      mainCare.setMaxRows(3);

      mainCare.setIMEMode(InputSubset.KANJI);

      mainCare.setMaxLength(111);

      mainCare.setLineWrap(true);

      addMainCare();
    }
    return mainCare;

  }

  /**
   * ��ȉ��҃R���e�i���擾���܂��B
   * @return ��ȉ��҃R���e�i
   */
  protected ACLabelContainer getMainCareContainer(){
    if(mainCareContainer==null){
      mainCareContainer = new ACLabelContainer();
      mainCareContainer.setFollowChildEnabled(true);
      mainCareContainer.setVAlignment(VRLayout.CENTER);
      mainCareContainer.add(getMainCare(), null);
    }
    return mainCareContainer;
  }

  /**
   * �Z���E�O���[�v���擾���܂��B
   * @return �Z���E�O���[�v
   */
  public ACGroupBox getJyukankyos(){
    if(jyukankyos==null){

      jyukankyos = new ACGroupBox();

      jyukankyos.setText("�Z��(37x4)");

      jyukankyos.setAutoWrap(false);

      jyukankyos.setHgap(0);

      jyukankyos.setLabelMargin(0);

      addJyukankyos();
    }
    return jyukankyos;

  }

  /**
   * �Z�����擾���܂��B
   * @return �Z��
   */
  public ACTextArea getJyukankyo(){
    if(jyukankyo==null){

      jyukankyo = new ACTextArea();

      jyukankyo.setBindPath("HOUSE");

      jyukankyo.setColumns(74);

      jyukankyo.setRows(5);

      jyukankyo.setMaxRows(4);

      jyukankyo.setIMEMode(InputSubset.KANJI);

      jyukankyo.setMaxLength(148);

      jyukankyo.setLineWrap(true);

      addJyukankyo();
    }
    return jyukankyo;

  }

  /**
   * �Z���R���e�i���擾���܂��B
   * @return �Z���R���e�i
   */
  protected ACLabelContainer getJyukankyoContainer(){
    if(jyukankyoContainer==null){
      jyukankyoContainer = new ACLabelContainer();
      jyukankyoContainer.setFollowChildEnabled(true);
      jyukankyoContainer.setVAlignment(VRLayout.CENTER);
      jyukankyoContainer.add(getJyukankyo(), null);
    }
    return jyukankyoContainer;
  }

  /**
   * NO.2 �˗��ړI���擾���܂��B
   * @return NO.2 �˗��ړI
   */
  public ACPanel getPoints5(){
    if(points5==null){

      points5 = new ACPanel();

      addPoints5();
    }
    return points5;

  }

  /**
   * ���p�ҁE�Ƒ��̈˗��ړI�̈�E�O���[�v���擾���܂��B
   * @return ���p�ҁE�Ƒ��̈˗��ړI�̈�E�O���[�v
   */
  public ACGroupBox getPatientAndFamilyRequests(){
    if(patientAndFamilyRequests==null){

      patientAndFamilyRequests = new ACGroupBox();

      patientAndFamilyRequests.setText("���p�ҁE�Ƒ��̈˗��ړI(37x6)");

      patientAndFamilyRequests.setAutoWrap(false);

      patientAndFamilyRequests.setHgap(0);

      patientAndFamilyRequests.setLabelMargin(0);

      addPatientAndFamilyRequests();
    }
    return patientAndFamilyRequests;

  }

  /**
   * ���p�ҁE�Ƒ��̈˗��ړI���擾���܂��B
   * @return ���p�ҁE�Ƒ��̈˗��ړI
   */
  public ACTextArea getPatientAndFamilyRequest(){
    if(patientAndFamilyRequest==null){

      patientAndFamilyRequest = new ACTextArea();

      patientAndFamilyRequest.setBindPath("PURPOSE");

      patientAndFamilyRequest.setColumns(74);

      patientAndFamilyRequest.setRows(7);

      patientAndFamilyRequest.setMaxRows(6);

      patientAndFamilyRequest.setIMEMode(InputSubset.KANJI);

      patientAndFamilyRequest.setMaxLength(222);

      patientAndFamilyRequest.setLineWrap(true);

      addPatientAndFamilyRequest();
    }
    return patientAndFamilyRequest;

  }

  /**
   * ���p�ҁE�Ƒ��̈˗��ړI�R���e�i���擾���܂��B
   * @return ���p�ҁE�Ƒ��̈˗��ړI�R���e�i
   */
  protected ACLabelContainer getPatientAndFamilyRequestContainer(){
    if(patientAndFamilyRequestContainer==null){
      patientAndFamilyRequestContainer = new ACLabelContainer();
      patientAndFamilyRequestContainer.setFollowChildEnabled(true);
      patientAndFamilyRequestContainer.setVAlignment(VRLayout.CENTER);
      patientAndFamilyRequestContainer.add(getPatientAndFamilyRequest(), null);
    }
    return patientAndFamilyRequestContainer;
  }

  /**
   * �厡�㓙�̈�E�O���[�v���擾���܂��B
   * @return �厡�㓙�̈�E�O���[�v
   */
  public ACGroupBox getSyujis(){
    if(syujis==null){

      syujis = new ACGroupBox();

      syujis.setText("�厡�㓙");

      syujis.setAutoWrap(false);

      syujis.setLabelMargin(0);

      addSyujis();
    }
    return syujis;

  }

  /**
   * �厡�㎁�����擾���܂��B
   * @return �厡�㎁��
   */
  public ACTextField getSyujiName(){
    if(syujiName==null){

      syujiName = new ACTextField();

      getSyujiNameContainer().setText("����");

      syujiName.setBindPath("DOCTOR_NAME");

      syujiName.setColumns(25);

      syujiName.setIMEMode(InputSubset.KANJI);

      syujiName.setMaxLength(25);

      addSyujiName();
    }
    return syujiName;

  }

  /**
   * �厡�㎁���R���e�i���擾���܂��B
   * @return �厡�㎁���R���e�i
   */
  protected ACLabelContainer getSyujiNameContainer(){
    if(syujiNameContainer==null){
      syujiNameContainer = new ACLabelContainer();
      syujiNameContainer.setFollowChildEnabled(true);
      syujiNameContainer.setVAlignment(VRLayout.CENTER);
      syujiNameContainer.add(getSyujiName(), null);
    }
    return syujiNameContainer;
  }

  /**
   * �厡���Ë@�ւ��擾���܂��B
   * @return �厡���Ë@��
   */
  public ACComboBox getSyujiMedicalName(){
    if(syujiMedicalName==null){

      syujiMedicalName = new ACComboBox();

      getSyujiMedicalNameContainer().setText("��Ë@��");

      syujiMedicalName.setBindPath("MEDICAL_FACILITY_NAME");

      syujiMedicalName.setColumns(22);

      syujiMedicalName.setModelBindPath("MEDICAL_FACILITY_ID");

      syujiMedicalName.setRenderBindPath("MEDICAL_FACILITY_NAME");

      syujiMedicalName.setIMEMode(InputSubset.KANJI);

      syujiMedicalName.setMaxLength(63);

      syujiMedicalName.setModel(getSyujiMedicalNameModel());

      addSyujiMedicalName();
    }
    return syujiMedicalName;

  }

  /**
   * �厡���Ë@�փR���e�i���擾���܂��B
   * @return �厡���Ë@�փR���e�i
   */
  protected ACLabelContainer getSyujiMedicalNameContainer(){
    if(syujiMedicalNameContainer==null){
      syujiMedicalNameContainer = new ACLabelContainer();
      syujiMedicalNameContainer.setFollowChildEnabled(true);
      syujiMedicalNameContainer.setVAlignment(VRLayout.CENTER);
      syujiMedicalNameContainer.add(getSyujiMedicalName(), null);
    }
    return syujiMedicalNameContainer;
  }

  /**
   * �厡���Ë@�փ��f�����擾���܂��B
   * @return �厡���Ë@�փ��f��
   */
  protected ACComboBoxModelAdapter getSyujiMedicalNameModel(){
    if(syujiMedicalNameModel==null){
      syujiMedicalNameModel = new ACComboBoxModelAdapter();
      addSyujiMedicalNameModel();
    }
    return syujiMedicalNameModel;
  }

  /**
   * �厡�㏊�ݒn���擾���܂��B
   * @return �厡�㏊�ݒn
   */
  public ACTextArea getSyujiAddress(){
    if(syujiAddress==null){

      syujiAddress = new ACTextArea();

      getSyujiAddressContainer().setText("���ݒn");

      syujiAddress.setBindPath("MEDICAL_FACILITY_ADDRESS");

      syujiAddress.setColumns(46);

      syujiAddress.setRows(3);

      syujiAddress.setMaxRows(3);

      syujiAddress.setIMEMode(InputSubset.KANJI);

      syujiAddress.setMaxLength(80);

      syujiAddress.setLineWrap(true);

      addSyujiAddress();
    }
    return syujiAddress;

  }

  /**
   * �厡�㏊�ݒn�R���e�i���擾���܂��B
   * @return �厡�㏊�ݒn�R���e�i
   */
  protected ACLabelContainer getSyujiAddressContainer(){
    if(syujiAddressContainer==null){
      syujiAddressContainer = new ACLabelContainer();
      syujiAddressContainer.setFollowChildEnabled(true);
      syujiAddressContainer.setVAlignment(VRLayout.CENTER);
      syujiAddressContainer.add(getSyujiAddress(), null);
    }
    return syujiAddressContainer;
  }

  /**
   * �厡��d�b�ԍ����擾���܂��B
   * @return �厡��d�b�ԍ�
   */
  public ACLabelContainer getSuijiTels(){
    if(suijiTels==null){

      suijiTels = new ACLabelContainer();

      suijiTels.setText("�d�b�ԍ�");

      addSuijiTels();
    }
    return suijiTels;

  }

  /**
   * �厡��d�b�ԍ�1���擾���܂��B
   * @return �厡��d�b�ԍ�1
   */
  public ACTextField getSyujiTel1(){
    if(syujiTel1==null){

      syujiTel1 = new ACTextField();

      syujiTel1.setBindPath("MEDICAL_FACILITY_TEL_FIRST");

      syujiTel1.setColumns(4);

      syujiTel1.setCharType(VRCharType.ONLY_DIGIT);

      syujiTel1.setIMEMode(InputSubset.LATIN);

      syujiTel1.setMaxLength(6);

      addSyujiTel1();
    }
    return syujiTel1;

  }

  /**
   * �厡��d�b�ԍ����x��1���擾���܂��B
   * @return �厡��d�b�ԍ����x��1
   */
  public ACLabel getSyujiLabel1(){
    if(syujiLabel1==null){

      syujiLabel1 = new ACLabel();

      syujiLabel1.setText("-");

      addSyujiLabel1();
    }
    return syujiLabel1;

  }

  /**
   * �厡��d�b�ԍ�2���擾���܂��B
   * @return �厡��d�b�ԍ�2
   */
  public ACTextField getSyujiTel2(){
    if(syujiTel2==null){

      syujiTel2 = new ACTextField();

      syujiTel2.setBindPath("MEDICAL_FACILITY_TEL_SECOND");

      syujiTel2.setColumns(4);

      syujiTel2.setCharType(VRCharType.ONLY_DIGIT);

      syujiTel2.setIMEMode(InputSubset.LATIN);

      syujiTel2.setMaxLength(4);

      addSyujiTel2();
    }
    return syujiTel2;

  }

  /**
   * �厡��d�b�ԍ����x��2���擾���܂��B
   * @return �厡��d�b�ԍ����x��2
   */
  public ACLabel getSyujiLabel2(){
    if(syujiLabel2==null){

      syujiLabel2 = new ACLabel();

      syujiLabel2.setText("-");

      addSyujiLabel2();
    }
    return syujiLabel2;

  }

  /**
   * �厡��d�b�ԍ�3���擾���܂��B
   * @return �厡��d�b�ԍ�3
   */
  public ACTextField getSyujiTel3(){
    if(syujiTel3==null){

      syujiTel3 = new ACTextField();

      syujiTel3.setBindPath("MEDICAL_FACILITY_TEL_THIRD");

      syujiTel3.setColumns(4);

      syujiTel3.setCharType(VRCharType.ONLY_DIGIT);

      syujiTel3.setIMEMode(InputSubset.LATIN);

      syujiTel3.setMaxLength(4);

      addSyujiTel3();
    }
    return syujiTel3;

  }

  /**
   * NO.2 ADL���擾���܂��B
   * @return NO.2 ADL
   */
  public ACPanel getPoints6(){
    if(points6==null){

      points6 = new ACPanel();

      addPoints6();
    }
    return points6;

  }

  /**
   * ADL�̏󋵗̈�E�O���[�v���擾���܂��B
   * @return ADL�̏󋵗̈�E�O���[�v
   */
  public ACGroupBox getRequestObjects(){
    if(RequestObjects==null){

      RequestObjects = new ACGroupBox();

      RequestObjects.setText("ADL�̏�");

      RequestObjects.setAutoWrap(false);

      RequestObjects.setVgap(6);

      addRequestObjects();
    }
    return RequestObjects;

  }

  /**
   * �ړ����擾���܂��B
   * @return �ړ�
   */
  public ACClearableRadioButtonGroup getRequestObjectMove(){
    if(RequestObjectMove==null){

      RequestObjectMove = new ACClearableRadioButtonGroup();

      getRequestObjectMoveContainer().setText("�ړ�");

      RequestObjectMove.setBindPath("ADL_MOVE");

      RequestObjectMove.setNoSelectIndex(0);

      RequestObjectMove.setUseClearButton(true);

      RequestObjectMove.setModel(getRequestObjectMoveModel());

      addRequestObjectMove();
    }
    return RequestObjectMove;

  }

  /**
   * �ړ��R���e�i���擾���܂��B
   * @return �ړ��R���e�i
   */
  protected ACLabelContainer getRequestObjectMoveContainer(){
    if(RequestObjectMoveContainer==null){
      RequestObjectMoveContainer = new ACLabelContainer();
      RequestObjectMoveContainer.setFollowChildEnabled(true);
      RequestObjectMoveContainer.setVAlignment(VRLayout.CENTER);
      RequestObjectMoveContainer.add(getRequestObjectMove(), null);
    }
    return RequestObjectMoveContainer;
  }

  /**
   * �ړ����f�����擾���܂��B
   * @return �ړ����f��
   */
  protected ACListModelAdapter getRequestObjectMoveModel(){
    if(RequestObjectMoveModel==null){
      RequestObjectMoveModel = new ACListModelAdapter();
      addRequestObjectMoveModel();
    }
    return RequestObjectMoveModel;
  }

  /**
   * �������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getRequestObjectMoveRadioItem1(){
    if(RequestObjectMoveRadioItem1==null){

      RequestObjectMoveRadioItem1 = new ACRadioButtonItem();

      RequestObjectMoveRadioItem1.setText("����");

      RequestObjectMoveRadioItem1.setGroup(getRequestObjectMove());

      addRequestObjectMoveRadioItem1();
    }
    return RequestObjectMoveRadioItem1;

  }

  /**
   * �ꕔ����擾���܂��B
   * @return �ꕔ�
   */
  public ACRadioButtonItem getRequestObjectMoveRadioItem2(){
    if(RequestObjectMoveRadioItem2==null){

      RequestObjectMoveRadioItem2 = new ACRadioButtonItem();

      RequestObjectMoveRadioItem2.setText("�ꕔ�");

      RequestObjectMoveRadioItem2.setGroup(getRequestObjectMove());

      addRequestObjectMoveRadioItem2();
    }
    return RequestObjectMoveRadioItem2;

  }

  /**
   * �S�ʉ���擾���܂��B
   * @return �S�ʉ
   */
  public ACRadioButtonItem getRequestObjectMoveRadioItem3(){
    if(RequestObjectMoveRadioItem3==null){

      RequestObjectMoveRadioItem3 = new ACRadioButtonItem();

      RequestObjectMoveRadioItem3.setText("�S�ʉ");

      RequestObjectMoveRadioItem3.setGroup(getRequestObjectMove());

      addRequestObjectMoveRadioItem3();
    }
    return RequestObjectMoveRadioItem3;

  }

  /**
   * ���̑����擾���܂��B
   * @return ���̑�
   */
  public ACRadioButtonItem getRequestObjectMoveRadioItem4(){
    if(RequestObjectMoveRadioItem4==null){

      RequestObjectMoveRadioItem4 = new ACRadioButtonItem();

      RequestObjectMoveRadioItem4.setText("���̑�");

      RequestObjectMoveRadioItem4.setGroup(getRequestObjectMove());

      addRequestObjectMoveRadioItem4();
    }
    return RequestObjectMoveRadioItem4;

  }

  /**
   * �H�����擾���܂��B
   * @return �H��
   */
  public ACClearableRadioButtonGroup getRequestObjectDinner(){
    if(RequestObjectDinner==null){

      RequestObjectDinner = new ACClearableRadioButtonGroup();

      getRequestObjectDinnerContainer().setText("�H��");

      RequestObjectDinner.setBindPath("ADL_FOOD");

      RequestObjectDinner.setNoSelectIndex(0);

      RequestObjectDinner.setUseClearButton(true);

      RequestObjectDinner.setModel(getRequestObjectDinnerModel());

      addRequestObjectDinner();
    }
    return RequestObjectDinner;

  }

  /**
   * �H���R���e�i���擾���܂��B
   * @return �H���R���e�i
   */
  protected ACLabelContainer getRequestObjectDinnerContainer(){
    if(RequestObjectDinnerContainer==null){
      RequestObjectDinnerContainer = new ACLabelContainer();
      RequestObjectDinnerContainer.setFollowChildEnabled(true);
      RequestObjectDinnerContainer.setVAlignment(VRLayout.CENTER);
      RequestObjectDinnerContainer.add(getRequestObjectDinner(), null);
    }
    return RequestObjectDinnerContainer;
  }

  /**
   * �H�����f�����擾���܂��B
   * @return �H�����f��
   */
  protected ACListModelAdapter getRequestObjectDinnerModel(){
    if(RequestObjectDinnerModel==null){
      RequestObjectDinnerModel = new ACListModelAdapter();
      addRequestObjectDinnerModel();
    }
    return RequestObjectDinnerModel;
  }

  /**
   * �������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getRequestObjectDinnerRadioItem1(){
    if(RequestObjectDinnerRadioItem1==null){

      RequestObjectDinnerRadioItem1 = new ACRadioButtonItem();

      RequestObjectDinnerRadioItem1.setText("����");

      RequestObjectDinnerRadioItem1.setGroup(getRequestObjectDinner());

      addRequestObjectDinnerRadioItem1();
    }
    return RequestObjectDinnerRadioItem1;

  }

  /**
   * �ꕔ����擾���܂��B
   * @return �ꕔ�
   */
  public ACRadioButtonItem getRequestObjectDinnerRadioItem2(){
    if(RequestObjectDinnerRadioItem2==null){

      RequestObjectDinnerRadioItem2 = new ACRadioButtonItem();

      RequestObjectDinnerRadioItem2.setText("�ꕔ�");

      RequestObjectDinnerRadioItem2.setGroup(getRequestObjectDinner());

      addRequestObjectDinnerRadioItem2();
    }
    return RequestObjectDinnerRadioItem2;

  }

  /**
   * �S�ʉ���擾���܂��B
   * @return �S�ʉ
   */
  public ACRadioButtonItem getRequestObjectDinnerRadioItem3(){
    if(RequestObjectDinnerRadioItem3==null){

      RequestObjectDinnerRadioItem3 = new ACRadioButtonItem();

      RequestObjectDinnerRadioItem3.setText("�S�ʉ");

      RequestObjectDinnerRadioItem3.setGroup(getRequestObjectDinner());

      addRequestObjectDinnerRadioItem3();
    }
    return RequestObjectDinnerRadioItem3;

  }

  /**
   * ���̑����擾���܂��B
   * @return ���̑�
   */
  public ACRadioButtonItem getRequestObjectDinnerRadioItem4(){
    if(RequestObjectDinnerRadioItem4==null){

      RequestObjectDinnerRadioItem4 = new ACRadioButtonItem();

      RequestObjectDinnerRadioItem4.setText("���̑�");

      RequestObjectDinnerRadioItem4.setGroup(getRequestObjectDinner());

      addRequestObjectDinnerRadioItem4();
    }
    return RequestObjectDinnerRadioItem4;

  }

  /**
   * �r�����擾���܂��B
   * @return �r��
   */
  public ACClearableRadioButtonGroup getRequestObjectExcrete(){
    if(RequestObjectExcrete==null){

      RequestObjectExcrete = new ACClearableRadioButtonGroup();

      getRequestObjectExcreteContainer().setText("�r��");

      RequestObjectExcrete.setBindPath("ADL_EXCRETION");

      RequestObjectExcrete.setNoSelectIndex(0);

      RequestObjectExcrete.setUseClearButton(true);

      RequestObjectExcrete.setModel(getRequestObjectExcreteModel());

      addRequestObjectExcrete();
    }
    return RequestObjectExcrete;

  }

  /**
   * �r���R���e�i���擾���܂��B
   * @return �r���R���e�i
   */
  protected ACLabelContainer getRequestObjectExcreteContainer(){
    if(RequestObjectExcreteContainer==null){
      RequestObjectExcreteContainer = new ACLabelContainer();
      RequestObjectExcreteContainer.setFollowChildEnabled(true);
      RequestObjectExcreteContainer.setVAlignment(VRLayout.CENTER);
      RequestObjectExcreteContainer.add(getRequestObjectExcrete(), null);
    }
    return RequestObjectExcreteContainer;
  }

  /**
   * �r�����f�����擾���܂��B
   * @return �r�����f��
   */
  protected ACListModelAdapter getRequestObjectExcreteModel(){
    if(RequestObjectExcreteModel==null){
      RequestObjectExcreteModel = new ACListModelAdapter();
      addRequestObjectExcreteModel();
    }
    return RequestObjectExcreteModel;
  }

  /**
   * �������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getRequestObjectExcreteRadioItem1(){
    if(RequestObjectExcreteRadioItem1==null){

      RequestObjectExcreteRadioItem1 = new ACRadioButtonItem();

      RequestObjectExcreteRadioItem1.setText("����");

      RequestObjectExcreteRadioItem1.setGroup(getRequestObjectExcrete());

      addRequestObjectExcreteRadioItem1();
    }
    return RequestObjectExcreteRadioItem1;

  }

  /**
   * �ꕔ����擾���܂��B
   * @return �ꕔ�
   */
  public ACRadioButtonItem getRequestObjectExcreteRadioItem2(){
    if(RequestObjectExcreteRadioItem2==null){

      RequestObjectExcreteRadioItem2 = new ACRadioButtonItem();

      RequestObjectExcreteRadioItem2.setText("�ꕔ�");

      RequestObjectExcreteRadioItem2.setGroup(getRequestObjectExcrete());

      addRequestObjectExcreteRadioItem2();
    }
    return RequestObjectExcreteRadioItem2;

  }

  /**
   * �S�ʉ���擾���܂��B
   * @return �S�ʉ
   */
  public ACRadioButtonItem getRequestObjectExcreteRadioItem3(){
    if(RequestObjectExcreteRadioItem3==null){

      RequestObjectExcreteRadioItem3 = new ACRadioButtonItem();

      RequestObjectExcreteRadioItem3.setText("�S�ʉ");

      RequestObjectExcreteRadioItem3.setGroup(getRequestObjectExcrete());

      addRequestObjectExcreteRadioItem3();
    }
    return RequestObjectExcreteRadioItem3;

  }

  /**
   * ���̑����擾���܂��B
   * @return ���̑�
   */
  public ACRadioButtonItem getRequestObjectExcreteRadioItem4(){
    if(RequestObjectExcreteRadioItem4==null){

      RequestObjectExcreteRadioItem4 = new ACRadioButtonItem();

      RequestObjectExcreteRadioItem4.setText("���̑�");

      RequestObjectExcreteRadioItem4.setGroup(getRequestObjectExcrete());

      addRequestObjectExcreteRadioItem4();
    }
    return RequestObjectExcreteRadioItem4;

  }

  /**
   * �������擾���܂��B
   * @return ����
   */
  public ACClearableRadioButtonGroup getRequestObjectBath(){
    if(RequestObjectBath==null){

      RequestObjectBath = new ACClearableRadioButtonGroup();

      getRequestObjectBathContainer().setText("����");

      RequestObjectBath.setBindPath("ADL_BATH");

      RequestObjectBath.setNoSelectIndex(0);

      RequestObjectBath.setUseClearButton(true);

      RequestObjectBath.setModel(getRequestObjectBathModel());

      addRequestObjectBath();
    }
    return RequestObjectBath;

  }

  /**
   * �����R���e�i���擾���܂��B
   * @return �����R���e�i
   */
  protected ACLabelContainer getRequestObjectBathContainer(){
    if(RequestObjectBathContainer==null){
      RequestObjectBathContainer = new ACLabelContainer();
      RequestObjectBathContainer.setFollowChildEnabled(true);
      RequestObjectBathContainer.setVAlignment(VRLayout.CENTER);
      RequestObjectBathContainer.add(getRequestObjectBath(), null);
    }
    return RequestObjectBathContainer;
  }

  /**
   * �������f�����擾���܂��B
   * @return �������f��
   */
  protected ACListModelAdapter getRequestObjectBathModel(){
    if(RequestObjectBathModel==null){
      RequestObjectBathModel = new ACListModelAdapter();
      addRequestObjectBathModel();
    }
    return RequestObjectBathModel;
  }

  /**
   * �������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getRequestObjectBathRadioItem1(){
    if(RequestObjectBathRadioItem1==null){

      RequestObjectBathRadioItem1 = new ACRadioButtonItem();

      RequestObjectBathRadioItem1.setText("����");

      RequestObjectBathRadioItem1.setGroup(getRequestObjectBath());

      addRequestObjectBathRadioItem1();
    }
    return RequestObjectBathRadioItem1;

  }

  /**
   * �ꕔ����擾���܂��B
   * @return �ꕔ�
   */
  public ACRadioButtonItem getRequestObjectBathRadioItem2(){
    if(RequestObjectBathRadioItem2==null){

      RequestObjectBathRadioItem2 = new ACRadioButtonItem();

      RequestObjectBathRadioItem2.setText("�ꕔ�");

      RequestObjectBathRadioItem2.setGroup(getRequestObjectBath());

      addRequestObjectBathRadioItem2();
    }
    return RequestObjectBathRadioItem2;

  }

  /**
   * �S�ʉ���擾���܂��B
   * @return �S�ʉ
   */
  public ACRadioButtonItem getRequestObjectBathRadioItem3(){
    if(RequestObjectBathRadioItem3==null){

      RequestObjectBathRadioItem3 = new ACRadioButtonItem();

      RequestObjectBathRadioItem3.setText("�S�ʉ");

      RequestObjectBathRadioItem3.setGroup(getRequestObjectBath());

      addRequestObjectBathRadioItem3();
    }
    return RequestObjectBathRadioItem3;

  }

  /**
   * ���̑����擾���܂��B
   * @return ���̑�
   */
  public ACRadioButtonItem getRequestObjectBathRadioItem4(){
    if(RequestObjectBathRadioItem4==null){

      RequestObjectBathRadioItem4 = new ACRadioButtonItem();

      RequestObjectBathRadioItem4.setText("���̑�");

      RequestObjectBathRadioItem4.setGroup(getRequestObjectBath());

      addRequestObjectBathRadioItem4();
    }
    return RequestObjectBathRadioItem4;

  }

  /**
   * ���ւ��擾���܂��B
   * @return ����
   */
  public ACClearableRadioButtonGroup getRequestObjectChangeClothes(){
    if(RequestObjectChangeClothes==null){

      RequestObjectChangeClothes = new ACClearableRadioButtonGroup();

      getRequestObjectChangeClothesContainer().setText("����");

      RequestObjectChangeClothes.setBindPath("ADL_CHANGE_CLOTH");

      RequestObjectChangeClothes.setNoSelectIndex(0);

      RequestObjectChangeClothes.setUseClearButton(true);

      RequestObjectChangeClothes.setModel(getRequestObjectChangeClothesModel());

      addRequestObjectChangeClothes();
    }
    return RequestObjectChangeClothes;

  }

  /**
   * ���փR���e�i���擾���܂��B
   * @return ���փR���e�i
   */
  protected ACLabelContainer getRequestObjectChangeClothesContainer(){
    if(RequestObjectChangeClothesContainer==null){
      RequestObjectChangeClothesContainer = new ACLabelContainer();
      RequestObjectChangeClothesContainer.setFollowChildEnabled(true);
      RequestObjectChangeClothesContainer.setVAlignment(VRLayout.CENTER);
      RequestObjectChangeClothesContainer.add(getRequestObjectChangeClothes(), null);
    }
    return RequestObjectChangeClothesContainer;
  }

  /**
   * ���փ��f�����擾���܂��B
   * @return ���փ��f��
   */
  protected ACListModelAdapter getRequestObjectChangeClothesModel(){
    if(RequestObjectChangeClothesModel==null){
      RequestObjectChangeClothesModel = new ACListModelAdapter();
      addRequestObjectChangeClothesModel();
    }
    return RequestObjectChangeClothesModel;
  }

  /**
   * �������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getRequestObjectChangeClothesRadioItem1(){
    if(RequestObjectChangeClothesRadioItem1==null){

      RequestObjectChangeClothesRadioItem1 = new ACRadioButtonItem();

      RequestObjectChangeClothesRadioItem1.setText("����");

      RequestObjectChangeClothesRadioItem1.setGroup(getRequestObjectChangeClothes());

      addRequestObjectChangeClothesRadioItem1();
    }
    return RequestObjectChangeClothesRadioItem1;

  }

  /**
   * �ꕔ����擾���܂��B
   * @return �ꕔ�
   */
  public ACRadioButtonItem getRequestObjectChangeClothesRadioItem2(){
    if(RequestObjectChangeClothesRadioItem2==null){

      RequestObjectChangeClothesRadioItem2 = new ACRadioButtonItem();

      RequestObjectChangeClothesRadioItem2.setText("�ꕔ�");

      RequestObjectChangeClothesRadioItem2.setGroup(getRequestObjectChangeClothes());

      addRequestObjectChangeClothesRadioItem2();
    }
    return RequestObjectChangeClothesRadioItem2;

  }

  /**
   * �S�ʉ���擾���܂��B
   * @return �S�ʉ
   */
  public ACRadioButtonItem getRequestObjectChangeClothesRadioItem3(){
    if(RequestObjectChangeClothesRadioItem3==null){

      RequestObjectChangeClothesRadioItem3 = new ACRadioButtonItem();

      RequestObjectChangeClothesRadioItem3.setText("�S�ʉ");

      RequestObjectChangeClothesRadioItem3.setGroup(getRequestObjectChangeClothes());

      addRequestObjectChangeClothesRadioItem3();
    }
    return RequestObjectChangeClothesRadioItem3;

  }

  /**
   * ���̑����擾���܂��B
   * @return ���̑�
   */
  public ACRadioButtonItem getRequestObjectChangeClothesRadioItem4(){
    if(RequestObjectChangeClothesRadioItem4==null){

      RequestObjectChangeClothesRadioItem4 = new ACRadioButtonItem();

      RequestObjectChangeClothesRadioItem4.setText("���̑�");

      RequestObjectChangeClothesRadioItem4.setGroup(getRequestObjectChangeClothes());

      addRequestObjectChangeClothesRadioItem4();
    }
    return RequestObjectChangeClothesRadioItem4;

  }

  /**
   * ���e���擾���܂��B
   * @return ���e
   */
  public ACClearableRadioButtonGroup getRequestObjectSeiyo(){
    if(RequestObjectSeiyo==null){

      RequestObjectSeiyo = new ACClearableRadioButtonGroup();

      getRequestObjectSeiyoContainer().setText("���e");

      RequestObjectSeiyo.setBindPath("ADL_COSMETIC");

      RequestObjectSeiyo.setNoSelectIndex(0);

      RequestObjectSeiyo.setUseClearButton(true);

      RequestObjectSeiyo.setModel(getRequestObjectSeiyoModel());

      addRequestObjectSeiyo();
    }
    return RequestObjectSeiyo;

  }

  /**
   * ���e�R���e�i���擾���܂��B
   * @return ���e�R���e�i
   */
  protected ACLabelContainer getRequestObjectSeiyoContainer(){
    if(RequestObjectSeiyoContainer==null){
      RequestObjectSeiyoContainer = new ACLabelContainer();
      RequestObjectSeiyoContainer.setFollowChildEnabled(true);
      RequestObjectSeiyoContainer.setVAlignment(VRLayout.CENTER);
      RequestObjectSeiyoContainer.add(getRequestObjectSeiyo(), null);
    }
    return RequestObjectSeiyoContainer;
  }

  /**
   * ���e���f�����擾���܂��B
   * @return ���e���f��
   */
  protected ACListModelAdapter getRequestObjectSeiyoModel(){
    if(RequestObjectSeiyoModel==null){
      RequestObjectSeiyoModel = new ACListModelAdapter();
      addRequestObjectSeiyoModel();
    }
    return RequestObjectSeiyoModel;
  }

  /**
   * �������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getRequestObjectSeiyoRadioItem1(){
    if(RequestObjectSeiyoRadioItem1==null){

      RequestObjectSeiyoRadioItem1 = new ACRadioButtonItem();

      RequestObjectSeiyoRadioItem1.setText("����");

      RequestObjectSeiyoRadioItem1.setGroup(getRequestObjectSeiyo());

      addRequestObjectSeiyoRadioItem1();
    }
    return RequestObjectSeiyoRadioItem1;

  }

  /**
   * �ꕔ����擾���܂��B
   * @return �ꕔ�
   */
  public ACRadioButtonItem getRequestObjectSeiyoRadioItem2(){
    if(RequestObjectSeiyoRadioItem2==null){

      RequestObjectSeiyoRadioItem2 = new ACRadioButtonItem();

      RequestObjectSeiyoRadioItem2.setText("�ꕔ�");

      RequestObjectSeiyoRadioItem2.setGroup(getRequestObjectSeiyo());

      addRequestObjectSeiyoRadioItem2();
    }
    return RequestObjectSeiyoRadioItem2;

  }

  /**
   * �S�ʉ���擾���܂��B
   * @return �S�ʉ
   */
  public ACRadioButtonItem getRequestObjectSeiyoRadioItem3(){
    if(RequestObjectSeiyoRadioItem3==null){

      RequestObjectSeiyoRadioItem3 = new ACRadioButtonItem();

      RequestObjectSeiyoRadioItem3.setText("�S�ʉ");

      RequestObjectSeiyoRadioItem3.setGroup(getRequestObjectSeiyo());

      addRequestObjectSeiyoRadioItem3();
    }
    return RequestObjectSeiyoRadioItem3;

  }

  /**
   * ���̑����擾���܂��B
   * @return ���̑�
   */
  public ACRadioButtonItem getRequestObjectSeiyoRadioItem4(){
    if(RequestObjectSeiyoRadioItem4==null){

      RequestObjectSeiyoRadioItem4 = new ACRadioButtonItem();

      RequestObjectSeiyoRadioItem4.setText("���̑�");

      RequestObjectSeiyoRadioItem4.setGroup(getRequestObjectSeiyo());

      addRequestObjectSeiyoRadioItem4();
    }
    return RequestObjectSeiyoRadioItem4;

  }

  /**
   * �ӎv�a�ʂ��擾���܂��B
   * @return �ӎv�a��
   */
  public ACClearableRadioButtonGroup getRequestObjectIsisotu(){
    if(RequestObjectIsisotu==null){

      RequestObjectIsisotu = new ACClearableRadioButtonGroup();

      getRequestObjectIsisotuContainer().setText("�ӎv�a��");

      RequestObjectIsisotu.setBindPath("ADL_COMMUNICATION");

      RequestObjectIsisotu.setNoSelectIndex(0);

      RequestObjectIsisotu.setUseClearButton(true);

      RequestObjectIsisotu.setModel(getRequestObjectIsisotuModel());

      addRequestObjectIsisotu();
    }
    return RequestObjectIsisotu;

  }

  /**
   * �ӎv�a�ʃR���e�i���擾���܂��B
   * @return �ӎv�a�ʃR���e�i
   */
  protected ACLabelContainer getRequestObjectIsisotuContainer(){
    if(RequestObjectIsisotuContainer==null){
      RequestObjectIsisotuContainer = new ACLabelContainer();
      RequestObjectIsisotuContainer.setFollowChildEnabled(true);
      RequestObjectIsisotuContainer.setVAlignment(VRLayout.CENTER);
      RequestObjectIsisotuContainer.add(getRequestObjectIsisotu(), null);
    }
    return RequestObjectIsisotuContainer;
  }

  /**
   * �ӎv�a�ʃ��f�����擾���܂��B
   * @return �ӎv�a�ʃ��f��
   */
  protected ACListModelAdapter getRequestObjectIsisotuModel(){
    if(RequestObjectIsisotuModel==null){
      RequestObjectIsisotuModel = new ACListModelAdapter();
      addRequestObjectIsisotuModel();
    }
    return RequestObjectIsisotuModel;
  }

  /**
   * �������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getRequestObjectIsisotuRadioItem1(){
    if(RequestObjectIsisotuRadioItem1==null){

      RequestObjectIsisotuRadioItem1 = new ACRadioButtonItem();

      RequestObjectIsisotuRadioItem1.setText("����");

      RequestObjectIsisotuRadioItem1.setGroup(getRequestObjectIsisotu());

      addRequestObjectIsisotuRadioItem1();
    }
    return RequestObjectIsisotuRadioItem1;

  }

  /**
   * �ꕔ����擾���܂��B
   * @return �ꕔ�
   */
  public ACRadioButtonItem getRequestObjectIsisotuRadioItem2(){
    if(RequestObjectIsisotuRadioItem2==null){

      RequestObjectIsisotuRadioItem2 = new ACRadioButtonItem();

      RequestObjectIsisotuRadioItem2.setText("�ꕔ�");

      RequestObjectIsisotuRadioItem2.setGroup(getRequestObjectIsisotu());

      addRequestObjectIsisotuRadioItem2();
    }
    return RequestObjectIsisotuRadioItem2;

  }

  /**
   * �S�ʉ���擾���܂��B
   * @return �S�ʉ
   */
  public ACRadioButtonItem getRequestObjectIsisotuRadioItem3(){
    if(RequestObjectIsisotuRadioItem3==null){

      RequestObjectIsisotuRadioItem3 = new ACRadioButtonItem();

      RequestObjectIsisotuRadioItem3.setText("�S�ʉ");

      RequestObjectIsisotuRadioItem3.setGroup(getRequestObjectIsisotu());

      addRequestObjectIsisotuRadioItem3();
    }
    return RequestObjectIsisotuRadioItem3;

  }

  /**
   * ���̑����擾���܂��B
   * @return ���̑�
   */
  public ACRadioButtonItem getRequestObjectIsisotuRadioItem4(){
    if(RequestObjectIsisotuRadioItem4==null){

      RequestObjectIsisotuRadioItem4 = new ACRadioButtonItem();

      RequestObjectIsisotuRadioItem4.setText("���̑�");

      RequestObjectIsisotuRadioItem4.setGroup(getRequestObjectIsisotu());

      addRequestObjectIsisotuRadioItem4();
    }
    return RequestObjectIsisotuRadioItem4;

  }

  /**
   * �ً}���̘A�����@�̈�E�O���[�v���擾���܂��B
   * @return �ً}���̘A�����@�̈�E�O���[�v
   */
  public ACGroupBox getEmergencyContacts(){
    if(emergencyContacts==null){

      emergencyContacts = new ACGroupBox();

      emergencyContacts.setText("�ً}���̘A�����@(46x8)");

      emergencyContacts.setAutoWrap(false);

      emergencyContacts.setHgap(0);

      emergencyContacts.setLabelMargin(0);

      addEmergencyContacts();
    }
    return emergencyContacts;

  }

  /**
   * �ً}���̘A�����@�̈���擾���܂��B
   * @return �ً}���̘A�����@�̈�
   */
  public ACTextArea getEmergencyContact(){
    if(emergencyContact==null){

      emergencyContact = new ACTextArea();

      emergencyContact.setBindPath("DOCTOR_RENRAKUSAKI");

      emergencyContact.setColumns(92);

      emergencyContact.setRows(9);

      emergencyContact.setMaxRows(8);

      emergencyContact.setIMEMode(InputSubset.KANJI);

      emergencyContact.setMaxLength(368);

      emergencyContact.setLineWrap(true);

      addEmergencyContact();
    }
    return emergencyContact;

  }

  /**
   * �ً}���̘A�����@�̈�R���e�i���擾���܂��B
   * @return �ً}���̘A�����@�̈�R���e�i
   */
  protected ACLabelContainer getEmergencyContactContainer(){
    if(emergencyContactContainer==null){
      emergencyContactContainer = new ACLabelContainer();
      emergencyContactContainer.setFollowChildEnabled(true);
      emergencyContactContainer.setVAlignment(VRLayout.CENTER);
      emergencyContactContainer.add(getEmergencyContact(), null);
    }
    return emergencyContactContainer;
  }

  /**
   * �֌W�@�ցE���p�󋵗̈���擾���܂��B
   * @return �֌W�@�ցE���p�󋵗̈�
   */
  public ACPanel getPoints7(){
    if(points7==null){

      points7 = new ACPanel();

      addPoints7();
    }
    return points7;

  }

  /**
   * �֌W�@�֗̈�E�O���[�v���擾���܂��B
   * @return �֌W�@�֗̈�E�O���[�v
   */
  public ACGroupBox getKankeikikans(){
    if(kankeikikans==null){

      kankeikikans = new ACGroupBox();

      kankeikikans.setText("�֌W�@��");

      kankeikikans.setLayout(getKankeikikanLayout());

      addKankeikikans();
    }
    return kankeikikans;

  }

  /**
   * �֌W�@�֗̈�E���C�A�E�g���擾���܂��B
   * @return �֌W�@�֗̈�E���C�A�E�g
   */
  public GridBagLayout getKankeikikanLayout(){
    if(kankeikikanLayout==null){

      kankeikikanLayout = new GridBagLayout();

      addKankeikikanLayout();
    }
    return kankeikikanLayout;

  }

  /**
   * �A����(�w�b�_���擾���܂��B
   * @return �A����(�w�b�_
   */
  public ACLabel getContactAddressHeader(){
    if(contactAddressHeader==null){

      contactAddressHeader = new ACLabel();

      contactAddressHeader.setText("�A����");

      addContactAddressHeader();
    }
    return contactAddressHeader;

  }

  /**
   * �S����(�w�b�_���擾���܂��B
   * @return �S����(�w�b�_
   */
  public ACLabel getChargeHeader(){
    if(chargeHeader==null){

      chargeHeader = new ACLabel();

      chargeHeader.setText("�S����");

      addChargeHeader();
    }
    return chargeHeader;

  }

  /**
   * ���l(�w�b�_���擾���܂��B
   * @return ���l(�w�b�_
   */
  public ACLabel getRemarkHeader(){
    if(remarkHeader==null){

      remarkHeader = new ACLabel();

      remarkHeader.setText("���l");

      addRemarkHeader();
    }
    return remarkHeader;

  }

  /**
   * �A����1���擾���܂��B
   * @return �A����1
   */
  public ACTextField getContact1(){
    if(contact1==null){

      contact1 = new ACTextField();

      contact1.setBindPath("MEDICAL_RENRAKUSAKI1");

      contact1.setColumns(15);

      contact1.setIMEMode(InputSubset.KANJI);

      contact1.setMaxLength(20);

      addContact1();
    }
    return contact1;

  }

  /**
   * �S����1���擾���܂��B
   * @return �S����1
   */
  public ACTextField getCharge1(){
    if(charge1==null){

      charge1 = new ACTextField();

      charge1.setBindPath("MEDICAL_PREPARED1");

      charge1.setColumns(12);

      charge1.setIMEMode(InputSubset.KANJI);

      charge1.setMaxLength(12);

      addCharge1();
    }
    return charge1;

  }

  /**
   * ���l1���擾���܂��B
   * @return ���l1
   */
  public ACTextField getRemark1(){
    if(remark1==null){

      remark1 = new ACTextField();

      remark1.setBindPath("MEDICAL_NOTE1");

      remark1.setColumns(38);

      remark1.setIMEMode(InputSubset.KANJI);

      remark1.setMaxLength(38);

      addRemark1();
    }
    return remark1;

  }

  /**
   * �A����2���擾���܂��B
   * @return �A����2
   */
  public ACTextField getContact2(){
    if(contact2==null){

      contact2 = new ACTextField();

      contact2.setBindPath("MEDICAL_RENRAKUSAKI2");

      contact2.setColumns(15);

      contact2.setIMEMode(InputSubset.KANJI);

      contact2.setMaxLength(20);

      addContact2();
    }
    return contact2;

  }

  /**
   * �S����2���擾���܂��B
   * @return �S����2
   */
  public ACTextField getCharge2(){
    if(charge2==null){

      charge2 = new ACTextField();

      charge2.setBindPath("MEDICAL_PREPARED2");

      charge2.setColumns(12);

      charge2.setIMEMode(InputSubset.KANJI);

      charge2.setMaxLength(12);

      addCharge2();
    }
    return charge2;

  }

  /**
   * ���l2���擾���܂��B
   * @return ���l2
   */
  public ACTextField getRemark2(){
    if(remark2==null){

      remark2 = new ACTextField();

      remark2.setBindPath("MEDICAL_NOTE2");

      remark2.setColumns(38);

      remark2.setIMEMode(InputSubset.KANJI);

      remark2.setMaxLength(38);

      addRemark2();
    }
    return remark2;

  }

  /**
   * �A����3���擾���܂��B
   * @return �A����3
   */
  public ACTextField getContact3(){
    if(contact3==null){

      contact3 = new ACTextField();

      contact3.setBindPath("MEDICAL_RENRAKUSAKI3");

      contact3.setColumns(15);

      contact3.setIMEMode(InputSubset.KANJI);

      contact3.setMaxLength(20);

      addContact3();
    }
    return contact3;

  }

  /**
   * �S����3���擾���܂��B
   * @return �S����3
   */
  public ACTextField getCharge3(){
    if(charge3==null){

      charge3 = new ACTextField();

      charge3.setBindPath("MEDICAL_PREPARED3");

      charge3.setColumns(12);

      charge3.setIMEMode(InputSubset.KANJI);

      charge3.setMaxLength(12);

      addCharge3();
    }
    return charge3;

  }

  /**
   * ���l3���擾���܂��B
   * @return ���l3
   */
  public ACTextField getRemark3(){
    if(remark3==null){

      remark3 = new ACTextField();

      remark3.setBindPath("MEDICAL_NOTE3");

      remark3.setColumns(38);

      remark3.setIMEMode(InputSubset.KANJI);

      remark3.setMaxLength(38);

      addRemark3();
    }
    return remark3;

  }

  /**
   * �A����4���擾���܂��B
   * @return �A����4
   */
  public ACTextField getContact4(){
    if(contact4==null){

      contact4 = new ACTextField();

      contact4.setBindPath("MEDICAL_RENRAKUSAKI4");

      contact4.setColumns(15);

      contact4.setIMEMode(InputSubset.KANJI);

      contact4.setMaxLength(20);

      addContact4();
    }
    return contact4;

  }

  /**
   * �S����4���擾���܂��B
   * @return �S����4
   */
  public ACTextField getCharge4(){
    if(charge4==null){

      charge4 = new ACTextField();

      charge4.setBindPath("MEDICAL_PREPARED4");

      charge4.setColumns(12);

      charge4.setIMEMode(InputSubset.KANJI);

      charge4.setMaxLength(12);

      addCharge4();
    }
    return charge4;

  }

  /**
   * ���l4���擾���܂��B
   * @return ���l4
   */
  public ACTextField getRemark4(){
    if(remark4==null){

      remark4 = new ACTextField();

      remark4.setBindPath("MEDICAL_NOTE4");

      remark4.setColumns(38);

      remark4.setIMEMode(InputSubset.KANJI);

      remark4.setMaxLength(38);

      addRemark4();
    }
    return remark4;

  }

  /**
   * �ی��E�����T�[�r�X���̗��p�󋵁E�O���[�v���擾���܂��B
   * @return �ی��E�����T�[�r�X���̗��p�󋵁E�O���[�v
   */
  public ACGroupBox getHokenfukusis(){
    if(hokenfukusis==null){

      hokenfukusis = new ACGroupBox();

      hokenfukusis.setText("�ی��E�����T�[�r�X���̗��p��(46x6)");

      hokenfukusis.setAutoWrap(false);

      hokenfukusis.setHgap(0);

      hokenfukusis.setLabelMargin(0);

      addHokenfukusis();
    }
    return hokenfukusis;

  }

  /**
   * �ی�������T�[�r�X���̗��p�󋵂��擾���܂��B
   * @return �ی�������T�[�r�X���̗��p��
   */
  public ACTextArea getHokenfukusi(){
    if(hokenfukusi==null){

      hokenfukusi = new ACTextArea();

      hokenfukusi.setBindPath("USED_STATE");

      hokenfukusi.setColumns(92);

      hokenfukusi.setRows(7);

      hokenfukusi.setMaxRows(6);

      hokenfukusi.setIMEMode(InputSubset.KANJI);

      hokenfukusi.setMaxLength(276);

      hokenfukusi.setLineWrap(true);

      addHokenfukusi();
    }
    return hokenfukusi;

  }

  /**
   * �ی�������T�[�r�X���̗��p�󋵃R���e�i���擾���܂��B
   * @return �ی�������T�[�r�X���̗��p�󋵃R���e�i
   */
  protected ACLabelContainer getHokenfukusiContainer(){
    if(hokenfukusiContainer==null){
      hokenfukusiContainer = new ACLabelContainer();
      hokenfukusiContainer.setFollowChildEnabled(true);
      hokenfukusiContainer.setVAlignment(VRLayout.CENTER);
      hokenfukusiContainer.add(getHokenfukusi(), null);
    }
    return hokenfukusiContainer;
  }

  /**
   * �R���X�g���N�^�ł��B
   */
  public QC004Design() {

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
   * �ۑ��ɓ������ڂ�ǉ����܂��B
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

    contents.add(getPatients(), VRLayout.NORTH);

    contents.add(getNurses(), VRLayout.NORTH);

    contents.add(getTabs(), VRLayout.CLIENT);

  }

  /**
   * ���җ̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatients(){

    patients.add(getPatient(), VRLayout.CLIENT);

  }

  /**
   * ���җ̈�E�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatient(){

    patient.add(getPatientNameContainer(), VRLayout.FLOW_INSETLINE);

    patient.add(getPatientSexContainer(), VRLayout.FLOW);

    patient.add(getPatientBirths(), VRLayout.FLOW_INSETLINE_RETURN);

    patient.add(getPatientAddressContainer(), VRLayout.FLOW_INSETLINE);

    patient.add(getPatientTels(), VRLayout.FLOW);

  }

  /**
   * ���Ҏ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatientName(){

  }

  /**
   * ���Ґ��ʂɓ������ڂ�ǉ����܂��B
   */
  protected void addPatientSex(){

  }

  /**
   * ���Ґ��N�����E�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatientBirths(){

    patientBirths.add(getPatientBirth(), VRLayout.FLOW);

    patientBirths.add(getPatientAge(), VRLayout.FLOW);

    patientBirths.add(getPatientAgeLabel(), VRLayout.FLOW);

  }

  /**
   * ���Ґ��N�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatientBirth(){

  }

  /**
   * ���ҔN��ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatientAge(){

  }

  /**
   * �΃��x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatientAgeLabel(){

  }

  /**
   * ���ҏZ���ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatientAddress(){

  }

  /**
   * ���ғd�b�ԍ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatientTels(){

    patientTels.add(getPatientTel1(), VRLayout.FLOW);

    patientTels.add(getPatientLabel1(), VRLayout.FLOW);

    patientTels.add(getPatientTel2(), VRLayout.FLOW);

    patientTels.add(getPatientLabel2(), VRLayout.FLOW);

    patientTels.add(getPatientTel3(), VRLayout.FLOW);

  }

  /**
   * ���ғd�b�ԍ�1�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatientTel1(){

  }

  /**
   * ���ғd�b�ԍ����x��1�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatientLabel1(){

  }

  /**
   * ���ғd�b�ԍ�2�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatientTel2(){

  }

  /**
   * ���ғd�b�ԍ����x��1�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatientLabel2(){

  }

  /**
   * ���ғd�b�ԍ�3�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatientTel3(){

  }

  /**
   * �Ō�t�̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addNurses(){

    nurses.add(getNurse(), VRLayout.CLIENT);

  }

  /**
   * �Ō�t�̈�E�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addNurse(){

    nurse.add(getNurseNameContainer(), VRLayout.FLOW_RETURN);

    nurse.add(getFirstVisitDates(), VRLayout.FLOW);

  }

  /**
   * �Ō�t�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addNurseName(){

  }

  /**
   * �Ō�t����K��N�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addFirstVisitDates(){

    firstVisitDates.add(getFirstVisitDateStart(), VRLayout.FLOW);

    firstVisitDates.add(getFirstVisitDateTimeLabel(), VRLayout.FLOW);

    firstVisitDates.add(getFirstVisitDateStartHour(), VRLayout.FLOW);

    firstVisitDates.add(getFirstVisitDateLabel(), VRLayout.FLOW);

    firstVisitDates.add(getFirstVisitDateEndHour(), VRLayout.FLOW);

  }

  /**
   * �Ō�t����K��N����(�J�n���ԁj�ɓ������ڂ�ǉ����܂��B
   */
  protected void addFirstVisitDateStart(){

  }

  /**
   * �Ō�t����K��N�����E�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addFirstVisitDateTimeLabel(){

  }

  /**
   * �Ō�t����K��N����(���ɓ������ڂ�ǉ����܂��B
   */
  protected void addFirstVisitDateStartHour(){

  }

  /**
   * �Ō�t����K��N�����E���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addFirstVisitDateLabel(){

  }

  /**
   * �Ō�t����K��N����(�I�����ԁj�ɓ������ڂ�ǉ����܂��B
   */
  protected void addFirstVisitDateEndHour(){

  }

  /**
   * �^�u�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTabs(){

    tabs.addTab("NO.1 ���a���E�a��", getPoints1());

    tabs.addTab("NO.1 ���a���E������", getPoints2());

    tabs.addTab("NO.1 ������", getPoints3());

    tabs.addTab("NO.1 ��ȉ��ҁE�Z��", getPoints4());

    tabs.addTab("NO.2 �˗��ړI", getPoints5());

    tabs.addTab("NO.2 ADL", getPoints6());

    tabs.addTab("�֌W�@�ցE���p��", getPoints7());

  }

  /**
   * NO.1 ���a���E�a��E��̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPoints1(){

    points1.add(getMainDiseases(), VRLayout.FLOW_RETURN);

    points1.add(getDiseaseConditionAndTreatments(), VRLayout.FLOW_RETURN);

  }

  /**
   * �傽�鏝�a���E�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMainDiseases(){

    mainDiseases.add(getMainDiseaseContainer(), VRLayout.FLOW);

  }

  /**
   * ��ȏ��a���ɓ������ڂ�ǉ����܂��B
   */
  protected void addMainDisease(){

  }

  /**
   * �a��E���Ï�ԓ��E�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addDiseaseConditionAndTreatments(){

    diseaseConditionAndTreatments.add(getDiseaseConditionAndTreatmentContainer(), VRLayout.FLOW);

  }

  /**
   * �a�󥎡�Ï�ԓ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addDiseaseConditionAndTreatment(){

  }

  /**
   * NO.1 ���a���E�������E�������ɓ������ڂ�ǉ����܂��B
   */
  protected void addPoints2(){

    points2.add(getGenbyorekis(), VRLayout.FLOW_RETURN);

    points2.add(getExistingAddressHistorys(), VRLayout.FLOW);

  }

  /**
   * ���a���E�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addGenbyorekis(){

    genbyorekis.add(getGenbyorekiContainer(), VRLayout.FLOW);

  }

  /**
   * ���a���ɓ������ڂ�ǉ����܂��B
   */
  protected void addGenbyoreki(){

  }

  /**
   * �������E�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addExistingAddressHistorys(){

    existingAddressHistorys.add(getExistingAddressHistoryContainer(), VRLayout.FLOW);

  }

  /**
   * �������ɓ������ڂ�ǉ����܂��B
   */
  protected void addExistingAddressHistory(){

  }

  /**
   * NO.1 �������ɓ������ڂ�ǉ����܂��B
   */
  protected void addPoints3(){

    points3.add(getLifeHistorys(), VRLayout.FLOW);

    points3.add(getFamilyStructureas(), VRLayout.FLOW_RETURN);

  }

  /**
   * �������E�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addLifeHistorys(){

    lifeHistorys.add(getLifeHistoryContainer(), VRLayout.FLOW);

  }

  /**
   * �������ɓ������ڂ�ǉ����܂��B
   */
  protected void addLifeHistory(){

  }

  /**
   * �Ƒ��\���E�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addFamilyStructureas(){

    familyStructureas.add(getFamilyStructreNameHeader(), new GridBagConstraints(0, 0, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

    familyStructureas.add(getFamilyStructreAgeHeader(), new GridBagConstraints(1, 0, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

    familyStructureas.add(getFamilyStructreRelationHeader(), new GridBagConstraints(2, 0, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

    familyStructureas.add(getFamilyStructreJobHeader(), new GridBagConstraints(3, 0, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

    familyStructureas.add(getFamilyStructreCommentHeader(), new GridBagConstraints(4, 0, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

    familyStructureas.add(getFamilyStructreName1(), new GridBagConstraints(0, 1, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

    familyStructureas.add(getFamilyStructreAge1(), new GridBagConstraints(1, 1, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

    familyStructureas.add(getFamilyStructreRelation1(), new GridBagConstraints(2, 1, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

    familyStructureas.add(getFamilyStructreJob1(), new GridBagConstraints(3, 1, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

    familyStructureas.add(getFamilyStructreComment1(), new GridBagConstraints(4, 1, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

    familyStructureas.add(getFamilyStructreName2(), new GridBagConstraints(0, 2, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

    familyStructureas.add(getFamilyStructreAge2(), new GridBagConstraints(1, 2, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

    familyStructureas.add(getFamilyStructreRelation2(), new GridBagConstraints(2, 2, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

    familyStructureas.add(getFamilyStructreJob2(), new GridBagConstraints(3, 2, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

    familyStructureas.add(getFamilyStructreComment2(), new GridBagConstraints(4, 2, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

    familyStructureas.add(getFamilyStructreName3(), new GridBagConstraints(0, 3, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

    familyStructureas.add(getFamilyStructreAge3(), new GridBagConstraints(1, 3, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

    familyStructureas.add(getFamilyStructreRelation3(), new GridBagConstraints(2, 3, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

    familyStructureas.add(getFamilyStructreJob3(), new GridBagConstraints(3, 3, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

    familyStructureas.add(getFamilyStructreComment3(), new GridBagConstraints(4, 3, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

    familyStructureas.add(getFamilyStructreName4(), new GridBagConstraints(0, 4, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

    familyStructureas.add(getFamilyStructreAge4(), new GridBagConstraints(1, 4, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

    familyStructureas.add(getFamilyStructreRelation4(), new GridBagConstraints(2, 4, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

    familyStructureas.add(getFamilyStructreJob4(), new GridBagConstraints(3, 4, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

    familyStructureas.add(getFamilyStructreComment4(), new GridBagConstraints(4, 4, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

    familyStructureas.add(getFamilyStructreName5(), new GridBagConstraints(0, 5, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

    familyStructureas.add(getFamilyStructreAge5(), new GridBagConstraints(1, 5, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

    familyStructureas.add(getFamilyStructreRelation5(), new GridBagConstraints(2, 5, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

    familyStructureas.add(getFamilyStructreJob5(), new GridBagConstraints(3, 5, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

    familyStructureas.add(getFamilyStructreComment5(), new GridBagConstraints(4, 5, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

    familyStructureas.add(getFamilyStructreName6(), new GridBagConstraints(0, 6, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

    familyStructureas.add(getFamilyStructreAge6(), new GridBagConstraints(1, 6, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

    familyStructureas.add(getFamilyStructreRelation6(), new GridBagConstraints(2, 6, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

    familyStructureas.add(getFamilyStructreJob6(), new GridBagConstraints(3, 6, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

    familyStructureas.add(getFamilyStructreComment6(), new GridBagConstraints(4, 6, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

  }

  /**
   * �Ƒ��\���E���C�A�E�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addFamilyStructre(){

  }

  /**
   * ����(�w�b�_�ɓ������ڂ�ǉ����܂��B
   */
  protected void addFamilyStructreNameHeader(){

  }

  /**
   * �N��(�w�b�_�ɓ������ڂ�ǉ����܂��B
   */
  protected void addFamilyStructreAgeHeader(){

  }

  /**
   * ����(�w�b�_�ɓ������ڂ�ǉ����܂��B
   */
  protected void addFamilyStructreRelationHeader(){

  }

  /**
   * �E��(�w�b�_�ɓ������ڂ�ǉ����܂��B
   */
  protected void addFamilyStructreJobHeader(){

  }

  /**
   * ���L���ׂ�����(�w�b�_�ɓ������ڂ�ǉ����܂��B
   */
  protected void addFamilyStructreCommentHeader(){

  }

  /**
   * ����1�ɓ������ڂ�ǉ����܂��B
   */
  protected void addFamilyStructreName1(){

  }

  /**
   * �N��1�ɓ������ڂ�ǉ����܂��B
   */
  protected void addFamilyStructreAge1(){

  }

  /**
   * ����1�ɓ������ڂ�ǉ����܂��B
   */
  protected void addFamilyStructreRelation1(){

  }

  /**
   * �E��1�ɓ������ڂ�ǉ����܂��B
   */
  protected void addFamilyStructreJob1(){

  }

  /**
   * ���L���ׂ�����1�ɓ������ڂ�ǉ����܂��B
   */
  protected void addFamilyStructreComment1(){

  }

  /**
   * ����2�ɓ������ڂ�ǉ����܂��B
   */
  protected void addFamilyStructreName2(){

  }

  /**
   * �N��2�ɓ������ڂ�ǉ����܂��B
   */
  protected void addFamilyStructreAge2(){

  }

  /**
   * ����2�ɓ������ڂ�ǉ����܂��B
   */
  protected void addFamilyStructreRelation2(){

  }

  /**
   * �E��2�ɓ������ڂ�ǉ����܂��B
   */
  protected void addFamilyStructreJob2(){

  }

  /**
   * ���L���ׂ�����2�ɓ������ڂ�ǉ����܂��B
   */
  protected void addFamilyStructreComment2(){

  }

  /**
   * ����3�ɓ������ڂ�ǉ����܂��B
   */
  protected void addFamilyStructreName3(){

  }

  /**
   * �N��3�ɓ������ڂ�ǉ����܂��B
   */
  protected void addFamilyStructreAge3(){

  }

  /**
   * ����3�ɓ������ڂ�ǉ����܂��B
   */
  protected void addFamilyStructreRelation3(){

  }

  /**
   * �E��3�ɓ������ڂ�ǉ����܂��B
   */
  protected void addFamilyStructreJob3(){

  }

  /**
   * ���L���ׂ�����3�ɓ������ڂ�ǉ����܂��B
   */
  protected void addFamilyStructreComment3(){

  }

  /**
   * ����4�ɓ������ڂ�ǉ����܂��B
   */
  protected void addFamilyStructreName4(){

  }

  /**
   * �N��4�ɓ������ڂ�ǉ����܂��B
   */
  protected void addFamilyStructreAge4(){

  }

  /**
   * ����4�ɓ������ڂ�ǉ����܂��B
   */
  protected void addFamilyStructreRelation4(){

  }

  /**
   * �E��4�ɓ������ڂ�ǉ����܂��B
   */
  protected void addFamilyStructreJob4(){

  }

  /**
   * ���L���ׂ�����4�ɓ������ڂ�ǉ����܂��B
   */
  protected void addFamilyStructreComment4(){

  }

  /**
   * ����5�ɓ������ڂ�ǉ����܂��B
   */
  protected void addFamilyStructreName5(){

  }

  /**
   * �N��5�ɓ������ڂ�ǉ����܂��B
   */
  protected void addFamilyStructreAge5(){

  }

  /**
   * ����5�ɓ������ڂ�ǉ����܂��B
   */
  protected void addFamilyStructreRelation5(){

  }

  /**
   * �E��5�ɓ������ڂ�ǉ����܂��B
   */
  protected void addFamilyStructreJob5(){

  }

  /**
   * ���L���ׂ�����5�ɓ������ڂ�ǉ����܂��B
   */
  protected void addFamilyStructreComment5(){

  }

  /**
   * ����6�ɓ������ڂ�ǉ����܂��B
   */
  protected void addFamilyStructreName6(){

  }

  /**
   * �N��6�ɓ������ڂ�ǉ����܂��B
   */
  protected void addFamilyStructreAge6(){

  }

  /**
   * ����6�ɓ������ڂ�ǉ����܂��B
   */
  protected void addFamilyStructreRelation6(){

  }

  /**
   * �E��6�ɓ������ڂ�ǉ����܂��B
   */
  protected void addFamilyStructreJob6(){

  }

  /**
   * ���L���ׂ�����6�ɓ������ڂ�ǉ����܂��B
   */
  protected void addFamilyStructreComment6(){

  }

  /**
   * NO.1 ��ȉ��ҁE�Z���ɓ������ڂ�ǉ����܂��B
   */
  protected void addPoints4(){

    points4.add(getMainCaares(), VRLayout.FLOW_RETURN);

    points4.add(getJyukankyos(), VRLayout.FLOW);

  }

  /**
   * ��ȉ��ҁE�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMainCaares(){

    mainCaares.add(getMainCareContainer(), VRLayout.FLOW);

  }

  /**
   * ��ȉ��҂ɓ������ڂ�ǉ����܂��B
   */
  protected void addMainCare(){

  }

  /**
   * �Z���E�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addJyukankyos(){

    jyukankyos.add(getJyukankyoContainer(), VRLayout.FLOW);

  }

  /**
   * �Z���ɓ������ڂ�ǉ����܂��B
   */
  protected void addJyukankyo(){

  }

  /**
   * NO.2 �˗��ړI�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPoints5(){

    points5.add(getPatientAndFamilyRequests(), VRLayout.FLOW_RETURN);

    points5.add(getSyujis(), VRLayout.FLOW);

  }

  /**
   * ���p�ҁE�Ƒ��̈˗��ړI�̈�E�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatientAndFamilyRequests(){

    patientAndFamilyRequests.add(getPatientAndFamilyRequestContainer(), VRLayout.FLOW);

  }

  /**
   * ���p�ҁE�Ƒ��̈˗��ړI�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatientAndFamilyRequest(){

  }

  /**
   * �厡�㓙�̈�E�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addSyujis(){

    syujis.add(getSyujiNameContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    syujis.add(getSyujiMedicalNameContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    syujis.add(getSyujiAddressContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    syujis.add(getSuijiTels(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * �厡�㎁���ɓ������ڂ�ǉ����܂��B
   */
  protected void addSyujiName(){

  }

  /**
   * �厡���Ë@�ւɓ������ڂ�ǉ����܂��B
   */
  protected void addSyujiMedicalName(){

  }

  /**
   * �厡���Ë@�փ��f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addSyujiMedicalNameModel(){

  }

  /**
   * �厡�㏊�ݒn�ɓ������ڂ�ǉ����܂��B
   */
  protected void addSyujiAddress(){

  }

  /**
   * �厡��d�b�ԍ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addSuijiTels(){

    suijiTels.add(getSyujiTel1(), VRLayout.FLOW);

    suijiTels.add(getSyujiLabel1(), VRLayout.FLOW);

    suijiTels.add(getSyujiTel2(), VRLayout.FLOW);

    suijiTels.add(getSyujiLabel2(), VRLayout.FLOW);

    suijiTels.add(getSyujiTel3(), VRLayout.FLOW);

  }

  /**
   * �厡��d�b�ԍ�1�ɓ������ڂ�ǉ����܂��B
   */
  protected void addSyujiTel1(){

  }

  /**
   * �厡��d�b�ԍ����x��1�ɓ������ڂ�ǉ����܂��B
   */
  protected void addSyujiLabel1(){

  }

  /**
   * �厡��d�b�ԍ�2�ɓ������ڂ�ǉ����܂��B
   */
  protected void addSyujiTel2(){

  }

  /**
   * �厡��d�b�ԍ����x��2�ɓ������ڂ�ǉ����܂��B
   */
  protected void addSyujiLabel2(){

  }

  /**
   * �厡��d�b�ԍ�3�ɓ������ڂ�ǉ����܂��B
   */
  protected void addSyujiTel3(){

  }

  /**
   * NO.2 ADL�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPoints6(){

    points6.add(getRequestObjects(), VRLayout.FLOW_RETURN);

    points6.add(getEmergencyContacts(), VRLayout.FLOW);

  }

  /**
   * ADL�̏󋵗̈�E�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addRequestObjects(){

    RequestObjects.add(getRequestObjectMoveContainer(), VRLayout.FLOW_INSETLINE);

    RequestObjects.add(getRequestObjectDinnerContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    RequestObjects.add(getRequestObjectExcreteContainer(), VRLayout.FLOW_INSETLINE);

    RequestObjects.add(getRequestObjectBathContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    RequestObjects.add(getRequestObjectChangeClothesContainer(), VRLayout.FLOW_INSETLINE);

    RequestObjects.add(getRequestObjectSeiyoContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    RequestObjects.add(getRequestObjectIsisotuContainer(), VRLayout.FLOW_INSETLINE);

  }

  /**
   * �ړ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addRequestObjectMove(){

  }

  /**
   * �ړ����f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addRequestObjectMoveModel(){

    getRequestObjectMoveRadioItem1().setButtonIndex(1);
    getRequestObjectMoveModel().add(getRequestObjectMoveRadioItem1());

    getRequestObjectMoveRadioItem2().setButtonIndex(2);
    getRequestObjectMoveModel().add(getRequestObjectMoveRadioItem2());

    getRequestObjectMoveRadioItem3().setButtonIndex(3);
    getRequestObjectMoveModel().add(getRequestObjectMoveRadioItem3());

    getRequestObjectMoveRadioItem4().setButtonIndex(4);
    getRequestObjectMoveModel().add(getRequestObjectMoveRadioItem4());

  }

  /**
   * �����ɓ������ڂ�ǉ����܂��B
   */
  protected void addRequestObjectMoveRadioItem1(){

  }

  /**
   * �ꕔ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addRequestObjectMoveRadioItem2(){

  }

  /**
   * �S�ʉ�ɓ������ڂ�ǉ����܂��B
   */
  protected void addRequestObjectMoveRadioItem3(){

  }

  /**
   * ���̑��ɓ������ڂ�ǉ����܂��B
   */
  protected void addRequestObjectMoveRadioItem4(){

  }

  /**
   * �H���ɓ������ڂ�ǉ����܂��B
   */
  protected void addRequestObjectDinner(){

  }

  /**
   * �H�����f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addRequestObjectDinnerModel(){

    getRequestObjectDinnerRadioItem1().setButtonIndex(1);
    getRequestObjectDinnerModel().add(getRequestObjectDinnerRadioItem1());

    getRequestObjectDinnerRadioItem2().setButtonIndex(2);
    getRequestObjectDinnerModel().add(getRequestObjectDinnerRadioItem2());

    getRequestObjectDinnerRadioItem3().setButtonIndex(3);
    getRequestObjectDinnerModel().add(getRequestObjectDinnerRadioItem3());

    getRequestObjectDinnerRadioItem4().setButtonIndex(4);
    getRequestObjectDinnerModel().add(getRequestObjectDinnerRadioItem4());

  }

  /**
   * �����ɓ������ڂ�ǉ����܂��B
   */
  protected void addRequestObjectDinnerRadioItem1(){

  }

  /**
   * �ꕔ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addRequestObjectDinnerRadioItem2(){

  }

  /**
   * �S�ʉ�ɓ������ڂ�ǉ����܂��B
   */
  protected void addRequestObjectDinnerRadioItem3(){

  }

  /**
   * ���̑��ɓ������ڂ�ǉ����܂��B
   */
  protected void addRequestObjectDinnerRadioItem4(){

  }

  /**
   * �r���ɓ������ڂ�ǉ����܂��B
   */
  protected void addRequestObjectExcrete(){

  }

  /**
   * �r�����f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addRequestObjectExcreteModel(){

    getRequestObjectExcreteRadioItem1().setButtonIndex(1);
    getRequestObjectExcreteModel().add(getRequestObjectExcreteRadioItem1());

    getRequestObjectExcreteRadioItem2().setButtonIndex(2);
    getRequestObjectExcreteModel().add(getRequestObjectExcreteRadioItem2());

    getRequestObjectExcreteRadioItem3().setButtonIndex(3);
    getRequestObjectExcreteModel().add(getRequestObjectExcreteRadioItem3());

    getRequestObjectExcreteRadioItem4().setButtonIndex(4);
    getRequestObjectExcreteModel().add(getRequestObjectExcreteRadioItem4());

  }

  /**
   * �����ɓ������ڂ�ǉ����܂��B
   */
  protected void addRequestObjectExcreteRadioItem1(){

  }

  /**
   * �ꕔ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addRequestObjectExcreteRadioItem2(){

  }

  /**
   * �S�ʉ�ɓ������ڂ�ǉ����܂��B
   */
  protected void addRequestObjectExcreteRadioItem3(){

  }

  /**
   * ���̑��ɓ������ڂ�ǉ����܂��B
   */
  protected void addRequestObjectExcreteRadioItem4(){

  }

  /**
   * �����ɓ������ڂ�ǉ����܂��B
   */
  protected void addRequestObjectBath(){

  }

  /**
   * �������f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addRequestObjectBathModel(){

    getRequestObjectBathRadioItem1().setButtonIndex(1);
    getRequestObjectBathModel().add(getRequestObjectBathRadioItem1());

    getRequestObjectBathRadioItem2().setButtonIndex(2);
    getRequestObjectBathModel().add(getRequestObjectBathRadioItem2());

    getRequestObjectBathRadioItem3().setButtonIndex(3);
    getRequestObjectBathModel().add(getRequestObjectBathRadioItem3());

    getRequestObjectBathRadioItem4().setButtonIndex(4);
    getRequestObjectBathModel().add(getRequestObjectBathRadioItem4());

  }

  /**
   * �����ɓ������ڂ�ǉ����܂��B
   */
  protected void addRequestObjectBathRadioItem1(){

  }

  /**
   * �ꕔ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addRequestObjectBathRadioItem2(){

  }

  /**
   * �S�ʉ�ɓ������ڂ�ǉ����܂��B
   */
  protected void addRequestObjectBathRadioItem3(){

  }

  /**
   * ���̑��ɓ������ڂ�ǉ����܂��B
   */
  protected void addRequestObjectBathRadioItem4(){

  }

  /**
   * ���ւɓ������ڂ�ǉ����܂��B
   */
  protected void addRequestObjectChangeClothes(){

  }

  /**
   * ���փ��f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addRequestObjectChangeClothesModel(){

    getRequestObjectChangeClothesRadioItem1().setButtonIndex(1);
    getRequestObjectChangeClothesModel().add(getRequestObjectChangeClothesRadioItem1());

    getRequestObjectChangeClothesRadioItem2().setButtonIndex(2);
    getRequestObjectChangeClothesModel().add(getRequestObjectChangeClothesRadioItem2());

    getRequestObjectChangeClothesRadioItem3().setButtonIndex(3);
    getRequestObjectChangeClothesModel().add(getRequestObjectChangeClothesRadioItem3());

    getRequestObjectChangeClothesRadioItem4().setButtonIndex(4);
    getRequestObjectChangeClothesModel().add(getRequestObjectChangeClothesRadioItem4());

  }

  /**
   * �����ɓ������ڂ�ǉ����܂��B
   */
  protected void addRequestObjectChangeClothesRadioItem1(){

  }

  /**
   * �ꕔ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addRequestObjectChangeClothesRadioItem2(){

  }

  /**
   * �S�ʉ�ɓ������ڂ�ǉ����܂��B
   */
  protected void addRequestObjectChangeClothesRadioItem3(){

  }

  /**
   * ���̑��ɓ������ڂ�ǉ����܂��B
   */
  protected void addRequestObjectChangeClothesRadioItem4(){

  }

  /**
   * ���e�ɓ������ڂ�ǉ����܂��B
   */
  protected void addRequestObjectSeiyo(){

  }

  /**
   * ���e���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addRequestObjectSeiyoModel(){

    getRequestObjectSeiyoRadioItem1().setButtonIndex(1);
    getRequestObjectSeiyoModel().add(getRequestObjectSeiyoRadioItem1());

    getRequestObjectSeiyoRadioItem2().setButtonIndex(2);
    getRequestObjectSeiyoModel().add(getRequestObjectSeiyoRadioItem2());

    getRequestObjectSeiyoRadioItem3().setButtonIndex(3);
    getRequestObjectSeiyoModel().add(getRequestObjectSeiyoRadioItem3());

    getRequestObjectSeiyoRadioItem4().setButtonIndex(4);
    getRequestObjectSeiyoModel().add(getRequestObjectSeiyoRadioItem4());

  }

  /**
   * �����ɓ������ڂ�ǉ����܂��B
   */
  protected void addRequestObjectSeiyoRadioItem1(){

  }

  /**
   * �ꕔ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addRequestObjectSeiyoRadioItem2(){

  }

  /**
   * �S�ʉ�ɓ������ڂ�ǉ����܂��B
   */
  protected void addRequestObjectSeiyoRadioItem3(){

  }

  /**
   * ���̑��ɓ������ڂ�ǉ����܂��B
   */
  protected void addRequestObjectSeiyoRadioItem4(){

  }

  /**
   * �ӎv�a�ʂɓ������ڂ�ǉ����܂��B
   */
  protected void addRequestObjectIsisotu(){

  }

  /**
   * �ӎv�a�ʃ��f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addRequestObjectIsisotuModel(){

    getRequestObjectIsisotuRadioItem1().setButtonIndex(1);
    getRequestObjectIsisotuModel().add(getRequestObjectIsisotuRadioItem1());

    getRequestObjectIsisotuRadioItem2().setButtonIndex(2);
    getRequestObjectIsisotuModel().add(getRequestObjectIsisotuRadioItem2());

    getRequestObjectIsisotuRadioItem3().setButtonIndex(3);
    getRequestObjectIsisotuModel().add(getRequestObjectIsisotuRadioItem3());

    getRequestObjectIsisotuRadioItem4().setButtonIndex(4);
    getRequestObjectIsisotuModel().add(getRequestObjectIsisotuRadioItem4());

  }

  /**
   * �����ɓ������ڂ�ǉ����܂��B
   */
  protected void addRequestObjectIsisotuRadioItem1(){

  }

  /**
   * �ꕔ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addRequestObjectIsisotuRadioItem2(){

  }

  /**
   * �S�ʉ�ɓ������ڂ�ǉ����܂��B
   */
  protected void addRequestObjectIsisotuRadioItem3(){

  }

  /**
   * ���̑��ɓ������ڂ�ǉ����܂��B
   */
  protected void addRequestObjectIsisotuRadioItem4(){

  }

  /**
   * �ً}���̘A�����@�̈�E�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addEmergencyContacts(){

    emergencyContacts.add(getEmergencyContactContainer(), VRLayout.FLOW);

  }

  /**
   * �ً}���̘A�����@�̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addEmergencyContact(){

  }

  /**
   * �֌W�@�ցE���p�󋵗̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPoints7(){

    points7.add(getKankeikikans(), VRLayout.FLOW_RETURN);

    points7.add(getHokenfukusis(), VRLayout.FLOW);

  }

  /**
   * �֌W�@�֗̈�E�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKankeikikans(){

    kankeikikans.add(getContactAddressHeader(), new GridBagConstraints(0, 0, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

    kankeikikans.add(getChargeHeader(), new GridBagConstraints(1, 0, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 1));

    kankeikikans.add(getRemarkHeader(), new GridBagConstraints(2, 0, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 2));

    kankeikikans.add(getContact1(), new GridBagConstraints(0, 1, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

    kankeikikans.add(getCharge1(), new GridBagConstraints(1, 1, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 1));

    kankeikikans.add(getRemark1(), new GridBagConstraints(2, 1, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 2));

    kankeikikans.add(getContact2(), new GridBagConstraints(0, 2, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

    kankeikikans.add(getCharge2(), new GridBagConstraints(1, 2, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 1));

    kankeikikans.add(getRemark2(), new GridBagConstraints(2, 2, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 2));

    kankeikikans.add(getContact3(), new GridBagConstraints(0, 3, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

    kankeikikans.add(getCharge3(), new GridBagConstraints(1, 3, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 1));

    kankeikikans.add(getRemark3(), new GridBagConstraints(2, 3, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 2));

    kankeikikans.add(getContact4(), new GridBagConstraints(0, 4, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

    kankeikikans.add(getCharge4(), new GridBagConstraints(1, 4, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 1));

    kankeikikans.add(getRemark4(), new GridBagConstraints(2, 4, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 2));

  }

  /**
   * �֌W�@�֗̈�E���C�A�E�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKankeikikanLayout(){

  }

  /**
   * �A����(�w�b�_�ɓ������ڂ�ǉ����܂��B
   */
  protected void addContactAddressHeader(){

  }

  /**
   * �S����(�w�b�_�ɓ������ڂ�ǉ����܂��B
   */
  protected void addChargeHeader(){

  }

  /**
   * ���l(�w�b�_�ɓ������ڂ�ǉ����܂��B
   */
  protected void addRemarkHeader(){

  }

  /**
   * �A����1�ɓ������ڂ�ǉ����܂��B
   */
  protected void addContact1(){

  }

  /**
   * �S����1�ɓ������ڂ�ǉ����܂��B
   */
  protected void addCharge1(){

  }

  /**
   * ���l1�ɓ������ڂ�ǉ����܂��B
   */
  protected void addRemark1(){

  }

  /**
   * �A����2�ɓ������ڂ�ǉ����܂��B
   */
  protected void addContact2(){

  }

  /**
   * �S����2�ɓ������ڂ�ǉ����܂��B
   */
  protected void addCharge2(){

  }

  /**
   * ���l2�ɓ������ڂ�ǉ����܂��B
   */
  protected void addRemark2(){

  }

  /**
   * �A����3�ɓ������ڂ�ǉ����܂��B
   */
  protected void addContact3(){

  }

  /**
   * �S����3�ɓ������ڂ�ǉ����܂��B
   */
  protected void addCharge3(){

  }

  /**
   * ���l3�ɓ������ڂ�ǉ����܂��B
   */
  protected void addRemark3(){

  }

  /**
   * �A����4�ɓ������ڂ�ǉ����܂��B
   */
  protected void addContact4(){

  }

  /**
   * �S����4�ɓ������ڂ�ǉ����܂��B
   */
  protected void addCharge4(){

  }

  /**
   * ���l4�ɓ������ڂ�ǉ����܂��B
   */
  protected void addRemark4(){

  }

  /**
   * �ی��E�����T�[�r�X���̗��p�󋵁E�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHokenfukusis(){

    hokenfukusis.add(getHokenfukusiContainer(), VRLayout.FLOW);

  }

  /**
   * �ی�������T�[�r�X���̗��p�󋵂ɓ������ڂ�ǉ����܂��B
   */
  protected void addHokenfukusi(){

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

    return getNurseName();

  }
  public void initAffair(ACAffairInfo affair) throws Exception {
  }

  public static void main(String[] args) {
    //�f�t�H���g�f�o�b�O�N��
    try {
      ACFrame.setVRLookAndFeel();
      ACFrame.getInstance().setFrameEventProcesser(new QkanFrameEventProcesser());
      ACFrame.debugStart(new ACAffairInfo(QC004Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QC004Design getThis() {
    return this;
  }
}
