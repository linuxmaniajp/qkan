
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
 * �쐬��: 2018/02/08  ���{�R���s���[�^�[������� �����@���̂� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���̑��@�\ (O)
 * �v���Z�X ���Ǝғo�^ (004)
 * �v���O���� ���Ǝғo�^(�Z�������������) (QO004_12111_201804)
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
 * ���Ǝғo�^(�Z�������������)��ʍ��ڃf�U�C��(QO004_12111_201804) 
 */
public class QO004_12111_201804Design extends QO004ProviderPanel {
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

  private ACValueArrayRadioButtonGroup nightWorkDivision;

  private ACLabelContainer nightWorkDivisionContainer;

  private ACListModelAdapter nightWorkDivisionModel;

  private ACRadioButtonItem nightWorkDivisionItem1;

  private ACRadioButtonItem nightWorkDivisionItem2;

  private ACValueArrayRadioButtonGroup staffLack;

  private ACLabelContainer staffLackContainer;

  private ACListModelAdapter staffLackModel;

  private ACRadioButtonItem staffLackItem1;

  private ACRadioButtonItem staffLackItem2;

  private ACRadioButtonItem staffLackItem3;

  private ACValueArrayRadioButtonGroup unitCareMaintenance;

  private ACLabelContainer unitCareMaintenanceContainer;

  private ACListModelAdapter unitCareMaintenanceModel;

  private ACRadioButtonItem unitCareMaintenanceItem1;

  private ACRadioButtonItem unitCareMaintenanceItem2;

  private ACValueArrayRadioButtonGroup kyoseiServiceTankiRadioGroup;

  private ACLabelContainer kyoseiServiceTankiRadioGroupContainer;

  private ACListModelAdapter kyoseiServiceTankiRadioGroupModel;

  private ACRadioButtonItem kyoseiServiceTankiItem1;

  private ACRadioButtonItem kyoseiServiceTankiItem2;

  private ACValueArrayRadioButtonGroup seikatsuSoudanGroup;

  private ACLabelContainer seikatsuSoudanGroupContainer;

  private ACListModelAdapter seikatsuSoudanGroupModel;

  private ACRadioButtonItem seikatsuSoudanGroupItem1;

  private ACRadioButtonItem seikatsuSoudanGroupItem2;

  private ACValueArrayRadioButtonGroup seikatsuKinouGroup;

  private ACLabelContainer seikatsuKinouGroupContainer;

  private ACListModelAdapter seikatsuKinouGroupModel;

  private ACRadioButtonItem seikatsuKinouGroupItem1;

  private ACRadioButtonItem seikatsuKinouGroupItem2;

  private ACValueArrayRadioButtonGroup functionTrainingGuidanceSystem;

  private ACLabelContainer functionTrainingGuidanceSystemContainer;

  private ACListModelAdapter functionTrainingGuidanceSystemModel;

  private ACRadioButtonItem functionTrainingGuidanceSystemItem1;

  private ACRadioButtonItem functionTrainingGuidanceSystemItem2;

  private ACValueArrayRadioButtonGroup individualfunctionTrainingSystem;

  private ACLabelContainer individualfunctionTrainingSystemContainer;

  private ACListModelAdapter individualfunctionTrainingSystemModel;

  private ACRadioButtonItem individualfunctionTrainingSystemItem1;

  private ACRadioButtonItem individualfunctionTrainingSystemItem2;

  private ACValueArrayRadioButtonGroup nurseStructuralAddRadioGroup;

  private ACLabelContainer nurseStructuralAddRadioGroupContainer;

  private ACListModelAdapter nurseStructuralAddRadioGroupModel;

  private ACRadioButtonItem nurseStructuralAddRadioItem1;

  private ACRadioButtonItem nurseStructuralAddRadioItem2;

  private ACRadioButtonItem nurseStructuralAddRadioItem3;

  private ACValueArrayRadioButtonGroup nurseStructuralAdd2RadioGroup;

  private ACLabelContainer nurseStructuralAdd2RadioGroupContainer;

  private ACListModelAdapter nurseStructuralAdd2RadioGroupModel;

  private ACRadioButtonItem nurseStructuralAdd2RadioItem1;

  private ACRadioButtonItem nurseStructuralAdd2RadioItem2;

  private ACRadioButtonItem nurseStructuralAdd2RadioItem3;

  private ACValueArrayRadioButtonGroup medicalStrengthenCooperation;

  private ACLabelContainer medicalStrengthenCooperationContainer;

  private ACListModelAdapter medicalStrengthenCooperationModel;

  private ACRadioButtonItem medicalStrengthenCooperationItem1;

  private ACRadioButtonItem medicalStrengthenCooperationItem2;

  private ACValueArrayRadioButtonGroup nightStaffDispositionAddRadioGroup;

  private ACLabelContainer nightStaffDispositionAddRadioGroupContainer;

  private ACListModelAdapter nightStaffDispositionAddRadioGroupModel;

  private ACRadioButtonItem nightStaffDispositionAddRadioItem1;

  private ACRadioButtonItem nightStaffDispositionAddRadioItem2;

  private ACRadioButtonItem nightStaffDispositionAddRadioItem3;

  private ACValueArrayRadioButtonGroup kaigoRobotRadioGroup;

  private ACLabelContainer kaigoRobotRadioGroupContainer;

  private ACListModelAdapter kaigoRobotRadioGroupModel;

  private ACRadioButtonItem kaigoRobotRadioItem1;

  private ACRadioButtonItem kaigoRobotRadioItem2;

  private ACValueArrayRadioButtonGroup youngDementiaPatinetAddRadioGroup;

  private ACLabelContainer youngDementiaPatinetAddRadioGroupContainer;

  private ACListModelAdapter youngDementiaPatinetAddRadioGroupModel;

  private ACRadioButtonItem youngDementiaPatinetAddRadioItem1;

  private ACRadioButtonItem youngDementiaPatinetAddRadioItem2;

  private ACPanel panel2;

  private ACPanel calculationDetails2;

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

  private ACValueArrayRadioButtonGroup serviceAddProvisionStructuralRadioGroup;

  private ACLabelContainer serviceAddProvisionStructuralRadioGroupContainer;

  private ACListModelAdapter serviceAddProvisionStructuralRadioGroupModel;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem1;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem2;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem3;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem4;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem5;

  private ACValueArrayRadioButtonGroup serviceAddProvisionStructuralKusyoRadioGroup;

  private ACLabelContainer serviceAddProvisionStructuralKusyoRadioGroupContainer;

  private ACListModelAdapter serviceAddProvisionStructuralKusyoRadioGroupModel;

  private ACRadioButtonItem serviceAddProvisionStructuralKusyoRadioItem1;

  private ACRadioButtonItem serviceAddProvisionStructuralKusyoRadioItem2;

  private ACRadioButtonItem serviceAddProvisionStructuralKusyoRadioItem3;

  private ACRadioButtonItem serviceAddProvisionStructuralKusyoRadioItem4;

  private ACRadioButtonItem serviceAddProvisionStructuralKusyoRadioItem5;

  private ACValueArrayRadioButtonGroup staffUpgradeRadioGroup;

  private ACLabelContainer staffUpgradeRadioGroupContainer;

  private ACListModelAdapter staffUpgradeRadioGroupModel;

  private ACRadioButtonItem staffUpgradeRadioItem1;

  private ACRadioButtonItem staffUpgradeRadioItem2;

  private ACRadioButtonItem staffUpgradeRadioItem3;

  private ACRadioButtonItem staffUpgradeRadioItem4;

  private ACRadioButtonItem staffUpgradeRadioItem5;

  private ACRadioButtonItem staffUpgradeRadioItem6;

  private ACLabelContainer reduceRateContainer;

  private ACTextField reduceRate;

  private ACLabel percentSign;

  private ACIntegerCheckBox ShahukuReduce;

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

      mainGroup.setText("�Z�������������");

      mainGroup.setFollowChildEnabled(true);

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
   * �p�l���P���擾���܂��B
   * @return �p�l���P
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

      facilitiesDivision.setBindPath("1210101");

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
   * �P�ƌ^���擾���܂��B
   * @return �P�ƌ^
   */
  public ACRadioButtonItem getFacilitiesDivisionItem1(){
    if(facilitiesDivisionItem1==null){

      facilitiesDivisionItem1 = new ACRadioButtonItem();

      facilitiesDivisionItem1.setText("�P�ƌ^");

      facilitiesDivisionItem1.setGroup(getFacilitiesDivision());

      facilitiesDivisionItem1.setConstraints(VRLayout.FLOW);

      addFacilitiesDivisionItem1();
    }
    return facilitiesDivisionItem1;

  }

  /**
   * ���݌^�E�󏰌^���擾���܂��B
   * @return ���݌^�E�󏰌^
   */
  public ACRadioButtonItem getFacilitiesDivisionItem2(){
    if(facilitiesDivisionItem2==null){

      facilitiesDivisionItem2 = new ACRadioButtonItem();

      facilitiesDivisionItem2.setText("���݌^�E�󏰌^");

      facilitiesDivisionItem2.setGroup(getFacilitiesDivision());

      facilitiesDivisionItem2.setConstraints(VRLayout.FLOW_RETURN);

      addFacilitiesDivisionItem2();
    }
    return facilitiesDivisionItem2;

  }

  /**
   * �P�ƌ^���j�b�g�^���擾���܂��B
   * @return �P�ƌ^���j�b�g�^
   */
  public ACRadioButtonItem getFacilitiesDivisionItem3(){
    if(facilitiesDivisionItem3==null){

      facilitiesDivisionItem3 = new ACRadioButtonItem();

      facilitiesDivisionItem3.setText("�P�ƌ^���j�b�g�^");

      facilitiesDivisionItem3.setGroup(getFacilitiesDivision());

      facilitiesDivisionItem3.setConstraints(VRLayout.FLOW);

      addFacilitiesDivisionItem3();
    }
    return facilitiesDivisionItem3;

  }

  /**
   * ���݌^�E�󏰌^���j�b�g�^���擾���܂��B
   * @return ���݌^�E�󏰌^���j�b�g�^
   */
  public ACRadioButtonItem getFacilitiesDivisionItem4(){
    if(facilitiesDivisionItem4==null){

      facilitiesDivisionItem4 = new ACRadioButtonItem();

      facilitiesDivisionItem4.setText("���݌^�E�󏰌^���j�b�g�^");

      facilitiesDivisionItem4.setGroup(getFacilitiesDivision());

      facilitiesDivisionItem4.setConstraints(VRLayout.FLOW);

      addFacilitiesDivisionItem4();
    }
    return facilitiesDivisionItem4;

  }

  /**
   * ��ԋΖ���������W�I�O���[�v���擾���܂��B
   * @return ��ԋΖ���������W�I�O���[�v
   */
  public ACValueArrayRadioButtonGroup getNightWorkDivision(){
    if(nightWorkDivision==null){

      nightWorkDivision = new ACValueArrayRadioButtonGroup();

      getNightWorkDivisionContainer().setText("��ԋΖ������");

      nightWorkDivision.setBindPath("1210102");

      nightWorkDivision.setUseClearButton(false);

      nightWorkDivision.setModel(getNightWorkDivisionModel());

      nightWorkDivision.setValues(new int[]{1,2});

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
   * �E���̌����ɂ�錸�Z�̏󋵃��W�I�O���[�v���擾���܂��B
   * @return �E���̌����ɂ�錸�Z�̏󋵃��W�I�O���[�v
   */
  public ACValueArrayRadioButtonGroup getStaffLack(){
    if(staffLack==null){

      staffLack = new ACValueArrayRadioButtonGroup();

      getStaffLackContainer().setText("�E���̌����ɂ�錸�Z�̏�");

      staffLack.setBindPath("1210107");

      staffLack.setUseClearButton(false);

      staffLack.setModel(getStaffLackModel());

      staffLack.setValues(new int[]{1,2,3});

      addStaffLack();
    }
    return staffLack;

  }

  /**
   * �E���̌����ɂ�錸�Z�̏󋵃��W�I�O���[�v�R���e�i���擾���܂��B
   * @return �E���̌����ɂ�錸�Z�̏󋵃��W�I�O���[�v�R���e�i
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
   * �E���̌����ɂ�錸�Z�̏󋵃��W�I�O���[�v���f�����擾���܂��B
   * @return �E���̌����ɂ�錸�Z�̏󋵃��W�I�O���[�v���f��
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

      addStaffLackItem1();
    }
    return staffLackItem1;

  }

  /**
   * �Ō�E�����擾���܂��B
   * @return �Ō�E��
   */
  public ACRadioButtonItem getStaffLackItem2(){
    if(staffLackItem2==null){

      staffLackItem2 = new ACRadioButtonItem();

      staffLackItem2.setText("�Ō�E��");

      staffLackItem2.setGroup(getStaffLack());

      addStaffLackItem2();
    }
    return staffLackItem2;

  }

  /**
   * ���E�����擾���܂��B
   * @return ���E��
   */
  public ACRadioButtonItem getStaffLackItem3(){
    if(staffLackItem3==null){

      staffLackItem3 = new ACRadioButtonItem();

      staffLackItem3.setText("���E��");

      staffLackItem3.setGroup(getStaffLack());

      addStaffLackItem3();
    }
    return staffLackItem3;

  }

  /**
   * ���j�b�g�P�A�̐����擾���܂��B
   * @return ���j�b�g�P�A�̐�
   */
  public ACValueArrayRadioButtonGroup getUnitCareMaintenance(){
    if(unitCareMaintenance==null){

      unitCareMaintenance = new ACValueArrayRadioButtonGroup();

      getUnitCareMaintenanceContainer().setText("���j�b�g�P�A�̐�");

      unitCareMaintenance.setBindPath("1210116");

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
   * �����^�T�[�r�X�̒� �i�Z���������Ə��j ���擾���܂��B
   * @return �����^�T�[�r�X�̒� �i�Z���������Ə��j 
   */
  public ACValueArrayRadioButtonGroup getKyoseiServiceTankiRadioGroup(){
    if(kyoseiServiceTankiRadioGroup==null){

      kyoseiServiceTankiRadioGroup = new ACValueArrayRadioButtonGroup();

      getKyoseiServiceTankiRadioGroupContainer().setText("<html>�����^�T�[�r�X�̒�<br> �i�Z���������Ə��j</html> ");

      kyoseiServiceTankiRadioGroup.setBindPath("1210130");

      kyoseiServiceTankiRadioGroup.setUseClearButton(false);

      kyoseiServiceTankiRadioGroup.setModel(getKyoseiServiceTankiRadioGroupModel());

      kyoseiServiceTankiRadioGroup.setValues(new int[]{1,2});

      addKyoseiServiceTankiRadioGroup();
    }
    return kyoseiServiceTankiRadioGroup;

  }

  /**
   * �����^�T�[�r�X�̒� �i�Z���������Ə��j �R���e�i���擾���܂��B
   * @return �����^�T�[�r�X�̒� �i�Z���������Ə��j �R���e�i
   */
  protected ACLabelContainer getKyoseiServiceTankiRadioGroupContainer(){
    if(kyoseiServiceTankiRadioGroupContainer==null){
      kyoseiServiceTankiRadioGroupContainer = new ACLabelContainer();
      kyoseiServiceTankiRadioGroupContainer.setFollowChildEnabled(true);
      kyoseiServiceTankiRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      kyoseiServiceTankiRadioGroupContainer.add(getKyoseiServiceTankiRadioGroup(), null);
    }
    return kyoseiServiceTankiRadioGroupContainer;
  }

  /**
   * �����^�T�[�r�X�̒� �i�Z���������Ə��j ���f�����擾���܂��B
   * @return �����^�T�[�r�X�̒� �i�Z���������Ə��j ���f��
   */
  protected ACListModelAdapter getKyoseiServiceTankiRadioGroupModel(){
    if(kyoseiServiceTankiRadioGroupModel==null){
      kyoseiServiceTankiRadioGroupModel = new ACListModelAdapter();
      addKyoseiServiceTankiRadioGroupModel();
    }
    return kyoseiServiceTankiRadioGroupModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getKyoseiServiceTankiItem1(){
    if(kyoseiServiceTankiItem1==null){

      kyoseiServiceTankiItem1 = new ACRadioButtonItem();

      kyoseiServiceTankiItem1.setText("�Ȃ�");

      kyoseiServiceTankiItem1.setGroup(getKyoseiServiceTankiRadioGroup());

      addKyoseiServiceTankiItem1();
    }
    return kyoseiServiceTankiItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getKyoseiServiceTankiItem2(){
    if(kyoseiServiceTankiItem2==null){

      kyoseiServiceTankiItem2 = new ACRadioButtonItem();

      kyoseiServiceTankiItem2.setText("����");

      kyoseiServiceTankiItem2.setGroup(getKyoseiServiceTankiRadioGroup());

      addKyoseiServiceTankiItem2();
    }
    return kyoseiServiceTankiItem2;

  }

  /**
   * �������k���z�u�����Z���擾���܂��B
   * @return �������k���z�u�����Z
   */
  public ACValueArrayRadioButtonGroup getSeikatsuSoudanGroup(){
    if(seikatsuSoudanGroup==null){

      seikatsuSoudanGroup = new ACValueArrayRadioButtonGroup();

      getSeikatsuSoudanGroupContainer().setText("�������k���z�u�����Z");

      seikatsuSoudanGroup.setBindPath("1210131");

      seikatsuSoudanGroup.setNoSelectIndex(0);

      seikatsuSoudanGroup.setUseClearButton(false);

      seikatsuSoudanGroup.setModel(getSeikatsuSoudanGroupModel());

      seikatsuSoudanGroup.setValues(new int[]{1,2});

      addSeikatsuSoudanGroup();
    }
    return seikatsuSoudanGroup;

  }

  /**
   * �������k���z�u�����Z�R���e�i���擾���܂��B
   * @return �������k���z�u�����Z�R���e�i
   */
  protected ACLabelContainer getSeikatsuSoudanGroupContainer(){
    if(seikatsuSoudanGroupContainer==null){
      seikatsuSoudanGroupContainer = new ACLabelContainer();
      seikatsuSoudanGroupContainer.setFollowChildEnabled(true);
      seikatsuSoudanGroupContainer.setVAlignment(VRLayout.CENTER);
      seikatsuSoudanGroupContainer.add(getSeikatsuSoudanGroup(), null);
    }
    return seikatsuSoudanGroupContainer;
  }

  /**
   * �������k���z�u�����Z���f�����擾���܂��B
   * @return �������k���z�u�����Z���f��
   */
  protected ACListModelAdapter getSeikatsuSoudanGroupModel(){
    if(seikatsuSoudanGroupModel==null){
      seikatsuSoudanGroupModel = new ACListModelAdapter();
      addSeikatsuSoudanGroupModel();
    }
    return seikatsuSoudanGroupModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getSeikatsuSoudanGroupItem1(){
    if(seikatsuSoudanGroupItem1==null){

      seikatsuSoudanGroupItem1 = new ACRadioButtonItem();

      seikatsuSoudanGroupItem1.setText("�Ȃ�");

      seikatsuSoudanGroupItem1.setGroup(getSeikatsuSoudanGroup());

      seikatsuSoudanGroupItem1.setConstraints(VRLayout.FLOW);

      addSeikatsuSoudanGroupItem1();
    }
    return seikatsuSoudanGroupItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getSeikatsuSoudanGroupItem2(){
    if(seikatsuSoudanGroupItem2==null){

      seikatsuSoudanGroupItem2 = new ACRadioButtonItem();

      seikatsuSoudanGroupItem2.setText("����");

      seikatsuSoudanGroupItem2.setGroup(getSeikatsuSoudanGroup());

      seikatsuSoudanGroupItem2.setConstraints(VRLayout.FLOW);

      addSeikatsuSoudanGroupItem2();
    }
    return seikatsuSoudanGroupItem2;

  }

  /**
   * �����@�\����A�g���Z���擾���܂��B
   * @return �����@�\����A�g���Z
   */
  public ACValueArrayRadioButtonGroup getSeikatsuKinouGroup(){
    if(seikatsuKinouGroup==null){

      seikatsuKinouGroup = new ACValueArrayRadioButtonGroup();

      getSeikatsuKinouGroupContainer().setText("�����@�\����A�g���Z");

      seikatsuKinouGroup.setBindPath("1210132");

      seikatsuKinouGroup.setNoSelectIndex(0);

      seikatsuKinouGroup.setUseClearButton(false);

      seikatsuKinouGroup.setModel(getSeikatsuKinouGroupModel());

      seikatsuKinouGroup.setValues(new int[]{1,2});

      addSeikatsuKinouGroup();
    }
    return seikatsuKinouGroup;

  }

  /**
   * �����@�\����A�g���Z�R���e�i���擾���܂��B
   * @return �����@�\����A�g���Z�R���e�i
   */
  protected ACLabelContainer getSeikatsuKinouGroupContainer(){
    if(seikatsuKinouGroupContainer==null){
      seikatsuKinouGroupContainer = new ACLabelContainer();
      seikatsuKinouGroupContainer.setFollowChildEnabled(true);
      seikatsuKinouGroupContainer.setVAlignment(VRLayout.CENTER);
      seikatsuKinouGroupContainer.add(getSeikatsuKinouGroup(), null);
    }
    return seikatsuKinouGroupContainer;
  }

  /**
   * �����@�\����A�g���Z���f�����擾���܂��B
   * @return �����@�\����A�g���Z���f��
   */
  protected ACListModelAdapter getSeikatsuKinouGroupModel(){
    if(seikatsuKinouGroupModel==null){
      seikatsuKinouGroupModel = new ACListModelAdapter();
      addSeikatsuKinouGroupModel();
    }
    return seikatsuKinouGroupModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getSeikatsuKinouGroupItem1(){
    if(seikatsuKinouGroupItem1==null){

      seikatsuKinouGroupItem1 = new ACRadioButtonItem();

      seikatsuKinouGroupItem1.setText("�Ȃ�");

      seikatsuKinouGroupItem1.setGroup(getSeikatsuKinouGroup());

      seikatsuKinouGroupItem1.setConstraints(VRLayout.FLOW);

      addSeikatsuKinouGroupItem1();
    }
    return seikatsuKinouGroupItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getSeikatsuKinouGroupItem2(){
    if(seikatsuKinouGroupItem2==null){

      seikatsuKinouGroupItem2 = new ACRadioButtonItem();

      seikatsuKinouGroupItem2.setText("����");

      seikatsuKinouGroupItem2.setGroup(getSeikatsuKinouGroup());

      seikatsuKinouGroupItem2.setConstraints(VRLayout.FLOW);

      addSeikatsuKinouGroupItem2();
    }
    return seikatsuKinouGroupItem2;

  }

  /**
   * �@�\�P���w���̐����W�I�O���[�v���擾���܂��B
   * @return �@�\�P���w���̐����W�I�O���[�v
   */
  public ACValueArrayRadioButtonGroup getFunctionTrainingGuidanceSystem(){
    if(functionTrainingGuidanceSystem==null){

      functionTrainingGuidanceSystem = new ACValueArrayRadioButtonGroup();

      getFunctionTrainingGuidanceSystemContainer().setText("�@�\�P���w���̐�");

      functionTrainingGuidanceSystem.setBindPath("1210103");

      functionTrainingGuidanceSystem.setUseClearButton(false);

      functionTrainingGuidanceSystem.setModel(getFunctionTrainingGuidanceSystemModel());

      functionTrainingGuidanceSystem.setValues(new int[]{1,2});

      addFunctionTrainingGuidanceSystem();
    }
    return functionTrainingGuidanceSystem;

  }

  /**
   * �@�\�P���w���̐����W�I�O���[�v�R���e�i���擾���܂��B
   * @return �@�\�P���w���̐����W�I�O���[�v�R���e�i
   */
  protected ACLabelContainer getFunctionTrainingGuidanceSystemContainer(){
    if(functionTrainingGuidanceSystemContainer==null){
      functionTrainingGuidanceSystemContainer = new ACLabelContainer();
      functionTrainingGuidanceSystemContainer.setFollowChildEnabled(true);
      functionTrainingGuidanceSystemContainer.setVAlignment(VRLayout.CENTER);
      functionTrainingGuidanceSystemContainer.add(getFunctionTrainingGuidanceSystem(), null);
    }
    return functionTrainingGuidanceSystemContainer;
  }

  /**
   * �@�\�P���w���̐����W�I�O���[�v���f�����擾���܂��B
   * @return �@�\�P���w���̐����W�I�O���[�v���f��
   */
  protected ACListModelAdapter getFunctionTrainingGuidanceSystemModel(){
    if(functionTrainingGuidanceSystemModel==null){
      functionTrainingGuidanceSystemModel = new ACListModelAdapter();
      addFunctionTrainingGuidanceSystemModel();
    }
    return functionTrainingGuidanceSystemModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getFunctionTrainingGuidanceSystemItem1(){
    if(functionTrainingGuidanceSystemItem1==null){

      functionTrainingGuidanceSystemItem1 = new ACRadioButtonItem();

      functionTrainingGuidanceSystemItem1.setText("�Ȃ�");

      functionTrainingGuidanceSystemItem1.setGroup(getFunctionTrainingGuidanceSystem());

      addFunctionTrainingGuidanceSystemItem1();
    }
    return functionTrainingGuidanceSystemItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getFunctionTrainingGuidanceSystemItem2(){
    if(functionTrainingGuidanceSystemItem2==null){

      functionTrainingGuidanceSystemItem2 = new ACRadioButtonItem();

      functionTrainingGuidanceSystemItem2.setText("����");

      functionTrainingGuidanceSystemItem2.setGroup(getFunctionTrainingGuidanceSystem());

      addFunctionTrainingGuidanceSystemItem2();
    }
    return functionTrainingGuidanceSystemItem2;

  }

  /**
   * �ʋ@�\�P���̐����W�I�O���[�v���擾���܂��B
   * @return �ʋ@�\�P���̐����W�I�O���[�v
   */
  public ACValueArrayRadioButtonGroup getIndividualfunctionTrainingSystem(){
    if(individualfunctionTrainingSystem==null){

      individualfunctionTrainingSystem = new ACValueArrayRadioButtonGroup();

      getIndividualfunctionTrainingSystemContainer().setText("�ʋ@�\�P���̐�");

      individualfunctionTrainingSystem.setBindPath("1210128");

      individualfunctionTrainingSystem.setNoSelectIndex(0);

      individualfunctionTrainingSystem.setUseClearButton(false);

      individualfunctionTrainingSystem.setModel(getIndividualfunctionTrainingSystemModel());

      individualfunctionTrainingSystem.setValues(new int[]{1,2});

      addIndividualfunctionTrainingSystem();
    }
    return individualfunctionTrainingSystem;

  }

  /**
   * �ʋ@�\�P���̐����W�I�O���[�v�R���e�i���擾���܂��B
   * @return �ʋ@�\�P���̐����W�I�O���[�v�R���e�i
   */
  protected ACLabelContainer getIndividualfunctionTrainingSystemContainer(){
    if(individualfunctionTrainingSystemContainer==null){
      individualfunctionTrainingSystemContainer = new ACLabelContainer();
      individualfunctionTrainingSystemContainer.setFollowChildEnabled(true);
      individualfunctionTrainingSystemContainer.setVAlignment(VRLayout.CENTER);
      individualfunctionTrainingSystemContainer.add(getIndividualfunctionTrainingSystem(), null);
    }
    return individualfunctionTrainingSystemContainer;
  }

  /**
   * �ʋ@�\�P���̐����W�I�O���[�v���f�����擾���܂��B
   * @return �ʋ@�\�P���̐����W�I�O���[�v���f��
   */
  protected ACListModelAdapter getIndividualfunctionTrainingSystemModel(){
    if(individualfunctionTrainingSystemModel==null){
      individualfunctionTrainingSystemModel = new ACListModelAdapter();
      addIndividualfunctionTrainingSystemModel();
    }
    return individualfunctionTrainingSystemModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getIndividualfunctionTrainingSystemItem1(){
    if(individualfunctionTrainingSystemItem1==null){

      individualfunctionTrainingSystemItem1 = new ACRadioButtonItem();

      individualfunctionTrainingSystemItem1.setText("�Ȃ�");

      individualfunctionTrainingSystemItem1.setGroup(getIndividualfunctionTrainingSystem());

      individualfunctionTrainingSystemItem1.setConstraints(VRLayout.FLOW);

      addIndividualfunctionTrainingSystemItem1();
    }
    return individualfunctionTrainingSystemItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getIndividualfunctionTrainingSystemItem2(){
    if(individualfunctionTrainingSystemItem2==null){

      individualfunctionTrainingSystemItem2 = new ACRadioButtonItem();

      individualfunctionTrainingSystemItem2.setText("����");

      individualfunctionTrainingSystemItem2.setGroup(getIndividualfunctionTrainingSystem());

      individualfunctionTrainingSystemItem2.setConstraints(VRLayout.FLOW);

      addIndividualfunctionTrainingSystemItem2();
    }
    return individualfunctionTrainingSystemItem2;

  }

  /**
   * �Ō�̐����Z I����III���擾���܂��B
   * @return �Ō�̐����Z I����III
   */
  public ACValueArrayRadioButtonGroup getNurseStructuralAddRadioGroup(){
    if(nurseStructuralAddRadioGroup==null){

      nurseStructuralAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getNurseStructuralAddRadioGroupContainer().setText("�Ō�̐����Z I����III");

      nurseStructuralAddRadioGroup.setBindPath("1210120");

      nurseStructuralAddRadioGroup.setNoSelectIndex(0);

      nurseStructuralAddRadioGroup.setUseClearButton(false);

      nurseStructuralAddRadioGroup.setModel(getNurseStructuralAddRadioGroupModel());

      nurseStructuralAddRadioGroup.setValues(new int[]{1,2,3});

      addNurseStructuralAddRadioGroup();
    }
    return nurseStructuralAddRadioGroup;

  }

  /**
   * �Ō�̐����Z I����III�R���e�i���擾���܂��B
   * @return �Ō�̐����Z I����III�R���e�i
   */
  protected ACLabelContainer getNurseStructuralAddRadioGroupContainer(){
    if(nurseStructuralAddRadioGroupContainer==null){
      nurseStructuralAddRadioGroupContainer = new ACLabelContainer();
      nurseStructuralAddRadioGroupContainer.setFollowChildEnabled(true);
      nurseStructuralAddRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      nurseStructuralAddRadioGroupContainer.add(getNurseStructuralAddRadioGroup(), null);
    }
    return nurseStructuralAddRadioGroupContainer;
  }

  /**
   * �Ō�̐����Z I����III���f�����擾���܂��B
   * @return �Ō�̐����Z I����III���f��
   */
  protected ACListModelAdapter getNurseStructuralAddRadioGroupModel(){
    if(nurseStructuralAddRadioGroupModel==null){
      nurseStructuralAddRadioGroupModel = new ACListModelAdapter();
      addNurseStructuralAddRadioGroupModel();
    }
    return nurseStructuralAddRadioGroupModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getNurseStructuralAddRadioItem1(){
    if(nurseStructuralAddRadioItem1==null){

      nurseStructuralAddRadioItem1 = new ACRadioButtonItem();

      nurseStructuralAddRadioItem1.setText("�Ȃ�");

      nurseStructuralAddRadioItem1.setGroup(getNurseStructuralAddRadioGroup());

      nurseStructuralAddRadioItem1.setConstraints(VRLayout.FLOW);

      addNurseStructuralAddRadioItem1();
    }
    return nurseStructuralAddRadioItem1;

  }

  /**
   * ���ZI���擾���܂��B
   * @return ���ZI
   */
  public ACRadioButtonItem getNurseStructuralAddRadioItem2(){
    if(nurseStructuralAddRadioItem2==null){

      nurseStructuralAddRadioItem2 = new ACRadioButtonItem();

      nurseStructuralAddRadioItem2.setText("���ZI");

      nurseStructuralAddRadioItem2.setGroup(getNurseStructuralAddRadioGroup());

      nurseStructuralAddRadioItem2.setConstraints(VRLayout.FLOW);

      addNurseStructuralAddRadioItem2();
    }
    return nurseStructuralAddRadioItem2;

  }

  /**
   * ���ZIII���擾���܂��B
   * @return ���ZIII
   */
  public ACRadioButtonItem getNurseStructuralAddRadioItem3(){
    if(nurseStructuralAddRadioItem3==null){

      nurseStructuralAddRadioItem3 = new ACRadioButtonItem();

      nurseStructuralAddRadioItem3.setText("���ZIII");

      nurseStructuralAddRadioItem3.setGroup(getNurseStructuralAddRadioGroup());

      nurseStructuralAddRadioItem3.setConstraints(VRLayout.FLOW);

      addNurseStructuralAddRadioItem3();
    }
    return nurseStructuralAddRadioItem3;

  }

  /**
   * �Ō�̐����Z II����IV���擾���܂��B
   * @return �Ō�̐����Z II����IV
   */
  public ACValueArrayRadioButtonGroup getNurseStructuralAdd2RadioGroup(){
    if(nurseStructuralAdd2RadioGroup==null){

      nurseStructuralAdd2RadioGroup = new ACValueArrayRadioButtonGroup();

      getNurseStructuralAdd2RadioGroupContainer().setText("�Ō�̐����Z II����IV");

      nurseStructuralAdd2RadioGroup.setBindPath("1210133");

      nurseStructuralAdd2RadioGroup.setNoSelectIndex(0);

      nurseStructuralAdd2RadioGroup.setUseClearButton(false);

      nurseStructuralAdd2RadioGroup.setModel(getNurseStructuralAdd2RadioGroupModel());

      nurseStructuralAdd2RadioGroup.setValues(new int[]{1,2,3});

      addNurseStructuralAdd2RadioGroup();
    }
    return nurseStructuralAdd2RadioGroup;

  }

  /**
   * �Ō�̐����Z II����IV�R���e�i���擾���܂��B
   * @return �Ō�̐����Z II����IV�R���e�i
   */
  protected ACLabelContainer getNurseStructuralAdd2RadioGroupContainer(){
    if(nurseStructuralAdd2RadioGroupContainer==null){
      nurseStructuralAdd2RadioGroupContainer = new ACLabelContainer();
      nurseStructuralAdd2RadioGroupContainer.setFollowChildEnabled(true);
      nurseStructuralAdd2RadioGroupContainer.setVAlignment(VRLayout.CENTER);
      nurseStructuralAdd2RadioGroupContainer.add(getNurseStructuralAdd2RadioGroup(), null);
    }
    return nurseStructuralAdd2RadioGroupContainer;
  }

  /**
   * �Ō�̐����Z II����IV���f�����擾���܂��B
   * @return �Ō�̐����Z II����IV���f��
   */
  protected ACListModelAdapter getNurseStructuralAdd2RadioGroupModel(){
    if(nurseStructuralAdd2RadioGroupModel==null){
      nurseStructuralAdd2RadioGroupModel = new ACListModelAdapter();
      addNurseStructuralAdd2RadioGroupModel();
    }
    return nurseStructuralAdd2RadioGroupModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getNurseStructuralAdd2RadioItem1(){
    if(nurseStructuralAdd2RadioItem1==null){

      nurseStructuralAdd2RadioItem1 = new ACRadioButtonItem();

      nurseStructuralAdd2RadioItem1.setText("�Ȃ�");

      nurseStructuralAdd2RadioItem1.setGroup(getNurseStructuralAdd2RadioGroup());

      nurseStructuralAdd2RadioItem1.setConstraints(VRLayout.FLOW);

      addNurseStructuralAdd2RadioItem1();
    }
    return nurseStructuralAdd2RadioItem1;

  }

  /**
   * ���ZII���擾���܂��B
   * @return ���ZII
   */
  public ACRadioButtonItem getNurseStructuralAdd2RadioItem2(){
    if(nurseStructuralAdd2RadioItem2==null){

      nurseStructuralAdd2RadioItem2 = new ACRadioButtonItem();

      nurseStructuralAdd2RadioItem2.setText("���ZII");

      nurseStructuralAdd2RadioItem2.setGroup(getNurseStructuralAdd2RadioGroup());

      nurseStructuralAdd2RadioItem2.setConstraints(VRLayout.FLOW);

      addNurseStructuralAdd2RadioItem2();
    }
    return nurseStructuralAdd2RadioItem2;

  }

  /**
   * ���ZIV���擾���܂��B
   * @return ���ZIV
   */
  public ACRadioButtonItem getNurseStructuralAdd2RadioItem3(){
    if(nurseStructuralAdd2RadioItem3==null){

      nurseStructuralAdd2RadioItem3 = new ACRadioButtonItem();

      nurseStructuralAdd2RadioItem3.setText("���ZIV");

      nurseStructuralAdd2RadioItem3.setGroup(getNurseStructuralAdd2RadioGroup());

      nurseStructuralAdd2RadioItem3.setConstraints(VRLayout.FLOW);

      addNurseStructuralAdd2RadioItem3();
    }
    return nurseStructuralAdd2RadioItem3;

  }

  /**
   * ��ØA�g�������Z���W�I�O���[�v���擾���܂��B
   * @return ��ØA�g�������Z���W�I�O���[�v
   */
  public ACValueArrayRadioButtonGroup getMedicalStrengthenCooperation(){
    if(medicalStrengthenCooperation==null){

      medicalStrengthenCooperation = new ACValueArrayRadioButtonGroup();

      getMedicalStrengthenCooperationContainer().setText("��ØA�g�������Z");

      medicalStrengthenCooperation.setBindPath("1210129");

      medicalStrengthenCooperation.setNoSelectIndex(0);

      medicalStrengthenCooperation.setUseClearButton(false);

      medicalStrengthenCooperation.setModel(getMedicalStrengthenCooperationModel());

      medicalStrengthenCooperation.setValues(new int[]{1,2});

      addMedicalStrengthenCooperation();
    }
    return medicalStrengthenCooperation;

  }

  /**
   * ��ØA�g�������Z���W�I�O���[�v�R���e�i���擾���܂��B
   * @return ��ØA�g�������Z���W�I�O���[�v�R���e�i
   */
  protected ACLabelContainer getMedicalStrengthenCooperationContainer(){
    if(medicalStrengthenCooperationContainer==null){
      medicalStrengthenCooperationContainer = new ACLabelContainer();
      medicalStrengthenCooperationContainer.setFollowChildEnabled(true);
      medicalStrengthenCooperationContainer.setVAlignment(VRLayout.CENTER);
      medicalStrengthenCooperationContainer.add(getMedicalStrengthenCooperation(), null);
    }
    return medicalStrengthenCooperationContainer;
  }

  /**
   * ��ØA�g�������Z���W�I�O���[�v���f�����擾���܂��B
   * @return ��ØA�g�������Z���W�I�O���[�v���f��
   */
  protected ACListModelAdapter getMedicalStrengthenCooperationModel(){
    if(medicalStrengthenCooperationModel==null){
      medicalStrengthenCooperationModel = new ACListModelAdapter();
      addMedicalStrengthenCooperationModel();
    }
    return medicalStrengthenCooperationModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getMedicalStrengthenCooperationItem1(){
    if(medicalStrengthenCooperationItem1==null){

      medicalStrengthenCooperationItem1 = new ACRadioButtonItem();

      medicalStrengthenCooperationItem1.setText("�Ȃ�");

      medicalStrengthenCooperationItem1.setGroup(getMedicalStrengthenCooperation());

      medicalStrengthenCooperationItem1.setConstraints(VRLayout.FLOW);

      addMedicalStrengthenCooperationItem1();
    }
    return medicalStrengthenCooperationItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getMedicalStrengthenCooperationItem2(){
    if(medicalStrengthenCooperationItem2==null){

      medicalStrengthenCooperationItem2 = new ACRadioButtonItem();

      medicalStrengthenCooperationItem2.setText("����");

      medicalStrengthenCooperationItem2.setGroup(getMedicalStrengthenCooperation());

      medicalStrengthenCooperationItem2.setConstraints(VRLayout.FLOW);

      addMedicalStrengthenCooperationItem2();
    }
    return medicalStrengthenCooperationItem2;

  }

  /**
   * ��ΐE���z�u���Z���擾���܂��B
   * @return ��ΐE���z�u���Z
   */
  public ACValueArrayRadioButtonGroup getNightStaffDispositionAddRadioGroup(){
    if(nightStaffDispositionAddRadioGroup==null){

      nightStaffDispositionAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getNightStaffDispositionAddRadioGroupContainer().setText("��ΐE���z�u���Z");

      nightStaffDispositionAddRadioGroup.setBindPath("1210121");

      nightStaffDispositionAddRadioGroup.setNoSelectIndex(0);

      nightStaffDispositionAddRadioGroup.setUseClearButton(false);

      nightStaffDispositionAddRadioGroup.setModel(getNightStaffDispositionAddRadioGroupModel());

      nightStaffDispositionAddRadioGroup.setValues(new int[]{1,2,3});

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
   * ���ZI�E���ZII���擾���܂��B
   * @return ���ZI�E���ZII
   */
  public ACRadioButtonItem getNightStaffDispositionAddRadioItem2(){
    if(nightStaffDispositionAddRadioItem2==null){

      nightStaffDispositionAddRadioItem2 = new ACRadioButtonItem();

      nightStaffDispositionAddRadioItem2.setText("���ZI�E���ZII");

      nightStaffDispositionAddRadioItem2.setGroup(getNightStaffDispositionAddRadioGroup());

      nightStaffDispositionAddRadioItem2.setConstraints(VRLayout.FLOW);

      addNightStaffDispositionAddRadioItem2();
    }
    return nightStaffDispositionAddRadioItem2;

  }

  /**
   * ���ZIII�E���ZIV���擾���܂��B
   * @return ���ZIII�E���ZIV
   */
  public ACRadioButtonItem getNightStaffDispositionAddRadioItem3(){
    if(nightStaffDispositionAddRadioItem3==null){

      nightStaffDispositionAddRadioItem3 = new ACRadioButtonItem();

      nightStaffDispositionAddRadioItem3.setText("���ZIII�E���ZIV");

      nightStaffDispositionAddRadioItem3.setGroup(getNightStaffDispositionAddRadioGroup());

      nightStaffDispositionAddRadioItem3.setConstraints(VRLayout.FLOW);

      addNightStaffDispositionAddRadioItem3();
    }
    return nightStaffDispositionAddRadioItem3;

  }

  /**
   * ��샍�{�b�g�̓������擾���܂��B
   * @return ��샍�{�b�g�̓���
   */
  public ACValueArrayRadioButtonGroup getKaigoRobotRadioGroup(){
    if(kaigoRobotRadioGroup==null){

      kaigoRobotRadioGroup = new ACValueArrayRadioButtonGroup();

      getKaigoRobotRadioGroupContainer().setText("��샍�{�b�g�̓���");

      kaigoRobotRadioGroup.setBindPath("1210134");

      kaigoRobotRadioGroup.setNoSelectIndex(0);

      kaigoRobotRadioGroup.setUseClearButton(false);

      kaigoRobotRadioGroup.setModel(getKaigoRobotRadioGroupModel());

      kaigoRobotRadioGroup.setValues(new int[]{1,2});

      addKaigoRobotRadioGroup();
    }
    return kaigoRobotRadioGroup;

  }

  /**
   * ��샍�{�b�g�̓����R���e�i���擾���܂��B
   * @return ��샍�{�b�g�̓����R���e�i
   */
  protected ACLabelContainer getKaigoRobotRadioGroupContainer(){
    if(kaigoRobotRadioGroupContainer==null){
      kaigoRobotRadioGroupContainer = new ACLabelContainer();
      kaigoRobotRadioGroupContainer.setFollowChildEnabled(true);
      kaigoRobotRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      kaigoRobotRadioGroupContainer.add(getKaigoRobotRadioGroup(), null);
    }
    return kaigoRobotRadioGroupContainer;
  }

  /**
   * ��샍�{�b�g�̓������f�����擾���܂��B
   * @return ��샍�{�b�g�̓������f��
   */
  protected ACListModelAdapter getKaigoRobotRadioGroupModel(){
    if(kaigoRobotRadioGroupModel==null){
      kaigoRobotRadioGroupModel = new ACListModelAdapter();
      addKaigoRobotRadioGroupModel();
    }
    return kaigoRobotRadioGroupModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getKaigoRobotRadioItem1(){
    if(kaigoRobotRadioItem1==null){

      kaigoRobotRadioItem1 = new ACRadioButtonItem();

      kaigoRobotRadioItem1.setText("�Ȃ�");

      kaigoRobotRadioItem1.setGroup(getKaigoRobotRadioGroup());

      kaigoRobotRadioItem1.setConstraints(VRLayout.FLOW);

      addKaigoRobotRadioItem1();
    }
    return kaigoRobotRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getKaigoRobotRadioItem2(){
    if(kaigoRobotRadioItem2==null){

      kaigoRobotRadioItem2 = new ACRadioButtonItem();

      kaigoRobotRadioItem2.setText("����");

      kaigoRobotRadioItem2.setGroup(getKaigoRobotRadioGroup());

      kaigoRobotRadioItem2.setConstraints(VRLayout.FLOW);

      addKaigoRobotRadioItem2();
    }
    return kaigoRobotRadioItem2;

  }

  /**
   * ��N���F�m�Ǘ��p�Ҏ�����Z���擾���܂��B
   * @return ��N���F�m�Ǘ��p�Ҏ�����Z
   */
  public ACValueArrayRadioButtonGroup getYoungDementiaPatinetAddRadioGroup(){
    if(youngDementiaPatinetAddRadioGroup==null){

      youngDementiaPatinetAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getYoungDementiaPatinetAddRadioGroupContainer().setText("��N���F�m�Ǘ��p�Ҏ�����Z");

      youngDementiaPatinetAddRadioGroup.setBindPath("1210122");

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
   * ���}�̐����W�I�O���[�v���擾���܂��B
   * @return ���}�̐����W�I�O���[�v
   */
  public ACValueArrayRadioButtonGroup getMeetingAndSendingOffSystem(){
    if(meetingAndSendingOffSystem==null){

      meetingAndSendingOffSystem = new ACValueArrayRadioButtonGroup();

      getMeetingAndSendingOffSystemContainer().setText("���}�̐�");

      meetingAndSendingOffSystem.setBindPath("1210104");

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

      medicalFoodAddRadioGroup.setBindPath("1210123");

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

      dementiaCareRadioGroup.setBindPath("1210135");

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
   * �T�[�r�X�񋟑̐��������Z�i�P�ƌ^�E���݌^�j���擾���܂��B
   * @return �T�[�r�X�񋟑̐��������Z�i�P�ƌ^�E���݌^�j
   */
  public ACValueArrayRadioButtonGroup getServiceAddProvisionStructuralRadioGroup(){
    if(serviceAddProvisionStructuralRadioGroup==null){

      serviceAddProvisionStructuralRadioGroup = new ACValueArrayRadioButtonGroup();

      getServiceAddProvisionStructuralRadioGroupContainer().setText("<html>�T�[�r�X�񋟑̐��������Z<br>�i�P�ƌ^�E���݌^�j</html>");

      serviceAddProvisionStructuralRadioGroup.setBindPath("1210124");

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
   * �T�[�r�X�񋟑̐��������Z�i�P�ƌ^�E���݌^�j�R���e�i���擾���܂��B
   * @return �T�[�r�X�񋟑̐��������Z�i�P�ƌ^�E���݌^�j�R���e�i
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
   * �T�[�r�X�񋟑̐��������Z�i�P�ƌ^�E���݌^�j���f�����擾���܂��B
   * @return �T�[�r�X�񋟑̐��������Z�i�P�ƌ^�E���݌^�j���f��
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
   * �T�[�r�X�񋟑̐��������Z�i�󏰌^�j���擾���܂��B
   * @return �T�[�r�X�񋟑̐��������Z�i�󏰌^�j
   */
  public ACValueArrayRadioButtonGroup getServiceAddProvisionStructuralKusyoRadioGroup(){
    if(serviceAddProvisionStructuralKusyoRadioGroup==null){

      serviceAddProvisionStructuralKusyoRadioGroup = new ACValueArrayRadioButtonGroup();

      getServiceAddProvisionStructuralKusyoRadioGroupContainer().setText("<html>�T�[�r�X�񋟑̐��������Z<br>�i�󏰌^�j</html>");

      serviceAddProvisionStructuralKusyoRadioGroup.setBindPath("1210125");

      serviceAddProvisionStructuralKusyoRadioGroup.setVisible(true);

      serviceAddProvisionStructuralKusyoRadioGroup.setEnabled(true);

      serviceAddProvisionStructuralKusyoRadioGroup.setNoSelectIndex(0);

      serviceAddProvisionStructuralKusyoRadioGroup.setUseClearButton(false);

      serviceAddProvisionStructuralKusyoRadioGroup.setModel(getServiceAddProvisionStructuralKusyoRadioGroupModel());

      serviceAddProvisionStructuralKusyoRadioGroup.setValues(new int[]{1,5,2,3,4});

      addServiceAddProvisionStructuralKusyoRadioGroup();
    }
    return serviceAddProvisionStructuralKusyoRadioGroup;

  }

  /**
   * �T�[�r�X�񋟑̐��������Z�i�󏰌^�j�R���e�i���擾���܂��B
   * @return �T�[�r�X�񋟑̐��������Z�i�󏰌^�j�R���e�i
   */
  protected ACLabelContainer getServiceAddProvisionStructuralKusyoRadioGroupContainer(){
    if(serviceAddProvisionStructuralKusyoRadioGroupContainer==null){
      serviceAddProvisionStructuralKusyoRadioGroupContainer = new ACLabelContainer();
      serviceAddProvisionStructuralKusyoRadioGroupContainer.setFollowChildEnabled(true);
      serviceAddProvisionStructuralKusyoRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      serviceAddProvisionStructuralKusyoRadioGroupContainer.add(getServiceAddProvisionStructuralKusyoRadioGroup(), null);
    }
    return serviceAddProvisionStructuralKusyoRadioGroupContainer;
  }

  /**
   * �T�[�r�X�񋟑̐��������Z�i�󏰌^�j���f�����擾���܂��B
   * @return �T�[�r�X�񋟑̐��������Z�i�󏰌^�j���f��
   */
  protected ACListModelAdapter getServiceAddProvisionStructuralKusyoRadioGroupModel(){
    if(serviceAddProvisionStructuralKusyoRadioGroupModel==null){
      serviceAddProvisionStructuralKusyoRadioGroupModel = new ACListModelAdapter();
      addServiceAddProvisionStructuralKusyoRadioGroupModel();
    }
    return serviceAddProvisionStructuralKusyoRadioGroupModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getServiceAddProvisionStructuralKusyoRadioItem1(){
    if(serviceAddProvisionStructuralKusyoRadioItem1==null){

      serviceAddProvisionStructuralKusyoRadioItem1 = new ACRadioButtonItem();

      serviceAddProvisionStructuralKusyoRadioItem1.setText("�Ȃ�");

      serviceAddProvisionStructuralKusyoRadioItem1.setGroup(getServiceAddProvisionStructuralKusyoRadioGroup());

      serviceAddProvisionStructuralKusyoRadioItem1.setConstraints(VRLayout.FLOW);

      addServiceAddProvisionStructuralKusyoRadioItem1();
    }
    return serviceAddProvisionStructuralKusyoRadioItem1;

  }

  /**
   * ���ZI�C���擾���܂��B
   * @return ���ZI�C
   */
  public ACRadioButtonItem getServiceAddProvisionStructuralKusyoRadioItem2(){
    if(serviceAddProvisionStructuralKusyoRadioItem2==null){

      serviceAddProvisionStructuralKusyoRadioItem2 = new ACRadioButtonItem();

      serviceAddProvisionStructuralKusyoRadioItem2.setText("���ZI�C");

      serviceAddProvisionStructuralKusyoRadioItem2.setGroup(getServiceAddProvisionStructuralKusyoRadioGroup());

      serviceAddProvisionStructuralKusyoRadioItem2.setConstraints(VRLayout.FLOW);

      addServiceAddProvisionStructuralKusyoRadioItem2();
    }
    return serviceAddProvisionStructuralKusyoRadioItem2;

  }

  /**
   * ���ZI�����擾���܂��B
   * @return ���ZI��
   */
  public ACRadioButtonItem getServiceAddProvisionStructuralKusyoRadioItem3(){
    if(serviceAddProvisionStructuralKusyoRadioItem3==null){

      serviceAddProvisionStructuralKusyoRadioItem3 = new ACRadioButtonItem();

      serviceAddProvisionStructuralKusyoRadioItem3.setText("���ZI��");

      serviceAddProvisionStructuralKusyoRadioItem3.setGroup(getServiceAddProvisionStructuralKusyoRadioGroup());

      serviceAddProvisionStructuralKusyoRadioItem3.setConstraints(VRLayout.FLOW_RETURN);

      addServiceAddProvisionStructuralKusyoRadioItem3();
    }
    return serviceAddProvisionStructuralKusyoRadioItem3;

  }

  /**
   * ���ZII���擾���܂��B
   * @return ���ZII
   */
  public ACRadioButtonItem getServiceAddProvisionStructuralKusyoRadioItem4(){
    if(serviceAddProvisionStructuralKusyoRadioItem4==null){

      serviceAddProvisionStructuralKusyoRadioItem4 = new ACRadioButtonItem();

      serviceAddProvisionStructuralKusyoRadioItem4.setText("���ZII");

      serviceAddProvisionStructuralKusyoRadioItem4.setGroup(getServiceAddProvisionStructuralKusyoRadioGroup());

      serviceAddProvisionStructuralKusyoRadioItem4.setConstraints(VRLayout.FLOW);

      addServiceAddProvisionStructuralKusyoRadioItem4();
    }
    return serviceAddProvisionStructuralKusyoRadioItem4;

  }

  /**
   * ���ZIII���擾���܂��B
   * @return ���ZIII
   */
  public ACRadioButtonItem getServiceAddProvisionStructuralKusyoRadioItem5(){
    if(serviceAddProvisionStructuralKusyoRadioItem5==null){

      serviceAddProvisionStructuralKusyoRadioItem5 = new ACRadioButtonItem();

      serviceAddProvisionStructuralKusyoRadioItem5.setText("���ZIII");

      serviceAddProvisionStructuralKusyoRadioItem5.setGroup(getServiceAddProvisionStructuralKusyoRadioGroup());

      serviceAddProvisionStructuralKusyoRadioItem5.setConstraints(VRLayout.FLOW);

      addServiceAddProvisionStructuralKusyoRadioItem5();
    }
    return serviceAddProvisionStructuralKusyoRadioItem5;

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
   * �������R���e�i���擾���܂��B
   * @return �������R���e�i
   */
  public ACLabelContainer getReduceRateContainer(){
    if(reduceRateContainer==null){

      reduceRateContainer = new ACLabelContainer();

      reduceRateContainer.setText("������");

      reduceRateContainer.setFollowChildEnabled(true);

      addReduceRateContainer();
    }
    return reduceRateContainer;

  }

  /**
   * ���������擾���܂��B
   * @return ������
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
   * �����x�����擾���܂��B
   * @return �����x��
   */
  public ACLabel getPercentSign(){
    if(percentSign==null){

      percentSign = new ACLabel();

      percentSign.setText("��");

      addPercentSign();
    }
    return percentSign;

  }

  /**
   * �Е����ƑΏێ��Ǝ҂��擾���܂��B
   * @return �Е����ƑΏێ��Ǝ�
   */
  public ACIntegerCheckBox getShahukuReduce(){
    if(ShahukuReduce==null){

      ShahukuReduce = new ACIntegerCheckBox();

      ShahukuReduce.setText("�Љ���@�l���̌y�����x");

      ShahukuReduce.setBindPath("1");

      ShahukuReduce.setSelectValue(2);

      ShahukuReduce.setUnSelectValue(1);

      addShahukuReduce();
    }
    return ShahukuReduce;

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

      dinnerTotal.setBindPath("1210108");

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

      dinnerMorning.setBindPath("1210109");

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

      dinnerNoon.setBindPath("1210110");

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

      dinnerNight.setBindPath("1210111");

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

      unitRoom.setBindPath("1210112");

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

      unitSemiRoom.setBindPath("1210113");

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

      normalRoom.setBindPath("1210114");

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

      tasyouRoom.setBindPath("1210115");

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
  public QO004_12111_201804Design() {

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
   * �p�l���P�ɓ������ڂ�ǉ����܂��B
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

    calculationDetails.add(getKyoseiServiceTankiRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails.add(getSeikatsuSoudanGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails.add(getSeikatsuKinouGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails.add(getFunctionTrainingGuidanceSystemContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails.add(getIndividualfunctionTrainingSystemContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails.add(getNurseStructuralAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails.add(getNurseStructuralAdd2RadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails.add(getMedicalStrengthenCooperationContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails.add(getNightStaffDispositionAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails.add(getKaigoRobotRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails.add(getYoungDementiaPatinetAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

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
   * �P�ƌ^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addFacilitiesDivisionItem1(){

  }

  /**
   * ���݌^�E�󏰌^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addFacilitiesDivisionItem2(){

  }

  /**
   * �P�ƌ^���j�b�g�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addFacilitiesDivisionItem3(){

  }

  /**
   * ���݌^�E�󏰌^���j�b�g�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addFacilitiesDivisionItem4(){

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
   * �E���̌����ɂ�錸�Z�̏󋵃��W�I�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffLack(){

  }

  /**
   * �E���̌����ɂ�錸�Z�̏󋵃��W�I�O���[�v���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffLackModel(){

    getStaffLackItem1().setButtonIndex(1);

    getStaffLackModel().add(getStaffLackItem1());

    getStaffLackItem2().setButtonIndex(2);

    getStaffLackModel().add(getStaffLackItem2());

    getStaffLackItem3().setButtonIndex(3);

    getStaffLackModel().add(getStaffLackItem3());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffLackItem1(){

  }

  /**
   * �Ō�E���ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffLackItem2(){

  }

  /**
   * ���E���ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffLackItem3(){

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
   * �����^�T�[�r�X�̒� �i�Z���������Ə��j �ɓ������ڂ�ǉ����܂��B
   */
  protected void addKyoseiServiceTankiRadioGroup(){

  }

  /**
   * �����^�T�[�r�X�̒� �i�Z���������Ə��j ���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKyoseiServiceTankiRadioGroupModel(){

    getKyoseiServiceTankiItem1().setButtonIndex(1);

    getKyoseiServiceTankiRadioGroupModel().add(getKyoseiServiceTankiItem1());

    getKyoseiServiceTankiItem2().setButtonIndex(2);

    getKyoseiServiceTankiRadioGroupModel().add(getKyoseiServiceTankiItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addKyoseiServiceTankiItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addKyoseiServiceTankiItem2(){

  }

  /**
   * �������k���z�u�����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addSeikatsuSoudanGroup(){

  }

  /**
   * �������k���z�u�����Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addSeikatsuSoudanGroupModel(){

    getSeikatsuSoudanGroupItem1().setButtonIndex(1);

    getSeikatsuSoudanGroupModel().add(getSeikatsuSoudanGroupItem1());

    getSeikatsuSoudanGroupItem2().setButtonIndex(2);

    getSeikatsuSoudanGroupModel().add(getSeikatsuSoudanGroupItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addSeikatsuSoudanGroupItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addSeikatsuSoudanGroupItem2(){

  }

  /**
   * �����@�\����A�g���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addSeikatsuKinouGroup(){

  }

  /**
   * �����@�\����A�g���Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addSeikatsuKinouGroupModel(){

    getSeikatsuKinouGroupItem1().setButtonIndex(1);

    getSeikatsuKinouGroupModel().add(getSeikatsuKinouGroupItem1());

    getSeikatsuKinouGroupItem2().setButtonIndex(2);

    getSeikatsuKinouGroupModel().add(getSeikatsuKinouGroupItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addSeikatsuKinouGroupItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addSeikatsuKinouGroupItem2(){

  }

  /**
   * �@�\�P���w���̐����W�I�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addFunctionTrainingGuidanceSystem(){

  }

  /**
   * �@�\�P���w���̐����W�I�O���[�v���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addFunctionTrainingGuidanceSystemModel(){

    getFunctionTrainingGuidanceSystemItem1().setButtonIndex(1);

    getFunctionTrainingGuidanceSystemModel().add(getFunctionTrainingGuidanceSystemItem1());

    getFunctionTrainingGuidanceSystemItem2().setButtonIndex(2);

    getFunctionTrainingGuidanceSystemModel().add(getFunctionTrainingGuidanceSystemItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addFunctionTrainingGuidanceSystemItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addFunctionTrainingGuidanceSystemItem2(){

  }

  /**
   * �ʋ@�\�P���̐����W�I�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addIndividualfunctionTrainingSystem(){

  }

  /**
   * �ʋ@�\�P���̐����W�I�O���[�v���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addIndividualfunctionTrainingSystemModel(){

    getIndividualfunctionTrainingSystemItem1().setButtonIndex(1);

    getIndividualfunctionTrainingSystemModel().add(getIndividualfunctionTrainingSystemItem1());

    getIndividualfunctionTrainingSystemItem2().setButtonIndex(2);

    getIndividualfunctionTrainingSystemModel().add(getIndividualfunctionTrainingSystemItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addIndividualfunctionTrainingSystemItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addIndividualfunctionTrainingSystemItem2(){

  }

  /**
   * �Ō�̐����Z I����III�ɓ������ڂ�ǉ����܂��B
   */
  protected void addNurseStructuralAddRadioGroup(){

  }

  /**
   * �Ō�̐����Z I����III���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addNurseStructuralAddRadioGroupModel(){

    getNurseStructuralAddRadioItem1().setButtonIndex(1);

    getNurseStructuralAddRadioGroupModel().add(getNurseStructuralAddRadioItem1());

    getNurseStructuralAddRadioItem2().setButtonIndex(2);

    getNurseStructuralAddRadioGroupModel().add(getNurseStructuralAddRadioItem2());

    getNurseStructuralAddRadioItem3().setButtonIndex(3);

    getNurseStructuralAddRadioGroupModel().add(getNurseStructuralAddRadioItem3());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addNurseStructuralAddRadioItem1(){

  }

  /**
   * ���ZI�ɓ������ڂ�ǉ����܂��B
   */
  protected void addNurseStructuralAddRadioItem2(){

  }

  /**
   * ���ZIII�ɓ������ڂ�ǉ����܂��B
   */
  protected void addNurseStructuralAddRadioItem3(){

  }

  /**
   * �Ō�̐����Z II����IV�ɓ������ڂ�ǉ����܂��B
   */
  protected void addNurseStructuralAdd2RadioGroup(){

  }

  /**
   * �Ō�̐����Z II����IV���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addNurseStructuralAdd2RadioGroupModel(){

    getNurseStructuralAdd2RadioItem1().setButtonIndex(1);

    getNurseStructuralAdd2RadioGroupModel().add(getNurseStructuralAdd2RadioItem1());

    getNurseStructuralAdd2RadioItem2().setButtonIndex(2);

    getNurseStructuralAdd2RadioGroupModel().add(getNurseStructuralAdd2RadioItem2());

    getNurseStructuralAdd2RadioItem3().setButtonIndex(3);

    getNurseStructuralAdd2RadioGroupModel().add(getNurseStructuralAdd2RadioItem3());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addNurseStructuralAdd2RadioItem1(){

  }

  /**
   * ���ZII�ɓ������ڂ�ǉ����܂��B
   */
  protected void addNurseStructuralAdd2RadioItem2(){

  }

  /**
   * ���ZIV�ɓ������ڂ�ǉ����܂��B
   */
  protected void addNurseStructuralAdd2RadioItem3(){

  }

  /**
   * ��ØA�g�������Z���W�I�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalStrengthenCooperation(){

  }

  /**
   * ��ØA�g�������Z���W�I�O���[�v���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalStrengthenCooperationModel(){

    getMedicalStrengthenCooperationItem1().setButtonIndex(1);

    getMedicalStrengthenCooperationModel().add(getMedicalStrengthenCooperationItem1());

    getMedicalStrengthenCooperationItem2().setButtonIndex(2);

    getMedicalStrengthenCooperationModel().add(getMedicalStrengthenCooperationItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalStrengthenCooperationItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalStrengthenCooperationItem2(){

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

    getNightStaffDispositionAddRadioItem3().setButtonIndex(3);

    getNightStaffDispositionAddRadioGroupModel().add(getNightStaffDispositionAddRadioItem3());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addNightStaffDispositionAddRadioItem1(){

  }

  /**
   * ���ZI�E���ZII�ɓ������ڂ�ǉ����܂��B
   */
  protected void addNightStaffDispositionAddRadioItem2(){

  }

  /**
   * ���ZIII�E���ZIV�ɓ������ڂ�ǉ����܂��B
   */
  protected void addNightStaffDispositionAddRadioItem3(){

  }

  /**
   * ��샍�{�b�g�̓����ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoRobotRadioGroup(){

  }

  /**
   * ��샍�{�b�g�̓������f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoRobotRadioGroupModel(){

    getKaigoRobotRadioItem1().setButtonIndex(1);

    getKaigoRobotRadioGroupModel().add(getKaigoRobotRadioItem1());

    getKaigoRobotRadioItem2().setButtonIndex(2);

    getKaigoRobotRadioGroupModel().add(getKaigoRobotRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoRobotRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoRobotRadioItem2(){

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
   * �p�l��2�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPanel2(){

    panel2.add(getCalculationDetails2(), VRLayout.NORTH);

    panel2.add(getStandardMoneyGroup(), VRLayout.NORTH);

  }

  /**
   * �Z�荀�ڗ̈�2�ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalculationDetails2(){

    calculationDetails2.add(getMeetingAndSendingOffSystemContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails2.add(getMedicalFoodAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails2.add(getDementiaCareRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails2.add(getServiceAddProvisionStructuralRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails2.add(getServiceAddProvisionStructuralKusyoRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails2.add(getStaffUpgradeRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails2.add(getReduceRateContainer(), VRLayout.FLOW);

    calculationDetails2.add(getShahukuReduce(), VRLayout.FLOW);

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
   * �T�[�r�X�񋟑̐��������Z�i�P�ƌ^�E���݌^�j�ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceAddProvisionStructuralRadioGroup(){

  }

  /**
   * �T�[�r�X�񋟑̐��������Z�i�P�ƌ^�E���݌^�j���f���ɓ������ڂ�ǉ����܂��B
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
   * �T�[�r�X�񋟑̐��������Z�i�󏰌^�j�ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceAddProvisionStructuralKusyoRadioGroup(){

  }

  /**
   * �T�[�r�X�񋟑̐��������Z�i�󏰌^�j���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceAddProvisionStructuralKusyoRadioGroupModel(){

    getServiceAddProvisionStructuralKusyoRadioItem1().setButtonIndex(1);

    getServiceAddProvisionStructuralKusyoRadioGroupModel().add(getServiceAddProvisionStructuralKusyoRadioItem1());

    getServiceAddProvisionStructuralKusyoRadioItem2().setButtonIndex(5);

    getServiceAddProvisionStructuralKusyoRadioGroupModel().add(getServiceAddProvisionStructuralKusyoRadioItem2());

    getServiceAddProvisionStructuralKusyoRadioItem3().setButtonIndex(2);

    getServiceAddProvisionStructuralKusyoRadioGroupModel().add(getServiceAddProvisionStructuralKusyoRadioItem3());

    getServiceAddProvisionStructuralKusyoRadioItem4().setButtonIndex(3);

    getServiceAddProvisionStructuralKusyoRadioGroupModel().add(getServiceAddProvisionStructuralKusyoRadioItem4());

    getServiceAddProvisionStructuralKusyoRadioItem5().setButtonIndex(4);

    getServiceAddProvisionStructuralKusyoRadioGroupModel().add(getServiceAddProvisionStructuralKusyoRadioItem5());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceAddProvisionStructuralKusyoRadioItem1(){

  }

  /**
   * ���ZI�C�ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceAddProvisionStructuralKusyoRadioItem2(){

  }

  /**
   * ���ZI���ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceAddProvisionStructuralKusyoRadioItem3(){

  }

  /**
   * ���ZII�ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceAddProvisionStructuralKusyoRadioItem4(){

  }

  /**
   * ���ZIII�ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceAddProvisionStructuralKusyoRadioItem5(){

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
   * �������R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addReduceRateContainer(){

    reduceRateContainer.add(getReduceRate(), VRLayout.FLOW);

    reduceRateContainer.add(getPercentSign(), VRLayout.FLOW);

  }

  /**
   * �������ɓ������ڂ�ǉ����܂��B
   */
  protected void addReduceRate(){

  }

  /**
   * �����x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addPercentSign(){

  }

  /**
   * �Е����ƑΏێ��Ǝ҂ɓ������ڂ�ǉ����܂��B
   */
  protected void addShahukuReduce(){

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
   * ���j�b�g�^���I��������z�E�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addUnitSemiRoomContainer(){

    unitSemiRoomContainer.add(getUnitSemiRoom(), null);

    unitSemiRoomContainer.add(getUnitSemiRoomLabel(), null);

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
      ACFrame.debugStart(new ACAffairInfo(QO004_12111_201804Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QO004_12111_201804Design getThis() {
    return this;
  }
}
