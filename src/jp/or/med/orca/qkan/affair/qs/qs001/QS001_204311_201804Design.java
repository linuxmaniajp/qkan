
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
 * �J����: �����@���̂�
 * �쐬��: 2018/02/17  ���{�R���s���[�^�[������� �����@���̂� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �T�[�r�X�\��쐬/�ύX (S)
 * �v���Z�X �T�[�r�X�\��T�� (001)
 * �v���O���� �T�[�r�X�p�^�[���Z�������×{���i����É@�j (QS001_204311_201804)
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
 * �T�[�r�X�p�^�[���Z�������×{���i����É@�j��ʍ��ڃf�U�C��(QS001_204311_201804) 
 */
public class QS001_204311_201804Design extends QS001ServicePanel {
  //GUI�R���|�[�l���g

  private JTabbedPane tabs;

  private ACPanel tab1;

  private ACValueArrayRadioButtonGroup shortStayHospitalRecuperationInstitutionDivisionRadio;

  private ACLabelContainer shortStayHospitalRecuperationInstitutionDivisionRadioContainer;

  private ACListModelAdapter shortStayHospitalRecuperationInstitutionDivisionRadioModel;

  private ACRadioButtonItem shortStayHospitalRecuperationInstitutionDivisionRadioItem1;

  private ACRadioButtonItem shortStayHospitalRecuperationInstitutionDivisionRadioItem2;

  private ACRadioButtonItem shortStayHospitalRecuperationInstitutionDivisionRadioItem3;

  private ACRadioButtonItem shortStayHospitalRecuperationInstitutionDivisionRadioItem4;

  private ACRadioButtonItem shortStayHospitalRecuperationInstitutionDivisionRadioItem5;

  private ACRadioButtonItem shortStayHospitalRecuperationInstitutionDivisionRadioItem6;

  private ACLabelContainer staffAssignmentDivisionContainer;

  private ACValueArrayRadioButtonGroup staffAssignment1Division;

  private ACListModelAdapter staffAssignment1DivisionModel;

  private ACRadioButtonItem staffAssignmentDivisionItem1;

  private ACRadioButtonItem staffAssignmentDivisionItem2;

  private ACRadioButtonItem staffAssignmentDivisionItem3;

  private ACValueArrayRadioButtonGroup staffAssignment2Division;

  private ACListModelAdapter staffAssignment2DivisionModel;

  private ACRadioButtonItem staffAssignmentDivisionItem4;

  private ACRadioButtonItem staffAssignmentDivisionItem5;

  private ACRadioButtonItem staffAssignmentDivisionItem6;

  private ACValueArrayRadioButtonGroup staffAssignment3Division;

  private ACListModelAdapter staffAssignment3DivisionModel;

  private ACRadioButtonItem staffAssignmentDivisionItem7;

  private ACRadioButtonItem staffAssignmentDivisionItem8;

  private ACLabelContainer shortStayHospitalRecuperationHospitalRoomContena;

  private ACValueArrayRadioButtonGroup shortStayHospitalRecuperationHospitalRoomRadio;

  private ACListModelAdapter shortStayHospitalRecuperationHospitalRoomRadioModel;

  private ACRadioButtonItem shortStayHospitalRecuperationHospitalRoomRadioItem1;

  private ACRadioButtonItem shortStayHospitalRecuperationHospitalRoomRadioItem2;

  private ACValueArrayRadioButtonGroup shortStayHospitalRecuperationUnitHospitalRoomRadio;

  private ACListModelAdapter shortStayHospitalRecuperationUnitHospitalRoomRadioModel;

  private ACRadioButtonItem shortStayHospitalRecuperationUnitHospitalRoomRadioItem1;

  private ACRadioButtonItem shortStayHospitalRecuperationUnitHospitalRoomRadioItem2;

  private ACPanel tab2;

  private ACValueArrayRadioButtonGroup shortStayHospitalRecuperationUnitCareMaintenanceRadio;

  private ACLabelContainer shortStayHospitalRecuperationUnitCareMaintenanceRadioContainer;

  private ACListModelAdapter shortStayHospitalRecuperationUnitCareMaintenanceRadioModel;

  private ACRadioButtonItem shortStayHospitalRecuperationUnitCareMaintenanceRadioItem1;

  private ACRadioButtonItem shortStayHospitalRecuperationUnitCareMaintenanceRadioItem2;

  private ACValueArrayRadioButtonGroup shortStayHospitalRecuperationAdditionType;

  private ACLabelContainer shortStayHospitalRecuperationAdditionTypeContainer;

  private ACListModelAdapter shortStayHospitalRecuperationAdditionTypeModel;

  private ACRadioButtonItem shortStayHospitalRecuperationAdditionType1;

  private ACRadioButtonItem shortStayHospitalRecuperationAdditionType2;

  private ACRadioButtonItem shortStayHospitalRecuperationAdditionType3;

  private ACRadioButtonItem shortStayHospitalRecuperationAdditionType4;

  private ACRadioButtonItem shortStayHospitalRecuperationAdditionType5;

  private ACValueArrayRadioButtonGroup environmentalCorridorRadio;

  private ACLabelContainer environmentalCorridorRadioContainer;

  private ACListModelAdapter environmentalCorridorRadioModel;

  private ACRadioButtonItem environmentalCorridorRadioItem1;

  private ACRadioButtonItem environmentalCorridorRadioItem2;

  private ACValueArrayRadioButtonGroup environmentalRecuperationRoomRadio;

  private ACLabelContainer environmentalRecuperationRoomRadioContainer;

  private ACListModelAdapter environmentalRecuperationRoomRadioModel;

  private ACRadioButtonItem environmentalRecuperationRoomRadioItem1;

  private ACRadioButtonItem environmentalRecuperationRoomRadioItem2;

  private ACValueArrayRadioButtonGroup shortStayHospitalRecuperationType;

  private ACLabelContainer shortStayHospitalRecuperationTypeContainer;

  private ACListModelAdapter shortStayHospitalRecuperationTypeModel;

  private ACRadioButtonItem shortStayHospitalRecuperationTypeNormal;

  private ACRadioButtonItem shortStayHospitalRecuperationTypeNone;

  private ACValueArrayRadioButtonGroup medicalFacilityHospitalSubstraction;

  private ACLabelContainer medicalFacilityHospitalSubstractionContainer;

  private ACListModelAdapter medicalFacilityHospitalSubstractionModel;

  private ACRadioButtonItem medicalFacilityHospitalSubstractionItem1;

  private ACRadioButtonItem medicalFacilityHospitalSubstractionItem2;

  private ACRadioButtonItem medicalFacilityHospitalSubstractionItem3;

  private ACRadioButtonItem medicalFacilityHospitalSubstractionItem4;

  private ACPanel tab3;

  private ACValueArrayRadioButtonGroup dementiaActionAddRadioGroup;

  private ACLabelContainer dementiaActionAddRadioGroupContainer;

  private ACListModelAdapter dementiaActionAddRadioGroupModel;

  private ACRadioButtonItem dementiaActionAddRadioItem1;

  private ACRadioButtonItem dementiaActionAddRadioItem2;

  private ACValueArrayRadioButtonGroup youngDementiaPatinetAddRadioGroup;

  private ACLabelContainer youngDementiaPatinetAddRadioGroupContainer;

  private ACListModelAdapter youngDementiaPatinetAddRadioGroupModel;

  private ACRadioButtonItem youngDementiaPatinetAddRadioItem1;

  private ACRadioButtonItem youngDementiaPatinetAddRadioItem2;

  private ACValueArrayRadioButtonGroup shortStayHospitalRecuperationMeetingAndSendingOff;

  private ACLabelContainer shortStayHospitalRecuperationMeetingAndSendingOffContainer;

  private ACListModelAdapter shortStayHospitalRecuperationMeetingAndSendingOffModel;

  private ACRadioButtonItem shortStayHospitalRecuperationMeetingAndSendingOffNone;

  private ACRadioButtonItem shortStayHospitalRecuperationMeetingAndSendingOffOneWay;

  private ACRadioButtonItem shortStayHospitalRecuperationMeetingAndSendingOffRoundTrip;

  private ACValueArrayRadioButtonGroup shortStayHospitalRecuperationMedicalExpensesRadio;

  private ACLabelContainer shortStayHospitalRecuperationMedicalExpensesRadioContainer;

  private ACListModelAdapter shortStayHospitalRecuperationMedicalExpensesRadioModel;

  private ACRadioButtonItem shortStayHospitalRecuperationMedicalExpensesRadioItem1;

  private ACRadioButtonItem shortStayHospitalRecuperationMedicalExpensesRadioItem2;

  private ACRadioButtonItem shortStayHospitalRecuperationMedicalExpensesRadioItem3;

  private ACRadioButtonItem shortStayHospitalRecuperationMedicalExpensesRadioItem4;

  private ACValueArrayRadioButtonGroup emergencyTreatmentManagementRadio;

  private ACLabelContainer emergencyTreatmentManagementRadioContainer;

  private ACListModelAdapter emergencyTreatmentManagementRadioModel;

  private ACRadioButtonItem emergencyTreatmentManagementItem1;

  private ACRadioButtonItem emergencyTreatmentManagementItem2;

  private ACValueArrayRadioButtonGroup dementiaProfessionalCareAddRadioGroup;

  private ACLabelContainer dementiaProfessionalCareAddRadioGroupContainer;

  private ACListModelAdapter dementiaProfessionalCareAddRadioGroupModel;

  private ACRadioButtonItem dementiaProfessionalCareAddRadioItem1;

  private ACRadioButtonItem dementiaProfessionalCareAddRadioItem2;

  private ACRadioButtonItem dementiaProfessionalCareAddRadioItem3;

  private ACPanel tab4;

  private ACMapBindButton shortStayHospitalRecuperationSpecificConsultationFee;

  private ACLabel shortStayHospitalRecuperationSpecificConsultationFeeOutline;

  private ACValueArrayRadioButtonGroup serviceAddProvisionStructuralRadioGroup;

  private ACLabelContainer serviceAddProvisionStructuralRadioGroupContainer;

  private ACListModelAdapter serviceAddProvisionStructuralRadioGroupModel;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem1;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem5;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem2;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem3;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem4;

  private ACBackLabelContainer shortStayRecuperationHealthFacilityDinnerContainer;

  private ACComboBox shortStayRecuperationHealthFacilityDinnerOffer;

  private ACLabelContainer shortStayRecuperationHealthFacilityDinnerOfferContainer;

  private ACComboBoxModelAdapter shortStayRecuperationHealthFacilityDinnerOfferModel;

  private ACTextField shortStayRecuperationHealthFacilityDinnerCost;

  private ACLabelContainer shortStayRecuperationHealthFacilityDinnerCostContainer;

  private ACIntegerCheckBox shortStayHospitalRecuperationEtc30Over;

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
  public ACValueArrayRadioButtonGroup getShortStayHospitalRecuperationInstitutionDivisionRadio(){
    if(shortStayHospitalRecuperationInstitutionDivisionRadio==null){

      shortStayHospitalRecuperationInstitutionDivisionRadio = new ACValueArrayRadioButtonGroup();

      getShortStayHospitalRecuperationInstitutionDivisionRadioContainer().setText("�{�ݓ��̋敪");

      shortStayHospitalRecuperationInstitutionDivisionRadio.setBindPath("20430101");

      shortStayHospitalRecuperationInstitutionDivisionRadio.setNoSelectIndex(0);

      shortStayHospitalRecuperationInstitutionDivisionRadio.setUseClearButton(false);

      shortStayHospitalRecuperationInstitutionDivisionRadio.setModel(getShortStayHospitalRecuperationInstitutionDivisionRadioModel());

      shortStayHospitalRecuperationInstitutionDivisionRadio.setValues(new int[]{1,2,3,4,5,6});

      addShortStayHospitalRecuperationInstitutionDivisionRadio();
    }
    return shortStayHospitalRecuperationInstitutionDivisionRadio;

  }

  /**
   * �{�ݓ��̋敪�R���e�i���擾���܂��B
   * @return �{�ݓ��̋敪�R���e�i
   */
  protected ACLabelContainer getShortStayHospitalRecuperationInstitutionDivisionRadioContainer(){
    if(shortStayHospitalRecuperationInstitutionDivisionRadioContainer==null){
      shortStayHospitalRecuperationInstitutionDivisionRadioContainer = new ACLabelContainer();
      shortStayHospitalRecuperationInstitutionDivisionRadioContainer.setFollowChildEnabled(true);
      shortStayHospitalRecuperationInstitutionDivisionRadioContainer.setVAlignment(VRLayout.CENTER);
      shortStayHospitalRecuperationInstitutionDivisionRadioContainer.add(getShortStayHospitalRecuperationInstitutionDivisionRadio(), null);
    }
    return shortStayHospitalRecuperationInstitutionDivisionRadioContainer;
  }

  /**
   * �{�ݓ��̋敪���f�����擾���܂��B
   * @return �{�ݓ��̋敪���f��
   */
  protected ACListModelAdapter getShortStayHospitalRecuperationInstitutionDivisionRadioModel(){
    if(shortStayHospitalRecuperationInstitutionDivisionRadioModel==null){
      shortStayHospitalRecuperationInstitutionDivisionRadioModel = new ACListModelAdapter();
      addShortStayHospitalRecuperationInstitutionDivisionRadioModel();
    }
    return shortStayHospitalRecuperationInstitutionDivisionRadioModel;
  }

  /**
   * I�^����É@���擾���܂��B
   * @return I�^����É@
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationInstitutionDivisionRadioItem1(){
    if(shortStayHospitalRecuperationInstitutionDivisionRadioItem1==null){

      shortStayHospitalRecuperationInstitutionDivisionRadioItem1 = new ACRadioButtonItem();

      shortStayHospitalRecuperationInstitutionDivisionRadioItem1.setText("I�^����É@");

      shortStayHospitalRecuperationInstitutionDivisionRadioItem1.setGroup(getShortStayHospitalRecuperationInstitutionDivisionRadio());

      shortStayHospitalRecuperationInstitutionDivisionRadioItem1.setConstraints(VRLayout.FLOW_RETURN);

      addShortStayHospitalRecuperationInstitutionDivisionRadioItem1();
    }
    return shortStayHospitalRecuperationInstitutionDivisionRadioItem1;

  }

  /**
   * II�^����É@���擾���܂��B
   * @return II�^����É@
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationInstitutionDivisionRadioItem2(){
    if(shortStayHospitalRecuperationInstitutionDivisionRadioItem2==null){

      shortStayHospitalRecuperationInstitutionDivisionRadioItem2 = new ACRadioButtonItem();

      shortStayHospitalRecuperationInstitutionDivisionRadioItem2.setText("II�^����É@");

      shortStayHospitalRecuperationInstitutionDivisionRadioItem2.setGroup(getShortStayHospitalRecuperationInstitutionDivisionRadio());

      shortStayHospitalRecuperationInstitutionDivisionRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

      addShortStayHospitalRecuperationInstitutionDivisionRadioItem2();
    }
    return shortStayHospitalRecuperationInstitutionDivisionRadioItem2;

  }

  /**
   * ���ʉ���É@���擾���܂��B
   * @return ���ʉ���É@
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationInstitutionDivisionRadioItem3(){
    if(shortStayHospitalRecuperationInstitutionDivisionRadioItem3==null){

      shortStayHospitalRecuperationInstitutionDivisionRadioItem3 = new ACRadioButtonItem();

      shortStayHospitalRecuperationInstitutionDivisionRadioItem3.setText("���ʉ���É@");

      shortStayHospitalRecuperationInstitutionDivisionRadioItem3.setGroup(getShortStayHospitalRecuperationInstitutionDivisionRadio());

      shortStayHospitalRecuperationInstitutionDivisionRadioItem3.setConstraints(VRLayout.FLOW_RETURN);

      addShortStayHospitalRecuperationInstitutionDivisionRadioItem3();
    }
    return shortStayHospitalRecuperationInstitutionDivisionRadioItem3;

  }

  /**
   * ���j�b�g�^I�^����É@���擾���܂��B
   * @return ���j�b�g�^I�^����É@
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationInstitutionDivisionRadioItem4(){
    if(shortStayHospitalRecuperationInstitutionDivisionRadioItem4==null){

      shortStayHospitalRecuperationInstitutionDivisionRadioItem4 = new ACRadioButtonItem();

      shortStayHospitalRecuperationInstitutionDivisionRadioItem4.setText("���j�b�g�^I�^����É@");

      shortStayHospitalRecuperationInstitutionDivisionRadioItem4.setGroup(getShortStayHospitalRecuperationInstitutionDivisionRadio());

      shortStayHospitalRecuperationInstitutionDivisionRadioItem4.setConstraints(VRLayout.FLOW_RETURN);

      addShortStayHospitalRecuperationInstitutionDivisionRadioItem4();
    }
    return shortStayHospitalRecuperationInstitutionDivisionRadioItem4;

  }

  /**
   * ���j�b�g�^II�^����É@���擾���܂��B
   * @return ���j�b�g�^II�^����É@
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationInstitutionDivisionRadioItem5(){
    if(shortStayHospitalRecuperationInstitutionDivisionRadioItem5==null){

      shortStayHospitalRecuperationInstitutionDivisionRadioItem5 = new ACRadioButtonItem();

      shortStayHospitalRecuperationInstitutionDivisionRadioItem5.setText("���j�b�g�^II�^����É@");

      shortStayHospitalRecuperationInstitutionDivisionRadioItem5.setGroup(getShortStayHospitalRecuperationInstitutionDivisionRadio());

      shortStayHospitalRecuperationInstitutionDivisionRadioItem5.setConstraints(VRLayout.FLOW_RETURN);

      addShortStayHospitalRecuperationInstitutionDivisionRadioItem5();
    }
    return shortStayHospitalRecuperationInstitutionDivisionRadioItem5;

  }

  /**
   * ���j�b�g�^���ʉ���É@���擾���܂��B
   * @return ���j�b�g�^���ʉ���É@
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationInstitutionDivisionRadioItem6(){
    if(shortStayHospitalRecuperationInstitutionDivisionRadioItem6==null){

      shortStayHospitalRecuperationInstitutionDivisionRadioItem6 = new ACRadioButtonItem();

      shortStayHospitalRecuperationInstitutionDivisionRadioItem6.setText("���j�b�g�^���ʉ���É@");

      shortStayHospitalRecuperationInstitutionDivisionRadioItem6.setGroup(getShortStayHospitalRecuperationInstitutionDivisionRadio());

      shortStayHospitalRecuperationInstitutionDivisionRadioItem6.setConstraints(VRLayout.FLOW_RETURN);

      addShortStayHospitalRecuperationInstitutionDivisionRadioItem6();
    }
    return shortStayHospitalRecuperationInstitutionDivisionRadioItem6;

  }

  /**
   * �l���z�u�敪�R���e�i���擾���܂��B
   * @return �l���z�u�敪�R���e�i
   */
  public ACLabelContainer getStaffAssignmentDivisionContainer(){
    if(staffAssignmentDivisionContainer==null){

      staffAssignmentDivisionContainer = new ACLabelContainer();

      staffAssignmentDivisionContainer.setText("�l���z�u�敪");

      staffAssignmentDivisionContainer.setFollowChildEnabled(true);

      addStaffAssignmentDivisionContainer();
    }
    return staffAssignmentDivisionContainer;

  }

  /**
   * �l���z�u�敪���W�I�O���[�v���擾���܂��B
   * @return �l���z�u�敪���W�I�O���[�v
   */
  public ACValueArrayRadioButtonGroup getStaffAssignment1Division(){
    if(staffAssignment1Division==null){

      staffAssignment1Division = new ACValueArrayRadioButtonGroup();

      staffAssignment1Division.setBindPath("20430102");

      staffAssignment1Division.setUseClearButton(false);

      staffAssignment1Division.setModel(getStaffAssignment1DivisionModel());

      staffAssignment1Division.setValues(new int[]{1,2,3});

      addStaffAssignment1Division();
    }
    return staffAssignment1Division;

  }

  /**
   * �l���z�u�敪���W�I�O���[�v���f�����擾���܂��B
   * @return �l���z�u�敪���W�I�O���[�v���f��
   */
  protected ACListModelAdapter getStaffAssignment1DivisionModel(){
    if(staffAssignment1DivisionModel==null){
      staffAssignment1DivisionModel = new ACListModelAdapter();
      addStaffAssignment1DivisionModel();
    }
    return staffAssignment1DivisionModel;
  }

  /**
   * I�^�iI�j���擾���܂��B
   * @return I�^�iI�j
   */
  public ACRadioButtonItem getStaffAssignmentDivisionItem1(){
    if(staffAssignmentDivisionItem1==null){

      staffAssignmentDivisionItem1 = new ACRadioButtonItem();

      staffAssignmentDivisionItem1.setText("I�^ (I)");

      staffAssignmentDivisionItem1.setGroup(getStaffAssignment1Division());

      staffAssignmentDivisionItem1.setConstraints(VRLayout.FLOW);

      addStaffAssignmentDivisionItem1();
    }
    return staffAssignmentDivisionItem1;

  }

  /**
   * I�^�iII�j���擾���܂��B
   * @return I�^�iII�j
   */
  public ACRadioButtonItem getStaffAssignmentDivisionItem2(){
    if(staffAssignmentDivisionItem2==null){

      staffAssignmentDivisionItem2 = new ACRadioButtonItem();

      staffAssignmentDivisionItem2.setText("I�^ (II)");

      staffAssignmentDivisionItem2.setGroup(getStaffAssignment1Division());

      staffAssignmentDivisionItem2.setConstraints(VRLayout.FLOW);

      addStaffAssignmentDivisionItem2();
    }
    return staffAssignmentDivisionItem2;

  }

  /**
   * I�^�iIII�j���擾���܂��B
   * @return I�^�iIII�j
   */
  public ACRadioButtonItem getStaffAssignmentDivisionItem3(){
    if(staffAssignmentDivisionItem3==null){

      staffAssignmentDivisionItem3 = new ACRadioButtonItem();

      staffAssignmentDivisionItem3.setText("I�^ (III)");

      staffAssignmentDivisionItem3.setGroup(getStaffAssignment1Division());

      staffAssignmentDivisionItem3.setConstraints(VRLayout.FLOW);

      addStaffAssignmentDivisionItem3();
    }
    return staffAssignmentDivisionItem3;

  }

  /**
   * �l���z�u�敪���擾���܂��B
   * @return �l���z�u�敪
   */
  public ACValueArrayRadioButtonGroup getStaffAssignment2Division(){
    if(staffAssignment2Division==null){

      staffAssignment2Division = new ACValueArrayRadioButtonGroup();

      staffAssignment2Division.setBindPath("20430103");

      staffAssignment2Division.setUseClearButton(false);

      staffAssignment2Division.setModel(getStaffAssignment2DivisionModel());

      staffAssignment2Division.setValues(new int[]{1,2,3});

      addStaffAssignment2Division();
    }
    return staffAssignment2Division;

  }

  /**
   * �l���z�u�敪���f�����擾���܂��B
   * @return �l���z�u�敪���f��
   */
  protected ACListModelAdapter getStaffAssignment2DivisionModel(){
    if(staffAssignment2DivisionModel==null){
      staffAssignment2DivisionModel = new ACListModelAdapter();
      addStaffAssignment2DivisionModel();
    }
    return staffAssignment2DivisionModel;
  }

  /**
   * II�^�iI�j���擾���܂��B
   * @return II�^�iI�j
   */
  public ACRadioButtonItem getStaffAssignmentDivisionItem4(){
    if(staffAssignmentDivisionItem4==null){

      staffAssignmentDivisionItem4 = new ACRadioButtonItem();

      staffAssignmentDivisionItem4.setText("II�^ (I)");

      staffAssignmentDivisionItem4.setGroup(getStaffAssignment2Division());

      staffAssignmentDivisionItem4.setConstraints(VRLayout.FLOW);

      addStaffAssignmentDivisionItem4();
    }
    return staffAssignmentDivisionItem4;

  }

  /**
   * II�^�iII�j���擾���܂��B
   * @return II�^�iII�j
   */
  public ACRadioButtonItem getStaffAssignmentDivisionItem5(){
    if(staffAssignmentDivisionItem5==null){

      staffAssignmentDivisionItem5 = new ACRadioButtonItem();

      staffAssignmentDivisionItem5.setText("II�^ (II)");

      staffAssignmentDivisionItem5.setGroup(getStaffAssignment2Division());

      staffAssignmentDivisionItem5.setConstraints(VRLayout.FLOW);

      addStaffAssignmentDivisionItem5();
    }
    return staffAssignmentDivisionItem5;

  }

  /**
   * II�^�iIII�j���擾���܂��B
   * @return II�^�iIII�j
   */
  public ACRadioButtonItem getStaffAssignmentDivisionItem6(){
    if(staffAssignmentDivisionItem6==null){

      staffAssignmentDivisionItem6 = new ACRadioButtonItem();

      staffAssignmentDivisionItem6.setText("II�^ (III)");

      staffAssignmentDivisionItem6.setGroup(getStaffAssignment2Division());

      staffAssignmentDivisionItem6.setConstraints(VRLayout.FLOW);

      addStaffAssignmentDivisionItem6();
    }
    return staffAssignmentDivisionItem6;

  }

  /**
   * �l���z�u�敪���擾���܂��B
   * @return �l���z�u�敪
   */
  public ACValueArrayRadioButtonGroup getStaffAssignment3Division(){
    if(staffAssignment3Division==null){

      staffAssignment3Division = new ACValueArrayRadioButtonGroup();

      staffAssignment3Division.setBindPath("20430104");

      staffAssignment3Division.setUseClearButton(false);

      staffAssignment3Division.setModel(getStaffAssignment3DivisionModel());

      staffAssignment3Division.setValues(new int[]{1,2});

      addStaffAssignment3Division();
    }
    return staffAssignment3Division;

  }

  /**
   * �l���z�u�敪���f�����擾���܂��B
   * @return �l���z�u�敪���f��
   */
  protected ACListModelAdapter getStaffAssignment3DivisionModel(){
    if(staffAssignment3DivisionModel==null){
      staffAssignment3DivisionModel = new ACListModelAdapter();
      addStaffAssignment3DivisionModel();
    }
    return staffAssignment3DivisionModel;
  }

  /**
   * I�^���擾���܂��B
   * @return I�^
   */
  public ACRadioButtonItem getStaffAssignmentDivisionItem7(){
    if(staffAssignmentDivisionItem7==null){

      staffAssignmentDivisionItem7 = new ACRadioButtonItem();

      staffAssignmentDivisionItem7.setText("I �^");

      staffAssignmentDivisionItem7.setGroup(getStaffAssignment3Division());

      staffAssignmentDivisionItem7.setConstraints(VRLayout.FLOW);

      addStaffAssignmentDivisionItem7();
    }
    return staffAssignmentDivisionItem7;

  }

  /**
   * II�^���擾���܂��B
   * @return II�^
   */
  public ACRadioButtonItem getStaffAssignmentDivisionItem8(){
    if(staffAssignmentDivisionItem8==null){

      staffAssignmentDivisionItem8 = new ACRadioButtonItem();

      staffAssignmentDivisionItem8.setText("II �^");

      staffAssignmentDivisionItem8.setGroup(getStaffAssignment3Division());

      staffAssignmentDivisionItem8.setConstraints(VRLayout.FLOW);

      addStaffAssignmentDivisionItem8();
    }
    return staffAssignmentDivisionItem8;

  }

  /**
   * �a���敪�R���e�i���擾���܂��B
   * @return �a���敪�R���e�i
   */
  public ACLabelContainer getShortStayHospitalRecuperationHospitalRoomContena(){
    if(shortStayHospitalRecuperationHospitalRoomContena==null){

      shortStayHospitalRecuperationHospitalRoomContena = new ACLabelContainer();

      shortStayHospitalRecuperationHospitalRoomContena.setText("�a���敪");

      shortStayHospitalRecuperationHospitalRoomContena.setFollowChildEnabled(true);

      addShortStayHospitalRecuperationHospitalRoomContena();
    }
    return shortStayHospitalRecuperationHospitalRoomContena;

  }

  /**
   * �a���敪�i�a���j���擾���܂��B
   * @return �a���敪�i�a���j
   */
  public ACValueArrayRadioButtonGroup getShortStayHospitalRecuperationHospitalRoomRadio(){
    if(shortStayHospitalRecuperationHospitalRoomRadio==null){

      shortStayHospitalRecuperationHospitalRoomRadio = new ACValueArrayRadioButtonGroup();

      shortStayHospitalRecuperationHospitalRoomRadio.setBindPath("20430105");

      shortStayHospitalRecuperationHospitalRoomRadio.setUseClearButton(false);

      shortStayHospitalRecuperationHospitalRoomRadio.setModel(getShortStayHospitalRecuperationHospitalRoomRadioModel());

      shortStayHospitalRecuperationHospitalRoomRadio.setValues(new int[]{1,2});

      addShortStayHospitalRecuperationHospitalRoomRadio();
    }
    return shortStayHospitalRecuperationHospitalRoomRadio;

  }

  /**
   * �a���敪�i�a���j���f�����擾���܂��B
   * @return �a���敪�i�a���j���f��
   */
  protected ACListModelAdapter getShortStayHospitalRecuperationHospitalRoomRadioModel(){
    if(shortStayHospitalRecuperationHospitalRoomRadioModel==null){
      shortStayHospitalRecuperationHospitalRoomRadioModel = new ACListModelAdapter();
      addShortStayHospitalRecuperationHospitalRoomRadioModel();
    }
    return shortStayHospitalRecuperationHospitalRoomRadioModel;
  }

  /**
   * �]���^�����擾���܂��B
   * @return �]���^��
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationHospitalRoomRadioItem1(){
    if(shortStayHospitalRecuperationHospitalRoomRadioItem1==null){

      shortStayHospitalRecuperationHospitalRoomRadioItem1 = new ACRadioButtonItem();

      shortStayHospitalRecuperationHospitalRoomRadioItem1.setText("�]���^��");

      shortStayHospitalRecuperationHospitalRoomRadioItem1.setGroup(getShortStayHospitalRecuperationHospitalRoomRadio());

      shortStayHospitalRecuperationHospitalRoomRadioItem1.setConstraints(VRLayout.FLOW);

      addShortStayHospitalRecuperationHospitalRoomRadioItem1();
    }
    return shortStayHospitalRecuperationHospitalRoomRadioItem1;

  }

  /**
   * ���������擾���܂��B
   * @return ������
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationHospitalRoomRadioItem2(){
    if(shortStayHospitalRecuperationHospitalRoomRadioItem2==null){

      shortStayHospitalRecuperationHospitalRoomRadioItem2 = new ACRadioButtonItem();

      shortStayHospitalRecuperationHospitalRoomRadioItem2.setText("������");

      shortStayHospitalRecuperationHospitalRoomRadioItem2.setGroup(getShortStayHospitalRecuperationHospitalRoomRadio());

      shortStayHospitalRecuperationHospitalRoomRadioItem2.setConstraints(VRLayout.FLOW);

      addShortStayHospitalRecuperationHospitalRoomRadioItem2();
    }
    return shortStayHospitalRecuperationHospitalRoomRadioItem2;

  }

  /**
   * �a���敪�i���j�b�g�^�a�@�j���擾���܂��B
   * @return �a���敪�i���j�b�g�^�a�@�j
   */
  public ACValueArrayRadioButtonGroup getShortStayHospitalRecuperationUnitHospitalRoomRadio(){
    if(shortStayHospitalRecuperationUnitHospitalRoomRadio==null){

      shortStayHospitalRecuperationUnitHospitalRoomRadio = new ACValueArrayRadioButtonGroup();

      shortStayHospitalRecuperationUnitHospitalRoomRadio.setBindPath("20430106");

      shortStayHospitalRecuperationUnitHospitalRoomRadio.setUseClearButton(false);

      shortStayHospitalRecuperationUnitHospitalRoomRadio.setModel(getShortStayHospitalRecuperationUnitHospitalRoomRadioModel());

      shortStayHospitalRecuperationUnitHospitalRoomRadio.setValues(new int[]{1,2});

      addShortStayHospitalRecuperationUnitHospitalRoomRadio();
    }
    return shortStayHospitalRecuperationUnitHospitalRoomRadio;

  }

  /**
   * �a���敪�i���j�b�g�^�a�@�j���f�����擾���܂��B
   * @return �a���敪�i���j�b�g�^�a�@�j���f��
   */
  protected ACListModelAdapter getShortStayHospitalRecuperationUnitHospitalRoomRadioModel(){
    if(shortStayHospitalRecuperationUnitHospitalRoomRadioModel==null){
      shortStayHospitalRecuperationUnitHospitalRoomRadioModel = new ACListModelAdapter();
      addShortStayHospitalRecuperationUnitHospitalRoomRadioModel();
    }
    return shortStayHospitalRecuperationUnitHospitalRoomRadioModel;
  }

  /**
   * ���j�b�g�^�����擾���܂��B
   * @return ���j�b�g�^��
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationUnitHospitalRoomRadioItem1(){
    if(shortStayHospitalRecuperationUnitHospitalRoomRadioItem1==null){

      shortStayHospitalRecuperationUnitHospitalRoomRadioItem1 = new ACRadioButtonItem();

      shortStayHospitalRecuperationUnitHospitalRoomRadioItem1.setText("�ƯČ^��");

      shortStayHospitalRecuperationUnitHospitalRoomRadioItem1.setGroup(getShortStayHospitalRecuperationUnitHospitalRoomRadio());

      shortStayHospitalRecuperationUnitHospitalRoomRadioItem1.setConstraints(VRLayout.FLOW);

      addShortStayHospitalRecuperationUnitHospitalRoomRadioItem1();
    }
    return shortStayHospitalRecuperationUnitHospitalRoomRadioItem1;

  }

  /**
   * ���j�b�g�^���I���������擾���܂��B
   * @return ���j�b�g�^���I������
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationUnitHospitalRoomRadioItem2(){
    if(shortStayHospitalRecuperationUnitHospitalRoomRadioItem2==null){

      shortStayHospitalRecuperationUnitHospitalRoomRadioItem2 = new ACRadioButtonItem();

      shortStayHospitalRecuperationUnitHospitalRoomRadioItem2.setText("�ƯČ^���I������");

      shortStayHospitalRecuperationUnitHospitalRoomRadioItem2.setGroup(getShortStayHospitalRecuperationUnitHospitalRoomRadio());

      shortStayHospitalRecuperationUnitHospitalRoomRadioItem2.setConstraints(VRLayout.FLOW);

      addShortStayHospitalRecuperationUnitHospitalRoomRadioItem2();
    }
    return shortStayHospitalRecuperationUnitHospitalRoomRadioItem2;

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
   * ���j�b�g�P�A�̐������擾���܂��B
   * @return ���j�b�g�P�A�̐���
   */
  public ACValueArrayRadioButtonGroup getShortStayHospitalRecuperationUnitCareMaintenanceRadio(){
    if(shortStayHospitalRecuperationUnitCareMaintenanceRadio==null){

      shortStayHospitalRecuperationUnitCareMaintenanceRadio = new ACValueArrayRadioButtonGroup();

      getShortStayHospitalRecuperationUnitCareMaintenanceRadioContainer().setText("���j�b�g�P�A�̐���");

      shortStayHospitalRecuperationUnitCareMaintenanceRadio.setBindPath("20430109");

      shortStayHospitalRecuperationUnitCareMaintenanceRadio.setUseClearButton(false);

      shortStayHospitalRecuperationUnitCareMaintenanceRadio.setModel(getShortStayHospitalRecuperationUnitCareMaintenanceRadioModel());

      shortStayHospitalRecuperationUnitCareMaintenanceRadio.setValues(new int[]{1,2});

      addShortStayHospitalRecuperationUnitCareMaintenanceRadio();
    }
    return shortStayHospitalRecuperationUnitCareMaintenanceRadio;

  }

  /**
   * ���j�b�g�P�A�̐����R���e�i���擾���܂��B
   * @return ���j�b�g�P�A�̐����R���e�i
   */
  protected ACLabelContainer getShortStayHospitalRecuperationUnitCareMaintenanceRadioContainer(){
    if(shortStayHospitalRecuperationUnitCareMaintenanceRadioContainer==null){
      shortStayHospitalRecuperationUnitCareMaintenanceRadioContainer = new ACLabelContainer();
      shortStayHospitalRecuperationUnitCareMaintenanceRadioContainer.setFollowChildEnabled(true);
      shortStayHospitalRecuperationUnitCareMaintenanceRadioContainer.setVAlignment(VRLayout.CENTER);
      shortStayHospitalRecuperationUnitCareMaintenanceRadioContainer.add(getShortStayHospitalRecuperationUnitCareMaintenanceRadio(), null);
    }
    return shortStayHospitalRecuperationUnitCareMaintenanceRadioContainer;
  }

  /**
   * ���j�b�g�P�A�̐������f�����擾���܂��B
   * @return ���j�b�g�P�A�̐������f��
   */
  protected ACListModelAdapter getShortStayHospitalRecuperationUnitCareMaintenanceRadioModel(){
    if(shortStayHospitalRecuperationUnitCareMaintenanceRadioModel==null){
      shortStayHospitalRecuperationUnitCareMaintenanceRadioModel = new ACListModelAdapter();
      addShortStayHospitalRecuperationUnitCareMaintenanceRadioModel();
    }
    return shortStayHospitalRecuperationUnitCareMaintenanceRadioModel;
  }

  /**
   * ���������擾���܂��B
   * @return ������
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationUnitCareMaintenanceRadioItem1(){
    if(shortStayHospitalRecuperationUnitCareMaintenanceRadioItem1==null){

      shortStayHospitalRecuperationUnitCareMaintenanceRadioItem1 = new ACRadioButtonItem();

      shortStayHospitalRecuperationUnitCareMaintenanceRadioItem1.setText("������");

      shortStayHospitalRecuperationUnitCareMaintenanceRadioItem1.setGroup(getShortStayHospitalRecuperationUnitCareMaintenanceRadio());

      shortStayHospitalRecuperationUnitCareMaintenanceRadioItem1.setConstraints(VRLayout.FLOW);

      addShortStayHospitalRecuperationUnitCareMaintenanceRadioItem1();
    }
    return shortStayHospitalRecuperationUnitCareMaintenanceRadioItem1;

  }

  /**
   * �������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationUnitCareMaintenanceRadioItem2(){
    if(shortStayHospitalRecuperationUnitCareMaintenanceRadioItem2==null){

      shortStayHospitalRecuperationUnitCareMaintenanceRadioItem2 = new ACRadioButtonItem();

      shortStayHospitalRecuperationUnitCareMaintenanceRadioItem2.setText("����");

      shortStayHospitalRecuperationUnitCareMaintenanceRadioItem2.setGroup(getShortStayHospitalRecuperationUnitCareMaintenanceRadio());

      shortStayHospitalRecuperationUnitCareMaintenanceRadioItem2.setConstraints(VRLayout.FLOW);

      addShortStayHospitalRecuperationUnitCareMaintenanceRadioItem2();
    }
    return shortStayHospitalRecuperationUnitCareMaintenanceRadioItem2;

  }

  /**
   * ��ԋΖ����Ō���Z���擾���܂��B
   * @return ��ԋΖ����Ō���Z
   */
  public ACValueArrayRadioButtonGroup getShortStayHospitalRecuperationAdditionType(){
    if(shortStayHospitalRecuperationAdditionType==null){

      shortStayHospitalRecuperationAdditionType = new ACValueArrayRadioButtonGroup();

      getShortStayHospitalRecuperationAdditionTypeContainer().setText("��ԋΖ����Ō���Z");

      shortStayHospitalRecuperationAdditionType.setBindPath("20430110");

      shortStayHospitalRecuperationAdditionType.setUseClearButton(false);

      shortStayHospitalRecuperationAdditionType.setModel(getShortStayHospitalRecuperationAdditionTypeModel());

      shortStayHospitalRecuperationAdditionType.setValues(new int[]{1,2,3,4,5});

      addShortStayHospitalRecuperationAdditionType();
    }
    return shortStayHospitalRecuperationAdditionType;

  }

  /**
   * ��ԋΖ����Ō���Z�R���e�i���擾���܂��B
   * @return ��ԋΖ����Ō���Z�R���e�i
   */
  protected ACLabelContainer getShortStayHospitalRecuperationAdditionTypeContainer(){
    if(shortStayHospitalRecuperationAdditionTypeContainer==null){
      shortStayHospitalRecuperationAdditionTypeContainer = new ACLabelContainer();
      shortStayHospitalRecuperationAdditionTypeContainer.setFollowChildEnabled(true);
      shortStayHospitalRecuperationAdditionTypeContainer.setVAlignment(VRLayout.CENTER);
      shortStayHospitalRecuperationAdditionTypeContainer.add(getShortStayHospitalRecuperationAdditionType(), null);
    }
    return shortStayHospitalRecuperationAdditionTypeContainer;
  }

  /**
   * ��ԋΖ����Ō���Z���f�����擾���܂��B
   * @return ��ԋΖ����Ō���Z���f��
   */
  protected ACListModelAdapter getShortStayHospitalRecuperationAdditionTypeModel(){
    if(shortStayHospitalRecuperationAdditionTypeModel==null){
      shortStayHospitalRecuperationAdditionTypeModel = new ACListModelAdapter();
      addShortStayHospitalRecuperationAdditionTypeModel();
    }
    return shortStayHospitalRecuperationAdditionTypeModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationAdditionType1(){
    if(shortStayHospitalRecuperationAdditionType1==null){

      shortStayHospitalRecuperationAdditionType1 = new ACRadioButtonItem();

      shortStayHospitalRecuperationAdditionType1.setText("�Ȃ�");

      shortStayHospitalRecuperationAdditionType1.setGroup(getShortStayHospitalRecuperationAdditionType());

      shortStayHospitalRecuperationAdditionType1.setConstraints(VRLayout.FLOW);

      addShortStayHospitalRecuperationAdditionType1();
    }
    return shortStayHospitalRecuperationAdditionType1;

  }

  /**
   * I�^���擾���܂��B
   * @return I�^
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationAdditionType2(){
    if(shortStayHospitalRecuperationAdditionType2==null){

      shortStayHospitalRecuperationAdditionType2 = new ACRadioButtonItem();

      shortStayHospitalRecuperationAdditionType2.setText("I�^");

      shortStayHospitalRecuperationAdditionType2.setGroup(getShortStayHospitalRecuperationAdditionType());

      shortStayHospitalRecuperationAdditionType2.setConstraints(VRLayout.FLOW);

      addShortStayHospitalRecuperationAdditionType2();
    }
    return shortStayHospitalRecuperationAdditionType2;

  }

  /**
   * II�^���擾���܂��B
   * @return II�^
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationAdditionType3(){
    if(shortStayHospitalRecuperationAdditionType3==null){

      shortStayHospitalRecuperationAdditionType3 = new ACRadioButtonItem();

      shortStayHospitalRecuperationAdditionType3.setText("II�^");

      shortStayHospitalRecuperationAdditionType3.setGroup(getShortStayHospitalRecuperationAdditionType());

      shortStayHospitalRecuperationAdditionType3.setConstraints(VRLayout.FLOW_RETURN);

      addShortStayHospitalRecuperationAdditionType3();
    }
    return shortStayHospitalRecuperationAdditionType3;

  }

  /**
   * III�^���擾���܂��B
   * @return III�^
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationAdditionType4(){
    if(shortStayHospitalRecuperationAdditionType4==null){

      shortStayHospitalRecuperationAdditionType4 = new ACRadioButtonItem();

      shortStayHospitalRecuperationAdditionType4.setText("III�^");

      shortStayHospitalRecuperationAdditionType4.setGroup(getShortStayHospitalRecuperationAdditionType());

      shortStayHospitalRecuperationAdditionType4.setConstraints(VRLayout.FLOW);

      addShortStayHospitalRecuperationAdditionType4();
    }
    return shortStayHospitalRecuperationAdditionType4;

  }

  /**
   * IV�^���擾���܂��B
   * @return IV�^
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationAdditionType5(){
    if(shortStayHospitalRecuperationAdditionType5==null){

      shortStayHospitalRecuperationAdditionType5 = new ACRadioButtonItem();

      shortStayHospitalRecuperationAdditionType5.setText("IV�^");

      shortStayHospitalRecuperationAdditionType5.setGroup(getShortStayHospitalRecuperationAdditionType());

      shortStayHospitalRecuperationAdditionType5.setConstraints(VRLayout.FLOW);

      addShortStayHospitalRecuperationAdditionType5();
    }
    return shortStayHospitalRecuperationAdditionType5;

  }

  /**
   * �×{����i�L���j���擾���܂��B
   * @return �×{����i�L���j
   */
  public ACValueArrayRadioButtonGroup getEnvironmentalCorridorRadio(){
    if(environmentalCorridorRadio==null){

      environmentalCorridorRadio = new ACValueArrayRadioButtonGroup();

      getEnvironmentalCorridorRadioContainer().setText("�×{����i�L���j");

      environmentalCorridorRadio.setBindPath("20430111");

      environmentalCorridorRadio.setUseClearButton(false);

      environmentalCorridorRadio.setModel(getEnvironmentalCorridorRadioModel());

      environmentalCorridorRadio.setValues(new int[]{1,2});

      addEnvironmentalCorridorRadio();
    }
    return environmentalCorridorRadio;

  }

  /**
   * �×{����i�L���j�R���e�i���擾���܂��B
   * @return �×{����i�L���j�R���e�i
   */
  protected ACLabelContainer getEnvironmentalCorridorRadioContainer(){
    if(environmentalCorridorRadioContainer==null){
      environmentalCorridorRadioContainer = new ACLabelContainer();
      environmentalCorridorRadioContainer.setFollowChildEnabled(true);
      environmentalCorridorRadioContainer.setVAlignment(VRLayout.CENTER);
      environmentalCorridorRadioContainer.add(getEnvironmentalCorridorRadio(), null);
    }
    return environmentalCorridorRadioContainer;
  }

  /**
   * �×{����i�L���j���f�����擾���܂��B
   * @return �×{����i�L���j���f��
   */
  protected ACListModelAdapter getEnvironmentalCorridorRadioModel(){
    if(environmentalCorridorRadioModel==null){
      environmentalCorridorRadioModel = new ACListModelAdapter();
      addEnvironmentalCorridorRadioModel();
    }
    return environmentalCorridorRadioModel;
  }

  /**
   * ��^���擾���܂��B
   * @return ��^
   */
  public ACRadioButtonItem getEnvironmentalCorridorRadioItem1(){
    if(environmentalCorridorRadioItem1==null){

      environmentalCorridorRadioItem1 = new ACRadioButtonItem();

      environmentalCorridorRadioItem1.setText("��^");

      environmentalCorridorRadioItem1.setGroup(getEnvironmentalCorridorRadio());

      environmentalCorridorRadioItem1.setConstraints(VRLayout.FLOW);

      addEnvironmentalCorridorRadioItem1();
    }
    return environmentalCorridorRadioItem1;

  }

  /**
   * ���Z�^���擾���܂��B
   * @return ���Z�^
   */
  public ACRadioButtonItem getEnvironmentalCorridorRadioItem2(){
    if(environmentalCorridorRadioItem2==null){

      environmentalCorridorRadioItem2 = new ACRadioButtonItem();

      environmentalCorridorRadioItem2.setText("���Z�^");

      environmentalCorridorRadioItem2.setGroup(getEnvironmentalCorridorRadio());

      environmentalCorridorRadioItem2.setConstraints(VRLayout.FLOW);

      addEnvironmentalCorridorRadioItem2();
    }
    return environmentalCorridorRadioItem2;

  }

  /**
   * �×{����i�×{���j���擾���܂��B
   * @return �×{����i�×{���j
   */
  public ACValueArrayRadioButtonGroup getEnvironmentalRecuperationRoomRadio(){
    if(environmentalRecuperationRoomRadio==null){

      environmentalRecuperationRoomRadio = new ACValueArrayRadioButtonGroup();

      getEnvironmentalRecuperationRoomRadioContainer().setText("�×{����i�×{���j");

      environmentalRecuperationRoomRadio.setBindPath("20430112");

      environmentalRecuperationRoomRadio.setUseClearButton(false);

      environmentalRecuperationRoomRadio.setModel(getEnvironmentalRecuperationRoomRadioModel());

      environmentalRecuperationRoomRadio.setValues(new int[]{1,2});

      addEnvironmentalRecuperationRoomRadio();
    }
    return environmentalRecuperationRoomRadio;

  }

  /**
   * �×{����i�×{���j�R���e�i���擾���܂��B
   * @return �×{����i�×{���j�R���e�i
   */
  protected ACLabelContainer getEnvironmentalRecuperationRoomRadioContainer(){
    if(environmentalRecuperationRoomRadioContainer==null){
      environmentalRecuperationRoomRadioContainer = new ACLabelContainer();
      environmentalRecuperationRoomRadioContainer.setFollowChildEnabled(true);
      environmentalRecuperationRoomRadioContainer.setVAlignment(VRLayout.CENTER);
      environmentalRecuperationRoomRadioContainer.add(getEnvironmentalRecuperationRoomRadio(), null);
    }
    return environmentalRecuperationRoomRadioContainer;
  }

  /**
   * �×{����i�×{���j���f�����擾���܂��B
   * @return �×{����i�×{���j���f��
   */
  protected ACListModelAdapter getEnvironmentalRecuperationRoomRadioModel(){
    if(environmentalRecuperationRoomRadioModel==null){
      environmentalRecuperationRoomRadioModel = new ACListModelAdapter();
      addEnvironmentalRecuperationRoomRadioModel();
    }
    return environmentalRecuperationRoomRadioModel;
  }

  /**
   * ��^���擾���܂��B
   * @return ��^
   */
  public ACRadioButtonItem getEnvironmentalRecuperationRoomRadioItem1(){
    if(environmentalRecuperationRoomRadioItem1==null){

      environmentalRecuperationRoomRadioItem1 = new ACRadioButtonItem();

      environmentalRecuperationRoomRadioItem1.setText("��^");

      environmentalRecuperationRoomRadioItem1.setGroup(getEnvironmentalRecuperationRoomRadio());

      environmentalRecuperationRoomRadioItem1.setConstraints(VRLayout.FLOW);

      addEnvironmentalRecuperationRoomRadioItem1();
    }
    return environmentalRecuperationRoomRadioItem1;

  }

  /**
   * ���Z�^���擾���܂��B
   * @return ���Z�^
   */
  public ACRadioButtonItem getEnvironmentalRecuperationRoomRadioItem2(){
    if(environmentalRecuperationRoomRadioItem2==null){

      environmentalRecuperationRoomRadioItem2 = new ACRadioButtonItem();

      environmentalRecuperationRoomRadioItem2.setText("���Z�^");

      environmentalRecuperationRoomRadioItem2.setGroup(getEnvironmentalRecuperationRoomRadio());

      environmentalRecuperationRoomRadioItem2.setConstraints(VRLayout.FLOW);

      addEnvironmentalRecuperationRoomRadioItem2();
    }
    return environmentalRecuperationRoomRadioItem2;

  }

  /**
   * ��ԋΖ���������擾���܂��B
   * @return ��ԋΖ������
   */
  public ACValueArrayRadioButtonGroup getShortStayHospitalRecuperationType(){
    if(shortStayHospitalRecuperationType==null){

      shortStayHospitalRecuperationType = new ACValueArrayRadioButtonGroup();

      getShortStayHospitalRecuperationTypeContainer().setText("��ԋΖ������");

      shortStayHospitalRecuperationType.setBindPath("20430113");

      shortStayHospitalRecuperationType.setUseClearButton(false);

      shortStayHospitalRecuperationType.setModel(getShortStayHospitalRecuperationTypeModel());

      shortStayHospitalRecuperationType.setValues(new int[]{1,2});

      addShortStayHospitalRecuperationType();
    }
    return shortStayHospitalRecuperationType;

  }

  /**
   * ��ԋΖ�������R���e�i���擾���܂��B
   * @return ��ԋΖ�������R���e�i
   */
  protected ACLabelContainer getShortStayHospitalRecuperationTypeContainer(){
    if(shortStayHospitalRecuperationTypeContainer==null){
      shortStayHospitalRecuperationTypeContainer = new ACLabelContainer();
      shortStayHospitalRecuperationTypeContainer.setFollowChildEnabled(true);
      shortStayHospitalRecuperationTypeContainer.setVAlignment(VRLayout.CENTER);
      shortStayHospitalRecuperationTypeContainer.add(getShortStayHospitalRecuperationType(), null);
    }
    return shortStayHospitalRecuperationTypeContainer;
  }

  /**
   * ��ԋΖ���������f�����擾���܂��B
   * @return ��ԋΖ���������f��
   */
  protected ACListModelAdapter getShortStayHospitalRecuperationTypeModel(){
    if(shortStayHospitalRecuperationTypeModel==null){
      shortStayHospitalRecuperationTypeModel = new ACListModelAdapter();
      addShortStayHospitalRecuperationTypeModel();
    }
    return shortStayHospitalRecuperationTypeModel;
  }

  /**
   * �ʏ���擾���܂��B
   * @return �ʏ�
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationTypeNormal(){
    if(shortStayHospitalRecuperationTypeNormal==null){

      shortStayHospitalRecuperationTypeNormal = new ACRadioButtonItem();

      shortStayHospitalRecuperationTypeNormal.setText("��^");

      shortStayHospitalRecuperationTypeNormal.setGroup(getShortStayHospitalRecuperationType());

      shortStayHospitalRecuperationTypeNormal.setConstraints(VRLayout.FLOW);

      addShortStayHospitalRecuperationTypeNormal();
    }
    return shortStayHospitalRecuperationTypeNormal;

  }

  /**
   * ���Z�^���擾���܂��B
   * @return ���Z�^
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationTypeNone(){
    if(shortStayHospitalRecuperationTypeNone==null){

      shortStayHospitalRecuperationTypeNone = new ACRadioButtonItem();

      shortStayHospitalRecuperationTypeNone.setText("���Z�^");

      shortStayHospitalRecuperationTypeNone.setGroup(getShortStayHospitalRecuperationType());

      shortStayHospitalRecuperationTypeNone.setConstraints(VRLayout.FLOW);

      addShortStayHospitalRecuperationTypeNone();
    }
    return shortStayHospitalRecuperationTypeNone;

  }

  /**
   * �E�����Z���擾���܂��B
   * @return �E�����Z
   */
  public ACValueArrayRadioButtonGroup getMedicalFacilityHospitalSubstraction(){
    if(medicalFacilityHospitalSubstraction==null){

      medicalFacilityHospitalSubstraction = new ACValueArrayRadioButtonGroup();

      getMedicalFacilityHospitalSubstractionContainer().setText("�l�����Z");

      medicalFacilityHospitalSubstraction.setBindPath("20430114");

      medicalFacilityHospitalSubstraction.setUseClearButton(false);

      medicalFacilityHospitalSubstraction.setModel(getMedicalFacilityHospitalSubstractionModel());

      medicalFacilityHospitalSubstraction.setValues(new int[]{1,2,3,4});

      addMedicalFacilityHospitalSubstraction();
    }
    return medicalFacilityHospitalSubstraction;

  }

  /**
   * �E�����Z�R���e�i���擾���܂��B
   * @return �E�����Z�R���e�i
   */
  protected ACLabelContainer getMedicalFacilityHospitalSubstractionContainer(){
    if(medicalFacilityHospitalSubstractionContainer==null){
      medicalFacilityHospitalSubstractionContainer = new ACLabelContainer();
      medicalFacilityHospitalSubstractionContainer.setFollowChildEnabled(true);
      medicalFacilityHospitalSubstractionContainer.setVAlignment(VRLayout.CENTER);
      medicalFacilityHospitalSubstractionContainer.add(getMedicalFacilityHospitalSubstraction(), null);
    }
    return medicalFacilityHospitalSubstractionContainer;
  }

  /**
   * �E�����Z���f�����擾���܂��B
   * @return �E�����Z���f��
   */
  protected ACListModelAdapter getMedicalFacilityHospitalSubstractionModel(){
    if(medicalFacilityHospitalSubstractionModel==null){
      medicalFacilityHospitalSubstractionModel = new ACListModelAdapter();
      addMedicalFacilityHospitalSubstractionModel();
    }
    return medicalFacilityHospitalSubstractionModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getMedicalFacilityHospitalSubstractionItem1(){
    if(medicalFacilityHospitalSubstractionItem1==null){

      medicalFacilityHospitalSubstractionItem1 = new ACRadioButtonItem();

      medicalFacilityHospitalSubstractionItem1.setText("�Ȃ�");

      medicalFacilityHospitalSubstractionItem1.setGroup(getMedicalFacilityHospitalSubstraction());

      medicalFacilityHospitalSubstractionItem1.setConstraints(VRLayout.FLOW);

      addMedicalFacilityHospitalSubstractionItem1();
    }
    return medicalFacilityHospitalSubstractionItem1;

  }

  /**
   * ������߂��擾���܂��B
   * @return �������
   */
  public ACRadioButtonItem getMedicalFacilityHospitalSubstractionItem2(){
    if(medicalFacilityHospitalSubstractionItem2==null){

      medicalFacilityHospitalSubstractionItem2 = new ACRadioButtonItem();

      medicalFacilityHospitalSubstractionItem2.setText("�������");

      medicalFacilityHospitalSubstractionItem2.setGroup(getMedicalFacilityHospitalSubstraction());

      medicalFacilityHospitalSubstractionItem2.setConstraints(VRLayout.FLOW_RETURN);

      addMedicalFacilityHospitalSubstractionItem2();
    }
    return medicalFacilityHospitalSubstractionItem2;

  }

  /**
   * ��t�E��܎t�E�Ō�E���E���E���̕s�����擾���܂��B
   * @return ��t�E��܎t�E�Ō�E���E���E���̕s��
   */
  public ACRadioButtonItem getMedicalFacilityHospitalSubstractionItem3(){
    if(medicalFacilityHospitalSubstractionItem3==null){

      medicalFacilityHospitalSubstractionItem3 = new ACRadioButtonItem();

      medicalFacilityHospitalSubstractionItem3.setText("<html>��t�E��܎t�E�Ō�E��<br>���E���̕s��<html>");

      medicalFacilityHospitalSubstractionItem3.setGroup(getMedicalFacilityHospitalSubstraction());

      medicalFacilityHospitalSubstractionItem3.setConstraints(VRLayout.FLOW_RETURN);

      addMedicalFacilityHospitalSubstractionItem3();
    }
    return medicalFacilityHospitalSubstractionItem3;

  }

  /**
   * ���Ŕ䗦��20���������擾���܂��B
   * @return ���Ŕ䗦��20������
   */
  public ACRadioButtonItem getMedicalFacilityHospitalSubstractionItem4(){
    if(medicalFacilityHospitalSubstractionItem4==null){

      medicalFacilityHospitalSubstractionItem4 = new ACRadioButtonItem();

      medicalFacilityHospitalSubstractionItem4.setText("���Ŕ䗦��20������");

      medicalFacilityHospitalSubstractionItem4.setGroup(getMedicalFacilityHospitalSubstraction());

      medicalFacilityHospitalSubstractionItem4.setConstraints(VRLayout.FLOW);

      addMedicalFacilityHospitalSubstractionItem4();
    }
    return medicalFacilityHospitalSubstractionItem4;

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
   * �F�m�Ǎs���E�S���Ǐ�ً}�Ή����Z���擾���܂��B
   * @return �F�m�Ǎs���E�S���Ǐ�ً}�Ή����Z
   */
  public ACValueArrayRadioButtonGroup getDementiaActionAddRadioGroup(){
    if(dementiaActionAddRadioGroup==null){

      dementiaActionAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getDementiaActionAddRadioGroupContainer().setText("�F�m�Ǎs���E" + ACConstants.LINE_SEPARATOR + "�S���Ǐ�ً}�Ή����Z" + ACConstants.LINE_SEPARATOR + "�i1����7�������x�j");

      dementiaActionAddRadioGroup.setBindPath("20430115");

      dementiaActionAddRadioGroup.setNoSelectIndex(0);

      dementiaActionAddRadioGroup.setUseClearButton(false);

      dementiaActionAddRadioGroup.setModel(getDementiaActionAddRadioGroupModel());

      dementiaActionAddRadioGroup.setValues(new int[]{1,2});

      addDementiaActionAddRadioGroup();
    }
    return dementiaActionAddRadioGroup;

  }

  /**
   * �F�m�Ǎs���E�S���Ǐ�ً}�Ή����Z�R���e�i���擾���܂��B
   * @return �F�m�Ǎs���E�S���Ǐ�ً}�Ή����Z�R���e�i
   */
  protected ACLabelContainer getDementiaActionAddRadioGroupContainer(){
    if(dementiaActionAddRadioGroupContainer==null){
      dementiaActionAddRadioGroupContainer = new ACLabelContainer();
      dementiaActionAddRadioGroupContainer.setFollowChildEnabled(true);
      dementiaActionAddRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      dementiaActionAddRadioGroupContainer.add(getDementiaActionAddRadioGroup(), null);
    }
    return dementiaActionAddRadioGroupContainer;
  }

  /**
   * �F�m�Ǎs���E�S���Ǐ�ً}�Ή����Z���f�����擾���܂��B
   * @return �F�m�Ǎs���E�S���Ǐ�ً}�Ή����Z���f��
   */
  protected ACListModelAdapter getDementiaActionAddRadioGroupModel(){
    if(dementiaActionAddRadioGroupModel==null){
      dementiaActionAddRadioGroupModel = new ACListModelAdapter();
      addDementiaActionAddRadioGroupModel();
    }
    return dementiaActionAddRadioGroupModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getDementiaActionAddRadioItem1(){
    if(dementiaActionAddRadioItem1==null){

      dementiaActionAddRadioItem1 = new ACRadioButtonItem();

      dementiaActionAddRadioItem1.setText("�Ȃ�");

      dementiaActionAddRadioItem1.setGroup(getDementiaActionAddRadioGroup());

      dementiaActionAddRadioItem1.setConstraints(VRLayout.FLOW);

      addDementiaActionAddRadioItem1();
    }
    return dementiaActionAddRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getDementiaActionAddRadioItem2(){
    if(dementiaActionAddRadioItem2==null){

      dementiaActionAddRadioItem2 = new ACRadioButtonItem();

      dementiaActionAddRadioItem2.setText("����");

      dementiaActionAddRadioItem2.setGroup(getDementiaActionAddRadioGroup());

      dementiaActionAddRadioItem2.setConstraints(VRLayout.FLOW);

      addDementiaActionAddRadioItem2();
    }
    return dementiaActionAddRadioItem2;

  }

  /**
   * ��N���F�m�Ǘ��p�Ҏ�����Z���擾���܂��B
   * @return ��N���F�m�Ǘ��p�Ҏ�����Z
   */
  public ACValueArrayRadioButtonGroup getYoungDementiaPatinetAddRadioGroup(){
    if(youngDementiaPatinetAddRadioGroup==null){

      youngDementiaPatinetAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getYoungDementiaPatinetAddRadioGroupContainer().setText("��N���F�m�Ǘ��p�Ҏ�����Z");

      youngDementiaPatinetAddRadioGroup.setBindPath("20430117");

      youngDementiaPatinetAddRadioGroup.setNoSelectIndex(0);

      youngDementiaPatinetAddRadioGroup.setUseClearButton(false);

      youngDementiaPatinetAddRadioGroup.setModel(getYoungDementiaPatinetAddRadioGroupModel());

      youngDementiaPatinetAddRadioGroup.setValues(new int[]{1,2});

      addYoungDementiaPatinetAddRadioGroup();
    }
    return youngDementiaPatinetAddRadioGroup;

  }

  /**
   * ��N���F�m�Ǘ��p�Ҏ�����Z�R���e�i���擾���܂��B
   * @return ��N���F�m�Ǘ��p�Ҏ�����Z�R���e�i
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
   * ��N���F�m�Ǘ��p�Ҏ�����Z���f�����擾���܂��B
   * @return ��N���F�m�Ǘ��p�Ҏ�����Z���f��
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
   * ���}���Z���擾���܂��B
   * @return ���}���Z
   */
  public ACValueArrayRadioButtonGroup getShortStayHospitalRecuperationMeetingAndSendingOff(){
    if(shortStayHospitalRecuperationMeetingAndSendingOff==null){

      shortStayHospitalRecuperationMeetingAndSendingOff = new ACValueArrayRadioButtonGroup();

      getShortStayHospitalRecuperationMeetingAndSendingOffContainer().setText("���}���Z");

      shortStayHospitalRecuperationMeetingAndSendingOff.setBindPath("6");

      shortStayHospitalRecuperationMeetingAndSendingOff.setUseClearButton(false);

      shortStayHospitalRecuperationMeetingAndSendingOff.setModel(getShortStayHospitalRecuperationMeetingAndSendingOffModel());

      shortStayHospitalRecuperationMeetingAndSendingOff.setValues(new int[]{1,2,3});

      addShortStayHospitalRecuperationMeetingAndSendingOff();
    }
    return shortStayHospitalRecuperationMeetingAndSendingOff;

  }

  /**
   * ���}���Z�R���e�i���擾���܂��B
   * @return ���}���Z�R���e�i
   */
  protected ACLabelContainer getShortStayHospitalRecuperationMeetingAndSendingOffContainer(){
    if(shortStayHospitalRecuperationMeetingAndSendingOffContainer==null){
      shortStayHospitalRecuperationMeetingAndSendingOffContainer = new ACLabelContainer();
      shortStayHospitalRecuperationMeetingAndSendingOffContainer.setFollowChildEnabled(true);
      shortStayHospitalRecuperationMeetingAndSendingOffContainer.setVAlignment(VRLayout.CENTER);
      shortStayHospitalRecuperationMeetingAndSendingOffContainer.add(getShortStayHospitalRecuperationMeetingAndSendingOff(), null);
    }
    return shortStayHospitalRecuperationMeetingAndSendingOffContainer;
  }

  /**
   * ���}���Z���f�����擾���܂��B
   * @return ���}���Z���f��
   */
  protected ACListModelAdapter getShortStayHospitalRecuperationMeetingAndSendingOffModel(){
    if(shortStayHospitalRecuperationMeetingAndSendingOffModel==null){
      shortStayHospitalRecuperationMeetingAndSendingOffModel = new ACListModelAdapter();
      addShortStayHospitalRecuperationMeetingAndSendingOffModel();
    }
    return shortStayHospitalRecuperationMeetingAndSendingOffModel;
  }

  /**
   * ���}�Ȃ����擾���܂��B
   * @return ���}�Ȃ�
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationMeetingAndSendingOffNone(){
    if(shortStayHospitalRecuperationMeetingAndSendingOffNone==null){

      shortStayHospitalRecuperationMeetingAndSendingOffNone = new ACRadioButtonItem();

      shortStayHospitalRecuperationMeetingAndSendingOffNone.setText("���}�Ȃ�");

      shortStayHospitalRecuperationMeetingAndSendingOffNone.setGroup(getShortStayHospitalRecuperationMeetingAndSendingOff());

      shortStayHospitalRecuperationMeetingAndSendingOffNone.setConstraints(VRLayout.FLOW);

      addShortStayHospitalRecuperationMeetingAndSendingOffNone();
    }
    return shortStayHospitalRecuperationMeetingAndSendingOffNone;

  }

  /**
   * ���}�Г����擾���܂��B
   * @return ���}�Г�
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationMeetingAndSendingOffOneWay(){
    if(shortStayHospitalRecuperationMeetingAndSendingOffOneWay==null){

      shortStayHospitalRecuperationMeetingAndSendingOffOneWay = new ACRadioButtonItem();

      shortStayHospitalRecuperationMeetingAndSendingOffOneWay.setText("���}�Г�");

      shortStayHospitalRecuperationMeetingAndSendingOffOneWay.setGroup(getShortStayHospitalRecuperationMeetingAndSendingOff());

      shortStayHospitalRecuperationMeetingAndSendingOffOneWay.setConstraints(VRLayout.FLOW);

      addShortStayHospitalRecuperationMeetingAndSendingOffOneWay();
    }
    return shortStayHospitalRecuperationMeetingAndSendingOffOneWay;

  }

  /**
   * ���}�������擾���܂��B
   * @return ���}����
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationMeetingAndSendingOffRoundTrip(){
    if(shortStayHospitalRecuperationMeetingAndSendingOffRoundTrip==null){

      shortStayHospitalRecuperationMeetingAndSendingOffRoundTrip = new ACRadioButtonItem();

      shortStayHospitalRecuperationMeetingAndSendingOffRoundTrip.setText("���}����");

      shortStayHospitalRecuperationMeetingAndSendingOffRoundTrip.setGroup(getShortStayHospitalRecuperationMeetingAndSendingOff());

      shortStayHospitalRecuperationMeetingAndSendingOffRoundTrip.setConstraints(VRLayout.FLOW);

      addShortStayHospitalRecuperationMeetingAndSendingOffRoundTrip();
    }
    return shortStayHospitalRecuperationMeetingAndSendingOffRoundTrip;

  }

  /**
   * �×{�H���Z���擾���܂��B
   * @return �×{�H���Z
   */
  public ACValueArrayRadioButtonGroup getShortStayHospitalRecuperationMedicalExpensesRadio(){
    if(shortStayHospitalRecuperationMedicalExpensesRadio==null){

      shortStayHospitalRecuperationMedicalExpensesRadio = new ACValueArrayRadioButtonGroup();

      getShortStayHospitalRecuperationMedicalExpensesRadioContainer().setText("�×{�H���Z");

      shortStayHospitalRecuperationMedicalExpensesRadio.setBindPath("20430118");

      shortStayHospitalRecuperationMedicalExpensesRadio.setUseClearButton(false);

      shortStayHospitalRecuperationMedicalExpensesRadio.setModel(getShortStayHospitalRecuperationMedicalExpensesRadioModel());

      shortStayHospitalRecuperationMedicalExpensesRadio.setValues(new int[]{1,2,3,4});

      addShortStayHospitalRecuperationMedicalExpensesRadio();
    }
    return shortStayHospitalRecuperationMedicalExpensesRadio;

  }

  /**
   * �×{�H���Z�R���e�i���擾���܂��B
   * @return �×{�H���Z�R���e�i
   */
  protected ACLabelContainer getShortStayHospitalRecuperationMedicalExpensesRadioContainer(){
    if(shortStayHospitalRecuperationMedicalExpensesRadioContainer==null){
      shortStayHospitalRecuperationMedicalExpensesRadioContainer = new ACLabelContainer();
      shortStayHospitalRecuperationMedicalExpensesRadioContainer.setFollowChildEnabled(true);
      shortStayHospitalRecuperationMedicalExpensesRadioContainer.setVAlignment(VRLayout.CENTER);
      shortStayHospitalRecuperationMedicalExpensesRadioContainer.add(getShortStayHospitalRecuperationMedicalExpensesRadio(), null);
    }
    return shortStayHospitalRecuperationMedicalExpensesRadioContainer;
  }

  /**
   * �×{�H���Z���f�����擾���܂��B
   * @return �×{�H���Z���f��
   */
  protected ACListModelAdapter getShortStayHospitalRecuperationMedicalExpensesRadioModel(){
    if(shortStayHospitalRecuperationMedicalExpensesRadioModel==null){
      shortStayHospitalRecuperationMedicalExpensesRadioModel = new ACListModelAdapter();
      addShortStayHospitalRecuperationMedicalExpensesRadioModel();
    }
    return shortStayHospitalRecuperationMedicalExpensesRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationMedicalExpensesRadioItem1(){
    if(shortStayHospitalRecuperationMedicalExpensesRadioItem1==null){

      shortStayHospitalRecuperationMedicalExpensesRadioItem1 = new ACRadioButtonItem();

      shortStayHospitalRecuperationMedicalExpensesRadioItem1.setText("�Ȃ�");

      shortStayHospitalRecuperationMedicalExpensesRadioItem1.setGroup(getShortStayHospitalRecuperationMedicalExpensesRadio());

      shortStayHospitalRecuperationMedicalExpensesRadioItem1.setConstraints(VRLayout.FLOW);

      addShortStayHospitalRecuperationMedicalExpensesRadioItem1();
    }
    return shortStayHospitalRecuperationMedicalExpensesRadioItem1;

  }

  /**
   * 3����擾���܂��B
   * @return 3��
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationMedicalExpensesRadioItem2(){
    if(shortStayHospitalRecuperationMedicalExpensesRadioItem2==null){

      shortStayHospitalRecuperationMedicalExpensesRadioItem2 = new ACRadioButtonItem();

      shortStayHospitalRecuperationMedicalExpensesRadioItem2.setText("3��");

      shortStayHospitalRecuperationMedicalExpensesRadioItem2.setGroup(getShortStayHospitalRecuperationMedicalExpensesRadio());

      shortStayHospitalRecuperationMedicalExpensesRadioItem2.setConstraints(VRLayout.FLOW);

      addShortStayHospitalRecuperationMedicalExpensesRadioItem2();
    }
    return shortStayHospitalRecuperationMedicalExpensesRadioItem2;

  }

  /**
   * 2����擾���܂��B
   * @return 2��
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationMedicalExpensesRadioItem3(){
    if(shortStayHospitalRecuperationMedicalExpensesRadioItem3==null){

      shortStayHospitalRecuperationMedicalExpensesRadioItem3 = new ACRadioButtonItem();

      shortStayHospitalRecuperationMedicalExpensesRadioItem3.setText("2��");

      shortStayHospitalRecuperationMedicalExpensesRadioItem3.setGroup(getShortStayHospitalRecuperationMedicalExpensesRadio());

      shortStayHospitalRecuperationMedicalExpensesRadioItem3.setConstraints(VRLayout.FLOW);

      addShortStayHospitalRecuperationMedicalExpensesRadioItem3();
    }
    return shortStayHospitalRecuperationMedicalExpensesRadioItem3;

  }

  /**
   * 1����擾���܂��B
   * @return 1��
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationMedicalExpensesRadioItem4(){
    if(shortStayHospitalRecuperationMedicalExpensesRadioItem4==null){

      shortStayHospitalRecuperationMedicalExpensesRadioItem4 = new ACRadioButtonItem();

      shortStayHospitalRecuperationMedicalExpensesRadioItem4.setText("1��");

      shortStayHospitalRecuperationMedicalExpensesRadioItem4.setGroup(getShortStayHospitalRecuperationMedicalExpensesRadio());

      shortStayHospitalRecuperationMedicalExpensesRadioItem4.setConstraints(VRLayout.FLOW);

      addShortStayHospitalRecuperationMedicalExpensesRadioItem4();
    }
    return shortStayHospitalRecuperationMedicalExpensesRadioItem4;

  }

  /**
   * �ً}�����ÊǗ����擾���܂��B
   * @return �ً}�����ÊǗ�
   */
  public ACValueArrayRadioButtonGroup getEmergencyTreatmentManagementRadio(){
    if(emergencyTreatmentManagementRadio==null){

      emergencyTreatmentManagementRadio = new ACValueArrayRadioButtonGroup();

      getEmergencyTreatmentManagementRadioContainer().setText("�ً}�����ÊǗ�");

      emergencyTreatmentManagementRadio.setBindPath("20430119");

      emergencyTreatmentManagementRadio.setUseClearButton(false);

      emergencyTreatmentManagementRadio.setModel(getEmergencyTreatmentManagementRadioModel());

      emergencyTreatmentManagementRadio.setValues(new int[]{1,2});

      addEmergencyTreatmentManagementRadio();
    }
    return emergencyTreatmentManagementRadio;

  }

  /**
   * �ً}�����ÊǗ��R���e�i���擾���܂��B
   * @return �ً}�����ÊǗ��R���e�i
   */
  protected ACLabelContainer getEmergencyTreatmentManagementRadioContainer(){
    if(emergencyTreatmentManagementRadioContainer==null){
      emergencyTreatmentManagementRadioContainer = new ACLabelContainer();
      emergencyTreatmentManagementRadioContainer.setFollowChildEnabled(true);
      emergencyTreatmentManagementRadioContainer.setVAlignment(VRLayout.CENTER);
      emergencyTreatmentManagementRadioContainer.add(getEmergencyTreatmentManagementRadio(), null);
    }
    return emergencyTreatmentManagementRadioContainer;
  }

  /**
   * �ً}�����ÊǗ����f�����擾���܂��B
   * @return �ً}�����ÊǗ����f��
   */
  protected ACListModelAdapter getEmergencyTreatmentManagementRadioModel(){
    if(emergencyTreatmentManagementRadioModel==null){
      emergencyTreatmentManagementRadioModel = new ACListModelAdapter();
      addEmergencyTreatmentManagementRadioModel();
    }
    return emergencyTreatmentManagementRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getEmergencyTreatmentManagementItem1(){
    if(emergencyTreatmentManagementItem1==null){

      emergencyTreatmentManagementItem1 = new ACRadioButtonItem();

      emergencyTreatmentManagementItem1.setText("�Ȃ�");

      emergencyTreatmentManagementItem1.setGroup(getEmergencyTreatmentManagementRadio());

      emergencyTreatmentManagementItem1.setConstraints(VRLayout.FLOW);

      addEmergencyTreatmentManagementItem1();
    }
    return emergencyTreatmentManagementItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getEmergencyTreatmentManagementItem2(){
    if(emergencyTreatmentManagementItem2==null){

      emergencyTreatmentManagementItem2 = new ACRadioButtonItem();

      emergencyTreatmentManagementItem2.setText("����");

      emergencyTreatmentManagementItem2.setGroup(getEmergencyTreatmentManagementRadio());

      emergencyTreatmentManagementItem2.setConstraints(VRLayout.FLOW);

      addEmergencyTreatmentManagementItem2();
    }
    return emergencyTreatmentManagementItem2;

  }

  /**
   * �F�m�ǐ��P�A���Z���擾���܂��B
   * @return �F�m�ǐ��P�A���Z
   */
  public ACValueArrayRadioButtonGroup getDementiaProfessionalCareAddRadioGroup(){
    if(dementiaProfessionalCareAddRadioGroup==null){

      dementiaProfessionalCareAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getDementiaProfessionalCareAddRadioGroupContainer().setText("�F�m�ǐ��P�A���Z");

      dementiaProfessionalCareAddRadioGroup.setBindPath("20430120");

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
   * �^�u4���擾���܂��B
   * @return �^�u4
   */
  public ACPanel getTab4(){
    if(tab4==null){

      tab4 = new ACPanel();

      tab4.setFollowChildEnabled(true);

      tab4.setHgap(0);

      addTab4();
    }
    return tab4;

  }

  /**
   * ���ʐf�Ô�{�^�����擾���܂��B
   * @return ���ʐf�Ô�{�^��
   */
  public ACMapBindButton getShortStayHospitalRecuperationSpecificConsultationFee(){
    if(shortStayHospitalRecuperationSpecificConsultationFee==null){

      shortStayHospitalRecuperationSpecificConsultationFee = new ACMapBindButton();

      shortStayHospitalRecuperationSpecificConsultationFee.setText("���ʐf�Ô�");

      shortStayHospitalRecuperationSpecificConsultationFee.setToolTipText("���ʐf�Ô��ݒ肵�܂��B");

      addShortStayHospitalRecuperationSpecificConsultationFee();
    }
    return shortStayHospitalRecuperationSpecificConsultationFee;

  }

  /**
   * �ݒ胉�x�����擾���܂��B
   * @return �ݒ胉�x��
   */
  public ACLabel getShortStayHospitalRecuperationSpecificConsultationFeeOutline(){
    if(shortStayHospitalRecuperationSpecificConsultationFeeOutline==null){

      shortStayHospitalRecuperationSpecificConsultationFeeOutline = new ACLabel();

      shortStayHospitalRecuperationSpecificConsultationFeeOutline.setText("�ݒ�Ȃ�");

      shortStayHospitalRecuperationSpecificConsultationFeeOutline.setOpaque(true);
      shortStayHospitalRecuperationSpecificConsultationFeeOutline.setBackground(new Color(255,255,172));

      addShortStayHospitalRecuperationSpecificConsultationFeeOutline();
    }
    return shortStayHospitalRecuperationSpecificConsultationFeeOutline;

  }

  /**
   * �T�[�r�X�񋟑̐��������Z���擾���܂��B
   * @return �T�[�r�X�񋟑̐��������Z
   */
  public ACValueArrayRadioButtonGroup getServiceAddProvisionStructuralRadioGroup(){
    if(serviceAddProvisionStructuralRadioGroup==null){

      serviceAddProvisionStructuralRadioGroup = new ACValueArrayRadioButtonGroup();

      getServiceAddProvisionStructuralRadioGroupContainer().setText("�T�[�r�X�񋟑̐��������Z");

      serviceAddProvisionStructuralRadioGroup.setBindPath("20430122");

      serviceAddProvisionStructuralRadioGroup.setNoSelectIndex(0);

      serviceAddProvisionStructuralRadioGroup.setUseClearButton(false);

      serviceAddProvisionStructuralRadioGroup.setModel(getServiceAddProvisionStructuralRadioGroupModel());

      serviceAddProvisionStructuralRadioGroup.setValues(new int[]{1,5,2,3,4});

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
  public ACRadioButtonItem getServiceAddProvisionStructuralRadioItem5(){
    if(serviceAddProvisionStructuralRadioItem5==null){

      serviceAddProvisionStructuralRadioItem5 = new ACRadioButtonItem();

      serviceAddProvisionStructuralRadioItem5.setText("I�C�^");

      serviceAddProvisionStructuralRadioItem5.setGroup(getServiceAddProvisionStructuralRadioGroup());

      serviceAddProvisionStructuralRadioItem5.setConstraints(VRLayout.FLOW_RETURN);

      addServiceAddProvisionStructuralRadioItem5();
    }
    return serviceAddProvisionStructuralRadioItem5;

  }

  /**
   * I���^���擾���܂��B
   * @return I���^
   */
  public ACRadioButtonItem getServiceAddProvisionStructuralRadioItem2(){
    if(serviceAddProvisionStructuralRadioItem2==null){

      serviceAddProvisionStructuralRadioItem2 = new ACRadioButtonItem();

      serviceAddProvisionStructuralRadioItem2.setText("I���^");

      serviceAddProvisionStructuralRadioItem2.setGroup(getServiceAddProvisionStructuralRadioGroup());

      serviceAddProvisionStructuralRadioItem2.setConstraints(VRLayout.FLOW);

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
   * �H���R���e�i���擾���܂��B
   * @return �H���R���e�i
   */
  public ACBackLabelContainer getShortStayRecuperationHealthFacilityDinnerContainer(){
    if(shortStayRecuperationHealthFacilityDinnerContainer==null){

      shortStayRecuperationHealthFacilityDinnerContainer = new ACBackLabelContainer();

      shortStayRecuperationHealthFacilityDinnerContainer.setFollowChildEnabled(true);

      addShortStayRecuperationHealthFacilityDinnerContainer();
    }
    return shortStayRecuperationHealthFacilityDinnerContainer;

  }

  /**
   * �H���񋟂��擾���܂��B
   * @return �H����
   */
  public ACComboBox getShortStayRecuperationHealthFacilityDinnerOffer(){
    if(shortStayRecuperationHealthFacilityDinnerOffer==null){

      shortStayRecuperationHealthFacilityDinnerOffer = new ACComboBox();

      getShortStayRecuperationHealthFacilityDinnerOfferContainer().setText("�H����");

      shortStayRecuperationHealthFacilityDinnerOffer.setBindPath("20430123");

      shortStayRecuperationHealthFacilityDinnerOffer.setEditable(false);

      shortStayRecuperationHealthFacilityDinnerOffer.setModelBindPath("20430123");

      shortStayRecuperationHealthFacilityDinnerOffer.setRenderBindPath("CONTENT");

      shortStayRecuperationHealthFacilityDinnerOffer.setModel(getShortStayRecuperationHealthFacilityDinnerOfferModel());

      addShortStayRecuperationHealthFacilityDinnerOffer();
    }
    return shortStayRecuperationHealthFacilityDinnerOffer;

  }

  /**
   * �H���񋟃R���e�i���擾���܂��B
   * @return �H���񋟃R���e�i
   */
  protected ACLabelContainer getShortStayRecuperationHealthFacilityDinnerOfferContainer(){
    if(shortStayRecuperationHealthFacilityDinnerOfferContainer==null){
      shortStayRecuperationHealthFacilityDinnerOfferContainer = new ACLabelContainer();
      shortStayRecuperationHealthFacilityDinnerOfferContainer.setFollowChildEnabled(true);
      shortStayRecuperationHealthFacilityDinnerOfferContainer.setVAlignment(VRLayout.CENTER);
      shortStayRecuperationHealthFacilityDinnerOfferContainer.add(getShortStayRecuperationHealthFacilityDinnerOffer(), null);
    }
    return shortStayRecuperationHealthFacilityDinnerOfferContainer;
  }

  /**
   * �H���񋟃��f�����擾���܂��B
   * @return �H���񋟃��f��
   */
  protected ACComboBoxModelAdapter getShortStayRecuperationHealthFacilityDinnerOfferModel(){
    if(shortStayRecuperationHealthFacilityDinnerOfferModel==null){
      shortStayRecuperationHealthFacilityDinnerOfferModel = new ACComboBoxModelAdapter();
      addShortStayRecuperationHealthFacilityDinnerOfferModel();
    }
    return shortStayRecuperationHealthFacilityDinnerOfferModel;
  }

  /**
   * �H����p���擾���܂��B
   * @return �H����p
   */
  public ACTextField getShortStayRecuperationHealthFacilityDinnerCost(){
    if(shortStayRecuperationHealthFacilityDinnerCost==null){

      shortStayRecuperationHealthFacilityDinnerCost = new ACTextField();

      getShortStayRecuperationHealthFacilityDinnerCostContainer().setText("�H����p");

      shortStayRecuperationHealthFacilityDinnerCost.setBindPath("20430124");

      shortStayRecuperationHealthFacilityDinnerCost.setColumns(4);

      shortStayRecuperationHealthFacilityDinnerCost.setCharType(VRCharType.ONLY_DIGIT);

      shortStayRecuperationHealthFacilityDinnerCost.setHorizontalAlignment(SwingConstants.RIGHT);

      shortStayRecuperationHealthFacilityDinnerCost.setIMEMode(InputSubset.LATIN);

      shortStayRecuperationHealthFacilityDinnerCost.setMaxLength(5);

      addShortStayRecuperationHealthFacilityDinnerCost();
    }
    return shortStayRecuperationHealthFacilityDinnerCost;

  }

  /**
   * �H����p�R���e�i���擾���܂��B
   * @return �H����p�R���e�i
   */
  protected ACLabelContainer getShortStayRecuperationHealthFacilityDinnerCostContainer(){
    if(shortStayRecuperationHealthFacilityDinnerCostContainer==null){
      shortStayRecuperationHealthFacilityDinnerCostContainer = new ACLabelContainer();
      shortStayRecuperationHealthFacilityDinnerCostContainer.setFollowChildEnabled(true);
      shortStayRecuperationHealthFacilityDinnerCostContainer.setVAlignment(VRLayout.CENTER);
      shortStayRecuperationHealthFacilityDinnerCostContainer.add(getShortStayRecuperationHealthFacilityDinnerCost(), null);
    }
    return shortStayRecuperationHealthFacilityDinnerCostContainer;
  }

  /**
   * 30�������擾���܂��B
   * @return 30����
   */
  public ACIntegerCheckBox getShortStayHospitalRecuperationEtc30Over(){
    if(shortStayHospitalRecuperationEtc30Over==null){

      shortStayHospitalRecuperationEtc30Over = new ACIntegerCheckBox();

      shortStayHospitalRecuperationEtc30Over.setText("30����");

      shortStayHospitalRecuperationEtc30Over.setBindPath("5");

      shortStayHospitalRecuperationEtc30Over.setSelectValue(2);

      shortStayHospitalRecuperationEtc30Over.setUnSelectValue(1);

      addShortStayHospitalRecuperationEtc30Over();
    }
    return shortStayHospitalRecuperationEtc30Over;

  }

  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001_204311_201804Design() {

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

  }

  /**
   * �^�u1�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTab1(){

    tab1.add(getShortStayHospitalRecuperationInstitutionDivisionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getStaffAssignmentDivisionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getShortStayHospitalRecuperationHospitalRoomContena(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * �{�ݓ��̋敪�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationInstitutionDivisionRadio(){

  }

  /**
   * �{�ݓ��̋敪���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationInstitutionDivisionRadioModel(){

    getShortStayHospitalRecuperationInstitutionDivisionRadioItem1().setButtonIndex(1);

    getShortStayHospitalRecuperationInstitutionDivisionRadioModel().add(getShortStayHospitalRecuperationInstitutionDivisionRadioItem1());

    getShortStayHospitalRecuperationInstitutionDivisionRadioItem2().setButtonIndex(2);

    getShortStayHospitalRecuperationInstitutionDivisionRadioModel().add(getShortStayHospitalRecuperationInstitutionDivisionRadioItem2());

    getShortStayHospitalRecuperationInstitutionDivisionRadioItem3().setButtonIndex(3);

    getShortStayHospitalRecuperationInstitutionDivisionRadioModel().add(getShortStayHospitalRecuperationInstitutionDivisionRadioItem3());

    getShortStayHospitalRecuperationInstitutionDivisionRadioItem4().setButtonIndex(4);

    getShortStayHospitalRecuperationInstitutionDivisionRadioModel().add(getShortStayHospitalRecuperationInstitutionDivisionRadioItem4());

    getShortStayHospitalRecuperationInstitutionDivisionRadioItem5().setButtonIndex(5);

    getShortStayHospitalRecuperationInstitutionDivisionRadioModel().add(getShortStayHospitalRecuperationInstitutionDivisionRadioItem5());

    getShortStayHospitalRecuperationInstitutionDivisionRadioItem6().setButtonIndex(6);

    getShortStayHospitalRecuperationInstitutionDivisionRadioModel().add(getShortStayHospitalRecuperationInstitutionDivisionRadioItem6());

  }

  /**
   * I�^����É@�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationInstitutionDivisionRadioItem1(){

  }

  /**
   * II�^����É@�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationInstitutionDivisionRadioItem2(){

  }

  /**
   * ���ʉ���É@�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationInstitutionDivisionRadioItem3(){

  }

  /**
   * ���j�b�g�^I�^����É@�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationInstitutionDivisionRadioItem4(){

  }

  /**
   * ���j�b�g�^II�^����É@�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationInstitutionDivisionRadioItem5(){

  }

  /**
   * ���j�b�g�^���ʉ���É@�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationInstitutionDivisionRadioItem6(){

  }

  /**
   * �l���z�u�敪�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffAssignmentDivisionContainer(){

    staffAssignmentDivisionContainer.add(getStaffAssignment1Division(), VRLayout.FLOW_INSETLINE_RETURN);

    staffAssignmentDivisionContainer.add(getStaffAssignment2Division(), VRLayout.FLOW_INSETLINE_RETURN);

    staffAssignmentDivisionContainer.add(getStaffAssignment3Division(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * �l���z�u�敪���W�I�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffAssignment1Division(){

  }

  /**
   * �l���z�u�敪���W�I�O���[�v���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffAssignment1DivisionModel(){

    getStaffAssignmentDivisionItem1().setButtonIndex(1);

    getStaffAssignment1DivisionModel().add(getStaffAssignmentDivisionItem1());

    getStaffAssignmentDivisionItem2().setButtonIndex(2);

    getStaffAssignment1DivisionModel().add(getStaffAssignmentDivisionItem2());

    getStaffAssignmentDivisionItem3().setButtonIndex(3);

    getStaffAssignment1DivisionModel().add(getStaffAssignmentDivisionItem3());

  }

  /**
   * I�^�iI�j�ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffAssignmentDivisionItem1(){

  }

  /**
   * I�^�iII�j�ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffAssignmentDivisionItem2(){

  }

  /**
   * I�^�iIII�j�ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffAssignmentDivisionItem3(){

  }

  /**
   * �l���z�u�敪�ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffAssignment2Division(){

  }

  /**
   * �l���z�u�敪���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffAssignment2DivisionModel(){

    getStaffAssignmentDivisionItem4().setButtonIndex(1);

    getStaffAssignment2DivisionModel().add(getStaffAssignmentDivisionItem4());

    getStaffAssignmentDivisionItem5().setButtonIndex(2);

    getStaffAssignment2DivisionModel().add(getStaffAssignmentDivisionItem5());

    getStaffAssignmentDivisionItem6().setButtonIndex(3);

    getStaffAssignment2DivisionModel().add(getStaffAssignmentDivisionItem6());

  }

  /**
   * II�^�iI�j�ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffAssignmentDivisionItem4(){

  }

  /**
   * II�^�iII�j�ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffAssignmentDivisionItem5(){

  }

  /**
   * II�^�iIII�j�ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffAssignmentDivisionItem6(){

  }

  /**
   * �l���z�u�敪�ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffAssignment3Division(){

  }

  /**
   * �l���z�u�敪���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffAssignment3DivisionModel(){

    getStaffAssignmentDivisionItem7().setButtonIndex(1);

    getStaffAssignment3DivisionModel().add(getStaffAssignmentDivisionItem7());

    getStaffAssignmentDivisionItem8().setButtonIndex(2);

    getStaffAssignment3DivisionModel().add(getStaffAssignmentDivisionItem8());

  }

  /**
   * I�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffAssignmentDivisionItem7(){

  }

  /**
   * II�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffAssignmentDivisionItem8(){

  }

  /**
   * �a���敪�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationHospitalRoomContena(){

    shortStayHospitalRecuperationHospitalRoomContena.add(getShortStayHospitalRecuperationHospitalRoomRadio(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayHospitalRecuperationHospitalRoomContena.add(getShortStayHospitalRecuperationUnitHospitalRoomRadio(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * �a���敪�i�a���j�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationHospitalRoomRadio(){

  }

  /**
   * �a���敪�i�a���j���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationHospitalRoomRadioModel(){

    getShortStayHospitalRecuperationHospitalRoomRadioItem1().setButtonIndex(1);

    getShortStayHospitalRecuperationHospitalRoomRadioModel().add(getShortStayHospitalRecuperationHospitalRoomRadioItem1());

    getShortStayHospitalRecuperationHospitalRoomRadioItem2().setButtonIndex(2);

    getShortStayHospitalRecuperationHospitalRoomRadioModel().add(getShortStayHospitalRecuperationHospitalRoomRadioItem2());

  }

  /**
   * �]���^���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationHospitalRoomRadioItem1(){

  }

  /**
   * �������ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationHospitalRoomRadioItem2(){

  }

  /**
   * �a���敪�i���j�b�g�^�a�@�j�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationUnitHospitalRoomRadio(){

  }

  /**
   * �a���敪�i���j�b�g�^�a�@�j���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationUnitHospitalRoomRadioModel(){

    getShortStayHospitalRecuperationUnitHospitalRoomRadioItem1().setButtonIndex(1);

    getShortStayHospitalRecuperationUnitHospitalRoomRadioModel().add(getShortStayHospitalRecuperationUnitHospitalRoomRadioItem1());

    getShortStayHospitalRecuperationUnitHospitalRoomRadioItem2().setButtonIndex(2);

    getShortStayHospitalRecuperationUnitHospitalRoomRadioModel().add(getShortStayHospitalRecuperationUnitHospitalRoomRadioItem2());

  }

  /**
   * ���j�b�g�^���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationUnitHospitalRoomRadioItem1(){

  }

  /**
   * ���j�b�g�^���I�������ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationUnitHospitalRoomRadioItem2(){

  }

  /**
   * �^�u2�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTab2(){

    tab2.add(getShortStayHospitalRecuperationUnitCareMaintenanceRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getShortStayHospitalRecuperationAdditionTypeContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getEnvironmentalCorridorRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getEnvironmentalRecuperationRoomRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getShortStayHospitalRecuperationTypeContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getMedicalFacilityHospitalSubstractionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * ���j�b�g�P�A�̐����ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationUnitCareMaintenanceRadio(){

  }

  /**
   * ���j�b�g�P�A�̐������f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationUnitCareMaintenanceRadioModel(){

    getShortStayHospitalRecuperationUnitCareMaintenanceRadioItem1().setButtonIndex(1);

    getShortStayHospitalRecuperationUnitCareMaintenanceRadioModel().add(getShortStayHospitalRecuperationUnitCareMaintenanceRadioItem1());

    getShortStayHospitalRecuperationUnitCareMaintenanceRadioItem2().setButtonIndex(2);

    getShortStayHospitalRecuperationUnitCareMaintenanceRadioModel().add(getShortStayHospitalRecuperationUnitCareMaintenanceRadioItem2());

  }

  /**
   * �������ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationUnitCareMaintenanceRadioItem1(){

  }

  /**
   * �����ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationUnitCareMaintenanceRadioItem2(){

  }

  /**
   * ��ԋΖ����Ō���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationAdditionType(){

  }

  /**
   * ��ԋΖ����Ō���Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationAdditionTypeModel(){

    getShortStayHospitalRecuperationAdditionType1().setButtonIndex(1);

    getShortStayHospitalRecuperationAdditionTypeModel().add(getShortStayHospitalRecuperationAdditionType1());

    getShortStayHospitalRecuperationAdditionType2().setButtonIndex(2);

    getShortStayHospitalRecuperationAdditionTypeModel().add(getShortStayHospitalRecuperationAdditionType2());

    getShortStayHospitalRecuperationAdditionType3().setButtonIndex(3);

    getShortStayHospitalRecuperationAdditionTypeModel().add(getShortStayHospitalRecuperationAdditionType3());

    getShortStayHospitalRecuperationAdditionType4().setButtonIndex(4);

    getShortStayHospitalRecuperationAdditionTypeModel().add(getShortStayHospitalRecuperationAdditionType4());

    getShortStayHospitalRecuperationAdditionType5().setButtonIndex(5);

    getShortStayHospitalRecuperationAdditionTypeModel().add(getShortStayHospitalRecuperationAdditionType5());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationAdditionType1(){

  }

  /**
   * I�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationAdditionType2(){

  }

  /**
   * II�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationAdditionType3(){

  }

  /**
   * III�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationAdditionType4(){

  }

  /**
   * IV�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationAdditionType5(){

  }

  /**
   * �×{����i�L���j�ɓ������ڂ�ǉ����܂��B
   */
  protected void addEnvironmentalCorridorRadio(){

  }

  /**
   * �×{����i�L���j���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addEnvironmentalCorridorRadioModel(){

    getEnvironmentalCorridorRadioItem1().setButtonIndex(1);

    getEnvironmentalCorridorRadioModel().add(getEnvironmentalCorridorRadioItem1());

    getEnvironmentalCorridorRadioItem2().setButtonIndex(2);

    getEnvironmentalCorridorRadioModel().add(getEnvironmentalCorridorRadioItem2());

  }

  /**
   * ��^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addEnvironmentalCorridorRadioItem1(){

  }

  /**
   * ���Z�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addEnvironmentalCorridorRadioItem2(){

  }

  /**
   * �×{����i�×{���j�ɓ������ڂ�ǉ����܂��B
   */
  protected void addEnvironmentalRecuperationRoomRadio(){

  }

  /**
   * �×{����i�×{���j���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addEnvironmentalRecuperationRoomRadioModel(){

    getEnvironmentalRecuperationRoomRadioItem1().setButtonIndex(1);

    getEnvironmentalRecuperationRoomRadioModel().add(getEnvironmentalRecuperationRoomRadioItem1());

    getEnvironmentalRecuperationRoomRadioItem2().setButtonIndex(2);

    getEnvironmentalRecuperationRoomRadioModel().add(getEnvironmentalRecuperationRoomRadioItem2());

  }

  /**
   * ��^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addEnvironmentalRecuperationRoomRadioItem1(){

  }

  /**
   * ���Z�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addEnvironmentalRecuperationRoomRadioItem2(){

  }

  /**
   * ��ԋΖ�������ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationType(){

  }

  /**
   * ��ԋΖ���������f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationTypeModel(){

    getShortStayHospitalRecuperationTypeNormal().setButtonIndex(1);

    getShortStayHospitalRecuperationTypeModel().add(getShortStayHospitalRecuperationTypeNormal());

    getShortStayHospitalRecuperationTypeNone().setButtonIndex(2);

    getShortStayHospitalRecuperationTypeModel().add(getShortStayHospitalRecuperationTypeNone());

  }

  /**
   * �ʏ�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationTypeNormal(){

  }

  /**
   * ���Z�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationTypeNone(){

  }

  /**
   * �E�����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityHospitalSubstraction(){

  }

  /**
   * �E�����Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityHospitalSubstractionModel(){

    getMedicalFacilityHospitalSubstractionItem1().setButtonIndex(1);

    getMedicalFacilityHospitalSubstractionModel().add(getMedicalFacilityHospitalSubstractionItem1());

    getMedicalFacilityHospitalSubstractionItem2().setButtonIndex(2);

    getMedicalFacilityHospitalSubstractionModel().add(getMedicalFacilityHospitalSubstractionItem2());

    getMedicalFacilityHospitalSubstractionItem3().setButtonIndex(3);

    getMedicalFacilityHospitalSubstractionModel().add(getMedicalFacilityHospitalSubstractionItem3());

    getMedicalFacilityHospitalSubstractionItem4().setButtonIndex(4);

    getMedicalFacilityHospitalSubstractionModel().add(getMedicalFacilityHospitalSubstractionItem4());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityHospitalSubstractionItem1(){

  }

  /**
   * ������߂ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityHospitalSubstractionItem2(){

  }

  /**
   * ��t�E��܎t�E�Ō�E���E���E���̕s���ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityHospitalSubstractionItem3(){

  }

  /**
   * ���Ŕ䗦��20�������ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityHospitalSubstractionItem4(){

  }

  /**
   * �^�u3�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTab3(){

    tab3.add(getDementiaActionAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab3.add(getYoungDementiaPatinetAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab3.add(getShortStayHospitalRecuperationMeetingAndSendingOffContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab3.add(getShortStayHospitalRecuperationMedicalExpensesRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab3.add(getEmergencyTreatmentManagementRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab3.add(getDementiaProfessionalCareAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * �F�m�Ǎs���E�S���Ǐ�ً}�Ή����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addDementiaActionAddRadioGroup(){

  }

  /**
   * �F�m�Ǎs���E�S���Ǐ�ً}�Ή����Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addDementiaActionAddRadioGroupModel(){

    getDementiaActionAddRadioItem1().setButtonIndex(1);

    getDementiaActionAddRadioGroupModel().add(getDementiaActionAddRadioItem1());

    getDementiaActionAddRadioItem2().setButtonIndex(2);

    getDementiaActionAddRadioGroupModel().add(getDementiaActionAddRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addDementiaActionAddRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addDementiaActionAddRadioItem2(){

  }

  /**
   * ��N���F�m�Ǘ��p�Ҏ�����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addYoungDementiaPatinetAddRadioGroup(){

  }

  /**
   * ��N���F�m�Ǘ��p�Ҏ�����Z���f���ɓ������ڂ�ǉ����܂��B
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
   * ���}���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationMeetingAndSendingOff(){

  }

  /**
   * ���}���Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationMeetingAndSendingOffModel(){

    getShortStayHospitalRecuperationMeetingAndSendingOffNone().setButtonIndex(1);

    getShortStayHospitalRecuperationMeetingAndSendingOffModel().add(getShortStayHospitalRecuperationMeetingAndSendingOffNone());

    getShortStayHospitalRecuperationMeetingAndSendingOffOneWay().setButtonIndex(2);

    getShortStayHospitalRecuperationMeetingAndSendingOffModel().add(getShortStayHospitalRecuperationMeetingAndSendingOffOneWay());

    getShortStayHospitalRecuperationMeetingAndSendingOffRoundTrip().setButtonIndex(3);

    getShortStayHospitalRecuperationMeetingAndSendingOffModel().add(getShortStayHospitalRecuperationMeetingAndSendingOffRoundTrip());

  }

  /**
   * ���}�Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationMeetingAndSendingOffNone(){

  }

  /**
   * ���}�Г��ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationMeetingAndSendingOffOneWay(){

  }

  /**
   * ���}�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationMeetingAndSendingOffRoundTrip(){

  }

  /**
   * �×{�H���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationMedicalExpensesRadio(){

  }

  /**
   * �×{�H���Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationMedicalExpensesRadioModel(){

    getShortStayHospitalRecuperationMedicalExpensesRadioItem1().setButtonIndex(1);

    getShortStayHospitalRecuperationMedicalExpensesRadioModel().add(getShortStayHospitalRecuperationMedicalExpensesRadioItem1());

    getShortStayHospitalRecuperationMedicalExpensesRadioItem2().setButtonIndex(2);

    getShortStayHospitalRecuperationMedicalExpensesRadioModel().add(getShortStayHospitalRecuperationMedicalExpensesRadioItem2());

    getShortStayHospitalRecuperationMedicalExpensesRadioItem3().setButtonIndex(3);

    getShortStayHospitalRecuperationMedicalExpensesRadioModel().add(getShortStayHospitalRecuperationMedicalExpensesRadioItem3());

    getShortStayHospitalRecuperationMedicalExpensesRadioItem4().setButtonIndex(4);

    getShortStayHospitalRecuperationMedicalExpensesRadioModel().add(getShortStayHospitalRecuperationMedicalExpensesRadioItem4());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationMedicalExpensesRadioItem1(){

  }

  /**
   * 3��ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationMedicalExpensesRadioItem2(){

  }

  /**
   * 2��ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationMedicalExpensesRadioItem3(){

  }

  /**
   * 1��ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationMedicalExpensesRadioItem4(){

  }

  /**
   * �ً}�����ÊǗ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addEmergencyTreatmentManagementRadio(){

  }

  /**
   * �ً}�����ÊǗ����f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addEmergencyTreatmentManagementRadioModel(){

    getEmergencyTreatmentManagementItem1().setButtonIndex(1);

    getEmergencyTreatmentManagementRadioModel().add(getEmergencyTreatmentManagementItem1());

    getEmergencyTreatmentManagementItem2().setButtonIndex(2);

    getEmergencyTreatmentManagementRadioModel().add(getEmergencyTreatmentManagementItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addEmergencyTreatmentManagementItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addEmergencyTreatmentManagementItem2(){

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
   * �^�u4�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTab4(){

    tab4.add(getShortStayHospitalRecuperationSpecificConsultationFee(), VRLayout.FLOW);

    tab4.add(getShortStayHospitalRecuperationSpecificConsultationFeeOutline(), VRLayout.FLOW_RETURN);

    tab4.add(getServiceAddProvisionStructuralRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab4.add(getShortStayRecuperationHealthFacilityDinnerContainer(), VRLayout.FLOW_DOUBLEINSETLINE_RETURN);

    tab4.add(getShortStayHospitalRecuperationEtc30Over(), VRLayout.FLOW_INSETLINE);

  }

  /**
   * ���ʐf�Ô�{�^���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationSpecificConsultationFee(){

  }

  /**
   * �ݒ胉�x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationSpecificConsultationFeeOutline(){

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

    getServiceAddProvisionStructuralRadioItem5().setButtonIndex(5);

    getServiceAddProvisionStructuralRadioGroupModel().add(getServiceAddProvisionStructuralRadioItem5());

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
   * I�C�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceAddProvisionStructuralRadioItem5(){

  }

  /**
   * I���^�ɓ������ڂ�ǉ����܂��B
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
   * �H���R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperationHealthFacilityDinnerContainer(){

    shortStayRecuperationHealthFacilityDinnerContainer.add(getShortStayRecuperationHealthFacilityDinnerOfferContainer(), VRLayout.FLOW);

    shortStayRecuperationHealthFacilityDinnerContainer.add(getShortStayRecuperationHealthFacilityDinnerCostContainer(), VRLayout.FLOW);

  }

  /**
   * �H���񋟂ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperationHealthFacilityDinnerOffer(){

  }

  /**
   * �H���񋟃��f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperationHealthFacilityDinnerOfferModel(){

  }

  /**
   * �H����p�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperationHealthFacilityDinnerCost(){

  }

  /**
   * 30�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationEtc30Over(){

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
      ACFrame.debugStart(new ACAffairInfo(QS001_204311_201804Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QS001_204311_201804Design getThis() {
    return this;
  }
}
