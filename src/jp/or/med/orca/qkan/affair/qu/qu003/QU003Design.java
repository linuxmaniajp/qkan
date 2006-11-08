
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
 * �J����: �����F
 * �쐬��: 2006/10/02  ���{�R���s���[�^�[������� �����F �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���p�ғo�^/�C�� (U)
 * �v���Z�X ���p�ғo�^ (003)
 * �v���O���� ��ÊŌ��� (QU003)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qu.qu003;
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
/**
 * ��ÊŌ����ʍ��ڃf�U�C��(QU003) 
 */
public class QU003Design extends QkanAffairContainer implements ACAffairable {
  //GUI�R���|�[�l���g

  private ACAffairButtonBar buttons;

  private ACAffairButton insert;

  private ACAffairButton update;

  private ACPanel contents;

  private ACPanel patientInfo;

  private ACLabel patientNameCaption;

  private ACLabel patientName;

  private JTabbedPane tabs;

  private ACPanel point1;

  private ACPanel medicalInfos;

  private ACClearableRadioButtonGroup medicalInfoInsuranceVarietyRadio1;

  private ACLabelContainer medicalInfoInsuranceVarietyRadio1Container;

  private ACListModelAdapter medicalInfoInsuranceVarietyRadio1Model;

  private ACRadioButtonItem medicalInfoInsuranceVarietyRadio1Item1;

  private ACRadioButtonItem medicalInfoInsuranceVarietyRadio1Item2;

  private ACRadioButtonItem medicalInfoInsuranceVarietyRadio1Item3;

  private ACClearableRadioButtonGroup medicalInfoInsuranceVarietyRadio2;

  private ACLabelContainer medicalInfoInsuranceVarietyRadio2Container;

  private ACListModelAdapter medicalInfoInsuranceVarietyRadio2Model;

  private ACRadioButtonItem medicalInfoInsuranceVarietyRadio2Item1;

  private ACRadioButtonItem medicalInfoInsuranceVarietyRadio2Item2;

  private ACClearableRadioButtonGroup medicalInfoPersonAndFamilyRadio;

  private ACLabelContainer medicalInfoPersonAndFamilyRadioContainer;

  private ACListModelAdapter medicalInfoPersonAndFamilyRadioModel;

  private ACRadioButtonItem medicalInfoPersonAndFamilyRadioItem1;

  private ACRadioButtonItem medicalInfoPersonAndFamilyRadioItem2;

  private ACRadioButtonItem medicalInfoPersonAndFamilyRadioItem3;

  private ACClearableRadioButtonGroup medicalInfoOld9AndOld8Radio;

  private ACLabelContainer medicalInfoOld9AndOld8RadioContainer;

  private ACListModelAdapter medicalInfoOld9AndOld8RadioModel;

  private ACRadioButtonItem medicalInfoOld9AndOld8RadioItem1;

  private ACRadioButtonItem medicalInfoOld9AndOld8RadioItem2;

  private ACRadioButtonItem medicalInfoOld9AndOld8RadioItem3;

  private ACLabelContainer medicalInfoInsurerNoContena;

  private ACTextField medicalInfoInsurerLawNo;

  private ACTextField medicalInfoInsurerNo;

  private ACComboBox medicalInfoInsurerName;

  private ACLabelContainer medicalInfoInsurerNameContainer;

  private ACComboBoxModelAdapter medicalInfoInsurerNameModel;

  private ACTextField medicalInfoMark;

  private ACLabelContainer medicalInfoMarkContainer;

  private ACLabelContainer medicalInfoValidLimitContena;

  private QkanDateTextField medicalInfoValidLimit1;

  private ACLabel medicalInfoValidLimitLabel;

  private QkanDateTextField medicalInfoValidLimit2;

  private ACLabelContainer medicalInfoProvideContena;

  private ACLabel medicalInfoProvideLabel1;

  private ACComboBox medicalInfoProvide;

  private ACComboBoxModelAdapter medicalInfoProvideModel;

  private ACLabel medicalInfoProvideLabel2;

  private ACLabelContainer medicalInfoCitiesNoContena;

  private ACTextField medicalInfoCitiesLawNo;

  private ACTextField medicalInfoCitiesNo;

  private ACComboBox medicalInfoCitiesName;

  private ACLabelContainer medicalInfoCitiesNameContainer;

  private ACComboBoxModelAdapter medicalInfoCitiesNameModel;

  private ACTextField medicalInfoOldPersonReceiptNo;

  private ACLabelContainer medicalInfoOldPersonReceiptNoContainer;

  private ACPanel medicalInfoButtons;

  private ACButton medicalInfoButtonClear;

  private ACButton medicalInfoButtonInsert;

  private ACButton medicalInfoButtonConpile;

  private ACButton medicalInfoButtonDelete;

  private ACTable medicalInfoTable;

  private VRTableColumnModel medicalInfoTableColumnModel;

  private ACTableColumn medicalInfoTableColumn0;

  private ACTableColumn medicalInfoTableColumn1;

  private ACTableColumn medicalInfoTableColumn2;

  private ACTableColumn medicalInfoTableColumn3;

  private ACTableColumn medicalInfoTableColumn4;

  private ACTableColumn medicalInfoTableColumn5;

  private ACTableColumn medicalInfoTableColumn6;

  private ACTableColumn medicalInfoTableColumn7;

  private ACTableColumn medicalInfoTableColumn8;

  private ACTableColumn medicalInfoTableColumn9;

  private ACTableColumn medicalInfoTableColumn10;

  private ACTableColumn medicalInfoTableColumn11;

  private ACPanel point2;

  private ACGroupBox callNursePatients;

  private ACTextArea callNurseMindState;

  private ACLabelContainer callNurseMindStateContainer;

  private ACTextArea callNurseMainDiseaseName;

  private ACLabelContainer callNurseMainDiseaseNameContainer;

  private ACClearableRadioButtonGroup callNurseInsuranceRadio;

  private ACLabelContainer callNurseInsuranceRadioContainer;

  private ACListModelAdapter callNurseInsuranceRadioModel;

  private ACRadioButtonItem callNurseInsuranceRadioItem1;

  private ACRadioButtonItem callNurseInsuranceRadioItem2;

  private ACLabel callNurseOfficialSpace1;

  private ACClearableRadioButtonGroup callNurseOfficialRadio;

  private ACLabelContainer callNurseOfficialRadioContainer;

  private ACListModelAdapter callNurseOfficialRadioModel;

  private ACRadioButtonItem callNurseOfficialRadioItem1;

  private ACRadioButtonItem callNurseOfficialRadioItem2;

  private ACRadioButtonItem callNurseOfficialRadioItem3;

  private ACLabel callNurseOfficialSpace2;

  private ACClearableRadioButtonGroup callNurseAddParticularRadio;

  private ACLabelContainer callNurseAddParticularRadioContainer;

  private ACListModelAdapter callNurseAddParticularRadioModel;

  private ACRadioButtonItem callNurseAddParticularRadioItem1;

  private ACRadioButtonItem callNurseAddParticularRadioItem2;

  private ACTextField callNurseCallTime;

  private ACLabelContainer callNurseCallTimeContainer;

  private ACGroupBox instructInfos;

  private ACLabelContainer instructInfoValidLimitContena;

  private ACPanel instructInfoValidLimitPanel1;

  private QkanDateTextField instructInfoValidLimit1;

  private ACLabel instructInfoValidLimitLabel;

  private QkanDateTextField instructInfoValidLimit2;

  private ACLabelContainer specialInstructContena;

  private ACPanel specialInstructPanel1;

  private QkanDateTextField specialInstruct1;

  private ACLabel specialInstructLabel1;

  private QkanDateTextField specialInstruct2;

  private ACPanel specialInstructPanel2;

  private ACButton specialInstructButton2;

  private ACLabel specialInstructCommentSpace1;

  private ACLabel specialInstructComment1;

  private ACLabel specialInstructCommentSpace2;

  private ACLabel specialInstructComment2;

  private ACGroupBox medicalTreatmentInfos;

  private ACPanel medicalTreatmentBasicInfos;

  private ACComboBox medicalTreatmentInfoOrgan;

  private ACLabelContainer medicalTreatmentInfoOrganContainer;

  private ACComboBoxModelAdapter medicalTreatmentInfoOrganModel;

  private ACTextField medicalTreatmentInfoZip;

  private ACLabelContainer medicalTreatmentInfoZipContainer;

  private ACTextField medicalTreatmentInfoAddress;

  private ACLabelContainer medicalTreatmentInfoAddressContainer;

  private ACTextField medicalTreatmentInfoTel;

  private ACLabelContainer medicalTreatmentInfoTelContainer;

  private ACTextField medicalTreatmentInfoFax;

  private ACLabelContainer medicalTreatmentInfoFaxContainer;

  private ACTextField medicalTreatmentInfoMainDoctorName;

  private ACLabelContainer medicalTreatmentInfoMainDoctorNameContainer;

  //getter

  /**
   * �Ɩ��{�^���o�[���擾���܂��B
   * @return �Ɩ��{�^���o�[
   */
  public ACAffairButtonBar getButtons(){
    if(buttons==null){

      buttons = new ACAffairButtonBar();

      buttons.setText("��ÊŌ���");

      addButtons();
    }
    return buttons;

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
   * ���p�Җ��̈���擾���܂��B
   * @return ���p�Җ��̈�
   */
  public ACPanel getPatientInfo(){
    if(patientInfo==null){

      patientInfo = new ACPanel();

      addPatientInfo();
    }
    return patientInfo;

  }

  /**
   * ���p�Җ��L���v�V�������擾���܂��B
   * @return ���p�Җ��L���v�V����
   */
  public ACLabel getPatientNameCaption(){
    if(patientNameCaption==null){

      patientNameCaption = new ACLabel();

      patientNameCaption.setText("���p�Җ�");

      addPatientNameCaption();
    }
    return patientNameCaption;

  }

  /**
   * ���p�Җ����擾���܂��B
   * @return ���p�Җ�
   */
  public ACLabel getPatientName(){
    if(patientName==null){

      patientName = new ACLabel();

      patientName.setText("�T���v�����p��");

      patientName.setBindPath("PATIENT_NAME");

      patientName.setColumns(35);

      addPatientName();
    }
    return patientName;

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
   * ��Õی��̈���擾���܂��B
   * @return ��Õی��̈�
   */
  public ACPanel getPoint1(){
    if(point1==null){

      point1 = new ACPanel();

      addPoint1();
    }
    return point1;

  }

  /**
   * ��Õی��̈�E�����擾���܂��B
   * @return ��Õی��̈�E���
   */
  public ACPanel getMedicalInfos(){
    if(medicalInfos==null){

      medicalInfos = new ACPanel();

      medicalInfos.setAutoWrap(false);

      addMedicalInfos();
    }
    return medicalInfos;

  }

  /**
   * �ی���ށE����擾���܂��B
   * @return �ی���ށE��
   */
  public ACClearableRadioButtonGroup getMedicalInfoInsuranceVarietyRadio1(){
    if(medicalInfoInsuranceVarietyRadio1==null){

      medicalInfoInsuranceVarietyRadio1 = new ACClearableRadioButtonGroup();

      getMedicalInfoInsuranceVarietyRadio1Container().setText("�ی����");

      medicalInfoInsuranceVarietyRadio1.setBindPath("INSURE_TYPE");

      medicalInfoInsuranceVarietyRadio1.setUseClearButton(false);

      medicalInfoInsuranceVarietyRadio1.setModel(getMedicalInfoInsuranceVarietyRadio1Model());

      addMedicalInfoInsuranceVarietyRadio1();
    }
    return medicalInfoInsuranceVarietyRadio1;

  }

  /**
   * �ی���ށE��R���e�i���擾���܂��B
   * @return �ی���ށE��R���e�i
   */
  protected ACLabelContainer getMedicalInfoInsuranceVarietyRadio1Container(){
    if(medicalInfoInsuranceVarietyRadio1Container==null){
      medicalInfoInsuranceVarietyRadio1Container = new ACLabelContainer();
      medicalInfoInsuranceVarietyRadio1Container.setFollowChildEnabled(true);
      medicalInfoInsuranceVarietyRadio1Container.setVAlignment(VRLayout.CENTER);
      medicalInfoInsuranceVarietyRadio1Container.add(getMedicalInfoInsuranceVarietyRadio1(), null);
    }
    return medicalInfoInsuranceVarietyRadio1Container;
  }

  /**
   * �ی���ށE�ヂ�f�����擾���܂��B
   * @return �ی���ށE�ヂ�f��
   */
  protected ACListModelAdapter getMedicalInfoInsuranceVarietyRadio1Model(){
    if(medicalInfoInsuranceVarietyRadio1Model==null){
      medicalInfoInsuranceVarietyRadio1Model = new ACListModelAdapter();
      addMedicalInfoInsuranceVarietyRadio1Model();
    }
    return medicalInfoInsuranceVarietyRadio1Model;
  }

  /**
   * �Еۂ��擾���܂��B
   * @return �Е�
   */
  public ACRadioButtonItem getMedicalInfoInsuranceVarietyRadio1Item1(){
    if(medicalInfoInsuranceVarietyRadio1Item1==null){

      medicalInfoInsuranceVarietyRadio1Item1 = new ACRadioButtonItem();

      medicalInfoInsuranceVarietyRadio1Item1.setText("�Е�");

      medicalInfoInsuranceVarietyRadio1Item1.setGroup(getMedicalInfoInsuranceVarietyRadio1());

      medicalInfoInsuranceVarietyRadio1Item1.setConstraints(VRLayout.FLOW);

      addMedicalInfoInsuranceVarietyRadio1Item1();
    }
    return medicalInfoInsuranceVarietyRadio1Item1;

  }

  /**
   * ���ۂ��擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getMedicalInfoInsuranceVarietyRadio1Item2(){
    if(medicalInfoInsuranceVarietyRadio1Item2==null){

      medicalInfoInsuranceVarietyRadio1Item2 = new ACRadioButtonItem();

      medicalInfoInsuranceVarietyRadio1Item2.setText("����");

      medicalInfoInsuranceVarietyRadio1Item2.setGroup(getMedicalInfoInsuranceVarietyRadio1());

      medicalInfoInsuranceVarietyRadio1Item2.setConstraints(VRLayout.FLOW);

      addMedicalInfoInsuranceVarietyRadio1Item2();
    }
    return medicalInfoInsuranceVarietyRadio1Item2;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getMedicalInfoInsuranceVarietyRadio1Item3(){
    if(medicalInfoInsuranceVarietyRadio1Item3==null){

      medicalInfoInsuranceVarietyRadio1Item3 = new ACRadioButtonItem();

      medicalInfoInsuranceVarietyRadio1Item3.setText("����");

      medicalInfoInsuranceVarietyRadio1Item3.setGroup(getMedicalInfoInsuranceVarietyRadio1());

      medicalInfoInsuranceVarietyRadio1Item3.setConstraints(VRLayout.FLOW);

      addMedicalInfoInsuranceVarietyRadio1Item3();
    }
    return medicalInfoInsuranceVarietyRadio1Item3;

  }

  /**
   * �ی���ށE�����擾���܂��B
   * @return �ی���ށE��
   */
  public ACClearableRadioButtonGroup getMedicalInfoInsuranceVarietyRadio2(){
    if(medicalInfoInsuranceVarietyRadio2==null){

      medicalInfoInsuranceVarietyRadio2 = new ACClearableRadioButtonGroup();

      medicalInfoInsuranceVarietyRadio2.setBindPath("OLD_FLAG");

      medicalInfoInsuranceVarietyRadio2.setModel(getMedicalInfoInsuranceVarietyRadio2Model());

      addMedicalInfoInsuranceVarietyRadio2();
    }
    return medicalInfoInsuranceVarietyRadio2;

  }

  /**
   * �ی���ށE���R���e�i���擾���܂��B
   * @return �ی���ށE���R���e�i
   */
  protected ACLabelContainer getMedicalInfoInsuranceVarietyRadio2Container(){
    if(medicalInfoInsuranceVarietyRadio2Container==null){
      medicalInfoInsuranceVarietyRadio2Container = new ACLabelContainer();
      medicalInfoInsuranceVarietyRadio2Container.setFollowChildEnabled(true);
      medicalInfoInsuranceVarietyRadio2Container.setVAlignment(VRLayout.CENTER);
      medicalInfoInsuranceVarietyRadio2Container.add(getMedicalInfoInsuranceVarietyRadio2(), null);
    }
    return medicalInfoInsuranceVarietyRadio2Container;
  }

  /**
   * �ی���ށE�����f�����擾���܂��B
   * @return �ی���ށE�����f��
   */
  protected ACListModelAdapter getMedicalInfoInsuranceVarietyRadio2Model(){
    if(medicalInfoInsuranceVarietyRadio2Model==null){
      medicalInfoInsuranceVarietyRadio2Model = new ACListModelAdapter();
      addMedicalInfoInsuranceVarietyRadio2Model();
    }
    return medicalInfoInsuranceVarietyRadio2Model;
  }

  /**
   * �V�l���擾���܂��B
   * @return �V�l
   */
  public ACRadioButtonItem getMedicalInfoInsuranceVarietyRadio2Item1(){
    if(medicalInfoInsuranceVarietyRadio2Item1==null){

      medicalInfoInsuranceVarietyRadio2Item1 = new ACRadioButtonItem();

      medicalInfoInsuranceVarietyRadio2Item1.setText("�V�l");

      medicalInfoInsuranceVarietyRadio2Item1.setGroup(getMedicalInfoInsuranceVarietyRadio2());

      medicalInfoInsuranceVarietyRadio2Item1.setConstraints(VRLayout.FLOW);

      addMedicalInfoInsuranceVarietyRadio2Item1();
    }
    return medicalInfoInsuranceVarietyRadio2Item1;

  }

  /**
   * �ސE�҂��擾���܂��B
   * @return �ސE��
   */
  public ACRadioButtonItem getMedicalInfoInsuranceVarietyRadio2Item2(){
    if(medicalInfoInsuranceVarietyRadio2Item2==null){

      medicalInfoInsuranceVarietyRadio2Item2 = new ACRadioButtonItem();

      medicalInfoInsuranceVarietyRadio2Item2.setText("�ސE��");

      medicalInfoInsuranceVarietyRadio2Item2.setGroup(getMedicalInfoInsuranceVarietyRadio2());

      medicalInfoInsuranceVarietyRadio2Item2.setConstraints(VRLayout.FLOW);

      addMedicalInfoInsuranceVarietyRadio2Item2();
    }
    return medicalInfoInsuranceVarietyRadio2Item2;

  }

  /**
   * �{�l/�Ƒ����擾���܂��B
   * @return �{�l/�Ƒ�
   */
  public ACClearableRadioButtonGroup getMedicalInfoPersonAndFamilyRadio(){
    if(medicalInfoPersonAndFamilyRadio==null){

      medicalInfoPersonAndFamilyRadio = new ACClearableRadioButtonGroup();

      getMedicalInfoPersonAndFamilyRadioContainer().setText("�{�l/�Ƒ�");

      medicalInfoPersonAndFamilyRadio.setBindPath("SELF_FLAG");

      medicalInfoPersonAndFamilyRadio.setUseClearButton(true);

      medicalInfoPersonAndFamilyRadio.setModel(getMedicalInfoPersonAndFamilyRadioModel());

      addMedicalInfoPersonAndFamilyRadio();
    }
    return medicalInfoPersonAndFamilyRadio;

  }

  /**
   * �{�l/�Ƒ��R���e�i���擾���܂��B
   * @return �{�l/�Ƒ��R���e�i
   */
  protected ACLabelContainer getMedicalInfoPersonAndFamilyRadioContainer(){
    if(medicalInfoPersonAndFamilyRadioContainer==null){
      medicalInfoPersonAndFamilyRadioContainer = new ACLabelContainer();
      medicalInfoPersonAndFamilyRadioContainer.setFollowChildEnabled(true);
      medicalInfoPersonAndFamilyRadioContainer.setVAlignment(VRLayout.CENTER);
      medicalInfoPersonAndFamilyRadioContainer.add(getMedicalInfoPersonAndFamilyRadio(), null);
    }
    return medicalInfoPersonAndFamilyRadioContainer;
  }

  /**
   * �{�l/�Ƒ����f�����擾���܂��B
   * @return �{�l/�Ƒ����f��
   */
  protected ACListModelAdapter getMedicalInfoPersonAndFamilyRadioModel(){
    if(medicalInfoPersonAndFamilyRadioModel==null){
      medicalInfoPersonAndFamilyRadioModel = new ACListModelAdapter();
      addMedicalInfoPersonAndFamilyRadioModel();
    }
    return medicalInfoPersonAndFamilyRadioModel;
  }

  /**
   * �{�l���擾���܂��B
   * @return �{�l
   */
  public ACRadioButtonItem getMedicalInfoPersonAndFamilyRadioItem1(){
    if(medicalInfoPersonAndFamilyRadioItem1==null){

      medicalInfoPersonAndFamilyRadioItem1 = new ACRadioButtonItem();

      medicalInfoPersonAndFamilyRadioItem1.setText("�{�l");

      medicalInfoPersonAndFamilyRadioItem1.setGroup(getMedicalInfoPersonAndFamilyRadio());

      medicalInfoPersonAndFamilyRadioItem1.setConstraints(VRLayout.FLOW);

      addMedicalInfoPersonAndFamilyRadioItem1();
    }
    return medicalInfoPersonAndFamilyRadioItem1;

  }

  /**
   * 3�΂��擾���܂��B
   * @return 3��
   */
  public ACRadioButtonItem getMedicalInfoPersonAndFamilyRadioItem2(){
    if(medicalInfoPersonAndFamilyRadioItem2==null){

      medicalInfoPersonAndFamilyRadioItem2 = new ACRadioButtonItem();

      medicalInfoPersonAndFamilyRadioItem2.setText("3��");

      medicalInfoPersonAndFamilyRadioItem2.setGroup(getMedicalInfoPersonAndFamilyRadio());

      medicalInfoPersonAndFamilyRadioItem2.setConstraints(VRLayout.FLOW);

      addMedicalInfoPersonAndFamilyRadioItem2();
    }
    return medicalInfoPersonAndFamilyRadioItem2;

  }

  /**
   * �Ƒ����擾���܂��B
   * @return �Ƒ�
   */
  public ACRadioButtonItem getMedicalInfoPersonAndFamilyRadioItem3(){
    if(medicalInfoPersonAndFamilyRadioItem3==null){

      medicalInfoPersonAndFamilyRadioItem3 = new ACRadioButtonItem();

      medicalInfoPersonAndFamilyRadioItem3.setText("�Ƒ�");

      medicalInfoPersonAndFamilyRadioItem3.setGroup(getMedicalInfoPersonAndFamilyRadio());

      medicalInfoPersonAndFamilyRadioItem3.setConstraints(VRLayout.FLOW);

      addMedicalInfoPersonAndFamilyRadioItem3();
    }
    return medicalInfoPersonAndFamilyRadioItem3;

  }

  /**
   * ��������擾���܂��B
   * @return �����
   */
  public ACClearableRadioButtonGroup getMedicalInfoOld9AndOld8Radio(){
    if(medicalInfoOld9AndOld8Radio==null){

      medicalInfoOld9AndOld8Radio = new ACClearableRadioButtonGroup();

      medicalInfoOld9AndOld8Radio.setBindPath("OLD_RATE_FLAG");

      medicalInfoOld9AndOld8Radio.setUseClearButton(true);

      medicalInfoOld9AndOld8Radio.setModel(getMedicalInfoOld9AndOld8RadioModel());

      addMedicalInfoOld9AndOld8Radio();
    }
    return medicalInfoOld9AndOld8Radio;

  }

  /**
   * ������R���e�i���擾���܂��B
   * @return ������R���e�i
   */
  protected ACLabelContainer getMedicalInfoOld9AndOld8RadioContainer(){
    if(medicalInfoOld9AndOld8RadioContainer==null){
      medicalInfoOld9AndOld8RadioContainer = new ACLabelContainer();
      medicalInfoOld9AndOld8RadioContainer.setFollowChildEnabled(true);
      medicalInfoOld9AndOld8RadioContainer.setVAlignment(VRLayout.CENTER);
      medicalInfoOld9AndOld8RadioContainer.add(getMedicalInfoOld9AndOld8Radio(), null);
    }
    return medicalInfoOld9AndOld8RadioContainer;
  }

  /**
   * ��������f�����擾���܂��B
   * @return ��������f��
   */
  protected ACListModelAdapter getMedicalInfoOld9AndOld8RadioModel(){
    if(medicalInfoOld9AndOld8RadioModel==null){
      medicalInfoOld9AndOld8RadioModel = new ACListModelAdapter();
      addMedicalInfoOld9AndOld8RadioModel();
    }
    return medicalInfoOld9AndOld8RadioModel;
  }

  /**
   * ����9���擾���܂��B
   * @return ����9
   */
  public ACRadioButtonItem getMedicalInfoOld9AndOld8RadioItem1(){
    if(medicalInfoOld9AndOld8RadioItem1==null){

      medicalInfoOld9AndOld8RadioItem1 = new ACRadioButtonItem();

      medicalInfoOld9AndOld8RadioItem1.setText("����9");

      medicalInfoOld9AndOld8RadioItem1.setGroup(getMedicalInfoOld9AndOld8Radio());

      medicalInfoOld9AndOld8RadioItem1.setConstraints(VRLayout.FLOW);

      addMedicalInfoOld9AndOld8RadioItem1();
    }
    return medicalInfoOld9AndOld8RadioItem1;

  }

  /**
   * ����8���擾���܂��B
   * @return ����8
   */
  public ACRadioButtonItem getMedicalInfoOld9AndOld8RadioItem2(){
    if(medicalInfoOld9AndOld8RadioItem2==null){

      medicalInfoOld9AndOld8RadioItem2 = new ACRadioButtonItem();

      medicalInfoOld9AndOld8RadioItem2.setText("����8");

      medicalInfoOld9AndOld8RadioItem2.setGroup(getMedicalInfoOld9AndOld8Radio());

      medicalInfoOld9AndOld8RadioItem2.setConstraints(VRLayout.FLOW);

      addMedicalInfoOld9AndOld8RadioItem2();
    }
    return medicalInfoOld9AndOld8RadioItem2;

  }

  /**
   * ����7���擾���܂��B
   * @return ����7
   */
  public ACRadioButtonItem getMedicalInfoOld9AndOld8RadioItem3(){
    if(medicalInfoOld9AndOld8RadioItem3==null){

      medicalInfoOld9AndOld8RadioItem3 = new ACRadioButtonItem();

      medicalInfoOld9AndOld8RadioItem3.setText("����7");

      medicalInfoOld9AndOld8RadioItem3.setGroup(getMedicalInfoOld9AndOld8Radio());

      medicalInfoOld9AndOld8RadioItem3.setConstraints(VRLayout.FLOW);

      addMedicalInfoOld9AndOld8RadioItem3();
    }
    return medicalInfoOld9AndOld8RadioItem3;

  }

  /**
   * (�ی��Ҕԍ��E�R���e�i)���擾���܂��B
   * @return (�ی��Ҕԍ��E�R���e�i)
   */
  public ACLabelContainer getMedicalInfoInsurerNoContena(){
    if(medicalInfoInsurerNoContena==null){

      medicalInfoInsurerNoContena = new ACLabelContainer();

      medicalInfoInsurerNoContena.setText("�ی��Ҕԍ�");

      medicalInfoInsurerNoContena.setFollowChildEnabled(true);

      addMedicalInfoInsurerNoContena();
    }
    return medicalInfoInsurerNoContena;

  }

  /**
   * (��Õی��Ҕԍ�)�@�ʔԍ����擾���܂��B
   * @return (��Õی��Ҕԍ�)�@�ʔԍ�
   */
  public ACTextField getMedicalInfoInsurerLawNo(){
    if(medicalInfoInsurerLawNo==null){

      medicalInfoInsurerLawNo = new ACTextField();

      medicalInfoInsurerLawNo.setBindPath("MEDICAL_LAW_NO");

      medicalInfoInsurerLawNo.setColumns(2);

      medicalInfoInsurerLawNo.setCharType(VRCharType.ONLY_DIGIT);

      medicalInfoInsurerLawNo.setIMEMode(InputSubset.LATIN);

      medicalInfoInsurerLawNo.setMaxLength(2);

      addMedicalInfoInsurerLawNo();
    }
    return medicalInfoInsurerLawNo;

  }

  /**
   * (��Õی��Ҕԍ�)�ی��Ҕԍ����擾���܂��B
   * @return (��Õی��Ҕԍ�)�ی��Ҕԍ�
   */
  public ACTextField getMedicalInfoInsurerNo(){
    if(medicalInfoInsurerNo==null){

      medicalInfoInsurerNo = new ACTextField();

      medicalInfoInsurerNo.setBindPath("MEDICAL_INSURER_ID");

      medicalInfoInsurerNo.setColumns(6);

      medicalInfoInsurerNo.setCharType(VRCharType.ONLY_DIGIT);

      medicalInfoInsurerNo.setIMEMode(InputSubset.LATIN);

      medicalInfoInsurerNo.setMaxLength(6);

      addMedicalInfoInsurerNo();
    }
    return medicalInfoInsurerNo;

  }

  /**
   * �ی��Җ����擾���܂��B
   * @return �ی��Җ�
   */
  public ACComboBox getMedicalInfoInsurerName(){
    if(medicalInfoInsurerName==null){

      medicalInfoInsurerName = new ACComboBox();

      getMedicalInfoInsurerNameContainer().setText("�ی��Җ�");

      medicalInfoInsurerName.setEditable(false);

      medicalInfoInsurerName.setColumns(10);

      medicalInfoInsurerName.setModelBindPath("MEDICAL_INSURER");

      medicalInfoInsurerName.setRenderBindPath("INSURER_NAME");

      medicalInfoInsurerName.setModel(getMedicalInfoInsurerNameModel());

      addMedicalInfoInsurerName();
    }
    return medicalInfoInsurerName;

  }

  /**
   * �ی��Җ��R���e�i���擾���܂��B
   * @return �ی��Җ��R���e�i
   */
  protected ACLabelContainer getMedicalInfoInsurerNameContainer(){
    if(medicalInfoInsurerNameContainer==null){
      medicalInfoInsurerNameContainer = new ACLabelContainer();
      medicalInfoInsurerNameContainer.setFollowChildEnabled(true);
      medicalInfoInsurerNameContainer.setVAlignment(VRLayout.CENTER);
      medicalInfoInsurerNameContainer.add(getMedicalInfoInsurerName(), null);
    }
    return medicalInfoInsurerNameContainer;
  }

  /**
   * �ی��Җ����f�����擾���܂��B
   * @return �ی��Җ����f��
   */
  protected ACComboBoxModelAdapter getMedicalInfoInsurerNameModel(){
    if(medicalInfoInsurerNameModel==null){
      medicalInfoInsurerNameModel = new ACComboBoxModelAdapter();
      addMedicalInfoInsurerNameModel();
    }
    return medicalInfoInsurerNameModel;
  }

  /**
   * �L���E�ԍ����擾���܂��B
   * @return �L���E�ԍ�
   */
  public ACTextField getMedicalInfoMark(){
    if(medicalInfoMark==null){

      medicalInfoMark = new ACTextField();

      getMedicalInfoMarkContainer().setText("�L���E�ԍ�");

      medicalInfoMark.setBindPath("MEDICAL_INSURE_ID");

      medicalInfoMark.setColumns(12);

      medicalInfoMark.setIMEMode(InputSubset.KANJI);

      medicalInfoMark.setMaxLength(16);

      addMedicalInfoMark();
    }
    return medicalInfoMark;

  }

  /**
   * �L���E�ԍ��R���e�i���擾���܂��B
   * @return �L���E�ԍ��R���e�i
   */
  protected ACLabelContainer getMedicalInfoMarkContainer(){
    if(medicalInfoMarkContainer==null){
      medicalInfoMarkContainer = new ACLabelContainer();
      medicalInfoMarkContainer.setFollowChildEnabled(true);
      medicalInfoMarkContainer.setVAlignment(VRLayout.CENTER);
      medicalInfoMarkContainer.add(getMedicalInfoMark(), null);
    }
    return medicalInfoMarkContainer;
  }

  /**
   * �L�����ԁE�R���e�i���擾���܂��B
   * @return �L�����ԁE�R���e�i
   */
  public ACLabelContainer getMedicalInfoValidLimitContena(){
    if(medicalInfoValidLimitContena==null){

      medicalInfoValidLimitContena = new ACLabelContainer();

      medicalInfoValidLimitContena.setText("�L������");

      medicalInfoValidLimitContena.setFollowChildEnabled(true);

      addMedicalInfoValidLimitContena();
    }
    return medicalInfoValidLimitContena;

  }

  /**
   * �L�����ԁE�e�L�X�g1���擾���܂��B
   * @return �L�����ԁE�e�L�X�g1
   */
  public QkanDateTextField getMedicalInfoValidLimit1(){
    if(medicalInfoValidLimit1==null){

      medicalInfoValidLimit1 = new QkanDateTextField();

      medicalInfoValidLimit1.setBindPath("MEDICAL_VALID_START");

      addMedicalInfoValidLimit1();
    }
    return medicalInfoValidLimit1;

  }

  /**
   * �L�����ԁE���x�����擾���܂��B
   * @return �L�����ԁE���x��
   */
  public ACLabel getMedicalInfoValidLimitLabel(){
    if(medicalInfoValidLimitLabel==null){

      medicalInfoValidLimitLabel = new ACLabel();

      medicalInfoValidLimitLabel.setText(" ���� ");

      addMedicalInfoValidLimitLabel();
    }
    return medicalInfoValidLimitLabel;

  }

  /**
   * �L�����ԁE�e�L�X�g2���擾���܂��B
   * @return �L�����ԁE�e�L�X�g2
   */
  public QkanDateTextField getMedicalInfoValidLimit2(){
    if(medicalInfoValidLimit2==null){

      medicalInfoValidLimit2 = new QkanDateTextField();

      medicalInfoValidLimit2.setBindPath("MEDICAL_VALID_END");

      medicalInfoValidLimit2.setColumns(10);

      medicalInfoValidLimit2.setFormat(new ACBorderBlankDateFormat("gggee�NMM��dd��"));

      medicalInfoValidLimit2.setMaxLength(11);

      addMedicalInfoValidLimit2();
    }
    return medicalInfoValidLimit2;

  }

  /**
   * ���t�����E�R���e�i���擾���܂��B
   * @return ���t�����E�R���e�i
   */
  public ACLabelContainer getMedicalInfoProvideContena(){
    if(medicalInfoProvideContena==null){

      medicalInfoProvideContena = new ACLabelContainer();

      medicalInfoProvideContena.setText("���t����");

      medicalInfoProvideContena.setFollowChildEnabled(true);

      addMedicalInfoProvideContena();
    }
    return medicalInfoProvideContena;

  }

  /**
   * ���t�����E���x��1���擾���܂��B
   * @return ���t�����E���x��1
   */
  public ACLabel getMedicalInfoProvideLabel1(){
    if(medicalInfoProvideLabel1==null){

      medicalInfoProvideLabel1 = new ACLabel();

      addMedicalInfoProvideLabel1();
    }
    return medicalInfoProvideLabel1;

  }

  /**
   * ���t�������擾���܂��B
   * @return ���t����
   */
  public ACComboBox getMedicalInfoProvide(){
    if(medicalInfoProvide==null){

      medicalInfoProvide = new ACComboBox();

      medicalInfoProvide.setBindPath("BENEFIT_RATE");

      medicalInfoProvide.setEditable(false);

      medicalInfoProvide.setColumns(3);

      medicalInfoProvide.setModelBindPath("BENEFIT_RATE");

      medicalInfoProvide.setRenderBindPath("CONTENT");

      medicalInfoProvide.setModel(getMedicalInfoProvideModel());

      addMedicalInfoProvide();
    }
    return medicalInfoProvide;

  }

  /**
   * ���t�������f�����擾���܂��B
   * @return ���t�������f��
   */
  protected ACComboBoxModelAdapter getMedicalInfoProvideModel(){
    if(medicalInfoProvideModel==null){
      medicalInfoProvideModel = new ACComboBoxModelAdapter();
      addMedicalInfoProvideModel();
    }
    return medicalInfoProvideModel;
  }

  /**
   * ���t�����E���x��2���擾���܂��B
   * @return ���t�����E���x��2
   */
  public ACLabel getMedicalInfoProvideLabel2(){
    if(medicalInfoProvideLabel2==null){

      medicalInfoProvideLabel2 = new ACLabel();

      medicalInfoProvideLabel2.setText(" ��");

      addMedicalInfoProvideLabel2();
    }
    return medicalInfoProvideLabel2;

  }

  /**
   * (�s�����ԍ��E�R���e�i)���擾���܂��B
   * @return (�s�����ԍ��E�R���e�i)
   */
  public ACLabelContainer getMedicalInfoCitiesNoContena(){
    if(medicalInfoCitiesNoContena==null){

      medicalInfoCitiesNoContena = new ACLabelContainer();

      medicalInfoCitiesNoContena.setText("�s�����ԍ�");

      medicalInfoCitiesNoContena.setFollowChildEnabled(true);

      addMedicalInfoCitiesNoContena();
    }
    return medicalInfoCitiesNoContena;

  }

  /**
   * (�s�����ԍ�)�@�ʔԍ����擾���܂��B
   * @return (�s�����ԍ�)�@�ʔԍ�
   */
  public ACTextField getMedicalInfoCitiesLawNo(){
    if(medicalInfoCitiesLawNo==null){

      medicalInfoCitiesLawNo = new ACTextField();

      medicalInfoCitiesLawNo.setBindPath("CITY_LAW_NO");

      medicalInfoCitiesLawNo.setColumns(2);

      medicalInfoCitiesLawNo.setCharType(VRCharType.ONLY_DIGIT);

      medicalInfoCitiesLawNo.setIMEMode(InputSubset.LATIN);

      medicalInfoCitiesLawNo.setMaxLength(2);

      addMedicalInfoCitiesLawNo();
    }
    return medicalInfoCitiesLawNo;

  }

  /**
   * (�s�����ԍ�)�ی��Ҕԍ����擾���܂��B
   * @return (�s�����ԍ�)�ی��Ҕԍ�
   */
  public ACTextField getMedicalInfoCitiesNo(){
    if(medicalInfoCitiesNo==null){

      medicalInfoCitiesNo = new ACTextField();

      medicalInfoCitiesNo.setBindPath("CITY_INSURER_ID");

      medicalInfoCitiesNo.setColumns(6);

      medicalInfoCitiesNo.setCharType(VRCharType.ONLY_DIGIT);

      medicalInfoCitiesNo.setIMEMode(InputSubset.LATIN);

      medicalInfoCitiesNo.setMaxLength(6);

      addMedicalInfoCitiesNo();
    }
    return medicalInfoCitiesNo;

  }

  /**
   * �s���������擾���܂��B
   * @return �s������
   */
  public ACComboBox getMedicalInfoCitiesName(){
    if(medicalInfoCitiesName==null){

      medicalInfoCitiesName = new ACComboBox();

      getMedicalInfoCitiesNameContainer().setText("�s������");

      medicalInfoCitiesName.setEditable(false);

      medicalInfoCitiesName.setColumns(10);

      medicalInfoCitiesName.setModelBindPath("CITY_INSURER");

      medicalInfoCitiesName.setRenderBindPath("INSURER_NAME");

      medicalInfoCitiesName.setModel(getMedicalInfoCitiesNameModel());

      addMedicalInfoCitiesName();
    }
    return medicalInfoCitiesName;

  }

  /**
   * �s�������R���e�i���擾���܂��B
   * @return �s�������R���e�i
   */
  protected ACLabelContainer getMedicalInfoCitiesNameContainer(){
    if(medicalInfoCitiesNameContainer==null){
      medicalInfoCitiesNameContainer = new ACLabelContainer();
      medicalInfoCitiesNameContainer.setFollowChildEnabled(true);
      medicalInfoCitiesNameContainer.setVAlignment(VRLayout.CENTER);
      medicalInfoCitiesNameContainer.add(getMedicalInfoCitiesName(), null);
    }
    return medicalInfoCitiesNameContainer;
  }

  /**
   * �s���������f�����擾���܂��B
   * @return �s���������f��
   */
  protected ACComboBoxModelAdapter getMedicalInfoCitiesNameModel(){
    if(medicalInfoCitiesNameModel==null){
      medicalInfoCitiesNameModel = new ACComboBoxModelAdapter();
      addMedicalInfoCitiesNameModel();
    }
    return medicalInfoCitiesNameModel;
  }

  /**
   * �V�l�󋋎Ҕԍ����擾���܂��B
   * @return �V�l�󋋎Ҕԍ�
   */
  public ACTextField getMedicalInfoOldPersonReceiptNo(){
    if(medicalInfoOldPersonReceiptNo==null){

      medicalInfoOldPersonReceiptNo = new ACTextField();

      getMedicalInfoOldPersonReceiptNoContainer().setText("�V�l�󋋎Ҕԍ�");

      medicalInfoOldPersonReceiptNo.setBindPath("OLD_RECIPIENT_ID");

      medicalInfoOldPersonReceiptNo.setColumns(10);

      medicalInfoOldPersonReceiptNo.setCharType(VRCharType.ONLY_DIGIT);

      medicalInfoOldPersonReceiptNo.setIMEMode(InputSubset.LATIN);

      medicalInfoOldPersonReceiptNo.setMaxLength(7);

      addMedicalInfoOldPersonReceiptNo();
    }
    return medicalInfoOldPersonReceiptNo;

  }

  /**
   * �V�l�󋋎Ҕԍ��R���e�i���擾���܂��B
   * @return �V�l�󋋎Ҕԍ��R���e�i
   */
  protected ACLabelContainer getMedicalInfoOldPersonReceiptNoContainer(){
    if(medicalInfoOldPersonReceiptNoContainer==null){
      medicalInfoOldPersonReceiptNoContainer = new ACLabelContainer();
      medicalInfoOldPersonReceiptNoContainer.setFollowChildEnabled(true);
      medicalInfoOldPersonReceiptNoContainer.setVAlignment(VRLayout.CENTER);
      medicalInfoOldPersonReceiptNoContainer.add(getMedicalInfoOldPersonReceiptNo(), null);
    }
    return medicalInfoOldPersonReceiptNoContainer;
  }

  /**
   * �{�^���̈���擾���܂��B
   * @return �{�^���̈�
   */
  public ACPanel getMedicalInfoButtons(){
    if(medicalInfoButtons==null){

      medicalInfoButtons = new ACPanel();

      addMedicalInfoButtons();
    }
    return medicalInfoButtons;

  }

  /**
   * �N���A���擾���܂��B
   * @return �N���A
   */
  public ACButton getMedicalInfoButtonClear(){
    if(medicalInfoButtonClear==null){

      medicalInfoButtonClear = new ACButton();

      medicalInfoButtonClear.setText("�N���A");

      medicalInfoButtonClear.setToolTipText("��Õی������N���A���܂��B");

      medicalInfoButtonClear.setIconPath(ACConstants.ICON_PATH_CLEAR_16);

      addMedicalInfoButtonClear();
    }
    return medicalInfoButtonClear;

  }

  /**
   * �ǉ����擾���܂��B
   * @return �ǉ�
   */
  public ACButton getMedicalInfoButtonInsert(){
    if(medicalInfoButtonInsert==null){

      medicalInfoButtonInsert = new ACButton();

      medicalInfoButtonInsert.setText("�ǉ�");

      medicalInfoButtonInsert.setToolTipText("��Õی�����ǉ����܂��B");

      medicalInfoButtonInsert.setIconPath(ACConstants.ICON_PATH_RECORD_DOWNLOAD_16);

      addMedicalInfoButtonInsert();
    }
    return medicalInfoButtonInsert;

  }

  /**
   * ���ւ��擾���܂��B
   * @return ����
   */
  public ACButton getMedicalInfoButtonConpile(){
    if(medicalInfoButtonConpile==null){

      medicalInfoButtonConpile = new ACButton();

      medicalInfoButtonConpile.setText("����");

      medicalInfoButtonConpile.setToolTipText("��Õی�����ҏW���܂��B");

      medicalInfoButtonConpile.setIconPath(ACConstants.ICON_PATH_STATE_UPDATE_16);

      addMedicalInfoButtonConpile();
    }
    return medicalInfoButtonConpile;

  }

  /**
   * �폜���擾���܂��B
   * @return �폜
   */
  public ACButton getMedicalInfoButtonDelete(){
    if(medicalInfoButtonDelete==null){

      medicalInfoButtonDelete = new ACButton();

      medicalInfoButtonDelete.setText("�폜");

      medicalInfoButtonDelete.setToolTipText("��Õی������폜���܂��B");

      medicalInfoButtonDelete.setIconPath(ACConstants.ICON_PATH_STATE_DELETE_16);

      addMedicalInfoButtonDelete();
    }
    return medicalInfoButtonDelete;

  }

  /**
   * ��Õی��̈�E�e�[�u�����擾���܂��B
   * @return ��Õی��̈�E�e�[�u��
   */
  public ACTable getMedicalInfoTable(){
    if(medicalInfoTable==null){

      medicalInfoTable = new ACTable();

      medicalInfoTable.setColumnModel(getMedicalInfoTableColumnModel());

      addMedicalInfoTable();
    }
    return medicalInfoTable;

  }

  /**
   * ��Õی��̈�E�e�[�u���J�������f�����擾���܂��B
   * @return ��Õی��̈�E�e�[�u���J�������f��
   */
  protected VRTableColumnModel getMedicalInfoTableColumnModel(){
    if(medicalInfoTableColumnModel==null){
      medicalInfoTableColumnModel = new VRTableColumnModel(new TableColumn[]{});
      addMedicalInfoTableColumnModel();
    }
    return medicalInfoTableColumnModel;
  }

  /**
   * No���擾���܂��B
   * @return No
   */
  public ACTableColumn getMedicalInfoTableColumn0(){
    if(medicalInfoTableColumn0==null){

      medicalInfoTableColumn0 = new ACTableColumn(0);

      medicalInfoTableColumn0.setHeaderValue("No.");

      medicalInfoTableColumn0.setColumns(3);

      medicalInfoTableColumn0.setRendererType(ACTableCellViewer.RENDERER_TYPE_SERIAL_NO);

      medicalInfoTableColumn0.setSortable(false);

      addMedicalInfoTableColumn0();
    }
    return medicalInfoTableColumn0;

  }

  /**
   * �ی���ރJ�������擾���܂��B
   * @return �ی���ރJ����
   */
  public ACTableColumn getMedicalInfoTableColumn1(){
    if(medicalInfoTableColumn1==null){

      medicalInfoTableColumn1 = new ACTableColumn(0);

      medicalInfoTableColumn1.setHeaderValue("�ی����");

      medicalInfoTableColumn1.setColumns(6);

      addMedicalInfoTableColumn1();
    }
    return medicalInfoTableColumn1;

  }

  /**
   * �{�l/�Ƒ��J�������擾���܂��B
   * @return �{�l/�Ƒ��J����
   */
  public ACTableColumn getMedicalInfoTableColumn2(){
    if(medicalInfoTableColumn2==null){

      medicalInfoTableColumn2 = new ACTableColumn(1);

      medicalInfoTableColumn2.setHeaderValue("�{�l/�Ƒ�");

      medicalInfoTableColumn2.setColumns(7);

      addMedicalInfoTableColumn2();
    }
    return medicalInfoTableColumn2;

  }

  /**
   * �ی��Ҕԍ��J�������擾���܂��B
   * @return �ی��Ҕԍ��J����
   */
  public ACTableColumn getMedicalInfoTableColumn3(){
    if(medicalInfoTableColumn3==null){

      medicalInfoTableColumn3 = new ACTableColumn(2);

      medicalInfoTableColumn3.setHeaderValue("�ی��Ҕԍ�");

      medicalInfoTableColumn3.setColumns(7);

      addMedicalInfoTableColumn3();
    }
    return medicalInfoTableColumn3;

  }

  /**
   * �ی��Җ��J�������擾���܂��B
   * @return �ی��Җ��J����
   */
  public ACTableColumn getMedicalInfoTableColumn4(){
    if(medicalInfoTableColumn4==null){

      medicalInfoTableColumn4 = new ACTableColumn(3);

      medicalInfoTableColumn4.setHeaderValue("�ی��Җ�");

      medicalInfoTableColumn4.setColumns(10);

      addMedicalInfoTableColumn4();
    }
    return medicalInfoTableColumn4;

  }

  /**
   * �L���E�ԍ��J�������擾���܂��B
   * @return �L���E�ԍ��J����
   */
  public ACTableColumn getMedicalInfoTableColumn5(){
    if(medicalInfoTableColumn5==null){

      medicalInfoTableColumn5 = new ACTableColumn(4);

      medicalInfoTableColumn5.setHeaderValue("�L���E�ԍ�");

      medicalInfoTableColumn5.setColumns(7);

      addMedicalInfoTableColumn5();
    }
    return medicalInfoTableColumn5;

  }

  /**
   * �L�����ԊJ�n�J�������擾���܂��B
   * @return �L�����ԊJ�n�J����
   */
  public ACTableColumn getMedicalInfoTableColumn6(){
    if(medicalInfoTableColumn6==null){

      medicalInfoTableColumn6 = new ACTableColumn(5);

      medicalInfoTableColumn6.setHeaderValue("�L�����ԊJ�n��");

      medicalInfoTableColumn6.setColumns(10);

      medicalInfoTableColumn6.setFormat(new ACBorderBlankDateFormat("gggee�NMM��dd��"));

      addMedicalInfoTableColumn6();
    }
    return medicalInfoTableColumn6;

  }

  /**
   * �L�����ԏI���J�������擾���܂��B
   * @return �L�����ԏI���J����
   */
  public ACTableColumn getMedicalInfoTableColumn7(){
    if(medicalInfoTableColumn7==null){

      medicalInfoTableColumn7 = new ACTableColumn(6);

      medicalInfoTableColumn7.setHeaderValue("�L�����ԏI����");

      medicalInfoTableColumn7.setColumns(10);

      medicalInfoTableColumn7.setFormat(new ACBorderBlankDateFormat("gggee�NMM��dd��"));

      addMedicalInfoTableColumn7();
    }
    return medicalInfoTableColumn7;

  }

  /**
   * ���t�����J�������擾���܂��B
   * @return ���t�����J����
   */
  public ACTableColumn getMedicalInfoTableColumn8(){
    if(medicalInfoTableColumn8==null){

      medicalInfoTableColumn8 = new ACTableColumn(7);

      medicalInfoTableColumn8.setHeaderValue("���t����");

      medicalInfoTableColumn8.setColumns(6);

      medicalInfoTableColumn8.setHorizontalAlignment(SwingConstants.RIGHT);

      addMedicalInfoTableColumn8();
    }
    return medicalInfoTableColumn8;

  }

  /**
   * �s�����ԍ��J�������擾���܂��B
   * @return �s�����ԍ��J����
   */
  public ACTableColumn getMedicalInfoTableColumn9(){
    if(medicalInfoTableColumn9==null){

      medicalInfoTableColumn9 = new ACTableColumn(8);

      medicalInfoTableColumn9.setHeaderValue("�s�����ԍ�");

      medicalInfoTableColumn9.setColumns(7);

      addMedicalInfoTableColumn9();
    }
    return medicalInfoTableColumn9;

  }

  /**
   * �s�������J�������擾���܂��B
   * @return �s�������J����
   */
  public ACTableColumn getMedicalInfoTableColumn10(){
    if(medicalInfoTableColumn10==null){

      medicalInfoTableColumn10 = new ACTableColumn(9);

      medicalInfoTableColumn10.setHeaderValue("�s������");

      medicalInfoTableColumn10.setColumns(10);

      addMedicalInfoTableColumn10();
    }
    return medicalInfoTableColumn10;

  }

  /**
   * �V�l�󋋎Ҕԍ��J�������擾���܂��B
   * @return �V�l�󋋎Ҕԍ��J����
   */
  public ACTableColumn getMedicalInfoTableColumn11(){
    if(medicalInfoTableColumn11==null){

      medicalInfoTableColumn11 = new ACTableColumn(10);

      medicalInfoTableColumn11.setHeaderValue("�V�l�󋋎Ҕԍ�");

      medicalInfoTableColumn11.setColumns(8);

      addMedicalInfoTableColumn11();
    }
    return medicalInfoTableColumn11;

  }

  /**
   * �K��Ō�×{��׏����o�^�̈���擾���܂��B
   * @return �K��Ō�×{��׏����o�^�̈�
   */
  public ACPanel getPoint2(){
    if(point2==null){

      point2 = new ACPanel();

      addPoint2();
    }
    return point2;

  }

  /**
   * ���p�҂̏󋵗̈���擾���܂��B
   * @return ���p�҂̏󋵗̈�
   */
  public ACGroupBox getCallNursePatients(){
    if(callNursePatients==null){

      callNursePatients = new ACGroupBox();

      callNursePatients.setText("���p�҂̏�");

      callNursePatients.setAutoWrap(false);

      addCallNursePatients();
    }
    return callNursePatients;

  }

  /**
   * �S�g�̏�Ԃ��擾���܂��B
   * @return �S�g�̏��
   */
  public ACTextArea getCallNurseMindState(){
    if(callNurseMindState==null){

      callNurseMindState = new ACTextArea();

      getCallNurseMindStateContainer().setText("�S�g�̏��");

      callNurseMindState.setBindPath("BODY_STATE");

      callNurseMindState.setColumns(50);

      callNurseMindState.setRows(6);

      callNurseMindState.setMaxRows(6);

      callNurseMindState.setIMEMode(InputSubset.KANJI);

      callNurseMindState.setMaxLength(300);

      callNurseMindState.setLineWrap(true);

      addCallNurseMindState();
    }
    return callNurseMindState;

  }

  /**
   * �S�g�̏�ԃR���e�i���擾���܂��B
   * @return �S�g�̏�ԃR���e�i
   */
  protected ACLabelContainer getCallNurseMindStateContainer(){
    if(callNurseMindStateContainer==null){
      callNurseMindStateContainer = new ACLabelContainer();
      callNurseMindStateContainer.setFollowChildEnabled(true);
      callNurseMindStateContainer.setVAlignment(VRLayout.CENTER);
      callNurseMindStateContainer.add(getCallNurseMindState(), null);
    }
    return callNurseMindStateContainer;
  }

  /**
   * �傽�鏝�a�����擾���܂��B
   * @return �傽�鏝�a��
   */
  public ACTextArea getCallNurseMainDiseaseName(){
    if(callNurseMainDiseaseName==null){

      callNurseMainDiseaseName = new ACTextArea();

      getCallNurseMainDiseaseNameContainer().setText("�傽�鏝�a��");

      callNurseMainDiseaseName.setBindPath("DISEASE");

      callNurseMainDiseaseName.setColumns(50);

      callNurseMainDiseaseName.setRows(5);

      callNurseMainDiseaseName.setMaxRows(5);

      callNurseMainDiseaseName.setIMEMode(InputSubset.KANJI);

      callNurseMainDiseaseName.setMaxLength(250);

      callNurseMainDiseaseName.setLineWrap(true);

      addCallNurseMainDiseaseName();
    }
    return callNurseMainDiseaseName;

  }

  /**
   * �傽�鏝�a���R���e�i���擾���܂��B
   * @return �傽�鏝�a���R���e�i
   */
  protected ACLabelContainer getCallNurseMainDiseaseNameContainer(){
    if(callNurseMainDiseaseNameContainer==null){
      callNurseMainDiseaseNameContainer = new ACLabelContainer();
      callNurseMainDiseaseNameContainer.setFollowChildEnabled(true);
      callNurseMainDiseaseNameContainer.setVAlignment(VRLayout.CENTER);
      callNurseMainDiseaseNameContainer.add(getCallNurseMainDiseaseName(), null);
    }
    return callNurseMainDiseaseNameContainer;
  }

  /**
   * ������b�̒�߂鎾�a���擾���܂��B
   * @return ������b�̒�߂鎾�a
   */
  public ACClearableRadioButtonGroup getCallNurseInsuranceRadio(){
    if(callNurseInsuranceRadio==null){

      callNurseInsuranceRadio = new ACClearableRadioButtonGroup();

      getCallNurseInsuranceRadioContainer().setText("�����J����b�̒�߂鎾�a");

      callNurseInsuranceRadio.setBindPath("SPECIAL_SHIPPEI");

      callNurseInsuranceRadio.setUseClearButton(false);

      callNurseInsuranceRadio.setModel(getCallNurseInsuranceRadioModel());

      addCallNurseInsuranceRadio();
    }
    return callNurseInsuranceRadio;

  }

  /**
   * ������b�̒�߂鎾�a�R���e�i���擾���܂��B
   * @return ������b�̒�߂鎾�a�R���e�i
   */
  protected ACLabelContainer getCallNurseInsuranceRadioContainer(){
    if(callNurseInsuranceRadioContainer==null){
      callNurseInsuranceRadioContainer = new ACLabelContainer();
      callNurseInsuranceRadioContainer.setFollowChildEnabled(true);
      callNurseInsuranceRadioContainer.setVAlignment(VRLayout.CENTER);
      callNurseInsuranceRadioContainer.add(getCallNurseInsuranceRadio(), null);
    }
    return callNurseInsuranceRadioContainer;
  }

  /**
   * ������b�̒�߂鎾�a���f�����擾���܂��B
   * @return ������b�̒�߂鎾�a���f��
   */
  protected ACListModelAdapter getCallNurseInsuranceRadioModel(){
    if(callNurseInsuranceRadioModel==null){
      callNurseInsuranceRadioModel = new ACListModelAdapter();
      addCallNurseInsuranceRadioModel();
    }
    return callNurseInsuranceRadioModel;
  }

  /**
   * ��Y�����擾���܂��B
   * @return ��Y��
   */
  public ACRadioButtonItem getCallNurseInsuranceRadioItem1(){
    if(callNurseInsuranceRadioItem1==null){

      callNurseInsuranceRadioItem1 = new ACRadioButtonItem();

      callNurseInsuranceRadioItem1.setText("��Y��");

      callNurseInsuranceRadioItem1.setGroup(getCallNurseInsuranceRadio());

      callNurseInsuranceRadioItem1.setConstraints(VRLayout.FLOW);

      addCallNurseInsuranceRadioItem1();
    }
    return callNurseInsuranceRadioItem1;

  }

  /**
   * �Y�����擾���܂��B
   * @return �Y��
   */
  public ACRadioButtonItem getCallNurseInsuranceRadioItem2(){
    if(callNurseInsuranceRadioItem2==null){

      callNurseInsuranceRadioItem2 = new ACRadioButtonItem();

      callNurseInsuranceRadioItem2.setText("�Y��");

      callNurseInsuranceRadioItem2.setGroup(getCallNurseInsuranceRadio());

      callNurseInsuranceRadioItem2.setConstraints(VRLayout.FLOW);

      addCallNurseInsuranceRadioItem2();
    }
    return callNurseInsuranceRadioItem2;

  }

  /**
   * �X�y�[�X1���擾���܂��B
   * @return �X�y�[�X1
   */
  public ACLabel getCallNurseOfficialSpace1(){
    if(callNurseOfficialSpace1==null){

      callNurseOfficialSpace1 = new ACLabel();

      callNurseOfficialSpace1.setText("�@�@�@�@�@�@�@");

      addCallNurseOfficialSpace1();
    }
    return callNurseOfficialSpace1;

  }

  /**
   * �E����̎��R���擾���܂��B
   * @return �E����̎��R
   */
  public ACClearableRadioButtonGroup getCallNurseOfficialRadio(){
    if(callNurseOfficialRadio==null){

      callNurseOfficialRadio = new ACClearableRadioButtonGroup();

      getCallNurseOfficialRadioContainer().setText("�E����̎��R");

      callNurseOfficialRadio.setBindPath("SHOKUMU_JIYU");

      callNurseOfficialRadio.setUseClearButton(true);

      callNurseOfficialRadio.setModel(getCallNurseOfficialRadioModel());

      addCallNurseOfficialRadio();
    }
    return callNurseOfficialRadio;

  }

  /**
   * �E����̎��R�R���e�i���擾���܂��B
   * @return �E����̎��R�R���e�i
   */
  protected ACLabelContainer getCallNurseOfficialRadioContainer(){
    if(callNurseOfficialRadioContainer==null){
      callNurseOfficialRadioContainer = new ACLabelContainer();
      callNurseOfficialRadioContainer.setFollowChildEnabled(true);
      callNurseOfficialRadioContainer.setVAlignment(VRLayout.CENTER);
      callNurseOfficialRadioContainer.add(getCallNurseOfficialRadio(), null);
    }
    return callNurseOfficialRadioContainer;
  }

  /**
   * �E����̎��R���f�����擾���܂��B
   * @return �E����̎��R���f��
   */
  protected ACListModelAdapter getCallNurseOfficialRadioModel(){
    if(callNurseOfficialRadioModel==null){
      callNurseOfficialRadioModel = new ACListModelAdapter();
      addCallNurseOfficialRadioModel();
    }
    return callNurseOfficialRadioModel;
  }

  /**
   * 1.�E������擾���܂��B
   * @return 1.�E����
   */
  public ACRadioButtonItem getCallNurseOfficialRadioItem1(){
    if(callNurseOfficialRadioItem1==null){

      callNurseOfficialRadioItem1 = new ACRadioButtonItem();

      callNurseOfficialRadioItem1.setText("1.�E����");

      callNurseOfficialRadioItem1.setGroup(getCallNurseOfficialRadio());

      callNurseOfficialRadioItem1.setConstraints(VRLayout.FLOW);

      addCallNurseOfficialRadioItem1();
    }
    return callNurseOfficialRadioItem1;

  }

  /**
   * 2.���D��3���ȓ����擾���܂��B
   * @return 2.���D��3���ȓ�
   */
  public ACRadioButtonItem getCallNurseOfficialRadioItem2(){
    if(callNurseOfficialRadioItem2==null){

      callNurseOfficialRadioItem2 = new ACRadioButtonItem();

      callNurseOfficialRadioItem2.setText("2.���D��3���ȓ�");

      callNurseOfficialRadioItem2.setGroup(getCallNurseOfficialRadio());

      callNurseOfficialRadioItem2.setConstraints(VRLayout.FLOW);

      addCallNurseOfficialRadioItem2();
    }
    return callNurseOfficialRadioItem2;

  }

  /**
   * 3.�ʋ΍ЊQ���擾���܂��B
   * @return 3.�ʋ΍ЊQ
   */
  public ACRadioButtonItem getCallNurseOfficialRadioItem3(){
    if(callNurseOfficialRadioItem3==null){

      callNurseOfficialRadioItem3 = new ACRadioButtonItem();

      callNurseOfficialRadioItem3.setText("3.�ʋ΍ЊQ");

      callNurseOfficialRadioItem3.setGroup(getCallNurseOfficialRadio());

      callNurseOfficialRadioItem3.setConstraints(VRLayout.FLOW);

      addCallNurseOfficialRadioItem3();
    }
    return callNurseOfficialRadioItem3;

  }

  /**
   * �X�y�[�X2���擾���܂��B
   * @return �X�y�[�X2
   */
  public ACLabel getCallNurseOfficialSpace2(){
    if(callNurseOfficialSpace2==null){

      callNurseOfficialSpace2 = new ACLabel();

      callNurseOfficialSpace2.setText("�@�@�@�@�@�@�@");

      addCallNurseOfficialSpace2();
    }
    return callNurseOfficialSpace2;

  }

  /**
   * ���n���Z�̗L�����擾���܂��B
   * @return ���n���Z�̗L��
   */
  public ACClearableRadioButtonGroup getCallNurseAddParticularRadio(){
    if(callNurseAddParticularRadio==null){

      callNurseAddParticularRadio = new ACClearableRadioButtonGroup();

      getCallNurseAddParticularRadioContainer().setText("���n���Z�̗L��");

      callNurseAddParticularRadio.setBindPath("SPECIAL_AREA_ADD");

      callNurseAddParticularRadio.setUseClearButton(false);

      callNurseAddParticularRadio.setModel(getCallNurseAddParticularRadioModel());

      addCallNurseAddParticularRadio();
    }
    return callNurseAddParticularRadio;

  }

  /**
   * ���n���Z�̗L���R���e�i���擾���܂��B
   * @return ���n���Z�̗L���R���e�i
   */
  protected ACLabelContainer getCallNurseAddParticularRadioContainer(){
    if(callNurseAddParticularRadioContainer==null){
      callNurseAddParticularRadioContainer = new ACLabelContainer();
      callNurseAddParticularRadioContainer.setFollowChildEnabled(true);
      callNurseAddParticularRadioContainer.setVAlignment(VRLayout.CENTER);
      callNurseAddParticularRadioContainer.add(getCallNurseAddParticularRadio(), null);
    }
    return callNurseAddParticularRadioContainer;
  }

  /**
   * ���n���Z�̗L�����f�����擾���܂��B
   * @return ���n���Z�̗L�����f��
   */
  protected ACListModelAdapter getCallNurseAddParticularRadioModel(){
    if(callNurseAddParticularRadioModel==null){
      callNurseAddParticularRadioModel = new ACListModelAdapter();
      addCallNurseAddParticularRadioModel();
    }
    return callNurseAddParticularRadioModel;
  }

  /**
   * �����擾���܂��B
   * @return ��
   */
  public ACRadioButtonItem getCallNurseAddParticularRadioItem1(){
    if(callNurseAddParticularRadioItem1==null){

      callNurseAddParticularRadioItem1 = new ACRadioButtonItem();

      callNurseAddParticularRadioItem1.setText("��");

      callNurseAddParticularRadioItem1.setGroup(getCallNurseAddParticularRadio());

      callNurseAddParticularRadioItem1.setConstraints(VRLayout.FLOW);

      addCallNurseAddParticularRadioItem1();
    }
    return callNurseAddParticularRadioItem1;

  }

  /**
   * �L���擾���܂��B
   * @return �L
   */
  public ACRadioButtonItem getCallNurseAddParticularRadioItem2(){
    if(callNurseAddParticularRadioItem2==null){

      callNurseAddParticularRadioItem2 = new ACRadioButtonItem();

      callNurseAddParticularRadioItem2.setText("�L");

      callNurseAddParticularRadioItem2.setGroup(getCallNurseAddParticularRadio());

      callNurseAddParticularRadioItem2.setConstraints(VRLayout.FLOW);

      addCallNurseAddParticularRadioItem2();
    }
    return callNurseAddParticularRadioItem2;

  }

  /**
   * �K��ɗv���鎞�Ԃ��擾���܂��B
   * @return �K��ɗv���鎞��
   */
  public ACTextField getCallNurseCallTime(){
    if(callNurseCallTime==null){

      callNurseCallTime = new ACTextField();

      getCallNurseCallTimeContainer().setText("�K��ɗv���鎞��");

      callNurseCallTime.setBindPath("HOMON_TIME");

      callNurseCallTime.setColumns(10);

      callNurseCallTime.setIMEMode(InputSubset.KANJI);

      callNurseCallTime.setMaxLength(32);

      addCallNurseCallTime();
    }
    return callNurseCallTime;

  }

  /**
   * �K��ɗv���鎞�ԃR���e�i���擾���܂��B
   * @return �K��ɗv���鎞�ԃR���e�i
   */
  protected ACLabelContainer getCallNurseCallTimeContainer(){
    if(callNurseCallTimeContainer==null){
      callNurseCallTimeContainer = new ACLabelContainer();
      callNurseCallTimeContainer.setFollowChildEnabled(true);
      callNurseCallTimeContainer.setVAlignment(VRLayout.CENTER);
      callNurseCallTimeContainer.add(getCallNurseCallTime(), null);
    }
    return callNurseCallTimeContainer;
  }

  /**
   * �w�������̈���擾���܂��B
   * @return �w�������̈�
   */
  public ACGroupBox getInstructInfos(){
    if(instructInfos==null){

      instructInfos = new ACGroupBox();

      instructInfos.setText("�w�������");

      instructInfos.setAutoWrap(false);

      addInstructInfos();
    }
    return instructInfos;

  }

  /**
   * �w�����L�����ԁE�R���e�i���擾���܂��B
   * @return �w�����L�����ԁE�R���e�i
   */
  public ACLabelContainer getInstructInfoValidLimitContena(){
    if(instructInfoValidLimitContena==null){

      instructInfoValidLimitContena = new ACLabelContainer();

      instructInfoValidLimitContena.setText("�w�����L������");

      addInstructInfoValidLimitContena();
    }
    return instructInfoValidLimitContena;

  }

  /**
   * �w���L�����ԁE�p�l��1���擾���܂��B
   * @return �w���L�����ԁE�p�l��1
   */
  public ACPanel getInstructInfoValidLimitPanel1(){
    if(instructInfoValidLimitPanel1==null){

      instructInfoValidLimitPanel1 = new ACPanel();

      instructInfoValidLimitPanel1.setAutoWrap(false);

      instructInfoValidLimitPanel1.setHgap(2);

      addInstructInfoValidLimitPanel1();
    }
    return instructInfoValidLimitPanel1;

  }

  /**
   * �w�����L�����ԁE�e�L�X�g1���擾���܂��B
   * @return �w�����L�����ԁE�e�L�X�g1
   */
  public QkanDateTextField getInstructInfoValidLimit1(){
    if(instructInfoValidLimit1==null){

      instructInfoValidLimit1 = new QkanDateTextField();

      instructInfoValidLimit1.setBindPath("SHIJISHO_VALID_START");

      instructInfoValidLimit1.setColumns(11);

      instructInfoValidLimit1.setFormat(new ACBorderBlankDateFormat("gggee�NMM��dd��"));

      instructInfoValidLimit1.setMaxLength(11);

      addInstructInfoValidLimit1();
    }
    return instructInfoValidLimit1;

  }

  /**
   * �w�����L�����ԁE���x�����擾���܂��B
   * @return �w�����L�����ԁE���x��
   */
  public ACLabel getInstructInfoValidLimitLabel(){
    if(instructInfoValidLimitLabel==null){

      instructInfoValidLimitLabel = new ACLabel();

      instructInfoValidLimitLabel.setText(" ���� ");

      addInstructInfoValidLimitLabel();
    }
    return instructInfoValidLimitLabel;

  }

  /**
   * �w�����L�����ԁE�e�L�X�g2���擾���܂��B
   * @return �w�����L�����ԁE�e�L�X�g2
   */
  public QkanDateTextField getInstructInfoValidLimit2(){
    if(instructInfoValidLimit2==null){

      instructInfoValidLimit2 = new QkanDateTextField();

      instructInfoValidLimit2.setBindPath("SHIJISHO_VALID_END");

      instructInfoValidLimit2.setColumns(11);

      instructInfoValidLimit2.setFormat(new ACBorderBlankDateFormat("gggee�NMM��dd��"));

      instructInfoValidLimit2.setMaxLength(11);

      addInstructInfoValidLimit2();
    }
    return instructInfoValidLimit2;

  }

  /**
   * ���ʎw�����E�R���e�i���擾���܂��B
   * @return ���ʎw�����E�R���e�i
   */
  public ACLabelContainer getSpecialInstructContena(){
    if(specialInstructContena==null){

      specialInstructContena = new ACLabelContainer();

      specialInstructContena.setText("���ʎw����");

      addSpecialInstructContena();
    }
    return specialInstructContena;

  }

  /**
   * ���ʎw�����E�p�l��1���擾���܂��B
   * @return ���ʎw�����E�p�l��1
   */
  public ACPanel getSpecialInstructPanel1(){
    if(specialInstructPanel1==null){

      specialInstructPanel1 = new ACPanel();

      specialInstructPanel1.setAutoWrap(false);

      specialInstructPanel1.setHgap(2);

      addSpecialInstructPanel1();
    }
    return specialInstructPanel1;

  }

  /**
   * ���ʎw�����E�e�L�X�g1���擾���܂��B
   * @return ���ʎw�����E�e�L�X�g1
   */
  public QkanDateTextField getSpecialInstruct1(){
    if(specialInstruct1==null){

      specialInstruct1 = new QkanDateTextField();

      specialInstruct1.setBindPath("SPECIAL_SHIJISHO_VALID_START");

      specialInstruct1.setColumns(11);

      specialInstruct1.setFormat(new ACBorderBlankDateFormat("gggee�NMM��dd��"));

      specialInstruct1.setMaxLength(11);

      addSpecialInstruct1();
    }
    return specialInstruct1;

  }

  /**
   * ���ʎw�����E���x�����擾���܂��B
   * @return ���ʎw�����E���x��
   */
  public ACLabel getSpecialInstructLabel1(){
    if(specialInstructLabel1==null){

      specialInstructLabel1 = new ACLabel();

      specialInstructLabel1.setText(" ���� ");

      addSpecialInstructLabel1();
    }
    return specialInstructLabel1;

  }

  /**
   * ���ʎw�����E�e�L�X�g2���擾���܂��B
   * @return ���ʎw�����E�e�L�X�g2
   */
  public QkanDateTextField getSpecialInstruct2(){
    if(specialInstruct2==null){

      specialInstruct2 = new QkanDateTextField();

      specialInstruct2.setBindPath("SPECIAL_SHIJISHO_VALID_END");

      specialInstruct2.setColumns(11);

      specialInstruct2.setFormat(new ACBorderBlankDateFormat("gggee�NMM��dd��"));

      specialInstruct2.setMaxLength(11);

      addSpecialInstruct2();
    }
    return specialInstruct2;

  }

  /**
   * ���ʎw�����E�p�l��2���擾���܂��B
   * @return ���ʎw�����E�p�l��2
   */
  public ACPanel getSpecialInstructPanel2(){
    if(specialInstructPanel2==null){

      specialInstructPanel2 = new ACPanel();

      specialInstructPanel2.setAutoWrap(false);

      specialInstructPanel2.setHgap(2);

      addSpecialInstructPanel2();
    }
    return specialInstructPanel2;

  }

  /**
   * �N���A���擾���܂��B
   * @return �N���A
   */
  public ACButton getSpecialInstructButton2(){
    if(specialInstructButton2==null){

      specialInstructButton2 = new ACButton();

      specialInstructButton2.setText("�N���A");

      specialInstructButton2.setToolTipText("���ʎw�������Ԃ��N���A���܂��B");

      addSpecialInstructButton2();
    }
    return specialInstructButton2;

  }

  /**
   * �R�����g�X�y�[�X1���擾���܂��B
   * @return �R�����g�X�y�[�X1
   */
  public ACLabel getSpecialInstructCommentSpace1(){
    if(specialInstructCommentSpace1==null){

      specialInstructCommentSpace1 = new ACLabel();

      specialInstructCommentSpace1.setText("�@�@�@�@�@");

      addSpecialInstructCommentSpace1();
    }
    return specialInstructCommentSpace1;

  }

  /**
   * �R�����g1���擾���܂��B
   * @return �R�����g1
   */
  public ACLabel getSpecialInstructComment1(){
    if(specialInstructComment1==null){

      specialInstructComment1 = new ACLabel();

      specialInstructComment1.setText("���ʎw�������Ԓ��ɍs���K��Ō�́A��Õی��̑ΏۂƂȂ�܂��B");

      addSpecialInstructComment1();
    }
    return specialInstructComment1;

  }

  /**
   * �R�����g�X�y�[�X2���擾���܂��B
   * @return �R�����g�X�y�[�X2
   */
  public ACLabel getSpecialInstructCommentSpace2(){
    if(specialInstructCommentSpace2==null){

      specialInstructCommentSpace2 = new ACLabel();

      specialInstructCommentSpace2.setText("�@�@�@�@�@");

      addSpecialInstructCommentSpace2();
    }
    return specialInstructCommentSpace2;

  }

  /**
   * �R�����g2���擾���܂��B
   * @return �R�����g2
   */
  public ACLabel getSpecialInstructComment2(){
    if(specialInstructComment2==null){

      specialInstructComment2 = new ACLabel();

      specialInstructComment2.setText("�T�[�r�X���͎��͖K��Ō�(��)��I��ł��������B");

      addSpecialInstructComment2();
    }
    return specialInstructComment2;

  }

  /**
   * ��Ë@�֏����擾���܂��B
   * @return ��Ë@�֏��
   */
  public ACGroupBox getMedicalTreatmentInfos(){
    if(medicalTreatmentInfos==null){

      medicalTreatmentInfos = new ACGroupBox();

      medicalTreatmentInfos.setText("��Ë@�֏��");

      addMedicalTreatmentInfos();
    }
    return medicalTreatmentInfos;

  }

  /**
   * ��Ë@�֊�{���p�l�����擾���܂��B
   * @return ��Ë@�֊�{���p�l��
   */
  public ACPanel getMedicalTreatmentBasicInfos(){
    if(medicalTreatmentBasicInfos==null){

      medicalTreatmentBasicInfos = new ACPanel();

      medicalTreatmentBasicInfos.setHgrid(150);

      addMedicalTreatmentBasicInfos();
    }
    return medicalTreatmentBasicInfos;

  }

  /**
   * �厡��̑������Ë@�ւ̖��̂��擾���܂��B
   * @return �厡��̑������Ë@�ւ̖���
   */
  public ACComboBox getMedicalTreatmentInfoOrgan(){
    if(medicalTreatmentInfoOrgan==null){

      medicalTreatmentInfoOrgan = new ACComboBox();

      getMedicalTreatmentInfoOrganContainer().setText("�厡��̑������Ë@�ւ̖���");

      medicalTreatmentInfoOrgan.setBindPath("MEDICAL_FACILITY_ID");

      medicalTreatmentInfoOrgan.setEditable(false);

      medicalTreatmentInfoOrgan.setColumns(15);

      medicalTreatmentInfoOrgan.setModelBindPath("MEDICAL_FACILITY");

      medicalTreatmentInfoOrgan.setRenderBindPath("MEDICAL_FACILITY_NAME");

      medicalTreatmentInfoOrgan.setBlankable(true);

      medicalTreatmentInfoOrgan.setMaxColumns(43);

      medicalTreatmentInfoOrgan.setModel(getMedicalTreatmentInfoOrganModel());

      addMedicalTreatmentInfoOrgan();
    }
    return medicalTreatmentInfoOrgan;

  }

  /**
   * �厡��̑������Ë@�ւ̖��̃R���e�i���擾���܂��B
   * @return �厡��̑������Ë@�ւ̖��̃R���e�i
   */
  protected ACLabelContainer getMedicalTreatmentInfoOrganContainer(){
    if(medicalTreatmentInfoOrganContainer==null){
      medicalTreatmentInfoOrganContainer = new ACLabelContainer();
      medicalTreatmentInfoOrganContainer.setFollowChildEnabled(true);
      medicalTreatmentInfoOrganContainer.setVAlignment(VRLayout.CENTER);
      medicalTreatmentInfoOrganContainer.add(getMedicalTreatmentInfoOrgan(), null);
    }
    return medicalTreatmentInfoOrganContainer;
  }

  /**
   * �厡��̑������Ë@�ւ̖��̃��f�����擾���܂��B
   * @return �厡��̑������Ë@�ւ̖��̃��f��
   */
  protected ACComboBoxModelAdapter getMedicalTreatmentInfoOrganModel(){
    if(medicalTreatmentInfoOrganModel==null){
      medicalTreatmentInfoOrganModel = new ACComboBoxModelAdapter();
      addMedicalTreatmentInfoOrganModel();
    }
    return medicalTreatmentInfoOrganModel;
  }

  /**
   * ��Ë@�ւ̗X�֔ԍ����擾���܂��B
   * @return ��Ë@�ւ̗X�֔ԍ�
   */
  public ACTextField getMedicalTreatmentInfoZip(){
    if(medicalTreatmentInfoZip==null){

      medicalTreatmentInfoZip = new ACTextField();

      getMedicalTreatmentInfoZipContainer().setText("�X�֔ԍ�");

      medicalTreatmentInfoZip.setBindPath("MEDICAL_FACILITY_ZIP");

      medicalTreatmentInfoZip.setEditable(false);

      medicalTreatmentInfoZip.setColumns(8);

      addMedicalTreatmentInfoZip();
    }
    return medicalTreatmentInfoZip;

  }

  /**
   * ��Ë@�ւ̗X�֔ԍ��R���e�i���擾���܂��B
   * @return ��Ë@�ւ̗X�֔ԍ��R���e�i
   */
  protected ACLabelContainer getMedicalTreatmentInfoZipContainer(){
    if(medicalTreatmentInfoZipContainer==null){
      medicalTreatmentInfoZipContainer = new ACLabelContainer();
      medicalTreatmentInfoZipContainer.setFollowChildEnabled(true);
      medicalTreatmentInfoZipContainer.setVAlignment(VRLayout.CENTER);
      medicalTreatmentInfoZipContainer.add(getMedicalTreatmentInfoZip(), null);
    }
    return medicalTreatmentInfoZipContainer;
  }

  /**
   * ��Ë@�ւ̏Z�����擾���܂��B
   * @return ��Ë@�ւ̏Z��
   */
  public ACTextField getMedicalTreatmentInfoAddress(){
    if(medicalTreatmentInfoAddress==null){

      medicalTreatmentInfoAddress = new ACTextField();

      getMedicalTreatmentInfoAddressContainer().setText("�Z��");

      medicalTreatmentInfoAddress.setBindPath("MEDICAL_FACILITY_ADDRESS");

      medicalTreatmentInfoAddress.setEditable(false);

      medicalTreatmentInfoAddress.setColumns(43);

      addMedicalTreatmentInfoAddress();
    }
    return medicalTreatmentInfoAddress;

  }

  /**
   * ��Ë@�ւ̏Z���R���e�i���擾���܂��B
   * @return ��Ë@�ւ̏Z���R���e�i
   */
  protected ACLabelContainer getMedicalTreatmentInfoAddressContainer(){
    if(medicalTreatmentInfoAddressContainer==null){
      medicalTreatmentInfoAddressContainer = new ACLabelContainer();
      medicalTreatmentInfoAddressContainer.setFollowChildEnabled(true);
      medicalTreatmentInfoAddressContainer.setVAlignment(VRLayout.CENTER);
      medicalTreatmentInfoAddressContainer.add(getMedicalTreatmentInfoAddress(), null);
    }
    return medicalTreatmentInfoAddressContainer;
  }

  /**
   * ��Ë@�ւ̓d�b�ԍ����擾���܂��B
   * @return ��Ë@�ւ̓d�b�ԍ�
   */
  public ACTextField getMedicalTreatmentInfoTel(){
    if(medicalTreatmentInfoTel==null){

      medicalTreatmentInfoTel = new ACTextField();

      getMedicalTreatmentInfoTelContainer().setText("�d�b�ԍ�");

      medicalTreatmentInfoTel.setBindPath("MEDICAL_FACILITY_TEL");

      medicalTreatmentInfoTel.setEditable(false);

      medicalTreatmentInfoTel.setColumns(15);

      addMedicalTreatmentInfoTel();
    }
    return medicalTreatmentInfoTel;

  }

  /**
   * ��Ë@�ւ̓d�b�ԍ��R���e�i���擾���܂��B
   * @return ��Ë@�ւ̓d�b�ԍ��R���e�i
   */
  protected ACLabelContainer getMedicalTreatmentInfoTelContainer(){
    if(medicalTreatmentInfoTelContainer==null){
      medicalTreatmentInfoTelContainer = new ACLabelContainer();
      medicalTreatmentInfoTelContainer.setFollowChildEnabled(true);
      medicalTreatmentInfoTelContainer.setVAlignment(VRLayout.CENTER);
      medicalTreatmentInfoTelContainer.add(getMedicalTreatmentInfoTel(), null);
    }
    return medicalTreatmentInfoTelContainer;
  }

  /**
   * ��Ë@�ւ�FAX�ԍ����擾���܂��B
   * @return ��Ë@�ւ�FAX�ԍ�
   */
  public ACTextField getMedicalTreatmentInfoFax(){
    if(medicalTreatmentInfoFax==null){

      medicalTreatmentInfoFax = new ACTextField();

      getMedicalTreatmentInfoFaxContainer().setText("FAX�ԍ�");

      medicalTreatmentInfoFax.setBindPath("MEDICAL_FACILITY_FAX");

      medicalTreatmentInfoFax.setEditable(false);

      medicalTreatmentInfoFax.setColumns(15);

      addMedicalTreatmentInfoFax();
    }
    return medicalTreatmentInfoFax;

  }

  /**
   * ��Ë@�ւ�FAX�ԍ��R���e�i���擾���܂��B
   * @return ��Ë@�ւ�FAX�ԍ��R���e�i
   */
  protected ACLabelContainer getMedicalTreatmentInfoFaxContainer(){
    if(medicalTreatmentInfoFaxContainer==null){
      medicalTreatmentInfoFaxContainer = new ACLabelContainer();
      medicalTreatmentInfoFaxContainer.setFollowChildEnabled(true);
      medicalTreatmentInfoFaxContainer.setVAlignment(VRLayout.CENTER);
      medicalTreatmentInfoFaxContainer.add(getMedicalTreatmentInfoFax(), null);
    }
    return medicalTreatmentInfoFaxContainer;
  }

  /**
   * �厡��̎������擾���܂��B
   * @return �厡��̎���
   */
  public ACTextField getMedicalTreatmentInfoMainDoctorName(){
    if(medicalTreatmentInfoMainDoctorName==null){

      medicalTreatmentInfoMainDoctorName = new ACTextField();

      getMedicalTreatmentInfoMainDoctorNameContainer().setText("�厡��̎���");

      medicalTreatmentInfoMainDoctorName.setBindPath("DOCTOR_NAME");

      medicalTreatmentInfoMainDoctorName.setColumns(10);

      medicalTreatmentInfoMainDoctorName.setIMEMode(InputSubset.KANJI);

      medicalTreatmentInfoMainDoctorName.setMaxLength(32);

      addMedicalTreatmentInfoMainDoctorName();
    }
    return medicalTreatmentInfoMainDoctorName;

  }

  /**
   * �厡��̎����R���e�i���擾���܂��B
   * @return �厡��̎����R���e�i
   */
  protected ACLabelContainer getMedicalTreatmentInfoMainDoctorNameContainer(){
    if(medicalTreatmentInfoMainDoctorNameContainer==null){
      medicalTreatmentInfoMainDoctorNameContainer = new ACLabelContainer();
      medicalTreatmentInfoMainDoctorNameContainer.setFollowChildEnabled(true);
      medicalTreatmentInfoMainDoctorNameContainer.setVAlignment(VRLayout.CENTER);
      medicalTreatmentInfoMainDoctorNameContainer.add(getMedicalTreatmentInfoMainDoctorName(), null);
    }
    return medicalTreatmentInfoMainDoctorNameContainer;
  }

  /**
   * �R���X�g���N�^�ł��B
   */
  public QU003Design() {

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
   * �Ɩ��{�^���o�[�ɓ������ڂ�ǉ����܂��B
   */
  protected void addButtons(){

    buttons.add(getUpdate(), VRLayout.EAST);
    buttons.add(getInsert(), VRLayout.EAST);
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
   * �N���C�A���g�̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addContents(){

    contents.add(getPatientInfo(), VRLayout.NORTH);

    contents.add(getTabs(), VRLayout.CLIENT);

  }

  /**
   * ���p�Җ��̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatientInfo(){

    patientInfo.add(getPatientNameCaption(), VRLayout.FLOW);

    patientInfo.add(getPatientName(), VRLayout.FLOW);

  }

  /**
   * ���p�Җ��L���v�V�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatientNameCaption(){

  }

  /**
   * ���p�Җ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatientName(){

  }

  /**
   * �^�u�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTabs(){

    tabs.addTab("��Õی�", getPoint1());

    tabs.addTab("�K��Ō�×{��׏����o�^", getPoint2());

  }

  /**
   * ��Õی��̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPoint1(){

    point1.add(getMedicalInfos(), VRLayout.NORTH);

    point1.add(getMedicalInfoButtons(), VRLayout.NORTH);

    point1.add(getMedicalInfoTable(), VRLayout.CLIENT);

  }

  /**
   * ��Õی��̈�E���ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalInfos(){

    medicalInfos.add(getMedicalInfoInsuranceVarietyRadio1Container(), VRLayout.FLOW_INSETLINE_RETURN);

    medicalInfos.add(getMedicalInfoInsuranceVarietyRadio2Container(), VRLayout.FLOW_INSETLINE_RETURN);

    medicalInfos.add(getMedicalInfoPersonAndFamilyRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    medicalInfos.add(getMedicalInfoOld9AndOld8RadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    medicalInfos.add(getMedicalInfoInsurerNoContena(), VRLayout.FLOW_INSETLINE);

    medicalInfos.add(getMedicalInfoInsurerNameContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    medicalInfos.add(getMedicalInfoMarkContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    medicalInfos.add(getMedicalInfoValidLimitContena(), VRLayout.FLOW_INSETLINE);

    medicalInfos.add(getMedicalInfoProvideContena(), VRLayout.FLOW_INSETLINE_RETURN);

    medicalInfos.add(getMedicalInfoCitiesNoContena(), VRLayout.FLOW_INSETLINE);

    medicalInfos.add(getMedicalInfoCitiesNameContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    medicalInfos.add(getMedicalInfoOldPersonReceiptNoContainer(), VRLayout.FLOW_INSETLINE);

  }

  /**
   * �ی���ށE��ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalInfoInsuranceVarietyRadio1(){

  }

  /**
   * �ی���ށE�ヂ�f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalInfoInsuranceVarietyRadio1Model(){

    getMedicalInfoInsuranceVarietyRadio1Item1().setButtonIndex(1);

    getMedicalInfoInsuranceVarietyRadio1Model().add(getMedicalInfoInsuranceVarietyRadio1Item1());

    getMedicalInfoInsuranceVarietyRadio1Item2().setButtonIndex(2);

    getMedicalInfoInsuranceVarietyRadio1Model().add(getMedicalInfoInsuranceVarietyRadio1Item2());

    getMedicalInfoInsuranceVarietyRadio1Item3().setButtonIndex(3);

    getMedicalInfoInsuranceVarietyRadio1Model().add(getMedicalInfoInsuranceVarietyRadio1Item3());

  }

  /**
   * �Еۂɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalInfoInsuranceVarietyRadio1Item1(){

  }

  /**
   * ���ۂɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalInfoInsuranceVarietyRadio1Item2(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalInfoInsuranceVarietyRadio1Item3(){

  }

  /**
   * �ی���ށE���ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalInfoInsuranceVarietyRadio2(){

  }

  /**
   * �ی���ށE�����f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalInfoInsuranceVarietyRadio2Model(){

    getMedicalInfoInsuranceVarietyRadio2Item1().setButtonIndex(1);

    getMedicalInfoInsuranceVarietyRadio2Model().add(getMedicalInfoInsuranceVarietyRadio2Item1());

    getMedicalInfoInsuranceVarietyRadio2Item2().setButtonIndex(2);

    getMedicalInfoInsuranceVarietyRadio2Model().add(getMedicalInfoInsuranceVarietyRadio2Item2());

  }

  /**
   * �V�l�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalInfoInsuranceVarietyRadio2Item1(){

  }

  /**
   * �ސE�҂ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalInfoInsuranceVarietyRadio2Item2(){

  }

  /**
   * �{�l/�Ƒ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalInfoPersonAndFamilyRadio(){

  }

  /**
   * �{�l/�Ƒ����f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalInfoPersonAndFamilyRadioModel(){

    getMedicalInfoPersonAndFamilyRadioItem1().setButtonIndex(1);

    getMedicalInfoPersonAndFamilyRadioModel().add(getMedicalInfoPersonAndFamilyRadioItem1());

    getMedicalInfoPersonAndFamilyRadioItem2().setButtonIndex(2);

    getMedicalInfoPersonAndFamilyRadioModel().add(getMedicalInfoPersonAndFamilyRadioItem2());

    getMedicalInfoPersonAndFamilyRadioItem3().setButtonIndex(3);

    getMedicalInfoPersonAndFamilyRadioModel().add(getMedicalInfoPersonAndFamilyRadioItem3());

  }

  /**
   * �{�l�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalInfoPersonAndFamilyRadioItem1(){

  }

  /**
   * 3�΂ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalInfoPersonAndFamilyRadioItem2(){

  }

  /**
   * �Ƒ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalInfoPersonAndFamilyRadioItem3(){

  }

  /**
   * ������ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalInfoOld9AndOld8Radio(){

  }

  /**
   * ��������f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalInfoOld9AndOld8RadioModel(){

    getMedicalInfoOld9AndOld8RadioItem1().setButtonIndex(1);

    getMedicalInfoOld9AndOld8RadioModel().add(getMedicalInfoOld9AndOld8RadioItem1());

    getMedicalInfoOld9AndOld8RadioItem2().setButtonIndex(2);

    getMedicalInfoOld9AndOld8RadioModel().add(getMedicalInfoOld9AndOld8RadioItem2());

    getMedicalInfoOld9AndOld8RadioItem3().setButtonIndex(3);

    getMedicalInfoOld9AndOld8RadioModel().add(getMedicalInfoOld9AndOld8RadioItem3());

  }

  /**
   * ����9�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalInfoOld9AndOld8RadioItem1(){

  }

  /**
   * ����8�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalInfoOld9AndOld8RadioItem2(){

  }

  /**
   * ����7�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalInfoOld9AndOld8RadioItem3(){

  }

  /**
   * (�ی��Ҕԍ��E�R���e�i)�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalInfoInsurerNoContena(){

    medicalInfoInsurerNoContena.add(getMedicalInfoInsurerLawNo(), VRLayout.FLOW);

    medicalInfoInsurerNoContena.add(getMedicalInfoInsurerNo(), VRLayout.FLOW);

  }

  /**
   * (��Õی��Ҕԍ�)�@�ʔԍ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalInfoInsurerLawNo(){

  }

  /**
   * (��Õی��Ҕԍ�)�ی��Ҕԍ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalInfoInsurerNo(){

  }

  /**
   * �ی��Җ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalInfoInsurerName(){

  }

  /**
   * �ی��Җ����f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalInfoInsurerNameModel(){

  }

  /**
   * �L���E�ԍ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalInfoMark(){

  }

  /**
   * �L�����ԁE�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalInfoValidLimitContena(){

    medicalInfoValidLimitContena.add(getMedicalInfoValidLimit1(), VRLayout.FLOW);

    medicalInfoValidLimitContena.add(getMedicalInfoValidLimitLabel(), VRLayout.FLOW);

    medicalInfoValidLimitContena.add(getMedicalInfoValidLimit2(), VRLayout.FLOW);

  }

  /**
   * �L�����ԁE�e�L�X�g1�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalInfoValidLimit1(){

  }

  /**
   * �L�����ԁE���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalInfoValidLimitLabel(){

  }

  /**
   * �L�����ԁE�e�L�X�g2�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalInfoValidLimit2(){

  }

  /**
   * ���t�����E�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalInfoProvideContena(){

    medicalInfoProvideContena.add(getMedicalInfoProvideLabel1(), VRLayout.FLOW);

    medicalInfoProvideContena.add(getMedicalInfoProvide(), VRLayout.FLOW);

    medicalInfoProvideContena.add(getMedicalInfoProvideLabel2(), VRLayout.FLOW);

  }

  /**
   * ���t�����E���x��1�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalInfoProvideLabel1(){

  }

  /**
   * ���t�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalInfoProvide(){

  }

  /**
   * ���t�������f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalInfoProvideModel(){

  }

  /**
   * ���t�����E���x��2�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalInfoProvideLabel2(){

  }

  /**
   * (�s�����ԍ��E�R���e�i)�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalInfoCitiesNoContena(){

    medicalInfoCitiesNoContena.add(getMedicalInfoCitiesLawNo(), VRLayout.FLOW);

    medicalInfoCitiesNoContena.add(getMedicalInfoCitiesNo(), VRLayout.FLOW);

  }

  /**
   * (�s�����ԍ�)�@�ʔԍ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalInfoCitiesLawNo(){

  }

  /**
   * (�s�����ԍ�)�ی��Ҕԍ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalInfoCitiesNo(){

  }

  /**
   * �s�������ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalInfoCitiesName(){

  }

  /**
   * �s���������f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalInfoCitiesNameModel(){

  }

  /**
   * �V�l�󋋎Ҕԍ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalInfoOldPersonReceiptNo(){

  }

  /**
   * �{�^���̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalInfoButtons(){

    medicalInfoButtons.add(getMedicalInfoButtonDelete(), VRLayout.EAST);
    medicalInfoButtons.add(getMedicalInfoButtonConpile(), VRLayout.EAST);
    medicalInfoButtons.add(getMedicalInfoButtonInsert(), VRLayout.EAST);
    medicalInfoButtons.add(getMedicalInfoButtonClear(), VRLayout.EAST);
  }

  /**
   * �N���A�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalInfoButtonClear(){

  }

  /**
   * �ǉ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalInfoButtonInsert(){

  }

  /**
   * ���ւɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalInfoButtonConpile(){

  }

  /**
   * �폜�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalInfoButtonDelete(){

  }

  /**
   * ��Õی��̈�E�e�[�u���ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalInfoTable(){

  }

  /**
   * ��Õی��̈�E�e�[�u���J�������f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalInfoTableColumnModel(){

    getMedicalInfoTableColumnModel().addColumn(getMedicalInfoTableColumn0());

    getMedicalInfoTableColumnModel().addColumn(getMedicalInfoTableColumn1());

    getMedicalInfoTableColumnModel().addColumn(getMedicalInfoTableColumn2());

    getMedicalInfoTableColumnModel().addColumn(getMedicalInfoTableColumn3());

    getMedicalInfoTableColumnModel().addColumn(getMedicalInfoTableColumn4());

    getMedicalInfoTableColumnModel().addColumn(getMedicalInfoTableColumn5());

    getMedicalInfoTableColumnModel().addColumn(getMedicalInfoTableColumn6());

    getMedicalInfoTableColumnModel().addColumn(getMedicalInfoTableColumn7());

    getMedicalInfoTableColumnModel().addColumn(getMedicalInfoTableColumn8());

    getMedicalInfoTableColumnModel().addColumn(getMedicalInfoTableColumn9());

    getMedicalInfoTableColumnModel().addColumn(getMedicalInfoTableColumn10());

    getMedicalInfoTableColumnModel().addColumn(getMedicalInfoTableColumn11());

  }

  /**
   * No�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalInfoTableColumn0(){

  }

  /**
   * �ی���ރJ�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalInfoTableColumn1(){

  }

  /**
   * �{�l/�Ƒ��J�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalInfoTableColumn2(){

  }

  /**
   * �ی��Ҕԍ��J�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalInfoTableColumn3(){

  }

  /**
   * �ی��Җ��J�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalInfoTableColumn4(){

  }

  /**
   * �L���E�ԍ��J�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalInfoTableColumn5(){

  }

  /**
   * �L�����ԊJ�n�J�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalInfoTableColumn6(){

  }

  /**
   * �L�����ԏI���J�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalInfoTableColumn7(){

  }

  /**
   * ���t�����J�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalInfoTableColumn8(){

  }

  /**
   * �s�����ԍ��J�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalInfoTableColumn9(){

  }

  /**
   * �s�������J�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalInfoTableColumn10(){

  }

  /**
   * �V�l�󋋎Ҕԍ��J�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalInfoTableColumn11(){

  }

  /**
   * �K��Ō�×{��׏����o�^�̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPoint2(){

    point2.add(getCallNursePatients(), VRLayout.NORTH);

    point2.add(getInstructInfos(), VRLayout.NORTH);

    point2.add(getMedicalTreatmentInfos(), VRLayout.NORTH);

  }

  /**
   * ���p�҂̏󋵗̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addCallNursePatients(){

    callNursePatients.add(getCallNurseMindStateContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    callNursePatients.add(getCallNurseMainDiseaseNameContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    callNursePatients.add(getCallNurseInsuranceRadioContainer(), VRLayout.FLOW_RETURN);

    callNursePatients.add(getCallNurseOfficialSpace1(), VRLayout.FLOW);

    callNursePatients.add(getCallNurseOfficialRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    callNursePatients.add(getCallNurseOfficialSpace2(), VRLayout.FLOW_INSETLINE);

    callNursePatients.add(getCallNurseAddParticularRadioContainer(), VRLayout.FLOW_INSETLINE);

    callNursePatients.add(getCallNurseCallTimeContainer(), VRLayout.FLOW_INSETLINE);

  }

  /**
   * �S�g�̏�Ԃɓ������ڂ�ǉ����܂��B
   */
  protected void addCallNurseMindState(){

  }

  /**
   * �傽�鏝�a���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCallNurseMainDiseaseName(){

  }

  /**
   * ������b�̒�߂鎾�a�ɓ������ڂ�ǉ����܂��B
   */
  protected void addCallNurseInsuranceRadio(){

  }

  /**
   * ������b�̒�߂鎾�a���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCallNurseInsuranceRadioModel(){

    getCallNurseInsuranceRadioItem1().setButtonIndex(1);

    getCallNurseInsuranceRadioModel().add(getCallNurseInsuranceRadioItem1());

    getCallNurseInsuranceRadioItem2().setButtonIndex(2);

    getCallNurseInsuranceRadioModel().add(getCallNurseInsuranceRadioItem2());

  }

  /**
   * ��Y���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCallNurseInsuranceRadioItem1(){

  }

  /**
   * �Y���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCallNurseInsuranceRadioItem2(){

  }

  /**
   * �X�y�[�X1�ɓ������ڂ�ǉ����܂��B
   */
  protected void addCallNurseOfficialSpace1(){

  }

  /**
   * �E����̎��R�ɓ������ڂ�ǉ����܂��B
   */
  protected void addCallNurseOfficialRadio(){

  }

  /**
   * �E����̎��R���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCallNurseOfficialRadioModel(){

    getCallNurseOfficialRadioItem1().setButtonIndex(1);

    getCallNurseOfficialRadioModel().add(getCallNurseOfficialRadioItem1());

    getCallNurseOfficialRadioItem2().setButtonIndex(2);

    getCallNurseOfficialRadioModel().add(getCallNurseOfficialRadioItem2());

    getCallNurseOfficialRadioItem3().setButtonIndex(3);

    getCallNurseOfficialRadioModel().add(getCallNurseOfficialRadioItem3());

  }

  /**
   * 1.�E����ɓ������ڂ�ǉ����܂��B
   */
  protected void addCallNurseOfficialRadioItem1(){

  }

  /**
   * 2.���D��3���ȓ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addCallNurseOfficialRadioItem2(){

  }

  /**
   * 3.�ʋ΍ЊQ�ɓ������ڂ�ǉ����܂��B
   */
  protected void addCallNurseOfficialRadioItem3(){

  }

  /**
   * �X�y�[�X2�ɓ������ڂ�ǉ����܂��B
   */
  protected void addCallNurseOfficialSpace2(){

  }

  /**
   * ���n���Z�̗L���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCallNurseAddParticularRadio(){

  }

  /**
   * ���n���Z�̗L�����f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCallNurseAddParticularRadioModel(){

    getCallNurseAddParticularRadioItem1().setButtonIndex(1);

    getCallNurseAddParticularRadioModel().add(getCallNurseAddParticularRadioItem1());

    getCallNurseAddParticularRadioItem2().setButtonIndex(2);

    getCallNurseAddParticularRadioModel().add(getCallNurseAddParticularRadioItem2());

  }

  /**
   * ���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCallNurseAddParticularRadioItem1(){

  }

  /**
   * �L�ɓ������ڂ�ǉ����܂��B
   */
  protected void addCallNurseAddParticularRadioItem2(){

  }

  /**
   * �K��ɗv���鎞�Ԃɓ������ڂ�ǉ����܂��B
   */
  protected void addCallNurseCallTime(){

  }

  /**
   * �w�������̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addInstructInfos(){

    instructInfos.add(getInstructInfoValidLimitContena(), VRLayout.FLOW_INSETLINE_RETURN);

    instructInfos.add(getSpecialInstructContena(), VRLayout.FLOW_INSETLINE_RETURN);

    instructInfos.add(getSpecialInstructCommentSpace1(), VRLayout.FLOW_INSETLINE);

    instructInfos.add(getSpecialInstructComment1(), VRLayout.FLOW_INSETLINE_RETURN);

    instructInfos.add(getSpecialInstructCommentSpace2(), VRLayout.FLOW_INSETLINE);

    instructInfos.add(getSpecialInstructComment2(), VRLayout.FLOW_INSETLINE);

  }

  /**
   * �w�����L�����ԁE�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addInstructInfoValidLimitContena(){

    instructInfoValidLimitContena.add(getInstructInfoValidLimitPanel1(), VRLayout.FLOW);

  }

  /**
   * �w���L�����ԁE�p�l��1�ɓ������ڂ�ǉ����܂��B
   */
  protected void addInstructInfoValidLimitPanel1(){

    instructInfoValidLimitPanel1.add(getInstructInfoValidLimit1(), VRLayout.FLOW);

    instructInfoValidLimitPanel1.add(getInstructInfoValidLimitLabel(), VRLayout.FLOW);

    instructInfoValidLimitPanel1.add(getInstructInfoValidLimit2(), VRLayout.FLOW);

  }

  /**
   * �w�����L�����ԁE�e�L�X�g1�ɓ������ڂ�ǉ����܂��B
   */
  protected void addInstructInfoValidLimit1(){

  }

  /**
   * �w�����L�����ԁE���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addInstructInfoValidLimitLabel(){

  }

  /**
   * �w�����L�����ԁE�e�L�X�g2�ɓ������ڂ�ǉ����܂��B
   */
  protected void addInstructInfoValidLimit2(){

  }

  /**
   * ���ʎw�����E�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addSpecialInstructContena(){

    specialInstructContena.add(getSpecialInstructPanel1(), VRLayout.FLOW);

    specialInstructContena.add(getSpecialInstructPanel2(), VRLayout.FLOW);

  }

  /**
   * ���ʎw�����E�p�l��1�ɓ������ڂ�ǉ����܂��B
   */
  protected void addSpecialInstructPanel1(){

    specialInstructPanel1.add(getSpecialInstruct1(), VRLayout.FLOW);

    specialInstructPanel1.add(getSpecialInstructLabel1(), VRLayout.FLOW);

    specialInstructPanel1.add(getSpecialInstruct2(), VRLayout.FLOW);

  }

  /**
   * ���ʎw�����E�e�L�X�g1�ɓ������ڂ�ǉ����܂��B
   */
  protected void addSpecialInstruct1(){

  }

  /**
   * ���ʎw�����E���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addSpecialInstructLabel1(){

  }

  /**
   * ���ʎw�����E�e�L�X�g2�ɓ������ڂ�ǉ����܂��B
   */
  protected void addSpecialInstruct2(){

  }

  /**
   * ���ʎw�����E�p�l��2�ɓ������ڂ�ǉ����܂��B
   */
  protected void addSpecialInstructPanel2(){

    specialInstructPanel2.add(getSpecialInstructButton2(), VRLayout.FLOW);

  }

  /**
   * �N���A�ɓ������ڂ�ǉ����܂��B
   */
  protected void addSpecialInstructButton2(){

  }

  /**
   * �R�����g�X�y�[�X1�ɓ������ڂ�ǉ����܂��B
   */
  protected void addSpecialInstructCommentSpace1(){

  }

  /**
   * �R�����g1�ɓ������ڂ�ǉ����܂��B
   */
  protected void addSpecialInstructComment1(){

  }

  /**
   * �R�����g�X�y�[�X2�ɓ������ڂ�ǉ����܂��B
   */
  protected void addSpecialInstructCommentSpace2(){

  }

  /**
   * �R�����g2�ɓ������ڂ�ǉ����܂��B
   */
  protected void addSpecialInstructComment2(){

  }

  /**
   * ��Ë@�֏��ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalTreatmentInfos(){

    medicalTreatmentInfos.add(getMedicalTreatmentBasicInfos(), VRLayout.NORTH);

  }

  /**
   * ��Ë@�֊�{���p�l���ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalTreatmentBasicInfos(){

    medicalTreatmentBasicInfos.add(getMedicalTreatmentInfoOrganContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    medicalTreatmentBasicInfos.add(getMedicalTreatmentInfoZipContainer(), VRLayout.FLOW_INSETLINE);

    medicalTreatmentBasicInfos.add(getMedicalTreatmentInfoAddressContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    medicalTreatmentBasicInfos.add(getMedicalTreatmentInfoTelContainer(), VRLayout.FLOW_INSETLINE);

    medicalTreatmentBasicInfos.add(getMedicalTreatmentInfoFaxContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    medicalTreatmentBasicInfos.add(getMedicalTreatmentInfoMainDoctorNameContainer(), VRLayout.FLOW_INSETLINE);

  }

  /**
   * �厡��̑������Ë@�ւ̖��̂ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalTreatmentInfoOrgan(){

  }

  /**
   * �厡��̑������Ë@�ւ̖��̃��f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalTreatmentInfoOrganModel(){

  }

  /**
   * ��Ë@�ւ̗X�֔ԍ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalTreatmentInfoZip(){

  }

  /**
   * ��Ë@�ւ̏Z���ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalTreatmentInfoAddress(){

  }

  /**
   * ��Ë@�ւ̓d�b�ԍ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalTreatmentInfoTel(){

  }

  /**
   * ��Ë@�ւ�FAX�ԍ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalTreatmentInfoFax(){

  }

  /**
   * �厡��̎����ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalTreatmentInfoMainDoctorName(){

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
      ACFrame.debugStart(new ACAffairInfo(QU003Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QU003Design getThis() {
    return this;
  }
}
