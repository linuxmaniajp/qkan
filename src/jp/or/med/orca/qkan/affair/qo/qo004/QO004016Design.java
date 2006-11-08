
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
 * �J����: ���}�@�M�u
 * �쐬��: 2006/02/18  ���{�R���s���[�^�[������� ���}�@�M�u �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���̑��@�\ (O)
 * �v���Z�X ���Ǝғo�^ (004)
 * �v���O���� ���V�l�����{�� (QO004016)
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
import jp.or.med.orca.qkan.component.*;
import jp.or.med.orca.qkan.text.*;
/**
 * ���V�l�����{�݉�ʍ��ڃf�U�C��(QO004016) 
 */
public class QO004016Design extends ACPanel {
  //GUI�R���|�[�l���g

  private ACGroupBox agedPeopleWelfareFacilityGroup;

  private ACLabelContainer agedPeopleWelfareFacilityDiscountcontainer;

  private ACTextField agedPeopleWelfareFacilityDiscountRate;

  private ACLabel percentSign;

  private ACClearableRadioButtonGroup agedPeopleWelfareFacilitiesDivision;

  private ACLabelContainer agedPeopleWelfareFacilitiesDivisionContainer;

  private ACListModelAdapter agedPeopleWelfareFacilitiesDivisionModel;

  private VRLayout agedPeopleWelfareFacilitiesDivisionLayout;

  private ACRadioButtonItem welfareFacility1;

  private ACRadioButtonItem welfareFacility2;

  private ACRadioButtonItem welfareFacility3;

  private ACRadioButtonItem welfareFacility4;

  private ACClearableRadioButtonGroup nightShiftCondition;

  private ACLabelContainer nightShiftConditionContainer;

  private ACListModelAdapter nightShiftConditionModel;

  private ACRadioButtonItem nightShiftConditionStandard;

  private ACRadioButtonItem nightShiftConditionSubtraction;

  private ACClearableRadioButtonGroup functionTrainingGuidanceSystem;

  private ACLabelContainer functionTrainingGuidanceSystemContainer;

  private ACListModelAdapter functionTrainingGuidanceSystemModel;

  private ACRadioButtonItem functionTrainingGuidanceSystemOff;

  private ACRadioButtonItem functionTrainingGuidanceSystemOn;

  private ACClearableRadioButtonGroup standingDoctorArrangement;

  private ACLabelContainer standingDoctorArrangementContainer;

  private ACListModelAdapter standingDoctorArrangementModel;

  private ACRadioButtonItem standingDoctorArrangementOff;

  private ACRadioButtonItem standingDoctorArrangementOn;

  private ACClearableRadioButtonGroup psychiatristMaster;

  private ACLabelContainer psychiatristMasterContainer;

  private ACListModelAdapter psychiatristMasterModel;

  private ACRadioButtonItem psychiatristMasterOff;

  private ACRadioButtonItem psychiatristMasterOn;

  private ACClearableRadioButtonGroup handicappedPersonSupport;

  private ACLabelContainer handicappedPersonSupportContainer;

  private ACListModelAdapter handicappedPersonSupportModel;

  private ACRadioButtonItem handicappedPersonSupportOff;

  private ACRadioButtonItem handicappedPersonSupportOn;

  private ACClearableRadioButtonGroup nutritionManageRadio;

  private ACLabelContainer nutritionManageRadioContainer;

  private ACListModelAdapter nutritionManageRadioModel;

  private ACRadioButtonItem nutritionManageRadioItem1;

  private ACRadioButtonItem nutritionManageRadioItem2;

  private ACClearableRadioButtonGroup nutritionRadio;

  private ACLabelContainer nutritionRadioContainer;

  private ACListModelAdapter nutritionRadioModel;

  private ACRadioButtonItem nutritionRadioItem1;

  private ACRadioButtonItem nutritionRadioItem2 ;

  private ACClearableRadioButtonGroup oralSwitchRadio;

  private ACLabelContainer oralSwitchRadioContainer;

  private ACListModelAdapter oralSwitchRadioModel;

  private ACRadioButtonItem oralSwitchRadioItem1;

  private ACRadioButtonItem oralSwitchRadioItem2 ;

  private ACClearableRadioButtonGroup recuperateDinnerRadio;

  private ACLabelContainer recuperateDinnerRadioContainer;

  private ACListModelAdapter recuperateDinnerRadioModel;

  private ACRadioButtonItem recuperateDinnerRadioItem1;

  private ACRadioButtonItem recuperateDinnerRadioItem2;

  private ACClearableRadioButtonGroup staffLack;

  private ACLabelContainer staffLackContainer;

  private ACListModelAdapter staffLackModel;

  private ACRadioButtonItem staffLackOff;

  private ACRadioButtonItem staffLackStaffExcess;

  private ACRadioButtonItem staffLackKaigo;

  private ACLabelContainer careOldPepleWelfareFacilitiesDinnerStandeirdMoneyConteiner;

  private ACTextField careOldPepleWelfareFacilitiesDinnerStandeirdMoneyTotal;

  private ACLabel careOldPepleWelfareFacilitiesMorningDinnerStandeirdMoneyLabel;

  private ACTextField careOldPepleWelfareFacilitiesMorningDinnerStandeirdMoney;

  private ACLabel careOldPepleWelfareFacilitiesNoonDinnerStandeirdMoneyLabel;

  private ACTextField careOldPepleWelfareFacilitiesNoonDinnerStandeirdMoney;

  private ACLabel careOldPepleWelfareFacilitiesNightDinnerStandeirdMoneyLabel;

  private ACTextField careOldPepleWelfareFacilitiesNightDinnerStandeirdMoney;

  private ACLabel careOldPepleWelfareFacilitiesDinnerStandeirdMoney4Label;

  private ACLabelContainer careOldPepleWelfareFacilitiesUnitRoomStandeirdMoneyConteiner;

  private ACTextField careOldPepleWelfareFacilitiesUnitRoomStandeirdMoneyText;

  private ACLabel careOldPepleWelfareFacilitiesUnitRoomStandeirdMoneyLabel;

  private ACLabelContainer careOldPepleWelfareFacilitiesUnitSemiRoomStandeirdMoneyConteiner;

  private ACTextField careOldPepleWelfareFacilitiesUnitSemiRoomStandeirdMoneyText;

  private ACLabel careOldPepleWelfareFacilitiesUnitSemiRoomStandeirdMoneyLabel;

  private ACLabelContainer careOldPepleWelfareFacilitiesNormalRoomStandeirdMoneyConteiner;

  private ACTextField careOldPepleWelfareFacilitiesNormalRoomStandeirdMoneyText;

  private ACLabel careOldPepleWelfareFacilitiesNormalRoomStandeirdMoneyLabel;

  private ACLabelContainer careOldPepleWelfareFacilitiesTasyouRoomConteiner;

  private ACTextField careOldPepleWelfareFacilitiesTasyouRoomText;

  private ACLabel careOldPepleWelfareFacilitiesTasyouRoomLabel;

  //getter

  /**
   * ���ƃO���[�v���擾���܂��B
   * @return ���ƃO���[�v
   */
  public ACGroupBox getAgedPeopleWelfareFacilityGroup(){
    if(agedPeopleWelfareFacilityGroup==null){

      agedPeopleWelfareFacilityGroup = new ACGroupBox();

      agedPeopleWelfareFacilityGroup.setText("���V�l�����{��");

      agedPeopleWelfareFacilityGroup.setFollowChildEnabled(true);

      agedPeopleWelfareFacilityGroup.setHgrid(500);

      addAgedPeopleWelfareFacilityGroup();
    }
    return agedPeopleWelfareFacilityGroup;

  }

  /**
   * �������R���e�i���擾���܂��B
   * @return �������R���e�i
   */
  public ACLabelContainer getAgedPeopleWelfareFacilityDiscountcontainer(){
    if(agedPeopleWelfareFacilityDiscountcontainer==null){

      agedPeopleWelfareFacilityDiscountcontainer = new ACLabelContainer();

      agedPeopleWelfareFacilityDiscountcontainer.setText("������");

      agedPeopleWelfareFacilityDiscountcontainer.setFollowChildEnabled(true);

      addAgedPeopleWelfareFacilityDiscountcontainer();
    }
    return agedPeopleWelfareFacilityDiscountcontainer;

  }

  /**
   * ���������擾���܂��B
   * @return ������
   */
  public ACTextField getAgedPeopleWelfareFacilityDiscountRate(){
    if(agedPeopleWelfareFacilityDiscountRate==null){

      agedPeopleWelfareFacilityDiscountRate = new ACTextField();

      agedPeopleWelfareFacilityDiscountRate.setBindPath("REDUCT_RATE");

      agedPeopleWelfareFacilityDiscountRate.setColumns(3);

      agedPeopleWelfareFacilityDiscountRate.setCharType(VRCharType.ONLY_DIGIT);

      agedPeopleWelfareFacilityDiscountRate.setHorizontalAlignment(SwingConstants.RIGHT);

      agedPeopleWelfareFacilityDiscountRate.setIMEMode(InputSubset.LATIN);

      agedPeopleWelfareFacilityDiscountRate.setMaxLength(3);

      addAgedPeopleWelfareFacilityDiscountRate();
    }
    return agedPeopleWelfareFacilityDiscountRate;

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
   * �{�݋敪���W�I�O���[�v���擾���܂��B
   * @return �{�݋敪���W�I�O���[�v
   */
  public ACClearableRadioButtonGroup getAgedPeopleWelfareFacilitiesDivision(){
    if(agedPeopleWelfareFacilitiesDivision==null){

      agedPeopleWelfareFacilitiesDivision = new ACClearableRadioButtonGroup();

      getAgedPeopleWelfareFacilitiesDivisionContainer().setText("�{�݋敪");

      agedPeopleWelfareFacilitiesDivision.setBindPath("1510101");

      agedPeopleWelfareFacilitiesDivision.setLayout(getAgedPeopleWelfareFacilitiesDivisionLayout());

      agedPeopleWelfareFacilitiesDivision.setModel(getAgedPeopleWelfareFacilitiesDivisionModel());

      agedPeopleWelfareFacilitiesDivision.setUseClearButton(false);

      addAgedPeopleWelfareFacilitiesDivision();
    }
    return agedPeopleWelfareFacilitiesDivision;

  }

  /**
   * �{�݋敪���W�I�O���[�v�R���e�i���擾���܂��B
   * @return �{�݋敪���W�I�O���[�v�R���e�i
   */
  protected ACLabelContainer getAgedPeopleWelfareFacilitiesDivisionContainer(){
    if(agedPeopleWelfareFacilitiesDivisionContainer==null){
      agedPeopleWelfareFacilitiesDivisionContainer = new ACLabelContainer();
      agedPeopleWelfareFacilitiesDivisionContainer.setFollowChildEnabled(true);
      agedPeopleWelfareFacilitiesDivisionContainer.add(getAgedPeopleWelfareFacilitiesDivision(), null);
    }
    return agedPeopleWelfareFacilitiesDivisionContainer;
  }

  /**
   * �{�݋敪���W�I�O���[�v���f�����擾���܂��B
   * @return �{�݋敪���W�I�O���[�v���f��
   */
  protected ACListModelAdapter getAgedPeopleWelfareFacilitiesDivisionModel(){
    if(agedPeopleWelfareFacilitiesDivisionModel==null){
      agedPeopleWelfareFacilitiesDivisionModel = new ACListModelAdapter();
      addAgedPeopleWelfareFacilitiesDivisionModel();
    }
    return agedPeopleWelfareFacilitiesDivisionModel;
  }

  /**
   * �{�ݓ��̋敪���W�I�O���[�v���C�A�E�g���擾���܂��B
   * @return �{�ݓ��̋敪���W�I�O���[�v���C�A�E�g
   */
  public VRLayout getAgedPeopleWelfareFacilitiesDivisionLayout(){
    if(agedPeopleWelfareFacilitiesDivisionLayout==null){

      agedPeopleWelfareFacilitiesDivisionLayout = new VRLayout();

      agedPeopleWelfareFacilitiesDivisionLayout.setAutoWrap(false);

      agedPeopleWelfareFacilitiesDivisionLayout.setHgap(0);

      addAgedPeopleWelfareFacilitiesDivisionLayout();
    }
    return agedPeopleWelfareFacilitiesDivisionLayout;

  }

  /**
   * ��앟���{�݂��擾���܂��B
   * @return ��앟���{��
   */
  public ACRadioButtonItem getWelfareFacility1(){
    if(welfareFacility1==null){

      welfareFacility1 = new ACRadioButtonItem();

      welfareFacility1.setText("��앟���{��");

      welfareFacility1.setGroup(getAgedPeopleWelfareFacilitiesDivision());

      welfareFacility1.setConstraints(VRLayout.FLOW);

      addWelfareFacility1();
    }
    return welfareFacility1;

  }

  /**
   * ���K�͉�앟���{�݂��擾���܂��B
   * @return ���K�͉�앟���{��
   */
  public ACRadioButtonItem getWelfareFacility2(){
    if(welfareFacility2==null){

      welfareFacility2 = new ACRadioButtonItem();

      welfareFacility2.setText("���K�͉�앟���{��");

      welfareFacility2.setGroup(getAgedPeopleWelfareFacilitiesDivision());

      welfareFacility2.setConstraints(VRLayout.FLOW_RETURN);

      addWelfareFacility2();
    }
    return welfareFacility2;

  }

  /**
   * ���j�b�g�^��앟���{�݂��擾���܂��B
   * @return ���j�b�g�^��앟���{��
   */
  public ACRadioButtonItem getWelfareFacility3(){
    if(welfareFacility3==null){

      welfareFacility3 = new ACRadioButtonItem();

      welfareFacility3.setText("���j�b�g�^��앟���{��");

      welfareFacility3.setGroup(getAgedPeopleWelfareFacilitiesDivision());

      welfareFacility3.setConstraints(VRLayout.FLOW);

      addWelfareFacility3();
    }
    return welfareFacility3;

  }

  /**
   * ���j�b�g�^���K�͉�앟���{�݂��擾���܂��B
   * @return ���j�b�g�^���K�͉�앟���{��
   */
  public ACRadioButtonItem getWelfareFacility4(){
    if(welfareFacility4==null){

      welfareFacility4 = new ACRadioButtonItem();

      welfareFacility4.setText("���j�b�g�^���K�͉�앟���{��");

      welfareFacility4.setGroup(getAgedPeopleWelfareFacilitiesDivision());

      welfareFacility4.setConstraints(VRLayout.FLOW);

      addWelfareFacility4();
    }
    return welfareFacility4;

  }

  /**
   * ��ԋΖ���������W�I�O���[�v���擾���܂��B
   * @return ��ԋΖ���������W�I�O���[�v
   */
  public ACClearableRadioButtonGroup getNightShiftCondition(){
    if(nightShiftCondition==null){

      nightShiftCondition = new ACClearableRadioButtonGroup();

      getNightShiftConditionContainer().setText("��ԋΖ������");

      nightShiftCondition.setBindPath("1510102");

      nightShiftCondition.setModel(getNightShiftConditionModel());

      nightShiftCondition.setUseClearButton(false);

      addNightShiftCondition();
    }
    return nightShiftCondition;

  }

  /**
   * ��ԋΖ���������W�I�O���[�v�R���e�i���擾���܂��B
   * @return ��ԋΖ���������W�I�O���[�v�R���e�i
   */
  protected ACLabelContainer getNightShiftConditionContainer(){
    if(nightShiftConditionContainer==null){
      nightShiftConditionContainer = new ACLabelContainer();
      nightShiftConditionContainer.setFollowChildEnabled(true);
      nightShiftConditionContainer.add(getNightShiftCondition(), null);
    }
    return nightShiftConditionContainer;
  }

  /**
   * ��ԋΖ���������W�I�O���[�v���f�����擾���܂��B
   * @return ��ԋΖ���������W�I�O���[�v���f��
   */
  protected ACListModelAdapter getNightShiftConditionModel(){
    if(nightShiftConditionModel==null){
      nightShiftConditionModel = new ACListModelAdapter();
      addNightShiftConditionModel();
    }
    return nightShiftConditionModel;
  }

  /**
   * ��^���擾���܂��B
   * @return ��^
   */
  public ACRadioButtonItem getNightShiftConditionStandard(){
    if(nightShiftConditionStandard==null){

      nightShiftConditionStandard = new ACRadioButtonItem();

      nightShiftConditionStandard.setText("��^");

      nightShiftConditionStandard.setGroup(getNightShiftCondition());

      addNightShiftConditionStandard();
    }
    return nightShiftConditionStandard;

  }

  /**
   * ���Z�^���擾���܂��B
   * @return ���Z�^
   */
  public ACRadioButtonItem getNightShiftConditionSubtraction(){
    if(nightShiftConditionSubtraction==null){

      nightShiftConditionSubtraction = new ACRadioButtonItem();

      nightShiftConditionSubtraction.setText("���Z�^");

      nightShiftConditionSubtraction.setGroup(getNightShiftCondition());

      addNightShiftConditionSubtraction();
    }
    return nightShiftConditionSubtraction;

  }

  /**
   * �@�\�P���w���̐����W�I�O���[�v���擾���܂��B
   * @return �@�\�P���w���̐����W�I�O���[�v
   */
  public ACClearableRadioButtonGroup getFunctionTrainingGuidanceSystem(){
    if(functionTrainingGuidanceSystem==null){

      functionTrainingGuidanceSystem = new ACClearableRadioButtonGroup();

      getFunctionTrainingGuidanceSystemContainer().setText("�@�\�P���w���̐�");

      functionTrainingGuidanceSystem.setBindPath("1510103");

      functionTrainingGuidanceSystem.setModel(getFunctionTrainingGuidanceSystemModel());

      functionTrainingGuidanceSystem.setUseClearButton(false);

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
  public ACRadioButtonItem getFunctionTrainingGuidanceSystemOff(){
    if(functionTrainingGuidanceSystemOff==null){

      functionTrainingGuidanceSystemOff = new ACRadioButtonItem();

      functionTrainingGuidanceSystemOff.setText("�Ȃ�");

      functionTrainingGuidanceSystemOff.setGroup(getFunctionTrainingGuidanceSystem());

      addFunctionTrainingGuidanceSystemOff();
    }
    return functionTrainingGuidanceSystemOff;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getFunctionTrainingGuidanceSystemOn(){
    if(functionTrainingGuidanceSystemOn==null){

      functionTrainingGuidanceSystemOn = new ACRadioButtonItem();

      functionTrainingGuidanceSystemOn.setText("����");

      functionTrainingGuidanceSystemOn.setGroup(getFunctionTrainingGuidanceSystem());

      addFunctionTrainingGuidanceSystemOn();
    }
    return functionTrainingGuidanceSystemOn;

  }

  /**
   * ��ΐ�]��t�z�u���W�I�O���[�v���擾���܂��B
   * @return ��ΐ�]��t�z�u���W�I�O���[�v
   */
  public ACClearableRadioButtonGroup getStandingDoctorArrangement(){
    if(standingDoctorArrangement==null){

      standingDoctorArrangement = new ACClearableRadioButtonGroup();

      getStandingDoctorArrangementContainer().setText("��ΐ�]��t�z�u");

      standingDoctorArrangement.setBindPath("1510104");

      standingDoctorArrangement.setModel(getStandingDoctorArrangementModel());

      standingDoctorArrangement.setUseClearButton(false);

      addStandingDoctorArrangement();
    }
    return standingDoctorArrangement;

  }

  /**
   * ��ΐ�]��t�z�u���W�I�O���[�v�R���e�i���擾���܂��B
   * @return ��ΐ�]��t�z�u���W�I�O���[�v�R���e�i
   */
  protected ACLabelContainer getStandingDoctorArrangementContainer(){
    if(standingDoctorArrangementContainer==null){
      standingDoctorArrangementContainer = new ACLabelContainer();
      standingDoctorArrangementContainer.setFollowChildEnabled(true);
      standingDoctorArrangementContainer.add(getStandingDoctorArrangement(), null);
    }
    return standingDoctorArrangementContainer;
  }

  /**
   * ��ΐ�]��t�z�u���W�I�O���[�v���f�����擾���܂��B
   * @return ��ΐ�]��t�z�u���W�I�O���[�v���f��
   */
  protected ACListModelAdapter getStandingDoctorArrangementModel(){
    if(standingDoctorArrangementModel==null){
      standingDoctorArrangementModel = new ACListModelAdapter();
      addStandingDoctorArrangementModel();
    }
    return standingDoctorArrangementModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getStandingDoctorArrangementOff(){
    if(standingDoctorArrangementOff==null){

      standingDoctorArrangementOff = new ACRadioButtonItem();

      standingDoctorArrangementOff.setText("�Ȃ�");

      standingDoctorArrangementOff.setGroup(getStandingDoctorArrangement());

      addStandingDoctorArrangementOff();
    }
    return standingDoctorArrangementOff;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getStandingDoctorArrangementOn(){
    if(standingDoctorArrangementOn==null){

      standingDoctorArrangementOn = new ACRadioButtonItem();

      standingDoctorArrangementOn.setText("����");

      standingDoctorArrangementOn.setGroup(getStandingDoctorArrangement());

      addStandingDoctorArrangementOn();
    }
    return standingDoctorArrangementOn;

  }

  /**
   * ���_�Ȉ�t����I�×{�w�����W�I�O���[�v���擾���܂��B
   * @return ���_�Ȉ�t����I�×{�w�����W�I�O���[�v
   */
  public ACClearableRadioButtonGroup getPsychiatristMaster(){
    if(psychiatristMaster==null){

      psychiatristMaster = new ACClearableRadioButtonGroup();

      getPsychiatristMasterContainer().setText("���_�Ȉ�t����I�×{�w��");

      psychiatristMaster.setBindPath("1510105");

      psychiatristMaster.setModel(getPsychiatristMasterModel());

      psychiatristMaster.setUseClearButton(false);

      addPsychiatristMaster();
    }
    return psychiatristMaster;

  }

  /**
   * ���_�Ȉ�t����I�×{�w�����W�I�O���[�v�R���e�i���擾���܂��B
   * @return ���_�Ȉ�t����I�×{�w�����W�I�O���[�v�R���e�i
   */
  protected ACLabelContainer getPsychiatristMasterContainer(){
    if(psychiatristMasterContainer==null){
      psychiatristMasterContainer = new ACLabelContainer();
      psychiatristMasterContainer.setFollowChildEnabled(true);
      psychiatristMasterContainer.add(getPsychiatristMaster(), null);
    }
    return psychiatristMasterContainer;
  }

  /**
   * ���_�Ȉ�t����I�×{�w�����W�I�O���[�v���f�����擾���܂��B
   * @return ���_�Ȉ�t����I�×{�w�����W�I�O���[�v���f��
   */
  protected ACListModelAdapter getPsychiatristMasterModel(){
    if(psychiatristMasterModel==null){
      psychiatristMasterModel = new ACListModelAdapter();
      addPsychiatristMasterModel();
    }
    return psychiatristMasterModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getPsychiatristMasterOff(){
    if(psychiatristMasterOff==null){

      psychiatristMasterOff = new ACRadioButtonItem();

      psychiatristMasterOff.setText("�Ȃ�");

      psychiatristMasterOff.setGroup(getPsychiatristMaster());

      addPsychiatristMasterOff();
    }
    return psychiatristMasterOff;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getPsychiatristMasterOn(){
    if(psychiatristMasterOn==null){

      psychiatristMasterOn = new ACRadioButtonItem();

      psychiatristMasterOn.setText("����");

      psychiatristMasterOn.setGroup(getPsychiatristMaster());

      addPsychiatristMasterOn();
    }
    return psychiatristMasterOn;

  }

  /**
   * ��Q�Ґ����x���̐����W�I�O���[�v���擾���܂��B
   * @return ��Q�Ґ����x���̐����W�I�O���[�v
   */
  public ACClearableRadioButtonGroup getHandicappedPersonSupport(){
    if(handicappedPersonSupport==null){

      handicappedPersonSupport = new ACClearableRadioButtonGroup();

      getHandicappedPersonSupportContainer().setText("��Q�Ґ����x���̐�");

      handicappedPersonSupport.setBindPath("1510106");

      handicappedPersonSupport.setModel(getHandicappedPersonSupportModel());

      handicappedPersonSupport.setUseClearButton(false);

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
  public ACRadioButtonItem getHandicappedPersonSupportOff(){
    if(handicappedPersonSupportOff==null){

      handicappedPersonSupportOff = new ACRadioButtonItem();

      handicappedPersonSupportOff.setText("�Ȃ�");

      handicappedPersonSupportOff.setGroup(getHandicappedPersonSupport());

      addHandicappedPersonSupportOff();
    }
    return handicappedPersonSupportOff;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getHandicappedPersonSupportOn(){
    if(handicappedPersonSupportOn==null){

      handicappedPersonSupportOn = new ACRadioButtonItem();

      handicappedPersonSupportOn.setText("����");

      handicappedPersonSupportOn.setGroup(getHandicappedPersonSupport());

      addHandicappedPersonSupportOn();
    }
    return handicappedPersonSupportOn;

  }

  /**
   * �h�{�Ǘ��̐����W�I�O���[�v���擾���܂��B
   * @return �h�{�Ǘ��̐����W�I�O���[�v
   */
  public ACClearableRadioButtonGroup getNutritionManageRadio(){
    if(nutritionManageRadio==null){

      nutritionManageRadio = new ACClearableRadioButtonGroup();

      getNutritionManageRadioContainer().setText("�h�{�Ǘ��̐�");

      nutritionManageRadio.setBindPath("1510108");

      nutritionManageRadio.setModel(getNutritionManageRadioModel());

      nutritionManageRadio.setUseClearButton(false);

      addNutritionManageRadio();
    }
    return nutritionManageRadio;

  }

  /**
   * �h�{�Ǘ��̐����W�I�O���[�v�R���e�i���擾���܂��B
   * @return �h�{�Ǘ��̐����W�I�O���[�v�R���e�i
   */
  protected ACLabelContainer getNutritionManageRadioContainer(){
    if(nutritionManageRadioContainer==null){
      nutritionManageRadioContainer = new ACLabelContainer();
      nutritionManageRadioContainer.setFollowChildEnabled(true);
      nutritionManageRadioContainer.add(getNutritionManageRadio(), null);
    }
    return nutritionManageRadioContainer;
  }

  /**
   * �h�{�Ǘ��̐����W�I�O���[�v���f�����擾���܂��B
   * @return �h�{�Ǘ��̐����W�I�O���[�v���f��
   */
  protected ACListModelAdapter getNutritionManageRadioModel(){
    if(nutritionManageRadioModel==null){
      nutritionManageRadioModel = new ACListModelAdapter();
      addNutritionManageRadioModel();
    }
    return nutritionManageRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getNutritionManageRadioItem1(){
    if(nutritionManageRadioItem1==null){

      nutritionManageRadioItem1 = new ACRadioButtonItem();

      nutritionManageRadioItem1.setText("�Ȃ�");

      nutritionManageRadioItem1.setGroup(getNutritionManageRadio());

      addNutritionManageRadioItem1();
    }
    return nutritionManageRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getNutritionManageRadioItem2(){
    if(nutritionManageRadioItem2==null){

      nutritionManageRadioItem2 = new ACRadioButtonItem();

      nutritionManageRadioItem2.setText("����");

      nutritionManageRadioItem2.setGroup(getNutritionManageRadio());

      addNutritionManageRadioItem2();
    }
    return nutritionManageRadioItem2;

  }

  /**
   * �h�{�}�l�W�����g�̐����W�I�O���[�v���擾���܂��B
   * @return �h�{�}�l�W�����g�̐����W�I�O���[�v
   */
  public ACClearableRadioButtonGroup getNutritionRadio(){
    if(nutritionRadio==null){

      nutritionRadio = new ACClearableRadioButtonGroup();

      getNutritionRadioContainer().setText("�h�{�}�l�W�����g�̐�");

      nutritionRadio.setBindPath("1510109");

      nutritionRadio.setModel(getNutritionRadioModel());

      nutritionRadio.setUseClearButton(false);

      addNutritionRadio();
    }
    return nutritionRadio;

  }

  /**
   * �h�{�}�l�W�����g�̐����W�I�O���[�v�R���e�i���擾���܂��B
   * @return �h�{�}�l�W�����g�̐����W�I�O���[�v�R���e�i
   */
  protected ACLabelContainer getNutritionRadioContainer(){
    if(nutritionRadioContainer==null){
      nutritionRadioContainer = new ACLabelContainer();
      nutritionRadioContainer.setFollowChildEnabled(true);
      nutritionRadioContainer.add(getNutritionRadio(), null);
    }
    return nutritionRadioContainer;
  }

  /**
   * �h�{�}�l�W�����g�̐����W�I�O���[�v���f�����擾���܂��B
   * @return �h�{�}�l�W�����g�̐����W�I�O���[�v���f��
   */
  protected ACListModelAdapter getNutritionRadioModel(){
    if(nutritionRadioModel==null){
      nutritionRadioModel = new ACListModelAdapter();
      addNutritionRadioModel();
    }
    return nutritionRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getNutritionRadioItem1(){
    if(nutritionRadioItem1==null){

      nutritionRadioItem1 = new ACRadioButtonItem();

      nutritionRadioItem1.setText("�Ȃ�");

      nutritionRadioItem1.setGroup(getNutritionRadio());

      addNutritionRadioItem1();
    }
    return nutritionRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getNutritionRadioItem2 (){
    if(nutritionRadioItem2 ==null){

      nutritionRadioItem2  = new ACRadioButtonItem();

      nutritionRadioItem2 .setText("����");

      nutritionRadioItem2 .setGroup(getNutritionRadio());

      addNutritionRadioItem2 ();
    }
    return nutritionRadioItem2 ;

  }

  /**
   * �o���ڍs�̐����W�I�O���[�v���擾���܂��B
   * @return �o���ڍs�̐����W�I�O���[�v
   */
  public ACClearableRadioButtonGroup getOralSwitchRadio(){
    if(oralSwitchRadio==null){

      oralSwitchRadio = new ACClearableRadioButtonGroup();

      getOralSwitchRadioContainer().setText("�o���ڍs�̐�");

      oralSwitchRadio.setBindPath("1510110");

      oralSwitchRadio.setModel(getOralSwitchRadioModel());

      oralSwitchRadio.setUseClearButton(false);

      addOralSwitchRadio();
    }
    return oralSwitchRadio;

  }

  /**
   * �o���ڍs�̐����W�I�O���[�v�R���e�i���擾���܂��B
   * @return �o���ڍs�̐����W�I�O���[�v�R���e�i
   */
  protected ACLabelContainer getOralSwitchRadioContainer(){
    if(oralSwitchRadioContainer==null){
      oralSwitchRadioContainer = new ACLabelContainer();
      oralSwitchRadioContainer.setFollowChildEnabled(true);
      oralSwitchRadioContainer.add(getOralSwitchRadio(), null);
    }
    return oralSwitchRadioContainer;
  }

  /**
   * �o���ڍs�̐����W�I�O���[�v���f�����擾���܂��B
   * @return �o���ڍs�̐����W�I�O���[�v���f��
   */
  protected ACListModelAdapter getOralSwitchRadioModel(){
    if(oralSwitchRadioModel==null){
      oralSwitchRadioModel = new ACListModelAdapter();
      addOralSwitchRadioModel();
    }
    return oralSwitchRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getOralSwitchRadioItem1(){
    if(oralSwitchRadioItem1==null){

      oralSwitchRadioItem1 = new ACRadioButtonItem();

      oralSwitchRadioItem1.setText("�Ȃ�");

      oralSwitchRadioItem1.setGroup(getOralSwitchRadio());

      addOralSwitchRadioItem1();
    }
    return oralSwitchRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getOralSwitchRadioItem2 (){
    if(oralSwitchRadioItem2 ==null){

      oralSwitchRadioItem2  = new ACRadioButtonItem();

      oralSwitchRadioItem2 .setText("����");

      oralSwitchRadioItem2 .setGroup(getOralSwitchRadio());

      addOralSwitchRadioItem2 ();
    }
    return oralSwitchRadioItem2 ;

  }

  /**
   * �×{�H�̐����W�I�O���[�v���擾���܂��B
   * @return �×{�H�̐����W�I�O���[�v
   */
  public ACClearableRadioButtonGroup getRecuperateDinnerRadio(){
    if(recuperateDinnerRadio==null){

      recuperateDinnerRadio = new ACClearableRadioButtonGroup();

      getRecuperateDinnerRadioContainer().setText("�×{�H�̐�");

      recuperateDinnerRadio.setBindPath("1510111");

      recuperateDinnerRadio.setModel(getRecuperateDinnerRadioModel());

      recuperateDinnerRadio.setUseClearButton(false);

      addRecuperateDinnerRadio();
    }
    return recuperateDinnerRadio;

  }

  /**
   * �×{�H�̐����W�I�O���[�v�R���e�i���擾���܂��B
   * @return �×{�H�̐����W�I�O���[�v�R���e�i
   */
  protected ACLabelContainer getRecuperateDinnerRadioContainer(){
    if(recuperateDinnerRadioContainer==null){
      recuperateDinnerRadioContainer = new ACLabelContainer();
      recuperateDinnerRadioContainer.setFollowChildEnabled(true);
      recuperateDinnerRadioContainer.add(getRecuperateDinnerRadio(), null);
    }
    return recuperateDinnerRadioContainer;
  }

  /**
   * �×{�H�̐����W�I�O���[�v���f�����擾���܂��B
   * @return �×{�H�̐����W�I�O���[�v���f��
   */
  protected ACListModelAdapter getRecuperateDinnerRadioModel(){
    if(recuperateDinnerRadioModel==null){
      recuperateDinnerRadioModel = new ACListModelAdapter();
      addRecuperateDinnerRadioModel();
    }
    return recuperateDinnerRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getRecuperateDinnerRadioItem1(){
    if(recuperateDinnerRadioItem1==null){

      recuperateDinnerRadioItem1 = new ACRadioButtonItem();

      recuperateDinnerRadioItem1.setText("�Ȃ�");

      recuperateDinnerRadioItem1.setGroup(getRecuperateDinnerRadio());

      addRecuperateDinnerRadioItem1();
    }
    return recuperateDinnerRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getRecuperateDinnerRadioItem2(){
    if(recuperateDinnerRadioItem2==null){

      recuperateDinnerRadioItem2 = new ACRadioButtonItem();

      recuperateDinnerRadioItem2.setText("����");

      recuperateDinnerRadioItem2.setGroup(getRecuperateDinnerRadio());

      addRecuperateDinnerRadioItem2();
    }
    return recuperateDinnerRadioItem2;

  }

  /**
   * �l�����Z���W�I�O���[�v���擾���܂��B
   * @return �l�����Z���W�I�O���[�v
   */
  public ACClearableRadioButtonGroup getStaffLack(){
    if(staffLack==null){

      staffLack = new ACClearableRadioButtonGroup();

      getStaffLackContainer().setText("�l�����Z");

      staffLack.setBindPath("1510112");

      staffLack.setModel(getStaffLackModel());

      staffLack.setUseClearButton(false);

      addStaffLack();
    }
    return staffLack;

  }

  /**
   * �l�����Z���W�I�O���[�v�R���e�i���擾���܂��B
   * @return �l�����Z���W�I�O���[�v�R���e�i
   */
  protected ACLabelContainer getStaffLackContainer(){
    if(staffLackContainer==null){
      staffLackContainer = new ACLabelContainer();
      staffLackContainer.setFollowChildEnabled(true);
      staffLackContainer.add(getStaffLack(), null);
    }
    return staffLackContainer;
  }

  /**
   * �l�����Z���W�I�O���[�v���f�����擾���܂��B
   * @return �l�����Z���W�I�O���[�v���f��
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
  public ACRadioButtonItem getStaffLackOff(){
    if(staffLackOff==null){

      staffLackOff = new ACRadioButtonItem();

      staffLackOff.setText("�Ȃ�");

      staffLackOff.setGroup(getStaffLack());

      addStaffLackOff();
    }
    return staffLackOff;

  }

  /**
   * ������߂��擾���܂��B
   * @return �������
   */
  public ACRadioButtonItem getStaffLackStaffExcess(){
    if(staffLackStaffExcess==null){

      staffLackStaffExcess = new ACRadioButtonItem();

      staffLackStaffExcess.setText("�������");

      staffLackStaffExcess.setGroup(getStaffLack());

      addStaffLackStaffExcess();
    }
    return staffLackStaffExcess;

  }

  /**
   * �Ō�E���E�����͉��x�������̕s�����擾���܂��B
   * @return �Ō�E���E�����͉��x�������̕s��
   */
  public ACRadioButtonItem getStaffLackKaigo(){
    if(staffLackKaigo==null){

      staffLackKaigo = new ACRadioButtonItem();

      staffLackKaigo.setText("�Ō�E���E�����͉��x�������̕s��");

      staffLackKaigo.setGroup(getStaffLack());

      addStaffLackKaigo();
    }
    return staffLackKaigo;

  }

  /**
   * �H���z�E�R���e�i���擾���܂��B
   * @return �H���z�E�R���e�i
   */
  public ACLabelContainer getCareOldPepleWelfareFacilitiesDinnerStandeirdMoneyConteiner(){
    if(careOldPepleWelfareFacilitiesDinnerStandeirdMoneyConteiner==null){

      careOldPepleWelfareFacilitiesDinnerStandeirdMoneyConteiner = new ACLabelContainer();

      careOldPepleWelfareFacilitiesDinnerStandeirdMoneyConteiner.setText("�H���z");

      careOldPepleWelfareFacilitiesDinnerStandeirdMoneyConteiner.setFollowChildEnabled(true);

      addCareOldPepleWelfareFacilitiesDinnerStandeirdMoneyConteiner();
    }
    return careOldPepleWelfareFacilitiesDinnerStandeirdMoneyConteiner;

  }

  /**
   * �H���z�E���v�E�e�L�X�g���擾���܂��B
   * @return �H���z�E���v�E�e�L�X�g
   */
  public ACTextField getCareOldPepleWelfareFacilitiesDinnerStandeirdMoneyTotal(){
    if(careOldPepleWelfareFacilitiesDinnerStandeirdMoneyTotal==null){

      careOldPepleWelfareFacilitiesDinnerStandeirdMoneyTotal = new ACTextField();

      careOldPepleWelfareFacilitiesDinnerStandeirdMoneyTotal.setBindPath("1510113");

      careOldPepleWelfareFacilitiesDinnerStandeirdMoneyTotal.setEditable(false);

      careOldPepleWelfareFacilitiesDinnerStandeirdMoneyTotal.setColumns(4);

      careOldPepleWelfareFacilitiesDinnerStandeirdMoneyTotal.setCharType(VRCharType.ONLY_DIGIT);

      careOldPepleWelfareFacilitiesDinnerStandeirdMoneyTotal.setHorizontalAlignment(SwingConstants.RIGHT);

      careOldPepleWelfareFacilitiesDinnerStandeirdMoneyTotal.setIMEMode(InputSubset.LATIN);

      careOldPepleWelfareFacilitiesDinnerStandeirdMoneyTotal.setMaxLength(4);

      addCareOldPepleWelfareFacilitiesDinnerStandeirdMoneyTotal();
    }
    return careOldPepleWelfareFacilitiesDinnerStandeirdMoneyTotal;

  }

  /**
   * �H���z�E���E���x�����擾���܂��B
   * @return �H���z�E���E���x��
   */
  public ACLabel getCareOldPepleWelfareFacilitiesMorningDinnerStandeirdMoneyLabel(){
    if(careOldPepleWelfareFacilitiesMorningDinnerStandeirdMoneyLabel==null){

      careOldPepleWelfareFacilitiesMorningDinnerStandeirdMoneyLabel = new ACLabel();

      careOldPepleWelfareFacilitiesMorningDinnerStandeirdMoneyLabel.setText("�@��");

      addCareOldPepleWelfareFacilitiesMorningDinnerStandeirdMoneyLabel();
    }
    return careOldPepleWelfareFacilitiesMorningDinnerStandeirdMoneyLabel;

  }

  /**
   * �H���z�E���E�e�L�X�g���擾���܂��B
   * @return �H���z�E���E�e�L�X�g
   */
  public ACTextField getCareOldPepleWelfareFacilitiesMorningDinnerStandeirdMoney(){
    if(careOldPepleWelfareFacilitiesMorningDinnerStandeirdMoney==null){

      careOldPepleWelfareFacilitiesMorningDinnerStandeirdMoney = new ACTextField();

      careOldPepleWelfareFacilitiesMorningDinnerStandeirdMoney.setBindPath("1510114");

      careOldPepleWelfareFacilitiesMorningDinnerStandeirdMoney.setColumns(3);

      careOldPepleWelfareFacilitiesMorningDinnerStandeirdMoney.setCharType(VRCharType.ONLY_DIGIT);

      careOldPepleWelfareFacilitiesMorningDinnerStandeirdMoney.setHorizontalAlignment(SwingConstants.RIGHT);

      careOldPepleWelfareFacilitiesMorningDinnerStandeirdMoney.setIMEMode(InputSubset.LATIN);

      careOldPepleWelfareFacilitiesMorningDinnerStandeirdMoney.setMaxLength(3);

      addCareOldPepleWelfareFacilitiesMorningDinnerStandeirdMoney();
    }
    return careOldPepleWelfareFacilitiesMorningDinnerStandeirdMoney;

  }

  /**
   * �H���z�E���E���x�����擾���܂��B
   * @return �H���z�E���E���x��
   */
  public ACLabel getCareOldPepleWelfareFacilitiesNoonDinnerStandeirdMoneyLabel(){
    if(careOldPepleWelfareFacilitiesNoonDinnerStandeirdMoneyLabel==null){

      careOldPepleWelfareFacilitiesNoonDinnerStandeirdMoneyLabel = new ACLabel();

      careOldPepleWelfareFacilitiesNoonDinnerStandeirdMoneyLabel.setText("��");

      addCareOldPepleWelfareFacilitiesNoonDinnerStandeirdMoneyLabel();
    }
    return careOldPepleWelfareFacilitiesNoonDinnerStandeirdMoneyLabel;

  }

  /**
   * �H���z�E���E�e�L�X�g���擾���܂��B
   * @return �H���z�E���E�e�L�X�g
   */
  public ACTextField getCareOldPepleWelfareFacilitiesNoonDinnerStandeirdMoney(){
    if(careOldPepleWelfareFacilitiesNoonDinnerStandeirdMoney==null){

      careOldPepleWelfareFacilitiesNoonDinnerStandeirdMoney = new ACTextField();

      careOldPepleWelfareFacilitiesNoonDinnerStandeirdMoney.setBindPath("1510115");

      careOldPepleWelfareFacilitiesNoonDinnerStandeirdMoney.setColumns(3);

      careOldPepleWelfareFacilitiesNoonDinnerStandeirdMoney.setCharType(VRCharType.ONLY_DIGIT);

      careOldPepleWelfareFacilitiesNoonDinnerStandeirdMoney.setHorizontalAlignment(SwingConstants.RIGHT);

      careOldPepleWelfareFacilitiesNoonDinnerStandeirdMoney.setIMEMode(InputSubset.LATIN);

      careOldPepleWelfareFacilitiesNoonDinnerStandeirdMoney.setMaxLength(3);

      addCareOldPepleWelfareFacilitiesNoonDinnerStandeirdMoney();
    }
    return careOldPepleWelfareFacilitiesNoonDinnerStandeirdMoney;

  }

  /**
   * �H���z�E��E���x�����擾���܂��B
   * @return �H���z�E��E���x��
   */
  public ACLabel getCareOldPepleWelfareFacilitiesNightDinnerStandeirdMoneyLabel(){
    if(careOldPepleWelfareFacilitiesNightDinnerStandeirdMoneyLabel==null){

      careOldPepleWelfareFacilitiesNightDinnerStandeirdMoneyLabel = new ACLabel();

      careOldPepleWelfareFacilitiesNightDinnerStandeirdMoneyLabel.setText("��");

      addCareOldPepleWelfareFacilitiesNightDinnerStandeirdMoneyLabel();
    }
    return careOldPepleWelfareFacilitiesNightDinnerStandeirdMoneyLabel;

  }

  /**
   * �H���z�E��E�e�L�X�g���擾���܂��B
   * @return �H���z�E��E�e�L�X�g
   */
  public ACTextField getCareOldPepleWelfareFacilitiesNightDinnerStandeirdMoney(){
    if(careOldPepleWelfareFacilitiesNightDinnerStandeirdMoney==null){

      careOldPepleWelfareFacilitiesNightDinnerStandeirdMoney = new ACTextField();

      careOldPepleWelfareFacilitiesNightDinnerStandeirdMoney.setBindPath("1510116");

      careOldPepleWelfareFacilitiesNightDinnerStandeirdMoney.setColumns(3);

      careOldPepleWelfareFacilitiesNightDinnerStandeirdMoney.setCharType(VRCharType.ONLY_DIGIT);

      careOldPepleWelfareFacilitiesNightDinnerStandeirdMoney.setHorizontalAlignment(SwingConstants.RIGHT);

      careOldPepleWelfareFacilitiesNightDinnerStandeirdMoney.setIMEMode(InputSubset.LATIN);

      careOldPepleWelfareFacilitiesNightDinnerStandeirdMoney.setMaxLength(3);

      addCareOldPepleWelfareFacilitiesNightDinnerStandeirdMoney();
    }
    return careOldPepleWelfareFacilitiesNightDinnerStandeirdMoney;

  }

  /**
   * �H���z�E���x�����擾���܂��B
   * @return �H���z�E���x��
   */
  public ACLabel getCareOldPepleWelfareFacilitiesDinnerStandeirdMoney4Label(){
    if(careOldPepleWelfareFacilitiesDinnerStandeirdMoney4Label==null){

      careOldPepleWelfareFacilitiesDinnerStandeirdMoney4Label = new ACLabel();

      careOldPepleWelfareFacilitiesDinnerStandeirdMoney4Label.setText("�i�~�j");

      addCareOldPepleWelfareFacilitiesDinnerStandeirdMoney4Label();
    }
    return careOldPepleWelfareFacilitiesDinnerStandeirdMoney4Label;

  }

  /**
   * ���j�b�g�^����z�E�R���e�i���擾���܂��B
   * @return ���j�b�g�^����z�E�R���e�i
   */
  public ACLabelContainer getCareOldPepleWelfareFacilitiesUnitRoomStandeirdMoneyConteiner(){
    if(careOldPepleWelfareFacilitiesUnitRoomStandeirdMoneyConteiner==null){

      careOldPepleWelfareFacilitiesUnitRoomStandeirdMoneyConteiner = new ACLabelContainer();

      careOldPepleWelfareFacilitiesUnitRoomStandeirdMoneyConteiner.setText("���j�b�g�^����z");

      careOldPepleWelfareFacilitiesUnitRoomStandeirdMoneyConteiner.setFollowChildEnabled(true);

      addCareOldPepleWelfareFacilitiesUnitRoomStandeirdMoneyConteiner();
    }
    return careOldPepleWelfareFacilitiesUnitRoomStandeirdMoneyConteiner;

  }

  /**
   * ���j�b�g�^����z�E�e�L�X�g���擾���܂��B
   * @return ���j�b�g�^����z�E�e�L�X�g
   */
  public ACTextField getCareOldPepleWelfareFacilitiesUnitRoomStandeirdMoneyText(){
    if(careOldPepleWelfareFacilitiesUnitRoomStandeirdMoneyText==null){

      careOldPepleWelfareFacilitiesUnitRoomStandeirdMoneyText = new ACTextField();

      careOldPepleWelfareFacilitiesUnitRoomStandeirdMoneyText.setBindPath("1510117");

      careOldPepleWelfareFacilitiesUnitRoomStandeirdMoneyText.setColumns(4);

      careOldPepleWelfareFacilitiesUnitRoomStandeirdMoneyText.setCharType(VRCharType.ONLY_DIGIT);

      careOldPepleWelfareFacilitiesUnitRoomStandeirdMoneyText.setHorizontalAlignment(SwingConstants.RIGHT);

      careOldPepleWelfareFacilitiesUnitRoomStandeirdMoneyText.setIMEMode(InputSubset.LATIN);

      careOldPepleWelfareFacilitiesUnitRoomStandeirdMoneyText.setMaxLength(4);

      addCareOldPepleWelfareFacilitiesUnitRoomStandeirdMoneyText();
    }
    return careOldPepleWelfareFacilitiesUnitRoomStandeirdMoneyText;

  }

  /**
   * ���j�b�g�^����z�E���x�����擾���܂��B
   * @return ���j�b�g�^����z�E���x��
   */
  public ACLabel getCareOldPepleWelfareFacilitiesUnitRoomStandeirdMoneyLabel(){
    if(careOldPepleWelfareFacilitiesUnitRoomStandeirdMoneyLabel==null){

      careOldPepleWelfareFacilitiesUnitRoomStandeirdMoneyLabel = new ACLabel();

      careOldPepleWelfareFacilitiesUnitRoomStandeirdMoneyLabel.setText("�i�~�j");

      addCareOldPepleWelfareFacilitiesUnitRoomStandeirdMoneyLabel();
    }
    return careOldPepleWelfareFacilitiesUnitRoomStandeirdMoneyLabel;

  }

  /**
   * ���j�b�g�^������z�E�R���e�i���擾���܂��B
   * @return ���j�b�g�^������z�E�R���e�i
   */
  public ACLabelContainer getCareOldPepleWelfareFacilitiesUnitSemiRoomStandeirdMoneyConteiner(){
    if(careOldPepleWelfareFacilitiesUnitSemiRoomStandeirdMoneyConteiner==null){

      careOldPepleWelfareFacilitiesUnitSemiRoomStandeirdMoneyConteiner = new ACLabelContainer();

      careOldPepleWelfareFacilitiesUnitSemiRoomStandeirdMoneyConteiner.setText("���j�b�g�^������z");

      careOldPepleWelfareFacilitiesUnitSemiRoomStandeirdMoneyConteiner.setFollowChildEnabled(true);

      addCareOldPepleWelfareFacilitiesUnitSemiRoomStandeirdMoneyConteiner();
    }
    return careOldPepleWelfareFacilitiesUnitSemiRoomStandeirdMoneyConteiner;

  }

  /**
   * ���j�b�g�^������z�E�e�L�X�g���擾���܂��B
   * @return ���j�b�g�^������z�E�e�L�X�g
   */
  public ACTextField getCareOldPepleWelfareFacilitiesUnitSemiRoomStandeirdMoneyText(){
    if(careOldPepleWelfareFacilitiesUnitSemiRoomStandeirdMoneyText==null){

      careOldPepleWelfareFacilitiesUnitSemiRoomStandeirdMoneyText = new ACTextField();

      careOldPepleWelfareFacilitiesUnitSemiRoomStandeirdMoneyText.setBindPath("1510118");

      careOldPepleWelfareFacilitiesUnitSemiRoomStandeirdMoneyText.setColumns(4);

      careOldPepleWelfareFacilitiesUnitSemiRoomStandeirdMoneyText.setCharType(VRCharType.ONLY_DIGIT);

      careOldPepleWelfareFacilitiesUnitSemiRoomStandeirdMoneyText.setHorizontalAlignment(SwingConstants.RIGHT);

      careOldPepleWelfareFacilitiesUnitSemiRoomStandeirdMoneyText.setIMEMode(InputSubset.LATIN);

      careOldPepleWelfareFacilitiesUnitSemiRoomStandeirdMoneyText.setMaxLength(4);

      addCareOldPepleWelfareFacilitiesUnitSemiRoomStandeirdMoneyText();
    }
    return careOldPepleWelfareFacilitiesUnitSemiRoomStandeirdMoneyText;

  }

  /**
   * ���j�b�g�^������z�E���x�����擾���܂��B
   * @return ���j�b�g�^������z�E���x��
   */
  public ACLabel getCareOldPepleWelfareFacilitiesUnitSemiRoomStandeirdMoneyLabel(){
    if(careOldPepleWelfareFacilitiesUnitSemiRoomStandeirdMoneyLabel==null){

      careOldPepleWelfareFacilitiesUnitSemiRoomStandeirdMoneyLabel = new ACLabel();

      careOldPepleWelfareFacilitiesUnitSemiRoomStandeirdMoneyLabel.setText("�i�~�j");

      addCareOldPepleWelfareFacilitiesUnitSemiRoomStandeirdMoneyLabel();
    }
    return careOldPepleWelfareFacilitiesUnitSemiRoomStandeirdMoneyLabel;

  }

  /**
   * �]���^����z�E�R���e�i���擾���܂��B
   * @return �]���^����z�E�R���e�i
   */
  public ACLabelContainer getCareOldPepleWelfareFacilitiesNormalRoomStandeirdMoneyConteiner(){
    if(careOldPepleWelfareFacilitiesNormalRoomStandeirdMoneyConteiner==null){

      careOldPepleWelfareFacilitiesNormalRoomStandeirdMoneyConteiner = new ACLabelContainer();

      careOldPepleWelfareFacilitiesNormalRoomStandeirdMoneyConteiner.setText("�]���^����z");

      careOldPepleWelfareFacilitiesNormalRoomStandeirdMoneyConteiner.setFollowChildEnabled(true);

      addCareOldPepleWelfareFacilitiesNormalRoomStandeirdMoneyConteiner();
    }
    return careOldPepleWelfareFacilitiesNormalRoomStandeirdMoneyConteiner;

  }

  /**
   * �]���^����z�E�e�L�X�g���擾���܂��B
   * @return �]���^����z�E�e�L�X�g
   */
  public ACTextField getCareOldPepleWelfareFacilitiesNormalRoomStandeirdMoneyText(){
    if(careOldPepleWelfareFacilitiesNormalRoomStandeirdMoneyText==null){

      careOldPepleWelfareFacilitiesNormalRoomStandeirdMoneyText = new ACTextField();

      careOldPepleWelfareFacilitiesNormalRoomStandeirdMoneyText.setBindPath("1510119");

      careOldPepleWelfareFacilitiesNormalRoomStandeirdMoneyText.setColumns(4);

      careOldPepleWelfareFacilitiesNormalRoomStandeirdMoneyText.setCharType(VRCharType.ONLY_DIGIT);

      careOldPepleWelfareFacilitiesNormalRoomStandeirdMoneyText.setHorizontalAlignment(SwingConstants.RIGHT);

      careOldPepleWelfareFacilitiesNormalRoomStandeirdMoneyText.setIMEMode(InputSubset.LATIN);

      careOldPepleWelfareFacilitiesNormalRoomStandeirdMoneyText.setMaxLength(4);

      addCareOldPepleWelfareFacilitiesNormalRoomStandeirdMoneyText();
    }
    return careOldPepleWelfareFacilitiesNormalRoomStandeirdMoneyText;

  }

  /**
   * �]���^����z�E���x�����擾���܂��B
   * @return �]���^����z�E���x��
   */
  public ACLabel getCareOldPepleWelfareFacilitiesNormalRoomStandeirdMoneyLabel(){
    if(careOldPepleWelfareFacilitiesNormalRoomStandeirdMoneyLabel==null){

      careOldPepleWelfareFacilitiesNormalRoomStandeirdMoneyLabel = new ACLabel();

      careOldPepleWelfareFacilitiesNormalRoomStandeirdMoneyLabel.setText("�i�~�j");

      addCareOldPepleWelfareFacilitiesNormalRoomStandeirdMoneyLabel();
    }
    return careOldPepleWelfareFacilitiesNormalRoomStandeirdMoneyLabel;

  }

  /**
   * ��������z�E�R���e�i���擾���܂��B
   * @return ��������z�E�R���e�i
   */
  public ACLabelContainer getCareOldPepleWelfareFacilitiesTasyouRoomConteiner(){
    if(careOldPepleWelfareFacilitiesTasyouRoomConteiner==null){

      careOldPepleWelfareFacilitiesTasyouRoomConteiner = new ACLabelContainer();

      careOldPepleWelfareFacilitiesTasyouRoomConteiner.setText("��������z");

      careOldPepleWelfareFacilitiesTasyouRoomConteiner.setFollowChildEnabled(true);

      addCareOldPepleWelfareFacilitiesTasyouRoomConteiner();
    }
    return careOldPepleWelfareFacilitiesTasyouRoomConteiner;

  }

  /**
   * ��������z�E�e�L�X�g���擾���܂��B
   * @return ��������z�E�e�L�X�g
   */
  public ACTextField getCareOldPepleWelfareFacilitiesTasyouRoomText(){
    if(careOldPepleWelfareFacilitiesTasyouRoomText==null){

      careOldPepleWelfareFacilitiesTasyouRoomText = new ACTextField();

      careOldPepleWelfareFacilitiesTasyouRoomText.setBindPath("1510120");

      careOldPepleWelfareFacilitiesTasyouRoomText.setColumns(4);

      careOldPepleWelfareFacilitiesTasyouRoomText.setCharType(VRCharType.ONLY_DIGIT);

      careOldPepleWelfareFacilitiesTasyouRoomText.setHorizontalAlignment(SwingConstants.RIGHT);

      careOldPepleWelfareFacilitiesTasyouRoomText.setIMEMode(InputSubset.LATIN);

      careOldPepleWelfareFacilitiesTasyouRoomText.setMaxLength(4);

      addCareOldPepleWelfareFacilitiesTasyouRoomText();
    }
    return careOldPepleWelfareFacilitiesTasyouRoomText;

  }

  /**
   * ��������z�E���x�����擾���܂��B
   * @return ��������z�E���x��
   */
  public ACLabel getCareOldPepleWelfareFacilitiesTasyouRoomLabel(){
    if(careOldPepleWelfareFacilitiesTasyouRoomLabel==null){

      careOldPepleWelfareFacilitiesTasyouRoomLabel = new ACLabel();

      careOldPepleWelfareFacilitiesTasyouRoomLabel.setText("�i�~�j");

      addCareOldPepleWelfareFacilitiesTasyouRoomLabel();
    }
    return careOldPepleWelfareFacilitiesTasyouRoomLabel;

  }

  /**
   * �R���X�g���N�^�ł��B
   */
  public QO004016Design() {

    try {
      initialize();

      initAffair(null);

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

    this.add(getAgedPeopleWelfareFacilityGroup(), VRLayout.CLIENT);

  }

  /**
   * ���ƃO���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addAgedPeopleWelfareFacilityGroup(){

    agedPeopleWelfareFacilityGroup.add(getAgedPeopleWelfareFacilityDiscountcontainer(), VRLayout.FLOW_INSETLINE_RETURN);

    agedPeopleWelfareFacilityGroup.add(getAgedPeopleWelfareFacilitiesDivisionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    agedPeopleWelfareFacilityGroup.add(getNightShiftConditionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    agedPeopleWelfareFacilityGroup.add(getFunctionTrainingGuidanceSystemContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    agedPeopleWelfareFacilityGroup.add(getStandingDoctorArrangementContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    agedPeopleWelfareFacilityGroup.add(getPsychiatristMasterContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    agedPeopleWelfareFacilityGroup.add(getHandicappedPersonSupportContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    agedPeopleWelfareFacilityGroup.add(getNutritionManageRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    agedPeopleWelfareFacilityGroup.add(getNutritionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    agedPeopleWelfareFacilityGroup.add(getOralSwitchRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    agedPeopleWelfareFacilityGroup.add(getRecuperateDinnerRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    agedPeopleWelfareFacilityGroup.add(getStaffLackContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    agedPeopleWelfareFacilityGroup.add(getCareOldPepleWelfareFacilitiesDinnerStandeirdMoneyConteiner(), VRLayout.FLOW_INSETLINE_RETURN);

    agedPeopleWelfareFacilityGroup.add(getCareOldPepleWelfareFacilitiesUnitRoomStandeirdMoneyConteiner(), VRLayout.FLOW_INSETLINE_RETURN);

    agedPeopleWelfareFacilityGroup.add(getCareOldPepleWelfareFacilitiesUnitSemiRoomStandeirdMoneyConteiner(), VRLayout.FLOW_INSETLINE_RETURN);

    agedPeopleWelfareFacilityGroup.add(getCareOldPepleWelfareFacilitiesNormalRoomStandeirdMoneyConteiner(), VRLayout.FLOW_INSETLINE_RETURN);

    agedPeopleWelfareFacilityGroup.add(getCareOldPepleWelfareFacilitiesTasyouRoomConteiner(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * �������R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addAgedPeopleWelfareFacilityDiscountcontainer(){

    agedPeopleWelfareFacilityDiscountcontainer.add(getAgedPeopleWelfareFacilityDiscountRate(), VRLayout.FLOW);

    agedPeopleWelfareFacilityDiscountcontainer.add(getPercentSign(), VRLayout.FLOW);

  }

  /**
   * �������ɓ������ڂ�ǉ����܂��B
   */
  protected void addAgedPeopleWelfareFacilityDiscountRate(){

  }

  /**
   * �����x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addPercentSign(){

  }

  /**
   * �{�݋敪���W�I�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addAgedPeopleWelfareFacilitiesDivision(){

  }

  /**
   * �{�݋敪���W�I�O���[�v���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addAgedPeopleWelfareFacilitiesDivisionModel(){

    getWelfareFacility1().setButtonIndex(1);
    getAgedPeopleWelfareFacilitiesDivisionModel().add(getWelfareFacility1());

    getWelfareFacility2().setButtonIndex(2);
    getAgedPeopleWelfareFacilitiesDivisionModel().add(getWelfareFacility2());

    getWelfareFacility3().setButtonIndex(3);
    getAgedPeopleWelfareFacilitiesDivisionModel().add(getWelfareFacility3());

    getWelfareFacility4().setButtonIndex(4);
    getAgedPeopleWelfareFacilitiesDivisionModel().add(getWelfareFacility4());

  }

  /**
   * �{�ݓ��̋敪���W�I�O���[�v���C�A�E�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addAgedPeopleWelfareFacilitiesDivisionLayout(){

  }

  /**
   * ��앟���{�݂ɓ������ڂ�ǉ����܂��B
   */
  protected void addWelfareFacility1(){

  }

  /**
   * ���K�͉�앟���{�݂ɓ������ڂ�ǉ����܂��B
   */
  protected void addWelfareFacility2(){

  }

  /**
   * ���j�b�g�^��앟���{�݂ɓ������ڂ�ǉ����܂��B
   */
  protected void addWelfareFacility3(){

  }

  /**
   * ���j�b�g�^���K�͉�앟���{�݂ɓ������ڂ�ǉ����܂��B
   */
  protected void addWelfareFacility4(){

  }

  /**
   * ��ԋΖ���������W�I�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addNightShiftCondition(){

  }

  /**
   * ��ԋΖ���������W�I�O���[�v���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addNightShiftConditionModel(){

    getNightShiftConditionStandard().setButtonIndex(1);
    getNightShiftConditionModel().add(getNightShiftConditionStandard());

    getNightShiftConditionSubtraction().setButtonIndex(2);
    getNightShiftConditionModel().add(getNightShiftConditionSubtraction());

  }

  /**
   * ��^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addNightShiftConditionStandard(){

  }

  /**
   * ���Z�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addNightShiftConditionSubtraction(){

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

    getFunctionTrainingGuidanceSystemOff().setButtonIndex(1);
    getFunctionTrainingGuidanceSystemModel().add(getFunctionTrainingGuidanceSystemOff());

    getFunctionTrainingGuidanceSystemOn().setButtonIndex(2);
    getFunctionTrainingGuidanceSystemModel().add(getFunctionTrainingGuidanceSystemOn());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addFunctionTrainingGuidanceSystemOff(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addFunctionTrainingGuidanceSystemOn(){

  }

  /**
   * ��ΐ�]��t�z�u���W�I�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addStandingDoctorArrangement(){

  }

  /**
   * ��ΐ�]��t�z�u���W�I�O���[�v���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addStandingDoctorArrangementModel(){

    getStandingDoctorArrangementOff().setButtonIndex(1);
    getStandingDoctorArrangementModel().add(getStandingDoctorArrangementOff());

    getStandingDoctorArrangementOn().setButtonIndex(2);
    getStandingDoctorArrangementModel().add(getStandingDoctorArrangementOn());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addStandingDoctorArrangementOff(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addStandingDoctorArrangementOn(){

  }

  /**
   * ���_�Ȉ�t����I�×{�w�����W�I�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPsychiatristMaster(){

  }

  /**
   * ���_�Ȉ�t����I�×{�w�����W�I�O���[�v���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addPsychiatristMasterModel(){

    getPsychiatristMasterOff().setButtonIndex(1);
    getPsychiatristMasterModel().add(getPsychiatristMasterOff());

    getPsychiatristMasterOn().setButtonIndex(2);
    getPsychiatristMasterModel().add(getPsychiatristMasterOn());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addPsychiatristMasterOff(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addPsychiatristMasterOn(){

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

    getHandicappedPersonSupportOff().setButtonIndex(1);
    getHandicappedPersonSupportModel().add(getHandicappedPersonSupportOff());

    getHandicappedPersonSupportOn().setButtonIndex(2);
    getHandicappedPersonSupportModel().add(getHandicappedPersonSupportOn());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addHandicappedPersonSupportOff(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addHandicappedPersonSupportOn(){

  }

  /**
   * �h�{�Ǘ��̐����W�I�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addNutritionManageRadio(){

  }

  /**
   * �h�{�Ǘ��̐����W�I�O���[�v���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addNutritionManageRadioModel(){

    getNutritionManageRadioItem1().setButtonIndex(1);
    getNutritionManageRadioModel().add(getNutritionManageRadioItem1());

    getNutritionManageRadioItem2().setButtonIndex(2);
    getNutritionManageRadioModel().add(getNutritionManageRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addNutritionManageRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addNutritionManageRadioItem2(){

  }

  /**
   * �h�{�}�l�W�����g�̐����W�I�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addNutritionRadio(){

  }

  /**
   * �h�{�}�l�W�����g�̐����W�I�O���[�v���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addNutritionRadioModel(){

    getNutritionRadioItem1().setButtonIndex(1);
    getNutritionRadioModel().add(getNutritionRadioItem1());

    getNutritionRadioItem2 ().setButtonIndex(2);
    getNutritionRadioModel().add(getNutritionRadioItem2 ());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addNutritionRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addNutritionRadioItem2 (){

  }

  /**
   * �o���ڍs�̐����W�I�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addOralSwitchRadio(){

  }

  /**
   * �o���ڍs�̐����W�I�O���[�v���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addOralSwitchRadioModel(){

    getOralSwitchRadioItem1().setButtonIndex(1);
    getOralSwitchRadioModel().add(getOralSwitchRadioItem1());

    getOralSwitchRadioItem2 ().setButtonIndex(2);
    getOralSwitchRadioModel().add(getOralSwitchRadioItem2 ());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addOralSwitchRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addOralSwitchRadioItem2 (){

  }

  /**
   * �×{�H�̐����W�I�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addRecuperateDinnerRadio(){

  }

  /**
   * �×{�H�̐����W�I�O���[�v���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addRecuperateDinnerRadioModel(){

    getRecuperateDinnerRadioItem1().setButtonIndex(1);
    getRecuperateDinnerRadioModel().add(getRecuperateDinnerRadioItem1());

    getRecuperateDinnerRadioItem2().setButtonIndex(2);
    getRecuperateDinnerRadioModel().add(getRecuperateDinnerRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addRecuperateDinnerRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addRecuperateDinnerRadioItem2(){

  }

  /**
   * �l�����Z���W�I�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffLack(){

  }

  /**
   * �l�����Z���W�I�O���[�v���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffLackModel(){

    getStaffLackOff().setButtonIndex(1);
    getStaffLackModel().add(getStaffLackOff());

    getStaffLackStaffExcess().setButtonIndex(2);
    getStaffLackModel().add(getStaffLackStaffExcess());

    getStaffLackKaigo().setButtonIndex(3);
    getStaffLackModel().add(getStaffLackKaigo());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffLackOff(){

  }

  /**
   * ������߂ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffLackStaffExcess(){

  }

  /**
   * �Ō�E���E�����͉��x�������̕s���ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffLackKaigo(){

  }

  /**
   * �H���z�E�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addCareOldPepleWelfareFacilitiesDinnerStandeirdMoneyConteiner(){

    careOldPepleWelfareFacilitiesDinnerStandeirdMoneyConteiner.add(getCareOldPepleWelfareFacilitiesDinnerStandeirdMoneyTotal(), VRLayout.FLOW);

    careOldPepleWelfareFacilitiesDinnerStandeirdMoneyConteiner.add(getCareOldPepleWelfareFacilitiesMorningDinnerStandeirdMoneyLabel(), VRLayout.FLOW);

    careOldPepleWelfareFacilitiesDinnerStandeirdMoneyConteiner.add(getCareOldPepleWelfareFacilitiesMorningDinnerStandeirdMoney(), VRLayout.FLOW);

    careOldPepleWelfareFacilitiesDinnerStandeirdMoneyConteiner.add(getCareOldPepleWelfareFacilitiesNoonDinnerStandeirdMoneyLabel(), VRLayout.FLOW);

    careOldPepleWelfareFacilitiesDinnerStandeirdMoneyConteiner.add(getCareOldPepleWelfareFacilitiesNoonDinnerStandeirdMoney(), VRLayout.FLOW);

    careOldPepleWelfareFacilitiesDinnerStandeirdMoneyConteiner.add(getCareOldPepleWelfareFacilitiesNightDinnerStandeirdMoneyLabel(), VRLayout.FLOW);

    careOldPepleWelfareFacilitiesDinnerStandeirdMoneyConteiner.add(getCareOldPepleWelfareFacilitiesNightDinnerStandeirdMoney(), VRLayout.FLOW);

    careOldPepleWelfareFacilitiesDinnerStandeirdMoneyConteiner.add(getCareOldPepleWelfareFacilitiesDinnerStandeirdMoney4Label(), VRLayout.FLOW);

  }

  /**
   * �H���z�E���v�E�e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addCareOldPepleWelfareFacilitiesDinnerStandeirdMoneyTotal(){

  }

  /**
   * �H���z�E���E���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCareOldPepleWelfareFacilitiesMorningDinnerStandeirdMoneyLabel(){

  }

  /**
   * �H���z�E���E�e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addCareOldPepleWelfareFacilitiesMorningDinnerStandeirdMoney(){

  }

  /**
   * �H���z�E���E���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCareOldPepleWelfareFacilitiesNoonDinnerStandeirdMoneyLabel(){

  }

  /**
   * �H���z�E���E�e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addCareOldPepleWelfareFacilitiesNoonDinnerStandeirdMoney(){

  }

  /**
   * �H���z�E��E���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCareOldPepleWelfareFacilitiesNightDinnerStandeirdMoneyLabel(){

  }

  /**
   * �H���z�E��E�e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addCareOldPepleWelfareFacilitiesNightDinnerStandeirdMoney(){

  }

  /**
   * �H���z�E���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCareOldPepleWelfareFacilitiesDinnerStandeirdMoney4Label(){

  }

  /**
   * ���j�b�g�^����z�E�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addCareOldPepleWelfareFacilitiesUnitRoomStandeirdMoneyConteiner(){

    careOldPepleWelfareFacilitiesUnitRoomStandeirdMoneyConteiner.add(getCareOldPepleWelfareFacilitiesUnitRoomStandeirdMoneyText(), null);

    careOldPepleWelfareFacilitiesUnitRoomStandeirdMoneyConteiner.add(getCareOldPepleWelfareFacilitiesUnitRoomStandeirdMoneyLabel(), null);

  }

  /**
   * ���j�b�g�^����z�E�e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addCareOldPepleWelfareFacilitiesUnitRoomStandeirdMoneyText(){

  }

  /**
   * ���j�b�g�^����z�E���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCareOldPepleWelfareFacilitiesUnitRoomStandeirdMoneyLabel(){

  }

  /**
   * ���j�b�g�^������z�E�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addCareOldPepleWelfareFacilitiesUnitSemiRoomStandeirdMoneyConteiner(){

    careOldPepleWelfareFacilitiesUnitSemiRoomStandeirdMoneyConteiner.add(getCareOldPepleWelfareFacilitiesUnitSemiRoomStandeirdMoneyText(), null);

    careOldPepleWelfareFacilitiesUnitSemiRoomStandeirdMoneyConteiner.add(getCareOldPepleWelfareFacilitiesUnitSemiRoomStandeirdMoneyLabel(), null);

  }

  /**
   * ���j�b�g�^������z�E�e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addCareOldPepleWelfareFacilitiesUnitSemiRoomStandeirdMoneyText(){

  }

  /**
   * ���j�b�g�^������z�E���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCareOldPepleWelfareFacilitiesUnitSemiRoomStandeirdMoneyLabel(){

  }

  /**
   * �]���^����z�E�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addCareOldPepleWelfareFacilitiesNormalRoomStandeirdMoneyConteiner(){

    careOldPepleWelfareFacilitiesNormalRoomStandeirdMoneyConteiner.add(getCareOldPepleWelfareFacilitiesNormalRoomStandeirdMoneyText(), null);

    careOldPepleWelfareFacilitiesNormalRoomStandeirdMoneyConteiner.add(getCareOldPepleWelfareFacilitiesNormalRoomStandeirdMoneyLabel(), null);

  }

  /**
   * �]���^����z�E�e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addCareOldPepleWelfareFacilitiesNormalRoomStandeirdMoneyText(){

  }

  /**
   * �]���^����z�E���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCareOldPepleWelfareFacilitiesNormalRoomStandeirdMoneyLabel(){

  }

  /**
   * ��������z�E�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addCareOldPepleWelfareFacilitiesTasyouRoomConteiner(){

    careOldPepleWelfareFacilitiesTasyouRoomConteiner.add(getCareOldPepleWelfareFacilitiesTasyouRoomText(), null);

    careOldPepleWelfareFacilitiesTasyouRoomConteiner.add(getCareOldPepleWelfareFacilitiesTasyouRoomLabel(), null);

  }

  /**
   * ��������z�E�e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addCareOldPepleWelfareFacilitiesTasyouRoomText(){

  }

  /**
   * ��������z�E���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCareOldPepleWelfareFacilitiesTasyouRoomLabel(){

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
      ACFrame.getInstance().getContentPane().add(new QO004016Design());
      ACFrame.getInstance().setVisible(true);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QO004016Design getThis() {
    return this;
  }
}
