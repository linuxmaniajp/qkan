
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
 * �쐬��: 2006/05/04  ���{�R���s���[�^�[������� ���{�@�K�� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �T�[�r�X�\��쐬/�ύX (S)
 * �v���Z�X �T�[�r�X�\��T�� (001)
 * �v���O���� �T�[�r�X�p�^�[���F�m�ǑΉ������������i�Z�����p�j (QS001127)
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
 * �T�[�r�X�p�^�[���F�m�ǑΉ������������i�Z�����p�j��ʍ��ڃf�U�C��(QS001127) 
 */
public class QS001127Design extends QS001ServicePanel {
  //GUI�R���|�[�l���g

  private ACPanel typeSymbiosisNursingForDementiaPatterns;

  private ACClearableRadioButtonGroup typeSymbiosisNursingForDementiaSubtraction;

  private ACLabelContainer typeSymbiosisNursingForDementiaSubtractionContainer;

  private ACListModelAdapter typeSymbiosisNursingForDementiaSubtractionModel;

  private ACRadioButtonItem typeSymbiosisNursingForDementiaSubtractionCapacityNot;

  private ACRadioButtonItem typeSymbiosisNursingForDementiaSubtractionCapacityExcess;

  private ACRadioButtonItem typeSymbiosisNursingForDementiaSubtractionPersonLack;

  private ACClearableRadioButtonGroup nightWorkConditionStandardRadio;

  private ACLabelContainer nightWorkConditionStandardRadioContainer;

  private ACListModelAdapter nightWorkConditionStandardRadioModel;

  private ACRadioButtonItem nightWorkConditionStandardRadioItem1;

  private ACRadioButtonItem nightWorkConditionStandardRadioItem2;

  private ACClearableRadioButtonGroup medicalCooperationSystemAddRadio;

  private ACLabelContainer medicalCooperationSystemAddRadioContainer;

  private ACListModelAdapter medicalCooperationSystemAddRadioModel;

  private ACRadioButtonItem medicalCooperationSystemAddRadioItem1;

  private ACRadioButtonItem medicalCooperationSystemAddRadioItem2;

  private ACIntegerCheckBox shortStayLifeAddition30Orver;

  private ACLabel information;

  //getter

  /**
   * �F�m�ǑΉ������������i�Z�����p�j�p�^�[���̈���擾���܂��B
   * @return �F�m�ǑΉ������������i�Z�����p�j�p�^�[���̈�
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
   * �l�����Z���擾���܂��B
   * @return �l�����Z
   */
  public ACClearableRadioButtonGroup getTypeSymbiosisNursingForDementiaSubtraction(){
    if(typeSymbiosisNursingForDementiaSubtraction==null){

      typeSymbiosisNursingForDementiaSubtraction = new ACClearableRadioButtonGroup();

      getTypeSymbiosisNursingForDementiaSubtractionContainer().setText("�l�����Z");

      typeSymbiosisNursingForDementiaSubtraction.setBindPath("1380101");

      typeSymbiosisNursingForDementiaSubtraction.setUseClearButton(false);

      typeSymbiosisNursingForDementiaSubtraction.setModel(getTypeSymbiosisNursingForDementiaSubtractionModel());

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
      typeSymbiosisNursingForDementiaSubtractionContainer.setVAlignment(VRLayout.CENTER);
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
   * ��ԋΖ���������擾���܂��B
   * @return ��ԋΖ������
   */
  public ACClearableRadioButtonGroup getNightWorkConditionStandardRadio(){
    if(nightWorkConditionStandardRadio==null){

      nightWorkConditionStandardRadio = new ACClearableRadioButtonGroup();

      getNightWorkConditionStandardRadioContainer().setText("��ԋΖ������");

      nightWorkConditionStandardRadio.setBindPath("1380102");

      nightWorkConditionStandardRadio.setUseClearButton(false);

      nightWorkConditionStandardRadio.setModel(getNightWorkConditionStandardRadioModel());

      addNightWorkConditionStandardRadio();
    }
    return nightWorkConditionStandardRadio;

  }

  /**
   * ��ԋΖ�������R���e�i���擾���܂��B
   * @return ��ԋΖ�������R���e�i
   */
  protected ACLabelContainer getNightWorkConditionStandardRadioContainer(){
    if(nightWorkConditionStandardRadioContainer==null){
      nightWorkConditionStandardRadioContainer = new ACLabelContainer();
      nightWorkConditionStandardRadioContainer.setFollowChildEnabled(true);
      nightWorkConditionStandardRadioContainer.setVAlignment(VRLayout.CENTER);
      nightWorkConditionStandardRadioContainer.add(getNightWorkConditionStandardRadio(), null);
    }
    return nightWorkConditionStandardRadioContainer;
  }

  /**
   * ��ԋΖ���������f�����擾���܂��B
   * @return ��ԋΖ���������f��
   */
  protected ACListModelAdapter getNightWorkConditionStandardRadioModel(){
    if(nightWorkConditionStandardRadioModel==null){
      nightWorkConditionStandardRadioModel = new ACListModelAdapter();
      addNightWorkConditionStandardRadioModel();
    }
    return nightWorkConditionStandardRadioModel;
  }

  /**
   * �������Ă�����擾���܂��B
   * @return �������Ă���
   */
  public ACRadioButtonItem getNightWorkConditionStandardRadioItem1(){
    if(nightWorkConditionStandardRadioItem1==null){

      nightWorkConditionStandardRadioItem1 = new ACRadioButtonItem();

      nightWorkConditionStandardRadioItem1.setText("�������Ă���");

      nightWorkConditionStandardRadioItem1.setGroup(getNightWorkConditionStandardRadio());

      nightWorkConditionStandardRadioItem1.setConstraints(VRLayout.FLOW_RETURN);

      addNightWorkConditionStandardRadioItem1();
    }
    return nightWorkConditionStandardRadioItem1;

  }

  /**
   * �������Ă��Ȃ����擾���܂��B
   * @return �������Ă��Ȃ�
   */
  public ACRadioButtonItem getNightWorkConditionStandardRadioItem2(){
    if(nightWorkConditionStandardRadioItem2==null){

      nightWorkConditionStandardRadioItem2 = new ACRadioButtonItem();

      nightWorkConditionStandardRadioItem2.setText("�������Ă��Ȃ�");

      nightWorkConditionStandardRadioItem2.setGroup(getNightWorkConditionStandardRadio());

      nightWorkConditionStandardRadioItem2.setConstraints(VRLayout.FLOW);

      addNightWorkConditionStandardRadioItem2();
    }
    return nightWorkConditionStandardRadioItem2;

  }

  /**
   * ��ØA�g�̐����Z���擾���܂��B
   * @return ��ØA�g�̐����Z
   */
  public ACClearableRadioButtonGroup getMedicalCooperationSystemAddRadio(){
    if(medicalCooperationSystemAddRadio==null){

      medicalCooperationSystemAddRadio = new ACClearableRadioButtonGroup();

      getMedicalCooperationSystemAddRadioContainer().setText("��ØA�g�̐����Z");

      medicalCooperationSystemAddRadio.setBindPath("1380103");

      medicalCooperationSystemAddRadio.setUseClearButton(false);

      medicalCooperationSystemAddRadio.setModel(getMedicalCooperationSystemAddRadioModel());

      addMedicalCooperationSystemAddRadio();
    }
    return medicalCooperationSystemAddRadio;

  }

  /**
   * ��ØA�g�̐����Z�R���e�i���擾���܂��B
   * @return ��ØA�g�̐����Z�R���e�i
   */
  protected ACLabelContainer getMedicalCooperationSystemAddRadioContainer(){
    if(medicalCooperationSystemAddRadioContainer==null){
      medicalCooperationSystemAddRadioContainer = new ACLabelContainer();
      medicalCooperationSystemAddRadioContainer.setFollowChildEnabled(true);
      medicalCooperationSystemAddRadioContainer.setVAlignment(VRLayout.CENTER);
      medicalCooperationSystemAddRadioContainer.add(getMedicalCooperationSystemAddRadio(), null);
    }
    return medicalCooperationSystemAddRadioContainer;
  }

  /**
   * ��ØA�g�̐����Z���f�����擾���܂��B
   * @return ��ØA�g�̐����Z���f��
   */
  protected ACListModelAdapter getMedicalCooperationSystemAddRadioModel(){
    if(medicalCooperationSystemAddRadioModel==null){
      medicalCooperationSystemAddRadioModel = new ACListModelAdapter();
      addMedicalCooperationSystemAddRadioModel();
    }
    return medicalCooperationSystemAddRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getMedicalCooperationSystemAddRadioItem1(){
    if(medicalCooperationSystemAddRadioItem1==null){

      medicalCooperationSystemAddRadioItem1 = new ACRadioButtonItem();

      medicalCooperationSystemAddRadioItem1.setText("�Ȃ�");

      medicalCooperationSystemAddRadioItem1.setGroup(getMedicalCooperationSystemAddRadio());

      medicalCooperationSystemAddRadioItem1.setConstraints(VRLayout.FLOW);

      addMedicalCooperationSystemAddRadioItem1();
    }
    return medicalCooperationSystemAddRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getMedicalCooperationSystemAddRadioItem2(){
    if(medicalCooperationSystemAddRadioItem2==null){

      medicalCooperationSystemAddRadioItem2 = new ACRadioButtonItem();

      medicalCooperationSystemAddRadioItem2.setText("����");

      medicalCooperationSystemAddRadioItem2.setGroup(getMedicalCooperationSystemAddRadio());

      medicalCooperationSystemAddRadioItem2.setConstraints(VRLayout.FLOW);

      addMedicalCooperationSystemAddRadioItem2();
    }
    return medicalCooperationSystemAddRadioItem2;

  }

  /**
   * 30�������擾���܂��B
   * @return 30����
   */
  public ACIntegerCheckBox getShortStayLifeAddition30Orver(){
    if(shortStayLifeAddition30Orver==null){

      shortStayLifeAddition30Orver = new ACIntegerCheckBox();

      shortStayLifeAddition30Orver.setText("30����");

      shortStayLifeAddition30Orver.setBindPath("5");

      shortStayLifeAddition30Orver.setSelectValue(2);

      shortStayLifeAddition30Orver.setUnSelectValue(1);

      addShortStayLifeAddition30Orver();
    }
    return shortStayLifeAddition30Orver;

  }

  /**
   * �⑫�����擾���܂��B
   * @return �⑫��
   */
  public ACLabel getInformation(){
    if(information==null){

      information = new ACLabel();

      information.setText("���ԕ\�ւ̐ݒ��1��������30���܂łƂ��Ă��������B");

      information.setVisible(false);

      information.setColumns(27);

      information.setForeground(Color.blue);

      information.setAutoWrap(true);

      addInformation();
    }
    return information;

  }

  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001127Design() {

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

    this.add(getTypeSymbiosisNursingForDementiaPatterns(), VRLayout.CLIENT);

  }

  /**
   * �F�m�ǑΉ������������i�Z�����p�j�p�^�[���̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTypeSymbiosisNursingForDementiaPatterns(){

    typeSymbiosisNursingForDementiaPatterns.add(getTypeSymbiosisNursingForDementiaSubtractionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    typeSymbiosisNursingForDementiaPatterns.add(getNightWorkConditionStandardRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    typeSymbiosisNursingForDementiaPatterns.add(getMedicalCooperationSystemAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    typeSymbiosisNursingForDementiaPatterns.add(getShortStayLifeAddition30Orver(), VRLayout.FLOW_INSETLINE_RETURN);

    typeSymbiosisNursingForDementiaPatterns.add(getInformation(), VRLayout.SOUTH);
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
   * ��ԋΖ�������ɓ������ڂ�ǉ����܂��B
   */
  protected void addNightWorkConditionStandardRadio(){

  }

  /**
   * ��ԋΖ���������f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addNightWorkConditionStandardRadioModel(){

    getNightWorkConditionStandardRadioItem1().setButtonIndex(1);
    getNightWorkConditionStandardRadioModel().add(getNightWorkConditionStandardRadioItem1());

    getNightWorkConditionStandardRadioItem2().setButtonIndex(2);
    getNightWorkConditionStandardRadioModel().add(getNightWorkConditionStandardRadioItem2());

  }

  /**
   * �������Ă���ɓ������ڂ�ǉ����܂��B
   */
  protected void addNightWorkConditionStandardRadioItem1(){

  }

  /**
   * �������Ă��Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addNightWorkConditionStandardRadioItem2(){

  }

  /**
   * ��ØA�g�̐����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalCooperationSystemAddRadio(){

  }

  /**
   * ��ØA�g�̐����Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalCooperationSystemAddRadioModel(){

    getMedicalCooperationSystemAddRadioItem1().setButtonIndex(1);
    getMedicalCooperationSystemAddRadioModel().add(getMedicalCooperationSystemAddRadioItem1());

    getMedicalCooperationSystemAddRadioItem2().setButtonIndex(2);
    getMedicalCooperationSystemAddRadioModel().add(getMedicalCooperationSystemAddRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalCooperationSystemAddRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalCooperationSystemAddRadioItem2(){

  }

  /**
   * 30�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayLifeAddition30Orver(){

  }

  /**
   * �⑫���ɓ������ڂ�ǉ����܂��B
   */
  protected void addInformation(){

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
      ACFrame.debugStart(new ACAffairInfo(QS001127Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QS001127Design getThis() {
    return this;
  }
}
