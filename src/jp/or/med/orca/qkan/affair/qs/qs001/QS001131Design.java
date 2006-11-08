
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
 * �J����: ���{�@�K��
 * �쐬��: 2006/05/10  ���{�R���s���[�^�[������� ���{�@�K�� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �T�[�r�X�\��쐬/�ύX (S)
 * �v���Z�X �T�[�r�X�\��T�� (001)
 * �v���O���� �T�[�r�X�p�^�[�����\�h�K�������� (QS001131)
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
 * �T�[�r�X�p�^�[�����\�h�K���������ʍ��ڃf�U�C��(QS001131) 
 */
public class QS001131Design extends QS001ServicePanel {
  //GUI�R���|�[�l���g

  private ACPanel preventiveVisitBathCareMultiPatterns;

  private ACClearableRadioButtonGroup visitPersonAddRadio;

  private ACLabelContainer visitPersonAddRadioContainer;

  private ACListModelAdapter visitPersonAddRadioModel;

  private ACRadioButtonItem visitPersonAddRadioItem1;

  private ACRadioButtonItem visitPersonAddRadioItem2;

  private ACClearableRadioButtonGroup bathCareDivisionAddRadio;

  private ACLabelContainer bathCareDivisionAddRadioContainer;

  private ACListModelAdapter bathCareDivisionAddRadioModel;

  private ACRadioButtonItem bathCareDivisionAddRadioItem1;

  private ACRadioButtonItem bathCareDivisionAddRadioItem2;

  private ACBackLabelContainer homonNyuyokuTimeContainer;

  private ACTimeComboBox homonNyuyokuBeginTime;

  private ACLabelContainer homonNyuyokuBeginTimeContainer;

  private ACComboBoxModelAdapter homonNyuyokuBeginTimeModel;

  private ACTimeComboBox homonNyuyokuEndTime;

  private ACLabelContainer homonNyuyokuEndTimeContainer;

  private ACComboBoxModelAdapter homonNyuyokuEndTimeModel;

  //getter

  /**
   * ���\�h�K��������p�^�[���̈���擾���܂��B
   * @return ���\�h�K��������p�^�[���̈�
   */
  public ACPanel getPreventiveVisitBathCareMultiPatterns(){
    if(preventiveVisitBathCareMultiPatterns==null){

      preventiveVisitBathCareMultiPatterns = new ACPanel();

      preventiveVisitBathCareMultiPatterns.setAutoWrap(false);

      preventiveVisitBathCareMultiPatterns.setHgrid(200);

      addPreventiveVisitBathCareMultiPatterns();
    }
    return preventiveVisitBathCareMultiPatterns;

  }

  /**
   * �K��҂̐l�����擾���܂��B
   * @return �K��҂̐l��
   */
  public ACClearableRadioButtonGroup getVisitPersonAddRadio(){
    if(visitPersonAddRadio==null){

      visitPersonAddRadio = new ACClearableRadioButtonGroup();

      getVisitPersonAddRadioContainer().setText("�K��҂̐l��");

      visitPersonAddRadio.setBindPath("1620101");

      visitPersonAddRadio.setUseClearButton(false);

      visitPersonAddRadio.setModel(getVisitPersonAddRadioModel());

      addVisitPersonAddRadio();
    }
    return visitPersonAddRadio;

  }

  /**
   * �K��҂̐l���R���e�i���擾���܂��B
   * @return �K��҂̐l���R���e�i
   */
  protected ACLabelContainer getVisitPersonAddRadioContainer(){
    if(visitPersonAddRadioContainer==null){
      visitPersonAddRadioContainer = new ACLabelContainer();
      visitPersonAddRadioContainer.setFollowChildEnabled(true);
      visitPersonAddRadioContainer.setVAlignment(VRLayout.CENTER);
      visitPersonAddRadioContainer.add(getVisitPersonAddRadio(), null);
    }
    return visitPersonAddRadioContainer;
  }

  /**
   * �K��҂̐l�����f�����擾���܂��B
   * @return �K��҂̐l�����f��
   */
  protected ACListModelAdapter getVisitPersonAddRadioModel(){
    if(visitPersonAddRadioModel==null){
      visitPersonAddRadioModel = new ACListModelAdapter();
      addVisitPersonAddRadioModel();
    }
    return visitPersonAddRadioModel;
  }

  /**
   * �Ō�E��1�l�y�щ��E��1�l���擾���܂��B
   * @return �Ō�E��1�l�y�щ��E��1�l
   */
  public ACRadioButtonItem getVisitPersonAddRadioItem1(){
    if(visitPersonAddRadioItem1==null){

      visitPersonAddRadioItem1 = new ACRadioButtonItem();

      visitPersonAddRadioItem1.setText("�Ō�E��1�l�y�щ��E��1�l");

      visitPersonAddRadioItem1.setGroup(getVisitPersonAddRadio());

      visitPersonAddRadioItem1.setConstraints(VRLayout.FLOW_RETURN);

      addVisitPersonAddRadioItem1();
    }
    return visitPersonAddRadioItem1;

  }

  /**
   * ���E��2�l���擾���܂��B
   * @return ���E��2�l
   */
  public ACRadioButtonItem getVisitPersonAddRadioItem2(){
    if(visitPersonAddRadioItem2==null){

      visitPersonAddRadioItem2 = new ACRadioButtonItem();

      visitPersonAddRadioItem2.setText("���E��2�l");

      visitPersonAddRadioItem2.setGroup(getVisitPersonAddRadio());

      visitPersonAddRadioItem2.setConstraints(VRLayout.FLOW);

      addVisitPersonAddRadioItem2();
    }
    return visitPersonAddRadioItem2;

  }

  /**
   * �������敪���擾���܂��B
   * @return �������敪
   */
  public ACClearableRadioButtonGroup getBathCareDivisionAddRadio(){
    if(bathCareDivisionAddRadio==null){

      bathCareDivisionAddRadio = new ACClearableRadioButtonGroup();

      getBathCareDivisionAddRadioContainer().setText("�������敪");

      bathCareDivisionAddRadio.setBindPath("1620102");

      bathCareDivisionAddRadio.setUseClearButton(false);

      bathCareDivisionAddRadio.setModel(getBathCareDivisionAddRadioModel());

      addBathCareDivisionAddRadio();
    }
    return bathCareDivisionAddRadio;

  }

  /**
   * �������敪�R���e�i���擾���܂��B
   * @return �������敪�R���e�i
   */
  protected ACLabelContainer getBathCareDivisionAddRadioContainer(){
    if(bathCareDivisionAddRadioContainer==null){
      bathCareDivisionAddRadioContainer = new ACLabelContainer();
      bathCareDivisionAddRadioContainer.setFollowChildEnabled(true);
      bathCareDivisionAddRadioContainer.setVAlignment(VRLayout.CENTER);
      bathCareDivisionAddRadioContainer.add(getBathCareDivisionAddRadio(), null);
    }
    return bathCareDivisionAddRadioContainer;
  }

  /**
   * �������敪���f�����擾���܂��B
   * @return �������敪���f��
   */
  protected ACListModelAdapter getBathCareDivisionAddRadioModel(){
    if(bathCareDivisionAddRadioModel==null){
      bathCareDivisionAddRadioModel = new ACListModelAdapter();
      addBathCareDivisionAddRadioModel();
    }
    return bathCareDivisionAddRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getBathCareDivisionAddRadioItem1(){
    if(bathCareDivisionAddRadioItem1==null){

      bathCareDivisionAddRadioItem1 = new ACRadioButtonItem();

      bathCareDivisionAddRadioItem1.setText("�Ȃ�");

      bathCareDivisionAddRadioItem1.setGroup(getBathCareDivisionAddRadio());

      bathCareDivisionAddRadioItem1.setConstraints(VRLayout.FLOW);

      addBathCareDivisionAddRadioItem1();
    }
    return bathCareDivisionAddRadioItem1;

  }

  /**
   * �������E���@�݂̂��擾���܂��B
   * @return �������E���@�̂�
   */
  public ACRadioButtonItem getBathCareDivisionAddRadioItem2(){
    if(bathCareDivisionAddRadioItem2==null){

      bathCareDivisionAddRadioItem2 = new ACRadioButtonItem();

      bathCareDivisionAddRadioItem2.setText("�������E���@�̂�");

      bathCareDivisionAddRadioItem2.setGroup(getBathCareDivisionAddRadio());

      bathCareDivisionAddRadioItem2.setConstraints(VRLayout.FLOW);

      addBathCareDivisionAddRadioItem2();
    }
    return bathCareDivisionAddRadioItem2;

  }

  /**
   * �񋟎��ԃR���e�i���擾���܂��B
   * @return �񋟎��ԃR���e�i
   */
  public ACBackLabelContainer getHomonNyuyokuTimeContainer(){
    if(homonNyuyokuTimeContainer==null){

      homonNyuyokuTimeContainer = new ACBackLabelContainer();

      addHomonNyuyokuTimeContainer();
    }
    return homonNyuyokuTimeContainer;

  }

  /**
   * �J�n�����R���{���擾���܂��B
   * @return �J�n�����R���{
   */
  public ACTimeComboBox getHomonNyuyokuBeginTime(){
    if(homonNyuyokuBeginTime==null){

      homonNyuyokuBeginTime = new ACTimeComboBox();

      getHomonNyuyokuBeginTimeContainer().setText("�J�n����");

      homonNyuyokuBeginTime.setBindPath("3");

      homonNyuyokuBeginTime.setModelBindPath("3");

      homonNyuyokuBeginTime.setRenderBindPath("CONTENT");

      homonNyuyokuBeginTime.setModel(getHomonNyuyokuBeginTimeModel());

      addHomonNyuyokuBeginTime();
    }
    return homonNyuyokuBeginTime;

  }

  /**
   * �J�n�����R���{�R���e�i���擾���܂��B
   * @return �J�n�����R���{�R���e�i
   */
  protected ACLabelContainer getHomonNyuyokuBeginTimeContainer(){
    if(homonNyuyokuBeginTimeContainer==null){
      homonNyuyokuBeginTimeContainer = new ACLabelContainer();
      homonNyuyokuBeginTimeContainer.setFollowChildEnabled(true);
      homonNyuyokuBeginTimeContainer.setVAlignment(VRLayout.CENTER);
      homonNyuyokuBeginTimeContainer.add(getHomonNyuyokuBeginTime(), null);
    }
    return homonNyuyokuBeginTimeContainer;
  }

  /**
   * �J�n�����R���{���f�����擾���܂��B
   * @return �J�n�����R���{���f��
   */
  protected ACComboBoxModelAdapter getHomonNyuyokuBeginTimeModel(){
    if(homonNyuyokuBeginTimeModel==null){
      homonNyuyokuBeginTimeModel = new ACComboBoxModelAdapter();
      addHomonNyuyokuBeginTimeModel();
    }
    return homonNyuyokuBeginTimeModel;
  }

  /**
   * �I�������R���{���擾���܂��B
   * @return �I�������R���{
   */
  public ACTimeComboBox getHomonNyuyokuEndTime(){
    if(homonNyuyokuEndTime==null){

      homonNyuyokuEndTime = new ACTimeComboBox();

      getHomonNyuyokuEndTimeContainer().setText("�I������");

      homonNyuyokuEndTime.setBindPath("4");

      homonNyuyokuEndTime.setModelBindPath("4");

      homonNyuyokuEndTime.setRenderBindPath("CONTENT");

      homonNyuyokuEndTime.setModel(getHomonNyuyokuEndTimeModel());

      addHomonNyuyokuEndTime();
    }
    return homonNyuyokuEndTime;

  }

  /**
   * �I�������R���{�R���e�i���擾���܂��B
   * @return �I�������R���{�R���e�i
   */
  protected ACLabelContainer getHomonNyuyokuEndTimeContainer(){
    if(homonNyuyokuEndTimeContainer==null){
      homonNyuyokuEndTimeContainer = new ACLabelContainer();
      homonNyuyokuEndTimeContainer.setFollowChildEnabled(true);
      homonNyuyokuEndTimeContainer.setVAlignment(VRLayout.CENTER);
      homonNyuyokuEndTimeContainer.add(getHomonNyuyokuEndTime(), null);
    }
    return homonNyuyokuEndTimeContainer;
  }

  /**
   * �I�������R���{���f�����擾���܂��B
   * @return �I�������R���{���f��
   */
  protected ACComboBoxModelAdapter getHomonNyuyokuEndTimeModel(){
    if(homonNyuyokuEndTimeModel==null){
      homonNyuyokuEndTimeModel = new ACComboBoxModelAdapter();
      addHomonNyuyokuEndTimeModel();
    }
    return homonNyuyokuEndTimeModel;
  }

  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001131Design() {

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

    this.add(getPreventiveVisitBathCareMultiPatterns(), VRLayout.CLIENT);

  }

  /**
   * ���\�h�K��������p�^�[���̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPreventiveVisitBathCareMultiPatterns(){

    preventiveVisitBathCareMultiPatterns.add(getVisitPersonAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    preventiveVisitBathCareMultiPatterns.add(getBathCareDivisionAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    preventiveVisitBathCareMultiPatterns.add(getHomonNyuyokuTimeContainer(), VRLayout.FLOW_DOUBLEINSETLINE_RETURN);

  }

  /**
   * �K��҂̐l���ɓ������ڂ�ǉ����܂��B
   */
  protected void addVisitPersonAddRadio(){

  }

  /**
   * �K��҂̐l�����f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addVisitPersonAddRadioModel(){

    getVisitPersonAddRadioItem1().setButtonIndex(1);
    getVisitPersonAddRadioModel().add(getVisitPersonAddRadioItem1());

    getVisitPersonAddRadioItem2().setButtonIndex(2);
    getVisitPersonAddRadioModel().add(getVisitPersonAddRadioItem2());

  }

  /**
   * �Ō�E��1�l�y�щ��E��1�l�ɓ������ڂ�ǉ����܂��B
   */
  protected void addVisitPersonAddRadioItem1(){

  }

  /**
   * ���E��2�l�ɓ������ڂ�ǉ����܂��B
   */
  protected void addVisitPersonAddRadioItem2(){

  }

  /**
   * �������敪�ɓ������ڂ�ǉ����܂��B
   */
  protected void addBathCareDivisionAddRadio(){

  }

  /**
   * �������敪���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addBathCareDivisionAddRadioModel(){

    getBathCareDivisionAddRadioItem1().setButtonIndex(1);
    getBathCareDivisionAddRadioModel().add(getBathCareDivisionAddRadioItem1());

    getBathCareDivisionAddRadioItem2().setButtonIndex(2);
    getBathCareDivisionAddRadioModel().add(getBathCareDivisionAddRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addBathCareDivisionAddRadioItem1(){

  }

  /**
   * �������E���@�݂̂ɓ������ڂ�ǉ����܂��B
   */
  protected void addBathCareDivisionAddRadioItem2(){

  }

  /**
   * �񋟎��ԃR���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHomonNyuyokuTimeContainer(){

    homonNyuyokuTimeContainer.add(getHomonNyuyokuBeginTimeContainer(), VRLayout.FLOW);

    homonNyuyokuTimeContainer.add(getHomonNyuyokuEndTimeContainer(), VRLayout.FLOW);

  }

  /**
   * �J�n�����R���{�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHomonNyuyokuBeginTime(){

  }

  /**
   * �J�n�����R���{���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addHomonNyuyokuBeginTimeModel(){

  }

  /**
   * �I�������R���{�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHomonNyuyokuEndTime(){

  }

  /**
   * �I�������R���{���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addHomonNyuyokuEndTimeModel(){

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
      ACFrame.debugStart(new ACAffairInfo(QS001131Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QS001131Design getThis() {
    return this;
  }
}
