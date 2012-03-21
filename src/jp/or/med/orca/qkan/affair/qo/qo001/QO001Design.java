
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
 * �J����: ���}�@�M�u
 * �쐬��: 2006/03/30  ���{�R���s���[�^�[������� ���}�@�M�u �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���̑� (O)
 * �v���Z�X �ی��҈ꗗ�o�^ (001)
 * �v���O���� �ی��҈ꗗ�o�^ (QO001)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qo.qo001;
import java.awt.Component;
import java.awt.im.InputSubset;

import javax.swing.SwingConstants;
import javax.swing.table.TableColumn;

import jp.nichicom.ac.ACConstants;
import jp.nichicom.ac.component.ACAffairButton;
import jp.nichicom.ac.component.ACAffairButtonBar;
import jp.nichicom.ac.component.ACTextField;
import jp.nichicom.ac.component.table.ACTable;
import jp.nichicom.ac.component.table.ACTableCellViewer;
import jp.nichicom.ac.component.table.ACTableColumn;
import jp.nichicom.ac.container.ACLabelContainer;
import jp.nichicom.ac.container.ACPanel;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACAffairable;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.vr.component.table.VRTableColumnModel;
import jp.nichicom.vr.layout.VRLayout;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.affair.QkanAffairContainer;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.text.QkanInsurerTypeFormat;
/**
 * �ی��҈ꗗ�o�^��ʍ��ڃf�U�C��(QO001) 
 */
public class QO001Design extends QkanAffairContainer implements ACAffairable {
  //GUI�R���|�[�l���g

  private ACAffairButtonBar buttons;

  private ACAffairButton find;

  private ACAffairButton detail;

  private ACAffairButton insert;

  private ACAffairButton delete;

  private ACPanel insurerInfoFind;

  private ACTextField insurerName;

  private ACLabelContainer insurerNameContainer;

  private ACPanel insurerInfos;

  private ACTable insurerInfoTable;

  private VRTableColumnModel insurerInfoTableColumnModel;

  private ACTableColumn insurerNoColumn;

  private ACTableColumn insurerIdColumn;

  private ACTableColumn insurerNameColumn;

  private ACTableColumn insurerTypeColumn;

  private ACTableColumn insurerZipcdColumn;

  private ACTableColumn insurerAddressColumn;

  private ACTableColumn insurerTelColumn;

  //getter

  /**
   * �{�^���o�[���擾���܂��B
   * @return �{�^���o�[
   */
  public ACAffairButtonBar getButtons(){
    if(buttons==null){

      buttons = new ACAffairButtonBar();

      buttons.setText("�ی��҈ꗗ");

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

      find.setToolTipText("�ی��҂��������܂��B");

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

      detail.setToolTipText("�I�����ꂽ�ی��҂̕ҏW��ʈڂ�܂��B");

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

      insert.setToolTipText("�ی��҂�V�K�ɍ쐬���܂��B");

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

      delete.setToolTipText("�I�����ꂽ�ی��҂̑S�����폜���܂��B");

      delete.setMnemonic('D');

      delete.setIconPath(ACConstants.ICON_PATH_DELETE_24);

      addDelete();
    }
    return delete;

  }

  /**
   * �ی��ҏ�񌟍��̈���擾���܂��B
   * @return �ی��ҏ�񌟍��̈�
   */
  public ACPanel getInsurerInfoFind(){
    if(insurerInfoFind==null){

      insurerInfoFind = new ACPanel();

      insurerInfoFind.setVgap(4);

      addInsurerInfoFind();
    }
    return insurerInfoFind;

  }

  /**
   * �ی��Җ��̂��擾���܂��B
   * @return �ی��Җ���
   */
  public ACTextField getInsurerName(){
    if(insurerName==null){

      insurerName = new ACTextField();

      getInsurerNameContainer().setText("�ی��Җ���");

      insurerName.setBindPath("INSURER_NAME_FIND");

      insurerName.setColumns(25);

      insurerName.setIMEMode(InputSubset.KANJI);

      insurerName.setMaxLength(64);

      addInsurerName();
    }
    return insurerName;

  }

  /**
   * �ی��Җ��̃R���e�i���擾���܂��B
   * @return �ی��Җ��̃R���e�i
   */
  protected ACLabelContainer getInsurerNameContainer(){
    if(insurerNameContainer==null){
      insurerNameContainer = new ACLabelContainer();
      insurerNameContainer.setFollowChildEnabled(true);
      insurerNameContainer.setVAlignment(VRLayout.CENTER);
      insurerNameContainer.add(getInsurerName(), null);
    }
    return insurerNameContainer;
  }

  /**
   * �ی��ҏ��\���̈���擾���܂��B
   * @return �ی��ҏ��\���̈�
   */
  public ACPanel getInsurerInfos(){
    if(insurerInfos==null){

      insurerInfos = new ACPanel();

      addInsurerInfos();
    }
    return insurerInfos;

  }

  /**
   * �ی��ҏ��e�[�u�����擾���܂��B
   * @return �ی��ҏ��e�[�u��
   */
  public ACTable getInsurerInfoTable(){
    if(insurerInfoTable==null){

      insurerInfoTable = new ACTable();

      insurerInfoTable.setColumnModel(getInsurerInfoTableColumnModel());

      addInsurerInfoTable();
    }
    return insurerInfoTable;

  }

  /**
   * �ی��ҏ��e�[�u���J�������f�����擾���܂��B
   * @return �ی��ҏ��e�[�u���J�������f��
   */
  protected VRTableColumnModel getInsurerInfoTableColumnModel(){
    if(insurerInfoTableColumnModel==null){
      insurerInfoTableColumnModel = new VRTableColumnModel(new TableColumn[]{});
      addInsurerInfoTableColumnModel();
    }
    return insurerInfoTableColumnModel;
  }

  /**
   * No.���擾���܂��B
   * @return No.
   */
  public ACTableColumn getInsurerNoColumn(){
    if(insurerNoColumn==null){

      insurerNoColumn = new ACTableColumn();

      insurerNoColumn.setHeaderValue("No.");

      insurerNoColumn.setColumnName("INSURER_ID");

      insurerNoColumn.setColumns(3);

      insurerNoColumn.setRendererType(ACTableCellViewer.RENDERER_TYPE_SERIAL_NO);

      insurerNoColumn.setSortable(false);

      addInsurerNoColumn();
    }
    return insurerNoColumn;

  }

  /**
   * �ی��Ҕԍ����擾���܂��B
   * @return �ی��Ҕԍ�
   */
  public ACTableColumn getInsurerIdColumn(){
    if(insurerIdColumn==null){

      insurerIdColumn = new ACTableColumn();

      insurerIdColumn.setHeaderValue("�ی��Ҕԍ�");

      insurerIdColumn.setColumnName("INSURER_ID");

      insurerIdColumn.setColumns(7);

      insurerIdColumn.setHorizontalAlignment(SwingConstants.LEFT);

      addInsurerIdColumn();
    }
    return insurerIdColumn;

  }

  /**
   * �ی��Җ��̂��擾���܂��B
   * @return �ی��Җ���
   */
  public ACTableColumn getInsurerNameColumn(){
    if(insurerNameColumn==null){

      insurerNameColumn = new ACTableColumn();

      insurerNameColumn.setHeaderValue("�ی��Җ���");

      insurerNameColumn.setColumnName("INSURER_NAME");

      insurerNameColumn.setColumns(20);

      insurerNameColumn.setHorizontalAlignment(SwingConstants.LEFT);

      addInsurerNameColumn();
    }
    return insurerNameColumn;

  }

  /**
   * �ی��ҋ敪���擾���܂��B
   * @return �ی��ҋ敪
   */
  public ACTableColumn getInsurerTypeColumn(){
    if(insurerTypeColumn==null){

      insurerTypeColumn = new ACTableColumn();

      insurerTypeColumn.setHeaderValue("�ی��ҋ敪");

      insurerTypeColumn.setColumnName("INSURER_TYPE");

      insurerTypeColumn.setColumns(7);

      insurerTypeColumn.setHorizontalAlignment(SwingConstants.LEFT);

      insurerTypeColumn.setFormat(QkanInsurerTypeFormat.getInstance());

      addInsurerTypeColumn();
    }
    return insurerTypeColumn;

  }

  /**
   * �ی��җX�֔ԍ����擾���܂��B
   * @return �ی��җX�֔ԍ�
   */
  public ACTableColumn getInsurerZipcdColumn(){
    if(insurerZipcdColumn==null){

      insurerZipcdColumn = new ACTableColumn();

      insurerZipcdColumn.setHeaderValue("�X�֔ԍ�");

      insurerZipcdColumn.setColumnName("INSURER_ZIP_FIRST+'-'+INSURER_ZIP_SECOND");

      insurerZipcdColumn.setColumns(6);

      insurerZipcdColumn.setHorizontalAlignment(SwingConstants.LEFT);

      addInsurerZipcdColumn();
    }
    return insurerZipcdColumn;

  }

  /**
   * �ی��ҏ��ݒn���擾���܂��B
   * @return �ی��ҏ��ݒn
   */
  public ACTableColumn getInsurerAddressColumn(){
    if(insurerAddressColumn==null){

      insurerAddressColumn = new ACTableColumn();

      insurerAddressColumn.setHeaderValue("���ݒn");

      insurerAddressColumn.setColumnName("INSURER_ADDRESS");

      insurerAddressColumn.setColumns(25);

      insurerAddressColumn.setHorizontalAlignment(SwingConstants.LEFT);

      addInsurerAddressColumn();
    }
    return insurerAddressColumn;

  }

  /**
   * �ی��ғd�b�ԍ����擾���܂��B
   * @return �ی��ғd�b�ԍ�
   */
  public ACTableColumn getInsurerTelColumn(){
    if(insurerTelColumn==null){

      insurerTelColumn = new ACTableColumn();

      insurerTelColumn.setHeaderValue("�d�b�ԍ�");

      insurerTelColumn.setColumnName("INSURER_TEL_FIRST+'-'+INSURER_TEL_SECOND+'-'+INSURER_TEL_THIRD");

      insurerTelColumn.setColumns(8);

      insurerTelColumn.setHorizontalAlignment(SwingConstants.LEFT);

      addInsurerTelColumn();
    }
    return insurerTelColumn;

  }

  /**
   * �R���X�g���N�^�ł��B
   */
  public QO001Design() {

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

    this.add(getInsurerInfoFind(), VRLayout.NORTH);

    this.add(getInsurerInfos(), VRLayout.CLIENT);

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
   * �ی��ҏ�񌟍��̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addInsurerInfoFind(){

    insurerInfoFind.add(getInsurerNameContainer(), VRLayout.FLOW);

  }

  /**
   * �ی��Җ��̂ɓ������ڂ�ǉ����܂��B
   */
  protected void addInsurerName(){

  }

  /**
   * �ی��ҏ��\���̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addInsurerInfos(){

    insurerInfos.add(getInsurerInfoTable(), VRLayout.CLIENT);

  }

  /**
   * �ی��ҏ��e�[�u���ɓ������ڂ�ǉ����܂��B
   */
  protected void addInsurerInfoTable(){

  }

  /**
   * �ی��ҏ��e�[�u���J�������f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addInsurerInfoTableColumnModel(){

    getInsurerInfoTableColumnModel().addColumn(getInsurerNoColumn());

    getInsurerInfoTableColumnModel().addColumn(getInsurerIdColumn());

    getInsurerInfoTableColumnModel().addColumn(getInsurerNameColumn());

    getInsurerInfoTableColumnModel().addColumn(getInsurerTypeColumn());

    getInsurerInfoTableColumnModel().addColumn(getInsurerZipcdColumn());

    getInsurerInfoTableColumnModel().addColumn(getInsurerAddressColumn());

    getInsurerInfoTableColumnModel().addColumn(getInsurerTelColumn());

  }

  /**
   * No.�ɓ������ڂ�ǉ����܂��B
   */
  protected void addInsurerNoColumn(){

  }

  /**
   * �ی��Ҕԍ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addInsurerIdColumn(){

  }

  /**
   * �ی��Җ��̂ɓ������ڂ�ǉ����܂��B
   */
  protected void addInsurerNameColumn(){

  }

  /**
   * �ی��ҋ敪�ɓ������ڂ�ǉ����܂��B
   */
  protected void addInsurerTypeColumn(){

  }

  /**
   * �ی��җX�֔ԍ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addInsurerZipcdColumn(){

  }

  /**
   * �ی��ҏ��ݒn�ɓ������ڂ�ǉ����܂��B
   */
  protected void addInsurerAddressColumn(){

  }

  /**
   * �ی��ғd�b�ԍ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addInsurerTelColumn(){

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

    return getInsurerName();

  }
  public void initAffair(ACAffairInfo affair) throws Exception {
  }

  public static void main(String[] args) {
    //�f�t�H���g�f�o�b�O�N��
    try {
      ACFrame.setVRLookAndFeel();
      ACFrame.getInstance().setFrameEventProcesser(new QkanFrameEventProcesser());
      ACFrame.debugStart(new ACAffairInfo(QO001Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QO001Design getThis() {
    return this;
  }
}
