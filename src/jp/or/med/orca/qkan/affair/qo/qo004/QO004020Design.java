
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
 * �v���O���� ���Ǝғo�^(���×{�^��Î{�݁i�F�m�ǎ����^�j) (QO004020)
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
 * ���Ǝғo�^(���×{�^��Î{�݁i�F�m�ǎ����^�j)��ʍ��ڃf�U�C��(QO004020) 
 */
public class QO004020Design extends ACPanel {
  //GUI�R���|�[�l���g

  private ACGroupBox kaigoRecuperationMedicalFacilitiesGroup;

  private ACLabelContainer kaigoRecuperationMedicalFacilitiesDiscountcontainer;

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

  private ACComboBox staffLack;

  private ACLabelContainer staffLackContainer;

  private ACComboBoxModelAdapter staffLackModel;

  private ACLabelContainer kaigoRecuperationMedicalFacilitiesDinnerStandeirdMoneyConteiner;

  private ACTextField kaigoRecuperationMedicalFacilitiesDinnerStandeirdMoneyTotal;

  private ACLabel kaigoRecuperationMedicalFacilitiesMorningDinnerStandeirdMoneyLabel;

  private ACTextField kaigoRecuperationMedicalFacilitiesMorningDinnerStandeirdMoney;

  private ACLabel kaigoRecuperationMedicalFacilitiesNoonDinnerStandeirdMoneyLabel;

  private ACTextField kaigoRecuperationMedicalFacilitiesNoonDinnerStandeirdMoney;

  private ACLabel kaigoRecuperationMedicalFacilitiesNightDinnerStandeirdMoneyLabel;

  private ACTextField kaigoRecuperationMedicalFacilitiesNightDinnerStandeirdMoney;

  private ACLabel kaigoRecuperationMedicalFacilitiesDinnerStandeirdMoneyDenomination;

  private ACLabelContainer kaigoRecuperationMedicalFacilitiesCognitiveUnitRoomStandeirdMoneyConteiner;

  private ACTextField kaigoRecuperationMedicalFacilitiesCognitiveUnitRoomStandeirdMoneyText;

  private ACLabel kaigoRecuperationMedicalFacilitiesCognitiveUnitRoomStandeirdMoneyLabel;

  private ACLabelContainer kaigoRecuperationMedicalFacilitiesCognitiveUnitSemiRoomStandeirdMoneyConteiner;

  private ACTextField kaigoRecuperationMedicalFacilitiesCognitiveUnitSemiRoomStandeirdMoneyText;

  private ACLabel kaigoRecuperationMedicalFacilitiesCognitiveUnitSemiRoomStandeirdMoneyLabel;

  private ACLabelContainer kaigoRecuperationMedicalFacilitiesCognitiveNormalRoomStandeirdMoneyConteiner;

  private ACTextField kaigoRecuperationMedicalFacilitiesCognitiveNormalRoomStandeirdMoneyText;

  private ACLabel kaigoRecuperationMedicalFacilitiesCognitiveNormalRoomStandeirdMoneyLabel;

  private ACLabelContainer kaigoRecuperationMedicalFacilitiesCognitiveTasyouRoomConteiner;

  private ACTextField kaigoRecuperationMedicalFacilitiesCognitiveTasyouRoomText;

  private ACLabel kaigoRecuperationMedicalFacilitiesCognitiveTasyouRoomLabel;

  //getter

  /**
   * ���ƃO���[�v���擾���܂��B
   * @return ���ƃO���[�v
   */
  public ACGroupBox getKaigoRecuperationMedicalFacilitiesGroup(){
    if(kaigoRecuperationMedicalFacilitiesGroup==null){

      kaigoRecuperationMedicalFacilitiesGroup = new ACGroupBox();

      kaigoRecuperationMedicalFacilitiesGroup.setText("���×{�^��Î{�݁i�F�m�ǎ����^�j");

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
  public ACLabelContainer getKaigoRecuperationMedicalFacilitiesDiscountcontainer(){
    if(kaigoRecuperationMedicalFacilitiesDiscountcontainer==null){

      kaigoRecuperationMedicalFacilitiesDiscountcontainer = new ACLabelContainer();

      kaigoRecuperationMedicalFacilitiesDiscountcontainer.setText("������");

      kaigoRecuperationMedicalFacilitiesDiscountcontainer.setFollowChildEnabled(true);

      addKaigoRecuperationMedicalFacilitiesDiscountcontainer();
    }
    return kaigoRecuperationMedicalFacilitiesDiscountcontainer;

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

      InstitutionDivisionRadio.setBindPath("1530301");

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
   * �F�m�ǎ����^���擾���܂��B
   * @return �F�m�ǎ����^
   */
  public ACRadioButtonItem getInstitutionDivisionRadioItem1(){
    if(InstitutionDivisionRadioItem1==null){

      InstitutionDivisionRadioItem1 = new ACRadioButtonItem();

      InstitutionDivisionRadioItem1.setText("�F�m�ǎ����^");

      InstitutionDivisionRadioItem1.setGroup(getInstitutionDivisionRadio());

      addInstitutionDivisionRadioItem1();
    }
    return InstitutionDivisionRadioItem1;

  }

  /**
   * ���j�b�g�^�F�m�ǎ����^���擾���܂��B
   * @return ���j�b�g�^�F�m�ǎ����^
   */
  public ACRadioButtonItem getInstitutionDivisionRadioItem2(){
    if(InstitutionDivisionRadioItem2==null){

      InstitutionDivisionRadioItem2 = new ACRadioButtonItem();

      InstitutionDivisionRadioItem2.setText("���j�b�g�^�F�m�ǎ����^");

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

      staffAssignmentDivision.setBindPath("1530302");

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
   * �h�{�Ǘ��̐����W�I�O���[�v���擾���܂��B
   * @return �h�{�Ǘ��̐����W�I�O���[�v
   */
  public ACClearableRadioButtonGroup getNutritionManageRadio(){
    if(nutritionManageRadio==null){

      nutritionManageRadio = new ACClearableRadioButtonGroup();

      getNutritionManageRadioContainer().setText("�h�{�Ǘ��̐�");

      nutritionManageRadio.setBindPath("1530303");

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

      nutritionRadio.setBindPath("1530304");

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

      oralSwitchRadio.setBindPath("1530305");

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

      recuperateDinnerRadio.setBindPath("1530306");

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
  public ACComboBox getStaffLack(){
    if(staffLack==null){

      staffLack = new ACComboBox();

      getStaffLackContainer().setText("�l�����Z");

      staffLack.setBindPath("1530307");

      staffLack.setEditable(false);

      staffLack.setModel(getStaffLackModel());

      staffLack.setRenderBindPath("CONTENT");

      addStaffLack();
    }
    return staffLack;

  }

  /**
   * �l�����Z�R���e�i���擾���܂��B
   * @return �l�����Z�R���e�i
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
   * �l�����Z���f�����擾���܂��B
   * @return �l�����Z���f��
   */
  protected ACComboBoxModelAdapter getStaffLackModel(){
    if(staffLackModel==null){
      staffLackModel = new ACComboBoxModelAdapter();
      addStaffLackModel();
    }
    return staffLackModel;
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

      kaigoRecuperationMedicalFacilitiesDinnerStandeirdMoneyTotal.setBindPath("1530308");

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

      kaigoRecuperationMedicalFacilitiesMorningDinnerStandeirdMoney.setBindPath("1530309");

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

      kaigoRecuperationMedicalFacilitiesNoonDinnerStandeirdMoney.setBindPath("1530310");

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

      kaigoRecuperationMedicalFacilitiesNightDinnerStandeirdMoney.setBindPath("1530311");

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
  public ACLabel getKaigoRecuperationMedicalFacilitiesDinnerStandeirdMoneyDenomination(){
    if(kaigoRecuperationMedicalFacilitiesDinnerStandeirdMoneyDenomination==null){

      kaigoRecuperationMedicalFacilitiesDinnerStandeirdMoneyDenomination = new ACLabel();

      kaigoRecuperationMedicalFacilitiesDinnerStandeirdMoneyDenomination.setText("�i�~�j");

      addKaigoRecuperationMedicalFacilitiesDinnerStandeirdMoneyDenomination();
    }
    return kaigoRecuperationMedicalFacilitiesDinnerStandeirdMoneyDenomination;

  }

  /**
   * ���j�b�g�^����z�E�R���e�i���擾���܂��B
   * @return ���j�b�g�^����z�E�R���e�i
   */
  public ACLabelContainer getKaigoRecuperationMedicalFacilitiesCognitiveUnitRoomStandeirdMoneyConteiner(){
    if(kaigoRecuperationMedicalFacilitiesCognitiveUnitRoomStandeirdMoneyConteiner==null){

      kaigoRecuperationMedicalFacilitiesCognitiveUnitRoomStandeirdMoneyConteiner = new ACLabelContainer();

      kaigoRecuperationMedicalFacilitiesCognitiveUnitRoomStandeirdMoneyConteiner.setText("���j�b�g�^����z");

      kaigoRecuperationMedicalFacilitiesCognitiveUnitRoomStandeirdMoneyConteiner.setFollowChildEnabled(true);

      addKaigoRecuperationMedicalFacilitiesCognitiveUnitRoomStandeirdMoneyConteiner();
    }
    return kaigoRecuperationMedicalFacilitiesCognitiveUnitRoomStandeirdMoneyConteiner;

  }

  /**
   * ���j�b�g�^����z�E�e�L�X�g���擾���܂��B
   * @return ���j�b�g�^����z�E�e�L�X�g
   */
  public ACTextField getKaigoRecuperationMedicalFacilitiesCognitiveUnitRoomStandeirdMoneyText(){
    if(kaigoRecuperationMedicalFacilitiesCognitiveUnitRoomStandeirdMoneyText==null){

      kaigoRecuperationMedicalFacilitiesCognitiveUnitRoomStandeirdMoneyText = new ACTextField();

      kaigoRecuperationMedicalFacilitiesCognitiveUnitRoomStandeirdMoneyText.setBindPath("1530312");

      kaigoRecuperationMedicalFacilitiesCognitiveUnitRoomStandeirdMoneyText.setColumns(4);

      kaigoRecuperationMedicalFacilitiesCognitiveUnitRoomStandeirdMoneyText.setCharType(VRCharType.ONLY_DIGIT);

      kaigoRecuperationMedicalFacilitiesCognitiveUnitRoomStandeirdMoneyText.setHorizontalAlignment(SwingConstants.RIGHT);

      kaigoRecuperationMedicalFacilitiesCognitiveUnitRoomStandeirdMoneyText.setIMEMode(InputSubset.LATIN);

      kaigoRecuperationMedicalFacilitiesCognitiveUnitRoomStandeirdMoneyText.setMaxLength(4);

      addKaigoRecuperationMedicalFacilitiesCognitiveUnitRoomStandeirdMoneyText();
    }
    return kaigoRecuperationMedicalFacilitiesCognitiveUnitRoomStandeirdMoneyText;

  }

  /**
   * ���j�b�g�^����z�E���x�����擾���܂��B
   * @return ���j�b�g�^����z�E���x��
   */
  public ACLabel getKaigoRecuperationMedicalFacilitiesCognitiveUnitRoomStandeirdMoneyLabel(){
    if(kaigoRecuperationMedicalFacilitiesCognitiveUnitRoomStandeirdMoneyLabel==null){

      kaigoRecuperationMedicalFacilitiesCognitiveUnitRoomStandeirdMoneyLabel = new ACLabel();

      kaigoRecuperationMedicalFacilitiesCognitiveUnitRoomStandeirdMoneyLabel.setText("�i�~�j");

      addKaigoRecuperationMedicalFacilitiesCognitiveUnitRoomStandeirdMoneyLabel();
    }
    return kaigoRecuperationMedicalFacilitiesCognitiveUnitRoomStandeirdMoneyLabel;

  }

  /**
   * ���j�b�g�^������z�E�R���e�i���擾���܂��B
   * @return ���j�b�g�^������z�E�R���e�i
   */
  public ACLabelContainer getKaigoRecuperationMedicalFacilitiesCognitiveUnitSemiRoomStandeirdMoneyConteiner(){
    if(kaigoRecuperationMedicalFacilitiesCognitiveUnitSemiRoomStandeirdMoneyConteiner==null){

      kaigoRecuperationMedicalFacilitiesCognitiveUnitSemiRoomStandeirdMoneyConteiner = new ACLabelContainer();

      kaigoRecuperationMedicalFacilitiesCognitiveUnitSemiRoomStandeirdMoneyConteiner.setText("���j�b�g�^������z");

      kaigoRecuperationMedicalFacilitiesCognitiveUnitSemiRoomStandeirdMoneyConteiner.setFollowChildEnabled(true);

      addKaigoRecuperationMedicalFacilitiesCognitiveUnitSemiRoomStandeirdMoneyConteiner();
    }
    return kaigoRecuperationMedicalFacilitiesCognitiveUnitSemiRoomStandeirdMoneyConteiner;

  }

  /**
   * ���j�b�g�^������z�E�e�L�X�g���擾���܂��B
   * @return ���j�b�g�^������z�E�e�L�X�g
   */
  public ACTextField getKaigoRecuperationMedicalFacilitiesCognitiveUnitSemiRoomStandeirdMoneyText(){
    if(kaigoRecuperationMedicalFacilitiesCognitiveUnitSemiRoomStandeirdMoneyText==null){

      kaigoRecuperationMedicalFacilitiesCognitiveUnitSemiRoomStandeirdMoneyText = new ACTextField();

      kaigoRecuperationMedicalFacilitiesCognitiveUnitSemiRoomStandeirdMoneyText.setBindPath("1530313");

      kaigoRecuperationMedicalFacilitiesCognitiveUnitSemiRoomStandeirdMoneyText.setColumns(4);

      kaigoRecuperationMedicalFacilitiesCognitiveUnitSemiRoomStandeirdMoneyText.setCharType(VRCharType.ONLY_DIGIT);

      kaigoRecuperationMedicalFacilitiesCognitiveUnitSemiRoomStandeirdMoneyText.setHorizontalAlignment(SwingConstants.RIGHT);

      kaigoRecuperationMedicalFacilitiesCognitiveUnitSemiRoomStandeirdMoneyText.setIMEMode(InputSubset.LATIN);

      kaigoRecuperationMedicalFacilitiesCognitiveUnitSemiRoomStandeirdMoneyText.setMaxLength(4);

      addKaigoRecuperationMedicalFacilitiesCognitiveUnitSemiRoomStandeirdMoneyText();
    }
    return kaigoRecuperationMedicalFacilitiesCognitiveUnitSemiRoomStandeirdMoneyText;

  }

  /**
   * ���j�b�g�^������z�E���x�����擾���܂��B
   * @return ���j�b�g�^������z�E���x��
   */
  public ACLabel getKaigoRecuperationMedicalFacilitiesCognitiveUnitSemiRoomStandeirdMoneyLabel(){
    if(kaigoRecuperationMedicalFacilitiesCognitiveUnitSemiRoomStandeirdMoneyLabel==null){

      kaigoRecuperationMedicalFacilitiesCognitiveUnitSemiRoomStandeirdMoneyLabel = new ACLabel();

      kaigoRecuperationMedicalFacilitiesCognitiveUnitSemiRoomStandeirdMoneyLabel.setText("�i�~�j");

      addKaigoRecuperationMedicalFacilitiesCognitiveUnitSemiRoomStandeirdMoneyLabel();
    }
    return kaigoRecuperationMedicalFacilitiesCognitiveUnitSemiRoomStandeirdMoneyLabel;

  }

  /**
   * �]���^����z�E�R���e�i���擾���܂��B
   * @return �]���^����z�E�R���e�i
   */
  public ACLabelContainer getKaigoRecuperationMedicalFacilitiesCognitiveNormalRoomStandeirdMoneyConteiner(){
    if(kaigoRecuperationMedicalFacilitiesCognitiveNormalRoomStandeirdMoneyConteiner==null){

      kaigoRecuperationMedicalFacilitiesCognitiveNormalRoomStandeirdMoneyConteiner = new ACLabelContainer();

      kaigoRecuperationMedicalFacilitiesCognitiveNormalRoomStandeirdMoneyConteiner.setText("�@�@�]���^����z");

      kaigoRecuperationMedicalFacilitiesCognitiveNormalRoomStandeirdMoneyConteiner.setFollowChildEnabled(true);

      addKaigoRecuperationMedicalFacilitiesCognitiveNormalRoomStandeirdMoneyConteiner();
    }
    return kaigoRecuperationMedicalFacilitiesCognitiveNormalRoomStandeirdMoneyConteiner;

  }

  /**
   * �]���^����z�E�e�L�X�g���擾���܂��B
   * @return �]���^����z�E�e�L�X�g
   */
  public ACTextField getKaigoRecuperationMedicalFacilitiesCognitiveNormalRoomStandeirdMoneyText(){
    if(kaigoRecuperationMedicalFacilitiesCognitiveNormalRoomStandeirdMoneyText==null){

      kaigoRecuperationMedicalFacilitiesCognitiveNormalRoomStandeirdMoneyText = new ACTextField();

      kaigoRecuperationMedicalFacilitiesCognitiveNormalRoomStandeirdMoneyText.setBindPath("1530314");

      kaigoRecuperationMedicalFacilitiesCognitiveNormalRoomStandeirdMoneyText.setColumns(4);

      kaigoRecuperationMedicalFacilitiesCognitiveNormalRoomStandeirdMoneyText.setCharType(VRCharType.ONLY_DIGIT);

      kaigoRecuperationMedicalFacilitiesCognitiveNormalRoomStandeirdMoneyText.setHorizontalAlignment(SwingConstants.RIGHT);

      kaigoRecuperationMedicalFacilitiesCognitiveNormalRoomStandeirdMoneyText.setIMEMode(InputSubset.LATIN);

      kaigoRecuperationMedicalFacilitiesCognitiveNormalRoomStandeirdMoneyText.setMaxLength(4);

      addKaigoRecuperationMedicalFacilitiesCognitiveNormalRoomStandeirdMoneyText();
    }
    return kaigoRecuperationMedicalFacilitiesCognitiveNormalRoomStandeirdMoneyText;

  }

  /**
   * �]���^����z�E���x�����擾���܂��B
   * @return �]���^����z�E���x��
   */
  public ACLabel getKaigoRecuperationMedicalFacilitiesCognitiveNormalRoomStandeirdMoneyLabel(){
    if(kaigoRecuperationMedicalFacilitiesCognitiveNormalRoomStandeirdMoneyLabel==null){

      kaigoRecuperationMedicalFacilitiesCognitiveNormalRoomStandeirdMoneyLabel = new ACLabel();

      kaigoRecuperationMedicalFacilitiesCognitiveNormalRoomStandeirdMoneyLabel.setText("�i�~�j");

      addKaigoRecuperationMedicalFacilitiesCognitiveNormalRoomStandeirdMoneyLabel();
    }
    return kaigoRecuperationMedicalFacilitiesCognitiveNormalRoomStandeirdMoneyLabel;

  }

  /**
   * ��������z�E�R���e�i���擾���܂��B
   * @return ��������z�E�R���e�i
   */
  public ACLabelContainer getKaigoRecuperationMedicalFacilitiesCognitiveTasyouRoomConteiner(){
    if(kaigoRecuperationMedicalFacilitiesCognitiveTasyouRoomConteiner==null){

      kaigoRecuperationMedicalFacilitiesCognitiveTasyouRoomConteiner = new ACLabelContainer();

      kaigoRecuperationMedicalFacilitiesCognitiveTasyouRoomConteiner.setText("�@�@��������z");

      kaigoRecuperationMedicalFacilitiesCognitiveTasyouRoomConteiner.setFollowChildEnabled(true);

      addKaigoRecuperationMedicalFacilitiesCognitiveTasyouRoomConteiner();
    }
    return kaigoRecuperationMedicalFacilitiesCognitiveTasyouRoomConteiner;

  }

  /**
   * ��������z�E�e�L�X�g���擾���܂��B
   * @return ��������z�E�e�L�X�g
   */
  public ACTextField getKaigoRecuperationMedicalFacilitiesCognitiveTasyouRoomText(){
    if(kaigoRecuperationMedicalFacilitiesCognitiveTasyouRoomText==null){

      kaigoRecuperationMedicalFacilitiesCognitiveTasyouRoomText = new ACTextField();

      kaigoRecuperationMedicalFacilitiesCognitiveTasyouRoomText.setBindPath("1530315");

      kaigoRecuperationMedicalFacilitiesCognitiveTasyouRoomText.setColumns(4);

      kaigoRecuperationMedicalFacilitiesCognitiveTasyouRoomText.setCharType(VRCharType.ONLY_DIGIT);

      kaigoRecuperationMedicalFacilitiesCognitiveTasyouRoomText.setHorizontalAlignment(SwingConstants.RIGHT);

      kaigoRecuperationMedicalFacilitiesCognitiveTasyouRoomText.setIMEMode(InputSubset.LATIN);

      kaigoRecuperationMedicalFacilitiesCognitiveTasyouRoomText.setMaxLength(4);

      addKaigoRecuperationMedicalFacilitiesCognitiveTasyouRoomText();
    }
    return kaigoRecuperationMedicalFacilitiesCognitiveTasyouRoomText;

  }

  /**
   * ��������z�E���x�����擾���܂��B
   * @return ��������z�E���x��
   */
  public ACLabel getKaigoRecuperationMedicalFacilitiesCognitiveTasyouRoomLabel(){
    if(kaigoRecuperationMedicalFacilitiesCognitiveTasyouRoomLabel==null){

      kaigoRecuperationMedicalFacilitiesCognitiveTasyouRoomLabel = new ACLabel();

      kaigoRecuperationMedicalFacilitiesCognitiveTasyouRoomLabel.setText("�i�~�j");

      addKaigoRecuperationMedicalFacilitiesCognitiveTasyouRoomLabel();
    }
    return kaigoRecuperationMedicalFacilitiesCognitiveTasyouRoomLabel;

  }

  /**
   * �R���X�g���N�^�ł��B
   */
  public QO004020Design() {

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

    kaigoRecuperationMedicalFacilitiesGroup.add(getKaigoRecuperationMedicalFacilitiesDiscountcontainer(), VRLayout.FLOW_INSETLINE_RETURN);

    kaigoRecuperationMedicalFacilitiesGroup.add(getInstitutionDivisionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    kaigoRecuperationMedicalFacilitiesGroup.add(getStaffAssignmentDivisionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    kaigoRecuperationMedicalFacilitiesGroup.add(getNutritionManageRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    kaigoRecuperationMedicalFacilitiesGroup.add(getNutritionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    kaigoRecuperationMedicalFacilitiesGroup.add(getOralSwitchRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    kaigoRecuperationMedicalFacilitiesGroup.add(getRecuperateDinnerRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    kaigoRecuperationMedicalFacilitiesGroup.add(getStaffLackContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    kaigoRecuperationMedicalFacilitiesGroup.add(getKaigoRecuperationMedicalFacilitiesDinnerStandeirdMoneyConteiner(), VRLayout.FLOW_INSETLINE_RETURN);

    kaigoRecuperationMedicalFacilitiesGroup.add(getKaigoRecuperationMedicalFacilitiesCognitiveUnitRoomStandeirdMoneyConteiner(), VRLayout.FLOW_INSETLINE_RETURN);

    kaigoRecuperationMedicalFacilitiesGroup.add(getKaigoRecuperationMedicalFacilitiesCognitiveUnitSemiRoomStandeirdMoneyConteiner(), VRLayout.FLOW_INSETLINE_RETURN);

    kaigoRecuperationMedicalFacilitiesGroup.add(getKaigoRecuperationMedicalFacilitiesCognitiveNormalRoomStandeirdMoneyConteiner(), VRLayout.FLOW_INSETLINE_RETURN);

    kaigoRecuperationMedicalFacilitiesGroup.add(getKaigoRecuperationMedicalFacilitiesCognitiveTasyouRoomConteiner(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * �������R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoRecuperationMedicalFacilitiesDiscountcontainer(){

    kaigoRecuperationMedicalFacilitiesDiscountcontainer.add(getKaigoRecuperationMedicalFacilitiesDiscountRate(), VRLayout.FLOW);

    kaigoRecuperationMedicalFacilitiesDiscountcontainer.add(getPercentSign(), VRLayout.FLOW);

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
   * �F�m�ǎ����^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addInstitutionDivisionRadioItem1(){

  }

  /**
   * ���j�b�g�^�F�m�ǎ����^�ɓ������ڂ�ǉ����܂��B
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
  protected void addStaffLack(){

  }

  /**
   * �l�����Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffLackModel(){

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

    kaigoRecuperationMedicalFacilitiesDinnerStandeirdMoneyConteiner.add(getKaigoRecuperationMedicalFacilitiesDinnerStandeirdMoneyDenomination(), VRLayout.FLOW);

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
  protected void addKaigoRecuperationMedicalFacilitiesDinnerStandeirdMoneyDenomination(){

  }

  /**
   * ���j�b�g�^����z�E�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoRecuperationMedicalFacilitiesCognitiveUnitRoomStandeirdMoneyConteiner(){

    kaigoRecuperationMedicalFacilitiesCognitiveUnitRoomStandeirdMoneyConteiner.add(getKaigoRecuperationMedicalFacilitiesCognitiveUnitRoomStandeirdMoneyText(), null);

    kaigoRecuperationMedicalFacilitiesCognitiveUnitRoomStandeirdMoneyConteiner.add(getKaigoRecuperationMedicalFacilitiesCognitiveUnitRoomStandeirdMoneyLabel(), null);

  }

  /**
   * ���j�b�g�^����z�E�e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoRecuperationMedicalFacilitiesCognitiveUnitRoomStandeirdMoneyText(){

  }

  /**
   * ���j�b�g�^����z�E���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoRecuperationMedicalFacilitiesCognitiveUnitRoomStandeirdMoneyLabel(){

  }

  /**
   * ���j�b�g�^������z�E�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoRecuperationMedicalFacilitiesCognitiveUnitSemiRoomStandeirdMoneyConteiner(){

    kaigoRecuperationMedicalFacilitiesCognitiveUnitSemiRoomStandeirdMoneyConteiner.add(getKaigoRecuperationMedicalFacilitiesCognitiveUnitSemiRoomStandeirdMoneyText(), null);

    kaigoRecuperationMedicalFacilitiesCognitiveUnitSemiRoomStandeirdMoneyConteiner.add(getKaigoRecuperationMedicalFacilitiesCognitiveUnitSemiRoomStandeirdMoneyLabel(), null);

  }

  /**
   * ���j�b�g�^������z�E�e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoRecuperationMedicalFacilitiesCognitiveUnitSemiRoomStandeirdMoneyText(){

  }

  /**
   * ���j�b�g�^������z�E���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoRecuperationMedicalFacilitiesCognitiveUnitSemiRoomStandeirdMoneyLabel(){

  }

  /**
   * �]���^����z�E�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoRecuperationMedicalFacilitiesCognitiveNormalRoomStandeirdMoneyConteiner(){

    kaigoRecuperationMedicalFacilitiesCognitiveNormalRoomStandeirdMoneyConteiner.add(getKaigoRecuperationMedicalFacilitiesCognitiveNormalRoomStandeirdMoneyText(), null);

    kaigoRecuperationMedicalFacilitiesCognitiveNormalRoomStandeirdMoneyConteiner.add(getKaigoRecuperationMedicalFacilitiesCognitiveNormalRoomStandeirdMoneyLabel(), null);

  }

  /**
   * �]���^����z�E�e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoRecuperationMedicalFacilitiesCognitiveNormalRoomStandeirdMoneyText(){

  }

  /**
   * �]���^����z�E���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoRecuperationMedicalFacilitiesCognitiveNormalRoomStandeirdMoneyLabel(){

  }

  /**
   * ��������z�E�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoRecuperationMedicalFacilitiesCognitiveTasyouRoomConteiner(){

    kaigoRecuperationMedicalFacilitiesCognitiveTasyouRoomConteiner.add(getKaigoRecuperationMedicalFacilitiesCognitiveTasyouRoomText(), null);

    kaigoRecuperationMedicalFacilitiesCognitiveTasyouRoomConteiner.add(getKaigoRecuperationMedicalFacilitiesCognitiveTasyouRoomLabel(), null);

  }

  /**
   * ��������z�E�e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoRecuperationMedicalFacilitiesCognitiveTasyouRoomText(){

  }

  /**
   * ��������z�E���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoRecuperationMedicalFacilitiesCognitiveTasyouRoomLabel(){

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
      ACFrame.getInstance().getContentPane().add(new QO004020Design());
      ACFrame.getInstance().setVisible(true);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QO004020Design getThis() {
    return this;
  }
}
