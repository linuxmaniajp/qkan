
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
 * �쐬��: 2006/12/25  ���{�R���s���[�^�[������� ���{�@�K�� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �T�[�r�X�\��쐬/�ύX (S)
 * �v���Z�X �T�[�r�X�\��T�� (001)
 * �v���O���� �T�[�r�X�p�^�[����ԑΉ��^�K���� (QS001123)
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
 * �T�[�r�X�p�^�[����ԑΉ��^�K�����ʍ��ڃf�U�C��(QS001123) 
 */
public class QS001123Design extends QS001ServicePanel {
  //GUI�R���|�[�l���g

  private ACPanel nightTypeVisitCarePatterns;

  private ACClearableRadioButtonGroup providerDivisionRadio;

  private ACLabelContainer providerDivisionRadioContainer;

  private ACListModelAdapter providerDivisionRadioModel;

  private ACRadioButtonItem providerDivisionRadioItem1;

  private ACRadioButtonItem providerDivisionRadioItem2;

  private ACClearableRadioButtonGroup serviceDivisionRadio;

  private ACLabelContainer serviceDivisionRadioContainer;

  private ACListModelAdapter serviceDivisionRadioModel;

  private ACRadioButtonItem serviceDivisionRadioItem1;

  private ACRadioButtonItem serviceDivisionRadioItem2;

  private ACClearableRadioButtonGroup anytimeCorrespondenceTypeRadio;

  private ACLabelContainer anytimeCorrespondenceTypeRadioContainer;

  private ACListModelAdapter anytimeCorrespondenceTypeRadioModel;

  private ACRadioButtonItem anytimeCorrespondenceTypeRadioItem1;

  private ACRadioButtonItem anytimeCorrespondenceTypeRadioItem2;

  private ACClearableRadioButtonGroup classEmploymentRadio;

  private ACLabelContainer classEmploymentRadioContainer;

  private ACListModelAdapter classEmploymentRadioModel;

  private ACRadioButtonItem classEmploymentRadioItem1;

  private ACRadioButtonItem classEmploymentRadioItem2;

  private ACValueArrayRadioButtonGroup calculationDivision;

  private ACLabelContainer calculationDivisionContainer;

  private ACListModelAdapter calculationDivisionModel;

  private ACRadioButtonItem calculationDivisionNormal;

  private ACRadioButtonItem calculationDivisionBasicOnly;

  private ACIntegerCheckBox crackOnDayCheck;

  //getter

  /**
   * ��ԑΉ��^�K����p�^�[���̈���擾���܂��B
   * @return ��ԑΉ��^�K����p�^�[���̈�
   */
  public ACPanel getNightTypeVisitCarePatterns(){
    if(nightTypeVisitCarePatterns==null){

      nightTypeVisitCarePatterns = new ACPanel();

      nightTypeVisitCarePatterns.setAutoWrap(false);

      nightTypeVisitCarePatterns.setHgrid(200);

      addNightTypeVisitCarePatterns();
    }
    return nightTypeVisitCarePatterns;

  }

  /**
   * �{�ݓ��̋敪���擾���܂��B
   * @return �{�ݓ��̋敪
   */
  public ACClearableRadioButtonGroup getProviderDivisionRadio(){
    if(providerDivisionRadio==null){

      providerDivisionRadio = new ACClearableRadioButtonGroup();

      getProviderDivisionRadioContainer().setText("�{�ݓ��̋敪");

      providerDivisionRadio.setBindPath("1710101");

      providerDivisionRadio.setUseClearButton(false);

      providerDivisionRadio.setModel(getProviderDivisionRadioModel());

      addProviderDivisionRadio();
    }
    return providerDivisionRadio;

  }

  /**
   * �{�ݓ��̋敪�R���e�i���擾���܂��B
   * @return �{�ݓ��̋敪�R���e�i
   */
  protected ACLabelContainer getProviderDivisionRadioContainer(){
    if(providerDivisionRadioContainer==null){
      providerDivisionRadioContainer = new ACLabelContainer();
      providerDivisionRadioContainer.setFollowChildEnabled(true);
      providerDivisionRadioContainer.setVAlignment(VRLayout.CENTER);
      providerDivisionRadioContainer.add(getProviderDivisionRadio(), null);
    }
    return providerDivisionRadioContainer;
  }

  /**
   * �{�ݓ��̋敪���f�����擾���܂��B
   * @return �{�ݓ��̋敪���f��
   */
  protected ACListModelAdapter getProviderDivisionRadioModel(){
    if(providerDivisionRadioModel==null){
      providerDivisionRadioModel = new ACListModelAdapter();
      addProviderDivisionRadioModel();
    }
    return providerDivisionRadioModel;
  }

  /**
   * I�^���擾���܂��B
   * @return I�^
   */
  public ACRadioButtonItem getProviderDivisionRadioItem1(){
    if(providerDivisionRadioItem1==null){

      providerDivisionRadioItem1 = new ACRadioButtonItem();

      providerDivisionRadioItem1.setText("I�^");

      providerDivisionRadioItem1.setGroup(getProviderDivisionRadio());

      providerDivisionRadioItem1.setConstraints(VRLayout.FLOW);

      addProviderDivisionRadioItem1();
    }
    return providerDivisionRadioItem1;

  }

  /**
   * II�^���擾���܂��B
   * @return II�^
   */
  public ACRadioButtonItem getProviderDivisionRadioItem2(){
    if(providerDivisionRadioItem2==null){

      providerDivisionRadioItem2 = new ACRadioButtonItem();

      providerDivisionRadioItem2.setText("II�^");

      providerDivisionRadioItem2.setGroup(getProviderDivisionRadio());

      providerDivisionRadioItem2.setConstraints(VRLayout.FLOW);

      addProviderDivisionRadioItem2();
    }
    return providerDivisionRadioItem2;

  }

  /**
   * �T�[�r�X�敪���擾���܂��B
   * @return �T�[�r�X�敪
   */
  public ACClearableRadioButtonGroup getServiceDivisionRadio(){
    if(serviceDivisionRadio==null){

      serviceDivisionRadio = new ACClearableRadioButtonGroup();

      getServiceDivisionRadioContainer().setText("�T�[�r�X�敪");

      serviceDivisionRadio.setBindPath("1710102");

      serviceDivisionRadio.setUseClearButton(false);

      serviceDivisionRadio.setModel(getServiceDivisionRadioModel());

      addServiceDivisionRadio();
    }
    return serviceDivisionRadio;

  }

  /**
   * �T�[�r�X�敪�R���e�i���擾���܂��B
   * @return �T�[�r�X�敪�R���e�i
   */
  protected ACLabelContainer getServiceDivisionRadioContainer(){
    if(serviceDivisionRadioContainer==null){
      serviceDivisionRadioContainer = new ACLabelContainer();
      serviceDivisionRadioContainer.setFollowChildEnabled(true);
      serviceDivisionRadioContainer.setVAlignment(VRLayout.CENTER);
      serviceDivisionRadioContainer.add(getServiceDivisionRadio(), null);
    }
    return serviceDivisionRadioContainer;
  }

  /**
   * �T�[�r�X�敪���f�����擾���܂��B
   * @return �T�[�r�X�敪���f��
   */
  protected ACListModelAdapter getServiceDivisionRadioModel(){
    if(serviceDivisionRadioModel==null){
      serviceDivisionRadioModel = new ACListModelAdapter();
      addServiceDivisionRadioModel();
    }
    return serviceDivisionRadioModel;
  }

  /**
   * �������^���擾���܂��B
   * @return �������^
   */
  public ACRadioButtonItem getServiceDivisionRadioItem1(){
    if(serviceDivisionRadioItem1==null){

      serviceDivisionRadioItem1 = new ACRadioButtonItem();

      serviceDivisionRadioItem1.setText("�������^");

      serviceDivisionRadioItem1.setGroup(getServiceDivisionRadio());

      serviceDivisionRadioItem1.setConstraints(VRLayout.FLOW);

      addServiceDivisionRadioItem1();
    }
    return serviceDivisionRadioItem1;

  }

  /**
   * �����Ή��^���擾���܂��B
   * @return �����Ή��^
   */
  public ACRadioButtonItem getServiceDivisionRadioItem2(){
    if(serviceDivisionRadioItem2==null){

      serviceDivisionRadioItem2 = new ACRadioButtonItem();

      serviceDivisionRadioItem2.setText("�����Ή��^");

      serviceDivisionRadioItem2.setGroup(getServiceDivisionRadio());

      serviceDivisionRadioItem2.setConstraints(VRLayout.FLOW);

      addServiceDivisionRadioItem2();
    }
    return serviceDivisionRadioItem2;

  }

  /**
   * �Ή��l�����擾���܂��B
   * @return �Ή��l��
   */
  public ACClearableRadioButtonGroup getAnytimeCorrespondenceTypeRadio(){
    if(anytimeCorrespondenceTypeRadio==null){

      anytimeCorrespondenceTypeRadio = new ACClearableRadioButtonGroup();

      getAnytimeCorrespondenceTypeRadioContainer().setText("�Ή��l��");

      anytimeCorrespondenceTypeRadio.setBindPath("1710104");

      anytimeCorrespondenceTypeRadio.setUseClearButton(false);

      anytimeCorrespondenceTypeRadio.setModel(getAnytimeCorrespondenceTypeRadioModel());

      addAnytimeCorrespondenceTypeRadio();
    }
    return anytimeCorrespondenceTypeRadio;

  }

  /**
   * �Ή��l���R���e�i���擾���܂��B
   * @return �Ή��l���R���e�i
   */
  protected ACLabelContainer getAnytimeCorrespondenceTypeRadioContainer(){
    if(anytimeCorrespondenceTypeRadioContainer==null){
      anytimeCorrespondenceTypeRadioContainer = new ACLabelContainer();
      anytimeCorrespondenceTypeRadioContainer.setFollowChildEnabled(true);
      anytimeCorrespondenceTypeRadioContainer.setVAlignment(VRLayout.CENTER);
      anytimeCorrespondenceTypeRadioContainer.add(getAnytimeCorrespondenceTypeRadio(), null);
    }
    return anytimeCorrespondenceTypeRadioContainer;
  }

  /**
   * �Ή��l�����f�����擾���܂��B
   * @return �Ή��l�����f��
   */
  protected ACListModelAdapter getAnytimeCorrespondenceTypeRadioModel(){
    if(anytimeCorrespondenceTypeRadioModel==null){
      anytimeCorrespondenceTypeRadioModel = new ACListModelAdapter();
      addAnytimeCorrespondenceTypeRadioModel();
    }
    return anytimeCorrespondenceTypeRadioModel;
  }

  /**
   * 1�l�Ή����擾���܂��B
   * @return 1�l�Ή�
   */
  public ACRadioButtonItem getAnytimeCorrespondenceTypeRadioItem1(){
    if(anytimeCorrespondenceTypeRadioItem1==null){

      anytimeCorrespondenceTypeRadioItem1 = new ACRadioButtonItem();

      anytimeCorrespondenceTypeRadioItem1.setText("1�l�Ή�");

      anytimeCorrespondenceTypeRadioItem1.setGroup(getAnytimeCorrespondenceTypeRadio());

      anytimeCorrespondenceTypeRadioItem1.setConstraints(VRLayout.FLOW);

      addAnytimeCorrespondenceTypeRadioItem1();
    }
    return anytimeCorrespondenceTypeRadioItem1;

  }

  /**
   * 2�l�Ή����擾���܂��B
   * @return 2�l�Ή�
   */
  public ACRadioButtonItem getAnytimeCorrespondenceTypeRadioItem2(){
    if(anytimeCorrespondenceTypeRadioItem2==null){

      anytimeCorrespondenceTypeRadioItem2 = new ACRadioButtonItem();

      anytimeCorrespondenceTypeRadioItem2.setText("2�l�Ή�");

      anytimeCorrespondenceTypeRadioItem2.setGroup(getAnytimeCorrespondenceTypeRadio());

      anytimeCorrespondenceTypeRadioItem2.setConstraints(VRLayout.FLOW);

      addAnytimeCorrespondenceTypeRadioItem2();
    }
    return anytimeCorrespondenceTypeRadioItem2;

  }

  /**
   * �K��҂̋��E���擾���܂��B
   * @return �K��҂̋��E
   */
  public ACClearableRadioButtonGroup getClassEmploymentRadio(){
    if(classEmploymentRadio==null){

      classEmploymentRadio = new ACClearableRadioButtonGroup();

      getClassEmploymentRadioContainer().setText("�K��҂̋��E");

      classEmploymentRadio.setBindPath("1710105");

      classEmploymentRadio.setUseClearButton(false);

      classEmploymentRadio.setModel(getClassEmploymentRadioModel());

      addClassEmploymentRadio();
    }
    return classEmploymentRadio;

  }

  /**
   * �K��҂̋��E�R���e�i���擾���܂��B
   * @return �K��҂̋��E�R���e�i
   */
  protected ACLabelContainer getClassEmploymentRadioContainer(){
    if(classEmploymentRadioContainer==null){
      classEmploymentRadioContainer = new ACLabelContainer();
      classEmploymentRadioContainer.setFollowChildEnabled(true);
      classEmploymentRadioContainer.setVAlignment(VRLayout.CENTER);
      classEmploymentRadioContainer.add(getClassEmploymentRadio(), null);
    }
    return classEmploymentRadioContainer;
  }

  /**
   * �K��҂̋��E���f�����擾���܂��B
   * @return �K��҂̋��E���f��
   */
  protected ACListModelAdapter getClassEmploymentRadioModel(){
    if(classEmploymentRadioModel==null){
      classEmploymentRadioModel = new ACListModelAdapter();
      addClassEmploymentRadioModel();
    }
    return classEmploymentRadioModel;
  }

  /**
   * 3���ȊO���擾���܂��B
   * @return 3���ȊO
   */
  public ACRadioButtonItem getClassEmploymentRadioItem1(){
    if(classEmploymentRadioItem1==null){

      classEmploymentRadioItem1 = new ACRadioButtonItem();

      classEmploymentRadioItem1.setText("3���ȊO");

      classEmploymentRadioItem1.setGroup(getClassEmploymentRadio());

      classEmploymentRadioItem1.setConstraints(VRLayout.FLOW);

      addClassEmploymentRadioItem1();
    }
    return classEmploymentRadioItem1;

  }

  /**
   * 3�����擾���܂��B
   * @return 3��
   */
  public ACRadioButtonItem getClassEmploymentRadioItem2(){
    if(classEmploymentRadioItem2==null){

      classEmploymentRadioItem2 = new ACRadioButtonItem();

      classEmploymentRadioItem2.setText("3��");

      classEmploymentRadioItem2.setGroup(getClassEmploymentRadio());

      classEmploymentRadioItem2.setConstraints(VRLayout.FLOW);

      addClassEmploymentRadioItem2();
    }
    return classEmploymentRadioItem2;

  }

  /**
   * �Z��敪���擾���܂��B
   * @return �Z��敪
   */
  public ACValueArrayRadioButtonGroup getCalculationDivision(){
    if(calculationDivision==null){

      calculationDivision = new ACValueArrayRadioButtonGroup();

      getCalculationDivisionContainer().setText("�Z��敪");

      calculationDivision.setBindPath("9");

      calculationDivision.setUseClearButton(false);

      calculationDivision.setModel(getCalculationDivisionModel());

      calculationDivision.setValues(new int[]{1,3});

      addCalculationDivision();
    }
    return calculationDivision;

  }

  /**
   * �Z��敪�R���e�i���擾���܂��B
   * @return �Z��敪�R���e�i
   */
  protected ACLabelContainer getCalculationDivisionContainer(){
    if(calculationDivisionContainer==null){
      calculationDivisionContainer = new ACLabelContainer();
      calculationDivisionContainer.setFollowChildEnabled(true);
      calculationDivisionContainer.setVAlignment(VRLayout.CENTER);
      calculationDivisionContainer.add(getCalculationDivision(), null);
    }
    return calculationDivisionContainer;
  }

  /**
   * �Z��敪���f�����擾���܂��B
   * @return �Z��敪���f��
   */
  protected ACListModelAdapter getCalculationDivisionModel(){
    if(calculationDivisionModel==null){
      calculationDivisionModel = new ACListModelAdapter();
      addCalculationDivisionModel();
    }
    return calculationDivisionModel;
  }

  /**
   * �ʏ���擾���܂��B
   * @return �ʏ�
   */
  public ACRadioButtonItem getCalculationDivisionNormal(){
    if(calculationDivisionNormal==null){

      calculationDivisionNormal = new ACRadioButtonItem();

      calculationDivisionNormal.setText("�ʏ�");

      calculationDivisionNormal.setGroup(getCalculationDivision());

      calculationDivisionNormal.setConstraints(VRLayout.FLOW);

      addCalculationDivisionNormal();
    }
    return calculationDivisionNormal;

  }

  /**
   * ��{�݂̂��擾���܂��B
   * @return ��{�̂�
   */
  public ACRadioButtonItem getCalculationDivisionBasicOnly(){
    if(calculationDivisionBasicOnly==null){

      calculationDivisionBasicOnly = new ACRadioButtonItem();

      calculationDivisionBasicOnly.setText("��{�̂�");

      calculationDivisionBasicOnly.setGroup(getCalculationDivision());

      calculationDivisionBasicOnly.setConstraints(VRLayout.FLOW);

      addCalculationDivisionBasicOnly();
    }
    return calculationDivisionBasicOnly;

  }

  /**
   * �������擾���܂��B
   * @return ����
   */
  public ACIntegerCheckBox getCrackOnDayCheck(){
    if(crackOnDayCheck==null){

      crackOnDayCheck = new ACIntegerCheckBox();

      crackOnDayCheck.setText("����");

      crackOnDayCheck.setBindPath("1710106");

      crackOnDayCheck.setSelectValue(2);

      crackOnDayCheck.setUnSelectValue(1);

      addCrackOnDayCheck();
    }
    return crackOnDayCheck;

  }

  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001123Design() {

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

    this.add(getNightTypeVisitCarePatterns(), VRLayout.CLIENT);

  }

  /**
   * ��ԑΉ��^�K����p�^�[���̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addNightTypeVisitCarePatterns(){

    nightTypeVisitCarePatterns.add(getProviderDivisionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    nightTypeVisitCarePatterns.add(getServiceDivisionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    nightTypeVisitCarePatterns.add(getAnytimeCorrespondenceTypeRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    nightTypeVisitCarePatterns.add(getClassEmploymentRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    nightTypeVisitCarePatterns.add(getCalculationDivisionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    nightTypeVisitCarePatterns.add(getCrackOnDayCheck(), VRLayout.FLOW);

  }

  /**
   * �{�ݓ��̋敪�ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderDivisionRadio(){

  }

  /**
   * �{�ݓ��̋敪���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderDivisionRadioModel(){

    getProviderDivisionRadioItem1().setButtonIndex(1);

    getProviderDivisionRadioModel().add(getProviderDivisionRadioItem1());

    getProviderDivisionRadioItem2().setButtonIndex(2);

    getProviderDivisionRadioModel().add(getProviderDivisionRadioItem2());

  }

  /**
   * I�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderDivisionRadioItem1(){

  }

  /**
   * II�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderDivisionRadioItem2(){

  }

  /**
   * �T�[�r�X�敪�ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceDivisionRadio(){

  }

  /**
   * �T�[�r�X�敪���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceDivisionRadioModel(){

    getServiceDivisionRadioItem1().setButtonIndex(1);

    getServiceDivisionRadioModel().add(getServiceDivisionRadioItem1());

    getServiceDivisionRadioItem2().setButtonIndex(2);

    getServiceDivisionRadioModel().add(getServiceDivisionRadioItem2());

  }

  /**
   * �������^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceDivisionRadioItem1(){

  }

  /**
   * �����Ή��^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceDivisionRadioItem2(){

  }

  /**
   * �Ή��l���ɓ������ڂ�ǉ����܂��B
   */
  protected void addAnytimeCorrespondenceTypeRadio(){

  }

  /**
   * �Ή��l�����f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addAnytimeCorrespondenceTypeRadioModel(){

    getAnytimeCorrespondenceTypeRadioItem1().setButtonIndex(1);

    getAnytimeCorrespondenceTypeRadioModel().add(getAnytimeCorrespondenceTypeRadioItem1());

    getAnytimeCorrespondenceTypeRadioItem2().setButtonIndex(2);

    getAnytimeCorrespondenceTypeRadioModel().add(getAnytimeCorrespondenceTypeRadioItem2());

  }

  /**
   * 1�l�Ή��ɓ������ڂ�ǉ����܂��B
   */
  protected void addAnytimeCorrespondenceTypeRadioItem1(){

  }

  /**
   * 2�l�Ή��ɓ������ڂ�ǉ����܂��B
   */
  protected void addAnytimeCorrespondenceTypeRadioItem2(){

  }

  /**
   * �K��҂̋��E�ɓ������ڂ�ǉ����܂��B
   */
  protected void addClassEmploymentRadio(){

  }

  /**
   * �K��҂̋��E���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addClassEmploymentRadioModel(){

    getClassEmploymentRadioItem1().setButtonIndex(1);

    getClassEmploymentRadioModel().add(getClassEmploymentRadioItem1());

    getClassEmploymentRadioItem2().setButtonIndex(2);

    getClassEmploymentRadioModel().add(getClassEmploymentRadioItem2());

  }

  /**
   * 3���ȊO�ɓ������ڂ�ǉ����܂��B
   */
  protected void addClassEmploymentRadioItem1(){

  }

  /**
   * 3���ɓ������ڂ�ǉ����܂��B
   */
  protected void addClassEmploymentRadioItem2(){

  }

  /**
   * �Z��敪�ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalculationDivision(){

  }

  /**
   * �Z��敪���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalculationDivisionModel(){

    getCalculationDivisionNormal().setButtonIndex(1);

    getCalculationDivisionModel().add(getCalculationDivisionNormal());

    getCalculationDivisionBasicOnly().setButtonIndex(3);

    getCalculationDivisionModel().add(getCalculationDivisionBasicOnly());

  }

  /**
   * �ʏ�ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalculationDivisionNormal(){

  }

  /**
   * ��{�݂̂ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalculationDivisionBasicOnly(){

  }

  /**
   * �����ɓ������ڂ�ǉ����܂��B
   */
  protected void addCrackOnDayCheck(){

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
      ACFrame.debugStart(new ACAffairInfo(QS001123Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QS001123Design getThis() {
    return this;
  }
}
