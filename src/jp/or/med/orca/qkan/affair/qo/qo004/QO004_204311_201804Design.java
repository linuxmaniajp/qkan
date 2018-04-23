
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
 * �쐬��: 2018/02/21  ���{�R���s���[�^�[������� �����@���̂� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���̑��@�\ (O)
 * �v���Z�X ���Ə����o�^ (004)
 * �v���O���� �\�h�Z�������×{���i����É@�j (QO004_204311_201804)
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
 * �\�h�Z�������×{���i����É@�j��ʍ��ڃf�U�C��(QO004_204311_201804) 
 */
public class QO004_204311_201804Design extends QO004ProviderPanel {
  //GUI�R���|�[�l���g

  private ACGroupBox mainGroup;

  private JTabbedPane tabs;

  private ACPanel tab1;

  private ACPanel panel1;

  private ACValueArrayRadioButtonGroup facilitiesDivision;

  private ACLabelContainer facilitiesDivisionContainer;

  private ACListModelAdapter facilitiesDivisionModel;

  private ACRadioButtonItem facilitiesDivisionItem1;

  private ACRadioButtonItem facilitiesDivisionItem2;

  private ACRadioButtonItem facilitiesDivisionItem3;

  private ACRadioButtonItem facilitiesDivisionItem4;

  private ACRadioButtonItem facilitiesDivisionItem5;

  private ACRadioButtonItem facilitiesDivisionItem6;

  private ACLabelContainer personnelDivisionContainer;

  private ACValueArrayRadioButtonGroup staffAssignmentDivision1;

  private ACListModelAdapter staffAssignmentDivision1Model;

  private ACRadioButtonItem staffAssignmentDivision1Item1;

  private ACRadioButtonItem staffAssignmentDivision1Item2;

  private ACRadioButtonItem staffAssignmentDivision1Item3;

  private ACValueArrayRadioButtonGroup staffAssignmentDivision2;

  private ACListModelAdapter staffAssignmentDivision2Model;

  private ACRadioButtonItem staffAssignmentDivision2Item1;

  private ACRadioButtonItem staffAssignmentDivision2Item2;

  private ACRadioButtonItem staffAssignmentDivision2Item3;

  private ACValueArrayRadioButtonGroup staffAssignmentDivision3;

  private ACListModelAdapter staffAssignmentDivision3Model;

  private ACRadioButtonItem staffAssignmentDivision3Item1;

  private ACRadioButtonItem staffAssignmentDivision3Item2;

  private ACValueArrayRadioButtonGroup nightWorkDivision;

  private ACLabelContainer nightWorkDivisionContainer;

  private ACListModelAdapter nightWorkDivisionModel;

  private ACRadioButtonItem nightWorkDivisionItem1;

  private ACRadioButtonItem nightWorkDivisionItem2;

  private ACRadioButtonItem nightWorkDivisionItem3;

  private ACRadioButtonItem nightWorkDivisionItem4;

  private ACRadioButtonItem nightWorkDivisionItem5;

  private ACRadioButtonItem nightWorkDivisionItem6;

  private ACValueArrayRadioButtonGroup staffLack;

  private ACLabelContainer staffLackContainer;

  private ACListModelAdapter staffLackModel;

  private ACRadioButtonItem staffLackItem1;

  private ACRadioButtonItem staffLackItem2;

  private ACRadioButtonItem staffLackItem3;

  private ACRadioButtonItem staffLackItem4;

  private ACRadioButtonItem staffLackItem5;

  private ACValueArrayRadioButtonGroup unitCareMaintenance;

  private ACLabelContainer unitCareMaintenanceContainer;

  private ACListModelAdapter unitCareMaintenanceModel;

  private ACRadioButtonItem unitCareMaintenanceItem1;

  private ACRadioButtonItem unitCareMaintenanceItem2;

  private ACValueArrayRadioButtonGroup recuperationEnvironmental1;

  private ACLabelContainer recuperationEnvironmental1Container;

  private ACListModelAdapter recuperationEnvironmental1Model;

  private ACRadioButtonItem recuperationEnvironmental1Item1;

  private ACRadioButtonItem recuperationEnvironmental1Item2;

  private ACValueArrayRadioButtonGroup recuperationEnvironmental2;

  private ACLabelContainer recuperationEnvironmental2Container;

  private ACListModelAdapter recuperationEnvironmental2Model;

  private ACRadioButtonItem recuperationEnvironmental2Item1;

  private ACRadioButtonItem recuperationEnvironmental2Item2;

  private ACPanel tab2;

  private ACPanel panel2;

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

  private ACValueArrayRadioButtonGroup dementiaCareRadioGroup;

  private ACLabelContainer dementiaCareRadioGroupContainer;

  private ACListModelAdapter dementiaCareRadioGroupModel;

  private ACRadioButtonItem dementiaCareRadioItem1;

  private ACRadioButtonItem dementiaCareRadioItem2;

  private ACRadioButtonItem dementiaCareRadioItem3;

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

  private ACRadioButtonItem staffUpgradeRadioItem6;

  private ACPanel tab3;

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

      mainGroup.setText("�\�h�Z�������×{���i����É@�j");

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

      addTab1();
    }
    return tab1;

  }

  /**
   * �Z�荀�ڗ̈���擾���܂��B
   * @return �Z�荀�ڗ̈�
   */
  public ACPanel getPanel1(){
    if(panel1==null){

      panel1 = new ACPanel();

      panel1.setFollowChildEnabled(true);

      panel1.setHgrid(200);

      addPanel1();
    }
    return panel1;

  }

  /**
   * �{�݋敪���W�I�O���[�v���擾���܂��B
   * @return �{�݋敪���W�I�O���[�v
   */
  public ACValueArrayRadioButtonGroup getFacilitiesDivision(){
    if(facilitiesDivision==null){

      facilitiesDivision = new ACValueArrayRadioButtonGroup();

      getFacilitiesDivisionContainer().setText("�{�ݓ��̋敪");

      facilitiesDivision.setBindPath("20430101");

      facilitiesDivision.setUseClearButton(false);

      facilitiesDivision.setModel(getFacilitiesDivisionModel());

      facilitiesDivision.setValues(new int[]{1,2,3,4,5,6});

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
   * I �^����É@���擾���܂��B
   * @return I �^����É@
   */
  public ACRadioButtonItem getFacilitiesDivisionItem1(){
    if(facilitiesDivisionItem1==null){

      facilitiesDivisionItem1 = new ACRadioButtonItem();

      facilitiesDivisionItem1.setText("I �^����É@");

      facilitiesDivisionItem1.setGroup(getFacilitiesDivision());

      facilitiesDivisionItem1.setConstraints(VRLayout.FLOW_RETURN);

      addFacilitiesDivisionItem1();
    }
    return facilitiesDivisionItem1;

  }

  /**
   * II �^����É@���擾���܂��B
   * @return II �^����É@
   */
  public ACRadioButtonItem getFacilitiesDivisionItem2(){
    if(facilitiesDivisionItem2==null){

      facilitiesDivisionItem2 = new ACRadioButtonItem();

      facilitiesDivisionItem2.setText("II �^����É@");

      facilitiesDivisionItem2.setGroup(getFacilitiesDivision());

      facilitiesDivisionItem2.setConstraints(VRLayout.FLOW_RETURN);

      addFacilitiesDivisionItem2();
    }
    return facilitiesDivisionItem2;

  }

  /**
   * ���ʉ���É@���擾���܂��B
   * @return ���ʉ���É@
   */
  public ACRadioButtonItem getFacilitiesDivisionItem3(){
    if(facilitiesDivisionItem3==null){

      facilitiesDivisionItem3 = new ACRadioButtonItem();

      facilitiesDivisionItem3.setText("���ʉ���É@");

      facilitiesDivisionItem3.setGroup(getFacilitiesDivision());

      facilitiesDivisionItem3.setConstraints(VRLayout.FLOW_RETURN);

      addFacilitiesDivisionItem3();
    }
    return facilitiesDivisionItem3;

  }

  /**
   * ���j�b�g�^I �^����É@���擾���܂��B
   * @return ���j�b�g�^I �^����É@
   */
  public ACRadioButtonItem getFacilitiesDivisionItem4(){
    if(facilitiesDivisionItem4==null){

      facilitiesDivisionItem4 = new ACRadioButtonItem();

      facilitiesDivisionItem4.setText("���j�b�g�^I �^����É@");

      facilitiesDivisionItem4.setGroup(getFacilitiesDivision());

      facilitiesDivisionItem4.setConstraints(VRLayout.FLOW_RETURN);

      addFacilitiesDivisionItem4();
    }
    return facilitiesDivisionItem4;

  }

  /**
   * ���j�b�g�^II �^����É@���擾���܂��B
   * @return ���j�b�g�^II �^����É@
   */
  public ACRadioButtonItem getFacilitiesDivisionItem5(){
    if(facilitiesDivisionItem5==null){

      facilitiesDivisionItem5 = new ACRadioButtonItem();

      facilitiesDivisionItem5.setText("���j�b�g�^II �^����É@");

      facilitiesDivisionItem5.setGroup(getFacilitiesDivision());

      facilitiesDivisionItem5.setConstraints(VRLayout.FLOW_RETURN);

      addFacilitiesDivisionItem5();
    }
    return facilitiesDivisionItem5;

  }

  /**
   * ���j�b�g�^���ʉ���É@���擾���܂��B
   * @return ���j�b�g�^���ʉ���É@
   */
  public ACRadioButtonItem getFacilitiesDivisionItem6(){
    if(facilitiesDivisionItem6==null){

      facilitiesDivisionItem6 = new ACRadioButtonItem();

      facilitiesDivisionItem6.setText("���j�b�g�^���ʉ���É@");

      facilitiesDivisionItem6.setGroup(getFacilitiesDivision());

      facilitiesDivisionItem6.setConstraints(VRLayout.FLOW_RETURN);

      addFacilitiesDivisionItem6();
    }
    return facilitiesDivisionItem6;

  }

  /**
   * �l���z�u�敪�R���e�i���擾���܂��B
   * @return �l���z�u�敪�R���e�i
   */
  public ACLabelContainer getPersonnelDivisionContainer(){
    if(personnelDivisionContainer==null){

      personnelDivisionContainer = new ACLabelContainer();

      personnelDivisionContainer.setText("�l���z�u�敪");

      personnelDivisionContainer.setFollowChildEnabled(true);

      addPersonnelDivisionContainer();
    }
    return personnelDivisionContainer;

  }

  /**
   * �l���z�u�敪�P���擾���܂��B
   * @return �l���z�u�敪�P
   */
  public ACValueArrayRadioButtonGroup getStaffAssignmentDivision1(){
    if(staffAssignmentDivision1==null){

      staffAssignmentDivision1 = new ACValueArrayRadioButtonGroup();

      staffAssignmentDivision1.setBindPath("20430102");

      staffAssignmentDivision1.setUseClearButton(false);

      staffAssignmentDivision1.setModel(getStaffAssignmentDivision1Model());

      staffAssignmentDivision1.setValues(new int[]{1,2,3});

      addStaffAssignmentDivision1();
    }
    return staffAssignmentDivision1;

  }

  /**
   * �l���z�u�敪�P���f�����擾���܂��B
   * @return �l���z�u�敪�P���f��
   */
  protected ACListModelAdapter getStaffAssignmentDivision1Model(){
    if(staffAssignmentDivision1Model==null){
      staffAssignmentDivision1Model = new ACListModelAdapter();
      addStaffAssignmentDivision1Model();
    }
    return staffAssignmentDivision1Model;
  }

  /**
   * I �^�iI�j���擾���܂��B
   * @return I �^�iI�j
   */
  public ACRadioButtonItem getStaffAssignmentDivision1Item1(){
    if(staffAssignmentDivision1Item1==null){

      staffAssignmentDivision1Item1 = new ACRadioButtonItem();

      staffAssignmentDivision1Item1.setText("I �^�iI�j");

      staffAssignmentDivision1Item1.setGroup(getStaffAssignmentDivision1());

      staffAssignmentDivision1Item1.setConstraints(VRLayout.FLOW);

      addStaffAssignmentDivision1Item1();
    }
    return staffAssignmentDivision1Item1;

  }

  /**
   * I �^�iII�j���擾���܂��B
   * @return I �^�iII�j
   */
  public ACRadioButtonItem getStaffAssignmentDivision1Item2(){
    if(staffAssignmentDivision1Item2==null){

      staffAssignmentDivision1Item2 = new ACRadioButtonItem();

      staffAssignmentDivision1Item2.setText("I �^�iII�j");

      staffAssignmentDivision1Item2.setGroup(getStaffAssignmentDivision1());

      staffAssignmentDivision1Item2.setConstraints(VRLayout.FLOW);

      addStaffAssignmentDivision1Item2();
    }
    return staffAssignmentDivision1Item2;

  }

  /**
   * I �^�iIII�j���擾���܂��B
   * @return I �^�iIII�j
   */
  public ACRadioButtonItem getStaffAssignmentDivision1Item3(){
    if(staffAssignmentDivision1Item3==null){

      staffAssignmentDivision1Item3 = new ACRadioButtonItem();

      staffAssignmentDivision1Item3.setText("I �^�iIII�j");

      staffAssignmentDivision1Item3.setGroup(getStaffAssignmentDivision1());

      staffAssignmentDivision1Item3.setConstraints(VRLayout.FLOW);

      addStaffAssignmentDivision1Item3();
    }
    return staffAssignmentDivision1Item3;

  }

  /**
   * �l���z�u�敪�Q���擾���܂��B
   * @return �l���z�u�敪�Q
   */
  public ACValueArrayRadioButtonGroup getStaffAssignmentDivision2(){
    if(staffAssignmentDivision2==null){

      staffAssignmentDivision2 = new ACValueArrayRadioButtonGroup();

      staffAssignmentDivision2.setBindPath("20430103");

      staffAssignmentDivision2.setUseClearButton(false);

      staffAssignmentDivision2.setModel(getStaffAssignmentDivision2Model());

      staffAssignmentDivision2.setValues(new int[]{1,2,3});

      addStaffAssignmentDivision2();
    }
    return staffAssignmentDivision2;

  }

  /**
   * �l���z�u�敪�Q���f�����擾���܂��B
   * @return �l���z�u�敪�Q���f��
   */
  protected ACListModelAdapter getStaffAssignmentDivision2Model(){
    if(staffAssignmentDivision2Model==null){
      staffAssignmentDivision2Model = new ACListModelAdapter();
      addStaffAssignmentDivision2Model();
    }
    return staffAssignmentDivision2Model;
  }

  /**
   * II �^�iI�j���擾���܂��B
   * @return II �^�iI�j
   */
  public ACRadioButtonItem getStaffAssignmentDivision2Item1(){
    if(staffAssignmentDivision2Item1==null){

      staffAssignmentDivision2Item1 = new ACRadioButtonItem();

      staffAssignmentDivision2Item1.setText("II �^�iI�j");

      staffAssignmentDivision2Item1.setGroup(getStaffAssignmentDivision2());

      staffAssignmentDivision2Item1.setConstraints(VRLayout.FLOW);

      addStaffAssignmentDivision2Item1();
    }
    return staffAssignmentDivision2Item1;

  }

  /**
   * II �^�iII�j���擾���܂��B
   * @return II �^�iII�j
   */
  public ACRadioButtonItem getStaffAssignmentDivision2Item2(){
    if(staffAssignmentDivision2Item2==null){

      staffAssignmentDivision2Item2 = new ACRadioButtonItem();

      staffAssignmentDivision2Item2.setText("II �^�iII�j");

      staffAssignmentDivision2Item2.setGroup(getStaffAssignmentDivision2());

      staffAssignmentDivision2Item2.setConstraints(VRLayout.FLOW);

      addStaffAssignmentDivision2Item2();
    }
    return staffAssignmentDivision2Item2;

  }

  /**
   * II �^�iIII�j���擾���܂��B
   * @return II �^�iIII�j
   */
  public ACRadioButtonItem getStaffAssignmentDivision2Item3(){
    if(staffAssignmentDivision2Item3==null){

      staffAssignmentDivision2Item3 = new ACRadioButtonItem();

      staffAssignmentDivision2Item3.setText("II �^�iIII�j");

      staffAssignmentDivision2Item3.setGroup(getStaffAssignmentDivision2());

      staffAssignmentDivision2Item3.setConstraints(VRLayout.FLOW);

      addStaffAssignmentDivision2Item3();
    }
    return staffAssignmentDivision2Item3;

  }

  /**
   * �l���z�u�敪�R���擾���܂��B
   * @return �l���z�u�敪�R
   */
  public ACValueArrayRadioButtonGroup getStaffAssignmentDivision3(){
    if(staffAssignmentDivision3==null){

      staffAssignmentDivision3 = new ACValueArrayRadioButtonGroup();

      staffAssignmentDivision3.setBindPath("20430104");

      staffAssignmentDivision3.setUseClearButton(false);

      staffAssignmentDivision3.setModel(getStaffAssignmentDivision3Model());

      staffAssignmentDivision3.setValues(new int[]{1,2});

      addStaffAssignmentDivision3();
    }
    return staffAssignmentDivision3;

  }

  /**
   * �l���z�u�敪�R���f�����擾���܂��B
   * @return �l���z�u�敪�R���f��
   */
  protected ACListModelAdapter getStaffAssignmentDivision3Model(){
    if(staffAssignmentDivision3Model==null){
      staffAssignmentDivision3Model = new ACListModelAdapter();
      addStaffAssignmentDivision3Model();
    }
    return staffAssignmentDivision3Model;
  }

  /**
   * I �^���擾���܂��B
   * @return I �^
   */
  public ACRadioButtonItem getStaffAssignmentDivision3Item1(){
    if(staffAssignmentDivision3Item1==null){

      staffAssignmentDivision3Item1 = new ACRadioButtonItem();

      staffAssignmentDivision3Item1.setText("I �^");

      staffAssignmentDivision3Item1.setGroup(getStaffAssignmentDivision3());

      staffAssignmentDivision3Item1.setConstraints(VRLayout.FLOW);

      addStaffAssignmentDivision3Item1();
    }
    return staffAssignmentDivision3Item1;

  }

  /**
   * II �^���擾���܂��B
   * @return II �^
   */
  public ACRadioButtonItem getStaffAssignmentDivision3Item2(){
    if(staffAssignmentDivision3Item2==null){

      staffAssignmentDivision3Item2 = new ACRadioButtonItem();

      staffAssignmentDivision3Item2.setText("II �^");

      staffAssignmentDivision3Item2.setGroup(getStaffAssignmentDivision3());

      staffAssignmentDivision3Item2.setConstraints(VRLayout.FLOW);

      addStaffAssignmentDivision3Item2();
    }
    return staffAssignmentDivision3Item2;

  }

  /**
   * ��ԋΖ���������W�I�O���[�v���擾���܂��B
   * @return ��ԋΖ���������W�I�O���[�v
   */
  public ACValueArrayRadioButtonGroup getNightWorkDivision(){
    if(nightWorkDivision==null){

      nightWorkDivision = new ACValueArrayRadioButtonGroup();

      getNightWorkDivisionContainer().setText("��ԋΖ������");

      nightWorkDivision.setBindPath("20430105");

      nightWorkDivision.setUseClearButton(false);

      nightWorkDivision.setModel(getNightWorkDivisionModel());

      nightWorkDivision.setValues(new int[]{1,2,3,7,5,6});

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

      nightWorkDivisionItem2.setText("���Z�^I");

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

      nightWorkDivisionItem3.setText("���Z�^II");

      nightWorkDivisionItem3.setGroup(getNightWorkDivision());

      nightWorkDivisionItem3.setConstraints(VRLayout.FLOW_RETURN);

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

      nightWorkDivisionItem4.setText("���Z�^III");

      nightWorkDivisionItem4.setGroup(getNightWorkDivision());

      nightWorkDivisionItem4.setConstraints(VRLayout.FLOW);

      addNightWorkDivisionItem4();
    }
    return nightWorkDivisionItem4;

  }

  /**
   * ���Z�^IV���擾���܂��B
   * @return ���Z�^IV
   */
  public ACRadioButtonItem getNightWorkDivisionItem5(){
    if(nightWorkDivisionItem5==null){

      nightWorkDivisionItem5 = new ACRadioButtonItem();

      nightWorkDivisionItem5.setText("���Z�^IV");

      nightWorkDivisionItem5.setGroup(getNightWorkDivision());

      nightWorkDivisionItem5.setConstraints(VRLayout.FLOW);

      addNightWorkDivisionItem5();
    }
    return nightWorkDivisionItem5;

  }

  /**
   * ���Z�^���擾���܂��B
   * @return ���Z�^
   */
  public ACRadioButtonItem getNightWorkDivisionItem6(){
    if(nightWorkDivisionItem6==null){

      nightWorkDivisionItem6 = new ACRadioButtonItem();

      nightWorkDivisionItem6.setText("���Z�^");

      nightWorkDivisionItem6.setGroup(getNightWorkDivision());

      nightWorkDivisionItem6.setConstraints(VRLayout.FLOW);

      addNightWorkDivisionItem6();
    }
    return nightWorkDivisionItem6;

  }

  /**
   * �E���̌����ɂ�錸�Z�̏󋵂��擾���܂��B
   * @return �E���̌����ɂ�錸�Z�̏�
   */
  public ACValueArrayRadioButtonGroup getStaffLack(){
    if(staffLack==null){

      staffLack = new ACValueArrayRadioButtonGroup();

      getStaffLackContainer().setText("�E���̌����ɂ�錸�Z�̏�");

      staffLack.setBindPath("20430106");

      staffLack.setUseClearButton(false);

      staffLack.setModel(getStaffLackModel());

      staffLack.setValues(new int[]{1,2,3,4,5});

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
   * ��܎t���擾���܂��B
   * @return ��܎t
   */
  public ACRadioButtonItem getStaffLackItem3(){
    if(staffLackItem3==null){

      staffLackItem3 = new ACRadioButtonItem();

      staffLackItem3.setText("��܎t");

      staffLackItem3.setGroup(getStaffLack());

      staffLackItem3.setConstraints(VRLayout.FLOW);

      addStaffLackItem3();
    }
    return staffLackItem3;

  }

  /**
   * �Ō�E�����擾���܂��B
   * @return �Ō�E��
   */
  public ACRadioButtonItem getStaffLackItem4(){
    if(staffLackItem4==null){

      staffLackItem4 = new ACRadioButtonItem();

      staffLackItem4.setText("�Ō�E��");

      staffLackItem4.setGroup(getStaffLack());

      staffLackItem4.setConstraints(VRLayout.FLOW_RETURN);

      addStaffLackItem4();
    }
    return staffLackItem4;

  }

  /**
   * ���E�����擾���܂��B
   * @return ���E��
   */
  public ACRadioButtonItem getStaffLackItem5(){
    if(staffLackItem5==null){

      staffLackItem5 = new ACRadioButtonItem();

      staffLackItem5.setText("���E��");

      staffLackItem5.setGroup(getStaffLack());

      staffLackItem5.setConstraints(VRLayout.FLOW);

      addStaffLackItem5();
    }
    return staffLackItem5;

  }

  /**
   * ���j�b�g�P�A�̐����擾���܂��B
   * @return ���j�b�g�P�A�̐�
   */
  public ACValueArrayRadioButtonGroup getUnitCareMaintenance(){
    if(unitCareMaintenance==null){

      unitCareMaintenance = new ACValueArrayRadioButtonGroup();

      getUnitCareMaintenanceContainer().setText("���j�b�g�P�A�̐�");

      unitCareMaintenance.setBindPath("20430107");

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
   * �×{����i�L���j���擾���܂��B
   * @return �×{����i�L���j
   */
  public ACValueArrayRadioButtonGroup getRecuperationEnvironmental1(){
    if(recuperationEnvironmental1==null){

      recuperationEnvironmental1 = new ACValueArrayRadioButtonGroup();

      getRecuperationEnvironmental1Container().setText("�×{����i�L���j");

      recuperationEnvironmental1.setBindPath("20430108");

      recuperationEnvironmental1.setUseClearButton(false);

      recuperationEnvironmental1.setModel(getRecuperationEnvironmental1Model());

      recuperationEnvironmental1.setValues(new int[]{1,2});

      addRecuperationEnvironmental1();
    }
    return recuperationEnvironmental1;

  }

  /**
   * �×{����i�L���j�R���e�i���擾���܂��B
   * @return �×{����i�L���j�R���e�i
   */
  protected ACLabelContainer getRecuperationEnvironmental1Container(){
    if(recuperationEnvironmental1Container==null){
      recuperationEnvironmental1Container = new ACLabelContainer();
      recuperationEnvironmental1Container.setFollowChildEnabled(true);
      recuperationEnvironmental1Container.setVAlignment(VRLayout.CENTER);
      recuperationEnvironmental1Container.add(getRecuperationEnvironmental1(), null);
    }
    return recuperationEnvironmental1Container;
  }

  /**
   * �×{����i�L���j���f�����擾���܂��B
   * @return �×{����i�L���j���f��
   */
  protected ACListModelAdapter getRecuperationEnvironmental1Model(){
    if(recuperationEnvironmental1Model==null){
      recuperationEnvironmental1Model = new ACListModelAdapter();
      addRecuperationEnvironmental1Model();
    }
    return recuperationEnvironmental1Model;
  }

  /**
   * ��^���擾���܂��B
   * @return ��^
   */
  public ACRadioButtonItem getRecuperationEnvironmental1Item1(){
    if(recuperationEnvironmental1Item1==null){

      recuperationEnvironmental1Item1 = new ACRadioButtonItem();

      recuperationEnvironmental1Item1.setText("��^");

      recuperationEnvironmental1Item1.setGroup(getRecuperationEnvironmental1());

      addRecuperationEnvironmental1Item1();
    }
    return recuperationEnvironmental1Item1;

  }

  /**
   * ���Z�^���擾���܂��B
   * @return ���Z�^
   */
  public ACRadioButtonItem getRecuperationEnvironmental1Item2(){
    if(recuperationEnvironmental1Item2==null){

      recuperationEnvironmental1Item2 = new ACRadioButtonItem();

      recuperationEnvironmental1Item2.setText("���Z�^");

      recuperationEnvironmental1Item2.setGroup(getRecuperationEnvironmental1());

      addRecuperationEnvironmental1Item2();
    }
    return recuperationEnvironmental1Item2;

  }

  /**
   * �×{����i�×{���j���擾���܂��B
   * @return �×{����i�×{���j
   */
  public ACValueArrayRadioButtonGroup getRecuperationEnvironmental2(){
    if(recuperationEnvironmental2==null){

      recuperationEnvironmental2 = new ACValueArrayRadioButtonGroup();

      getRecuperationEnvironmental2Container().setText("�×{����i�×{���j");

      recuperationEnvironmental2.setBindPath("20430109");

      recuperationEnvironmental2.setUseClearButton(false);

      recuperationEnvironmental2.setModel(getRecuperationEnvironmental2Model());

      recuperationEnvironmental2.setValues(new int[]{1,2});

      addRecuperationEnvironmental2();
    }
    return recuperationEnvironmental2;

  }

  /**
   * �×{����i�×{���j�R���e�i���擾���܂��B
   * @return �×{����i�×{���j�R���e�i
   */
  protected ACLabelContainer getRecuperationEnvironmental2Container(){
    if(recuperationEnvironmental2Container==null){
      recuperationEnvironmental2Container = new ACLabelContainer();
      recuperationEnvironmental2Container.setFollowChildEnabled(true);
      recuperationEnvironmental2Container.setVAlignment(VRLayout.CENTER);
      recuperationEnvironmental2Container.add(getRecuperationEnvironmental2(), null);
    }
    return recuperationEnvironmental2Container;
  }

  /**
   * �×{����i�×{���j���f�����擾���܂��B
   * @return �×{����i�×{���j���f��
   */
  protected ACListModelAdapter getRecuperationEnvironmental2Model(){
    if(recuperationEnvironmental2Model==null){
      recuperationEnvironmental2Model = new ACListModelAdapter();
      addRecuperationEnvironmental2Model();
    }
    return recuperationEnvironmental2Model;
  }

  /**
   * ��^���擾���܂��B
   * @return ��^
   */
  public ACRadioButtonItem getRecuperationEnvironmental2Item1(){
    if(recuperationEnvironmental2Item1==null){

      recuperationEnvironmental2Item1 = new ACRadioButtonItem();

      recuperationEnvironmental2Item1.setText("��^");

      recuperationEnvironmental2Item1.setGroup(getRecuperationEnvironmental2());

      addRecuperationEnvironmental2Item1();
    }
    return recuperationEnvironmental2Item1;

  }

  /**
   * ���Z�^���擾���܂��B
   * @return ���Z�^
   */
  public ACRadioButtonItem getRecuperationEnvironmental2Item2(){
    if(recuperationEnvironmental2Item2==null){

      recuperationEnvironmental2Item2 = new ACRadioButtonItem();

      recuperationEnvironmental2Item2.setText("���Z�^");

      recuperationEnvironmental2Item2.setGroup(getRecuperationEnvironmental2());

      addRecuperationEnvironmental2Item2();
    }
    return recuperationEnvironmental2Item2;

  }

  /**
   * �^�u2���擾���܂��B
   * @return �^�u2
   */
  public ACPanel getTab2(){
    if(tab2==null){

      tab2 = new ACPanel();

      tab2.setFollowChildEnabled(true);

      addTab2();
    }
    return tab2;

  }

  /**
   * �Z�荀�ڗ̈���擾���܂��B
   * @return �Z�荀�ڗ̈�
   */
  public ACPanel getPanel2(){
    if(panel2==null){

      panel2 = new ACPanel();

      panel2.setFollowChildEnabled(true);

      panel2.setHgrid(200);

      addPanel2();
    }
    return panel2;

  }

  /**
   * ��N���F�m�Ǘ��p�Ҏ�����Z���擾���܂��B
   * @return ��N���F�m�Ǘ��p�Ҏ�����Z
   */
  public ACValueArrayRadioButtonGroup getYoungDementiaPatinetAddRadioGroup(){
    if(youngDementiaPatinetAddRadioGroup==null){

      youngDementiaPatinetAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getYoungDementiaPatinetAddRadioGroupContainer().setText("��N���F�m�Ǘ��p�Ҏ�����Z");

      youngDementiaPatinetAddRadioGroup.setBindPath("20430110");

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
   * ���}�̐����擾���܂��B
   * @return ���}�̐�
   */
  public ACValueArrayRadioButtonGroup getMeetingAndSendingOffSystem(){
    if(meetingAndSendingOffSystem==null){

      meetingAndSendingOffSystem = new ACValueArrayRadioButtonGroup();

      getMeetingAndSendingOffSystemContainer().setText("���}�̐�");

      meetingAndSendingOffSystem.setBindPath("20430111");

      meetingAndSendingOffSystem.setUseClearButton(false);

      meetingAndSendingOffSystem.setModel(getMeetingAndSendingOffSystemModel());

      meetingAndSendingOffSystem.setValues(new int[]{1,2});

      addMeetingAndSendingOffSystem();
    }
    return meetingAndSendingOffSystem;

  }

  /**
   * ���}�̐��R���e�i���擾���܂��B
   * @return ���}�̐��R���e�i
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
   * ���}�̐����f�����擾���܂��B
   * @return ���}�̐����f��
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

      meetingAndSendingOffSystemItem1.setConstraints(VRLayout.FLOW);

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

      meetingAndSendingOffSystemItem2.setConstraints(VRLayout.FLOW);

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

      medicalFoodAddRadioGroup.setBindPath("20430112");

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
   * �F�m�ǐ��P�A���Z���擾���܂��B
   * @return �F�m�ǐ��P�A���Z
   */
  public ACValueArrayRadioButtonGroup getDementiaCareRadioGroup(){
    if(dementiaCareRadioGroup==null){

      dementiaCareRadioGroup = new ACValueArrayRadioButtonGroup();

      getDementiaCareRadioGroupContainer().setText("�F�m�ǐ��P�A���Z");

      dementiaCareRadioGroup.setBindPath("20430113");

      dementiaCareRadioGroup.setNoSelectIndex(0);

      dementiaCareRadioGroup.setUseClearButton(false);

      dementiaCareRadioGroup.setModel(getDementiaCareRadioGroupModel());

      dementiaCareRadioGroup.setValues(new int[]{1,2,3});

      addDementiaCareRadioGroup();
    }
    return dementiaCareRadioGroup;

  }

  /**
   * �F�m�ǐ��P�A���Z�R���e�i���擾���܂��B
   * @return �F�m�ǐ��P�A���Z�R���e�i
   */
  protected ACLabelContainer getDementiaCareRadioGroupContainer(){
    if(dementiaCareRadioGroupContainer==null){
      dementiaCareRadioGroupContainer = new ACLabelContainer();
      dementiaCareRadioGroupContainer.setFollowChildEnabled(true);
      dementiaCareRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      dementiaCareRadioGroupContainer.add(getDementiaCareRadioGroup(), null);
    }
    return dementiaCareRadioGroupContainer;
  }

  /**
   * �F�m�ǐ��P�A���Z���f�����擾���܂��B
   * @return �F�m�ǐ��P�A���Z���f��
   */
  protected ACListModelAdapter getDementiaCareRadioGroupModel(){
    if(dementiaCareRadioGroupModel==null){
      dementiaCareRadioGroupModel = new ACListModelAdapter();
      addDementiaCareRadioGroupModel();
    }
    return dementiaCareRadioGroupModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getDementiaCareRadioItem1(){
    if(dementiaCareRadioItem1==null){

      dementiaCareRadioItem1 = new ACRadioButtonItem();

      dementiaCareRadioItem1.setText("�Ȃ�");

      dementiaCareRadioItem1.setGroup(getDementiaCareRadioGroup());

      dementiaCareRadioItem1.setConstraints(VRLayout.FLOW);

      addDementiaCareRadioItem1();
    }
    return dementiaCareRadioItem1;

  }

  /**
   * ���ZI���擾���܂��B
   * @return ���ZI
   */
  public ACRadioButtonItem getDementiaCareRadioItem2(){
    if(dementiaCareRadioItem2==null){

      dementiaCareRadioItem2 = new ACRadioButtonItem();

      dementiaCareRadioItem2.setText("���ZI");

      dementiaCareRadioItem2.setGroup(getDementiaCareRadioGroup());

      dementiaCareRadioItem2.setConstraints(VRLayout.FLOW);

      addDementiaCareRadioItem2();
    }
    return dementiaCareRadioItem2;

  }

  /**
   * ���ZII���擾���܂��B
   * @return ���ZII
   */
  public ACRadioButtonItem getDementiaCareRadioItem3(){
    if(dementiaCareRadioItem3==null){

      dementiaCareRadioItem3 = new ACRadioButtonItem();

      dementiaCareRadioItem3.setText("���ZII");

      dementiaCareRadioItem3.setGroup(getDementiaCareRadioGroup());

      dementiaCareRadioItem3.setConstraints(VRLayout.FLOW);

      addDementiaCareRadioItem3();
    }
    return dementiaCareRadioItem3;

  }

  /**
   * ���ʐf�Ô�ڃR���e�i���擾���܂��B
   * @return ���ʐf�Ô�ڃR���e�i
   */
  public ACLabelContainer getSpecialClinicDetailsContainer(){
    if(specialClinicDetailsContainer==null){

      specialClinicDetailsContainer = new ACLabelContainer();

      specialClinicDetailsContainer.setText("���ʐf�Ô��");

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

      serviceAddProvisionStructuralRadioGroup.setBindPath("20430115");

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

      serviceAddProvisionStructuralRadioItem3.setConstraints(VRLayout.FLOW_RETURN);

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

      staffUpgradeRadioGroup.setValues(new int[]{1,6,5,2,3,4});

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

      staffUpgradeRadioItem4.setConstraints(VRLayout.FLOW_RETURN);

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
   * ���ZV���擾���܂��B
   * @return ���ZV
   */
  public ACRadioButtonItem getStaffUpgradeRadioItem6(){
    if(staffUpgradeRadioItem6==null){

      staffUpgradeRadioItem6 = new ACRadioButtonItem();

      staffUpgradeRadioItem6.setText("���ZV");

      staffUpgradeRadioItem6.setGroup(getStaffUpgradeRadioGroup());

      staffUpgradeRadioItem6.setConstraints(VRLayout.FLOW);

      addStaffUpgradeRadioItem6();
    }
    return staffUpgradeRadioItem6;

  }

  /**
   * �^�u3���擾���܂��B
   * @return �^�u3
   */
  public ACPanel getTab3(){
    if(tab3==null){

      tab3 = new ACPanel();

      tab3.setFollowChildEnabled(true);

      addTab3();
    }
    return tab3;

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

      dinnerTotal.setBindPath("20430116");

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

      dinnerMorning.setBindPath("20430117");

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

      dinnerNoon.setBindPath("20430118");

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

      dinnerNight.setBindPath("20430119");

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

      unitRoom.setBindPath("20430120");

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
   * ���j�b�g�^���I��������z�E�R���e�i���擾���܂��B
   * @return ���j�b�g�^���I��������z�E�R���e�i
   */
  public ACLabelContainer getUnitSemiRoomContainer(){
    if(unitSemiRoomContainer==null){

      unitSemiRoomContainer = new ACLabelContainer();

      unitSemiRoomContainer.setText("���j�b�g�^���I������");

      unitSemiRoomContainer.setFollowChildEnabled(true);

      addUnitSemiRoomContainer();
    }
    return unitSemiRoomContainer;

  }

  /**
   * ���j�b�g�^���I��������z�E�e�L�X�g���擾���܂��B
   * @return ���j�b�g�^���I��������z�E�e�L�X�g
   */
  public ACTextField getUnitSemiRoom(){
    if(unitSemiRoom==null){

      unitSemiRoom = new ACTextField();

      unitSemiRoom.setBindPath("20430121");

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
   * ���j�b�g�^���I��������z�E���x�����擾���܂��B
   * @return ���j�b�g�^���I��������z�E���x��
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

      normalRoom.setBindPath("20430122");

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

      tasyouRoom.setBindPath("20430123");

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
  public QO004_204311_201804Design() {

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

    mainGroup.add(getTabs(), VRLayout.CLIENT);

  }

  /**
   * �^�u�ɓ������ڂ�ǉ����܂��B
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

    tab1.add(getPanel1(), VRLayout.NORTH);

  }

  /**
   * �Z�荀�ڗ̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPanel1(){

    panel1.add(getFacilitiesDivisionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    panel1.add(getPersonnelDivisionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    panel1.add(getNightWorkDivisionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    panel1.add(getStaffLackContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    panel1.add(getUnitCareMaintenanceContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    panel1.add(getRecuperationEnvironmental1Container(), VRLayout.FLOW_INSETLINE_RETURN);

    panel1.add(getRecuperationEnvironmental2Container(), VRLayout.FLOW_INSETLINE_RETURN);

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

    getFacilitiesDivisionItem5().setButtonIndex(5);

    getFacilitiesDivisionModel().add(getFacilitiesDivisionItem5());

    getFacilitiesDivisionItem6().setButtonIndex(6);

    getFacilitiesDivisionModel().add(getFacilitiesDivisionItem6());

  }

  /**
   * I �^����É@�ɓ������ڂ�ǉ����܂��B
   */
  protected void addFacilitiesDivisionItem1(){

  }

  /**
   * II �^����É@�ɓ������ڂ�ǉ����܂��B
   */
  protected void addFacilitiesDivisionItem2(){

  }

  /**
   * ���ʉ���É@�ɓ������ڂ�ǉ����܂��B
   */
  protected void addFacilitiesDivisionItem3(){

  }

  /**
   * ���j�b�g�^I �^����É@�ɓ������ڂ�ǉ����܂��B
   */
  protected void addFacilitiesDivisionItem4(){

  }

  /**
   * ���j�b�g�^II �^����É@�ɓ������ڂ�ǉ����܂��B
   */
  protected void addFacilitiesDivisionItem5(){

  }

  /**
   * ���j�b�g�^���ʉ���É@�ɓ������ڂ�ǉ����܂��B
   */
  protected void addFacilitiesDivisionItem6(){

  }

  /**
   * �l���z�u�敪�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPersonnelDivisionContainer(){

    personnelDivisionContainer.add(getStaffAssignmentDivision1(), VRLayout.FLOW_INSETLINE_RETURN);

    personnelDivisionContainer.add(getStaffAssignmentDivision2(), VRLayout.FLOW_INSETLINE_RETURN);

    personnelDivisionContainer.add(getStaffAssignmentDivision3(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * �l���z�u�敪�P�ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffAssignmentDivision1(){

  }

  /**
   * �l���z�u�敪�P���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffAssignmentDivision1Model(){

    getStaffAssignmentDivision1Item1().setButtonIndex(1);

    getStaffAssignmentDivision1Model().add(getStaffAssignmentDivision1Item1());

    getStaffAssignmentDivision1Item2().setButtonIndex(2);

    getStaffAssignmentDivision1Model().add(getStaffAssignmentDivision1Item2());

    getStaffAssignmentDivision1Item3().setButtonIndex(3);

    getStaffAssignmentDivision1Model().add(getStaffAssignmentDivision1Item3());

  }

  /**
   * I �^�iI�j�ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffAssignmentDivision1Item1(){

  }

  /**
   * I �^�iII�j�ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffAssignmentDivision1Item2(){

  }

  /**
   * I �^�iIII�j�ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffAssignmentDivision1Item3(){

  }

  /**
   * �l���z�u�敪�Q�ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffAssignmentDivision2(){

  }

  /**
   * �l���z�u�敪�Q���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffAssignmentDivision2Model(){

    getStaffAssignmentDivision2Item1().setButtonIndex(1);

    getStaffAssignmentDivision2Model().add(getStaffAssignmentDivision2Item1());

    getStaffAssignmentDivision2Item2().setButtonIndex(2);

    getStaffAssignmentDivision2Model().add(getStaffAssignmentDivision2Item2());

    getStaffAssignmentDivision2Item3().setButtonIndex(3);

    getStaffAssignmentDivision2Model().add(getStaffAssignmentDivision2Item3());

  }

  /**
   * II �^�iI�j�ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffAssignmentDivision2Item1(){

  }

  /**
   * II �^�iII�j�ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffAssignmentDivision2Item2(){

  }

  /**
   * II �^�iIII�j�ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffAssignmentDivision2Item3(){

  }

  /**
   * �l���z�u�敪�R�ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffAssignmentDivision3(){

  }

  /**
   * �l���z�u�敪�R���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffAssignmentDivision3Model(){

    getStaffAssignmentDivision3Item1().setButtonIndex(1);

    getStaffAssignmentDivision3Model().add(getStaffAssignmentDivision3Item1());

    getStaffAssignmentDivision3Item2().setButtonIndex(2);

    getStaffAssignmentDivision3Model().add(getStaffAssignmentDivision3Item2());

  }

  /**
   * I �^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffAssignmentDivision3Item1(){

  }

  /**
   * II �^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffAssignmentDivision3Item2(){

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

    getNightWorkDivisionItem4().setButtonIndex(7);

    getNightWorkDivisionModel().add(getNightWorkDivisionItem4());

    getNightWorkDivisionItem5().setButtonIndex(5);

    getNightWorkDivisionModel().add(getNightWorkDivisionItem5());

    getNightWorkDivisionItem6().setButtonIndex(6);

    getNightWorkDivisionModel().add(getNightWorkDivisionItem6());

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
  protected void addNightWorkDivisionItem5(){

  }

  /**
   * ���Z�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addNightWorkDivisionItem6(){

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
   * ��܎t�ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffLackItem3(){

  }

  /**
   * �Ō�E���ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffLackItem4(){

  }

  /**
   * ���E���ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffLackItem5(){

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
   * �×{����i�L���j�ɓ������ڂ�ǉ����܂��B
   */
  protected void addRecuperationEnvironmental1(){

  }

  /**
   * �×{����i�L���j���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addRecuperationEnvironmental1Model(){

    getRecuperationEnvironmental1Item1().setButtonIndex(1);

    getRecuperationEnvironmental1Model().add(getRecuperationEnvironmental1Item1());

    getRecuperationEnvironmental1Item2().setButtonIndex(2);

    getRecuperationEnvironmental1Model().add(getRecuperationEnvironmental1Item2());

  }

  /**
   * ��^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addRecuperationEnvironmental1Item1(){

  }

  /**
   * ���Z�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addRecuperationEnvironmental1Item2(){

  }

  /**
   * �×{����i�×{���j�ɓ������ڂ�ǉ����܂��B
   */
  protected void addRecuperationEnvironmental2(){

  }

  /**
   * �×{����i�×{���j���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addRecuperationEnvironmental2Model(){

    getRecuperationEnvironmental2Item1().setButtonIndex(1);

    getRecuperationEnvironmental2Model().add(getRecuperationEnvironmental2Item1());

    getRecuperationEnvironmental2Item2().setButtonIndex(2);

    getRecuperationEnvironmental2Model().add(getRecuperationEnvironmental2Item2());

  }

  /**
   * ��^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addRecuperationEnvironmental2Item1(){

  }

  /**
   * ���Z�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addRecuperationEnvironmental2Item2(){

  }

  /**
   * �^�u2�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTab2(){

    tab2.add(getPanel2(), VRLayout.NORTH);

  }

  /**
   * �Z�荀�ڗ̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPanel2(){

    panel2.add(getYoungDementiaPatinetAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    panel2.add(getMeetingAndSendingOffSystemContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    panel2.add(getMedicalFoodAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    panel2.add(getDementiaCareRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    panel2.add(getSpecialClinicDetailsContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    panel2.add(getRehabilitationDetailsContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    panel2.add(getServiceAddProvisionStructuralRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    panel2.add(getStaffUpgradeRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

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
   * ���}�̐��ɓ������ڂ�ǉ����܂��B
   */
  protected void addMeetingAndSendingOffSystem(){

  }

  /**
   * ���}�̐����f���ɓ������ڂ�ǉ����܂��B
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
   * �F�m�ǐ��P�A���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addDementiaCareRadioGroup(){

  }

  /**
   * �F�m�ǐ��P�A���Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addDementiaCareRadioGroupModel(){

    getDementiaCareRadioItem1().setButtonIndex(1);

    getDementiaCareRadioGroupModel().add(getDementiaCareRadioItem1());

    getDementiaCareRadioItem2().setButtonIndex(2);

    getDementiaCareRadioGroupModel().add(getDementiaCareRadioItem2());

    getDementiaCareRadioItem3().setButtonIndex(3);

    getDementiaCareRadioGroupModel().add(getDementiaCareRadioItem3());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addDementiaCareRadioItem1(){

  }

  /**
   * ���ZI�ɓ������ڂ�ǉ����܂��B
   */
  protected void addDementiaCareRadioItem2(){

  }

  /**
   * ���ZII�ɓ������ڂ�ǉ����܂��B
   */
  protected void addDementiaCareRadioItem3(){

  }

  /**
   * ���ʐf�Ô�ڃR���e�i�ɓ������ڂ�ǉ����܂��B
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

    getStaffUpgradeRadioItem2().setButtonIndex(6);

    getStaffUpgradeRadioGroupModel().add(getStaffUpgradeRadioItem2());

    getStaffUpgradeRadioItem3().setButtonIndex(5);

    getStaffUpgradeRadioGroupModel().add(getStaffUpgradeRadioItem3());

    getStaffUpgradeRadioItem4().setButtonIndex(2);

    getStaffUpgradeRadioGroupModel().add(getStaffUpgradeRadioItem4());

    getStaffUpgradeRadioItem5().setButtonIndex(3);

    getStaffUpgradeRadioGroupModel().add(getStaffUpgradeRadioItem5());

    getStaffUpgradeRadioItem6().setButtonIndex(4);

    getStaffUpgradeRadioGroupModel().add(getStaffUpgradeRadioItem6());

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
   * ���ZV�ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffUpgradeRadioItem6(){

  }

  /**
   * �^�u3�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTab3(){

    tab3.add(getStandardMoneyGroup(), VRLayout.NORTH);

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

    unitRoomContainer.add(getUnitRoom(), VRLayout.FLOW);

    unitRoomContainer.add(getUnitRoomLabel(), VRLayout.FLOW);

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
   * ���j�b�g�^���I��������z�E�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addUnitSemiRoomContainer(){

    unitSemiRoomContainer.add(getUnitSemiRoom(), VRLayout.FLOW);

    unitSemiRoomContainer.add(getUnitSemiRoomLabel(), VRLayout.FLOW);

  }

  /**
   * ���j�b�g�^���I��������z�E�e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addUnitSemiRoom(){

  }

  /**
   * ���j�b�g�^���I��������z�E���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addUnitSemiRoomLabel(){

  }

  /**
   * �]���^����z�E�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addNormalRoomContainer(){

    normalRoomContainer.add(getNormalRoom(), VRLayout.FLOW);

    normalRoomContainer.add(getNormalRoomLabel(), VRLayout.FLOW);

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

    tasyouRoomContainer.add(getTasyouRoom(), VRLayout.FLOW);

    tasyouRoomContainer.add(getTasyouRoomLabel(), VRLayout.FLOW);

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
      ACFrame.debugStart(new ACAffairInfo(QO004_204311_201804Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QO004_204311_201804Design getThis() {
    return this;
  }
}
