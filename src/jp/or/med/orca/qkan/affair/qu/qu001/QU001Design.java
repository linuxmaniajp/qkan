
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
 * �J����: �����@���v
 * �쐬��: 2006/04/17  ���{�R���s���[�^�[������� �����@���v �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���p�ҊǗ� (U)
 * �v���Z�X ���p�҈ꗗ (001)
 * �v���O���� ���p�҈ꗗ (QU001)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qu.qu001;
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
 * ���p�҈ꗗ��ʍ��ڃf�U�C��(QU001) 
 */
public class QU001Design extends QkanAffairContainer implements ACAffairable {
  //GUI�R���|�[�l���g

  private ACAffairButtonBar buttons;

  private ACAffairButton find;

  private ACAffairButton detail;

  private ACAffairButton insert;

  private ACAffairButton delete;

  private ACAffairButton print;

  private ACAffairButton planInsert;

  private ACAffairButton resultInsert;

  private ACPanel contents;

  private ACPanel findConditions;

  private QkanYearDateTextField targetDate;

  private ACLabelContainer targetDateContainer;

  private ACTextField patientCode;

  private ACLabelContainer patientCodeContainer;

  private ACLabelContainer nowNotEnabledPatientIncludeFindContainer;

  private ACIntegerCheckBox nowNotEnabledPatientIncludeFind;

  private ACTextField patientKana;

  private ACLabelContainer patientKanaContainer;

  private QkanDateTextField birthday;

  private ACLabelContainer birthdayContainer;

  private ACTable patients;

  private VRTableColumnModel patientsColumnModel;

  private ACTableColumn patientNoColumn;

  private ACTableColumn patientEnabledColumn;

  private ACTableColumn patientCodeColumn;

  private ACTableColumn patientNameColumn;

  private ACTableColumn patientKanaColumn;

  private ACTableColumn patientSexColumn;

  private ACTableColumn patientBirthColumn;

  private ACTableColumn patientZipColumn;

  private ACTableColumn patientAddressColumn;

  private ACTableColumn patientTelColumn;

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
   * ����(F)���擾���܂��B
   * @return ����(F)
   */
  public ACAffairButton getFind(){
    if(find==null){

      find = new ACAffairButton();

      find.setText("����(F)");

      find.setToolTipText("���ݓ��͂���Ă�������ɂ��A�ꗗ��\�����܂��B");

      find.setMnemonic('F');

      find.setIconPath(ACConstants.ICON_PATH_FIND_24);

      addFind();
    }
    return find;

  }

  /**
   * �ڍ�(E)���擾���܂��B
   * @return �ڍ�(E)
   */
  public ACAffairButton getDetail(){
    if(detail==null){

      detail = new ACAffairButton();

      detail.setText("�ڍ�(E)");

      detail.setToolTipText("�I�����ꂽ���p�҂̕ҏW��ʂɈڂ�܂��B");

      detail.setMnemonic('E');

      detail.setIconPath(ACConstants.ICON_PATH_DETAIL_24);

      addDetail();
    }
    return detail;

  }

  /**
   * �V�K(N)���擾���܂��B
   * @return �V�K(N)
   */
  public ACAffairButton getInsert(){
    if(insert==null){

      insert = new ACAffairButton();

      insert.setText("�V�K(N)");

      insert.setToolTipText("���p�ҏ���V�K�ɍ쐬���܂��B");

      insert.setMnemonic('N');

      insert.setIconPath(ACConstants.ICON_PATH_NEW_24);

      addInsert();
    }
    return insert;

  }

  /**
   * �폜(D)���擾���܂��B
   * @return �폜(D)
   */
  public ACAffairButton getDelete(){
    if(delete==null){

      delete = new ACAffairButton();

      delete.setText("�폜(D)");

      delete.setToolTipText("�I�����ꂽ���p�҂̏����폜���܂��B");

      delete.setMnemonic('D');

      delete.setIconPath(ACConstants.ICON_PATH_DELETE_24);

      addDelete();
    }
    return delete;

  }

  /**
   * �ꗗ���(P)���擾���܂��B
   * @return �ꗗ���(P)
   */
  public ACAffairButton getPrint(){
    if(print==null){

      print = new ACAffairButton();

      print.setText("�ꗗ���(P)");

      print.setToolTipText("�o�^���p�҈ꗗ�\��������܂��B");

      print.setMnemonic('P');

      print.setIconPath(ACConstants.ICON_PATH_TABLE_PRINT_24);

      addPrint();
    }
    return print;

  }

  /**
   * �\��o�^(E)���擾���܂��B
   * @return �\��o�^(E)
   */
  public ACAffairButton getPlanInsert(){
    if(planInsert==null){

      planInsert = new ACAffairButton();

      planInsert.setText("�\��o�^(E)");

      planInsert.setToolTipText("�I�����ꂽ���p�҂̃T�[�r�X�\��o�^��ʂɈڂ�܂��B");

      planInsert.setMnemonic('E');

      planInsert.setIconPath(ACConstants.ICON_PATH_DETAIL_24);

      addPlanInsert();
    }
    return planInsert;

  }

  /**
   * ���ѓo�^(E)���擾���܂��B
   * @return ���ѓo�^(E)
   */
  public ACAffairButton getResultInsert(){
    if(resultInsert==null){

      resultInsert = new ACAffairButton();

      resultInsert.setText("���ѓo�^(E)");

      resultInsert.setToolTipText("�I�����ꂽ���p�҂̃T�[�r�X���ѓo�^��ʂɈڂ�܂��B");

      resultInsert.setMnemonic('E');

      resultInsert.setIconPath(ACConstants.ICON_PATH_DETAIL_24);

      addResultInsert();
    }
    return resultInsert;

  }

  /**
   * ���͗̈���擾���܂��B
   * @return ���͗̈�
   */
  public ACPanel getContents(){
    if(contents==null){

      contents = new ACPanel();

      addContents();
    }
    return contents;

  }

  /**
   * ���������̈���擾���܂��B
   * @return ���������̈�
   */
  public ACPanel getFindConditions(){
    if(findConditions==null){

      findConditions = new ACPanel();

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
   * ���p��Cd���擾���܂��B
   * @return ���p��Cd
   */
  public ACTextField getPatientCode(){
    if(patientCode==null){

      patientCode = new ACTextField();

      getPatientCodeContainer().setText("���p�҃R�[�h");

      patientCode.setBindPath("PATIENT_CODE");

      patientCode.setColumns(16);

      patientCode.setCharType(VRCharType.ONLY_HALF_CHAR);

      patientCode.setHorizontalAlignment(SwingConstants.LEFT);

      patientCode.setIMEMode(InputSubset.LATIN);

      patientCode.setMaxLength(16);

      addPatientCode();
    }
    return patientCode;

  }

  /**
   * ���p��Cd�R���e�i���擾���܂��B
   * @return ���p��Cd�R���e�i
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
   * ���ݗL���łȂ����p�҂��܂߂Č����R���e�i���擾���܂��B
   * @return ���ݗL���łȂ����p�҂��܂߂Č����R���e�i
   */
  public ACLabelContainer getNowNotEnabledPatientIncludeFindContainer(){
    if(nowNotEnabledPatientIncludeFindContainer==null){

      nowNotEnabledPatientIncludeFindContainer = new ACLabelContainer();

      addNowNotEnabledPatientIncludeFindContainer();
    }
    return nowNotEnabledPatientIncludeFindContainer;

  }

  /**
   * ���ݗL���łȂ����p�҂��܂߂Č������擾���܂��B
   * @return ���ݗL���łȂ����p�҂��܂߂Č���
   */
  public ACIntegerCheckBox getNowNotEnabledPatientIncludeFind(){
    if(nowNotEnabledPatientIncludeFind==null){

      nowNotEnabledPatientIncludeFind = new ACIntegerCheckBox();

      nowNotEnabledPatientIncludeFind.setText("���ݗL���łȂ����p�҂��܂߂Č�������(A)");

      nowNotEnabledPatientIncludeFind.setBindPath("HIDE_FLAG");

      nowNotEnabledPatientIncludeFind.setMnemonic('A');

      addNowNotEnabledPatientIncludeFind();
    }
    return nowNotEnabledPatientIncludeFind;

  }

  /**
   * �ӂ肪�Ȃ��擾���܂��B
   * @return �ӂ肪��
   */
  public ACTextField getPatientKana(){
    if(patientKana==null){

      patientKana = new ACTextField();

      getPatientKanaContainer().setText("�ӂ肪��");

      patientKana.setBindPath("PATIENT_KANA");

      patientKana.setColumns(16);

      patientKana.setHorizontalAlignment(SwingConstants.LEFT);

      patientKana.setIMEMode(InputSubset.KANJI);

      patientKana.setMaxLength(32);

      addPatientKana();
    }
    return patientKana;

  }

  /**
   * �ӂ肪�ȃR���e�i���擾���܂��B
   * @return �ӂ肪�ȃR���e�i
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
   * ���N�������擾���܂��B
   * @return ���N����
   */
  public QkanDateTextField getBirthday(){
    if(birthday==null){

      birthday = new QkanDateTextField();

      getBirthdayContainer().setText("���N����");

      birthday.setBindPath("PATIENT_BIRTHDAY");

      addBirthday();
    }
    return birthday;

  }

  /**
   * ���N�����R���e�i���擾���܂��B
   * @return ���N�����R���e�i
   */
  protected ACLabelContainer getBirthdayContainer(){
    if(birthdayContainer==null){
      birthdayContainer = new ACLabelContainer();
      birthdayContainer.setFollowChildEnabled(true);
      birthdayContainer.setVAlignment(VRLayout.CENTER);
      birthdayContainer.add(getBirthday(), null);
    }
    return birthdayContainer;
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
  public ACTableColumn getPatientNoColumn(){
    if(patientNoColumn==null){

      patientNoColumn = new ACTableColumn(0);

      patientNoColumn.setHeaderValue("No.");

      patientNoColumn.setColumns(3);

      patientNoColumn.setRendererType(ACTableCellViewer.RENDERER_TYPE_SERIAL_NO);

      patientNoColumn.setSortable(false);

      addPatientNoColumn();
    }
    return patientNoColumn;

  }

  /**
   * ���p�҈ꗗ�F�L�����擾���܂��B
   * @return ���p�҈ꗗ�F�L��
   */
  public ACTableColumn getPatientEnabledColumn(){
    if(patientEnabledColumn==null){

      patientEnabledColumn = new ACTableColumn(0);

      patientEnabledColumn.setHeaderValue("�L��");

      patientEnabledColumn.setColumns(3);

      patientEnabledColumn.setHorizontalAlignment(SwingConstants.CENTER);

      patientEnabledColumn.setRendererType(ACTableCellViewer.RENDERER_TYPE_ICON);

      patientEnabledColumn.setSortable(false);

      addPatientEnabledColumn();
    }
    return patientEnabledColumn;

  }

  /**
   * ���p�҈ꗗ�F���p�҃R�[�h���擾���܂��B
   * @return ���p�҈ꗗ�F���p�҃R�[�h
   */
  public ACTableColumn getPatientCodeColumn(){
    if(patientCodeColumn==null){

      patientCodeColumn = new ACTableColumn(1);

      patientCodeColumn.setHeaderValue("���p�҃R�[�h");

      patientCodeColumn.setColumns(8);

      addPatientCodeColumn();
    }
    return patientCodeColumn;

  }

  /**
   * ���p�҈ꗗ�F�������擾���܂��B
   * @return ���p�҈ꗗ�F����
   */
  public ACTableColumn getPatientNameColumn(){
    if(patientNameColumn==null){

      patientNameColumn = new ACTableColumn(2);

      patientNameColumn.setHeaderValue("����");

      patientNameColumn.setColumns(10);

      addPatientNameColumn();
    }
    return patientNameColumn;

  }

  /**
   * ���p�җ��F�ӂ肪�Ȃ��擾���܂��B
   * @return ���p�җ��F�ӂ肪��
   */
  public ACTableColumn getPatientKanaColumn(){
    if(patientKanaColumn==null){

      patientKanaColumn = new ACTableColumn(3);

      patientKanaColumn.setHeaderValue("�ӂ肪��");

      patientKanaColumn.setColumns(15);

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

      patientSexColumn = new ACTableColumn(4);

      patientSexColumn.setHeaderValue("����");

      patientSexColumn.setColumns(3);

      patientSexColumn.setFormat(QkanConstants.FORMAT_SEX);

      addPatientSexColumn();
    }
    return patientSexColumn;

  }

  /**
   * ���p�҈ꗗ�F���N�������擾���܂��B
   * @return ���p�҈ꗗ�F���N����
   */
  public ACTableColumn getPatientBirthColumn(){
    if(patientBirthColumn==null){

      patientBirthColumn = new ACTableColumn(5);

      patientBirthColumn.setHeaderValue("���N����");

      patientBirthColumn.setColumns(10);

      patientBirthColumn.setFormat(new ACBorderBlankDateFormat("gggee�NMM��dd��"));

      addPatientBirthColumn();
    }
    return patientBirthColumn;

  }

  /**
   * ���p�҈ꗗ�F�X�֔ԍ����擾���܂��B
   * @return ���p�҈ꗗ�F�X�֔ԍ�
   */
  public ACTableColumn getPatientZipColumn(){
    if(patientZipColumn==null){

      patientZipColumn = new ACTableColumn(6);

      patientZipColumn.setHeaderValue("�X�֔ԍ�");

      patientZipColumn.setColumns(6);

      addPatientZipColumn();
    }
    return patientZipColumn;

  }

  /**
   * ���p�҈ꗗ�F�Z�����擾���܂��B
   * @return ���p�҈ꗗ�F�Z��
   */
  public ACTableColumn getPatientAddressColumn(){
    if(patientAddressColumn==null){

      patientAddressColumn = new ACTableColumn(7);

      patientAddressColumn.setHeaderValue("�Z��");

      patientAddressColumn.setColumns(20);

      addPatientAddressColumn();
    }
    return patientAddressColumn;

  }

  /**
   * ���p�҈ꗗ�F�d�b�ԍ����擾���܂��B
   * @return ���p�҈ꗗ�F�d�b�ԍ�
   */
  public ACTableColumn getPatientTelColumn(){
    if(patientTelColumn==null){

      patientTelColumn = new ACTableColumn(8);

      patientTelColumn.setHeaderValue("�d�b�ԍ�");

      patientTelColumn.setColumns(20);

      addPatientTelColumn();
    }
    return patientTelColumn;

  }

  /**
   * �R���X�g���N�^�ł��B
   */
  public QU001Design() {

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

    buttons.add(getResultInsert(), VRLayout.EAST);
    buttons.add(getPlanInsert(), VRLayout.EAST);
    buttons.add(getPrint(), VRLayout.EAST);
    buttons.add(getDelete(), VRLayout.EAST);
    buttons.add(getInsert(), VRLayout.EAST);
    buttons.add(getDetail(), VRLayout.EAST);
    buttons.add(getFind(), VRLayout.EAST);
  }

  /**
   * ����(F)�ɓ������ڂ�ǉ����܂��B
   */
  protected void addFind(){

  }

  /**
   * �ڍ�(E)�ɓ������ڂ�ǉ����܂��B
   */
  protected void addDetail(){

  }

  /**
   * �V�K(N)�ɓ������ڂ�ǉ����܂��B
   */
  protected void addInsert(){

  }

  /**
   * �폜(D)�ɓ������ڂ�ǉ����܂��B
   */
  protected void addDelete(){

  }

  /**
   * �ꗗ���(P)�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPrint(){

  }

  /**
   * �\��o�^(E)�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPlanInsert(){

  }

  /**
   * ���ѓo�^(E)�ɓ������ڂ�ǉ����܂��B
   */
  protected void addResultInsert(){

  }

  /**
   * ���͗̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addContents(){

    contents.add(getFindConditions(), VRLayout.NORTH);

    contents.add(getPatients(), VRLayout.CLIENT);

  }

  /**
   * ���������̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addFindConditions(){

    findConditions.add(getTargetDateContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    findConditions.add(getPatientCodeContainer(), VRLayout.FLOW_INSETLINE);

    findConditions.add(getNowNotEnabledPatientIncludeFindContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    findConditions.add(getPatientKanaContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    findConditions.add(getBirthdayContainer(), VRLayout.FLOW_INSETLINE);

  }

  /**
   * �Ώ۔N���ɓ������ڂ�ǉ����܂��B
   */
  protected void addTargetDate(){

  }

  /**
   * ���p��Cd�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatientCode(){

  }

  /**
   * ���ݗL���łȂ����p�҂��܂߂Č����R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addNowNotEnabledPatientIncludeFindContainer(){

    nowNotEnabledPatientIncludeFindContainer.add(getNowNotEnabledPatientIncludeFind(), null);

  }

  /**
   * ���ݗL���łȂ����p�҂��܂߂Č����ɓ������ڂ�ǉ����܂��B
   */
  protected void addNowNotEnabledPatientIncludeFind(){

  }

  /**
   * �ӂ肪�Ȃɓ������ڂ�ǉ����܂��B
   */
  protected void addPatientKana(){

  }

  /**
   * ���N�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addBirthday(){

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

    getPatientsColumnModel().addColumn(getPatientNoColumn());

    getPatientsColumnModel().addColumn(getPatientEnabledColumn());

    getPatientsColumnModel().addColumn(getPatientCodeColumn());

    getPatientsColumnModel().addColumn(getPatientNameColumn());

    getPatientsColumnModel().addColumn(getPatientKanaColumn());

    getPatientsColumnModel().addColumn(getPatientSexColumn());

    getPatientsColumnModel().addColumn(getPatientBirthColumn());

    getPatientsColumnModel().addColumn(getPatientZipColumn());

    getPatientsColumnModel().addColumn(getPatientAddressColumn());

    getPatientsColumnModel().addColumn(getPatientTelColumn());

  }

  /**
   * ���p�҈ꗗ�FNo.�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatientNoColumn(){

  }

  /**
   * ���p�҈ꗗ�F�L���ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatientEnabledColumn(){

  }

  /**
   * ���p�҈ꗗ�F���p�҃R�[�h�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatientCodeColumn(){

  }

  /**
   * ���p�҈ꗗ�F�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatientNameColumn(){

  }

  /**
   * ���p�җ��F�ӂ肪�Ȃɓ������ڂ�ǉ����܂��B
   */
  protected void addPatientKanaColumn(){

  }

  /**
   * ���p�҈ꗗ�F���ʂɓ������ڂ�ǉ����܂��B
   */
  protected void addPatientSexColumn(){

  }

  /**
   * ���p�҈ꗗ�F���N�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatientBirthColumn(){

  }

  /**
   * ���p�҈ꗗ�F�X�֔ԍ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatientZipColumn(){

  }

  /**
   * ���p�҈ꗗ�F�Z���ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatientAddressColumn(){

  }

  /**
   * ���p�҈ꗗ�F�d�b�ԍ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatientTelColumn(){

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
      ACFrame.debugStart(new ACAffairInfo(QU001Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QU001Design getThis() {
    return this;
  }
}
