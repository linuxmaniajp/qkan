
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
 * �쐬��: 2012/04/09  ���{�R���s���[�^�[������� ����@��F �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �T�[�r�X�\��쐬/�ύX (S)
 * �v���Z�X �T�[�r�X�\��T�� (001)
 * �v���O���� �T�[�r�X�p�^�[�����V�l�ی��{�� (QS001_15211_201204)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
import java.awt.Color;
import java.awt.Component;
import java.awt.im.InputSubset;

import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;

import jp.nichicom.ac.component.ACComboBox;
import jp.nichicom.ac.component.ACIntegerCheckBox;
import jp.nichicom.ac.component.ACLabel;
import jp.nichicom.ac.component.ACMapBindButton;
import jp.nichicom.ac.component.ACRadioButtonItem;
import jp.nichicom.ac.component.ACTextField;
import jp.nichicom.ac.component.ACValueArrayRadioButtonGroup;
import jp.nichicom.ac.container.ACBackLabelContainer;
import jp.nichicom.ac.container.ACLabelContainer;
import jp.nichicom.ac.container.ACPanel;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.util.adapter.ACComboBoxModelAdapter;
import jp.nichicom.ac.util.adapter.ACListModelAdapter;
import jp.nichicom.vr.layout.VRLayout;
import jp.nichicom.vr.text.VRCharType;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
/**
 * �T�[�r�X�p�^�[�����V�l�ی��{�݉�ʍ��ڃf�U�C��(QS001_15211_201204) 
 */
public class QS001_15211_201204Design extends QS001ServicePanel {
  //GUI�R���|�[�l���g

  private JTabbedPane tabs;

  private ACPanel tab1;

  private ACValueArrayRadioButtonGroup kaigoHealthCareOfTheAgedDivisionRadio;

  private ACLabelContainer kaigoHealthCareOfTheAgedDivisionRadioContainer;

  private ACListModelAdapter kaigoHealthCareOfTheAgedDivisionRadioModel;

  private ACRadioButtonItem kaigoHealthCareOfTheAgedDivisionRadioItem1;

  private ACRadioButtonItem kaigoHealthCareOfTheAgedDivisionRadioItem2;

  private ACRadioButtonItem kaigoHealthCareOfTheAgedDivisionRadioItem3;

  private ACRadioButtonItem kaigoHealthCareOfTheAgedDivisionRadioItem4;

  private ACRadioButtonItem kaigoHealthCareOfTheAgedDivisionRadioItem5;

  private ACRadioButtonItem kaigoHealthCareOfTheAgedDivisionRadioItem6;

  private ACLabelContainer kaigoHealthCareOfTheAgedHospitalDivisionContainer;

  private ACValueArrayRadioButtonGroup kaigoHealthCareOfTheAgedHospitalDivision1;

  private ACListModelAdapter kaigoHealthCareOfTheAgedHospitalDivision1Model;

  private ACRadioButtonItem kaigoHealthCareOfTheAgedHospitalDivision11;

  private ACRadioButtonItem kaigoHealthCareOfTheAgedHospitalDivision12;

  private ACValueArrayRadioButtonGroup kaigoHealthCareOfTheAgedHospitalDivision2;

  private ACListModelAdapter kaigoHealthCareOfTheAgedHospitalDivision2Model;

  private ACRadioButtonItem kaigoHealthCareOfTheAgedHospitalDivision21;

  private ACRadioButtonItem kaigoHealthCareOfTheAgedHospitalDivision22;

  private ACLabelContainer kaigoHealthCareOfTheAgedHospitalRoomContena;

  private ACValueArrayRadioButtonGroup kaigoHealthCareOfTheAgedHospitalRoomRadio;

  private ACListModelAdapter kaigoHealthCareOfTheAgedHospitalRoomRadioModel;

  private ACRadioButtonItem kaigoHealthCareOfTheAgedHospitalRoomRadioItem1;

  private ACRadioButtonItem kaigoHealthCareOfTheAgedHospitalRoomRadioItem2;

  private ACValueArrayRadioButtonGroup kaigoHealthCareOfTheAgedUnitHospitalRoomRadio;

  private ACListModelAdapter kaigoHealthCareOfTheAgedUnitHospitalRoomRadioModel;

  private ACRadioButtonItem kaigoHealthCareOfTheAgedUnitHospitalRoomRadioItem1;

  private ACRadioButtonItem kaigoHealthCareOfTheAgedUnitHospitalRoomRadioItem2;

  private ACValueArrayRadioButtonGroup kaigoHealthCareOfTheAgedNightShiftSubtractionRadio;

  private ACLabelContainer kaigoHealthCareOfTheAgedNightShiftSubtractionRadioContainer;

  private ACListModelAdapter kaigoHealthCareOfTheAgedNightShiftSubtractionRadioModel;

  private ACRadioButtonItem kaigoHealthCareOfTheAgedNightShiftSubtractionRadioItem1;

  private ACRadioButtonItem kaigoHealthCareOfTheAgedNightShiftSubtractionRadioItem2;

  private ACLabelContainer shortConcentrationRehabiliContainer;

  private ACValueArrayRadioButtonGroup shortConcentrationRehabiliAddRadio;

  private ACListModelAdapter shortConcentrationRehabiliAddRadioModel;

  private ACRadioButtonItem shortConcentrationRehabiliAddRadioItem1;

  private ACRadioButtonItem shortConcentrationRehabiliAddRadioItem2;

  private ACIntegerCheckBox shortConcentrationRehabiliAddDementiaCheck;

  private ACPanel tab2;

  private ACValueArrayRadioButtonGroup kaigoHealthCareOfTheAgedStayingOutOvernightCostRadio;

  private ACLabelContainer kaigoHealthCareOfTheAgedStayingOutOvernightCostRadioContainer;

  private ACListModelAdapter kaigoHealthCareOfTheAgedStayingOutOvernightCostRadioModel;

  private ACRadioButtonItem kaigoHealthCareOfTheAgedStayingOutOvernightCostRadioItem1;

  private ACRadioButtonItem kaigoHealthCareOfTheAgedStayingOutOvernightCostRadioItem2;

  private ACValueArrayRadioButtonGroup kaigoHealthCareOfTheAgedDefaultRadio;

  private ACLabelContainer kaigoHealthCareOfTheAgedDefaultRadioContainer;

  private ACListModelAdapter kaigoHealthCareOfTheAgedDefaultRadioModel;

  private ACRadioButtonItem kaigoHealthCareOfTheAgedDefaultRadioItem1;

  private ACRadioButtonItem kaigoHealthCareOfTheAgedDefaultRadioItem2;

  private ACValueArrayRadioButtonGroup kaigoHealthCareOfTheAgedEmergencyRadio;

  private ACLabelContainer kaigoHealthCareOfTheAgedEmergencyRadioContainer;

  private ACListModelAdapter kaigoHealthCareOfTheAgedEmergencyRadioModel;

  private ACRadioButtonItem kaigoHealthCareOfTheAgedEmergencyRadioItem1;

  private ACRadioButtonItem kaigoHealthCareOfTheAgedEmergencyRadioItem2;

  private ACValueArrayRadioButtonGroup kaigoHealthCareOfTheAgedNutritionRadio;

  private ACLabelContainer kaigoHealthCareOfTheAgedNutritionRadioContainer;

  private ACListModelAdapter kaigoHealthCareOfTheAgedNutritionRadioModel;

  private ACRadioButtonItem kaigoHealthCareOfTheAgedNutritionRadioItem1;

  private ACRadioButtonItem kaigoHealthCareOfTheAgedNutritionRadioItem2;

  private ACValueArrayRadioButtonGroup kaigoHealthCareOfTheAgedOralSwitchRadio;

  private ACLabelContainer kaigoHealthCareOfTheAgedOralSwitchRadioContainer;

  private ACListModelAdapter kaigoHealthCareOfTheAgedOralSwitchRadioModel;

  private ACRadioButtonItem kaigoHealthCareOfTheAgedOralSwitchRadioItem1;

  private ACRadioButtonItem kaigoHealthCareOfTheAgedOralSwitchRadioItem2;

  private ACValueArrayRadioButtonGroup oralMaintenanceAddRadio;

  private ACLabelContainer oralMaintenanceAddRadioContainer;

  private ACListModelAdapter oralMaintenanceAddRadioModel;

  private ACRadioButtonItem oralMaintenanceAddRadioItem1;

  private ACRadioButtonItem oralMaintenanceAddRadioItem2;

  private ACRadioButtonItem oralMaintenanceAddRadioItem3;

  private ACValueArrayRadioButtonGroup oralKeepStructureAddRadioGroup;

  private ACLabelContainer oralKeepStructureAddRadioGroupContainer;

  private ACListModelAdapter oralKeepStructureAddRadioGroupModel;

  private ACRadioButtonItem oralKeepStructureAddRadioItem1;

  private ACRadioButtonItem oralKeepStructureAddRadioItem2;

  private ACValueArrayRadioButtonGroup oralKeepAddRadioGroup;

  private ACLabelContainer oralKeepAddRadioGroupContainer;

  private ACListModelAdapter oralKeepAddRadioGroupModel;

  private ACRadioButtonItem oralKeepAddRadioItem1;

  private ACRadioButtonItem oralKeepAddRadioItem2;

  private ACValueArrayRadioButtonGroup kaigoHealthCareOfTheAgedRecuperateDinnerRadio;

  private ACLabelContainer kaigoHealthCareOfTheAgedRecuperateDinnerRadioContainer;

  private ACListModelAdapter kaigoHealthCareOfTheAgedRecuperateDinnerRadioModel;

  private ACRadioButtonItem kaigoHealthCareOfTheAgedRecuperateDinnerRadioItem1;

  private ACRadioButtonItem kaigoHealthCareOfTheAgedRecuperateDinnerRadioItem2;

  private ACMapBindButton specialMedicalExpense;

  private ACLabel specialMedicalExpenseLabel;

  private ACBackLabelContainer kaigoHealthCareOfTheAgedDinnerContainer;

  private ACComboBox kaigoHealthCareOfTheAgedDinnerOffer;

  private ACLabelContainer kaigoHealthCareOfTheAgedDinnerOfferContainer;

  private ACComboBoxModelAdapter kaigoHealthCareOfTheAgedDinnerOfferModel;

  private ACTextField kaigoHealthCareOfTheAgedDinnerCost;

  private ACLabelContainer kaigoHealthCareOfTheAgedDinnerCostContainer;

  private ACPanel tab3;

  private ACValueArrayRadioButtonGroup kaigoHealthCareOfTheAgedStaffSubtraction;

  private ACLabelContainer kaigoHealthCareOfTheAgedStaffSubtractionContainer;

  private ACListModelAdapter kaigoHealthCareOfTheAgedStaffSubtractionModel;

  private ACRadioButtonItem kaigoHealthCareOfTheAgedStaffSubtractionCapacityNot;

  private ACRadioButtonItem kaigoHealthCareOfTheAgedStaffSubtractionCapacityExcess;

  private ACRadioButtonItem kaigoHealthCareOfTheAgedStaffSubtractionPersonLack;

  private ACValueArrayRadioButtonGroup unitCareMaintenanceRadio;

  private ACLabelContainer unitCareMaintenanceRadioContainer;

  private ACListModelAdapter unitCareMaintenanceRadioModel;

  private ACRadioButtonItem unitCareMaintenanceRadioItem1;

  private ACRadioButtonItem unitCareMaintenanceRadioItem2;

  private ACValueArrayRadioButtonGroup recuperationRadio;

  private ACLabelContainer recuperationRadioContainer;

  private ACListModelAdapter recuperationRadioModel;

  private ACRadioButtonItem recuperationRadioItem1;

  private ACRadioButtonItem recuperationRadioItem2;

  private ACValueArrayRadioButtonGroup nightStaffDispositionAddRadioGroup;

  private ACLabelContainer nightStaffDispositionAddRadioGroupContainer;

  private ACListModelAdapter nightStaffDispositionAddRadioGroupModel;

  private ACRadioButtonItem nightStaffDispositionAddRadioItem1;

  private ACRadioButtonItem nightStaffDispositionAddRadioItem2;

  private ACValueArrayRadioButtonGroup intentionCommunicationDifficultyAddRadio;

  private ACLabelContainer intentionCommunicationDifficultyAddRadioContainer;

  private ACListModelAdapter intentionCommunicationDifficultyAddRadioModel;

  private ACRadioButtonItem intentionCommunicationDifficultyAddRadioItem1;

  private ACRadioButtonItem intentionCommunicationDifficultyAddRadioItem2;

  private ACValueArrayRadioButtonGroup dementiaProfessionalCareAddRadioGroup;

  private ACLabelContainer dementiaProfessionalCareAddRadioGroupContainer;

  private ACListModelAdapter dementiaProfessionalCareAddRadioGroupModel;

  private ACRadioButtonItem dementiaProfessionalCareAddRadioItem1;

  private ACRadioButtonItem dementiaProfessionalCareAddRadioItem2;

  private ACRadioButtonItem dementiaProfessionalCareAddRadioItem3;

  private ACValueArrayRadioButtonGroup youngDementiaPatinetAddRadioGroup;

  private ACLabelContainer youngDementiaPatinetAddRadioGroupContainer;

  private ACListModelAdapter youngDementiaPatinetAddRadioGroupModel;

  private ACRadioButtonItem youngDementiaPatinetAddRadioItem1;

  private ACRadioButtonItem youngDementiaPatinetAddRadioItem2;

  private ACValueArrayRadioButtonGroup dementiainfoAddRadioGroup;

  private ACLabelContainer dementiainfoAddRadioGroupContainer;

  private ACListModelAdapter dementiainfoAddRadioGroupModel;

  private ACRadioButtonItem dementiainfoAddRadioItem1;

  private ACRadioButtonItem dementiainfoAddRadioItem2;

  private ACValueArrayRadioButtonGroup dementiaEmergencyAddRadioGroup;

  private ACLabelContainer dementiaEmergencyAddRadioGroupContainer;

  private ACListModelAdapter dementiaEmergencyAddRadioGroupModel;

  private ACRadioButtonItem dementiaEmergencyAddRadioItem1;

  private ACRadioButtonItem dementiaEmergencyAddRadioItem2;

  private ACValueArrayRadioButtonGroup bodyRestraintAbolitionRadio;

  private ACLabelContainer bodyRestraintAbolitionRadioContainer;

  private ACListModelAdapter bodyRestraintAbolitionRadioModel;

  private ACRadioButtonItem bodyRestraintAbolitionRadioItem1;

  private ACRadioButtonItem bodyRestraintAbolitionRadioItem2;

  private ACPanel tab4;

  private ACLabelContainer kaigoHealthCareOfTheAgedHijoAddition;

  private ACIntegerCheckBox leavingHospitalPreConsultationAddition;

  private ACIntegerCheckBox leavingHospitalAfterConsultationAddition;

  private ACIntegerCheckBox leavingHospitalConsultationAddition;

  private ACIntegerCheckBox leavingHospitalDissemination;

  private ACIntegerCheckBox leavingHospitalCooperationAddition;

  private ACIntegerCheckBox leavingHospital;

  private ACValueArrayRadioButtonGroup stayReturnSupportRyoyoAddRadio;

  private ACLabelContainer stayReturnSupportRyoyoAddRadioContainer;

  private ACListModelAdapter stayReturnSupportRyoyoAddRadioModel;

  private ACRadioButtonItem stayReturnSupportRyoyoAddRadioItem1;

  private ACRadioButtonItem stayReturnSupportRyoyoAddRadioItem2;

  private ACValueArrayRadioButtonGroup stayReturnSupportAddRadio;

  private ACLabelContainer stayReturnSupportAddRadioContainer;

  private ACListModelAdapter stayReturnSupportAddRadioModel;

  private ACRadioButtonItem stayReturnSupportAddRadioItem1;

  private ACRadioButtonItem stayReturnSupportAddRadioItem2;

  private ACValueArrayRadioButtonGroup terminalRadio;

  private ACLabelContainer terminalRadioContainer;

  private ACListModelAdapter terminalRadioModel;

  private ACRadioButtonItem terminalRadioItem1;

  private ACRadioButtonItem terminalRadioItem2;

  private ACRadioButtonItem terminalRadioItem3;

  private ACRadioButtonItem terminalRadioItem4;

  private ACLabelContainer terminalDaysContainer;

  private ACTextField terminalDays;

  private ACLabel terminalDaysUnit;

  private ACPanel tab5;

  private ACValueArrayRadioButtonGroup serviceAddProvisionStructuralRadioGroup;

  private ACLabelContainer serviceAddProvisionStructuralRadioGroupContainer;

  private ACListModelAdapter serviceAddProvisionStructuralRadioGroupModel;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem1;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem2;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem3;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem4;

  private ACValueArrayRadioButtonGroup enterHospitalPreConsultantRadio;

  private ACLabelContainer enterHospitalPreConsultantRadioContainer;

  private ACListModelAdapter enterHospitalPreConsultantRadioModel;

  private ACRadioButtonItem enterHospitalPreConsultantRadioItem1;

  private ACRadioButtonItem enterHospitalPreConsultantRadioItem2;

  private ACValueArrayRadioButtonGroup pneumoniaTreatmentRadio;

  private ACLabelContainer pneumoniaTreatmentRadioContainer;

  private ACListModelAdapter pneumoniaTreatmentRadioModel;

  private ACRadioButtonItem pneumoniaTreatmentRadioItem1;

  private ACRadioButtonItem pneumoniaTreatmentRadioItem2;

  private ACValueArrayRadioButtonGroup localTreatmentPlanInfoAddRadio;

  private ACLabelContainer localTreatmentPlanInfoAddRadioContainer;

  private ACListModelAdapter localTreatmentPlanInfoAddRadioModel;

  private ACRadioButtonItem localTreatmentPlanInfoAddRadioItem1;

  private ACRadioButtonItem localTreatmentPlanInfoAddRadioItem2;

  private ACValueArrayRadioButtonGroup kaigoHealthCareOfTheAgedCalculationDivisionRadio;

  private ACLabelContainer kaigoHealthCareOfTheAgedCalculationDivisionRadioContainer;

  private ACListModelAdapter kaigoHealthCareOfTheAgedCalculationDivisionRadioModel;

  private ACRadioButtonItem kaigoHealthCareOfTheAgedCalculationDivisionRadioItem1;

  private ACRadioButtonItem kaigoHealthCareOfTheAgedCalculationDivisionRadioItem2;

  //getter

  /**
   * �^�u�y�C�����擾���܂��B
   * @return �^�u�y�C��
   */
  public JTabbedPane getTabs(){
    if(tabs==null){

      tabs = new JTabbedPane();

      addTabs();
    }
    return tabs;

  }

  /**
   * �^�u1���擾���܂��B
   * @return �^�u1
   */
  public ACPanel getTab1(){
    if(tab1==null){

      tab1 = new ACPanel();

      tab1.setFollowChildEnabled(true);

      tab1.setHgap(0);

      addTab1();
    }
    return tab1;

  }

  /**
   * �{�ݓ��̋敪���擾���܂��B
   * @return �{�ݓ��̋敪
   */
  public ACValueArrayRadioButtonGroup getKaigoHealthCareOfTheAgedDivisionRadio(){
    if(kaigoHealthCareOfTheAgedDivisionRadio==null){

      kaigoHealthCareOfTheAgedDivisionRadio = new ACValueArrayRadioButtonGroup();

      getKaigoHealthCareOfTheAgedDivisionRadioContainer().setText("�{�ݓ��̋敪");

      kaigoHealthCareOfTheAgedDivisionRadio.setBindPath("1520101");

      kaigoHealthCareOfTheAgedDivisionRadio.setNoSelectIndex(0);

      kaigoHealthCareOfTheAgedDivisionRadio.setUseClearButton(false);

      kaigoHealthCareOfTheAgedDivisionRadio.setModel(getKaigoHealthCareOfTheAgedDivisionRadioModel());

      kaigoHealthCareOfTheAgedDivisionRadio.setValues(new int[]{1,2,3,4,5,6});

      addKaigoHealthCareOfTheAgedDivisionRadio();
    }
    return kaigoHealthCareOfTheAgedDivisionRadio;

  }

  /**
   * �{�ݓ��̋敪�R���e�i���擾���܂��B
   * @return �{�ݓ��̋敪�R���e�i
   */
  protected ACLabelContainer getKaigoHealthCareOfTheAgedDivisionRadioContainer(){
    if(kaigoHealthCareOfTheAgedDivisionRadioContainer==null){
      kaigoHealthCareOfTheAgedDivisionRadioContainer = new ACLabelContainer();
      kaigoHealthCareOfTheAgedDivisionRadioContainer.setFollowChildEnabled(true);
      kaigoHealthCareOfTheAgedDivisionRadioContainer.setVAlignment(VRLayout.CENTER);
      kaigoHealthCareOfTheAgedDivisionRadioContainer.add(getKaigoHealthCareOfTheAgedDivisionRadio(), null);
    }
    return kaigoHealthCareOfTheAgedDivisionRadioContainer;
  }

  /**
   * �{�ݓ��̋敪���f�����擾���܂��B
   * @return �{�ݓ��̋敪���f��
   */
  protected ACListModelAdapter getKaigoHealthCareOfTheAgedDivisionRadioModel(){
    if(kaigoHealthCareOfTheAgedDivisionRadioModel==null){
      kaigoHealthCareOfTheAgedDivisionRadioModel = new ACListModelAdapter();
      addKaigoHealthCareOfTheAgedDivisionRadioModel();
    }
    return kaigoHealthCareOfTheAgedDivisionRadioModel;
  }

  /**
   * ���V�l�ی��{�݁iI�j���擾���܂��B
   * @return ���V�l�ی��{�݁iI�j
   */
  public ACRadioButtonItem getKaigoHealthCareOfTheAgedDivisionRadioItem1(){
    if(kaigoHealthCareOfTheAgedDivisionRadioItem1==null){

      kaigoHealthCareOfTheAgedDivisionRadioItem1 = new ACRadioButtonItem();

      kaigoHealthCareOfTheAgedDivisionRadioItem1.setText("���V�l�ی��{�݁iI�j");

      kaigoHealthCareOfTheAgedDivisionRadioItem1.setGroup(getKaigoHealthCareOfTheAgedDivisionRadio());

      kaigoHealthCareOfTheAgedDivisionRadioItem1.setConstraints(VRLayout.FLOW_RETURN);

      addKaigoHealthCareOfTheAgedDivisionRadioItem1();
    }
    return kaigoHealthCareOfTheAgedDivisionRadioItem1;

  }

  /**
   * ���j�b�g�^���V�l�ی��{�݁iI�j���擾���܂��B
   * @return ���j�b�g�^���V�l�ی��{�݁iI�j
   */
  public ACRadioButtonItem getKaigoHealthCareOfTheAgedDivisionRadioItem2(){
    if(kaigoHealthCareOfTheAgedDivisionRadioItem2==null){

      kaigoHealthCareOfTheAgedDivisionRadioItem2 = new ACRadioButtonItem();

      kaigoHealthCareOfTheAgedDivisionRadioItem2.setText("���j�b�g�^���V�l�ی��{�݁iI�j");

      kaigoHealthCareOfTheAgedDivisionRadioItem2.setGroup(getKaigoHealthCareOfTheAgedDivisionRadio());

      kaigoHealthCareOfTheAgedDivisionRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

      addKaigoHealthCareOfTheAgedDivisionRadioItem2();
    }
    return kaigoHealthCareOfTheAgedDivisionRadioItem2;

  }

  /**
   * ���V�l�ی��{�݁iII�j���擾���܂��B
   * @return ���V�l�ی��{�݁iII�j
   */
  public ACRadioButtonItem getKaigoHealthCareOfTheAgedDivisionRadioItem3(){
    if(kaigoHealthCareOfTheAgedDivisionRadioItem3==null){

      kaigoHealthCareOfTheAgedDivisionRadioItem3 = new ACRadioButtonItem();

      kaigoHealthCareOfTheAgedDivisionRadioItem3.setText("���V�l�ی��{�݁iII�j");

      kaigoHealthCareOfTheAgedDivisionRadioItem3.setGroup(getKaigoHealthCareOfTheAgedDivisionRadio());

      kaigoHealthCareOfTheAgedDivisionRadioItem3.setConstraints(VRLayout.FLOW_RETURN);

      addKaigoHealthCareOfTheAgedDivisionRadioItem3();
    }
    return kaigoHealthCareOfTheAgedDivisionRadioItem3;

  }

  /**
   * ���j�b�g�^���V�l�ی��{�݁iII�j���擾���܂��B
   * @return ���j�b�g�^���V�l�ی��{�݁iII�j
   */
  public ACRadioButtonItem getKaigoHealthCareOfTheAgedDivisionRadioItem4(){
    if(kaigoHealthCareOfTheAgedDivisionRadioItem4==null){

      kaigoHealthCareOfTheAgedDivisionRadioItem4 = new ACRadioButtonItem();

      kaigoHealthCareOfTheAgedDivisionRadioItem4.setText("���j�b�g�^���V�l�ی��{�݁iII�j");

      kaigoHealthCareOfTheAgedDivisionRadioItem4.setGroup(getKaigoHealthCareOfTheAgedDivisionRadio());

      kaigoHealthCareOfTheAgedDivisionRadioItem4.setConstraints(VRLayout.FLOW_RETURN);

      addKaigoHealthCareOfTheAgedDivisionRadioItem4();
    }
    return kaigoHealthCareOfTheAgedDivisionRadioItem4;

  }

  /**
   * ���V�l�ی��{�݁iIII�j���擾���܂��B
   * @return ���V�l�ی��{�݁iIII�j
   */
  public ACRadioButtonItem getKaigoHealthCareOfTheAgedDivisionRadioItem5(){
    if(kaigoHealthCareOfTheAgedDivisionRadioItem5==null){

      kaigoHealthCareOfTheAgedDivisionRadioItem5 = new ACRadioButtonItem();

      kaigoHealthCareOfTheAgedDivisionRadioItem5.setText("���V�l�ی��{�݁iIII�j");

      kaigoHealthCareOfTheAgedDivisionRadioItem5.setGroup(getKaigoHealthCareOfTheAgedDivisionRadio());

      kaigoHealthCareOfTheAgedDivisionRadioItem5.setConstraints(VRLayout.FLOW_RETURN);

      addKaigoHealthCareOfTheAgedDivisionRadioItem5();
    }
    return kaigoHealthCareOfTheAgedDivisionRadioItem5;

  }

  /**
   * ���j�b�g�^���V�l�ی��{�݁iIII�j���擾���܂��B
   * @return ���j�b�g�^���V�l�ی��{�݁iIII�j
   */
  public ACRadioButtonItem getKaigoHealthCareOfTheAgedDivisionRadioItem6(){
    if(kaigoHealthCareOfTheAgedDivisionRadioItem6==null){

      kaigoHealthCareOfTheAgedDivisionRadioItem6 = new ACRadioButtonItem();

      kaigoHealthCareOfTheAgedDivisionRadioItem6.setText("���j�b�g�^���V�l�ی��{�݁iIII�j");

      kaigoHealthCareOfTheAgedDivisionRadioItem6.setGroup(getKaigoHealthCareOfTheAgedDivisionRadio());

      kaigoHealthCareOfTheAgedDivisionRadioItem6.setConstraints(VRLayout.FLOW_RETURN);

      addKaigoHealthCareOfTheAgedDivisionRadioItem6();
    }
    return kaigoHealthCareOfTheAgedDivisionRadioItem6;

  }

  /**
   * �l���z�u�敪�R���e�i���擾���܂��B
   * @return �l���z�u�敪�R���e�i
   */
  public ACLabelContainer getKaigoHealthCareOfTheAgedHospitalDivisionContainer(){
    if(kaigoHealthCareOfTheAgedHospitalDivisionContainer==null){

      kaigoHealthCareOfTheAgedHospitalDivisionContainer = new ACLabelContainer();

      kaigoHealthCareOfTheAgedHospitalDivisionContainer.setText("�l���z�u�敪");

      kaigoHealthCareOfTheAgedHospitalDivisionContainer.setFollowChildEnabled(true);

      addKaigoHealthCareOfTheAgedHospitalDivisionContainer();
    }
    return kaigoHealthCareOfTheAgedHospitalDivisionContainer;

  }

  /**
   * �l���z�u�敪���擾���܂��B
   * @return �l���z�u�敪
   */
  public ACValueArrayRadioButtonGroup getKaigoHealthCareOfTheAgedHospitalDivision1(){
    if(kaigoHealthCareOfTheAgedHospitalDivision1==null){

      kaigoHealthCareOfTheAgedHospitalDivision1 = new ACValueArrayRadioButtonGroup();

      kaigoHealthCareOfTheAgedHospitalDivision1.setBindPath("1520143");

      kaigoHealthCareOfTheAgedHospitalDivision1.setUseClearButton(false);

      kaigoHealthCareOfTheAgedHospitalDivision1.setModel(getKaigoHealthCareOfTheAgedHospitalDivision1Model());

      kaigoHealthCareOfTheAgedHospitalDivision1.setValues(new int[]{1,2});

      addKaigoHealthCareOfTheAgedHospitalDivision1();
    }
    return kaigoHealthCareOfTheAgedHospitalDivision1;

  }

  /**
   * �l���z�u�敪���f�����擾���܂��B
   * @return �l���z�u�敪���f��
   */
  protected ACListModelAdapter getKaigoHealthCareOfTheAgedHospitalDivision1Model(){
    if(kaigoHealthCareOfTheAgedHospitalDivision1Model==null){
      kaigoHealthCareOfTheAgedHospitalDivision1Model = new ACListModelAdapter();
      addKaigoHealthCareOfTheAgedHospitalDivision1Model();
    }
    return kaigoHealthCareOfTheAgedHospitalDivision1Model;
  }

  /**
   * �]���^���擾���܂��B
   * @return �]���^
   */
  public ACRadioButtonItem getKaigoHealthCareOfTheAgedHospitalDivision11(){
    if(kaigoHealthCareOfTheAgedHospitalDivision11==null){

      kaigoHealthCareOfTheAgedHospitalDivision11 = new ACRadioButtonItem();

      kaigoHealthCareOfTheAgedHospitalDivision11.setText("�]���^");

      kaigoHealthCareOfTheAgedHospitalDivision11.setGroup(getKaigoHealthCareOfTheAgedHospitalDivision1());

      kaigoHealthCareOfTheAgedHospitalDivision11.setConstraints(VRLayout.FLOW);

      addKaigoHealthCareOfTheAgedHospitalDivision11();
    }
    return kaigoHealthCareOfTheAgedHospitalDivision11;

  }

  /**
   * �ݑ���^���擾���܂��B
   * @return �ݑ���^
   */
  public ACRadioButtonItem getKaigoHealthCareOfTheAgedHospitalDivision12(){
    if(kaigoHealthCareOfTheAgedHospitalDivision12==null){

      kaigoHealthCareOfTheAgedHospitalDivision12 = new ACRadioButtonItem();

      kaigoHealthCareOfTheAgedHospitalDivision12.setText("�ݑ���^");

      kaigoHealthCareOfTheAgedHospitalDivision12.setGroup(getKaigoHealthCareOfTheAgedHospitalDivision1());

      kaigoHealthCareOfTheAgedHospitalDivision12.setConstraints(VRLayout.FLOW);

      addKaigoHealthCareOfTheAgedHospitalDivision12();
    }
    return kaigoHealthCareOfTheAgedHospitalDivision12;

  }

  /**
   * �l���z�u�敪�i�×{�^�j���擾���܂��B
   * @return �l���z�u�敪�i�×{�^�j
   */
  public ACValueArrayRadioButtonGroup getKaigoHealthCareOfTheAgedHospitalDivision2(){
    if(kaigoHealthCareOfTheAgedHospitalDivision2==null){

      kaigoHealthCareOfTheAgedHospitalDivision2 = new ACValueArrayRadioButtonGroup();

      kaigoHealthCareOfTheAgedHospitalDivision2.setBindPath("1520149");

      kaigoHealthCareOfTheAgedHospitalDivision2.setUseClearButton(false);

      kaigoHealthCareOfTheAgedHospitalDivision2.setModel(getKaigoHealthCareOfTheAgedHospitalDivision2Model());

      kaigoHealthCareOfTheAgedHospitalDivision2.setValues(new int[]{1,2});

      addKaigoHealthCareOfTheAgedHospitalDivision2();
    }
    return kaigoHealthCareOfTheAgedHospitalDivision2;

  }

  /**
   * �l���z�u�敪�i�×{�^�j���f�����擾���܂��B
   * @return �l���z�u�敪�i�×{�^�j���f��
   */
  protected ACListModelAdapter getKaigoHealthCareOfTheAgedHospitalDivision2Model(){
    if(kaigoHealthCareOfTheAgedHospitalDivision2Model==null){
      kaigoHealthCareOfTheAgedHospitalDivision2Model = new ACListModelAdapter();
      addKaigoHealthCareOfTheAgedHospitalDivision2Model();
    }
    return kaigoHealthCareOfTheAgedHospitalDivision2Model;
  }

  /**
   * �×{�^���擾���܂��B
   * @return �×{�^
   */
  public ACRadioButtonItem getKaigoHealthCareOfTheAgedHospitalDivision21(){
    if(kaigoHealthCareOfTheAgedHospitalDivision21==null){

      kaigoHealthCareOfTheAgedHospitalDivision21 = new ACRadioButtonItem();

      kaigoHealthCareOfTheAgedHospitalDivision21.setText("�×{�^");

      kaigoHealthCareOfTheAgedHospitalDivision21.setGroup(getKaigoHealthCareOfTheAgedHospitalDivision2());

      kaigoHealthCareOfTheAgedHospitalDivision21.setConstraints(VRLayout.FLOW);

      addKaigoHealthCareOfTheAgedHospitalDivision21();
    }
    return kaigoHealthCareOfTheAgedHospitalDivision21;

  }

  /**
   * �×{�����^���擾���܂��B
   * @return �×{�����^
   */
  public ACRadioButtonItem getKaigoHealthCareOfTheAgedHospitalDivision22(){
    if(kaigoHealthCareOfTheAgedHospitalDivision22==null){

      kaigoHealthCareOfTheAgedHospitalDivision22 = new ACRadioButtonItem();

      kaigoHealthCareOfTheAgedHospitalDivision22.setText("�×{�����^");

      kaigoHealthCareOfTheAgedHospitalDivision22.setGroup(getKaigoHealthCareOfTheAgedHospitalDivision2());

      kaigoHealthCareOfTheAgedHospitalDivision22.setConstraints(VRLayout.FLOW);

      addKaigoHealthCareOfTheAgedHospitalDivision22();
    }
    return kaigoHealthCareOfTheAgedHospitalDivision22;

  }

  /**
   * �a���敪�R���e�i���擾���܂��B
   * @return �a���敪�R���e�i
   */
  public ACLabelContainer getKaigoHealthCareOfTheAgedHospitalRoomContena(){
    if(kaigoHealthCareOfTheAgedHospitalRoomContena==null){

      kaigoHealthCareOfTheAgedHospitalRoomContena = new ACLabelContainer();

      kaigoHealthCareOfTheAgedHospitalRoomContena.setText("�a���敪");

      kaigoHealthCareOfTheAgedHospitalRoomContena.setFollowChildEnabled(true);

      addKaigoHealthCareOfTheAgedHospitalRoomContena();
    }
    return kaigoHealthCareOfTheAgedHospitalRoomContena;

  }

  /**
   * �a���敪�i���ی��{�݁j���擾���܂��B
   * @return �a���敪�i���ی��{�݁j
   */
  public ACValueArrayRadioButtonGroup getKaigoHealthCareOfTheAgedHospitalRoomRadio(){
    if(kaigoHealthCareOfTheAgedHospitalRoomRadio==null){

      kaigoHealthCareOfTheAgedHospitalRoomRadio = new ACValueArrayRadioButtonGroup();

      kaigoHealthCareOfTheAgedHospitalRoomRadio.setBindPath("1520102");

      kaigoHealthCareOfTheAgedHospitalRoomRadio.setUseClearButton(false);

      kaigoHealthCareOfTheAgedHospitalRoomRadio.setModel(getKaigoHealthCareOfTheAgedHospitalRoomRadioModel());

      kaigoHealthCareOfTheAgedHospitalRoomRadio.setValues(new int[]{1,2});

      addKaigoHealthCareOfTheAgedHospitalRoomRadio();
    }
    return kaigoHealthCareOfTheAgedHospitalRoomRadio;

  }

  /**
   * �a���敪�i���ی��{�݁j���f�����擾���܂��B
   * @return �a���敪�i���ی��{�݁j���f��
   */
  protected ACListModelAdapter getKaigoHealthCareOfTheAgedHospitalRoomRadioModel(){
    if(kaigoHealthCareOfTheAgedHospitalRoomRadioModel==null){
      kaigoHealthCareOfTheAgedHospitalRoomRadioModel = new ACListModelAdapter();
      addKaigoHealthCareOfTheAgedHospitalRoomRadioModel();
    }
    return kaigoHealthCareOfTheAgedHospitalRoomRadioModel;
  }

  /**
   * �]���^�����擾���܂��B
   * @return �]���^��
   */
  public ACRadioButtonItem getKaigoHealthCareOfTheAgedHospitalRoomRadioItem1(){
    if(kaigoHealthCareOfTheAgedHospitalRoomRadioItem1==null){

      kaigoHealthCareOfTheAgedHospitalRoomRadioItem1 = new ACRadioButtonItem();

      kaigoHealthCareOfTheAgedHospitalRoomRadioItem1.setText("�]���^��");

      kaigoHealthCareOfTheAgedHospitalRoomRadioItem1.setGroup(getKaigoHealthCareOfTheAgedHospitalRoomRadio());

      kaigoHealthCareOfTheAgedHospitalRoomRadioItem1.setConstraints(VRLayout.FLOW);

      addKaigoHealthCareOfTheAgedHospitalRoomRadioItem1();
    }
    return kaigoHealthCareOfTheAgedHospitalRoomRadioItem1;

  }

  /**
   * ���������擾���܂��B
   * @return ������
   */
  public ACRadioButtonItem getKaigoHealthCareOfTheAgedHospitalRoomRadioItem2(){
    if(kaigoHealthCareOfTheAgedHospitalRoomRadioItem2==null){

      kaigoHealthCareOfTheAgedHospitalRoomRadioItem2 = new ACRadioButtonItem();

      kaigoHealthCareOfTheAgedHospitalRoomRadioItem2.setText("������");

      kaigoHealthCareOfTheAgedHospitalRoomRadioItem2.setGroup(getKaigoHealthCareOfTheAgedHospitalRoomRadio());

      kaigoHealthCareOfTheAgedHospitalRoomRadioItem2.setConstraints(VRLayout.FLOW);

      addKaigoHealthCareOfTheAgedHospitalRoomRadioItem2();
    }
    return kaigoHealthCareOfTheAgedHospitalRoomRadioItem2;

  }

  /**
   * �a���敪�i���j�b�g�^�j���擾���܂��B
   * @return �a���敪�i���j�b�g�^�j
   */
  public ACValueArrayRadioButtonGroup getKaigoHealthCareOfTheAgedUnitHospitalRoomRadio(){
    if(kaigoHealthCareOfTheAgedUnitHospitalRoomRadio==null){

      kaigoHealthCareOfTheAgedUnitHospitalRoomRadio = new ACValueArrayRadioButtonGroup();

      kaigoHealthCareOfTheAgedUnitHospitalRoomRadio.setBindPath("1520103");

      kaigoHealthCareOfTheAgedUnitHospitalRoomRadio.setUseClearButton(false);

      kaigoHealthCareOfTheAgedUnitHospitalRoomRadio.setModel(getKaigoHealthCareOfTheAgedUnitHospitalRoomRadioModel());

      kaigoHealthCareOfTheAgedUnitHospitalRoomRadio.setValues(new int[]{1,2});

      addKaigoHealthCareOfTheAgedUnitHospitalRoomRadio();
    }
    return kaigoHealthCareOfTheAgedUnitHospitalRoomRadio;

  }

  /**
   * �a���敪�i���j�b�g�^�j���f�����擾���܂��B
   * @return �a���敪�i���j�b�g�^�j���f��
   */
  protected ACListModelAdapter getKaigoHealthCareOfTheAgedUnitHospitalRoomRadioModel(){
    if(kaigoHealthCareOfTheAgedUnitHospitalRoomRadioModel==null){
      kaigoHealthCareOfTheAgedUnitHospitalRoomRadioModel = new ACListModelAdapter();
      addKaigoHealthCareOfTheAgedUnitHospitalRoomRadioModel();
    }
    return kaigoHealthCareOfTheAgedUnitHospitalRoomRadioModel;
  }

  /**
   * ���j�b�g�^�����擾���܂��B
   * @return ���j�b�g�^��
   */
  public ACRadioButtonItem getKaigoHealthCareOfTheAgedUnitHospitalRoomRadioItem1(){
    if(kaigoHealthCareOfTheAgedUnitHospitalRoomRadioItem1==null){

      kaigoHealthCareOfTheAgedUnitHospitalRoomRadioItem1 = new ACRadioButtonItem();

      kaigoHealthCareOfTheAgedUnitHospitalRoomRadioItem1.setText("���j�b�g�^��");

      kaigoHealthCareOfTheAgedUnitHospitalRoomRadioItem1.setGroup(getKaigoHealthCareOfTheAgedUnitHospitalRoomRadio());

      kaigoHealthCareOfTheAgedUnitHospitalRoomRadioItem1.setConstraints(VRLayout.FLOW);

      addKaigoHealthCareOfTheAgedUnitHospitalRoomRadioItem1();
    }
    return kaigoHealthCareOfTheAgedUnitHospitalRoomRadioItem1;

  }

  /**
   * ���j�b�g�^�������擾���܂��B
   * @return ���j�b�g�^����
   */
  public ACRadioButtonItem getKaigoHealthCareOfTheAgedUnitHospitalRoomRadioItem2(){
    if(kaigoHealthCareOfTheAgedUnitHospitalRoomRadioItem2==null){

      kaigoHealthCareOfTheAgedUnitHospitalRoomRadioItem2 = new ACRadioButtonItem();

      kaigoHealthCareOfTheAgedUnitHospitalRoomRadioItem2.setText("���j�b�g�^����");

      kaigoHealthCareOfTheAgedUnitHospitalRoomRadioItem2.setGroup(getKaigoHealthCareOfTheAgedUnitHospitalRoomRadio());

      kaigoHealthCareOfTheAgedUnitHospitalRoomRadioItem2.setConstraints(VRLayout.FLOW);

      addKaigoHealthCareOfTheAgedUnitHospitalRoomRadioItem2();
    }
    return kaigoHealthCareOfTheAgedUnitHospitalRoomRadioItem2;

  }

  /**
   * ��ԋΖ���������擾���܂��B
   * @return ��ԋΖ������
   */
  public ACValueArrayRadioButtonGroup getKaigoHealthCareOfTheAgedNightShiftSubtractionRadio(){
    if(kaigoHealthCareOfTheAgedNightShiftSubtractionRadio==null){

      kaigoHealthCareOfTheAgedNightShiftSubtractionRadio = new ACValueArrayRadioButtonGroup();

      getKaigoHealthCareOfTheAgedNightShiftSubtractionRadioContainer().setText("��ԋΖ������");

      kaigoHealthCareOfTheAgedNightShiftSubtractionRadio.setBindPath("1520104");

      kaigoHealthCareOfTheAgedNightShiftSubtractionRadio.setUseClearButton(false);

      kaigoHealthCareOfTheAgedNightShiftSubtractionRadio.setModel(getKaigoHealthCareOfTheAgedNightShiftSubtractionRadioModel());

      kaigoHealthCareOfTheAgedNightShiftSubtractionRadio.setValues(new int[]{1,2});

      addKaigoHealthCareOfTheAgedNightShiftSubtractionRadio();
    }
    return kaigoHealthCareOfTheAgedNightShiftSubtractionRadio;

  }

  /**
   * ��ԋΖ�������R���e�i���擾���܂��B
   * @return ��ԋΖ�������R���e�i
   */
  protected ACLabelContainer getKaigoHealthCareOfTheAgedNightShiftSubtractionRadioContainer(){
    if(kaigoHealthCareOfTheAgedNightShiftSubtractionRadioContainer==null){
      kaigoHealthCareOfTheAgedNightShiftSubtractionRadioContainer = new ACLabelContainer();
      kaigoHealthCareOfTheAgedNightShiftSubtractionRadioContainer.setFollowChildEnabled(true);
      kaigoHealthCareOfTheAgedNightShiftSubtractionRadioContainer.setVAlignment(VRLayout.CENTER);
      kaigoHealthCareOfTheAgedNightShiftSubtractionRadioContainer.add(getKaigoHealthCareOfTheAgedNightShiftSubtractionRadio(), null);
    }
    return kaigoHealthCareOfTheAgedNightShiftSubtractionRadioContainer;
  }

  /**
   * ��ԋΖ���������f�����擾���܂��B
   * @return ��ԋΖ���������f��
   */
  protected ACListModelAdapter getKaigoHealthCareOfTheAgedNightShiftSubtractionRadioModel(){
    if(kaigoHealthCareOfTheAgedNightShiftSubtractionRadioModel==null){
      kaigoHealthCareOfTheAgedNightShiftSubtractionRadioModel = new ACListModelAdapter();
      addKaigoHealthCareOfTheAgedNightShiftSubtractionRadioModel();
    }
    return kaigoHealthCareOfTheAgedNightShiftSubtractionRadioModel;
  }

  /**
   * ��^���擾���܂��B
   * @return ��^
   */
  public ACRadioButtonItem getKaigoHealthCareOfTheAgedNightShiftSubtractionRadioItem1(){
    if(kaigoHealthCareOfTheAgedNightShiftSubtractionRadioItem1==null){

      kaigoHealthCareOfTheAgedNightShiftSubtractionRadioItem1 = new ACRadioButtonItem();

      kaigoHealthCareOfTheAgedNightShiftSubtractionRadioItem1.setText("��^");

      kaigoHealthCareOfTheAgedNightShiftSubtractionRadioItem1.setGroup(getKaigoHealthCareOfTheAgedNightShiftSubtractionRadio());

      kaigoHealthCareOfTheAgedNightShiftSubtractionRadioItem1.setConstraints(VRLayout.FLOW);

      addKaigoHealthCareOfTheAgedNightShiftSubtractionRadioItem1();
    }
    return kaigoHealthCareOfTheAgedNightShiftSubtractionRadioItem1;

  }

  /**
   * ���Z�^���擾���܂��B
   * @return ���Z�^
   */
  public ACRadioButtonItem getKaigoHealthCareOfTheAgedNightShiftSubtractionRadioItem2(){
    if(kaigoHealthCareOfTheAgedNightShiftSubtractionRadioItem2==null){

      kaigoHealthCareOfTheAgedNightShiftSubtractionRadioItem2 = new ACRadioButtonItem();

      kaigoHealthCareOfTheAgedNightShiftSubtractionRadioItem2.setText("���Z�^");

      kaigoHealthCareOfTheAgedNightShiftSubtractionRadioItem2.setGroup(getKaigoHealthCareOfTheAgedNightShiftSubtractionRadio());

      kaigoHealthCareOfTheAgedNightShiftSubtractionRadioItem2.setConstraints(VRLayout.FLOW);

      addKaigoHealthCareOfTheAgedNightShiftSubtractionRadioItem2();
    }
    return kaigoHealthCareOfTheAgedNightShiftSubtractionRadioItem2;

  }

  /**
   * �Z���W�����n�r�����Z�R���e�i���擾���܂��B
   * @return �Z���W�����n�r�����Z�R���e�i
   */
  public ACLabelContainer getShortConcentrationRehabiliContainer(){
    if(shortConcentrationRehabiliContainer==null){

      shortConcentrationRehabiliContainer = new ACLabelContainer();

      shortConcentrationRehabiliContainer.setText("�Z���W�����n�r�����Z");

      shortConcentrationRehabiliContainer.setFollowChildEnabled(true);

      addShortConcentrationRehabiliContainer();
    }
    return shortConcentrationRehabiliContainer;

  }

  /**
   * �Z���W�����n�r�����Z���擾���܂��B
   * @return �Z���W�����n�r�����Z
   */
  public ACValueArrayRadioButtonGroup getShortConcentrationRehabiliAddRadio(){
    if(shortConcentrationRehabiliAddRadio==null){

      shortConcentrationRehabiliAddRadio = new ACValueArrayRadioButtonGroup();

      shortConcentrationRehabiliAddRadio.setBindPath("1520124");

      shortConcentrationRehabiliAddRadio.setUseClearButton(false);

      shortConcentrationRehabiliAddRadio.setModel(getShortConcentrationRehabiliAddRadioModel());

      shortConcentrationRehabiliAddRadio.setValues(new int[]{1,2});

      addShortConcentrationRehabiliAddRadio();
    }
    return shortConcentrationRehabiliAddRadio;

  }

  /**
   * �Z���W�����n�r�����Z���f�����擾���܂��B
   * @return �Z���W�����n�r�����Z���f��
   */
  protected ACListModelAdapter getShortConcentrationRehabiliAddRadioModel(){
    if(shortConcentrationRehabiliAddRadioModel==null){
      shortConcentrationRehabiliAddRadioModel = new ACListModelAdapter();
      addShortConcentrationRehabiliAddRadioModel();
    }
    return shortConcentrationRehabiliAddRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getShortConcentrationRehabiliAddRadioItem1(){
    if(shortConcentrationRehabiliAddRadioItem1==null){

      shortConcentrationRehabiliAddRadioItem1 = new ACRadioButtonItem();

      shortConcentrationRehabiliAddRadioItem1.setText("�Ȃ�");

      shortConcentrationRehabiliAddRadioItem1.setGroup(getShortConcentrationRehabiliAddRadio());

      shortConcentrationRehabiliAddRadioItem1.setConstraints(VRLayout.FLOW);

      addShortConcentrationRehabiliAddRadioItem1();
    }
    return shortConcentrationRehabiliAddRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getShortConcentrationRehabiliAddRadioItem2(){
    if(shortConcentrationRehabiliAddRadioItem2==null){

      shortConcentrationRehabiliAddRadioItem2 = new ACRadioButtonItem();

      shortConcentrationRehabiliAddRadioItem2.setText("����");

      shortConcentrationRehabiliAddRadioItem2.setGroup(getShortConcentrationRehabiliAddRadio());

      shortConcentrationRehabiliAddRadioItem2.setConstraints(VRLayout.FLOW);

      addShortConcentrationRehabiliAddRadioItem2();
    }
    return shortConcentrationRehabiliAddRadioItem2;

  }

  /**
   * �F�m�Ǎ���҂��擾���܂��B
   * @return �F�m�Ǎ����
   */
  public ACIntegerCheckBox getShortConcentrationRehabiliAddDementiaCheck(){
    if(shortConcentrationRehabiliAddDementiaCheck==null){

      shortConcentrationRehabiliAddDementiaCheck = new ACIntegerCheckBox();

      shortConcentrationRehabiliAddDementiaCheck.setText("�F�m�Ǎ����");

      shortConcentrationRehabiliAddDementiaCheck.setBindPath("1520125");

      shortConcentrationRehabiliAddDementiaCheck.setSelectValue(2);

      shortConcentrationRehabiliAddDementiaCheck.setUnSelectValue(1);

      addShortConcentrationRehabiliAddDementiaCheck();
    }
    return shortConcentrationRehabiliAddDementiaCheck;

  }

  /**
   * �^�u2���擾���܂��B
   * @return �^�u2
   */
  public ACPanel getTab2(){
    if(tab2==null){

      tab2 = new ACPanel();

      tab2.setFollowChildEnabled(true);

      tab2.setHgap(0);

      addTab2();
    }
    return tab2;

  }

  /**
   * �O�������Z���擾���܂��B
   * @return �O�������Z
   */
  public ACValueArrayRadioButtonGroup getKaigoHealthCareOfTheAgedStayingOutOvernightCostRadio(){
    if(kaigoHealthCareOfTheAgedStayingOutOvernightCostRadio==null){

      kaigoHealthCareOfTheAgedStayingOutOvernightCostRadio = new ACValueArrayRadioButtonGroup();

      getKaigoHealthCareOfTheAgedStayingOutOvernightCostRadioContainer().setText("�O�����Z");

      kaigoHealthCareOfTheAgedStayingOutOvernightCostRadio.setBindPath("1520107");

      kaigoHealthCareOfTheAgedStayingOutOvernightCostRadio.setUseClearButton(false);

      kaigoHealthCareOfTheAgedStayingOutOvernightCostRadio.setModel(getKaigoHealthCareOfTheAgedStayingOutOvernightCostRadioModel());

      kaigoHealthCareOfTheAgedStayingOutOvernightCostRadio.setValues(new int[]{1,2});

      addKaigoHealthCareOfTheAgedStayingOutOvernightCostRadio();
    }
    return kaigoHealthCareOfTheAgedStayingOutOvernightCostRadio;

  }

  /**
   * �O�������Z�R���e�i���擾���܂��B
   * @return �O�������Z�R���e�i
   */
  protected ACLabelContainer getKaigoHealthCareOfTheAgedStayingOutOvernightCostRadioContainer(){
    if(kaigoHealthCareOfTheAgedStayingOutOvernightCostRadioContainer==null){
      kaigoHealthCareOfTheAgedStayingOutOvernightCostRadioContainer = new ACLabelContainer();
      kaigoHealthCareOfTheAgedStayingOutOvernightCostRadioContainer.setFollowChildEnabled(true);
      kaigoHealthCareOfTheAgedStayingOutOvernightCostRadioContainer.setVAlignment(VRLayout.CENTER);
      kaigoHealthCareOfTheAgedStayingOutOvernightCostRadioContainer.add(getKaigoHealthCareOfTheAgedStayingOutOvernightCostRadio(), null);
    }
    return kaigoHealthCareOfTheAgedStayingOutOvernightCostRadioContainer;
  }

  /**
   * �O�������Z���f�����擾���܂��B
   * @return �O�������Z���f��
   */
  protected ACListModelAdapter getKaigoHealthCareOfTheAgedStayingOutOvernightCostRadioModel(){
    if(kaigoHealthCareOfTheAgedStayingOutOvernightCostRadioModel==null){
      kaigoHealthCareOfTheAgedStayingOutOvernightCostRadioModel = new ACListModelAdapter();
      addKaigoHealthCareOfTheAgedStayingOutOvernightCostRadioModel();
    }
    return kaigoHealthCareOfTheAgedStayingOutOvernightCostRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getKaigoHealthCareOfTheAgedStayingOutOvernightCostRadioItem1(){
    if(kaigoHealthCareOfTheAgedStayingOutOvernightCostRadioItem1==null){

      kaigoHealthCareOfTheAgedStayingOutOvernightCostRadioItem1 = new ACRadioButtonItem();

      kaigoHealthCareOfTheAgedStayingOutOvernightCostRadioItem1.setText("�Ȃ�");

      kaigoHealthCareOfTheAgedStayingOutOvernightCostRadioItem1.setGroup(getKaigoHealthCareOfTheAgedStayingOutOvernightCostRadio());

      kaigoHealthCareOfTheAgedStayingOutOvernightCostRadioItem1.setConstraints(VRLayout.FLOW);

      addKaigoHealthCareOfTheAgedStayingOutOvernightCostRadioItem1();
    }
    return kaigoHealthCareOfTheAgedStayingOutOvernightCostRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getKaigoHealthCareOfTheAgedStayingOutOvernightCostRadioItem2(){
    if(kaigoHealthCareOfTheAgedStayingOutOvernightCostRadioItem2==null){

      kaigoHealthCareOfTheAgedStayingOutOvernightCostRadioItem2 = new ACRadioButtonItem();

      kaigoHealthCareOfTheAgedStayingOutOvernightCostRadioItem2.setText("����");

      kaigoHealthCareOfTheAgedStayingOutOvernightCostRadioItem2.setGroup(getKaigoHealthCareOfTheAgedStayingOutOvernightCostRadio());

      kaigoHealthCareOfTheAgedStayingOutOvernightCostRadioItem2.setConstraints(VRLayout.FLOW);

      addKaigoHealthCareOfTheAgedStayingOutOvernightCostRadioItem2();
    }
    return kaigoHealthCareOfTheAgedStayingOutOvernightCostRadioItem2;

  }

  /**
   * �������Z���擾���܂��B
   * @return �������Z
   */
  public ACValueArrayRadioButtonGroup getKaigoHealthCareOfTheAgedDefaultRadio(){
    if(kaigoHealthCareOfTheAgedDefaultRadio==null){

      kaigoHealthCareOfTheAgedDefaultRadio = new ACValueArrayRadioButtonGroup();

      getKaigoHealthCareOfTheAgedDefaultRadioContainer().setText("�������Z");

      kaigoHealthCareOfTheAgedDefaultRadio.setBindPath("1520108");

      kaigoHealthCareOfTheAgedDefaultRadio.setUseClearButton(false);

      kaigoHealthCareOfTheAgedDefaultRadio.setModel(getKaigoHealthCareOfTheAgedDefaultRadioModel());

      kaigoHealthCareOfTheAgedDefaultRadio.setValues(new int[]{1,2});

      addKaigoHealthCareOfTheAgedDefaultRadio();
    }
    return kaigoHealthCareOfTheAgedDefaultRadio;

  }

  /**
   * �������Z�R���e�i���擾���܂��B
   * @return �������Z�R���e�i
   */
  protected ACLabelContainer getKaigoHealthCareOfTheAgedDefaultRadioContainer(){
    if(kaigoHealthCareOfTheAgedDefaultRadioContainer==null){
      kaigoHealthCareOfTheAgedDefaultRadioContainer = new ACLabelContainer();
      kaigoHealthCareOfTheAgedDefaultRadioContainer.setFollowChildEnabled(true);
      kaigoHealthCareOfTheAgedDefaultRadioContainer.setVAlignment(VRLayout.CENTER);
      kaigoHealthCareOfTheAgedDefaultRadioContainer.add(getKaigoHealthCareOfTheAgedDefaultRadio(), null);
    }
    return kaigoHealthCareOfTheAgedDefaultRadioContainer;
  }

  /**
   * �������Z���f�����擾���܂��B
   * @return �������Z���f��
   */
  protected ACListModelAdapter getKaigoHealthCareOfTheAgedDefaultRadioModel(){
    if(kaigoHealthCareOfTheAgedDefaultRadioModel==null){
      kaigoHealthCareOfTheAgedDefaultRadioModel = new ACListModelAdapter();
      addKaigoHealthCareOfTheAgedDefaultRadioModel();
    }
    return kaigoHealthCareOfTheAgedDefaultRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getKaigoHealthCareOfTheAgedDefaultRadioItem1(){
    if(kaigoHealthCareOfTheAgedDefaultRadioItem1==null){

      kaigoHealthCareOfTheAgedDefaultRadioItem1 = new ACRadioButtonItem();

      kaigoHealthCareOfTheAgedDefaultRadioItem1.setText("�Ȃ�");

      kaigoHealthCareOfTheAgedDefaultRadioItem1.setGroup(getKaigoHealthCareOfTheAgedDefaultRadio());

      kaigoHealthCareOfTheAgedDefaultRadioItem1.setConstraints(VRLayout.FLOW);

      addKaigoHealthCareOfTheAgedDefaultRadioItem1();
    }
    return kaigoHealthCareOfTheAgedDefaultRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getKaigoHealthCareOfTheAgedDefaultRadioItem2(){
    if(kaigoHealthCareOfTheAgedDefaultRadioItem2==null){

      kaigoHealthCareOfTheAgedDefaultRadioItem2 = new ACRadioButtonItem();

      kaigoHealthCareOfTheAgedDefaultRadioItem2.setText("����");

      kaigoHealthCareOfTheAgedDefaultRadioItem2.setGroup(getKaigoHealthCareOfTheAgedDefaultRadio());

      kaigoHealthCareOfTheAgedDefaultRadioItem2.setConstraints(VRLayout.FLOW);

      addKaigoHealthCareOfTheAgedDefaultRadioItem2();
    }
    return kaigoHealthCareOfTheAgedDefaultRadioItem2;

  }

  /**
   * �ً}���{�ݗ×{����擾���܂��B
   * @return �ً}���{�ݗ×{��
   */
  public ACValueArrayRadioButtonGroup getKaigoHealthCareOfTheAgedEmergencyRadio(){
    if(kaigoHealthCareOfTheAgedEmergencyRadio==null){

      kaigoHealthCareOfTheAgedEmergencyRadio = new ACValueArrayRadioButtonGroup();

      getKaigoHealthCareOfTheAgedEmergencyRadioContainer().setText("�ً}���{�ݗ×{��");

      kaigoHealthCareOfTheAgedEmergencyRadio.setBindPath("1520109");

      kaigoHealthCareOfTheAgedEmergencyRadio.setUseClearButton(false);

      kaigoHealthCareOfTheAgedEmergencyRadio.setModel(getKaigoHealthCareOfTheAgedEmergencyRadioModel());

      kaigoHealthCareOfTheAgedEmergencyRadio.setValues(new int[]{1,2});

      addKaigoHealthCareOfTheAgedEmergencyRadio();
    }
    return kaigoHealthCareOfTheAgedEmergencyRadio;

  }

  /**
   * �ً}���{�ݗ×{��R���e�i���擾���܂��B
   * @return �ً}���{�ݗ×{��R���e�i
   */
  protected ACLabelContainer getKaigoHealthCareOfTheAgedEmergencyRadioContainer(){
    if(kaigoHealthCareOfTheAgedEmergencyRadioContainer==null){
      kaigoHealthCareOfTheAgedEmergencyRadioContainer = new ACLabelContainer();
      kaigoHealthCareOfTheAgedEmergencyRadioContainer.setFollowChildEnabled(true);
      kaigoHealthCareOfTheAgedEmergencyRadioContainer.setVAlignment(VRLayout.CENTER);
      kaigoHealthCareOfTheAgedEmergencyRadioContainer.add(getKaigoHealthCareOfTheAgedEmergencyRadio(), null);
    }
    return kaigoHealthCareOfTheAgedEmergencyRadioContainer;
  }

  /**
   * �ً}���{�ݗ×{��f�����擾���܂��B
   * @return �ً}���{�ݗ×{��f��
   */
  protected ACListModelAdapter getKaigoHealthCareOfTheAgedEmergencyRadioModel(){
    if(kaigoHealthCareOfTheAgedEmergencyRadioModel==null){
      kaigoHealthCareOfTheAgedEmergencyRadioModel = new ACListModelAdapter();
      addKaigoHealthCareOfTheAgedEmergencyRadioModel();
    }
    return kaigoHealthCareOfTheAgedEmergencyRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getKaigoHealthCareOfTheAgedEmergencyRadioItem1(){
    if(kaigoHealthCareOfTheAgedEmergencyRadioItem1==null){

      kaigoHealthCareOfTheAgedEmergencyRadioItem1 = new ACRadioButtonItem();

      kaigoHealthCareOfTheAgedEmergencyRadioItem1.setText("�Ȃ�");

      kaigoHealthCareOfTheAgedEmergencyRadioItem1.setGroup(getKaigoHealthCareOfTheAgedEmergencyRadio());

      kaigoHealthCareOfTheAgedEmergencyRadioItem1.setConstraints(VRLayout.FLOW);

      addKaigoHealthCareOfTheAgedEmergencyRadioItem1();
    }
    return kaigoHealthCareOfTheAgedEmergencyRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getKaigoHealthCareOfTheAgedEmergencyRadioItem2(){
    if(kaigoHealthCareOfTheAgedEmergencyRadioItem2==null){

      kaigoHealthCareOfTheAgedEmergencyRadioItem2 = new ACRadioButtonItem();

      kaigoHealthCareOfTheAgedEmergencyRadioItem2.setText("����");

      kaigoHealthCareOfTheAgedEmergencyRadioItem2.setGroup(getKaigoHealthCareOfTheAgedEmergencyRadio());

      kaigoHealthCareOfTheAgedEmergencyRadioItem2.setConstraints(VRLayout.FLOW);

      addKaigoHealthCareOfTheAgedEmergencyRadioItem2();
    }
    return kaigoHealthCareOfTheAgedEmergencyRadioItem2;

  }

  /**
   * �h�{�}�l�W�����g���Z���擾���܂��B
   * @return �h�{�}�l�W�����g���Z
   */
  public ACValueArrayRadioButtonGroup getKaigoHealthCareOfTheAgedNutritionRadio(){
    if(kaigoHealthCareOfTheAgedNutritionRadio==null){

      kaigoHealthCareOfTheAgedNutritionRadio = new ACValueArrayRadioButtonGroup();

      getKaigoHealthCareOfTheAgedNutritionRadioContainer().setText("�h�{�}�l�W�����g���Z");

      kaigoHealthCareOfTheAgedNutritionRadio.setBindPath("1520111");

      kaigoHealthCareOfTheAgedNutritionRadio.setUseClearButton(false);

      kaigoHealthCareOfTheAgedNutritionRadio.setModel(getKaigoHealthCareOfTheAgedNutritionRadioModel());

      kaigoHealthCareOfTheAgedNutritionRadio.setValues(new int[]{1,2});

      addKaigoHealthCareOfTheAgedNutritionRadio();
    }
    return kaigoHealthCareOfTheAgedNutritionRadio;

  }

  /**
   * �h�{�}�l�W�����g���Z�R���e�i���擾���܂��B
   * @return �h�{�}�l�W�����g���Z�R���e�i
   */
  protected ACLabelContainer getKaigoHealthCareOfTheAgedNutritionRadioContainer(){
    if(kaigoHealthCareOfTheAgedNutritionRadioContainer==null){
      kaigoHealthCareOfTheAgedNutritionRadioContainer = new ACLabelContainer();
      kaigoHealthCareOfTheAgedNutritionRadioContainer.setFollowChildEnabled(true);
      kaigoHealthCareOfTheAgedNutritionRadioContainer.setVAlignment(VRLayout.CENTER);
      kaigoHealthCareOfTheAgedNutritionRadioContainer.add(getKaigoHealthCareOfTheAgedNutritionRadio(), null);
    }
    return kaigoHealthCareOfTheAgedNutritionRadioContainer;
  }

  /**
   * �h�{�}�l�W�����g���Z���f�����擾���܂��B
   * @return �h�{�}�l�W�����g���Z���f��
   */
  protected ACListModelAdapter getKaigoHealthCareOfTheAgedNutritionRadioModel(){
    if(kaigoHealthCareOfTheAgedNutritionRadioModel==null){
      kaigoHealthCareOfTheAgedNutritionRadioModel = new ACListModelAdapter();
      addKaigoHealthCareOfTheAgedNutritionRadioModel();
    }
    return kaigoHealthCareOfTheAgedNutritionRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getKaigoHealthCareOfTheAgedNutritionRadioItem1(){
    if(kaigoHealthCareOfTheAgedNutritionRadioItem1==null){

      kaigoHealthCareOfTheAgedNutritionRadioItem1 = new ACRadioButtonItem();

      kaigoHealthCareOfTheAgedNutritionRadioItem1.setText("�Ȃ�");

      kaigoHealthCareOfTheAgedNutritionRadioItem1.setGroup(getKaigoHealthCareOfTheAgedNutritionRadio());

      kaigoHealthCareOfTheAgedNutritionRadioItem1.setConstraints(VRLayout.FLOW);

      addKaigoHealthCareOfTheAgedNutritionRadioItem1();
    }
    return kaigoHealthCareOfTheAgedNutritionRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getKaigoHealthCareOfTheAgedNutritionRadioItem2(){
    if(kaigoHealthCareOfTheAgedNutritionRadioItem2==null){

      kaigoHealthCareOfTheAgedNutritionRadioItem2 = new ACRadioButtonItem();

      kaigoHealthCareOfTheAgedNutritionRadioItem2.setText("����");

      kaigoHealthCareOfTheAgedNutritionRadioItem2.setGroup(getKaigoHealthCareOfTheAgedNutritionRadio());

      kaigoHealthCareOfTheAgedNutritionRadioItem2.setConstraints(VRLayout.FLOW);

      addKaigoHealthCareOfTheAgedNutritionRadioItem2();
    }
    return kaigoHealthCareOfTheAgedNutritionRadioItem2;

  }

  /**
   * �o���ڍs���Z���擾���܂��B
   * @return �o���ڍs���Z
   */
  public ACValueArrayRadioButtonGroup getKaigoHealthCareOfTheAgedOralSwitchRadio(){
    if(kaigoHealthCareOfTheAgedOralSwitchRadio==null){

      kaigoHealthCareOfTheAgedOralSwitchRadio = new ACValueArrayRadioButtonGroup();

      getKaigoHealthCareOfTheAgedOralSwitchRadioContainer().setText("�o���ڍs���Z");

      kaigoHealthCareOfTheAgedOralSwitchRadio.setBindPath("1520112");

      kaigoHealthCareOfTheAgedOralSwitchRadio.setUseClearButton(false);

      kaigoHealthCareOfTheAgedOralSwitchRadio.setModel(getKaigoHealthCareOfTheAgedOralSwitchRadioModel());

      kaigoHealthCareOfTheAgedOralSwitchRadio.setValues(new int[]{1,2});

      addKaigoHealthCareOfTheAgedOralSwitchRadio();
    }
    return kaigoHealthCareOfTheAgedOralSwitchRadio;

  }

  /**
   * �o���ڍs���Z�R���e�i���擾���܂��B
   * @return �o���ڍs���Z�R���e�i
   */
  protected ACLabelContainer getKaigoHealthCareOfTheAgedOralSwitchRadioContainer(){
    if(kaigoHealthCareOfTheAgedOralSwitchRadioContainer==null){
      kaigoHealthCareOfTheAgedOralSwitchRadioContainer = new ACLabelContainer();
      kaigoHealthCareOfTheAgedOralSwitchRadioContainer.setFollowChildEnabled(true);
      kaigoHealthCareOfTheAgedOralSwitchRadioContainer.setVAlignment(VRLayout.CENTER);
      kaigoHealthCareOfTheAgedOralSwitchRadioContainer.add(getKaigoHealthCareOfTheAgedOralSwitchRadio(), null);
    }
    return kaigoHealthCareOfTheAgedOralSwitchRadioContainer;
  }

  /**
   * �o���ڍs���Z���f�����擾���܂��B
   * @return �o���ڍs���Z���f��
   */
  protected ACListModelAdapter getKaigoHealthCareOfTheAgedOralSwitchRadioModel(){
    if(kaigoHealthCareOfTheAgedOralSwitchRadioModel==null){
      kaigoHealthCareOfTheAgedOralSwitchRadioModel = new ACListModelAdapter();
      addKaigoHealthCareOfTheAgedOralSwitchRadioModel();
    }
    return kaigoHealthCareOfTheAgedOralSwitchRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getKaigoHealthCareOfTheAgedOralSwitchRadioItem1(){
    if(kaigoHealthCareOfTheAgedOralSwitchRadioItem1==null){

      kaigoHealthCareOfTheAgedOralSwitchRadioItem1 = new ACRadioButtonItem();

      kaigoHealthCareOfTheAgedOralSwitchRadioItem1.setText("�Ȃ�");

      kaigoHealthCareOfTheAgedOralSwitchRadioItem1.setGroup(getKaigoHealthCareOfTheAgedOralSwitchRadio());

      kaigoHealthCareOfTheAgedOralSwitchRadioItem1.setConstraints(VRLayout.FLOW);

      addKaigoHealthCareOfTheAgedOralSwitchRadioItem1();
    }
    return kaigoHealthCareOfTheAgedOralSwitchRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getKaigoHealthCareOfTheAgedOralSwitchRadioItem2(){
    if(kaigoHealthCareOfTheAgedOralSwitchRadioItem2==null){

      kaigoHealthCareOfTheAgedOralSwitchRadioItem2 = new ACRadioButtonItem();

      kaigoHealthCareOfTheAgedOralSwitchRadioItem2.setText("����");

      kaigoHealthCareOfTheAgedOralSwitchRadioItem2.setGroup(getKaigoHealthCareOfTheAgedOralSwitchRadio());

      kaigoHealthCareOfTheAgedOralSwitchRadioItem2.setConstraints(VRLayout.FLOW);

      addKaigoHealthCareOfTheAgedOralSwitchRadioItem2();
    }
    return kaigoHealthCareOfTheAgedOralSwitchRadioItem2;

  }

  /**
   * �o���ێ����Z���擾���܂��B
   * @return �o���ێ����Z
   */
  public ACValueArrayRadioButtonGroup getOralMaintenanceAddRadio(){
    if(oralMaintenanceAddRadio==null){

      oralMaintenanceAddRadio = new ACValueArrayRadioButtonGroup();

      getOralMaintenanceAddRadioContainer().setText("�o���ێ����Z");

      oralMaintenanceAddRadio.setBindPath("1520126");

      oralMaintenanceAddRadio.setUseClearButton(false);

      oralMaintenanceAddRadio.setModel(getOralMaintenanceAddRadioModel());

      oralMaintenanceAddRadio.setValues(new int[]{1,2,3});

      addOralMaintenanceAddRadio();
    }
    return oralMaintenanceAddRadio;

  }

  /**
   * �o���ێ����Z�R���e�i���擾���܂��B
   * @return �o���ێ����Z�R���e�i
   */
  protected ACLabelContainer getOralMaintenanceAddRadioContainer(){
    if(oralMaintenanceAddRadioContainer==null){
      oralMaintenanceAddRadioContainer = new ACLabelContainer();
      oralMaintenanceAddRadioContainer.setFollowChildEnabled(true);
      oralMaintenanceAddRadioContainer.setVAlignment(VRLayout.CENTER);
      oralMaintenanceAddRadioContainer.add(getOralMaintenanceAddRadio(), null);
    }
    return oralMaintenanceAddRadioContainer;
  }

  /**
   * �o���ێ����Z���f�����擾���܂��B
   * @return �o���ێ����Z���f��
   */
  protected ACListModelAdapter getOralMaintenanceAddRadioModel(){
    if(oralMaintenanceAddRadioModel==null){
      oralMaintenanceAddRadioModel = new ACListModelAdapter();
      addOralMaintenanceAddRadioModel();
    }
    return oralMaintenanceAddRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getOralMaintenanceAddRadioItem1(){
    if(oralMaintenanceAddRadioItem1==null){

      oralMaintenanceAddRadioItem1 = new ACRadioButtonItem();

      oralMaintenanceAddRadioItem1.setText("�Ȃ�");

      oralMaintenanceAddRadioItem1.setGroup(getOralMaintenanceAddRadio());

      oralMaintenanceAddRadioItem1.setConstraints(VRLayout.FLOW);

      addOralMaintenanceAddRadioItem1();
    }
    return oralMaintenanceAddRadioItem1;

  }

  /**
   * I�^���擾���܂��B
   * @return I�^
   */
  public ACRadioButtonItem getOralMaintenanceAddRadioItem2(){
    if(oralMaintenanceAddRadioItem2==null){

      oralMaintenanceAddRadioItem2 = new ACRadioButtonItem();

      oralMaintenanceAddRadioItem2.setText("I�^");

      oralMaintenanceAddRadioItem2.setGroup(getOralMaintenanceAddRadio());

      oralMaintenanceAddRadioItem2.setConstraints(VRLayout.FLOW);

      addOralMaintenanceAddRadioItem2();
    }
    return oralMaintenanceAddRadioItem2;

  }

  /**
   * II�^���擾���܂��B
   * @return II�^
   */
  public ACRadioButtonItem getOralMaintenanceAddRadioItem3(){
    if(oralMaintenanceAddRadioItem3==null){

      oralMaintenanceAddRadioItem3 = new ACRadioButtonItem();

      oralMaintenanceAddRadioItem3.setText("II�^");

      oralMaintenanceAddRadioItem3.setGroup(getOralMaintenanceAddRadio());

      oralMaintenanceAddRadioItem3.setConstraints(VRLayout.FLOW);

      addOralMaintenanceAddRadioItem3();
    }
    return oralMaintenanceAddRadioItem3;

  }

  /**
   * ���o�@�\�ێ��Ǘ��̐����Z���擾���܂��B
   * @return ���o�@�\�ێ��Ǘ��̐����Z
   */
  public ACValueArrayRadioButtonGroup getOralKeepStructureAddRadioGroup(){
    if(oralKeepStructureAddRadioGroup==null){

      oralKeepStructureAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getOralKeepStructureAddRadioGroupContainer().setText("���o�@�\�ێ��Ǘ��̐����Z");

      oralKeepStructureAddRadioGroup.setBindPath("1510145");

      oralKeepStructureAddRadioGroup.setNoSelectIndex(0);

      oralKeepStructureAddRadioGroup.setUseClearButton(false);

      oralKeepStructureAddRadioGroup.setModel(getOralKeepStructureAddRadioGroupModel());

      oralKeepStructureAddRadioGroup.setValues(new int[]{1,2});

      addOralKeepStructureAddRadioGroup();
    }
    return oralKeepStructureAddRadioGroup;

  }

  /**
   * ���o�@�\�ێ��Ǘ��̐����Z�R���e�i���擾���܂��B
   * @return ���o�@�\�ێ��Ǘ��̐����Z�R���e�i
   */
  protected ACLabelContainer getOralKeepStructureAddRadioGroupContainer(){
    if(oralKeepStructureAddRadioGroupContainer==null){
      oralKeepStructureAddRadioGroupContainer = new ACLabelContainer();
      oralKeepStructureAddRadioGroupContainer.setFollowChildEnabled(true);
      oralKeepStructureAddRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      oralKeepStructureAddRadioGroupContainer.add(getOralKeepStructureAddRadioGroup(), null);
    }
    return oralKeepStructureAddRadioGroupContainer;
  }

  /**
   * ���o�@�\�ێ��Ǘ��̐����Z���f�����擾���܂��B
   * @return ���o�@�\�ێ��Ǘ��̐����Z���f��
   */
  protected ACListModelAdapter getOralKeepStructureAddRadioGroupModel(){
    if(oralKeepStructureAddRadioGroupModel==null){
      oralKeepStructureAddRadioGroupModel = new ACListModelAdapter();
      addOralKeepStructureAddRadioGroupModel();
    }
    return oralKeepStructureAddRadioGroupModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getOralKeepStructureAddRadioItem1(){
    if(oralKeepStructureAddRadioItem1==null){

      oralKeepStructureAddRadioItem1 = new ACRadioButtonItem();

      oralKeepStructureAddRadioItem1.setText("�Ȃ�");

      oralKeepStructureAddRadioItem1.setGroup(getOralKeepStructureAddRadioGroup());

      oralKeepStructureAddRadioItem1.setConstraints(VRLayout.FLOW);

      addOralKeepStructureAddRadioItem1();
    }
    return oralKeepStructureAddRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getOralKeepStructureAddRadioItem2(){
    if(oralKeepStructureAddRadioItem2==null){

      oralKeepStructureAddRadioItem2 = new ACRadioButtonItem();

      oralKeepStructureAddRadioItem2.setText("����");

      oralKeepStructureAddRadioItem2.setGroup(getOralKeepStructureAddRadioGroup());

      oralKeepStructureAddRadioItem2.setConstraints(VRLayout.FLOW);

      addOralKeepStructureAddRadioItem2();
    }
    return oralKeepStructureAddRadioItem2;

  }

  /**
   * ���o�@�\�ێ��Ǘ����Z���擾���܂��B
   * @return ���o�@�\�ێ��Ǘ����Z
   */
  public ACValueArrayRadioButtonGroup getOralKeepAddRadioGroup(){
    if(oralKeepAddRadioGroup==null){

      oralKeepAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getOralKeepAddRadioGroupContainer().setText("���o�@�\�ێ��Ǘ����Z");

      oralKeepAddRadioGroup.setBindPath("1520135");

      oralKeepAddRadioGroup.setNoSelectIndex(0);

      oralKeepAddRadioGroup.setUseClearButton(false);

      oralKeepAddRadioGroup.setModel(getOralKeepAddRadioGroupModel());

      oralKeepAddRadioGroup.setValues(new int[]{1,2});

      addOralKeepAddRadioGroup();
    }
    return oralKeepAddRadioGroup;

  }

  /**
   * ���o�@�\�ێ��Ǘ����Z�R���e�i���擾���܂��B
   * @return ���o�@�\�ێ��Ǘ����Z�R���e�i
   */
  protected ACLabelContainer getOralKeepAddRadioGroupContainer(){
    if(oralKeepAddRadioGroupContainer==null){
      oralKeepAddRadioGroupContainer = new ACLabelContainer();
      oralKeepAddRadioGroupContainer.setFollowChildEnabled(true);
      oralKeepAddRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      oralKeepAddRadioGroupContainer.add(getOralKeepAddRadioGroup(), null);
    }
    return oralKeepAddRadioGroupContainer;
  }

  /**
   * ���o�@�\�ێ��Ǘ����Z���f�����擾���܂��B
   * @return ���o�@�\�ێ��Ǘ����Z���f��
   */
  protected ACListModelAdapter getOralKeepAddRadioGroupModel(){
    if(oralKeepAddRadioGroupModel==null){
      oralKeepAddRadioGroupModel = new ACListModelAdapter();
      addOralKeepAddRadioGroupModel();
    }
    return oralKeepAddRadioGroupModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getOralKeepAddRadioItem1(){
    if(oralKeepAddRadioItem1==null){

      oralKeepAddRadioItem1 = new ACRadioButtonItem();

      oralKeepAddRadioItem1.setText("�Ȃ�");

      oralKeepAddRadioItem1.setGroup(getOralKeepAddRadioGroup());

      oralKeepAddRadioItem1.setConstraints(VRLayout.FLOW);

      addOralKeepAddRadioItem1();
    }
    return oralKeepAddRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getOralKeepAddRadioItem2(){
    if(oralKeepAddRadioItem2==null){

      oralKeepAddRadioItem2 = new ACRadioButtonItem();

      oralKeepAddRadioItem2.setText("����");

      oralKeepAddRadioItem2.setGroup(getOralKeepAddRadioGroup());

      oralKeepAddRadioItem2.setConstraints(VRLayout.FLOW);

      addOralKeepAddRadioItem2();
    }
    return oralKeepAddRadioItem2;

  }

  /**
   * �×{�H���Z���擾���܂��B
   * @return �×{�H���Z
   */
  public ACValueArrayRadioButtonGroup getKaigoHealthCareOfTheAgedRecuperateDinnerRadio(){
    if(kaigoHealthCareOfTheAgedRecuperateDinnerRadio==null){

      kaigoHealthCareOfTheAgedRecuperateDinnerRadio = new ACValueArrayRadioButtonGroup();

      getKaigoHealthCareOfTheAgedRecuperateDinnerRadioContainer().setText("�×{�H���Z");

      kaigoHealthCareOfTheAgedRecuperateDinnerRadio.setBindPath("1520113");

      kaigoHealthCareOfTheAgedRecuperateDinnerRadio.setUseClearButton(false);

      kaigoHealthCareOfTheAgedRecuperateDinnerRadio.setModel(getKaigoHealthCareOfTheAgedRecuperateDinnerRadioModel());

      kaigoHealthCareOfTheAgedRecuperateDinnerRadio.setValues(new int[]{1,2});

      addKaigoHealthCareOfTheAgedRecuperateDinnerRadio();
    }
    return kaigoHealthCareOfTheAgedRecuperateDinnerRadio;

  }

  /**
   * �×{�H���Z�R���e�i���擾���܂��B
   * @return �×{�H���Z�R���e�i
   */
  protected ACLabelContainer getKaigoHealthCareOfTheAgedRecuperateDinnerRadioContainer(){
    if(kaigoHealthCareOfTheAgedRecuperateDinnerRadioContainer==null){
      kaigoHealthCareOfTheAgedRecuperateDinnerRadioContainer = new ACLabelContainer();
      kaigoHealthCareOfTheAgedRecuperateDinnerRadioContainer.setFollowChildEnabled(true);
      kaigoHealthCareOfTheAgedRecuperateDinnerRadioContainer.setVAlignment(VRLayout.CENTER);
      kaigoHealthCareOfTheAgedRecuperateDinnerRadioContainer.add(getKaigoHealthCareOfTheAgedRecuperateDinnerRadio(), null);
    }
    return kaigoHealthCareOfTheAgedRecuperateDinnerRadioContainer;
  }

  /**
   * �×{�H���Z���f�����擾���܂��B
   * @return �×{�H���Z���f��
   */
  protected ACListModelAdapter getKaigoHealthCareOfTheAgedRecuperateDinnerRadioModel(){
    if(kaigoHealthCareOfTheAgedRecuperateDinnerRadioModel==null){
      kaigoHealthCareOfTheAgedRecuperateDinnerRadioModel = new ACListModelAdapter();
      addKaigoHealthCareOfTheAgedRecuperateDinnerRadioModel();
    }
    return kaigoHealthCareOfTheAgedRecuperateDinnerRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getKaigoHealthCareOfTheAgedRecuperateDinnerRadioItem1(){
    if(kaigoHealthCareOfTheAgedRecuperateDinnerRadioItem1==null){

      kaigoHealthCareOfTheAgedRecuperateDinnerRadioItem1 = new ACRadioButtonItem();

      kaigoHealthCareOfTheAgedRecuperateDinnerRadioItem1.setText("�Ȃ�");

      kaigoHealthCareOfTheAgedRecuperateDinnerRadioItem1.setGroup(getKaigoHealthCareOfTheAgedRecuperateDinnerRadio());

      kaigoHealthCareOfTheAgedRecuperateDinnerRadioItem1.setConstraints(VRLayout.FLOW);

      addKaigoHealthCareOfTheAgedRecuperateDinnerRadioItem1();
    }
    return kaigoHealthCareOfTheAgedRecuperateDinnerRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getKaigoHealthCareOfTheAgedRecuperateDinnerRadioItem2(){
    if(kaigoHealthCareOfTheAgedRecuperateDinnerRadioItem2==null){

      kaigoHealthCareOfTheAgedRecuperateDinnerRadioItem2 = new ACRadioButtonItem();

      kaigoHealthCareOfTheAgedRecuperateDinnerRadioItem2.setText("����");

      kaigoHealthCareOfTheAgedRecuperateDinnerRadioItem2.setGroup(getKaigoHealthCareOfTheAgedRecuperateDinnerRadio());

      kaigoHealthCareOfTheAgedRecuperateDinnerRadioItem2.setConstraints(VRLayout.FLOW);

      addKaigoHealthCareOfTheAgedRecuperateDinnerRadioItem2();
    }
    return kaigoHealthCareOfTheAgedRecuperateDinnerRadioItem2;

  }

  /**
   * ���ʗ×{����擾���܂��B
   * @return ���ʗ×{��
   */
  public ACMapBindButton getSpecialMedicalExpense(){
    if(specialMedicalExpense==null){

      specialMedicalExpense = new ACMapBindButton();

      specialMedicalExpense.setText("���ʗ×{��");

      specialMedicalExpense.setToolTipText("���ʗ×{���ݒ肵�܂��B");

      addSpecialMedicalExpense();
    }
    return specialMedicalExpense;

  }

  /**
   * ���x�����擾���܂��B
   * @return ���x��
   */
  public ACLabel getSpecialMedicalExpenseLabel(){
    if(specialMedicalExpenseLabel==null){

      specialMedicalExpenseLabel = new ACLabel();

      specialMedicalExpenseLabel.setText("�ݒ�Ȃ�");

      specialMedicalExpenseLabel.setOpaque(true);
      specialMedicalExpenseLabel.setBackground(new Color(255,255,172));

      addSpecialMedicalExpenseLabel();
    }
    return specialMedicalExpenseLabel;

  }

  /**
   * �H���R���e�i���擾���܂��B
   * @return �H���R���e�i
   */
  public ACBackLabelContainer getKaigoHealthCareOfTheAgedDinnerContainer(){
    if(kaigoHealthCareOfTheAgedDinnerContainer==null){

      kaigoHealthCareOfTheAgedDinnerContainer = new ACBackLabelContainer();

      kaigoHealthCareOfTheAgedDinnerContainer.setFollowChildEnabled(true);

      addKaigoHealthCareOfTheAgedDinnerContainer();
    }
    return kaigoHealthCareOfTheAgedDinnerContainer;

  }

  /**
   * �H���񋟂��擾���܂��B
   * @return �H����
   */
  public ACComboBox getKaigoHealthCareOfTheAgedDinnerOffer(){
    if(kaigoHealthCareOfTheAgedDinnerOffer==null){

      kaigoHealthCareOfTheAgedDinnerOffer = new ACComboBox();

      getKaigoHealthCareOfTheAgedDinnerOfferContainer().setText("�H����");

      kaigoHealthCareOfTheAgedDinnerOffer.setBindPath("1520120");

      kaigoHealthCareOfTheAgedDinnerOffer.setEditable(false);

      kaigoHealthCareOfTheAgedDinnerOffer.setModelBindPath("1520120");

      kaigoHealthCareOfTheAgedDinnerOffer.setRenderBindPath("CONTENT");

      kaigoHealthCareOfTheAgedDinnerOffer.setModel(getKaigoHealthCareOfTheAgedDinnerOfferModel());

      addKaigoHealthCareOfTheAgedDinnerOffer();
    }
    return kaigoHealthCareOfTheAgedDinnerOffer;

  }

  /**
   * �H���񋟃R���e�i���擾���܂��B
   * @return �H���񋟃R���e�i
   */
  protected ACLabelContainer getKaigoHealthCareOfTheAgedDinnerOfferContainer(){
    if(kaigoHealthCareOfTheAgedDinnerOfferContainer==null){
      kaigoHealthCareOfTheAgedDinnerOfferContainer = new ACLabelContainer();
      kaigoHealthCareOfTheAgedDinnerOfferContainer.setFollowChildEnabled(true);
      kaigoHealthCareOfTheAgedDinnerOfferContainer.setVAlignment(VRLayout.CENTER);
      kaigoHealthCareOfTheAgedDinnerOfferContainer.add(getKaigoHealthCareOfTheAgedDinnerOffer(), null);
    }
    return kaigoHealthCareOfTheAgedDinnerOfferContainer;
  }

  /**
   * �H���񋟃��f�����擾���܂��B
   * @return �H���񋟃��f��
   */
  protected ACComboBoxModelAdapter getKaigoHealthCareOfTheAgedDinnerOfferModel(){
    if(kaigoHealthCareOfTheAgedDinnerOfferModel==null){
      kaigoHealthCareOfTheAgedDinnerOfferModel = new ACComboBoxModelAdapter();
      addKaigoHealthCareOfTheAgedDinnerOfferModel();
    }
    return kaigoHealthCareOfTheAgedDinnerOfferModel;
  }

  /**
   * �H����p���擾���܂��B
   * @return �H����p
   */
  public ACTextField getKaigoHealthCareOfTheAgedDinnerCost(){
    if(kaigoHealthCareOfTheAgedDinnerCost==null){

      kaigoHealthCareOfTheAgedDinnerCost = new ACTextField();

      getKaigoHealthCareOfTheAgedDinnerCostContainer().setText("�H����p");

      kaigoHealthCareOfTheAgedDinnerCost.setBindPath("1520122");

      kaigoHealthCareOfTheAgedDinnerCost.setColumns(4);

      kaigoHealthCareOfTheAgedDinnerCost.setCharType(VRCharType.ONLY_DIGIT);

      kaigoHealthCareOfTheAgedDinnerCost.setHorizontalAlignment(SwingConstants.RIGHT);

      kaigoHealthCareOfTheAgedDinnerCost.setIMEMode(InputSubset.LATIN);

      kaigoHealthCareOfTheAgedDinnerCost.setMaxLength(5);

      addKaigoHealthCareOfTheAgedDinnerCost();
    }
    return kaigoHealthCareOfTheAgedDinnerCost;

  }

  /**
   * �H����p�R���e�i���擾���܂��B
   * @return �H����p�R���e�i
   */
  protected ACLabelContainer getKaigoHealthCareOfTheAgedDinnerCostContainer(){
    if(kaigoHealthCareOfTheAgedDinnerCostContainer==null){
      kaigoHealthCareOfTheAgedDinnerCostContainer = new ACLabelContainer();
      kaigoHealthCareOfTheAgedDinnerCostContainer.setFollowChildEnabled(true);
      kaigoHealthCareOfTheAgedDinnerCostContainer.setVAlignment(VRLayout.CENTER);
      kaigoHealthCareOfTheAgedDinnerCostContainer.add(getKaigoHealthCareOfTheAgedDinnerCost(), null);
    }
    return kaigoHealthCareOfTheAgedDinnerCostContainer;
  }

  /**
   * �^�u3���擾���܂��B
   * @return �^�u3
   */
  public ACPanel getTab3(){
    if(tab3==null){

      tab3 = new ACPanel();

      tab3.setFollowChildEnabled(true);

      tab3.setHgap(0);

      addTab3();
    }
    return tab3;

  }

  /**
   * �E�����Z���擾���܂��B
   * @return �E�����Z
   */
  public ACValueArrayRadioButtonGroup getKaigoHealthCareOfTheAgedStaffSubtraction(){
    if(kaigoHealthCareOfTheAgedStaffSubtraction==null){

      kaigoHealthCareOfTheAgedStaffSubtraction = new ACValueArrayRadioButtonGroup();

      getKaigoHealthCareOfTheAgedStaffSubtractionContainer().setText("�l�����Z");

      kaigoHealthCareOfTheAgedStaffSubtraction.setBindPath("1520119");

      kaigoHealthCareOfTheAgedStaffSubtraction.setUseClearButton(false);

      kaigoHealthCareOfTheAgedStaffSubtraction.setModel(getKaigoHealthCareOfTheAgedStaffSubtractionModel());

      kaigoHealthCareOfTheAgedStaffSubtraction.setValues(new int[]{1,2,3});

      addKaigoHealthCareOfTheAgedStaffSubtraction();
    }
    return kaigoHealthCareOfTheAgedStaffSubtraction;

  }

  /**
   * �E�����Z�R���e�i���擾���܂��B
   * @return �E�����Z�R���e�i
   */
  protected ACLabelContainer getKaigoHealthCareOfTheAgedStaffSubtractionContainer(){
    if(kaigoHealthCareOfTheAgedStaffSubtractionContainer==null){
      kaigoHealthCareOfTheAgedStaffSubtractionContainer = new ACLabelContainer();
      kaigoHealthCareOfTheAgedStaffSubtractionContainer.setFollowChildEnabled(true);
      kaigoHealthCareOfTheAgedStaffSubtractionContainer.setVAlignment(VRLayout.CENTER);
      kaigoHealthCareOfTheAgedStaffSubtractionContainer.add(getKaigoHealthCareOfTheAgedStaffSubtraction(), null);
    }
    return kaigoHealthCareOfTheAgedStaffSubtractionContainer;
  }

  /**
   * �E�����Z���f�����擾���܂��B
   * @return �E�����Z���f��
   */
  protected ACListModelAdapter getKaigoHealthCareOfTheAgedStaffSubtractionModel(){
    if(kaigoHealthCareOfTheAgedStaffSubtractionModel==null){
      kaigoHealthCareOfTheAgedStaffSubtractionModel = new ACListModelAdapter();
      addKaigoHealthCareOfTheAgedStaffSubtractionModel();
    }
    return kaigoHealthCareOfTheAgedStaffSubtractionModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getKaigoHealthCareOfTheAgedStaffSubtractionCapacityNot(){
    if(kaigoHealthCareOfTheAgedStaffSubtractionCapacityNot==null){

      kaigoHealthCareOfTheAgedStaffSubtractionCapacityNot = new ACRadioButtonItem();

      kaigoHealthCareOfTheAgedStaffSubtractionCapacityNot.setText("�Ȃ�");

      kaigoHealthCareOfTheAgedStaffSubtractionCapacityNot.setGroup(getKaigoHealthCareOfTheAgedStaffSubtraction());

      kaigoHealthCareOfTheAgedStaffSubtractionCapacityNot.setConstraints(VRLayout.FLOW);

      addKaigoHealthCareOfTheAgedStaffSubtractionCapacityNot();
    }
    return kaigoHealthCareOfTheAgedStaffSubtractionCapacityNot;

  }

  /**
   * ������߂��擾���܂��B
   * @return �������
   */
  public ACRadioButtonItem getKaigoHealthCareOfTheAgedStaffSubtractionCapacityExcess(){
    if(kaigoHealthCareOfTheAgedStaffSubtractionCapacityExcess==null){

      kaigoHealthCareOfTheAgedStaffSubtractionCapacityExcess = new ACRadioButtonItem();

      kaigoHealthCareOfTheAgedStaffSubtractionCapacityExcess.setText("�������");

      kaigoHealthCareOfTheAgedStaffSubtractionCapacityExcess.setGroup(getKaigoHealthCareOfTheAgedStaffSubtraction());

      kaigoHealthCareOfTheAgedStaffSubtractionCapacityExcess.setConstraints(VRLayout.FLOW_RETURN);

      addKaigoHealthCareOfTheAgedStaffSubtractionCapacityExcess();
    }
    return kaigoHealthCareOfTheAgedStaffSubtractionCapacityExcess;

  }

  /**
   * �Ō�E���E�����͈�t�APT�EOT�EST�A���x�������̕s�����擾���܂��B
   * @return �Ō�E���E�����͈�t�APT�EOT�EST�A���x�������̕s��
   */
  public ACRadioButtonItem getKaigoHealthCareOfTheAgedStaffSubtractionPersonLack(){
    if(kaigoHealthCareOfTheAgedStaffSubtractionPersonLack==null){

      kaigoHealthCareOfTheAgedStaffSubtractionPersonLack = new ACRadioButtonItem();

      kaigoHealthCareOfTheAgedStaffSubtractionPersonLack.setText("<html>�Ō�E���E�����͈�t�APT�EOT�EST�A<br>���x�������̕s��<html>");

      kaigoHealthCareOfTheAgedStaffSubtractionPersonLack.setGroup(getKaigoHealthCareOfTheAgedStaffSubtraction());

      kaigoHealthCareOfTheAgedStaffSubtractionPersonLack.setConstraints(VRLayout.FLOW);

      addKaigoHealthCareOfTheAgedStaffSubtractionPersonLack();
    }
    return kaigoHealthCareOfTheAgedStaffSubtractionPersonLack;

  }

  /**
   * ���j�b�g�P�A�̐������擾���܂��B
   * @return ���j�b�g�P�A�̐���
   */
  public ACValueArrayRadioButtonGroup getUnitCareMaintenanceRadio(){
    if(unitCareMaintenanceRadio==null){

      unitCareMaintenanceRadio = new ACValueArrayRadioButtonGroup();

      getUnitCareMaintenanceRadioContainer().setText("���j�b�g�P�A�̐���");

      unitCareMaintenanceRadio.setBindPath("1520127");

      unitCareMaintenanceRadio.setUseClearButton(false);

      unitCareMaintenanceRadio.setModel(getUnitCareMaintenanceRadioModel());

      unitCareMaintenanceRadio.setValues(new int[]{1,2});

      addUnitCareMaintenanceRadio();
    }
    return unitCareMaintenanceRadio;

  }

  /**
   * ���j�b�g�P�A�̐����R���e�i���擾���܂��B
   * @return ���j�b�g�P�A�̐����R���e�i
   */
  protected ACLabelContainer getUnitCareMaintenanceRadioContainer(){
    if(unitCareMaintenanceRadioContainer==null){
      unitCareMaintenanceRadioContainer = new ACLabelContainer();
      unitCareMaintenanceRadioContainer.setFollowChildEnabled(true);
      unitCareMaintenanceRadioContainer.setVAlignment(VRLayout.CENTER);
      unitCareMaintenanceRadioContainer.add(getUnitCareMaintenanceRadio(), null);
    }
    return unitCareMaintenanceRadioContainer;
  }

  /**
   * ���j�b�g�P�A�̐������f�����擾���܂��B
   * @return ���j�b�g�P�A�̐������f��
   */
  protected ACListModelAdapter getUnitCareMaintenanceRadioModel(){
    if(unitCareMaintenanceRadioModel==null){
      unitCareMaintenanceRadioModel = new ACListModelAdapter();
      addUnitCareMaintenanceRadioModel();
    }
    return unitCareMaintenanceRadioModel;
  }

  /**
   * ���������擾���܂��B
   * @return ������
   */
  public ACRadioButtonItem getUnitCareMaintenanceRadioItem1(){
    if(unitCareMaintenanceRadioItem1==null){

      unitCareMaintenanceRadioItem1 = new ACRadioButtonItem();

      unitCareMaintenanceRadioItem1.setText("������");

      unitCareMaintenanceRadioItem1.setGroup(getUnitCareMaintenanceRadio());

      unitCareMaintenanceRadioItem1.setConstraints(VRLayout.FLOW);

      addUnitCareMaintenanceRadioItem1();
    }
    return unitCareMaintenanceRadioItem1;

  }

  /**
   * �������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getUnitCareMaintenanceRadioItem2(){
    if(unitCareMaintenanceRadioItem2==null){

      unitCareMaintenanceRadioItem2 = new ACRadioButtonItem();

      unitCareMaintenanceRadioItem2.setText("����");

      unitCareMaintenanceRadioItem2.setGroup(getUnitCareMaintenanceRadio());

      unitCareMaintenanceRadioItem2.setConstraints(VRLayout.FLOW);

      addUnitCareMaintenanceRadioItem2();
    }
    return unitCareMaintenanceRadioItem2;

  }

  /**
   * �×{�̐��ێ����ʉ��Z���擾���܂��B
   * @return �×{�̐��ێ����ʉ��Z
   */
  public ACValueArrayRadioButtonGroup getRecuperationRadio(){
    if(recuperationRadio==null){

      recuperationRadio = new ACValueArrayRadioButtonGroup();

      getRecuperationRadioContainer().setText("�×{�̐��ێ����ʉ��Z");

      recuperationRadio.setBindPath("1520134");

      recuperationRadio.setUseClearButton(false);

      recuperationRadio.setModel(getRecuperationRadioModel());

      recuperationRadio.setValues(new int[]{1,2});

      addRecuperationRadio();
    }
    return recuperationRadio;

  }

  /**
   * �×{�̐��ێ����ʉ��Z�R���e�i���擾���܂��B
   * @return �×{�̐��ێ����ʉ��Z�R���e�i
   */
  protected ACLabelContainer getRecuperationRadioContainer(){
    if(recuperationRadioContainer==null){
      recuperationRadioContainer = new ACLabelContainer();
      recuperationRadioContainer.setFollowChildEnabled(true);
      recuperationRadioContainer.setVAlignment(VRLayout.CENTER);
      recuperationRadioContainer.add(getRecuperationRadio(), null);
    }
    return recuperationRadioContainer;
  }

  /**
   * �×{�̐��ێ����ʉ��Z���f�����擾���܂��B
   * @return �×{�̐��ێ����ʉ��Z���f��
   */
  protected ACListModelAdapter getRecuperationRadioModel(){
    if(recuperationRadioModel==null){
      recuperationRadioModel = new ACListModelAdapter();
      addRecuperationRadioModel();
    }
    return recuperationRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getRecuperationRadioItem1(){
    if(recuperationRadioItem1==null){

      recuperationRadioItem1 = new ACRadioButtonItem();

      recuperationRadioItem1.setText("�Ȃ�");

      recuperationRadioItem1.setGroup(getRecuperationRadio());

      recuperationRadioItem1.setConstraints(VRLayout.FLOW);

      addRecuperationRadioItem1();
    }
    return recuperationRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getRecuperationRadioItem2(){
    if(recuperationRadioItem2==null){

      recuperationRadioItem2 = new ACRadioButtonItem();

      recuperationRadioItem2.setText("����");

      recuperationRadioItem2.setGroup(getRecuperationRadio());

      recuperationRadioItem2.setConstraints(VRLayout.FLOW);

      addRecuperationRadioItem2();
    }
    return recuperationRadioItem2;

  }

  /**
   * ��ΐE���z�u���Z���擾���܂��B
   * @return ��ΐE���z�u���Z
   */
  public ACValueArrayRadioButtonGroup getNightStaffDispositionAddRadioGroup(){
    if(nightStaffDispositionAddRadioGroup==null){

      nightStaffDispositionAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getNightStaffDispositionAddRadioGroupContainer().setText("��ΐE���z�u���Z");

      nightStaffDispositionAddRadioGroup.setBindPath("1520136");

      nightStaffDispositionAddRadioGroup.setNoSelectIndex(0);

      nightStaffDispositionAddRadioGroup.setUseClearButton(false);

      nightStaffDispositionAddRadioGroup.setModel(getNightStaffDispositionAddRadioGroupModel());

      nightStaffDispositionAddRadioGroup.setValues(new int[]{1,2});

      addNightStaffDispositionAddRadioGroup();
    }
    return nightStaffDispositionAddRadioGroup;

  }

  /**
   * ��ΐE���z�u���Z�R���e�i���擾���܂��B
   * @return ��ΐE���z�u���Z�R���e�i
   */
  protected ACLabelContainer getNightStaffDispositionAddRadioGroupContainer(){
    if(nightStaffDispositionAddRadioGroupContainer==null){
      nightStaffDispositionAddRadioGroupContainer = new ACLabelContainer();
      nightStaffDispositionAddRadioGroupContainer.setFollowChildEnabled(true);
      nightStaffDispositionAddRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      nightStaffDispositionAddRadioGroupContainer.add(getNightStaffDispositionAddRadioGroup(), null);
    }
    return nightStaffDispositionAddRadioGroupContainer;
  }

  /**
   * ��ΐE���z�u���Z���f�����擾���܂��B
   * @return ��ΐE���z�u���Z���f��
   */
  protected ACListModelAdapter getNightStaffDispositionAddRadioGroupModel(){
    if(nightStaffDispositionAddRadioGroupModel==null){
      nightStaffDispositionAddRadioGroupModel = new ACListModelAdapter();
      addNightStaffDispositionAddRadioGroupModel();
    }
    return nightStaffDispositionAddRadioGroupModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getNightStaffDispositionAddRadioItem1(){
    if(nightStaffDispositionAddRadioItem1==null){

      nightStaffDispositionAddRadioItem1 = new ACRadioButtonItem();

      nightStaffDispositionAddRadioItem1.setText("�Ȃ�");

      nightStaffDispositionAddRadioItem1.setGroup(getNightStaffDispositionAddRadioGroup());

      nightStaffDispositionAddRadioItem1.setConstraints(VRLayout.FLOW);

      addNightStaffDispositionAddRadioItem1();
    }
    return nightStaffDispositionAddRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getNightStaffDispositionAddRadioItem2(){
    if(nightStaffDispositionAddRadioItem2==null){

      nightStaffDispositionAddRadioItem2 = new ACRadioButtonItem();

      nightStaffDispositionAddRadioItem2.setText("����");

      nightStaffDispositionAddRadioItem2.setGroup(getNightStaffDispositionAddRadioGroup());

      nightStaffDispositionAddRadioItem2.setConstraints(VRLayout.FLOW);

      addNightStaffDispositionAddRadioItem2();
    }
    return nightStaffDispositionAddRadioItem2;

  }

  /**
   * �F�m�ǃP�A���Z���擾���܂��B
   * @return �F�m�ǃP�A���Z
   */
  public ACValueArrayRadioButtonGroup getIntentionCommunicationDifficultyAddRadio(){
    if(intentionCommunicationDifficultyAddRadio==null){

      intentionCommunicationDifficultyAddRadio = new ACValueArrayRadioButtonGroup();

      getIntentionCommunicationDifficultyAddRadioContainer().setText("�F�m�ǃP�A���Z");

      intentionCommunicationDifficultyAddRadio.setBindPath("1520128");

      intentionCommunicationDifficultyAddRadio.setUseClearButton(false);

      intentionCommunicationDifficultyAddRadio.setModel(getIntentionCommunicationDifficultyAddRadioModel());

      intentionCommunicationDifficultyAddRadio.setValues(new int[]{1,2});

      addIntentionCommunicationDifficultyAddRadio();
    }
    return intentionCommunicationDifficultyAddRadio;

  }

  /**
   * �F�m�ǃP�A���Z�R���e�i���擾���܂��B
   * @return �F�m�ǃP�A���Z�R���e�i
   */
  protected ACLabelContainer getIntentionCommunicationDifficultyAddRadioContainer(){
    if(intentionCommunicationDifficultyAddRadioContainer==null){
      intentionCommunicationDifficultyAddRadioContainer = new ACLabelContainer();
      intentionCommunicationDifficultyAddRadioContainer.setFollowChildEnabled(true);
      intentionCommunicationDifficultyAddRadioContainer.setVAlignment(VRLayout.CENTER);
      intentionCommunicationDifficultyAddRadioContainer.add(getIntentionCommunicationDifficultyAddRadio(), null);
    }
    return intentionCommunicationDifficultyAddRadioContainer;
  }

  /**
   * �F�m�ǃP�A���Z���f�����擾���܂��B
   * @return �F�m�ǃP�A���Z���f��
   */
  protected ACListModelAdapter getIntentionCommunicationDifficultyAddRadioModel(){
    if(intentionCommunicationDifficultyAddRadioModel==null){
      intentionCommunicationDifficultyAddRadioModel = new ACListModelAdapter();
      addIntentionCommunicationDifficultyAddRadioModel();
    }
    return intentionCommunicationDifficultyAddRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getIntentionCommunicationDifficultyAddRadioItem1(){
    if(intentionCommunicationDifficultyAddRadioItem1==null){

      intentionCommunicationDifficultyAddRadioItem1 = new ACRadioButtonItem();

      intentionCommunicationDifficultyAddRadioItem1.setText("�Ȃ�");

      intentionCommunicationDifficultyAddRadioItem1.setGroup(getIntentionCommunicationDifficultyAddRadio());

      intentionCommunicationDifficultyAddRadioItem1.setConstraints(VRLayout.FLOW);

      addIntentionCommunicationDifficultyAddRadioItem1();
    }
    return intentionCommunicationDifficultyAddRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getIntentionCommunicationDifficultyAddRadioItem2(){
    if(intentionCommunicationDifficultyAddRadioItem2==null){

      intentionCommunicationDifficultyAddRadioItem2 = new ACRadioButtonItem();

      intentionCommunicationDifficultyAddRadioItem2.setText("����");

      intentionCommunicationDifficultyAddRadioItem2.setGroup(getIntentionCommunicationDifficultyAddRadio());

      intentionCommunicationDifficultyAddRadioItem2.setConstraints(VRLayout.FLOW);

      addIntentionCommunicationDifficultyAddRadioItem2();
    }
    return intentionCommunicationDifficultyAddRadioItem2;

  }

  /**
   * �F�m�ǐ��P�A���Z���擾���܂��B
   * @return �F�m�ǐ��P�A���Z
   */
  public ACValueArrayRadioButtonGroup getDementiaProfessionalCareAddRadioGroup(){
    if(dementiaProfessionalCareAddRadioGroup==null){

      dementiaProfessionalCareAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getDementiaProfessionalCareAddRadioGroupContainer().setText("�F�m�ǐ��P�A���Z");

      dementiaProfessionalCareAddRadioGroup.setBindPath("1520137");

      dementiaProfessionalCareAddRadioGroup.setVisible(true);

      dementiaProfessionalCareAddRadioGroup.setEnabled(true);

      dementiaProfessionalCareAddRadioGroup.setNoSelectIndex(0);

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

      dementiaProfessionalCareAddRadioItem1.setConstraints(VRLayout.FLOW);

      addDementiaProfessionalCareAddRadioItem1();
    }
    return dementiaProfessionalCareAddRadioItem1;

  }

  /**
   * I�^���擾���܂��B
   * @return I�^
   */
  public ACRadioButtonItem getDementiaProfessionalCareAddRadioItem2(){
    if(dementiaProfessionalCareAddRadioItem2==null){

      dementiaProfessionalCareAddRadioItem2 = new ACRadioButtonItem();

      dementiaProfessionalCareAddRadioItem2.setText("I�^");

      dementiaProfessionalCareAddRadioItem2.setGroup(getDementiaProfessionalCareAddRadioGroup());

      dementiaProfessionalCareAddRadioItem2.setConstraints(VRLayout.FLOW);

      addDementiaProfessionalCareAddRadioItem2();
    }
    return dementiaProfessionalCareAddRadioItem2;

  }

  /**
   * II�^���擾���܂��B
   * @return II�^
   */
  public ACRadioButtonItem getDementiaProfessionalCareAddRadioItem3(){
    if(dementiaProfessionalCareAddRadioItem3==null){

      dementiaProfessionalCareAddRadioItem3 = new ACRadioButtonItem();

      dementiaProfessionalCareAddRadioItem3.setText("II�^");

      dementiaProfessionalCareAddRadioItem3.setGroup(getDementiaProfessionalCareAddRadioGroup());

      dementiaProfessionalCareAddRadioItem3.setConstraints(VRLayout.FLOW);

      addDementiaProfessionalCareAddRadioItem3();
    }
    return dementiaProfessionalCareAddRadioItem3;

  }

  /**
   * ��N���F�m�Ǔ����Ҏ�����Z���擾���܂��B
   * @return ��N���F�m�Ǔ����Ҏ�����Z
   */
  public ACValueArrayRadioButtonGroup getYoungDementiaPatinetAddRadioGroup(){
    if(youngDementiaPatinetAddRadioGroup==null){

      youngDementiaPatinetAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getYoungDementiaPatinetAddRadioGroupContainer().setText("��N���F�m�Ǔ����Ҏ�����Z");

      youngDementiaPatinetAddRadioGroup.setBindPath("1520138");

      youngDementiaPatinetAddRadioGroup.setNoSelectIndex(0);

      youngDementiaPatinetAddRadioGroup.setUseClearButton(false);

      youngDementiaPatinetAddRadioGroup.setModel(getYoungDementiaPatinetAddRadioGroupModel());

      youngDementiaPatinetAddRadioGroup.setValues(new int[]{1,2});

      addYoungDementiaPatinetAddRadioGroup();
    }
    return youngDementiaPatinetAddRadioGroup;

  }

  /**
   * ��N���F�m�Ǔ����Ҏ�����Z�R���e�i���擾���܂��B
   * @return ��N���F�m�Ǔ����Ҏ�����Z�R���e�i
   */
  protected ACLabelContainer getYoungDementiaPatinetAddRadioGroupContainer(){
    if(youngDementiaPatinetAddRadioGroupContainer==null){
      youngDementiaPatinetAddRadioGroupContainer = new ACLabelContainer();
      youngDementiaPatinetAddRadioGroupContainer.setFollowChildEnabled(true);
      youngDementiaPatinetAddRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      youngDementiaPatinetAddRadioGroupContainer.add(getYoungDementiaPatinetAddRadioGroup(), null);
    }
    return youngDementiaPatinetAddRadioGroupContainer;
  }

  /**
   * ��N���F�m�Ǔ����Ҏ�����Z���f�����擾���܂��B
   * @return ��N���F�m�Ǔ����Ҏ�����Z���f��
   */
  protected ACListModelAdapter getYoungDementiaPatinetAddRadioGroupModel(){
    if(youngDementiaPatinetAddRadioGroupModel==null){
      youngDementiaPatinetAddRadioGroupModel = new ACListModelAdapter();
      addYoungDementiaPatinetAddRadioGroupModel();
    }
    return youngDementiaPatinetAddRadioGroupModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getYoungDementiaPatinetAddRadioItem1(){
    if(youngDementiaPatinetAddRadioItem1==null){

      youngDementiaPatinetAddRadioItem1 = new ACRadioButtonItem();

      youngDementiaPatinetAddRadioItem1.setText("�Ȃ�");

      youngDementiaPatinetAddRadioItem1.setGroup(getYoungDementiaPatinetAddRadioGroup());

      youngDementiaPatinetAddRadioItem1.setConstraints(VRLayout.FLOW);

      addYoungDementiaPatinetAddRadioItem1();
    }
    return youngDementiaPatinetAddRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getYoungDementiaPatinetAddRadioItem2(){
    if(youngDementiaPatinetAddRadioItem2==null){

      youngDementiaPatinetAddRadioItem2 = new ACRadioButtonItem();

      youngDementiaPatinetAddRadioItem2.setText("����");

      youngDementiaPatinetAddRadioItem2.setGroup(getYoungDementiaPatinetAddRadioGroup());

      youngDementiaPatinetAddRadioItem2.setConstraints(VRLayout.FLOW);

      addYoungDementiaPatinetAddRadioItem2();
    }
    return youngDementiaPatinetAddRadioItem2;

  }

  /**
   * �F�m�Ǐ��񋟉��Z���擾���܂��B
   * @return �F�m�Ǐ��񋟉��Z
   */
  public ACValueArrayRadioButtonGroup getDementiainfoAddRadioGroup(){
    if(dementiainfoAddRadioGroup==null){

      dementiainfoAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getDementiainfoAddRadioGroupContainer().setText("�F�m�Ǐ��񋟉��Z");

      dementiainfoAddRadioGroup.setBindPath("1520139");

      dementiainfoAddRadioGroup.setNoSelectIndex(0);

      dementiainfoAddRadioGroup.setUseClearButton(false);

      dementiainfoAddRadioGroup.setModel(getDementiainfoAddRadioGroupModel());

      dementiainfoAddRadioGroup.setValues(new int[]{1,2});

      addDementiainfoAddRadioGroup();
    }
    return dementiainfoAddRadioGroup;

  }

  /**
   * �F�m�Ǐ��񋟉��Z�R���e�i���擾���܂��B
   * @return �F�m�Ǐ��񋟉��Z�R���e�i
   */
  protected ACLabelContainer getDementiainfoAddRadioGroupContainer(){
    if(dementiainfoAddRadioGroupContainer==null){
      dementiainfoAddRadioGroupContainer = new ACLabelContainer();
      dementiainfoAddRadioGroupContainer.setFollowChildEnabled(true);
      dementiainfoAddRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      dementiainfoAddRadioGroupContainer.add(getDementiainfoAddRadioGroup(), null);
    }
    return dementiainfoAddRadioGroupContainer;
  }

  /**
   * �F�m�Ǐ��񋟉��Z���f�����擾���܂��B
   * @return �F�m�Ǐ��񋟉��Z���f��
   */
  protected ACListModelAdapter getDementiainfoAddRadioGroupModel(){
    if(dementiainfoAddRadioGroupModel==null){
      dementiainfoAddRadioGroupModel = new ACListModelAdapter();
      addDementiainfoAddRadioGroupModel();
    }
    return dementiainfoAddRadioGroupModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getDementiainfoAddRadioItem1(){
    if(dementiainfoAddRadioItem1==null){

      dementiainfoAddRadioItem1 = new ACRadioButtonItem();

      dementiainfoAddRadioItem1.setText("�Ȃ�");

      dementiainfoAddRadioItem1.setGroup(getDementiainfoAddRadioGroup());

      dementiainfoAddRadioItem1.setConstraints(VRLayout.FLOW);

      addDementiainfoAddRadioItem1();
    }
    return dementiainfoAddRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getDementiainfoAddRadioItem2(){
    if(dementiainfoAddRadioItem2==null){

      dementiainfoAddRadioItem2 = new ACRadioButtonItem();

      dementiainfoAddRadioItem2.setText("����");

      dementiainfoAddRadioItem2.setGroup(getDementiainfoAddRadioGroup());

      dementiainfoAddRadioItem2.setConstraints(VRLayout.FLOW);

      addDementiainfoAddRadioItem2();
    }
    return dementiainfoAddRadioItem2;

  }

  /**
   * �F�m�Ǎs���E�S���Ǐ�ً}�Ή����Z���擾���܂��B
   * @return �F�m�Ǎs���E�S���Ǐ�ً}�Ή����Z
   */
  public ACValueArrayRadioButtonGroup getDementiaEmergencyAddRadioGroup(){
    if(dementiaEmergencyAddRadioGroup==null){

      dementiaEmergencyAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getDementiaEmergencyAddRadioGroupContainer().setText("�F�m�Ǎs���E�S���Ǐ�ً}�Ή����Z");

      dementiaEmergencyAddRadioGroup.setBindPath("1520146");

      dementiaEmergencyAddRadioGroup.setNoSelectIndex(0);

      dementiaEmergencyAddRadioGroup.setUseClearButton(false);

      dementiaEmergencyAddRadioGroup.setModel(getDementiaEmergencyAddRadioGroupModel());

      dementiaEmergencyAddRadioGroup.setValues(new int[]{1,2});

      addDementiaEmergencyAddRadioGroup();
    }
    return dementiaEmergencyAddRadioGroup;

  }

  /**
   * �F�m�Ǎs���E�S���Ǐ�ً}�Ή����Z�R���e�i���擾���܂��B
   * @return �F�m�Ǎs���E�S���Ǐ�ً}�Ή����Z�R���e�i
   */
  protected ACLabelContainer getDementiaEmergencyAddRadioGroupContainer(){
    if(dementiaEmergencyAddRadioGroupContainer==null){
      dementiaEmergencyAddRadioGroupContainer = new ACLabelContainer();
      dementiaEmergencyAddRadioGroupContainer.setFollowChildEnabled(true);
      dementiaEmergencyAddRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      dementiaEmergencyAddRadioGroupContainer.add(getDementiaEmergencyAddRadioGroup(), null);
    }
    return dementiaEmergencyAddRadioGroupContainer;
  }

  /**
   * �F�m�Ǎs���E�S���Ǐ�ً}�Ή����Z���f�����擾���܂��B
   * @return �F�m�Ǎs���E�S���Ǐ�ً}�Ή����Z���f��
   */
  protected ACListModelAdapter getDementiaEmergencyAddRadioGroupModel(){
    if(dementiaEmergencyAddRadioGroupModel==null){
      dementiaEmergencyAddRadioGroupModel = new ACListModelAdapter();
      addDementiaEmergencyAddRadioGroupModel();
    }
    return dementiaEmergencyAddRadioGroupModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getDementiaEmergencyAddRadioItem1(){
    if(dementiaEmergencyAddRadioItem1==null){

      dementiaEmergencyAddRadioItem1 = new ACRadioButtonItem();

      dementiaEmergencyAddRadioItem1.setText("�Ȃ�");

      dementiaEmergencyAddRadioItem1.setGroup(getDementiaEmergencyAddRadioGroup());

      dementiaEmergencyAddRadioItem1.setConstraints(VRLayout.FLOW);

      addDementiaEmergencyAddRadioItem1();
    }
    return dementiaEmergencyAddRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getDementiaEmergencyAddRadioItem2(){
    if(dementiaEmergencyAddRadioItem2==null){

      dementiaEmergencyAddRadioItem2 = new ACRadioButtonItem();

      dementiaEmergencyAddRadioItem2.setText("����");

      dementiaEmergencyAddRadioItem2.setGroup(getDementiaEmergencyAddRadioGroup());

      dementiaEmergencyAddRadioItem2.setConstraints(VRLayout.FLOW);

      addDementiaEmergencyAddRadioItem2();
    }
    return dementiaEmergencyAddRadioItem2;

  }

  /**
   * �g�̍S���p�~�����{���Z���擾���܂��B
   * @return �g�̍S���p�~�����{���Z
   */
  public ACValueArrayRadioButtonGroup getBodyRestraintAbolitionRadio(){
    if(bodyRestraintAbolitionRadio==null){

      bodyRestraintAbolitionRadio = new ACValueArrayRadioButtonGroup();

      getBodyRestraintAbolitionRadioContainer().setText("�g�̍S���p�~�����{���Z");

      bodyRestraintAbolitionRadio.setBindPath("1520130");

      bodyRestraintAbolitionRadio.setUseClearButton(false);

      bodyRestraintAbolitionRadio.setModel(getBodyRestraintAbolitionRadioModel());

      bodyRestraintAbolitionRadio.setValues(new int[]{1,2});

      addBodyRestraintAbolitionRadio();
    }
    return bodyRestraintAbolitionRadio;

  }

  /**
   * �g�̍S���p�~�����{���Z�R���e�i���擾���܂��B
   * @return �g�̍S���p�~�����{���Z�R���e�i
   */
  protected ACLabelContainer getBodyRestraintAbolitionRadioContainer(){
    if(bodyRestraintAbolitionRadioContainer==null){
      bodyRestraintAbolitionRadioContainer = new ACLabelContainer();
      bodyRestraintAbolitionRadioContainer.setFollowChildEnabled(true);
      bodyRestraintAbolitionRadioContainer.setVAlignment(VRLayout.CENTER);
      bodyRestraintAbolitionRadioContainer.add(getBodyRestraintAbolitionRadio(), null);
    }
    return bodyRestraintAbolitionRadioContainer;
  }

  /**
   * �g�̍S���p�~�����{���Z���f�����擾���܂��B
   * @return �g�̍S���p�~�����{���Z���f��
   */
  protected ACListModelAdapter getBodyRestraintAbolitionRadioModel(){
    if(bodyRestraintAbolitionRadioModel==null){
      bodyRestraintAbolitionRadioModel = new ACListModelAdapter();
      addBodyRestraintAbolitionRadioModel();
    }
    return bodyRestraintAbolitionRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getBodyRestraintAbolitionRadioItem1(){
    if(bodyRestraintAbolitionRadioItem1==null){

      bodyRestraintAbolitionRadioItem1 = new ACRadioButtonItem();

      bodyRestraintAbolitionRadioItem1.setText("�Ȃ�");

      bodyRestraintAbolitionRadioItem1.setGroup(getBodyRestraintAbolitionRadio());

      bodyRestraintAbolitionRadioItem1.setConstraints(VRLayout.FLOW);

      addBodyRestraintAbolitionRadioItem1();
    }
    return bodyRestraintAbolitionRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getBodyRestraintAbolitionRadioItem2(){
    if(bodyRestraintAbolitionRadioItem2==null){

      bodyRestraintAbolitionRadioItem2 = new ACRadioButtonItem();

      bodyRestraintAbolitionRadioItem2.setText("����");

      bodyRestraintAbolitionRadioItem2.setGroup(getBodyRestraintAbolitionRadio());

      bodyRestraintAbolitionRadioItem2.setConstraints(VRLayout.FLOW);

      addBodyRestraintAbolitionRadioItem2();
    }
    return bodyRestraintAbolitionRadioItem2;

  }

  /**
   * �^�u4���擾���܂��B
   * @return �^�u4
   */
  public ACPanel getTab4(){
    if(tab4==null){

      tab4 = new ACPanel();

      tab4.setFollowChildEnabled(true);

      tab4.setHgap(0);

      tab4.setLabelMargin(0);

      tab4.setVgap(0);

      addTab4();
    }
    return tab4;

  }

  /**
   * �ޏ��֘A���Z���擾���܂��B
   * @return �ޏ��֘A���Z
   */
  public ACLabelContainer getKaigoHealthCareOfTheAgedHijoAddition(){
    if(kaigoHealthCareOfTheAgedHijoAddition==null){

      kaigoHealthCareOfTheAgedHijoAddition = new ACLabelContainer();

      kaigoHealthCareOfTheAgedHijoAddition.setText("�ޏ��֘A���Z");

      kaigoHealthCareOfTheAgedHijoAddition.setFollowChildEnabled(true);

      addKaigoHealthCareOfTheAgedHijoAddition();
    }
    return kaigoHealthCareOfTheAgedHijoAddition;

  }

  /**
   * �ޏ�(�@)�O�K��w�����Z���擾���܂��B
   * @return �ޏ�(�@)�O�K��w�����Z
   */
  public ACIntegerCheckBox getLeavingHospitalPreConsultationAddition(){
    if(leavingHospitalPreConsultationAddition==null){

      leavingHospitalPreConsultationAddition = new ACIntegerCheckBox();

      leavingHospitalPreConsultationAddition.setText("�ޏ��O�K��w�����Z");

      leavingHospitalPreConsultationAddition.setBindPath("3020109");

      leavingHospitalPreConsultationAddition.setSelectValue(2);

      leavingHospitalPreConsultationAddition.setUnSelectValue(1);

      addLeavingHospitalPreConsultationAddition();
    }
    return leavingHospitalPreConsultationAddition;

  }

  /**
   * �ޏ�(�@)��K��w�����Z���擾���܂��B
   * @return �ޏ�(�@)��K��w�����Z
   */
  public ACIntegerCheckBox getLeavingHospitalAfterConsultationAddition(){
    if(leavingHospitalAfterConsultationAddition==null){

      leavingHospitalAfterConsultationAddition = new ACIntegerCheckBox();

      leavingHospitalAfterConsultationAddition.setText("�ޏ���K��w�����Z");

      leavingHospitalAfterConsultationAddition.setBindPath("3020110");

      leavingHospitalAfterConsultationAddition.setSelectValue(2);

      leavingHospitalAfterConsultationAddition.setUnSelectValue(1);

      addLeavingHospitalAfterConsultationAddition();
    }
    return leavingHospitalAfterConsultationAddition;

  }

  /**
   * �ޏ�(�@)���w�����Z���擾���܂��B
   * @return �ޏ�(�@)���w�����Z
   */
  public ACIntegerCheckBox getLeavingHospitalConsultationAddition(){
    if(leavingHospitalConsultationAddition==null){

      leavingHospitalConsultationAddition = new ACIntegerCheckBox();

      leavingHospitalConsultationAddition.setText("�ޏ����w�����Z");

      leavingHospitalConsultationAddition.setBindPath("3020105");

      leavingHospitalConsultationAddition.setSelectValue(2);

      leavingHospitalConsultationAddition.setUnSelectValue(1);

      addLeavingHospitalConsultationAddition();
    }
    return leavingHospitalConsultationAddition;

  }

  /**
   * �ޏ�(�@)�����񋟉��Z���擾���܂��B
   * @return �ޏ�(�@)�����񋟉��Z
   */
  public ACIntegerCheckBox getLeavingHospitalDissemination(){
    if(leavingHospitalDissemination==null){

      leavingHospitalDissemination = new ACIntegerCheckBox();

      leavingHospitalDissemination.setText("�ޏ������񋟉��Z");

      leavingHospitalDissemination.setBindPath("3020106");

      leavingHospitalDissemination.setSelectValue(2);

      leavingHospitalDissemination.setUnSelectValue(1);

      addLeavingHospitalDissemination();
    }
    return leavingHospitalDissemination;

  }

  /**
   * �ޏ�(�@)�O�A�g���Z���擾���܂��B
   * @return �ޏ�(�@)�O�A�g���Z
   */
  public ACIntegerCheckBox getLeavingHospitalCooperationAddition(){
    if(leavingHospitalCooperationAddition==null){

      leavingHospitalCooperationAddition = new ACIntegerCheckBox();

      leavingHospitalCooperationAddition.setText("�ޏ��O�A�g���Z");

      leavingHospitalCooperationAddition.setBindPath("3020107");

      leavingHospitalCooperationAddition.setSelectValue(2);

      leavingHospitalCooperationAddition.setUnSelectValue(1);

      addLeavingHospitalCooperationAddition();
    }
    return leavingHospitalCooperationAddition;

  }

  /**
   * �V�l�K��Ō�w�����Z���擾���܂��B
   * @return �V�l�K��Ō�w�����Z
   */
  public ACIntegerCheckBox getLeavingHospital(){
    if(leavingHospital==null){

      leavingHospital = new ACIntegerCheckBox();

      leavingHospital.setText("�V�l�K��Ō�w�����Z");

      leavingHospital.setBindPath("3020108");

      leavingHospital.setSelectValue(2);

      leavingHospital.setUnSelectValue(1);

      addLeavingHospital();
    }
    return leavingHospital;

  }

  /**
   * �ݑ�A�ݑ�×{�x�����Z���擾���܂��B
   * @return �ݑ�A�ݑ�×{�x�����Z
   */
  public ACValueArrayRadioButtonGroup getStayReturnSupportRyoyoAddRadio(){
    if(stayReturnSupportRyoyoAddRadio==null){

      stayReturnSupportRyoyoAddRadio = new ACValueArrayRadioButtonGroup();

      getStayReturnSupportRyoyoAddRadioContainer().setText("�ݑ�A�ݑ�×{�x�����Z");

      stayReturnSupportRyoyoAddRadio.setBindPath("1520140");

      stayReturnSupportRyoyoAddRadio.setNoSelectIndex(0);

      stayReturnSupportRyoyoAddRadio.setUseClearButton(false);

      stayReturnSupportRyoyoAddRadio.setModel(getStayReturnSupportRyoyoAddRadioModel());

      stayReturnSupportRyoyoAddRadio.setValues(new int[]{1,2});

      addStayReturnSupportRyoyoAddRadio();
    }
    return stayReturnSupportRyoyoAddRadio;

  }

  /**
   * �ݑ�A�ݑ�×{�x�����Z�R���e�i���擾���܂��B
   * @return �ݑ�A�ݑ�×{�x�����Z�R���e�i
   */
  protected ACLabelContainer getStayReturnSupportRyoyoAddRadioContainer(){
    if(stayReturnSupportRyoyoAddRadioContainer==null){
      stayReturnSupportRyoyoAddRadioContainer = new ACLabelContainer();
      stayReturnSupportRyoyoAddRadioContainer.setFollowChildEnabled(true);
      stayReturnSupportRyoyoAddRadioContainer.setVAlignment(VRLayout.CENTER);
      stayReturnSupportRyoyoAddRadioContainer.add(getStayReturnSupportRyoyoAddRadio(), null);
    }
    return stayReturnSupportRyoyoAddRadioContainer;
  }

  /**
   * �ݑ�A�ݑ�×{�x�����Z���f�����擾���܂��B
   * @return �ݑ�A�ݑ�×{�x�����Z���f��
   */
  protected ACListModelAdapter getStayReturnSupportRyoyoAddRadioModel(){
    if(stayReturnSupportRyoyoAddRadioModel==null){
      stayReturnSupportRyoyoAddRadioModel = new ACListModelAdapter();
      addStayReturnSupportRyoyoAddRadioModel();
    }
    return stayReturnSupportRyoyoAddRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getStayReturnSupportRyoyoAddRadioItem1(){
    if(stayReturnSupportRyoyoAddRadioItem1==null){

      stayReturnSupportRyoyoAddRadioItem1 = new ACRadioButtonItem();

      stayReturnSupportRyoyoAddRadioItem1.setText("�Ȃ�");

      stayReturnSupportRyoyoAddRadioItem1.setGroup(getStayReturnSupportRyoyoAddRadio());

      stayReturnSupportRyoyoAddRadioItem1.setConstraints(VRLayout.FLOW);

      addStayReturnSupportRyoyoAddRadioItem1();
    }
    return stayReturnSupportRyoyoAddRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getStayReturnSupportRyoyoAddRadioItem2(){
    if(stayReturnSupportRyoyoAddRadioItem2==null){

      stayReturnSupportRyoyoAddRadioItem2 = new ACRadioButtonItem();

      stayReturnSupportRyoyoAddRadioItem2.setText("����");

      stayReturnSupportRyoyoAddRadioItem2.setGroup(getStayReturnSupportRyoyoAddRadio());

      stayReturnSupportRyoyoAddRadioItem2.setConstraints(VRLayout.FLOW);

      addStayReturnSupportRyoyoAddRadioItem2();
    }
    return stayReturnSupportRyoyoAddRadioItem2;

  }

  /**
   * �ݑ�A�x���@�\���Z���擾���܂��B
   * @return �ݑ�A�x���@�\���Z
   */
  public ACValueArrayRadioButtonGroup getStayReturnSupportAddRadio(){
    if(stayReturnSupportAddRadio==null){

      stayReturnSupportAddRadio = new ACValueArrayRadioButtonGroup();

      getStayReturnSupportAddRadioContainer().setText("�ݑ�A�x���@�\���Z");

      stayReturnSupportAddRadio.setBindPath("1520148");

      stayReturnSupportAddRadio.setNoSelectIndex(0);

      stayReturnSupportAddRadio.setUseClearButton(false);

      stayReturnSupportAddRadio.setModel(getStayReturnSupportAddRadioModel());

      stayReturnSupportAddRadio.setValues(new int[]{1,2});

      addStayReturnSupportAddRadio();
    }
    return stayReturnSupportAddRadio;

  }

  /**
   * �ݑ�A�x���@�\���Z�R���e�i���擾���܂��B
   * @return �ݑ�A�x���@�\���Z�R���e�i
   */
  protected ACLabelContainer getStayReturnSupportAddRadioContainer(){
    if(stayReturnSupportAddRadioContainer==null){
      stayReturnSupportAddRadioContainer = new ACLabelContainer();
      stayReturnSupportAddRadioContainer.setFollowChildEnabled(true);
      stayReturnSupportAddRadioContainer.setVAlignment(VRLayout.CENTER);
      stayReturnSupportAddRadioContainer.add(getStayReturnSupportAddRadio(), null);
    }
    return stayReturnSupportAddRadioContainer;
  }

  /**
   * �ݑ�A�x���@�\���Z���f�����擾���܂��B
   * @return �ݑ�A�x���@�\���Z���f��
   */
  protected ACListModelAdapter getStayReturnSupportAddRadioModel(){
    if(stayReturnSupportAddRadioModel==null){
      stayReturnSupportAddRadioModel = new ACListModelAdapter();
      addStayReturnSupportAddRadioModel();
    }
    return stayReturnSupportAddRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getStayReturnSupportAddRadioItem1(){
    if(stayReturnSupportAddRadioItem1==null){

      stayReturnSupportAddRadioItem1 = new ACRadioButtonItem();

      stayReturnSupportAddRadioItem1.setText("�Ȃ�");

      stayReturnSupportAddRadioItem1.setGroup(getStayReturnSupportAddRadio());

      stayReturnSupportAddRadioItem1.setConstraints(VRLayout.FLOW);

      addStayReturnSupportAddRadioItem1();
    }
    return stayReturnSupportAddRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getStayReturnSupportAddRadioItem2(){
    if(stayReturnSupportAddRadioItem2==null){

      stayReturnSupportAddRadioItem2 = new ACRadioButtonItem();

      stayReturnSupportAddRadioItem2.setText("����");

      stayReturnSupportAddRadioItem2.setGroup(getStayReturnSupportAddRadio());

      stayReturnSupportAddRadioItem2.setConstraints(VRLayout.FLOW);

      addStayReturnSupportAddRadioItem2();
    }
    return stayReturnSupportAddRadioItem2;

  }

  /**
   * �^�[�~�i���P�A���Z���擾���܂��B
   * @return �^�[�~�i���P�A���Z
   */
  public ACValueArrayRadioButtonGroup getTerminalRadio(){
    if(terminalRadio==null){

      terminalRadio = new ACValueArrayRadioButtonGroup();

      getTerminalRadioContainer().setText("�^�[�~�i���P�A���Z");

      terminalRadio.setBindPath("1520141");

      terminalRadio.setNoSelectIndex(0);

      terminalRadio.setUseClearButton(false);

      terminalRadio.setModel(getTerminalRadioModel());

      terminalRadio.setValues(new int[]{1,2,3,4});

      addTerminalRadio();
    }
    return terminalRadio;

  }

  /**
   * �^�[�~�i���P�A���Z�R���e�i���擾���܂��B
   * @return �^�[�~�i���P�A���Z�R���e�i
   */
  protected ACLabelContainer getTerminalRadioContainer(){
    if(terminalRadioContainer==null){
      terminalRadioContainer = new ACLabelContainer();
      terminalRadioContainer.setFollowChildEnabled(true);
      terminalRadioContainer.setVAlignment(VRLayout.CENTER);
      terminalRadioContainer.add(getTerminalRadio(), null);
    }
    return terminalRadioContainer;
  }

  /**
   * �^�[�~�i���P�A���Z���f�����擾���܂��B
   * @return �^�[�~�i���P�A���Z���f��
   */
  protected ACListModelAdapter getTerminalRadioModel(){
    if(terminalRadioModel==null){
      terminalRadioModel = new ACListModelAdapter();
      addTerminalRadioModel();
    }
    return terminalRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getTerminalRadioItem1(){
    if(terminalRadioItem1==null){

      terminalRadioItem1 = new ACRadioButtonItem();

      terminalRadioItem1.setText("�Ȃ�");

      terminalRadioItem1.setGroup(getTerminalRadio());

      terminalRadioItem1.setConstraints(VRLayout.FLOW_RETURN);

      addTerminalRadioItem1();
    }
    return terminalRadioItem1;

  }

  /**
   * ���S���ȑO4���ȏ�30���ȉ����擾���܂��B
   * @return ���S���ȑO4���ȏ�30���ȉ�
   */
  public ACRadioButtonItem getTerminalRadioItem2(){
    if(terminalRadioItem2==null){

      terminalRadioItem2 = new ACRadioButtonItem();

      terminalRadioItem2.setText("���S���ȑO4���ȏ�30���ȉ�");

      terminalRadioItem2.setGroup(getTerminalRadio());

      terminalRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

      addTerminalRadioItem2();
    }
    return terminalRadioItem2;

  }

  /**
   * ���S���ȑO2������3�����擾���܂��B
   * @return ���S���ȑO2������3��
   */
  public ACRadioButtonItem getTerminalRadioItem3(){
    if(terminalRadioItem3==null){

      terminalRadioItem3 = new ACRadioButtonItem();

      terminalRadioItem3.setText("���S���ȑO2������3��");

      terminalRadioItem3.setGroup(getTerminalRadio());

      terminalRadioItem3.setConstraints(VRLayout.FLOW_RETURN);

      addTerminalRadioItem3();
    }
    return terminalRadioItem3;

  }

  /**
   * ���S�����擾���܂��B
   * @return ���S��
   */
  public ACRadioButtonItem getTerminalRadioItem4(){
    if(terminalRadioItem4==null){

      terminalRadioItem4 = new ACRadioButtonItem();

      terminalRadioItem4.setText("���S��");

      terminalRadioItem4.setGroup(getTerminalRadio());

      terminalRadioItem4.setConstraints(VRLayout.FLOW_RETURN);

      addTerminalRadioItem4();
    }
    return terminalRadioItem4;

  }

  /**
   * �^�[�~�i���P�A���Z�R���e�i���擾���܂��B
   * @return �^�[�~�i���P�A���Z�R���e�i
   */
  public ACLabelContainer getTerminalDaysContainer(){
    if(terminalDaysContainer==null){

      terminalDaysContainer = new ACLabelContainer();

      terminalDaysContainer.setText("�^�[�~�i���P�A���Z����");

      terminalDaysContainer.setFollowChildEnabled(true);

      addTerminalDaysContainer();
    }
    return terminalDaysContainer;

  }

  /**
   * �^�[�~�i���P�A���Z�������擾���܂��B
   * @return �^�[�~�i���P�A���Z����
   */
  public ACTextField getTerminalDays(){
    if(terminalDays==null){

      terminalDays = new ACTextField();

      terminalDays.setText("1");

      terminalDays.setBindPath("1520150");

      terminalDays.setColumns(2);

      terminalDays.setCharType(VRCharType.ONLY_DIGIT);

      terminalDays.setHorizontalAlignment(SwingConstants.RIGHT);

      terminalDays.setMaxLength(2);

      addTerminalDays();
    }
    return terminalDays;

  }

  /**
   * �^�[�~�i���P�A���Z�����P�ʂ��擾���܂��B
   * @return �^�[�~�i���P�A���Z�����P��
   */
  public ACLabel getTerminalDaysUnit(){
    if(terminalDaysUnit==null){

      terminalDaysUnit = new ACLabel();

      terminalDaysUnit.setText("��");

      addTerminalDaysUnit();
    }
    return terminalDaysUnit;

  }

  /**
   * �^�u5���擾���܂��B
   * @return �^�u5
   */
  public ACPanel getTab5(){
    if(tab5==null){

      tab5 = new ACPanel();

      tab5.setFollowChildEnabled(true);

      tab5.setHgap(0);

      tab5.setLabelMargin(0);

      tab5.setVgap(0);

      addTab5();
    }
    return tab5;

  }

  /**
   * �T�[�r�X�񋟑̐��������Z���擾���܂��B
   * @return �T�[�r�X�񋟑̐��������Z
   */
  public ACValueArrayRadioButtonGroup getServiceAddProvisionStructuralRadioGroup(){
    if(serviceAddProvisionStructuralRadioGroup==null){

      serviceAddProvisionStructuralRadioGroup = new ACValueArrayRadioButtonGroup();

      getServiceAddProvisionStructuralRadioGroupContainer().setText("�T�[�r�X�񋟑̐��������Z");

      serviceAddProvisionStructuralRadioGroup.setBindPath("1520142");

      serviceAddProvisionStructuralRadioGroup.setVisible(true);

      serviceAddProvisionStructuralRadioGroup.setEnabled(true);

      serviceAddProvisionStructuralRadioGroup.setNoSelectIndex(0);

      serviceAddProvisionStructuralRadioGroup.setUseClearButton(false);

      serviceAddProvisionStructuralRadioGroup.setModel(getServiceAddProvisionStructuralRadioGroupModel());

      serviceAddProvisionStructuralRadioGroup.setValues(new int[]{1,2,3,4});

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
   * I�^���擾���܂��B
   * @return I�^
   */
  public ACRadioButtonItem getServiceAddProvisionStructuralRadioItem2(){
    if(serviceAddProvisionStructuralRadioItem2==null){

      serviceAddProvisionStructuralRadioItem2 = new ACRadioButtonItem();

      serviceAddProvisionStructuralRadioItem2.setText("I�^");

      serviceAddProvisionStructuralRadioItem2.setGroup(getServiceAddProvisionStructuralRadioGroup());

      serviceAddProvisionStructuralRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

      addServiceAddProvisionStructuralRadioItem2();
    }
    return serviceAddProvisionStructuralRadioItem2;

  }

  /**
   * II�^���擾���܂��B
   * @return II�^
   */
  public ACRadioButtonItem getServiceAddProvisionStructuralRadioItem3(){
    if(serviceAddProvisionStructuralRadioItem3==null){

      serviceAddProvisionStructuralRadioItem3 = new ACRadioButtonItem();

      serviceAddProvisionStructuralRadioItem3.setText("II�^");

      serviceAddProvisionStructuralRadioItem3.setGroup(getServiceAddProvisionStructuralRadioGroup());

      serviceAddProvisionStructuralRadioItem3.setConstraints(VRLayout.FLOW);

      addServiceAddProvisionStructuralRadioItem3();
    }
    return serviceAddProvisionStructuralRadioItem3;

  }

  /**
   * III�^���擾���܂��B
   * @return III�^
   */
  public ACRadioButtonItem getServiceAddProvisionStructuralRadioItem4(){
    if(serviceAddProvisionStructuralRadioItem4==null){

      serviceAddProvisionStructuralRadioItem4 = new ACRadioButtonItem();

      serviceAddProvisionStructuralRadioItem4.setText("III�^");

      serviceAddProvisionStructuralRadioItem4.setGroup(getServiceAddProvisionStructuralRadioGroup());

      serviceAddProvisionStructuralRadioItem4.setConstraints(VRLayout.FLOW);

      addServiceAddProvisionStructuralRadioItem4();
    }
    return serviceAddProvisionStructuralRadioItem4;

  }

  /**
   * �����O��K��w�����Z���擾���܂��B
   * @return �����O��K��w�����Z
   */
  public ACValueArrayRadioButtonGroup getEnterHospitalPreConsultantRadio(){
    if(enterHospitalPreConsultantRadio==null){

      enterHospitalPreConsultantRadio = new ACValueArrayRadioButtonGroup();

      getEnterHospitalPreConsultantRadioContainer().setText("�����O��K��w�����Z");

      enterHospitalPreConsultantRadio.setBindPath("1520144");

      enterHospitalPreConsultantRadio.setUseClearButton(false);

      enterHospitalPreConsultantRadio.setModel(getEnterHospitalPreConsultantRadioModel());

      enterHospitalPreConsultantRadio.setValues(new int[]{1,2});

      addEnterHospitalPreConsultantRadio();
    }
    return enterHospitalPreConsultantRadio;

  }

  /**
   * �����O��K��w�����Z�R���e�i���擾���܂��B
   * @return �����O��K��w�����Z�R���e�i
   */
  protected ACLabelContainer getEnterHospitalPreConsultantRadioContainer(){
    if(enterHospitalPreConsultantRadioContainer==null){
      enterHospitalPreConsultantRadioContainer = new ACLabelContainer();
      enterHospitalPreConsultantRadioContainer.setFollowChildEnabled(true);
      enterHospitalPreConsultantRadioContainer.setVAlignment(VRLayout.CENTER);
      enterHospitalPreConsultantRadioContainer.add(getEnterHospitalPreConsultantRadio(), null);
    }
    return enterHospitalPreConsultantRadioContainer;
  }

  /**
   * �����O��K��w�����Z���f�����擾���܂��B
   * @return �����O��K��w�����Z���f��
   */
  protected ACListModelAdapter getEnterHospitalPreConsultantRadioModel(){
    if(enterHospitalPreConsultantRadioModel==null){
      enterHospitalPreConsultantRadioModel = new ACListModelAdapter();
      addEnterHospitalPreConsultantRadioModel();
    }
    return enterHospitalPreConsultantRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getEnterHospitalPreConsultantRadioItem1(){
    if(enterHospitalPreConsultantRadioItem1==null){

      enterHospitalPreConsultantRadioItem1 = new ACRadioButtonItem();

      enterHospitalPreConsultantRadioItem1.setText("�Ȃ�");

      enterHospitalPreConsultantRadioItem1.setGroup(getEnterHospitalPreConsultantRadio());

      enterHospitalPreConsultantRadioItem1.setConstraints(VRLayout.FLOW);

      addEnterHospitalPreConsultantRadioItem1();
    }
    return enterHospitalPreConsultantRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getEnterHospitalPreConsultantRadioItem2(){
    if(enterHospitalPreConsultantRadioItem2==null){

      enterHospitalPreConsultantRadioItem2 = new ACRadioButtonItem();

      enterHospitalPreConsultantRadioItem2.setText("����");

      enterHospitalPreConsultantRadioItem2.setGroup(getEnterHospitalPreConsultantRadio());

      enterHospitalPreConsultantRadioItem2.setConstraints(VRLayout.FLOW);

      addEnterHospitalPreConsultantRadioItem2();
    }
    return enterHospitalPreConsultantRadioItem2;

  }

  /**
   * ���莾���{�ݗ×{����擾���܂��B
   * @return ���莾���{�ݗ×{��
   */
  public ACValueArrayRadioButtonGroup getPneumoniaTreatmentRadio(){
    if(pneumoniaTreatmentRadio==null){

      pneumoniaTreatmentRadio = new ACValueArrayRadioButtonGroup();

      getPneumoniaTreatmentRadioContainer().setText("���莾���{�ݗ×{��");

      pneumoniaTreatmentRadio.setBindPath("1520145");

      pneumoniaTreatmentRadio.setUseClearButton(false);

      pneumoniaTreatmentRadio.setModel(getPneumoniaTreatmentRadioModel());

      pneumoniaTreatmentRadio.setValues(new int[]{1,2});

      addPneumoniaTreatmentRadio();
    }
    return pneumoniaTreatmentRadio;

  }

  /**
   * ���莾���{�ݗ×{��R���e�i���擾���܂��B
   * @return ���莾���{�ݗ×{��R���e�i
   */
  protected ACLabelContainer getPneumoniaTreatmentRadioContainer(){
    if(pneumoniaTreatmentRadioContainer==null){
      pneumoniaTreatmentRadioContainer = new ACLabelContainer();
      pneumoniaTreatmentRadioContainer.setFollowChildEnabled(true);
      pneumoniaTreatmentRadioContainer.setVAlignment(VRLayout.CENTER);
      pneumoniaTreatmentRadioContainer.add(getPneumoniaTreatmentRadio(), null);
    }
    return pneumoniaTreatmentRadioContainer;
  }

  /**
   * ���莾���{�ݗ×{��f�����擾���܂��B
   * @return ���莾���{�ݗ×{��f��
   */
  protected ACListModelAdapter getPneumoniaTreatmentRadioModel(){
    if(pneumoniaTreatmentRadioModel==null){
      pneumoniaTreatmentRadioModel = new ACListModelAdapter();
      addPneumoniaTreatmentRadioModel();
    }
    return pneumoniaTreatmentRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getPneumoniaTreatmentRadioItem1(){
    if(pneumoniaTreatmentRadioItem1==null){

      pneumoniaTreatmentRadioItem1 = new ACRadioButtonItem();

      pneumoniaTreatmentRadioItem1.setText("�Ȃ�");

      pneumoniaTreatmentRadioItem1.setGroup(getPneumoniaTreatmentRadio());

      pneumoniaTreatmentRadioItem1.setConstraints(VRLayout.FLOW);

      addPneumoniaTreatmentRadioItem1();
    }
    return pneumoniaTreatmentRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getPneumoniaTreatmentRadioItem2(){
    if(pneumoniaTreatmentRadioItem2==null){

      pneumoniaTreatmentRadioItem2 = new ACRadioButtonItem();

      pneumoniaTreatmentRadioItem2.setText("����");

      pneumoniaTreatmentRadioItem2.setGroup(getPneumoniaTreatmentRadio());

      pneumoniaTreatmentRadioItem2.setConstraints(VRLayout.FLOW);

      addPneumoniaTreatmentRadioItem2();
    }
    return pneumoniaTreatmentRadioItem2;

  }

  /**
   * �n��A�g�f�Ìv����񋟉��Z���擾���܂��B
   * @return �n��A�g�f�Ìv����񋟉��Z
   */
  public ACValueArrayRadioButtonGroup getLocalTreatmentPlanInfoAddRadio(){
    if(localTreatmentPlanInfoAddRadio==null){

      localTreatmentPlanInfoAddRadio = new ACValueArrayRadioButtonGroup();

      getLocalTreatmentPlanInfoAddRadioContainer().setText("�n��A�g�f�Ìv����񋟉��Z");

      localTreatmentPlanInfoAddRadio.setBindPath("1520147");

      localTreatmentPlanInfoAddRadio.setUseClearButton(false);

      localTreatmentPlanInfoAddRadio.setModel(getLocalTreatmentPlanInfoAddRadioModel());

      localTreatmentPlanInfoAddRadio.setValues(new int[]{1,2});

      addLocalTreatmentPlanInfoAddRadio();
    }
    return localTreatmentPlanInfoAddRadio;

  }

  /**
   * �n��A�g�f�Ìv����񋟉��Z�R���e�i���擾���܂��B
   * @return �n��A�g�f�Ìv����񋟉��Z�R���e�i
   */
  protected ACLabelContainer getLocalTreatmentPlanInfoAddRadioContainer(){
    if(localTreatmentPlanInfoAddRadioContainer==null){
      localTreatmentPlanInfoAddRadioContainer = new ACLabelContainer();
      localTreatmentPlanInfoAddRadioContainer.setFollowChildEnabled(true);
      localTreatmentPlanInfoAddRadioContainer.setVAlignment(VRLayout.CENTER);
      localTreatmentPlanInfoAddRadioContainer.add(getLocalTreatmentPlanInfoAddRadio(), null);
    }
    return localTreatmentPlanInfoAddRadioContainer;
  }

  /**
   * �n��A�g�f�Ìv����񋟉��Z���f�����擾���܂��B
   * @return �n��A�g�f�Ìv����񋟉��Z���f��
   */
  protected ACListModelAdapter getLocalTreatmentPlanInfoAddRadioModel(){
    if(localTreatmentPlanInfoAddRadioModel==null){
      localTreatmentPlanInfoAddRadioModel = new ACListModelAdapter();
      addLocalTreatmentPlanInfoAddRadioModel();
    }
    return localTreatmentPlanInfoAddRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getLocalTreatmentPlanInfoAddRadioItem1(){
    if(localTreatmentPlanInfoAddRadioItem1==null){

      localTreatmentPlanInfoAddRadioItem1 = new ACRadioButtonItem();

      localTreatmentPlanInfoAddRadioItem1.setText("�Ȃ�");

      localTreatmentPlanInfoAddRadioItem1.setGroup(getLocalTreatmentPlanInfoAddRadio());

      localTreatmentPlanInfoAddRadioItem1.setConstraints(VRLayout.FLOW);

      addLocalTreatmentPlanInfoAddRadioItem1();
    }
    return localTreatmentPlanInfoAddRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getLocalTreatmentPlanInfoAddRadioItem2(){
    if(localTreatmentPlanInfoAddRadioItem2==null){

      localTreatmentPlanInfoAddRadioItem2 = new ACRadioButtonItem();

      localTreatmentPlanInfoAddRadioItem2.setText("����");

      localTreatmentPlanInfoAddRadioItem2.setGroup(getLocalTreatmentPlanInfoAddRadio());

      localTreatmentPlanInfoAddRadioItem2.setConstraints(VRLayout.FLOW);

      addLocalTreatmentPlanInfoAddRadioItem2();
    }
    return localTreatmentPlanInfoAddRadioItem2;

  }

  /**
   * �Z��敪���擾���܂��B
   * @return �Z��敪
   */
  public ACValueArrayRadioButtonGroup getKaigoHealthCareOfTheAgedCalculationDivisionRadio(){
    if(kaigoHealthCareOfTheAgedCalculationDivisionRadio==null){

      kaigoHealthCareOfTheAgedCalculationDivisionRadio = new ACValueArrayRadioButtonGroup();

      getKaigoHealthCareOfTheAgedCalculationDivisionRadioContainer().setText("�Z��敪");

      kaigoHealthCareOfTheAgedCalculationDivisionRadio.setBindPath("9");

      kaigoHealthCareOfTheAgedCalculationDivisionRadio.setUseClearButton(false);

      kaigoHealthCareOfTheAgedCalculationDivisionRadio.setModel(getKaigoHealthCareOfTheAgedCalculationDivisionRadioModel());

      kaigoHealthCareOfTheAgedCalculationDivisionRadio.setValues(new int[]{1,2});

      addKaigoHealthCareOfTheAgedCalculationDivisionRadio();
    }
    return kaigoHealthCareOfTheAgedCalculationDivisionRadio;

  }

  /**
   * �Z��敪�R���e�i���擾���܂��B
   * @return �Z��敪�R���e�i
   */
  protected ACLabelContainer getKaigoHealthCareOfTheAgedCalculationDivisionRadioContainer(){
    if(kaigoHealthCareOfTheAgedCalculationDivisionRadioContainer==null){
      kaigoHealthCareOfTheAgedCalculationDivisionRadioContainer = new ACLabelContainer();
      kaigoHealthCareOfTheAgedCalculationDivisionRadioContainer.setFollowChildEnabled(true);
      kaigoHealthCareOfTheAgedCalculationDivisionRadioContainer.setVAlignment(VRLayout.CENTER);
      kaigoHealthCareOfTheAgedCalculationDivisionRadioContainer.add(getKaigoHealthCareOfTheAgedCalculationDivisionRadio(), null);
    }
    return kaigoHealthCareOfTheAgedCalculationDivisionRadioContainer;
  }

  /**
   * �Z��敪���f�����擾���܂��B
   * @return �Z��敪���f��
   */
  protected ACListModelAdapter getKaigoHealthCareOfTheAgedCalculationDivisionRadioModel(){
    if(kaigoHealthCareOfTheAgedCalculationDivisionRadioModel==null){
      kaigoHealthCareOfTheAgedCalculationDivisionRadioModel = new ACListModelAdapter();
      addKaigoHealthCareOfTheAgedCalculationDivisionRadioModel();
    }
    return kaigoHealthCareOfTheAgedCalculationDivisionRadioModel;
  }

  /**
   * �ʏ���擾���܂��B
   * @return �ʏ�
   */
  public ACRadioButtonItem getKaigoHealthCareOfTheAgedCalculationDivisionRadioItem1(){
    if(kaigoHealthCareOfTheAgedCalculationDivisionRadioItem1==null){

      kaigoHealthCareOfTheAgedCalculationDivisionRadioItem1 = new ACRadioButtonItem();

      kaigoHealthCareOfTheAgedCalculationDivisionRadioItem1.setText("�ʏ�");

      kaigoHealthCareOfTheAgedCalculationDivisionRadioItem1.setGroup(getKaigoHealthCareOfTheAgedCalculationDivisionRadio());

      kaigoHealthCareOfTheAgedCalculationDivisionRadioItem1.setConstraints(VRLayout.FLOW);

      addKaigoHealthCareOfTheAgedCalculationDivisionRadioItem1();
    }
    return kaigoHealthCareOfTheAgedCalculationDivisionRadioItem1;

  }

  /**
   * ���Z�݂̂��擾���܂��B
   * @return ���Z�̂�
   */
  public ACRadioButtonItem getKaigoHealthCareOfTheAgedCalculationDivisionRadioItem2(){
    if(kaigoHealthCareOfTheAgedCalculationDivisionRadioItem2==null){

      kaigoHealthCareOfTheAgedCalculationDivisionRadioItem2 = new ACRadioButtonItem();

      kaigoHealthCareOfTheAgedCalculationDivisionRadioItem2.setText("���Z�̂�");

      kaigoHealthCareOfTheAgedCalculationDivisionRadioItem2.setGroup(getKaigoHealthCareOfTheAgedCalculationDivisionRadio());

      kaigoHealthCareOfTheAgedCalculationDivisionRadioItem2.setConstraints(VRLayout.FLOW);

      addKaigoHealthCareOfTheAgedCalculationDivisionRadioItem2();
    }
    return kaigoHealthCareOfTheAgedCalculationDivisionRadioItem2;

  }

  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001_15211_201204Design() {

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
   * �^�u�y�C���ɓ������ڂ�ǉ����܂��B
   */
  protected void addTabs(){

    tabs.addTab("1", getTab1());

    tabs.addTab("2", getTab2());

    tabs.addTab("3", getTab3());

    tabs.addTab("4", getTab4());

    tabs.addTab("5", getTab5());

  }

  /**
   * �^�u1�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTab1(){

    tab1.add(getKaigoHealthCareOfTheAgedDivisionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getKaigoHealthCareOfTheAgedHospitalDivisionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getKaigoHealthCareOfTheAgedHospitalRoomContena(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getKaigoHealthCareOfTheAgedNightShiftSubtractionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getShortConcentrationRehabiliContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * �{�ݓ��̋敪�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoHealthCareOfTheAgedDivisionRadio(){

  }

  /**
   * �{�ݓ��̋敪���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoHealthCareOfTheAgedDivisionRadioModel(){

    getKaigoHealthCareOfTheAgedDivisionRadioItem1().setButtonIndex(1);

    getKaigoHealthCareOfTheAgedDivisionRadioModel().add(getKaigoHealthCareOfTheAgedDivisionRadioItem1());

    getKaigoHealthCareOfTheAgedDivisionRadioItem2().setButtonIndex(2);

    getKaigoHealthCareOfTheAgedDivisionRadioModel().add(getKaigoHealthCareOfTheAgedDivisionRadioItem2());

    getKaigoHealthCareOfTheAgedDivisionRadioItem3().setButtonIndex(3);

    getKaigoHealthCareOfTheAgedDivisionRadioModel().add(getKaigoHealthCareOfTheAgedDivisionRadioItem3());

    getKaigoHealthCareOfTheAgedDivisionRadioItem4().setButtonIndex(4);

    getKaigoHealthCareOfTheAgedDivisionRadioModel().add(getKaigoHealthCareOfTheAgedDivisionRadioItem4());

    getKaigoHealthCareOfTheAgedDivisionRadioItem5().setButtonIndex(5);

    getKaigoHealthCareOfTheAgedDivisionRadioModel().add(getKaigoHealthCareOfTheAgedDivisionRadioItem5());

    getKaigoHealthCareOfTheAgedDivisionRadioItem6().setButtonIndex(6);

    getKaigoHealthCareOfTheAgedDivisionRadioModel().add(getKaigoHealthCareOfTheAgedDivisionRadioItem6());

  }

  /**
   * ���V�l�ی��{�݁iI�j�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoHealthCareOfTheAgedDivisionRadioItem1(){

  }

  /**
   * ���j�b�g�^���V�l�ی��{�݁iI�j�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoHealthCareOfTheAgedDivisionRadioItem2(){

  }

  /**
   * ���V�l�ی��{�݁iII�j�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoHealthCareOfTheAgedDivisionRadioItem3(){

  }

  /**
   * ���j�b�g�^���V�l�ی��{�݁iII�j�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoHealthCareOfTheAgedDivisionRadioItem4(){

  }

  /**
   * ���V�l�ی��{�݁iIII�j�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoHealthCareOfTheAgedDivisionRadioItem5(){

  }

  /**
   * ���j�b�g�^���V�l�ی��{�݁iIII�j�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoHealthCareOfTheAgedDivisionRadioItem6(){

  }

  /**
   * �l���z�u�敪�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoHealthCareOfTheAgedHospitalDivisionContainer(){

    kaigoHealthCareOfTheAgedHospitalDivisionContainer.add(getKaigoHealthCareOfTheAgedHospitalDivision1(), VRLayout.FLOW_INSETLINE_RETURN);

    kaigoHealthCareOfTheAgedHospitalDivisionContainer.add(getKaigoHealthCareOfTheAgedHospitalDivision2(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * �l���z�u�敪�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoHealthCareOfTheAgedHospitalDivision1(){

  }

  /**
   * �l���z�u�敪���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoHealthCareOfTheAgedHospitalDivision1Model(){

    getKaigoHealthCareOfTheAgedHospitalDivision11().setButtonIndex(1);

    getKaigoHealthCareOfTheAgedHospitalDivision1Model().add(getKaigoHealthCareOfTheAgedHospitalDivision11());

    getKaigoHealthCareOfTheAgedHospitalDivision12().setButtonIndex(2);

    getKaigoHealthCareOfTheAgedHospitalDivision1Model().add(getKaigoHealthCareOfTheAgedHospitalDivision12());

  }

  /**
   * �]���^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoHealthCareOfTheAgedHospitalDivision11(){

  }

  /**
   * �ݑ���^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoHealthCareOfTheAgedHospitalDivision12(){

  }

  /**
   * �l���z�u�敪�i�×{�^�j�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoHealthCareOfTheAgedHospitalDivision2(){

  }

  /**
   * �l���z�u�敪�i�×{�^�j���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoHealthCareOfTheAgedHospitalDivision2Model(){

    getKaigoHealthCareOfTheAgedHospitalDivision21().setButtonIndex(1);

    getKaigoHealthCareOfTheAgedHospitalDivision2Model().add(getKaigoHealthCareOfTheAgedHospitalDivision21());

    getKaigoHealthCareOfTheAgedHospitalDivision22().setButtonIndex(2);

    getKaigoHealthCareOfTheAgedHospitalDivision2Model().add(getKaigoHealthCareOfTheAgedHospitalDivision22());

  }

  /**
   * �×{�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoHealthCareOfTheAgedHospitalDivision21(){

  }

  /**
   * �×{�����^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoHealthCareOfTheAgedHospitalDivision22(){

  }

  /**
   * �a���敪�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoHealthCareOfTheAgedHospitalRoomContena(){

    kaigoHealthCareOfTheAgedHospitalRoomContena.add(getKaigoHealthCareOfTheAgedHospitalRoomRadio(), VRLayout.FLOW_INSETLINE_RETURN);

    kaigoHealthCareOfTheAgedHospitalRoomContena.add(getKaigoHealthCareOfTheAgedUnitHospitalRoomRadio(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * �a���敪�i���ی��{�݁j�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoHealthCareOfTheAgedHospitalRoomRadio(){

  }

  /**
   * �a���敪�i���ی��{�݁j���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoHealthCareOfTheAgedHospitalRoomRadioModel(){

    getKaigoHealthCareOfTheAgedHospitalRoomRadioItem1().setButtonIndex(1);

    getKaigoHealthCareOfTheAgedHospitalRoomRadioModel().add(getKaigoHealthCareOfTheAgedHospitalRoomRadioItem1());

    getKaigoHealthCareOfTheAgedHospitalRoomRadioItem2().setButtonIndex(2);

    getKaigoHealthCareOfTheAgedHospitalRoomRadioModel().add(getKaigoHealthCareOfTheAgedHospitalRoomRadioItem2());

  }

  /**
   * �]���^���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoHealthCareOfTheAgedHospitalRoomRadioItem1(){

  }

  /**
   * �������ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoHealthCareOfTheAgedHospitalRoomRadioItem2(){

  }

  /**
   * �a���敪�i���j�b�g�^�j�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoHealthCareOfTheAgedUnitHospitalRoomRadio(){

  }

  /**
   * �a���敪�i���j�b�g�^�j���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoHealthCareOfTheAgedUnitHospitalRoomRadioModel(){

    getKaigoHealthCareOfTheAgedUnitHospitalRoomRadioItem1().setButtonIndex(1);

    getKaigoHealthCareOfTheAgedUnitHospitalRoomRadioModel().add(getKaigoHealthCareOfTheAgedUnitHospitalRoomRadioItem1());

    getKaigoHealthCareOfTheAgedUnitHospitalRoomRadioItem2().setButtonIndex(2);

    getKaigoHealthCareOfTheAgedUnitHospitalRoomRadioModel().add(getKaigoHealthCareOfTheAgedUnitHospitalRoomRadioItem2());

  }

  /**
   * ���j�b�g�^���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoHealthCareOfTheAgedUnitHospitalRoomRadioItem1(){

  }

  /**
   * ���j�b�g�^�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoHealthCareOfTheAgedUnitHospitalRoomRadioItem2(){

  }

  /**
   * ��ԋΖ�������ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoHealthCareOfTheAgedNightShiftSubtractionRadio(){

  }

  /**
   * ��ԋΖ���������f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoHealthCareOfTheAgedNightShiftSubtractionRadioModel(){

    getKaigoHealthCareOfTheAgedNightShiftSubtractionRadioItem1().setButtonIndex(1);

    getKaigoHealthCareOfTheAgedNightShiftSubtractionRadioModel().add(getKaigoHealthCareOfTheAgedNightShiftSubtractionRadioItem1());

    getKaigoHealthCareOfTheAgedNightShiftSubtractionRadioItem2().setButtonIndex(2);

    getKaigoHealthCareOfTheAgedNightShiftSubtractionRadioModel().add(getKaigoHealthCareOfTheAgedNightShiftSubtractionRadioItem2());

  }

  /**
   * ��^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoHealthCareOfTheAgedNightShiftSubtractionRadioItem1(){

  }

  /**
   * ���Z�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoHealthCareOfTheAgedNightShiftSubtractionRadioItem2(){

  }

  /**
   * �Z���W�����n�r�����Z�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortConcentrationRehabiliContainer(){

    shortConcentrationRehabiliContainer.add(getShortConcentrationRehabiliAddRadio(), VRLayout.FLOW_RETURN);

    shortConcentrationRehabiliContainer.add(getShortConcentrationRehabiliAddDementiaCheck(), VRLayout.FLOW);

  }

  /**
   * �Z���W�����n�r�����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortConcentrationRehabiliAddRadio(){

  }

  /**
   * �Z���W�����n�r�����Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortConcentrationRehabiliAddRadioModel(){

    getShortConcentrationRehabiliAddRadioItem1().setButtonIndex(1);

    getShortConcentrationRehabiliAddRadioModel().add(getShortConcentrationRehabiliAddRadioItem1());

    getShortConcentrationRehabiliAddRadioItem2().setButtonIndex(2);

    getShortConcentrationRehabiliAddRadioModel().add(getShortConcentrationRehabiliAddRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortConcentrationRehabiliAddRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortConcentrationRehabiliAddRadioItem2(){

  }

  /**
   * �F�m�Ǎ���҂ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortConcentrationRehabiliAddDementiaCheck(){

  }

  /**
   * �^�u2�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTab2(){

    tab2.add(getKaigoHealthCareOfTheAgedStayingOutOvernightCostRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getKaigoHealthCareOfTheAgedDefaultRadioContainer(), VRLayout.FLOW_INSETLINE);

    tab2.add(getKaigoHealthCareOfTheAgedEmergencyRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getKaigoHealthCareOfTheAgedNutritionRadioContainer(), VRLayout.FLOW_INSETLINE);

    tab2.add(getKaigoHealthCareOfTheAgedOralSwitchRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getOralMaintenanceAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getOralKeepStructureAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getOralKeepAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getKaigoHealthCareOfTheAgedRecuperateDinnerRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getSpecialMedicalExpense(), VRLayout.FLOW);

    tab2.add(getSpecialMedicalExpenseLabel(), VRLayout.FLOW_RETURN);

    tab2.add(getKaigoHealthCareOfTheAgedDinnerContainer(), VRLayout.FLOW_DOUBLEINSETLINE_RETURN);

  }

  /**
   * �O�������Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoHealthCareOfTheAgedStayingOutOvernightCostRadio(){

  }

  /**
   * �O�������Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoHealthCareOfTheAgedStayingOutOvernightCostRadioModel(){

    getKaigoHealthCareOfTheAgedStayingOutOvernightCostRadioItem1().setButtonIndex(1);

    getKaigoHealthCareOfTheAgedStayingOutOvernightCostRadioModel().add(getKaigoHealthCareOfTheAgedStayingOutOvernightCostRadioItem1());

    getKaigoHealthCareOfTheAgedStayingOutOvernightCostRadioItem2().setButtonIndex(2);

    getKaigoHealthCareOfTheAgedStayingOutOvernightCostRadioModel().add(getKaigoHealthCareOfTheAgedStayingOutOvernightCostRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoHealthCareOfTheAgedStayingOutOvernightCostRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoHealthCareOfTheAgedStayingOutOvernightCostRadioItem2(){

  }

  /**
   * �������Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoHealthCareOfTheAgedDefaultRadio(){

  }

  /**
   * �������Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoHealthCareOfTheAgedDefaultRadioModel(){

    getKaigoHealthCareOfTheAgedDefaultRadioItem1().setButtonIndex(1);

    getKaigoHealthCareOfTheAgedDefaultRadioModel().add(getKaigoHealthCareOfTheAgedDefaultRadioItem1());

    getKaigoHealthCareOfTheAgedDefaultRadioItem2().setButtonIndex(2);

    getKaigoHealthCareOfTheAgedDefaultRadioModel().add(getKaigoHealthCareOfTheAgedDefaultRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoHealthCareOfTheAgedDefaultRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoHealthCareOfTheAgedDefaultRadioItem2(){

  }

  /**
   * �ً}���{�ݗ×{��ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoHealthCareOfTheAgedEmergencyRadio(){

  }

  /**
   * �ً}���{�ݗ×{��f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoHealthCareOfTheAgedEmergencyRadioModel(){

    getKaigoHealthCareOfTheAgedEmergencyRadioItem1().setButtonIndex(1);

    getKaigoHealthCareOfTheAgedEmergencyRadioModel().add(getKaigoHealthCareOfTheAgedEmergencyRadioItem1());

    getKaigoHealthCareOfTheAgedEmergencyRadioItem2().setButtonIndex(2);

    getKaigoHealthCareOfTheAgedEmergencyRadioModel().add(getKaigoHealthCareOfTheAgedEmergencyRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoHealthCareOfTheAgedEmergencyRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoHealthCareOfTheAgedEmergencyRadioItem2(){

  }

  /**
   * �h�{�}�l�W�����g���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoHealthCareOfTheAgedNutritionRadio(){

  }

  /**
   * �h�{�}�l�W�����g���Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoHealthCareOfTheAgedNutritionRadioModel(){

    getKaigoHealthCareOfTheAgedNutritionRadioItem1().setButtonIndex(1);

    getKaigoHealthCareOfTheAgedNutritionRadioModel().add(getKaigoHealthCareOfTheAgedNutritionRadioItem1());

    getKaigoHealthCareOfTheAgedNutritionRadioItem2().setButtonIndex(2);

    getKaigoHealthCareOfTheAgedNutritionRadioModel().add(getKaigoHealthCareOfTheAgedNutritionRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoHealthCareOfTheAgedNutritionRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoHealthCareOfTheAgedNutritionRadioItem2(){

  }

  /**
   * �o���ڍs���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoHealthCareOfTheAgedOralSwitchRadio(){

  }

  /**
   * �o���ڍs���Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoHealthCareOfTheAgedOralSwitchRadioModel(){

    getKaigoHealthCareOfTheAgedOralSwitchRadioItem1().setButtonIndex(1);

    getKaigoHealthCareOfTheAgedOralSwitchRadioModel().add(getKaigoHealthCareOfTheAgedOralSwitchRadioItem1());

    getKaigoHealthCareOfTheAgedOralSwitchRadioItem2().setButtonIndex(2);

    getKaigoHealthCareOfTheAgedOralSwitchRadioModel().add(getKaigoHealthCareOfTheAgedOralSwitchRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoHealthCareOfTheAgedOralSwitchRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoHealthCareOfTheAgedOralSwitchRadioItem2(){

  }

  /**
   * �o���ێ����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addOralMaintenanceAddRadio(){

  }

  /**
   * �o���ێ����Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addOralMaintenanceAddRadioModel(){

    getOralMaintenanceAddRadioItem1().setButtonIndex(1);

    getOralMaintenanceAddRadioModel().add(getOralMaintenanceAddRadioItem1());

    getOralMaintenanceAddRadioItem2().setButtonIndex(2);

    getOralMaintenanceAddRadioModel().add(getOralMaintenanceAddRadioItem2());

    getOralMaintenanceAddRadioItem3().setButtonIndex(3);

    getOralMaintenanceAddRadioModel().add(getOralMaintenanceAddRadioItem3());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addOralMaintenanceAddRadioItem1(){

  }

  /**
   * I�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addOralMaintenanceAddRadioItem2(){

  }

  /**
   * II�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addOralMaintenanceAddRadioItem3(){

  }

  /**
   * ���o�@�\�ێ��Ǘ��̐����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addOralKeepStructureAddRadioGroup(){

  }

  /**
   * ���o�@�\�ێ��Ǘ��̐����Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addOralKeepStructureAddRadioGroupModel(){

    getOralKeepStructureAddRadioItem1().setButtonIndex(1);

    getOralKeepStructureAddRadioGroupModel().add(getOralKeepStructureAddRadioItem1());

    getOralKeepStructureAddRadioItem2().setButtonIndex(2);

    getOralKeepStructureAddRadioGroupModel().add(getOralKeepStructureAddRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addOralKeepStructureAddRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addOralKeepStructureAddRadioItem2(){

  }

  /**
   * ���o�@�\�ێ��Ǘ����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addOralKeepAddRadioGroup(){

  }

  /**
   * ���o�@�\�ێ��Ǘ����Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addOralKeepAddRadioGroupModel(){

    getOralKeepAddRadioItem1().setButtonIndex(1);

    getOralKeepAddRadioGroupModel().add(getOralKeepAddRadioItem1());

    getOralKeepAddRadioItem2().setButtonIndex(2);

    getOralKeepAddRadioGroupModel().add(getOralKeepAddRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addOralKeepAddRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addOralKeepAddRadioItem2(){

  }

  /**
   * �×{�H���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoHealthCareOfTheAgedRecuperateDinnerRadio(){

  }

  /**
   * �×{�H���Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoHealthCareOfTheAgedRecuperateDinnerRadioModel(){

    getKaigoHealthCareOfTheAgedRecuperateDinnerRadioItem1().setButtonIndex(1);

    getKaigoHealthCareOfTheAgedRecuperateDinnerRadioModel().add(getKaigoHealthCareOfTheAgedRecuperateDinnerRadioItem1());

    getKaigoHealthCareOfTheAgedRecuperateDinnerRadioItem2().setButtonIndex(2);

    getKaigoHealthCareOfTheAgedRecuperateDinnerRadioModel().add(getKaigoHealthCareOfTheAgedRecuperateDinnerRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoHealthCareOfTheAgedRecuperateDinnerRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoHealthCareOfTheAgedRecuperateDinnerRadioItem2(){

  }

  /**
   * ���ʗ×{��ɓ������ڂ�ǉ����܂��B
   */
  protected void addSpecialMedicalExpense(){

  }

  /**
   * ���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addSpecialMedicalExpenseLabel(){

  }

  /**
   * �H���R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoHealthCareOfTheAgedDinnerContainer(){

    kaigoHealthCareOfTheAgedDinnerContainer.add(getKaigoHealthCareOfTheAgedDinnerOfferContainer(), VRLayout.FLOW);

    kaigoHealthCareOfTheAgedDinnerContainer.add(getKaigoHealthCareOfTheAgedDinnerCostContainer(), VRLayout.FLOW);

  }

  /**
   * �H���񋟂ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoHealthCareOfTheAgedDinnerOffer(){

  }

  /**
   * �H���񋟃��f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoHealthCareOfTheAgedDinnerOfferModel(){

  }

  /**
   * �H����p�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoHealthCareOfTheAgedDinnerCost(){

  }

  /**
   * �^�u3�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTab3(){

    tab3.add(getKaigoHealthCareOfTheAgedStaffSubtractionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab3.add(getUnitCareMaintenanceRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab3.add(getRecuperationRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab3.add(getNightStaffDispositionAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab3.add(getIntentionCommunicationDifficultyAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab3.add(getDementiaProfessionalCareAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab3.add(getYoungDementiaPatinetAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab3.add(getDementiainfoAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab3.add(getDementiaEmergencyAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab3.add(getBodyRestraintAbolitionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * �E�����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoHealthCareOfTheAgedStaffSubtraction(){

  }

  /**
   * �E�����Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoHealthCareOfTheAgedStaffSubtractionModel(){

    getKaigoHealthCareOfTheAgedStaffSubtractionCapacityNot().setButtonIndex(1);

    getKaigoHealthCareOfTheAgedStaffSubtractionModel().add(getKaigoHealthCareOfTheAgedStaffSubtractionCapacityNot());

    getKaigoHealthCareOfTheAgedStaffSubtractionCapacityExcess().setButtonIndex(2);

    getKaigoHealthCareOfTheAgedStaffSubtractionModel().add(getKaigoHealthCareOfTheAgedStaffSubtractionCapacityExcess());

    getKaigoHealthCareOfTheAgedStaffSubtractionPersonLack().setButtonIndex(3);

    getKaigoHealthCareOfTheAgedStaffSubtractionModel().add(getKaigoHealthCareOfTheAgedStaffSubtractionPersonLack());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoHealthCareOfTheAgedStaffSubtractionCapacityNot(){

  }

  /**
   * ������߂ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoHealthCareOfTheAgedStaffSubtractionCapacityExcess(){

  }

  /**
   * �Ō�E���E�����͈�t�APT�EOT�EST�A���x�������̕s���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoHealthCareOfTheAgedStaffSubtractionPersonLack(){

  }

  /**
   * ���j�b�g�P�A�̐����ɓ������ڂ�ǉ����܂��B
   */
  protected void addUnitCareMaintenanceRadio(){

  }

  /**
   * ���j�b�g�P�A�̐������f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addUnitCareMaintenanceRadioModel(){

    getUnitCareMaintenanceRadioItem1().setButtonIndex(1);

    getUnitCareMaintenanceRadioModel().add(getUnitCareMaintenanceRadioItem1());

    getUnitCareMaintenanceRadioItem2().setButtonIndex(2);

    getUnitCareMaintenanceRadioModel().add(getUnitCareMaintenanceRadioItem2());

  }

  /**
   * �������ɓ������ڂ�ǉ����܂��B
   */
  protected void addUnitCareMaintenanceRadioItem1(){

  }

  /**
   * �����ɓ������ڂ�ǉ����܂��B
   */
  protected void addUnitCareMaintenanceRadioItem2(){

  }

  /**
   * �×{�̐��ێ����ʉ��Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addRecuperationRadio(){

  }

  /**
   * �×{�̐��ێ����ʉ��Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addRecuperationRadioModel(){

    getRecuperationRadioItem1().setButtonIndex(1);

    getRecuperationRadioModel().add(getRecuperationRadioItem1());

    getRecuperationRadioItem2().setButtonIndex(2);

    getRecuperationRadioModel().add(getRecuperationRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addRecuperationRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addRecuperationRadioItem2(){

  }

  /**
   * ��ΐE���z�u���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addNightStaffDispositionAddRadioGroup(){

  }

  /**
   * ��ΐE���z�u���Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addNightStaffDispositionAddRadioGroupModel(){

    getNightStaffDispositionAddRadioItem1().setButtonIndex(1);

    getNightStaffDispositionAddRadioGroupModel().add(getNightStaffDispositionAddRadioItem1());

    getNightStaffDispositionAddRadioItem2().setButtonIndex(2);

    getNightStaffDispositionAddRadioGroupModel().add(getNightStaffDispositionAddRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addNightStaffDispositionAddRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addNightStaffDispositionAddRadioItem2(){

  }

  /**
   * �F�m�ǃP�A���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addIntentionCommunicationDifficultyAddRadio(){

  }

  /**
   * �F�m�ǃP�A���Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addIntentionCommunicationDifficultyAddRadioModel(){

    getIntentionCommunicationDifficultyAddRadioItem1().setButtonIndex(1);

    getIntentionCommunicationDifficultyAddRadioModel().add(getIntentionCommunicationDifficultyAddRadioItem1());

    getIntentionCommunicationDifficultyAddRadioItem2().setButtonIndex(2);

    getIntentionCommunicationDifficultyAddRadioModel().add(getIntentionCommunicationDifficultyAddRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addIntentionCommunicationDifficultyAddRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addIntentionCommunicationDifficultyAddRadioItem2(){

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
   * I�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addDementiaProfessionalCareAddRadioItem2(){

  }

  /**
   * II�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addDementiaProfessionalCareAddRadioItem3(){

  }

  /**
   * ��N���F�m�Ǔ����Ҏ�����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addYoungDementiaPatinetAddRadioGroup(){

  }

  /**
   * ��N���F�m�Ǔ����Ҏ�����Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addYoungDementiaPatinetAddRadioGroupModel(){

    getYoungDementiaPatinetAddRadioItem1().setButtonIndex(1);

    getYoungDementiaPatinetAddRadioGroupModel().add(getYoungDementiaPatinetAddRadioItem1());

    getYoungDementiaPatinetAddRadioItem2().setButtonIndex(2);

    getYoungDementiaPatinetAddRadioGroupModel().add(getYoungDementiaPatinetAddRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addYoungDementiaPatinetAddRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addYoungDementiaPatinetAddRadioItem2(){

  }

  /**
   * �F�m�Ǐ��񋟉��Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addDementiainfoAddRadioGroup(){

  }

  /**
   * �F�m�Ǐ��񋟉��Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addDementiainfoAddRadioGroupModel(){

    getDementiainfoAddRadioItem1().setButtonIndex(1);

    getDementiainfoAddRadioGroupModel().add(getDementiainfoAddRadioItem1());

    getDementiainfoAddRadioItem2().setButtonIndex(2);

    getDementiainfoAddRadioGroupModel().add(getDementiainfoAddRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addDementiainfoAddRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addDementiainfoAddRadioItem2(){

  }

  /**
   * �F�m�Ǎs���E�S���Ǐ�ً}�Ή����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addDementiaEmergencyAddRadioGroup(){

  }

  /**
   * �F�m�Ǎs���E�S���Ǐ�ً}�Ή����Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addDementiaEmergencyAddRadioGroupModel(){

    getDementiaEmergencyAddRadioItem1().setButtonIndex(1);

    getDementiaEmergencyAddRadioGroupModel().add(getDementiaEmergencyAddRadioItem1());

    getDementiaEmergencyAddRadioItem2().setButtonIndex(2);

    getDementiaEmergencyAddRadioGroupModel().add(getDementiaEmergencyAddRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addDementiaEmergencyAddRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addDementiaEmergencyAddRadioItem2(){

  }

  /**
   * �g�̍S���p�~�����{���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addBodyRestraintAbolitionRadio(){

  }

  /**
   * �g�̍S���p�~�����{���Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addBodyRestraintAbolitionRadioModel(){

    getBodyRestraintAbolitionRadioItem1().setButtonIndex(1);

    getBodyRestraintAbolitionRadioModel().add(getBodyRestraintAbolitionRadioItem1());

    getBodyRestraintAbolitionRadioItem2().setButtonIndex(2);

    getBodyRestraintAbolitionRadioModel().add(getBodyRestraintAbolitionRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addBodyRestraintAbolitionRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addBodyRestraintAbolitionRadioItem2(){

  }

  /**
   * �^�u4�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTab4(){

    tab4.add(getKaigoHealthCareOfTheAgedHijoAddition(), VRLayout.FLOW_INSETLINE_RETURN);

    tab4.add(getStayReturnSupportRyoyoAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab4.add(getStayReturnSupportAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab4.add(getTerminalRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab4.add(getTerminalDaysContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * �ޏ��֘A���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoHealthCareOfTheAgedHijoAddition(){

    kaigoHealthCareOfTheAgedHijoAddition.add(getLeavingHospitalPreConsultationAddition(), VRLayout.FLOW_RETURN);

    kaigoHealthCareOfTheAgedHijoAddition.add(getLeavingHospitalAfterConsultationAddition(), VRLayout.FLOW_RETURN);

    kaigoHealthCareOfTheAgedHijoAddition.add(getLeavingHospitalConsultationAddition(), VRLayout.FLOW_RETURN);

    kaigoHealthCareOfTheAgedHijoAddition.add(getLeavingHospitalDissemination(), VRLayout.FLOW_RETURN);

    kaigoHealthCareOfTheAgedHijoAddition.add(getLeavingHospitalCooperationAddition(), VRLayout.FLOW_RETURN);

    kaigoHealthCareOfTheAgedHijoAddition.add(getLeavingHospital(), VRLayout.FLOW_RETURN);

  }

  /**
   * �ޏ�(�@)�O�K��w�����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addLeavingHospitalPreConsultationAddition(){

  }

  /**
   * �ޏ�(�@)��K��w�����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addLeavingHospitalAfterConsultationAddition(){

  }

  /**
   * �ޏ�(�@)���w�����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addLeavingHospitalConsultationAddition(){

  }

  /**
   * �ޏ�(�@)�����񋟉��Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addLeavingHospitalDissemination(){

  }

  /**
   * �ޏ�(�@)�O�A�g���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addLeavingHospitalCooperationAddition(){

  }

  /**
   * �V�l�K��Ō�w�����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addLeavingHospital(){

  }

  /**
   * �ݑ�A�ݑ�×{�x�����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addStayReturnSupportRyoyoAddRadio(){

  }

  /**
   * �ݑ�A�ݑ�×{�x�����Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addStayReturnSupportRyoyoAddRadioModel(){

    getStayReturnSupportRyoyoAddRadioItem1().setButtonIndex(1);

    getStayReturnSupportRyoyoAddRadioModel().add(getStayReturnSupportRyoyoAddRadioItem1());

    getStayReturnSupportRyoyoAddRadioItem2().setButtonIndex(2);

    getStayReturnSupportRyoyoAddRadioModel().add(getStayReturnSupportRyoyoAddRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addStayReturnSupportRyoyoAddRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addStayReturnSupportRyoyoAddRadioItem2(){

  }

  /**
   * �ݑ�A�x���@�\���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addStayReturnSupportAddRadio(){

  }

  /**
   * �ݑ�A�x���@�\���Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addStayReturnSupportAddRadioModel(){

    getStayReturnSupportAddRadioItem1().setButtonIndex(1);

    getStayReturnSupportAddRadioModel().add(getStayReturnSupportAddRadioItem1());

    getStayReturnSupportAddRadioItem2().setButtonIndex(2);

    getStayReturnSupportAddRadioModel().add(getStayReturnSupportAddRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addStayReturnSupportAddRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addStayReturnSupportAddRadioItem2(){

  }

  /**
   * �^�[�~�i���P�A���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTerminalRadio(){

  }

  /**
   * �^�[�~�i���P�A���Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addTerminalRadioModel(){

    getTerminalRadioItem1().setButtonIndex(1);

    getTerminalRadioModel().add(getTerminalRadioItem1());

    getTerminalRadioItem2().setButtonIndex(2);

    getTerminalRadioModel().add(getTerminalRadioItem2());

    getTerminalRadioItem3().setButtonIndex(3);

    getTerminalRadioModel().add(getTerminalRadioItem3());

    getTerminalRadioItem4().setButtonIndex(4);

    getTerminalRadioModel().add(getTerminalRadioItem4());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addTerminalRadioItem1(){

  }

  /**
   * ���S���ȑO4���ȏ�30���ȉ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addTerminalRadioItem2(){

  }

  /**
   * ���S���ȑO2������3���ɓ������ڂ�ǉ����܂��B
   */
  protected void addTerminalRadioItem3(){

  }

  /**
   * ���S���ɓ������ڂ�ǉ����܂��B
   */
  protected void addTerminalRadioItem4(){

  }

  /**
   * �^�[�~�i���P�A���Z�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTerminalDaysContainer(){

    terminalDaysContainer.add(getTerminalDays(), VRLayout.FLOW);

    terminalDaysContainer.add(getTerminalDaysUnit(), VRLayout.FLOW);

  }

  /**
   * �^�[�~�i���P�A���Z�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addTerminalDays(){

  }

  /**
   * �^�[�~�i���P�A���Z�����P�ʂɓ������ڂ�ǉ����܂��B
   */
  protected void addTerminalDaysUnit(){

  }

  /**
   * �^�u5�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTab5(){

    tab5.add(getServiceAddProvisionStructuralRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab5.add(getEnterHospitalPreConsultantRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab5.add(getPneumoniaTreatmentRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab5.add(getLocalTreatmentPlanInfoAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab5.add(getKaigoHealthCareOfTheAgedCalculationDivisionRadioContainer(), VRLayout.FLOW_INSETLINE);

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

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceAddProvisionStructuralRadioItem1(){

  }

  /**
   * I�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceAddProvisionStructuralRadioItem2(){

  }

  /**
   * II�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceAddProvisionStructuralRadioItem3(){

  }

  /**
   * III�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceAddProvisionStructuralRadioItem4(){

  }

  /**
   * �����O��K��w�����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addEnterHospitalPreConsultantRadio(){

  }

  /**
   * �����O��K��w�����Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addEnterHospitalPreConsultantRadioModel(){

    getEnterHospitalPreConsultantRadioItem1().setButtonIndex(1);

    getEnterHospitalPreConsultantRadioModel().add(getEnterHospitalPreConsultantRadioItem1());

    getEnterHospitalPreConsultantRadioItem2().setButtonIndex(2);

    getEnterHospitalPreConsultantRadioModel().add(getEnterHospitalPreConsultantRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addEnterHospitalPreConsultantRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addEnterHospitalPreConsultantRadioItem2(){

  }

  /**
   * ���莾���{�ݗ×{��ɓ������ڂ�ǉ����܂��B
   */
  protected void addPneumoniaTreatmentRadio(){

  }

  /**
   * ���莾���{�ݗ×{��f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addPneumoniaTreatmentRadioModel(){

    getPneumoniaTreatmentRadioItem1().setButtonIndex(1);

    getPneumoniaTreatmentRadioModel().add(getPneumoniaTreatmentRadioItem1());

    getPneumoniaTreatmentRadioItem2().setButtonIndex(2);

    getPneumoniaTreatmentRadioModel().add(getPneumoniaTreatmentRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addPneumoniaTreatmentRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addPneumoniaTreatmentRadioItem2(){

  }

  /**
   * �n��A�g�f�Ìv����񋟉��Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addLocalTreatmentPlanInfoAddRadio(){

  }

  /**
   * �n��A�g�f�Ìv����񋟉��Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addLocalTreatmentPlanInfoAddRadioModel(){

    getLocalTreatmentPlanInfoAddRadioItem1().setButtonIndex(1);

    getLocalTreatmentPlanInfoAddRadioModel().add(getLocalTreatmentPlanInfoAddRadioItem1());

    getLocalTreatmentPlanInfoAddRadioItem2().setButtonIndex(2);

    getLocalTreatmentPlanInfoAddRadioModel().add(getLocalTreatmentPlanInfoAddRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addLocalTreatmentPlanInfoAddRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addLocalTreatmentPlanInfoAddRadioItem2(){

  }

  /**
   * �Z��敪�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoHealthCareOfTheAgedCalculationDivisionRadio(){

  }

  /**
   * �Z��敪���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoHealthCareOfTheAgedCalculationDivisionRadioModel(){

    getKaigoHealthCareOfTheAgedCalculationDivisionRadioItem1().setButtonIndex(1);

    getKaigoHealthCareOfTheAgedCalculationDivisionRadioModel().add(getKaigoHealthCareOfTheAgedCalculationDivisionRadioItem1());

    getKaigoHealthCareOfTheAgedCalculationDivisionRadioItem2().setButtonIndex(2);

    getKaigoHealthCareOfTheAgedCalculationDivisionRadioModel().add(getKaigoHealthCareOfTheAgedCalculationDivisionRadioItem2());

  }

  /**
   * �ʏ�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoHealthCareOfTheAgedCalculationDivisionRadioItem1(){

  }

  /**
   * ���Z�݂̂ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoHealthCareOfTheAgedCalculationDivisionRadioItem2(){

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
      ACFrame.debugStart(new ACAffairInfo(QS001_15211_201204Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QS001_15211_201204Design getThis() {
    return this;
  }
}
