
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
 * �J����: ����@��F
 * �쐬��: 2012/04/12  ���{�R���s���[�^�[������� ����@��F �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���ъm��/�������o�� (P)
 * �v���Z�X �������� (001)
 * �v���O���� ���p�҈ꗗ�i�����j (QP001)
 *
 *****************************************************************
 */
package jp.nichicom.ac.lib.care.claim.calculation;
import java.awt.Component;
import java.awt.im.InputSubset;

import javax.swing.SwingConstants;
import javax.swing.table.TableColumn;

import jp.nichicom.ac.ACCommon;
import jp.nichicom.ac.ACConstants;
import jp.nichicom.ac.component.ACAffairButton;
import jp.nichicom.ac.component.ACAffairButtonBar;
import jp.nichicom.ac.component.ACComboBox;
import jp.nichicom.ac.component.ACIntegerCheckBox;
import jp.nichicom.ac.component.ACLabel;
import jp.nichicom.ac.component.ACTextField;
import jp.nichicom.ac.component.table.ACCheckBoxTableColumnPopupMenu;
import jp.nichicom.ac.component.table.ACTable;
import jp.nichicom.ac.component.table.ACTableCellViewer;
import jp.nichicom.ac.component.table.ACTableColumn;
import jp.nichicom.ac.container.ACGroupBox;
import jp.nichicom.ac.container.ACLabelContainer;
import jp.nichicom.ac.container.ACPanel;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACAffairable;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.text.ACBorderBlankDateFormat;
import jp.nichicom.ac.util.adapter.ACComboBoxModelAdapter;
import jp.nichicom.vr.component.table.VRTableCellViewer;
import jp.nichicom.vr.component.table.VRTableColumnModel;
import jp.nichicom.vr.layout.VRLayout;
import jp.nichicom.vr.text.VRCharType;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanConstants;
import jp.or.med.orca.qkan.affair.QkanAffairContainer;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.component.QkanDateTextField;
import jp.or.med.orca.qkan.component.QkanYearDateTextField;
/**
 * ���p�҈ꗗ�i�����j��ʍ��ڃf�U�C��(QP001) 
 */
public class QP001Design extends QkanAffairContainer implements ACAffairable {
  //GUI�R���|�[�l���g

  private ACAffairButtonBar buttons;

  private ACAffairButton entry;

  private ACAffairButton find;

  private ACAffairButton delete;

  private ACAffairButton printList;

  private ACAffairButton print;

  private ACAffairButton csvOut;

  private ACAffairButton commit;

  private ACPanel contents;

  private ACPanel extractConditions;

  private ACLabel loginProviderInfo;

  private ACGroupBox extractCondition;

  private ACLabelContainer targetDateContena;

  private QkanYearDateTextField targetDate;

  private ACLabel targetDateLabel4;

  private QkanYearDateTextField claimDate;

  private ACLabelContainer claimDateContainer;

  private ACIntegerCheckBox notOutputDistinction;

  private ACLabelContainer insurerContena;

  private ACTextField insurerNoText;

  private ACComboBox insurerNoConbo;

  private ACComboBoxModelAdapter insurerNoConboModel;

  private ACTextField patientCodeText;

  private ACLabelContainer patientCodeTextContainer;

  private ACTextField patientFuriganaText;

  private ACLabelContainer patientFuriganaTextContainer;

  private ACTextField insuredNoText;

  private ACLabelContainer insuredNoTextContainer;

  private ACPanel updateConditions;

  private ACGroupBox updateCondition;

  private QkanYearDateTextField claimDateUpdate;

  private ACLabelContainer claimDateUpdateContainer;

  private ACIntegerCheckBox claimDateUpdateChangePermit;

  private ACPanel printConditions;

  private ACGroupBox printCondition;

  private QkanDateTextField claimDatePrint;

  private ACLabelContainer claimDatePrintContainer;

  private ACPanel typeCountInfomations;

  private ACGroupBox typeCountInfomation;

  private ACTextField supplyCount;

  private ACLabelContainer supplyCountContainer;

  private ACTextField nursingCount;

  private ACLabelContainer nursingCountContainer;

  private ACTextField type7Count;

  private ACLabelContainer type7CountContainer;

  private ACTextField type2Count;

  private ACLabelContainer type2CountContainer;

  private ACTextField type3Count;

  private ACLabelContainer type3CountContainer;

  private ACTextField type4Count;

  private ACLabelContainer type4CountContainer;

  private ACTextField type5Count;

  private ACLabelContainer type5CountContainer;

  private ACTextField type6Count;

  private ACLabelContainer type6CountContainer;

  private ACTextField type8Count;

  private ACLabelContainer type8CountContainer;

  private ACTextField type9Count;

  private ACLabelContainer type9CountContainer;

  private ACTextField type10Count;

  private ACLabelContainer type10CountContainer;

  private ACTextField visitCount;

  private ACLabelContainer visitCountContainer;

  private ACTextField syahoCount;

  private ACLabelContainer syahoCountContainer;

  private ACTextField kokuhoCount;

  private ACLabelContainer kokuhoCountContainer;

  private ACTextField serviceCount;

  private ACLabelContainer serviceCountContainer;

  private ACPanel demandMoneyAndTotalDenominations;

  private ACGroupBox demandMoneyAndTotalDenomination;

  private ACTextField totalDenominationText;

  private ACLabelContainer totalDenominationTextContainer;

  private ACTextField totalMoneyText;

  private ACLabelContainer totalMoneyTextContainer;

  private ACTextField demandMoneyInsuranceMoneyText;

  private ACLabelContainer demandMoneyInsuranceMoneyTextContainer;

  private ACTextField demandMoneyPatientMoneyText;

  private ACLabelContainer demandMoneyPatientMoneyTextContainer;

  private ACTextField totalDenominationPublicExpenseMoneyText;

  private ACLabelContainer totalDenominationPublicExpenseMoneyTextContainer;

  private ACPanel infos;

  private ACTable infoTable;

  private VRTableColumnModel infoTableColumnModel;

  private ACTableColumn infoTableColumn1;

  private ACTableColumn infoTableColumn2;

  private ACTableColumn infoTableColumn3;

  private ACTableColumn infoTableColumn4;

  private ACTableColumn infoTableColumn23;

  private ACTableColumn infoTableColumn5;

  private ACTableColumn infoTableColumn14;

  private ACTableColumn infoTableColumn6;

  private ACTableColumn infoTableColumn7;

  private ACTableColumn infoTableColumn8;

  private ACTableColumn infoTableColumn9;

  private ACTableColumn infoTableColumn10;

  private ACTableColumn infoTableColumn11;

  private ACTableColumn infoTableColumn12;

  private ACTableColumn infoTableColumn13;

  private ACTableColumn infoTableColumn15;

  private ACTableColumn infoTableColumn16;

  private ACTableColumn infoTableColumn17;

  private ACTableColumn infoTableColumn18;

  private ACTableColumn infoTableColumn19;

  private ACTableColumn infoTableColumn20;

  private ACTableColumn infoTableColumn21;

  private ACTableColumn infoTableColumn22;

  //getter

  /**
   * �Ɩ��{�^���o�[���擾���܂��B
   * @return �Ɩ��{�^���o�[
   */
  public ACAffairButtonBar getButtons(){
    if(buttons==null){

      buttons = new ACAffairButtonBar();

      buttons.setText("���p�҈ꗗ");

      addButtons();
    }
    return buttons;

  }

  /**
   * �ڍׂ��擾���܂��B
   * @return �ڍ�
   */
  public ACAffairButton getEntry(){
    if(entry==null){

      entry = new ACAffairButton();

      entry.setText("�ڍ�(E)");

      entry.setToolTipText("�m�F�E�C����ʂ�\�����܂��B");

      entry.setMnemonic('E');

      entry.setIconPath(ACConstants.ICON_PATH_DETAIL_24);

      addEntry();
    }
    return entry;

  }

  /**
   * �����{�^�����擾���܂��B
   * @return �����{�^��
   */
  public ACAffairButton getFind(){
    if(find==null){

      find = new ACAffairButton();

      find.setText("����(F)");

      find.setToolTipText("���p�҂��������܂��B");

      find.setMnemonic('F');

      find.setIconPath(ACConstants.ICON_PATH_FIND_24);

      addFind();
    }
    return find;

  }

  /**
   * �폜�{�^�����擾���܂��B
   * @return �폜�{�^��
   */
  public ACAffairButton getDelete(){
    if(delete==null){

      delete = new ACAffairButton();

      delete.setText("�폜(D)");

      delete.setToolTipText("���������폜���܂��B");

      delete.setMnemonic('D');

      delete.setIconPath(ACConstants.ICON_PATH_DELETE_24);

      addDelete();
    }
    return delete;

  }

  /**
   * �ꗗ������擾���܂��B
   * @return �ꗗ���
   */
  public ACAffairButton getPrintList(){
    if(printList==null){

      printList = new ACAffairButton();

      printList.setText("�ꗗ���(L)");

      printList.setToolTipText("���p�҈ꗗ�\��������܂��B");

      printList.setMnemonic('L');

      printList.setIconPath(ACConstants.ICON_PATH_TABLE_PRINT_24);

      addPrintList();
    }
    return printList;

  }

  /**
   * ����{�^�����擾���܂��B
   * @return ����{�^��
   */
  public ACAffairButton getPrint(){
    if(print==null){

      print = new ACAffairButton();

      print.setText("���(P)");

      print.setToolTipText("��������s���܂��B");

      print.setMnemonic('P');

      print.setIconPath(ACConstants.ICON_PATH_PRINT_24);

      addPrint();
    }
    return print;

  }

  /**
   * CSV�o�̓{�^�����擾���܂��B
   * @return CSV�o�̓{�^��
   */
  public ACAffairButton getCsvOut(){
    if(csvOut==null){

      csvOut = new ACAffairButton();

      csvOut.setText("CSV�쐬(M)");

      csvOut.setToolTipText("CSV�o�͂��s���܂��B");

      csvOut.setMnemonic('M');

      csvOut.setIconPath(ACConstants.ICON_PATH_EXPORT_24);

      addCsvOut();
    }
    return csvOut;

  }

  /**
   * ���ъm����擾���܂��B
   * @return ���ъm��
   */
  public ACAffairButton getCommit(){
    if(commit==null){

      commit = new ACAffairButton();

      commit.setText("���ъm��(T)");

      commit.setToolTipText("���яW�v���s���܂��B");

      commit.setMnemonic('T');

      commit.setIconPath(ACConstants.ICON_PATH_CALC_24);

      addCommit();
    }
    return commit;

  }

  /**
   * ���̈���擾���܂��B
   * @return ���̈�
   */
  public ACPanel getContents(){
    if(contents==null){

      contents = new ACPanel();

      addContents();
    }
    return contents;

  }

  /**
   * ���o�����̈���擾���܂��B
   * @return ���o�����̈�
   */
  public ACPanel getExtractConditions(){
    if(extractConditions==null){

      extractConditions = new ACPanel();

      addExtractConditions();
    }
    return extractConditions;

  }

  /**
   * ���O�C�����Ə����擾���܂��B
   * @return ���O�C�����Ə�
   */
  public ACLabel getLoginProviderInfo(){
    if(loginProviderInfo==null){

      loginProviderInfo = new ACLabel();

      loginProviderInfo.setText("���O�C�����Ə� �Ɋւ���W�v�E�����������s�Ȃ��܂��B���̎��Ə���ΏۂƂ���ꍇ�́A���O�A�E�g���s�����Ə���I�����Ȃ����Ă��������B");

      loginProviderInfo.setIconPath(ACConstants.ICON_PATH_INFORMATION_16);

      loginProviderInfo.setAutoWrap(true);

      addLoginProviderInfo();
    }
    return loginProviderInfo;

  }

  /**
   * ���o�����̈�E�t���[�����擾���܂��B
   * @return ���o�����̈�E�t���[��
   */
  public ACGroupBox getExtractCondition(){
    if(extractCondition==null){

      extractCondition = new ACGroupBox();

      extractCondition.setText("���o����");

      extractCondition.setAutoWrap(false);

      extractCondition.setHgap(0);

      addExtractCondition();
    }
    return extractCondition;

  }

  /**
   * �Ώ۔N���E�R���e�i���擾���܂��B
   * @return �Ώ۔N���E�R���e�i
   */
  public ACLabelContainer getTargetDateContena(){
    if(targetDateContena==null){

      targetDateContena = new ACLabelContainer();

      targetDateContena.setText("�Ώ۔N��");

      addTargetDateContena();
    }
    return targetDateContena;

  }

  /**
   * �Ώ۔N�����擾���܂��B
   * @return �Ώ۔N��
   */
  public QkanYearDateTextField getTargetDate(){
    if(targetDate==null){

      targetDate = new QkanYearDateTextField();

      targetDate.setBindPath("REST_TARGET_DATE");

      try{
        targetDate.setMinimumDate(ACCastUtilities.toDate("2012/04/01"));
      }catch(Throwable ex){
        ACCommon.getInstance().showExceptionMessage(new IllegalArgumentException("targetDate �̍ŏ��N�����ɕs���ȓ��t���w�肳��Ă��܂��B"));
      }

      addTargetDate();
    }
    return targetDate;

  }

  /**
   * �Ώ۔N���E���x��(�x���擾���܂��B
   * @return �Ώ۔N���E���x��(�x
   */
  public ACLabel getTargetDateLabel4(){
    if(targetDateLabel4==null){

      targetDateLabel4 = new ACLabel();

      targetDateLabel4.setText("�x");

      addTargetDateLabel4();
    }
    return targetDateLabel4;

  }

  /**
   * �����N���E�e�L�X�g���擾���܂��B
   * @return �����N���E�e�L�X�g
   */
  public QkanYearDateTextField getClaimDate(){
    if(claimDate==null){

      claimDate = new QkanYearDateTextField();

      getClaimDateContainer().setText("�����N��");

      claimDate.setBindPath("CLAIM_TARGET_DATE");

      addClaimDate();
    }
    return claimDate;

  }

  /**
   * �����N���E�e�L�X�g�R���e�i���擾���܂��B
   * @return �����N���E�e�L�X�g�R���e�i
   */
  protected ACLabelContainer getClaimDateContainer(){
    if(claimDateContainer==null){
      claimDateContainer = new ACLabelContainer();
      claimDateContainer.setFollowChildEnabled(true);
      claimDateContainer.setVAlignment(VRLayout.CENTER);
      claimDateContainer.add(getClaimDate(), null);
    }
    return claimDateContainer;
  }

  /**
   * ���o�͔��ʃ`�F�b�N�{�b�N�X���擾���܂��B
   * @return ���o�͔��ʃ`�F�b�N�{�b�N�X
   */
  public ACIntegerCheckBox getNotOutputDistinction(){
    if(notOutputDistinction==null){

      notOutputDistinction = new ACIntegerCheckBox();

      notOutputDistinction.setText("���o�̗͂��p�҂�����\��(V)");

      notOutputDistinction.setBindPath("NOT_OUTPUT");

      notOutputDistinction.setMnemonic('V');

      addNotOutputDistinction();
    }
    return notOutputDistinction;

  }

  /**
   * �ی��Ҕԍ��E�R���e�i���擾���܂��B
   * @return �ی��Ҕԍ��E�R���e�i
   */
  public ACLabelContainer getInsurerContena(){
    if(insurerContena==null){

      insurerContena = new ACLabelContainer();

      insurerContena.setText("�ی��Ҕԍ�");

      addInsurerContena();
    }
    return insurerContena;

  }

  /**
   * �ی��Ҕԍ��E�e�L�X�g���擾���܂��B
   * @return �ی��Ҕԍ��E�e�L�X�g
   */
  public ACTextField getInsurerNoText(){
    if(insurerNoText==null){

      insurerNoText = new ACTextField();

      insurerNoText.setBindPath("INSURER_TEXT");

      insurerNoText.setColumns(6);

      insurerNoText.setCharType(VRCharType.ONLY_DIGIT);

      insurerNoText.setIMEMode(InputSubset.LATIN);

      insurerNoText.setMaxLength(6);

      addInsurerNoText();
    }
    return insurerNoText;

  }

  /**
   * �ی��Ҕԍ��E�R���{���擾���܂��B
   * @return �ی��Ҕԍ��E�R���{
   */
  public ACComboBox getInsurerNoConbo(){
    if(insurerNoConbo==null){

      insurerNoConbo = new ACComboBox();

      insurerNoConbo.setBindPath("INSURER_COMBO");

      insurerNoConbo.setEditable(false);

      insurerNoConbo.setModel(getInsurerNoConboModel());

      addInsurerNoConbo();
    }
    return insurerNoConbo;

  }

  /**
   * �ی��Ҕԍ��E�R���{���f�����擾���܂��B
   * @return �ی��Ҕԍ��E�R���{���f��
   */
  protected ACComboBoxModelAdapter getInsurerNoConboModel(){
    if(insurerNoConboModel==null){
      insurerNoConboModel = new ACComboBoxModelAdapter();
      addInsurerNoConboModel();
    }
    return insurerNoConboModel;
  }

  /**
   * ���p�҃R�[�h�E�e�L�X�g���擾���܂��B
   * @return ���p�҃R�[�h�E�e�L�X�g
   */
  public ACTextField getPatientCodeText(){
    if(patientCodeText==null){

      patientCodeText = new ACTextField();

      getPatientCodeTextContainer().setText("���p�҃R�[�h");

      patientCodeText.setBindPath("PATIENT_CODE_TEXT");

      patientCodeText.setColumns(15);

      patientCodeText.setCharType(VRCharType.ONLY_HALF_CHAR);

      patientCodeText.setIMEMode(InputSubset.LATIN);

      patientCodeText.setMaxLength(15);

      addPatientCodeText();
    }
    return patientCodeText;

  }

  /**
   * ���p�҃R�[�h�E�e�L�X�g�R���e�i���擾���܂��B
   * @return ���p�҃R�[�h�E�e�L�X�g�R���e�i
   */
  protected ACLabelContainer getPatientCodeTextContainer(){
    if(patientCodeTextContainer==null){
      patientCodeTextContainer = new ACLabelContainer();
      patientCodeTextContainer.setFollowChildEnabled(true);
      patientCodeTextContainer.setVAlignment(VRLayout.CENTER);
      patientCodeTextContainer.add(getPatientCodeText(), null);
    }
    return patientCodeTextContainer;
  }

  /**
   * ���p�҂ӂ肪�ȁE�e�L�X�g���擾���܂��B
   * @return ���p�҂ӂ肪�ȁE�e�L�X�g
   */
  public ACTextField getPatientFuriganaText(){
    if(patientFuriganaText==null){

      patientFuriganaText = new ACTextField();

      getPatientFuriganaTextContainer().setText("���p�҂ӂ肪��");

      patientFuriganaText.setBindPath("PATIENT_NAME_KN");

      patientFuriganaText.setColumns(40);

      patientFuriganaText.setIMEMode(InputSubset.KANJI);

      patientFuriganaText.setMaxLength(40);

      addPatientFuriganaText();
    }
    return patientFuriganaText;

  }

  /**
   * ���p�҂ӂ肪�ȁE�e�L�X�g�R���e�i���擾���܂��B
   * @return ���p�҂ӂ肪�ȁE�e�L�X�g�R���e�i
   */
  protected ACLabelContainer getPatientFuriganaTextContainer(){
    if(patientFuriganaTextContainer==null){
      patientFuriganaTextContainer = new ACLabelContainer();
      patientFuriganaTextContainer.setFollowChildEnabled(true);
      patientFuriganaTextContainer.setVAlignment(VRLayout.CENTER);
      patientFuriganaTextContainer.add(getPatientFuriganaText(), null);
    }
    return patientFuriganaTextContainer;
  }

  /**
   * ��ی��Ҕԍ��E�e�L�X�g���擾���܂��B
   * @return ��ی��Ҕԍ��E�e�L�X�g
   */
  public ACTextField getInsuredNoText(){
    if(insuredNoText==null){

      insuredNoText = new ACTextField();

      getInsuredNoTextContainer().setText("��ی��Ҕԍ�");

      insuredNoText.setBindPath("INSURED_ID_TEXT");

      insuredNoText.setColumns(10);

      insuredNoText.setCharType(VRCharType.ONLY_DIGIT);

      insuredNoText.setIMEMode(InputSubset.LATIN);

      insuredNoText.setMaxLength(10);

      addInsuredNoText();
    }
    return insuredNoText;

  }

  /**
   * ��ی��Ҕԍ��E�e�L�X�g�R���e�i���擾���܂��B
   * @return ��ی��Ҕԍ��E�e�L�X�g�R���e�i
   */
  protected ACLabelContainer getInsuredNoTextContainer(){
    if(insuredNoTextContainer==null){
      insuredNoTextContainer = new ACLabelContainer();
      insuredNoTextContainer.setFollowChildEnabled(true);
      insuredNoTextContainer.setVAlignment(VRLayout.CENTER);
      insuredNoTextContainer.add(getInsuredNoText(), null);
    }
    return insuredNoTextContainer;
  }

  /**
   * �o�^�����̈���擾���܂��B
   * @return �o�^�����̈�
   */
  public ACPanel getUpdateConditions(){
    if(updateConditions==null){

      updateConditions = new ACPanel();

      addUpdateConditions();
    }
    return updateConditions;

  }

  /**
   * �o�^�����̈�E�t���[�����擾���܂��B
   * @return �o�^�����̈�E�t���[��
   */
  public ACGroupBox getUpdateCondition(){
    if(updateCondition==null){

      updateCondition = new ACGroupBox();

      updateCondition.setText("�o�^����");

      addUpdateCondition();
    }
    return updateCondition;

  }

  /**
   * �����N���E�e�L�X�g(�o�^�p)���擾���܂��B
   * @return �����N���E�e�L�X�g(�o�^�p)
   */
  public QkanYearDateTextField getClaimDateUpdate(){
    if(claimDateUpdate==null){

      claimDateUpdate = new QkanYearDateTextField();

      getClaimDateUpdateContainer().setText("�����N��");

      claimDateUpdate.setBindPath("CLAIM_UPDATE_DATE");

      try{
        claimDateUpdate.setMinimumDate(ACCastUtilities.toDate("2012/04/01"));
      }catch(Throwable ex){
        ACCommon.getInstance().showExceptionMessage(new IllegalArgumentException("claimDateUpdate �̍ŏ��N�����ɕs���ȓ��t���w�肳��Ă��܂��B"));
      }

      addClaimDateUpdate();
    }
    return claimDateUpdate;

  }

  /**
   * �����N���E�e�L�X�g(�o�^�p)�R���e�i���擾���܂��B
   * @return �����N���E�e�L�X�g(�o�^�p)�R���e�i
   */
  protected ACLabelContainer getClaimDateUpdateContainer(){
    if(claimDateUpdateContainer==null){
      claimDateUpdateContainer = new ACLabelContainer();
      claimDateUpdateContainer.setFollowChildEnabled(true);
      claimDateUpdateContainer.setVAlignment(VRLayout.CENTER);
      claimDateUpdateContainer.add(getClaimDateUpdate(), null);
    }
    return claimDateUpdateContainer;
  }

  /**
   * �����N���ύX���`�F�b�N�{�b�N�X���擾���܂��B
   * @return �����N���ύX���`�F�b�N�{�b�N�X
   */
  public ACIntegerCheckBox getClaimDateUpdateChangePermit(){
    if(claimDateUpdateChangePermit==null){

      claimDateUpdateChangePermit = new ACIntegerCheckBox();

      claimDateUpdateChangePermit.setText("�����N����ύX����(C)");

      claimDateUpdateChangePermit.setMnemonic('C');

      addClaimDateUpdateChangePermit();
    }
    return claimDateUpdateChangePermit;

  }

  /**
   * ��������̈���擾���܂��B
   * @return ��������̈�
   */
  public ACPanel getPrintConditions(){
    if(printConditions==null){

      printConditions = new ACPanel();

      addPrintConditions();
    }
    return printConditions;

  }

  /**
   * ��������̈�E�t���[�����擾���܂��B
   * @return ��������̈�E�t���[��
   */
  public ACGroupBox getPrintCondition(){
    if(printCondition==null){

      printCondition = new ACGroupBox();

      printCondition.setText("�������");

      addPrintCondition();
    }
    return printCondition;

  }

  /**
   * ���������t���擾���܂��B
   * @return ���������t
   */
  public QkanDateTextField getClaimDatePrint(){
    if(claimDatePrint==null){

      claimDatePrint = new QkanDateTextField();

      getClaimDatePrintContainer().setText("���������t");

      claimDatePrint.setBindPath("CLAIM_PRINT_DATE");

      claimDatePrint.setColumns(10);

      addClaimDatePrint();
    }
    return claimDatePrint;

  }

  /**
   * ���������t�R���e�i���擾���܂��B
   * @return ���������t�R���e�i
   */
  protected ACLabelContainer getClaimDatePrintContainer(){
    if(claimDatePrintContainer==null){
      claimDatePrintContainer = new ACLabelContainer();
      claimDatePrintContainer.setFollowChildEnabled(true);
      claimDatePrintContainer.setVAlignment(VRLayout.CENTER);
      claimDatePrintContainer.add(getClaimDatePrint(), null);
    }
    return claimDatePrintContainer;
  }

  /**
   * �l���������̈���擾���܂��B
   * @return �l���������̈�
   */
  public ACPanel getTypeCountInfomations(){
    if(typeCountInfomations==null){

      typeCountInfomations = new ACPanel();

      addTypeCountInfomations();
    }
    return typeCountInfomations;

  }

  /**
   * �l���������̈�E�t���[�����擾���܂��B
   * @return �l���������̈�E�t���[��
   */
  public ACGroupBox getTypeCountInfomation(){
    if(typeCountInfomation==null){

      typeCountInfomation = new ACGroupBox();

      typeCountInfomation.setText("�l��");

      addTypeCountInfomation();
    }
    return typeCountInfomation;

  }

  /**
   * ���t�Ǘ��[�E�e�L�X�g���擾���܂��B
   * @return ���t�Ǘ��[�E�e�L�X�g
   */
  public ACTextField getSupplyCount(){
    if(supplyCount==null){

      supplyCount = new ACTextField();

      getSupplyCountContainer().setText("���t�Ǘ��[����");

      supplyCount.setColumns(3);

      supplyCount.setEditable(false);

      addSupplyCount();
    }
    return supplyCount;

  }

  /**
   * ���t�Ǘ��[�E�e�L�X�g�R���e�i���擾���܂��B
   * @return ���t�Ǘ��[�E�e�L�X�g�R���e�i
   */
  protected ACLabelContainer getSupplyCountContainer(){
    if(supplyCountContainer==null){
      supplyCountContainer = new ACLabelContainer();
      supplyCountContainer.setFollowChildEnabled(true);
      supplyCountContainer.setVAlignment(VRLayout.CENTER);
      supplyCountContainer.add(getSupplyCount(), null);
    }
    return supplyCountContainer;
  }

  /**
   * ��싋�t������E�e�L�X�g���擾���܂��B
   * @return ��싋�t������E�e�L�X�g
   */
  public ACTextField getNursingCount(){
    if(nursingCount==null){

      nursingCount = new ACTextField();

      getNursingCountContainer().setText("��싋�t���������");

      nursingCount.setColumns(3);

      nursingCount.setEditable(false);

      addNursingCount();
    }
    return nursingCount;

  }

  /**
   * ��싋�t������E�e�L�X�g�R���e�i���擾���܂��B
   * @return ��싋�t������E�e�L�X�g�R���e�i
   */
  protected ACLabelContainer getNursingCountContainer(){
    if(nursingCountContainer==null){
      nursingCountContainer = new ACLabelContainer();
      nursingCountContainer.setFollowChildEnabled(true);
      nursingCountContainer.setVAlignment(VRLayout.CENTER);
      nursingCountContainer.add(getNursingCount(), null);
    }
    return nursingCountContainer;
  }

  /**
   * �l���掵�E�e�L�X�g���擾���܂��B
   * @return �l���掵�E�e�L�X�g
   */
  public ACTextField getType7Count(){
    if(type7Count==null){

      type7Count = new ACTextField();

      getType7CountContainer().setText("�l���掵����");

      type7Count.setBindPath("STYLE_7");

      type7Count.setColumns(3);

      type7Count.setEditable(false);

      addType7Count();
    }
    return type7Count;

  }

  /**
   * �l���掵�E�e�L�X�g�R���e�i���擾���܂��B
   * @return �l���掵�E�e�L�X�g�R���e�i
   */
  protected ACLabelContainer getType7CountContainer(){
    if(type7CountContainer==null){
      type7CountContainer = new ACLabelContainer();
      type7CountContainer.setFollowChildEnabled(true);
      type7CountContainer.setVAlignment(VRLayout.CENTER);
      type7CountContainer.add(getType7Count(), null);
    }
    return type7CountContainer;
  }

  /**
   * �l�����E�e�L�X�g���擾���܂��B
   * @return �l�����E�e�L�X�g
   */
  public ACTextField getType2Count(){
    if(type2Count==null){

      type2Count = new ACTextField();

      getType2CountContainer().setText("�l����񌏐�");

      type2Count.setBindPath("STYLE_2");

      type2Count.setColumns(3);

      type2Count.setEditable(false);

      addType2Count();
    }
    return type2Count;

  }

  /**
   * �l�����E�e�L�X�g�R���e�i���擾���܂��B
   * @return �l�����E�e�L�X�g�R���e�i
   */
  protected ACLabelContainer getType2CountContainer(){
    if(type2CountContainer==null){
      type2CountContainer = new ACLabelContainer();
      type2CountContainer.setFollowChildEnabled(true);
      type2CountContainer.setVAlignment(VRLayout.CENTER);
      type2CountContainer.add(getType2Count(), null);
    }
    return type2CountContainer;
  }

  /**
   * �l����O�E�e�L�X�g���擾���܂��B
   * @return �l����O�E�e�L�X�g
   */
  public ACTextField getType3Count(){
    if(type3Count==null){

      type3Count = new ACTextField();

      getType3CountContainer().setText("�l����O����");

      type3Count.setBindPath("STYLE_3");

      type3Count.setColumns(3);

      type3Count.setEditable(false);

      addType3Count();
    }
    return type3Count;

  }

  /**
   * �l����O�E�e�L�X�g�R���e�i���擾���܂��B
   * @return �l����O�E�e�L�X�g�R���e�i
   */
  protected ACLabelContainer getType3CountContainer(){
    if(type3CountContainer==null){
      type3CountContainer = new ACLabelContainer();
      type3CountContainer.setFollowChildEnabled(true);
      type3CountContainer.setVAlignment(VRLayout.CENTER);
      type3CountContainer.add(getType3Count(), null);
    }
    return type3CountContainer;
  }

  /**
   * �l����l�E�e�L�X�g���擾���܂��B
   * @return �l����l�E�e�L�X�g
   */
  public ACTextField getType4Count(){
    if(type4Count==null){

      type4Count = new ACTextField();

      getType4CountContainer().setText("�l����l����");

      type4Count.setBindPath("STYLE_4");

      type4Count.setColumns(3);

      type4Count.setEditable(false);

      addType4Count();
    }
    return type4Count;

  }

  /**
   * �l����l�E�e�L�X�g�R���e�i���擾���܂��B
   * @return �l����l�E�e�L�X�g�R���e�i
   */
  protected ACLabelContainer getType4CountContainer(){
    if(type4CountContainer==null){
      type4CountContainer = new ACLabelContainer();
      type4CountContainer.setFollowChildEnabled(true);
      type4CountContainer.setVAlignment(VRLayout.CENTER);
      type4CountContainer.add(getType4Count(), null);
    }
    return type4CountContainer;
  }

  /**
   * �l����܁E�e�L�X�g���擾���܂��B
   * @return �l����܁E�e�L�X�g
   */
  public ACTextField getType5Count(){
    if(type5Count==null){

      type5Count = new ACTextField();

      getType5CountContainer().setText("�l����܌���");

      type5Count.setBindPath("STYLE_5");

      type5Count.setColumns(3);

      type5Count.setEditable(false);

      addType5Count();
    }
    return type5Count;

  }

  /**
   * �l����܁E�e�L�X�g�R���e�i���擾���܂��B
   * @return �l����܁E�e�L�X�g�R���e�i
   */
  protected ACLabelContainer getType5CountContainer(){
    if(type5CountContainer==null){
      type5CountContainer = new ACLabelContainer();
      type5CountContainer.setFollowChildEnabled(true);
      type5CountContainer.setVAlignment(VRLayout.CENTER);
      type5CountContainer.add(getType5Count(), null);
    }
    return type5CountContainer;
  }

  /**
   * �l����Z�E�e�L�X�g���擾���܂��B
   * @return �l����Z�E�e�L�X�g
   */
  public ACTextField getType6Count(){
    if(type6Count==null){

      type6Count = new ACTextField();

      getType6CountContainer().setText("�l����Z����");

      type6Count.setBindPath("STYLE_6");

      type6Count.setColumns(3);

      type6Count.setEditable(false);

      addType6Count();
    }
    return type6Count;

  }

  /**
   * �l����Z�E�e�L�X�g�R���e�i���擾���܂��B
   * @return �l����Z�E�e�L�X�g�R���e�i
   */
  protected ACLabelContainer getType6CountContainer(){
    if(type6CountContainer==null){
      type6CountContainer = new ACLabelContainer();
      type6CountContainer.setFollowChildEnabled(true);
      type6CountContainer.setVAlignment(VRLayout.CENTER);
      type6CountContainer.add(getType6Count(), null);
    }
    return type6CountContainer;
  }

  /**
   * �l���攪�E�e�L�X�g���擾���܂��B
   * @return �l���攪�E�e�L�X�g
   */
  public ACTextField getType8Count(){
    if(type8Count==null){

      type8Count = new ACTextField();

      getType8CountContainer().setText("�l���攪����");

      type8Count.setBindPath("STYLE_8");

      type8Count.setColumns(3);

      type8Count.setEditable(false);

      addType8Count();
    }
    return type8Count;

  }

  /**
   * �l���攪�E�e�L�X�g�R���e�i���擾���܂��B
   * @return �l���攪�E�e�L�X�g�R���e�i
   */
  protected ACLabelContainer getType8CountContainer(){
    if(type8CountContainer==null){
      type8CountContainer = new ACLabelContainer();
      type8CountContainer.setFollowChildEnabled(true);
      type8CountContainer.setVAlignment(VRLayout.CENTER);
      type8CountContainer.add(getType8Count(), null);
    }
    return type8CountContainer;
  }

  /**
   * �l�����E�e�L�X�g���擾���܂��B
   * @return �l�����E�e�L�X�g
   */
  public ACTextField getType9Count(){
    if(type9Count==null){

      type9Count = new ACTextField();

      getType9CountContainer().setText("�l����㌏��");

      type9Count.setBindPath("STYLE_9");

      type9Count.setColumns(3);

      type9Count.setEditable(false);

      addType9Count();
    }
    return type9Count;

  }

  /**
   * �l�����E�e�L�X�g�R���e�i���擾���܂��B
   * @return �l�����E�e�L�X�g�R���e�i
   */
  protected ACLabelContainer getType9CountContainer(){
    if(type9CountContainer==null){
      type9CountContainer = new ACLabelContainer();
      type9CountContainer.setFollowChildEnabled(true);
      type9CountContainer.setVAlignment(VRLayout.CENTER);
      type9CountContainer.add(getType9Count(), null);
    }
    return type9CountContainer;
  }

  /**
   * �l����\�E�e�L�X�g���擾���܂��B
   * @return �l����\�E�e�L�X�g
   */
  public ACTextField getType10Count(){
    if(type10Count==null){

      type10Count = new ACTextField();

      getType10CountContainer().setText("�l����\����");

      type10Count.setBindPath("STYLE_10");

      type10Count.setColumns(3);

      type10Count.setEditable(false);

      addType10Count();
    }
    return type10Count;

  }

  /**
   * �l����\�E�e�L�X�g�R���e�i���擾���܂��B
   * @return �l����\�E�e�L�X�g�R���e�i
   */
  protected ACLabelContainer getType10CountContainer(){
    if(type10CountContainer==null){
      type10CountContainer = new ACLabelContainer();
      type10CountContainer.setFollowChildEnabled(true);
      type10CountContainer.setVAlignment(VRLayout.CENTER);
      type10CountContainer.add(getType10Count(), null);
    }
    return type10CountContainer;
  }

  /**
   * �K��Ō�×{��׏��E�e�L�X�g���擾���܂��B
   * @return �K��Ō�×{��׏��E�e�L�X�g
   */
  public ACTextField getVisitCount(){
    if(visitCount==null){

      visitCount = new ACTextField();

      getVisitCountContainer().setText("�K��Ō�×{��׏�����");

      visitCount.setColumns(3);

      visitCount.setEditable(false);

      addVisitCount();
    }
    return visitCount;

  }

  /**
   * �K��Ō�×{��׏��E�e�L�X�g�R���e�i���擾���܂��B
   * @return �K��Ō�×{��׏��E�e�L�X�g�R���e�i
   */
  protected ACLabelContainer getVisitCountContainer(){
    if(visitCountContainer==null){
      visitCountContainer = new ACLabelContainer();
      visitCountContainer.setFollowChildEnabled(true);
      visitCountContainer.setVAlignment(VRLayout.CENTER);
      visitCountContainer.add(getVisitCount(), null);
    }
    return visitCountContainer;
  }

  /**
   * �K��Ō�×{�����(�Еې���)�E�e�L�X�g���擾���܂��B
   * @return �K��Ō�×{�����(�Еې���)�E�e�L�X�g
   */
  public ACTextField getSyahoCount(){
    if(syahoCount==null){

      syahoCount = new ACTextField();

      getSyahoCountContainer().setText("�K��Ō�×{�����(�Еې���)����");

      syahoCount.setColumns(3);

      syahoCount.setEditable(false);

      addSyahoCount();
    }
    return syahoCount;

  }

  /**
   * �K��Ō�×{�����(�Еې���)�E�e�L�X�g�R���e�i���擾���܂��B
   * @return �K��Ō�×{�����(�Еې���)�E�e�L�X�g�R���e�i
   */
  protected ACLabelContainer getSyahoCountContainer(){
    if(syahoCountContainer==null){
      syahoCountContainer = new ACLabelContainer();
      syahoCountContainer.setFollowChildEnabled(true);
      syahoCountContainer.setVAlignment(VRLayout.CENTER);
      syahoCountContainer.add(getSyahoCount(), null);
    }
    return syahoCountContainer;
  }

  /**
   * �K��Ō�×{�����(���ې���)�E�e�L�X�g���擾���܂��B
   * @return �K��Ō�×{�����(���ې���)�E�e�L�X�g
   */
  public ACTextField getKokuhoCount(){
    if(kokuhoCount==null){

      kokuhoCount = new ACTextField();

      getKokuhoCountContainer().setText("�K��Ō�×{�����(���ې���)����");

      kokuhoCount.setColumns(3);

      kokuhoCount.setEditable(false);

      addKokuhoCount();
    }
    return kokuhoCount;

  }

  /**
   * �K��Ō�×{�����(���ې���)�E�e�L�X�g�R���e�i���擾���܂��B
   * @return �K��Ō�×{�����(���ې���)�E�e�L�X�g�R���e�i
   */
  protected ACLabelContainer getKokuhoCountContainer(){
    if(kokuhoCountContainer==null){
      kokuhoCountContainer = new ACLabelContainer();
      kokuhoCountContainer.setFollowChildEnabled(true);
      kokuhoCountContainer.setVAlignment(VRLayout.CENTER);
      kokuhoCountContainer.add(getKokuhoCount(), null);
    }
    return kokuhoCountContainer;
  }

  /**
   * ���T�[�r�X���p�������E�e�L�X�g���擾���܂��B
   * @return ���T�[�r�X���p�������E�e�L�X�g
   */
  public ACTextField getServiceCount(){
    if(serviceCount==null){

      serviceCount = new ACTextField();

      getServiceCountContainer().setText("���T�[�r�X���p����������");

      serviceCount.setColumns(3);

      serviceCount.setEditable(false);

      addServiceCount();
    }
    return serviceCount;

  }

  /**
   * ���T�[�r�X���p�������E�e�L�X�g�R���e�i���擾���܂��B
   * @return ���T�[�r�X���p�������E�e�L�X�g�R���e�i
   */
  protected ACLabelContainer getServiceCountContainer(){
    if(serviceCountContainer==null){
      serviceCountContainer = new ACLabelContainer();
      serviceCountContainer.setFollowChildEnabled(true);
      serviceCountContainer.setVAlignment(VRLayout.CENTER);
      serviceCountContainer.add(getServiceCount(), null);
    }
    return serviceCountContainer;
  }

  /**
   * �����z�E���v�P�ʗ̈���擾���܂��B
   * @return �����z�E���v�P�ʗ̈�
   */
  public ACPanel getDemandMoneyAndTotalDenominations(){
    if(demandMoneyAndTotalDenominations==null){

      demandMoneyAndTotalDenominations = new ACPanel();

      addDemandMoneyAndTotalDenominations();
    }
    return demandMoneyAndTotalDenominations;

  }

  /**
   * �����z�E���v�P�ʗ̈�E�t���[�����擾���܂��B
   * @return �����z�E���v�P�ʗ̈�E�t���[��
   */
  public ACGroupBox getDemandMoneyAndTotalDenomination(){
    if(demandMoneyAndTotalDenomination==null){

      demandMoneyAndTotalDenomination = new ACGroupBox();

      demandMoneyAndTotalDenomination.setText("���v");

      demandMoneyAndTotalDenomination.setAutoWrap(false);

      demandMoneyAndTotalDenomination.setHgrid(100);

      addDemandMoneyAndTotalDenomination();
    }
    return demandMoneyAndTotalDenomination;

  }

  /**
   * ���v�P�ʐ��E�e�L�X�g���擾���܂��B
   * @return ���v�P�ʐ��E�e�L�X�g
   */
  public ACTextField getTotalDenominationText(){
    if(totalDenominationText==null){

      totalDenominationText = new ACTextField();

      getTotalDenominationTextContainer().setText("���v�P�ʐ�");

      totalDenominationText.setColumns(10);

      totalDenominationText.setHorizontalAlignment(SwingConstants.RIGHT);

      totalDenominationText.setIMEMode(InputSubset.LATIN);

      totalDenominationText.setMaxLength(10);

      totalDenominationText.setEditable(false);

      addTotalDenominationText();
    }
    return totalDenominationText;

  }

  /**
   * ���v�P�ʐ��E�e�L�X�g�R���e�i���擾���܂��B
   * @return ���v�P�ʐ��E�e�L�X�g�R���e�i
   */
  protected ACLabelContainer getTotalDenominationTextContainer(){
    if(totalDenominationTextContainer==null){
      totalDenominationTextContainer = new ACLabelContainer();
      totalDenominationTextContainer.setFollowChildEnabled(true);
      totalDenominationTextContainer.setVAlignment(VRLayout.CENTER);
      totalDenominationTextContainer.add(getTotalDenominationText(), null);
    }
    return totalDenominationTextContainer;
  }

  /**
   * ���v���z�E�e�L�X�g���擾���܂��B
   * @return ���v���z�E�e�L�X�g
   */
  public ACTextField getTotalMoneyText(){
    if(totalMoneyText==null){

      totalMoneyText = new ACTextField();

      getTotalMoneyTextContainer().setText("���v���z");

      totalMoneyText.setColumns(10);

      totalMoneyText.setHorizontalAlignment(SwingConstants.RIGHT);

      totalMoneyText.setIMEMode(InputSubset.LATIN);

      totalMoneyText.setMaxLength(10);

      totalMoneyText.setEditable(false);

      addTotalMoneyText();
    }
    return totalMoneyText;

  }

  /**
   * ���v���z�E�e�L�X�g�R���e�i���擾���܂��B
   * @return ���v���z�E�e�L�X�g�R���e�i
   */
  protected ACLabelContainer getTotalMoneyTextContainer(){
    if(totalMoneyTextContainer==null){
      totalMoneyTextContainer = new ACLabelContainer();
      totalMoneyTextContainer.setFollowChildEnabled(true);
      totalMoneyTextContainer.setVAlignment(VRLayout.CENTER);
      totalMoneyTextContainer.add(getTotalMoneyText(), null);
    }
    return totalMoneyTextContainer;
  }

  /**
   * �ی������z�E�e�L�X�g���擾���܂��B
   * @return �ی������z�E�e�L�X�g
   */
  public ACTextField getDemandMoneyInsuranceMoneyText(){
    if(demandMoneyInsuranceMoneyText==null){

      demandMoneyInsuranceMoneyText = new ACTextField();

      getDemandMoneyInsuranceMoneyTextContainer().setText("�ی������z");

      demandMoneyInsuranceMoneyText.setColumns(10);

      demandMoneyInsuranceMoneyText.setHorizontalAlignment(SwingConstants.RIGHT);

      demandMoneyInsuranceMoneyText.setIMEMode(InputSubset.LATIN);

      demandMoneyInsuranceMoneyText.setMaxLength(10);

      demandMoneyInsuranceMoneyText.setEditable(false);

      addDemandMoneyInsuranceMoneyText();
    }
    return demandMoneyInsuranceMoneyText;

  }

  /**
   * �ی������z�E�e�L�X�g�R���e�i���擾���܂��B
   * @return �ی������z�E�e�L�X�g�R���e�i
   */
  protected ACLabelContainer getDemandMoneyInsuranceMoneyTextContainer(){
    if(demandMoneyInsuranceMoneyTextContainer==null){
      demandMoneyInsuranceMoneyTextContainer = new ACLabelContainer();
      demandMoneyInsuranceMoneyTextContainer.setFollowChildEnabled(true);
      demandMoneyInsuranceMoneyTextContainer.setVAlignment(VRLayout.CENTER);
      demandMoneyInsuranceMoneyTextContainer.add(getDemandMoneyInsuranceMoneyText(), null);
    }
    return demandMoneyInsuranceMoneyTextContainer;
  }

  /**
   * ���p�ҕ��S�z�E�e�L�X�g���擾���܂��B
   * @return ���p�ҕ��S�z�E�e�L�X�g
   */
  public ACTextField getDemandMoneyPatientMoneyText(){
    if(demandMoneyPatientMoneyText==null){

      demandMoneyPatientMoneyText = new ACTextField();

      getDemandMoneyPatientMoneyTextContainer().setText("���p�Ґ����z");

      demandMoneyPatientMoneyText.setColumns(10);

      demandMoneyPatientMoneyText.setHorizontalAlignment(SwingConstants.RIGHT);

      demandMoneyPatientMoneyText.setIMEMode(InputSubset.LATIN);

      demandMoneyPatientMoneyText.setMaxLength(10);

      demandMoneyPatientMoneyText.setEditable(false);

      addDemandMoneyPatientMoneyText();
    }
    return demandMoneyPatientMoneyText;

  }

  /**
   * ���p�ҕ��S�z�E�e�L�X�g�R���e�i���擾���܂��B
   * @return ���p�ҕ��S�z�E�e�L�X�g�R���e�i
   */
  protected ACLabelContainer getDemandMoneyPatientMoneyTextContainer(){
    if(demandMoneyPatientMoneyTextContainer==null){
      demandMoneyPatientMoneyTextContainer = new ACLabelContainer();
      demandMoneyPatientMoneyTextContainer.setFollowChildEnabled(true);
      demandMoneyPatientMoneyTextContainer.setVAlignment(VRLayout.CENTER);
      demandMoneyPatientMoneyTextContainer.add(getDemandMoneyPatientMoneyText(), null);
    }
    return demandMoneyPatientMoneyTextContainer;
  }

  /**
   * ������z�E�e�L�X�g���擾���܂��B
   * @return ������z�E�e�L�X�g
   */
  public ACTextField getTotalDenominationPublicExpenseMoneyText(){
    if(totalDenominationPublicExpenseMoneyText==null){

      totalDenominationPublicExpenseMoneyText = new ACTextField();

      getTotalDenominationPublicExpenseMoneyTextContainer().setText("������z");

      totalDenominationPublicExpenseMoneyText.setColumns(10);

      totalDenominationPublicExpenseMoneyText.setHorizontalAlignment(SwingConstants.RIGHT);

      totalDenominationPublicExpenseMoneyText.setIMEMode(InputSubset.LATIN);

      totalDenominationPublicExpenseMoneyText.setMaxLength(10);

      totalDenominationPublicExpenseMoneyText.setEditable(false);

      addTotalDenominationPublicExpenseMoneyText();
    }
    return totalDenominationPublicExpenseMoneyText;

  }

  /**
   * ������z�E�e�L�X�g�R���e�i���擾���܂��B
   * @return ������z�E�e�L�X�g�R���e�i
   */
  protected ACLabelContainer getTotalDenominationPublicExpenseMoneyTextContainer(){
    if(totalDenominationPublicExpenseMoneyTextContainer==null){
      totalDenominationPublicExpenseMoneyTextContainer = new ACLabelContainer();
      totalDenominationPublicExpenseMoneyTextContainer.setFollowChildEnabled(true);
      totalDenominationPublicExpenseMoneyTextContainer.setVAlignment(VRLayout.CENTER);
      totalDenominationPublicExpenseMoneyTextContainer.add(getTotalDenominationPublicExpenseMoneyText(), null);
    }
    return totalDenominationPublicExpenseMoneyTextContainer;
  }

  /**
   * ���e�[�u���̈���擾���܂��B
   * @return ���e�[�u���̈�
   */
  public ACPanel getInfos(){
    if(infos==null){

      infos = new ACPanel();

      addInfos();
    }
    return infos;

  }

  /**
   * ���e�[�u�����擾���܂��B
   * @return ���e�[�u��
   */
  public ACTable getInfoTable(){
    if(infoTable==null){

      infoTable = new ACTable();

      infoTable.setColumnModel(getInfoTableColumnModel());

      addInfoTable();
    }
    return infoTable;

  }

  /**
   * ���e�[�u���J�������f�����擾���܂��B
   * @return ���e�[�u���J�������f��
   */
  protected VRTableColumnModel getInfoTableColumnModel(){
    if(infoTableColumnModel==null){
      infoTableColumnModel = new VRTableColumnModel(new TableColumn[]{});
      addInfoTableColumnModel();
    }
    return infoTableColumnModel;
  }

  /**
   * �m�����擾���܂��B
   * @return �m��
   */
  public ACTableColumn getInfoTableColumn1(){
    if(infoTableColumn1==null){

      infoTableColumn1 = new ACTableColumn();

      infoTableColumn1.setHeaderValue("No");

      infoTableColumn1.setColumnName("NO");

      infoTableColumn1.setColumns(3);

      infoTableColumn1.setHorizontalAlignment(SwingConstants.CENTER);

      infoTableColumn1.setRendererType(ACTableCellViewer.RENDERER_TYPE_SERIAL_NO);

      infoTableColumn1.setSortable(false);

      addInfoTableColumn1();
    }
    return infoTableColumn1;

  }

  /**
   * ����ς݃t���O(����擾���܂��B
   * @return ����ς݃t���O(��
   */
  public ACTableColumn getInfoTableColumn2(){
    if(infoTableColumn2==null){

      infoTableColumn2 = new ACTableColumn();

      infoTableColumn2.setHeaderValue("���");

      infoTableColumn2.setColumnName("PRINT");

      infoTableColumn2.setColumns(4);

      addInfoTableColumn2();
    }
    return infoTableColumn2;

  }

  /**
   * �I��(����擾���܂��B
   * @return �I��(��
   */
  public ACTableColumn getInfoTableColumn3(){
    if(infoTableColumn3==null){

      infoTableColumn3 = new ACTableColumn();

      infoTableColumn3.setHeaderValue("�I��");

      infoTableColumn3.setColumnName("CHOISE");

      infoTableColumn3.setEditable(true);

      infoTableColumn3.setColumns(4);

      infoTableColumn3.setHorizontalAlignment(SwingConstants.CENTER);

      infoTableColumn3.setRendererType(VRTableCellViewer.RENDERER_TYPE_CHECK_BOX);

      infoTableColumn3.setEditorType(VRTableCellViewer.EDITOR_TYPE_CHECK_BOX);

      infoTableColumn3.setHeaderPopupMenu( new ACCheckBoxTableColumnPopupMenu(getInfoTable(), "CHOISE", new Boolean(true), new Boolean(false)) );

      addInfoTableColumn3();
    }
    return infoTableColumn3;

  }

  /**
   * �폜(����擾���܂��B
   * @return �폜(��
   */
  public ACTableColumn getInfoTableColumn4(){
    if(infoTableColumn4==null){

      infoTableColumn4 = new ACTableColumn();

      infoTableColumn4.setHeaderValue("�폜");

      infoTableColumn4.setColumnName("DELETE");

      infoTableColumn4.setEditable(true);

      infoTableColumn4.setColumns(4);

      infoTableColumn4.setHorizontalAlignment(SwingConstants.CENTER);

      infoTableColumn4.setRendererType(VRTableCellViewer.RENDERER_TYPE_CHECK_BOX);

      infoTableColumn4.setEditorType(VRTableCellViewer.EDITOR_TYPE_CHECK_BOX);

      infoTableColumn4.setHeaderPopupMenu( new ACCheckBoxTableColumnPopupMenu(getInfoTable(), "DELETE", new Boolean(true), new Boolean(false)) );

      addInfoTableColumn4();
    }
    return infoTableColumn4;

  }

  /**
   * �敪(����擾���܂��B
   * @return �敪(��
   */
  public ACTableColumn getInfoTableColumn23(){
    if(infoTableColumn23==null){

      infoTableColumn23 = new ACTableColumn();

      infoTableColumn23.setHeaderValue("�敪");

      infoTableColumn23.setColumnName("KUBUN");

      infoTableColumn23.setEditable(true);

      infoTableColumn23.setColumns(4);

      infoTableColumn23.setEditorType(VRTableCellViewer.EDITOR_TYPE_COMBO_BOX);

      infoTableColumn23.setComponentEditable(false);

      addInfoTableColumn23();
    }
    return infoTableColumn23;

  }

  /**
   * �N���x(����擾���܂��B
   * @return �N���x(��
   */
  public ACTableColumn getInfoTableColumn5(){
    if(infoTableColumn5==null){

      infoTableColumn5 = new ACTableColumn();

      infoTableColumn5.setHeaderValue("�N���x");

      infoTableColumn5.setColumnName("TARGET_DATE");

      infoTableColumn5.setColumns(8);

      infoTableColumn5.setFormat(new ACBorderBlankDateFormat("gggee�NMM��"));

      addInfoTableColumn5();
    }
    return infoTableColumn5;

  }

  /**
   * �l��(����擾���܂��B
   * @return �l��(��
   */
  public ACTableColumn getInfoTableColumn14(){
    if(infoTableColumn14==null){

      infoTableColumn14 = new ACTableColumn();

      infoTableColumn14.setHeaderValue("�l��");

      infoTableColumn14.setColumnName("CLAIM_STYLE_TYPE");

      infoTableColumn14.setColumns(8);

      addInfoTableColumn14();
    }
    return infoTableColumn14;

  }

  /**
   * �ی��Ҕԍ�(����擾���܂��B
   * @return �ی��Ҕԍ�(��
   */
  public ACTableColumn getInfoTableColumn6(){
    if(infoTableColumn6==null){

      infoTableColumn6 = new ACTableColumn();

      infoTableColumn6.setHeaderValue("�ی��Ҕԍ�");

      infoTableColumn6.setColumnName("INSURER_ID");

      infoTableColumn6.setColumns(8);

      addInfoTableColumn6();
    }
    return infoTableColumn6;

  }

  /**
   * �ی��Җ���(����擾���܂��B
   * @return �ی��Җ���(��
   */
  public ACTableColumn getInfoTableColumn7(){
    if(infoTableColumn7==null){

      infoTableColumn7 = new ACTableColumn();

      infoTableColumn7.setHeaderValue("�ی��Җ���");

      infoTableColumn7.setColumnName("INSURER_NAME");

      infoTableColumn7.setColumns(10);

      addInfoTableColumn7();
    }
    return infoTableColumn7;

  }

  /**
   * ���p�҃R�[�h(����擾���܂��B
   * @return ���p�҃R�[�h(��
   */
  public ACTableColumn getInfoTableColumn8(){
    if(infoTableColumn8==null){

      infoTableColumn8 = new ACTableColumn();

      infoTableColumn8.setHeaderValue("���p�҃R�[�h");

      infoTableColumn8.setColumnName("PATIENT_CODE");

      infoTableColumn8.setColumns(10);

      addInfoTableColumn8();
    }
    return infoTableColumn8;

  }

  /**
   * ��ی��Ҕԍ�(����擾���܂��B
   * @return ��ی��Ҕԍ�(��
   */
  public ACTableColumn getInfoTableColumn9(){
    if(infoTableColumn9==null){

      infoTableColumn9 = new ACTableColumn();

      infoTableColumn9.setHeaderValue("��ی��Ҕԍ�");

      infoTableColumn9.setColumnName("INSURED_ID");

      infoTableColumn9.setColumns(10);

      addInfoTableColumn9();
    }
    return infoTableColumn9;

  }

  /**
   * ���p�Ҏ���(����擾���܂��B
   * @return ���p�Ҏ���(��
   */
  public ACTableColumn getInfoTableColumn10(){
    if(infoTableColumn10==null){

      infoTableColumn10 = new ACTableColumn();

      infoTableColumn10.setHeaderValue("���p�Ҏ���");

      infoTableColumn10.setColumnName("PATIENT_NAME");

      infoTableColumn10.setColumns(10);

      addInfoTableColumn10();
    }
    return infoTableColumn10;

  }

  /**
   * �ӂ肪��(����擾���܂��B
   * @return �ӂ肪��(��
   */
  public ACTableColumn getInfoTableColumn11(){
    if(infoTableColumn11==null){

      infoTableColumn11 = new ACTableColumn();

      infoTableColumn11.setHeaderValue("�ӂ肪��");

      infoTableColumn11.setColumnName("PATIENT_KANA");

      infoTableColumn11.setColumns(10);

      addInfoTableColumn11();
    }
    return infoTableColumn11;

  }

  /**
   * ����(����擾���܂��B
   * @return ����(��
   */
  public ACTableColumn getInfoTableColumn12(){
    if(infoTableColumn12==null){

      infoTableColumn12 = new ACTableColumn();

      infoTableColumn12.setHeaderValue("����");

      infoTableColumn12.setColumnName("PATIENT_SEX");

      infoTableColumn12.setColumns(3);

      infoTableColumn12.setFormat(QkanConstants.FORMAT_SEX);

      addInfoTableColumn12();
    }
    return infoTableColumn12;

  }

  /**
   * �N��(����擾���܂��B
   * @return �N��(��
   */
  public ACTableColumn getInfoTableColumn13(){
    if(infoTableColumn13==null){

      infoTableColumn13 = new ACTableColumn();

      infoTableColumn13.setHeaderValue("�N��");

      infoTableColumn13.setColumnName("PATIENT_BIRTHDAY");

      infoTableColumn13.setColumns(4);

      infoTableColumn13.setFormat(QkanConstants.FORMAT_NOW_AGE);

      addInfoTableColumn13();
    }
    return infoTableColumn13;

  }

  /**
   * �v���x(����擾���܂��B
   * @return �v���x(��
   */
  public ACTableColumn getInfoTableColumn15(){
    if(infoTableColumn15==null){

      infoTableColumn15 = new ACTableColumn();

      infoTableColumn15.setHeaderValue("�v���x");

      infoTableColumn15.setColumnName("JOTAI_CODE");

      infoTableColumn15.setColumns(5);

      addInfoTableColumn15();
    }
    return infoTableColumn15;

  }

  /**
   * �ی��敪(����擾���܂��B
   * @return �ی��敪(��
   */
  public ACTableColumn getInfoTableColumn16(){
    if(infoTableColumn16==null){

      infoTableColumn16 = new ACTableColumn();

      infoTableColumn16.setHeaderValue("�ی��敪");

      infoTableColumn16.setColumnName("INSURE_TYPE");

      infoTableColumn16.setColumns(5);

      addInfoTableColumn16();
    }
    return infoTableColumn16;

  }

  /**
   * �v��P��(����擾���܂��B
   * @return �v��P��(��
   */
  public ACTableColumn getInfoTableColumn17(){
    if(infoTableColumn17==null){

      infoTableColumn17 = new ACTableColumn();

      infoTableColumn17.setHeaderValue("�v��P��");

      infoTableColumn17.setColumnName("PLAN_RATE");

      infoTableColumn17.setColumns(6);

      infoTableColumn17.setHorizontalAlignment(SwingConstants.RIGHT);

      addInfoTableColumn17();
    }
    return infoTableColumn17;

  }

  /**
   * �T�[�r�X�P��(����擾���܂��B
   * @return �T�[�r�X�P��(��
   */
  public ACTableColumn getInfoTableColumn18(){
    if(infoTableColumn18==null){

      infoTableColumn18 = new ACTableColumn();

      infoTableColumn18.setHeaderValue("�T�[�r�X�P��");

      infoTableColumn18.setColumnName("SERVICE_UNIT");

      infoTableColumn18.setColumns(8);

      infoTableColumn18.setHorizontalAlignment(SwingConstants.RIGHT);

      addInfoTableColumn18();
    }
    return infoTableColumn18;

  }

  /**
   * �T�[�r�X���v���z(����擾���܂��B
   * @return �T�[�r�X���v���z(��
   */
  public ACTableColumn getInfoTableColumn19(){
    if(infoTableColumn19==null){

      infoTableColumn19 = new ACTableColumn();

      infoTableColumn19.setHeaderValue("�T�[�r�X���v���z");

      infoTableColumn19.setColumnName("SERVICE_TOTAL");

      infoTableColumn19.setColumns(9);

      infoTableColumn19.setHorizontalAlignment(SwingConstants.RIGHT);

      addInfoTableColumn19();
    }
    return infoTableColumn19;

  }

  /**
   * �ی������z(����擾���܂��B
   * @return �ی������z(��
   */
  public ACTableColumn getInfoTableColumn20(){
    if(infoTableColumn20==null){

      infoTableColumn20 = new ACTableColumn();

      infoTableColumn20.setHeaderValue("�ی������z");

      infoTableColumn20.setColumnName("HOKEN");

      infoTableColumn20.setColumns(6);

      infoTableColumn20.setHorizontalAlignment(SwingConstants.RIGHT);

      addInfoTableColumn20();
    }
    return infoTableColumn20;

  }

  /**
   * ����S�z(����擾���܂��B
   * @return ����S�z(��
   */
  public ACTableColumn getInfoTableColumn21(){
    if(infoTableColumn21==null){

      infoTableColumn21 = new ACTableColumn();

      infoTableColumn21.setHeaderValue("����S�z");

      infoTableColumn21.setColumnName("KOUHI");

      infoTableColumn21.setColumns(6);

      infoTableColumn21.setHorizontalAlignment(SwingConstants.RIGHT);

      addInfoTableColumn21();
    }
    return infoTableColumn21;

  }

  /**
   * ���p�ҕ��S�z(����擾���܂��B
   * @return ���p�ҕ��S�z(��
   */
  public ACTableColumn getInfoTableColumn22(){
    if(infoTableColumn22==null){

      infoTableColumn22 = new ACTableColumn();

      infoTableColumn22.setHeaderValue("���p�ҕ��S�z");

      infoTableColumn22.setColumnName("RIYOUSYA");

      infoTableColumn22.setColumns(8);

      infoTableColumn22.setHorizontalAlignment(SwingConstants.RIGHT);

      addInfoTableColumn22();
    }
    return infoTableColumn22;

  }

  /**
   * �R���X�g���N�^�ł��B
   */
  public QP001Design() {

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

    buttons.add(getCommit(), VRLayout.EAST);
    buttons.add(getCsvOut(), VRLayout.EAST);
    buttons.add(getPrint(), VRLayout.EAST);
    buttons.add(getPrintList(), VRLayout.EAST);
    buttons.add(getDelete(), VRLayout.EAST);
    buttons.add(getFind(), VRLayout.EAST);
    buttons.add(getEntry(), VRLayout.EAST);
  }

  /**
   * �ڍׂɓ������ڂ�ǉ����܂��B
   */
  protected void addEntry(){

  }

  /**
   * �����{�^���ɓ������ڂ�ǉ����܂��B
   */
  protected void addFind(){

  }

  /**
   * �폜�{�^���ɓ������ڂ�ǉ����܂��B
   */
  protected void addDelete(){

  }

  /**
   * �ꗗ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addPrintList(){

  }

  /**
   * ����{�^���ɓ������ڂ�ǉ����܂��B
   */
  protected void addPrint(){

  }

  /**
   * CSV�o�̓{�^���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCsvOut(){

  }

  /**
   * ���ъm��ɓ������ڂ�ǉ����܂��B
   */
  protected void addCommit(){

  }

  /**
   * ���̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addContents(){

    contents.add(getExtractConditions(), VRLayout.NORTH);

    contents.add(getUpdateConditions(), VRLayout.NORTH);

    contents.add(getPrintConditions(), VRLayout.NORTH);

    contents.add(getTypeCountInfomations(), VRLayout.NORTH);

    contents.add(getDemandMoneyAndTotalDenominations(), VRLayout.NORTH);

    contents.add(getInfos(), VRLayout.CLIENT);

  }

  /**
   * ���o�����̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addExtractConditions(){

    extractConditions.add(getLoginProviderInfo(), VRLayout.NORTH);

    extractConditions.add(getExtractCondition(), VRLayout.NORTH);

  }

  /**
   * ���O�C�����Ə��ɓ������ڂ�ǉ����܂��B
   */
  protected void addLoginProviderInfo(){

  }

  /**
   * ���o�����̈�E�t���[���ɓ������ڂ�ǉ����܂��B
   */
  protected void addExtractCondition(){

    extractCondition.add(getTargetDateContena(), VRLayout.FLOW);

    extractCondition.add(getClaimDateContainer(), VRLayout.FLOW);

    extractCondition.add(getNotOutputDistinction(), VRLayout.FLOW_RETURN);

    extractCondition.add(getInsurerContena(), VRLayout.FLOW_INSETLINE_RETURN);

    extractCondition.add(getPatientCodeTextContainer(), VRLayout.FLOW_INSETLINE);

    extractCondition.add(getPatientFuriganaTextContainer(), VRLayout.FLOW_INSETLINE);

    extractCondition.add(getInsuredNoTextContainer(), VRLayout.FLOW_INSETLINE);

  }

  /**
   * �Ώ۔N���E�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTargetDateContena(){

    targetDateContena.add(getTargetDate(), null);

    targetDateContena.add(getTargetDateLabel4(), VRLayout.FLOW);

  }

  /**
   * �Ώ۔N���ɓ������ڂ�ǉ����܂��B
   */
  protected void addTargetDate(){

  }

  /**
   * �Ώ۔N���E���x��(�x�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTargetDateLabel4(){

  }

  /**
   * �����N���E�e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addClaimDate(){

  }

  /**
   * ���o�͔��ʃ`�F�b�N�{�b�N�X�ɓ������ڂ�ǉ����܂��B
   */
  protected void addNotOutputDistinction(){

  }

  /**
   * �ی��Ҕԍ��E�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addInsurerContena(){

    insurerContena.add(getInsurerNoText(), VRLayout.FLOW);

    insurerContena.add(getInsurerNoConbo(), VRLayout.FLOW);

  }

  /**
   * �ی��Ҕԍ��E�e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addInsurerNoText(){

  }

  /**
   * �ی��Ҕԍ��E�R���{�ɓ������ڂ�ǉ����܂��B
   */
  protected void addInsurerNoConbo(){

  }

  /**
   * �ی��Ҕԍ��E�R���{���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addInsurerNoConboModel(){

  }

  /**
   * ���p�҃R�[�h�E�e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatientCodeText(){

  }

  /**
   * ���p�҂ӂ肪�ȁE�e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatientFuriganaText(){

  }

  /**
   * ��ی��Ҕԍ��E�e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addInsuredNoText(){

  }

  /**
   * �o�^�����̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addUpdateConditions(){

    updateConditions.add(getUpdateCondition(), VRLayout.NORTH);

  }

  /**
   * �o�^�����̈�E�t���[���ɓ������ڂ�ǉ����܂��B
   */
  protected void addUpdateCondition(){

    updateCondition.add(getClaimDateUpdateContainer(), VRLayout.FLOW);

    updateCondition.add(getClaimDateUpdateChangePermit(), VRLayout.FLOW);

  }

  /**
   * �����N���E�e�L�X�g(�o�^�p)�ɓ������ڂ�ǉ����܂��B
   */
  protected void addClaimDateUpdate(){

  }

  /**
   * �����N���ύX���`�F�b�N�{�b�N�X�ɓ������ڂ�ǉ����܂��B
   */
  protected void addClaimDateUpdateChangePermit(){

  }

  /**
   * ��������̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPrintConditions(){

    printConditions.add(getPrintCondition(), VRLayout.NORTH);

  }

  /**
   * ��������̈�E�t���[���ɓ������ڂ�ǉ����܂��B
   */
  protected void addPrintCondition(){

    printCondition.add(getClaimDatePrintContainer(), VRLayout.FLOW);

  }

  /**
   * ���������t�ɓ������ڂ�ǉ����܂��B
   */
  protected void addClaimDatePrint(){

  }

  /**
   * �l���������̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTypeCountInfomations(){

    typeCountInfomations.add(getTypeCountInfomation(), VRLayout.NORTH);

  }

  /**
   * �l���������̈�E�t���[���ɓ������ڂ�ǉ����܂��B
   */
  protected void addTypeCountInfomation(){

    typeCountInfomation.add(getSupplyCountContainer(), VRLayout.FLOW_INSETLINE);

    typeCountInfomation.add(getNursingCountContainer(), VRLayout.FLOW_INSETLINE);

    typeCountInfomation.add(getType7CountContainer(), VRLayout.FLOW_INSETLINE);

    typeCountInfomation.add(getType2CountContainer(), VRLayout.FLOW_INSETLINE);

    typeCountInfomation.add(getType3CountContainer(), VRLayout.FLOW_INSETLINE);

    typeCountInfomation.add(getType4CountContainer(), VRLayout.FLOW_INSETLINE);

    typeCountInfomation.add(getType5CountContainer(), VRLayout.FLOW_INSETLINE);

    typeCountInfomation.add(getType6CountContainer(), VRLayout.FLOW_INSETLINE);

    typeCountInfomation.add(getType8CountContainer(), VRLayout.FLOW_INSETLINE);

    typeCountInfomation.add(getType9CountContainer(), VRLayout.FLOW_INSETLINE);

    typeCountInfomation.add(getType10CountContainer(), VRLayout.FLOW_INSETLINE);

    typeCountInfomation.add(getVisitCountContainer(), VRLayout.FLOW_INSETLINE);

    typeCountInfomation.add(getSyahoCountContainer(), VRLayout.FLOW_INSETLINE);

    typeCountInfomation.add(getKokuhoCountContainer(), VRLayout.FLOW_INSETLINE);

    typeCountInfomation.add(getServiceCountContainer(), VRLayout.FLOW_INSETLINE);

  }

  /**
   * ���t�Ǘ��[�E�e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addSupplyCount(){

  }

  /**
   * ��싋�t������E�e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addNursingCount(){

  }

  /**
   * �l���掵�E�e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addType7Count(){

  }

  /**
   * �l�����E�e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addType2Count(){

  }

  /**
   * �l����O�E�e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addType3Count(){

  }

  /**
   * �l����l�E�e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addType4Count(){

  }

  /**
   * �l����܁E�e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addType5Count(){

  }

  /**
   * �l����Z�E�e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addType6Count(){

  }

  /**
   * �l���攪�E�e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addType8Count(){

  }

  /**
   * �l�����E�e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addType9Count(){

  }

  /**
   * �l����\�E�e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addType10Count(){

  }

  /**
   * �K��Ō�×{��׏��E�e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addVisitCount(){

  }

  /**
   * �K��Ō�×{�����(�Еې���)�E�e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addSyahoCount(){

  }

  /**
   * �K��Ō�×{�����(���ې���)�E�e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKokuhoCount(){

  }

  /**
   * ���T�[�r�X���p�������E�e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceCount(){

  }

  /**
   * �����z�E���v�P�ʗ̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addDemandMoneyAndTotalDenominations(){

    demandMoneyAndTotalDenominations.add(getDemandMoneyAndTotalDenomination(), VRLayout.NORTH);

  }

  /**
   * �����z�E���v�P�ʗ̈�E�t���[���ɓ������ڂ�ǉ����܂��B
   */
  protected void addDemandMoneyAndTotalDenomination(){

    demandMoneyAndTotalDenomination.add(getTotalDenominationTextContainer(), VRLayout.FLOW_INSETLINE);

    demandMoneyAndTotalDenomination.add(getTotalMoneyTextContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    demandMoneyAndTotalDenomination.add(getDemandMoneyInsuranceMoneyTextContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    demandMoneyAndTotalDenomination.add(getDemandMoneyPatientMoneyTextContainer(), VRLayout.FLOW_INSETLINE);

    demandMoneyAndTotalDenomination.add(getTotalDenominationPublicExpenseMoneyTextContainer(), VRLayout.FLOW_INSETLINE);

  }

  /**
   * ���v�P�ʐ��E�e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTotalDenominationText(){

  }

  /**
   * ���v���z�E�e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTotalMoneyText(){

  }

  /**
   * �ی������z�E�e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addDemandMoneyInsuranceMoneyText(){

  }

  /**
   * ���p�ҕ��S�z�E�e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addDemandMoneyPatientMoneyText(){

  }

  /**
   * ������z�E�e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTotalDenominationPublicExpenseMoneyText(){

  }

  /**
   * ���e�[�u���̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addInfos(){

    infos.add(getInfoTable(), VRLayout.CLIENT);

  }

  /**
   * ���e�[�u���ɓ������ڂ�ǉ����܂��B
   */
  protected void addInfoTable(){

  }

  /**
   * ���e�[�u���J�������f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addInfoTableColumnModel(){

    getInfoTableColumnModel().addColumn(getInfoTableColumn1());

    getInfoTableColumnModel().addColumn(getInfoTableColumn2());

    getInfoTableColumnModel().addColumn(getInfoTableColumn3());

    getInfoTableColumnModel().addColumn(getInfoTableColumn4());

    getInfoTableColumnModel().addColumn(getInfoTableColumn23());

    getInfoTableColumnModel().addColumn(getInfoTableColumn5());

    getInfoTableColumnModel().addColumn(getInfoTableColumn14());

    getInfoTableColumnModel().addColumn(getInfoTableColumn6());

    getInfoTableColumnModel().addColumn(getInfoTableColumn7());

    getInfoTableColumnModel().addColumn(getInfoTableColumn8());

    getInfoTableColumnModel().addColumn(getInfoTableColumn9());

    getInfoTableColumnModel().addColumn(getInfoTableColumn10());

    getInfoTableColumnModel().addColumn(getInfoTableColumn11());

    getInfoTableColumnModel().addColumn(getInfoTableColumn12());

    getInfoTableColumnModel().addColumn(getInfoTableColumn13());

    getInfoTableColumnModel().addColumn(getInfoTableColumn15());

    getInfoTableColumnModel().addColumn(getInfoTableColumn16());

    getInfoTableColumnModel().addColumn(getInfoTableColumn17());

    getInfoTableColumnModel().addColumn(getInfoTableColumn18());

    getInfoTableColumnModel().addColumn(getInfoTableColumn19());

    getInfoTableColumnModel().addColumn(getInfoTableColumn20());

    getInfoTableColumnModel().addColumn(getInfoTableColumn21());

    getInfoTableColumnModel().addColumn(getInfoTableColumn22());

  }

  /**
   * �m���ɓ������ڂ�ǉ����܂��B
   */
  protected void addInfoTableColumn1(){

  }

  /**
   * ����ς݃t���O(��ɓ������ڂ�ǉ����܂��B
   */
  protected void addInfoTableColumn2(){

  }

  /**
   * �I��(��ɓ������ڂ�ǉ����܂��B
   */
  protected void addInfoTableColumn3(){

  }

  /**
   * �폜(��ɓ������ڂ�ǉ����܂��B
   */
  protected void addInfoTableColumn4(){

  }

  /**
   * �敪(��ɓ������ڂ�ǉ����܂��B
   */
  protected void addInfoTableColumn23(){

  }

  /**
   * �N���x(��ɓ������ڂ�ǉ����܂��B
   */
  protected void addInfoTableColumn5(){

  }

  /**
   * �l��(��ɓ������ڂ�ǉ����܂��B
   */
  protected void addInfoTableColumn14(){

  }

  /**
   * �ی��Ҕԍ�(��ɓ������ڂ�ǉ����܂��B
   */
  protected void addInfoTableColumn6(){

  }

  /**
   * �ی��Җ���(��ɓ������ڂ�ǉ����܂��B
   */
  protected void addInfoTableColumn7(){

  }

  /**
   * ���p�҃R�[�h(��ɓ������ڂ�ǉ����܂��B
   */
  protected void addInfoTableColumn8(){

  }

  /**
   * ��ی��Ҕԍ�(��ɓ������ڂ�ǉ����܂��B
   */
  protected void addInfoTableColumn9(){

  }

  /**
   * ���p�Ҏ���(��ɓ������ڂ�ǉ����܂��B
   */
  protected void addInfoTableColumn10(){

  }

  /**
   * �ӂ肪��(��ɓ������ڂ�ǉ����܂��B
   */
  protected void addInfoTableColumn11(){

  }

  /**
   * ����(��ɓ������ڂ�ǉ����܂��B
   */
  protected void addInfoTableColumn12(){

  }

  /**
   * �N��(��ɓ������ڂ�ǉ����܂��B
   */
  protected void addInfoTableColumn13(){

  }

  /**
   * �v���x(��ɓ������ڂ�ǉ����܂��B
   */
  protected void addInfoTableColumn15(){

  }

  /**
   * �ی��敪(��ɓ������ڂ�ǉ����܂��B
   */
  protected void addInfoTableColumn16(){

  }

  /**
   * �v��P��(��ɓ������ڂ�ǉ����܂��B
   */
  protected void addInfoTableColumn17(){

  }

  /**
   * �T�[�r�X�P��(��ɓ������ڂ�ǉ����܂��B
   */
  protected void addInfoTableColumn18(){

  }

  /**
   * �T�[�r�X���v���z(��ɓ������ڂ�ǉ����܂��B
   */
  protected void addInfoTableColumn19(){

  }

  /**
   * �ی������z(��ɓ������ڂ�ǉ����܂��B
   */
  protected void addInfoTableColumn20(){

  }

  /**
   * ����S�z(��ɓ������ڂ�ǉ����܂��B
   */
  protected void addInfoTableColumn21(){

  }

  /**
   * ���p�ҕ��S�z(��ɓ������ڂ�ǉ����܂��B
   */
  protected void addInfoTableColumn22(){

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
      ACFrame.debugStart(new ACAffairInfo(QP001Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QP001Design getThis() {
    return this;
  }
}
