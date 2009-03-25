
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
 * �J����: �c���@����
 * �쐬��: 2009/03/02  ���{�R���s���[�^�[������� �c���@���� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �T�[�r�X�\��쐬/�ύX (S)
 * �v���Z�X �T�[�r�X�\��T�� (001)
 * �v���O���� �T�[�r�X�p�^�[������{�ݓ����Ґ������ (QS001128_H2104)
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
 * �T�[�r�X�p�^�[���n�斧���^����{�ݓ����Ґ�������ʍ��ڃf�U�C��(QS001128_H2104) 
 */
public class QS001128_H2104Design extends QS001ServicePanel {
  //GUI�R���|�[�l���g

  private ACPanel regionSpecificFacilityPatterns;

  private ACClearableRadioButtonGroup regionStaffSubtractionRadio;

  private ACLabelContainer regionStaffSubtractionRadioContainer;

  private ACListModelAdapter regionStaffSubtractionRadioModel;

  private ACRadioButtonItem regionSubtractionNo;

  private ACRadioButtonItem regionSubtractionPersonLack;

  private ACClearableRadioButtonGroup regionTrainingRadio;

  private ACLabelContainer regionTrainingRadioContainer;

  private ACListModelAdapter regionTrainingRadioModel;

  private ACRadioButtonItem regionTrainingRadioItem1;

  private ACRadioButtonItem regionTrainingRadioItem2;

  private ACClearableRadioButtonGroup regionNightStandardRadio;

  private ACLabelContainer regionNightStandardRadioContainer;

  private ACListModelAdapter regionNightStandardRadioModel;

  private ACRadioButtonItem regionNightStandardRadioItem1;

  private ACRadioButtonItem regionNightStandardRadioItem2;

  private ACClearableRadioButtonGroup medicalCoordinateAddRadioGroup;

  private ACLabelContainer medicalCoordinateAddRadioGroupContainer;

  private ACListModelAdapter medicalCoordinateAddRadioGroupModel;

  private ACRadioButtonItem medicalCoordinateAddRadioItem1;

  private ACRadioButtonItem medicalCoordinateAddRadioItem2;

  //getter

  /**
   * �n�斧������{�ݓ����Ґ������p�^�[���̈���擾���܂��B
   * @return �n�斧������{�ݓ����Ґ������p�^�[���̈�
   */
  public ACPanel getRegionSpecificFacilityPatterns(){
    if(regionSpecificFacilityPatterns==null){

      regionSpecificFacilityPatterns = new ACPanel();

      regionSpecificFacilityPatterns.setAutoWrap(false);

      regionSpecificFacilityPatterns.setHgrid(200);

      addRegionSpecificFacilityPatterns();
    }
    return regionSpecificFacilityPatterns;

  }

  /**
   * �l�����Z���擾���܂��B
   * @return �l�����Z
   */
  public ACClearableRadioButtonGroup getRegionStaffSubtractionRadio(){
    if(regionStaffSubtractionRadio==null){

      regionStaffSubtractionRadio = new ACClearableRadioButtonGroup();

      getRegionStaffSubtractionRadioContainer().setText("�l�����Z");

      regionStaffSubtractionRadio.setBindPath("1360101");

      regionStaffSubtractionRadio.setUseClearButton(false);

      regionStaffSubtractionRadio.setModel(getRegionStaffSubtractionRadioModel());

      addRegionStaffSubtractionRadio();
    }
    return regionStaffSubtractionRadio;

  }

  /**
   * �l�����Z�R���e�i���擾���܂��B
   * @return �l�����Z�R���e�i
   */
  protected ACLabelContainer getRegionStaffSubtractionRadioContainer(){
    if(regionStaffSubtractionRadioContainer==null){
      regionStaffSubtractionRadioContainer = new ACLabelContainer();
      regionStaffSubtractionRadioContainer.setFollowChildEnabled(true);
      regionStaffSubtractionRadioContainer.setVAlignment(VRLayout.CENTER);
      regionStaffSubtractionRadioContainer.add(getRegionStaffSubtractionRadio(), null);
    }
    return regionStaffSubtractionRadioContainer;
  }

  /**
   * �l�����Z���f�����擾���܂��B
   * @return �l�����Z���f��
   */
  protected ACListModelAdapter getRegionStaffSubtractionRadioModel(){
    if(regionStaffSubtractionRadioModel==null){
      regionStaffSubtractionRadioModel = new ACListModelAdapter();
      addRegionStaffSubtractionRadioModel();
    }
    return regionStaffSubtractionRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getRegionSubtractionNo(){
    if(regionSubtractionNo==null){

      regionSubtractionNo = new ACRadioButtonItem();

      regionSubtractionNo.setText("�Ȃ�");

      regionSubtractionNo.setGroup(getRegionStaffSubtractionRadio());

      regionSubtractionNo.setConstraints(VRLayout.FLOW);

      addRegionSubtractionNo();
    }
    return regionSubtractionNo;

  }

  /**
   * �Ō�E���E���̕s�����擾���܂��B
   * @return �Ō�E���E���̕s��
   */
  public ACRadioButtonItem getRegionSubtractionPersonLack(){
    if(regionSubtractionPersonLack==null){

      regionSubtractionPersonLack = new ACRadioButtonItem();

      regionSubtractionPersonLack.setText("�Ō�E���E���̕s��");

      regionSubtractionPersonLack.setGroup(getRegionStaffSubtractionRadio());

      regionSubtractionPersonLack.setConstraints(VRLayout.FLOW);

      addRegionSubtractionPersonLack();
    }
    return regionSubtractionPersonLack;

  }

  /**
   * �ʋ@�\�P���w���̐����Z���擾���܂��B
   * @return �ʋ@�\�P���w���̐����Z
   */
  public ACClearableRadioButtonGroup getRegionTrainingRadio(){
    if(regionTrainingRadio==null){

      regionTrainingRadio = new ACClearableRadioButtonGroup();

      getRegionTrainingRadioContainer().setText("�ʋ@�\�P���w�����Z");

      regionTrainingRadio.setBindPath("1360102");

      regionTrainingRadio.setUseClearButton(false);

      regionTrainingRadio.setModel(getRegionTrainingRadioModel());

      addRegionTrainingRadio();
    }
    return regionTrainingRadio;

  }

  /**
   * �ʋ@�\�P���w���̐����Z�R���e�i���擾���܂��B
   * @return �ʋ@�\�P���w���̐����Z�R���e�i
   */
  protected ACLabelContainer getRegionTrainingRadioContainer(){
    if(regionTrainingRadioContainer==null){
      regionTrainingRadioContainer = new ACLabelContainer();
      regionTrainingRadioContainer.setFollowChildEnabled(true);
      regionTrainingRadioContainer.setVAlignment(VRLayout.CENTER);
      regionTrainingRadioContainer.add(getRegionTrainingRadio(), null);
    }
    return regionTrainingRadioContainer;
  }

  /**
   * �ʋ@�\�P���w���̐����Z���f�����擾���܂��B
   * @return �ʋ@�\�P���w���̐����Z���f��
   */
  protected ACListModelAdapter getRegionTrainingRadioModel(){
    if(regionTrainingRadioModel==null){
      regionTrainingRadioModel = new ACListModelAdapter();
      addRegionTrainingRadioModel();
    }
    return regionTrainingRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getRegionTrainingRadioItem1(){
    if(regionTrainingRadioItem1==null){

      regionTrainingRadioItem1 = new ACRadioButtonItem();

      regionTrainingRadioItem1.setText("�Ȃ�");

      regionTrainingRadioItem1.setGroup(getRegionTrainingRadio());

      regionTrainingRadioItem1.setConstraints(VRLayout.FLOW);

      addRegionTrainingRadioItem1();
    }
    return regionTrainingRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getRegionTrainingRadioItem2(){
    if(regionTrainingRadioItem2==null){

      regionTrainingRadioItem2 = new ACRadioButtonItem();

      regionTrainingRadioItem2.setText("����");

      regionTrainingRadioItem2.setGroup(getRegionTrainingRadio());

      regionTrainingRadioItem2.setConstraints(VRLayout.FLOW);

      addRegionTrainingRadioItem2();
    }
    return regionTrainingRadioItem2;

  }

  /**
   * ��ԊŌ�̐����Z���擾���܂��B
   * @return ��ԊŌ�̐����Z
   */
  public ACClearableRadioButtonGroup getRegionNightStandardRadio(){
    if(regionNightStandardRadio==null){

      regionNightStandardRadio = new ACClearableRadioButtonGroup();

      getRegionNightStandardRadioContainer().setText("��ԊŌ�̐�");

      regionNightStandardRadio.setBindPath("1360103");

      regionNightStandardRadio.setUseClearButton(false);

      regionNightStandardRadio.setModel(getRegionNightStandardRadioModel());

      addRegionNightStandardRadio();
    }
    return regionNightStandardRadio;

  }

  /**
   * ��ԊŌ�̐����Z�R���e�i���擾���܂��B
   * @return ��ԊŌ�̐����Z�R���e�i
   */
  protected ACLabelContainer getRegionNightStandardRadioContainer(){
    if(regionNightStandardRadioContainer==null){
      regionNightStandardRadioContainer = new ACLabelContainer();
      regionNightStandardRadioContainer.setFollowChildEnabled(true);
      regionNightStandardRadioContainer.setVAlignment(VRLayout.CENTER);
      regionNightStandardRadioContainer.add(getRegionNightStandardRadio(), null);
    }
    return regionNightStandardRadioContainer;
  }

  /**
   * ��ԊŌ�̐����Z���f�����擾���܂��B
   * @return ��ԊŌ�̐����Z���f��
   */
  protected ACListModelAdapter getRegionNightStandardRadioModel(){
    if(regionNightStandardRadioModel==null){
      regionNightStandardRadioModel = new ACListModelAdapter();
      addRegionNightStandardRadioModel();
    }
    return regionNightStandardRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getRegionNightStandardRadioItem1(){
    if(regionNightStandardRadioItem1==null){

      regionNightStandardRadioItem1 = new ACRadioButtonItem();

      regionNightStandardRadioItem1.setText("�Ȃ�");

      regionNightStandardRadioItem1.setGroup(getRegionNightStandardRadio());

      regionNightStandardRadioItem1.setConstraints(VRLayout.FLOW);

      addRegionNightStandardRadioItem1();
    }
    return regionNightStandardRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getRegionNightStandardRadioItem2(){
    if(regionNightStandardRadioItem2==null){

      regionNightStandardRadioItem2 = new ACRadioButtonItem();

      regionNightStandardRadioItem2.setText("����");

      regionNightStandardRadioItem2.setGroup(getRegionNightStandardRadio());

      regionNightStandardRadioItem2.setConstraints(VRLayout.FLOW);

      addRegionNightStandardRadioItem2();
    }
    return regionNightStandardRadioItem2;

  }

  /**
   * ��Ë@�֘A�g���Z���擾���܂��B
   * @return ��Ë@�֘A�g���Z
   */
  public ACClearableRadioButtonGroup getMedicalCoordinateAddRadioGroup(){
    if(medicalCoordinateAddRadioGroup==null){

      medicalCoordinateAddRadioGroup = new ACClearableRadioButtonGroup();

      getMedicalCoordinateAddRadioGroupContainer().setText("��Ë@�֘A�g���Z");

      medicalCoordinateAddRadioGroup.setBindPath("1360104");

      medicalCoordinateAddRadioGroup.setUseClearButton(false);

      medicalCoordinateAddRadioGroup.setModel(getMedicalCoordinateAddRadioGroupModel());

      addMedicalCoordinateAddRadioGroup();
    }
    return medicalCoordinateAddRadioGroup;

  }

  /**
   * ��Ë@�֘A�g���Z�R���e�i���擾���܂��B
   * @return ��Ë@�֘A�g���Z�R���e�i
   */
  protected ACLabelContainer getMedicalCoordinateAddRadioGroupContainer(){
    if(medicalCoordinateAddRadioGroupContainer==null){
      medicalCoordinateAddRadioGroupContainer = new ACLabelContainer();
      medicalCoordinateAddRadioGroupContainer.setFollowChildEnabled(true);
      medicalCoordinateAddRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      medicalCoordinateAddRadioGroupContainer.add(getMedicalCoordinateAddRadioGroup(), null);
    }
    return medicalCoordinateAddRadioGroupContainer;
  }

  /**
   * ��Ë@�֘A�g���Z���f�����擾���܂��B
   * @return ��Ë@�֘A�g���Z���f��
   */
  protected ACListModelAdapter getMedicalCoordinateAddRadioGroupModel(){
    if(medicalCoordinateAddRadioGroupModel==null){
      medicalCoordinateAddRadioGroupModel = new ACListModelAdapter();
      addMedicalCoordinateAddRadioGroupModel();
    }
    return medicalCoordinateAddRadioGroupModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getMedicalCoordinateAddRadioItem1(){
    if(medicalCoordinateAddRadioItem1==null){

      medicalCoordinateAddRadioItem1 = new ACRadioButtonItem();

      medicalCoordinateAddRadioItem1.setText("�Ȃ�");

      medicalCoordinateAddRadioItem1.setGroup(getMedicalCoordinateAddRadioGroup());

      medicalCoordinateAddRadioItem1.setConstraints(VRLayout.FLOW);

      addMedicalCoordinateAddRadioItem1();
    }
    return medicalCoordinateAddRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getMedicalCoordinateAddRadioItem2(){
    if(medicalCoordinateAddRadioItem2==null){

      medicalCoordinateAddRadioItem2 = new ACRadioButtonItem();

      medicalCoordinateAddRadioItem2.setText("����");

      medicalCoordinateAddRadioItem2.setGroup(getMedicalCoordinateAddRadioGroup());

      medicalCoordinateAddRadioItem2.setConstraints(VRLayout.FLOW);

      addMedicalCoordinateAddRadioItem2();
    }
    return medicalCoordinateAddRadioItem2;

  }

  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001128_H2104Design() {

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

    this.add(getRegionSpecificFacilityPatterns(), VRLayout.CLIENT);

  }

  /**
   * �n�斧������{�ݓ����Ґ������p�^�[���̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addRegionSpecificFacilityPatterns(){

    regionSpecificFacilityPatterns.add(getRegionStaffSubtractionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    regionSpecificFacilityPatterns.add(getRegionTrainingRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    regionSpecificFacilityPatterns.add(getRegionNightStandardRadioContainer(), VRLayout.FLOW_RETURN);

    regionSpecificFacilityPatterns.add(getMedicalCoordinateAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * �l�����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addRegionStaffSubtractionRadio(){

  }

  /**
   * �l�����Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addRegionStaffSubtractionRadioModel(){

    getRegionSubtractionNo().setButtonIndex(1);

    getRegionStaffSubtractionRadioModel().add(getRegionSubtractionNo());

    getRegionSubtractionPersonLack().setButtonIndex(2);

    getRegionStaffSubtractionRadioModel().add(getRegionSubtractionPersonLack());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addRegionSubtractionNo(){

  }

  /**
   * �Ō�E���E���̕s���ɓ������ڂ�ǉ����܂��B
   */
  protected void addRegionSubtractionPersonLack(){

  }

  /**
   * �ʋ@�\�P���w���̐����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addRegionTrainingRadio(){

  }

  /**
   * �ʋ@�\�P���w���̐����Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addRegionTrainingRadioModel(){

    getRegionTrainingRadioItem1().setButtonIndex(1);

    getRegionTrainingRadioModel().add(getRegionTrainingRadioItem1());

    getRegionTrainingRadioItem2().setButtonIndex(2);

    getRegionTrainingRadioModel().add(getRegionTrainingRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addRegionTrainingRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addRegionTrainingRadioItem2(){

  }

  /**
   * ��ԊŌ�̐����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addRegionNightStandardRadio(){

  }

  /**
   * ��ԊŌ�̐����Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addRegionNightStandardRadioModel(){

    getRegionNightStandardRadioItem1().setButtonIndex(1);

    getRegionNightStandardRadioModel().add(getRegionNightStandardRadioItem1());

    getRegionNightStandardRadioItem2().setButtonIndex(2);

    getRegionNightStandardRadioModel().add(getRegionNightStandardRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addRegionNightStandardRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addRegionNightStandardRadioItem2(){

  }

  /**
   * ��Ë@�֘A�g���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalCoordinateAddRadioGroup(){

  }

  /**
   * ��Ë@�֘A�g���Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalCoordinateAddRadioGroupModel(){

    getMedicalCoordinateAddRadioItem1().setButtonIndex(1);

    getMedicalCoordinateAddRadioGroupModel().add(getMedicalCoordinateAddRadioItem1());

    getMedicalCoordinateAddRadioItem2().setButtonIndex(2);

    getMedicalCoordinateAddRadioGroupModel().add(getMedicalCoordinateAddRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalCoordinateAddRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalCoordinateAddRadioItem2(){

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
      ACFrame.debugStart(new ACAffairInfo(QS001128_H2104Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QS001128_H2104Design getThis() {
    return this;
  }
}
