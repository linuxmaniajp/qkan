
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
 * �쐬��: 2006/03/14  ���{�R���s���[�^�[������� ����@��F �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �\��Ǘ� (S)
 * �v���Z�X �T�[�r�X�\�� (001)
 * �v���O���� �W�v���׉�� (QS001030)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
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
import jp.or.med.orca.qkan.text.*;
/**
 * �W�v���׉�ʉ�ʍ��ڃf�U�C��(QS001030) 
 */
public class QS001030Design extends QkanAffairDialog {
  //GUI�R���|�[�l���g

  private ACPanel contents;

  private ACGroupBox inLimitAmount;

  private ACPanel inLimitAmountInfomation;

  private ACLabel inLimitAmountLimitCaption;

  private ACTextField inLimitAmountLimit;

  private ACLabel inLimitAmountLimitUnit;

  private ACTable detailsTable;

  private VRTableColumnModel detailsTableColumnModel;

  private ACTableColumn detailsTableColumn1;

  private ACTableColumn detailsTableColumn2;

  private ACTableColumn detailsTableColumn3;

  private ACTableColumn detailsTableColumn4;

  private ACTableColumn detailsTableColumn5;

  private ACGroupBox outerServices;

  private ACPanel outerServiceInfomation;

  private ACLabel outerServiceLimitCaption;

  private ACTextField outerServiceLimit;

  private ACLabel outerServiceLimitUnit;

  private ACTable outerTable;

  private VRTableColumnModel outerTableColumnModel;

  private ACTableColumn outerTableColumn1;

  private ACTableColumn outerTableColumn2;

  private ACTableColumn outerTableColumn3;

  private ACTableColumn outerTableColumn4;

  private ACTableColumn outerTableColumn5;

  private ACPanel buttons;

  private ACButton close;

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
   * ���t�Ǘ��Ώۃe�[�u���̈���擾���܂��B
   * @return ���t�Ǘ��Ώۃe�[�u���̈�
   */
  public ACGroupBox getInLimitAmount(){
    if(inLimitAmount==null){

      inLimitAmount = new ACGroupBox();

      inLimitAmount.setText("���t�Ǘ��ΏۃT�[�r�X");

      addInLimitAmount();
    }
    return inLimitAmount;

  }

  /**
   * ���t�Ǘ��Ώۏ����擾���܂��B
   * @return ���t�Ǘ��Ώۏ��
   */
  public ACPanel getInLimitAmountInfomation(){
    if(inLimitAmountInfomation==null){

      inLimitAmountInfomation = new ACPanel();

      addInLimitAmountInfomation();
    }
    return inLimitAmountInfomation;

  }

  /**
   * ���t�Ǘ��Ώێx�����x�z�L���v�V�������擾���܂��B
   * @return ���t�Ǘ��Ώێx�����x�z�L���v�V����
   */
  public ACLabel getInLimitAmountLimitCaption(){
    if(inLimitAmountLimitCaption==null){

      inLimitAmountLimitCaption = new ACLabel();

      inLimitAmountLimitCaption.setText("�x�����x�z");

      addInLimitAmountLimitCaption();
    }
    return inLimitAmountLimitCaption;

  }

  /**
   * ���t�Ǘ��Ώێx�����x�z���擾���܂��B
   * @return ���t�Ǘ��Ώێx�����x�z
   */
  public ACTextField getInLimitAmountLimit(){
    if(inLimitAmountLimit==null){

      inLimitAmountLimit = new ACTextField();

      inLimitAmountLimit.setBindPath("LIMIT_RATE");

      inLimitAmountLimit.setEditable(false);

      inLimitAmountLimit.setColumns(5);

      inLimitAmountLimit.setHorizontalAlignment(SwingConstants.RIGHT);

      addInLimitAmountLimit();
    }
    return inLimitAmountLimit;

  }

  /**
   * ���t�Ǘ��Ώێx�����x�z�P�ʂ��擾���܂��B
   * @return ���t�Ǘ��Ώێx�����x�z�P��
   */
  public ACLabel getInLimitAmountLimitUnit(){
    if(inLimitAmountLimitUnit==null){

      inLimitAmountLimitUnit = new ACLabel();

      inLimitAmountLimitUnit.setText("�P��");

      addInLimitAmountLimitUnit();
    }
    return inLimitAmountLimitUnit;

  }

  /**
   * ���t�Ǘ��ΏۏW�v���׃e�[�u�����擾���܂��B
   * @return ���t�Ǘ��ΏۏW�v���׃e�[�u��
   */
  public ACTable getDetailsTable(){
    if(detailsTable==null){

      detailsTable = new ACTable();

      detailsTable.setColumnModel(getDetailsTableColumnModel());

      addDetailsTable();
    }
    return detailsTable;

  }

  /**
   * ���t�Ǘ��ΏۏW�v���׃e�[�u���J�������f�����擾���܂��B
   * @return ���t�Ǘ��ΏۏW�v���׃e�[�u���J�������f��
   */
  protected VRTableColumnModel getDetailsTableColumnModel(){
    if(detailsTableColumnModel==null){
      detailsTableColumnModel = new VRTableColumnModel(new TableColumn[]{});
      addDetailsTableColumnModel();
    }
    return detailsTableColumnModel;
  }

  /**
   * No.���擾���܂��B
   * @return No.
   */
  public ACTableColumn getDetailsTableColumn1(){
    if(detailsTableColumn1==null){

      detailsTableColumn1 = new ACTableColumn();

      detailsTableColumn1.setHeaderValue("No.");

      detailsTableColumn1.setColumnName("SYSTEM_SERVICE_KIND_DETAIL");

      detailsTableColumn1.setColumns(2);

      detailsTableColumn1.setRendererType(ACTableCellViewer.RENDERER_TYPE_SERIAL_NO);

      detailsTableColumn1.setSortable(false);

      addDetailsTableColumn1();
    }
    return detailsTableColumn1;

  }

  /**
   * �T�[�r�X��ނ��擾���܂��B
   * @return �T�[�r�X���
   */
  public ACTableColumn getDetailsTableColumn2(){
    if(detailsTableColumn2==null){

      detailsTableColumn2 = new ACTableColumn();

      detailsTableColumn2.setHeaderValue("�T�[�r�X���");

      detailsTableColumn2.setColumnName("SYSTEM_SERVICE_KIND_DETAIL");

      detailsTableColumn2.setColumns(20);

      detailsTableColumn2.setFormat(QkanServiceFormat.getInstance());

      addDetailsTableColumn2();
    }
    return detailsTableColumn2;

  }

  /**
   * ���t�P�ʂ��擾���܂��B
   * @return ���t�P��
   */
  public ACTableColumn getDetailsTableColumn3(){
    if(detailsTableColumn3==null){

      detailsTableColumn3 = new ACTableColumn();

      detailsTableColumn3.setHeaderValue("���t�P��");

      detailsTableColumn3.setColumnName("UNIT");

      detailsTableColumn3.setColumns(6);

      detailsTableColumn3.setHorizontalAlignment(SwingConstants.RIGHT);

      addDetailsTableColumn3();
    }
    return detailsTableColumn3;

  }

  /**
   * �����P�ʂ��擾���܂��B
   * @return �����P��
   */
  public ACTableColumn getDetailsTableColumn4(){
    if(detailsTableColumn4==null){

      detailsTableColumn4 = new ACTableColumn();

      detailsTableColumn4.setHeaderValue("�����P��");

      detailsTableColumn4.setColumnName("ADJUST");

      detailsTableColumn4.setColumns(6);

      detailsTableColumn4.setHorizontalAlignment(SwingConstants.RIGHT);

      addDetailsTableColumn4();
    }
    return detailsTableColumn4;

  }

  /**
   * ���x�z���P�ʂ��擾���܂��B
   * @return ���x�z���P��
   */
  public ACTableColumn getDetailsTableColumn5(){
    if(detailsTableColumn5==null){

      detailsTableColumn5 = new ACTableColumn();

      detailsTableColumn5.setHeaderValue("���x�z���P��");

      detailsTableColumn5.setColumnName("RESULT");

      detailsTableColumn5.setColumns(8);

      detailsTableColumn5.setHorizontalAlignment(SwingConstants.RIGHT);

      addDetailsTableColumn5();
    }
    return detailsTableColumn5;

  }

  /**
   * �O�����p�^�e�[�u���̈���擾���܂��B
   * @return �O�����p�^�e�[�u���̈�
   */
  public ACGroupBox getOuterServices(){
    if(outerServices==null){

      outerServices = new ACGroupBox();

      outerServices.setText("�O�����p�^�T�[�r�X");

      addOuterServices();
    }
    return outerServices;

  }

  /**
   * �O�����p�^�����擾���܂��B
   * @return �O�����p�^���
   */
  public ACPanel getOuterServiceInfomation(){
    if(outerServiceInfomation==null){

      outerServiceInfomation = new ACPanel();

      addOuterServiceInfomation();
    }
    return outerServiceInfomation;

  }

  /**
   * �O�����p�^���t����P�ʐ��L���v�V�������擾���܂��B
   * @return �O�����p�^���t����P�ʐ��L���v�V����
   */
  public ACLabel getOuterServiceLimitCaption(){
    if(outerServiceLimitCaption==null){

      outerServiceLimitCaption = new ACLabel();

      outerServiceLimitCaption.setText("���t����P�ʐ�");

      addOuterServiceLimitCaption();
    }
    return outerServiceLimitCaption;

  }

  /**
   * �O�����p�^���t����P�ʐ����擾���܂��B
   * @return �O�����p�^���t����P�ʐ�
   */
  public ACTextField getOuterServiceLimit(){
    if(outerServiceLimit==null){

      outerServiceLimit = new ACTextField();

      outerServiceLimit.setBindPath("EXTERNAL_USE_LIMIT");

      outerServiceLimit.setEditable(false);

      outerServiceLimit.setColumns(5);

      outerServiceLimit.setHorizontalAlignment(SwingConstants.RIGHT);

      addOuterServiceLimit();
    }
    return outerServiceLimit;

  }

  /**
   * �O�����p�^���t����P�ʐ��P�ʂ��擾���܂��B
   * @return �O�����p�^���t����P�ʐ��P��
   */
  public ACLabel getOuterServiceLimitUnit(){
    if(outerServiceLimitUnit==null){

      outerServiceLimitUnit = new ACLabel();

      outerServiceLimitUnit.setText("�P��");

      addOuterServiceLimitUnit();
    }
    return outerServiceLimitUnit;

  }

  /**
   * �O�����p�^�W�v���׃e�[�u�����擾���܂��B
   * @return �O�����p�^�W�v���׃e�[�u��
   */
  public ACTable getOuterTable(){
    if(outerTable==null){

      outerTable = new ACTable();

      outerTable.setColumnModel(getOuterTableColumnModel());

      outerTable.setPreferredSize(new Dimension(100,50));

      addOuterTable();
    }
    return outerTable;

  }

  /**
   * �O�����p�^�W�v���׃e�[�u���J�������f�����擾���܂��B
   * @return �O�����p�^�W�v���׃e�[�u���J�������f��
   */
  protected VRTableColumnModel getOuterTableColumnModel(){
    if(outerTableColumnModel==null){
      outerTableColumnModel = new VRTableColumnModel(new TableColumn[]{});
      addOuterTableColumnModel();
    }
    return outerTableColumnModel;
  }

  /**
   * No.���擾���܂��B
   * @return No.
   */
  public ACTableColumn getOuterTableColumn1(){
    if(outerTableColumn1==null){

      outerTableColumn1 = new ACTableColumn();

      outerTableColumn1.setHeaderValue("No.");

      outerTableColumn1.setColumnName("SYSTEM_SERVICE_KIND_DETAIL");

      outerTableColumn1.setColumns(2);

      outerTableColumn1.setRendererType(ACTableCellViewer.RENDERER_TYPE_SERIAL_NO);

      outerTableColumn1.setSortable(false);

      addOuterTableColumn1();
    }
    return outerTableColumn1;

  }

  /**
   * �T�[�r�X��ނ��擾���܂��B
   * @return �T�[�r�X���
   */
  public ACTableColumn getOuterTableColumn2(){
    if(outerTableColumn2==null){

      outerTableColumn2 = new ACTableColumn();

      outerTableColumn2.setHeaderValue("�T�[�r�X���");

      outerTableColumn2.setColumnName("SYSTEM_SERVICE_KIND_DETAIL");

      outerTableColumn2.setColumns(20);

      outerTableColumn2.setFormat(QkanServiceFormat.getInstance());

      addOuterTableColumn2();
    }
    return outerTableColumn2;

  }

  /**
   * ���t�P�ʂ��擾���܂��B
   * @return ���t�P��
   */
  public ACTableColumn getOuterTableColumn3(){
    if(outerTableColumn3==null){

      outerTableColumn3 = new ACTableColumn();

      outerTableColumn3.setHeaderValue("���t�P��");

      outerTableColumn3.setColumnName("UNIT");

      outerTableColumn3.setColumns(6);

      outerTableColumn3.setHorizontalAlignment(SwingConstants.RIGHT);

      addOuterTableColumn3();
    }
    return outerTableColumn3;

  }

  /**
   * �����P�ʂ��擾���܂��B
   * @return �����P��
   */
  public ACTableColumn getOuterTableColumn4(){
    if(outerTableColumn4==null){

      outerTableColumn4 = new ACTableColumn();

      outerTableColumn4.setHeaderValue("�����P��");

      outerTableColumn4.setColumnName("ADJUST");

      outerTableColumn4.setColumns(6);

      outerTableColumn4.setHorizontalAlignment(SwingConstants.RIGHT);

      addOuterTableColumn4();
    }
    return outerTableColumn4;

  }

  /**
   * ������P�ʂ��擾���܂��B
   * @return ������P��
   */
  public ACTableColumn getOuterTableColumn5(){
    if(outerTableColumn5==null){

      outerTableColumn5 = new ACTableColumn();

      outerTableColumn5.setHeaderValue("���x�z���P��");

      outerTableColumn5.setColumnName("RESULT");

      outerTableColumn5.setColumns(8);

      outerTableColumn5.setHorizontalAlignment(SwingConstants.RIGHT);

      addOuterTableColumn5();
    }
    return outerTableColumn5;

  }

  /**
   * �{�^���̈���擾���܂��B
   * @return �{�^���̈�
   */
  public ACPanel getButtons(){
    if(buttons==null){

      buttons = new ACPanel();

      addButtons();
    }
    return buttons;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACButton getClose(){
    if(close==null){

      close = new ACButton();

      close.setText("����(C)");

      close.setMnemonic('C');

      addClose();
    }
    return close;

  }

  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001030Design() {

    super(ACFrame.getInstance(), true);
    this.getContentPane().setLayout(new VRLayout());
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    try {
      initialize();

      setSize(520, 360);

      // �E�B���h�E�𒆉��ɔz�u
      Point pos = ACFrame.getInstance().getLocationOnScreen();
      Dimension screenSize = ACFrame.getInstance().getSize();
      Dimension frameSize = this.getSize();
      if (frameSize.height > screenSize.height) {
          frameSize.height = screenSize.height;
      }
      if (frameSize.width > screenSize.width) {
          frameSize.width = screenSize.width;
      }
      this.setLocation((int)(pos.getX()+(screenSize.width - frameSize.width) / 2),
              (int)(pos.getY()+(screenSize.height - frameSize.height) / 2));

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

    this.getContentPane().add(getContents(), VRLayout.CLIENT);

  }

  /**
   * �N���C�A���g�̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addContents(){

    contents.add(getInLimitAmount(), VRLayout.CLIENT);

    contents.add(getButtons(), VRLayout.SOUTH);
    contents.add(getOuterServices(), VRLayout.SOUTH);
  }

  /**
   * ���t�Ǘ��Ώۃe�[�u���̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addInLimitAmount(){

    inLimitAmount.add(getInLimitAmountInfomation(), VRLayout.NORTH);

    inLimitAmount.add(getDetailsTable(), VRLayout.CLIENT);

  }

  /**
   * ���t�Ǘ��Ώۏ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addInLimitAmountInfomation(){

    inLimitAmountInfomation.add(getInLimitAmountLimitCaption(), VRLayout.FLOW);

    inLimitAmountInfomation.add(getInLimitAmountLimit(), VRLayout.FLOW);

    inLimitAmountInfomation.add(getInLimitAmountLimitUnit(), VRLayout.FLOW);

  }

  /**
   * ���t�Ǘ��Ώێx�����x�z�L���v�V�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addInLimitAmountLimitCaption(){

  }

  /**
   * ���t�Ǘ��Ώێx�����x�z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addInLimitAmountLimit(){

  }

  /**
   * ���t�Ǘ��Ώێx�����x�z�P�ʂɓ������ڂ�ǉ����܂��B
   */
  protected void addInLimitAmountLimitUnit(){

  }

  /**
   * ���t�Ǘ��ΏۏW�v���׃e�[�u���ɓ������ڂ�ǉ����܂��B
   */
  protected void addDetailsTable(){

  }

  /**
   * ���t�Ǘ��ΏۏW�v���׃e�[�u���J�������f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addDetailsTableColumnModel(){

    getDetailsTableColumnModel().addColumn(getDetailsTableColumn1());

    getDetailsTableColumnModel().addColumn(getDetailsTableColumn2());

    getDetailsTableColumnModel().addColumn(getDetailsTableColumn3());

    getDetailsTableColumnModel().addColumn(getDetailsTableColumn4());

    getDetailsTableColumnModel().addColumn(getDetailsTableColumn5());

  }

  /**
   * No.�ɓ������ڂ�ǉ����܂��B
   */
  protected void addDetailsTableColumn1(){

  }

  /**
   * �T�[�r�X��ނɓ������ڂ�ǉ����܂��B
   */
  protected void addDetailsTableColumn2(){

  }

  /**
   * ���t�P�ʂɓ������ڂ�ǉ����܂��B
   */
  protected void addDetailsTableColumn3(){

  }

  /**
   * �����P�ʂɓ������ڂ�ǉ����܂��B
   */
  protected void addDetailsTableColumn4(){

  }

  /**
   * ���x�z���P�ʂɓ������ڂ�ǉ����܂��B
   */
  protected void addDetailsTableColumn5(){

  }

  /**
   * �O�����p�^�e�[�u���̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addOuterServices(){

    outerServices.add(getOuterServiceInfomation(), VRLayout.NORTH);

    outerServices.add(getOuterTable(), VRLayout.CLIENT);

  }

  /**
   * �O�����p�^���ɓ������ڂ�ǉ����܂��B
   */
  protected void addOuterServiceInfomation(){

    outerServiceInfomation.add(getOuterServiceLimitCaption(), VRLayout.FLOW);

    outerServiceInfomation.add(getOuterServiceLimit(), VRLayout.FLOW);

    outerServiceInfomation.add(getOuterServiceLimitUnit(), VRLayout.FLOW);

  }

  /**
   * �O�����p�^���t����P�ʐ��L���v�V�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addOuterServiceLimitCaption(){

  }

  /**
   * �O�����p�^���t����P�ʐ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addOuterServiceLimit(){

  }

  /**
   * �O�����p�^���t����P�ʐ��P�ʂɓ������ڂ�ǉ����܂��B
   */
  protected void addOuterServiceLimitUnit(){

  }

  /**
   * �O�����p�^�W�v���׃e�[�u���ɓ������ڂ�ǉ����܂��B
   */
  protected void addOuterTable(){

  }

  /**
   * �O�����p�^�W�v���׃e�[�u���J�������f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addOuterTableColumnModel(){

    getOuterTableColumnModel().addColumn(getOuterTableColumn1());

    getOuterTableColumnModel().addColumn(getOuterTableColumn2());

    getOuterTableColumnModel().addColumn(getOuterTableColumn3());

    getOuterTableColumnModel().addColumn(getOuterTableColumn4());

    getOuterTableColumnModel().addColumn(getOuterTableColumn5());

  }

  /**
   * No.�ɓ������ڂ�ǉ����܂��B
   */
  protected void addOuterTableColumn1(){

  }

  /**
   * �T�[�r�X��ނɓ������ڂ�ǉ����܂��B
   */
  protected void addOuterTableColumn2(){

  }

  /**
   * ���t�P�ʂɓ������ڂ�ǉ����܂��B
   */
  protected void addOuterTableColumn3(){

  }

  /**
   * �����P�ʂɓ������ڂ�ǉ����܂��B
   */
  protected void addOuterTableColumn4(){

  }

  /**
   * ������P�ʂɓ������ڂ�ǉ����܂��B
   */
  protected void addOuterTableColumn5(){

  }

  /**
   * �{�^���̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addButtons(){

    buttons.add(getClose(), VRLayout.EAST);
  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addClose(){

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

  public void setVisible(boolean visible){
    if(visible){
      try{
        initAffair(null);
      }catch(Throwable ex){
        ACCommon.getInstance().showExceptionMessage(ex);
      }
    }
    super.setVisible(visible);
  }
  public static void main(String[] args) {
    //�f�t�H���g�f�o�b�O�N��
    try {
      ACFrame.setVRLookAndFeel();
      ACFrame.getInstance().setFrameEventProcesser(new QkanFrameEventProcesser());
      new QS001030Design().setVisible(true);
      System.exit(0);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QS001030Design getThis() {
    return this;
  }
}
