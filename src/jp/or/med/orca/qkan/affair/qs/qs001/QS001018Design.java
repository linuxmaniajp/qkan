
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
 * �쐬��: 2006/02/16  ���{�R���s���[�^�[������� ���}�@�M�u �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �T�[�r�X�\��쐬/�ύX (S)
 * �v���Z�X �T�[�r�X�\��T�� (001)
 * �v���O���� �T�[�r�X�p�^�[���F�m�ǑΉ������������ (QS001018)
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
 * �T�[�r�X�p�^�[���F�m�ǑΉ�������������ʍ��ڃf�U�C��(QS001018) 
 */
public class QS001018Design extends QS001ServicePanel {
  //GUI�R���|�[�l���g

  private ACPanel typeSymbiosisNursingForDementiaPatterns;

  private ACClearableRadioButtonGroup typeSymbiosisNursingForDementiaNightTimeCareRadio;

  private ACLabelContainer typeSymbiosisNursingForDementiaNightTimeCareRadioContainer;

  private ACListModelAdapter typeSymbiosisNursingForDementiaNightTimeCareRadioModel;

  private ACRadioButtonItem typeSymbiosisNursingForDementiaNightTimeCareRadioItem1;

  private ACRadioButtonItem typeSymbiosisNursingForDementiaNightTimeCareRadioItem2;

  private ACClearableRadioButtonGroup typeSymbiosisNursingForDementiaDefaultRadio;

  private ACLabelContainer typeSymbiosisNursingForDementiaDefaultRadioContainer;

  private ACListModelAdapter typeSymbiosisNursingForDementiaDefaultRadioModel;

  private ACRadioButtonItem typeSymbiosisNursingForDementiaDefaultRadioItem1;

  private ACRadioButtonItem typeSymbiosisNursingForDementiaDefaultRadioItem2;

  private ACClearableRadioButtonGroup typeSymbiosisNursingForDementiaSubtraction;

  private ACLabelContainer typeSymbiosisNursingForDementiaSubtractionContainer;

  private ACListModelAdapter typeSymbiosisNursingForDementiaSubtractionModel;

  private ACRadioButtonItem typeSymbiosisNursingForDementiaSubtractionCapacityNot;

  private ACRadioButtonItem typeSymbiosisNursingForDementiaSubtractionCapacityExcess;

  private ACRadioButtonItem typeSymbiosisNursingForDementiaSubtractionPersonLack;

  //getter

  /**
   * �s��Ή������������p�^�[���̈���擾���܂��B
   * @return �s��Ή������������p�^�[���̈�
   */
  public ACPanel getTypeSymbiosisNursingForDementiaPatterns(){
    if(typeSymbiosisNursingForDementiaPatterns==null){

      typeSymbiosisNursingForDementiaPatterns = new ACPanel();

      typeSymbiosisNursingForDementiaPatterns.setAutoWrap(false);

      typeSymbiosisNursingForDementiaPatterns.setHgrid(200);

      addTypeSymbiosisNursingForDementiaPatterns();
    }
    return typeSymbiosisNursingForDementiaPatterns;

  }

  /**
   * ��ԃP�A���Z���擾���܂��B
   * @return ��ԃP�A���Z
   */
  public ACClearableRadioButtonGroup getTypeSymbiosisNursingForDementiaNightTimeCareRadio(){
    if(typeSymbiosisNursingForDementiaNightTimeCareRadio==null){

      typeSymbiosisNursingForDementiaNightTimeCareRadio = new ACClearableRadioButtonGroup();

      getTypeSymbiosisNursingForDementiaNightTimeCareRadioContainer().setText("��ԃP�A���Z");

      typeSymbiosisNursingForDementiaNightTimeCareRadio.setBindPath("1320103");

      typeSymbiosisNursingForDementiaNightTimeCareRadio.setModel(getTypeSymbiosisNursingForDementiaNightTimeCareRadioModel());

      typeSymbiosisNursingForDementiaNightTimeCareRadio.setUseClearButton(false);

      addTypeSymbiosisNursingForDementiaNightTimeCareRadio();
    }
    return typeSymbiosisNursingForDementiaNightTimeCareRadio;

  }

  /**
   * ��ԃP�A���Z�R���e�i���擾���܂��B
   * @return ��ԃP�A���Z�R���e�i
   */
  protected ACLabelContainer getTypeSymbiosisNursingForDementiaNightTimeCareRadioContainer(){
    if(typeSymbiosisNursingForDementiaNightTimeCareRadioContainer==null){
      typeSymbiosisNursingForDementiaNightTimeCareRadioContainer = new ACLabelContainer();
      typeSymbiosisNursingForDementiaNightTimeCareRadioContainer.setFollowChildEnabled(true);
      typeSymbiosisNursingForDementiaNightTimeCareRadioContainer.add(getTypeSymbiosisNursingForDementiaNightTimeCareRadio(), null);
    }
    return typeSymbiosisNursingForDementiaNightTimeCareRadioContainer;
  }

  /**
   * ��ԃP�A���Z���f�����擾���܂��B
   * @return ��ԃP�A���Z���f��
   */
  protected ACListModelAdapter getTypeSymbiosisNursingForDementiaNightTimeCareRadioModel(){
    if(typeSymbiosisNursingForDementiaNightTimeCareRadioModel==null){
      typeSymbiosisNursingForDementiaNightTimeCareRadioModel = new ACListModelAdapter();
      addTypeSymbiosisNursingForDementiaNightTimeCareRadioModel();
    }
    return typeSymbiosisNursingForDementiaNightTimeCareRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getTypeSymbiosisNursingForDementiaNightTimeCareRadioItem1(){
    if(typeSymbiosisNursingForDementiaNightTimeCareRadioItem1==null){

      typeSymbiosisNursingForDementiaNightTimeCareRadioItem1 = new ACRadioButtonItem();

      typeSymbiosisNursingForDementiaNightTimeCareRadioItem1.setText("�Ȃ�");

      typeSymbiosisNursingForDementiaNightTimeCareRadioItem1.setGroup(getTypeSymbiosisNursingForDementiaNightTimeCareRadio());

      typeSymbiosisNursingForDementiaNightTimeCareRadioItem1.setConstraints(VRLayout.FLOW);

      addTypeSymbiosisNursingForDementiaNightTimeCareRadioItem1();
    }
    return typeSymbiosisNursingForDementiaNightTimeCareRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getTypeSymbiosisNursingForDementiaNightTimeCareRadioItem2(){
    if(typeSymbiosisNursingForDementiaNightTimeCareRadioItem2==null){

      typeSymbiosisNursingForDementiaNightTimeCareRadioItem2 = new ACRadioButtonItem();

      typeSymbiosisNursingForDementiaNightTimeCareRadioItem2.setText("����");

      typeSymbiosisNursingForDementiaNightTimeCareRadioItem2.setGroup(getTypeSymbiosisNursingForDementiaNightTimeCareRadio());

      typeSymbiosisNursingForDementiaNightTimeCareRadioItem2.setConstraints(VRLayout.FLOW);

      addTypeSymbiosisNursingForDementiaNightTimeCareRadioItem2();
    }
    return typeSymbiosisNursingForDementiaNightTimeCareRadioItem2;

  }

  /**
   * �������Z���擾���܂��B
   * @return �������Z
   */
  public ACClearableRadioButtonGroup getTypeSymbiosisNursingForDementiaDefaultRadio(){
    if(typeSymbiosisNursingForDementiaDefaultRadio==null){

      typeSymbiosisNursingForDementiaDefaultRadio = new ACClearableRadioButtonGroup();

      getTypeSymbiosisNursingForDementiaDefaultRadioContainer().setText("�������Z");

      typeSymbiosisNursingForDementiaDefaultRadio.setBindPath("1320104");

      typeSymbiosisNursingForDementiaDefaultRadio.setModel(getTypeSymbiosisNursingForDementiaDefaultRadioModel());

      typeSymbiosisNursingForDementiaDefaultRadio.setUseClearButton(false);

      addTypeSymbiosisNursingForDementiaDefaultRadio();
    }
    return typeSymbiosisNursingForDementiaDefaultRadio;

  }

  /**
   * �������Z�R���e�i���擾���܂��B
   * @return �������Z�R���e�i
   */
  protected ACLabelContainer getTypeSymbiosisNursingForDementiaDefaultRadioContainer(){
    if(typeSymbiosisNursingForDementiaDefaultRadioContainer==null){
      typeSymbiosisNursingForDementiaDefaultRadioContainer = new ACLabelContainer();
      typeSymbiosisNursingForDementiaDefaultRadioContainer.setFollowChildEnabled(true);
      typeSymbiosisNursingForDementiaDefaultRadioContainer.add(getTypeSymbiosisNursingForDementiaDefaultRadio(), null);
    }
    return typeSymbiosisNursingForDementiaDefaultRadioContainer;
  }

  /**
   * �������Z���f�����擾���܂��B
   * @return �������Z���f��
   */
  protected ACListModelAdapter getTypeSymbiosisNursingForDementiaDefaultRadioModel(){
    if(typeSymbiosisNursingForDementiaDefaultRadioModel==null){
      typeSymbiosisNursingForDementiaDefaultRadioModel = new ACListModelAdapter();
      addTypeSymbiosisNursingForDementiaDefaultRadioModel();
    }
    return typeSymbiosisNursingForDementiaDefaultRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getTypeSymbiosisNursingForDementiaDefaultRadioItem1(){
    if(typeSymbiosisNursingForDementiaDefaultRadioItem1==null){

      typeSymbiosisNursingForDementiaDefaultRadioItem1 = new ACRadioButtonItem();

      typeSymbiosisNursingForDementiaDefaultRadioItem1.setText("�Ȃ�");

      typeSymbiosisNursingForDementiaDefaultRadioItem1.setGroup(getTypeSymbiosisNursingForDementiaDefaultRadio());

      typeSymbiosisNursingForDementiaDefaultRadioItem1.setConstraints(VRLayout.FLOW);

      addTypeSymbiosisNursingForDementiaDefaultRadioItem1();
    }
    return typeSymbiosisNursingForDementiaDefaultRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getTypeSymbiosisNursingForDementiaDefaultRadioItem2(){
    if(typeSymbiosisNursingForDementiaDefaultRadioItem2==null){

      typeSymbiosisNursingForDementiaDefaultRadioItem2 = new ACRadioButtonItem();

      typeSymbiosisNursingForDementiaDefaultRadioItem2.setText("����");

      typeSymbiosisNursingForDementiaDefaultRadioItem2.setGroup(getTypeSymbiosisNursingForDementiaDefaultRadio());

      typeSymbiosisNursingForDementiaDefaultRadioItem2.setConstraints(VRLayout.FLOW);

      addTypeSymbiosisNursingForDementiaDefaultRadioItem2();
    }
    return typeSymbiosisNursingForDementiaDefaultRadioItem2;

  }

  /**
   * �l�����Z���擾���܂��B
   * @return �l�����Z
   */
  public ACClearableRadioButtonGroup getTypeSymbiosisNursingForDementiaSubtraction(){
    if(typeSymbiosisNursingForDementiaSubtraction==null){

      typeSymbiosisNursingForDementiaSubtraction = new ACClearableRadioButtonGroup();

      getTypeSymbiosisNursingForDementiaSubtractionContainer().setText("�l�����Z");

      typeSymbiosisNursingForDementiaSubtraction.setBindPath("1320105");

      typeSymbiosisNursingForDementiaSubtraction.setModel(getTypeSymbiosisNursingForDementiaSubtractionModel());

      typeSymbiosisNursingForDementiaSubtraction.setUseClearButton(false);

      addTypeSymbiosisNursingForDementiaSubtraction();
    }
    return typeSymbiosisNursingForDementiaSubtraction;

  }

  /**
   * �l�����Z�R���e�i���擾���܂��B
   * @return �l�����Z�R���e�i
   */
  protected ACLabelContainer getTypeSymbiosisNursingForDementiaSubtractionContainer(){
    if(typeSymbiosisNursingForDementiaSubtractionContainer==null){
      typeSymbiosisNursingForDementiaSubtractionContainer = new ACLabelContainer();
      typeSymbiosisNursingForDementiaSubtractionContainer.setFollowChildEnabled(true);
      typeSymbiosisNursingForDementiaSubtractionContainer.add(getTypeSymbiosisNursingForDementiaSubtraction(), null);
    }
    return typeSymbiosisNursingForDementiaSubtractionContainer;
  }

  /**
   * �l�����Z���f�����擾���܂��B
   * @return �l�����Z���f��
   */
  protected ACListModelAdapter getTypeSymbiosisNursingForDementiaSubtractionModel(){
    if(typeSymbiosisNursingForDementiaSubtractionModel==null){
      typeSymbiosisNursingForDementiaSubtractionModel = new ACListModelAdapter();
      addTypeSymbiosisNursingForDementiaSubtractionModel();
    }
    return typeSymbiosisNursingForDementiaSubtractionModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getTypeSymbiosisNursingForDementiaSubtractionCapacityNot(){
    if(typeSymbiosisNursingForDementiaSubtractionCapacityNot==null){

      typeSymbiosisNursingForDementiaSubtractionCapacityNot = new ACRadioButtonItem();

      typeSymbiosisNursingForDementiaSubtractionCapacityNot.setText("�Ȃ�");

      typeSymbiosisNursingForDementiaSubtractionCapacityNot.setGroup(getTypeSymbiosisNursingForDementiaSubtraction());

      typeSymbiosisNursingForDementiaSubtractionCapacityNot.setConstraints(VRLayout.FLOW);

      addTypeSymbiosisNursingForDementiaSubtractionCapacityNot();
    }
    return typeSymbiosisNursingForDementiaSubtractionCapacityNot;

  }

  /**
   * ������߂��擾���܂��B
   * @return �������
   */
  public ACRadioButtonItem getTypeSymbiosisNursingForDementiaSubtractionCapacityExcess(){
    if(typeSymbiosisNursingForDementiaSubtractionCapacityExcess==null){

      typeSymbiosisNursingForDementiaSubtractionCapacityExcess = new ACRadioButtonItem();

      typeSymbiosisNursingForDementiaSubtractionCapacityExcess.setText("�������");

      typeSymbiosisNursingForDementiaSubtractionCapacityExcess.setGroup(getTypeSymbiosisNursingForDementiaSubtraction());

      typeSymbiosisNursingForDementiaSubtractionCapacityExcess.setConstraints(VRLayout.FLOW_RETURN);

      addTypeSymbiosisNursingForDementiaSubtractionCapacityExcess();
    }
    return typeSymbiosisNursingForDementiaSubtractionCapacityExcess;

  }

  /**
   * �E���s�����擾���܂��B
   * @return �E���s��
   */
  public ACRadioButtonItem getTypeSymbiosisNursingForDementiaSubtractionPersonLack(){
    if(typeSymbiosisNursingForDementiaSubtractionPersonLack==null){

      typeSymbiosisNursingForDementiaSubtractionPersonLack = new ACRadioButtonItem();

      typeSymbiosisNursingForDementiaSubtractionPersonLack.setText("���]�ƈ��̕s��");

      typeSymbiosisNursingForDementiaSubtractionPersonLack.setGroup(getTypeSymbiosisNursingForDementiaSubtraction());

      typeSymbiosisNursingForDementiaSubtractionPersonLack.setConstraints(VRLayout.FLOW);

      addTypeSymbiosisNursingForDementiaSubtractionPersonLack();
    }
    return typeSymbiosisNursingForDementiaSubtractionPersonLack;

  }

  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001018Design() {

    try {
      initialize();

      initAffair(null);

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

    this.add(getTypeSymbiosisNursingForDementiaPatterns(), VRLayout.WEST);

  }

  /**
   * �s��Ή������������p�^�[���̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTypeSymbiosisNursingForDementiaPatterns(){

    typeSymbiosisNursingForDementiaPatterns.add(getTypeSymbiosisNursingForDementiaNightTimeCareRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    typeSymbiosisNursingForDementiaPatterns.add(getTypeSymbiosisNursingForDementiaDefaultRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    typeSymbiosisNursingForDementiaPatterns.add(getTypeSymbiosisNursingForDementiaSubtractionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * ��ԃP�A���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTypeSymbiosisNursingForDementiaNightTimeCareRadio(){

  }

  /**
   * ��ԃP�A���Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addTypeSymbiosisNursingForDementiaNightTimeCareRadioModel(){

    getTypeSymbiosisNursingForDementiaNightTimeCareRadioItem1().setButtonIndex(1);
    getTypeSymbiosisNursingForDementiaNightTimeCareRadioModel().add(getTypeSymbiosisNursingForDementiaNightTimeCareRadioItem1());

    getTypeSymbiosisNursingForDementiaNightTimeCareRadioItem2().setButtonIndex(2);
    getTypeSymbiosisNursingForDementiaNightTimeCareRadioModel().add(getTypeSymbiosisNursingForDementiaNightTimeCareRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addTypeSymbiosisNursingForDementiaNightTimeCareRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addTypeSymbiosisNursingForDementiaNightTimeCareRadioItem2(){

  }

  /**
   * �������Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTypeSymbiosisNursingForDementiaDefaultRadio(){

  }

  /**
   * �������Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addTypeSymbiosisNursingForDementiaDefaultRadioModel(){

    getTypeSymbiosisNursingForDementiaDefaultRadioItem1().setButtonIndex(1);
    getTypeSymbiosisNursingForDementiaDefaultRadioModel().add(getTypeSymbiosisNursingForDementiaDefaultRadioItem1());

    getTypeSymbiosisNursingForDementiaDefaultRadioItem2().setButtonIndex(2);
    getTypeSymbiosisNursingForDementiaDefaultRadioModel().add(getTypeSymbiosisNursingForDementiaDefaultRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addTypeSymbiosisNursingForDementiaDefaultRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addTypeSymbiosisNursingForDementiaDefaultRadioItem2(){

  }

  /**
   * �l�����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTypeSymbiosisNursingForDementiaSubtraction(){

  }

  /**
   * �l�����Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addTypeSymbiosisNursingForDementiaSubtractionModel(){

    getTypeSymbiosisNursingForDementiaSubtractionCapacityNot().setButtonIndex(1);
    getTypeSymbiosisNursingForDementiaSubtractionModel().add(getTypeSymbiosisNursingForDementiaSubtractionCapacityNot());

    getTypeSymbiosisNursingForDementiaSubtractionCapacityExcess().setButtonIndex(2);
    getTypeSymbiosisNursingForDementiaSubtractionModel().add(getTypeSymbiosisNursingForDementiaSubtractionCapacityExcess());

    getTypeSymbiosisNursingForDementiaSubtractionPersonLack().setButtonIndex(3);
    getTypeSymbiosisNursingForDementiaSubtractionModel().add(getTypeSymbiosisNursingForDementiaSubtractionPersonLack());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addTypeSymbiosisNursingForDementiaSubtractionCapacityNot(){

  }

  /**
   * ������߂ɓ������ڂ�ǉ����܂��B
   */
  protected void addTypeSymbiosisNursingForDementiaSubtractionCapacityExcess(){

  }

  /**
   * �E���s���ɓ������ڂ�ǉ����܂��B
   */
  protected void addTypeSymbiosisNursingForDementiaSubtractionPersonLack(){

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
      ACFrame.getInstance().getContentPane().add(new QS001018Design());
      ACFrame.getInstance().setVisible(true);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QS001018Design getThis() {
    return this;
  }
}
