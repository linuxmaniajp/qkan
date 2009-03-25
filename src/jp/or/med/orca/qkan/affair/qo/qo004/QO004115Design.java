
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
 * �쐬��: 2009/03/11  ���{�R���s���[�^�[������� ���{�@�K�� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���̑��@�\ (O)
 * �v���Z�X ���Ǝғo�^ (004)
 * �v���O���� ����{�ݓ����Ґ������ (QO004115)
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
 * ����{�ݓ����Ґ�������ʍ��ڃf�U�C��(QO004115) 
 */
public class QO004115Design extends QO004ProviderPanel {
  //GUI�R���|�[�l���g

  private ACGroupBox mainGroup;

  private ACPanel calculationDetails;

  private ACValueArrayRadioButtonGroup facilitiesDivision;

  private ACLabelContainer facilitiesDivisionContainer;

  private ACListModelAdapter facilitiesDivisionModel;

  private ACRadioButtonItem facilitiesDivisionItem1;

  private ACRadioButtonItem facilitiesDivisionItem2;

  private ACRadioButtonItem facilitiesDivisionItem3;

  private ACRadioButtonItem facilitiesDivisionItem4;

  private ACRadioButtonItem facilitiesDivisionItem5;

  private ACRadioButtonItem facilitiesDivisionItem6;

  private ACRadioButtonItem facilitiesDivisionItem7;

  private ACRadioButtonItem facilitiesDivisionItem8;

  private ACClearableRadioButtonGroup staffAssignmentDivision;

  private ACLabelContainer staffAssignmentDivisionContainer;

  private ACListModelAdapter staffAssignmentDivisionModel;

  private ACRadioButtonItem staffAssignmentDivisionItem1;

  private ACRadioButtonItem staffAssignmentDivisionItem2;

  private ACClearableRadioButtonGroup staffLack;

  private ACLabelContainer staffLackContainer;

  private ACListModelAdapter staffLackModel;

  private ACRadioButtonItem staffLackItem1;

  private ACRadioButtonItem staffLackItem2;

  private ACRadioButtonItem staffLackItem3;

  private ACClearableRadioButtonGroup functionTrainingGuidanceSystem;

  private ACLabelContainer functionTrainingGuidanceSystemContainer;

  private ACListModelAdapter functionTrainingGuidanceSystemModel;

  private ACRadioButtonItem functionTrainingGuidanceSystemItem1;

  private ACRadioButtonItem functionTrainingGuidanceSystemItem2;

  private ACClearableRadioButtonGroup nightNursingSystemAdd;

  private ACLabelContainer nightNursingSystemAddContainer;

  private ACListModelAdapter nightNursingSystemAddModel;

  private ACRadioButtonItem nightNursingSystemAddItem1;

  private ACRadioButtonItem nightNursingSystemAddItem2;

  private ACLabelContainer reduceRateContainer;

  private ACTextField reduceRate;

  private ACLabel percentSign;

  private ACPanel oldLowElementArea;

  private ACGroupBox oldLowH2103Group;

  private ACClearableRadioButtonGroup facilitiesDivision_H2103;

  private ACLabelContainer facilitiesDivision_H2103Container;

  private ACListModelAdapter facilitiesDivision_H2103Model;

  private ACRadioButtonItem facilitiesDivisionItem1_H2103;

  private ACRadioButtonItem facilitiesDivisionItem2_H2103;

  private ACRadioButtonItem facilitiesDivisionItem3_H2103;

  private ACRadioButtonItem facilitiesDivisionItem4_H2103;

  //getter

  /**
   * ���ƃO���[�v���擾���܂��B
   * @return ���ƃO���[�v
   */
  public ACGroupBox getMainGroup(){
    if(mainGroup==null){

      mainGroup = new ACGroupBox();

      mainGroup.setText("����{�ݓ����Ґ������");

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
   * �{�ݓ��̋敪���W�I�O���[�v���擾���܂��B
   * @return �{�ݓ��̋敪���W�I�O���[�v
   */
  public ACValueArrayRadioButtonGroup getFacilitiesDivision(){
    if(facilitiesDivision==null){

      facilitiesDivision = new ACValueArrayRadioButtonGroup();

      getFacilitiesDivisionContainer().setText("�{�ݓ��̋敪");

      facilitiesDivision.setBindPath("1330108");

      facilitiesDivision.setNoSelectIndex(0);

      facilitiesDivision.setUseClearButton(false);

      facilitiesDivision.setModel(getFacilitiesDivisionModel());

      facilitiesDivision.setValues(new int[]{1,2,3,4,5,6,7,8});

      addFacilitiesDivision();
    }
    return facilitiesDivision;

  }

  /**
   * �{�ݓ��̋敪���W�I�O���[�v�R���e�i���擾���܂��B
   * @return �{�ݓ��̋敪���W�I�O���[�v�R���e�i
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
   * �{�ݓ��̋敪���W�I�O���[�v���f�����擾���܂��B
   * @return �{�ݓ��̋敪���W�I�O���[�v���f��
   */
  protected ACListModelAdapter getFacilitiesDivisionModel(){
    if(facilitiesDivisionModel==null){
      facilitiesDivisionModel = new ACListModelAdapter();
      addFacilitiesDivisionModel();
    }
    return facilitiesDivisionModel;
  }

  /**
   * �L���V�l�z�[���i����p�^�j���擾���܂��B
   * @return �L���V�l�z�[���i����p�^�j
   */
  public ACRadioButtonItem getFacilitiesDivisionItem1(){
    if(facilitiesDivisionItem1==null){

      facilitiesDivisionItem1 = new ACRadioButtonItem();

      facilitiesDivisionItem1.setText("�L���V�l�z�[���i����p�^�j");

      facilitiesDivisionItem1.setGroup(getFacilitiesDivision());

      facilitiesDivisionItem1.setConstraints(VRLayout.FLOW_RETURN);

      addFacilitiesDivisionItem1();
    }
    return facilitiesDivisionItem1;

  }

  /**
   * �y��V�l�z�[���i����p�^�j���擾���܂��B
   * @return �y��V�l�z�[���i����p�^�j
   */
  public ACRadioButtonItem getFacilitiesDivisionItem2(){
    if(facilitiesDivisionItem2==null){

      facilitiesDivisionItem2 = new ACRadioButtonItem();

      facilitiesDivisionItem2.setText("�y��V�l�z�[���i����p�^�j");

      facilitiesDivisionItem2.setGroup(getFacilitiesDivision());

      facilitiesDivisionItem2.setConstraints(VRLayout.FLOW_RETURN);

      addFacilitiesDivisionItem2();
    }
    return facilitiesDivisionItem2;

  }

  /**
   * �{��V�l�z�[���i����p�^�j���擾���܂��B
   * @return �{��V�l�z�[���i����p�^�j
   */
  public ACRadioButtonItem getFacilitiesDivisionItem3(){
    if(facilitiesDivisionItem3==null){

      facilitiesDivisionItem3 = new ACRadioButtonItem();

      facilitiesDivisionItem3.setText("�{��V�l�z�[���i����p�^�j");

      facilitiesDivisionItem3.setGroup(getFacilitiesDivision());

      facilitiesDivisionItem3.setConstraints(VRLayout.FLOW_RETURN);

      addFacilitiesDivisionItem3();
    }
    return facilitiesDivisionItem3;

  }

  /**
   * ����Ґ�p���ݏZ��i����p�^�j���擾���܂��B
   * @return ����Ґ�p���ݏZ��i����p�^�j
   */
  public ACRadioButtonItem getFacilitiesDivisionItem4(){
    if(facilitiesDivisionItem4==null){

      facilitiesDivisionItem4 = new ACRadioButtonItem();

      facilitiesDivisionItem4.setText("����Ґ�p���ݏZ��i����p�^�j");

      facilitiesDivisionItem4.setGroup(getFacilitiesDivision());

      facilitiesDivisionItem4.setConstraints(VRLayout.FLOW_RETURN);

      addFacilitiesDivisionItem4();
    }
    return facilitiesDivisionItem4;

  }

  /**
   * �L���V�l�z�[���i�����^�j���擾���܂��B
   * @return �L���V�l�z�[���i�����^�j
   */
  public ACRadioButtonItem getFacilitiesDivisionItem5(){
    if(facilitiesDivisionItem5==null){

      facilitiesDivisionItem5 = new ACRadioButtonItem();

      facilitiesDivisionItem5.setText("�L���V�l�z�[���i�����^�j");

      facilitiesDivisionItem5.setGroup(getFacilitiesDivision());

      facilitiesDivisionItem5.setConstraints(VRLayout.FLOW_RETURN);

      addFacilitiesDivisionItem5();
    }
    return facilitiesDivisionItem5;

  }

  /**
   * �y��V�l�z�[���i�����^�j���擾���܂��B
   * @return �y��V�l�z�[���i�����^�j
   */
  public ACRadioButtonItem getFacilitiesDivisionItem6(){
    if(facilitiesDivisionItem6==null){

      facilitiesDivisionItem6 = new ACRadioButtonItem();

      facilitiesDivisionItem6.setText("�y��V�l�z�[���i�����^�j");

      facilitiesDivisionItem6.setGroup(getFacilitiesDivision());

      facilitiesDivisionItem6.setConstraints(VRLayout.FLOW_RETURN);

      addFacilitiesDivisionItem6();
    }
    return facilitiesDivisionItem6;

  }

  /**
   * �{��V�l�z�[���i�����^�j���擾���܂��B
   * @return �{��V�l�z�[���i�����^�j
   */
  public ACRadioButtonItem getFacilitiesDivisionItem7(){
    if(facilitiesDivisionItem7==null){

      facilitiesDivisionItem7 = new ACRadioButtonItem();

      facilitiesDivisionItem7.setText("�{��V�l�z�[���i�����^�j");

      facilitiesDivisionItem7.setGroup(getFacilitiesDivision());

      facilitiesDivisionItem7.setConstraints(VRLayout.FLOW_RETURN);

      addFacilitiesDivisionItem7();
    }
    return facilitiesDivisionItem7;

  }

  /**
   * ����Ґ�p���ݏZ��i�����^�j���擾���܂��B
   * @return ����Ґ�p���ݏZ��i�����^�j
   */
  public ACRadioButtonItem getFacilitiesDivisionItem8(){
    if(facilitiesDivisionItem8==null){

      facilitiesDivisionItem8 = new ACRadioButtonItem();

      facilitiesDivisionItem8.setText("����Ґ�p���ݏZ��i�����^�j");

      facilitiesDivisionItem8.setGroup(getFacilitiesDivision());

      facilitiesDivisionItem8.setConstraints(VRLayout.FLOW);

      addFacilitiesDivisionItem8();
    }
    return facilitiesDivisionItem8;

  }

  /**
   * �l���z�u�敪���W�I�O���[�v���擾���܂��B
   * @return �l���z�u�敪���W�I�O���[�v
   */
  public ACClearableRadioButtonGroup getStaffAssignmentDivision(){
    if(staffAssignmentDivision==null){

      staffAssignmentDivision = new ACClearableRadioButtonGroup();

      getStaffAssignmentDivisionContainer().setText("�l���z�u�敪");

      staffAssignmentDivision.setBindPath("1330103");

      staffAssignmentDivision.setUseClearButton(false);

      staffAssignmentDivision.setModel(getStaffAssignmentDivisionModel());

      addStaffAssignmentDivision();
    }
    return staffAssignmentDivision;

  }

  /**
   * �l���z�u�敪���W�I�O���[�v�R���e�i���擾���܂��B
   * @return �l���z�u�敪���W�I�O���[�v�R���e�i
   */
  protected ACLabelContainer getStaffAssignmentDivisionContainer(){
    if(staffAssignmentDivisionContainer==null){
      staffAssignmentDivisionContainer = new ACLabelContainer();
      staffAssignmentDivisionContainer.setFollowChildEnabled(true);
      staffAssignmentDivisionContainer.setVAlignment(VRLayout.CENTER);
      staffAssignmentDivisionContainer.add(getStaffAssignmentDivision(), null);
    }
    return staffAssignmentDivisionContainer;
  }

  /**
   * �l���z�u�敪���W�I�O���[�v���f�����擾���܂��B
   * @return �l���z�u�敪���W�I�O���[�v���f��
   */
  protected ACListModelAdapter getStaffAssignmentDivisionModel(){
    if(staffAssignmentDivisionModel==null){
      staffAssignmentDivisionModel = new ACListModelAdapter();
      addStaffAssignmentDivisionModel();
    }
    return staffAssignmentDivisionModel;
  }

  /**
   * ��ʌ^���擾���܂��B
   * @return ��ʌ^
   */
  public ACRadioButtonItem getStaffAssignmentDivisionItem1(){
    if(staffAssignmentDivisionItem1==null){

      staffAssignmentDivisionItem1 = new ACRadioButtonItem();

      staffAssignmentDivisionItem1.setText("��ʌ^");

      staffAssignmentDivisionItem1.setGroup(getStaffAssignmentDivision());

      staffAssignmentDivisionItem1.setConstraints(VRLayout.FLOW);

      addStaffAssignmentDivisionItem1();
    }
    return staffAssignmentDivisionItem1;

  }

  /**
   * �O���T�[�r�X���p�^���擾���܂��B
   * @return �O���T�[�r�X���p�^
   */
  public ACRadioButtonItem getStaffAssignmentDivisionItem2(){
    if(staffAssignmentDivisionItem2==null){

      staffAssignmentDivisionItem2 = new ACRadioButtonItem();

      staffAssignmentDivisionItem2.setText("�O���T�[�r�X���p�^");

      staffAssignmentDivisionItem2.setGroup(getStaffAssignmentDivision());

      staffAssignmentDivisionItem2.setConstraints(VRLayout.FLOW);

      addStaffAssignmentDivisionItem2();
    }
    return staffAssignmentDivisionItem2;

  }

  /**
   * �E���̌����ɂ�錸�Z�̏󋵃��W�I�O���[�v���擾���܂��B
   * @return �E���̌����ɂ�錸�Z�̏󋵃��W�I�O���[�v
   */
  public ACClearableRadioButtonGroup getStaffLack(){
    if(staffLack==null){

      staffLack = new ACClearableRadioButtonGroup();

      getStaffLackContainer().setText("�E���̌����ɂ�錸�Z�̏�");

      staffLack.setBindPath("1330102");

      staffLack.setUseClearButton(false);

      staffLack.setModel(getStaffLackModel());

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
   * �ʋ@�\�P���̐����W�I�O���[�v���擾���܂��B
   * @return �ʋ@�\�P���̐����W�I�O���[�v
   */
  public ACClearableRadioButtonGroup getFunctionTrainingGuidanceSystem(){
    if(functionTrainingGuidanceSystem==null){

      functionTrainingGuidanceSystem = new ACClearableRadioButtonGroup();

      getFunctionTrainingGuidanceSystemContainer().setText("�ʋ@�\�P���̐�");

      functionTrainingGuidanceSystem.setBindPath("1330101");

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
   * ��ԊŌ�̐����擾���܂��B
   * @return ��ԊŌ�̐�
   */
  public ACClearableRadioButtonGroup getNightNursingSystemAdd(){
    if(nightNursingSystemAdd==null){

      nightNursingSystemAdd = new ACClearableRadioButtonGroup();

      getNightNursingSystemAddContainer().setText("��ԊŌ�̐�");

      nightNursingSystemAdd.setBindPath("1330104");

      nightNursingSystemAdd.setUseClearButton(false);

      nightNursingSystemAdd.setModel(getNightNursingSystemAddModel());

      addNightNursingSystemAdd();
    }
    return nightNursingSystemAdd;

  }

  /**
   * ��ԊŌ�̐��R���e�i���擾���܂��B
   * @return ��ԊŌ�̐��R���e�i
   */
  protected ACLabelContainer getNightNursingSystemAddContainer(){
    if(nightNursingSystemAddContainer==null){
      nightNursingSystemAddContainer = new ACLabelContainer();
      nightNursingSystemAddContainer.setFollowChildEnabled(true);
      nightNursingSystemAddContainer.setVAlignment(VRLayout.CENTER);
      nightNursingSystemAddContainer.add(getNightNursingSystemAdd(), null);
    }
    return nightNursingSystemAddContainer;
  }

  /**
   * ��ԊŌ�̐����f�����擾���܂��B
   * @return ��ԊŌ�̐����f��
   */
  protected ACListModelAdapter getNightNursingSystemAddModel(){
    if(nightNursingSystemAddModel==null){
      nightNursingSystemAddModel = new ACListModelAdapter();
      addNightNursingSystemAddModel();
    }
    return nightNursingSystemAddModel;
  }

  /**
   * �Ή��s���擾���܂��B
   * @return �Ή��s��
   */
  public ACRadioButtonItem getNightNursingSystemAddItem1(){
    if(nightNursingSystemAddItem1==null){

      nightNursingSystemAddItem1 = new ACRadioButtonItem();

      nightNursingSystemAddItem1.setText("�Ή��s��");

      nightNursingSystemAddItem1.setGroup(getNightNursingSystemAdd());

      nightNursingSystemAddItem1.setConstraints(VRLayout.FLOW);

      addNightNursingSystemAddItem1();
    }
    return nightNursingSystemAddItem1;

  }

  /**
   * �Ή����擾���܂��B
   * @return �Ή���
   */
  public ACRadioButtonItem getNightNursingSystemAddItem2(){
    if(nightNursingSystemAddItem2==null){

      nightNursingSystemAddItem2 = new ACRadioButtonItem();

      nightNursingSystemAddItem2.setText("�Ή���");

      nightNursingSystemAddItem2.setGroup(getNightNursingSystemAdd());

      nightNursingSystemAddItem2.setConstraints(VRLayout.FLOW);

      addNightNursingSystemAddItem2();
    }
    return nightNursingSystemAddItem2;

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
   * �{�ݓ��̋敪���W�I�O���[�v���擾���܂��B
   * @return �{�ݓ��̋敪���W�I�O���[�v
   */
  public ACClearableRadioButtonGroup getFacilitiesDivision_H2103(){
    if(facilitiesDivision_H2103==null){

      facilitiesDivision_H2103 = new ACClearableRadioButtonGroup();

      getFacilitiesDivision_H2103Container().setText("�{�ݓ��̋敪");

      facilitiesDivision_H2103.setBindPath("1330105");

      facilitiesDivision_H2103.setUseClearButton(false);

      facilitiesDivision_H2103.setModel(getFacilitiesDivision_H2103Model());

      addFacilitiesDivision_H2103();
    }
    return facilitiesDivision_H2103;

  }

  /**
   * �{�ݓ��̋敪���W�I�O���[�v�R���e�i���擾���܂��B
   * @return �{�ݓ��̋敪���W�I�O���[�v�R���e�i
   */
  protected ACLabelContainer getFacilitiesDivision_H2103Container(){
    if(facilitiesDivision_H2103Container==null){
      facilitiesDivision_H2103Container = new ACLabelContainer();
      facilitiesDivision_H2103Container.setFollowChildEnabled(true);
      facilitiesDivision_H2103Container.setVAlignment(VRLayout.CENTER);
      facilitiesDivision_H2103Container.add(getFacilitiesDivision_H2103(), null);
    }
    return facilitiesDivision_H2103Container;
  }

  /**
   * �{�ݓ��̋敪���W�I�O���[�v���f�����擾���܂��B
   * @return �{�ݓ��̋敪���W�I�O���[�v���f��
   */
  protected ACListModelAdapter getFacilitiesDivision_H2103Model(){
    if(facilitiesDivision_H2103Model==null){
      facilitiesDivision_H2103Model = new ACListModelAdapter();
      addFacilitiesDivision_H2103Model();
    }
    return facilitiesDivision_H2103Model;
  }

  /**
   * �L���V�l�z�[�����擾���܂��B
   * @return �L���V�l�z�[��
   */
  public ACRadioButtonItem getFacilitiesDivisionItem1_H2103(){
    if(facilitiesDivisionItem1_H2103==null){

      facilitiesDivisionItem1_H2103 = new ACRadioButtonItem();

      facilitiesDivisionItem1_H2103.setText("�L���V�l�z�[��");

      facilitiesDivisionItem1_H2103.setGroup(getFacilitiesDivision_H2103());

      facilitiesDivisionItem1_H2103.setConstraints(VRLayout.FLOW);

      addFacilitiesDivisionItem1_H2103();
    }
    return facilitiesDivisionItem1_H2103;

  }

  /**
   * �y��V�l�z�[�����擾���܂��B
   * @return �y��V�l�z�[��
   */
  public ACRadioButtonItem getFacilitiesDivisionItem2_H2103(){
    if(facilitiesDivisionItem2_H2103==null){

      facilitiesDivisionItem2_H2103 = new ACRadioButtonItem();

      facilitiesDivisionItem2_H2103.setText("�y��V�l�z�[��");

      facilitiesDivisionItem2_H2103.setGroup(getFacilitiesDivision_H2103());

      facilitiesDivisionItem2_H2103.setConstraints(VRLayout.FLOW_RETURN);

      addFacilitiesDivisionItem2_H2103();
    }
    return facilitiesDivisionItem2_H2103;

  }

  /**
   * �{��V�l�z�[�����擾���܂��B
   * @return �{��V�l�z�[��
   */
  public ACRadioButtonItem getFacilitiesDivisionItem3_H2103(){
    if(facilitiesDivisionItem3_H2103==null){

      facilitiesDivisionItem3_H2103 = new ACRadioButtonItem();

      facilitiesDivisionItem3_H2103.setText("�{��V�l�z�[��");

      facilitiesDivisionItem3_H2103.setGroup(getFacilitiesDivision_H2103());

      facilitiesDivisionItem3_H2103.setConstraints(VRLayout.FLOW);

      addFacilitiesDivisionItem3_H2103();
    }
    return facilitiesDivisionItem3_H2103;

  }

  /**
   * ����Ґ�p���ݏZ����擾���܂��B
   * @return ����Ґ�p���ݏZ��
   */
  public ACRadioButtonItem getFacilitiesDivisionItem4_H2103(){
    if(facilitiesDivisionItem4_H2103==null){

      facilitiesDivisionItem4_H2103 = new ACRadioButtonItem();

      facilitiesDivisionItem4_H2103.setText("����Ґ�p���ݏZ��");

      facilitiesDivisionItem4_H2103.setGroup(getFacilitiesDivision_H2103());

      facilitiesDivisionItem4_H2103.setConstraints(VRLayout.FLOW);

      addFacilitiesDivisionItem4_H2103();
    }
    return facilitiesDivisionItem4_H2103;

  }

  /**
   * �R���X�g���N�^�ł��B
   */
  public QO004115Design() {

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

    mainGroup.add(getOldLowElementArea(), VRLayout.FLOW_RETURN);

  }

  /**
   * �Z�荀�ڗ̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalculationDetails(){

    calculationDetails.add(getFacilitiesDivisionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails.add(getStaffAssignmentDivisionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails.add(getStaffLackContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails.add(getFunctionTrainingGuidanceSystemContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails.add(getNightNursingSystemAddContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails.add(getReduceRateContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * �{�ݓ��̋敪���W�I�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addFacilitiesDivision(){

  }

  /**
   * �{�ݓ��̋敪���W�I�O���[�v���f���ɓ������ڂ�ǉ����܂��B
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

    getFacilitiesDivisionItem7().setButtonIndex(7);

    getFacilitiesDivisionModel().add(getFacilitiesDivisionItem7());

    getFacilitiesDivisionItem8().setButtonIndex(8);

    getFacilitiesDivisionModel().add(getFacilitiesDivisionItem8());

  }

  /**
   * �L���V�l�z�[���i����p�^�j�ɓ������ڂ�ǉ����܂��B
   */
  protected void addFacilitiesDivisionItem1(){

  }

  /**
   * �y��V�l�z�[���i����p�^�j�ɓ������ڂ�ǉ����܂��B
   */
  protected void addFacilitiesDivisionItem2(){

  }

  /**
   * �{��V�l�z�[���i����p�^�j�ɓ������ڂ�ǉ����܂��B
   */
  protected void addFacilitiesDivisionItem3(){

  }

  /**
   * ����Ґ�p���ݏZ��i����p�^�j�ɓ������ڂ�ǉ����܂��B
   */
  protected void addFacilitiesDivisionItem4(){

  }

  /**
   * �L���V�l�z�[���i�����^�j�ɓ������ڂ�ǉ����܂��B
   */
  protected void addFacilitiesDivisionItem5(){

  }

  /**
   * �y��V�l�z�[���i�����^�j�ɓ������ڂ�ǉ����܂��B
   */
  protected void addFacilitiesDivisionItem6(){

  }

  /**
   * �{��V�l�z�[���i�����^�j�ɓ������ڂ�ǉ����܂��B
   */
  protected void addFacilitiesDivisionItem7(){

  }

  /**
   * ����Ґ�p���ݏZ��i�����^�j�ɓ������ڂ�ǉ����܂��B
   */
  protected void addFacilitiesDivisionItem8(){

  }

  /**
   * �l���z�u�敪���W�I�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffAssignmentDivision(){

  }

  /**
   * �l���z�u�敪���W�I�O���[�v���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffAssignmentDivisionModel(){

    getStaffAssignmentDivisionItem1().setButtonIndex(1);

    getStaffAssignmentDivisionModel().add(getStaffAssignmentDivisionItem1());

    getStaffAssignmentDivisionItem2().setButtonIndex(2);

    getStaffAssignmentDivisionModel().add(getStaffAssignmentDivisionItem2());

  }

  /**
   * ��ʌ^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffAssignmentDivisionItem1(){

  }

  /**
   * �O���T�[�r�X���p�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffAssignmentDivisionItem2(){

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
   * ��ԊŌ�̐��ɓ������ڂ�ǉ����܂��B
   */
  protected void addNightNursingSystemAdd(){

  }

  /**
   * ��ԊŌ�̐����f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addNightNursingSystemAddModel(){

    getNightNursingSystemAddItem1().setButtonIndex(1);

    getNightNursingSystemAddModel().add(getNightNursingSystemAddItem1());

    getNightNursingSystemAddItem2().setButtonIndex(2);

    getNightNursingSystemAddModel().add(getNightNursingSystemAddItem2());

  }

  /**
   * �Ή��s�ɓ������ڂ�ǉ����܂��B
   */
  protected void addNightNursingSystemAddItem1(){

  }

  /**
   * �Ή��ɓ������ڂ�ǉ����܂��B
   */
  protected void addNightNursingSystemAddItem2(){

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
   * ���@���ڂɓ������ڂ�ǉ����܂��B
   */
  protected void addOldLowElementArea(){

    oldLowElementArea.add(getOldLowH2103Group(), VRLayout.NORTH);

  }

  /**
   * ����21�N3���ȑO�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addOldLowH2103Group(){

    oldLowH2103Group.add(getFacilitiesDivision_H2103Container(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * �{�ݓ��̋敪���W�I�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addFacilitiesDivision_H2103(){

  }

  /**
   * �{�ݓ��̋敪���W�I�O���[�v���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addFacilitiesDivision_H2103Model(){

    getFacilitiesDivisionItem1_H2103().setButtonIndex(1);

    getFacilitiesDivision_H2103Model().add(getFacilitiesDivisionItem1_H2103());

    getFacilitiesDivisionItem2_H2103().setButtonIndex(2);

    getFacilitiesDivision_H2103Model().add(getFacilitiesDivisionItem2_H2103());

    getFacilitiesDivisionItem3_H2103().setButtonIndex(3);

    getFacilitiesDivision_H2103Model().add(getFacilitiesDivisionItem3_H2103());

    getFacilitiesDivisionItem4_H2103().setButtonIndex(4);

    getFacilitiesDivision_H2103Model().add(getFacilitiesDivisionItem4_H2103());

  }

  /**
   * �L���V�l�z�[���ɓ������ڂ�ǉ����܂��B
   */
  protected void addFacilitiesDivisionItem1_H2103(){

  }

  /**
   * �y��V�l�z�[���ɓ������ڂ�ǉ����܂��B
   */
  protected void addFacilitiesDivisionItem2_H2103(){

  }

  /**
   * �{��V�l�z�[���ɓ������ڂ�ǉ����܂��B
   */
  protected void addFacilitiesDivisionItem3_H2103(){

  }

  /**
   * ����Ґ�p���ݏZ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addFacilitiesDivisionItem4_H2103(){

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
      ACFrame.debugStart(new ACAffairInfo(QO004115Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QO004115Design getThis() {
    return this;
  }
}
