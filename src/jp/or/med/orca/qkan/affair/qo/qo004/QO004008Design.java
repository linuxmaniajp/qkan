
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
 * �v���O���� ���Ǝғo�^(�Z�������������) (QO004008)
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
 * ���Ǝғo�^(�Z�������������)��ʍ��ڃf�U�C��(QO004008) 
 */
public class QO004008Design extends ACPanel {
  //GUI�R���|�[�l���g

  private ACGroupBox shortStayLifeGroup;

  private ACLabelContainer shortStayLifeDiscountContainer;

  private ACTextField shortStayLifeDiscountRate;

  private ACLabel shortStayPercentSign;

  private ACClearableRadioButtonGroup shortStayLifeFacilitiesDivision;

  private ACLabelContainer shortStayLifeFacilitiesDivisionContainer;

  private ACListModelAdapter shortStayLifeFacilitiesDivisionModel;

  private ACRadioButtonItem shortStayLifeSingle;

  private ACRadioButtonItem shortStayLifeDouble;

  private ACRadioButtonItem shortStayLifeSmall;

  private ACRadioButtonItem shortStayLifeDoubleSmall;

  private ACClearableRadioButtonGroup shortStayNightWorkDivision;

  private ACLabelContainer shortStayNightWorkDivisionContainer;

  private ACListModelAdapter shortStayNightWorkDivisionModel;

  private ACRadioButtonItem shortStayLifeNightWorkDivisionFill;

  private ACRadioButtonItem shortStayNightWorkDivisionNotFill;

  private ACClearableRadioButtonGroup shortStayLifeFunctionTrainingGuidanceSystem;

  private ACLabelContainer shortStayLifeFunctionTrainingGuidanceSystemContainer;

  private ACListModelAdapter shortStayLifeFunctionTrainingGuidanceSystemModel;

  private ACRadioButtonItem shortStayFunctionTrainingGuidanceSystemOff;

  private ACRadioButtonItem shortStayLifeFunctionTrainingGuidanceSystemOn;

  private ACClearableRadioButtonGroup shortStayMeetingAndSendingOffSystem;

  private ACLabelContainer shortStayMeetingAndSendingOffSystemContainer;

  private ACListModelAdapter shortStayMeetingAndSendingOffSystemModel;

  private ACRadioButtonItem shortStayLifeMeetingAndSendingOffSystemOff;

  private ACRadioButtonItem shortStayMeetingAndSendingOffSystemOn;

  private ACClearableRadioButtonGroup shortStayLifeNutritionManageRadio;

  private ACLabelContainer shortStayLifeNutritionManageRadioContainer;

  private ACListModelAdapter shortStayLifeNutritionManageRadioModel;

  private ACRadioButtonItem shortStayLifeNutritionManageRadioItem1;

  private ACRadioButtonItem shortStayLifeNutritionManageRadioItem2;

  private ACClearableRadioButtonGroup shortStayLifeRecuperatDinnerRadio;

  private ACLabelContainer shortStayLifeRecuperatDinnerRadioContainer;

  private ACListModelAdapter shortStayLifeRecuperatDinnerRadioModel;

  private ACRadioButtonItem shortStayLifeRecuperatDinnerRadioItem1;

  private ACRadioButtonItem shortStayLifeRecuperatDinnerRadioItem2;

  private ACClearableRadioButtonGroup shortStayStaffReduceRadio;

  private ACLabelContainer shortStayStaffReduceRadioContainer;

  private ACListModelAdapter shortStayStaffReduceRadioModel;

  private ACRadioButtonItem shortStayStaffNot;

  private ACRadioButtonItem shortStayStaffExcess;

  private ACRadioButtonItem shortStayStaffShortage;

  private ACLabelContainer shortStayDinnerStandardMoneyConteiner;

  private ACTextField shortStayDinnerStandardMoneyTotal;

  private ACLabel shortStayMorningDinnerStandardMoneyLabel;

  private ACTextField shortStayMorningDinnerStandardMoney;

  private ACLabel shortStayNoonDinnerStandardMoneyLabel;

  private ACTextField shortStayNoonDinnerStandardMoney;

  private ACLabel shortStayNightDinnerStandardMoneyLabel;

  private ACTextField shortStayNightDinnerStandardMoney;

  private ACLabel shortStayDinnerStandardMoneyDenomination;

  private ACLabelContainer shortStayUnitRoomStandardMoneyConteiner;

  private ACTextField shortStayUnitRoomStandardMoneyText;

  private ACLabel shortStayUnitRoomStandardMoneyLabel;

  private ACLabelContainer shortStayUnitSemiRoomStandardMoneyConteiner;

  private ACTextField shortStayUnitSemiRoomStandardMoneyText;

  private ACLabel shortStayUnitSemiRoomStandardMoneyLabel;

  private ACLabelContainer shortStayNormalRoomStandardMoneyConteiner;

  private ACTextField shortStayNormalRoomStandardMoneyText;

  private ACLabel shortStayNormalRoomStandardMoneyLabel;

  private ACLabelContainer shortStayTasyouRoomConteiner;

  private ACTextField shortStayTasyouRoomText;

  private ACLabel shortStayTasyouRoomLabel;

  //getter

  /**
   * ���ƃO���[�v���擾���܂��B
   * @return ���ƃO���[�v
   */
  public ACGroupBox getShortStayLifeGroup(){
    if(shortStayLifeGroup==null){

      shortStayLifeGroup = new ACGroupBox();

      shortStayLifeGroup.setText("�Z�������������");

      shortStayLifeGroup.setFollowChildEnabled(true);

      shortStayLifeGroup.setHgrid(200);

      addShortStayLifeGroup();
    }
    return shortStayLifeGroup;

  }

  /**
   * �������R���e�i���擾���܂��B
   * @return �������R���e�i
   */
  public ACLabelContainer getShortStayLifeDiscountContainer(){
    if(shortStayLifeDiscountContainer==null){

      shortStayLifeDiscountContainer = new ACLabelContainer();

      shortStayLifeDiscountContainer.setText("������");

      shortStayLifeDiscountContainer.setFollowChildEnabled(true);

      addShortStayLifeDiscountContainer();
    }
    return shortStayLifeDiscountContainer;

  }

  /**
   * ���������擾���܂��B
   * @return ������
   */
  public ACTextField getShortStayLifeDiscountRate(){
    if(shortStayLifeDiscountRate==null){

      shortStayLifeDiscountRate = new ACTextField();

      shortStayLifeDiscountRate.setBindPath("REDUCT_RATE");

      shortStayLifeDiscountRate.setColumns(3);

      shortStayLifeDiscountRate.setCharType(VRCharType.ONLY_DIGIT);

      shortStayLifeDiscountRate.setHorizontalAlignment(SwingConstants.RIGHT);

      shortStayLifeDiscountRate.setIMEMode(InputSubset.LATIN);

      shortStayLifeDiscountRate.setMaxLength(3);

      addShortStayLifeDiscountRate();
    }
    return shortStayLifeDiscountRate;

  }

  /**
   * �����x�����擾���܂��B
   * @return �����x��
   */
  public ACLabel getShortStayPercentSign(){
    if(shortStayPercentSign==null){

      shortStayPercentSign = new ACLabel();

      shortStayPercentSign.setText("��");

      addShortStayPercentSign();
    }
    return shortStayPercentSign;

  }

  /**
   * �{�݋敪���W�I�O���[�v���擾���܂��B
   * @return �{�݋敪���W�I�O���[�v
   */
  public ACClearableRadioButtonGroup getShortStayLifeFacilitiesDivision(){
    if(shortStayLifeFacilitiesDivision==null){

      shortStayLifeFacilitiesDivision = new ACClearableRadioButtonGroup();

      getShortStayLifeFacilitiesDivisionContainer().setText("�{�݋敪");

      shortStayLifeFacilitiesDivision.setBindPath("1210101");

      shortStayLifeFacilitiesDivision.setModel(getShortStayLifeFacilitiesDivisionModel());

      shortStayLifeFacilitiesDivision.setUseClearButton(false);

      addShortStayLifeFacilitiesDivision();
    }
    return shortStayLifeFacilitiesDivision;

  }

  /**
   * �{�݋敪���W�I�O���[�v�R���e�i���擾���܂��B
   * @return �{�݋敪���W�I�O���[�v�R���e�i
   */
  protected ACLabelContainer getShortStayLifeFacilitiesDivisionContainer(){
    if(shortStayLifeFacilitiesDivisionContainer==null){
      shortStayLifeFacilitiesDivisionContainer = new ACLabelContainer();
      shortStayLifeFacilitiesDivisionContainer.setFollowChildEnabled(true);
      shortStayLifeFacilitiesDivisionContainer.add(getShortStayLifeFacilitiesDivision(), null);
    }
    return shortStayLifeFacilitiesDivisionContainer;
  }

  /**
   * �{�݋敪���W�I�O���[�v���f�����擾���܂��B
   * @return �{�݋敪���W�I�O���[�v���f��
   */
  protected ACListModelAdapter getShortStayLifeFacilitiesDivisionModel(){
    if(shortStayLifeFacilitiesDivisionModel==null){
      shortStayLifeFacilitiesDivisionModel = new ACListModelAdapter();
      addShortStayLifeFacilitiesDivisionModel();
    }
    return shortStayLifeFacilitiesDivisionModel;
  }

  /**
   * �P�ƌ^���擾���܂��B
   * @return �P�ƌ^
   */
  public ACRadioButtonItem getShortStayLifeSingle(){
    if(shortStayLifeSingle==null){

      shortStayLifeSingle = new ACRadioButtonItem();

      shortStayLifeSingle.setText("�P�ƌ^");

      shortStayLifeSingle.setGroup(getShortStayLifeFacilitiesDivision());

      addShortStayLifeSingle();
    }
    return shortStayLifeSingle;

  }

  /**
   * ���݌^���擾���܂��B
   * @return ���݌^
   */
  public ACRadioButtonItem getShortStayLifeDouble(){
    if(shortStayLifeDouble==null){

      shortStayLifeDouble = new ACRadioButtonItem();

      shortStayLifeDouble.setText("���݌^");

      shortStayLifeDouble.setGroup(getShortStayLifeFacilitiesDivision());

      addShortStayLifeDouble();
    }
    return shortStayLifeDouble;

  }

  /**
   * �P�Ə��K�͌^���擾���܂��B
   * @return �P�Ə��K�͌^
   */
  public ACRadioButtonItem getShortStayLifeSmall(){
    if(shortStayLifeSmall==null){

      shortStayLifeSmall = new ACRadioButtonItem();

      shortStayLifeSmall.setText("�P�ƌ^���j�b�g�^");

      shortStayLifeSmall.setGroup(getShortStayLifeFacilitiesDivision());

      addShortStayLifeSmall();
    }
    return shortStayLifeSmall;

  }

  /**
   * ���ݏ��K�͌^���擾���܂��B
   * @return ���ݏ��K�͌^
   */
  public ACRadioButtonItem getShortStayLifeDoubleSmall(){
    if(shortStayLifeDoubleSmall==null){

      shortStayLifeDoubleSmall = new ACRadioButtonItem();

      shortStayLifeDoubleSmall.setText("���݌^���j�b�g�^");

      shortStayLifeDoubleSmall.setGroup(getShortStayLifeFacilitiesDivision());

      addShortStayLifeDoubleSmall();
    }
    return shortStayLifeDoubleSmall;

  }

  /**
   * ��ԋΖ���������W�I�O���[�v���擾���܂��B
   * @return ��ԋΖ���������W�I�O���[�v
   */
  public ACClearableRadioButtonGroup getShortStayNightWorkDivision(){
    if(shortStayNightWorkDivision==null){

      shortStayNightWorkDivision = new ACClearableRadioButtonGroup();

      getShortStayNightWorkDivisionContainer().setText("��ԋΖ������");

      shortStayNightWorkDivision.setBindPath("1210102");

      shortStayNightWorkDivision.setModel(getShortStayNightWorkDivisionModel());

      shortStayNightWorkDivision.setUseClearButton(false);

      addShortStayNightWorkDivision();
    }
    return shortStayNightWorkDivision;

  }

  /**
   * ��ԋΖ���������W�I�O���[�v�R���e�i���擾���܂��B
   * @return ��ԋΖ���������W�I�O���[�v�R���e�i
   */
  protected ACLabelContainer getShortStayNightWorkDivisionContainer(){
    if(shortStayNightWorkDivisionContainer==null){
      shortStayNightWorkDivisionContainer = new ACLabelContainer();
      shortStayNightWorkDivisionContainer.setFollowChildEnabled(true);
      shortStayNightWorkDivisionContainer.add(getShortStayNightWorkDivision(), null);
    }
    return shortStayNightWorkDivisionContainer;
  }

  /**
   * ��ԋΖ���������W�I�O���[�v���f�����擾���܂��B
   * @return ��ԋΖ���������W�I�O���[�v���f��
   */
  protected ACListModelAdapter getShortStayNightWorkDivisionModel(){
    if(shortStayNightWorkDivisionModel==null){
      shortStayNightWorkDivisionModel = new ACListModelAdapter();
      addShortStayNightWorkDivisionModel();
    }
    return shortStayNightWorkDivisionModel;
  }

  /**
   * ��^���擾���܂��B
   * @return ��^
   */
  public ACRadioButtonItem getShortStayLifeNightWorkDivisionFill(){
    if(shortStayLifeNightWorkDivisionFill==null){

      shortStayLifeNightWorkDivisionFill = new ACRadioButtonItem();

      shortStayLifeNightWorkDivisionFill.setText("��^");

      shortStayLifeNightWorkDivisionFill.setGroup(getShortStayNightWorkDivision());

      addShortStayLifeNightWorkDivisionFill();
    }
    return shortStayLifeNightWorkDivisionFill;

  }

  /**
   * ���Z�^���擾���܂��B
   * @return ���Z�^
   */
  public ACRadioButtonItem getShortStayNightWorkDivisionNotFill(){
    if(shortStayNightWorkDivisionNotFill==null){

      shortStayNightWorkDivisionNotFill = new ACRadioButtonItem();

      shortStayNightWorkDivisionNotFill.setText("���Z�^");

      shortStayNightWorkDivisionNotFill.setGroup(getShortStayNightWorkDivision());

      addShortStayNightWorkDivisionNotFill();
    }
    return shortStayNightWorkDivisionNotFill;

  }

  /**
   * �@�\�P���w���̐����W�I�O���[�v���擾���܂��B
   * @return �@�\�P���w���̐����W�I�O���[�v
   */
  public ACClearableRadioButtonGroup getShortStayLifeFunctionTrainingGuidanceSystem(){
    if(shortStayLifeFunctionTrainingGuidanceSystem==null){

      shortStayLifeFunctionTrainingGuidanceSystem = new ACClearableRadioButtonGroup();

      getShortStayLifeFunctionTrainingGuidanceSystemContainer().setText("�@�\�P���w���̐�");

      shortStayLifeFunctionTrainingGuidanceSystem.setBindPath("1210103");

      shortStayLifeFunctionTrainingGuidanceSystem.setModel(getShortStayLifeFunctionTrainingGuidanceSystemModel());

      shortStayLifeFunctionTrainingGuidanceSystem.setUseClearButton(false);

      addShortStayLifeFunctionTrainingGuidanceSystem();
    }
    return shortStayLifeFunctionTrainingGuidanceSystem;

  }

  /**
   * �@�\�P���w���̐����W�I�O���[�v�R���e�i���擾���܂��B
   * @return �@�\�P���w���̐����W�I�O���[�v�R���e�i
   */
  protected ACLabelContainer getShortStayLifeFunctionTrainingGuidanceSystemContainer(){
    if(shortStayLifeFunctionTrainingGuidanceSystemContainer==null){
      shortStayLifeFunctionTrainingGuidanceSystemContainer = new ACLabelContainer();
      shortStayLifeFunctionTrainingGuidanceSystemContainer.setFollowChildEnabled(true);
      shortStayLifeFunctionTrainingGuidanceSystemContainer.add(getShortStayLifeFunctionTrainingGuidanceSystem(), null);
    }
    return shortStayLifeFunctionTrainingGuidanceSystemContainer;
  }

  /**
   * �@�\�P���w���̐����W�I�O���[�v���f�����擾���܂��B
   * @return �@�\�P���w���̐����W�I�O���[�v���f��
   */
  protected ACListModelAdapter getShortStayLifeFunctionTrainingGuidanceSystemModel(){
    if(shortStayLifeFunctionTrainingGuidanceSystemModel==null){
      shortStayLifeFunctionTrainingGuidanceSystemModel = new ACListModelAdapter();
      addShortStayLifeFunctionTrainingGuidanceSystemModel();
    }
    return shortStayLifeFunctionTrainingGuidanceSystemModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getShortStayFunctionTrainingGuidanceSystemOff(){
    if(shortStayFunctionTrainingGuidanceSystemOff==null){

      shortStayFunctionTrainingGuidanceSystemOff = new ACRadioButtonItem();

      shortStayFunctionTrainingGuidanceSystemOff.setText("�Ȃ�");

      shortStayFunctionTrainingGuidanceSystemOff.setGroup(getShortStayLifeFunctionTrainingGuidanceSystem());

      addShortStayFunctionTrainingGuidanceSystemOff();
    }
    return shortStayFunctionTrainingGuidanceSystemOff;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getShortStayLifeFunctionTrainingGuidanceSystemOn(){
    if(shortStayLifeFunctionTrainingGuidanceSystemOn==null){

      shortStayLifeFunctionTrainingGuidanceSystemOn = new ACRadioButtonItem();

      shortStayLifeFunctionTrainingGuidanceSystemOn.setText("����");

      shortStayLifeFunctionTrainingGuidanceSystemOn.setGroup(getShortStayLifeFunctionTrainingGuidanceSystem());

      addShortStayLifeFunctionTrainingGuidanceSystemOn();
    }
    return shortStayLifeFunctionTrainingGuidanceSystemOn;

  }

  /**
   * ���}�̐����W�I�O���[�v���擾���܂��B
   * @return ���}�̐����W�I�O���[�v
   */
  public ACClearableRadioButtonGroup getShortStayMeetingAndSendingOffSystem(){
    if(shortStayMeetingAndSendingOffSystem==null){

      shortStayMeetingAndSendingOffSystem = new ACClearableRadioButtonGroup();

      getShortStayMeetingAndSendingOffSystemContainer().setText("���}�̐�");

      shortStayMeetingAndSendingOffSystem.setBindPath("1210104");

      shortStayMeetingAndSendingOffSystem.setModel(getShortStayMeetingAndSendingOffSystemModel());

      shortStayMeetingAndSendingOffSystem.setUseClearButton(false);

      addShortStayMeetingAndSendingOffSystem();
    }
    return shortStayMeetingAndSendingOffSystem;

  }

  /**
   * ���}�̐����W�I�O���[�v�R���e�i���擾���܂��B
   * @return ���}�̐����W�I�O���[�v�R���e�i
   */
  protected ACLabelContainer getShortStayMeetingAndSendingOffSystemContainer(){
    if(shortStayMeetingAndSendingOffSystemContainer==null){
      shortStayMeetingAndSendingOffSystemContainer = new ACLabelContainer();
      shortStayMeetingAndSendingOffSystemContainer.setFollowChildEnabled(true);
      shortStayMeetingAndSendingOffSystemContainer.add(getShortStayMeetingAndSendingOffSystem(), null);
    }
    return shortStayMeetingAndSendingOffSystemContainer;
  }

  /**
   * ���}�̐����W�I�O���[�v���f�����擾���܂��B
   * @return ���}�̐����W�I�O���[�v���f��
   */
  protected ACListModelAdapter getShortStayMeetingAndSendingOffSystemModel(){
    if(shortStayMeetingAndSendingOffSystemModel==null){
      shortStayMeetingAndSendingOffSystemModel = new ACListModelAdapter();
      addShortStayMeetingAndSendingOffSystemModel();
    }
    return shortStayMeetingAndSendingOffSystemModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getShortStayLifeMeetingAndSendingOffSystemOff(){
    if(shortStayLifeMeetingAndSendingOffSystemOff==null){

      shortStayLifeMeetingAndSendingOffSystemOff = new ACRadioButtonItem();

      shortStayLifeMeetingAndSendingOffSystemOff.setText("�Ȃ�");

      shortStayLifeMeetingAndSendingOffSystemOff.setGroup(getShortStayMeetingAndSendingOffSystem());

      addShortStayLifeMeetingAndSendingOffSystemOff();
    }
    return shortStayLifeMeetingAndSendingOffSystemOff;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getShortStayMeetingAndSendingOffSystemOn(){
    if(shortStayMeetingAndSendingOffSystemOn==null){

      shortStayMeetingAndSendingOffSystemOn = new ACRadioButtonItem();

      shortStayMeetingAndSendingOffSystemOn.setText("����");

      shortStayMeetingAndSendingOffSystemOn.setGroup(getShortStayMeetingAndSendingOffSystem());

      addShortStayMeetingAndSendingOffSystemOn();
    }
    return shortStayMeetingAndSendingOffSystemOn;

  }

  /**
   * �h�{�Ǘ��̐����W�I�O���[�v���擾���܂��B
   * @return �h�{�Ǘ��̐����W�I�O���[�v
   */
  public ACClearableRadioButtonGroup getShortStayLifeNutritionManageRadio(){
    if(shortStayLifeNutritionManageRadio==null){

      shortStayLifeNutritionManageRadio = new ACClearableRadioButtonGroup();

      getShortStayLifeNutritionManageRadioContainer().setText("�h�{�Ǘ��̐�");

      shortStayLifeNutritionManageRadio.setBindPath("1210105");

      shortStayLifeNutritionManageRadio.setModel(getShortStayLifeNutritionManageRadioModel());

      shortStayLifeNutritionManageRadio.setUseClearButton(false);

      addShortStayLifeNutritionManageRadio();
    }
    return shortStayLifeNutritionManageRadio;

  }

  /**
   * �h�{�Ǘ��̐����W�I�O���[�v�R���e�i���擾���܂��B
   * @return �h�{�Ǘ��̐����W�I�O���[�v�R���e�i
   */
  protected ACLabelContainer getShortStayLifeNutritionManageRadioContainer(){
    if(shortStayLifeNutritionManageRadioContainer==null){
      shortStayLifeNutritionManageRadioContainer = new ACLabelContainer();
      shortStayLifeNutritionManageRadioContainer.setFollowChildEnabled(true);
      shortStayLifeNutritionManageRadioContainer.add(getShortStayLifeNutritionManageRadio(), null);
    }
    return shortStayLifeNutritionManageRadioContainer;
  }

  /**
   * �h�{�Ǘ��̐����W�I�O���[�v���f�����擾���܂��B
   * @return �h�{�Ǘ��̐����W�I�O���[�v���f��
   */
  protected ACListModelAdapter getShortStayLifeNutritionManageRadioModel(){
    if(shortStayLifeNutritionManageRadioModel==null){
      shortStayLifeNutritionManageRadioModel = new ACListModelAdapter();
      addShortStayLifeNutritionManageRadioModel();
    }
    return shortStayLifeNutritionManageRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getShortStayLifeNutritionManageRadioItem1(){
    if(shortStayLifeNutritionManageRadioItem1==null){

      shortStayLifeNutritionManageRadioItem1 = new ACRadioButtonItem();

      shortStayLifeNutritionManageRadioItem1.setText("�Ȃ�");

      shortStayLifeNutritionManageRadioItem1.setGroup(getShortStayLifeNutritionManageRadio());

      addShortStayLifeNutritionManageRadioItem1();
    }
    return shortStayLifeNutritionManageRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getShortStayLifeNutritionManageRadioItem2(){
    if(shortStayLifeNutritionManageRadioItem2==null){

      shortStayLifeNutritionManageRadioItem2 = new ACRadioButtonItem();

      shortStayLifeNutritionManageRadioItem2.setText("����");

      shortStayLifeNutritionManageRadioItem2.setGroup(getShortStayLifeNutritionManageRadio());

      addShortStayLifeNutritionManageRadioItem2();
    }
    return shortStayLifeNutritionManageRadioItem2;

  }

  /**
   * �×{�H�̐����W�I�O���[�v���擾���܂��B
   * @return �×{�H�̐����W�I�O���[�v
   */
  public ACClearableRadioButtonGroup getShortStayLifeRecuperatDinnerRadio(){
    if(shortStayLifeRecuperatDinnerRadio==null){

      shortStayLifeRecuperatDinnerRadio = new ACClearableRadioButtonGroup();

      getShortStayLifeRecuperatDinnerRadioContainer().setText("�×{�H�̐�");

      shortStayLifeRecuperatDinnerRadio.setBindPath("1210106");

      shortStayLifeRecuperatDinnerRadio.setModel(getShortStayLifeRecuperatDinnerRadioModel());

      shortStayLifeRecuperatDinnerRadio.setUseClearButton(false);

      addShortStayLifeRecuperatDinnerRadio();
    }
    return shortStayLifeRecuperatDinnerRadio;

  }

  /**
   * �×{�H�̐����W�I�O���[�v�R���e�i���擾���܂��B
   * @return �×{�H�̐����W�I�O���[�v�R���e�i
   */
  protected ACLabelContainer getShortStayLifeRecuperatDinnerRadioContainer(){
    if(shortStayLifeRecuperatDinnerRadioContainer==null){
      shortStayLifeRecuperatDinnerRadioContainer = new ACLabelContainer();
      shortStayLifeRecuperatDinnerRadioContainer.setFollowChildEnabled(true);
      shortStayLifeRecuperatDinnerRadioContainer.add(getShortStayLifeRecuperatDinnerRadio(), null);
    }
    return shortStayLifeRecuperatDinnerRadioContainer;
  }

  /**
   * �×{�H�̐����W�I�O���[�v���f�����擾���܂��B
   * @return �×{�H�̐����W�I�O���[�v���f��
   */
  protected ACListModelAdapter getShortStayLifeRecuperatDinnerRadioModel(){
    if(shortStayLifeRecuperatDinnerRadioModel==null){
      shortStayLifeRecuperatDinnerRadioModel = new ACListModelAdapter();
      addShortStayLifeRecuperatDinnerRadioModel();
    }
    return shortStayLifeRecuperatDinnerRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getShortStayLifeRecuperatDinnerRadioItem1(){
    if(shortStayLifeRecuperatDinnerRadioItem1==null){

      shortStayLifeRecuperatDinnerRadioItem1 = new ACRadioButtonItem();

      shortStayLifeRecuperatDinnerRadioItem1.setText("�Ȃ�");

      shortStayLifeRecuperatDinnerRadioItem1.setGroup(getShortStayLifeRecuperatDinnerRadio());

      addShortStayLifeRecuperatDinnerRadioItem1();
    }
    return shortStayLifeRecuperatDinnerRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getShortStayLifeRecuperatDinnerRadioItem2(){
    if(shortStayLifeRecuperatDinnerRadioItem2==null){

      shortStayLifeRecuperatDinnerRadioItem2 = new ACRadioButtonItem();

      shortStayLifeRecuperatDinnerRadioItem2.setText("����");

      shortStayLifeRecuperatDinnerRadioItem2.setGroup(getShortStayLifeRecuperatDinnerRadio());

      addShortStayLifeRecuperatDinnerRadioItem2();
    }
    return shortStayLifeRecuperatDinnerRadioItem2;

  }

  /**
   * �l�����Z�敪���W�I�O���[�v���擾���܂��B
   * @return �l�����Z�敪���W�I�O���[�v
   */
  public ACClearableRadioButtonGroup getShortStayStaffReduceRadio(){
    if(shortStayStaffReduceRadio==null){

      shortStayStaffReduceRadio = new ACClearableRadioButtonGroup();

      getShortStayStaffReduceRadioContainer().setText("�l�����Z");

      shortStayStaffReduceRadio.setBindPath("1210107");

      shortStayStaffReduceRadio.setModel(getShortStayStaffReduceRadioModel());

      shortStayStaffReduceRadio.setUseClearButton(false);

      addShortStayStaffReduceRadio();
    }
    return shortStayStaffReduceRadio;

  }

  /**
   * �l�����Z�敪���W�I�O���[�v�R���e�i���擾���܂��B
   * @return �l�����Z�敪���W�I�O���[�v�R���e�i
   */
  protected ACLabelContainer getShortStayStaffReduceRadioContainer(){
    if(shortStayStaffReduceRadioContainer==null){
      shortStayStaffReduceRadioContainer = new ACLabelContainer();
      shortStayStaffReduceRadioContainer.setFollowChildEnabled(true);
      shortStayStaffReduceRadioContainer.add(getShortStayStaffReduceRadio(), null);
    }
    return shortStayStaffReduceRadioContainer;
  }

  /**
   * �l�����Z�敪���W�I�O���[�v���f�����擾���܂��B
   * @return �l�����Z�敪���W�I�O���[�v���f��
   */
  protected ACListModelAdapter getShortStayStaffReduceRadioModel(){
    if(shortStayStaffReduceRadioModel==null){
      shortStayStaffReduceRadioModel = new ACListModelAdapter();
      addShortStayStaffReduceRadioModel();
    }
    return shortStayStaffReduceRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getShortStayStaffNot(){
    if(shortStayStaffNot==null){

      shortStayStaffNot = new ACRadioButtonItem();

      shortStayStaffNot.setText("�Ȃ�");

      shortStayStaffNot.setGroup(getShortStayStaffReduceRadio());

      addShortStayStaffNot();
    }
    return shortStayStaffNot;

  }

  /**
   * ������߂��擾���܂��B
   * @return �������
   */
  public ACRadioButtonItem getShortStayStaffExcess(){
    if(shortStayStaffExcess==null){

      shortStayStaffExcess = new ACRadioButtonItem();

      shortStayStaffExcess.setText("�������");

      shortStayStaffExcess.setGroup(getShortStayStaffReduceRadio());

      addShortStayStaffExcess();
    }
    return shortStayStaffExcess;

  }

  /**
   * �Ō�A���E���̕s�����擾���܂��B
   * @return �Ō�A���E���̕s��
   */
  public ACRadioButtonItem getShortStayStaffShortage(){
    if(shortStayStaffShortage==null){

      shortStayStaffShortage = new ACRadioButtonItem();

      shortStayStaffShortage.setText("�Ō�E���E���̕s��");

      shortStayStaffShortage.setGroup(getShortStayStaffReduceRadio());

      addShortStayStaffShortage();
    }
    return shortStayStaffShortage;

  }

  /**
   * �H���z�E�R���e�i���擾���܂��B
   * @return �H���z�E�R���e�i
   */
  public ACLabelContainer getShortStayDinnerStandardMoneyConteiner(){
    if(shortStayDinnerStandardMoneyConteiner==null){

      shortStayDinnerStandardMoneyConteiner = new ACLabelContainer();

      shortStayDinnerStandardMoneyConteiner.setText("�H���z");

      shortStayDinnerStandardMoneyConteiner.setFollowChildEnabled(true);

      addShortStayDinnerStandardMoneyConteiner();
    }
    return shortStayDinnerStandardMoneyConteiner;

  }

  /**
   * �H���z�E���v�E�e�L�X�g���擾���܂��B
   * @return �H���z�E���v�E�e�L�X�g
   */
  public ACTextField getShortStayDinnerStandardMoneyTotal(){
    if(shortStayDinnerStandardMoneyTotal==null){

      shortStayDinnerStandardMoneyTotal = new ACTextField();

      shortStayDinnerStandardMoneyTotal.setBindPath("1210108");

      shortStayDinnerStandardMoneyTotal.setEditable(false);

      shortStayDinnerStandardMoneyTotal.setColumns(4);

      shortStayDinnerStandardMoneyTotal.setCharType(VRCharType.ONLY_DIGIT);

      shortStayDinnerStandardMoneyTotal.setHorizontalAlignment(SwingConstants.RIGHT);

      shortStayDinnerStandardMoneyTotal.setIMEMode(InputSubset.LATIN);

      shortStayDinnerStandardMoneyTotal.setMaxLength(4);

      addShortStayDinnerStandardMoneyTotal();
    }
    return shortStayDinnerStandardMoneyTotal;

  }

  /**
   * �H���z�E���E���x�����擾���܂��B
   * @return �H���z�E���E���x��
   */
  public ACLabel getShortStayMorningDinnerStandardMoneyLabel(){
    if(shortStayMorningDinnerStandardMoneyLabel==null){

      shortStayMorningDinnerStandardMoneyLabel = new ACLabel();

      shortStayMorningDinnerStandardMoneyLabel.setText("�@��");

      addShortStayMorningDinnerStandardMoneyLabel();
    }
    return shortStayMorningDinnerStandardMoneyLabel;

  }

  /**
   * �H���z�E���E�e�L�X�g���擾���܂��B
   * @return �H���z�E���E�e�L�X�g
   */
  public ACTextField getShortStayMorningDinnerStandardMoney(){
    if(shortStayMorningDinnerStandardMoney==null){

      shortStayMorningDinnerStandardMoney = new ACTextField();

      shortStayMorningDinnerStandardMoney.setBindPath("1210109");

      shortStayMorningDinnerStandardMoney.setColumns(3);

      shortStayMorningDinnerStandardMoney.setCharType(VRCharType.ONLY_DIGIT);

      shortStayMorningDinnerStandardMoney.setHorizontalAlignment(SwingConstants.RIGHT);

      shortStayMorningDinnerStandardMoney.setIMEMode(InputSubset.LATIN);

      shortStayMorningDinnerStandardMoney.setMaxLength(3);

      addShortStayMorningDinnerStandardMoney();
    }
    return shortStayMorningDinnerStandardMoney;

  }

  /**
   * �H���z�E���E���x�����擾���܂��B
   * @return �H���z�E���E���x��
   */
  public ACLabel getShortStayNoonDinnerStandardMoneyLabel(){
    if(shortStayNoonDinnerStandardMoneyLabel==null){

      shortStayNoonDinnerStandardMoneyLabel = new ACLabel();

      shortStayNoonDinnerStandardMoneyLabel.setText("��");

      addShortStayNoonDinnerStandardMoneyLabel();
    }
    return shortStayNoonDinnerStandardMoneyLabel;

  }

  /**
   * �H���z�E���E�e�L�X�g���擾���܂��B
   * @return �H���z�E���E�e�L�X�g
   */
  public ACTextField getShortStayNoonDinnerStandardMoney(){
    if(shortStayNoonDinnerStandardMoney==null){

      shortStayNoonDinnerStandardMoney = new ACTextField();

      shortStayNoonDinnerStandardMoney.setBindPath("1210110");

      shortStayNoonDinnerStandardMoney.setColumns(3);

      shortStayNoonDinnerStandardMoney.setCharType(VRCharType.ONLY_DIGIT);

      shortStayNoonDinnerStandardMoney.setHorizontalAlignment(SwingConstants.RIGHT);

      shortStayNoonDinnerStandardMoney.setIMEMode(InputSubset.LATIN);

      shortStayNoonDinnerStandardMoney.setMaxLength(3);

      addShortStayNoonDinnerStandardMoney();
    }
    return shortStayNoonDinnerStandardMoney;

  }

  /**
   * �H���z�E��E���x�����擾���܂��B
   * @return �H���z�E��E���x��
   */
  public ACLabel getShortStayNightDinnerStandardMoneyLabel(){
    if(shortStayNightDinnerStandardMoneyLabel==null){

      shortStayNightDinnerStandardMoneyLabel = new ACLabel();

      shortStayNightDinnerStandardMoneyLabel.setText("��");

      addShortStayNightDinnerStandardMoneyLabel();
    }
    return shortStayNightDinnerStandardMoneyLabel;

  }

  /**
   * �H���z�E��E�e�L�X�g���擾���܂��B
   * @return �H���z�E��E�e�L�X�g
   */
  public ACTextField getShortStayNightDinnerStandardMoney(){
    if(shortStayNightDinnerStandardMoney==null){

      shortStayNightDinnerStandardMoney = new ACTextField();

      shortStayNightDinnerStandardMoney.setBindPath("1210111");

      shortStayNightDinnerStandardMoney.setColumns(3);

      shortStayNightDinnerStandardMoney.setCharType(VRCharType.ONLY_DIGIT);

      shortStayNightDinnerStandardMoney.setHorizontalAlignment(SwingConstants.RIGHT);

      shortStayNightDinnerStandardMoney.setIMEMode(InputSubset.LATIN);

      shortStayNightDinnerStandardMoney.setMaxLength(3);

      addShortStayNightDinnerStandardMoney();
    }
    return shortStayNightDinnerStandardMoney;

  }

  /**
   * �H���z�E���x�����擾���܂��B
   * @return �H���z�E���x��
   */
  public ACLabel getShortStayDinnerStandardMoneyDenomination(){
    if(shortStayDinnerStandardMoneyDenomination==null){

      shortStayDinnerStandardMoneyDenomination = new ACLabel();

      shortStayDinnerStandardMoneyDenomination.setText("�i�~�j");

      addShortStayDinnerStandardMoneyDenomination();
    }
    return shortStayDinnerStandardMoneyDenomination;

  }

  /**
   * ���j�b�g�^����z�E�R���e�i���擾���܂��B
   * @return ���j�b�g�^����z�E�R���e�i
   */
  public ACLabelContainer getShortStayUnitRoomStandardMoneyConteiner(){
    if(shortStayUnitRoomStandardMoneyConteiner==null){

      shortStayUnitRoomStandardMoneyConteiner = new ACLabelContainer();

      shortStayUnitRoomStandardMoneyConteiner.setText("���j�b�g�^����z");

      shortStayUnitRoomStandardMoneyConteiner.setFollowChildEnabled(true);

      addShortStayUnitRoomStandardMoneyConteiner();
    }
    return shortStayUnitRoomStandardMoneyConteiner;

  }

  /**
   * ���j�b�g�^����z�E�e�L�X�g���擾���܂��B
   * @return ���j�b�g�^����z�E�e�L�X�g
   */
  public ACTextField getShortStayUnitRoomStandardMoneyText(){
    if(shortStayUnitRoomStandardMoneyText==null){

      shortStayUnitRoomStandardMoneyText = new ACTextField();

      shortStayUnitRoomStandardMoneyText.setBindPath("1210112");

      shortStayUnitRoomStandardMoneyText.setColumns(4);

      shortStayUnitRoomStandardMoneyText.setCharType(VRCharType.ONLY_DIGIT);

      shortStayUnitRoomStandardMoneyText.setHorizontalAlignment(SwingConstants.RIGHT);

      shortStayUnitRoomStandardMoneyText.setIMEMode(InputSubset.LATIN);

      shortStayUnitRoomStandardMoneyText.setMaxLength(4);

      addShortStayUnitRoomStandardMoneyText();
    }
    return shortStayUnitRoomStandardMoneyText;

  }

  /**
   * ���j�b�g�^����z�E���x�����擾���܂��B
   * @return ���j�b�g�^����z�E���x��
   */
  public ACLabel getShortStayUnitRoomStandardMoneyLabel(){
    if(shortStayUnitRoomStandardMoneyLabel==null){

      shortStayUnitRoomStandardMoneyLabel = new ACLabel();

      shortStayUnitRoomStandardMoneyLabel.setText("�i�~�j");

      addShortStayUnitRoomStandardMoneyLabel();
    }
    return shortStayUnitRoomStandardMoneyLabel;

  }

  /**
   * ���j�b�g�^������z�E�R���e�i���擾���܂��B
   * @return ���j�b�g�^������z�E�R���e�i
   */
  public ACLabelContainer getShortStayUnitSemiRoomStandardMoneyConteiner(){
    if(shortStayUnitSemiRoomStandardMoneyConteiner==null){

      shortStayUnitSemiRoomStandardMoneyConteiner = new ACLabelContainer();

      shortStayUnitSemiRoomStandardMoneyConteiner.setText("���j�b�g�^������z");

      shortStayUnitSemiRoomStandardMoneyConteiner.setFollowChildEnabled(true);

      addShortStayUnitSemiRoomStandardMoneyConteiner();
    }
    return shortStayUnitSemiRoomStandardMoneyConteiner;

  }

  /**
   * ���j�b�g�^������z�E�e�L�X�g���擾���܂��B
   * @return ���j�b�g�^������z�E�e�L�X�g
   */
  public ACTextField getShortStayUnitSemiRoomStandardMoneyText(){
    if(shortStayUnitSemiRoomStandardMoneyText==null){

      shortStayUnitSemiRoomStandardMoneyText = new ACTextField();

      shortStayUnitSemiRoomStandardMoneyText.setBindPath("1210113");

      shortStayUnitSemiRoomStandardMoneyText.setColumns(4);

      shortStayUnitSemiRoomStandardMoneyText.setCharType(VRCharType.ONLY_DIGIT);

      shortStayUnitSemiRoomStandardMoneyText.setHorizontalAlignment(SwingConstants.RIGHT);

      shortStayUnitSemiRoomStandardMoneyText.setIMEMode(InputSubset.LATIN);

      shortStayUnitSemiRoomStandardMoneyText.setMaxLength(4);

      addShortStayUnitSemiRoomStandardMoneyText();
    }
    return shortStayUnitSemiRoomStandardMoneyText;

  }

  /**
   * ���j�b�g�^������z�E���x�����擾���܂��B
   * @return ���j�b�g�^������z�E���x��
   */
  public ACLabel getShortStayUnitSemiRoomStandardMoneyLabel(){
    if(shortStayUnitSemiRoomStandardMoneyLabel==null){

      shortStayUnitSemiRoomStandardMoneyLabel = new ACLabel();

      shortStayUnitSemiRoomStandardMoneyLabel.setText("�i�~�j");

      addShortStayUnitSemiRoomStandardMoneyLabel();
    }
    return shortStayUnitSemiRoomStandardMoneyLabel;

  }

  /**
   * �]���^����z�E�R���e�i���擾���܂��B
   * @return �]���^����z�E�R���e�i
   */
  public ACLabelContainer getShortStayNormalRoomStandardMoneyConteiner(){
    if(shortStayNormalRoomStandardMoneyConteiner==null){

      shortStayNormalRoomStandardMoneyConteiner = new ACLabelContainer();

      shortStayNormalRoomStandardMoneyConteiner.setText("�]���^����z");

      shortStayNormalRoomStandardMoneyConteiner.setFollowChildEnabled(true);

      addShortStayNormalRoomStandardMoneyConteiner();
    }
    return shortStayNormalRoomStandardMoneyConteiner;

  }

  /**
   * �]���^����z�E�e�L�X�g���擾���܂��B
   * @return �]���^����z�E�e�L�X�g
   */
  public ACTextField getShortStayNormalRoomStandardMoneyText(){
    if(shortStayNormalRoomStandardMoneyText==null){

      shortStayNormalRoomStandardMoneyText = new ACTextField();

      shortStayNormalRoomStandardMoneyText.setBindPath("1210114");

      shortStayNormalRoomStandardMoneyText.setColumns(4);

      shortStayNormalRoomStandardMoneyText.setCharType(VRCharType.ONLY_DIGIT);

      shortStayNormalRoomStandardMoneyText.setHorizontalAlignment(SwingConstants.RIGHT);

      shortStayNormalRoomStandardMoneyText.setIMEMode(InputSubset.LATIN);

      shortStayNormalRoomStandardMoneyText.setMaxLength(4);

      addShortStayNormalRoomStandardMoneyText();
    }
    return shortStayNormalRoomStandardMoneyText;

  }

  /**
   * �]���^����z�E���x�����擾���܂��B
   * @return �]���^����z�E���x��
   */
  public ACLabel getShortStayNormalRoomStandardMoneyLabel(){
    if(shortStayNormalRoomStandardMoneyLabel==null){

      shortStayNormalRoomStandardMoneyLabel = new ACLabel();

      shortStayNormalRoomStandardMoneyLabel.setText("�i�~�j");

      addShortStayNormalRoomStandardMoneyLabel();
    }
    return shortStayNormalRoomStandardMoneyLabel;

  }

  /**
   * ��������z�E�R���e�i���擾���܂��B
   * @return ��������z�E�R���e�i
   */
  public ACLabelContainer getShortStayTasyouRoomConteiner(){
    if(shortStayTasyouRoomConteiner==null){

      shortStayTasyouRoomConteiner = new ACLabelContainer();

      shortStayTasyouRoomConteiner.setText("��������z");

      shortStayTasyouRoomConteiner.setFollowChildEnabled(true);

      addShortStayTasyouRoomConteiner();
    }
    return shortStayTasyouRoomConteiner;

  }

  /**
   * ��������z�E�e�L�X�g���擾���܂��B
   * @return ��������z�E�e�L�X�g
   */
  public ACTextField getShortStayTasyouRoomText(){
    if(shortStayTasyouRoomText==null){

      shortStayTasyouRoomText = new ACTextField();

      shortStayTasyouRoomText.setBindPath("1210115");

      shortStayTasyouRoomText.setColumns(4);

      shortStayTasyouRoomText.setCharType(VRCharType.ONLY_DIGIT);

      shortStayTasyouRoomText.setHorizontalAlignment(SwingConstants.RIGHT);

      shortStayTasyouRoomText.setIMEMode(InputSubset.LATIN);

      shortStayTasyouRoomText.setMaxLength(4);

      addShortStayTasyouRoomText();
    }
    return shortStayTasyouRoomText;

  }

  /**
   * ��������z�E���x�����擾���܂��B
   * @return ��������z�E���x��
   */
  public ACLabel getShortStayTasyouRoomLabel(){
    if(shortStayTasyouRoomLabel==null){

      shortStayTasyouRoomLabel = new ACLabel();

      shortStayTasyouRoomLabel.setText("�i�~�j");

      addShortStayTasyouRoomLabel();
    }
    return shortStayTasyouRoomLabel;

  }

  /**
   * �R���X�g���N�^�ł��B
   */
  public QO004008Design() {

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

    this.add(getShortStayLifeGroup(), VRLayout.CLIENT);

  }

  /**
   * ���ƃO���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayLifeGroup(){

    shortStayLifeGroup.add(getShortStayLifeDiscountContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayLifeGroup.add(getShortStayLifeFacilitiesDivisionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayLifeGroup.add(getShortStayNightWorkDivisionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayLifeGroup.add(getShortStayLifeFunctionTrainingGuidanceSystemContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayLifeGroup.add(getShortStayMeetingAndSendingOffSystemContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayLifeGroup.add(getShortStayLifeNutritionManageRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayLifeGroup.add(getShortStayLifeRecuperatDinnerRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayLifeGroup.add(getShortStayStaffReduceRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayLifeGroup.add(getShortStayDinnerStandardMoneyConteiner(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayLifeGroup.add(getShortStayUnitRoomStandardMoneyConteiner(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayLifeGroup.add(getShortStayUnitSemiRoomStandardMoneyConteiner(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayLifeGroup.add(getShortStayNormalRoomStandardMoneyConteiner(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayLifeGroup.add(getShortStayTasyouRoomConteiner(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * �������R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayLifeDiscountContainer(){

    shortStayLifeDiscountContainer.add(getShortStayLifeDiscountRate(), VRLayout.FLOW);

    shortStayLifeDiscountContainer.add(getShortStayPercentSign(), VRLayout.FLOW);

  }

  /**
   * �������ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayLifeDiscountRate(){

  }

  /**
   * �����x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayPercentSign(){

  }

  /**
   * �{�݋敪���W�I�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayLifeFacilitiesDivision(){

  }

  /**
   * �{�݋敪���W�I�O���[�v���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayLifeFacilitiesDivisionModel(){

    getShortStayLifeSingle().setButtonIndex(1);
    getShortStayLifeFacilitiesDivisionModel().add(getShortStayLifeSingle());

    getShortStayLifeDouble().setButtonIndex(2);
    getShortStayLifeFacilitiesDivisionModel().add(getShortStayLifeDouble());

    getShortStayLifeSmall().setButtonIndex(3);
    getShortStayLifeFacilitiesDivisionModel().add(getShortStayLifeSmall());

    getShortStayLifeDoubleSmall().setButtonIndex(4);
    getShortStayLifeFacilitiesDivisionModel().add(getShortStayLifeDoubleSmall());

  }

  /**
   * �P�ƌ^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayLifeSingle(){

  }

  /**
   * ���݌^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayLifeDouble(){

  }

  /**
   * �P�Ə��K�͌^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayLifeSmall(){

  }

  /**
   * ���ݏ��K�͌^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayLifeDoubleSmall(){

  }

  /**
   * ��ԋΖ���������W�I�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayNightWorkDivision(){

  }

  /**
   * ��ԋΖ���������W�I�O���[�v���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayNightWorkDivisionModel(){

    getShortStayLifeNightWorkDivisionFill().setButtonIndex(1);
    getShortStayNightWorkDivisionModel().add(getShortStayLifeNightWorkDivisionFill());

    getShortStayNightWorkDivisionNotFill().setButtonIndex(2);
    getShortStayNightWorkDivisionModel().add(getShortStayNightWorkDivisionNotFill());

  }

  /**
   * ��^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayLifeNightWorkDivisionFill(){

  }

  /**
   * ���Z�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayNightWorkDivisionNotFill(){

  }

  /**
   * �@�\�P���w���̐����W�I�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayLifeFunctionTrainingGuidanceSystem(){

  }

  /**
   * �@�\�P���w���̐����W�I�O���[�v���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayLifeFunctionTrainingGuidanceSystemModel(){

    getShortStayFunctionTrainingGuidanceSystemOff().setButtonIndex(1);
    getShortStayLifeFunctionTrainingGuidanceSystemModel().add(getShortStayFunctionTrainingGuidanceSystemOff());

    getShortStayLifeFunctionTrainingGuidanceSystemOn().setButtonIndex(2);
    getShortStayLifeFunctionTrainingGuidanceSystemModel().add(getShortStayLifeFunctionTrainingGuidanceSystemOn());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayFunctionTrainingGuidanceSystemOff(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayLifeFunctionTrainingGuidanceSystemOn(){

  }

  /**
   * ���}�̐����W�I�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayMeetingAndSendingOffSystem(){

  }

  /**
   * ���}�̐����W�I�O���[�v���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayMeetingAndSendingOffSystemModel(){

    getShortStayLifeMeetingAndSendingOffSystemOff().setButtonIndex(1);
    getShortStayMeetingAndSendingOffSystemModel().add(getShortStayLifeMeetingAndSendingOffSystemOff());

    getShortStayMeetingAndSendingOffSystemOn().setButtonIndex(2);
    getShortStayMeetingAndSendingOffSystemModel().add(getShortStayMeetingAndSendingOffSystemOn());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayLifeMeetingAndSendingOffSystemOff(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayMeetingAndSendingOffSystemOn(){

  }

  /**
   * �h�{�Ǘ��̐����W�I�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayLifeNutritionManageRadio(){

  }

  /**
   * �h�{�Ǘ��̐����W�I�O���[�v���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayLifeNutritionManageRadioModel(){

    getShortStayLifeNutritionManageRadioItem1().setButtonIndex(1);
    getShortStayLifeNutritionManageRadioModel().add(getShortStayLifeNutritionManageRadioItem1());

    getShortStayLifeNutritionManageRadioItem2().setButtonIndex(2);
    getShortStayLifeNutritionManageRadioModel().add(getShortStayLifeNutritionManageRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayLifeNutritionManageRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayLifeNutritionManageRadioItem2(){

  }

  /**
   * �×{�H�̐����W�I�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayLifeRecuperatDinnerRadio(){

  }

  /**
   * �×{�H�̐����W�I�O���[�v���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayLifeRecuperatDinnerRadioModel(){

    getShortStayLifeRecuperatDinnerRadioItem1().setButtonIndex(1);
    getShortStayLifeRecuperatDinnerRadioModel().add(getShortStayLifeRecuperatDinnerRadioItem1());

    getShortStayLifeRecuperatDinnerRadioItem2().setButtonIndex(2);
    getShortStayLifeRecuperatDinnerRadioModel().add(getShortStayLifeRecuperatDinnerRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayLifeRecuperatDinnerRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayLifeRecuperatDinnerRadioItem2(){

  }

  /**
   * �l�����Z�敪���W�I�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayStaffReduceRadio(){

  }

  /**
   * �l�����Z�敪���W�I�O���[�v���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayStaffReduceRadioModel(){

    getShortStayStaffNot().setButtonIndex(1);
    getShortStayStaffReduceRadioModel().add(getShortStayStaffNot());

    getShortStayStaffExcess().setButtonIndex(2);
    getShortStayStaffReduceRadioModel().add(getShortStayStaffExcess());

    getShortStayStaffShortage().setButtonIndex(3);
    getShortStayStaffReduceRadioModel().add(getShortStayStaffShortage());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayStaffNot(){

  }

  /**
   * ������߂ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayStaffExcess(){

  }

  /**
   * �Ō�A���E���̕s���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayStaffShortage(){

  }

  /**
   * �H���z�E�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayDinnerStandardMoneyConteiner(){

    shortStayDinnerStandardMoneyConteiner.add(getShortStayDinnerStandardMoneyTotal(), VRLayout.FLOW);

    shortStayDinnerStandardMoneyConteiner.add(getShortStayMorningDinnerStandardMoneyLabel(), VRLayout.FLOW);

    shortStayDinnerStandardMoneyConteiner.add(getShortStayMorningDinnerStandardMoney(), VRLayout.FLOW);

    shortStayDinnerStandardMoneyConteiner.add(getShortStayNoonDinnerStandardMoneyLabel(), VRLayout.FLOW);

    shortStayDinnerStandardMoneyConteiner.add(getShortStayNoonDinnerStandardMoney(), VRLayout.FLOW);

    shortStayDinnerStandardMoneyConteiner.add(getShortStayNightDinnerStandardMoneyLabel(), VRLayout.FLOW);

    shortStayDinnerStandardMoneyConteiner.add(getShortStayNightDinnerStandardMoney(), VRLayout.FLOW);

    shortStayDinnerStandardMoneyConteiner.add(getShortStayDinnerStandardMoneyDenomination(), VRLayout.FLOW);

  }

  /**
   * �H���z�E���v�E�e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayDinnerStandardMoneyTotal(){

  }

  /**
   * �H���z�E���E���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayMorningDinnerStandardMoneyLabel(){

  }

  /**
   * �H���z�E���E�e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayMorningDinnerStandardMoney(){

  }

  /**
   * �H���z�E���E���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayNoonDinnerStandardMoneyLabel(){

  }

  /**
   * �H���z�E���E�e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayNoonDinnerStandardMoney(){

  }

  /**
   * �H���z�E��E���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayNightDinnerStandardMoneyLabel(){

  }

  /**
   * �H���z�E��E�e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayNightDinnerStandardMoney(){

  }

  /**
   * �H���z�E���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayDinnerStandardMoneyDenomination(){

  }

  /**
   * ���j�b�g�^����z�E�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayUnitRoomStandardMoneyConteiner(){

    shortStayUnitRoomStandardMoneyConteiner.add(getShortStayUnitRoomStandardMoneyText(), null);

    shortStayUnitRoomStandardMoneyConteiner.add(getShortStayUnitRoomStandardMoneyLabel(), null);

  }

  /**
   * ���j�b�g�^����z�E�e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayUnitRoomStandardMoneyText(){

  }

  /**
   * ���j�b�g�^����z�E���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayUnitRoomStandardMoneyLabel(){

  }

  /**
   * ���j�b�g�^������z�E�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayUnitSemiRoomStandardMoneyConteiner(){

    shortStayUnitSemiRoomStandardMoneyConteiner.add(getShortStayUnitSemiRoomStandardMoneyText(), null);

    shortStayUnitSemiRoomStandardMoneyConteiner.add(getShortStayUnitSemiRoomStandardMoneyLabel(), null);

  }

  /**
   * ���j�b�g�^������z�E�e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayUnitSemiRoomStandardMoneyText(){

  }

  /**
   * ���j�b�g�^������z�E���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayUnitSemiRoomStandardMoneyLabel(){

  }

  /**
   * �]���^����z�E�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayNormalRoomStandardMoneyConteiner(){

    shortStayNormalRoomStandardMoneyConteiner.add(getShortStayNormalRoomStandardMoneyText(), null);

    shortStayNormalRoomStandardMoneyConteiner.add(getShortStayNormalRoomStandardMoneyLabel(), null);

  }

  /**
   * �]���^����z�E�e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayNormalRoomStandardMoneyText(){

  }

  /**
   * �]���^����z�E���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayNormalRoomStandardMoneyLabel(){

  }

  /**
   * ��������z�E�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayTasyouRoomConteiner(){

    shortStayTasyouRoomConteiner.add(getShortStayTasyouRoomText(), null);

    shortStayTasyouRoomConteiner.add(getShortStayTasyouRoomLabel(), null);

  }

  /**
   * ��������z�E�e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayTasyouRoomText(){

  }

  /**
   * ��������z�E���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayTasyouRoomLabel(){

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
      ACFrame.getInstance().getContentPane().add(new QO004008Design());
      ACFrame.getInstance().setVisible(true);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QO004008Design getThis() {
    return this;
  }
}
