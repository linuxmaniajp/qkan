
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
 * �쐬��: 2011/03/02  ���{�R���s���[�^�[������� ���}�@�M�u �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���p�ғo�^�^�C�� (O)
 * �v���Z�X ���Ǝ҈ꗗ (003)
 * �v���O���� ���Ǝ҈ꗗ (QO003)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qo.qo003;
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
 * ���Ǝ҈ꗗ��ʍ��ڃf�U�C��(QO003) 
 */
public class QO003Design extends QkanAffairContainer implements ACAffairable {
  //GUI�R���|�[�l���g

  private ACAffairButtonBar buttons;

  private ACAffairButton find;

  private ACAffairButton detail;

  private ACAffairButton insert;

  private ACAffairButton delete;

  private ACAffairButton print;

  private ACPanel contents;

  private VRLayout contentsLayout;

  private ACGroupBox findContens;

  private VRLayout findContensLayout;

  private ACComboBox findContentproviderType;

  private ACLabelContainer findContentproviderTypeContainer;

  private ACComboBoxModelAdapter findContentproviderTypeModel;

  private ACTextField findContentproviderId;

  private ACLabelContainer findContentproviderIdContainer;

  private ACTextField findContentproviderName;

  private ACLabelContainer findContentproviderNameContainer;

  private ACTable providerTable;

  private VRTableColumnModel providerTableColumnModel;

  private ACTableColumn providerNoColumn;

  private ACTableColumn providerTypeColumn;

  private ACTableColumn providerIdColumn;

  private ACTableColumn providerNameColumn;

  private ACTableColumn providerZipColumn;

  private ACTableColumn providerAddressColumn;

  private ACTableColumn providerTelColumn;

  private ACTableColumn providerFaxColumn;

  private ACTableColumn providerDivisionColumn;

  private ACTableColumn providerRegionColumn;

  private ACTableColumn providerChargeColumn;

  //getter

  /**
   * �{�^���o�[���擾���܂��B
   * @return �{�^���o�[
   */
  public ACAffairButtonBar getButtons(){
    if(buttons==null){

      buttons = new ACAffairButtonBar();

      buttons.setText("���Ə��ꗗ");

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

      find.setToolTipText("���Ə��̏����������܂��B");

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

      detail.setToolTipText("�I�����ꂽ���Ə��̕ҏW��ʂɈڂ�܂��B");

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

      insert.setToolTipText("���Ə���V�K�ɍ쐬���܂��B");

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

      delete.setToolTipText("���Ə��̑S�����폜���܂��B");

      delete.setMnemonic('D');

      delete.setIconPath(ACConstants.ICON_PATH_DELETE_24);

      addDelete();
    }
    return delete;

  }

  /**
   * ����{�^�����擾���܂��B
   * @return ����{�^��
   */
  public ACAffairButton getPrint(){
    if(print==null){

      print = new ACAffairButton();

      print.setText("���(P)");

      print.setToolTipText("���Ə��ꗗ�̈�������s���܂��B");

      print.setMnemonic('P');

      print.setIconPath(ACConstants.ICON_PATH_PRINT_24);

      addPrint();
    }
    return print;

  }

  /**
   * �N���C�A���g�̈���擾���܂��B
   * @return �N���C�A���g�̈�
   */
  public ACPanel getContents(){
    if(contents==null){

      contents = new ACPanel();

      contents.setLayout(getContentsLayout());

      addContents();
    }
    return contents;

  }

  /**
   * �N���C�A���g�̈惌�C�A�E�g���擾���܂��B
   * @return �N���C�A���g�̈惌�C�A�E�g
   */
  public VRLayout getContentsLayout(){
    if(contentsLayout==null){

      contentsLayout = new VRLayout();

      addContentsLayout();
    }
    return contentsLayout;

  }

  /**
   * ���������̈���擾���܂��B
   * @return ���������̈�
   */
  public ACGroupBox getFindContens(){
    if(findContens==null){

      findContens = new ACGroupBox();

      findContens.setText("�\������");

      findContens.setLayout(getFindContensLayout());

      addFindContens();
    }
    return findContens;

  }

  /**
   * ���������̈惌�C�A�E�g���擾���܂��B
   * @return ���������̈惌�C�A�E�g
   */
  public VRLayout getFindContensLayout(){
    if(findContensLayout==null){

      findContensLayout = new VRLayout();

      addFindContensLayout();
    }
    return findContensLayout;

  }

  /**
   * ���Ə���ʂ��擾���܂��B
   * @return ���Ə����
   */
  public ACComboBox getFindContentproviderType(){
    if(findContentproviderType==null){

      findContentproviderType = new ACComboBox();

      getFindContentproviderTypeContainer().setText("���Ə����");

      findContentproviderType.setBindPath("PROVIDER_TYPE");

      findContentproviderType.setEditable(false);

      findContentproviderType.setModelBindPath("PROVIDER_TYPE");

      findContentproviderType.setRenderBindPath("CONTENT");

      findContentproviderType.setBlankable(true);

      findContentproviderType.setModel(getFindContentproviderTypeModel());

      addFindContentproviderType();
    }
    return findContentproviderType;

  }

  /**
   * ���Ə���ʃR���e�i���擾���܂��B
   * @return ���Ə���ʃR���e�i
   */
  protected ACLabelContainer getFindContentproviderTypeContainer(){
    if(findContentproviderTypeContainer==null){
      findContentproviderTypeContainer = new ACLabelContainer();
      findContentproviderTypeContainer.setFollowChildEnabled(true);
      findContentproviderTypeContainer.setVAlignment(VRLayout.CENTER);
      findContentproviderTypeContainer.add(getFindContentproviderType(), VRLayout.CLIENT);
    }
    return findContentproviderTypeContainer;
  }

  /**
   * ���Ə���ʃ��f�����擾���܂��B
   * @return ���Ə���ʃ��f��
   */
  protected ACComboBoxModelAdapter getFindContentproviderTypeModel(){
    if(findContentproviderTypeModel==null){
      findContentproviderTypeModel = new ACComboBoxModelAdapter();
      addFindContentproviderTypeModel();
    }
    return findContentproviderTypeModel;
  }

  /**
   * ���Ə��ԍ����擾���܂��B
   * @return ���Ə��ԍ�
   */
  public ACTextField getFindContentproviderId(){
    if(findContentproviderId==null){

      findContentproviderId = new ACTextField();

      getFindContentproviderIdContainer().setText("���Ə��ԍ�");

      findContentproviderId.setBindPath("PROVIDER_ID");

      findContentproviderId.setColumns(9);

      findContentproviderId.setHorizontalAlignment(SwingConstants.LEFT);

      findContentproviderId.setMaxLength(10);

      addFindContentproviderId();
    }
    return findContentproviderId;

  }

  /**
   * ���Ə��ԍ��R���e�i���擾���܂��B
   * @return ���Ə��ԍ��R���e�i
   */
  protected ACLabelContainer getFindContentproviderIdContainer(){
    if(findContentproviderIdContainer==null){
      findContentproviderIdContainer = new ACLabelContainer();
      findContentproviderIdContainer.setFollowChildEnabled(true);
      findContentproviderIdContainer.setVAlignment(VRLayout.CENTER);
      findContentproviderIdContainer.add(getFindContentproviderId(), VRLayout.CLIENT);
    }
    return findContentproviderIdContainer;
  }

  /**
   * ���Ə����̂��擾���܂��B
   * @return ���Ə�����
   */
  public ACTextField getFindContentproviderName(){
    if(findContentproviderName==null){

      findContentproviderName = new ACTextField();

      getFindContentproviderNameContainer().setText("���Ə�����");

      findContentproviderName.setBindPath("PROVIDER_NAME");

      findContentproviderName.setColumns(30);

      findContentproviderName.setHorizontalAlignment(SwingConstants.LEFT);

      findContentproviderName.setIMEMode(InputSubset.KANJI);

      findContentproviderName.setMaxLength(128);

      addFindContentproviderName();
    }
    return findContentproviderName;

  }

  /**
   * ���Ə����̃R���e�i���擾���܂��B
   * @return ���Ə����̃R���e�i
   */
  protected ACLabelContainer getFindContentproviderNameContainer(){
    if(findContentproviderNameContainer==null){
      findContentproviderNameContainer = new ACLabelContainer();
      findContentproviderNameContainer.setFollowChildEnabled(true);
      findContentproviderNameContainer.setVAlignment(VRLayout.CENTER);
      findContentproviderNameContainer.add(getFindContentproviderName(), VRLayout.CLIENT);
    }
    return findContentproviderNameContainer;
  }

  /**
   * ���Ə��ꗗ���擾���܂��B
   * @return ���Ə��ꗗ
   */
  public ACTable getProviderTable(){
    if(providerTable==null){

      providerTable = new ACTable();

      providerTable.setColumnModel(getProviderTableColumnModel());

      providerTable.setExtendLastColumn(false);

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
   * �ꗗ�FNo.���擾���܂��B
   * @return �ꗗ�FNo.
   */
  public ACTableColumn getProviderNoColumn(){
    if(providerNoColumn==null){

      providerNoColumn = new ACTableColumn(0);

      providerNoColumn.setHeaderValue("No.");

      providerNoColumn.setColumns(3);

      providerNoColumn.setRendererType(ACTableCellViewer.RENDERER_TYPE_SERIAL_NO);

      providerNoColumn.setSortable(false);

      addProviderNoColumn();
    }
    return providerNoColumn;

  }

  /**
   * �ꗗ�F���Ə���ʂ��擾���܂��B
   * @return �ꗗ�F���Ə����
   */
  public ACTableColumn getProviderTypeColumn(){
    if(providerTypeColumn==null){

      providerTypeColumn = new ACTableColumn(0);

      providerTypeColumn.setHeaderValue("���Ə����");

      providerTypeColumn.setColumns(6);

      providerTypeColumn.setHorizontalAlignment(SwingConstants.LEFT);

      addProviderTypeColumn();
    }
    return providerTypeColumn;

  }

  /**
   * �ꗗ�F���Ə��ԍ����擾���܂��B
   * @return �ꗗ�F���Ə��ԍ�
   */
  public ACTableColumn getProviderIdColumn(){
    if(providerIdColumn==null){

      providerIdColumn = new ACTableColumn(1);

      providerIdColumn.setHeaderValue("���Ə��ԍ�");

      providerIdColumn.setColumns(7);

      providerIdColumn.setHorizontalAlignment(SwingConstants.LEFT);

      addProviderIdColumn();
    }
    return providerIdColumn;

  }

  /**
   * �ꗗ�F���Ə����̂��擾���܂��B
   * @return �ꗗ�F���Ə�����
   */
  public ACTableColumn getProviderNameColumn(){
    if(providerNameColumn==null){

      providerNameColumn = new ACTableColumn(2);

      providerNameColumn.setHeaderValue("���Ə�����");

      providerNameColumn.setColumns(14);

      providerNameColumn.setHorizontalAlignment(SwingConstants.LEFT);

      addProviderNameColumn();
    }
    return providerNameColumn;

  }

  /**
   * �ꗗ�F�X�֔ԍ����擾���܂��B
   * @return �ꗗ�F�X�֔ԍ�
   */
  public ACTableColumn getProviderZipColumn(){
    if(providerZipColumn==null){

      providerZipColumn = new ACTableColumn(3);

      providerZipColumn.setHeaderValue("�X�֔ԍ�");

      providerZipColumn.setColumns(6);

      providerZipColumn.setHorizontalAlignment(SwingConstants.LEFT);

      addProviderZipColumn();
    }
    return providerZipColumn;

  }

  /**
   * �ꗗ�F���ݒn���擾���܂��B
   * @return �ꗗ�F���ݒn
   */
  public ACTableColumn getProviderAddressColumn(){
    if(providerAddressColumn==null){

      providerAddressColumn = new ACTableColumn(4);

      providerAddressColumn.setHeaderValue("���ݒn");

      providerAddressColumn.setColumns(10);

      providerAddressColumn.setHorizontalAlignment(SwingConstants.LEFT);

      addProviderAddressColumn();
    }
    return providerAddressColumn;

  }

  /**
   * �ꗗ�F�d�b�ԍ����擾���܂��B
   * @return �ꗗ�F�d�b�ԍ�
   */
  public ACTableColumn getProviderTelColumn(){
    if(providerTelColumn==null){

      providerTelColumn = new ACTableColumn(5);

      providerTelColumn.setHeaderValue("�d�b�ԍ�");

      providerTelColumn.setColumns(9);

      providerTelColumn.setHorizontalAlignment(SwingConstants.LEFT);

      addProviderTelColumn();
    }
    return providerTelColumn;

  }

  /**
   * �ꗗ�FFAX�ԍ����擾���܂��B
   * @return �ꗗ�FFAX�ԍ�
   */
  public ACTableColumn getProviderFaxColumn(){
    if(providerFaxColumn==null){

      providerFaxColumn = new ACTableColumn(6);

      providerFaxColumn.setHeaderValue("FAX�ԍ�");

      providerFaxColumn.setColumns(9);

      providerFaxColumn.setHorizontalAlignment(SwingConstants.LEFT);

      addProviderFaxColumn();
    }
    return providerFaxColumn;

  }

  /**
   * �ꗗ�F���Ƌ敪���擾���܂��B
   * @return �ꗗ�F���Ƌ敪
   */
  public ACTableColumn getProviderDivisionColumn(){
    if(providerDivisionColumn==null){

      providerDivisionColumn = new ACTableColumn(7);

      providerDivisionColumn.setHeaderValue("���Ƌ敪");

      providerDivisionColumn.setColumns(5);

      providerDivisionColumn.setHorizontalAlignment(SwingConstants.LEFT);

      addProviderDivisionColumn();
    }
    return providerDivisionColumn;

  }

  /**
   * �ꗗ�F�n��敪���擾���܂��B
   * @return �ꗗ�F�n��敪
   */
  public ACTableColumn getProviderRegionColumn(){
    if(providerRegionColumn==null){

      providerRegionColumn = new ACTableColumn(8);

      providerRegionColumn.setHeaderValue("�n��敪");

      providerRegionColumn.setColumns(5);

      providerRegionColumn.setHorizontalAlignment(SwingConstants.LEFT);

      addProviderRegionColumn();
    }
    return providerRegionColumn;

  }

  /**
   * �ꗗ�F���x�����������擾���܂��B
   * @return �ꗗ�F���x��������
   */
  public ACTableColumn getProviderChargeColumn(){
    if(providerChargeColumn==null){

      providerChargeColumn = new ACTableColumn(9);

      providerChargeColumn.setHeaderValue("�S����");

      providerChargeColumn.setColumns(50);

      providerChargeColumn.setHorizontalAlignment(SwingConstants.LEFT);

      addProviderChargeColumn();
    }
    return providerChargeColumn;

  }

  /**
   * �R���X�g���N�^�ł��B
   */
  public QO003Design() {

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
   * ����{�^���ɓ������ڂ�ǉ����܂��B
   */
  protected void addPrint(){

  }

  /**
   * �N���C�A���g�̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addContents(){

    contents.add(getFindContens(), VRLayout.NORTH);

    contents.add(getProviderTable(), VRLayout.CLIENT);

  }

  /**
   * �N���C�A���g�̈惌�C�A�E�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addContentsLayout(){

  }

  /**
   * ���������̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addFindContens(){

    findContens.add(getFindContentproviderTypeContainer(), VRLayout.WEST);

    findContens.add(getFindContentproviderIdContainer(), VRLayout.WEST);

    findContens.add(getFindContentproviderNameContainer(), VRLayout.WEST);

  }

  /**
   * ���������̈惌�C�A�E�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addFindContensLayout(){

  }

  /**
   * ���Ə���ʂɓ������ڂ�ǉ����܂��B
   */
  protected void addFindContentproviderType(){

  }

  /**
   * ���Ə���ʃ��f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addFindContentproviderTypeModel(){

  }

  /**
   * ���Ə��ԍ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addFindContentproviderId(){

  }

  /**
   * ���Ə����̂ɓ������ڂ�ǉ����܂��B
   */
  protected void addFindContentproviderName(){

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

    getProviderTableColumnModel().addColumn(getProviderNoColumn());

    getProviderTableColumnModel().addColumn(getProviderTypeColumn());

    getProviderTableColumnModel().addColumn(getProviderIdColumn());

    getProviderTableColumnModel().addColumn(getProviderNameColumn());

    getProviderTableColumnModel().addColumn(getProviderZipColumn());

    getProviderTableColumnModel().addColumn(getProviderAddressColumn());

    getProviderTableColumnModel().addColumn(getProviderTelColumn());

    getProviderTableColumnModel().addColumn(getProviderFaxColumn());

    getProviderTableColumnModel().addColumn(getProviderDivisionColumn());

    getProviderTableColumnModel().addColumn(getProviderRegionColumn());

    getProviderTableColumnModel().addColumn(getProviderChargeColumn());

  }

  /**
   * �ꗗ�FNo.�ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderNoColumn(){

  }

  /**
   * �ꗗ�F���Ə���ʂɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderTypeColumn(){

  }

  /**
   * �ꗗ�F���Ə��ԍ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderIdColumn(){

  }

  /**
   * �ꗗ�F���Ə����̂ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderNameColumn(){

  }

  /**
   * �ꗗ�F�X�֔ԍ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderZipColumn(){

  }

  /**
   * �ꗗ�F���ݒn�ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderAddressColumn(){

  }

  /**
   * �ꗗ�F�d�b�ԍ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderTelColumn(){

  }

  /**
   * �ꗗ�FFAX�ԍ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderFaxColumn(){

  }

  /**
   * �ꗗ�F���Ƌ敪�ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderDivisionColumn(){

  }

  /**
   * �ꗗ�F�n��敪�ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderRegionColumn(){

  }

  /**
   * �ꗗ�F���x���������ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderChargeColumn(){

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

    return getFindContentproviderType();

  }
  public void initAffair(ACAffairInfo affair) throws Exception {
  }

  public static void main(String[] args) {
    //�f�t�H���g�f�o�b�O�N��
    try {
      ACFrame.getInstance().setFrameEventProcesser(new QkanFrameEventProcesser());
      ACFrame.debugStart(new ACAffairInfo(QO003Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QO003Design getThis() {
    return this;
  }
}
