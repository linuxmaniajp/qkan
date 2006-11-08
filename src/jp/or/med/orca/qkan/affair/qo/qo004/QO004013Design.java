
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
 * �v���O���� �Z�������×{����K���f�Ï��^ (QO004013)
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
 * �Z�������×{����K���f�Ï��^��ʍ��ڃf�U�C��(QO004013) 
 */
public class QO004013Design extends ACPanel {
  //GUI�R���|�[�l���g

  private ACGroupBox shortStayStandardAgreementRecuperationGroup;

  private ACLabelContainer shortStayStandardAgreementRecuperationDiscountContainer;

  private ACTextField shortStayStandardAgreementRecuperationDiscountRate;

  private ACLabel shortStayStandardAgreementRecuperationPercentSign;

  private ACClearableRadioButtonGroup shortStayStandardAgreementRecuperationMeetingAndSendingOffSystem;

  private ACLabelContainer shortStayStandardAgreementRecuperationMeetingAndSendingOffSystemContainer;

  private ACListModelAdapter shortStayStandardAgreementRecuperationMeetingAndSendingOffSystemModel;

  private ACRadioButtonItem shortStayStandardAgreementRecuperationMeetingAndSendingOffSystemOff;

  private ACRadioButtonItem shortStayStandardAgreementRecuperationMeetingAndSendingOffSystemOn;

  private ACClearableRadioButtonGroup shortStayStandardAgreementRecuperationNutritionManageRadio;

  private ACLabelContainer shortStayStandardAgreementRecuperationNutritionManageRadioContainer;

  private ACListModelAdapter shortStayStandardAgreementRecuperationNutritionManageRadioModel;

  private ACRadioButtonItem shortStayStandardAgreementRecuperationNutritionManageRadioItem1;

  private ACRadioButtonItem shortStayStandardAgreementRecuperationNutritionManageRadioItem2;

  private ACClearableRadioButtonGroup shortStayStandardAgreementRecuperationRecuperateRadio;

  private ACLabelContainer shortStayStandardAgreementRecuperationRecuperateRadioContainer;

  private ACListModelAdapter shortStayStandardAgreementRecuperationRecuperateRadioModel;

  private ACRadioButtonItem shortStayStandardAgreementRecuperationRecuperateRadioItem1;

  private ACRadioButtonItem shortStayStandardAgreementRecuperationRecuperateRadioItem2;

  private ACClearableRadioButtonGroup shortStayStandardAgreementRecuperationStaffReduceRadio;

  private ACLabelContainer shortStayStandardAgreementRecuperationStaffReduceRadioContainer;

  private ACListModelAdapter shortStayStandardAgreementRecuperationStaffReduceRadioModel;

  private ACRadioButtonItem shortStayStandardAgreementRecuperationStaffNot;

  private ACRadioButtonItem shortStayStandardAgreementRecuperationStaffExcess;

  private ACLabelContainer shortStayRecuperateCareStandardDinnerStandeirdMoneyConteiner;

  private ACTextField shortStayRecuperateCareStandardDinnerStandeirdMoneyTotal;

  private ACLabel shortStayRecuperateCareStandardMorningDinnerStandeirdMoneyLabel;

  private ACTextField shortStayRecuperateCareStandardMorningDinnerStandeirdMoney;

  private ACLabel shortStayRecuperateCareStandardNoonDinnerStandeirdMoneyLabel;

  private ACTextField shortStayRecuperateCareStandardNoonDinnerStandeirdMoney;

  private ACLabel shortStayRecuperateCareStandardNightDinnerStandeirdMoneyLabel;

  private ACTextField shortStayRecuperateCareStandardNightDinnerStandeirdMoney;

  private ACLabel shortStayRecuperateCareStandardDinnerStandeirdMoney4Label;

  private ACLabelContainer shortStayRecuperateCareStandardUnitRoomStandeirdMoneyConteiner;

  private ACTextField shortStayRecuperateCareStandardUnitRoomStandeirdMoneyText;

  private ACLabel shortStayRecuperateCareStandardUnitRoomStandeirdMoneyLabel;

  private ACLabelContainer shortStayRecuperateCareStandardUnitSemiRoomStandeirdMoneyConteiner;

  private ACTextField shortStayRecuperateCareStandardUnitSemiRoomStandeirdMoneyText;

  private ACLabel shortStayRecuperateCareStandardUnitSemiRoomStandeirdMoneyLabel;

  private ACLabelContainer shortStayRecuperateCareStandardNormalRoomStandeirdMoneyConteiner;

  private ACTextField shortStayRecuperateCareStandardNormalRoomStandeirdMoneyText;

  private ACLabel shortStayRecuperateCareStandardNormalRoomStandeirdMoneyLabel;

  private ACLabelContainer shortStayRecuperateCareStandardTasyouRoomConteiner;

  private ACTextField shortStayRecuperateCareStandardTasyouRoomText;

  private ACLabel shortStayRecuperateCareStandardTasyouRoomLabel;

  //getter

  /**
   * ���ƃO���[�v���擾���܂��B
   * @return ���ƃO���[�v
   */
  public ACGroupBox getShortStayStandardAgreementRecuperationGroup(){
    if(shortStayStandardAgreementRecuperationGroup==null){

      shortStayStandardAgreementRecuperationGroup = new ACGroupBox();

      shortStayStandardAgreementRecuperationGroup.setText("�Z�������×{���i��K���f�Ï��^�j");

      shortStayStandardAgreementRecuperationGroup.setFollowChildEnabled(true);

      shortStayStandardAgreementRecuperationGroup.setHgrid(200);

      addShortStayStandardAgreementRecuperationGroup();
    }
    return shortStayStandardAgreementRecuperationGroup;

  }

  /**
   * �������R���e�i���擾���܂��B
   * @return �������R���e�i
   */
  public ACLabelContainer getShortStayStandardAgreementRecuperationDiscountContainer(){
    if(shortStayStandardAgreementRecuperationDiscountContainer==null){

      shortStayStandardAgreementRecuperationDiscountContainer = new ACLabelContainer();

      shortStayStandardAgreementRecuperationDiscountContainer.setText("������");

      shortStayStandardAgreementRecuperationDiscountContainer.setFollowChildEnabled(true);

      addShortStayStandardAgreementRecuperationDiscountContainer();
    }
    return shortStayStandardAgreementRecuperationDiscountContainer;

  }

  /**
   * ���������擾���܂��B
   * @return ������
   */
  public ACTextField getShortStayStandardAgreementRecuperationDiscountRate(){
    if(shortStayStandardAgreementRecuperationDiscountRate==null){

      shortStayStandardAgreementRecuperationDiscountRate = new ACTextField();

      shortStayStandardAgreementRecuperationDiscountRate.setBindPath("REDUCT_RATE");

      shortStayStandardAgreementRecuperationDiscountRate.setColumns(3);

      shortStayStandardAgreementRecuperationDiscountRate.setCharType(VRCharType.ONLY_DIGIT);

      shortStayStandardAgreementRecuperationDiscountRate.setHorizontalAlignment(SwingConstants.RIGHT);

      shortStayStandardAgreementRecuperationDiscountRate.setIMEMode(InputSubset.LATIN);

      shortStayStandardAgreementRecuperationDiscountRate.setMaxLength(3);

      addShortStayStandardAgreementRecuperationDiscountRate();
    }
    return shortStayStandardAgreementRecuperationDiscountRate;

  }

  /**
   * �����x�����擾���܂��B
   * @return �����x��
   */
  public ACLabel getShortStayStandardAgreementRecuperationPercentSign(){
    if(shortStayStandardAgreementRecuperationPercentSign==null){

      shortStayStandardAgreementRecuperationPercentSign = new ACLabel();

      shortStayStandardAgreementRecuperationPercentSign.setText("��");

      addShortStayStandardAgreementRecuperationPercentSign();
    }
    return shortStayStandardAgreementRecuperationPercentSign;

  }

  /**
   * ���}�̐����W�I�O���[�v���擾���܂��B
   * @return ���}�̐����W�I�O���[�v
   */
  public ACClearableRadioButtonGroup getShortStayStandardAgreementRecuperationMeetingAndSendingOffSystem(){
    if(shortStayStandardAgreementRecuperationMeetingAndSendingOffSystem==null){

      shortStayStandardAgreementRecuperationMeetingAndSendingOffSystem = new ACClearableRadioButtonGroup();

      getShortStayStandardAgreementRecuperationMeetingAndSendingOffSystemContainer().setText("���}�̐�");

      shortStayStandardAgreementRecuperationMeetingAndSendingOffSystem.setBindPath("1230401");

      shortStayStandardAgreementRecuperationMeetingAndSendingOffSystem.setModel(getShortStayStandardAgreementRecuperationMeetingAndSendingOffSystemModel());

      shortStayStandardAgreementRecuperationMeetingAndSendingOffSystem.setUseClearButton(false);

      addShortStayStandardAgreementRecuperationMeetingAndSendingOffSystem();
    }
    return shortStayStandardAgreementRecuperationMeetingAndSendingOffSystem;

  }

  /**
   * ���}�̐����W�I�O���[�v�R���e�i���擾���܂��B
   * @return ���}�̐����W�I�O���[�v�R���e�i
   */
  protected ACLabelContainer getShortStayStandardAgreementRecuperationMeetingAndSendingOffSystemContainer(){
    if(shortStayStandardAgreementRecuperationMeetingAndSendingOffSystemContainer==null){
      shortStayStandardAgreementRecuperationMeetingAndSendingOffSystemContainer = new ACLabelContainer();
      shortStayStandardAgreementRecuperationMeetingAndSendingOffSystemContainer.setFollowChildEnabled(true);
      shortStayStandardAgreementRecuperationMeetingAndSendingOffSystemContainer.add(getShortStayStandardAgreementRecuperationMeetingAndSendingOffSystem(), null);
    }
    return shortStayStandardAgreementRecuperationMeetingAndSendingOffSystemContainer;
  }

  /**
   * ���}�̐����W�I�O���[�v���f�����擾���܂��B
   * @return ���}�̐����W�I�O���[�v���f��
   */
  protected ACListModelAdapter getShortStayStandardAgreementRecuperationMeetingAndSendingOffSystemModel(){
    if(shortStayStandardAgreementRecuperationMeetingAndSendingOffSystemModel==null){
      shortStayStandardAgreementRecuperationMeetingAndSendingOffSystemModel = new ACListModelAdapter();
      addShortStayStandardAgreementRecuperationMeetingAndSendingOffSystemModel();
    }
    return shortStayStandardAgreementRecuperationMeetingAndSendingOffSystemModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getShortStayStandardAgreementRecuperationMeetingAndSendingOffSystemOff(){
    if(shortStayStandardAgreementRecuperationMeetingAndSendingOffSystemOff==null){

      shortStayStandardAgreementRecuperationMeetingAndSendingOffSystemOff = new ACRadioButtonItem();

      shortStayStandardAgreementRecuperationMeetingAndSendingOffSystemOff.setText("�Ȃ�");

      shortStayStandardAgreementRecuperationMeetingAndSendingOffSystemOff.setGroup(getShortStayStandardAgreementRecuperationMeetingAndSendingOffSystem());

      addShortStayStandardAgreementRecuperationMeetingAndSendingOffSystemOff();
    }
    return shortStayStandardAgreementRecuperationMeetingAndSendingOffSystemOff;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getShortStayStandardAgreementRecuperationMeetingAndSendingOffSystemOn(){
    if(shortStayStandardAgreementRecuperationMeetingAndSendingOffSystemOn==null){

      shortStayStandardAgreementRecuperationMeetingAndSendingOffSystemOn = new ACRadioButtonItem();

      shortStayStandardAgreementRecuperationMeetingAndSendingOffSystemOn.setText("����");

      shortStayStandardAgreementRecuperationMeetingAndSendingOffSystemOn.setGroup(getShortStayStandardAgreementRecuperationMeetingAndSendingOffSystem());

      addShortStayStandardAgreementRecuperationMeetingAndSendingOffSystemOn();
    }
    return shortStayStandardAgreementRecuperationMeetingAndSendingOffSystemOn;

  }

  /**
   * �h�{�Ǘ��̐����W�I�O���[�v���擾���܂��B
   * @return �h�{�Ǘ��̐����W�I�O���[�v
   */
  public ACClearableRadioButtonGroup getShortStayStandardAgreementRecuperationNutritionManageRadio(){
    if(shortStayStandardAgreementRecuperationNutritionManageRadio==null){

      shortStayStandardAgreementRecuperationNutritionManageRadio = new ACClearableRadioButtonGroup();

      getShortStayStandardAgreementRecuperationNutritionManageRadioContainer().setText("�h�{�Ǘ��̐�");

      shortStayStandardAgreementRecuperationNutritionManageRadio.setBindPath("1230402");

      shortStayStandardAgreementRecuperationNutritionManageRadio.setModel(getShortStayStandardAgreementRecuperationNutritionManageRadioModel());

      shortStayStandardAgreementRecuperationNutritionManageRadio.setUseClearButton(false);

      addShortStayStandardAgreementRecuperationNutritionManageRadio();
    }
    return shortStayStandardAgreementRecuperationNutritionManageRadio;

  }

  /**
   * �h�{�Ǘ��̐����W�I�O���[�v�R���e�i���擾���܂��B
   * @return �h�{�Ǘ��̐����W�I�O���[�v�R���e�i
   */
  protected ACLabelContainer getShortStayStandardAgreementRecuperationNutritionManageRadioContainer(){
    if(shortStayStandardAgreementRecuperationNutritionManageRadioContainer==null){
      shortStayStandardAgreementRecuperationNutritionManageRadioContainer = new ACLabelContainer();
      shortStayStandardAgreementRecuperationNutritionManageRadioContainer.setFollowChildEnabled(true);
      shortStayStandardAgreementRecuperationNutritionManageRadioContainer.add(getShortStayStandardAgreementRecuperationNutritionManageRadio(), null);
    }
    return shortStayStandardAgreementRecuperationNutritionManageRadioContainer;
  }

  /**
   * �h�{�Ǘ��̐����W�I�O���[�v���f�����擾���܂��B
   * @return �h�{�Ǘ��̐����W�I�O���[�v���f��
   */
  protected ACListModelAdapter getShortStayStandardAgreementRecuperationNutritionManageRadioModel(){
    if(shortStayStandardAgreementRecuperationNutritionManageRadioModel==null){
      shortStayStandardAgreementRecuperationNutritionManageRadioModel = new ACListModelAdapter();
      addShortStayStandardAgreementRecuperationNutritionManageRadioModel();
    }
    return shortStayStandardAgreementRecuperationNutritionManageRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getShortStayStandardAgreementRecuperationNutritionManageRadioItem1(){
    if(shortStayStandardAgreementRecuperationNutritionManageRadioItem1==null){

      shortStayStandardAgreementRecuperationNutritionManageRadioItem1 = new ACRadioButtonItem();

      shortStayStandardAgreementRecuperationNutritionManageRadioItem1.setText("�Ȃ�");

      shortStayStandardAgreementRecuperationNutritionManageRadioItem1.setGroup(getShortStayStandardAgreementRecuperationNutritionManageRadio());

      addShortStayStandardAgreementRecuperationNutritionManageRadioItem1();
    }
    return shortStayStandardAgreementRecuperationNutritionManageRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getShortStayStandardAgreementRecuperationNutritionManageRadioItem2(){
    if(shortStayStandardAgreementRecuperationNutritionManageRadioItem2==null){

      shortStayStandardAgreementRecuperationNutritionManageRadioItem2 = new ACRadioButtonItem();

      shortStayStandardAgreementRecuperationNutritionManageRadioItem2.setText("����");

      shortStayStandardAgreementRecuperationNutritionManageRadioItem2.setGroup(getShortStayStandardAgreementRecuperationNutritionManageRadio());

      addShortStayStandardAgreementRecuperationNutritionManageRadioItem2();
    }
    return shortStayStandardAgreementRecuperationNutritionManageRadioItem2;

  }

  /**
   * �×{�H�̐����W�I�O���[�v���擾���܂��B
   * @return �×{�H�̐����W�I�O���[�v
   */
  public ACClearableRadioButtonGroup getShortStayStandardAgreementRecuperationRecuperateRadio(){
    if(shortStayStandardAgreementRecuperationRecuperateRadio==null){

      shortStayStandardAgreementRecuperationRecuperateRadio = new ACClearableRadioButtonGroup();

      getShortStayStandardAgreementRecuperationRecuperateRadioContainer().setText("�×{�H�̐�");

      shortStayStandardAgreementRecuperationRecuperateRadio.setBindPath("1230403");

      shortStayStandardAgreementRecuperationRecuperateRadio.setModel(getShortStayStandardAgreementRecuperationRecuperateRadioModel());

      shortStayStandardAgreementRecuperationRecuperateRadio.setUseClearButton(false);

      addShortStayStandardAgreementRecuperationRecuperateRadio();
    }
    return shortStayStandardAgreementRecuperationRecuperateRadio;

  }

  /**
   * �×{�H�̐����W�I�O���[�v�R���e�i���擾���܂��B
   * @return �×{�H�̐����W�I�O���[�v�R���e�i
   */
  protected ACLabelContainer getShortStayStandardAgreementRecuperationRecuperateRadioContainer(){
    if(shortStayStandardAgreementRecuperationRecuperateRadioContainer==null){
      shortStayStandardAgreementRecuperationRecuperateRadioContainer = new ACLabelContainer();
      shortStayStandardAgreementRecuperationRecuperateRadioContainer.setFollowChildEnabled(true);
      shortStayStandardAgreementRecuperationRecuperateRadioContainer.add(getShortStayStandardAgreementRecuperationRecuperateRadio(), null);
    }
    return shortStayStandardAgreementRecuperationRecuperateRadioContainer;
  }

  /**
   * �×{�H�̐����W�I�O���[�v���f�����擾���܂��B
   * @return �×{�H�̐����W�I�O���[�v���f��
   */
  protected ACListModelAdapter getShortStayStandardAgreementRecuperationRecuperateRadioModel(){
    if(shortStayStandardAgreementRecuperationRecuperateRadioModel==null){
      shortStayStandardAgreementRecuperationRecuperateRadioModel = new ACListModelAdapter();
      addShortStayStandardAgreementRecuperationRecuperateRadioModel();
    }
    return shortStayStandardAgreementRecuperationRecuperateRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getShortStayStandardAgreementRecuperationRecuperateRadioItem1(){
    if(shortStayStandardAgreementRecuperationRecuperateRadioItem1==null){

      shortStayStandardAgreementRecuperationRecuperateRadioItem1 = new ACRadioButtonItem();

      shortStayStandardAgreementRecuperationRecuperateRadioItem1.setText("�Ȃ�");

      shortStayStandardAgreementRecuperationRecuperateRadioItem1.setGroup(getShortStayStandardAgreementRecuperationRecuperateRadio());

      addShortStayStandardAgreementRecuperationRecuperateRadioItem1();
    }
    return shortStayStandardAgreementRecuperationRecuperateRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getShortStayStandardAgreementRecuperationRecuperateRadioItem2(){
    if(shortStayStandardAgreementRecuperationRecuperateRadioItem2==null){

      shortStayStandardAgreementRecuperationRecuperateRadioItem2 = new ACRadioButtonItem();

      shortStayStandardAgreementRecuperationRecuperateRadioItem2.setText("����");

      shortStayStandardAgreementRecuperationRecuperateRadioItem2.setGroup(getShortStayStandardAgreementRecuperationRecuperateRadio());

      addShortStayStandardAgreementRecuperationRecuperateRadioItem2();
    }
    return shortStayStandardAgreementRecuperationRecuperateRadioItem2;

  }

  /**
   * �l�����Z���W�I�O���[�v���擾���܂��B
   * @return �l�����Z���W�I�O���[�v
   */
  public ACClearableRadioButtonGroup getShortStayStandardAgreementRecuperationStaffReduceRadio(){
    if(shortStayStandardAgreementRecuperationStaffReduceRadio==null){

      shortStayStandardAgreementRecuperationStaffReduceRadio = new ACClearableRadioButtonGroup();

      getShortStayStandardAgreementRecuperationStaffReduceRadioContainer().setText("�l�����Z");

      shortStayStandardAgreementRecuperationStaffReduceRadio.setBindPath("1230404");

      shortStayStandardAgreementRecuperationStaffReduceRadio.setModel(getShortStayStandardAgreementRecuperationStaffReduceRadioModel());

      shortStayStandardAgreementRecuperationStaffReduceRadio.setUseClearButton(false);

      addShortStayStandardAgreementRecuperationStaffReduceRadio();
    }
    return shortStayStandardAgreementRecuperationStaffReduceRadio;

  }

  /**
   * �l�����Z���W�I�O���[�v�R���e�i���擾���܂��B
   * @return �l�����Z���W�I�O���[�v�R���e�i
   */
  protected ACLabelContainer getShortStayStandardAgreementRecuperationStaffReduceRadioContainer(){
    if(shortStayStandardAgreementRecuperationStaffReduceRadioContainer==null){
      shortStayStandardAgreementRecuperationStaffReduceRadioContainer = new ACLabelContainer();
      shortStayStandardAgreementRecuperationStaffReduceRadioContainer.setFollowChildEnabled(true);
      shortStayStandardAgreementRecuperationStaffReduceRadioContainer.add(getShortStayStandardAgreementRecuperationStaffReduceRadio(), null);
    }
    return shortStayStandardAgreementRecuperationStaffReduceRadioContainer;
  }

  /**
   * �l�����Z���W�I�O���[�v���f�����擾���܂��B
   * @return �l�����Z���W�I�O���[�v���f��
   */
  protected ACListModelAdapter getShortStayStandardAgreementRecuperationStaffReduceRadioModel(){
    if(shortStayStandardAgreementRecuperationStaffReduceRadioModel==null){
      shortStayStandardAgreementRecuperationStaffReduceRadioModel = new ACListModelAdapter();
      addShortStayStandardAgreementRecuperationStaffReduceRadioModel();
    }
    return shortStayStandardAgreementRecuperationStaffReduceRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getShortStayStandardAgreementRecuperationStaffNot(){
    if(shortStayStandardAgreementRecuperationStaffNot==null){

      shortStayStandardAgreementRecuperationStaffNot = new ACRadioButtonItem();

      shortStayStandardAgreementRecuperationStaffNot.setText("�Ȃ�");

      shortStayStandardAgreementRecuperationStaffNot.setGroup(getShortStayStandardAgreementRecuperationStaffReduceRadio());

      addShortStayStandardAgreementRecuperationStaffNot();
    }
    return shortStayStandardAgreementRecuperationStaffNot;

  }

  /**
   * ������߂��擾���܂��B
   * @return �������
   */
  public ACRadioButtonItem getShortStayStandardAgreementRecuperationStaffExcess(){
    if(shortStayStandardAgreementRecuperationStaffExcess==null){

      shortStayStandardAgreementRecuperationStaffExcess = new ACRadioButtonItem();

      shortStayStandardAgreementRecuperationStaffExcess.setText("�������");

      shortStayStandardAgreementRecuperationStaffExcess.setGroup(getShortStayStandardAgreementRecuperationStaffReduceRadio());

      addShortStayStandardAgreementRecuperationStaffExcess();
    }
    return shortStayStandardAgreementRecuperationStaffExcess;

  }

  /**
   * �H���z�E�R���e�i���擾���܂��B
   * @return �H���z�E�R���e�i
   */
  public ACLabelContainer getShortStayRecuperateCareStandardDinnerStandeirdMoneyConteiner(){
    if(shortStayRecuperateCareStandardDinnerStandeirdMoneyConteiner==null){

      shortStayRecuperateCareStandardDinnerStandeirdMoneyConteiner = new ACLabelContainer();

      shortStayRecuperateCareStandardDinnerStandeirdMoneyConteiner.setText("�H���z");

      shortStayRecuperateCareStandardDinnerStandeirdMoneyConteiner.setFollowChildEnabled(true);

      addShortStayRecuperateCareStandardDinnerStandeirdMoneyConteiner();
    }
    return shortStayRecuperateCareStandardDinnerStandeirdMoneyConteiner;

  }

  /**
   * �H���z�E���v�E�e�L�X�g���擾���܂��B
   * @return �H���z�E���v�E�e�L�X�g
   */
  public ACTextField getShortStayRecuperateCareStandardDinnerStandeirdMoneyTotal(){
    if(shortStayRecuperateCareStandardDinnerStandeirdMoneyTotal==null){

      shortStayRecuperateCareStandardDinnerStandeirdMoneyTotal = new ACTextField();

      shortStayRecuperateCareStandardDinnerStandeirdMoneyTotal.setBindPath("1230405");

      shortStayRecuperateCareStandardDinnerStandeirdMoneyTotal.setEditable(false);

      shortStayRecuperateCareStandardDinnerStandeirdMoneyTotal.setColumns(4);

      shortStayRecuperateCareStandardDinnerStandeirdMoneyTotal.setCharType(VRCharType.ONLY_DIGIT);

      shortStayRecuperateCareStandardDinnerStandeirdMoneyTotal.setHorizontalAlignment(SwingConstants.RIGHT);

      shortStayRecuperateCareStandardDinnerStandeirdMoneyTotal.setIMEMode(InputSubset.LATIN);

      shortStayRecuperateCareStandardDinnerStandeirdMoneyTotal.setMaxLength(4);

      addShortStayRecuperateCareStandardDinnerStandeirdMoneyTotal();
    }
    return shortStayRecuperateCareStandardDinnerStandeirdMoneyTotal;

  }

  /**
   * �H���z�E���E���x�����擾���܂��B
   * @return �H���z�E���E���x��
   */
  public ACLabel getShortStayRecuperateCareStandardMorningDinnerStandeirdMoneyLabel(){
    if(shortStayRecuperateCareStandardMorningDinnerStandeirdMoneyLabel==null){

      shortStayRecuperateCareStandardMorningDinnerStandeirdMoneyLabel = new ACLabel();

      shortStayRecuperateCareStandardMorningDinnerStandeirdMoneyLabel.setText("�@��");

      addShortStayRecuperateCareStandardMorningDinnerStandeirdMoneyLabel();
    }
    return shortStayRecuperateCareStandardMorningDinnerStandeirdMoneyLabel;

  }

  /**
   * �H���z�E���E�e�L�X�g���擾���܂��B
   * @return �H���z�E���E�e�L�X�g
   */
  public ACTextField getShortStayRecuperateCareStandardMorningDinnerStandeirdMoney(){
    if(shortStayRecuperateCareStandardMorningDinnerStandeirdMoney==null){

      shortStayRecuperateCareStandardMorningDinnerStandeirdMoney = new ACTextField();

      shortStayRecuperateCareStandardMorningDinnerStandeirdMoney.setBindPath("1230406");

      shortStayRecuperateCareStandardMorningDinnerStandeirdMoney.setColumns(3);

      shortStayRecuperateCareStandardMorningDinnerStandeirdMoney.setCharType(VRCharType.ONLY_DIGIT);

      shortStayRecuperateCareStandardMorningDinnerStandeirdMoney.setHorizontalAlignment(SwingConstants.RIGHT);

      shortStayRecuperateCareStandardMorningDinnerStandeirdMoney.setIMEMode(InputSubset.LATIN);

      shortStayRecuperateCareStandardMorningDinnerStandeirdMoney.setMaxLength(3);

      addShortStayRecuperateCareStandardMorningDinnerStandeirdMoney();
    }
    return shortStayRecuperateCareStandardMorningDinnerStandeirdMoney;

  }

  /**
   * �H���z�E���E���x�����擾���܂��B
   * @return �H���z�E���E���x��
   */
  public ACLabel getShortStayRecuperateCareStandardNoonDinnerStandeirdMoneyLabel(){
    if(shortStayRecuperateCareStandardNoonDinnerStandeirdMoneyLabel==null){

      shortStayRecuperateCareStandardNoonDinnerStandeirdMoneyLabel = new ACLabel();

      shortStayRecuperateCareStandardNoonDinnerStandeirdMoneyLabel.setText("��");

      addShortStayRecuperateCareStandardNoonDinnerStandeirdMoneyLabel();
    }
    return shortStayRecuperateCareStandardNoonDinnerStandeirdMoneyLabel;

  }

  /**
   * �H���z�E���E�e�L�X�g���擾���܂��B
   * @return �H���z�E���E�e�L�X�g
   */
  public ACTextField getShortStayRecuperateCareStandardNoonDinnerStandeirdMoney(){
    if(shortStayRecuperateCareStandardNoonDinnerStandeirdMoney==null){

      shortStayRecuperateCareStandardNoonDinnerStandeirdMoney = new ACTextField();

      shortStayRecuperateCareStandardNoonDinnerStandeirdMoney.setBindPath("1230407");

      shortStayRecuperateCareStandardNoonDinnerStandeirdMoney.setColumns(3);

      shortStayRecuperateCareStandardNoonDinnerStandeirdMoney.setCharType(VRCharType.ONLY_DIGIT);

      shortStayRecuperateCareStandardNoonDinnerStandeirdMoney.setHorizontalAlignment(SwingConstants.RIGHT);

      shortStayRecuperateCareStandardNoonDinnerStandeirdMoney.setIMEMode(InputSubset.LATIN);

      shortStayRecuperateCareStandardNoonDinnerStandeirdMoney.setMaxLength(3);

      addShortStayRecuperateCareStandardNoonDinnerStandeirdMoney();
    }
    return shortStayRecuperateCareStandardNoonDinnerStandeirdMoney;

  }

  /**
   * �H���z�E��E���x�����擾���܂��B
   * @return �H���z�E��E���x��
   */
  public ACLabel getShortStayRecuperateCareStandardNightDinnerStandeirdMoneyLabel(){
    if(shortStayRecuperateCareStandardNightDinnerStandeirdMoneyLabel==null){

      shortStayRecuperateCareStandardNightDinnerStandeirdMoneyLabel = new ACLabel();

      shortStayRecuperateCareStandardNightDinnerStandeirdMoneyLabel.setText("��");

      addShortStayRecuperateCareStandardNightDinnerStandeirdMoneyLabel();
    }
    return shortStayRecuperateCareStandardNightDinnerStandeirdMoneyLabel;

  }

  /**
   * �H���z�E��E�e�L�X�g���擾���܂��B
   * @return �H���z�E��E�e�L�X�g
   */
  public ACTextField getShortStayRecuperateCareStandardNightDinnerStandeirdMoney(){
    if(shortStayRecuperateCareStandardNightDinnerStandeirdMoney==null){

      shortStayRecuperateCareStandardNightDinnerStandeirdMoney = new ACTextField();

      shortStayRecuperateCareStandardNightDinnerStandeirdMoney.setBindPath("1230408");

      shortStayRecuperateCareStandardNightDinnerStandeirdMoney.setColumns(3);

      shortStayRecuperateCareStandardNightDinnerStandeirdMoney.setCharType(VRCharType.ONLY_DIGIT);

      shortStayRecuperateCareStandardNightDinnerStandeirdMoney.setHorizontalAlignment(SwingConstants.RIGHT);

      shortStayRecuperateCareStandardNightDinnerStandeirdMoney.setIMEMode(InputSubset.LATIN);

      shortStayRecuperateCareStandardNightDinnerStandeirdMoney.setMaxLength(3);

      addShortStayRecuperateCareStandardNightDinnerStandeirdMoney();
    }
    return shortStayRecuperateCareStandardNightDinnerStandeirdMoney;

  }

  /**
   * �H���z�E���x�����擾���܂��B
   * @return �H���z�E���x��
   */
  public ACLabel getShortStayRecuperateCareStandardDinnerStandeirdMoney4Label(){
    if(shortStayRecuperateCareStandardDinnerStandeirdMoney4Label==null){

      shortStayRecuperateCareStandardDinnerStandeirdMoney4Label = new ACLabel();

      shortStayRecuperateCareStandardDinnerStandeirdMoney4Label.setText("�i�~�j");

      addShortStayRecuperateCareStandardDinnerStandeirdMoney4Label();
    }
    return shortStayRecuperateCareStandardDinnerStandeirdMoney4Label;

  }

  /**
   * ���j�b�g�^����z�E�R���e�i���擾���܂��B
   * @return ���j�b�g�^����z�E�R���e�i
   */
  public ACLabelContainer getShortStayRecuperateCareStandardUnitRoomStandeirdMoneyConteiner(){
    if(shortStayRecuperateCareStandardUnitRoomStandeirdMoneyConteiner==null){

      shortStayRecuperateCareStandardUnitRoomStandeirdMoneyConteiner = new ACLabelContainer();

      shortStayRecuperateCareStandardUnitRoomStandeirdMoneyConteiner.setText("���j�b�g�^����z");

      shortStayRecuperateCareStandardUnitRoomStandeirdMoneyConteiner.setFollowChildEnabled(true);

      addShortStayRecuperateCareStandardUnitRoomStandeirdMoneyConteiner();
    }
    return shortStayRecuperateCareStandardUnitRoomStandeirdMoneyConteiner;

  }

  /**
   * ���j�b�g�^����z�E�e�L�X�g���擾���܂��B
   * @return ���j�b�g�^����z�E�e�L�X�g
   */
  public ACTextField getShortStayRecuperateCareStandardUnitRoomStandeirdMoneyText(){
    if(shortStayRecuperateCareStandardUnitRoomStandeirdMoneyText==null){

      shortStayRecuperateCareStandardUnitRoomStandeirdMoneyText = new ACTextField();

      shortStayRecuperateCareStandardUnitRoomStandeirdMoneyText.setBindPath("1230409");

      shortStayRecuperateCareStandardUnitRoomStandeirdMoneyText.setColumns(4);

      shortStayRecuperateCareStandardUnitRoomStandeirdMoneyText.setCharType(VRCharType.ONLY_DIGIT);

      shortStayRecuperateCareStandardUnitRoomStandeirdMoneyText.setHorizontalAlignment(SwingConstants.RIGHT);

      shortStayRecuperateCareStandardUnitRoomStandeirdMoneyText.setIMEMode(InputSubset.LATIN);

      shortStayRecuperateCareStandardUnitRoomStandeirdMoneyText.setMaxLength(4);

      addShortStayRecuperateCareStandardUnitRoomStandeirdMoneyText();
    }
    return shortStayRecuperateCareStandardUnitRoomStandeirdMoneyText;

  }

  /**
   * ���j�b�g�^����z�E���x�����擾���܂��B
   * @return ���j�b�g�^����z�E���x��
   */
  public ACLabel getShortStayRecuperateCareStandardUnitRoomStandeirdMoneyLabel(){
    if(shortStayRecuperateCareStandardUnitRoomStandeirdMoneyLabel==null){

      shortStayRecuperateCareStandardUnitRoomStandeirdMoneyLabel = new ACLabel();

      shortStayRecuperateCareStandardUnitRoomStandeirdMoneyLabel.setText("�i�~�j");

      addShortStayRecuperateCareStandardUnitRoomStandeirdMoneyLabel();
    }
    return shortStayRecuperateCareStandardUnitRoomStandeirdMoneyLabel;

  }

  /**
   * ���j�b�g�^������z�E�R���e�i���擾���܂��B
   * @return ���j�b�g�^������z�E�R���e�i
   */
  public ACLabelContainer getShortStayRecuperateCareStandardUnitSemiRoomStandeirdMoneyConteiner(){
    if(shortStayRecuperateCareStandardUnitSemiRoomStandeirdMoneyConteiner==null){

      shortStayRecuperateCareStandardUnitSemiRoomStandeirdMoneyConteiner = new ACLabelContainer();

      shortStayRecuperateCareStandardUnitSemiRoomStandeirdMoneyConteiner.setText("���j�b�g�^������z");

      shortStayRecuperateCareStandardUnitSemiRoomStandeirdMoneyConteiner.setFollowChildEnabled(true);

      addShortStayRecuperateCareStandardUnitSemiRoomStandeirdMoneyConteiner();
    }
    return shortStayRecuperateCareStandardUnitSemiRoomStandeirdMoneyConteiner;

  }

  /**
   * ���j�b�g�^������z�E�e�L�X�g���擾���܂��B
   * @return ���j�b�g�^������z�E�e�L�X�g
   */
  public ACTextField getShortStayRecuperateCareStandardUnitSemiRoomStandeirdMoneyText(){
    if(shortStayRecuperateCareStandardUnitSemiRoomStandeirdMoneyText==null){

      shortStayRecuperateCareStandardUnitSemiRoomStandeirdMoneyText = new ACTextField();

      shortStayRecuperateCareStandardUnitSemiRoomStandeirdMoneyText.setBindPath("1230410");

      shortStayRecuperateCareStandardUnitSemiRoomStandeirdMoneyText.setColumns(4);

      shortStayRecuperateCareStandardUnitSemiRoomStandeirdMoneyText.setCharType(VRCharType.ONLY_DIGIT);

      shortStayRecuperateCareStandardUnitSemiRoomStandeirdMoneyText.setHorizontalAlignment(SwingConstants.RIGHT);

      shortStayRecuperateCareStandardUnitSemiRoomStandeirdMoneyText.setIMEMode(InputSubset.LATIN);

      shortStayRecuperateCareStandardUnitSemiRoomStandeirdMoneyText.setMaxLength(4);

      addShortStayRecuperateCareStandardUnitSemiRoomStandeirdMoneyText();
    }
    return shortStayRecuperateCareStandardUnitSemiRoomStandeirdMoneyText;

  }

  /**
   * ���j�b�g�^������z�E���x�����擾���܂��B
   * @return ���j�b�g�^������z�E���x��
   */
  public ACLabel getShortStayRecuperateCareStandardUnitSemiRoomStandeirdMoneyLabel(){
    if(shortStayRecuperateCareStandardUnitSemiRoomStandeirdMoneyLabel==null){

      shortStayRecuperateCareStandardUnitSemiRoomStandeirdMoneyLabel = new ACLabel();

      shortStayRecuperateCareStandardUnitSemiRoomStandeirdMoneyLabel.setText("�i�~�j");

      addShortStayRecuperateCareStandardUnitSemiRoomStandeirdMoneyLabel();
    }
    return shortStayRecuperateCareStandardUnitSemiRoomStandeirdMoneyLabel;

  }

  /**
   * �]���^����z�E�R���e�i���擾���܂��B
   * @return �]���^����z�E�R���e�i
   */
  public ACLabelContainer getShortStayRecuperateCareStandardNormalRoomStandeirdMoneyConteiner(){
    if(shortStayRecuperateCareStandardNormalRoomStandeirdMoneyConteiner==null){

      shortStayRecuperateCareStandardNormalRoomStandeirdMoneyConteiner = new ACLabelContainer();

      shortStayRecuperateCareStandardNormalRoomStandeirdMoneyConteiner.setText("�@�@�]���^����z");

      shortStayRecuperateCareStandardNormalRoomStandeirdMoneyConteiner.setFollowChildEnabled(true);

      addShortStayRecuperateCareStandardNormalRoomStandeirdMoneyConteiner();
    }
    return shortStayRecuperateCareStandardNormalRoomStandeirdMoneyConteiner;

  }

  /**
   * �]���^����z�E�e�L�X�g���擾���܂��B
   * @return �]���^����z�E�e�L�X�g
   */
  public ACTextField getShortStayRecuperateCareStandardNormalRoomStandeirdMoneyText(){
    if(shortStayRecuperateCareStandardNormalRoomStandeirdMoneyText==null){

      shortStayRecuperateCareStandardNormalRoomStandeirdMoneyText = new ACTextField();

      shortStayRecuperateCareStandardNormalRoomStandeirdMoneyText.setBindPath("1230411");

      shortStayRecuperateCareStandardNormalRoomStandeirdMoneyText.setColumns(4);

      shortStayRecuperateCareStandardNormalRoomStandeirdMoneyText.setCharType(VRCharType.ONLY_DIGIT);

      shortStayRecuperateCareStandardNormalRoomStandeirdMoneyText.setHorizontalAlignment(SwingConstants.RIGHT);

      shortStayRecuperateCareStandardNormalRoomStandeirdMoneyText.setIMEMode(InputSubset.LATIN);

      shortStayRecuperateCareStandardNormalRoomStandeirdMoneyText.setMaxLength(4);

      addShortStayRecuperateCareStandardNormalRoomStandeirdMoneyText();
    }
    return shortStayRecuperateCareStandardNormalRoomStandeirdMoneyText;

  }

  /**
   * �]���^����z�E���x�����擾���܂��B
   * @return �]���^����z�E���x��
   */
  public ACLabel getShortStayRecuperateCareStandardNormalRoomStandeirdMoneyLabel(){
    if(shortStayRecuperateCareStandardNormalRoomStandeirdMoneyLabel==null){

      shortStayRecuperateCareStandardNormalRoomStandeirdMoneyLabel = new ACLabel();

      shortStayRecuperateCareStandardNormalRoomStandeirdMoneyLabel.setText("�i�~�j");

      addShortStayRecuperateCareStandardNormalRoomStandeirdMoneyLabel();
    }
    return shortStayRecuperateCareStandardNormalRoomStandeirdMoneyLabel;

  }

  /**
   * ��������z�E�R���e�i���擾���܂��B
   * @return ��������z�E�R���e�i
   */
  public ACLabelContainer getShortStayRecuperateCareStandardTasyouRoomConteiner(){
    if(shortStayRecuperateCareStandardTasyouRoomConteiner==null){

      shortStayRecuperateCareStandardTasyouRoomConteiner = new ACLabelContainer();

      shortStayRecuperateCareStandardTasyouRoomConteiner.setText("�@�@��������z");

      shortStayRecuperateCareStandardTasyouRoomConteiner.setFollowChildEnabled(true);

      addShortStayRecuperateCareStandardTasyouRoomConteiner();
    }
    return shortStayRecuperateCareStandardTasyouRoomConteiner;

  }

  /**
   * ��������z�E�e�L�X�g���擾���܂��B
   * @return ��������z�E�e�L�X�g
   */
  public ACTextField getShortStayRecuperateCareStandardTasyouRoomText(){
    if(shortStayRecuperateCareStandardTasyouRoomText==null){

      shortStayRecuperateCareStandardTasyouRoomText = new ACTextField();

      shortStayRecuperateCareStandardTasyouRoomText.setBindPath("1230412");

      shortStayRecuperateCareStandardTasyouRoomText.setColumns(4);

      shortStayRecuperateCareStandardTasyouRoomText.setCharType(VRCharType.ONLY_DIGIT);

      shortStayRecuperateCareStandardTasyouRoomText.setHorizontalAlignment(SwingConstants.RIGHT);

      shortStayRecuperateCareStandardTasyouRoomText.setIMEMode(InputSubset.LATIN);

      shortStayRecuperateCareStandardTasyouRoomText.setMaxLength(4);

      addShortStayRecuperateCareStandardTasyouRoomText();
    }
    return shortStayRecuperateCareStandardTasyouRoomText;

  }

  /**
   * ��������z�E���x�����擾���܂��B
   * @return ��������z�E���x��
   */
  public ACLabel getShortStayRecuperateCareStandardTasyouRoomLabel(){
    if(shortStayRecuperateCareStandardTasyouRoomLabel==null){

      shortStayRecuperateCareStandardTasyouRoomLabel = new ACLabel();

      shortStayRecuperateCareStandardTasyouRoomLabel.setText("�i�~�j");

      addShortStayRecuperateCareStandardTasyouRoomLabel();
    }
    return shortStayRecuperateCareStandardTasyouRoomLabel;

  }

  /**
   * �R���X�g���N�^�ł��B
   */
  public QO004013Design() {

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

    this.add(getShortStayStandardAgreementRecuperationGroup(), VRLayout.CLIENT);

  }

  /**
   * ���ƃO���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayStandardAgreementRecuperationGroup(){

    shortStayStandardAgreementRecuperationGroup.add(getShortStayStandardAgreementRecuperationDiscountContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayStandardAgreementRecuperationGroup.add(getShortStayStandardAgreementRecuperationMeetingAndSendingOffSystemContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayStandardAgreementRecuperationGroup.add(getShortStayStandardAgreementRecuperationNutritionManageRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayStandardAgreementRecuperationGroup.add(getShortStayStandardAgreementRecuperationRecuperateRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayStandardAgreementRecuperationGroup.add(getShortStayStandardAgreementRecuperationStaffReduceRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayStandardAgreementRecuperationGroup.add(getShortStayRecuperateCareStandardDinnerStandeirdMoneyConteiner(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayStandardAgreementRecuperationGroup.add(getShortStayRecuperateCareStandardUnitRoomStandeirdMoneyConteiner(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayStandardAgreementRecuperationGroup.add(getShortStayRecuperateCareStandardUnitSemiRoomStandeirdMoneyConteiner(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayStandardAgreementRecuperationGroup.add(getShortStayRecuperateCareStandardNormalRoomStandeirdMoneyConteiner(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayStandardAgreementRecuperationGroup.add(getShortStayRecuperateCareStandardTasyouRoomConteiner(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * �������R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayStandardAgreementRecuperationDiscountContainer(){

    shortStayStandardAgreementRecuperationDiscountContainer.add(getShortStayStandardAgreementRecuperationDiscountRate(), VRLayout.FLOW);

    shortStayStandardAgreementRecuperationDiscountContainer.add(getShortStayStandardAgreementRecuperationPercentSign(), VRLayout.FLOW);

  }

  /**
   * �������ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayStandardAgreementRecuperationDiscountRate(){

  }

  /**
   * �����x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayStandardAgreementRecuperationPercentSign(){

  }

  /**
   * ���}�̐����W�I�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayStandardAgreementRecuperationMeetingAndSendingOffSystem(){

  }

  /**
   * ���}�̐����W�I�O���[�v���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayStandardAgreementRecuperationMeetingAndSendingOffSystemModel(){

    getShortStayStandardAgreementRecuperationMeetingAndSendingOffSystemOff().setButtonIndex(1);
    getShortStayStandardAgreementRecuperationMeetingAndSendingOffSystemModel().add(getShortStayStandardAgreementRecuperationMeetingAndSendingOffSystemOff());

    getShortStayStandardAgreementRecuperationMeetingAndSendingOffSystemOn().setButtonIndex(2);
    getShortStayStandardAgreementRecuperationMeetingAndSendingOffSystemModel().add(getShortStayStandardAgreementRecuperationMeetingAndSendingOffSystemOn());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayStandardAgreementRecuperationMeetingAndSendingOffSystemOff(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayStandardAgreementRecuperationMeetingAndSendingOffSystemOn(){

  }

  /**
   * �h�{�Ǘ��̐����W�I�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayStandardAgreementRecuperationNutritionManageRadio(){

  }

  /**
   * �h�{�Ǘ��̐����W�I�O���[�v���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayStandardAgreementRecuperationNutritionManageRadioModel(){

    getShortStayStandardAgreementRecuperationNutritionManageRadioItem1().setButtonIndex(1);
    getShortStayStandardAgreementRecuperationNutritionManageRadioModel().add(getShortStayStandardAgreementRecuperationNutritionManageRadioItem1());

    getShortStayStandardAgreementRecuperationNutritionManageRadioItem2().setButtonIndex(2);
    getShortStayStandardAgreementRecuperationNutritionManageRadioModel().add(getShortStayStandardAgreementRecuperationNutritionManageRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayStandardAgreementRecuperationNutritionManageRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayStandardAgreementRecuperationNutritionManageRadioItem2(){

  }

  /**
   * �×{�H�̐����W�I�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayStandardAgreementRecuperationRecuperateRadio(){

  }

  /**
   * �×{�H�̐����W�I�O���[�v���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayStandardAgreementRecuperationRecuperateRadioModel(){

    getShortStayStandardAgreementRecuperationRecuperateRadioItem1().setButtonIndex(1);
    getShortStayStandardAgreementRecuperationRecuperateRadioModel().add(getShortStayStandardAgreementRecuperationRecuperateRadioItem1());

    getShortStayStandardAgreementRecuperationRecuperateRadioItem2().setButtonIndex(2);
    getShortStayStandardAgreementRecuperationRecuperateRadioModel().add(getShortStayStandardAgreementRecuperationRecuperateRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayStandardAgreementRecuperationRecuperateRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayStandardAgreementRecuperationRecuperateRadioItem2(){

  }

  /**
   * �l�����Z���W�I�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayStandardAgreementRecuperationStaffReduceRadio(){

  }

  /**
   * �l�����Z���W�I�O���[�v���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayStandardAgreementRecuperationStaffReduceRadioModel(){

    getShortStayStandardAgreementRecuperationStaffNot().setButtonIndex(1);
    getShortStayStandardAgreementRecuperationStaffReduceRadioModel().add(getShortStayStandardAgreementRecuperationStaffNot());

    getShortStayStandardAgreementRecuperationStaffExcess().setButtonIndex(2);
    getShortStayStandardAgreementRecuperationStaffReduceRadioModel().add(getShortStayStandardAgreementRecuperationStaffExcess());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayStandardAgreementRecuperationStaffNot(){

  }

  /**
   * ������߂ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayStandardAgreementRecuperationStaffExcess(){

  }

  /**
   * �H���z�E�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperateCareStandardDinnerStandeirdMoneyConteiner(){

    shortStayRecuperateCareStandardDinnerStandeirdMoneyConteiner.add(getShortStayRecuperateCareStandardDinnerStandeirdMoneyTotal(), VRLayout.FLOW);

    shortStayRecuperateCareStandardDinnerStandeirdMoneyConteiner.add(getShortStayRecuperateCareStandardMorningDinnerStandeirdMoneyLabel(), VRLayout.FLOW);

    shortStayRecuperateCareStandardDinnerStandeirdMoneyConteiner.add(getShortStayRecuperateCareStandardMorningDinnerStandeirdMoney(), VRLayout.FLOW);

    shortStayRecuperateCareStandardDinnerStandeirdMoneyConteiner.add(getShortStayRecuperateCareStandardNoonDinnerStandeirdMoneyLabel(), VRLayout.FLOW);

    shortStayRecuperateCareStandardDinnerStandeirdMoneyConteiner.add(getShortStayRecuperateCareStandardNoonDinnerStandeirdMoney(), VRLayout.FLOW);

    shortStayRecuperateCareStandardDinnerStandeirdMoneyConteiner.add(getShortStayRecuperateCareStandardNightDinnerStandeirdMoneyLabel(), VRLayout.FLOW);

    shortStayRecuperateCareStandardDinnerStandeirdMoneyConteiner.add(getShortStayRecuperateCareStandardNightDinnerStandeirdMoney(), VRLayout.FLOW);

    shortStayRecuperateCareStandardDinnerStandeirdMoneyConteiner.add(getShortStayRecuperateCareStandardDinnerStandeirdMoney4Label(), VRLayout.FLOW);

  }

  /**
   * �H���z�E���v�E�e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperateCareStandardDinnerStandeirdMoneyTotal(){

  }

  /**
   * �H���z�E���E���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperateCareStandardMorningDinnerStandeirdMoneyLabel(){

  }

  /**
   * �H���z�E���E�e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperateCareStandardMorningDinnerStandeirdMoney(){

  }

  /**
   * �H���z�E���E���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperateCareStandardNoonDinnerStandeirdMoneyLabel(){

  }

  /**
   * �H���z�E���E�e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperateCareStandardNoonDinnerStandeirdMoney(){

  }

  /**
   * �H���z�E��E���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperateCareStandardNightDinnerStandeirdMoneyLabel(){

  }

  /**
   * �H���z�E��E�e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperateCareStandardNightDinnerStandeirdMoney(){

  }

  /**
   * �H���z�E���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperateCareStandardDinnerStandeirdMoney4Label(){

  }

  /**
   * ���j�b�g�^����z�E�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperateCareStandardUnitRoomStandeirdMoneyConteiner(){

    shortStayRecuperateCareStandardUnitRoomStandeirdMoneyConteiner.add(getShortStayRecuperateCareStandardUnitRoomStandeirdMoneyText(), null);

    shortStayRecuperateCareStandardUnitRoomStandeirdMoneyConteiner.add(getShortStayRecuperateCareStandardUnitRoomStandeirdMoneyLabel(), null);

  }

  /**
   * ���j�b�g�^����z�E�e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperateCareStandardUnitRoomStandeirdMoneyText(){

  }

  /**
   * ���j�b�g�^����z�E���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperateCareStandardUnitRoomStandeirdMoneyLabel(){

  }

  /**
   * ���j�b�g�^������z�E�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperateCareStandardUnitSemiRoomStandeirdMoneyConteiner(){

    shortStayRecuperateCareStandardUnitSemiRoomStandeirdMoneyConteiner.add(getShortStayRecuperateCareStandardUnitSemiRoomStandeirdMoneyText(), null);

    shortStayRecuperateCareStandardUnitSemiRoomStandeirdMoneyConteiner.add(getShortStayRecuperateCareStandardUnitSemiRoomStandeirdMoneyLabel(), null);

  }

  /**
   * ���j�b�g�^������z�E�e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperateCareStandardUnitSemiRoomStandeirdMoneyText(){

  }

  /**
   * ���j�b�g�^������z�E���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperateCareStandardUnitSemiRoomStandeirdMoneyLabel(){

  }

  /**
   * �]���^����z�E�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperateCareStandardNormalRoomStandeirdMoneyConteiner(){

    shortStayRecuperateCareStandardNormalRoomStandeirdMoneyConteiner.add(getShortStayRecuperateCareStandardNormalRoomStandeirdMoneyText(), null);

    shortStayRecuperateCareStandardNormalRoomStandeirdMoneyConteiner.add(getShortStayRecuperateCareStandardNormalRoomStandeirdMoneyLabel(), null);

  }

  /**
   * �]���^����z�E�e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperateCareStandardNormalRoomStandeirdMoneyText(){

  }

  /**
   * �]���^����z�E���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperateCareStandardNormalRoomStandeirdMoneyLabel(){

  }

  /**
   * ��������z�E�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperateCareStandardTasyouRoomConteiner(){

    shortStayRecuperateCareStandardTasyouRoomConteiner.add(getShortStayRecuperateCareStandardTasyouRoomText(), null);

    shortStayRecuperateCareStandardTasyouRoomConteiner.add(getShortStayRecuperateCareStandardTasyouRoomLabel(), null);

  }

  /**
   * ��������z�E�e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperateCareStandardTasyouRoomText(){

  }

  /**
   * ��������z�E���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperateCareStandardTasyouRoomLabel(){

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
      ACFrame.getInstance().getContentPane().add(new QO004013Design());
      ACFrame.getInstance().setVisible(true);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QO004013Design getThis() {
    return this;
  }
}
