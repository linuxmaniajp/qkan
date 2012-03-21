
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
 * �쐬��: 2009/08/27  ���{�R���s���[�^�[������� �� ���� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���[�Ǘ� (C)
 * �v���Z�X ����×{�Ǘ��w���� (005)
 * �v���O���� ����×{�Ǘ��w���� (QC005)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qc.qc005;
import java.awt.Color;
import java.awt.Component;
import java.awt.im.InputSubset;

import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;

import jp.nichicom.ac.ACConstants;
import jp.nichicom.ac.component.ACAffairButton;
import jp.nichicom.ac.component.ACAffairButtonBar;
import jp.nichicom.ac.component.ACButton;
import jp.nichicom.ac.component.ACClearableRadioButtonGroup;
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
import jp.nichicom.vr.text.VRCharType;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanConstants;
import jp.or.med.orca.qkan.affair.QkanAffairContainer;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.component.QkanDateTextField;
import jp.or.med.orca.qkan.component.QkanYearDateTextField;
/**
 * ����×{�Ǘ��w������ʍ��ڃf�U�C��(QC005) 
 */
public class QC005Design extends QkanAffairContainer implements ACAffairable {
  //GUI�R���|�[�l���g

  private ACAffairButtonBar buttons;

  private ACAffairButton open;

  private ACAffairButton insert;

  private ACAffairButton update;

  private ACAffairButton print;

  private ACPanel contents;

  private ACPanel targetDates;

  private ACLabel targetDateCaption;

  private ACLabel targetDateLabel;

  private ACGroupBox patients;

  private ACPanel patients1;

  private ACTextField patientName;

  private ACLabelContainer patientNameContainer;

  private ACTextField patientSex;

  private ACLabelContainer patientSexContainer;

  private QkanDateTextField patientBirth;

  private ACLabelContainer patientBirthContainer;

  private ACValueArrayRadioButtonGroup jotaiCode;

  private ACLabelContainer jotaiCodeContainer;

  private ACListModelAdapter jotaiCodeModel;

  private ACRadioButtonItem yokaigodoRadioItem1;

  private ACRadioButtonItem yokaigodoRadioItem8;

  private ACRadioButtonItem yokaigodoRadioItem9;

  private ACRadioButtonItem yokaigodoRadioItem2;

  private ACRadioButtonItem yokaigodoRadioItem3;

  private ACRadioButtonItem yokaigodoRadioItem4;

  private ACRadioButtonItem yokaigodoRadioItem5;

  private ACRadioButtonItem yokaigodoRadioItem6;

  private ACRadioButtonItem yokaigodoRadioItem7;

  private ACPanel patients2;

  private ACClearableRadioButtonGroup shogaiJiritsudo;

  private ACLabelContainer shogaiJiritsudoContainer;

  private ACListModelAdapter shogaiJiritsudoModel;

  private ACRadioButtonItem shogaiJiritsudoRadioItem1;

  private ACRadioButtonItem shogaiJiritsudoRadioItem2;

  private ACRadioButtonItem shogaiJiritsudoRadioItem3;

  private ACRadioButtonItem shogaiJiritsudoRadioItem4;

  private ACRadioButtonItem shogaiJiritsudoRadioItem5;

  private ACClearableRadioButtonGroup ninchishoJiritsudo;

  private ACLabelContainer ninchishoJiritsudoContainer;

  private ACListModelAdapter ninchishoJiritsudoModel;

  private ACRadioButtonItem ninchishoJiritsudoRadioItem1;

  private ACRadioButtonItem ninchishoJiritsudoRadioItem2;

  private ACRadioButtonItem ninchishoJiritsudoRadioItem3;

  private ACRadioButtonItem ninchishoJiritsudoRadioItem4;

  private ACRadioButtonItem ninchishoJiritsudoRadioItem5;

  private ACRadioButtonItem ninchishoJiritsudoRadioItem6;

  private ACTextArea patientAddress;

  private ACLabelContainer patientAddressContainer;

  private ACLabelContainer patientTelContena;

  private ACTextField patientTel2;

  private ACLabel patientTel3;

  private ACTextField patientTel4;

  private ACLabel patientTel5;

  private ACTextField patientTel6;

  private JTabbedPane tabsArea;

  private ACPanel providerAndMedicaiInfoArea;

  private ACGroupBox medicalInfoGroup;

  private ACComboBox medicalInstitusion;

  private ACLabelContainer medicalInstitusionContainer;

  private ACComboBoxModelAdapter medicalInstitusionModel;

  private ACTextField medicalAddress;

  private ACLabelContainer medicalAddressContainer;

  private ACLabelContainer medicalTelContena;

  private ACTextField medicalTel2;

  private ACLabel medicalTel3;

  private ACTextField medicalTel4;

  private ACLabel medicalTel5;

  private ACTextField medicalTel6;

  private ACTextField doctorName;

  private ACLabelContainer doctorNameContainer;

  private ACPanel points;

  private ACPanel points1;

  private ACLabel yourDoctorCaption1;

  private ACLabel yourDoctor;

  private ACLabel yourDoctorCaption2;

  private QkanYearDateTextField createDateZaitaku;

  private ACLabelContainer createDateZaitakuContainer;

  private ACLabelContainer visitThisMonthContainer;

  private ACTextField visitThisMonth1;

  private ACTextField visitThisMonth2;

  private ACTextField visitThisMonth3;

  private ACTextField visitThisMonth4;

  private ACTextField visitThisMonth5;

  private ACTextField visitThisMonth6;

  private ACLabel visitThisMonthCaption;

  private ACButton resultReadButton;

  private ACLabelContainer visitNextMonthContainer;

  private ACTextField visitNextMonth1;

  private ACTextField visitNextMonth2;

  private ACTextField visitNextMonth3;

  private ACTextField visitNextMonth4;

  private ACTextField visitNextMonth5;

  private ACTextField visitNextMonth6;

  private ACLabel visitNextMonthCaption;

  private ACLabelContainer adviceContainer;

  private VRLayout adviceContainerLayout;

  private ACPanel advices;

  private ACPanel advicdHeaders;

  private ACTextField adviceMonth;

  private ACLabel adviceMonthCaption;

  private ACLabel adviceLength;

  private ACTextArea advice;

  private ACPanel points2;

  private JTabbedPane kyotakuPoints;

  private ACPanel kyotakuPointsPanel1;

  private ACGroupBox providerInfoGroup;

  private QkanDateTextField createDateKyotaku;

  private ACLabelContainer createDateKyotakuContainer;

  private ACComboBox senmonin;

  private ACLabelContainer senmoninContainer;

  private ACComboBoxModelAdapter senmoninModel;

  private ACComboBox providerName;

  private ACLabelContainer providerNameContainer;

  private ACComboBoxModelAdapter providerNameModel;

  private ACGroupBox byojoGroup;

  private ACPanel byojoPanel;

  private ACTextArea byojo;

  private ACLabelContainer byojoContainer;

  private ACGroupBox byojiKeikaGroup;

  private ACPanel byojoKeikaPanel;

  private ACTextArea byojoKeika;

  private ACLabelContainer byojoKeikaContainer;

  private ACPanel kyotakuPointsPane2;

  private ACGroupBox kaigoServiceUseCheckGroup;

  private ACPanel kaigoServicePanel;

  private ACTextArea kaigoServiceUseCheck;

  private ACLabelContainer kaigoServiceUseCheckContainer;

  private ACGroupBox ryuitenGroup;

  private ACPanel ryuitenPanel;

  private ACTextArea ryuiten;

  private ACLabelContainer ryuitenContainer;

  private ACPanel kyotakuPointsPane3;

  private ACGroupBox bikouGroup;

  private ACPanel bikouPanel;

  private ACTextArea bikou;

  private ACLabelContainer bikouContainer;

  //getter

  /**
   * �{�^���o�[���擾���܂��B
   * @return �{�^���o�[
   */
  public ACAffairButtonBar getButtons(){
    if(buttons==null){

      buttons = new ACAffairButtonBar();

      buttons.setText("����×{�Ǘ��w����");

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

      open.setToolTipText("�ߋ��̃f�[�^�̒��ŁA�ŐV�̃f�[�^��ǂݍ��݂܂��B");

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

      print.setToolTipText("�u����×{�Ǘ��w�����v��������܂��B");

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
  public ACLabel getTargetDateLabel(){
    if(targetDateLabel==null){

      targetDateLabel = new ACLabel();

      targetDateLabel.setBindPath("TARGET_DATE");

      targetDateLabel.setForeground(Color.blue);

      addTargetDateLabel();
    }
    return targetDateLabel;

  }

  /**
   * ���p�ҏ��̈���擾���܂��B
   * @return ���p�ҏ��̈�
   */
  public ACGroupBox getPatients(){
    if(patients==null){

      patients = new ACGroupBox();

      patients.setText("���p�ҏ��");

      addPatients();
    }
    return patients;

  }

  /**
   * ���p�ҏ��T�u�̈�1���擾���܂��B
   * @return ���p�ҏ��T�u�̈�1
   */
  public ACPanel getPatients1(){
    if(patients1==null){

      patients1 = new ACPanel();

      patients1.setAutoWrap(false);

      patients1.setHgap(0);

      patients1.setHgrid(100);

      addPatients1();
    }
    return patients1;

  }

  /**
   * ���p�Ҏ������擾���܂��B
   * @return ���p�Ҏ���
   */
  public ACTextField getPatientName(){
    if(patientName==null){

      patientName = new ACTextField();

      getPatientNameContainer().setText("���p�Ҏ���");

      patientName.setBindPath("PATIENT_NAME");

      patientName.setEditable(false);

      patientName.setColumns(26);

      patientName.setIMEMode(InputSubset.KANJI);

      patientName.setMaxLength(52);

      addPatientName();
    }
    return patientName;

  }

  /**
   * ���p�Ҏ����R���e�i���擾���܂��B
   * @return ���p�Ҏ����R���e�i
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
   * ���ʂ��擾���܂��B
   * @return ����
   */
  public ACTextField getPatientSex(){
    if(patientSex==null){

      patientSex = new ACTextField();

      getPatientSexContainer().setText("����");

      patientSex.setBindPath("PATIENT_SEX");

      patientSex.setEditable(false);

      patientSex.setFormat(QkanConstants.FORMAT_SEX);

      patientSex.setMaxLength(4);

      addPatientSex();
    }
    return patientSex;

  }

  /**
   * ���ʃR���e�i���擾���܂��B
   * @return ���ʃR���e�i
   */
  protected ACLabelContainer getPatientSexContainer(){
    if(patientSexContainer==null){
      patientSexContainer = new ACLabelContainer();
      patientSexContainer.setFollowChildEnabled(true);
      patientSexContainer.setVAlignment(VRLayout.CENTER);
      patientSexContainer.add(getPatientSex(), null);
    }
    return patientSexContainer;
  }

  /**
   * ���N�������擾���܂��B
   * @return ���N����
   */
  public QkanDateTextField getPatientBirth(){
    if(patientBirth==null){

      patientBirth = new QkanDateTextField();

      getPatientBirthContainer().setText("���N����");

      patientBirth.setBindPath("PATIENT_BIRTHDAY");

      patientBirth.setEditable(false);

      addPatientBirth();
    }
    return patientBirth;

  }

  /**
   * ���N�����R���e�i���擾���܂��B
   * @return ���N�����R���e�i
   */
  protected ACLabelContainer getPatientBirthContainer(){
    if(patientBirthContainer==null){
      patientBirthContainer = new ACLabelContainer();
      patientBirthContainer.setFollowChildEnabled(true);
      patientBirthContainer.setVAlignment(VRLayout.CENTER);
      patientBirthContainer.add(getPatientBirth(), null);
    }
    return patientBirthContainer;
  }

  /**
   * �v���F����擾���܂��B
   * @return �v���F��
   */
  public ACValueArrayRadioButtonGroup getJotaiCode(){
    if(jotaiCode==null){

      jotaiCode = new ACValueArrayRadioButtonGroup();

      getJotaiCodeContainer().setText("�v���F��");

      jotaiCode.setBindPath("JOTAI_CODE");

      jotaiCode.setUseClearButton(false);

      jotaiCode.setModel(getJotaiCodeModel());

      jotaiCode.setValues(new int[]{1,12,13,11,21,22,23,24,25});

      addJotaiCode();
    }
    return jotaiCode;

  }

  /**
   * �v���F��R���e�i���擾���܂��B
   * @return �v���F��R���e�i
   */
  protected ACLabelContainer getJotaiCodeContainer(){
    if(jotaiCodeContainer==null){
      jotaiCodeContainer = new ACLabelContainer();
      jotaiCodeContainer.setFollowChildEnabled(true);
      jotaiCodeContainer.setVAlignment(VRLayout.CENTER);
      jotaiCodeContainer.add(getJotaiCode(), null);
    }
    return jotaiCodeContainer;
  }

  /**
   * �v���F�胂�f�����擾���܂��B
   * @return �v���F�胂�f��
   */
  protected ACListModelAdapter getJotaiCodeModel(){
    if(jotaiCodeModel==null){
      jotaiCodeModel = new ACListModelAdapter();
      addJotaiCodeModel();
    }
    return jotaiCodeModel;
  }

  /**
   * �������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getYokaigodoRadioItem1(){
    if(yokaigodoRadioItem1==null){

      yokaigodoRadioItem1 = new ACRadioButtonItem();

      yokaigodoRadioItem1.setText("����");

      yokaigodoRadioItem1.setGroup(getJotaiCode());

      yokaigodoRadioItem1.setConstraints(VRLayout.FLOW);

      addYokaigodoRadioItem1();
    }
    return yokaigodoRadioItem1;

  }

  /**
   * �v�x���P���擾���܂��B
   * @return �v�x���P
   */
  public ACRadioButtonItem getYokaigodoRadioItem8(){
    if(yokaigodoRadioItem8==null){

      yokaigodoRadioItem8 = new ACRadioButtonItem();

      yokaigodoRadioItem8.setText("�v�x���P");

      yokaigodoRadioItem8.setGroup(getJotaiCode());

      yokaigodoRadioItem8.setConstraints(VRLayout.FLOW);

      addYokaigodoRadioItem8();
    }
    return yokaigodoRadioItem8;

  }

  /**
   * �v�x���Q���擾���܂��B
   * @return �v�x���Q
   */
  public ACRadioButtonItem getYokaigodoRadioItem9(){
    if(yokaigodoRadioItem9==null){

      yokaigodoRadioItem9 = new ACRadioButtonItem();

      yokaigodoRadioItem9.setText("�v�x���Q");

      yokaigodoRadioItem9.setGroup(getJotaiCode());

      yokaigodoRadioItem9.setConstraints(VRLayout.FLOW_RETURN);

      addYokaigodoRadioItem9();
    }
    return yokaigodoRadioItem9;

  }

  /**
   * �o�ߓI�v�����擾���܂��B
   * @return �o�ߓI�v���
   */
  public ACRadioButtonItem getYokaigodoRadioItem2(){
    if(yokaigodoRadioItem2==null){

      yokaigodoRadioItem2 = new ACRadioButtonItem();

      yokaigodoRadioItem2.setText("�o�ߓI�v���");

      yokaigodoRadioItem2.setGroup(getJotaiCode());

      yokaigodoRadioItem2.setConstraints(VRLayout.FLOW);

      addYokaigodoRadioItem2();
    }
    return yokaigodoRadioItem2;

  }

  /**
   * �v���1���擾���܂��B
   * @return �v���1
   */
  public ACRadioButtonItem getYokaigodoRadioItem3(){
    if(yokaigodoRadioItem3==null){

      yokaigodoRadioItem3 = new ACRadioButtonItem();

      yokaigodoRadioItem3.setText("�v���1");

      yokaigodoRadioItem3.setGroup(getJotaiCode());

      yokaigodoRadioItem3.setConstraints(VRLayout.FLOW);

      addYokaigodoRadioItem3();
    }
    return yokaigodoRadioItem3;

  }

  /**
   * �v���2���擾���܂��B
   * @return �v���2
   */
  public ACRadioButtonItem getYokaigodoRadioItem4(){
    if(yokaigodoRadioItem4==null){

      yokaigodoRadioItem4 = new ACRadioButtonItem();

      yokaigodoRadioItem4.setText("�v���2");

      yokaigodoRadioItem4.setGroup(getJotaiCode());

      yokaigodoRadioItem4.setConstraints(VRLayout.FLOW);

      addYokaigodoRadioItem4();
    }
    return yokaigodoRadioItem4;

  }

  /**
   * �v���3���擾���܂��B
   * @return �v���3
   */
  public ACRadioButtonItem getYokaigodoRadioItem5(){
    if(yokaigodoRadioItem5==null){

      yokaigodoRadioItem5 = new ACRadioButtonItem();

      yokaigodoRadioItem5.setText("�v���3");

      yokaigodoRadioItem5.setGroup(getJotaiCode());

      yokaigodoRadioItem5.setConstraints(VRLayout.FLOW);

      addYokaigodoRadioItem5();
    }
    return yokaigodoRadioItem5;

  }

  /**
   * �v���4���擾���܂��B
   * @return �v���4
   */
  public ACRadioButtonItem getYokaigodoRadioItem6(){
    if(yokaigodoRadioItem6==null){

      yokaigodoRadioItem6 = new ACRadioButtonItem();

      yokaigodoRadioItem6.setText("�v���4");

      yokaigodoRadioItem6.setGroup(getJotaiCode());

      yokaigodoRadioItem6.setConstraints(VRLayout.FLOW);

      addYokaigodoRadioItem6();
    }
    return yokaigodoRadioItem6;

  }

  /**
   * �v���5���擾���܂��B
   * @return �v���5
   */
  public ACRadioButtonItem getYokaigodoRadioItem7(){
    if(yokaigodoRadioItem7==null){

      yokaigodoRadioItem7 = new ACRadioButtonItem();

      yokaigodoRadioItem7.setText("�v���5");

      yokaigodoRadioItem7.setGroup(getJotaiCode());

      yokaigodoRadioItem7.setConstraints(VRLayout.FLOW);

      addYokaigodoRadioItem7();
    }
    return yokaigodoRadioItem7;

  }

  /**
   * ���p�ҏ��T�u�̈�2���擾���܂��B
   * @return ���p�ҏ��T�u�̈�2
   */
  public ACPanel getPatients2(){
    if(patients2==null){

      patients2 = new ACPanel();

      addPatients2();
    }
    return patients2;

  }

  /**
   * ��Q�V�l���퐶�������x���擾���܂��B
   * @return ��Q�V�l���퐶�������x
   */
  public ACClearableRadioButtonGroup getShogaiJiritsudo(){
    if(shogaiJiritsudo==null){

      shogaiJiritsudo = new ACClearableRadioButtonGroup();

      getShogaiJiritsudoContainer().setText("��Q����҂̓��퐶�������x");

      shogaiJiritsudo.setBindPath("SHOGAI_JIRITSUDO");

      shogaiJiritsudo.setUseClearButton(true);

      shogaiJiritsudo.setModel(getShogaiJiritsudoModel());

      addShogaiJiritsudo();
    }
    return shogaiJiritsudo;

  }

  /**
   * ��Q�V�l���퐶�������x�R���e�i���擾���܂��B
   * @return ��Q�V�l���퐶�������x�R���e�i
   */
  protected ACLabelContainer getShogaiJiritsudoContainer(){
    if(shogaiJiritsudoContainer==null){
      shogaiJiritsudoContainer = new ACLabelContainer();
      shogaiJiritsudoContainer.setFollowChildEnabled(true);
      shogaiJiritsudoContainer.setVAlignment(VRLayout.CENTER);
      shogaiJiritsudoContainer.add(getShogaiJiritsudo(), null);
    }
    return shogaiJiritsudoContainer;
  }

  /**
   * ��Q�V�l���퐶�������x���f�����擾���܂��B
   * @return ��Q�V�l���퐶�������x���f��
   */
  protected ACListModelAdapter getShogaiJiritsudoModel(){
    if(shogaiJiritsudoModel==null){
      shogaiJiritsudoModel = new ACListModelAdapter();
      addShogaiJiritsudoModel();
    }
    return shogaiJiritsudoModel;
  }

  /**
   * ��Q�V�l���퐶�������x1���擾���܂��B
   * @return ��Q�V�l���퐶�������x1
   */
  public ACRadioButtonItem getShogaiJiritsudoRadioItem1(){
    if(shogaiJiritsudoRadioItem1==null){

      shogaiJiritsudoRadioItem1 = new ACRadioButtonItem();

      shogaiJiritsudoRadioItem1.setText("����");

      shogaiJiritsudoRadioItem1.setGroup(getShogaiJiritsudo());

      addShogaiJiritsudoRadioItem1();
    }
    return shogaiJiritsudoRadioItem1;

  }

  /**
   * ��Q�V�l���퐶�������x2���擾���܂��B
   * @return ��Q�V�l���퐶�������x2
   */
  public ACRadioButtonItem getShogaiJiritsudoRadioItem2(){
    if(shogaiJiritsudoRadioItem2==null){

      shogaiJiritsudoRadioItem2 = new ACRadioButtonItem();

      shogaiJiritsudoRadioItem2.setText("�i");

      shogaiJiritsudoRadioItem2.setGroup(getShogaiJiritsudo());

      addShogaiJiritsudoRadioItem2();
    }
    return shogaiJiritsudoRadioItem2;

  }

  /**
   * ��Q�V�l���퐶�������x3���擾���܂��B
   * @return ��Q�V�l���퐶�������x3
   */
  public ACRadioButtonItem getShogaiJiritsudoRadioItem3(){
    if(shogaiJiritsudoRadioItem3==null){

      shogaiJiritsudoRadioItem3 = new ACRadioButtonItem();

      shogaiJiritsudoRadioItem3.setText("�`");

      shogaiJiritsudoRadioItem3.setGroup(getShogaiJiritsudo());

      addShogaiJiritsudoRadioItem3();
    }
    return shogaiJiritsudoRadioItem3;

  }

  /**
   * ��Q�V�l���퐶�������x4���擾���܂��B
   * @return ��Q�V�l���퐶�������x4
   */
  public ACRadioButtonItem getShogaiJiritsudoRadioItem4(){
    if(shogaiJiritsudoRadioItem4==null){

      shogaiJiritsudoRadioItem4 = new ACRadioButtonItem();

      shogaiJiritsudoRadioItem4.setText("�a");

      shogaiJiritsudoRadioItem4.setGroup(getShogaiJiritsudo());

      addShogaiJiritsudoRadioItem4();
    }
    return shogaiJiritsudoRadioItem4;

  }

  /**
   * ��Q�V�l���퐶�������x5���擾���܂��B
   * @return ��Q�V�l���퐶�������x5
   */
  public ACRadioButtonItem getShogaiJiritsudoRadioItem5(){
    if(shogaiJiritsudoRadioItem5==null){

      shogaiJiritsudoRadioItem5 = new ACRadioButtonItem();

      shogaiJiritsudoRadioItem5.setText("�b");

      shogaiJiritsudoRadioItem5.setGroup(getShogaiJiritsudo());

      addShogaiJiritsudoRadioItem5();
    }
    return shogaiJiritsudoRadioItem5;

  }

  /**
   * �F�m�ǘV�l���퐶�������x���擾���܂��B
   * @return �F�m�ǘV�l���퐶�������x
   */
  public ACClearableRadioButtonGroup getNinchishoJiritsudo(){
    if(ninchishoJiritsudo==null){

      ninchishoJiritsudo = new ACClearableRadioButtonGroup();

      getNinchishoJiritsudoContainer().setText("�F�m�Ǎ���҂̓��퐶�������x");

      ninchishoJiritsudo.setBindPath("NINCHISHO_JIRITSUDO");

      ninchishoJiritsudo.setUseClearButton(true);

      ninchishoJiritsudo.setModel(getNinchishoJiritsudoModel());

      addNinchishoJiritsudo();
    }
    return ninchishoJiritsudo;

  }

  /**
   * �F�m�ǘV�l���퐶�������x�R���e�i���擾���܂��B
   * @return �F�m�ǘV�l���퐶�������x�R���e�i
   */
  protected ACLabelContainer getNinchishoJiritsudoContainer(){
    if(ninchishoJiritsudoContainer==null){
      ninchishoJiritsudoContainer = new ACLabelContainer();
      ninchishoJiritsudoContainer.setFollowChildEnabled(true);
      ninchishoJiritsudoContainer.setVAlignment(VRLayout.CENTER);
      ninchishoJiritsudoContainer.add(getNinchishoJiritsudo(), null);
    }
    return ninchishoJiritsudoContainer;
  }

  /**
   * �F�m�ǘV�l���퐶�������x���f�����擾���܂��B
   * @return �F�m�ǘV�l���퐶�������x���f��
   */
  protected ACListModelAdapter getNinchishoJiritsudoModel(){
    if(ninchishoJiritsudoModel==null){
      ninchishoJiritsudoModel = new ACListModelAdapter();
      addNinchishoJiritsudoModel();
    }
    return ninchishoJiritsudoModel;
  }

  /**
   * �F�m�ǘV�l���퐶�������x1���擾���܂��B
   * @return �F�m�ǘV�l���퐶�������x1
   */
  public ACRadioButtonItem getNinchishoJiritsudoRadioItem1(){
    if(ninchishoJiritsudoRadioItem1==null){

      ninchishoJiritsudoRadioItem1 = new ACRadioButtonItem();

      ninchishoJiritsudoRadioItem1.setText("����");

      ninchishoJiritsudoRadioItem1.setGroup(getNinchishoJiritsudo());

      addNinchishoJiritsudoRadioItem1();
    }
    return ninchishoJiritsudoRadioItem1;

  }

  /**
   * �F�m�ǘV�l���퐶�������x2���擾���܂��B
   * @return �F�m�ǘV�l���퐶�������x2
   */
  public ACRadioButtonItem getNinchishoJiritsudoRadioItem2(){
    if(ninchishoJiritsudoRadioItem2==null){

      ninchishoJiritsudoRadioItem2 = new ACRadioButtonItem();

      ninchishoJiritsudoRadioItem2.setText("I");

      ninchishoJiritsudoRadioItem2.setGroup(getNinchishoJiritsudo());

      addNinchishoJiritsudoRadioItem2();
    }
    return ninchishoJiritsudoRadioItem2;

  }

  /**
   * �F�m�ǘV�l���퐶�������x3���擾���܂��B
   * @return �F�m�ǘV�l���퐶�������x3
   */
  public ACRadioButtonItem getNinchishoJiritsudoRadioItem3(){
    if(ninchishoJiritsudoRadioItem3==null){

      ninchishoJiritsudoRadioItem3 = new ACRadioButtonItem();

      ninchishoJiritsudoRadioItem3.setText("II");

      ninchishoJiritsudoRadioItem3.setGroup(getNinchishoJiritsudo());

      addNinchishoJiritsudoRadioItem3();
    }
    return ninchishoJiritsudoRadioItem3;

  }

  /**
   * �F�m�ǘV�l���퐶�������x4���擾���܂��B
   * @return �F�m�ǘV�l���퐶�������x4
   */
  public ACRadioButtonItem getNinchishoJiritsudoRadioItem4(){
    if(ninchishoJiritsudoRadioItem4==null){

      ninchishoJiritsudoRadioItem4 = new ACRadioButtonItem();

      ninchishoJiritsudoRadioItem4.setText("III");

      ninchishoJiritsudoRadioItem4.setGroup(getNinchishoJiritsudo());

      addNinchishoJiritsudoRadioItem4();
    }
    return ninchishoJiritsudoRadioItem4;

  }

  /**
   * �F�m�ǘV�l���퐶�������x5���擾���܂��B
   * @return �F�m�ǘV�l���퐶�������x5
   */
  public ACRadioButtonItem getNinchishoJiritsudoRadioItem5(){
    if(ninchishoJiritsudoRadioItem5==null){

      ninchishoJiritsudoRadioItem5 = new ACRadioButtonItem();

      ninchishoJiritsudoRadioItem5.setText("IV");

      ninchishoJiritsudoRadioItem5.setGroup(getNinchishoJiritsudo());

      addNinchishoJiritsudoRadioItem5();
    }
    return ninchishoJiritsudoRadioItem5;

  }

  /**
   * �F�m�ǘV�l���퐶�������x6���擾���܂��B
   * @return �F�m�ǘV�l���퐶�������x6
   */
  public ACRadioButtonItem getNinchishoJiritsudoRadioItem6(){
    if(ninchishoJiritsudoRadioItem6==null){

      ninchishoJiritsudoRadioItem6 = new ACRadioButtonItem();

      ninchishoJiritsudoRadioItem6.setText("�l");

      ninchishoJiritsudoRadioItem6.setGroup(getNinchishoJiritsudo());

      addNinchishoJiritsudoRadioItem6();
    }
    return ninchishoJiritsudoRadioItem6;

  }

  /**
   * ���p�ҏZ�����擾���܂��B
   * @return ���p�ҏZ��
   */
  public ACTextArea getPatientAddress(){
    if(patientAddress==null){

      patientAddress = new ACTextArea();

      getPatientAddressContainer().setText("���p�ҏZ��");

      patientAddress.setBindPath("PATIENT_ADDRESS");

      patientAddress.setColumns(80);

      patientAddress.setRows(3);

      patientAddress.setMaxRows(2);

      patientAddress.setIMEMode(InputSubset.KANJI);

      patientAddress.setMaxLength(120);

      patientAddress.setLineWrap(true);

      addPatientAddress();
    }
    return patientAddress;

  }

  /**
   * ���p�ҏZ���R���e�i���擾���܂��B
   * @return ���p�ҏZ���R���e�i
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
   * (�d�b�ԍ��E�R���e�i)���擾���܂��B
   * @return (�d�b�ԍ��E�R���e�i)
   */
  public ACLabelContainer getPatientTelContena(){
    if(patientTelContena==null){

      patientTelContena = new ACLabelContainer();

      patientTelContena.setText("�A����");

      addPatientTelContena();
    }
    return patientTelContena;

  }

  /**
   * �d�b�ԍ��E�e�L�X�g1���擾���܂��B
   * @return �d�b�ԍ��E�e�L�X�g1
   */
  public ACTextField getPatientTel2(){
    if(patientTel2==null){

      patientTel2 = new ACTextField();

      patientTel2.setBindPath("PATIENT_TEL_FIRST");

      patientTel2.setColumns(4);

      patientTel2.setCharType(VRCharType.ONLY_DIGIT);

      patientTel2.setIMEMode(InputSubset.LATIN);

      patientTel2.setMaxLength(6);

      addPatientTel2();
    }
    return patientTel2;

  }

  /**
   * �d�b�ԍ��E���x��1���擾���܂��B
   * @return �d�b�ԍ��E���x��1
   */
  public ACLabel getPatientTel3(){
    if(patientTel3==null){

      patientTel3 = new ACLabel();

      patientTel3.setText("-");

      addPatientTel3();
    }
    return patientTel3;

  }

  /**
   * �d�b�ԍ��E�e�L�X�g2���擾���܂��B
   * @return �d�b�ԍ��E�e�L�X�g2
   */
  public ACTextField getPatientTel4(){
    if(patientTel4==null){

      patientTel4 = new ACTextField();

      patientTel4.setBindPath("PATIENT_TEL_SECOND");

      patientTel4.setColumns(4);

      patientTel4.setCharType(VRCharType.ONLY_DIGIT);

      patientTel4.setIMEMode(InputSubset.LATIN);

      patientTel4.setMaxLength(4);

      addPatientTel4();
    }
    return patientTel4;

  }

  /**
   * �d�b�ԍ��E���x��2���擾���܂��B
   * @return �d�b�ԍ��E���x��2
   */
  public ACLabel getPatientTel5(){
    if(patientTel5==null){

      patientTel5 = new ACLabel();

      patientTel5.setText("-");

      addPatientTel5();
    }
    return patientTel5;

  }

  /**
   * �d�b�ԍ��E�e�L�X�g3���擾���܂��B
   * @return �d�b�ԍ��E�e�L�X�g3
   */
  public ACTextField getPatientTel6(){
    if(patientTel6==null){

      patientTel6 = new ACTextField();

      patientTel6.setBindPath("PATIENT_TEL_THIRD");

      patientTel6.setColumns(4);

      patientTel6.setCharType(VRCharType.ONLY_DIGIT);

      patientTel6.setIMEMode(InputSubset.LATIN);

      patientTel6.setMaxLength(4);

      addPatientTel6();
    }
    return patientTel6;

  }

  /**
   * �^�u�̈���擾���܂��B
   * @return �^�u�̈�
   */
  public JTabbedPane getTabsArea(){
    if(tabsArea==null){

      tabsArea = new JTabbedPane();

      addTabsArea();
    }
    return tabsArea;

  }

  /**
   * ��Ë@�֏��̈���擾���܂��B
   * @return ��Ë@�֏��̈�
   */
  public ACPanel getProviderAndMedicaiInfoArea(){
    if(providerAndMedicaiInfoArea==null){

      providerAndMedicaiInfoArea = new ACPanel();

      addProviderAndMedicaiInfoArea();
    }
    return providerAndMedicaiInfoArea;

  }

  /**
   * ��Ë@�փO���[�v���擾���܂��B
   * @return ��Ë@�փO���[�v
   */
  public ACGroupBox getMedicalInfoGroup(){
    if(medicalInfoGroup==null){

      medicalInfoGroup = new ACGroupBox();

      medicalInfoGroup.setText("���񋟌���Ë@�ւ̏��ݒn�y�і���");

      addMedicalInfoGroup();
    }
    return medicalInfoGroup;

  }

  /**
   * ��Ë@�֖����擾���܂��B
   * @return ��Ë@�֖�
   */
  public ACComboBox getMedicalInstitusion(){
    if(medicalInstitusion==null){

      medicalInstitusion = new ACComboBox();

      getMedicalInstitusionContainer().setText("��Ë@�֖�");

      medicalInstitusion.setBindPath("MEDICAL_FACILITY_NAME");

      medicalInstitusion.setEditable(true);

      medicalInstitusion.setModelBindPath("MEDICAL_INSTITUSIONS");

      medicalInstitusion.setRenderBindPath("MEDICAL_FACILITY_NAME");

      medicalInstitusion.setIMEMode(InputSubset.KANJI);

      medicalInstitusion.setMaxLength(60);

      medicalInstitusion.setMaxColumns(45);

      medicalInstitusion.setModel(getMedicalInstitusionModel());

      addMedicalInstitusion();
    }
    return medicalInstitusion;

  }

  /**
   * ��Ë@�֖��R���e�i���擾���܂��B
   * @return ��Ë@�֖��R���e�i
   */
  protected ACLabelContainer getMedicalInstitusionContainer(){
    if(medicalInstitusionContainer==null){
      medicalInstitusionContainer = new ACLabelContainer();
      medicalInstitusionContainer.setFollowChildEnabled(true);
      medicalInstitusionContainer.setVAlignment(VRLayout.CENTER);
      medicalInstitusionContainer.add(getMedicalInstitusion(), null);
    }
    return medicalInstitusionContainer;
  }

  /**
   * ��Ë@�֖����f�����擾���܂��B
   * @return ��Ë@�֖����f��
   */
  protected ACComboBoxModelAdapter getMedicalInstitusionModel(){
    if(medicalInstitusionModel==null){
      medicalInstitusionModel = new ACComboBoxModelAdapter();
      addMedicalInstitusionModel();
    }
    return medicalInstitusionModel;
  }

  /**
   * ��Ë@�֏Z�����擾���܂��B
   * @return ��Ë@�֏Z��
   */
  public ACTextField getMedicalAddress(){
    if(medicalAddress==null){

      medicalAddress = new ACTextField();

      getMedicalAddressContainer().setText("�Z��");

      medicalAddress.setBindPath("MEDICAL_FACILITY_ADDRESS");

      medicalAddress.setColumns(45);

      medicalAddress.setIMEMode(InputSubset.KANJI);

      medicalAddress.setMaxLength(100);

      addMedicalAddress();
    }
    return medicalAddress;

  }

  /**
   * ��Ë@�֏Z���R���e�i���擾���܂��B
   * @return ��Ë@�֏Z���R���e�i
   */
  protected ACLabelContainer getMedicalAddressContainer(){
    if(medicalAddressContainer==null){
      medicalAddressContainer = new ACLabelContainer();
      medicalAddressContainer.setFollowChildEnabled(true);
      medicalAddressContainer.setVAlignment(VRLayout.CENTER);
      medicalAddressContainer.add(getMedicalAddress(), null);
    }
    return medicalAddressContainer;
  }

  /**
   * ��Ë@�֓d�b�ԍ��E�R���e�i���擾���܂��B
   * @return ��Ë@�֓d�b�ԍ��E�R���e�i
   */
  public ACLabelContainer getMedicalTelContena(){
    if(medicalTelContena==null){

      medicalTelContena = new ACLabelContainer();

      medicalTelContena.setText("�A����");

      addMedicalTelContena();
    }
    return medicalTelContena;

  }

  /**
   * �d�b�ԍ��E�e�L�X�g1���擾���܂��B
   * @return �d�b�ԍ��E�e�L�X�g1
   */
  public ACTextField getMedicalTel2(){
    if(medicalTel2==null){

      medicalTel2 = new ACTextField();

      medicalTel2.setBindPath("MEDICAL_FACILITY_TEL_FIRST");

      medicalTel2.setColumns(4);

      medicalTel2.setCharType(VRCharType.ONLY_DIGIT);

      medicalTel2.setIMEMode(InputSubset.LATIN);

      medicalTel2.setMaxLength(6);

      addMedicalTel2();
    }
    return medicalTel2;

  }

  /**
   * �d�b�ԍ��E���x��1���擾���܂��B
   * @return �d�b�ԍ��E���x��1
   */
  public ACLabel getMedicalTel3(){
    if(medicalTel3==null){

      medicalTel3 = new ACLabel();

      medicalTel3.setText("-");

      addMedicalTel3();
    }
    return medicalTel3;

  }

  /**
   * �d�b�ԍ��E�e�L�X�g2���擾���܂��B
   * @return �d�b�ԍ��E�e�L�X�g2
   */
  public ACTextField getMedicalTel4(){
    if(medicalTel4==null){

      medicalTel4 = new ACTextField();

      medicalTel4.setBindPath("MEDICAL_FACILITY_TEL_SECOND");

      medicalTel4.setColumns(4);

      medicalTel4.setCharType(VRCharType.ONLY_DIGIT);

      medicalTel4.setIMEMode(InputSubset.LATIN);

      medicalTel4.setMaxLength(4);

      addMedicalTel4();
    }
    return medicalTel4;

  }

  /**
   * �d�b�ԍ��E���x��2���擾���܂��B
   * @return �d�b�ԍ��E���x��2
   */
  public ACLabel getMedicalTel5(){
    if(medicalTel5==null){

      medicalTel5 = new ACLabel();

      medicalTel5.setText("-");

      addMedicalTel5();
    }
    return medicalTel5;

  }

  /**
   * �d�b�ԍ��E�e�L�X�g3���擾���܂��B
   * @return �d�b�ԍ��E�e�L�X�g3
   */
  public ACTextField getMedicalTel6(){
    if(medicalTel6==null){

      medicalTel6 = new ACTextField();

      medicalTel6.setBindPath("MEDICAL_FACILITY_TEL_THIRD");

      medicalTel6.setColumns(4);

      medicalTel6.setCharType(VRCharType.ONLY_DIGIT);

      medicalTel6.setIMEMode(InputSubset.LATIN);

      medicalTel6.setMaxLength(4);

      addMedicalTel6();
    }
    return medicalTel6;

  }

  /**
   * �S���㎁�����擾���܂��B
   * @return �S���㎁��
   */
  public ACTextField getDoctorName(){
    if(doctorName==null){

      doctorName = new ACTextField();

      getDoctorNameContainer().setText("��t����");

      doctorName.setBindPath("DOCTOR_NAME");

      doctorName.setColumns(30);

      doctorName.setIMEMode(InputSubset.KANJI);

      doctorName.setMaxLength(25);

      addDoctorName();
    }
    return doctorName;

  }

  /**
   * �S���㎁���R���e�i���擾���܂��B
   * @return �S���㎁���R���e�i
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
   * Tab1�u�ݑ�×{�����̃|�C���g�v���擾���܂��B
   * @return Tab1�u�ݑ�×{�����̃|�C���g�v
   */
  public ACPanel getPoints(){
    if(points==null){

      points = new ACPanel();

      addPoints();
    }
    return points;

  }

  /**
   * Tab1�E�ݑ�×{�����̃|�C���g�E�T�u�̈�1���擾���܂��B
   * @return Tab1�E�ݑ�×{�����̃|�C���g�E�T�u�̈�1
   */
  public ACPanel getPoints1(){
    if(points1==null){

      points1 = new ACPanel();

      addPoints1();
    }
    return points1;

  }

  /**
   * ���Ȃ��̎厡��L���v�V�������擾���܂��B
   * @return ���Ȃ��̎厡��L���v�V����
   */
  public ACLabel getYourDoctorCaption1(){
    if(yourDoctorCaption1==null){

      yourDoctorCaption1 = new ACLabel();

      yourDoctorCaption1.setText("���Ȃ��̎厡��́A���A");

      addYourDoctorCaption1();
    }
    return yourDoctorCaption1;

  }

  /**
   * ���Ȃ��̎厡����擾���܂��B
   * @return ���Ȃ��̎厡��
   */
  public ACLabel getYourDoctor(){
    if(yourDoctor==null){

      yourDoctor = new ACLabel();

      yourDoctor.setBindPath("YOUR_DOCTOR_NAME");

      addYourDoctor();
    }
    return yourDoctor;

  }

  /**
   * ���Ȃ��̎厡��L���v�V�������擾���܂��B
   * @return ���Ȃ��̎厡��L���v�V����
   */
  public ACLabel getYourDoctorCaption2(){
    if(yourDoctorCaption2==null){

      yourDoctorCaption2 = new ACLabel();

      yourDoctorCaption2.setText("�ł��B");

      addYourDoctorCaption2();
    }
    return yourDoctorCaption2;

  }

  /**
   * �ݑ�×{�����̃|�C���g�쐬�N�������擾���܂��B
   * @return �ݑ�×{�����̃|�C���g�쐬�N����
   */
  public QkanYearDateTextField getCreateDateZaitaku(){
    if(createDateZaitaku==null){

      createDateZaitaku = new QkanYearDateTextField();

      getCreateDateZaitakuContainer().setText("�쐬�N����");

      createDateZaitaku.setBindPath("CREATE_DATE_ZAITAKU");

      createDateZaitaku.setVisible(false);

      createDateZaitaku.setEditable(true);

      addCreateDateZaitaku();
    }
    return createDateZaitaku;

  }

  /**
   * �ݑ�×{�����̃|�C���g�쐬�N�����R���e�i���擾���܂��B
   * @return �ݑ�×{�����̃|�C���g�쐬�N�����R���e�i
   */
  protected ACLabelContainer getCreateDateZaitakuContainer(){
    if(createDateZaitakuContainer==null){
      createDateZaitakuContainer = new ACLabelContainer();
      createDateZaitakuContainer.setFollowChildEnabled(true);
      createDateZaitakuContainer.setVAlignment(VRLayout.CENTER);
      createDateZaitakuContainer.add(getCreateDateZaitaku(), null);
    }
    return createDateZaitakuContainer;
  }

  /**
   * �����̖K����R���e�i���擾���܂��B
   * @return �����̖K����R���e�i
   */
  public ACLabelContainer getVisitThisMonthContainer(){
    if(visitThisMonthContainer==null){

      visitThisMonthContainer = new ACLabelContainer();

      visitThisMonthContainer.setText("�����̖K���");

      addVisitThisMonthContainer();
    }
    return visitThisMonthContainer;

  }

  /**
   * �����̖K���1���擾���܂��B
   * @return �����̖K���1
   */
  public ACTextField getVisitThisMonth1(){
    if(visitThisMonth1==null){

      visitThisMonth1 = new ACTextField();

      visitThisMonth1.setBindPath("VISIT_THIS_MONTH_NO1");

      visitThisMonth1.setColumns(2);

      visitThisMonth1.setCharType(VRCharType.ONLY_DIGIT);

      visitThisMonth1.setHorizontalAlignment(SwingConstants.RIGHT);

      visitThisMonth1.setIMEMode(InputSubset.LATIN);

      visitThisMonth1.setMaxLength(2);

      addVisitThisMonth1();
    }
    return visitThisMonth1;

  }

  /**
   * �����̖K���2���擾���܂��B
   * @return �����̖K���2
   */
  public ACTextField getVisitThisMonth2(){
    if(visitThisMonth2==null){

      visitThisMonth2 = new ACTextField();

      visitThisMonth2.setBindPath("VISIT_THIS_MONTH_NO2");

      visitThisMonth2.setColumns(2);

      visitThisMonth2.setCharType(VRCharType.ONLY_DIGIT);

      visitThisMonth2.setHorizontalAlignment(SwingConstants.RIGHT);

      visitThisMonth2.setIMEMode(InputSubset.LATIN);

      visitThisMonth2.setMaxLength(2);

      addVisitThisMonth2();
    }
    return visitThisMonth2;

  }

  /**
   * �����̖K���3���擾���܂��B
   * @return �����̖K���3
   */
  public ACTextField getVisitThisMonth3(){
    if(visitThisMonth3==null){

      visitThisMonth3 = new ACTextField();

      visitThisMonth3.setBindPath("VISIT_THIS_MONTH_NO3");

      visitThisMonth3.setColumns(2);

      visitThisMonth3.setCharType(VRCharType.ONLY_DIGIT);

      visitThisMonth3.setHorizontalAlignment(SwingConstants.RIGHT);

      visitThisMonth3.setIMEMode(InputSubset.LATIN);

      visitThisMonth3.setMaxLength(2);

      addVisitThisMonth3();
    }
    return visitThisMonth3;

  }

  /**
   * �����̖K���4���擾���܂��B
   * @return �����̖K���4
   */
  public ACTextField getVisitThisMonth4(){
    if(visitThisMonth4==null){

      visitThisMonth4 = new ACTextField();

      visitThisMonth4.setBindPath("VISIT_THIS_MONTH_NO4");

      visitThisMonth4.setColumns(2);

      visitThisMonth4.setCharType(VRCharType.ONLY_DIGIT);

      visitThisMonth4.setHorizontalAlignment(SwingConstants.RIGHT);

      visitThisMonth4.setIMEMode(InputSubset.LATIN);

      visitThisMonth4.setMaxLength(2);

      addVisitThisMonth4();
    }
    return visitThisMonth4;

  }

  /**
   * �����̖K���5���擾���܂��B
   * @return �����̖K���5
   */
  public ACTextField getVisitThisMonth5(){
    if(visitThisMonth5==null){

      visitThisMonth5 = new ACTextField();

      visitThisMonth5.setBindPath("VISIT_THIS_MONTH_NO5");

      visitThisMonth5.setColumns(2);

      visitThisMonth5.setCharType(VRCharType.ONLY_DIGIT);

      visitThisMonth5.setHorizontalAlignment(SwingConstants.RIGHT);

      visitThisMonth5.setIMEMode(InputSubset.LATIN);

      visitThisMonth5.setMaxLength(2);

      addVisitThisMonth5();
    }
    return visitThisMonth5;

  }

  /**
   * �����̖K���6���擾���܂��B
   * @return �����̖K���6
   */
  public ACTextField getVisitThisMonth6(){
    if(visitThisMonth6==null){

      visitThisMonth6 = new ACTextField();

      visitThisMonth6.setBindPath("VISIT_THIS_MONTH_NO6");

      visitThisMonth6.setColumns(2);

      visitThisMonth6.setCharType(VRCharType.ONLY_DIGIT);

      visitThisMonth6.setHorizontalAlignment(SwingConstants.RIGHT);

      visitThisMonth6.setIMEMode(InputSubset.LATIN);

      visitThisMonth6.setMaxLength(2);

      addVisitThisMonth6();
    }
    return visitThisMonth6;

  }

  /**
   * �����̖K����L���v�V�������擾���܂��B
   * @return �����̖K����L���v�V����
   */
  public ACLabel getVisitThisMonthCaption(){
    if(visitThisMonthCaption==null){

      visitThisMonthCaption = new ACLabel();

      visitThisMonthCaption.setText("��");

      addVisitThisMonthCaption();
    }
    return visitThisMonthCaption;

  }

  /**
   * ���ѓǍ��݃{�^�����擾���܂��B
   * @return ���ѓǍ��݃{�^��
   */
  public ACButton getResultReadButton(){
    if(resultReadButton==null){

      resultReadButton = new ACButton();

      resultReadButton.setText("���ѓǍ�");

      addResultReadButton();
    }
    return resultReadButton;

  }

  /**
   * �����̖K����R���e�i���擾���܂��B
   * @return �����̖K����R���e�i
   */
  public ACLabelContainer getVisitNextMonthContainer(){
    if(visitNextMonthContainer==null){

      visitNextMonthContainer = new ACLabelContainer();

      visitNextMonthContainer.setText("�����̖K��\��");

      addVisitNextMonthContainer();
    }
    return visitNextMonthContainer;

  }

  /**
   * �����̖K��\��1���擾���܂��B
   * @return �����̖K��\��1
   */
  public ACTextField getVisitNextMonth1(){
    if(visitNextMonth1==null){

      visitNextMonth1 = new ACTextField();

      visitNextMonth1.setBindPath("VISIT_NEXT_MONTH_NO1");

      visitNextMonth1.setColumns(2);

      visitNextMonth1.setCharType(VRCharType.ONLY_DIGIT);

      visitNextMonth1.setHorizontalAlignment(SwingConstants.RIGHT);

      visitNextMonth1.setIMEMode(InputSubset.LATIN);

      visitNextMonth1.setMaxLength(2);

      addVisitNextMonth1();
    }
    return visitNextMonth1;

  }

  /**
   * �����̖K��\��2���擾���܂��B
   * @return �����̖K��\��2
   */
  public ACTextField getVisitNextMonth2(){
    if(visitNextMonth2==null){

      visitNextMonth2 = new ACTextField();

      visitNextMonth2.setBindPath("VISIT_NEXT_MONTH_NO2");

      visitNextMonth2.setColumns(2);

      visitNextMonth2.setCharType(VRCharType.ONLY_DIGIT);

      visitNextMonth2.setHorizontalAlignment(SwingConstants.RIGHT);

      visitNextMonth2.setIMEMode(InputSubset.LATIN);

      visitNextMonth2.setMaxLength(2);

      addVisitNextMonth2();
    }
    return visitNextMonth2;

  }

  /**
   * �����̖K��\��3���擾���܂��B
   * @return �����̖K��\��3
   */
  public ACTextField getVisitNextMonth3(){
    if(visitNextMonth3==null){

      visitNextMonth3 = new ACTextField();

      visitNextMonth3.setBindPath("VISIT_NEXT_MONTH_NO3");

      visitNextMonth3.setColumns(2);

      visitNextMonth3.setCharType(VRCharType.ONLY_DIGIT);

      visitNextMonth3.setHorizontalAlignment(SwingConstants.RIGHT);

      visitNextMonth3.setIMEMode(InputSubset.LATIN);

      visitNextMonth3.setMaxLength(2);

      addVisitNextMonth3();
    }
    return visitNextMonth3;

  }

  /**
   * �����̖K��\��4���擾���܂��B
   * @return �����̖K��\��4
   */
  public ACTextField getVisitNextMonth4(){
    if(visitNextMonth4==null){

      visitNextMonth4 = new ACTextField();

      visitNextMonth4.setBindPath("VISIT_NEXT_MONTH_NO4");

      visitNextMonth4.setColumns(2);

      visitNextMonth4.setCharType(VRCharType.ONLY_DIGIT);

      visitNextMonth4.setHorizontalAlignment(SwingConstants.RIGHT);

      visitNextMonth4.setIMEMode(InputSubset.LATIN);

      visitNextMonth4.setMaxLength(2);

      addVisitNextMonth4();
    }
    return visitNextMonth4;

  }

  /**
   * �����̖K��\��5���擾���܂��B
   * @return �����̖K��\��5
   */
  public ACTextField getVisitNextMonth5(){
    if(visitNextMonth5==null){

      visitNextMonth5 = new ACTextField();

      visitNextMonth5.setBindPath("VISIT_NEXT_MONTH_NO5");

      visitNextMonth5.setColumns(2);

      visitNextMonth5.setCharType(VRCharType.ONLY_DIGIT);

      visitNextMonth5.setHorizontalAlignment(SwingConstants.RIGHT);

      visitNextMonth5.setIMEMode(InputSubset.LATIN);

      visitNextMonth5.setMaxLength(2);

      addVisitNextMonth5();
    }
    return visitNextMonth5;

  }

  /**
   * �����̖K��\��6���擾���܂��B
   * @return �����̖K��\��6
   */
  public ACTextField getVisitNextMonth6(){
    if(visitNextMonth6==null){

      visitNextMonth6 = new ACTextField();

      visitNextMonth6.setBindPath("VISIT_NEXT_MONTH_NO6");

      visitNextMonth6.setColumns(2);

      visitNextMonth6.setCharType(VRCharType.ONLY_DIGIT);

      visitNextMonth6.setHorizontalAlignment(SwingConstants.RIGHT);

      visitNextMonth6.setIMEMode(InputSubset.LATIN);

      visitNextMonth6.setMaxLength(2);

      addVisitNextMonth6();
    }
    return visitNextMonth6;

  }

  /**
   * �����̖K��\��L���v�V�������擾���܂��B
   * @return �����̖K��\��L���v�V����
   */
  public ACLabel getVisitNextMonthCaption(){
    if(visitNextMonthCaption==null){

      visitNextMonthCaption = new ACLabel();

      visitNextMonthCaption.setText("��");

      addVisitNextMonthCaption();
    }
    return visitNextMonthCaption;

  }

  /**
   * �A�h�o�C�X�R���e�i���擾���܂��B
   * @return �A�h�o�C�X�R���e�i
   */
  public ACLabelContainer getAdviceContainer(){
    if(adviceContainer==null){

      adviceContainer = new ACLabelContainer();

      adviceContainer.setLayout(getAdviceContainerLayout());

      addAdviceContainer();
    }
    return adviceContainer;

  }

  /**
   * �A�h�o�C�X�R���e�i���C�A�E�g���擾���܂��B
   * @return �A�h�o�C�X�R���e�i���C�A�E�g
   */
  public VRLayout getAdviceContainerLayout(){
    if(adviceContainerLayout==null){

      adviceContainerLayout = new VRLayout();

      adviceContainerLayout.setAutoWrap(false);

      adviceContainerLayout.setHgap(0);

      addAdviceContainerLayout();
    }
    return adviceContainerLayout;

  }

  /**
   * �A�h�o�C�X�̈���擾���܂��B
   * @return �A�h�o�C�X�̈�
   */
  public ACPanel getAdvices(){
    if(advices==null){

      advices = new ACPanel();

      addAdvices();
    }
    return advices;

  }

  /**
   * �A�h�o�C�X�E�㕔���擾���܂��B
   * @return �A�h�o�C�X�E�㕔
   */
  public ACPanel getAdvicdHeaders(){
    if(advicdHeaders==null){

      advicdHeaders = new ACPanel();

      addAdvicdHeaders();
    }
    return advicdHeaders;

  }

  /**
   * �����̃A�h�o�C�X���擾���܂��B
   * @return �����̃A�h�o�C�X
   */
  public ACTextField getAdviceMonth(){
    if(adviceMonth==null){

      adviceMonth = new ACTextField();

      adviceMonth.setBindPath("ADVICE_MONTH");

      adviceMonth.setEditable(false);

      adviceMonth.setColumns(2);

      adviceMonth.setCharType(VRCharType.ONLY_DIGIT);

      adviceMonth.setHorizontalAlignment(SwingConstants.CENTER);

      adviceMonth.setIMEMode(InputSubset.LATIN);

      adviceMonth.setMaxLength(2);

      addAdviceMonth();
    }
    return adviceMonth;

  }

  /**
   * �����̃A�h�o�C�X�L���v�V�������擾���܂��B
   * @return �����̃A�h�o�C�X�L���v�V����
   */
  public ACLabel getAdviceMonthCaption(){
    if(adviceMonthCaption==null){

      adviceMonthCaption = new ACLabel();

      adviceMonthCaption.setText("���̃A�h�o�C�X");

      addAdviceMonthCaption();
    }
    return adviceMonthCaption;

  }

  /**
   * �A�h�o�C�X�E�������擾���܂��B
   * @return �A�h�o�C�X�E����
   */
  public ACLabel getAdviceLength(){
    if(adviceLength==null){

      adviceLength = new ACLabel();

      adviceLength.setText("(48x19)");

      addAdviceLength();
    }
    return adviceLength;

  }

  /**
   * �A�h�o�C�X�E�{�����擾���܂��B
   * @return �A�h�o�C�X�E�{��
   */
  public ACTextArea getAdvice(){
    if(advice==null){

      advice = new ACTextArea();

      advice.setBindPath("ADVICE");

      advice.setColumns(96);

      advice.setRows(9);

      advice.setMaxRows(19);

      advice.setIMEMode(InputSubset.KANJI);

      advice.setMaxLength(912);

      advice.setLineWrap(true);

      addAdvice();
    }
    return advice;

  }

  /**
   * Tab2�u����×{�Ǘ��w�����v���擾���܂��B
   * @return Tab2�u����×{�Ǘ��w�����v
   */
  public ACPanel getPoints2(){
    if(points2==null){

      points2 = new ACPanel();

      addPoints2();
    }
    return points2;

  }

  /**
   * ����×{�Ǘ��w���������^�u���擾���܂��B
   * @return ����×{�Ǘ��w���������^�u
   */
  public JTabbedPane getKyotakuPoints(){
    if(kyotakuPoints==null){

      kyotakuPoints = new JTabbedPane();

      addKyotakuPoints();
    }
    return kyotakuPoints;

  }

  /**
   * �a��^�u�p�l�����擾���܂��B
   * @return �a��^�u�p�l��
   */
  public ACPanel getKyotakuPointsPanel1(){
    if(kyotakuPointsPanel1==null){

      kyotakuPointsPanel1 = new ACPanel();

      addKyotakuPointsPanel1();
    }
    return kyotakuPointsPanel1;

  }

  /**
   * ���Ə��O���[�v���擾���܂��B
   * @return ���Ə��O���[�v
   */
  public ACGroupBox getProviderInfoGroup(){
    if(providerInfoGroup==null){

      providerInfoGroup = new ACGroupBox();

      providerInfoGroup.setText("���Ə����");

      providerInfoGroup.setAutoWrap(false);

      providerInfoGroup.setHgap(0);

      addProviderInfoGroup();
    }
    return providerInfoGroup;

  }

  /**
   * ����×{�Ǘ��w�����E�쐬�N�������擾���܂��B
   * @return ����×{�Ǘ��w�����E�쐬�N����
   */
  public QkanDateTextField getCreateDateKyotaku(){
    if(createDateKyotaku==null){

      createDateKyotaku = new QkanDateTextField();

      getCreateDateKyotakuContainer().setText("�쐬�N����");

      createDateKyotaku.setBindPath("CREATE_DATE_KYOTAKU");

      createDateKyotaku.setEditable(true);

      addCreateDateKyotaku();
    }
    return createDateKyotaku;

  }

  /**
   * ����×{�Ǘ��w�����E�쐬�N�����R���e�i���擾���܂��B
   * @return ����×{�Ǘ��w�����E�쐬�N�����R���e�i
   */
  protected ACLabelContainer getCreateDateKyotakuContainer(){
    if(createDateKyotakuContainer==null){
      createDateKyotakuContainer = new ACLabelContainer();
      createDateKyotakuContainer.setFollowChildEnabled(true);
      createDateKyotakuContainer.setVAlignment(VRLayout.CENTER);
      createDateKyotakuContainer.add(getCreateDateKyotaku(), null);
    }
    return createDateKyotakuContainer;
  }

  /**
   * ���x���������擾���܂��B
   * @return ���x������
   */
  public ACComboBox getSenmonin(){
    if(senmonin==null){

      senmonin = new ACComboBox();

      getSenmoninContainer().setText("���x������������");

      senmonin.setBindPath("SENMONIN");

      senmonin.setEditable(true);

      senmonin.setModelBindPath("SENMONIN");

      senmonin.setRenderBindPath("STAFF_NAME");

      senmonin.setIMEMode(InputSubset.KANJI);

      senmonin.setMaxLength(32);

      senmonin.setMaxColumns(15);

      senmonin.setModel(getSenmoninModel());

      addSenmonin();
    }
    return senmonin;

  }

  /**
   * ���x�������R���e�i���擾���܂��B
   * @return ���x�������R���e�i
   */
  protected ACLabelContainer getSenmoninContainer(){
    if(senmoninContainer==null){
      senmoninContainer = new ACLabelContainer();
      senmoninContainer.setFollowChildEnabled(true);
      senmoninContainer.setVAlignment(VRLayout.CENTER);
      senmoninContainer.add(getSenmonin(), null);
    }
    return senmoninContainer;
  }

  /**
   * ���x���������f�����擾���܂��B
   * @return ���x���������f��
   */
  protected ACComboBoxModelAdapter getSenmoninModel(){
    if(senmoninModel==null){
      senmoninModel = new ACComboBoxModelAdapter();
      addSenmoninModel();
    }
    return senmoninModel;
  }

  /**
   * ���Ə������擾���܂��B
   * @return ���Ə���
   */
  public ACComboBox getProviderName(){
    if(providerName==null){

      providerName = new ACComboBox();

      getProviderNameContainer().setText("���Ə�����");

      providerName.setBindPath("PROVIDER_NAME");

      providerName.setModelBindPath("PROVIDER_NAMES");

      providerName.setRenderBindPath("PROVIDER_NAME");

      providerName.setIMEMode(InputSubset.KANJI);

      providerName.setMaxLength(60);

      providerName.setMaxColumns(23);

      providerName.setModel(getProviderNameModel());

      addProviderName();
    }
    return providerName;

  }

  /**
   * ���Ə����R���e�i���擾���܂��B
   * @return ���Ə����R���e�i
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
   * ���Ə������f�����擾���܂��B
   * @return ���Ə������f��
   */
  protected ACComboBoxModelAdapter getProviderNameModel(){
    if(providerNameModel==null){
      providerNameModel = new ACComboBoxModelAdapter();
      addProviderNameModel();
    }
    return providerNameModel;
  }

  /**
   * �a��O���[�v���擾���܂��B
   * @return �a��O���[�v
   */
  public ACGroupBox getByojoGroup(){
    if(byojoGroup==null){

      byojoGroup = new ACGroupBox();

      byojoGroup.setText("�a��(45�~4)");

      byojoGroup.setHgap(0);

      byojoGroup.setLabelMargin(0);

      byojoGroup.setVgap(0);

      byojoGroup.setHgrid(0);

      addByojoGroup();
    }
    return byojoGroup;

  }

  /**
   * �a��p�l�����擾���܂��B
   * @return �a��p�l��
   */
  public ACPanel getByojoPanel(){
    if(byojoPanel==null){

      byojoPanel = new ACPanel();

      byojoPanel.setHgap(0);

      byojoPanel.setLabelMargin(0);

      byojoPanel.setVgap(0);

      addByojoPanel();
    }
    return byojoPanel;

  }

  /**
   * �a����擾���܂��B
   * @return �a��
   */
  public ACTextArea getByojo(){
    if(byojo==null){

      byojo = new ACTextArea();

      byojo.setBindPath("CONDITION");

      byojo.setColumns(90);

      byojo.setRows(5);

      byojo.setMaxRows(4);

      byojo.setIMEMode(InputSubset.KANJI);

      byojo.setMaxLength(180);

      byojo.setLineWrap(true);

      addByojo();
    }
    return byojo;

  }

  /**
   * �a��R���e�i���擾���܂��B
   * @return �a��R���e�i
   */
  protected ACLabelContainer getByojoContainer(){
    if(byojoContainer==null){
      byojoContainer = new ACLabelContainer();
      byojoContainer.setFollowChildEnabled(true);
      byojoContainer.setVAlignment(VRLayout.CENTER);
      byojoContainer.add(getByojo(), null);
    }
    return byojoContainer;
  }

  /**
   * �a��o�ߓ��O���[�v���擾���܂��B
   * @return �a��o�ߓ��O���[�v
   */
  public ACGroupBox getByojiKeikaGroup(){
    if(byojiKeikaGroup==null){

      byojiKeikaGroup = new ACGroupBox();

      byojiKeikaGroup.setText("�a��o�ߓ�(45�~4)");

      byojiKeikaGroup.setHgap(0);

      byojiKeikaGroup.setLabelMargin(0);

      byojiKeikaGroup.setVgap(0);

      byojiKeikaGroup.setHgrid(0);

      addByojiKeikaGroup();
    }
    return byojiKeikaGroup;

  }

  /**
   * �a��o�߃p�l�����擾���܂��B
   * @return �a��o�߃p�l��
   */
  public ACPanel getByojoKeikaPanel(){
    if(byojoKeikaPanel==null){

      byojoKeikaPanel = new ACPanel();

      byojoKeikaPanel.setHgap(0);

      byojoKeikaPanel.setLabelMargin(0);

      byojoKeikaPanel.setVgap(0);

      addByojoKeikaPanel();
    }
    return byojoKeikaPanel;

  }

  /**
   * �a��o�ߓ����擾���܂��B
   * @return �a��o�ߓ�
   */
  public ACTextArea getByojoKeika(){
    if(byojoKeika==null){

      byojoKeika = new ACTextArea();

      byojoKeika.setBindPath("CONDITION_PASSAGE");

      byojoKeika.setColumns(90);

      byojoKeika.setRows(5);

      byojoKeika.setMaxRows(4);

      byojoKeika.setIMEMode(InputSubset.KANJI);

      byojoKeika.setMaxLength(180);

      byojoKeika.setLineWrap(true);

      addByojoKeika();
    }
    return byojoKeika;

  }

  /**
   * �a��o�ߓ��R���e�i���擾���܂��B
   * @return �a��o�ߓ��R���e�i
   */
  protected ACLabelContainer getByojoKeikaContainer(){
    if(byojoKeikaContainer==null){
      byojoKeikaContainer = new ACLabelContainer();
      byojoKeikaContainer.setFollowChildEnabled(true);
      byojoKeikaContainer.setVAlignment(VRLayout.CENTER);
      byojoKeikaContainer.add(getByojoKeika(), null);
    }
    return byojoKeikaContainer;
  }

  /**
   * ���T�[�r�X�^�u�p�l�����擾���܂��B
   * @return ���T�[�r�X�^�u�p�l��
   */
  public ACPanel getKyotakuPointsPane2(){
    if(kyotakuPointsPane2==null){

      kyotakuPointsPane2 = new ACPanel();

      addKyotakuPointsPane2();
    }
    return kyotakuPointsPane2;

  }

  /**
   * ���T�[�r�X�𗘗p�����ł̗��ӓ_�E�����@���O���[�v���擾���܂��B
   * @return ���T�[�r�X�𗘗p�����ł̗��ӓ_�E�����@���O���[�v
   */
  public ACGroupBox getKaigoServiceUseCheckGroup(){
    if(kaigoServiceUseCheckGroup==null){

      kaigoServiceUseCheckGroup = new ACGroupBox();

      kaigoServiceUseCheckGroup.setText("���T�[�r�X�𗘗p�����ł̗��ӓ_�E�����@��(45�~4)");

      kaigoServiceUseCheckGroup.setHgap(0);

      kaigoServiceUseCheckGroup.setLabelMargin(0);

      kaigoServiceUseCheckGroup.setVgap(0);

      kaigoServiceUseCheckGroup.setHgrid(0);

      addKaigoServiceUseCheckGroup();
    }
    return kaigoServiceUseCheckGroup;

  }

  /**
   * ���T�[�r�X�𗘗p�����ł̗��ӓ_�E�����@���p�l�����擾���܂��B
   * @return ���T�[�r�X�𗘗p�����ł̗��ӓ_�E�����@���p�l��
   */
  public ACPanel getKaigoServicePanel(){
    if(kaigoServicePanel==null){

      kaigoServicePanel = new ACPanel();

      kaigoServicePanel.setHgap(0);

      kaigoServicePanel.setLabelMargin(0);

      kaigoServicePanel.setVgap(0);

      addKaigoServicePanel();
    }
    return kaigoServicePanel;

  }

  /**
   * ���T�[�r�X�𗘗p�����ł̗��ӓ_�E�����@�����擾���܂��B
   * @return ���T�[�r�X�𗘗p�����ł̗��ӓ_�E�����@��
   */
  public ACTextArea getKaigoServiceUseCheck(){
    if(kaigoServiceUseCheck==null){

      kaigoServiceUseCheck = new ACTextArea();

      kaigoServiceUseCheck.setBindPath("NOTE_OF_KAIGO_SERVICE");

      kaigoServiceUseCheck.setColumns(90);

      kaigoServiceUseCheck.setRows(5);

      kaigoServiceUseCheck.setMaxRows(4);

      kaigoServiceUseCheck.setIMEMode(InputSubset.KANJI);

      kaigoServiceUseCheck.setMaxLength(180);

      kaigoServiceUseCheck.setLineWrap(true);

      addKaigoServiceUseCheck();
    }
    return kaigoServiceUseCheck;

  }

  /**
   * ���T�[�r�X�𗘗p�����ł̗��ӓ_�E�����@���R���e�i���擾���܂��B
   * @return ���T�[�r�X�𗘗p�����ł̗��ӓ_�E�����@���R���e�i
   */
  protected ACLabelContainer getKaigoServiceUseCheckContainer(){
    if(kaigoServiceUseCheckContainer==null){
      kaigoServiceUseCheckContainer = new ACLabelContainer();
      kaigoServiceUseCheckContainer.setFollowChildEnabled(true);
      kaigoServiceUseCheckContainer.setVAlignment(VRLayout.CENTER);
      kaigoServiceUseCheckContainer.add(getKaigoServiceUseCheck(), null);
    }
    return kaigoServiceUseCheckContainer;
  }

  /**
   * ���p�҂̓��퐶����̗��ӓ_�O���[�v���擾���܂��B
   * @return ���p�҂̓��퐶����̗��ӓ_�O���[�v
   */
  public ACGroupBox getRyuitenGroup(){
    if(ryuitenGroup==null){

      ryuitenGroup = new ACGroupBox();

      ryuitenGroup.setText("���p�҂̓��퐶����̗��ӓ_(45�~4)");

      ryuitenGroup.setHgap(0);

      ryuitenGroup.setLabelMargin(0);

      ryuitenGroup.setVgap(0);

      ryuitenGroup.setHgrid(0);

      addRyuitenGroup();
    }
    return ryuitenGroup;

  }

  /**
   * ���p�҂̓��퐶����̗��ӓ_�p�l�����擾���܂��B
   * @return ���p�҂̓��퐶����̗��ӓ_�p�l��
   */
  public ACPanel getRyuitenPanel(){
    if(ryuitenPanel==null){

      ryuitenPanel = new ACPanel();

      ryuitenPanel.setHgap(0);

      ryuitenPanel.setLabelMargin(0);

      ryuitenPanel.setVgap(0);

      addRyuitenPanel();
    }
    return ryuitenPanel;

  }

  /**
   * ���p�҂̓��퐶����̗��ӓ_���擾���܂��B
   * @return ���p�҂̓��퐶����̗��ӓ_
   */
  public ACTextArea getRyuiten(){
    if(ryuiten==null){

      ryuiten = new ACTextArea();

      ryuiten.setBindPath("NOTE_OF_DAILY_LIFE");

      ryuiten.setColumns(90);

      ryuiten.setRows(5);

      ryuiten.setMaxRows(4);

      ryuiten.setIMEMode(InputSubset.KANJI);

      ryuiten.setMaxLength(180);

      ryuiten.setLineWrap(true);

      addRyuiten();
    }
    return ryuiten;

  }

  /**
   * ���p�҂̓��퐶����̗��ӓ_�R���e�i���擾���܂��B
   * @return ���p�҂̓��퐶����̗��ӓ_�R���e�i
   */
  protected ACLabelContainer getRyuitenContainer(){
    if(ryuitenContainer==null){
      ryuitenContainer = new ACLabelContainer();
      ryuitenContainer.setFollowChildEnabled(true);
      ryuitenContainer.setVAlignment(VRLayout.CENTER);
      ryuitenContainer.add(getRyuiten(), null);
    }
    return ryuitenContainer;
  }

  /**
   * ���l�^�u�p�l�����擾���܂��B
   * @return ���l�^�u�p�l��
   */
  public ACPanel getKyotakuPointsPane3(){
    if(kyotakuPointsPane3==null){

      kyotakuPointsPane3 = new ACPanel();

      addKyotakuPointsPane3();
    }
    return kyotakuPointsPane3;

  }

  /**
   * ���l�O���[�v���擾���܂��B
   * @return ���l�O���[�v
   */
  public ACGroupBox getBikouGroup(){
    if(bikouGroup==null){

      bikouGroup = new ACGroupBox();

      bikouGroup.setText("���l(45�~2)");

      bikouGroup.setHgap(0);

      bikouGroup.setLabelMargin(0);

      bikouGroup.setVgap(0);

      bikouGroup.setHgrid(0);

      addBikouGroup();
    }
    return bikouGroup;

  }

  /**
   * �̈�p�l�����擾���܂��B
   * @return �̈�p�l��
   */
  public ACPanel getBikouPanel(){
    if(bikouPanel==null){

      bikouPanel = new ACPanel();

      bikouPanel.setHgap(0);

      bikouPanel.setLabelMargin(0);

      bikouPanel.setVgap(0);

      addBikouPanel();
    }
    return bikouPanel;

  }

  /**
   * ���l���擾���܂��B
   * @return ���l
   */
  public ACTextArea getBikou(){
    if(bikou==null){

      bikou = new ACTextArea();

      bikou.setBindPath("REMARKS");

      bikou.setColumns(90);

      bikou.setRows(3);

      bikou.setMaxRows(2);

      bikou.setIMEMode(InputSubset.KANJI);

      bikou.setMaxLength(90);

      bikou.setLineWrap(true);

      addBikou();
    }
    return bikou;

  }

  /**
   * ���l�R���e�i���擾���܂��B
   * @return ���l�R���e�i
   */
  protected ACLabelContainer getBikouContainer(){
    if(bikouContainer==null){
      bikouContainer = new ACLabelContainer();
      bikouContainer.setFollowChildEnabled(true);
      bikouContainer.setVAlignment(VRLayout.CENTER);
      bikouContainer.add(getBikou(), null);
    }
    return bikouContainer;
  }

  /**
   * �R���X�g���N�^�ł��B
   */
  public QC005Design() {

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

    contents.add(getPatients(), VRLayout.NORTH);

    contents.add(getTabsArea(), VRLayout.CLIENT);

  }

  /**
   * �Ώ۔N���̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTargetDates(){

    targetDates.add(getTargetDateCaption(), VRLayout.FLOW);

    targetDates.add(getTargetDateLabel(), VRLayout.FLOW);

  }

  /**
   * �Ώ۔N���L���v�V�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addTargetDateCaption(){

  }

  /**
   * �Ώ۔N���ɓ������ڂ�ǉ����܂��B
   */
  protected void addTargetDateLabel(){

  }

  /**
   * ���p�ҏ��̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatients(){

    patients.add(getPatients1(), VRLayout.NORTH);

    patients.add(getPatients2(), VRLayout.CLIENT);

  }

  /**
   * ���p�ҏ��T�u�̈�1�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatients1(){

    patients1.add(getPatientNameContainer(), VRLayout.FLOW_INSETLINE);

    patients1.add(getPatientSexContainer(), VRLayout.FLOW);

    patients1.add(getPatientBirthContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    patients1.add(getJotaiCodeContainer(), VRLayout.FLOW_INSETLINE);

  }

  /**
   * ���p�Ҏ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatientName(){

  }

  /**
   * ���ʂɓ������ڂ�ǉ����܂��B
   */
  protected void addPatientSex(){

  }

  /**
   * ���N�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatientBirth(){

  }

  /**
   * �v���F��ɓ������ڂ�ǉ����܂��B
   */
  protected void addJotaiCode(){

  }

  /**
   * �v���F�胂�f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addJotaiCodeModel(){

    getYokaigodoRadioItem1().setButtonIndex(1);

    getJotaiCodeModel().add(getYokaigodoRadioItem1());

    getYokaigodoRadioItem8().setButtonIndex(12);

    getJotaiCodeModel().add(getYokaigodoRadioItem8());

    getYokaigodoRadioItem9().setButtonIndex(13);

    getJotaiCodeModel().add(getYokaigodoRadioItem9());

    getYokaigodoRadioItem2().setButtonIndex(11);

    getJotaiCodeModel().add(getYokaigodoRadioItem2());

    getYokaigodoRadioItem3().setButtonIndex(21);

    getJotaiCodeModel().add(getYokaigodoRadioItem3());

    getYokaigodoRadioItem4().setButtonIndex(22);

    getJotaiCodeModel().add(getYokaigodoRadioItem4());

    getYokaigodoRadioItem5().setButtonIndex(23);

    getJotaiCodeModel().add(getYokaigodoRadioItem5());

    getYokaigodoRadioItem6().setButtonIndex(24);

    getJotaiCodeModel().add(getYokaigodoRadioItem6());

    getYokaigodoRadioItem7().setButtonIndex(25);

    getJotaiCodeModel().add(getYokaigodoRadioItem7());

  }

  /**
   * �����ɓ������ڂ�ǉ����܂��B
   */
  protected void addYokaigodoRadioItem1(){

  }

  /**
   * �v�x���P�ɓ������ڂ�ǉ����܂��B
   */
  protected void addYokaigodoRadioItem8(){

  }

  /**
   * �v�x���Q�ɓ������ڂ�ǉ����܂��B
   */
  protected void addYokaigodoRadioItem9(){

  }

  /**
   * �o�ߓI�v���ɓ������ڂ�ǉ����܂��B
   */
  protected void addYokaigodoRadioItem2(){

  }

  /**
   * �v���1�ɓ������ڂ�ǉ����܂��B
   */
  protected void addYokaigodoRadioItem3(){

  }

  /**
   * �v���2�ɓ������ڂ�ǉ����܂��B
   */
  protected void addYokaigodoRadioItem4(){

  }

  /**
   * �v���3�ɓ������ڂ�ǉ����܂��B
   */
  protected void addYokaigodoRadioItem5(){

  }

  /**
   * �v���4�ɓ������ڂ�ǉ����܂��B
   */
  protected void addYokaigodoRadioItem6(){

  }

  /**
   * �v���5�ɓ������ڂ�ǉ����܂��B
   */
  protected void addYokaigodoRadioItem7(){

  }

  /**
   * ���p�ҏ��T�u�̈�2�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatients2(){

    patients2.add(getShogaiJiritsudoContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    patients2.add(getNinchishoJiritsudoContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    patients2.add(getPatientAddressContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    patients2.add(getPatientTelContena(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * ��Q�V�l���퐶�������x�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShogaiJiritsudo(){

  }

  /**
   * ��Q�V�l���퐶�������x���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShogaiJiritsudoModel(){

    getShogaiJiritsudoRadioItem1().setButtonIndex(1);

    getShogaiJiritsudoModel().add(getShogaiJiritsudoRadioItem1());

    getShogaiJiritsudoRadioItem2().setButtonIndex(2);

    getShogaiJiritsudoModel().add(getShogaiJiritsudoRadioItem2());

    getShogaiJiritsudoRadioItem3().setButtonIndex(3);

    getShogaiJiritsudoModel().add(getShogaiJiritsudoRadioItem3());

    getShogaiJiritsudoRadioItem4().setButtonIndex(4);

    getShogaiJiritsudoModel().add(getShogaiJiritsudoRadioItem4());

    getShogaiJiritsudoRadioItem5().setButtonIndex(5);

    getShogaiJiritsudoModel().add(getShogaiJiritsudoRadioItem5());

  }

  /**
   * ��Q�V�l���퐶�������x1�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShogaiJiritsudoRadioItem1(){

  }

  /**
   * ��Q�V�l���퐶�������x2�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShogaiJiritsudoRadioItem2(){

  }

  /**
   * ��Q�V�l���퐶�������x3�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShogaiJiritsudoRadioItem3(){

  }

  /**
   * ��Q�V�l���퐶�������x4�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShogaiJiritsudoRadioItem4(){

  }

  /**
   * ��Q�V�l���퐶�������x5�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShogaiJiritsudoRadioItem5(){

  }

  /**
   * �F�m�ǘV�l���퐶�������x�ɓ������ڂ�ǉ����܂��B
   */
  protected void addNinchishoJiritsudo(){

  }

  /**
   * �F�m�ǘV�l���퐶�������x���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addNinchishoJiritsudoModel(){

    getNinchishoJiritsudoRadioItem1().setButtonIndex(1);

    getNinchishoJiritsudoModel().add(getNinchishoJiritsudoRadioItem1());

    getNinchishoJiritsudoRadioItem2().setButtonIndex(2);

    getNinchishoJiritsudoModel().add(getNinchishoJiritsudoRadioItem2());

    getNinchishoJiritsudoRadioItem3().setButtonIndex(3);

    getNinchishoJiritsudoModel().add(getNinchishoJiritsudoRadioItem3());

    getNinchishoJiritsudoRadioItem4().setButtonIndex(4);

    getNinchishoJiritsudoModel().add(getNinchishoJiritsudoRadioItem4());

    getNinchishoJiritsudoRadioItem5().setButtonIndex(5);

    getNinchishoJiritsudoModel().add(getNinchishoJiritsudoRadioItem5());

    getNinchishoJiritsudoRadioItem6().setButtonIndex(6);

    getNinchishoJiritsudoModel().add(getNinchishoJiritsudoRadioItem6());

  }

  /**
   * �F�m�ǘV�l���퐶�������x1�ɓ������ڂ�ǉ����܂��B
   */
  protected void addNinchishoJiritsudoRadioItem1(){

  }

  /**
   * �F�m�ǘV�l���퐶�������x2�ɓ������ڂ�ǉ����܂��B
   */
  protected void addNinchishoJiritsudoRadioItem2(){

  }

  /**
   * �F�m�ǘV�l���퐶�������x3�ɓ������ڂ�ǉ����܂��B
   */
  protected void addNinchishoJiritsudoRadioItem3(){

  }

  /**
   * �F�m�ǘV�l���퐶�������x4�ɓ������ڂ�ǉ����܂��B
   */
  protected void addNinchishoJiritsudoRadioItem4(){

  }

  /**
   * �F�m�ǘV�l���퐶�������x5�ɓ������ڂ�ǉ����܂��B
   */
  protected void addNinchishoJiritsudoRadioItem5(){

  }

  /**
   * �F�m�ǘV�l���퐶�������x6�ɓ������ڂ�ǉ����܂��B
   */
  protected void addNinchishoJiritsudoRadioItem6(){

  }

  /**
   * ���p�ҏZ���ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatientAddress(){

  }

  /**
   * (�d�b�ԍ��E�R���e�i)�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatientTelContena(){

    patientTelContena.add(getPatientTel2(), VRLayout.FLOW);

    patientTelContena.add(getPatientTel3(), VRLayout.FLOW);

    patientTelContena.add(getPatientTel4(), VRLayout.FLOW);

    patientTelContena.add(getPatientTel5(), VRLayout.FLOW);

    patientTelContena.add(getPatientTel6(), VRLayout.FLOW);

  }

  /**
   * �d�b�ԍ��E�e�L�X�g1�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatientTel2(){

  }

  /**
   * �d�b�ԍ��E���x��1�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatientTel3(){

  }

  /**
   * �d�b�ԍ��E�e�L�X�g2�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatientTel4(){

  }

  /**
   * �d�b�ԍ��E���x��2�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatientTel5(){

  }

  /**
   * �d�b�ԍ��E�e�L�X�g3�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatientTel6(){

  }

  /**
   * �^�u�̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTabsArea(){

    tabsArea.addTab("��Ë@�֏��", getProviderAndMedicaiInfoArea());

    tabsArea.addTab("�ݑ�×{�����̃|�C���g", getPoints());

    tabsArea.addTab("����×{�Ǘ��w����", getPoints2());

  }

  /**
   * ��Ë@�֏��̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderAndMedicaiInfoArea(){

    providerAndMedicaiInfoArea.add(getMedicalInfoGroup(), VRLayout.NORTH);

  }

  /**
   * ��Ë@�փO���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalInfoGroup(){

    medicalInfoGroup.add(getMedicalInstitusionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    medicalInfoGroup.add(getMedicalAddressContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    medicalInfoGroup.add(getMedicalTelContena(), VRLayout.FLOW_INSETLINE_RETURN);

    medicalInfoGroup.add(getDoctorNameContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * ��Ë@�֖��ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalInstitusion(){

  }

  /**
   * ��Ë@�֖����f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalInstitusionModel(){

  }

  /**
   * ��Ë@�֏Z���ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalAddress(){

  }

  /**
   * ��Ë@�֓d�b�ԍ��E�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalTelContena(){

    medicalTelContena.add(getMedicalTel2(), VRLayout.FLOW);

    medicalTelContena.add(getMedicalTel3(), VRLayout.FLOW);

    medicalTelContena.add(getMedicalTel4(), VRLayout.FLOW);

    medicalTelContena.add(getMedicalTel5(), VRLayout.FLOW);

    medicalTelContena.add(getMedicalTel6(), VRLayout.FLOW);

  }

  /**
   * �d�b�ԍ��E�e�L�X�g1�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalTel2(){

  }

  /**
   * �d�b�ԍ��E���x��1�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalTel3(){

  }

  /**
   * �d�b�ԍ��E�e�L�X�g2�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalTel4(){

  }

  /**
   * �d�b�ԍ��E���x��2�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalTel5(){

  }

  /**
   * �d�b�ԍ��E�e�L�X�g3�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalTel6(){

  }

  /**
   * �S���㎁���ɓ������ڂ�ǉ����܂��B
   */
  protected void addDoctorName(){

  }

  /**
   * Tab1�u�ݑ�×{�����̃|�C���g�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPoints(){

    points.add(getPoints1(), VRLayout.NORTH);

  }

  /**
   * Tab1�E�ݑ�×{�����̃|�C���g�E�T�u�̈�1�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPoints1(){

    points1.add(getYourDoctorCaption1(), VRLayout.FLOW);

    points1.add(getYourDoctor(), VRLayout.FLOW);

    points1.add(getYourDoctorCaption2(), VRLayout.FLOW_RETURN);

    points1.add(getCreateDateZaitakuContainer(), VRLayout.FLOW_RETURN);

    points1.add(getVisitThisMonthContainer(), VRLayout.FLOW_INSETLINE);

    points1.add(getResultReadButton(), VRLayout.FLOW_INSETLINE_RETURN);

    points1.add(getVisitNextMonthContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    points1.add(getAdviceContainer(), VRLayout.FLOW_RETURN);

  }

  /**
   * ���Ȃ��̎厡��L���v�V�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addYourDoctorCaption1(){

  }

  /**
   * ���Ȃ��̎厡��ɓ������ڂ�ǉ����܂��B
   */
  protected void addYourDoctor(){

  }

  /**
   * ���Ȃ��̎厡��L���v�V�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addYourDoctorCaption2(){

  }

  /**
   * �ݑ�×{�����̃|�C���g�쐬�N�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addCreateDateZaitaku(){

  }

  /**
   * �����̖K����R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addVisitThisMonthContainer(){

    visitThisMonthContainer.add(getVisitThisMonth1(), null);

    visitThisMonthContainer.add(getVisitThisMonth2(), null);

    visitThisMonthContainer.add(getVisitThisMonth3(), null);

    visitThisMonthContainer.add(getVisitThisMonth4(), null);

    visitThisMonthContainer.add(getVisitThisMonth5(), null);

    visitThisMonthContainer.add(getVisitThisMonth6(), null);

    visitThisMonthContainer.add(getVisitThisMonthCaption(), null);

  }

  /**
   * �����̖K���1�ɓ������ڂ�ǉ����܂��B
   */
  protected void addVisitThisMonth1(){

  }

  /**
   * �����̖K���2�ɓ������ڂ�ǉ����܂��B
   */
  protected void addVisitThisMonth2(){

  }

  /**
   * �����̖K���3�ɓ������ڂ�ǉ����܂��B
   */
  protected void addVisitThisMonth3(){

  }

  /**
   * �����̖K���4�ɓ������ڂ�ǉ����܂��B
   */
  protected void addVisitThisMonth4(){

  }

  /**
   * �����̖K���5�ɓ������ڂ�ǉ����܂��B
   */
  protected void addVisitThisMonth5(){

  }

  /**
   * �����̖K���6�ɓ������ڂ�ǉ����܂��B
   */
  protected void addVisitThisMonth6(){

  }

  /**
   * �����̖K����L���v�V�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addVisitThisMonthCaption(){

  }

  /**
   * ���ѓǍ��݃{�^���ɓ������ڂ�ǉ����܂��B
   */
  protected void addResultReadButton(){

  }

  /**
   * �����̖K����R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addVisitNextMonthContainer(){

    visitNextMonthContainer.add(getVisitNextMonth1(), null);

    visitNextMonthContainer.add(getVisitNextMonth2(), null);

    visitNextMonthContainer.add(getVisitNextMonth3(), null);

    visitNextMonthContainer.add(getVisitNextMonth4(), null);

    visitNextMonthContainer.add(getVisitNextMonth5(), null);

    visitNextMonthContainer.add(getVisitNextMonth6(), null);

    visitNextMonthContainer.add(getVisitNextMonthCaption(), null);

  }

  /**
   * �����̖K��\��1�ɓ������ڂ�ǉ����܂��B
   */
  protected void addVisitNextMonth1(){

  }

  /**
   * �����̖K��\��2�ɓ������ڂ�ǉ����܂��B
   */
  protected void addVisitNextMonth2(){

  }

  /**
   * �����̖K��\��3�ɓ������ڂ�ǉ����܂��B
   */
  protected void addVisitNextMonth3(){

  }

  /**
   * �����̖K��\��4�ɓ������ڂ�ǉ����܂��B
   */
  protected void addVisitNextMonth4(){

  }

  /**
   * �����̖K��\��5�ɓ������ڂ�ǉ����܂��B
   */
  protected void addVisitNextMonth5(){

  }

  /**
   * �����̖K��\��6�ɓ������ڂ�ǉ����܂��B
   */
  protected void addVisitNextMonth6(){

  }

  /**
   * �����̖K��\��L���v�V�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addVisitNextMonthCaption(){

  }

  /**
   * �A�h�o�C�X�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addAdviceContainer(){

    adviceContainer.add(getAdvices(), null);

  }

  /**
   * �A�h�o�C�X�R���e�i���C�A�E�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addAdviceContainerLayout(){

  }

  /**
   * �A�h�o�C�X�̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addAdvices(){

    advices.add(getAdvicdHeaders(), VRLayout.NORTH);

    advices.add(getAdvice(), VRLayout.FLOW);

  }

  /**
   * �A�h�o�C�X�E�㕔�ɓ������ڂ�ǉ����܂��B
   */
  protected void addAdvicdHeaders(){

    advicdHeaders.add(getAdviceMonth(), VRLayout.WEST);

    advicdHeaders.add(getAdviceMonthCaption(), VRLayout.WEST);

    advicdHeaders.add(getAdviceLength(), VRLayout.EAST);
  }

  /**
   * �����̃A�h�o�C�X�ɓ������ڂ�ǉ����܂��B
   */
  protected void addAdviceMonth(){

  }

  /**
   * �����̃A�h�o�C�X�L���v�V�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addAdviceMonthCaption(){

  }

  /**
   * �A�h�o�C�X�E�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addAdviceLength(){

  }

  /**
   * �A�h�o�C�X�E�{���ɓ������ڂ�ǉ����܂��B
   */
  protected void addAdvice(){

  }

  /**
   * Tab2�u����×{�Ǘ��w�����v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPoints2(){

    points2.add(getKyotakuPoints(), VRLayout.CLIENT);

  }

  /**
   * ����×{�Ǘ��w���������^�u�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKyotakuPoints(){

    kyotakuPoints.addTab("�a��E�a��o�ߓ�", getKyotakuPointsPanel1());

    kyotakuPoints.addTab("��엯�ӓ_�E�����@�E���퐶����̗��ӓ_", getKyotakuPointsPane2());

    kyotakuPoints.addTab("���l", getKyotakuPointsPane3());

  }

  /**
   * �a��^�u�p�l���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKyotakuPointsPanel1(){

    kyotakuPointsPanel1.add(getProviderInfoGroup(), VRLayout.NORTH);

    kyotakuPointsPanel1.add(getByojoGroup(), VRLayout.NORTH);

    kyotakuPointsPanel1.add(getByojiKeikaGroup(), VRLayout.NORTH);

  }

  /**
   * ���Ə��O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderInfoGroup(){

    providerInfoGroup.add(getCreateDateKyotakuContainer(), VRLayout.FLOW_RETURN);

    providerInfoGroup.add(getSenmoninContainer(), VRLayout.FLOW);

    providerInfoGroup.add(getProviderNameContainer(), VRLayout.FLOW);

  }

  /**
   * ����×{�Ǘ��w�����E�쐬�N�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addCreateDateKyotaku(){

  }

  /**
   * ���x�������ɓ������ڂ�ǉ����܂��B
   */
  protected void addSenmonin(){

  }

  /**
   * ���x���������f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addSenmoninModel(){

  }

  /**
   * ���Ə����ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderName(){

  }

  /**
   * ���Ə������f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderNameModel(){

  }

  /**
   * �a��O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addByojoGroup(){

    byojoGroup.add(getByojoPanel(), VRLayout.FLOW);

  }

  /**
   * �a��p�l���ɓ������ڂ�ǉ����܂��B
   */
  protected void addByojoPanel(){

    byojoPanel.add(getByojoContainer(), VRLayout.FLOW);

  }

  /**
   * �a��ɓ������ڂ�ǉ����܂��B
   */
  protected void addByojo(){

  }

  /**
   * �a��o�ߓ��O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addByojiKeikaGroup(){

    byojiKeikaGroup.add(getByojoKeikaPanel(), VRLayout.FLOW);

  }

  /**
   * �a��o�߃p�l���ɓ������ڂ�ǉ����܂��B
   */
  protected void addByojoKeikaPanel(){

    byojoKeikaPanel.add(getByojoKeikaContainer(), VRLayout.FLOW);

  }

  /**
   * �a��o�ߓ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addByojoKeika(){

  }

  /**
   * ���T�[�r�X�^�u�p�l���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKyotakuPointsPane2(){

    kyotakuPointsPane2.add(getKaigoServiceUseCheckGroup(), VRLayout.NORTH);

    kyotakuPointsPane2.add(getRyuitenGroup(), VRLayout.NORTH);

  }

  /**
   * ���T�[�r�X�𗘗p�����ł̗��ӓ_�E�����@���O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoServiceUseCheckGroup(){

    kaigoServiceUseCheckGroup.add(getKaigoServicePanel(), VRLayout.FLOW);

  }

  /**
   * ���T�[�r�X�𗘗p�����ł̗��ӓ_�E�����@���p�l���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoServicePanel(){

    kaigoServicePanel.add(getKaigoServiceUseCheckContainer(), VRLayout.FLOW);

  }

  /**
   * ���T�[�r�X�𗘗p�����ł̗��ӓ_�E�����@���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoServiceUseCheck(){

  }

  /**
   * ���p�҂̓��퐶����̗��ӓ_�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addRyuitenGroup(){

    ryuitenGroup.add(getRyuitenPanel(), VRLayout.FLOW);

  }

  /**
   * ���p�҂̓��퐶����̗��ӓ_�p�l���ɓ������ڂ�ǉ����܂��B
   */
  protected void addRyuitenPanel(){

    ryuitenPanel.add(getRyuitenContainer(), VRLayout.FLOW);

  }

  /**
   * ���p�҂̓��퐶����̗��ӓ_�ɓ������ڂ�ǉ����܂��B
   */
  protected void addRyuiten(){

  }

  /**
   * ���l�^�u�p�l���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKyotakuPointsPane3(){

    kyotakuPointsPane3.add(getBikouGroup(), VRLayout.NORTH);

  }

  /**
   * ���l�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addBikouGroup(){

    bikouGroup.add(getBikouPanel(), VRLayout.FLOW);

  }

  /**
   * �̈�p�l���ɓ������ڂ�ǉ����܂��B
   */
  protected void addBikouPanel(){

    bikouPanel.add(getBikouContainer(), VRLayout.FLOW);

  }

  /**
   * ���l�ɓ������ڂ�ǉ����܂��B
   */
  protected void addBikou(){

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
      ACFrame.debugStart(new ACAffairInfo(QC005Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QC005Design getThis() {
    return this;
  }
}
