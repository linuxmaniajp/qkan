
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
 * �쐬��: 2011/11/16  ���{�R���s���[�^�[������� �����F �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���p�ҊǗ� (U)
 * �v���Z�X ���p�ғo�^ (004)
 * �v���O���� ����E�Е��y����� (QU004)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qu.qu004;
import java.awt.Component;
import java.awt.im.InputSubset;

import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.table.TableColumn;

import jp.nichicom.ac.ACConstants;
import jp.nichicom.ac.component.ACAffairButton;
import jp.nichicom.ac.component.ACAffairButtonBar;
import jp.nichicom.ac.component.ACButton;
import jp.nichicom.ac.component.ACComboBox;
import jp.nichicom.ac.component.ACLabel;
import jp.nichicom.ac.component.ACTextField;
import jp.nichicom.ac.component.table.ACTable;
import jp.nichicom.ac.component.table.ACTableCellViewer;
import jp.nichicom.ac.component.table.ACTableColumn;
import jp.nichicom.ac.container.ACGroupBox;
import jp.nichicom.ac.container.ACLabelContainer;
import jp.nichicom.ac.container.ACPanel;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACAffairable;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.text.ACBorderBlankDateFormat;
import jp.nichicom.ac.util.adapter.ACComboBoxModelAdapter;
import jp.nichicom.vr.component.table.VRTableCellViewer;
import jp.nichicom.vr.component.table.VRTableColumnModel;
import jp.nichicom.vr.layout.VRLayout;
import jp.nichicom.vr.text.VRCharType;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.affair.QkanAffairContainer;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.component.QkanDateTextField;
/**
 * ����E�Е��y������ʍ��ڃf�U�C��(QU004) 
 */
@SuppressWarnings("serial")
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
