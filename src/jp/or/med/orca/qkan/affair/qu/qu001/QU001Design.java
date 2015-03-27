
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
 * �쐬��: 2011/12/13  ���{�R���s���[�^�[������� �����@���v �V�K�쐬
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

  private ACAffairButton printReport;

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

  private ACGroupBox providerFindContents;

  private ACComboBox providerName;

  private ACLabelContainer providerNameContainer;

  private ACComboBoxModelAdapter providerNameModel;

  private ACComboBox senmonin;

  private ACLabelContainer senmoninContainer;

  private ACComboBoxModelAdapter senmoninModel;

  private ACTable patients;

  private VRTableColumnModel patientsColumnModel;

  private ACTableColumn patientNoColumn;

  private ACTableColumn patientEnabledColumn;

  private ACTableColumn patientReportColumn;

  private ACTableColumn patientFinishFlagColumn;

  private ACTableColumn patientChoiseColumn;

  private ACTableColumn patientCodeColumn;

  private ACTableColumn patientNameColumn;

  private ACTableColumn patientKanaColumn;

  private ACTableColumn patientSexColumn;

  private ACTableColumn patientBirthColumn;

  private ACTableColumn patientJotaiCodeColumn;

  private ACTableColumn patientInsuredIdColumn;

  private ACTableColumn patientInsureValidStartColumn;

  private ACTableColumn patientInsureValidEndColumn;

  private ACTableColumn patientInsurerIdColumn;

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
   * ���(P)���擾���܂��B
   * @return ���(P)
   */
  public ACAffairButton getPrintReport(){
    if(printReport==null){

      printReport = new ACAffairButton();

      printReport.setText("���(P)");

      printReport.setToolTipText("�I�����ꂽ���[�̈�����s���܂��B");

      printReport.setMnemonic('P');

      printReport.setIconPath(ACConstants.ICON_PATH_PRINT_24);

      addPrintReport();
    }
    return printReport;

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
        targetDate.setMinimumDate(QkanConstants.H2704);
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
   * ���Ə���񌟍��̈���擾���܂��B
   * @return ���Ə���񌟍��̈�
   */
  public ACGroupBox getProviderFindContents(){
    if(providerFindContents==null){

      providerFindContents = new ACGroupBox();

      providerFindContents.setText("���Ə����");

      addProviderFindContents();
    }
    return providerFindContents;

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

      providerName.setEditable(false);

      providerName.setColumns(18);

      providerName.setModelBindPath("PROVIDER_NAMES");

      providerName.setRenderBindPath("PROVIDER_NAME");

      providerName.setBlankable(true);

      providerName.setIMEMode(InputSubset.KANJI);

      providerName.setMaxLength(60);

      providerName.setMaxColumns(30);

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
   * ���x���������擾���܂��B
   * @return ���x������
   */
  public ACComboBox getSenmonin(){
    if(senmonin==null){

      senmonin = new ACComboBox();

      getSenmoninContainer().setText("���x������������");

      senmonin.setBindPath("SENMONIN");

      senmonin.setEditable(false);

      senmonin.setColumns(8);

      senmonin.setModelBindPath("SENMONIN");

      senmonin.setRenderBindPath("STAFF_NAME");

      senmonin.setBlankable(true);

      senmonin.setIMEMode(InputSubset.KANJI);

      senmonin.setMaxLength(32);

      senmonin.setMaxColumns(20);

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

      patientNoColumn = new ACTableColumn();

      patientNoColumn.setHeaderValue("No.");

      patientNoColumn.setColumnName("SHOW_FLAG");

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

      patientEnabledColumn = new ACTableColumn();

      patientEnabledColumn.setHeaderValue("�L��");

      patientEnabledColumn.setColumnName("SHOW_FLAG");

      patientEnabledColumn.setColumns(3);

      patientEnabledColumn.setHorizontalAlignment(SwingConstants.CENTER);

      patientEnabledColumn.setRendererType(ACTableCellViewer.RENDERER_TYPE_ICON);

      patientEnabledColumn.setSortable(false);

      addPatientEnabledColumn();
    }
    return patientEnabledColumn;

  }

  /**
   * ���p�҈ꗗ�F�L�����擾���܂��B
   * @return ���p�҈ꗗ�F�L��
   */
  public ACTableColumn getPatientReportColumn(){
    if(patientReportColumn==null){

      patientReportColumn = new ACTableColumn();

      patientReportColumn.setHeaderValue("�L��");

      patientReportColumn.setColumnName("REPORT");

      patientReportColumn.setColumns(3);

      patientReportColumn.setHorizontalAlignment(SwingConstants.CENTER);

      patientReportColumn.setRendererType(ACTableCellViewer.RENDERER_TYPE_ICON);

      patientReportColumn.setSortable(false);

      addPatientReportColumn();
    }
    return patientReportColumn;

  }

  /**
   * ���p�҈ꗗ�F������擾���܂��B
   * @return ���p�҈ꗗ�F���
   */
  public ACTableColumn getPatientFinishFlagColumn(){
    if(patientFinishFlagColumn==null){

      patientFinishFlagColumn = new ACTableColumn();

      patientFinishFlagColumn.setHeaderValue("���");

      patientFinishFlagColumn.setColumnName("FINISH_FLAG");

      patientFinishFlagColumn.setColumns(3);

      patientFinishFlagColumn.setHorizontalAlignment(SwingConstants.LEFT);

      patientFinishFlagColumn.setSortable(true);

      addPatientFinishFlagColumn();
    }
    return patientFinishFlagColumn;

  }

  /**
   * ���p�҈ꗗ�F�I�����擾���܂��B
   * @return ���p�҈ꗗ�F�I��
   */
  public ACTableColumn getPatientChoiseColumn(){
    if(patientChoiseColumn==null){

      patientChoiseColumn = new ACTableColumn();

      patientChoiseColumn.setHeaderValue("�I��");

      patientChoiseColumn.setColumnName("CHOISE");

      patientChoiseColumn.setEditable(true);

      patientChoiseColumn.setColumns(3);

      patientChoiseColumn.setHorizontalAlignment(SwingConstants.CENTER);

      patientChoiseColumn.setRendererType(VRTableCellViewer.RENDERER_TYPE_CHECK_BOX);

      patientChoiseColumn.setEditorType(VRTableCellViewer.EDITOR_TYPE_CHECK_BOX);

      patientChoiseColumn.setHeaderPopupMenu( new ACCheckBoxTableColumnPopupMenu(getPatients(), "CHOISE", new Boolean(true), new Boolean(false)) );

      addPatientChoiseColumn();
    }
    return patientChoiseColumn;

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

      patientCodeColumn.setColumns(7);

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

      patientNameColumn = new ACTableColumn();

      patientNameColumn.setHeaderValue("����");

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

      patientSexColumn = new ACTableColumn();

      patientSexColumn.setHeaderValue("����");

      patientSexColumn.setColumnName("PATIENT_SEX");

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

      patientBirthColumn = new ACTableColumn();

      patientBirthColumn.setHeaderValue("���N����");

      patientBirthColumn.setColumnName("PATIENT_BIRTHDAY");

      patientBirthColumn.setColumns(10);

      patientBirthColumn.setFormat(new ACBorderBlankDateFormat("gggee�NMM��dd��"));

      addPatientBirthColumn();
    }
    return patientBirthColumn;

  }

  /**
   * ���p�҈ꗗ�F�v���x���擾���܂��B
   * @return ���p�҈ꗗ�F�v���x
   */
  public ACTableColumn getPatientJotaiCodeColumn(){
    if(patientJotaiCodeColumn==null){

      patientJotaiCodeColumn = new ACTableColumn();

      patientJotaiCodeColumn.setHeaderValue("�v���x");

      patientJotaiCodeColumn.setColumnName("JOTAI_CODE");

      patientJotaiCodeColumn.setColumns(6);

      patientJotaiCodeColumn.setFormat(QkanJotaiCodeFormat.getInstance());

      addPatientJotaiCodeColumn();
    }
    return patientJotaiCodeColumn;

  }

  /**
   * ���p�҈ꗗ�F��ی��Ҕԍ����擾���܂��B
   * @return ���p�҈ꗗ�F��ی��Ҕԍ�
   */
  public ACTableColumn getPatientInsuredIdColumn(){
    if(patientInsuredIdColumn==null){

      patientInsuredIdColumn = new ACTableColumn();

      patientInsuredIdColumn.setHeaderValue("��ی��Ҕԍ�");

      patientInsuredIdColumn.setColumnName("INSURED_ID");

      patientInsuredIdColumn.setColumns(8);

      addPatientInsuredIdColumn();
    }
    return patientInsuredIdColumn;

  }

  /**
   * ���p�҈ꗗ�F�L�������J�n���擾���܂��B
   * @return ���p�҈ꗗ�F�L�������J�n
   */
  public ACTableColumn getPatientInsureValidStartColumn(){
    if(patientInsureValidStartColumn==null){

      patientInsureValidStartColumn = new ACTableColumn();

      patientInsureValidStartColumn.setHeaderValue("�L�������J�n");

      patientInsureValidStartColumn.setColumnName("INSURE_VALID_START");

      patientInsureValidStartColumn.setColumns(10);

      patientInsureValidStartColumn.setFormat(new ACBorderBlankDateFormat("gggee�NMM��dd��"));

      addPatientInsureValidStartColumn();
    }
    return patientInsureValidStartColumn;

  }

  /**
   * ���p�҈ꗗ�F�L�������I�����擾���܂��B
   * @return ���p�҈ꗗ�F�L�������I��
   */
  public ACTableColumn getPatientInsureValidEndColumn(){
    if(patientInsureValidEndColumn==null){

      patientInsureValidEndColumn = new ACTableColumn();

      patientInsureValidEndColumn.setHeaderValue("�L�������I��");

      patientInsureValidEndColumn.setColumnName("INSURE_VALID_END");

      patientInsureValidEndColumn.setColumns(10);

      patientInsureValidEndColumn.setFormat(new ACBorderBlankDateFormat("gggee�NMM��dd��"));

      addPatientInsureValidEndColumn();
    }
    return patientInsureValidEndColumn;

  }

  /**
   * ���p�҈ꗗ�F�ی��Ҕԍ����擾���܂��B
   * @return ���p�҈ꗗ�F�ی��Ҕԍ�
   */
  public ACTableColumn getPatientInsurerIdColumn(){
    if(patientInsurerIdColumn==null){

      patientInsurerIdColumn = new ACTableColumn();

      patientInsurerIdColumn.setHeaderValue("�ی��Ҕԍ�");

      patientInsurerIdColumn.setColumnName("INSURER_ID");

      patientInsurerIdColumn.setColumns(6);

      addPatientInsurerIdColumn();
    }
    return patientInsurerIdColumn;

  }

  /**
   * ���p�҈ꗗ�F�X�֔ԍ����擾���܂��B
   * @return ���p�҈ꗗ�F�X�֔ԍ�
   */
  public ACTableColumn getPatientZipColumn(){
    if(patientZipColumn==null){

      patientZipColumn = new ACTableColumn();

      patientZipColumn.setHeaderValue("�X�֔ԍ�");

      patientZipColumn.setColumnName("PATIENT_ZIP_FIRST+'-'+PATIENT_ZIP_SECOND");

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

      patientAddressColumn = new ACTableColumn();

      patientAddressColumn.setHeaderValue("�Z��");

      patientAddressColumn.setColumnName("PATIENT_ADDRESS");

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

      patientTelColumn = new ACTableColumn();

      patientTelColumn.setHeaderValue("�d�b�ԍ�");

      patientTelColumn.setColumnName("PATIENT_TEL_FIRST+'-'+PATIENT_TEL_SECOND+'-'+PATIENT_TEL_THIRD");

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
    buttons.add(getPrintReport(), VRLayout.EAST);
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
   * ���(P)�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPrintReport(){

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

    contents.add(getProviderFindContents(), VRLayout.NORTH);

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
   * ���Ə���񌟍��̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderFindContents(){

    providerFindContents.add(getProviderNameContainer(), VRLayout.FLOW);

    providerFindContents.add(getSenmoninContainer(), VRLayout.FLOW);

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

    getPatientsColumnModel().addColumn(getPatientReportColumn());

    getPatientsColumnModel().addColumn(getPatientFinishFlagColumn());

    getPatientsColumnModel().addColumn(getPatientChoiseColumn());

    getPatientsColumnModel().addColumn(getPatientCodeColumn());

    getPatientsColumnModel().addColumn(getPatientNameColumn());

    getPatientsColumnModel().addColumn(getPatientKanaColumn());

    getPatientsColumnModel().addColumn(getPatientSexColumn());

    getPatientsColumnModel().addColumn(getPatientBirthColumn());

    getPatientsColumnModel().addColumn(getPatientJotaiCodeColumn());

    getPatientsColumnModel().addColumn(getPatientInsuredIdColumn());

    getPatientsColumnModel().addColumn(getPatientInsureValidStartColumn());

    getPatientsColumnModel().addColumn(getPatientInsureValidEndColumn());

    getPatientsColumnModel().addColumn(getPatientInsurerIdColumn());

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
   * ���p�҈ꗗ�F�L���ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatientReportColumn(){

  }

  /**
   * ���p�҈ꗗ�F����ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatientFinishFlagColumn(){

  }

  /**
   * ���p�҈ꗗ�F�I���ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatientChoiseColumn(){

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
   * ���p�҈ꗗ�F���N�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatientBirthColumn(){

  }

  /**
   * ���p�҈ꗗ�F�v���x�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatientJotaiCodeColumn(){

  }

  /**
   * ���p�҈ꗗ�F��ی��Ҕԍ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatientInsuredIdColumn(){

  }

  /**
   * ���p�҈ꗗ�F�L�������J�n�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatientInsureValidStartColumn(){

  }

  /**
   * ���p�҈ꗗ�F�L�������I���ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatientInsureValidEndColumn(){

  }

  /**
   * ���p�҈ꗗ�F�ی��Ҕԍ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatientInsurerIdColumn(){

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
