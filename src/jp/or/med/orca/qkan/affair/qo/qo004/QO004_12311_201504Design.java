
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
 * �J����: ���{�@�K��
 * �쐬��: 2015/02/11  ���{�R���s���[�^�[������� ���{�@�K�� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���̑��@�\ (O)
 * �v���Z�X ���Ǝғo�^ (004)
 * �v���O���� �Z�������×{���a�@�×{�^ (QO004_12311_201504)
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
/**
 * �Z�������×{���a�@�×{�^��ʍ��ڃf�U�C��(QO004_12311_201504) 
 */
public class QO004_12311_201504Design extends QO004ProviderPanel {
  //GUI�R���|�[�l���g

  private ACGroupBox mainGroup;

  private JTabbedPane tab;

  private ACPanel panel1;

  private ACPanel calculationDetails;

  private ACValueArrayRadioButtonGroup facilitiesDivision;

  private ACLabelContainer facilitiesDivisionContainer;

  private ACListModelAdapter facilitiesDivisionModel;

  private ACRadioButtonItem facilitiesDivisionItem1;

  private ACRadioButtonItem facilitiesDivisionItem2;

  private ACRadioButtonItem facilitiesDivisionItem3;

  private ACRadioButtonItem facilitiesDivisionItem4;

  private ACLabelContainer staffAssignmentDivisionContainer;

  private ACValueArrayRadioButtonGroup staffAssignment1Division;

  private ACListModelAdapter staffAssignment1DivisionModel;

  private ACRadioButtonItem staffAssignmentDivisionItem1;

  private ACRadioButtonItem staffAssignmentDivisionItem2;

  private ACRadioButtonItem staffAssignmentDivisionItem3;

  private ACRadioButtonItem staffAssignmentDivisionItem4;

  private ACRadioButtonItem staffAssignmentDivisionItem5;

  private ACRadioButtonItem staffAssignmentDivisionItem6;

  private ACValueArrayRadioButtonGroup staffAssignment2Division;

  private ACListModelAdapter staffAssignment2DivisionModel;

  private ACRadioButtonItem staffAssignment2DivisionItem1;

  private ACRadioButtonItem staffAssignment2DivisionItem2;

  private ACRadioButtonItem staffAssignment2DivisionItem3;

  private ACValueArrayRadioButtonGroup staffAssignment3Division;

  private ACListModelAdapter staffAssignment3DivisionModel;

  private ACRadioButtonItem staffAssignment3DivisionItem1;

  private ACRadioButtonItem staffAssignment3DivisionItem2;

  private ACValueArrayRadioButtonGroup nightWorkDivision;

  private ACLabelContainer nightWorkDivisionContainer;

  private ACListModelAdapter nightWorkDivisionModel;

  private ACRadioButtonItem nightWorkDivisionItem1;

  private ACRadioButtonItem nightWorkDivisionItem2;

  private ACRadioButtonItem nightWorkDivisionItem3;

  private ACRadioButtonItem nightWorkDivisionItem4;

  private ACRadioButtonItem nightWorkDivisionItem6;

  private ACRadioButtonItem nightWorkDivisionItem5;

  private ACValueArrayRadioButtonGroup staffLack;

  private ACLabelContainer staffLackContainer;

  private ACListModelAdapter staffLackModel;

  private ACRadioButtonItem staffLackItem1;

  private ACRadioButtonItem staffLackItem2;

  private ACRadioButtonItem staffLackItem3;

  private ACRadioButtonItem staffLackItem4;

  private ACValueArrayRadioButtonGroup unitCareMaintenance;

  private ACLabelContainer unitCareMaintenanceContainer;

  private ACListModelAdapter unitCareMaintenanceModel;

  private ACRadioButtonItem unitCareMaintenanceItem1;

  private ACRadioButtonItem unitCareMaintenanceItem2;

  private ACValueArrayRadioButtonGroup recuperationEnvironmentalH2104;

  private ACLabelContainer recuperationEnvironmentalH2104Container;

  private ACListModelAdapter recuperationEnvironmentalH2104Model;

  private ACRadioButtonItem recuperationEnvironmentalH21104Item1;

  private ACRadioButtonItem recuperationEnvironmentalH21104Item2;

  private ACValueArrayRadioButtonGroup doctorsAssignment;

  private ACLabelContainer doctorsAssignmentContainer;

  private ACListModelAdapter doctorsAssignmentModel;

  private ACRadioButtonItem doctorsAssignmentItem1;

  private ACRadioButtonItem doctorsAssignmentItem2;

  private ACValueArrayRadioButtonGroup youngDementiaPatinetAddRadioGroup;

  private ACLabelContainer youngDementiaPatinetAddRadioGroupContainer;

  private ACListModelAdapter youngDementiaPatinetAddRadioGroupModel;

  private ACRadioButtonItem youngDementiaPatinetAddRadioItem1;

  private ACRadioButtonItem youngDementiaPatinetAddRadioItem2;

  private ACValueArrayRadioButtonGroup meetingAndSendingOffSystem;

  private ACLabelContainer meetingAndSendingOffSystemContainer;

  private ACListModelAdapter meetingAndSendingOffSystemModel;

  private ACRadioButtonItem meetingAndSendingOffSystemItem1;

  private ACRadioButtonItem meetingAndSendingOffSystemItem2;

  private ACValueArrayRadioButtonGroup medicalFoodAddRadioGroup;

  private ACLabelContainer medicalFoodAddRadioGroupContainer;

  private ACListModelAdapter medicalFoodAddRadioGroupModel;

  private ACRadioButtonItem medicalFoodAddRadioItem1;

  private ACRadioButtonItem medicalFoodAddRadioItem2;

  private ACPanel panel2;

  private ACPanel calculationDetails2;

  private ACLabelContainer specialClinicDetailsContainer;

  private ACIntegerCheckBox specialClinicDetailsItem1;

  private ACIntegerCheckBox specialClinicDetailsItem2;

  private ACIntegerCheckBox specialClinicDetailsItem3;

  private ACLabelContainer rehabilitationDetailsContainer;

  private ACIntegerCheckBox rehabilitationDetailsItem1;

  private ACIntegerCheckBox rehabilitationDetailsItem3;

  private ACIntegerCheckBox rehabilitationDetailsItem4;

  private ACIntegerCheckBox rehabilitationDetailsItem5;

  private ACIntegerCheckBox rehabilitationDetailsItem6;

  private ACValueArrayRadioButtonGroup serviceAddProvisionStructuralRadioGroup;

  private ACLabelContainer serviceAddProvisionStructuralRadioGroupContainer;

  private ACListModelAdapter serviceAddProvisionStructuralRadioGroupModel;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem1;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem2;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem3;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem4;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem5;

  private ACValueArrayRadioButtonGroup staffUpgradeRadioGroup;

  private ACLabelContainer staffUpgradeRadioGroupContainer;

  private ACListModelAdapter staffUpgradeRadioGroupModel;

  private ACRadioButtonItem staffUpgradeRadioItem1;

  private ACRadioButtonItem staffUpgradeRadioItem2;

  private ACRadioButtonItem staffUpgradeRadioItem3;

  private ACRadioButtonItem staffUpgradeRadioItem4;

  private ACRadioButtonItem staffUpgradeRadioItem5;

  private ACGroupBox standardMoneyGroup;

  private ACLabelContainer dinnerContainer;

  private ACTextField dinnerTotal;

  private ACBackLabelContainer dinnerDetailsContainer;

  private ACLabel dinnerMorningLabel;

  private ACTextField dinnerMorning;

  private ACLabel dinnerNoonLabel;

  private ACTextField dinnerNoon;

  private ACLabel dinnerNightLabel;

  private ACTextField dinnerNight;

  private ACLabel dinnerDenomination;

  private ACLabelContainer unitRoomContainer;

  private ACTextField unitRoom;

  private ACLabel unitRoomLabel;

  private ACLabelContainer unitSemiRoomContainer;

  private ACTextField unitSemiRoom;

  private ACLabel unitSemiRoomLabel;

  private ACLabelContainer normalRoomContainer;

  private ACTextField normalRoom;

  private ACLabel normalRoomLabel;

  private ACLabelContainer tasyouRoomContainer;

  private ACTextField tasyouRoom;

  private ACLabel tasyouRoomLabel;

  //getter

  /**
   * ���ƃO���[�v���擾���܂��B
   * @return ���ƃO���[�v
   */
  public ACGroupBox getMainGroup(){
    if(mainGroup==null){

      mainGroup = new ACGroupBox();

      mainGroup.setText("�Z�������×{���i�a�@�×{�^�j");

      mainGroup.setFollowChildEnabled(true);

      mainGroup.setHgrid(200);

      addMainGroup();
    }
    return mainGroup;

  }

  /**
   * �^�u���擾���܂��B
   * @return �^�u
   */
  public JTabbedPane getTab(){
    if(tab==null){

      tab = new JTabbedPane();

      addTab();
    }
    return tab;

  }

  /**
   * �p�l��1���擾���܂��B
   * @return �p�l��1
   */
  public ACPanel getPanel1(){
    if(panel1==null){

      panel1 = new ACPanel();

      panel1.setFollowChildEnabled(true);

      addPanel1();
    }
    return panel1;

  }

  /**
   * �Z�荀�ڗ̈���擾���܂��B
   * @return �Z�荀�ڗ̈�
   */
  public ACPanel getCalculationDetails(){
    if(calculationDetails==null){

      calculationDetails = new ACPanel();

      calculationDetails.setFollowChildEnabled(true);

      calculationDetails.setHgrid(200);

      addCalculationDetails();
    }
    return calculationDetails;

  }

  /**
   * �{�݋敪���W�I�O���[�v���擾���܂��B
   * @return �{�݋敪���W�I�O���[�v
   */
  public ACValueArrayRadioButtonGroup getFacilitiesDivision(){
    if(facilitiesDivision==null){

      facilitiesDivision = new ACValueArrayRadioButtonGroup();

      getFacilitiesDivisionContainer().setText("�{�ݓ��̋敪");

      facilitiesDivision.setBindPath("1230124");

      facilitiesDivision.setUseClearButton(false);

      facilitiesDivision.setModel(getFacilitiesDivisionModel());

      facilitiesDivision.setValues(new int[]{1,2,3,4});

      addFacilitiesDivision();
    }
    return facilitiesDivision;

  }

  /**
   * �{�݋敪���W�I�O���[�v�R���e�i���擾���܂��B
   * @return �{�݋敪���W�I�O���[�v�R���e�i
   */
  protected ACLabelContainer getFacilitiesDivisionContainer(){
    if(facilitiesDivisionContainer==null){
      facilitiesDivisionContainer = new ACLabelContainer();
      facilitiesDivisionContainer.setFollowChildEnabled(true);
      facilitiesDivisionContainer.setVAlignment(VRLayout.CENTER);
      facilitiesDivisionContainer.add(getFacilitiesDivision(), null);
    }
    return facilitiesDivisionContainer;
  }

  /**
   * �{�݋敪���W�I�O���[�v���f�����擾���܂��B
   * @return �{�݋敪���W�I�O���[�v���f��
   */
  protected ACListModelAdapter getFacilitiesDivisionModel(){
    if(facilitiesDivisionModel==null){
      facilitiesDivisionModel = new ACListModelAdapter();
      addFacilitiesDivisionModel();
    }
    return facilitiesDivisionModel;
  }

  /**
   * �a�@�×{�^���擾���܂��B
   * @return �a�@�×{�^
   */
  public ACRadioButtonItem getFacilitiesDivisionItem1(){
    if(facilitiesDivisionItem1==null){

      facilitiesDivisionItem1 = new ACRadioButtonItem();

      facilitiesDivisionItem1.setText("�a�@�×{�^");

      facilitiesDivisionItem1.setGroup(getFacilitiesDivision());

      facilitiesDivisionItem1.setConstraints(VRLayout.FLOW);

      addFacilitiesDivisionItem1();
    }
    return facilitiesDivisionItem1;

  }

  /**
   * ���j�b�g�^�a�@�×{�^���擾���܂��B
   * @return ���j�b�g�^�a�@�×{�^
   */
  public ACRadioButtonItem getFacilitiesDivisionItem2(){
    if(facilitiesDivisionItem2==null){

      facilitiesDivisionItem2 = new ACRadioButtonItem();

      facilitiesDivisionItem2.setText("���j�b�g�^�a�@�×{�^");

      facilitiesDivisionItem2.setGroup(getFacilitiesDivision());

      facilitiesDivisionItem2.setConstraints(VRLayout.FLOW_RETURN);

      addFacilitiesDivisionItem2();
    }
    return facilitiesDivisionItem2;

  }

  /**
   * �a�@�o�ߌ^���擾���܂��B
   * @return �a�@�o�ߌ^
   */
  public ACRadioButtonItem getFacilitiesDivisionItem3(){
    if(facilitiesDivisionItem3==null){

      facilitiesDivisionItem3 = new ACRadioButtonItem();

      facilitiesDivisionItem3.setText("�a�@�o�ߌ^");

      facilitiesDivisionItem3.setGroup(getFacilitiesDivision());

      facilitiesDivisionItem3.setConstraints(VRLayout.FLOW);

      addFacilitiesDivisionItem3();
    }
    return facilitiesDivisionItem3;

  }

  /**
   * ���j�b�g�^�a�@�o�ߌ^���擾���܂��B
   * @return ���j�b�g�^�a�@�o�ߌ^
   */
  public ACRadioButtonItem getFacilitiesDivisionItem4(){
    if(facilitiesDivisionItem4==null){

      facilitiesDivisionItem4 = new ACRadioButtonItem();

      facilitiesDivisionItem4.setText("���j�b�g�^�a�@�o�ߌ^");

      facilitiesDivisionItem4.setGroup(getFacilitiesDivision());

      facilitiesDivisionItem4.setConstraints(VRLayout.FLOW_RETURN);

      addFacilitiesDivisionItem4();
    }
    return facilitiesDivisionItem4;

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

      staffAssignment1Division.setBindPath("1230126");

      staffAssignment1Division.setUseClearButton(false);

      staffAssignment1Division.setModel(getStaffAssignment1DivisionModel());

      staffAssignment1Division.setValues(new int[]{1,2,3,4,5,6});

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
   * I�^�i�×{�@�\�����^�ȊO�j���擾���܂��B
   * @return I�^�i�×{�@�\�����^�ȊO�j
   */
  public ACRadioButtonItem getStaffAssignmentDivisionItem1(){
    if(staffAssignmentDivisionItem1==null){

      staffAssignmentDivisionItem1 = new ACRadioButtonItem();

      staffAssignmentDivisionItem1.setText("I �^�i�×{�@�\�����^�ȊO�j");

      staffAssignmentDivisionItem1.setGroup(getStaffAssignment1Division());

      staffAssignmentDivisionItem1.setConstraints(VRLayout.FLOW);

      addStaffAssignmentDivisionItem1();
    }
    return staffAssignmentDivisionItem1;

  }

  /**
   * I�^�i�×{�@�\�����^A�j���擾���܂��B
   * @return I�^�i�×{�@�\�����^A�j
   */
  public ACRadioButtonItem getStaffAssignmentDivisionItem2(){
    if(staffAssignmentDivisionItem2==null){

      staffAssignmentDivisionItem2 = new ACRadioButtonItem();

      staffAssignmentDivisionItem2.setText("I �^�i�×{�@�\�����^A�j");

      staffAssignmentDivisionItem2.setGroup(getStaffAssignment1Division());

      staffAssignmentDivisionItem2.setConstraints(VRLayout.FLOW_RETURN);

      addStaffAssignmentDivisionItem2();
    }
    return staffAssignmentDivisionItem2;

  }

  /**
   * I�^�i�×{�@�\�����^B�j���擾���܂��B
   * @return I�^�i�×{�@�\�����^B�j
   */
  public ACRadioButtonItem getStaffAssignmentDivisionItem3(){
    if(staffAssignmentDivisionItem3==null){

      staffAssignmentDivisionItem3 = new ACRadioButtonItem();

      staffAssignmentDivisionItem3.setText("I �^�i�×{�@�\�����^B�j");

      staffAssignmentDivisionItem3.setGroup(getStaffAssignment1Division());

      staffAssignmentDivisionItem3.setConstraints(VRLayout.FLOW_RETURN);

      addStaffAssignmentDivisionItem3();
    }
    return staffAssignmentDivisionItem3;

  }

  /**
   * II�^�i�×{�@�\�����^�ȊO�j���擾���܂��B
   * @return II�^�i�×{�@�\�����^�ȊO�j
   */
  public ACRadioButtonItem getStaffAssignmentDivisionItem4(){
    if(staffAssignmentDivisionItem4==null){

      staffAssignmentDivisionItem4 = new ACRadioButtonItem();

      staffAssignmentDivisionItem4.setText("II�^�i�×{�@�\�����^�ȊO�j");

      staffAssignmentDivisionItem4.setGroup(getStaffAssignment1Division());

      staffAssignmentDivisionItem4.setConstraints(VRLayout.FLOW);

      addStaffAssignmentDivisionItem4();
    }
    return staffAssignmentDivisionItem4;

  }

  /**
   * II�^�i�×{�@�\�����^�j���擾���܂��B
   * @return II�^�i�×{�@�\�����^�j
   */
  public ACRadioButtonItem getStaffAssignmentDivisionItem5(){
    if(staffAssignmentDivisionItem5==null){

      staffAssignmentDivisionItem5 = new ACRadioButtonItem();

      staffAssignmentDivisionItem5.setText("II�^�i�×{�@�\�����^�j");

      staffAssignmentDivisionItem5.setGroup(getStaffAssignment1Division());

      staffAssignmentDivisionItem5.setConstraints(VRLayout.FLOW_RETURN);

      addStaffAssignmentDivisionItem5();
    }
    return staffAssignmentDivisionItem5;

  }

  /**
   * III�^���擾���܂��B
   * @return III�^
   */
  public ACRadioButtonItem getStaffAssignmentDivisionItem6(){
    if(staffAssignmentDivisionItem6==null){

      staffAssignmentDivisionItem6 = new ACRadioButtonItem();

      staffAssignmentDivisionItem6.setText("III �^");

      staffAssignmentDivisionItem6.setGroup(getStaffAssignment1Division());

      staffAssignmentDivisionItem6.setConstraints(VRLayout.FLOW);

      addStaffAssignmentDivisionItem6();
    }
    return staffAssignmentDivisionItem6;

  }

  /**
   * �l���z�u�敪���擾���܂��B
   * @return �l���z�u�敪
   */
  public ACValueArrayRadioButtonGroup getStaffAssignment2Division(){
    if(staffAssignment2Division==null){

      staffAssignment2Division = new ACValueArrayRadioButtonGroup();

      staffAssignment2Division.setBindPath("1230129");

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
   * �×{�@�\�����^�ȊO���擾���܂��B
   * @return �×{�@�\�����^�ȊO
   */
  public ACRadioButtonItem getStaffAssignment2DivisionItem1(){
    if(staffAssignment2DivisionItem1==null){

      staffAssignment2DivisionItem1 = new ACRadioButtonItem();

      staffAssignment2DivisionItem1.setText("�×{�@�\�����^�ȊO");

      staffAssignment2DivisionItem1.setGroup(getStaffAssignment2Division());

      staffAssignment2DivisionItem1.setConstraints(VRLayout.FLOW);

      addStaffAssignment2DivisionItem1();
    }
    return staffAssignment2DivisionItem1;

  }

  /**
   * �×{�@�\�����^A���擾���܂��B
   * @return �×{�@�\�����^A
   */
  public ACRadioButtonItem getStaffAssignment2DivisionItem2(){
    if(staffAssignment2DivisionItem2==null){

      staffAssignment2DivisionItem2 = new ACRadioButtonItem();

      staffAssignment2DivisionItem2.setText("�×{�@�\�����^A");

      staffAssignment2DivisionItem2.setGroup(getStaffAssignment2Division());

      staffAssignment2DivisionItem2.setConstraints(VRLayout.FLOW);

      addStaffAssignment2DivisionItem2();
    }
    return staffAssignment2DivisionItem2;

  }

  /**
   * �×{�@�\�����^B���擾���܂��B
   * @return �×{�@�\�����^B
   */
  public ACRadioButtonItem getStaffAssignment2DivisionItem3(){
    if(staffAssignment2DivisionItem3==null){

      staffAssignment2DivisionItem3 = new ACRadioButtonItem();

      staffAssignment2DivisionItem3.setText("�×{�@�\�����^B");

      staffAssignment2DivisionItem3.setGroup(getStaffAssignment2Division());

      staffAssignment2DivisionItem3.setConstraints(VRLayout.FLOW_RETURN);

      addStaffAssignment2DivisionItem3();
    }
    return staffAssignment2DivisionItem3;

  }

  /**
   * �l���z�u�敪���擾���܂��B
   * @return �l���z�u�敪
   */
  public ACValueArrayRadioButtonGroup getStaffAssignment3Division(){
    if(staffAssignment3Division==null){

      staffAssignment3Division = new ACValueArrayRadioButtonGroup();

      staffAssignment3Division.setBindPath("1230130");

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
  public ACRadioButtonItem getStaffAssignment3DivisionItem1(){
    if(staffAssignment3DivisionItem1==null){

      staffAssignment3DivisionItem1 = new ACRadioButtonItem();

      staffAssignment3DivisionItem1.setText("I �^");

      staffAssignment3DivisionItem1.setGroup(getStaffAssignment3Division());

      staffAssignment3DivisionItem1.setConstraints(VRLayout.FLOW);

      addStaffAssignment3DivisionItem1();
    }
    return staffAssignment3DivisionItem1;

  }

  /**
   * II�^���擾���܂��B
   * @return II�^
   */
  public ACRadioButtonItem getStaffAssignment3DivisionItem2(){
    if(staffAssignment3DivisionItem2==null){

      staffAssignment3DivisionItem2 = new ACRadioButtonItem();

      staffAssignment3DivisionItem2.setText("II �^");

      staffAssignment3DivisionItem2.setGroup(getStaffAssignment3Division());

      staffAssignment3DivisionItem2.setConstraints(VRLayout.FLOW_RETURN);

      addStaffAssignment3DivisionItem2();
    }
    return staffAssignment3DivisionItem2;

  }

  /**
   * ��ԋΖ���������W�I�O���[�v���擾���܂��B
   * @return ��ԋΖ���������W�I�O���[�v
   */
  public ACValueArrayRadioButtonGroup getNightWorkDivision(){
    if(nightWorkDivision==null){

      nightWorkDivision = new ACValueArrayRadioButtonGroup();

      getNightWorkDivisionContainer().setText("��ԋΖ������");

      nightWorkDivision.setBindPath("1230125");

      nightWorkDivision.setNoSelectIndex(0);

      nightWorkDivision.setUseClearButton(false);

      nightWorkDivision.setModel(getNightWorkDivisionModel());

      nightWorkDivision.setValues(new int[]{1,2,3,4,6,5});

      addNightWorkDivision();
    }
    return nightWorkDivision;

  }

  /**
   * ��ԋΖ���������W�I�O���[�v�R���e�i���擾���܂��B
   * @return ��ԋΖ���������W�I�O���[�v�R���e�i
   */
  protected ACLabelContainer getNightWorkDivisionContainer(){
    if(nightWorkDivisionContainer==null){
      nightWorkDivisionContainer = new ACLabelContainer();
      nightWorkDivisionContainer.setFollowChildEnabled(true);
      nightWorkDivisionContainer.setVAlignment(VRLayout.CENTER);
      nightWorkDivisionContainer.add(getNightWorkDivision(), null);
    }
    return nightWorkDivisionContainer;
  }

  /**
   * ��ԋΖ���������W�I�O���[�v���f�����擾���܂��B
   * @return ��ԋΖ���������W�I�O���[�v���f��
   */
  protected ACListModelAdapter getNightWorkDivisionModel(){
    if(nightWorkDivisionModel==null){
      nightWorkDivisionModel = new ACListModelAdapter();
      addNightWorkDivisionModel();
    }
    return nightWorkDivisionModel;
  }

  /**
   * ��^���擾���܂��B
   * @return ��^
   */
  public ACRadioButtonItem getNightWorkDivisionItem1(){
    if(nightWorkDivisionItem1==null){

      nightWorkDivisionItem1 = new ACRadioButtonItem();

      nightWorkDivisionItem1.setText("��^");

      nightWorkDivisionItem1.setGroup(getNightWorkDivision());

      nightWorkDivisionItem1.setConstraints(VRLayout.FLOW);

      addNightWorkDivisionItem1();
    }
    return nightWorkDivisionItem1;

  }

  /**
   * ���Z�^I���擾���܂��B
   * @return ���Z�^I
   */
  public ACRadioButtonItem getNightWorkDivisionItem2(){
    if(nightWorkDivisionItem2==null){

      nightWorkDivisionItem2 = new ACRadioButtonItem();

      nightWorkDivisionItem2.setText("���Z�^ I");

      nightWorkDivisionItem2.setGroup(getNightWorkDivision());

      nightWorkDivisionItem2.setConstraints(VRLayout.FLOW);

      addNightWorkDivisionItem2();
    }
    return nightWorkDivisionItem2;

  }

  /**
   * ���Z�^II���擾���܂��B
   * @return ���Z�^II
   */
  public ACRadioButtonItem getNightWorkDivisionItem3(){
    if(nightWorkDivisionItem3==null){

      nightWorkDivisionItem3 = new ACRadioButtonItem();

      nightWorkDivisionItem3.setText("���Z�^ II");

      nightWorkDivisionItem3.setGroup(getNightWorkDivision());

      nightWorkDivisionItem3.setConstraints(VRLayout.FLOW);

      addNightWorkDivisionItem3();
    }
    return nightWorkDivisionItem3;

  }

  /**
   * ���Z�^III���擾���܂��B
   * @return ���Z�^III
   */
  public ACRadioButtonItem getNightWorkDivisionItem4(){
    if(nightWorkDivisionItem4==null){

      nightWorkDivisionItem4 = new ACRadioButtonItem();

      nightWorkDivisionItem4.setText("���Z�^ III");

      nightWorkDivisionItem4.setGroup(getNightWorkDivision());

      nightWorkDivisionItem4.setConstraints(VRLayout.FLOW_RETURN);

      addNightWorkDivisionItem4();
    }
    return nightWorkDivisionItem4;

  }

  /**
   * ���Z�^IV���擾���܂��B
   * @return ���Z�^IV
   */
  public ACRadioButtonItem getNightWorkDivisionItem6(){
    if(nightWorkDivisionItem6==null){

      nightWorkDivisionItem6 = new ACRadioButtonItem();

      nightWorkDivisionItem6.setText("���Z�^ IV");

      nightWorkDivisionItem6.setGroup(getNightWorkDivision());

      nightWorkDivisionItem6.setConstraints(VRLayout.FLOW);

      addNightWorkDivisionItem6();
    }
    return nightWorkDivisionItem6;

  }

  /**
   * ���Z�^���擾���܂��B
   * @return ���Z�^
   */
  public ACRadioButtonItem getNightWorkDivisionItem5(){
    if(nightWorkDivisionItem5==null){

      nightWorkDivisionItem5 = new ACRadioButtonItem();

      nightWorkDivisionItem5.setText("���Z�^");

      nightWorkDivisionItem5.setGroup(getNightWorkDivision());

      nightWorkDivisionItem5.setConstraints(VRLayout.FLOW);

      addNightWorkDivisionItem5();
    }
    return nightWorkDivisionItem5;

  }

  /**
   * �E���̌����ɂ�錸�Z�̏󋵂��擾���܂��B
   * @return �E���̌����ɂ�錸�Z�̏�
   */
  public ACValueArrayRadioButtonGroup getStaffLack(){
    if(staffLack==null){

      staffLack = new ACValueArrayRadioButtonGroup();

      getStaffLackContainer().setText("�E���̌����ɂ�錸�Z�̏�");

      staffLack.setBindPath("1230109");

      staffLack.setUseClearButton(false);

      staffLack.setModel(getStaffLackModel());

      staffLack.setValues(new int[]{1,2,3,4});

      addStaffLack();
    }
    return staffLack;

  }

  /**
   * �E���̌����ɂ�錸�Z�̏󋵃R���e�i���擾���܂��B
   * @return �E���̌����ɂ�錸�Z�̏󋵃R���e�i
   */
  protected ACLabelContainer getStaffLackContainer(){
    if(staffLackContainer==null){
      staffLackContainer = new ACLabelContainer();
      staffLackContainer.setFollowChildEnabled(true);
      staffLackContainer.setVAlignment(VRLayout.CENTER);
      staffLackContainer.add(getStaffLack(), null);
    }
    return staffLackContainer;
  }

  /**
   * �E���̌����ɂ�錸�Z�̏󋵃��f�����擾���܂��B
   * @return �E���̌����ɂ�錸�Z�̏󋵃��f��
   */
  protected ACListModelAdapter getStaffLackModel(){
    if(staffLackModel==null){
      staffLackModel = new ACListModelAdapter();
      addStaffLackModel();
    }
    return staffLackModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getStaffLackItem1(){
    if(staffLackItem1==null){

      staffLackItem1 = new ACRadioButtonItem();

      staffLackItem1.setText("�Ȃ�");

      staffLackItem1.setGroup(getStaffLack());

      staffLackItem1.setConstraints(VRLayout.FLOW);

      addStaffLackItem1();
    }
    return staffLackItem1;

  }

  /**
   * ��t���擾���܂��B
   * @return ��t
   */
  public ACRadioButtonItem getStaffLackItem2(){
    if(staffLackItem2==null){

      staffLackItem2 = new ACRadioButtonItem();

      staffLackItem2.setText("��t");

      staffLackItem2.setGroup(getStaffLack());

      staffLackItem2.setConstraints(VRLayout.FLOW);

      addStaffLackItem2();
    }
    return staffLackItem2;

  }

  /**
   * �Ō�E�����擾���܂��B
   * @return �Ō�E��
   */
  public ACRadioButtonItem getStaffLackItem3(){
    if(staffLackItem3==null){

      staffLackItem3 = new ACRadioButtonItem();

      staffLackItem3.setText("�Ō�E��");

      staffLackItem3.setGroup(getStaffLack());

      staffLackItem3.setConstraints(VRLayout.FLOW);

      addStaffLackItem3();
    }
    return staffLackItem3;

  }

  /**
   * ���E�����擾���܂��B
   * @return ���E��
   */
  public ACRadioButtonItem getStaffLackItem4(){
    if(staffLackItem4==null){

      staffLackItem4 = new ACRadioButtonItem();

      staffLackItem4.setText("���E��");

      staffLackItem4.setGroup(getStaffLack());

      staffLackItem4.setConstraints(VRLayout.FLOW);

      addStaffLackItem4();
    }
    return staffLackItem4;

  }

  /**
   * ���j�b�g�P�A�̐����擾���܂��B
   * @return ���j�b�g�P�A�̐�
   */
  public ACValueArrayRadioButtonGroup getUnitCareMaintenance(){
    if(unitCareMaintenance==null){

      unitCareMaintenance = new ACValueArrayRadioButtonGroup();

      getUnitCareMaintenanceContainer().setText("���j�b�g�P�A�̐�");

      unitCareMaintenance.setBindPath("1230127");

      unitCareMaintenance.setUseClearButton(false);

      unitCareMaintenance.setModel(getUnitCareMaintenanceModel());

      unitCareMaintenance.setValues(new int[]{1,2});

      addUnitCareMaintenance();
    }
    return unitCareMaintenance;

  }

  /**
   * ���j�b�g�P�A�̐��R���e�i���擾���܂��B
   * @return ���j�b�g�P�A�̐��R���e�i
   */
  protected ACLabelContainer getUnitCareMaintenanceContainer(){
    if(unitCareMaintenanceContainer==null){
      unitCareMaintenanceContainer = new ACLabelContainer();
      unitCareMaintenanceContainer.setFollowChildEnabled(true);
      unitCareMaintenanceContainer.setVAlignment(VRLayout.CENTER);
      unitCareMaintenanceContainer.add(getUnitCareMaintenance(), null);
    }
    return unitCareMaintenanceContainer;
  }

  /**
   * ���j�b�g�P�A�̐����f�����擾���܂��B
   * @return ���j�b�g�P�A�̐����f��
   */
  protected ACListModelAdapter getUnitCareMaintenanceModel(){
    if(unitCareMaintenanceModel==null){
      unitCareMaintenanceModel = new ACListModelAdapter();
      addUnitCareMaintenanceModel();
    }
    return unitCareMaintenanceModel;
  }

  /**
   * �Ή��s���擾���܂��B
   * @return �Ή��s��
   */
  public ACRadioButtonItem getUnitCareMaintenanceItem1(){
    if(unitCareMaintenanceItem1==null){

      unitCareMaintenanceItem1 = new ACRadioButtonItem();

      unitCareMaintenanceItem1.setText("�Ή��s��");

      unitCareMaintenanceItem1.setGroup(getUnitCareMaintenance());

      unitCareMaintenanceItem1.setConstraints(VRLayout.FLOW);

      addUnitCareMaintenanceItem1();
    }
    return unitCareMaintenanceItem1;

  }

  /**
   * �Ή����擾���܂��B
   * @return �Ή���
   */
  public ACRadioButtonItem getUnitCareMaintenanceItem2(){
    if(unitCareMaintenanceItem2==null){

      unitCareMaintenanceItem2 = new ACRadioButtonItem();

      unitCareMaintenanceItem2.setText("�Ή���");

      unitCareMaintenanceItem2.setGroup(getUnitCareMaintenance());

      unitCareMaintenanceItem2.setConstraints(VRLayout.FLOW);

      addUnitCareMaintenanceItem2();
    }
    return unitCareMaintenanceItem2;

  }

  /**
   * �×{������W�I�O���[�v���擾���܂��B
   * @return �×{������W�I�O���[�v
   */
  public ACValueArrayRadioButtonGroup getRecuperationEnvironmentalH2104(){
    if(recuperationEnvironmentalH2104==null){

      recuperationEnvironmentalH2104 = new ACValueArrayRadioButtonGroup();

      getRecuperationEnvironmentalH2104Container().setText("�×{���");

      recuperationEnvironmentalH2104.setBindPath("1230123");

      recuperationEnvironmentalH2104.setUseClearButton(false);

      recuperationEnvironmentalH2104.setModel(getRecuperationEnvironmentalH2104Model());

      recuperationEnvironmentalH2104.setValues(new int[]{1,2});

      addRecuperationEnvironmentalH2104();
    }
    return recuperationEnvironmentalH2104;

  }

  /**
   * �×{������W�I�O���[�v�R���e�i���擾���܂��B
   * @return �×{������W�I�O���[�v�R���e�i
   */
  protected ACLabelContainer getRecuperationEnvironmentalH2104Container(){
    if(recuperationEnvironmentalH2104Container==null){
      recuperationEnvironmentalH2104Container = new ACLabelContainer();
      recuperationEnvironmentalH2104Container.setFollowChildEnabled(true);
      recuperationEnvironmentalH2104Container.setVAlignment(VRLayout.CENTER);
      recuperationEnvironmentalH2104Container.add(getRecuperationEnvironmentalH2104(), null);
    }
    return recuperationEnvironmentalH2104Container;
  }

  /**
   * �×{������W�I�O���[�v���f�����擾���܂��B
   * @return �×{������W�I�O���[�v���f��
   */
  protected ACListModelAdapter getRecuperationEnvironmentalH2104Model(){
    if(recuperationEnvironmentalH2104Model==null){
      recuperationEnvironmentalH2104Model = new ACListModelAdapter();
      addRecuperationEnvironmentalH2104Model();
    }
    return recuperationEnvironmentalH2104Model;
  }

  /**
   * ��^���擾���܂��B
   * @return ��^
   */
  public ACRadioButtonItem getRecuperationEnvironmentalH21104Item1(){
    if(recuperationEnvironmentalH21104Item1==null){

      recuperationEnvironmentalH21104Item1 = new ACRadioButtonItem();

      recuperationEnvironmentalH21104Item1.setText("��^");

      recuperationEnvironmentalH21104Item1.setGroup(getRecuperationEnvironmentalH2104());

      addRecuperationEnvironmentalH21104Item1();
    }
    return recuperationEnvironmentalH21104Item1;

  }

  /**
   * ���Z�^I���擾���܂��B
   * @return ���Z�^I
   */
  public ACRadioButtonItem getRecuperationEnvironmentalH21104Item2(){
    if(recuperationEnvironmentalH21104Item2==null){

      recuperationEnvironmentalH21104Item2 = new ACRadioButtonItem();

      recuperationEnvironmentalH21104Item2.setText("���Z�^");

      recuperationEnvironmentalH21104Item2.setGroup(getRecuperationEnvironmentalH2104());

      addRecuperationEnvironmentalH21104Item2();
    }
    return recuperationEnvironmentalH21104Item2;

  }

  /**
   * ��t�̔z�u����W�I�O���[�v���擾���܂��B
   * @return ��t�̔z�u����W�I�O���[�v
   */
  public ACValueArrayRadioButtonGroup getDoctorsAssignment(){
    if(doctorsAssignment==null){

      doctorsAssignment = new ACValueArrayRadioButtonGroup();

      getDoctorsAssignmentContainer().setText("��t�̔z�u�");

      doctorsAssignment.setBindPath("1230105");

      doctorsAssignment.setUseClearButton(false);

      doctorsAssignment.setModel(getDoctorsAssignmentModel());

      doctorsAssignment.setValues(new int[]{1,2});

      addDoctorsAssignment();
    }
    return doctorsAssignment;

  }

  /**
   * ��t�̔z�u����W�I�O���[�v�R���e�i���擾���܂��B
   * @return ��t�̔z�u����W�I�O���[�v�R���e�i
   */
  protected ACLabelContainer getDoctorsAssignmentContainer(){
    if(doctorsAssignmentContainer==null){
      doctorsAssignmentContainer = new ACLabelContainer();
      doctorsAssignmentContainer.setFollowChildEnabled(true);
      doctorsAssignmentContainer.setVAlignment(VRLayout.CENTER);
      doctorsAssignmentContainer.add(getDoctorsAssignment(), null);
    }
    return doctorsAssignmentContainer;
  }

  /**
   * ��t�̔z�u����W�I�O���[�v���f�����擾���܂��B
   * @return ��t�̔z�u����W�I�O���[�v���f��
   */
  protected ACListModelAdapter getDoctorsAssignmentModel(){
    if(doctorsAssignmentModel==null){
      doctorsAssignmentModel = new ACListModelAdapter();
      addDoctorsAssignmentModel();
    }
    return doctorsAssignmentModel;
  }

  /**
   * ����擾���܂��B
   * @return �
   */
  public ACRadioButtonItem getDoctorsAssignmentItem1(){
    if(doctorsAssignmentItem1==null){

      doctorsAssignmentItem1 = new ACRadioButtonItem();

      doctorsAssignmentItem1.setText("�");

      doctorsAssignmentItem1.setGroup(getDoctorsAssignment());

      addDoctorsAssignmentItem1();
    }
    return doctorsAssignmentItem1;

  }

  /**
   * ��Ö@�{�s�K����49��K�p���擾���܂��B
   * @return ��Ö@�{�s�K����49��K�p
   */
  public ACRadioButtonItem getDoctorsAssignmentItem2(){
    if(doctorsAssignmentItem2==null){

      doctorsAssignmentItem2 = new ACRadioButtonItem();

      doctorsAssignmentItem2.setText("��Ö@�{�s�K����49��K�p");

      doctorsAssignmentItem2.setGroup(getDoctorsAssignment());

      addDoctorsAssignmentItem2();
    }
    return doctorsAssignmentItem2;

  }

  /**
   * ��N���F�m�Ǘ��p�Ҏ�����Z���擾���܂��B
   * @return ��N���F�m�Ǘ��p�Ҏ�����Z
   */
  public ACValueArrayRadioButtonGroup getYoungDementiaPatinetAddRadioGroup(){
    if(youngDementiaPatinetAddRadioGroup==null){

      youngDementiaPatinetAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getYoungDementiaPatinetAddRadioGroupContainer().setText("��N���F�m�Ǘ��p�Ҏ�����Z");

      youngDementiaPatinetAddRadioGroup.setBindPath("1230120");

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
   * ���}�̐����W�I�O���[�v���擾���܂��B
   * @return ���}�̐����W�I�O���[�v
   */
  public ACValueArrayRadioButtonGroup getMeetingAndSendingOffSystem(){
    if(meetingAndSendingOffSystem==null){

      meetingAndSendingOffSystem = new ACValueArrayRadioButtonGroup();

      getMeetingAndSendingOffSystemContainer().setText("���}�̐�");

      meetingAndSendingOffSystem.setBindPath("1230106");

      meetingAndSendingOffSystem.setUseClearButton(false);

      meetingAndSendingOffSystem.setModel(getMeetingAndSendingOffSystemModel());

      meetingAndSendingOffSystem.setValues(new int[]{1,2});

      addMeetingAndSendingOffSystem();
    }
    return meetingAndSendingOffSystem;

  }

  /**
   * ���}�̐����W�I�O���[�v�R���e�i���擾���܂��B
   * @return ���}�̐����W�I�O���[�v�R���e�i
   */
  protected ACLabelContainer getMeetingAndSendingOffSystemContainer(){
    if(meetingAndSendingOffSystemContainer==null){
      meetingAndSendingOffSystemContainer = new ACLabelContainer();
      meetingAndSendingOffSystemContainer.setFollowChildEnabled(true);
      meetingAndSendingOffSystemContainer.setVAlignment(VRLayout.CENTER);
      meetingAndSendingOffSystemContainer.add(getMeetingAndSendingOffSystem(), null);
    }
    return meetingAndSendingOffSystemContainer;
  }

  /**
   * ���}�̐����W�I�O���[�v���f�����擾���܂��B
   * @return ���}�̐����W�I�O���[�v���f��
   */
  protected ACListModelAdapter getMeetingAndSendingOffSystemModel(){
    if(meetingAndSendingOffSystemModel==null){
      meetingAndSendingOffSystemModel = new ACListModelAdapter();
      addMeetingAndSendingOffSystemModel();
    }
    return meetingAndSendingOffSystemModel;
  }

  /**
   * �Ή��s���擾���܂��B
   * @return �Ή��s��
   */
  public ACRadioButtonItem getMeetingAndSendingOffSystemItem1(){
    if(meetingAndSendingOffSystemItem1==null){

      meetingAndSendingOffSystemItem1 = new ACRadioButtonItem();

      meetingAndSendingOffSystemItem1.setText("�Ή��s��");

      meetingAndSendingOffSystemItem1.setGroup(getMeetingAndSendingOffSystem());

      addMeetingAndSendingOffSystemItem1();
    }
    return meetingAndSendingOffSystemItem1;

  }

  /**
   * �Ή����擾���܂��B
   * @return �Ή���
   */
  public ACRadioButtonItem getMeetingAndSendingOffSystemItem2(){
    if(meetingAndSendingOffSystemItem2==null){

      meetingAndSendingOffSystemItem2 = new ACRadioButtonItem();

      meetingAndSendingOffSystemItem2.setText("�Ή���");

      meetingAndSendingOffSystemItem2.setGroup(getMeetingAndSendingOffSystem());

      addMeetingAndSendingOffSystemItem2();
    }
    return meetingAndSendingOffSystemItem2;

  }

  /**
   * �×{�H���Z���擾���܂��B
   * @return �×{�H���Z
   */
  public ACValueArrayRadioButtonGroup getMedicalFoodAddRadioGroup(){
    if(medicalFoodAddRadioGroup==null){

      medicalFoodAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getMedicalFoodAddRadioGroupContainer().setText("�×{�H���Z");

      medicalFoodAddRadioGroup.setBindPath("1230121");

      medicalFoodAddRadioGroup.setNoSelectIndex(0);

      medicalFoodAddRadioGroup.setUseClearButton(false);

      medicalFoodAddRadioGroup.setModel(getMedicalFoodAddRadioGroupModel());

      medicalFoodAddRadioGroup.setValues(new int[]{1,2});

      addMedicalFoodAddRadioGroup();
    }
    return medicalFoodAddRadioGroup;

  }

  /**
   * �×{�H���Z�R���e�i���擾���܂��B
   * @return �×{�H���Z�R���e�i
   */
  protected ACLabelContainer getMedicalFoodAddRadioGroupContainer(){
    if(medicalFoodAddRadioGroupContainer==null){
      medicalFoodAddRadioGroupContainer = new ACLabelContainer();
      medicalFoodAddRadioGroupContainer.setFollowChildEnabled(true);
      medicalFoodAddRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      medicalFoodAddRadioGroupContainer.add(getMedicalFoodAddRadioGroup(), null);
    }
    return medicalFoodAddRadioGroupContainer;
  }

  /**
   * �×{�H���Z���f�����擾���܂��B
   * @return �×{�H���Z���f��
   */
  protected ACListModelAdapter getMedicalFoodAddRadioGroupModel(){
    if(medicalFoodAddRadioGroupModel==null){
      medicalFoodAddRadioGroupModel = new ACListModelAdapter();
      addMedicalFoodAddRadioGroupModel();
    }
    return medicalFoodAddRadioGroupModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getMedicalFoodAddRadioItem1(){
    if(medicalFoodAddRadioItem1==null){

      medicalFoodAddRadioItem1 = new ACRadioButtonItem();

      medicalFoodAddRadioItem1.setText("�Ȃ�");

      medicalFoodAddRadioItem1.setGroup(getMedicalFoodAddRadioGroup());

      medicalFoodAddRadioItem1.setConstraints(VRLayout.FLOW);

      addMedicalFoodAddRadioItem1();
    }
    return medicalFoodAddRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getMedicalFoodAddRadioItem2(){
    if(medicalFoodAddRadioItem2==null){

      medicalFoodAddRadioItem2 = new ACRadioButtonItem();

      medicalFoodAddRadioItem2.setText("����");

      medicalFoodAddRadioItem2.setGroup(getMedicalFoodAddRadioGroup());

      medicalFoodAddRadioItem2.setConstraints(VRLayout.FLOW);

      addMedicalFoodAddRadioItem2();
    }
    return medicalFoodAddRadioItem2;

  }

  /**
   * �p�l��2���擾���܂��B
   * @return �p�l��2
   */
  public ACPanel getPanel2(){
    if(panel2==null){

      panel2 = new ACPanel();

      panel2.setFollowChildEnabled(true);

      addPanel2();
    }
    return panel2;

  }

  /**
   * �Z�荀�ڗ̈���擾���܂��B
   * @return �Z�荀�ڗ̈�
   */
  public ACPanel getCalculationDetails2(){
    if(calculationDetails2==null){

      calculationDetails2 = new ACPanel();

      calculationDetails2.setFollowChildEnabled(true);

      calculationDetails2.setHgrid(200);

      addCalculationDetails2();
    }
    return calculationDetails2;

  }

  /**
   * ����f�Ô�ڃR���e�i���擾���܂��B
   * @return ����f�Ô�ڃR���e�i
   */
  public ACLabelContainer getSpecialClinicDetailsContainer(){
    if(specialClinicDetailsContainer==null){

      specialClinicDetailsContainer = new ACLabelContainer();

      specialClinicDetailsContainer.setText("����f�Ô��");

      specialClinicDetailsContainer.setFollowChildEnabled(true);

      addSpecialClinicDetailsContainer();
    }
    return specialClinicDetailsContainer;

  }

  /**
   * �d�ǔ畆��ᇊǗ��w���`�F�b�N���擾���܂��B
   * @return �d�ǔ畆��ᇊǗ��w���`�F�b�N
   */
  public ACIntegerCheckBox getSpecialClinicDetailsItem1(){
    if(specialClinicDetailsItem1==null){

      specialClinicDetailsItem1 = new ACIntegerCheckBox();

      specialClinicDetailsItem1.setText("�d�ǔ畆��ᇊǗ��w��");

      specialClinicDetailsItem1.setBindPath("3010101");

      specialClinicDetailsItem1.setSelectValue(2);

      specialClinicDetailsItem1.setUnSelectValue(1);

      addSpecialClinicDetailsItem1();
    }
    return specialClinicDetailsItem1;

  }

  /**
   * ��܊Ǘ��w���`�F�b�N���擾���܂��B
   * @return ��܊Ǘ��w���`�F�b�N
   */
  public ACIntegerCheckBox getSpecialClinicDetailsItem2(){
    if(specialClinicDetailsItem2==null){

      specialClinicDetailsItem2 = new ACIntegerCheckBox();

      specialClinicDetailsItem2.setText("��܊Ǘ��w��");

      specialClinicDetailsItem2.setBindPath("3010102");

      specialClinicDetailsItem2.setSelectValue(2);

      specialClinicDetailsItem2.setUnSelectValue(1);

      addSpecialClinicDetailsItem2();
    }
    return specialClinicDetailsItem2;

  }

  /**
   * �W�c�R�~���j�P�[�V�����Ö@���擾���܂��B
   * @return �W�c�R�~���j�P�[�V�����Ö@
   */
  public ACIntegerCheckBox getSpecialClinicDetailsItem3(){
    if(specialClinicDetailsItem3==null){

      specialClinicDetailsItem3 = new ACIntegerCheckBox();

      specialClinicDetailsItem3.setText("�W�c�R�~���j�P�[�V�����Ö@");

      specialClinicDetailsItem3.setBindPath("3010112");

      specialClinicDetailsItem3.setSelectValue(2);

      specialClinicDetailsItem3.setUnSelectValue(1);

      addSpecialClinicDetailsItem3();
    }
    return specialClinicDetailsItem3;

  }

  /**
   * ���n�r���񋟑̐��R���e�i���擾���܂��B
   * @return ���n�r���񋟑̐��R���e�i
   */
  public ACLabelContainer getRehabilitationDetailsContainer(){
    if(rehabilitationDetailsContainer==null){

      rehabilitationDetailsContainer = new ACLabelContainer();

      rehabilitationDetailsContainer.setText("���n�r���񋟑̐�");

      rehabilitationDetailsContainer.setFollowChildEnabled(true);

      addRehabilitationDetailsContainer();
    }
    return rehabilitationDetailsContainer;

  }

  /**
   * ���w�Ö@�T�`�F�b�N���擾���܂��B
   * @return ���w�Ö@�T�`�F�b�N
   */
  public ACIntegerCheckBox getRehabilitationDetailsItem1(){
    if(rehabilitationDetailsItem1==null){

      rehabilitationDetailsItem1 = new ACIntegerCheckBox();

      rehabilitationDetailsItem1.setText("���w�Ö@ I");

      rehabilitationDetailsItem1.setBindPath("3010103");

      rehabilitationDetailsItem1.setSelectValue(2);

      rehabilitationDetailsItem1.setUnSelectValue(1);

      addRehabilitationDetailsItem1();
    }
    return rehabilitationDetailsItem1;

  }

  /**
   * ��ƗÖ@�`�F�b�N���擾���܂��B
   * @return ��ƗÖ@�`�F�b�N
   */
  public ACIntegerCheckBox getRehabilitationDetailsItem3(){
    if(rehabilitationDetailsItem3==null){

      rehabilitationDetailsItem3 = new ACIntegerCheckBox();

      rehabilitationDetailsItem3.setText("��ƗÖ@");

      rehabilitationDetailsItem3.setBindPath("3010105");

      rehabilitationDetailsItem3.setSelectValue(2);

      rehabilitationDetailsItem3.setUnSelectValue(1);

      addRehabilitationDetailsItem3();
    }
    return rehabilitationDetailsItem3;

  }

  /**
   * ���꒮�o�Ö@�`�F�b�N���擾���܂��B
   * @return ���꒮�o�Ö@�`�F�b�N
   */
  public ACIntegerCheckBox getRehabilitationDetailsItem4(){
    if(rehabilitationDetailsItem4==null){

      rehabilitationDetailsItem4 = new ACIntegerCheckBox();

      rehabilitationDetailsItem4.setText("���꒮�o�Ö@");

      rehabilitationDetailsItem4.setBindPath("3010106");

      rehabilitationDetailsItem4.setSelectValue(2);

      rehabilitationDetailsItem4.setUnSelectValue(1);

      addRehabilitationDetailsItem4();
    }
    return rehabilitationDetailsItem4;

  }

  /**
   * ���_�ȍ�ƗÖ@�`�F�b�N���擾���܂��B
   * @return ���_�ȍ�ƗÖ@�`�F�b�N
   */
  public ACIntegerCheckBox getRehabilitationDetailsItem5(){
    if(rehabilitationDetailsItem5==null){

      rehabilitationDetailsItem5 = new ACIntegerCheckBox();

      rehabilitationDetailsItem5.setText("���_�ȍ�ƗÖ@");

      rehabilitationDetailsItem5.setBindPath("3010107");

      rehabilitationDetailsItem5.setSelectValue(2);

      rehabilitationDetailsItem5.setUnSelectValue(1);

      addRehabilitationDetailsItem5();
    }
    return rehabilitationDetailsItem5;

  }

  /**
   * ���̑��`�F�b�N���擾���܂��B
   * @return ���̑��`�F�b�N
   */
  public ACIntegerCheckBox getRehabilitationDetailsItem6(){
    if(rehabilitationDetailsItem6==null){

      rehabilitationDetailsItem6 = new ACIntegerCheckBox();

      rehabilitationDetailsItem6.setText("���̑�");

      rehabilitationDetailsItem6.setBindPath("3010108");

      rehabilitationDetailsItem6.setSelectValue(2);

      rehabilitationDetailsItem6.setUnSelectValue(1);

      addRehabilitationDetailsItem6();
    }
    return rehabilitationDetailsItem6;

  }

  /**
   * �T�[�r�X�񋟑̐��������Z���擾���܂��B
   * @return �T�[�r�X�񋟑̐��������Z
   */
  public ACValueArrayRadioButtonGroup getServiceAddProvisionStructuralRadioGroup(){
    if(serviceAddProvisionStructuralRadioGroup==null){

      serviceAddProvisionStructuralRadioGroup = new ACValueArrayRadioButtonGroup();

      getServiceAddProvisionStructuralRadioGroupContainer().setText("�T�[�r�X�񋟑̐��������Z");

      serviceAddProvisionStructuralRadioGroup.setBindPath("1230122");

      serviceAddProvisionStructuralRadioGroup.setVisible(true);

      serviceAddProvisionStructuralRadioGroup.setEnabled(true);

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
   * ���ZI�C���擾���܂��B
   * @return ���ZI�C
   */
  public ACRadioButtonItem getServiceAddProvisionStructuralRadioItem2(){
    if(serviceAddProvisionStructuralRadioItem2==null){

      serviceAddProvisionStructuralRadioItem2 = new ACRadioButtonItem();

      serviceAddProvisionStructuralRadioItem2.setText("���ZI�C");

      serviceAddProvisionStructuralRadioItem2.setGroup(getServiceAddProvisionStructuralRadioGroup());

      serviceAddProvisionStructuralRadioItem2.setConstraints(VRLayout.FLOW);

      addServiceAddProvisionStructuralRadioItem2();
    }
    return serviceAddProvisionStructuralRadioItem2;

  }

  /**
   * ���ZI�����擾���܂��B
   * @return ���ZI��
   */
  public ACRadioButtonItem getServiceAddProvisionStructuralRadioItem3(){
    if(serviceAddProvisionStructuralRadioItem3==null){

      serviceAddProvisionStructuralRadioItem3 = new ACRadioButtonItem();

      serviceAddProvisionStructuralRadioItem3.setText("���ZI��");

      serviceAddProvisionStructuralRadioItem3.setGroup(getServiceAddProvisionStructuralRadioGroup());

      serviceAddProvisionStructuralRadioItem3.setConstraints(VRLayout.FLOW);

      addServiceAddProvisionStructuralRadioItem3();
    }
    return serviceAddProvisionStructuralRadioItem3;

  }

  /**
   * ���ZII���擾���܂��B
   * @return ���ZII
   */
  public ACRadioButtonItem getServiceAddProvisionStructuralRadioItem4(){
    if(serviceAddProvisionStructuralRadioItem4==null){

      serviceAddProvisionStructuralRadioItem4 = new ACRadioButtonItem();

      serviceAddProvisionStructuralRadioItem4.setText("���ZII");

      serviceAddProvisionStructuralRadioItem4.setGroup(getServiceAddProvisionStructuralRadioGroup());

      serviceAddProvisionStructuralRadioItem4.setConstraints(VRLayout.FLOW);

      addServiceAddProvisionStructuralRadioItem4();
    }
    return serviceAddProvisionStructuralRadioItem4;

  }

  /**
   * ���ZIII���擾���܂��B
   * @return ���ZIII
   */
  public ACRadioButtonItem getServiceAddProvisionStructuralRadioItem5(){
    if(serviceAddProvisionStructuralRadioItem5==null){

      serviceAddProvisionStructuralRadioItem5 = new ACRadioButtonItem();

      serviceAddProvisionStructuralRadioItem5.setText("���ZIII");

      serviceAddProvisionStructuralRadioItem5.setGroup(getServiceAddProvisionStructuralRadioGroup());

      serviceAddProvisionStructuralRadioItem5.setConstraints(VRLayout.FLOW);

      addServiceAddProvisionStructuralRadioItem5();
    }
    return serviceAddProvisionStructuralRadioItem5;

  }

  /**
   * ���E���������P���Z���擾���܂��B
   * @return ���E���������P���Z
   */
  public ACValueArrayRadioButtonGroup getStaffUpgradeRadioGroup(){
    if(staffUpgradeRadioGroup==null){

      staffUpgradeRadioGroup = new ACValueArrayRadioButtonGroup();

      getStaffUpgradeRadioGroupContainer().setText("���E���������P���Z");

      staffUpgradeRadioGroup.setBindPath("4");

      staffUpgradeRadioGroup.setEnabled(true);

      staffUpgradeRadioGroup.setUseClearButton(false);

      staffUpgradeRadioGroup.setModel(getStaffUpgradeRadioGroupModel());

      staffUpgradeRadioGroup.setValues(new int[]{1,5,2,3,4});

      addStaffUpgradeRadioGroup();
    }
    return staffUpgradeRadioGroup;

  }

  /**
   * ���E���������P���Z�R���e�i���擾���܂��B
   * @return ���E���������P���Z�R���e�i
   */
  protected ACLabelContainer getStaffUpgradeRadioGroupContainer(){
    if(staffUpgradeRadioGroupContainer==null){
      staffUpgradeRadioGroupContainer = new ACLabelContainer();
      staffUpgradeRadioGroupContainer.setFollowChildEnabled(true);
      staffUpgradeRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      staffUpgradeRadioGroupContainer.add(getStaffUpgradeRadioGroup(), null);
    }
    return staffUpgradeRadioGroupContainer;
  }

  /**
   * ���E���������P���Z���f�����擾���܂��B
   * @return ���E���������P���Z���f��
   */
  protected ACListModelAdapter getStaffUpgradeRadioGroupModel(){
    if(staffUpgradeRadioGroupModel==null){
      staffUpgradeRadioGroupModel = new ACListModelAdapter();
      addStaffUpgradeRadioGroupModel();
    }
    return staffUpgradeRadioGroupModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getStaffUpgradeRadioItem1(){
    if(staffUpgradeRadioItem1==null){

      staffUpgradeRadioItem1 = new ACRadioButtonItem();

      staffUpgradeRadioItem1.setText("�Ȃ�");

      staffUpgradeRadioItem1.setGroup(getStaffUpgradeRadioGroup());

      staffUpgradeRadioItem1.setConstraints(VRLayout.FLOW);

      addStaffUpgradeRadioItem1();
    }
    return staffUpgradeRadioItem1;

  }

  /**
   * ���ZI���擾���܂��B
   * @return ���ZI
   */
  public ACRadioButtonItem getStaffUpgradeRadioItem2(){
    if(staffUpgradeRadioItem2==null){

      staffUpgradeRadioItem2 = new ACRadioButtonItem();

      staffUpgradeRadioItem2.setText("���ZI");

      staffUpgradeRadioItem2.setGroup(getStaffUpgradeRadioGroup());

      staffUpgradeRadioItem2.setConstraints(VRLayout.FLOW);

      addStaffUpgradeRadioItem2();
    }
    return staffUpgradeRadioItem2;

  }

  /**
   * ���ZII���擾���܂��B
   * @return ���ZII
   */
  public ACRadioButtonItem getStaffUpgradeRadioItem3(){
    if(staffUpgradeRadioItem3==null){

      staffUpgradeRadioItem3 = new ACRadioButtonItem();

      staffUpgradeRadioItem3.setText("���ZII");

      staffUpgradeRadioItem3.setGroup(getStaffUpgradeRadioGroup());

      staffUpgradeRadioItem3.setConstraints(VRLayout.FLOW);

      addStaffUpgradeRadioItem3();
    }
    return staffUpgradeRadioItem3;

  }

  /**
   * ���ZIII���擾���܂��B
   * @return ���ZIII
   */
  public ACRadioButtonItem getStaffUpgradeRadioItem4(){
    if(staffUpgradeRadioItem4==null){

      staffUpgradeRadioItem4 = new ACRadioButtonItem();

      staffUpgradeRadioItem4.setText("���ZIII");

      staffUpgradeRadioItem4.setGroup(getStaffUpgradeRadioGroup());

      staffUpgradeRadioItem4.setConstraints(VRLayout.FLOW);

      addStaffUpgradeRadioItem4();
    }
    return staffUpgradeRadioItem4;

  }

  /**
   * ���ZIV���擾���܂��B
   * @return ���ZIV
   */
  public ACRadioButtonItem getStaffUpgradeRadioItem5(){
    if(staffUpgradeRadioItem5==null){

      staffUpgradeRadioItem5 = new ACRadioButtonItem();

      staffUpgradeRadioItem5.setText("���ZIV");

      staffUpgradeRadioItem5.setGroup(getStaffUpgradeRadioGroup());

      staffUpgradeRadioItem5.setConstraints(VRLayout.FLOW);

      addStaffUpgradeRadioItem5();
    }
    return staffUpgradeRadioItem5;

  }

  /**
   * ��z�O���[�v���擾���܂��B
   * @return ��z�O���[�v
   */
  public ACGroupBox getStandardMoneyGroup(){
    if(standardMoneyGroup==null){

      standardMoneyGroup = new ACGroupBox();

      standardMoneyGroup.setText("�H��E���Z���z");

      standardMoneyGroup.setFollowChildEnabled(true);

      standardMoneyGroup.setHgrid(500);

      addStandardMoneyGroup();
    }
    return standardMoneyGroup;

  }

  /**
   * �H���z�E�R���e�i���擾���܂��B
   * @return �H���z�E�R���e�i
   */
  public ACLabelContainer getDinnerContainer(){
    if(dinnerContainer==null){

      dinnerContainer = new ACLabelContainer();

      dinnerContainer.setText("�H��");

      dinnerContainer.setFollowChildEnabled(true);

      addDinnerContainer();
    }
    return dinnerContainer;

  }

  /**
   * �H���z�E���v�E�e�L�X�g���擾���܂��B
   * @return �H���z�E���v�E�e�L�X�g
   */
  public ACTextField getDinnerTotal(){
    if(dinnerTotal==null){

      dinnerTotal = new ACTextField();

      dinnerTotal.setBindPath("1230110");

      dinnerTotal.setColumns(4);

      dinnerTotal.setCharType(VRCharType.ONLY_DIGIT);

      dinnerTotal.setHorizontalAlignment(SwingConstants.RIGHT);

      dinnerTotal.setIMEMode(InputSubset.LATIN);

      dinnerTotal.setMaxLength(4);

      addDinnerTotal();
    }
    return dinnerTotal;

  }

  /**
   * �H���z�E����E�R���e�i���擾���܂��B
   * @return �H���z�E����E�R���e�i
   */
  public ACBackLabelContainer getDinnerDetailsContainer(){
    if(dinnerDetailsContainer==null){

      dinnerDetailsContainer = new ACBackLabelContainer();

      dinnerDetailsContainer.setFollowChildEnabled(true);

      addDinnerDetailsContainer();
    }
    return dinnerDetailsContainer;

  }

  /**
   * �H���z�E���E���x�����擾���܂��B
   * @return �H���z�E���E���x��
   */
  public ACLabel getDinnerMorningLabel(){
    if(dinnerMorningLabel==null){

      dinnerMorningLabel = new ACLabel();

      dinnerMorningLabel.setText("��");

      addDinnerMorningLabel();
    }
    return dinnerMorningLabel;

  }

  /**
   * �H���z�E���E�e�L�X�g���擾���܂��B
   * @return �H���z�E���E�e�L�X�g
   */
  public ACTextField getDinnerMorning(){
    if(dinnerMorning==null){

      dinnerMorning = new ACTextField();

      dinnerMorning.setBindPath("1230111");

      dinnerMorning.setColumns(3);

      dinnerMorning.setCharType(VRCharType.ONLY_DIGIT);

      dinnerMorning.setHorizontalAlignment(SwingConstants.RIGHT);

      dinnerMorning.setIMEMode(InputSubset.LATIN);

      dinnerMorning.setMaxLength(4);

      addDinnerMorning();
    }
    return dinnerMorning;

  }

  /**
   * �H���z�E���E���x�����擾���܂��B
   * @return �H���z�E���E���x��
   */
  public ACLabel getDinnerNoonLabel(){
    if(dinnerNoonLabel==null){

      dinnerNoonLabel = new ACLabel();

      dinnerNoonLabel.setText("��");

      addDinnerNoonLabel();
    }
    return dinnerNoonLabel;

  }

  /**
   * �H���z�E���E�e�L�X�g���擾���܂��B
   * @return �H���z�E���E�e�L�X�g
   */
  public ACTextField getDinnerNoon(){
    if(dinnerNoon==null){

      dinnerNoon = new ACTextField();

      dinnerNoon.setBindPath("1230112");

      dinnerNoon.setColumns(3);

      dinnerNoon.setCharType(VRCharType.ONLY_DIGIT);

      dinnerNoon.setHorizontalAlignment(SwingConstants.RIGHT);

      dinnerNoon.setIMEMode(InputSubset.LATIN);

      dinnerNoon.setMaxLength(4);

      addDinnerNoon();
    }
    return dinnerNoon;

  }

  /**
   * �H���z�E��E���x�����擾���܂��B
   * @return �H���z�E��E���x��
   */
  public ACLabel getDinnerNightLabel(){
    if(dinnerNightLabel==null){

      dinnerNightLabel = new ACLabel();

      dinnerNightLabel.setText("��");

      addDinnerNightLabel();
    }
    return dinnerNightLabel;

  }

  /**
   * �H���z�E��E�e�L�X�g���擾���܂��B
   * @return �H���z�E��E�e�L�X�g
   */
  public ACTextField getDinnerNight(){
    if(dinnerNight==null){

      dinnerNight = new ACTextField();

      dinnerNight.setBindPath("1230113");

      dinnerNight.setColumns(3);

      dinnerNight.setCharType(VRCharType.ONLY_DIGIT);

      dinnerNight.setHorizontalAlignment(SwingConstants.RIGHT);

      dinnerNight.setIMEMode(InputSubset.LATIN);

      dinnerNight.setMaxLength(4);

      addDinnerNight();
    }
    return dinnerNight;

  }

  /**
   * �H���z�E���x�����擾���܂��B
   * @return �H���z�E���x��
   */
  public ACLabel getDinnerDenomination(){
    if(dinnerDenomination==null){

      dinnerDenomination = new ACLabel();

      dinnerDenomination.setText("�i�~�j");

      addDinnerDenomination();
    }
    return dinnerDenomination;

  }

  /**
   * ���j�b�g�^����z�E�R���e�i���擾���܂��B
   * @return ���j�b�g�^����z�E�R���e�i
   */
  public ACLabelContainer getUnitRoomContainer(){
    if(unitRoomContainer==null){

      unitRoomContainer = new ACLabelContainer();

      unitRoomContainer.setText("���j�b�g�^��");

      unitRoomContainer.setFollowChildEnabled(true);

      addUnitRoomContainer();
    }
    return unitRoomContainer;

  }

  /**
   * ���j�b�g�^����z�E�e�L�X�g���擾���܂��B
   * @return ���j�b�g�^����z�E�e�L�X�g
   */
  public ACTextField getUnitRoom(){
    if(unitRoom==null){

      unitRoom = new ACTextField();

      unitRoom.setBindPath("1230114");

      unitRoom.setColumns(4);

      unitRoom.setCharType(VRCharType.ONLY_DIGIT);

      unitRoom.setHorizontalAlignment(SwingConstants.RIGHT);

      unitRoom.setIMEMode(InputSubset.LATIN);

      unitRoom.setMaxLength(4);

      addUnitRoom();
    }
    return unitRoom;

  }

  /**
   * ���j�b�g�^����z�E���x�����擾���܂��B
   * @return ���j�b�g�^����z�E���x��
   */
  public ACLabel getUnitRoomLabel(){
    if(unitRoomLabel==null){

      unitRoomLabel = new ACLabel();

      unitRoomLabel.setText("�i�~�j");

      addUnitRoomLabel();
    }
    return unitRoomLabel;

  }

  /**
   * ���j�b�g�^������z�E�R���e�i���擾���܂��B
   * @return ���j�b�g�^������z�E�R���e�i
   */
  public ACLabelContainer getUnitSemiRoomContainer(){
    if(unitSemiRoomContainer==null){

      unitSemiRoomContainer = new ACLabelContainer();

      unitSemiRoomContainer.setText("���j�b�g�^����");

      unitSemiRoomContainer.setFollowChildEnabled(true);

      addUnitSemiRoomContainer();
    }
    return unitSemiRoomContainer;

  }

  /**
   * ���j�b�g�^������z�E�e�L�X�g���擾���܂��B
   * @return ���j�b�g�^������z�E�e�L�X�g
   */
  public ACTextField getUnitSemiRoom(){
    if(unitSemiRoom==null){

      unitSemiRoom = new ACTextField();

      unitSemiRoom.setBindPath("1230115");

      unitSemiRoom.setColumns(4);

      unitSemiRoom.setCharType(VRCharType.ONLY_DIGIT);

      unitSemiRoom.setHorizontalAlignment(SwingConstants.RIGHT);

      unitSemiRoom.setIMEMode(InputSubset.LATIN);

      unitSemiRoom.setMaxLength(4);

      addUnitSemiRoom();
    }
    return unitSemiRoom;

  }

  /**
   * ���j�b�g�^������z�E���x�����擾���܂��B
   * @return ���j�b�g�^������z�E���x��
   */
  public ACLabel getUnitSemiRoomLabel(){
    if(unitSemiRoomLabel==null){

      unitSemiRoomLabel = new ACLabel();

      unitSemiRoomLabel.setText("�i�~�j");

      addUnitSemiRoomLabel();
    }
    return unitSemiRoomLabel;

  }

  /**
   * �]���^����z�E�R���e�i���擾���܂��B
   * @return �]���^����z�E�R���e�i
   */
  public ACLabelContainer getNormalRoomContainer(){
    if(normalRoomContainer==null){

      normalRoomContainer = new ACLabelContainer();

      normalRoomContainer.setText("�]���^��");

      normalRoomContainer.setFollowChildEnabled(true);

      addNormalRoomContainer();
    }
    return normalRoomContainer;

  }

  /**
   * �]���^����z�E�e�L�X�g���擾���܂��B
   * @return �]���^����z�E�e�L�X�g
   */
  public ACTextField getNormalRoom(){
    if(normalRoom==null){

      normalRoom = new ACTextField();

      normalRoom.setBindPath("1230116");

      normalRoom.setColumns(4);

      normalRoom.setCharType(VRCharType.ONLY_DIGIT);

      normalRoom.setHorizontalAlignment(SwingConstants.RIGHT);

      normalRoom.setIMEMode(InputSubset.LATIN);

      normalRoom.setMaxLength(4);

      addNormalRoom();
    }
    return normalRoom;

  }

  /**
   * �]���^����z�E���x�����擾���܂��B
   * @return �]���^����z�E���x��
   */
  public ACLabel getNormalRoomLabel(){
    if(normalRoomLabel==null){

      normalRoomLabel = new ACLabel();

      normalRoomLabel.setText("�i�~�j");

      addNormalRoomLabel();
    }
    return normalRoomLabel;

  }

  /**
   * ��������z�E�R���e�i���擾���܂��B
   * @return ��������z�E�R���e�i
   */
  public ACLabelContainer getTasyouRoomContainer(){
    if(tasyouRoomContainer==null){

      tasyouRoomContainer = new ACLabelContainer();

      tasyouRoomContainer.setText("������");

      tasyouRoomContainer.setFollowChildEnabled(true);

      addTasyouRoomContainer();
    }
    return tasyouRoomContainer;

  }

  /**
   * ��������z�E�e�L�X�g���擾���܂��B
   * @return ��������z�E�e�L�X�g
   */
  public ACTextField getTasyouRoom(){
    if(tasyouRoom==null){

      tasyouRoom = new ACTextField();

      tasyouRoom.setBindPath("1230117");

      tasyouRoom.setColumns(4);

      tasyouRoom.setCharType(VRCharType.ONLY_DIGIT);

      tasyouRoom.setHorizontalAlignment(SwingConstants.RIGHT);

      tasyouRoom.setIMEMode(InputSubset.LATIN);

      tasyouRoom.setMaxLength(4);

      addTasyouRoom();
    }
    return tasyouRoom;

  }

  /**
   * ��������z�E���x�����擾���܂��B
   * @return ��������z�E���x��
   */
  public ACLabel getTasyouRoomLabel(){
    if(tasyouRoomLabel==null){

      tasyouRoomLabel = new ACLabel();

      tasyouRoomLabel.setText("�i�~�j");

      addTasyouRoomLabel();
    }
    return tasyouRoomLabel;

  }

  /**
   * �R���X�g���N�^�ł��B
   */
  public QO004_12311_201504Design() {

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

    this.add(getMainGroup(), VRLayout.CLIENT);

  }

  /**
   * ���ƃO���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMainGroup(){

    mainGroup.add(getTab(), VRLayout.CLIENT);

  }

  /**
   * �^�u�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTab(){

    tab.addTab("1", getPanel1());

    tab.addTab("2", getPanel2());

  }

  /**
   * �p�l��1�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPanel1(){

    panel1.add(getCalculationDetails(), VRLayout.NORTH);

  }

  /**
   * �Z�荀�ڗ̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalculationDetails(){

    calculationDetails.add(getFacilitiesDivisionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails.add(getStaffAssignmentDivisionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails.add(getNightWorkDivisionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails.add(getStaffLackContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails.add(getUnitCareMaintenanceContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails.add(getRecuperationEnvironmentalH2104Container(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails.add(getDoctorsAssignmentContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails.add(getYoungDementiaPatinetAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails.add(getMeetingAndSendingOffSystemContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails.add(getMedicalFoodAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * �{�݋敪���W�I�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addFacilitiesDivision(){

  }

  /**
   * �{�݋敪���W�I�O���[�v���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addFacilitiesDivisionModel(){

    getFacilitiesDivisionItem1().setButtonIndex(1);

    getFacilitiesDivisionModel().add(getFacilitiesDivisionItem1());

    getFacilitiesDivisionItem2().setButtonIndex(2);

    getFacilitiesDivisionModel().add(getFacilitiesDivisionItem2());

    getFacilitiesDivisionItem3().setButtonIndex(3);

    getFacilitiesDivisionModel().add(getFacilitiesDivisionItem3());

    getFacilitiesDivisionItem4().setButtonIndex(4);

    getFacilitiesDivisionModel().add(getFacilitiesDivisionItem4());

  }

  /**
   * �a�@�×{�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addFacilitiesDivisionItem1(){

  }

  /**
   * ���j�b�g�^�a�@�×{�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addFacilitiesDivisionItem2(){

  }

  /**
   * �a�@�o�ߌ^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addFacilitiesDivisionItem3(){

  }

  /**
   * ���j�b�g�^�a�@�o�ߌ^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addFacilitiesDivisionItem4(){

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

    getStaffAssignmentDivisionItem4().setButtonIndex(4);

    getStaffAssignment1DivisionModel().add(getStaffAssignmentDivisionItem4());

    getStaffAssignmentDivisionItem5().setButtonIndex(5);

    getStaffAssignment1DivisionModel().add(getStaffAssignmentDivisionItem5());

    getStaffAssignmentDivisionItem6().setButtonIndex(6);

    getStaffAssignment1DivisionModel().add(getStaffAssignmentDivisionItem6());

  }

  /**
   * I�^�i�×{�@�\�����^�ȊO�j�ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffAssignmentDivisionItem1(){

  }

  /**
   * I�^�i�×{�@�\�����^A�j�ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffAssignmentDivisionItem2(){

  }

  /**
   * I�^�i�×{�@�\�����^B�j�ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffAssignmentDivisionItem3(){

  }

  /**
   * II�^�i�×{�@�\�����^�ȊO�j�ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffAssignmentDivisionItem4(){

  }

  /**
   * II�^�i�×{�@�\�����^�j�ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffAssignmentDivisionItem5(){

  }

  /**
   * III�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffAssignmentDivisionItem6(){

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

    getStaffAssignment2DivisionItem1().setButtonIndex(1);

    getStaffAssignment2DivisionModel().add(getStaffAssignment2DivisionItem1());

    getStaffAssignment2DivisionItem2().setButtonIndex(2);

    getStaffAssignment2DivisionModel().add(getStaffAssignment2DivisionItem2());

    getStaffAssignment2DivisionItem3().setButtonIndex(3);

    getStaffAssignment2DivisionModel().add(getStaffAssignment2DivisionItem3());

  }

  /**
   * �×{�@�\�����^�ȊO�ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffAssignment2DivisionItem1(){

  }

  /**
   * �×{�@�\�����^A�ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffAssignment2DivisionItem2(){

  }

  /**
   * �×{�@�\�����^B�ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffAssignment2DivisionItem3(){

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

    getStaffAssignment3DivisionItem1().setButtonIndex(1);

    getStaffAssignment3DivisionModel().add(getStaffAssignment3DivisionItem1());

    getStaffAssignment3DivisionItem2().setButtonIndex(2);

    getStaffAssignment3DivisionModel().add(getStaffAssignment3DivisionItem2());

  }

  /**
   * I�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffAssignment3DivisionItem1(){

  }

  /**
   * II�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffAssignment3DivisionItem2(){

  }

  /**
   * ��ԋΖ���������W�I�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addNightWorkDivision(){

  }

  /**
   * ��ԋΖ���������W�I�O���[�v���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addNightWorkDivisionModel(){

    getNightWorkDivisionItem1().setButtonIndex(1);

    getNightWorkDivisionModel().add(getNightWorkDivisionItem1());

    getNightWorkDivisionItem2().setButtonIndex(2);

    getNightWorkDivisionModel().add(getNightWorkDivisionItem2());

    getNightWorkDivisionItem3().setButtonIndex(3);

    getNightWorkDivisionModel().add(getNightWorkDivisionItem3());

    getNightWorkDivisionItem4().setButtonIndex(4);

    getNightWorkDivisionModel().add(getNightWorkDivisionItem4());

    getNightWorkDivisionItem6().setButtonIndex(6);

    getNightWorkDivisionModel().add(getNightWorkDivisionItem6());

    getNightWorkDivisionItem5().setButtonIndex(5);

    getNightWorkDivisionModel().add(getNightWorkDivisionItem5());

  }

  /**
   * ��^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addNightWorkDivisionItem1(){

  }

  /**
   * ���Z�^I�ɓ������ڂ�ǉ����܂��B
   */
  protected void addNightWorkDivisionItem2(){

  }

  /**
   * ���Z�^II�ɓ������ڂ�ǉ����܂��B
   */
  protected void addNightWorkDivisionItem3(){

  }

  /**
   * ���Z�^III�ɓ������ڂ�ǉ����܂��B
   */
  protected void addNightWorkDivisionItem4(){

  }

  /**
   * ���Z�^IV�ɓ������ڂ�ǉ����܂��B
   */
  protected void addNightWorkDivisionItem6(){

  }

  /**
   * ���Z�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addNightWorkDivisionItem5(){

  }

  /**
   * �E���̌����ɂ�錸�Z�̏󋵂ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffLack(){

  }

  /**
   * �E���̌����ɂ�錸�Z�̏󋵃��f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffLackModel(){

    getStaffLackItem1().setButtonIndex(1);

    getStaffLackModel().add(getStaffLackItem1());

    getStaffLackItem2().setButtonIndex(2);

    getStaffLackModel().add(getStaffLackItem2());

    getStaffLackItem3().setButtonIndex(3);

    getStaffLackModel().add(getStaffLackItem3());

    getStaffLackItem4().setButtonIndex(4);

    getStaffLackModel().add(getStaffLackItem4());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffLackItem1(){

  }

  /**
   * ��t�ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffLackItem2(){

  }

  /**
   * �Ō�E���ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffLackItem3(){

  }

  /**
   * ���E���ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffLackItem4(){

  }

  /**
   * ���j�b�g�P�A�̐��ɓ������ڂ�ǉ����܂��B
   */
  protected void addUnitCareMaintenance(){

  }

  /**
   * ���j�b�g�P�A�̐����f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addUnitCareMaintenanceModel(){

    getUnitCareMaintenanceItem1().setButtonIndex(1);

    getUnitCareMaintenanceModel().add(getUnitCareMaintenanceItem1());

    getUnitCareMaintenanceItem2().setButtonIndex(2);

    getUnitCareMaintenanceModel().add(getUnitCareMaintenanceItem2());

  }

  /**
   * �Ή��s�ɓ������ڂ�ǉ����܂��B
   */
  protected void addUnitCareMaintenanceItem1(){

  }

  /**
   * �Ή��ɓ������ڂ�ǉ����܂��B
   */
  protected void addUnitCareMaintenanceItem2(){

  }

  /**
   * �×{������W�I�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addRecuperationEnvironmentalH2104(){

  }

  /**
   * �×{������W�I�O���[�v���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addRecuperationEnvironmentalH2104Model(){

    getRecuperationEnvironmentalH21104Item1().setButtonIndex(1);

    getRecuperationEnvironmentalH2104Model().add(getRecuperationEnvironmentalH21104Item1());

    getRecuperationEnvironmentalH21104Item2().setButtonIndex(2);

    getRecuperationEnvironmentalH2104Model().add(getRecuperationEnvironmentalH21104Item2());

  }

  /**
   * ��^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addRecuperationEnvironmentalH21104Item1(){

  }

  /**
   * ���Z�^I�ɓ������ڂ�ǉ����܂��B
   */
  protected void addRecuperationEnvironmentalH21104Item2(){

  }

  /**
   * ��t�̔z�u����W�I�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addDoctorsAssignment(){

  }

  /**
   * ��t�̔z�u����W�I�O���[�v���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addDoctorsAssignmentModel(){

    getDoctorsAssignmentItem1().setButtonIndex(1);

    getDoctorsAssignmentModel().add(getDoctorsAssignmentItem1());

    getDoctorsAssignmentItem2().setButtonIndex(2);

    getDoctorsAssignmentModel().add(getDoctorsAssignmentItem2());

  }

  /**
   * ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addDoctorsAssignmentItem1(){

  }

  /**
   * ��Ö@�{�s�K����49��K�p�ɓ������ڂ�ǉ����܂��B
   */
  protected void addDoctorsAssignmentItem2(){

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
   * ���}�̐����W�I�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMeetingAndSendingOffSystem(){

  }

  /**
   * ���}�̐����W�I�O���[�v���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addMeetingAndSendingOffSystemModel(){

    getMeetingAndSendingOffSystemItem1().setButtonIndex(1);

    getMeetingAndSendingOffSystemModel().add(getMeetingAndSendingOffSystemItem1());

    getMeetingAndSendingOffSystemItem2().setButtonIndex(2);

    getMeetingAndSendingOffSystemModel().add(getMeetingAndSendingOffSystemItem2());

  }

  /**
   * �Ή��s�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMeetingAndSendingOffSystemItem1(){

  }

  /**
   * �Ή��ɓ������ڂ�ǉ����܂��B
   */
  protected void addMeetingAndSendingOffSystemItem2(){

  }

  /**
   * �×{�H���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFoodAddRadioGroup(){

  }

  /**
   * �×{�H���Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFoodAddRadioGroupModel(){

    getMedicalFoodAddRadioItem1().setButtonIndex(1);

    getMedicalFoodAddRadioGroupModel().add(getMedicalFoodAddRadioItem1());

    getMedicalFoodAddRadioItem2().setButtonIndex(2);

    getMedicalFoodAddRadioGroupModel().add(getMedicalFoodAddRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFoodAddRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFoodAddRadioItem2(){

  }

  /**
   * �p�l��2�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPanel2(){

    panel2.add(getCalculationDetails2(), VRLayout.NORTH);

    panel2.add(getStandardMoneyGroup(), VRLayout.NORTH);

  }

  /**
   * �Z�荀�ڗ̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalculationDetails2(){

    calculationDetails2.add(getSpecialClinicDetailsContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails2.add(getRehabilitationDetailsContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails2.add(getServiceAddProvisionStructuralRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails2.add(getStaffUpgradeRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * ����f�Ô�ڃR���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addSpecialClinicDetailsContainer(){

    specialClinicDetailsContainer.add(getSpecialClinicDetailsItem1(), VRLayout.FLOW);

    specialClinicDetailsContainer.add(getSpecialClinicDetailsItem2(), VRLayout.FLOW_RETURN);

    specialClinicDetailsContainer.add(getSpecialClinicDetailsItem3(), VRLayout.FLOW);

  }

  /**
   * �d�ǔ畆��ᇊǗ��w���`�F�b�N�ɓ������ڂ�ǉ����܂��B
   */
  protected void addSpecialClinicDetailsItem1(){

  }

  /**
   * ��܊Ǘ��w���`�F�b�N�ɓ������ڂ�ǉ����܂��B
   */
  protected void addSpecialClinicDetailsItem2(){

  }

  /**
   * �W�c�R�~���j�P�[�V�����Ö@�ɓ������ڂ�ǉ����܂��B
   */
  protected void addSpecialClinicDetailsItem3(){

  }

  /**
   * ���n�r���񋟑̐��R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addRehabilitationDetailsContainer(){

    rehabilitationDetailsContainer.add(getRehabilitationDetailsItem1(), VRLayout.FLOW);

    rehabilitationDetailsContainer.add(getRehabilitationDetailsItem3(), VRLayout.FLOW_RETURN);

    rehabilitationDetailsContainer.add(getRehabilitationDetailsItem4(), VRLayout.FLOW);

    rehabilitationDetailsContainer.add(getRehabilitationDetailsItem5(), VRLayout.FLOW);

    rehabilitationDetailsContainer.add(getRehabilitationDetailsItem6(), VRLayout.FLOW);

  }

  /**
   * ���w�Ö@�T�`�F�b�N�ɓ������ڂ�ǉ����܂��B
   */
  protected void addRehabilitationDetailsItem1(){

  }

  /**
   * ��ƗÖ@�`�F�b�N�ɓ������ڂ�ǉ����܂��B
   */
  protected void addRehabilitationDetailsItem3(){

  }

  /**
   * ���꒮�o�Ö@�`�F�b�N�ɓ������ڂ�ǉ����܂��B
   */
  protected void addRehabilitationDetailsItem4(){

  }

  /**
   * ���_�ȍ�ƗÖ@�`�F�b�N�ɓ������ڂ�ǉ����܂��B
   */
  protected void addRehabilitationDetailsItem5(){

  }

  /**
   * ���̑��`�F�b�N�ɓ������ڂ�ǉ����܂��B
   */
  protected void addRehabilitationDetailsItem6(){

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

    getServiceAddProvisionStructuralRadioItem2().setButtonIndex(5);

    getServiceAddProvisionStructuralRadioGroupModel().add(getServiceAddProvisionStructuralRadioItem2());

    getServiceAddProvisionStructuralRadioItem3().setButtonIndex(2);

    getServiceAddProvisionStructuralRadioGroupModel().add(getServiceAddProvisionStructuralRadioItem3());

    getServiceAddProvisionStructuralRadioItem4().setButtonIndex(3);

    getServiceAddProvisionStructuralRadioGroupModel().add(getServiceAddProvisionStructuralRadioItem4());

    getServiceAddProvisionStructuralRadioItem5().setButtonIndex(4);

    getServiceAddProvisionStructuralRadioGroupModel().add(getServiceAddProvisionStructuralRadioItem5());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceAddProvisionStructuralRadioItem1(){

  }

  /**
   * ���ZI�C�ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceAddProvisionStructuralRadioItem2(){

  }

  /**
   * ���ZI���ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceAddProvisionStructuralRadioItem3(){

  }

  /**
   * ���ZII�ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceAddProvisionStructuralRadioItem4(){

  }

  /**
   * ���ZIII�ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceAddProvisionStructuralRadioItem5(){

  }

  /**
   * ���E���������P���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffUpgradeRadioGroup(){

  }

  /**
   * ���E���������P���Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffUpgradeRadioGroupModel(){

    getStaffUpgradeRadioItem1().setButtonIndex(1);

    getStaffUpgradeRadioGroupModel().add(getStaffUpgradeRadioItem1());

    getStaffUpgradeRadioItem2().setButtonIndex(5);

    getStaffUpgradeRadioGroupModel().add(getStaffUpgradeRadioItem2());

    getStaffUpgradeRadioItem3().setButtonIndex(2);

    getStaffUpgradeRadioGroupModel().add(getStaffUpgradeRadioItem3());

    getStaffUpgradeRadioItem4().setButtonIndex(3);

    getStaffUpgradeRadioGroupModel().add(getStaffUpgradeRadioItem4());

    getStaffUpgradeRadioItem5().setButtonIndex(4);

    getStaffUpgradeRadioGroupModel().add(getStaffUpgradeRadioItem5());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffUpgradeRadioItem1(){

  }

  /**
   * ���ZI�ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffUpgradeRadioItem2(){

  }

  /**
   * ���ZII�ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffUpgradeRadioItem3(){

  }

  /**
   * ���ZIII�ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffUpgradeRadioItem4(){

  }

  /**
   * ���ZIV�ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffUpgradeRadioItem5(){

  }

  /**
   * ��z�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addStandardMoneyGroup(){

    standardMoneyGroup.add(getDinnerContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    standardMoneyGroup.add(getUnitRoomContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    standardMoneyGroup.add(getUnitSemiRoomContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    standardMoneyGroup.add(getNormalRoomContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    standardMoneyGroup.add(getTasyouRoomContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * �H���z�E�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addDinnerContainer(){

    dinnerContainer.add(getDinnerTotal(), VRLayout.FLOW);

    dinnerContainer.add(getDinnerDetailsContainer(), VRLayout.FLOW);

  }

  /**
   * �H���z�E���v�E�e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addDinnerTotal(){

  }

  /**
   * �H���z�E����E�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addDinnerDetailsContainer(){

    dinnerDetailsContainer.add(getDinnerMorningLabel(), VRLayout.FLOW);

    dinnerDetailsContainer.add(getDinnerMorning(), VRLayout.FLOW);

    dinnerDetailsContainer.add(getDinnerNoonLabel(), VRLayout.FLOW);

    dinnerDetailsContainer.add(getDinnerNoon(), VRLayout.FLOW);

    dinnerDetailsContainer.add(getDinnerNightLabel(), VRLayout.FLOW);

    dinnerDetailsContainer.add(getDinnerNight(), VRLayout.FLOW);

    dinnerDetailsContainer.add(getDinnerDenomination(), VRLayout.FLOW);

  }

  /**
   * �H���z�E���E���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addDinnerMorningLabel(){

  }

  /**
   * �H���z�E���E�e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addDinnerMorning(){

  }

  /**
   * �H���z�E���E���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addDinnerNoonLabel(){

  }

  /**
   * �H���z�E���E�e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addDinnerNoon(){

  }

  /**
   * �H���z�E��E���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addDinnerNightLabel(){

  }

  /**
   * �H���z�E��E�e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addDinnerNight(){

  }

  /**
   * �H���z�E���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addDinnerDenomination(){

  }

  /**
   * ���j�b�g�^����z�E�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addUnitRoomContainer(){

    unitRoomContainer.add(getUnitRoom(), null);

    unitRoomContainer.add(getUnitRoomLabel(), null);

  }

  /**
   * ���j�b�g�^����z�E�e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addUnitRoom(){

  }

  /**
   * ���j�b�g�^����z�E���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addUnitRoomLabel(){

  }

  /**
   * ���j�b�g�^������z�E�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addUnitSemiRoomContainer(){

    unitSemiRoomContainer.add(getUnitSemiRoom(), null);

    unitSemiRoomContainer.add(getUnitSemiRoomLabel(), null);

  }

  /**
   * ���j�b�g�^������z�E�e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addUnitSemiRoom(){

  }

  /**
   * ���j�b�g�^������z�E���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addUnitSemiRoomLabel(){

  }

  /**
   * �]���^����z�E�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addNormalRoomContainer(){

    normalRoomContainer.add(getNormalRoom(), null);

    normalRoomContainer.add(getNormalRoomLabel(), null);

  }

  /**
   * �]���^����z�E�e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addNormalRoom(){

  }

  /**
   * �]���^����z�E���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addNormalRoomLabel(){

  }

  /**
   * ��������z�E�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTasyouRoomContainer(){

    tasyouRoomContainer.add(getTasyouRoom(), null);

    tasyouRoomContainer.add(getTasyouRoomLabel(), null);

  }

  /**
   * ��������z�E�e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTasyouRoom(){

  }

  /**
   * ��������z�E���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addTasyouRoomLabel(){

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
      ACFrame.debugStart(new ACAffairInfo(QO004_12311_201504Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QO004_12311_201504Design getThis() {
    return this;
  }
}
