
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
 * �쐬��: 2009/03/04  ���{�R���s���[�^�[������� ���{�@�K�� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���̑��@�\ (O)
 * �v���Z�X ���Ə����o�^ (004)
 * �v���O���� �Z�������×{���i���V�l�ی��{�݁j (QO004110)
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
 * �Z�������×{���i���V�l�ی��{�݁j��ʍ��ڃf�U�C��(QO004110) 
 */
public class QO004110Design extends QO004ProviderPanel {
  //GUI�R���|�[�l���g

  private ACGroupBox mainGroup;

  private JTabbedPane tab;

  private ACPanel panel1;

  private ACPanel calculationDetails;

  private ACLabelContainer facilitiesDivisionContainer;

  private ACBackLabelContainer facilitiesContainer;

  private ACClearableRadioButtonGroup facilitiesDivision;

  private ACListModelAdapter facilitiesDivisionModel;

  private ACRadioButtonItem facilitiesDivisionItem1;

  private ACRadioButtonItem facilitiesDivisionItem2;

  private ACBackLabelContainer typeContainer;

  private ACClearableRadioButtonGroup staffAssignmentDivision;

  private ACListModelAdapter staffAssignmentDivisionModel;

  private ACRadioButtonItem staffAssignmentDivisionItem1;

  private ACRadioButtonItem staffAssignmentDivisionItem2;

  private ACRadioButtonItem staffAssignmentDivisionItem3;

  private ACClearableRadioButtonGroup nightWorkDivision;

  private ACLabelContainer nightWorkDivisionContainer;

  private ACListModelAdapter nightWorkDivisionModel;

  private ACRadioButtonItem nightWorkDivisionItem1;

  private ACRadioButtonItem nightWorkDivisionItem2;

  private ACClearableRadioButtonGroup staffLack;

  private ACLabelContainer staffLackContainer;

  private ACListModelAdapter staffLackModel;

  private ACRadioButtonItem staffLackItem1;

  private ACRadioButtonItem staffLackItem2;

  private ACRadioButtonItem staffLackItem3;

  private ACRadioButtonItem staffLackItem4;

  private ACRadioButtonItem staffLackItem5;

  private ACRadioButtonItem staffLackItem6;

  private ACRadioButtonItem staffLackItem7;

  private ACClearableRadioButtonGroup unitCareMaintenance;

  private ACLabelContainer unitCareMaintenanceContainer;

  private ACListModelAdapter unitCareMaintenanceModel;

  private ACRadioButtonItem unitCareMaintenanceItem1;

  private ACRadioButtonItem unitCareMaintenanceItem2;

  private ACValueArrayRadioButtonGroup nightStaffDispositionAddRadioGroup;

  private ACLabelContainer nightStaffDispositionAddRadioGroupContainer;

  private ACListModelAdapter nightStaffDispositionAddRadioGroupModel;

  private ACRadioButtonItem nightStaffDispositionAddRadioItem1;

  private ACRadioButtonItem nightStaffDispositionAddRadioItem2;

  private ACClearableRadioButtonGroup rehabilitationReinforcement;

  private ACLabelContainer rehabilitationReinforcementContainer;

  private ACListModelAdapter rehabilitationReinforcementModel;

  private ACRadioButtonItem rehabilitationReinforcementItem1;

  private ACRadioButtonItem rehabilitationReinforcementItem2;

  private ACValueArrayRadioButtonGroup medicalFoodAddRadioGroup;

  private ACLabelContainer medicalFoodAddRadioGroupContainer;

  private ACListModelAdapter medicalFoodAddRadioGroupModel;

  private ACRadioButtonItem medicalFoodAddRadioItem1;

  private ACRadioButtonItem medicalFoodAddRadioItem2;

  private ACClearableRadioButtonGroup meetingAndSendingOffSystem;

  private ACLabelContainer meetingAndSendingOffSystemContainer;

  private ACListModelAdapter meetingAndSendingOffSystemModel;

  private ACRadioButtonItem meetingAndSendingOffSystemItem1;

  private ACRadioButtonItem meetingAndSendingOffSystemItem2;

  private ACClearableRadioButtonGroup dementiaCare;

  private ACLabelContainer dementiaCareContainer;

  private ACListModelAdapter dementiaCareModel;

  private ACRadioButtonItem dementiaCareItem1;

  private ACRadioButtonItem dementiaCareItem2;

  private ACValueArrayRadioButtonGroup youngDementiaPatinetAddRadioGroup;

  private ACLabelContainer youngDementiaPatinetAddRadioGroupContainer;

  private ACListModelAdapter youngDementiaPatinetAddRadioGroupModel;

  private ACRadioButtonItem youngDementiaPatinetAddRadioItem1;

  private ACRadioButtonItem youngDementiaPatinetAddRadioItem2;

  private ACClearableRadioButtonGroup emergencyNetworkAdd;

  private ACLabelContainer emergencyNetworkAddContainer;

  private ACListModelAdapter emergencyNetworkAddModel;

  private ACRadioButtonItem emergencyNetworkAddItem1;

  private ACRadioButtonItem emergencyNetworkAddItem2;

  private ACLabelContainer specialMedicalDetailsContainer;

  private ACIntegerCheckBox specialMedicalDetailsItem1;

  private ACIntegerCheckBox specialMedicalDetailsItem2;

  private ACLabelContainer rehabilitationDetailsContainer;

  private ACIntegerCheckBox rehabilitationDetailsItem1;

  private ACIntegerCheckBox rehabilitationDetailsItem2;

  private ACIntegerCheckBox rehabilitationDetailsItem3;

  private ACClearableRadioButtonGroup MedicalSystemUpkeep;

  private ACLabelContainer MedicalSystemUpkeepContainer;

  private ACListModelAdapter MedicalSystemUpkeepModel;

  private ACRadioButtonItem MedicalSystemUpkeeItem1;

  private ACRadioButtonItem MedicalSystemUpkeeItem2;

  private ACValueArrayRadioButtonGroup serviceAddProvisionStructuralRadioGroup;

  private ACLabelContainer serviceAddProvisionStructuralRadioGroupContainer;

  private ACListModelAdapter serviceAddProvisionStructuralRadioGroupModel;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem1;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem2;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem3;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem4;

  private ACPanel panel2;

  private ACPanel oldLowElementArea;

  private ACGroupBox oldLowH2103Group;

  private ACClearableRadioButtonGroup staffLack_H2103;

  private ACLabelContainer staffLack_H2103Container;

  private ACListModelAdapter staffLack_H2103Model;

  private ACRadioButtonItem staffLackItem1_H2103;

  private ACRadioButtonItem staffLackItem2_H2103;

  private ACRadioButtonItem staffLackItem3_H2103;

  private ACRadioButtonItem staffLackItem4_H2103;

  private ACRadioButtonItem staffLackItem5_H2103;

  private ACRadioButtonItem staffLackItem6_H2103;

  private ACClearableRadioButtonGroup nourishmentControlAdd;

  private ACLabelContainer nourishmentControlAddContainer;

  private ACListModelAdapter nourishmentControlAddModel;

  private ACRadioButtonItem nourishmentControlAddItem1;

  private ACRadioButtonItem nourishmentControlAddItem2;

  private ACRadioButtonItem nourishmentControlAddItem3;

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

  private ACPanel calculationDetails2;

  private ACLabelContainer reduceRateContainer;

  private ACTextField reduceRate;

  private ACLabel percentSign;

  //getter

  /**
   * ���ƃO���[�v���擾���܂��B
   * @return ���ƃO���[�v
   */
  public ACGroupBox getMainGroup(){
    if(mainGroup==null){

      mainGroup = new ACGroupBox();

      mainGroup.setText("�Z�������×{���i���V�l�ی��{�݁j");

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
   * �{�݋敪�E�R���e�i���擾���܂��B
   * @return �{�݋敪�E�R���e�i
   */
  public ACLabelContainer getFacilitiesDivisionContainer(){
    if(facilitiesDivisionContainer==null){

      facilitiesDivisionContainer = new ACLabelContainer();

      facilitiesDivisionContainer.setText("�{�ݓ��̋敪");

      facilitiesDivisionContainer.setFollowChildEnabled(true);

      facilitiesDivisionContainer.setHgap(0);

      facilitiesDivisionContainer.setLabelMargin(0);

      facilitiesDivisionContainer.setVgap(0);

      addFacilitiesDivisionContainer();
    }
    return facilitiesDivisionContainer;

  }

  /**
   * �{�݋敪�E�{�݁E�R���e�i���擾���܂��B
   * @return �{�݋敪�E�{�݁E�R���e�i
   */
  public ACBackLabelContainer getFacilitiesContainer(){
    if(facilitiesContainer==null){

      facilitiesContainer = new ACBackLabelContainer();

      facilitiesContainer.setFollowChildEnabled(true);

      facilitiesContainer.setHgap(0);

      facilitiesContainer.setLabelMargin(0);

      facilitiesContainer.setVgap(0);

      addFacilitiesContainer();
    }
    return facilitiesContainer;

  }

  /**
   * �{�݋敪���W�I�O���[�v���擾���܂��B
   * @return �{�݋敪���W�I�O���[�v
   */
  public ACClearableRadioButtonGroup getFacilitiesDivision(){
    if(facilitiesDivision==null){

      facilitiesDivision = new ACClearableRadioButtonGroup();

      facilitiesDivision.setBindPath("1220101");

      facilitiesDivision.setUseClearButton(false);

      facilitiesDivision.setModel(getFacilitiesDivisionModel());

      addFacilitiesDivision();
    }
    return facilitiesDivision;

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
   * ���V�l�ی��{�݂��擾���܂��B
   * @return ���V�l�ی��{��
   */
  public ACRadioButtonItem getFacilitiesDivisionItem1(){
    if(facilitiesDivisionItem1==null){

      facilitiesDivisionItem1 = new ACRadioButtonItem();

      facilitiesDivisionItem1.setText("���V�l�ی��{��");

      facilitiesDivisionItem1.setGroup(getFacilitiesDivision());

      addFacilitiesDivisionItem1();
    }
    return facilitiesDivisionItem1;

  }

  /**
   * ���j�b�g�^���V�l�ی��{�݂��擾���܂��B
   * @return ���j�b�g�^���V�l�ی��{��
   */
  public ACRadioButtonItem getFacilitiesDivisionItem2(){
    if(facilitiesDivisionItem2==null){

      facilitiesDivisionItem2 = new ACRadioButtonItem();

      facilitiesDivisionItem2.setText("���j�b�g�^���V�l�ی��{��");

      facilitiesDivisionItem2.setGroup(getFacilitiesDivision());

      addFacilitiesDivisionItem2();
    }
    return facilitiesDivisionItem2;

  }

  /**
   * �{�݋敪�E�^�E�R���e�i���擾���܂��B
   * @return �{�݋敪�E�^�E�R���e�i
   */
  public ACBackLabelContainer getTypeContainer(){
    if(typeContainer==null){

      typeContainer = new ACBackLabelContainer();

      typeContainer.setFollowChildEnabled(true);

      typeContainer.setHgap(0);

      typeContainer.setLabelMargin(0);

      typeContainer.setVgap(0);

      addTypeContainer();
    }
    return typeContainer;

  }

  /**
   * �{�ݓ��̋敪�i�̐��j���W�I�O���[�v���擾���܂��B
   * @return �{�ݓ��̋敪�i�̐��j���W�I�O���[�v
   */
  public ACClearableRadioButtonGroup getStaffAssignmentDivision(){
    if(staffAssignmentDivision==null){

      staffAssignmentDivision = new ACClearableRadioButtonGroup();

      staffAssignmentDivision.setBindPath("1220120");

      staffAssignmentDivision.setUseClearButton(false);

      staffAssignmentDivision.setModel(getStaffAssignmentDivisionModel());

      addStaffAssignmentDivision();
    }
    return staffAssignmentDivision;

  }

  /**
   * �{�ݓ��̋敪�i�̐��j���W�I�O���[�v���f�����擾���܂��B
   * @return �{�ݓ��̋敪�i�̐��j���W�I�O���[�v���f��
   */
  protected ACListModelAdapter getStaffAssignmentDivisionModel(){
    if(staffAssignmentDivisionModel==null){
      staffAssignmentDivisionModel = new ACListModelAdapter();
      addStaffAssignmentDivisionModel();
    }
    return staffAssignmentDivisionModel;
  }

  /**
   * �T�^���擾���܂��B
   * @return �T�^
   */
  public ACRadioButtonItem getStaffAssignmentDivisionItem1(){
    if(staffAssignmentDivisionItem1==null){

      staffAssignmentDivisionItem1 = new ACRadioButtonItem();

      staffAssignmentDivisionItem1.setText("I �^");

      staffAssignmentDivisionItem1.setGroup(getStaffAssignmentDivision());

      addStaffAssignmentDivisionItem1();
    }
    return staffAssignmentDivisionItem1;

  }

  /**
   * II�^���擾���܂��B
   * @return II�^
   */
  public ACRadioButtonItem getStaffAssignmentDivisionItem2(){
    if(staffAssignmentDivisionItem2==null){

      staffAssignmentDivisionItem2 = new ACRadioButtonItem();

      staffAssignmentDivisionItem2.setText("II �^");

      staffAssignmentDivisionItem2.setGroup(getStaffAssignmentDivision());

      addStaffAssignmentDivisionItem2();
    }
    return staffAssignmentDivisionItem2;

  }

  /**
   * III�^���擾���܂��B
   * @return III�^
   */
  public ACRadioButtonItem getStaffAssignmentDivisionItem3(){
    if(staffAssignmentDivisionItem3==null){

      staffAssignmentDivisionItem3 = new ACRadioButtonItem();

      staffAssignmentDivisionItem3.setText("III �^");

      staffAssignmentDivisionItem3.setGroup(getStaffAssignmentDivision());

      addStaffAssignmentDivisionItem3();
    }
    return staffAssignmentDivisionItem3;

  }

  /**
   * ��ԋΖ���������W�I�O���[�v���擾���܂��B
   * @return ��ԋΖ���������W�I�O���[�v
   */
  public ACClearableRadioButtonGroup getNightWorkDivision(){
    if(nightWorkDivision==null){

      nightWorkDivision = new ACClearableRadioButtonGroup();

      getNightWorkDivisionContainer().setText("��ԋΖ������");

      nightWorkDivision.setBindPath("1220102");

      nightWorkDivision.setUseClearButton(false);

      nightWorkDivision.setModel(getNightWorkDivisionModel());

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

      addNightWorkDivisionItem1();
    }
    return nightWorkDivisionItem1;

  }

  /**
   * ���Z�^���擾���܂��B
   * @return ���Z�^
   */
  public ACRadioButtonItem getNightWorkDivisionItem2(){
    if(nightWorkDivisionItem2==null){

      nightWorkDivisionItem2 = new ACRadioButtonItem();

      nightWorkDivisionItem2.setText("���Z�^");

      nightWorkDivisionItem2.setGroup(getNightWorkDivision());

      addNightWorkDivisionItem2();
    }
    return nightWorkDivisionItem2;

  }

  /**
   * �E���̌����ɂ�錸�Z�̏󋵂��擾���܂��B
   * @return �E���̌����ɂ�錸�Z�̏�
   */
  public ACClearableRadioButtonGroup getStaffLack(){
    if(staffLack==null){

      staffLack = new ACClearableRadioButtonGroup();

      getStaffLackContainer().setText("�E���̌����ɂ�錸�Z�̏�");

      staffLack.setBindPath("1220126");

      staffLack.setUseClearButton(false);

      staffLack.setModel(getStaffLackModel());

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

      staffLackItem4.setConstraints(VRLayout.FLOW_RETURN);

      addStaffLackItem4();
    }
    return staffLackItem4;

  }

  /**
   * ���w�Ö@�m���擾���܂��B
   * @return ���w�Ö@�m
   */
  public ACRadioButtonItem getStaffLackItem5(){
    if(staffLackItem5==null){

      staffLackItem5 = new ACRadioButtonItem();

      staffLackItem5.setText("���w�Ö@�m");

      staffLackItem5.setGroup(getStaffLack());

      staffLackItem5.setConstraints(VRLayout.FLOW);

      addStaffLackItem5();
    }
    return staffLackItem5;

  }

  /**
   * ��ƗÖ@�m���擾���܂��B
   * @return ��ƗÖ@�m
   */
  public ACRadioButtonItem getStaffLackItem6(){
    if(staffLackItem6==null){

      staffLackItem6 = new ACRadioButtonItem();

      staffLackItem6.setText("��ƗÖ@�m");

      staffLackItem6.setGroup(getStaffLack());

      staffLackItem6.setConstraints(VRLayout.FLOW);

      addStaffLackItem6();
    }
    return staffLackItem6;

  }

  /**
   * ���꒮�o�m���擾���܂��B
   * @return ���꒮�o�m
   */
  public ACRadioButtonItem getStaffLackItem7(){
    if(staffLackItem7==null){

      staffLackItem7 = new ACRadioButtonItem();

      staffLackItem7.setText("���꒮�o�m");

      staffLackItem7.setGroup(getStaffLack());

      staffLackItem7.setConstraints(VRLayout.FLOW);

      addStaffLackItem7();
    }
    return staffLackItem7;

  }

  /**
   * ���j�b�g�P�A�̐����擾���܂��B
   * @return ���j�b�g�P�A�̐�
   */
  public ACClearableRadioButtonGroup getUnitCareMaintenance(){
    if(unitCareMaintenance==null){

      unitCareMaintenance = new ACClearableRadioButtonGroup();

      getUnitCareMaintenanceContainer().setText("���j�b�g�P�A�̐�");

      unitCareMaintenance.setBindPath("1220117");

      unitCareMaintenance.setUseClearButton(false);

      unitCareMaintenance.setModel(getUnitCareMaintenanceModel());

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
   * ��ΐE���z�u���Z���擾���܂��B
   * @return ��ΐE���z�u���Z
   */
  public ACValueArrayRadioButtonGroup getNightStaffDispositionAddRadioGroup(){
    if(nightStaffDispositionAddRadioGroup==null){

      nightStaffDispositionAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getNightStaffDispositionAddRadioGroupContainer().setText("��ΐE���z�u���Z");

      nightStaffDispositionAddRadioGroup.setBindPath("1220122");

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
   * ���n�r���e�[�V�����@�\�������W�I�O���[�v���擾���܂��B
   * @return ���n�r���e�[�V�����@�\�������W�I�O���[�v
   */
  public ACClearableRadioButtonGroup getRehabilitationReinforcement(){
    if(rehabilitationReinforcement==null){

      rehabilitationReinforcement = new ACClearableRadioButtonGroup();

      getRehabilitationReinforcementContainer().setText("���n�r���@�\����");

      rehabilitationReinforcement.setBindPath("1220103");

      rehabilitationReinforcement.setUseClearButton(false);

      rehabilitationReinforcement.setModel(getRehabilitationReinforcementModel());

      addRehabilitationReinforcement();
    }
    return rehabilitationReinforcement;

  }

  /**
   * ���n�r���e�[�V�����@�\�������W�I�O���[�v�R���e�i���擾���܂��B
   * @return ���n�r���e�[�V�����@�\�������W�I�O���[�v�R���e�i
   */
  protected ACLabelContainer getRehabilitationReinforcementContainer(){
    if(rehabilitationReinforcementContainer==null){
      rehabilitationReinforcementContainer = new ACLabelContainer();
      rehabilitationReinforcementContainer.setFollowChildEnabled(true);
      rehabilitationReinforcementContainer.setVAlignment(VRLayout.CENTER);
      rehabilitationReinforcementContainer.add(getRehabilitationReinforcement(), null);
    }
    return rehabilitationReinforcementContainer;
  }

  /**
   * ���n�r���e�[�V�����@�\�������W�I�O���[�v���f�����擾���܂��B
   * @return ���n�r���e�[�V�����@�\�������W�I�O���[�v���f��
   */
  protected ACListModelAdapter getRehabilitationReinforcementModel(){
    if(rehabilitationReinforcementModel==null){
      rehabilitationReinforcementModel = new ACListModelAdapter();
      addRehabilitationReinforcementModel();
    }
    return rehabilitationReinforcementModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getRehabilitationReinforcementItem1(){
    if(rehabilitationReinforcementItem1==null){

      rehabilitationReinforcementItem1 = new ACRadioButtonItem();

      rehabilitationReinforcementItem1.setText("�Ȃ�");

      rehabilitationReinforcementItem1.setGroup(getRehabilitationReinforcement());

      addRehabilitationReinforcementItem1();
    }
    return rehabilitationReinforcementItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getRehabilitationReinforcementItem2(){
    if(rehabilitationReinforcementItem2==null){

      rehabilitationReinforcementItem2 = new ACRadioButtonItem();

      rehabilitationReinforcementItem2.setText("����");

      rehabilitationReinforcementItem2.setGroup(getRehabilitationReinforcement());

      addRehabilitationReinforcementItem2();
    }
    return rehabilitationReinforcementItem2;

  }

  /**
   * �×{�H���Z���擾���܂��B
   * @return �×{�H���Z
   */
  public ACValueArrayRadioButtonGroup getMedicalFoodAddRadioGroup(){
    if(medicalFoodAddRadioGroup==null){

      medicalFoodAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getMedicalFoodAddRadioGroupContainer().setText("�×{�H���Z");

      medicalFoodAddRadioGroup.setBindPath("1220123");

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
   * ���}�̐����W�I�O���[�v���擾���܂��B
   * @return ���}�̐����W�I�O���[�v
   */
  public ACClearableRadioButtonGroup getMeetingAndSendingOffSystem(){
    if(meetingAndSendingOffSystem==null){

      meetingAndSendingOffSystem = new ACClearableRadioButtonGroup();

      getMeetingAndSendingOffSystemContainer().setText("���}�̐�");

      meetingAndSendingOffSystem.setBindPath("1220105");

      meetingAndSendingOffSystem.setUseClearButton(false);

      meetingAndSendingOffSystem.setModel(getMeetingAndSendingOffSystemModel());

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
   * �F�m�ǃP�A���Z���擾���܂��B
   * @return �F�m�ǃP�A���Z
   */
  public ACClearableRadioButtonGroup getDementiaCare(){
    if(dementiaCare==null){

      dementiaCare = new ACClearableRadioButtonGroup();

      getDementiaCareContainer().setText("�F�m�ǃP�A���Z");

      dementiaCare.setBindPath("1220119");

      dementiaCare.setUseClearButton(false);

      dementiaCare.setModel(getDementiaCareModel());

      addDementiaCare();
    }
    return dementiaCare;

  }

  /**
   * �F�m�ǃP�A���Z�R���e�i���擾���܂��B
   * @return �F�m�ǃP�A���Z�R���e�i
   */
  protected ACLabelContainer getDementiaCareContainer(){
    if(dementiaCareContainer==null){
      dementiaCareContainer = new ACLabelContainer();
      dementiaCareContainer.setFollowChildEnabled(true);
      dementiaCareContainer.setVAlignment(VRLayout.CENTER);
      dementiaCareContainer.add(getDementiaCare(), null);
    }
    return dementiaCareContainer;
  }

  /**
   * �F�m�ǃP�A���Z���f�����擾���܂��B
   * @return �F�m�ǃP�A���Z���f��
   */
  protected ACListModelAdapter getDementiaCareModel(){
    if(dementiaCareModel==null){
      dementiaCareModel = new ACListModelAdapter();
      addDementiaCareModel();
    }
    return dementiaCareModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getDementiaCareItem1(){
    if(dementiaCareItem1==null){

      dementiaCareItem1 = new ACRadioButtonItem();

      dementiaCareItem1.setText("�Ȃ�");

      dementiaCareItem1.setGroup(getDementiaCare());

      dementiaCareItem1.setConstraints(VRLayout.FLOW);

      addDementiaCareItem1();
    }
    return dementiaCareItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getDementiaCareItem2(){
    if(dementiaCareItem2==null){

      dementiaCareItem2 = new ACRadioButtonItem();

      dementiaCareItem2.setText("����");

      dementiaCareItem2.setGroup(getDementiaCare());

      dementiaCareItem2.setConstraints(VRLayout.FLOW);

      addDementiaCareItem2();
    }
    return dementiaCareItem2;

  }

  /**
   * ��N���F�m�Ǘ��p�Ҏ�����Z���擾���܂��B
   * @return ��N���F�m�Ǘ��p�Ҏ�����Z
   */
  public ACValueArrayRadioButtonGroup getYoungDementiaPatinetAddRadioGroup(){
    if(youngDementiaPatinetAddRadioGroup==null){

      youngDementiaPatinetAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getYoungDementiaPatinetAddRadioGroupContainer().setText("��N���F�m�Ǘ��p�Ҏ�����Z");

      youngDementiaPatinetAddRadioGroup.setBindPath("1220124");

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
   * �ً}����̐����擾���܂��B
   * @return �ً}����̐�
   */
  public ACClearableRadioButtonGroup getEmergencyNetworkAdd(){
    if(emergencyNetworkAdd==null){

      emergencyNetworkAdd = new ACClearableRadioButtonGroup();

      getEmergencyNetworkAddContainer().setText("�ً}����̐�");

      emergencyNetworkAdd.setBindPath("1220118");

      emergencyNetworkAdd.setUseClearButton(false);

      emergencyNetworkAdd.setModel(getEmergencyNetworkAddModel());

      addEmergencyNetworkAdd();
    }
    return emergencyNetworkAdd;

  }

  /**
   * �ً}����̐��R���e�i���擾���܂��B
   * @return �ً}����̐��R���e�i
   */
  protected ACLabelContainer getEmergencyNetworkAddContainer(){
    if(emergencyNetworkAddContainer==null){
      emergencyNetworkAddContainer = new ACLabelContainer();
      emergencyNetworkAddContainer.setFollowChildEnabled(true);
      emergencyNetworkAddContainer.setVAlignment(VRLayout.CENTER);
      emergencyNetworkAddContainer.add(getEmergencyNetworkAdd(), null);
    }
    return emergencyNetworkAddContainer;
  }

  /**
   * �ً}����̐����f�����擾���܂��B
   * @return �ً}����̐����f��
   */
  protected ACListModelAdapter getEmergencyNetworkAddModel(){
    if(emergencyNetworkAddModel==null){
      emergencyNetworkAddModel = new ACListModelAdapter();
      addEmergencyNetworkAddModel();
    }
    return emergencyNetworkAddModel;
  }

  /**
   * �Ή��s���擾���܂��B
   * @return �Ή��s��
   */
  public ACRadioButtonItem getEmergencyNetworkAddItem1(){
    if(emergencyNetworkAddItem1==null){

      emergencyNetworkAddItem1 = new ACRadioButtonItem();

      emergencyNetworkAddItem1.setText("�Ή��s��");

      emergencyNetworkAddItem1.setGroup(getEmergencyNetworkAdd());

      emergencyNetworkAddItem1.setConstraints(VRLayout.FLOW);

      addEmergencyNetworkAddItem1();
    }
    return emergencyNetworkAddItem1;

  }

  /**
   * �Ή����擾���܂��B
   * @return �Ή���
   */
  public ACRadioButtonItem getEmergencyNetworkAddItem2(){
    if(emergencyNetworkAddItem2==null){

      emergencyNetworkAddItem2 = new ACRadioButtonItem();

      emergencyNetworkAddItem2.setText("�Ή���");

      emergencyNetworkAddItem2.setGroup(getEmergencyNetworkAdd());

      emergencyNetworkAddItem2.setConstraints(VRLayout.FLOW);

      addEmergencyNetworkAddItem2();
    }
    return emergencyNetworkAddItem2;

  }

  /**
   * ���ʗ×{��ڃR���e�i���擾���܂��B
   * @return ���ʗ×{��ڃR���e�i
   */
  public ACLabelContainer getSpecialMedicalDetailsContainer(){
    if(specialMedicalDetailsContainer==null){

      specialMedicalDetailsContainer = new ACLabelContainer();

      specialMedicalDetailsContainer.setText("���ʗ×{����Z����");

      specialMedicalDetailsContainer.setFollowChildEnabled(true);

      addSpecialMedicalDetailsContainer();
    }
    return specialMedicalDetailsContainer;

  }

  /**
   * �d�ǔ畆��ᇎw���Ǘ��`�F�b�N���擾���܂��B
   * @return �d�ǔ畆��ᇎw���Ǘ��`�F�b�N
   */
  public ACIntegerCheckBox getSpecialMedicalDetailsItem1(){
    if(specialMedicalDetailsItem1==null){

      specialMedicalDetailsItem1 = new ACIntegerCheckBox();

      specialMedicalDetailsItem1.setText("�d�ǔ畆��ᇎw���Ǘ�");

      specialMedicalDetailsItem1.setBindPath("3010109");

      specialMedicalDetailsItem1.setSelectValue(2);

      specialMedicalDetailsItem1.setUnSelectValue(1);

      addSpecialMedicalDetailsItem1();
    }
    return specialMedicalDetailsItem1;

  }

  /**
   * ��܊Ǘ��w���`�F�b�N���擾���܂��B
   * @return ��܊Ǘ��w���`�F�b�N
   */
  public ACIntegerCheckBox getSpecialMedicalDetailsItem2(){
    if(specialMedicalDetailsItem2==null){

      specialMedicalDetailsItem2 = new ACIntegerCheckBox();

      specialMedicalDetailsItem2.setText("��܊Ǘ��w��");

      specialMedicalDetailsItem2.setBindPath("3010110");

      specialMedicalDetailsItem2.setSelectValue(2);

      specialMedicalDetailsItem2.setUnSelectValue(1);

      addSpecialMedicalDetailsItem2();
    }
    return specialMedicalDetailsItem2;

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
   * ���꒮�o�Ö@�`�F�b�N���擾���܂��B
   * @return ���꒮�o�Ö@�`�F�b�N
   */
  public ACIntegerCheckBox getRehabilitationDetailsItem1(){
    if(rehabilitationDetailsItem1==null){

      rehabilitationDetailsItem1 = new ACIntegerCheckBox();

      rehabilitationDetailsItem1.setText("���꒮�o�Ö@");

      rehabilitationDetailsItem1.setBindPath("3010106");

      rehabilitationDetailsItem1.setSelectValue(2);

      rehabilitationDetailsItem1.setUnSelectValue(1);

      addRehabilitationDetailsItem1();
    }
    return rehabilitationDetailsItem1;

  }

  /**
   * ���_�ȍ�ƗÖ@�`�F�b�N���擾���܂��B
   * @return ���_�ȍ�ƗÖ@�`�F�b�N
   */
  public ACIntegerCheckBox getRehabilitationDetailsItem2(){
    if(rehabilitationDetailsItem2==null){

      rehabilitationDetailsItem2 = new ACIntegerCheckBox();

      rehabilitationDetailsItem2.setText("���_�ȍ�ƗÖ@");

      rehabilitationDetailsItem2.setBindPath("3010107");

      rehabilitationDetailsItem2.setSelectValue(2);

      rehabilitationDetailsItem2.setUnSelectValue(1);

      addRehabilitationDetailsItem2();
    }
    return rehabilitationDetailsItem2;

  }

  /**
   * ���̑��`�F�b�N���擾���܂��B
   * @return ���̑��`�F�b�N
   */
  public ACIntegerCheckBox getRehabilitationDetailsItem3(){
    if(rehabilitationDetailsItem3==null){

      rehabilitationDetailsItem3 = new ACIntegerCheckBox();

      rehabilitationDetailsItem3.setText("���̑�");

      rehabilitationDetailsItem3.setBindPath("3010108");

      rehabilitationDetailsItem3.setSelectValue(2);

      rehabilitationDetailsItem3.setUnSelectValue(1);

      addRehabilitationDetailsItem3();
    }
    return rehabilitationDetailsItem3;

  }

  /**
   * �×{�̐��ێ����ʉ��Z���W�I�O���[�v���擾���܂��B
   * @return �×{�̐��ێ����ʉ��Z���W�I�O���[�v
   */
  public ACClearableRadioButtonGroup getMedicalSystemUpkeep(){
    if(MedicalSystemUpkeep==null){

      MedicalSystemUpkeep = new ACClearableRadioButtonGroup();

      getMedicalSystemUpkeepContainer().setText("�×{�̐��ێ����ʉ��Z");

      MedicalSystemUpkeep.setBindPath("1220121");

      MedicalSystemUpkeep.setUseClearButton(false);

      MedicalSystemUpkeep.setModel(getMedicalSystemUpkeepModel());

      addMedicalSystemUpkeep();
    }
    return MedicalSystemUpkeep;

  }

  /**
   * �×{�̐��ێ����ʉ��Z���W�I�O���[�v�R���e�i���擾���܂��B
   * @return �×{�̐��ێ����ʉ��Z���W�I�O���[�v�R���e�i
   */
  protected ACLabelContainer getMedicalSystemUpkeepContainer(){
    if(MedicalSystemUpkeepContainer==null){
      MedicalSystemUpkeepContainer = new ACLabelContainer();
      MedicalSystemUpkeepContainer.setFollowChildEnabled(true);
      MedicalSystemUpkeepContainer.setVAlignment(VRLayout.CENTER);
      MedicalSystemUpkeepContainer.add(getMedicalSystemUpkeep(), null);
    }
    return MedicalSystemUpkeepContainer;
  }

  /**
   * �×{�̐��ێ����ʉ��Z���W�I�O���[�v���f�����擾���܂��B
   * @return �×{�̐��ێ����ʉ��Z���W�I�O���[�v���f��
   */
  protected ACListModelAdapter getMedicalSystemUpkeepModel(){
    if(MedicalSystemUpkeepModel==null){
      MedicalSystemUpkeepModel = new ACListModelAdapter();
      addMedicalSystemUpkeepModel();
    }
    return MedicalSystemUpkeepModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getMedicalSystemUpkeeItem1(){
    if(MedicalSystemUpkeeItem1==null){

      MedicalSystemUpkeeItem1 = new ACRadioButtonItem();

      MedicalSystemUpkeeItem1.setText("�Ȃ�");

      MedicalSystemUpkeeItem1.setGroup(getMedicalSystemUpkeep());

      MedicalSystemUpkeeItem1.setConstraints(VRLayout.FLOW);

      addMedicalSystemUpkeeItem1();
    }
    return MedicalSystemUpkeeItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getMedicalSystemUpkeeItem2(){
    if(MedicalSystemUpkeeItem2==null){

      MedicalSystemUpkeeItem2 = new ACRadioButtonItem();

      MedicalSystemUpkeeItem2.setText("����");

      MedicalSystemUpkeeItem2.setGroup(getMedicalSystemUpkeep());

      MedicalSystemUpkeeItem2.setConstraints(VRLayout.FLOW);

      addMedicalSystemUpkeeItem2();
    }
    return MedicalSystemUpkeeItem2;

  }

  /**
   * �T�[�r�X�񋟑̐��������Z���擾���܂��B
   * @return �T�[�r�X�񋟑̐��������Z
   */
  public ACValueArrayRadioButtonGroup getServiceAddProvisionStructuralRadioGroup(){
    if(serviceAddProvisionStructuralRadioGroup==null){

      serviceAddProvisionStructuralRadioGroup = new ACValueArrayRadioButtonGroup();

      getServiceAddProvisionStructuralRadioGroupContainer().setText("�T�[�r�X�񋟑̐��������Z");

      serviceAddProvisionStructuralRadioGroup.setBindPath("1220125");

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
   * ���ZI���擾���܂��B
   * @return ���ZI
   */
  public ACRadioButtonItem getServiceAddProvisionStructuralRadioItem2(){
    if(serviceAddProvisionStructuralRadioItem2==null){

      serviceAddProvisionStructuralRadioItem2 = new ACRadioButtonItem();

      serviceAddProvisionStructuralRadioItem2.setText("���ZI");

      serviceAddProvisionStructuralRadioItem2.setGroup(getServiceAddProvisionStructuralRadioGroup());

      serviceAddProvisionStructuralRadioItem2.setConstraints(VRLayout.FLOW);

      addServiceAddProvisionStructuralRadioItem2();
    }
    return serviceAddProvisionStructuralRadioItem2;

  }

  /**
   * ���ZII���擾���܂��B
   * @return ���ZII
   */
  public ACRadioButtonItem getServiceAddProvisionStructuralRadioItem3(){
    if(serviceAddProvisionStructuralRadioItem3==null){

      serviceAddProvisionStructuralRadioItem3 = new ACRadioButtonItem();

      serviceAddProvisionStructuralRadioItem3.setText("���ZII");

      serviceAddProvisionStructuralRadioItem3.setGroup(getServiceAddProvisionStructuralRadioGroup());

      serviceAddProvisionStructuralRadioItem3.setConstraints(VRLayout.FLOW);

      addServiceAddProvisionStructuralRadioItem3();
    }
    return serviceAddProvisionStructuralRadioItem3;

  }

  /**
   * ���ZIII���擾���܂��B
   * @return ���ZIII
   */
  public ACRadioButtonItem getServiceAddProvisionStructuralRadioItem4(){
    if(serviceAddProvisionStructuralRadioItem4==null){

      serviceAddProvisionStructuralRadioItem4 = new ACRadioButtonItem();

      serviceAddProvisionStructuralRadioItem4.setText("���ZIII");

      serviceAddProvisionStructuralRadioItem4.setGroup(getServiceAddProvisionStructuralRadioGroup());

      serviceAddProvisionStructuralRadioItem4.setConstraints(VRLayout.FLOW);

      addServiceAddProvisionStructuralRadioItem4();
    }
    return serviceAddProvisionStructuralRadioItem4;

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
   * ���@���ڂ��擾���܂��B
   * @return ���@����
   */
  public ACPanel getOldLowElementArea(){
    if(oldLowElementArea==null){

      oldLowElementArea = new ACPanel();

      oldLowElementArea.setFollowChildEnabled(true);

      addOldLowElementArea();
    }
    return oldLowElementArea;

  }

  /**
   * ����21�N3���ȑO�O���[�v���擾���܂��B
   * @return ����21�N3���ȑO�O���[�v
   */
  public ACGroupBox getOldLowH2103Group(){
    if(oldLowH2103Group==null){

      oldLowH2103Group = new ACGroupBox();

      oldLowH2103Group.setText("����21�N3���ȑO");

      oldLowH2103Group.setFollowChildEnabled(true);

      oldLowH2103Group.setHgap(0);

      oldLowH2103Group.setLabelMargin(0);

      oldLowH2103Group.setVgap(0);

      addOldLowH2103Group();
    }
    return oldLowH2103Group;

  }

  /**
   * �E���̌����ɂ�錸�Z�̏󋵂��擾���܂��B
   * @return �E���̌����ɂ�錸�Z�̏�
   */
  public ACClearableRadioButtonGroup getStaffLack_H2103(){
    if(staffLack_H2103==null){

      staffLack_H2103 = new ACClearableRadioButtonGroup();

      getStaffLack_H2103Container().setText("�E���̌����ɂ�錸�Z�̏�");

      staffLack_H2103.setBindPath("1220108");

      staffLack_H2103.setUseClearButton(false);

      staffLack_H2103.setModel(getStaffLack_H2103Model());

      addStaffLack_H2103();
    }
    return staffLack_H2103;

  }

  /**
   * �E���̌����ɂ�錸�Z�̏󋵃R���e�i���擾���܂��B
   * @return �E���̌����ɂ�錸�Z�̏󋵃R���e�i
   */
  protected ACLabelContainer getStaffLack_H2103Container(){
    if(staffLack_H2103Container==null){
      staffLack_H2103Container = new ACLabelContainer();
      staffLack_H2103Container.setFollowChildEnabled(true);
      staffLack_H2103Container.setVAlignment(VRLayout.CENTER);
      staffLack_H2103Container.add(getStaffLack_H2103(), null);
    }
    return staffLack_H2103Container;
  }

  /**
   * �E���̌����ɂ�錸�Z�̏󋵃��f�����擾���܂��B
   * @return �E���̌����ɂ�錸�Z�̏󋵃��f��
   */
  protected ACListModelAdapter getStaffLack_H2103Model(){
    if(staffLack_H2103Model==null){
      staffLack_H2103Model = new ACListModelAdapter();
      addStaffLack_H2103Model();
    }
    return staffLack_H2103Model;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getStaffLackItem1_H2103(){
    if(staffLackItem1_H2103==null){

      staffLackItem1_H2103 = new ACRadioButtonItem();

      staffLackItem1_H2103.setText("�Ȃ�");

      staffLackItem1_H2103.setGroup(getStaffLack_H2103());

      staffLackItem1_H2103.setConstraints(VRLayout.FLOW);

      addStaffLackItem1_H2103();
    }
    return staffLackItem1_H2103;

  }

  /**
   * ��t���擾���܂��B
   * @return ��t
   */
  public ACRadioButtonItem getStaffLackItem2_H2103(){
    if(staffLackItem2_H2103==null){

      staffLackItem2_H2103 = new ACRadioButtonItem();

      staffLackItem2_H2103.setText("��t");

      staffLackItem2_H2103.setGroup(getStaffLack_H2103());

      staffLackItem2_H2103.setConstraints(VRLayout.FLOW);

      addStaffLackItem2_H2103();
    }
    return staffLackItem2_H2103;

  }

  /**
   * �Ō�E�����擾���܂��B
   * @return �Ō�E��
   */
  public ACRadioButtonItem getStaffLackItem3_H2103(){
    if(staffLackItem3_H2103==null){

      staffLackItem3_H2103 = new ACRadioButtonItem();

      staffLackItem3_H2103.setText("�Ō�E��");

      staffLackItem3_H2103.setGroup(getStaffLack_H2103());

      staffLackItem3_H2103.setConstraints(VRLayout.FLOW);

      addStaffLackItem3_H2103();
    }
    return staffLackItem3_H2103;

  }

  /**
   * ���E�����擾���܂��B
   * @return ���E��
   */
  public ACRadioButtonItem getStaffLackItem4_H2103(){
    if(staffLackItem4_H2103==null){

      staffLackItem4_H2103 = new ACRadioButtonItem();

      staffLackItem4_H2103.setText("���E��");

      staffLackItem4_H2103.setGroup(getStaffLack_H2103());

      staffLackItem4_H2103.setConstraints(VRLayout.FLOW_RETURN);

      addStaffLackItem4_H2103();
    }
    return staffLackItem4_H2103;

  }

  /**
   * ���w�Ö@�m���擾���܂��B
   * @return ���w�Ö@�m
   */
  public ACRadioButtonItem getStaffLackItem5_H2103(){
    if(staffLackItem5_H2103==null){

      staffLackItem5_H2103 = new ACRadioButtonItem();

      staffLackItem5_H2103.setText("���w�Ö@�m");

      staffLackItem5_H2103.setGroup(getStaffLack_H2103());

      staffLackItem5_H2103.setConstraints(VRLayout.FLOW);

      addStaffLackItem5_H2103();
    }
    return staffLackItem5_H2103;

  }

  /**
   * ��ƗÖ@�m���擾���܂��B
   * @return ��ƗÖ@�m
   */
  public ACRadioButtonItem getStaffLackItem6_H2103(){
    if(staffLackItem6_H2103==null){

      staffLackItem6_H2103 = new ACRadioButtonItem();

      staffLackItem6_H2103.setText("��ƗÖ@�m");

      staffLackItem6_H2103.setGroup(getStaffLack_H2103());

      staffLackItem6_H2103.setConstraints(VRLayout.FLOW);

      addStaffLackItem6_H2103();
    }
    return staffLackItem6_H2103;

  }

  /**
   * �h�{�Ǘ��̕]�����擾���܂��B
   * @return �h�{�Ǘ��̕]��
   */
  public ACClearableRadioButtonGroup getNourishmentControlAdd(){
    if(nourishmentControlAdd==null){

      nourishmentControlAdd = new ACClearableRadioButtonGroup();

      getNourishmentControlAddContainer().setText("�h�{�Ǘ��̕]��");

      nourishmentControlAdd.setBindPath("1220106");

      nourishmentControlAdd.setUseClearButton(false);

      nourishmentControlAdd.setModel(getNourishmentControlAddModel());

      addNourishmentControlAdd();
    }
    return nourishmentControlAdd;

  }

  /**
   * �h�{�Ǘ��̕]���R���e�i���擾���܂��B
   * @return �h�{�Ǘ��̕]���R���e�i
   */
  protected ACLabelContainer getNourishmentControlAddContainer(){
    if(nourishmentControlAddContainer==null){
      nourishmentControlAddContainer = new ACLabelContainer();
      nourishmentControlAddContainer.setFollowChildEnabled(true);
      nourishmentControlAddContainer.setVAlignment(VRLayout.CENTER);
      nourishmentControlAddContainer.add(getNourishmentControlAdd(), null);
    }
    return nourishmentControlAddContainer;
  }

  /**
   * �h�{�Ǘ��̕]�����f�����擾���܂��B
   * @return �h�{�Ǘ��̕]�����f��
   */
  protected ACListModelAdapter getNourishmentControlAddModel(){
    if(nourishmentControlAddModel==null){
      nourishmentControlAddModel = new ACListModelAdapter();
      addNourishmentControlAddModel();
    }
    return nourishmentControlAddModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getNourishmentControlAddItem1(){
    if(nourishmentControlAddItem1==null){

      nourishmentControlAddItem1 = new ACRadioButtonItem();

      nourishmentControlAddItem1.setText("�Ȃ�");

      nourishmentControlAddItem1.setGroup(getNourishmentControlAdd());

      addNourishmentControlAddItem1();
    }
    return nourishmentControlAddItem1;

  }

  /**
   * �h�{�m���擾���܂��B
   * @return �h�{�m
   */
  public ACRadioButtonItem getNourishmentControlAddItem2(){
    if(nourishmentControlAddItem2==null){

      nourishmentControlAddItem2 = new ACRadioButtonItem();

      nourishmentControlAddItem2.setText("�h�{�m");

      nourishmentControlAddItem2.setGroup(getNourishmentControlAdd());

      addNourishmentControlAddItem2();
    }
    return nourishmentControlAddItem2;

  }

  /**
   * �Ǘ��h�{�m���擾���܂��B
   * @return �Ǘ��h�{�m
   */
  public ACRadioButtonItem getNourishmentControlAddItem3(){
    if(nourishmentControlAddItem3==null){

      nourishmentControlAddItem3 = new ACRadioButtonItem();

      nourishmentControlAddItem3.setText("�Ǘ��h�{�m");

      nourishmentControlAddItem3.setGroup(getNourishmentControlAdd());

      addNourishmentControlAddItem3();
    }
    return nourishmentControlAddItem3;

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

      dinnerTotal.setBindPath("1220109");

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

      dinnerMorning.setBindPath("1220110");

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

      dinnerNoon.setBindPath("1220111");

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

      dinnerNight.setBindPath("1220112");

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

      unitRoom.setBindPath("1220113");

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

      unitSemiRoom.setBindPath("1220114");

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

      normalRoom.setBindPath("1220115");

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

      tasyouRoom.setBindPath("1220116");

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
   * �Z�荀�ڗ̈�2���擾���܂��B
   * @return �Z�荀�ڗ̈�2
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
   * �������R���e�i���擾���܂��B
   * @return �������R���e�i
   */
  public ACLabelContainer getReduceRateContainer(){
    if(reduceRateContainer==null){

      reduceRateContainer = new ACLabelContainer();

      reduceRateContainer.setText("������");

      reduceRateContainer.setFollowChildEnabled(true);

      reduceRateContainer.setForeground(java.awt.Color.gray);

      addReduceRateContainer();
    }
    return reduceRateContainer;

  }

  /**
   * �e�L�X�g���擾���܂��B
   * @return �e�L�X�g
   */
  public ACTextField getReduceRate(){
    if(reduceRate==null){

      reduceRate = new ACTextField();

      reduceRate.setBindPath("REDUCT_RATE");

      reduceRate.setColumns(3);

      reduceRate.setCharType(VRCharType.ONLY_DIGIT);

      reduceRate.setHorizontalAlignment(SwingConstants.RIGHT);

      reduceRate.setIMEMode(InputSubset.LATIN);

      reduceRate.setMaxLength(3);

      addReduceRate();
    }
    return reduceRate;

  }

  /**
   * ���x�����擾���܂��B
   * @return ���x��
   */
  public ACLabel getPercentSign(){
    if(percentSign==null){

      percentSign = new ACLabel();

      percentSign.setText("��");

      percentSign.setForeground(java.awt.Color.gray);

      addPercentSign();
    }
    return percentSign;

  }

  /**
   * �R���X�g���N�^�ł��B
   */
  public QO004110Design() {

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

    calculationDetails.add(getNightWorkDivisionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails.add(getStaffLackContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails.add(getUnitCareMaintenanceContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails.add(getNightStaffDispositionAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails.add(getRehabilitationReinforcementContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails.add(getMedicalFoodAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails.add(getMeetingAndSendingOffSystemContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails.add(getDementiaCareContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails.add(getYoungDementiaPatinetAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails.add(getEmergencyNetworkAddContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails.add(getSpecialMedicalDetailsContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails.add(getRehabilitationDetailsContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails.add(getMedicalSystemUpkeepContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails.add(getServiceAddProvisionStructuralRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * �{�݋敪�E�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addFacilitiesDivisionContainer(){

    facilitiesDivisionContainer.add(getFacilitiesContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    facilitiesDivisionContainer.add(getTypeContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * �{�݋敪�E�{�݁E�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addFacilitiesContainer(){

    facilitiesContainer.add(getFacilitiesDivision(), VRLayout.FLOW_INSETLINE);

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

  }

  /**
   * ���V�l�ی��{�݂ɓ������ڂ�ǉ����܂��B
   */
  protected void addFacilitiesDivisionItem1(){

  }

  /**
   * ���j�b�g�^���V�l�ی��{�݂ɓ������ڂ�ǉ����܂��B
   */
  protected void addFacilitiesDivisionItem2(){

  }

  /**
   * �{�݋敪�E�^�E�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTypeContainer(){

    typeContainer.add(getStaffAssignmentDivision(), VRLayout.FLOW_INSETLINE);

  }

  /**
   * �{�ݓ��̋敪�i�̐��j���W�I�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffAssignmentDivision(){

  }

  /**
   * �{�ݓ��̋敪�i�̐��j���W�I�O���[�v���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffAssignmentDivisionModel(){

    getStaffAssignmentDivisionItem1().setButtonIndex(1);

    getStaffAssignmentDivisionModel().add(getStaffAssignmentDivisionItem1());

    getStaffAssignmentDivisionItem2().setButtonIndex(2);

    getStaffAssignmentDivisionModel().add(getStaffAssignmentDivisionItem2());

    getStaffAssignmentDivisionItem3().setButtonIndex(3);

    getStaffAssignmentDivisionModel().add(getStaffAssignmentDivisionItem3());

  }

  /**
   * �T�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffAssignmentDivisionItem1(){

  }

  /**
   * II�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffAssignmentDivisionItem2(){

  }

  /**
   * III�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffAssignmentDivisionItem3(){

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

  }

  /**
   * ��^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addNightWorkDivisionItem1(){

  }

  /**
   * ���Z�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addNightWorkDivisionItem2(){

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

    getStaffLackItem5().setButtonIndex(5);

    getStaffLackModel().add(getStaffLackItem5());

    getStaffLackItem6().setButtonIndex(6);

    getStaffLackModel().add(getStaffLackItem6());

    getStaffLackItem7().setButtonIndex(7);

    getStaffLackModel().add(getStaffLackItem7());

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
   * ���w�Ö@�m�ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffLackItem5(){

  }

  /**
   * ��ƗÖ@�m�ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffLackItem6(){

  }

  /**
   * ���꒮�o�m�ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffLackItem7(){

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
   * ���n�r���e�[�V�����@�\�������W�I�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addRehabilitationReinforcement(){

  }

  /**
   * ���n�r���e�[�V�����@�\�������W�I�O���[�v���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addRehabilitationReinforcementModel(){

    getRehabilitationReinforcementItem1().setButtonIndex(1);

    getRehabilitationReinforcementModel().add(getRehabilitationReinforcementItem1());

    getRehabilitationReinforcementItem2().setButtonIndex(2);

    getRehabilitationReinforcementModel().add(getRehabilitationReinforcementItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addRehabilitationReinforcementItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addRehabilitationReinforcementItem2(){

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
   * �F�m�ǃP�A���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addDementiaCare(){

  }

  /**
   * �F�m�ǃP�A���Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addDementiaCareModel(){

    getDementiaCareItem1().setButtonIndex(1);

    getDementiaCareModel().add(getDementiaCareItem1());

    getDementiaCareItem2().setButtonIndex(2);

    getDementiaCareModel().add(getDementiaCareItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addDementiaCareItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addDementiaCareItem2(){

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
   * �ً}����̐��ɓ������ڂ�ǉ����܂��B
   */
  protected void addEmergencyNetworkAdd(){

  }

  /**
   * �ً}����̐����f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addEmergencyNetworkAddModel(){

    getEmergencyNetworkAddItem1().setButtonIndex(1);

    getEmergencyNetworkAddModel().add(getEmergencyNetworkAddItem1());

    getEmergencyNetworkAddItem2().setButtonIndex(2);

    getEmergencyNetworkAddModel().add(getEmergencyNetworkAddItem2());

  }

  /**
   * �Ή��s�ɓ������ڂ�ǉ����܂��B
   */
  protected void addEmergencyNetworkAddItem1(){

  }

  /**
   * �Ή��ɓ������ڂ�ǉ����܂��B
   */
  protected void addEmergencyNetworkAddItem2(){

  }

  /**
   * ���ʗ×{��ڃR���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addSpecialMedicalDetailsContainer(){

    specialMedicalDetailsContainer.add(getSpecialMedicalDetailsItem1(), VRLayout.FLOW);

    specialMedicalDetailsContainer.add(getSpecialMedicalDetailsItem2(), VRLayout.FLOW);

  }

  /**
   * �d�ǔ畆��ᇎw���Ǘ��`�F�b�N�ɓ������ڂ�ǉ����܂��B
   */
  protected void addSpecialMedicalDetailsItem1(){

  }

  /**
   * ��܊Ǘ��w���`�F�b�N�ɓ������ڂ�ǉ����܂��B
   */
  protected void addSpecialMedicalDetailsItem2(){

  }

  /**
   * ���n�r���񋟑̐��R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addRehabilitationDetailsContainer(){

    rehabilitationDetailsContainer.add(getRehabilitationDetailsItem1(), VRLayout.FLOW);

    rehabilitationDetailsContainer.add(getRehabilitationDetailsItem2(), VRLayout.FLOW);

    rehabilitationDetailsContainer.add(getRehabilitationDetailsItem3(), VRLayout.FLOW);

  }

  /**
   * ���꒮�o�Ö@�`�F�b�N�ɓ������ڂ�ǉ����܂��B
   */
  protected void addRehabilitationDetailsItem1(){

  }

  /**
   * ���_�ȍ�ƗÖ@�`�F�b�N�ɓ������ڂ�ǉ����܂��B
   */
  protected void addRehabilitationDetailsItem2(){

  }

  /**
   * ���̑��`�F�b�N�ɓ������ڂ�ǉ����܂��B
   */
  protected void addRehabilitationDetailsItem3(){

  }

  /**
   * �×{�̐��ێ����ʉ��Z���W�I�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalSystemUpkeep(){

  }

  /**
   * �×{�̐��ێ����ʉ��Z���W�I�O���[�v���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalSystemUpkeepModel(){

    getMedicalSystemUpkeeItem1().setButtonIndex(1);

    getMedicalSystemUpkeepModel().add(getMedicalSystemUpkeeItem1());

    getMedicalSystemUpkeeItem2().setButtonIndex(2);

    getMedicalSystemUpkeepModel().add(getMedicalSystemUpkeeItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalSystemUpkeeItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalSystemUpkeeItem2(){

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
   * ���ZI�ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceAddProvisionStructuralRadioItem2(){

  }

  /**
   * ���ZII�ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceAddProvisionStructuralRadioItem3(){

  }

  /**
   * ���ZIII�ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceAddProvisionStructuralRadioItem4(){

  }

  /**
   * �p�l��2�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPanel2(){

    panel2.add(getOldLowElementArea(), VRLayout.NORTH);

    panel2.add(getStandardMoneyGroup(), VRLayout.NORTH);

    panel2.add(getCalculationDetails2(), VRLayout.NORTH);

  }

  /**
   * ���@���ڂɓ������ڂ�ǉ����܂��B
   */
  protected void addOldLowElementArea(){

    oldLowElementArea.add(getOldLowH2103Group(), VRLayout.NORTH);

  }

  /**
   * ����21�N3���ȑO�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addOldLowH2103Group(){

    oldLowH2103Group.add(getStaffLack_H2103Container(), VRLayout.FLOW_INSETLINE_RETURN);

    oldLowH2103Group.add(getNourishmentControlAddContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * �E���̌����ɂ�錸�Z�̏󋵂ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffLack_H2103(){

  }

  /**
   * �E���̌����ɂ�錸�Z�̏󋵃��f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffLack_H2103Model(){

    getStaffLackItem1_H2103().setButtonIndex(1);

    getStaffLack_H2103Model().add(getStaffLackItem1_H2103());

    getStaffLackItem2_H2103().setButtonIndex(2);

    getStaffLack_H2103Model().add(getStaffLackItem2_H2103());

    getStaffLackItem3_H2103().setButtonIndex(3);

    getStaffLack_H2103Model().add(getStaffLackItem3_H2103());

    getStaffLackItem4_H2103().setButtonIndex(4);

    getStaffLack_H2103Model().add(getStaffLackItem4_H2103());

    getStaffLackItem5_H2103().setButtonIndex(5);

    getStaffLack_H2103Model().add(getStaffLackItem5_H2103());

    getStaffLackItem6_H2103().setButtonIndex(6);

    getStaffLack_H2103Model().add(getStaffLackItem6_H2103());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffLackItem1_H2103(){

  }

  /**
   * ��t�ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffLackItem2_H2103(){

  }

  /**
   * �Ō�E���ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffLackItem3_H2103(){

  }

  /**
   * ���E���ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffLackItem4_H2103(){

  }

  /**
   * ���w�Ö@�m�ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffLackItem5_H2103(){

  }

  /**
   * ��ƗÖ@�m�ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffLackItem6_H2103(){

  }

  /**
   * �h�{�Ǘ��̕]���ɓ������ڂ�ǉ����܂��B
   */
  protected void addNourishmentControlAdd(){

  }

  /**
   * �h�{�Ǘ��̕]�����f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addNourishmentControlAddModel(){

    getNourishmentControlAddItem1().setButtonIndex(1);

    getNourishmentControlAddModel().add(getNourishmentControlAddItem1());

    getNourishmentControlAddItem2().setButtonIndex(2);

    getNourishmentControlAddModel().add(getNourishmentControlAddItem2());

    getNourishmentControlAddItem3().setButtonIndex(3);

    getNourishmentControlAddModel().add(getNourishmentControlAddItem3());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addNourishmentControlAddItem1(){

  }

  /**
   * �h�{�m�ɓ������ڂ�ǉ����܂��B
   */
  protected void addNourishmentControlAddItem2(){

  }

  /**
   * �Ǘ��h�{�m�ɓ������ڂ�ǉ����܂��B
   */
  protected void addNourishmentControlAddItem3(){

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
   * �Z�荀�ڗ̈�2�ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalculationDetails2(){

    calculationDetails2.add(getReduceRateContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * �������R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addReduceRateContainer(){

    reduceRateContainer.add(getReduceRate(), VRLayout.FLOW);

    reduceRateContainer.add(getPercentSign(), VRLayout.FLOW);

  }

  /**
   * �e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addReduceRate(){

  }

  /**
   * ���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addPercentSign(){

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
      ACFrame.debugStart(new ACAffairInfo(QO004110Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QO004110Design getThis() {
    return this;
  }
}
