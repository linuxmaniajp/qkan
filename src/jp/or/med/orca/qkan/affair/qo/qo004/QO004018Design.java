
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
 * �v���O���� ���×{�^��Î{�݁i�×{�^�a�@�j (QO004018)
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
import jp.or.med.orca.qkan.lib.*;
import jp.or.med.orca.qkan.text.*;
/**
 * ���×{�^��Î{�݁i�×{�^�a�@�j��ʍ��ڃf�U�C��(QO004018) 
 */
public class QO004018Design extends ACPanel {
  //GUI�R���|�[�l���g

  private ACGroupBox kaigoRecuperationMedicalFacilitiesGroup;

  private ACLabelContainer kaigoRecuperationMedicalFacilitiesDiscountContainer;

  private ACTextField kaigoRecuperationMedicalFacilitiesDiscountRate;

  private ACLabel percentSign;

  private ACClearableRadioButtonGroup InstitutionDivisionRadio;

  private ACLabelContainer InstitutionDivisionRadioContainer;

  private ACListModelAdapter InstitutionDivisionRadioModel;

  private ACRadioButtonItem InstitutionDivisionRadioItem1;

  private ACRadioButtonItem InstitutionDivisionRadioItem2;

  private ACClearableRadioButtonGroup staffAssignmentDivision;

  private ACLabelContainer staffAssignmentDivisionContainer;

  private ACListModelAdapter staffAssignmentDivisionModel;

  private ACRadioButtonItem staffAssignmentDivision1;

  private ACRadioButtonItem staffAssignmentDivision2;

  private ACRadioButtonItem staffAssignmentDivision3;

  private ACClearableRadioButtonGroup nightShiftCondition;

  private ACLabelContainer nightShiftConditionContainer;

  private ACListModelAdapter nightShiftConditionModel;

  private ACRadioButtonItem nightShiftConditionStandard;

  private ACRadioButtonItem nightShiftConditionAddition1;

  private ACRadioButtonItem nightShiftConditionAddition2;

  private ACRadioButtonItem nightShiftConditionAddition3;

  private ACRadioButtonItem nightShiftConditionSubtraction;

  private ACClearableRadioButtonGroup recuperationEnvironmental;

  private ACLabelContainer recuperationEnvironmentalContainer;

  private ACListModelAdapter recuperationEnvironmentalModel;

  private ACRadioButtonItem recuperationEnvironmentalStandard;

  private ACRadioButtonItem recuperationEnvironmentalSubtraction1;

  private ACRadioButtonItem recuperationEnvironmentalSubtraction2;

  private ACRadioButtonItem recuperationEnvironmentalSubtraction3;

  private ACClearableRadioButtonGroup doctorsArrangement;

  private ACLabelContainer doctorsArrangementContainer;

  private ACListModelAdapter doctorsArrangementModel;

  private ACRadioButtonItem doctorsArrangementStandard;

  private ACRadioButtonItem doctorsArrangementArticle49;

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

  private ACComboBox staffReduce;

  private ACLabelContainer staffReduceContainer;

  private ACComboBoxModelAdapter staffReduceModel;

  private ACLabelContainer kaigoRecuperationMedicalFacilitiesDinnerBasicMoneyConteiner;

  private ACTextField kaigoRecuperationMedicalFacilitiesDinnerBasicMoneyTotal;

  private ACLabel kaigoRecuperationMedicalFacilitiesMorningDinnerBasicMoneyLabel;

  private ACTextField kaigoRecuperationMedicalFacilitiesMorningDinnerBasicMoney;

  private ACLabel kaigoRecuperationMedicalFacilitiesNoonDinnerBasicMoneyLabel;

  private ACTextField kaigoRecuperationMedicalFacilitiesNoonDinnerBasicMoney;

  private ACLabel kaigoRecuperationMedicalFacilitiesNightDinnerBasicMoneyLabel;

  private ACTextField kaigoRecuperationMedicalFacilitiesNightDinnerBasicMoney;

  private ACLabel kaigoRecuperationMedicalFacilitiesDinnerBasicMoney4Label;

  private ACLabelContainer kaigoRecuperationMedicalFacilitiesUnitRoomBasicMoneyConteiner;

  private ACTextField kaigoRecuperationMedicalFacilitiesUnitRoomBasicMoneyText;

  private ACLabel kaigoRecuperationMedicalFacilitiesUnitRoomBasicMoneyLabel;

  private ACLabelContainer kaigoRecuperationMedicalFacilitiesUnitSemiRoomBasicMoneyConteiner;

  private ACTextField kaigoRecuperationMedicalFacilitiesUnitSemiRoomBasicMoneyText;

  private ACLabel kaigoRecuperationMedicalFacilitiesUnitSemiRoomBasicMoneyLabel;

  private ACLabelContainer kaigoRecuperationMedicalFacilitiesNormalRoomBasicMoneyConteiner;

  private ACTextField kaigoRecuperationMedicalFacilitiesNormalRoomBasicMoneyText;

  private ACLabel kaigoRecuperationMedicalFacilitiesNormalRoomBasicMoneyLabel;

  private ACLabelContainer kaigoRecuperationMedicalFacilitiesTasyouRoomConteiner;

  private ACTextField kaigoRecuperationMedicalFacilitiesTasyouRoomText;

  private ACLabel kaigoRecuperationMedicalFacilitiesTasyouRoomLabel;

  //getter

  /**
   * ���ƃO���[�v���擾���܂��B
   * @return ���ƃO���[�v
   */
  public ACGroupBox getKaigoRecuperationMedicalFacilitiesGroup(){
    if(kaigoRecuperationMedicalFacilitiesGroup==null){

      kaigoRecuperationMedicalFacilitiesGroup = new ACGroupBox();

      kaigoRecuperationMedicalFacilitiesGroup.setText("���×{�^��Î{�݁i�×{�^�a�@�j");

      kaigoRecuperationMedicalFacilitiesGroup.setFollowChildEnabled(true);

      kaigoRecuperationMedicalFacilitiesGroup.setHgrid(200);

      addKaigoRecuperationMedicalFacilitiesGroup();
    }
    return kaigoRecuperationMedicalFacilitiesGroup;

  }

  /**
   * �������R���e�i���擾���܂��B
   * @return �������R���e�i
   */
  public ACLabelContainer getKaigoRecuperationMedicalFacilitiesDiscountContainer(){
    if(kaigoRecuperationMedicalFacilitiesDiscountContainer==null){

      kaigoRecuperationMedicalFacilitiesDiscountContainer = new ACLabelContainer();

      kaigoRecuperationMedicalFacilitiesDiscountContainer.setText("������");

      kaigoRecuperationMedicalFacilitiesDiscountContainer.setFollowChildEnabled(true);

      addKaigoRecuperationMedicalFacilitiesDiscountContainer();
    }
    return kaigoRecuperationMedicalFacilitiesDiscountContainer;

  }

  /**
   * ���������擾���܂��B
   * @return ������
   */
  public ACTextField getKaigoRecuperationMedicalFacilitiesDiscountRate(){
    if(kaigoRecuperationMedicalFacilitiesDiscountRate==null){

      kaigoRecuperationMedicalFacilitiesDiscountRate = new ACTextField();

      kaigoRecuperationMedicalFacilitiesDiscountRate.setBindPath("REDUCT_RATE");

      kaigoRecuperationMedicalFacilitiesDiscountRate.setColumns(3);

      kaigoRecuperationMedicalFacilitiesDiscountRate.setCharType(VRCharType.ONLY_DIGIT);

      kaigoRecuperationMedicalFacilitiesDiscountRate.setHorizontalAlignment(SwingConstants.RIGHT);

      kaigoRecuperationMedicalFacilitiesDiscountRate.setIMEMode(InputSubset.LATIN);

      kaigoRecuperationMedicalFacilitiesDiscountRate.setMaxLength(3);

      addKaigoRecuperationMedicalFacilitiesDiscountRate();
    }
    return kaigoRecuperationMedicalFacilitiesDiscountRate;

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
  public ACClearableRadioButtonGroup getInstitutionDivisionRadio(){
    if(InstitutionDivisionRadio==null){

      InstitutionDivisionRadio = new ACClearableRadioButtonGroup();

      getInstitutionDivisionRadioContainer().setText("�{�݋敪");

      InstitutionDivisionRadio.setBindPath("1530101");

      InstitutionDivisionRadio.setModel(getInstitutionDivisionRadioModel());

      InstitutionDivisionRadio.setUseClearButton(false);

      addInstitutionDivisionRadio();
    }
    return InstitutionDivisionRadio;

  }

  /**
   * �{�݋敪���W�I�O���[�v�R���e�i���擾���܂��B
   * @return �{�݋敪���W�I�O���[�v�R���e�i
   */
  protected ACLabelContainer getInstitutionDivisionRadioContainer(){
    if(InstitutionDivisionRadioContainer==null){
      InstitutionDivisionRadioContainer = new ACLabelContainer();
      InstitutionDivisionRadioContainer.setFollowChildEnabled(true);
      InstitutionDivisionRadioContainer.add(getInstitutionDivisionRadio(), null);
    }
    return InstitutionDivisionRadioContainer;
  }

  /**
   * �{�݋敪���W�I�O���[�v���f�����擾���܂��B
   * @return �{�݋敪���W�I�O���[�v���f��
   */
  protected ACListModelAdapter getInstitutionDivisionRadioModel(){
    if(InstitutionDivisionRadioModel==null){
      InstitutionDivisionRadioModel = new ACListModelAdapter();
      addInstitutionDivisionRadioModel();
    }
    return InstitutionDivisionRadioModel;
  }

  /**
   * �a�@���擾���܂��B
   * @return �a�@
   */
  public ACRadioButtonItem getInstitutionDivisionRadioItem1(){
    if(InstitutionDivisionRadioItem1==null){

      InstitutionDivisionRadioItem1 = new ACRadioButtonItem();

      InstitutionDivisionRadioItem1.setText("�a�@");

      InstitutionDivisionRadioItem1.setGroup(getInstitutionDivisionRadio());

      addInstitutionDivisionRadioItem1();
    }
    return InstitutionDivisionRadioItem1;

  }

  /**
   * ���j�b�g�^�a�@���擾���܂��B
   * @return ���j�b�g�^�a�@
   */
  public ACRadioButtonItem getInstitutionDivisionRadioItem2(){
    if(InstitutionDivisionRadioItem2==null){

      InstitutionDivisionRadioItem2 = new ACRadioButtonItem();

      InstitutionDivisionRadioItem2.setText("���j�b�g�^�a�@");

      InstitutionDivisionRadioItem2.setGroup(getInstitutionDivisionRadio());

      addInstitutionDivisionRadioItem2();
    }
    return InstitutionDivisionRadioItem2;

  }

  /**
   * �l���z�u�敪���W�I�O���[�v���擾���܂��B
   * @return �l���z�u�敪���W�I�O���[�v
   */
  public ACClearableRadioButtonGroup getStaffAssignmentDivision(){
    if(staffAssignmentDivision==null){

      staffAssignmentDivision = new ACClearableRadioButtonGroup();

      getStaffAssignmentDivisionContainer().setText("�l���z�u�敪");

      staffAssignmentDivision.setBindPath("1530102");

      staffAssignmentDivision.setModel(getStaffAssignmentDivisionModel());

      staffAssignmentDivision.setUseClearButton(false);

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
   * I�^���擾���܂��B
   * @return I�^
   */
  public ACRadioButtonItem getStaffAssignmentDivision1(){
    if(staffAssignmentDivision1==null){

      staffAssignmentDivision1 = new ACRadioButtonItem();

      staffAssignmentDivision1.setText("I�^");

      staffAssignmentDivision1.setGroup(getStaffAssignmentDivision());

      addStaffAssignmentDivision1();
    }
    return staffAssignmentDivision1;

  }

  /**
   * II�^���擾���܂��B
   * @return II�^
   */
  public ACRadioButtonItem getStaffAssignmentDivision2(){
    if(staffAssignmentDivision2==null){

      staffAssignmentDivision2 = new ACRadioButtonItem();

      staffAssignmentDivision2.setText("II�^");

      staffAssignmentDivision2.setGroup(getStaffAssignmentDivision());

      addStaffAssignmentDivision2();
    }
    return staffAssignmentDivision2;

  }

  /**
   * III�^���擾���܂��B
   * @return III�^
   */
  public ACRadioButtonItem getStaffAssignmentDivision3(){
    if(staffAssignmentDivision3==null){

      staffAssignmentDivision3 = new ACRadioButtonItem();

      staffAssignmentDivision3.setText("III�^");

      staffAssignmentDivision3.setGroup(getStaffAssignmentDivision());

      addStaffAssignmentDivision3();
    }
    return staffAssignmentDivision3;

  }

  /**
   * ��ԋΖ���������W�I�O���[�v���擾���܂��B
   * @return ��ԋΖ���������W�I�O���[�v
   */
  public ACClearableRadioButtonGroup getNightShiftCondition(){
    if(nightShiftCondition==null){

      nightShiftCondition = new ACClearableRadioButtonGroup();

      getNightShiftConditionContainer().setText("��ԋΖ������");

      nightShiftCondition.setBindPath("1530103");

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
   * ���Z�^I���擾���܂��B
   * @return ���Z�^I
   */
  public ACRadioButtonItem getNightShiftConditionAddition1(){
    if(nightShiftConditionAddition1==null){

      nightShiftConditionAddition1 = new ACRadioButtonItem();

      nightShiftConditionAddition1.setText("���Z�^I");

      nightShiftConditionAddition1.setGroup(getNightShiftCondition());

      addNightShiftConditionAddition1();
    }
    return nightShiftConditionAddition1;

  }

  /**
   * ���Z�^II���擾���܂��B
   * @return ���Z�^II
   */
  public ACRadioButtonItem getNightShiftConditionAddition2(){
    if(nightShiftConditionAddition2==null){

      nightShiftConditionAddition2 = new ACRadioButtonItem();

      nightShiftConditionAddition2.setText("���Z�^II");

      nightShiftConditionAddition2.setGroup(getNightShiftCondition());

      addNightShiftConditionAddition2();
    }
    return nightShiftConditionAddition2;

  }

  /**
   * ���Z�^III���擾���܂��B
   * @return ���Z�^III
   */
  public ACRadioButtonItem getNightShiftConditionAddition3(){
    if(nightShiftConditionAddition3==null){

      nightShiftConditionAddition3 = new ACRadioButtonItem();

      nightShiftConditionAddition3.setText("���Z�^III");

      nightShiftConditionAddition3.setGroup(getNightShiftCondition());

      addNightShiftConditionAddition3();
    }
    return nightShiftConditionAddition3;

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
   * �×{������W�I�O���[�v���擾���܂��B
   * @return �×{������W�I�O���[�v
   */
  public ACClearableRadioButtonGroup getRecuperationEnvironmental(){
    if(recuperationEnvironmental==null){

      recuperationEnvironmental = new ACClearableRadioButtonGroup();

      getRecuperationEnvironmentalContainer().setText("�×{���");

      recuperationEnvironmental.setBindPath("1530104");

      recuperationEnvironmental.setModel(getRecuperationEnvironmentalModel());

      recuperationEnvironmental.setUseClearButton(false);

      addRecuperationEnvironmental();
    }
    return recuperationEnvironmental;

  }

  /**
   * �×{������W�I�O���[�v�R���e�i���擾���܂��B
   * @return �×{������W�I�O���[�v�R���e�i
   */
  protected ACLabelContainer getRecuperationEnvironmentalContainer(){
    if(recuperationEnvironmentalContainer==null){
      recuperationEnvironmentalContainer = new ACLabelContainer();
      recuperationEnvironmentalContainer.setFollowChildEnabled(true);
      recuperationEnvironmentalContainer.add(getRecuperationEnvironmental(), null);
    }
    return recuperationEnvironmentalContainer;
  }

  /**
   * �×{������W�I�O���[�v���f�����擾���܂��B
   * @return �×{������W�I�O���[�v���f��
   */
  protected ACListModelAdapter getRecuperationEnvironmentalModel(){
    if(recuperationEnvironmentalModel==null){
      recuperationEnvironmentalModel = new ACListModelAdapter();
      addRecuperationEnvironmentalModel();
    }
    return recuperationEnvironmentalModel;
  }

  /**
   * ��^���擾���܂��B
   * @return ��^
   */
  public ACRadioButtonItem getRecuperationEnvironmentalStandard(){
    if(recuperationEnvironmentalStandard==null){

      recuperationEnvironmentalStandard = new ACRadioButtonItem();

      recuperationEnvironmentalStandard.setText("��^");

      recuperationEnvironmentalStandard.setGroup(getRecuperationEnvironmental());

      addRecuperationEnvironmentalStandard();
    }
    return recuperationEnvironmentalStandard;

  }

  /**
   * ���Z�^I���擾���܂��B
   * @return ���Z�^I
   */
  public ACRadioButtonItem getRecuperationEnvironmentalSubtraction1(){
    if(recuperationEnvironmentalSubtraction1==null){

      recuperationEnvironmentalSubtraction1 = new ACRadioButtonItem();

      recuperationEnvironmentalSubtraction1.setText("���Z�^I");

      recuperationEnvironmentalSubtraction1.setGroup(getRecuperationEnvironmental());

      addRecuperationEnvironmentalSubtraction1();
    }
    return recuperationEnvironmentalSubtraction1;

  }

  /**
   * ���Z�^II���擾���܂��B
   * @return ���Z�^II
   */
  public ACRadioButtonItem getRecuperationEnvironmentalSubtraction2(){
    if(recuperationEnvironmentalSubtraction2==null){

      recuperationEnvironmentalSubtraction2 = new ACRadioButtonItem();

      recuperationEnvironmentalSubtraction2.setText("���Z�^II");

      recuperationEnvironmentalSubtraction2.setGroup(getRecuperationEnvironmental());

      addRecuperationEnvironmentalSubtraction2();
    }
    return recuperationEnvironmentalSubtraction2;

  }

  /**
   * ���Z�^III���擾���܂��B
   * @return ���Z�^III
   */
  public ACRadioButtonItem getRecuperationEnvironmentalSubtraction3(){
    if(recuperationEnvironmentalSubtraction3==null){

      recuperationEnvironmentalSubtraction3 = new ACRadioButtonItem();

      recuperationEnvironmentalSubtraction3.setText("���Z�^III");

      recuperationEnvironmentalSubtraction3.setGroup(getRecuperationEnvironmental());

      addRecuperationEnvironmentalSubtraction3();
    }
    return recuperationEnvironmentalSubtraction3;

  }

  /**
   * ��t�̔z�u����W�I�O���[�v���擾���܂��B
   * @return ��t�̔z�u����W�I�O���[�v
   */
  public ACClearableRadioButtonGroup getDoctorsArrangement(){
    if(doctorsArrangement==null){

      doctorsArrangement = new ACClearableRadioButtonGroup();

      getDoctorsArrangementContainer().setText("��t�̔z�u�");

      doctorsArrangement.setBindPath("1530105");

      doctorsArrangement.setModel(getDoctorsArrangementModel());

      doctorsArrangement.setUseClearButton(false);

      addDoctorsArrangement();
    }
    return doctorsArrangement;

  }

  /**
   * ��t�̔z�u����W�I�O���[�v�R���e�i���擾���܂��B
   * @return ��t�̔z�u����W�I�O���[�v�R���e�i
   */
  protected ACLabelContainer getDoctorsArrangementContainer(){
    if(doctorsArrangementContainer==null){
      doctorsArrangementContainer = new ACLabelContainer();
      doctorsArrangementContainer.setFollowChildEnabled(true);
      doctorsArrangementContainer.add(getDoctorsArrangement(), null);
    }
    return doctorsArrangementContainer;
  }

  /**
   * ��t�̔z�u����W�I�O���[�v���f�����擾���܂��B
   * @return ��t�̔z�u����W�I�O���[�v���f��
   */
  protected ACListModelAdapter getDoctorsArrangementModel(){
    if(doctorsArrangementModel==null){
      doctorsArrangementModel = new ACListModelAdapter();
      addDoctorsArrangementModel();
    }
    return doctorsArrangementModel;
  }

  /**
   * ����擾���܂��B
   * @return �
   */
  public ACRadioButtonItem getDoctorsArrangementStandard(){
    if(doctorsArrangementStandard==null){

      doctorsArrangementStandard = new ACRadioButtonItem();

      doctorsArrangementStandard.setText("�");

      doctorsArrangementStandard.setGroup(getDoctorsArrangement());

      addDoctorsArrangementStandard();
    }
    return doctorsArrangementStandard;

  }

  /**
   * ��Ö@�{�s�K����49��K�p���擾���܂��B
   * @return ��Ö@�{�s�K����49��K�p
   */
  public ACRadioButtonItem getDoctorsArrangementArticle49(){
    if(doctorsArrangementArticle49==null){

      doctorsArrangementArticle49 = new ACRadioButtonItem();

      doctorsArrangementArticle49.setText("49��K�p");

      doctorsArrangementArticle49.setGroup(getDoctorsArrangement());

      addDoctorsArrangementArticle49();
    }
    return doctorsArrangementArticle49;

  }

  /**
   * �h�{�Ǘ��̐����W�I�O���[�v���擾���܂��B
   * @return �h�{�Ǘ��̐����W�I�O���[�v
   */
  public ACClearableRadioButtonGroup getNutritionManageRadio(){
    if(nutritionManageRadio==null){

      nutritionManageRadio = new ACClearableRadioButtonGroup();

      getNutritionManageRadioContainer().setText("�h�{�Ǘ��̐�");

      nutritionManageRadio.setBindPath("1530106");

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

      nutritionRadio.setBindPath("1530107");

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

      oralSwitchRadio.setBindPath("1530108");

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

      recuperateDinnerRadio.setBindPath("1530109");

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
   * �l�����Z���擾���܂��B
   * @return �l�����Z
   */
  public ACComboBox getStaffReduce(){
    if(staffReduce==null){

      staffReduce = new ACComboBox();

      getStaffReduceContainer().setText("�l�����Z");

      staffReduce.setBindPath("1530110");

      staffReduce.setEditable(false);

      staffReduce.setModel(getStaffReduceModel());

      staffReduce.setRenderBindPath("CONTENT");

      addStaffReduce();
    }
    return staffReduce;

  }

  /**
   * �l�����Z�R���e�i���擾���܂��B
   * @return �l�����Z�R���e�i
   */
  protected ACLabelContainer getStaffReduceContainer(){
    if(staffReduceContainer==null){
      staffReduceContainer = new ACLabelContainer();
      staffReduceContainer.setFollowChildEnabled(true);
      staffReduceContainer.add(getStaffReduce(), null);
    }
    return staffReduceContainer;
  }

  /**
   * �l�����Z���f�����擾���܂��B
   * @return �l�����Z���f��
   */
  protected ACComboBoxModelAdapter getStaffReduceModel(){
    if(staffReduceModel==null){
      staffReduceModel = new ACComboBoxModelAdapter();
      addStaffReduceModel();
    }
    return staffReduceModel;
  }

  /**
   * �H���z�E�R���e�i���擾���܂��B
   * @return �H���z�E�R���e�i
   */
  public ACLabelContainer getKaigoRecuperationMedicalFacilitiesDinnerBasicMoneyConteiner(){
    if(kaigoRecuperationMedicalFacilitiesDinnerBasicMoneyConteiner==null){

      kaigoRecuperationMedicalFacilitiesDinnerBasicMoneyConteiner = new ACLabelContainer();

      kaigoRecuperationMedicalFacilitiesDinnerBasicMoneyConteiner.setText("�H���z");

      kaigoRecuperationMedicalFacilitiesDinnerBasicMoneyConteiner.setFollowChildEnabled(true);

      addKaigoRecuperationMedicalFacilitiesDinnerBasicMoneyConteiner();
    }
    return kaigoRecuperationMedicalFacilitiesDinnerBasicMoneyConteiner;

  }

  /**
   * �H���z�E���v�E�e�L�X�g���擾���܂��B
   * @return �H���z�E���v�E�e�L�X�g
   */
  public ACTextField getKaigoRecuperationMedicalFacilitiesDinnerBasicMoneyTotal(){
    if(kaigoRecuperationMedicalFacilitiesDinnerBasicMoneyTotal==null){

      kaigoRecuperationMedicalFacilitiesDinnerBasicMoneyTotal = new ACTextField();

      kaigoRecuperationMedicalFacilitiesDinnerBasicMoneyTotal.setBindPath("1530111");

      kaigoRecuperationMedicalFacilitiesDinnerBasicMoneyTotal.setEditable(false);

      kaigoRecuperationMedicalFacilitiesDinnerBasicMoneyTotal.setColumns(4);

      kaigoRecuperationMedicalFacilitiesDinnerBasicMoneyTotal.setCharType(VRCharType.ONLY_DIGIT);

      kaigoRecuperationMedicalFacilitiesDinnerBasicMoneyTotal.setIMEMode(InputSubset.LATIN);

      kaigoRecuperationMedicalFacilitiesDinnerBasicMoneyTotal.setMaxLength(4);

      addKaigoRecuperationMedicalFacilitiesDinnerBasicMoneyTotal();
    }
    return kaigoRecuperationMedicalFacilitiesDinnerBasicMoneyTotal;

  }

  /**
   * �H���z�E���E���x�����擾���܂��B
   * @return �H���z�E���E���x��
   */
  public ACLabel getKaigoRecuperationMedicalFacilitiesMorningDinnerBasicMoneyLabel(){
    if(kaigoRecuperationMedicalFacilitiesMorningDinnerBasicMoneyLabel==null){

      kaigoRecuperationMedicalFacilitiesMorningDinnerBasicMoneyLabel = new ACLabel();

      kaigoRecuperationMedicalFacilitiesMorningDinnerBasicMoneyLabel.setText("�@��");

      addKaigoRecuperationMedicalFacilitiesMorningDinnerBasicMoneyLabel();
    }
    return kaigoRecuperationMedicalFacilitiesMorningDinnerBasicMoneyLabel;

  }

  /**
   * �H���z�E���E�e�L�X�g���擾���܂��B
   * @return �H���z�E���E�e�L�X�g
   */
  public ACTextField getKaigoRecuperationMedicalFacilitiesMorningDinnerBasicMoney(){
    if(kaigoRecuperationMedicalFacilitiesMorningDinnerBasicMoney==null){

      kaigoRecuperationMedicalFacilitiesMorningDinnerBasicMoney = new ACTextField();

      kaigoRecuperationMedicalFacilitiesMorningDinnerBasicMoney.setBindPath("1530112");

      kaigoRecuperationMedicalFacilitiesMorningDinnerBasicMoney.setColumns(3);

      kaigoRecuperationMedicalFacilitiesMorningDinnerBasicMoney.setCharType(VRCharType.ONLY_DIGIT);

      kaigoRecuperationMedicalFacilitiesMorningDinnerBasicMoney.setHorizontalAlignment(SwingConstants.RIGHT);

      kaigoRecuperationMedicalFacilitiesMorningDinnerBasicMoney.setIMEMode(InputSubset.LATIN);

      kaigoRecuperationMedicalFacilitiesMorningDinnerBasicMoney.setMaxLength(3);

      addKaigoRecuperationMedicalFacilitiesMorningDinnerBasicMoney();
    }
    return kaigoRecuperationMedicalFacilitiesMorningDinnerBasicMoney;

  }

  /**
   * �H���z�E���E���x�����擾���܂��B
   * @return �H���z�E���E���x��
   */
  public ACLabel getKaigoRecuperationMedicalFacilitiesNoonDinnerBasicMoneyLabel(){
    if(kaigoRecuperationMedicalFacilitiesNoonDinnerBasicMoneyLabel==null){

      kaigoRecuperationMedicalFacilitiesNoonDinnerBasicMoneyLabel = new ACLabel();

      kaigoRecuperationMedicalFacilitiesNoonDinnerBasicMoneyLabel.setText("��");

      addKaigoRecuperationMedicalFacilitiesNoonDinnerBasicMoneyLabel();
    }
    return kaigoRecuperationMedicalFacilitiesNoonDinnerBasicMoneyLabel;

  }

  /**
   * �H���z�E���E�e�L�X�g���擾���܂��B
   * @return �H���z�E���E�e�L�X�g
   */
  public ACTextField getKaigoRecuperationMedicalFacilitiesNoonDinnerBasicMoney(){
    if(kaigoRecuperationMedicalFacilitiesNoonDinnerBasicMoney==null){

      kaigoRecuperationMedicalFacilitiesNoonDinnerBasicMoney = new ACTextField();

      kaigoRecuperationMedicalFacilitiesNoonDinnerBasicMoney.setBindPath("1530113");

      kaigoRecuperationMedicalFacilitiesNoonDinnerBasicMoney.setColumns(3);

      kaigoRecuperationMedicalFacilitiesNoonDinnerBasicMoney.setCharType(VRCharType.ONLY_DIGIT);

      kaigoRecuperationMedicalFacilitiesNoonDinnerBasicMoney.setHorizontalAlignment(SwingConstants.RIGHT);

      kaigoRecuperationMedicalFacilitiesNoonDinnerBasicMoney.setIMEMode(InputSubset.LATIN);

      kaigoRecuperationMedicalFacilitiesNoonDinnerBasicMoney.setMaxLength(3);

      addKaigoRecuperationMedicalFacilitiesNoonDinnerBasicMoney();
    }
    return kaigoRecuperationMedicalFacilitiesNoonDinnerBasicMoney;

  }

  /**
   * �H���z�E��E���x�����擾���܂��B
   * @return �H���z�E��E���x��
   */
  public ACLabel getKaigoRecuperationMedicalFacilitiesNightDinnerBasicMoneyLabel(){
    if(kaigoRecuperationMedicalFacilitiesNightDinnerBasicMoneyLabel==null){

      kaigoRecuperationMedicalFacilitiesNightDinnerBasicMoneyLabel = new ACLabel();

      kaigoRecuperationMedicalFacilitiesNightDinnerBasicMoneyLabel.setText("��");

      addKaigoRecuperationMedicalFacilitiesNightDinnerBasicMoneyLabel();
    }
    return kaigoRecuperationMedicalFacilitiesNightDinnerBasicMoneyLabel;

  }

  /**
   * �H���z�E��E�e�L�X�g���擾���܂��B
   * @return �H���z�E��E�e�L�X�g
   */
  public ACTextField getKaigoRecuperationMedicalFacilitiesNightDinnerBasicMoney(){
    if(kaigoRecuperationMedicalFacilitiesNightDinnerBasicMoney==null){

      kaigoRecuperationMedicalFacilitiesNightDinnerBasicMoney = new ACTextField();

      kaigoRecuperationMedicalFacilitiesNightDinnerBasicMoney.setBindPath("1530114");

      kaigoRecuperationMedicalFacilitiesNightDinnerBasicMoney.setColumns(3);

      kaigoRecuperationMedicalFacilitiesNightDinnerBasicMoney.setCharType(VRCharType.ONLY_DIGIT);

      kaigoRecuperationMedicalFacilitiesNightDinnerBasicMoney.setHorizontalAlignment(SwingConstants.RIGHT);

      kaigoRecuperationMedicalFacilitiesNightDinnerBasicMoney.setIMEMode(InputSubset.LATIN);

      kaigoRecuperationMedicalFacilitiesNightDinnerBasicMoney.setMaxLength(3);

      addKaigoRecuperationMedicalFacilitiesNightDinnerBasicMoney();
    }
    return kaigoRecuperationMedicalFacilitiesNightDinnerBasicMoney;

  }

  /**
   * �H���z�E���x�����擾���܂��B
   * @return �H���z�E���x��
   */
  public ACLabel getKaigoRecuperationMedicalFacilitiesDinnerBasicMoney4Label(){
    if(kaigoRecuperationMedicalFacilitiesDinnerBasicMoney4Label==null){

      kaigoRecuperationMedicalFacilitiesDinnerBasicMoney4Label = new ACLabel();

      kaigoRecuperationMedicalFacilitiesDinnerBasicMoney4Label.setText("�i�~�j");

      addKaigoRecuperationMedicalFacilitiesDinnerBasicMoney4Label();
    }
    return kaigoRecuperationMedicalFacilitiesDinnerBasicMoney4Label;

  }

  /**
   * ���j�b�g�^����z�E�R���e�i���擾���܂��B
   * @return ���j�b�g�^����z�E�R���e�i
   */
  public ACLabelContainer getKaigoRecuperationMedicalFacilitiesUnitRoomBasicMoneyConteiner(){
    if(kaigoRecuperationMedicalFacilitiesUnitRoomBasicMoneyConteiner==null){

      kaigoRecuperationMedicalFacilitiesUnitRoomBasicMoneyConteiner = new ACLabelContainer();

      kaigoRecuperationMedicalFacilitiesUnitRoomBasicMoneyConteiner.setText("���j�b�g�^����z");

      kaigoRecuperationMedicalFacilitiesUnitRoomBasicMoneyConteiner.setFollowChildEnabled(true);

      addKaigoRecuperationMedicalFacilitiesUnitRoomBasicMoneyConteiner();
    }
    return kaigoRecuperationMedicalFacilitiesUnitRoomBasicMoneyConteiner;

  }

  /**
   * ���j�b�g�^����z�E�e�L�X�g���擾���܂��B
   * @return ���j�b�g�^����z�E�e�L�X�g
   */
  public ACTextField getKaigoRecuperationMedicalFacilitiesUnitRoomBasicMoneyText(){
    if(kaigoRecuperationMedicalFacilitiesUnitRoomBasicMoneyText==null){

      kaigoRecuperationMedicalFacilitiesUnitRoomBasicMoneyText = new ACTextField();

      kaigoRecuperationMedicalFacilitiesUnitRoomBasicMoneyText.setBindPath("1530115");

      kaigoRecuperationMedicalFacilitiesUnitRoomBasicMoneyText.setColumns(4);

      kaigoRecuperationMedicalFacilitiesUnitRoomBasicMoneyText.setCharType(VRCharType.ONLY_DIGIT);

      kaigoRecuperationMedicalFacilitiesUnitRoomBasicMoneyText.setHorizontalAlignment(SwingConstants.RIGHT);

      kaigoRecuperationMedicalFacilitiesUnitRoomBasicMoneyText.setIMEMode(InputSubset.LATIN);

      kaigoRecuperationMedicalFacilitiesUnitRoomBasicMoneyText.setMaxLength(4);

      addKaigoRecuperationMedicalFacilitiesUnitRoomBasicMoneyText();
    }
    return kaigoRecuperationMedicalFacilitiesUnitRoomBasicMoneyText;

  }

  /**
   * ���j�b�g�^����z�E���x�����擾���܂��B
   * @return ���j�b�g�^����z�E���x��
   */
  public ACLabel getKaigoRecuperationMedicalFacilitiesUnitRoomBasicMoneyLabel(){
    if(kaigoRecuperationMedicalFacilitiesUnitRoomBasicMoneyLabel==null){

      kaigoRecuperationMedicalFacilitiesUnitRoomBasicMoneyLabel = new ACLabel();

      kaigoRecuperationMedicalFacilitiesUnitRoomBasicMoneyLabel.setText("�i�~�j");

      addKaigoRecuperationMedicalFacilitiesUnitRoomBasicMoneyLabel();
    }
    return kaigoRecuperationMedicalFacilitiesUnitRoomBasicMoneyLabel;

  }

  /**
   * ���j�b�g�^������z�E�R���e�i���擾���܂��B
   * @return ���j�b�g�^������z�E�R���e�i
   */
  public ACLabelContainer getKaigoRecuperationMedicalFacilitiesUnitSemiRoomBasicMoneyConteiner(){
    if(kaigoRecuperationMedicalFacilitiesUnitSemiRoomBasicMoneyConteiner==null){

      kaigoRecuperationMedicalFacilitiesUnitSemiRoomBasicMoneyConteiner = new ACLabelContainer();

      kaigoRecuperationMedicalFacilitiesUnitSemiRoomBasicMoneyConteiner.setText("���j�b�g�^������z");

      kaigoRecuperationMedicalFacilitiesUnitSemiRoomBasicMoneyConteiner.setFollowChildEnabled(true);

      addKaigoRecuperationMedicalFacilitiesUnitSemiRoomBasicMoneyConteiner();
    }
    return kaigoRecuperationMedicalFacilitiesUnitSemiRoomBasicMoneyConteiner;

  }

  /**
   * ���j�b�g�^������z�E�e�L�X�g���擾���܂��B
   * @return ���j�b�g�^������z�E�e�L�X�g
   */
  public ACTextField getKaigoRecuperationMedicalFacilitiesUnitSemiRoomBasicMoneyText(){
    if(kaigoRecuperationMedicalFacilitiesUnitSemiRoomBasicMoneyText==null){

      kaigoRecuperationMedicalFacilitiesUnitSemiRoomBasicMoneyText = new ACTextField();

      kaigoRecuperationMedicalFacilitiesUnitSemiRoomBasicMoneyText.setBindPath("1530116");

      kaigoRecuperationMedicalFacilitiesUnitSemiRoomBasicMoneyText.setColumns(4);

      kaigoRecuperationMedicalFacilitiesUnitSemiRoomBasicMoneyText.setCharType(VRCharType.ONLY_DIGIT);

      kaigoRecuperationMedicalFacilitiesUnitSemiRoomBasicMoneyText.setHorizontalAlignment(SwingConstants.RIGHT);

      kaigoRecuperationMedicalFacilitiesUnitSemiRoomBasicMoneyText.setIMEMode(InputSubset.LATIN);

      kaigoRecuperationMedicalFacilitiesUnitSemiRoomBasicMoneyText.setMaxLength(4);

      addKaigoRecuperationMedicalFacilitiesUnitSemiRoomBasicMoneyText();
    }
    return kaigoRecuperationMedicalFacilitiesUnitSemiRoomBasicMoneyText;

  }

  /**
   * ���j�b�g�^������z�E���x�����擾���܂��B
   * @return ���j�b�g�^������z�E���x��
   */
  public ACLabel getKaigoRecuperationMedicalFacilitiesUnitSemiRoomBasicMoneyLabel(){
    if(kaigoRecuperationMedicalFacilitiesUnitSemiRoomBasicMoneyLabel==null){

      kaigoRecuperationMedicalFacilitiesUnitSemiRoomBasicMoneyLabel = new ACLabel();

      kaigoRecuperationMedicalFacilitiesUnitSemiRoomBasicMoneyLabel.setText("�i�~�j");

      addKaigoRecuperationMedicalFacilitiesUnitSemiRoomBasicMoneyLabel();
    }
    return kaigoRecuperationMedicalFacilitiesUnitSemiRoomBasicMoneyLabel;

  }

  /**
   * �]���^����z�E�R���e�i���擾���܂��B
   * @return �]���^����z�E�R���e�i
   */
  public ACLabelContainer getKaigoRecuperationMedicalFacilitiesNormalRoomBasicMoneyConteiner(){
    if(kaigoRecuperationMedicalFacilitiesNormalRoomBasicMoneyConteiner==null){

      kaigoRecuperationMedicalFacilitiesNormalRoomBasicMoneyConteiner = new ACLabelContainer();

      kaigoRecuperationMedicalFacilitiesNormalRoomBasicMoneyConteiner.setText("�@�@�]���^����z");

      kaigoRecuperationMedicalFacilitiesNormalRoomBasicMoneyConteiner.setFollowChildEnabled(true);

      addKaigoRecuperationMedicalFacilitiesNormalRoomBasicMoneyConteiner();
    }
    return kaigoRecuperationMedicalFacilitiesNormalRoomBasicMoneyConteiner;

  }

  /**
   * �]���^����z�E�e�L�X�g���擾���܂��B
   * @return �]���^����z�E�e�L�X�g
   */
  public ACTextField getKaigoRecuperationMedicalFacilitiesNormalRoomBasicMoneyText(){
    if(kaigoRecuperationMedicalFacilitiesNormalRoomBasicMoneyText==null){

      kaigoRecuperationMedicalFacilitiesNormalRoomBasicMoneyText = new ACTextField();

      kaigoRecuperationMedicalFacilitiesNormalRoomBasicMoneyText.setBindPath("1530117");

      kaigoRecuperationMedicalFacilitiesNormalRoomBasicMoneyText.setColumns(4);

      kaigoRecuperationMedicalFacilitiesNormalRoomBasicMoneyText.setCharType(VRCharType.ONLY_DIGIT);

      kaigoRecuperationMedicalFacilitiesNormalRoomBasicMoneyText.setHorizontalAlignment(SwingConstants.RIGHT);

      kaigoRecuperationMedicalFacilitiesNormalRoomBasicMoneyText.setIMEMode(InputSubset.LATIN);

      kaigoRecuperationMedicalFacilitiesNormalRoomBasicMoneyText.setMaxLength(4);

      addKaigoRecuperationMedicalFacilitiesNormalRoomBasicMoneyText();
    }
    return kaigoRecuperationMedicalFacilitiesNormalRoomBasicMoneyText;

  }

  /**
   * �]���^����z�E���x�����擾���܂��B
   * @return �]���^����z�E���x��
   */
  public ACLabel getKaigoRecuperationMedicalFacilitiesNormalRoomBasicMoneyLabel(){
    if(kaigoRecuperationMedicalFacilitiesNormalRoomBasicMoneyLabel==null){

      kaigoRecuperationMedicalFacilitiesNormalRoomBasicMoneyLabel = new ACLabel();

      kaigoRecuperationMedicalFacilitiesNormalRoomBasicMoneyLabel.setText("�i�~�j");

      addKaigoRecuperationMedicalFacilitiesNormalRoomBasicMoneyLabel();
    }
    return kaigoRecuperationMedicalFacilitiesNormalRoomBasicMoneyLabel;

  }

  /**
   * ��������z�E�R���e�i���擾���܂��B
   * @return ��������z�E�R���e�i
   */
  public ACLabelContainer getKaigoRecuperationMedicalFacilitiesTasyouRoomConteiner(){
    if(kaigoRecuperationMedicalFacilitiesTasyouRoomConteiner==null){

      kaigoRecuperationMedicalFacilitiesTasyouRoomConteiner = new ACLabelContainer();

      kaigoRecuperationMedicalFacilitiesTasyouRoomConteiner.setText("�@�@��������z");

      kaigoRecuperationMedicalFacilitiesTasyouRoomConteiner.setFollowChildEnabled(true);

      addKaigoRecuperationMedicalFacilitiesTasyouRoomConteiner();
    }
    return kaigoRecuperationMedicalFacilitiesTasyouRoomConteiner;

  }

  /**
   * ��������z�E�e�L�X�g���擾���܂��B
   * @return ��������z�E�e�L�X�g
   */
  public ACTextField getKaigoRecuperationMedicalFacilitiesTasyouRoomText(){
    if(kaigoRecuperationMedicalFacilitiesTasyouRoomText==null){

      kaigoRecuperationMedicalFacilitiesTasyouRoomText = new ACTextField();

      kaigoRecuperationMedicalFacilitiesTasyouRoomText.setBindPath("1530118");

      kaigoRecuperationMedicalFacilitiesTasyouRoomText.setColumns(4);

      kaigoRecuperationMedicalFacilitiesTasyouRoomText.setCharType(VRCharType.ONLY_DIGIT);

      kaigoRecuperationMedicalFacilitiesTasyouRoomText.setHorizontalAlignment(SwingConstants.RIGHT);

      kaigoRecuperationMedicalFacilitiesTasyouRoomText.setIMEMode(InputSubset.LATIN);

      kaigoRecuperationMedicalFacilitiesTasyouRoomText.setMaxLength(4);

      addKaigoRecuperationMedicalFacilitiesTasyouRoomText();
    }
    return kaigoRecuperationMedicalFacilitiesTasyouRoomText;

  }

  /**
   * ��������z�E���x�����擾���܂��B
   * @return ��������z�E���x��
   */
  public ACLabel getKaigoRecuperationMedicalFacilitiesTasyouRoomLabel(){
    if(kaigoRecuperationMedicalFacilitiesTasyouRoomLabel==null){

      kaigoRecuperationMedicalFacilitiesTasyouRoomLabel = new ACLabel();

      kaigoRecuperationMedicalFacilitiesTasyouRoomLabel.setText("�i�~�j");

      addKaigoRecuperationMedicalFacilitiesTasyouRoomLabel();
    }
    return kaigoRecuperationMedicalFacilitiesTasyouRoomLabel;

  }

  /**
   * �R���X�g���N�^�ł��B
   */
  public QO004018Design() {

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

    this.add(getKaigoRecuperationMedicalFacilitiesGroup(), VRLayout.CLIENT);

  }

  /**
   * ���ƃO���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoRecuperationMedicalFacilitiesGroup(){

    kaigoRecuperationMedicalFacilitiesGroup.add(getKaigoRecuperationMedicalFacilitiesDiscountContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    kaigoRecuperationMedicalFacilitiesGroup.add(getInstitutionDivisionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    kaigoRecuperationMedicalFacilitiesGroup.add(getStaffAssignmentDivisionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    kaigoRecuperationMedicalFacilitiesGroup.add(getNightShiftConditionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    kaigoRecuperationMedicalFacilitiesGroup.add(getRecuperationEnvironmentalContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    kaigoRecuperationMedicalFacilitiesGroup.add(getDoctorsArrangementContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    kaigoRecuperationMedicalFacilitiesGroup.add(getNutritionManageRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    kaigoRecuperationMedicalFacilitiesGroup.add(getNutritionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    kaigoRecuperationMedicalFacilitiesGroup.add(getOralSwitchRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    kaigoRecuperationMedicalFacilitiesGroup.add(getRecuperateDinnerRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    kaigoRecuperationMedicalFacilitiesGroup.add(getStaffReduceContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    kaigoRecuperationMedicalFacilitiesGroup.add(getKaigoRecuperationMedicalFacilitiesDinnerBasicMoneyConteiner(), VRLayout.FLOW_INSETLINE_RETURN);

    kaigoRecuperationMedicalFacilitiesGroup.add(getKaigoRecuperationMedicalFacilitiesUnitRoomBasicMoneyConteiner(), VRLayout.FLOW_INSETLINE_RETURN);

    kaigoRecuperationMedicalFacilitiesGroup.add(getKaigoRecuperationMedicalFacilitiesUnitSemiRoomBasicMoneyConteiner(), VRLayout.FLOW_INSETLINE_RETURN);

    kaigoRecuperationMedicalFacilitiesGroup.add(getKaigoRecuperationMedicalFacilitiesNormalRoomBasicMoneyConteiner(), VRLayout.FLOW_INSETLINE_RETURN);

    kaigoRecuperationMedicalFacilitiesGroup.add(getKaigoRecuperationMedicalFacilitiesTasyouRoomConteiner(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * �������R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoRecuperationMedicalFacilitiesDiscountContainer(){

    kaigoRecuperationMedicalFacilitiesDiscountContainer.add(getKaigoRecuperationMedicalFacilitiesDiscountRate(), VRLayout.FLOW);

    kaigoRecuperationMedicalFacilitiesDiscountContainer.add(getPercentSign(), VRLayout.FLOW);

  }

  /**
   * �������ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoRecuperationMedicalFacilitiesDiscountRate(){

  }

  /**
   * �����x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addPercentSign(){

  }

  /**
   * �{�݋敪���W�I�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addInstitutionDivisionRadio(){

  }

  /**
   * �{�݋敪���W�I�O���[�v���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addInstitutionDivisionRadioModel(){

    getInstitutionDivisionRadioItem1().setButtonIndex(1);
    getInstitutionDivisionRadioModel().add(getInstitutionDivisionRadioItem1());

    getInstitutionDivisionRadioItem2().setButtonIndex(2);
    getInstitutionDivisionRadioModel().add(getInstitutionDivisionRadioItem2());

  }

  /**
   * �a�@�ɓ������ڂ�ǉ����܂��B
   */
  protected void addInstitutionDivisionRadioItem1(){

  }

  /**
   * ���j�b�g�^�a�@�ɓ������ڂ�ǉ����܂��B
   */
  protected void addInstitutionDivisionRadioItem2(){

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

    getStaffAssignmentDivision1().setButtonIndex(1);
    getStaffAssignmentDivisionModel().add(getStaffAssignmentDivision1());

    getStaffAssignmentDivision2().setButtonIndex(2);
    getStaffAssignmentDivisionModel().add(getStaffAssignmentDivision2());

    getStaffAssignmentDivision3().setButtonIndex(3);
    getStaffAssignmentDivisionModel().add(getStaffAssignmentDivision3());

  }

  /**
   * I�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffAssignmentDivision1(){

  }

  /**
   * II�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffAssignmentDivision2(){

  }

  /**
   * III�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffAssignmentDivision3(){

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

    getNightShiftConditionAddition1().setButtonIndex(2);
    getNightShiftConditionModel().add(getNightShiftConditionAddition1());

    getNightShiftConditionAddition2().setButtonIndex(3);
    getNightShiftConditionModel().add(getNightShiftConditionAddition2());

    getNightShiftConditionAddition3().setButtonIndex(4);
    getNightShiftConditionModel().add(getNightShiftConditionAddition3());

    getNightShiftConditionSubtraction().setButtonIndex(5);
    getNightShiftConditionModel().add(getNightShiftConditionSubtraction());

  }

  /**
   * ��^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addNightShiftConditionStandard(){

  }

  /**
   * ���Z�^I�ɓ������ڂ�ǉ����܂��B
   */
  protected void addNightShiftConditionAddition1(){

  }

  /**
   * ���Z�^II�ɓ������ڂ�ǉ����܂��B
   */
  protected void addNightShiftConditionAddition2(){

  }

  /**
   * ���Z�^III�ɓ������ڂ�ǉ����܂��B
   */
  protected void addNightShiftConditionAddition3(){

  }

  /**
   * ���Z�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addNightShiftConditionSubtraction(){

  }

  /**
   * �×{������W�I�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addRecuperationEnvironmental(){

  }

  /**
   * �×{������W�I�O���[�v���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addRecuperationEnvironmentalModel(){

    getRecuperationEnvironmentalStandard().setButtonIndex(1);
    getRecuperationEnvironmentalModel().add(getRecuperationEnvironmentalStandard());

    getRecuperationEnvironmentalSubtraction1().setButtonIndex(2);
    getRecuperationEnvironmentalModel().add(getRecuperationEnvironmentalSubtraction1());

    getRecuperationEnvironmentalSubtraction2().setButtonIndex(3);
    getRecuperationEnvironmentalModel().add(getRecuperationEnvironmentalSubtraction2());

    getRecuperationEnvironmentalSubtraction3().setButtonIndex(4);
    getRecuperationEnvironmentalModel().add(getRecuperationEnvironmentalSubtraction3());

  }

  /**
   * ��^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addRecuperationEnvironmentalStandard(){

  }

  /**
   * ���Z�^I�ɓ������ڂ�ǉ����܂��B
   */
  protected void addRecuperationEnvironmentalSubtraction1(){

  }

  /**
   * ���Z�^II�ɓ������ڂ�ǉ����܂��B
   */
  protected void addRecuperationEnvironmentalSubtraction2(){

  }

  /**
   * ���Z�^III�ɓ������ڂ�ǉ����܂��B
   */
  protected void addRecuperationEnvironmentalSubtraction3(){

  }

  /**
   * ��t�̔z�u����W�I�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addDoctorsArrangement(){

  }

  /**
   * ��t�̔z�u����W�I�O���[�v���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addDoctorsArrangementModel(){

    getDoctorsArrangementStandard().setButtonIndex(1);
    getDoctorsArrangementModel().add(getDoctorsArrangementStandard());

    getDoctorsArrangementArticle49().setButtonIndex(2);
    getDoctorsArrangementModel().add(getDoctorsArrangementArticle49());

  }

  /**
   * ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addDoctorsArrangementStandard(){

  }

  /**
   * ��Ö@�{�s�K����49��K�p�ɓ������ڂ�ǉ����܂��B
   */
  protected void addDoctorsArrangementArticle49(){

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
   * �l�����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffReduce(){

  }

  /**
   * �l�����Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffReduceModel(){

  }

  /**
   * �H���z�E�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoRecuperationMedicalFacilitiesDinnerBasicMoneyConteiner(){

    kaigoRecuperationMedicalFacilitiesDinnerBasicMoneyConteiner.add(getKaigoRecuperationMedicalFacilitiesDinnerBasicMoneyTotal(), VRLayout.FLOW);

    kaigoRecuperationMedicalFacilitiesDinnerBasicMoneyConteiner.add(getKaigoRecuperationMedicalFacilitiesMorningDinnerBasicMoneyLabel(), VRLayout.FLOW);

    kaigoRecuperationMedicalFacilitiesDinnerBasicMoneyConteiner.add(getKaigoRecuperationMedicalFacilitiesMorningDinnerBasicMoney(), VRLayout.FLOW);

    kaigoRecuperationMedicalFacilitiesDinnerBasicMoneyConteiner.add(getKaigoRecuperationMedicalFacilitiesNoonDinnerBasicMoneyLabel(), VRLayout.FLOW);

    kaigoRecuperationMedicalFacilitiesDinnerBasicMoneyConteiner.add(getKaigoRecuperationMedicalFacilitiesNoonDinnerBasicMoney(), VRLayout.FLOW);

    kaigoRecuperationMedicalFacilitiesDinnerBasicMoneyConteiner.add(getKaigoRecuperationMedicalFacilitiesNightDinnerBasicMoneyLabel(), VRLayout.FLOW);

    kaigoRecuperationMedicalFacilitiesDinnerBasicMoneyConteiner.add(getKaigoRecuperationMedicalFacilitiesNightDinnerBasicMoney(), VRLayout.FLOW);

    kaigoRecuperationMedicalFacilitiesDinnerBasicMoneyConteiner.add(getKaigoRecuperationMedicalFacilitiesDinnerBasicMoney4Label(), VRLayout.FLOW);

  }

  /**
   * �H���z�E���v�E�e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoRecuperationMedicalFacilitiesDinnerBasicMoneyTotal(){

  }

  /**
   * �H���z�E���E���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoRecuperationMedicalFacilitiesMorningDinnerBasicMoneyLabel(){

  }

  /**
   * �H���z�E���E�e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoRecuperationMedicalFacilitiesMorningDinnerBasicMoney(){

  }

  /**
   * �H���z�E���E���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoRecuperationMedicalFacilitiesNoonDinnerBasicMoneyLabel(){

  }

  /**
   * �H���z�E���E�e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoRecuperationMedicalFacilitiesNoonDinnerBasicMoney(){

  }

  /**
   * �H���z�E��E���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoRecuperationMedicalFacilitiesNightDinnerBasicMoneyLabel(){

  }

  /**
   * �H���z�E��E�e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoRecuperationMedicalFacilitiesNightDinnerBasicMoney(){

  }

  /**
   * �H���z�E���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoRecuperationMedicalFacilitiesDinnerBasicMoney4Label(){

  }

  /**
   * ���j�b�g�^����z�E�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoRecuperationMedicalFacilitiesUnitRoomBasicMoneyConteiner(){

    kaigoRecuperationMedicalFacilitiesUnitRoomBasicMoneyConteiner.add(getKaigoRecuperationMedicalFacilitiesUnitRoomBasicMoneyText(), null);

    kaigoRecuperationMedicalFacilitiesUnitRoomBasicMoneyConteiner.add(getKaigoRecuperationMedicalFacilitiesUnitRoomBasicMoneyLabel(), null);

  }

  /**
   * ���j�b�g�^����z�E�e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoRecuperationMedicalFacilitiesUnitRoomBasicMoneyText(){

  }

  /**
   * ���j�b�g�^����z�E���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoRecuperationMedicalFacilitiesUnitRoomBasicMoneyLabel(){

  }

  /**
   * ���j�b�g�^������z�E�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoRecuperationMedicalFacilitiesUnitSemiRoomBasicMoneyConteiner(){

    kaigoRecuperationMedicalFacilitiesUnitSemiRoomBasicMoneyConteiner.add(getKaigoRecuperationMedicalFacilitiesUnitSemiRoomBasicMoneyText(), null);

    kaigoRecuperationMedicalFacilitiesUnitSemiRoomBasicMoneyConteiner.add(getKaigoRecuperationMedicalFacilitiesUnitSemiRoomBasicMoneyLabel(), null);

  }

  /**
   * ���j�b�g�^������z�E�e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoRecuperationMedicalFacilitiesUnitSemiRoomBasicMoneyText(){

  }

  /**
   * ���j�b�g�^������z�E���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoRecuperationMedicalFacilitiesUnitSemiRoomBasicMoneyLabel(){

  }

  /**
   * �]���^����z�E�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoRecuperationMedicalFacilitiesNormalRoomBasicMoneyConteiner(){

    kaigoRecuperationMedicalFacilitiesNormalRoomBasicMoneyConteiner.add(getKaigoRecuperationMedicalFacilitiesNormalRoomBasicMoneyText(), null);

    kaigoRecuperationMedicalFacilitiesNormalRoomBasicMoneyConteiner.add(getKaigoRecuperationMedicalFacilitiesNormalRoomBasicMoneyLabel(), null);

  }

  /**
   * �]���^����z�E�e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoRecuperationMedicalFacilitiesNormalRoomBasicMoneyText(){

  }

  /**
   * �]���^����z�E���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoRecuperationMedicalFacilitiesNormalRoomBasicMoneyLabel(){

  }

  /**
   * ��������z�E�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoRecuperationMedicalFacilitiesTasyouRoomConteiner(){

    kaigoRecuperationMedicalFacilitiesTasyouRoomConteiner.add(getKaigoRecuperationMedicalFacilitiesTasyouRoomText(), null);

    kaigoRecuperationMedicalFacilitiesTasyouRoomConteiner.add(getKaigoRecuperationMedicalFacilitiesTasyouRoomLabel(), null);

  }

  /**
   * ��������z�E�e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoRecuperationMedicalFacilitiesTasyouRoomText(){

  }

  /**
   * ��������z�E���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoRecuperationMedicalFacilitiesTasyouRoomLabel(){

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
      ACFrame.getInstance().getContentPane().add(new QO004018Design());
      ACFrame.getInstance().setVisible(true);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QO004018Design getThis() {
    return this;
  }
}
