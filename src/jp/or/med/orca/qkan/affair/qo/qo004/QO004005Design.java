
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
 * �v���O���� �ʏ���� (QO004005)
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
 * �ʏ�����ʍ��ڃf�U�C��(QO004005) 
 */
public class QO004005Design extends ACPanel {
  //GUI�R���|�[�l���g

  private ACGroupBox tsuusyokaigoGroup;

  private ACLabelContainer tsuusyokaigoDiscountContena;

  private ACTextField tsuusyokaigoDiscountRate;

  private ACLabel tsuusyokaigotSign;

  private ACClearableRadioButtonGroup tsuusyokaigoFacilitiesDivision;

  private ACLabelContainer tsuusyokaigoFacilitiesDivisionContainer;

  private ACListModelAdapter tsuusyokaigoFacilitiesDivisionModel;

  private ACRadioButtonItem tsuusyokaigoSingle;

  private ACRadioButtonItem tsuusyokaigoDouble;

  private ACRadioButtonItem tsuusyokaigoDementiaSingle;

  private ACRadioButtonItem tsuusyokaigoDementiaDouble;

  private ACClearableRadioButtonGroup tsuusyokaigoFunctionTrainingGuidanceSystem;

  private ACLabelContainer tsuusyokaigoFunctionTrainingGuidanceSystemContainer;

  private ACListModelAdapter tsuusyokaigoFunctionTrainingGuidanceSystemModel;

  private ACRadioButtonItem tsuusyokaigoFunctionTrainingGuidanceSystemOff;

  private ACRadioButtonItem tsuusyokaigoFunctionTrainingGuidanceSystemOn;

  private ACClearableRadioButtonGroup tsuusyokaigoBathingHelpSystem;

  private ACLabelContainer tsuusyokaigoBathingHelpSystemContainer;

  private ACListModelAdapter tsuusyokaigoBathingHelpSystemModel;

  private ACRadioButtonItem tsuusyokaigoBathingHelpSystemOff;

  private ACRadioButtonItem tsuusyokaigoBathingHelpSystemOn;

  private ACClearableRadioButtonGroup tsuusyokaigoSpecialBathingHelpSystem;

  private ACLabelContainer tsuusyokaigoSpecialBathingHelpSystemContainer;

  private ACListModelAdapter tsuusyokaigoSpecialBathingHelpSystemModel;

  private ACRadioButtonItem tsuusyokaigoSpecialBathingHelpSystemOff;

  private ACRadioButtonItem tsuusyokaigoSpecialBathingHelpSystemOn;

  private ACClearableRadioButtonGroup tsuusyokaigoMeetingAndSendingOffSystem;

  private ACLabelContainer tsuusyokaigoMeetingAndSendingOffSystemContainer;

  private ACListModelAdapter tsuusyokaigoMeetingAndSendingOffSystemModel;

  private ACRadioButtonItem tsuusyokaigoMeetingAndSendingOffSystemOff;

  private ACRadioButtonItem tsuusyokaigoMeetingAndSendingOffSystemOn;

  private ACClearableRadioButtonGroup tsuusyokaigoStaffRadio;

  private ACLabelContainer tsuusyokaigoStaffRadioContainer;

  private ACListModelAdapter tsuusyokaigoStaffRadioModel;

  private ACRadioButtonItem tsuusyokaigoStaffNot;

  private ACRadioButtonItem tsuusyokaigoStaffReduce;

  private ACRadioButtonItem tsuusyokaigoStaffShortage;

  //getter

  /**
   * ���ƃO���[�v���擾���܂��B
   * @return ���ƃO���[�v
   */
  public ACGroupBox getTsuusyokaigoGroup(){
    if(tsuusyokaigoGroup==null){

      tsuusyokaigoGroup = new ACGroupBox();

      tsuusyokaigoGroup.setText("�ʏ����");

      tsuusyokaigoGroup.setFollowChildEnabled(true);

      tsuusyokaigoGroup.setHgrid(200);

      addTsuusyokaigoGroup();
    }
    return tsuusyokaigoGroup;

  }

  /**
   * �������R���e�i���擾���܂��B
   * @return �������R���e�i
   */
  public ACLabelContainer getTsuusyokaigoDiscountContena(){
    if(tsuusyokaigoDiscountContena==null){

      tsuusyokaigoDiscountContena = new ACLabelContainer();

      tsuusyokaigoDiscountContena.setText("������");

      tsuusyokaigoDiscountContena.setFollowChildEnabled(true);

      addTsuusyokaigoDiscountContena();
    }
    return tsuusyokaigoDiscountContena;

  }

  /**
   * ���������擾���܂��B
   * @return ������
   */
  public ACTextField getTsuusyokaigoDiscountRate(){
    if(tsuusyokaigoDiscountRate==null){

      tsuusyokaigoDiscountRate = new ACTextField();

      tsuusyokaigoDiscountRate.setBindPath("REDUCT_RATE");

      tsuusyokaigoDiscountRate.setColumns(3);

      tsuusyokaigoDiscountRate.setCharType(VRCharType.ONLY_DIGIT);

      tsuusyokaigoDiscountRate.setHorizontalAlignment(SwingConstants.RIGHT);

      tsuusyokaigoDiscountRate.setIMEMode(InputSubset.LATIN);

      tsuusyokaigoDiscountRate.setMaxLength(3);

      addTsuusyokaigoDiscountRate();
    }
    return tsuusyokaigoDiscountRate;

  }

  /**
   * �����x�����擾���܂��B
   * @return �����x��
   */
  public ACLabel getTsuusyokaigotSign(){
    if(tsuusyokaigotSign==null){

      tsuusyokaigotSign = new ACLabel();

      tsuusyokaigotSign.setText("��");

      addTsuusyokaigotSign();
    }
    return tsuusyokaigotSign;

  }

  /**
   * �{�݋敪���W�I�O���[�v���擾���܂��B
   * @return �{�݋敪���W�I�O���[�v
   */
  public ACClearableRadioButtonGroup getTsuusyokaigoFacilitiesDivision(){
    if(tsuusyokaigoFacilitiesDivision==null){

      tsuusyokaigoFacilitiesDivision = new ACClearableRadioButtonGroup();

      getTsuusyokaigoFacilitiesDivisionContainer().setText("�{�݋敪");

      tsuusyokaigoFacilitiesDivision.setBindPath("1150101");

      tsuusyokaigoFacilitiesDivision.setModel(getTsuusyokaigoFacilitiesDivisionModel());

      tsuusyokaigoFacilitiesDivision.setUseClearButton(false);

      addTsuusyokaigoFacilitiesDivision();
    }
    return tsuusyokaigoFacilitiesDivision;

  }

  /**
   * �{�݋敪���W�I�O���[�v�R���e�i���擾���܂��B
   * @return �{�݋敪���W�I�O���[�v�R���e�i
   */
  protected ACLabelContainer getTsuusyokaigoFacilitiesDivisionContainer(){
    if(tsuusyokaigoFacilitiesDivisionContainer==null){
      tsuusyokaigoFacilitiesDivisionContainer = new ACLabelContainer();
      tsuusyokaigoFacilitiesDivisionContainer.setFollowChildEnabled(true);
      tsuusyokaigoFacilitiesDivisionContainer.add(getTsuusyokaigoFacilitiesDivision(), null);
    }
    return tsuusyokaigoFacilitiesDivisionContainer;
  }

  /**
   * �{�݋敪���W�I�O���[�v���f�����擾���܂��B
   * @return �{�݋敪���W�I�O���[�v���f��
   */
  protected ACListModelAdapter getTsuusyokaigoFacilitiesDivisionModel(){
    if(tsuusyokaigoFacilitiesDivisionModel==null){
      tsuusyokaigoFacilitiesDivisionModel = new ACListModelAdapter();
      addTsuusyokaigoFacilitiesDivisionModel();
    }
    return tsuusyokaigoFacilitiesDivisionModel;
  }

  /**
   * �P�ƌ^���擾���܂��B
   * @return �P�ƌ^
   */
  public ACRadioButtonItem getTsuusyokaigoSingle(){
    if(tsuusyokaigoSingle==null){

      tsuusyokaigoSingle = new ACRadioButtonItem();

      tsuusyokaigoSingle.setText("�P�ƌ^");

      tsuusyokaigoSingle.setGroup(getTsuusyokaigoFacilitiesDivision());

      addTsuusyokaigoSingle();
    }
    return tsuusyokaigoSingle;

  }

  /**
   * ���݌^���擾���܂��B
   * @return ���݌^
   */
  public ACRadioButtonItem getTsuusyokaigoDouble(){
    if(tsuusyokaigoDouble==null){

      tsuusyokaigoDouble = new ACRadioButtonItem();

      tsuusyokaigoDouble.setText("���݌^");

      tsuusyokaigoDouble.setGroup(getTsuusyokaigoFacilitiesDivision());

      addTsuusyokaigoDouble();
    }
    return tsuusyokaigoDouble;

  }

  /**
   * �F�m�ǐ�p�P�ƌ^���擾���܂��B
   * @return �F�m�ǐ�p�P�ƌ^
   */
  public ACRadioButtonItem getTsuusyokaigoDementiaSingle(){
    if(tsuusyokaigoDementiaSingle==null){

      tsuusyokaigoDementiaSingle = new ACRadioButtonItem();

      tsuusyokaigoDementiaSingle.setText("�F�m�ǐ�p�P�ƌ^");

      tsuusyokaigoDementiaSingle.setGroup(getTsuusyokaigoFacilitiesDivision());

      addTsuusyokaigoDementiaSingle();
    }
    return tsuusyokaigoDementiaSingle;

  }

  /**
   * �F�m�ǐ�p���݌^���擾���܂��B
   * @return �F�m�ǐ�p���݌^
   */
  public ACRadioButtonItem getTsuusyokaigoDementiaDouble(){
    if(tsuusyokaigoDementiaDouble==null){

      tsuusyokaigoDementiaDouble = new ACRadioButtonItem();

      tsuusyokaigoDementiaDouble.setText("�F�m�ǐ�p���݌^");

      tsuusyokaigoDementiaDouble.setGroup(getTsuusyokaigoFacilitiesDivision());

      addTsuusyokaigoDementiaDouble();
    }
    return tsuusyokaigoDementiaDouble;

  }

  /**
   * �@�\�P���w���̐����W�I�O���[�v���擾���܂��B
   * @return �@�\�P���w���̐����W�I�O���[�v
   */
  public ACClearableRadioButtonGroup getTsuusyokaigoFunctionTrainingGuidanceSystem(){
    if(tsuusyokaigoFunctionTrainingGuidanceSystem==null){

      tsuusyokaigoFunctionTrainingGuidanceSystem = new ACClearableRadioButtonGroup();

      getTsuusyokaigoFunctionTrainingGuidanceSystemContainer().setText("�@�\�P���w���̐�");

      tsuusyokaigoFunctionTrainingGuidanceSystem.setBindPath("1150102");

      tsuusyokaigoFunctionTrainingGuidanceSystem.setModel(getTsuusyokaigoFunctionTrainingGuidanceSystemModel());

      tsuusyokaigoFunctionTrainingGuidanceSystem.setUseClearButton(false);

      addTsuusyokaigoFunctionTrainingGuidanceSystem();
    }
    return tsuusyokaigoFunctionTrainingGuidanceSystem;

  }

  /**
   * �@�\�P���w���̐����W�I�O���[�v�R���e�i���擾���܂��B
   * @return �@�\�P���w���̐����W�I�O���[�v�R���e�i
   */
  protected ACLabelContainer getTsuusyokaigoFunctionTrainingGuidanceSystemContainer(){
    if(tsuusyokaigoFunctionTrainingGuidanceSystemContainer==null){
      tsuusyokaigoFunctionTrainingGuidanceSystemContainer = new ACLabelContainer();
      tsuusyokaigoFunctionTrainingGuidanceSystemContainer.setFollowChildEnabled(true);
      tsuusyokaigoFunctionTrainingGuidanceSystemContainer.add(getTsuusyokaigoFunctionTrainingGuidanceSystem(), null);
    }
    return tsuusyokaigoFunctionTrainingGuidanceSystemContainer;
  }

  /**
   * �@�\�P���w���̐����W�I�O���[�v���f�����擾���܂��B
   * @return �@�\�P���w���̐����W�I�O���[�v���f��
   */
  protected ACListModelAdapter getTsuusyokaigoFunctionTrainingGuidanceSystemModel(){
    if(tsuusyokaigoFunctionTrainingGuidanceSystemModel==null){
      tsuusyokaigoFunctionTrainingGuidanceSystemModel = new ACListModelAdapter();
      addTsuusyokaigoFunctionTrainingGuidanceSystemModel();
    }
    return tsuusyokaigoFunctionTrainingGuidanceSystemModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getTsuusyokaigoFunctionTrainingGuidanceSystemOff(){
    if(tsuusyokaigoFunctionTrainingGuidanceSystemOff==null){

      tsuusyokaigoFunctionTrainingGuidanceSystemOff = new ACRadioButtonItem();

      tsuusyokaigoFunctionTrainingGuidanceSystemOff.setText("�Ȃ�");

      tsuusyokaigoFunctionTrainingGuidanceSystemOff.setGroup(getTsuusyokaigoFunctionTrainingGuidanceSystem());

      addTsuusyokaigoFunctionTrainingGuidanceSystemOff();
    }
    return tsuusyokaigoFunctionTrainingGuidanceSystemOff;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getTsuusyokaigoFunctionTrainingGuidanceSystemOn(){
    if(tsuusyokaigoFunctionTrainingGuidanceSystemOn==null){

      tsuusyokaigoFunctionTrainingGuidanceSystemOn = new ACRadioButtonItem();

      tsuusyokaigoFunctionTrainingGuidanceSystemOn.setText("����");

      tsuusyokaigoFunctionTrainingGuidanceSystemOn.setGroup(getTsuusyokaigoFunctionTrainingGuidanceSystem());

      addTsuusyokaigoFunctionTrainingGuidanceSystemOn();
    }
    return tsuusyokaigoFunctionTrainingGuidanceSystemOn;

  }

  /**
   * ������̐����W�I�O���[�v���擾���܂��B
   * @return ������̐����W�I�O���[�v
   */
  public ACClearableRadioButtonGroup getTsuusyokaigoBathingHelpSystem(){
    if(tsuusyokaigoBathingHelpSystem==null){

      tsuusyokaigoBathingHelpSystem = new ACClearableRadioButtonGroup();

      getTsuusyokaigoBathingHelpSystemContainer().setText("������̐�");

      tsuusyokaigoBathingHelpSystem.setBindPath("1150103");

      tsuusyokaigoBathingHelpSystem.setModel(getTsuusyokaigoBathingHelpSystemModel());

      tsuusyokaigoBathingHelpSystem.setUseClearButton(false);

      addTsuusyokaigoBathingHelpSystem();
    }
    return tsuusyokaigoBathingHelpSystem;

  }

  /**
   * ������̐����W�I�O���[�v�R���e�i���擾���܂��B
   * @return ������̐����W�I�O���[�v�R���e�i
   */
  protected ACLabelContainer getTsuusyokaigoBathingHelpSystemContainer(){
    if(tsuusyokaigoBathingHelpSystemContainer==null){
      tsuusyokaigoBathingHelpSystemContainer = new ACLabelContainer();
      tsuusyokaigoBathingHelpSystemContainer.setFollowChildEnabled(true);
      tsuusyokaigoBathingHelpSystemContainer.add(getTsuusyokaigoBathingHelpSystem(), null);
    }
    return tsuusyokaigoBathingHelpSystemContainer;
  }

  /**
   * ������̐����W�I�O���[�v���f�����擾���܂��B
   * @return ������̐����W�I�O���[�v���f��
   */
  protected ACListModelAdapter getTsuusyokaigoBathingHelpSystemModel(){
    if(tsuusyokaigoBathingHelpSystemModel==null){
      tsuusyokaigoBathingHelpSystemModel = new ACListModelAdapter();
      addTsuusyokaigoBathingHelpSystemModel();
    }
    return tsuusyokaigoBathingHelpSystemModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getTsuusyokaigoBathingHelpSystemOff(){
    if(tsuusyokaigoBathingHelpSystemOff==null){

      tsuusyokaigoBathingHelpSystemOff = new ACRadioButtonItem();

      tsuusyokaigoBathingHelpSystemOff.setText("�Ȃ�");

      tsuusyokaigoBathingHelpSystemOff.setGroup(getTsuusyokaigoBathingHelpSystem());

      addTsuusyokaigoBathingHelpSystemOff();
    }
    return tsuusyokaigoBathingHelpSystemOff;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getTsuusyokaigoBathingHelpSystemOn(){
    if(tsuusyokaigoBathingHelpSystemOn==null){

      tsuusyokaigoBathingHelpSystemOn = new ACRadioButtonItem();

      tsuusyokaigoBathingHelpSystemOn.setText("����");

      tsuusyokaigoBathingHelpSystemOn.setGroup(getTsuusyokaigoBathingHelpSystem());

      addTsuusyokaigoBathingHelpSystemOn();
    }
    return tsuusyokaigoBathingHelpSystemOn;

  }

  /**
   * ���ʓ�����̐����W�I�O���[�v���擾���܂��B
   * @return ���ʓ�����̐����W�I�O���[�v
   */
  public ACClearableRadioButtonGroup getTsuusyokaigoSpecialBathingHelpSystem(){
    if(tsuusyokaigoSpecialBathingHelpSystem==null){

      tsuusyokaigoSpecialBathingHelpSystem = new ACClearableRadioButtonGroup();

      getTsuusyokaigoSpecialBathingHelpSystemContainer().setText("���ʓ�����̐�");

      tsuusyokaigoSpecialBathingHelpSystem.setBindPath("1150104");

      tsuusyokaigoSpecialBathingHelpSystem.setModel(getTsuusyokaigoSpecialBathingHelpSystemModel());

      tsuusyokaigoSpecialBathingHelpSystem.setUseClearButton(false);

      addTsuusyokaigoSpecialBathingHelpSystem();
    }
    return tsuusyokaigoSpecialBathingHelpSystem;

  }

  /**
   * ���ʓ�����̐����W�I�O���[�v�R���e�i���擾���܂��B
   * @return ���ʓ�����̐����W�I�O���[�v�R���e�i
   */
  protected ACLabelContainer getTsuusyokaigoSpecialBathingHelpSystemContainer(){
    if(tsuusyokaigoSpecialBathingHelpSystemContainer==null){
      tsuusyokaigoSpecialBathingHelpSystemContainer = new ACLabelContainer();
      tsuusyokaigoSpecialBathingHelpSystemContainer.setFollowChildEnabled(true);
      tsuusyokaigoSpecialBathingHelpSystemContainer.add(getTsuusyokaigoSpecialBathingHelpSystem(), null);
    }
    return tsuusyokaigoSpecialBathingHelpSystemContainer;
  }

  /**
   * ���ʓ�����̐����W�I�O���[�v���f�����擾���܂��B
   * @return ���ʓ�����̐����W�I�O���[�v���f��
   */
  protected ACListModelAdapter getTsuusyokaigoSpecialBathingHelpSystemModel(){
    if(tsuusyokaigoSpecialBathingHelpSystemModel==null){
      tsuusyokaigoSpecialBathingHelpSystemModel = new ACListModelAdapter();
      addTsuusyokaigoSpecialBathingHelpSystemModel();
    }
    return tsuusyokaigoSpecialBathingHelpSystemModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getTsuusyokaigoSpecialBathingHelpSystemOff(){
    if(tsuusyokaigoSpecialBathingHelpSystemOff==null){

      tsuusyokaigoSpecialBathingHelpSystemOff = new ACRadioButtonItem();

      tsuusyokaigoSpecialBathingHelpSystemOff.setText("�Ȃ�");

      tsuusyokaigoSpecialBathingHelpSystemOff.setGroup(getTsuusyokaigoSpecialBathingHelpSystem());

      addTsuusyokaigoSpecialBathingHelpSystemOff();
    }
    return tsuusyokaigoSpecialBathingHelpSystemOff;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getTsuusyokaigoSpecialBathingHelpSystemOn(){
    if(tsuusyokaigoSpecialBathingHelpSystemOn==null){

      tsuusyokaigoSpecialBathingHelpSystemOn = new ACRadioButtonItem();

      tsuusyokaigoSpecialBathingHelpSystemOn.setText("����");

      tsuusyokaigoSpecialBathingHelpSystemOn.setGroup(getTsuusyokaigoSpecialBathingHelpSystem());

      addTsuusyokaigoSpecialBathingHelpSystemOn();
    }
    return tsuusyokaigoSpecialBathingHelpSystemOn;

  }

  /**
   * ���}�̐����W�I�O���[�v���擾���܂��B
   * @return ���}�̐����W�I�O���[�v
   */
  public ACClearableRadioButtonGroup getTsuusyokaigoMeetingAndSendingOffSystem(){
    if(tsuusyokaigoMeetingAndSendingOffSystem==null){

      tsuusyokaigoMeetingAndSendingOffSystem = new ACClearableRadioButtonGroup();

      getTsuusyokaigoMeetingAndSendingOffSystemContainer().setText("���}�̐�");

      tsuusyokaigoMeetingAndSendingOffSystem.setBindPath("1150105");

      tsuusyokaigoMeetingAndSendingOffSystem.setModel(getTsuusyokaigoMeetingAndSendingOffSystemModel());

      tsuusyokaigoMeetingAndSendingOffSystem.setUseClearButton(false);

      addTsuusyokaigoMeetingAndSendingOffSystem();
    }
    return tsuusyokaigoMeetingAndSendingOffSystem;

  }

  /**
   * ���}�̐����W�I�O���[�v�R���e�i���擾���܂��B
   * @return ���}�̐����W�I�O���[�v�R���e�i
   */
  protected ACLabelContainer getTsuusyokaigoMeetingAndSendingOffSystemContainer(){
    if(tsuusyokaigoMeetingAndSendingOffSystemContainer==null){
      tsuusyokaigoMeetingAndSendingOffSystemContainer = new ACLabelContainer();
      tsuusyokaigoMeetingAndSendingOffSystemContainer.setFollowChildEnabled(true);
      tsuusyokaigoMeetingAndSendingOffSystemContainer.add(getTsuusyokaigoMeetingAndSendingOffSystem(), null);
    }
    return tsuusyokaigoMeetingAndSendingOffSystemContainer;
  }

  /**
   * ���}�̐����W�I�O���[�v���f�����擾���܂��B
   * @return ���}�̐����W�I�O���[�v���f��
   */
  protected ACListModelAdapter getTsuusyokaigoMeetingAndSendingOffSystemModel(){
    if(tsuusyokaigoMeetingAndSendingOffSystemModel==null){
      tsuusyokaigoMeetingAndSendingOffSystemModel = new ACListModelAdapter();
      addTsuusyokaigoMeetingAndSendingOffSystemModel();
    }
    return tsuusyokaigoMeetingAndSendingOffSystemModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getTsuusyokaigoMeetingAndSendingOffSystemOff(){
    if(tsuusyokaigoMeetingAndSendingOffSystemOff==null){

      tsuusyokaigoMeetingAndSendingOffSystemOff = new ACRadioButtonItem();

      tsuusyokaigoMeetingAndSendingOffSystemOff.setText("�Ȃ�");

      tsuusyokaigoMeetingAndSendingOffSystemOff.setGroup(getTsuusyokaigoMeetingAndSendingOffSystem());

      addTsuusyokaigoMeetingAndSendingOffSystemOff();
    }
    return tsuusyokaigoMeetingAndSendingOffSystemOff;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getTsuusyokaigoMeetingAndSendingOffSystemOn(){
    if(tsuusyokaigoMeetingAndSendingOffSystemOn==null){

      tsuusyokaigoMeetingAndSendingOffSystemOn = new ACRadioButtonItem();

      tsuusyokaigoMeetingAndSendingOffSystemOn.setText("����");

      tsuusyokaigoMeetingAndSendingOffSystemOn.setGroup(getTsuusyokaigoMeetingAndSendingOffSystem());

      addTsuusyokaigoMeetingAndSendingOffSystemOn();
    }
    return tsuusyokaigoMeetingAndSendingOffSystemOn;

  }

  /**
   * �l�����Z���W�I�O���[�v���擾���܂��B
   * @return �l�����Z���W�I�O���[�v
   */
  public ACClearableRadioButtonGroup getTsuusyokaigoStaffRadio(){
    if(tsuusyokaigoStaffRadio==null){

      tsuusyokaigoStaffRadio = new ACClearableRadioButtonGroup();

      getTsuusyokaigoStaffRadioContainer().setText("�l�����Z");

      tsuusyokaigoStaffRadio.setBindPath("1150106");

      tsuusyokaigoStaffRadio.setModel(getTsuusyokaigoStaffRadioModel());

      tsuusyokaigoStaffRadio.setUseClearButton(false);

      addTsuusyokaigoStaffRadio();
    }
    return tsuusyokaigoStaffRadio;

  }

  /**
   * �l�����Z���W�I�O���[�v�R���e�i���擾���܂��B
   * @return �l�����Z���W�I�O���[�v�R���e�i
   */
  protected ACLabelContainer getTsuusyokaigoStaffRadioContainer(){
    if(tsuusyokaigoStaffRadioContainer==null){
      tsuusyokaigoStaffRadioContainer = new ACLabelContainer();
      tsuusyokaigoStaffRadioContainer.setFollowChildEnabled(true);
      tsuusyokaigoStaffRadioContainer.add(getTsuusyokaigoStaffRadio(), null);
    }
    return tsuusyokaigoStaffRadioContainer;
  }

  /**
   * �l�����Z���W�I�O���[�v���f�����擾���܂��B
   * @return �l�����Z���W�I�O���[�v���f��
   */
  protected ACListModelAdapter getTsuusyokaigoStaffRadioModel(){
    if(tsuusyokaigoStaffRadioModel==null){
      tsuusyokaigoStaffRadioModel = new ACListModelAdapter();
      addTsuusyokaigoStaffRadioModel();
    }
    return tsuusyokaigoStaffRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getTsuusyokaigoStaffNot(){
    if(tsuusyokaigoStaffNot==null){

      tsuusyokaigoStaffNot = new ACRadioButtonItem();

      tsuusyokaigoStaffNot.setText("�Ȃ�");

      tsuusyokaigoStaffNot.setGroup(getTsuusyokaigoStaffRadio());

      addTsuusyokaigoStaffNot();
    }
    return tsuusyokaigoStaffNot;

  }

  /**
   * ������߂��擾���܂��B
   * @return �������
   */
  public ACRadioButtonItem getTsuusyokaigoStaffReduce(){
    if(tsuusyokaigoStaffReduce==null){

      tsuusyokaigoStaffReduce = new ACRadioButtonItem();

      tsuusyokaigoStaffReduce.setText("�������");

      tsuusyokaigoStaffReduce.setGroup(getTsuusyokaigoStaffRadio());

      addTsuusyokaigoStaffReduce();
    }
    return tsuusyokaigoStaffReduce;

  }

  /**
   * �Ō�A���E���̕s�����擾���܂��B
   * @return �Ō�A���E���̕s��
   */
  public ACRadioButtonItem getTsuusyokaigoStaffShortage(){
    if(tsuusyokaigoStaffShortage==null){

      tsuusyokaigoStaffShortage = new ACRadioButtonItem();

      tsuusyokaigoStaffShortage.setText("�Ō�E���E���̕s��");

      tsuusyokaigoStaffShortage.setGroup(getTsuusyokaigoStaffRadio());

      addTsuusyokaigoStaffShortage();
    }
    return tsuusyokaigoStaffShortage;

  }

  /**
   * �R���X�g���N�^�ł��B
   */
  public QO004005Design() {

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

    this.add(getTsuusyokaigoGroup(), VRLayout.CLIENT);

  }

  /**
   * ���ƃO���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTsuusyokaigoGroup(){

    tsuusyokaigoGroup.add(getTsuusyokaigoDiscountContena(), VRLayout.FLOW_INSETLINE_RETURN);

    tsuusyokaigoGroup.add(getTsuusyokaigoFacilitiesDivisionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tsuusyokaigoGroup.add(getTsuusyokaigoFunctionTrainingGuidanceSystemContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tsuusyokaigoGroup.add(getTsuusyokaigoBathingHelpSystemContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tsuusyokaigoGroup.add(getTsuusyokaigoSpecialBathingHelpSystemContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tsuusyokaigoGroup.add(getTsuusyokaigoMeetingAndSendingOffSystemContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tsuusyokaigoGroup.add(getTsuusyokaigoStaffRadioContainer(), VRLayout.FLOW_INSETLINE);

  }

  /**
   * �������R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTsuusyokaigoDiscountContena(){

    tsuusyokaigoDiscountContena.add(getTsuusyokaigoDiscountRate(), VRLayout.FLOW);

    tsuusyokaigoDiscountContena.add(getTsuusyokaigotSign(), VRLayout.FLOW);

  }

  /**
   * �������ɓ������ڂ�ǉ����܂��B
   */
  protected void addTsuusyokaigoDiscountRate(){

  }

  /**
   * �����x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addTsuusyokaigotSign(){

  }

  /**
   * �{�݋敪���W�I�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTsuusyokaigoFacilitiesDivision(){

  }

  /**
   * �{�݋敪���W�I�O���[�v���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addTsuusyokaigoFacilitiesDivisionModel(){

    getTsuusyokaigoSingle().setButtonIndex(1);
    getTsuusyokaigoFacilitiesDivisionModel().add(getTsuusyokaigoSingle());

    getTsuusyokaigoDouble().setButtonIndex(2);
    getTsuusyokaigoFacilitiesDivisionModel().add(getTsuusyokaigoDouble());

    getTsuusyokaigoDementiaSingle().setButtonIndex(3);
    getTsuusyokaigoFacilitiesDivisionModel().add(getTsuusyokaigoDementiaSingle());

    getTsuusyokaigoDementiaDouble().setButtonIndex(4);
    getTsuusyokaigoFacilitiesDivisionModel().add(getTsuusyokaigoDementiaDouble());

  }

  /**
   * �P�ƌ^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTsuusyokaigoSingle(){

  }

  /**
   * ���݌^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTsuusyokaigoDouble(){

  }

  /**
   * �F�m�ǐ�p�P�ƌ^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTsuusyokaigoDementiaSingle(){

  }

  /**
   * �F�m�ǐ�p���݌^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTsuusyokaigoDementiaDouble(){

  }

  /**
   * �@�\�P���w���̐����W�I�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTsuusyokaigoFunctionTrainingGuidanceSystem(){

  }

  /**
   * �@�\�P���w���̐����W�I�O���[�v���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addTsuusyokaigoFunctionTrainingGuidanceSystemModel(){

    getTsuusyokaigoFunctionTrainingGuidanceSystemOff().setButtonIndex(1);
    getTsuusyokaigoFunctionTrainingGuidanceSystemModel().add(getTsuusyokaigoFunctionTrainingGuidanceSystemOff());

    getTsuusyokaigoFunctionTrainingGuidanceSystemOn().setButtonIndex(2);
    getTsuusyokaigoFunctionTrainingGuidanceSystemModel().add(getTsuusyokaigoFunctionTrainingGuidanceSystemOn());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addTsuusyokaigoFunctionTrainingGuidanceSystemOff(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addTsuusyokaigoFunctionTrainingGuidanceSystemOn(){

  }

  /**
   * ������̐����W�I�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTsuusyokaigoBathingHelpSystem(){

  }

  /**
   * ������̐����W�I�O���[�v���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addTsuusyokaigoBathingHelpSystemModel(){

    getTsuusyokaigoBathingHelpSystemOff().setButtonIndex(1);
    getTsuusyokaigoBathingHelpSystemModel().add(getTsuusyokaigoBathingHelpSystemOff());

    getTsuusyokaigoBathingHelpSystemOn().setButtonIndex(2);
    getTsuusyokaigoBathingHelpSystemModel().add(getTsuusyokaigoBathingHelpSystemOn());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addTsuusyokaigoBathingHelpSystemOff(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addTsuusyokaigoBathingHelpSystemOn(){

  }

  /**
   * ���ʓ�����̐����W�I�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTsuusyokaigoSpecialBathingHelpSystem(){

  }

  /**
   * ���ʓ�����̐����W�I�O���[�v���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addTsuusyokaigoSpecialBathingHelpSystemModel(){

    getTsuusyokaigoSpecialBathingHelpSystemOff().setButtonIndex(1);
    getTsuusyokaigoSpecialBathingHelpSystemModel().add(getTsuusyokaigoSpecialBathingHelpSystemOff());

    getTsuusyokaigoSpecialBathingHelpSystemOn().setButtonIndex(2);
    getTsuusyokaigoSpecialBathingHelpSystemModel().add(getTsuusyokaigoSpecialBathingHelpSystemOn());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addTsuusyokaigoSpecialBathingHelpSystemOff(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addTsuusyokaigoSpecialBathingHelpSystemOn(){

  }

  /**
   * ���}�̐����W�I�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTsuusyokaigoMeetingAndSendingOffSystem(){

  }

  /**
   * ���}�̐����W�I�O���[�v���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addTsuusyokaigoMeetingAndSendingOffSystemModel(){

    getTsuusyokaigoMeetingAndSendingOffSystemOff().setButtonIndex(1);
    getTsuusyokaigoMeetingAndSendingOffSystemModel().add(getTsuusyokaigoMeetingAndSendingOffSystemOff());

    getTsuusyokaigoMeetingAndSendingOffSystemOn().setButtonIndex(2);
    getTsuusyokaigoMeetingAndSendingOffSystemModel().add(getTsuusyokaigoMeetingAndSendingOffSystemOn());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addTsuusyokaigoMeetingAndSendingOffSystemOff(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addTsuusyokaigoMeetingAndSendingOffSystemOn(){

  }

  /**
   * �l�����Z���W�I�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTsuusyokaigoStaffRadio(){

  }

  /**
   * �l�����Z���W�I�O���[�v���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addTsuusyokaigoStaffRadioModel(){

    getTsuusyokaigoStaffNot().setButtonIndex(1);
    getTsuusyokaigoStaffRadioModel().add(getTsuusyokaigoStaffNot());

    getTsuusyokaigoStaffReduce().setButtonIndex(2);
    getTsuusyokaigoStaffRadioModel().add(getTsuusyokaigoStaffReduce());

    getTsuusyokaigoStaffShortage().setButtonIndex(3);
    getTsuusyokaigoStaffRadioModel().add(getTsuusyokaigoStaffShortage());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addTsuusyokaigoStaffNot(){

  }

  /**
   * ������߂ɓ������ڂ�ǉ����܂��B
   */
  protected void addTsuusyokaigoStaffReduce(){

  }

  /**
   * �Ō�A���E���̕s���ɓ������ڂ�ǉ����܂��B
   */
  protected void addTsuusyokaigoStaffShortage(){

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
      ACFrame.getInstance().getContentPane().add(new QO004005Design());
      ACFrame.getInstance().setVisible(true);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QO004005Design getThis() {
    return this;
  }
}
