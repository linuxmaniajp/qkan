
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
 * �쐬��: 2016/01/27  ���{�R���s���[�^�[������� ����@��F �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �T�[�r�X�\��쐬/�ύX (S)
 * �v���Z�X �T�[�r�X�\��T�� (001)
 * �v���O���� �T�[�r�X�p�^�[������{�ݓ����Ґ������ (QS001_13311_201504)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
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
 * �T�[�r�X�p�^�[������{�ݓ����Ґ�������ʍ��ڃf�U�C��(QS001_13311_201504) 
 */
public class QS001_13311_201504Design extends QS001ServicePanel {
  //GUI�R���|�[�l���g

  private JTabbedPane tabs;

  private ACPanel tabPanel1;

  private ACValueArrayRadioButtonGroup facilitiesDivisionRadio;

  private ACLabelContainer facilitiesDivisionRadioContainer;

  private ACListModelAdapter facilitiesDivisionRadioModel;

  private ACRadioButtonItem facilitiesDivisionRadioItem1;

  private ACRadioButtonItem facilitiesDivisionRadioItem2;

  private ACValueArrayRadioButtonGroup specificFacilitySubtractionRadio;

  private ACLabelContainer specificFacilitySubtractionRadioContainer;

  private ACListModelAdapter specificFacilitySubtractionRadioModel;

  private ACRadioButtonItem specificFacilitySubtractionNot;

  private ACRadioButtonItem specificFacilitySubtractionPersonLack;

  private ACValueArrayRadioButtonGroup specificFacilityFunctionTrainingRadio;

  private ACLabelContainer specificFacilityFunctionTrainingRadioContainer;

  private ACListModelAdapter specificFacilityFunctionTrainingRadioModel;

  private ACRadioButtonItem specificFacilityFunctionTrainingRadioItem2;

  private ACRadioButtonItem specificFacilityFunctionTrainingRadioItem1;

  private ACValueArrayRadioButtonGroup nightNursingSystemRadio;

  private ACLabelContainer nightNursingSystemRadioContainer;

  private ACListModelAdapter nightNursingSystemRadioModel;

  private ACRadioButtonItem nightNursingSystemRadioItem1;

  private ACRadioButtonItem nightNursingSystemRadioItem2;

  private ACValueArrayRadioButtonGroup medicalCoordinateAddRadioGroup;

  private ACLabelContainer medicalCoordinateAddRadioGroupContainer;

  private ACListModelAdapter medicalCoordinateAddRadioGroupModel;

  private ACRadioButtonItem medicalCoordinateAddRadioItem1;

  private ACRadioButtonItem medicalCoordinateAddRadioItem2;

  private ACValueArrayRadioButtonGroup impairedPersonHelpAddRadioGroup;

  private ACLabelContainer impairedPersonHelpAddRadioGroupContainer;

  private ACListModelAdapter impairedPersonHelpAddRadioGroupModel;

  private ACRadioButtonItem impairedPersonHelpAddRadioItem1;

  private ACRadioButtonItem impairedPersonHelpAddRadioItem2;

  private ACPanel tabPanel2;

  private ACValueArrayRadioButtonGroup terminalCareAddRadioGroup;

  private ACLabelContainer terminalCareAddRadioGroupContainer;

  private ACListModelAdapter terminalCareAddRadioGroupModel;

  private ACRadioButtonItem terminalCareAddRadioItem1;

  private ACRadioButtonItem terminalCareAddRadioItem2;

  private ACRadioButtonItem terminalCareAddRadioItem3;

  private ACRadioButtonItem terminalCareAddRadioItem4;

  private ACLabelContainer kaigoWelfareFacilityTakingCareNursingAddDaysContainer;

  private ACTextField kaigoWelfareFacilityTakingCareNursingAddDays;

  private ACLabel kaigoWelfareFacilityTakingCareNursingAddDaysUnit;

  private ACValueArrayRadioButtonGroup dementiaProfessionalCareAddRadioGroup;

  private ACLabelContainer dementiaProfessionalCareAddRadioGroupContainer;

  private ACListModelAdapter dementiaProfessionalCareAddRadioGroupModel;

  private ACRadioButtonItem dementiaProfessionalCareAddRadioItem1;

  private ACRadioButtonItem dementiaProfessionalCareAddRadioItem2;

  private ACRadioButtonItem dementiaProfessionalCareAddRadioItem3;

  private ACValueArrayRadioButtonGroup serviceAddProvisionStructuralRadioGroup;

  private ACLabelContainer serviceAddProvisionStructuralRadioGroupContainer;

  private ACListModelAdapter serviceAddProvisionStructuralRadioGroupModel;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem1;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem2;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem3;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem4;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem5;

  private ACValueArrayRadioButtonGroup calculationDivisionRadio;

  private ACLabelContainer calculationDivisionRadioContainer;

  private ACListModelAdapter calculationDivisionRadioModel;

  private ACRadioButtonItem calculationDivisionRadioItem1;

  private ACRadioButtonItem calculationDivisionRadioItem2;

  private ACPanel tabPanel3;

  private ACPanel serviceSettingPanel;

  private ACValueArrayRadioButtonGroup outsideServiceRadio;

  private ACLabelContainer outsideServiceRadioContainer;

  private ACListModelAdapter outsideServiceRadioModel;

  private ACRadioButtonItem outsideServiceRadioItem0;

  private ACRadioButtonItem outsideServiceRadioItem1;

  private ACRadioButtonItem outsideServiceRadioItem2;

  private ACRadioButtonItem outsideServiceRadioItem3;

  private ACRadioButtonItem outsideServiceRadioItem4;

  private ACRadioButtonItem outsideServiceRadioItem5;

  private ACRadioButtonItem outsideServiceRadioItem6;

  private ACRadioButtonItem outsideServiceRadioItem7;

  private ACRadioButtonItem outsideServiceRadioItem8;

  private ACRadioButtonItem outsideServiceRadioItem9;

  private ACBackLabelContainer specificFacilityTimeContena;

  private ACTimeComboBox specificFacilityBeginTime;

  private ACLabelContainer specificFacilityBeginTimeContainer;

  private ACComboBoxModelAdapter specificFacilityBeginTimeModel;

  private ACTimeComboBox specificFacilityEndTime;

  private ACLabelContainer specificFacilityEndTimeContainer;

  private ACComboBoxModelAdapter specificFacilityEndTimeModel;

  private ACGroupBox visitCareGroup;

  private ACValueArrayRadioButtonGroup visitCareRadio;

  private ACLabelContainer visitCareRadioContainer;

  private ACListModelAdapter visitCareRadioModel;

  private ACRadioButtonItem visitCareRadioItem1;

  private ACRadioButtonItem visitCareRadioItem2;

  private ACRadioButtonItem visitCareRadioItem3;

  private ACComboBox visitCareCombo;

  private ACLabelContainer visitCareComboContainer;

  private ACComboBoxModelAdapter visitCareComboModel;

  private ACPanel tabPanel4;

  private ACGroupBox visitNursingRadioGroup;

  private ACValueArrayRadioButtonGroup visitNursingFacilitiesDivisionRadio;

  private ACLabelContainer visitNursingFacilitiesDivisionRadioContainer;

  private ACListModelAdapter visitNursingFacilitiesDivisionRadioModel;

  private ACRadioButtonItem visitNursingFacilitiesDivisionRadioItem1;

  private ACRadioButtonItem visitNursingFacilitiesDivisionRadioItem2;

  private ACValueArrayRadioButtonGroup visitNursingStaffDivisionRadio;

  private ACLabelContainer visitNursingStaffDivisionRadioContainer;

  private ACListModelAdapter visitNursingStaffDivisionRadioModel;

  private ACRadioButtonItem visitNursingStaffDivisionRadioItem1;

  private ACRadioButtonItem visitNursingStaffDivisionRadioItem2;

  private ACIntegerCheckBox twoOrMoreTimesCheck;

  private ACComboBox visitNursingCombo;

  private ACLabelContainer visitNursingComboContainer;

  private ACComboBoxModelAdapter visitNursingComboModel;

  private ACValueArrayRadioButtonGroup nurseStaffDivisionRadioGroup;

  private ACLabelContainer nurseStaffDivisionRadioGroupContainer;

  private ACListModelAdapter nurseStaffDivisionRadioGroupModel;

  private ACRadioButtonItem nurseStaffDivisionRadioItem1;

  private ACRadioButtonItem nurseStaffDivisionRadioItem2;

  private ACGroupBox visitRehabiliGroup;

  private ACValueArrayRadioButtonGroup visitRehabiliRadio;

  private ACLabelContainer visitRehabiliRadioContainer;

  private ACListModelAdapter visitRehabiliRadioModel;

  private ACRadioButtonItem visitRehabiliRadioItem1;

  private ACRadioButtonItem visitRehabiliRadioItem2;

  private ACPanel tabPanel5;

  private ACGroupBox expertPlaceNursingGroup;

  private ACValueArrayRadioButtonGroup expertPlaceNursingRadio;

  private ACLabelContainer expertPlaceNursingRadioContainer;

  private ACListModelAdapter expertPlaceNursingRadioModel;

  private ACRadioButtonItem expertPlaceNursingRadioItem1;

  private ACRadioButtonItem expertPlaceNursingRadioItem2;

  private ACRadioButtonItem expertPlaceNursingRadioItem3;

  private ACRadioButtonItem expertPlaceNursingRadioItem4;

  private ACRadioButtonItem expertPlaceNursingRadioItem5;

  private ACComboBox expertPlaceNursingCombo;

  private ACLabelContainer expertPlaceNursingComboContainer;

  private ACComboBoxModelAdapter expertPlaceNursingComboModel;

  private ACPanel tabPanel6;

  private ACGroupBox expertPlaceRehabiliGroup;

  private ACValueArrayRadioButtonGroup expertPlaceRehabiliRadio;

  private ACLabelContainer expertPlaceRehabiliRadioContainer;

  private ACListModelAdapter expertPlaceRehabiliRadioModel;

  private ACRadioButtonItem expertPlaceRehabiliRadioItem1;

  private ACRadioButtonItem expertPlaceRehabiliRadioItem2;

  private ACRadioButtonItem expertPlaceRehabiliRadioItem3;

  private ACRadioButtonItem expertPlaceRehabiliRadioItem4;

  private ACRadioButtonItem expertPlaceRehabiliRadioItem5;

  private ACRadioButtonItem expertPlaceRehabiliRadioItem6;

  private ACComboBox expertPlaceRehabiliCombo;

  private ACLabelContainer expertPlaceRehabiliComboContainer;

  private ACComboBoxModelAdapter expertPlaceRehabiliComboModel;

  private ACPanel tabPanel7;

  private ACGroupBox welfareToolsGroup;

  private ACComboBox welfareToolsCombo;

  private ACLabelContainer welfareToolsComboContainer;

  private ACComboBoxModelAdapter welfareToolsComboModel;

  private ACTextField welfarePointText;

  private ACLabelContainer welfarePointTextContainer;

  private ACTextField welfareTekiyoText;

  private ACLabelContainer welfareTekiyoTextContainer;

  private ACGroupBox ninchishoTaioTsushoGroup;

  private ACValueArrayRadioButtonGroup providerDivisionRadio;

  private ACLabelContainer providerDivisionRadioContainer;

  private ACListModelAdapter providerDivisionRadioModel;

  private ACRadioButtonItem providerDivisionRadioItem1;

  private ACRadioButtonItem providerDivisionRadioItem2;

  private ACValueArrayRadioButtonGroup divisionRadion;

  private ACLabelContainer divisionRadionContainer;

  private ACListModelAdapter divisionRadionModel;

  private ACRadioButtonItem divisionRadionitem1;

  private ACRadioButtonItem divisionRadionitem2;

  private ACValueArrayRadioButtonGroup timeDivisionRadio;

  private ACLabelContainer timeDivisionRadioContainer;

  private ACListModelAdapter timeDivisionRadioModel;

  private ACRadioButtonItem timeDivisionRadioItem1;

  private ACRadioButtonItem timeDivisionRadioItem2;

  private ACRadioButtonItem timeDivisionRadioItem3;

  private ACRadioButtonItem timeDivisionRadioItem4;

  private ACPanel tabPanel8;

  private ACGroupBox chiikiDayCareGroup;

  private ACValueArrayRadioButtonGroup chiikiDayCareRadio;

  private ACLabelContainer chiikiDayCareRadioContainer;

  private ACListModelAdapter chiikiDayCareRadioModel;

  private ACRadioButtonItem chiikiDayCareRadioItem1;

  private ACRadioButtonItem chiikiDayCareRadioItem2;

  private ACComboBox chiikiDayCareCombo;

  private ACLabelContainer chiikiDayCareComboContainer;

  private ACComboBoxModelAdapter chiikiDayCareComboModel;

  //getter

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
   * �^�u�p�l��1���擾���܂��B
   * @return �^�u�p�l��1
   */
  public ACPanel getTabPanel1(){
    if(tabPanel1==null){

      tabPanel1 = new ACPanel();

      tabPanel1.setFollowChildEnabled(true);

      tabPanel1.setHgap(0);

      addTabPanel1();
    }
    return tabPanel1;

  }

  /**
   * �{�ݓ��̋敪���擾���܂��B
   * @return �{�ݓ��̋敪
   */
  public ACValueArrayRadioButtonGroup getFacilitiesDivisionRadio(){
    if(facilitiesDivisionRadio==null){

      facilitiesDivisionRadio = new ACValueArrayRadioButtonGroup();

      getFacilitiesDivisionRadioContainer().setText("�{�ݓ��̋敪");

      facilitiesDivisionRadio.setBindPath("1330105");

      facilitiesDivisionRadio.setUseClearButton(false);

      facilitiesDivisionRadio.setModel(getFacilitiesDivisionRadioModel());

      facilitiesDivisionRadio.setValues(new int[]{1,2});

      addFacilitiesDivisionRadio();
    }
    return facilitiesDivisionRadio;

  }

  /**
   * �{�ݓ��̋敪�R���e�i���擾���܂��B
   * @return �{�ݓ��̋敪�R���e�i
   */
  protected ACLabelContainer getFacilitiesDivisionRadioContainer(){
    if(facilitiesDivisionRadioContainer==null){
      facilitiesDivisionRadioContainer = new ACLabelContainer();
      facilitiesDivisionRadioContainer.setFollowChildEnabled(true);
      facilitiesDivisionRadioContainer.setVAlignment(VRLayout.CENTER);
      facilitiesDivisionRadioContainer.add(getFacilitiesDivisionRadio(), null);
    }
    return facilitiesDivisionRadioContainer;
  }

  /**
   * �{�ݓ��̋敪���f�����擾���܂��B
   * @return �{�ݓ��̋敪���f��
   */
  protected ACListModelAdapter getFacilitiesDivisionRadioModel(){
    if(facilitiesDivisionRadioModel==null){
      facilitiesDivisionRadioModel = new ACListModelAdapter();
      addFacilitiesDivisionRadioModel();
    }
    return facilitiesDivisionRadioModel;
  }

  /**
   * ����{�ݓ����҂��擾���܂��B
   * @return ����{�ݓ�����
   */
  public ACRadioButtonItem getFacilitiesDivisionRadioItem1(){
    if(facilitiesDivisionRadioItem1==null){

      facilitiesDivisionRadioItem1 = new ACRadioButtonItem();

      facilitiesDivisionRadioItem1.setText("����{�ݓ�����");

      facilitiesDivisionRadioItem1.setGroup(getFacilitiesDivisionRadio());

      facilitiesDivisionRadioItem1.setConstraints(VRLayout.FLOW_RETURN);

      addFacilitiesDivisionRadioItem1();
    }
    return facilitiesDivisionRadioItem1;

  }

  /**
   * �O���T�[�r�X���p�^���擾���܂��B
   * @return �O���T�[�r�X���p�^
   */
  public ACRadioButtonItem getFacilitiesDivisionRadioItem2(){
    if(facilitiesDivisionRadioItem2==null){

      facilitiesDivisionRadioItem2 = new ACRadioButtonItem();

      facilitiesDivisionRadioItem2.setText("�O���T�[�r�X���p�^");

      facilitiesDivisionRadioItem2.setGroup(getFacilitiesDivisionRadio());

      facilitiesDivisionRadioItem2.setConstraints(VRLayout.FLOW);

      addFacilitiesDivisionRadioItem2();
    }
    return facilitiesDivisionRadioItem2;

  }

  /**
   * �l�����Z���擾���܂��B
   * @return �l�����Z
   */
  public ACValueArrayRadioButtonGroup getSpecificFacilitySubtractionRadio(){
    if(specificFacilitySubtractionRadio==null){

      specificFacilitySubtractionRadio = new ACValueArrayRadioButtonGroup();

      getSpecificFacilitySubtractionRadioContainer().setText("�l�����Z");

      specificFacilitySubtractionRadio.setBindPath("1330104");

      specificFacilitySubtractionRadio.setUseClearButton(false);

      specificFacilitySubtractionRadio.setModel(getSpecificFacilitySubtractionRadioModel());

      specificFacilitySubtractionRadio.setValues(new int[]{1,2});

      addSpecificFacilitySubtractionRadio();
    }
    return specificFacilitySubtractionRadio;

  }

  /**
   * �l�����Z�R���e�i���擾���܂��B
   * @return �l�����Z�R���e�i
   */
  protected ACLabelContainer getSpecificFacilitySubtractionRadioContainer(){
    if(specificFacilitySubtractionRadioContainer==null){
      specificFacilitySubtractionRadioContainer = new ACLabelContainer();
      specificFacilitySubtractionRadioContainer.setFollowChildEnabled(true);
      specificFacilitySubtractionRadioContainer.setVAlignment(VRLayout.CENTER);
      specificFacilitySubtractionRadioContainer.add(getSpecificFacilitySubtractionRadio(), null);
    }
    return specificFacilitySubtractionRadioContainer;
  }

  /**
   * �l�����Z���f�����擾���܂��B
   * @return �l�����Z���f��
   */
  protected ACListModelAdapter getSpecificFacilitySubtractionRadioModel(){
    if(specificFacilitySubtractionRadioModel==null){
      specificFacilitySubtractionRadioModel = new ACListModelAdapter();
      addSpecificFacilitySubtractionRadioModel();
    }
    return specificFacilitySubtractionRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getSpecificFacilitySubtractionNot(){
    if(specificFacilitySubtractionNot==null){

      specificFacilitySubtractionNot = new ACRadioButtonItem();

      specificFacilitySubtractionNot.setText("�Ȃ�");

      specificFacilitySubtractionNot.setGroup(getSpecificFacilitySubtractionRadio());

      specificFacilitySubtractionNot.setConstraints(VRLayout.FLOW_RETURN);

      addSpecificFacilitySubtractionNot();
    }
    return specificFacilitySubtractionNot;

  }

  /**
   * �E���s�����擾���܂��B
   * @return �E���s��
   */
  public ACRadioButtonItem getSpecificFacilitySubtractionPersonLack(){
    if(specificFacilitySubtractionPersonLack==null){

      specificFacilitySubtractionPersonLack = new ACRadioButtonItem();

      specificFacilitySubtractionPersonLack.setText("�Ō�E���E���̕s��");

      specificFacilitySubtractionPersonLack.setGroup(getSpecificFacilitySubtractionRadio());

      specificFacilitySubtractionPersonLack.setConstraints(VRLayout.FLOW);

      addSpecificFacilitySubtractionPersonLack();
    }
    return specificFacilitySubtractionPersonLack;

  }

  /**
   * �ʋ@�\�P���w���̐����Z���擾���܂��B
   * @return �ʋ@�\�P���w���̐����Z
   */
  public ACValueArrayRadioButtonGroup getSpecificFacilityFunctionTrainingRadio(){
    if(specificFacilityFunctionTrainingRadio==null){

      specificFacilityFunctionTrainingRadio = new ACValueArrayRadioButtonGroup();

      getSpecificFacilityFunctionTrainingRadioContainer().setText("�ʋ@�\�P���w�����Z");

      specificFacilityFunctionTrainingRadio.setBindPath("1330103");

      specificFacilityFunctionTrainingRadio.setUseClearButton(false);

      specificFacilityFunctionTrainingRadio.setModel(getSpecificFacilityFunctionTrainingRadioModel());

      specificFacilityFunctionTrainingRadio.setValues(new int[]{1,2});

      addSpecificFacilityFunctionTrainingRadio();
    }
    return specificFacilityFunctionTrainingRadio;

  }

  /**
   * �ʋ@�\�P���w���̐����Z�R���e�i���擾���܂��B
   * @return �ʋ@�\�P���w���̐����Z�R���e�i
   */
  protected ACLabelContainer getSpecificFacilityFunctionTrainingRadioContainer(){
    if(specificFacilityFunctionTrainingRadioContainer==null){
      specificFacilityFunctionTrainingRadioContainer = new ACLabelContainer();
      specificFacilityFunctionTrainingRadioContainer.setFollowChildEnabled(true);
      specificFacilityFunctionTrainingRadioContainer.setVAlignment(VRLayout.CENTER);
      specificFacilityFunctionTrainingRadioContainer.add(getSpecificFacilityFunctionTrainingRadio(), null);
    }
    return specificFacilityFunctionTrainingRadioContainer;
  }

  /**
   * �ʋ@�\�P���w���̐����Z���f�����擾���܂��B
   * @return �ʋ@�\�P���w���̐����Z���f��
   */
  protected ACListModelAdapter getSpecificFacilityFunctionTrainingRadioModel(){
    if(specificFacilityFunctionTrainingRadioModel==null){
      specificFacilityFunctionTrainingRadioModel = new ACListModelAdapter();
      addSpecificFacilityFunctionTrainingRadioModel();
    }
    return specificFacilityFunctionTrainingRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getSpecificFacilityFunctionTrainingRadioItem2(){
    if(specificFacilityFunctionTrainingRadioItem2==null){

      specificFacilityFunctionTrainingRadioItem2 = new ACRadioButtonItem();

      specificFacilityFunctionTrainingRadioItem2.setText("�Ȃ�");

      specificFacilityFunctionTrainingRadioItem2.setGroup(getSpecificFacilityFunctionTrainingRadio());

      specificFacilityFunctionTrainingRadioItem2.setConstraints(VRLayout.FLOW);

      addSpecificFacilityFunctionTrainingRadioItem2();
    }
    return specificFacilityFunctionTrainingRadioItem2;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getSpecificFacilityFunctionTrainingRadioItem1(){
    if(specificFacilityFunctionTrainingRadioItem1==null){

      specificFacilityFunctionTrainingRadioItem1 = new ACRadioButtonItem();

      specificFacilityFunctionTrainingRadioItem1.setText("����");

      specificFacilityFunctionTrainingRadioItem1.setGroup(getSpecificFacilityFunctionTrainingRadio());

      specificFacilityFunctionTrainingRadioItem1.setConstraints(VRLayout.FLOW);

      addSpecificFacilityFunctionTrainingRadioItem1();
    }
    return specificFacilityFunctionTrainingRadioItem1;

  }

  /**
   * ��ԊŌ�̐����Z���擾���܂��B
   * @return ��ԊŌ�̐����Z
   */
  public ACValueArrayRadioButtonGroup getNightNursingSystemRadio(){
    if(nightNursingSystemRadio==null){

      nightNursingSystemRadio = new ACValueArrayRadioButtonGroup();

      getNightNursingSystemRadioContainer().setText("��ԊŌ�̐����Z");

      nightNursingSystemRadio.setBindPath("1330106");

      nightNursingSystemRadio.setUseClearButton(false);

      nightNursingSystemRadio.setModel(getNightNursingSystemRadioModel());

      nightNursingSystemRadio.setValues(new int[]{1,2});

      addNightNursingSystemRadio();
    }
    return nightNursingSystemRadio;

  }

  /**
   * ��ԊŌ�̐����Z�R���e�i���擾���܂��B
   * @return ��ԊŌ�̐����Z�R���e�i
   */
  protected ACLabelContainer getNightNursingSystemRadioContainer(){
    if(nightNursingSystemRadioContainer==null){
      nightNursingSystemRadioContainer = new ACLabelContainer();
      nightNursingSystemRadioContainer.setFollowChildEnabled(true);
      nightNursingSystemRadioContainer.setVAlignment(VRLayout.CENTER);
      nightNursingSystemRadioContainer.add(getNightNursingSystemRadio(), null);
    }
    return nightNursingSystemRadioContainer;
  }

  /**
   * ��ԊŌ�̐����Z���f�����擾���܂��B
   * @return ��ԊŌ�̐����Z���f��
   */
  protected ACListModelAdapter getNightNursingSystemRadioModel(){
    if(nightNursingSystemRadioModel==null){
      nightNursingSystemRadioModel = new ACListModelAdapter();
      addNightNursingSystemRadioModel();
    }
    return nightNursingSystemRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getNightNursingSystemRadioItem1(){
    if(nightNursingSystemRadioItem1==null){

      nightNursingSystemRadioItem1 = new ACRadioButtonItem();

      nightNursingSystemRadioItem1.setText("�Ȃ�");

      nightNursingSystemRadioItem1.setGroup(getNightNursingSystemRadio());

      nightNursingSystemRadioItem1.setConstraints(VRLayout.FLOW);

      addNightNursingSystemRadioItem1();
    }
    return nightNursingSystemRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getNightNursingSystemRadioItem2(){
    if(nightNursingSystemRadioItem2==null){

      nightNursingSystemRadioItem2 = new ACRadioButtonItem();

      nightNursingSystemRadioItem2.setText("����");

      nightNursingSystemRadioItem2.setGroup(getNightNursingSystemRadio());

      nightNursingSystemRadioItem2.setConstraints(VRLayout.FLOW);

      addNightNursingSystemRadioItem2();
    }
    return nightNursingSystemRadioItem2;

  }

  /**
   * ��Ë@�֘A�g���Z���擾���܂��B
   * @return ��Ë@�֘A�g���Z
   */
  public ACValueArrayRadioButtonGroup getMedicalCoordinateAddRadioGroup(){
    if(medicalCoordinateAddRadioGroup==null){

      medicalCoordinateAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getMedicalCoordinateAddRadioGroupContainer().setText("��Ë@�֘A�g���Z");

      medicalCoordinateAddRadioGroup.setBindPath("1330124");

      medicalCoordinateAddRadioGroup.setNoSelectIndex(0);

      medicalCoordinateAddRadioGroup.setUseClearButton(false);

      medicalCoordinateAddRadioGroup.setModel(getMedicalCoordinateAddRadioGroupModel());

      medicalCoordinateAddRadioGroup.setValues(new int[]{1,2});

      addMedicalCoordinateAddRadioGroup();
    }
    return medicalCoordinateAddRadioGroup;

  }

  /**
   * ��Ë@�֘A�g���Z�R���e�i���擾���܂��B
   * @return ��Ë@�֘A�g���Z�R���e�i
   */
  protected ACLabelContainer getMedicalCoordinateAddRadioGroupContainer(){
    if(medicalCoordinateAddRadioGroupContainer==null){
      medicalCoordinateAddRadioGroupContainer = new ACLabelContainer();
      medicalCoordinateAddRadioGroupContainer.setFollowChildEnabled(true);
      medicalCoordinateAddRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      medicalCoordinateAddRadioGroupContainer.add(getMedicalCoordinateAddRadioGroup(), null);
    }
    return medicalCoordinateAddRadioGroupContainer;
  }

  /**
   * ��Ë@�֘A�g���Z���f�����擾���܂��B
   * @return ��Ë@�֘A�g���Z���f��
   */
  protected ACListModelAdapter getMedicalCoordinateAddRadioGroupModel(){
    if(medicalCoordinateAddRadioGroupModel==null){
      medicalCoordinateAddRadioGroupModel = new ACListModelAdapter();
      addMedicalCoordinateAddRadioGroupModel();
    }
    return medicalCoordinateAddRadioGroupModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getMedicalCoordinateAddRadioItem1(){
    if(medicalCoordinateAddRadioItem1==null){

      medicalCoordinateAddRadioItem1 = new ACRadioButtonItem();

      medicalCoordinateAddRadioItem1.setText("�Ȃ�");

      medicalCoordinateAddRadioItem1.setGroup(getMedicalCoordinateAddRadioGroup());

      medicalCoordinateAddRadioItem1.setConstraints(VRLayout.FLOW);

      addMedicalCoordinateAddRadioItem1();
    }
    return medicalCoordinateAddRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getMedicalCoordinateAddRadioItem2(){
    if(medicalCoordinateAddRadioItem2==null){

      medicalCoordinateAddRadioItem2 = new ACRadioButtonItem();

      medicalCoordinateAddRadioItem2.setText("����");

      medicalCoordinateAddRadioItem2.setGroup(getMedicalCoordinateAddRadioGroup());

      medicalCoordinateAddRadioItem2.setConstraints(VRLayout.FLOW);

      addMedicalCoordinateAddRadioItem2();
    }
    return medicalCoordinateAddRadioItem2;

  }

  /**
   * ��Q�ғ��x�����Z���擾���܂��B
   * @return ��Q�ғ��x�����Z
   */
  public ACValueArrayRadioButtonGroup getImpairedPersonHelpAddRadioGroup(){
    if(impairedPersonHelpAddRadioGroup==null){

      impairedPersonHelpAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getImpairedPersonHelpAddRadioGroupContainer().setText("��Q�ғ��x�����Z");

      impairedPersonHelpAddRadioGroup.setBindPath("1330125");

      impairedPersonHelpAddRadioGroup.setNoSelectIndex(0);

      impairedPersonHelpAddRadioGroup.setUseClearButton(false);

      impairedPersonHelpAddRadioGroup.setModel(getImpairedPersonHelpAddRadioGroupModel());

      impairedPersonHelpAddRadioGroup.setValues(new int[]{1,2});

      addImpairedPersonHelpAddRadioGroup();
    }
    return impairedPersonHelpAddRadioGroup;

  }

  /**
   * ��Q�ғ��x�����Z�R���e�i���擾���܂��B
   * @return ��Q�ғ��x�����Z�R���e�i
   */
  protected ACLabelContainer getImpairedPersonHelpAddRadioGroupContainer(){
    if(impairedPersonHelpAddRadioGroupContainer==null){
      impairedPersonHelpAddRadioGroupContainer = new ACLabelContainer();
      impairedPersonHelpAddRadioGroupContainer.setFollowChildEnabled(true);
      impairedPersonHelpAddRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      impairedPersonHelpAddRadioGroupContainer.add(getImpairedPersonHelpAddRadioGroup(), null);
    }
    return impairedPersonHelpAddRadioGroupContainer;
  }

  /**
   * ��Q�ғ��x�����Z���f�����擾���܂��B
   * @return ��Q�ғ��x�����Z���f��
   */
  protected ACListModelAdapter getImpairedPersonHelpAddRadioGroupModel(){
    if(impairedPersonHelpAddRadioGroupModel==null){
      impairedPersonHelpAddRadioGroupModel = new ACListModelAdapter();
      addImpairedPersonHelpAddRadioGroupModel();
    }
    return impairedPersonHelpAddRadioGroupModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getImpairedPersonHelpAddRadioItem1(){
    if(impairedPersonHelpAddRadioItem1==null){

      impairedPersonHelpAddRadioItem1 = new ACRadioButtonItem();

      impairedPersonHelpAddRadioItem1.setText("�Ȃ�");

      impairedPersonHelpAddRadioItem1.setGroup(getImpairedPersonHelpAddRadioGroup());

      impairedPersonHelpAddRadioItem1.setConstraints(VRLayout.FLOW);

      addImpairedPersonHelpAddRadioItem1();
    }
    return impairedPersonHelpAddRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getImpairedPersonHelpAddRadioItem2(){
    if(impairedPersonHelpAddRadioItem2==null){

      impairedPersonHelpAddRadioItem2 = new ACRadioButtonItem();

      impairedPersonHelpAddRadioItem2.setText("����");

      impairedPersonHelpAddRadioItem2.setGroup(getImpairedPersonHelpAddRadioGroup());

      impairedPersonHelpAddRadioItem2.setConstraints(VRLayout.FLOW);

      addImpairedPersonHelpAddRadioItem2();
    }
    return impairedPersonHelpAddRadioItem2;

  }

  /**
   * �^�u�p�l��2���擾���܂��B
   * @return �^�u�p�l��2
   */
  public ACPanel getTabPanel2(){
    if(tabPanel2==null){

      tabPanel2 = new ACPanel();

      tabPanel2.setFollowChildEnabled(true);

      tabPanel2.setHgap(0);

      addTabPanel2();
    }
    return tabPanel2;

  }

  /**
   * �Ŏ������Z���擾���܂��B
   * @return �Ŏ������Z
   */
  public ACValueArrayRadioButtonGroup getTerminalCareAddRadioGroup(){
    if(terminalCareAddRadioGroup==null){

      terminalCareAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getTerminalCareAddRadioGroupContainer().setText("�Ŏ������Z");

      terminalCareAddRadioGroup.setBindPath("1330128");

      terminalCareAddRadioGroup.setNoSelectIndex(0);

      terminalCareAddRadioGroup.setUseClearButton(false);

      terminalCareAddRadioGroup.setModel(getTerminalCareAddRadioGroupModel());

      terminalCareAddRadioGroup.setValues(new int[]{1,2,3,4});

      addTerminalCareAddRadioGroup();
    }
    return terminalCareAddRadioGroup;

  }

  /**
   * �Ŏ������Z�R���e�i���擾���܂��B
   * @return �Ŏ������Z�R���e�i
   */
  protected ACLabelContainer getTerminalCareAddRadioGroupContainer(){
    if(terminalCareAddRadioGroupContainer==null){
      terminalCareAddRadioGroupContainer = new ACLabelContainer();
      terminalCareAddRadioGroupContainer.setFollowChildEnabled(true);
      terminalCareAddRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      terminalCareAddRadioGroupContainer.add(getTerminalCareAddRadioGroup(), null);
    }
    return terminalCareAddRadioGroupContainer;
  }

  /**
   * �Ŏ������Z���f�����擾���܂��B
   * @return �Ŏ������Z���f��
   */
  protected ACListModelAdapter getTerminalCareAddRadioGroupModel(){
    if(terminalCareAddRadioGroupModel==null){
      terminalCareAddRadioGroupModel = new ACListModelAdapter();
      addTerminalCareAddRadioGroupModel();
    }
    return terminalCareAddRadioGroupModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getTerminalCareAddRadioItem1(){
    if(terminalCareAddRadioItem1==null){

      terminalCareAddRadioItem1 = new ACRadioButtonItem();

      terminalCareAddRadioItem1.setText("�Ȃ�");

      terminalCareAddRadioItem1.setGroup(getTerminalCareAddRadioGroup());

      terminalCareAddRadioItem1.setConstraints(VRLayout.FLOW_RETURN);

      addTerminalCareAddRadioItem1();
    }
    return terminalCareAddRadioItem1;

  }

  /**
   * ���S���ȑO4���ȏ�30���ȉ����擾���܂��B
   * @return ���S���ȑO4���ȏ�30���ȉ�
   */
  public ACRadioButtonItem getTerminalCareAddRadioItem2(){
    if(terminalCareAddRadioItem2==null){

      terminalCareAddRadioItem2 = new ACRadioButtonItem();

      terminalCareAddRadioItem2.setText("���S���ȑO4���ȏ�30���ȉ�");

      terminalCareAddRadioItem2.setGroup(getTerminalCareAddRadioGroup());

      terminalCareAddRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

      addTerminalCareAddRadioItem2();
    }
    return terminalCareAddRadioItem2;

  }

  /**
   * ���S���ȑO2������3�����擾���܂��B
   * @return ���S���ȑO2������3��
   */
  public ACRadioButtonItem getTerminalCareAddRadioItem3(){
    if(terminalCareAddRadioItem3==null){

      terminalCareAddRadioItem3 = new ACRadioButtonItem();

      terminalCareAddRadioItem3.setText("���S���ȑO2������3��");

      terminalCareAddRadioItem3.setGroup(getTerminalCareAddRadioGroup());

      terminalCareAddRadioItem3.setConstraints(VRLayout.FLOW_RETURN);

      addTerminalCareAddRadioItem3();
    }
    return terminalCareAddRadioItem3;

  }

  /**
   * ���S�����擾���܂��B
   * @return ���S��
   */
  public ACRadioButtonItem getTerminalCareAddRadioItem4(){
    if(terminalCareAddRadioItem4==null){

      terminalCareAddRadioItem4 = new ACRadioButtonItem();

      terminalCareAddRadioItem4.setText("���S��");

      terminalCareAddRadioItem4.setGroup(getTerminalCareAddRadioGroup());

      terminalCareAddRadioItem4.setConstraints(VRLayout.FLOW_RETURN);

      addTerminalCareAddRadioItem4();
    }
    return terminalCareAddRadioItem4;

  }

  /**
   * �Ŏ������Z�R���e�i���擾���܂��B
   * @return �Ŏ������Z�R���e�i
   */
  public ACLabelContainer getKaigoWelfareFacilityTakingCareNursingAddDaysContainer(){
    if(kaigoWelfareFacilityTakingCareNursingAddDaysContainer==null){

      kaigoWelfareFacilityTakingCareNursingAddDaysContainer = new ACLabelContainer();

      kaigoWelfareFacilityTakingCareNursingAddDaysContainer.setText("�Ŏ������Z����");

      kaigoWelfareFacilityTakingCareNursingAddDaysContainer.setFollowChildEnabled(true);

      addKaigoWelfareFacilityTakingCareNursingAddDaysContainer();
    }
    return kaigoWelfareFacilityTakingCareNursingAddDaysContainer;

  }

  /**
   * �Ŏ������Z�������擾���܂��B
   * @return �Ŏ������Z����
   */
  public ACTextField getKaigoWelfareFacilityTakingCareNursingAddDays(){
    if(kaigoWelfareFacilityTakingCareNursingAddDays==null){

      kaigoWelfareFacilityTakingCareNursingAddDays = new ACTextField();

      kaigoWelfareFacilityTakingCareNursingAddDays.setText("1");

      kaigoWelfareFacilityTakingCareNursingAddDays.setBindPath("1330133");

      kaigoWelfareFacilityTakingCareNursingAddDays.setColumns(2);

      kaigoWelfareFacilityTakingCareNursingAddDays.setCharType(VRCharType.ONLY_DIGIT);

      kaigoWelfareFacilityTakingCareNursingAddDays.setHorizontalAlignment(SwingConstants.RIGHT);

      kaigoWelfareFacilityTakingCareNursingAddDays.setMaxLength(2);

      addKaigoWelfareFacilityTakingCareNursingAddDays();
    }
    return kaigoWelfareFacilityTakingCareNursingAddDays;

  }

  /**
   * �Ŏ������Z�����P�ʂ��擾���܂��B
   * @return �Ŏ������Z�����P��
   */
  public ACLabel getKaigoWelfareFacilityTakingCareNursingAddDaysUnit(){
    if(kaigoWelfareFacilityTakingCareNursingAddDaysUnit==null){

      kaigoWelfareFacilityTakingCareNursingAddDaysUnit = new ACLabel();

      kaigoWelfareFacilityTakingCareNursingAddDaysUnit.setText("��");

      addKaigoWelfareFacilityTakingCareNursingAddDaysUnit();
    }
    return kaigoWelfareFacilityTakingCareNursingAddDaysUnit;

  }

  /**
   * �F�m�ǐ��P�A���Z���擾���܂��B
   * @return �F�m�ǐ��P�A���Z
   */
  public ACValueArrayRadioButtonGroup getDementiaProfessionalCareAddRadioGroup(){
    if(dementiaProfessionalCareAddRadioGroup==null){

      dementiaProfessionalCareAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getDementiaProfessionalCareAddRadioGroupContainer().setText("�F�m�ǐ��P�A���Z");

      dementiaProfessionalCareAddRadioGroup.setBindPath("1330130");

      dementiaProfessionalCareAddRadioGroup.setUseClearButton(false);

      dementiaProfessionalCareAddRadioGroup.setModel(getDementiaProfessionalCareAddRadioGroupModel());

      dementiaProfessionalCareAddRadioGroup.setValues(new int[]{1,2,3});

      addDementiaProfessionalCareAddRadioGroup();
    }
    return dementiaProfessionalCareAddRadioGroup;

  }

  /**
   * �F�m�ǐ��P�A���Z�R���e�i���擾���܂��B
   * @return �F�m�ǐ��P�A���Z�R���e�i
   */
  protected ACLabelContainer getDementiaProfessionalCareAddRadioGroupContainer(){
    if(dementiaProfessionalCareAddRadioGroupContainer==null){
      dementiaProfessionalCareAddRadioGroupContainer = new ACLabelContainer();
      dementiaProfessionalCareAddRadioGroupContainer.setFollowChildEnabled(true);
      dementiaProfessionalCareAddRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      dementiaProfessionalCareAddRadioGroupContainer.add(getDementiaProfessionalCareAddRadioGroup(), null);
    }
    return dementiaProfessionalCareAddRadioGroupContainer;
  }

  /**
   * �F�m�ǐ��P�A���Z���f�����擾���܂��B
   * @return �F�m�ǐ��P�A���Z���f��
   */
  protected ACListModelAdapter getDementiaProfessionalCareAddRadioGroupModel(){
    if(dementiaProfessionalCareAddRadioGroupModel==null){
      dementiaProfessionalCareAddRadioGroupModel = new ACListModelAdapter();
      addDementiaProfessionalCareAddRadioGroupModel();
    }
    return dementiaProfessionalCareAddRadioGroupModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getDementiaProfessionalCareAddRadioItem1(){
    if(dementiaProfessionalCareAddRadioItem1==null){

      dementiaProfessionalCareAddRadioItem1 = new ACRadioButtonItem();

      dementiaProfessionalCareAddRadioItem1.setText("�Ȃ�");

      dementiaProfessionalCareAddRadioItem1.setGroup(getDementiaProfessionalCareAddRadioGroup());

      addDementiaProfessionalCareAddRadioItem1();
    }
    return dementiaProfessionalCareAddRadioItem1;

  }

  /**
   * ���Z�^I���擾���܂��B
   * @return ���Z�^I
   */
  public ACRadioButtonItem getDementiaProfessionalCareAddRadioItem2(){
    if(dementiaProfessionalCareAddRadioItem2==null){

      dementiaProfessionalCareAddRadioItem2 = new ACRadioButtonItem();

      dementiaProfessionalCareAddRadioItem2.setText("���Z�^I");

      dementiaProfessionalCareAddRadioItem2.setGroup(getDementiaProfessionalCareAddRadioGroup());

      addDementiaProfessionalCareAddRadioItem2();
    }
    return dementiaProfessionalCareAddRadioItem2;

  }

  /**
   * ���Z�^II���擾���܂��B
   * @return ���Z�^II
   */
  public ACRadioButtonItem getDementiaProfessionalCareAddRadioItem3(){
    if(dementiaProfessionalCareAddRadioItem3==null){

      dementiaProfessionalCareAddRadioItem3 = new ACRadioButtonItem();

      dementiaProfessionalCareAddRadioItem3.setText("���Z�^II");

      dementiaProfessionalCareAddRadioItem3.setGroup(getDementiaProfessionalCareAddRadioGroup());

      addDementiaProfessionalCareAddRadioItem3();
    }
    return dementiaProfessionalCareAddRadioItem3;

  }

  /**
   * �T�[�r�X�񋟑̐��������Z���擾���܂��B
   * @return �T�[�r�X�񋟑̐��������Z
   */
  public ACValueArrayRadioButtonGroup getServiceAddProvisionStructuralRadioGroup(){
    if(serviceAddProvisionStructuralRadioGroup==null){

      serviceAddProvisionStructuralRadioGroup = new ACValueArrayRadioButtonGroup();

      getServiceAddProvisionStructuralRadioGroupContainer().setText("�T�[�r�X�񋟑̐��������Z");

      serviceAddProvisionStructuralRadioGroup.setBindPath("1330131");

      serviceAddProvisionStructuralRadioGroup.setVisible(true);

      serviceAddProvisionStructuralRadioGroup.setEnabled(true);

      serviceAddProvisionStructuralRadioGroup.setNoSelectIndex(0);

      serviceAddProvisionStructuralRadioGroup.setUseClearButton(false);

      serviceAddProvisionStructuralRadioGroup.setModel(getServiceAddProvisionStructuralRadioGroupModel());

      serviceAddProvisionStructuralRadioGroup.setValues(new int[]{1,2,3,4,5});

      addServiceAddProvisionStructuralRadioGroup();
    }
    return serviceAddProvisionStructuralRadioGroup;

  }

  /**
   * �T�[�r�X�񋟑̐��������Z�R���e�i���擾���܂��B
   * @return �T�[�r�X�񋟑̐��������Z�R���e�i
   */
  protected ACLabelContainer getServiceAddProvisionStructuralRadioGroupContainer(){
    if(serviceAddProvisionStructuralRadioGroupContainer==null){
      serviceAddProvisionStructuralRadioGroupContainer = new ACLabelContainer();
      serviceAddProvisionStructuralRadioGroupContainer.setFollowChildEnabled(true);
      serviceAddProvisionStructuralRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      serviceAddProvisionStructuralRadioGroupContainer.add(getServiceAddProvisionStructuralRadioGroup(), null);
    }
    return serviceAddProvisionStructuralRadioGroupContainer;
  }

  /**
   * �T�[�r�X�񋟑̐��������Z���f�����擾���܂��B
   * @return �T�[�r�X�񋟑̐��������Z���f��
   */
  protected ACListModelAdapter getServiceAddProvisionStructuralRadioGroupModel(){
    if(serviceAddProvisionStructuralRadioGroupModel==null){
      serviceAddProvisionStructuralRadioGroupModel = new ACListModelAdapter();
      addServiceAddProvisionStructuralRadioGroupModel();
    }
    return serviceAddProvisionStructuralRadioGroupModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getServiceAddProvisionStructuralRadioItem1(){
    if(serviceAddProvisionStructuralRadioItem1==null){

      serviceAddProvisionStructuralRadioItem1 = new ACRadioButtonItem();

      serviceAddProvisionStructuralRadioItem1.setText("�Ȃ�");

      serviceAddProvisionStructuralRadioItem1.setGroup(getServiceAddProvisionStructuralRadioGroup());

      serviceAddProvisionStructuralRadioItem1.setConstraints(VRLayout.FLOW);

      addServiceAddProvisionStructuralRadioItem1();
    }
    return serviceAddProvisionStructuralRadioItem1;

  }

  /**
   * I�C�^���擾���܂��B
   * @return I�C�^
   */
  public ACRadioButtonItem getServiceAddProvisionStructuralRadioItem2(){
    if(serviceAddProvisionStructuralRadioItem2==null){

      serviceAddProvisionStructuralRadioItem2 = new ACRadioButtonItem();

      serviceAddProvisionStructuralRadioItem2.setText("I�C�^");

      serviceAddProvisionStructuralRadioItem2.setGroup(getServiceAddProvisionStructuralRadioGroup());

      serviceAddProvisionStructuralRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

      addServiceAddProvisionStructuralRadioItem2();
    }
    return serviceAddProvisionStructuralRadioItem2;

  }

  /**
   * I���^���擾���܂��B
   * @return I���^
   */
  public ACRadioButtonItem getServiceAddProvisionStructuralRadioItem3(){
    if(serviceAddProvisionStructuralRadioItem3==null){

      serviceAddProvisionStructuralRadioItem3 = new ACRadioButtonItem();

      serviceAddProvisionStructuralRadioItem3.setText("I���^");

      serviceAddProvisionStructuralRadioItem3.setGroup(getServiceAddProvisionStructuralRadioGroup());

      serviceAddProvisionStructuralRadioItem3.setConstraints(VRLayout.FLOW);

      addServiceAddProvisionStructuralRadioItem3();
    }
    return serviceAddProvisionStructuralRadioItem3;

  }

  /**
   * II�^���擾���܂��B
   * @return II�^
   */
  public ACRadioButtonItem getServiceAddProvisionStructuralRadioItem4(){
    if(serviceAddProvisionStructuralRadioItem4==null){

      serviceAddProvisionStructuralRadioItem4 = new ACRadioButtonItem();

      serviceAddProvisionStructuralRadioItem4.setText("II�^");

      serviceAddProvisionStructuralRadioItem4.setGroup(getServiceAddProvisionStructuralRadioGroup());

      serviceAddProvisionStructuralRadioItem4.setConstraints(VRLayout.FLOW);

      addServiceAddProvisionStructuralRadioItem4();
    }
    return serviceAddProvisionStructuralRadioItem4;

  }

  /**
   * III�^���擾���܂��B
   * @return III�^
   */
  public ACRadioButtonItem getServiceAddProvisionStructuralRadioItem5(){
    if(serviceAddProvisionStructuralRadioItem5==null){

      serviceAddProvisionStructuralRadioItem5 = new ACRadioButtonItem();

      serviceAddProvisionStructuralRadioItem5.setText("III�^");

      serviceAddProvisionStructuralRadioItem5.setGroup(getServiceAddProvisionStructuralRadioGroup());

      serviceAddProvisionStructuralRadioItem5.setConstraints(VRLayout.FLOW);

      addServiceAddProvisionStructuralRadioItem5();
    }
    return serviceAddProvisionStructuralRadioItem5;

  }

  /**
   * �Z��敪���擾���܂��B
   * @return �Z��敪
   */
  public ACValueArrayRadioButtonGroup getCalculationDivisionRadio(){
    if(calculationDivisionRadio==null){

      calculationDivisionRadio = new ACValueArrayRadioButtonGroup();

      getCalculationDivisionRadioContainer().setText("�Z��敪");

      calculationDivisionRadio.setBindPath("9");

      calculationDivisionRadio.setUseClearButton(false);

      calculationDivisionRadio.setModel(getCalculationDivisionRadioModel());

      calculationDivisionRadio.setValues(new int[]{1,2});

      addCalculationDivisionRadio();
    }
    return calculationDivisionRadio;

  }

  /**
   * �Z��敪�R���e�i���擾���܂��B
   * @return �Z��敪�R���e�i
   */
  protected ACLabelContainer getCalculationDivisionRadioContainer(){
    if(calculationDivisionRadioContainer==null){
      calculationDivisionRadioContainer = new ACLabelContainer();
      calculationDivisionRadioContainer.setFollowChildEnabled(true);
      calculationDivisionRadioContainer.setVAlignment(VRLayout.CENTER);
      calculationDivisionRadioContainer.add(getCalculationDivisionRadio(), null);
    }
    return calculationDivisionRadioContainer;
  }

  /**
   * �Z��敪���f�����擾���܂��B
   * @return �Z��敪���f��
   */
  protected ACListModelAdapter getCalculationDivisionRadioModel(){
    if(calculationDivisionRadioModel==null){
      calculationDivisionRadioModel = new ACListModelAdapter();
      addCalculationDivisionRadioModel();
    }
    return calculationDivisionRadioModel;
  }

  /**
   * �ʏ���擾���܂��B
   * @return �ʏ�
   */
  public ACRadioButtonItem getCalculationDivisionRadioItem1(){
    if(calculationDivisionRadioItem1==null){

      calculationDivisionRadioItem1 = new ACRadioButtonItem();

      calculationDivisionRadioItem1.setText("�ʏ�");

      calculationDivisionRadioItem1.setGroup(getCalculationDivisionRadio());

      calculationDivisionRadioItem1.setConstraints(VRLayout.FLOW);

      addCalculationDivisionRadioItem1();
    }
    return calculationDivisionRadioItem1;

  }

  /**
   * ���Z�݂̂��擾���܂��B
   * @return ���Z�̂�
   */
  public ACRadioButtonItem getCalculationDivisionRadioItem2(){
    if(calculationDivisionRadioItem2==null){

      calculationDivisionRadioItem2 = new ACRadioButtonItem();

      calculationDivisionRadioItem2.setText("���Z�̂�");

      calculationDivisionRadioItem2.setGroup(getCalculationDivisionRadio());

      calculationDivisionRadioItem2.setConstraints(VRLayout.FLOW);

      addCalculationDivisionRadioItem2();
    }
    return calculationDivisionRadioItem2;

  }

  /**
   * �^�u�p�l��3���擾���܂��B
   * @return �^�u�p�l��3
   */
  public ACPanel getTabPanel3(){
    if(tabPanel3==null){

      tabPanel3 = new ACPanel();

      tabPanel3.setFollowChildEnabled(true);

      tabPanel3.setHgap(0);

      addTabPanel3();
    }
    return tabPanel3;

  }

  /**
   * �T�v�̈���擾���܂��B
   * @return �T�v�̈�
   */
  public ACPanel getServiceSettingPanel(){
    if(serviceSettingPanel==null){

      serviceSettingPanel = new ACPanel();

      serviceSettingPanel.setFollowChildEnabled(true);

      serviceSettingPanel.setHgap(0);

      serviceSettingPanel.setLabelMargin(0);

      serviceSettingPanel.setVgap(0);

      addServiceSettingPanel();
    }
    return serviceSettingPanel;

  }

  /**
   * �O���T�[�r�X���擾���܂��B
   * @return �O���T�[�r�X
   */
  public ACValueArrayRadioButtonGroup getOutsideServiceRadio(){
    if(outsideServiceRadio==null){

      outsideServiceRadio = new ACValueArrayRadioButtonGroup();

      getOutsideServiceRadioContainer().setText("�O���T�[�r�X");

      outsideServiceRadio.setBindPath("1330107");

      outsideServiceRadio.setUseClearButton(false);

      outsideServiceRadio.setModel(getOutsideServiceRadioModel());

      outsideServiceRadio.setValues(new int[]{9,1,2,3,4,5,6,7,8,10});

      addOutsideServiceRadio();
    }
    return outsideServiceRadio;

  }

  /**
   * �O���T�[�r�X�R���e�i���擾���܂��B
   * @return �O���T�[�r�X�R���e�i
   */
  protected ACLabelContainer getOutsideServiceRadioContainer(){
    if(outsideServiceRadioContainer==null){
      outsideServiceRadioContainer = new ACLabelContainer();
      outsideServiceRadioContainer.setFollowChildEnabled(true);
      outsideServiceRadioContainer.setVAlignment(VRLayout.CENTER);
      outsideServiceRadioContainer.add(getOutsideServiceRadio(), null);
    }
    return outsideServiceRadioContainer;
  }

  /**
   * �O���T�[�r�X���f�����擾���܂��B
   * @return �O���T�[�r�X���f��
   */
  protected ACListModelAdapter getOutsideServiceRadioModel(){
    if(outsideServiceRadioModel==null){
      outsideServiceRadioModel = new ACListModelAdapter();
      addOutsideServiceRadioModel();
    }
    return outsideServiceRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getOutsideServiceRadioItem0(){
    if(outsideServiceRadioItem0==null){

      outsideServiceRadioItem0 = new ACRadioButtonItem();

      outsideServiceRadioItem0.setText("�Ȃ�");

      outsideServiceRadioItem0.setGroup(getOutsideServiceRadio());

      outsideServiceRadioItem0.setConstraints(VRLayout.FLOW_RETURN);

      addOutsideServiceRadioItem0();
    }
    return outsideServiceRadioItem0;

  }

  /**
   * �K������擾���܂��B
   * @return �K����
   */
  public ACRadioButtonItem getOutsideServiceRadioItem1(){
    if(outsideServiceRadioItem1==null){

      outsideServiceRadioItem1 = new ACRadioButtonItem();

      outsideServiceRadioItem1.setText("�K����");

      outsideServiceRadioItem1.setGroup(getOutsideServiceRadio());

      outsideServiceRadioItem1.setConstraints(VRLayout.FLOW);

      addOutsideServiceRadioItem1();
    }
    return outsideServiceRadioItem1;

  }

  /**
   * �K����������擾���܂��B
   * @return �K��������
   */
  public ACRadioButtonItem getOutsideServiceRadioItem2(){
    if(outsideServiceRadioItem2==null){

      outsideServiceRadioItem2 = new ACRadioButtonItem();

      outsideServiceRadioItem2.setText("�K��������");

      outsideServiceRadioItem2.setGroup(getOutsideServiceRadio());

      outsideServiceRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

      addOutsideServiceRadioItem2();
    }
    return outsideServiceRadioItem2;

  }

  /**
   * �K��Ō���擾���܂��B
   * @return �K��Ō�
   */
  public ACRadioButtonItem getOutsideServiceRadioItem3(){
    if(outsideServiceRadioItem3==null){

      outsideServiceRadioItem3 = new ACRadioButtonItem();

      outsideServiceRadioItem3.setText("�K��Ō�");

      outsideServiceRadioItem3.setGroup(getOutsideServiceRadio());

      outsideServiceRadioItem3.setConstraints(VRLayout.FLOW);

      addOutsideServiceRadioItem3();
    }
    return outsideServiceRadioItem3;

  }

  /**
   * �K�⃊�n���擾���܂��B
   * @return �K�⃊�n
   */
  public ACRadioButtonItem getOutsideServiceRadioItem4(){
    if(outsideServiceRadioItem4==null){

      outsideServiceRadioItem4 = new ACRadioButtonItem();

      outsideServiceRadioItem4.setText("�K�⃊�n");

      outsideServiceRadioItem4.setGroup(getOutsideServiceRadio());

      outsideServiceRadioItem4.setConstraints(VRLayout.FLOW_RETURN);

      addOutsideServiceRadioItem4();
    }
    return outsideServiceRadioItem4;

  }

  /**
   * �ʏ������擾���܂��B
   * @return �ʏ����
   */
  public ACRadioButtonItem getOutsideServiceRadioItem5(){
    if(outsideServiceRadioItem5==null){

      outsideServiceRadioItem5 = new ACRadioButtonItem();

      outsideServiceRadioItem5.setText("�ʏ����");

      outsideServiceRadioItem5.setGroup(getOutsideServiceRadio());

      outsideServiceRadioItem5.setConstraints(VRLayout.FLOW);

      addOutsideServiceRadioItem5();
    }
    return outsideServiceRadioItem5;

  }

  /**
   * �ʏ����n���擾���܂��B
   * @return �ʏ����n
   */
  public ACRadioButtonItem getOutsideServiceRadioItem6(){
    if(outsideServiceRadioItem6==null){

      outsideServiceRadioItem6 = new ACRadioButtonItem();

      outsideServiceRadioItem6.setText("�ʏ����n");

      outsideServiceRadioItem6.setGroup(getOutsideServiceRadio());

      outsideServiceRadioItem6.setConstraints(VRLayout.FLOW_RETURN);

      addOutsideServiceRadioItem6();
    }
    return outsideServiceRadioItem6;

  }

  /**
   * �����p��ݗ^���擾���܂��B
   * @return �����p��ݗ^
   */
  public ACRadioButtonItem getOutsideServiceRadioItem7(){
    if(outsideServiceRadioItem7==null){

      outsideServiceRadioItem7 = new ACRadioButtonItem();

      outsideServiceRadioItem7.setText("�����p��ݗ^");

      outsideServiceRadioItem7.setGroup(getOutsideServiceRadio());

      outsideServiceRadioItem7.setConstraints(VRLayout.FLOW);

      addOutsideServiceRadioItem7();
    }
    return outsideServiceRadioItem7;

  }

  /**
   * �F�m�ǑΉ��ʏ������擾���܂��B
   * @return �F�m�ǑΉ��ʏ����
   */
  public ACRadioButtonItem getOutsideServiceRadioItem8(){
    if(outsideServiceRadioItem8==null){

      outsideServiceRadioItem8 = new ACRadioButtonItem();

      outsideServiceRadioItem8.setText("�F�m�ǑΉ��^�ʏ����");

      outsideServiceRadioItem8.setGroup(getOutsideServiceRadio());

      outsideServiceRadioItem8.setConstraints(VRLayout.FLOW_RETURN);

      addOutsideServiceRadioItem8();
    }
    return outsideServiceRadioItem8;

  }

  /**
   * �n�斧���^�ʏ������擾���܂��B
   * @return �n�斧���^�ʏ����
   */
  public ACRadioButtonItem getOutsideServiceRadioItem9(){
    if(outsideServiceRadioItem9==null){

      outsideServiceRadioItem9 = new ACRadioButtonItem();

      outsideServiceRadioItem9.setText("�n�斧���^�ʏ����");

      outsideServiceRadioItem9.setGroup(getOutsideServiceRadio());

      outsideServiceRadioItem9.setConstraints(VRLayout.FLOW);

      addOutsideServiceRadioItem9();
    }
    return outsideServiceRadioItem9;

  }

  /**
   * �񋟎��ԃR���e�i���擾���܂��B
   * @return �񋟎��ԃR���e�i
   */
  public ACBackLabelContainer getSpecificFacilityTimeContena(){
    if(specificFacilityTimeContena==null){

      specificFacilityTimeContena = new ACBackLabelContainer();

      specificFacilityTimeContena.setFollowChildEnabled(true);

      addSpecificFacilityTimeContena();
    }
    return specificFacilityTimeContena;

  }

  /**
   * �J�n�����R���{���擾���܂��B
   * @return �J�n�����R���{
   */
  public ACTimeComboBox getSpecificFacilityBeginTime(){
    if(specificFacilityBeginTime==null){

      specificFacilityBeginTime = new ACTimeComboBox();

      getSpecificFacilityBeginTimeContainer().setText("�J�n����");

      specificFacilityBeginTime.setBindPath("3");

      specificFacilityBeginTime.setModelBindPath("3");

      specificFacilityBeginTime.setRenderBindPath("CONTENT");

      specificFacilityBeginTime.setModel(getSpecificFacilityBeginTimeModel());

      addSpecificFacilityBeginTime();
    }
    return specificFacilityBeginTime;

  }

  /**
   * �J�n�����R���{�R���e�i���擾���܂��B
   * @return �J�n�����R���{�R���e�i
   */
  protected ACLabelContainer getSpecificFacilityBeginTimeContainer(){
    if(specificFacilityBeginTimeContainer==null){
      specificFacilityBeginTimeContainer = new ACLabelContainer();
      specificFacilityBeginTimeContainer.setFollowChildEnabled(true);
      specificFacilityBeginTimeContainer.setVAlignment(VRLayout.CENTER);
      specificFacilityBeginTimeContainer.add(getSpecificFacilityBeginTime(), null);
    }
    return specificFacilityBeginTimeContainer;
  }

  /**
   * �J�n�����R���{���f�����擾���܂��B
   * @return �J�n�����R���{���f��
   */
  protected ACComboBoxModelAdapter getSpecificFacilityBeginTimeModel(){
    if(specificFacilityBeginTimeModel==null){
      specificFacilityBeginTimeModel = new ACComboBoxModelAdapter();
      addSpecificFacilityBeginTimeModel();
    }
    return specificFacilityBeginTimeModel;
  }

  /**
   * �I�������R���{���擾���܂��B
   * @return �I�������R���{
   */
  public ACTimeComboBox getSpecificFacilityEndTime(){
    if(specificFacilityEndTime==null){

      specificFacilityEndTime = new ACTimeComboBox();

      getSpecificFacilityEndTimeContainer().setText("�I������");

      specificFacilityEndTime.setBindPath("4");

      specificFacilityEndTime.setModelBindPath("4");

      specificFacilityEndTime.setRenderBindPath("CONTENT");

      specificFacilityEndTime.setModel(getSpecificFacilityEndTimeModel());

      addSpecificFacilityEndTime();
    }
    return specificFacilityEndTime;

  }

  /**
   * �I�������R���{�R���e�i���擾���܂��B
   * @return �I�������R���{�R���e�i
   */
  protected ACLabelContainer getSpecificFacilityEndTimeContainer(){
    if(specificFacilityEndTimeContainer==null){
      specificFacilityEndTimeContainer = new ACLabelContainer();
      specificFacilityEndTimeContainer.setFollowChildEnabled(true);
      specificFacilityEndTimeContainer.setVAlignment(VRLayout.CENTER);
      specificFacilityEndTimeContainer.add(getSpecificFacilityEndTime(), null);
    }
    return specificFacilityEndTimeContainer;
  }

  /**
   * �I�������R���{���f�����擾���܂��B
   * @return �I�������R���{���f��
   */
  protected ACComboBoxModelAdapter getSpecificFacilityEndTimeModel(){
    if(specificFacilityEndTimeModel==null){
      specificFacilityEndTimeModel = new ACComboBoxModelAdapter();
      addSpecificFacilityEndTimeModel();
    }
    return specificFacilityEndTimeModel;
  }

  /**
   * �K����O���[�v���擾���܂��B
   * @return �K����O���[�v
   */
  public ACGroupBox getVisitCareGroup(){
    if(visitCareGroup==null){

      visitCareGroup = new ACGroupBox();

      visitCareGroup.setText("�K����");

      visitCareGroup.setFollowChildEnabled(true);

      addVisitCareGroup();
    }
    return visitCareGroup;

  }

  /**
   * �K������擾���܂��B
   * @return �K����
   */
  public ACValueArrayRadioButtonGroup getVisitCareRadio(){
    if(visitCareRadio==null){

      visitCareRadio = new ACValueArrayRadioButtonGroup();

      getVisitCareRadioContainer().setText("���");

      visitCareRadio.setBindPath("1330108");

      visitCareRadio.setUseClearButton(false);

      visitCareRadio.setModel(getVisitCareRadioModel());

      visitCareRadio.setValues(new int[]{1,2,3});

      addVisitCareRadio();
    }
    return visitCareRadio;

  }

  /**
   * �K����R���e�i���擾���܂��B
   * @return �K����R���e�i
   */
  protected ACLabelContainer getVisitCareRadioContainer(){
    if(visitCareRadioContainer==null){
      visitCareRadioContainer = new ACLabelContainer();
      visitCareRadioContainer.setFollowChildEnabled(true);
      visitCareRadioContainer.setVAlignment(VRLayout.CENTER);
      visitCareRadioContainer.add(getVisitCareRadio(), null);
    }
    return visitCareRadioContainer;
  }

  /**
   * �K���샂�f�����擾���܂��B
   * @return �K���샂�f��
   */
  protected ACListModelAdapter getVisitCareRadioModel(){
    if(visitCareRadioModel==null){
      visitCareRadioModel = new ACListModelAdapter();
      addVisitCareRadioModel();
    }
    return visitCareRadioModel;
  }

  /**
   * �g�̉�쒆�S���擾���܂��B
   * @return �g�̉�쒆�S
   */
  public ACRadioButtonItem getVisitCareRadioItem1(){
    if(visitCareRadioItem1==null){

      visitCareRadioItem1 = new ACRadioButtonItem();

      visitCareRadioItem1.setText("�g�̉�쒆�S");

      visitCareRadioItem1.setGroup(getVisitCareRadio());

      visitCareRadioItem1.setConstraints(VRLayout.FLOW);

      addVisitCareRadioItem1();
    }
    return visitCareRadioItem1;

  }

  /**
   * �����������S���擾���܂��B
   * @return �����������S
   */
  public ACRadioButtonItem getVisitCareRadioItem2(){
    if(visitCareRadioItem2==null){

      visitCareRadioItem2 = new ACRadioButtonItem();

      visitCareRadioItem2.setText("�����������S");

      visitCareRadioItem2.setGroup(getVisitCareRadio());

      visitCareRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

      addVisitCareRadioItem2();
    }
    return visitCareRadioItem2;

  }

  /**
   * �ʉ@����~����擾���܂��B
   * @return �ʉ@����~�
   */
  public ACRadioButtonItem getVisitCareRadioItem3(){
    if(visitCareRadioItem3==null){

      visitCareRadioItem3 = new ACRadioButtonItem();

      visitCareRadioItem3.setText("�ʉ@����~�");

      visitCareRadioItem3.setGroup(getVisitCareRadio());

      visitCareRadioItem3.setConstraints(VRLayout.FLOW);

      addVisitCareRadioItem3();
    }
    return visitCareRadioItem3;

  }

  /**
   * ���ԋ敪�R���{���擾���܂��B
   * @return ���ԋ敪�R���{
   */
  public ACComboBox getVisitCareCombo(){
    if(visitCareCombo==null){

      visitCareCombo = new ACComboBox();

      getVisitCareComboContainer().setText("���ԋ敪");

      visitCareCombo.setBindPath("1330109");

      visitCareCombo.setEditable(false);

      visitCareCombo.setModelBindPath("1330109");

      visitCareCombo.setRenderBindPath("CONTENT");

      visitCareCombo.setModel(getVisitCareComboModel());

      addVisitCareCombo();
    }
    return visitCareCombo;

  }

  /**
   * ���ԋ敪�R���{�R���e�i���擾���܂��B
   * @return ���ԋ敪�R���{�R���e�i
   */
  protected ACLabelContainer getVisitCareComboContainer(){
    if(visitCareComboContainer==null){
      visitCareComboContainer = new ACLabelContainer();
      visitCareComboContainer.setFollowChildEnabled(true);
      visitCareComboContainer.setVAlignment(VRLayout.CENTER);
      visitCareComboContainer.add(getVisitCareCombo(), null);
    }
    return visitCareComboContainer;
  }

  /**
   * ���ԋ敪�R���{���f�����擾���܂��B
   * @return ���ԋ敪�R���{���f��
   */
  protected ACComboBoxModelAdapter getVisitCareComboModel(){
    if(visitCareComboModel==null){
      visitCareComboModel = new ACComboBoxModelAdapter();
      addVisitCareComboModel();
    }
    return visitCareComboModel;
  }

  /**
   * �^�u�p�l��4���擾���܂��B
   * @return �^�u�p�l��4
   */
  public ACPanel getTabPanel4(){
    if(tabPanel4==null){

      tabPanel4 = new ACPanel();

      tabPanel4.setFollowChildEnabled(true);

      tabPanel4.setHgap(0);

      addTabPanel4();
    }
    return tabPanel4;

  }

  /**
   * �K��Ō���擾���܂��B
   * @return �K��Ō�
   */
  public ACGroupBox getVisitNursingRadioGroup(){
    if(visitNursingRadioGroup==null){

      visitNursingRadioGroup = new ACGroupBox();

      visitNursingRadioGroup.setText("�K��Ō�");

      visitNursingRadioGroup.setFollowChildEnabled(true);

      addVisitNursingRadioGroup();
    }
    return visitNursingRadioGroup;

  }

  /**
   * �{�ݓ��̋敪���擾���܂��B
   * @return �{�ݓ��̋敪
   */
  public ACValueArrayRadioButtonGroup getVisitNursingFacilitiesDivisionRadio(){
    if(visitNursingFacilitiesDivisionRadio==null){

      visitNursingFacilitiesDivisionRadio = new ACValueArrayRadioButtonGroup();

      getVisitNursingFacilitiesDivisionRadioContainer().setText("�{�ݓ��̋敪");

      visitNursingFacilitiesDivisionRadio.setBindPath("1330110");

      visitNursingFacilitiesDivisionRadio.setUseClearButton(false);

      visitNursingFacilitiesDivisionRadio.setModel(getVisitNursingFacilitiesDivisionRadioModel());

      visitNursingFacilitiesDivisionRadio.setValues(new int[]{1,2});

      addVisitNursingFacilitiesDivisionRadio();
    }
    return visitNursingFacilitiesDivisionRadio;

  }

  /**
   * �{�ݓ��̋敪�R���e�i���擾���܂��B
   * @return �{�ݓ��̋敪�R���e�i
   */
  protected ACLabelContainer getVisitNursingFacilitiesDivisionRadioContainer(){
    if(visitNursingFacilitiesDivisionRadioContainer==null){
      visitNursingFacilitiesDivisionRadioContainer = new ACLabelContainer();
      visitNursingFacilitiesDivisionRadioContainer.setFollowChildEnabled(true);
      visitNursingFacilitiesDivisionRadioContainer.setVAlignment(VRLayout.CENTER);
      visitNursingFacilitiesDivisionRadioContainer.add(getVisitNursingFacilitiesDivisionRadio(), null);
    }
    return visitNursingFacilitiesDivisionRadioContainer;
  }

  /**
   * �{�ݓ��̋敪���f�����擾���܂��B
   * @return �{�ݓ��̋敪���f��
   */
  protected ACListModelAdapter getVisitNursingFacilitiesDivisionRadioModel(){
    if(visitNursingFacilitiesDivisionRadioModel==null){
      visitNursingFacilitiesDivisionRadioModel = new ACListModelAdapter();
      addVisitNursingFacilitiesDivisionRadioModel();
    }
    return visitNursingFacilitiesDivisionRadioModel;
  }

  /**
   * �K��Ō�X�e�[�V�������擾���܂��B
   * @return �K��Ō�X�e�[�V����
   */
  public ACRadioButtonItem getVisitNursingFacilitiesDivisionRadioItem1(){
    if(visitNursingFacilitiesDivisionRadioItem1==null){

      visitNursingFacilitiesDivisionRadioItem1 = new ACRadioButtonItem();

      visitNursingFacilitiesDivisionRadioItem1.setText("�K��Ō�X�e�[�V����");

      visitNursingFacilitiesDivisionRadioItem1.setGroup(getVisitNursingFacilitiesDivisionRadio());

      visitNursingFacilitiesDivisionRadioItem1.setConstraints(VRLayout.FLOW_RETURN);

      addVisitNursingFacilitiesDivisionRadioItem1();
    }
    return visitNursingFacilitiesDivisionRadioItem1;

  }

  /**
   * �a�@���͐f�Ï����擾���܂��B
   * @return �a�@���͐f�Ï�
   */
  public ACRadioButtonItem getVisitNursingFacilitiesDivisionRadioItem2(){
    if(visitNursingFacilitiesDivisionRadioItem2==null){

      visitNursingFacilitiesDivisionRadioItem2 = new ACRadioButtonItem();

      visitNursingFacilitiesDivisionRadioItem2.setText("�a�@���͐f�Ï�");

      visitNursingFacilitiesDivisionRadioItem2.setGroup(getVisitNursingFacilitiesDivisionRadio());

      visitNursingFacilitiesDivisionRadioItem2.setConstraints(VRLayout.FLOW);

      addVisitNursingFacilitiesDivisionRadioItem2();
    }
    return visitNursingFacilitiesDivisionRadioItem2;

  }

  /**
   * �E���敪���擾���܂��B
   * @return �E���敪
   */
  public ACValueArrayRadioButtonGroup getVisitNursingStaffDivisionRadio(){
    if(visitNursingStaffDivisionRadio==null){

      visitNursingStaffDivisionRadio = new ACValueArrayRadioButtonGroup();

      getVisitNursingStaffDivisionRadioContainer().setText("�E���敪");

      visitNursingStaffDivisionRadio.setBindPath("1330111");

      visitNursingStaffDivisionRadio.setUseClearButton(false);

      visitNursingStaffDivisionRadio.setModel(getVisitNursingStaffDivisionRadioModel());

      visitNursingStaffDivisionRadio.setValues(new int[]{1,2});

      addVisitNursingStaffDivisionRadio();
    }
    return visitNursingStaffDivisionRadio;

  }

  /**
   * �E���敪�R���e�i���擾���܂��B
   * @return �E���敪�R���e�i
   */
  protected ACLabelContainer getVisitNursingStaffDivisionRadioContainer(){
    if(visitNursingStaffDivisionRadioContainer==null){
      visitNursingStaffDivisionRadioContainer = new ACLabelContainer();
      visitNursingStaffDivisionRadioContainer.setFollowChildEnabled(true);
      visitNursingStaffDivisionRadioContainer.setVAlignment(VRLayout.CENTER);
      visitNursingStaffDivisionRadioContainer.add(getVisitNursingStaffDivisionRadio(), null);
    }
    return visitNursingStaffDivisionRadioContainer;
  }

  /**
   * �E���敪���f�����擾���܂��B
   * @return �E���敪���f��
   */
  protected ACListModelAdapter getVisitNursingStaffDivisionRadioModel(){
    if(visitNursingStaffDivisionRadioModel==null){
      visitNursingStaffDivisionRadioModel = new ACListModelAdapter();
      addVisitNursingStaffDivisionRadioModel();
    }
    return visitNursingStaffDivisionRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getVisitNursingStaffDivisionRadioItem1(){
    if(visitNursingStaffDivisionRadioItem1==null){

      visitNursingStaffDivisionRadioItem1 = new ACRadioButtonItem();

      visitNursingStaffDivisionRadioItem1.setText("�Ȃ�");

      visitNursingStaffDivisionRadioItem1.setGroup(getVisitNursingStaffDivisionRadio());

      visitNursingStaffDivisionRadioItem1.setConstraints(VRLayout.FLOW);

      addVisitNursingStaffDivisionRadioItem1();
    }
    return visitNursingStaffDivisionRadioItem1;

  }

  /**
   * PT,OT,ST���擾���܂��B
   * @return PT,OT,ST
   */
  public ACRadioButtonItem getVisitNursingStaffDivisionRadioItem2(){
    if(visitNursingStaffDivisionRadioItem2==null){

      visitNursingStaffDivisionRadioItem2 = new ACRadioButtonItem();

      visitNursingStaffDivisionRadioItem2.setText("PT,OT,ST");

      visitNursingStaffDivisionRadioItem2.setGroup(getVisitNursingStaffDivisionRadio());

      visitNursingStaffDivisionRadioItem2.setConstraints(VRLayout.FLOW);

      addVisitNursingStaffDivisionRadioItem2();
    }
    return visitNursingStaffDivisionRadioItem2;

  }

  /**
   * 1����2����z���Ď��{���擾���܂��B
   * @return 1����2����z���Ď��{
   */
  public ACIntegerCheckBox getTwoOrMoreTimesCheck(){
    if(twoOrMoreTimesCheck==null){

      twoOrMoreTimesCheck = new ACIntegerCheckBox();

      twoOrMoreTimesCheck.setText("1����2����z���Ď��{");

      twoOrMoreTimesCheck.setBindPath("1330129");

      twoOrMoreTimesCheck.setSelectValue(2);

      twoOrMoreTimesCheck.setUnSelectValue(1);

      addTwoOrMoreTimesCheck();
    }
    return twoOrMoreTimesCheck;

  }

  /**
   * ���ԋ敪�R���{���擾���܂��B
   * @return ���ԋ敪�R���{
   */
  public ACComboBox getVisitNursingCombo(){
    if(visitNursingCombo==null){

      visitNursingCombo = new ACComboBox();

      getVisitNursingComboContainer().setText("���ԋ敪");

      visitNursingCombo.setBindPath("1330112");

      visitNursingCombo.setEditable(false);

      visitNursingCombo.setModelBindPath("1330112");

      visitNursingCombo.setRenderBindPath("CONTENT");

      visitNursingCombo.setModel(getVisitNursingComboModel());

      addVisitNursingCombo();
    }
    return visitNursingCombo;

  }

  /**
   * ���ԋ敪�R���{�R���e�i���擾���܂��B
   * @return ���ԋ敪�R���{�R���e�i
   */
  protected ACLabelContainer getVisitNursingComboContainer(){
    if(visitNursingComboContainer==null){
      visitNursingComboContainer = new ACLabelContainer();
      visitNursingComboContainer.setFollowChildEnabled(true);
      visitNursingComboContainer.setVAlignment(VRLayout.CENTER);
      visitNursingComboContainer.add(getVisitNursingCombo(), null);
    }
    return visitNursingComboContainer;
  }

  /**
   * ���ԋ敪�R���{���f�����擾���܂��B
   * @return ���ԋ敪�R���{���f��
   */
  protected ACComboBoxModelAdapter getVisitNursingComboModel(){
    if(visitNursingComboModel==null){
      visitNursingComboModel = new ACComboBoxModelAdapter();
      addVisitNursingComboModel();
    }
    return visitNursingComboModel;
  }

  /**
   * �Ō�E���敪���擾���܂��B
   * @return �Ō�E���敪
   */
  public ACValueArrayRadioButtonGroup getNurseStaffDivisionRadioGroup(){
    if(nurseStaffDivisionRadioGroup==null){

      nurseStaffDivisionRadioGroup = new ACValueArrayRadioButtonGroup();

      getNurseStaffDivisionRadioGroupContainer().setText("�Ō�E���敪");

      nurseStaffDivisionRadioGroup.setBindPath("1330132");

      nurseStaffDivisionRadioGroup.setUseClearButton(false);

      nurseStaffDivisionRadioGroup.setModel(getNurseStaffDivisionRadioGroupModel());

      nurseStaffDivisionRadioGroup.setValues(new int[]{1,2});

      addNurseStaffDivisionRadioGroup();
    }
    return nurseStaffDivisionRadioGroup;

  }

  /**
   * �Ō�E���敪�R���e�i���擾���܂��B
   * @return �Ō�E���敪�R���e�i
   */
  protected ACLabelContainer getNurseStaffDivisionRadioGroupContainer(){
    if(nurseStaffDivisionRadioGroupContainer==null){
      nurseStaffDivisionRadioGroupContainer = new ACLabelContainer();
      nurseStaffDivisionRadioGroupContainer.setFollowChildEnabled(true);
      nurseStaffDivisionRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      nurseStaffDivisionRadioGroupContainer.add(getNurseStaffDivisionRadioGroup(), null);
    }
    return nurseStaffDivisionRadioGroupContainer;
  }

  /**
   * �Ō�E���敪���f�����擾���܂��B
   * @return �Ō�E���敪���f��
   */
  protected ACListModelAdapter getNurseStaffDivisionRadioGroupModel(){
    if(nurseStaffDivisionRadioGroupModel==null){
      nurseStaffDivisionRadioGroupModel = new ACListModelAdapter();
      addNurseStaffDivisionRadioGroupModel();
    }
    return nurseStaffDivisionRadioGroupModel;
  }

  /**
   * ���œ����擾���܂��B
   * @return ���œ�
   */
  public ACRadioButtonItem getNurseStaffDivisionRadioItem1(){
    if(nurseStaffDivisionRadioItem1==null){

      nurseStaffDivisionRadioItem1 = new ACRadioButtonItem();

      nurseStaffDivisionRadioItem1.setText("���œ�");

      nurseStaffDivisionRadioItem1.setGroup(getNurseStaffDivisionRadioGroup());

      nurseStaffDivisionRadioItem1.setConstraints(VRLayout.FLOW);

      addNurseStaffDivisionRadioItem1();
    }
    return nurseStaffDivisionRadioItem1;

  }

  /**
   * �y�ł��擾���܂��B
   * @return �y��
   */
  public ACRadioButtonItem getNurseStaffDivisionRadioItem2(){
    if(nurseStaffDivisionRadioItem2==null){

      nurseStaffDivisionRadioItem2 = new ACRadioButtonItem();

      nurseStaffDivisionRadioItem2.setText("�y��");

      nurseStaffDivisionRadioItem2.setGroup(getNurseStaffDivisionRadioGroup());

      nurseStaffDivisionRadioItem2.setConstraints(VRLayout.FLOW);

      addNurseStaffDivisionRadioItem2();
    }
    return nurseStaffDivisionRadioItem2;

  }

  /**
   * �K�⃊�n�O���[�v���擾���܂��B
   * @return �K�⃊�n�O���[�v
   */
  public ACGroupBox getVisitRehabiliGroup(){
    if(visitRehabiliGroup==null){

      visitRehabiliGroup = new ACGroupBox();

      visitRehabiliGroup.setText("�K�⃊�n");

      visitRehabiliGroup.setFollowChildEnabled(true);

      addVisitRehabiliGroup();
    }
    return visitRehabiliGroup;

  }

  /**
   * �{�ݓ��̋敪���擾���܂��B
   * @return �{�ݓ��̋敪
   */
  public ACValueArrayRadioButtonGroup getVisitRehabiliRadio(){
    if(visitRehabiliRadio==null){

      visitRehabiliRadio = new ACValueArrayRadioButtonGroup();

      getVisitRehabiliRadioContainer().setText("�{�ݓ��̋敪");

      visitRehabiliRadio.setBindPath("1330113");

      visitRehabiliRadio.setUseClearButton(false);

      visitRehabiliRadio.setModel(getVisitRehabiliRadioModel());

      visitRehabiliRadio.setValues(new int[]{1,2});

      addVisitRehabiliRadio();
    }
    return visitRehabiliRadio;

  }

  /**
   * �{�ݓ��̋敪�R���e�i���擾���܂��B
   * @return �{�ݓ��̋敪�R���e�i
   */
  protected ACLabelContainer getVisitRehabiliRadioContainer(){
    if(visitRehabiliRadioContainer==null){
      visitRehabiliRadioContainer = new ACLabelContainer();
      visitRehabiliRadioContainer.setFollowChildEnabled(true);
      visitRehabiliRadioContainer.setVAlignment(VRLayout.CENTER);
      visitRehabiliRadioContainer.add(getVisitRehabiliRadio(), null);
    }
    return visitRehabiliRadioContainer;
  }

  /**
   * �{�ݓ��̋敪���f�����擾���܂��B
   * @return �{�ݓ��̋敪���f��
   */
  protected ACListModelAdapter getVisitRehabiliRadioModel(){
    if(visitRehabiliRadioModel==null){
      visitRehabiliRadioModel = new ACListModelAdapter();
      addVisitRehabiliRadioModel();
    }
    return visitRehabiliRadioModel;
  }

  /**
   * �a�@���͐f�Ï����擾���܂��B
   * @return �a�@���͐f�Ï�
   */
  public ACRadioButtonItem getVisitRehabiliRadioItem1(){
    if(visitRehabiliRadioItem1==null){

      visitRehabiliRadioItem1 = new ACRadioButtonItem();

      visitRehabiliRadioItem1.setText("�a�@���͐f�Ï�");

      visitRehabiliRadioItem1.setGroup(getVisitRehabiliRadio());

      visitRehabiliRadioItem1.setConstraints(VRLayout.FLOW_RETURN);

      addVisitRehabiliRadioItem1();
    }
    return visitRehabiliRadioItem1;

  }

  /**
   * ���V�l�ی��{�݂��擾���܂��B
   * @return ���V�l�ی��{��
   */
  public ACRadioButtonItem getVisitRehabiliRadioItem2(){
    if(visitRehabiliRadioItem2==null){

      visitRehabiliRadioItem2 = new ACRadioButtonItem();

      visitRehabiliRadioItem2.setText("���V�l�ی��{��");

      visitRehabiliRadioItem2.setGroup(getVisitRehabiliRadio());

      visitRehabiliRadioItem2.setConstraints(VRLayout.FLOW);

      addVisitRehabiliRadioItem2();
    }
    return visitRehabiliRadioItem2;

  }

  /**
   * �^�u�p�l��5���擾���܂��B
   * @return �^�u�p�l��5
   */
  public ACPanel getTabPanel5(){
    if(tabPanel5==null){

      tabPanel5 = new ACPanel();

      tabPanel5.setFollowChildEnabled(true);

      tabPanel5.setHgap(0);

      addTabPanel5();
    }
    return tabPanel5;

  }

  /**
   * �ʏ����O���[�v���擾���܂��B
   * @return �ʏ����O���[�v
   */
  public ACGroupBox getExpertPlaceNursingGroup(){
    if(expertPlaceNursingGroup==null){

      expertPlaceNursingGroup = new ACGroupBox();

      expertPlaceNursingGroup.setText("�ʏ����");

      expertPlaceNursingGroup.setFollowChildEnabled(true);

      addExpertPlaceNursingGroup();
    }
    return expertPlaceNursingGroup;

  }

  /**
   * �{�ݓ��̋敪���擾���܂��B
   * @return �{�ݓ��̋敪
   */
  public ACValueArrayRadioButtonGroup getExpertPlaceNursingRadio(){
    if(expertPlaceNursingRadio==null){

      expertPlaceNursingRadio = new ACValueArrayRadioButtonGroup();

      getExpertPlaceNursingRadioContainer().setText("�{�ݓ��̋敪");

      expertPlaceNursingRadio.setBindPath("1330126");

      expertPlaceNursingRadio.setUseClearButton(false);

      expertPlaceNursingRadio.setModel(getExpertPlaceNursingRadioModel());

      expertPlaceNursingRadio.setValues(new int[]{1,2,3,4,5});

      addExpertPlaceNursingRadio();
    }
    return expertPlaceNursingRadio;

  }

  /**
   * �{�ݓ��̋敪�R���e�i���擾���܂��B
   * @return �{�ݓ��̋敪�R���e�i
   */
  protected ACLabelContainer getExpertPlaceNursingRadioContainer(){
    if(expertPlaceNursingRadioContainer==null){
      expertPlaceNursingRadioContainer = new ACLabelContainer();
      expertPlaceNursingRadioContainer.setFollowChildEnabled(true);
      expertPlaceNursingRadioContainer.setVAlignment(VRLayout.CENTER);
      expertPlaceNursingRadioContainer.add(getExpertPlaceNursingRadio(), null);
    }
    return expertPlaceNursingRadioContainer;
  }

  /**
   * �{�ݓ��̋敪���f�����擾���܂��B
   * @return �{�ݓ��̋敪���f��
   */
  protected ACListModelAdapter getExpertPlaceNursingRadioModel(){
    if(expertPlaceNursingRadioModel==null){
      expertPlaceNursingRadioModel = new ACListModelAdapter();
      addExpertPlaceNursingRadioModel();
    }
    return expertPlaceNursingRadioModel;
  }

  /**
   * ���K�͎��Ə����擾���܂��B
   * @return ���K�͎��Ə�
   */
  public ACRadioButtonItem getExpertPlaceNursingRadioItem1(){
    if(expertPlaceNursingRadioItem1==null){

      expertPlaceNursingRadioItem1 = new ACRadioButtonItem();

      expertPlaceNursingRadioItem1.setText("���K�͎��Ə��iH28.4�p�~�j");

      expertPlaceNursingRadioItem1.setGroup(getExpertPlaceNursingRadio());

      expertPlaceNursingRadioItem1.setConstraints(VRLayout.FLOW_RETURN);

      addExpertPlaceNursingRadioItem1();
    }
    return expertPlaceNursingRadioItem1;

  }

  /**
   * �ʏ�K�͎��Ə����擾���܂��B
   * @return �ʏ�K�͎��Ə�
   */
  public ACRadioButtonItem getExpertPlaceNursingRadioItem2(){
    if(expertPlaceNursingRadioItem2==null){

      expertPlaceNursingRadioItem2 = new ACRadioButtonItem();

      expertPlaceNursingRadioItem2.setText("�ʏ�K�͎��Ə�");

      expertPlaceNursingRadioItem2.setGroup(getExpertPlaceNursingRadio());

      expertPlaceNursingRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

      addExpertPlaceNursingRadioItem2();
    }
    return expertPlaceNursingRadioItem2;

  }

  /**
   * ��K�͎��Ə� I���擾���܂��B
   * @return ��K�͎��Ə� I
   */
  public ACRadioButtonItem getExpertPlaceNursingRadioItem3(){
    if(expertPlaceNursingRadioItem3==null){

      expertPlaceNursingRadioItem3 = new ACRadioButtonItem();

      expertPlaceNursingRadioItem3.setText("��K�͎��Ə� I");

      expertPlaceNursingRadioItem3.setGroup(getExpertPlaceNursingRadio());

      expertPlaceNursingRadioItem3.setConstraints(VRLayout.FLOW_RETURN);

      addExpertPlaceNursingRadioItem3();
    }
    return expertPlaceNursingRadioItem3;

  }

  /**
   * ��K�͎��Ə� II���擾���܂��B
   * @return ��K�͎��Ə� II
   */
  public ACRadioButtonItem getExpertPlaceNursingRadioItem4(){
    if(expertPlaceNursingRadioItem4==null){

      expertPlaceNursingRadioItem4 = new ACRadioButtonItem();

      expertPlaceNursingRadioItem4.setText("��K�͎��Ə� II");

      expertPlaceNursingRadioItem4.setGroup(getExpertPlaceNursingRadio());

      expertPlaceNursingRadioItem4.setConstraints(VRLayout.FLOW_RETURN);

      addExpertPlaceNursingRadioItem4();
    }
    return expertPlaceNursingRadioItem4;

  }

  /**
   * �×{�ʏ����擾���܂��B
   * @return �×{�ʏ�
   */
  public ACRadioButtonItem getExpertPlaceNursingRadioItem5(){
    if(expertPlaceNursingRadioItem5==null){

      expertPlaceNursingRadioItem5 = new ACRadioButtonItem();

      expertPlaceNursingRadioItem5.setText("�×{�ʏ��iH28.4�p�~�j");

      expertPlaceNursingRadioItem5.setGroup(getExpertPlaceNursingRadio());

      expertPlaceNursingRadioItem5.setConstraints(VRLayout.FLOW);

      addExpertPlaceNursingRadioItem5();
    }
    return expertPlaceNursingRadioItem5;

  }

  /**
   * ���ԋ敪�R���{���擾���܂��B
   * @return ���ԋ敪�R���{
   */
  public ACComboBox getExpertPlaceNursingCombo(){
    if(expertPlaceNursingCombo==null){

      expertPlaceNursingCombo = new ACComboBox();

      getExpertPlaceNursingComboContainer().setText("���ԋ敪");

      expertPlaceNursingCombo.setBindPath("1330115");

      expertPlaceNursingCombo.setEditable(false);

      expertPlaceNursingCombo.setModelBindPath("1330115");

      expertPlaceNursingCombo.setRenderBindPath("CONTENT");

      expertPlaceNursingCombo.setModel(getExpertPlaceNursingComboModel());

      addExpertPlaceNursingCombo();
    }
    return expertPlaceNursingCombo;

  }

  /**
   * ���ԋ敪�R���{�R���e�i���擾���܂��B
   * @return ���ԋ敪�R���{�R���e�i
   */
  protected ACLabelContainer getExpertPlaceNursingComboContainer(){
    if(expertPlaceNursingComboContainer==null){
      expertPlaceNursingComboContainer = new ACLabelContainer();
      expertPlaceNursingComboContainer.setFollowChildEnabled(true);
      expertPlaceNursingComboContainer.setVAlignment(VRLayout.CENTER);
      expertPlaceNursingComboContainer.add(getExpertPlaceNursingCombo(), null);
    }
    return expertPlaceNursingComboContainer;
  }

  /**
   * ���ԋ敪�R���{���f�����擾���܂��B
   * @return ���ԋ敪�R���{���f��
   */
  protected ACComboBoxModelAdapter getExpertPlaceNursingComboModel(){
    if(expertPlaceNursingComboModel==null){
      expertPlaceNursingComboModel = new ACComboBoxModelAdapter();
      addExpertPlaceNursingComboModel();
    }
    return expertPlaceNursingComboModel;
  }

  /**
   * �^�u�p�l��6���擾���܂��B
   * @return �^�u�p�l��6
   */
  public ACPanel getTabPanel6(){
    if(tabPanel6==null){

      tabPanel6 = new ACPanel();

      tabPanel6.setFollowChildEnabled(true);

      tabPanel6.setHgap(0);

      addTabPanel6();
    }
    return tabPanel6;

  }

  /**
   * �ʏ����n�O���[�v���擾���܂��B
   * @return �ʏ����n�O���[�v
   */
  public ACGroupBox getExpertPlaceRehabiliGroup(){
    if(expertPlaceRehabiliGroup==null){

      expertPlaceRehabiliGroup = new ACGroupBox();

      expertPlaceRehabiliGroup.setText("�ʏ����n");

      expertPlaceRehabiliGroup.setFollowChildEnabled(true);

      addExpertPlaceRehabiliGroup();
    }
    return expertPlaceRehabiliGroup;

  }

  /**
   * �{�ݓ��̋敪���擾���܂��B
   * @return �{�ݓ��̋敪
   */
  public ACValueArrayRadioButtonGroup getExpertPlaceRehabiliRadio(){
    if(expertPlaceRehabiliRadio==null){

      expertPlaceRehabiliRadio = new ACValueArrayRadioButtonGroup();

      getExpertPlaceRehabiliRadioContainer().setText("�{�ݓ��̋敪");

      expertPlaceRehabiliRadio.setBindPath("1330127");

      expertPlaceRehabiliRadio.setUseClearButton(false);

      expertPlaceRehabiliRadio.setModel(getExpertPlaceRehabiliRadioModel());

      expertPlaceRehabiliRadio.setValues(new int[]{1,2,3,4,5,6});

      addExpertPlaceRehabiliRadio();
    }
    return expertPlaceRehabiliRadio;

  }

  /**
   * �{�ݓ��̋敪�R���e�i���擾���܂��B
   * @return �{�ݓ��̋敪�R���e�i
   */
  protected ACLabelContainer getExpertPlaceRehabiliRadioContainer(){
    if(expertPlaceRehabiliRadioContainer==null){
      expertPlaceRehabiliRadioContainer = new ACLabelContainer();
      expertPlaceRehabiliRadioContainer.setFollowChildEnabled(true);
      expertPlaceRehabiliRadioContainer.setVAlignment(VRLayout.CENTER);
      expertPlaceRehabiliRadioContainer.add(getExpertPlaceRehabiliRadio(), null);
    }
    return expertPlaceRehabiliRadioContainer;
  }

  /**
   * �{�ݓ��̋敪���f�����擾���܂��B
   * @return �{�ݓ��̋敪���f��
   */
  protected ACListModelAdapter getExpertPlaceRehabiliRadioModel(){
    if(expertPlaceRehabiliRadioModel==null){
      expertPlaceRehabiliRadioModel = new ACListModelAdapter();
      addExpertPlaceRehabiliRadioModel();
    }
    return expertPlaceRehabiliRadioModel;
  }

  /**
   * �ʏ�K�͎��Ə��i�a�@�E�f�Ï��j���擾���܂��B
   * @return �ʏ�K�͎��Ə��i�a�@�E�f�Ï��j
   */
  public ACRadioButtonItem getExpertPlaceRehabiliRadioItem1(){
    if(expertPlaceRehabiliRadioItem1==null){

      expertPlaceRehabiliRadioItem1 = new ACRadioButtonItem();

      expertPlaceRehabiliRadioItem1.setText("�ʏ�K�͎��Ə��i�a�@�E�f�Ï��j");

      expertPlaceRehabiliRadioItem1.setGroup(getExpertPlaceRehabiliRadio());

      expertPlaceRehabiliRadioItem1.setConstraints(VRLayout.FLOW_RETURN);

      addExpertPlaceRehabiliRadioItem1();
    }
    return expertPlaceRehabiliRadioItem1;

  }

  /**
   * �ʏ�K�͎��Ə��i���V�l�ی��{�݁j���擾���܂��B
   * @return �ʏ�K�͎��Ə��i���V�l�ی��{�݁j
   */
  public ACRadioButtonItem getExpertPlaceRehabiliRadioItem2(){
    if(expertPlaceRehabiliRadioItem2==null){

      expertPlaceRehabiliRadioItem2 = new ACRadioButtonItem();

      expertPlaceRehabiliRadioItem2.setText("�ʏ�K�͎��Ə��i���V�l�ی��{�݁j");

      expertPlaceRehabiliRadioItem2.setGroup(getExpertPlaceRehabiliRadio());

      expertPlaceRehabiliRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

      addExpertPlaceRehabiliRadioItem2();
    }
    return expertPlaceRehabiliRadioItem2;

  }

  /**
   * ��K�͎��Ə� I�i�a�@�E�f�Ï��j���擾���܂��B
   * @return ��K�͎��Ə� I�i�a�@�E�f�Ï��j
   */
  public ACRadioButtonItem getExpertPlaceRehabiliRadioItem3(){
    if(expertPlaceRehabiliRadioItem3==null){

      expertPlaceRehabiliRadioItem3 = new ACRadioButtonItem();

      expertPlaceRehabiliRadioItem3.setText("��K�͎��Ə� I�i�a�@�E�f�Ï��j");

      expertPlaceRehabiliRadioItem3.setGroup(getExpertPlaceRehabiliRadio());

      expertPlaceRehabiliRadioItem3.setConstraints(VRLayout.FLOW_RETURN);

      addExpertPlaceRehabiliRadioItem3();
    }
    return expertPlaceRehabiliRadioItem3;

  }

  /**
   * ��K�͎��Ə� I�i���V�l�ی��{�݁j���擾���܂��B
   * @return ��K�͎��Ə� I�i���V�l�ی��{�݁j
   */
  public ACRadioButtonItem getExpertPlaceRehabiliRadioItem4(){
    if(expertPlaceRehabiliRadioItem4==null){

      expertPlaceRehabiliRadioItem4 = new ACRadioButtonItem();

      expertPlaceRehabiliRadioItem4.setText("��K�͎��Ə� I�i���V�l�ی��{�݁j");

      expertPlaceRehabiliRadioItem4.setGroup(getExpertPlaceRehabiliRadio());

      expertPlaceRehabiliRadioItem4.setConstraints(VRLayout.FLOW_RETURN);

      addExpertPlaceRehabiliRadioItem4();
    }
    return expertPlaceRehabiliRadioItem4;

  }

  /**
   * ��K�͎��Ə� II�i�a�@�E�f�Ï��j���擾���܂��B
   * @return ��K�͎��Ə� II�i�a�@�E�f�Ï��j
   */
  public ACRadioButtonItem getExpertPlaceRehabiliRadioItem5(){
    if(expertPlaceRehabiliRadioItem5==null){

      expertPlaceRehabiliRadioItem5 = new ACRadioButtonItem();

      expertPlaceRehabiliRadioItem5.setText("��K�͎��Ə� II�i�a�@�E�f�Ï��j");

      expertPlaceRehabiliRadioItem5.setGroup(getExpertPlaceRehabiliRadio());

      expertPlaceRehabiliRadioItem5.setConstraints(VRLayout.FLOW_RETURN);

      addExpertPlaceRehabiliRadioItem5();
    }
    return expertPlaceRehabiliRadioItem5;

  }

  /**
   * ��K�͎��Ə� II�i���V�l�ی��{�݁j���擾���܂��B
   * @return ��K�͎��Ə� II�i���V�l�ی��{�݁j
   */
  public ACRadioButtonItem getExpertPlaceRehabiliRadioItem6(){
    if(expertPlaceRehabiliRadioItem6==null){

      expertPlaceRehabiliRadioItem6 = new ACRadioButtonItem();

      expertPlaceRehabiliRadioItem6.setText("��K�͎��Ə� II�i���V�l�ی��{�݁j");

      expertPlaceRehabiliRadioItem6.setGroup(getExpertPlaceRehabiliRadio());

      expertPlaceRehabiliRadioItem6.setConstraints(VRLayout.FLOW);

      addExpertPlaceRehabiliRadioItem6();
    }
    return expertPlaceRehabiliRadioItem6;

  }

  /**
   * ���ԋ敪�R���{���擾���܂��B
   * @return ���ԋ敪�R���{
   */
  public ACComboBox getExpertPlaceRehabiliCombo(){
    if(expertPlaceRehabiliCombo==null){

      expertPlaceRehabiliCombo = new ACComboBox();

      getExpertPlaceRehabiliComboContainer().setText("���ԋ敪");

      expertPlaceRehabiliCombo.setBindPath("1330117");

      expertPlaceRehabiliCombo.setEditable(false);

      expertPlaceRehabiliCombo.setModelBindPath("1330117");

      expertPlaceRehabiliCombo.setRenderBindPath("CONTENT");

      expertPlaceRehabiliCombo.setModel(getExpertPlaceRehabiliComboModel());

      addExpertPlaceRehabiliCombo();
    }
    return expertPlaceRehabiliCombo;

  }

  /**
   * ���ԋ敪�R���{�R���e�i���擾���܂��B
   * @return ���ԋ敪�R���{�R���e�i
   */
  protected ACLabelContainer getExpertPlaceRehabiliComboContainer(){
    if(expertPlaceRehabiliComboContainer==null){
      expertPlaceRehabiliComboContainer = new ACLabelContainer();
      expertPlaceRehabiliComboContainer.setFollowChildEnabled(true);
      expertPlaceRehabiliComboContainer.setVAlignment(VRLayout.CENTER);
      expertPlaceRehabiliComboContainer.add(getExpertPlaceRehabiliCombo(), null);
    }
    return expertPlaceRehabiliComboContainer;
  }

  /**
   * ���ԋ敪�R���{���f�����擾���܂��B
   * @return ���ԋ敪�R���{���f��
   */
  protected ACComboBoxModelAdapter getExpertPlaceRehabiliComboModel(){
    if(expertPlaceRehabiliComboModel==null){
      expertPlaceRehabiliComboModel = new ACComboBoxModelAdapter();
      addExpertPlaceRehabiliComboModel();
    }
    return expertPlaceRehabiliComboModel;
  }

  /**
   * �^�u�p�l��7���擾���܂��B
   * @return �^�u�p�l��7
   */
  public ACPanel getTabPanel7(){
    if(tabPanel7==null){

      tabPanel7 = new ACPanel();

      tabPanel7.setFollowChildEnabled(true);

      tabPanel7.setHgap(0);

      addTabPanel7();
    }
    return tabPanel7;

  }

  /**
   * �����p��ݗ^�O���[�v���擾���܂��B
   * @return �����p��ݗ^�O���[�v
   */
  public ACGroupBox getWelfareToolsGroup(){
    if(welfareToolsGroup==null){

      welfareToolsGroup = new ACGroupBox();

      welfareToolsGroup.setText("�����p��ݗ^");

      welfareToolsGroup.setFollowChildEnabled(true);

      addWelfareToolsGroup();
    }
    return welfareToolsGroup;

  }

  /**
   * �p����擾���܂��B
   * @return �p��
   */
  public ACComboBox getWelfareToolsCombo(){
    if(welfareToolsCombo==null){

      welfareToolsCombo = new ACComboBox();

      getWelfareToolsComboContainer().setText("�p��");

      welfareToolsCombo.setBindPath("1330118");

      welfareToolsCombo.setEditable(false);

      welfareToolsCombo.setColumns(4);

      welfareToolsCombo.setModelBindPath("1330118");

      welfareToolsCombo.setRenderBindPath("CONTENT");

      welfareToolsCombo.setModel(getWelfareToolsComboModel());

      addWelfareToolsCombo();
    }
    return welfareToolsCombo;

  }

  /**
   * �p��R���e�i���擾���܂��B
   * @return �p��R���e�i
   */
  protected ACLabelContainer getWelfareToolsComboContainer(){
    if(welfareToolsComboContainer==null){
      welfareToolsComboContainer = new ACLabelContainer();
      welfareToolsComboContainer.setFollowChildEnabled(true);
      welfareToolsComboContainer.setVAlignment(VRLayout.CENTER);
      welfareToolsComboContainer.add(getWelfareToolsCombo(), null);
    }
    return welfareToolsComboContainer;
  }

  /**
   * �p��f�����擾���܂��B
   * @return �p��f��
   */
  protected ACComboBoxModelAdapter getWelfareToolsComboModel(){
    if(welfareToolsComboModel==null){
      welfareToolsComboModel = new ACComboBoxModelAdapter();
      addWelfareToolsComboModel();
    }
    return welfareToolsComboModel;
  }

  /**
   * �P�����擾���܂��B
   * @return �P��
   */
  public ACTextField getWelfarePointText(){
    if(welfarePointText==null){

      welfarePointText = new ACTextField();

      getWelfarePointTextContainer().setText("�P��");

      welfarePointText.setBindPath("1330119");

      welfarePointText.setColumns(4);

      welfarePointText.setCharType(VRCharType.ONLY_DIGIT);

      welfarePointText.setIMEMode(InputSubset.LATIN);

      welfarePointText.setMaxLength(6);

      addWelfarePointText();
    }
    return welfarePointText;

  }

  /**
   * �P���R���e�i���擾���܂��B
   * @return �P���R���e�i
   */
  protected ACLabelContainer getWelfarePointTextContainer(){
    if(welfarePointTextContainer==null){
      welfarePointTextContainer = new ACLabelContainer();
      welfarePointTextContainer.setFollowChildEnabled(true);
      welfarePointTextContainer.setVAlignment(VRLayout.CENTER);
      welfarePointTextContainer.add(getWelfarePointText(), null);
    }
    return welfarePointTextContainer;
  }

  /**
   * �E�v���擾���܂��B
   * @return �E�v
   */
  public ACTextField getWelfareTekiyoText(){
    if(welfareTekiyoText==null){

      welfareTekiyoText = new ACTextField();

      getWelfareTekiyoTextContainer().setText("�E�v");

      welfareTekiyoText.setBindPath("1330120");

      welfareTekiyoText.setColumns(15);

      welfareTekiyoText.setCharType(VRCharType.ONLY_HALF_CHAR);

      welfareTekiyoText.setHorizontalAlignment(SwingConstants.LEFT);

      welfareTekiyoText.setIMEMode(InputSubset.LATIN);

      welfareTekiyoText.setMaxLength(20);

      addWelfareTekiyoText();
    }
    return welfareTekiyoText;

  }

  /**
   * �E�v�R���e�i���擾���܂��B
   * @return �E�v�R���e�i
   */
  protected ACLabelContainer getWelfareTekiyoTextContainer(){
    if(welfareTekiyoTextContainer==null){
      welfareTekiyoTextContainer = new ACLabelContainer();
      welfareTekiyoTextContainer.setFollowChildEnabled(true);
      welfareTekiyoTextContainer.setVAlignment(VRLayout.CENTER);
      welfareTekiyoTextContainer.add(getWelfareTekiyoText(), null);
    }
    return welfareTekiyoTextContainer;
  }

  /**
   * �F�m�ǑΉ��^�ʏ����O���[�v���擾���܂��B
   * @return �F�m�ǑΉ��^�ʏ����O���[�v
   */
  public ACGroupBox getNinchishoTaioTsushoGroup(){
    if(ninchishoTaioTsushoGroup==null){

      ninchishoTaioTsushoGroup = new ACGroupBox();

      ninchishoTaioTsushoGroup.setText("�F�m�ǑΉ��^�ʏ����");

      ninchishoTaioTsushoGroup.setFollowChildEnabled(true);

      addNinchishoTaioTsushoGroup();
    }
    return ninchishoTaioTsushoGroup;

  }

  /**
   * �{�ݓ��̋敪1���擾���܂��B
   * @return �{�ݓ��̋敪1
   */
  public ACValueArrayRadioButtonGroup getProviderDivisionRadio(){
    if(providerDivisionRadio==null){

      providerDivisionRadio = new ACValueArrayRadioButtonGroup();

      getProviderDivisionRadioContainer().setText("�{�ݓ��̋敪1");

      providerDivisionRadio.setBindPath("1330121");

      providerDivisionRadio.setUseClearButton(false);

      providerDivisionRadio.setModel(getProviderDivisionRadioModel());

      providerDivisionRadio.setValues(new int[]{1,2});

      addProviderDivisionRadio();
    }
    return providerDivisionRadio;

  }

  /**
   * �{�ݓ��̋敪1�R���e�i���擾���܂��B
   * @return �{�ݓ��̋敪1�R���e�i
   */
  protected ACLabelContainer getProviderDivisionRadioContainer(){
    if(providerDivisionRadioContainer==null){
      providerDivisionRadioContainer = new ACLabelContainer();
      providerDivisionRadioContainer.setFollowChildEnabled(true);
      providerDivisionRadioContainer.setVAlignment(VRLayout.CENTER);
      providerDivisionRadioContainer.add(getProviderDivisionRadio(), null);
    }
    return providerDivisionRadioContainer;
  }

  /**
   * �{�ݓ��̋敪1���f�����擾���܂��B
   * @return �{�ݓ��̋敪1���f��
   */
  protected ACListModelAdapter getProviderDivisionRadioModel(){
    if(providerDivisionRadioModel==null){
      providerDivisionRadioModel = new ACListModelAdapter();
      addProviderDivisionRadioModel();
    }
    return providerDivisionRadioModel;
  }

  /**
   * I�^���擾���܂��B
   * @return I�^
   */
  public ACRadioButtonItem getProviderDivisionRadioItem1(){
    if(providerDivisionRadioItem1==null){

      providerDivisionRadioItem1 = new ACRadioButtonItem();

      providerDivisionRadioItem1.setText("I�^");

      providerDivisionRadioItem1.setGroup(getProviderDivisionRadio());

      providerDivisionRadioItem1.setConstraints(VRLayout.FLOW);

      addProviderDivisionRadioItem1();
    }
    return providerDivisionRadioItem1;

  }

  /**
   * II�^���擾���܂��B
   * @return II�^
   */
  public ACRadioButtonItem getProviderDivisionRadioItem2(){
    if(providerDivisionRadioItem2==null){

      providerDivisionRadioItem2 = new ACRadioButtonItem();

      providerDivisionRadioItem2.setText("II�^");

      providerDivisionRadioItem2.setGroup(getProviderDivisionRadio());

      providerDivisionRadioItem2.setConstraints(VRLayout.FLOW);

      addProviderDivisionRadioItem2();
    }
    return providerDivisionRadioItem2;

  }

  /**
   * �{�ݓ��̋敪2���擾���܂��B
   * @return �{�ݓ��̋敪2
   */
  public ACValueArrayRadioButtonGroup getDivisionRadion(){
    if(divisionRadion==null){

      divisionRadion = new ACValueArrayRadioButtonGroup();

      getDivisionRadionContainer().setText("�{�ݓ��̋敪2");

      divisionRadion.setBindPath("1330122");

      divisionRadion.setUseClearButton(false);

      divisionRadion.setModel(getDivisionRadionModel());

      divisionRadion.setValues(new int[]{1,2});

      addDivisionRadion();
    }
    return divisionRadion;

  }

  /**
   * �{�ݓ��̋敪2�R���e�i���擾���܂��B
   * @return �{�ݓ��̋敪2�R���e�i
   */
  protected ACLabelContainer getDivisionRadionContainer(){
    if(divisionRadionContainer==null){
      divisionRadionContainer = new ACLabelContainer();
      divisionRadionContainer.setFollowChildEnabled(true);
      divisionRadionContainer.setVAlignment(VRLayout.CENTER);
      divisionRadionContainer.add(getDivisionRadion(), null);
    }
    return divisionRadionContainer;
  }

  /**
   * �{�ݓ��̋敪2���f�����擾���܂��B
   * @return �{�ݓ��̋敪2���f��
   */
  protected ACListModelAdapter getDivisionRadionModel(){
    if(divisionRadionModel==null){
      divisionRadionModel = new ACListModelAdapter();
      addDivisionRadionModel();
    }
    return divisionRadionModel;
  }

  /**
   * �P�ƌ^���擾���܂��B
   * @return �P�ƌ^
   */
  public ACRadioButtonItem getDivisionRadionitem1(){
    if(divisionRadionitem1==null){

      divisionRadionitem1 = new ACRadioButtonItem();

      divisionRadionitem1.setText("�P�ƌ^");

      divisionRadionitem1.setGroup(getDivisionRadion());

      divisionRadionitem1.setConstraints(VRLayout.FLOW);

      addDivisionRadionitem1();
    }
    return divisionRadionitem1;

  }

  /**
   * ���݌^���擾���܂��B
   * @return ���݌^
   */
  public ACRadioButtonItem getDivisionRadionitem2(){
    if(divisionRadionitem2==null){

      divisionRadionitem2 = new ACRadioButtonItem();

      divisionRadionitem2.setText("���݌^");

      divisionRadionitem2.setGroup(getDivisionRadion());

      divisionRadionitem2.setConstraints(VRLayout.FLOW);

      addDivisionRadionitem2();
    }
    return divisionRadionitem2;

  }

  /**
   * ���ԋ敪���擾���܂��B
   * @return ���ԋ敪
   */
  public ACValueArrayRadioButtonGroup getTimeDivisionRadio(){
    if(timeDivisionRadio==null){

      timeDivisionRadio = new ACValueArrayRadioButtonGroup();

      getTimeDivisionRadioContainer().setText("���ԋ敪");

      timeDivisionRadio.setBindPath("1330123");

      timeDivisionRadio.setUseClearButton(false);

      timeDivisionRadio.setModel(getTimeDivisionRadioModel());

      timeDivisionRadio.setValues(new int[]{1,2,3,4});

      addTimeDivisionRadio();
    }
    return timeDivisionRadio;

  }

  /**
   * ���ԋ敪�R���e�i���擾���܂��B
   * @return ���ԋ敪�R���e�i
   */
  protected ACLabelContainer getTimeDivisionRadioContainer(){
    if(timeDivisionRadioContainer==null){
      timeDivisionRadioContainer = new ACLabelContainer();
      timeDivisionRadioContainer.setFollowChildEnabled(true);
      timeDivisionRadioContainer.setVAlignment(VRLayout.CENTER);
      timeDivisionRadioContainer.add(getTimeDivisionRadio(), null);
    }
    return timeDivisionRadioContainer;
  }

  /**
   * ���ԋ敪���f�����擾���܂��B
   * @return ���ԋ敪���f��
   */
  protected ACListModelAdapter getTimeDivisionRadioModel(){
    if(timeDivisionRadioModel==null){
      timeDivisionRadioModel = new ACListModelAdapter();
      addTimeDivisionRadioModel();
    }
    return timeDivisionRadioModel;
  }

  /**
   * 2����3���Ԃ��擾���܂��B
   * @return 2����3����
   */
  public ACRadioButtonItem getTimeDivisionRadioItem1(){
    if(timeDivisionRadioItem1==null){

      timeDivisionRadioItem1 = new ACRadioButtonItem();

      timeDivisionRadioItem1.setText("2����3����");

      timeDivisionRadioItem1.setGroup(getTimeDivisionRadio());

      timeDivisionRadioItem1.setConstraints(VRLayout.FLOW);

      addTimeDivisionRadioItem1();
    }
    return timeDivisionRadioItem1;

  }

  /**
   * 3����4���Ԃ��擾���܂��B
   * @return 3����4����
   */
  public ACRadioButtonItem getTimeDivisionRadioItem2(){
    if(timeDivisionRadioItem2==null){

      timeDivisionRadioItem2 = new ACRadioButtonItem();

      timeDivisionRadioItem2.setText("3����5����");

      timeDivisionRadioItem2.setGroup(getTimeDivisionRadio());

      timeDivisionRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

      addTimeDivisionRadioItem2();
    }
    return timeDivisionRadioItem2;

  }

  /**
   * 4����6���Ԃ��擾���܂��B
   * @return 4����6����
   */
  public ACRadioButtonItem getTimeDivisionRadioItem3(){
    if(timeDivisionRadioItem3==null){

      timeDivisionRadioItem3 = new ACRadioButtonItem();

      timeDivisionRadioItem3.setText("5����7����");

      timeDivisionRadioItem3.setGroup(getTimeDivisionRadio());

      timeDivisionRadioItem3.setConstraints(VRLayout.FLOW);

      addTimeDivisionRadioItem3();
    }
    return timeDivisionRadioItem3;

  }

  /**
   * 6����8���Ԃ��擾���܂��B
   * @return 6����8����
   */
  public ACRadioButtonItem getTimeDivisionRadioItem4(){
    if(timeDivisionRadioItem4==null){

      timeDivisionRadioItem4 = new ACRadioButtonItem();

      timeDivisionRadioItem4.setText("7����9����");

      timeDivisionRadioItem4.setGroup(getTimeDivisionRadio());

      timeDivisionRadioItem4.setConstraints(VRLayout.FLOW_RETURN);

      addTimeDivisionRadioItem4();
    }
    return timeDivisionRadioItem4;

  }

  /**
   * �^�u�p�l��8���擾���܂��B
   * @return �^�u�p�l��8
   */
  public ACPanel getTabPanel8(){
    if(tabPanel8==null){

      tabPanel8 = new ACPanel();

      tabPanel8.setFollowChildEnabled(true);

      tabPanel8.setHgap(0);

      addTabPanel8();
    }
    return tabPanel8;

  }

  /**
   * �n�斧���^�ʏ����O���[�v���擾���܂��B
   * @return �n�斧���^�ʏ����O���[�v
   */
  public ACGroupBox getChiikiDayCareGroup(){
    if(chiikiDayCareGroup==null){

      chiikiDayCareGroup = new ACGroupBox();

      chiikiDayCareGroup.setText("�n�斧���^�ʏ����");

      chiikiDayCareGroup.setFollowChildEnabled(true);

      addChiikiDayCareGroup();
    }
    return chiikiDayCareGroup;

  }

  /**
   * �{�ݓ��̋敪���擾���܂��B
   * @return �{�ݓ��̋敪
   */
  public ACValueArrayRadioButtonGroup getChiikiDayCareRadio(){
    if(chiikiDayCareRadio==null){

      chiikiDayCareRadio = new ACValueArrayRadioButtonGroup();

      getChiikiDayCareRadioContainer().setText("�{�ݓ��̋敪");

      chiikiDayCareRadio.setBindPath("1330134");

      chiikiDayCareRadio.setUseClearButton(false);

      chiikiDayCareRadio.setModel(getChiikiDayCareRadioModel());

      chiikiDayCareRadio.setValues(new int[]{1,2});

      addChiikiDayCareRadio();
    }
    return chiikiDayCareRadio;

  }

  /**
   * �{�ݓ��̋敪�R���e�i���擾���܂��B
   * @return �{�ݓ��̋敪�R���e�i
   */
  protected ACLabelContainer getChiikiDayCareRadioContainer(){
    if(chiikiDayCareRadioContainer==null){
      chiikiDayCareRadioContainer = new ACLabelContainer();
      chiikiDayCareRadioContainer.setFollowChildEnabled(true);
      chiikiDayCareRadioContainer.setVAlignment(VRLayout.CENTER);
      chiikiDayCareRadioContainer.add(getChiikiDayCareRadio(), null);
    }
    return chiikiDayCareRadioContainer;
  }

  /**
   * �{�ݓ��̋敪���f�����擾���܂��B
   * @return �{�ݓ��̋敪���f��
   */
  protected ACListModelAdapter getChiikiDayCareRadioModel(){
    if(chiikiDayCareRadioModel==null){
      chiikiDayCareRadioModel = new ACListModelAdapter();
      addChiikiDayCareRadioModel();
    }
    return chiikiDayCareRadioModel;
  }

  /**
   * �n�斧���^�ʏ������擾���܂��B
   * @return �n�斧���^�ʏ����
   */
  public ACRadioButtonItem getChiikiDayCareRadioItem1(){
    if(chiikiDayCareRadioItem1==null){

      chiikiDayCareRadioItem1 = new ACRadioButtonItem();

      chiikiDayCareRadioItem1.setText("�n�斧���^�ʏ����");

      chiikiDayCareRadioItem1.setGroup(getChiikiDayCareRadio());

      chiikiDayCareRadioItem1.setConstraints(VRLayout.FLOW_RETURN);

      addChiikiDayCareRadioItem1();
    }
    return chiikiDayCareRadioItem1;

  }

  /**
   * �×{�ʏ������擾���܂��B
   * @return �×{�ʏ����
   */
  public ACRadioButtonItem getChiikiDayCareRadioItem2(){
    if(chiikiDayCareRadioItem2==null){

      chiikiDayCareRadioItem2 = new ACRadioButtonItem();

      chiikiDayCareRadioItem2.setText("�×{�ʏ����");

      chiikiDayCareRadioItem2.setGroup(getChiikiDayCareRadio());

      chiikiDayCareRadioItem2.setConstraints(VRLayout.FLOW);

      addChiikiDayCareRadioItem2();
    }
    return chiikiDayCareRadioItem2;

  }

  /**
   * ���ԋ敪�R���{���擾���܂��B
   * @return ���ԋ敪�R���{
   */
  public ACComboBox getChiikiDayCareCombo(){
    if(chiikiDayCareCombo==null){

      chiikiDayCareCombo = new ACComboBox();

      getChiikiDayCareComboContainer().setText("���ԋ敪");

      chiikiDayCareCombo.setBindPath("1330135");

      chiikiDayCareCombo.setEditable(false);

      chiikiDayCareCombo.setModelBindPath("1330135");

      chiikiDayCareCombo.setRenderBindPath("CONTENT");

      chiikiDayCareCombo.setModel(getChiikiDayCareComboModel());

      addChiikiDayCareCombo();
    }
    return chiikiDayCareCombo;

  }

  /**
   * ���ԋ敪�R���{�R���e�i���擾���܂��B
   * @return ���ԋ敪�R���{�R���e�i
   */
  protected ACLabelContainer getChiikiDayCareComboContainer(){
    if(chiikiDayCareComboContainer==null){
      chiikiDayCareComboContainer = new ACLabelContainer();
      chiikiDayCareComboContainer.setFollowChildEnabled(true);
      chiikiDayCareComboContainer.setVAlignment(VRLayout.CENTER);
      chiikiDayCareComboContainer.add(getChiikiDayCareCombo(), null);
    }
    return chiikiDayCareComboContainer;
  }

  /**
   * ���ԋ敪�R���{���f�����擾���܂��B
   * @return ���ԋ敪�R���{���f��
   */
  protected ACComboBoxModelAdapter getChiikiDayCareComboModel(){
    if(chiikiDayCareComboModel==null){
      chiikiDayCareComboModel = new ACComboBoxModelAdapter();
      addChiikiDayCareComboModel();
    }
    return chiikiDayCareComboModel;
  }

  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001_13311_201504Design() {

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

    this.add(getTabs(), VRLayout.CLIENT);

  }

  /**
   * �^�u�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTabs(){

    tabs.addTab("1", getTabPanel1());

    tabs.addTab("2", getTabPanel2());

    tabs.addTab("3", getTabPanel3());

    tabs.addTab("4", getTabPanel4());

    tabs.addTab("5", getTabPanel5());

    tabs.addTab("6", getTabPanel6());

    tabs.addTab("7", getTabPanel7());

    tabs.addTab("8", getTabPanel8());

  }

  /**
   * �^�u�p�l��1�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTabPanel1(){

    tabPanel1.add(getFacilitiesDivisionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tabPanel1.add(getSpecificFacilitySubtractionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tabPanel1.add(getSpecificFacilityFunctionTrainingRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tabPanel1.add(getNightNursingSystemRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tabPanel1.add(getMedicalCoordinateAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tabPanel1.add(getImpairedPersonHelpAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * �{�ݓ��̋敪�ɓ������ڂ�ǉ����܂��B
   */
  protected void addFacilitiesDivisionRadio(){

  }

  /**
   * �{�ݓ��̋敪���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addFacilitiesDivisionRadioModel(){

    getFacilitiesDivisionRadioItem1().setButtonIndex(1);

    getFacilitiesDivisionRadioModel().add(getFacilitiesDivisionRadioItem1());

    getFacilitiesDivisionRadioItem2().setButtonIndex(2);

    getFacilitiesDivisionRadioModel().add(getFacilitiesDivisionRadioItem2());

  }

  /**
   * ����{�ݓ����҂ɓ������ڂ�ǉ����܂��B
   */
  protected void addFacilitiesDivisionRadioItem1(){

  }

  /**
   * �O���T�[�r�X���p�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addFacilitiesDivisionRadioItem2(){

  }

  /**
   * �l�����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addSpecificFacilitySubtractionRadio(){

  }

  /**
   * �l�����Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addSpecificFacilitySubtractionRadioModel(){

    getSpecificFacilitySubtractionNot().setButtonIndex(1);

    getSpecificFacilitySubtractionRadioModel().add(getSpecificFacilitySubtractionNot());

    getSpecificFacilitySubtractionPersonLack().setButtonIndex(2);

    getSpecificFacilitySubtractionRadioModel().add(getSpecificFacilitySubtractionPersonLack());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addSpecificFacilitySubtractionNot(){

  }

  /**
   * �E���s���ɓ������ڂ�ǉ����܂��B
   */
  protected void addSpecificFacilitySubtractionPersonLack(){

  }

  /**
   * �ʋ@�\�P���w���̐����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addSpecificFacilityFunctionTrainingRadio(){

  }

  /**
   * �ʋ@�\�P���w���̐����Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addSpecificFacilityFunctionTrainingRadioModel(){

    getSpecificFacilityFunctionTrainingRadioItem2().setButtonIndex(1);

    getSpecificFacilityFunctionTrainingRadioModel().add(getSpecificFacilityFunctionTrainingRadioItem2());

    getSpecificFacilityFunctionTrainingRadioItem1().setButtonIndex(2);

    getSpecificFacilityFunctionTrainingRadioModel().add(getSpecificFacilityFunctionTrainingRadioItem1());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addSpecificFacilityFunctionTrainingRadioItem2(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addSpecificFacilityFunctionTrainingRadioItem1(){

  }

  /**
   * ��ԊŌ�̐����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addNightNursingSystemRadio(){

  }

  /**
   * ��ԊŌ�̐����Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addNightNursingSystemRadioModel(){

    getNightNursingSystemRadioItem1().setButtonIndex(1);

    getNightNursingSystemRadioModel().add(getNightNursingSystemRadioItem1());

    getNightNursingSystemRadioItem2().setButtonIndex(2);

    getNightNursingSystemRadioModel().add(getNightNursingSystemRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addNightNursingSystemRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addNightNursingSystemRadioItem2(){

  }

  /**
   * ��Ë@�֘A�g���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalCoordinateAddRadioGroup(){

  }

  /**
   * ��Ë@�֘A�g���Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalCoordinateAddRadioGroupModel(){

    getMedicalCoordinateAddRadioItem1().setButtonIndex(1);

    getMedicalCoordinateAddRadioGroupModel().add(getMedicalCoordinateAddRadioItem1());

    getMedicalCoordinateAddRadioItem2().setButtonIndex(2);

    getMedicalCoordinateAddRadioGroupModel().add(getMedicalCoordinateAddRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalCoordinateAddRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalCoordinateAddRadioItem2(){

  }

  /**
   * ��Q�ғ��x�����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addImpairedPersonHelpAddRadioGroup(){

  }

  /**
   * ��Q�ғ��x�����Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addImpairedPersonHelpAddRadioGroupModel(){

    getImpairedPersonHelpAddRadioItem1().setButtonIndex(1);

    getImpairedPersonHelpAddRadioGroupModel().add(getImpairedPersonHelpAddRadioItem1());

    getImpairedPersonHelpAddRadioItem2().setButtonIndex(2);

    getImpairedPersonHelpAddRadioGroupModel().add(getImpairedPersonHelpAddRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addImpairedPersonHelpAddRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addImpairedPersonHelpAddRadioItem2(){

  }

  /**
   * �^�u�p�l��2�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTabPanel2(){

    tabPanel2.add(getTerminalCareAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tabPanel2.add(getKaigoWelfareFacilityTakingCareNursingAddDaysContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tabPanel2.add(getDementiaProfessionalCareAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tabPanel2.add(getServiceAddProvisionStructuralRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tabPanel2.add(getCalculationDivisionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * �Ŏ������Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTerminalCareAddRadioGroup(){

  }

  /**
   * �Ŏ������Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addTerminalCareAddRadioGroupModel(){

    getTerminalCareAddRadioItem1().setButtonIndex(1);

    getTerminalCareAddRadioGroupModel().add(getTerminalCareAddRadioItem1());

    getTerminalCareAddRadioItem2().setButtonIndex(2);

    getTerminalCareAddRadioGroupModel().add(getTerminalCareAddRadioItem2());

    getTerminalCareAddRadioItem3().setButtonIndex(3);

    getTerminalCareAddRadioGroupModel().add(getTerminalCareAddRadioItem3());

    getTerminalCareAddRadioItem4().setButtonIndex(4);

    getTerminalCareAddRadioGroupModel().add(getTerminalCareAddRadioItem4());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addTerminalCareAddRadioItem1(){

  }

  /**
   * ���S���ȑO4���ȏ�30���ȉ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addTerminalCareAddRadioItem2(){

  }

  /**
   * ���S���ȑO2������3���ɓ������ڂ�ǉ����܂��B
   */
  protected void addTerminalCareAddRadioItem3(){

  }

  /**
   * ���S���ɓ������ڂ�ǉ����܂��B
   */
  protected void addTerminalCareAddRadioItem4(){

  }

  /**
   * �Ŏ������Z�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityTakingCareNursingAddDaysContainer(){

    kaigoWelfareFacilityTakingCareNursingAddDaysContainer.add(getKaigoWelfareFacilityTakingCareNursingAddDays(), VRLayout.FLOW);

    kaigoWelfareFacilityTakingCareNursingAddDaysContainer.add(getKaigoWelfareFacilityTakingCareNursingAddDaysUnit(), VRLayout.FLOW);

  }

  /**
   * �Ŏ������Z�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityTakingCareNursingAddDays(){

  }

  /**
   * �Ŏ������Z�����P�ʂɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityTakingCareNursingAddDaysUnit(){

  }

  /**
   * �F�m�ǐ��P�A���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addDementiaProfessionalCareAddRadioGroup(){

  }

  /**
   * �F�m�ǐ��P�A���Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addDementiaProfessionalCareAddRadioGroupModel(){

    getDementiaProfessionalCareAddRadioItem1().setButtonIndex(1);

    getDementiaProfessionalCareAddRadioGroupModel().add(getDementiaProfessionalCareAddRadioItem1());

    getDementiaProfessionalCareAddRadioItem2().setButtonIndex(2);

    getDementiaProfessionalCareAddRadioGroupModel().add(getDementiaProfessionalCareAddRadioItem2());

    getDementiaProfessionalCareAddRadioItem3().setButtonIndex(3);

    getDementiaProfessionalCareAddRadioGroupModel().add(getDementiaProfessionalCareAddRadioItem3());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addDementiaProfessionalCareAddRadioItem1(){

  }

  /**
   * ���Z�^I�ɓ������ڂ�ǉ����܂��B
   */
  protected void addDementiaProfessionalCareAddRadioItem2(){

  }

  /**
   * ���Z�^II�ɓ������ڂ�ǉ����܂��B
   */
  protected void addDementiaProfessionalCareAddRadioItem3(){

  }

  /**
   * �T�[�r�X�񋟑̐��������Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceAddProvisionStructuralRadioGroup(){

  }

  /**
   * �T�[�r�X�񋟑̐��������Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceAddProvisionStructuralRadioGroupModel(){

    getServiceAddProvisionStructuralRadioItem1().setButtonIndex(1);

    getServiceAddProvisionStructuralRadioGroupModel().add(getServiceAddProvisionStructuralRadioItem1());

    getServiceAddProvisionStructuralRadioItem2().setButtonIndex(2);

    getServiceAddProvisionStructuralRadioGroupModel().add(getServiceAddProvisionStructuralRadioItem2());

    getServiceAddProvisionStructuralRadioItem3().setButtonIndex(3);

    getServiceAddProvisionStructuralRadioGroupModel().add(getServiceAddProvisionStructuralRadioItem3());

    getServiceAddProvisionStructuralRadioItem4().setButtonIndex(4);

    getServiceAddProvisionStructuralRadioGroupModel().add(getServiceAddProvisionStructuralRadioItem4());

    getServiceAddProvisionStructuralRadioItem5().setButtonIndex(5);

    getServiceAddProvisionStructuralRadioGroupModel().add(getServiceAddProvisionStructuralRadioItem5());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceAddProvisionStructuralRadioItem1(){

  }

  /**
   * I�C�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceAddProvisionStructuralRadioItem2(){

  }

  /**
   * I���^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceAddProvisionStructuralRadioItem3(){

  }

  /**
   * II�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceAddProvisionStructuralRadioItem4(){

  }

  /**
   * III�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceAddProvisionStructuralRadioItem5(){

  }

  /**
   * �Z��敪�ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalculationDivisionRadio(){

  }

  /**
   * �Z��敪���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalculationDivisionRadioModel(){

    getCalculationDivisionRadioItem1().setButtonIndex(1);

    getCalculationDivisionRadioModel().add(getCalculationDivisionRadioItem1());

    getCalculationDivisionRadioItem2().setButtonIndex(2);

    getCalculationDivisionRadioModel().add(getCalculationDivisionRadioItem2());

  }

  /**
   * �ʏ�ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalculationDivisionRadioItem1(){

  }

  /**
   * ���Z�݂̂ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalculationDivisionRadioItem2(){

  }

  /**
   * �^�u�p�l��3�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTabPanel3(){

    tabPanel3.add(getServiceSettingPanel(), VRLayout.NORTH);

    tabPanel3.add(getVisitCareGroup(), VRLayout.NORTH);

  }

  /**
   * �T�v�̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceSettingPanel(){

    serviceSettingPanel.add(getOutsideServiceRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    serviceSettingPanel.add(getSpecificFacilityTimeContena(), VRLayout.FLOW_DOUBLEINSETLINE_RETURN);

  }

  /**
   * �O���T�[�r�X�ɓ������ڂ�ǉ����܂��B
   */
  protected void addOutsideServiceRadio(){

  }

  /**
   * �O���T�[�r�X���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addOutsideServiceRadioModel(){

    getOutsideServiceRadioItem0().setButtonIndex(9);

    getOutsideServiceRadioModel().add(getOutsideServiceRadioItem0());

    getOutsideServiceRadioItem1().setButtonIndex(1);

    getOutsideServiceRadioModel().add(getOutsideServiceRadioItem1());

    getOutsideServiceRadioItem2().setButtonIndex(2);

    getOutsideServiceRadioModel().add(getOutsideServiceRadioItem2());

    getOutsideServiceRadioItem3().setButtonIndex(3);

    getOutsideServiceRadioModel().add(getOutsideServiceRadioItem3());

    getOutsideServiceRadioItem4().setButtonIndex(4);

    getOutsideServiceRadioModel().add(getOutsideServiceRadioItem4());

    getOutsideServiceRadioItem5().setButtonIndex(5);

    getOutsideServiceRadioModel().add(getOutsideServiceRadioItem5());

    getOutsideServiceRadioItem6().setButtonIndex(6);

    getOutsideServiceRadioModel().add(getOutsideServiceRadioItem6());

    getOutsideServiceRadioItem7().setButtonIndex(7);

    getOutsideServiceRadioModel().add(getOutsideServiceRadioItem7());

    getOutsideServiceRadioItem8().setButtonIndex(8);

    getOutsideServiceRadioModel().add(getOutsideServiceRadioItem8());

    getOutsideServiceRadioItem9().setButtonIndex(10);

    getOutsideServiceRadioModel().add(getOutsideServiceRadioItem9());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addOutsideServiceRadioItem0(){

  }

  /**
   * �K����ɓ������ڂ�ǉ����܂��B
   */
  protected void addOutsideServiceRadioItem1(){

  }

  /**
   * �K��������ɓ������ڂ�ǉ����܂��B
   */
  protected void addOutsideServiceRadioItem2(){

  }

  /**
   * �K��Ō�ɓ������ڂ�ǉ����܂��B
   */
  protected void addOutsideServiceRadioItem3(){

  }

  /**
   * �K�⃊�n�ɓ������ڂ�ǉ����܂��B
   */
  protected void addOutsideServiceRadioItem4(){

  }

  /**
   * �ʏ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addOutsideServiceRadioItem5(){

  }

  /**
   * �ʏ����n�ɓ������ڂ�ǉ����܂��B
   */
  protected void addOutsideServiceRadioItem6(){

  }

  /**
   * �����p��ݗ^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addOutsideServiceRadioItem7(){

  }

  /**
   * �F�m�ǑΉ��ʏ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addOutsideServiceRadioItem8(){

  }

  /**
   * �n�斧���^�ʏ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addOutsideServiceRadioItem9(){

  }

  /**
   * �񋟎��ԃR���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addSpecificFacilityTimeContena(){

    specificFacilityTimeContena.add(getSpecificFacilityBeginTimeContainer(), VRLayout.FLOW);

    specificFacilityTimeContena.add(getSpecificFacilityEndTimeContainer(), VRLayout.FLOW);

  }

  /**
   * �J�n�����R���{�ɓ������ڂ�ǉ����܂��B
   */
  protected void addSpecificFacilityBeginTime(){

  }

  /**
   * �J�n�����R���{���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addSpecificFacilityBeginTimeModel(){

  }

  /**
   * �I�������R���{�ɓ������ڂ�ǉ����܂��B
   */
  protected void addSpecificFacilityEndTime(){

  }

  /**
   * �I�������R���{���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addSpecificFacilityEndTimeModel(){

  }

  /**
   * �K����O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addVisitCareGroup(){

    visitCareGroup.add(getVisitCareRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    visitCareGroup.add(getVisitCareComboContainer(), VRLayout.FLOW);

  }

  /**
   * �K����ɓ������ڂ�ǉ����܂��B
   */
  protected void addVisitCareRadio(){

  }

  /**
   * �K���샂�f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addVisitCareRadioModel(){

    getVisitCareRadioItem1().setButtonIndex(1);

    getVisitCareRadioModel().add(getVisitCareRadioItem1());

    getVisitCareRadioItem2().setButtonIndex(2);

    getVisitCareRadioModel().add(getVisitCareRadioItem2());

    getVisitCareRadioItem3().setButtonIndex(3);

    getVisitCareRadioModel().add(getVisitCareRadioItem3());

  }

  /**
   * �g�̉�쒆�S�ɓ������ڂ�ǉ����܂��B
   */
  protected void addVisitCareRadioItem1(){

  }

  /**
   * �����������S�ɓ������ڂ�ǉ����܂��B
   */
  protected void addVisitCareRadioItem2(){

  }

  /**
   * �ʉ@����~��ɓ������ڂ�ǉ����܂��B
   */
  protected void addVisitCareRadioItem3(){

  }

  /**
   * ���ԋ敪�R���{�ɓ������ڂ�ǉ����܂��B
   */
  protected void addVisitCareCombo(){

  }

  /**
   * ���ԋ敪�R���{���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addVisitCareComboModel(){

  }

  /**
   * �^�u�p�l��4�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTabPanel4(){

    tabPanel4.add(getVisitNursingRadioGroup(), VRLayout.NORTH);

    tabPanel4.add(getVisitRehabiliGroup(), VRLayout.NORTH);

  }

  /**
   * �K��Ō�ɓ������ڂ�ǉ����܂��B
   */
  protected void addVisitNursingRadioGroup(){

    visitNursingRadioGroup.add(getVisitNursingFacilitiesDivisionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    visitNursingRadioGroup.add(getVisitNursingStaffDivisionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    visitNursingRadioGroup.add(getTwoOrMoreTimesCheck(), VRLayout.FLOW);

    visitNursingRadioGroup.add(getVisitNursingComboContainer(), VRLayout.FLOW);

    visitNursingRadioGroup.add(getNurseStaffDivisionRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * �{�ݓ��̋敪�ɓ������ڂ�ǉ����܂��B
   */
  protected void addVisitNursingFacilitiesDivisionRadio(){

  }

  /**
   * �{�ݓ��̋敪���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addVisitNursingFacilitiesDivisionRadioModel(){

    getVisitNursingFacilitiesDivisionRadioItem1().setButtonIndex(1);

    getVisitNursingFacilitiesDivisionRadioModel().add(getVisitNursingFacilitiesDivisionRadioItem1());

    getVisitNursingFacilitiesDivisionRadioItem2().setButtonIndex(2);

    getVisitNursingFacilitiesDivisionRadioModel().add(getVisitNursingFacilitiesDivisionRadioItem2());

  }

  /**
   * �K��Ō�X�e�[�V�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addVisitNursingFacilitiesDivisionRadioItem1(){

  }

  /**
   * �a�@���͐f�Ï��ɓ������ڂ�ǉ����܂��B
   */
  protected void addVisitNursingFacilitiesDivisionRadioItem2(){

  }

  /**
   * �E���敪�ɓ������ڂ�ǉ����܂��B
   */
  protected void addVisitNursingStaffDivisionRadio(){

  }

  /**
   * �E���敪���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addVisitNursingStaffDivisionRadioModel(){

    getVisitNursingStaffDivisionRadioItem1().setButtonIndex(1);

    getVisitNursingStaffDivisionRadioModel().add(getVisitNursingStaffDivisionRadioItem1());

    getVisitNursingStaffDivisionRadioItem2().setButtonIndex(2);

    getVisitNursingStaffDivisionRadioModel().add(getVisitNursingStaffDivisionRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addVisitNursingStaffDivisionRadioItem1(){

  }

  /**
   * PT,OT,ST�ɓ������ڂ�ǉ����܂��B
   */
  protected void addVisitNursingStaffDivisionRadioItem2(){

  }

  /**
   * 1����2����z���Ď��{�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTwoOrMoreTimesCheck(){

  }

  /**
   * ���ԋ敪�R���{�ɓ������ڂ�ǉ����܂��B
   */
  protected void addVisitNursingCombo(){

  }

  /**
   * ���ԋ敪�R���{���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addVisitNursingComboModel(){

  }

  /**
   * �Ō�E���敪�ɓ������ڂ�ǉ����܂��B
   */
  protected void addNurseStaffDivisionRadioGroup(){

  }

  /**
   * �Ō�E���敪���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addNurseStaffDivisionRadioGroupModel(){

    getNurseStaffDivisionRadioItem1().setButtonIndex(1);

    getNurseStaffDivisionRadioGroupModel().add(getNurseStaffDivisionRadioItem1());

    getNurseStaffDivisionRadioItem2().setButtonIndex(2);

    getNurseStaffDivisionRadioGroupModel().add(getNurseStaffDivisionRadioItem2());

  }

  /**
   * ���œ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addNurseStaffDivisionRadioItem1(){

  }

  /**
   * �y�łɓ������ڂ�ǉ����܂��B
   */
  protected void addNurseStaffDivisionRadioItem2(){

  }

  /**
   * �K�⃊�n�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addVisitRehabiliGroup(){

    visitRehabiliGroup.add(getVisitRehabiliRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * �{�ݓ��̋敪�ɓ������ڂ�ǉ����܂��B
   */
  protected void addVisitRehabiliRadio(){

  }

  /**
   * �{�ݓ��̋敪���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addVisitRehabiliRadioModel(){

    getVisitRehabiliRadioItem1().setButtonIndex(1);

    getVisitRehabiliRadioModel().add(getVisitRehabiliRadioItem1());

    getVisitRehabiliRadioItem2().setButtonIndex(2);

    getVisitRehabiliRadioModel().add(getVisitRehabiliRadioItem2());

  }

  /**
   * �a�@���͐f�Ï��ɓ������ڂ�ǉ����܂��B
   */
  protected void addVisitRehabiliRadioItem1(){

  }

  /**
   * ���V�l�ی��{�݂ɓ������ڂ�ǉ����܂��B
   */
  protected void addVisitRehabiliRadioItem2(){

  }

  /**
   * �^�u�p�l��5�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTabPanel5(){

    tabPanel5.add(getExpertPlaceNursingGroup(), VRLayout.NORTH);

  }

  /**
   * �ʏ����O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addExpertPlaceNursingGroup(){

    expertPlaceNursingGroup.add(getExpertPlaceNursingRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    expertPlaceNursingGroup.add(getExpertPlaceNursingComboContainer(), VRLayout.FLOW);

  }

  /**
   * �{�ݓ��̋敪�ɓ������ڂ�ǉ����܂��B
   */
  protected void addExpertPlaceNursingRadio(){

  }

  /**
   * �{�ݓ��̋敪���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addExpertPlaceNursingRadioModel(){

    getExpertPlaceNursingRadioItem1().setButtonIndex(1);

    getExpertPlaceNursingRadioModel().add(getExpertPlaceNursingRadioItem1());

    getExpertPlaceNursingRadioItem2().setButtonIndex(2);

    getExpertPlaceNursingRadioModel().add(getExpertPlaceNursingRadioItem2());

    getExpertPlaceNursingRadioItem3().setButtonIndex(3);

    getExpertPlaceNursingRadioModel().add(getExpertPlaceNursingRadioItem3());

    getExpertPlaceNursingRadioItem4().setButtonIndex(4);

    getExpertPlaceNursingRadioModel().add(getExpertPlaceNursingRadioItem4());

    getExpertPlaceNursingRadioItem5().setButtonIndex(5);

    getExpertPlaceNursingRadioModel().add(getExpertPlaceNursingRadioItem5());

  }

  /**
   * ���K�͎��Ə��ɓ������ڂ�ǉ����܂��B
   */
  protected void addExpertPlaceNursingRadioItem1(){

  }

  /**
   * �ʏ�K�͎��Ə��ɓ������ڂ�ǉ����܂��B
   */
  protected void addExpertPlaceNursingRadioItem2(){

  }

  /**
   * ��K�͎��Ə� I�ɓ������ڂ�ǉ����܂��B
   */
  protected void addExpertPlaceNursingRadioItem3(){

  }

  /**
   * ��K�͎��Ə� II�ɓ������ڂ�ǉ����܂��B
   */
  protected void addExpertPlaceNursingRadioItem4(){

  }

  /**
   * �×{�ʏ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addExpertPlaceNursingRadioItem5(){

  }

  /**
   * ���ԋ敪�R���{�ɓ������ڂ�ǉ����܂��B
   */
  protected void addExpertPlaceNursingCombo(){

  }

  /**
   * ���ԋ敪�R���{���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addExpertPlaceNursingComboModel(){

  }

  /**
   * �^�u�p�l��6�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTabPanel6(){

    tabPanel6.add(getExpertPlaceRehabiliGroup(), VRLayout.NORTH);

  }

  /**
   * �ʏ����n�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addExpertPlaceRehabiliGroup(){

    expertPlaceRehabiliGroup.add(getExpertPlaceRehabiliRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    expertPlaceRehabiliGroup.add(getExpertPlaceRehabiliComboContainer(), VRLayout.FLOW);

  }

  /**
   * �{�ݓ��̋敪�ɓ������ڂ�ǉ����܂��B
   */
  protected void addExpertPlaceRehabiliRadio(){

  }

  /**
   * �{�ݓ��̋敪���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addExpertPlaceRehabiliRadioModel(){

    getExpertPlaceRehabiliRadioItem1().setButtonIndex(1);

    getExpertPlaceRehabiliRadioModel().add(getExpertPlaceRehabiliRadioItem1());

    getExpertPlaceRehabiliRadioItem2().setButtonIndex(2);

    getExpertPlaceRehabiliRadioModel().add(getExpertPlaceRehabiliRadioItem2());

    getExpertPlaceRehabiliRadioItem3().setButtonIndex(3);

    getExpertPlaceRehabiliRadioModel().add(getExpertPlaceRehabiliRadioItem3());

    getExpertPlaceRehabiliRadioItem4().setButtonIndex(4);

    getExpertPlaceRehabiliRadioModel().add(getExpertPlaceRehabiliRadioItem4());

    getExpertPlaceRehabiliRadioItem5().setButtonIndex(5);

    getExpertPlaceRehabiliRadioModel().add(getExpertPlaceRehabiliRadioItem5());

    getExpertPlaceRehabiliRadioItem6().setButtonIndex(6);

    getExpertPlaceRehabiliRadioModel().add(getExpertPlaceRehabiliRadioItem6());

  }

  /**
   * �ʏ�K�͎��Ə��i�a�@�E�f�Ï��j�ɓ������ڂ�ǉ����܂��B
   */
  protected void addExpertPlaceRehabiliRadioItem1(){

  }

  /**
   * �ʏ�K�͎��Ə��i���V�l�ی��{�݁j�ɓ������ڂ�ǉ����܂��B
   */
  protected void addExpertPlaceRehabiliRadioItem2(){

  }

  /**
   * ��K�͎��Ə� I�i�a�@�E�f�Ï��j�ɓ������ڂ�ǉ����܂��B
   */
  protected void addExpertPlaceRehabiliRadioItem3(){

  }

  /**
   * ��K�͎��Ə� I�i���V�l�ی��{�݁j�ɓ������ڂ�ǉ����܂��B
   */
  protected void addExpertPlaceRehabiliRadioItem4(){

  }

  /**
   * ��K�͎��Ə� II�i�a�@�E�f�Ï��j�ɓ������ڂ�ǉ����܂��B
   */
  protected void addExpertPlaceRehabiliRadioItem5(){

  }

  /**
   * ��K�͎��Ə� II�i���V�l�ی��{�݁j�ɓ������ڂ�ǉ����܂��B
   */
  protected void addExpertPlaceRehabiliRadioItem6(){

  }

  /**
   * ���ԋ敪�R���{�ɓ������ڂ�ǉ����܂��B
   */
  protected void addExpertPlaceRehabiliCombo(){

  }

  /**
   * ���ԋ敪�R���{���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addExpertPlaceRehabiliComboModel(){

  }

  /**
   * �^�u�p�l��7�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTabPanel7(){

    tabPanel7.add(getWelfareToolsGroup(), VRLayout.NORTH);

    tabPanel7.add(getNinchishoTaioTsushoGroup(), VRLayout.NORTH);

  }

  /**
   * �����p��ݗ^�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addWelfareToolsGroup(){

    welfareToolsGroup.add(getWelfareToolsComboContainer(), VRLayout.FLOW_RETURN);

    welfareToolsGroup.add(getWelfarePointTextContainer(), VRLayout.FLOW_RETURN);

    welfareToolsGroup.add(getWelfareTekiyoTextContainer(), VRLayout.FLOW);

  }

  /**
   * �p��ɓ������ڂ�ǉ����܂��B
   */
  protected void addWelfareToolsCombo(){

  }

  /**
   * �p��f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addWelfareToolsComboModel(){

  }

  /**
   * �P���ɓ������ڂ�ǉ����܂��B
   */
  protected void addWelfarePointText(){

  }

  /**
   * �E�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addWelfareTekiyoText(){

  }

  /**
   * �F�m�ǑΉ��^�ʏ����O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addNinchishoTaioTsushoGroup(){

    ninchishoTaioTsushoGroup.add(getProviderDivisionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    ninchishoTaioTsushoGroup.add(getDivisionRadionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    ninchishoTaioTsushoGroup.add(getTimeDivisionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * �{�ݓ��̋敪1�ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderDivisionRadio(){

  }

  /**
   * �{�ݓ��̋敪1���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderDivisionRadioModel(){

    getProviderDivisionRadioItem1().setButtonIndex(1);

    getProviderDivisionRadioModel().add(getProviderDivisionRadioItem1());

    getProviderDivisionRadioItem2().setButtonIndex(2);

    getProviderDivisionRadioModel().add(getProviderDivisionRadioItem2());

  }

  /**
   * I�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderDivisionRadioItem1(){

  }

  /**
   * II�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderDivisionRadioItem2(){

  }

  /**
   * �{�ݓ��̋敪2�ɓ������ڂ�ǉ����܂��B
   */
  protected void addDivisionRadion(){

  }

  /**
   * �{�ݓ��̋敪2���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addDivisionRadionModel(){

    getDivisionRadionitem1().setButtonIndex(1);

    getDivisionRadionModel().add(getDivisionRadionitem1());

    getDivisionRadionitem2().setButtonIndex(2);

    getDivisionRadionModel().add(getDivisionRadionitem2());

  }

  /**
   * �P�ƌ^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addDivisionRadionitem1(){

  }

  /**
   * ���݌^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addDivisionRadionitem2(){

  }

  /**
   * ���ԋ敪�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTimeDivisionRadio(){

  }

  /**
   * ���ԋ敪���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addTimeDivisionRadioModel(){

    getTimeDivisionRadioItem1().setButtonIndex(1);

    getTimeDivisionRadioModel().add(getTimeDivisionRadioItem1());

    getTimeDivisionRadioItem2().setButtonIndex(2);

    getTimeDivisionRadioModel().add(getTimeDivisionRadioItem2());

    getTimeDivisionRadioItem3().setButtonIndex(3);

    getTimeDivisionRadioModel().add(getTimeDivisionRadioItem3());

    getTimeDivisionRadioItem4().setButtonIndex(4);

    getTimeDivisionRadioModel().add(getTimeDivisionRadioItem4());

  }

  /**
   * 2����3���Ԃɓ������ڂ�ǉ����܂��B
   */
  protected void addTimeDivisionRadioItem1(){

  }

  /**
   * 3����4���Ԃɓ������ڂ�ǉ����܂��B
   */
  protected void addTimeDivisionRadioItem2(){

  }

  /**
   * 4����6���Ԃɓ������ڂ�ǉ����܂��B
   */
  protected void addTimeDivisionRadioItem3(){

  }

  /**
   * 6����8���Ԃɓ������ڂ�ǉ����܂��B
   */
  protected void addTimeDivisionRadioItem4(){

  }

  /**
   * �^�u�p�l��8�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTabPanel8(){

    tabPanel8.add(getChiikiDayCareGroup(), VRLayout.NORTH);

  }

  /**
   * �n�斧���^�ʏ����O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addChiikiDayCareGroup(){

    chiikiDayCareGroup.add(getChiikiDayCareRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    chiikiDayCareGroup.add(getChiikiDayCareComboContainer(), VRLayout.FLOW);

  }

  /**
   * �{�ݓ��̋敪�ɓ������ڂ�ǉ����܂��B
   */
  protected void addChiikiDayCareRadio(){

  }

  /**
   * �{�ݓ��̋敪���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addChiikiDayCareRadioModel(){

    getChiikiDayCareRadioItem1().setButtonIndex(1);

    getChiikiDayCareRadioModel().add(getChiikiDayCareRadioItem1());

    getChiikiDayCareRadioItem2().setButtonIndex(2);

    getChiikiDayCareRadioModel().add(getChiikiDayCareRadioItem2());

  }

  /**
   * �n�斧���^�ʏ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addChiikiDayCareRadioItem1(){

  }

  /**
   * �×{�ʏ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addChiikiDayCareRadioItem2(){

  }

  /**
   * ���ԋ敪�R���{�ɓ������ڂ�ǉ����܂��B
   */
  protected void addChiikiDayCareCombo(){

  }

  /**
   * ���ԋ敪�R���{���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addChiikiDayCareComboModel(){

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
      ACFrame.debugStart(new ACAffairInfo(QS001_13311_201504Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QS001_13311_201504Design getThis() {
    return this;
  }
}
