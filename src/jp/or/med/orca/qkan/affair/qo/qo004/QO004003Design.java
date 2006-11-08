
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
 * �쐬��: 2006/02/18  ���{�R���s���[�^�[������� ���}�@�M�u �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���̑��@�\ (O)
 * �v���Z�X ���Ǝғo�^ (004)
 * �v���O���� �K��Ō� (QO004003)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qo.qo004;
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
 * �K��Ō��ʍ��ڃf�U�C��(QO004003) 
 */
public class QO004003Design extends ACPanel {
  //GUI�R���|�[�l���g

  private ACGroupBox homonkangoGroup;

  private ACLabelContainer homonkangoDiscountContainer;

  private ACTextField homonkangoDiscountRate;

  private ACLabel percentSign;

  private ACClearableRadioButtonGroup homonkangoFacilitiesDivision;

  private ACLabelContainer homonkangoFacilitiesDivisionContainer;

  private ACListModelAdapter homonkangoFacilitiesDivisionModel;

  private ACRadioButtonItem homonkangoStation;

  private ACRadioButtonItem hospitalOrClinic;

  private ACClearableRadioButtonGroup homonkangoPressingRadio;

  private ACLabelContainer homonkangoPressingRadioContainer;

  private ACListModelAdapter homonkangoPressingRadioModel;

  private ACRadioButtonItem homonkangoPressingRadioItem1;

  private ACRadioButtonItem homonkangoPressingRadioItem2;

  private ACClearableRadioButtonGroup specialManagementSystem;

  private ACLabelContainer specialManagementSystemContainer;

  private ACListModelAdapter specialManagementSystemModel;

  private ACRadioButtonItem specialManagementSystemOn;

  private ACRadioButtonItem specialManagementSystemOff;

  private ACTextField managerName;

  private ACLabelContainer managerNameContainer;

  private ACGroupBox medicalTreatmentInsurance;

  private ACTextField medicalTreatmentInsuranceStationCode;

  private ACLabelContainer medicalTreatmentInsuranceStationCodeContainer;

  //getter

  /**
   * ���ƃO���[�v���擾���܂��B
   * @return ���ƃO���[�v
   */
  public ACGroupBox getHomonkangoGroup(){
    if(homonkangoGroup==null){

      homonkangoGroup = new ACGroupBox();

      homonkangoGroup.setText("�K��Ō�");

      homonkangoGroup.setFollowChildEnabled(true);

      homonkangoGroup.setHgrid(500);

      addHomonkangoGroup();
    }
    return homonkangoGroup;

  }

  /**
   * �������R���e�i���擾���܂��B
   * @return �������R���e�i
   */
  public ACLabelContainer getHomonkangoDiscountContainer(){
    if(homonkangoDiscountContainer==null){

      homonkangoDiscountContainer = new ACLabelContainer();

      homonkangoDiscountContainer.setText("������");

      homonkangoDiscountContainer.setFollowChildEnabled(true);

      addHomonkangoDiscountContainer();
    }
    return homonkangoDiscountContainer;

  }

  /**
   * ���������擾���܂��B
   * @return ������
   */
  public ACTextField getHomonkangoDiscountRate(){
    if(homonkangoDiscountRate==null){

      homonkangoDiscountRate = new ACTextField();

      homonkangoDiscountRate.setBindPath("REDUCT_RATE");

      homonkangoDiscountRate.setColumns(3);

      homonkangoDiscountRate.setCharType(VRCharType.ONLY_DIGIT);

      homonkangoDiscountRate.setHorizontalAlignment(SwingConstants.RIGHT);

      homonkangoDiscountRate.setIMEMode(InputSubset.LATIN);

      homonkangoDiscountRate.setMaxLength(3);

      addHomonkangoDiscountRate();
    }
    return homonkangoDiscountRate;

  }

  /**
   * %���x�����擾���܂��B
   * @return %���x��
   */
  public ACLabel getPercentSign(){
    if(percentSign==null){

      percentSign = new ACLabel();

      percentSign.setText("��");

      addPercentSign();
    }
    return percentSign;

  }

  /**
   * �{�݋敪���W�I�O���[�v���擾���܂��B
   * @return �{�݋敪���W�I�O���[�v
   */
  public ACClearableRadioButtonGroup getHomonkangoFacilitiesDivision(){
    if(homonkangoFacilitiesDivision==null){

      homonkangoFacilitiesDivision = new ACClearableRadioButtonGroup();

      getHomonkangoFacilitiesDivisionContainer().setText("�{�݋敪");

      homonkangoFacilitiesDivision.setBindPath("1130101");

      homonkangoFacilitiesDivision.setModel(getHomonkangoFacilitiesDivisionModel());

      homonkangoFacilitiesDivision.setUseClearButton(false);

      addHomonkangoFacilitiesDivision();
    }
    return homonkangoFacilitiesDivision;

  }

  /**
   * �{�݋敪���W�I�O���[�v�R���e�i���擾���܂��B
   * @return �{�݋敪���W�I�O���[�v�R���e�i
   */
  protected ACLabelContainer getHomonkangoFacilitiesDivisionContainer(){
    if(homonkangoFacilitiesDivisionContainer==null){
      homonkangoFacilitiesDivisionContainer = new ACLabelContainer();
      homonkangoFacilitiesDivisionContainer.setFollowChildEnabled(true);
      homonkangoFacilitiesDivisionContainer.add(getHomonkangoFacilitiesDivision(), null);
    }
    return homonkangoFacilitiesDivisionContainer;
  }

  /**
   * �{�݋敪���W�I�O���[�v���f�����擾���܂��B
   * @return �{�݋敪���W�I�O���[�v���f��
   */
  protected ACListModelAdapter getHomonkangoFacilitiesDivisionModel(){
    if(homonkangoFacilitiesDivisionModel==null){
      homonkangoFacilitiesDivisionModel = new ACListModelAdapter();
      addHomonkangoFacilitiesDivisionModel();
    }
    return homonkangoFacilitiesDivisionModel;
  }

  /**
   * �K��Ō�X�e�[�V�������擾���܂��B
   * @return �K��Ō�X�e�[�V����
   */
  public ACRadioButtonItem getHomonkangoStation(){
    if(homonkangoStation==null){

      homonkangoStation = new ACRadioButtonItem();

      homonkangoStation.setText("�K��Ō�X�e�[�V����");

      homonkangoStation.setGroup(getHomonkangoFacilitiesDivision());

      addHomonkangoStation();
    }
    return homonkangoStation;

  }

  /**
   * �a�@�܂��͐f�Ï����擾���܂��B
   * @return �a�@�܂��͐f�Ï�
   */
  public ACRadioButtonItem getHospitalOrClinic(){
    if(hospitalOrClinic==null){

      hospitalOrClinic = new ACRadioButtonItem();

      hospitalOrClinic.setText("�a�@���͐f�Ï�");

      hospitalOrClinic.setGroup(getHomonkangoFacilitiesDivision());

      addHospitalOrClinic();
    }
    return hospitalOrClinic;

  }

  /**
   * �ً}���K��Ō���Z�̐����擾���܂��B
   * @return �ً}���K��Ō���Z�̐�
   */
  public ACClearableRadioButtonGroup getHomonkangoPressingRadio(){
    if(homonkangoPressingRadio==null){

      homonkangoPressingRadio = new ACClearableRadioButtonGroup();

      getHomonkangoPressingRadioContainer().setText("�ً}���K��Ō���Z�̐�");

      homonkangoPressingRadio.setBindPath("1130104");

      homonkangoPressingRadio.setModel(getHomonkangoPressingRadioModel());

      homonkangoPressingRadio.setUseClearButton(false);

      addHomonkangoPressingRadio();
    }
    return homonkangoPressingRadio;

  }

  /**
   * �ً}���K��Ō���Z�̐��R���e�i���擾���܂��B
   * @return �ً}���K��Ō���Z�̐��R���e�i
   */
  protected ACLabelContainer getHomonkangoPressingRadioContainer(){
    if(homonkangoPressingRadioContainer==null){
      homonkangoPressingRadioContainer = new ACLabelContainer();
      homonkangoPressingRadioContainer.setFollowChildEnabled(true);
      homonkangoPressingRadioContainer.add(getHomonkangoPressingRadio(), null);
    }
    return homonkangoPressingRadioContainer;
  }

  /**
   * �ً}���K��Ō���Z�̐����f�����擾���܂��B
   * @return �ً}���K��Ō���Z�̐����f��
   */
  protected ACListModelAdapter getHomonkangoPressingRadioModel(){
    if(homonkangoPressingRadioModel==null){
      homonkangoPressingRadioModel = new ACListModelAdapter();
      addHomonkangoPressingRadioModel();
    }
    return homonkangoPressingRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getHomonkangoPressingRadioItem1(){
    if(homonkangoPressingRadioItem1==null){

      homonkangoPressingRadioItem1 = new ACRadioButtonItem();

      homonkangoPressingRadioItem1.setText("�Ȃ�");

      homonkangoPressingRadioItem1.setGroup(getHomonkangoPressingRadio());

      addHomonkangoPressingRadioItem1();
    }
    return homonkangoPressingRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getHomonkangoPressingRadioItem2(){
    if(homonkangoPressingRadioItem2==null){

      homonkangoPressingRadioItem2 = new ACRadioButtonItem();

      homonkangoPressingRadioItem2.setText("����");

      homonkangoPressingRadioItem2.setGroup(getHomonkangoPressingRadio());

      addHomonkangoPressingRadioItem2();
    }
    return homonkangoPressingRadioItem2;

  }

  /**
   * ���ʊǗ��̐����W�I�O���[�v���擾���܂��B
   * @return ���ʊǗ��̐����W�I�O���[�v
   */
  public ACClearableRadioButtonGroup getSpecialManagementSystem(){
    if(specialManagementSystem==null){

      specialManagementSystem = new ACClearableRadioButtonGroup();

      getSpecialManagementSystemContainer().setText("���ʊǗ��̐�");

      specialManagementSystem.setBindPath("1130102");

      specialManagementSystem.setModel(getSpecialManagementSystemModel());

      specialManagementSystem.setUseClearButton(false);

      addSpecialManagementSystem();
    }
    return specialManagementSystem;

  }

  /**
   * ���ʊǗ��̐����W�I�O���[�v�R���e�i���擾���܂��B
   * @return ���ʊǗ��̐����W�I�O���[�v�R���e�i
   */
  protected ACLabelContainer getSpecialManagementSystemContainer(){
    if(specialManagementSystemContainer==null){
      specialManagementSystemContainer = new ACLabelContainer();
      specialManagementSystemContainer.setFollowChildEnabled(true);
      specialManagementSystemContainer.add(getSpecialManagementSystem(), null);
    }
    return specialManagementSystemContainer;
  }

  /**
   * ���ʊǗ��̐����W�I�O���[�v���f�����擾���܂��B
   * @return ���ʊǗ��̐����W�I�O���[�v���f��
   */
  protected ACListModelAdapter getSpecialManagementSystemModel(){
    if(specialManagementSystemModel==null){
      specialManagementSystemModel = new ACListModelAdapter();
      addSpecialManagementSystemModel();
    }
    return specialManagementSystemModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getSpecialManagementSystemOn(){
    if(specialManagementSystemOn==null){

      specialManagementSystemOn = new ACRadioButtonItem();

      specialManagementSystemOn.setText("�Ȃ�");

      specialManagementSystemOn.setGroup(getSpecialManagementSystem());

      addSpecialManagementSystemOn();
    }
    return specialManagementSystemOn;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getSpecialManagementSystemOff(){
    if(specialManagementSystemOff==null){

      specialManagementSystemOff = new ACRadioButtonItem();

      specialManagementSystemOff.setText("����");

      specialManagementSystemOff.setGroup(getSpecialManagementSystem());

      addSpecialManagementSystemOff();
    }
    return specialManagementSystemOff;

  }

  /**
   * �Ǘ��Ҏ������擾���܂��B
   * @return �Ǘ��Ҏ���
   */
  public ACTextField getManagerName(){
    if(managerName==null){

      managerName = new ACTextField();

      getManagerNameContainer().setText("�Ǘ��Ҏ���");

      managerName.setBindPath("1130103");

      managerName.setColumns(11);

      managerName.setIMEMode(InputSubset.KANJI);

      managerName.setMaxLength(10);

      addManagerName();
    }
    return managerName;

  }

  /**
   * �Ǘ��Ҏ����R���e�i���擾���܂��B
   * @return �Ǘ��Ҏ����R���e�i
   */
  protected ACLabelContainer getManagerNameContainer(){
    if(managerNameContainer==null){
      managerNameContainer = new ACLabelContainer();
      managerNameContainer.setFollowChildEnabled(true);
      managerNameContainer.add(getManagerName(), null);
    }
    return managerNameContainer;
  }

  /**
   * ������Õی����������擾���܂��B
   * @return ������Õی�������
   */
  public ACGroupBox getMedicalTreatmentInsurance(){
    if(medicalTreatmentInsurance==null){

      medicalTreatmentInsurance = new ACGroupBox();

      medicalTreatmentInsurance.setText("��Õی���");

      medicalTreatmentInsurance.setFollowChildEnabled(true);

      addMedicalTreatmentInsurance();
    }
    return medicalTreatmentInsurance;

  }

  /**
   * �X�e�[�V�����R�[�h���擾���܂��B
   * @return �X�e�[�V�����R�[�h
   */
  public ACTextField getMedicalTreatmentInsuranceStationCode(){
    if(medicalTreatmentInsuranceStationCode==null){

      medicalTreatmentInsuranceStationCode = new ACTextField();

      getMedicalTreatmentInsuranceStationCodeContainer().setText("�X�e�[�V�����R�[�h");

      medicalTreatmentInsuranceStationCode.setBindPath("2010101");

      medicalTreatmentInsuranceStationCode.setCharType(VRCharType.ONLY_DIGIT);

      medicalTreatmentInsuranceStationCode.setColumns(5);

      medicalTreatmentInsuranceStationCode.setIMEMode(InputSubset.LATIN);

      medicalTreatmentInsuranceStationCode.setMaxLength(7);

      addMedicalTreatmentInsuranceStationCode();
    }
    return medicalTreatmentInsuranceStationCode;

  }

  /**
   * �X�e�[�V�����R�[�h�R���e�i���擾���܂��B
   * @return �X�e�[�V�����R�[�h�R���e�i
   */
  protected ACLabelContainer getMedicalTreatmentInsuranceStationCodeContainer(){
    if(medicalTreatmentInsuranceStationCodeContainer==null){
      medicalTreatmentInsuranceStationCodeContainer = new ACLabelContainer();
      medicalTreatmentInsuranceStationCodeContainer.setFollowChildEnabled(true);
      medicalTreatmentInsuranceStationCodeContainer.add(getMedicalTreatmentInsuranceStationCode(), null);
    }
    return medicalTreatmentInsuranceStationCodeContainer;
  }

  /**
   * �R���X�g���N�^�ł��B
   */
  public QO004003Design() {

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

    this.add(getHomonkangoGroup(), VRLayout.CLIENT);

  }

  /**
   * ���ƃO���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHomonkangoGroup(){

    homonkangoGroup.add(getHomonkangoDiscountContainer(), VRLayout.FLOW_RETURN);

    homonkangoGroup.add(getHomonkangoFacilitiesDivisionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    homonkangoGroup.add(getHomonkangoPressingRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    homonkangoGroup.add(getSpecialManagementSystemContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    homonkangoGroup.add(getManagerNameContainer(), VRLayout.FLOW_RETURN);

    homonkangoGroup.add(getMedicalTreatmentInsurance(), VRLayout.FLOW_RETURN);

  }

  /**
   * �������R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHomonkangoDiscountContainer(){

    homonkangoDiscountContainer.add(getHomonkangoDiscountRate(), VRLayout.FLOW);

    homonkangoDiscountContainer.add(getPercentSign(), VRLayout.FLOW);

  }

  /**
   * �������ɓ������ڂ�ǉ����܂��B
   */
  protected void addHomonkangoDiscountRate(){

  }

  /**
   * %���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addPercentSign(){

  }

  /**
   * �{�݋敪���W�I�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHomonkangoFacilitiesDivision(){

  }

  /**
   * �{�݋敪���W�I�O���[�v���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addHomonkangoFacilitiesDivisionModel(){

    getHomonkangoStation().setButtonIndex(1);
    getHomonkangoFacilitiesDivisionModel().add(getHomonkangoStation());

    getHospitalOrClinic().setButtonIndex(2);
    getHomonkangoFacilitiesDivisionModel().add(getHospitalOrClinic());

  }

  /**
   * �K��Ō�X�e�[�V�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addHomonkangoStation(){

  }

  /**
   * �a�@�܂��͐f�Ï��ɓ������ڂ�ǉ����܂��B
   */
  protected void addHospitalOrClinic(){

  }

  /**
   * �ً}���K��Ō���Z�̐��ɓ������ڂ�ǉ����܂��B
   */
  protected void addHomonkangoPressingRadio(){

  }

  /**
   * �ً}���K��Ō���Z�̐����f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addHomonkangoPressingRadioModel(){

    getHomonkangoPressingRadioItem1().setButtonIndex(1);
    getHomonkangoPressingRadioModel().add(getHomonkangoPressingRadioItem1());

    getHomonkangoPressingRadioItem2().setButtonIndex(2);
    getHomonkangoPressingRadioModel().add(getHomonkangoPressingRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addHomonkangoPressingRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addHomonkangoPressingRadioItem2(){

  }

  /**
   * ���ʊǗ��̐����W�I�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addSpecialManagementSystem(){

  }

  /**
   * ���ʊǗ��̐����W�I�O���[�v���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addSpecialManagementSystemModel(){

    getSpecialManagementSystemOn().setButtonIndex(1);
    getSpecialManagementSystemModel().add(getSpecialManagementSystemOn());

    getSpecialManagementSystemOff().setButtonIndex(2);
    getSpecialManagementSystemModel().add(getSpecialManagementSystemOff());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addSpecialManagementSystemOn(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addSpecialManagementSystemOff(){

  }

  /**
   * �Ǘ��Ҏ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addManagerName(){

  }

  /**
   * ������Õی��������ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalTreatmentInsurance(){

    medicalTreatmentInsurance.add(getMedicalTreatmentInsuranceStationCodeContainer(), VRLayout.FLOW_INSETLINE);

  }

  /**
   * �X�e�[�V�����R�[�h�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalTreatmentInsuranceStationCode(){

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
      ACFrame.getInstance().getContentPane().add(new QO004003Design());
      ACFrame.getInstance().setVisible(true);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QO004003Design getThis() {
    return this;
  }
}
