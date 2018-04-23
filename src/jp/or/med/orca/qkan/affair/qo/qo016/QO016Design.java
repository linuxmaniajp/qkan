
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
 * �J����: 
 * �쐬��: 2016/09/14  ���{�R���s���[�^�[�������  �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���̑� (O)
 * �v���Z�X �������ƃT�[�r�X�R�[�h�ꗗ (016)
 * �v���O���� �������ƃT�[�r�X�R�[�h�ꗗ (QO016)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qo.qo016;
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
 * �������ƃT�[�r�X�R�[�h�ꗗ��ʍ��ڃf�U�C��(QO016) 
 */
public class QO016Design extends QkanAffairContainer implements ACAffairable {
  //GUI�R���|�[�l���g

  private ACAffairButtonBar buttons;

  private ACAffairButton find;

  private ACAffairButton detail;

  private ACAffairButton insert;

  private ACAffairButton delete;

  private ACPanel sjServiceCodeInfoFind;

  private ACLabelContainer insurerContena;

  private ACTextField insurerNoText;

  private ACComboBox insurerNoCombo;

  private ACComboBoxModelAdapter insurerNoComboModel;

  private ACLabelContainer serviceCodeKindContena;

  private ACComboBox serviceCodeKindCombo;

  private ACComboBoxModelAdapter serviceCodeKindComboModel;

  private ACLabelContainer targetDateContena;

  private QkanYearDateTextField targetDate;

  private ACPanel comment;

  private ACLabel targetDateComment;

  private ACPanel sjServiceCodeInfos;

  private ACTable sjServiceCodeInfoTable;

  private VRTableColumnModel sjServiceCodeInfoTableColumnModel;

  private ACTableColumn sjServiceCodeTableColum1;

  private ACTableColumn sjServiceCodeTableColum2;

  private ACTableColumn sjServiceCodeTableColum3;

  private ACTableColumn sjServiceCodeTableColum4;

  private ACTableColumn sjServiceCodeTableColum5;

  private ACTableColumn sjServiceCodeTableColum6;

  private ACTableColumn sjServiceCodeTableColum7;

  //getter

  /**
   * �{�^���o�[���擾���܂��B
   * @return �{�^���o�[
   */
  public ACAffairButtonBar getButtons(){
    if(buttons==null){

      buttons = new ACAffairButtonBar();

      buttons.setText("�������ƃT�[�r�X�R�[�h�ꗗ");

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

      find.setToolTipText("�������ƃT�[�r�X�R�[�h�����������܂��B");

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

      detail.setToolTipText("�I�����ꂽ�������ƃT�[�r�X�R�[�h�̕ҏW��ʂֈڂ�܂��B");

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

      insert.setToolTipText("�������ƃT�[�r�X�R�[�h��V�K�ɍ쐬���܂��B");

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

      delete.setToolTipText("�I�����ꂽ�������ƃT�[�r�X�R�[�h�̏����폜���܂��B");

      delete.setMnemonic('D');

      delete.setIconPath(ACConstants.ICON_PATH_DELETE_24);

      addDelete();
    }
    return delete;

  }

  /**
   * �������ƃT�[�r�X�R�[�h��񌟍��̈���擾���܂��B
   * @return �������ƃT�[�r�X�R�[�h��񌟍��̈�
   */
  public ACPanel getSjServiceCodeInfoFind(){
    if(sjServiceCodeInfoFind==null){

      sjServiceCodeInfoFind = new ACPanel();

      sjServiceCodeInfoFind.setVgap(4);

      addSjServiceCodeInfoFind();
    }
    return sjServiceCodeInfoFind;

  }

  /**
   * �ی��Ҕԍ��E�R���e�i���擾���܂��B
   * @return �ی��Ҕԍ��E�R���e�i
   */
  public ACLabelContainer getInsurerContena(){
    if(insurerContena==null){

      insurerContena = new ACLabelContainer();

      insurerContena.setText("�ی��Ҕԍ�");

      addInsurerContena();
    }
    return insurerContena;

  }

  /**
   * �ی��Ҕԍ��E�e�L�X�g���擾���܂��B
   * @return �ی��Ҕԍ��E�e�L�X�g
   */
  public ACTextField getInsurerNoText(){
    if(insurerNoText==null){

      insurerNoText = new ACTextField();

      insurerNoText.setBindPath("INSURER_ID");

      insurerNoText.setColumns(6);

      insurerNoText.setCharType(VRCharType.ONLY_DIGIT);

      insurerNoText.setIMEMode(InputSubset.LATIN);

      insurerNoText.setMaxLength(6);

      addInsurerNoText();
    }
    return insurerNoText;

  }

  /**
   * �ی��Ҕԍ��E�R���{���擾���܂��B
   * @return �ی��Ҕԍ��E�R���{
   */
  public ACComboBox getInsurerNoCombo(){
    if(insurerNoCombo==null){

      insurerNoCombo = new ACComboBox();

      insurerNoCombo.setBindPath("INSURER_NAME");

      insurerNoCombo.setEditable(false);

      insurerNoCombo.setModelBindPath("INSURER_ID");

      insurerNoCombo.setRenderBindPath("INSURER_NAME");

      insurerNoCombo.setModel(getInsurerNoComboModel());

      addInsurerNoCombo();
    }
    return insurerNoCombo;

  }

  /**
   * �ی��Ҕԍ��E�R���{���f�����擾���܂��B
   * @return �ی��Ҕԍ��E�R���{���f��
   */
  protected ACComboBoxModelAdapter getInsurerNoComboModel(){
    if(insurerNoComboModel==null){
      insurerNoComboModel = new ACComboBoxModelAdapter();
      addInsurerNoComboModel();
    }
    return insurerNoComboModel;
  }

  /**
   * �T�[�r�X��ށE�R���e�i���擾���܂��B
   * @return �T�[�r�X��ށE�R���e�i
   */
  public ACLabelContainer getServiceCodeKindContena(){
    if(serviceCodeKindContena==null){

      serviceCodeKindContena = new ACLabelContainer();

      serviceCodeKindContena.setText("�T�[�r�X���");

      addServiceCodeKindContena();
    }
    return serviceCodeKindContena;

  }

  /**
   * �T�[�r�X��ށE�R���{���擾���܂��B
   * @return �T�[�r�X��ށE�R���{
   */
  public ACComboBox getServiceCodeKindCombo(){
    if(serviceCodeKindCombo==null){

      serviceCodeKindCombo = new ACComboBox();

      serviceCodeKindCombo.setBindPath("SERVICE_CODE_KIND");

      serviceCodeKindCombo.setEditable(false);

      serviceCodeKindCombo.setModelBindPath("SERVICE_CODE_KIND");

      serviceCodeKindCombo.setRenderBindPath("SERVICE_NAME");

      serviceCodeKindCombo.setBlankable(true);

      serviceCodeKindCombo.setModel(getServiceCodeKindComboModel());

      addServiceCodeKindCombo();
    }
    return serviceCodeKindCombo;

  }

  /**
   * �T�[�r�X��ށE�R���{���f�����擾���܂��B
   * @return �T�[�r�X��ށE�R���{���f��
   */
  protected ACComboBoxModelAdapter getServiceCodeKindComboModel(){
    if(serviceCodeKindComboModel==null){
      serviceCodeKindComboModel = new ACComboBoxModelAdapter();
      addServiceCodeKindComboModel();
    }
    return serviceCodeKindComboModel;
  }

  /**
   * �Ώ۔N���E�R���e�i���擾���܂��B
   * @return �Ώ۔N���E�R���e�i
   */
  public ACLabelContainer getTargetDateContena(){
    if(targetDateContena==null){

      targetDateContena = new ACLabelContainer();

      targetDateContena.setText("�Ώ۔N��");

      addTargetDateContena();
    }
    return targetDateContena;

  }

  /**
   * �Ώ۔N�����擾���܂��B
   * @return �Ώ۔N��
   */
  public QkanYearDateTextField getTargetDate(){
    if(targetDate==null){

      targetDate = new QkanYearDateTextField();

      targetDate.setBindPath("TARGET_DATE");

      try{
        targetDate.setMinimumDate(QkanConstants.H3004);
      }catch(Throwable ex){
        ACCommon.getInstance().showExceptionMessage(new IllegalArgumentException("targetDate �̍ŏ��N�����ɕs���ȓ��t���w�肳��Ă��܂��B"));
      }

      addTargetDate();
    }
    return targetDate;

  }

  /**
   * �R�����g�̈���擾���܂��B
   * @return �R�����g�̈�
   */
  public ACPanel getComment(){
    if(comment==null){

      comment = new ACPanel();

      addComment();
    }
    return comment;

  }

  /**
   * �Ώ۔N���R�����g���擾���܂��B
   * @return �Ώ۔N���R�����g
   */
  public ACLabel getTargetDateComment(){
    if(targetDateComment==null){

      targetDateComment = new ACLabel();

      targetDateComment.setText("�i�w�肳�ꂽ�N�����_�ŗL���ȃf�[�^���������܂��j");

      targetDateComment.setAutoWrap(true);

      addTargetDateComment();
    }
    return targetDateComment;

  }

  /**
   * �������ƃT�[�r�X�R�[�h���\���̈���擾���܂��B
   * @return �������ƃT�[�r�X�R�[�h���\���̈�
   */
  public ACPanel getSjServiceCodeInfos(){
    if(sjServiceCodeInfos==null){

      sjServiceCodeInfos = new ACPanel();

      addSjServiceCodeInfos();
    }
    return sjServiceCodeInfos;

  }

  /**
   * �������ƃT�[�r�X�R�[�h���e�[�u�����擾���܂��B
   * @return �������ƃT�[�r�X�R�[�h���e�[�u��
   */
  public ACTable getSjServiceCodeInfoTable(){
    if(sjServiceCodeInfoTable==null){

      sjServiceCodeInfoTable = new ACTable();

      sjServiceCodeInfoTable.setColumnModel(getSjServiceCodeInfoTableColumnModel());

      addSjServiceCodeInfoTable();
    }
    return sjServiceCodeInfoTable;

  }

  /**
   * �������ƃT�[�r�X�R�[�h���e�[�u���J�������f�����擾���܂��B
   * @return �������ƃT�[�r�X�R�[�h���e�[�u���J�������f��
   */
  protected VRTableColumnModel getSjServiceCodeInfoTableColumnModel(){
    if(sjServiceCodeInfoTableColumnModel==null){
      sjServiceCodeInfoTableColumnModel = new VRTableColumnModel(new TableColumn[]{});
      addSjServiceCodeInfoTableColumnModel();
    }
    return sjServiceCodeInfoTableColumnModel;
  }

  /**
   * No.���擾���܂��B
   * @return No.
   */
  public ACTableColumn getSjServiceCodeTableColum1(){
    if(sjServiceCodeTableColum1==null){

      sjServiceCodeTableColum1 = new ACTableColumn();

      sjServiceCodeTableColum1.setHeaderValue("No.");

      sjServiceCodeTableColum1.setColumnName("SYSTEM_SERVICE_CODE_ITEM");

      sjServiceCodeTableColum1.setColumns(3);

      sjServiceCodeTableColum1.setHorizontalAlignment(SwingConstants.LEFT);

      sjServiceCodeTableColum1.setRendererType(ACTableCellViewer.RENDERER_TYPE_SERIAL_NO);

      sjServiceCodeTableColum1.setSortable(false);

      addSjServiceCodeTableColum1();
    }
    return sjServiceCodeTableColum1;

  }

  /**
   * �R�[�h���擾���܂��B
   * @return �R�[�h
   */
  public ACTableColumn getSjServiceCodeTableColum2(){
    if(sjServiceCodeTableColum2==null){

      sjServiceCodeTableColum2 = new ACTableColumn();

      sjServiceCodeTableColum2.setHeaderValue("�R�[�h");

      sjServiceCodeTableColum2.setColumnName("SERVICE_CODE");

      sjServiceCodeTableColum2.setColumns(6);

      sjServiceCodeTableColum2.setHorizontalAlignment(SwingConstants.LEFT);

      addSjServiceCodeTableColum2();
    }
    return sjServiceCodeTableColum2;

  }

  /**
   * �K�p�J�n�N�������擾���܂��B
   * @return �K�p�J�n�N����
   */
  public ACTableColumn getSjServiceCodeTableColum3(){
    if(sjServiceCodeTableColum3==null){

      sjServiceCodeTableColum3 = new ACTableColumn();

      sjServiceCodeTableColum3.setHeaderValue("�K�p�J�n�N����");

      sjServiceCodeTableColum3.setColumnName("TEKIYO_ST_DATE");

      sjServiceCodeTableColum3.setColumns(10);

      sjServiceCodeTableColum3.setHorizontalAlignment(SwingConstants.LEFT);

      sjServiceCodeTableColum3.setFormat(new ACBorderBlankDateFormat("gggee�NMM��dd��"));

      addSjServiceCodeTableColum3();
    }
    return sjServiceCodeTableColum3;

  }

  /**
   * �K�p�I���N�������擾���܂��B
   * @return �K�p�I���N����
   */
  public ACTableColumn getSjServiceCodeTableColum4(){
    if(sjServiceCodeTableColum4==null){

      sjServiceCodeTableColum4 = new ACTableColumn();

      sjServiceCodeTableColum4.setHeaderValue("�K�p�I���N����");

      sjServiceCodeTableColum4.setColumnName("TEKIYO_ED_DATE");

      sjServiceCodeTableColum4.setColumns(10);

      sjServiceCodeTableColum4.setHorizontalAlignment(SwingConstants.LEFT);

      sjServiceCodeTableColum4.setFormat(new ACBorderBlankDateFormat("gggee�NMM��dd��"));

      addSjServiceCodeTableColum4();
    }
    return sjServiceCodeTableColum4;

  }

  /**
   * �T�[�r�X���̂��擾���܂��B
   * @return �T�[�r�X����
   */
  public ACTableColumn getSjServiceCodeTableColum5(){
    if(sjServiceCodeTableColum5==null){

      sjServiceCodeTableColum5 = new ACTableColumn();

      sjServiceCodeTableColum5.setHeaderValue("�T�[�r�X����");

      sjServiceCodeTableColum5.setColumnName("SERVICE_NAME");

      sjServiceCodeTableColum5.setColumns(32);

      sjServiceCodeTableColum5.setHorizontalAlignment(SwingConstants.LEFT);

      addSjServiceCodeTableColum5();
    }
    return sjServiceCodeTableColum5;

  }

  /**
   * �P�ʐ����擾���܂��B
   * @return �P�ʐ�
   */
  public ACTableColumn getSjServiceCodeTableColum6(){
    if(sjServiceCodeTableColum6==null){

      sjServiceCodeTableColum6 = new ACTableColumn();

      sjServiceCodeTableColum6.setHeaderValue("�P�ʐ�");

      sjServiceCodeTableColum6.setColumnName("SERVICE_UNIT");

      sjServiceCodeTableColum6.setColumns(6);

      sjServiceCodeTableColum6.setHorizontalAlignment(SwingConstants.RIGHT);

      addSjServiceCodeTableColum6();
    }
    return sjServiceCodeTableColum6;

  }

  /**
   * �쐬�N�������擾���܂��B
   * @return �쐬�N����
   */
  public ACTableColumn getSjServiceCodeTableColum7(){
    if(sjServiceCodeTableColum7==null){

      sjServiceCodeTableColum7 = new ACTableColumn();

      sjServiceCodeTableColum7.setHeaderValue("�쐬�N����");

      sjServiceCodeTableColum7.setColumnName("SAKUSEI_DATE");

      sjServiceCodeTableColum7.setColumns(10);

      sjServiceCodeTableColum7.setHorizontalAlignment(SwingConstants.LEFT);

      sjServiceCodeTableColum7.setFormat(new ACBorderBlankDateFormat("gggee�NMM��dd��"));

      addSjServiceCodeTableColum7();
    }
    return sjServiceCodeTableColum7;

  }

  /**
   * �R���X�g���N�^�ł��B
   */
  public QO016Design() {

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

    this.add(getSjServiceCodeInfoFind(), VRLayout.NORTH);

    this.add(getSjServiceCodeInfos(), VRLayout.CLIENT);

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
   * �������ƃT�[�r�X�R�[�h��񌟍��̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addSjServiceCodeInfoFind(){

    sjServiceCodeInfoFind.add(getInsurerContena(), VRLayout.FLOW_INSETLINE_RETURN);

    sjServiceCodeInfoFind.add(getServiceCodeKindContena(), VRLayout.FLOW_INSETLINE_RETURN);

    sjServiceCodeInfoFind.add(getTargetDateContena(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * �ی��Ҕԍ��E�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addInsurerContena(){

    insurerContena.add(getInsurerNoText(), VRLayout.FLOW);

    insurerContena.add(getInsurerNoCombo(), VRLayout.FLOW);

  }

  /**
   * �ی��Ҕԍ��E�e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addInsurerNoText(){

  }

  /**
   * �ی��Ҕԍ��E�R���{�ɓ������ڂ�ǉ����܂��B
   */
  protected void addInsurerNoCombo(){

  }

  /**
   * �ی��Ҕԍ��E�R���{���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addInsurerNoComboModel(){

  }

  /**
   * �T�[�r�X��ށE�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceCodeKindContena(){

    serviceCodeKindContena.add(getServiceCodeKindCombo(), VRLayout.FLOW);

  }

  /**
   * �T�[�r�X��ށE�R���{�ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceCodeKindCombo(){

  }

  /**
   * �T�[�r�X��ށE�R���{���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceCodeKindComboModel(){

  }

  /**
   * �Ώ۔N���E�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTargetDateContena(){

    targetDateContena.add(getTargetDate(), VRLayout.FLOW);

    targetDateContena.add(getComment(), VRLayout.FLOW_RETURN);

  }

  /**
   * �Ώ۔N���ɓ������ڂ�ǉ����܂��B
   */
  protected void addTargetDate(){

  }

  /**
   * �R�����g�̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addComment(){

    comment.add(getTargetDateComment(), VRLayout.NORTH);

  }

  /**
   * �Ώ۔N���R�����g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTargetDateComment(){

  }

  /**
   * �������ƃT�[�r�X�R�[�h���\���̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addSjServiceCodeInfos(){

    sjServiceCodeInfos.add(getSjServiceCodeInfoTable(), VRLayout.CLIENT);

  }

  /**
   * �������ƃT�[�r�X�R�[�h���e�[�u���ɓ������ڂ�ǉ����܂��B
   */
  protected void addSjServiceCodeInfoTable(){

  }

  /**
   * �������ƃT�[�r�X�R�[�h���e�[�u���J�������f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addSjServiceCodeInfoTableColumnModel(){

    getSjServiceCodeInfoTableColumnModel().addColumn(getSjServiceCodeTableColum1());

    getSjServiceCodeInfoTableColumnModel().addColumn(getSjServiceCodeTableColum2());

    getSjServiceCodeInfoTableColumnModel().addColumn(getSjServiceCodeTableColum3());

    getSjServiceCodeInfoTableColumnModel().addColumn(getSjServiceCodeTableColum4());

    getSjServiceCodeInfoTableColumnModel().addColumn(getSjServiceCodeTableColum5());

    getSjServiceCodeInfoTableColumnModel().addColumn(getSjServiceCodeTableColum6());

    getSjServiceCodeInfoTableColumnModel().addColumn(getSjServiceCodeTableColum7());

  }

  /**
   * No.�ɓ������ڂ�ǉ����܂��B
   */
  protected void addSjServiceCodeTableColum1(){

  }

  /**
   * �R�[�h�ɓ������ڂ�ǉ����܂��B
   */
  protected void addSjServiceCodeTableColum2(){

  }

  /**
   * �K�p�J�n�N�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addSjServiceCodeTableColum3(){

  }

  /**
   * �K�p�I���N�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addSjServiceCodeTableColum4(){

  }

  /**
   * �T�[�r�X���̂ɓ������ڂ�ǉ����܂��B
   */
  protected void addSjServiceCodeTableColum5(){

  }

  /**
   * �P�ʐ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addSjServiceCodeTableColum6(){

  }

  /**
   * �쐬�N�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addSjServiceCodeTableColum7(){

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

    return getInsurerNoText();

  }
  public void initAffair(ACAffairInfo affair) throws Exception {
  }

  public static void main(String[] args) {
    //�f�t�H���g�f�o�b�O�N��
    try {
      ACFrame.getInstance().setFrameEventProcesser(new QkanFrameEventProcesser());
      ACFrame.debugStart(new ACAffairInfo(QO016Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QO016Design getThis() {
    return this;
  }
}
