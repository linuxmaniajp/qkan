
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
 * �v���O���� ���Ǝғo�^(�Z�������×{���F�m�ǎ����^) (QO004012)
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
 * ���Ǝғo�^(�Z�������×{���F�m�ǎ����^)��ʍ��ڃf�U�C��(QO004012) 
 */
public class QO004012Design extends ACPanel {
  //GUI�R���|�[�l���g

  private ACGroupBox shortStayDementiaDiseaseRecuperationGroup;

  private ACLabelContainer shortStayDementiaDiseaseRecuperationDiscountConteiner;

  private ACTextField shortStayDementiaDiseaseRecuperationDiscountRate;

  private ACLabel shortStayDementiaDiseaseRecuperationPercentSign;

  private ACClearableRadioButtonGroup shortStayDementiaDiseaseRecuperationPercentSignCognitiveRadio;

  private ACLabelContainer shortStayDementiaDiseaseRecuperationPercentSignCognitiveRadioContainer;

  private ACListModelAdapter shortStayDementiaDiseaseRecuperationPercentSignCognitiveRadioModel;

  private ACRadioButtonItem shortStayDementiaDiseaseRecuperationPercentSignCognitiveRadioItem1;

  private ACRadioButtonItem shortStayDementiaDiseaseRecuperationPercentSignCognitiveRadioItem2;

  private ACClearableRadioButtonGroup shortStayDementiaDiseaseRecuperationStaffAssignmentDivision;

  private ACLabelContainer shortStayDementiaDiseaseRecuperationStaffAssignmentDivisionContainer;

  private ACListModelAdapter shortStayDementiaDiseaseRecuperationStaffAssignmentDivisionModel;

  private ACRadioButtonItem shortStayDementiaDiseaseRecuperationStaffAssignmentDivision1;

  private ACRadioButtonItem shortStayDementiaDiseaseRecuperationStaffAssignmentDivision2;

  private ACRadioButtonItem shortStayDementiaDiseaseRecuperationstaffAssignmentDivision3;

  private ACClearableRadioButtonGroup shortStayDementiaDiseaseRecuperationMeetingAndSendingOffSystem;

  private ACLabelContainer shortStayDementiaDiseaseRecuperationMeetingAndSendingOffSystemContainer;

  private ACListModelAdapter shortStayDementiaDiseaseRecuperationMeetingAndSendingOffSystemModel;

  private ACRadioButtonItem shortStayDementiaDiseaseRecuperationMeetingAndSendingOffSystemOff;

  private ACRadioButtonItem shortStayDementiaDiseaseRecuperationMeetingAndSendingOffSystemOn;

  private ACClearableRadioButtonGroup shortStayDementiaDiseaseRecuperationNutritionManageRadio;

  private ACLabelContainer shortStayDementiaDiseaseRecuperationNutritionManageRadioContainer;

  private ACListModelAdapter shortStayDementiaDiseaseRecuperationNutritionManageRadioModel;

  private ACRadioButtonItem shortStayDementiaDiseaseRecuperationNutritionManageRadioItem1;

  private ACRadioButtonItem shortStayDementiaDiseaseRecuperationNutritionManageRadioItem2;

  private ACClearableRadioButtonGroup shortStayDementiaDiseaseRecuperationRecuperateDinnerRadio;

  private ACLabelContainer shortStayDementiaDiseaseRecuperationRecuperateDinnerRadioContainer;

  private ACListModelAdapter shortStayDementiaDiseaseRecuperationRecuperateDinnerRadioModel;

  private ACRadioButtonItem shortStayDementiaDiseaseRecuperationRecuperateDinnerRadioItem1;

  private ACRadioButtonItem shortStayDementiaDiseaseRecuperationRecuperateDinnerRadioItem2;

  private ACComboBox shortStayDementiaDiseaseRecuperationStaffReduce;

  private ACLabelContainer shortStayDementiaDiseaseRecuperationStaffReduceContainer;

  private ACComboBoxModelAdapter shortStayDementiaDiseaseRecuperationStaffReduceModel;

  private ACLabelContainer shortStayRecuperateCareCognitiveDinnerStandeirdMoneyConteiner;

  private ACTextField shortStayRecuperateCareCognitiveDinnerStandeirdMoneyTotal;

  private ACLabel shortStayRecuperateCareCognitiveMorningDinnerStandeirdMoneyLabel;

  private ACTextField shortStayRecuperateCareCognitiveMorningDinnerStandeirdMoney;

  private ACLabel shortStayRecuperateCareCognitiveNoonDinnerStandeirdMoneyLabel;

  private ACTextField shortStayRecuperateCareCognitiveNoonDinnerStandeirdMoney;

  private ACLabel shortStayRecuperateCareCognitiveNightDinnerStandeirdTotalMoneyLabel;

  private ACTextField shortStayRecuperateCareCognitiveNightDinnerStandeirdMoney;

  private ACLabel shortStayRecuperateCareCognitiveRecuperateCareCognitiveDinnerStandeirdMoney4Label;

  private ACLabelContainer shortStayRecuperateCareCognitiveUnitRoomStandeirdMoneyConteiner;

  private ACTextField shortStayRecuperateCareCognitiveUnitRoomStandeirdMoneyText;

  private ACLabel shortStayRecuperateCareCognitiveUnitRoomStandeirdMoneyLabel;

  private ACLabelContainer shortStayRecuperateCareCognitiveUnitSemiRoomStandeirdMoneyConteiner;

  private ACTextField shortStayRecuperateCareCognitiveUnitSemiRoomStandeirdMoneyText;

  private ACLabel shortStayRecuperateCareCognitiveUnitSemiRoomStandeirdMoneyLabel;

  private ACLabelContainer shortStayRecuperateCareCognitiveNormalRoomStandeirdMoneyConteiner;

  private ACTextField shortStayRecuperateCareCognitiveNormalRoomStandeirdMoneyText;

  private ACLabel shortStayRecuperateCareCognitiveNormalRoomStandeirdMoneyLabel;

  private ACLabelContainer shortStayRecuperateCareCognitiveTasyouRoomConteiner;

  private ACTextField shortStayRecuperateCareCognitiveTasyouRoomText;

  private ACLabel shortStayRecuperateCareCognitiveTasyouRoomLabel;

  //getter

  /**
   * ���ƃO���[�v���擾���܂��B
   * @return ���ƃO���[�v
   */
  public ACGroupBox getShortStayDementiaDiseaseRecuperationGroup(){
    if(shortStayDementiaDiseaseRecuperationGroup==null){

      shortStayDementiaDiseaseRecuperationGroup = new ACGroupBox();

      shortStayDementiaDiseaseRecuperationGroup.setText("�Z�������×{���i�F�m�ǎ����^�j");

      shortStayDementiaDiseaseRecuperationGroup.setFollowChildEnabled(true);

      shortStayDementiaDiseaseRecuperationGroup.setHgrid(200);

      addShortStayDementiaDiseaseRecuperationGroup();
    }
    return shortStayDementiaDiseaseRecuperationGroup;

  }

  /**
   * �������R���e�i���擾���܂��B
   * @return �������R���e�i
   */
  public ACLabelContainer getShortStayDementiaDiseaseRecuperationDiscountConteiner(){
    if(shortStayDementiaDiseaseRecuperationDiscountConteiner==null){

      shortStayDementiaDiseaseRecuperationDiscountConteiner = new ACLabelContainer();

      shortStayDementiaDiseaseRecuperationDiscountConteiner.setText("������");

      shortStayDementiaDiseaseRecuperationDiscountConteiner.setFollowChildEnabled(true);

      addShortStayDementiaDiseaseRecuperationDiscountConteiner();
    }
    return shortStayDementiaDiseaseRecuperationDiscountConteiner;

  }

  /**
   * ���������擾���܂��B
   * @return ������
   */
  public ACTextField getShortStayDementiaDiseaseRecuperationDiscountRate(){
    if(shortStayDementiaDiseaseRecuperationDiscountRate==null){

      shortStayDementiaDiseaseRecuperationDiscountRate = new ACTextField();

      shortStayDementiaDiseaseRecuperationDiscountRate.setBindPath("REDUCT_RATE");

      shortStayDementiaDiseaseRecuperationDiscountRate.setColumns(3);

      shortStayDementiaDiseaseRecuperationDiscountRate.setCharType(VRCharType.ONLY_DIGIT);

      shortStayDementiaDiseaseRecuperationDiscountRate.setHorizontalAlignment(SwingConstants.RIGHT);

      shortStayDementiaDiseaseRecuperationDiscountRate.setIMEMode(InputSubset.LATIN);

      shortStayDementiaDiseaseRecuperationDiscountRate.setMaxLength(3);

      addShortStayDementiaDiseaseRecuperationDiscountRate();
    }
    return shortStayDementiaDiseaseRecuperationDiscountRate;

  }

  /**
   * �����x�����擾���܂��B
   * @return �����x��
   */
  public ACLabel getShortStayDementiaDiseaseRecuperationPercentSign(){
    if(shortStayDementiaDiseaseRecuperationPercentSign==null){

      shortStayDementiaDiseaseRecuperationPercentSign = new ACLabel();

      shortStayDementiaDiseaseRecuperationPercentSign.setText("��");

      addShortStayDementiaDiseaseRecuperationPercentSign();
    }
    return shortStayDementiaDiseaseRecuperationPercentSign;

  }

  /**
   * �{�݋敪���W�I�O���[�v���擾���܂��B
   * @return �{�݋敪���W�I�O���[�v
   */
  public ACClearableRadioButtonGroup getShortStayDementiaDiseaseRecuperationPercentSignCognitiveRadio(){
    if(shortStayDementiaDiseaseRecuperationPercentSignCognitiveRadio==null){

      shortStayDementiaDiseaseRecuperationPercentSignCognitiveRadio = new ACClearableRadioButtonGroup();

      getShortStayDementiaDiseaseRecuperationPercentSignCognitiveRadioContainer().setText("�{�݋敪");

      shortStayDementiaDiseaseRecuperationPercentSignCognitiveRadio.setBindPath("1230301");

      shortStayDementiaDiseaseRecuperationPercentSignCognitiveRadio.setModel(getShortStayDementiaDiseaseRecuperationPercentSignCognitiveRadioModel());

      shortStayDementiaDiseaseRecuperationPercentSignCognitiveRadio.setUseClearButton(false);

      addShortStayDementiaDiseaseRecuperationPercentSignCognitiveRadio();
    }
    return shortStayDementiaDiseaseRecuperationPercentSignCognitiveRadio;

  }

  /**
   * �{�݋敪���W�I�O���[�v�R���e�i���擾���܂��B
   * @return �{�݋敪���W�I�O���[�v�R���e�i
   */
  protected ACLabelContainer getShortStayDementiaDiseaseRecuperationPercentSignCognitiveRadioContainer(){
    if(shortStayDementiaDiseaseRecuperationPercentSignCognitiveRadioContainer==null){
      shortStayDementiaDiseaseRecuperationPercentSignCognitiveRadioContainer = new ACLabelContainer();
      shortStayDementiaDiseaseRecuperationPercentSignCognitiveRadioContainer.setFollowChildEnabled(true);
      shortStayDementiaDiseaseRecuperationPercentSignCognitiveRadioContainer.add(getShortStayDementiaDiseaseRecuperationPercentSignCognitiveRadio(), null);
    }
    return shortStayDementiaDiseaseRecuperationPercentSignCognitiveRadioContainer;
  }

  /**
   * �{�݋敪���W�I�O���[�v���f�����擾���܂��B
   * @return �{�݋敪���W�I�O���[�v���f��
   */
  protected ACListModelAdapter getShortStayDementiaDiseaseRecuperationPercentSignCognitiveRadioModel(){
    if(shortStayDementiaDiseaseRecuperationPercentSignCognitiveRadioModel==null){
      shortStayDementiaDiseaseRecuperationPercentSignCognitiveRadioModel = new ACListModelAdapter();
      addShortStayDementiaDiseaseRecuperationPercentSignCognitiveRadioModel();
    }
    return shortStayDementiaDiseaseRecuperationPercentSignCognitiveRadioModel;
  }

  /**
   * �F�m�ǎ����^���擾���܂��B
   * @return �F�m�ǎ����^
   */
  public ACRadioButtonItem getShortStayDementiaDiseaseRecuperationPercentSignCognitiveRadioItem1(){
    if(shortStayDementiaDiseaseRecuperationPercentSignCognitiveRadioItem1==null){

      shortStayDementiaDiseaseRecuperationPercentSignCognitiveRadioItem1 = new ACRadioButtonItem();

      shortStayDementiaDiseaseRecuperationPercentSignCognitiveRadioItem1.setText("�F�m�ǎ����^");

      shortStayDementiaDiseaseRecuperationPercentSignCognitiveRadioItem1.setGroup(getShortStayDementiaDiseaseRecuperationPercentSignCognitiveRadio());

      addShortStayDementiaDiseaseRecuperationPercentSignCognitiveRadioItem1();
    }
    return shortStayDementiaDiseaseRecuperationPercentSignCognitiveRadioItem1;

  }

  /**
   * ���j�b�g�^�F�m�ǎ����^���擾���܂��B
   * @return ���j�b�g�^�F�m�ǎ����^
   */
  public ACRadioButtonItem getShortStayDementiaDiseaseRecuperationPercentSignCognitiveRadioItem2(){
    if(shortStayDementiaDiseaseRecuperationPercentSignCognitiveRadioItem2==null){

      shortStayDementiaDiseaseRecuperationPercentSignCognitiveRadioItem2 = new ACRadioButtonItem();

      shortStayDementiaDiseaseRecuperationPercentSignCognitiveRadioItem2.setText("���j�b�g�^�F�m�ǎ����^");

      shortStayDementiaDiseaseRecuperationPercentSignCognitiveRadioItem2.setGroup(getShortStayDementiaDiseaseRecuperationPercentSignCognitiveRadio());

      addShortStayDementiaDiseaseRecuperationPercentSignCognitiveRadioItem2();
    }
    return shortStayDementiaDiseaseRecuperationPercentSignCognitiveRadioItem2;

  }

  /**
   * �l���z�u�敪���W�I�O���[�v���擾���܂��B
   * @return �l���z�u�敪���W�I�O���[�v
   */
  public ACClearableRadioButtonGroup getShortStayDementiaDiseaseRecuperationStaffAssignmentDivision(){
    if(shortStayDementiaDiseaseRecuperationStaffAssignmentDivision==null){

      shortStayDementiaDiseaseRecuperationStaffAssignmentDivision = new ACClearableRadioButtonGroup();

      getShortStayDementiaDiseaseRecuperationStaffAssignmentDivisionContainer().setText("�l���z�u�敪");

      shortStayDementiaDiseaseRecuperationStaffAssignmentDivision.setBindPath("1230302");

      shortStayDementiaDiseaseRecuperationStaffAssignmentDivision.setModel(getShortStayDementiaDiseaseRecuperationStaffAssignmentDivisionModel());

      shortStayDementiaDiseaseRecuperationStaffAssignmentDivision.setUseClearButton(false);

      addShortStayDementiaDiseaseRecuperationStaffAssignmentDivision();
    }
    return shortStayDementiaDiseaseRecuperationStaffAssignmentDivision;

  }

  /**
   * �l���z�u�敪���W�I�O���[�v�R���e�i���擾���܂��B
   * @return �l���z�u�敪���W�I�O���[�v�R���e�i
   */
  protected ACLabelContainer getShortStayDementiaDiseaseRecuperationStaffAssignmentDivisionContainer(){
    if(shortStayDementiaDiseaseRecuperationStaffAssignmentDivisionContainer==null){
      shortStayDementiaDiseaseRecuperationStaffAssignmentDivisionContainer = new ACLabelContainer();
      shortStayDementiaDiseaseRecuperationStaffAssignmentDivisionContainer.setFollowChildEnabled(true);
      shortStayDementiaDiseaseRecuperationStaffAssignmentDivisionContainer.add(getShortStayDementiaDiseaseRecuperationStaffAssignmentDivision(), null);
    }
    return shortStayDementiaDiseaseRecuperationStaffAssignmentDivisionContainer;
  }

  /**
   * �l���z�u�敪���W�I�O���[�v���f�����擾���܂��B
   * @return �l���z�u�敪���W�I�O���[�v���f��
   */
  protected ACListModelAdapter getShortStayDementiaDiseaseRecuperationStaffAssignmentDivisionModel(){
    if(shortStayDementiaDiseaseRecuperationStaffAssignmentDivisionModel==null){
      shortStayDementiaDiseaseRecuperationStaffAssignmentDivisionModel = new ACListModelAdapter();
      addShortStayDementiaDiseaseRecuperationStaffAssignmentDivisionModel();
    }
    return shortStayDementiaDiseaseRecuperationStaffAssignmentDivisionModel;
  }

  /**
   * I�^���擾���܂��B
   * @return I�^
   */
  public ACRadioButtonItem getShortStayDementiaDiseaseRecuperationStaffAssignmentDivision1(){
    if(shortStayDementiaDiseaseRecuperationStaffAssignmentDivision1==null){

      shortStayDementiaDiseaseRecuperationStaffAssignmentDivision1 = new ACRadioButtonItem();

      shortStayDementiaDiseaseRecuperationStaffAssignmentDivision1.setText("I�^");

      shortStayDementiaDiseaseRecuperationStaffAssignmentDivision1.setGroup(getShortStayDementiaDiseaseRecuperationStaffAssignmentDivision());

      addShortStayDementiaDiseaseRecuperationStaffAssignmentDivision1();
    }
    return shortStayDementiaDiseaseRecuperationStaffAssignmentDivision1;

  }

  /**
   * II�^���擾���܂��B
   * @return II�^
   */
  public ACRadioButtonItem getShortStayDementiaDiseaseRecuperationStaffAssignmentDivision2(){
    if(shortStayDementiaDiseaseRecuperationStaffAssignmentDivision2==null){

      shortStayDementiaDiseaseRecuperationStaffAssignmentDivision2 = new ACRadioButtonItem();

      shortStayDementiaDiseaseRecuperationStaffAssignmentDivision2.setText("II�^");

      shortStayDementiaDiseaseRecuperationStaffAssignmentDivision2.setGroup(getShortStayDementiaDiseaseRecuperationStaffAssignmentDivision());

      addShortStayDementiaDiseaseRecuperationStaffAssignmentDivision2();
    }
    return shortStayDementiaDiseaseRecuperationStaffAssignmentDivision2;

  }

  /**
   * III�^���擾���܂��B
   * @return III�^
   */
  public ACRadioButtonItem getShortStayDementiaDiseaseRecuperationstaffAssignmentDivision3(){
    if(shortStayDementiaDiseaseRecuperationstaffAssignmentDivision3==null){

      shortStayDementiaDiseaseRecuperationstaffAssignmentDivision3 = new ACRadioButtonItem();

      shortStayDementiaDiseaseRecuperationstaffAssignmentDivision3.setText("III�^");

      shortStayDementiaDiseaseRecuperationstaffAssignmentDivision3.setGroup(getShortStayDementiaDiseaseRecuperationStaffAssignmentDivision());

      addShortStayDementiaDiseaseRecuperationstaffAssignmentDivision3();
    }
    return shortStayDementiaDiseaseRecuperationstaffAssignmentDivision3;

  }

  /**
   * ���}�̐����W�I�O���[�v���擾���܂��B
   * @return ���}�̐����W�I�O���[�v
   */
  public ACClearableRadioButtonGroup getShortStayDementiaDiseaseRecuperationMeetingAndSendingOffSystem(){
    if(shortStayDementiaDiseaseRecuperationMeetingAndSendingOffSystem==null){

      shortStayDementiaDiseaseRecuperationMeetingAndSendingOffSystem = new ACClearableRadioButtonGroup();

      getShortStayDementiaDiseaseRecuperationMeetingAndSendingOffSystemContainer().setText("���}�̐�");

      shortStayDementiaDiseaseRecuperationMeetingAndSendingOffSystem.setBindPath("1230303");

      shortStayDementiaDiseaseRecuperationMeetingAndSendingOffSystem.setModel(getShortStayDementiaDiseaseRecuperationMeetingAndSendingOffSystemModel());

      shortStayDementiaDiseaseRecuperationMeetingAndSendingOffSystem.setUseClearButton(false);

      addShortStayDementiaDiseaseRecuperationMeetingAndSendingOffSystem();
    }
    return shortStayDementiaDiseaseRecuperationMeetingAndSendingOffSystem;

  }

  /**
   * ���}�̐����W�I�O���[�v�R���e�i���擾���܂��B
   * @return ���}�̐����W�I�O���[�v�R���e�i
   */
  protected ACLabelContainer getShortStayDementiaDiseaseRecuperationMeetingAndSendingOffSystemContainer(){
    if(shortStayDementiaDiseaseRecuperationMeetingAndSendingOffSystemContainer==null){
      shortStayDementiaDiseaseRecuperationMeetingAndSendingOffSystemContainer = new ACLabelContainer();
      shortStayDementiaDiseaseRecuperationMeetingAndSendingOffSystemContainer.setFollowChildEnabled(true);
      shortStayDementiaDiseaseRecuperationMeetingAndSendingOffSystemContainer.add(getShortStayDementiaDiseaseRecuperationMeetingAndSendingOffSystem(), null);
    }
    return shortStayDementiaDiseaseRecuperationMeetingAndSendingOffSystemContainer;
  }

  /**
   * ���}�̐����W�I�O���[�v���f�����擾���܂��B
   * @return ���}�̐����W�I�O���[�v���f��
   */
  protected ACListModelAdapter getShortStayDementiaDiseaseRecuperationMeetingAndSendingOffSystemModel(){
    if(shortStayDementiaDiseaseRecuperationMeetingAndSendingOffSystemModel==null){
      shortStayDementiaDiseaseRecuperationMeetingAndSendingOffSystemModel = new ACListModelAdapter();
      addShortStayDementiaDiseaseRecuperationMeetingAndSendingOffSystemModel();
    }
    return shortStayDementiaDiseaseRecuperationMeetingAndSendingOffSystemModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getShortStayDementiaDiseaseRecuperationMeetingAndSendingOffSystemOff(){
    if(shortStayDementiaDiseaseRecuperationMeetingAndSendingOffSystemOff==null){

      shortStayDementiaDiseaseRecuperationMeetingAndSendingOffSystemOff = new ACRadioButtonItem();

      shortStayDementiaDiseaseRecuperationMeetingAndSendingOffSystemOff.setText("�Ȃ�");

      shortStayDementiaDiseaseRecuperationMeetingAndSendingOffSystemOff.setGroup(getShortStayDementiaDiseaseRecuperationMeetingAndSendingOffSystem());

      addShortStayDementiaDiseaseRecuperationMeetingAndSendingOffSystemOff();
    }
    return shortStayDementiaDiseaseRecuperationMeetingAndSendingOffSystemOff;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getShortStayDementiaDiseaseRecuperationMeetingAndSendingOffSystemOn(){
    if(shortStayDementiaDiseaseRecuperationMeetingAndSendingOffSystemOn==null){

      shortStayDementiaDiseaseRecuperationMeetingAndSendingOffSystemOn = new ACRadioButtonItem();

      shortStayDementiaDiseaseRecuperationMeetingAndSendingOffSystemOn.setText("����");

      shortStayDementiaDiseaseRecuperationMeetingAndSendingOffSystemOn.setGroup(getShortStayDementiaDiseaseRecuperationMeetingAndSendingOffSystem());

      addShortStayDementiaDiseaseRecuperationMeetingAndSendingOffSystemOn();
    }
    return shortStayDementiaDiseaseRecuperationMeetingAndSendingOffSystemOn;

  }

  /**
   * �h�{�Ǘ��̐����W�I�O���[�v���擾���܂��B
   * @return �h�{�Ǘ��̐����W�I�O���[�v
   */
  public ACClearableRadioButtonGroup getShortStayDementiaDiseaseRecuperationNutritionManageRadio(){
    if(shortStayDementiaDiseaseRecuperationNutritionManageRadio==null){

      shortStayDementiaDiseaseRecuperationNutritionManageRadio = new ACClearableRadioButtonGroup();

      getShortStayDementiaDiseaseRecuperationNutritionManageRadioContainer().setText("�h�{�Ǘ��̐�");

      shortStayDementiaDiseaseRecuperationNutritionManageRadio.setBindPath("1230304");

      shortStayDementiaDiseaseRecuperationNutritionManageRadio.setModel(getShortStayDementiaDiseaseRecuperationNutritionManageRadioModel());

      shortStayDementiaDiseaseRecuperationNutritionManageRadio.setUseClearButton(false);

      addShortStayDementiaDiseaseRecuperationNutritionManageRadio();
    }
    return shortStayDementiaDiseaseRecuperationNutritionManageRadio;

  }

  /**
   * �h�{�Ǘ��̐����W�I�O���[�v�R���e�i���擾���܂��B
   * @return �h�{�Ǘ��̐����W�I�O���[�v�R���e�i
   */
  protected ACLabelContainer getShortStayDementiaDiseaseRecuperationNutritionManageRadioContainer(){
    if(shortStayDementiaDiseaseRecuperationNutritionManageRadioContainer==null){
      shortStayDementiaDiseaseRecuperationNutritionManageRadioContainer = new ACLabelContainer();
      shortStayDementiaDiseaseRecuperationNutritionManageRadioContainer.setFollowChildEnabled(true);
      shortStayDementiaDiseaseRecuperationNutritionManageRadioContainer.add(getShortStayDementiaDiseaseRecuperationNutritionManageRadio(), null);
    }
    return shortStayDementiaDiseaseRecuperationNutritionManageRadioContainer;
  }

  /**
   * �h�{�Ǘ��̐����W�I�O���[�v���f�����擾���܂��B
   * @return �h�{�Ǘ��̐����W�I�O���[�v���f��
   */
  protected ACListModelAdapter getShortStayDementiaDiseaseRecuperationNutritionManageRadioModel(){
    if(shortStayDementiaDiseaseRecuperationNutritionManageRadioModel==null){
      shortStayDementiaDiseaseRecuperationNutritionManageRadioModel = new ACListModelAdapter();
      addShortStayDementiaDiseaseRecuperationNutritionManageRadioModel();
    }
    return shortStayDementiaDiseaseRecuperationNutritionManageRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getShortStayDementiaDiseaseRecuperationNutritionManageRadioItem1(){
    if(shortStayDementiaDiseaseRecuperationNutritionManageRadioItem1==null){

      shortStayDementiaDiseaseRecuperationNutritionManageRadioItem1 = new ACRadioButtonItem();

      shortStayDementiaDiseaseRecuperationNutritionManageRadioItem1.setText("�Ȃ�");

      shortStayDementiaDiseaseRecuperationNutritionManageRadioItem1.setGroup(getShortStayDementiaDiseaseRecuperationNutritionManageRadio());

      addShortStayDementiaDiseaseRecuperationNutritionManageRadioItem1();
    }
    return shortStayDementiaDiseaseRecuperationNutritionManageRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getShortStayDementiaDiseaseRecuperationNutritionManageRadioItem2(){
    if(shortStayDementiaDiseaseRecuperationNutritionManageRadioItem2==null){

      shortStayDementiaDiseaseRecuperationNutritionManageRadioItem2 = new ACRadioButtonItem();

      shortStayDementiaDiseaseRecuperationNutritionManageRadioItem2.setText("����");

      shortStayDementiaDiseaseRecuperationNutritionManageRadioItem2.setGroup(getShortStayDementiaDiseaseRecuperationNutritionManageRadio());

      addShortStayDementiaDiseaseRecuperationNutritionManageRadioItem2();
    }
    return shortStayDementiaDiseaseRecuperationNutritionManageRadioItem2;

  }

  /**
   * �×{�H�̐����W�I�O���[�v���擾���܂��B
   * @return �×{�H�̐����W�I�O���[�v
   */
  public ACClearableRadioButtonGroup getShortStayDementiaDiseaseRecuperationRecuperateDinnerRadio(){
    if(shortStayDementiaDiseaseRecuperationRecuperateDinnerRadio==null){

      shortStayDementiaDiseaseRecuperationRecuperateDinnerRadio = new ACClearableRadioButtonGroup();

      getShortStayDementiaDiseaseRecuperationRecuperateDinnerRadioContainer().setText("�×{�H�̐�");

      shortStayDementiaDiseaseRecuperationRecuperateDinnerRadio.setBindPath("1230305");

      shortStayDementiaDiseaseRecuperationRecuperateDinnerRadio.setModel(getShortStayDementiaDiseaseRecuperationRecuperateDinnerRadioModel());

      shortStayDementiaDiseaseRecuperationRecuperateDinnerRadio.setUseClearButton(false);

      addShortStayDementiaDiseaseRecuperationRecuperateDinnerRadio();
    }
    return shortStayDementiaDiseaseRecuperationRecuperateDinnerRadio;

  }

  /**
   * �×{�H�̐����W�I�O���[�v�R���e�i���擾���܂��B
   * @return �×{�H�̐����W�I�O���[�v�R���e�i
   */
  protected ACLabelContainer getShortStayDementiaDiseaseRecuperationRecuperateDinnerRadioContainer(){
    if(shortStayDementiaDiseaseRecuperationRecuperateDinnerRadioContainer==null){
      shortStayDementiaDiseaseRecuperationRecuperateDinnerRadioContainer = new ACLabelContainer();
      shortStayDementiaDiseaseRecuperationRecuperateDinnerRadioContainer.setFollowChildEnabled(true);
      shortStayDementiaDiseaseRecuperationRecuperateDinnerRadioContainer.add(getShortStayDementiaDiseaseRecuperationRecuperateDinnerRadio(), null);
    }
    return shortStayDementiaDiseaseRecuperationRecuperateDinnerRadioContainer;
  }

  /**
   * �×{�H�̐����W�I�O���[�v���f�����擾���܂��B
   * @return �×{�H�̐����W�I�O���[�v���f��
   */
  protected ACListModelAdapter getShortStayDementiaDiseaseRecuperationRecuperateDinnerRadioModel(){
    if(shortStayDementiaDiseaseRecuperationRecuperateDinnerRadioModel==null){
      shortStayDementiaDiseaseRecuperationRecuperateDinnerRadioModel = new ACListModelAdapter();
      addShortStayDementiaDiseaseRecuperationRecuperateDinnerRadioModel();
    }
    return shortStayDementiaDiseaseRecuperationRecuperateDinnerRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getShortStayDementiaDiseaseRecuperationRecuperateDinnerRadioItem1(){
    if(shortStayDementiaDiseaseRecuperationRecuperateDinnerRadioItem1==null){

      shortStayDementiaDiseaseRecuperationRecuperateDinnerRadioItem1 = new ACRadioButtonItem();

      shortStayDementiaDiseaseRecuperationRecuperateDinnerRadioItem1.setText("�Ȃ�");

      shortStayDementiaDiseaseRecuperationRecuperateDinnerRadioItem1.setGroup(getShortStayDementiaDiseaseRecuperationRecuperateDinnerRadio());

      addShortStayDementiaDiseaseRecuperationRecuperateDinnerRadioItem1();
    }
    return shortStayDementiaDiseaseRecuperationRecuperateDinnerRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getShortStayDementiaDiseaseRecuperationRecuperateDinnerRadioItem2(){
    if(shortStayDementiaDiseaseRecuperationRecuperateDinnerRadioItem2==null){

      shortStayDementiaDiseaseRecuperationRecuperateDinnerRadioItem2 = new ACRadioButtonItem();

      shortStayDementiaDiseaseRecuperationRecuperateDinnerRadioItem2.setText("����");

      shortStayDementiaDiseaseRecuperationRecuperateDinnerRadioItem2.setGroup(getShortStayDementiaDiseaseRecuperationRecuperateDinnerRadio());

      addShortStayDementiaDiseaseRecuperationRecuperateDinnerRadioItem2();
    }
    return shortStayDementiaDiseaseRecuperationRecuperateDinnerRadioItem2;

  }

  /**
   * �l�����Z�R���{���擾���܂��B
   * @return �l�����Z�R���{
   */
  public ACComboBox getShortStayDementiaDiseaseRecuperationStaffReduce(){
    if(shortStayDementiaDiseaseRecuperationStaffReduce==null){

      shortStayDementiaDiseaseRecuperationStaffReduce = new ACComboBox();

      getShortStayDementiaDiseaseRecuperationStaffReduceContainer().setText("�l�����Z");

      shortStayDementiaDiseaseRecuperationStaffReduce.setBindPath("1230306");

      shortStayDementiaDiseaseRecuperationStaffReduce.setEditable(false);

      shortStayDementiaDiseaseRecuperationStaffReduce.setModel(getShortStayDementiaDiseaseRecuperationStaffReduceModel());

      shortStayDementiaDiseaseRecuperationStaffReduce.setRenderBindPath("CONTENT");

      addShortStayDementiaDiseaseRecuperationStaffReduce();
    }
    return shortStayDementiaDiseaseRecuperationStaffReduce;

  }

  /**
   * �l�����Z�R���{�R���e�i���擾���܂��B
   * @return �l�����Z�R���{�R���e�i
   */
  protected ACLabelContainer getShortStayDementiaDiseaseRecuperationStaffReduceContainer(){
    if(shortStayDementiaDiseaseRecuperationStaffReduceContainer==null){
      shortStayDementiaDiseaseRecuperationStaffReduceContainer = new ACLabelContainer();
      shortStayDementiaDiseaseRecuperationStaffReduceContainer.setFollowChildEnabled(true);
      shortStayDementiaDiseaseRecuperationStaffReduceContainer.add(getShortStayDementiaDiseaseRecuperationStaffReduce(), null);
    }
    return shortStayDementiaDiseaseRecuperationStaffReduceContainer;
  }

  /**
   * �l�����Z�R���{���f�����擾���܂��B
   * @return �l�����Z�R���{���f��
   */
  protected ACComboBoxModelAdapter getShortStayDementiaDiseaseRecuperationStaffReduceModel(){
    if(shortStayDementiaDiseaseRecuperationStaffReduceModel==null){
      shortStayDementiaDiseaseRecuperationStaffReduceModel = new ACComboBoxModelAdapter();
      addShortStayDementiaDiseaseRecuperationStaffReduceModel();
    }
    return shortStayDementiaDiseaseRecuperationStaffReduceModel;
  }

  /**
   * �H���z�E�R���e�i���擾���܂��B
   * @return �H���z�E�R���e�i
   */
  public ACLabelContainer getShortStayRecuperateCareCognitiveDinnerStandeirdMoneyConteiner(){
    if(shortStayRecuperateCareCognitiveDinnerStandeirdMoneyConteiner==null){

      shortStayRecuperateCareCognitiveDinnerStandeirdMoneyConteiner = new ACLabelContainer();

      shortStayRecuperateCareCognitiveDinnerStandeirdMoneyConteiner.setText("�H���z");

      shortStayRecuperateCareCognitiveDinnerStandeirdMoneyConteiner.setFollowChildEnabled(true);

      addShortStayRecuperateCareCognitiveDinnerStandeirdMoneyConteiner();
    }
    return shortStayRecuperateCareCognitiveDinnerStandeirdMoneyConteiner;

  }

  /**
   * �H���z�E���v�E�e�L�X�g���擾���܂��B
   * @return �H���z�E���v�E�e�L�X�g
   */
  public ACTextField getShortStayRecuperateCareCognitiveDinnerStandeirdMoneyTotal(){
    if(shortStayRecuperateCareCognitiveDinnerStandeirdMoneyTotal==null){

      shortStayRecuperateCareCognitiveDinnerStandeirdMoneyTotal = new ACTextField();

      shortStayRecuperateCareCognitiveDinnerStandeirdMoneyTotal.setBindPath("1230307");

      shortStayRecuperateCareCognitiveDinnerStandeirdMoneyTotal.setEditable(false);

      shortStayRecuperateCareCognitiveDinnerStandeirdMoneyTotal.setColumns(4);

      shortStayRecuperateCareCognitiveDinnerStandeirdMoneyTotal.setCharType(VRCharType.ONLY_DIGIT);

      shortStayRecuperateCareCognitiveDinnerStandeirdMoneyTotal.setHorizontalAlignment(SwingConstants.RIGHT);

      shortStayRecuperateCareCognitiveDinnerStandeirdMoneyTotal.setIMEMode(InputSubset.LATIN);

      shortStayRecuperateCareCognitiveDinnerStandeirdMoneyTotal.setMaxLength(4);

      addShortStayRecuperateCareCognitiveDinnerStandeirdMoneyTotal();
    }
    return shortStayRecuperateCareCognitiveDinnerStandeirdMoneyTotal;

  }

  /**
   * �H���z�E���E���x�����擾���܂��B
   * @return �H���z�E���E���x��
   */
  public ACLabel getShortStayRecuperateCareCognitiveMorningDinnerStandeirdMoneyLabel(){
    if(shortStayRecuperateCareCognitiveMorningDinnerStandeirdMoneyLabel==null){

      shortStayRecuperateCareCognitiveMorningDinnerStandeirdMoneyLabel = new ACLabel();

      shortStayRecuperateCareCognitiveMorningDinnerStandeirdMoneyLabel.setText("�@��");

      addShortStayRecuperateCareCognitiveMorningDinnerStandeirdMoneyLabel();
    }
    return shortStayRecuperateCareCognitiveMorningDinnerStandeirdMoneyLabel;

  }

  /**
   * �H���z�E���E�e�L�X�g���擾���܂��B
   * @return �H���z�E���E�e�L�X�g
   */
  public ACTextField getShortStayRecuperateCareCognitiveMorningDinnerStandeirdMoney(){
    if(shortStayRecuperateCareCognitiveMorningDinnerStandeirdMoney==null){

      shortStayRecuperateCareCognitiveMorningDinnerStandeirdMoney = new ACTextField();

      shortStayRecuperateCareCognitiveMorningDinnerStandeirdMoney.setBindPath("1230308");

      shortStayRecuperateCareCognitiveMorningDinnerStandeirdMoney.setColumns(3);

      shortStayRecuperateCareCognitiveMorningDinnerStandeirdMoney.setCharType(VRCharType.ONLY_DIGIT);

      shortStayRecuperateCareCognitiveMorningDinnerStandeirdMoney.setHorizontalAlignment(SwingConstants.RIGHT);

      shortStayRecuperateCareCognitiveMorningDinnerStandeirdMoney.setIMEMode(InputSubset.LATIN);

      shortStayRecuperateCareCognitiveMorningDinnerStandeirdMoney.setMaxLength(3);

      addShortStayRecuperateCareCognitiveMorningDinnerStandeirdMoney();
    }
    return shortStayRecuperateCareCognitiveMorningDinnerStandeirdMoney;

  }

  /**
   * �H���z�E���E���x�����擾���܂��B
   * @return �H���z�E���E���x��
   */
  public ACLabel getShortStayRecuperateCareCognitiveNoonDinnerStandeirdMoneyLabel(){
    if(shortStayRecuperateCareCognitiveNoonDinnerStandeirdMoneyLabel==null){

      shortStayRecuperateCareCognitiveNoonDinnerStandeirdMoneyLabel = new ACLabel();

      shortStayRecuperateCareCognitiveNoonDinnerStandeirdMoneyLabel.setText("��");

      addShortStayRecuperateCareCognitiveNoonDinnerStandeirdMoneyLabel();
    }
    return shortStayRecuperateCareCognitiveNoonDinnerStandeirdMoneyLabel;

  }

  /**
   * �H���z�E���E�e�L�X�g���擾���܂��B
   * @return �H���z�E���E�e�L�X�g
   */
  public ACTextField getShortStayRecuperateCareCognitiveNoonDinnerStandeirdMoney(){
    if(shortStayRecuperateCareCognitiveNoonDinnerStandeirdMoney==null){

      shortStayRecuperateCareCognitiveNoonDinnerStandeirdMoney = new ACTextField();

      shortStayRecuperateCareCognitiveNoonDinnerStandeirdMoney.setBindPath("1230309");

      shortStayRecuperateCareCognitiveNoonDinnerStandeirdMoney.setColumns(3);

      shortStayRecuperateCareCognitiveNoonDinnerStandeirdMoney.setCharType(VRCharType.ONLY_DIGIT);

      shortStayRecuperateCareCognitiveNoonDinnerStandeirdMoney.setHorizontalAlignment(SwingConstants.RIGHT);

      shortStayRecuperateCareCognitiveNoonDinnerStandeirdMoney.setIMEMode(InputSubset.LATIN);

      shortStayRecuperateCareCognitiveNoonDinnerStandeirdMoney.setMaxLength(3);

      addShortStayRecuperateCareCognitiveNoonDinnerStandeirdMoney();
    }
    return shortStayRecuperateCareCognitiveNoonDinnerStandeirdMoney;

  }

  /**
   * �H���z�E��E���x�����擾���܂��B
   * @return �H���z�E��E���x��
   */
  public ACLabel getShortStayRecuperateCareCognitiveNightDinnerStandeirdTotalMoneyLabel(){
    if(shortStayRecuperateCareCognitiveNightDinnerStandeirdTotalMoneyLabel==null){

      shortStayRecuperateCareCognitiveNightDinnerStandeirdTotalMoneyLabel = new ACLabel();

      shortStayRecuperateCareCognitiveNightDinnerStandeirdTotalMoneyLabel.setText("��");

      addShortStayRecuperateCareCognitiveNightDinnerStandeirdTotalMoneyLabel();
    }
    return shortStayRecuperateCareCognitiveNightDinnerStandeirdTotalMoneyLabel;

  }

  /**
   * �H���z�E��E�e�L�X�g���擾���܂��B
   * @return �H���z�E��E�e�L�X�g
   */
  public ACTextField getShortStayRecuperateCareCognitiveNightDinnerStandeirdMoney(){
    if(shortStayRecuperateCareCognitiveNightDinnerStandeirdMoney==null){

      shortStayRecuperateCareCognitiveNightDinnerStandeirdMoney = new ACTextField();

      shortStayRecuperateCareCognitiveNightDinnerStandeirdMoney.setBindPath("1230310");

      shortStayRecuperateCareCognitiveNightDinnerStandeirdMoney.setColumns(3);

      shortStayRecuperateCareCognitiveNightDinnerStandeirdMoney.setCharType(VRCharType.ONLY_DIGIT);

      shortStayRecuperateCareCognitiveNightDinnerStandeirdMoney.setHorizontalAlignment(SwingConstants.RIGHT);

      shortStayRecuperateCareCognitiveNightDinnerStandeirdMoney.setIMEMode(InputSubset.LATIN);

      shortStayRecuperateCareCognitiveNightDinnerStandeirdMoney.setMaxLength(3);

      addShortStayRecuperateCareCognitiveNightDinnerStandeirdMoney();
    }
    return shortStayRecuperateCareCognitiveNightDinnerStandeirdMoney;

  }

  /**
   * �H���z�E���x�����擾���܂��B
   * @return �H���z�E���x��
   */
  public ACLabel getShortStayRecuperateCareCognitiveRecuperateCareCognitiveDinnerStandeirdMoney4Label(){
    if(shortStayRecuperateCareCognitiveRecuperateCareCognitiveDinnerStandeirdMoney4Label==null){

      shortStayRecuperateCareCognitiveRecuperateCareCognitiveDinnerStandeirdMoney4Label = new ACLabel();

      shortStayRecuperateCareCognitiveRecuperateCareCognitiveDinnerStandeirdMoney4Label.setText("�i�~�j");

      addShortStayRecuperateCareCognitiveRecuperateCareCognitiveDinnerStandeirdMoney4Label();
    }
    return shortStayRecuperateCareCognitiveRecuperateCareCognitiveDinnerStandeirdMoney4Label;

  }

  /**
   * ���j�b�g�^����z�E�R���e�i���擾���܂��B
   * @return ���j�b�g�^����z�E�R���e�i
   */
  public ACLabelContainer getShortStayRecuperateCareCognitiveUnitRoomStandeirdMoneyConteiner(){
    if(shortStayRecuperateCareCognitiveUnitRoomStandeirdMoneyConteiner==null){

      shortStayRecuperateCareCognitiveUnitRoomStandeirdMoneyConteiner = new ACLabelContainer();

      shortStayRecuperateCareCognitiveUnitRoomStandeirdMoneyConteiner.setText("���j�b�g�^����z");

      shortStayRecuperateCareCognitiveUnitRoomStandeirdMoneyConteiner.setFollowChildEnabled(true);

      addShortStayRecuperateCareCognitiveUnitRoomStandeirdMoneyConteiner();
    }
    return shortStayRecuperateCareCognitiveUnitRoomStandeirdMoneyConteiner;

  }

  /**
   * ���j�b�g�^����z�E�e�L�X�g���擾���܂��B
   * @return ���j�b�g�^����z�E�e�L�X�g
   */
  public ACTextField getShortStayRecuperateCareCognitiveUnitRoomStandeirdMoneyText(){
    if(shortStayRecuperateCareCognitiveUnitRoomStandeirdMoneyText==null){

      shortStayRecuperateCareCognitiveUnitRoomStandeirdMoneyText = new ACTextField();

      shortStayRecuperateCareCognitiveUnitRoomStandeirdMoneyText.setBindPath("1230311");

      shortStayRecuperateCareCognitiveUnitRoomStandeirdMoneyText.setColumns(4);

      shortStayRecuperateCareCognitiveUnitRoomStandeirdMoneyText.setCharType(VRCharType.ONLY_DIGIT);

      shortStayRecuperateCareCognitiveUnitRoomStandeirdMoneyText.setHorizontalAlignment(SwingConstants.RIGHT);

      shortStayRecuperateCareCognitiveUnitRoomStandeirdMoneyText.setIMEMode(InputSubset.LATIN);

      shortStayRecuperateCareCognitiveUnitRoomStandeirdMoneyText.setMaxLength(4);

      addShortStayRecuperateCareCognitiveUnitRoomStandeirdMoneyText();
    }
    return shortStayRecuperateCareCognitiveUnitRoomStandeirdMoneyText;

  }

  /**
   * ���j�b�g�^����z�E���x�����擾���܂��B
   * @return ���j�b�g�^����z�E���x��
   */
  public ACLabel getShortStayRecuperateCareCognitiveUnitRoomStandeirdMoneyLabel(){
    if(shortStayRecuperateCareCognitiveUnitRoomStandeirdMoneyLabel==null){

      shortStayRecuperateCareCognitiveUnitRoomStandeirdMoneyLabel = new ACLabel();

      shortStayRecuperateCareCognitiveUnitRoomStandeirdMoneyLabel.setText("�i�~�j");

      addShortStayRecuperateCareCognitiveUnitRoomStandeirdMoneyLabel();
    }
    return shortStayRecuperateCareCognitiveUnitRoomStandeirdMoneyLabel;

  }

  /**
   * ���j�b�g�^������z�E�R���e�i���擾���܂��B
   * @return ���j�b�g�^������z�E�R���e�i
   */
  public ACLabelContainer getShortStayRecuperateCareCognitiveUnitSemiRoomStandeirdMoneyConteiner(){
    if(shortStayRecuperateCareCognitiveUnitSemiRoomStandeirdMoneyConteiner==null){

      shortStayRecuperateCareCognitiveUnitSemiRoomStandeirdMoneyConteiner = new ACLabelContainer();

      shortStayRecuperateCareCognitiveUnitSemiRoomStandeirdMoneyConteiner.setText("���j�b�g�^������z");

      shortStayRecuperateCareCognitiveUnitSemiRoomStandeirdMoneyConteiner.setFollowChildEnabled(true);

      addShortStayRecuperateCareCognitiveUnitSemiRoomStandeirdMoneyConteiner();
    }
    return shortStayRecuperateCareCognitiveUnitSemiRoomStandeirdMoneyConteiner;

  }

  /**
   * ���j�b�g�^������z�E�e�L�X�g���擾���܂��B
   * @return ���j�b�g�^������z�E�e�L�X�g
   */
  public ACTextField getShortStayRecuperateCareCognitiveUnitSemiRoomStandeirdMoneyText(){
    if(shortStayRecuperateCareCognitiveUnitSemiRoomStandeirdMoneyText==null){

      shortStayRecuperateCareCognitiveUnitSemiRoomStandeirdMoneyText = new ACTextField();

      shortStayRecuperateCareCognitiveUnitSemiRoomStandeirdMoneyText.setBindPath("1230312");

      shortStayRecuperateCareCognitiveUnitSemiRoomStandeirdMoneyText.setColumns(4);

      shortStayRecuperateCareCognitiveUnitSemiRoomStandeirdMoneyText.setCharType(VRCharType.ONLY_DIGIT);

      shortStayRecuperateCareCognitiveUnitSemiRoomStandeirdMoneyText.setHorizontalAlignment(SwingConstants.RIGHT);

      shortStayRecuperateCareCognitiveUnitSemiRoomStandeirdMoneyText.setIMEMode(InputSubset.LATIN);

      shortStayRecuperateCareCognitiveUnitSemiRoomStandeirdMoneyText.setMaxLength(4);

      addShortStayRecuperateCareCognitiveUnitSemiRoomStandeirdMoneyText();
    }
    return shortStayRecuperateCareCognitiveUnitSemiRoomStandeirdMoneyText;

  }

  /**
   * ���j�b�g�^������z�E���x�����擾���܂��B
   * @return ���j�b�g�^������z�E���x��
   */
  public ACLabel getShortStayRecuperateCareCognitiveUnitSemiRoomStandeirdMoneyLabel(){
    if(shortStayRecuperateCareCognitiveUnitSemiRoomStandeirdMoneyLabel==null){

      shortStayRecuperateCareCognitiveUnitSemiRoomStandeirdMoneyLabel = new ACLabel();

      shortStayRecuperateCareCognitiveUnitSemiRoomStandeirdMoneyLabel.setText("�i�~�j");

      addShortStayRecuperateCareCognitiveUnitSemiRoomStandeirdMoneyLabel();
    }
    return shortStayRecuperateCareCognitiveUnitSemiRoomStandeirdMoneyLabel;

  }

  /**
   * �]���^����z�E�R���e�i���擾���܂��B
   * @return �]���^����z�E�R���e�i
   */
  public ACLabelContainer getShortStayRecuperateCareCognitiveNormalRoomStandeirdMoneyConteiner(){
    if(shortStayRecuperateCareCognitiveNormalRoomStandeirdMoneyConteiner==null){

      shortStayRecuperateCareCognitiveNormalRoomStandeirdMoneyConteiner = new ACLabelContainer();

      shortStayRecuperateCareCognitiveNormalRoomStandeirdMoneyConteiner.setText("�@�@�]���^����z");

      shortStayRecuperateCareCognitiveNormalRoomStandeirdMoneyConteiner.setFollowChildEnabled(true);

      addShortStayRecuperateCareCognitiveNormalRoomStandeirdMoneyConteiner();
    }
    return shortStayRecuperateCareCognitiveNormalRoomStandeirdMoneyConteiner;

  }

  /**
   * �]���^����z�E�e�L�X�g���擾���܂��B
   * @return �]���^����z�E�e�L�X�g
   */
  public ACTextField getShortStayRecuperateCareCognitiveNormalRoomStandeirdMoneyText(){
    if(shortStayRecuperateCareCognitiveNormalRoomStandeirdMoneyText==null){

      shortStayRecuperateCareCognitiveNormalRoomStandeirdMoneyText = new ACTextField();

      shortStayRecuperateCareCognitiveNormalRoomStandeirdMoneyText.setBindPath("1230313");

      shortStayRecuperateCareCognitiveNormalRoomStandeirdMoneyText.setColumns(4);

      shortStayRecuperateCareCognitiveNormalRoomStandeirdMoneyText.setCharType(VRCharType.ONLY_DIGIT);

      shortStayRecuperateCareCognitiveNormalRoomStandeirdMoneyText.setHorizontalAlignment(SwingConstants.RIGHT);

      shortStayRecuperateCareCognitiveNormalRoomStandeirdMoneyText.setIMEMode(InputSubset.LATIN);

      shortStayRecuperateCareCognitiveNormalRoomStandeirdMoneyText.setMaxLength(4);

      addShortStayRecuperateCareCognitiveNormalRoomStandeirdMoneyText();
    }
    return shortStayRecuperateCareCognitiveNormalRoomStandeirdMoneyText;

  }

  /**
   * �]���^����z�E���x�����擾���܂��B
   * @return �]���^����z�E���x��
   */
  public ACLabel getShortStayRecuperateCareCognitiveNormalRoomStandeirdMoneyLabel(){
    if(shortStayRecuperateCareCognitiveNormalRoomStandeirdMoneyLabel==null){

      shortStayRecuperateCareCognitiveNormalRoomStandeirdMoneyLabel = new ACLabel();

      shortStayRecuperateCareCognitiveNormalRoomStandeirdMoneyLabel.setText("�i�~�j");

      addShortStayRecuperateCareCognitiveNormalRoomStandeirdMoneyLabel();
    }
    return shortStayRecuperateCareCognitiveNormalRoomStandeirdMoneyLabel;

  }

  /**
   * ��������z�E�R���e�i���擾���܂��B
   * @return ��������z�E�R���e�i
   */
  public ACLabelContainer getShortStayRecuperateCareCognitiveTasyouRoomConteiner(){
    if(shortStayRecuperateCareCognitiveTasyouRoomConteiner==null){

      shortStayRecuperateCareCognitiveTasyouRoomConteiner = new ACLabelContainer();

      shortStayRecuperateCareCognitiveTasyouRoomConteiner.setText("�@�@��������z");

      shortStayRecuperateCareCognitiveTasyouRoomConteiner.setFollowChildEnabled(true);

      addShortStayRecuperateCareCognitiveTasyouRoomConteiner();
    }
    return shortStayRecuperateCareCognitiveTasyouRoomConteiner;

  }

  /**
   * ��������z�E�e�L�X�g���擾���܂��B
   * @return ��������z�E�e�L�X�g
   */
  public ACTextField getShortStayRecuperateCareCognitiveTasyouRoomText(){
    if(shortStayRecuperateCareCognitiveTasyouRoomText==null){

      shortStayRecuperateCareCognitiveTasyouRoomText = new ACTextField();

      shortStayRecuperateCareCognitiveTasyouRoomText.setBindPath("1230314");

      shortStayRecuperateCareCognitiveTasyouRoomText.setColumns(4);

      shortStayRecuperateCareCognitiveTasyouRoomText.setCharType(VRCharType.ONLY_DIGIT);

      shortStayRecuperateCareCognitiveTasyouRoomText.setHorizontalAlignment(SwingConstants.RIGHT);

      shortStayRecuperateCareCognitiveTasyouRoomText.setIMEMode(InputSubset.LATIN);

      shortStayRecuperateCareCognitiveTasyouRoomText.setMaxLength(4);

      addShortStayRecuperateCareCognitiveTasyouRoomText();
    }
    return shortStayRecuperateCareCognitiveTasyouRoomText;

  }

  /**
   * ��������z�E���x�����擾���܂��B
   * @return ��������z�E���x��
   */
  public ACLabel getShortStayRecuperateCareCognitiveTasyouRoomLabel(){
    if(shortStayRecuperateCareCognitiveTasyouRoomLabel==null){

      shortStayRecuperateCareCognitiveTasyouRoomLabel = new ACLabel();

      shortStayRecuperateCareCognitiveTasyouRoomLabel.setText("�i�~�j");

      addShortStayRecuperateCareCognitiveTasyouRoomLabel();
    }
    return shortStayRecuperateCareCognitiveTasyouRoomLabel;

  }

  /**
   * �R���X�g���N�^�ł��B
   */
  public QO004012Design() {

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

    this.add(getShortStayDementiaDiseaseRecuperationGroup(), VRLayout.CLIENT);

  }

  /**
   * ���ƃO���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayDementiaDiseaseRecuperationGroup(){

    shortStayDementiaDiseaseRecuperationGroup.add(getShortStayDementiaDiseaseRecuperationDiscountConteiner(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayDementiaDiseaseRecuperationGroup.add(getShortStayDementiaDiseaseRecuperationPercentSignCognitiveRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayDementiaDiseaseRecuperationGroup.add(getShortStayDementiaDiseaseRecuperationStaffAssignmentDivisionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayDementiaDiseaseRecuperationGroup.add(getShortStayDementiaDiseaseRecuperationMeetingAndSendingOffSystemContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayDementiaDiseaseRecuperationGroup.add(getShortStayDementiaDiseaseRecuperationNutritionManageRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayDementiaDiseaseRecuperationGroup.add(getShortStayDementiaDiseaseRecuperationRecuperateDinnerRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayDementiaDiseaseRecuperationGroup.add(getShortStayDementiaDiseaseRecuperationStaffReduceContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayDementiaDiseaseRecuperationGroup.add(getShortStayRecuperateCareCognitiveDinnerStandeirdMoneyConteiner(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayDementiaDiseaseRecuperationGroup.add(getShortStayRecuperateCareCognitiveUnitRoomStandeirdMoneyConteiner(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayDementiaDiseaseRecuperationGroup.add(getShortStayRecuperateCareCognitiveUnitSemiRoomStandeirdMoneyConteiner(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayDementiaDiseaseRecuperationGroup.add(getShortStayRecuperateCareCognitiveNormalRoomStandeirdMoneyConteiner(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayDementiaDiseaseRecuperationGroup.add(getShortStayRecuperateCareCognitiveTasyouRoomConteiner(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * �������R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayDementiaDiseaseRecuperationDiscountConteiner(){

    shortStayDementiaDiseaseRecuperationDiscountConteiner.add(getShortStayDementiaDiseaseRecuperationDiscountRate(), VRLayout.FLOW);

    shortStayDementiaDiseaseRecuperationDiscountConteiner.add(getShortStayDementiaDiseaseRecuperationPercentSign(), VRLayout.FLOW);

  }

  /**
   * �������ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayDementiaDiseaseRecuperationDiscountRate(){

  }

  /**
   * �����x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayDementiaDiseaseRecuperationPercentSign(){

  }

  /**
   * �{�݋敪���W�I�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayDementiaDiseaseRecuperationPercentSignCognitiveRadio(){

  }

  /**
   * �{�݋敪���W�I�O���[�v���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayDementiaDiseaseRecuperationPercentSignCognitiveRadioModel(){

    getShortStayDementiaDiseaseRecuperationPercentSignCognitiveRadioItem1().setButtonIndex(1);
    getShortStayDementiaDiseaseRecuperationPercentSignCognitiveRadioModel().add(getShortStayDementiaDiseaseRecuperationPercentSignCognitiveRadioItem1());

    getShortStayDementiaDiseaseRecuperationPercentSignCognitiveRadioItem2().setButtonIndex(2);
    getShortStayDementiaDiseaseRecuperationPercentSignCognitiveRadioModel().add(getShortStayDementiaDiseaseRecuperationPercentSignCognitiveRadioItem2());

  }

  /**
   * �F�m�ǎ����^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayDementiaDiseaseRecuperationPercentSignCognitiveRadioItem1(){

  }

  /**
   * ���j�b�g�^�F�m�ǎ����^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayDementiaDiseaseRecuperationPercentSignCognitiveRadioItem2(){

  }

  /**
   * �l���z�u�敪���W�I�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayDementiaDiseaseRecuperationStaffAssignmentDivision(){

  }

  /**
   * �l���z�u�敪���W�I�O���[�v���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayDementiaDiseaseRecuperationStaffAssignmentDivisionModel(){

    getShortStayDementiaDiseaseRecuperationStaffAssignmentDivision1().setButtonIndex(1);
    getShortStayDementiaDiseaseRecuperationStaffAssignmentDivisionModel().add(getShortStayDementiaDiseaseRecuperationStaffAssignmentDivision1());

    getShortStayDementiaDiseaseRecuperationStaffAssignmentDivision2().setButtonIndex(2);
    getShortStayDementiaDiseaseRecuperationStaffAssignmentDivisionModel().add(getShortStayDementiaDiseaseRecuperationStaffAssignmentDivision2());

    getShortStayDementiaDiseaseRecuperationstaffAssignmentDivision3().setButtonIndex(3);
    getShortStayDementiaDiseaseRecuperationStaffAssignmentDivisionModel().add(getShortStayDementiaDiseaseRecuperationstaffAssignmentDivision3());

  }

  /**
   * I�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayDementiaDiseaseRecuperationStaffAssignmentDivision1(){

  }

  /**
   * II�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayDementiaDiseaseRecuperationStaffAssignmentDivision2(){

  }

  /**
   * III�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayDementiaDiseaseRecuperationstaffAssignmentDivision3(){

  }

  /**
   * ���}�̐����W�I�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayDementiaDiseaseRecuperationMeetingAndSendingOffSystem(){

  }

  /**
   * ���}�̐����W�I�O���[�v���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayDementiaDiseaseRecuperationMeetingAndSendingOffSystemModel(){

    getShortStayDementiaDiseaseRecuperationMeetingAndSendingOffSystemOff().setButtonIndex(1);
    getShortStayDementiaDiseaseRecuperationMeetingAndSendingOffSystemModel().add(getShortStayDementiaDiseaseRecuperationMeetingAndSendingOffSystemOff());

    getShortStayDementiaDiseaseRecuperationMeetingAndSendingOffSystemOn().setButtonIndex(2);
    getShortStayDementiaDiseaseRecuperationMeetingAndSendingOffSystemModel().add(getShortStayDementiaDiseaseRecuperationMeetingAndSendingOffSystemOn());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayDementiaDiseaseRecuperationMeetingAndSendingOffSystemOff(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayDementiaDiseaseRecuperationMeetingAndSendingOffSystemOn(){

  }

  /**
   * �h�{�Ǘ��̐����W�I�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayDementiaDiseaseRecuperationNutritionManageRadio(){

  }

  /**
   * �h�{�Ǘ��̐����W�I�O���[�v���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayDementiaDiseaseRecuperationNutritionManageRadioModel(){

    getShortStayDementiaDiseaseRecuperationNutritionManageRadioItem1().setButtonIndex(1);
    getShortStayDementiaDiseaseRecuperationNutritionManageRadioModel().add(getShortStayDementiaDiseaseRecuperationNutritionManageRadioItem1());

    getShortStayDementiaDiseaseRecuperationNutritionManageRadioItem2().setButtonIndex(2);
    getShortStayDementiaDiseaseRecuperationNutritionManageRadioModel().add(getShortStayDementiaDiseaseRecuperationNutritionManageRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayDementiaDiseaseRecuperationNutritionManageRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayDementiaDiseaseRecuperationNutritionManageRadioItem2(){

  }

  /**
   * �×{�H�̐����W�I�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayDementiaDiseaseRecuperationRecuperateDinnerRadio(){

  }

  /**
   * �×{�H�̐����W�I�O���[�v���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayDementiaDiseaseRecuperationRecuperateDinnerRadioModel(){

    getShortStayDementiaDiseaseRecuperationRecuperateDinnerRadioItem1().setButtonIndex(1);
    getShortStayDementiaDiseaseRecuperationRecuperateDinnerRadioModel().add(getShortStayDementiaDiseaseRecuperationRecuperateDinnerRadioItem1());

    getShortStayDementiaDiseaseRecuperationRecuperateDinnerRadioItem2().setButtonIndex(2);
    getShortStayDementiaDiseaseRecuperationRecuperateDinnerRadioModel().add(getShortStayDementiaDiseaseRecuperationRecuperateDinnerRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayDementiaDiseaseRecuperationRecuperateDinnerRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayDementiaDiseaseRecuperationRecuperateDinnerRadioItem2(){

  }

  /**
   * �l�����Z�R���{�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayDementiaDiseaseRecuperationStaffReduce(){

  }

  /**
   * �l�����Z�R���{���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayDementiaDiseaseRecuperationStaffReduceModel(){

  }

  /**
   * �H���z�E�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperateCareCognitiveDinnerStandeirdMoneyConteiner(){

    shortStayRecuperateCareCognitiveDinnerStandeirdMoneyConteiner.add(getShortStayRecuperateCareCognitiveDinnerStandeirdMoneyTotal(), VRLayout.FLOW);

    shortStayRecuperateCareCognitiveDinnerStandeirdMoneyConteiner.add(getShortStayRecuperateCareCognitiveMorningDinnerStandeirdMoneyLabel(), VRLayout.FLOW);

    shortStayRecuperateCareCognitiveDinnerStandeirdMoneyConteiner.add(getShortStayRecuperateCareCognitiveMorningDinnerStandeirdMoney(), VRLayout.FLOW);

    shortStayRecuperateCareCognitiveDinnerStandeirdMoneyConteiner.add(getShortStayRecuperateCareCognitiveNoonDinnerStandeirdMoneyLabel(), VRLayout.FLOW);

    shortStayRecuperateCareCognitiveDinnerStandeirdMoneyConteiner.add(getShortStayRecuperateCareCognitiveNoonDinnerStandeirdMoney(), VRLayout.FLOW);

    shortStayRecuperateCareCognitiveDinnerStandeirdMoneyConteiner.add(getShortStayRecuperateCareCognitiveNightDinnerStandeirdTotalMoneyLabel(), VRLayout.FLOW);

    shortStayRecuperateCareCognitiveDinnerStandeirdMoneyConteiner.add(getShortStayRecuperateCareCognitiveNightDinnerStandeirdMoney(), VRLayout.FLOW);

    shortStayRecuperateCareCognitiveDinnerStandeirdMoneyConteiner.add(getShortStayRecuperateCareCognitiveRecuperateCareCognitiveDinnerStandeirdMoney4Label(), VRLayout.FLOW);

  }

  /**
   * �H���z�E���v�E�e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperateCareCognitiveDinnerStandeirdMoneyTotal(){

  }

  /**
   * �H���z�E���E���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperateCareCognitiveMorningDinnerStandeirdMoneyLabel(){

  }

  /**
   * �H���z�E���E�e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperateCareCognitiveMorningDinnerStandeirdMoney(){

  }

  /**
   * �H���z�E���E���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperateCareCognitiveNoonDinnerStandeirdMoneyLabel(){

  }

  /**
   * �H���z�E���E�e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperateCareCognitiveNoonDinnerStandeirdMoney(){

  }

  /**
   * �H���z�E��E���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperateCareCognitiveNightDinnerStandeirdTotalMoneyLabel(){

  }

  /**
   * �H���z�E��E�e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperateCareCognitiveNightDinnerStandeirdMoney(){

  }

  /**
   * �H���z�E���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperateCareCognitiveRecuperateCareCognitiveDinnerStandeirdMoney4Label(){

  }

  /**
   * ���j�b�g�^����z�E�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperateCareCognitiveUnitRoomStandeirdMoneyConteiner(){

    shortStayRecuperateCareCognitiveUnitRoomStandeirdMoneyConteiner.add(getShortStayRecuperateCareCognitiveUnitRoomStandeirdMoneyText(), null);

    shortStayRecuperateCareCognitiveUnitRoomStandeirdMoneyConteiner.add(getShortStayRecuperateCareCognitiveUnitRoomStandeirdMoneyLabel(), null);

  }

  /**
   * ���j�b�g�^����z�E�e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperateCareCognitiveUnitRoomStandeirdMoneyText(){

  }

  /**
   * ���j�b�g�^����z�E���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperateCareCognitiveUnitRoomStandeirdMoneyLabel(){

  }

  /**
   * ���j�b�g�^������z�E�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperateCareCognitiveUnitSemiRoomStandeirdMoneyConteiner(){

    shortStayRecuperateCareCognitiveUnitSemiRoomStandeirdMoneyConteiner.add(getShortStayRecuperateCareCognitiveUnitSemiRoomStandeirdMoneyText(), null);

    shortStayRecuperateCareCognitiveUnitSemiRoomStandeirdMoneyConteiner.add(getShortStayRecuperateCareCognitiveUnitSemiRoomStandeirdMoneyLabel(), null);

  }

  /**
   * ���j�b�g�^������z�E�e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperateCareCognitiveUnitSemiRoomStandeirdMoneyText(){

  }

  /**
   * ���j�b�g�^������z�E���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperateCareCognitiveUnitSemiRoomStandeirdMoneyLabel(){

  }

  /**
   * �]���^����z�E�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperateCareCognitiveNormalRoomStandeirdMoneyConteiner(){

    shortStayRecuperateCareCognitiveNormalRoomStandeirdMoneyConteiner.add(getShortStayRecuperateCareCognitiveNormalRoomStandeirdMoneyText(), null);

    shortStayRecuperateCareCognitiveNormalRoomStandeirdMoneyConteiner.add(getShortStayRecuperateCareCognitiveNormalRoomStandeirdMoneyLabel(), null);

  }

  /**
   * �]���^����z�E�e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperateCareCognitiveNormalRoomStandeirdMoneyText(){

  }

  /**
   * �]���^����z�E���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperateCareCognitiveNormalRoomStandeirdMoneyLabel(){

  }

  /**
   * ��������z�E�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperateCareCognitiveTasyouRoomConteiner(){

    shortStayRecuperateCareCognitiveTasyouRoomConteiner.add(getShortStayRecuperateCareCognitiveTasyouRoomText(), null);

    shortStayRecuperateCareCognitiveTasyouRoomConteiner.add(getShortStayRecuperateCareCognitiveTasyouRoomLabel(), null);

  }

  /**
   * ��������z�E�e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperateCareCognitiveTasyouRoomText(){

  }

  /**
   * ��������z�E���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperateCareCognitiveTasyouRoomLabel(){

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
      ACFrame.getInstance().getContentPane().add(new QO004012Design());
      ACFrame.getInstance().setVisible(true);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QO004012Design getThis() {
    return this;
  }
}
