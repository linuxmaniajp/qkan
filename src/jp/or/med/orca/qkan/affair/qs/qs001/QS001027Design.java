
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
 * �쐬��: 2006/02/28  ���{�R���s���[�^�[������� ���}�@�M�u �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �\��Ǘ� (S)
 * �v���Z�X �T�[�r�X�\�� (001)
 * �v���O���� �T�[�r�X�p�^�[����ȓ��퐶����̊��� (QS001027)
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
import jp.or.med.orca.qkan.lib.*;
import jp.or.med.orca.qkan.text.*;
/**
 * �T�[�r�X�p�^�[����ȓ��퐶����̊�����ʍ��ڃf�U�C��(QS001027) 
 */
public class QS001027Design extends QS001ServicePanel {
  //GUI�R���|�[�l���g

  private ACPanel etcContentDetailPatterns;

  private ACPanel etcContentDetail;

  private ACBackLabelContainer etcContentDetailTimeContena;

  private ACTimeComboBox etcContentDetailBeginTime;

  private ACLabelContainer etcContentDetailBeginTimeContainer;

  private ACComboBoxModelAdapter etcContentDetailBeginTimeModel;

  private ACTimeComboBox etcContentDetailEndTime;

  private ACLabelContainer etcContentDetailEndTimeContainer;

  private ACComboBoxModelAdapter etcContentDetailEndTimeModel;

  private QS001OtherItemListBox etcContentDetailIList;

  private ACLabelContainer etcContentDetailIListContainer;

  private ACListModelAdapter etcContentDetailIListModel;

  private ACTextField etcContentDetailInput;

  private ACLabelContainer etcContentDetailInputContainer;

  private ACButton etcContentInsertButton;

  private ACButton etcContentFindButton;

  private ACButton etcContentDeleteButton;

  //getter

  /**
   * ���̑����e�ڍ׃p�^�[���̈���擾���܂��B
   * @return ���̑����e�ڍ׃p�^�[���̈�
   */
  public ACPanel getEtcContentDetailPatterns(){
    if(etcContentDetailPatterns==null){

      etcContentDetailPatterns = new ACPanel();

      etcContentDetailPatterns.setAutoWrap(false);

      addEtcContentDetailPatterns();
    }
    return etcContentDetailPatterns;

  }

  /**
   * ���e�p�l�����擾���܂��B
   * @return ���e�p�l��
   */
  public ACPanel getEtcContentDetail(){
    if(etcContentDetail==null){

      etcContentDetail = new ACPanel();

      etcContentDetail.setHgrid(200);

      addEtcContentDetail();
    }
    return etcContentDetail;

  }

  /**
   * �񋟎��ԃR���e�i���擾���܂��B
   * @return �񋟎��ԃR���e�i
   */
  public ACBackLabelContainer getEtcContentDetailTimeContena(){
    if(etcContentDetailTimeContena==null){

      etcContentDetailTimeContena = new ACBackLabelContainer();

      addEtcContentDetailTimeContena();
    }
    return etcContentDetailTimeContena;

  }

  /**
   * �J�n�����R���{���擾���܂��B
   * @return �J�n�����R���{
   */
  public ACTimeComboBox getEtcContentDetailBeginTime(){
    if(etcContentDetailBeginTime==null){

      etcContentDetailBeginTime = new ACTimeComboBox();

      getEtcContentDetailBeginTimeContainer().setText("�J�n����");

      etcContentDetailBeginTime.setBindPath("3");

      etcContentDetailBeginTime.setModelBindPath("3");

      etcContentDetailBeginTime.setModel(getEtcContentDetailBeginTimeModel());

      etcContentDetailBeginTime.setRenderBindPath("CONTENT");

      addEtcContentDetailBeginTime();
    }
    return etcContentDetailBeginTime;

  }

  /**
   * �J�n�����R���{�R���e�i���擾���܂��B
   * @return �J�n�����R���{�R���e�i
   */
  protected ACLabelContainer getEtcContentDetailBeginTimeContainer(){
    if(etcContentDetailBeginTimeContainer==null){
      etcContentDetailBeginTimeContainer = new ACLabelContainer();
      etcContentDetailBeginTimeContainer.setFollowChildEnabled(true);
      etcContentDetailBeginTimeContainer.setVAlignment(VRLayout.CENTER);
      etcContentDetailBeginTimeContainer.add(getEtcContentDetailBeginTime(), null);
    }
    return etcContentDetailBeginTimeContainer;
  }

  /**
   * �J�n�����R���{���f�����擾���܂��B
   * @return �J�n�����R���{���f��
   */
  protected ACComboBoxModelAdapter getEtcContentDetailBeginTimeModel(){
    if(etcContentDetailBeginTimeModel==null){
      etcContentDetailBeginTimeModel = new ACComboBoxModelAdapter();
      addEtcContentDetailBeginTimeModel();
    }
    return etcContentDetailBeginTimeModel;
  }

  /**
   * �I�������R���{���擾���܂��B
   * @return �I�������R���{
   */
  public ACTimeComboBox getEtcContentDetailEndTime(){
    if(etcContentDetailEndTime==null){

      etcContentDetailEndTime = new ACTimeComboBox();

      getEtcContentDetailEndTimeContainer().setText("�I������");

      etcContentDetailEndTime.setBindPath("4");

      etcContentDetailEndTime.setModelBindPath("4");

      etcContentDetailEndTime.setModel(getEtcContentDetailEndTimeModel());

      etcContentDetailEndTime.setRenderBindPath("CONTENT");

      addEtcContentDetailEndTime();
    }
    return etcContentDetailEndTime;

  }

  /**
   * �I�������R���{�R���e�i���擾���܂��B
   * @return �I�������R���{�R���e�i
   */
  protected ACLabelContainer getEtcContentDetailEndTimeContainer(){
    if(etcContentDetailEndTimeContainer==null){
      etcContentDetailEndTimeContainer = new ACLabelContainer();
      etcContentDetailEndTimeContainer.setFollowChildEnabled(true);
      etcContentDetailEndTimeContainer.setVAlignment(VRLayout.CENTER);
      etcContentDetailEndTimeContainer.add(getEtcContentDetailEndTime(), null);
    }
    return etcContentDetailEndTimeContainer;
  }

  /**
   * �I�������R���{���f�����擾���܂��B
   * @return �I�������R���{���f��
   */
  protected ACComboBoxModelAdapter getEtcContentDetailEndTimeModel(){
    if(etcContentDetailEndTimeModel==null){
      etcContentDetailEndTimeModel = new ACComboBoxModelAdapter();
      addEtcContentDetailEndTimeModel();
    }
    return etcContentDetailEndTimeModel;
  }

  /**
   * ���e�ڍ׃��X�g���擾���܂��B
   * @return ���e�ڍ׃��X�g
   */
  public QS001OtherItemListBox getEtcContentDetailIList(){
    if(etcContentDetailIList==null){

      etcContentDetailIList = new QS001OtherItemListBox();

      getEtcContentDetailIListContainer().setText("���͌��");

      etcContentDetailIList.setBindPath("dummy");

      etcContentDetailIList.setColumns(12);

      etcContentDetailIList.setModel(getEtcContentDetailIListModel());

      etcContentDetailIList.setVisibleRowCount(11);

      addEtcContentDetailIList();
    }
    return etcContentDetailIList;

  }

  /**
   * ���e�ڍ׃��X�g�R���e�i���擾���܂��B
   * @return ���e�ڍ׃��X�g�R���e�i
   */
  protected ACLabelContainer getEtcContentDetailIListContainer(){
    if(etcContentDetailIListContainer==null){
      etcContentDetailIListContainer = new ACLabelContainer();
      etcContentDetailIListContainer.setFollowChildEnabled(true);
      etcContentDetailIListContainer.setVAlignment(VRLayout.CENTER);
      etcContentDetailIListContainer.add(getEtcContentDetailIList(), null);
    }
    return etcContentDetailIListContainer;
  }

  /**
   * ���e�ڍ׃��X�g���f�����擾���܂��B
   * @return ���e�ڍ׃��X�g���f��
   */
  protected ACListModelAdapter getEtcContentDetailIListModel(){
    if(etcContentDetailIListModel==null){
      etcContentDetailIListModel = new ACListModelAdapter();
      addEtcContentDetailIListModel();
    }
    return etcContentDetailIListModel;
  }

  /**
   * ���e�ڍ׃e�L�X�g���擾���܂��B
   * @return ���e�ڍ׃e�L�X�g
   */
  public ACTextField getEtcContentDetailInput(){
    if(etcContentDetailInput==null){

      etcContentDetailInput = new ACTextField();

      getEtcContentDetailInputContainer().setText("���e�ڍ�");

      etcContentDetailInput.setBindPath("9020101");

      etcContentDetailInput.setColumns(11);

      etcContentDetailInput.setIMEMode(InputSubset.KANJI);

      etcContentDetailInput.setMaxLength(10);

      addEtcContentDetailInput();
    }
    return etcContentDetailInput;

  }

  /**
   * ���e�ڍ׃e�L�X�g�R���e�i���擾���܂��B
   * @return ���e�ڍ׃e�L�X�g�R���e�i
   */
  protected ACLabelContainer getEtcContentDetailInputContainer(){
    if(etcContentDetailInputContainer==null){
      etcContentDetailInputContainer = new ACLabelContainer();
      etcContentDetailInputContainer.setFollowChildEnabled(true);
      etcContentDetailInputContainer.setVAlignment(VRLayout.CENTER);
      etcContentDetailInputContainer.add(getEtcContentDetailInput(), null);
    }
    return etcContentDetailInputContainer;
  }

  /**
   * �ǉ����擾���܂��B
   * @return �ǉ�
   */
  public ACButton getEtcContentInsertButton(){
    if(etcContentInsertButton==null){

      etcContentInsertButton = new ACButton();

      etcContentInsertButton.setText("�ǉ�");

      addEtcContentInsertButton();
    }
    return etcContentInsertButton;

  }

  /**
   * �ҏW���擾���܂��B
   * @return �ҏW
   */
  public ACButton getEtcContentFindButton(){
    if(etcContentFindButton==null){

      etcContentFindButton = new ACButton();

      etcContentFindButton.setText("�ҏW");

      addEtcContentFindButton();
    }
    return etcContentFindButton;

  }

  /**
   * �폜���擾���܂��B
   * @return �폜
   */
  public ACButton getEtcContentDeleteButton(){
    if(etcContentDeleteButton==null){

      etcContentDeleteButton = new ACButton();

      etcContentDeleteButton.setText("�폜");

      addEtcContentDeleteButton();
    }
    return etcContentDeleteButton;

  }

  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001027Design() {

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

    this.add(getEtcContentDetailPatterns(), VRLayout.WEST);

  }

  /**
   * ���̑����e�ڍ׃p�^�[���̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addEtcContentDetailPatterns(){

    etcContentDetailPatterns.add(getEtcContentDetail(), VRLayout.NORTH);

  }

  /**
   * ���e�p�l���ɓ������ڂ�ǉ����܂��B
   */
  protected void addEtcContentDetail(){

    etcContentDetail.add(getEtcContentDetailTimeContena(), VRLayout.FLOW_DOUBLEINSETLINE_RETURN);

    etcContentDetail.add(getEtcContentDetailIListContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    etcContentDetail.add(getEtcContentDetailInputContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    etcContentDetail.add(getEtcContentInsertButton(), VRLayout.FLOW);

    etcContentDetail.add(getEtcContentFindButton(), VRLayout.FLOW);

    etcContentDetail.add(getEtcContentDeleteButton(), VRLayout.FLOW);

  }

  /**
   * �񋟎��ԃR���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addEtcContentDetailTimeContena(){

    etcContentDetailTimeContena.add(getEtcContentDetailBeginTimeContainer(), VRLayout.FLOW);

    etcContentDetailTimeContena.add(getEtcContentDetailEndTimeContainer(), VRLayout.FLOW);

  }

  /**
   * �J�n�����R���{�ɓ������ڂ�ǉ����܂��B
   */
  protected void addEtcContentDetailBeginTime(){

  }

  /**
   * �J�n�����R���{���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addEtcContentDetailBeginTimeModel(){

  }

  /**
   * �I�������R���{�ɓ������ڂ�ǉ����܂��B
   */
  protected void addEtcContentDetailEndTime(){

  }

  /**
   * �I�������R���{���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addEtcContentDetailEndTimeModel(){

  }

  /**
   * ���e�ڍ׃��X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addEtcContentDetailIList(){

  }

  /**
   * ���e�ڍ׃��X�g���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addEtcContentDetailIListModel(){

  }

  /**
   * ���e�ڍ׃e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addEtcContentDetailInput(){

  }

  /**
   * �ǉ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addEtcContentInsertButton(){

  }

  /**
   * �ҏW�ɓ������ڂ�ǉ����܂��B
   */
  protected void addEtcContentFindButton(){

  }

  /**
   * �폜�ɓ������ڂ�ǉ����܂��B
   */
  protected void addEtcContentDeleteButton(){

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
      ACFrame.debugStart(new ACAffairInfo(QS001027Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QS001027Design getThis() {
    return this;
  }
}
