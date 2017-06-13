
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
 * �쐬��: 2016/02/03  ���{�R���s���[�^�[������� �����F �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �����f�[�^�쐬 (P)
 * �v���Z�X �m�F�E�C�� (002)
 * �v���O���� ���[(�l��)�I�� (QP002)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qp.qp002;
import java.awt.Component;

import javax.swing.SwingConstants;
import javax.swing.table.TableColumn;

import jp.nichicom.ac.ACConstants;
import jp.nichicom.ac.component.ACAffairButton;
import jp.nichicom.ac.component.ACAffairButtonBar;
import jp.nichicom.ac.component.ACLabel;
import jp.nichicom.ac.component.ACTextField;
import jp.nichicom.ac.component.table.ACCheckBoxTableColumnPopupMenu;
import jp.nichicom.ac.component.table.ACTable;
import jp.nichicom.ac.component.table.ACTableCellViewer;
import jp.nichicom.ac.component.table.ACTableColumn;
import jp.nichicom.ac.container.ACPanel;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACAffairable;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.text.ACBorderBlankDateFormat;
import jp.nichicom.vr.component.table.VRTableCellViewer;
import jp.nichicom.vr.component.table.VRTableColumnModel;
import jp.nichicom.vr.layout.VRLayout;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanConstants;
import jp.or.med.orca.qkan.affair.QkanAffairContainer;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
/**
 * ���[(�l��)�I����ʍ��ڃf�U�C��(QP002) 
 */
public class QP002Design extends QkanAffairContainer implements ACAffairable {
  //GUI�R���|�[�l���g

  private ACPanel contents;

  private ACAffairButtonBar buttons;

  private ACAffairButton seikyu;

  private ACAffairButton delete;

  private ACAffairButton select;

  private ACPanel patientNames;

  private ACLabel patinetNameLabel;

  private ACTextField patientName;

  private ACLabel patientNoLabel1;

  private ACTextField patientNo;

  private ACLabel PatientNoLabel2;

  private ACPanel providerPanel;

  private ACTable providerTable;

  private VRTableColumnModel providerTableColumnModel;

  private ACTableColumn providerTableColumn1;

  private ACTableColumn providerTableColumn9;

  private ACTableColumn providerTableColumn2;

  private ACTableColumn providerTableColumn7;

  private ACTableColumn providerTableColumn8;

  private ACTableColumn providerTableColumn3;

  private ACTableColumn providerTableColumn4;

  private ACTableColumn providerTableColumn5;

  private ACTableColumn providerTableColumn6;

  //getter

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
   * �{�^���o�[���擾���܂��B
   * @return �{�^���o�[
   */
  public ACAffairButtonBar getButtons(){
    if(buttons==null){

      buttons = new ACAffairButtonBar();

      buttons.setText("���[(�l��)�E���Ə��I��");

      addButtons();
    }
    return buttons;

  }

  /**
   * ���p�������擾���܂��B
   * @return ���p����
   */
  public ACAffairButton getSeikyu(){
    if(seikyu==null){

      seikyu = new ACAffairButton();

      seikyu.setText("���p����(B)");

      seikyu.setToolTipText("���p�Ҍ��������ڍ׉�ʂɑJ�ڂ��܂��B");

      seikyu.setMnemonic('B');

      seikyu.setIconPath(QkanConstants.ICON_PATH_PATIENT_BILL_24);

      addSeikyu();
    }
    return seikyu;

  }

  /**
   * �폜�{�^�����擾���܂��B
   * @return �폜�{�^��
   */
  public ACAffairButton getDelete(){
    if(delete==null){

      delete = new ACAffairButton();

      delete.setText("�폜(D)");

      delete.setEnabled(false);

      delete.setToolTipText("���׏������폜���܂��B");

      delete.setMnemonic('D');

      delete.setIconPath(ACConstants.ICON_PATH_DELETE_24);

      addDelete();
    }
    return delete;

  }

  /**
   * �ڍ׃{�^�����擾���܂��B
   * @return �ڍ׃{�^��
   */
  public ACAffairButton getSelect(){
    if(select==null){

      select = new ACAffairButton();

      select.setText("�ڍ�(E)");

      select.setToolTipText("���׏�����ʂɑJ�ڂ��܂��B");

      select.setMnemonic('E');

      select.setIconPath(QkanConstants.ICON_PATH_PROVIDER_BILL_24);

      addSelect();
    }
    return select;

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
   * �e�[�u���̈���擾���܂��B
   * @return �e�[�u���̈�
   */
  public ACPanel getProviderPanel(){
    if(providerPanel==null){

      providerPanel = new ACPanel();

      addProviderPanel();
    }
    return providerPanel;

  }

  /**
   * ���Ə��ꗗ���擾���܂��B
   * @return ���Ə��ꗗ
   */
  public ACTable getProviderTable(){
    if(providerTable==null){

      providerTable = new ACTable();

      providerTable.setColumnModel(getProviderTableColumnModel());

      addProviderTable();
    }
    return providerTable;

  }

  /**
   * ���Ə��ꗗ�J�������f�����擾���܂��B
   * @return ���Ə��ꗗ�J�������f��
   */
  protected VRTableColumnModel getProviderTableColumnModel(){
    if(providerTableColumnModel==null){
      providerTableColumnModel = new VRTableColumnModel(new TableColumn[]{});
      addProviderTableColumnModel();
    }
    return providerTableColumnModel;
  }

  /**
   * No.���擾���܂��B
   * @return No.
   */
  public ACTableColumn getProviderTableColumn1(){
    if(providerTableColumn1==null){

      providerTableColumn1 = new ACTableColumn();

      providerTableColumn1.setHeaderValue("No.");

      providerTableColumn1.setColumnName("NO");

      providerTableColumn1.setColumns(3);

      providerTableColumn1.setRendererType(ACTableCellViewer.RENDERER_TYPE_SERIAL_NO);

      providerTableColumn1.setSortable(false);

      addProviderTableColumn1();
    }
    return providerTableColumn1;

  }

  /**
   * �폜(����擾���܂��B
   * @return �폜(��
   */
  public ACTableColumn getProviderTableColumn9(){
    if(providerTableColumn9==null){

      providerTableColumn9 = new ACTableColumn();

      providerTableColumn9.setHeaderValue("�폜");

      providerTableColumn9.setColumnName("DELETE");

      providerTableColumn9.setEditable(true);

      providerTableColumn9.setColumns(4);

      providerTableColumn9.setHorizontalAlignment(SwingConstants.CENTER);

      providerTableColumn9.setRendererType(VRTableCellViewer.RENDERER_TYPE_CHECK_BOX);

      providerTableColumn9.setEditorType(VRTableCellViewer.EDITOR_TYPE_CHECK_BOX);

      providerTableColumn9.setHeaderPopupMenu( new ACCheckBoxTableColumnPopupMenu(getProviderTable(), "DELETE", new Boolean(true), new Boolean(false)) );

      addProviderTableColumn9();
    }
    return providerTableColumn9;

  }

  /**
   * �N���x���擾���܂��B
   * @return �N���x
   */
  public ACTableColumn getProviderTableColumn2(){
    if(providerTableColumn2==null){

      providerTableColumn2 = new ACTableColumn();

      providerTableColumn2.setHeaderValue("�N���x");

      providerTableColumn2.setColumnName("TARGET_DATE");

      providerTableColumn2.setColumns(8);

      providerTableColumn2.setFormat(new ACBorderBlankDateFormat("gggee�NMM��"));

      addProviderTableColumn2();
    }
    return providerTableColumn2;

  }

  /**
   * �ی��Ҕԍ����擾���܂��B
   * @return �ی��Ҕԍ�
   */
  public ACTableColumn getProviderTableColumn7(){
    if(providerTableColumn7==null){

      providerTableColumn7 = new ACTableColumn();

      providerTableColumn7.setHeaderValue("�ی��Ҕԍ�");

      providerTableColumn7.setColumnName("INSURER_ID");

      providerTableColumn7.setColumns(6);

      addProviderTableColumn7();
    }
    return providerTableColumn7;

  }

  /**
   * ��ی��Ҕԍ����擾���܂��B
   * @return ��ی��Ҕԍ�
   */
  public ACTableColumn getProviderTableColumn8(){
    if(providerTableColumn8==null){

      providerTableColumn8 = new ACTableColumn();

      providerTableColumn8.setHeaderValue("��ی��Ҕԍ�");

      providerTableColumn8.setColumnName("UNIT_INSURED_ID");

      providerTableColumn8.setColumns(8);

      addProviderTableColumn8();
    }
    return providerTableColumn8;

  }

  /**
   * ���Ə��ԍ����擾���܂��B
   * @return ���Ə��ԍ�
   */
  public ACTableColumn getProviderTableColumn3(){
    if(providerTableColumn3==null){

      providerTableColumn3 = new ACTableColumn();

      providerTableColumn3.setHeaderValue("���Ə��ԍ�");

      providerTableColumn3.setColumnName("PROVIDER_ID");

      providerTableColumn3.setColumns(8);

      addProviderTableColumn3();
    }
    return providerTableColumn3;

  }

  /**
   * ���Ə����̂��擾���܂��B
   * @return ���Ə�����
   */
  public ACTableColumn getProviderTableColumn4(){
    if(providerTableColumn4==null){

      providerTableColumn4 = new ACTableColumn();

      providerTableColumn4.setHeaderValue("���Ə�����");

      providerTableColumn4.setColumnName("PROVIDER_NAME");

      providerTableColumn4.setColumns(20);

      addProviderTableColumn4();
    }
    return providerTableColumn4;

  }

  /**
   * �ی���ނ��擾���܂��B
   * @return �ی����
   */
  public ACTableColumn getProviderTableColumn5(){
    if(providerTableColumn5==null){

      providerTableColumn5 = new ACTableColumn();

      providerTableColumn5.setHeaderValue("�ی����");

      providerTableColumn5.setColumnName("INSURED_ID");

      providerTableColumn5.setColumns(6);

      addProviderTableColumn5();
    }
    return providerTableColumn5;

  }

  /**
   * �l�����擾���܂��B
   * @return �l��
   */
  public ACTableColumn getProviderTableColumn6(){
    if(providerTableColumn6==null){

      providerTableColumn6 = new ACTableColumn();

      providerTableColumn6.setHeaderValue("�l��");

      providerTableColumn6.setColumnName("CLAIM_STYLE_TYPE");

      providerTableColumn6.setColumns(6);

      addProviderTableColumn6();
    }
    return providerTableColumn6;

  }

  /**
   * �R���X�g���N�^�ł��B
   */
  public QP002Design() {

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

    this.add(getContents(), VRLayout.CLIENT);

  }

  /**
   * �N���C�A���g�̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addContents(){

    contents.add(getButtons(), VRLayout.NORTH);

    contents.add(getPatientNames(), VRLayout.NORTH);

    contents.add(getProviderPanel(), VRLayout.CLIENT);

  }

  /**
   * �{�^���o�[�ɓ������ڂ�ǉ����܂��B
   */
  protected void addButtons(){

    buttons.add(getSelect(), VRLayout.EAST);
    buttons.add(getDelete(), VRLayout.EAST);
    buttons.add(getSeikyu(), VRLayout.EAST);
  }

  /**
   * ���p�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addSeikyu(){

  }

  /**
   * �폜�{�^���ɓ������ڂ�ǉ����܂��B
   */
  protected void addDelete(){

  }

  /**
   * �ڍ׃{�^���ɓ������ڂ�ǉ����܂��B
   */
  protected void addSelect(){

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
   * �e�[�u���̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderPanel(){

    providerPanel.add(getProviderTable(), VRLayout.CLIENT);

  }

  /**
   * ���Ə��ꗗ�ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderTable(){

  }

  /**
   * ���Ə��ꗗ�J�������f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderTableColumnModel(){

    getProviderTableColumnModel().addColumn(getProviderTableColumn1());

    getProviderTableColumnModel().addColumn(getProviderTableColumn9());

    getProviderTableColumnModel().addColumn(getProviderTableColumn2());

    getProviderTableColumnModel().addColumn(getProviderTableColumn7());

    getProviderTableColumnModel().addColumn(getProviderTableColumn8());

    getProviderTableColumnModel().addColumn(getProviderTableColumn3());

    getProviderTableColumnModel().addColumn(getProviderTableColumn4());

    getProviderTableColumnModel().addColumn(getProviderTableColumn5());

    getProviderTableColumnModel().addColumn(getProviderTableColumn6());

  }

  /**
   * No.�ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderTableColumn1(){

  }

  /**
   * �폜(��ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderTableColumn9(){

  }

  /**
   * �N���x�ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderTableColumn2(){

  }

  /**
   * �ی��Ҕԍ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderTableColumn7(){

  }

  /**
   * ��ی��Ҕԍ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderTableColumn8(){

  }

  /**
   * ���Ə��ԍ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderTableColumn3(){

  }

  /**
   * ���Ə����̂ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderTableColumn4(){

  }

  /**
   * �ی���ނɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderTableColumn5(){

  }

  /**
   * �l���ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderTableColumn6(){

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

    return getProviderTable();

  }
  public void initAffair(ACAffairInfo affair) throws Exception {
  }

  public static void main(String[] args) {
    //�f�t�H���g�f�o�b�O�N��
    try {
      ACFrame.getInstance().setFrameEventProcesser(new QkanFrameEventProcesser());
      ACFrame.debugStart(new ACAffairInfo(QP002Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QP002Design getThis() {
    return this;
  }
}
