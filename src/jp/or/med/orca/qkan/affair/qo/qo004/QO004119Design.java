
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
 * �쐬��: 2006/03/09  ���{�R���s���[�^�[������� ���{�@�K�� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���̑��@�\ (O)
 * �v���Z�X ���Ǝғo�^ (004)
 * �v���O���� ���V�l�ی��{�� (QO004119)
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
import jp.or.med.orca.qkan.affair.qs.qs001.QS001ServicePanel;
import jp.or.med.orca.qkan.component.*;
import jp.or.med.orca.qkan.text.*;
/**
 * ���V�l�ی��{�݉�ʍ��ڃf�U�C��(QO004119) 
 */
public class QO004119Design extends QS001ServicePanel {
  //GUI�R���|�[�l���g

  private ACGroupBox mainGroup;

  private ACPanel calculationDetails;

  private ACClearableRadioButtonGroup facilitiesDivision;

  private ACLabelContainer facilitiesDivisionContainer;

  private ACListModelAdapter facilitiesDivisionModel;

  private ACRadioButtonItem facilitiesDivisionItem1;

  private ACRadioButtonItem facilitiesDivisionItem2;

  private ACRadioButtonItem facilitiesDivisionItem3;

  private ACRadioButtonItem facilitiesDivisionItem4;

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

  private ACClearableRadioButtonGroup dementiaCare;

  private ACLabelContainer dementiaCareContainer;

  private ACListModelAdapter dementiaCareModel;

  private ACRadioButtonItem dementiaCareItem1;

  private ACRadioButtonItem dementiaCareItem2;

  private ACClearableRadioButtonGroup bodyRestraintAbolition;

  private ACLabelContainer bodyRestraintAbolitionContainer;

  private ACListModelAdapter bodyRestraintAbolitionModel;

  private ACRadioButtonItem bodyRestraintAbolitionItem1;

  private ACRadioButtonItem bodyRestraintAbolitionItem2;

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

      mainGroup.setText("���V�l�ی��{��");

      mainGroup.setFollowChildEnabled(true);

      mainGroup.setHgrid(200);

      addMainGroup();
    }
    return mainGroup;

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
  public ACClearableRadioButtonGroup getFacilitiesDivision(){
    if(facilitiesDivision==null){

      facilitiesDivision = new ACClearableRadioButtonGroup();

      getFacilitiesDivisionContainer().setText("�{�ݓ��̋敪");

      facilitiesDivision.setBindPath("1520101");

      facilitiesDivision.setModel(getFacilitiesDivisionModel());

      facilitiesDivision.setUseClearButton(false);

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
   * ���ی��{�݂��擾���܂��B
   * @return ���ی��{��
   */
  public ACRadioButtonItem getFacilitiesDivisionItem1(){
    if(facilitiesDivisionItem1==null){

      facilitiesDivisionItem1 = new ACRadioButtonItem();

      facilitiesDivisionItem1.setText("���ی��{��");

      facilitiesDivisionItem1.setGroup(getFacilitiesDivision());

      facilitiesDivisionItem1.setConstraints(VRLayout.FLOW);

      addFacilitiesDivisionItem1();
    }
    return facilitiesDivisionItem1;

  }

  /**
   * ���K�͉��ی��{�݂��擾���܂��B
   * @return ���K�͉��ی��{��
   */
  public ACRadioButtonItem getFacilitiesDivisionItem2(){
    if(facilitiesDivisionItem2==null){

      facilitiesDivisionItem2 = new ACRadioButtonItem();

      facilitiesDivisionItem2.setText("���K�͉��ی��{��");

      facilitiesDivisionItem2.setGroup(getFacilitiesDivision());

      facilitiesDivisionItem2.setConstraints(VRLayout.FLOW_RETURN);

      addFacilitiesDivisionItem2();
    }
    return facilitiesDivisionItem2;

  }

  /**
   * ���j�b�g�^���ی��{�݂��擾���܂��B
   * @return ���j�b�g�^���ی��{��
   */
  public ACRadioButtonItem getFacilitiesDivisionItem3(){
    if(facilitiesDivisionItem3==null){

      facilitiesDivisionItem3 = new ACRadioButtonItem();

      facilitiesDivisionItem3.setText("���j�b�g�^���ی��{��");

      facilitiesDivisionItem3.setGroup(getFacilitiesDivision());

      facilitiesDivisionItem3.setConstraints(VRLayout.FLOW_RETURN);

      addFacilitiesDivisionItem3();
    }
    return facilitiesDivisionItem3;

  }

  /**
   * ���j�b�g�^���K�͉��ی��{�݂��擾���܂��B
   * @return ���j�b�g�^���K�͉��ی��{��
   */
  public ACRadioButtonItem getFacilitiesDivisionItem4(){
    if(facilitiesDivisionItem4==null){

      facilitiesDivisionItem4 = new ACRadioButtonItem();

      facilitiesDivisionItem4.setText("���j�b�g�^���K�͉��ی��{��");

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
  public ACClearableRadioButtonGroup getNightWorkDivision(){
    if(nightWorkDivision==null){

      nightWorkDivision = new ACClearableRadioButtonGroup();

      getNightWorkDivisionContainer().setText("��ԋΖ������");

      nightWorkDivision.setBindPath("1520102");

      nightWorkDivision.setModel(getNightWorkDivisionModel());

      nightWorkDivision.setUseClearButton(false);

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
  public ACClearableRadioButtonGroup getStaffLack(){
    if(staffLack==null){

      staffLack = new ACClearableRadioButtonGroup();

      getStaffLackContainer().setText("�E���̌����ɂ�錸�Z�̏�");

      staffLack.setBindPath("1520109");

      staffLack.setModel(getStaffLackModel());

      staffLack.setUseClearButton(false);

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
   * ���x���������擾���܂��B
   * @return ���x������
   */
  public ACRadioButtonItem getStaffLackItem7(){
    if(staffLackItem7==null){

      staffLackItem7 = new ACRadioButtonItem();

      staffLackItem7.setText("���x������");

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

      unitCareMaintenance.setBindPath("1520119");

      unitCareMaintenance.setModel(getUnitCareMaintenanceModel());

      unitCareMaintenance.setUseClearButton(false);

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
   * �h�{�Ǘ��̕]�����W�I�O���[�v���擾���܂��B
   * @return �h�{�Ǘ��̕]�����W�I�O���[�v
   */
  public ACClearableRadioButtonGroup getNourishmentControlAdd(){
    if(nourishmentControlAdd==null){

      nourishmentControlAdd = new ACClearableRadioButtonGroup();

      getNourishmentControlAddContainer().setText("�h�{�Ǘ��̕]��");

      nourishmentControlAdd.setBindPath("1520105");

      nourishmentControlAdd.setModel(getNourishmentControlAddModel());

      nourishmentControlAdd.setUseClearButton(false);

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

      nourishmentManagementAdd.setBindPath("1520106");

      nourishmentManagementAdd.setModel(getNourishmentManagementAddModel());

      nourishmentManagementAdd.setUseClearButton(false);

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
   * �F�m�ǃP�A���Z���擾���܂��B
   * @return �F�m�ǃP�A���Z
   */
  public ACClearableRadioButtonGroup getDementiaCare(){
    if(dementiaCare==null){

      dementiaCare = new ACClearableRadioButtonGroup();

      getDementiaCareContainer().setText("�F�m�ǃP�A���Z");

      dementiaCare.setBindPath("1520121");

      dementiaCare.setModel(getDementiaCareModel());

      dementiaCare.setUseClearButton(false);

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
   * �g�̍S���p�~��g�̗L�����擾���܂��B
   * @return �g�̍S���p�~��g�̗L��
   */
  public ACClearableRadioButtonGroup getBodyRestraintAbolition(){
    if(bodyRestraintAbolition==null){

      bodyRestraintAbolition = new ACClearableRadioButtonGroup();

      getBodyRestraintAbolitionContainer().setText("�g�̍S���p�~��g�̗L��");

      bodyRestraintAbolition.setBindPath("1520120");

      bodyRestraintAbolition.setModel(getBodyRestraintAbolitionModel());

      bodyRestraintAbolition.setUseClearButton(false);

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

      dinnerTotal.setBindPath("1520110");

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

      dinnerMorning.setBindPath("1520111");

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

      dinnerNoon.setBindPath("1520112");

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

      dinnerNight.setBindPath("1520113");

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

      unitRoom.setBindPath("1520114");

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

      unitSemiRoom.setBindPath("1520115");

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

      normalRoom.setBindPath("1520116");

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

      tasyouRoom.setBindPath("1520117");

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
   * �R���X�g���N�^�ł��B
   */
  public QO004119Design() {

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

    mainGroup.add(getCalculationDetails(), VRLayout.NORTH);

    mainGroup.add(getStandardMoneyGroup(), VRLayout.NORTH);

    mainGroup.add(getCalculationDetails2(), VRLayout.NORTH);

  }

  /**
   * �Z�荀�ڗ̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalculationDetails(){

    calculationDetails.add(getFacilitiesDivisionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails.add(getNightWorkDivisionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails.add(getStaffLackContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails.add(getUnitCareMaintenanceContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails.add(getNourishmentControlAddContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails.add(getNourishmentManagementAddContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails.add(getDementiaCareContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails.add(getBodyRestraintAbolitionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

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
   * ���ی��{�݂ɓ������ڂ�ǉ����܂��B
   */
  protected void addFacilitiesDivisionItem1(){

  }

  /**
   * ���K�͉��ی��{�݂ɓ������ڂ�ǉ����܂��B
   */
  protected void addFacilitiesDivisionItem2(){

  }

  /**
   * ���j�b�g�^���ی��{�݂ɓ������ڂ�ǉ����܂��B
   */
  protected void addFacilitiesDivisionItem3(){

  }

  /**
   * ���j�b�g�^���K�͉��ی��{�݂ɓ������ڂ�ǉ����܂��B
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
   * ���x�������ɓ������ڂ�ǉ����܂��B
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
      ACFrame.debugStart(new ACAffairInfo(QO004119Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QO004119Design getThis() {
    return this;
  }
}
