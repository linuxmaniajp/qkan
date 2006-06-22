
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
 * �v���O���� �ʏ����n (QO004006)
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
 * �ʏ����n��ʍ��ڃf�U�C��(QO004006) 
 */
public class QO004006Design extends ACPanel {
  //GUI�R���|�[�l���g

  private ACGroupBox tsuusyorehabilitationGroup;

  private ACLabelContainer tsuusyorehabilitationDiscountContena;

  private ACTextField tsuusyorehabilitationDiscountRate;

  private ACLabel tsuusyorehabilitationPercentSign;

  private ACClearableRadioButtonGroup tsuusyorehabilitationFacilitiesDivision;

  private ACLabelContainer tsuusyorehabilitationFacilitiesDivisionContainer;

  private ACListModelAdapter tsuusyorehabilitationFacilitiesDivisionModel;

  private ACRadioButtonItem tsuusyorehabilitationNormalFacilities;

  private ACRadioButtonItem tsuusyorehabilitationSmallFacilities;

  private ACRadioButtonItem tsuusyorehabilitationEtcFacilities;

  private ACClearableRadioButtonGroup tsuusyorehabilitationBathingHelpSystem;

  private ACLabelContainer tsuusyorehabilitationBathingHelpSystemContainer;

  private ACListModelAdapter tsuusyorehabilitationBathingHelpSystemModel;

  private ACRadioButtonItem tsuusyorehabilitationBathingHelpSystemOff;

  private ACRadioButtonItem tsuusyorehabilitationBathingHelpSystemOn;

  private ACClearableRadioButtonGroup tsuusyorehabilitationSpecialBathingHelpSystem;

  private ACLabelContainer tsuusyorehabilitationSpecialBathingHelpSystemContainer;

  private ACListModelAdapter tsuusyorehabilitationSpecialBathingHelpSystemModel;

  private ACRadioButtonItem tsuusyorehabilitationSpecialBathingHelpSystemOff;

  private ACRadioButtonItem tsuusyorehabilitationSpecialBathingHelpSystemOn;

  private ACClearableRadioButtonGroup tsuusyorehabilitationMeetingAndSendingOffSystem;

  private ACLabelContainer tsuusyorehabilitationMeetingAndSendingOffSystemContainer;

  private ACListModelAdapter tsuusyorehabilitationMeetingAndSendingOffSystemModel;

  private ACRadioButtonItem tsuusyorehabilitationMeetingAndSendingOffSystemOff;

  private ACRadioButtonItem tsuusyorehabilitationMeetingAndSendingOffSystemOn;

  private ACClearableRadioButtonGroup tsuusyorehabilitationStaffReduce;

  private ACLabelContainer tsuusyorehabilitationStaffReduceContainer;

  private ACListModelAdapter tsuusyorehabilitationStaffReduceModel;

  private ACRadioButtonItem tsuusyorehabilitationStaffNot;

  private ACRadioButtonItem tsuusyorehabilitationStaffExcess;

  private ACRadioButtonItem tsuusyorehabilitationMedicalStaffDivision;

  //getter

  /**
   * ���ƃO���[�v���擾���܂��B
   * @return ���ƃO���[�v
   */
  public ACGroupBox getTsuusyorehabilitationGroup(){
    if(tsuusyorehabilitationGroup==null){

      tsuusyorehabilitationGroup = new ACGroupBox();

      tsuusyorehabilitationGroup.setText("�ʏ����n�r���e�[�V����");

      tsuusyorehabilitationGroup.setFollowChildEnabled(true);

      tsuusyorehabilitationGroup.setHgrid(200);

      addTsuusyorehabilitationGroup();
    }
    return tsuusyorehabilitationGroup;

  }

  /**
   * �������R���e�i���擾���܂��B
   * @return �������R���e�i
   */
  public ACLabelContainer getTsuusyorehabilitationDiscountContena(){
    if(tsuusyorehabilitationDiscountContena==null){

      tsuusyorehabilitationDiscountContena = new ACLabelContainer();

      tsuusyorehabilitationDiscountContena.setText("������");

      tsuusyorehabilitationDiscountContena.setFollowChildEnabled(true);

      addTsuusyorehabilitationDiscountContena();
    }
    return tsuusyorehabilitationDiscountContena;

  }

  /**
   * ���������擾���܂��B
   * @return ������
   */
  public ACTextField getTsuusyorehabilitationDiscountRate(){
    if(tsuusyorehabilitationDiscountRate==null){

      tsuusyorehabilitationDiscountRate = new ACTextField();

      tsuusyorehabilitationDiscountRate.setBindPath("REDUCT_RATE");

      tsuusyorehabilitationDiscountRate.setColumns(3);

      tsuusyorehabilitationDiscountRate.setCharType(VRCharType.ONLY_DIGIT);

      tsuusyorehabilitationDiscountRate.setHorizontalAlignment(SwingConstants.RIGHT);

      tsuusyorehabilitationDiscountRate.setIMEMode(InputSubset.LATIN);

      tsuusyorehabilitationDiscountRate.setMaxLength(3);

      addTsuusyorehabilitationDiscountRate();
    }
    return tsuusyorehabilitationDiscountRate;

  }

  /**
   * �����x�����擾���܂��B
   * @return �����x��
   */
  public ACLabel getTsuusyorehabilitationPercentSign(){
    if(tsuusyorehabilitationPercentSign==null){

      tsuusyorehabilitationPercentSign = new ACLabel();

      tsuusyorehabilitationPercentSign.setText("��");

      addTsuusyorehabilitationPercentSign();
    }
    return tsuusyorehabilitationPercentSign;

  }

  /**
   * �{�݋敪���W�I�O���[�v���擾���܂��B
   * @return �{�݋敪���W�I�O���[�v
   */
  public ACClearableRadioButtonGroup getTsuusyorehabilitationFacilitiesDivision(){
    if(tsuusyorehabilitationFacilitiesDivision==null){

      tsuusyorehabilitationFacilitiesDivision = new ACClearableRadioButtonGroup();

      getTsuusyorehabilitationFacilitiesDivisionContainer().setText("�{�݋敪");

      tsuusyorehabilitationFacilitiesDivision.setBindPath("1160101");

      tsuusyorehabilitationFacilitiesDivision.setModel(getTsuusyorehabilitationFacilitiesDivisionModel());

      tsuusyorehabilitationFacilitiesDivision.setUseClearButton(false);

      addTsuusyorehabilitationFacilitiesDivision();
    }
    return tsuusyorehabilitationFacilitiesDivision;

  }

  /**
   * �{�݋敪���W�I�O���[�v�R���e�i���擾���܂��B
   * @return �{�݋敪���W�I�O���[�v�R���e�i
   */
  protected ACLabelContainer getTsuusyorehabilitationFacilitiesDivisionContainer(){
    if(tsuusyorehabilitationFacilitiesDivisionContainer==null){
      tsuusyorehabilitationFacilitiesDivisionContainer = new ACLabelContainer();
      tsuusyorehabilitationFacilitiesDivisionContainer.setFollowChildEnabled(true);
      tsuusyorehabilitationFacilitiesDivisionContainer.add(getTsuusyorehabilitationFacilitiesDivision(), null);
    }
    return tsuusyorehabilitationFacilitiesDivisionContainer;
  }

  /**
   * �{�݋敪���W�I�O���[�v���f�����擾���܂��B
   * @return �{�݋敪���W�I�O���[�v���f��
   */
  protected ACListModelAdapter getTsuusyorehabilitationFacilitiesDivisionModel(){
    if(tsuusyorehabilitationFacilitiesDivisionModel==null){
      tsuusyorehabilitationFacilitiesDivisionModel = new ACListModelAdapter();
      addTsuusyorehabilitationFacilitiesDivisionModel();
    }
    return tsuusyorehabilitationFacilitiesDivisionModel;
  }

  /**
   * �ʏ�K�͂̈�Ë@�ւ��擾���܂��B
   * @return �ʏ�K�͂̈�Ë@��
   */
  public ACRadioButtonItem getTsuusyorehabilitationNormalFacilities(){
    if(tsuusyorehabilitationNormalFacilities==null){

      tsuusyorehabilitationNormalFacilities = new ACRadioButtonItem();

      tsuusyorehabilitationNormalFacilities.setText("�ʏ�K�͂̈�Ë@��");

      tsuusyorehabilitationNormalFacilities.setGroup(getTsuusyorehabilitationFacilitiesDivision());

      addTsuusyorehabilitationNormalFacilities();
    }
    return tsuusyorehabilitationNormalFacilities;

  }

  /**
   * ���K�͐f�Ï����擾���܂��B
   * @return ���K�͐f�Ï�
   */
  public ACRadioButtonItem getTsuusyorehabilitationSmallFacilities(){
    if(tsuusyorehabilitationSmallFacilities==null){

      tsuusyorehabilitationSmallFacilities = new ACRadioButtonItem();

      tsuusyorehabilitationSmallFacilities.setText("���K�͐f�Ï�");

      tsuusyorehabilitationSmallFacilities.setGroup(getTsuusyorehabilitationFacilitiesDivision());

      addTsuusyorehabilitationSmallFacilities();
    }
    return tsuusyorehabilitationSmallFacilities;

  }

  /**
   * ���V�l�ی��{�݂��擾���܂��B
   * @return ���V�l�ی��{��
   */
  public ACRadioButtonItem getTsuusyorehabilitationEtcFacilities(){
    if(tsuusyorehabilitationEtcFacilities==null){

      tsuusyorehabilitationEtcFacilities = new ACRadioButtonItem();

      tsuusyorehabilitationEtcFacilities.setText("���V�l�ی��{��");

      tsuusyorehabilitationEtcFacilities.setGroup(getTsuusyorehabilitationFacilitiesDivision());

      addTsuusyorehabilitationEtcFacilities();
    }
    return tsuusyorehabilitationEtcFacilities;

  }

  /**
   * ������̐����W�I�O���[�v���擾���܂��B
   * @return ������̐����W�I�O���[�v
   */
  public ACClearableRadioButtonGroup getTsuusyorehabilitationBathingHelpSystem(){
    if(tsuusyorehabilitationBathingHelpSystem==null){

      tsuusyorehabilitationBathingHelpSystem = new ACClearableRadioButtonGroup();

      getTsuusyorehabilitationBathingHelpSystemContainer().setText("������̐�");

      tsuusyorehabilitationBathingHelpSystem.setBindPath("1160102");

      tsuusyorehabilitationBathingHelpSystem.setModel(getTsuusyorehabilitationBathingHelpSystemModel());

      tsuusyorehabilitationBathingHelpSystem.setUseClearButton(false);

      addTsuusyorehabilitationBathingHelpSystem();
    }
    return tsuusyorehabilitationBathingHelpSystem;

  }

  /**
   * ������̐����W�I�O���[�v�R���e�i���擾���܂��B
   * @return ������̐����W�I�O���[�v�R���e�i
   */
  protected ACLabelContainer getTsuusyorehabilitationBathingHelpSystemContainer(){
    if(tsuusyorehabilitationBathingHelpSystemContainer==null){
      tsuusyorehabilitationBathingHelpSystemContainer = new ACLabelContainer();
      tsuusyorehabilitationBathingHelpSystemContainer.setFollowChildEnabled(true);
      tsuusyorehabilitationBathingHelpSystemContainer.add(getTsuusyorehabilitationBathingHelpSystem(), null);
    }
    return tsuusyorehabilitationBathingHelpSystemContainer;
  }

  /**
   * ������̐����W�I�O���[�v���f�����擾���܂��B
   * @return ������̐����W�I�O���[�v���f��
   */
  protected ACListModelAdapter getTsuusyorehabilitationBathingHelpSystemModel(){
    if(tsuusyorehabilitationBathingHelpSystemModel==null){
      tsuusyorehabilitationBathingHelpSystemModel = new ACListModelAdapter();
      addTsuusyorehabilitationBathingHelpSystemModel();
    }
    return tsuusyorehabilitationBathingHelpSystemModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getTsuusyorehabilitationBathingHelpSystemOff(){
    if(tsuusyorehabilitationBathingHelpSystemOff==null){

      tsuusyorehabilitationBathingHelpSystemOff = new ACRadioButtonItem();

      tsuusyorehabilitationBathingHelpSystemOff.setText("�Ȃ�");

      tsuusyorehabilitationBathingHelpSystemOff.setGroup(getTsuusyorehabilitationBathingHelpSystem());

      addTsuusyorehabilitationBathingHelpSystemOff();
    }
    return tsuusyorehabilitationBathingHelpSystemOff;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getTsuusyorehabilitationBathingHelpSystemOn(){
    if(tsuusyorehabilitationBathingHelpSystemOn==null){

      tsuusyorehabilitationBathingHelpSystemOn = new ACRadioButtonItem();

      tsuusyorehabilitationBathingHelpSystemOn.setText("����");

      tsuusyorehabilitationBathingHelpSystemOn.setGroup(getTsuusyorehabilitationBathingHelpSystem());

      addTsuusyorehabilitationBathingHelpSystemOn();
    }
    return tsuusyorehabilitationBathingHelpSystemOn;

  }

  /**
   * ���ʓ�����̐����W�I�O���[�v���擾���܂��B
   * @return ���ʓ�����̐����W�I�O���[�v
   */
  public ACClearableRadioButtonGroup getTsuusyorehabilitationSpecialBathingHelpSystem(){
    if(tsuusyorehabilitationSpecialBathingHelpSystem==null){

      tsuusyorehabilitationSpecialBathingHelpSystem = new ACClearableRadioButtonGroup();

      getTsuusyorehabilitationSpecialBathingHelpSystemContainer().setText("���ʓ�����̐�");

      tsuusyorehabilitationSpecialBathingHelpSystem.setBindPath("1160103");

      tsuusyorehabilitationSpecialBathingHelpSystem.setModel(getTsuusyorehabilitationSpecialBathingHelpSystemModel());

      tsuusyorehabilitationSpecialBathingHelpSystem.setUseClearButton(false);

      addTsuusyorehabilitationSpecialBathingHelpSystem();
    }
    return tsuusyorehabilitationSpecialBathingHelpSystem;

  }

  /**
   * ���ʓ�����̐����W�I�O���[�v�R���e�i���擾���܂��B
   * @return ���ʓ�����̐����W�I�O���[�v�R���e�i
   */
  protected ACLabelContainer getTsuusyorehabilitationSpecialBathingHelpSystemContainer(){
    if(tsuusyorehabilitationSpecialBathingHelpSystemContainer==null){
      tsuusyorehabilitationSpecialBathingHelpSystemContainer = new ACLabelContainer();
      tsuusyorehabilitationSpecialBathingHelpSystemContainer.setFollowChildEnabled(true);
      tsuusyorehabilitationSpecialBathingHelpSystemContainer.add(getTsuusyorehabilitationSpecialBathingHelpSystem(), null);
    }
    return tsuusyorehabilitationSpecialBathingHelpSystemContainer;
  }

  /**
   * ���ʓ�����̐����W�I�O���[�v���f�����擾���܂��B
   * @return ���ʓ�����̐����W�I�O���[�v���f��
   */
  protected ACListModelAdapter getTsuusyorehabilitationSpecialBathingHelpSystemModel(){
    if(tsuusyorehabilitationSpecialBathingHelpSystemModel==null){
      tsuusyorehabilitationSpecialBathingHelpSystemModel = new ACListModelAdapter();
      addTsuusyorehabilitationSpecialBathingHelpSystemModel();
    }
    return tsuusyorehabilitationSpecialBathingHelpSystemModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getTsuusyorehabilitationSpecialBathingHelpSystemOff(){
    if(tsuusyorehabilitationSpecialBathingHelpSystemOff==null){

      tsuusyorehabilitationSpecialBathingHelpSystemOff = new ACRadioButtonItem();

      tsuusyorehabilitationSpecialBathingHelpSystemOff.setText("�Ȃ�");

      tsuusyorehabilitationSpecialBathingHelpSystemOff.setGroup(getTsuusyorehabilitationSpecialBathingHelpSystem());

      addTsuusyorehabilitationSpecialBathingHelpSystemOff();
    }
    return tsuusyorehabilitationSpecialBathingHelpSystemOff;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getTsuusyorehabilitationSpecialBathingHelpSystemOn(){
    if(tsuusyorehabilitationSpecialBathingHelpSystemOn==null){

      tsuusyorehabilitationSpecialBathingHelpSystemOn = new ACRadioButtonItem();

      tsuusyorehabilitationSpecialBathingHelpSystemOn.setText("����");

      tsuusyorehabilitationSpecialBathingHelpSystemOn.setGroup(getTsuusyorehabilitationSpecialBathingHelpSystem());

      addTsuusyorehabilitationSpecialBathingHelpSystemOn();
    }
    return tsuusyorehabilitationSpecialBathingHelpSystemOn;

  }

  /**
   * ���}�̐����W�I�O���[�v���擾���܂��B
   * @return ���}�̐����W�I�O���[�v
   */
  public ACClearableRadioButtonGroup getTsuusyorehabilitationMeetingAndSendingOffSystem(){
    if(tsuusyorehabilitationMeetingAndSendingOffSystem==null){

      tsuusyorehabilitationMeetingAndSendingOffSystem = new ACClearableRadioButtonGroup();

      getTsuusyorehabilitationMeetingAndSendingOffSystemContainer().setText("���}�̐�");

      tsuusyorehabilitationMeetingAndSendingOffSystem.setBindPath("1160104");

      tsuusyorehabilitationMeetingAndSendingOffSystem.setModel(getTsuusyorehabilitationMeetingAndSendingOffSystemModel());

      tsuusyorehabilitationMeetingAndSendingOffSystem.setUseClearButton(false);

      addTsuusyorehabilitationMeetingAndSendingOffSystem();
    }
    return tsuusyorehabilitationMeetingAndSendingOffSystem;

  }

  /**
   * ���}�̐����W�I�O���[�v�R���e�i���擾���܂��B
   * @return ���}�̐����W�I�O���[�v�R���e�i
   */
  protected ACLabelContainer getTsuusyorehabilitationMeetingAndSendingOffSystemContainer(){
    if(tsuusyorehabilitationMeetingAndSendingOffSystemContainer==null){
      tsuusyorehabilitationMeetingAndSendingOffSystemContainer = new ACLabelContainer();
      tsuusyorehabilitationMeetingAndSendingOffSystemContainer.setFollowChildEnabled(true);
      tsuusyorehabilitationMeetingAndSendingOffSystemContainer.add(getTsuusyorehabilitationMeetingAndSendingOffSystem(), null);
    }
    return tsuusyorehabilitationMeetingAndSendingOffSystemContainer;
  }

  /**
   * ���}�̐����W�I�O���[�v���f�����擾���܂��B
   * @return ���}�̐����W�I�O���[�v���f��
   */
  protected ACListModelAdapter getTsuusyorehabilitationMeetingAndSendingOffSystemModel(){
    if(tsuusyorehabilitationMeetingAndSendingOffSystemModel==null){
      tsuusyorehabilitationMeetingAndSendingOffSystemModel = new ACListModelAdapter();
      addTsuusyorehabilitationMeetingAndSendingOffSystemModel();
    }
    return tsuusyorehabilitationMeetingAndSendingOffSystemModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getTsuusyorehabilitationMeetingAndSendingOffSystemOff(){
    if(tsuusyorehabilitationMeetingAndSendingOffSystemOff==null){

      tsuusyorehabilitationMeetingAndSendingOffSystemOff = new ACRadioButtonItem();

      tsuusyorehabilitationMeetingAndSendingOffSystemOff.setText("�Ȃ�");

      tsuusyorehabilitationMeetingAndSendingOffSystemOff.setGroup(getTsuusyorehabilitationMeetingAndSendingOffSystem());

      addTsuusyorehabilitationMeetingAndSendingOffSystemOff();
    }
    return tsuusyorehabilitationMeetingAndSendingOffSystemOff;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getTsuusyorehabilitationMeetingAndSendingOffSystemOn(){
    if(tsuusyorehabilitationMeetingAndSendingOffSystemOn==null){

      tsuusyorehabilitationMeetingAndSendingOffSystemOn = new ACRadioButtonItem();

      tsuusyorehabilitationMeetingAndSendingOffSystemOn.setText("����");

      tsuusyorehabilitationMeetingAndSendingOffSystemOn.setGroup(getTsuusyorehabilitationMeetingAndSendingOffSystem());

      addTsuusyorehabilitationMeetingAndSendingOffSystemOn();
    }
    return tsuusyorehabilitationMeetingAndSendingOffSystemOn;

  }

  /**
   * �l�����Z���W�I�O���[�v���擾���܂��B
   * @return �l�����Z���W�I�O���[�v
   */
  public ACClearableRadioButtonGroup getTsuusyorehabilitationStaffReduce(){
    if(tsuusyorehabilitationStaffReduce==null){

      tsuusyorehabilitationStaffReduce = new ACClearableRadioButtonGroup();

      getTsuusyorehabilitationStaffReduceContainer().setText("�l�����Z");

      tsuusyorehabilitationStaffReduce.setBindPath("1160105");

      tsuusyorehabilitationStaffReduce.setModel(getTsuusyorehabilitationStaffReduceModel());

      tsuusyorehabilitationStaffReduce.setUseClearButton(false);

      addTsuusyorehabilitationStaffReduce();
    }
    return tsuusyorehabilitationStaffReduce;

  }

  /**
   * �l�����Z���W�I�O���[�v�R���e�i���擾���܂��B
   * @return �l�����Z���W�I�O���[�v�R���e�i
   */
  protected ACLabelContainer getTsuusyorehabilitationStaffReduceContainer(){
    if(tsuusyorehabilitationStaffReduceContainer==null){
      tsuusyorehabilitationStaffReduceContainer = new ACLabelContainer();
      tsuusyorehabilitationStaffReduceContainer.setFollowChildEnabled(true);
      tsuusyorehabilitationStaffReduceContainer.add(getTsuusyorehabilitationStaffReduce(), null);
    }
    return tsuusyorehabilitationStaffReduceContainer;
  }

  /**
   * �l�����Z���W�I�O���[�v���f�����擾���܂��B
   * @return �l�����Z���W�I�O���[�v���f��
   */
  protected ACListModelAdapter getTsuusyorehabilitationStaffReduceModel(){
    if(tsuusyorehabilitationStaffReduceModel==null){
      tsuusyorehabilitationStaffReduceModel = new ACListModelAdapter();
      addTsuusyorehabilitationStaffReduceModel();
    }
    return tsuusyorehabilitationStaffReduceModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getTsuusyorehabilitationStaffNot(){
    if(tsuusyorehabilitationStaffNot==null){

      tsuusyorehabilitationStaffNot = new ACRadioButtonItem();

      tsuusyorehabilitationStaffNot.setText("�Ȃ�");

      tsuusyorehabilitationStaffNot.setGroup(getTsuusyorehabilitationStaffReduce());

      addTsuusyorehabilitationStaffNot();
    }
    return tsuusyorehabilitationStaffNot;

  }

  /**
   * ������߂��擾���܂��B
   * @return �������
   */
  public ACRadioButtonItem getTsuusyorehabilitationStaffExcess(){
    if(tsuusyorehabilitationStaffExcess==null){

      tsuusyorehabilitationStaffExcess = new ACRadioButtonItem();

      tsuusyorehabilitationStaffExcess.setText("�������");

      tsuusyorehabilitationStaffExcess.setGroup(getTsuusyorehabilitationStaffReduce());

      addTsuusyorehabilitationStaffExcess();
    }
    return tsuusyorehabilitationStaffExcess;

  }

  /**
   * ��t�APT�EOT�EST�A�Ō�E���E���̕s�����擾���܂��B
   * @return ��t�APT�EOT�EST�A�Ō�E���E���̕s��
   */
  public ACRadioButtonItem getTsuusyorehabilitationMedicalStaffDivision(){
    if(tsuusyorehabilitationMedicalStaffDivision==null){

      tsuusyorehabilitationMedicalStaffDivision = new ACRadioButtonItem();

      tsuusyorehabilitationMedicalStaffDivision.setText("��t�APT�EOT�EST�A�Ō�E���E���̕s��");

      tsuusyorehabilitationMedicalStaffDivision.setGroup(getTsuusyorehabilitationStaffReduce());

      addTsuusyorehabilitationMedicalStaffDivision();
    }
    return tsuusyorehabilitationMedicalStaffDivision;

  }

  /**
   * �R���X�g���N�^�ł��B
   */
  public QO004006Design() {

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

    this.add(getTsuusyorehabilitationGroup(), VRLayout.CLIENT);

  }

  /**
   * ���ƃO���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTsuusyorehabilitationGroup(){

    tsuusyorehabilitationGroup.add(getTsuusyorehabilitationDiscountContena(), VRLayout.FLOW_INSETLINE_RETURN);

    tsuusyorehabilitationGroup.add(getTsuusyorehabilitationFacilitiesDivisionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tsuusyorehabilitationGroup.add(getTsuusyorehabilitationBathingHelpSystemContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tsuusyorehabilitationGroup.add(getTsuusyorehabilitationSpecialBathingHelpSystemContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tsuusyorehabilitationGroup.add(getTsuusyorehabilitationMeetingAndSendingOffSystemContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tsuusyorehabilitationGroup.add(getTsuusyorehabilitationStaffReduceContainer(), VRLayout.FLOW_INSETLINE);

  }

  /**
   * �������R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTsuusyorehabilitationDiscountContena(){

    tsuusyorehabilitationDiscountContena.add(getTsuusyorehabilitationDiscountRate(), VRLayout.FLOW);

    tsuusyorehabilitationDiscountContena.add(getTsuusyorehabilitationPercentSign(), VRLayout.FLOW);

  }

  /**
   * �������ɓ������ڂ�ǉ����܂��B
   */
  protected void addTsuusyorehabilitationDiscountRate(){

  }

  /**
   * �����x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addTsuusyorehabilitationPercentSign(){

  }

  /**
   * �{�݋敪���W�I�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTsuusyorehabilitationFacilitiesDivision(){

  }

  /**
   * �{�݋敪���W�I�O���[�v���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addTsuusyorehabilitationFacilitiesDivisionModel(){

    getTsuusyorehabilitationNormalFacilities().setButtonIndex(1);
    getTsuusyorehabilitationFacilitiesDivisionModel().add(getTsuusyorehabilitationNormalFacilities());

    getTsuusyorehabilitationSmallFacilities().setButtonIndex(2);
    getTsuusyorehabilitationFacilitiesDivisionModel().add(getTsuusyorehabilitationSmallFacilities());

    getTsuusyorehabilitationEtcFacilities().setButtonIndex(3);
    getTsuusyorehabilitationFacilitiesDivisionModel().add(getTsuusyorehabilitationEtcFacilities());

  }

  /**
   * �ʏ�K�͂̈�Ë@�ւɓ������ڂ�ǉ����܂��B
   */
  protected void addTsuusyorehabilitationNormalFacilities(){

  }

  /**
   * ���K�͐f�Ï��ɓ������ڂ�ǉ����܂��B
   */
  protected void addTsuusyorehabilitationSmallFacilities(){

  }

  /**
   * ���V�l�ی��{�݂ɓ������ڂ�ǉ����܂��B
   */
  protected void addTsuusyorehabilitationEtcFacilities(){

  }

  /**
   * ������̐����W�I�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTsuusyorehabilitationBathingHelpSystem(){

  }

  /**
   * ������̐����W�I�O���[�v���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addTsuusyorehabilitationBathingHelpSystemModel(){

    getTsuusyorehabilitationBathingHelpSystemOff().setButtonIndex(1);
    getTsuusyorehabilitationBathingHelpSystemModel().add(getTsuusyorehabilitationBathingHelpSystemOff());

    getTsuusyorehabilitationBathingHelpSystemOn().setButtonIndex(2);
    getTsuusyorehabilitationBathingHelpSystemModel().add(getTsuusyorehabilitationBathingHelpSystemOn());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addTsuusyorehabilitationBathingHelpSystemOff(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addTsuusyorehabilitationBathingHelpSystemOn(){

  }

  /**
   * ���ʓ�����̐����W�I�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTsuusyorehabilitationSpecialBathingHelpSystem(){

  }

  /**
   * ���ʓ�����̐����W�I�O���[�v���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addTsuusyorehabilitationSpecialBathingHelpSystemModel(){

    getTsuusyorehabilitationSpecialBathingHelpSystemOff().setButtonIndex(1);
    getTsuusyorehabilitationSpecialBathingHelpSystemModel().add(getTsuusyorehabilitationSpecialBathingHelpSystemOff());

    getTsuusyorehabilitationSpecialBathingHelpSystemOn().setButtonIndex(2);
    getTsuusyorehabilitationSpecialBathingHelpSystemModel().add(getTsuusyorehabilitationSpecialBathingHelpSystemOn());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addTsuusyorehabilitationSpecialBathingHelpSystemOff(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addTsuusyorehabilitationSpecialBathingHelpSystemOn(){

  }

  /**
   * ���}�̐����W�I�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTsuusyorehabilitationMeetingAndSendingOffSystem(){

  }

  /**
   * ���}�̐����W�I�O���[�v���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addTsuusyorehabilitationMeetingAndSendingOffSystemModel(){

    getTsuusyorehabilitationMeetingAndSendingOffSystemOff().setButtonIndex(1);
    getTsuusyorehabilitationMeetingAndSendingOffSystemModel().add(getTsuusyorehabilitationMeetingAndSendingOffSystemOff());

    getTsuusyorehabilitationMeetingAndSendingOffSystemOn().setButtonIndex(2);
    getTsuusyorehabilitationMeetingAndSendingOffSystemModel().add(getTsuusyorehabilitationMeetingAndSendingOffSystemOn());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addTsuusyorehabilitationMeetingAndSendingOffSystemOff(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addTsuusyorehabilitationMeetingAndSendingOffSystemOn(){

  }

  /**
   * �l�����Z���W�I�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTsuusyorehabilitationStaffReduce(){

  }

  /**
   * �l�����Z���W�I�O���[�v���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addTsuusyorehabilitationStaffReduceModel(){

    getTsuusyorehabilitationStaffNot().setButtonIndex(1);
    getTsuusyorehabilitationStaffReduceModel().add(getTsuusyorehabilitationStaffNot());

    getTsuusyorehabilitationStaffExcess().setButtonIndex(2);
    getTsuusyorehabilitationStaffReduceModel().add(getTsuusyorehabilitationStaffExcess());

    getTsuusyorehabilitationMedicalStaffDivision().setButtonIndex(3);
    getTsuusyorehabilitationStaffReduceModel().add(getTsuusyorehabilitationMedicalStaffDivision());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addTsuusyorehabilitationStaffNot(){

  }

  /**
   * ������߂ɓ������ڂ�ǉ����܂��B
   */
  protected void addTsuusyorehabilitationStaffExcess(){

  }

  /**
   * ��t�APT�EOT�EST�A�Ō�E���E���̕s���ɓ������ڂ�ǉ����܂��B
   */
  protected void addTsuusyorehabilitationMedicalStaffDivision(){

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
      ACFrame.getInstance().getContentPane().add(new QO004006Design());
      ACFrame.getInstance().setVisible(true);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QO004006Design getThis() {
    return this;
  }
}
