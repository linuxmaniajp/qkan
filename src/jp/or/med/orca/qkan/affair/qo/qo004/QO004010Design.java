
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
 * �v���O���� �Z�������×{���a�@�×{�^ (QO004010)
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
 * �Z�������×{���a�@�×{�^��ʍ��ڃf�U�C��(QO004010) 
 */
public class QO004010Design extends ACPanel {
  //GUI�R���|�[�l���g

  private ACGroupBox shortStayHospitalRecuperationGroup;

  private ACLabelContainer shortStayHospitalRecuperationDiscountContainer;

  private ACTextField shortStayHospitalRecuperationDiscountRate;

  private ACLabel percentSign;

  private ACClearableRadioButtonGroup shortStayHospitalRecuperationInstitutionDivisionRadio;

  private ACLabelContainer shortStayHospitalRecuperationInstitutionDivisionRadioContainer;

  private ACListModelAdapter shortStayHospitalRecuperationInstitutionDivisionRadioModel;

  private ACRadioButtonItem shortStayHospitalRecuperationInstitutionDivisionRadioItem1;

  private ACRadioButtonItem shortStayHospitalRecuperationInstitutionDivisionRadioItem2;

  private ACClearableRadioButtonGroup shortStayHospitalRecuperationStaffAssignmentDivision;

  private ACLabelContainer shortStayHospitalRecuperationStaffAssignmentDivisionContainer;

  private ACListModelAdapter shortStayHospitalRecuperationStaffAssignmentDivisionModel;

  private ACRadioButtonItem shortStayHospitalRecuperationStaffAssignmentDivision1;

  private ACRadioButtonItem shortStayHospitalRecuperationStaffAssignmentDivision2;

  private ACRadioButtonItem shortStayHospitalRecuperationStaffAssignmentDivision3;

  private ACClearableRadioButtonGroup shortStayHospitalRecuperationNightShiftCondition;

  private ACLabelContainer shortStayHospitalRecuperationNightShiftConditionContainer;

  private ACListModelAdapter shortStayHospitalRecuperationNightShiftConditionModel;

  private VRLayout shortStayHospitalRecuperationNightShiftConditionLayout;

  private ACRadioButtonItem shortStayHospitalRecuperationNightShiftConditionStandard;

  private ACRadioButtonItem shortStayHospitalRecuperationNightShiftConditionAddition1;

  private ACRadioButtonItem shortStayHospitalRecuperationNightShiftConditionAddition2;

  private ACRadioButtonItem shortStayHospitalRecuperationNightShiftConditionAddition3;

  private ACRadioButtonItem shortStayHospitalRecuperationNightShiftConditionSubtraction;

  private ACClearableRadioButtonGroup shortStayHospitalRecuperationRecuperationEnvironmental;

  private ACLabelContainer shortStayHospitalRecuperationRecuperationEnvironmentalContainer;

  private ACListModelAdapter shortStayHospitalRecuperationRecuperationEnvironmentalModel;

  private ACRadioButtonItem shortStayHospitalRecuperationRecuperationEnvironmentalStandard;

  private ACRadioButtonItem shortStayHospitalRecuperationRecuperationEnvironmentalSubtraction1;

  private ACRadioButtonItem shortStayHospitalRecuperationRecuperationEnvironmentalSubtraction2;

  private ACRadioButtonItem shortStayHospitalRecuperationRecuperationEnvironmentalSubtraction3;

  private ACClearableRadioButtonGroup shortStayHospitalRecuperationDoctorsArrangement;

  private ACLabelContainer shortStayHospitalRecuperationDoctorsArrangementContainer;

  private ACListModelAdapter shortStayHospitalRecuperationDoctorsArrangementModel;

  private ACRadioButtonItem shortStayHospitalRecuperationDoctorsArrangementStandard;

  private ACRadioButtonItem shortStayHospitalRecuperationDoctorsArrangementArticle49;

  private ACClearableRadioButtonGroup shortStayHospitalRecuperationMeetingAndSendingOffSystem;

  private ACLabelContainer shortStayHospitalRecuperationMeetingAndSendingOffSystemContainer;

  private ACListModelAdapter shortStayHospitalRecuperationMeetingAndSendingOffSystemModel;

  private ACRadioButtonItem shortStayHospitalRecuperationMeetingAndSendingOffSystemOff;

  private ACRadioButtonItem shortStayHospitalRecuperationMeetingAndSendingOffSystemOn;

  private ACClearableRadioButtonGroup shortStayHospitalRecuperationNutritionManageRadio;

  private ACLabelContainer shortStayHospitalRecuperationNutritionManageRadioContainer;

  private ACListModelAdapter shortStayHospitalRecuperationNutritionManageRadioModel;

  private ACRadioButtonItem shortStayHospitalRecuperationNutritionManageRadioItem1;

  private ACRadioButtonItem shortStayHospitalRecuperationNutritionManageRadioItem2;

  private ACClearableRadioButtonGroup shortStayHospitalRecuperationRecuperationRadio;

  private ACLabelContainer shortStayHospitalRecuperationRecuperationRadioContainer;

  private ACListModelAdapter shortStayHospitalRecuperationRecuperationRadioModel;

  private ACRadioButtonItem shortStayHospitalRecuperationRecuperationRadioItem1;

  private ACRadioButtonItem shortStayHospitalRecuperationRecuperationRadioItem2;

  private ACComboBox shortStayHospitalRecuperationStaffReduce;

  private ACLabelContainer shortStayHospitalRecuperationStaffReduceContainer;

  private ACComboBoxModelAdapter shortStayHospitalRecuperationStaffReduceModel;

  private ACLabelContainer shortStayRecuperateCareHospitalDinnerStandeirdMoneyConteiner;

  private ACTextField shortStayRecuperateCareHospitalDinnerStandeirdMoneyTotal;

  private ACLabel shortStayRecuperateCareHospitalMorningDinnerStandeirdMoneyLabel;

  private ACTextField shortStayRecuperateCareHospitalMorningDinnerStandeirdMoney;

  private ACLabel shortStayRecuperateCareHospitalNoonDinnerStandeirdMoneyLabel;

  private ACTextField shortStayRecuperateCareHospitalNoonDinnerStandeirdMoney;

  private ACLabel shortStayRecuperateCareHospitalNightDinnerStandeirdMoneyLabel;

  private ACTextField shortStayRecuperateCareHospitalNightDinnerStandeirdMoney;

  private ACLabel shortStayRecuperateCareHospitalDinnerStandeirdMoneyDenomination;

  private ACLabelContainer shortStayRecuperateCareHospitalUnitRoomStandeirdMoneyConteiner;

  private ACTextField shortStayRecuperateCareHospitalUnitRoomStandeirdMoneyText;

  private ACLabel shortStayRecuperateCareHospitalUnitRoomStandeirdMoneyLabel;

  private ACLabelContainer shortStayRecuperateCareHospitalUnitSemiRoomStandeirdMoneyConteiner;

  private ACTextField shortStayRecuperateCareHospitalUnitSemiRoomStandeirdMoneyText;

  private ACLabel shortStayRecuperateCareHospitalUnitSemiRoomStandeirdMoneyLabel;

  private ACLabelContainer shortStayRecuperateCareHospitalNormalRoomStandeirdMoneyConteiner;

  private ACTextField shortStayRecuperateCareHospitalNormalRoomStandeirdMoneyText;

  private ACLabel shortStayRecuperateCareHospitalNormalRoomStandeirdMoneyLabel;

  private ACLabelContainer shortStayRecuperateCareHospitalTasyouRoomConteiner;

  private ACTextField shortStayRecuperateCareHospitalTasyouRoomText;

  private ACLabel shortStayRecuperateCareHospitalTasyouRoomLabel;

  //getter

  /**
   * ���ƃO���[�v���擾���܂��B
   * @return ���ƃO���[�v
   */
  public ACGroupBox getShortStayHospitalRecuperationGroup(){
    if(shortStayHospitalRecuperationGroup==null){

      shortStayHospitalRecuperationGroup = new ACGroupBox();

      shortStayHospitalRecuperationGroup.setText("�Z�������×{���i�a�@�×{�^�j");

      shortStayHospitalRecuperationGroup.setFollowChildEnabled(true);

      shortStayHospitalRecuperationGroup.setHgrid(200);

      addShortStayHospitalRecuperationGroup();
    }
    return shortStayHospitalRecuperationGroup;

  }

  /**
   * �������R���e�i���擾���܂��B
   * @return �������R���e�i
   */
  public ACLabelContainer getShortStayHospitalRecuperationDiscountContainer(){
    if(shortStayHospitalRecuperationDiscountContainer==null){

      shortStayHospitalRecuperationDiscountContainer = new ACLabelContainer();

      shortStayHospitalRecuperationDiscountContainer.setText("������");

      shortStayHospitalRecuperationDiscountContainer.setFollowChildEnabled(true);

      addShortStayHospitalRecuperationDiscountContainer();
    }
    return shortStayHospitalRecuperationDiscountContainer;

  }

  /**
   * ���������擾���܂��B
   * @return ������
   */
  public ACTextField getShortStayHospitalRecuperationDiscountRate(){
    if(shortStayHospitalRecuperationDiscountRate==null){

      shortStayHospitalRecuperationDiscountRate = new ACTextField();

      shortStayHospitalRecuperationDiscountRate.setBindPath("REDUCT_RATE");

      shortStayHospitalRecuperationDiscountRate.setColumns(3);

      shortStayHospitalRecuperationDiscountRate.setCharType(VRCharType.ONLY_DIGIT);

      shortStayHospitalRecuperationDiscountRate.setHorizontalAlignment(SwingConstants.RIGHT);

      shortStayHospitalRecuperationDiscountRate.setIMEMode(InputSubset.LATIN);

      shortStayHospitalRecuperationDiscountRate.setMaxLength(3);

      addShortStayHospitalRecuperationDiscountRate();
    }
    return shortStayHospitalRecuperationDiscountRate;

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
  public ACClearableRadioButtonGroup getShortStayHospitalRecuperationInstitutionDivisionRadio(){
    if(shortStayHospitalRecuperationInstitutionDivisionRadio==null){

      shortStayHospitalRecuperationInstitutionDivisionRadio = new ACClearableRadioButtonGroup();

      getShortStayHospitalRecuperationInstitutionDivisionRadioContainer().setText("�{�݋敪");

      shortStayHospitalRecuperationInstitutionDivisionRadio.setBindPath("1230101");

      shortStayHospitalRecuperationInstitutionDivisionRadio.setModel(getShortStayHospitalRecuperationInstitutionDivisionRadioModel());

      shortStayHospitalRecuperationInstitutionDivisionRadio.setUseClearButton(false);

      addShortStayHospitalRecuperationInstitutionDivisionRadio();
    }
    return shortStayHospitalRecuperationInstitutionDivisionRadio;

  }

  /**
   * �{�݋敪���W�I�O���[�v�R���e�i���擾���܂��B
   * @return �{�݋敪���W�I�O���[�v�R���e�i
   */
  protected ACLabelContainer getShortStayHospitalRecuperationInstitutionDivisionRadioContainer(){
    if(shortStayHospitalRecuperationInstitutionDivisionRadioContainer==null){
      shortStayHospitalRecuperationInstitutionDivisionRadioContainer = new ACLabelContainer();
      shortStayHospitalRecuperationInstitutionDivisionRadioContainer.setFollowChildEnabled(true);
      shortStayHospitalRecuperationInstitutionDivisionRadioContainer.add(getShortStayHospitalRecuperationInstitutionDivisionRadio(), null);
    }
    return shortStayHospitalRecuperationInstitutionDivisionRadioContainer;
  }

  /**
   * �{�݋敪���W�I�O���[�v���f�����擾���܂��B
   * @return �{�݋敪���W�I�O���[�v���f��
   */
  protected ACListModelAdapter getShortStayHospitalRecuperationInstitutionDivisionRadioModel(){
    if(shortStayHospitalRecuperationInstitutionDivisionRadioModel==null){
      shortStayHospitalRecuperationInstitutionDivisionRadioModel = new ACListModelAdapter();
      addShortStayHospitalRecuperationInstitutionDivisionRadioModel();
    }
    return shortStayHospitalRecuperationInstitutionDivisionRadioModel;
  }

  /**
   * �a�@���擾���܂��B
   * @return �a�@
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationInstitutionDivisionRadioItem1(){
    if(shortStayHospitalRecuperationInstitutionDivisionRadioItem1==null){

      shortStayHospitalRecuperationInstitutionDivisionRadioItem1 = new ACRadioButtonItem();

      shortStayHospitalRecuperationInstitutionDivisionRadioItem1.setText("�a�@");

      shortStayHospitalRecuperationInstitutionDivisionRadioItem1.setGroup(getShortStayHospitalRecuperationInstitutionDivisionRadio());

      addShortStayHospitalRecuperationInstitutionDivisionRadioItem1();
    }
    return shortStayHospitalRecuperationInstitutionDivisionRadioItem1;

  }

  /**
   * ���j�b�g�^�a�@���擾���܂��B
   * @return ���j�b�g�^�a�@
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationInstitutionDivisionRadioItem2(){
    if(shortStayHospitalRecuperationInstitutionDivisionRadioItem2==null){

      shortStayHospitalRecuperationInstitutionDivisionRadioItem2 = new ACRadioButtonItem();

      shortStayHospitalRecuperationInstitutionDivisionRadioItem2.setText("���j�b�g�^�a�@");

      shortStayHospitalRecuperationInstitutionDivisionRadioItem2.setGroup(getShortStayHospitalRecuperationInstitutionDivisionRadio());

      addShortStayHospitalRecuperationInstitutionDivisionRadioItem2();
    }
    return shortStayHospitalRecuperationInstitutionDivisionRadioItem2;

  }

  /**
   * �l���z�u�敪���W�I�O���[�v���擾���܂��B
   * @return �l���z�u�敪���W�I�O���[�v
   */
  public ACClearableRadioButtonGroup getShortStayHospitalRecuperationStaffAssignmentDivision(){
    if(shortStayHospitalRecuperationStaffAssignmentDivision==null){

      shortStayHospitalRecuperationStaffAssignmentDivision = new ACClearableRadioButtonGroup();

      getShortStayHospitalRecuperationStaffAssignmentDivisionContainer().setText("�l���z�u�敪");

      shortStayHospitalRecuperationStaffAssignmentDivision.setBindPath("1230102");

      shortStayHospitalRecuperationStaffAssignmentDivision.setModel(getShortStayHospitalRecuperationStaffAssignmentDivisionModel());

      shortStayHospitalRecuperationStaffAssignmentDivision.setUseClearButton(false);

      addShortStayHospitalRecuperationStaffAssignmentDivision();
    }
    return shortStayHospitalRecuperationStaffAssignmentDivision;

  }

  /**
   * �l���z�u�敪���W�I�O���[�v�R���e�i���擾���܂��B
   * @return �l���z�u�敪���W�I�O���[�v�R���e�i
   */
  protected ACLabelContainer getShortStayHospitalRecuperationStaffAssignmentDivisionContainer(){
    if(shortStayHospitalRecuperationStaffAssignmentDivisionContainer==null){
      shortStayHospitalRecuperationStaffAssignmentDivisionContainer = new ACLabelContainer();
      shortStayHospitalRecuperationStaffAssignmentDivisionContainer.setFollowChildEnabled(true);
      shortStayHospitalRecuperationStaffAssignmentDivisionContainer.add(getShortStayHospitalRecuperationStaffAssignmentDivision(), null);
    }
    return shortStayHospitalRecuperationStaffAssignmentDivisionContainer;
  }

  /**
   * �l���z�u�敪���W�I�O���[�v���f�����擾���܂��B
   * @return �l���z�u�敪���W�I�O���[�v���f��
   */
  protected ACListModelAdapter getShortStayHospitalRecuperationStaffAssignmentDivisionModel(){
    if(shortStayHospitalRecuperationStaffAssignmentDivisionModel==null){
      shortStayHospitalRecuperationStaffAssignmentDivisionModel = new ACListModelAdapter();
      addShortStayHospitalRecuperationStaffAssignmentDivisionModel();
    }
    return shortStayHospitalRecuperationStaffAssignmentDivisionModel;
  }

  /**
   * I�^���擾���܂��B
   * @return I�^
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationStaffAssignmentDivision1(){
    if(shortStayHospitalRecuperationStaffAssignmentDivision1==null){

      shortStayHospitalRecuperationStaffAssignmentDivision1 = new ACRadioButtonItem();

      shortStayHospitalRecuperationStaffAssignmentDivision1.setText("I�^");

      shortStayHospitalRecuperationStaffAssignmentDivision1.setGroup(getShortStayHospitalRecuperationStaffAssignmentDivision());

      addShortStayHospitalRecuperationStaffAssignmentDivision1();
    }
    return shortStayHospitalRecuperationStaffAssignmentDivision1;

  }

  /**
   * II�^���擾���܂��B
   * @return II�^
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationStaffAssignmentDivision2(){
    if(shortStayHospitalRecuperationStaffAssignmentDivision2==null){

      shortStayHospitalRecuperationStaffAssignmentDivision2 = new ACRadioButtonItem();

      shortStayHospitalRecuperationStaffAssignmentDivision2.setText("II�^");

      shortStayHospitalRecuperationStaffAssignmentDivision2.setGroup(getShortStayHospitalRecuperationStaffAssignmentDivision());

      addShortStayHospitalRecuperationStaffAssignmentDivision2();
    }
    return shortStayHospitalRecuperationStaffAssignmentDivision2;

  }

  /**
   * III�^���擾���܂��B
   * @return III�^
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationStaffAssignmentDivision3(){
    if(shortStayHospitalRecuperationStaffAssignmentDivision3==null){

      shortStayHospitalRecuperationStaffAssignmentDivision3 = new ACRadioButtonItem();

      shortStayHospitalRecuperationStaffAssignmentDivision3.setText("III�^");

      shortStayHospitalRecuperationStaffAssignmentDivision3.setGroup(getShortStayHospitalRecuperationStaffAssignmentDivision());

      addShortStayHospitalRecuperationStaffAssignmentDivision3();
    }
    return shortStayHospitalRecuperationStaffAssignmentDivision3;

  }

  /**
   * ��ԋΖ���������W�I�O���[�v���擾���܂��B
   * @return ��ԋΖ���������W�I�O���[�v
   */
  public ACClearableRadioButtonGroup getShortStayHospitalRecuperationNightShiftCondition(){
    if(shortStayHospitalRecuperationNightShiftCondition==null){

      shortStayHospitalRecuperationNightShiftCondition = new ACClearableRadioButtonGroup();

      getShortStayHospitalRecuperationNightShiftConditionContainer().setText("��ԋΖ������");

      shortStayHospitalRecuperationNightShiftCondition.setBindPath("1230103");

      shortStayHospitalRecuperationNightShiftCondition.setLayout(getShortStayHospitalRecuperationNightShiftConditionLayout());

      shortStayHospitalRecuperationNightShiftCondition.setModel(getShortStayHospitalRecuperationNightShiftConditionModel());

      shortStayHospitalRecuperationNightShiftCondition.setUseClearButton(false);

      addShortStayHospitalRecuperationNightShiftCondition();
    }
    return shortStayHospitalRecuperationNightShiftCondition;

  }

  /**
   * ��ԋΖ���������W�I�O���[�v�R���e�i���擾���܂��B
   * @return ��ԋΖ���������W�I�O���[�v�R���e�i
   */
  protected ACLabelContainer getShortStayHospitalRecuperationNightShiftConditionContainer(){
    if(shortStayHospitalRecuperationNightShiftConditionContainer==null){
      shortStayHospitalRecuperationNightShiftConditionContainer = new ACLabelContainer();
      shortStayHospitalRecuperationNightShiftConditionContainer.setFollowChildEnabled(true);
      shortStayHospitalRecuperationNightShiftConditionContainer.add(getShortStayHospitalRecuperationNightShiftCondition(), null);
    }
    return shortStayHospitalRecuperationNightShiftConditionContainer;
  }

  /**
   * ��ԋΖ���������W�I�O���[�v���f�����擾���܂��B
   * @return ��ԋΖ���������W�I�O���[�v���f��
   */
  protected ACListModelAdapter getShortStayHospitalRecuperationNightShiftConditionModel(){
    if(shortStayHospitalRecuperationNightShiftConditionModel==null){
      shortStayHospitalRecuperationNightShiftConditionModel = new ACListModelAdapter();
      addShortStayHospitalRecuperationNightShiftConditionModel();
    }
    return shortStayHospitalRecuperationNightShiftConditionModel;
  }

  /**
   * ��ԋΖ���������W�I�O���[�v���C�A�E�g���擾���܂��B
   * @return ��ԋΖ���������W�I�O���[�v���C�A�E�g
   */
  public VRLayout getShortStayHospitalRecuperationNightShiftConditionLayout(){
    if(shortStayHospitalRecuperationNightShiftConditionLayout==null){

      shortStayHospitalRecuperationNightShiftConditionLayout = new VRLayout();

      shortStayHospitalRecuperationNightShiftConditionLayout.setAutoWrap(false);

      shortStayHospitalRecuperationNightShiftConditionLayout.setHgap(0);

      addShortStayHospitalRecuperationNightShiftConditionLayout();
    }
    return shortStayHospitalRecuperationNightShiftConditionLayout;

  }

  /**
   * ��^���擾���܂��B
   * @return ��^
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationNightShiftConditionStandard(){
    if(shortStayHospitalRecuperationNightShiftConditionStandard==null){

      shortStayHospitalRecuperationNightShiftConditionStandard = new ACRadioButtonItem();

      shortStayHospitalRecuperationNightShiftConditionStandard.setText("��^");

      shortStayHospitalRecuperationNightShiftConditionStandard.setGroup(getShortStayHospitalRecuperationNightShiftCondition());

      addShortStayHospitalRecuperationNightShiftConditionStandard();
    }
    return shortStayHospitalRecuperationNightShiftConditionStandard;

  }

  /**
   * ���Z�^I���擾���܂��B
   * @return ���Z�^I
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationNightShiftConditionAddition1(){
    if(shortStayHospitalRecuperationNightShiftConditionAddition1==null){

      shortStayHospitalRecuperationNightShiftConditionAddition1 = new ACRadioButtonItem();

      shortStayHospitalRecuperationNightShiftConditionAddition1.setText("���Z�^I");

      shortStayHospitalRecuperationNightShiftConditionAddition1.setGroup(getShortStayHospitalRecuperationNightShiftCondition());

      addShortStayHospitalRecuperationNightShiftConditionAddition1();
    }
    return shortStayHospitalRecuperationNightShiftConditionAddition1;

  }

  /**
   * ���Z�^II���擾���܂��B
   * @return ���Z�^II
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationNightShiftConditionAddition2(){
    if(shortStayHospitalRecuperationNightShiftConditionAddition2==null){

      shortStayHospitalRecuperationNightShiftConditionAddition2 = new ACRadioButtonItem();

      shortStayHospitalRecuperationNightShiftConditionAddition2.setText("���Z�^II");

      shortStayHospitalRecuperationNightShiftConditionAddition2.setGroup(getShortStayHospitalRecuperationNightShiftCondition());

      addShortStayHospitalRecuperationNightShiftConditionAddition2();
    }
    return shortStayHospitalRecuperationNightShiftConditionAddition2;

  }

  /**
   * ���Z�^III���擾���܂��B
   * @return ���Z�^III
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationNightShiftConditionAddition3(){
    if(shortStayHospitalRecuperationNightShiftConditionAddition3==null){

      shortStayHospitalRecuperationNightShiftConditionAddition3 = new ACRadioButtonItem();

      shortStayHospitalRecuperationNightShiftConditionAddition3.setText("���Z�^III");

      shortStayHospitalRecuperationNightShiftConditionAddition3.setGroup(getShortStayHospitalRecuperationNightShiftCondition());

      addShortStayHospitalRecuperationNightShiftConditionAddition3();
    }
    return shortStayHospitalRecuperationNightShiftConditionAddition3;

  }

  /**
   * ���Z�^���擾���܂��B
   * @return ���Z�^
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationNightShiftConditionSubtraction(){
    if(shortStayHospitalRecuperationNightShiftConditionSubtraction==null){

      shortStayHospitalRecuperationNightShiftConditionSubtraction = new ACRadioButtonItem();

      shortStayHospitalRecuperationNightShiftConditionSubtraction.setText("���Z�^");

      shortStayHospitalRecuperationNightShiftConditionSubtraction.setGroup(getShortStayHospitalRecuperationNightShiftCondition());

      addShortStayHospitalRecuperationNightShiftConditionSubtraction();
    }
    return shortStayHospitalRecuperationNightShiftConditionSubtraction;

  }

  /**
   * �×{������W�I�O���[�v���擾���܂��B
   * @return �×{������W�I�O���[�v
   */
  public ACClearableRadioButtonGroup getShortStayHospitalRecuperationRecuperationEnvironmental(){
    if(shortStayHospitalRecuperationRecuperationEnvironmental==null){

      shortStayHospitalRecuperationRecuperationEnvironmental = new ACClearableRadioButtonGroup();

      getShortStayHospitalRecuperationRecuperationEnvironmentalContainer().setText("�×{���");

      shortStayHospitalRecuperationRecuperationEnvironmental.setBindPath("1230104");

      shortStayHospitalRecuperationRecuperationEnvironmental.setModel(getShortStayHospitalRecuperationRecuperationEnvironmentalModel());

      shortStayHospitalRecuperationRecuperationEnvironmental.setUseClearButton(false);

      addShortStayHospitalRecuperationRecuperationEnvironmental();
    }
    return shortStayHospitalRecuperationRecuperationEnvironmental;

  }

  /**
   * �×{������W�I�O���[�v�R���e�i���擾���܂��B
   * @return �×{������W�I�O���[�v�R���e�i
   */
  protected ACLabelContainer getShortStayHospitalRecuperationRecuperationEnvironmentalContainer(){
    if(shortStayHospitalRecuperationRecuperationEnvironmentalContainer==null){
      shortStayHospitalRecuperationRecuperationEnvironmentalContainer = new ACLabelContainer();
      shortStayHospitalRecuperationRecuperationEnvironmentalContainer.setFollowChildEnabled(true);
      shortStayHospitalRecuperationRecuperationEnvironmentalContainer.add(getShortStayHospitalRecuperationRecuperationEnvironmental(), null);
    }
    return shortStayHospitalRecuperationRecuperationEnvironmentalContainer;
  }

  /**
   * �×{������W�I�O���[�v���f�����擾���܂��B
   * @return �×{������W�I�O���[�v���f��
   */
  protected ACListModelAdapter getShortStayHospitalRecuperationRecuperationEnvironmentalModel(){
    if(shortStayHospitalRecuperationRecuperationEnvironmentalModel==null){
      shortStayHospitalRecuperationRecuperationEnvironmentalModel = new ACListModelAdapter();
      addShortStayHospitalRecuperationRecuperationEnvironmentalModel();
    }
    return shortStayHospitalRecuperationRecuperationEnvironmentalModel;
  }

  /**
   * ��^���擾���܂��B
   * @return ��^
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationRecuperationEnvironmentalStandard(){
    if(shortStayHospitalRecuperationRecuperationEnvironmentalStandard==null){

      shortStayHospitalRecuperationRecuperationEnvironmentalStandard = new ACRadioButtonItem();

      shortStayHospitalRecuperationRecuperationEnvironmentalStandard.setText("��^");

      shortStayHospitalRecuperationRecuperationEnvironmentalStandard.setGroup(getShortStayHospitalRecuperationRecuperationEnvironmental());

      addShortStayHospitalRecuperationRecuperationEnvironmentalStandard();
    }
    return shortStayHospitalRecuperationRecuperationEnvironmentalStandard;

  }

  /**
   * ���Z�^I���擾���܂��B
   * @return ���Z�^I
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationRecuperationEnvironmentalSubtraction1(){
    if(shortStayHospitalRecuperationRecuperationEnvironmentalSubtraction1==null){

      shortStayHospitalRecuperationRecuperationEnvironmentalSubtraction1 = new ACRadioButtonItem();

      shortStayHospitalRecuperationRecuperationEnvironmentalSubtraction1.setText("���Z�^I");

      shortStayHospitalRecuperationRecuperationEnvironmentalSubtraction1.setGroup(getShortStayHospitalRecuperationRecuperationEnvironmental());

      addShortStayHospitalRecuperationRecuperationEnvironmentalSubtraction1();
    }
    return shortStayHospitalRecuperationRecuperationEnvironmentalSubtraction1;

  }

  /**
   * ���Z�^II���擾���܂��B
   * @return ���Z�^II
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationRecuperationEnvironmentalSubtraction2(){
    if(shortStayHospitalRecuperationRecuperationEnvironmentalSubtraction2==null){

      shortStayHospitalRecuperationRecuperationEnvironmentalSubtraction2 = new ACRadioButtonItem();

      shortStayHospitalRecuperationRecuperationEnvironmentalSubtraction2.setText("���Z�^II");

      shortStayHospitalRecuperationRecuperationEnvironmentalSubtraction2.setGroup(getShortStayHospitalRecuperationRecuperationEnvironmental());

      addShortStayHospitalRecuperationRecuperationEnvironmentalSubtraction2();
    }
    return shortStayHospitalRecuperationRecuperationEnvironmentalSubtraction2;

  }

  /**
   * ���Z�^III���擾���܂��B
   * @return ���Z�^III
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationRecuperationEnvironmentalSubtraction3(){
    if(shortStayHospitalRecuperationRecuperationEnvironmentalSubtraction3==null){

      shortStayHospitalRecuperationRecuperationEnvironmentalSubtraction3 = new ACRadioButtonItem();

      shortStayHospitalRecuperationRecuperationEnvironmentalSubtraction3.setText("���Z�^III");

      shortStayHospitalRecuperationRecuperationEnvironmentalSubtraction3.setGroup(getShortStayHospitalRecuperationRecuperationEnvironmental());

      addShortStayHospitalRecuperationRecuperationEnvironmentalSubtraction3();
    }
    return shortStayHospitalRecuperationRecuperationEnvironmentalSubtraction3;

  }

  /**
   * ��t�̔z�u����W�I�O���[�v���擾���܂��B
   * @return ��t�̔z�u����W�I�O���[�v
   */
  public ACClearableRadioButtonGroup getShortStayHospitalRecuperationDoctorsArrangement(){
    if(shortStayHospitalRecuperationDoctorsArrangement==null){

      shortStayHospitalRecuperationDoctorsArrangement = new ACClearableRadioButtonGroup();

      getShortStayHospitalRecuperationDoctorsArrangementContainer().setText("��t�̔z�u�");

      shortStayHospitalRecuperationDoctorsArrangement.setBindPath("1230105");

      shortStayHospitalRecuperationDoctorsArrangement.setModel(getShortStayHospitalRecuperationDoctorsArrangementModel());

      shortStayHospitalRecuperationDoctorsArrangement.setUseClearButton(false);

      addShortStayHospitalRecuperationDoctorsArrangement();
    }
    return shortStayHospitalRecuperationDoctorsArrangement;

  }

  /**
   * ��t�̔z�u����W�I�O���[�v�R���e�i���擾���܂��B
   * @return ��t�̔z�u����W�I�O���[�v�R���e�i
   */
  protected ACLabelContainer getShortStayHospitalRecuperationDoctorsArrangementContainer(){
    if(shortStayHospitalRecuperationDoctorsArrangementContainer==null){
      shortStayHospitalRecuperationDoctorsArrangementContainer = new ACLabelContainer();
      shortStayHospitalRecuperationDoctorsArrangementContainer.setFollowChildEnabled(true);
      shortStayHospitalRecuperationDoctorsArrangementContainer.add(getShortStayHospitalRecuperationDoctorsArrangement(), null);
    }
    return shortStayHospitalRecuperationDoctorsArrangementContainer;
  }

  /**
   * ��t�̔z�u����W�I�O���[�v���f�����擾���܂��B
   * @return ��t�̔z�u����W�I�O���[�v���f��
   */
  protected ACListModelAdapter getShortStayHospitalRecuperationDoctorsArrangementModel(){
    if(shortStayHospitalRecuperationDoctorsArrangementModel==null){
      shortStayHospitalRecuperationDoctorsArrangementModel = new ACListModelAdapter();
      addShortStayHospitalRecuperationDoctorsArrangementModel();
    }
    return shortStayHospitalRecuperationDoctorsArrangementModel;
  }

  /**
   * ����擾���܂��B
   * @return �
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationDoctorsArrangementStandard(){
    if(shortStayHospitalRecuperationDoctorsArrangementStandard==null){

      shortStayHospitalRecuperationDoctorsArrangementStandard = new ACRadioButtonItem();

      shortStayHospitalRecuperationDoctorsArrangementStandard.setText("�");

      shortStayHospitalRecuperationDoctorsArrangementStandard.setGroup(getShortStayHospitalRecuperationDoctorsArrangement());

      addShortStayHospitalRecuperationDoctorsArrangementStandard();
    }
    return shortStayHospitalRecuperationDoctorsArrangementStandard;

  }

  /**
   * ��Ö@�{�s�K����49��K�p���擾���܂��B
   * @return ��Ö@�{�s�K����49��K�p
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationDoctorsArrangementArticle49(){
    if(shortStayHospitalRecuperationDoctorsArrangementArticle49==null){

      shortStayHospitalRecuperationDoctorsArrangementArticle49 = new ACRadioButtonItem();

      shortStayHospitalRecuperationDoctorsArrangementArticle49.setText("49��K�p");

      shortStayHospitalRecuperationDoctorsArrangementArticle49.setGroup(getShortStayHospitalRecuperationDoctorsArrangement());

      addShortStayHospitalRecuperationDoctorsArrangementArticle49();
    }
    return shortStayHospitalRecuperationDoctorsArrangementArticle49;

  }

  /**
   * ���}�̐����W�I�O���[�v���擾���܂��B
   * @return ���}�̐����W�I�O���[�v
   */
  public ACClearableRadioButtonGroup getShortStayHospitalRecuperationMeetingAndSendingOffSystem(){
    if(shortStayHospitalRecuperationMeetingAndSendingOffSystem==null){

      shortStayHospitalRecuperationMeetingAndSendingOffSystem = new ACClearableRadioButtonGroup();

      getShortStayHospitalRecuperationMeetingAndSendingOffSystemContainer().setText("���}�̐�");

      shortStayHospitalRecuperationMeetingAndSendingOffSystem.setBindPath("1230106");

      shortStayHospitalRecuperationMeetingAndSendingOffSystem.setModel(getShortStayHospitalRecuperationMeetingAndSendingOffSystemModel());

      shortStayHospitalRecuperationMeetingAndSendingOffSystem.setUseClearButton(false);

      addShortStayHospitalRecuperationMeetingAndSendingOffSystem();
    }
    return shortStayHospitalRecuperationMeetingAndSendingOffSystem;

  }

  /**
   * ���}�̐����W�I�O���[�v�R���e�i���擾���܂��B
   * @return ���}�̐����W�I�O���[�v�R���e�i
   */
  protected ACLabelContainer getShortStayHospitalRecuperationMeetingAndSendingOffSystemContainer(){
    if(shortStayHospitalRecuperationMeetingAndSendingOffSystemContainer==null){
      shortStayHospitalRecuperationMeetingAndSendingOffSystemContainer = new ACLabelContainer();
      shortStayHospitalRecuperationMeetingAndSendingOffSystemContainer.setFollowChildEnabled(true);
      shortStayHospitalRecuperationMeetingAndSendingOffSystemContainer.add(getShortStayHospitalRecuperationMeetingAndSendingOffSystem(), null);
    }
    return shortStayHospitalRecuperationMeetingAndSendingOffSystemContainer;
  }

  /**
   * ���}�̐����W�I�O���[�v���f�����擾���܂��B
   * @return ���}�̐����W�I�O���[�v���f��
   */
  protected ACListModelAdapter getShortStayHospitalRecuperationMeetingAndSendingOffSystemModel(){
    if(shortStayHospitalRecuperationMeetingAndSendingOffSystemModel==null){
      shortStayHospitalRecuperationMeetingAndSendingOffSystemModel = new ACListModelAdapter();
      addShortStayHospitalRecuperationMeetingAndSendingOffSystemModel();
    }
    return shortStayHospitalRecuperationMeetingAndSendingOffSystemModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationMeetingAndSendingOffSystemOff(){
    if(shortStayHospitalRecuperationMeetingAndSendingOffSystemOff==null){

      shortStayHospitalRecuperationMeetingAndSendingOffSystemOff = new ACRadioButtonItem();

      shortStayHospitalRecuperationMeetingAndSendingOffSystemOff.setText("�Ȃ�");

      shortStayHospitalRecuperationMeetingAndSendingOffSystemOff.setGroup(getShortStayHospitalRecuperationMeetingAndSendingOffSystem());

      addShortStayHospitalRecuperationMeetingAndSendingOffSystemOff();
    }
    return shortStayHospitalRecuperationMeetingAndSendingOffSystemOff;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationMeetingAndSendingOffSystemOn(){
    if(shortStayHospitalRecuperationMeetingAndSendingOffSystemOn==null){

      shortStayHospitalRecuperationMeetingAndSendingOffSystemOn = new ACRadioButtonItem();

      shortStayHospitalRecuperationMeetingAndSendingOffSystemOn.setText("����");

      shortStayHospitalRecuperationMeetingAndSendingOffSystemOn.setGroup(getShortStayHospitalRecuperationMeetingAndSendingOffSystem());

      addShortStayHospitalRecuperationMeetingAndSendingOffSystemOn();
    }
    return shortStayHospitalRecuperationMeetingAndSendingOffSystemOn;

  }

  /**
   * �h�{�Ǘ��̐����W�I�O���[�v���擾���܂��B
   * @return �h�{�Ǘ��̐����W�I�O���[�v
   */
  public ACClearableRadioButtonGroup getShortStayHospitalRecuperationNutritionManageRadio(){
    if(shortStayHospitalRecuperationNutritionManageRadio==null){

      shortStayHospitalRecuperationNutritionManageRadio = new ACClearableRadioButtonGroup();

      getShortStayHospitalRecuperationNutritionManageRadioContainer().setText("�h�{�Ǘ��̐�");

      shortStayHospitalRecuperationNutritionManageRadio.setBindPath("1230107");

      shortStayHospitalRecuperationNutritionManageRadio.setModel(getShortStayHospitalRecuperationNutritionManageRadioModel());

      shortStayHospitalRecuperationNutritionManageRadio.setUseClearButton(false);

      addShortStayHospitalRecuperationNutritionManageRadio();
    }
    return shortStayHospitalRecuperationNutritionManageRadio;

  }

  /**
   * �h�{�Ǘ��̐����W�I�O���[�v�R���e�i���擾���܂��B
   * @return �h�{�Ǘ��̐����W�I�O���[�v�R���e�i
   */
  protected ACLabelContainer getShortStayHospitalRecuperationNutritionManageRadioContainer(){
    if(shortStayHospitalRecuperationNutritionManageRadioContainer==null){
      shortStayHospitalRecuperationNutritionManageRadioContainer = new ACLabelContainer();
      shortStayHospitalRecuperationNutritionManageRadioContainer.setFollowChildEnabled(true);
      shortStayHospitalRecuperationNutritionManageRadioContainer.add(getShortStayHospitalRecuperationNutritionManageRadio(), null);
    }
    return shortStayHospitalRecuperationNutritionManageRadioContainer;
  }

  /**
   * �h�{�Ǘ��̐����W�I�O���[�v���f�����擾���܂��B
   * @return �h�{�Ǘ��̐����W�I�O���[�v���f��
   */
  protected ACListModelAdapter getShortStayHospitalRecuperationNutritionManageRadioModel(){
    if(shortStayHospitalRecuperationNutritionManageRadioModel==null){
      shortStayHospitalRecuperationNutritionManageRadioModel = new ACListModelAdapter();
      addShortStayHospitalRecuperationNutritionManageRadioModel();
    }
    return shortStayHospitalRecuperationNutritionManageRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationNutritionManageRadioItem1(){
    if(shortStayHospitalRecuperationNutritionManageRadioItem1==null){

      shortStayHospitalRecuperationNutritionManageRadioItem1 = new ACRadioButtonItem();

      shortStayHospitalRecuperationNutritionManageRadioItem1.setText("�Ȃ�");

      shortStayHospitalRecuperationNutritionManageRadioItem1.setGroup(getShortStayHospitalRecuperationNutritionManageRadio());

      addShortStayHospitalRecuperationNutritionManageRadioItem1();
    }
    return shortStayHospitalRecuperationNutritionManageRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationNutritionManageRadioItem2(){
    if(shortStayHospitalRecuperationNutritionManageRadioItem2==null){

      shortStayHospitalRecuperationNutritionManageRadioItem2 = new ACRadioButtonItem();

      shortStayHospitalRecuperationNutritionManageRadioItem2.setText("����");

      shortStayHospitalRecuperationNutritionManageRadioItem2.setGroup(getShortStayHospitalRecuperationNutritionManageRadio());

      addShortStayHospitalRecuperationNutritionManageRadioItem2();
    }
    return shortStayHospitalRecuperationNutritionManageRadioItem2;

  }

  /**
   * �×{�H�̐����W�I�O���[�v���擾���܂��B
   * @return �×{�H�̐����W�I�O���[�v
   */
  public ACClearableRadioButtonGroup getShortStayHospitalRecuperationRecuperationRadio(){
    if(shortStayHospitalRecuperationRecuperationRadio==null){

      shortStayHospitalRecuperationRecuperationRadio = new ACClearableRadioButtonGroup();

      getShortStayHospitalRecuperationRecuperationRadioContainer().setText("�×{�H�̐�");

      shortStayHospitalRecuperationRecuperationRadio.setBindPath("1230108");

      shortStayHospitalRecuperationRecuperationRadio.setModel(getShortStayHospitalRecuperationRecuperationRadioModel());

      shortStayHospitalRecuperationRecuperationRadio.setUseClearButton(false);

      addShortStayHospitalRecuperationRecuperationRadio();
    }
    return shortStayHospitalRecuperationRecuperationRadio;

  }

  /**
   * �×{�H�̐����W�I�O���[�v�R���e�i���擾���܂��B
   * @return �×{�H�̐����W�I�O���[�v�R���e�i
   */
  protected ACLabelContainer getShortStayHospitalRecuperationRecuperationRadioContainer(){
    if(shortStayHospitalRecuperationRecuperationRadioContainer==null){
      shortStayHospitalRecuperationRecuperationRadioContainer = new ACLabelContainer();
      shortStayHospitalRecuperationRecuperationRadioContainer.setFollowChildEnabled(true);
      shortStayHospitalRecuperationRecuperationRadioContainer.add(getShortStayHospitalRecuperationRecuperationRadio(), null);
    }
    return shortStayHospitalRecuperationRecuperationRadioContainer;
  }

  /**
   * �×{�H�̐����W�I�O���[�v���f�����擾���܂��B
   * @return �×{�H�̐����W�I�O���[�v���f��
   */
  protected ACListModelAdapter getShortStayHospitalRecuperationRecuperationRadioModel(){
    if(shortStayHospitalRecuperationRecuperationRadioModel==null){
      shortStayHospitalRecuperationRecuperationRadioModel = new ACListModelAdapter();
      addShortStayHospitalRecuperationRecuperationRadioModel();
    }
    return shortStayHospitalRecuperationRecuperationRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationRecuperationRadioItem1(){
    if(shortStayHospitalRecuperationRecuperationRadioItem1==null){

      shortStayHospitalRecuperationRecuperationRadioItem1 = new ACRadioButtonItem();

      shortStayHospitalRecuperationRecuperationRadioItem1.setText("�Ȃ�");

      shortStayHospitalRecuperationRecuperationRadioItem1.setGroup(getShortStayHospitalRecuperationRecuperationRadio());

      addShortStayHospitalRecuperationRecuperationRadioItem1();
    }
    return shortStayHospitalRecuperationRecuperationRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationRecuperationRadioItem2(){
    if(shortStayHospitalRecuperationRecuperationRadioItem2==null){

      shortStayHospitalRecuperationRecuperationRadioItem2 = new ACRadioButtonItem();

      shortStayHospitalRecuperationRecuperationRadioItem2.setText("����");

      shortStayHospitalRecuperationRecuperationRadioItem2.setGroup(getShortStayHospitalRecuperationRecuperationRadio());

      addShortStayHospitalRecuperationRecuperationRadioItem2();
    }
    return shortStayHospitalRecuperationRecuperationRadioItem2;

  }

  /**
   * �l�����Z�R���{���擾���܂��B
   * @return �l�����Z�R���{
   */
  public ACComboBox getShortStayHospitalRecuperationStaffReduce(){
    if(shortStayHospitalRecuperationStaffReduce==null){

      shortStayHospitalRecuperationStaffReduce = new ACComboBox();

      getShortStayHospitalRecuperationStaffReduceContainer().setText("�l�����Z");

      shortStayHospitalRecuperationStaffReduce.setBindPath("1230109");

      shortStayHospitalRecuperationStaffReduce.setEditable(false);

      shortStayHospitalRecuperationStaffReduce.setModelBindPath("STAFF_REDUCE");

      shortStayHospitalRecuperationStaffReduce.setModel(getShortStayHospitalRecuperationStaffReduceModel());

      shortStayHospitalRecuperationStaffReduce.setRenderBindPath("CONTENT");

      addShortStayHospitalRecuperationStaffReduce();
    }
    return shortStayHospitalRecuperationStaffReduce;

  }

  /**
   * �l�����Z�R���{�R���e�i���擾���܂��B
   * @return �l�����Z�R���{�R���e�i
   */
  protected ACLabelContainer getShortStayHospitalRecuperationStaffReduceContainer(){
    if(shortStayHospitalRecuperationStaffReduceContainer==null){
      shortStayHospitalRecuperationStaffReduceContainer = new ACLabelContainer();
      shortStayHospitalRecuperationStaffReduceContainer.setFollowChildEnabled(true);
      shortStayHospitalRecuperationStaffReduceContainer.add(getShortStayHospitalRecuperationStaffReduce(), null);
    }
    return shortStayHospitalRecuperationStaffReduceContainer;
  }

  /**
   * �l�����Z�R���{���f�����擾���܂��B
   * @return �l�����Z�R���{���f��
   */
  protected ACComboBoxModelAdapter getShortStayHospitalRecuperationStaffReduceModel(){
    if(shortStayHospitalRecuperationStaffReduceModel==null){
      shortStayHospitalRecuperationStaffReduceModel = new ACComboBoxModelAdapter();
      addShortStayHospitalRecuperationStaffReduceModel();
    }
    return shortStayHospitalRecuperationStaffReduceModel;
  }

  /**
   * �H���z�E�R���e�i���擾���܂��B
   * @return �H���z�E�R���e�i
   */
  public ACLabelContainer getShortStayRecuperateCareHospitalDinnerStandeirdMoneyConteiner(){
    if(shortStayRecuperateCareHospitalDinnerStandeirdMoneyConteiner==null){

      shortStayRecuperateCareHospitalDinnerStandeirdMoneyConteiner = new ACLabelContainer();

      shortStayRecuperateCareHospitalDinnerStandeirdMoneyConteiner.setText("�H���z");

      shortStayRecuperateCareHospitalDinnerStandeirdMoneyConteiner.setFollowChildEnabled(true);

      addShortStayRecuperateCareHospitalDinnerStandeirdMoneyConteiner();
    }
    return shortStayRecuperateCareHospitalDinnerStandeirdMoneyConteiner;

  }

  /**
   * �H���z�E���v�E�e�L�X�g���擾���܂��B
   * @return �H���z�E���v�E�e�L�X�g
   */
  public ACTextField getShortStayRecuperateCareHospitalDinnerStandeirdMoneyTotal(){
    if(shortStayRecuperateCareHospitalDinnerStandeirdMoneyTotal==null){

      shortStayRecuperateCareHospitalDinnerStandeirdMoneyTotal = new ACTextField();

      shortStayRecuperateCareHospitalDinnerStandeirdMoneyTotal.setBindPath("1230110");

      shortStayRecuperateCareHospitalDinnerStandeirdMoneyTotal.setEditable(false);

      shortStayRecuperateCareHospitalDinnerStandeirdMoneyTotal.setColumns(4);

      shortStayRecuperateCareHospitalDinnerStandeirdMoneyTotal.setCharType(VRCharType.ONLY_DIGIT);

      shortStayRecuperateCareHospitalDinnerStandeirdMoneyTotal.setHorizontalAlignment(SwingConstants.RIGHT);

      shortStayRecuperateCareHospitalDinnerStandeirdMoneyTotal.setIMEMode(InputSubset.LATIN);

      shortStayRecuperateCareHospitalDinnerStandeirdMoneyTotal.setMaxLength(4);

      addShortStayRecuperateCareHospitalDinnerStandeirdMoneyTotal();
    }
    return shortStayRecuperateCareHospitalDinnerStandeirdMoneyTotal;

  }

  /**
   * �H���z�E���E���x�����擾���܂��B
   * @return �H���z�E���E���x��
   */
  public ACLabel getShortStayRecuperateCareHospitalMorningDinnerStandeirdMoneyLabel(){
    if(shortStayRecuperateCareHospitalMorningDinnerStandeirdMoneyLabel==null){

      shortStayRecuperateCareHospitalMorningDinnerStandeirdMoneyLabel = new ACLabel();

      shortStayRecuperateCareHospitalMorningDinnerStandeirdMoneyLabel.setText("�@��");

      addShortStayRecuperateCareHospitalMorningDinnerStandeirdMoneyLabel();
    }
    return shortStayRecuperateCareHospitalMorningDinnerStandeirdMoneyLabel;

  }

  /**
   * �H���z�E���E�e�L�X�g���擾���܂��B
   * @return �H���z�E���E�e�L�X�g
   */
  public ACTextField getShortStayRecuperateCareHospitalMorningDinnerStandeirdMoney(){
    if(shortStayRecuperateCareHospitalMorningDinnerStandeirdMoney==null){

      shortStayRecuperateCareHospitalMorningDinnerStandeirdMoney = new ACTextField();

      shortStayRecuperateCareHospitalMorningDinnerStandeirdMoney.setBindPath("1230111");

      shortStayRecuperateCareHospitalMorningDinnerStandeirdMoney.setColumns(3);

      shortStayRecuperateCareHospitalMorningDinnerStandeirdMoney.setCharType(VRCharType.ONLY_DIGIT);

      shortStayRecuperateCareHospitalMorningDinnerStandeirdMoney.setHorizontalAlignment(SwingConstants.RIGHT);

      shortStayRecuperateCareHospitalMorningDinnerStandeirdMoney.setIMEMode(InputSubset.LATIN);

      shortStayRecuperateCareHospitalMorningDinnerStandeirdMoney.setMaxLength(3);

      addShortStayRecuperateCareHospitalMorningDinnerStandeirdMoney();
    }
    return shortStayRecuperateCareHospitalMorningDinnerStandeirdMoney;

  }

  /**
   * �H���z�E���E���x�����擾���܂��B
   * @return �H���z�E���E���x��
   */
  public ACLabel getShortStayRecuperateCareHospitalNoonDinnerStandeirdMoneyLabel(){
    if(shortStayRecuperateCareHospitalNoonDinnerStandeirdMoneyLabel==null){

      shortStayRecuperateCareHospitalNoonDinnerStandeirdMoneyLabel = new ACLabel();

      shortStayRecuperateCareHospitalNoonDinnerStandeirdMoneyLabel.setText("��");

      addShortStayRecuperateCareHospitalNoonDinnerStandeirdMoneyLabel();
    }
    return shortStayRecuperateCareHospitalNoonDinnerStandeirdMoneyLabel;

  }

  /**
   * �H���z�E���E�e�L�X�g���擾���܂��B
   * @return �H���z�E���E�e�L�X�g
   */
  public ACTextField getShortStayRecuperateCareHospitalNoonDinnerStandeirdMoney(){
    if(shortStayRecuperateCareHospitalNoonDinnerStandeirdMoney==null){

      shortStayRecuperateCareHospitalNoonDinnerStandeirdMoney = new ACTextField();

      shortStayRecuperateCareHospitalNoonDinnerStandeirdMoney.setBindPath("1230112");

      shortStayRecuperateCareHospitalNoonDinnerStandeirdMoney.setColumns(3);

      shortStayRecuperateCareHospitalNoonDinnerStandeirdMoney.setCharType(VRCharType.ONLY_DIGIT);

      shortStayRecuperateCareHospitalNoonDinnerStandeirdMoney.setHorizontalAlignment(SwingConstants.RIGHT);

      shortStayRecuperateCareHospitalNoonDinnerStandeirdMoney.setIMEMode(InputSubset.LATIN);

      shortStayRecuperateCareHospitalNoonDinnerStandeirdMoney.setMaxLength(3);

      addShortStayRecuperateCareHospitalNoonDinnerStandeirdMoney();
    }
    return shortStayRecuperateCareHospitalNoonDinnerStandeirdMoney;

  }

  /**
   * �H���z�E��E���x�����擾���܂��B
   * @return �H���z�E��E���x��
   */
  public ACLabel getShortStayRecuperateCareHospitalNightDinnerStandeirdMoneyLabel(){
    if(shortStayRecuperateCareHospitalNightDinnerStandeirdMoneyLabel==null){

      shortStayRecuperateCareHospitalNightDinnerStandeirdMoneyLabel = new ACLabel();

      shortStayRecuperateCareHospitalNightDinnerStandeirdMoneyLabel.setText("��");

      addShortStayRecuperateCareHospitalNightDinnerStandeirdMoneyLabel();
    }
    return shortStayRecuperateCareHospitalNightDinnerStandeirdMoneyLabel;

  }

  /**
   * �H���z�E��E�e�L�X�g���擾���܂��B
   * @return �H���z�E��E�e�L�X�g
   */
  public ACTextField getShortStayRecuperateCareHospitalNightDinnerStandeirdMoney(){
    if(shortStayRecuperateCareHospitalNightDinnerStandeirdMoney==null){

      shortStayRecuperateCareHospitalNightDinnerStandeirdMoney = new ACTextField();

      shortStayRecuperateCareHospitalNightDinnerStandeirdMoney.setBindPath("1230113");

      shortStayRecuperateCareHospitalNightDinnerStandeirdMoney.setColumns(3);

      shortStayRecuperateCareHospitalNightDinnerStandeirdMoney.setCharType(VRCharType.ONLY_DIGIT);

      shortStayRecuperateCareHospitalNightDinnerStandeirdMoney.setHorizontalAlignment(SwingConstants.RIGHT);

      shortStayRecuperateCareHospitalNightDinnerStandeirdMoney.setIMEMode(InputSubset.LATIN);

      shortStayRecuperateCareHospitalNightDinnerStandeirdMoney.setMaxLength(3);

      addShortStayRecuperateCareHospitalNightDinnerStandeirdMoney();
    }
    return shortStayRecuperateCareHospitalNightDinnerStandeirdMoney;

  }

  /**
   * �H���z�E���x�����擾���܂��B
   * @return �H���z�E���x��
   */
  public ACLabel getShortStayRecuperateCareHospitalDinnerStandeirdMoneyDenomination(){
    if(shortStayRecuperateCareHospitalDinnerStandeirdMoneyDenomination==null){

      shortStayRecuperateCareHospitalDinnerStandeirdMoneyDenomination = new ACLabel();

      shortStayRecuperateCareHospitalDinnerStandeirdMoneyDenomination.setText("�i�~�j");

      addShortStayRecuperateCareHospitalDinnerStandeirdMoneyDenomination();
    }
    return shortStayRecuperateCareHospitalDinnerStandeirdMoneyDenomination;

  }

  /**
   * ���j�b�g�^����z�E�R���e�i���擾���܂��B
   * @return ���j�b�g�^����z�E�R���e�i
   */
  public ACLabelContainer getShortStayRecuperateCareHospitalUnitRoomStandeirdMoneyConteiner(){
    if(shortStayRecuperateCareHospitalUnitRoomStandeirdMoneyConteiner==null){

      shortStayRecuperateCareHospitalUnitRoomStandeirdMoneyConteiner = new ACLabelContainer();

      shortStayRecuperateCareHospitalUnitRoomStandeirdMoneyConteiner.setText("���j�b�g�^����z");

      shortStayRecuperateCareHospitalUnitRoomStandeirdMoneyConteiner.setFollowChildEnabled(true);

      addShortStayRecuperateCareHospitalUnitRoomStandeirdMoneyConteiner();
    }
    return shortStayRecuperateCareHospitalUnitRoomStandeirdMoneyConteiner;

  }

  /**
   * ���j�b�g�^����z�E�e�L�X�g���擾���܂��B
   * @return ���j�b�g�^����z�E�e�L�X�g
   */
  public ACTextField getShortStayRecuperateCareHospitalUnitRoomStandeirdMoneyText(){
    if(shortStayRecuperateCareHospitalUnitRoomStandeirdMoneyText==null){

      shortStayRecuperateCareHospitalUnitRoomStandeirdMoneyText = new ACTextField();

      shortStayRecuperateCareHospitalUnitRoomStandeirdMoneyText.setBindPath("1230114");

      shortStayRecuperateCareHospitalUnitRoomStandeirdMoneyText.setColumns(4);

      shortStayRecuperateCareHospitalUnitRoomStandeirdMoneyText.setCharType(VRCharType.ONLY_DIGIT);

      shortStayRecuperateCareHospitalUnitRoomStandeirdMoneyText.setHorizontalAlignment(SwingConstants.RIGHT);

      shortStayRecuperateCareHospitalUnitRoomStandeirdMoneyText.setIMEMode(InputSubset.LATIN);

      shortStayRecuperateCareHospitalUnitRoomStandeirdMoneyText.setMaxLength(4);

      addShortStayRecuperateCareHospitalUnitRoomStandeirdMoneyText();
    }
    return shortStayRecuperateCareHospitalUnitRoomStandeirdMoneyText;

  }

  /**
   * ���j�b�g�^����z�E���x�����擾���܂��B
   * @return ���j�b�g�^����z�E���x��
   */
  public ACLabel getShortStayRecuperateCareHospitalUnitRoomStandeirdMoneyLabel(){
    if(shortStayRecuperateCareHospitalUnitRoomStandeirdMoneyLabel==null){

      shortStayRecuperateCareHospitalUnitRoomStandeirdMoneyLabel = new ACLabel();

      shortStayRecuperateCareHospitalUnitRoomStandeirdMoneyLabel.setText("�i�~�j");

      addShortStayRecuperateCareHospitalUnitRoomStandeirdMoneyLabel();
    }
    return shortStayRecuperateCareHospitalUnitRoomStandeirdMoneyLabel;

  }

  /**
   * ���j�b�g�^������z�E�R���e�i���擾���܂��B
   * @return ���j�b�g�^������z�E�R���e�i
   */
  public ACLabelContainer getShortStayRecuperateCareHospitalUnitSemiRoomStandeirdMoneyConteiner(){
    if(shortStayRecuperateCareHospitalUnitSemiRoomStandeirdMoneyConteiner==null){

      shortStayRecuperateCareHospitalUnitSemiRoomStandeirdMoneyConteiner = new ACLabelContainer();

      shortStayRecuperateCareHospitalUnitSemiRoomStandeirdMoneyConteiner.setText("���j�b�g�^������z");

      shortStayRecuperateCareHospitalUnitSemiRoomStandeirdMoneyConteiner.setFollowChildEnabled(true);

      addShortStayRecuperateCareHospitalUnitSemiRoomStandeirdMoneyConteiner();
    }
    return shortStayRecuperateCareHospitalUnitSemiRoomStandeirdMoneyConteiner;

  }

  /**
   * ���j�b�g�^������z�E�e�L�X�g���擾���܂��B
   * @return ���j�b�g�^������z�E�e�L�X�g
   */
  public ACTextField getShortStayRecuperateCareHospitalUnitSemiRoomStandeirdMoneyText(){
    if(shortStayRecuperateCareHospitalUnitSemiRoomStandeirdMoneyText==null){

      shortStayRecuperateCareHospitalUnitSemiRoomStandeirdMoneyText = new ACTextField();

      shortStayRecuperateCareHospitalUnitSemiRoomStandeirdMoneyText.setBindPath("1230115");

      shortStayRecuperateCareHospitalUnitSemiRoomStandeirdMoneyText.setColumns(4);

      shortStayRecuperateCareHospitalUnitSemiRoomStandeirdMoneyText.setCharType(VRCharType.ONLY_DIGIT);

      shortStayRecuperateCareHospitalUnitSemiRoomStandeirdMoneyText.setHorizontalAlignment(SwingConstants.RIGHT);

      shortStayRecuperateCareHospitalUnitSemiRoomStandeirdMoneyText.setIMEMode(InputSubset.LATIN);

      shortStayRecuperateCareHospitalUnitSemiRoomStandeirdMoneyText.setMaxLength(4);

      addShortStayRecuperateCareHospitalUnitSemiRoomStandeirdMoneyText();
    }
    return shortStayRecuperateCareHospitalUnitSemiRoomStandeirdMoneyText;

  }

  /**
   * ���j�b�g�^������z�E���x�����擾���܂��B
   * @return ���j�b�g�^������z�E���x��
   */
  public ACLabel getShortStayRecuperateCareHospitalUnitSemiRoomStandeirdMoneyLabel(){
    if(shortStayRecuperateCareHospitalUnitSemiRoomStandeirdMoneyLabel==null){

      shortStayRecuperateCareHospitalUnitSemiRoomStandeirdMoneyLabel = new ACLabel();

      shortStayRecuperateCareHospitalUnitSemiRoomStandeirdMoneyLabel.setText("�i�~�j");

      addShortStayRecuperateCareHospitalUnitSemiRoomStandeirdMoneyLabel();
    }
    return shortStayRecuperateCareHospitalUnitSemiRoomStandeirdMoneyLabel;

  }

  /**
   * �]���^����z�E�R���e�i���擾���܂��B
   * @return �]���^����z�E�R���e�i
   */
  public ACLabelContainer getShortStayRecuperateCareHospitalNormalRoomStandeirdMoneyConteiner(){
    if(shortStayRecuperateCareHospitalNormalRoomStandeirdMoneyConteiner==null){

      shortStayRecuperateCareHospitalNormalRoomStandeirdMoneyConteiner = new ACLabelContainer();

      shortStayRecuperateCareHospitalNormalRoomStandeirdMoneyConteiner.setText("�@�@�]���^����z");

      shortStayRecuperateCareHospitalNormalRoomStandeirdMoneyConteiner.setFollowChildEnabled(true);

      addShortStayRecuperateCareHospitalNormalRoomStandeirdMoneyConteiner();
    }
    return shortStayRecuperateCareHospitalNormalRoomStandeirdMoneyConteiner;

  }

  /**
   * �]���^����z�E�e�L�X�g���擾���܂��B
   * @return �]���^����z�E�e�L�X�g
   */
  public ACTextField getShortStayRecuperateCareHospitalNormalRoomStandeirdMoneyText(){
    if(shortStayRecuperateCareHospitalNormalRoomStandeirdMoneyText==null){

      shortStayRecuperateCareHospitalNormalRoomStandeirdMoneyText = new ACTextField();

      shortStayRecuperateCareHospitalNormalRoomStandeirdMoneyText.setBindPath("1230116");

      shortStayRecuperateCareHospitalNormalRoomStandeirdMoneyText.setColumns(4);

      shortStayRecuperateCareHospitalNormalRoomStandeirdMoneyText.setCharType(VRCharType.ONLY_DIGIT);

      shortStayRecuperateCareHospitalNormalRoomStandeirdMoneyText.setHorizontalAlignment(SwingConstants.RIGHT);

      shortStayRecuperateCareHospitalNormalRoomStandeirdMoneyText.setIMEMode(InputSubset.LATIN);

      shortStayRecuperateCareHospitalNormalRoomStandeirdMoneyText.setMaxLength(4);

      addShortStayRecuperateCareHospitalNormalRoomStandeirdMoneyText();
    }
    return shortStayRecuperateCareHospitalNormalRoomStandeirdMoneyText;

  }

  /**
   * �]���^����z�E���x�����擾���܂��B
   * @return �]���^����z�E���x��
   */
  public ACLabel getShortStayRecuperateCareHospitalNormalRoomStandeirdMoneyLabel(){
    if(shortStayRecuperateCareHospitalNormalRoomStandeirdMoneyLabel==null){

      shortStayRecuperateCareHospitalNormalRoomStandeirdMoneyLabel = new ACLabel();

      shortStayRecuperateCareHospitalNormalRoomStandeirdMoneyLabel.setText("�i�~�j");

      addShortStayRecuperateCareHospitalNormalRoomStandeirdMoneyLabel();
    }
    return shortStayRecuperateCareHospitalNormalRoomStandeirdMoneyLabel;

  }

  /**
   * ��������z�E�R���e�i���擾���܂��B
   * @return ��������z�E�R���e�i
   */
  public ACLabelContainer getShortStayRecuperateCareHospitalTasyouRoomConteiner(){
    if(shortStayRecuperateCareHospitalTasyouRoomConteiner==null){

      shortStayRecuperateCareHospitalTasyouRoomConteiner = new ACLabelContainer();

      shortStayRecuperateCareHospitalTasyouRoomConteiner.setText("�@�@��������z");

      shortStayRecuperateCareHospitalTasyouRoomConteiner.setFollowChildEnabled(true);

      addShortStayRecuperateCareHospitalTasyouRoomConteiner();
    }
    return shortStayRecuperateCareHospitalTasyouRoomConteiner;

  }

  /**
   * ��������z�E�e�L�X�g���擾���܂��B
   * @return ��������z�E�e�L�X�g
   */
  public ACTextField getShortStayRecuperateCareHospitalTasyouRoomText(){
    if(shortStayRecuperateCareHospitalTasyouRoomText==null){

      shortStayRecuperateCareHospitalTasyouRoomText = new ACTextField();

      shortStayRecuperateCareHospitalTasyouRoomText.setBindPath("1230117");

      shortStayRecuperateCareHospitalTasyouRoomText.setColumns(4);

      shortStayRecuperateCareHospitalTasyouRoomText.setCharType(VRCharType.ONLY_DIGIT);

      shortStayRecuperateCareHospitalTasyouRoomText.setHorizontalAlignment(SwingConstants.RIGHT);

      shortStayRecuperateCareHospitalTasyouRoomText.setIMEMode(InputSubset.LATIN);

      shortStayRecuperateCareHospitalTasyouRoomText.setMaxLength(4);

      addShortStayRecuperateCareHospitalTasyouRoomText();
    }
    return shortStayRecuperateCareHospitalTasyouRoomText;

  }

  /**
   * ��������z�E���x�����擾���܂��B
   * @return ��������z�E���x��
   */
  public ACLabel getShortStayRecuperateCareHospitalTasyouRoomLabel(){
    if(shortStayRecuperateCareHospitalTasyouRoomLabel==null){

      shortStayRecuperateCareHospitalTasyouRoomLabel = new ACLabel();

      shortStayRecuperateCareHospitalTasyouRoomLabel.setText("�i�~�j");

      addShortStayRecuperateCareHospitalTasyouRoomLabel();
    }
    return shortStayRecuperateCareHospitalTasyouRoomLabel;

  }

  /**
   * �R���X�g���N�^�ł��B
   */
  public QO004010Design() {

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

    this.add(getShortStayHospitalRecuperationGroup(), VRLayout.CLIENT);

  }

  /**
   * ���ƃO���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationGroup(){

    shortStayHospitalRecuperationGroup.add(getShortStayHospitalRecuperationDiscountContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayHospitalRecuperationGroup.add(getShortStayHospitalRecuperationInstitutionDivisionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayHospitalRecuperationGroup.add(getShortStayHospitalRecuperationStaffAssignmentDivisionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayHospitalRecuperationGroup.add(getShortStayHospitalRecuperationNightShiftConditionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayHospitalRecuperationGroup.add(getShortStayHospitalRecuperationRecuperationEnvironmentalContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayHospitalRecuperationGroup.add(getShortStayHospitalRecuperationDoctorsArrangementContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayHospitalRecuperationGroup.add(getShortStayHospitalRecuperationMeetingAndSendingOffSystemContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayHospitalRecuperationGroup.add(getShortStayHospitalRecuperationNutritionManageRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayHospitalRecuperationGroup.add(getShortStayHospitalRecuperationRecuperationRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayHospitalRecuperationGroup.add(getShortStayHospitalRecuperationStaffReduceContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayHospitalRecuperationGroup.add(getShortStayRecuperateCareHospitalDinnerStandeirdMoneyConteiner(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayHospitalRecuperationGroup.add(getShortStayRecuperateCareHospitalUnitRoomStandeirdMoneyConteiner(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayHospitalRecuperationGroup.add(getShortStayRecuperateCareHospitalUnitSemiRoomStandeirdMoneyConteiner(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayHospitalRecuperationGroup.add(getShortStayRecuperateCareHospitalNormalRoomStandeirdMoneyConteiner(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayHospitalRecuperationGroup.add(getShortStayRecuperateCareHospitalTasyouRoomConteiner(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * �������R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationDiscountContainer(){

    shortStayHospitalRecuperationDiscountContainer.add(getShortStayHospitalRecuperationDiscountRate(), VRLayout.FLOW);

    shortStayHospitalRecuperationDiscountContainer.add(getPercentSign(), VRLayout.FLOW);

  }

  /**
   * �������ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationDiscountRate(){

  }

  /**
   * �����x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addPercentSign(){

  }

  /**
   * �{�݋敪���W�I�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationInstitutionDivisionRadio(){

  }

  /**
   * �{�݋敪���W�I�O���[�v���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationInstitutionDivisionRadioModel(){

    getShortStayHospitalRecuperationInstitutionDivisionRadioItem1().setButtonIndex(1);
    getShortStayHospitalRecuperationInstitutionDivisionRadioModel().add(getShortStayHospitalRecuperationInstitutionDivisionRadioItem1());

    getShortStayHospitalRecuperationInstitutionDivisionRadioItem2().setButtonIndex(2);
    getShortStayHospitalRecuperationInstitutionDivisionRadioModel().add(getShortStayHospitalRecuperationInstitutionDivisionRadioItem2());

  }

  /**
   * �a�@�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationInstitutionDivisionRadioItem1(){

  }

  /**
   * ���j�b�g�^�a�@�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationInstitutionDivisionRadioItem2(){

  }

  /**
   * �l���z�u�敪���W�I�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationStaffAssignmentDivision(){

  }

  /**
   * �l���z�u�敪���W�I�O���[�v���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationStaffAssignmentDivisionModel(){

    getShortStayHospitalRecuperationStaffAssignmentDivision1().setButtonIndex(1);
    getShortStayHospitalRecuperationStaffAssignmentDivisionModel().add(getShortStayHospitalRecuperationStaffAssignmentDivision1());

    getShortStayHospitalRecuperationStaffAssignmentDivision2().setButtonIndex(2);
    getShortStayHospitalRecuperationStaffAssignmentDivisionModel().add(getShortStayHospitalRecuperationStaffAssignmentDivision2());

    getShortStayHospitalRecuperationStaffAssignmentDivision3().setButtonIndex(3);
    getShortStayHospitalRecuperationStaffAssignmentDivisionModel().add(getShortStayHospitalRecuperationStaffAssignmentDivision3());

  }

  /**
   * I�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationStaffAssignmentDivision1(){

  }

  /**
   * II�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationStaffAssignmentDivision2(){

  }

  /**
   * III�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationStaffAssignmentDivision3(){

  }

  /**
   * ��ԋΖ���������W�I�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationNightShiftCondition(){

  }

  /**
   * ��ԋΖ���������W�I�O���[�v���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationNightShiftConditionModel(){

    getShortStayHospitalRecuperationNightShiftConditionStandard().setButtonIndex(1);
    getShortStayHospitalRecuperationNightShiftConditionModel().add(getShortStayHospitalRecuperationNightShiftConditionStandard());

    getShortStayHospitalRecuperationNightShiftConditionAddition1().setButtonIndex(2);
    getShortStayHospitalRecuperationNightShiftConditionModel().add(getShortStayHospitalRecuperationNightShiftConditionAddition1());

    getShortStayHospitalRecuperationNightShiftConditionAddition2().setButtonIndex(3);
    getShortStayHospitalRecuperationNightShiftConditionModel().add(getShortStayHospitalRecuperationNightShiftConditionAddition2());

    getShortStayHospitalRecuperationNightShiftConditionAddition3().setButtonIndex(4);
    getShortStayHospitalRecuperationNightShiftConditionModel().add(getShortStayHospitalRecuperationNightShiftConditionAddition3());

    getShortStayHospitalRecuperationNightShiftConditionSubtraction().setButtonIndex(5);
    getShortStayHospitalRecuperationNightShiftConditionModel().add(getShortStayHospitalRecuperationNightShiftConditionSubtraction());

  }

  /**
   * ��ԋΖ���������W�I�O���[�v���C�A�E�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationNightShiftConditionLayout(){

  }

  /**
   * ��^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationNightShiftConditionStandard(){

  }

  /**
   * ���Z�^I�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationNightShiftConditionAddition1(){

  }

  /**
   * ���Z�^II�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationNightShiftConditionAddition2(){

  }

  /**
   * ���Z�^III�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationNightShiftConditionAddition3(){

  }

  /**
   * ���Z�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationNightShiftConditionSubtraction(){

  }

  /**
   * �×{������W�I�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationRecuperationEnvironmental(){

  }

  /**
   * �×{������W�I�O���[�v���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationRecuperationEnvironmentalModel(){

    getShortStayHospitalRecuperationRecuperationEnvironmentalStandard().setButtonIndex(1);
    getShortStayHospitalRecuperationRecuperationEnvironmentalModel().add(getShortStayHospitalRecuperationRecuperationEnvironmentalStandard());

    getShortStayHospitalRecuperationRecuperationEnvironmentalSubtraction1().setButtonIndex(2);
    getShortStayHospitalRecuperationRecuperationEnvironmentalModel().add(getShortStayHospitalRecuperationRecuperationEnvironmentalSubtraction1());

    getShortStayHospitalRecuperationRecuperationEnvironmentalSubtraction2().setButtonIndex(3);
    getShortStayHospitalRecuperationRecuperationEnvironmentalModel().add(getShortStayHospitalRecuperationRecuperationEnvironmentalSubtraction2());

    getShortStayHospitalRecuperationRecuperationEnvironmentalSubtraction3().setButtonIndex(4);
    getShortStayHospitalRecuperationRecuperationEnvironmentalModel().add(getShortStayHospitalRecuperationRecuperationEnvironmentalSubtraction3());

  }

  /**
   * ��^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationRecuperationEnvironmentalStandard(){

  }

  /**
   * ���Z�^I�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationRecuperationEnvironmentalSubtraction1(){

  }

  /**
   * ���Z�^II�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationRecuperationEnvironmentalSubtraction2(){

  }

  /**
   * ���Z�^III�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationRecuperationEnvironmentalSubtraction3(){

  }

  /**
   * ��t�̔z�u����W�I�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationDoctorsArrangement(){

  }

  /**
   * ��t�̔z�u����W�I�O���[�v���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationDoctorsArrangementModel(){

    getShortStayHospitalRecuperationDoctorsArrangementStandard().setButtonIndex(1);
    getShortStayHospitalRecuperationDoctorsArrangementModel().add(getShortStayHospitalRecuperationDoctorsArrangementStandard());

    getShortStayHospitalRecuperationDoctorsArrangementArticle49().setButtonIndex(2);
    getShortStayHospitalRecuperationDoctorsArrangementModel().add(getShortStayHospitalRecuperationDoctorsArrangementArticle49());

  }

  /**
   * ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationDoctorsArrangementStandard(){

  }

  /**
   * ��Ö@�{�s�K����49��K�p�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationDoctorsArrangementArticle49(){

  }

  /**
   * ���}�̐����W�I�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationMeetingAndSendingOffSystem(){

  }

  /**
   * ���}�̐����W�I�O���[�v���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationMeetingAndSendingOffSystemModel(){

    getShortStayHospitalRecuperationMeetingAndSendingOffSystemOff().setButtonIndex(1);
    getShortStayHospitalRecuperationMeetingAndSendingOffSystemModel().add(getShortStayHospitalRecuperationMeetingAndSendingOffSystemOff());

    getShortStayHospitalRecuperationMeetingAndSendingOffSystemOn().setButtonIndex(2);
    getShortStayHospitalRecuperationMeetingAndSendingOffSystemModel().add(getShortStayHospitalRecuperationMeetingAndSendingOffSystemOn());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationMeetingAndSendingOffSystemOff(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationMeetingAndSendingOffSystemOn(){

  }

  /**
   * �h�{�Ǘ��̐����W�I�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationNutritionManageRadio(){

  }

  /**
   * �h�{�Ǘ��̐����W�I�O���[�v���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationNutritionManageRadioModel(){

    getShortStayHospitalRecuperationNutritionManageRadioItem1().setButtonIndex(1);
    getShortStayHospitalRecuperationNutritionManageRadioModel().add(getShortStayHospitalRecuperationNutritionManageRadioItem1());

    getShortStayHospitalRecuperationNutritionManageRadioItem2().setButtonIndex(2);
    getShortStayHospitalRecuperationNutritionManageRadioModel().add(getShortStayHospitalRecuperationNutritionManageRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationNutritionManageRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationNutritionManageRadioItem2(){

  }

  /**
   * �×{�H�̐����W�I�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationRecuperationRadio(){

  }

  /**
   * �×{�H�̐����W�I�O���[�v���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationRecuperationRadioModel(){

    getShortStayHospitalRecuperationRecuperationRadioItem1().setButtonIndex(1);
    getShortStayHospitalRecuperationRecuperationRadioModel().add(getShortStayHospitalRecuperationRecuperationRadioItem1());

    getShortStayHospitalRecuperationRecuperationRadioItem2().setButtonIndex(2);
    getShortStayHospitalRecuperationRecuperationRadioModel().add(getShortStayHospitalRecuperationRecuperationRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationRecuperationRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationRecuperationRadioItem2(){

  }

  /**
   * �l�����Z�R���{�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationStaffReduce(){

  }

  /**
   * �l�����Z�R���{���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationStaffReduceModel(){

  }

  /**
   * �H���z�E�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperateCareHospitalDinnerStandeirdMoneyConteiner(){

    shortStayRecuperateCareHospitalDinnerStandeirdMoneyConteiner.add(getShortStayRecuperateCareHospitalDinnerStandeirdMoneyTotal(), VRLayout.FLOW);

    shortStayRecuperateCareHospitalDinnerStandeirdMoneyConteiner.add(getShortStayRecuperateCareHospitalMorningDinnerStandeirdMoneyLabel(), VRLayout.FLOW);

    shortStayRecuperateCareHospitalDinnerStandeirdMoneyConteiner.add(getShortStayRecuperateCareHospitalMorningDinnerStandeirdMoney(), VRLayout.FLOW);

    shortStayRecuperateCareHospitalDinnerStandeirdMoneyConteiner.add(getShortStayRecuperateCareHospitalNoonDinnerStandeirdMoneyLabel(), VRLayout.FLOW);

    shortStayRecuperateCareHospitalDinnerStandeirdMoneyConteiner.add(getShortStayRecuperateCareHospitalNoonDinnerStandeirdMoney(), VRLayout.FLOW);

    shortStayRecuperateCareHospitalDinnerStandeirdMoneyConteiner.add(getShortStayRecuperateCareHospitalNightDinnerStandeirdMoneyLabel(), VRLayout.FLOW);

    shortStayRecuperateCareHospitalDinnerStandeirdMoneyConteiner.add(getShortStayRecuperateCareHospitalNightDinnerStandeirdMoney(), VRLayout.FLOW);

    shortStayRecuperateCareHospitalDinnerStandeirdMoneyConteiner.add(getShortStayRecuperateCareHospitalDinnerStandeirdMoneyDenomination(), VRLayout.FLOW);

  }

  /**
   * �H���z�E���v�E�e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperateCareHospitalDinnerStandeirdMoneyTotal(){

  }

  /**
   * �H���z�E���E���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperateCareHospitalMorningDinnerStandeirdMoneyLabel(){

  }

  /**
   * �H���z�E���E�e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperateCareHospitalMorningDinnerStandeirdMoney(){

  }

  /**
   * �H���z�E���E���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperateCareHospitalNoonDinnerStandeirdMoneyLabel(){

  }

  /**
   * �H���z�E���E�e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperateCareHospitalNoonDinnerStandeirdMoney(){

  }

  /**
   * �H���z�E��E���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperateCareHospitalNightDinnerStandeirdMoneyLabel(){

  }

  /**
   * �H���z�E��E�e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperateCareHospitalNightDinnerStandeirdMoney(){

  }

  /**
   * �H���z�E���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperateCareHospitalDinnerStandeirdMoneyDenomination(){

  }

  /**
   * ���j�b�g�^����z�E�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperateCareHospitalUnitRoomStandeirdMoneyConteiner(){

    shortStayRecuperateCareHospitalUnitRoomStandeirdMoneyConteiner.add(getShortStayRecuperateCareHospitalUnitRoomStandeirdMoneyText(), null);

    shortStayRecuperateCareHospitalUnitRoomStandeirdMoneyConteiner.add(getShortStayRecuperateCareHospitalUnitRoomStandeirdMoneyLabel(), null);

  }

  /**
   * ���j�b�g�^����z�E�e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperateCareHospitalUnitRoomStandeirdMoneyText(){

  }

  /**
   * ���j�b�g�^����z�E���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperateCareHospitalUnitRoomStandeirdMoneyLabel(){

  }

  /**
   * ���j�b�g�^������z�E�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperateCareHospitalUnitSemiRoomStandeirdMoneyConteiner(){

    shortStayRecuperateCareHospitalUnitSemiRoomStandeirdMoneyConteiner.add(getShortStayRecuperateCareHospitalUnitSemiRoomStandeirdMoneyText(), null);

    shortStayRecuperateCareHospitalUnitSemiRoomStandeirdMoneyConteiner.add(getShortStayRecuperateCareHospitalUnitSemiRoomStandeirdMoneyLabel(), null);

  }

  /**
   * ���j�b�g�^������z�E�e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperateCareHospitalUnitSemiRoomStandeirdMoneyText(){

  }

  /**
   * ���j�b�g�^������z�E���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperateCareHospitalUnitSemiRoomStandeirdMoneyLabel(){

  }

  /**
   * �]���^����z�E�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperateCareHospitalNormalRoomStandeirdMoneyConteiner(){

    shortStayRecuperateCareHospitalNormalRoomStandeirdMoneyConteiner.add(getShortStayRecuperateCareHospitalNormalRoomStandeirdMoneyText(), null);

    shortStayRecuperateCareHospitalNormalRoomStandeirdMoneyConteiner.add(getShortStayRecuperateCareHospitalNormalRoomStandeirdMoneyLabel(), null);

  }

  /**
   * �]���^����z�E�e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperateCareHospitalNormalRoomStandeirdMoneyText(){

  }

  /**
   * �]���^����z�E���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperateCareHospitalNormalRoomStandeirdMoneyLabel(){

  }

  /**
   * ��������z�E�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperateCareHospitalTasyouRoomConteiner(){

    shortStayRecuperateCareHospitalTasyouRoomConteiner.add(getShortStayRecuperateCareHospitalTasyouRoomText(), null);

    shortStayRecuperateCareHospitalTasyouRoomConteiner.add(getShortStayRecuperateCareHospitalTasyouRoomLabel(), null);

  }

  /**
   * ��������z�E�e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperateCareHospitalTasyouRoomText(){

  }

  /**
   * ��������z�E���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperateCareHospitalTasyouRoomLabel(){

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
      ACFrame.getInstance().getContentPane().add(new QO004010Design());
      ACFrame.getInstance().setVisible(true);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QO004010Design getThis() {
    return this;
  }
}
