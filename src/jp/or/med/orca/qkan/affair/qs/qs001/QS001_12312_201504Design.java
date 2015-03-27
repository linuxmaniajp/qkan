
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
 * �쐬��: 2015/03/13  ���{�R���s���[�^�[������� ����@��F �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �T�[�r�X�\��쐬/�ύX (S)
 * �v���Z�X �T�[�r�X�\��T�� (001)
 * �v���O���� �T�[�r�X�p�^�[���Z�������×{���i�f�Ï��×{�j (QS001_12312_201504)
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
 * �T�[�r�X�p�^�[���Z�������×{���i�f�Ï��×{�j��ʍ��ڃf�U�C��(QS001_12312_201504) 
 */
public class QS001_12312_201504Design extends QS001ServicePanel {
  //GUI�R���|�[�l���g

  private JTabbedPane tabs;

  private ACPanel tab1;

  private ACValueArrayRadioButtonGroup shortStayClinicRecuperationInstitutionDivisionRadio;

  private ACLabelContainer shortStayClinicRecuperationInstitutionDivisionRadioContainer;

  private ACListModelAdapter shortStayClinicRecuperationInstitutionDivisionRadioModel;

  private ACRadioButtonItem shortStayClinicRecuperationInstitutionDivisionRadioItem1;

  private ACRadioButtonItem shortStayClinicRecuperationInstitutionDivisionRadioItem2;

  private ACRadioButtonItem shortStayClinicRecuperationInstitutionDivisionRadioItem3;

  private ACLabelContainer staffAssignmentDivisionContainer;

  private ACValueArrayRadioButtonGroup staffAssignment1Division;

  private ACListModelAdapter staffAssignment1DivisionModel;

  private ACRadioButtonItem staffAssignmentDivisionItem1;

  private ACRadioButtonItem staffAssignmentDivisionItem2;

  private ACRadioButtonItem staffAssignmentDivisionItem3;

  private ACRadioButtonItem staffAssignmentDivisionItem4;

  private ACValueArrayRadioButtonGroup staffAssignment2Division;

  private ACListModelAdapter staffAssignment2DivisionModel;

  private ACRadioButtonItem staffAssignmentDivisionItem5;

  private ACRadioButtonItem staffAssignmentDivisionItem6;

  private ACRadioButtonItem staffAssignmentDivisionItem7;

  private ACLabelContainer shortStayClinicRecuperationHospitalRoomContena;

  private ACValueArrayRadioButtonGroup shortStayClinicRecuperationHospitalRoomRadio;

  private ACListModelAdapter shortStayClinicRecuperationHospitalRoomRadioModel;

  private ACRadioButtonItem shortStayClinicRecuperationHospitalRoomRadioItem1;

  private ACRadioButtonItem shortStayClinicRecuperationHospitalRoomRadioItem2;

  private ACValueArrayRadioButtonGroup shortStayClinicRecuperationUnitHospitalRoomRadio;

  private ACListModelAdapter shortStayClinicRecuperationUnitHospitalRoomRadioModel;

  private ACRadioButtonItem shortStayClinicRecuperationUnitHospitalRoomRadioItem1;

  private ACRadioButtonItem shortStayClinicRecuperationUnitHospitalRoomRadioItem2;

  private ACValueArrayRadioButtonGroup shortStayClinicRecuperationSickroomDivisionRadio;

  private ACLabelContainer shortStayClinicRecuperationSickroomDivisionRadioContainer;

  private ACListModelAdapter shortStayClinicRecuperationSickroomDivisionRadioModel;

  private ACRadioButtonItem shortStayClinicRecuperationSickroomDivisionRadioItem1;

  private ACRadioButtonItem shortStayClinicRecuperationSickroomDivisionRadioItem2;

  private ACRadioButtonItem shortStayClinicRecuperationSickroomDivisionRadioItem3;

  private ACRadioButtonItem shortStayClinicRecuperationSickroomDivisionRadioItem4;

  private ACComboBox tankinyusyoTimeDivision;

  private ACLabelContainer tankinyusyoTimeDivisionContainer;

  private ACComboBoxModelAdapter tankinyusyoTimeDivisionModel;

  private ACValueArrayRadioButtonGroup shortStayClinicRecuperationSubtractionType;

  private ACLabelContainer shortStayClinicRecuperationSubtractionTypeContainer;

  private ACListModelAdapter shortStayClinicRecuperationSubtractionTypeModel;

  private ACRadioButtonItem shortStayClinicRecuperationSubtractionTypeNormal;

  private ACRadioButtonItem shortStayClinicRecuperationSubtractionType3;

  private ACValueArrayRadioButtonGroup shortStayClinicRecuperationProvisionBase;

  private ACLabelContainer shortStayClinicRecuperationProvisionBaseContainer;

  private ACListModelAdapter shortStayClinicRecuperationProvisionBaseModel;

  private ACRadioButtonItem shortStayClinicRecuperationProvisionBaseNormal;

  private ACRadioButtonItem shortStayClinicRecuperationProvisionBaseType1;

  private ACPanel tab2;

  private ACValueArrayRadioButtonGroup dementiaActionAddRadioGroup;

  private ACLabelContainer dementiaActionAddRadioGroupContainer;

  private ACListModelAdapter dementiaActionAddRadioGroupModel;

  private ACRadioButtonItem dementiaActionAddRadioItem1;

  private ACRadioButtonItem dementiaActionAddRadioItem2;

  private ACValueArrayRadioButtonGroup shortStayClinicRecuperationEmergencyNetworkAddRadio;

  private ACLabelContainer shortStayClinicRecuperationEmergencyNetworkAddRadioContainer;

  private ACListModelAdapter shortStayClinicRecuperationEmergencyNetworkAddRadioModel;

  private ACRadioButtonItem shortStayClinicRecuperationEmergencyNetworkAddRadioItem1;

  private ACRadioButtonItem shortStayClinicRecuperationEmergencyNetworkAddRadioItem2;

  private ACValueArrayRadioButtonGroup youngDementiaPatinetAddRadioGroup;

  private ACLabelContainer youngDementiaPatinetAddRadioGroupContainer;

  private ACListModelAdapter youngDementiaPatinetAddRadioGroupModel;

  private ACRadioButtonItem youngDementiaPatinetAddRadioItem1;

  private ACRadioButtonItem youngDementiaPatinetAddRadioItem2;

  private ACValueArrayRadioButtonGroup shortStayClinicRecuperationMeetingAndSendingOff;

  private ACLabelContainer shortStayClinicRecuperationMeetingAndSendingOffContainer;

  private ACListModelAdapter shortStayClinicRecuperationMeetingAndSendingOffModel;

  private ACRadioButtonItem shortStayClinicRecuperationMeetingAndSendingOffNone;

  private ACRadioButtonItem shortStayClinicRecuperationMeetingAndSendingOffOneWay;

  private ACRadioButtonItem shortStayClinicRecuperationMeetingAndSendingOffRoundTrip;

  private ACValueArrayRadioButtonGroup shortStayClinicRecuperationMedicalExpensesRadio;

  private ACLabelContainer shortStayClinicRecuperationMedicalExpensesRadioContainer;

  private ACListModelAdapter shortStayClinicRecuperationMedicalExpensesRadioModel;

  private ACRadioButtonItem shortStayClinicRecuperationMedicalExpensesRadioItem1;

  private ACRadioButtonItem shortStayClinicRecuperationMedicalExpensesRadioItem2;

  private ACValueArrayRadioButtonGroup shortStayClinicRecuperationStaffReduceRadio;

  private ACLabelContainer shortStayClinicRecuperationStaffReduceRadioContainer;

  private ACListModelAdapter shortStayClinicRecuperationStaffReduceRadioModel;

  private ACRadioButtonItem shortStayClinicRecuperationStaffReduceRadioItem1;

  private ACRadioButtonItem shortStayClinicRecuperationStaffReduceRadioItem2;

  private ACMapBindButton shortStayClinicRecuperationSpecificConsultationFee;

  private ACLabel shortStayClinicRecuperationSpecificConsultationFeeOutline;

  private ACPanel tab3;

  private ACBackLabelContainer shortStayClinicRecuperationDinnerContainer;

  private ACComboBox shortStayClinicRecuperationDinnerOffer;

  private ACLabelContainer shortStayClinicRecuperationDinnerOfferContainer;

  private ACComboBoxModelAdapter shortStayClinicRecuperationDinnerOfferModel;

  private ACTextField shortStayClinicRecuperationDinnerCost;

  private ACLabelContainer shortStayClinicRecuperationDinnerCostContainer;

  private ACIntegerCheckBox shortStayClinicRecuperationEtc30Over;

  private ACValueArrayRadioButtonGroup shortStayClinicRecuperationUnitCareMaintenanceRadio;

  private ACLabelContainer shortStayClinicRecuperationUnitCareMaintenanceRadioContainer;

  private ACListModelAdapter shortStayClinicRecuperationUnitCareMaintenanceRadioModel;

  private ACRadioButtonItem shortStayClinicRecuperationUnitCareMaintenanceRadioitem1;

  private ACRadioButtonItem shortStayClinicRecuperationUnitCareMaintenanceRadioitem2;

  private ACValueArrayRadioButtonGroup serviceAddProvisionStructuralRadioGroup;

  private ACLabelContainer serviceAddProvisionStructuralRadioGroupContainer;

  private ACListModelAdapter serviceAddProvisionStructuralRadioGroupModel;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem1;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem5;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem2;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem3;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem4;

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
  public ACValueArrayRadioButtonGroup getShortStayClinicRecuperationInstitutionDivisionRadio(){
    if(shortStayClinicRecuperationInstitutionDivisionRadio==null){

      shortStayClinicRecuperationInstitutionDivisionRadio = new ACValueArrayRadioButtonGroup();

      getShortStayClinicRecuperationInstitutionDivisionRadioContainer().setText("�{�ݓ��̋敪");

      shortStayClinicRecuperationInstitutionDivisionRadio.setBindPath("1230201");

      shortStayClinicRecuperationInstitutionDivisionRadio.setUseClearButton(false);

      shortStayClinicRecuperationInstitutionDivisionRadio.setModel(getShortStayClinicRecuperationInstitutionDivisionRadioModel());

      shortStayClinicRecuperationInstitutionDivisionRadio.setValues(new int[]{1,2,3});

      addShortStayClinicRecuperationInstitutionDivisionRadio();
    }
    return shortStayClinicRecuperationInstitutionDivisionRadio;

  }

  /**
   * �{�ݓ��̋敪�R���e�i���擾���܂��B
   * @return �{�ݓ��̋敪�R���e�i
   */
  protected ACLabelContainer getShortStayClinicRecuperationInstitutionDivisionRadioContainer(){
    if(shortStayClinicRecuperationInstitutionDivisionRadioContainer==null){
      shortStayClinicRecuperationInstitutionDivisionRadioContainer = new ACLabelContainer();
      shortStayClinicRecuperationInstitutionDivisionRadioContainer.setFollowChildEnabled(true);
      shortStayClinicRecuperationInstitutionDivisionRadioContainer.setVAlignment(VRLayout.CENTER);
      shortStayClinicRecuperationInstitutionDivisionRadioContainer.add(getShortStayClinicRecuperationInstitutionDivisionRadio(), null);
    }
    return shortStayClinicRecuperationInstitutionDivisionRadioContainer;
  }

  /**
   * �{�ݓ��̋敪���f�����擾���܂��B
   * @return �{�ݓ��̋敪���f��
   */
  protected ACListModelAdapter getShortStayClinicRecuperationInstitutionDivisionRadioModel(){
    if(shortStayClinicRecuperationInstitutionDivisionRadioModel==null){
      shortStayClinicRecuperationInstitutionDivisionRadioModel = new ACListModelAdapter();
      addShortStayClinicRecuperationInstitutionDivisionRadioModel();
    }
    return shortStayClinicRecuperationInstitutionDivisionRadioModel;
  }

  /**
   * �f�Ï����擾���܂��B
   * @return �f�Ï�
   */
  public ACRadioButtonItem getShortStayClinicRecuperationInstitutionDivisionRadioItem1(){
    if(shortStayClinicRecuperationInstitutionDivisionRadioItem1==null){

      shortStayClinicRecuperationInstitutionDivisionRadioItem1 = new ACRadioButtonItem();

      shortStayClinicRecuperationInstitutionDivisionRadioItem1.setText("�f�Ï�");

      shortStayClinicRecuperationInstitutionDivisionRadioItem1.setGroup(getShortStayClinicRecuperationInstitutionDivisionRadio());

      shortStayClinicRecuperationInstitutionDivisionRadioItem1.setConstraints(VRLayout.FLOW);

      addShortStayClinicRecuperationInstitutionDivisionRadioItem1();
    }
    return shortStayClinicRecuperationInstitutionDivisionRadioItem1;

  }

  /**
   * ���j�b�g�^�f�Ï����擾���܂��B
   * @return ���j�b�g�^�f�Ï�
   */
  public ACRadioButtonItem getShortStayClinicRecuperationInstitutionDivisionRadioItem2(){
    if(shortStayClinicRecuperationInstitutionDivisionRadioItem2==null){

      shortStayClinicRecuperationInstitutionDivisionRadioItem2 = new ACRadioButtonItem();

      shortStayClinicRecuperationInstitutionDivisionRadioItem2.setText("���j�b�g�^�f�Ï�");

      shortStayClinicRecuperationInstitutionDivisionRadioItem2.setGroup(getShortStayClinicRecuperationInstitutionDivisionRadio());

      shortStayClinicRecuperationInstitutionDivisionRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

      addShortStayClinicRecuperationInstitutionDivisionRadioItem2();
    }
    return shortStayClinicRecuperationInstitutionDivisionRadioItem2;

  }

  /**
   * ���A��V���[�g�X�e�C���擾���܂��B
   * @return ���A��V���[�g�X�e�C
   */
  public ACRadioButtonItem getShortStayClinicRecuperationInstitutionDivisionRadioItem3(){
    if(shortStayClinicRecuperationInstitutionDivisionRadioItem3==null){

      shortStayClinicRecuperationInstitutionDivisionRadioItem3 = new ACRadioButtonItem();

      shortStayClinicRecuperationInstitutionDivisionRadioItem3.setText("���A��V���[�g�X�e�C");

      shortStayClinicRecuperationInstitutionDivisionRadioItem3.setGroup(getShortStayClinicRecuperationInstitutionDivisionRadio());

      shortStayClinicRecuperationInstitutionDivisionRadioItem3.setConstraints(VRLayout.FLOW);

      addShortStayClinicRecuperationInstitutionDivisionRadioItem3();
    }
    return shortStayClinicRecuperationInstitutionDivisionRadioItem3;

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

      staffAssignment1Division.setBindPath("1230202");

      staffAssignment1Division.setUseClearButton(false);

      staffAssignment1Division.setModel(getStaffAssignment1DivisionModel());

      staffAssignment1Division.setValues(new int[]{1,2,3,4});

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
   * I�^�i�����^�ȊO�j���擾���܂��B
   * @return I�^�i�����^�ȊO�j
   */
  public ACRadioButtonItem getStaffAssignmentDivisionItem1(){
    if(staffAssignmentDivisionItem1==null){

      staffAssignmentDivisionItem1 = new ACRadioButtonItem();

      staffAssignmentDivisionItem1.setText("I�^(�����^�ȊO)");

      staffAssignmentDivisionItem1.setGroup(getStaffAssignment1Division());

      staffAssignmentDivisionItem1.setConstraints(VRLayout.FLOW_RETURN);

      addStaffAssignmentDivisionItem1();
    }
    return staffAssignmentDivisionItem1;

  }

  /**
   * I�^�i�����^A�j���擾���܂��B
   * @return I�^�i�����^A�j
   */
  public ACRadioButtonItem getStaffAssignmentDivisionItem2(){
    if(staffAssignmentDivisionItem2==null){

      staffAssignmentDivisionItem2 = new ACRadioButtonItem();

      staffAssignmentDivisionItem2.setText("I�^(�����^A)");

      staffAssignmentDivisionItem2.setGroup(getStaffAssignment1Division());

      staffAssignmentDivisionItem2.setConstraints(VRLayout.FLOW);

      addStaffAssignmentDivisionItem2();
    }
    return staffAssignmentDivisionItem2;

  }

  /**
   * I�^�i�����^B�j���擾���܂��B
   * @return I�^�i�����^B�j
   */
  public ACRadioButtonItem getStaffAssignmentDivisionItem3(){
    if(staffAssignmentDivisionItem3==null){

      staffAssignmentDivisionItem3 = new ACRadioButtonItem();

      staffAssignmentDivisionItem3.setText("I�^(�����^B)");

      staffAssignmentDivisionItem3.setGroup(getStaffAssignment1Division());

      staffAssignmentDivisionItem3.setConstraints(VRLayout.FLOW_RETURN);

      addStaffAssignmentDivisionItem3();
    }
    return staffAssignmentDivisionItem3;

  }

  /**
   * II�^���擾���܂��B
   * @return II�^
   */
  public ACRadioButtonItem getStaffAssignmentDivisionItem4(){
    if(staffAssignmentDivisionItem4==null){

      staffAssignmentDivisionItem4 = new ACRadioButtonItem();

      staffAssignmentDivisionItem4.setText("II�^");

      staffAssignmentDivisionItem4.setGroup(getStaffAssignment1Division());

      staffAssignmentDivisionItem4.setConstraints(VRLayout.FLOW);

      addStaffAssignmentDivisionItem4();
    }
    return staffAssignmentDivisionItem4;

  }

  /**
   * �l���z�u�敪���擾���܂��B
   * @return �l���z�u�敪
   */
  public ACValueArrayRadioButtonGroup getStaffAssignment2Division(){
    if(staffAssignment2Division==null){

      staffAssignment2Division = new ACValueArrayRadioButtonGroup();

      staffAssignment2Division.setBindPath("1230214");

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
   * �����^�ȊO���擾���܂��B
   * @return �����^�ȊO
   */
  public ACRadioButtonItem getStaffAssignmentDivisionItem5(){
    if(staffAssignmentDivisionItem5==null){

      staffAssignmentDivisionItem5 = new ACRadioButtonItem();

      staffAssignmentDivisionItem5.setText("�����^�ȊO");

      staffAssignmentDivisionItem5.setGroup(getStaffAssignment2Division());

      staffAssignmentDivisionItem5.setConstraints(VRLayout.FLOW_RETURN);

      addStaffAssignmentDivisionItem5();
    }
    return staffAssignmentDivisionItem5;

  }

  /**
   * �����^A���擾���܂��B
   * @return �����^A
   */
  public ACRadioButtonItem getStaffAssignmentDivisionItem6(){
    if(staffAssignmentDivisionItem6==null){

      staffAssignmentDivisionItem6 = new ACRadioButtonItem();

      staffAssignmentDivisionItem6.setText("�����^A");

      staffAssignmentDivisionItem6.setGroup(getStaffAssignment2Division());

      staffAssignmentDivisionItem6.setConstraints(VRLayout.FLOW);

      addStaffAssignmentDivisionItem6();
    }
    return staffAssignmentDivisionItem6;

  }

  /**
   * �����^B���擾���܂��B
   * @return �����^B
   */
  public ACRadioButtonItem getStaffAssignmentDivisionItem7(){
    if(staffAssignmentDivisionItem7==null){

      staffAssignmentDivisionItem7 = new ACRadioButtonItem();

      staffAssignmentDivisionItem7.setText("�����^B");

      staffAssignmentDivisionItem7.setGroup(getStaffAssignment2Division());

      staffAssignmentDivisionItem7.setConstraints(VRLayout.FLOW);

      addStaffAssignmentDivisionItem7();
    }
    return staffAssignmentDivisionItem7;

  }

  /**
   * �a���敪�R���e�i(�V���[�g�X�e�C�ȊO�p)���擾���܂��B
   * @return �a���敪�R���e�i(�V���[�g�X�e�C�ȊO�p)
   */
  public ACLabelContainer getShortStayClinicRecuperationHospitalRoomContena(){
    if(shortStayClinicRecuperationHospitalRoomContena==null){

      shortStayClinicRecuperationHospitalRoomContena = new ACLabelContainer();

      shortStayClinicRecuperationHospitalRoomContena.setText("�a���敪");

      shortStayClinicRecuperationHospitalRoomContena.setFollowChildEnabled(true);

      addShortStayClinicRecuperationHospitalRoomContena();
    }
    return shortStayClinicRecuperationHospitalRoomContena;

  }

  /**
   * �a���i�f�Ï��j���擾���܂��B
   * @return �a���i�f�Ï��j
   */
  public ACValueArrayRadioButtonGroup getShortStayClinicRecuperationHospitalRoomRadio(){
    if(shortStayClinicRecuperationHospitalRoomRadio==null){

      shortStayClinicRecuperationHospitalRoomRadio = new ACValueArrayRadioButtonGroup();

      shortStayClinicRecuperationHospitalRoomRadio.setBindPath("1230203");

      shortStayClinicRecuperationHospitalRoomRadio.setUseClearButton(false);

      shortStayClinicRecuperationHospitalRoomRadio.setModel(getShortStayClinicRecuperationHospitalRoomRadioModel());

      shortStayClinicRecuperationHospitalRoomRadio.setValues(new int[]{1,2});

      addShortStayClinicRecuperationHospitalRoomRadio();
    }
    return shortStayClinicRecuperationHospitalRoomRadio;

  }

  /**
   * �a���i�f�Ï��j���f�����擾���܂��B
   * @return �a���i�f�Ï��j���f��
   */
  protected ACListModelAdapter getShortStayClinicRecuperationHospitalRoomRadioModel(){
    if(shortStayClinicRecuperationHospitalRoomRadioModel==null){
      shortStayClinicRecuperationHospitalRoomRadioModel = new ACListModelAdapter();
      addShortStayClinicRecuperationHospitalRoomRadioModel();
    }
    return shortStayClinicRecuperationHospitalRoomRadioModel;
  }

  /**
   * �]���^�����擾���܂��B
   * @return �]���^��
   */
  public ACRadioButtonItem getShortStayClinicRecuperationHospitalRoomRadioItem1(){
    if(shortStayClinicRecuperationHospitalRoomRadioItem1==null){

      shortStayClinicRecuperationHospitalRoomRadioItem1 = new ACRadioButtonItem();

      shortStayClinicRecuperationHospitalRoomRadioItem1.setText("�]���^��");

      shortStayClinicRecuperationHospitalRoomRadioItem1.setGroup(getShortStayClinicRecuperationHospitalRoomRadio());

      shortStayClinicRecuperationHospitalRoomRadioItem1.setConstraints(VRLayout.FLOW);

      addShortStayClinicRecuperationHospitalRoomRadioItem1();
    }
    return shortStayClinicRecuperationHospitalRoomRadioItem1;

  }

  /**
   * ���������擾���܂��B
   * @return ������
   */
  public ACRadioButtonItem getShortStayClinicRecuperationHospitalRoomRadioItem2(){
    if(shortStayClinicRecuperationHospitalRoomRadioItem2==null){

      shortStayClinicRecuperationHospitalRoomRadioItem2 = new ACRadioButtonItem();

      shortStayClinicRecuperationHospitalRoomRadioItem2.setText("������");

      shortStayClinicRecuperationHospitalRoomRadioItem2.setGroup(getShortStayClinicRecuperationHospitalRoomRadio());

      shortStayClinicRecuperationHospitalRoomRadioItem2.setConstraints(VRLayout.FLOW);

      addShortStayClinicRecuperationHospitalRoomRadioItem2();
    }
    return shortStayClinicRecuperationHospitalRoomRadioItem2;

  }

  /**
   * �a���i���j�b�g�^�j���擾���܂��B
   * @return �a���i���j�b�g�^�j
   */
  public ACValueArrayRadioButtonGroup getShortStayClinicRecuperationUnitHospitalRoomRadio(){
    if(shortStayClinicRecuperationUnitHospitalRoomRadio==null){

      shortStayClinicRecuperationUnitHospitalRoomRadio = new ACValueArrayRadioButtonGroup();

      shortStayClinicRecuperationUnitHospitalRoomRadio.setBindPath("1230204");

      shortStayClinicRecuperationUnitHospitalRoomRadio.setUseClearButton(false);

      shortStayClinicRecuperationUnitHospitalRoomRadio.setModel(getShortStayClinicRecuperationUnitHospitalRoomRadioModel());

      shortStayClinicRecuperationUnitHospitalRoomRadio.setValues(new int[]{1,2});

      addShortStayClinicRecuperationUnitHospitalRoomRadio();
    }
    return shortStayClinicRecuperationUnitHospitalRoomRadio;

  }

  /**
   * �a���i���j�b�g�^�j���f�����擾���܂��B
   * @return �a���i���j�b�g�^�j���f��
   */
  protected ACListModelAdapter getShortStayClinicRecuperationUnitHospitalRoomRadioModel(){
    if(shortStayClinicRecuperationUnitHospitalRoomRadioModel==null){
      shortStayClinicRecuperationUnitHospitalRoomRadioModel = new ACListModelAdapter();
      addShortStayClinicRecuperationUnitHospitalRoomRadioModel();
    }
    return shortStayClinicRecuperationUnitHospitalRoomRadioModel;
  }

  /**
   * ���j�b�g�^�����擾���܂��B
   * @return ���j�b�g�^��
   */
  public ACRadioButtonItem getShortStayClinicRecuperationUnitHospitalRoomRadioItem1(){
    if(shortStayClinicRecuperationUnitHospitalRoomRadioItem1==null){

      shortStayClinicRecuperationUnitHospitalRoomRadioItem1 = new ACRadioButtonItem();

      shortStayClinicRecuperationUnitHospitalRoomRadioItem1.setText("���j�b�g�^��");

      shortStayClinicRecuperationUnitHospitalRoomRadioItem1.setGroup(getShortStayClinicRecuperationUnitHospitalRoomRadio());

      shortStayClinicRecuperationUnitHospitalRoomRadioItem1.setConstraints(VRLayout.FLOW);

      addShortStayClinicRecuperationUnitHospitalRoomRadioItem1();
    }
    return shortStayClinicRecuperationUnitHospitalRoomRadioItem1;

  }

  /**
   * ���j�b�g�^�������擾���܂��B
   * @return ���j�b�g�^����
   */
  public ACRadioButtonItem getShortStayClinicRecuperationUnitHospitalRoomRadioItem2(){
    if(shortStayClinicRecuperationUnitHospitalRoomRadioItem2==null){

      shortStayClinicRecuperationUnitHospitalRoomRadioItem2 = new ACRadioButtonItem();

      shortStayClinicRecuperationUnitHospitalRoomRadioItem2.setText("���j�b�g�^����");

      shortStayClinicRecuperationUnitHospitalRoomRadioItem2.setGroup(getShortStayClinicRecuperationUnitHospitalRoomRadio());

      shortStayClinicRecuperationUnitHospitalRoomRadioItem2.setConstraints(VRLayout.FLOW);

      addShortStayClinicRecuperationUnitHospitalRoomRadioItem2();
    }
    return shortStayClinicRecuperationUnitHospitalRoomRadioItem2;

  }

  /**
   * �a���敪���W�I(�V���[�g�X�e�C�p)���擾���܂��B
   * @return �a���敪���W�I(�V���[�g�X�e�C�p)
   */
  public ACValueArrayRadioButtonGroup getShortStayClinicRecuperationSickroomDivisionRadio(){
    if(shortStayClinicRecuperationSickroomDivisionRadio==null){

      shortStayClinicRecuperationSickroomDivisionRadio = new ACValueArrayRadioButtonGroup();

      getShortStayClinicRecuperationSickroomDivisionRadioContainer().setText("�a���敪");

      shortStayClinicRecuperationSickroomDivisionRadio.setBindPath("1230212");

      shortStayClinicRecuperationSickroomDivisionRadio.setUseClearButton(false);

      shortStayClinicRecuperationSickroomDivisionRadio.setModel(getShortStayClinicRecuperationSickroomDivisionRadioModel());

      shortStayClinicRecuperationSickroomDivisionRadio.setValues(new int[]{1,2,3,4});

      addShortStayClinicRecuperationSickroomDivisionRadio();
    }
    return shortStayClinicRecuperationSickroomDivisionRadio;

  }

  /**
   * �a���敪���W�I(�V���[�g�X�e�C�p)�R���e�i���擾���܂��B
   * @return �a���敪���W�I(�V���[�g�X�e�C�p)�R���e�i
   */
  protected ACLabelContainer getShortStayClinicRecuperationSickroomDivisionRadioContainer(){
    if(shortStayClinicRecuperationSickroomDivisionRadioContainer==null){
      shortStayClinicRecuperationSickroomDivisionRadioContainer = new ACLabelContainer();
      shortStayClinicRecuperationSickroomDivisionRadioContainer.setFollowChildEnabled(true);
      shortStayClinicRecuperationSickroomDivisionRadioContainer.setVAlignment(VRLayout.CENTER);
      shortStayClinicRecuperationSickroomDivisionRadioContainer.add(getShortStayClinicRecuperationSickroomDivisionRadio(), null);
    }
    return shortStayClinicRecuperationSickroomDivisionRadioContainer;
  }

  /**
   * �a���敪���W�I(�V���[�g�X�e�C�p)���f�����擾���܂��B
   * @return �a���敪���W�I(�V���[�g�X�e�C�p)���f��
   */
  protected ACListModelAdapter getShortStayClinicRecuperationSickroomDivisionRadioModel(){
    if(shortStayClinicRecuperationSickroomDivisionRadioModel==null){
      shortStayClinicRecuperationSickroomDivisionRadioModel = new ACListModelAdapter();
      addShortStayClinicRecuperationSickroomDivisionRadioModel();
    }
    return shortStayClinicRecuperationSickroomDivisionRadioModel;
  }

  /**
   * �]���^�����擾���܂��B
   * @return �]���^��
   */
  public ACRadioButtonItem getShortStayClinicRecuperationSickroomDivisionRadioItem1(){
    if(shortStayClinicRecuperationSickroomDivisionRadioItem1==null){

      shortStayClinicRecuperationSickroomDivisionRadioItem1 = new ACRadioButtonItem();

      shortStayClinicRecuperationSickroomDivisionRadioItem1.setText("�]���^��");

      shortStayClinicRecuperationSickroomDivisionRadioItem1.setGroup(getShortStayClinicRecuperationSickroomDivisionRadio());

      shortStayClinicRecuperationSickroomDivisionRadioItem1.setConstraints(VRLayout.FLOW);

      addShortStayClinicRecuperationSickroomDivisionRadioItem1();
    }
    return shortStayClinicRecuperationSickroomDivisionRadioItem1;

  }

  /**
   * ���������擾���܂��B
   * @return ������
   */
  public ACRadioButtonItem getShortStayClinicRecuperationSickroomDivisionRadioItem2(){
    if(shortStayClinicRecuperationSickroomDivisionRadioItem2==null){

      shortStayClinicRecuperationSickroomDivisionRadioItem2 = new ACRadioButtonItem();

      shortStayClinicRecuperationSickroomDivisionRadioItem2.setText("������");

      shortStayClinicRecuperationSickroomDivisionRadioItem2.setGroup(getShortStayClinicRecuperationSickroomDivisionRadio());

      shortStayClinicRecuperationSickroomDivisionRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

      addShortStayClinicRecuperationSickroomDivisionRadioItem2();
    }
    return shortStayClinicRecuperationSickroomDivisionRadioItem2;

  }

  /**
   * ���j�b�g�^�����擾���܂��B
   * @return ���j�b�g�^��
   */
  public ACRadioButtonItem getShortStayClinicRecuperationSickroomDivisionRadioItem3(){
    if(shortStayClinicRecuperationSickroomDivisionRadioItem3==null){

      shortStayClinicRecuperationSickroomDivisionRadioItem3 = new ACRadioButtonItem();

      shortStayClinicRecuperationSickroomDivisionRadioItem3.setText("���j�b�g�^��");

      shortStayClinicRecuperationSickroomDivisionRadioItem3.setGroup(getShortStayClinicRecuperationSickroomDivisionRadio());

      shortStayClinicRecuperationSickroomDivisionRadioItem3.setConstraints(VRLayout.FLOW);

      addShortStayClinicRecuperationSickroomDivisionRadioItem3();
    }
    return shortStayClinicRecuperationSickroomDivisionRadioItem3;

  }

  /**
   * ���j�b�g�^�������擾���܂��B
   * @return ���j�b�g�^����
   */
  public ACRadioButtonItem getShortStayClinicRecuperationSickroomDivisionRadioItem4(){
    if(shortStayClinicRecuperationSickroomDivisionRadioItem4==null){

      shortStayClinicRecuperationSickroomDivisionRadioItem4 = new ACRadioButtonItem();

      shortStayClinicRecuperationSickroomDivisionRadioItem4.setText("���j�b�g�^����");

      shortStayClinicRecuperationSickroomDivisionRadioItem4.setGroup(getShortStayClinicRecuperationSickroomDivisionRadio());

      shortStayClinicRecuperationSickroomDivisionRadioItem4.setConstraints(VRLayout.FLOW);

      addShortStayClinicRecuperationSickroomDivisionRadioItem4();
    }
    return shortStayClinicRecuperationSickroomDivisionRadioItem4;

  }

  /**
   * ���ԋ敪���擾���܂��B
   * @return ���ԋ敪
   */
  public ACComboBox getTankinyusyoTimeDivision(){
    if(tankinyusyoTimeDivision==null){

      tankinyusyoTimeDivision = new ACComboBox();

      getTankinyusyoTimeDivisionContainer().setText("���ԋ敪");

      tankinyusyoTimeDivision.setBindPath("1230255");

      tankinyusyoTimeDivision.setEditable(false);

      tankinyusyoTimeDivision.setModelBindPath("1230255");

      tankinyusyoTimeDivision.setRenderBindPath("CONTENT");

      tankinyusyoTimeDivision.setModel(getTankinyusyoTimeDivisionModel());

      addTankinyusyoTimeDivision();
    }
    return tankinyusyoTimeDivision;

  }

  /**
   * ���ԋ敪�R���e�i���擾���܂��B
   * @return ���ԋ敪�R���e�i
   */
  protected ACLabelContainer getTankinyusyoTimeDivisionContainer(){
    if(tankinyusyoTimeDivisionContainer==null){
      tankinyusyoTimeDivisionContainer = new ACLabelContainer();
      tankinyusyoTimeDivisionContainer.setFollowChildEnabled(true);
      tankinyusyoTimeDivisionContainer.setVAlignment(VRLayout.CENTER);
      tankinyusyoTimeDivisionContainer.add(getTankinyusyoTimeDivision(), null);
    }
    return tankinyusyoTimeDivisionContainer;
  }

  /**
   * ���ԋ敪���f�����擾���܂��B
   * @return ���ԋ敪���f��
   */
  protected ACComboBoxModelAdapter getTankinyusyoTimeDivisionModel(){
    if(tankinyusyoTimeDivisionModel==null){
      tankinyusyoTimeDivisionModel = new ACComboBoxModelAdapter();
      addTankinyusyoTimeDivisionModel();
    }
    return tankinyusyoTimeDivisionModel;
  }

  /**
   * �×{�����Z���擾���܂��B
   * @return �×{�����Z
   */
  public ACValueArrayRadioButtonGroup getShortStayClinicRecuperationSubtractionType(){
    if(shortStayClinicRecuperationSubtractionType==null){

      shortStayClinicRecuperationSubtractionType = new ACValueArrayRadioButtonGroup();

      getShortStayClinicRecuperationSubtractionTypeContainer().setText("�×{�����Z");

      shortStayClinicRecuperationSubtractionType.setBindPath("1230254");

      shortStayClinicRecuperationSubtractionType.setNoSelectIndex(0);

      shortStayClinicRecuperationSubtractionType.setUseClearButton(false);

      shortStayClinicRecuperationSubtractionType.setModel(getShortStayClinicRecuperationSubtractionTypeModel());

      shortStayClinicRecuperationSubtractionType.setValues(new int[]{1,3});

      addShortStayClinicRecuperationSubtractionType();
    }
    return shortStayClinicRecuperationSubtractionType;

  }

  /**
   * �×{�����Z�R���e�i���擾���܂��B
   * @return �×{�����Z�R���e�i
   */
  protected ACLabelContainer getShortStayClinicRecuperationSubtractionTypeContainer(){
    if(shortStayClinicRecuperationSubtractionTypeContainer==null){
      shortStayClinicRecuperationSubtractionTypeContainer = new ACLabelContainer();
      shortStayClinicRecuperationSubtractionTypeContainer.setFollowChildEnabled(true);
      shortStayClinicRecuperationSubtractionTypeContainer.setVAlignment(VRLayout.CENTER);
      shortStayClinicRecuperationSubtractionTypeContainer.add(getShortStayClinicRecuperationSubtractionType(), null);
    }
    return shortStayClinicRecuperationSubtractionTypeContainer;
  }

  /**
   * �×{�����Z���f�����擾���܂��B
   * @return �×{�����Z���f��
   */
  protected ACListModelAdapter getShortStayClinicRecuperationSubtractionTypeModel(){
    if(shortStayClinicRecuperationSubtractionTypeModel==null){
      shortStayClinicRecuperationSubtractionTypeModel = new ACListModelAdapter();
      addShortStayClinicRecuperationSubtractionTypeModel();
    }
    return shortStayClinicRecuperationSubtractionTypeModel;
  }

  /**
   * ��^���擾���܂��B
   * @return ��^
   */
  public ACRadioButtonItem getShortStayClinicRecuperationSubtractionTypeNormal(){
    if(shortStayClinicRecuperationSubtractionTypeNormal==null){

      shortStayClinicRecuperationSubtractionTypeNormal = new ACRadioButtonItem();

      shortStayClinicRecuperationSubtractionTypeNormal.setText("��^");

      shortStayClinicRecuperationSubtractionTypeNormal.setGroup(getShortStayClinicRecuperationSubtractionType());

      shortStayClinicRecuperationSubtractionTypeNormal.setConstraints(VRLayout.FLOW);

      addShortStayClinicRecuperationSubtractionTypeNormal();
    }
    return shortStayClinicRecuperationSubtractionTypeNormal;

  }

  /**
   * ���Z�^II���擾���܂��B
   * @return ���Z�^II
   */
  public ACRadioButtonItem getShortStayClinicRecuperationSubtractionType3(){
    if(shortStayClinicRecuperationSubtractionType3==null){

      shortStayClinicRecuperationSubtractionType3 = new ACRadioButtonItem();

      shortStayClinicRecuperationSubtractionType3.setText("���Z�^II");

      shortStayClinicRecuperationSubtractionType3.setGroup(getShortStayClinicRecuperationSubtractionType());

      shortStayClinicRecuperationSubtractionType3.setConstraints(VRLayout.FLOW);

      addShortStayClinicRecuperationSubtractionType3();
    }
    return shortStayClinicRecuperationSubtractionType3;

  }

  /**
   * �ݔ�����Z���擾���܂��B
   * @return �ݔ�����Z
   */
  public ACValueArrayRadioButtonGroup getShortStayClinicRecuperationProvisionBase(){
    if(shortStayClinicRecuperationProvisionBase==null){

      shortStayClinicRecuperationProvisionBase = new ACValueArrayRadioButtonGroup();

      getShortStayClinicRecuperationProvisionBaseContainer().setText("�ݔ�����Z");

      shortStayClinicRecuperationProvisionBase.setBindPath("1230252");

      shortStayClinicRecuperationProvisionBase.setUseClearButton(false);

      shortStayClinicRecuperationProvisionBase.setModel(getShortStayClinicRecuperationProvisionBaseModel());

      shortStayClinicRecuperationProvisionBase.setValues(new int[]{1,2});

      addShortStayClinicRecuperationProvisionBase();
    }
    return shortStayClinicRecuperationProvisionBase;

  }

  /**
   * �ݔ�����Z�R���e�i���擾���܂��B
   * @return �ݔ�����Z�R���e�i
   */
  protected ACLabelContainer getShortStayClinicRecuperationProvisionBaseContainer(){
    if(shortStayClinicRecuperationProvisionBaseContainer==null){
      shortStayClinicRecuperationProvisionBaseContainer = new ACLabelContainer();
      shortStayClinicRecuperationProvisionBaseContainer.setFollowChildEnabled(true);
      shortStayClinicRecuperationProvisionBaseContainer.setVAlignment(VRLayout.CENTER);
      shortStayClinicRecuperationProvisionBaseContainer.add(getShortStayClinicRecuperationProvisionBase(), null);
    }
    return shortStayClinicRecuperationProvisionBaseContainer;
  }

  /**
   * �ݔ�����Z���f�����擾���܂��B
   * @return �ݔ�����Z���f��
   */
  protected ACListModelAdapter getShortStayClinicRecuperationProvisionBaseModel(){
    if(shortStayClinicRecuperationProvisionBaseModel==null){
      shortStayClinicRecuperationProvisionBaseModel = new ACListModelAdapter();
      addShortStayClinicRecuperationProvisionBaseModel();
    }
    return shortStayClinicRecuperationProvisionBaseModel;
  }

  /**
   * ����擾���܂��B
   * @return �
   */
  public ACRadioButtonItem getShortStayClinicRecuperationProvisionBaseNormal(){
    if(shortStayClinicRecuperationProvisionBaseNormal==null){

      shortStayClinicRecuperationProvisionBaseNormal = new ACRadioButtonItem();

      shortStayClinicRecuperationProvisionBaseNormal.setText("��^");

      shortStayClinicRecuperationProvisionBaseNormal.setGroup(getShortStayClinicRecuperationProvisionBase());

      shortStayClinicRecuperationProvisionBaseNormal.setConstraints(VRLayout.FLOW);

      addShortStayClinicRecuperationProvisionBaseNormal();
    }
    return shortStayClinicRecuperationProvisionBaseNormal;

  }

  /**
   * ���Z�^���擾���܂��B
   * @return ���Z�^
   */
  public ACRadioButtonItem getShortStayClinicRecuperationProvisionBaseType1(){
    if(shortStayClinicRecuperationProvisionBaseType1==null){

      shortStayClinicRecuperationProvisionBaseType1 = new ACRadioButtonItem();

      shortStayClinicRecuperationProvisionBaseType1.setText("���Z�^");

      shortStayClinicRecuperationProvisionBaseType1.setGroup(getShortStayClinicRecuperationProvisionBase());

      shortStayClinicRecuperationProvisionBaseType1.setConstraints(VRLayout.FLOW);

      addShortStayClinicRecuperationProvisionBaseType1();
    }
    return shortStayClinicRecuperationProvisionBaseType1;

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
   * �F�m�Ǎs���E�S���Ǐ�ً}�Ή����Z���擾���܂��B
   * @return �F�m�Ǎs���E�S���Ǐ�ً}�Ή����Z
   */
  public ACValueArrayRadioButtonGroup getDementiaActionAddRadioGroup(){
    if(dementiaActionAddRadioGroup==null){

      dementiaActionAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getDementiaActionAddRadioGroupContainer().setText("�F�m�Ǎs���E" + ACConstants.LINE_SEPARATOR + "�S���Ǐ�ً}�Ή����Z" + ACConstants.LINE_SEPARATOR + "�i1����7�������x�j");

      dementiaActionAddRadioGroup.setBindPath("1230256");

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

      dementiaActionAddRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

      addDementiaActionAddRadioItem2();
    }
    return dementiaActionAddRadioItem2;

  }

  /**
   * �ً}�Z������������Z���擾���܂��B
   * @return �ً}�Z������������Z
   */
  public ACValueArrayRadioButtonGroup getShortStayClinicRecuperationEmergencyNetworkAddRadio(){
    if(shortStayClinicRecuperationEmergencyNetworkAddRadio==null){

      shortStayClinicRecuperationEmergencyNetworkAddRadio = new ACValueArrayRadioButtonGroup();

      getShortStayClinicRecuperationEmergencyNetworkAddRadioContainer().setText("�ً}�Z������������Z" + ACConstants.LINE_SEPARATOR + "�i1����7�������x�j");

      shortStayClinicRecuperationEmergencyNetworkAddRadio.setBindPath("1230213");

      shortStayClinicRecuperationEmergencyNetworkAddRadio.setUseClearButton(false);

      shortStayClinicRecuperationEmergencyNetworkAddRadio.setModel(getShortStayClinicRecuperationEmergencyNetworkAddRadioModel());

      shortStayClinicRecuperationEmergencyNetworkAddRadio.setValues(new int[]{1,2});

      addShortStayClinicRecuperationEmergencyNetworkAddRadio();
    }
    return shortStayClinicRecuperationEmergencyNetworkAddRadio;

  }

  /**
   * �ً}�Z������������Z�R���e�i���擾���܂��B
   * @return �ً}�Z������������Z�R���e�i
   */
  protected ACLabelContainer getShortStayClinicRecuperationEmergencyNetworkAddRadioContainer(){
    if(shortStayClinicRecuperationEmergencyNetworkAddRadioContainer==null){
      shortStayClinicRecuperationEmergencyNetworkAddRadioContainer = new ACLabelContainer();
      shortStayClinicRecuperationEmergencyNetworkAddRadioContainer.setFollowChildEnabled(true);
      shortStayClinicRecuperationEmergencyNetworkAddRadioContainer.setVAlignment(VRLayout.CENTER);
      shortStayClinicRecuperationEmergencyNetworkAddRadioContainer.add(getShortStayClinicRecuperationEmergencyNetworkAddRadio(), null);
    }
    return shortStayClinicRecuperationEmergencyNetworkAddRadioContainer;
  }

  /**
   * �ً}�Z������������Z���f�����擾���܂��B
   * @return �ً}�Z������������Z���f��
   */
  protected ACListModelAdapter getShortStayClinicRecuperationEmergencyNetworkAddRadioModel(){
    if(shortStayClinicRecuperationEmergencyNetworkAddRadioModel==null){
      shortStayClinicRecuperationEmergencyNetworkAddRadioModel = new ACListModelAdapter();
      addShortStayClinicRecuperationEmergencyNetworkAddRadioModel();
    }
    return shortStayClinicRecuperationEmergencyNetworkAddRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getShortStayClinicRecuperationEmergencyNetworkAddRadioItem1(){
    if(shortStayClinicRecuperationEmergencyNetworkAddRadioItem1==null){

      shortStayClinicRecuperationEmergencyNetworkAddRadioItem1 = new ACRadioButtonItem();

      shortStayClinicRecuperationEmergencyNetworkAddRadioItem1.setText("�Ȃ�");

      shortStayClinicRecuperationEmergencyNetworkAddRadioItem1.setGroup(getShortStayClinicRecuperationEmergencyNetworkAddRadio());

      shortStayClinicRecuperationEmergencyNetworkAddRadioItem1.setConstraints(VRLayout.FLOW);

      addShortStayClinicRecuperationEmergencyNetworkAddRadioItem1();
    }
    return shortStayClinicRecuperationEmergencyNetworkAddRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getShortStayClinicRecuperationEmergencyNetworkAddRadioItem2(){
    if(shortStayClinicRecuperationEmergencyNetworkAddRadioItem2==null){

      shortStayClinicRecuperationEmergencyNetworkAddRadioItem2 = new ACRadioButtonItem();

      shortStayClinicRecuperationEmergencyNetworkAddRadioItem2.setText("����");

      shortStayClinicRecuperationEmergencyNetworkAddRadioItem2.setGroup(getShortStayClinicRecuperationEmergencyNetworkAddRadio());

      shortStayClinicRecuperationEmergencyNetworkAddRadioItem2.setConstraints(VRLayout.FLOW);

      addShortStayClinicRecuperationEmergencyNetworkAddRadioItem2();
    }
    return shortStayClinicRecuperationEmergencyNetworkAddRadioItem2;

  }

  /**
   * ��N���F�m�Ǘ��p�Ҏ�����Z���擾���܂��B
   * @return ��N���F�m�Ǘ��p�Ҏ�����Z
   */
  public ACValueArrayRadioButtonGroup getYoungDementiaPatinetAddRadioGroup(){
    if(youngDementiaPatinetAddRadioGroup==null){

      youngDementiaPatinetAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getYoungDementiaPatinetAddRadioGroupContainer().setText("��N���F�m�Ǘ��p�Ҏ�����Z");

      youngDementiaPatinetAddRadioGroup.setBindPath("1230257");

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
  public ACValueArrayRadioButtonGroup getShortStayClinicRecuperationMeetingAndSendingOff(){
    if(shortStayClinicRecuperationMeetingAndSendingOff==null){

      shortStayClinicRecuperationMeetingAndSendingOff = new ACValueArrayRadioButtonGroup();

      getShortStayClinicRecuperationMeetingAndSendingOffContainer().setText("���}���Z");

      shortStayClinicRecuperationMeetingAndSendingOff.setBindPath("6");

      shortStayClinicRecuperationMeetingAndSendingOff.setUseClearButton(false);

      shortStayClinicRecuperationMeetingAndSendingOff.setModel(getShortStayClinicRecuperationMeetingAndSendingOffModel());

      shortStayClinicRecuperationMeetingAndSendingOff.setValues(new int[]{1,2,3});

      addShortStayClinicRecuperationMeetingAndSendingOff();
    }
    return shortStayClinicRecuperationMeetingAndSendingOff;

  }

  /**
   * ���}���Z�R���e�i���擾���܂��B
   * @return ���}���Z�R���e�i
   */
  protected ACLabelContainer getShortStayClinicRecuperationMeetingAndSendingOffContainer(){
    if(shortStayClinicRecuperationMeetingAndSendingOffContainer==null){
      shortStayClinicRecuperationMeetingAndSendingOffContainer = new ACLabelContainer();
      shortStayClinicRecuperationMeetingAndSendingOffContainer.setFollowChildEnabled(true);
      shortStayClinicRecuperationMeetingAndSendingOffContainer.setVAlignment(VRLayout.CENTER);
      shortStayClinicRecuperationMeetingAndSendingOffContainer.add(getShortStayClinicRecuperationMeetingAndSendingOff(), null);
    }
    return shortStayClinicRecuperationMeetingAndSendingOffContainer;
  }

  /**
   * ���}���Z���f�����擾���܂��B
   * @return ���}���Z���f��
   */
  protected ACListModelAdapter getShortStayClinicRecuperationMeetingAndSendingOffModel(){
    if(shortStayClinicRecuperationMeetingAndSendingOffModel==null){
      shortStayClinicRecuperationMeetingAndSendingOffModel = new ACListModelAdapter();
      addShortStayClinicRecuperationMeetingAndSendingOffModel();
    }
    return shortStayClinicRecuperationMeetingAndSendingOffModel;
  }

  /**
   * ���}�Ȃ����擾���܂��B
   * @return ���}�Ȃ�
   */
  public ACRadioButtonItem getShortStayClinicRecuperationMeetingAndSendingOffNone(){
    if(shortStayClinicRecuperationMeetingAndSendingOffNone==null){

      shortStayClinicRecuperationMeetingAndSendingOffNone = new ACRadioButtonItem();

      shortStayClinicRecuperationMeetingAndSendingOffNone.setText("���}�Ȃ�");

      shortStayClinicRecuperationMeetingAndSendingOffNone.setGroup(getShortStayClinicRecuperationMeetingAndSendingOff());

      shortStayClinicRecuperationMeetingAndSendingOffNone.setConstraints(VRLayout.FLOW);

      addShortStayClinicRecuperationMeetingAndSendingOffNone();
    }
    return shortStayClinicRecuperationMeetingAndSendingOffNone;

  }

  /**
   * ���}�Г����擾���܂��B
   * @return ���}�Г�
   */
  public ACRadioButtonItem getShortStayClinicRecuperationMeetingAndSendingOffOneWay(){
    if(shortStayClinicRecuperationMeetingAndSendingOffOneWay==null){

      shortStayClinicRecuperationMeetingAndSendingOffOneWay = new ACRadioButtonItem();

      shortStayClinicRecuperationMeetingAndSendingOffOneWay.setText("���}�Г�");

      shortStayClinicRecuperationMeetingAndSendingOffOneWay.setGroup(getShortStayClinicRecuperationMeetingAndSendingOff());

      shortStayClinicRecuperationMeetingAndSendingOffOneWay.setConstraints(VRLayout.FLOW);

      addShortStayClinicRecuperationMeetingAndSendingOffOneWay();
    }
    return shortStayClinicRecuperationMeetingAndSendingOffOneWay;

  }

  /**
   * ���}�������擾���܂��B
   * @return ���}����
   */
  public ACRadioButtonItem getShortStayClinicRecuperationMeetingAndSendingOffRoundTrip(){
    if(shortStayClinicRecuperationMeetingAndSendingOffRoundTrip==null){

      shortStayClinicRecuperationMeetingAndSendingOffRoundTrip = new ACRadioButtonItem();

      shortStayClinicRecuperationMeetingAndSendingOffRoundTrip.setText("���}����");

      shortStayClinicRecuperationMeetingAndSendingOffRoundTrip.setGroup(getShortStayClinicRecuperationMeetingAndSendingOff());

      shortStayClinicRecuperationMeetingAndSendingOffRoundTrip.setConstraints(VRLayout.FLOW);

      addShortStayClinicRecuperationMeetingAndSendingOffRoundTrip();
    }
    return shortStayClinicRecuperationMeetingAndSendingOffRoundTrip;

  }

  /**
   * �×{�H���Z���擾���܂��B
   * @return �×{�H���Z
   */
  public ACValueArrayRadioButtonGroup getShortStayClinicRecuperationMedicalExpensesRadio(){
    if(shortStayClinicRecuperationMedicalExpensesRadio==null){

      shortStayClinicRecuperationMedicalExpensesRadio = new ACValueArrayRadioButtonGroup();

      getShortStayClinicRecuperationMedicalExpensesRadioContainer().setText("�×{�H���Z");

      shortStayClinicRecuperationMedicalExpensesRadio.setBindPath("1230208");

      shortStayClinicRecuperationMedicalExpensesRadio.setUseClearButton(false);

      shortStayClinicRecuperationMedicalExpensesRadio.setModel(getShortStayClinicRecuperationMedicalExpensesRadioModel());

      shortStayClinicRecuperationMedicalExpensesRadio.setValues(new int[]{1,2});

      addShortStayClinicRecuperationMedicalExpensesRadio();
    }
    return shortStayClinicRecuperationMedicalExpensesRadio;

  }

  /**
   * �×{�H���Z�R���e�i���擾���܂��B
   * @return �×{�H���Z�R���e�i
   */
  protected ACLabelContainer getShortStayClinicRecuperationMedicalExpensesRadioContainer(){
    if(shortStayClinicRecuperationMedicalExpensesRadioContainer==null){
      shortStayClinicRecuperationMedicalExpensesRadioContainer = new ACLabelContainer();
      shortStayClinicRecuperationMedicalExpensesRadioContainer.setFollowChildEnabled(true);
      shortStayClinicRecuperationMedicalExpensesRadioContainer.setVAlignment(VRLayout.CENTER);
      shortStayClinicRecuperationMedicalExpensesRadioContainer.add(getShortStayClinicRecuperationMedicalExpensesRadio(), null);
    }
    return shortStayClinicRecuperationMedicalExpensesRadioContainer;
  }

  /**
   * �×{�H���Z���f�����擾���܂��B
   * @return �×{�H���Z���f��
   */
  protected ACListModelAdapter getShortStayClinicRecuperationMedicalExpensesRadioModel(){
    if(shortStayClinicRecuperationMedicalExpensesRadioModel==null){
      shortStayClinicRecuperationMedicalExpensesRadioModel = new ACListModelAdapter();
      addShortStayClinicRecuperationMedicalExpensesRadioModel();
    }
    return shortStayClinicRecuperationMedicalExpensesRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getShortStayClinicRecuperationMedicalExpensesRadioItem1(){
    if(shortStayClinicRecuperationMedicalExpensesRadioItem1==null){

      shortStayClinicRecuperationMedicalExpensesRadioItem1 = new ACRadioButtonItem();

      shortStayClinicRecuperationMedicalExpensesRadioItem1.setText("�Ȃ�");

      shortStayClinicRecuperationMedicalExpensesRadioItem1.setGroup(getShortStayClinicRecuperationMedicalExpensesRadio());

      shortStayClinicRecuperationMedicalExpensesRadioItem1.setConstraints(VRLayout.FLOW);

      addShortStayClinicRecuperationMedicalExpensesRadioItem1();
    }
    return shortStayClinicRecuperationMedicalExpensesRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getShortStayClinicRecuperationMedicalExpensesRadioItem2(){
    if(shortStayClinicRecuperationMedicalExpensesRadioItem2==null){

      shortStayClinicRecuperationMedicalExpensesRadioItem2 = new ACRadioButtonItem();

      shortStayClinicRecuperationMedicalExpensesRadioItem2.setText("����");

      shortStayClinicRecuperationMedicalExpensesRadioItem2.setGroup(getShortStayClinicRecuperationMedicalExpensesRadio());

      shortStayClinicRecuperationMedicalExpensesRadioItem2.setConstraints(VRLayout.FLOW);

      addShortStayClinicRecuperationMedicalExpensesRadioItem2();
    }
    return shortStayClinicRecuperationMedicalExpensesRadioItem2;

  }

  /**
   * �l�����Z���擾���܂��B
   * @return �l�����Z
   */
  public ACValueArrayRadioButtonGroup getShortStayClinicRecuperationStaffReduceRadio(){
    if(shortStayClinicRecuperationStaffReduceRadio==null){

      shortStayClinicRecuperationStaffReduceRadio = new ACValueArrayRadioButtonGroup();

      getShortStayClinicRecuperationStaffReduceRadioContainer().setText("�l�����Z");

      shortStayClinicRecuperationStaffReduceRadio.setBindPath("1230209");

      shortStayClinicRecuperationStaffReduceRadio.setUseClearButton(false);

      shortStayClinicRecuperationStaffReduceRadio.setModel(getShortStayClinicRecuperationStaffReduceRadioModel());

      shortStayClinicRecuperationStaffReduceRadio.setValues(new int[]{1,2});

      addShortStayClinicRecuperationStaffReduceRadio();
    }
    return shortStayClinicRecuperationStaffReduceRadio;

  }

  /**
   * �l�����Z�R���e�i���擾���܂��B
   * @return �l�����Z�R���e�i
   */
  protected ACLabelContainer getShortStayClinicRecuperationStaffReduceRadioContainer(){
    if(shortStayClinicRecuperationStaffReduceRadioContainer==null){
      shortStayClinicRecuperationStaffReduceRadioContainer = new ACLabelContainer();
      shortStayClinicRecuperationStaffReduceRadioContainer.setFollowChildEnabled(true);
      shortStayClinicRecuperationStaffReduceRadioContainer.setVAlignment(VRLayout.CENTER);
      shortStayClinicRecuperationStaffReduceRadioContainer.add(getShortStayClinicRecuperationStaffReduceRadio(), null);
    }
    return shortStayClinicRecuperationStaffReduceRadioContainer;
  }

  /**
   * �l�����Z���f�����擾���܂��B
   * @return �l�����Z���f��
   */
  protected ACListModelAdapter getShortStayClinicRecuperationStaffReduceRadioModel(){
    if(shortStayClinicRecuperationStaffReduceRadioModel==null){
      shortStayClinicRecuperationStaffReduceRadioModel = new ACListModelAdapter();
      addShortStayClinicRecuperationStaffReduceRadioModel();
    }
    return shortStayClinicRecuperationStaffReduceRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getShortStayClinicRecuperationStaffReduceRadioItem1(){
    if(shortStayClinicRecuperationStaffReduceRadioItem1==null){

      shortStayClinicRecuperationStaffReduceRadioItem1 = new ACRadioButtonItem();

      shortStayClinicRecuperationStaffReduceRadioItem1.setText("�Ȃ�");

      shortStayClinicRecuperationStaffReduceRadioItem1.setGroup(getShortStayClinicRecuperationStaffReduceRadio());

      shortStayClinicRecuperationStaffReduceRadioItem1.setConstraints(VRLayout.FLOW);

      addShortStayClinicRecuperationStaffReduceRadioItem1();
    }
    return shortStayClinicRecuperationStaffReduceRadioItem1;

  }

  /**
   * ������߂��擾���܂��B
   * @return �������
   */
  public ACRadioButtonItem getShortStayClinicRecuperationStaffReduceRadioItem2(){
    if(shortStayClinicRecuperationStaffReduceRadioItem2==null){

      shortStayClinicRecuperationStaffReduceRadioItem2 = new ACRadioButtonItem();

      shortStayClinicRecuperationStaffReduceRadioItem2.setText("�������");

      shortStayClinicRecuperationStaffReduceRadioItem2.setGroup(getShortStayClinicRecuperationStaffReduceRadio());

      shortStayClinicRecuperationStaffReduceRadioItem2.setConstraints(VRLayout.FLOW);

      addShortStayClinicRecuperationStaffReduceRadioItem2();
    }
    return shortStayClinicRecuperationStaffReduceRadioItem2;

  }

  /**
   * ����f�Ô�{�^�����擾���܂��B
   * @return ����f�Ô�{�^��
   */
  public ACMapBindButton getShortStayClinicRecuperationSpecificConsultationFee(){
    if(shortStayClinicRecuperationSpecificConsultationFee==null){

      shortStayClinicRecuperationSpecificConsultationFee = new ACMapBindButton();

      shortStayClinicRecuperationSpecificConsultationFee.setText("����f�Ô�");

      shortStayClinicRecuperationSpecificConsultationFee.setToolTipText("����f�Ô��ݒ肵�܂��B");

      addShortStayClinicRecuperationSpecificConsultationFee();
    }
    return shortStayClinicRecuperationSpecificConsultationFee;

  }

  /**
   * �ݒ胉�x�����擾���܂��B
   * @return �ݒ胉�x��
   */
  public ACLabel getShortStayClinicRecuperationSpecificConsultationFeeOutline(){
    if(shortStayClinicRecuperationSpecificConsultationFeeOutline==null){

      shortStayClinicRecuperationSpecificConsultationFeeOutline = new ACLabel();

      shortStayClinicRecuperationSpecificConsultationFeeOutline.setText("�ݒ�Ȃ�");

      shortStayClinicRecuperationSpecificConsultationFeeOutline.setOpaque(true);
      shortStayClinicRecuperationSpecificConsultationFeeOutline.setBackground(new Color(255,255,172));

      addShortStayClinicRecuperationSpecificConsultationFeeOutline();
    }
    return shortStayClinicRecuperationSpecificConsultationFeeOutline;

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
   * �H���R���e�i���擾���܂��B
   * @return �H���R���e�i
   */
  public ACBackLabelContainer getShortStayClinicRecuperationDinnerContainer(){
    if(shortStayClinicRecuperationDinnerContainer==null){

      shortStayClinicRecuperationDinnerContainer = new ACBackLabelContainer();

      shortStayClinicRecuperationDinnerContainer.setFollowChildEnabled(true);

      addShortStayClinicRecuperationDinnerContainer();
    }
    return shortStayClinicRecuperationDinnerContainer;

  }

  /**
   * �H���񋟂��擾���܂��B
   * @return �H����
   */
  public ACComboBox getShortStayClinicRecuperationDinnerOffer(){
    if(shortStayClinicRecuperationDinnerOffer==null){

      shortStayClinicRecuperationDinnerOffer = new ACComboBox();

      getShortStayClinicRecuperationDinnerOfferContainer().setText("�H����");

      shortStayClinicRecuperationDinnerOffer.setBindPath("1230249");

      shortStayClinicRecuperationDinnerOffer.setEditable(false);

      shortStayClinicRecuperationDinnerOffer.setModelBindPath("1230249");

      shortStayClinicRecuperationDinnerOffer.setRenderBindPath("CONTENT");

      shortStayClinicRecuperationDinnerOffer.setModel(getShortStayClinicRecuperationDinnerOfferModel());

      addShortStayClinicRecuperationDinnerOffer();
    }
    return shortStayClinicRecuperationDinnerOffer;

  }

  /**
   * �H���񋟃R���e�i���擾���܂��B
   * @return �H���񋟃R���e�i
   */
  protected ACLabelContainer getShortStayClinicRecuperationDinnerOfferContainer(){
    if(shortStayClinicRecuperationDinnerOfferContainer==null){
      shortStayClinicRecuperationDinnerOfferContainer = new ACLabelContainer();
      shortStayClinicRecuperationDinnerOfferContainer.setFollowChildEnabled(true);
      shortStayClinicRecuperationDinnerOfferContainer.setVAlignment(VRLayout.CENTER);
      shortStayClinicRecuperationDinnerOfferContainer.add(getShortStayClinicRecuperationDinnerOffer(), null);
    }
    return shortStayClinicRecuperationDinnerOfferContainer;
  }

  /**
   * �H���񋟃��f�����擾���܂��B
   * @return �H���񋟃��f��
   */
  protected ACComboBoxModelAdapter getShortStayClinicRecuperationDinnerOfferModel(){
    if(shortStayClinicRecuperationDinnerOfferModel==null){
      shortStayClinicRecuperationDinnerOfferModel = new ACComboBoxModelAdapter();
      addShortStayClinicRecuperationDinnerOfferModel();
    }
    return shortStayClinicRecuperationDinnerOfferModel;
  }

  /**
   * �H����p���擾���܂��B
   * @return �H����p
   */
  public ACTextField getShortStayClinicRecuperationDinnerCost(){
    if(shortStayClinicRecuperationDinnerCost==null){

      shortStayClinicRecuperationDinnerCost = new ACTextField();

      getShortStayClinicRecuperationDinnerCostContainer().setText("�H����p");

      shortStayClinicRecuperationDinnerCost.setBindPath("1230251");

      shortStayClinicRecuperationDinnerCost.setColumns(4);

      shortStayClinicRecuperationDinnerCost.setCharType(VRCharType.ONLY_DIGIT);

      shortStayClinicRecuperationDinnerCost.setHorizontalAlignment(SwingConstants.RIGHT);

      shortStayClinicRecuperationDinnerCost.setIMEMode(InputSubset.LATIN);

      shortStayClinicRecuperationDinnerCost.setMaxLength(5);

      addShortStayClinicRecuperationDinnerCost();
    }
    return shortStayClinicRecuperationDinnerCost;

  }

  /**
   * �H����p�R���e�i���擾���܂��B
   * @return �H����p�R���e�i
   */
  protected ACLabelContainer getShortStayClinicRecuperationDinnerCostContainer(){
    if(shortStayClinicRecuperationDinnerCostContainer==null){
      shortStayClinicRecuperationDinnerCostContainer = new ACLabelContainer();
      shortStayClinicRecuperationDinnerCostContainer.setFollowChildEnabled(true);
      shortStayClinicRecuperationDinnerCostContainer.setVAlignment(VRLayout.CENTER);
      shortStayClinicRecuperationDinnerCostContainer.add(getShortStayClinicRecuperationDinnerCost(), null);
    }
    return shortStayClinicRecuperationDinnerCostContainer;
  }

  /**
   * 30�������擾���܂��B
   * @return 30����
   */
  public ACIntegerCheckBox getShortStayClinicRecuperationEtc30Over(){
    if(shortStayClinicRecuperationEtc30Over==null){

      shortStayClinicRecuperationEtc30Over = new ACIntegerCheckBox();

      shortStayClinicRecuperationEtc30Over.setText("30����");

      shortStayClinicRecuperationEtc30Over.setBindPath("5");

      shortStayClinicRecuperationEtc30Over.setSelectValue(2);

      shortStayClinicRecuperationEtc30Over.setUnSelectValue(1);

      addShortStayClinicRecuperationEtc30Over();
    }
    return shortStayClinicRecuperationEtc30Over;

  }

  /**
   * ���j�b�g�P�A�̐������擾���܂��B
   * @return ���j�b�g�P�A�̐���
   */
  public ACValueArrayRadioButtonGroup getShortStayClinicRecuperationUnitCareMaintenanceRadio(){
    if(shortStayClinicRecuperationUnitCareMaintenanceRadio==null){

      shortStayClinicRecuperationUnitCareMaintenanceRadio = new ACValueArrayRadioButtonGroup();

      getShortStayClinicRecuperationUnitCareMaintenanceRadioContainer().setText("���j�b�g�P�A�̐���");

      shortStayClinicRecuperationUnitCareMaintenanceRadio.setBindPath("1230210");

      shortStayClinicRecuperationUnitCareMaintenanceRadio.setUseClearButton(false);

      shortStayClinicRecuperationUnitCareMaintenanceRadio.setModel(getShortStayClinicRecuperationUnitCareMaintenanceRadioModel());

      shortStayClinicRecuperationUnitCareMaintenanceRadio.setValues(new int[]{1,2});

      addShortStayClinicRecuperationUnitCareMaintenanceRadio();
    }
    return shortStayClinicRecuperationUnitCareMaintenanceRadio;

  }

  /**
   * ���j�b�g�P�A�̐����R���e�i���擾���܂��B
   * @return ���j�b�g�P�A�̐����R���e�i
   */
  protected ACLabelContainer getShortStayClinicRecuperationUnitCareMaintenanceRadioContainer(){
    if(shortStayClinicRecuperationUnitCareMaintenanceRadioContainer==null){
      shortStayClinicRecuperationUnitCareMaintenanceRadioContainer = new ACLabelContainer();
      shortStayClinicRecuperationUnitCareMaintenanceRadioContainer.setFollowChildEnabled(true);
      shortStayClinicRecuperationUnitCareMaintenanceRadioContainer.setVAlignment(VRLayout.CENTER);
      shortStayClinicRecuperationUnitCareMaintenanceRadioContainer.add(getShortStayClinicRecuperationUnitCareMaintenanceRadio(), null);
    }
    return shortStayClinicRecuperationUnitCareMaintenanceRadioContainer;
  }

  /**
   * ���j�b�g�P�A�̐������f�����擾���܂��B
   * @return ���j�b�g�P�A�̐������f��
   */
  protected ACListModelAdapter getShortStayClinicRecuperationUnitCareMaintenanceRadioModel(){
    if(shortStayClinicRecuperationUnitCareMaintenanceRadioModel==null){
      shortStayClinicRecuperationUnitCareMaintenanceRadioModel = new ACListModelAdapter();
      addShortStayClinicRecuperationUnitCareMaintenanceRadioModel();
    }
    return shortStayClinicRecuperationUnitCareMaintenanceRadioModel;
  }

  /**
   * ���������擾���܂��B
   * @return ������
   */
  public ACRadioButtonItem getShortStayClinicRecuperationUnitCareMaintenanceRadioitem1(){
    if(shortStayClinicRecuperationUnitCareMaintenanceRadioitem1==null){

      shortStayClinicRecuperationUnitCareMaintenanceRadioitem1 = new ACRadioButtonItem();

      shortStayClinicRecuperationUnitCareMaintenanceRadioitem1.setText("������");

      shortStayClinicRecuperationUnitCareMaintenanceRadioitem1.setGroup(getShortStayClinicRecuperationUnitCareMaintenanceRadio());

      shortStayClinicRecuperationUnitCareMaintenanceRadioitem1.setConstraints(VRLayout.FLOW);

      addShortStayClinicRecuperationUnitCareMaintenanceRadioitem1();
    }
    return shortStayClinicRecuperationUnitCareMaintenanceRadioitem1;

  }

  /**
   * �������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getShortStayClinicRecuperationUnitCareMaintenanceRadioitem2(){
    if(shortStayClinicRecuperationUnitCareMaintenanceRadioitem2==null){

      shortStayClinicRecuperationUnitCareMaintenanceRadioitem2 = new ACRadioButtonItem();

      shortStayClinicRecuperationUnitCareMaintenanceRadioitem2.setText("����");

      shortStayClinicRecuperationUnitCareMaintenanceRadioitem2.setGroup(getShortStayClinicRecuperationUnitCareMaintenanceRadio());

      shortStayClinicRecuperationUnitCareMaintenanceRadioitem2.setConstraints(VRLayout.FLOW);

      addShortStayClinicRecuperationUnitCareMaintenanceRadioitem2();
    }
    return shortStayClinicRecuperationUnitCareMaintenanceRadioitem2;

  }

  /**
   * �T�[�r�X�񋟑̐��������Z���擾���܂��B
   * @return �T�[�r�X�񋟑̐��������Z
   */
  public ACValueArrayRadioButtonGroup getServiceAddProvisionStructuralRadioGroup(){
    if(serviceAddProvisionStructuralRadioGroup==null){

      serviceAddProvisionStructuralRadioGroup = new ACValueArrayRadioButtonGroup();

      getServiceAddProvisionStructuralRadioGroupContainer().setText("�T�[�r�X�񋟑̐��������Z");

      serviceAddProvisionStructuralRadioGroup.setBindPath("1230253");

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
   * �R���X�g���N�^�ł��B
   */
  public QS001_12312_201504Design() {

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

  }

  /**
   * �^�u1�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTab1(){

    tab1.add(getShortStayClinicRecuperationInstitutionDivisionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getStaffAssignmentDivisionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getShortStayClinicRecuperationHospitalRoomContena(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getShortStayClinicRecuperationSickroomDivisionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getTankinyusyoTimeDivisionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getShortStayClinicRecuperationSubtractionTypeContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getShortStayClinicRecuperationProvisionBaseContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * �{�ݓ��̋敪�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayClinicRecuperationInstitutionDivisionRadio(){

  }

  /**
   * �{�ݓ��̋敪���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayClinicRecuperationInstitutionDivisionRadioModel(){

    getShortStayClinicRecuperationInstitutionDivisionRadioItem1().setButtonIndex(1);

    getShortStayClinicRecuperationInstitutionDivisionRadioModel().add(getShortStayClinicRecuperationInstitutionDivisionRadioItem1());

    getShortStayClinicRecuperationInstitutionDivisionRadioItem2().setButtonIndex(2);

    getShortStayClinicRecuperationInstitutionDivisionRadioModel().add(getShortStayClinicRecuperationInstitutionDivisionRadioItem2());

    getShortStayClinicRecuperationInstitutionDivisionRadioItem3().setButtonIndex(3);

    getShortStayClinicRecuperationInstitutionDivisionRadioModel().add(getShortStayClinicRecuperationInstitutionDivisionRadioItem3());

  }

  /**
   * �f�Ï��ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayClinicRecuperationInstitutionDivisionRadioItem1(){

  }

  /**
   * ���j�b�g�^�f�Ï��ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayClinicRecuperationInstitutionDivisionRadioItem2(){

  }

  /**
   * ���A��V���[�g�X�e�C�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayClinicRecuperationInstitutionDivisionRadioItem3(){

  }

  /**
   * �l���z�u�敪�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffAssignmentDivisionContainer(){

    staffAssignmentDivisionContainer.add(getStaffAssignment1Division(), VRLayout.FLOW_INSETLINE_RETURN);

    staffAssignmentDivisionContainer.add(getStaffAssignment2Division(), VRLayout.FLOW_INSETLINE_RETURN);

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

    getStaffAssignmentDivisionItem4().setButtonIndex(4);

    getStaffAssignment1DivisionModel().add(getStaffAssignmentDivisionItem4());

  }

  /**
   * I�^�i�����^�ȊO�j�ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffAssignmentDivisionItem1(){

  }

  /**
   * I�^�i�����^A�j�ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffAssignmentDivisionItem2(){

  }

  /**
   * I�^�i�����^B�j�ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffAssignmentDivisionItem3(){

  }

  /**
   * II�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffAssignmentDivisionItem4(){

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

    getStaffAssignmentDivisionItem5().setButtonIndex(1);

    getStaffAssignment2DivisionModel().add(getStaffAssignmentDivisionItem5());

    getStaffAssignmentDivisionItem6().setButtonIndex(2);

    getStaffAssignment2DivisionModel().add(getStaffAssignmentDivisionItem6());

    getStaffAssignmentDivisionItem7().setButtonIndex(3);

    getStaffAssignment2DivisionModel().add(getStaffAssignmentDivisionItem7());

  }

  /**
   * �����^�ȊO�ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffAssignmentDivisionItem5(){

  }

  /**
   * �����^A�ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffAssignmentDivisionItem6(){

  }

  /**
   * �����^B�ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffAssignmentDivisionItem7(){

  }

  /**
   * �a���敪�R���e�i(�V���[�g�X�e�C�ȊO�p)�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayClinicRecuperationHospitalRoomContena(){

    shortStayClinicRecuperationHospitalRoomContena.add(getShortStayClinicRecuperationHospitalRoomRadio(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayClinicRecuperationHospitalRoomContena.add(getShortStayClinicRecuperationUnitHospitalRoomRadio(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * �a���i�f�Ï��j�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayClinicRecuperationHospitalRoomRadio(){

  }

  /**
   * �a���i�f�Ï��j���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayClinicRecuperationHospitalRoomRadioModel(){

    getShortStayClinicRecuperationHospitalRoomRadioItem1().setButtonIndex(1);

    getShortStayClinicRecuperationHospitalRoomRadioModel().add(getShortStayClinicRecuperationHospitalRoomRadioItem1());

    getShortStayClinicRecuperationHospitalRoomRadioItem2().setButtonIndex(2);

    getShortStayClinicRecuperationHospitalRoomRadioModel().add(getShortStayClinicRecuperationHospitalRoomRadioItem2());

  }

  /**
   * �]���^���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayClinicRecuperationHospitalRoomRadioItem1(){

  }

  /**
   * �������ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayClinicRecuperationHospitalRoomRadioItem2(){

  }

  /**
   * �a���i���j�b�g�^�j�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayClinicRecuperationUnitHospitalRoomRadio(){

  }

  /**
   * �a���i���j�b�g�^�j���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayClinicRecuperationUnitHospitalRoomRadioModel(){

    getShortStayClinicRecuperationUnitHospitalRoomRadioItem1().setButtonIndex(1);

    getShortStayClinicRecuperationUnitHospitalRoomRadioModel().add(getShortStayClinicRecuperationUnitHospitalRoomRadioItem1());

    getShortStayClinicRecuperationUnitHospitalRoomRadioItem2().setButtonIndex(2);

    getShortStayClinicRecuperationUnitHospitalRoomRadioModel().add(getShortStayClinicRecuperationUnitHospitalRoomRadioItem2());

  }

  /**
   * ���j�b�g�^���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayClinicRecuperationUnitHospitalRoomRadioItem1(){

  }

  /**
   * ���j�b�g�^�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayClinicRecuperationUnitHospitalRoomRadioItem2(){

  }

  /**
   * �a���敪���W�I(�V���[�g�X�e�C�p)�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayClinicRecuperationSickroomDivisionRadio(){

  }

  /**
   * �a���敪���W�I(�V���[�g�X�e�C�p)���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayClinicRecuperationSickroomDivisionRadioModel(){

    getShortStayClinicRecuperationSickroomDivisionRadioItem1().setButtonIndex(1);

    getShortStayClinicRecuperationSickroomDivisionRadioModel().add(getShortStayClinicRecuperationSickroomDivisionRadioItem1());

    getShortStayClinicRecuperationSickroomDivisionRadioItem2().setButtonIndex(2);

    getShortStayClinicRecuperationSickroomDivisionRadioModel().add(getShortStayClinicRecuperationSickroomDivisionRadioItem2());

    getShortStayClinicRecuperationSickroomDivisionRadioItem3().setButtonIndex(3);

    getShortStayClinicRecuperationSickroomDivisionRadioModel().add(getShortStayClinicRecuperationSickroomDivisionRadioItem3());

    getShortStayClinicRecuperationSickroomDivisionRadioItem4().setButtonIndex(4);

    getShortStayClinicRecuperationSickroomDivisionRadioModel().add(getShortStayClinicRecuperationSickroomDivisionRadioItem4());

  }

  /**
   * �]���^���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayClinicRecuperationSickroomDivisionRadioItem1(){

  }

  /**
   * �������ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayClinicRecuperationSickroomDivisionRadioItem2(){

  }

  /**
   * ���j�b�g�^���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayClinicRecuperationSickroomDivisionRadioItem3(){

  }

  /**
   * ���j�b�g�^�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayClinicRecuperationSickroomDivisionRadioItem4(){

  }

  /**
   * ���ԋ敪�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTankinyusyoTimeDivision(){

  }

  /**
   * ���ԋ敪���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addTankinyusyoTimeDivisionModel(){

  }

  /**
   * �×{�����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayClinicRecuperationSubtractionType(){

  }

  /**
   * �×{�����Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayClinicRecuperationSubtractionTypeModel(){

    getShortStayClinicRecuperationSubtractionTypeNormal().setButtonIndex(1);

    getShortStayClinicRecuperationSubtractionTypeModel().add(getShortStayClinicRecuperationSubtractionTypeNormal());

    getShortStayClinicRecuperationSubtractionType3().setButtonIndex(3);

    getShortStayClinicRecuperationSubtractionTypeModel().add(getShortStayClinicRecuperationSubtractionType3());

  }

  /**
   * ��^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayClinicRecuperationSubtractionTypeNormal(){

  }

  /**
   * ���Z�^II�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayClinicRecuperationSubtractionType3(){

  }

  /**
   * �ݔ�����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayClinicRecuperationProvisionBase(){

  }

  /**
   * �ݔ�����Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayClinicRecuperationProvisionBaseModel(){

    getShortStayClinicRecuperationProvisionBaseNormal().setButtonIndex(1);

    getShortStayClinicRecuperationProvisionBaseModel().add(getShortStayClinicRecuperationProvisionBaseNormal());

    getShortStayClinicRecuperationProvisionBaseType1().setButtonIndex(2);

    getShortStayClinicRecuperationProvisionBaseModel().add(getShortStayClinicRecuperationProvisionBaseType1());

  }

  /**
   * ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayClinicRecuperationProvisionBaseNormal(){

  }

  /**
   * ���Z�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayClinicRecuperationProvisionBaseType1(){

  }

  /**
   * �^�u2�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTab2(){

    tab2.add(getDementiaActionAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getShortStayClinicRecuperationEmergencyNetworkAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getYoungDementiaPatinetAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getShortStayClinicRecuperationMeetingAndSendingOffContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getShortStayClinicRecuperationMedicalExpensesRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getShortStayClinicRecuperationStaffReduceRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getShortStayClinicRecuperationSpecificConsultationFee(), VRLayout.FLOW);

    tab2.add(getShortStayClinicRecuperationSpecificConsultationFeeOutline(), VRLayout.FLOW_RETURN);

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
   * �ً}�Z������������Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayClinicRecuperationEmergencyNetworkAddRadio(){

  }

  /**
   * �ً}�Z������������Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayClinicRecuperationEmergencyNetworkAddRadioModel(){

    getShortStayClinicRecuperationEmergencyNetworkAddRadioItem1().setButtonIndex(1);

    getShortStayClinicRecuperationEmergencyNetworkAddRadioModel().add(getShortStayClinicRecuperationEmergencyNetworkAddRadioItem1());

    getShortStayClinicRecuperationEmergencyNetworkAddRadioItem2().setButtonIndex(2);

    getShortStayClinicRecuperationEmergencyNetworkAddRadioModel().add(getShortStayClinicRecuperationEmergencyNetworkAddRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayClinicRecuperationEmergencyNetworkAddRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayClinicRecuperationEmergencyNetworkAddRadioItem2(){

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
  protected void addShortStayClinicRecuperationMeetingAndSendingOff(){

  }

  /**
   * ���}���Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayClinicRecuperationMeetingAndSendingOffModel(){

    getShortStayClinicRecuperationMeetingAndSendingOffNone().setButtonIndex(1);

    getShortStayClinicRecuperationMeetingAndSendingOffModel().add(getShortStayClinicRecuperationMeetingAndSendingOffNone());

    getShortStayClinicRecuperationMeetingAndSendingOffOneWay().setButtonIndex(2);

    getShortStayClinicRecuperationMeetingAndSendingOffModel().add(getShortStayClinicRecuperationMeetingAndSendingOffOneWay());

    getShortStayClinicRecuperationMeetingAndSendingOffRoundTrip().setButtonIndex(3);

    getShortStayClinicRecuperationMeetingAndSendingOffModel().add(getShortStayClinicRecuperationMeetingAndSendingOffRoundTrip());

  }

  /**
   * ���}�Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayClinicRecuperationMeetingAndSendingOffNone(){

  }

  /**
   * ���}�Г��ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayClinicRecuperationMeetingAndSendingOffOneWay(){

  }

  /**
   * ���}�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayClinicRecuperationMeetingAndSendingOffRoundTrip(){

  }

  /**
   * �×{�H���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayClinicRecuperationMedicalExpensesRadio(){

  }

  /**
   * �×{�H���Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayClinicRecuperationMedicalExpensesRadioModel(){

    getShortStayClinicRecuperationMedicalExpensesRadioItem1().setButtonIndex(1);

    getShortStayClinicRecuperationMedicalExpensesRadioModel().add(getShortStayClinicRecuperationMedicalExpensesRadioItem1());

    getShortStayClinicRecuperationMedicalExpensesRadioItem2().setButtonIndex(2);

    getShortStayClinicRecuperationMedicalExpensesRadioModel().add(getShortStayClinicRecuperationMedicalExpensesRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayClinicRecuperationMedicalExpensesRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayClinicRecuperationMedicalExpensesRadioItem2(){

  }

  /**
   * �l�����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayClinicRecuperationStaffReduceRadio(){

  }

  /**
   * �l�����Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayClinicRecuperationStaffReduceRadioModel(){

    getShortStayClinicRecuperationStaffReduceRadioItem1().setButtonIndex(1);

    getShortStayClinicRecuperationStaffReduceRadioModel().add(getShortStayClinicRecuperationStaffReduceRadioItem1());

    getShortStayClinicRecuperationStaffReduceRadioItem2().setButtonIndex(2);

    getShortStayClinicRecuperationStaffReduceRadioModel().add(getShortStayClinicRecuperationStaffReduceRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayClinicRecuperationStaffReduceRadioItem1(){

  }

  /**
   * ������߂ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayClinicRecuperationStaffReduceRadioItem2(){

  }

  /**
   * ����f�Ô�{�^���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayClinicRecuperationSpecificConsultationFee(){

  }

  /**
   * �ݒ胉�x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayClinicRecuperationSpecificConsultationFeeOutline(){

  }

  /**
   * �^�u3�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTab3(){

    tab3.add(getShortStayClinicRecuperationDinnerContainer(), VRLayout.FLOW_DOUBLEINSETLINE_RETURN);

    tab3.add(getShortStayClinicRecuperationEtc30Over(), VRLayout.FLOW_INSETLINE_RETURN);

    tab3.add(getShortStayClinicRecuperationUnitCareMaintenanceRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab3.add(getServiceAddProvisionStructuralRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * �H���R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayClinicRecuperationDinnerContainer(){

    shortStayClinicRecuperationDinnerContainer.add(getShortStayClinicRecuperationDinnerOfferContainer(), VRLayout.FLOW);

    shortStayClinicRecuperationDinnerContainer.add(getShortStayClinicRecuperationDinnerCostContainer(), VRLayout.FLOW);

  }

  /**
   * �H���񋟂ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayClinicRecuperationDinnerOffer(){

  }

  /**
   * �H���񋟃��f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayClinicRecuperationDinnerOfferModel(){

  }

  /**
   * �H����p�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayClinicRecuperationDinnerCost(){

  }

  /**
   * 30�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayClinicRecuperationEtc30Over(){

  }

  /**
   * ���j�b�g�P�A�̐����ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayClinicRecuperationUnitCareMaintenanceRadio(){

  }

  /**
   * ���j�b�g�P�A�̐������f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayClinicRecuperationUnitCareMaintenanceRadioModel(){

    getShortStayClinicRecuperationUnitCareMaintenanceRadioitem1().setButtonIndex(1);

    getShortStayClinicRecuperationUnitCareMaintenanceRadioModel().add(getShortStayClinicRecuperationUnitCareMaintenanceRadioitem1());

    getShortStayClinicRecuperationUnitCareMaintenanceRadioitem2().setButtonIndex(2);

    getShortStayClinicRecuperationUnitCareMaintenanceRadioModel().add(getShortStayClinicRecuperationUnitCareMaintenanceRadioitem2());

  }

  /**
   * �������ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayClinicRecuperationUnitCareMaintenanceRadioitem1(){

  }

  /**
   * �����ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayClinicRecuperationUnitCareMaintenanceRadioitem2(){

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
      ACFrame.debugStart(new ACAffairInfo(QS001_12312_201504Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QS001_12312_201504Design getThis() {
    return this;
  }
}
