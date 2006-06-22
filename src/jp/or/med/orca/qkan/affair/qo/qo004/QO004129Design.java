
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
 * �쐬��: 2006/03/27  ���{�R���s���[�^�[������� ���{�@�K�� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���̑��@�\ (O)
 * �v���Z�X ���Ǝғo�^ (004)
 * �v���O���� �n�斧���^���V�l�����{�� (QO004129)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qo.qo004;
import java.awt.Component;
import java.awt.im.InputSubset;

import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;

import jp.nichicom.ac.component.ACClearableRadioButtonGroup;
import jp.nichicom.ac.component.ACIntegerCheckBox;
import jp.nichicom.ac.component.ACLabel;
import jp.nichicom.ac.component.ACRadioButtonItem;
import jp.nichicom.ac.component.ACTextField;
import jp.nichicom.ac.container.ACBackLabelContainer;
import jp.nichicom.ac.container.ACGroupBox;
import jp.nichicom.ac.container.ACLabelContainer;
import jp.nichicom.ac.container.ACPanel;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.util.adapter.ACListModelAdapter;
import jp.nichicom.vr.layout.VRLayout;
import jp.nichicom.vr.text.VRCharType;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.affair.qs.qs001.QS001ServicePanel;
/**
 * �n�斧���^���V�l�����{�݉�ʍ��ڃf�U�C��(QO004129) 
 */
public class QO004129Design extends QS001ServicePanel {
  //GUI�R���|�[�l���g

  private ACGroupBox mainGroup;

  private JTabbedPane tab;

  private ACPanel panel1;

  private ACPanel calculationDetails1;

  private ACLabelContainer facilitiesDivisionContainer;

  private ACClearableRadioButtonGroup facilitiesDivision;

  private ACListModelAdapter facilitiesDivisionModel;

  private ACRadioButtonItem facilitiesDivisionItem1;

  private ACRadioButtonItem facilitiesDivisionItem2;

  private ACRadioButtonItem facilitiesDivisionItem3;

  private ACRadioButtonItem facilitiesDivisionItem4;

  private ACIntegerCheckBox facilitiesDivisionOther1;

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

  private ACClearableRadioButtonGroup unitCareMaintenance;

  private ACLabelContainer unitCareMaintenanceContainer;

  private ACListModelAdapter unitCareMaintenanceModel;

  private ACRadioButtonItem unitCareMaintenanceItem1;

  private ACRadioButtonItem unitCareMaintenanceItem2;

  private ACClearableRadioButtonGroup heavilyCorrespondenceAdd;

  private ACLabelContainer heavilyCorrespondenceAddContainer;

  private ACListModelAdapter heavilyCorrespondenceAddModel;

  private ACRadioButtonItem heavilyCorrespondenceAddItem1;

  private ACRadioButtonItem heavilyCorrespondenceAddItem2;

  private ACClearableRadioButtonGroup semiUnitCareMaintenance;

  private ACLabelContainer semiUnitCareMaintenanceContainer;

  private ACListModelAdapter semiUnitCareMaintenanceModel;

  private ACRadioButtonItem semiUnitCareMaintenanceItem1;

  private ACRadioButtonItem semiUnitCareMaintenanceItem2;

  private ACClearableRadioButtonGroup functionTrainingGuidanceSystem;

  private ACLabelContainer functionTrainingGuidanceSystemContainer;

  private ACListModelAdapter functionTrainingGuidanceSystemModel;

  private ACRadioButtonItem functionTrainingGuidanceSystemItem1;

  private ACRadioButtonItem functionTrainingGuidanceSystemItem2;

  private ACClearableRadioButtonGroup standingDoctorAssignment;

  private ACLabelContainer standingDoctorAssignmentContainer;

  private ACListModelAdapter standingDoctorAssignmentModel;

  private ACRadioButtonItem standingDoctorAssignmentItem1;

  private ACRadioButtonItem standingDoctorAssignmentItem2;

  private ACClearableRadioButtonGroup psychiatristGuidance;

  private ACLabelContainer psychiatristGuidanceContainer;

  private ACListModelAdapter psychiatristGuidanceModel;

  private ACRadioButtonItem psychiatristGuidanceItem1;

  private ACRadioButtonItem psychiatristGuidanceItem2;

  private ACClearableRadioButtonGroup handicappedPersonSupport;

  private ACLabelContainer handicappedPersonSupportContainer;

  private ACListModelAdapter handicappedPersonSupportModel;

  private ACRadioButtonItem handicappedPersonSupportItem1;

  private ACRadioButtonItem handicappedPersonSupportItem2;

  private ACClearableRadioButtonGroup nourishmentControlAdd;

  private ACLabelContainer nourishmentControlAddContainer;

  private ACListModelAdapter nourishmentControlAddModel;

  private ACRadioButtonItem nourishmentControlAddItem1;

  private ACRadioButtonItem nourishmentControlAddItem2;

  private ACRadioButtonItem nourishmentControlAddItem3;

  private ACClearableRadioButtonGroup nourishmentManagementAdd;

  private ACLabelContainer nourishmentManagementAddContainer;

  private ACListModelAdapter nourishmentManagementAddModel;

  private ACRadioButtonItem nourishmentManagementAddItem1;

  private ACRadioButtonItem nourishmentManagementAddItem2;

  private ACClearableRadioButtonGroup bodyRestraintAbolition;

  private ACLabelContainer bodyRestraintAbolitionContainer;

  private ACListModelAdapter bodyRestraintAbolitionModel;

  private ACRadioButtonItem bodyRestraintAbolitionItem1;

  private ACRadioButtonItem bodyRestraintAbolitionItem2;

  private ACPanel panel2;

  private ACPanel calculationDetails2;

  private ACClearableRadioButtonGroup terminalCare;

  private ACLabelContainer terminalCareContainer;

  private ACListModelAdapter terminalCareModel;

  private ACRadioButtonItem terminalCareItem1;

  private ACRadioButtonItem terminalCareItem2;

  private ACClearableRadioButtonGroup homeAndFacility;

  private ACLabelContainer homeAndFacilityContainer;

  private ACListModelAdapter homeAndFacilityModel;

  private ACRadioButtonItem homeAndFacilityItem1;

  private ACRadioButtonItem homeAndFacilityItem2;

  private ACClearableRadioButtonGroup smallFootholdConcentration;

  private ACLabelContainer smallFootholdConcentrationContainer;

  private ACListModelAdapter smallFootholdConcentrationModel;

  private ACRadioButtonItem smallFootholdConcentrationItem1;

  private ACRadioButtonItem smallFootholdConcentrationItem2;

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

  private ACPanel calculationDetails3;

  private ACLabelContainer reduceRateContainer;

  private ACTextField reduceRate;

  private ACLabel percentSign;

  private ACIntegerCheckBox ShahukuReduce;

  //getter

  /**
   * ���ƃO���[�v���擾���܂��B
   * @return ���ƃO���[�v
   */
  public ACGroupBox getMainGroup(){
    if(mainGroup==null){

      mainGroup = new ACGroupBox();

      mainGroup.setText("�n�斧���^���V�l�����{��");

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

      panel1.setHgrid(200);

      addPanel1();
    }
    return panel1;

  }

  /**
   * �Z�荀�ڗ̈�1���擾���܂��B
   * @return �Z�荀�ڗ̈�1
   */
  public ACPanel getCalculationDetails1(){
    if(calculationDetails1==null){

      calculationDetails1 = new ACPanel();

      calculationDetails1.setFollowChildEnabled(true);

      calculationDetails1.setHgrid(200);

      addCalculationDetails1();
    }
    return calculationDetails1;

  }

  /**
   * �{�݋敪�R���e�i���擾���܂��B
   * @return �{�݋敪�R���e�i
   */
  public ACLabelContainer getFacilitiesDivisionContainer(){
    if(facilitiesDivisionContainer==null){

      facilitiesDivisionContainer = new ACLabelContainer();

      facilitiesDivisionContainer.setText("�{�ݓ��̋敪");

      facilitiesDivisionContainer.setFollowChildEnabled(true);

      addFacilitiesDivisionContainer();
    }
    return facilitiesDivisionContainer;

  }

  /**
   * �{�݋敪���W�I�O���[�v���擾���܂��B
   * @return �{�݋敪���W�I�O���[�v
   */
  public ACClearableRadioButtonGroup getFacilitiesDivision(){
    if(facilitiesDivision==null){

      facilitiesDivision = new ACClearableRadioButtonGroup();

      facilitiesDivision.setBindPath("1540101");

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
   * �n�斧���^��앟���{�݂��擾���܂��B
   * @return �n�斧���^��앟���{��
   */
  public ACRadioButtonItem getFacilitiesDivisionItem1(){
    if(facilitiesDivisionItem1==null){

      facilitiesDivisionItem1 = new ACRadioButtonItem();

      facilitiesDivisionItem1.setText("�n�斧���^��앟���{��");

      facilitiesDivisionItem1.setGroup(getFacilitiesDivision());

      facilitiesDivisionItem1.setConstraints(VRLayout.FLOW_RETURN);

      addFacilitiesDivisionItem1();
    }
    return facilitiesDivisionItem1;

  }

  /**
   * �T�e���C�g�^��앟���{�݂��擾���܂��B
   * @return �T�e���C�g�^��앟���{��
   */
  public ACRadioButtonItem getFacilitiesDivisionItem2(){
    if(facilitiesDivisionItem2==null){

      facilitiesDivisionItem2 = new ACRadioButtonItem();

      facilitiesDivisionItem2.setText("�T�e���C�g�^��앟���{��");

      facilitiesDivisionItem2.setGroup(getFacilitiesDivision());

      facilitiesDivisionItem2.setConstraints(VRLayout.FLOW_RETURN);

      addFacilitiesDivisionItem2();
    }
    return facilitiesDivisionItem2;

  }

  /**
   * ���j�b�g�^�n�斧���^��앟���{�݂��擾���܂��B
   * @return ���j�b�g�^�n�斧���^��앟���{��
   */
  public ACRadioButtonItem getFacilitiesDivisionItem3(){
    if(facilitiesDivisionItem3==null){

      facilitiesDivisionItem3 = new ACRadioButtonItem();

      facilitiesDivisionItem3.setText("���j�b�g�^�n�斧���^��앟���{��");

      facilitiesDivisionItem3.setGroup(getFacilitiesDivision());

      facilitiesDivisionItem3.setConstraints(VRLayout.FLOW_RETURN);

      addFacilitiesDivisionItem3();
    }
    return facilitiesDivisionItem3;

  }

  /**
   * ���j�b�g�^�T�e���C�g�^��앟���{�݂��擾���܂��B
   * @return ���j�b�g�^�T�e���C�g�^��앟���{��
   */
  public ACRadioButtonItem getFacilitiesDivisionItem4(){
    if(facilitiesDivisionItem4==null){

      facilitiesDivisionItem4 = new ACRadioButtonItem();

      facilitiesDivisionItem4.setText("���j�b�g�^�T�e���C�g�^��앟���{��");

      facilitiesDivisionItem4.setGroup(getFacilitiesDivision());

      facilitiesDivisionItem4.setConstraints(VRLayout.FLOW);

      addFacilitiesDivisionItem4();
    }
    return facilitiesDivisionItem4;

  }

  /**
   * �o�ߓI�{�݂��擾���܂��B
   * @return �o�ߓI�{��
   */
  public ACIntegerCheckBox getFacilitiesDivisionOther1(){
    if(facilitiesDivisionOther1==null){

      facilitiesDivisionOther1 = new ACIntegerCheckBox();

      facilitiesDivisionOther1.setText("�o�ߓI�{��");

      facilitiesDivisionOther1.setBindPath("1540102");

      facilitiesDivisionOther1.setSelectValue(2);

      facilitiesDivisionOther1.setUnSelectValue(1);

      addFacilitiesDivisionOther1();
    }
    return facilitiesDivisionOther1;

  }

  /**
   * ��ԋΖ���������W�I�O���[�v���擾���܂��B
   * @return ��ԋΖ���������W�I�O���[�v
   */
  public ACClearableRadioButtonGroup getNightWorkDivision(){
    if(nightWorkDivision==null){

      nightWorkDivision = new ACClearableRadioButtonGroup();

      getNightWorkDivisionContainer().setText("��ԋΖ������");

      nightWorkDivision.setBindPath("1540103");

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

      staffLack.setBindPath("1540112");

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
   * �Ō�E�����擾���܂��B
   * @return �Ō�E��
   */
  public ACRadioButtonItem getStaffLackItem2(){
    if(staffLackItem2==null){

      staffLackItem2 = new ACRadioButtonItem();

      staffLackItem2.setText("�Ō�E��");

      staffLackItem2.setGroup(getStaffLack());

      staffLackItem2.setConstraints(VRLayout.FLOW_RETURN);

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

      staffLackItem3.setConstraints(VRLayout.FLOW);

      addStaffLackItem3();
    }
    return staffLackItem3;

  }

  /**
   * ���x���������擾���܂��B
   * @return ���x������
   */
  public ACRadioButtonItem getStaffLackItem4(){
    if(staffLackItem4==null){

      staffLackItem4 = new ACRadioButtonItem();

      staffLackItem4.setText("���x������");

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
  public ACClearableRadioButtonGroup getUnitCareMaintenance(){
    if(unitCareMaintenance==null){

      unitCareMaintenance = new ACClearableRadioButtonGroup();

      getUnitCareMaintenanceContainer().setText("���j�b�g�P�A�̐�");

      unitCareMaintenance.setBindPath("1540113");

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
   * �d�x���Ή��̐����擾���܂��B
   * @return �d�x���Ή��̐�
   */
  public ACClearableRadioButtonGroup getHeavilyCorrespondenceAdd(){
    if(heavilyCorrespondenceAdd==null){

      heavilyCorrespondenceAdd = new ACClearableRadioButtonGroup();

      getHeavilyCorrespondenceAddContainer().setText("�d�x���Ή��̐�");

      heavilyCorrespondenceAdd.setBindPath("1540115");

      heavilyCorrespondenceAdd.setUseClearButton(false);

      heavilyCorrespondenceAdd.setModel(getHeavilyCorrespondenceAddModel());

      addHeavilyCorrespondenceAdd();
    }
    return heavilyCorrespondenceAdd;

  }

  /**
   * �d�x���Ή��̐��R���e�i���擾���܂��B
   * @return �d�x���Ή��̐��R���e�i
   */
  protected ACLabelContainer getHeavilyCorrespondenceAddContainer(){
    if(heavilyCorrespondenceAddContainer==null){
      heavilyCorrespondenceAddContainer = new ACLabelContainer();
      heavilyCorrespondenceAddContainer.setFollowChildEnabled(true);
      heavilyCorrespondenceAddContainer.setVAlignment(VRLayout.CENTER);
      heavilyCorrespondenceAddContainer.add(getHeavilyCorrespondenceAdd(), null);
    }
    return heavilyCorrespondenceAddContainer;
  }

  /**
   * �d�x���Ή��̐����f�����擾���܂��B
   * @return �d�x���Ή��̐����f��
   */
  protected ACListModelAdapter getHeavilyCorrespondenceAddModel(){
    if(heavilyCorrespondenceAddModel==null){
      heavilyCorrespondenceAddModel = new ACListModelAdapter();
      addHeavilyCorrespondenceAddModel();
    }
    return heavilyCorrespondenceAddModel;
  }

  /**
   * �Ή��s���擾���܂��B
   * @return �Ή��s��
   */
  public ACRadioButtonItem getHeavilyCorrespondenceAddItem1(){
    if(heavilyCorrespondenceAddItem1==null){

      heavilyCorrespondenceAddItem1 = new ACRadioButtonItem();

      heavilyCorrespondenceAddItem1.setText("�Ή��s��");

      heavilyCorrespondenceAddItem1.setGroup(getHeavilyCorrespondenceAdd());

      heavilyCorrespondenceAddItem1.setConstraints(VRLayout.FLOW);

      addHeavilyCorrespondenceAddItem1();
    }
    return heavilyCorrespondenceAddItem1;

  }

  /**
   * �Ή����擾���܂��B
   * @return �Ή���
   */
  public ACRadioButtonItem getHeavilyCorrespondenceAddItem2(){
    if(heavilyCorrespondenceAddItem2==null){

      heavilyCorrespondenceAddItem2 = new ACRadioButtonItem();

      heavilyCorrespondenceAddItem2.setText("�Ή���");

      heavilyCorrespondenceAddItem2.setGroup(getHeavilyCorrespondenceAdd());

      heavilyCorrespondenceAddItem2.setConstraints(VRLayout.FLOW);

      addHeavilyCorrespondenceAddItem2();
    }
    return heavilyCorrespondenceAddItem2;

  }

  /**
   * �����j�b�g�P�A�̐����擾���܂��B
   * @return �����j�b�g�P�A�̐�
   */
  public ACClearableRadioButtonGroup getSemiUnitCareMaintenance(){
    if(semiUnitCareMaintenance==null){

      semiUnitCareMaintenance = new ACClearableRadioButtonGroup();

      getSemiUnitCareMaintenanceContainer().setText("�����j�b�g�P�A�̐�");

      semiUnitCareMaintenance.setBindPath("1540114");

      semiUnitCareMaintenance.setUseClearButton(false);

      semiUnitCareMaintenance.setModel(getSemiUnitCareMaintenanceModel());

      addSemiUnitCareMaintenance();
    }
    return semiUnitCareMaintenance;

  }

  /**
   * �����j�b�g�P�A�̐��R���e�i���擾���܂��B
   * @return �����j�b�g�P�A�̐��R���e�i
   */
  protected ACLabelContainer getSemiUnitCareMaintenanceContainer(){
    if(semiUnitCareMaintenanceContainer==null){
      semiUnitCareMaintenanceContainer = new ACLabelContainer();
      semiUnitCareMaintenanceContainer.setFollowChildEnabled(true);
      semiUnitCareMaintenanceContainer.setVAlignment(VRLayout.CENTER);
      semiUnitCareMaintenanceContainer.add(getSemiUnitCareMaintenance(), null);
    }
    return semiUnitCareMaintenanceContainer;
  }

  /**
   * �����j�b�g�P�A�̐����f�����擾���܂��B
   * @return �����j�b�g�P�A�̐����f��
   */
  protected ACListModelAdapter getSemiUnitCareMaintenanceModel(){
    if(semiUnitCareMaintenanceModel==null){
      semiUnitCareMaintenanceModel = new ACListModelAdapter();
      addSemiUnitCareMaintenanceModel();
    }
    return semiUnitCareMaintenanceModel;
  }

  /**
   * �Ή��s���擾���܂��B
   * @return �Ή��s��
   */
  public ACRadioButtonItem getSemiUnitCareMaintenanceItem1(){
    if(semiUnitCareMaintenanceItem1==null){

      semiUnitCareMaintenanceItem1 = new ACRadioButtonItem();

      semiUnitCareMaintenanceItem1.setText("�Ή��s��");

      semiUnitCareMaintenanceItem1.setGroup(getSemiUnitCareMaintenance());

      semiUnitCareMaintenanceItem1.setConstraints(VRLayout.FLOW);

      addSemiUnitCareMaintenanceItem1();
    }
    return semiUnitCareMaintenanceItem1;

  }

  /**
   * �Ή����擾���܂��B
   * @return �Ή���
   */
  public ACRadioButtonItem getSemiUnitCareMaintenanceItem2(){
    if(semiUnitCareMaintenanceItem2==null){

      semiUnitCareMaintenanceItem2 = new ACRadioButtonItem();

      semiUnitCareMaintenanceItem2.setText("�Ή���");

      semiUnitCareMaintenanceItem2.setGroup(getSemiUnitCareMaintenance());

      semiUnitCareMaintenanceItem2.setConstraints(VRLayout.FLOW);

      addSemiUnitCareMaintenanceItem2();
    }
    return semiUnitCareMaintenanceItem2;

  }

  /**
   * �ʋ@�\�P���̐����W�I�O���[�v���擾���܂��B
   * @return �ʋ@�\�P���̐����W�I�O���[�v
   */
  public ACClearableRadioButtonGroup getFunctionTrainingGuidanceSystem(){
    if(functionTrainingGuidanceSystem==null){

      functionTrainingGuidanceSystem = new ACClearableRadioButtonGroup();

      getFunctionTrainingGuidanceSystemContainer().setText("�ʋ@�\�P���̐�");

      functionTrainingGuidanceSystem.setBindPath("1540104");

      functionTrainingGuidanceSystem.setUseClearButton(false);

      functionTrainingGuidanceSystem.setModel(getFunctionTrainingGuidanceSystemModel());

      addFunctionTrainingGuidanceSystem();
    }
    return functionTrainingGuidanceSystem;

  }

  /**
   * �ʋ@�\�P���̐����W�I�O���[�v�R���e�i���擾���܂��B
   * @return �ʋ@�\�P���̐����W�I�O���[�v�R���e�i
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
   * �ʋ@�\�P���̐����W�I�O���[�v���f�����擾���܂��B
   * @return �ʋ@�\�P���̐����W�I�O���[�v���f��
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
   * ��ΐ�]��t�z�u���W�I�O���[�v���擾���܂��B
   * @return ��ΐ�]��t�z�u���W�I�O���[�v
   */
  public ACClearableRadioButtonGroup getStandingDoctorAssignment(){
    if(standingDoctorAssignment==null){

      standingDoctorAssignment = new ACClearableRadioButtonGroup();

      getStandingDoctorAssignmentContainer().setText("��ΐ�]��t�z�u");

      standingDoctorAssignment.setBindPath("1540105");

      standingDoctorAssignment.setUseClearButton(false);

      standingDoctorAssignment.setModel(getStandingDoctorAssignmentModel());

      addStandingDoctorAssignment();
    }
    return standingDoctorAssignment;

  }

  /**
   * ��ΐ�]��t�z�u���W�I�O���[�v�R���e�i���擾���܂��B
   * @return ��ΐ�]��t�z�u���W�I�O���[�v�R���e�i
   */
  protected ACLabelContainer getStandingDoctorAssignmentContainer(){
    if(standingDoctorAssignmentContainer==null){
      standingDoctorAssignmentContainer = new ACLabelContainer();
      standingDoctorAssignmentContainer.setFollowChildEnabled(true);
      standingDoctorAssignmentContainer.setVAlignment(VRLayout.CENTER);
      standingDoctorAssignmentContainer.add(getStandingDoctorAssignment(), null);
    }
    return standingDoctorAssignmentContainer;
  }

  /**
   * ��ΐ�]��t�z�u���W�I�O���[�v���f�����擾���܂��B
   * @return ��ΐ�]��t�z�u���W�I�O���[�v���f��
   */
  protected ACListModelAdapter getStandingDoctorAssignmentModel(){
    if(standingDoctorAssignmentModel==null){
      standingDoctorAssignmentModel = new ACListModelAdapter();
      addStandingDoctorAssignmentModel();
    }
    return standingDoctorAssignmentModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getStandingDoctorAssignmentItem1(){
    if(standingDoctorAssignmentItem1==null){

      standingDoctorAssignmentItem1 = new ACRadioButtonItem();

      standingDoctorAssignmentItem1.setText("�Ȃ�");

      standingDoctorAssignmentItem1.setGroup(getStandingDoctorAssignment());

      addStandingDoctorAssignmentItem1();
    }
    return standingDoctorAssignmentItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getStandingDoctorAssignmentItem2(){
    if(standingDoctorAssignmentItem2==null){

      standingDoctorAssignmentItem2 = new ACRadioButtonItem();

      standingDoctorAssignmentItem2.setText("����");

      standingDoctorAssignmentItem2.setGroup(getStandingDoctorAssignment());

      addStandingDoctorAssignmentItem2();
    }
    return standingDoctorAssignmentItem2;

  }

  /**
   * ���_�Ȉ�t����I�×{�w�����W�I�O���[�v���擾���܂��B
   * @return ���_�Ȉ�t����I�×{�w�����W�I�O���[�v
   */
  public ACClearableRadioButtonGroup getPsychiatristGuidance(){
    if(psychiatristGuidance==null){

      psychiatristGuidance = new ACClearableRadioButtonGroup();

      getPsychiatristGuidanceContainer().setText("���_�Ȉ�t����I�×{�w��");

      psychiatristGuidance.setBindPath("1540106");

      psychiatristGuidance.setUseClearButton(false);

      psychiatristGuidance.setModel(getPsychiatristGuidanceModel());

      addPsychiatristGuidance();
    }
    return psychiatristGuidance;

  }

  /**
   * ���_�Ȉ�t����I�×{�w�����W�I�O���[�v�R���e�i���擾���܂��B
   * @return ���_�Ȉ�t����I�×{�w�����W�I�O���[�v�R���e�i
   */
  protected ACLabelContainer getPsychiatristGuidanceContainer(){
    if(psychiatristGuidanceContainer==null){
      psychiatristGuidanceContainer = new ACLabelContainer();
      psychiatristGuidanceContainer.setFollowChildEnabled(true);
      psychiatristGuidanceContainer.setVAlignment(VRLayout.CENTER);
      psychiatristGuidanceContainer.add(getPsychiatristGuidance(), null);
    }
    return psychiatristGuidanceContainer;
  }

  /**
   * ���_�Ȉ�t����I�×{�w�����W�I�O���[�v���f�����擾���܂��B
   * @return ���_�Ȉ�t����I�×{�w�����W�I�O���[�v���f��
   */
  protected ACListModelAdapter getPsychiatristGuidanceModel(){
    if(psychiatristGuidanceModel==null){
      psychiatristGuidanceModel = new ACListModelAdapter();
      addPsychiatristGuidanceModel();
    }
    return psychiatristGuidanceModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getPsychiatristGuidanceItem1(){
    if(psychiatristGuidanceItem1==null){

      psychiatristGuidanceItem1 = new ACRadioButtonItem();

      psychiatristGuidanceItem1.setText("�Ȃ�");

      psychiatristGuidanceItem1.setGroup(getPsychiatristGuidance());

      addPsychiatristGuidanceItem1();
    }
    return psychiatristGuidanceItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getPsychiatristGuidanceItem2(){
    if(psychiatristGuidanceItem2==null){

      psychiatristGuidanceItem2 = new ACRadioButtonItem();

      psychiatristGuidanceItem2.setText("����");

      psychiatristGuidanceItem2.setGroup(getPsychiatristGuidance());

      addPsychiatristGuidanceItem2();
    }
    return psychiatristGuidanceItem2;

  }

  /**
   * ��Q�Ґ����x���̐����W�I�O���[�v���擾���܂��B
   * @return ��Q�Ґ����x���̐����W�I�O���[�v
   */
  public ACClearableRadioButtonGroup getHandicappedPersonSupport(){
    if(handicappedPersonSupport==null){

      handicappedPersonSupport = new ACClearableRadioButtonGroup();

      getHandicappedPersonSupportContainer().setText("��Q�Ґ����x���̐�");

      handicappedPersonSupport.setBindPath("1540107");

      handicappedPersonSupport.setUseClearButton(false);

      handicappedPersonSupport.setModel(getHandicappedPersonSupportModel());

      addHandicappedPersonSupport();
    }
    return handicappedPersonSupport;

  }

  /**
   * ��Q�Ґ����x���̐����W�I�O���[�v�R���e�i���擾���܂��B
   * @return ��Q�Ґ����x���̐����W�I�O���[�v�R���e�i
   */
  protected ACLabelContainer getHandicappedPersonSupportContainer(){
    if(handicappedPersonSupportContainer==null){
      handicappedPersonSupportContainer = new ACLabelContainer();
      handicappedPersonSupportContainer.setFollowChildEnabled(true);
      handicappedPersonSupportContainer.setVAlignment(VRLayout.CENTER);
      handicappedPersonSupportContainer.add(getHandicappedPersonSupport(), null);
    }
    return handicappedPersonSupportContainer;
  }

  /**
   * ��Q�Ґ����x���̐����W�I�O���[�v���f�����擾���܂��B
   * @return ��Q�Ґ����x���̐����W�I�O���[�v���f��
   */
  protected ACListModelAdapter getHandicappedPersonSupportModel(){
    if(handicappedPersonSupportModel==null){
      handicappedPersonSupportModel = new ACListModelAdapter();
      addHandicappedPersonSupportModel();
    }
    return handicappedPersonSupportModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getHandicappedPersonSupportItem1(){
    if(handicappedPersonSupportItem1==null){

      handicappedPersonSupportItem1 = new ACRadioButtonItem();

      handicappedPersonSupportItem1.setText("�Ȃ�");

      handicappedPersonSupportItem1.setGroup(getHandicappedPersonSupport());

      addHandicappedPersonSupportItem1();
    }
    return handicappedPersonSupportItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getHandicappedPersonSupportItem2(){
    if(handicappedPersonSupportItem2==null){

      handicappedPersonSupportItem2 = new ACRadioButtonItem();

      handicappedPersonSupportItem2.setText("����");

      handicappedPersonSupportItem2.setGroup(getHandicappedPersonSupport());

      addHandicappedPersonSupportItem2();
    }
    return handicappedPersonSupportItem2;

  }

  /**
   * �h�{�Ǘ��̕]�����W�I�O���[�v���擾���܂��B
   * @return �h�{�Ǘ��̕]�����W�I�O���[�v
   */
  public ACClearableRadioButtonGroup getNourishmentControlAdd(){
    if(nourishmentControlAdd==null){

      nourishmentControlAdd = new ACClearableRadioButtonGroup();

      getNourishmentControlAddContainer().setText("�h�{�Ǘ��̕]��");

      nourishmentControlAdd.setBindPath("1540108");

      nourishmentControlAdd.setUseClearButton(false);

      nourishmentControlAdd.setModel(getNourishmentControlAddModel());

      addNourishmentControlAdd();
    }
    return nourishmentControlAdd;

  }

  /**
   * �h�{�Ǘ��̕]�����W�I�O���[�v�R���e�i���擾���܂��B
   * @return �h�{�Ǘ��̕]�����W�I�O���[�v�R���e�i
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
   * �h�{�Ǘ��̕]�����W�I�O���[�v���f�����擾���܂��B
   * @return �h�{�Ǘ��̕]�����W�I�O���[�v���f��
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

      nourishmentControlAddItem1.setConstraints(VRLayout.FLOW);

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

      nourishmentControlAddItem2.setConstraints(VRLayout.FLOW);

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

      nourishmentControlAddItem3.setConstraints(VRLayout.FLOW_RETURN);

      addNourishmentControlAddItem3();
    }
    return nourishmentControlAddItem3;

  }

  /**
   * �h�{�P�A�E�}�l�W�����g�̐����W�I�O���[�v���擾���܂��B
   * @return �h�{�P�A�E�}�l�W�����g�̐����W�I�O���[�v
   */
  public ACClearableRadioButtonGroup getNourishmentManagementAdd(){
    if(nourishmentManagementAdd==null){

      nourishmentManagementAdd = new ACClearableRadioButtonGroup();

      getNourishmentManagementAddContainer().setText("�h�{�P�A�E�}�l�W�����g�̐�");

      nourishmentManagementAdd.setBindPath("1540109");

      nourishmentManagementAdd.setUseClearButton(false);

      nourishmentManagementAdd.setModel(getNourishmentManagementAddModel());

      addNourishmentManagementAdd();
    }
    return nourishmentManagementAdd;

  }

  /**
   * �h�{�P�A�E�}�l�W�����g�̐����W�I�O���[�v�R���e�i���擾���܂��B
   * @return �h�{�P�A�E�}�l�W�����g�̐����W�I�O���[�v�R���e�i
   */
  protected ACLabelContainer getNourishmentManagementAddContainer(){
    if(nourishmentManagementAddContainer==null){
      nourishmentManagementAddContainer = new ACLabelContainer();
      nourishmentManagementAddContainer.setFollowChildEnabled(true);
      nourishmentManagementAddContainer.setVAlignment(VRLayout.CENTER);
      nourishmentManagementAddContainer.add(getNourishmentManagementAdd(), null);
    }
    return nourishmentManagementAddContainer;
  }

  /**
   * �h�{�P�A�E�}�l�W�����g�̐����W�I�O���[�v���f�����擾���܂��B
   * @return �h�{�P�A�E�}�l�W�����g�̐����W�I�O���[�v���f��
   */
  protected ACListModelAdapter getNourishmentManagementAddModel(){
    if(nourishmentManagementAddModel==null){
      nourishmentManagementAddModel = new ACListModelAdapter();
      addNourishmentManagementAddModel();
    }
    return nourishmentManagementAddModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getNourishmentManagementAddItem1(){
    if(nourishmentManagementAddItem1==null){

      nourishmentManagementAddItem1 = new ACRadioButtonItem();

      nourishmentManagementAddItem1.setText("�Ȃ�");

      nourishmentManagementAddItem1.setGroup(getNourishmentManagementAdd());

      addNourishmentManagementAddItem1();
    }
    return nourishmentManagementAddItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getNourishmentManagementAddItem2(){
    if(nourishmentManagementAddItem2==null){

      nourishmentManagementAddItem2 = new ACRadioButtonItem();

      nourishmentManagementAddItem2.setText("����");

      nourishmentManagementAddItem2.setGroup(getNourishmentManagementAdd());

      addNourishmentManagementAddItem2();
    }
    return nourishmentManagementAddItem2;

  }

  /**
   * �g�̍S���p�~��g�̗L�����擾���܂��B
   * @return �g�̍S���p�~��g�̗L��
   */
  public ACClearableRadioButtonGroup getBodyRestraintAbolition(){
    if(bodyRestraintAbolition==null){

      bodyRestraintAbolition = new ACClearableRadioButtonGroup();

      getBodyRestraintAbolitionContainer().setText("�g�̍S���p�~��g�̗L��");

      bodyRestraintAbolition.setBindPath("1540116");

      bodyRestraintAbolition.setUseClearButton(false);

      bodyRestraintAbolition.setModel(getBodyRestraintAbolitionModel());

      addBodyRestraintAbolition();
    }
    return bodyRestraintAbolition;

  }

  /**
   * �g�̍S���p�~��g�̗L���R���e�i���擾���܂��B
   * @return �g�̍S���p�~��g�̗L���R���e�i
   */
  protected ACLabelContainer getBodyRestraintAbolitionContainer(){
    if(bodyRestraintAbolitionContainer==null){
      bodyRestraintAbolitionContainer = new ACLabelContainer();
      bodyRestraintAbolitionContainer.setFollowChildEnabled(true);
      bodyRestraintAbolitionContainer.setVAlignment(VRLayout.CENTER);
      bodyRestraintAbolitionContainer.add(getBodyRestraintAbolition(), null);
    }
    return bodyRestraintAbolitionContainer;
  }

  /**
   * �g�̍S���p�~��g�̗L�����f�����擾���܂��B
   * @return �g�̍S���p�~��g�̗L�����f��
   */
  protected ACListModelAdapter getBodyRestraintAbolitionModel(){
    if(bodyRestraintAbolitionModel==null){
      bodyRestraintAbolitionModel = new ACListModelAdapter();
      addBodyRestraintAbolitionModel();
    }
    return bodyRestraintAbolitionModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getBodyRestraintAbolitionItem1(){
    if(bodyRestraintAbolitionItem1==null){

      bodyRestraintAbolitionItem1 = new ACRadioButtonItem();

      bodyRestraintAbolitionItem1.setText("�Ȃ�");

      bodyRestraintAbolitionItem1.setGroup(getBodyRestraintAbolition());

      bodyRestraintAbolitionItem1.setConstraints(VRLayout.FLOW);

      addBodyRestraintAbolitionItem1();
    }
    return bodyRestraintAbolitionItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getBodyRestraintAbolitionItem2(){
    if(bodyRestraintAbolitionItem2==null){

      bodyRestraintAbolitionItem2 = new ACRadioButtonItem();

      bodyRestraintAbolitionItem2.setText("����");

      bodyRestraintAbolitionItem2.setGroup(getBodyRestraintAbolition());

      bodyRestraintAbolitionItem2.setConstraints(VRLayout.FLOW);

      addBodyRestraintAbolitionItem2();
    }
    return bodyRestraintAbolitionItem2;

  }

  /**
   * �p�l��2���擾���܂��B
   * @return �p�l��2
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
   * �Ŏ����̐����擾���܂��B
   * @return �Ŏ����̐�
   */
  public ACClearableRadioButtonGroup getTerminalCare(){
    if(terminalCare==null){

      terminalCare = new ACClearableRadioButtonGroup();

      getTerminalCareContainer().setText("�Ŏ����̐�");

      terminalCare.setBindPath("1540125");

      terminalCare.setUseClearButton(false);

      terminalCare.setModel(getTerminalCareModel());

      addTerminalCare();
    }
    return terminalCare;

  }

  /**
   * �Ŏ����̐��R���e�i���擾���܂��B
   * @return �Ŏ����̐��R���e�i
   */
  protected ACLabelContainer getTerminalCareContainer(){
    if(terminalCareContainer==null){
      terminalCareContainer = new ACLabelContainer();
      terminalCareContainer.setFollowChildEnabled(true);
      terminalCareContainer.setVAlignment(VRLayout.CENTER);
      terminalCareContainer.add(getTerminalCare(), null);
    }
    return terminalCareContainer;
  }

  /**
   * �Ŏ����̐����f�����擾���܂��B
   * @return �Ŏ����̐����f��
   */
  protected ACListModelAdapter getTerminalCareModel(){
    if(terminalCareModel==null){
      terminalCareModel = new ACListModelAdapter();
      addTerminalCareModel();
    }
    return terminalCareModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getTerminalCareItem1(){
    if(terminalCareItem1==null){

      terminalCareItem1 = new ACRadioButtonItem();

      terminalCareItem1.setText("�Ȃ�");

      terminalCareItem1.setGroup(getTerminalCare());

      terminalCareItem1.setConstraints(VRLayout.FLOW);

      addTerminalCareItem1();
    }
    return terminalCareItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getTerminalCareItem2(){
    if(terminalCareItem2==null){

      terminalCareItem2 = new ACRadioButtonItem();

      terminalCareItem2.setText("����");

      terminalCareItem2.setGroup(getTerminalCare());

      terminalCareItem2.setConstraints(VRLayout.FLOW);

      addTerminalCareItem2();
    }
    return terminalCareItem2;

  }

  /**
   * �ݑ�E�������ݗ��p�̐����擾���܂��B
   * @return �ݑ�E�������ݗ��p�̐�
   */
  public ACClearableRadioButtonGroup getHomeAndFacility(){
    if(homeAndFacility==null){

      homeAndFacility = new ACClearableRadioButtonGroup();

      getHomeAndFacilityContainer().setText("�ݑ�E�������ݗ��p�̐�");

      homeAndFacility.setBindPath("1540126");

      homeAndFacility.setUseClearButton(false);

      homeAndFacility.setModel(getHomeAndFacilityModel());

      addHomeAndFacility();
    }
    return homeAndFacility;

  }

  /**
   * �ݑ�E�������ݗ��p�̐��R���e�i���擾���܂��B
   * @return �ݑ�E�������ݗ��p�̐��R���e�i
   */
  protected ACLabelContainer getHomeAndFacilityContainer(){
    if(homeAndFacilityContainer==null){
      homeAndFacilityContainer = new ACLabelContainer();
      homeAndFacilityContainer.setFollowChildEnabled(true);
      homeAndFacilityContainer.setVAlignment(VRLayout.CENTER);
      homeAndFacilityContainer.add(getHomeAndFacility(), null);
    }
    return homeAndFacilityContainer;
  }

  /**
   * �ݑ�E�������ݗ��p�̐����f�����擾���܂��B
   * @return �ݑ�E�������ݗ��p�̐����f��
   */
  protected ACListModelAdapter getHomeAndFacilityModel(){
    if(homeAndFacilityModel==null){
      homeAndFacilityModel = new ACListModelAdapter();
      addHomeAndFacilityModel();
    }
    return homeAndFacilityModel;
  }

  /**
   * �Ή��s���擾���܂��B
   * @return �Ή��s��
   */
  public ACRadioButtonItem getHomeAndFacilityItem1(){
    if(homeAndFacilityItem1==null){

      homeAndFacilityItem1 = new ACRadioButtonItem();

      homeAndFacilityItem1.setText("�Ή��s��");

      homeAndFacilityItem1.setGroup(getHomeAndFacility());

      homeAndFacilityItem1.setConstraints(VRLayout.FLOW);

      addHomeAndFacilityItem1();
    }
    return homeAndFacilityItem1;

  }

  /**
   * �Ή����擾���܂��B
   * @return �Ή���
   */
  public ACRadioButtonItem getHomeAndFacilityItem2(){
    if(homeAndFacilityItem2==null){

      homeAndFacilityItem2 = new ACRadioButtonItem();

      homeAndFacilityItem2.setText("�Ή���");

      homeAndFacilityItem2.setGroup(getHomeAndFacility());

      homeAndFacilityItem2.setConstraints(VRLayout.FLOW);

      addHomeAndFacilityItem2();
    }
    return homeAndFacilityItem2;

  }

  /**
   * ���K�͋��_�W���̐����擾���܂��B
   * @return ���K�͋��_�W���̐�
   */
  public ACClearableRadioButtonGroup getSmallFootholdConcentration(){
    if(smallFootholdConcentration==null){

      smallFootholdConcentration = new ACClearableRadioButtonGroup();

      getSmallFootholdConcentrationContainer().setText("���K�͋��_�W���̐�");

      smallFootholdConcentration.setBindPath("1540127");

      smallFootholdConcentration.setUseClearButton(false);

      smallFootholdConcentration.setModel(getSmallFootholdConcentrationModel());

      addSmallFootholdConcentration();
    }
    return smallFootholdConcentration;

  }

  /**
   * ���K�͋��_�W���̐��R���e�i���擾���܂��B
   * @return ���K�͋��_�W���̐��R���e�i
   */
  protected ACLabelContainer getSmallFootholdConcentrationContainer(){
    if(smallFootholdConcentrationContainer==null){
      smallFootholdConcentrationContainer = new ACLabelContainer();
      smallFootholdConcentrationContainer.setFollowChildEnabled(true);
      smallFootholdConcentrationContainer.setVAlignment(VRLayout.CENTER);
      smallFootholdConcentrationContainer.add(getSmallFootholdConcentration(), null);
    }
    return smallFootholdConcentrationContainer;
  }

  /**
   * ���K�͋��_�W���̐����f�����擾���܂��B
   * @return ���K�͋��_�W���̐����f��
   */
  protected ACListModelAdapter getSmallFootholdConcentrationModel(){
    if(smallFootholdConcentrationModel==null){
      smallFootholdConcentrationModel = new ACListModelAdapter();
      addSmallFootholdConcentrationModel();
    }
    return smallFootholdConcentrationModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getSmallFootholdConcentrationItem1(){
    if(smallFootholdConcentrationItem1==null){

      smallFootholdConcentrationItem1 = new ACRadioButtonItem();

      smallFootholdConcentrationItem1.setText("�Ȃ�");

      smallFootholdConcentrationItem1.setGroup(getSmallFootholdConcentration());

      smallFootholdConcentrationItem1.setConstraints(VRLayout.FLOW);

      addSmallFootholdConcentrationItem1();
    }
    return smallFootholdConcentrationItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getSmallFootholdConcentrationItem2(){
    if(smallFootholdConcentrationItem2==null){

      smallFootholdConcentrationItem2 = new ACRadioButtonItem();

      smallFootholdConcentrationItem2.setText("����");

      smallFootholdConcentrationItem2.setGroup(getSmallFootholdConcentration());

      smallFootholdConcentrationItem2.setConstraints(VRLayout.FLOW);

      addSmallFootholdConcentrationItem2();
    }
    return smallFootholdConcentrationItem2;

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

      dinnerTotal.setBindPath("1540117");

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

      dinnerMorning.setBindPath("1540118");

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

      dinnerNoon.setBindPath("1540119");

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

      dinnerNight.setBindPath("1540120");

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

      unitRoom.setBindPath("1540121");

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

      unitSemiRoom.setBindPath("1540122");

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

      normalRoom.setBindPath("1540123");

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

      tasyouRoom.setBindPath("1540124");

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
   * �Z�荀�ڗ̈�3���擾���܂��B
   * @return �Z�荀�ڗ̈�3
   */
  public ACPanel getCalculationDetails3(){
    if(calculationDetails3==null){

      calculationDetails3 = new ACPanel();

      calculationDetails3.setFollowChildEnabled(true);

      calculationDetails3.setHgrid(200);

      addCalculationDetails3();
    }
    return calculationDetails3;

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
   * �R���X�g���N�^�ł��B
   */
  public QO004129Design() {

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

    panel1.add(getCalculationDetails1(), VRLayout.NORTH);

  }

  /**
   * �Z�荀�ڗ̈�1�ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalculationDetails1(){

    calculationDetails1.add(getFacilitiesDivisionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails1.add(getNightWorkDivisionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails1.add(getStaffLackContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails1.add(getUnitCareMaintenanceContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails1.add(getHeavilyCorrespondenceAddContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails1.add(getSemiUnitCareMaintenanceContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails1.add(getFunctionTrainingGuidanceSystemContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails1.add(getStandingDoctorAssignmentContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails1.add(getPsychiatristGuidanceContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails1.add(getHandicappedPersonSupportContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails1.add(getNourishmentControlAddContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails1.add(getNourishmentManagementAddContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails1.add(getBodyRestraintAbolitionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * �{�݋敪�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addFacilitiesDivisionContainer(){

    facilitiesDivisionContainer.add(getFacilitiesDivision(), VRLayout.FLOW_INSETLINE_RETURN);

    facilitiesDivisionContainer.add(getFacilitiesDivisionOther1(), VRLayout.FLOW);

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
   * �n�斧���^��앟���{�݂ɓ������ڂ�ǉ����܂��B
   */
  protected void addFacilitiesDivisionItem1(){

  }

  /**
   * �T�e���C�g�^��앟���{�݂ɓ������ڂ�ǉ����܂��B
   */
  protected void addFacilitiesDivisionItem2(){

  }

  /**
   * ���j�b�g�^�n�斧���^��앟���{�݂ɓ������ڂ�ǉ����܂��B
   */
  protected void addFacilitiesDivisionItem3(){

  }

  /**
   * ���j�b�g�^�T�e���C�g�^��앟���{�݂ɓ������ڂ�ǉ����܂��B
   */
  protected void addFacilitiesDivisionItem4(){

  }

  /**
   * �o�ߓI�{�݂ɓ������ڂ�ǉ����܂��B
   */
  protected void addFacilitiesDivisionOther1(){

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
   * ���x�������ɓ������ڂ�ǉ����܂��B
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
   * �d�x���Ή��̐��ɓ������ڂ�ǉ����܂��B
   */
  protected void addHeavilyCorrespondenceAdd(){

  }

  /**
   * �d�x���Ή��̐����f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addHeavilyCorrespondenceAddModel(){

    getHeavilyCorrespondenceAddItem1().setButtonIndex(1);
    getHeavilyCorrespondenceAddModel().add(getHeavilyCorrespondenceAddItem1());

    getHeavilyCorrespondenceAddItem2().setButtonIndex(2);
    getHeavilyCorrespondenceAddModel().add(getHeavilyCorrespondenceAddItem2());

  }

  /**
   * �Ή��s�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHeavilyCorrespondenceAddItem1(){

  }

  /**
   * �Ή��ɓ������ڂ�ǉ����܂��B
   */
  protected void addHeavilyCorrespondenceAddItem2(){

  }

  /**
   * �����j�b�g�P�A�̐��ɓ������ڂ�ǉ����܂��B
   */
  protected void addSemiUnitCareMaintenance(){

  }

  /**
   * �����j�b�g�P�A�̐����f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addSemiUnitCareMaintenanceModel(){

    getSemiUnitCareMaintenanceItem1().setButtonIndex(1);
    getSemiUnitCareMaintenanceModel().add(getSemiUnitCareMaintenanceItem1());

    getSemiUnitCareMaintenanceItem2().setButtonIndex(2);
    getSemiUnitCareMaintenanceModel().add(getSemiUnitCareMaintenanceItem2());

  }

  /**
   * �Ή��s�ɓ������ڂ�ǉ����܂��B
   */
  protected void addSemiUnitCareMaintenanceItem1(){

  }

  /**
   * �Ή��ɓ������ڂ�ǉ����܂��B
   */
  protected void addSemiUnitCareMaintenanceItem2(){

  }

  /**
   * �ʋ@�\�P���̐����W�I�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addFunctionTrainingGuidanceSystem(){

  }

  /**
   * �ʋ@�\�P���̐����W�I�O���[�v���f���ɓ������ڂ�ǉ����܂��B
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
   * ��ΐ�]��t�z�u���W�I�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addStandingDoctorAssignment(){

  }

  /**
   * ��ΐ�]��t�z�u���W�I�O���[�v���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addStandingDoctorAssignmentModel(){

    getStandingDoctorAssignmentItem1().setButtonIndex(1);
    getStandingDoctorAssignmentModel().add(getStandingDoctorAssignmentItem1());

    getStandingDoctorAssignmentItem2().setButtonIndex(2);
    getStandingDoctorAssignmentModel().add(getStandingDoctorAssignmentItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addStandingDoctorAssignmentItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addStandingDoctorAssignmentItem2(){

  }

  /**
   * ���_�Ȉ�t����I�×{�w�����W�I�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPsychiatristGuidance(){

  }

  /**
   * ���_�Ȉ�t����I�×{�w�����W�I�O���[�v���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addPsychiatristGuidanceModel(){

    getPsychiatristGuidanceItem1().setButtonIndex(1);
    getPsychiatristGuidanceModel().add(getPsychiatristGuidanceItem1());

    getPsychiatristGuidanceItem2().setButtonIndex(2);
    getPsychiatristGuidanceModel().add(getPsychiatristGuidanceItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addPsychiatristGuidanceItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addPsychiatristGuidanceItem2(){

  }

  /**
   * ��Q�Ґ����x���̐����W�I�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHandicappedPersonSupport(){

  }

  /**
   * ��Q�Ґ����x���̐����W�I�O���[�v���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addHandicappedPersonSupportModel(){

    getHandicappedPersonSupportItem1().setButtonIndex(1);
    getHandicappedPersonSupportModel().add(getHandicappedPersonSupportItem1());

    getHandicappedPersonSupportItem2().setButtonIndex(2);
    getHandicappedPersonSupportModel().add(getHandicappedPersonSupportItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addHandicappedPersonSupportItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addHandicappedPersonSupportItem2(){

  }

  /**
   * �h�{�Ǘ��̕]�����W�I�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addNourishmentControlAdd(){

  }

  /**
   * �h�{�Ǘ��̕]�����W�I�O���[�v���f���ɓ������ڂ�ǉ����܂��B
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
   * �h�{�P�A�E�}�l�W�����g�̐����W�I�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addNourishmentManagementAdd(){

  }

  /**
   * �h�{�P�A�E�}�l�W�����g�̐����W�I�O���[�v���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addNourishmentManagementAddModel(){

    getNourishmentManagementAddItem1().setButtonIndex(1);
    getNourishmentManagementAddModel().add(getNourishmentManagementAddItem1());

    getNourishmentManagementAddItem2().setButtonIndex(2);
    getNourishmentManagementAddModel().add(getNourishmentManagementAddItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addNourishmentManagementAddItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addNourishmentManagementAddItem2(){

  }

  /**
   * �g�̍S���p�~��g�̗L���ɓ������ڂ�ǉ����܂��B
   */
  protected void addBodyRestraintAbolition(){

  }

  /**
   * �g�̍S���p�~��g�̗L�����f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addBodyRestraintAbolitionModel(){

    getBodyRestraintAbolitionItem1().setButtonIndex(1);
    getBodyRestraintAbolitionModel().add(getBodyRestraintAbolitionItem1());

    getBodyRestraintAbolitionItem2().setButtonIndex(2);
    getBodyRestraintAbolitionModel().add(getBodyRestraintAbolitionItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addBodyRestraintAbolitionItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addBodyRestraintAbolitionItem2(){

  }

  /**
   * �p�l��2�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPanel2(){

    panel2.add(getCalculationDetails2(), VRLayout.NORTH);

    panel2.add(getStandardMoneyGroup(), VRLayout.NORTH);

    panel2.add(getCalculationDetails3(), VRLayout.NORTH);

  }

  /**
   * �Z�荀�ڗ̈�2�ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalculationDetails2(){

    calculationDetails2.add(getTerminalCareContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails2.add(getHomeAndFacilityContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails2.add(getSmallFootholdConcentrationContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * �Ŏ����̐��ɓ������ڂ�ǉ����܂��B
   */
  protected void addTerminalCare(){

  }

  /**
   * �Ŏ����̐����f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addTerminalCareModel(){

    getTerminalCareItem1().setButtonIndex(1);
    getTerminalCareModel().add(getTerminalCareItem1());

    getTerminalCareItem2().setButtonIndex(2);
    getTerminalCareModel().add(getTerminalCareItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addTerminalCareItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addTerminalCareItem2(){

  }

  /**
   * �ݑ�E�������ݗ��p�̐��ɓ������ڂ�ǉ����܂��B
   */
  protected void addHomeAndFacility(){

  }

  /**
   * �ݑ�E�������ݗ��p�̐����f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addHomeAndFacilityModel(){

    getHomeAndFacilityItem1().setButtonIndex(1);
    getHomeAndFacilityModel().add(getHomeAndFacilityItem1());

    getHomeAndFacilityItem2().setButtonIndex(2);
    getHomeAndFacilityModel().add(getHomeAndFacilityItem2());

  }

  /**
   * �Ή��s�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHomeAndFacilityItem1(){

  }

  /**
   * �Ή��ɓ������ڂ�ǉ����܂��B
   */
  protected void addHomeAndFacilityItem2(){

  }

  /**
   * ���K�͋��_�W���̐��ɓ������ڂ�ǉ����܂��B
   */
  protected void addSmallFootholdConcentration(){

  }

  /**
   * ���K�͋��_�W���̐����f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addSmallFootholdConcentrationModel(){

    getSmallFootholdConcentrationItem1().setButtonIndex(1);
    getSmallFootholdConcentrationModel().add(getSmallFootholdConcentrationItem1());

    getSmallFootholdConcentrationItem2().setButtonIndex(2);
    getSmallFootholdConcentrationModel().add(getSmallFootholdConcentrationItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addSmallFootholdConcentrationItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addSmallFootholdConcentrationItem2(){

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
   * �Z�荀�ڗ̈�3�ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalculationDetails3(){

    calculationDetails3.add(getReduceRateContainer(), VRLayout.FLOW_INSETLINE);

    calculationDetails3.add(getShahukuReduce(), VRLayout.FLOW_RETURN);

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
      ACFrame.setVRLookAndFeel();
      ACFrame.getInstance().setFrameEventProcesser(new QkanFrameEventProcesser());
      ACFrame.debugStart(new ACAffairInfo(QO004129Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QO004129Design getThis() {
    return this;
  }
}
