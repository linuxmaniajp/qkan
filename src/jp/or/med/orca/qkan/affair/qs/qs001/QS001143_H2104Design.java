
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
 * �쐬��: 2009/03/03  ���{�R���s���[�^�[������� �c���@���� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �T�[�r�X�\��쐬/�ύX (S)
 * �v���Z�X �T�[�r�X�\��T�� (001)
 * �v���O���� �T�[�r�X�p�^�[�����\�h����{�ݓ����Ґ������ (QS001143_H2104)
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
 * �T�[�r�X�p�^�[�����\�h����{�ݓ����Ґ�������ʍ��ڃf�U�C��(QS001143_H2104) 
 */
public class QS001143_H2104Design extends QS001ServicePanel {
  //GUI�R���|�[�l���g

  private JTabbedPane tabs;

  private ACPanel tabPanel1;

  private ACClearableRadioButtonGroup facilitiesDivisionRadio;

  private ACLabelContainer facilitiesDivisionRadioContainer;

  private ACListModelAdapter facilitiesDivisionRadioModel;

  private ACRadioButtonItem facilitiesDivisionRadioItem1;

  private ACRadioButtonItem facilitiesDivisionRadioItem2;

  private ACClearableRadioButtonGroup specificFacilitySubtractionRadio;

  private ACLabelContainer specificFacilitySubtractionRadioContainer;

  private ACListModelAdapter specificFacilitySubtractionRadioModel;

  private ACRadioButtonItem specificFacilitySubtractionNot;

  private ACRadioButtonItem specificFacilitySubtractionPersonLack;

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

  private ACBackLabelContainer specificFacilityTimeContena;

  private ACTimeComboBox specificFacilityBeginTime;

  private ACLabelContainer specificFacilityBeginTimeContainer;

  private ACComboBoxModelAdapter specificFacilityBeginTimeModel;

  private ACTimeComboBox specificFacilityEndTime;

  private ACLabelContainer specificFacilityEndTimeContainer;

  private ACComboBoxModelAdapter specificFacilityEndTimeModel;

  private ACPanel tabPanel2;

  private ACPanel servicePanelAdd;

  private ACClearableRadioButtonGroup specificFacilityFunctionTrainingRadio;

  private ACLabelContainer specificFacilityFunctionTrainingRadioContainer;

  private ACListModelAdapter specificFacilityFunctionTrainingRadioModel;

  private ACRadioButtonItem specificFacilityFunctionTrainingRadioItem2;

  private ACRadioButtonItem specificFacilityFunctionTrainingRadioItem1;

  private ACClearableRadioButtonGroup medicalCoordinateAddRadioGroup;

  private ACLabelContainer medicalCoordinateAddRadioGroupContainer;

  private ACListModelAdapter medicalCoordinateAddRadioGroupModel;

  private ACRadioButtonItem medicalCoordinateAddRadioItem1;

  private ACRadioButtonItem medicalCoordinateAddRadioItem2;

  private ACClearableRadioButtonGroup impairedPersonHelpAddRadioGroup;

  private ACLabelContainer impairedPersonHelpAddRadioGroupContainer;

  private ACListModelAdapter impairedPersonHelpAddRadioGroupModel;

  private ACRadioButtonItem impairedPersonHelpAddRadioItem1;

  private ACRadioButtonItem impairedPersonHelpAddRadioItem2;

  private ACGroupBox visitCareGroup;

  private ACClearableRadioButtonGroup visitCareRadio;

  private ACLabelContainer visitCareRadioContainer;

  private ACListModelAdapter visitCareRadioModel;

  private ACRadioButtonItem visitCareRadioItem1;

  private ACRadioButtonItem visitCareRadioItem2;

  private ACRadioButtonItem visitCareRadioItem3;

  private ACIntegerCheckBox visitCareCrackOnDayCheck;

  private ACGroupBox visitNursingRadioGroup;

  private ACClearableRadioButtonGroup visitNursingFacilitiesDivisionRadio;

  private ACLabelContainer visitNursingFacilitiesDivisionRadioContainer;

  private ACListModelAdapter visitNursingFacilitiesDivisionRadioModel;

  private ACRadioButtonItem visitNursingFacilitiesDivisionRadioItem1;

  private ACRadioButtonItem visitNursingFacilitiesDivisionRadioItem2;

  private ACClearableRadioButtonGroup visitNursingStaffDivisionRadio;

  private ACLabelContainer visitNursingStaffDivisionRadioContainer;

  private ACListModelAdapter visitNursingStaffDivisionRadioModel;

  private ACRadioButtonItem visitNursingStaffDivisionRadioItem1;

  private ACRadioButtonItem visitNursingStaffDivisionRadioItem2;

  private ACComboBox visitNursingCombo;

  private ACLabelContainer visitNursingComboContainer;

  private ACComboBoxModelAdapter visitNursingComboModel;

  private ACPanel tabPanel3;

  private ACGroupBox visitRehabiliGroup;

  private ACClearableRadioButtonGroup visitRehabiliRadio;

  private ACLabelContainer visitRehabiliRadioContainer;

  private ACListModelAdapter visitRehabiliRadioModel;

  private ACRadioButtonItem visitRehabiliRadioItem1;

  private ACRadioButtonItem visitRehabiliRadioItem2;

  private ACGroupBox expertPlaceNursingGroup;

  private ACIntegerCheckBox expertPlaceNursingCrackOnDayChaeck;

  private ACClearableRadioButtonGroup expertPlaceNursingMovementFunctionImprovementAddRadio;

  private ACLabelContainer expertPlaceNursingMovementFunctionImprovementAddRadioContainer;

  private ACListModelAdapter expertPlaceNursingMovementFunctionImprovementAddRadioModel;

  private ACRadioButtonItem expertPlaceNursingMovementFunctionImprovementAddRadioItem1;

  private ACRadioButtonItem expertPlaceNursingMovementFunctionImprovementAddRadioItem2;

  private ACClearableRadioButtonGroup expertPlaceNursingNourishmentImprovementAddRadio;

  private ACLabelContainer expertPlaceNursingNourishmentImprovementAddRadioContainer;

  private ACListModelAdapter expertPlaceNursingNourishmentImprovementAddRadioModel;

  private ACRadioButtonItem expertPlaceNursingNourishmentImprovementAddRadioItem1;

  private ACRadioButtonItem expertPlaceNursingNourishmentImprovementAddRadioItem2;

  private ACClearableRadioButtonGroup expertPlaceNursingMouthFunctionImprovementAddRadio;

  private ACLabelContainer expertPlaceNursingMouthFunctionImprovementAddRadioContainer;

  private ACListModelAdapter expertPlaceNursingMouthFunctionImprovementAddRadioModel;

  private ACRadioButtonItem expertPlaceNursingMouthFunctionImprovementAddRadioItem1;

  private ACRadioButtonItem expertPlaceNursingMouthFunctionImprovementAddRadioItem2;

  private ACPanel tabPanel4;

  private ACGroupBox expertPlaceRehabiliGroup;

  private ACIntegerCheckBox expertPlaceRehabiliCrackOnDay;

  private ACClearableRadioButtonGroup expertPlaceRehabiliMovementFunctionImprovementAddRadio;

  private ACLabelContainer expertPlaceRehabiliMovementFunctionImprovementAddRadioContainer;

  private ACListModelAdapter expertPlaceRehabiliMovementFunctionImprovementAddRadioModel;

  private ACRadioButtonItem expertPlaceRehabiliMovementFunctionImprovementAddRadioItem1;

  private ACRadioButtonItem expertPlaceRehabiliMovementFunctionImprovementAddRadioItem2;

  private ACClearableRadioButtonGroup expertPlaceRehabiliNourishmentImprovementAddRadio;

  private ACLabelContainer expertPlaceRehabiliNourishmentImprovementAddRadioContainer;

  private ACListModelAdapter expertPlaceRehabiliNourishmentImprovementAddRadioModel;

  private ACRadioButtonItem expertPlaceRehabiliNourishmentImprovementAddRadioItem1;

  private ACRadioButtonItem expertPlaceRehabiliNourishmentImprovementAddRadioItem2;

  private ACClearableRadioButtonGroup expertPlaceRehabiliMouthFunctionImprovementAddRadio;

  private ACLabelContainer expertPlaceRehabiliMouthFunctionImprovementAddRadioContainer;

  private ACListModelAdapter expertPlaceRehabiliMouthFunctionImprovementAddRadioModel;

  private ACRadioButtonItem expertPlaceRehabiliMouthFunctionImprovementAddRadioItem1;

  private ACRadioButtonItem expertPlaceRehabiliMouthFunctionImprovementAddRadioItem2;

  private ACGroupBox welfareToolsGroup;

  private ACComboBox welfareToolsCombo;

  private ACLabelContainer welfareToolsComboContainer;

  private ACComboBoxModelAdapter welfareToolsComboModel;

  private ACTextField welfarePointText;

  private ACLabelContainer welfarePointTextContainer;

  private ACTextField welfareTekiyoText;

  private ACLabelContainer welfareTekiyoTextContainer;

  private ACPanel tabPanel5;

  private ACGroupBox ninchishoTaioTsushoGroup;

  private ACClearableRadioButtonGroup providerDivisionRadio;

  private ACLabelContainer providerDivisionRadioContainer;

  private ACListModelAdapter providerDivisionRadioModel;

  private ACRadioButtonItem providerDivisionRadioItem1;

  private ACRadioButtonItem providerDivisionRadioItem2;

  private ACClearableRadioButtonGroup divisionRadion;

  private ACLabelContainer divisionRadionContainer;

  private ACListModelAdapter divisionRadionModel;

  private ACRadioButtonItem divisionRadionitem1;

  private ACRadioButtonItem divisionRadionitem2;

  private ACClearableRadioButtonGroup timeDivisionRadio;

  private ACLabelContainer timeDivisionRadioContainer;

  private ACListModelAdapter timeDivisionRadioModel;

  private ACRadioButtonItem timeDivisionRadioItem1;

  private ACRadioButtonItem timeDivisionRadioItem2;

  private ACRadioButtonItem timeDivisionRadioItem3;

  private ACRadioButtonItem timeDivisionRadioItem4;

  private ACClearableRadioButtonGroup ninchishoTaioTsushoIndividualFunctionTrainingAddRadio;

  private ACLabelContainer ninchishoTaioTsushoIndividualFunctionTrainingAddRadioContainer;

  private ACListModelAdapter ninchishoTaioTsushoIndividualFunctionTrainingAddRadioModel;

  private ACRadioButtonItem ninchishoTaioTsushoIndividualFunctionTrainingAddRadioItem1;

  private ACRadioButtonItem ninchishoTaioTsushoIndividualFunctionTrainingAddRadioItem2;

  private ACClearableRadioButtonGroup ninchishoTaioTsushoNourishmentImprovementAddRadio;

  private ACLabelContainer ninchishoTaioTsushoNourishmentImprovementAddRadioContainer;

  private ACListModelAdapter ninchishoTaioTsushoNourishmentImprovementAddRadioModel;

  private ACRadioButtonItem ninchishoTaioTsushoNourishmentImprovementAddRadioItem1;

  private ACRadioButtonItem ninchishoTaioTsushoNourishmentImprovementAddRadioItem2;

  private ACClearableRadioButtonGroup ninchishoTaioTsushoMouthFunctionImprovementAddRadio;

  private ACLabelContainer ninchishoTaioTsushoMouthFunctionImprovementAddRadioContainer;

  private ACListModelAdapter ninchishoTaioTsushoMouthFunctionImprovementAddRadioModel;

  private ACRadioButtonItem ninchishoTaioTsushoMouthFunctionImprovementAddRadioItem1;

  private ACRadioButtonItem ninchishoTaioTsushoMouthFunctionImprovementAddRadioItem2;

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

      tabPanel1.setHgap(0);

      addTabPanel1();
    }
    return tabPanel1;

  }

  /**
   * �{�ݓ��̋敪���擾���܂��B
   * @return �{�ݓ��̋敪
   */
  public ACClearableRadioButtonGroup getFacilitiesDivisionRadio(){
    if(facilitiesDivisionRadio==null){

      facilitiesDivisionRadio = new ACClearableRadioButtonGroup();

      getFacilitiesDivisionRadioContainer().setText("�{�ݓ��̋敪");

      facilitiesDivisionRadio.setBindPath("1350101");

      facilitiesDivisionRadio.setUseClearButton(false);

      facilitiesDivisionRadio.setModel(getFacilitiesDivisionRadioModel());

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
  public ACClearableRadioButtonGroup getSpecificFacilitySubtractionRadio(){
    if(specificFacilitySubtractionRadio==null){

      specificFacilitySubtractionRadio = new ACClearableRadioButtonGroup();

      getSpecificFacilitySubtractionRadioContainer().setText("�l�����Z");

      specificFacilitySubtractionRadio.setBindPath("1350103");

      specificFacilitySubtractionRadio.setUseClearButton(false);

      specificFacilitySubtractionRadio.setModel(getSpecificFacilitySubtractionRadioModel());

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
   * �Ō�E���E�����������擾���܂��B
   * @return �Ō�E���E��������
   */
  public ACRadioButtonItem getSpecificFacilitySubtractionPersonLack(){
    if(specificFacilitySubtractionPersonLack==null){

      specificFacilitySubtractionPersonLack = new ACRadioButtonItem();

      specificFacilitySubtractionPersonLack.setText("�Ō�E���E��������");

      specificFacilitySubtractionPersonLack.setGroup(getSpecificFacilitySubtractionRadio());

      specificFacilitySubtractionPersonLack.setConstraints(VRLayout.FLOW);

      addSpecificFacilitySubtractionPersonLack();
    }
    return specificFacilitySubtractionPersonLack;

  }

  /**
   * �O���T�[�r�X���擾���܂��B
   * @return �O���T�[�r�X
   */
  public ACValueArrayRadioButtonGroup getOutsideServiceRadio(){
    if(outsideServiceRadio==null){

      outsideServiceRadio = new ACValueArrayRadioButtonGroup();

      getOutsideServiceRadioContainer().setText("�O���T�[�r�X");

      outsideServiceRadio.setBindPath("1350104");

      outsideServiceRadio.setUseClearButton(false);

      outsideServiceRadio.setModel(getOutsideServiceRadioModel());

      outsideServiceRadio.setValues(new int[]{9,1,2,3,4,5,6,7,8});

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

      outsideServiceRadioItem7.setConstraints(VRLayout.FLOW_RETURN);

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

      outsideServiceRadioItem8.setConstraints(VRLayout.FLOW);

      addOutsideServiceRadioItem8();
    }
    return outsideServiceRadioItem8;

  }

  /**
   * �񋟎��ԃR���e�i���擾���܂��B
   * @return �񋟎��ԃR���e�i
   */
  public ACBackLabelContainer getSpecificFacilityTimeContena(){
    if(specificFacilityTimeContena==null){

      specificFacilityTimeContena = new ACBackLabelContainer();

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
   * �^�u�p�l��2���擾���܂��B
   * @return �^�u�p�l��2
   */
  public ACPanel getTabPanel2(){
    if(tabPanel2==null){

      tabPanel2 = new ACPanel();

      tabPanel2.setHgap(0);

      addTabPanel2();
    }
    return tabPanel2;

  }

  /**
   * �T�[�r�X���Z�p�l�����擾���܂��B
   * @return �T�[�r�X���Z�p�l��
   */
  public ACPanel getServicePanelAdd(){
    if(servicePanelAdd==null){

      servicePanelAdd = new ACPanel();

      servicePanelAdd.setFollowChildEnabled(true);

      servicePanelAdd.setHgap(0);

      servicePanelAdd.setLabelMargin(0);

      servicePanelAdd.setVgap(0);

      addServicePanelAdd();
    }
    return servicePanelAdd;

  }

  /**
   * �ʋ@�\�P�����Z���擾���܂��B
   * @return �ʋ@�\�P�����Z
   */
  public ACClearableRadioButtonGroup getSpecificFacilityFunctionTrainingRadio(){
    if(specificFacilityFunctionTrainingRadio==null){

      specificFacilityFunctionTrainingRadio = new ACClearableRadioButtonGroup();

      getSpecificFacilityFunctionTrainingRadioContainer().setText("�ʋ@�\�P�����Z");

      specificFacilityFunctionTrainingRadio.setBindPath("1350102");

      specificFacilityFunctionTrainingRadio.setUseClearButton(false);

      specificFacilityFunctionTrainingRadio.setModel(getSpecificFacilityFunctionTrainingRadioModel());

      addSpecificFacilityFunctionTrainingRadio();
    }
    return specificFacilityFunctionTrainingRadio;

  }

  /**
   * �ʋ@�\�P�����Z�R���e�i���擾���܂��B
   * @return �ʋ@�\�P�����Z�R���e�i
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
   * �ʋ@�\�P�����Z���f�����擾���܂��B
   * @return �ʋ@�\�P�����Z���f��
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
   * ��Ë@�֘A�g���Z���擾���܂��B
   * @return ��Ë@�֘A�g���Z
   */
  public ACClearableRadioButtonGroup getMedicalCoordinateAddRadioGroup(){
    if(medicalCoordinateAddRadioGroup==null){

      medicalCoordinateAddRadioGroup = new ACClearableRadioButtonGroup();

      getMedicalCoordinateAddRadioGroupContainer().setText("��Ë@�֘A�g���Z");

      medicalCoordinateAddRadioGroup.setBindPath("1350127");

      medicalCoordinateAddRadioGroup.setUseClearButton(false);

      medicalCoordinateAddRadioGroup.setModel(getMedicalCoordinateAddRadioGroupModel());

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
  public ACClearableRadioButtonGroup getImpairedPersonHelpAddRadioGroup(){
    if(impairedPersonHelpAddRadioGroup==null){

      impairedPersonHelpAddRadioGroup = new ACClearableRadioButtonGroup();

      getImpairedPersonHelpAddRadioGroupContainer().setText("��Q�ғ��x�����Z");

      impairedPersonHelpAddRadioGroup.setBindPath("1350128");

      impairedPersonHelpAddRadioGroup.setUseClearButton(false);

      impairedPersonHelpAddRadioGroup.setModel(getImpairedPersonHelpAddRadioGroupModel());

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
   * �K�������擾���܂��B
   * @return �K�����
   */
  public ACClearableRadioButtonGroup getVisitCareRadio(){
    if(visitCareRadio==null){

      visitCareRadio = new ACClearableRadioButtonGroup();

      getVisitCareRadioContainer().setText("�K�����");

      visitCareRadio.setBindPath("1350105");

      visitCareRadio.setUseClearButton(false);

      visitCareRadio.setModel(getVisitCareRadioModel());

      addVisitCareRadio();
    }
    return visitCareRadio;

  }

  /**
   * �K�����R���e�i���擾���܂��B
   * @return �K�����R���e�i
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
   * �K�����f�����擾���܂��B
   * @return �K�����f��
   */
  protected ACListModelAdapter getVisitCareRadioModel(){
    if(visitCareRadioModel==null){
      visitCareRadioModel = new ACListModelAdapter();
      addVisitCareRadioModel();
    }
    return visitCareRadioModel;
  }

  /**
   * �T�^���擾���܂��B
   * @return �T�^
   */
  public ACRadioButtonItem getVisitCareRadioItem1(){
    if(visitCareRadioItem1==null){

      visitCareRadioItem1 = new ACRadioButtonItem();

      visitCareRadioItem1.setText("I�^");

      visitCareRadioItem1.setGroup(getVisitCareRadio());

      visitCareRadioItem1.setConstraints(VRLayout.FLOW);

      addVisitCareRadioItem1();
    }
    return visitCareRadioItem1;

  }

  /**
   * �U�^���擾���܂��B
   * @return �U�^
   */
  public ACRadioButtonItem getVisitCareRadioItem2(){
    if(visitCareRadioItem2==null){

      visitCareRadioItem2 = new ACRadioButtonItem();

      visitCareRadioItem2.setText("II�^");

      visitCareRadioItem2.setGroup(getVisitCareRadio());

      visitCareRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

      addVisitCareRadioItem2();
    }
    return visitCareRadioItem2;

  }

  /**
   * �V�^���擾���܂��B
   * @return �V�^
   */
  public ACRadioButtonItem getVisitCareRadioItem3(){
    if(visitCareRadioItem3==null){

      visitCareRadioItem3 = new ACRadioButtonItem();

      visitCareRadioItem3.setText("III�^");

      visitCareRadioItem3.setGroup(getVisitCareRadio());

      visitCareRadioItem3.setConstraints(VRLayout.FLOW);

      addVisitCareRadioItem3();
    }
    return visitCareRadioItem3;

  }

  /**
   * �������擾���܂��B
   * @return ����
   */
  public ACIntegerCheckBox getVisitCareCrackOnDayCheck(){
    if(visitCareCrackOnDayCheck==null){

      visitCareCrackOnDayCheck = new ACIntegerCheckBox();

      visitCareCrackOnDayCheck.setText("����");

      visitCareCrackOnDayCheck.setBindPath("1350106");

      visitCareCrackOnDayCheck.setSelectValue(2);

      visitCareCrackOnDayCheck.setUnSelectValue(1);

      addVisitCareCrackOnDayCheck();
    }
    return visitCareCrackOnDayCheck;

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
  public ACClearableRadioButtonGroup getVisitNursingFacilitiesDivisionRadio(){
    if(visitNursingFacilitiesDivisionRadio==null){

      visitNursingFacilitiesDivisionRadio = new ACClearableRadioButtonGroup();

      getVisitNursingFacilitiesDivisionRadioContainer().setText("�{�ݓ��̋敪");

      visitNursingFacilitiesDivisionRadio.setBindPath("1350107");

      visitNursingFacilitiesDivisionRadio.setUseClearButton(false);

      visitNursingFacilitiesDivisionRadio.setModel(getVisitNursingFacilitiesDivisionRadioModel());

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
  public ACClearableRadioButtonGroup getVisitNursingStaffDivisionRadio(){
    if(visitNursingStaffDivisionRadio==null){

      visitNursingStaffDivisionRadio = new ACClearableRadioButtonGroup();

      getVisitNursingStaffDivisionRadioContainer().setText("�E���敪");

      visitNursingStaffDivisionRadio.setBindPath("1350108");

      visitNursingStaffDivisionRadio.setUseClearButton(false);

      visitNursingStaffDivisionRadio.setModel(getVisitNursingStaffDivisionRadioModel());

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
   * ���ԋ敪�R���{���擾���܂��B
   * @return ���ԋ敪�R���{
   */
  public ACComboBox getVisitNursingCombo(){
    if(visitNursingCombo==null){

      visitNursingCombo = new ACComboBox();

      getVisitNursingComboContainer().setText("���ԋ敪");

      visitNursingCombo.setBindPath("1350109");

      visitNursingCombo.setEditable(false);

      visitNursingCombo.setModelBindPath("1350109");

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
   * �^�u�p�l��3���擾���܂��B
   * @return �^�u�p�l��3
   */
  public ACPanel getTabPanel3(){
    if(tabPanel3==null){

      tabPanel3 = new ACPanel();

      tabPanel3.setHgap(0);

      addTabPanel3();
    }
    return tabPanel3;

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
  public ACClearableRadioButtonGroup getVisitRehabiliRadio(){
    if(visitRehabiliRadio==null){

      visitRehabiliRadio = new ACClearableRadioButtonGroup();

      getVisitRehabiliRadioContainer().setText("�{�ݓ��̋敪");

      visitRehabiliRadio.setBindPath("1350110");

      visitRehabiliRadio.setUseClearButton(false);

      visitRehabiliRadio.setModel(getVisitRehabiliRadioModel());

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
   * �������擾���܂��B
   * @return ����
   */
  public ACIntegerCheckBox getExpertPlaceNursingCrackOnDayChaeck(){
    if(expertPlaceNursingCrackOnDayChaeck==null){

      expertPlaceNursingCrackOnDayChaeck = new ACIntegerCheckBox();

      expertPlaceNursingCrackOnDayChaeck.setText("����");

      expertPlaceNursingCrackOnDayChaeck.setBindPath("1350111");

      expertPlaceNursingCrackOnDayChaeck.setSelectValue(2);

      expertPlaceNursingCrackOnDayChaeck.setUnSelectValue(1);

      addExpertPlaceNursingCrackOnDayChaeck();
    }
    return expertPlaceNursingCrackOnDayChaeck;

  }

  /**
   * �^����@�\������Z���擾���܂��B
   * @return �^����@�\������Z
   */
  public ACClearableRadioButtonGroup getExpertPlaceNursingMovementFunctionImprovementAddRadio(){
    if(expertPlaceNursingMovementFunctionImprovementAddRadio==null){

      expertPlaceNursingMovementFunctionImprovementAddRadio = new ACClearableRadioButtonGroup();

      getExpertPlaceNursingMovementFunctionImprovementAddRadioContainer().setText("�^����@�\������Z");

      expertPlaceNursingMovementFunctionImprovementAddRadio.setBindPath("1350112");

      expertPlaceNursingMovementFunctionImprovementAddRadio.setUseClearButton(false);

      expertPlaceNursingMovementFunctionImprovementAddRadio.setModel(getExpertPlaceNursingMovementFunctionImprovementAddRadioModel());

      addExpertPlaceNursingMovementFunctionImprovementAddRadio();
    }
    return expertPlaceNursingMovementFunctionImprovementAddRadio;

  }

  /**
   * �^����@�\������Z�R���e�i���擾���܂��B
   * @return �^����@�\������Z�R���e�i
   */
  protected ACLabelContainer getExpertPlaceNursingMovementFunctionImprovementAddRadioContainer(){
    if(expertPlaceNursingMovementFunctionImprovementAddRadioContainer==null){
      expertPlaceNursingMovementFunctionImprovementAddRadioContainer = new ACLabelContainer();
      expertPlaceNursingMovementFunctionImprovementAddRadioContainer.setFollowChildEnabled(true);
      expertPlaceNursingMovementFunctionImprovementAddRadioContainer.setVAlignment(VRLayout.CENTER);
      expertPlaceNursingMovementFunctionImprovementAddRadioContainer.add(getExpertPlaceNursingMovementFunctionImprovementAddRadio(), null);
    }
    return expertPlaceNursingMovementFunctionImprovementAddRadioContainer;
  }

  /**
   * �^����@�\������Z���f�����擾���܂��B
   * @return �^����@�\������Z���f��
   */
  protected ACListModelAdapter getExpertPlaceNursingMovementFunctionImprovementAddRadioModel(){
    if(expertPlaceNursingMovementFunctionImprovementAddRadioModel==null){
      expertPlaceNursingMovementFunctionImprovementAddRadioModel = new ACListModelAdapter();
      addExpertPlaceNursingMovementFunctionImprovementAddRadioModel();
    }
    return expertPlaceNursingMovementFunctionImprovementAddRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getExpertPlaceNursingMovementFunctionImprovementAddRadioItem1(){
    if(expertPlaceNursingMovementFunctionImprovementAddRadioItem1==null){

      expertPlaceNursingMovementFunctionImprovementAddRadioItem1 = new ACRadioButtonItem();

      expertPlaceNursingMovementFunctionImprovementAddRadioItem1.setText("�Ȃ�");

      expertPlaceNursingMovementFunctionImprovementAddRadioItem1.setGroup(getExpertPlaceNursingMovementFunctionImprovementAddRadio());

      expertPlaceNursingMovementFunctionImprovementAddRadioItem1.setConstraints(VRLayout.FLOW);

      addExpertPlaceNursingMovementFunctionImprovementAddRadioItem1();
    }
    return expertPlaceNursingMovementFunctionImprovementAddRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getExpertPlaceNursingMovementFunctionImprovementAddRadioItem2(){
    if(expertPlaceNursingMovementFunctionImprovementAddRadioItem2==null){

      expertPlaceNursingMovementFunctionImprovementAddRadioItem2 = new ACRadioButtonItem();

      expertPlaceNursingMovementFunctionImprovementAddRadioItem2.setText("����");

      expertPlaceNursingMovementFunctionImprovementAddRadioItem2.setGroup(getExpertPlaceNursingMovementFunctionImprovementAddRadio());

      expertPlaceNursingMovementFunctionImprovementAddRadioItem2.setConstraints(VRLayout.FLOW);

      addExpertPlaceNursingMovementFunctionImprovementAddRadioItem2();
    }
    return expertPlaceNursingMovementFunctionImprovementAddRadioItem2;

  }

  /**
   * �h�{���P���Z���擾���܂��B
   * @return �h�{���P���Z
   */
  public ACClearableRadioButtonGroup getExpertPlaceNursingNourishmentImprovementAddRadio(){
    if(expertPlaceNursingNourishmentImprovementAddRadio==null){

      expertPlaceNursingNourishmentImprovementAddRadio = new ACClearableRadioButtonGroup();

      getExpertPlaceNursingNourishmentImprovementAddRadioContainer().setText("�h�{���P���Z");

      expertPlaceNursingNourishmentImprovementAddRadio.setBindPath("1350113");

      expertPlaceNursingNourishmentImprovementAddRadio.setUseClearButton(false);

      expertPlaceNursingNourishmentImprovementAddRadio.setModel(getExpertPlaceNursingNourishmentImprovementAddRadioModel());

      addExpertPlaceNursingNourishmentImprovementAddRadio();
    }
    return expertPlaceNursingNourishmentImprovementAddRadio;

  }

  /**
   * �h�{���P���Z�R���e�i���擾���܂��B
   * @return �h�{���P���Z�R���e�i
   */
  protected ACLabelContainer getExpertPlaceNursingNourishmentImprovementAddRadioContainer(){
    if(expertPlaceNursingNourishmentImprovementAddRadioContainer==null){
      expertPlaceNursingNourishmentImprovementAddRadioContainer = new ACLabelContainer();
      expertPlaceNursingNourishmentImprovementAddRadioContainer.setFollowChildEnabled(true);
      expertPlaceNursingNourishmentImprovementAddRadioContainer.setVAlignment(VRLayout.CENTER);
      expertPlaceNursingNourishmentImprovementAddRadioContainer.add(getExpertPlaceNursingNourishmentImprovementAddRadio(), null);
    }
    return expertPlaceNursingNourishmentImprovementAddRadioContainer;
  }

  /**
   * �h�{���P���Z���f�����擾���܂��B
   * @return �h�{���P���Z���f��
   */
  protected ACListModelAdapter getExpertPlaceNursingNourishmentImprovementAddRadioModel(){
    if(expertPlaceNursingNourishmentImprovementAddRadioModel==null){
      expertPlaceNursingNourishmentImprovementAddRadioModel = new ACListModelAdapter();
      addExpertPlaceNursingNourishmentImprovementAddRadioModel();
    }
    return expertPlaceNursingNourishmentImprovementAddRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getExpertPlaceNursingNourishmentImprovementAddRadioItem1(){
    if(expertPlaceNursingNourishmentImprovementAddRadioItem1==null){

      expertPlaceNursingNourishmentImprovementAddRadioItem1 = new ACRadioButtonItem();

      expertPlaceNursingNourishmentImprovementAddRadioItem1.setText("�Ȃ�");

      expertPlaceNursingNourishmentImprovementAddRadioItem1.setGroup(getExpertPlaceNursingNourishmentImprovementAddRadio());

      expertPlaceNursingNourishmentImprovementAddRadioItem1.setConstraints(VRLayout.FLOW);

      addExpertPlaceNursingNourishmentImprovementAddRadioItem1();
    }
    return expertPlaceNursingNourishmentImprovementAddRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getExpertPlaceNursingNourishmentImprovementAddRadioItem2(){
    if(expertPlaceNursingNourishmentImprovementAddRadioItem2==null){

      expertPlaceNursingNourishmentImprovementAddRadioItem2 = new ACRadioButtonItem();

      expertPlaceNursingNourishmentImprovementAddRadioItem2.setText("����");

      expertPlaceNursingNourishmentImprovementAddRadioItem2.setGroup(getExpertPlaceNursingNourishmentImprovementAddRadio());

      expertPlaceNursingNourishmentImprovementAddRadioItem2.setConstraints(VRLayout.FLOW);

      addExpertPlaceNursingNourishmentImprovementAddRadioItem2();
    }
    return expertPlaceNursingNourishmentImprovementAddRadioItem2;

  }

  /**
   * ���o�@�\������Z���擾���܂��B
   * @return ���o�@�\������Z
   */
  public ACClearableRadioButtonGroup getExpertPlaceNursingMouthFunctionImprovementAddRadio(){
    if(expertPlaceNursingMouthFunctionImprovementAddRadio==null){

      expertPlaceNursingMouthFunctionImprovementAddRadio = new ACClearableRadioButtonGroup();

      getExpertPlaceNursingMouthFunctionImprovementAddRadioContainer().setText("���o�@�\������Z");

      expertPlaceNursingMouthFunctionImprovementAddRadio.setBindPath("1350114");

      expertPlaceNursingMouthFunctionImprovementAddRadio.setUseClearButton(false);

      expertPlaceNursingMouthFunctionImprovementAddRadio.setModel(getExpertPlaceNursingMouthFunctionImprovementAddRadioModel());

      addExpertPlaceNursingMouthFunctionImprovementAddRadio();
    }
    return expertPlaceNursingMouthFunctionImprovementAddRadio;

  }

  /**
   * ���o�@�\������Z�R���e�i���擾���܂��B
   * @return ���o�@�\������Z�R���e�i
   */
  protected ACLabelContainer getExpertPlaceNursingMouthFunctionImprovementAddRadioContainer(){
    if(expertPlaceNursingMouthFunctionImprovementAddRadioContainer==null){
      expertPlaceNursingMouthFunctionImprovementAddRadioContainer = new ACLabelContainer();
      expertPlaceNursingMouthFunctionImprovementAddRadioContainer.setFollowChildEnabled(true);
      expertPlaceNursingMouthFunctionImprovementAddRadioContainer.setVAlignment(VRLayout.CENTER);
      expertPlaceNursingMouthFunctionImprovementAddRadioContainer.add(getExpertPlaceNursingMouthFunctionImprovementAddRadio(), null);
    }
    return expertPlaceNursingMouthFunctionImprovementAddRadioContainer;
  }

  /**
   * ���o�@�\������Z���f�����擾���܂��B
   * @return ���o�@�\������Z���f��
   */
  protected ACListModelAdapter getExpertPlaceNursingMouthFunctionImprovementAddRadioModel(){
    if(expertPlaceNursingMouthFunctionImprovementAddRadioModel==null){
      expertPlaceNursingMouthFunctionImprovementAddRadioModel = new ACListModelAdapter();
      addExpertPlaceNursingMouthFunctionImprovementAddRadioModel();
    }
    return expertPlaceNursingMouthFunctionImprovementAddRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getExpertPlaceNursingMouthFunctionImprovementAddRadioItem1(){
    if(expertPlaceNursingMouthFunctionImprovementAddRadioItem1==null){

      expertPlaceNursingMouthFunctionImprovementAddRadioItem1 = new ACRadioButtonItem();

      expertPlaceNursingMouthFunctionImprovementAddRadioItem1.setText("�Ȃ�");

      expertPlaceNursingMouthFunctionImprovementAddRadioItem1.setGroup(getExpertPlaceNursingMouthFunctionImprovementAddRadio());

      expertPlaceNursingMouthFunctionImprovementAddRadioItem1.setConstraints(VRLayout.FLOW);

      addExpertPlaceNursingMouthFunctionImprovementAddRadioItem1();
    }
    return expertPlaceNursingMouthFunctionImprovementAddRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getExpertPlaceNursingMouthFunctionImprovementAddRadioItem2(){
    if(expertPlaceNursingMouthFunctionImprovementAddRadioItem2==null){

      expertPlaceNursingMouthFunctionImprovementAddRadioItem2 = new ACRadioButtonItem();

      expertPlaceNursingMouthFunctionImprovementAddRadioItem2.setText("����");

      expertPlaceNursingMouthFunctionImprovementAddRadioItem2.setGroup(getExpertPlaceNursingMouthFunctionImprovementAddRadio());

      expertPlaceNursingMouthFunctionImprovementAddRadioItem2.setConstraints(VRLayout.FLOW);

      addExpertPlaceNursingMouthFunctionImprovementAddRadioItem2();
    }
    return expertPlaceNursingMouthFunctionImprovementAddRadioItem2;

  }

  /**
   * �^�u�p�l��4���擾���܂��B
   * @return �^�u�p�l��4
   */
  public ACPanel getTabPanel4(){
    if(tabPanel4==null){

      tabPanel4 = new ACPanel();

      tabPanel4.setHgap(0);

      addTabPanel4();
    }
    return tabPanel4;

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
   * �������擾���܂��B
   * @return ����
   */
  public ACIntegerCheckBox getExpertPlaceRehabiliCrackOnDay(){
    if(expertPlaceRehabiliCrackOnDay==null){

      expertPlaceRehabiliCrackOnDay = new ACIntegerCheckBox();

      expertPlaceRehabiliCrackOnDay.setText("����");

      expertPlaceRehabiliCrackOnDay.setBindPath("1350115");

      expertPlaceRehabiliCrackOnDay.setSelectValue(2);

      expertPlaceRehabiliCrackOnDay.setUnSelectValue(1);

      addExpertPlaceRehabiliCrackOnDay();
    }
    return expertPlaceRehabiliCrackOnDay;

  }

  /**
   * �^����@�\������Z���擾���܂��B
   * @return �^����@�\������Z
   */
  public ACClearableRadioButtonGroup getExpertPlaceRehabiliMovementFunctionImprovementAddRadio(){
    if(expertPlaceRehabiliMovementFunctionImprovementAddRadio==null){

      expertPlaceRehabiliMovementFunctionImprovementAddRadio = new ACClearableRadioButtonGroup();

      getExpertPlaceRehabiliMovementFunctionImprovementAddRadioContainer().setText("�^����@�\������Z");

      expertPlaceRehabiliMovementFunctionImprovementAddRadio.setBindPath("1350116");

      expertPlaceRehabiliMovementFunctionImprovementAddRadio.setUseClearButton(false);

      expertPlaceRehabiliMovementFunctionImprovementAddRadio.setModel(getExpertPlaceRehabiliMovementFunctionImprovementAddRadioModel());

      addExpertPlaceRehabiliMovementFunctionImprovementAddRadio();
    }
    return expertPlaceRehabiliMovementFunctionImprovementAddRadio;

  }

  /**
   * �^����@�\������Z�R���e�i���擾���܂��B
   * @return �^����@�\������Z�R���e�i
   */
  protected ACLabelContainer getExpertPlaceRehabiliMovementFunctionImprovementAddRadioContainer(){
    if(expertPlaceRehabiliMovementFunctionImprovementAddRadioContainer==null){
      expertPlaceRehabiliMovementFunctionImprovementAddRadioContainer = new ACLabelContainer();
      expertPlaceRehabiliMovementFunctionImprovementAddRadioContainer.setFollowChildEnabled(true);
      expertPlaceRehabiliMovementFunctionImprovementAddRadioContainer.setVAlignment(VRLayout.CENTER);
      expertPlaceRehabiliMovementFunctionImprovementAddRadioContainer.add(getExpertPlaceRehabiliMovementFunctionImprovementAddRadio(), null);
    }
    return expertPlaceRehabiliMovementFunctionImprovementAddRadioContainer;
  }

  /**
   * �^����@�\������Z���f�����擾���܂��B
   * @return �^����@�\������Z���f��
   */
  protected ACListModelAdapter getExpertPlaceRehabiliMovementFunctionImprovementAddRadioModel(){
    if(expertPlaceRehabiliMovementFunctionImprovementAddRadioModel==null){
      expertPlaceRehabiliMovementFunctionImprovementAddRadioModel = new ACListModelAdapter();
      addExpertPlaceRehabiliMovementFunctionImprovementAddRadioModel();
    }
    return expertPlaceRehabiliMovementFunctionImprovementAddRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getExpertPlaceRehabiliMovementFunctionImprovementAddRadioItem1(){
    if(expertPlaceRehabiliMovementFunctionImprovementAddRadioItem1==null){

      expertPlaceRehabiliMovementFunctionImprovementAddRadioItem1 = new ACRadioButtonItem();

      expertPlaceRehabiliMovementFunctionImprovementAddRadioItem1.setText("�Ȃ�");

      expertPlaceRehabiliMovementFunctionImprovementAddRadioItem1.setGroup(getExpertPlaceRehabiliMovementFunctionImprovementAddRadio());

      expertPlaceRehabiliMovementFunctionImprovementAddRadioItem1.setConstraints(VRLayout.FLOW);

      addExpertPlaceRehabiliMovementFunctionImprovementAddRadioItem1();
    }
    return expertPlaceRehabiliMovementFunctionImprovementAddRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getExpertPlaceRehabiliMovementFunctionImprovementAddRadioItem2(){
    if(expertPlaceRehabiliMovementFunctionImprovementAddRadioItem2==null){

      expertPlaceRehabiliMovementFunctionImprovementAddRadioItem2 = new ACRadioButtonItem();

      expertPlaceRehabiliMovementFunctionImprovementAddRadioItem2.setText("����");

      expertPlaceRehabiliMovementFunctionImprovementAddRadioItem2.setGroup(getExpertPlaceRehabiliMovementFunctionImprovementAddRadio());

      expertPlaceRehabiliMovementFunctionImprovementAddRadioItem2.setConstraints(VRLayout.FLOW);

      addExpertPlaceRehabiliMovementFunctionImprovementAddRadioItem2();
    }
    return expertPlaceRehabiliMovementFunctionImprovementAddRadioItem2;

  }

  /**
   * �h�{���P���Z���擾���܂��B
   * @return �h�{���P���Z
   */
  public ACClearableRadioButtonGroup getExpertPlaceRehabiliNourishmentImprovementAddRadio(){
    if(expertPlaceRehabiliNourishmentImprovementAddRadio==null){

      expertPlaceRehabiliNourishmentImprovementAddRadio = new ACClearableRadioButtonGroup();

      getExpertPlaceRehabiliNourishmentImprovementAddRadioContainer().setText("�h�{���P���Z");

      expertPlaceRehabiliNourishmentImprovementAddRadio.setBindPath("1350117");

      expertPlaceRehabiliNourishmentImprovementAddRadio.setUseClearButton(false);

      expertPlaceRehabiliNourishmentImprovementAddRadio.setModel(getExpertPlaceRehabiliNourishmentImprovementAddRadioModel());

      addExpertPlaceRehabiliNourishmentImprovementAddRadio();
    }
    return expertPlaceRehabiliNourishmentImprovementAddRadio;

  }

  /**
   * �h�{���P���Z�R���e�i���擾���܂��B
   * @return �h�{���P���Z�R���e�i
   */
  protected ACLabelContainer getExpertPlaceRehabiliNourishmentImprovementAddRadioContainer(){
    if(expertPlaceRehabiliNourishmentImprovementAddRadioContainer==null){
      expertPlaceRehabiliNourishmentImprovementAddRadioContainer = new ACLabelContainer();
      expertPlaceRehabiliNourishmentImprovementAddRadioContainer.setFollowChildEnabled(true);
      expertPlaceRehabiliNourishmentImprovementAddRadioContainer.setVAlignment(VRLayout.CENTER);
      expertPlaceRehabiliNourishmentImprovementAddRadioContainer.add(getExpertPlaceRehabiliNourishmentImprovementAddRadio(), null);
    }
    return expertPlaceRehabiliNourishmentImprovementAddRadioContainer;
  }

  /**
   * �h�{���P���Z���f�����擾���܂��B
   * @return �h�{���P���Z���f��
   */
  protected ACListModelAdapter getExpertPlaceRehabiliNourishmentImprovementAddRadioModel(){
    if(expertPlaceRehabiliNourishmentImprovementAddRadioModel==null){
      expertPlaceRehabiliNourishmentImprovementAddRadioModel = new ACListModelAdapter();
      addExpertPlaceRehabiliNourishmentImprovementAddRadioModel();
    }
    return expertPlaceRehabiliNourishmentImprovementAddRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getExpertPlaceRehabiliNourishmentImprovementAddRadioItem1(){
    if(expertPlaceRehabiliNourishmentImprovementAddRadioItem1==null){

      expertPlaceRehabiliNourishmentImprovementAddRadioItem1 = new ACRadioButtonItem();

      expertPlaceRehabiliNourishmentImprovementAddRadioItem1.setText("�Ȃ�");

      expertPlaceRehabiliNourishmentImprovementAddRadioItem1.setGroup(getExpertPlaceRehabiliNourishmentImprovementAddRadio());

      expertPlaceRehabiliNourishmentImprovementAddRadioItem1.setConstraints(VRLayout.FLOW);

      addExpertPlaceRehabiliNourishmentImprovementAddRadioItem1();
    }
    return expertPlaceRehabiliNourishmentImprovementAddRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getExpertPlaceRehabiliNourishmentImprovementAddRadioItem2(){
    if(expertPlaceRehabiliNourishmentImprovementAddRadioItem2==null){

      expertPlaceRehabiliNourishmentImprovementAddRadioItem2 = new ACRadioButtonItem();

      expertPlaceRehabiliNourishmentImprovementAddRadioItem2.setText("����");

      expertPlaceRehabiliNourishmentImprovementAddRadioItem2.setGroup(getExpertPlaceRehabiliNourishmentImprovementAddRadio());

      expertPlaceRehabiliNourishmentImprovementAddRadioItem2.setConstraints(VRLayout.FLOW);

      addExpertPlaceRehabiliNourishmentImprovementAddRadioItem2();
    }
    return expertPlaceRehabiliNourishmentImprovementAddRadioItem2;

  }

  /**
   * ���o�@�\������Z���擾���܂��B
   * @return ���o�@�\������Z
   */
  public ACClearableRadioButtonGroup getExpertPlaceRehabiliMouthFunctionImprovementAddRadio(){
    if(expertPlaceRehabiliMouthFunctionImprovementAddRadio==null){

      expertPlaceRehabiliMouthFunctionImprovementAddRadio = new ACClearableRadioButtonGroup();

      getExpertPlaceRehabiliMouthFunctionImprovementAddRadioContainer().setText("���o�@�\������Z");

      expertPlaceRehabiliMouthFunctionImprovementAddRadio.setBindPath("1350118");

      expertPlaceRehabiliMouthFunctionImprovementAddRadio.setUseClearButton(false);

      expertPlaceRehabiliMouthFunctionImprovementAddRadio.setModel(getExpertPlaceRehabiliMouthFunctionImprovementAddRadioModel());

      addExpertPlaceRehabiliMouthFunctionImprovementAddRadio();
    }
    return expertPlaceRehabiliMouthFunctionImprovementAddRadio;

  }

  /**
   * ���o�@�\������Z�R���e�i���擾���܂��B
   * @return ���o�@�\������Z�R���e�i
   */
  protected ACLabelContainer getExpertPlaceRehabiliMouthFunctionImprovementAddRadioContainer(){
    if(expertPlaceRehabiliMouthFunctionImprovementAddRadioContainer==null){
      expertPlaceRehabiliMouthFunctionImprovementAddRadioContainer = new ACLabelContainer();
      expertPlaceRehabiliMouthFunctionImprovementAddRadioContainer.setFollowChildEnabled(true);
      expertPlaceRehabiliMouthFunctionImprovementAddRadioContainer.setVAlignment(VRLayout.CENTER);
      expertPlaceRehabiliMouthFunctionImprovementAddRadioContainer.add(getExpertPlaceRehabiliMouthFunctionImprovementAddRadio(), null);
    }
    return expertPlaceRehabiliMouthFunctionImprovementAddRadioContainer;
  }

  /**
   * ���o�@�\������Z���f�����擾���܂��B
   * @return ���o�@�\������Z���f��
   */
  protected ACListModelAdapter getExpertPlaceRehabiliMouthFunctionImprovementAddRadioModel(){
    if(expertPlaceRehabiliMouthFunctionImprovementAddRadioModel==null){
      expertPlaceRehabiliMouthFunctionImprovementAddRadioModel = new ACListModelAdapter();
      addExpertPlaceRehabiliMouthFunctionImprovementAddRadioModel();
    }
    return expertPlaceRehabiliMouthFunctionImprovementAddRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getExpertPlaceRehabiliMouthFunctionImprovementAddRadioItem1(){
    if(expertPlaceRehabiliMouthFunctionImprovementAddRadioItem1==null){

      expertPlaceRehabiliMouthFunctionImprovementAddRadioItem1 = new ACRadioButtonItem();

      expertPlaceRehabiliMouthFunctionImprovementAddRadioItem1.setText("�Ȃ�");

      expertPlaceRehabiliMouthFunctionImprovementAddRadioItem1.setGroup(getExpertPlaceRehabiliMouthFunctionImprovementAddRadio());

      expertPlaceRehabiliMouthFunctionImprovementAddRadioItem1.setConstraints(VRLayout.FLOW);

      addExpertPlaceRehabiliMouthFunctionImprovementAddRadioItem1();
    }
    return expertPlaceRehabiliMouthFunctionImprovementAddRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getExpertPlaceRehabiliMouthFunctionImprovementAddRadioItem2(){
    if(expertPlaceRehabiliMouthFunctionImprovementAddRadioItem2==null){

      expertPlaceRehabiliMouthFunctionImprovementAddRadioItem2 = new ACRadioButtonItem();

      expertPlaceRehabiliMouthFunctionImprovementAddRadioItem2.setText("����");

      expertPlaceRehabiliMouthFunctionImprovementAddRadioItem2.setGroup(getExpertPlaceRehabiliMouthFunctionImprovementAddRadio());

      expertPlaceRehabiliMouthFunctionImprovementAddRadioItem2.setConstraints(VRLayout.FLOW);

      addExpertPlaceRehabiliMouthFunctionImprovementAddRadioItem2();
    }
    return expertPlaceRehabiliMouthFunctionImprovementAddRadioItem2;

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

      welfareToolsCombo.setBindPath("1350119");

      welfareToolsCombo.setEditable(false);

      welfareToolsCombo.setColumns(4);

      welfareToolsCombo.setModelBindPath("1350119");

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

      welfarePointText.setBindPath("1350120");

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

      welfareTekiyoText.setBindPath("1170104");

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
   * �^�u�p�l��5���擾���܂��B
   * @return �^�u�p�l��5
   */
  public ACPanel getTabPanel5(){
    if(tabPanel5==null){

      tabPanel5 = new ACPanel();

      tabPanel5.setHgap(0);

      tabPanel5.setLabelMargin(0);

      tabPanel5.setVgap(0);

      addTabPanel5();
    }
    return tabPanel5;

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
  public ACClearableRadioButtonGroup getProviderDivisionRadio(){
    if(providerDivisionRadio==null){

      providerDivisionRadio = new ACClearableRadioButtonGroup();

      getProviderDivisionRadioContainer().setText("�{�ݓ��̋敪1");

      providerDivisionRadio.setBindPath("1350121");

      providerDivisionRadio.setUseClearButton(false);

      providerDivisionRadio.setModel(getProviderDivisionRadioModel());

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
  public ACClearableRadioButtonGroup getDivisionRadion(){
    if(divisionRadion==null){

      divisionRadion = new ACClearableRadioButtonGroup();

      getDivisionRadionContainer().setText("�{�ݓ��̋敪2");

      divisionRadion.setBindPath("1350122");

      divisionRadion.setUseClearButton(false);

      divisionRadion.setModel(getDivisionRadionModel());

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
  public ACClearableRadioButtonGroup getTimeDivisionRadio(){
    if(timeDivisionRadio==null){

      timeDivisionRadio = new ACClearableRadioButtonGroup();

      getTimeDivisionRadioContainer().setText("���ԋ敪");

      timeDivisionRadio.setBindPath("1350123");

      timeDivisionRadio.setUseClearButton(false);

      timeDivisionRadio.setModel(getTimeDivisionRadioModel());

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

      timeDivisionRadioItem2.setText("3����4����");

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

      timeDivisionRadioItem3.setText("4����6����");

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

      timeDivisionRadioItem4.setText("6����8����");

      timeDivisionRadioItem4.setGroup(getTimeDivisionRadio());

      timeDivisionRadioItem4.setConstraints(VRLayout.FLOW_RETURN);

      addTimeDivisionRadioItem4();
    }
    return timeDivisionRadioItem4;

  }

  /**
   * �ʋ@�\�P�����Z���擾���܂��B
   * @return �ʋ@�\�P�����Z
   */
  public ACClearableRadioButtonGroup getNinchishoTaioTsushoIndividualFunctionTrainingAddRadio(){
    if(ninchishoTaioTsushoIndividualFunctionTrainingAddRadio==null){

      ninchishoTaioTsushoIndividualFunctionTrainingAddRadio = new ACClearableRadioButtonGroup();

      getNinchishoTaioTsushoIndividualFunctionTrainingAddRadioContainer().setText("�ʋ@�\�P�����Z");

      ninchishoTaioTsushoIndividualFunctionTrainingAddRadio.setBindPath("1350124");

      ninchishoTaioTsushoIndividualFunctionTrainingAddRadio.setUseClearButton(false);

      ninchishoTaioTsushoIndividualFunctionTrainingAddRadio.setModel(getNinchishoTaioTsushoIndividualFunctionTrainingAddRadioModel());

      addNinchishoTaioTsushoIndividualFunctionTrainingAddRadio();
    }
    return ninchishoTaioTsushoIndividualFunctionTrainingAddRadio;

  }

  /**
   * �ʋ@�\�P�����Z�R���e�i���擾���܂��B
   * @return �ʋ@�\�P�����Z�R���e�i
   */
  protected ACLabelContainer getNinchishoTaioTsushoIndividualFunctionTrainingAddRadioContainer(){
    if(ninchishoTaioTsushoIndividualFunctionTrainingAddRadioContainer==null){
      ninchishoTaioTsushoIndividualFunctionTrainingAddRadioContainer = new ACLabelContainer();
      ninchishoTaioTsushoIndividualFunctionTrainingAddRadioContainer.setFollowChildEnabled(true);
      ninchishoTaioTsushoIndividualFunctionTrainingAddRadioContainer.setVAlignment(VRLayout.CENTER);
      ninchishoTaioTsushoIndividualFunctionTrainingAddRadioContainer.add(getNinchishoTaioTsushoIndividualFunctionTrainingAddRadio(), null);
    }
    return ninchishoTaioTsushoIndividualFunctionTrainingAddRadioContainer;
  }

  /**
   * �ʋ@�\�P�����Z���f�����擾���܂��B
   * @return �ʋ@�\�P�����Z���f��
   */
  protected ACListModelAdapter getNinchishoTaioTsushoIndividualFunctionTrainingAddRadioModel(){
    if(ninchishoTaioTsushoIndividualFunctionTrainingAddRadioModel==null){
      ninchishoTaioTsushoIndividualFunctionTrainingAddRadioModel = new ACListModelAdapter();
      addNinchishoTaioTsushoIndividualFunctionTrainingAddRadioModel();
    }
    return ninchishoTaioTsushoIndividualFunctionTrainingAddRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getNinchishoTaioTsushoIndividualFunctionTrainingAddRadioItem1(){
    if(ninchishoTaioTsushoIndividualFunctionTrainingAddRadioItem1==null){

      ninchishoTaioTsushoIndividualFunctionTrainingAddRadioItem1 = new ACRadioButtonItem();

      ninchishoTaioTsushoIndividualFunctionTrainingAddRadioItem1.setText("�Ȃ�");

      ninchishoTaioTsushoIndividualFunctionTrainingAddRadioItem1.setGroup(getNinchishoTaioTsushoIndividualFunctionTrainingAddRadio());

      ninchishoTaioTsushoIndividualFunctionTrainingAddRadioItem1.setConstraints(VRLayout.FLOW);

      addNinchishoTaioTsushoIndividualFunctionTrainingAddRadioItem1();
    }
    return ninchishoTaioTsushoIndividualFunctionTrainingAddRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getNinchishoTaioTsushoIndividualFunctionTrainingAddRadioItem2(){
    if(ninchishoTaioTsushoIndividualFunctionTrainingAddRadioItem2==null){

      ninchishoTaioTsushoIndividualFunctionTrainingAddRadioItem2 = new ACRadioButtonItem();

      ninchishoTaioTsushoIndividualFunctionTrainingAddRadioItem2.setText("����");

      ninchishoTaioTsushoIndividualFunctionTrainingAddRadioItem2.setGroup(getNinchishoTaioTsushoIndividualFunctionTrainingAddRadio());

      ninchishoTaioTsushoIndividualFunctionTrainingAddRadioItem2.setConstraints(VRLayout.FLOW);

      addNinchishoTaioTsushoIndividualFunctionTrainingAddRadioItem2();
    }
    return ninchishoTaioTsushoIndividualFunctionTrainingAddRadioItem2;

  }

  /**
   * �h�{���P���Z���擾���܂��B
   * @return �h�{���P���Z
   */
  public ACClearableRadioButtonGroup getNinchishoTaioTsushoNourishmentImprovementAddRadio(){
    if(ninchishoTaioTsushoNourishmentImprovementAddRadio==null){

      ninchishoTaioTsushoNourishmentImprovementAddRadio = new ACClearableRadioButtonGroup();

      getNinchishoTaioTsushoNourishmentImprovementAddRadioContainer().setText("�h�{���P���Z");

      ninchishoTaioTsushoNourishmentImprovementAddRadio.setBindPath("1350125");

      ninchishoTaioTsushoNourishmentImprovementAddRadio.setUseClearButton(false);

      ninchishoTaioTsushoNourishmentImprovementAddRadio.setModel(getNinchishoTaioTsushoNourishmentImprovementAddRadioModel());

      addNinchishoTaioTsushoNourishmentImprovementAddRadio();
    }
    return ninchishoTaioTsushoNourishmentImprovementAddRadio;

  }

  /**
   * �h�{���P���Z�R���e�i���擾���܂��B
   * @return �h�{���P���Z�R���e�i
   */
  protected ACLabelContainer getNinchishoTaioTsushoNourishmentImprovementAddRadioContainer(){
    if(ninchishoTaioTsushoNourishmentImprovementAddRadioContainer==null){
      ninchishoTaioTsushoNourishmentImprovementAddRadioContainer = new ACLabelContainer();
      ninchishoTaioTsushoNourishmentImprovementAddRadioContainer.setFollowChildEnabled(true);
      ninchishoTaioTsushoNourishmentImprovementAddRadioContainer.setVAlignment(VRLayout.CENTER);
      ninchishoTaioTsushoNourishmentImprovementAddRadioContainer.add(getNinchishoTaioTsushoNourishmentImprovementAddRadio(), null);
    }
    return ninchishoTaioTsushoNourishmentImprovementAddRadioContainer;
  }

  /**
   * �h�{���P���Z���f�����擾���܂��B
   * @return �h�{���P���Z���f��
   */
  protected ACListModelAdapter getNinchishoTaioTsushoNourishmentImprovementAddRadioModel(){
    if(ninchishoTaioTsushoNourishmentImprovementAddRadioModel==null){
      ninchishoTaioTsushoNourishmentImprovementAddRadioModel = new ACListModelAdapter();
      addNinchishoTaioTsushoNourishmentImprovementAddRadioModel();
    }
    return ninchishoTaioTsushoNourishmentImprovementAddRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getNinchishoTaioTsushoNourishmentImprovementAddRadioItem1(){
    if(ninchishoTaioTsushoNourishmentImprovementAddRadioItem1==null){

      ninchishoTaioTsushoNourishmentImprovementAddRadioItem1 = new ACRadioButtonItem();

      ninchishoTaioTsushoNourishmentImprovementAddRadioItem1.setText("�Ȃ�");

      ninchishoTaioTsushoNourishmentImprovementAddRadioItem1.setGroup(getNinchishoTaioTsushoNourishmentImprovementAddRadio());

      ninchishoTaioTsushoNourishmentImprovementAddRadioItem1.setConstraints(VRLayout.FLOW);

      addNinchishoTaioTsushoNourishmentImprovementAddRadioItem1();
    }
    return ninchishoTaioTsushoNourishmentImprovementAddRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getNinchishoTaioTsushoNourishmentImprovementAddRadioItem2(){
    if(ninchishoTaioTsushoNourishmentImprovementAddRadioItem2==null){

      ninchishoTaioTsushoNourishmentImprovementAddRadioItem2 = new ACRadioButtonItem();

      ninchishoTaioTsushoNourishmentImprovementAddRadioItem2.setText("����");

      ninchishoTaioTsushoNourishmentImprovementAddRadioItem2.setGroup(getNinchishoTaioTsushoNourishmentImprovementAddRadio());

      ninchishoTaioTsushoNourishmentImprovementAddRadioItem2.setConstraints(VRLayout.FLOW);

      addNinchishoTaioTsushoNourishmentImprovementAddRadioItem2();
    }
    return ninchishoTaioTsushoNourishmentImprovementAddRadioItem2;

  }

  /**
   * ���o�@�\������Z���擾���܂��B
   * @return ���o�@�\������Z
   */
  public ACClearableRadioButtonGroup getNinchishoTaioTsushoMouthFunctionImprovementAddRadio(){
    if(ninchishoTaioTsushoMouthFunctionImprovementAddRadio==null){

      ninchishoTaioTsushoMouthFunctionImprovementAddRadio = new ACClearableRadioButtonGroup();

      getNinchishoTaioTsushoMouthFunctionImprovementAddRadioContainer().setText("���o�@�\������Z");

      ninchishoTaioTsushoMouthFunctionImprovementAddRadio.setBindPath("1350126");

      ninchishoTaioTsushoMouthFunctionImprovementAddRadio.setUseClearButton(false);

      ninchishoTaioTsushoMouthFunctionImprovementAddRadio.setModel(getNinchishoTaioTsushoMouthFunctionImprovementAddRadioModel());

      addNinchishoTaioTsushoMouthFunctionImprovementAddRadio();
    }
    return ninchishoTaioTsushoMouthFunctionImprovementAddRadio;

  }

  /**
   * ���o�@�\������Z�R���e�i���擾���܂��B
   * @return ���o�@�\������Z�R���e�i
   */
  protected ACLabelContainer getNinchishoTaioTsushoMouthFunctionImprovementAddRadioContainer(){
    if(ninchishoTaioTsushoMouthFunctionImprovementAddRadioContainer==null){
      ninchishoTaioTsushoMouthFunctionImprovementAddRadioContainer = new ACLabelContainer();
      ninchishoTaioTsushoMouthFunctionImprovementAddRadioContainer.setFollowChildEnabled(true);
      ninchishoTaioTsushoMouthFunctionImprovementAddRadioContainer.setVAlignment(VRLayout.CENTER);
      ninchishoTaioTsushoMouthFunctionImprovementAddRadioContainer.add(getNinchishoTaioTsushoMouthFunctionImprovementAddRadio(), null);
    }
    return ninchishoTaioTsushoMouthFunctionImprovementAddRadioContainer;
  }

  /**
   * ���o�@�\������Z���f�����擾���܂��B
   * @return ���o�@�\������Z���f��
   */
  protected ACListModelAdapter getNinchishoTaioTsushoMouthFunctionImprovementAddRadioModel(){
    if(ninchishoTaioTsushoMouthFunctionImprovementAddRadioModel==null){
      ninchishoTaioTsushoMouthFunctionImprovementAddRadioModel = new ACListModelAdapter();
      addNinchishoTaioTsushoMouthFunctionImprovementAddRadioModel();
    }
    return ninchishoTaioTsushoMouthFunctionImprovementAddRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getNinchishoTaioTsushoMouthFunctionImprovementAddRadioItem1(){
    if(ninchishoTaioTsushoMouthFunctionImprovementAddRadioItem1==null){

      ninchishoTaioTsushoMouthFunctionImprovementAddRadioItem1 = new ACRadioButtonItem();

      ninchishoTaioTsushoMouthFunctionImprovementAddRadioItem1.setText("�Ȃ�");

      ninchishoTaioTsushoMouthFunctionImprovementAddRadioItem1.setGroup(getNinchishoTaioTsushoMouthFunctionImprovementAddRadio());

      ninchishoTaioTsushoMouthFunctionImprovementAddRadioItem1.setConstraints(VRLayout.FLOW);

      addNinchishoTaioTsushoMouthFunctionImprovementAddRadioItem1();
    }
    return ninchishoTaioTsushoMouthFunctionImprovementAddRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getNinchishoTaioTsushoMouthFunctionImprovementAddRadioItem2(){
    if(ninchishoTaioTsushoMouthFunctionImprovementAddRadioItem2==null){

      ninchishoTaioTsushoMouthFunctionImprovementAddRadioItem2 = new ACRadioButtonItem();

      ninchishoTaioTsushoMouthFunctionImprovementAddRadioItem2.setText("����");

      ninchishoTaioTsushoMouthFunctionImprovementAddRadioItem2.setGroup(getNinchishoTaioTsushoMouthFunctionImprovementAddRadio());

      ninchishoTaioTsushoMouthFunctionImprovementAddRadioItem2.setConstraints(VRLayout.FLOW);

      addNinchishoTaioTsushoMouthFunctionImprovementAddRadioItem2();
    }
    return ninchishoTaioTsushoMouthFunctionImprovementAddRadioItem2;

  }

  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001143_H2104Design() {

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

  }

  /**
   * �^�u�p�l��1�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTabPanel1(){

    tabPanel1.add(getFacilitiesDivisionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tabPanel1.add(getSpecificFacilitySubtractionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tabPanel1.add(getOutsideServiceRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tabPanel1.add(getSpecificFacilityTimeContena(), VRLayout.FLOW_DOUBLEINSETLINE_RETURN);

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
   * �Ō�E���E���������ɓ������ڂ�ǉ����܂��B
   */
  protected void addSpecificFacilitySubtractionPersonLack(){

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
   * �^�u�p�l��2�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTabPanel2(){

    tabPanel2.add(getServicePanelAdd(), VRLayout.NORTH);

    tabPanel2.add(getVisitCareGroup(), VRLayout.NORTH);

    tabPanel2.add(getVisitNursingRadioGroup(), VRLayout.NORTH);

  }

  /**
   * �T�[�r�X���Z�p�l���ɓ������ڂ�ǉ����܂��B
   */
  protected void addServicePanelAdd(){

    servicePanelAdd.add(getSpecificFacilityFunctionTrainingRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    servicePanelAdd.add(getMedicalCoordinateAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    servicePanelAdd.add(getImpairedPersonHelpAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * �ʋ@�\�P�����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addSpecificFacilityFunctionTrainingRadio(){

  }

  /**
   * �ʋ@�\�P�����Z���f���ɓ������ڂ�ǉ����܂��B
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
   * �K����O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addVisitCareGroup(){

    visitCareGroup.add(getVisitCareRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    visitCareGroup.add(getVisitCareCrackOnDayCheck(), VRLayout.FLOW_RETURN);

  }

  /**
   * �K�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addVisitCareRadio(){

  }

  /**
   * �K�����f���ɓ������ڂ�ǉ����܂��B
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
   * �T�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addVisitCareRadioItem1(){

  }

  /**
   * �U�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addVisitCareRadioItem2(){

  }

  /**
   * �V�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addVisitCareRadioItem3(){

  }

  /**
   * �����ɓ������ڂ�ǉ����܂��B
   */
  protected void addVisitCareCrackOnDayCheck(){

  }

  /**
   * �K��Ō�ɓ������ڂ�ǉ����܂��B
   */
  protected void addVisitNursingRadioGroup(){

    visitNursingRadioGroup.add(getVisitNursingFacilitiesDivisionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    visitNursingRadioGroup.add(getVisitNursingStaffDivisionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    visitNursingRadioGroup.add(getVisitNursingComboContainer(), VRLayout.FLOW);

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
   * �^�u�p�l��3�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTabPanel3(){

    tabPanel3.add(getVisitRehabiliGroup(), VRLayout.NORTH);

    tabPanel3.add(getExpertPlaceNursingGroup(), VRLayout.NORTH);

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
   * �ʏ����O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addExpertPlaceNursingGroup(){

    expertPlaceNursingGroup.add(getExpertPlaceNursingCrackOnDayChaeck(), VRLayout.FLOW_RETURN);

    expertPlaceNursingGroup.add(getExpertPlaceNursingMovementFunctionImprovementAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    expertPlaceNursingGroup.add(getExpertPlaceNursingNourishmentImprovementAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    expertPlaceNursingGroup.add(getExpertPlaceNursingMouthFunctionImprovementAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * �����ɓ������ڂ�ǉ����܂��B
   */
  protected void addExpertPlaceNursingCrackOnDayChaeck(){

  }

  /**
   * �^����@�\������Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addExpertPlaceNursingMovementFunctionImprovementAddRadio(){

  }

  /**
   * �^����@�\������Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addExpertPlaceNursingMovementFunctionImprovementAddRadioModel(){

    getExpertPlaceNursingMovementFunctionImprovementAddRadioItem1().setButtonIndex(1);

    getExpertPlaceNursingMovementFunctionImprovementAddRadioModel().add(getExpertPlaceNursingMovementFunctionImprovementAddRadioItem1());

    getExpertPlaceNursingMovementFunctionImprovementAddRadioItem2().setButtonIndex(2);

    getExpertPlaceNursingMovementFunctionImprovementAddRadioModel().add(getExpertPlaceNursingMovementFunctionImprovementAddRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addExpertPlaceNursingMovementFunctionImprovementAddRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addExpertPlaceNursingMovementFunctionImprovementAddRadioItem2(){

  }

  /**
   * �h�{���P���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addExpertPlaceNursingNourishmentImprovementAddRadio(){

  }

  /**
   * �h�{���P���Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addExpertPlaceNursingNourishmentImprovementAddRadioModel(){

    getExpertPlaceNursingNourishmentImprovementAddRadioItem1().setButtonIndex(1);

    getExpertPlaceNursingNourishmentImprovementAddRadioModel().add(getExpertPlaceNursingNourishmentImprovementAddRadioItem1());

    getExpertPlaceNursingNourishmentImprovementAddRadioItem2().setButtonIndex(2);

    getExpertPlaceNursingNourishmentImprovementAddRadioModel().add(getExpertPlaceNursingNourishmentImprovementAddRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addExpertPlaceNursingNourishmentImprovementAddRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addExpertPlaceNursingNourishmentImprovementAddRadioItem2(){

  }

  /**
   * ���o�@�\������Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addExpertPlaceNursingMouthFunctionImprovementAddRadio(){

  }

  /**
   * ���o�@�\������Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addExpertPlaceNursingMouthFunctionImprovementAddRadioModel(){

    getExpertPlaceNursingMouthFunctionImprovementAddRadioItem1().setButtonIndex(1);

    getExpertPlaceNursingMouthFunctionImprovementAddRadioModel().add(getExpertPlaceNursingMouthFunctionImprovementAddRadioItem1());

    getExpertPlaceNursingMouthFunctionImprovementAddRadioItem2().setButtonIndex(2);

    getExpertPlaceNursingMouthFunctionImprovementAddRadioModel().add(getExpertPlaceNursingMouthFunctionImprovementAddRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addExpertPlaceNursingMouthFunctionImprovementAddRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addExpertPlaceNursingMouthFunctionImprovementAddRadioItem2(){

  }

  /**
   * �^�u�p�l��4�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTabPanel4(){

    tabPanel4.add(getExpertPlaceRehabiliGroup(), VRLayout.NORTH);

    tabPanel4.add(getWelfareToolsGroup(), VRLayout.NORTH);

  }

  /**
   * �ʏ����n�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addExpertPlaceRehabiliGroup(){

    expertPlaceRehabiliGroup.add(getExpertPlaceRehabiliCrackOnDay(), VRLayout.FLOW_INSETLINE_RETURN);

    expertPlaceRehabiliGroup.add(getExpertPlaceRehabiliMovementFunctionImprovementAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    expertPlaceRehabiliGroup.add(getExpertPlaceRehabiliNourishmentImprovementAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    expertPlaceRehabiliGroup.add(getExpertPlaceRehabiliMouthFunctionImprovementAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * �����ɓ������ڂ�ǉ����܂��B
   */
  protected void addExpertPlaceRehabiliCrackOnDay(){

  }

  /**
   * �^����@�\������Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addExpertPlaceRehabiliMovementFunctionImprovementAddRadio(){

  }

  /**
   * �^����@�\������Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addExpertPlaceRehabiliMovementFunctionImprovementAddRadioModel(){

    getExpertPlaceRehabiliMovementFunctionImprovementAddRadioItem1().setButtonIndex(1);

    getExpertPlaceRehabiliMovementFunctionImprovementAddRadioModel().add(getExpertPlaceRehabiliMovementFunctionImprovementAddRadioItem1());

    getExpertPlaceRehabiliMovementFunctionImprovementAddRadioItem2().setButtonIndex(2);

    getExpertPlaceRehabiliMovementFunctionImprovementAddRadioModel().add(getExpertPlaceRehabiliMovementFunctionImprovementAddRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addExpertPlaceRehabiliMovementFunctionImprovementAddRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addExpertPlaceRehabiliMovementFunctionImprovementAddRadioItem2(){

  }

  /**
   * �h�{���P���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addExpertPlaceRehabiliNourishmentImprovementAddRadio(){

  }

  /**
   * �h�{���P���Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addExpertPlaceRehabiliNourishmentImprovementAddRadioModel(){

    getExpertPlaceRehabiliNourishmentImprovementAddRadioItem1().setButtonIndex(1);

    getExpertPlaceRehabiliNourishmentImprovementAddRadioModel().add(getExpertPlaceRehabiliNourishmentImprovementAddRadioItem1());

    getExpertPlaceRehabiliNourishmentImprovementAddRadioItem2().setButtonIndex(2);

    getExpertPlaceRehabiliNourishmentImprovementAddRadioModel().add(getExpertPlaceRehabiliNourishmentImprovementAddRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addExpertPlaceRehabiliNourishmentImprovementAddRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addExpertPlaceRehabiliNourishmentImprovementAddRadioItem2(){

  }

  /**
   * ���o�@�\������Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addExpertPlaceRehabiliMouthFunctionImprovementAddRadio(){

  }

  /**
   * ���o�@�\������Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addExpertPlaceRehabiliMouthFunctionImprovementAddRadioModel(){

    getExpertPlaceRehabiliMouthFunctionImprovementAddRadioItem1().setButtonIndex(1);

    getExpertPlaceRehabiliMouthFunctionImprovementAddRadioModel().add(getExpertPlaceRehabiliMouthFunctionImprovementAddRadioItem1());

    getExpertPlaceRehabiliMouthFunctionImprovementAddRadioItem2().setButtonIndex(2);

    getExpertPlaceRehabiliMouthFunctionImprovementAddRadioModel().add(getExpertPlaceRehabiliMouthFunctionImprovementAddRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addExpertPlaceRehabiliMouthFunctionImprovementAddRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addExpertPlaceRehabiliMouthFunctionImprovementAddRadioItem2(){

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
   * �^�u�p�l��5�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTabPanel5(){

    tabPanel5.add(getNinchishoTaioTsushoGroup(), VRLayout.NORTH);

  }

  /**
   * �F�m�ǑΉ��^�ʏ����O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addNinchishoTaioTsushoGroup(){

    ninchishoTaioTsushoGroup.add(getProviderDivisionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    ninchishoTaioTsushoGroup.add(getDivisionRadionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    ninchishoTaioTsushoGroup.add(getTimeDivisionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    ninchishoTaioTsushoGroup.add(getNinchishoTaioTsushoIndividualFunctionTrainingAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    ninchishoTaioTsushoGroup.add(getNinchishoTaioTsushoNourishmentImprovementAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    ninchishoTaioTsushoGroup.add(getNinchishoTaioTsushoMouthFunctionImprovementAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

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
   * �ʋ@�\�P�����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addNinchishoTaioTsushoIndividualFunctionTrainingAddRadio(){

  }

  /**
   * �ʋ@�\�P�����Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addNinchishoTaioTsushoIndividualFunctionTrainingAddRadioModel(){

    getNinchishoTaioTsushoIndividualFunctionTrainingAddRadioItem1().setButtonIndex(1);

    getNinchishoTaioTsushoIndividualFunctionTrainingAddRadioModel().add(getNinchishoTaioTsushoIndividualFunctionTrainingAddRadioItem1());

    getNinchishoTaioTsushoIndividualFunctionTrainingAddRadioItem2().setButtonIndex(2);

    getNinchishoTaioTsushoIndividualFunctionTrainingAddRadioModel().add(getNinchishoTaioTsushoIndividualFunctionTrainingAddRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addNinchishoTaioTsushoIndividualFunctionTrainingAddRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addNinchishoTaioTsushoIndividualFunctionTrainingAddRadioItem2(){

  }

  /**
   * �h�{���P���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addNinchishoTaioTsushoNourishmentImprovementAddRadio(){

  }

  /**
   * �h�{���P���Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addNinchishoTaioTsushoNourishmentImprovementAddRadioModel(){

    getNinchishoTaioTsushoNourishmentImprovementAddRadioItem1().setButtonIndex(1);

    getNinchishoTaioTsushoNourishmentImprovementAddRadioModel().add(getNinchishoTaioTsushoNourishmentImprovementAddRadioItem1());

    getNinchishoTaioTsushoNourishmentImprovementAddRadioItem2().setButtonIndex(2);

    getNinchishoTaioTsushoNourishmentImprovementAddRadioModel().add(getNinchishoTaioTsushoNourishmentImprovementAddRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addNinchishoTaioTsushoNourishmentImprovementAddRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addNinchishoTaioTsushoNourishmentImprovementAddRadioItem2(){

  }

  /**
   * ���o�@�\������Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addNinchishoTaioTsushoMouthFunctionImprovementAddRadio(){

  }

  /**
   * ���o�@�\������Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addNinchishoTaioTsushoMouthFunctionImprovementAddRadioModel(){

    getNinchishoTaioTsushoMouthFunctionImprovementAddRadioItem1().setButtonIndex(1);

    getNinchishoTaioTsushoMouthFunctionImprovementAddRadioModel().add(getNinchishoTaioTsushoMouthFunctionImprovementAddRadioItem1());

    getNinchishoTaioTsushoMouthFunctionImprovementAddRadioItem2().setButtonIndex(2);

    getNinchishoTaioTsushoMouthFunctionImprovementAddRadioModel().add(getNinchishoTaioTsushoMouthFunctionImprovementAddRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addNinchishoTaioTsushoMouthFunctionImprovementAddRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addNinchishoTaioTsushoMouthFunctionImprovementAddRadioItem2(){

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
      ACFrame.debugStart(new ACAffairInfo(QS001143_H2104Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QS001143_H2104Design getThis() {
    return this;
  }
}
