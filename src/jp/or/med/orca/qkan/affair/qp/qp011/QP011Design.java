
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
 * �J����: �c���@����
 * �쐬��: 2006/09/05  ���{�R���s���[�^�[������� �c���@���� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �����f�[�^�쐬 (P)
 * �v���Z�X �K��Ō�×{��̎����ꗗ (011)
 * �v���O���� �K��Ō�×{��̎����ꗗ (QP011)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qp.qp011;
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
 * �K��Ō�×{��̎����ꗗ��ʍ��ڃf�U�C��(QP011) 
 */
public class QP011Design extends QkanAffairContainer implements ACAffairable {
  //GUI�R���|�[�l���g

  private ACAffairButtonBar buttons;

  private ACAffairButton find;

  private ACAffairButton detail;

  private ACAffairButton insert;

  private ACAffairButton delete;

  private ACPanel contents;

  private ACGroupBox patientInfomationContents;

  private ACTextField patientCode;

  private ACLabelContainer patientCodeContainer;

  private ACTextField patientName;

  private ACLabelContainer patientNameContainer;

  private ACGroupBox findConditions;

  private QkanYearDateTextField targetDate;

  private ACLabelContainer targetDateContainer;

  private ACGroupBox createConditions;

  private ACLabelContainer billSpanContainer;

  private ACLabel billSpanStartYearMonth;

  private ACTextField billSpanStartDay;

  private ACLabel billSpanStartDayUnit;

  private ACLabel billSpan;

  private ACLabel billSpanEndYearMonth;

  private ACTextField billSpanEndDay;

  private ACLabel billSpanEndDayUnit;

  private ACIntegerCheckBox copyCreate;

  private ACGroupBox infomationContents;

  private ACLabel infomation1;

  private ACLabel infomation2;

  private ACLabel infomation3;

  private ACTable bills;

  private VRTableColumnModel billsColumnModel;

  private ACTableColumn billNoColumn;

  private ACTableColumn billPrintedColumn;

  private ACTableColumn billSpanStartColumn;

  private ACTableColumn billSpanEndColumn;

  private ACTableColumn billPrintDateColumn;

  private ACTableColumn billFullCostColumn;

  private ACTableColumn billInsureTypeColumn;

  //getter

  /**
   * �{�^���o�[���擾���܂��B
   * @return �{�^���o�[
   */
  public ACAffairButtonBar getButtons(){
    if(buttons==null){

      buttons = new ACAffairButtonBar();

      buttons.setText("�K��Ō�×{��̎����ꗗ");

      addButtons();
    }
    return buttons;

  }

  /**
   * �������擾���܂��B
   * @return ����
   */
  public ACAffairButton getFind(){
    if(find==null){

      find = new ACAffairButton();

      find.setText("����(F)");

      find.setToolTipText("�Ώ۔N���̗̎������������܂��B");

      find.setMnemonic('F');

      find.setIconPath(ACConstants.ICON_PATH_FIND_24);

      addFind();
    }
    return find;

  }

  /**
   * �ڍׂ��擾���܂��B
   * @return �ڍ�
   */
  public ACAffairButton getDetail(){
    if(detail==null){

      detail = new ACAffairButton();

      detail.setText("�ڍ�(E)");

      detail.setToolTipText("�I�������̎������{���E�ҏW���܂��B");

      detail.setMnemonic('E');

      detail.setIconPath(ACConstants.ICON_PATH_DETAIL_24);

      addDetail();
    }
    return detail;

  }

  /**
   * �V�K���擾���܂��B
   * @return �V�K
   */
  public ACAffairButton getInsert(){
    if(insert==null){

      insert = new ACAffairButton();

      insert.setText("�V�K(N)");

      insert.setToolTipText("�V�K�ɗ̎������쐬���܂��B");

      insert.setMnemonic('N');

      insert.setIconPath(ACConstants.ICON_PATH_NEW_24);

      addInsert();
    }
    return insert;

  }

  /**
   * �폜���擾���܂��B
   * @return �폜
   */
  public ACAffairButton getDelete(){
    if(delete==null){

      delete = new ACAffairButton();

      delete.setText("�폜(D)");

      delete.setToolTipText("�I�������̎������폜���܂��B");

      delete.setMnemonic('D');

      delete.setIconPath(ACConstants.ICON_PATH_DELETE_24);

      addDelete();
    }
    return delete;

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
   * ���p�ҏ����擾���܂��B
   * @return ���p�ҏ��
   */
  public ACGroupBox getPatientInfomationContents(){
    if(patientInfomationContents==null){

      patientInfomationContents = new ACGroupBox();

      patientInfomationContents.setText("���p�ҏ��");

      addPatientInfomationContents();
    }
    return patientInfomationContents;

  }

  /**
   * ���p�҃R�[�h���擾���܂��B
   * @return ���p�҃R�[�h
   */
  public ACTextField getPatientCode(){
    if(patientCode==null){

      patientCode = new ACTextField();

      getPatientCodeContainer().setText("���p�҃R�[�h");

      patientCode.setBindPath("PATIENT_CODE");

      patientCode.setEditable(false);

      patientCode.setColumns(15);

      addPatientCode();
    }
    return patientCode;

  }

  /**
   * ���p�҃R�[�h�R���e�i���擾���܂��B
   * @return ���p�҃R�[�h�R���e�i
   */
  protected ACLabelContainer getPatientCodeContainer(){
    if(patientCodeContainer==null){
      patientCodeContainer = new ACLabelContainer();
      patientCodeContainer.setFollowChildEnabled(true);
      patientCodeContainer.setVAlignment(VRLayout.CENTER);
      patientCodeContainer.add(getPatientCode(), null);
    }
    return patientCodeContainer;
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

      patientName.setColumns(33);

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
   * �����������擾���܂��B
   * @return ��������
   */
  public ACGroupBox getFindConditions(){
    if(findConditions==null){

      findConditions = new ACGroupBox();

      findConditions.setText("��������");

      addFindConditions();
    }
    return findConditions;

  }

  /**
   * �Ώ۔N�����擾���܂��B
   * @return �Ώ۔N��
   */
  public QkanYearDateTextField getTargetDate(){
    if(targetDate==null){

      targetDate = new QkanYearDateTextField();

      getTargetDateContainer().setText("�Ώ۔N��");

      targetDate.setBindPath("TARGET_DATE");

      targetDate.setAllowedBlank(false);

      try{
        targetDate.setMinimumDate(ACCastUtilities.toDate("2006/04/01"));
      }catch(Throwable ex){
        ACCommon.getInstance().showExceptionMessage(new IllegalArgumentException("targetDate �̍ŏ��N�����ɕs���ȓ��t���w�肳��Ă��܂��B"));
      }

      addTargetDate();
    }
    return targetDate;

  }

  /**
   * �Ώ۔N���R���e�i���擾���܂��B
   * @return �Ώ۔N���R���e�i
   */
  protected ACLabelContainer getTargetDateContainer(){
    if(targetDateContainer==null){
      targetDateContainer = new ACLabelContainer();
      targetDateContainer.setFollowChildEnabled(true);
      targetDateContainer.setVAlignment(VRLayout.CENTER);
      targetDateContainer.add(getTargetDate(), null);
    }
    return targetDateContainer;
  }

  /**
   * �쐬�������擾���܂��B
   * @return �쐬����
   */
  public ACGroupBox getCreateConditions(){
    if(createConditions==null){

      createConditions = new ACGroupBox();

      createConditions.setText("�쐬����");

      addCreateConditions();
    }
    return createConditions;

  }

  /**
   * �������Ԃ��擾���܂��B
   * @return ��������
   */
  public ACLabelContainer getBillSpanContainer(){
    if(billSpanContainer==null){

      billSpanContainer = new ACLabelContainer();

      billSpanContainer.setText("��������");

      addBillSpanContainer();
    }
    return billSpanContainer;

  }

  /**
   * �������ԊJ�n�N�����擾���܂��B
   * @return �������ԊJ�n�N��
   */
  public ACLabel getBillSpanStartYearMonth(){
    if(billSpanStartYearMonth==null){

      billSpanStartYearMonth = new ACLabel();

      billSpanStartYearMonth.setText("����18�N09��");

      billSpanStartYearMonth.setBindPath("BILL_DATE");

      billSpanStartYearMonth.setFormat(new ACBorderBlankDateFormat("gggee�NMM��"));

      addBillSpanStartYearMonth();
    }
    return billSpanStartYearMonth;

  }

  /**
   * �������ԊJ�n�����擾���܂��B
   * @return �������ԊJ�n��
   */
  public ACTextField getBillSpanStartDay(){
    if(billSpanStartDay==null){

      billSpanStartDay = new ACTextField();

      billSpanStartDay.setText("1");

      billSpanStartDay.setBindPath("BILL_SPAN_START_DAY");

      billSpanStartDay.setColumns(2);

      billSpanStartDay.setCharType(VRCharType.ONLY_DIGIT);

      billSpanStartDay.setIMEMode(InputSubset.LATIN);

      billSpanStartDay.setMaxLength(2);

      addBillSpanStartDay();
    }
    return billSpanStartDay;

  }

  /**
   * �������ԊJ�n���P�ʂ��擾���܂��B
   * @return �������ԊJ�n���P��
   */
  public ACLabel getBillSpanStartDayUnit(){
    if(billSpanStartDayUnit==null){

      billSpanStartDayUnit = new ACLabel();

      billSpanStartDayUnit.setText("��");

      addBillSpanStartDayUnit();
    }
    return billSpanStartDayUnit;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACLabel getBillSpan(){
    if(billSpan==null){

      billSpan = new ACLabel();

      billSpan.setText(" ���� ");

      addBillSpan();
    }
    return billSpan;

  }

  /**
   * �������ԏI���N�����擾���܂��B
   * @return �������ԏI���N��
   */
  public ACLabel getBillSpanEndYearMonth(){
    if(billSpanEndYearMonth==null){

      billSpanEndYearMonth = new ACLabel();

      billSpanEndYearMonth.setText("����18�N09��");

      billSpanEndYearMonth.setBindPath("BILL_DATE");

      billSpanEndYearMonth.setFormat(new ACBorderBlankDateFormat("gggee�NMM��"));

      addBillSpanEndYearMonth();
    }
    return billSpanEndYearMonth;

  }

  /**
   * �������ԏI�������擾���܂��B
   * @return �������ԏI����
   */
  public ACTextField getBillSpanEndDay(){
    if(billSpanEndDay==null){

      billSpanEndDay = new ACTextField();

      billSpanEndDay.setBindPath("BILL_SPAN_END_DAY");

      billSpanEndDay.setColumns(2);

      billSpanEndDay.setCharType(VRCharType.ONLY_DIGIT);

      billSpanEndDay.setIMEMode(InputSubset.LATIN);

      billSpanEndDay.setMaxLength(2);

      addBillSpanEndDay();
    }
    return billSpanEndDay;

  }

  /**
   * �������ԏI�����P�ʂ��擾���܂��B
   * @return �������ԏI�����P��
   */
  public ACLabel getBillSpanEndDayUnit(){
    if(billSpanEndDayUnit==null){

      billSpanEndDayUnit = new ACLabel();

      billSpanEndDayUnit.setText("��");

      addBillSpanEndDayUnit();
    }
    return billSpanEndDayUnit;

  }

  /**
   * �����ۂ��擾���܂��B
   * @return ������
   */
  public ACIntegerCheckBox getCopyCreate(){
    if(copyCreate==null){

      copyCreate = new ACIntegerCheckBox();

      copyCreate.setText("�I�������̎����𕡐����ĐV�K�쐬(C)");

      copyCreate.setBindPath("COPY_CREATE");

      copyCreate.setMnemonic('C');

      addCopyCreate();
    }
    return copyCreate;

  }

  /**
   * ��������̈���擾���܂��B
   * @return ��������̈�
   */
  public ACGroupBox getInfomationContents(){
    if(infomationContents==null){

      infomationContents = new ACGroupBox();

      infomationContents.setText("�������");

      addInfomationContents();
    }
    return infomationContents;

  }

  /**
   * �������1���擾���܂��B
   * @return �������1
   */
  public ACLabel getInfomation1(){
    if(infomation1==null){

      infomation1 = new ACLabel();

      infomation1.setText("(1)�y�ߋ��ɍ쐬�����̎������{���E�ҏW����ꍇ�z�Ώ۔N�����w�肵�Č����B�ꗗ����ړI�̗̎�����I���B�ڍ׃{�^���������B");

      infomation1.setAutoWrap(true);

      addInfomation1();
    }
    return infomation1;

  }

  /**
   * �������2���擾���܂��B
   * @return �������2
   */
  public ACLabel getInfomation2(){
    if(infomation2==null){

      infomation2 = new ACLabel();

      infomation2.setText("(2)�y�V�K�ɗ̎������쐬����ꍇ�z�V�K�ɍ쐬����̎����̐������Ԃ���́B�u�I�������̎����𕡐����ĐV�K�쐬�v�̃`�F�b�N���͂����B�V�K�{�^���������B");

      infomation2.setAutoWrap(true);

      addInfomation2();
    }
    return infomation2;

  }

  /**
   * �������3���擾���܂��B
   * @return �������3
   */
  public ACLabel getInfomation3(){
    if(infomation3==null){

      infomation3 = new ACLabel();

      infomation3.setText("(3)�y�ߋ��ɍ쐬�����̎����𕡐����ĐV�K�ɗ̎������쐬����ꍇ�z(1)�̎菇�ŕ������̐�������I���B�V�K�ɍ쐬����̎����̐������Ԃ���́B�u�I�������̎����𕡐����ĐV�K�쐬�v�Ƀ`�F�b�N������B�V�K�{�^���������B");

      infomation3.setAutoWrap(true);

      addInfomation3();
    }
    return infomation3;

  }

  /**
   * �̎����ꗗ���擾���܂��B
   * @return �̎����ꗗ
   */
  public ACTable getBills(){
    if(bills==null){

      bills = new ACTable();

      bills.setColumnModel(getBillsColumnModel());

      addBills();
    }
    return bills;

  }

  /**
   * �̎����ꗗ�J�������f�����擾���܂��B
   * @return �̎����ꗗ�J�������f��
   */
  protected VRTableColumnModel getBillsColumnModel(){
    if(billsColumnModel==null){
      billsColumnModel = new VRTableColumnModel(new TableColumn[]{});
      addBillsColumnModel();
    }
    return billsColumnModel;
  }

  /**
   * �̎����ꗗ�FNo.���擾���܂��B
   * @return �̎����ꗗ�FNo.
   */
  public ACTableColumn getBillNoColumn(){
    if(billNoColumn==null){

      billNoColumn = new ACTableColumn();

      billNoColumn.setHeaderValue("No.");

      billNoColumn.setColumnName("BILL_PRINTED");

      billNoColumn.setColumns(3);

      billNoColumn.setRendererType(ACTableCellViewer.RENDERER_TYPE_SERIAL_NO);

      billNoColumn.setSortable(false);

      addBillNoColumn();
    }
    return billNoColumn;

  }

  /**
   * �̎����ꗗ�F������擾���܂��B
   * @return �̎����ꗗ�F���
   */
  public ACTableColumn getBillPrintedColumn(){
    if(billPrintedColumn==null){

      billPrintedColumn = new ACTableColumn();

      billPrintedColumn.setHeaderValue("���");

      billPrintedColumn.setColumnName("BILL_PRINTED");

      billPrintedColumn.setColumns(4);

      billPrintedColumn.setFormat(QkanClaimMedicalPrintedFormat.getInstance());

      addBillPrintedColumn();
    }
    return billPrintedColumn;

  }

  /**
   * �̎����ꗗ�F�������ԊJ�n���擾���܂��B
   * @return �̎����ꗗ�F�������ԊJ�n
   */
  public ACTableColumn getBillSpanStartColumn(){
    if(billSpanStartColumn==null){

      billSpanStartColumn = new ACTableColumn();

      billSpanStartColumn.setHeaderValue("�������ԊJ�n");

      billSpanStartColumn.setColumnName("BILL_SPAN_START");

      billSpanStartColumn.setColumns(10);

      billSpanStartColumn.setFormat(new ACBorderBlankDateFormat("gggee�NMM��dd��"));

      addBillSpanStartColumn();
    }
    return billSpanStartColumn;

  }

  /**
   * �̎����ꗗ�F�������ԏI�����擾���܂��B
   * @return �̎����ꗗ�F�������ԏI��
   */
  public ACTableColumn getBillSpanEndColumn(){
    if(billSpanEndColumn==null){

      billSpanEndColumn = new ACTableColumn();

      billSpanEndColumn.setHeaderValue("�������ԏI��");

      billSpanEndColumn.setColumnName("BILL_SPAN_END");

      billSpanEndColumn.setColumns(10);

      billSpanEndColumn.setFormat(new ACBorderBlankDateFormat("gggee�NMM��dd��"));

      addBillSpanEndColumn();
    }
    return billSpanEndColumn;

  }

  /**
   * �̎����ꗗ�F���s�����擾���܂��B
   * @return �̎����ꗗ�F���s��
   */
  public ACTableColumn getBillPrintDateColumn(){
    if(billPrintDateColumn==null){

      billPrintDateColumn = new ACTableColumn();

      billPrintDateColumn.setHeaderValue("���s��");

      billPrintDateColumn.setColumnName("BILL_PRINT_DATE");

      billPrintDateColumn.setColumns(10);

      billPrintDateColumn.setFormat(new ACBorderBlankDateFormat("gggee�NMM��dd��"));

      addBillPrintDateColumn();
    }
    return billPrintDateColumn;

  }

  /**
   * �̎����ꗗ�F�̎��z���v���擾���܂��B
   * @return �̎����ꗗ�F�̎��z���v
   */
  public ACTableColumn getBillFullCostColumn(){
    if(billFullCostColumn==null){

      billFullCostColumn = new ACTableColumn();

      billFullCostColumn.setHeaderValue("�̎��z���v");

      billFullCostColumn.setColumnName("BILL_FULL_TOTAL");

      billFullCostColumn.setColumns(7);

      billFullCostColumn.setHorizontalAlignment(SwingConstants.RIGHT);

      billFullCostColumn.setFormat(NumberFormat.getIntegerInstance());

      addBillFullCostColumn();
    }
    return billFullCostColumn;

  }

  /**
   * �̎����ꗗ�F�ی��敪���擾���܂��B
   * @return �̎����ꗗ�F�ی��敪
   */
  public ACTableColumn getBillInsureTypeColumn(){
    if(billInsureTypeColumn==null){

      billInsureTypeColumn = new ACTableColumn();

      billInsureTypeColumn.setHeaderValue("�ی��敪");

      billInsureTypeColumn.setColumnName("BILL_INSURE_TYPE");

      billInsureTypeColumn.setColumns(10);

      addBillInsureTypeColumn();
    }
    return billInsureTypeColumn;

  }

  /**
   * �R���X�g���N�^�ł��B
   */
  public QP011Design() {

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

    buttons.add(getDelete(), VRLayout.EAST);
    buttons.add(getInsert(), VRLayout.EAST);
    buttons.add(getDetail(), VRLayout.EAST);
    buttons.add(getFind(), VRLayout.EAST);
  }

  /**
   * �����ɓ������ڂ�ǉ����܂��B
   */
  protected void addFind(){

  }

  /**
   * �ڍׂɓ������ڂ�ǉ����܂��B
   */
  protected void addDetail(){

  }

  /**
   * �V�K�ɓ������ڂ�ǉ����܂��B
   */
  protected void addInsert(){

  }

  /**
   * �폜�ɓ������ڂ�ǉ����܂��B
   */
  protected void addDelete(){

  }

  /**
   * �N���C�A���g�̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addContents(){

    contents.add(getPatientInfomationContents(), VRLayout.NORTH);

    contents.add(getFindConditions(), VRLayout.NORTH);

    contents.add(getCreateConditions(), VRLayout.NORTH);

    contents.add(getInfomationContents(), VRLayout.NORTH);

    contents.add(getBills(), VRLayout.CLIENT);

  }

  /**
   * ���p�ҏ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatientInfomationContents(){

    patientInfomationContents.add(getPatientCodeContainer(), VRLayout.FLOW_INSETLINE);

    patientInfomationContents.add(getPatientNameContainer(), VRLayout.FLOW_INSETLINE);

  }

  /**
   * ���p�҃R�[�h�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatientCode(){

  }

  /**
   * �����ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatientName(){

  }

  /**
   * ���������ɓ������ڂ�ǉ����܂��B
   */
  protected void addFindConditions(){

    findConditions.add(getTargetDateContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * �Ώ۔N���ɓ������ڂ�ǉ����܂��B
   */
  protected void addTargetDate(){

  }

  /**
   * �쐬�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addCreateConditions(){

    createConditions.add(getBillSpanContainer(), VRLayout.FLOW_INSETLINE);

    createConditions.add(getCopyCreate(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * �������Ԃɓ������ڂ�ǉ����܂��B
   */
  protected void addBillSpanContainer(){

    billSpanContainer.add(getBillSpanStartYearMonth(), VRLayout.FLOW);

    billSpanContainer.add(getBillSpanStartDay(), VRLayout.FLOW);

    billSpanContainer.add(getBillSpanStartDayUnit(), VRLayout.FLOW);

    billSpanContainer.add(getBillSpan(), VRLayout.FLOW);

    billSpanContainer.add(getBillSpanEndYearMonth(), VRLayout.FLOW);

    billSpanContainer.add(getBillSpanEndDay(), VRLayout.FLOW);

    billSpanContainer.add(getBillSpanEndDayUnit(), VRLayout.FLOW);

  }

  /**
   * �������ԊJ�n�N���ɓ������ڂ�ǉ����܂��B
   */
  protected void addBillSpanStartYearMonth(){

  }

  /**
   * �������ԊJ�n���ɓ������ڂ�ǉ����܂��B
   */
  protected void addBillSpanStartDay(){

  }

  /**
   * �������ԊJ�n���P�ʂɓ������ڂ�ǉ����܂��B
   */
  protected void addBillSpanStartDayUnit(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addBillSpan(){

  }

  /**
   * �������ԏI���N���ɓ������ڂ�ǉ����܂��B
   */
  protected void addBillSpanEndYearMonth(){

  }

  /**
   * �������ԏI�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addBillSpanEndDay(){

  }

  /**
   * �������ԏI�����P�ʂɓ������ڂ�ǉ����܂��B
   */
  protected void addBillSpanEndDayUnit(){

  }

  /**
   * �����ۂɓ������ڂ�ǉ����܂��B
   */
  protected void addCopyCreate(){

  }

  /**
   * ��������̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addInfomationContents(){

    infomationContents.add(getInfomation1(), VRLayout.NORTH);

    infomationContents.add(getInfomation2(), VRLayout.NORTH);

    infomationContents.add(getInfomation3(), VRLayout.NORTH);

  }

  /**
   * �������1�ɓ������ڂ�ǉ����܂��B
   */
  protected void addInfomation1(){

  }

  /**
   * �������2�ɓ������ڂ�ǉ����܂��B
   */
  protected void addInfomation2(){

  }

  /**
   * �������3�ɓ������ڂ�ǉ����܂��B
   */
  protected void addInfomation3(){

  }

  /**
   * �̎����ꗗ�ɓ������ڂ�ǉ����܂��B
   */
  protected void addBills(){

  }

  /**
   * �̎����ꗗ�J�������f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addBillsColumnModel(){

    getBillsColumnModel().addColumn(getBillNoColumn());

    getBillsColumnModel().addColumn(getBillPrintedColumn());

    getBillsColumnModel().addColumn(getBillSpanStartColumn());

    getBillsColumnModel().addColumn(getBillSpanEndColumn());

    getBillsColumnModel().addColumn(getBillPrintDateColumn());

    getBillsColumnModel().addColumn(getBillFullCostColumn());

    getBillsColumnModel().addColumn(getBillInsureTypeColumn());

  }

  /**
   * �̎����ꗗ�FNo.�ɓ������ڂ�ǉ����܂��B
   */
  protected void addBillNoColumn(){

  }

  /**
   * �̎����ꗗ�F����ɓ������ڂ�ǉ����܂��B
   */
  protected void addBillPrintedColumn(){

  }

  /**
   * �̎����ꗗ�F�������ԊJ�n�ɓ������ڂ�ǉ����܂��B
   */
  protected void addBillSpanStartColumn(){

  }

  /**
   * �̎����ꗗ�F�������ԏI���ɓ������ڂ�ǉ����܂��B
   */
  protected void addBillSpanEndColumn(){

  }

  /**
   * �̎����ꗗ�F���s���ɓ������ڂ�ǉ����܂��B
   */
  protected void addBillPrintDateColumn(){

  }

  /**
   * �̎����ꗗ�F�̎��z���v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addBillFullCostColumn(){

  }

  /**
   * �̎����ꗗ�F�ی��敪�ɓ������ڂ�ǉ����܂��B
   */
  protected void addBillInsureTypeColumn(){

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

    return getBillSpanStartDay();

  }
  public void initAffair(ACAffairInfo affair) throws Exception {
  }

  public static void main(String[] args) {
    //�f�t�H���g�f�o�b�O�N��
    try {
      ACFrame.getInstance().setFrameEventProcesser(new QkanFrameEventProcesser());
      ACFrame.debugStart(new ACAffairInfo(QP011Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QP011Design getThis() {
    return this;
  }
}
