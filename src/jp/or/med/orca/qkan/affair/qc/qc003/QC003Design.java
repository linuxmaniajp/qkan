
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
 * �J����: ��� ��F
 * �쐬��: 2006/04/04  ���{�R���s���[�^�[������� ��� ��F �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���[�Ǘ� (C)
 * �v���Z�X �K��Ō�̏��񋟏� (003)
 * �v���O���� �K��Ō�̏��񋟏� (QC003)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qc.qc003;
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
 * �K��Ō�̏��񋟏���ʍ��ڃf�U�C��(QC003) 
 */
public class QC003Design extends QkanAffairContainer implements ACAffairable {
  //GUI�R���|�[�l���g

  private ACAffairButtonBar buttons;

  private ACAffairButton open;

  private ACAffairButton insert;

  private ACAffairButton update;

  private ACAffairButton print;

  private ACPanel contents;

  private ACPanel infos;

  private ACTextField infoTheOffer;

  private ACLabelContainer infoTheOfferContainer;

  private QkanDateTextField resultDay;

  private ACLabelContainer resultDayContainer;

  private ACPanel patients;

  private ACGroupBox patient;

  private ACTextField patientName;

  private ACLabelContainer patientNameContainer;

  private ACTextField patientSex;

  private ACLabelContainer patientSexContainer;

  private ACLabelContainer patientBirths;

  private QkanDateTextField patientBirth;

  private ACTextField patientAge;

  private ACLabel patientAgeLabel;

  private ACTextField patientJob;

  private ACLabelContainer patientJobContainer;

  private ACTextField patientAddress;

  private ACLabelContainer patientAddressContainer;

  private ACLabelContainer patientTels;

  private ACTextField patientTel1;

  private ACLabel patientTelLabel1;

  private ACTextField patientTel2;

  private ACLabel patientTelLabel2;

  private ACTextField patientTel3;

  private ACValueArrayRadioButtonGroup patientYokaigodo;

  private ACLabelContainer patientYokaigodoContainer;

  private ACListModelAdapter patientYokaigodoModel;

  private ACRadioButtonItem yokaigodoRadio1;

  private ACRadioButtonItem yokaigodoRadio2;

  private ACRadioButtonItem yokaigodoRadio3;

  private ACRadioButtonItem yokaigodoRadio4;

  private ACRadioButtonItem yokaigodoRadio5;

  private ACRadioButtonItem yokaigodoRadio6;

  private ACRadioButtonItem yokaigodoRadio7;

  private ACRadioButtonItem yokaigodoRadio8;

  private ACRadioButtonItem yokaigodoRadio9;

  private ACTextField patientDiseaseName;

  private ACLabelContainer patientDiseaseNameContainer;

  private ACPanel providers;

  private ACGroupBox provider;

  private ACComboBox providerName;

  private ACLabelContainer providerNameContainer;

  private ACComboBoxModelAdapter providerNameModel;

  private ACTextField providerAdderess;

  private ACLabelContainer providerAdderessContainer;

  private ACLabelContainer providerTels;

  private ACTextField providerTel1;

  private ACLabel providerLabel1;

  private ACTextField providerTel2;

  private ACLabel providerLabel2;

  private ACTextField providerTel3;

  private ACTextField providarAdministrator;

  private ACLabelContainer providarAdministratorContainer;

  private JTabbedPane tabs;

  private ACPanel points1;

  private ACGroupBox syujis;

  private ACTextField syujiName;

  private ACLabelContainer syujiNameContainer;

  private ACTextField syujiAddress;

  private ACLabelContainer syujiAddressContainer;

  private ACGroupBox nichijokatsudoStates;

  private ACPanel nichijokatsudoStateLeft;

  private ACValueArrayRadioButtonGroup moves;

  private ACLabelContainer movesContainer;

  private ACListModelAdapter movesModel;

  private ACRadioButtonItem moveRadioItem1;

  private ACRadioButtonItem moveRadioItem2;

  private ACRadioButtonItem moveRadioItem3;

  private ACValueArrayRadioButtonGroup excretes;

  private ACLabelContainer excretesContainer;

  private ACListModelAdapter excretesModel;

  private ACRadioButtonItem excreteRadioItem1;

  private ACRadioButtonItem excreteRadioItem2;

  private ACRadioButtonItem excreteRadioItem3;

  private ACValueArrayRadioButtonGroup changeClothes;

  private ACLabelContainer changeClothesContainer;

  private ACListModelAdapter changeClothesModel;

  private ACRadioButtonItem changeClothesRadioItem1;

  private ACRadioButtonItem changeClothesRadioItem2;

  private ACRadioButtonItem changeClothesRadioItem3;

  private ACPanel nichijokatsudoStateRight;

  private ACValueArrayRadioButtonGroup meal;

  private ACLabelContainer mealContainer;

  private ACListModelAdapter mealModel;

  private ACRadioButtonItem mealRadioItem1;

  private ACRadioButtonItem mealRadioItem2;

  private ACRadioButtonItem mealRadioItem3;

  private ACValueArrayRadioButtonGroup bath;

  private ACLabelContainer bathContainer;

  private ACListModelAdapter bathModel;

  private ACRadioButtonItem bathRadioItem1;

  private ACRadioButtonItem bathRadioItem2;

  private ACRadioButtonItem bathRadioItem3;

  private ACValueArrayRadioButtonGroup seiyo;

  private ACLabelContainer seiyoContainer;

  private ACListModelAdapter seiyoModel;

  private ACRadioButtonItem seiyoRadioItem1;

  private ACRadioButtonItem seiyoRadioItem2;

  private ACRadioButtonItem seiyoRadioItem3;

  private ACPanel points2;

  private ACGroupBox byojoAndShogais;

  private ACTextArea byojoAndShogai;

  private ACLabelContainer byojoAndShogaiContainer;

  private ACGroupBox homonkaisus;

  private ACTextField homonkaisuDay;

  private ACLabelContainer homonkaisuDayContainer;

  private ACTextField homonkaisuCount;

  private ACLabelContainer homonkaisuCountContainer;

  private ACLabel homonkaisuCaption;

  private ACGroupBox kangoContents;

  private ACTextArea kangoContent;

  private ACLabelContainer kangoContentContainer;

  private ACPanel points3;

  private ACGroupBox needHokenfukushiServices;

  private ACTextArea needHokenfukushiService;

  private ACLabelContainer needHokenfukushiServiceContainer;

  private ACGroupBox extraTokijikos;

  private ACTextArea extraTokijiko;

  private ACLabelContainer extraTokijikoContainer;

  //getter

  /**
   * �{�^���o�[���擾���܂��B
   * @return �{�^���o�[
   */
  public ACAffairButtonBar getButtons(){
    if(buttons==null){

      buttons = new ACAffairButtonBar();

      buttons.setText("�K��Ō�̏��񋟏�");

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

      print.setToolTipText("�u�K��Ō�̏��񋟏��v��������܂��B");

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
   * ���񋟐���擾���܂��B
   * @return ���񋟐�
   */
  public ACTextField getInfoTheOffer(){
    if(infoTheOffer==null){

      infoTheOffer = new ACTextField();

      getInfoTheOfferContainer().setText("���񋟐�");

      infoTheOffer.setBindPath("JOHO_TEIKYO_SAKI");

      infoTheOffer.setColumns(12);

      infoTheOffer.setIMEMode(InputSubset.KANJI);

      infoTheOffer.setMaxLength(12);

      addInfoTheOffer();
    }
    return infoTheOffer;

  }

  /**
   * ���񋟐�R���e�i���擾���܂��B
   * @return ���񋟐�R���e�i
   */
  protected ACLabelContainer getInfoTheOfferContainer(){
    if(infoTheOfferContainer==null){
      infoTheOfferContainer = new ACLabelContainer();
      infoTheOfferContainer.setFollowChildEnabled(true);
      infoTheOfferContainer.setVAlignment(VRLayout.CENTER);
      infoTheOfferContainer.add(getInfoTheOffer(), null);
    }
    return infoTheOfferContainer;
  }

  /**
   * ���{�����擾���܂��B
   * @return ���{��
   */
  public QkanDateTextField getResultDay(){
    if(resultDay==null){

      resultDay = new QkanDateTextField();

      getResultDayContainer().setText("���{��");

      resultDay.setBindPath("CREATE_DATE");

      addResultDay();
    }
    return resultDay;

  }

  /**
   * ���{���R���e�i���擾���܂��B
   * @return ���{���R���e�i
   */
  protected ACLabelContainer getResultDayContainer(){
    if(resultDayContainer==null){
      resultDayContainer = new ACLabelContainer();
      resultDayContainer.setFollowChildEnabled(true);
      resultDayContainer.setVAlignment(VRLayout.CENTER);
      resultDayContainer.add(getResultDay(), null);
    }
    return resultDayContainer;
  }

  /**
   * ���p�җ̈���擾���܂��B
   * @return ���p�җ̈�
   */
  public ACPanel getPatients(){
    if(patients==null){

      patients = new ACPanel();

      addPatients();
    }
    return patients;

  }

  /**
   * ���p�җ̈���擾���܂��B
   * @return ���p�җ̈�
   */
  public ACGroupBox getPatient(){
    if(patient==null){

      patient = new ACGroupBox();

      patient.setText("���p��");

      patient.setAutoWrap(false);

      patient.setHgap(1);

      patient.setLabelMargin(1);

      addPatient();
    }
    return patient;

  }

  /**
   * ���p�Ҏ������擾���܂��B
   * @return ���p�Ҏ���
   */
  public ACTextField getPatientName(){
    if(patientName==null){

      patientName = new ACTextField();

      getPatientNameContainer().setText("����");

      patientName.setBindPath("PATIENT_FULL_NAME");

      patientName.setEditable(false);

      patientName.setColumns(25);

      patientName.setMaxLength(24);

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
   * ���p�Ґ��ʂ��擾���܂��B
   * @return ���p�Ґ���
   */
  public ACTextField getPatientSex(){
    if(patientSex==null){

      patientSex = new ACTextField();

      getPatientSexContainer().setText("����");

      patientSex.setBindPath("PATIENT_SEX");

      patientSex.setEditable(false);

      patientSex.setColumns(2);

      patientSex.setFormat(QkanConstants.FORMAT_SEX);

      patientSex.setMaxLength(2);

      addPatientSex();
    }
    return patientSex;

  }

  /**
   * ���p�Ґ��ʃR���e�i���擾���܂��B
   * @return ���p�Ґ��ʃR���e�i
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
   * ���p�Ґ��N�����E�R���e�i���擾���܂��B
   * @return ���p�Ґ��N�����E�R���e�i
   */
  public ACLabelContainer getPatientBirths(){
    if(patientBirths==null){

      patientBirths = new ACLabelContainer();

      patientBirths.setText("���N����");

      addPatientBirths();
    }
    return patientBirths;

  }

  /**
   * ���p�Ґ��N�������擾���܂��B
   * @return ���p�Ґ��N����
   */
  public QkanDateTextField getPatientBirth(){
    if(patientBirth==null){

      patientBirth = new QkanDateTextField();

      patientBirth.setBindPath("PATIENT_BIRTHDAY");

      patientBirth.setEditable(false);

      addPatientBirth();
    }
    return patientBirth;

  }

  /**
   * ���p�ҔN����擾���܂��B
   * @return ���p�ҔN��
   */
  public ACTextField getPatientAge(){
    if(patientAge==null){

      patientAge = new ACTextField();

      patientAge.setBindPath("PATIENT_BIRTHDAY");

      patientAge.setEditable(false);

      patientAge.setFormat(QkanConstants.FORMAT_NOW_AGE);

      patientAge.setMaxLength(4);

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
   * ���p�ҐE�Ƃ��擾���܂��B
   * @return ���p�ҐE��
   */
  public ACTextField getPatientJob(){
    if(patientJob==null){

      patientJob = new ACTextField();

      getPatientJobContainer().setText("�E��");

      patientJob.setBindPath("PATIENT_JOB");

      patientJob.setColumns(10);

      patientJob.setIMEMode(InputSubset.KANJI);

      patientJob.setMaxLength(10);

      addPatientJob();
    }
    return patientJob;

  }

  /**
   * ���p�ҐE�ƃR���e�i���擾���܂��B
   * @return ���p�ҐE�ƃR���e�i
   */
  protected ACLabelContainer getPatientJobContainer(){
    if(patientJobContainer==null){
      patientJobContainer = new ACLabelContainer();
      patientJobContainer.setFollowChildEnabled(true);
      patientJobContainer.setVAlignment(VRLayout.CENTER);
      patientJobContainer.add(getPatientJob(), null);
    }
    return patientJobContainer;
  }

  /**
   * ���p�ҏZ�����擾���܂��B
   * @return ���p�ҏZ��
   */
  public ACTextField getPatientAddress(){
    if(patientAddress==null){

      patientAddress = new ACTextField();

      getPatientAddressContainer().setText("�Z��");

      patientAddress.setBindPath("PATIENT_ADDRESS");

      patientAddress.setEditable(false);

      patientAddress.setColumns(40);

      patientAddress.setMaxLength(40);

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
   * ���p�ғd�b�ԍ��E�R���e�i���擾���܂��B
   * @return ���p�ғd�b�ԍ��E�R���e�i
   */
  public ACLabelContainer getPatientTels(){
    if(patientTels==null){

      patientTels = new ACLabelContainer();

      patientTels.setText("�d�b�ԍ�");

      addPatientTels();
    }
    return patientTels;

  }

  /**
   * ���p�ғd�b�ԍ�1���擾���܂��B
   * @return ���p�ғd�b�ԍ�1
   */
  public ACTextField getPatientTel1(){
    if(patientTel1==null){

      patientTel1 = new ACTextField();

      patientTel1.setBindPath("PATIENT_TEL_FIRST");

      patientTel1.setEditable(false);

      patientTel1.setColumns(4);

      patientTel1.setMaxLength(6);

      addPatientTel1();
    }
    return patientTel1;

  }

  /**
   * ���p���x��1���擾���܂��B
   * @return ���p���x��1
   */
  public ACLabel getPatientTelLabel1(){
    if(patientTelLabel1==null){

      patientTelLabel1 = new ACLabel();

      patientTelLabel1.setText("-");

      addPatientTelLabel1();
    }
    return patientTelLabel1;

  }

  /**
   * ���p�ғd�b�ԍ�2���擾���܂��B
   * @return ���p�ғd�b�ԍ�2
   */
  public ACTextField getPatientTel2(){
    if(patientTel2==null){

      patientTel2 = new ACTextField();

      patientTel2.setBindPath("PATIENT_TEL_SECOND");

      patientTel2.setEditable(false);

      patientTel2.setColumns(4);

      patientTel2.setMaxLength(4);

      addPatientTel2();
    }
    return patientTel2;

  }

  /**
   * ���p�҃��x��2���擾���܂��B
   * @return ���p�҃��x��2
   */
  public ACLabel getPatientTelLabel2(){
    if(patientTelLabel2==null){

      patientTelLabel2 = new ACLabel();

      patientTelLabel2.setText("-");

      addPatientTelLabel2();
    }
    return patientTelLabel2;

  }

  /**
   * ���p�ғd�b�ԍ�3���擾���܂��B
   * @return ���p�ғd�b�ԍ�3
   */
  public ACTextField getPatientTel3(){
    if(patientTel3==null){

      patientTel3 = new ACTextField();

      patientTel3.setBindPath("PATIENT_TEL_THIRD");

      patientTel3.setEditable(false);

      patientTel3.setColumns(4);

      patientTel3.setMaxLength(4);

      addPatientTel3();
    }
    return patientTel3;

  }

  /**
   * ���p�җv���F����擾���܂��B
   * @return ���p�җv���F��
   */
  public ACValueArrayRadioButtonGroup getPatientYokaigodo(){
    if(patientYokaigodo==null){

      patientYokaigodo = new ACValueArrayRadioButtonGroup();

      getPatientYokaigodoContainer().setText("�v���F��");

      patientYokaigodo.setBindPath("JOTAI_CODE");

      patientYokaigodo.setNoSelectIndex(0);

      patientYokaigodo.setUseClearButton(false);

      patientYokaigodo.setModel(getPatientYokaigodoModel());

      patientYokaigodo.setValues(new int[]{1,12,13,11,21,22,23,24,25});

      addPatientYokaigodo();
    }
    return patientYokaigodo;

  }

  /**
   * ���p�җv���F��R���e�i���擾���܂��B
   * @return ���p�җv���F��R���e�i
   */
  protected ACLabelContainer getPatientYokaigodoContainer(){
    if(patientYokaigodoContainer==null){
      patientYokaigodoContainer = new ACLabelContainer();
      patientYokaigodoContainer.setFollowChildEnabled(true);
      patientYokaigodoContainer.setVAlignment(VRLayout.CENTER);
      patientYokaigodoContainer.add(getPatientYokaigodo(), null);
    }
    return patientYokaigodoContainer;
  }

  /**
   * ���p�җv���F�胂�f�����擾���܂��B
   * @return ���p�җv���F�胂�f��
   */
  protected ACListModelAdapter getPatientYokaigodoModel(){
    if(patientYokaigodoModel==null){
      patientYokaigodoModel = new ACListModelAdapter();
      addPatientYokaigodoModel();
    }
    return patientYokaigodoModel;
  }

  /**
   * �������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getYokaigodoRadio1(){
    if(yokaigodoRadio1==null){

      yokaigodoRadio1 = new ACRadioButtonItem();

      yokaigodoRadio1.setText("����");

      yokaigodoRadio1.setGroup(getPatientYokaigodo());

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

      yokaigodoRadio2.setGroup(getPatientYokaigodo());

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

      yokaigodoRadio3.setGroup(getPatientYokaigodo());

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

      yokaigodoRadio4.setGroup(getPatientYokaigodo());

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

      yokaigodoRadio5.setGroup(getPatientYokaigodo());

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

      yokaigodoRadio6.setGroup(getPatientYokaigodo());

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

      yokaigodoRadio7.setGroup(getPatientYokaigodo());

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

      yokaigodoRadio8.setGroup(getPatientYokaigodo());

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

      yokaigodoRadio9.setGroup(getPatientYokaigodo());

      yokaigodoRadio9.setConstraints(VRLayout.FLOW);

      addYokaigodoRadio9();
    }
    return yokaigodoRadio9;

  }

  /**
   * ���p�Ҏ叝�a�����擾���܂��B
   * @return ���p�Ҏ叝�a��
   */
  public ACTextField getPatientDiseaseName(){
    if(patientDiseaseName==null){

      patientDiseaseName = new ACTextField();

      getPatientDiseaseNameContainer().setText("�叝�a��");

      patientDiseaseName.setBindPath("DISEASE");

      patientDiseaseName.setColumns(35);

      patientDiseaseName.setIMEMode(InputSubset.KANJI);

      patientDiseaseName.setMaxLength(35);

      addPatientDiseaseName();
    }
    return patientDiseaseName;

  }

  /**
   * ���p�Ҏ叝�a���R���e�i���擾���܂��B
   * @return ���p�Ҏ叝�a���R���e�i
   */
  protected ACLabelContainer getPatientDiseaseNameContainer(){
    if(patientDiseaseNameContainer==null){
      patientDiseaseNameContainer = new ACLabelContainer();
      patientDiseaseNameContainer.setFollowChildEnabled(true);
      patientDiseaseNameContainer.setVAlignment(VRLayout.CENTER);
      patientDiseaseNameContainer.add(getPatientDiseaseName(), null);
    }
    return patientDiseaseNameContainer;
  }

  /**
   * ���Ə��̈���擾���܂��B
   * @return ���Ə��̈�
   */
  public ACPanel getProviders(){
    if(providers==null){

      providers = new ACPanel();

      addProviders();
    }
    return providers;

  }

  /**
   * ���Ə��̈���擾���܂��B
   * @return ���Ə��̈�
   */
  public ACGroupBox getProvider(){
    if(provider==null){

      provider = new ACGroupBox();

      provider.setText("�K��Ō�X�e�[�V����");

      provider.setHgap(1);

      provider.setLabelMargin(1);

      addProvider();
    }
    return provider;

  }

  /**
   * ���Ə����̂��擾���܂��B
   * @return ���Ə�����
   */
  public ACComboBox getProviderName(){
    if(providerName==null){

      providerName = new ACComboBox();

      getProviderNameContainer().setText("����");

      providerName.setBindPath("PROVIDER_NAME");

      providerName.setEditable(true);

      providerName.setColumns(18);

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
   * ���Ə����̃R���e�i���擾���܂��B
   * @return ���Ə����̃R���e�i
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
   * ���Ə����̃��f�����擾���܂��B
   * @return ���Ə����̃��f��
   */
  protected ACComboBoxModelAdapter getProviderNameModel(){
    if(providerNameModel==null){
      providerNameModel = new ACComboBoxModelAdapter();
      addProviderNameModel();
    }
    return providerNameModel;
  }

  /**
   * ���Ə����ݒn���擾���܂��B
   * @return ���Ə����ݒn
   */
  public ACTextField getProviderAdderess(){
    if(providerAdderess==null){

      providerAdderess = new ACTextField();

      getProviderAdderessContainer().setText("���ݒn");

      providerAdderess.setBindPath("PROVIDER_ADDRESS");

      providerAdderess.setColumns(40);

      providerAdderess.setIMEMode(InputSubset.KANJI);

      providerAdderess.setMaxLength(40);

      addProviderAdderess();
    }
    return providerAdderess;

  }

  /**
   * ���Ə����ݒn�R���e�i���擾���܂��B
   * @return ���Ə����ݒn�R���e�i
   */
  protected ACLabelContainer getProviderAdderessContainer(){
    if(providerAdderessContainer==null){
      providerAdderessContainer = new ACLabelContainer();
      providerAdderessContainer.setFollowChildEnabled(true);
      providerAdderessContainer.setVAlignment(VRLayout.CENTER);
      providerAdderessContainer.add(getProviderAdderess(), null);
    }
    return providerAdderessContainer;
  }

  /**
   * ���Ə��d�b�ԍ����擾���܂��B
   * @return ���Ə��d�b�ԍ�
   */
  public ACLabelContainer getProviderTels(){
    if(providerTels==null){

      providerTels = new ACLabelContainer();

      providerTels.setText("�d�b�ԍ�");

      addProviderTels();
    }
    return providerTels;

  }

  /**
   * ���Ə��d�b�ԍ�1���擾���܂��B
   * @return ���Ə��d�b�ԍ�1
   */
  public ACTextField getProviderTel1(){
    if(providerTel1==null){

      providerTel1 = new ACTextField();

      providerTel1.setBindPath("PROVIDER_TEL_FIRST");

      providerTel1.setColumns(4);

      providerTel1.setCharType(VRCharType.ONLY_DIGIT);

      providerTel1.setIMEMode(InputSubset.LATIN);

      providerTel1.setMaxLength(6);

      addProviderTel1();
    }
    return providerTel1;

  }

  /**
   * ���Ə����x��1���擾���܂��B
   * @return ���Ə����x��1
   */
  public ACLabel getProviderLabel1(){
    if(providerLabel1==null){

      providerLabel1 = new ACLabel();

      providerLabel1.setText("-");

      addProviderLabel1();
    }
    return providerLabel1;

  }

  /**
   * ���Ə��d�b�ԍ�2���擾���܂��B
   * @return ���Ə��d�b�ԍ�2
   */
  public ACTextField getProviderTel2(){
    if(providerTel2==null){

      providerTel2 = new ACTextField();

      providerTel2.setBindPath("PROVIDER_TEL_SECOND");

      providerTel2.setColumns(4);

      providerTel2.setCharType(VRCharType.ONLY_DIGIT);

      providerTel2.setIMEMode(InputSubset.LATIN);

      providerTel2.setMaxLength(4);

      addProviderTel2();
    }
    return providerTel2;

  }

  /**
   * ���Ə����x��2���擾���܂��B
   * @return ���Ə����x��2
   */
  public ACLabel getProviderLabel2(){
    if(providerLabel2==null){

      providerLabel2 = new ACLabel();

      providerLabel2.setText("-");

      addProviderLabel2();
    }
    return providerLabel2;

  }

  /**
   * ���Ə��d�b�ԍ�3���擾���܂��B
   * @return ���Ə��d�b�ԍ�3
   */
  public ACTextField getProviderTel3(){
    if(providerTel3==null){

      providerTel3 = new ACTextField();

      providerTel3.setBindPath("PROVIDER_TEL_THIRD");

      providerTel3.setColumns(4);

      providerTel3.setCharType(VRCharType.ONLY_DIGIT);

      providerTel3.setIMEMode(InputSubset.LATIN);

      providerTel3.setMaxLength(4);

      addProviderTel3();
    }
    return providerTel3;

  }

  /**
   * ���Ə��Ǘ��҂��擾���܂��B
   * @return ���Ə��Ǘ���
   */
  public ACTextField getProvidarAdministrator(){
    if(providarAdministrator==null){

      providarAdministrator = new ACTextField();

      getProvidarAdministratorContainer().setText("�Ǘ���");

      providarAdministrator.setBindPath("PROVIDER_ADMINISTRATOR");

      providarAdministrator.setColumns(20);

      providarAdministrator.setIMEMode(InputSubset.KANJI);

      providarAdministrator.setMaxLength(20);

      addProvidarAdministrator();
    }
    return providarAdministrator;

  }

  /**
   * ���Ə��Ǘ��҃R���e�i���擾���܂��B
   * @return ���Ə��Ǘ��҃R���e�i
   */
  protected ACLabelContainer getProvidarAdministratorContainer(){
    if(providarAdministratorContainer==null){
      providarAdministratorContainer = new ACLabelContainer();
      providarAdministratorContainer.setFollowChildEnabled(true);
      providarAdministratorContainer.setVAlignment(VRLayout.CENTER);
      providarAdministratorContainer.add(getProvidarAdministrator(), null);
    }
    return providarAdministratorContainer;
  }

  /**
   * �^�u���擾���܂��B
   * @return �^�u
   */
  public JTabbedPane getTabs(){
    if(tabs==null){

      tabs = new JTabbedPane();

      addTabs();
    }
    return tabs;

  }

  /**
   * �厡��E�v���F��󋵁EADL�̈���擾���܂��B
   * @return �厡��E�v���F��󋵁EADL�̈�
   */
  public ACPanel getPoints1(){
    if(points1==null){

      points1 = new ACPanel();

      addPoints1();
    }
    return points1;

  }

  /**
   * �厡��̈���擾���܂��B
   * @return �厡��̈�
   */
  public ACGroupBox getSyujis(){
    if(syujis==null){

      syujis = new ACGroupBox();

      syujis.setText("�厡��");

      syujis.setAutoWrap(false);

      syujis.setHgap(0);

      syujis.setLabelMargin(0);

      addSyujis();
    }
    return syujis;

  }

  /**
   * �厡�㎁�����擾���܂��B
   * @return �厡�㎁��
   */
  public ACTextField getSyujiName(){
    if(syujiName==null){

      syujiName = new ACTextField();

      getSyujiNameContainer().setText("����");

      syujiName.setBindPath("DOCTOR_NAME");

      syujiName.setColumns(25);

      syujiName.setIMEMode(InputSubset.KANJI);

      syujiName.setMaxLength(25);

      addSyujiName();
    }
    return syujiName;

  }

  /**
   * �厡�㎁���R���e�i���擾���܂��B
   * @return �厡�㎁���R���e�i
   */
  protected ACLabelContainer getSyujiNameContainer(){
    if(syujiNameContainer==null){
      syujiNameContainer = new ACLabelContainer();
      syujiNameContainer.setFollowChildEnabled(true);
      syujiNameContainer.setVAlignment(VRLayout.CENTER);
      syujiNameContainer.add(getSyujiName(), null);
    }
    return syujiNameContainer;
  }

  /**
   * �厡��Z�����擾���܂��B
   * @return �厡��Z��
   */
  public ACTextField getSyujiAddress(){
    if(syujiAddress==null){

      syujiAddress = new ACTextField();

      getSyujiAddressContainer().setText("�Z��");

      syujiAddress.setBindPath("DOCTOR_ADDRESS");

      syujiAddress.setColumns(40);

      syujiAddress.setIMEMode(InputSubset.KANJI);

      syujiAddress.setMaxLength(40);

      addSyujiAddress();
    }
    return syujiAddress;

  }

  /**
   * �厡��Z���R���e�i���擾���܂��B
   * @return �厡��Z���R���e�i
   */
  protected ACLabelContainer getSyujiAddressContainer(){
    if(syujiAddressContainer==null){
      syujiAddressContainer = new ACLabelContainer();
      syujiAddressContainer.setFollowChildEnabled(true);
      syujiAddressContainer.setVAlignment(VRLayout.CENTER);
      syujiAddressContainer.add(getSyujiAddress(), null);
    }
    return syujiAddressContainer;
  }

  /**
   * ���퐶�������̏󋵗̈���擾���܂��B
   * @return ���퐶�������̏󋵗̈�
   */
  public ACGroupBox getNichijokatsudoStates(){
    if(nichijokatsudoStates==null){

      nichijokatsudoStates = new ACGroupBox();

      nichijokatsudoStates.setText("���퐶������(ADL)�̏�");

      addNichijokatsudoStates();
    }
    return nichijokatsudoStates;

  }

  /**
   * ���퐶�������̏�(���̈�)���擾���܂��B
   * @return ���퐶�������̏�(���̈�)
   */
  public ACPanel getNichijokatsudoStateLeft(){
    if(nichijokatsudoStateLeft==null){

      nichijokatsudoStateLeft = new ACPanel();

      addNichijokatsudoStateLeft();
    }
    return nichijokatsudoStateLeft;

  }

  /**
   * �ړ����擾���܂��B
   * @return �ړ�
   */
  public ACValueArrayRadioButtonGroup getMoves(){
    if(moves==null){

      moves = new ACValueArrayRadioButtonGroup();

      getMovesContainer().setText("�ړ�");

      moves.setBindPath("ADL_MOVE");

      moves.setNoSelectIndex(0);

      moves.setUseClearButton(true);

      moves.setModel(getMovesModel());

      moves.setValues(new int[]{1,2,3});

      addMoves();
    }
    return moves;

  }

  /**
   * �ړ��R���e�i���擾���܂��B
   * @return �ړ��R���e�i
   */
  protected ACLabelContainer getMovesContainer(){
    if(movesContainer==null){
      movesContainer = new ACLabelContainer();
      movesContainer.setFollowChildEnabled(true);
      movesContainer.setVAlignment(VRLayout.CENTER);
      movesContainer.add(getMoves(), null);
    }
    return movesContainer;
  }

  /**
   * �ړ����f�����擾���܂��B
   * @return �ړ����f��
   */
  protected ACListModelAdapter getMovesModel(){
    if(movesModel==null){
      movesModel = new ACListModelAdapter();
      addMovesModel();
    }
    return movesModel;
  }

  /**
   * �������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getMoveRadioItem1(){
    if(moveRadioItem1==null){

      moveRadioItem1 = new ACRadioButtonItem();

      moveRadioItem1.setText("����");

      moveRadioItem1.setGroup(getMoves());

      moveRadioItem1.setConstraints(VRLayout.FLOW);

      addMoveRadioItem1();
    }
    return moveRadioItem1;

  }

  /**
   * �ꕔ����擾���܂��B
   * @return �ꕔ�
   */
  public ACRadioButtonItem getMoveRadioItem2(){
    if(moveRadioItem2==null){

      moveRadioItem2 = new ACRadioButtonItem();

      moveRadioItem2.setText("�ꕔ�");

      moveRadioItem2.setGroup(getMoves());

      moveRadioItem2.setConstraints(VRLayout.FLOW);

      addMoveRadioItem2();
    }
    return moveRadioItem2;

  }

  /**
   * �S�ʉ���擾���܂��B
   * @return �S�ʉ
   */
  public ACRadioButtonItem getMoveRadioItem3(){
    if(moveRadioItem3==null){

      moveRadioItem3 = new ACRadioButtonItem();

      moveRadioItem3.setText("�S�ʉ");

      moveRadioItem3.setGroup(getMoves());

      moveRadioItem3.setConstraints(VRLayout.FLOW);

      addMoveRadioItem3();
    }
    return moveRadioItem3;

  }

  /**
   * �r�����擾���܂��B
   * @return �r��
   */
  public ACValueArrayRadioButtonGroup getExcretes(){
    if(excretes==null){

      excretes = new ACValueArrayRadioButtonGroup();

      getExcretesContainer().setText("�r��");

      excretes.setBindPath("ADL_EXCRETION");

      excretes.setNoSelectIndex(0);

      excretes.setUseClearButton(true);

      excretes.setModel(getExcretesModel());

      excretes.setValues(new int[]{1,2,3});

      addExcretes();
    }
    return excretes;

  }

  /**
   * �r���R���e�i���擾���܂��B
   * @return �r���R���e�i
   */
  protected ACLabelContainer getExcretesContainer(){
    if(excretesContainer==null){
      excretesContainer = new ACLabelContainer();
      excretesContainer.setFollowChildEnabled(true);
      excretesContainer.setVAlignment(VRLayout.CENTER);
      excretesContainer.add(getExcretes(), null);
    }
    return excretesContainer;
  }

  /**
   * �r�����f�����擾���܂��B
   * @return �r�����f��
   */
  protected ACListModelAdapter getExcretesModel(){
    if(excretesModel==null){
      excretesModel = new ACListModelAdapter();
      addExcretesModel();
    }
    return excretesModel;
  }

  /**
   * �������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getExcreteRadioItem1(){
    if(excreteRadioItem1==null){

      excreteRadioItem1 = new ACRadioButtonItem();

      excreteRadioItem1.setText("����");

      excreteRadioItem1.setGroup(getExcretes());

      excreteRadioItem1.setConstraints(VRLayout.FLOW);

      addExcreteRadioItem1();
    }
    return excreteRadioItem1;

  }

  /**
   * �ꕔ����擾���܂��B
   * @return �ꕔ�
   */
  public ACRadioButtonItem getExcreteRadioItem2(){
    if(excreteRadioItem2==null){

      excreteRadioItem2 = new ACRadioButtonItem();

      excreteRadioItem2.setText("�ꕔ�");

      excreteRadioItem2.setGroup(getExcretes());

      excreteRadioItem2.setConstraints(VRLayout.FLOW);

      addExcreteRadioItem2();
    }
    return excreteRadioItem2;

  }

  /**
   * �S�ʉ���擾���܂��B
   * @return �S�ʉ
   */
  public ACRadioButtonItem getExcreteRadioItem3(){
    if(excreteRadioItem3==null){

      excreteRadioItem3 = new ACRadioButtonItem();

      excreteRadioItem3.setText("�S�ʉ");

      excreteRadioItem3.setGroup(getExcretes());

      excreteRadioItem3.setConstraints(VRLayout.FLOW);

      addExcreteRadioItem3();
    }
    return excreteRadioItem3;

  }

  /**
   * ���ւ��擾���܂��B
   * @return ����
   */
  public ACValueArrayRadioButtonGroup getChangeClothes(){
    if(changeClothes==null){

      changeClothes = new ACValueArrayRadioButtonGroup();

      getChangeClothesContainer().setText("����");

      changeClothes.setBindPath("ADL_CHANGE_CLOTH");

      changeClothes.setNoSelectIndex(0);

      changeClothes.setUseClearButton(true);

      changeClothes.setModel(getChangeClothesModel());

      changeClothes.setValues(new int[]{1,2,3});

      addChangeClothes();
    }
    return changeClothes;

  }

  /**
   * ���փR���e�i���擾���܂��B
   * @return ���փR���e�i
   */
  protected ACLabelContainer getChangeClothesContainer(){
    if(changeClothesContainer==null){
      changeClothesContainer = new ACLabelContainer();
      changeClothesContainer.setFollowChildEnabled(true);
      changeClothesContainer.setVAlignment(VRLayout.CENTER);
      changeClothesContainer.add(getChangeClothes(), null);
    }
    return changeClothesContainer;
  }

  /**
   * ���փ��f�����擾���܂��B
   * @return ���փ��f��
   */
  protected ACListModelAdapter getChangeClothesModel(){
    if(changeClothesModel==null){
      changeClothesModel = new ACListModelAdapter();
      addChangeClothesModel();
    }
    return changeClothesModel;
  }

  /**
   * �������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getChangeClothesRadioItem1(){
    if(changeClothesRadioItem1==null){

      changeClothesRadioItem1 = new ACRadioButtonItem();

      changeClothesRadioItem1.setText("����");

      changeClothesRadioItem1.setGroup(getChangeClothes());

      changeClothesRadioItem1.setConstraints(VRLayout.FLOW);

      addChangeClothesRadioItem1();
    }
    return changeClothesRadioItem1;

  }

  /**
   * �ꕔ����擾���܂��B
   * @return �ꕔ�
   */
  public ACRadioButtonItem getChangeClothesRadioItem2(){
    if(changeClothesRadioItem2==null){

      changeClothesRadioItem2 = new ACRadioButtonItem();

      changeClothesRadioItem2.setText("�ꕔ�");

      changeClothesRadioItem2.setGroup(getChangeClothes());

      changeClothesRadioItem2.setConstraints(VRLayout.FLOW);

      addChangeClothesRadioItem2();
    }
    return changeClothesRadioItem2;

  }

  /**
   * �S�ʉ���擾���܂��B
   * @return �S�ʉ
   */
  public ACRadioButtonItem getChangeClothesRadioItem3(){
    if(changeClothesRadioItem3==null){

      changeClothesRadioItem3 = new ACRadioButtonItem();

      changeClothesRadioItem3.setText("�S�ʉ");

      changeClothesRadioItem3.setGroup(getChangeClothes());

      changeClothesRadioItem3.setConstraints(VRLayout.FLOW);

      addChangeClothesRadioItem3();
    }
    return changeClothesRadioItem3;

  }

  /**
   * ���퐶�������̏�(�E�̈�)���擾���܂��B
   * @return ���퐶�������̏�(�E�̈�)
   */
  public ACPanel getNichijokatsudoStateRight(){
    if(nichijokatsudoStateRight==null){

      nichijokatsudoStateRight = new ACPanel();

      addNichijokatsudoStateRight();
    }
    return nichijokatsudoStateRight;

  }

  /**
   * �H�����擾���܂��B
   * @return �H��
   */
  public ACValueArrayRadioButtonGroup getMeal(){
    if(meal==null){

      meal = new ACValueArrayRadioButtonGroup();

      getMealContainer().setText("�H��");

      meal.setBindPath("ADL_FOOD");

      meal.setNoSelectIndex(0);

      meal.setUseClearButton(true);

      meal.setModel(getMealModel());

      meal.setValues(new int[]{1,2,3});

      addMeal();
    }
    return meal;

  }

  /**
   * �H���R���e�i���擾���܂��B
   * @return �H���R���e�i
   */
  protected ACLabelContainer getMealContainer(){
    if(mealContainer==null){
      mealContainer = new ACLabelContainer();
      mealContainer.setFollowChildEnabled(true);
      mealContainer.setVAlignment(VRLayout.CENTER);
      mealContainer.add(getMeal(), null);
    }
    return mealContainer;
  }

  /**
   * �H�����f�����擾���܂��B
   * @return �H�����f��
   */
  protected ACListModelAdapter getMealModel(){
    if(mealModel==null){
      mealModel = new ACListModelAdapter();
      addMealModel();
    }
    return mealModel;
  }

  /**
   * �������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getMealRadioItem1(){
    if(mealRadioItem1==null){

      mealRadioItem1 = new ACRadioButtonItem();

      mealRadioItem1.setText("����");

      mealRadioItem1.setGroup(getMeal());

      mealRadioItem1.setConstraints(VRLayout.FLOW);

      addMealRadioItem1();
    }
    return mealRadioItem1;

  }

  /**
   * �ꕔ����擾���܂��B
   * @return �ꕔ�
   */
  public ACRadioButtonItem getMealRadioItem2(){
    if(mealRadioItem2==null){

      mealRadioItem2 = new ACRadioButtonItem();

      mealRadioItem2.setText("�ꕔ�");

      mealRadioItem2.setGroup(getMeal());

      mealRadioItem2.setConstraints(VRLayout.FLOW);

      addMealRadioItem2();
    }
    return mealRadioItem2;

  }

  /**
   * �S�ʉ���擾���܂��B
   * @return �S�ʉ
   */
  public ACRadioButtonItem getMealRadioItem3(){
    if(mealRadioItem3==null){

      mealRadioItem3 = new ACRadioButtonItem();

      mealRadioItem3.setText("�S�ʉ");

      mealRadioItem3.setGroup(getMeal());

      mealRadioItem3.setConstraints(VRLayout.FLOW);

      addMealRadioItem3();
    }
    return mealRadioItem3;

  }

  /**
   * �������擾���܂��B
   * @return ����
   */
  public ACValueArrayRadioButtonGroup getBath(){
    if(bath==null){

      bath = new ACValueArrayRadioButtonGroup();

      getBathContainer().setText("����");

      bath.setBindPath("ADL_BATH");

      bath.setNoSelectIndex(0);

      bath.setUseClearButton(true);

      bath.setModel(getBathModel());

      bath.setValues(new int[]{1,2,3});

      addBath();
    }
    return bath;

  }

  /**
   * �����R���e�i���擾���܂��B
   * @return �����R���e�i
   */
  protected ACLabelContainer getBathContainer(){
    if(bathContainer==null){
      bathContainer = new ACLabelContainer();
      bathContainer.setFollowChildEnabled(true);
      bathContainer.setVAlignment(VRLayout.CENTER);
      bathContainer.add(getBath(), null);
    }
    return bathContainer;
  }

  /**
   * �������f�����擾���܂��B
   * @return �������f��
   */
  protected ACListModelAdapter getBathModel(){
    if(bathModel==null){
      bathModel = new ACListModelAdapter();
      addBathModel();
    }
    return bathModel;
  }

  /**
   * �������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getBathRadioItem1(){
    if(bathRadioItem1==null){

      bathRadioItem1 = new ACRadioButtonItem();

      bathRadioItem1.setText("����");

      bathRadioItem1.setGroup(getBath());

      bathRadioItem1.setConstraints(VRLayout.FLOW);

      addBathRadioItem1();
    }
    return bathRadioItem1;

  }

  /**
   * �ꕔ����擾���܂��B
   * @return �ꕔ�
   */
  public ACRadioButtonItem getBathRadioItem2(){
    if(bathRadioItem2==null){

      bathRadioItem2 = new ACRadioButtonItem();

      bathRadioItem2.setText("�ꕔ�");

      bathRadioItem2.setGroup(getBath());

      bathRadioItem2.setConstraints(VRLayout.FLOW);

      addBathRadioItem2();
    }
    return bathRadioItem2;

  }

  /**
   * �S�ʉ���擾���܂��B
   * @return �S�ʉ
   */
  public ACRadioButtonItem getBathRadioItem3(){
    if(bathRadioItem3==null){

      bathRadioItem3 = new ACRadioButtonItem();

      bathRadioItem3.setText("�S�ʉ");

      bathRadioItem3.setGroup(getBath());

      bathRadioItem3.setConstraints(VRLayout.FLOW);

      addBathRadioItem3();
    }
    return bathRadioItem3;

  }

  /**
   * ���e���擾���܂��B
   * @return ���e
   */
  public ACValueArrayRadioButtonGroup getSeiyo(){
    if(seiyo==null){

      seiyo = new ACValueArrayRadioButtonGroup();

      getSeiyoContainer().setText("���e");

      seiyo.setBindPath("ADL_COSMETIC");

      seiyo.setNoSelectIndex(0);

      seiyo.setUseClearButton(true);

      seiyo.setModel(getSeiyoModel());

      seiyo.setValues(new int[]{1,2,3});

      addSeiyo();
    }
    return seiyo;

  }

  /**
   * ���e�R���e�i���擾���܂��B
   * @return ���e�R���e�i
   */
  protected ACLabelContainer getSeiyoContainer(){
    if(seiyoContainer==null){
      seiyoContainer = new ACLabelContainer();
      seiyoContainer.setFollowChildEnabled(true);
      seiyoContainer.setVAlignment(VRLayout.CENTER);
      seiyoContainer.add(getSeiyo(), null);
    }
    return seiyoContainer;
  }

  /**
   * ���e���f�����擾���܂��B
   * @return ���e���f��
   */
  protected ACListModelAdapter getSeiyoModel(){
    if(seiyoModel==null){
      seiyoModel = new ACListModelAdapter();
      addSeiyoModel();
    }
    return seiyoModel;
  }

  /**
   * �������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getSeiyoRadioItem1(){
    if(seiyoRadioItem1==null){

      seiyoRadioItem1 = new ACRadioButtonItem();

      seiyoRadioItem1.setText("����");

      seiyoRadioItem1.setGroup(getSeiyo());

      seiyoRadioItem1.setConstraints(VRLayout.FLOW);

      addSeiyoRadioItem1();
    }
    return seiyoRadioItem1;

  }

  /**
   * �ꕔ����擾���܂��B
   * @return �ꕔ�
   */
  public ACRadioButtonItem getSeiyoRadioItem2(){
    if(seiyoRadioItem2==null){

      seiyoRadioItem2 = new ACRadioButtonItem();

      seiyoRadioItem2.setText("�ꕔ�");

      seiyoRadioItem2.setGroup(getSeiyo());

      seiyoRadioItem2.setConstraints(VRLayout.FLOW);

      addSeiyoRadioItem2();
    }
    return seiyoRadioItem2;

  }

  /**
   * �S�ʉ���擾���܂��B
   * @return �S�ʉ
   */
  public ACRadioButtonItem getSeiyoRadioItem3(){
    if(seiyoRadioItem3==null){

      seiyoRadioItem3 = new ACRadioButtonItem();

      seiyoRadioItem3.setText("�S�ʉ");

      seiyoRadioItem3.setGroup(getSeiyo());

      seiyoRadioItem3.setConstraints(VRLayout.FLOW);

      addSeiyoRadioItem3();
    }
    return seiyoRadioItem3;

  }

  /**
   * �a��E��Q���̏�ԗ̈���擾���܂��B
   * @return �a��E��Q���̏�ԗ̈�
   */
  public ACPanel getPoints2(){
    if(points2==null){

      points2 = new ACPanel();

      addPoints2();
    }
    return points2;

  }

  /**
   * �a��E��Q���̏󋵗̈���擾���܂��B
   * @return �a��E��Q���̏󋵗̈�
   */
  public ACGroupBox getByojoAndShogais(){
    if(byojoAndShogais==null){

      byojoAndShogais = new ACGroupBox();

      byojoAndShogais.setText("�a��E��Q���̏��(45x2)");

      addByojoAndShogais();
    }
    return byojoAndShogais;

  }

  /**
   * �a��E��Q���̏�Ԃ��擾���܂��B
   * @return �a��E��Q���̏��
   */
  public ACTextArea getByojoAndShogai(){
    if(byojoAndShogai==null){

      byojoAndShogai = new ACTextArea();

      byojoAndShogai.setBindPath("BYOJO_SHOGAI_STATE");

      byojoAndShogai.setColumns(90);

      byojoAndShogai.setRows(3);

      byojoAndShogai.setMaxRows(2);

      byojoAndShogai.setIMEMode(InputSubset.KANJI);

      byojoAndShogai.setMaxLength(90);

      byojoAndShogai.setLineWrap(true);

      addByojoAndShogai();
    }
    return byojoAndShogai;

  }

  /**
   * �a��E��Q���̏�ԃR���e�i���擾���܂��B
   * @return �a��E��Q���̏�ԃR���e�i
   */
  protected ACLabelContainer getByojoAndShogaiContainer(){
    if(byojoAndShogaiContainer==null){
      byojoAndShogaiContainer = new ACLabelContainer();
      byojoAndShogaiContainer.setFollowChildEnabled(true);
      byojoAndShogaiContainer.setVAlignment(VRLayout.CENTER);
      byojoAndShogaiContainer.add(getByojoAndShogai(), VRLayout.CLIENT);
    }
    return byojoAndShogaiContainer;
  }

  /**
   * 1��������̖K��񐔗̈���擾���܂��B
   * @return 1��������̖K��񐔗̈�
   */
  public ACGroupBox getHomonkaisus(){
    if(homonkaisus==null){

      homonkaisus = new ACGroupBox();

      homonkaisus.setText("1��������̖K���");

      homonkaisus.setAutoWrap(false);

      homonkaisus.setHgap(1);

      addHomonkaisus();
    }
    return homonkaisus;

  }

  /**
   * �����擾���܂��B
   * @return ��
   */
  public ACTextField getHomonkaisuDay(){
    if(homonkaisuDay==null){

      homonkaisuDay = new ACTextField();

      homonkaisuDay.setBindPath("HOMON_KAISU_DAY");

      homonkaisuDay.setColumns(4);

      homonkaisuDay.setCharType(VRCharType.ONLY_DIGIT);

      homonkaisuDay.setHorizontalAlignment(SwingConstants.RIGHT);

      homonkaisuDay.setIMEMode(InputSubset.LATIN);

      homonkaisuDay.setMaxLength(3);

      addHomonkaisuDay();
    }
    return homonkaisuDay;

  }

  /**
   * ���R���e�i���擾���܂��B
   * @return ���R���e�i
   */
  protected ACLabelContainer getHomonkaisuDayContainer(){
    if(homonkaisuDayContainer==null){
      homonkaisuDayContainer = new ACLabelContainer();
      homonkaisuDayContainer.setFollowChildEnabled(true);
      homonkaisuDayContainer.setVAlignment(VRLayout.CENTER);
      homonkaisuDayContainer.add(getHomonkaisuDay(), null);
    }
    return homonkaisuDayContainer;
  }

  /**
   * �񐔂��擾���܂��B
   * @return ��
   */
  public ACTextField getHomonkaisuCount(){
    if(homonkaisuCount==null){

      homonkaisuCount = new ACTextField();

      getHomonkaisuCountContainer().setText("��");

      homonkaisuCount.setBindPath("HOMON_KAISU_COUNT");

      homonkaisuCount.setColumns(4);

      homonkaisuCount.setCharType(VRCharType.ONLY_DIGIT);

      homonkaisuCount.setHorizontalAlignment(SwingConstants.RIGHT);

      homonkaisuCount.setIMEMode(InputSubset.LATIN);

      homonkaisuCount.setMaxLength(3);

      addHomonkaisuCount();
    }
    return homonkaisuCount;

  }

  /**
   * �񐔃R���e�i���擾���܂��B
   * @return �񐔃R���e�i
   */
  protected ACLabelContainer getHomonkaisuCountContainer(){
    if(homonkaisuCountContainer==null){
      homonkaisuCountContainer = new ACLabelContainer();
      homonkaisuCountContainer.setFollowChildEnabled(true);
      homonkaisuCountContainer.setVAlignment(VRLayout.CENTER);
      homonkaisuCountContainer.add(getHomonkaisuCount(), null);
    }
    return homonkaisuCountContainer;
  }

  /**
   * 1��������̖K��񐔁E�L���v�V�������擾���܂��B
   * @return 1��������̖K��񐔁E�L���v�V����
   */
  public ACLabel getHomonkaisuCaption(){
    if(homonkaisuCaption==null){

      homonkaisuCaption = new ACLabel();

      homonkaisuCaption.setText("��");

      addHomonkaisuCaption();
    }
    return homonkaisuCaption;

  }

  /**
   * �Ō�̓��e�̈���擾���܂��B
   * @return �Ō�̓��e�̈�
   */
  public ACGroupBox getKangoContents(){
    if(kangoContents==null){

      kangoContents = new ACGroupBox();

      kangoContents.setText("�Ō�̓��e(45x2)");

      addKangoContents();
    }
    return kangoContents;

  }

  /**
   * �Ō�̓��e���擾���܂��B
   * @return �Ō�̓��e
   */
  public ACTextArea getKangoContent(){
    if(kangoContent==null){

      kangoContent = new ACTextArea();

      kangoContent.setBindPath("KANGO_NAIYO");

      kangoContent.setColumns(90);

      kangoContent.setRows(3);

      kangoContent.setMaxRows(2);

      kangoContent.setIMEMode(InputSubset.KANJI);

      kangoContent.setMaxLength(90);

      kangoContent.setLineWrap(true);

      addKangoContent();
    }
    return kangoContent;

  }

  /**
   * �Ō�̓��e�R���e�i���擾���܂��B
   * @return �Ō�̓��e�R���e�i
   */
  protected ACLabelContainer getKangoContentContainer(){
    if(kangoContentContainer==null){
      kangoContentContainer = new ACLabelContainer();
      kangoContentContainer.setFollowChildEnabled(true);
      kangoContentContainer.setVAlignment(VRLayout.CENTER);
      kangoContentContainer.add(getKangoContent(), VRLayout.CLIENT);
    }
    return kangoContentContainer;
  }

  /**
   * �ی������T�[�r�X�E���L�����̈���擾���܂��B
   * @return �ی������T�[�r�X�E���L�����̈�
   */
  public ACPanel getPoints3(){
    if(points3==null){

      points3 = new ACPanel();

      addPoints3();
    }
    return points3;

  }

  /**
   * �K�v�ƍl������ی������T�[�r�X�̈���擾���܂��B
   * @return �K�v�ƍl������ی������T�[�r�X�̈�
   */
  public ACGroupBox getNeedHokenfukushiServices(){
    if(needHokenfukushiServices==null){

      needHokenfukushiServices = new ACGroupBox();

      needHokenfukushiServices.setText("�K�v�ƍl������ی������T�[�r�X(45x2)");

      addNeedHokenfukushiServices();
    }
    return needHokenfukushiServices;

  }

  /**
   * �K�v�ƍl������ی������T�[�r�X���擾���܂��B
   * @return �K�v�ƍl������ی������T�[�r�X
   */
  public ACTextArea getNeedHokenfukushiService(){
    if(needHokenfukushiService==null){

      needHokenfukushiService = new ACTextArea();

      needHokenfukushiService.setBindPath("HOKEN_FUKUSHI_SERVICE");

      needHokenfukushiService.setColumns(90);

      needHokenfukushiService.setRows(3);

      needHokenfukushiService.setMaxRows(2);

      needHokenfukushiService.setIMEMode(InputSubset.KANJI);

      needHokenfukushiService.setMaxLength(90);

      needHokenfukushiService.setLineWrap(true);

      addNeedHokenfukushiService();
    }
    return needHokenfukushiService;

  }

  /**
   * �K�v�ƍl������ی������T�[�r�X�R���e�i���擾���܂��B
   * @return �K�v�ƍl������ی������T�[�r�X�R���e�i
   */
  protected ACLabelContainer getNeedHokenfukushiServiceContainer(){
    if(needHokenfukushiServiceContainer==null){
      needHokenfukushiServiceContainer = new ACLabelContainer();
      needHokenfukushiServiceContainer.setFollowChildEnabled(true);
      needHokenfukushiServiceContainer.setVAlignment(VRLayout.CENTER);
      needHokenfukushiServiceContainer.add(getNeedHokenfukushiService(), VRLayout.CLIENT);
    }
    return needHokenfukushiServiceContainer;
  }

  /**
   * ���̑����L���ׂ����ӎ����̈���擾���܂��B
   * @return ���̑����L���ׂ����ӎ����̈�
   */
  public ACGroupBox getExtraTokijikos(){
    if(extraTokijikos==null){

      extraTokijikos = new ACGroupBox();

      extraTokijikos.setText("���̑����L���ׂ����ӎ���(45x2)");

      addExtraTokijikos();
    }
    return extraTokijikos;

  }

  /**
   * ���̑����L���ׂ����ӎ������擾���܂��B
   * @return ���̑����L���ׂ����ӎ���
   */
  public ACTextArea getExtraTokijiko(){
    if(extraTokijiko==null){

      extraTokijiko = new ACTextArea();

      extraTokijiko.setBindPath("RYUIJIKO");

      extraTokijiko.setColumns(90);

      extraTokijiko.setRows(3);

      extraTokijiko.setMaxRows(2);

      extraTokijiko.setIMEMode(InputSubset.KANJI);

      extraTokijiko.setMaxLength(90);

      extraTokijiko.setLineWrap(true);

      addExtraTokijiko();
    }
    return extraTokijiko;

  }

  /**
   * ���̑����L���ׂ����ӎ����R���e�i���擾���܂��B
   * @return ���̑����L���ׂ����ӎ����R���e�i
   */
  protected ACLabelContainer getExtraTokijikoContainer(){
    if(extraTokijikoContainer==null){
      extraTokijikoContainer = new ACLabelContainer();
      extraTokijikoContainer.setFollowChildEnabled(true);
      extraTokijikoContainer.setVAlignment(VRLayout.CENTER);
      extraTokijikoContainer.add(getExtraTokijiko(), VRLayout.CLIENT);
    }
    return extraTokijikoContainer;
  }

  /**
   * �R���X�g���N�^�ł��B
   */
  public QC003Design() {

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

    contents.add(getInfos(), VRLayout.NORTH);

    contents.add(getPatients(), VRLayout.NORTH);

    contents.add(getProviders(), VRLayout.NORTH);

    contents.add(getTabs(), VRLayout.CLIENT);

  }

  /**
   * ���̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addInfos(){

    infos.add(getInfoTheOfferContainer(), VRLayout.FLOW);

    infos.add(getResultDayContainer(), VRLayout.FLOW);

  }

  /**
   * ���񋟐�ɓ������ڂ�ǉ����܂��B
   */
  protected void addInfoTheOffer(){

  }

  /**
   * ���{���ɓ������ڂ�ǉ����܂��B
   */
  protected void addResultDay(){

  }

  /**
   * ���p�җ̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatients(){

    patients.add(getPatient(), VRLayout.CLIENT);

  }

  /**
   * ���p�җ̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatient(){

    patient.add(getPatientNameContainer(), VRLayout.FLOW_INSETLINE);

    patient.add(getPatientSexContainer(), VRLayout.FLOW);

    patient.add(getPatientBirths(), VRLayout.FLOW);

    patient.add(getPatientJobContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    patient.add(getPatientAddressContainer(), VRLayout.FLOW_INSETLINE);

    patient.add(getPatientTels(), VRLayout.FLOW_INSETLINE_RETURN);

    patient.add(getPatientYokaigodoContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    patient.add(getPatientDiseaseNameContainer(), VRLayout.FLOW_INSETLINE);

  }

  /**
   * ���p�Ҏ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatientName(){

  }

  /**
   * ���p�Ґ��ʂɓ������ڂ�ǉ����܂��B
   */
  protected void addPatientSex(){

  }

  /**
   * ���p�Ґ��N�����E�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatientBirths(){

    patientBirths.add(getPatientBirth(), VRLayout.FLOW);

    patientBirths.add(getPatientAge(), VRLayout.FLOW);

    patientBirths.add(getPatientAgeLabel(), VRLayout.FLOW);

  }

  /**
   * ���p�Ґ��N�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatientBirth(){

  }

  /**
   * ���p�ҔN��ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatientAge(){

  }

  /**
   * �΂ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatientAgeLabel(){

  }

  /**
   * ���p�ҐE�Ƃɓ������ڂ�ǉ����܂��B
   */
  protected void addPatientJob(){

  }

  /**
   * ���p�ҏZ���ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatientAddress(){

  }

  /**
   * ���p�ғd�b�ԍ��E�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatientTels(){

    patientTels.add(getPatientTel1(), VRLayout.FLOW);

    patientTels.add(getPatientTelLabel1(), VRLayout.FLOW);

    patientTels.add(getPatientTel2(), VRLayout.FLOW);

    patientTels.add(getPatientTelLabel2(), VRLayout.FLOW);

    patientTels.add(getPatientTel3(), VRLayout.FLOW);

  }

  /**
   * ���p�ғd�b�ԍ�1�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatientTel1(){

  }

  /**
   * ���p���x��1�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatientTelLabel1(){

  }

  /**
   * ���p�ғd�b�ԍ�2�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatientTel2(){

  }

  /**
   * ���p�҃��x��2�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatientTelLabel2(){

  }

  /**
   * ���p�ғd�b�ԍ�3�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatientTel3(){

  }

  /**
   * ���p�җv���F��ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatientYokaigodo(){

  }

  /**
   * ���p�җv���F�胂�f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatientYokaigodoModel(){

    getYokaigodoRadio1().setButtonIndex(1);
    getPatientYokaigodoModel().add(getYokaigodoRadio1());

    getYokaigodoRadio2().setButtonIndex(2);
    getPatientYokaigodoModel().add(getYokaigodoRadio2());

    getYokaigodoRadio3().setButtonIndex(3);
    getPatientYokaigodoModel().add(getYokaigodoRadio3());

    getYokaigodoRadio4().setButtonIndex(4);
    getPatientYokaigodoModel().add(getYokaigodoRadio4());

    getYokaigodoRadio5().setButtonIndex(5);
    getPatientYokaigodoModel().add(getYokaigodoRadio5());

    getYokaigodoRadio6().setButtonIndex(6);
    getPatientYokaigodoModel().add(getYokaigodoRadio6());

    getYokaigodoRadio7().setButtonIndex(7);
    getPatientYokaigodoModel().add(getYokaigodoRadio7());

    getYokaigodoRadio8().setButtonIndex(8);
    getPatientYokaigodoModel().add(getYokaigodoRadio8());

    getYokaigodoRadio9().setButtonIndex(9);
    getPatientYokaigodoModel().add(getYokaigodoRadio9());

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
   * ���p�Ҏ叝�a���ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatientDiseaseName(){

  }

  /**
   * ���Ə��̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviders(){

    providers.add(getProvider(), VRLayout.CLIENT);

  }

  /**
   * ���Ə��̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addProvider(){

    provider.add(getProviderNameContainer(), VRLayout.FLOW_INSETLINE);

    provider.add(getProviderAdderessContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    provider.add(getProviderTels(), VRLayout.FLOW_INSETLINE);

    provider.add(getProvidarAdministratorContainer(), VRLayout.FLOW);

  }

  /**
   * ���Ə����̂ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderName(){

  }

  /**
   * ���Ə����̃��f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderNameModel(){

  }

  /**
   * ���Ə����ݒn�ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderAdderess(){

  }

  /**
   * ���Ə��d�b�ԍ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderTels(){

    providerTels.add(getProviderTel1(), VRLayout.FLOW);

    providerTels.add(getProviderLabel1(), VRLayout.FLOW);

    providerTels.add(getProviderTel2(), VRLayout.FLOW);

    providerTels.add(getProviderLabel2(), VRLayout.FLOW);

    providerTels.add(getProviderTel3(), VRLayout.FLOW);

  }

  /**
   * ���Ə��d�b�ԍ�1�ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderTel1(){

  }

  /**
   * ���Ə����x��1�ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderLabel1(){

  }

  /**
   * ���Ə��d�b�ԍ�2�ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderTel2(){

  }

  /**
   * ���Ə����x��2�ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderLabel2(){

  }

  /**
   * ���Ə��d�b�ԍ�3�ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderTel3(){

  }

  /**
   * ���Ə��Ǘ��҂ɓ������ڂ�ǉ����܂��B
   */
  protected void addProvidarAdministrator(){

  }

  /**
   * �^�u�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTabs(){

    tabs.addTab("���퐶������(ADL)�̏�", getPoints1());

    tabs.addTab("�a��E��Q���̏��", getPoints2());

    tabs.addTab("�ی������T�[�r�X�E���L����", getPoints3());

  }

  /**
   * �厡��E�v���F��󋵁EADL�̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPoints1(){

    points1.add(getSyujis(), VRLayout.NORTH);

    points1.add(getNichijokatsudoStates(), VRLayout.NORTH);

  }

  /**
   * �厡��̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addSyujis(){

    syujis.add(getSyujiNameContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    syujis.add(getSyujiAddressContainer(), VRLayout.FLOW_INSETLINE);

  }

  /**
   * �厡�㎁���ɓ������ڂ�ǉ����܂��B
   */
  protected void addSyujiName(){

  }

  /**
   * �厡��Z���ɓ������ڂ�ǉ����܂��B
   */
  protected void addSyujiAddress(){

  }

  /**
   * ���퐶�������̏󋵗̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addNichijokatsudoStates(){

    nichijokatsudoStates.add(getNichijokatsudoStateLeft(), VRLayout.CLIENT);

    nichijokatsudoStates.add(getNichijokatsudoStateRight(), VRLayout.CLIENT);

  }

  /**
   * ���퐶�������̏�(���̈�)�ɓ������ڂ�ǉ����܂��B
   */
  protected void addNichijokatsudoStateLeft(){

    nichijokatsudoStateLeft.add(getMovesContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    nichijokatsudoStateLeft.add(getExcretesContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    nichijokatsudoStateLeft.add(getChangeClothesContainer(), VRLayout.FLOW_INSETLINE);

  }

  /**
   * �ړ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addMoves(){

  }

  /**
   * �ړ����f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addMovesModel(){

    getMoveRadioItem1().setButtonIndex(1);
    getMovesModel().add(getMoveRadioItem1());

    getMoveRadioItem2().setButtonIndex(2);
    getMovesModel().add(getMoveRadioItem2());

    getMoveRadioItem3().setButtonIndex(3);
    getMovesModel().add(getMoveRadioItem3());

  }

  /**
   * �����ɓ������ڂ�ǉ����܂��B
   */
  protected void addMoveRadioItem1(){

  }

  /**
   * �ꕔ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addMoveRadioItem2(){

  }

  /**
   * �S�ʉ�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMoveRadioItem3(){

  }

  /**
   * �r���ɓ������ڂ�ǉ����܂��B
   */
  protected void addExcretes(){

  }

  /**
   * �r�����f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addExcretesModel(){

    getExcreteRadioItem1().setButtonIndex(1);
    getExcretesModel().add(getExcreteRadioItem1());

    getExcreteRadioItem2().setButtonIndex(2);
    getExcretesModel().add(getExcreteRadioItem2());

    getExcreteRadioItem3().setButtonIndex(3);
    getExcretesModel().add(getExcreteRadioItem3());

  }

  /**
   * �����ɓ������ڂ�ǉ����܂��B
   */
  protected void addExcreteRadioItem1(){

  }

  /**
   * �ꕔ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addExcreteRadioItem2(){

  }

  /**
   * �S�ʉ�ɓ������ڂ�ǉ����܂��B
   */
  protected void addExcreteRadioItem3(){

  }

  /**
   * ���ւɓ������ڂ�ǉ����܂��B
   */
  protected void addChangeClothes(){

  }

  /**
   * ���փ��f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addChangeClothesModel(){

    getChangeClothesRadioItem1().setButtonIndex(1);
    getChangeClothesModel().add(getChangeClothesRadioItem1());

    getChangeClothesRadioItem2().setButtonIndex(2);
    getChangeClothesModel().add(getChangeClothesRadioItem2());

    getChangeClothesRadioItem3().setButtonIndex(3);
    getChangeClothesModel().add(getChangeClothesRadioItem3());

  }

  /**
   * �����ɓ������ڂ�ǉ����܂��B
   */
  protected void addChangeClothesRadioItem1(){

  }

  /**
   * �ꕔ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addChangeClothesRadioItem2(){

  }

  /**
   * �S�ʉ�ɓ������ڂ�ǉ����܂��B
   */
  protected void addChangeClothesRadioItem3(){

  }

  /**
   * ���퐶�������̏�(�E�̈�)�ɓ������ڂ�ǉ����܂��B
   */
  protected void addNichijokatsudoStateRight(){

    nichijokatsudoStateRight.add(getMealContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    nichijokatsudoStateRight.add(getBathContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    nichijokatsudoStateRight.add(getSeiyoContainer(), VRLayout.FLOW_INSETLINE);

  }

  /**
   * �H���ɓ������ڂ�ǉ����܂��B
   */
  protected void addMeal(){

  }

  /**
   * �H�����f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addMealModel(){

    getMealRadioItem1().setButtonIndex(1);
    getMealModel().add(getMealRadioItem1());

    getMealRadioItem2().setButtonIndex(2);
    getMealModel().add(getMealRadioItem2());

    getMealRadioItem3().setButtonIndex(3);
    getMealModel().add(getMealRadioItem3());

  }

  /**
   * �����ɓ������ڂ�ǉ����܂��B
   */
  protected void addMealRadioItem1(){

  }

  /**
   * �ꕔ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addMealRadioItem2(){

  }

  /**
   * �S�ʉ�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMealRadioItem3(){

  }

  /**
   * �����ɓ������ڂ�ǉ����܂��B
   */
  protected void addBath(){

  }

  /**
   * �������f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addBathModel(){

    getBathRadioItem1().setButtonIndex(1);
    getBathModel().add(getBathRadioItem1());

    getBathRadioItem2().setButtonIndex(2);
    getBathModel().add(getBathRadioItem2());

    getBathRadioItem3().setButtonIndex(3);
    getBathModel().add(getBathRadioItem3());

  }

  /**
   * �����ɓ������ڂ�ǉ����܂��B
   */
  protected void addBathRadioItem1(){

  }

  /**
   * �ꕔ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addBathRadioItem2(){

  }

  /**
   * �S�ʉ�ɓ������ڂ�ǉ����܂��B
   */
  protected void addBathRadioItem3(){

  }

  /**
   * ���e�ɓ������ڂ�ǉ����܂��B
   */
  protected void addSeiyo(){

  }

  /**
   * ���e���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addSeiyoModel(){

    getSeiyoRadioItem1().setButtonIndex(1);
    getSeiyoModel().add(getSeiyoRadioItem1());

    getSeiyoRadioItem2().setButtonIndex(2);
    getSeiyoModel().add(getSeiyoRadioItem2());

    getSeiyoRadioItem3().setButtonIndex(3);
    getSeiyoModel().add(getSeiyoRadioItem3());

  }

  /**
   * �����ɓ������ڂ�ǉ����܂��B
   */
  protected void addSeiyoRadioItem1(){

  }

  /**
   * �ꕔ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addSeiyoRadioItem2(){

  }

  /**
   * �S�ʉ�ɓ������ڂ�ǉ����܂��B
   */
  protected void addSeiyoRadioItem3(){

  }

  /**
   * �a��E��Q���̏�ԗ̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPoints2(){

    points2.add(getByojoAndShogais(), VRLayout.FLOW_INSETLINE_RETURN);

    points2.add(getHomonkaisus(), VRLayout.FLOW_INSETLINE_RETURN);

    points2.add(getKangoContents(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * �a��E��Q���̏󋵗̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addByojoAndShogais(){

    byojoAndShogais.add(getByojoAndShogaiContainer(), VRLayout.CLIENT);

  }

  /**
   * �a��E��Q���̏�Ԃɓ������ڂ�ǉ����܂��B
   */
  protected void addByojoAndShogai(){

  }

  /**
   * 1��������̖K��񐔗̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHomonkaisus(){

    homonkaisus.add(getHomonkaisuDayContainer(), VRLayout.FLOW);

    homonkaisus.add(getHomonkaisuCountContainer(), VRLayout.FLOW);

    homonkaisus.add(getHomonkaisuCaption(), VRLayout.FLOW);

  }

  /**
   * ���ɓ������ڂ�ǉ����܂��B
   */
  protected void addHomonkaisuDay(){

  }

  /**
   * �񐔂ɓ������ڂ�ǉ����܂��B
   */
  protected void addHomonkaisuCount(){

  }

  /**
   * 1��������̖K��񐔁E�L���v�V�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addHomonkaisuCaption(){

  }

  /**
   * �Ō�̓��e�̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKangoContents(){

    kangoContents.add(getKangoContentContainer(), VRLayout.CLIENT);

  }

  /**
   * �Ō�̓��e�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKangoContent(){

  }

  /**
   * �ی������T�[�r�X�E���L�����̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPoints3(){

    points3.add(getNeedHokenfukushiServices(), VRLayout.FLOW_INSETLINE_RETURN);

    points3.add(getExtraTokijikos(), VRLayout.FLOW_INSETLINE);

  }

  /**
   * �K�v�ƍl������ی������T�[�r�X�̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addNeedHokenfukushiServices(){

    needHokenfukushiServices.add(getNeedHokenfukushiServiceContainer(), VRLayout.CLIENT);

  }

  /**
   * �K�v�ƍl������ی������T�[�r�X�ɓ������ڂ�ǉ����܂��B
   */
  protected void addNeedHokenfukushiService(){

  }

  /**
   * ���̑����L���ׂ����ӎ����̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addExtraTokijikos(){

    extraTokijikos.add(getExtraTokijikoContainer(), VRLayout.CLIENT);

  }

  /**
   * ���̑����L���ׂ����ӎ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addExtraTokijiko(){

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
      ACFrame.debugStart(new ACAffairInfo(QC003Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QC003Design getThis() {
    return this;
  }
}
