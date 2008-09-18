
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
 * �v���O���� �i���×{�^��Î{�݁i�f�Ï��^�j (QO004019)
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
 * �i���×{�^��Î{�݁i�f�Ï��^�j��ʍ��ڃf�U�C��(QO004019) 
 */
public class QO004019Design extends ACPanel {
  //GUI�R���|�[�l���g

  private ACGroupBox kaigoRecuperationMedicalFacilitiesClinicGroup;

  private ACLabelContainer kaigoRecuperationMedicalFacilitiesClinicDiscountContainer;

  private ACTextField kaigoRecuperationMedicalFacilitiesClinicDiscountRate;

  private ACLabel kaigoRecuperationMedicalFacilitiesClinicPercentSign;

  private ACClearableRadioButtonGroup kaigoRecuperationMedicalFacilitiesClinicInstitutionDivisionRadio;

  private ACLabelContainer kaigoRecuperationMedicalFacilitiesClinicInstitutionDivisionRadioContainer;

  private ACListModelAdapter kaigoRecuperationMedicalFacilitiesClinicInstitutionDivisionRadioModel;

  private ACRadioButtonItem kaigoRecuperationMedicalFacilitiesClinicInstitutionDivisionRadioItem1;

  private ACRadioButtonItem kaigoRecuperationMedicalFacilitiesClinicInstitutionDivisionRadioItem2;

  private ACClearableRadioButtonGroup kaigoRecuperationMedicalFacilitiesClinicStaffAssignmentDivision;

  private ACLabelContainer kaigoRecuperationMedicalFacilitiesClinicStaffAssignmentDivisionContainer;

  private ACListModelAdapter kaigoRecuperationMedicalFacilitiesClinicStaffAssignmentDivisionModel;

  private ACRadioButtonItem kaigoRecuperationMedicalFacilitiesClinicStaffAssignmentDivision1;

  private ACRadioButtonItem kaigoRecuperationMedicalFacilitiesClinicStaffAssignmentDivision2;

  private ACClearableRadioButtonGroup kaigoRecuperationMedicalFacilitiesClinicRecuperationEnvironmental;

  private ACLabelContainer kaigoRecuperationMedicalFacilitiesClinicRecuperationEnvironmentalContainer;

  private ACListModelAdapter kaigoRecuperationMedicalFacilitiesClinicRecuperationEnvironmentalModel;

  private ACRadioButtonItem kaigoRecuperationMedicalFacilitiesClinicRecuperationEnvironmentalStandard;

  private ACRadioButtonItem kaigoRecuperationMedicalFacilitiesClinicRecuperationEnvironmentalSubtraction1;

  private ACRadioButtonItem kaigoRecuperationMedicalFacilitiesClinicRecuperationEnvironmentalSubtraction2;

  private ACClearableRadioButtonGroup kaigoRecuperationMedicalFacilitiesClinicNutritionManageRadio;

  private ACLabelContainer kaigoRecuperationMedicalFacilitiesClinicNutritionManageRadioContainer;

  private ACListModelAdapter kaigoRecuperationMedicalFacilitiesClinicNutritionManageRadioModel;

  private ACRadioButtonItem kaigoRecuperationMedicalFacilitiesClinicNutritionManageRadioItem1;

  private ACRadioButtonItem kaigoRecuperationMedicalFacilitiesClinicNutritionManageRadioItem2;

  private ACClearableRadioButtonGroup kaigoRecuperationMedicalFacilitiesClinicNutritionRadio;

  private ACLabelContainer kaigoRecuperationMedicalFacilitiesClinicNutritionRadioContainer;

  private ACListModelAdapter kaigoRecuperationMedicalFacilitiesClinicNutritionRadioModel;

  private ACRadioButtonItem kaigoRecuperationMedicalFacilitiesClinicNutritionRadioItem1;

  private ACRadioButtonItem kaigoRecuperationMedicalFacilitiesClinicNutritionRadioItem2 ;

  private ACClearableRadioButtonGroup kaigoRecuperationMedicalFacilitiesClinicOralSwitchRadio;

  private ACLabelContainer kaigoRecuperationMedicalFacilitiesClinicOralSwitchRadioContainer;

  private ACListModelAdapter kaigoRecuperationMedicalFacilitiesClinicOralSwitchRadioModel;

  private ACRadioButtonItem kaigoRecuperationMedicalFacilitiesClinicOralSwitchRadioItem1;

  private ACRadioButtonItem kaigoRecuperationMedicalFacilitiesClinicOralSwitchRadioItem2 ;

  private ACClearableRadioButtonGroup kaigoRecuperationMedicalFacilitiesClinicRecuperateDinnerRadio;

  private ACLabelContainer kaigoRecuperationMedicalFacilitiesClinicRecuperateDinnerRadioContainer;

  private ACListModelAdapter kaigoRecuperationMedicalFacilitiesClinicRecuperateDinnerRadioModel;

  private ACRadioButtonItem kaigoRecuperationMedicalFacilitiesClinicRecuperateDinnerRadioItem1;

  private ACRadioButtonItem kaigoRecuperationMedicalFacilitiesClinicRecuperateDinnerRadioItem2;

  private ACClearableRadioButtonGroup kaigoRecuperationMedicalFacilitiesClinicStaffReduce;

  private ACLabelContainer kaigoRecuperationMedicalFacilitiesClinicStaffReduceContainer;

  private ACListModelAdapter kaigoRecuperationMedicalFacilitiesClinicStaffReduceModel;

  private ACRadioButtonItem kaigoRecuperationMedicalFacilitiesClinicStaffNot;

  private ACRadioButtonItem kaigoRecuperationMedicalFacilitiesClinicStaffExcess;

  private ACLabelContainer kaigoRecuperationMedicalFacilitiesDinnerStandeirdMoneyConteiner;

  private ACTextField kaigoRecuperationMedicalFacilitiesDinnerStandeirdMoneyTotal;

  private ACLabel kaigoRecuperationMedicalFacilitiesMorningDinnerStandeirdMoneyLabel;

  private ACTextField kaigoRecuperationMedicalFacilitiesMorningDinnerStandeirdMoney;

  private ACLabel kaigoRecuperationMedicalFacilitiesNoonDinnerStandeirdMoneyLabel;

  private ACTextField kaigoRecuperationMedicalFacilitiesNoonDinnerStandeirdMoney;

  private ACLabel kaigoRecuperationMedicalFacilitiesNightDinnerStandeirdMoneyLabel;

  private ACTextField kaigoRecuperationMedicalFacilitiesNightDinnerStandeirdMoney;

  private ACLabel kaigoRecuperationMedicalFacilitiesDinnerStandeirdMoney4Label;

  private ACLabelContainer kaigoRecuperationMedicalFacilitiesClinicUnitRoomStandeirdMoneyConteiner;

  private ACTextField kaigoRecuperationMedicalFacilitiesClinicUnitRoomStandeirdMoneyText;

  private ACLabel kaigoRecuperationMedicalFacilitiesClinicUnitRoomStandeirdMoneyLabel;

  private ACLabelContainer kaigoRecuperationMedicalFacilitiesClinicUnitSemiRoomStandeirdMoneyConteiner;

  private ACTextField kaigoRecuperationMedicalFacilitiesClinicUnitSemiRoomStandeirdMoneyText;

  private ACLabel kaigoRecuperationMedicalFacilitiesClinicUnitSemiRoomStandeirdMoneyLabel;

  private ACLabelContainer kaigoRecuperationMedicalFacilitiesClinicNormalRoomStandeirdMoneyConteiner;

  private ACTextField kaigoRecuperationMedicalFacilitiesClinicNormalRoomStandeirdMoneyText;

  private ACLabel kaigoRecuperationMedicalFacilitiesClinicNormalRoomStandeirdMoneyLabel;

  private ACLabelContainer kaigoRecuperationMedicalFacilitiesClinicTasyouRoomConteiner;

  private ACTextField kaigoRecuperationMedicalFacilitiesClinicTasyouRoomText;

  private ACLabel kaigoRecuperationMedicalFacilitiesClinicTasyouRoomLabel;

  //getter

  /**
   * ���ƃO���[�v���擾���܂��B
   * @return ���ƃO���[�v
   */
  public ACGroupBox getKaigoRecuperationMedicalFacilitiesClinicGroup(){
    if(kaigoRecuperationMedicalFacilitiesClinicGroup==null){

      kaigoRecuperationMedicalFacilitiesClinicGroup = new ACGroupBox();

      kaigoRecuperationMedicalFacilitiesClinicGroup.setText("���×{�^��Î{�݁i�f�Ï��^�j");

      kaigoRecuperationMedicalFacilitiesClinicGroup.setFollowChildEnabled(true);

      kaigoRecuperationMedicalFacilitiesClinicGroup.setHgrid(200);

      addKaigoRecuperationMedicalFacilitiesClinicGroup();
    }
    return kaigoRecuperationMedicalFacilitiesClinicGroup;

  }

  /**
   * �������R���e�i���擾���܂��B
   * @return �������R���e�i
   */
  public ACLabelContainer getKaigoRecuperationMedicalFacilitiesClinicDiscountContainer(){
    if(kaigoRecuperationMedicalFacilitiesClinicDiscountContainer==null){

      kaigoRecuperationMedicalFacilitiesClinicDiscountContainer = new ACLabelContainer();

      kaigoRecuperationMedicalFacilitiesClinicDiscountContainer.setText("������");

      kaigoRecuperationMedicalFacilitiesClinicDiscountContainer.setFollowChildEnabled(true);

      addKaigoRecuperationMedicalFacilitiesClinicDiscountContainer();
    }
    return kaigoRecuperationMedicalFacilitiesClinicDiscountContainer;

  }

  /**
   * ���������擾���܂��B
   * @return ������
   */
  public ACTextField getKaigoRecuperationMedicalFacilitiesClinicDiscountRate(){
    if(kaigoRecuperationMedicalFacilitiesClinicDiscountRate==null){

      kaigoRecuperationMedicalFacilitiesClinicDiscountRate = new ACTextField();

      kaigoRecuperationMedicalFacilitiesClinicDiscountRate.setBindPath("REDUCT_RATE");

      kaigoRecuperationMedicalFacilitiesClinicDiscountRate.setColumns(3);

      kaigoRecuperationMedicalFacilitiesClinicDiscountRate.setCharType(VRCharType.ONLY_DIGIT);

      kaigoRecuperationMedicalFacilitiesClinicDiscountRate.setHorizontalAlignment(SwingConstants.RIGHT);

      kaigoRecuperationMedicalFacilitiesClinicDiscountRate.setIMEMode(InputSubset.LATIN);

      kaigoRecuperationMedicalFacilitiesClinicDiscountRate.setMaxLength(3);

      addKaigoRecuperationMedicalFacilitiesClinicDiscountRate();
    }
    return kaigoRecuperationMedicalFacilitiesClinicDiscountRate;

  }

  /**
   * �����x�����擾���܂��B
   * @return �����x��
   */
  public ACLabel getKaigoRecuperationMedicalFacilitiesClinicPercentSign(){
    if(kaigoRecuperationMedicalFacilitiesClinicPercentSign==null){

      kaigoRecuperationMedicalFacilitiesClinicPercentSign = new ACLabel();

      kaigoRecuperationMedicalFacilitiesClinicPercentSign.setText("��");

      addKaigoRecuperationMedicalFacilitiesClinicPercentSign();
    }
    return kaigoRecuperationMedicalFacilitiesClinicPercentSign;

  }

  /**
   * �{�݋敪���W�I�O���[�v���擾���܂��B
   * @return �{�݋敪���W�I�O���[�v
   */
  public ACClearableRadioButtonGroup getKaigoRecuperationMedicalFacilitiesClinicInstitutionDivisionRadio(){
    if(kaigoRecuperationMedicalFacilitiesClinicInstitutionDivisionRadio==null){

      kaigoRecuperationMedicalFacilitiesClinicInstitutionDivisionRadio = new ACClearableRadioButtonGroup();

      getKaigoRecuperationMedicalFacilitiesClinicInstitutionDivisionRadioContainer().setText("�{�݋敪");

      kaigoRecuperationMedicalFacilitiesClinicInstitutionDivisionRadio.setBindPath("1530201");

      kaigoRecuperationMedicalFacilitiesClinicInstitutionDivisionRadio.setModel(getKaigoRecuperationMedicalFacilitiesClinicInstitutionDivisionRadioModel());

      kaigoRecuperationMedicalFacilitiesClinicInstitutionDivisionRadio.setUseClearButton(false);

      addKaigoRecuperationMedicalFacilitiesClinicInstitutionDivisionRadio();
    }
    return kaigoRecuperationMedicalFacilitiesClinicInstitutionDivisionRadio;

  }

  /**
   * �{�݋敪���W�I�O���[�v�R���e�i���擾���܂��B
   * @return �{�݋敪���W�I�O���[�v�R���e�i
   */
  protected ACLabelContainer getKaigoRecuperationMedicalFacilitiesClinicInstitutionDivisionRadioContainer(){
    if(kaigoRecuperationMedicalFacilitiesClinicInstitutionDivisionRadioContainer==null){
      kaigoRecuperationMedicalFacilitiesClinicInstitutionDivisionRadioContainer = new ACLabelContainer();
      kaigoRecuperationMedicalFacilitiesClinicInstitutionDivisionRadioContainer.setFollowChildEnabled(true);
      kaigoRecuperationMedicalFacilitiesClinicInstitutionDivisionRadioContainer.add(getKaigoRecuperationMedicalFacilitiesClinicInstitutionDivisionRadio(), null);
    }
    return kaigoRecuperationMedicalFacilitiesClinicInstitutionDivisionRadioContainer;
  }

  /**
   * �{�݋敪���W�I�O���[�v���f�����擾���܂��B
   * @return �{�݋敪���W�I�O���[�v���f��
   */
  protected ACListModelAdapter getKaigoRecuperationMedicalFacilitiesClinicInstitutionDivisionRadioModel(){
    if(kaigoRecuperationMedicalFacilitiesClinicInstitutionDivisionRadioModel==null){
      kaigoRecuperationMedicalFacilitiesClinicInstitutionDivisionRadioModel = new ACListModelAdapter();
      addKaigoRecuperationMedicalFacilitiesClinicInstitutionDivisionRadioModel();
    }
    return kaigoRecuperationMedicalFacilitiesClinicInstitutionDivisionRadioModel;
  }

  /**
   * �f�Ï����擾���܂��B
   * @return �f�Ï�
   */
  public ACRadioButtonItem getKaigoRecuperationMedicalFacilitiesClinicInstitutionDivisionRadioItem1(){
    if(kaigoRecuperationMedicalFacilitiesClinicInstitutionDivisionRadioItem1==null){

      kaigoRecuperationMedicalFacilitiesClinicInstitutionDivisionRadioItem1 = new ACRadioButtonItem();

      kaigoRecuperationMedicalFacilitiesClinicInstitutionDivisionRadioItem1.setText("�f�Ï�");

      kaigoRecuperationMedicalFacilitiesClinicInstitutionDivisionRadioItem1.setGroup(getKaigoRecuperationMedicalFacilitiesClinicInstitutionDivisionRadio());

      addKaigoRecuperationMedicalFacilitiesClinicInstitutionDivisionRadioItem1();
    }
    return kaigoRecuperationMedicalFacilitiesClinicInstitutionDivisionRadioItem1;

  }

  /**
   * ���j�b�g�^�f�Ï����擾���܂��B
   * @return ���j�b�g�^�f�Ï�
   */
  public ACRadioButtonItem getKaigoRecuperationMedicalFacilitiesClinicInstitutionDivisionRadioItem2(){
    if(kaigoRecuperationMedicalFacilitiesClinicInstitutionDivisionRadioItem2==null){

      kaigoRecuperationMedicalFacilitiesClinicInstitutionDivisionRadioItem2 = new ACRadioButtonItem();

      kaigoRecuperationMedicalFacilitiesClinicInstitutionDivisionRadioItem2.setText("���j�b�g�^�f�Ï�");

      kaigoRecuperationMedicalFacilitiesClinicInstitutionDivisionRadioItem2.setGroup(getKaigoRecuperationMedicalFacilitiesClinicInstitutionDivisionRadio());

      addKaigoRecuperationMedicalFacilitiesClinicInstitutionDivisionRadioItem2();
    }
    return kaigoRecuperationMedicalFacilitiesClinicInstitutionDivisionRadioItem2;

  }

  /**
   * �l���z�u�敪���W�I�O���[�v���擾���܂��B
   * @return �l���z�u�敪���W�I�O���[�v
   */
  public ACClearableRadioButtonGroup getKaigoRecuperationMedicalFacilitiesClinicStaffAssignmentDivision(){
    if(kaigoRecuperationMedicalFacilitiesClinicStaffAssignmentDivision==null){

      kaigoRecuperationMedicalFacilitiesClinicStaffAssignmentDivision = new ACClearableRadioButtonGroup();

      getKaigoRecuperationMedicalFacilitiesClinicStaffAssignmentDivisionContainer().setText("�l���z�u�敪");

      kaigoRecuperationMedicalFacilitiesClinicStaffAssignmentDivision.setBindPath("1530202");

      kaigoRecuperationMedicalFacilitiesClinicStaffAssignmentDivision.setModel(getKaigoRecuperationMedicalFacilitiesClinicStaffAssignmentDivisionModel());

      kaigoRecuperationMedicalFacilitiesClinicStaffAssignmentDivision.setUseClearButton(false);

      addKaigoRecuperationMedicalFacilitiesClinicStaffAssignmentDivision();
    }
    return kaigoRecuperationMedicalFacilitiesClinicStaffAssignmentDivision;

  }

  /**
   * �l���z�u�敪���W�I�O���[�v�R���e�i���擾���܂��B
   * @return �l���z�u�敪���W�I�O���[�v�R���e�i
   */
  protected ACLabelContainer getKaigoRecuperationMedicalFacilitiesClinicStaffAssignmentDivisionContainer(){
    if(kaigoRecuperationMedicalFacilitiesClinicStaffAssignmentDivisionContainer==null){
      kaigoRecuperationMedicalFacilitiesClinicStaffAssignmentDivisionContainer = new ACLabelContainer();
      kaigoRecuperationMedicalFacilitiesClinicStaffAssignmentDivisionContainer.setFollowChildEnabled(true);
      kaigoRecuperationMedicalFacilitiesClinicStaffAssignmentDivisionContainer.add(getKaigoRecuperationMedicalFacilitiesClinicStaffAssignmentDivision(), null);
    }
    return kaigoRecuperationMedicalFacilitiesClinicStaffAssignmentDivisionContainer;
  }

  /**
   * �l���z�u�敪���W�I�O���[�v���f�����擾���܂��B
   * @return �l���z�u�敪���W�I�O���[�v���f��
   */
  protected ACListModelAdapter getKaigoRecuperationMedicalFacilitiesClinicStaffAssignmentDivisionModel(){
    if(kaigoRecuperationMedicalFacilitiesClinicStaffAssignmentDivisionModel==null){
      kaigoRecuperationMedicalFacilitiesClinicStaffAssignmentDivisionModel = new ACListModelAdapter();
      addKaigoRecuperationMedicalFacilitiesClinicStaffAssignmentDivisionModel();
    }
    return kaigoRecuperationMedicalFacilitiesClinicStaffAssignmentDivisionModel;
  }

  /**
   * I�^���擾���܂��B
   * @return I�^
   */
  public ACRadioButtonItem getKaigoRecuperationMedicalFacilitiesClinicStaffAssignmentDivision1(){
    if(kaigoRecuperationMedicalFacilitiesClinicStaffAssignmentDivision1==null){

      kaigoRecuperationMedicalFacilitiesClinicStaffAssignmentDivision1 = new ACRadioButtonItem();

      kaigoRecuperationMedicalFacilitiesClinicStaffAssignmentDivision1.setText("I�^");

      kaigoRecuperationMedicalFacilitiesClinicStaffAssignmentDivision1.setGroup(getKaigoRecuperationMedicalFacilitiesClinicStaffAssignmentDivision());

      addKaigoRecuperationMedicalFacilitiesClinicStaffAssignmentDivision1();
    }
    return kaigoRecuperationMedicalFacilitiesClinicStaffAssignmentDivision1;

  }

  /**
   * II�^���擾���܂��B
   * @return II�^
   */
  public ACRadioButtonItem getKaigoRecuperationMedicalFacilitiesClinicStaffAssignmentDivision2(){
    if(kaigoRecuperationMedicalFacilitiesClinicStaffAssignmentDivision2==null){

      kaigoRecuperationMedicalFacilitiesClinicStaffAssignmentDivision2 = new ACRadioButtonItem();

      kaigoRecuperationMedicalFacilitiesClinicStaffAssignmentDivision2.setText("II�^");

      kaigoRecuperationMedicalFacilitiesClinicStaffAssignmentDivision2.setGroup(getKaigoRecuperationMedicalFacilitiesClinicStaffAssignmentDivision());

      addKaigoRecuperationMedicalFacilitiesClinicStaffAssignmentDivision2();
    }
    return kaigoRecuperationMedicalFacilitiesClinicStaffAssignmentDivision2;

  }

  /**
   * �×{������W�I�O���[�v���擾���܂��B
   * @return �×{������W�I�O���[�v
   */
  public ACClearableRadioButtonGroup getKaigoRecuperationMedicalFacilitiesClinicRecuperationEnvironmental(){
    if(kaigoRecuperationMedicalFacilitiesClinicRecuperationEnvironmental==null){

      kaigoRecuperationMedicalFacilitiesClinicRecuperationEnvironmental = new ACClearableRadioButtonGroup();

      getKaigoRecuperationMedicalFacilitiesClinicRecuperationEnvironmentalContainer().setText("�×{���");

      kaigoRecuperationMedicalFacilitiesClinicRecuperationEnvironmental.setBindPath("1530203");

      kaigoRecuperationMedicalFacilitiesClinicRecuperationEnvironmental.setModel(getKaigoRecuperationMedicalFacilitiesClinicRecuperationEnvironmentalModel());

      kaigoRecuperationMedicalFacilitiesClinicRecuperationEnvironmental.setUseClearButton(false);

      addKaigoRecuperationMedicalFacilitiesClinicRecuperationEnvironmental();
    }
    return kaigoRecuperationMedicalFacilitiesClinicRecuperationEnvironmental;

  }

  /**
   * �×{������W�I�O���[�v�R���e�i���擾���܂��B
   * @return �×{������W�I�O���[�v�R���e�i
   */
  protected ACLabelContainer getKaigoRecuperationMedicalFacilitiesClinicRecuperationEnvironmentalContainer(){
    if(kaigoRecuperationMedicalFacilitiesClinicRecuperationEnvironmentalContainer==null){
      kaigoRecuperationMedicalFacilitiesClinicRecuperationEnvironmentalContainer = new ACLabelContainer();
      kaigoRecuperationMedicalFacilitiesClinicRecuperationEnvironmentalContainer.setFollowChildEnabled(true);
      kaigoRecuperationMedicalFacilitiesClinicRecuperationEnvironmentalContainer.add(getKaigoRecuperationMedicalFacilitiesClinicRecuperationEnvironmental(), null);
    }
    return kaigoRecuperationMedicalFacilitiesClinicRecuperationEnvironmentalContainer;
  }

  /**
   * �×{������W�I�O���[�v���f�����擾���܂��B
   * @return �×{������W�I�O���[�v���f��
   */
  protected ACListModelAdapter getKaigoRecuperationMedicalFacilitiesClinicRecuperationEnvironmentalModel(){
    if(kaigoRecuperationMedicalFacilitiesClinicRecuperationEnvironmentalModel==null){
      kaigoRecuperationMedicalFacilitiesClinicRecuperationEnvironmentalModel = new ACListModelAdapter();
      addKaigoRecuperationMedicalFacilitiesClinicRecuperationEnvironmentalModel();
    }
    return kaigoRecuperationMedicalFacilitiesClinicRecuperationEnvironmentalModel;
  }

  /**
   * ��^���擾���܂��B
   * @return ��^
   */
  public ACRadioButtonItem getKaigoRecuperationMedicalFacilitiesClinicRecuperationEnvironmentalStandard(){
    if(kaigoRecuperationMedicalFacilitiesClinicRecuperationEnvironmentalStandard==null){

      kaigoRecuperationMedicalFacilitiesClinicRecuperationEnvironmentalStandard = new ACRadioButtonItem();

      kaigoRecuperationMedicalFacilitiesClinicRecuperationEnvironmentalStandard.setText("��^");

      kaigoRecuperationMedicalFacilitiesClinicRecuperationEnvironmentalStandard.setGroup(getKaigoRecuperationMedicalFacilitiesClinicRecuperationEnvironmental());

      addKaigoRecuperationMedicalFacilitiesClinicRecuperationEnvironmentalStandard();
    }
    return kaigoRecuperationMedicalFacilitiesClinicRecuperationEnvironmentalStandard;

  }

  /**
   * ���Z�^I���擾���܂��B
   * @return ���Z�^I
   */
  public ACRadioButtonItem getKaigoRecuperationMedicalFacilitiesClinicRecuperationEnvironmentalSubtraction1(){
    if(kaigoRecuperationMedicalFacilitiesClinicRecuperationEnvironmentalSubtraction1==null){

      kaigoRecuperationMedicalFacilitiesClinicRecuperationEnvironmentalSubtraction1 = new ACRadioButtonItem();

      kaigoRecuperationMedicalFacilitiesClinicRecuperationEnvironmentalSubtraction1.setText("���Z�^I");

      kaigoRecuperationMedicalFacilitiesClinicRecuperationEnvironmentalSubtraction1.setGroup(getKaigoRecuperationMedicalFacilitiesClinicRecuperationEnvironmental());

      addKaigoRecuperationMedicalFacilitiesClinicRecuperationEnvironmentalSubtraction1();
    }
    return kaigoRecuperationMedicalFacilitiesClinicRecuperationEnvironmentalSubtraction1;

  }

  /**
   * ���Z�^II���擾���܂��B
   * @return ���Z�^II
   */
  public ACRadioButtonItem getKaigoRecuperationMedicalFacilitiesClinicRecuperationEnvironmentalSubtraction2(){
    if(kaigoRecuperationMedicalFacilitiesClinicRecuperationEnvironmentalSubtraction2==null){

      kaigoRecuperationMedicalFacilitiesClinicRecuperationEnvironmentalSubtraction2 = new ACRadioButtonItem();

      kaigoRecuperationMedicalFacilitiesClinicRecuperationEnvironmentalSubtraction2.setText("���Z�^II");

      kaigoRecuperationMedicalFacilitiesClinicRecuperationEnvironmentalSubtraction2.setGroup(getKaigoRecuperationMedicalFacilitiesClinicRecuperationEnvironmental());

      addKaigoRecuperationMedicalFacilitiesClinicRecuperationEnvironmentalSubtraction2();
    }
    return kaigoRecuperationMedicalFacilitiesClinicRecuperationEnvironmentalSubtraction2;

  }

  /**
   * �h�{�Ǘ��̐����W�I�O���[�v���擾���܂��B
   * @return �h�{�Ǘ��̐����W�I�O���[�v
   */
  public ACClearableRadioButtonGroup getKaigoRecuperationMedicalFacilitiesClinicNutritionManageRadio(){
    if(kaigoRecuperationMedicalFacilitiesClinicNutritionManageRadio==null){

      kaigoRecuperationMedicalFacilitiesClinicNutritionManageRadio = new ACClearableRadioButtonGroup();

      getKaigoRecuperationMedicalFacilitiesClinicNutritionManageRadioContainer().setText("�h�{�Ǘ��̐�");

      kaigoRecuperationMedicalFacilitiesClinicNutritionManageRadio.setBindPath("1530204");

      kaigoRecuperationMedicalFacilitiesClinicNutritionManageRadio.setModel(getKaigoRecuperationMedicalFacilitiesClinicNutritionManageRadioModel());

      kaigoRecuperationMedicalFacilitiesClinicNutritionManageRadio.setUseClearButton(false);

      addKaigoRecuperationMedicalFacilitiesClinicNutritionManageRadio();
    }
    return kaigoRecuperationMedicalFacilitiesClinicNutritionManageRadio;

  }

  /**
   * �h�{�Ǘ��̐����W�I�O���[�v�R���e�i���擾���܂��B
   * @return �h�{�Ǘ��̐����W�I�O���[�v�R���e�i
   */
  protected ACLabelContainer getKaigoRecuperationMedicalFacilitiesClinicNutritionManageRadioContainer(){
    if(kaigoRecuperationMedicalFacilitiesClinicNutritionManageRadioContainer==null){
      kaigoRecuperationMedicalFacilitiesClinicNutritionManageRadioContainer = new ACLabelContainer();
      kaigoRecuperationMedicalFacilitiesClinicNutritionManageRadioContainer.setFollowChildEnabled(true);
      kaigoRecuperationMedicalFacilitiesClinicNutritionManageRadioContainer.add(getKaigoRecuperationMedicalFacilitiesClinicNutritionManageRadio(), null);
    }
    return kaigoRecuperationMedicalFacilitiesClinicNutritionManageRadioContainer;
  }

  /**
   * �h�{�Ǘ��̐����W�I�O���[�v���f�����擾���܂��B
   * @return �h�{�Ǘ��̐����W�I�O���[�v���f��
   */
  protected ACListModelAdapter getKaigoRecuperationMedicalFacilitiesClinicNutritionManageRadioModel(){
    if(kaigoRecuperationMedicalFacilitiesClinicNutritionManageRadioModel==null){
      kaigoRecuperationMedicalFacilitiesClinicNutritionManageRadioModel = new ACListModelAdapter();
      addKaigoRecuperationMedicalFacilitiesClinicNutritionManageRadioModel();
    }
    return kaigoRecuperationMedicalFacilitiesClinicNutritionManageRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getKaigoRecuperationMedicalFacilitiesClinicNutritionManageRadioItem1(){
    if(kaigoRecuperationMedicalFacilitiesClinicNutritionManageRadioItem1==null){

      kaigoRecuperationMedicalFacilitiesClinicNutritionManageRadioItem1 = new ACRadioButtonItem();

      kaigoRecuperationMedicalFacilitiesClinicNutritionManageRadioItem1.setText("�Ȃ�");

      kaigoRecuperationMedicalFacilitiesClinicNutritionManageRadioItem1.setGroup(getKaigoRecuperationMedicalFacilitiesClinicNutritionManageRadio());

      addKaigoRecuperationMedicalFacilitiesClinicNutritionManageRadioItem1();
    }
    return kaigoRecuperationMedicalFacilitiesClinicNutritionManageRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getKaigoRecuperationMedicalFacilitiesClinicNutritionManageRadioItem2(){
    if(kaigoRecuperationMedicalFacilitiesClinicNutritionManageRadioItem2==null){

      kaigoRecuperationMedicalFacilitiesClinicNutritionManageRadioItem2 = new ACRadioButtonItem();

      kaigoRecuperationMedicalFacilitiesClinicNutritionManageRadioItem2.setText("����");

      kaigoRecuperationMedicalFacilitiesClinicNutritionManageRadioItem2.setGroup(getKaigoRecuperationMedicalFacilitiesClinicNutritionManageRadio());

      addKaigoRecuperationMedicalFacilitiesClinicNutritionManageRadioItem2();
    }
    return kaigoRecuperationMedicalFacilitiesClinicNutritionManageRadioItem2;

  }

  /**
   * �h�{�}�l�W�����g�̐����W�I�O���[�v���擾���܂��B
   * @return �h�{�}�l�W�����g�̐����W�I�O���[�v
   */
  public ACClearableRadioButtonGroup getKaigoRecuperationMedicalFacilitiesClinicNutritionRadio(){
    if(kaigoRecuperationMedicalFacilitiesClinicNutritionRadio==null){

      kaigoRecuperationMedicalFacilitiesClinicNutritionRadio = new ACClearableRadioButtonGroup();

      getKaigoRecuperationMedicalFacilitiesClinicNutritionRadioContainer().setText("�h�{�}�l�W�����g�̐�");

      kaigoRecuperationMedicalFacilitiesClinicNutritionRadio.setBindPath("1530205");

      kaigoRecuperationMedicalFacilitiesClinicNutritionRadio.setModel(getKaigoRecuperationMedicalFacilitiesClinicNutritionRadioModel());

      kaigoRecuperationMedicalFacilitiesClinicNutritionRadio.setUseClearButton(false);

      addKaigoRecuperationMedicalFacilitiesClinicNutritionRadio();
    }
    return kaigoRecuperationMedicalFacilitiesClinicNutritionRadio;

  }

  /**
   * �h�{�}�l�W�����g�̐����W�I�O���[�v�R���e�i���擾���܂��B
   * @return �h�{�}�l�W�����g�̐����W�I�O���[�v�R���e�i
   */
  protected ACLabelContainer getKaigoRecuperationMedicalFacilitiesClinicNutritionRadioContainer(){
    if(kaigoRecuperationMedicalFacilitiesClinicNutritionRadioContainer==null){
      kaigoRecuperationMedicalFacilitiesClinicNutritionRadioContainer = new ACLabelContainer();
      kaigoRecuperationMedicalFacilitiesClinicNutritionRadioContainer.setFollowChildEnabled(true);
      kaigoRecuperationMedicalFacilitiesClinicNutritionRadioContainer.add(getKaigoRecuperationMedicalFacilitiesClinicNutritionRadio(), null);
    }
    return kaigoRecuperationMedicalFacilitiesClinicNutritionRadioContainer;
  }

  /**
   * �h�{�}�l�W�����g�̐����W�I�O���[�v���f�����擾���܂��B
   * @return �h�{�}�l�W�����g�̐����W�I�O���[�v���f��
   */
  protected ACListModelAdapter getKaigoRecuperationMedicalFacilitiesClinicNutritionRadioModel(){
    if(kaigoRecuperationMedicalFacilitiesClinicNutritionRadioModel==null){
      kaigoRecuperationMedicalFacilitiesClinicNutritionRadioModel = new ACListModelAdapter();
      addKaigoRecuperationMedicalFacilitiesClinicNutritionRadioModel();
    }
    return kaigoRecuperationMedicalFacilitiesClinicNutritionRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getKaigoRecuperationMedicalFacilitiesClinicNutritionRadioItem1(){
    if(kaigoRecuperationMedicalFacilitiesClinicNutritionRadioItem1==null){

      kaigoRecuperationMedicalFacilitiesClinicNutritionRadioItem1 = new ACRadioButtonItem();

      kaigoRecuperationMedicalFacilitiesClinicNutritionRadioItem1.setText("�Ȃ�");

      kaigoRecuperationMedicalFacilitiesClinicNutritionRadioItem1.setGroup(getKaigoRecuperationMedicalFacilitiesClinicNutritionRadio());

      addKaigoRecuperationMedicalFacilitiesClinicNutritionRadioItem1();
    }
    return kaigoRecuperationMedicalFacilitiesClinicNutritionRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getKaigoRecuperationMedicalFacilitiesClinicNutritionRadioItem2 (){
    if(kaigoRecuperationMedicalFacilitiesClinicNutritionRadioItem2 ==null){

      kaigoRecuperationMedicalFacilitiesClinicNutritionRadioItem2  = new ACRadioButtonItem();

      kaigoRecuperationMedicalFacilitiesClinicNutritionRadioItem2 .setText("����");

      kaigoRecuperationMedicalFacilitiesClinicNutritionRadioItem2 .setGroup(getKaigoRecuperationMedicalFacilitiesClinicNutritionRadio());

      addKaigoRecuperationMedicalFacilitiesClinicNutritionRadioItem2 ();
    }
    return kaigoRecuperationMedicalFacilitiesClinicNutritionRadioItem2 ;

  }

  /**
   * �o���ڍs�̐����W�I�O���[�v���擾���܂��B
   * @return �o���ڍs�̐����W�I�O���[�v
   */
  public ACClearableRadioButtonGroup getKaigoRecuperationMedicalFacilitiesClinicOralSwitchRadio(){
    if(kaigoRecuperationMedicalFacilitiesClinicOralSwitchRadio==null){

      kaigoRecuperationMedicalFacilitiesClinicOralSwitchRadio = new ACClearableRadioButtonGroup();

      getKaigoRecuperationMedicalFacilitiesClinicOralSwitchRadioContainer().setText("�o���ڍs�̐�");

      kaigoRecuperationMedicalFacilitiesClinicOralSwitchRadio.setBindPath("1530206");

      kaigoRecuperationMedicalFacilitiesClinicOralSwitchRadio.setModel(getKaigoRecuperationMedicalFacilitiesClinicOralSwitchRadioModel());

      kaigoRecuperationMedicalFacilitiesClinicOralSwitchRadio.setUseClearButton(false);

      addKaigoRecuperationMedicalFacilitiesClinicOralSwitchRadio();
    }
    return kaigoRecuperationMedicalFacilitiesClinicOralSwitchRadio;

  }

  /**
   * �o���ڍs�̐����W�I�O���[�v�R���e�i���擾���܂��B
   * @return �o���ڍs�̐����W�I�O���[�v�R���e�i
   */
  protected ACLabelContainer getKaigoRecuperationMedicalFacilitiesClinicOralSwitchRadioContainer(){
    if(kaigoRecuperationMedicalFacilitiesClinicOralSwitchRadioContainer==null){
      kaigoRecuperationMedicalFacilitiesClinicOralSwitchRadioContainer = new ACLabelContainer();
      kaigoRecuperationMedicalFacilitiesClinicOralSwitchRadioContainer.setFollowChildEnabled(true);
      kaigoRecuperationMedicalFacilitiesClinicOralSwitchRadioContainer.add(getKaigoRecuperationMedicalFacilitiesClinicOralSwitchRadio(), null);
    }
    return kaigoRecuperationMedicalFacilitiesClinicOralSwitchRadioContainer;
  }

  /**
   * �o���ڍs�̐����W�I�O���[�v���f�����擾���܂��B
   * @return �o���ڍs�̐����W�I�O���[�v���f��
   */
  protected ACListModelAdapter getKaigoRecuperationMedicalFacilitiesClinicOralSwitchRadioModel(){
    if(kaigoRecuperationMedicalFacilitiesClinicOralSwitchRadioModel==null){
      kaigoRecuperationMedicalFacilitiesClinicOralSwitchRadioModel = new ACListModelAdapter();
      addKaigoRecuperationMedicalFacilitiesClinicOralSwitchRadioModel();
    }
    return kaigoRecuperationMedicalFacilitiesClinicOralSwitchRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getKaigoRecuperationMedicalFacilitiesClinicOralSwitchRadioItem1(){
    if(kaigoRecuperationMedicalFacilitiesClinicOralSwitchRadioItem1==null){

      kaigoRecuperationMedicalFacilitiesClinicOralSwitchRadioItem1 = new ACRadioButtonItem();

      kaigoRecuperationMedicalFacilitiesClinicOralSwitchRadioItem1.setText("�Ȃ�");

      kaigoRecuperationMedicalFacilitiesClinicOralSwitchRadioItem1.setGroup(getKaigoRecuperationMedicalFacilitiesClinicOralSwitchRadio());

      addKaigoRecuperationMedicalFacilitiesClinicOralSwitchRadioItem1();
    }
    return kaigoRecuperationMedicalFacilitiesClinicOralSwitchRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getKaigoRecuperationMedicalFacilitiesClinicOralSwitchRadioItem2 (){
    if(kaigoRecuperationMedicalFacilitiesClinicOralSwitchRadioItem2 ==null){

      kaigoRecuperationMedicalFacilitiesClinicOralSwitchRadioItem2  = new ACRadioButtonItem();

      kaigoRecuperationMedicalFacilitiesClinicOralSwitchRadioItem2 .setText("����");

      kaigoRecuperationMedicalFacilitiesClinicOralSwitchRadioItem2 .setGroup(getKaigoRecuperationMedicalFacilitiesClinicOralSwitchRadio());

      addKaigoRecuperationMedicalFacilitiesClinicOralSwitchRadioItem2 ();
    }
    return kaigoRecuperationMedicalFacilitiesClinicOralSwitchRadioItem2 ;

  }

  /**
   * �×{�H�̐����W�I�O���[�v���擾���܂��B
   * @return �×{�H�̐����W�I�O���[�v
   */
  public ACClearableRadioButtonGroup getKaigoRecuperationMedicalFacilitiesClinicRecuperateDinnerRadio(){
    if(kaigoRecuperationMedicalFacilitiesClinicRecuperateDinnerRadio==null){

      kaigoRecuperationMedicalFacilitiesClinicRecuperateDinnerRadio = new ACClearableRadioButtonGroup();

      getKaigoRecuperationMedicalFacilitiesClinicRecuperateDinnerRadioContainer().setText("�×{�H�̐�");

      kaigoRecuperationMedicalFacilitiesClinicRecuperateDinnerRadio.setBindPath("1530207");

      kaigoRecuperationMedicalFacilitiesClinicRecuperateDinnerRadio.setModel(getKaigoRecuperationMedicalFacilitiesClinicRecuperateDinnerRadioModel());

      kaigoRecuperationMedicalFacilitiesClinicRecuperateDinnerRadio.setUseClearButton(false);

      addKaigoRecuperationMedicalFacilitiesClinicRecuperateDinnerRadio();
    }
    return kaigoRecuperationMedicalFacilitiesClinicRecuperateDinnerRadio;

  }

  /**
   * �×{�H�̐����W�I�O���[�v�R���e�i���擾���܂��B
   * @return �×{�H�̐����W�I�O���[�v�R���e�i
   */
  protected ACLabelContainer getKaigoRecuperationMedicalFacilitiesClinicRecuperateDinnerRadioContainer(){
    if(kaigoRecuperationMedicalFacilitiesClinicRecuperateDinnerRadioContainer==null){
      kaigoRecuperationMedicalFacilitiesClinicRecuperateDinnerRadioContainer = new ACLabelContainer();
      kaigoRecuperationMedicalFacilitiesClinicRecuperateDinnerRadioContainer.setFollowChildEnabled(true);
      kaigoRecuperationMedicalFacilitiesClinicRecuperateDinnerRadioContainer.add(getKaigoRecuperationMedicalFacilitiesClinicRecuperateDinnerRadio(), null);
    }
    return kaigoRecuperationMedicalFacilitiesClinicRecuperateDinnerRadioContainer;
  }

  /**
   * �×{�H�̐����W�I�O���[�v���f�����擾���܂��B
   * @return �×{�H�̐����W�I�O���[�v���f��
   */
  protected ACListModelAdapter getKaigoRecuperationMedicalFacilitiesClinicRecuperateDinnerRadioModel(){
    if(kaigoRecuperationMedicalFacilitiesClinicRecuperateDinnerRadioModel==null){
      kaigoRecuperationMedicalFacilitiesClinicRecuperateDinnerRadioModel = new ACListModelAdapter();
      addKaigoRecuperationMedicalFacilitiesClinicRecuperateDinnerRadioModel();
    }
    return kaigoRecuperationMedicalFacilitiesClinicRecuperateDinnerRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getKaigoRecuperationMedicalFacilitiesClinicRecuperateDinnerRadioItem1(){
    if(kaigoRecuperationMedicalFacilitiesClinicRecuperateDinnerRadioItem1==null){

      kaigoRecuperationMedicalFacilitiesClinicRecuperateDinnerRadioItem1 = new ACRadioButtonItem();

      kaigoRecuperationMedicalFacilitiesClinicRecuperateDinnerRadioItem1.setText("�Ȃ�");

      kaigoRecuperationMedicalFacilitiesClinicRecuperateDinnerRadioItem1.setGroup(getKaigoRecuperationMedicalFacilitiesClinicRecuperateDinnerRadio());

      addKaigoRecuperationMedicalFacilitiesClinicRecuperateDinnerRadioItem1();
    }
    return kaigoRecuperationMedicalFacilitiesClinicRecuperateDinnerRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getKaigoRecuperationMedicalFacilitiesClinicRecuperateDinnerRadioItem2(){
    if(kaigoRecuperationMedicalFacilitiesClinicRecuperateDinnerRadioItem2==null){

      kaigoRecuperationMedicalFacilitiesClinicRecuperateDinnerRadioItem2 = new ACRadioButtonItem();

      kaigoRecuperationMedicalFacilitiesClinicRecuperateDinnerRadioItem2.setText("����");

      kaigoRecuperationMedicalFacilitiesClinicRecuperateDinnerRadioItem2.setGroup(getKaigoRecuperationMedicalFacilitiesClinicRecuperateDinnerRadio());

      addKaigoRecuperationMedicalFacilitiesClinicRecuperateDinnerRadioItem2();
    }
    return kaigoRecuperationMedicalFacilitiesClinicRecuperateDinnerRadioItem2;

  }

  /**
   * �l�����Z���W�I�O���[�v���擾���܂��B
   * @return �l�����Z���W�I�O���[�v
   */
  public ACClearableRadioButtonGroup getKaigoRecuperationMedicalFacilitiesClinicStaffReduce(){
    if(kaigoRecuperationMedicalFacilitiesClinicStaffReduce==null){

      kaigoRecuperationMedicalFacilitiesClinicStaffReduce = new ACClearableRadioButtonGroup();

      getKaigoRecuperationMedicalFacilitiesClinicStaffReduceContainer().setText("�l�����Z");

      kaigoRecuperationMedicalFacilitiesClinicStaffReduce.setBindPath("1530208");

      kaigoRecuperationMedicalFacilitiesClinicStaffReduce.setModel(getKaigoRecuperationMedicalFacilitiesClinicStaffReduceModel());

      kaigoRecuperationMedicalFacilitiesClinicStaffReduce.setUseClearButton(false);

      addKaigoRecuperationMedicalFacilitiesClinicStaffReduce();
    }
    return kaigoRecuperationMedicalFacilitiesClinicStaffReduce;

  }

  /**
   * �l�����Z���W�I�O���[�v�R���e�i���擾���܂��B
   * @return �l�����Z���W�I�O���[�v�R���e�i
   */
  protected ACLabelContainer getKaigoRecuperationMedicalFacilitiesClinicStaffReduceContainer(){
    if(kaigoRecuperationMedicalFacilitiesClinicStaffReduceContainer==null){
      kaigoRecuperationMedicalFacilitiesClinicStaffReduceContainer = new ACLabelContainer();
      kaigoRecuperationMedicalFacilitiesClinicStaffReduceContainer.setFollowChildEnabled(true);
      kaigoRecuperationMedicalFacilitiesClinicStaffReduceContainer.add(getKaigoRecuperationMedicalFacilitiesClinicStaffReduce(), null);
    }
    return kaigoRecuperationMedicalFacilitiesClinicStaffReduceContainer;
  }

  /**
   * �l�����Z���W�I�O���[�v���f�����擾���܂��B
   * @return �l�����Z���W�I�O���[�v���f��
   */
  protected ACListModelAdapter getKaigoRecuperationMedicalFacilitiesClinicStaffReduceModel(){
    if(kaigoRecuperationMedicalFacilitiesClinicStaffReduceModel==null){
      kaigoRecuperationMedicalFacilitiesClinicStaffReduceModel = new ACListModelAdapter();
      addKaigoRecuperationMedicalFacilitiesClinicStaffReduceModel();
    }
    return kaigoRecuperationMedicalFacilitiesClinicStaffReduceModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getKaigoRecuperationMedicalFacilitiesClinicStaffNot(){
    if(kaigoRecuperationMedicalFacilitiesClinicStaffNot==null){

      kaigoRecuperationMedicalFacilitiesClinicStaffNot = new ACRadioButtonItem();

      kaigoRecuperationMedicalFacilitiesClinicStaffNot.setText("�Ȃ�");

      kaigoRecuperationMedicalFacilitiesClinicStaffNot.setGroup(getKaigoRecuperationMedicalFacilitiesClinicStaffReduce());

      addKaigoRecuperationMedicalFacilitiesClinicStaffNot();
    }
    return kaigoRecuperationMedicalFacilitiesClinicStaffNot;

  }

  /**
   * ������߂��擾���܂��B
   * @return �������
   */
  public ACRadioButtonItem getKaigoRecuperationMedicalFacilitiesClinicStaffExcess(){
    if(kaigoRecuperationMedicalFacilitiesClinicStaffExcess==null){

      kaigoRecuperationMedicalFacilitiesClinicStaffExcess = new ACRadioButtonItem();

      kaigoRecuperationMedicalFacilitiesClinicStaffExcess.setText("�������");

      kaigoRecuperationMedicalFacilitiesClinicStaffExcess.setGroup(getKaigoRecuperationMedicalFacilitiesClinicStaffReduce());

      addKaigoRecuperationMedicalFacilitiesClinicStaffExcess();
    }
    return kaigoRecuperationMedicalFacilitiesClinicStaffExcess;

  }

  /**
   * �H���z�E�R���e�i���擾���܂��B
   * @return �H���z�E�R���e�i
   */
  public ACLabelContainer getKaigoRecuperationMedicalFacilitiesDinnerStandeirdMoneyConteiner(){
    if(kaigoRecuperationMedicalFacilitiesDinnerStandeirdMoneyConteiner==null){

      kaigoRecuperationMedicalFacilitiesDinnerStandeirdMoneyConteiner = new ACLabelContainer();

      kaigoRecuperationMedicalFacilitiesDinnerStandeirdMoneyConteiner.setText("�H���z");

      kaigoRecuperationMedicalFacilitiesDinnerStandeirdMoneyConteiner.setFollowChildEnabled(true);

      addKaigoRecuperationMedicalFacilitiesDinnerStandeirdMoneyConteiner();
    }
    return kaigoRecuperationMedicalFacilitiesDinnerStandeirdMoneyConteiner;

  }

  /**
   * �H���z�E���v�E�e�L�X�g���擾���܂��B
   * @return �H���z�E���v�E�e�L�X�g
   */
  public ACTextField getKaigoRecuperationMedicalFacilitiesDinnerStandeirdMoneyTotal(){
    if(kaigoRecuperationMedicalFacilitiesDinnerStandeirdMoneyTotal==null){

      kaigoRecuperationMedicalFacilitiesDinnerStandeirdMoneyTotal = new ACTextField();

      kaigoRecuperationMedicalFacilitiesDinnerStandeirdMoneyTotal.setBindPath("1530209");

      kaigoRecuperationMedicalFacilitiesDinnerStandeirdMoneyTotal.setEditable(false);

      kaigoRecuperationMedicalFacilitiesDinnerStandeirdMoneyTotal.setColumns(4);

      kaigoRecuperationMedicalFacilitiesDinnerStandeirdMoneyTotal.setCharType(VRCharType.ONLY_DIGIT);

      kaigoRecuperationMedicalFacilitiesDinnerStandeirdMoneyTotal.setHorizontalAlignment(SwingConstants.RIGHT);

      kaigoRecuperationMedicalFacilitiesDinnerStandeirdMoneyTotal.setIMEMode(InputSubset.LATIN);

      kaigoRecuperationMedicalFacilitiesDinnerStandeirdMoneyTotal.setMaxLength(4);

      addKaigoRecuperationMedicalFacilitiesDinnerStandeirdMoneyTotal();
    }
    return kaigoRecuperationMedicalFacilitiesDinnerStandeirdMoneyTotal;

  }

  /**
   * �H���z�E���E���x�����擾���܂��B
   * @return �H���z�E���E���x��
   */
  public ACLabel getKaigoRecuperationMedicalFacilitiesMorningDinnerStandeirdMoneyLabel(){
    if(kaigoRecuperationMedicalFacilitiesMorningDinnerStandeirdMoneyLabel==null){

      kaigoRecuperationMedicalFacilitiesMorningDinnerStandeirdMoneyLabel = new ACLabel();

      kaigoRecuperationMedicalFacilitiesMorningDinnerStandeirdMoneyLabel.setText("�@��");

      addKaigoRecuperationMedicalFacilitiesMorningDinnerStandeirdMoneyLabel();
    }
    return kaigoRecuperationMedicalFacilitiesMorningDinnerStandeirdMoneyLabel;

  }

  /**
   * �H���z�E���E�e�L�X�g���擾���܂��B
   * @return �H���z�E���E�e�L�X�g
   */
  public ACTextField getKaigoRecuperationMedicalFacilitiesMorningDinnerStandeirdMoney(){
    if(kaigoRecuperationMedicalFacilitiesMorningDinnerStandeirdMoney==null){

      kaigoRecuperationMedicalFacilitiesMorningDinnerStandeirdMoney = new ACTextField();

      kaigoRecuperationMedicalFacilitiesMorningDinnerStandeirdMoney.setBindPath("1530210");

      kaigoRecuperationMedicalFacilitiesMorningDinnerStandeirdMoney.setColumns(3);

      kaigoRecuperationMedicalFacilitiesMorningDinnerStandeirdMoney.setCharType(VRCharType.ONLY_DIGIT);

      kaigoRecuperationMedicalFacilitiesMorningDinnerStandeirdMoney.setHorizontalAlignment(SwingConstants.RIGHT);

      kaigoRecuperationMedicalFacilitiesMorningDinnerStandeirdMoney.setIMEMode(InputSubset.LATIN);

      kaigoRecuperationMedicalFacilitiesMorningDinnerStandeirdMoney.setMaxLength(3);

      addKaigoRecuperationMedicalFacilitiesMorningDinnerStandeirdMoney();
    }
    return kaigoRecuperationMedicalFacilitiesMorningDinnerStandeirdMoney;

  }

  /**
   * �H���z�E���E���x�����擾���܂��B
   * @return �H���z�E���E���x��
   */
  public ACLabel getKaigoRecuperationMedicalFacilitiesNoonDinnerStandeirdMoneyLabel(){
    if(kaigoRecuperationMedicalFacilitiesNoonDinnerStandeirdMoneyLabel==null){

      kaigoRecuperationMedicalFacilitiesNoonDinnerStandeirdMoneyLabel = new ACLabel();

      kaigoRecuperationMedicalFacilitiesNoonDinnerStandeirdMoneyLabel.setText("��");

      addKaigoRecuperationMedicalFacilitiesNoonDinnerStandeirdMoneyLabel();
    }
    return kaigoRecuperationMedicalFacilitiesNoonDinnerStandeirdMoneyLabel;

  }

  /**
   * �H���z�E���E�e�L�X�g���擾���܂��B
   * @return �H���z�E���E�e�L�X�g
   */
  public ACTextField getKaigoRecuperationMedicalFacilitiesNoonDinnerStandeirdMoney(){
    if(kaigoRecuperationMedicalFacilitiesNoonDinnerStandeirdMoney==null){

      kaigoRecuperationMedicalFacilitiesNoonDinnerStandeirdMoney = new ACTextField();

      kaigoRecuperationMedicalFacilitiesNoonDinnerStandeirdMoney.setBindPath("1530211");

      kaigoRecuperationMedicalFacilitiesNoonDinnerStandeirdMoney.setColumns(3);

      kaigoRecuperationMedicalFacilitiesNoonDinnerStandeirdMoney.setCharType(VRCharType.ONLY_DIGIT);

      kaigoRecuperationMedicalFacilitiesNoonDinnerStandeirdMoney.setHorizontalAlignment(SwingConstants.RIGHT);

      kaigoRecuperationMedicalFacilitiesNoonDinnerStandeirdMoney.setIMEMode(InputSubset.LATIN);

      kaigoRecuperationMedicalFacilitiesNoonDinnerStandeirdMoney.setMaxLength(3);

      addKaigoRecuperationMedicalFacilitiesNoonDinnerStandeirdMoney();
    }
    return kaigoRecuperationMedicalFacilitiesNoonDinnerStandeirdMoney;

  }

  /**
   * �H���z�E��E���x�����擾���܂��B
   * @return �H���z�E��E���x��
   */
  public ACLabel getKaigoRecuperationMedicalFacilitiesNightDinnerStandeirdMoneyLabel(){
    if(kaigoRecuperationMedicalFacilitiesNightDinnerStandeirdMoneyLabel==null){

      kaigoRecuperationMedicalFacilitiesNightDinnerStandeirdMoneyLabel = new ACLabel();

      kaigoRecuperationMedicalFacilitiesNightDinnerStandeirdMoneyLabel.setText("��");

      addKaigoRecuperationMedicalFacilitiesNightDinnerStandeirdMoneyLabel();
    }
    return kaigoRecuperationMedicalFacilitiesNightDinnerStandeirdMoneyLabel;

  }

  /**
   * �H���z�E��E�e�L�X�g���擾���܂��B
   * @return �H���z�E��E�e�L�X�g
   */
  public ACTextField getKaigoRecuperationMedicalFacilitiesNightDinnerStandeirdMoney(){
    if(kaigoRecuperationMedicalFacilitiesNightDinnerStandeirdMoney==null){

      kaigoRecuperationMedicalFacilitiesNightDinnerStandeirdMoney = new ACTextField();

      kaigoRecuperationMedicalFacilitiesNightDinnerStandeirdMoney.setBindPath("1530212");

      kaigoRecuperationMedicalFacilitiesNightDinnerStandeirdMoney.setColumns(3);

      kaigoRecuperationMedicalFacilitiesNightDinnerStandeirdMoney.setCharType(VRCharType.ONLY_DIGIT);

      kaigoRecuperationMedicalFacilitiesNightDinnerStandeirdMoney.setHorizontalAlignment(SwingConstants.RIGHT);

      kaigoRecuperationMedicalFacilitiesNightDinnerStandeirdMoney.setIMEMode(InputSubset.LATIN);

      kaigoRecuperationMedicalFacilitiesNightDinnerStandeirdMoney.setMaxLength(3);

      addKaigoRecuperationMedicalFacilitiesNightDinnerStandeirdMoney();
    }
    return kaigoRecuperationMedicalFacilitiesNightDinnerStandeirdMoney;

  }

  /**
   * �H���z�E���x�����擾���܂��B
   * @return �H���z�E���x��
   */
  public ACLabel getKaigoRecuperationMedicalFacilitiesDinnerStandeirdMoney4Label(){
    if(kaigoRecuperationMedicalFacilitiesDinnerStandeirdMoney4Label==null){

      kaigoRecuperationMedicalFacilitiesDinnerStandeirdMoney4Label = new ACLabel();

      kaigoRecuperationMedicalFacilitiesDinnerStandeirdMoney4Label.setText("�i�~�j");

      addKaigoRecuperationMedicalFacilitiesDinnerStandeirdMoney4Label();
    }
    return kaigoRecuperationMedicalFacilitiesDinnerStandeirdMoney4Label;

  }

  /**
   * ���j�b�g�^����z�E�R���e�i���擾���܂��B
   * @return ���j�b�g�^����z�E�R���e�i
   */
  public ACLabelContainer getKaigoRecuperationMedicalFacilitiesClinicUnitRoomStandeirdMoneyConteiner(){
    if(kaigoRecuperationMedicalFacilitiesClinicUnitRoomStandeirdMoneyConteiner==null){

      kaigoRecuperationMedicalFacilitiesClinicUnitRoomStandeirdMoneyConteiner = new ACLabelContainer();

      kaigoRecuperationMedicalFacilitiesClinicUnitRoomStandeirdMoneyConteiner.setText("���j�b�g�^����z");

      kaigoRecuperationMedicalFacilitiesClinicUnitRoomStandeirdMoneyConteiner.setFollowChildEnabled(true);

      addKaigoRecuperationMedicalFacilitiesClinicUnitRoomStandeirdMoneyConteiner();
    }
    return kaigoRecuperationMedicalFacilitiesClinicUnitRoomStandeirdMoneyConteiner;

  }

  /**
   * ���j�b�g�^����z�E�e�L�X�g���擾���܂��B
   * @return ���j�b�g�^����z�E�e�L�X�g
   */
  public ACTextField getKaigoRecuperationMedicalFacilitiesClinicUnitRoomStandeirdMoneyText(){
    if(kaigoRecuperationMedicalFacilitiesClinicUnitRoomStandeirdMoneyText==null){

      kaigoRecuperationMedicalFacilitiesClinicUnitRoomStandeirdMoneyText = new ACTextField();

      kaigoRecuperationMedicalFacilitiesClinicUnitRoomStandeirdMoneyText.setBindPath("1530213");

      kaigoRecuperationMedicalFacilitiesClinicUnitRoomStandeirdMoneyText.setColumns(4);

      kaigoRecuperationMedicalFacilitiesClinicUnitRoomStandeirdMoneyText.setCharType(VRCharType.ONLY_DIGIT);

      kaigoRecuperationMedicalFacilitiesClinicUnitRoomStandeirdMoneyText.setHorizontalAlignment(SwingConstants.RIGHT);

      kaigoRecuperationMedicalFacilitiesClinicUnitRoomStandeirdMoneyText.setIMEMode(InputSubset.LATIN);

      kaigoRecuperationMedicalFacilitiesClinicUnitRoomStandeirdMoneyText.setMaxLength(4);

      addKaigoRecuperationMedicalFacilitiesClinicUnitRoomStandeirdMoneyText();
    }
    return kaigoRecuperationMedicalFacilitiesClinicUnitRoomStandeirdMoneyText;

  }

  /**
   * ���j�b�g�^����z�E���x�����擾���܂��B
   * @return ���j�b�g�^����z�E���x��
   */
  public ACLabel getKaigoRecuperationMedicalFacilitiesClinicUnitRoomStandeirdMoneyLabel(){
    if(kaigoRecuperationMedicalFacilitiesClinicUnitRoomStandeirdMoneyLabel==null){

      kaigoRecuperationMedicalFacilitiesClinicUnitRoomStandeirdMoneyLabel = new ACLabel();

      kaigoRecuperationMedicalFacilitiesClinicUnitRoomStandeirdMoneyLabel.setText("�i�~�j");

      addKaigoRecuperationMedicalFacilitiesClinicUnitRoomStandeirdMoneyLabel();
    }
    return kaigoRecuperationMedicalFacilitiesClinicUnitRoomStandeirdMoneyLabel;

  }

  /**
   * ���j�b�g�^������z�E�R���e�i���擾���܂��B
   * @return ���j�b�g�^������z�E�R���e�i
   */
  public ACLabelContainer getKaigoRecuperationMedicalFacilitiesClinicUnitSemiRoomStandeirdMoneyConteiner(){
    if(kaigoRecuperationMedicalFacilitiesClinicUnitSemiRoomStandeirdMoneyConteiner==null){

      kaigoRecuperationMedicalFacilitiesClinicUnitSemiRoomStandeirdMoneyConteiner = new ACLabelContainer();

      kaigoRecuperationMedicalFacilitiesClinicUnitSemiRoomStandeirdMoneyConteiner.setText("���j�b�g�^������z");

      kaigoRecuperationMedicalFacilitiesClinicUnitSemiRoomStandeirdMoneyConteiner.setFollowChildEnabled(true);

      addKaigoRecuperationMedicalFacilitiesClinicUnitSemiRoomStandeirdMoneyConteiner();
    }
    return kaigoRecuperationMedicalFacilitiesClinicUnitSemiRoomStandeirdMoneyConteiner;

  }

  /**
   * ���j�b�g�^������z�E�e�L�X�g���擾���܂��B
   * @return ���j�b�g�^������z�E�e�L�X�g
   */
  public ACTextField getKaigoRecuperationMedicalFacilitiesClinicUnitSemiRoomStandeirdMoneyText(){
    if(kaigoRecuperationMedicalFacilitiesClinicUnitSemiRoomStandeirdMoneyText==null){

      kaigoRecuperationMedicalFacilitiesClinicUnitSemiRoomStandeirdMoneyText = new ACTextField();

      kaigoRecuperationMedicalFacilitiesClinicUnitSemiRoomStandeirdMoneyText.setBindPath("1530214");

      kaigoRecuperationMedicalFacilitiesClinicUnitSemiRoomStandeirdMoneyText.setColumns(4);

      kaigoRecuperationMedicalFacilitiesClinicUnitSemiRoomStandeirdMoneyText.setCharType(VRCharType.ONLY_DIGIT);

      kaigoRecuperationMedicalFacilitiesClinicUnitSemiRoomStandeirdMoneyText.setHorizontalAlignment(SwingConstants.RIGHT);

      kaigoRecuperationMedicalFacilitiesClinicUnitSemiRoomStandeirdMoneyText.setIMEMode(InputSubset.LATIN);

      kaigoRecuperationMedicalFacilitiesClinicUnitSemiRoomStandeirdMoneyText.setMaxLength(4);

      addKaigoRecuperationMedicalFacilitiesClinicUnitSemiRoomStandeirdMoneyText();
    }
    return kaigoRecuperationMedicalFacilitiesClinicUnitSemiRoomStandeirdMoneyText;

  }

  /**
   * ���j�b�g�^������z�E���x�����擾���܂��B
   * @return ���j�b�g�^������z�E���x��
   */
  public ACLabel getKaigoRecuperationMedicalFacilitiesClinicUnitSemiRoomStandeirdMoneyLabel(){
    if(kaigoRecuperationMedicalFacilitiesClinicUnitSemiRoomStandeirdMoneyLabel==null){

      kaigoRecuperationMedicalFacilitiesClinicUnitSemiRoomStandeirdMoneyLabel = new ACLabel();

      kaigoRecuperationMedicalFacilitiesClinicUnitSemiRoomStandeirdMoneyLabel.setText("�i�~�j");

      addKaigoRecuperationMedicalFacilitiesClinicUnitSemiRoomStandeirdMoneyLabel();
    }
    return kaigoRecuperationMedicalFacilitiesClinicUnitSemiRoomStandeirdMoneyLabel;

  }

  /**
   * �]���^����z�E�R���e�i���擾���܂��B
   * @return �]���^����z�E�R���e�i
   */
  public ACLabelContainer getKaigoRecuperationMedicalFacilitiesClinicNormalRoomStandeirdMoneyConteiner(){
    if(kaigoRecuperationMedicalFacilitiesClinicNormalRoomStandeirdMoneyConteiner==null){

      kaigoRecuperationMedicalFacilitiesClinicNormalRoomStandeirdMoneyConteiner = new ACLabelContainer();

      kaigoRecuperationMedicalFacilitiesClinicNormalRoomStandeirdMoneyConteiner.setText("�@�@�]���^����z");

      kaigoRecuperationMedicalFacilitiesClinicNormalRoomStandeirdMoneyConteiner.setFollowChildEnabled(true);

      addKaigoRecuperationMedicalFacilitiesClinicNormalRoomStandeirdMoneyConteiner();
    }
    return kaigoRecuperationMedicalFacilitiesClinicNormalRoomStandeirdMoneyConteiner;

  }

  /**
   * �]���^����z�E�e�L�X�g���擾���܂��B
   * @return �]���^����z�E�e�L�X�g
   */
  public ACTextField getKaigoRecuperationMedicalFacilitiesClinicNormalRoomStandeirdMoneyText(){
    if(kaigoRecuperationMedicalFacilitiesClinicNormalRoomStandeirdMoneyText==null){

      kaigoRecuperationMedicalFacilitiesClinicNormalRoomStandeirdMoneyText = new ACTextField();

      kaigoRecuperationMedicalFacilitiesClinicNormalRoomStandeirdMoneyText.setBindPath("1530215");

      kaigoRecuperationMedicalFacilitiesClinicNormalRoomStandeirdMoneyText.setColumns(4);

      kaigoRecuperationMedicalFacilitiesClinicNormalRoomStandeirdMoneyText.setCharType(VRCharType.ONLY_DIGIT);

      kaigoRecuperationMedicalFacilitiesClinicNormalRoomStandeirdMoneyText.setHorizontalAlignment(SwingConstants.RIGHT);

      kaigoRecuperationMedicalFacilitiesClinicNormalRoomStandeirdMoneyText.setIMEMode(InputSubset.LATIN);

      kaigoRecuperationMedicalFacilitiesClinicNormalRoomStandeirdMoneyText.setMaxLength(4);

      addKaigoRecuperationMedicalFacilitiesClinicNormalRoomStandeirdMoneyText();
    }
    return kaigoRecuperationMedicalFacilitiesClinicNormalRoomStandeirdMoneyText;

  }

  /**
   * �]���^����z�E���x�����擾���܂��B
   * @return �]���^����z�E���x��
   */
  public ACLabel getKaigoRecuperationMedicalFacilitiesClinicNormalRoomStandeirdMoneyLabel(){
    if(kaigoRecuperationMedicalFacilitiesClinicNormalRoomStandeirdMoneyLabel==null){

      kaigoRecuperationMedicalFacilitiesClinicNormalRoomStandeirdMoneyLabel = new ACLabel();

      kaigoRecuperationMedicalFacilitiesClinicNormalRoomStandeirdMoneyLabel.setText("�i�~�j");

      addKaigoRecuperationMedicalFacilitiesClinicNormalRoomStandeirdMoneyLabel();
    }
    return kaigoRecuperationMedicalFacilitiesClinicNormalRoomStandeirdMoneyLabel;

  }

  /**
   * ��������z�E�R���e�i���擾���܂��B
   * @return ��������z�E�R���e�i
   */
  public ACLabelContainer getKaigoRecuperationMedicalFacilitiesClinicTasyouRoomConteiner(){
    if(kaigoRecuperationMedicalFacilitiesClinicTasyouRoomConteiner==null){

      kaigoRecuperationMedicalFacilitiesClinicTasyouRoomConteiner = new ACLabelContainer();

      kaigoRecuperationMedicalFacilitiesClinicTasyouRoomConteiner.setText("�@�@��������z");

      kaigoRecuperationMedicalFacilitiesClinicTasyouRoomConteiner.setFollowChildEnabled(true);

      addKaigoRecuperationMedicalFacilitiesClinicTasyouRoomConteiner();
    }
    return kaigoRecuperationMedicalFacilitiesClinicTasyouRoomConteiner;

  }

  /**
   * ��������z�E�e�L�X�g���擾���܂��B
   * @return ��������z�E�e�L�X�g
   */
  public ACTextField getKaigoRecuperationMedicalFacilitiesClinicTasyouRoomText(){
    if(kaigoRecuperationMedicalFacilitiesClinicTasyouRoomText==null){

      kaigoRecuperationMedicalFacilitiesClinicTasyouRoomText = new ACTextField();

      kaigoRecuperationMedicalFacilitiesClinicTasyouRoomText.setBindPath("1530216");

      kaigoRecuperationMedicalFacilitiesClinicTasyouRoomText.setColumns(4);

      kaigoRecuperationMedicalFacilitiesClinicTasyouRoomText.setCharType(VRCharType.ONLY_DIGIT);

      kaigoRecuperationMedicalFacilitiesClinicTasyouRoomText.setHorizontalAlignment(SwingConstants.RIGHT);

      kaigoRecuperationMedicalFacilitiesClinicTasyouRoomText.setIMEMode(InputSubset.LATIN);

      kaigoRecuperationMedicalFacilitiesClinicTasyouRoomText.setMaxLength(4);

      addKaigoRecuperationMedicalFacilitiesClinicTasyouRoomText();
    }
    return kaigoRecuperationMedicalFacilitiesClinicTasyouRoomText;

  }

  /**
   * ��������z�E���x�����擾���܂��B
   * @return ��������z�E���x��
   */
  public ACLabel getKaigoRecuperationMedicalFacilitiesClinicTasyouRoomLabel(){
    if(kaigoRecuperationMedicalFacilitiesClinicTasyouRoomLabel==null){

      kaigoRecuperationMedicalFacilitiesClinicTasyouRoomLabel = new ACLabel();

      kaigoRecuperationMedicalFacilitiesClinicTasyouRoomLabel.setText("�i�~�j");

      addKaigoRecuperationMedicalFacilitiesClinicTasyouRoomLabel();
    }
    return kaigoRecuperationMedicalFacilitiesClinicTasyouRoomLabel;

  }

  /**
   * �R���X�g���N�^�ł��B
   */
  public QO004019Design() {

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

    this.add(getKaigoRecuperationMedicalFacilitiesClinicGroup(), VRLayout.CLIENT);

  }

  /**
   * ���ƃO���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoRecuperationMedicalFacilitiesClinicGroup(){

    kaigoRecuperationMedicalFacilitiesClinicGroup.add(getKaigoRecuperationMedicalFacilitiesClinicDiscountContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    kaigoRecuperationMedicalFacilitiesClinicGroup.add(getKaigoRecuperationMedicalFacilitiesClinicInstitutionDivisionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    kaigoRecuperationMedicalFacilitiesClinicGroup.add(getKaigoRecuperationMedicalFacilitiesClinicStaffAssignmentDivisionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    kaigoRecuperationMedicalFacilitiesClinicGroup.add(getKaigoRecuperationMedicalFacilitiesClinicRecuperationEnvironmentalContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    kaigoRecuperationMedicalFacilitiesClinicGroup.add(getKaigoRecuperationMedicalFacilitiesClinicNutritionManageRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    kaigoRecuperationMedicalFacilitiesClinicGroup.add(getKaigoRecuperationMedicalFacilitiesClinicNutritionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    kaigoRecuperationMedicalFacilitiesClinicGroup.add(getKaigoRecuperationMedicalFacilitiesClinicOralSwitchRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    kaigoRecuperationMedicalFacilitiesClinicGroup.add(getKaigoRecuperationMedicalFacilitiesClinicRecuperateDinnerRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    kaigoRecuperationMedicalFacilitiesClinicGroup.add(getKaigoRecuperationMedicalFacilitiesClinicStaffReduceContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    kaigoRecuperationMedicalFacilitiesClinicGroup.add(getKaigoRecuperationMedicalFacilitiesDinnerStandeirdMoneyConteiner(), VRLayout.FLOW_INSETLINE_RETURN);

    kaigoRecuperationMedicalFacilitiesClinicGroup.add(getKaigoRecuperationMedicalFacilitiesClinicUnitRoomStandeirdMoneyConteiner(), VRLayout.FLOW_INSETLINE_RETURN);

    kaigoRecuperationMedicalFacilitiesClinicGroup.add(getKaigoRecuperationMedicalFacilitiesClinicUnitSemiRoomStandeirdMoneyConteiner(), VRLayout.FLOW_INSETLINE_RETURN);

    kaigoRecuperationMedicalFacilitiesClinicGroup.add(getKaigoRecuperationMedicalFacilitiesClinicNormalRoomStandeirdMoneyConteiner(), VRLayout.FLOW_INSETLINE_RETURN);

    kaigoRecuperationMedicalFacilitiesClinicGroup.add(getKaigoRecuperationMedicalFacilitiesClinicTasyouRoomConteiner(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * �������R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoRecuperationMedicalFacilitiesClinicDiscountContainer(){

    kaigoRecuperationMedicalFacilitiesClinicDiscountContainer.add(getKaigoRecuperationMedicalFacilitiesClinicDiscountRate(), VRLayout.FLOW);

    kaigoRecuperationMedicalFacilitiesClinicDiscountContainer.add(getKaigoRecuperationMedicalFacilitiesClinicPercentSign(), VRLayout.FLOW);

  }

  /**
   * �������ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoRecuperationMedicalFacilitiesClinicDiscountRate(){

  }

  /**
   * �����x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoRecuperationMedicalFacilitiesClinicPercentSign(){

  }

  /**
   * �{�݋敪���W�I�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoRecuperationMedicalFacilitiesClinicInstitutionDivisionRadio(){

  }

  /**
   * �{�݋敪���W�I�O���[�v���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoRecuperationMedicalFacilitiesClinicInstitutionDivisionRadioModel(){

    getKaigoRecuperationMedicalFacilitiesClinicInstitutionDivisionRadioItem1().setButtonIndex(1);
    getKaigoRecuperationMedicalFacilitiesClinicInstitutionDivisionRadioModel().add(getKaigoRecuperationMedicalFacilitiesClinicInstitutionDivisionRadioItem1());

    getKaigoRecuperationMedicalFacilitiesClinicInstitutionDivisionRadioItem2().setButtonIndex(2);
    getKaigoRecuperationMedicalFacilitiesClinicInstitutionDivisionRadioModel().add(getKaigoRecuperationMedicalFacilitiesClinicInstitutionDivisionRadioItem2());

  }

  /**
   * �f�Ï��ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoRecuperationMedicalFacilitiesClinicInstitutionDivisionRadioItem1(){

  }

  /**
   * ���j�b�g�^�f�Ï��ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoRecuperationMedicalFacilitiesClinicInstitutionDivisionRadioItem2(){

  }

  /**
   * �l���z�u�敪���W�I�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoRecuperationMedicalFacilitiesClinicStaffAssignmentDivision(){

  }

  /**
   * �l���z�u�敪���W�I�O���[�v���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoRecuperationMedicalFacilitiesClinicStaffAssignmentDivisionModel(){

    getKaigoRecuperationMedicalFacilitiesClinicStaffAssignmentDivision1().setButtonIndex(1);
    getKaigoRecuperationMedicalFacilitiesClinicStaffAssignmentDivisionModel().add(getKaigoRecuperationMedicalFacilitiesClinicStaffAssignmentDivision1());

    getKaigoRecuperationMedicalFacilitiesClinicStaffAssignmentDivision2().setButtonIndex(2);
    getKaigoRecuperationMedicalFacilitiesClinicStaffAssignmentDivisionModel().add(getKaigoRecuperationMedicalFacilitiesClinicStaffAssignmentDivision2());

  }

  /**
   * I�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoRecuperationMedicalFacilitiesClinicStaffAssignmentDivision1(){

  }

  /**
   * II�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoRecuperationMedicalFacilitiesClinicStaffAssignmentDivision2(){

  }

  /**
   * �×{������W�I�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoRecuperationMedicalFacilitiesClinicRecuperationEnvironmental(){

  }

  /**
   * �×{������W�I�O���[�v���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoRecuperationMedicalFacilitiesClinicRecuperationEnvironmentalModel(){

    getKaigoRecuperationMedicalFacilitiesClinicRecuperationEnvironmentalStandard().setButtonIndex(1);
    getKaigoRecuperationMedicalFacilitiesClinicRecuperationEnvironmentalModel().add(getKaigoRecuperationMedicalFacilitiesClinicRecuperationEnvironmentalStandard());

    getKaigoRecuperationMedicalFacilitiesClinicRecuperationEnvironmentalSubtraction1().setButtonIndex(2);
    getKaigoRecuperationMedicalFacilitiesClinicRecuperationEnvironmentalModel().add(getKaigoRecuperationMedicalFacilitiesClinicRecuperationEnvironmentalSubtraction1());

    getKaigoRecuperationMedicalFacilitiesClinicRecuperationEnvironmentalSubtraction2().setButtonIndex(3);
    getKaigoRecuperationMedicalFacilitiesClinicRecuperationEnvironmentalModel().add(getKaigoRecuperationMedicalFacilitiesClinicRecuperationEnvironmentalSubtraction2());

  }

  /**
   * ��^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoRecuperationMedicalFacilitiesClinicRecuperationEnvironmentalStandard(){

  }

  /**
   * ���Z�^I�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoRecuperationMedicalFacilitiesClinicRecuperationEnvironmentalSubtraction1(){

  }

  /**
   * ���Z�^II�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoRecuperationMedicalFacilitiesClinicRecuperationEnvironmentalSubtraction2(){

  }

  /**
   * �h�{�Ǘ��̐����W�I�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoRecuperationMedicalFacilitiesClinicNutritionManageRadio(){

  }

  /**
   * �h�{�Ǘ��̐����W�I�O���[�v���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoRecuperationMedicalFacilitiesClinicNutritionManageRadioModel(){

    getKaigoRecuperationMedicalFacilitiesClinicNutritionManageRadioItem1().setButtonIndex(1);
    getKaigoRecuperationMedicalFacilitiesClinicNutritionManageRadioModel().add(getKaigoRecuperationMedicalFacilitiesClinicNutritionManageRadioItem1());

    getKaigoRecuperationMedicalFacilitiesClinicNutritionManageRadioItem2().setButtonIndex(2);
    getKaigoRecuperationMedicalFacilitiesClinicNutritionManageRadioModel().add(getKaigoRecuperationMedicalFacilitiesClinicNutritionManageRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoRecuperationMedicalFacilitiesClinicNutritionManageRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoRecuperationMedicalFacilitiesClinicNutritionManageRadioItem2(){

  }

  /**
   * �h�{�}�l�W�����g�̐����W�I�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoRecuperationMedicalFacilitiesClinicNutritionRadio(){

  }

  /**
   * �h�{�}�l�W�����g�̐����W�I�O���[�v���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoRecuperationMedicalFacilitiesClinicNutritionRadioModel(){

    getKaigoRecuperationMedicalFacilitiesClinicNutritionRadioItem1().setButtonIndex(1);
    getKaigoRecuperationMedicalFacilitiesClinicNutritionRadioModel().add(getKaigoRecuperationMedicalFacilitiesClinicNutritionRadioItem1());

    getKaigoRecuperationMedicalFacilitiesClinicNutritionRadioItem2 ().setButtonIndex(2);
    getKaigoRecuperationMedicalFacilitiesClinicNutritionRadioModel().add(getKaigoRecuperationMedicalFacilitiesClinicNutritionRadioItem2 ());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoRecuperationMedicalFacilitiesClinicNutritionRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoRecuperationMedicalFacilitiesClinicNutritionRadioItem2 (){

  }

  /**
   * �o���ڍs�̐����W�I�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoRecuperationMedicalFacilitiesClinicOralSwitchRadio(){

  }

  /**
   * �o���ڍs�̐����W�I�O���[�v���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoRecuperationMedicalFacilitiesClinicOralSwitchRadioModel(){

    getKaigoRecuperationMedicalFacilitiesClinicOralSwitchRadioItem1().setButtonIndex(1);
    getKaigoRecuperationMedicalFacilitiesClinicOralSwitchRadioModel().add(getKaigoRecuperationMedicalFacilitiesClinicOralSwitchRadioItem1());

    getKaigoRecuperationMedicalFacilitiesClinicOralSwitchRadioItem2 ().setButtonIndex(2);
    getKaigoRecuperationMedicalFacilitiesClinicOralSwitchRadioModel().add(getKaigoRecuperationMedicalFacilitiesClinicOralSwitchRadioItem2 ());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoRecuperationMedicalFacilitiesClinicOralSwitchRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoRecuperationMedicalFacilitiesClinicOralSwitchRadioItem2 (){

  }

  /**
   * �×{�H�̐����W�I�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoRecuperationMedicalFacilitiesClinicRecuperateDinnerRadio(){

  }

  /**
   * �×{�H�̐����W�I�O���[�v���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoRecuperationMedicalFacilitiesClinicRecuperateDinnerRadioModel(){

    getKaigoRecuperationMedicalFacilitiesClinicRecuperateDinnerRadioItem1().setButtonIndex(1);
    getKaigoRecuperationMedicalFacilitiesClinicRecuperateDinnerRadioModel().add(getKaigoRecuperationMedicalFacilitiesClinicRecuperateDinnerRadioItem1());

    getKaigoRecuperationMedicalFacilitiesClinicRecuperateDinnerRadioItem2().setButtonIndex(2);
    getKaigoRecuperationMedicalFacilitiesClinicRecuperateDinnerRadioModel().add(getKaigoRecuperationMedicalFacilitiesClinicRecuperateDinnerRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoRecuperationMedicalFacilitiesClinicRecuperateDinnerRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoRecuperationMedicalFacilitiesClinicRecuperateDinnerRadioItem2(){

  }

  /**
   * �l�����Z���W�I�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoRecuperationMedicalFacilitiesClinicStaffReduce(){

  }

  /**
   * �l�����Z���W�I�O���[�v���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoRecuperationMedicalFacilitiesClinicStaffReduceModel(){

    getKaigoRecuperationMedicalFacilitiesClinicStaffNot().setButtonIndex(1);
    getKaigoRecuperationMedicalFacilitiesClinicStaffReduceModel().add(getKaigoRecuperationMedicalFacilitiesClinicStaffNot());

    getKaigoRecuperationMedicalFacilitiesClinicStaffExcess().setButtonIndex(2);
    getKaigoRecuperationMedicalFacilitiesClinicStaffReduceModel().add(getKaigoRecuperationMedicalFacilitiesClinicStaffExcess());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoRecuperationMedicalFacilitiesClinicStaffNot(){

  }

  /**
   * ������߂ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoRecuperationMedicalFacilitiesClinicStaffExcess(){

  }

  /**
   * �H���z�E�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoRecuperationMedicalFacilitiesDinnerStandeirdMoneyConteiner(){

    kaigoRecuperationMedicalFacilitiesDinnerStandeirdMoneyConteiner.add(getKaigoRecuperationMedicalFacilitiesDinnerStandeirdMoneyTotal(), VRLayout.FLOW);

    kaigoRecuperationMedicalFacilitiesDinnerStandeirdMoneyConteiner.add(getKaigoRecuperationMedicalFacilitiesMorningDinnerStandeirdMoneyLabel(), VRLayout.FLOW);

    kaigoRecuperationMedicalFacilitiesDinnerStandeirdMoneyConteiner.add(getKaigoRecuperationMedicalFacilitiesMorningDinnerStandeirdMoney(), VRLayout.FLOW);

    kaigoRecuperationMedicalFacilitiesDinnerStandeirdMoneyConteiner.add(getKaigoRecuperationMedicalFacilitiesNoonDinnerStandeirdMoneyLabel(), VRLayout.FLOW);

    kaigoRecuperationMedicalFacilitiesDinnerStandeirdMoneyConteiner.add(getKaigoRecuperationMedicalFacilitiesNoonDinnerStandeirdMoney(), VRLayout.FLOW);

    kaigoRecuperationMedicalFacilitiesDinnerStandeirdMoneyConteiner.add(getKaigoRecuperationMedicalFacilitiesNightDinnerStandeirdMoneyLabel(), VRLayout.FLOW);

    kaigoRecuperationMedicalFacilitiesDinnerStandeirdMoneyConteiner.add(getKaigoRecuperationMedicalFacilitiesNightDinnerStandeirdMoney(), VRLayout.FLOW);

    kaigoRecuperationMedicalFacilitiesDinnerStandeirdMoneyConteiner.add(getKaigoRecuperationMedicalFacilitiesDinnerStandeirdMoney4Label(), VRLayout.FLOW);

  }

  /**
   * �H���z�E���v�E�e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoRecuperationMedicalFacilitiesDinnerStandeirdMoneyTotal(){

  }

  /**
   * �H���z�E���E���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoRecuperationMedicalFacilitiesMorningDinnerStandeirdMoneyLabel(){

  }

  /**
   * �H���z�E���E�e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoRecuperationMedicalFacilitiesMorningDinnerStandeirdMoney(){

  }

  /**
   * �H���z�E���E���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoRecuperationMedicalFacilitiesNoonDinnerStandeirdMoneyLabel(){

  }

  /**
   * �H���z�E���E�e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoRecuperationMedicalFacilitiesNoonDinnerStandeirdMoney(){

  }

  /**
   * �H���z�E��E���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoRecuperationMedicalFacilitiesNightDinnerStandeirdMoneyLabel(){

  }

  /**
   * �H���z�E��E�e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoRecuperationMedicalFacilitiesNightDinnerStandeirdMoney(){

  }

  /**
   * �H���z�E���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoRecuperationMedicalFacilitiesDinnerStandeirdMoney4Label(){

  }

  /**
   * ���j�b�g�^����z�E�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoRecuperationMedicalFacilitiesClinicUnitRoomStandeirdMoneyConteiner(){

    kaigoRecuperationMedicalFacilitiesClinicUnitRoomStandeirdMoneyConteiner.add(getKaigoRecuperationMedicalFacilitiesClinicUnitRoomStandeirdMoneyText(), null);

    kaigoRecuperationMedicalFacilitiesClinicUnitRoomStandeirdMoneyConteiner.add(getKaigoRecuperationMedicalFacilitiesClinicUnitRoomStandeirdMoneyLabel(), null);

  }

  /**
   * ���j�b�g�^����z�E�e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoRecuperationMedicalFacilitiesClinicUnitRoomStandeirdMoneyText(){

  }

  /**
   * ���j�b�g�^����z�E���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoRecuperationMedicalFacilitiesClinicUnitRoomStandeirdMoneyLabel(){

  }

  /**
   * ���j�b�g�^������z�E�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoRecuperationMedicalFacilitiesClinicUnitSemiRoomStandeirdMoneyConteiner(){

    kaigoRecuperationMedicalFacilitiesClinicUnitSemiRoomStandeirdMoneyConteiner.add(getKaigoRecuperationMedicalFacilitiesClinicUnitSemiRoomStandeirdMoneyText(), null);

    kaigoRecuperationMedicalFacilitiesClinicUnitSemiRoomStandeirdMoneyConteiner.add(getKaigoRecuperationMedicalFacilitiesClinicUnitSemiRoomStandeirdMoneyLabel(), null);

  }

  /**
   * ���j�b�g�^������z�E�e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoRecuperationMedicalFacilitiesClinicUnitSemiRoomStandeirdMoneyText(){

  }

  /**
   * ���j�b�g�^������z�E���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoRecuperationMedicalFacilitiesClinicUnitSemiRoomStandeirdMoneyLabel(){

  }

  /**
   * �]���^����z�E�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoRecuperationMedicalFacilitiesClinicNormalRoomStandeirdMoneyConteiner(){

    kaigoRecuperationMedicalFacilitiesClinicNormalRoomStandeirdMoneyConteiner.add(getKaigoRecuperationMedicalFacilitiesClinicNormalRoomStandeirdMoneyText(), null);

    kaigoRecuperationMedicalFacilitiesClinicNormalRoomStandeirdMoneyConteiner.add(getKaigoRecuperationMedicalFacilitiesClinicNormalRoomStandeirdMoneyLabel(), null);

  }

  /**
   * �]���^����z�E�e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoRecuperationMedicalFacilitiesClinicNormalRoomStandeirdMoneyText(){

  }

  /**
   * �]���^����z�E���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoRecuperationMedicalFacilitiesClinicNormalRoomStandeirdMoneyLabel(){

  }

  /**
   * ��������z�E�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoRecuperationMedicalFacilitiesClinicTasyouRoomConteiner(){

    kaigoRecuperationMedicalFacilitiesClinicTasyouRoomConteiner.add(getKaigoRecuperationMedicalFacilitiesClinicTasyouRoomText(), null);

    kaigoRecuperationMedicalFacilitiesClinicTasyouRoomConteiner.add(getKaigoRecuperationMedicalFacilitiesClinicTasyouRoomLabel(), null);

  }

  /**
   * ��������z�E�e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoRecuperationMedicalFacilitiesClinicTasyouRoomText(){

  }

  /**
   * ��������z�E���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoRecuperationMedicalFacilitiesClinicTasyouRoomLabel(){

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
      ACFrame.getInstance().getContentPane().add(new QO004019Design());
      ACFrame.getInstance().setVisible(true);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QO004019Design getThis() {
    return this;
  }
}
