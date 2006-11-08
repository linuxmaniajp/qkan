
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
 * �J����: �����F
 * �쐬��: 2006/06/08  ���{�R���s���[�^�[������� �����F �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���p�ҊǗ� (U)
 * �v���Z�X ���p�ғo�^ (004)
 * �v���O���� ����E�Е��y����� (QU004)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qu.qu004;
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
 * ����E�Е��y������ʍ��ڃf�U�C��(QU004) 
 */
public class QU004Design extends QkanAffairContainer implements ACAffairable {
  //GUI�R���|�[�l���g

  private ACAffairButtonBar buttons;

  private ACAffairButton insert;

  private ACAffairButton update;

  private ACPanel contents;

  private ACPanel patientInfo;

  private ACLabel patientNameCaption;

  private ACLabel patientName;

  private JTabbedPane tabs;

  private ACPanel points1;

  private VRLayout kaigoLayout;

  private ACPanel kaigoInfos;

  private ACPanel kaigoInfo;

  private ACComboBox kaigoInfoPublicExpense;

  private ACLabelContainer kaigoInfoPublicExpenseContainer;

  private ACComboBoxModelAdapter kaigoInfoPublicExpenseModel;

  private ACLabelContainer kaigoInfoBenefitRateContena;

  private ACTextField kaigoInfoBenefitRate;

  private ACLabel kaigoInfoPercentLabel;

  private ACLabelContainer kaigoInfoBearNoContena;

  private ACTextField kaigoInfoKohiNo;

  private ACTextField kaigoInfoInsurerNo;

  private ACComboBox kaigoInfoBearName;

  private ACLabelContainer kaigoInfoBearNameContainer;

  private ACComboBoxModelAdapter kaigoInfoBearNameModel;

  private ACTextField kaigoInfoReceiptNo;

  private ACLabelContainer kaigoInfoReceiptNoContainer;

  private ACLabelContainer kaigoInfoValidLimitContena;

  private QkanDateTextField kaigoInfoValidLimit1;

  private ACLabel kaigoInfoValidLimitLabel;

  private QkanDateTextField kaigoInfoValidLimit2;

  private ACLabelContainer kaigoInfoSelfPaymentContents;

  private ACTextField kaigoInfoSelfPayment;

  private ACLabel kaigoInfoSelfPaymentYen;

  private ACPanel kaigoInfoButtons;

  private ACButton kaigoInfoButtonClear;

  private ACButton kaigoInfoButtonInsert;

  private ACButton kaigoInfoButtonConpile;

  private ACButton kaigoInfoButtonDelete;

  private ACPanel kaigoInfoTables;

  private ACTable kaigoInfoTable;

  private VRTableColumnModel kaigoInfoTableColumnModel;

  private ACTableColumn kaigoInfoTableColumn0;

  private ACTableColumn kaigoInfoTableColumn1;

  private ACTableColumn kaigoInfoTableColumn2;

  private ACTableColumn kaigoInfoTableColumn3;

  private ACTableColumn kaigoInfoTableColumn5;

  private ACTableColumn kaigoInfoTableColumn6;

  private ACTableColumn kaigoInfoTableColumn7;

  private ACPanel kaigoInfoServices;

  private ACGroupBox kaigoInfoService;

  private ACLabel kaigoInfoServiceComment;

  private ACTable kaigoInfoServiceTable;

  private VRTableColumnModel kaigoInfoServiceTableColumnModel;

  private ACTableColumn kaigoInfoServiceTableColumn1;

  private ACTableColumn kaigoInfoServiceTableColumn2;

  private ACTableColumn kaigoInfoServiceTableColumn3;

  private ACPanel points2;

  private VRLayout iryoLayout;

  private ACPanel iryoInfos;

  private ACPanel iryoInfo;

  private ACComboBox iryoInfoPublicExpense;

  private ACLabelContainer iryoInfoPublicExpenseContainer;

  private ACComboBoxModelAdapter iryoInfoPublicExpenseModel;

  private ACLabelContainer iryoInfoBenefitRateContena;

  private ACTextField iryoInfoBenefitRate;

  private ACLabel iryoInfoPercentLabel;

  private ACLabelContainer iryoInfoBearNoContena;

  private ACTextField iryoInfoKohiNo;

  private ACTextField iryoInfoInsurerNo;

  private ACComboBox iryoInfoBearName;

  private ACLabelContainer iryoInfoBearNameContainer;

  private ACComboBoxModelAdapter iryoInfoBearNameModel;

  private ACTextField iryoInfoReceiptNo;

  private ACLabelContainer iryoInfoReceiptNoContainer;

  private ACLabelContainer iryoInfoValidLimitContena;

  private QkanDateTextField iryoInfoValidLimit1;

  private ACLabel iryoInfoValidLimitLabel;

  private QkanDateTextField iryoInfoValidLimit2;

  private ACPanel iryoInfoButtons;

  private ACButton iryoInfoButtonClear;

  private ACButton iryoInfoButtonInsert;

  private ACButton iryoInfoButtonConpile;

  private ACButton iryoInfoButtonDelete;

  private ACPanel iryoInfoTables;

  private ACTable iryoInfoTable;

  private VRTableColumnModel iryoInfoTableColumnModel;

  private ACTableColumn iryoInfoTableColumn0;

  private ACTableColumn iryoInfoTableColumn1;

  private ACTableColumn iryoInfoTableColumn2;

  private ACTableColumn iryoInfoTableColumn3;

  private ACTableColumn iryoInfoTableColumn5;

  private ACTableColumn iryoInfoTableColumn6;

  private ACTableColumn iryoInfoTableColumn7;

  private ACPanel iryoInfoServices;

  private ACGroupBox iryoInfoService;

  private ACLabel iryoInfoServiceComment;

  private ACTable iryoInfoServiceTable;

  private VRTableColumnModel iryoInfoServiceTableColumnModel;

  private ACTableColumn iryoInfoServiceTableColumn1;

  private ACTableColumn iryoInfoServiceTableColumn2;

  private ACTableColumn iryoInfoServiceTableColumn3;

  private ACPanel points3;

  private VRLayout shahukuLayout;

  private ACPanel shahukuInfos;

  private ACPanel shahukuInfo;

  private ACLabelContainer shahukuInfoBenefitRateContena;

  private ACTextField shahukuInfoBenefitRate;

  private ACLabel shahukuInfoPercentLabel;

  private ACLabelContainer shahukuInfoValidLimitContena;

  private QkanDateTextField shahukuInfoValidLimit1;

  private ACLabel shahukuInfoValidLimitLabel;

  private QkanDateTextField shahukuInfoValidLimit2;

  private ACPanel shahukuInfoButtons;

  private ACButton shahukuInfoButtonClear;

  private ACButton shahukuInfoButtonInsert;

  private ACButton shahukuInfoButtonConpile;

  private ACButton shahukuInfoButtonDelete;

  private ACPanel shahukuInfoTables;

  private ACTable shahukuInfoTable;

  private VRTableColumnModel shahukuInfoTableColumnModel;

  private ACTableColumn shahukuInfoTableColumn0;

  private ACTableColumn shahukuInfoTableColumn1;

  private ACTableColumn shahukuInfoTableColumn2;

  private ACTableColumn shahukuInfoTableColumn3;

  //getter

  /**
   * �Ɩ��{�^���o�[���擾���܂��B
   * @return �Ɩ��{�^���o�[
   */
  public ACAffairButtonBar getButtons(){
    if(buttons==null){

      buttons = new ACAffairButtonBar();

      buttons.setText("����E�Е��y�����");

      addButtons();
    }
    return buttons;

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
  public ACPanel getPatientInfo(){
    if(patientInfo==null){

      patientInfo = new ACPanel();

      addPatientInfo();
    }
    return patientInfo;

  }

  /**
   * ���p�Җ��L���v�V�������擾���܂��B
   * @return ���p�Җ��L���v�V����
   */
  public ACLabel getPatientNameCaption(){
    if(patientNameCaption==null){

      patientNameCaption = new ACLabel();

      patientNameCaption.setText("���p�Җ�");

      addPatientNameCaption();
    }
    return patientNameCaption;

  }

  /**
   * ���p�Җ����擾���܂��B
   * @return ���p�Җ�
   */
  public ACLabel getPatientName(){
    if(patientName==null){

      patientName = new ACLabel();

      patientName.setText("�T���v�����p��");

      patientName.setBindPath("PATIENT_NAME");

      patientName.setColumns(35);

      addPatientName();
    }
    return patientName;

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
   * ������̈���擾���܂��B
   * @return ������̈�
   */
  public ACPanel getPoints1(){
    if(points1==null){

      points1 = new ACPanel();

      points1.setLayout(getKaigoLayout());

      addPoints1();
    }
    return points1;

  }

  /**
   * ������̈�E���C�A�E�g���擾���܂��B
   * @return ������̈�E���C�A�E�g
   */
  public VRLayout getKaigoLayout(){
    if(kaigoLayout==null){

      kaigoLayout = new VRLayout();

      kaigoLayout.setAutoWrap(false);

      addKaigoLayout();
    }
    return kaigoLayout;

  }

  /**
   * ������̈�E�����擾���܂��B
   * @return ������̈�E���
   */
  public ACPanel getKaigoInfos(){
    if(kaigoInfos==null){

      kaigoInfos = new ACPanel();

      addKaigoInfos();
    }
    return kaigoInfos;

  }

  /**
   * ������̈�E���2���擾���܂��B
   * @return ������̈�E���2
   */
  public ACPanel getKaigoInfo(){
    if(kaigoInfo==null){

      kaigoInfo = new ACPanel();

      addKaigoInfo();
    }
    return kaigoInfo;

  }

  /**
   * ��������擾���܂��B
   * @return ������
   */
  public ACComboBox getKaigoInfoPublicExpense(){
    if(kaigoInfoPublicExpense==null){

      kaigoInfoPublicExpense = new ACComboBox();

      getKaigoInfoPublicExpenseContainer().setText("������");

      kaigoInfoPublicExpense.setBindPath("KOHI_TYPE");

      kaigoInfoPublicExpense.setEditable(false);

      kaigoInfoPublicExpense.setColumns(10);

      kaigoInfoPublicExpense.setModelBindPath("KAIGO_KOHI");

      kaigoInfoPublicExpense.setRenderBindPath("KOHI_NAME");

      kaigoInfoPublicExpense.setModel(getKaigoInfoPublicExpenseModel());

      addKaigoInfoPublicExpense();
    }
    return kaigoInfoPublicExpense;

  }

  /**
   * ������R���e�i���擾���܂��B
   * @return ������R���e�i
   */
  protected ACLabelContainer getKaigoInfoPublicExpenseContainer(){
    if(kaigoInfoPublicExpenseContainer==null){
      kaigoInfoPublicExpenseContainer = new ACLabelContainer();
      kaigoInfoPublicExpenseContainer.setFollowChildEnabled(true);
      kaigoInfoPublicExpenseContainer.setVAlignment(VRLayout.CENTER);
      kaigoInfoPublicExpenseContainer.add(getKaigoInfoPublicExpense(), null);
    }
    return kaigoInfoPublicExpenseContainer;
  }

  /**
   * �����񃂃f�����擾���܂��B
   * @return �����񃂃f��
   */
  protected ACComboBoxModelAdapter getKaigoInfoPublicExpenseModel(){
    if(kaigoInfoPublicExpenseModel==null){
      kaigoInfoPublicExpenseModel = new ACComboBoxModelAdapter();
      addKaigoInfoPublicExpenseModel();
    }
    return kaigoInfoPublicExpenseModel;
  }

  /**
   * (���t���E�R���e�i)���擾���܂��B
   * @return (���t���E�R���e�i)
   */
  public ACLabelContainer getKaigoInfoBenefitRateContena(){
    if(kaigoInfoBenefitRateContena==null){

      kaigoInfoBenefitRateContena = new ACLabelContainer();

      kaigoInfoBenefitRateContena.setText("���t��");

      addKaigoInfoBenefitRateContena();
    }
    return kaigoInfoBenefitRateContena;

  }

  /**
   * ���t�����擾���܂��B
   * @return ���t��
   */
  public ACTextField getKaigoInfoBenefitRate(){
    if(kaigoInfoBenefitRate==null){

      kaigoInfoBenefitRate = new ACTextField();

      kaigoInfoBenefitRate.setBindPath("BENEFIT_RATE");

      kaigoInfoBenefitRate.setColumns(3);

      kaigoInfoBenefitRate.setCharType(VRCharType.ONLY_DIGIT);

      kaigoInfoBenefitRate.setHorizontalAlignment(SwingConstants.RIGHT);

      kaigoInfoBenefitRate.setIMEMode(InputSubset.LATIN);

      kaigoInfoBenefitRate.setMaxLength(3);

      addKaigoInfoBenefitRate();
    }
    return kaigoInfoBenefitRate;

  }

  /**
   * %���x�����擾���܂��B
   * @return %���x��
   */
  public ACLabel getKaigoInfoPercentLabel(){
    if(kaigoInfoPercentLabel==null){

      kaigoInfoPercentLabel = new ACLabel();

      kaigoInfoPercentLabel.setText(" ��");

      addKaigoInfoPercentLabel();
    }
    return kaigoInfoPercentLabel;

  }

  /**
   * (���S�Ҕԍ��E�R���e�i)���擾���܂��B
   * @return (���S�Ҕԍ��E�R���e�i)
   */
  public ACLabelContainer getKaigoInfoBearNoContena(){
    if(kaigoInfoBearNoContena==null){

      kaigoInfoBearNoContena = new ACLabelContainer();

      kaigoInfoBearNoContena.setText("���S�Ҕԍ�");

      addKaigoInfoBearNoContena();
    }
    return kaigoInfoBearNoContena;

  }

  /**
   * ����@�ʔԍ����擾���܂��B
   * @return ����@�ʔԍ�
   */
  public ACTextField getKaigoInfoKohiNo(){
    if(kaigoInfoKohiNo==null){

      kaigoInfoKohiNo = new ACTextField();

      kaigoInfoKohiNo.setBindPath("KOHI_LAW_NO");

      kaigoInfoKohiNo.setEditable(false);

      kaigoInfoKohiNo.setColumns(2);

      kaigoInfoKohiNo.setCharType(VRCharType.ONLY_DIGIT);

      kaigoInfoKohiNo.setIMEMode(InputSubset.LATIN);

      kaigoInfoKohiNo.setMaxLength(2);

      addKaigoInfoKohiNo();
    }
    return kaigoInfoKohiNo;

  }

  /**
   * �ی��Ҕԍ����擾���܂��B
   * @return �ی��Ҕԍ�
   */
  public ACTextField getKaigoInfoInsurerNo(){
    if(kaigoInfoInsurerNo==null){

      kaigoInfoInsurerNo = new ACTextField();

      kaigoInfoInsurerNo.setBindPath("INSURER_ID");

      kaigoInfoInsurerNo.setColumns(6);

      kaigoInfoInsurerNo.setCharType(VRCharType.ONLY_DIGIT);

      kaigoInfoInsurerNo.setMaxLength(6);

      addKaigoInfoInsurerNo();
    }
    return kaigoInfoInsurerNo;

  }

  /**
   * ���S�Җ����擾���܂��B
   * @return ���S�Җ�
   */
  public ACComboBox getKaigoInfoBearName(){
    if(kaigoInfoBearName==null){

      kaigoInfoBearName = new ACComboBox();

      kaigoInfoBearName.setVisible(false);

      kaigoInfoBearName.setEditable(false);

      kaigoInfoBearName.setColumns(10);

      kaigoInfoBearName.setModelBindPath("KOHI_PAYER_NAME");

      kaigoInfoBearName.setRenderBindPath("INSURER_NAME");

      kaigoInfoBearName.setModel(getKaigoInfoBearNameModel());

      addKaigoInfoBearName();
    }
    return kaigoInfoBearName;

  }

  /**
   * ���S�Җ��R���e�i���擾���܂��B
   * @return ���S�Җ��R���e�i
   */
  protected ACLabelContainer getKaigoInfoBearNameContainer(){
    if(kaigoInfoBearNameContainer==null){
      kaigoInfoBearNameContainer = new ACLabelContainer();
      kaigoInfoBearNameContainer.setFollowChildEnabled(true);
      kaigoInfoBearNameContainer.setVAlignment(VRLayout.CENTER);
      kaigoInfoBearNameContainer.add(getKaigoInfoBearName(), null);
    }
    return kaigoInfoBearNameContainer;
  }

  /**
   * ���S�Җ����f�����擾���܂��B
   * @return ���S�Җ����f��
   */
  protected ACComboBoxModelAdapter getKaigoInfoBearNameModel(){
    if(kaigoInfoBearNameModel==null){
      kaigoInfoBearNameModel = new ACComboBoxModelAdapter();
      addKaigoInfoBearNameModel();
    }
    return kaigoInfoBearNameModel;
  }

  /**
   * �󋋎Ҕԍ����擾���܂��B
   * @return �󋋎Ҕԍ�
   */
  public ACTextField getKaigoInfoReceiptNo(){
    if(kaigoInfoReceiptNo==null){

      kaigoInfoReceiptNo = new ACTextField();

      getKaigoInfoReceiptNoContainer().setText("�󋋎Ҕԍ�");

      kaigoInfoReceiptNo.setBindPath("KOHI_RECIPIENT_NO");

      kaigoInfoReceiptNo.setCharType(VRCharType.ONLY_ALNUM);

      kaigoInfoReceiptNo.setColumns(10);

      kaigoInfoReceiptNo.setMaxLength(7);

      addKaigoInfoReceiptNo();
    }
    return kaigoInfoReceiptNo;

  }

  /**
   * �󋋎Ҕԍ��R���e�i���擾���܂��B
   * @return �󋋎Ҕԍ��R���e�i
   */
  protected ACLabelContainer getKaigoInfoReceiptNoContainer(){
    if(kaigoInfoReceiptNoContainer==null){
      kaigoInfoReceiptNoContainer = new ACLabelContainer();
      kaigoInfoReceiptNoContainer.setFollowChildEnabled(true);
      kaigoInfoReceiptNoContainer.setVAlignment(VRLayout.CENTER);
      kaigoInfoReceiptNoContainer.add(getKaigoInfoReceiptNo(), null);
    }
    return kaigoInfoReceiptNoContainer;
  }

  /**
   * �L�����ԁE�R���e�i���擾���܂��B
   * @return �L�����ԁE�R���e�i
   */
  public ACLabelContainer getKaigoInfoValidLimitContena(){
    if(kaigoInfoValidLimitContena==null){

      kaigoInfoValidLimitContena = new ACLabelContainer();

      kaigoInfoValidLimitContena.setText("�L������");

      addKaigoInfoValidLimitContena();
    }
    return kaigoInfoValidLimitContena;

  }

  /**
   * �L�����ԁE�e�L�X�g1���擾���܂��B
   * @return �L�����ԁE�e�L�X�g1
   */
  public QkanDateTextField getKaigoInfoValidLimit1(){
    if(kaigoInfoValidLimit1==null){

      kaigoInfoValidLimit1 = new QkanDateTextField();

      kaigoInfoValidLimit1.setBindPath("KOHI_VALID_START");

      kaigoInfoValidLimit1.setColumns(10);

      kaigoInfoValidLimit1.setFormat(new ACBorderBlankDateFormat("gggee�NMM��dd��"));

      kaigoInfoValidLimit1.setMaxLength(11);

      addKaigoInfoValidLimit1();
    }
    return kaigoInfoValidLimit1;

  }

  /**
   * �L�����ԁE���x�����擾���܂��B
   * @return �L�����ԁE���x��
   */
  public ACLabel getKaigoInfoValidLimitLabel(){
    if(kaigoInfoValidLimitLabel==null){

      kaigoInfoValidLimitLabel = new ACLabel();

      kaigoInfoValidLimitLabel.setText(" ���� ");

      addKaigoInfoValidLimitLabel();
    }
    return kaigoInfoValidLimitLabel;

  }

  /**
   * �L�����ԁE�e�L�X�g2���擾���܂��B
   * @return �L�����ԁE�e�L�X�g2
   */
  public QkanDateTextField getKaigoInfoValidLimit2(){
    if(kaigoInfoValidLimit2==null){

      kaigoInfoValidLimit2 = new QkanDateTextField();

      kaigoInfoValidLimit2.setBindPath("KOHI_VALID_END");

      kaigoInfoValidLimit2.setColumns(10);

      kaigoInfoValidLimit2.setFormat(new ACBorderBlankDateFormat("gggee�NMM��dd��"));

      kaigoInfoValidLimit2.setMaxLength(11);

      addKaigoInfoValidLimit2();
    }
    return kaigoInfoValidLimit2;

  }

  /**
   * (���ȕ��S�z�E�R���e�i)���擾���܂��B
   * @return (���ȕ��S�z�E�R���e�i)
   */
  public ACLabelContainer getKaigoInfoSelfPaymentContents(){
    if(kaigoInfoSelfPaymentContents==null){

      kaigoInfoSelfPaymentContents = new ACLabelContainer();

      kaigoInfoSelfPaymentContents.setText("���ȕ��S�z");

      addKaigoInfoSelfPaymentContents();
    }
    return kaigoInfoSelfPaymentContents;

  }

  /**
   * ���ȕ��S�z���擾���܂��B
   * @return ���ȕ��S�z
   */
  public ACTextField getKaigoInfoSelfPayment(){
    if(kaigoInfoSelfPayment==null){

      kaigoInfoSelfPayment = new ACTextField();

      kaigoInfoSelfPayment.setBindPath("SELF_PAY");

      kaigoInfoSelfPayment.setColumns(5);

      kaigoInfoSelfPayment.setCharType(VRCharType.ONLY_DIGIT);

      kaigoInfoSelfPayment.setHorizontalAlignment(SwingConstants.RIGHT);

      kaigoInfoSelfPayment.setMaxLength(6);

      addKaigoInfoSelfPayment();
    }
    return kaigoInfoSelfPayment;

  }

  /**
   * ���ȕ��S�z���x�����擾���܂��B
   * @return ���ȕ��S�z���x��
   */
  public ACLabel getKaigoInfoSelfPaymentYen(){
    if(kaigoInfoSelfPaymentYen==null){

      kaigoInfoSelfPaymentYen = new ACLabel();

      kaigoInfoSelfPaymentYen.setText(" �~");

      addKaigoInfoSelfPaymentYen();
    }
    return kaigoInfoSelfPaymentYen;

  }

  /**
   * ������̈�E�{�^�����擾���܂��B
   * @return ������̈�E�{�^��
   */
  public ACPanel getKaigoInfoButtons(){
    if(kaigoInfoButtons==null){

      kaigoInfoButtons = new ACPanel();

      addKaigoInfoButtons();
    }
    return kaigoInfoButtons;

  }

  /**
   * �N���A���擾���܂��B
   * @return �N���A
   */
  public ACButton getKaigoInfoButtonClear(){
    if(kaigoInfoButtonClear==null){

      kaigoInfoButtonClear = new ACButton();

      kaigoInfoButtonClear.setText("�N���A");

      kaigoInfoButtonClear.setToolTipText("����������N���A���܂��B");

      kaigoInfoButtonClear.setIconPath(ACConstants.ICON_PATH_CLEAR_16);

      addKaigoInfoButtonClear();
    }
    return kaigoInfoButtonClear;

  }

  /**
   * �ǉ����擾���܂��B
   * @return �ǉ�
   */
  public ACButton getKaigoInfoButtonInsert(){
    if(kaigoInfoButtonInsert==null){

      kaigoInfoButtonInsert = new ACButton();

      kaigoInfoButtonInsert.setText("�ǉ�");

      kaigoInfoButtonInsert.setToolTipText("���������ǉ����܂��B");

      kaigoInfoButtonInsert.setIconPath(ACConstants.ICON_PATH_RECORD_DOWNLOAD_16);

      addKaigoInfoButtonInsert();
    }
    return kaigoInfoButtonInsert;

  }

  /**
   * ���ւ��擾���܂��B
   * @return ����
   */
  public ACButton getKaigoInfoButtonConpile(){
    if(kaigoInfoButtonConpile==null){

      kaigoInfoButtonConpile = new ACButton();

      kaigoInfoButtonConpile.setText("����");

      kaigoInfoButtonConpile.setToolTipText("���������ҏW���܂��B");

      kaigoInfoButtonConpile.setIconPath(ACConstants.ICON_PATH_STATE_UPDATE_16);

      addKaigoInfoButtonConpile();
    }
    return kaigoInfoButtonConpile;

  }

  /**
   * �폜���擾���܂��B
   * @return �폜
   */
  public ACButton getKaigoInfoButtonDelete(){
    if(kaigoInfoButtonDelete==null){

      kaigoInfoButtonDelete = new ACButton();

      kaigoInfoButtonDelete.setText("�폜");

      kaigoInfoButtonDelete.setToolTipText("����������폜���܂��B");

      kaigoInfoButtonDelete.setIconPath(ACConstants.ICON_PATH_STATE_DELETE_16);

      addKaigoInfoButtonDelete();
    }
    return kaigoInfoButtonDelete;

  }

  /**
   * ������̈�E�p�l�����擾���܂��B
   * @return ������̈�E�p�l��
   */
  public ACPanel getKaigoInfoTables(){
    if(kaigoInfoTables==null){

      kaigoInfoTables = new ACPanel();

      addKaigoInfoTables();
    }
    return kaigoInfoTables;

  }

  /**
   * ������E�e�[�u�����擾���܂��B
   * @return ������E�e�[�u��
   */
  public ACTable getKaigoInfoTable(){
    if(kaigoInfoTable==null){

      kaigoInfoTable = new ACTable();

      kaigoInfoTable.setColumnModel(getKaigoInfoTableColumnModel());

      addKaigoInfoTable();
    }
    return kaigoInfoTable;

  }

  /**
   * ������E�e�[�u���J�������f�����擾���܂��B
   * @return ������E�e�[�u���J�������f��
   */
  protected VRTableColumnModel getKaigoInfoTableColumnModel(){
    if(kaigoInfoTableColumnModel==null){
      kaigoInfoTableColumnModel = new VRTableColumnModel(new TableColumn[]{});
      addKaigoInfoTableColumnModel();
    }
    return kaigoInfoTableColumnModel;
  }

  /**
   * No.���擾���܂��B
   * @return No.
   */
  public ACTableColumn getKaigoInfoTableColumn0(){
    if(kaigoInfoTableColumn0==null){

      kaigoInfoTableColumn0 = new ACTableColumn(0);

      kaigoInfoTableColumn0.setHeaderValue("No.");

      kaigoInfoTableColumn0.setColumns(3);

      kaigoInfoTableColumn0.setRendererType(ACTableCellViewer.RENDERER_TYPE_SERIAL_NO);

      kaigoInfoTableColumn0.setSortable(false);

      addKaigoInfoTableColumn0();
    }
    return kaigoInfoTableColumn0;

  }

  /**
   * ��������擾���܂��B
   * @return ������
   */
  public ACTableColumn getKaigoInfoTableColumn1(){
    if(kaigoInfoTableColumn1==null){

      kaigoInfoTableColumn1 = new ACTableColumn(0);

      kaigoInfoTableColumn1.setHeaderValue("������");

      kaigoInfoTableColumn1.setColumns(22);

      addKaigoInfoTableColumn1();
    }
    return kaigoInfoTableColumn1;

  }

  /**
   * ���t�����擾���܂��B
   * @return ���t��
   */
  public ACTableColumn getKaigoInfoTableColumn2(){
    if(kaigoInfoTableColumn2==null){

      kaigoInfoTableColumn2 = new ACTableColumn(1);

      kaigoInfoTableColumn2.setHeaderValue("���t��");

      kaigoInfoTableColumn2.setColumns(7);

      kaigoInfoTableColumn2.setHorizontalAlignment(SwingConstants.RIGHT);

      addKaigoInfoTableColumn2();
    }
    return kaigoInfoTableColumn2;

  }

  /**
   * ���S�Ҕԍ����擾���܂��B
   * @return ���S�Ҕԍ�
   */
  public ACTableColumn getKaigoInfoTableColumn3(){
    if(kaigoInfoTableColumn3==null){

      kaigoInfoTableColumn3 = new ACTableColumn(2);

      kaigoInfoTableColumn3.setHeaderValue("���S�Ҕԍ�");

      kaigoInfoTableColumn3.setColumns(8);

      addKaigoInfoTableColumn3();
    }
    return kaigoInfoTableColumn3;

  }

  /**
   * �󋋎Ҕԍ����擾���܂��B
   * @return �󋋎Ҕԍ�
   */
  public ACTableColumn getKaigoInfoTableColumn5(){
    if(kaigoInfoTableColumn5==null){

      kaigoInfoTableColumn5 = new ACTableColumn(4);

      kaigoInfoTableColumn5.setHeaderValue("�󋋎Ҕԍ�");

      kaigoInfoTableColumn5.setColumns(7);

      addKaigoInfoTableColumn5();
    }
    return kaigoInfoTableColumn5;

  }

  /**
   * �L�����ԊJ�n���擾���܂��B
   * @return �L�����ԊJ�n
   */
  public ACTableColumn getKaigoInfoTableColumn6(){
    if(kaigoInfoTableColumn6==null){

      kaigoInfoTableColumn6 = new ACTableColumn(5);

      kaigoInfoTableColumn6.setHeaderValue("�L�����ԊJ�n��");

      kaigoInfoTableColumn6.setColumns(12);

      kaigoInfoTableColumn6.setFormat(new ACBorderBlankDateFormat("gggee�NMM��dd��"));

      addKaigoInfoTableColumn6();
    }
    return kaigoInfoTableColumn6;

  }

  /**
   * �L�����ԏI�����擾���܂��B
   * @return �L�����ԏI��
   */
  public ACTableColumn getKaigoInfoTableColumn7(){
    if(kaigoInfoTableColumn7==null){

      kaigoInfoTableColumn7 = new ACTableColumn(6);

      kaigoInfoTableColumn7.setHeaderValue("�L�����ԏI����");

      kaigoInfoTableColumn7.setColumns(12);

      kaigoInfoTableColumn7.setFormat(new ACBorderBlankDateFormat("gggee�NMM��dd��"));

      addKaigoInfoTableColumn7();
    }
    return kaigoInfoTableColumn7;

  }

  /**
   * ������̈�E�T�[�r�X���擾���܂��B
   * @return ������̈�E�T�[�r�X
   */
  public ACPanel getKaigoInfoServices(){
    if(kaigoInfoServices==null){

      kaigoInfoServices = new ACPanel();

      kaigoInfoServices.setVisible(false);

      addKaigoInfoServices();
    }
    return kaigoInfoServices;

  }

  /**
   * �T�[�r�X�E�O���[�v���擾���܂��B
   * @return �T�[�r�X�E�O���[�v
   */
  public ACGroupBox getKaigoInfoService(){
    if(kaigoInfoService==null){

      kaigoInfoService = new ACGroupBox();

      kaigoInfoService.setText("���t�ΏۃT�[�r�X");

      kaigoInfoService.setAutoWrap(false);

      addKaigoInfoService();
    }
    return kaigoInfoService;

  }

  /**
   * ���������x���E�����擾���܂��B
   * @return ���������x���E���
   */
  public ACLabel getKaigoInfoServiceComment(){
    if(kaigoInfoServiceComment==null){

      kaigoInfoServiceComment = new ACLabel();

      kaigoInfoServiceComment.setText("����̑ΏۂƂȂ�T�[�r�X�Ƀ`�F�b�N�����Ă��������B");

      kaigoInfoServiceComment.setIconPath(ACConstants.ICON_PATH_INFORMATION_16);

      addKaigoInfoServiceComment();
    }
    return kaigoInfoServiceComment;

  }

  /**
   * ����E�g�p�T�[�r�X�e�[�u�����擾���܂��B
   * @return ����E�g�p�T�[�r�X�e�[�u��
   */
  public ACTable getKaigoInfoServiceTable(){
    if(kaigoInfoServiceTable==null){

      kaigoInfoServiceTable = new ACTable();

      kaigoInfoServiceTable.setColumns(36);

      kaigoInfoServiceTable.setColumnModel(getKaigoInfoServiceTableColumnModel());

      kaigoInfoServiceTable.setColumnSort(false);

      addKaigoInfoServiceTable();
    }
    return kaigoInfoServiceTable;

  }

  /**
   * ����E�g�p�T�[�r�X�e�[�u���J�������f�����擾���܂��B
   * @return ����E�g�p�T�[�r�X�e�[�u���J�������f��
   */
  protected VRTableColumnModel getKaigoInfoServiceTableColumnModel(){
    if(kaigoInfoServiceTableColumnModel==null){
      kaigoInfoServiceTableColumnModel = new VRTableColumnModel(new TableColumn[]{});
      addKaigoInfoServiceTableColumnModel();
    }
    return kaigoInfoServiceTableColumnModel;
  }

  /**
   * ��F�񋟂��擾���܂��B
   * @return ��F��
   */
  public ACTableColumn getKaigoInfoServiceTableColumn1(){
    if(kaigoInfoServiceTableColumn1==null){

      kaigoInfoServiceTableColumn1 = new ACTableColumn(0);

      kaigoInfoServiceTableColumn1.setHeaderValue("��");

      kaigoInfoServiceTableColumn1.setEditable(true);

      kaigoInfoServiceTableColumn1.setColumns(3);

      kaigoInfoServiceTableColumn1.setRendererType(VRTableCellViewer.RENDERER_TYPE_CHECK_BOX);

      kaigoInfoServiceTableColumn1.setEditorType(VRTableCellViewer.EDITOR_TYPE_CHECK_BOX);

      addKaigoInfoServiceTableColumn1();
    }
    return kaigoInfoServiceTableColumn1;

  }

  /**
   * ��F�T�[�r�X��ނ��擾���܂��B
   * @return ��F�T�[�r�X���
   */
  public ACTableColumn getKaigoInfoServiceTableColumn2(){
    if(kaigoInfoServiceTableColumn2==null){

      kaigoInfoServiceTableColumn2 = new ACTableColumn(1);

      kaigoInfoServiceTableColumn2.setHeaderValue("�T�[�r�X���");

      kaigoInfoServiceTableColumn2.setColumns(25);

      addKaigoInfoServiceTableColumn2();
    }
    return kaigoInfoServiceTableColumn2;

  }

  /**
   * ��F���[��ނ��擾���܂��B
   * @return ��F���[���
   */
  public ACTableColumn getKaigoInfoServiceTableColumn3(){
    if(kaigoInfoServiceTableColumn3==null){

      kaigoInfoServiceTableColumn3 = new ACTableColumn(2);

      kaigoInfoServiceTableColumn3.setHeaderValue("���[���");

      kaigoInfoServiceTableColumn3.setColumns(8);

      addKaigoInfoServiceTableColumn3();
    }
    return kaigoInfoServiceTableColumn3;

  }

  /**
   * ��Ì���̈���擾���܂��B
   * @return ��Ì���̈�
   */
  public ACPanel getPoints2(){
    if(points2==null){

      points2 = new ACPanel();

      points2.setLayout(getIryoLayout());

      addPoints2();
    }
    return points2;

  }

  /**
   * ��Ì���̈�E���C�A�E�g���擾���܂��B
   * @return ��Ì���̈�E���C�A�E�g
   */
  public VRLayout getIryoLayout(){
    if(iryoLayout==null){

      iryoLayout = new VRLayout();

      iryoLayout.setAutoWrap(false);

      addIryoLayout();
    }
    return iryoLayout;

  }

  /**
   * ��Ì���̈�E�����擾���܂��B
   * @return ��Ì���̈�E���
   */
  public ACPanel getIryoInfos(){
    if(iryoInfos==null){

      iryoInfos = new ACPanel();

      addIryoInfos();
    }
    return iryoInfos;

  }

  /**
   * ��Ì���̈�E���2���擾���܂��B
   * @return ��Ì���̈�E���2
   */
  public ACPanel getIryoInfo(){
    if(iryoInfo==null){

      iryoInfo = new ACPanel();

      addIryoInfo();
    }
    return iryoInfo;

  }

  /**
   * ��������擾���܂��B
   * @return ������
   */
  public ACComboBox getIryoInfoPublicExpense(){
    if(iryoInfoPublicExpense==null){

      iryoInfoPublicExpense = new ACComboBox();

      getIryoInfoPublicExpenseContainer().setText("������");

      iryoInfoPublicExpense.setBindPath("KOHI_TYPE");

      iryoInfoPublicExpense.setEditable(false);

      iryoInfoPublicExpense.setColumns(10);

      iryoInfoPublicExpense.setModelBindPath("IRYO_KOHI");

      iryoInfoPublicExpense.setRenderBindPath("KOHI_NAME");

      iryoInfoPublicExpense.setModel(getIryoInfoPublicExpenseModel());

      addIryoInfoPublicExpense();
    }
    return iryoInfoPublicExpense;

  }

  /**
   * ������R���e�i���擾���܂��B
   * @return ������R���e�i
   */
  protected ACLabelContainer getIryoInfoPublicExpenseContainer(){
    if(iryoInfoPublicExpenseContainer==null){
      iryoInfoPublicExpenseContainer = new ACLabelContainer();
      iryoInfoPublicExpenseContainer.setFollowChildEnabled(true);
      iryoInfoPublicExpenseContainer.setVAlignment(VRLayout.CENTER);
      iryoInfoPublicExpenseContainer.add(getIryoInfoPublicExpense(), null);
    }
    return iryoInfoPublicExpenseContainer;
  }

  /**
   * �����񃂃f�����擾���܂��B
   * @return �����񃂃f��
   */
  protected ACComboBoxModelAdapter getIryoInfoPublicExpenseModel(){
    if(iryoInfoPublicExpenseModel==null){
      iryoInfoPublicExpenseModel = new ACComboBoxModelAdapter();
      addIryoInfoPublicExpenseModel();
    }
    return iryoInfoPublicExpenseModel;
  }

  /**
   * (���t���E�R���e�i)���擾���܂��B
   * @return (���t���E�R���e�i)
   */
  public ACLabelContainer getIryoInfoBenefitRateContena(){
    if(iryoInfoBenefitRateContena==null){

      iryoInfoBenefitRateContena = new ACLabelContainer();

      iryoInfoBenefitRateContena.setText("���t��");

      addIryoInfoBenefitRateContena();
    }
    return iryoInfoBenefitRateContena;

  }

  /**
   * ���t�����擾���܂��B
   * @return ���t��
   */
  public ACTextField getIryoInfoBenefitRate(){
    if(iryoInfoBenefitRate==null){

      iryoInfoBenefitRate = new ACTextField();

      iryoInfoBenefitRate.setBindPath("BENEFIT_RATE");

      iryoInfoBenefitRate.setColumns(3);

      iryoInfoBenefitRate.setCharType(VRCharType.ONLY_DIGIT);

      iryoInfoBenefitRate.setHorizontalAlignment(SwingConstants.RIGHT);

      iryoInfoBenefitRate.setIMEMode(InputSubset.LATIN);

      iryoInfoBenefitRate.setMaxLength(3);

      addIryoInfoBenefitRate();
    }
    return iryoInfoBenefitRate;

  }

  /**
   * %���x�����擾���܂��B
   * @return %���x��
   */
  public ACLabel getIryoInfoPercentLabel(){
    if(iryoInfoPercentLabel==null){

      iryoInfoPercentLabel = new ACLabel();

      iryoInfoPercentLabel.setText(" ��");

      addIryoInfoPercentLabel();
    }
    return iryoInfoPercentLabel;

  }

  /**
   * (���S�Ҕԍ��E�R���e�i)���擾���܂��B
   * @return (���S�Ҕԍ��E�R���e�i)
   */
  public ACLabelContainer getIryoInfoBearNoContena(){
    if(iryoInfoBearNoContena==null){

      iryoInfoBearNoContena = new ACLabelContainer();

      iryoInfoBearNoContena.setText("���S�Ҕԍ�");

      addIryoInfoBearNoContena();
    }
    return iryoInfoBearNoContena;

  }

  /**
   * ����@�ʔԍ����擾���܂��B
   * @return ����@�ʔԍ�
   */
  public ACTextField getIryoInfoKohiNo(){
    if(iryoInfoKohiNo==null){

      iryoInfoKohiNo = new ACTextField();

      iryoInfoKohiNo.setBindPath("KOHI_LAW_NO");

      iryoInfoKohiNo.setEditable(false);

      iryoInfoKohiNo.setColumns(2);

      iryoInfoKohiNo.setCharType(VRCharType.ONLY_DIGIT);

      iryoInfoKohiNo.setIMEMode(InputSubset.LATIN);

      iryoInfoKohiNo.setMaxLength(2);

      addIryoInfoKohiNo();
    }
    return iryoInfoKohiNo;

  }

  /**
   * �ی��Ҕԍ����擾���܂��B
   * @return �ی��Ҕԍ�
   */
  public ACTextField getIryoInfoInsurerNo(){
    if(iryoInfoInsurerNo==null){

      iryoInfoInsurerNo = new ACTextField();

      iryoInfoInsurerNo.setBindPath("INSURER_ID");

      iryoInfoInsurerNo.setColumns(6);

      iryoInfoInsurerNo.setCharType(VRCharType.ONLY_DIGIT);

      iryoInfoInsurerNo.setMaxLength(6);

      addIryoInfoInsurerNo();
    }
    return iryoInfoInsurerNo;

  }

  /**
   * ���S�Җ����擾���܂��B
   * @return ���S�Җ�
   */
  public ACComboBox getIryoInfoBearName(){
    if(iryoInfoBearName==null){

      iryoInfoBearName = new ACComboBox();

      iryoInfoBearName.setVisible(false);

      iryoInfoBearName.setEditable(false);

      iryoInfoBearName.setColumns(10);

      iryoInfoBearName.setModelBindPath("KOHI_PAYER_NAME");

      iryoInfoBearName.setRenderBindPath("INSURER_NAME");

      iryoInfoBearName.setModel(getIryoInfoBearNameModel());

      addIryoInfoBearName();
    }
    return iryoInfoBearName;

  }

  /**
   * ���S�Җ��R���e�i���擾���܂��B
   * @return ���S�Җ��R���e�i
   */
  protected ACLabelContainer getIryoInfoBearNameContainer(){
    if(iryoInfoBearNameContainer==null){
      iryoInfoBearNameContainer = new ACLabelContainer();
      iryoInfoBearNameContainer.setFollowChildEnabled(true);
      iryoInfoBearNameContainer.setVAlignment(VRLayout.CENTER);
      iryoInfoBearNameContainer.add(getIryoInfoBearName(), null);
    }
    return iryoInfoBearNameContainer;
  }

  /**
   * ���S�Җ����f�����擾���܂��B
   * @return ���S�Җ����f��
   */
  protected ACComboBoxModelAdapter getIryoInfoBearNameModel(){
    if(iryoInfoBearNameModel==null){
      iryoInfoBearNameModel = new ACComboBoxModelAdapter();
      addIryoInfoBearNameModel();
    }
    return iryoInfoBearNameModel;
  }

  /**
   * �󋋎Ҕԍ����擾���܂��B
   * @return �󋋎Ҕԍ�
   */
  public ACTextField getIryoInfoReceiptNo(){
    if(iryoInfoReceiptNo==null){

      iryoInfoReceiptNo = new ACTextField();

      getIryoInfoReceiptNoContainer().setText("�󋋎Ҕԍ�");

      iryoInfoReceiptNo.setBindPath("KOHI_RECIPIENT_NO");

      iryoInfoReceiptNo.setCharType(VRCharType.ONLY_ALNUM);

      iryoInfoReceiptNo.setColumns(10);

      iryoInfoReceiptNo.setMaxLength(7);

      addIryoInfoReceiptNo();
    }
    return iryoInfoReceiptNo;

  }

  /**
   * �󋋎Ҕԍ��R���e�i���擾���܂��B
   * @return �󋋎Ҕԍ��R���e�i
   */
  protected ACLabelContainer getIryoInfoReceiptNoContainer(){
    if(iryoInfoReceiptNoContainer==null){
      iryoInfoReceiptNoContainer = new ACLabelContainer();
      iryoInfoReceiptNoContainer.setFollowChildEnabled(true);
      iryoInfoReceiptNoContainer.setVAlignment(VRLayout.CENTER);
      iryoInfoReceiptNoContainer.add(getIryoInfoReceiptNo(), null);
    }
    return iryoInfoReceiptNoContainer;
  }

  /**
   * �L�����ԁE�R���e�i���擾���܂��B
   * @return �L�����ԁE�R���e�i
   */
  public ACLabelContainer getIryoInfoValidLimitContena(){
    if(iryoInfoValidLimitContena==null){

      iryoInfoValidLimitContena = new ACLabelContainer();

      iryoInfoValidLimitContena.setText("�L������");

      addIryoInfoValidLimitContena();
    }
    return iryoInfoValidLimitContena;

  }

  /**
   * �L�����ԁE�e�L�X�g1���擾���܂��B
   * @return �L�����ԁE�e�L�X�g1
   */
  public QkanDateTextField getIryoInfoValidLimit1(){
    if(iryoInfoValidLimit1==null){

      iryoInfoValidLimit1 = new QkanDateTextField();

      iryoInfoValidLimit1.setBindPath("KOHI_VALID_START");

      iryoInfoValidLimit1.setColumns(10);

      iryoInfoValidLimit1.setFormat(new ACBorderBlankDateFormat("gggee�NMM��dd��"));

      iryoInfoValidLimit1.setMaxLength(11);

      addIryoInfoValidLimit1();
    }
    return iryoInfoValidLimit1;

  }

  /**
   * �L�����ԁE���x�����擾���܂��B
   * @return �L�����ԁE���x��
   */
  public ACLabel getIryoInfoValidLimitLabel(){
    if(iryoInfoValidLimitLabel==null){

      iryoInfoValidLimitLabel = new ACLabel();

      iryoInfoValidLimitLabel.setText(" ���� ");

      addIryoInfoValidLimitLabel();
    }
    return iryoInfoValidLimitLabel;

  }

  /**
   * �L�����ԁE�e�L�X�g2���擾���܂��B
   * @return �L�����ԁE�e�L�X�g2
   */
  public QkanDateTextField getIryoInfoValidLimit2(){
    if(iryoInfoValidLimit2==null){

      iryoInfoValidLimit2 = new QkanDateTextField();

      iryoInfoValidLimit2.setBindPath("KOHI_VALID_END");

      iryoInfoValidLimit2.setColumns(10);

      iryoInfoValidLimit2.setFormat(new ACBorderBlankDateFormat("gggee�NMM��dd��"));

      iryoInfoValidLimit2.setMaxLength(11);

      addIryoInfoValidLimit2();
    }
    return iryoInfoValidLimit2;

  }

  /**
   * ��Ì���̈�E�{�^�����擾���܂��B
   * @return ��Ì���̈�E�{�^��
   */
  public ACPanel getIryoInfoButtons(){
    if(iryoInfoButtons==null){

      iryoInfoButtons = new ACPanel();

      addIryoInfoButtons();
    }
    return iryoInfoButtons;

  }

  /**
   * �N���A���擾���܂��B
   * @return �N���A
   */
  public ACButton getIryoInfoButtonClear(){
    if(iryoInfoButtonClear==null){

      iryoInfoButtonClear = new ACButton();

      iryoInfoButtonClear.setText("�N���A");

      iryoInfoButtonClear.setToolTipText("��Ì�������N���A���܂��B");

      iryoInfoButtonClear.setIconPath(ACConstants.ICON_PATH_CLEAR_16);

      addIryoInfoButtonClear();
    }
    return iryoInfoButtonClear;

  }

  /**
   * �ǉ����擾���܂��B
   * @return �ǉ�
   */
  public ACButton getIryoInfoButtonInsert(){
    if(iryoInfoButtonInsert==null){

      iryoInfoButtonInsert = new ACButton();

      iryoInfoButtonInsert.setText("�ǉ�");

      iryoInfoButtonInsert.setToolTipText("��Ì������ǉ����܂��B");

      iryoInfoButtonInsert.setIconPath(ACConstants.ICON_PATH_RECORD_DOWNLOAD_16);

      addIryoInfoButtonInsert();
    }
    return iryoInfoButtonInsert;

  }

  /**
   * ���ւ��擾���܂��B
   * @return ����
   */
  public ACButton getIryoInfoButtonConpile(){
    if(iryoInfoButtonConpile==null){

      iryoInfoButtonConpile = new ACButton();

      iryoInfoButtonConpile.setText("����");

      iryoInfoButtonConpile.setToolTipText("��Ì������ҏW���܂��B");

      iryoInfoButtonConpile.setIconPath(ACConstants.ICON_PATH_STATE_UPDATE_16);

      addIryoInfoButtonConpile();
    }
    return iryoInfoButtonConpile;

  }

  /**
   * �폜���擾���܂��B
   * @return �폜
   */
  public ACButton getIryoInfoButtonDelete(){
    if(iryoInfoButtonDelete==null){

      iryoInfoButtonDelete = new ACButton();

      iryoInfoButtonDelete.setText("�폜");

      iryoInfoButtonDelete.setToolTipText("��Ì�������폜���܂��B");

      iryoInfoButtonDelete.setIconPath(ACConstants.ICON_PATH_STATE_DELETE_16);

      addIryoInfoButtonDelete();
    }
    return iryoInfoButtonDelete;

  }

  /**
   * ��Ì���̈�E�e�[�u�����擾���܂��B
   * @return ��Ì���̈�E�e�[�u��
   */
  public ACPanel getIryoInfoTables(){
    if(iryoInfoTables==null){

      iryoInfoTables = new ACPanel();

      addIryoInfoTables();
    }
    return iryoInfoTables;

  }

  /**
   * ��Ì���E�e�[�u�����擾���܂��B
   * @return ��Ì���E�e�[�u��
   */
  public ACTable getIryoInfoTable(){
    if(iryoInfoTable==null){

      iryoInfoTable = new ACTable();

      iryoInfoTable.setColumnModel(getIryoInfoTableColumnModel());

      addIryoInfoTable();
    }
    return iryoInfoTable;

  }

  /**
   * ��Ì���E�e�[�u���J�������f�����擾���܂��B
   * @return ��Ì���E�e�[�u���J�������f��
   */
  protected VRTableColumnModel getIryoInfoTableColumnModel(){
    if(iryoInfoTableColumnModel==null){
      iryoInfoTableColumnModel = new VRTableColumnModel(new TableColumn[]{});
      addIryoInfoTableColumnModel();
    }
    return iryoInfoTableColumnModel;
  }

  /**
   * No.���擾���܂��B
   * @return No.
   */
  public ACTableColumn getIryoInfoTableColumn0(){
    if(iryoInfoTableColumn0==null){

      iryoInfoTableColumn0 = new ACTableColumn(0);

      iryoInfoTableColumn0.setHeaderValue("No.");

      iryoInfoTableColumn0.setColumns(3);

      iryoInfoTableColumn0.setRendererType(ACTableCellViewer.RENDERER_TYPE_SERIAL_NO);

      iryoInfoTableColumn0.setSortable(false);

      addIryoInfoTableColumn0();
    }
    return iryoInfoTableColumn0;

  }

  /**
   * ��������擾���܂��B
   * @return ������
   */
  public ACTableColumn getIryoInfoTableColumn1(){
    if(iryoInfoTableColumn1==null){

      iryoInfoTableColumn1 = new ACTableColumn(0);

      iryoInfoTableColumn1.setHeaderValue("������");

      iryoInfoTableColumn1.setColumns(22);

      addIryoInfoTableColumn1();
    }
    return iryoInfoTableColumn1;

  }

  /**
   * ���t�����擾���܂��B
   * @return ���t��
   */
  public ACTableColumn getIryoInfoTableColumn2(){
    if(iryoInfoTableColumn2==null){

      iryoInfoTableColumn2 = new ACTableColumn(1);

      iryoInfoTableColumn2.setHeaderValue("���t��");

      iryoInfoTableColumn2.setColumns(7);

      iryoInfoTableColumn2.setHorizontalAlignment(SwingConstants.RIGHT);

      addIryoInfoTableColumn2();
    }
    return iryoInfoTableColumn2;

  }

  /**
   * ���S�Ҕԍ����擾���܂��B
   * @return ���S�Ҕԍ�
   */
  public ACTableColumn getIryoInfoTableColumn3(){
    if(iryoInfoTableColumn3==null){

      iryoInfoTableColumn3 = new ACTableColumn(2);

      iryoInfoTableColumn3.setHeaderValue("���S�Ҕԍ�");

      iryoInfoTableColumn3.setColumns(8);

      addIryoInfoTableColumn3();
    }
    return iryoInfoTableColumn3;

  }

  /**
   * �󋋎Ҕԍ����擾���܂��B
   * @return �󋋎Ҕԍ�
   */
  public ACTableColumn getIryoInfoTableColumn5(){
    if(iryoInfoTableColumn5==null){

      iryoInfoTableColumn5 = new ACTableColumn(4);

      iryoInfoTableColumn5.setHeaderValue("�󋋎Ҕԍ�");

      iryoInfoTableColumn5.setColumns(7);

      addIryoInfoTableColumn5();
    }
    return iryoInfoTableColumn5;

  }

  /**
   * �L�����ԊJ�n���擾���܂��B
   * @return �L�����ԊJ�n
   */
  public ACTableColumn getIryoInfoTableColumn6(){
    if(iryoInfoTableColumn6==null){

      iryoInfoTableColumn6 = new ACTableColumn(5);

      iryoInfoTableColumn6.setHeaderValue("�L�����ԊJ�n��");

      iryoInfoTableColumn6.setColumns(12);

      iryoInfoTableColumn6.setFormat(new ACBorderBlankDateFormat("gggee�NMM��dd��"));

      addIryoInfoTableColumn6();
    }
    return iryoInfoTableColumn6;

  }

  /**
   * �L�����ԏI�����擾���܂��B
   * @return �L�����ԏI��
   */
  public ACTableColumn getIryoInfoTableColumn7(){
    if(iryoInfoTableColumn7==null){

      iryoInfoTableColumn7 = new ACTableColumn(6);

      iryoInfoTableColumn7.setHeaderValue("�L�����ԏI����");

      iryoInfoTableColumn7.setColumns(12);

      iryoInfoTableColumn7.setFormat(new ACBorderBlankDateFormat("gggee�NMM��dd��"));

      addIryoInfoTableColumn7();
    }
    return iryoInfoTableColumn7;

  }

  /**
   * ��Ì���̈�E�T�[�r�X���擾���܂��B
   * @return ��Ì���̈�E�T�[�r�X
   */
  public ACPanel getIryoInfoServices(){
    if(iryoInfoServices==null){

      iryoInfoServices = new ACPanel();

      iryoInfoServices.setVisible(false);

      addIryoInfoServices();
    }
    return iryoInfoServices;

  }

  /**
   * �T�[�r�X�E�O���[�v���擾���܂��B
   * @return �T�[�r�X�E�O���[�v
   */
  public ACGroupBox getIryoInfoService(){
    if(iryoInfoService==null){

      iryoInfoService = new ACGroupBox();

      iryoInfoService.setText("���t�ΏۃT�[�r�X");

      addIryoInfoService();
    }
    return iryoInfoService;

  }

  /**
   * ���������x���E��Â��擾���܂��B
   * @return ���������x���E���
   */
  public ACLabel getIryoInfoServiceComment(){
    if(iryoInfoServiceComment==null){

      iryoInfoServiceComment = new ACLabel();

      iryoInfoServiceComment.setText("����̑ΏۂƂȂ�T�[�r�X�Ƀ`�F�b�N�����Ă��������B");

      iryoInfoServiceComment.setIconPath(ACConstants.ICON_PATH_INFORMATION_16);

      addIryoInfoServiceComment();
    }
    return iryoInfoServiceComment;

  }

  /**
   * ��Ì���E�g�p�T�[�r�X�e�[�u�����擾���܂��B
   * @return ��Ì���E�g�p�T�[�r�X�e�[�u��
   */
  public ACTable getIryoInfoServiceTable(){
    if(iryoInfoServiceTable==null){

      iryoInfoServiceTable = new ACTable();

      iryoInfoServiceTable.setColumns(25);

      iryoInfoServiceTable.setColumnModel(getIryoInfoServiceTableColumnModel());

      iryoInfoServiceTable.setColumnSort(false);

      addIryoInfoServiceTable();
    }
    return iryoInfoServiceTable;

  }

  /**
   * ��Ì���E�g�p�T�[�r�X�e�[�u���J�������f�����擾���܂��B
   * @return ��Ì���E�g�p�T�[�r�X�e�[�u���J�������f��
   */
  protected VRTableColumnModel getIryoInfoServiceTableColumnModel(){
    if(iryoInfoServiceTableColumnModel==null){
      iryoInfoServiceTableColumnModel = new VRTableColumnModel(new TableColumn[]{});
      addIryoInfoServiceTableColumnModel();
    }
    return iryoInfoServiceTableColumnModel;
  }

  /**
   * ��F�񋟂��擾���܂��B
   * @return ��F��
   */
  public ACTableColumn getIryoInfoServiceTableColumn1(){
    if(iryoInfoServiceTableColumn1==null){

      iryoInfoServiceTableColumn1 = new ACTableColumn(0);

      iryoInfoServiceTableColumn1.setHeaderValue("��");

      iryoInfoServiceTableColumn1.setEditable(true);

      iryoInfoServiceTableColumn1.setColumns(3);

      iryoInfoServiceTableColumn1.setRendererType(VRTableCellViewer.RENDERER_TYPE_CHECK_BOX);

      iryoInfoServiceTableColumn1.setEditorType(VRTableCellViewer.EDITOR_TYPE_CHECK_BOX);

      addIryoInfoServiceTableColumn1();
    }
    return iryoInfoServiceTableColumn1;

  }

  /**
   * ��F�T�[�r�X��ނ��擾���܂��B
   * @return ��F�T�[�r�X���
   */
  public ACTableColumn getIryoInfoServiceTableColumn2(){
    if(iryoInfoServiceTableColumn2==null){

      iryoInfoServiceTableColumn2 = new ACTableColumn(1);

      iryoInfoServiceTableColumn2.setHeaderValue("�T�[�r�X���");

      iryoInfoServiceTableColumn2.setColumns(10);

      addIryoInfoServiceTableColumn2();
    }
    return iryoInfoServiceTableColumn2;

  }

  /**
   * ��F���[��ނ��擾���܂��B
   * @return ��F���[���
   */
  public ACTableColumn getIryoInfoServiceTableColumn3(){
    if(iryoInfoServiceTableColumn3==null){

      iryoInfoServiceTableColumn3 = new ACTableColumn(2);

      iryoInfoServiceTableColumn3.setHeaderValue("���[���");

      iryoInfoServiceTableColumn3.setColumns(12);

      addIryoInfoServiceTableColumn3();
    }
    return iryoInfoServiceTableColumn3;

  }

  /**
   * �Љ���y���̈���擾���܂��B
   * @return �Љ���y���̈�
   */
  public ACPanel getPoints3(){
    if(points3==null){

      points3 = new ACPanel();

      points3.setLayout(getShahukuLayout());

      addPoints3();
    }
    return points3;

  }

  /**
   * �Љ���y���̈�E���C�A�E�g���擾���܂��B
   * @return �Љ���y���̈�E���C�A�E�g
   */
  public VRLayout getShahukuLayout(){
    if(shahukuLayout==null){

      shahukuLayout = new VRLayout();

      shahukuLayout.setAutoWrap(false);

      addShahukuLayout();
    }
    return shahukuLayout;

  }

  /**
   * �Љ���y���̈�E�����擾���܂��B
   * @return �Љ���y���̈�E���
   */
  public ACPanel getShahukuInfos(){
    if(shahukuInfos==null){

      shahukuInfos = new ACPanel();

      addShahukuInfos();
    }
    return shahukuInfos;

  }

  /**
   * �Љ���y���̈�E���2���擾���܂��B
   * @return �Љ���y���̈�E���2
   */
  public ACPanel getShahukuInfo(){
    if(shahukuInfo==null){

      shahukuInfo = new ACPanel();

      addShahukuInfo();
    }
    return shahukuInfo;

  }

  /**
   * (���z�����E�R���e�i)���擾���܂��B
   * @return (���z�����E�R���e�i)
   */
  public ACLabelContainer getShahukuInfoBenefitRateContena(){
    if(shahukuInfoBenefitRateContena==null){

      shahukuInfoBenefitRateContena = new ACLabelContainer();

      shahukuInfoBenefitRateContena.setText("���z����");

      addShahukuInfoBenefitRateContena();
    }
    return shahukuInfoBenefitRateContena;

  }

  /**
   * ���z�������擾���܂��B
   * @return ���z����
   */
  public ACTextField getShahukuInfoBenefitRate(){
    if(shahukuInfoBenefitRate==null){

      shahukuInfoBenefitRate = new ACTextField();

      shahukuInfoBenefitRate.setBindPath("LOOK");

      shahukuInfoBenefitRate.setColumns(3);

      shahukuInfoBenefitRate.setCharType(VRCharType.ONLY_FLOAT);

      shahukuInfoBenefitRate.setHorizontalAlignment(SwingConstants.RIGHT);

      shahukuInfoBenefitRate.setIMEMode(InputSubset.LATIN);

      shahukuInfoBenefitRate.setMaxLength(4);

      addShahukuInfoBenefitRate();
    }
    return shahukuInfoBenefitRate;

  }

  /**
   * �P�ʃ��x�����擾���܂��B
   * @return �P�ʃ��x��
   */
  public ACLabel getShahukuInfoPercentLabel(){
    if(shahukuInfoPercentLabel==null){

      shahukuInfoPercentLabel = new ACLabel();

      shahukuInfoPercentLabel.setText(" �^100 ");

      addShahukuInfoPercentLabel();
    }
    return shahukuInfoPercentLabel;

  }

  /**
   * �L�����ԁE�R���e�i���擾���܂��B
   * @return �L�����ԁE�R���e�i
   */
  public ACLabelContainer getShahukuInfoValidLimitContena(){
    if(shahukuInfoValidLimitContena==null){

      shahukuInfoValidLimitContena = new ACLabelContainer();

      shahukuInfoValidLimitContena.setText("�L������");

      addShahukuInfoValidLimitContena();
    }
    return shahukuInfoValidLimitContena;

  }

  /**
   * �L�����ԁE�e�L�X�g1���擾���܂��B
   * @return �L�����ԁE�e�L�X�g1
   */
  public QkanDateTextField getShahukuInfoValidLimit1(){
    if(shahukuInfoValidLimit1==null){

      shahukuInfoValidLimit1 = new QkanDateTextField();

      shahukuInfoValidLimit1.setBindPath("KOHI_VALID_START");

      shahukuInfoValidLimit1.setColumns(10);

      shahukuInfoValidLimit1.setFormat(new ACBorderBlankDateFormat("gggee�NMM��dd��"));

      shahukuInfoValidLimit1.setMaxLength(11);

      addShahukuInfoValidLimit1();
    }
    return shahukuInfoValidLimit1;

  }

  /**
   * �L�����ԁE���x�����擾���܂��B
   * @return �L�����ԁE���x��
   */
  public ACLabel getShahukuInfoValidLimitLabel(){
    if(shahukuInfoValidLimitLabel==null){

      shahukuInfoValidLimitLabel = new ACLabel();

      shahukuInfoValidLimitLabel.setText(" ���� ");

      addShahukuInfoValidLimitLabel();
    }
    return shahukuInfoValidLimitLabel;

  }

  /**
   * �L�����ԁE�e�L�X�g2���擾���܂��B
   * @return �L�����ԁE�e�L�X�g2
   */
  public QkanDateTextField getShahukuInfoValidLimit2(){
    if(shahukuInfoValidLimit2==null){

      shahukuInfoValidLimit2 = new QkanDateTextField();

      shahukuInfoValidLimit2.setBindPath("KOHI_VALID_END");

      shahukuInfoValidLimit2.setColumns(10);

      shahukuInfoValidLimit2.setFormat(new ACBorderBlankDateFormat("gggee�NMM��dd��"));

      shahukuInfoValidLimit2.setMaxLength(11);

      addShahukuInfoValidLimit2();
    }
    return shahukuInfoValidLimit2;

  }

  /**
   * �Љ���y���̈�E�{�^�����擾���܂��B
   * @return �Љ���y���̈�E�{�^��
   */
  public ACPanel getShahukuInfoButtons(){
    if(shahukuInfoButtons==null){

      shahukuInfoButtons = new ACPanel();

      addShahukuInfoButtons();
    }
    return shahukuInfoButtons;

  }

  /**
   * �N���A���擾���܂��B
   * @return �N���A
   */
  public ACButton getShahukuInfoButtonClear(){
    if(shahukuInfoButtonClear==null){

      shahukuInfoButtonClear = new ACButton();

      shahukuInfoButtonClear.setText("�N���A");

      shahukuInfoButtonClear.setToolTipText("�Љ���y�������N���A���܂��B");

      shahukuInfoButtonClear.setIconPath(ACConstants.ICON_PATH_CLEAR_16);

      addShahukuInfoButtonClear();
    }
    return shahukuInfoButtonClear;

  }

  /**
   * �ǉ����擾���܂��B
   * @return �ǉ�
   */
  public ACButton getShahukuInfoButtonInsert(){
    if(shahukuInfoButtonInsert==null){

      shahukuInfoButtonInsert = new ACButton();

      shahukuInfoButtonInsert.setText("�ǉ�");

      shahukuInfoButtonInsert.setToolTipText("�Љ���y������ǉ����܂��B");

      shahukuInfoButtonInsert.setIconPath(ACConstants.ICON_PATH_RECORD_DOWNLOAD_16);

      addShahukuInfoButtonInsert();
    }
    return shahukuInfoButtonInsert;

  }

  /**
   * ���ւ��擾���܂��B
   * @return ����
   */
  public ACButton getShahukuInfoButtonConpile(){
    if(shahukuInfoButtonConpile==null){

      shahukuInfoButtonConpile = new ACButton();

      shahukuInfoButtonConpile.setText("����");

      shahukuInfoButtonConpile.setToolTipText("�Љ���y������ҏW���܂��B");

      shahukuInfoButtonConpile.setIconPath(ACConstants.ICON_PATH_STATE_UPDATE_16);

      addShahukuInfoButtonConpile();
    }
    return shahukuInfoButtonConpile;

  }

  /**
   * �폜���擾���܂��B
   * @return �폜
   */
  public ACButton getShahukuInfoButtonDelete(){
    if(shahukuInfoButtonDelete==null){

      shahukuInfoButtonDelete = new ACButton();

      shahukuInfoButtonDelete.setText("�폜");

      shahukuInfoButtonDelete.setToolTipText("�Љ���y�������폜���܂��B");

      shahukuInfoButtonDelete.setIconPath(ACConstants.ICON_PATH_STATE_DELETE_16);

      addShahukuInfoButtonDelete();
    }
    return shahukuInfoButtonDelete;

  }

  /**
   * �Љ���y���̈�E�e�[�u�����擾���܂��B
   * @return �Љ���y���̈�E�e�[�u��
   */
  public ACPanel getShahukuInfoTables(){
    if(shahukuInfoTables==null){

      shahukuInfoTables = new ACPanel();

      addShahukuInfoTables();
    }
    return shahukuInfoTables;

  }

  /**
   * �Љ���y���̈�E�e�[�u�����擾���܂��B
   * @return �Љ���y���̈�E�e�[�u��
   */
  public ACTable getShahukuInfoTable(){
    if(shahukuInfoTable==null){

      shahukuInfoTable = new ACTable();

      shahukuInfoTable.setColumnModel(getShahukuInfoTableColumnModel());

      addShahukuInfoTable();
    }
    return shahukuInfoTable;

  }

  /**
   * �Љ���y���̈�E�e�[�u���J�������f�����擾���܂��B
   * @return �Љ���y���̈�E�e�[�u���J�������f��
   */
  protected VRTableColumnModel getShahukuInfoTableColumnModel(){
    if(shahukuInfoTableColumnModel==null){
      shahukuInfoTableColumnModel = new VRTableColumnModel(new TableColumn[]{});
      addShahukuInfoTableColumnModel();
    }
    return shahukuInfoTableColumnModel;
  }

  /**
   * No.���擾���܂��B
   * @return No.
   */
  public ACTableColumn getShahukuInfoTableColumn0(){
    if(shahukuInfoTableColumn0==null){

      shahukuInfoTableColumn0 = new ACTableColumn(0);

      shahukuInfoTableColumn0.setHeaderValue("No.");

      shahukuInfoTableColumn0.setColumns(3);

      shahukuInfoTableColumn0.setRendererType(ACTableCellViewer.RENDERER_TYPE_SERIAL_NO);

      shahukuInfoTableColumn0.setSortable(false);

      addShahukuInfoTableColumn0();
    }
    return shahukuInfoTableColumn0;

  }

  /**
   * ���t�����擾���܂��B
   * @return ���t��
   */
  public ACTableColumn getShahukuInfoTableColumn1(){
    if(shahukuInfoTableColumn1==null){

      shahukuInfoTableColumn1 = new ACTableColumn(0);

      shahukuInfoTableColumn1.setHeaderValue("���z����");

      shahukuInfoTableColumn1.setColumns(7);

      shahukuInfoTableColumn1.setHorizontalAlignment(SwingConstants.RIGHT);

      addShahukuInfoTableColumn1();
    }
    return shahukuInfoTableColumn1;

  }

  /**
   * �L�����ԊJ�n���擾���܂��B
   * @return �L�����ԊJ�n
   */
  public ACTableColumn getShahukuInfoTableColumn2(){
    if(shahukuInfoTableColumn2==null){

      shahukuInfoTableColumn2 = new ACTableColumn(1);

      shahukuInfoTableColumn2.setHeaderValue("�L�����ԊJ�n��");

      shahukuInfoTableColumn2.setColumns(12);

      shahukuInfoTableColumn2.setFormat(new ACBorderBlankDateFormat("gggee�NMM��dd��"));

      addShahukuInfoTableColumn2();
    }
    return shahukuInfoTableColumn2;

  }

  /**
   * �L�����ԏI�����擾���܂��B
   * @return �L�����ԏI��
   */
  public ACTableColumn getShahukuInfoTableColumn3(){
    if(shahukuInfoTableColumn3==null){

      shahukuInfoTableColumn3 = new ACTableColumn(2);

      shahukuInfoTableColumn3.setHeaderValue("�L�����ԏI����");

      shahukuInfoTableColumn3.setColumns(12);

      shahukuInfoTableColumn3.setFormat(new ACBorderBlankDateFormat("gggee�NMM��dd��"));

      addShahukuInfoTableColumn3();
    }
    return shahukuInfoTableColumn3;

  }

  /**
   * �R���X�g���N�^�ł��B
   */
  public QU004Design() {

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
   * �Ɩ��{�^���o�[�ɓ������ڂ�ǉ����܂��B
   */
  protected void addButtons(){

    buttons.add(getUpdate(), VRLayout.EAST);
    buttons.add(getInsert(), VRLayout.EAST);
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
   * �N���C�A���g�̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addContents(){

    contents.add(getPatientInfo(), VRLayout.NORTH);

    contents.add(getTabs(), VRLayout.CLIENT);

  }

  /**
   * ���p�Җ��̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatientInfo(){

    patientInfo.add(getPatientNameCaption(), VRLayout.FLOW);

    patientInfo.add(getPatientName(), VRLayout.FLOW);

  }

  /**
   * ���p�Җ��L���v�V�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatientNameCaption(){

  }

  /**
   * ���p�Җ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatientName(){

  }

  /**
   * �^�u�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTabs(){

    tabs.addTab("������", getPoints1());

    tabs.addTab("��Ì���", getPoints2());

    tabs.addTab("�Е��y��", getPoints3());

  }

  /**
   * ������̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPoints1(){

    points1.add(getKaigoInfos(), VRLayout.CLIENT);

    points1.add(getKaigoInfoServices(), VRLayout.EAST);
  }

  /**
   * ������̈�E���C�A�E�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoLayout(){

  }

  /**
   * ������̈�E���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoInfos(){

    kaigoInfos.add(getKaigoInfo(), VRLayout.NORTH);

    kaigoInfos.add(getKaigoInfoButtons(), VRLayout.NORTH);

    kaigoInfos.add(getKaigoInfoTables(), VRLayout.CLIENT);

  }

  /**
   * ������̈�E���2�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoInfo(){

    kaigoInfo.add(getKaigoInfoPublicExpenseContainer(), VRLayout.FLOW_INSETLINE);

    kaigoInfo.add(getKaigoInfoBenefitRateContena(), VRLayout.FLOW_INSETLINE_RETURN);

    kaigoInfo.add(getKaigoInfoBearNoContena(), VRLayout.FLOW_INSETLINE);

    kaigoInfo.add(getKaigoInfoBearNameContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    kaigoInfo.add(getKaigoInfoReceiptNoContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    kaigoInfo.add(getKaigoInfoValidLimitContena(), VRLayout.FLOW_INSETLINE);

    kaigoInfo.add(getKaigoInfoSelfPaymentContents(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * ������ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoInfoPublicExpense(){

  }

  /**
   * �����񃂃f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoInfoPublicExpenseModel(){

  }

  /**
   * (���t���E�R���e�i)�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoInfoBenefitRateContena(){

    kaigoInfoBenefitRateContena.add(getKaigoInfoBenefitRate(), VRLayout.FLOW);

    kaigoInfoBenefitRateContena.add(getKaigoInfoPercentLabel(), VRLayout.FLOW);

  }

  /**
   * ���t���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoInfoBenefitRate(){

  }

  /**
   * %���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoInfoPercentLabel(){

  }

  /**
   * (���S�Ҕԍ��E�R���e�i)�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoInfoBearNoContena(){

    kaigoInfoBearNoContena.add(getKaigoInfoKohiNo(), VRLayout.FLOW);

    kaigoInfoBearNoContena.add(getKaigoInfoInsurerNo(), VRLayout.FLOW);

  }

  /**
   * ����@�ʔԍ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoInfoKohiNo(){

  }

  /**
   * �ی��Ҕԍ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoInfoInsurerNo(){

  }

  /**
   * ���S�Җ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoInfoBearName(){

  }

  /**
   * ���S�Җ����f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoInfoBearNameModel(){

  }

  /**
   * �󋋎Ҕԍ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoInfoReceiptNo(){

  }

  /**
   * �L�����ԁE�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoInfoValidLimitContena(){

    kaigoInfoValidLimitContena.add(getKaigoInfoValidLimit1(), VRLayout.FLOW);

    kaigoInfoValidLimitContena.add(getKaigoInfoValidLimitLabel(), VRLayout.FLOW);

    kaigoInfoValidLimitContena.add(getKaigoInfoValidLimit2(), VRLayout.FLOW);

  }

  /**
   * �L�����ԁE�e�L�X�g1�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoInfoValidLimit1(){

  }

  /**
   * �L�����ԁE���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoInfoValidLimitLabel(){

  }

  /**
   * �L�����ԁE�e�L�X�g2�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoInfoValidLimit2(){

  }

  /**
   * (���ȕ��S�z�E�R���e�i)�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoInfoSelfPaymentContents(){

    kaigoInfoSelfPaymentContents.add(getKaigoInfoSelfPayment(), VRLayout.FLOW);

    kaigoInfoSelfPaymentContents.add(getKaigoInfoSelfPaymentYen(), VRLayout.FLOW);

  }

  /**
   * ���ȕ��S�z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoInfoSelfPayment(){

  }

  /**
   * ���ȕ��S�z���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoInfoSelfPaymentYen(){

  }

  /**
   * ������̈�E�{�^���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoInfoButtons(){

    kaigoInfoButtons.add(getKaigoInfoButtonDelete(), VRLayout.EAST);
    kaigoInfoButtons.add(getKaigoInfoButtonConpile(), VRLayout.EAST);
    kaigoInfoButtons.add(getKaigoInfoButtonInsert(), VRLayout.EAST);
    kaigoInfoButtons.add(getKaigoInfoButtonClear(), VRLayout.EAST);
  }

  /**
   * �N���A�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoInfoButtonClear(){

  }

  /**
   * �ǉ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoInfoButtonInsert(){

  }

  /**
   * ���ւɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoInfoButtonConpile(){

  }

  /**
   * �폜�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoInfoButtonDelete(){

  }

  /**
   * ������̈�E�p�l���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoInfoTables(){

    kaigoInfoTables.add(getKaigoInfoTable(), VRLayout.CLIENT);

  }

  /**
   * ������E�e�[�u���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoInfoTable(){

  }

  /**
   * ������E�e�[�u���J�������f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoInfoTableColumnModel(){

    getKaigoInfoTableColumnModel().addColumn(getKaigoInfoTableColumn0());

    getKaigoInfoTableColumnModel().addColumn(getKaigoInfoTableColumn1());

    getKaigoInfoTableColumnModel().addColumn(getKaigoInfoTableColumn2());

    getKaigoInfoTableColumnModel().addColumn(getKaigoInfoTableColumn3());

    getKaigoInfoTableColumnModel().addColumn(getKaigoInfoTableColumn5());

    getKaigoInfoTableColumnModel().addColumn(getKaigoInfoTableColumn6());

    getKaigoInfoTableColumnModel().addColumn(getKaigoInfoTableColumn7());

  }

  /**
   * No.�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoInfoTableColumn0(){

  }

  /**
   * ������ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoInfoTableColumn1(){

  }

  /**
   * ���t���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoInfoTableColumn2(){

  }

  /**
   * ���S�Ҕԍ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoInfoTableColumn3(){

  }

  /**
   * �󋋎Ҕԍ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoInfoTableColumn5(){

  }

  /**
   * �L�����ԊJ�n�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoInfoTableColumn6(){

  }

  /**
   * �L�����ԏI���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoInfoTableColumn7(){

  }

  /**
   * ������̈�E�T�[�r�X�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoInfoServices(){

    kaigoInfoServices.add(getKaigoInfoService(), VRLayout.CLIENT);

  }

  /**
   * �T�[�r�X�E�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoInfoService(){

    kaigoInfoService.add(getKaigoInfoServiceComment(), VRLayout.NORTH);

    kaigoInfoService.add(getKaigoInfoServiceTable(), VRLayout.CLIENT);

  }

  /**
   * ���������x���E���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoInfoServiceComment(){

  }

  /**
   * ����E�g�p�T�[�r�X�e�[�u���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoInfoServiceTable(){

  }

  /**
   * ����E�g�p�T�[�r�X�e�[�u���J�������f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoInfoServiceTableColumnModel(){

    getKaigoInfoServiceTableColumnModel().addColumn(getKaigoInfoServiceTableColumn1());

    getKaigoInfoServiceTableColumnModel().addColumn(getKaigoInfoServiceTableColumn2());

    getKaigoInfoServiceTableColumnModel().addColumn(getKaigoInfoServiceTableColumn3());

  }

  /**
   * ��F�񋟂ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoInfoServiceTableColumn1(){

  }

  /**
   * ��F�T�[�r�X��ނɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoInfoServiceTableColumn2(){

  }

  /**
   * ��F���[��ނɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoInfoServiceTableColumn3(){

  }

  /**
   * ��Ì���̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPoints2(){

    points2.add(getIryoInfos(), VRLayout.CLIENT);

    points2.add(getIryoInfoServices(), VRLayout.EAST);
  }

  /**
   * ��Ì���̈�E���C�A�E�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addIryoLayout(){

  }

  /**
   * ��Ì���̈�E���ɓ������ڂ�ǉ����܂��B
   */
  protected void addIryoInfos(){

    iryoInfos.add(getIryoInfo(), VRLayout.NORTH);

    iryoInfos.add(getIryoInfoButtons(), VRLayout.NORTH);

    iryoInfos.add(getIryoInfoTables(), VRLayout.CLIENT);

  }

  /**
   * ��Ì���̈�E���2�ɓ������ڂ�ǉ����܂��B
   */
  protected void addIryoInfo(){

    iryoInfo.add(getIryoInfoPublicExpenseContainer(), VRLayout.FLOW_INSETLINE);

    iryoInfo.add(getIryoInfoBenefitRateContena(), VRLayout.FLOW_INSETLINE_RETURN);

    iryoInfo.add(getIryoInfoBearNoContena(), VRLayout.FLOW_INSETLINE);

    iryoInfo.add(getIryoInfoBearNameContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    iryoInfo.add(getIryoInfoReceiptNoContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    iryoInfo.add(getIryoInfoValidLimitContena(), VRLayout.FLOW_INSETLINE);

  }

  /**
   * ������ɓ������ڂ�ǉ����܂��B
   */
  protected void addIryoInfoPublicExpense(){

  }

  /**
   * �����񃂃f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addIryoInfoPublicExpenseModel(){

  }

  /**
   * (���t���E�R���e�i)�ɓ������ڂ�ǉ����܂��B
   */
  protected void addIryoInfoBenefitRateContena(){

    iryoInfoBenefitRateContena.add(getIryoInfoBenefitRate(), VRLayout.FLOW);

    iryoInfoBenefitRateContena.add(getIryoInfoPercentLabel(), VRLayout.FLOW);

  }

  /**
   * ���t���ɓ������ڂ�ǉ����܂��B
   */
  protected void addIryoInfoBenefitRate(){

  }

  /**
   * %���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addIryoInfoPercentLabel(){

  }

  /**
   * (���S�Ҕԍ��E�R���e�i)�ɓ������ڂ�ǉ����܂��B
   */
  protected void addIryoInfoBearNoContena(){

    iryoInfoBearNoContena.add(getIryoInfoKohiNo(), VRLayout.FLOW);

    iryoInfoBearNoContena.add(getIryoInfoInsurerNo(), VRLayout.FLOW);

  }

  /**
   * ����@�ʔԍ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addIryoInfoKohiNo(){

  }

  /**
   * �ی��Ҕԍ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addIryoInfoInsurerNo(){

  }

  /**
   * ���S�Җ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addIryoInfoBearName(){

  }

  /**
   * ���S�Җ����f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addIryoInfoBearNameModel(){

  }

  /**
   * �󋋎Ҕԍ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addIryoInfoReceiptNo(){

  }

  /**
   * �L�����ԁE�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addIryoInfoValidLimitContena(){

    iryoInfoValidLimitContena.add(getIryoInfoValidLimit1(), VRLayout.FLOW);

    iryoInfoValidLimitContena.add(getIryoInfoValidLimitLabel(), VRLayout.FLOW);

    iryoInfoValidLimitContena.add(getIryoInfoValidLimit2(), VRLayout.FLOW);

  }

  /**
   * �L�����ԁE�e�L�X�g1�ɓ������ڂ�ǉ����܂��B
   */
  protected void addIryoInfoValidLimit1(){

  }

  /**
   * �L�����ԁE���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addIryoInfoValidLimitLabel(){

  }

  /**
   * �L�����ԁE�e�L�X�g2�ɓ������ڂ�ǉ����܂��B
   */
  protected void addIryoInfoValidLimit2(){

  }

  /**
   * ��Ì���̈�E�{�^���ɓ������ڂ�ǉ����܂��B
   */
  protected void addIryoInfoButtons(){

    iryoInfoButtons.add(getIryoInfoButtonDelete(), VRLayout.EAST);
    iryoInfoButtons.add(getIryoInfoButtonConpile(), VRLayout.EAST);
    iryoInfoButtons.add(getIryoInfoButtonInsert(), VRLayout.EAST);
    iryoInfoButtons.add(getIryoInfoButtonClear(), VRLayout.EAST);
  }

  /**
   * �N���A�ɓ������ڂ�ǉ����܂��B
   */
  protected void addIryoInfoButtonClear(){

  }

  /**
   * �ǉ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addIryoInfoButtonInsert(){

  }

  /**
   * ���ւɓ������ڂ�ǉ����܂��B
   */
  protected void addIryoInfoButtonConpile(){

  }

  /**
   * �폜�ɓ������ڂ�ǉ����܂��B
   */
  protected void addIryoInfoButtonDelete(){

  }

  /**
   * ��Ì���̈�E�e�[�u���ɓ������ڂ�ǉ����܂��B
   */
  protected void addIryoInfoTables(){

    iryoInfoTables.add(getIryoInfoTable(), VRLayout.CLIENT);

  }

  /**
   * ��Ì���E�e�[�u���ɓ������ڂ�ǉ����܂��B
   */
  protected void addIryoInfoTable(){

  }

  /**
   * ��Ì���E�e�[�u���J�������f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addIryoInfoTableColumnModel(){

    getIryoInfoTableColumnModel().addColumn(getIryoInfoTableColumn0());

    getIryoInfoTableColumnModel().addColumn(getIryoInfoTableColumn1());

    getIryoInfoTableColumnModel().addColumn(getIryoInfoTableColumn2());

    getIryoInfoTableColumnModel().addColumn(getIryoInfoTableColumn3());

    getIryoInfoTableColumnModel().addColumn(getIryoInfoTableColumn5());

    getIryoInfoTableColumnModel().addColumn(getIryoInfoTableColumn6());

    getIryoInfoTableColumnModel().addColumn(getIryoInfoTableColumn7());

  }

  /**
   * No.�ɓ������ڂ�ǉ����܂��B
   */
  protected void addIryoInfoTableColumn0(){

  }

  /**
   * ������ɓ������ڂ�ǉ����܂��B
   */
  protected void addIryoInfoTableColumn1(){

  }

  /**
   * ���t���ɓ������ڂ�ǉ����܂��B
   */
  protected void addIryoInfoTableColumn2(){

  }

  /**
   * ���S�Ҕԍ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addIryoInfoTableColumn3(){

  }

  /**
   * �󋋎Ҕԍ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addIryoInfoTableColumn5(){

  }

  /**
   * �L�����ԊJ�n�ɓ������ڂ�ǉ����܂��B
   */
  protected void addIryoInfoTableColumn6(){

  }

  /**
   * �L�����ԏI���ɓ������ڂ�ǉ����܂��B
   */
  protected void addIryoInfoTableColumn7(){

  }

  /**
   * ��Ì���̈�E�T�[�r�X�ɓ������ڂ�ǉ����܂��B
   */
  protected void addIryoInfoServices(){

    iryoInfoServices.add(getIryoInfoService(), VRLayout.CLIENT);

  }

  /**
   * �T�[�r�X�E�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addIryoInfoService(){

    iryoInfoService.add(getIryoInfoServiceComment(), VRLayout.NORTH);

    iryoInfoService.add(getIryoInfoServiceTable(), VRLayout.CLIENT);

  }

  /**
   * ���������x���E��Âɓ������ڂ�ǉ����܂��B
   */
  protected void addIryoInfoServiceComment(){

  }

  /**
   * ��Ì���E�g�p�T�[�r�X�e�[�u���ɓ������ڂ�ǉ����܂��B
   */
  protected void addIryoInfoServiceTable(){

  }

  /**
   * ��Ì���E�g�p�T�[�r�X�e�[�u���J�������f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addIryoInfoServiceTableColumnModel(){

    getIryoInfoServiceTableColumnModel().addColumn(getIryoInfoServiceTableColumn1());

    getIryoInfoServiceTableColumnModel().addColumn(getIryoInfoServiceTableColumn2());

    getIryoInfoServiceTableColumnModel().addColumn(getIryoInfoServiceTableColumn3());

  }

  /**
   * ��F�񋟂ɓ������ڂ�ǉ����܂��B
   */
  protected void addIryoInfoServiceTableColumn1(){

  }

  /**
   * ��F�T�[�r�X��ނɓ������ڂ�ǉ����܂��B
   */
  protected void addIryoInfoServiceTableColumn2(){

  }

  /**
   * ��F���[��ނɓ������ڂ�ǉ����܂��B
   */
  protected void addIryoInfoServiceTableColumn3(){

  }

  /**
   * �Љ���y���̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPoints3(){

    points3.add(getShahukuInfos(), VRLayout.CLIENT);

  }

  /**
   * �Љ���y���̈�E���C�A�E�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShahukuLayout(){

  }

  /**
   * �Љ���y���̈�E���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShahukuInfos(){

    shahukuInfos.add(getShahukuInfo(), VRLayout.NORTH);

    shahukuInfos.add(getShahukuInfoButtons(), VRLayout.NORTH);

    shahukuInfos.add(getShahukuInfoTables(), VRLayout.CLIENT);

  }

  /**
   * �Љ���y���̈�E���2�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShahukuInfo(){

    shahukuInfo.add(getShahukuInfoBenefitRateContena(), VRLayout.FLOW_INSETLINE_RETURN);

    shahukuInfo.add(getShahukuInfoValidLimitContena(), VRLayout.FLOW_INSETLINE);

  }

  /**
   * (���z�����E�R���e�i)�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShahukuInfoBenefitRateContena(){

    shahukuInfoBenefitRateContena.add(getShahukuInfoBenefitRate(), VRLayout.FLOW);

    shahukuInfoBenefitRateContena.add(getShahukuInfoPercentLabel(), VRLayout.FLOW);

  }

  /**
   * ���z�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addShahukuInfoBenefitRate(){

  }

  /**
   * �P�ʃ��x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShahukuInfoPercentLabel(){

  }

  /**
   * �L�����ԁE�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShahukuInfoValidLimitContena(){

    shahukuInfoValidLimitContena.add(getShahukuInfoValidLimit1(), VRLayout.FLOW);

    shahukuInfoValidLimitContena.add(getShahukuInfoValidLimitLabel(), VRLayout.FLOW);

    shahukuInfoValidLimitContena.add(getShahukuInfoValidLimit2(), VRLayout.FLOW);

  }

  /**
   * �L�����ԁE�e�L�X�g1�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShahukuInfoValidLimit1(){

  }

  /**
   * �L�����ԁE���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShahukuInfoValidLimitLabel(){

  }

  /**
   * �L�����ԁE�e�L�X�g2�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShahukuInfoValidLimit2(){

  }

  /**
   * �Љ���y���̈�E�{�^���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShahukuInfoButtons(){

    shahukuInfoButtons.add(getShahukuInfoButtonDelete(), VRLayout.EAST);
    shahukuInfoButtons.add(getShahukuInfoButtonConpile(), VRLayout.EAST);
    shahukuInfoButtons.add(getShahukuInfoButtonInsert(), VRLayout.EAST);
    shahukuInfoButtons.add(getShahukuInfoButtonClear(), VRLayout.EAST);
  }

  /**
   * �N���A�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShahukuInfoButtonClear(){

  }

  /**
   * �ǉ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addShahukuInfoButtonInsert(){

  }

  /**
   * ���ւɓ������ڂ�ǉ����܂��B
   */
  protected void addShahukuInfoButtonConpile(){

  }

  /**
   * �폜�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShahukuInfoButtonDelete(){

  }

  /**
   * �Љ���y���̈�E�e�[�u���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShahukuInfoTables(){

    shahukuInfoTables.add(getShahukuInfoTable(), VRLayout.CLIENT);

  }

  /**
   * �Љ���y���̈�E�e�[�u���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShahukuInfoTable(){

  }

  /**
   * �Љ���y���̈�E�e�[�u���J�������f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShahukuInfoTableColumnModel(){

    getShahukuInfoTableColumnModel().addColumn(getShahukuInfoTableColumn0());

    getShahukuInfoTableColumnModel().addColumn(getShahukuInfoTableColumn1());

    getShahukuInfoTableColumnModel().addColumn(getShahukuInfoTableColumn2());

    getShahukuInfoTableColumnModel().addColumn(getShahukuInfoTableColumn3());

  }

  /**
   * No.�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShahukuInfoTableColumn0(){

  }

  /**
   * ���t���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShahukuInfoTableColumn1(){

  }

  /**
   * �L�����ԊJ�n�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShahukuInfoTableColumn2(){

  }

  /**
   * �L�����ԏI���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShahukuInfoTableColumn3(){

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
      ACFrame.debugStart(new ACAffairInfo(QU004Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QU004Design getThis() {
    return this;
  }
}
