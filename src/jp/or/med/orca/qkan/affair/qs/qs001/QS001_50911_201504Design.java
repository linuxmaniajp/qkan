
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
 * �J����: �T��@�z��Y
 * �쐬��: 2016/09/12  ���{�R���s���[�^�[������� �T��@�z��Y �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �\��Ǘ� (S)
 * �v���Z�X �T�[�r�X�\�� (001)
 * �v���O���� �T�[�r�X�p�^�[�����̑��̐����x���T�[�r�X(�z�H�藦) (QS001_50911_201504)
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
 * �T�[�r�X�p�^�[�����̑��̐����x���T�[�r�X(�z�H�藦)��ʍ��ڃf�U�C��(QS001_50911_201504) 
 */
public class QS001_50911_201504Design extends QS001ServicePanelSogo {
  //GUI�R���|�[�l���g

  private ACPanel soA9Patterns;

  private ACPanel soA9Detail;

  private ACBackLabelContainer soA9TimeContena;

  private ACTimeComboBox soA9BeginTime;

  private ACLabelContainer soA9BeginTimeContainer;

  private ACComboBoxModelAdapter soA9BeginTimeModel;

  private ACTimeComboBox soA9EndTime;

  private ACLabelContainer soA9EndTimeContainer;

  private ACComboBoxModelAdapter soA9EndTimeModel;

  private ACComboBox insurerName;

  private ACLabelContainer insurerNameContainer;

  private ACComboBoxModelAdapter insurerNameModel;

  private ACBackLabelContainer soA9ItemCodeContena;

  private ACTextField itemCodeText;

  private ACLabelContainer itemCodeTextContainer;

  private ACButton addCodeToListButton;

  private ACButton codeFindButton;

  private ACButton deleteCodeButton;

  private ACTable svCodeTable;

  private VRTableColumnModel svCodeTableColumnModel;

  private ACTableColumn svCodeTableColumn1;

  private ACTableColumn svCodeTableColumn2;

  private ACTableColumn svCodeTableColumn3;

  private ACTableColumn svCodeTableColumn4;

  private ACTableColumn svCodeTableColumn5;

  //getter

  /**
   * ���̑��̐����x���T�[�r�X�z�H�藦�p�^�[���̈���擾���܂��B
   * @return ���̑��̐����x���T�[�r�X�z�H�藦�p�^�[���̈�
   */
  public ACPanel getSoA9Patterns(){
    if(soA9Patterns==null){

      soA9Patterns = new ACPanel();

      soA9Patterns.setAutoWrap(false);

      addSoA9Patterns();
    }
    return soA9Patterns;

  }

  /**
   * ���e�p�l�����擾���܂��B
   * @return ���e�p�l��
   */
  public ACPanel getSoA9Detail(){
    if(soA9Detail==null){

      soA9Detail = new ACPanel();

      soA9Detail.setHgrid(200);

      addSoA9Detail();
    }
    return soA9Detail;

  }

  /**
   * �񋟎��ԃR���e�i���擾���܂��B
   * @return �񋟎��ԃR���e�i
   */
  public ACBackLabelContainer getSoA9TimeContena(){
    if(soA9TimeContena==null){

      soA9TimeContena = new ACBackLabelContainer();

      addSoA9TimeContena();
    }
    return soA9TimeContena;

  }

  /**
   * �J�n�����R���{���擾���܂��B
   * @return �J�n�����R���{
   */
  public ACTimeComboBox getSoA9BeginTime(){
    if(soA9BeginTime==null){

      soA9BeginTime = new ACTimeComboBox();

      getSoA9BeginTimeContainer().setText("�J�n����");

      soA9BeginTime.setBindPath("3");

      soA9BeginTime.setModelBindPath("3");

      soA9BeginTime.setRenderBindPath("CONTENT");

      soA9BeginTime.setModel(getSoA9BeginTimeModel());

      addSoA9BeginTime();
    }
    return soA9BeginTime;

  }

  /**
   * �J�n�����R���{�R���e�i���擾���܂��B
   * @return �J�n�����R���{�R���e�i
   */
  protected ACLabelContainer getSoA9BeginTimeContainer(){
    if(soA9BeginTimeContainer==null){
      soA9BeginTimeContainer = new ACLabelContainer();
      soA9BeginTimeContainer.setFollowChildEnabled(true);
      soA9BeginTimeContainer.setVAlignment(VRLayout.CENTER);
      soA9BeginTimeContainer.add(getSoA9BeginTime(), null);
    }
    return soA9BeginTimeContainer;
  }

  /**
   * �J�n�����R���{���f�����擾���܂��B
   * @return �J�n�����R���{���f��
   */
  protected ACComboBoxModelAdapter getSoA9BeginTimeModel(){
    if(soA9BeginTimeModel==null){
      soA9BeginTimeModel = new ACComboBoxModelAdapter();
      addSoA9BeginTimeModel();
    }
    return soA9BeginTimeModel;
  }

  /**
   * �I�������R���{���擾���܂��B
   * @return �I�������R���{
   */
  public ACTimeComboBox getSoA9EndTime(){
    if(soA9EndTime==null){

      soA9EndTime = new ACTimeComboBox();

      getSoA9EndTimeContainer().setText("�I������");

      soA9EndTime.setBindPath("4");

      soA9EndTime.setModelBindPath("4");

      soA9EndTime.setRenderBindPath("CONTENT");

      soA9EndTime.setModel(getSoA9EndTimeModel());

      addSoA9EndTime();
    }
    return soA9EndTime;

  }

  /**
   * �I�������R���{�R���e�i���擾���܂��B
   * @return �I�������R���{�R���e�i
   */
  protected ACLabelContainer getSoA9EndTimeContainer(){
    if(soA9EndTimeContainer==null){
      soA9EndTimeContainer = new ACLabelContainer();
      soA9EndTimeContainer.setFollowChildEnabled(true);
      soA9EndTimeContainer.setVAlignment(VRLayout.CENTER);
      soA9EndTimeContainer.add(getSoA9EndTime(), null);
    }
    return soA9EndTimeContainer;
  }

  /**
   * �I�������R���{���f�����擾���܂��B
   * @return �I�������R���{���f��
   */
  protected ACComboBoxModelAdapter getSoA9EndTimeModel(){
    if(soA9EndTimeModel==null){
      soA9EndTimeModel = new ACComboBoxModelAdapter();
      addSoA9EndTimeModel();
    }
    return soA9EndTimeModel;
  }

  /**
   * �ی��Җ����擾���܂��B
   * @return �ی��Җ�
   */
  public ACComboBox getInsurerName(){
    if(insurerName==null){

      insurerName = new ACComboBox();

      getInsurerNameContainer().setText("�ی��Җ�");

      insurerName.setBindPath("500");

      insurerName.setEditable(false);

      insurerName.setColumns(10);

      insurerName.setModelBindPath("INSURER");

      insurerName.setRenderBindPath("INSURER_NAME");

      insurerName.setMaxColumns(18);

      insurerName.setModel(getInsurerNameModel());

      addInsurerName();
    }
    return insurerName;

  }

  /**
   * �ی��Җ��R���e�i���擾���܂��B
   * @return �ی��Җ��R���e�i
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
   * �T�[�r�X���ڃR�[�h�R���e�i���擾���܂��B
   * @return �T�[�r�X���ڃR�[�h�R���e�i
   */
  public ACBackLabelContainer getSoA9ItemCodeContena(){
    if(soA9ItemCodeContena==null){

      soA9ItemCodeContena = new ACBackLabelContainer();

      addSoA9ItemCodeContena();
    }
    return soA9ItemCodeContena;

  }

  /**
   * �T�[�r�X���ڃR�[�h�e�L�X�g���擾���܂��B
   * @return �T�[�r�X���ڃR�[�h�e�L�X�g
   */
  public ACTextField getItemCodeText(){
    if(itemCodeText==null){

      itemCodeText = new ACTextField();

      getItemCodeTextContainer().setText("A9");

      itemCodeText.setColumns(4);

      itemCodeText.setIMEMode(InputSubset.LATIN);

      itemCodeText.setMaxLength(4);

      addItemCodeText();
    }
    return itemCodeText;

  }

  /**
   * �T�[�r�X���ڃR�[�h�e�L�X�g�R���e�i���擾���܂��B
   * @return �T�[�r�X���ڃR�[�h�e�L�X�g�R���e�i
   */
  protected ACLabelContainer getItemCodeTextContainer(){
    if(itemCodeTextContainer==null){
      itemCodeTextContainer = new ACLabelContainer();
      itemCodeTextContainer.setFollowChildEnabled(true);
      itemCodeTextContainer.setVAlignment(VRLayout.CENTER);
      itemCodeTextContainer.add(getItemCodeText(), null);
    }
    return itemCodeTextContainer;
  }

  /**
   * �R�[�h���ꗗ�֒ǉ����擾���܂��B
   * @return �R�[�h���ꗗ�֒ǉ�
   */
  public ACButton getAddCodeToListButton(){
    if(addCodeToListButton==null){

      addCodeToListButton = new ACButton();

      addCodeToListButton.setText("�R�[�h���ꗗ�֒ǉ�");

      addAddCodeToListButton();
    }
    return addCodeToListButton;

  }

  /**
   * �R�[�h�I�����擾���܂��B
   * @return �R�[�h�I��
   */
  public ACButton getCodeFindButton(){
    if(codeFindButton==null){

      codeFindButton = new ACButton();

      codeFindButton.setText("�R�[�h�I��");

      addCodeFindButton();
    }
    return codeFindButton;

  }

  /**
   * �R�[�h�폜���擾���܂��B
   * @return �R�[�h�폜
   */
  public ACButton getDeleteCodeButton(){
    if(deleteCodeButton==null){

      deleteCodeButton = new ACButton();

      deleteCodeButton.setText("�R�[�h�폜");

      addDeleteCodeButton();
    }
    return deleteCodeButton;

  }

  /**
   * ��ȓ��퐶���e�[�u�����擾���܂��B
   * @return ��ȓ��퐶���e�[�u��
   */
  public ACTable getSvCodeTable(){
    if(svCodeTable==null){

      svCodeTable = new ACTable();

      svCodeTable.setColumnModel(getSvCodeTableColumnModel());

      svCodeTable.setPreferredSize(new Dimension(305,160));

      addSvCodeTable();
    }
    return svCodeTable;

  }

  /**
   * ��ȓ��퐶���e�[�u���J�������f�����擾���܂��B
   * @return ��ȓ��퐶���e�[�u���J�������f��
   */
  protected VRTableColumnModel getSvCodeTableColumnModel(){
    if(svCodeTableColumnModel==null){
      svCodeTableColumnModel = new VRTableColumnModel(new TableColumn[]{});
      addSvCodeTableColumnModel();
    }
    return svCodeTableColumnModel;
  }

  /**
   * �R�[�h���擾���܂��B
   * @return �R�[�h
   */
  public ACTableColumn getSvCodeTableColumn1(){
    if(svCodeTableColumn1==null){

      svCodeTableColumn1 = new ACTableColumn();

      svCodeTableColumn1.setHeaderValue("�R�[�h");

      svCodeTableColumn1.setColumnName("SERVICE_CODE_ITEM");

      svCodeTableColumn1.setColumns(5);

      addSvCodeTableColumn1();
    }
    return svCodeTableColumn1;

  }

  /**
   * ���̂��擾���܂��B
   * @return ����
   */
  public ACTableColumn getSvCodeTableColumn2(){
    if(svCodeTableColumn2==null){

      svCodeTableColumn2 = new ACTableColumn();

      svCodeTableColumn2.setHeaderValue("����");

      svCodeTableColumn2.setColumnName("SERVICE_NAME");

      svCodeTableColumn2.setColumns(14);

      addSvCodeTableColumn2();
    }
    return svCodeTableColumn2;

  }

  /**
   * �P�ʐ����擾���܂��B
   * @return �P�ʐ�
   */
  public ACTableColumn getSvCodeTableColumn3(){
    if(svCodeTableColumn3==null){

      svCodeTableColumn3 = new ACTableColumn();

      svCodeTableColumn3.setHeaderValue("�P�ʐ�");

      svCodeTableColumn3.setColumnName("SERVICE_UNIT");

      svCodeTableColumn3.setColumns(3);

      svCodeTableColumn3.setHorizontalAlignment(SwingConstants.RIGHT);

      addSvCodeTableColumn3();
    }
    return svCodeTableColumn3;

  }

  /**
   * ���t�����擾���܂��B
   * @return ���t��
   */
  public ACTableColumn getSvCodeTableColumn4(){
    if(svCodeTableColumn4==null){

      svCodeTableColumn4 = new ACTableColumn();

      svCodeTableColumn4.setHeaderValue("���t��");

      svCodeTableColumn4.setColumnName("KYUFURITSU");

      svCodeTableColumn4.setColumns(3);

      svCodeTableColumn4.setHorizontalAlignment(SwingConstants.RIGHT);

      addSvCodeTableColumn4();
    }
    return svCodeTableColumn4;

  }

  /**
   * �ی��Ҕԍ����擾���܂��B
   * @return �ی��Ҕԍ�
   */
  public ACTableColumn getSvCodeTableColumn5(){
    if(svCodeTableColumn5==null){

      svCodeTableColumn5 = new ACTableColumn();

      svCodeTableColumn5.setHeaderValue("�ی��Ҕԍ�");

      svCodeTableColumn5.setColumnName("INSURER_ID");

      svCodeTableColumn5.setColumns(6);

      addSvCodeTableColumn5();
    }
    return svCodeTableColumn5;

  }

  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001_50911_201504Design() {

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

    this.add(getSoA9Patterns(), VRLayout.WEST);

  }

  /**
   * ���̑��̐����x���T�[�r�X�z�H�藦�p�^�[���̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addSoA9Patterns(){

    soA9Patterns.add(getSoA9Detail(), VRLayout.NORTH);

  }

  /**
   * ���e�p�l���ɓ������ڂ�ǉ����܂��B
   */
  protected void addSoA9Detail(){

    soA9Detail.add(getSoA9TimeContena(), VRLayout.FLOW_DOUBLEINSETLINE_RETURN);

    soA9Detail.add(getInsurerNameContainer(), VRLayout.FLOW_INSETLINE);

    soA9Detail.add(getSoA9ItemCodeContena(), VRLayout.FLOW_DOUBLEINSETLINE_RETURN);

    soA9Detail.add(getCodeFindButton(), VRLayout.FLOW);

    soA9Detail.add(getDeleteCodeButton(), VRLayout.FLOW_RETURN);

    soA9Detail.add(getSvCodeTable(), VRLayout.FLOW_RETURN);

  }

  /**
   * �񋟎��ԃR���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addSoA9TimeContena(){

    soA9TimeContena.add(getSoA9BeginTimeContainer(), VRLayout.FLOW);

    soA9TimeContena.add(getSoA9EndTimeContainer(), VRLayout.FLOW);

  }

  /**
   * �J�n�����R���{�ɓ������ڂ�ǉ����܂��B
   */
  protected void addSoA9BeginTime(){

  }

  /**
   * �J�n�����R���{���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addSoA9BeginTimeModel(){

  }

  /**
   * �I�������R���{�ɓ������ڂ�ǉ����܂��B
   */
  protected void addSoA9EndTime(){

  }

  /**
   * �I�������R���{���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addSoA9EndTimeModel(){

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
   * �T�[�r�X���ڃR�[�h�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addSoA9ItemCodeContena(){

    soA9ItemCodeContena.add(getItemCodeTextContainer(), VRLayout.FLOW);

    soA9ItemCodeContena.add(getAddCodeToListButton(), VRLayout.FLOW);

  }

  /**
   * �T�[�r�X���ڃR�[�h�e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addItemCodeText(){

  }

  /**
   * �R�[�h���ꗗ�֒ǉ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addAddCodeToListButton(){

  }

  /**
   * �R�[�h�I���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCodeFindButton(){

  }

  /**
   * �R�[�h�폜�ɓ������ڂ�ǉ����܂��B
   */
  protected void addDeleteCodeButton(){

  }

  /**
   * ��ȓ��퐶���e�[�u���ɓ������ڂ�ǉ����܂��B
   */
  protected void addSvCodeTable(){

  }

  /**
   * ��ȓ��퐶���e�[�u���J�������f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addSvCodeTableColumnModel(){

    getSvCodeTableColumnModel().addColumn(getSvCodeTableColumn1());

    getSvCodeTableColumnModel().addColumn(getSvCodeTableColumn2());

    getSvCodeTableColumnModel().addColumn(getSvCodeTableColumn3());

    getSvCodeTableColumnModel().addColumn(getSvCodeTableColumn4());

    getSvCodeTableColumnModel().addColumn(getSvCodeTableColumn5());

  }

  /**
   * �R�[�h�ɓ������ڂ�ǉ����܂��B
   */
  protected void addSvCodeTableColumn1(){

  }

  /**
   * ���̂ɓ������ڂ�ǉ����܂��B
   */
  protected void addSvCodeTableColumn2(){

  }

  /**
   * �P�ʐ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addSvCodeTableColumn3(){

  }

  /**
   * ���t���ɓ������ڂ�ǉ����܂��B
   */
  protected void addSvCodeTableColumn4(){

  }

  /**
   * �ی��Ҕԍ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addSvCodeTableColumn5(){

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
      ACFrame.debugStart(new ACAffairInfo(QS001_50911_201504Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QS001_50911_201504Design getThis() {
    return this;
  }
}
