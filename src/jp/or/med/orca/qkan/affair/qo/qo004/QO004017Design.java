
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
 * �v���O���� ���V�l�ی��{�� (QO004017)
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
 * ���V�l�ی��{�݉�ʍ��ڃf�U�C��(QO004017) 
 */
public class QO004017Design extends ACPanel {
  //GUI�R���|�[�l���g

  private ACGroupBox agedPeopleHealthFacilityGroup;

  private ACLabelContainer agedPeopleHealthFacilityDiscountContainer;

  private ACTextField agedPeopleHealthFacilityDiscountRate;

  private ACLabel percentSign;

  private ACClearableRadioButtonGroup institutionDivisionRadio;

  private ACLabelContainer institutionDivisionRadioContainer;

  private ACListModelAdapter institutionDivisionRadioModel;

  private ACRadioButtonItem institutionDivisionRadioItem1;

  private ACRadioButtonItem institutionDivisionRadioItem2;

  private ACClearableRadioButtonGroup nightShiftCondition;

  private ACLabelContainer nightShiftConditionContainer;

  private ACListModelAdapter nightShiftConditionModel;

  private ACRadioButtonItem nightShiftConditionStandard;

  private ACRadioButtonItem nightShiftConditionSubtraction;

  private ACClearableRadioButtonGroup rehabilitationFunctionalEnhancement;

  private ACLabelContainer rehabilitationFunctionalEnhancementContainer;

  private ACListModelAdapter rehabilitationFunctionalEnhancementModel;

  private ACRadioButtonItem rehabilitationFunctionalEnhancementOff;

  private ACRadioButtonItem rehabilitationFunctionalEnhancementOn;

  private ACClearableRadioButtonGroup dementiaSpecialBuilding;

  private ACLabelContainer dementiaSpecialBuildingContainer;

  private ACListModelAdapter dementiaSpecialBuildingModel;

  private ACRadioButtonItem dementiaSpecialBuildingOff;

  private ACRadioButtonItem dementiaSpecialBuildingOn;

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

  private ACRadioButtonItem staffLackExcess;

  private ACRadioButtonItem staffLackKango;

  private ACLabelContainer careOldPeopleHealthFacilitiesDinnerStandeirdMoneyConteiner;

  private ACTextField careOldPeopleHealthFacilitiesDinnerStandeirdMoneyTotal;

  private ACLabel careOldPeopleHealthFacilitiesMorningDinnerStandeirdMoneyLabel;

  private ACTextField careOldPeopleHealthFacilitiesMorningDinnerStandeirdMoney;

  private ACLabel careOldPeopleHealthFacilitiesNoonDinnerStandeirdMoneyLabel;

  private ACTextField careOldPeopleHealthFacilitiesNoonDinnerStandeirdMoney;

  private ACLabel careOldPeopleHealthFacilitiesNightDinnerStandeirdMoneyLabel;

  private ACTextField careOldPeopleHealthFacilitiesNightDinnerStandeirdMoney;

  private ACLabel careOldPeopleHealthFacilitiesTotalDinnerStandeirdMoneyDenominationLabel;

  private ACLabelContainer careOldPeopleHealthFacilitiesUnitRoomStandeirdMoneyConteiner;

  private ACTextField careOldPeopleHealthFacilitiesUnitRoomStandeirdMoneyText;

  private ACLabel careOldPeopleHealthFacilitiesUnitRoomStandeirdMoneyLabel;

  private ACLabelContainer careOldPeopleHealthFacilitiesUnitSemiRoomStandeirdMoneyConteiner;

  private ACTextField careOldPeopleHealthFacilitiesUnitSemiRoomStandeirdMoneyText;

  private ACLabel careOldPeopleHealthFacilitiesUnitSemiRoomStandeirdMoneyLabel;

  private ACLabelContainer careOldPeopleHealthFacilitiesNormalRoomStandeirdMoneyConteiner;

  private ACTextField careOldPeopleHealthFacilitiesNormalRoomStandeirdMoneyText;

  private ACLabel careOldPeopleHealthFacilitiesNormalRoomStandeirdMoneyLabel;

  private ACLabelContainer careOldPeopleHealthFacilitiesTasyouRoomConteiner;

  private ACTextField careOldPeopleHealthFacilitiesTasyouRoomText;

  private ACLabel careOldPeopleHealthFacilitiesTasyouRoomLabel;

  //getter

  /**
   * ���ƃO���[�v���擾���܂��B
   * @return ���ƃO���[�v
   */
  public ACGroupBox getAgedPeopleHealthFacilityGroup(){
    if(agedPeopleHealthFacilityGroup==null){

      agedPeopleHealthFacilityGroup = new ACGroupBox();

      agedPeopleHealthFacilityGroup.setText("���V�l�ی��{��");

      agedPeopleHealthFacilityGroup.setFollowChildEnabled(true);

      agedPeopleHealthFacilityGroup.setHgrid(200);

      addAgedPeopleHealthFacilityGroup();
    }
    return agedPeopleHealthFacilityGroup;

  }

  /**
   * �������R���e�i���擾���܂��B
   * @return �������R���e�i
   */
  public ACLabelContainer getAgedPeopleHealthFacilityDiscountContainer(){
    if(agedPeopleHealthFacilityDiscountContainer==null){

      agedPeopleHealthFacilityDiscountContainer = new ACLabelContainer();

      agedPeopleHealthFacilityDiscountContainer.setText("������");

      agedPeopleHealthFacilityDiscountContainer.setFollowChildEnabled(true);

      addAgedPeopleHealthFacilityDiscountContainer();
    }
    return agedPeopleHealthFacilityDiscountContainer;

  }

  /**
   * ���������擾���܂��B
   * @return ������
   */
  public ACTextField getAgedPeopleHealthFacilityDiscountRate(){
    if(agedPeopleHealthFacilityDiscountRate==null){

      agedPeopleHealthFacilityDiscountRate = new ACTextField();

      agedPeopleHealthFacilityDiscountRate.setBindPath("REDUCT_RATE");

      agedPeopleHealthFacilityDiscountRate.setColumns(3);

      agedPeopleHealthFacilityDiscountRate.setCharType(VRCharType.ONLY_DIGIT);

      agedPeopleHealthFacilityDiscountRate.setHorizontalAlignment(SwingConstants.RIGHT);

      agedPeopleHealthFacilityDiscountRate.setIMEMode(InputSubset.LATIN);

      agedPeopleHealthFacilityDiscountRate.setMaxLength(3);

      addAgedPeopleHealthFacilityDiscountRate();
    }
    return agedPeopleHealthFacilityDiscountRate;

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
    if(institutionDivisionRadio==null){

      institutionDivisionRadio = new ACClearableRadioButtonGroup();

      getInstitutionDivisionRadioContainer().setText("�{�݋敪");

      institutionDivisionRadio.setBindPath("1520101");

      institutionDivisionRadio.setModel(getInstitutionDivisionRadioModel());

      institutionDivisionRadio.setUseClearButton(false);

      addInstitutionDivisionRadio();
    }
    return institutionDivisionRadio;

  }

  /**
   * �{�݋敪���W�I�O���[�v�R���e�i���擾���܂��B
   * @return �{�݋敪���W�I�O���[�v�R���e�i
   */
  protected ACLabelContainer getInstitutionDivisionRadioContainer(){
    if(institutionDivisionRadioContainer==null){
      institutionDivisionRadioContainer = new ACLabelContainer();
      institutionDivisionRadioContainer.setFollowChildEnabled(true);
      institutionDivisionRadioContainer.add(getInstitutionDivisionRadio(), null);
    }
    return institutionDivisionRadioContainer;
  }

  /**
   * �{�݋敪���W�I�O���[�v���f�����擾���܂��B
   * @return �{�݋敪���W�I�O���[�v���f��
   */
  protected ACListModelAdapter getInstitutionDivisionRadioModel(){
    if(institutionDivisionRadioModel==null){
      institutionDivisionRadioModel = new ACListModelAdapter();
      addInstitutionDivisionRadioModel();
    }
    return institutionDivisionRadioModel;
  }

  /**
   * ���ی��{�݂��擾���܂��B
   * @return ���ی��{��
   */
  public ACRadioButtonItem getInstitutionDivisionRadioItem1(){
    if(institutionDivisionRadioItem1==null){

      institutionDivisionRadioItem1 = new ACRadioButtonItem();

      institutionDivisionRadioItem1.setText("���ی��{��");

      institutionDivisionRadioItem1.setGroup(getInstitutionDivisionRadio());

      addInstitutionDivisionRadioItem1();
    }
    return institutionDivisionRadioItem1;

  }

  /**
   * ���j�b�g�^���ی��{�݂��擾���܂��B
   * @return ���j�b�g�^���ی��{��
   */
  public ACRadioButtonItem getInstitutionDivisionRadioItem2(){
    if(institutionDivisionRadioItem2==null){

      institutionDivisionRadioItem2 = new ACRadioButtonItem();

      institutionDivisionRadioItem2.setText("���j�b�g�^���ی��{��");

      institutionDivisionRadioItem2.setGroup(getInstitutionDivisionRadio());

      addInstitutionDivisionRadioItem2();
    }
    return institutionDivisionRadioItem2;

  }

  /**
   * ��ԋΖ���������W�I�O���[�v���擾���܂��B
   * @return ��ԋΖ���������W�I�O���[�v
   */
  public ACClearableRadioButtonGroup getNightShiftCondition(){
    if(nightShiftCondition==null){

      nightShiftCondition = new ACClearableRadioButtonGroup();

      getNightShiftConditionContainer().setText("��ԋΖ������");

      nightShiftCondition.setBindPath("1520102");

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
   * ���n�r���e�[�V�����@�\�������W�I�O���[�v���擾���܂��B
   * @return ���n�r���e�[�V�����@�\�������W�I�O���[�v
   */
  public ACClearableRadioButtonGroup getRehabilitationFunctionalEnhancement(){
    if(rehabilitationFunctionalEnhancement==null){

      rehabilitationFunctionalEnhancement = new ACClearableRadioButtonGroup();

      getRehabilitationFunctionalEnhancementContainer().setText("���n�r���e�[�V�����@�\����");

      rehabilitationFunctionalEnhancement.setBindPath("1520103");

      rehabilitationFunctionalEnhancement.setModel(getRehabilitationFunctionalEnhancementModel());

      rehabilitationFunctionalEnhancement.setUseClearButton(false);

      addRehabilitationFunctionalEnhancement();
    }
    return rehabilitationFunctionalEnhancement;

  }

  /**
   * ���n�r���e�[�V�����@�\�������W�I�O���[�v�R���e�i���擾���܂��B
   * @return ���n�r���e�[�V�����@�\�������W�I�O���[�v�R���e�i
   */
  protected ACLabelContainer getRehabilitationFunctionalEnhancementContainer(){
    if(rehabilitationFunctionalEnhancementContainer==null){
      rehabilitationFunctionalEnhancementContainer = new ACLabelContainer();
      rehabilitationFunctionalEnhancementContainer.setFollowChildEnabled(true);
      rehabilitationFunctionalEnhancementContainer.add(getRehabilitationFunctionalEnhancement(), null);
    }
    return rehabilitationFunctionalEnhancementContainer;
  }

  /**
   * ���n�r���e�[�V�����@�\�������W�I�O���[�v���f�����擾���܂��B
   * @return ���n�r���e�[�V�����@�\�������W�I�O���[�v���f��
   */
  protected ACListModelAdapter getRehabilitationFunctionalEnhancementModel(){
    if(rehabilitationFunctionalEnhancementModel==null){
      rehabilitationFunctionalEnhancementModel = new ACListModelAdapter();
      addRehabilitationFunctionalEnhancementModel();
    }
    return rehabilitationFunctionalEnhancementModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getRehabilitationFunctionalEnhancementOff(){
    if(rehabilitationFunctionalEnhancementOff==null){

      rehabilitationFunctionalEnhancementOff = new ACRadioButtonItem();

      rehabilitationFunctionalEnhancementOff.setText("�Ȃ�");

      rehabilitationFunctionalEnhancementOff.setGroup(getRehabilitationFunctionalEnhancement());

      addRehabilitationFunctionalEnhancementOff();
    }
    return rehabilitationFunctionalEnhancementOff;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getRehabilitationFunctionalEnhancementOn(){
    if(rehabilitationFunctionalEnhancementOn==null){

      rehabilitationFunctionalEnhancementOn = new ACRadioButtonItem();

      rehabilitationFunctionalEnhancementOn.setText("����");

      rehabilitationFunctionalEnhancementOn.setGroup(getRehabilitationFunctionalEnhancement());

      addRehabilitationFunctionalEnhancementOn();
    }
    return rehabilitationFunctionalEnhancementOn;

  }

  /**
   * �F�m�ǐ�哏���W�I�O���[�v���擾���܂��B
   * @return �F�m�ǐ�哏���W�I�O���[�v
   */
  public ACClearableRadioButtonGroup getDementiaSpecialBuilding(){
    if(dementiaSpecialBuilding==null){

      dementiaSpecialBuilding = new ACClearableRadioButtonGroup();

      getDementiaSpecialBuildingContainer().setText("�F�m�ǐ�哏");

      dementiaSpecialBuilding.setBindPath("1520104");

      dementiaSpecialBuilding.setModel(getDementiaSpecialBuildingModel());

      dementiaSpecialBuilding.setUseClearButton(false);

      addDementiaSpecialBuilding();
    }
    return dementiaSpecialBuilding;

  }

  /**
   * �F�m�ǐ�哏���W�I�O���[�v�R���e�i���擾���܂��B
   * @return �F�m�ǐ�哏���W�I�O���[�v�R���e�i
   */
  protected ACLabelContainer getDementiaSpecialBuildingContainer(){
    if(dementiaSpecialBuildingContainer==null){
      dementiaSpecialBuildingContainer = new ACLabelContainer();
      dementiaSpecialBuildingContainer.setFollowChildEnabled(true);
      dementiaSpecialBuildingContainer.add(getDementiaSpecialBuilding(), null);
    }
    return dementiaSpecialBuildingContainer;
  }

  /**
   * �F�m�ǐ�哏���W�I�O���[�v���f�����擾���܂��B
   * @return �F�m�ǐ�哏���W�I�O���[�v���f��
   */
  protected ACListModelAdapter getDementiaSpecialBuildingModel(){
    if(dementiaSpecialBuildingModel==null){
      dementiaSpecialBuildingModel = new ACListModelAdapter();
      addDementiaSpecialBuildingModel();
    }
    return dementiaSpecialBuildingModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getDementiaSpecialBuildingOff(){
    if(dementiaSpecialBuildingOff==null){

      dementiaSpecialBuildingOff = new ACRadioButtonItem();

      dementiaSpecialBuildingOff.setText("�Ȃ�");

      dementiaSpecialBuildingOff.setGroup(getDementiaSpecialBuilding());

      addDementiaSpecialBuildingOff();
    }
    return dementiaSpecialBuildingOff;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getDementiaSpecialBuildingOn(){
    if(dementiaSpecialBuildingOn==null){

      dementiaSpecialBuildingOn = new ACRadioButtonItem();

      dementiaSpecialBuildingOn.setText("����");

      dementiaSpecialBuildingOn.setGroup(getDementiaSpecialBuilding());

      addDementiaSpecialBuildingOn();
    }
    return dementiaSpecialBuildingOn;

  }

  /**
   * �h�{�Ǘ��̐����W�I�O���[�v���擾���܂��B
   * @return �h�{�Ǘ��̐����W�I�O���[�v
   */
  public ACClearableRadioButtonGroup getNutritionManageRadio(){
    if(nutritionManageRadio==null){

      nutritionManageRadio = new ACClearableRadioButtonGroup();

      getNutritionManageRadioContainer().setText("�h�{�Ǘ��̐�");

      nutritionManageRadio.setBindPath("1520105");

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

      nutritionRadio.setBindPath("1520106");

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

      oralSwitchRadio.setBindPath("1520107");

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

      recuperateDinnerRadio.setBindPath("1520108");

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

      staffLack.setBindPath("1520109");

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
  public ACRadioButtonItem getStaffLackExcess(){
    if(staffLackExcess==null){

      staffLackExcess = new ACRadioButtonItem();

      staffLackExcess.setText("�������");

      staffLackExcess.setGroup(getStaffLack());

      addStaffLackExcess();
    }
    return staffLackExcess;

  }

  /**
   * �Ō�E���E�����͈�t�APT�EOT�A���x�������̕s�����擾���܂��B
   * @return �Ō�E���E�����͈�t�APT�EOT�A���x�������̕s��
   */
  public ACRadioButtonItem getStaffLackKango(){
    if(staffLackKango==null){

      staffLackKango = new ACRadioButtonItem();

      staffLackKango.setText("�Ō�E���E�����͈�t�APT�EOT�A���x�������̕s��");

      staffLackKango.setGroup(getStaffLack());

      addStaffLackKango();
    }
    return staffLackKango;

  }

  /**
   * �H���z�E�R���e�i���擾���܂��B
   * @return �H���z�E�R���e�i
   */
  public ACLabelContainer getCareOldPeopleHealthFacilitiesDinnerStandeirdMoneyConteiner(){
    if(careOldPeopleHealthFacilitiesDinnerStandeirdMoneyConteiner==null){

      careOldPeopleHealthFacilitiesDinnerStandeirdMoneyConteiner = new ACLabelContainer();

      careOldPeopleHealthFacilitiesDinnerStandeirdMoneyConteiner.setText("�H���z");

      careOldPeopleHealthFacilitiesDinnerStandeirdMoneyConteiner.setFollowChildEnabled(true);

      addCareOldPeopleHealthFacilitiesDinnerStandeirdMoneyConteiner();
    }
    return careOldPeopleHealthFacilitiesDinnerStandeirdMoneyConteiner;

  }

  /**
   * �H���z�E���v�E�e�L�X�g���擾���܂��B
   * @return �H���z�E���v�E�e�L�X�g
   */
  public ACTextField getCareOldPeopleHealthFacilitiesDinnerStandeirdMoneyTotal(){
    if(careOldPeopleHealthFacilitiesDinnerStandeirdMoneyTotal==null){

      careOldPeopleHealthFacilitiesDinnerStandeirdMoneyTotal = new ACTextField();

      careOldPeopleHealthFacilitiesDinnerStandeirdMoneyTotal.setBindPath("1520110");

      careOldPeopleHealthFacilitiesDinnerStandeirdMoneyTotal.setEditable(false);

      careOldPeopleHealthFacilitiesDinnerStandeirdMoneyTotal.setColumns(4);

      careOldPeopleHealthFacilitiesDinnerStandeirdMoneyTotal.setCharType(VRCharType.ONLY_DIGIT);

      careOldPeopleHealthFacilitiesDinnerStandeirdMoneyTotal.setHorizontalAlignment(SwingConstants.RIGHT);

      careOldPeopleHealthFacilitiesDinnerStandeirdMoneyTotal.setIMEMode(InputSubset.LATIN);

      careOldPeopleHealthFacilitiesDinnerStandeirdMoneyTotal.setMaxLength(4);

      addCareOldPeopleHealthFacilitiesDinnerStandeirdMoneyTotal();
    }
    return careOldPeopleHealthFacilitiesDinnerStandeirdMoneyTotal;

  }

  /**
   * �H���z�E���E���x�����擾���܂��B
   * @return �H���z�E���E���x��
   */
  public ACLabel getCareOldPeopleHealthFacilitiesMorningDinnerStandeirdMoneyLabel(){
    if(careOldPeopleHealthFacilitiesMorningDinnerStandeirdMoneyLabel==null){

      careOldPeopleHealthFacilitiesMorningDinnerStandeirdMoneyLabel = new ACLabel();

      careOldPeopleHealthFacilitiesMorningDinnerStandeirdMoneyLabel.setText("�@��");

      addCareOldPeopleHealthFacilitiesMorningDinnerStandeirdMoneyLabel();
    }
    return careOldPeopleHealthFacilitiesMorningDinnerStandeirdMoneyLabel;

  }

  /**
   * �H���z�E���E�e�L�X�g���擾���܂��B
   * @return �H���z�E���E�e�L�X�g
   */
  public ACTextField getCareOldPeopleHealthFacilitiesMorningDinnerStandeirdMoney(){
    if(careOldPeopleHealthFacilitiesMorningDinnerStandeirdMoney==null){

      careOldPeopleHealthFacilitiesMorningDinnerStandeirdMoney = new ACTextField();

      careOldPeopleHealthFacilitiesMorningDinnerStandeirdMoney.setBindPath("1520111");

      careOldPeopleHealthFacilitiesMorningDinnerStandeirdMoney.setColumns(3);

      careOldPeopleHealthFacilitiesMorningDinnerStandeirdMoney.setCharType(VRCharType.ONLY_DIGIT);

      careOldPeopleHealthFacilitiesMorningDinnerStandeirdMoney.setHorizontalAlignment(SwingConstants.RIGHT);

      careOldPeopleHealthFacilitiesMorningDinnerStandeirdMoney.setIMEMode(InputSubset.LATIN);

      careOldPeopleHealthFacilitiesMorningDinnerStandeirdMoney.setMaxLength(3);

      addCareOldPeopleHealthFacilitiesMorningDinnerStandeirdMoney();
    }
    return careOldPeopleHealthFacilitiesMorningDinnerStandeirdMoney;

  }

  /**
   * �H���z�E���E���x�����擾���܂��B
   * @return �H���z�E���E���x��
   */
  public ACLabel getCareOldPeopleHealthFacilitiesNoonDinnerStandeirdMoneyLabel(){
    if(careOldPeopleHealthFacilitiesNoonDinnerStandeirdMoneyLabel==null){

      careOldPeopleHealthFacilitiesNoonDinnerStandeirdMoneyLabel = new ACLabel();

      careOldPeopleHealthFacilitiesNoonDinnerStandeirdMoneyLabel.setText("��");

      addCareOldPeopleHealthFacilitiesNoonDinnerStandeirdMoneyLabel();
    }
    return careOldPeopleHealthFacilitiesNoonDinnerStandeirdMoneyLabel;

  }

  /**
   * �H���z�E���E�e�L�X�g���擾���܂��B
   * @return �H���z�E���E�e�L�X�g
   */
  public ACTextField getCareOldPeopleHealthFacilitiesNoonDinnerStandeirdMoney(){
    if(careOldPeopleHealthFacilitiesNoonDinnerStandeirdMoney==null){

      careOldPeopleHealthFacilitiesNoonDinnerStandeirdMoney = new ACTextField();

      careOldPeopleHealthFacilitiesNoonDinnerStandeirdMoney.setBindPath("1520112");

      careOldPeopleHealthFacilitiesNoonDinnerStandeirdMoney.setColumns(3);

      careOldPeopleHealthFacilitiesNoonDinnerStandeirdMoney.setCharType(VRCharType.ONLY_DIGIT);

      careOldPeopleHealthFacilitiesNoonDinnerStandeirdMoney.setHorizontalAlignment(SwingConstants.RIGHT);

      careOldPeopleHealthFacilitiesNoonDinnerStandeirdMoney.setIMEMode(InputSubset.LATIN);

      careOldPeopleHealthFacilitiesNoonDinnerStandeirdMoney.setMaxLength(3);

      addCareOldPeopleHealthFacilitiesNoonDinnerStandeirdMoney();
    }
    return careOldPeopleHealthFacilitiesNoonDinnerStandeirdMoney;

  }

  /**
   * �H���z�E��E���x�����擾���܂��B
   * @return �H���z�E��E���x��
   */
  public ACLabel getCareOldPeopleHealthFacilitiesNightDinnerStandeirdMoneyLabel(){
    if(careOldPeopleHealthFacilitiesNightDinnerStandeirdMoneyLabel==null){

      careOldPeopleHealthFacilitiesNightDinnerStandeirdMoneyLabel = new ACLabel();

      careOldPeopleHealthFacilitiesNightDinnerStandeirdMoneyLabel.setText("��");

      addCareOldPeopleHealthFacilitiesNightDinnerStandeirdMoneyLabel();
    }
    return careOldPeopleHealthFacilitiesNightDinnerStandeirdMoneyLabel;

  }

  /**
   * �H���z�E��E�e�L�X�g���擾���܂��B
   * @return �H���z�E��E�e�L�X�g
   */
  public ACTextField getCareOldPeopleHealthFacilitiesNightDinnerStandeirdMoney(){
    if(careOldPeopleHealthFacilitiesNightDinnerStandeirdMoney==null){

      careOldPeopleHealthFacilitiesNightDinnerStandeirdMoney = new ACTextField();

      careOldPeopleHealthFacilitiesNightDinnerStandeirdMoney.setBindPath("1520113");

      careOldPeopleHealthFacilitiesNightDinnerStandeirdMoney.setColumns(3);

      careOldPeopleHealthFacilitiesNightDinnerStandeirdMoney.setCharType(VRCharType.ONLY_DIGIT);

      careOldPeopleHealthFacilitiesNightDinnerStandeirdMoney.setHorizontalAlignment(SwingConstants.RIGHT);

      careOldPeopleHealthFacilitiesNightDinnerStandeirdMoney.setIMEMode(InputSubset.LATIN);

      careOldPeopleHealthFacilitiesNightDinnerStandeirdMoney.setMaxLength(3);

      addCareOldPeopleHealthFacilitiesNightDinnerStandeirdMoney();
    }
    return careOldPeopleHealthFacilitiesNightDinnerStandeirdMoney;

  }

  /**
   * �H���z�E���x�����擾���܂��B
   * @return �H���z�E���x��
   */
  public ACLabel getCareOldPeopleHealthFacilitiesTotalDinnerStandeirdMoneyDenominationLabel(){
    if(careOldPeopleHealthFacilitiesTotalDinnerStandeirdMoneyDenominationLabel==null){

      careOldPeopleHealthFacilitiesTotalDinnerStandeirdMoneyDenominationLabel = new ACLabel();

      careOldPeopleHealthFacilitiesTotalDinnerStandeirdMoneyDenominationLabel.setText("�i�~�j");

      addCareOldPeopleHealthFacilitiesTotalDinnerStandeirdMoneyDenominationLabel();
    }
    return careOldPeopleHealthFacilitiesTotalDinnerStandeirdMoneyDenominationLabel;

  }

  /**
   * ���j�b�g�^����z�E�R���e�i���擾���܂��B
   * @return ���j�b�g�^����z�E�R���e�i
   */
  public ACLabelContainer getCareOldPeopleHealthFacilitiesUnitRoomStandeirdMoneyConteiner(){
    if(careOldPeopleHealthFacilitiesUnitRoomStandeirdMoneyConteiner==null){

      careOldPeopleHealthFacilitiesUnitRoomStandeirdMoneyConteiner = new ACLabelContainer();

      careOldPeopleHealthFacilitiesUnitRoomStandeirdMoneyConteiner.setText("���j�b�g�^����z");

      careOldPeopleHealthFacilitiesUnitRoomStandeirdMoneyConteiner.setFollowChildEnabled(true);

      addCareOldPeopleHealthFacilitiesUnitRoomStandeirdMoneyConteiner();
    }
    return careOldPeopleHealthFacilitiesUnitRoomStandeirdMoneyConteiner;

  }

  /**
   * ���j�b�g�^����z�E�e�L�X�g���擾���܂��B
   * @return ���j�b�g�^����z�E�e�L�X�g
   */
  public ACTextField getCareOldPeopleHealthFacilitiesUnitRoomStandeirdMoneyText(){
    if(careOldPeopleHealthFacilitiesUnitRoomStandeirdMoneyText==null){

      careOldPeopleHealthFacilitiesUnitRoomStandeirdMoneyText = new ACTextField();

      careOldPeopleHealthFacilitiesUnitRoomStandeirdMoneyText.setBindPath("1520114");

      careOldPeopleHealthFacilitiesUnitRoomStandeirdMoneyText.setColumns(4);

      careOldPeopleHealthFacilitiesUnitRoomStandeirdMoneyText.setCharType(VRCharType.ONLY_DIGIT);

      careOldPeopleHealthFacilitiesUnitRoomStandeirdMoneyText.setHorizontalAlignment(SwingConstants.RIGHT);

      careOldPeopleHealthFacilitiesUnitRoomStandeirdMoneyText.setIMEMode(InputSubset.LATIN);

      careOldPeopleHealthFacilitiesUnitRoomStandeirdMoneyText.setMaxLength(4);

      addCareOldPeopleHealthFacilitiesUnitRoomStandeirdMoneyText();
    }
    return careOldPeopleHealthFacilitiesUnitRoomStandeirdMoneyText;

  }

  /**
   * ���j�b�g�^����z�E���x�����擾���܂��B
   * @return ���j�b�g�^����z�E���x��
   */
  public ACLabel getCareOldPeopleHealthFacilitiesUnitRoomStandeirdMoneyLabel(){
    if(careOldPeopleHealthFacilitiesUnitRoomStandeirdMoneyLabel==null){

      careOldPeopleHealthFacilitiesUnitRoomStandeirdMoneyLabel = new ACLabel();

      careOldPeopleHealthFacilitiesUnitRoomStandeirdMoneyLabel.setText("�i�~�j");

      addCareOldPeopleHealthFacilitiesUnitRoomStandeirdMoneyLabel();
    }
    return careOldPeopleHealthFacilitiesUnitRoomStandeirdMoneyLabel;

  }

  /**
   * ���j�b�g�^������z�E�R���e�i���擾���܂��B
   * @return ���j�b�g�^������z�E�R���e�i
   */
  public ACLabelContainer getCareOldPeopleHealthFacilitiesUnitSemiRoomStandeirdMoneyConteiner(){
    if(careOldPeopleHealthFacilitiesUnitSemiRoomStandeirdMoneyConteiner==null){

      careOldPeopleHealthFacilitiesUnitSemiRoomStandeirdMoneyConteiner = new ACLabelContainer();

      careOldPeopleHealthFacilitiesUnitSemiRoomStandeirdMoneyConteiner.setText("���j�b�g�^������z");

      careOldPeopleHealthFacilitiesUnitSemiRoomStandeirdMoneyConteiner.setFollowChildEnabled(true);

      addCareOldPeopleHealthFacilitiesUnitSemiRoomStandeirdMoneyConteiner();
    }
    return careOldPeopleHealthFacilitiesUnitSemiRoomStandeirdMoneyConteiner;

  }

  /**
   * ���j�b�g�^������z�E�e�L�X�g���擾���܂��B
   * @return ���j�b�g�^������z�E�e�L�X�g
   */
  public ACTextField getCareOldPeopleHealthFacilitiesUnitSemiRoomStandeirdMoneyText(){
    if(careOldPeopleHealthFacilitiesUnitSemiRoomStandeirdMoneyText==null){

      careOldPeopleHealthFacilitiesUnitSemiRoomStandeirdMoneyText = new ACTextField();

      careOldPeopleHealthFacilitiesUnitSemiRoomStandeirdMoneyText.setBindPath("1520115");

      careOldPeopleHealthFacilitiesUnitSemiRoomStandeirdMoneyText.setColumns(4);

      careOldPeopleHealthFacilitiesUnitSemiRoomStandeirdMoneyText.setCharType(VRCharType.ONLY_DIGIT);

      careOldPeopleHealthFacilitiesUnitSemiRoomStandeirdMoneyText.setHorizontalAlignment(SwingConstants.RIGHT);

      careOldPeopleHealthFacilitiesUnitSemiRoomStandeirdMoneyText.setIMEMode(InputSubset.LATIN);

      careOldPeopleHealthFacilitiesUnitSemiRoomStandeirdMoneyText.setMaxLength(4);

      addCareOldPeopleHealthFacilitiesUnitSemiRoomStandeirdMoneyText();
    }
    return careOldPeopleHealthFacilitiesUnitSemiRoomStandeirdMoneyText;

  }

  /**
   * ���j�b�g�^������z�E���x�����擾���܂��B
   * @return ���j�b�g�^������z�E���x��
   */
  public ACLabel getCareOldPeopleHealthFacilitiesUnitSemiRoomStandeirdMoneyLabel(){
    if(careOldPeopleHealthFacilitiesUnitSemiRoomStandeirdMoneyLabel==null){

      careOldPeopleHealthFacilitiesUnitSemiRoomStandeirdMoneyLabel = new ACLabel();

      careOldPeopleHealthFacilitiesUnitSemiRoomStandeirdMoneyLabel.setText("�i�~�j");

      addCareOldPeopleHealthFacilitiesUnitSemiRoomStandeirdMoneyLabel();
    }
    return careOldPeopleHealthFacilitiesUnitSemiRoomStandeirdMoneyLabel;

  }

  /**
   * �]���^����z�E�R���e�i���擾���܂��B
   * @return �]���^����z�E�R���e�i
   */
  public ACLabelContainer getCareOldPeopleHealthFacilitiesNormalRoomStandeirdMoneyConteiner(){
    if(careOldPeopleHealthFacilitiesNormalRoomStandeirdMoneyConteiner==null){

      careOldPeopleHealthFacilitiesNormalRoomStandeirdMoneyConteiner = new ACLabelContainer();

      careOldPeopleHealthFacilitiesNormalRoomStandeirdMoneyConteiner.setText("�]���^����z");

      careOldPeopleHealthFacilitiesNormalRoomStandeirdMoneyConteiner.setFollowChildEnabled(true);

      addCareOldPeopleHealthFacilitiesNormalRoomStandeirdMoneyConteiner();
    }
    return careOldPeopleHealthFacilitiesNormalRoomStandeirdMoneyConteiner;

  }

  /**
   * �]���^����z�E�e�L�X�g���擾���܂��B
   * @return �]���^����z�E�e�L�X�g
   */
  public ACTextField getCareOldPeopleHealthFacilitiesNormalRoomStandeirdMoneyText(){
    if(careOldPeopleHealthFacilitiesNormalRoomStandeirdMoneyText==null){

      careOldPeopleHealthFacilitiesNormalRoomStandeirdMoneyText = new ACTextField();

      careOldPeopleHealthFacilitiesNormalRoomStandeirdMoneyText.setBindPath("1520116");

      careOldPeopleHealthFacilitiesNormalRoomStandeirdMoneyText.setColumns(4);

      careOldPeopleHealthFacilitiesNormalRoomStandeirdMoneyText.setCharType(VRCharType.ONLY_DIGIT);

      careOldPeopleHealthFacilitiesNormalRoomStandeirdMoneyText.setHorizontalAlignment(SwingConstants.RIGHT);

      careOldPeopleHealthFacilitiesNormalRoomStandeirdMoneyText.setIMEMode(InputSubset.LATIN);

      careOldPeopleHealthFacilitiesNormalRoomStandeirdMoneyText.setMaxLength(4);

      addCareOldPeopleHealthFacilitiesNormalRoomStandeirdMoneyText();
    }
    return careOldPeopleHealthFacilitiesNormalRoomStandeirdMoneyText;

  }

  /**
   * �]���^����z�E���x�����擾���܂��B
   * @return �]���^����z�E���x��
   */
  public ACLabel getCareOldPeopleHealthFacilitiesNormalRoomStandeirdMoneyLabel(){
    if(careOldPeopleHealthFacilitiesNormalRoomStandeirdMoneyLabel==null){

      careOldPeopleHealthFacilitiesNormalRoomStandeirdMoneyLabel = new ACLabel();

      careOldPeopleHealthFacilitiesNormalRoomStandeirdMoneyLabel.setText("�i�~�j");

      addCareOldPeopleHealthFacilitiesNormalRoomStandeirdMoneyLabel();
    }
    return careOldPeopleHealthFacilitiesNormalRoomStandeirdMoneyLabel;

  }

  /**
   * ��������z�E�R���e�i���擾���܂��B
   * @return ��������z�E�R���e�i
   */
  public ACLabelContainer getCareOldPeopleHealthFacilitiesTasyouRoomConteiner(){
    if(careOldPeopleHealthFacilitiesTasyouRoomConteiner==null){

      careOldPeopleHealthFacilitiesTasyouRoomConteiner = new ACLabelContainer();

      careOldPeopleHealthFacilitiesTasyouRoomConteiner.setText("��������z");

      careOldPeopleHealthFacilitiesTasyouRoomConteiner.setFollowChildEnabled(true);

      addCareOldPeopleHealthFacilitiesTasyouRoomConteiner();
    }
    return careOldPeopleHealthFacilitiesTasyouRoomConteiner;

  }

  /**
   * ��������z�E�e�L�X�g���擾���܂��B
   * @return ��������z�E�e�L�X�g
   */
  public ACTextField getCareOldPeopleHealthFacilitiesTasyouRoomText(){
    if(careOldPeopleHealthFacilitiesTasyouRoomText==null){

      careOldPeopleHealthFacilitiesTasyouRoomText = new ACTextField();

      careOldPeopleHealthFacilitiesTasyouRoomText.setBindPath("1520117");

      careOldPeopleHealthFacilitiesTasyouRoomText.setColumns(4);

      careOldPeopleHealthFacilitiesTasyouRoomText.setCharType(VRCharType.ONLY_DIGIT);

      careOldPeopleHealthFacilitiesTasyouRoomText.setHorizontalAlignment(SwingConstants.RIGHT);

      careOldPeopleHealthFacilitiesTasyouRoomText.setIMEMode(InputSubset.LATIN);

      careOldPeopleHealthFacilitiesTasyouRoomText.setMaxLength(4);

      addCareOldPeopleHealthFacilitiesTasyouRoomText();
    }
    return careOldPeopleHealthFacilitiesTasyouRoomText;

  }

  /**
   * ��������z�E���x�����擾���܂��B
   * @return ��������z�E���x��
   */
  public ACLabel getCareOldPeopleHealthFacilitiesTasyouRoomLabel(){
    if(careOldPeopleHealthFacilitiesTasyouRoomLabel==null){

      careOldPeopleHealthFacilitiesTasyouRoomLabel = new ACLabel();

      careOldPeopleHealthFacilitiesTasyouRoomLabel.setText("�i�~�j");

      addCareOldPeopleHealthFacilitiesTasyouRoomLabel();
    }
    return careOldPeopleHealthFacilitiesTasyouRoomLabel;

  }

  /**
   * �R���X�g���N�^�ł��B
   */
  public QO004017Design() {

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

    this.add(getAgedPeopleHealthFacilityGroup(), VRLayout.CLIENT);

  }

  /**
   * ���ƃO���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addAgedPeopleHealthFacilityGroup(){

    agedPeopleHealthFacilityGroup.add(getAgedPeopleHealthFacilityDiscountContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    agedPeopleHealthFacilityGroup.add(getInstitutionDivisionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    agedPeopleHealthFacilityGroup.add(getNightShiftConditionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    agedPeopleHealthFacilityGroup.add(getRehabilitationFunctionalEnhancementContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    agedPeopleHealthFacilityGroup.add(getDementiaSpecialBuildingContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    agedPeopleHealthFacilityGroup.add(getNutritionManageRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    agedPeopleHealthFacilityGroup.add(getNutritionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    agedPeopleHealthFacilityGroup.add(getOralSwitchRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    agedPeopleHealthFacilityGroup.add(getRecuperateDinnerRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    agedPeopleHealthFacilityGroup.add(getStaffLackContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    agedPeopleHealthFacilityGroup.add(getCareOldPeopleHealthFacilitiesDinnerStandeirdMoneyConteiner(), VRLayout.FLOW_INSETLINE_RETURN);

    agedPeopleHealthFacilityGroup.add(getCareOldPeopleHealthFacilitiesUnitRoomStandeirdMoneyConteiner(), VRLayout.FLOW_INSETLINE_RETURN);

    agedPeopleHealthFacilityGroup.add(getCareOldPeopleHealthFacilitiesUnitSemiRoomStandeirdMoneyConteiner(), VRLayout.FLOW_INSETLINE_RETURN);

    agedPeopleHealthFacilityGroup.add(getCareOldPeopleHealthFacilitiesNormalRoomStandeirdMoneyConteiner(), VRLayout.FLOW_INSETLINE_RETURN);

    agedPeopleHealthFacilityGroup.add(getCareOldPeopleHealthFacilitiesTasyouRoomConteiner(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * �������R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addAgedPeopleHealthFacilityDiscountContainer(){

    agedPeopleHealthFacilityDiscountContainer.add(getAgedPeopleHealthFacilityDiscountRate(), VRLayout.FLOW);

    agedPeopleHealthFacilityDiscountContainer.add(getPercentSign(), VRLayout.FLOW);

  }

  /**
   * �������ɓ������ڂ�ǉ����܂��B
   */
  protected void addAgedPeopleHealthFacilityDiscountRate(){

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
   * ���ی��{�݂ɓ������ڂ�ǉ����܂��B
   */
  protected void addInstitutionDivisionRadioItem1(){

  }

  /**
   * ���j�b�g�^���ی��{�݂ɓ������ڂ�ǉ����܂��B
   */
  protected void addInstitutionDivisionRadioItem2(){

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
   * ���n�r���e�[�V�����@�\�������W�I�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addRehabilitationFunctionalEnhancement(){

  }

  /**
   * ���n�r���e�[�V�����@�\�������W�I�O���[�v���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addRehabilitationFunctionalEnhancementModel(){

    getRehabilitationFunctionalEnhancementOff().setButtonIndex(1);
    getRehabilitationFunctionalEnhancementModel().add(getRehabilitationFunctionalEnhancementOff());

    getRehabilitationFunctionalEnhancementOn().setButtonIndex(2);
    getRehabilitationFunctionalEnhancementModel().add(getRehabilitationFunctionalEnhancementOn());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addRehabilitationFunctionalEnhancementOff(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addRehabilitationFunctionalEnhancementOn(){

  }

  /**
   * �F�m�ǐ�哏���W�I�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addDementiaSpecialBuilding(){

  }

  /**
   * �F�m�ǐ�哏���W�I�O���[�v���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addDementiaSpecialBuildingModel(){

    getDementiaSpecialBuildingOff().setButtonIndex(1);
    getDementiaSpecialBuildingModel().add(getDementiaSpecialBuildingOff());

    getDementiaSpecialBuildingOn().setButtonIndex(2);
    getDementiaSpecialBuildingModel().add(getDementiaSpecialBuildingOn());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addDementiaSpecialBuildingOff(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addDementiaSpecialBuildingOn(){

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

    getStaffLackExcess().setButtonIndex(2);
    getStaffLackModel().add(getStaffLackExcess());

    getStaffLackKango().setButtonIndex(3);
    getStaffLackModel().add(getStaffLackKango());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffLackOff(){

  }

  /**
   * ������߂ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffLackExcess(){

  }

  /**
   * �Ō�E���E�����͈�t�APT�EOT�A���x�������̕s���ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffLackKango(){

  }

  /**
   * �H���z�E�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addCareOldPeopleHealthFacilitiesDinnerStandeirdMoneyConteiner(){

    careOldPeopleHealthFacilitiesDinnerStandeirdMoneyConteiner.add(getCareOldPeopleHealthFacilitiesDinnerStandeirdMoneyTotal(), VRLayout.FLOW);

    careOldPeopleHealthFacilitiesDinnerStandeirdMoneyConteiner.add(getCareOldPeopleHealthFacilitiesMorningDinnerStandeirdMoneyLabel(), VRLayout.FLOW);

    careOldPeopleHealthFacilitiesDinnerStandeirdMoneyConteiner.add(getCareOldPeopleHealthFacilitiesMorningDinnerStandeirdMoney(), VRLayout.FLOW);

    careOldPeopleHealthFacilitiesDinnerStandeirdMoneyConteiner.add(getCareOldPeopleHealthFacilitiesNoonDinnerStandeirdMoneyLabel(), VRLayout.FLOW);

    careOldPeopleHealthFacilitiesDinnerStandeirdMoneyConteiner.add(getCareOldPeopleHealthFacilitiesNoonDinnerStandeirdMoney(), VRLayout.FLOW);

    careOldPeopleHealthFacilitiesDinnerStandeirdMoneyConteiner.add(getCareOldPeopleHealthFacilitiesNightDinnerStandeirdMoneyLabel(), VRLayout.FLOW);

    careOldPeopleHealthFacilitiesDinnerStandeirdMoneyConteiner.add(getCareOldPeopleHealthFacilitiesNightDinnerStandeirdMoney(), VRLayout.FLOW);

    careOldPeopleHealthFacilitiesDinnerStandeirdMoneyConteiner.add(getCareOldPeopleHealthFacilitiesTotalDinnerStandeirdMoneyDenominationLabel(), VRLayout.FLOW);

  }

  /**
   * �H���z�E���v�E�e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addCareOldPeopleHealthFacilitiesDinnerStandeirdMoneyTotal(){

  }

  /**
   * �H���z�E���E���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCareOldPeopleHealthFacilitiesMorningDinnerStandeirdMoneyLabel(){

  }

  /**
   * �H���z�E���E�e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addCareOldPeopleHealthFacilitiesMorningDinnerStandeirdMoney(){

  }

  /**
   * �H���z�E���E���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCareOldPeopleHealthFacilitiesNoonDinnerStandeirdMoneyLabel(){

  }

  /**
   * �H���z�E���E�e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addCareOldPeopleHealthFacilitiesNoonDinnerStandeirdMoney(){

  }

  /**
   * �H���z�E��E���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCareOldPeopleHealthFacilitiesNightDinnerStandeirdMoneyLabel(){

  }

  /**
   * �H���z�E��E�e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addCareOldPeopleHealthFacilitiesNightDinnerStandeirdMoney(){

  }

  /**
   * �H���z�E���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCareOldPeopleHealthFacilitiesTotalDinnerStandeirdMoneyDenominationLabel(){

  }

  /**
   * ���j�b�g�^����z�E�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addCareOldPeopleHealthFacilitiesUnitRoomStandeirdMoneyConteiner(){

    careOldPeopleHealthFacilitiesUnitRoomStandeirdMoneyConteiner.add(getCareOldPeopleHealthFacilitiesUnitRoomStandeirdMoneyText(), null);

    careOldPeopleHealthFacilitiesUnitRoomStandeirdMoneyConteiner.add(getCareOldPeopleHealthFacilitiesUnitRoomStandeirdMoneyLabel(), null);

  }

  /**
   * ���j�b�g�^����z�E�e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addCareOldPeopleHealthFacilitiesUnitRoomStandeirdMoneyText(){

  }

  /**
   * ���j�b�g�^����z�E���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCareOldPeopleHealthFacilitiesUnitRoomStandeirdMoneyLabel(){

  }

  /**
   * ���j�b�g�^������z�E�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addCareOldPeopleHealthFacilitiesUnitSemiRoomStandeirdMoneyConteiner(){

    careOldPeopleHealthFacilitiesUnitSemiRoomStandeirdMoneyConteiner.add(getCareOldPeopleHealthFacilitiesUnitSemiRoomStandeirdMoneyText(), null);

    careOldPeopleHealthFacilitiesUnitSemiRoomStandeirdMoneyConteiner.add(getCareOldPeopleHealthFacilitiesUnitSemiRoomStandeirdMoneyLabel(), null);

  }

  /**
   * ���j�b�g�^������z�E�e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addCareOldPeopleHealthFacilitiesUnitSemiRoomStandeirdMoneyText(){

  }

  /**
   * ���j�b�g�^������z�E���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCareOldPeopleHealthFacilitiesUnitSemiRoomStandeirdMoneyLabel(){

  }

  /**
   * �]���^����z�E�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addCareOldPeopleHealthFacilitiesNormalRoomStandeirdMoneyConteiner(){

    careOldPeopleHealthFacilitiesNormalRoomStandeirdMoneyConteiner.add(getCareOldPeopleHealthFacilitiesNormalRoomStandeirdMoneyText(), null);

    careOldPeopleHealthFacilitiesNormalRoomStandeirdMoneyConteiner.add(getCareOldPeopleHealthFacilitiesNormalRoomStandeirdMoneyLabel(), null);

  }

  /**
   * �]���^����z�E�e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addCareOldPeopleHealthFacilitiesNormalRoomStandeirdMoneyText(){

  }

  /**
   * �]���^����z�E���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCareOldPeopleHealthFacilitiesNormalRoomStandeirdMoneyLabel(){

  }

  /**
   * ��������z�E�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addCareOldPeopleHealthFacilitiesTasyouRoomConteiner(){

    careOldPeopleHealthFacilitiesTasyouRoomConteiner.add(getCareOldPeopleHealthFacilitiesTasyouRoomText(), null);

    careOldPeopleHealthFacilitiesTasyouRoomConteiner.add(getCareOldPeopleHealthFacilitiesTasyouRoomLabel(), null);

  }

  /**
   * ��������z�E�e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addCareOldPeopleHealthFacilitiesTasyouRoomText(){

  }

  /**
   * ��������z�E���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCareOldPeopleHealthFacilitiesTasyouRoomLabel(){

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
      ACFrame.getInstance().getContentPane().add(new QO004017Design());
      ACFrame.getInstance().setVisible(true);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QO004017Design getThis() {
    return this;
  }
}
