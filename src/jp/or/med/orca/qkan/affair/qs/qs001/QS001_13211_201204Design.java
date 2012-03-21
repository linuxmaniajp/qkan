
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
 * �쐬��: 2012/02/17  ���{�R���s���[�^�[������� ����@��F �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �T�[�r�X�\��쐬/�ύX (S)
 * �v���Z�X �T�[�r�X�\��T�� (001)
 * �v���O���� �T�[�r�X�p�^�[���F�m�ǑΉ������������i�Z�����p�ȊO�j (QS001_13211_201204)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
import java.awt.Component;

import javax.swing.JTabbedPane;

import jp.nichicom.ac.component.ACIntegerCheckBox;
import jp.nichicom.ac.component.ACRadioButtonItem;
import jp.nichicom.ac.component.ACValueArrayRadioButtonGroup;
import jp.nichicom.ac.container.ACLabelContainer;
import jp.nichicom.ac.container.ACPanel;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.util.adapter.ACListModelAdapter;
import jp.nichicom.vr.layout.VRLayout;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
/**
 * �T�[�r�X�p�^�[���F�m�ǑΉ������������i�Z�����p�ȊO�j��ʍ��ڃf�U�C��(QS001_13211_201204) 
 */
public class QS001_13211_201204Design extends QS001ServicePanel {
  //GUI�R���|�[�l���g

  private JTabbedPane tabs;

  private ACPanel tab1;

  private ACValueArrayRadioButtonGroup providerDivisionRadio;

  private ACLabelContainer providerDivisionRadioContainer;

  private ACListModelAdapter providerDivisionRadioModel;

  private ACRadioButtonItem providerDivisionRadioItem1;

  private ACRadioButtonItem providerDivisionRadioItem2;

  private ACValueArrayRadioButtonGroup typeSymbiosisNursingForDementiaDefaultRadio;

  private ACLabelContainer typeSymbiosisNursingForDementiaDefaultRadioContainer;

  private ACListModelAdapter typeSymbiosisNursingForDementiaDefaultRadioModel;

  private ACRadioButtonItem typeSymbiosisNursingForDementiaDefaultRadioItem1;

  private ACRadioButtonItem typeSymbiosisNursingForDementiaDefaultRadioItem2;

  private ACValueArrayRadioButtonGroup typeSymbiosisNursingForDementiaSubtraction;

  private ACLabelContainer typeSymbiosisNursingForDementiaSubtractionContainer;

  private ACListModelAdapter typeSymbiosisNursingForDementiaSubtractionModel;

  private ACRadioButtonItem typeSymbiosisNursingForDementiaSubtractionCapacityNot;

  private ACRadioButtonItem typeSymbiosisNursingForDementiaSubtractionCapacityExcess;

  private ACRadioButtonItem typeSymbiosisNursingForDementiaSubtractionPersonLack;

  private ACValueArrayRadioButtonGroup nightWorkConditionStandardRadio;

  private ACLabelContainer nightWorkConditionStandardRadioContainer;

  private ACListModelAdapter nightWorkConditionStandardRadioModel;

  private ACRadioButtonItem nightWorkConditionStandardRadioItem1;

  private ACRadioButtonItem nightWorkConditionStandardRadioItem2;

  private ACValueArrayRadioButtonGroup medicalCooperationSystemAddRadio;

  private ACLabelContainer medicalCooperationSystemAddRadioContainer;

  private ACListModelAdapter medicalCooperationSystemAddRadioModel;

  private ACRadioButtonItem medicalCooperationSystemAddRadioItem1;

  private ACRadioButtonItem medicalCooperationSystemAddRadioItem2;

  private ACValueArrayRadioButtonGroup nightCareAddRadioGroup;

  private ACLabelContainer nightCareAddRadioGroupContainer;

  private ACListModelAdapter nightCareAddRadioGroupModel;

  private ACRadioButtonItem nightCareAddRadioItem1;

  private ACRadioButtonItem nightCareAddRadioItem2;

  private ACValueArrayRadioButtonGroup youngDementiaPatinetAddRadioGroup;

  private ACLabelContainer youngDementiaPatinetAddRadioGroupContainer;

  private ACListModelAdapter youngDementiaPatinetAddRadioGroupModel;

  private ACRadioButtonItem youngDementiaPatinetAddRadioItem1;

  private ACRadioButtonItem youngDementiaPatinetAddRadioItem2;

  private ACValueArrayRadioButtonGroup dementiaProfessionalCareAddRadioGroup;

  private ACLabelContainer dementiaProfessionalCareAddRadioGroupContainer;

  private ACListModelAdapter dementiaProfessionalCareAddRadioGroupModel;

  private ACRadioButtonItem dementiaProfessionalCareAddRadioItem1;

  private ACRadioButtonItem dementiaProfessionalCareAddRadioItem2;

  private ACRadioButtonItem dementiaProfessionalCareAddRadioItem3;

  private ACPanel tab2;

  private ACValueArrayRadioButtonGroup watchKaigoAddRadioGroup;

  private ACLabelContainer watchKaigoAddRadioGroupContainer;

  private ACListModelAdapter watchKaigoAddRadioGroupModel;

  private ACRadioButtonItem watchKaigoAddRadioItem1;

  private ACRadioButtonItem watchKaigoAddRadioItem2;

  private ACRadioButtonItem watchKaigoAddRadioItem3;

  private ACRadioButtonItem watchKaigoAddRadioItem4;

  private ACLabelContainer kaigoHealthCareOfTheAgedHijoAddition;

  private ACIntegerCheckBox leaveApartmentsSupportAdd;

  private ACValueArrayRadioButtonGroup serviceAddProvisionStructuralRadioGroup;

  private ACLabelContainer serviceAddProvisionStructuralRadioGroupContainer;

  private ACListModelAdapter serviceAddProvisionStructuralRadioGroupModel;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem1;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem2;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem3;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem4;

  //getter

  /**
   * �^�u�y�C�����擾���܂��B
   * @return �^�u�y�C��
   */
  public JTabbedPane getTabs(){
    if(tabs==null){

      tabs = new JTabbedPane();

      addTabs();
    }
    return tabs;

  }

  /**
   * �^�u1���擾���܂��B
   * @return �^�u1
   */
  public ACPanel getTab1(){
    if(tab1==null){

      tab1 = new ACPanel();

      tab1.setFollowChildEnabled(true);

      tab1.setHgap(0);

      tab1.setLabelMargin(0);

      tab1.setVgap(0);

      addTab1();
    }
    return tab1;

  }

  /**
   * �{�ݓ��̋敪���擾���܂��B
   * @return �{�ݓ��̋敪
   */
  public ACValueArrayRadioButtonGroup getProviderDivisionRadio(){
    if(providerDivisionRadio==null){

      providerDivisionRadio = new ACValueArrayRadioButtonGroup();

      getProviderDivisionRadioContainer().setText("�{�ݓ��̋敪");

      providerDivisionRadio.setBindPath("1320114");

      providerDivisionRadio.setUseClearButton(false);

      providerDivisionRadio.setModel(getProviderDivisionRadioModel());

      providerDivisionRadio.setValues(new int[]{1,2});

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
   * �������Z���擾���܂��B
   * @return �������Z
   */
  public ACValueArrayRadioButtonGroup getTypeSymbiosisNursingForDementiaDefaultRadio(){
    if(typeSymbiosisNursingForDementiaDefaultRadio==null){

      typeSymbiosisNursingForDementiaDefaultRadio = new ACValueArrayRadioButtonGroup();

      getTypeSymbiosisNursingForDementiaDefaultRadioContainer().setText("�������Z");

      typeSymbiosisNursingForDementiaDefaultRadio.setBindPath("1320104");

      typeSymbiosisNursingForDementiaDefaultRadio.setUseClearButton(false);

      typeSymbiosisNursingForDementiaDefaultRadio.setModel(getTypeSymbiosisNursingForDementiaDefaultRadioModel());

      typeSymbiosisNursingForDementiaDefaultRadio.setValues(new int[]{1,2});

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
      typeSymbiosisNursingForDementiaDefaultRadioContainer.setVAlignment(VRLayout.CENTER);
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
  public ACValueArrayRadioButtonGroup getTypeSymbiosisNursingForDementiaSubtraction(){
    if(typeSymbiosisNursingForDementiaSubtraction==null){

      typeSymbiosisNursingForDementiaSubtraction = new ACValueArrayRadioButtonGroup();

      getTypeSymbiosisNursingForDementiaSubtractionContainer().setText("�l�����Z");

      typeSymbiosisNursingForDementiaSubtraction.setBindPath("1320105");

      typeSymbiosisNursingForDementiaSubtraction.setUseClearButton(false);

      typeSymbiosisNursingForDementiaSubtraction.setModel(getTypeSymbiosisNursingForDementiaSubtractionModel());

      typeSymbiosisNursingForDementiaSubtraction.setValues(new int[]{1,2,3});

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
  public ACValueArrayRadioButtonGroup getNightWorkConditionStandardRadio(){
    if(nightWorkConditionStandardRadio==null){

      nightWorkConditionStandardRadio = new ACValueArrayRadioButtonGroup();

      getNightWorkConditionStandardRadioContainer().setText("��ԋΖ������");

      nightWorkConditionStandardRadio.setBindPath("1320106");

      nightWorkConditionStandardRadio.setUseClearButton(false);

      nightWorkConditionStandardRadio.setModel(getNightWorkConditionStandardRadioModel());

      nightWorkConditionStandardRadio.setValues(new int[]{1,2});

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
  public ACValueArrayRadioButtonGroup getMedicalCooperationSystemAddRadio(){
    if(medicalCooperationSystemAddRadio==null){

      medicalCooperationSystemAddRadio = new ACValueArrayRadioButtonGroup();

      getMedicalCooperationSystemAddRadioContainer().setText("��ØA�g�̐����Z");

      medicalCooperationSystemAddRadio.setBindPath("1320107");

      medicalCooperationSystemAddRadio.setUseClearButton(false);

      medicalCooperationSystemAddRadio.setModel(getMedicalCooperationSystemAddRadioModel());

      medicalCooperationSystemAddRadio.setValues(new int[]{1,2});

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
   * ��ԃP�A���Z���擾���܂��B
   * @return ��ԃP�A���Z
   */
  public ACValueArrayRadioButtonGroup getNightCareAddRadioGroup(){
    if(nightCareAddRadioGroup==null){

      nightCareAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getNightCareAddRadioGroupContainer().setText("��ԃP�A���Z");

      nightCareAddRadioGroup.setBindPath("1320108");

      nightCareAddRadioGroup.setNoSelectIndex(0);

      nightCareAddRadioGroup.setUseClearButton(false);

      nightCareAddRadioGroup.setModel(getNightCareAddRadioGroupModel());

      nightCareAddRadioGroup.setValues(new int[]{1,2});

      addNightCareAddRadioGroup();
    }
    return nightCareAddRadioGroup;

  }

  /**
   * ��ԃP�A���Z�R���e�i���擾���܂��B
   * @return ��ԃP�A���Z�R���e�i
   */
  protected ACLabelContainer getNightCareAddRadioGroupContainer(){
    if(nightCareAddRadioGroupContainer==null){
      nightCareAddRadioGroupContainer = new ACLabelContainer();
      nightCareAddRadioGroupContainer.setFollowChildEnabled(true);
      nightCareAddRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      nightCareAddRadioGroupContainer.add(getNightCareAddRadioGroup(), null);
    }
    return nightCareAddRadioGroupContainer;
  }

  /**
   * ��ԃP�A���Z���f�����擾���܂��B
   * @return ��ԃP�A���Z���f��
   */
  protected ACListModelAdapter getNightCareAddRadioGroupModel(){
    if(nightCareAddRadioGroupModel==null){
      nightCareAddRadioGroupModel = new ACListModelAdapter();
      addNightCareAddRadioGroupModel();
    }
    return nightCareAddRadioGroupModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getNightCareAddRadioItem1(){
    if(nightCareAddRadioItem1==null){

      nightCareAddRadioItem1 = new ACRadioButtonItem();

      nightCareAddRadioItem1.setText("�Ȃ�");

      nightCareAddRadioItem1.setGroup(getNightCareAddRadioGroup());

      nightCareAddRadioItem1.setConstraints(VRLayout.FLOW);

      addNightCareAddRadioItem1();
    }
    return nightCareAddRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getNightCareAddRadioItem2(){
    if(nightCareAddRadioItem2==null){

      nightCareAddRadioItem2 = new ACRadioButtonItem();

      nightCareAddRadioItem2.setText("����");

      nightCareAddRadioItem2.setGroup(getNightCareAddRadioGroup());

      nightCareAddRadioItem2.setConstraints(VRLayout.FLOW);

      addNightCareAddRadioItem2();
    }
    return nightCareAddRadioItem2;

  }

  /**
   * ��N���F�m�Ǘ��p�Ҏ�����Z���擾���܂��B
   * @return ��N���F�m�Ǘ��p�Ҏ�����Z
   */
  public ACValueArrayRadioButtonGroup getYoungDementiaPatinetAddRadioGroup(){
    if(youngDementiaPatinetAddRadioGroup==null){

      youngDementiaPatinetAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getYoungDementiaPatinetAddRadioGroupContainer().setText("��N���F�m�Ǘ��p�Ҏ�����Z");

      youngDementiaPatinetAddRadioGroup.setBindPath("1320109");

      youngDementiaPatinetAddRadioGroup.setNoSelectIndex(0);

      youngDementiaPatinetAddRadioGroup.setUseClearButton(false);

      youngDementiaPatinetAddRadioGroup.setModel(getYoungDementiaPatinetAddRadioGroupModel());

      youngDementiaPatinetAddRadioGroup.setValues(new int[]{1,2});

      addYoungDementiaPatinetAddRadioGroup();
    }
    return youngDementiaPatinetAddRadioGroup;

  }

  /**
   * ��N���F�m�Ǘ��p�Ҏ�����Z�R���e�i���擾���܂��B
   * @return ��N���F�m�Ǘ��p�Ҏ�����Z�R���e�i
   */
  protected ACLabelContainer getYoungDementiaPatinetAddRadioGroupContainer(){
    if(youngDementiaPatinetAddRadioGroupContainer==null){
      youngDementiaPatinetAddRadioGroupContainer = new ACLabelContainer();
      youngDementiaPatinetAddRadioGroupContainer.setFollowChildEnabled(true);
      youngDementiaPatinetAddRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      youngDementiaPatinetAddRadioGroupContainer.add(getYoungDementiaPatinetAddRadioGroup(), null);
    }
    return youngDementiaPatinetAddRadioGroupContainer;
  }

  /**
   * ��N���F�m�Ǘ��p�Ҏ�����Z���f�����擾���܂��B
   * @return ��N���F�m�Ǘ��p�Ҏ�����Z���f��
   */
  protected ACListModelAdapter getYoungDementiaPatinetAddRadioGroupModel(){
    if(youngDementiaPatinetAddRadioGroupModel==null){
      youngDementiaPatinetAddRadioGroupModel = new ACListModelAdapter();
      addYoungDementiaPatinetAddRadioGroupModel();
    }
    return youngDementiaPatinetAddRadioGroupModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getYoungDementiaPatinetAddRadioItem1(){
    if(youngDementiaPatinetAddRadioItem1==null){

      youngDementiaPatinetAddRadioItem1 = new ACRadioButtonItem();

      youngDementiaPatinetAddRadioItem1.setText("�Ȃ�");

      youngDementiaPatinetAddRadioItem1.setGroup(getYoungDementiaPatinetAddRadioGroup());

      youngDementiaPatinetAddRadioItem1.setConstraints(VRLayout.FLOW);

      addYoungDementiaPatinetAddRadioItem1();
    }
    return youngDementiaPatinetAddRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getYoungDementiaPatinetAddRadioItem2(){
    if(youngDementiaPatinetAddRadioItem2==null){

      youngDementiaPatinetAddRadioItem2 = new ACRadioButtonItem();

      youngDementiaPatinetAddRadioItem2.setText("����");

      youngDementiaPatinetAddRadioItem2.setGroup(getYoungDementiaPatinetAddRadioGroup());

      youngDementiaPatinetAddRadioItem2.setConstraints(VRLayout.FLOW);

      addYoungDementiaPatinetAddRadioItem2();
    }
    return youngDementiaPatinetAddRadioItem2;

  }

  /**
   * �F�m�ǐ��P�A���Z���擾���܂��B
   * @return �F�m�ǐ��P�A���Z
   */
  public ACValueArrayRadioButtonGroup getDementiaProfessionalCareAddRadioGroup(){
    if(dementiaProfessionalCareAddRadioGroup==null){

      dementiaProfessionalCareAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getDementiaProfessionalCareAddRadioGroupContainer().setText("�F�m�ǐ��P�A���Z");

      dementiaProfessionalCareAddRadioGroup.setBindPath("1320110");

      dementiaProfessionalCareAddRadioGroup.setVisible(true);

      dementiaProfessionalCareAddRadioGroup.setEnabled(true);

      dementiaProfessionalCareAddRadioGroup.setNoSelectIndex(0);

      dementiaProfessionalCareAddRadioGroup.setUseClearButton(false);

      dementiaProfessionalCareAddRadioGroup.setModel(getDementiaProfessionalCareAddRadioGroupModel());

      dementiaProfessionalCareAddRadioGroup.setValues(new int[]{1,2,3});

      addDementiaProfessionalCareAddRadioGroup();
    }
    return dementiaProfessionalCareAddRadioGroup;

  }

  /**
   * �F�m�ǐ��P�A���Z�R���e�i���擾���܂��B
   * @return �F�m�ǐ��P�A���Z�R���e�i
   */
  protected ACLabelContainer getDementiaProfessionalCareAddRadioGroupContainer(){
    if(dementiaProfessionalCareAddRadioGroupContainer==null){
      dementiaProfessionalCareAddRadioGroupContainer = new ACLabelContainer();
      dementiaProfessionalCareAddRadioGroupContainer.setFollowChildEnabled(true);
      dementiaProfessionalCareAddRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      dementiaProfessionalCareAddRadioGroupContainer.add(getDementiaProfessionalCareAddRadioGroup(), null);
    }
    return dementiaProfessionalCareAddRadioGroupContainer;
  }

  /**
   * �F�m�ǐ��P�A���Z���f�����擾���܂��B
   * @return �F�m�ǐ��P�A���Z���f��
   */
  protected ACListModelAdapter getDementiaProfessionalCareAddRadioGroupModel(){
    if(dementiaProfessionalCareAddRadioGroupModel==null){
      dementiaProfessionalCareAddRadioGroupModel = new ACListModelAdapter();
      addDementiaProfessionalCareAddRadioGroupModel();
    }
    return dementiaProfessionalCareAddRadioGroupModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getDementiaProfessionalCareAddRadioItem1(){
    if(dementiaProfessionalCareAddRadioItem1==null){

      dementiaProfessionalCareAddRadioItem1 = new ACRadioButtonItem();

      dementiaProfessionalCareAddRadioItem1.setText("�Ȃ�");

      dementiaProfessionalCareAddRadioItem1.setGroup(getDementiaProfessionalCareAddRadioGroup());

      dementiaProfessionalCareAddRadioItem1.setConstraints(VRLayout.FLOW);

      addDementiaProfessionalCareAddRadioItem1();
    }
    return dementiaProfessionalCareAddRadioItem1;

  }

  /**
   * I�^���擾���܂��B
   * @return I�^
   */
  public ACRadioButtonItem getDementiaProfessionalCareAddRadioItem2(){
    if(dementiaProfessionalCareAddRadioItem2==null){

      dementiaProfessionalCareAddRadioItem2 = new ACRadioButtonItem();

      dementiaProfessionalCareAddRadioItem2.setText("I�^");

      dementiaProfessionalCareAddRadioItem2.setGroup(getDementiaProfessionalCareAddRadioGroup());

      dementiaProfessionalCareAddRadioItem2.setConstraints(VRLayout.FLOW);

      addDementiaProfessionalCareAddRadioItem2();
    }
    return dementiaProfessionalCareAddRadioItem2;

  }

  /**
   * II�^���擾���܂��B
   * @return II�^
   */
  public ACRadioButtonItem getDementiaProfessionalCareAddRadioItem3(){
    if(dementiaProfessionalCareAddRadioItem3==null){

      dementiaProfessionalCareAddRadioItem3 = new ACRadioButtonItem();

      dementiaProfessionalCareAddRadioItem3.setText("II�^");

      dementiaProfessionalCareAddRadioItem3.setGroup(getDementiaProfessionalCareAddRadioGroup());

      dementiaProfessionalCareAddRadioItem3.setConstraints(VRLayout.FLOW);

      addDementiaProfessionalCareAddRadioItem3();
    }
    return dementiaProfessionalCareAddRadioItem3;

  }

  /**
   * �^�u2���擾���܂��B
   * @return �^�u2
   */
  public ACPanel getTab2(){
    if(tab2==null){

      tab2 = new ACPanel();

      tab2.setFollowChildEnabled(true);

      tab2.setHgap(0);

      addTab2();
    }
    return tab2;

  }

  /**
   * �Ŏ������Z���擾���܂��B
   * @return �Ŏ������Z
   */
  public ACValueArrayRadioButtonGroup getWatchKaigoAddRadioGroup(){
    if(watchKaigoAddRadioGroup==null){

      watchKaigoAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getWatchKaigoAddRadioGroupContainer().setText("�Ŏ������Z");

      watchKaigoAddRadioGroup.setBindPath("1320112");

      watchKaigoAddRadioGroup.setNoSelectIndex(0);

      watchKaigoAddRadioGroup.setUseClearButton(false);

      watchKaigoAddRadioGroup.setModel(getWatchKaigoAddRadioGroupModel());

      watchKaigoAddRadioGroup.setValues(new int[]{1,2,3,4});

      addWatchKaigoAddRadioGroup();
    }
    return watchKaigoAddRadioGroup;

  }

  /**
   * �Ŏ������Z�R���e�i���擾���܂��B
   * @return �Ŏ������Z�R���e�i
   */
  protected ACLabelContainer getWatchKaigoAddRadioGroupContainer(){
    if(watchKaigoAddRadioGroupContainer==null){
      watchKaigoAddRadioGroupContainer = new ACLabelContainer();
      watchKaigoAddRadioGroupContainer.setFollowChildEnabled(true);
      watchKaigoAddRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      watchKaigoAddRadioGroupContainer.add(getWatchKaigoAddRadioGroup(), null);
    }
    return watchKaigoAddRadioGroupContainer;
  }

  /**
   * �Ŏ������Z���f�����擾���܂��B
   * @return �Ŏ������Z���f��
   */
  protected ACListModelAdapter getWatchKaigoAddRadioGroupModel(){
    if(watchKaigoAddRadioGroupModel==null){
      watchKaigoAddRadioGroupModel = new ACListModelAdapter();
      addWatchKaigoAddRadioGroupModel();
    }
    return watchKaigoAddRadioGroupModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getWatchKaigoAddRadioItem1(){
    if(watchKaigoAddRadioItem1==null){

      watchKaigoAddRadioItem1 = new ACRadioButtonItem();

      watchKaigoAddRadioItem1.setText("�Ȃ�");

      watchKaigoAddRadioItem1.setGroup(getWatchKaigoAddRadioGroup());

      watchKaigoAddRadioItem1.setConstraints(VRLayout.FLOW_RETURN);

      addWatchKaigoAddRadioItem1();
    }
    return watchKaigoAddRadioItem1;

  }

  /**
   * ���S���ȑO4���ȏ�30���ȉ����擾���܂��B
   * @return ���S���ȑO4���ȏ�30���ȉ�
   */
  public ACRadioButtonItem getWatchKaigoAddRadioItem2(){
    if(watchKaigoAddRadioItem2==null){

      watchKaigoAddRadioItem2 = new ACRadioButtonItem();

      watchKaigoAddRadioItem2.setText("���S���ȑO4���ȏ�30���ȉ�");

      watchKaigoAddRadioItem2.setGroup(getWatchKaigoAddRadioGroup());

      watchKaigoAddRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

      addWatchKaigoAddRadioItem2();
    }
    return watchKaigoAddRadioItem2;

  }

  /**
   * ���S���ȑO2������3�����擾���܂��B
   * @return ���S���ȑO2������3��
   */
  public ACRadioButtonItem getWatchKaigoAddRadioItem3(){
    if(watchKaigoAddRadioItem3==null){

      watchKaigoAddRadioItem3 = new ACRadioButtonItem();

      watchKaigoAddRadioItem3.setText("���S���ȑO2������3��");

      watchKaigoAddRadioItem3.setGroup(getWatchKaigoAddRadioGroup());

      watchKaigoAddRadioItem3.setConstraints(VRLayout.FLOW_RETURN);

      addWatchKaigoAddRadioItem3();
    }
    return watchKaigoAddRadioItem3;

  }

  /**
   * ���S�����擾���܂��B
   * @return ���S��
   */
  public ACRadioButtonItem getWatchKaigoAddRadioItem4(){
    if(watchKaigoAddRadioItem4==null){

      watchKaigoAddRadioItem4 = new ACRadioButtonItem();

      watchKaigoAddRadioItem4.setText("���S��");

      watchKaigoAddRadioItem4.setGroup(getWatchKaigoAddRadioGroup());

      watchKaigoAddRadioItem4.setConstraints(VRLayout.FLOW);

      addWatchKaigoAddRadioItem4();
    }
    return watchKaigoAddRadioItem4;

  }

  /**
   * �ޏ��֘A���Z���擾���܂��B
   * @return �ޏ��֘A���Z
   */
  public ACLabelContainer getKaigoHealthCareOfTheAgedHijoAddition(){
    if(kaigoHealthCareOfTheAgedHijoAddition==null){

      kaigoHealthCareOfTheAgedHijoAddition = new ACLabelContainer();

      kaigoHealthCareOfTheAgedHijoAddition.setText("�ޏ��֘A���Z");

      addKaigoHealthCareOfTheAgedHijoAddition();
    }
    return kaigoHealthCareOfTheAgedHijoAddition;

  }

  /**
   * �ދ������k�������Z���擾���܂��B
   * @return �ދ������k�������Z
   */
  public ACIntegerCheckBox getLeaveApartmentsSupportAdd(){
    if(leaveApartmentsSupportAdd==null){

      leaveApartmentsSupportAdd = new ACIntegerCheckBox();

      leaveApartmentsSupportAdd.setText("�ދ������k�������Z");

      leaveApartmentsSupportAdd.setBindPath("1320113");

      leaveApartmentsSupportAdd.setSelectValue(2);

      leaveApartmentsSupportAdd.setUnSelectValue(1);

      addLeaveApartmentsSupportAdd();
    }
    return leaveApartmentsSupportAdd;

  }

  /**
   * �T�[�r�X�񋟑̐��������Z���擾���܂��B
   * @return �T�[�r�X�񋟑̐��������Z
   */
  public ACValueArrayRadioButtonGroup getServiceAddProvisionStructuralRadioGroup(){
    if(serviceAddProvisionStructuralRadioGroup==null){

      serviceAddProvisionStructuralRadioGroup = new ACValueArrayRadioButtonGroup();

      getServiceAddProvisionStructuralRadioGroupContainer().setText("�T�[�r�X�񋟑̐��������Z");

      serviceAddProvisionStructuralRadioGroup.setBindPath("1320111");

      serviceAddProvisionStructuralRadioGroup.setVisible(true);

      serviceAddProvisionStructuralRadioGroup.setEnabled(true);

      serviceAddProvisionStructuralRadioGroup.setNoSelectIndex(0);

      serviceAddProvisionStructuralRadioGroup.setUseClearButton(false);

      serviceAddProvisionStructuralRadioGroup.setModel(getServiceAddProvisionStructuralRadioGroupModel());

      serviceAddProvisionStructuralRadioGroup.setValues(new int[]{1,2,3,4});

      addServiceAddProvisionStructuralRadioGroup();
    }
    return serviceAddProvisionStructuralRadioGroup;

  }

  /**
   * �T�[�r�X�񋟑̐��������Z�R���e�i���擾���܂��B
   * @return �T�[�r�X�񋟑̐��������Z�R���e�i
   */
  protected ACLabelContainer getServiceAddProvisionStructuralRadioGroupContainer(){
    if(serviceAddProvisionStructuralRadioGroupContainer==null){
      serviceAddProvisionStructuralRadioGroupContainer = new ACLabelContainer();
      serviceAddProvisionStructuralRadioGroupContainer.setFollowChildEnabled(true);
      serviceAddProvisionStructuralRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      serviceAddProvisionStructuralRadioGroupContainer.add(getServiceAddProvisionStructuralRadioGroup(), null);
    }
    return serviceAddProvisionStructuralRadioGroupContainer;
  }

  /**
   * �T�[�r�X�񋟑̐��������Z���f�����擾���܂��B
   * @return �T�[�r�X�񋟑̐��������Z���f��
   */
  protected ACListModelAdapter getServiceAddProvisionStructuralRadioGroupModel(){
    if(serviceAddProvisionStructuralRadioGroupModel==null){
      serviceAddProvisionStructuralRadioGroupModel = new ACListModelAdapter();
      addServiceAddProvisionStructuralRadioGroupModel();
    }
    return serviceAddProvisionStructuralRadioGroupModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getServiceAddProvisionStructuralRadioItem1(){
    if(serviceAddProvisionStructuralRadioItem1==null){

      serviceAddProvisionStructuralRadioItem1 = new ACRadioButtonItem();

      serviceAddProvisionStructuralRadioItem1.setText("�Ȃ�");

      serviceAddProvisionStructuralRadioItem1.setGroup(getServiceAddProvisionStructuralRadioGroup());

      serviceAddProvisionStructuralRadioItem1.setConstraints(VRLayout.FLOW);

      addServiceAddProvisionStructuralRadioItem1();
    }
    return serviceAddProvisionStructuralRadioItem1;

  }

  /**
   * I�^���擾���܂��B
   * @return I�^
   */
  public ACRadioButtonItem getServiceAddProvisionStructuralRadioItem2(){
    if(serviceAddProvisionStructuralRadioItem2==null){

      serviceAddProvisionStructuralRadioItem2 = new ACRadioButtonItem();

      serviceAddProvisionStructuralRadioItem2.setText("I�^");

      serviceAddProvisionStructuralRadioItem2.setGroup(getServiceAddProvisionStructuralRadioGroup());

      serviceAddProvisionStructuralRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

      addServiceAddProvisionStructuralRadioItem2();
    }
    return serviceAddProvisionStructuralRadioItem2;

  }

  /**
   * II�^���擾���܂��B
   * @return II�^
   */
  public ACRadioButtonItem getServiceAddProvisionStructuralRadioItem3(){
    if(serviceAddProvisionStructuralRadioItem3==null){

      serviceAddProvisionStructuralRadioItem3 = new ACRadioButtonItem();

      serviceAddProvisionStructuralRadioItem3.setText("II�^");

      serviceAddProvisionStructuralRadioItem3.setGroup(getServiceAddProvisionStructuralRadioGroup());

      serviceAddProvisionStructuralRadioItem3.setConstraints(VRLayout.FLOW);

      addServiceAddProvisionStructuralRadioItem3();
    }
    return serviceAddProvisionStructuralRadioItem3;

  }

  /**
   * III�^���擾���܂��B
   * @return III�^
   */
  public ACRadioButtonItem getServiceAddProvisionStructuralRadioItem4(){
    if(serviceAddProvisionStructuralRadioItem4==null){

      serviceAddProvisionStructuralRadioItem4 = new ACRadioButtonItem();

      serviceAddProvisionStructuralRadioItem4.setText("III�^");

      serviceAddProvisionStructuralRadioItem4.setGroup(getServiceAddProvisionStructuralRadioGroup());

      serviceAddProvisionStructuralRadioItem4.setConstraints(VRLayout.FLOW);

      addServiceAddProvisionStructuralRadioItem4();
    }
    return serviceAddProvisionStructuralRadioItem4;

  }

  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001_13211_201204Design() {

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

    this.add(getTabs(), VRLayout.CLIENT);

  }

  /**
   * �^�u�y�C���ɓ������ڂ�ǉ����܂��B
   */
  protected void addTabs(){

    tabs.addTab("1", getTab1());

    tabs.addTab("2", getTab2());

  }

  /**
   * �^�u1�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTab1(){

    tab1.add(getProviderDivisionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getTypeSymbiosisNursingForDementiaDefaultRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getTypeSymbiosisNursingForDementiaSubtractionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getNightWorkConditionStandardRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getMedicalCooperationSystemAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getNightCareAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getYoungDementiaPatinetAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getDementiaProfessionalCareAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

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
   * ��ԃP�A���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addNightCareAddRadioGroup(){

  }

  /**
   * ��ԃP�A���Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addNightCareAddRadioGroupModel(){

    getNightCareAddRadioItem1().setButtonIndex(1);

    getNightCareAddRadioGroupModel().add(getNightCareAddRadioItem1());

    getNightCareAddRadioItem2().setButtonIndex(2);

    getNightCareAddRadioGroupModel().add(getNightCareAddRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addNightCareAddRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addNightCareAddRadioItem2(){

  }

  /**
   * ��N���F�m�Ǘ��p�Ҏ�����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addYoungDementiaPatinetAddRadioGroup(){

  }

  /**
   * ��N���F�m�Ǘ��p�Ҏ�����Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addYoungDementiaPatinetAddRadioGroupModel(){

    getYoungDementiaPatinetAddRadioItem1().setButtonIndex(1);

    getYoungDementiaPatinetAddRadioGroupModel().add(getYoungDementiaPatinetAddRadioItem1());

    getYoungDementiaPatinetAddRadioItem2().setButtonIndex(2);

    getYoungDementiaPatinetAddRadioGroupModel().add(getYoungDementiaPatinetAddRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addYoungDementiaPatinetAddRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addYoungDementiaPatinetAddRadioItem2(){

  }

  /**
   * �F�m�ǐ��P�A���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addDementiaProfessionalCareAddRadioGroup(){

  }

  /**
   * �F�m�ǐ��P�A���Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addDementiaProfessionalCareAddRadioGroupModel(){

    getDementiaProfessionalCareAddRadioItem1().setButtonIndex(1);

    getDementiaProfessionalCareAddRadioGroupModel().add(getDementiaProfessionalCareAddRadioItem1());

    getDementiaProfessionalCareAddRadioItem2().setButtonIndex(2);

    getDementiaProfessionalCareAddRadioGroupModel().add(getDementiaProfessionalCareAddRadioItem2());

    getDementiaProfessionalCareAddRadioItem3().setButtonIndex(3);

    getDementiaProfessionalCareAddRadioGroupModel().add(getDementiaProfessionalCareAddRadioItem3());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addDementiaProfessionalCareAddRadioItem1(){

  }

  /**
   * I�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addDementiaProfessionalCareAddRadioItem2(){

  }

  /**
   * II�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addDementiaProfessionalCareAddRadioItem3(){

  }

  /**
   * �^�u2�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTab2(){

    tab2.add(getWatchKaigoAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getKaigoHealthCareOfTheAgedHijoAddition(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getServiceAddProvisionStructuralRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * �Ŏ������Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addWatchKaigoAddRadioGroup(){

  }

  /**
   * �Ŏ������Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addWatchKaigoAddRadioGroupModel(){

    getWatchKaigoAddRadioItem1().setButtonIndex(1);

    getWatchKaigoAddRadioGroupModel().add(getWatchKaigoAddRadioItem1());

    getWatchKaigoAddRadioItem2().setButtonIndex(2);

    getWatchKaigoAddRadioGroupModel().add(getWatchKaigoAddRadioItem2());

    getWatchKaigoAddRadioItem3().setButtonIndex(3);

    getWatchKaigoAddRadioGroupModel().add(getWatchKaigoAddRadioItem3());

    getWatchKaigoAddRadioItem4().setButtonIndex(4);

    getWatchKaigoAddRadioGroupModel().add(getWatchKaigoAddRadioItem4());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addWatchKaigoAddRadioItem1(){

  }

  /**
   * ���S���ȑO4���ȏ�30���ȉ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addWatchKaigoAddRadioItem2(){

  }

  /**
   * ���S���ȑO2������3���ɓ������ڂ�ǉ����܂��B
   */
  protected void addWatchKaigoAddRadioItem3(){

  }

  /**
   * ���S���ɓ������ڂ�ǉ����܂��B
   */
  protected void addWatchKaigoAddRadioItem4(){

  }

  /**
   * �ޏ��֘A���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoHealthCareOfTheAgedHijoAddition(){

    kaigoHealthCareOfTheAgedHijoAddition.add(getLeaveApartmentsSupportAdd(), VRLayout.FLOW_RETURN);

  }

  /**
   * �ދ������k�������Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addLeaveApartmentsSupportAdd(){

  }

  /**
   * �T�[�r�X�񋟑̐��������Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceAddProvisionStructuralRadioGroup(){

  }

  /**
   * �T�[�r�X�񋟑̐��������Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceAddProvisionStructuralRadioGroupModel(){

    getServiceAddProvisionStructuralRadioItem1().setButtonIndex(1);

    getServiceAddProvisionStructuralRadioGroupModel().add(getServiceAddProvisionStructuralRadioItem1());

    getServiceAddProvisionStructuralRadioItem2().setButtonIndex(2);

    getServiceAddProvisionStructuralRadioGroupModel().add(getServiceAddProvisionStructuralRadioItem2());

    getServiceAddProvisionStructuralRadioItem3().setButtonIndex(3);

    getServiceAddProvisionStructuralRadioGroupModel().add(getServiceAddProvisionStructuralRadioItem3());

    getServiceAddProvisionStructuralRadioItem4().setButtonIndex(4);

    getServiceAddProvisionStructuralRadioGroupModel().add(getServiceAddProvisionStructuralRadioItem4());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceAddProvisionStructuralRadioItem1(){

  }

  /**
   * I�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceAddProvisionStructuralRadioItem2(){

  }

  /**
   * II�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceAddProvisionStructuralRadioItem3(){

  }

  /**
   * III�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceAddProvisionStructuralRadioItem4(){

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
      ACFrame.debugStart(new ACAffairInfo(QS001_13211_201204Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QS001_13211_201204Design getThis() {
    return this;
  }
}
