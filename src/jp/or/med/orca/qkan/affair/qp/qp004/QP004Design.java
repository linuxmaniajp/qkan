
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
 * �J����: �����@�L
 * �쐬��: 2018/04/20  ���{�R���s���[�^�[������� �����@�L �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �����f�[�^�쐬 (P)
 * �v���Z�X �m�F�E�C�� (004)
 * �v���O���� ���׏���{���ҏW��� (QP004)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qp.qp004;
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
import jp.nichicom.ac.component.table.event.*;
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
 * ���׏���{���ҏW��ʉ�ʍ��ڃf�U�C��(QP004) 
 */
public class QP004Design extends QkanAffairContainer implements ACAffairable {
  //GUI�R���|�[�l���g

  private ACAffairButtonBar buttons;

  private ACAffairButton tekiyoHelp;

  private ACAffairButton detail;

  private ACAffairButton update;

  private ACPanel contents;

  private ACPanel patientNames;

  private ACLabel patinetNameLabel;

  private ACTextField patientName;

  private ACLabel patientNoLabel1;

  private ACTextField patientNo;

  private ACLabel PatientNoLabel2;

  private ACGroupBox kyotakuIdouGroup;

  private QkanDateTextField contentsStartDate;

  private ACLabelContainer contentsStartDateContainer;

  private QkanDateTextField contentsStopDate;

  private ACLabelContainer contentsStopDateContainer;

  private ACValueArrayRadioButtonGroup contentsStopReasons;

  private ACLabelContainer contentsStopReasonsContainer;

  private ACListModelAdapter contentsStopReasonsModel;

  private ACRadioButtonItem contentsStopReaseonHigaito;

  private ACRadioButtonItem contentsStopReaseonNyuin;

  private ACRadioButtonItem contentsStopReaseonDeath;

  private ACRadioButtonItem contentsStopReaseonEtc;

  private ACRadioButtonItem contentsStopReaseonTokuyo;

  private ACRadioButtonItem contentsStopReaseonRouken;

  private ACRadioButtonItem contentsStopReaseonRyoyo;

  private ACRadioButtonItem contentsStopReaseonIryoin;

  private ACGroupBox shisetsuIdouGroup;

  private QkanDateTextField contentsNyushoDate;

  private ACLabelContainer contentsNyushoDateContainer;

  private QkanDateTextField contentsTaishoDate;

  private ACLabelContainer contentsTaishoDateContainer;

  private ACTextField contentsNyushoDays;

  private ACLabelContainer contentsNyushoDaysContainer;

  private ACTextField contentsTankiNyushoDays;

  private ACLabelContainer contentsTankiNyushoDaysContainer;

  private ACTextField contentsGaihakuDays;

  private ACLabelContainer contentsGaihakuDaysContainer;

  private ACValueArrayRadioButtonGroup contentsNyushoJotais;

  private ACLabelContainer contentsNyushoJotaisContainer;

  private ACListModelAdapter contentsNyushoJotaisModel;

  private ACRadioButtonItem contentsNyushoZaitaku;

  private ACRadioButtonItem contentsNyushoIryo;

  private ACRadioButtonItem contentsNyushoFukushi;

  private ACRadioButtonItem contentsNyushoHoken;

  private ACRadioButtonItem contentsNyushoRyoyo;

  private ACRadioButtonItem contentsNyushoNinchi;

  private ACRadioButtonItem contentsNyushoTokutei;

  private ACRadioButtonItem contentsNyushoEtc;

  private ACRadioButtonItem contentsNyushoIryoin;

  private ACValueArrayRadioButtonGroup contentsTaishoJotais;

  private ACLabelContainer contentsTaishoJotaisContainer;

  private ACListModelAdapter contentsTaishoJotaisModel;

  private ACRadioButtonItem contentsTaishoJotaiZaitaku;

  private ACRadioButtonItem contentsTaishoJotaiNyuin;

  private ACRadioButtonItem contentsTaishoJotaiDeath;

  private ACRadioButtonItem contentsTaishoJotaiEtc;

  private ACRadioButtonItem contentsTaishoJotaiTokuyo;

  private ACRadioButtonItem contentsTaishoJotaiRouken;

  private ACRadioButtonItem contentsTaishoJotaiRyoyo;

  private ACRadioButtonItem contentsTaishoJotaiIryoin;

  private ACPanel editTekiyoPanel;

  private ACGroupBox baseSummaryArea;

  private ACTextField baseSummaryText;

  private ACTable baseSummaryTable;

  private VRTableColumnModel baseSummaryTableColumnModel;

  private ACTableColumn baseSummaryNoColumn;

  private ACTableColumn baseSummaryKindCodeColumn;

  private ACTableColumn baseSummaryNameColumn;

  private ACTableColumn baseSummaryNaiyoColumn;

  private ACGroupBox tekiyos;

  private ACTextField tekiyoText;

  private ACTable tekiyoTable;

  private VRTableColumnModel tekiyoTableColumnModel;

  private ACTableColumn tekiyoNoColumn;

  private ACTableColumn tekiyoServiceCodeColumn;

  private ACTableColumn tekiyoServiceNameColumn;

  private ACTableColumn tekiyoTimesColumn;

  private ACTableColumn tekiyoServiceUnitColumn;

  private ACTableColumn tekiyoTekiyoColumn;

  private ACGroupBox shinryos;

  private ACTextField shinryoDeseaseText;

  private ACLabelContainer shinryoDeseaseTextContainer;

  private ACTextField shinryoText;

  private ACTable sinryoTable;

  private VRTableColumnModel sinryoTableColumnModel;

  private ACTableColumn sinryoNoColumn;

  private ACTableColumn sinryoShikibetsuColumn;

  private ACTableColumn sinryoNameColumn;

  private ACTableColumn sinryoTimesColumn;

  private ACTableColumn sinryoUnitColumn;

  private ACTableColumn sinryoTekiyoColumn;

  //getter

  /**
   * �{�^���o�[���擾���܂��B
   * @return �{�^���o�[
   */
  public ACAffairButtonBar getButtons(){
    if(buttons==null){

      buttons = new ACAffairButtonBar();

      buttons.setText("���׏���{���ҏW");

      addButtons();
    }
    return buttons;

  }

  /**
   * �E�v�\���{�^��(H)���擾���܂��B
   * @return �E�v�\���{�^��(H)
   */
  public ACAffairButton getTekiyoHelp(){
    if(tekiyoHelp==null){

      tekiyoHelp = new ACAffairButton();

      tekiyoHelp.setText("�E�v�L��(H)");

      tekiyoHelp.setToolTipText("�E�v���L�ڎ����ɂ��Ă̐�����\�����܂��B");

      tekiyoHelp.setMnemonic('H');

      tekiyoHelp.setIconPath(ACConstants.ICON_PATH_QUESTION_24);

      addTekiyoHelp();
    }
    return tekiyoHelp;

  }

  /**
   * �ڍ׃{�^��(E)���擾���܂��B
   * @return �ڍ׃{�^��(E)
   */
  public ACAffairButton getDetail(){
    if(detail==null){

      detail = new ACAffairButton();

      detail.setText("�ڍ�(E)");

      detail.setToolTipText("����ɏڍׂȓ��e���m�F�E�C�����܂��B");

      detail.setMnemonic('E');

      detail.setIconPath(ACConstants.ICON_PATH_DETAIL_24);

      addDetail();
    }
    return detail;

  }

  /**
   * �X�V�{�^��(S)���擾���܂��B
   * @return �X�V�{�^��(S)
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
   * ���p�Җ��̈���擾���܂��B
   * @return ���p�Җ��̈�
   */
  public ACPanel getPatientNames(){
    if(patientNames==null){

      patientNames = new ACPanel();

      patientNames.setHgap(3);

      patientNames.setVgap(3);

      addPatientNames();
    }
    return patientNames;

  }

  /**
   * ���p�Җ��E���x�����擾���܂��B
   * @return ���p�Җ��E���x��
   */
  public ACLabel getPatinetNameLabel(){
    if(patinetNameLabel==null){

      patinetNameLabel = new ACLabel();

      patinetNameLabel.setText("���p�Җ�");

      addPatinetNameLabel();
    }
    return patinetNameLabel;

  }

  /**
   * ���p�Җ����擾���܂��B
   * @return ���p�Җ�
   */
  public ACTextField getPatientName(){
    if(patientName==null){

      patientName = new ACTextField();

      patientName.setBindPath("PATIENT_NAME");

      patientName.setEditable(false);

      patientName.setColumns(35);

      patientName.setMaxLength(34);

      addPatientName();
    }
    return patientName;

  }

  /**
   * ���p�҃R�[�h�E���x��1���擾���܂��B
   * @return ���p�҃R�[�h�E���x��1
   */
  public ACLabel getPatientNoLabel1(){
    if(patientNoLabel1==null){

      patientNoLabel1 = new ACLabel();

      patientNoLabel1.setText("�i���p�҃R�[�h");

      addPatientNoLabel1();
    }
    return patientNoLabel1;

  }

  /**
   * ���p�҃R�[�h���擾���܂��B
   * @return ���p�҃R�[�h
   */
  public ACTextField getPatientNo(){
    if(patientNo==null){

      patientNo = new ACTextField();

      patientNo.setBindPath("PATIENT_CODE");

      patientNo.setEditable(false);

      patientNo.setColumns(15);

      patientNo.setMaxLength(20);

      addPatientNo();
    }
    return patientNo;

  }

  /**
   * ���p�҃R�[�h�E���x��2���擾���܂��B
   * @return ���p�҃R�[�h�E���x��2
   */
  public ACLabel getPatientNoLabel2(){
    if(PatientNoLabel2==null){

      PatientNoLabel2 = new ACLabel();

      PatientNoLabel2.setText("�j");

      addPatientNoLabel2();
    }
    return PatientNoLabel2;

  }

  /**
   * ����n�ٓ������擾���܂��B
   * @return ����n�ٓ����
   */
  public ACGroupBox getKyotakuIdouGroup(){
    if(kyotakuIdouGroup==null){

      kyotakuIdouGroup = new ACGroupBox();

      kyotakuIdouGroup.setText("�ٓ����");

      kyotakuIdouGroup.setAutoWrap(true);

      kyotakuIdouGroup.setFollowChildEnabled(true);

      kyotakuIdouGroup.setHgrid(200);

      addKyotakuIdouGroup();
    }
    return kyotakuIdouGroup;

  }

  /**
   * �J�n�N�������擾���܂��B
   * @return �J�n�N����
   */
  public QkanDateTextField getContentsStartDate(){
    if(contentsStartDate==null){

      contentsStartDate = new QkanDateTextField();

      getContentsStartDateContainer().setText("�J�n�N����");

      contentsStartDate.setBindPath("201021");

      addContentsStartDate();
    }
    return contentsStartDate;

  }

  /**
   * �J�n�N�����R���e�i���擾���܂��B
   * @return �J�n�N�����R���e�i
   */
  protected ACLabelContainer getContentsStartDateContainer(){
    if(contentsStartDateContainer==null){
      contentsStartDateContainer = new ACLabelContainer();
      contentsStartDateContainer.setFollowChildEnabled(true);
      contentsStartDateContainer.setVAlignment(VRLayout.CENTER);
      contentsStartDateContainer.add(getContentsStartDate(), null);
    }
    return contentsStartDateContainer;
  }

  /**
   * ���~�N�������擾���܂��B
   * @return ���~�N����
   */
  public QkanDateTextField getContentsStopDate(){
    if(contentsStopDate==null){

      contentsStopDate = new QkanDateTextField();

      getContentsStopDateContainer().setText("���~�N����");

      contentsStopDate.setBindPath("201022");

      addContentsStopDate();
    }
    return contentsStopDate;

  }

  /**
   * ���~�N�����R���e�i���擾���܂��B
   * @return ���~�N�����R���e�i
   */
  protected ACLabelContainer getContentsStopDateContainer(){
    if(contentsStopDateContainer==null){
      contentsStopDateContainer = new ACLabelContainer();
      contentsStopDateContainer.setFollowChildEnabled(true);
      contentsStopDateContainer.setVAlignment(VRLayout.CENTER);
      contentsStopDateContainer.add(getContentsStopDate(), null);
    }
    return contentsStopDateContainer;
  }

  /**
   * ���~���R�R�[�h���擾���܂��B
   * @return ���~���R�R�[�h
   */
  public ACValueArrayRadioButtonGroup getContentsStopReasons(){
    if(contentsStopReasons==null){

      contentsStopReasons = new ACValueArrayRadioButtonGroup();

      getContentsStopReasonsContainer().setText("���~���R�R�[�h");

      contentsStopReasons.setBindPath("201023");

      contentsStopReasons.setNoSelectIndex(0);

      contentsStopReasons.setUseClearButton(true);

      contentsStopReasons.setModel(getContentsStopReasonsModel());

      contentsStopReasons.setValues(new int[]{1,3,4,5,6,7,8,9});

      addContentsStopReasons();
    }
    return contentsStopReasons;

  }

  /**
   * ���~���R�R�[�h�R���e�i���擾���܂��B
   * @return ���~���R�R�[�h�R���e�i
   */
  protected ACLabelContainer getContentsStopReasonsContainer(){
    if(contentsStopReasonsContainer==null){
      contentsStopReasonsContainer = new ACLabelContainer();
      contentsStopReasonsContainer.setFollowChildEnabled(true);
      contentsStopReasonsContainer.setVAlignment(VRLayout.CENTER);
      contentsStopReasonsContainer.add(getContentsStopReasons(), null);
    }
    return contentsStopReasonsContainer;
  }

  /**
   * ���~���R�R�[�h���f�����擾���܂��B
   * @return ���~���R�R�[�h���f��
   */
  protected ACListModelAdapter getContentsStopReasonsModel(){
    if(contentsStopReasonsModel==null){
      contentsStopReasonsModel = new ACListModelAdapter();
      addContentsStopReasonsModel();
    }
    return contentsStopReasonsModel;
  }

  /**
   * 1.��Y�����擾���܂��B
   * @return 1.��Y��
   */
  public ACRadioButtonItem getContentsStopReaseonHigaito(){
    if(contentsStopReaseonHigaito==null){

      contentsStopReaseonHigaito = new ACRadioButtonItem();

      contentsStopReaseonHigaito.setText("1.��Y��");

      contentsStopReaseonHigaito.setGroup(getContentsStopReasons());

      contentsStopReaseonHigaito.setConstraints(VRLayout.FLOW);

      addContentsStopReaseonHigaito();
    }
    return contentsStopReaseonHigaito;

  }

  /**
   * 3.��Ë@�֓��@���擾���܂��B
   * @return 3.��Ë@�֓��@
   */
  public ACRadioButtonItem getContentsStopReaseonNyuin(){
    if(contentsStopReaseonNyuin==null){

      contentsStopReaseonNyuin = new ACRadioButtonItem();

      contentsStopReaseonNyuin.setText("3.��Ë@�֓��@");

      contentsStopReaseonNyuin.setGroup(getContentsStopReasons());

      contentsStopReaseonNyuin.setConstraints(VRLayout.FLOW);

      addContentsStopReaseonNyuin();
    }
    return contentsStopReaseonNyuin;

  }

  /**
   * 4.���S���擾���܂��B
   * @return 4.���S
   */
  public ACRadioButtonItem getContentsStopReaseonDeath(){
    if(contentsStopReaseonDeath==null){

      contentsStopReaseonDeath = new ACRadioButtonItem();

      contentsStopReaseonDeath.setText("4.���S");

      contentsStopReaseonDeath.setGroup(getContentsStopReasons());

      contentsStopReaseonDeath.setConstraints(VRLayout.FLOW);

      addContentsStopReaseonDeath();
    }
    return contentsStopReaseonDeath;

  }

  /**
   * 5.���̑����擾���܂��B
   * @return 5.���̑�
   */
  public ACRadioButtonItem getContentsStopReaseonEtc(){
    if(contentsStopReaseonEtc==null){

      contentsStopReaseonEtc = new ACRadioButtonItem();

      contentsStopReaseonEtc.setText("5.���̑�");

      contentsStopReaseonEtc.setGroup(getContentsStopReasons());

      contentsStopReaseonEtc.setConstraints(VRLayout.FLOW_RETURN);

      addContentsStopReaseonEtc();
    }
    return contentsStopReaseonEtc;

  }

  /**
   * 6.���V�l�����{�ݓ������擾���܂��B
   * @return 6.���V�l�����{�ݓ���
   */
  public ACRadioButtonItem getContentsStopReaseonTokuyo(){
    if(contentsStopReaseonTokuyo==null){

      contentsStopReaseonTokuyo = new ACRadioButtonItem();

      contentsStopReaseonTokuyo.setText("6.���V�l�����{�ݓ���");

      contentsStopReaseonTokuyo.setGroup(getContentsStopReasons());

      contentsStopReaseonTokuyo.setConstraints(VRLayout.FLOW);

      addContentsStopReaseonTokuyo();
    }
    return contentsStopReaseonTokuyo;

  }

  /**
   * 7.���V�l�ی��{�ݓ������擾���܂��B
   * @return 7.���V�l�ی��{�ݓ���
   */
  public ACRadioButtonItem getContentsStopReaseonRouken(){
    if(contentsStopReaseonRouken==null){

      contentsStopReaseonRouken = new ACRadioButtonItem();

      contentsStopReaseonRouken.setText("7.���V�l�ی��{�ݓ���");

      contentsStopReaseonRouken.setGroup(getContentsStopReasons());

      contentsStopReaseonRouken.setConstraints(VRLayout.FLOW);

      addContentsStopReaseonRouken();
    }
    return contentsStopReaseonRouken;

  }

  /**
   * 8.���×{�^��Î{�ݓ��@���擾���܂��B
   * @return 8.���×{�^��Î{�ݓ��@
   */
  public ACRadioButtonItem getContentsStopReaseonRyoyo(){
    if(contentsStopReaseonRyoyo==null){

      contentsStopReaseonRyoyo = new ACRadioButtonItem();

      contentsStopReaseonRyoyo.setText("8.���×{�^��Î{�ݓ��@");

      contentsStopReaseonRyoyo.setGroup(getContentsStopReasons());

      contentsStopReaseonRyoyo.setConstraints(VRLayout.FLOW);

      addContentsStopReaseonRyoyo();
    }
    return contentsStopReaseonRyoyo;

  }

  /**
   * 9.����É@�������擾���܂��B
   * @return 9.����É@����
   */
  public ACRadioButtonItem getContentsStopReaseonIryoin(){
    if(contentsStopReaseonIryoin==null){

      contentsStopReaseonIryoin = new ACRadioButtonItem();

      contentsStopReaseonIryoin.setText("9.����É@����");

      contentsStopReaseonIryoin.setGroup(getContentsStopReasons());

      contentsStopReaseonIryoin.setConstraints(VRLayout.FLOW);

      addContentsStopReaseonIryoin();
    }
    return contentsStopReaseonIryoin;

  }

  /**
   * �{�݌n�ٓ������擾���܂��B
   * @return �{�݌n�ٓ����
   */
  public ACGroupBox getShisetsuIdouGroup(){
    if(shisetsuIdouGroup==null){

      shisetsuIdouGroup = new ACGroupBox();

      shisetsuIdouGroup.setText("�ٓ����");

      shisetsuIdouGroup.setAutoWrap(true);

      shisetsuIdouGroup.setFollowChildEnabled(true);

      shisetsuIdouGroup.setHgrid(200);

      addShisetsuIdouGroup();
    }
    return shisetsuIdouGroup;

  }

  /**
   * ����(�@)�N�������擾���܂��B
   * @return ����(�@)�N����
   */
  public QkanDateTextField getContentsNyushoDate(){
    if(contentsNyushoDate==null){

      contentsNyushoDate = new QkanDateTextField();

      getContentsNyushoDateContainer().setText("�����i�@�E���j�N����");

      contentsNyushoDate.setBindPath("201024");

      addContentsNyushoDate();
    }
    return contentsNyushoDate;

  }

  /**
   * ����(�@)�N�����R���e�i���擾���܂��B
   * @return ����(�@)�N�����R���e�i
   */
  protected ACLabelContainer getContentsNyushoDateContainer(){
    if(contentsNyushoDateContainer==null){
      contentsNyushoDateContainer = new ACLabelContainer();
      contentsNyushoDateContainer.setFollowChildEnabled(true);
      contentsNyushoDateContainer.setVAlignment(VRLayout.CENTER);
      contentsNyushoDateContainer.add(getContentsNyushoDate(), null);
    }
    return contentsNyushoDateContainer;
  }

  /**
   * �ޏ�(�@)�N�������擾���܂��B
   * @return �ޏ�(�@)�N����
   */
  public QkanDateTextField getContentsTaishoDate(){
    if(contentsTaishoDate==null){

      contentsTaishoDate = new QkanDateTextField();

      getContentsTaishoDateContainer().setText("�ޏ��i�@�E���j�N����");

      contentsTaishoDate.setBindPath("201025");

      addContentsTaishoDate();
    }
    return contentsTaishoDate;

  }

  /**
   * �ޏ�(�@)�N�����R���e�i���擾���܂��B
   * @return �ޏ�(�@)�N�����R���e�i
   */
  protected ACLabelContainer getContentsTaishoDateContainer(){
    if(contentsTaishoDateContainer==null){
      contentsTaishoDateContainer = new ACLabelContainer();
      contentsTaishoDateContainer.setFollowChildEnabled(true);
      contentsTaishoDateContainer.setVAlignment(VRLayout.CENTER);
      contentsTaishoDateContainer.add(getContentsTaishoDate(), null);
    }
    return contentsTaishoDateContainer;
  }

  /**
   * ����(�@)���������擾���܂��B
   * @return ����(�@)������
   */
  public ACTextField getContentsNyushoDays(){
    if(contentsNyushoDays==null){

      contentsNyushoDays = new ACTextField();

      getContentsNyushoDaysContainer().setText("����(�@�E��)������");

      contentsNyushoDays.setBindPath("201026");

      contentsNyushoDays.setColumns(5);

      contentsNyushoDays.setCharType(VRCharType.ONLY_DIGIT);

      contentsNyushoDays.setHorizontalAlignment(SwingConstants.RIGHT);

      contentsNyushoDays.setIMEMode(InputSubset.LATIN);

      contentsNyushoDays.setMaxLength(3);

      addContentsNyushoDays();
    }
    return contentsNyushoDays;

  }

  /**
   * ����(�@)�������R���e�i���擾���܂��B
   * @return ����(�@)�������R���e�i
   */
  protected ACLabelContainer getContentsNyushoDaysContainer(){
    if(contentsNyushoDaysContainer==null){
      contentsNyushoDaysContainer = new ACLabelContainer();
      contentsNyushoDaysContainer.setFollowChildEnabled(true);
      contentsNyushoDaysContainer.setVAlignment(VRLayout.CENTER);
      contentsNyushoDaysContainer.add(getContentsNyushoDays(), null);
    }
    return contentsNyushoDaysContainer;
  }

  /**
   * �������������擾���܂��B
   * @return ����������
   */
  public ACTextField getContentsTankiNyushoDays(){
    if(contentsTankiNyushoDays==null){

      contentsTankiNyushoDays = new ACTextField();

      getContentsTankiNyushoDaysContainer().setText("����������");

      contentsTankiNyushoDays.setBindPath("701008");

      contentsTankiNyushoDays.setColumns(5);

      contentsTankiNyushoDays.setCharType(VRCharType.ONLY_DIGIT);

      contentsTankiNyushoDays.setHorizontalAlignment(SwingConstants.RIGHT);

      contentsTankiNyushoDays.setIMEMode(InputSubset.LATIN);

      contentsTankiNyushoDays.setMaxLength(3);

      addContentsTankiNyushoDays();
    }
    return contentsTankiNyushoDays;

  }

  /**
   * �����������R���e�i���擾���܂��B
   * @return �����������R���e�i
   */
  protected ACLabelContainer getContentsTankiNyushoDaysContainer(){
    if(contentsTankiNyushoDaysContainer==null){
      contentsTankiNyushoDaysContainer = new ACLabelContainer();
      contentsTankiNyushoDaysContainer.setFollowChildEnabled(true);
      contentsTankiNyushoDaysContainer.setVAlignment(VRLayout.CENTER);
      contentsTankiNyushoDaysContainer.add(getContentsTankiNyushoDays(), null);
    }
    return contentsTankiNyushoDaysContainer;
  }

  /**
   * �O���������擾���܂��B
   * @return �O������
   */
  public ACTextField getContentsGaihakuDays(){
    if(contentsGaihakuDays==null){

      contentsGaihakuDays = new ACTextField();

      getContentsGaihakuDaysContainer().setText("�O������");

      contentsGaihakuDays.setBindPath("201027");

      contentsGaihakuDays.setColumns(5);

      contentsGaihakuDays.setCharType(VRCharType.ONLY_DIGIT);

      contentsGaihakuDays.setHorizontalAlignment(SwingConstants.RIGHT);

      contentsGaihakuDays.setIMEMode(InputSubset.LATIN);

      contentsGaihakuDays.setMaxLength(3);

      addContentsGaihakuDays();
    }
    return contentsGaihakuDays;

  }

  /**
   * �O�������R���e�i���擾���܂��B
   * @return �O�������R���e�i
   */
  protected ACLabelContainer getContentsGaihakuDaysContainer(){
    if(contentsGaihakuDaysContainer==null){
      contentsGaihakuDaysContainer = new ACLabelContainer();
      contentsGaihakuDaysContainer.setFollowChildEnabled(true);
      contentsGaihakuDaysContainer.setVAlignment(VRLayout.CENTER);
      contentsGaihakuDaysContainer.add(getContentsGaihakuDays(), null);
    }
    return contentsGaihakuDaysContainer;
  }

  /**
   * �����i�@�j�O�̏󋵃R�[�h���擾���܂��B
   * @return �����i�@�j�O�̏󋵃R�[�h
   */
  public ACValueArrayRadioButtonGroup getContentsNyushoJotais(){
    if(contentsNyushoJotais==null){

      contentsNyushoJotais = new ACValueArrayRadioButtonGroup();

      getContentsNyushoJotaisContainer().setText("�����i�@�j�O�̏󋵃R�[�h");

      contentsNyushoJotais.setBindPath("201023");

      contentsNyushoJotais.setUseClearButton(false);

      contentsNyushoJotais.setModel(getContentsNyushoJotaisModel());

      contentsNyushoJotais.setValues(new int[]{1,2,3,4,5,6,7,8,9});

      addContentsNyushoJotais();
    }
    return contentsNyushoJotais;

  }

  /**
   * �����i�@�j�O�̏󋵃R�[�h�R���e�i���擾���܂��B
   * @return �����i�@�j�O�̏󋵃R�[�h�R���e�i
   */
  protected ACLabelContainer getContentsNyushoJotaisContainer(){
    if(contentsNyushoJotaisContainer==null){
      contentsNyushoJotaisContainer = new ACLabelContainer();
      contentsNyushoJotaisContainer.setFollowChildEnabled(true);
      contentsNyushoJotaisContainer.setVAlignment(VRLayout.CENTER);
      contentsNyushoJotaisContainer.add(getContentsNyushoJotais(), null);
    }
    return contentsNyushoJotaisContainer;
  }

  /**
   * �����i�@�j�O�̏󋵃R�[�h���f�����擾���܂��B
   * @return �����i�@�j�O�̏󋵃R�[�h���f��
   */
  protected ACListModelAdapter getContentsNyushoJotaisModel(){
    if(contentsNyushoJotaisModel==null){
      contentsNyushoJotaisModel = new ACListModelAdapter();
      addContentsNyushoJotaisModel();
    }
    return contentsNyushoJotaisModel;
  }

  /**
   * 1.������擾���܂��B
   * @return 1.����
   */
  public ACRadioButtonItem getContentsNyushoZaitaku(){
    if(contentsNyushoZaitaku==null){

      contentsNyushoZaitaku = new ACRadioButtonItem();

      contentsNyushoZaitaku.setText("1.����");

      contentsNyushoZaitaku.setGroup(getContentsNyushoJotais());

      contentsNyushoZaitaku.setConstraints(VRLayout.FLOW);

      addContentsNyushoZaitaku();
    }
    return contentsNyushoZaitaku;

  }

  /**
   * 2.��Ë@�ւ��擾���܂��B
   * @return 2.��Ë@��
   */
  public ACRadioButtonItem getContentsNyushoIryo(){
    if(contentsNyushoIryo==null){

      contentsNyushoIryo = new ACRadioButtonItem();

      contentsNyushoIryo.setText("2.��Ë@��");

      contentsNyushoIryo.setGroup(getContentsNyushoJotais());

      contentsNyushoIryo.setConstraints(VRLayout.FLOW);

      addContentsNyushoIryo();
    }
    return contentsNyushoIryo;

  }

  /**
   * 3.���V�l�����{�݂��擾���܂��B
   * @return 3.���V�l�����{��
   */
  public ACRadioButtonItem getContentsNyushoFukushi(){
    if(contentsNyushoFukushi==null){

      contentsNyushoFukushi = new ACRadioButtonItem();

      contentsNyushoFukushi.setText("3.���V�l�����{��");

      contentsNyushoFukushi.setGroup(getContentsNyushoJotais());

      contentsNyushoFukushi.setConstraints(VRLayout.FLOW);

      addContentsNyushoFukushi();
    }
    return contentsNyushoFukushi;

  }

  /**
   * 4.���V�l�ی��{�݂��擾���܂��B
   * @return 4.���V�l�ی��{��
   */
  public ACRadioButtonItem getContentsNyushoHoken(){
    if(contentsNyushoHoken==null){

      contentsNyushoHoken = new ACRadioButtonItem();

      contentsNyushoHoken.setText("4.���V�l�ی��{��");

      contentsNyushoHoken.setGroup(getContentsNyushoJotais());

      contentsNyushoHoken.setConstraints(VRLayout.FLOW_RETURN);

      addContentsNyushoHoken();
    }
    return contentsNyushoHoken;

  }

  /**
   * 5.���×{�^��Î{�݂��擾���܂��B
   * @return 5.���×{�^��Î{��
   */
  public ACRadioButtonItem getContentsNyushoRyoyo(){
    if(contentsNyushoRyoyo==null){

      contentsNyushoRyoyo = new ACRadioButtonItem();

      contentsNyushoRyoyo.setText("5.���×{�^��Î{��");

      contentsNyushoRyoyo.setGroup(getContentsNyushoJotais());

      contentsNyushoRyoyo.setConstraints(VRLayout.FLOW);

      addContentsNyushoRyoyo();
    }
    return contentsNyushoRyoyo;

  }

  /**
   * 6.�F�m�ǑΉ��^�������������擾���܂��B
   * @return 6.�F�m�ǑΉ��^�����������
   */
  public ACRadioButtonItem getContentsNyushoNinchi(){
    if(contentsNyushoNinchi==null){

      contentsNyushoNinchi = new ACRadioButtonItem();

      contentsNyushoNinchi.setText("6.�F�m�ǑΉ��^�����������");

      contentsNyushoNinchi.setGroup(getContentsNyushoJotais());

      contentsNyushoNinchi.setConstraints(VRLayout.FLOW);

      addContentsNyushoNinchi();
    }
    return contentsNyushoNinchi;

  }

  /**
   * 7.����{�ݓ����Ґ��������擾���܂��B
   * @return 7.����{�ݓ����Ґ������
   */
  public ACRadioButtonItem getContentsNyushoTokutei(){
    if(contentsNyushoTokutei==null){

      contentsNyushoTokutei = new ACRadioButtonItem();

      contentsNyushoTokutei.setText("7.����{�ݓ����Ґ������");

      contentsNyushoTokutei.setGroup(getContentsNyushoJotais());

      contentsNyushoTokutei.setConstraints(VRLayout.FLOW);

      addContentsNyushoTokutei();
    }
    return contentsNyushoTokutei;

  }

  /**
   * 8.���̑����擾���܂��B
   * @return 8.���̑�
   */
  public ACRadioButtonItem getContentsNyushoEtc(){
    if(contentsNyushoEtc==null){

      contentsNyushoEtc = new ACRadioButtonItem();

      contentsNyushoEtc.setText("8.���̑�");

      contentsNyushoEtc.setGroup(getContentsNyushoJotais());

      contentsNyushoEtc.setConstraints(VRLayout.FLOW);

      addContentsNyushoEtc();
    }
    return contentsNyushoEtc;

  }

  /**
   * 9.����É@���擾���܂��B
   * @return 9.����É@
   */
  public ACRadioButtonItem getContentsNyushoIryoin(){
    if(contentsNyushoIryoin==null){

      contentsNyushoIryoin = new ACRadioButtonItem();

      contentsNyushoIryoin.setText("9.����É@");

      contentsNyushoIryoin.setGroup(getContentsNyushoJotais());

      contentsNyushoIryoin.setConstraints(VRLayout.FLOW);

      addContentsNyushoIryoin();
    }
    return contentsNyushoIryoin;

  }

  /**
   * �ޏ�(�@)��̏�ԃR�[�h���擾���܂��B
   * @return �ޏ�(�@)��̏�ԃR�[�h
   */
  public ACValueArrayRadioButtonGroup getContentsTaishoJotais(){
    if(contentsTaishoJotais==null){

      contentsTaishoJotais = new ACValueArrayRadioButtonGroup();

      getContentsTaishoJotaisContainer().setText("�ޏ��i�@�E���j��̏�ԃR�[�h");

      contentsTaishoJotais.setBindPath("201028");

      contentsTaishoJotais.setNoSelectIndex(0);

      contentsTaishoJotais.setUseClearButton(true);

      contentsTaishoJotais.setModel(getContentsTaishoJotaisModel());

      contentsTaishoJotais.setValues(new int[]{1,3,4,5,6,7,8,9});

      addContentsTaishoJotais();
    }
    return contentsTaishoJotais;

  }

  /**
   * �ޏ�(�@)��̏�ԃR�[�h�R���e�i���擾���܂��B
   * @return �ޏ�(�@)��̏�ԃR�[�h�R���e�i
   */
  protected ACLabelContainer getContentsTaishoJotaisContainer(){
    if(contentsTaishoJotaisContainer==null){
      contentsTaishoJotaisContainer = new ACLabelContainer();
      contentsTaishoJotaisContainer.setFollowChildEnabled(true);
      contentsTaishoJotaisContainer.setVAlignment(VRLayout.CENTER);
      contentsTaishoJotaisContainer.add(getContentsTaishoJotais(), null);
    }
    return contentsTaishoJotaisContainer;
  }

  /**
   * �ޏ�(�@)��̏�ԃR�[�h���f�����擾���܂��B
   * @return �ޏ�(�@)��̏�ԃR�[�h���f��
   */
  protected ACListModelAdapter getContentsTaishoJotaisModel(){
    if(contentsTaishoJotaisModel==null){
      contentsTaishoJotaisModel = new ACListModelAdapter();
      addContentsTaishoJotaisModel();
    }
    return contentsTaishoJotaisModel;
  }

  /**
   * 1.������擾���܂��B
   * @return 1.����
   */
  public ACRadioButtonItem getContentsTaishoJotaiZaitaku(){
    if(contentsTaishoJotaiZaitaku==null){

      contentsTaishoJotaiZaitaku = new ACRadioButtonItem();

      contentsTaishoJotaiZaitaku.setText("1.����");

      contentsTaishoJotaiZaitaku.setGroup(getContentsTaishoJotais());

      contentsTaishoJotaiZaitaku.setConstraints(VRLayout.FLOW);

      addContentsTaishoJotaiZaitaku();
    }
    return contentsTaishoJotaiZaitaku;

  }

  /**
   * 3.��Ë@�֓��@���擾���܂��B
   * @return 3.��Ë@�֓��@
   */
  public ACRadioButtonItem getContentsTaishoJotaiNyuin(){
    if(contentsTaishoJotaiNyuin==null){

      contentsTaishoJotaiNyuin = new ACRadioButtonItem();

      contentsTaishoJotaiNyuin.setText("3.��Ë@�֓��@");

      contentsTaishoJotaiNyuin.setGroup(getContentsTaishoJotais());

      contentsTaishoJotaiNyuin.setConstraints(VRLayout.FLOW);

      addContentsTaishoJotaiNyuin();
    }
    return contentsTaishoJotaiNyuin;

  }

  /**
   * 4.���S���擾���܂��B
   * @return 4.���S
   */
  public ACRadioButtonItem getContentsTaishoJotaiDeath(){
    if(contentsTaishoJotaiDeath==null){

      contentsTaishoJotaiDeath = new ACRadioButtonItem();

      contentsTaishoJotaiDeath.setText("4.���S");

      contentsTaishoJotaiDeath.setGroup(getContentsTaishoJotais());

      contentsTaishoJotaiDeath.setConstraints(VRLayout.FLOW);

      addContentsTaishoJotaiDeath();
    }
    return contentsTaishoJotaiDeath;

  }

  /**
   * 5.���̑����擾���܂��B
   * @return 5.���̑�
   */
  public ACRadioButtonItem getContentsTaishoJotaiEtc(){
    if(contentsTaishoJotaiEtc==null){

      contentsTaishoJotaiEtc = new ACRadioButtonItem();

      contentsTaishoJotaiEtc.setText("5.���̑�");

      contentsTaishoJotaiEtc.setGroup(getContentsTaishoJotais());

      contentsTaishoJotaiEtc.setConstraints(VRLayout.FLOW_RETURN);

      addContentsTaishoJotaiEtc();
    }
    return contentsTaishoJotaiEtc;

  }

  /**
   * 6.���V�l�����{�ݓ������擾���܂��B
   * @return 6.���V�l�����{�ݓ���
   */
  public ACRadioButtonItem getContentsTaishoJotaiTokuyo(){
    if(contentsTaishoJotaiTokuyo==null){

      contentsTaishoJotaiTokuyo = new ACRadioButtonItem();

      contentsTaishoJotaiTokuyo.setText("6.���V�l�����{�ݓ���");

      contentsTaishoJotaiTokuyo.setGroup(getContentsTaishoJotais());

      contentsTaishoJotaiTokuyo.setConstraints(VRLayout.FLOW);

      addContentsTaishoJotaiTokuyo();
    }
    return contentsTaishoJotaiTokuyo;

  }

  /**
   * 7.���V�l�ی��{�ݓ������擾���܂��B
   * @return 7.���V�l�ی��{�ݓ���
   */
  public ACRadioButtonItem getContentsTaishoJotaiRouken(){
    if(contentsTaishoJotaiRouken==null){

      contentsTaishoJotaiRouken = new ACRadioButtonItem();

      contentsTaishoJotaiRouken.setText("7.���V�l�ی��{�ݓ���");

      contentsTaishoJotaiRouken.setGroup(getContentsTaishoJotais());

      contentsTaishoJotaiRouken.setConstraints(VRLayout.FLOW);

      addContentsTaishoJotaiRouken();
    }
    return contentsTaishoJotaiRouken;

  }

  /**
   * 8.���×{�^��Î{�ݓ��@���擾���܂��B
   * @return 8.���×{�^��Î{�ݓ��@
   */
  public ACRadioButtonItem getContentsTaishoJotaiRyoyo(){
    if(contentsTaishoJotaiRyoyo==null){

      contentsTaishoJotaiRyoyo = new ACRadioButtonItem();

      contentsTaishoJotaiRyoyo.setText("8.���×{�^��Î{�ݓ��@");

      contentsTaishoJotaiRyoyo.setGroup(getContentsTaishoJotais());

      contentsTaishoJotaiRyoyo.setConstraints(VRLayout.FLOW);

      addContentsTaishoJotaiRyoyo();
    }
    return contentsTaishoJotaiRyoyo;

  }

  /**
   * 9.����É@�������擾���܂��B
   * @return 9.����É@����
   */
  public ACRadioButtonItem getContentsTaishoJotaiIryoin(){
    if(contentsTaishoJotaiIryoin==null){

      contentsTaishoJotaiIryoin = new ACRadioButtonItem();

      contentsTaishoJotaiIryoin.setText("9.����É@����");

      contentsTaishoJotaiIryoin.setGroup(getContentsTaishoJotais());

      contentsTaishoJotaiIryoin.setConstraints(VRLayout.FLOW);

      addContentsTaishoJotaiIryoin();
    }
    return contentsTaishoJotaiIryoin;

  }

  /**
   * �E�v���ҏW�̈���擾���܂��B
   * @return �E�v���ҏW�̈�
   */
  public ACPanel getEditTekiyoPanel(){
    if(editTekiyoPanel==null){

      editTekiyoPanel = new ACPanel();

      addEditTekiyoPanel();
    }
    return editTekiyoPanel;

  }

  /**
   * ��{�E�v�\���̈���擾���܂��B
   * @return ��{�E�v�\���̈�
   */
  public ACGroupBox getBaseSummaryArea(){
    if(baseSummaryArea==null){

      baseSummaryArea = new ACGroupBox();

      baseSummaryArea.setText("��{�E�v");

      addBaseSummaryArea();
    }
    return baseSummaryArea;

  }

  /**
   * ��{�E�v�R�����g���擾���܂��B
   * @return ��{�E�v�R�����g
   */
  public ACTextField getBaseSummaryText(){
    if(baseSummaryText==null){

      baseSummaryText = new ACTextField();

      baseSummaryText.setBindPath("BASE_SUMMARY_MEMO");

      baseSummaryText.setEditable(false);

      addBaseSummaryText();
    }
    return baseSummaryText;

  }

  /**
   * ��{�E�v�ꗗ���擾���܂��B
   * @return ��{�E�v�ꗗ
   */
  public ACTable getBaseSummaryTable(){
    if(baseSummaryTable==null){

      baseSummaryTable = new ACTable();

      baseSummaryTable.setColumnModel(getBaseSummaryTableColumnModel());

      baseSummaryTable.setColumnSort(false);

      addBaseSummaryTable();
    }
    return baseSummaryTable;

  }

  /**
   * ��{�E�v�ꗗ�J�������f�����擾���܂��B
   * @return ��{�E�v�ꗗ�J�������f��
   */
  protected VRTableColumnModel getBaseSummaryTableColumnModel(){
    if(baseSummaryTableColumnModel==null){
      baseSummaryTableColumnModel = new VRTableColumnModel(new TableColumn[]{});
      addBaseSummaryTableColumnModel();
    }
    return baseSummaryTableColumnModel;
  }

  /**
   * No.���擾���܂��B
   * @return No.
   */
  public ACTableColumn getBaseSummaryNoColumn(){
    if(baseSummaryNoColumn==null){

      baseSummaryNoColumn = new ACTableColumn(0, 40);

      baseSummaryNoColumn.setHeaderValue("No.");

      baseSummaryNoColumn.setColumns(4);

      baseSummaryNoColumn.setRendererType(ACTableCellViewer.RENDERER_TYPE_SERIAL_NO);

      baseSummaryNoColumn.setSortable(false);

      addBaseSummaryNoColumn();
    }
    return baseSummaryNoColumn;

  }

  /**
   * �E�v��ʃR�[�h���擾���܂��B
   * @return �E�v��ʃR�[�h
   */
  public ACTableColumn getBaseSummaryKindCodeColumn(){
    if(baseSummaryKindCodeColumn==null){

      baseSummaryKindCodeColumn = new ACTableColumn(0, 100);

      baseSummaryKindCodeColumn.setHeaderValue("�E�v��ʃR�[�h");

      baseSummaryKindCodeColumn.setColumns(9);

      addBaseSummaryKindCodeColumn();
    }
    return baseSummaryKindCodeColumn;

  }

  /**
   * ���̂��擾���܂��B
   * @return ����
   */
  public ACTableColumn getBaseSummaryNameColumn(){
    if(baseSummaryNameColumn==null){

      baseSummaryNameColumn = new ACTableColumn(1);

      baseSummaryNameColumn.setHeaderValue("����");

      baseSummaryNameColumn.setColumns(20);

      addBaseSummaryNameColumn();
    }
    return baseSummaryNameColumn;

  }

  /**
   * �E�v���e���擾���܂��B
   * @return �E�v���e
   */
  public ACTableColumn getBaseSummaryNaiyoColumn(){
    if(baseSummaryNaiyoColumn==null){

      baseSummaryNaiyoColumn = new ACTableColumn(2, 400);

      baseSummaryNaiyoColumn.setHeaderValue("�E�v���e");

      baseSummaryNaiyoColumn.setEditable(true);

      addBaseSummaryNaiyoColumn();
    }
    return baseSummaryNaiyoColumn;

  }

  /**
   * �E�v���L�ڎ����\���̈���擾���܂��B
   * @return �E�v���L�ڎ����\���̈�
   */
  public ACGroupBox getTekiyos(){
    if(tekiyos==null){

      tekiyos = new ACGroupBox();

      tekiyos.setText("�E�v���L�ڎ���");

      addTekiyos();
    }
    return tekiyos;

  }

  /**
   * �E�v���L�ڎ����R�����g���擾���܂��B
   * @return �E�v���L�ڎ����R�����g
   */
  public ACTextField getTekiyoText(){
    if(tekiyoText==null){

      tekiyoText = new ACTextField();

      tekiyoText.setBindPath("DETAIL_SUMMARY_MEMO");

      tekiyoText.setEditable(false);

      addTekiyoText();
    }
    return tekiyoText;

  }

  /**
   * �E�v���L�ڎ����ꗗ���擾���܂��B
   * @return �E�v���L�ڎ����ꗗ
   */
  public ACTable getTekiyoTable(){
    if(tekiyoTable==null){

      tekiyoTable = new ACTable();

      tekiyoTable.setColumnModel(getTekiyoTableColumnModel());

      tekiyoTable.setColumnSort(false);

      addTekiyoTable();
    }
    return tekiyoTable;

  }

  /**
   * �E�v���L�ڎ����ꗗ�J�������f�����擾���܂��B
   * @return �E�v���L�ڎ����ꗗ�J�������f��
   */
  protected VRTableColumnModel getTekiyoTableColumnModel(){
    if(tekiyoTableColumnModel==null){
      tekiyoTableColumnModel = new VRTableColumnModel(new TableColumn[]{});
      addTekiyoTableColumnModel();
    }
    return tekiyoTableColumnModel;
  }

  /**
   * No.���擾���܂��B
   * @return No.
   */
  public ACTableColumn getTekiyoNoColumn(){
    if(tekiyoNoColumn==null){

      tekiyoNoColumn = new ACTableColumn(0, 40);

      tekiyoNoColumn.setHeaderValue("No.");

      tekiyoNoColumn.setColumns(4);

      tekiyoNoColumn.setRendererType(ACTableCellViewer.RENDERER_TYPE_SERIAL_NO);

      tekiyoNoColumn.setSortable(false);

      addTekiyoNoColumn();
    }
    return tekiyoNoColumn;

  }

  /**
   * �T�[�r�X�R�[�h���擾���܂��B
   * @return �T�[�r�X�R�[�h
   */
  public ACTableColumn getTekiyoServiceCodeColumn(){
    if(tekiyoServiceCodeColumn==null){

      tekiyoServiceCodeColumn = new ACTableColumn(0, 100);

      tekiyoServiceCodeColumn.setHeaderValue("�T�[�r�X�R�[�h");

      tekiyoServiceCodeColumn.setColumns(9);

      addTekiyoServiceCodeColumn();
    }
    return tekiyoServiceCodeColumn;

  }

  /**
   * �T�[�r�X���̂��擾���܂��B
   * @return �T�[�r�X����
   */
  public ACTableColumn getTekiyoServiceNameColumn(){
    if(tekiyoServiceNameColumn==null){

      tekiyoServiceNameColumn = new ACTableColumn(1, 200);

      tekiyoServiceNameColumn.setHeaderValue("�T�[�r�X����");

      tekiyoServiceNameColumn.setColumns(20);

      addTekiyoServiceNameColumn();
    }
    return tekiyoServiceNameColumn;

  }

  /**
   * �񐔂��擾���܂��B
   * @return ��
   */
  public ACTableColumn getTekiyoTimesColumn(){
    if(tekiyoTimesColumn==null){

      tekiyoTimesColumn = new ACTableColumn(2);

      tekiyoTimesColumn.setHeaderValue("��");

      tekiyoTimesColumn.setColumns(4);

      tekiyoTimesColumn.setHorizontalAlignment(SwingConstants.RIGHT);

      addTekiyoTimesColumn();
    }
    return tekiyoTimesColumn;

  }

  /**
   * �P�ʐ����擾���܂��B
   * @return �P�ʐ�
   */
  public ACTableColumn getTekiyoServiceUnitColumn(){
    if(tekiyoServiceUnitColumn==null){

      tekiyoServiceUnitColumn = new ACTableColumn(3);

      tekiyoServiceUnitColumn.setHeaderValue("�P�ʐ�");

      tekiyoServiceUnitColumn.setColumns(6);

      tekiyoServiceUnitColumn.setHorizontalAlignment(SwingConstants.RIGHT);

      addTekiyoServiceUnitColumn();
    }
    return tekiyoServiceUnitColumn;

  }

  /**
   * �E�v���擾���܂��B
   * @return �E�v
   */
  public ACTableColumn getTekiyoTekiyoColumn(){
    if(tekiyoTekiyoColumn==null){

      tekiyoTekiyoColumn = new ACTableColumn(4, 400);

      tekiyoTekiyoColumn.setHeaderValue("�E�v");

      tekiyoTekiyoColumn.setEditable(true);

      addTekiyoTekiyoColumn();
    }
    return tekiyoTekiyoColumn;

  }

  /**
   * ����f�Ô�\���̈���擾���܂��B
   * @return ����f�Ô�\���̈�
   */
  public ACGroupBox getShinryos(){
    if(shinryos==null){

      shinryos = new ACGroupBox();

      shinryos.setText("����f�Ô�");

      addShinryos();
    }
    return shinryos;

  }

  /**
   * ���a�����擾���܂��B
   * @return ���a��
   */
  public ACTextField getShinryoDeseaseText(){
    if(shinryoDeseaseText==null){

      shinryoDeseaseText = new ACTextField();

      getShinryoDeseaseTextContainer().setText("���a��");

      shinryoDeseaseText.setBindPath("501008");

      shinryoDeseaseText.setConvertToCharacter(ACCharacterConverter.TO_WIDE_CHAR);

      shinryoDeseaseText.setIMEMode(InputSubset.KANJI);

      shinryoDeseaseText.setMaxLength(50);

      addShinryoDeseaseText();
    }
    return shinryoDeseaseText;

  }

  /**
   * ���a���R���e�i���擾���܂��B
   * @return ���a���R���e�i
   */
  protected ACLabelContainer getShinryoDeseaseTextContainer(){
    if(shinryoDeseaseTextContainer==null){
      shinryoDeseaseTextContainer = new ACLabelContainer();
      shinryoDeseaseTextContainer.setFollowChildEnabled(true);
      shinryoDeseaseTextContainer.setVAlignment(VRLayout.CENTER);
      shinryoDeseaseTextContainer.add(getShinryoDeseaseText(), VRLayout.CLIENT);
    }
    return shinryoDeseaseTextContainer;
  }

  /**
   * ����f�Ô�R�����g���擾���܂��B
   * @return ����f�Ô�R�����g
   */
  public ACTextField getShinryoText(){
    if(shinryoText==null){

      shinryoText = new ACTextField();

      shinryoText.setBindPath("SPECIAL_CLINIC_SUMMARY_MEMO");

      shinryoText.setEditable(false);

      addShinryoText();
    }
    return shinryoText;

  }

  /**
   * ����f�Ô�ꗗ���擾���܂��B
   * @return ����f�Ô�ꗗ
   */
  public ACTable getSinryoTable(){
    if(sinryoTable==null){

      sinryoTable = new ACTable();

      sinryoTable.setColumnModel(getSinryoTableColumnModel());

      sinryoTable.setColumnSort(false);

      sinryoTable.setPreferredSize(new Dimension(100,100));

      addSinryoTable();
    }
    return sinryoTable;

  }

  /**
   * ����f�Ô�ꗗ�J�������f�����擾���܂��B
   * @return ����f�Ô�ꗗ�J�������f��
   */
  protected VRTableColumnModel getSinryoTableColumnModel(){
    if(sinryoTableColumnModel==null){
      sinryoTableColumnModel = new VRTableColumnModel(new TableColumn[]{});
      addSinryoTableColumnModel();
    }
    return sinryoTableColumnModel;
  }

  /**
   * No.���擾���܂��B
   * @return No.
   */
  public ACTableColumn getSinryoNoColumn(){
    if(sinryoNoColumn==null){

      sinryoNoColumn = new ACTableColumn(0, 40);

      sinryoNoColumn.setHeaderValue("No.");

      sinryoNoColumn.setColumns(4);

      sinryoNoColumn.setRendererType(ACTableCellViewer.RENDERER_TYPE_SERIAL_NO);

      sinryoNoColumn.setSortable(false);

      addSinryoNoColumn();
    }
    return sinryoNoColumn;

  }

  /**
   * ���ʔԍ����擾���܂��B
   * @return ���ʔԍ�
   */
  public ACTableColumn getSinryoShikibetsuColumn(){
    if(sinryoShikibetsuColumn==null){

      sinryoShikibetsuColumn = new ACTableColumn(0, 100);

      sinryoShikibetsuColumn.setHeaderValue("���ʔԍ�");

      sinryoShikibetsuColumn.setColumns(6);

      addSinryoShikibetsuColumn();
    }
    return sinryoShikibetsuColumn;

  }

  /**
   * ���̂��擾���܂��B
   * @return ����
   */
  public ACTableColumn getSinryoNameColumn(){
    if(sinryoNameColumn==null){

      sinryoNameColumn = new ACTableColumn(1, 200);

      sinryoNameColumn.setHeaderValue("����");

      sinryoNameColumn.setColumns(20);

      addSinryoNameColumn();
    }
    return sinryoNameColumn;

  }

  /**
   * �񐔂��擾���܂��B
   * @return ��
   */
  public ACTableColumn getSinryoTimesColumn(){
    if(sinryoTimesColumn==null){

      sinryoTimesColumn = new ACTableColumn(2);

      sinryoTimesColumn.setHeaderValue("��");

      sinryoTimesColumn.setColumns(4);

      sinryoTimesColumn.setHorizontalAlignment(SwingConstants.RIGHT);

      addSinryoTimesColumn();
    }
    return sinryoTimesColumn;

  }

  /**
   * �P�ʐ����擾���܂��B
   * @return �P�ʐ�
   */
  public ACTableColumn getSinryoUnitColumn(){
    if(sinryoUnitColumn==null){

      sinryoUnitColumn = new ACTableColumn(3);

      sinryoUnitColumn.setHeaderValue("�P�ʐ�");

      sinryoUnitColumn.setColumns(6);

      sinryoUnitColumn.setHorizontalAlignment(SwingConstants.RIGHT);

      addSinryoUnitColumn();
    }
    return sinryoUnitColumn;

  }

  /**
   * �E�v���擾���܂��B
   * @return �E�v
   */
  public ACTableColumn getSinryoTekiyoColumn(){
    if(sinryoTekiyoColumn==null){

      sinryoTekiyoColumn = new ACTableColumn(4, 400);

      sinryoTekiyoColumn.setHeaderValue("�E�v");

      sinryoTekiyoColumn.setEditable(true);

      sinryoTekiyoColumn.setEditorType(VRTableCellViewer.EDITOR_TYPE_TEXT_FIELD);

      addSinryoTekiyoColumn();
    }
    return sinryoTekiyoColumn;

  }

  /**
   * �R���X�g���N�^�ł��B
   */
  public QP004Design() {

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

    this.add(getContents(), VRLayout.NORTH);

    this.add(getEditTekiyoPanel(), VRLayout.CLIENT);

  }

  /**
   * �{�^���o�[�ɓ������ڂ�ǉ����܂��B
   */
  protected void addButtons(){

    buttons.add(getUpdate(), VRLayout.EAST);
    buttons.add(getDetail(), VRLayout.EAST);
    buttons.add(getTekiyoHelp(), VRLayout.EAST);
  }

  /**
   * �E�v�\���{�^��(H)�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTekiyoHelp(){

  }

  /**
   * �ڍ׃{�^��(E)�ɓ������ڂ�ǉ����܂��B
   */
  protected void addDetail(){

  }

  /**
   * �X�V�{�^��(S)�ɓ������ڂ�ǉ����܂��B
   */
  protected void addUpdate(){

  }

  /**
   * �N���C�A���g�̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addContents(){

    contents.add(getPatientNames(), VRLayout.NORTH);

    contents.add(getKyotakuIdouGroup(), VRLayout.NORTH);

    contents.add(getShisetsuIdouGroup(), VRLayout.NORTH);

  }

  /**
   * ���p�Җ��̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatientNames(){

    patientNames.add(getPatinetNameLabel(), VRLayout.FLOW);

    patientNames.add(getPatientName(), VRLayout.FLOW);

    patientNames.add(getPatientNoLabel1(), VRLayout.FLOW);

    patientNames.add(getPatientNo(), VRLayout.FLOW);

    patientNames.add(getPatientNoLabel2(), VRLayout.FLOW);

  }

  /**
   * ���p�Җ��E���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatinetNameLabel(){

  }

  /**
   * ���p�Җ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatientName(){

  }

  /**
   * ���p�҃R�[�h�E���x��1�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatientNoLabel1(){

  }

  /**
   * ���p�҃R�[�h�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatientNo(){

  }

  /**
   * ���p�҃R�[�h�E���x��2�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatientNoLabel2(){

  }

  /**
   * ����n�ٓ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addKyotakuIdouGroup(){

    kyotakuIdouGroup.add(getContentsStartDateContainer(), VRLayout.FLOW_INSETLINE);

    kyotakuIdouGroup.add(getContentsStopDateContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    kyotakuIdouGroup.add(getContentsStopReasonsContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * �J�n�N�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addContentsStartDate(){

  }

  /**
   * ���~�N�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addContentsStopDate(){

  }

  /**
   * ���~���R�R�[�h�ɓ������ڂ�ǉ����܂��B
   */
  protected void addContentsStopReasons(){

  }

  /**
   * ���~���R�R�[�h���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addContentsStopReasonsModel(){

    getContentsStopReaseonHigaito().setButtonIndex(1);

    getContentsStopReasonsModel().add(getContentsStopReaseonHigaito());

    getContentsStopReaseonNyuin().setButtonIndex(3);

    getContentsStopReasonsModel().add(getContentsStopReaseonNyuin());

    getContentsStopReaseonDeath().setButtonIndex(4);

    getContentsStopReasonsModel().add(getContentsStopReaseonDeath());

    getContentsStopReaseonEtc().setButtonIndex(5);

    getContentsStopReasonsModel().add(getContentsStopReaseonEtc());

    getContentsStopReaseonTokuyo().setButtonIndex(6);

    getContentsStopReasonsModel().add(getContentsStopReaseonTokuyo());

    getContentsStopReaseonRouken().setButtonIndex(7);

    getContentsStopReasonsModel().add(getContentsStopReaseonRouken());

    getContentsStopReaseonRyoyo().setButtonIndex(8);

    getContentsStopReasonsModel().add(getContentsStopReaseonRyoyo());

    getContentsStopReaseonIryoin().setButtonIndex(9);

    getContentsStopReasonsModel().add(getContentsStopReaseonIryoin());

  }

  /**
   * 1.��Y���ɓ������ڂ�ǉ����܂��B
   */
  protected void addContentsStopReaseonHigaito(){

  }

  /**
   * 3.��Ë@�֓��@�ɓ������ڂ�ǉ����܂��B
   */
  protected void addContentsStopReaseonNyuin(){

  }

  /**
   * 4.���S�ɓ������ڂ�ǉ����܂��B
   */
  protected void addContentsStopReaseonDeath(){

  }

  /**
   * 5.���̑��ɓ������ڂ�ǉ����܂��B
   */
  protected void addContentsStopReaseonEtc(){

  }

  /**
   * 6.���V�l�����{�ݓ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addContentsStopReaseonTokuyo(){

  }

  /**
   * 7.���V�l�ی��{�ݓ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addContentsStopReaseonRouken(){

  }

  /**
   * 8.���×{�^��Î{�ݓ��@�ɓ������ڂ�ǉ����܂��B
   */
  protected void addContentsStopReaseonRyoyo(){

  }

  /**
   * 9.����É@�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addContentsStopReaseonIryoin(){

  }

  /**
   * �{�݌n�ٓ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addShisetsuIdouGroup(){

    shisetsuIdouGroup.add(getContentsNyushoDateContainer(), VRLayout.FLOW_INSETLINE);

    shisetsuIdouGroup.add(getContentsTaishoDateContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    shisetsuIdouGroup.add(getContentsNyushoDaysContainer(), VRLayout.FLOW_INSETLINE);

    shisetsuIdouGroup.add(getContentsTankiNyushoDaysContainer(), VRLayout.FLOW_INSETLINE);

    shisetsuIdouGroup.add(getContentsGaihakuDaysContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    shisetsuIdouGroup.add(getContentsNyushoJotaisContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    shisetsuIdouGroup.add(getContentsTaishoJotaisContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * ����(�@)�N�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addContentsNyushoDate(){

  }

  /**
   * �ޏ�(�@)�N�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addContentsTaishoDate(){

  }

  /**
   * ����(�@)�������ɓ������ڂ�ǉ����܂��B
   */
  protected void addContentsNyushoDays(){

  }

  /**
   * �����������ɓ������ڂ�ǉ����܂��B
   */
  protected void addContentsTankiNyushoDays(){

  }

  /**
   * �O�������ɓ������ڂ�ǉ����܂��B
   */
  protected void addContentsGaihakuDays(){

  }

  /**
   * �����i�@�j�O�̏󋵃R�[�h�ɓ������ڂ�ǉ����܂��B
   */
  protected void addContentsNyushoJotais(){

  }

  /**
   * �����i�@�j�O�̏󋵃R�[�h���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addContentsNyushoJotaisModel(){

    getContentsNyushoZaitaku().setButtonIndex(1);

    getContentsNyushoJotaisModel().add(getContentsNyushoZaitaku());

    getContentsNyushoIryo().setButtonIndex(2);

    getContentsNyushoJotaisModel().add(getContentsNyushoIryo());

    getContentsNyushoFukushi().setButtonIndex(3);

    getContentsNyushoJotaisModel().add(getContentsNyushoFukushi());

    getContentsNyushoHoken().setButtonIndex(4);

    getContentsNyushoJotaisModel().add(getContentsNyushoHoken());

    getContentsNyushoRyoyo().setButtonIndex(5);

    getContentsNyushoJotaisModel().add(getContentsNyushoRyoyo());

    getContentsNyushoNinchi().setButtonIndex(6);

    getContentsNyushoJotaisModel().add(getContentsNyushoNinchi());

    getContentsNyushoTokutei().setButtonIndex(7);

    getContentsNyushoJotaisModel().add(getContentsNyushoTokutei());

    getContentsNyushoEtc().setButtonIndex(8);

    getContentsNyushoJotaisModel().add(getContentsNyushoEtc());

    getContentsNyushoIryoin().setButtonIndex(9);

    getContentsNyushoJotaisModel().add(getContentsNyushoIryoin());

  }

  /**
   * 1.����ɓ������ڂ�ǉ����܂��B
   */
  protected void addContentsNyushoZaitaku(){

  }

  /**
   * 2.��Ë@�ւɓ������ڂ�ǉ����܂��B
   */
  protected void addContentsNyushoIryo(){

  }

  /**
   * 3.���V�l�����{�݂ɓ������ڂ�ǉ����܂��B
   */
  protected void addContentsNyushoFukushi(){

  }

  /**
   * 4.���V�l�ی��{�݂ɓ������ڂ�ǉ����܂��B
   */
  protected void addContentsNyushoHoken(){

  }

  /**
   * 5.���×{�^��Î{�݂ɓ������ڂ�ǉ����܂��B
   */
  protected void addContentsNyushoRyoyo(){

  }

  /**
   * 6.�F�m�ǑΉ��^�����������ɓ������ڂ�ǉ����܂��B
   */
  protected void addContentsNyushoNinchi(){

  }

  /**
   * 7.����{�ݓ����Ґ������ɓ������ڂ�ǉ����܂��B
   */
  protected void addContentsNyushoTokutei(){

  }

  /**
   * 8.���̑��ɓ������ڂ�ǉ����܂��B
   */
  protected void addContentsNyushoEtc(){

  }

  /**
   * 9.����É@�ɓ������ڂ�ǉ����܂��B
   */
  protected void addContentsNyushoIryoin(){

  }

  /**
   * �ޏ�(�@)��̏�ԃR�[�h�ɓ������ڂ�ǉ����܂��B
   */
  protected void addContentsTaishoJotais(){

  }

  /**
   * �ޏ�(�@)��̏�ԃR�[�h���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addContentsTaishoJotaisModel(){

    getContentsTaishoJotaiZaitaku().setButtonIndex(1);

    getContentsTaishoJotaisModel().add(getContentsTaishoJotaiZaitaku());

    getContentsTaishoJotaiNyuin().setButtonIndex(3);

    getContentsTaishoJotaisModel().add(getContentsTaishoJotaiNyuin());

    getContentsTaishoJotaiDeath().setButtonIndex(4);

    getContentsTaishoJotaisModel().add(getContentsTaishoJotaiDeath());

    getContentsTaishoJotaiEtc().setButtonIndex(5);

    getContentsTaishoJotaisModel().add(getContentsTaishoJotaiEtc());

    getContentsTaishoJotaiTokuyo().setButtonIndex(6);

    getContentsTaishoJotaisModel().add(getContentsTaishoJotaiTokuyo());

    getContentsTaishoJotaiRouken().setButtonIndex(7);

    getContentsTaishoJotaisModel().add(getContentsTaishoJotaiRouken());

    getContentsTaishoJotaiRyoyo().setButtonIndex(8);

    getContentsTaishoJotaisModel().add(getContentsTaishoJotaiRyoyo());

    getContentsTaishoJotaiIryoin().setButtonIndex(9);

    getContentsTaishoJotaisModel().add(getContentsTaishoJotaiIryoin());

  }

  /**
   * 1.����ɓ������ڂ�ǉ����܂��B
   */
  protected void addContentsTaishoJotaiZaitaku(){

  }

  /**
   * 3.��Ë@�֓��@�ɓ������ڂ�ǉ����܂��B
   */
  protected void addContentsTaishoJotaiNyuin(){

  }

  /**
   * 4.���S�ɓ������ڂ�ǉ����܂��B
   */
  protected void addContentsTaishoJotaiDeath(){

  }

  /**
   * 5.���̑��ɓ������ڂ�ǉ����܂��B
   */
  protected void addContentsTaishoJotaiEtc(){

  }

  /**
   * 6.���V�l�����{�ݓ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addContentsTaishoJotaiTokuyo(){

  }

  /**
   * 7.���V�l�ی��{�ݓ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addContentsTaishoJotaiRouken(){

  }

  /**
   * 8.���×{�^��Î{�ݓ��@�ɓ������ڂ�ǉ����܂��B
   */
  protected void addContentsTaishoJotaiRyoyo(){

  }

  /**
   * 9.����É@�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addContentsTaishoJotaiIryoin(){

  }

  /**
   * �E�v���ҏW�̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addEditTekiyoPanel(){

    editTekiyoPanel.add(getBaseSummaryArea(), VRLayout.NORTH);

    editTekiyoPanel.add(getTekiyos(), VRLayout.NORTH);

    editTekiyoPanel.add(getShinryos(), VRLayout.CLIENT);

  }

  /**
   * ��{�E�v�\���̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addBaseSummaryArea(){

    baseSummaryArea.add(getBaseSummaryText(), VRLayout.NORTH);

    baseSummaryArea.add(getBaseSummaryTable(), VRLayout.CLIENT);

  }

  /**
   * ��{�E�v�R�����g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addBaseSummaryText(){

  }

  /**
   * ��{�E�v�ꗗ�ɓ������ڂ�ǉ����܂��B
   */
  protected void addBaseSummaryTable(){

  }

  /**
   * ��{�E�v�ꗗ�J�������f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addBaseSummaryTableColumnModel(){

    getBaseSummaryTableColumnModel().addColumn(getBaseSummaryNoColumn());

    getBaseSummaryTableColumnModel().addColumn(getBaseSummaryKindCodeColumn());

    getBaseSummaryTableColumnModel().addColumn(getBaseSummaryNameColumn());

    getBaseSummaryTableColumnModel().addColumn(getBaseSummaryNaiyoColumn());

  }

  /**
   * No.�ɓ������ڂ�ǉ����܂��B
   */
  protected void addBaseSummaryNoColumn(){

  }

  /**
   * �E�v��ʃR�[�h�ɓ������ڂ�ǉ����܂��B
   */
  protected void addBaseSummaryKindCodeColumn(){

  }

  /**
   * ���̂ɓ������ڂ�ǉ����܂��B
   */
  protected void addBaseSummaryNameColumn(){

  }

  /**
   * �E�v���e�ɓ������ڂ�ǉ����܂��B
   */
  protected void addBaseSummaryNaiyoColumn(){

  }

  /**
   * �E�v���L�ڎ����\���̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTekiyos(){

    tekiyos.add(getTekiyoText(), VRLayout.NORTH);

    tekiyos.add(getTekiyoTable(), VRLayout.CLIENT);

  }

  /**
   * �E�v���L�ڎ����R�����g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTekiyoText(){

  }

  /**
   * �E�v���L�ڎ����ꗗ�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTekiyoTable(){

  }

  /**
   * �E�v���L�ڎ����ꗗ�J�������f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addTekiyoTableColumnModel(){

    getTekiyoTableColumnModel().addColumn(getTekiyoNoColumn());

    getTekiyoTableColumnModel().addColumn(getTekiyoServiceCodeColumn());

    getTekiyoTableColumnModel().addColumn(getTekiyoServiceNameColumn());

    getTekiyoTableColumnModel().addColumn(getTekiyoTimesColumn());

    getTekiyoTableColumnModel().addColumn(getTekiyoServiceUnitColumn());

    getTekiyoTableColumnModel().addColumn(getTekiyoTekiyoColumn());

  }

  /**
   * No.�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTekiyoNoColumn(){

  }

  /**
   * �T�[�r�X�R�[�h�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTekiyoServiceCodeColumn(){

  }

  /**
   * �T�[�r�X���̂ɓ������ڂ�ǉ����܂��B
   */
  protected void addTekiyoServiceNameColumn(){

  }

  /**
   * �񐔂ɓ������ڂ�ǉ����܂��B
   */
  protected void addTekiyoTimesColumn(){

  }

  /**
   * �P�ʐ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addTekiyoServiceUnitColumn(){

  }

  /**
   * �E�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTekiyoTekiyoColumn(){

  }

  /**
   * ����f�Ô�\���̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShinryos(){

    shinryos.add(getShinryoDeseaseTextContainer(), VRLayout.NORTH);

    shinryos.add(getShinryoText(), VRLayout.NORTH);

    shinryos.add(getSinryoTable(), VRLayout.CLIENT);

  }

  /**
   * ���a���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShinryoDeseaseText(){

  }

  /**
   * ����f�Ô�R�����g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShinryoText(){

  }

  /**
   * ����f�Ô�ꗗ�ɓ������ڂ�ǉ����܂��B
   */
  protected void addSinryoTable(){

  }

  /**
   * ����f�Ô�ꗗ�J�������f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addSinryoTableColumnModel(){

    getSinryoTableColumnModel().addColumn(getSinryoNoColumn());

    getSinryoTableColumnModel().addColumn(getSinryoShikibetsuColumn());

    getSinryoTableColumnModel().addColumn(getSinryoNameColumn());

    getSinryoTableColumnModel().addColumn(getSinryoTimesColumn());

    getSinryoTableColumnModel().addColumn(getSinryoUnitColumn());

    getSinryoTableColumnModel().addColumn(getSinryoTekiyoColumn());

  }

  /**
   * No.�ɓ������ڂ�ǉ����܂��B
   */
  protected void addSinryoNoColumn(){

  }

  /**
   * ���ʔԍ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addSinryoShikibetsuColumn(){

  }

  /**
   * ���̂ɓ������ڂ�ǉ����܂��B
   */
  protected void addSinryoNameColumn(){

  }

  /**
   * �񐔂ɓ������ڂ�ǉ����܂��B
   */
  protected void addSinryoTimesColumn(){

  }

  /**
   * �P�ʐ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addSinryoUnitColumn(){

  }

  /**
   * �E�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addSinryoTekiyoColumn(){

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
      ACFrame.debugStart(new ACAffairInfo(QP004Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QP004Design getThis() {
    return this;
  }
}
