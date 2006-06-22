
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
 * �v���O���� �Z�������×{���f�Ï��×{�^ (QO004011)
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
 * �Z�������×{���f�Ï��×{�^��ʍ��ڃf�U�C��(QO004011) 
 */
public class QO004011Design extends ACPanel {
  //GUI�R���|�[�l���g

  private ACGroupBox shortStayClinicRecuperationGroup;

  private ACLabelContainer shortStayClinicRecuperationDiscountContainer;

  private ACTextField shortStayClinicRecuperationDiscountRate;

  private ACLabel shortStayPercentSign;

  private ACClearableRadioButtonGroup shortStayInstitutionDivisionRadio;

  private ACLabelContainer shortStayInstitutionDivisionRadioContainer;

  private ACListModelAdapter shortStayInstitutionDivisionRadioModel;

  private ACRadioButtonItem shortStayInstitutionDivisionRadioItem1;

  private ACRadioButtonItem shortStayInstitutionDivisionRadioItem2;

  private ACClearableRadioButtonGroup shortStayStaffAssignmentDivision;

  private ACLabelContainer shortStayStaffAssignmentDivisionContainer;

  private ACListModelAdapter shortStayStaffAssignmentDivisionModel;

  private ACRadioButtonItem shortStayStaffAssignmentDivision1;

  private ACRadioButtonItem shortStayStaffAssignmentDivision2;

  private ACClearableRadioButtonGroup shortStayRecuperationEnvironmental;

  private ACLabelContainer shortStayRecuperationEnvironmentalContainer;

  private ACListModelAdapter shortStayRecuperationEnvironmentalModel;

  private ACRadioButtonItem shortStayRecuperationEnvironmentalStandard;

  private ACRadioButtonItem shortStayRecuperationEnvironmentalSubtraction1;

  private ACRadioButtonItem shortStayRecuperationEnvironmentalSubtraction2;

  private ACClearableRadioButtonGroup shortStayMeetingAndSendingOffSystem;

  private ACLabelContainer shortStayMeetingAndSendingOffSystemContainer;

  private ACListModelAdapter shortStayMeetingAndSendingOffSystemModel;

  private ACRadioButtonItem shortStayMeetingAndSendingOffSystemOff;

  private ACRadioButtonItem shortStayMeetingAndSendingOffSystemOn;

  private ACClearableRadioButtonGroup shortStayNutritionManageRadio;

  private ACLabelContainer shortStayNutritionManageRadioContainer;

  private ACListModelAdapter shortStayNutritionManageRadioModel;

  private ACRadioButtonItem shortStayNutritionManageRadioItem1;

  private ACRadioButtonItem shortStayNutritionManageRadioItem2;

  private ACClearableRadioButtonGroup shortStayRecuperateDinnerRadio;

  private ACLabelContainer shortStayRecuperateDinnerRadioContainer;

  private ACListModelAdapter shortStayRecuperateDinnerRadioModel;

  private ACRadioButtonItem shortStayRecuperateDinnerRadioItem1;

  private ACRadioButtonItem shortStayRecuperateDinnerRadioItem2;

  private ACClearableRadioButtonGroup shortStayStaffReduce;

  private ACLabelContainer shortStayStaffReduceContainer;

  private ACListModelAdapter shortStayStaffReduceModel;

  private ACRadioButtonItem shortStayStaffNot;

  private ACRadioButtonItem shortStayStaffExcess;

  private ACLabelContainer shortStayRecuperateCareClinicDinnerStandeirdMoneyConteiner;

  private ACTextField shortStayRecuperateCareClinicDinnerStandeirdMoneyTotal;

  private ACLabel shortStayRecuperateCareClinicMorningDinnerStandeirdMoneyLabel;

  private ACTextField shortStayRecuperateCareClinicMorningDinnerStandeirdMoney;

  private ACLabel shortStayRecuperateCareClinicNoonDinnerStandeirdMoneyLabel;

  private ACTextField shortStayRecuperateCareClinicNoonDinnerStandeirdMoney;

  private ACLabel shortStayRecuperateCareClinicNightDinnerStandeirdMoneyLabel;

  private ACTextField shortStayRecuperateCareClinicNightDinnerStandeirdMoney;

  private ACLabel shortStayRecuperateCareClinicDinnerStandeirdMoney4Label;

  private ACLabelContainer shortStayRecuperateCareClinicUnitRoomStandeirdMoneyConteiner;

  private ACTextField shortStayRecuperateCareClinicUnitRoomStandeirdMoneyText;

  private ACLabel shortStayRecuperateCareClinicUnitRoomStandeirdMoneyLabel;

  private ACLabelContainer shortStayRecuperateCareClinicUnitSemiRoomStandeirdMoneyConteiner;

  private ACTextField shortStayRecuperateCareClinicUnitSemiRoomStandeirdMoneyText;

  private ACLabel shortStayRecuperateCareClinicUnitSemiRoomStandeirdMoneyLabel;

  private ACLabelContainer shortStayRecuperateCareClinicNormalRoomStandeirdMoneyConteiner;

  private ACTextField shortStayRecuperateCareClinicNormalRoomStandeirdMoneyText;

  private ACLabel shortStayRecuperateCareClinicNormalRoomStandeirdMoneyLabel;

  private ACLabelContainer shortStayRecuperateCareClinicTasyouRoomConteiner;

  private ACTextField shortStayRecuperateCareClinicTasyouRoomText;

  private ACLabel shortStayRecuperateCareClinicTasyouRoomLabel;

  //getter

  /**
   * ���ƃO���[�v���擾���܂��B
   * @return ���ƃO���[�v
   */
  public ACGroupBox getShortStayClinicRecuperationGroup(){
    if(shortStayClinicRecuperationGroup==null){

      shortStayClinicRecuperationGroup = new ACGroupBox();

      shortStayClinicRecuperationGroup.setText("�Z�������×{���i�f�Ï��×{�^�j");

      shortStayClinicRecuperationGroup.setFollowChildEnabled(true);

      shortStayClinicRecuperationGroup.setHgrid(200);

      addShortStayClinicRecuperationGroup();
    }
    return shortStayClinicRecuperationGroup;

  }

  /**
   * �������R���e�i���擾���܂��B
   * @return �������R���e�i
   */
  public ACLabelContainer getShortStayClinicRecuperationDiscountContainer(){
    if(shortStayClinicRecuperationDiscountContainer==null){

      shortStayClinicRecuperationDiscountContainer = new ACLabelContainer();

      shortStayClinicRecuperationDiscountContainer.setText("������");

      shortStayClinicRecuperationDiscountContainer.setFollowChildEnabled(true);

      addShortStayClinicRecuperationDiscountContainer();
    }
    return shortStayClinicRecuperationDiscountContainer;

  }

  /**
   * ���������擾���܂��B
   * @return ������
   */
  public ACTextField getShortStayClinicRecuperationDiscountRate(){
    if(shortStayClinicRecuperationDiscountRate==null){

      shortStayClinicRecuperationDiscountRate = new ACTextField();

      shortStayClinicRecuperationDiscountRate.setBindPath("REDUCT_RATE");

      shortStayClinicRecuperationDiscountRate.setColumns(3);

      shortStayClinicRecuperationDiscountRate.setCharType(VRCharType.ONLY_DIGIT);

      shortStayClinicRecuperationDiscountRate.setHorizontalAlignment(SwingConstants.RIGHT);

      shortStayClinicRecuperationDiscountRate.setIMEMode(InputSubset.LATIN);

      shortStayClinicRecuperationDiscountRate.setMaxLength(3);

      addShortStayClinicRecuperationDiscountRate();
    }
    return shortStayClinicRecuperationDiscountRate;

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
  public ACClearableRadioButtonGroup getShortStayInstitutionDivisionRadio(){
    if(shortStayInstitutionDivisionRadio==null){

      shortStayInstitutionDivisionRadio = new ACClearableRadioButtonGroup();

      getShortStayInstitutionDivisionRadioContainer().setText("�{�݋敪");

      shortStayInstitutionDivisionRadio.setBindPath("1230201");

      shortStayInstitutionDivisionRadio.setModel(getShortStayInstitutionDivisionRadioModel());

      shortStayInstitutionDivisionRadio.setUseClearButton(false);

      addShortStayInstitutionDivisionRadio();
    }
    return shortStayInstitutionDivisionRadio;

  }

  /**
   * �{�݋敪���W�I�O���[�v�R���e�i���擾���܂��B
   * @return �{�݋敪���W�I�O���[�v�R���e�i
   */
  protected ACLabelContainer getShortStayInstitutionDivisionRadioContainer(){
    if(shortStayInstitutionDivisionRadioContainer==null){
      shortStayInstitutionDivisionRadioContainer = new ACLabelContainer();
      shortStayInstitutionDivisionRadioContainer.setFollowChildEnabled(true);
      shortStayInstitutionDivisionRadioContainer.add(getShortStayInstitutionDivisionRadio(), null);
    }
    return shortStayInstitutionDivisionRadioContainer;
  }

  /**
   * �{�݋敪���W�I�O���[�v���f�����擾���܂��B
   * @return �{�݋敪���W�I�O���[�v���f��
   */
  protected ACListModelAdapter getShortStayInstitutionDivisionRadioModel(){
    if(shortStayInstitutionDivisionRadioModel==null){
      shortStayInstitutionDivisionRadioModel = new ACListModelAdapter();
      addShortStayInstitutionDivisionRadioModel();
    }
    return shortStayInstitutionDivisionRadioModel;
  }

  /**
   * �f�Ï����擾���܂��B
   * @return �f�Ï�
   */
  public ACRadioButtonItem getShortStayInstitutionDivisionRadioItem1(){
    if(shortStayInstitutionDivisionRadioItem1==null){

      shortStayInstitutionDivisionRadioItem1 = new ACRadioButtonItem();

      shortStayInstitutionDivisionRadioItem1.setText("�f�Ï�");

      shortStayInstitutionDivisionRadioItem1.setGroup(getShortStayInstitutionDivisionRadio());

      addShortStayInstitutionDivisionRadioItem1();
    }
    return shortStayInstitutionDivisionRadioItem1;

  }

  /**
   * ���j�b�g�^�f�Ï����擾���܂��B
   * @return ���j�b�g�^�f�Ï�
   */
  public ACRadioButtonItem getShortStayInstitutionDivisionRadioItem2(){
    if(shortStayInstitutionDivisionRadioItem2==null){

      shortStayInstitutionDivisionRadioItem2 = new ACRadioButtonItem();

      shortStayInstitutionDivisionRadioItem2.setText("���j�b�g�^�f�Ï�");

      shortStayInstitutionDivisionRadioItem2.setGroup(getShortStayInstitutionDivisionRadio());

      addShortStayInstitutionDivisionRadioItem2();
    }
    return shortStayInstitutionDivisionRadioItem2;

  }

  /**
   * �l���z�u�敪���W�I�O���[�v���擾���܂��B
   * @return �l���z�u�敪���W�I�O���[�v
   */
  public ACClearableRadioButtonGroup getShortStayStaffAssignmentDivision(){
    if(shortStayStaffAssignmentDivision==null){

      shortStayStaffAssignmentDivision = new ACClearableRadioButtonGroup();

      getShortStayStaffAssignmentDivisionContainer().setText("�l���z�u�敪");

      shortStayStaffAssignmentDivision.setBindPath("1230202");

      shortStayStaffAssignmentDivision.setModel(getShortStayStaffAssignmentDivisionModel());

      shortStayStaffAssignmentDivision.setUseClearButton(false);

      addShortStayStaffAssignmentDivision();
    }
    return shortStayStaffAssignmentDivision;

  }

  /**
   * �l���z�u�敪���W�I�O���[�v�R���e�i���擾���܂��B
   * @return �l���z�u�敪���W�I�O���[�v�R���e�i
   */
  protected ACLabelContainer getShortStayStaffAssignmentDivisionContainer(){
    if(shortStayStaffAssignmentDivisionContainer==null){
      shortStayStaffAssignmentDivisionContainer = new ACLabelContainer();
      shortStayStaffAssignmentDivisionContainer.setFollowChildEnabled(true);
      shortStayStaffAssignmentDivisionContainer.add(getShortStayStaffAssignmentDivision(), null);
    }
    return shortStayStaffAssignmentDivisionContainer;
  }

  /**
   * �l���z�u�敪���W�I�O���[�v���f�����擾���܂��B
   * @return �l���z�u�敪���W�I�O���[�v���f��
   */
  protected ACListModelAdapter getShortStayStaffAssignmentDivisionModel(){
    if(shortStayStaffAssignmentDivisionModel==null){
      shortStayStaffAssignmentDivisionModel = new ACListModelAdapter();
      addShortStayStaffAssignmentDivisionModel();
    }
    return shortStayStaffAssignmentDivisionModel;
  }

  /**
   * I�^���擾���܂��B
   * @return I�^
   */
  public ACRadioButtonItem getShortStayStaffAssignmentDivision1(){
    if(shortStayStaffAssignmentDivision1==null){

      shortStayStaffAssignmentDivision1 = new ACRadioButtonItem();

      shortStayStaffAssignmentDivision1.setText("I�^");

      shortStayStaffAssignmentDivision1.setGroup(getShortStayStaffAssignmentDivision());

      addShortStayStaffAssignmentDivision1();
    }
    return shortStayStaffAssignmentDivision1;

  }

  /**
   * II�^���擾���܂��B
   * @return II�^
   */
  public ACRadioButtonItem getShortStayStaffAssignmentDivision2(){
    if(shortStayStaffAssignmentDivision2==null){

      shortStayStaffAssignmentDivision2 = new ACRadioButtonItem();

      shortStayStaffAssignmentDivision2.setText("II�^");

      shortStayStaffAssignmentDivision2.setGroup(getShortStayStaffAssignmentDivision());

      addShortStayStaffAssignmentDivision2();
    }
    return shortStayStaffAssignmentDivision2;

  }

  /**
   * �×{������W�I�O���[�v���擾���܂��B
   * @return �×{������W�I�O���[�v
   */
  public ACClearableRadioButtonGroup getShortStayRecuperationEnvironmental(){
    if(shortStayRecuperationEnvironmental==null){

      shortStayRecuperationEnvironmental = new ACClearableRadioButtonGroup();

      getShortStayRecuperationEnvironmentalContainer().setText("�×{���");

      shortStayRecuperationEnvironmental.setBindPath("1230203");

      shortStayRecuperationEnvironmental.setModel(getShortStayRecuperationEnvironmentalModel());

      shortStayRecuperationEnvironmental.setUseClearButton(false);

      addShortStayRecuperationEnvironmental();
    }
    return shortStayRecuperationEnvironmental;

  }

  /**
   * �×{������W�I�O���[�v�R���e�i���擾���܂��B
   * @return �×{������W�I�O���[�v�R���e�i
   */
  protected ACLabelContainer getShortStayRecuperationEnvironmentalContainer(){
    if(shortStayRecuperationEnvironmentalContainer==null){
      shortStayRecuperationEnvironmentalContainer = new ACLabelContainer();
      shortStayRecuperationEnvironmentalContainer.setFollowChildEnabled(true);
      shortStayRecuperationEnvironmentalContainer.add(getShortStayRecuperationEnvironmental(), null);
    }
    return shortStayRecuperationEnvironmentalContainer;
  }

  /**
   * �×{������W�I�O���[�v���f�����擾���܂��B
   * @return �×{������W�I�O���[�v���f��
   */
  protected ACListModelAdapter getShortStayRecuperationEnvironmentalModel(){
    if(shortStayRecuperationEnvironmentalModel==null){
      shortStayRecuperationEnvironmentalModel = new ACListModelAdapter();
      addShortStayRecuperationEnvironmentalModel();
    }
    return shortStayRecuperationEnvironmentalModel;
  }

  /**
   * ��^���擾���܂��B
   * @return ��^
   */
  public ACRadioButtonItem getShortStayRecuperationEnvironmentalStandard(){
    if(shortStayRecuperationEnvironmentalStandard==null){

      shortStayRecuperationEnvironmentalStandard = new ACRadioButtonItem();

      shortStayRecuperationEnvironmentalStandard.setText("��^");

      shortStayRecuperationEnvironmentalStandard.setGroup(getShortStayRecuperationEnvironmental());

      addShortStayRecuperationEnvironmentalStandard();
    }
    return shortStayRecuperationEnvironmentalStandard;

  }

  /**
   * ���Z�^I���擾���܂��B
   * @return ���Z�^I
   */
  public ACRadioButtonItem getShortStayRecuperationEnvironmentalSubtraction1(){
    if(shortStayRecuperationEnvironmentalSubtraction1==null){

      shortStayRecuperationEnvironmentalSubtraction1 = new ACRadioButtonItem();

      shortStayRecuperationEnvironmentalSubtraction1.setText("���Z�^I");

      shortStayRecuperationEnvironmentalSubtraction1.setGroup(getShortStayRecuperationEnvironmental());

      addShortStayRecuperationEnvironmentalSubtraction1();
    }
    return shortStayRecuperationEnvironmentalSubtraction1;

  }

  /**
   * ���Z�^II���擾���܂��B
   * @return ���Z�^II
   */
  public ACRadioButtonItem getShortStayRecuperationEnvironmentalSubtraction2(){
    if(shortStayRecuperationEnvironmentalSubtraction2==null){

      shortStayRecuperationEnvironmentalSubtraction2 = new ACRadioButtonItem();

      shortStayRecuperationEnvironmentalSubtraction2.setText("���Z�^II");

      shortStayRecuperationEnvironmentalSubtraction2.setGroup(getShortStayRecuperationEnvironmental());

      addShortStayRecuperationEnvironmentalSubtraction2();
    }
    return shortStayRecuperationEnvironmentalSubtraction2;

  }

  /**
   * ���}�̐����W�I�O���[�v���擾���܂��B
   * @return ���}�̐����W�I�O���[�v
   */
  public ACClearableRadioButtonGroup getShortStayMeetingAndSendingOffSystem(){
    if(shortStayMeetingAndSendingOffSystem==null){

      shortStayMeetingAndSendingOffSystem = new ACClearableRadioButtonGroup();

      getShortStayMeetingAndSendingOffSystemContainer().setText("���}�̐�");

      shortStayMeetingAndSendingOffSystem.setBindPath("1230204");

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
  public ACRadioButtonItem getShortStayMeetingAndSendingOffSystemOff(){
    if(shortStayMeetingAndSendingOffSystemOff==null){

      shortStayMeetingAndSendingOffSystemOff = new ACRadioButtonItem();

      shortStayMeetingAndSendingOffSystemOff.setText("�Ȃ�");

      shortStayMeetingAndSendingOffSystemOff.setGroup(getShortStayMeetingAndSendingOffSystem());

      addShortStayMeetingAndSendingOffSystemOff();
    }
    return shortStayMeetingAndSendingOffSystemOff;

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
  public ACClearableRadioButtonGroup getShortStayNutritionManageRadio(){
    if(shortStayNutritionManageRadio==null){

      shortStayNutritionManageRadio = new ACClearableRadioButtonGroup();

      getShortStayNutritionManageRadioContainer().setText("�h�{�Ǘ��̐�");

      shortStayNutritionManageRadio.setBindPath("1230205");

      shortStayNutritionManageRadio.setModel(getShortStayNutritionManageRadioModel());

      shortStayNutritionManageRadio.setUseClearButton(false);

      addShortStayNutritionManageRadio();
    }
    return shortStayNutritionManageRadio;

  }

  /**
   * �h�{�Ǘ��̐����W�I�O���[�v�R���e�i���擾���܂��B
   * @return �h�{�Ǘ��̐����W�I�O���[�v�R���e�i
   */
  protected ACLabelContainer getShortStayNutritionManageRadioContainer(){
    if(shortStayNutritionManageRadioContainer==null){
      shortStayNutritionManageRadioContainer = new ACLabelContainer();
      shortStayNutritionManageRadioContainer.setFollowChildEnabled(true);
      shortStayNutritionManageRadioContainer.add(getShortStayNutritionManageRadio(), null);
    }
    return shortStayNutritionManageRadioContainer;
  }

  /**
   * �h�{�Ǘ��̐����W�I�O���[�v���f�����擾���܂��B
   * @return �h�{�Ǘ��̐����W�I�O���[�v���f��
   */
  protected ACListModelAdapter getShortStayNutritionManageRadioModel(){
    if(shortStayNutritionManageRadioModel==null){
      shortStayNutritionManageRadioModel = new ACListModelAdapter();
      addShortStayNutritionManageRadioModel();
    }
    return shortStayNutritionManageRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getShortStayNutritionManageRadioItem1(){
    if(shortStayNutritionManageRadioItem1==null){

      shortStayNutritionManageRadioItem1 = new ACRadioButtonItem();

      shortStayNutritionManageRadioItem1.setText("�Ȃ�");

      shortStayNutritionManageRadioItem1.setGroup(getShortStayNutritionManageRadio());

      addShortStayNutritionManageRadioItem1();
    }
    return shortStayNutritionManageRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getShortStayNutritionManageRadioItem2(){
    if(shortStayNutritionManageRadioItem2==null){

      shortStayNutritionManageRadioItem2 = new ACRadioButtonItem();

      shortStayNutritionManageRadioItem2.setText("����");

      shortStayNutritionManageRadioItem2.setGroup(getShortStayNutritionManageRadio());

      addShortStayNutritionManageRadioItem2();
    }
    return shortStayNutritionManageRadioItem2;

  }

  /**
   * �×{�H�̐����W�I�O���[�v���擾���܂��B
   * @return �×{�H�̐����W�I�O���[�v
   */
  public ACClearableRadioButtonGroup getShortStayRecuperateDinnerRadio(){
    if(shortStayRecuperateDinnerRadio==null){

      shortStayRecuperateDinnerRadio = new ACClearableRadioButtonGroup();

      getShortStayRecuperateDinnerRadioContainer().setText("�×{�H�̐�");

      shortStayRecuperateDinnerRadio.setBindPath("1230206");

      shortStayRecuperateDinnerRadio.setModel(getShortStayRecuperateDinnerRadioModel());

      shortStayRecuperateDinnerRadio.setUseClearButton(false);

      addShortStayRecuperateDinnerRadio();
    }
    return shortStayRecuperateDinnerRadio;

  }

  /**
   * �×{�H�̐����W�I�O���[�v�R���e�i���擾���܂��B
   * @return �×{�H�̐����W�I�O���[�v�R���e�i
   */
  protected ACLabelContainer getShortStayRecuperateDinnerRadioContainer(){
    if(shortStayRecuperateDinnerRadioContainer==null){
      shortStayRecuperateDinnerRadioContainer = new ACLabelContainer();
      shortStayRecuperateDinnerRadioContainer.setFollowChildEnabled(true);
      shortStayRecuperateDinnerRadioContainer.add(getShortStayRecuperateDinnerRadio(), null);
    }
    return shortStayRecuperateDinnerRadioContainer;
  }

  /**
   * �×{�H�̐����W�I�O���[�v���f�����擾���܂��B
   * @return �×{�H�̐����W�I�O���[�v���f��
   */
  protected ACListModelAdapter getShortStayRecuperateDinnerRadioModel(){
    if(shortStayRecuperateDinnerRadioModel==null){
      shortStayRecuperateDinnerRadioModel = new ACListModelAdapter();
      addShortStayRecuperateDinnerRadioModel();
    }
    return shortStayRecuperateDinnerRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getShortStayRecuperateDinnerRadioItem1(){
    if(shortStayRecuperateDinnerRadioItem1==null){

      shortStayRecuperateDinnerRadioItem1 = new ACRadioButtonItem();

      shortStayRecuperateDinnerRadioItem1.setText("�Ȃ�");

      shortStayRecuperateDinnerRadioItem1.setGroup(getShortStayRecuperateDinnerRadio());

      addShortStayRecuperateDinnerRadioItem1();
    }
    return shortStayRecuperateDinnerRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getShortStayRecuperateDinnerRadioItem2(){
    if(shortStayRecuperateDinnerRadioItem2==null){

      shortStayRecuperateDinnerRadioItem2 = new ACRadioButtonItem();

      shortStayRecuperateDinnerRadioItem2.setText("����");

      shortStayRecuperateDinnerRadioItem2.setGroup(getShortStayRecuperateDinnerRadio());

      addShortStayRecuperateDinnerRadioItem2();
    }
    return shortStayRecuperateDinnerRadioItem2;

  }

  /**
   * �l�����Z���W�I�O���[�v���擾���܂��B
   * @return �l�����Z���W�I�O���[�v
   */
  public ACClearableRadioButtonGroup getShortStayStaffReduce(){
    if(shortStayStaffReduce==null){

      shortStayStaffReduce = new ACClearableRadioButtonGroup();

      getShortStayStaffReduceContainer().setText("�l�����Z");

      shortStayStaffReduce.setBindPath("1230207");

      shortStayStaffReduce.setModel(getShortStayStaffReduceModel());

      shortStayStaffReduce.setUseClearButton(false);

      addShortStayStaffReduce();
    }
    return shortStayStaffReduce;

  }

  /**
   * �l�����Z���W�I�O���[�v�R���e�i���擾���܂��B
   * @return �l�����Z���W�I�O���[�v�R���e�i
   */
  protected ACLabelContainer getShortStayStaffReduceContainer(){
    if(shortStayStaffReduceContainer==null){
      shortStayStaffReduceContainer = new ACLabelContainer();
      shortStayStaffReduceContainer.setFollowChildEnabled(true);
      shortStayStaffReduceContainer.add(getShortStayStaffReduce(), null);
    }
    return shortStayStaffReduceContainer;
  }

  /**
   * �l�����Z���W�I�O���[�v���f�����擾���܂��B
   * @return �l�����Z���W�I�O���[�v���f��
   */
  protected ACListModelAdapter getShortStayStaffReduceModel(){
    if(shortStayStaffReduceModel==null){
      shortStayStaffReduceModel = new ACListModelAdapter();
      addShortStayStaffReduceModel();
    }
    return shortStayStaffReduceModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getShortStayStaffNot(){
    if(shortStayStaffNot==null){

      shortStayStaffNot = new ACRadioButtonItem();

      shortStayStaffNot.setText("�Ȃ�");

      shortStayStaffNot.setGroup(getShortStayStaffReduce());

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

      shortStayStaffExcess.setGroup(getShortStayStaffReduce());

      addShortStayStaffExcess();
    }
    return shortStayStaffExcess;

  }

  /**
   * �H���z�E�R���e�i���擾���܂��B
   * @return �H���z�E�R���e�i
   */
  public ACLabelContainer getShortStayRecuperateCareClinicDinnerStandeirdMoneyConteiner(){
    if(shortStayRecuperateCareClinicDinnerStandeirdMoneyConteiner==null){

      shortStayRecuperateCareClinicDinnerStandeirdMoneyConteiner = new ACLabelContainer();

      shortStayRecuperateCareClinicDinnerStandeirdMoneyConteiner.setText("�H���z");

      shortStayRecuperateCareClinicDinnerStandeirdMoneyConteiner.setFollowChildEnabled(true);

      addShortStayRecuperateCareClinicDinnerStandeirdMoneyConteiner();
    }
    return shortStayRecuperateCareClinicDinnerStandeirdMoneyConteiner;

  }

  /**
   * �H���z�E���v�E�e�L�X�g���擾���܂��B
   * @return �H���z�E���v�E�e�L�X�g
   */
  public ACTextField getShortStayRecuperateCareClinicDinnerStandeirdMoneyTotal(){
    if(shortStayRecuperateCareClinicDinnerStandeirdMoneyTotal==null){

      shortStayRecuperateCareClinicDinnerStandeirdMoneyTotal = new ACTextField();

      shortStayRecuperateCareClinicDinnerStandeirdMoneyTotal.setBindPath("1230208");

      shortStayRecuperateCareClinicDinnerStandeirdMoneyTotal.setEditable(false);

      shortStayRecuperateCareClinicDinnerStandeirdMoneyTotal.setColumns(4);

      shortStayRecuperateCareClinicDinnerStandeirdMoneyTotal.setCharType(VRCharType.ONLY_DIGIT);

      shortStayRecuperateCareClinicDinnerStandeirdMoneyTotal.setHorizontalAlignment(SwingConstants.RIGHT);

      shortStayRecuperateCareClinicDinnerStandeirdMoneyTotal.setIMEMode(InputSubset.LATIN);

      shortStayRecuperateCareClinicDinnerStandeirdMoneyTotal.setMaxLength(4);

      addShortStayRecuperateCareClinicDinnerStandeirdMoneyTotal();
    }
    return shortStayRecuperateCareClinicDinnerStandeirdMoneyTotal;

  }

  /**
   * �H���z�E���E���x�����擾���܂��B
   * @return �H���z�E���E���x��
   */
  public ACLabel getShortStayRecuperateCareClinicMorningDinnerStandeirdMoneyLabel(){
    if(shortStayRecuperateCareClinicMorningDinnerStandeirdMoneyLabel==null){

      shortStayRecuperateCareClinicMorningDinnerStandeirdMoneyLabel = new ACLabel();

      shortStayRecuperateCareClinicMorningDinnerStandeirdMoneyLabel.setText("�@��");

      addShortStayRecuperateCareClinicMorningDinnerStandeirdMoneyLabel();
    }
    return shortStayRecuperateCareClinicMorningDinnerStandeirdMoneyLabel;

  }

  /**
   * �H���z�E���E�e�L�X�g���擾���܂��B
   * @return �H���z�E���E�e�L�X�g
   */
  public ACTextField getShortStayRecuperateCareClinicMorningDinnerStandeirdMoney(){
    if(shortStayRecuperateCareClinicMorningDinnerStandeirdMoney==null){

      shortStayRecuperateCareClinicMorningDinnerStandeirdMoney = new ACTextField();

      shortStayRecuperateCareClinicMorningDinnerStandeirdMoney.setBindPath("1230209");

      shortStayRecuperateCareClinicMorningDinnerStandeirdMoney.setColumns(3);

      shortStayRecuperateCareClinicMorningDinnerStandeirdMoney.setCharType(VRCharType.ONLY_DIGIT);

      shortStayRecuperateCareClinicMorningDinnerStandeirdMoney.setHorizontalAlignment(SwingConstants.RIGHT);

      shortStayRecuperateCareClinicMorningDinnerStandeirdMoney.setIMEMode(InputSubset.LATIN);

      shortStayRecuperateCareClinicMorningDinnerStandeirdMoney.setMaxLength(3);

      addShortStayRecuperateCareClinicMorningDinnerStandeirdMoney();
    }
    return shortStayRecuperateCareClinicMorningDinnerStandeirdMoney;

  }

  /**
   * �H���z�E���E���x�����擾���܂��B
   * @return �H���z�E���E���x��
   */
  public ACLabel getShortStayRecuperateCareClinicNoonDinnerStandeirdMoneyLabel(){
    if(shortStayRecuperateCareClinicNoonDinnerStandeirdMoneyLabel==null){

      shortStayRecuperateCareClinicNoonDinnerStandeirdMoneyLabel = new ACLabel();

      shortStayRecuperateCareClinicNoonDinnerStandeirdMoneyLabel.setText("��");

      addShortStayRecuperateCareClinicNoonDinnerStandeirdMoneyLabel();
    }
    return shortStayRecuperateCareClinicNoonDinnerStandeirdMoneyLabel;

  }

  /**
   * �H���z�E���E�e�L�X�g���擾���܂��B
   * @return �H���z�E���E�e�L�X�g
   */
  public ACTextField getShortStayRecuperateCareClinicNoonDinnerStandeirdMoney(){
    if(shortStayRecuperateCareClinicNoonDinnerStandeirdMoney==null){

      shortStayRecuperateCareClinicNoonDinnerStandeirdMoney = new ACTextField();

      shortStayRecuperateCareClinicNoonDinnerStandeirdMoney.setBindPath("1230210");

      shortStayRecuperateCareClinicNoonDinnerStandeirdMoney.setColumns(3);

      shortStayRecuperateCareClinicNoonDinnerStandeirdMoney.setCharType(VRCharType.ONLY_DIGIT);

      shortStayRecuperateCareClinicNoonDinnerStandeirdMoney.setHorizontalAlignment(SwingConstants.RIGHT);

      shortStayRecuperateCareClinicNoonDinnerStandeirdMoney.setIMEMode(InputSubset.LATIN);

      shortStayRecuperateCareClinicNoonDinnerStandeirdMoney.setMaxLength(3);

      addShortStayRecuperateCareClinicNoonDinnerStandeirdMoney();
    }
    return shortStayRecuperateCareClinicNoonDinnerStandeirdMoney;

  }

  /**
   * �H���z�E��E���x�����擾���܂��B
   * @return �H���z�E��E���x��
   */
  public ACLabel getShortStayRecuperateCareClinicNightDinnerStandeirdMoneyLabel(){
    if(shortStayRecuperateCareClinicNightDinnerStandeirdMoneyLabel==null){

      shortStayRecuperateCareClinicNightDinnerStandeirdMoneyLabel = new ACLabel();

      shortStayRecuperateCareClinicNightDinnerStandeirdMoneyLabel.setText("��");

      addShortStayRecuperateCareClinicNightDinnerStandeirdMoneyLabel();
    }
    return shortStayRecuperateCareClinicNightDinnerStandeirdMoneyLabel;

  }

  /**
   * �H���z�E��E�e�L�X�g���擾���܂��B
   * @return �H���z�E��E�e�L�X�g
   */
  public ACTextField getShortStayRecuperateCareClinicNightDinnerStandeirdMoney(){
    if(shortStayRecuperateCareClinicNightDinnerStandeirdMoney==null){

      shortStayRecuperateCareClinicNightDinnerStandeirdMoney = new ACTextField();

      shortStayRecuperateCareClinicNightDinnerStandeirdMoney.setBindPath("1230211");

      shortStayRecuperateCareClinicNightDinnerStandeirdMoney.setColumns(3);

      shortStayRecuperateCareClinicNightDinnerStandeirdMoney.setCharType(VRCharType.ONLY_DIGIT);

      shortStayRecuperateCareClinicNightDinnerStandeirdMoney.setHorizontalAlignment(SwingConstants.RIGHT);

      shortStayRecuperateCareClinicNightDinnerStandeirdMoney.setIMEMode(InputSubset.LATIN);

      shortStayRecuperateCareClinicNightDinnerStandeirdMoney.setMaxLength(3);

      addShortStayRecuperateCareClinicNightDinnerStandeirdMoney();
    }
    return shortStayRecuperateCareClinicNightDinnerStandeirdMoney;

  }

  /**
   * �H���z�E���x�����擾���܂��B
   * @return �H���z�E���x��
   */
  public ACLabel getShortStayRecuperateCareClinicDinnerStandeirdMoney4Label(){
    if(shortStayRecuperateCareClinicDinnerStandeirdMoney4Label==null){

      shortStayRecuperateCareClinicDinnerStandeirdMoney4Label = new ACLabel();

      shortStayRecuperateCareClinicDinnerStandeirdMoney4Label.setText("�i�~�j");

      addShortStayRecuperateCareClinicDinnerStandeirdMoney4Label();
    }
    return shortStayRecuperateCareClinicDinnerStandeirdMoney4Label;

  }

  /**
   * ���j�b�g�^����z�E�R���e�i���擾���܂��B
   * @return ���j�b�g�^����z�E�R���e�i
   */
  public ACLabelContainer getShortStayRecuperateCareClinicUnitRoomStandeirdMoneyConteiner(){
    if(shortStayRecuperateCareClinicUnitRoomStandeirdMoneyConteiner==null){

      shortStayRecuperateCareClinicUnitRoomStandeirdMoneyConteiner = new ACLabelContainer();

      shortStayRecuperateCareClinicUnitRoomStandeirdMoneyConteiner.setText("���j�b�g�^����z");

      shortStayRecuperateCareClinicUnitRoomStandeirdMoneyConteiner.setFollowChildEnabled(true);

      addShortStayRecuperateCareClinicUnitRoomStandeirdMoneyConteiner();
    }
    return shortStayRecuperateCareClinicUnitRoomStandeirdMoneyConteiner;

  }

  /**
   * ���j�b�g�^����z�E�e�L�X�g���擾���܂��B
   * @return ���j�b�g�^����z�E�e�L�X�g
   */
  public ACTextField getShortStayRecuperateCareClinicUnitRoomStandeirdMoneyText(){
    if(shortStayRecuperateCareClinicUnitRoomStandeirdMoneyText==null){

      shortStayRecuperateCareClinicUnitRoomStandeirdMoneyText = new ACTextField();

      shortStayRecuperateCareClinicUnitRoomStandeirdMoneyText.setBindPath("1230212");

      shortStayRecuperateCareClinicUnitRoomStandeirdMoneyText.setColumns(4);

      shortStayRecuperateCareClinicUnitRoomStandeirdMoneyText.setCharType(VRCharType.ONLY_DIGIT);

      shortStayRecuperateCareClinicUnitRoomStandeirdMoneyText.setHorizontalAlignment(SwingConstants.RIGHT);

      shortStayRecuperateCareClinicUnitRoomStandeirdMoneyText.setIMEMode(InputSubset.LATIN);

      shortStayRecuperateCareClinicUnitRoomStandeirdMoneyText.setMaxLength(4);

      addShortStayRecuperateCareClinicUnitRoomStandeirdMoneyText();
    }
    return shortStayRecuperateCareClinicUnitRoomStandeirdMoneyText;

  }

  /**
   * ���j�b�g�^����z�E���x�����擾���܂��B
   * @return ���j�b�g�^����z�E���x��
   */
  public ACLabel getShortStayRecuperateCareClinicUnitRoomStandeirdMoneyLabel(){
    if(shortStayRecuperateCareClinicUnitRoomStandeirdMoneyLabel==null){

      shortStayRecuperateCareClinicUnitRoomStandeirdMoneyLabel = new ACLabel();

      shortStayRecuperateCareClinicUnitRoomStandeirdMoneyLabel.setText("�i�~�j");

      addShortStayRecuperateCareClinicUnitRoomStandeirdMoneyLabel();
    }
    return shortStayRecuperateCareClinicUnitRoomStandeirdMoneyLabel;

  }

  /**
   * ���j�b�g�^������z�E�R���e�i���擾���܂��B
   * @return ���j�b�g�^������z�E�R���e�i
   */
  public ACLabelContainer getShortStayRecuperateCareClinicUnitSemiRoomStandeirdMoneyConteiner(){
    if(shortStayRecuperateCareClinicUnitSemiRoomStandeirdMoneyConteiner==null){

      shortStayRecuperateCareClinicUnitSemiRoomStandeirdMoneyConteiner = new ACLabelContainer();

      shortStayRecuperateCareClinicUnitSemiRoomStandeirdMoneyConteiner.setText("���j�b�g�^������z");

      shortStayRecuperateCareClinicUnitSemiRoomStandeirdMoneyConteiner.setFollowChildEnabled(true);

      addShortStayRecuperateCareClinicUnitSemiRoomStandeirdMoneyConteiner();
    }
    return shortStayRecuperateCareClinicUnitSemiRoomStandeirdMoneyConteiner;

  }

  /**
   * ���j�b�g�^������z�E�e�L�X�g���擾���܂��B
   * @return ���j�b�g�^������z�E�e�L�X�g
   */
  public ACTextField getShortStayRecuperateCareClinicUnitSemiRoomStandeirdMoneyText(){
    if(shortStayRecuperateCareClinicUnitSemiRoomStandeirdMoneyText==null){

      shortStayRecuperateCareClinicUnitSemiRoomStandeirdMoneyText = new ACTextField();

      shortStayRecuperateCareClinicUnitSemiRoomStandeirdMoneyText.setBindPath("1230213");

      shortStayRecuperateCareClinicUnitSemiRoomStandeirdMoneyText.setColumns(4);

      shortStayRecuperateCareClinicUnitSemiRoomStandeirdMoneyText.setCharType(VRCharType.ONLY_DIGIT);

      shortStayRecuperateCareClinicUnitSemiRoomStandeirdMoneyText.setHorizontalAlignment(SwingConstants.RIGHT);

      shortStayRecuperateCareClinicUnitSemiRoomStandeirdMoneyText.setIMEMode(InputSubset.LATIN);

      shortStayRecuperateCareClinicUnitSemiRoomStandeirdMoneyText.setMaxLength(4);

      addShortStayRecuperateCareClinicUnitSemiRoomStandeirdMoneyText();
    }
    return shortStayRecuperateCareClinicUnitSemiRoomStandeirdMoneyText;

  }

  /**
   * ���j�b�g�^������z�E���x�����擾���܂��B
   * @return ���j�b�g�^������z�E���x��
   */
  public ACLabel getShortStayRecuperateCareClinicUnitSemiRoomStandeirdMoneyLabel(){
    if(shortStayRecuperateCareClinicUnitSemiRoomStandeirdMoneyLabel==null){

      shortStayRecuperateCareClinicUnitSemiRoomStandeirdMoneyLabel = new ACLabel();

      shortStayRecuperateCareClinicUnitSemiRoomStandeirdMoneyLabel.setText("�i�~�j");

      addShortStayRecuperateCareClinicUnitSemiRoomStandeirdMoneyLabel();
    }
    return shortStayRecuperateCareClinicUnitSemiRoomStandeirdMoneyLabel;

  }

  /**
   * �]���^����z�E�R���e�i���擾���܂��B
   * @return �]���^����z�E�R���e�i
   */
  public ACLabelContainer getShortStayRecuperateCareClinicNormalRoomStandeirdMoneyConteiner(){
    if(shortStayRecuperateCareClinicNormalRoomStandeirdMoneyConteiner==null){

      shortStayRecuperateCareClinicNormalRoomStandeirdMoneyConteiner = new ACLabelContainer();

      shortStayRecuperateCareClinicNormalRoomStandeirdMoneyConteiner.setText("�@�@�]���^����z");

      shortStayRecuperateCareClinicNormalRoomStandeirdMoneyConteiner.setFollowChildEnabled(true);

      addShortStayRecuperateCareClinicNormalRoomStandeirdMoneyConteiner();
    }
    return shortStayRecuperateCareClinicNormalRoomStandeirdMoneyConteiner;

  }

  /**
   * �]���^����z�E�e�L�X�g���擾���܂��B
   * @return �]���^����z�E�e�L�X�g
   */
  public ACTextField getShortStayRecuperateCareClinicNormalRoomStandeirdMoneyText(){
    if(shortStayRecuperateCareClinicNormalRoomStandeirdMoneyText==null){

      shortStayRecuperateCareClinicNormalRoomStandeirdMoneyText = new ACTextField();

      shortStayRecuperateCareClinicNormalRoomStandeirdMoneyText.setBindPath("1230214");

      shortStayRecuperateCareClinicNormalRoomStandeirdMoneyText.setColumns(4);

      shortStayRecuperateCareClinicNormalRoomStandeirdMoneyText.setCharType(VRCharType.ONLY_DIGIT);

      shortStayRecuperateCareClinicNormalRoomStandeirdMoneyText.setHorizontalAlignment(SwingConstants.RIGHT);

      shortStayRecuperateCareClinicNormalRoomStandeirdMoneyText.setIMEMode(InputSubset.LATIN);

      shortStayRecuperateCareClinicNormalRoomStandeirdMoneyText.setMaxLength(4);

      addShortStayRecuperateCareClinicNormalRoomStandeirdMoneyText();
    }
    return shortStayRecuperateCareClinicNormalRoomStandeirdMoneyText;

  }

  /**
   * �]���^����z�E���x�����擾���܂��B
   * @return �]���^����z�E���x��
   */
  public ACLabel getShortStayRecuperateCareClinicNormalRoomStandeirdMoneyLabel(){
    if(shortStayRecuperateCareClinicNormalRoomStandeirdMoneyLabel==null){

      shortStayRecuperateCareClinicNormalRoomStandeirdMoneyLabel = new ACLabel();

      shortStayRecuperateCareClinicNormalRoomStandeirdMoneyLabel.setText("�i�~�j");

      addShortStayRecuperateCareClinicNormalRoomStandeirdMoneyLabel();
    }
    return shortStayRecuperateCareClinicNormalRoomStandeirdMoneyLabel;

  }

  /**
   * ��������z�E�R���e�i���擾���܂��B
   * @return ��������z�E�R���e�i
   */
  public ACLabelContainer getShortStayRecuperateCareClinicTasyouRoomConteiner(){
    if(shortStayRecuperateCareClinicTasyouRoomConteiner==null){

      shortStayRecuperateCareClinicTasyouRoomConteiner = new ACLabelContainer();

      shortStayRecuperateCareClinicTasyouRoomConteiner.setText("�@�@��������z");

      shortStayRecuperateCareClinicTasyouRoomConteiner.setFollowChildEnabled(true);

      addShortStayRecuperateCareClinicTasyouRoomConteiner();
    }
    return shortStayRecuperateCareClinicTasyouRoomConteiner;

  }

  /**
   * ��������z�E�e�L�X�g���擾���܂��B
   * @return ��������z�E�e�L�X�g
   */
  public ACTextField getShortStayRecuperateCareClinicTasyouRoomText(){
    if(shortStayRecuperateCareClinicTasyouRoomText==null){

      shortStayRecuperateCareClinicTasyouRoomText = new ACTextField();

      shortStayRecuperateCareClinicTasyouRoomText.setBindPath("1230215");

      shortStayRecuperateCareClinicTasyouRoomText.setColumns(4);

      shortStayRecuperateCareClinicTasyouRoomText.setCharType(VRCharType.ONLY_DIGIT);

      shortStayRecuperateCareClinicTasyouRoomText.setHorizontalAlignment(SwingConstants.RIGHT);

      shortStayRecuperateCareClinicTasyouRoomText.setIMEMode(InputSubset.LATIN);

      shortStayRecuperateCareClinicTasyouRoomText.setMaxLength(4);

      addShortStayRecuperateCareClinicTasyouRoomText();
    }
    return shortStayRecuperateCareClinicTasyouRoomText;

  }

  /**
   * ��������z�E���x�����擾���܂��B
   * @return ��������z�E���x��
   */
  public ACLabel getShortStayRecuperateCareClinicTasyouRoomLabel(){
    if(shortStayRecuperateCareClinicTasyouRoomLabel==null){

      shortStayRecuperateCareClinicTasyouRoomLabel = new ACLabel();

      shortStayRecuperateCareClinicTasyouRoomLabel.setText("�i�~�j");

      addShortStayRecuperateCareClinicTasyouRoomLabel();
    }
    return shortStayRecuperateCareClinicTasyouRoomLabel;

  }

  /**
   * �R���X�g���N�^�ł��B
   */
  public QO004011Design() {

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

    this.add(getShortStayClinicRecuperationGroup(), VRLayout.CLIENT);

  }

  /**
   * ���ƃO���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayClinicRecuperationGroup(){

    shortStayClinicRecuperationGroup.add(getShortStayClinicRecuperationDiscountContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayClinicRecuperationGroup.add(getShortStayInstitutionDivisionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayClinicRecuperationGroup.add(getShortStayStaffAssignmentDivisionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayClinicRecuperationGroup.add(getShortStayRecuperationEnvironmentalContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayClinicRecuperationGroup.add(getShortStayMeetingAndSendingOffSystemContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayClinicRecuperationGroup.add(getShortStayNutritionManageRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayClinicRecuperationGroup.add(getShortStayRecuperateDinnerRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayClinicRecuperationGroup.add(getShortStayStaffReduceContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayClinicRecuperationGroup.add(getShortStayRecuperateCareClinicDinnerStandeirdMoneyConteiner(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayClinicRecuperationGroup.add(getShortStayRecuperateCareClinicUnitRoomStandeirdMoneyConteiner(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayClinicRecuperationGroup.add(getShortStayRecuperateCareClinicUnitSemiRoomStandeirdMoneyConteiner(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayClinicRecuperationGroup.add(getShortStayRecuperateCareClinicNormalRoomStandeirdMoneyConteiner(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayClinicRecuperationGroup.add(getShortStayRecuperateCareClinicTasyouRoomConteiner(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * �������R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayClinicRecuperationDiscountContainer(){

    shortStayClinicRecuperationDiscountContainer.add(getShortStayClinicRecuperationDiscountRate(), VRLayout.FLOW);

    shortStayClinicRecuperationDiscountContainer.add(getShortStayPercentSign(), VRLayout.FLOW);

  }

  /**
   * �������ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayClinicRecuperationDiscountRate(){

  }

  /**
   * �����x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayPercentSign(){

  }

  /**
   * �{�݋敪���W�I�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayInstitutionDivisionRadio(){

  }

  /**
   * �{�݋敪���W�I�O���[�v���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayInstitutionDivisionRadioModel(){

    getShortStayInstitutionDivisionRadioItem1().setButtonIndex(1);
    getShortStayInstitutionDivisionRadioModel().add(getShortStayInstitutionDivisionRadioItem1());

    getShortStayInstitutionDivisionRadioItem2().setButtonIndex(2);
    getShortStayInstitutionDivisionRadioModel().add(getShortStayInstitutionDivisionRadioItem2());

  }

  /**
   * �f�Ï��ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayInstitutionDivisionRadioItem1(){

  }

  /**
   * ���j�b�g�^�f�Ï��ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayInstitutionDivisionRadioItem2(){

  }

  /**
   * �l���z�u�敪���W�I�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayStaffAssignmentDivision(){

  }

  /**
   * �l���z�u�敪���W�I�O���[�v���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayStaffAssignmentDivisionModel(){

    getShortStayStaffAssignmentDivision1().setButtonIndex(1);
    getShortStayStaffAssignmentDivisionModel().add(getShortStayStaffAssignmentDivision1());

    getShortStayStaffAssignmentDivision2().setButtonIndex(2);
    getShortStayStaffAssignmentDivisionModel().add(getShortStayStaffAssignmentDivision2());

  }

  /**
   * I�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayStaffAssignmentDivision1(){

  }

  /**
   * II�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayStaffAssignmentDivision2(){

  }

  /**
   * �×{������W�I�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperationEnvironmental(){

  }

  /**
   * �×{������W�I�O���[�v���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperationEnvironmentalModel(){

    getShortStayRecuperationEnvironmentalStandard().setButtonIndex(1);
    getShortStayRecuperationEnvironmentalModel().add(getShortStayRecuperationEnvironmentalStandard());

    getShortStayRecuperationEnvironmentalSubtraction1().setButtonIndex(2);
    getShortStayRecuperationEnvironmentalModel().add(getShortStayRecuperationEnvironmentalSubtraction1());

    getShortStayRecuperationEnvironmentalSubtraction2().setButtonIndex(3);
    getShortStayRecuperationEnvironmentalModel().add(getShortStayRecuperationEnvironmentalSubtraction2());

  }

  /**
   * ��^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperationEnvironmentalStandard(){

  }

  /**
   * ���Z�^I�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperationEnvironmentalSubtraction1(){

  }

  /**
   * ���Z�^II�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperationEnvironmentalSubtraction2(){

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

    getShortStayMeetingAndSendingOffSystemOff().setButtonIndex(1);
    getShortStayMeetingAndSendingOffSystemModel().add(getShortStayMeetingAndSendingOffSystemOff());

    getShortStayMeetingAndSendingOffSystemOn().setButtonIndex(2);
    getShortStayMeetingAndSendingOffSystemModel().add(getShortStayMeetingAndSendingOffSystemOn());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayMeetingAndSendingOffSystemOff(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayMeetingAndSendingOffSystemOn(){

  }

  /**
   * �h�{�Ǘ��̐����W�I�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayNutritionManageRadio(){

  }

  /**
   * �h�{�Ǘ��̐����W�I�O���[�v���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayNutritionManageRadioModel(){

    getShortStayNutritionManageRadioItem1().setButtonIndex(1);
    getShortStayNutritionManageRadioModel().add(getShortStayNutritionManageRadioItem1());

    getShortStayNutritionManageRadioItem2().setButtonIndex(2);
    getShortStayNutritionManageRadioModel().add(getShortStayNutritionManageRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayNutritionManageRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayNutritionManageRadioItem2(){

  }

  /**
   * �×{�H�̐����W�I�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperateDinnerRadio(){

  }

  /**
   * �×{�H�̐����W�I�O���[�v���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperateDinnerRadioModel(){

    getShortStayRecuperateDinnerRadioItem1().setButtonIndex(1);
    getShortStayRecuperateDinnerRadioModel().add(getShortStayRecuperateDinnerRadioItem1());

    getShortStayRecuperateDinnerRadioItem2().setButtonIndex(2);
    getShortStayRecuperateDinnerRadioModel().add(getShortStayRecuperateDinnerRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperateDinnerRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperateDinnerRadioItem2(){

  }

  /**
   * �l�����Z���W�I�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayStaffReduce(){

  }

  /**
   * �l�����Z���W�I�O���[�v���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayStaffReduceModel(){

    getShortStayStaffNot().setButtonIndex(1);
    getShortStayStaffReduceModel().add(getShortStayStaffNot());

    getShortStayStaffExcess().setButtonIndex(2);
    getShortStayStaffReduceModel().add(getShortStayStaffExcess());

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
   * �H���z�E�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperateCareClinicDinnerStandeirdMoneyConteiner(){

    shortStayRecuperateCareClinicDinnerStandeirdMoneyConteiner.add(getShortStayRecuperateCareClinicDinnerStandeirdMoneyTotal(), VRLayout.FLOW);

    shortStayRecuperateCareClinicDinnerStandeirdMoneyConteiner.add(getShortStayRecuperateCareClinicMorningDinnerStandeirdMoneyLabel(), VRLayout.FLOW);

    shortStayRecuperateCareClinicDinnerStandeirdMoneyConteiner.add(getShortStayRecuperateCareClinicMorningDinnerStandeirdMoney(), VRLayout.FLOW);

    shortStayRecuperateCareClinicDinnerStandeirdMoneyConteiner.add(getShortStayRecuperateCareClinicNoonDinnerStandeirdMoneyLabel(), VRLayout.FLOW);

    shortStayRecuperateCareClinicDinnerStandeirdMoneyConteiner.add(getShortStayRecuperateCareClinicNoonDinnerStandeirdMoney(), VRLayout.FLOW);

    shortStayRecuperateCareClinicDinnerStandeirdMoneyConteiner.add(getShortStayRecuperateCareClinicNightDinnerStandeirdMoneyLabel(), VRLayout.FLOW);

    shortStayRecuperateCareClinicDinnerStandeirdMoneyConteiner.add(getShortStayRecuperateCareClinicNightDinnerStandeirdMoney(), VRLayout.FLOW);

    shortStayRecuperateCareClinicDinnerStandeirdMoneyConteiner.add(getShortStayRecuperateCareClinicDinnerStandeirdMoney4Label(), VRLayout.FLOW);

  }

  /**
   * �H���z�E���v�E�e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperateCareClinicDinnerStandeirdMoneyTotal(){

  }

  /**
   * �H���z�E���E���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperateCareClinicMorningDinnerStandeirdMoneyLabel(){

  }

  /**
   * �H���z�E���E�e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperateCareClinicMorningDinnerStandeirdMoney(){

  }

  /**
   * �H���z�E���E���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperateCareClinicNoonDinnerStandeirdMoneyLabel(){

  }

  /**
   * �H���z�E���E�e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperateCareClinicNoonDinnerStandeirdMoney(){

  }

  /**
   * �H���z�E��E���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperateCareClinicNightDinnerStandeirdMoneyLabel(){

  }

  /**
   * �H���z�E��E�e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperateCareClinicNightDinnerStandeirdMoney(){

  }

  /**
   * �H���z�E���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperateCareClinicDinnerStandeirdMoney4Label(){

  }

  /**
   * ���j�b�g�^����z�E�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperateCareClinicUnitRoomStandeirdMoneyConteiner(){

    shortStayRecuperateCareClinicUnitRoomStandeirdMoneyConteiner.add(getShortStayRecuperateCareClinicUnitRoomStandeirdMoneyText(), null);

    shortStayRecuperateCareClinicUnitRoomStandeirdMoneyConteiner.add(getShortStayRecuperateCareClinicUnitRoomStandeirdMoneyLabel(), null);

  }

  /**
   * ���j�b�g�^����z�E�e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperateCareClinicUnitRoomStandeirdMoneyText(){

  }

  /**
   * ���j�b�g�^����z�E���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperateCareClinicUnitRoomStandeirdMoneyLabel(){

  }

  /**
   * ���j�b�g�^������z�E�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperateCareClinicUnitSemiRoomStandeirdMoneyConteiner(){

    shortStayRecuperateCareClinicUnitSemiRoomStandeirdMoneyConteiner.add(getShortStayRecuperateCareClinicUnitSemiRoomStandeirdMoneyText(), null);

    shortStayRecuperateCareClinicUnitSemiRoomStandeirdMoneyConteiner.add(getShortStayRecuperateCareClinicUnitSemiRoomStandeirdMoneyLabel(), null);

  }

  /**
   * ���j�b�g�^������z�E�e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperateCareClinicUnitSemiRoomStandeirdMoneyText(){

  }

  /**
   * ���j�b�g�^������z�E���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperateCareClinicUnitSemiRoomStandeirdMoneyLabel(){

  }

  /**
   * �]���^����z�E�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperateCareClinicNormalRoomStandeirdMoneyConteiner(){

    shortStayRecuperateCareClinicNormalRoomStandeirdMoneyConteiner.add(getShortStayRecuperateCareClinicNormalRoomStandeirdMoneyText(), null);

    shortStayRecuperateCareClinicNormalRoomStandeirdMoneyConteiner.add(getShortStayRecuperateCareClinicNormalRoomStandeirdMoneyLabel(), null);

  }

  /**
   * �]���^����z�E�e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperateCareClinicNormalRoomStandeirdMoneyText(){

  }

  /**
   * �]���^����z�E���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperateCareClinicNormalRoomStandeirdMoneyLabel(){

  }

  /**
   * ��������z�E�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperateCareClinicTasyouRoomConteiner(){

    shortStayRecuperateCareClinicTasyouRoomConteiner.add(getShortStayRecuperateCareClinicTasyouRoomText(), null);

    shortStayRecuperateCareClinicTasyouRoomConteiner.add(getShortStayRecuperateCareClinicTasyouRoomLabel(), null);

  }

  /**
   * ��������z�E�e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperateCareClinicTasyouRoomText(){

  }

  /**
   * ��������z�E���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperateCareClinicTasyouRoomLabel(){

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
      ACFrame.getInstance().getContentPane().add(new QO004011Design());
      ACFrame.getInstance().setVisible(true);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QO004011Design getThis() {
    return this;
  }
}
