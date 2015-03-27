
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
 * �J����: �� ����
 * �쐬��: 2006/09/01  ���{�R���s���[�^�[������� �� ���� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���[�Ǘ� (C)
 * �v���Z�X �K��Ō�񍐏� (002)
 * �v���O���� �K��Ō�񍐏� (QC002)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qc.qc002;
import java.awt.Color;
import java.awt.Component;
import java.awt.im.InputSubset;

import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;

import jp.nichicom.ac.ACConstants;
import jp.nichicom.ac.component.ACAffairButton;
import jp.nichicom.ac.component.ACAffairButtonBar;
import jp.nichicom.ac.component.ACButton;
import jp.nichicom.ac.component.ACComboBox;
import jp.nichicom.ac.component.ACLabel;
import jp.nichicom.ac.component.ACRadioButtonItem;
import jp.nichicom.ac.component.ACTextArea;
import jp.nichicom.ac.component.ACTextField;
import jp.nichicom.ac.component.ACValueArrayRadioButtonGroup;
import jp.nichicom.ac.container.ACGroupBox;
import jp.nichicom.ac.container.ACLabelContainer;
import jp.nichicom.ac.container.ACPanel;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACAffairable;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.util.adapter.ACComboBoxModelAdapter;
import jp.nichicom.ac.util.adapter.ACListModelAdapter;
import jp.nichicom.vr.layout.VRLayout;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanConstants;
import jp.or.med.orca.qkan.affair.QkanAffairContainer;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.component.QkanDateTextField;
/**
 * �K��Ō�񍐏���ʍ��ڃf�U�C��(QC002) 
 */
@SuppressWarnings("serial")
public class QC002Design extends QkanAffairContainer implements ACAffairable {
  //GUI�R���|�[�l���g

  private ACAffairButtonBar buttons;

  private ACAffairButton open;

  private ACAffairButton insert;

  private ACAffairButton update;

  private ACAffairButton print;

  private ACPanel contents;

  private ACPanel targetDates;

  private ACLabel targetDateCaption;

  private ACLabel targetDate;

  private ACPanel infos;

  private ACGroupBox patients;

  private ACTextField patientName;

  private ACLabelContainer patientNameContainer;

  private ACLabelContainer patientBirthContainer;

  private QkanDateTextField patientBirth;

  private ACTextField patientAge;

  private ACLabel patientAgeLabel;

  private ACValueArrayRadioButtonGroup yokaigodo;

  private ACLabelContainer yokaigodoContainer;

  private ACListModelAdapter yokaigodoModel;

  private ACRadioButtonItem yokaigodoRadio1;

  private ACRadioButtonItem yokaigodoRadio2;

  private ACRadioButtonItem yokaigodoRadio3;

  private ACRadioButtonItem yokaigodoRadio4;

  private ACRadioButtonItem yokaigodoRadio5;

  private ACRadioButtonItem yokaigodoRadio6;

  private ACRadioButtonItem yokaigodoRadio7;

  private ACRadioButtonItem yokaigodoRadio8;

  private ACRadioButtonItem yokaigodoRadio9;

  private ACTextField patientAddress;

  private ACLabelContainer patientAddressContainer;

  private ACTextField doctorName;

  private ACLabelContainer doctorNameContainer;

  private ACGroupBox stations;

  private QkanDateTextField createDate;

  private ACLabelContainer createDateContainer;

  private ACComboBox providerName;

  private ACLabelContainer providerNameContainer;

  private ACComboBoxModelAdapter providerNameModel;

  private ACTextField administratorName;

  private ACLabelContainer administratorNameContainer;

  private JTabbedPane tabs;

  private ACPanel tabVisitDate;

  private ACGroupBox visitDates;

  private ACPanel calendars;

  private ACLabelContainer calendarLefts;

  private ACPanel calendarLeftYearMonths;

  private VRLayout calendarLeftYearMonthsLayout;

  private ACLabel calendarLeftCaption;

  private ACLabel calendarLeftYear;

  private ACLabel calendarLeftYearCaption;

  private ACLabel calendarLeftMonth;

  private ACLabel calendarLeftMonthCaption;

  private ACPanel calendarLeftDayContainer;

  private ACComboBox calendarLeftDay01;

  private ACComboBoxModelAdapter calendarLeftDay01Model;

  private ACComboBox calendarLeftDay02;

  private ACComboBoxModelAdapter calendarLeftDay02Model;

  private ACComboBox calendarLeftDay03;

  private ACComboBoxModelAdapter calendarLeftDay03Model;

  private ACComboBox calendarLeftDay04;

  private ACComboBoxModelAdapter calendarLeftDay04Model;

  private ACComboBox calendarLeftDay05;

  private ACComboBoxModelAdapter calendarLeftDay05Model;

  private ACComboBox calendarLeftDay06;

  private ACComboBoxModelAdapter calendarLeftDay06Model;

  private ACComboBox calendarLeftDay07;

  private ACComboBoxModelAdapter calendarLeftDay07Model;

  private ACComboBox calendarLeftDay08;

  private ACComboBoxModelAdapter calendarLeftDay08Model;

  private ACComboBox calendarLeftDay09;

  private ACComboBoxModelAdapter calendarLeftDay09Model;

  private ACComboBox calendarLeftDay10;

  private ACComboBoxModelAdapter calendarLeftDay10Model;

  private ACComboBox calendarLeftDay11;

  private ACComboBoxModelAdapter calendarLeftDay11Model;

  private ACComboBox calendarLeftDay12;

  private ACComboBoxModelAdapter calendarLeftDay12Model;

  private ACComboBox calendarLeftDay13;

  private ACComboBoxModelAdapter calendarLeftDay13Model;

  private ACComboBox calendarLeftDay14;

  private ACComboBoxModelAdapter calendarLeftDay14Model;

  private ACComboBox calendarLeftDay15;

  private ACComboBoxModelAdapter calendarLeftDay15Model;

  private ACComboBox calendarLeftDay16;

  private ACComboBoxModelAdapter calendarLeftDay16Model;

  private ACComboBox calendarLeftDay17;

  private ACComboBoxModelAdapter calendarLeftDay17Model;

  private ACComboBox calendarLeftDay18;

  private ACComboBoxModelAdapter calendarLeftDay18Model;

  private ACComboBox calendarLeftDay19;

  private ACComboBoxModelAdapter calendarLeftDay19Model;

  private ACComboBox calendarLeftDay20;

  private ACComboBoxModelAdapter calendarLeftDay20Model;

  private ACComboBox calendarLeftDay21;

  private ACComboBoxModelAdapter calendarLeftDay21Model;

  private ACComboBox calendarLeftDay22;

  private ACComboBoxModelAdapter calendarLeftDay22Model;

  private ACComboBox calendarLeftDay23;

  private ACComboBoxModelAdapter calendarLeftDay23Model;

  private ACComboBox calendarLeftDay24;

  private ACComboBoxModelAdapter calendarLeftDay24Model;

  private ACComboBox calendarLeftDay25;

  private ACComboBoxModelAdapter calendarLeftDay25Model;

  private ACComboBox calendarLeftDay26;

  private ACComboBoxModelAdapter calendarLeftDay26Model;

  private ACComboBox calendarLeftDay27;

  private ACComboBoxModelAdapter calendarLeftDay27Model;

  private ACComboBox calendarLeftDay28;

  private ACComboBoxModelAdapter calendarLeftDay28Model;

  private ACPanel calendarLeftDay29Panel;

  private ACLabel calendarLeftDay29Label;

  private ACComboBox calendarLeftDay29;

  private ACComboBoxModelAdapter calendarLeftDay29Model;

  private ACPanel calendarLeftDay30Panel;

  private ACLabel calendarLeftDay30Label;

  private ACComboBox calendarLeftDay30;

  private ACComboBoxModelAdapter calendarLeftDay30Model;

  private ACPanel calendarLeftDay31Panel;

  private ACLabel calendarLeftDay31Label;

  private ACComboBox calendarLeftDay31;

  private ACComboBoxModelAdapter calendarLeftDay31Model;

  private ACLabelContainer calendarRights;

  private ACPanel calendarRightYearMonths;

  private VRLayout calendarRightYearMonthsLayout;

  private ACLabel calendarRightCaption;

  private ACLabel calendarRightYear;

  private ACLabel calendarRightYearCaption;

  private ACLabel calendarRightMonth;

  private ACLabel calendarRightMonthCaption;

  private ACPanel calendarRightDayContainer;

  private ACComboBox calendarRightDay01;

  private ACComboBoxModelAdapter calendarRightDay01Model;

  private ACComboBox calendarRightDay02;

  private ACComboBoxModelAdapter calendarRightDay02Model;

  private ACComboBox calendarRightDay03;

  private ACComboBoxModelAdapter calendarRightDay03Model;

  private ACComboBox calendarRightDay04;

  private ACComboBoxModelAdapter calendarRightDay04Model;

  private ACComboBox calendarRightDay05;

  private ACComboBoxModelAdapter calendarRightDay05Model;

  private ACComboBox calendarRightDay06;

  private ACComboBoxModelAdapter calendarRightDay06Model;

  private ACComboBox calendarRightDay07;

  private ACComboBoxModelAdapter calendarRightDay07Model;

  private ACComboBox calendarRightDay08;

  private ACComboBoxModelAdapter calendarRightDay08Model;

  private ACComboBox calendarRightDay09;

  private ACComboBoxModelAdapter calendarRightDay09Model;

  private ACComboBox calendarRightDay10;

  private ACComboBoxModelAdapter calendarRightDay10Model;

  private ACComboBox calendarRightDay11;

  private ACComboBoxModelAdapter calendarRightDay11Model;

  private ACComboBox calendarRightDay12;

  private ACComboBoxModelAdapter calendarRightDay12Model;

  private ACComboBox calendarRightDay13;

  private ACComboBoxModelAdapter calendarRightDay13Model;

  private ACComboBox calendarRightDay14;

  private ACComboBoxModelAdapter calendarRightDay14Model;

  private ACComboBox calendarRightDay15;

  private ACComboBoxModelAdapter calendarRightDay15Model;

  private ACComboBox calendarRightDay16;

  private ACComboBoxModelAdapter calendarRightDay16Model;

  private ACComboBox calendarRightDay17;

  private ACComboBoxModelAdapter calendarRightDay17Model;

  private ACComboBox calendarRightDay18;

  private ACComboBoxModelAdapter calendarRightDay18Model;

  private ACComboBox calendarRightDay19;

  private ACComboBoxModelAdapter calendarRightDay19Model;

  private ACComboBox calendarRightDay20;

  private ACComboBoxModelAdapter calendarRightDay20Model;

  private ACComboBox calendarRightDay21;

  private ACComboBoxModelAdapter calendarRightDay21Model;

  private ACComboBox calendarRightDay22;

  private ACComboBoxModelAdapter calendarRightDay22Model;

  private ACComboBox calendarRightDay23;

  private ACComboBoxModelAdapter calendarRightDay23Model;

  private ACComboBox calendarRightDay24;

  private ACComboBoxModelAdapter calendarRightDay24Model;

  private ACComboBox calendarRightDay25;

  private ACComboBoxModelAdapter calendarRightDay25Model;

  private ACComboBox calendarRightDay26;

  private ACComboBoxModelAdapter calendarRightDay26Model;

  private ACComboBox calendarRightDay27;

  private ACComboBoxModelAdapter calendarRightDay27Model;

  private ACComboBox calendarRightDay28;

  private ACComboBoxModelAdapter calendarRightDay28Model;

  private ACPanel calendarRightDay29Panel;

  private ACLabel calendarRightDay29Label;

  private ACComboBox calendarRightDay29;

  private ACComboBoxModelAdapter calendarRightDay29Model;

  private ACPanel calendarRightDay30Panel;

  private ACLabel calendarRightDay30Label;

  private ACComboBox calendarRightDay30;

  private ACComboBoxModelAdapter calendarRightDay30Model;

  private ACPanel calendarRightDay31Panel;

  private ACLabel calendarRightDay31Label;

  private ACComboBox calendarRightDay31;

  private ACComboBoxModelAdapter calendarRightDay31Model;

  private ACPanel resultButtonPanel;

  private ACPanel resultButtonPanelLeft;

  private ACButton resultReadButtonLeft;

  private ACPanel resultButtonPanelRight;

  private ACButton resultReadButtonRight;

  private ACPanel memos;

  private ACLabel memo1;

  private ACLabel memo6;

  private ACLabel memo2;

  private ACLabel memo3;

  private ACLabel memo4;

  private ACLabel memo5;

  private ACPanel tabsComments1;

  private ACGroupBox byojos;

  private ACPanel byojoPnls;

  private ACTextArea byojoComments;

  private ACLabelContainer byojoCommentsContainer;

  private ACGroupBox kangoRehas;

  private ACPanel kangoRehaPnls;

  private ACTextArea kangoRehaComments;

  private ACLabelContainer kangoRehaCommentsContainer;

  private ACPanel tabsComments2;

  private ACGroupBox ryoyoStates;

  private ACPanel ryoyoStatePnls;

  private ACTextArea ryoyoStateComments;

  private ACLabelContainer ryoyoStateCommentsContainer;

  private ACGroupBox specials;

  private ACPanel specialPnls;

  private ACTextArea specialComments;

  private ACLabelContainer specialCommentsContainer;

  //getter

  /**
   * �{�^���o�[���擾���܂��B
   * @return �{�^���o�[
   */
  public ACAffairButtonBar getButtons(){
    if(buttons==null){

      buttons = new ACAffairButtonBar();

      buttons.setText("�K��Ō�񍐏�");

      addButtons();
    }
    return buttons;

  }

  /**
   * �O��Ǎ����擾���܂��B
   * @return �O��Ǎ�
   */
  public ACAffairButton getOpen(){
    if(open==null){

      open = new ACAffairButton();

      open.setText("�O��Ǎ�(O)");

      open.setToolTipText("�ߋ��̃f�[�^�̒��ŁA�ŐV�̃f�[�^�������p���܂��B");

      open.setMnemonic('O');

      open.setIconPath(ACConstants.ICON_PATH_OPEN_24);

      addOpen();
    }
    return open;

  }

  /**
   * �o�^���擾���܂��B
   * @return �o�^
   */
  public ACAffairButton getInsert(){
    if(insert==null){

      insert = new ACAffairButton();

      insert.setText("�o�^(S)");

      insert.setToolTipText("���݂̓��e��o�^���܂��B");

      insert.setMnemonic('S');

      insert.setIconPath(ACConstants.ICON_PATH_UPDATE_24);

      addInsert();
    }
    return insert;

  }

  /**
   * �X�V���擾���܂��B
   * @return �X�V
   */
  public ACAffairButton getUpdate(){
    if(update==null){

      update = new ACAffairButton();

      update.setText("�X�V(S)");

      update.setToolTipText("���݂̓��e���X�V���܂��B");

      update.setMnemonic('S');

      update.setIconPath(ACConstants.ICON_PATH_UPDATE_24);

      addUpdate();
    }
    return update;

  }

  /**
   * ������擾���܂��B
   * @return ���
   */
  public ACAffairButton getPrint(){
    if(print==null){

      print = new ACAffairButton();

      print.setText("���(P)");

      print.setToolTipText("�u�K��Ō�񍐏��v��������܂��B");

      print.setMnemonic('P');

      print.setIconPath(ACConstants.ICON_PATH_PRINT_24);

      addPrint();
    }
    return print;

  }

  /**
   * �N���C�A���g�̈���擾���܂��B
   * @return �N���C�A���g�̈�
   */
  public ACPanel getContents(){
    if(contents==null){

      contents = new ACPanel();

      addContents();
    }
    return contents;

  }

  /**
   * �Ώ۔N���̈���擾���܂��B
   * @return �Ώ۔N���̈�
   */
  public ACPanel getTargetDates(){
    if(targetDates==null){

      targetDates = new ACPanel();

      addTargetDates();
    }
    return targetDates;

  }

  /**
   * �Ώ۔N���L���v�V�������擾���܂��B
   * @return �Ώ۔N���L���v�V����
   */
  public ACLabel getTargetDateCaption(){
    if(targetDateCaption==null){

      targetDateCaption = new ACLabel();

      targetDateCaption.setText("�Ώ۔N���F");

      targetDateCaption.setForeground(Color.blue);

      addTargetDateCaption();
    }
    return targetDateCaption;

  }

  /**
   * �Ώ۔N�����擾���܂��B
   * @return �Ώ۔N��
   */
  public ACLabel getTargetDate(){
    if(targetDate==null){

      targetDate = new ACLabel();

      targetDate.setForeground(Color.blue);

      addTargetDate();
    }
    return targetDate;

  }

  /**
   * ���̈���擾���܂��B
   * @return ���̈�
   */
  public ACPanel getInfos(){
    if(infos==null){

      infos = new ACPanel();

      addInfos();
    }
    return infos;

  }

  /**
   * ���p�ҏ��̈���擾���܂��B
   * @return ���p�ҏ��̈�
   */
  public ACGroupBox getPatients(){
    if(patients==null){

      patients = new ACGroupBox();

      patients.setText("���p��");

      addPatients();
    }
    return patients;

  }

  /**
   * �������擾���܂��B
   * @return ����
   */
  public ACTextField getPatientName(){
    if(patientName==null){

      patientName = new ACTextField();

      getPatientNameContainer().setText("����");

      patientName.setBindPath("PATIENT_NAME");

      patientName.setEditable(false);

      patientName.setColumns(26);

      patientName.setIMEMode(InputSubset.KANJI);

      patientName.setMaxLength(26);

      addPatientName();
    }
    return patientName;

  }

  /**
   * �����R���e�i���擾���܂��B
   * @return �����R���e�i
   */
  protected ACLabelContainer getPatientNameContainer(){
    if(patientNameContainer==null){
      patientNameContainer = new ACLabelContainer();
      patientNameContainer.setFollowChildEnabled(true);
      patientNameContainer.setVAlignment(VRLayout.CENTER);
      patientNameContainer.add(getPatientName(), null);
    }
    return patientNameContainer;
  }

  /**
   * ���N�����R���e�i���擾���܂��B
   * @return ���N�����R���e�i
   */
  public ACLabelContainer getPatientBirthContainer(){
    if(patientBirthContainer==null){

      patientBirthContainer = new ACLabelContainer();

      patientBirthContainer.setText("���N����");

      addPatientBirthContainer();
    }
    return patientBirthContainer;

  }

  /**
   * ���N�������擾���܂��B
   * @return ���N����
   */
  public QkanDateTextField getPatientBirth(){
    if(patientBirth==null){

      patientBirth = new QkanDateTextField();

      patientBirth.setBindPath("PATIENT_BIRTHDAY");

      patientBirth.setEditable(false);

      patientBirth.setColumns(9);

      addPatientBirth();
    }
    return patientBirth;

  }

  /**
   * �N����擾���܂��B
   * @return �N��
   */
  public ACTextField getPatientAge(){
    if(patientAge==null){

      patientAge = new ACTextField();

      patientAge.setBindPath("PATIENT_BIRTHDAY");

      patientAge.setEditable(false);

      patientAge.setFormat(QkanConstants.FORMAT_NOW_AGE);

      patientAge.setMaxLength(3);

      addPatientAge();
    }
    return patientAge;

  }

  /**
   * �΂��擾���܂��B
   * @return ��
   */
  public ACLabel getPatientAgeLabel(){
    if(patientAgeLabel==null){

      patientAgeLabel = new ACLabel();

      patientAgeLabel.setText("��");

      addPatientAgeLabel();
    }
    return patientAgeLabel;

  }

  /**
   * �v���F����擾���܂��B
   * @return �v���F��
   */
  public ACValueArrayRadioButtonGroup getYokaigodo(){
    if(yokaigodo==null){

      yokaigodo = new ACValueArrayRadioButtonGroup();

      getYokaigodoContainer().setText("�v���F��");

      yokaigodo.setBindPath("JOTAI_CODE");

      yokaigodo.setUseClearButton(false);

      yokaigodo.setModel(getYokaigodoModel());

      yokaigodo.setValues(new int[]{1,12,13,11,21,22,23,24,25});

      addYokaigodo();
    }
    return yokaigodo;

  }

  /**
   * �v���F��R���e�i���擾���܂��B
   * @return �v���F��R���e�i
   */
  protected ACLabelContainer getYokaigodoContainer(){
    if(yokaigodoContainer==null){
      yokaigodoContainer = new ACLabelContainer();
      yokaigodoContainer.setFollowChildEnabled(true);
      yokaigodoContainer.setVAlignment(VRLayout.CENTER);
      yokaigodoContainer.add(getYokaigodo(), null);
    }
    return yokaigodoContainer;
  }

  /**
   * �v���F�胂�f�����擾���܂��B
   * @return �v���F�胂�f��
   */
  protected ACListModelAdapter getYokaigodoModel(){
    if(yokaigodoModel==null){
      yokaigodoModel = new ACListModelAdapter();
      addYokaigodoModel();
    }
    return yokaigodoModel;
  }

  /**
   * �������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getYokaigodoRadio1(){
    if(yokaigodoRadio1==null){

      yokaigodoRadio1 = new ACRadioButtonItem();

      yokaigodoRadio1.setText("����");

      yokaigodoRadio1.setGroup(getYokaigodo());

      yokaigodoRadio1.setConstraints(VRLayout.FLOW);

      addYokaigodoRadio1();
    }
    return yokaigodoRadio1;

  }

  /**
   * �v�x��1���擾���܂��B
   * @return �v�x��1
   */
  public ACRadioButtonItem getYokaigodoRadio2(){
    if(yokaigodoRadio2==null){

      yokaigodoRadio2 = new ACRadioButtonItem();

      yokaigodoRadio2.setText("�v�x��1");

      yokaigodoRadio2.setGroup(getYokaigodo());

      yokaigodoRadio2.setConstraints(VRLayout.FLOW);

      addYokaigodoRadio2();
    }
    return yokaigodoRadio2;

  }

  /**
   * �v�x��2���擾���܂��B
   * @return �v�x��2
   */
  public ACRadioButtonItem getYokaigodoRadio3(){
    if(yokaigodoRadio3==null){

      yokaigodoRadio3 = new ACRadioButtonItem();

      yokaigodoRadio3.setText("�v�x��2");

      yokaigodoRadio3.setGroup(getYokaigodo());

      yokaigodoRadio3.setConstraints(VRLayout.FLOW_RETURN);

      addYokaigodoRadio3();
    }
    return yokaigodoRadio3;

  }

  /**
   * �o�ߓI�v�����擾���܂��B
   * @return �o�ߓI�v���
   */
  public ACRadioButtonItem getYokaigodoRadio4(){
    if(yokaigodoRadio4==null){

      yokaigodoRadio4 = new ACRadioButtonItem();

      yokaigodoRadio4.setText("�o�ߓI�v���");

      yokaigodoRadio4.setGroup(getYokaigodo());

      yokaigodoRadio4.setConstraints(VRLayout.FLOW);

      addYokaigodoRadio4();
    }
    return yokaigodoRadio4;

  }

  /**
   * �v���1���擾���܂��B
   * @return �v���1
   */
  public ACRadioButtonItem getYokaigodoRadio5(){
    if(yokaigodoRadio5==null){

      yokaigodoRadio5 = new ACRadioButtonItem();

      yokaigodoRadio5.setText("�v���1");

      yokaigodoRadio5.setGroup(getYokaigodo());

      yokaigodoRadio5.setConstraints(VRLayout.FLOW);

      addYokaigodoRadio5();
    }
    return yokaigodoRadio5;

  }

  /**
   * �v���2���擾���܂��B
   * @return �v���2
   */
  public ACRadioButtonItem getYokaigodoRadio6(){
    if(yokaigodoRadio6==null){

      yokaigodoRadio6 = new ACRadioButtonItem();

      yokaigodoRadio6.setText("�v���2");

      yokaigodoRadio6.setGroup(getYokaigodo());

      yokaigodoRadio6.setConstraints(VRLayout.FLOW);

      addYokaigodoRadio6();
    }
    return yokaigodoRadio6;

  }

  /**
   * �v���3���擾���܂��B
   * @return �v���3
   */
  public ACRadioButtonItem getYokaigodoRadio7(){
    if(yokaigodoRadio7==null){

      yokaigodoRadio7 = new ACRadioButtonItem();

      yokaigodoRadio7.setText("�v���3");

      yokaigodoRadio7.setGroup(getYokaigodo());

      yokaigodoRadio7.setConstraints(VRLayout.FLOW);

      addYokaigodoRadio7();
    }
    return yokaigodoRadio7;

  }

  /**
   * �v���4���擾���܂��B
   * @return �v���4
   */
  public ACRadioButtonItem getYokaigodoRadio8(){
    if(yokaigodoRadio8==null){

      yokaigodoRadio8 = new ACRadioButtonItem();

      yokaigodoRadio8.setText("�v���4");

      yokaigodoRadio8.setGroup(getYokaigodo());

      yokaigodoRadio8.setConstraints(VRLayout.FLOW);

      addYokaigodoRadio8();
    }
    return yokaigodoRadio8;

  }

  /**
   * �v���5���擾���܂��B
   * @return �v���5
   */
  public ACRadioButtonItem getYokaigodoRadio9(){
    if(yokaigodoRadio9==null){

      yokaigodoRadio9 = new ACRadioButtonItem();

      yokaigodoRadio9.setText("�v���5");

      yokaigodoRadio9.setGroup(getYokaigodo());

      yokaigodoRadio9.setConstraints(VRLayout.FLOW);

      addYokaigodoRadio9();
    }
    return yokaigodoRadio9;

  }

  /**
   * �Z�����擾���܂��B
   * @return �Z��
   */
  public ACTextField getPatientAddress(){
    if(patientAddress==null){

      patientAddress = new ACTextField();

      getPatientAddressContainer().setText("�Z��");

      patientAddress.setBindPath("PATIENT_ADDRESS");

      patientAddress.setEditable(false);

      patientAddress.setColumns(40);

      patientAddress.setIMEMode(InputSubset.KANJI);

      patientAddress.setMaxLength(40);

      addPatientAddress();
    }
    return patientAddress;

  }

  /**
   * �Z���R���e�i���擾���܂��B
   * @return �Z���R���e�i
   */
  protected ACLabelContainer getPatientAddressContainer(){
    if(patientAddressContainer==null){
      patientAddressContainer = new ACLabelContainer();
      patientAddressContainer.setFollowChildEnabled(true);
      patientAddressContainer.setVAlignment(VRLayout.CENTER);
      patientAddressContainer.add(getPatientAddress(), null);
    }
    return patientAddressContainer;
  }

  /**
   * �厡�㎁�����擾���܂��B
   * @return �厡�㎁��
   */
  public ACTextField getDoctorName(){
    if(doctorName==null){

      doctorName = new ACTextField();

      getDoctorNameContainer().setText("�厡�㎁��");

      doctorName.setBindPath("DOCTOR_NAME");

      doctorName.setColumns(22);

      doctorName.setIMEMode(InputSubset.KANJI);

      doctorName.setMaxLength(22);

      addDoctorName();
    }
    return doctorName;

  }

  /**
   * �厡�㎁���R���e�i���擾���܂��B
   * @return �厡�㎁���R���e�i
   */
  protected ACLabelContainer getDoctorNameContainer(){
    if(doctorNameContainer==null){
      doctorNameContainer = new ACLabelContainer();
      doctorNameContainer.setFollowChildEnabled(true);
      doctorNameContainer.setVAlignment(VRLayout.CENTER);
      doctorNameContainer.add(getDoctorName(), null);
    }
    return doctorNameContainer;
  }

  /**
   * �X�e�[�V�������̈���擾���܂��B
   * @return �X�e�[�V�������̈�
   */
  public ACGroupBox getStations(){
    if(stations==null){

      stations = new ACGroupBox();

      stations.setText("�X�e�[�V��������");

      stations.setHgrid(300);

      addStations();
    }
    return stations;

  }

  /**
   * �쐬�N�������擾���܂��B
   * @return �쐬�N����
   */
  public QkanDateTextField getCreateDate(){
    if(createDate==null){

      createDate = new QkanDateTextField();

      getCreateDateContainer().setText("�쐬�N����");

      createDate.setBindPath("CREATE_DATE");

      addCreateDate();
    }
    return createDate;

  }

  /**
   * �쐬�N�����R���e�i���擾���܂��B
   * @return �쐬�N�����R���e�i
   */
  protected ACLabelContainer getCreateDateContainer(){
    if(createDateContainer==null){
      createDateContainer = new ACLabelContainer();
      createDateContainer.setFollowChildEnabled(true);
      createDateContainer.setVAlignment(VRLayout.CENTER);
      createDateContainer.add(getCreateDate(), null);
    }
    return createDateContainer;
  }

  /**
   * �X�e�[�V���������擾���܂��B
   * @return �X�e�[�V������
   */
  public ACComboBox getProviderName(){
    if(providerName==null){

      providerName = new ACComboBox();

      getProviderNameContainer().setText("�X�e�[�V������");

      providerName.setBindPath("PROVIDER_NAME");

      providerName.setEditable(true);

      providerName.setColumns(22);

      providerName.setModelBindPath("PROVIDER_NAMES");

      providerName.setRenderBindPath("PROVIDER_NAME");

      providerName.setBlankable(false);

      providerName.setIMEMode(InputSubset.KANJI);

      providerName.setMaxLength(63);

      providerName.setModel(getProviderNameModel());

      addProviderName();
    }
    return providerName;

  }

  /**
   * �X�e�[�V�������R���e�i���擾���܂��B
   * @return �X�e�[�V�������R���e�i
   */
  protected ACLabelContainer getProviderNameContainer(){
    if(providerNameContainer==null){
      providerNameContainer = new ACLabelContainer();
      providerNameContainer.setFollowChildEnabled(true);
      providerNameContainer.setVAlignment(VRLayout.CENTER);
      providerNameContainer.add(getProviderName(), null);
    }
    return providerNameContainer;
  }

  /**
   * �X�e�[�V���������f�����擾���܂��B
   * @return �X�e�[�V���������f��
   */
  protected ACComboBoxModelAdapter getProviderNameModel(){
    if(providerNameModel==null){
      providerNameModel = new ACComboBoxModelAdapter();
      addProviderNameModel();
    }
    return providerNameModel;
  }

  /**
   * �Ǘ��Ҏ������擾���܂��B
   * @return �Ǘ��Ҏ���
   */
  public ACTextField getAdministratorName(){
    if(administratorName==null){

      administratorName = new ACTextField();

      getAdministratorNameContainer().setText("�Ǘ��Ҏ���");

      administratorName.setBindPath("ADMINISTRATOR_NAME");

      administratorName.setEditable(true);

      administratorName.setColumns(22);

      administratorName.setIMEMode(InputSubset.KANJI);

      administratorName.setMaxLength(22);

      addAdministratorName();
    }
    return administratorName;

  }

  /**
   * �Ǘ��Ҏ����R���e�i���擾���܂��B
   * @return �Ǘ��Ҏ����R���e�i
   */
  protected ACLabelContainer getAdministratorNameContainer(){
    if(administratorNameContainer==null){
      administratorNameContainer = new ACLabelContainer();
      administratorNameContainer.setFollowChildEnabled(true);
      administratorNameContainer.setVAlignment(VRLayout.CENTER);
      administratorNameContainer.add(getAdministratorName(), null);
    }
    return administratorNameContainer;
  }

  /**
   * Tab���擾���܂��B
   * @return Tab
   */
  public JTabbedPane getTabs(){
    if(tabs==null){

      tabs = new JTabbedPane();

      addTabs();
    }
    return tabs;

  }

  /**
   * Tab�u�K����v���擾���܂��B
   * @return Tab�u�K����v
   */
  public ACPanel getTabVisitDate(){
    if(tabVisitDate==null){

      tabVisitDate = new ACPanel();

      tabVisitDate.setHgap(0);

      addTabVisitDate();
    }
    return tabVisitDate;

  }

  /**
   * �K����̈���擾���܂��B
   * @return �K����̈�
   */
  public ACGroupBox getVisitDates(){
    if(visitDates==null){

      visitDates = new ACGroupBox();

      visitDates.setText("�K���");

      visitDates.setHgap(0);

      addVisitDates();
    }
    return visitDates;

  }

  /**
   * �J�����_�[�̈���擾���܂��B
   * @return �J�����_�[�̈�
   */
  public ACPanel getCalendars(){
    if(calendars==null){

      calendars = new ACPanel();

      calendars.setHgap(0);

      addCalendars();
    }
    return calendars;

  }

  /**
   * �J�����_�[(���̈�)���擾���܂��B
   * @return �J�����_�[(���̈�)
   */
  public ACLabelContainer getCalendarLefts(){
    if(calendarLefts==null){

      calendarLefts = new ACLabelContainer();

      calendarLefts.setHgap(0);

      addCalendarLefts();
    }
    return calendarLefts;

  }

  /**
   * �J�����_�[(��)�N���̈���擾���܂��B
   * @return �J�����_�[(��)�N���̈�
   */
  public ACPanel getCalendarLeftYearMonths(){
    if(calendarLeftYearMonths==null){

      calendarLeftYearMonths = new ACPanel();

      calendarLeftYearMonths.setLayout(getCalendarLeftYearMonthsLayout());

      addCalendarLeftYearMonths();
    }
    return calendarLeftYearMonths;

  }

  /**
   * �J�����_�[(��)�N���̈惌�C�A�E�g���擾���܂��B
   * @return �J�����_�[(��)�N���̈惌�C�A�E�g
   */
  public VRLayout getCalendarLeftYearMonthsLayout(){
    if(calendarLeftYearMonthsLayout==null){

      calendarLeftYearMonthsLayout = new VRLayout();

      calendarLeftYearMonthsLayout.setAlignment(SwingConstants.CENTER);

      calendarLeftYearMonthsLayout.setAutoWrap(false);

      addCalendarLeftYearMonthsLayout();
    }
    return calendarLeftYearMonthsLayout;

  }

  /**
   * �������擾���܂��B
   * @return ����
   */
  public ACLabel getCalendarLeftCaption(){
    if(calendarLeftCaption==null){

      calendarLeftCaption = new ACLabel();

      calendarLeftCaption.setText("����");

      addCalendarLeftCaption();
    }
    return calendarLeftCaption;

  }

  /**
   * �N���擾���܂��B
   * @return �N
   */
  public ACLabel getCalendarLeftYear(){
    if(calendarLeftYear==null){

      calendarLeftYear = new ACLabel();

      calendarLeftYear.setBindPath("CALENDAR_LEFT_YEAR");

      addCalendarLeftYear();
    }
    return calendarLeftYear;

  }

  /**
   * �N�L���v�V�������擾���܂��B
   * @return �N�L���v�V����
   */
  public ACLabel getCalendarLeftYearCaption(){
    if(calendarLeftYearCaption==null){

      calendarLeftYearCaption = new ACLabel();

      calendarLeftYearCaption.setText("�N");

      addCalendarLeftYearCaption();
    }
    return calendarLeftYearCaption;

  }

  /**
   * �����擾���܂��B
   * @return ��
   */
  public ACLabel getCalendarLeftMonth(){
    if(calendarLeftMonth==null){

      calendarLeftMonth = new ACLabel();

      calendarLeftMonth.setBindPath("CALENDAR_LEFT_MONTH");

      addCalendarLeftMonth();
    }
    return calendarLeftMonth;

  }

  /**
   * ���L���v�V�������擾���܂��B
   * @return ���L���v�V����
   */
  public ACLabel getCalendarLeftMonthCaption(){
    if(calendarLeftMonthCaption==null){

      calendarLeftMonthCaption = new ACLabel();

      calendarLeftMonthCaption.setText("��");

      addCalendarLeftMonthCaption();
    }
    return calendarLeftMonthCaption;

  }

  /**
   * �J�����_�[(�����t�̈�)���擾���܂��B
   * @return �J�����_�[(�����t�̈�)
   */
  public ACPanel getCalendarLeftDayContainer(){
    if(calendarLeftDayContainer==null){

      calendarLeftDayContainer = new ACPanel();

      calendarLeftDayContainer.setAutoWrap(false);

      calendarLeftDayContainer.setHgap(0);

      calendarLeftDayContainer.setVgap(0);

      addCalendarLeftDayContainer();
    }
    return calendarLeftDayContainer;

  }

  /**
   * 1�����擾���܂��B
   * @return 1��
   */
  public ACComboBox getCalendarLeftDay01(){
    if(calendarLeftDay01==null){

      calendarLeftDay01 = new ACComboBox();

      calendarLeftDay01.setBindPath("CALENDAR_LEFT_DAY1");

      calendarLeftDay01.setEditable(false);

      calendarLeftDay01.setColumns(3);

      calendarLeftDay01.setModelBindPath("CALENDAR_LEFT1");

      calendarLeftDay01.setRenderBindPath("CALENDAR_DATA_STRING");

      calendarLeftDay01.setBlankable(false);

      calendarLeftDay01.setMaxColumns(3);

      calendarLeftDay01.setModel(getCalendarLeftDay01Model());

      addCalendarLeftDay01();
    }
    return calendarLeftDay01;

  }

  /**
   * 1�����f�����擾���܂��B
   * @return 1�����f��
   */
  protected ACComboBoxModelAdapter getCalendarLeftDay01Model(){
    if(calendarLeftDay01Model==null){
      calendarLeftDay01Model = new ACComboBoxModelAdapter();
      addCalendarLeftDay01Model();
    }
    return calendarLeftDay01Model;
  }

  /**
   * 2�����擾���܂��B
   * @return 2��
   */
  public ACComboBox getCalendarLeftDay02(){
    if(calendarLeftDay02==null){

      calendarLeftDay02 = new ACComboBox();

      calendarLeftDay02.setBindPath("CALENDAR_LEFT_DAY2");

      calendarLeftDay02.setEditable(false);

      calendarLeftDay02.setColumns(3);

      calendarLeftDay02.setModelBindPath("CALENDAR_LEFT2");

      calendarLeftDay02.setRenderBindPath("CALENDAR_DATA_STRING");

      calendarLeftDay02.setBlankable(false);

      calendarLeftDay02.setMaxColumns(3);

      calendarLeftDay02.setModel(getCalendarLeftDay02Model());

      addCalendarLeftDay02();
    }
    return calendarLeftDay02;

  }

  /**
   * 2�����f�����擾���܂��B
   * @return 2�����f��
   */
  protected ACComboBoxModelAdapter getCalendarLeftDay02Model(){
    if(calendarLeftDay02Model==null){
      calendarLeftDay02Model = new ACComboBoxModelAdapter();
      addCalendarLeftDay02Model();
    }
    return calendarLeftDay02Model;
  }

  /**
   * 3�����擾���܂��B
   * @return 3��
   */
  public ACComboBox getCalendarLeftDay03(){
    if(calendarLeftDay03==null){

      calendarLeftDay03 = new ACComboBox();

      calendarLeftDay03.setBindPath("CALENDAR_LEFT_DAY3");

      calendarLeftDay03.setEditable(false);

      calendarLeftDay03.setColumns(3);

      calendarLeftDay03.setModelBindPath("CALENDAR_LEFT3");

      calendarLeftDay03.setRenderBindPath("CALENDAR_DATA_STRING");

      calendarLeftDay03.setBlankable(false);

      calendarLeftDay03.setMaxColumns(3);

      calendarLeftDay03.setModel(getCalendarLeftDay03Model());

      addCalendarLeftDay03();
    }
    return calendarLeftDay03;

  }

  /**
   * 3�����f�����擾���܂��B
   * @return 3�����f��
   */
  protected ACComboBoxModelAdapter getCalendarLeftDay03Model(){
    if(calendarLeftDay03Model==null){
      calendarLeftDay03Model = new ACComboBoxModelAdapter();
      addCalendarLeftDay03Model();
    }
    return calendarLeftDay03Model;
  }

  /**
   * 4�����擾���܂��B
   * @return 4��
   */
  public ACComboBox getCalendarLeftDay04(){
    if(calendarLeftDay04==null){

      calendarLeftDay04 = new ACComboBox();

      calendarLeftDay04.setBindPath("CALENDAR_LEFT_DAY4");

      calendarLeftDay04.setEditable(false);

      calendarLeftDay04.setColumns(3);

      calendarLeftDay04.setModelBindPath("CALENDAR_LEFT4");

      calendarLeftDay04.setRenderBindPath("CALENDAR_DATA_STRING");

      calendarLeftDay04.setBlankable(false);

      calendarLeftDay04.setMaxColumns(3);

      calendarLeftDay04.setModel(getCalendarLeftDay04Model());

      addCalendarLeftDay04();
    }
    return calendarLeftDay04;

  }

  /**
   * 4�����f�����擾���܂��B
   * @return 4�����f��
   */
  protected ACComboBoxModelAdapter getCalendarLeftDay04Model(){
    if(calendarLeftDay04Model==null){
      calendarLeftDay04Model = new ACComboBoxModelAdapter();
      addCalendarLeftDay04Model();
    }
    return calendarLeftDay04Model;
  }

  /**
   * 5�����擾���܂��B
   * @return 5��
   */
  public ACComboBox getCalendarLeftDay05(){
    if(calendarLeftDay05==null){

      calendarLeftDay05 = new ACComboBox();

      calendarLeftDay05.setBindPath("CALENDAR_LEFT_DAY5");

      calendarLeftDay05.setEditable(false);

      calendarLeftDay05.setColumns(3);

      calendarLeftDay05.setModelBindPath("CALENDAR_LEFT5");

      calendarLeftDay05.setRenderBindPath("CALENDAR_DATA_STRING");

      calendarLeftDay05.setBlankable(false);

      calendarLeftDay05.setMaxColumns(3);

      calendarLeftDay05.setModel(getCalendarLeftDay05Model());

      addCalendarLeftDay05();
    }
    return calendarLeftDay05;

  }

  /**
   * 5�����f�����擾���܂��B
   * @return 5�����f��
   */
  protected ACComboBoxModelAdapter getCalendarLeftDay05Model(){
    if(calendarLeftDay05Model==null){
      calendarLeftDay05Model = new ACComboBoxModelAdapter();
      addCalendarLeftDay05Model();
    }
    return calendarLeftDay05Model;
  }

  /**
   * 6�����擾���܂��B
   * @return 6��
   */
  public ACComboBox getCalendarLeftDay06(){
    if(calendarLeftDay06==null){

      calendarLeftDay06 = new ACComboBox();

      calendarLeftDay06.setBindPath("CALENDAR_LEFT_DAY6");

      calendarLeftDay06.setEditable(false);

      calendarLeftDay06.setColumns(3);

      calendarLeftDay06.setModelBindPath("CALENDAR_LEFT6");

      calendarLeftDay06.setRenderBindPath("CALENDAR_DATA_STRING");

      calendarLeftDay06.setBlankable(false);

      calendarLeftDay06.setMaxColumns(3);

      calendarLeftDay06.setModel(getCalendarLeftDay06Model());

      addCalendarLeftDay06();
    }
    return calendarLeftDay06;

  }

  /**
   * 6�����f�����擾���܂��B
   * @return 6�����f��
   */
  protected ACComboBoxModelAdapter getCalendarLeftDay06Model(){
    if(calendarLeftDay06Model==null){
      calendarLeftDay06Model = new ACComboBoxModelAdapter();
      addCalendarLeftDay06Model();
    }
    return calendarLeftDay06Model;
  }

  /**
   * 7�����擾���܂��B
   * @return 7��
   */
  public ACComboBox getCalendarLeftDay07(){
    if(calendarLeftDay07==null){

      calendarLeftDay07 = new ACComboBox();

      calendarLeftDay07.setBindPath("CALENDAR_LEFT_DAY7");

      calendarLeftDay07.setEditable(false);

      calendarLeftDay07.setColumns(3);

      calendarLeftDay07.setModelBindPath("CALENDAR_LEFT7");

      calendarLeftDay07.setRenderBindPath("CALENDAR_DATA_STRING");

      calendarLeftDay07.setBlankable(false);

      calendarLeftDay07.setMaxColumns(3);

      calendarLeftDay07.setModel(getCalendarLeftDay07Model());

      addCalendarLeftDay07();
    }
    return calendarLeftDay07;

  }

  /**
   * 7�����f�����擾���܂��B
   * @return 7�����f��
   */
  protected ACComboBoxModelAdapter getCalendarLeftDay07Model(){
    if(calendarLeftDay07Model==null){
      calendarLeftDay07Model = new ACComboBoxModelAdapter();
      addCalendarLeftDay07Model();
    }
    return calendarLeftDay07Model;
  }

  /**
   * 8�����擾���܂��B
   * @return 8��
   */
  public ACComboBox getCalendarLeftDay08(){
    if(calendarLeftDay08==null){

      calendarLeftDay08 = new ACComboBox();

      calendarLeftDay08.setBindPath("CALENDAR_LEFT_DAY8");

      calendarLeftDay08.setEditable(false);

      calendarLeftDay08.setColumns(3);

      calendarLeftDay08.setModelBindPath("CALENDAR_LEFT8");

      calendarLeftDay08.setRenderBindPath("CALENDAR_DATA_STRING");

      calendarLeftDay08.setBlankable(false);

      calendarLeftDay08.setMaxColumns(3);

      calendarLeftDay08.setModel(getCalendarLeftDay08Model());

      addCalendarLeftDay08();
    }
    return calendarLeftDay08;

  }

  /**
   * 8�����f�����擾���܂��B
   * @return 8�����f��
   */
  protected ACComboBoxModelAdapter getCalendarLeftDay08Model(){
    if(calendarLeftDay08Model==null){
      calendarLeftDay08Model = new ACComboBoxModelAdapter();
      addCalendarLeftDay08Model();
    }
    return calendarLeftDay08Model;
  }

  /**
   * 9�����擾���܂��B
   * @return 9��
   */
  public ACComboBox getCalendarLeftDay09(){
    if(calendarLeftDay09==null){

      calendarLeftDay09 = new ACComboBox();

      calendarLeftDay09.setBindPath("CALENDAR_LEFT_DAY9");

      calendarLeftDay09.setEditable(false);

      calendarLeftDay09.setColumns(3);

      calendarLeftDay09.setModelBindPath("CALENDAR_LEFT9");

      calendarLeftDay09.setRenderBindPath("CALENDAR_DATA_STRING");

      calendarLeftDay09.setBlankable(false);

      calendarLeftDay09.setMaxColumns(3);

      calendarLeftDay09.setModel(getCalendarLeftDay09Model());

      addCalendarLeftDay09();
    }
    return calendarLeftDay09;

  }

  /**
   * 9�����f�����擾���܂��B
   * @return 9�����f��
   */
  protected ACComboBoxModelAdapter getCalendarLeftDay09Model(){
    if(calendarLeftDay09Model==null){
      calendarLeftDay09Model = new ACComboBoxModelAdapter();
      addCalendarLeftDay09Model();
    }
    return calendarLeftDay09Model;
  }

  /**
   * 10�����擾���܂��B
   * @return 10��
   */
  public ACComboBox getCalendarLeftDay10(){
    if(calendarLeftDay10==null){

      calendarLeftDay10 = new ACComboBox();

      calendarLeftDay10.setBindPath("CALENDAR_LEFT_DAY10");

      calendarLeftDay10.setEditable(false);

      calendarLeftDay10.setColumns(3);

      calendarLeftDay10.setModelBindPath("CALENDAR_LEFT10");

      calendarLeftDay10.setRenderBindPath("CALENDAR_DATA_STRING");

      calendarLeftDay10.setBlankable(false);

      calendarLeftDay10.setMaxColumns(3);

      calendarLeftDay10.setModel(getCalendarLeftDay10Model());

      addCalendarLeftDay10();
    }
    return calendarLeftDay10;

  }

  /**
   * 10�����f�����擾���܂��B
   * @return 10�����f��
   */
  protected ACComboBoxModelAdapter getCalendarLeftDay10Model(){
    if(calendarLeftDay10Model==null){
      calendarLeftDay10Model = new ACComboBoxModelAdapter();
      addCalendarLeftDay10Model();
    }
    return calendarLeftDay10Model;
  }

  /**
   * 11�����擾���܂��B
   * @return 11��
   */
  public ACComboBox getCalendarLeftDay11(){
    if(calendarLeftDay11==null){

      calendarLeftDay11 = new ACComboBox();

      calendarLeftDay11.setBindPath("CALENDAR_LEFT_DAY11");

      calendarLeftDay11.setEditable(false);

      calendarLeftDay11.setColumns(3);

      calendarLeftDay11.setModelBindPath("CALENDAR_LEFT11");

      calendarLeftDay11.setRenderBindPath("CALENDAR_DATA_STRING");

      calendarLeftDay11.setBlankable(false);

      calendarLeftDay11.setMaxColumns(3);

      calendarLeftDay11.setModel(getCalendarLeftDay11Model());

      addCalendarLeftDay11();
    }
    return calendarLeftDay11;

  }

  /**
   * 11�����f�����擾���܂��B
   * @return 11�����f��
   */
  protected ACComboBoxModelAdapter getCalendarLeftDay11Model(){
    if(calendarLeftDay11Model==null){
      calendarLeftDay11Model = new ACComboBoxModelAdapter();
      addCalendarLeftDay11Model();
    }
    return calendarLeftDay11Model;
  }

  /**
   * 12�����擾���܂��B
   * @return 12��
   */
  public ACComboBox getCalendarLeftDay12(){
    if(calendarLeftDay12==null){

      calendarLeftDay12 = new ACComboBox();

      calendarLeftDay12.setBindPath("CALENDAR_LEFT_DAY12");

      calendarLeftDay12.setEditable(false);

      calendarLeftDay12.setColumns(3);

      calendarLeftDay12.setModelBindPath("CALENDAR_LEFT12");

      calendarLeftDay12.setRenderBindPath("CALENDAR_DATA_STRING");

      calendarLeftDay12.setBlankable(false);

      calendarLeftDay12.setMaxColumns(3);

      calendarLeftDay12.setModel(getCalendarLeftDay12Model());

      addCalendarLeftDay12();
    }
    return calendarLeftDay12;

  }

  /**
   * 12�����f�����擾���܂��B
   * @return 12�����f��
   */
  protected ACComboBoxModelAdapter getCalendarLeftDay12Model(){
    if(calendarLeftDay12Model==null){
      calendarLeftDay12Model = new ACComboBoxModelAdapter();
      addCalendarLeftDay12Model();
    }
    return calendarLeftDay12Model;
  }

  /**
   * 13�����擾���܂��B
   * @return 13��
   */
  public ACComboBox getCalendarLeftDay13(){
    if(calendarLeftDay13==null){

      calendarLeftDay13 = new ACComboBox();

      calendarLeftDay13.setBindPath("CALENDAR_LEFT_DAY13");

      calendarLeftDay13.setEditable(false);

      calendarLeftDay13.setColumns(3);

      calendarLeftDay13.setModelBindPath("CALENDAR_LEFT13");

      calendarLeftDay13.setRenderBindPath("CALENDAR_DATA_STRING");

      calendarLeftDay13.setBlankable(false);

      calendarLeftDay13.setMaxColumns(3);

      calendarLeftDay13.setModel(getCalendarLeftDay13Model());

      addCalendarLeftDay13();
    }
    return calendarLeftDay13;

  }

  /**
   * 13�����f�����擾���܂��B
   * @return 13�����f��
   */
  protected ACComboBoxModelAdapter getCalendarLeftDay13Model(){
    if(calendarLeftDay13Model==null){
      calendarLeftDay13Model = new ACComboBoxModelAdapter();
      addCalendarLeftDay13Model();
    }
    return calendarLeftDay13Model;
  }

  /**
   * 14�����擾���܂��B
   * @return 14��
   */
  public ACComboBox getCalendarLeftDay14(){
    if(calendarLeftDay14==null){

      calendarLeftDay14 = new ACComboBox();

      calendarLeftDay14.setBindPath("CALENDAR_LEFT_DAY14");

      calendarLeftDay14.setEditable(false);

      calendarLeftDay14.setColumns(3);

      calendarLeftDay14.setModelBindPath("CALENDAR_LEFT14");

      calendarLeftDay14.setRenderBindPath("CALENDAR_DATA_STRING");

      calendarLeftDay14.setBlankable(false);

      calendarLeftDay14.setMaxColumns(3);

      calendarLeftDay14.setModel(getCalendarLeftDay14Model());

      addCalendarLeftDay14();
    }
    return calendarLeftDay14;

  }

  /**
   * 14�����f�����擾���܂��B
   * @return 14�����f��
   */
  protected ACComboBoxModelAdapter getCalendarLeftDay14Model(){
    if(calendarLeftDay14Model==null){
      calendarLeftDay14Model = new ACComboBoxModelAdapter();
      addCalendarLeftDay14Model();
    }
    return calendarLeftDay14Model;
  }

  /**
   * 15�����擾���܂��B
   * @return 15��
   */
  public ACComboBox getCalendarLeftDay15(){
    if(calendarLeftDay15==null){

      calendarLeftDay15 = new ACComboBox();

      calendarLeftDay15.setBindPath("CALENDAR_LEFT_DAY15");

      calendarLeftDay15.setEditable(false);

      calendarLeftDay15.setColumns(3);

      calendarLeftDay15.setModelBindPath("CALENDAR_LEFT15");

      calendarLeftDay15.setRenderBindPath("CALENDAR_DATA_STRING");

      calendarLeftDay15.setBlankable(false);

      calendarLeftDay15.setMaxColumns(3);

      calendarLeftDay15.setModel(getCalendarLeftDay15Model());

      addCalendarLeftDay15();
    }
    return calendarLeftDay15;

  }

  /**
   * 15�����f�����擾���܂��B
   * @return 15�����f��
   */
  protected ACComboBoxModelAdapter getCalendarLeftDay15Model(){
    if(calendarLeftDay15Model==null){
      calendarLeftDay15Model = new ACComboBoxModelAdapter();
      addCalendarLeftDay15Model();
    }
    return calendarLeftDay15Model;
  }

  /**
   * 16�����擾���܂��B
   * @return 16��
   */
  public ACComboBox getCalendarLeftDay16(){
    if(calendarLeftDay16==null){

      calendarLeftDay16 = new ACComboBox();

      calendarLeftDay16.setBindPath("CALENDAR_LEFT_DAY16");

      calendarLeftDay16.setEditable(false);

      calendarLeftDay16.setColumns(3);

      calendarLeftDay16.setModelBindPath("CALENDAR_LEFT16");

      calendarLeftDay16.setRenderBindPath("CALENDAR_DATA_STRING");

      calendarLeftDay16.setBlankable(false);

      calendarLeftDay16.setMaxColumns(3);

      calendarLeftDay16.setModel(getCalendarLeftDay16Model());

      addCalendarLeftDay16();
    }
    return calendarLeftDay16;

  }

  /**
   * 16�����f�����擾���܂��B
   * @return 16�����f��
   */
  protected ACComboBoxModelAdapter getCalendarLeftDay16Model(){
    if(calendarLeftDay16Model==null){
      calendarLeftDay16Model = new ACComboBoxModelAdapter();
      addCalendarLeftDay16Model();
    }
    return calendarLeftDay16Model;
  }

  /**
   * 17�����擾���܂��B
   * @return 17��
   */
  public ACComboBox getCalendarLeftDay17(){
    if(calendarLeftDay17==null){

      calendarLeftDay17 = new ACComboBox();

      calendarLeftDay17.setBindPath("CALENDAR_LEFT_DAY17");

      calendarLeftDay17.setEditable(false);

      calendarLeftDay17.setColumns(3);

      calendarLeftDay17.setModelBindPath("CALENDAR_LEFT17");

      calendarLeftDay17.setRenderBindPath("CALENDAR_DATA_STRING");

      calendarLeftDay17.setBlankable(false);

      calendarLeftDay17.setMaxColumns(3);

      calendarLeftDay17.setModel(getCalendarLeftDay17Model());

      addCalendarLeftDay17();
    }
    return calendarLeftDay17;

  }

  /**
   * 17�����f�����擾���܂��B
   * @return 17�����f��
   */
  protected ACComboBoxModelAdapter getCalendarLeftDay17Model(){
    if(calendarLeftDay17Model==null){
      calendarLeftDay17Model = new ACComboBoxModelAdapter();
      addCalendarLeftDay17Model();
    }
    return calendarLeftDay17Model;
  }

  /**
   * 18�����擾���܂��B
   * @return 18��
   */
  public ACComboBox getCalendarLeftDay18(){
    if(calendarLeftDay18==null){

      calendarLeftDay18 = new ACComboBox();

      calendarLeftDay18.setBindPath("CALENDAR_LEFT_DAY18");

      calendarLeftDay18.setEditable(false);

      calendarLeftDay18.setColumns(3);

      calendarLeftDay18.setModelBindPath("CALENDAR_LEFT18");

      calendarLeftDay18.setRenderBindPath("CALENDAR_DATA_STRING");

      calendarLeftDay18.setBlankable(false);

      calendarLeftDay18.setMaxColumns(3);

      calendarLeftDay18.setModel(getCalendarLeftDay18Model());

      addCalendarLeftDay18();
    }
    return calendarLeftDay18;

  }

  /**
   * 18�����f�����擾���܂��B
   * @return 18�����f��
   */
  protected ACComboBoxModelAdapter getCalendarLeftDay18Model(){
    if(calendarLeftDay18Model==null){
      calendarLeftDay18Model = new ACComboBoxModelAdapter();
      addCalendarLeftDay18Model();
    }
    return calendarLeftDay18Model;
  }

  /**
   * 19�����擾���܂��B
   * @return 19��
   */
  public ACComboBox getCalendarLeftDay19(){
    if(calendarLeftDay19==null){

      calendarLeftDay19 = new ACComboBox();

      calendarLeftDay19.setBindPath("CALENDAR_LEFT_DAY19");

      calendarLeftDay19.setEditable(false);

      calendarLeftDay19.setColumns(3);

      calendarLeftDay19.setModelBindPath("CALENDAR_LEFT19");

      calendarLeftDay19.setRenderBindPath("CALENDAR_DATA_STRING");

      calendarLeftDay19.setBlankable(false);

      calendarLeftDay19.setMaxColumns(3);

      calendarLeftDay19.setModel(getCalendarLeftDay19Model());

      addCalendarLeftDay19();
    }
    return calendarLeftDay19;

  }

  /**
   * 19�����f�����擾���܂��B
   * @return 19�����f��
   */
  protected ACComboBoxModelAdapter getCalendarLeftDay19Model(){
    if(calendarLeftDay19Model==null){
      calendarLeftDay19Model = new ACComboBoxModelAdapter();
      addCalendarLeftDay19Model();
    }
    return calendarLeftDay19Model;
  }

  /**
   * 20�����擾���܂��B
   * @return 20��
   */
  public ACComboBox getCalendarLeftDay20(){
    if(calendarLeftDay20==null){

      calendarLeftDay20 = new ACComboBox();

      calendarLeftDay20.setBindPath("CALENDAR_LEFT_DAY20");

      calendarLeftDay20.setEditable(false);

      calendarLeftDay20.setColumns(3);

      calendarLeftDay20.setModelBindPath("CALENDAR_LEFT20");

      calendarLeftDay20.setRenderBindPath("CALENDAR_DATA_STRING");

      calendarLeftDay20.setBlankable(false);

      calendarLeftDay20.setMaxColumns(3);

      calendarLeftDay20.setModel(getCalendarLeftDay20Model());

      addCalendarLeftDay20();
    }
    return calendarLeftDay20;

  }

  /**
   * 20�����f�����擾���܂��B
   * @return 20�����f��
   */
  protected ACComboBoxModelAdapter getCalendarLeftDay20Model(){
    if(calendarLeftDay20Model==null){
      calendarLeftDay20Model = new ACComboBoxModelAdapter();
      addCalendarLeftDay20Model();
    }
    return calendarLeftDay20Model;
  }

  /**
   * 21�����擾���܂��B
   * @return 21��
   */
  public ACComboBox getCalendarLeftDay21(){
    if(calendarLeftDay21==null){

      calendarLeftDay21 = new ACComboBox();

      calendarLeftDay21.setBindPath("CALENDAR_LEFT_DAY21");

      calendarLeftDay21.setEditable(false);

      calendarLeftDay21.setColumns(3);

      calendarLeftDay21.setModelBindPath("CALENDAR_LEFT21");

      calendarLeftDay21.setRenderBindPath("CALENDAR_DATA_STRING");

      calendarLeftDay21.setBlankable(false);

      calendarLeftDay21.setMaxColumns(3);

      calendarLeftDay21.setModel(getCalendarLeftDay21Model());

      addCalendarLeftDay21();
    }
    return calendarLeftDay21;

  }

  /**
   * 21�����f�����擾���܂��B
   * @return 21�����f��
   */
  protected ACComboBoxModelAdapter getCalendarLeftDay21Model(){
    if(calendarLeftDay21Model==null){
      calendarLeftDay21Model = new ACComboBoxModelAdapter();
      addCalendarLeftDay21Model();
    }
    return calendarLeftDay21Model;
  }

  /**
   * 22�����擾���܂��B
   * @return 22��
   */
  public ACComboBox getCalendarLeftDay22(){
    if(calendarLeftDay22==null){

      calendarLeftDay22 = new ACComboBox();

      calendarLeftDay22.setBindPath("CALENDAR_LEFT_DAY22");

      calendarLeftDay22.setEditable(false);

      calendarLeftDay22.setColumns(3);

      calendarLeftDay22.setModelBindPath("CALENDAR_LEFT22");

      calendarLeftDay22.setRenderBindPath("CALENDAR_DATA_STRING");

      calendarLeftDay22.setBlankable(false);

      calendarLeftDay22.setMaxColumns(3);

      calendarLeftDay22.setModel(getCalendarLeftDay22Model());

      addCalendarLeftDay22();
    }
    return calendarLeftDay22;

  }

  /**
   * 22�����f�����擾���܂��B
   * @return 22�����f��
   */
  protected ACComboBoxModelAdapter getCalendarLeftDay22Model(){
    if(calendarLeftDay22Model==null){
      calendarLeftDay22Model = new ACComboBoxModelAdapter();
      addCalendarLeftDay22Model();
    }
    return calendarLeftDay22Model;
  }

  /**
   * 23�����擾���܂��B
   * @return 23��
   */
  public ACComboBox getCalendarLeftDay23(){
    if(calendarLeftDay23==null){

      calendarLeftDay23 = new ACComboBox();

      calendarLeftDay23.setBindPath("CALENDAR_LEFT_DAY23");

      calendarLeftDay23.setEditable(false);

      calendarLeftDay23.setColumns(3);

      calendarLeftDay23.setModelBindPath("CALENDAR_LEFT23");

      calendarLeftDay23.setRenderBindPath("CALENDAR_DATA_STRING");

      calendarLeftDay23.setBlankable(false);

      calendarLeftDay23.setMaxColumns(3);

      calendarLeftDay23.setModel(getCalendarLeftDay23Model());

      addCalendarLeftDay23();
    }
    return calendarLeftDay23;

  }

  /**
   * 23�����f�����擾���܂��B
   * @return 23�����f��
   */
  protected ACComboBoxModelAdapter getCalendarLeftDay23Model(){
    if(calendarLeftDay23Model==null){
      calendarLeftDay23Model = new ACComboBoxModelAdapter();
      addCalendarLeftDay23Model();
    }
    return calendarLeftDay23Model;
  }

  /**
   * 24�����擾���܂��B
   * @return 24��
   */
  public ACComboBox getCalendarLeftDay24(){
    if(calendarLeftDay24==null){

      calendarLeftDay24 = new ACComboBox();

      calendarLeftDay24.setBindPath("CALENDAR_LEFT_DAY24");

      calendarLeftDay24.setEditable(false);

      calendarLeftDay24.setColumns(3);

      calendarLeftDay24.setModelBindPath("CALENDAR_LEFT24");

      calendarLeftDay24.setRenderBindPath("CALENDAR_DATA_STRING");

      calendarLeftDay24.setBlankable(false);

      calendarLeftDay24.setMaxColumns(3);

      calendarLeftDay24.setModel(getCalendarLeftDay24Model());

      addCalendarLeftDay24();
    }
    return calendarLeftDay24;

  }

  /**
   * 24�����f�����擾���܂��B
   * @return 24�����f��
   */
  protected ACComboBoxModelAdapter getCalendarLeftDay24Model(){
    if(calendarLeftDay24Model==null){
      calendarLeftDay24Model = new ACComboBoxModelAdapter();
      addCalendarLeftDay24Model();
    }
    return calendarLeftDay24Model;
  }

  /**
   * 25�����擾���܂��B
   * @return 25��
   */
  public ACComboBox getCalendarLeftDay25(){
    if(calendarLeftDay25==null){

      calendarLeftDay25 = new ACComboBox();

      calendarLeftDay25.setBindPath("CALENDAR_LEFT_DAY25");

      calendarLeftDay25.setEditable(false);

      calendarLeftDay25.setColumns(3);

      calendarLeftDay25.setModelBindPath("CALENDAR_LEFT25");

      calendarLeftDay25.setRenderBindPath("CALENDAR_DATA_STRING");

      calendarLeftDay25.setBlankable(false);

      calendarLeftDay25.setMaxColumns(3);

      calendarLeftDay25.setModel(getCalendarLeftDay25Model());

      addCalendarLeftDay25();
    }
    return calendarLeftDay25;

  }

  /**
   * 25�����f�����擾���܂��B
   * @return 25�����f��
   */
  protected ACComboBoxModelAdapter getCalendarLeftDay25Model(){
    if(calendarLeftDay25Model==null){
      calendarLeftDay25Model = new ACComboBoxModelAdapter();
      addCalendarLeftDay25Model();
    }
    return calendarLeftDay25Model;
  }

  /**
   * 26�����擾���܂��B
   * @return 26��
   */
  public ACComboBox getCalendarLeftDay26(){
    if(calendarLeftDay26==null){

      calendarLeftDay26 = new ACComboBox();

      calendarLeftDay26.setBindPath("CALENDAR_LEFT_DAY26");

      calendarLeftDay26.setEditable(false);

      calendarLeftDay26.setColumns(3);

      calendarLeftDay26.setModelBindPath("CALENDAR_LEFT26");

      calendarLeftDay26.setRenderBindPath("CALENDAR_DATA_STRING");

      calendarLeftDay26.setBlankable(false);

      calendarLeftDay26.setMaxColumns(3);

      calendarLeftDay26.setModel(getCalendarLeftDay26Model());

      addCalendarLeftDay26();
    }
    return calendarLeftDay26;

  }

  /**
   * 26�����f�����擾���܂��B
   * @return 26�����f��
   */
  protected ACComboBoxModelAdapter getCalendarLeftDay26Model(){
    if(calendarLeftDay26Model==null){
      calendarLeftDay26Model = new ACComboBoxModelAdapter();
      addCalendarLeftDay26Model();
    }
    return calendarLeftDay26Model;
  }

  /**
   * 27�����擾���܂��B
   * @return 27��
   */
  public ACComboBox getCalendarLeftDay27(){
    if(calendarLeftDay27==null){

      calendarLeftDay27 = new ACComboBox();

      calendarLeftDay27.setBindPath("CALENDAR_LEFT_DAY27");

      calendarLeftDay27.setEditable(false);

      calendarLeftDay27.setColumns(3);

      calendarLeftDay27.setModelBindPath("CALENDAR_LEFT27");

      calendarLeftDay27.setRenderBindPath("CALENDAR_DATA_STRING");

      calendarLeftDay27.setBlankable(false);

      calendarLeftDay27.setMaxColumns(3);

      calendarLeftDay27.setModel(getCalendarLeftDay27Model());

      addCalendarLeftDay27();
    }
    return calendarLeftDay27;

  }

  /**
   * 27�����f�����擾���܂��B
   * @return 27�����f��
   */
  protected ACComboBoxModelAdapter getCalendarLeftDay27Model(){
    if(calendarLeftDay27Model==null){
      calendarLeftDay27Model = new ACComboBoxModelAdapter();
      addCalendarLeftDay27Model();
    }
    return calendarLeftDay27Model;
  }

  /**
   * 28�����擾���܂��B
   * @return 28��
   */
  public ACComboBox getCalendarLeftDay28(){
    if(calendarLeftDay28==null){

      calendarLeftDay28 = new ACComboBox();

      calendarLeftDay28.setBindPath("CALENDAR_LEFT_DAY28");

      calendarLeftDay28.setEditable(false);

      calendarLeftDay28.setColumns(3);

      calendarLeftDay28.setModelBindPath("CALENDAR_LEFT28");

      calendarLeftDay28.setRenderBindPath("CALENDAR_DATA_STRING");

      calendarLeftDay28.setBlankable(false);

      calendarLeftDay28.setMaxColumns(3);

      calendarLeftDay28.setModel(getCalendarLeftDay28Model());

      addCalendarLeftDay28();
    }
    return calendarLeftDay28;

  }

  /**
   * 28�����f�����擾���܂��B
   * @return 28�����f��
   */
  protected ACComboBoxModelAdapter getCalendarLeftDay28Model(){
    if(calendarLeftDay28Model==null){
      calendarLeftDay28Model = new ACComboBoxModelAdapter();
      addCalendarLeftDay28Model();
    }
    return calendarLeftDay28Model;
  }

  /**
   * 29���p�l�����擾���܂��B
   * @return 29���p�l��
   */
  public ACPanel getCalendarLeftDay29Panel(){
    if(calendarLeftDay29Panel==null){

      calendarLeftDay29Panel = new ACPanel();

      calendarLeftDay29Panel.setHgap(0);

      calendarLeftDay29Panel.setLabelMargin(0);

      calendarLeftDay29Panel.setVgap(0);

      addCalendarLeftDay29Panel();
    }
    return calendarLeftDay29Panel;

  }

  /**
   * 29���x�����擾���܂��B
   * @return 29���x��
   */
  public ACLabel getCalendarLeftDay29Label(){
    if(calendarLeftDay29Label==null){

      calendarLeftDay29Label = new ACLabel();

      calendarLeftDay29Label.setVisible(false);

      addCalendarLeftDay29Label();
    }
    return calendarLeftDay29Label;

  }

  /**
   * 29�����擾���܂��B
   * @return 29��
   */
  public ACComboBox getCalendarLeftDay29(){
    if(calendarLeftDay29==null){

      calendarLeftDay29 = new ACComboBox();

      calendarLeftDay29.setBindPath("CALENDAR_LEFT_DAY29");

      calendarLeftDay29.setEditable(false);

      calendarLeftDay29.setColumns(3);

      calendarLeftDay29.setModelBindPath("CALENDAR_LEFT29");

      calendarLeftDay29.setRenderBindPath("CALENDAR_DATA_STRING");

      calendarLeftDay29.setBlankable(false);

      calendarLeftDay29.setMaxColumns(3);

      calendarLeftDay29.setModel(getCalendarLeftDay29Model());

      addCalendarLeftDay29();
    }
    return calendarLeftDay29;

  }

  /**
   * 29�����f�����擾���܂��B
   * @return 29�����f��
   */
  protected ACComboBoxModelAdapter getCalendarLeftDay29Model(){
    if(calendarLeftDay29Model==null){
      calendarLeftDay29Model = new ACComboBoxModelAdapter();
      addCalendarLeftDay29Model();
    }
    return calendarLeftDay29Model;
  }

  /**
   * 30���p�l�����擾���܂��B
   * @return 30���p�l��
   */
  public ACPanel getCalendarLeftDay30Panel(){
    if(calendarLeftDay30Panel==null){

      calendarLeftDay30Panel = new ACPanel();

      calendarLeftDay30Panel.setHgap(0);

      calendarLeftDay30Panel.setLabelMargin(0);

      calendarLeftDay30Panel.setVgap(0);

      addCalendarLeftDay30Panel();
    }
    return calendarLeftDay30Panel;

  }

  /**
   * 30���x�����擾���܂��B
   * @return 30���x��
   */
  public ACLabel getCalendarLeftDay30Label(){
    if(calendarLeftDay30Label==null){

      calendarLeftDay30Label = new ACLabel();

      calendarLeftDay30Label.setVisible(false);

      addCalendarLeftDay30Label();
    }
    return calendarLeftDay30Label;

  }

  /**
   * 30�����擾���܂��B
   * @return 30��
   */
  public ACComboBox getCalendarLeftDay30(){
    if(calendarLeftDay30==null){

      calendarLeftDay30 = new ACComboBox();

      calendarLeftDay30.setBindPath("CALENDAR_LEFT_DAY30");

      calendarLeftDay30.setEditable(false);

      calendarLeftDay30.setColumns(3);

      calendarLeftDay30.setModelBindPath("CALENDAR_LEFT30");

      calendarLeftDay30.setRenderBindPath("CALENDAR_DATA_STRING");

      calendarLeftDay30.setBlankable(false);

      calendarLeftDay30.setMaxColumns(3);

      calendarLeftDay30.setModel(getCalendarLeftDay30Model());

      addCalendarLeftDay30();
    }
    return calendarLeftDay30;

  }

  /**
   * 30�����f�����擾���܂��B
   * @return 30�����f��
   */
  protected ACComboBoxModelAdapter getCalendarLeftDay30Model(){
    if(calendarLeftDay30Model==null){
      calendarLeftDay30Model = new ACComboBoxModelAdapter();
      addCalendarLeftDay30Model();
    }
    return calendarLeftDay30Model;
  }

  /**
   * 31���p�l�����擾���܂��B
   * @return 31���p�l��
   */
  public ACPanel getCalendarLeftDay31Panel(){
    if(calendarLeftDay31Panel==null){

      calendarLeftDay31Panel = new ACPanel();

      calendarLeftDay31Panel.setHgap(0);

      calendarLeftDay31Panel.setLabelMargin(0);

      calendarLeftDay31Panel.setVgap(0);

      addCalendarLeftDay31Panel();
    }
    return calendarLeftDay31Panel;

  }

  /**
   * 31���x�����擾���܂��B
   * @return 31���x��
   */
  public ACLabel getCalendarLeftDay31Label(){
    if(calendarLeftDay31Label==null){

      calendarLeftDay31Label = new ACLabel();

      calendarLeftDay31Label.setVisible(false);

      addCalendarLeftDay31Label();
    }
    return calendarLeftDay31Label;

  }

  /**
   * 31�����擾���܂��B
   * @return 31��
   */
  public ACComboBox getCalendarLeftDay31(){
    if(calendarLeftDay31==null){

      calendarLeftDay31 = new ACComboBox();

      calendarLeftDay31.setBindPath("CALENDAR_LEFT_DAY31");

      calendarLeftDay31.setEditable(false);

      calendarLeftDay31.setColumns(3);

      calendarLeftDay31.setModelBindPath("CALENDAR_LEFT31");

      calendarLeftDay31.setRenderBindPath("CALENDAR_DATA_STRING");

      calendarLeftDay31.setBlankable(false);

      calendarLeftDay31.setMaxColumns(3);

      calendarLeftDay31.setModel(getCalendarLeftDay31Model());

      addCalendarLeftDay31();
    }
    return calendarLeftDay31;

  }

  /**
   * 31�����f�����擾���܂��B
   * @return 31�����f��
   */
  protected ACComboBoxModelAdapter getCalendarLeftDay31Model(){
    if(calendarLeftDay31Model==null){
      calendarLeftDay31Model = new ACComboBoxModelAdapter();
      addCalendarLeftDay31Model();
    }
    return calendarLeftDay31Model;
  }

  /**
   * �J�����_�[(�E�̈�)���擾���܂��B
   * @return �J�����_�[(�E�̈�)
   */
  public ACLabelContainer getCalendarRights(){
    if(calendarRights==null){

      calendarRights = new ACLabelContainer();

      calendarRights.setHgap(0);

      addCalendarRights();
    }
    return calendarRights;

  }

  /**
   * �J�����_�[(�E)�N���̈���擾���܂��B
   * @return �J�����_�[(�E)�N���̈�
   */
  public ACPanel getCalendarRightYearMonths(){
    if(calendarRightYearMonths==null){

      calendarRightYearMonths = new ACPanel();

      calendarRightYearMonths.setLayout(getCalendarRightYearMonthsLayout());

      addCalendarRightYearMonths();
    }
    return calendarRightYearMonths;

  }

  /**
   * �J�����_�[(�E)�N���̈惌�C�A�E�g���擾���܂��B
   * @return �J�����_�[(�E)�N���̈惌�C�A�E�g
   */
  public VRLayout getCalendarRightYearMonthsLayout(){
    if(calendarRightYearMonthsLayout==null){

      calendarRightYearMonthsLayout = new VRLayout();

      calendarRightYearMonthsLayout.setAlignment(SwingConstants.CENTER);

      calendarRightYearMonthsLayout.setAutoWrap(false);

      addCalendarRightYearMonthsLayout();
    }
    return calendarRightYearMonthsLayout;

  }

  /**
   * �����L���v�V�������擾���܂��B
   * @return �����L���v�V����
   */
  public ACLabel getCalendarRightCaption(){
    if(calendarRightCaption==null){

      calendarRightCaption = new ACLabel();

      calendarRightCaption.setText("����");

      addCalendarRightCaption();
    }
    return calendarRightCaption;

  }

  /**
   * �N���擾���܂��B
   * @return �N
   */
  public ACLabel getCalendarRightYear(){
    if(calendarRightYear==null){

      calendarRightYear = new ACLabel();

      calendarRightYear.setBindPath("CALENDAR_RIGHT_YEAR");

      addCalendarRightYear();
    }
    return calendarRightYear;

  }

  /**
   * �N�L���v�V�������擾���܂��B
   * @return �N�L���v�V����
   */
  public ACLabel getCalendarRightYearCaption(){
    if(calendarRightYearCaption==null){

      calendarRightYearCaption = new ACLabel();

      calendarRightYearCaption.setText("�N");

      addCalendarRightYearCaption();
    }
    return calendarRightYearCaption;

  }

  /**
   * �����擾���܂��B
   * @return ��
   */
  public ACLabel getCalendarRightMonth(){
    if(calendarRightMonth==null){

      calendarRightMonth = new ACLabel();

      calendarRightMonth.setBindPath("CALENDAR_RIGHT_MONTH");

      addCalendarRightMonth();
    }
    return calendarRightMonth;

  }

  /**
   * ���L���v�V�������擾���܂��B
   * @return ���L���v�V����
   */
  public ACLabel getCalendarRightMonthCaption(){
    if(calendarRightMonthCaption==null){

      calendarRightMonthCaption = new ACLabel();

      calendarRightMonthCaption.setText("��");

      addCalendarRightMonthCaption();
    }
    return calendarRightMonthCaption;

  }

  /**
   * �J�����_�[(�E���t�̈�)���擾���܂��B
   * @return �J�����_�[(�E���t�̈�)
   */
  public ACPanel getCalendarRightDayContainer(){
    if(calendarRightDayContainer==null){

      calendarRightDayContainer = new ACPanel();

      calendarRightDayContainer.setAutoWrap(false);

      calendarRightDayContainer.setHgap(0);

      calendarRightDayContainer.setVgap(0);

      addCalendarRightDayContainer();
    }
    return calendarRightDayContainer;

  }

  /**
   * 1�����擾���܂��B
   * @return 1��
   */
  public ACComboBox getCalendarRightDay01(){
    if(calendarRightDay01==null){

      calendarRightDay01 = new ACComboBox();

      calendarRightDay01.setBindPath("CALENDAR_RIGHT_DAY1");

      calendarRightDay01.setEditable(false);

      calendarRightDay01.setColumns(3);

      calendarRightDay01.setModelBindPath("CALENDAR_RIGHT1");

      calendarRightDay01.setRenderBindPath("CALENDAR_DATA_STRING");

      calendarRightDay01.setBlankable(false);

      calendarRightDay01.setMaxColumns(3);

      calendarRightDay01.setModel(getCalendarRightDay01Model());

      addCalendarRightDay01();
    }
    return calendarRightDay01;

  }

  /**
   * 1�����f�����擾���܂��B
   * @return 1�����f��
   */
  protected ACComboBoxModelAdapter getCalendarRightDay01Model(){
    if(calendarRightDay01Model==null){
      calendarRightDay01Model = new ACComboBoxModelAdapter();
      addCalendarRightDay01Model();
    }
    return calendarRightDay01Model;
  }

  /**
   * 2�����擾���܂��B
   * @return 2��
   */
  public ACComboBox getCalendarRightDay02(){
    if(calendarRightDay02==null){

      calendarRightDay02 = new ACComboBox();

      calendarRightDay02.setBindPath("CALENDAR_RIGHT_DAY2");

      calendarRightDay02.setEditable(false);

      calendarRightDay02.setColumns(3);

      calendarRightDay02.setModelBindPath("CALENDAR_RIGHT2");

      calendarRightDay02.setRenderBindPath("CALENDAR_DATA_STRING");

      calendarRightDay02.setBlankable(false);

      calendarRightDay02.setMaxColumns(3);

      calendarRightDay02.setModel(getCalendarRightDay02Model());

      addCalendarRightDay02();
    }
    return calendarRightDay02;

  }

  /**
   * 2�����f�����擾���܂��B
   * @return 2�����f��
   */
  protected ACComboBoxModelAdapter getCalendarRightDay02Model(){
    if(calendarRightDay02Model==null){
      calendarRightDay02Model = new ACComboBoxModelAdapter();
      addCalendarRightDay02Model();
    }
    return calendarRightDay02Model;
  }

  /**
   * 3�����擾���܂��B
   * @return 3��
   */
  public ACComboBox getCalendarRightDay03(){
    if(calendarRightDay03==null){

      calendarRightDay03 = new ACComboBox();

      calendarRightDay03.setBindPath("CALENDAR_RIGHT_DAY3");

      calendarRightDay03.setEditable(false);

      calendarRightDay03.setColumns(3);

      calendarRightDay03.setModelBindPath("CALENDAR_RIGHT3");

      calendarRightDay03.setRenderBindPath("CALENDAR_DATA_STRING");

      calendarRightDay03.setBlankable(false);

      calendarRightDay03.setMaxColumns(3);

      calendarRightDay03.setModel(getCalendarRightDay03Model());

      addCalendarRightDay03();
    }
    return calendarRightDay03;

  }

  /**
   * 3�����f�����擾���܂��B
   * @return 3�����f��
   */
  protected ACComboBoxModelAdapter getCalendarRightDay03Model(){
    if(calendarRightDay03Model==null){
      calendarRightDay03Model = new ACComboBoxModelAdapter();
      addCalendarRightDay03Model();
    }
    return calendarRightDay03Model;
  }

  /**
   * 4�����擾���܂��B
   * @return 4��
   */
  public ACComboBox getCalendarRightDay04(){
    if(calendarRightDay04==null){

      calendarRightDay04 = new ACComboBox();

      calendarRightDay04.setBindPath("CALENDAR_RIGHT_DAY4");

      calendarRightDay04.setEditable(false);

      calendarRightDay04.setColumns(3);

      calendarRightDay04.setModelBindPath("CALENDAR_RIGHT4");

      calendarRightDay04.setRenderBindPath("CALENDAR_DATA_STRING");

      calendarRightDay04.setBlankable(false);

      calendarRightDay04.setMaxColumns(3);

      calendarRightDay04.setModel(getCalendarRightDay04Model());

      addCalendarRightDay04();
    }
    return calendarRightDay04;

  }

  /**
   * 4�����f�����擾���܂��B
   * @return 4�����f��
   */
  protected ACComboBoxModelAdapter getCalendarRightDay04Model(){
    if(calendarRightDay04Model==null){
      calendarRightDay04Model = new ACComboBoxModelAdapter();
      addCalendarRightDay04Model();
    }
    return calendarRightDay04Model;
  }

  /**
   * 5�����擾���܂��B
   * @return 5��
   */
  public ACComboBox getCalendarRightDay05(){
    if(calendarRightDay05==null){

      calendarRightDay05 = new ACComboBox();

      calendarRightDay05.setBindPath("CALENDAR_RIGHT_DAY5");

      calendarRightDay05.setEditable(false);

      calendarRightDay05.setColumns(3);

      calendarRightDay05.setModelBindPath("CALENDAR_RIGHT5");

      calendarRightDay05.setRenderBindPath("CALENDAR_DATA_STRING");

      calendarRightDay05.setBlankable(false);

      calendarRightDay05.setMaxColumns(3);

      calendarRightDay05.setModel(getCalendarRightDay05Model());

      addCalendarRightDay05();
    }
    return calendarRightDay05;

  }

  /**
   * 5�����f�����擾���܂��B
   * @return 5�����f��
   */
  protected ACComboBoxModelAdapter getCalendarRightDay05Model(){
    if(calendarRightDay05Model==null){
      calendarRightDay05Model = new ACComboBoxModelAdapter();
      addCalendarRightDay05Model();
    }
    return calendarRightDay05Model;
  }

  /**
   * 6�����擾���܂��B
   * @return 6��
   */
  public ACComboBox getCalendarRightDay06(){
    if(calendarRightDay06==null){

      calendarRightDay06 = new ACComboBox();

      calendarRightDay06.setBindPath("CALENDAR_RIGHT_DAY6");

      calendarRightDay06.setEditable(false);

      calendarRightDay06.setColumns(3);

      calendarRightDay06.setModelBindPath("CALENDAR_RIGHT6");

      calendarRightDay06.setRenderBindPath("CALENDAR_DATA_STRING");

      calendarRightDay06.setBlankable(false);

      calendarRightDay06.setMaxColumns(3);

      calendarRightDay06.setModel(getCalendarRightDay06Model());

      addCalendarRightDay06();
    }
    return calendarRightDay06;

  }

  /**
   * 6�����f�����擾���܂��B
   * @return 6�����f��
   */
  protected ACComboBoxModelAdapter getCalendarRightDay06Model(){
    if(calendarRightDay06Model==null){
      calendarRightDay06Model = new ACComboBoxModelAdapter();
      addCalendarRightDay06Model();
    }
    return calendarRightDay06Model;
  }

  /**
   * 7�����擾���܂��B
   * @return 7��
   */
  public ACComboBox getCalendarRightDay07(){
    if(calendarRightDay07==null){

      calendarRightDay07 = new ACComboBox();

      calendarRightDay07.setBindPath("CALENDAR_RIGHT_DAY7");

      calendarRightDay07.setEditable(false);

      calendarRightDay07.setColumns(3);

      calendarRightDay07.setModelBindPath("CALENDAR_RIGHT7");

      calendarRightDay07.setRenderBindPath("CALENDAR_DATA_STRING");

      calendarRightDay07.setBlankable(false);

      calendarRightDay07.setMaxColumns(3);

      calendarRightDay07.setModel(getCalendarRightDay07Model());

      addCalendarRightDay07();
    }
    return calendarRightDay07;

  }

  /**
   * 7�����f�����擾���܂��B
   * @return 7�����f��
   */
  protected ACComboBoxModelAdapter getCalendarRightDay07Model(){
    if(calendarRightDay07Model==null){
      calendarRightDay07Model = new ACComboBoxModelAdapter();
      addCalendarRightDay07Model();
    }
    return calendarRightDay07Model;
  }

  /**
   * 8�����擾���܂��B
   * @return 8��
   */
  public ACComboBox getCalendarRightDay08(){
    if(calendarRightDay08==null){

      calendarRightDay08 = new ACComboBox();

      calendarRightDay08.setBindPath("CALENDAR_RIGHT_DAY8");

      calendarRightDay08.setEditable(false);

      calendarRightDay08.setColumns(3);

      calendarRightDay08.setModelBindPath("CALENDAR_RIGHT8");

      calendarRightDay08.setRenderBindPath("CALENDAR_DATA_STRING");

      calendarRightDay08.setBlankable(false);

      calendarRightDay08.setMaxColumns(3);

      calendarRightDay08.setModel(getCalendarRightDay08Model());

      addCalendarRightDay08();
    }
    return calendarRightDay08;

  }

  /**
   * 8�����f�����擾���܂��B
   * @return 8�����f��
   */
  protected ACComboBoxModelAdapter getCalendarRightDay08Model(){
    if(calendarRightDay08Model==null){
      calendarRightDay08Model = new ACComboBoxModelAdapter();
      addCalendarRightDay08Model();
    }
    return calendarRightDay08Model;
  }

  /**
   * 9�����擾���܂��B
   * @return 9��
   */
  public ACComboBox getCalendarRightDay09(){
    if(calendarRightDay09==null){

      calendarRightDay09 = new ACComboBox();

      calendarRightDay09.setBindPath("CALENDAR_RIGHT_DAY9");

      calendarRightDay09.setEditable(false);

      calendarRightDay09.setColumns(3);

      calendarRightDay09.setModelBindPath("CALENDAR_RIGHT9");

      calendarRightDay09.setRenderBindPath("CALENDAR_DATA_STRING");

      calendarRightDay09.setBlankable(false);

      calendarRightDay09.setMaxColumns(3);

      calendarRightDay09.setModel(getCalendarRightDay09Model());

      addCalendarRightDay09();
    }
    return calendarRightDay09;

  }

  /**
   * 9�����f�����擾���܂��B
   * @return 9�����f��
   */
  protected ACComboBoxModelAdapter getCalendarRightDay09Model(){
    if(calendarRightDay09Model==null){
      calendarRightDay09Model = new ACComboBoxModelAdapter();
      addCalendarRightDay09Model();
    }
    return calendarRightDay09Model;
  }

  /**
   * 10�����擾���܂��B
   * @return 10��
   */
  public ACComboBox getCalendarRightDay10(){
    if(calendarRightDay10==null){

      calendarRightDay10 = new ACComboBox();

      calendarRightDay10.setBindPath("CALENDAR_RIGHT_DAY10");

      calendarRightDay10.setEditable(false);

      calendarRightDay10.setColumns(3);

      calendarRightDay10.setModelBindPath("CALENDAR_RIGHT10");

      calendarRightDay10.setRenderBindPath("CALENDAR_DATA_STRING");

      calendarRightDay10.setBlankable(false);

      calendarRightDay10.setMaxColumns(3);

      calendarRightDay10.setModel(getCalendarRightDay10Model());

      addCalendarRightDay10();
    }
    return calendarRightDay10;

  }

  /**
   * 10�����f�����擾���܂��B
   * @return 10�����f��
   */
  protected ACComboBoxModelAdapter getCalendarRightDay10Model(){
    if(calendarRightDay10Model==null){
      calendarRightDay10Model = new ACComboBoxModelAdapter();
      addCalendarRightDay10Model();
    }
    return calendarRightDay10Model;
  }

  /**
   * 11�����擾���܂��B
   * @return 11��
   */
  public ACComboBox getCalendarRightDay11(){
    if(calendarRightDay11==null){

      calendarRightDay11 = new ACComboBox();

      calendarRightDay11.setBindPath("CALENDAR_RIGHT_DAY11");

      calendarRightDay11.setEditable(false);

      calendarRightDay11.setColumns(3);

      calendarRightDay11.setModelBindPath("CALENDAR_RIGHT11");

      calendarRightDay11.setRenderBindPath("CALENDAR_DATA_STRING");

      calendarRightDay11.setBlankable(false);

      calendarRightDay11.setMaxColumns(3);

      calendarRightDay11.setModel(getCalendarRightDay11Model());

      addCalendarRightDay11();
    }
    return calendarRightDay11;

  }

  /**
   * 11�����f�����擾���܂��B
   * @return 11�����f��
   */
  protected ACComboBoxModelAdapter getCalendarRightDay11Model(){
    if(calendarRightDay11Model==null){
      calendarRightDay11Model = new ACComboBoxModelAdapter();
      addCalendarRightDay11Model();
    }
    return calendarRightDay11Model;
  }

  /**
   * 12�����擾���܂��B
   * @return 12��
   */
  public ACComboBox getCalendarRightDay12(){
    if(calendarRightDay12==null){

      calendarRightDay12 = new ACComboBox();

      calendarRightDay12.setBindPath("CALENDAR_RIGHT_DAY12");

      calendarRightDay12.setEditable(false);

      calendarRightDay12.setColumns(3);

      calendarRightDay12.setModelBindPath("CALENDAR_RIGHT12");

      calendarRightDay12.setRenderBindPath("CALENDAR_DATA_STRING");

      calendarRightDay12.setBlankable(false);

      calendarRightDay12.setMaxColumns(3);

      calendarRightDay12.setModel(getCalendarRightDay12Model());

      addCalendarRightDay12();
    }
    return calendarRightDay12;

  }

  /**
   * 12�����f�����擾���܂��B
   * @return 12�����f��
   */
  protected ACComboBoxModelAdapter getCalendarRightDay12Model(){
    if(calendarRightDay12Model==null){
      calendarRightDay12Model = new ACComboBoxModelAdapter();
      addCalendarRightDay12Model();
    }
    return calendarRightDay12Model;
  }

  /**
   * 13�����擾���܂��B
   * @return 13��
   */
  public ACComboBox getCalendarRightDay13(){
    if(calendarRightDay13==null){

      calendarRightDay13 = new ACComboBox();

      calendarRightDay13.setBindPath("CALENDAR_RIGHT_DAY13");

      calendarRightDay13.setEditable(false);

      calendarRightDay13.setColumns(3);

      calendarRightDay13.setModelBindPath("CALENDAR_RIGHT13");

      calendarRightDay13.setRenderBindPath("CALENDAR_DATA_STRING");

      calendarRightDay13.setBlankable(false);

      calendarRightDay13.setMaxColumns(3);

      calendarRightDay13.setModel(getCalendarRightDay13Model());

      addCalendarRightDay13();
    }
    return calendarRightDay13;

  }

  /**
   * 13�����f�����擾���܂��B
   * @return 13�����f��
   */
  protected ACComboBoxModelAdapter getCalendarRightDay13Model(){
    if(calendarRightDay13Model==null){
      calendarRightDay13Model = new ACComboBoxModelAdapter();
      addCalendarRightDay13Model();
    }
    return calendarRightDay13Model;
  }

  /**
   * 14�����擾���܂��B
   * @return 14��
   */
  public ACComboBox getCalendarRightDay14(){
    if(calendarRightDay14==null){

      calendarRightDay14 = new ACComboBox();

      calendarRightDay14.setBindPath("CALENDAR_RIGHT_DAY14");

      calendarRightDay14.setEditable(false);

      calendarRightDay14.setColumns(3);

      calendarRightDay14.setModelBindPath("CALENDAR_RIGHT14");

      calendarRightDay14.setRenderBindPath("CALENDAR_DATA_STRING");

      calendarRightDay14.setBlankable(false);

      calendarRightDay14.setMaxColumns(3);

      calendarRightDay14.setModel(getCalendarRightDay14Model());

      addCalendarRightDay14();
    }
    return calendarRightDay14;

  }

  /**
   * 14�����f�����擾���܂��B
   * @return 14�����f��
   */
  protected ACComboBoxModelAdapter getCalendarRightDay14Model(){
    if(calendarRightDay14Model==null){
      calendarRightDay14Model = new ACComboBoxModelAdapter();
      addCalendarRightDay14Model();
    }
    return calendarRightDay14Model;
  }

  /**
   * 15�����擾���܂��B
   * @return 15��
   */
  public ACComboBox getCalendarRightDay15(){
    if(calendarRightDay15==null){

      calendarRightDay15 = new ACComboBox();

      calendarRightDay15.setBindPath("CALENDAR_RIGHT_DAY15");

      calendarRightDay15.setEditable(false);

      calendarRightDay15.setColumns(3);

      calendarRightDay15.setModelBindPath("CALENDAR_RIGHT15");

      calendarRightDay15.setRenderBindPath("CALENDAR_DATA_STRING");

      calendarRightDay15.setBlankable(false);

      calendarRightDay15.setMaxColumns(3);

      calendarRightDay15.setModel(getCalendarRightDay15Model());

      addCalendarRightDay15();
    }
    return calendarRightDay15;

  }

  /**
   * 15�����f�����擾���܂��B
   * @return 15�����f��
   */
  protected ACComboBoxModelAdapter getCalendarRightDay15Model(){
    if(calendarRightDay15Model==null){
      calendarRightDay15Model = new ACComboBoxModelAdapter();
      addCalendarRightDay15Model();
    }
    return calendarRightDay15Model;
  }

  /**
   * 16�����擾���܂��B
   * @return 16��
   */
  public ACComboBox getCalendarRightDay16(){
    if(calendarRightDay16==null){

      calendarRightDay16 = new ACComboBox();

      calendarRightDay16.setBindPath("CALENDAR_RIGHT_DAY16");

      calendarRightDay16.setEditable(false);

      calendarRightDay16.setColumns(3);

      calendarRightDay16.setModelBindPath("CALENDAR_RIGHT16");

      calendarRightDay16.setRenderBindPath("CALENDAR_DATA_STRING");

      calendarRightDay16.setBlankable(false);

      calendarRightDay16.setMaxColumns(3);

      calendarRightDay16.setModel(getCalendarRightDay16Model());

      addCalendarRightDay16();
    }
    return calendarRightDay16;

  }

  /**
   * 16�����f�����擾���܂��B
   * @return 16�����f��
   */
  protected ACComboBoxModelAdapter getCalendarRightDay16Model(){
    if(calendarRightDay16Model==null){
      calendarRightDay16Model = new ACComboBoxModelAdapter();
      addCalendarRightDay16Model();
    }
    return calendarRightDay16Model;
  }

  /**
   * 17�����擾���܂��B
   * @return 17��
   */
  public ACComboBox getCalendarRightDay17(){
    if(calendarRightDay17==null){

      calendarRightDay17 = new ACComboBox();

      calendarRightDay17.setBindPath("CALENDAR_RIGHT_DAY17");

      calendarRightDay17.setEditable(false);

      calendarRightDay17.setColumns(3);

      calendarRightDay17.setModelBindPath("CALENDAR_RIGHT17");

      calendarRightDay17.setRenderBindPath("CALENDAR_DATA_STRING");

      calendarRightDay17.setBlankable(false);

      calendarRightDay17.setMaxColumns(3);

      calendarRightDay17.setModel(getCalendarRightDay17Model());

      addCalendarRightDay17();
    }
    return calendarRightDay17;

  }

  /**
   * 17�����f�����擾���܂��B
   * @return 17�����f��
   */
  protected ACComboBoxModelAdapter getCalendarRightDay17Model(){
    if(calendarRightDay17Model==null){
      calendarRightDay17Model = new ACComboBoxModelAdapter();
      addCalendarRightDay17Model();
    }
    return calendarRightDay17Model;
  }

  /**
   * 18�����擾���܂��B
   * @return 18��
   */
  public ACComboBox getCalendarRightDay18(){
    if(calendarRightDay18==null){

      calendarRightDay18 = new ACComboBox();

      calendarRightDay18.setBindPath("CALENDAR_RIGHT_DAY18");

      calendarRightDay18.setEditable(false);

      calendarRightDay18.setColumns(3);

      calendarRightDay18.setModelBindPath("CALENDAR_RIGHT18");

      calendarRightDay18.setRenderBindPath("CALENDAR_DATA_STRING");

      calendarRightDay18.setBlankable(false);

      calendarRightDay18.setMaxColumns(3);

      calendarRightDay18.setModel(getCalendarRightDay18Model());

      addCalendarRightDay18();
    }
    return calendarRightDay18;

  }

  /**
   * 18�����f�����擾���܂��B
   * @return 18�����f��
   */
  protected ACComboBoxModelAdapter getCalendarRightDay18Model(){
    if(calendarRightDay18Model==null){
      calendarRightDay18Model = new ACComboBoxModelAdapter();
      addCalendarRightDay18Model();
    }
    return calendarRightDay18Model;
  }

  /**
   * 19�����擾���܂��B
   * @return 19��
   */
  public ACComboBox getCalendarRightDay19(){
    if(calendarRightDay19==null){

      calendarRightDay19 = new ACComboBox();

      calendarRightDay19.setBindPath("CALENDAR_RIGHT_DAY19");

      calendarRightDay19.setEditable(false);

      calendarRightDay19.setColumns(3);

      calendarRightDay19.setModelBindPath("CALENDAR_RIGHT19");

      calendarRightDay19.setRenderBindPath("CALENDAR_DATA_STRING");

      calendarRightDay19.setBlankable(false);

      calendarRightDay19.setMaxColumns(3);

      calendarRightDay19.setModel(getCalendarRightDay19Model());

      addCalendarRightDay19();
    }
    return calendarRightDay19;

  }

  /**
   * 19�����f�����擾���܂��B
   * @return 19�����f��
   */
  protected ACComboBoxModelAdapter getCalendarRightDay19Model(){
    if(calendarRightDay19Model==null){
      calendarRightDay19Model = new ACComboBoxModelAdapter();
      addCalendarRightDay19Model();
    }
    return calendarRightDay19Model;
  }

  /**
   * 20�����擾���܂��B
   * @return 20��
   */
  public ACComboBox getCalendarRightDay20(){
    if(calendarRightDay20==null){

      calendarRightDay20 = new ACComboBox();

      calendarRightDay20.setBindPath("CALENDAR_RIGHT_DAY20");

      calendarRightDay20.setEditable(false);

      calendarRightDay20.setColumns(3);

      calendarRightDay20.setModelBindPath("CALENDAR_RIGHT20");

      calendarRightDay20.setRenderBindPath("CALENDAR_DATA_STRING");

      calendarRightDay20.setBlankable(false);

      calendarRightDay20.setMaxColumns(3);

      calendarRightDay20.setModel(getCalendarRightDay20Model());

      addCalendarRightDay20();
    }
    return calendarRightDay20;

  }

  /**
   * 20�����f�����擾���܂��B
   * @return 20�����f��
   */
  protected ACComboBoxModelAdapter getCalendarRightDay20Model(){
    if(calendarRightDay20Model==null){
      calendarRightDay20Model = new ACComboBoxModelAdapter();
      addCalendarRightDay20Model();
    }
    return calendarRightDay20Model;
  }

  /**
   * 21�����擾���܂��B
   * @return 21��
   */
  public ACComboBox getCalendarRightDay21(){
    if(calendarRightDay21==null){

      calendarRightDay21 = new ACComboBox();

      calendarRightDay21.setBindPath("CALENDAR_RIGHT_DAY21");

      calendarRightDay21.setEditable(false);

      calendarRightDay21.setColumns(3);

      calendarRightDay21.setModelBindPath("CALENDAR_RIGHT21");

      calendarRightDay21.setRenderBindPath("CALENDAR_DATA_STRING");

      calendarRightDay21.setBlankable(false);

      calendarRightDay21.setMaxColumns(3);

      calendarRightDay21.setModel(getCalendarRightDay21Model());

      addCalendarRightDay21();
    }
    return calendarRightDay21;

  }

  /**
   * 21�����f�����擾���܂��B
   * @return 21�����f��
   */
  protected ACComboBoxModelAdapter getCalendarRightDay21Model(){
    if(calendarRightDay21Model==null){
      calendarRightDay21Model = new ACComboBoxModelAdapter();
      addCalendarRightDay21Model();
    }
    return calendarRightDay21Model;
  }

  /**
   * 22�����擾���܂��B
   * @return 22��
   */
  public ACComboBox getCalendarRightDay22(){
    if(calendarRightDay22==null){

      calendarRightDay22 = new ACComboBox();

      calendarRightDay22.setBindPath("CALENDAR_RIGHT_DAY22");

      calendarRightDay22.setEditable(false);

      calendarRightDay22.setColumns(3);

      calendarRightDay22.setModelBindPath("CALENDAR_RIGHT22");

      calendarRightDay22.setRenderBindPath("CALENDAR_DATA_STRING");

      calendarRightDay22.setBlankable(false);

      calendarRightDay22.setMaxColumns(3);

      calendarRightDay22.setModel(getCalendarRightDay22Model());

      addCalendarRightDay22();
    }
    return calendarRightDay22;

  }

  /**
   * 22�����f�����擾���܂��B
   * @return 22�����f��
   */
  protected ACComboBoxModelAdapter getCalendarRightDay22Model(){
    if(calendarRightDay22Model==null){
      calendarRightDay22Model = new ACComboBoxModelAdapter();
      addCalendarRightDay22Model();
    }
    return calendarRightDay22Model;
  }

  /**
   * 23�����擾���܂��B
   * @return 23��
   */
  public ACComboBox getCalendarRightDay23(){
    if(calendarRightDay23==null){

      calendarRightDay23 = new ACComboBox();

      calendarRightDay23.setBindPath("CALENDAR_RIGHT_DAY23");

      calendarRightDay23.setEditable(false);

      calendarRightDay23.setColumns(3);

      calendarRightDay23.setModelBindPath("CALENDAR_RIGHT23");

      calendarRightDay23.setRenderBindPath("CALENDAR_DATA_STRING");

      calendarRightDay23.setBlankable(false);

      calendarRightDay23.setMaxColumns(3);

      calendarRightDay23.setModel(getCalendarRightDay23Model());

      addCalendarRightDay23();
    }
    return calendarRightDay23;

  }

  /**
   * 23�����f�����擾���܂��B
   * @return 23�����f��
   */
  protected ACComboBoxModelAdapter getCalendarRightDay23Model(){
    if(calendarRightDay23Model==null){
      calendarRightDay23Model = new ACComboBoxModelAdapter();
      addCalendarRightDay23Model();
    }
    return calendarRightDay23Model;
  }

  /**
   * 24�����擾���܂��B
   * @return 24��
   */
  public ACComboBox getCalendarRightDay24(){
    if(calendarRightDay24==null){

      calendarRightDay24 = new ACComboBox();

      calendarRightDay24.setBindPath("CALENDAR_RIGHT_DAY24");

      calendarRightDay24.setEditable(false);

      calendarRightDay24.setColumns(3);

      calendarRightDay24.setModelBindPath("CALENDAR_RIGHT24");

      calendarRightDay24.setRenderBindPath("CALENDAR_DATA_STRING");

      calendarRightDay24.setBlankable(false);

      calendarRightDay24.setMaxColumns(3);

      calendarRightDay24.setModel(getCalendarRightDay24Model());

      addCalendarRightDay24();
    }
    return calendarRightDay24;

  }

  /**
   * 24�����f�����擾���܂��B
   * @return 24�����f��
   */
  protected ACComboBoxModelAdapter getCalendarRightDay24Model(){
    if(calendarRightDay24Model==null){
      calendarRightDay24Model = new ACComboBoxModelAdapter();
      addCalendarRightDay24Model();
    }
    return calendarRightDay24Model;
  }

  /**
   * 25�����擾���܂��B
   * @return 25��
   */
  public ACComboBox getCalendarRightDay25(){
    if(calendarRightDay25==null){

      calendarRightDay25 = new ACComboBox();

      calendarRightDay25.setBindPath("CALENDAR_RIGHT_DAY25");

      calendarRightDay25.setEditable(false);

      calendarRightDay25.setColumns(3);

      calendarRightDay25.setModelBindPath("CALENDAR_RIGHT25");

      calendarRightDay25.setRenderBindPath("CALENDAR_DATA_STRING");

      calendarRightDay25.setBlankable(false);

      calendarRightDay25.setMaxColumns(3);

      calendarRightDay25.setModel(getCalendarRightDay25Model());

      addCalendarRightDay25();
    }
    return calendarRightDay25;

  }

  /**
   * 25�����f�����擾���܂��B
   * @return 25�����f��
   */
  protected ACComboBoxModelAdapter getCalendarRightDay25Model(){
    if(calendarRightDay25Model==null){
      calendarRightDay25Model = new ACComboBoxModelAdapter();
      addCalendarRightDay25Model();
    }
    return calendarRightDay25Model;
  }

  /**
   * 26�����擾���܂��B
   * @return 26��
   */
  public ACComboBox getCalendarRightDay26(){
    if(calendarRightDay26==null){

      calendarRightDay26 = new ACComboBox();

      calendarRightDay26.setBindPath("CALENDAR_RIGHT_DAY26");

      calendarRightDay26.setEditable(false);

      calendarRightDay26.setColumns(3);

      calendarRightDay26.setModelBindPath("CALENDAR_RIGHT26");

      calendarRightDay26.setRenderBindPath("CALENDAR_DATA_STRING");

      calendarRightDay26.setBlankable(false);

      calendarRightDay26.setMaxColumns(3);

      calendarRightDay26.setModel(getCalendarRightDay26Model());

      addCalendarRightDay26();
    }
    return calendarRightDay26;

  }

  /**
   * 26�����f�����擾���܂��B
   * @return 26�����f��
   */
  protected ACComboBoxModelAdapter getCalendarRightDay26Model(){
    if(calendarRightDay26Model==null){
      calendarRightDay26Model = new ACComboBoxModelAdapter();
      addCalendarRightDay26Model();
    }
    return calendarRightDay26Model;
  }

  /**
   * 27�����擾���܂��B
   * @return 27��
   */
  public ACComboBox getCalendarRightDay27(){
    if(calendarRightDay27==null){

      calendarRightDay27 = new ACComboBox();

      calendarRightDay27.setBindPath("CALENDAR_RIGHT_DAY27");

      calendarRightDay27.setEditable(false);

      calendarRightDay27.setColumns(3);

      calendarRightDay27.setModelBindPath("CALENDAR_RIGHT27");

      calendarRightDay27.setRenderBindPath("CALENDAR_DATA_STRING");

      calendarRightDay27.setBlankable(false);

      calendarRightDay27.setMaxColumns(3);

      calendarRightDay27.setModel(getCalendarRightDay27Model());

      addCalendarRightDay27();
    }
    return calendarRightDay27;

  }

  /**
   * 27�����f�����擾���܂��B
   * @return 27�����f��
   */
  protected ACComboBoxModelAdapter getCalendarRightDay27Model(){
    if(calendarRightDay27Model==null){
      calendarRightDay27Model = new ACComboBoxModelAdapter();
      addCalendarRightDay27Model();
    }
    return calendarRightDay27Model;
  }

  /**
   * 28�����擾���܂��B
   * @return 28��
   */
  public ACComboBox getCalendarRightDay28(){
    if(calendarRightDay28==null){

      calendarRightDay28 = new ACComboBox();

      calendarRightDay28.setBindPath("CALENDAR_RIGHT_DAY28");

      calendarRightDay28.setEditable(false);

      calendarRightDay28.setColumns(3);

      calendarRightDay28.setModelBindPath("CALENDAR_RIGHT28");

      calendarRightDay28.setRenderBindPath("CALENDAR_DATA_STRING");

      calendarRightDay28.setBlankable(false);

      calendarRightDay28.setMaxColumns(3);

      calendarRightDay28.setModel(getCalendarRightDay28Model());

      addCalendarRightDay28();
    }
    return calendarRightDay28;

  }

  /**
   * 28�����f�����擾���܂��B
   * @return 28�����f��
   */
  protected ACComboBoxModelAdapter getCalendarRightDay28Model(){
    if(calendarRightDay28Model==null){
      calendarRightDay28Model = new ACComboBoxModelAdapter();
      addCalendarRightDay28Model();
    }
    return calendarRightDay28Model;
  }

  /**
   * 29���p�l�����擾���܂��B
   * @return 29���p�l��
   */
  public ACPanel getCalendarRightDay29Panel(){
    if(calendarRightDay29Panel==null){

      calendarRightDay29Panel = new ACPanel();

      addCalendarRightDay29Panel();
    }
    return calendarRightDay29Panel;

  }

  /**
   * 29���x�����擾���܂��B
   * @return 29���x��
   */
  public ACLabel getCalendarRightDay29Label(){
    if(calendarRightDay29Label==null){

      calendarRightDay29Label = new ACLabel();

      calendarRightDay29Label.setVisible(false);

      addCalendarRightDay29Label();
    }
    return calendarRightDay29Label;

  }

  /**
   * 29�����擾���܂��B
   * @return 29��
   */
  public ACComboBox getCalendarRightDay29(){
    if(calendarRightDay29==null){

      calendarRightDay29 = new ACComboBox();

      calendarRightDay29.setBindPath("CALENDAR_RIGHT_DAY29");

      calendarRightDay29.setEditable(false);

      calendarRightDay29.setColumns(3);

      calendarRightDay29.setModelBindPath("CALENDAR_RIGHT29");

      calendarRightDay29.setRenderBindPath("CALENDAR_DATA_STRING");

      calendarRightDay29.setBlankable(false);

      calendarRightDay29.setMaxColumns(3);

      calendarRightDay29.setModel(getCalendarRightDay29Model());

      addCalendarRightDay29();
    }
    return calendarRightDay29;

  }

  /**
   * 29�����f�����擾���܂��B
   * @return 29�����f��
   */
  protected ACComboBoxModelAdapter getCalendarRightDay29Model(){
    if(calendarRightDay29Model==null){
      calendarRightDay29Model = new ACComboBoxModelAdapter();
      addCalendarRightDay29Model();
    }
    return calendarRightDay29Model;
  }

  /**
   * 30���p�l�����擾���܂��B
   * @return 30���p�l��
   */
  public ACPanel getCalendarRightDay30Panel(){
    if(calendarRightDay30Panel==null){

      calendarRightDay30Panel = new ACPanel();

      addCalendarRightDay30Panel();
    }
    return calendarRightDay30Panel;

  }

  /**
   * 30���x�����擾���܂��B
   * @return 30���x��
   */
  public ACLabel getCalendarRightDay30Label(){
    if(calendarRightDay30Label==null){

      calendarRightDay30Label = new ACLabel();

      calendarRightDay30Label.setVisible(false);

      addCalendarRightDay30Label();
    }
    return calendarRightDay30Label;

  }

  /**
   * 30�����擾���܂��B
   * @return 30��
   */
  public ACComboBox getCalendarRightDay30(){
    if(calendarRightDay30==null){

      calendarRightDay30 = new ACComboBox();

      calendarRightDay30.setBindPath("CALENDAR_RIGHT_DAY30");

      calendarRightDay30.setEditable(false);

      calendarRightDay30.setColumns(3);

      calendarRightDay30.setModelBindPath("CALENDAR_RIGHT30");

      calendarRightDay30.setRenderBindPath("CALENDAR_DATA_STRING");

      calendarRightDay30.setBlankable(false);

      calendarRightDay30.setMaxColumns(3);

      calendarRightDay30.setModel(getCalendarRightDay30Model());

      addCalendarRightDay30();
    }
    return calendarRightDay30;

  }

  /**
   * 30�����f�����擾���܂��B
   * @return 30�����f��
   */
  protected ACComboBoxModelAdapter getCalendarRightDay30Model(){
    if(calendarRightDay30Model==null){
      calendarRightDay30Model = new ACComboBoxModelAdapter();
      addCalendarRightDay30Model();
    }
    return calendarRightDay30Model;
  }

  /**
   * 31���p�l�����擾���܂��B
   * @return 31���p�l��
   */
  public ACPanel getCalendarRightDay31Panel(){
    if(calendarRightDay31Panel==null){

      calendarRightDay31Panel = new ACPanel();

      addCalendarRightDay31Panel();
    }
    return calendarRightDay31Panel;

  }

  /**
   * 31���x�����擾���܂��B
   * @return 31���x��
   */
  public ACLabel getCalendarRightDay31Label(){
    if(calendarRightDay31Label==null){

      calendarRightDay31Label = new ACLabel();

      calendarRightDay31Label.setVisible(false);

      addCalendarRightDay31Label();
    }
    return calendarRightDay31Label;

  }

  /**
   * 31�����擾���܂��B
   * @return 31��
   */
  public ACComboBox getCalendarRightDay31(){
    if(calendarRightDay31==null){

      calendarRightDay31 = new ACComboBox();

      calendarRightDay31.setBindPath("CALENDAR_RIGHT_DAY31");

      calendarRightDay31.setEditable(false);

      calendarRightDay31.setColumns(3);

      calendarRightDay31.setModelBindPath("CALENDAR_RIGHT31");

      calendarRightDay31.setRenderBindPath("CALENDAR_DATA_STRING");

      calendarRightDay31.setBlankable(false);

      calendarRightDay31.setMaxColumns(3);

      calendarRightDay31.setModel(getCalendarRightDay31Model());

      addCalendarRightDay31();
    }
    return calendarRightDay31;

  }

  /**
   * 31�����f�����擾���܂��B
   * @return 31�����f��
   */
  protected ACComboBoxModelAdapter getCalendarRightDay31Model(){
    if(calendarRightDay31Model==null){
      calendarRightDay31Model = new ACComboBoxModelAdapter();
      addCalendarRightDay31Model();
    }
    return calendarRightDay31Model;
  }

  /**
   * �{�^���̈���擾���܂��B
   * @return �{�^���̈�
   */
  public ACPanel getResultButtonPanel(){
    if(resultButtonPanel==null){

      resultButtonPanel = new ACPanel();

      addResultButtonPanel();
    }
    return resultButtonPanel;

  }

  /**
   * �p�l�����擾���܂��B
   * @return �p�l��
   */
  public ACPanel getResultButtonPanelLeft(){
    if(resultButtonPanelLeft==null){

      resultButtonPanelLeft = new ACPanel();

      addResultButtonPanelLeft();
    }
    return resultButtonPanelLeft;

  }

  /**
   * �{�^�����擾���܂��B
   * @return �{�^��
   */
  public ACButton getResultReadButtonLeft(){
    if(resultReadButtonLeft==null){

      resultReadButtonLeft = new ACButton();

      resultReadButtonLeft.setText("���ѓǍ�");

      addResultReadButtonLeft();
    }
    return resultReadButtonLeft;

  }

  /**
   * �p�l�����擾���܂��B
   * @return �p�l��
   */
  public ACPanel getResultButtonPanelRight(){
    if(resultButtonPanelRight==null){

      resultButtonPanelRight = new ACPanel();

      addResultButtonPanelRight();
    }
    return resultButtonPanelRight;

  }

  /**
   * �{�^�����擾���܂��B
   * @return �{�^��
   */
  public ACButton getResultReadButtonRight(){
    if(resultReadButtonRight==null){

      resultReadButtonRight = new ACButton();

      resultReadButtonRight.setText("���ѓǍ�");

      addResultReadButtonRight();
    }
    return resultReadButtonRight;

  }

  /**
   * �������̈���擾���܂��B
   * @return �������̈�
   */
  public ACPanel getMemos(){
    if(memos==null){

      memos = new ACPanel();

      addMemos();
    }
    return memos;

  }

  /**
   * ������1���擾���܂��B
   * @return ������1
   */
  public ACLabel getMemo1(){
    if(memo1==null){

      memo1 = new ACLabel();

      memo1.setText("�K��������ň͂ނ��ƁB�P���ɂQ��K�₵�����́��ň͂ނ��ƁB");

      addMemo1();
    }
    return memo1;

  }

  /**
   * ������6(�ǉ��j���擾���܂��B
   * @return ������6(�ǉ��j
   */
  public ACLabel getMemo6(){
    if(memo6==null){

      memo6 = new ACLabel();

      memo6.setText("�P���ɂR��ȏ�K�₵�����́��ň͂ނ��ƁB");

      addMemo6();
    }
    return memo6;

  }

  /**
   * ������2���擾���܂��B
   * @return ������2
   */
  public ACLabel getMemo2(){
    if(memo2==null){

      memo2 = new ACLabel();

      memo2.setText("���ʖK��Ō�w�����Ɋ�Â��K��Ō�����{�������́��ň͂ނ��ƁB");

      addMemo2();
    }
    return memo2;

  }

  /**
   * ������3���擾���܂��B
   * @return ������3
   */
  public ACLabel getMemo3(){
    if(memo3==null){

      memo3 = new ACLabel();

      memo3.setText("�ً}���K����s�������́~��Ƃ��邱�ƁB");

      addMemo3();
    }
    return memo3;

  }

  /**
   * ������4���擾���܂��B
   * @return ������4
   */
  public ACLabel getMemo4(){
    if(memo4==null){

      memo4 = new ACLabel();

      memo4.setText("�Ȃ��A�E�\�͖K������Q���ɂ킽��ꍇ�g�p���邱�ƁB");

      addMemo4();
    }
    return memo4;

  }

  /**
   * ������5���擾���܂��B
   * @return ������5
   */
  public ACLabel getMemo5(){
    if(memo5==null){

      memo5 = new ACLabel();

      memo5.setText("�@");

      addMemo5();
    }
    return memo5;

  }

  /**
   * Tab�u�o�߁E���e�v���擾���܂��B
   * @return Tab�u�o�߁E���e�v
   */
  public ACPanel getTabsComments1(){
    if(tabsComments1==null){

      tabsComments1 = new ACPanel();

      addTabsComments1();
    }
    return tabsComments1;

  }

  /**
   * �a��̌o�ߗ̈���擾���܂��B
   * @return �a��̌o�ߗ̈�
   */
  public ACGroupBox getByojos(){
    if(byojos==null){

      byojos = new ACGroupBox();

      byojos.setText("�a��̌o��(42x7)");

      addByojos();
    }
    return byojos;

  }

  /**
   * �a��̌o�ߏ��̈���擾���܂��B
   * @return �a��̌o�ߏ��̈�
   */
  public ACPanel getByojoPnls(){
    if(byojoPnls==null){

      byojoPnls = new ACPanel();

      addByojoPnls();
    }
    return byojoPnls;

  }

  /**
   * �a��̌o�߂��擾���܂��B
   * @return �a��̌o��
   */
  public ACTextArea getByojoComments(){
    if(byojoComments==null){

      byojoComments = new ACTextArea();

      byojoComments.setBindPath("BYOJO_STATE");

      byojoComments.setColumns(84);

      byojoComments.setRows(8);

      byojoComments.setMaxRows(7);

      byojoComments.setIMEMode(InputSubset.KANJI);

      byojoComments.setMaxLength(294);

      byojoComments.setLineWrap(true);

      addByojoComments();
    }
    return byojoComments;

  }

  /**
   * �a��̌o�߃R���e�i���擾���܂��B
   * @return �a��̌o�߃R���e�i
   */
  protected ACLabelContainer getByojoCommentsContainer(){
    if(byojoCommentsContainer==null){
      byojoCommentsContainer = new ACLabelContainer();
      byojoCommentsContainer.setFollowChildEnabled(true);
      byojoCommentsContainer.setVAlignment(VRLayout.CENTER);
      byojoCommentsContainer.add(getByojoComments(), VRLayout.CLIENT);
    }
    return byojoCommentsContainer;
  }

  /**
   * �Ō�E���n�r���e�[�V�����̓��e�̈���擾���܂��B
   * @return �Ō�E���n�r���e�[�V�����̓��e�̈�
   */
  public ACGroupBox getKangoRehas(){
    if(kangoRehas==null){

      kangoRehas = new ACGroupBox();

      kangoRehas.setText("�Ō�E���n�r���e�[�V�����̓��e(42x9)");

      addKangoRehas();
    }
    return kangoRehas;

  }

  /**
   * �Ō�E���n�r���e�[�V�����̓��e���̈���擾���܂��B
   * @return �Ō�E���n�r���e�[�V�����̓��e���̈�
   */
  public ACPanel getKangoRehaPnls(){
    if(kangoRehaPnls==null){

      kangoRehaPnls = new ACPanel();

      addKangoRehaPnls();
    }
    return kangoRehaPnls;

  }

  /**
   * �Ō�E���n�r���e�[�V�����̓��e���擾���܂��B
   * @return �Ō�E���n�r���e�[�V�����̓��e
   */
  public ACTextArea getKangoRehaComments(){
    if(kangoRehaComments==null){

      kangoRehaComments = new ACTextArea();

      kangoRehaComments.setBindPath("KANGO_REHA_NAIYO");

      kangoRehaComments.setColumns(84);

      kangoRehaComments.setRows(10);

      kangoRehaComments.setMaxRows(9);

      kangoRehaComments.setIMEMode(InputSubset.KANJI);

      kangoRehaComments.setMaxLength(378);

      kangoRehaComments.setLineWrap(true);

      addKangoRehaComments();
    }
    return kangoRehaComments;

  }

  /**
   * �Ō�E���n�r���e�[�V�����̓��e�R���e�i���擾���܂��B
   * @return �Ō�E���n�r���e�[�V�����̓��e�R���e�i
   */
  protected ACLabelContainer getKangoRehaCommentsContainer(){
    if(kangoRehaCommentsContainer==null){
      kangoRehaCommentsContainer = new ACLabelContainer();
      kangoRehaCommentsContainer.setFollowChildEnabled(true);
      kangoRehaCommentsContainer.setVAlignment(VRLayout.CENTER);
      kangoRehaCommentsContainer.add(getKangoRehaComments(), VRLayout.CLIENT);
    }
    return kangoRehaCommentsContainer;
  }

  /**
   * Tab�u�󋵁E���L�����v���擾���܂��B
   * @return Tab�u�󋵁E���L�����v
   */
  public ACPanel getTabsComments2(){
    if(tabsComments2==null){

      tabsComments2 = new ACPanel();

      addTabsComments2();
    }
    return tabsComments2;

  }

  /**
   * �ƒ�ł̗×{�E���̏󋵗̈���擾���܂��B
   * @return �ƒ�ł̗×{�E���̏󋵗̈�
   */
  public ACGroupBox getRyoyoStates(){
    if(ryoyoStates==null){

      ryoyoStates = new ACGroupBox();

      ryoyoStates.setText("�ƒ�ł̗×{�E���̏�(42x8)");

      addRyoyoStates();
    }
    return ryoyoStates;

  }

  /**
   * �ƒ�ł̗×{�E���̏󋵏��̈���擾���܂��B
   * @return �ƒ�ł̗×{�E���̏󋵏��̈�
   */
  public ACPanel getRyoyoStatePnls(){
    if(ryoyoStatePnls==null){

      ryoyoStatePnls = new ACPanel();

      addRyoyoStatePnls();
    }
    return ryoyoStatePnls;

  }

  /**
   * �ƒ�ł̗×{�E���̏󋵂��擾���܂��B
   * @return �ƒ�ł̗×{�E���̏�
   */
  public ACTextArea getRyoyoStateComments(){
    if(ryoyoStateComments==null){

      ryoyoStateComments = new ACTextArea();

      ryoyoStateComments.setBindPath("RYOYO_KAIGO_STATE");

      ryoyoStateComments.setColumns(84);

      ryoyoStateComments.setRows(9);

      ryoyoStateComments.setMaxRows(8);

      ryoyoStateComments.setIMEMode(InputSubset.KANJI);

      ryoyoStateComments.setMaxLength(336);

      ryoyoStateComments.setLineWrap(true);

      addRyoyoStateComments();
    }
    return ryoyoStateComments;

  }

  /**
   * �ƒ�ł̗×{�E���̏󋵃R���e�i���擾���܂��B
   * @return �ƒ�ł̗×{�E���̏󋵃R���e�i
   */
  protected ACLabelContainer getRyoyoStateCommentsContainer(){
    if(ryoyoStateCommentsContainer==null){
      ryoyoStateCommentsContainer = new ACLabelContainer();
      ryoyoStateCommentsContainer.setFollowChildEnabled(true);
      ryoyoStateCommentsContainer.setVAlignment(VRLayout.CENTER);
      ryoyoStateCommentsContainer.add(getRyoyoStateComments(), VRLayout.CLIENT);
    }
    return ryoyoStateCommentsContainer;
  }

  /**
   * ���L���ׂ������E���̏󋵗̈���擾���܂��B
   * @return ���L���ׂ������E���̏󋵗̈�
   */
  public ACGroupBox getSpecials(){
    if(specials==null){

      specials = new ACGroupBox();

      specials.setText("���L���ׂ�����(48x5)");

      addSpecials();
    }
    return specials;

  }

  /**
   * ���L���ׂ������E���̏󋵏��̈���擾���܂��B
   * @return ���L���ׂ������E���̏󋵏��̈�
   */
  public ACPanel getSpecialPnls(){
    if(specialPnls==null){

      specialPnls = new ACPanel();

      addSpecialPnls();
    }
    return specialPnls;

  }

  /**
   * ���L���ׂ������E���̏󋵂��擾���܂��B
   * @return ���L���ׂ������E���̏�
   */
  public ACTextArea getSpecialComments(){
    if(specialComments==null){

      specialComments = new ACTextArea();

      specialComments.setBindPath("REPORT_COMMENT");

      specialComments.setColumns(96);

      specialComments.setRows(6);

      specialComments.setMaxRows(5);

      specialComments.setIMEMode(InputSubset.KANJI);

      specialComments.setMaxLength(240);

      specialComments.setLineWrap(true);

      addSpecialComments();
    }
    return specialComments;

  }

  /**
   * ���L���ׂ������E���̏󋵃R���e�i���擾���܂��B
   * @return ���L���ׂ������E���̏󋵃R���e�i
   */
  protected ACLabelContainer getSpecialCommentsContainer(){
    if(specialCommentsContainer==null){
      specialCommentsContainer = new ACLabelContainer();
      specialCommentsContainer.setFollowChildEnabled(true);
      specialCommentsContainer.setVAlignment(VRLayout.CENTER);
      specialCommentsContainer.add(getSpecialComments(), VRLayout.CLIENT);
    }
    return specialCommentsContainer;
  }

  /**
   * �R���X�g���N�^�ł��B
   */
  public QC002Design() {

    try {
      initialize();

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

    this.add(getButtons(), VRLayout.NORTH);

    this.add(getContents(), VRLayout.CLIENT);

  }

  /**
   * �{�^���o�[�ɓ������ڂ�ǉ����܂��B
   */
  protected void addButtons(){

    buttons.add(getPrint(), VRLayout.EAST);
    buttons.add(getUpdate(), VRLayout.EAST);
    buttons.add(getInsert(), VRLayout.EAST);
    buttons.add(getOpen(), VRLayout.EAST);
  }

  /**
   * �O��Ǎ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addOpen(){

  }

  /**
   * �o�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addInsert(){

  }

  /**
   * �X�V�ɓ������ڂ�ǉ����܂��B
   */
  protected void addUpdate(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addPrint(){

  }

  /**
   * �N���C�A���g�̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addContents(){

    contents.add(getTargetDates(), VRLayout.NORTH);

    contents.add(getInfos(), VRLayout.NORTH);

    contents.add(getTabs(), VRLayout.CLIENT);

  }

  /**
   * �Ώ۔N���̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTargetDates(){

    targetDates.add(getTargetDateCaption(), VRLayout.FLOW);

    targetDates.add(getTargetDate(), VRLayout.FLOW);

  }

  /**
   * �Ώ۔N���L���v�V�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addTargetDateCaption(){

  }

  /**
   * �Ώ۔N���ɓ������ڂ�ǉ����܂��B
   */
  protected void addTargetDate(){

  }

  /**
   * ���̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addInfos(){

    infos.add(getPatients(), VRLayout.NORTH);

    infos.add(getStations(), VRLayout.NORTH);

  }

  /**
   * ���p�ҏ��̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatients(){

    patients.add(getPatientNameContainer(), VRLayout.FLOW_INSETLINE);

    patients.add(getPatientBirthContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    patients.add(getYokaigodoContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    patients.add(getPatientAddressContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    patients.add(getDoctorNameContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * �����ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatientName(){

  }

  /**
   * ���N�����R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatientBirthContainer(){

    patientBirthContainer.add(getPatientBirth(), null);

    patientBirthContainer.add(getPatientAge(), null);

    patientBirthContainer.add(getPatientAgeLabel(), null);

  }

  /**
   * ���N�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatientBirth(){

  }

  /**
   * �N��ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatientAge(){

  }

  /**
   * �΂ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatientAgeLabel(){

  }

  /**
   * �v���F��ɓ������ڂ�ǉ����܂��B
   */
  protected void addYokaigodo(){

  }

  /**
   * �v���F�胂�f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addYokaigodoModel(){

    getYokaigodoRadio1().setButtonIndex(1);

    getYokaigodoModel().add(getYokaigodoRadio1());

    getYokaigodoRadio2().setButtonIndex(12);

    getYokaigodoModel().add(getYokaigodoRadio2());

    getYokaigodoRadio3().setButtonIndex(13);

    getYokaigodoModel().add(getYokaigodoRadio3());

    getYokaigodoRadio4().setButtonIndex(11);

    getYokaigodoModel().add(getYokaigodoRadio4());

    getYokaigodoRadio5().setButtonIndex(21);

    getYokaigodoModel().add(getYokaigodoRadio5());

    getYokaigodoRadio6().setButtonIndex(22);

    getYokaigodoModel().add(getYokaigodoRadio6());

    getYokaigodoRadio7().setButtonIndex(23);

    getYokaigodoModel().add(getYokaigodoRadio7());

    getYokaigodoRadio8().setButtonIndex(24);

    getYokaigodoModel().add(getYokaigodoRadio8());

    getYokaigodoRadio9().setButtonIndex(25);

    getYokaigodoModel().add(getYokaigodoRadio9());

  }

  /**
   * �����ɓ������ڂ�ǉ����܂��B
   */
  protected void addYokaigodoRadio1(){

  }

  /**
   * �v�x��1�ɓ������ڂ�ǉ����܂��B
   */
  protected void addYokaigodoRadio2(){

  }

  /**
   * �v�x��2�ɓ������ڂ�ǉ����܂��B
   */
  protected void addYokaigodoRadio3(){

  }

  /**
   * �o�ߓI�v���ɓ������ڂ�ǉ����܂��B
   */
  protected void addYokaigodoRadio4(){

  }

  /**
   * �v���1�ɓ������ڂ�ǉ����܂��B
   */
  protected void addYokaigodoRadio5(){

  }

  /**
   * �v���2�ɓ������ڂ�ǉ����܂��B
   */
  protected void addYokaigodoRadio6(){

  }

  /**
   * �v���3�ɓ������ڂ�ǉ����܂��B
   */
  protected void addYokaigodoRadio7(){

  }

  /**
   * �v���4�ɓ������ڂ�ǉ����܂��B
   */
  protected void addYokaigodoRadio8(){

  }

  /**
   * �v���5�ɓ������ڂ�ǉ����܂��B
   */
  protected void addYokaigodoRadio9(){

  }

  /**
   * �Z���ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatientAddress(){

  }

  /**
   * �厡�㎁���ɓ������ڂ�ǉ����܂��B
   */
  protected void addDoctorName(){

  }

  /**
   * �X�e�[�V�������̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addStations(){

    stations.add(getCreateDateContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    stations.add(getProviderNameContainer(), VRLayout.FLOW_INSETLINE);

    stations.add(getAdministratorNameContainer(), VRLayout.FLOW_RETURN);

  }

  /**
   * �쐬�N�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addCreateDate(){

  }

  /**
   * �X�e�[�V�������ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderName(){

  }

  /**
   * �X�e�[�V���������f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderNameModel(){

  }

  /**
   * �Ǘ��Ҏ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addAdministratorName(){

  }

  /**
   * Tab�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTabs(){

    tabs.addTab("�K���", getTabVisitDate());

    tabs.addTab("�o�߁E���e", getTabsComments1());

    tabs.addTab("�󋵁E���L����", getTabsComments2());

  }

  /**
   * Tab�u�K����v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTabVisitDate(){

    tabVisitDate.add(getVisitDates(), VRLayout.NORTH);

  }

  /**
   * �K����̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addVisitDates(){

    visitDates.add(getCalendars(), VRLayout.NORTH);

    visitDates.add(getResultButtonPanel(), VRLayout.NORTH);

    visitDates.add(getMemos(), VRLayout.NORTH);

  }

  /**
   * �J�����_�[�̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendars(){

    calendars.add(getCalendarLefts(), VRLayout.CLIENT);

    calendars.add(getCalendarRights(), VRLayout.CLIENT);

  }

  /**
   * �J�����_�[(���̈�)�ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarLefts(){

    calendarLefts.add(getCalendarLeftYearMonths(), VRLayout.NORTH);

    calendarLefts.add(getCalendarLeftDayContainer(), VRLayout.CLIENT);

  }

  /**
   * �J�����_�[(��)�N���̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarLeftYearMonths(){

    calendarLeftYearMonths.add(getCalendarLeftCaption(), VRLayout.FLOW);

    calendarLeftYearMonths.add(getCalendarLeftYear(), VRLayout.FLOW);

    calendarLeftYearMonths.add(getCalendarLeftYearCaption(), VRLayout.FLOW);

    calendarLeftYearMonths.add(getCalendarLeftMonth(), VRLayout.FLOW);

    calendarLeftYearMonths.add(getCalendarLeftMonthCaption(), VRLayout.FLOW);

  }

  /**
   * �J�����_�[(��)�N���̈惌�C�A�E�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarLeftYearMonthsLayout(){

  }

  /**
   * �����ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarLeftCaption(){

  }

  /**
   * �N�ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarLeftYear(){

  }

  /**
   * �N�L���v�V�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarLeftYearCaption(){

  }

  /**
   * ���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarLeftMonth(){

  }

  /**
   * ���L���v�V�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarLeftMonthCaption(){

  }

  /**
   * �J�����_�[(�����t�̈�)�ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarLeftDayContainer(){

    calendarLeftDayContainer.add(getCalendarLeftDay01(), VRLayout.FLOW);

    calendarLeftDayContainer.add(getCalendarLeftDay02(), VRLayout.FLOW);

    calendarLeftDayContainer.add(getCalendarLeftDay03(), VRLayout.FLOW);

    calendarLeftDayContainer.add(getCalendarLeftDay04(), VRLayout.FLOW);

    calendarLeftDayContainer.add(getCalendarLeftDay05(), VRLayout.FLOW);

    calendarLeftDayContainer.add(getCalendarLeftDay06(), VRLayout.FLOW);

    calendarLeftDayContainer.add(getCalendarLeftDay07(), VRLayout.FLOW_RETURN);

    calendarLeftDayContainer.add(getCalendarLeftDay08(), VRLayout.FLOW);

    calendarLeftDayContainer.add(getCalendarLeftDay09(), VRLayout.FLOW);

    calendarLeftDayContainer.add(getCalendarLeftDay10(), VRLayout.FLOW);

    calendarLeftDayContainer.add(getCalendarLeftDay11(), VRLayout.FLOW);

    calendarLeftDayContainer.add(getCalendarLeftDay12(), VRLayout.FLOW);

    calendarLeftDayContainer.add(getCalendarLeftDay13(), VRLayout.FLOW);

    calendarLeftDayContainer.add(getCalendarLeftDay14(), VRLayout.FLOW_RETURN);

    calendarLeftDayContainer.add(getCalendarLeftDay15(), VRLayout.FLOW);

    calendarLeftDayContainer.add(getCalendarLeftDay16(), VRLayout.FLOW);

    calendarLeftDayContainer.add(getCalendarLeftDay17(), VRLayout.FLOW);

    calendarLeftDayContainer.add(getCalendarLeftDay18(), VRLayout.FLOW);

    calendarLeftDayContainer.add(getCalendarLeftDay19(), VRLayout.FLOW);

    calendarLeftDayContainer.add(getCalendarLeftDay20(), VRLayout.FLOW);

    calendarLeftDayContainer.add(getCalendarLeftDay21(), VRLayout.FLOW_RETURN);

    calendarLeftDayContainer.add(getCalendarLeftDay22(), VRLayout.FLOW);

    calendarLeftDayContainer.add(getCalendarLeftDay23(), VRLayout.FLOW);

    calendarLeftDayContainer.add(getCalendarLeftDay24(), VRLayout.FLOW);

    calendarLeftDayContainer.add(getCalendarLeftDay25(), VRLayout.FLOW);

    calendarLeftDayContainer.add(getCalendarLeftDay26(), VRLayout.FLOW);

    calendarLeftDayContainer.add(getCalendarLeftDay27(), VRLayout.FLOW);

    calendarLeftDayContainer.add(getCalendarLeftDay28(), VRLayout.FLOW_RETURN);

    calendarLeftDayContainer.add(getCalendarLeftDay29Panel(), VRLayout.FLOW);

    calendarLeftDayContainer.add(getCalendarLeftDay30Panel(), VRLayout.FLOW);

    calendarLeftDayContainer.add(getCalendarLeftDay31Panel(), VRLayout.FLOW);

  }

  /**
   * 1���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarLeftDay01(){

  }

  /**
   * 1�����f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarLeftDay01Model(){

  }

  /**
   * 2���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarLeftDay02(){

  }

  /**
   * 2�����f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarLeftDay02Model(){

  }

  /**
   * 3���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarLeftDay03(){

  }

  /**
   * 3�����f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarLeftDay03Model(){

  }

  /**
   * 4���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarLeftDay04(){

  }

  /**
   * 4�����f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarLeftDay04Model(){

  }

  /**
   * 5���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarLeftDay05(){

  }

  /**
   * 5�����f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarLeftDay05Model(){

  }

  /**
   * 6���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarLeftDay06(){

  }

  /**
   * 6�����f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarLeftDay06Model(){

  }

  /**
   * 7���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarLeftDay07(){

  }

  /**
   * 7�����f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarLeftDay07Model(){

  }

  /**
   * 8���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarLeftDay08(){

  }

  /**
   * 8�����f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarLeftDay08Model(){

  }

  /**
   * 9���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarLeftDay09(){

  }

  /**
   * 9�����f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarLeftDay09Model(){

  }

  /**
   * 10���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarLeftDay10(){

  }

  /**
   * 10�����f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarLeftDay10Model(){

  }

  /**
   * 11���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarLeftDay11(){

  }

  /**
   * 11�����f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarLeftDay11Model(){

  }

  /**
   * 12���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarLeftDay12(){

  }

  /**
   * 12�����f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarLeftDay12Model(){

  }

  /**
   * 13���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarLeftDay13(){

  }

  /**
   * 13�����f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarLeftDay13Model(){

  }

  /**
   * 14���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarLeftDay14(){

  }

  /**
   * 14�����f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarLeftDay14Model(){

  }

  /**
   * 15���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarLeftDay15(){

  }

  /**
   * 15�����f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarLeftDay15Model(){

  }

  /**
   * 16���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarLeftDay16(){

  }

  /**
   * 16�����f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarLeftDay16Model(){

  }

  /**
   * 17���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarLeftDay17(){

  }

  /**
   * 17�����f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarLeftDay17Model(){

  }

  /**
   * 18���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarLeftDay18(){

  }

  /**
   * 18�����f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarLeftDay18Model(){

  }

  /**
   * 19���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarLeftDay19(){

  }

  /**
   * 19�����f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarLeftDay19Model(){

  }

  /**
   * 20���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarLeftDay20(){

  }

  /**
   * 20�����f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarLeftDay20Model(){

  }

  /**
   * 21���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarLeftDay21(){

  }

  /**
   * 21�����f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarLeftDay21Model(){

  }

  /**
   * 22���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarLeftDay22(){

  }

  /**
   * 22�����f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarLeftDay22Model(){

  }

  /**
   * 23���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarLeftDay23(){

  }

  /**
   * 23�����f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarLeftDay23Model(){

  }

  /**
   * 24���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarLeftDay24(){

  }

  /**
   * 24�����f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarLeftDay24Model(){

  }

  /**
   * 25���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarLeftDay25(){

  }

  /**
   * 25�����f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarLeftDay25Model(){

  }

  /**
   * 26���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarLeftDay26(){

  }

  /**
   * 26�����f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarLeftDay26Model(){

  }

  /**
   * 27���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarLeftDay27(){

  }

  /**
   * 27�����f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarLeftDay27Model(){

  }

  /**
   * 28���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarLeftDay28(){

  }

  /**
   * 28�����f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarLeftDay28Model(){

  }

  /**
   * 29���p�l���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarLeftDay29Panel(){

    calendarLeftDay29Panel.add(getCalendarLeftDay29Label(), VRLayout.CLIENT);

    calendarLeftDay29Panel.add(getCalendarLeftDay29(), VRLayout.CLIENT);

  }

  /**
   * 29���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarLeftDay29Label(){

  }

  /**
   * 29���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarLeftDay29(){

  }

  /**
   * 29�����f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarLeftDay29Model(){

  }

  /**
   * 30���p�l���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarLeftDay30Panel(){

    calendarLeftDay30Panel.add(getCalendarLeftDay30Label(), VRLayout.CLIENT);

    calendarLeftDay30Panel.add(getCalendarLeftDay30(), VRLayout.CLIENT);

  }

  /**
   * 30���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarLeftDay30Label(){

  }

  /**
   * 30���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarLeftDay30(){

  }

  /**
   * 30�����f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarLeftDay30Model(){

  }

  /**
   * 31���p�l���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarLeftDay31Panel(){

    calendarLeftDay31Panel.add(getCalendarLeftDay31Label(), VRLayout.CLIENT);

    calendarLeftDay31Panel.add(getCalendarLeftDay31(), VRLayout.CLIENT);

  }

  /**
   * 31���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarLeftDay31Label(){

  }

  /**
   * 31���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarLeftDay31(){

  }

  /**
   * 31�����f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarLeftDay31Model(){

  }

  /**
   * �J�����_�[(�E�̈�)�ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarRights(){

    calendarRights.add(getCalendarRightYearMonths(), VRLayout.NORTH);

    calendarRights.add(getCalendarRightDayContainer(), VRLayout.CLIENT);

  }

  /**
   * �J�����_�[(�E)�N���̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarRightYearMonths(){

    calendarRightYearMonths.add(getCalendarRightCaption(), VRLayout.FLOW);

    calendarRightYearMonths.add(getCalendarRightYear(), VRLayout.FLOW);

    calendarRightYearMonths.add(getCalendarRightYearCaption(), VRLayout.FLOW);

    calendarRightYearMonths.add(getCalendarRightMonth(), VRLayout.FLOW);

    calendarRightYearMonths.add(getCalendarRightMonthCaption(), VRLayout.FLOW);

  }

  /**
   * �J�����_�[(�E)�N���̈惌�C�A�E�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarRightYearMonthsLayout(){

  }

  /**
   * �����L���v�V�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarRightCaption(){

  }

  /**
   * �N�ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarRightYear(){

  }

  /**
   * �N�L���v�V�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarRightYearCaption(){

  }

  /**
   * ���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarRightMonth(){

  }

  /**
   * ���L���v�V�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarRightMonthCaption(){

  }

  /**
   * �J�����_�[(�E���t�̈�)�ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarRightDayContainer(){

    calendarRightDayContainer.add(getCalendarRightDay01(), VRLayout.FLOW);

    calendarRightDayContainer.add(getCalendarRightDay02(), VRLayout.FLOW);

    calendarRightDayContainer.add(getCalendarRightDay03(), VRLayout.FLOW);

    calendarRightDayContainer.add(getCalendarRightDay04(), VRLayout.FLOW);

    calendarRightDayContainer.add(getCalendarRightDay05(), VRLayout.FLOW);

    calendarRightDayContainer.add(getCalendarRightDay06(), VRLayout.FLOW);

    calendarRightDayContainer.add(getCalendarRightDay07(), VRLayout.FLOW_RETURN);

    calendarRightDayContainer.add(getCalendarRightDay08(), VRLayout.FLOW);

    calendarRightDayContainer.add(getCalendarRightDay09(), VRLayout.FLOW);

    calendarRightDayContainer.add(getCalendarRightDay10(), VRLayout.FLOW);

    calendarRightDayContainer.add(getCalendarRightDay11(), VRLayout.FLOW);

    calendarRightDayContainer.add(getCalendarRightDay12(), VRLayout.FLOW);

    calendarRightDayContainer.add(getCalendarRightDay13(), VRLayout.FLOW);

    calendarRightDayContainer.add(getCalendarRightDay14(), VRLayout.FLOW_RETURN);

    calendarRightDayContainer.add(getCalendarRightDay15(), VRLayout.FLOW);

    calendarRightDayContainer.add(getCalendarRightDay16(), VRLayout.FLOW);

    calendarRightDayContainer.add(getCalendarRightDay17(), VRLayout.FLOW);

    calendarRightDayContainer.add(getCalendarRightDay18(), VRLayout.FLOW);

    calendarRightDayContainer.add(getCalendarRightDay19(), VRLayout.FLOW);

    calendarRightDayContainer.add(getCalendarRightDay20(), VRLayout.FLOW);

    calendarRightDayContainer.add(getCalendarRightDay21(), VRLayout.FLOW_RETURN);

    calendarRightDayContainer.add(getCalendarRightDay22(), VRLayout.FLOW);

    calendarRightDayContainer.add(getCalendarRightDay23(), VRLayout.FLOW);

    calendarRightDayContainer.add(getCalendarRightDay24(), VRLayout.FLOW);

    calendarRightDayContainer.add(getCalendarRightDay25(), VRLayout.FLOW);

    calendarRightDayContainer.add(getCalendarRightDay26(), VRLayout.FLOW);

    calendarRightDayContainer.add(getCalendarRightDay27(), VRLayout.FLOW);

    calendarRightDayContainer.add(getCalendarRightDay28(), VRLayout.FLOW_RETURN);

    calendarRightDayContainer.add(getCalendarRightDay29Panel(), VRLayout.FLOW);

    calendarRightDayContainer.add(getCalendarRightDay30Panel(), VRLayout.FLOW);

    calendarRightDayContainer.add(getCalendarRightDay31Panel(), VRLayout.FLOW);

  }

  /**
   * 1���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarRightDay01(){

  }

  /**
   * 1�����f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarRightDay01Model(){

  }

  /**
   * 2���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarRightDay02(){

  }

  /**
   * 2�����f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarRightDay02Model(){

  }

  /**
   * 3���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarRightDay03(){

  }

  /**
   * 3�����f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarRightDay03Model(){

  }

  /**
   * 4���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarRightDay04(){

  }

  /**
   * 4�����f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarRightDay04Model(){

  }

  /**
   * 5���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarRightDay05(){

  }

  /**
   * 5�����f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarRightDay05Model(){

  }

  /**
   * 6���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarRightDay06(){

  }

  /**
   * 6�����f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarRightDay06Model(){

  }

  /**
   * 7���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarRightDay07(){

  }

  /**
   * 7�����f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarRightDay07Model(){

  }

  /**
   * 8���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarRightDay08(){

  }

  /**
   * 8�����f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarRightDay08Model(){

  }

  /**
   * 9���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarRightDay09(){

  }

  /**
   * 9�����f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarRightDay09Model(){

  }

  /**
   * 10���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarRightDay10(){

  }

  /**
   * 10�����f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarRightDay10Model(){

  }

  /**
   * 11���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarRightDay11(){

  }

  /**
   * 11�����f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarRightDay11Model(){

  }

  /**
   * 12���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarRightDay12(){

  }

  /**
   * 12�����f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarRightDay12Model(){

  }

  /**
   * 13���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarRightDay13(){

  }

  /**
   * 13�����f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarRightDay13Model(){

  }

  /**
   * 14���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarRightDay14(){

  }

  /**
   * 14�����f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarRightDay14Model(){

  }

  /**
   * 15���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarRightDay15(){

  }

  /**
   * 15�����f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarRightDay15Model(){

  }

  /**
   * 16���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarRightDay16(){

  }

  /**
   * 16�����f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarRightDay16Model(){

  }

  /**
   * 17���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarRightDay17(){

  }

  /**
   * 17�����f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarRightDay17Model(){

  }

  /**
   * 18���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarRightDay18(){

  }

  /**
   * 18�����f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarRightDay18Model(){

  }

  /**
   * 19���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarRightDay19(){

  }

  /**
   * 19�����f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarRightDay19Model(){

  }

  /**
   * 20���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarRightDay20(){

  }

  /**
   * 20�����f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarRightDay20Model(){

  }

  /**
   * 21���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarRightDay21(){

  }

  /**
   * 21�����f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarRightDay21Model(){

  }

  /**
   * 22���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarRightDay22(){

  }

  /**
   * 22�����f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarRightDay22Model(){

  }

  /**
   * 23���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarRightDay23(){

  }

  /**
   * 23�����f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarRightDay23Model(){

  }

  /**
   * 24���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarRightDay24(){

  }

  /**
   * 24�����f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarRightDay24Model(){

  }

  /**
   * 25���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarRightDay25(){

  }

  /**
   * 25�����f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarRightDay25Model(){

  }

  /**
   * 26���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarRightDay26(){

  }

  /**
   * 26�����f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarRightDay26Model(){

  }

  /**
   * 27���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarRightDay27(){

  }

  /**
   * 27�����f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarRightDay27Model(){

  }

  /**
   * 28���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarRightDay28(){

  }

  /**
   * 28�����f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarRightDay28Model(){

  }

  /**
   * 29���p�l���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarRightDay29Panel(){

    calendarRightDay29Panel.add(getCalendarRightDay29Label(), VRLayout.CLIENT);

    calendarRightDay29Panel.add(getCalendarRightDay29(), VRLayout.CLIENT);

  }

  /**
   * 29���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarRightDay29Label(){

  }

  /**
   * 29���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarRightDay29(){

  }

  /**
   * 29�����f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarRightDay29Model(){

  }

  /**
   * 30���p�l���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarRightDay30Panel(){

    calendarRightDay30Panel.add(getCalendarRightDay30Label(), VRLayout.CLIENT);

    calendarRightDay30Panel.add(getCalendarRightDay30(), VRLayout.CLIENT);

  }

  /**
   * 30���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarRightDay30Label(){

  }

  /**
   * 30���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarRightDay30(){

  }

  /**
   * 30�����f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarRightDay30Model(){

  }

  /**
   * 31���p�l���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarRightDay31Panel(){

    calendarRightDay31Panel.add(getCalendarRightDay31Label(), VRLayout.CLIENT);

    calendarRightDay31Panel.add(getCalendarRightDay31(), VRLayout.CLIENT);

  }

  /**
   * 31���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarRightDay31Label(){

  }

  /**
   * 31���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarRightDay31(){

  }

  /**
   * 31�����f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarRightDay31Model(){

  }

  /**
   * �{�^���̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addResultButtonPanel(){

    resultButtonPanel.add(getResultButtonPanelLeft(), VRLayout.CLIENT);

    resultButtonPanel.add(getResultButtonPanelRight(), VRLayout.CLIENT);

  }

  /**
   * �p�l���ɓ������ڂ�ǉ����܂��B
   */
  protected void addResultButtonPanelLeft(){

    resultButtonPanelLeft.add(getResultReadButtonLeft(), VRLayout.FLOW);

  }

  /**
   * �{�^���ɓ������ڂ�ǉ����܂��B
   */
  protected void addResultReadButtonLeft(){

  }

  /**
   * �p�l���ɓ������ڂ�ǉ����܂��B
   */
  protected void addResultButtonPanelRight(){

    resultButtonPanelRight.add(getResultReadButtonRight(), VRLayout.FLOW);

  }

  /**
   * �{�^���ɓ������ڂ�ǉ����܂��B
   */
  protected void addResultReadButtonRight(){

  }

  /**
   * �������̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMemos(){

    memos.add(getMemo1(), VRLayout.NORTH);

    memos.add(getMemo6(), VRLayout.NORTH);

    memos.add(getMemo2(), VRLayout.NORTH);

    memos.add(getMemo3(), VRLayout.NORTH);

    memos.add(getMemo4(), VRLayout.NORTH);

    memos.add(getMemo5(), VRLayout.NORTH);

  }

  /**
   * ������1�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMemo1(){

  }

  /**
   * ������6(�ǉ��j�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMemo6(){

  }

  /**
   * ������2�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMemo2(){

  }

  /**
   * ������3�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMemo3(){

  }

  /**
   * ������4�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMemo4(){

  }

  /**
   * ������5�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMemo5(){

  }

  /**
   * Tab�u�o�߁E���e�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTabsComments1(){

    tabsComments1.add(getByojos(), VRLayout.NORTH);

    tabsComments1.add(getKangoRehas(), VRLayout.NORTH);

  }

  /**
   * �a��̌o�ߗ̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addByojos(){

    byojos.add(getByojoPnls(), VRLayout.FLOW);

  }

  /**
   * �a��̌o�ߏ��̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addByojoPnls(){

    byojoPnls.add(getByojoCommentsContainer(), VRLayout.CLIENT);

  }

  /**
   * �a��̌o�߂ɓ������ڂ�ǉ����܂��B
   */
  protected void addByojoComments(){

  }

  /**
   * �Ō�E���n�r���e�[�V�����̓��e�̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKangoRehas(){

    kangoRehas.add(getKangoRehaPnls(), VRLayout.FLOW);

  }

  /**
   * �Ō�E���n�r���e�[�V�����̓��e���̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKangoRehaPnls(){

    kangoRehaPnls.add(getKangoRehaCommentsContainer(), VRLayout.CLIENT);

  }

  /**
   * �Ō�E���n�r���e�[�V�����̓��e�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKangoRehaComments(){

  }

  /**
   * Tab�u�󋵁E���L�����v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTabsComments2(){

    tabsComments2.add(getRyoyoStates(), VRLayout.NORTH);

    tabsComments2.add(getSpecials(), VRLayout.NORTH);

  }

  /**
   * �ƒ�ł̗×{�E���̏󋵗̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addRyoyoStates(){

    ryoyoStates.add(getRyoyoStatePnls(), VRLayout.FLOW);

  }

  /**
   * �ƒ�ł̗×{�E���̏󋵏��̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addRyoyoStatePnls(){

    ryoyoStatePnls.add(getRyoyoStateCommentsContainer(), VRLayout.CLIENT);

  }

  /**
   * �ƒ�ł̗×{�E���̏󋵂ɓ������ڂ�ǉ����܂��B
   */
  protected void addRyoyoStateComments(){

  }

  /**
   * ���L���ׂ������E���̏󋵗̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addSpecials(){

    specials.add(getSpecialPnls(), VRLayout.FLOW);

  }

  /**
   * ���L���ׂ������E���̏󋵏��̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addSpecialPnls(){

    specialPnls.add(getSpecialCommentsContainer(), VRLayout.CLIENT);

  }

  /**
   * ���L���ׂ������E���̏󋵂ɓ������ڂ�ǉ����܂��B
   */
  protected void addSpecialComments(){

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
      ACFrame.getInstance().setFrameEventProcesser(new QkanFrameEventProcesser());
      ACFrame.debugStart(new ACAffairInfo(QC002Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QC002Design getThis() {
    return this;
  }
}
