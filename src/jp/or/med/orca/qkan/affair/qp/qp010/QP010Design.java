
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
 * �쐬��: 2006/09/15  ���{�R���s���[�^�[������� �c���@���� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �����f�[�^�쐬 (P)
 * �v���Z�X ���p�҈ꗗ(�K��Ō�×{��̎���) (010)
 * �v���O���� ���p�҈ꗗ(�K��Ō�×{��̎���) (QP010)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qp.qp010;
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
 * ���p�҈ꗗ(�K��Ō�×{��̎���)��ʍ��ڃf�U�C��(QP010) 
 */
public class QP010Design extends QkanAffairContainer implements ACAffairable {
  //GUI�R���|�[�l���g

  private ACAffairButtonBar buttons;

  private ACAffairButton find;

  private ACAffairButton detail;

  private ACPanel contents;

  private ACLabel loginProviderInfo;

  private ACGroupBox findCondition;

  private QkanYearDateTextField targetDate;

  private ACLabelContainer targetDateContainer;

  private ACIntegerCheckBox onlyExistsResult;

  private ACLabelContainer insurerContainer;

  private ACTextField insurerID;

  private ACComboBox insurerName;

  private ACComboBoxModelAdapter insurerNameModel;

  private ACTextField patientCode;

  private ACLabelContainer patientCodeContainer;

  private ACTextField patientKana;

  private ACLabelContainer patientKanaContainer;

  private ACTextField patientInsuredID;

  private ACLabelContainer patientInsuredIDContainer;

  private ACTable patients;

  private VRTableColumnModel patientsColumnModel;

  private ACTableColumn patinetNoColumn;

  private ACTableColumn patientInsurerIDColumn;

  private ACTableColumn patientInsurerNameColumn;

  private ACTableColumn patientCodeColumn;

  private ACTableColumn patientInsuredIDColumn;

  private ACTableColumn patientNameColumn;

  private ACTableColumn patientKanaColumn;

  private ACTableColumn patientSexColumn;

  private ACTableColumn patientAgeColumn;

  private ACTableColumn patientInsureTypeColumn;

  //getter

  /**
   * �{�^���o�[���擾���܂��B
   * @return �{�^���o�[
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
   * �������擾���܂��B
   * @return ����
   */
  public ACAffairButton getFind(){
    if(find==null){

      find = new ACAffairButton();

      find.setText("����(F)");

      find.setToolTipText("�Ώ۔N���ɗL���ȗ��p�҂��������܂��B");

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

      detail.setToolTipText("�I���������p�҂̗̎������ڍו\�����܂��B");

      detail.setMnemonic('E');

      detail.setIconPath(ACConstants.ICON_PATH_DETAIL_24);

      addDetail();
    }
    return detail;

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
   * ���O�C�����Ə����擾���܂��B
   * @return ���O�C�����Ə�
   */
  public ACLabel getLoginProviderInfo(){
    if(loginProviderInfo==null){

      loginProviderInfo = new ACLabel();

      loginProviderInfo.setText("���O�C�����Ə� �Ɋւ���̎����쐬�������s�Ȃ��܂��B���̎��Ə���ΏۂƂ���ꍇ�́A���O�A�E�g���s�����Ə���I�����Ȃ����Ă��������B");

      loginProviderInfo.setIconPath(ACConstants.ICON_PATH_INFORMATION_16);

      loginProviderInfo.setAutoWrap(true);

      addLoginProviderInfo();
    }
    return loginProviderInfo;

  }

  /**
   * ���o�����̈���擾���܂��B
   * @return ���o�����̈�
   */
  public ACGroupBox getFindCondition(){
    if(findCondition==null){

      findCondition = new ACGroupBox();

      findCondition.setText("���o����");

      findCondition.setAutoWrap(false);

      findCondition.setHgap(0);

      addFindCondition();
    }
    return findCondition;

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
   * ���їL�����ʂ��擾���܂��B
   * @return ���їL������
   */
  public ACIntegerCheckBox getOnlyExistsResult(){
    if(onlyExistsResult==null){

      onlyExistsResult = new ACIntegerCheckBox();

      onlyExistsResult.setText("���т̂��闘�p�҂�����\��(V)");

      onlyExistsResult.setBindPath("ONLY_EXISTS_RESULT");

      onlyExistsResult.setMnemonic('V');

      addOnlyExistsResult();
    }
    return onlyExistsResult;

  }

  /**
   * �ی��Ҕԍ��R���e�i���擾���܂��B
   * @return �ی��Ҕԍ��R���e�i
   */
  public ACLabelContainer getInsurerContainer(){
    if(insurerContainer==null){

      insurerContainer = new ACLabelContainer();

      insurerContainer.setText("�ی��Ҕԍ�");

      addInsurerContainer();
    }
    return insurerContainer;

  }

  /**
   * �ی��Ҕԍ����擾���܂��B
   * @return �ی��Ҕԍ�
   */
  public ACTextField getInsurerID(){
    if(insurerID==null){

      insurerID = new ACTextField();

      insurerID.setBindPath("INSURER_NO");

      insurerID.setColumns(8);

      insurerID.setCharType(VRCharType.ONLY_DIGIT);

      insurerID.setIMEMode(InputSubset.LATIN);

      insurerID.setMaxLength(8);

      addInsurerID();
    }
    return insurerID;

  }

  /**
   * �ی��Җ����擾���܂��B
   * @return �ی��Җ�
   */
  public ACComboBox getInsurerName(){
    if(insurerName==null){

      insurerName = new ACComboBox();

      insurerName.setBindPath("INSURER_NAME");

      insurerName.setEditable(false);

      insurerName.setRenderBindPath("INSURER_NAME");

      insurerName.setBlankable(true);

      insurerName.setModel(getInsurerNameModel());

      addInsurerName();
    }
    return insurerName;

  }

  /**
   * �ی��Җ����f�����擾���܂��B
   * @return �ی��Җ����f��
   */
  protected ACComboBoxModelAdapter getInsurerNameModel(){
    if(insurerNameModel==null){
      insurerNameModel = new ACComboBoxModelAdapter();
      addInsurerNameModel();
    }
    return insurerNameModel;
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

      patientCode.setColumns(15);

      patientCode.setCharType(VRCharType.ONLY_HALF_CHAR);

      patientCode.setIMEMode(InputSubset.LATIN);

      patientCode.setMaxLength(15);

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
   * ���p�҂ӂ肪�Ȃ��擾���܂��B
   * @return ���p�҂ӂ肪��
   */
  public ACTextField getPatientKana(){
    if(patientKana==null){

      patientKana = new ACTextField();

      getPatientKanaContainer().setText("���p�҂ӂ肪��");

      patientKana.setBindPath("PATIENT_KANA");

      patientKana.setColumns(40);

      patientKana.setIMEMode(InputSubset.KANJI);

      patientKana.setMaxLength(40);

      addPatientKana();
    }
    return patientKana;

  }

  /**
   * ���p�҂ӂ肪�ȃR���e�i���擾���܂��B
   * @return ���p�҂ӂ肪�ȃR���e�i
   */
  protected ACLabelContainer getPatientKanaContainer(){
    if(patientKanaContainer==null){
      patientKanaContainer = new ACLabelContainer();
      patientKanaContainer.setFollowChildEnabled(true);
      patientKanaContainer.setVAlignment(VRLayout.CENTER);
      patientKanaContainer.add(getPatientKana(), null);
    }
    return patientKanaContainer;
  }

  /**
   * �L���E�ԍ����擾���܂��B
   * @return �L���E�ԍ�
   */
  public ACTextField getPatientInsuredID(){
    if(patientInsuredID==null){

      patientInsuredID = new ACTextField();

      getPatientInsuredIDContainer().setText("�L���E�ԍ�");

      patientInsuredID.setBindPath("MEDICAL_INSURE_ID");

      patientInsuredID.setColumns(16);

      patientInsuredID.setIMEMode(InputSubset.KANJI);

      patientInsuredID.setMaxLength(16);

      addPatientInsuredID();
    }
    return patientInsuredID;

  }

  /**
   * �L���E�ԍ��R���e�i���擾���܂��B
   * @return �L���E�ԍ��R���e�i
   */
  protected ACLabelContainer getPatientInsuredIDContainer(){
    if(patientInsuredIDContainer==null){
      patientInsuredIDContainer = new ACLabelContainer();
      patientInsuredIDContainer.setFollowChildEnabled(true);
      patientInsuredIDContainer.setVAlignment(VRLayout.CENTER);
      patientInsuredIDContainer.add(getPatientInsuredID(), null);
    }
    return patientInsuredIDContainer;
  }

  /**
   * ���p�҈ꗗ���擾���܂��B
   * @return ���p�҈ꗗ
   */
  public ACTable getPatients(){
    if(patients==null){

      patients = new ACTable();

      patients.setColumnModel(getPatientsColumnModel());

      addPatients();
    }
    return patients;

  }

  /**
   * ���p�҈ꗗ�J�������f�����擾���܂��B
   * @return ���p�҈ꗗ�J�������f��
   */
  protected VRTableColumnModel getPatientsColumnModel(){
    if(patientsColumnModel==null){
      patientsColumnModel = new VRTableColumnModel(new TableColumn[]{});
      addPatientsColumnModel();
    }
    return patientsColumnModel;
  }

  /**
   * ���p�҈ꗗ�FNo.���擾���܂��B
   * @return ���p�҈ꗗ�FNo.
   */
  public ACTableColumn getPatinetNoColumn(){
    if(patinetNoColumn==null){

      patinetNoColumn = new ACTableColumn();

      patinetNoColumn.setHeaderValue("No.");

      patinetNoColumn.setColumnName("INSURER_ID");

      patinetNoColumn.setColumns(3);

      patinetNoColumn.setRendererType(ACTableCellViewer.RENDERER_TYPE_SERIAL_NO);

      patinetNoColumn.setSortable(false);

      addPatinetNoColumn();
    }
    return patinetNoColumn;

  }

  /**
   * ���p�҈ꗗ�F�ی��Ҕԍ����擾���܂��B
   * @return ���p�҈ꗗ�F�ی��Ҕԍ�
   */
  public ACTableColumn getPatientInsurerIDColumn(){
    if(patientInsurerIDColumn==null){

      patientInsurerIDColumn = new ACTableColumn();

      patientInsurerIDColumn.setHeaderValue("�ی��Ҕԍ�");

      patientInsurerIDColumn.setColumnName("INSURER_ID");

      patientInsurerIDColumn.setColumns(8);

      addPatientInsurerIDColumn();
    }
    return patientInsurerIDColumn;

  }

  /**
   * ���p�҈ꗗ�F�ی��Җ��̂��擾���܂��B
   * @return ���p�҈ꗗ�F�ی��Җ���
   */
  public ACTableColumn getPatientInsurerNameColumn(){
    if(patientInsurerNameColumn==null){

      patientInsurerNameColumn = new ACTableColumn();

      patientInsurerNameColumn.setHeaderValue("�ی��Җ���");

      patientInsurerNameColumn.setColumnName("INSURER_ID");

      patientInsurerNameColumn.setColumns(10);

      addPatientInsurerNameColumn();
    }
    return patientInsurerNameColumn;

  }

  /**
   * ���p�҈ꗗ�F���p�҃R�[�h���擾���܂��B
   * @return ���p�҈ꗗ�F���p�҃R�[�h
   */
  public ACTableColumn getPatientCodeColumn(){
    if(patientCodeColumn==null){

      patientCodeColumn = new ACTableColumn();

      patientCodeColumn.setHeaderValue("���p�҃R�[�h");

      patientCodeColumn.setColumnName("PATIENT_CODE");

      patientCodeColumn.setColumns(10);

      addPatientCodeColumn();
    }
    return patientCodeColumn;

  }

  /**
   * ���p�҈ꗗ�F�L���E�ԍ����擾���܂��B
   * @return ���p�҈ꗗ�F�L���E�ԍ�
   */
  public ACTableColumn getPatientInsuredIDColumn(){
    if(patientInsuredIDColumn==null){

      patientInsuredIDColumn = new ACTableColumn();

      patientInsuredIDColumn.setHeaderValue("�L���E�ԍ�");

      patientInsuredIDColumn.setColumnName("MEDICAL_INSURE_ID");

      patientInsuredIDColumn.setColumns(16);

      addPatientInsuredIDColumn();
    }
    return patientInsuredIDColumn;

  }

  /**
   * ���p�҈ꗗ�F���p�Ҏ������擾���܂��B
   * @return ���p�҈ꗗ�F���p�Ҏ���
   */
  public ACTableColumn getPatientNameColumn(){
    if(patientNameColumn==null){

      patientNameColumn = new ACTableColumn();

      patientNameColumn.setHeaderValue("���p�Ҏ���");

      patientNameColumn.setColumnName("PATIENT_FAMILY_NAME+'�@'+PATIENT_FIRST_NAME");

      patientNameColumn.setColumns(10);

      addPatientNameColumn();
    }
    return patientNameColumn;

  }

  /**
   * ���p�҈ꗗ�F�ӂ肪�Ȃ��擾���܂��B
   * @return ���p�҈ꗗ�F�ӂ肪��
   */
  public ACTableColumn getPatientKanaColumn(){
    if(patientKanaColumn==null){

      patientKanaColumn = new ACTableColumn();

      patientKanaColumn.setHeaderValue("�ӂ肪��");

      patientKanaColumn.setColumnName("PATIENT_FAMILY_KANA+'�@'+PATIENT_FIRST_KANA");

      patientKanaColumn.setColumns(10);

      addPatientKanaColumn();
    }
    return patientKanaColumn;

  }

  /**
   * ���p�҈ꗗ�F���ʂ��擾���܂��B
   * @return ���p�҈ꗗ�F����
   */
  public ACTableColumn getPatientSexColumn(){
    if(patientSexColumn==null){

      patientSexColumn = new ACTableColumn();

      patientSexColumn.setHeaderValue("����");

      patientSexColumn.setColumnName("PATIENT_SEX");

      patientSexColumn.setColumns(4);

      patientSexColumn.setFormat(QkanConstants.FORMAT_SEX);

      addPatientSexColumn();
    }
    return patientSexColumn;

  }

  /**
   * ���p�҈ꗗ�F�N����擾���܂��B
   * @return ���p�҈ꗗ�F�N��
   */
  public ACTableColumn getPatientAgeColumn(){
    if(patientAgeColumn==null){

      patientAgeColumn = new ACTableColumn();

      patientAgeColumn.setHeaderValue("�N��");

      patientAgeColumn.setColumnName("PATIENT_BIRTHDAY");

      patientAgeColumn.setColumns(4);

      patientAgeColumn.setFormat(QkanConstants.FORMAT_NOW_AGE);

      addPatientAgeColumn();
    }
    return patientAgeColumn;

  }

  /**
   * ���p�҈ꗗ�F�ی��敪���擾���܂��B
   * @return ���p�҈ꗗ�F�ی��敪
   */
  public ACTableColumn getPatientInsureTypeColumn(){
    if(patientInsureTypeColumn==null){

      patientInsureTypeColumn = new ACTableColumn();

      patientInsureTypeColumn.setHeaderValue("�ی��敪");

      patientInsureTypeColumn.setColumnName("INSURE_TYPE");

      patientInsureTypeColumn.setColumns(6);

      patientInsureTypeColumn.setFormat(QkanInsureTypeFormat.getInstance());

      addPatientInsureTypeColumn();
    }
    return patientInsureTypeColumn;

  }

  /**
   * �R���X�g���N�^�ł��B
   */
  public QP010Design() {

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
   * �N���C�A���g�̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addContents(){

    contents.add(getLoginProviderInfo(), VRLayout.NORTH);

    contents.add(getFindCondition(), VRLayout.NORTH);

    contents.add(getPatients(), VRLayout.CLIENT);

  }

  /**
   * ���O�C�����Ə��ɓ������ڂ�ǉ����܂��B
   */
  protected void addLoginProviderInfo(){

  }

  /**
   * ���o�����̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addFindCondition(){

    findCondition.add(getTargetDateContainer(), VRLayout.FLOW);

    findCondition.add(getOnlyExistsResult(), VRLayout.FLOW_RETURN);

    findCondition.add(getInsurerContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    findCondition.add(getPatientCodeContainer(), VRLayout.FLOW_INSETLINE);

    findCondition.add(getPatientKanaContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    findCondition.add(getPatientInsuredIDContainer(), VRLayout.FLOW_INSETLINE);

  }

  /**
   * �Ώ۔N���ɓ������ڂ�ǉ����܂��B
   */
  protected void addTargetDate(){

  }

  /**
   * ���їL�����ʂɓ������ڂ�ǉ����܂��B
   */
  protected void addOnlyExistsResult(){

  }

  /**
   * �ی��Ҕԍ��R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addInsurerContainer(){

    insurerContainer.add(getInsurerID(), VRLayout.FLOW);

    insurerContainer.add(getInsurerName(), VRLayout.FLOW);

  }

  /**
   * �ی��Ҕԍ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addInsurerID(){

  }

  /**
   * �ی��Җ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addInsurerName(){

  }

  /**
   * �ی��Җ����f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addInsurerNameModel(){

  }

  /**
   * ���p�҃R�[�h�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatientCode(){

  }

  /**
   * ���p�҂ӂ肪�Ȃɓ������ڂ�ǉ����܂��B
   */
  protected void addPatientKana(){

  }

  /**
   * �L���E�ԍ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatientInsuredID(){

  }

  /**
   * ���p�҈ꗗ�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatients(){

  }

  /**
   * ���p�҈ꗗ�J�������f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatientsColumnModel(){

    getPatientsColumnModel().addColumn(getPatinetNoColumn());

    getPatientsColumnModel().addColumn(getPatientInsurerIDColumn());

    getPatientsColumnModel().addColumn(getPatientInsurerNameColumn());

    getPatientsColumnModel().addColumn(getPatientCodeColumn());

    getPatientsColumnModel().addColumn(getPatientInsuredIDColumn());

    getPatientsColumnModel().addColumn(getPatientNameColumn());

    getPatientsColumnModel().addColumn(getPatientKanaColumn());

    getPatientsColumnModel().addColumn(getPatientSexColumn());

    getPatientsColumnModel().addColumn(getPatientAgeColumn());

    getPatientsColumnModel().addColumn(getPatientInsureTypeColumn());

  }

  /**
   * ���p�҈ꗗ�FNo.�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatinetNoColumn(){

  }

  /**
   * ���p�҈ꗗ�F�ی��Ҕԍ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatientInsurerIDColumn(){

  }

  /**
   * ���p�҈ꗗ�F�ی��Җ��̂ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatientInsurerNameColumn(){

  }

  /**
   * ���p�҈ꗗ�F���p�҃R�[�h�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatientCodeColumn(){

  }

  /**
   * ���p�҈ꗗ�F�L���E�ԍ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatientInsuredIDColumn(){

  }

  /**
   * ���p�҈ꗗ�F���p�Ҏ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatientNameColumn(){

  }

  /**
   * ���p�҈ꗗ�F�ӂ肪�Ȃɓ������ڂ�ǉ����܂��B
   */
  protected void addPatientKanaColumn(){

  }

  /**
   * ���p�҈ꗗ�F���ʂɓ������ڂ�ǉ����܂��B
   */
  protected void addPatientSexColumn(){

  }

  /**
   * ���p�҈ꗗ�F�N��ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatientAgeColumn(){

  }

  /**
   * ���p�҈ꗗ�F�ی��敪�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatientInsureTypeColumn(){

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

    return getTargetDate();

  }
  public void initAffair(ACAffairInfo affair) throws Exception {
  }

  public static void main(String[] args) {
    //�f�t�H���g�f�o�b�O�N��
    try {
      ACFrame.getInstance().setFrameEventProcesser(new QkanFrameEventProcesser());
      ACFrame.debugStart(new ACAffairInfo(QP010Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QP010Design getThis() {
    return this;
  }
}
