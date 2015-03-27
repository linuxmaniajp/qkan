
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
 * �J����: �����@���̂�
 * �쐬��: 2014/12/19  MIS��B������� �����@���̂� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���[�Ǘ� (C)
 * �v���Z�X ����×{�Ǘ��w���� (006)
 * �v���O���� ����×{�Ǘ��w�����ꗗ (QC006)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qc.qc006;
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
 * ����×{�Ǘ��w�����ꗗ��ʍ��ڃf�U�C��(QC006) 
 */
public class QC006Design extends QkanAffairContainer implements ACAffairable {
  //GUI�R���|�[�l���g

  private ACAffairButtonBar buttons;

  private ACAffairButton detail;

  private ACAffairButton insert;

  private ACAffairButton delete;

  private ACPanel contents;

  private ACPanel patientPanel;

  private ACLabel targetDateCaption;

  private ACLabel targetDateLabel;

  private ACLabel patinetNameLabel;

  private ACTextField patientName;

  private ACLabel patientNoLabel1;

  private ACTextField patientNo;

  private ACLabel PatientNoLabel2;

  private ACPanel kyotakuPanel;

  private ACTable kyotakuTable;

  private VRTableColumnModel kyotakuTableColumnModel;

  private ACTableColumn kyotakuTableColumn1;

  private ACTableColumn kyotakuTableColumn2;

  private ACTableColumn kyotakuTableColumn3;

  private ACTableColumn kyotakuTableColumn4;

  private ACTableColumn kyotakuTableColumn5;

  private ACTableColumn kyotakuTableColumn6;

  private ACTableColumn kyotakuTableColumn7;

  private ACTableColumn kyotakuTableColumn8;

  //getter

  /**
   * �{�^���o�[���擾���܂��B
   * @return �{�^���o�[
   */
  public ACAffairButtonBar getButtons(){
    if(buttons==null){

      buttons = new ACAffairButtonBar();

      buttons.setText("����×{�Ǘ��w�����ꗗ");

      addButtons();
    }
    return buttons;

  }

  /**
   * �ڍ�(E)���擾���܂��B
   * @return �ڍ�(E)
   */
  public ACAffairButton getDetail(){
    if(detail==null){

      detail = new ACAffairButton();

      detail.setText("�ڍ�(E)");

      detail.setToolTipText("�I�����ꂽ����×{�Ǘ��w�����̕ҏW��ʈڂ�܂��B");

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

      insert.setToolTipText("����×{�Ǘ��w������V�K�ɍ쐬���܂��B");

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

      delete.setToolTipText("�I�����ꂽ����×{�Ǘ��w�������폜���܂��B");

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
   * ���p�Җ��̈���擾���܂��B
   * @return ���p�Җ��̈�
   */
  public ACPanel getPatientPanel(){
    if(patientPanel==null){

      patientPanel = new ACPanel();

      patientPanel.setHgap(3);

      patientPanel.setVgap(3);

      addPatientPanel();
    }
    return patientPanel;

  }

  /**
   * �Ώ۔N���E���x�����擾���܂��B
   * @return �Ώ۔N���E���x��
   */
  public ACLabel getTargetDateCaption(){
    if(targetDateCaption==null){

      targetDateCaption = new ACLabel();

      targetDateCaption.setText("�@�Ώ۔N���F");

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
   * ���p�Җ��E���x�����擾���܂��B
   * @return ���p�Җ��E���x��
   */
  public ACLabel getPatinetNameLabel(){
    if(patinetNameLabel==null){

      patinetNameLabel = new ACLabel();

      patinetNameLabel.setText("�@���p�Җ��F");

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
   * �e�[�u���̈���擾���܂��B
   * @return �e�[�u���̈�
   */
  public ACPanel getKyotakuPanel(){
    if(kyotakuPanel==null){

      kyotakuPanel = new ACPanel();

      addKyotakuPanel();
    }
    return kyotakuPanel;

  }

  /**
   * ����×{�Ǘ��w�������e�[�u�����擾���܂��B
   * @return ����×{�Ǘ��w�������e�[�u��
   */
  public ACTable getKyotakuTable(){
    if(kyotakuTable==null){

      kyotakuTable = new ACTable();

      kyotakuTable.setColumnModel(getKyotakuTableColumnModel());

      addKyotakuTable();
    }
    return kyotakuTable;

  }

  /**
   * ����×{�Ǘ��w�������e�[�u���J�������f�����擾���܂��B
   * @return ����×{�Ǘ��w�������e�[�u���J�������f��
   */
  protected VRTableColumnModel getKyotakuTableColumnModel(){
    if(kyotakuTableColumnModel==null){
      kyotakuTableColumnModel = new VRTableColumnModel(new TableColumn[]{});
      addKyotakuTableColumnModel();
    }
    return kyotakuTableColumnModel;
  }

  /**
   * No.���擾���܂��B
   * @return No.
   */
  public ACTableColumn getKyotakuTableColumn1(){
    if(kyotakuTableColumn1==null){

      kyotakuTableColumn1 = new ACTableColumn();

      kyotakuTableColumn1.setHeaderValue("No.");

      kyotakuTableColumn1.setColumnName("NO");

      kyotakuTableColumn1.setColumns(3);

      kyotakuTableColumn1.setRendererType(ACTableCellViewer.RENDERER_TYPE_SERIAL_NO);

      kyotakuTableColumn1.setSortable(false);

      addKyotakuTableColumn1();
    }
    return kyotakuTableColumn1;

  }

  /**
   * ������擾���܂��B
   * @return ���
   */
  public ACTableColumn getKyotakuTableColumn2(){
    if(kyotakuTableColumn2==null){

      kyotakuTableColumn2 = new ACTableColumn();

      kyotakuTableColumn2.setHeaderValue("���");

      kyotakuTableColumn2.setColumnName("FINISH_FLAG");

      kyotakuTableColumn2.setColumns(3);

      kyotakuTableColumn2.setHorizontalAlignment(SwingConstants.LEFT);

      addKyotakuTableColumn2();
    }
    return kyotakuTableColumn2;

  }

  /**
   * �쐬�N�������擾���܂��B
   * @return �쐬�N����
   */
  public ACTableColumn getKyotakuTableColumn3(){
    if(kyotakuTableColumn3==null){

      kyotakuTableColumn3 = new ACTableColumn();

      kyotakuTableColumn3.setHeaderValue("�쐬�N����");

      kyotakuTableColumn3.setColumnName("CREATE_DATE_KYOTAKU");

      kyotakuTableColumn3.setColumns(7);

      kyotakuTableColumn3.setHorizontalAlignment(SwingConstants.LEFT);

      addKyotakuTableColumn3();
    }
    return kyotakuTableColumn3;

  }

  /**
   * ��Ë@�֖����擾���܂��B
   * @return ��Ë@�֖�
   */
  public ACTableColumn getKyotakuTableColumn4(){
    if(kyotakuTableColumn4==null){

      kyotakuTableColumn4 = new ACTableColumn();

      kyotakuTableColumn4.setHeaderValue("��Ë@�֖�");

      kyotakuTableColumn4.setColumnName("MEDICAL_FACILITY_NAME");

      kyotakuTableColumn4.setColumns(10);

      kyotakuTableColumn4.setHorizontalAlignment(SwingConstants.LEFT);

      addKyotakuTableColumn4();
    }
    return kyotakuTableColumn4;

  }

  /**
   * �S���㎁�����擾���܂��B
   * @return �S���㎁��
   */
  public ACTableColumn getKyotakuTableColumn5(){
    if(kyotakuTableColumn5==null){

      kyotakuTableColumn5 = new ACTableColumn();

      kyotakuTableColumn5.setHeaderValue("�S���㎁��");

      kyotakuTableColumn5.setColumnName("DOCTOR_NAME");

      kyotakuTableColumn5.setColumns(8);

      kyotakuTableColumn5.setHorizontalAlignment(SwingConstants.LEFT);

      addKyotakuTableColumn5();
    }
    return kyotakuTableColumn5;

  }

  /**
   * ���x���������擾���܂��B
   * @return ���x������
   */
  public ACTableColumn getKyotakuTableColumn6(){
    if(kyotakuTableColumn6==null){

      kyotakuTableColumn6 = new ACTableColumn();

      kyotakuTableColumn6.setHeaderValue("���x������");

      kyotakuTableColumn6.setColumnName("SENMONIN");

      kyotakuTableColumn6.setColumns(8);

      kyotakuTableColumn6.setHorizontalAlignment(SwingConstants.LEFT);

      addKyotakuTableColumn6();
    }
    return kyotakuTableColumn6;

  }

  /**
   * ���Ə������擾���܂��B
   * @return ���Ə���
   */
  public ACTableColumn getKyotakuTableColumn7(){
    if(kyotakuTableColumn7==null){

      kyotakuTableColumn7 = new ACTableColumn();

      kyotakuTableColumn7.setHeaderValue("���Ə���");

      kyotakuTableColumn7.setColumnName("PROVIDER_NAME");

      kyotakuTableColumn7.setColumns(10);

      kyotakuTableColumn7.setHorizontalAlignment(SwingConstants.LEFT);

      addKyotakuTableColumn7();
    }
    return kyotakuTableColumn7;

  }

  /**
   * �a����擾���܂��B
   * @return �a��
   */
  public ACTableColumn getKyotakuTableColumn8(){
    if(kyotakuTableColumn8==null){

      kyotakuTableColumn8 = new ACTableColumn();

      kyotakuTableColumn8.setHeaderValue("�a��");

      kyotakuTableColumn8.setColumnName("CONDITION");

      kyotakuTableColumn8.setColumns(20);

      kyotakuTableColumn8.setHorizontalAlignment(SwingConstants.LEFT);

      addKyotakuTableColumn8();
    }
    return kyotakuTableColumn8;

  }

  /**
   * �R���X�g���N�^�ł��B
   */
  public QC006Design() {

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
   * �N���C�A���g�̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addContents(){

    contents.add(getPatientPanel(), VRLayout.NORTH);

    contents.add(getKyotakuPanel(), VRLayout.CLIENT);

  }

  /**
   * ���p�Җ��̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatientPanel(){

    patientPanel.add(getTargetDateCaption(), VRLayout.FLOW);

    patientPanel.add(getTargetDateLabel(), VRLayout.FLOW_RETURN);

    patientPanel.add(getPatinetNameLabel(), VRLayout.FLOW);

    patientPanel.add(getPatientName(), VRLayout.FLOW);

    patientPanel.add(getPatientNoLabel1(), VRLayout.FLOW);

    patientPanel.add(getPatientNo(), VRLayout.FLOW);

    patientPanel.add(getPatientNoLabel2(), VRLayout.FLOW);

  }

  /**
   * �Ώ۔N���E���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addTargetDateCaption(){

  }

  /**
   * �Ώ۔N���ɓ������ڂ�ǉ����܂��B
   */
  protected void addTargetDateLabel(){

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
   * �e�[�u���̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKyotakuPanel(){

    kyotakuPanel.add(getKyotakuTable(), VRLayout.CLIENT);

  }

  /**
   * ����×{�Ǘ��w�������e�[�u���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKyotakuTable(){

  }

  /**
   * ����×{�Ǘ��w�������e�[�u���J�������f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKyotakuTableColumnModel(){

    getKyotakuTableColumnModel().addColumn(getKyotakuTableColumn1());

    getKyotakuTableColumnModel().addColumn(getKyotakuTableColumn2());

    getKyotakuTableColumnModel().addColumn(getKyotakuTableColumn3());

    getKyotakuTableColumnModel().addColumn(getKyotakuTableColumn4());

    getKyotakuTableColumnModel().addColumn(getKyotakuTableColumn5());

    getKyotakuTableColumnModel().addColumn(getKyotakuTableColumn6());

    getKyotakuTableColumnModel().addColumn(getKyotakuTableColumn7());

    getKyotakuTableColumnModel().addColumn(getKyotakuTableColumn8());

  }

  /**
   * No.�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKyotakuTableColumn1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addKyotakuTableColumn2(){

  }

  /**
   * �쐬�N�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addKyotakuTableColumn3(){

  }

  /**
   * ��Ë@�֖��ɓ������ڂ�ǉ����܂��B
   */
  protected void addKyotakuTableColumn4(){

  }

  /**
   * �S���㎁���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKyotakuTableColumn5(){

  }

  /**
   * ���x�������ɓ������ڂ�ǉ����܂��B
   */
  protected void addKyotakuTableColumn6(){

  }

  /**
   * ���Ə����ɓ������ڂ�ǉ����܂��B
   */
  protected void addKyotakuTableColumn7(){

  }

  /**
   * �a��ɓ������ڂ�ǉ����܂��B
   */
  protected void addKyotakuTableColumn8(){

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
      ACFrame.debugStart(new ACAffairInfo(QC006Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QC006Design getThis() {
    return this;
  }
}
