
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
 * �J����: ��� ��F
 * �쐬��: 2006/03/06  ���{�R���s���[�^�[������� ��� ��F �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���̑��@�\ (O)
 * �v���Z�X ��Ë@�֊Ǘ� (009)
 * �v���O���� ��Ë@�ֈꗗ (QO009)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qo.qo009;
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
import jp.or.med.orca.qkan.lib.*;
import jp.or.med.orca.qkan.text.*;
/**
 * ��Ë@�ֈꗗ��ʍ��ڃf�U�C��(QO009) 
 */
public class QO009Design extends QkanAffairContainer implements ACAffairable {
  //GUI�R���|�[�l���g

  private ACAffairButtonBar buttons;

  private ACAffairButton find;

  private ACAffairButton detail;

  private ACAffairButton insert;

  private ACAffairButton delete;

  private ACGroupBox medicalFacilityFind;

  private ACTextField medicalFacilityName;

  private ACLabelContainer medicalFacilityNameContainer;

  private ACPanel medicalFacilityInfo;

  private ACTable medicalFacilityTable;

  private VRTableColumnModel medicalFacilityTableColumnModel;

  private ACTableColumn medicalFacilityTableColumn0;

  private ACTableColumn medicalFacilityTableColumn1;

  private ACTableColumn medicalFacilityTableColumn2;

  private ACTableColumn medicalFacilityTableColumn3;

  private ACTableColumn medicalFacilityTableColumn4;

  private ACTableColumn medicalFacilityTableColumn5;

  //getter

  /**
   * �{�^���o�[���擾���܂��B
   * @return �{�^���o�[
   */
  public ACAffairButtonBar getButtons(){
    if(buttons==null){

      buttons = new ACAffairButtonBar();

      buttons.setText("��Ë@�ֈꗗ");

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

      find.setToolTipText("��Ë@�ւ��������܂��B");

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

      detail.setToolTipText("�I�����ꂽ��Ë@�ւ̕ҏW��ʈڂ�܂��B");

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

      insert.setToolTipText("��Ë@�ւ�V�K�ɍ쐬���܂��B");

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

      delete.setToolTipText("�I�����ꂽ��Ë@�ւ̑S�����폜���܂��B");

      delete.setMnemonic('D');

      delete.setIconPath(ACConstants.ICON_PATH_DELETE_24);

      addDelete();
    }
    return delete;

  }

  /**
   * ��Ë@�֏�񌟍��̈���擾���܂��B
   * @return ��Ë@�֏�񌟍��̈�
   */
  public ACGroupBox getMedicalFacilityFind(){
    if(medicalFacilityFind==null){

      medicalFacilityFind = new ACGroupBox();

      medicalFacilityFind.setText("�\������");

      medicalFacilityFind.setVgap(2);

      addMedicalFacilityFind();
    }
    return medicalFacilityFind;

  }

  /**
   * ��Ë@�֖��̂��擾���܂��B
   * @return ��Ë@�֖���
   */
  public ACTextField getMedicalFacilityName(){
    if(medicalFacilityName==null){

      medicalFacilityName = new ACTextField();

      getMedicalFacilityNameContainer().setText("��Ë@�֖���");

      medicalFacilityName.setColumns(25);

      medicalFacilityName.setIMEMode(InputSubset.KANJI);

      medicalFacilityName.setMaxLength(64);

      addMedicalFacilityName();
    }
    return medicalFacilityName;

  }

  /**
   * ��Ë@�֖��̃R���e�i���擾���܂��B
   * @return ��Ë@�֖��̃R���e�i
   */
  protected ACLabelContainer getMedicalFacilityNameContainer(){
    if(medicalFacilityNameContainer==null){
      medicalFacilityNameContainer = new ACLabelContainer();
      medicalFacilityNameContainer.setFollowChildEnabled(true);
      medicalFacilityNameContainer.setVAlignment(VRLayout.CENTER);
      medicalFacilityNameContainer.add(getMedicalFacilityName(), null);
    }
    return medicalFacilityNameContainer;
  }

  /**
   * ��Ë@�֏��\���̈���擾���܂��B
   * @return ��Ë@�֏��\���̈�
   */
  public ACPanel getMedicalFacilityInfo(){
    if(medicalFacilityInfo==null){

      medicalFacilityInfo = new ACPanel();

      addMedicalFacilityInfo();
    }
    return medicalFacilityInfo;

  }

  /**
   * ��Ë@�֏��e�[�u�����擾���܂��B
   * @return ��Ë@�֏��e�[�u��
   */
  public ACTable getMedicalFacilityTable(){
    if(medicalFacilityTable==null){

      medicalFacilityTable = new ACTable();

      medicalFacilityTable.setColumnModel(getMedicalFacilityTableColumnModel());

      addMedicalFacilityTable();
    }
    return medicalFacilityTable;

  }

  /**
   * ��Ë@�֏��e�[�u���J�������f�����擾���܂��B
   * @return ��Ë@�֏��e�[�u���J�������f��
   */
  protected VRTableColumnModel getMedicalFacilityTableColumnModel(){
    if(medicalFacilityTableColumnModel==null){
      medicalFacilityTableColumnModel = new VRTableColumnModel(new TableColumn[]{});
      addMedicalFacilityTableColumnModel();
    }
    return medicalFacilityTableColumnModel;
  }

  /**
   * �ꗗ�FNo.���擾���܂��B
   * @return �ꗗ�FNo.
   */
  public ACTableColumn getMedicalFacilityTableColumn0(){
    if(medicalFacilityTableColumn0==null){

      medicalFacilityTableColumn0 = new ACTableColumn(0);

      medicalFacilityTableColumn0.setHeaderValue("No.");

      medicalFacilityTableColumn0.setColumns(3);

      medicalFacilityTableColumn0.setRendererType(ACTableCellViewer.RENDERER_TYPE_SERIAL_NO);

      medicalFacilityTableColumn0.setSortable(false);

      addMedicalFacilityTableColumn0();
    }
    return medicalFacilityTableColumn0;

  }

  /**
   * �ꗗ�F��Ë@�֖��̂��擾���܂��B
   * @return �ꗗ�F��Ë@�֖���
   */
  public ACTableColumn getMedicalFacilityTableColumn1(){
    if(medicalFacilityTableColumn1==null){

      medicalFacilityTableColumn1 = new ACTableColumn(0);

      medicalFacilityTableColumn1.setHeaderValue("��Ë@�֖���");

      medicalFacilityTableColumn1.setColumns(20);

      medicalFacilityTableColumn1.setHorizontalAlignment(SwingConstants.LEFT);

      addMedicalFacilityTableColumn1();
    }
    return medicalFacilityTableColumn1;

  }

  /**
   * �ꗗ�F��Ë@�֗X�֔ԍ����擾���܂��B
   * @return �ꗗ�F��Ë@�֗X�֔ԍ�
   */
  public ACTableColumn getMedicalFacilityTableColumn2(){
    if(medicalFacilityTableColumn2==null){

      medicalFacilityTableColumn2 = new ACTableColumn(1);

      medicalFacilityTableColumn2.setHeaderValue("�X�֔ԍ�");

      medicalFacilityTableColumn2.setColumns(7);

      medicalFacilityTableColumn2.setHorizontalAlignment(SwingConstants.LEFT);

      addMedicalFacilityTableColumn2();
    }
    return medicalFacilityTableColumn2;

  }

  /**
   * �ꗗ�F��Ë@�֏��ݒn���擾���܂��B
   * @return �ꗗ�F��Ë@�֏��ݒn
   */
  public ACTableColumn getMedicalFacilityTableColumn3(){
    if(medicalFacilityTableColumn3==null){

      medicalFacilityTableColumn3 = new ACTableColumn(2);

      medicalFacilityTableColumn3.setHeaderValue("���ݒn");

      medicalFacilityTableColumn3.setColumns(37);

      medicalFacilityTableColumn3.setHorizontalAlignment(SwingConstants.LEFT);

      addMedicalFacilityTableColumn3();
    }
    return medicalFacilityTableColumn3;

  }

  /**
   * �ꗗ�F��Ë@�֓d�b�ԍ����擾���܂��B
   * @return �ꗗ�F��Ë@�֓d�b�ԍ�
   */
  public ACTableColumn getMedicalFacilityTableColumn4(){
    if(medicalFacilityTableColumn4==null){

      medicalFacilityTableColumn4 = new ACTableColumn(3);

      medicalFacilityTableColumn4.setHeaderValue("�d�b�ԍ�");

      medicalFacilityTableColumn4.setColumns(9);

      medicalFacilityTableColumn4.setHorizontalAlignment(SwingConstants.LEFT);

      addMedicalFacilityTableColumn4();
    }
    return medicalFacilityTableColumn4;

  }

  /**
   * �ꗗ�F��Ë@��FAX���擾���܂��B
   * @return �ꗗ�F��Ë@��FAX
   */
  public ACTableColumn getMedicalFacilityTableColumn5(){
    if(medicalFacilityTableColumn5==null){

      medicalFacilityTableColumn5 = new ACTableColumn(4);

      medicalFacilityTableColumn5.setHeaderValue("FAX");

      medicalFacilityTableColumn5.setColumns(9);

      medicalFacilityTableColumn5.setHorizontalAlignment(SwingConstants.LEFT);

      addMedicalFacilityTableColumn5();
    }
    return medicalFacilityTableColumn5;

  }

  /**
   * �R���X�g���N�^�ł��B
   */
  public QO009Design() {

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

    this.add(getMedicalFacilityFind(), VRLayout.NORTH);

    this.add(getMedicalFacilityInfo(), VRLayout.CLIENT);

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
   * ��Ë@�֏�񌟍��̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityFind(){

    medicalFacilityFind.add(getMedicalFacilityNameContainer(), VRLayout.FLOW);

  }

  /**
   * ��Ë@�֖��̂ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityName(){

  }

  /**
   * ��Ë@�֏��\���̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityInfo(){

    medicalFacilityInfo.add(getMedicalFacilityTable(), VRLayout.CLIENT);

  }

  /**
   * ��Ë@�֏��e�[�u���ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityTable(){

  }

  /**
   * ��Ë@�֏��e�[�u���J�������f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityTableColumnModel(){

    getMedicalFacilityTableColumnModel().addColumn(getMedicalFacilityTableColumn0());

    getMedicalFacilityTableColumnModel().addColumn(getMedicalFacilityTableColumn1());

    getMedicalFacilityTableColumnModel().addColumn(getMedicalFacilityTableColumn2());

    getMedicalFacilityTableColumnModel().addColumn(getMedicalFacilityTableColumn3());

    getMedicalFacilityTableColumnModel().addColumn(getMedicalFacilityTableColumn4());

    getMedicalFacilityTableColumnModel().addColumn(getMedicalFacilityTableColumn5());

  }

  /**
   * �ꗗ�FNo.�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityTableColumn0(){

  }

  /**
   * �ꗗ�F��Ë@�֖��̂ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityTableColumn1(){

  }

  /**
   * �ꗗ�F��Ë@�֗X�֔ԍ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityTableColumn2(){

  }

  /**
   * �ꗗ�F��Ë@�֏��ݒn�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityTableColumn3(){

  }

  /**
   * �ꗗ�F��Ë@�֓d�b�ԍ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityTableColumn4(){

  }

  /**
   * �ꗗ�F��Ë@��FAX�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityTableColumn5(){

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

    return getMedicalFacilityName();

  }
  public void initAffair(ACAffairInfo affair) throws Exception {
  }

  public static void main(String[] args) {
    //�f�t�H���g�f�o�b�O�N��
    try {
      ACFrame.setVRLookAndFeel();
      ACFrame.getInstance().setFrameEventProcesser(new QkanFrameEventProcesser());
      ACFrame.debugStart(new ACAffairInfo(QO009Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QO009Design getThis() {
    return this;
  }
}
