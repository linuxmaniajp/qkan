
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
 * �쐬��: 2015/02/19  ���{�R���s���[�^�[������� ����@��F �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �T�[�r�X�\��쐬/�ύX (S)
 * �v���Z�X �T�[�r�X�\��T�� (001)
 * �v���O���� �T�[�r�X�p�^�[�����\�h����×{�Ǘ��w�� (QS001_13411_201504)
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
 * �T�[�r�X�p�^�[�����\�h����×{�Ǘ��w����ʍ��ڃf�U�C��(QS001_13411_201504) 
 */
public class QS001_13411_201504Design extends QS001ServicePanel {
  //GUI�R���|�[�l���g

  private ACPanel recuperationManagementGuidancePatterns;

  private JTabbedPane tabs;

  private ACPanel tab1;

  private ACValueArrayRadioButtonGroup chargeClassificationRadioGroup;

  private ACLabelContainer chargeClassificationRadioGroupContainer;

  private ACListModelAdapter chargeClassificationRadioGroupModel;

  private ACRadioButtonItem chargeClassificationRadioItem1;

  private ACRadioButtonItem chargeClassificationRadioItem2;

  private ACRadioButtonItem chargeClassificationRadioItem3;

  private ACRadioButtonItem chargeClassificationRadioItem4;

  private ACRadioButtonItem chargeClassificationRadioItem5;

  private ACRadioButtonItem chargeClassificationRadioItem6;

  private ACRadioButtonItem chargeClassificationRadioItem7;

  private ACValueArrayRadioButtonGroup medicineManagementRadioGroup;

  private ACLabelContainer medicineManagementRadioGroupContainer;

  private ACListModelAdapter medicineManagementRadioGroupModel;

  private ACRadioButtonItem medicineManagementRadioItem1;

  private ACRadioButtonItem medicineManagementRadioItem2;

  private ACGroupBox patientGroup;

  private ACValueArrayRadioButtonGroup patientDivisionRadio;

  private ACLabelContainer patientDivisionRadioContainer;

  private ACListModelAdapter patientDivisionRadioModel;

  private ACRadioButtonItem patientDivisionRadioItem1;

  private ACRadioButtonItem patientDivisionRadioItem2;

  private ACIntegerCheckBox recuperationManagementGuidanceTimesCancerEndCheck;

  private ACPanel tab2;

  private ACValueArrayRadioButtonGroup specialMedicineRadioGroup;

  private ACLabelContainer specialMedicineRadioGroupContainer;

  private ACListModelAdapter specialMedicineRadioGroupModel;

  private ACRadioButtonItem specialMedicineRadioItem1;

  private ACRadioButtonItem specialMedicineRadioItem2;

  private ACValueArrayRadioButtonGroup kyotakuClass;

  private ACLabelContainer kyotakuClassContainer;

  private ACListModelAdapter kyotakuClassModel;

  private ACRadioButtonItem kyotakuClass1;

  private ACRadioButtonItem kyotakuClass2;

  private ACBackLabelContainer recuperationManagementGuidanceTimeContena;

  private ACTimeComboBox recuperationManagementGuidanceBeginTime;

  private ACLabelContainer recuperationManagementGuidanceBeginTimeContainer;

  private ACComboBoxModelAdapter recuperationManagementGuidanceBeginTimeModel;

  private ACTimeComboBox recuperationManagementGuidanceEndTime;

  private ACLabelContainer recuperationManagementGuidanceEndTimeContainer;

  private ACComboBoxModelAdapter recuperationManagementGuidanceEndTimeModel;

  //getter

  /**
   * ����×{�Ǘ��w���p�^�[���̈���擾���܂��B
   * @return ����×{�Ǘ��w���p�^�[���̈�
   */
  public ACPanel getRecuperationManagementGuidancePatterns(){
    if(recuperationManagementGuidancePatterns==null){

      recuperationManagementGuidancePatterns = new ACPanel();

      recuperationManagementGuidancePatterns.setAutoWrap(false);

      recuperationManagementGuidancePatterns.setFollowChildEnabled(true);

      recuperationManagementGuidancePatterns.setHgap(0);

      recuperationManagementGuidancePatterns.setHgrid(200);

      addRecuperationManagementGuidancePatterns();
    }
    return recuperationManagementGuidancePatterns;

  }

  /**
   * �^�u���擾���܂��B
   * @return �^�u
   */
  public JTabbedPane getTabs(){
    if(tabs==null){

      tabs = new JTabbedPane();

      addTabs();
    }
    return tabs;

  }

  /**
   * �^�u�P���擾���܂��B
   * @return �^�u�P
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
   * �S���ҋ敪���擾���܂��B
   * @return �S���ҋ敪
   */
  public ACValueArrayRadioButtonGroup getChargeClassificationRadioGroup(){
    if(chargeClassificationRadioGroup==null){

      chargeClassificationRadioGroup = new ACValueArrayRadioButtonGroup();

      getChargeClassificationRadioGroupContainer().setText("�S���ҋ敪");

      chargeClassificationRadioGroup.setBindPath("1340108");

      chargeClassificationRadioGroup.setNoSelectIndex(0);

      chargeClassificationRadioGroup.setUseClearButton(false);

      chargeClassificationRadioGroup.setModel(getChargeClassificationRadioGroupModel());

      chargeClassificationRadioGroup.setValues(new int[]{1,2,3,4,5,6,7});

      addChargeClassificationRadioGroup();
    }
    return chargeClassificationRadioGroup;

  }

  /**
   * �S���ҋ敪�R���e�i���擾���܂��B
   * @return �S���ҋ敪�R���e�i
   */
  protected ACLabelContainer getChargeClassificationRadioGroupContainer(){
    if(chargeClassificationRadioGroupContainer==null){
      chargeClassificationRadioGroupContainer = new ACLabelContainer();
      chargeClassificationRadioGroupContainer.setFollowChildEnabled(true);
      chargeClassificationRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      chargeClassificationRadioGroupContainer.add(getChargeClassificationRadioGroup(), null);
    }
    return chargeClassificationRadioGroupContainer;
  }

  /**
   * �S���ҋ敪���f�����擾���܂��B
   * @return �S���ҋ敪���f��
   */
  protected ACListModelAdapter getChargeClassificationRadioGroupModel(){
    if(chargeClassificationRadioGroupModel==null){
      chargeClassificationRadioGroupModel = new ACListModelAdapter();
      addChargeClassificationRadioGroupModel();
    }
    return chargeClassificationRadioGroupModel;
  }

  /**
   * ��t���擾���܂��B
   * @return ��t
   */
  public ACRadioButtonItem getChargeClassificationRadioItem1(){
    if(chargeClassificationRadioItem1==null){

      chargeClassificationRadioItem1 = new ACRadioButtonItem();

      chargeClassificationRadioItem1.setText("��t");

      chargeClassificationRadioItem1.setGroup(getChargeClassificationRadioGroup());

      chargeClassificationRadioItem1.setConstraints(VRLayout.FLOW);

      addChargeClassificationRadioItem1();
    }
    return chargeClassificationRadioItem1;

  }

  /**
   * ���Ȉ�t���擾���܂��B
   * @return ���Ȉ�t
   */
  public ACRadioButtonItem getChargeClassificationRadioItem2(){
    if(chargeClassificationRadioItem2==null){

      chargeClassificationRadioItem2 = new ACRadioButtonItem();

      chargeClassificationRadioItem2.setText("���Ȉ�t");

      chargeClassificationRadioItem2.setGroup(getChargeClassificationRadioGroup());

      chargeClassificationRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

      addChargeClassificationRadioItem2();
    }
    return chargeClassificationRadioItem2;

  }

  /**
   * ��܎t�i��Ë@�ցj���擾���܂��B
   * @return ��܎t�i��Ë@�ցj
   */
  public ACRadioButtonItem getChargeClassificationRadioItem3(){
    if(chargeClassificationRadioItem3==null){

      chargeClassificationRadioItem3 = new ACRadioButtonItem();

      chargeClassificationRadioItem3.setText("��܎t�i��Ë@�ցj");

      chargeClassificationRadioItem3.setGroup(getChargeClassificationRadioGroup());

      chargeClassificationRadioItem3.setConstraints(VRLayout.FLOW_RETURN);

      addChargeClassificationRadioItem3();
    }
    return chargeClassificationRadioItem3;

  }

  /**
   * ��܎t�i��ǁj���擾���܂��B
   * @return ��܎t�i��ǁj
   */
  public ACRadioButtonItem getChargeClassificationRadioItem4(){
    if(chargeClassificationRadioItem4==null){

      chargeClassificationRadioItem4 = new ACRadioButtonItem();

      chargeClassificationRadioItem4.setText("��܎t�i��ǁj");

      chargeClassificationRadioItem4.setGroup(getChargeClassificationRadioGroup());

      chargeClassificationRadioItem4.setConstraints(VRLayout.FLOW_RETURN);

      addChargeClassificationRadioItem4();
    }
    return chargeClassificationRadioItem4;

  }

  /**
   * �Ǘ��h�{�m���擾���܂��B
   * @return �Ǘ��h�{�m
   */
  public ACRadioButtonItem getChargeClassificationRadioItem5(){
    if(chargeClassificationRadioItem5==null){

      chargeClassificationRadioItem5 = new ACRadioButtonItem();

      chargeClassificationRadioItem5.setText("�Ǘ��h�{�m");

      chargeClassificationRadioItem5.setGroup(getChargeClassificationRadioGroup());

      chargeClassificationRadioItem5.setConstraints(VRLayout.FLOW);

      addChargeClassificationRadioItem5();
    }
    return chargeClassificationRadioItem5;

  }

  /**
   * ���ȉq���m�����擾���܂��B
   * @return ���ȉq���m��
   */
  public ACRadioButtonItem getChargeClassificationRadioItem6(){
    if(chargeClassificationRadioItem6==null){

      chargeClassificationRadioItem6 = new ACRadioButtonItem();

      chargeClassificationRadioItem6.setText("���ȉq���m��");

      chargeClassificationRadioItem6.setGroup(getChargeClassificationRadioGroup());

      chargeClassificationRadioItem6.setConstraints(VRLayout.FLOW_RETURN);

      addChargeClassificationRadioItem6();
    }
    return chargeClassificationRadioItem6;

  }

  /**
   * �Ō�E�����擾���܂��B
   * @return �Ō�E��
   */
  public ACRadioButtonItem getChargeClassificationRadioItem7(){
    if(chargeClassificationRadioItem7==null){

      chargeClassificationRadioItem7 = new ACRadioButtonItem();

      chargeClassificationRadioItem7.setText("�Ō�E��");

      chargeClassificationRadioItem7.setGroup(getChargeClassificationRadioGroup());

      chargeClassificationRadioItem7.setConstraints(VRLayout.FLOW_RETURN);

      addChargeClassificationRadioItem7();
    }
    return chargeClassificationRadioItem7;

  }

  /**
   * ��w�����Ǘ������擾���܂��B
   * @return ��w�����Ǘ���
   */
  public ACValueArrayRadioButtonGroup getMedicineManagementRadioGroup(){
    if(medicineManagementRadioGroup==null){

      medicineManagementRadioGroup = new ACValueArrayRadioButtonGroup();

      getMedicineManagementRadioGroupContainer().setText("��w�����Ǘ���");

      medicineManagementRadioGroup.setBindPath("1340102");

      medicineManagementRadioGroup.setUseClearButton(false);

      medicineManagementRadioGroup.setModel(getMedicineManagementRadioGroupModel());

      medicineManagementRadioGroup.setValues(new int[]{1,2});

      addMedicineManagementRadioGroup();
    }
    return medicineManagementRadioGroup;

  }

  /**
   * ��w�����Ǘ����R���e�i���擾���܂��B
   * @return ��w�����Ǘ����R���e�i
   */
  protected ACLabelContainer getMedicineManagementRadioGroupContainer(){
    if(medicineManagementRadioGroupContainer==null){
      medicineManagementRadioGroupContainer = new ACLabelContainer();
      medicineManagementRadioGroupContainer.setFollowChildEnabled(true);
      medicineManagementRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      medicineManagementRadioGroupContainer.add(getMedicineManagementRadioGroup(), null);
    }
    return medicineManagementRadioGroupContainer;
  }

  /**
   * ��w�����Ǘ������f�����擾���܂��B
   * @return ��w�����Ǘ������f��
   */
  protected ACListModelAdapter getMedicineManagementRadioGroupModel(){
    if(medicineManagementRadioGroupModel==null){
      medicineManagementRadioGroupModel = new ACListModelAdapter();
      addMedicineManagementRadioGroupModel();
    }
    return medicineManagementRadioGroupModel;
  }

  /**
   * �Ȃ��i�w���� ( I ) �j���擾���܂��B
   * @return �Ȃ��i�w���� ( I ) �j
   */
  public ACRadioButtonItem getMedicineManagementRadioItem1(){
    if(medicineManagementRadioItem1==null){

      medicineManagementRadioItem1 = new ACRadioButtonItem();

      medicineManagementRadioItem1.setText("�Ȃ��i�w���� ( I ) �j");

      medicineManagementRadioItem1.setGroup(getMedicineManagementRadioGroup());

      medicineManagementRadioItem1.setConstraints(VRLayout.FLOW_RETURN);

      addMedicineManagementRadioItem1();
    }
    return medicineManagementRadioItem1;

  }

  /**
   * ����i�w���� ( II ) �j���擾���܂��B
   * @return ����i�w���� ( II ) �j
   */
  public ACRadioButtonItem getMedicineManagementRadioItem2(){
    if(medicineManagementRadioItem2==null){

      medicineManagementRadioItem2 = new ACRadioButtonItem();

      medicineManagementRadioItem2.setText("����i�w���� ( II ) �j");

      medicineManagementRadioItem2.setGroup(getMedicineManagementRadioGroup());

      medicineManagementRadioItem2.setConstraints(VRLayout.FLOW);

      addMedicineManagementRadioItem2();
    }
    return medicineManagementRadioItem2;

  }

  /**
   * ���p�ҋ敪���擾���܂��B
   * @return ���p�ҋ敪
   */
  public ACGroupBox getPatientGroup(){
    if(patientGroup==null){

      patientGroup = new ACGroupBox();

      patientGroup.setText("���p�҃T�[�r�X�敪");

      patientGroup.setFollowChildEnabled(true);

      addPatientGroup();
    }
    return patientGroup;

  }

  /**
   * ���ݒn�敪���擾���܂��B
   * @return ���ݒn�敪
   */
  public ACValueArrayRadioButtonGroup getPatientDivisionRadio(){
    if(patientDivisionRadio==null){

      patientDivisionRadio = new ACValueArrayRadioButtonGroup();

      getPatientDivisionRadioContainer().setText("���ݒn�敪");

      patientDivisionRadio.setBindPath("16");

      patientDivisionRadio.setNoSelectIndex(0);

      patientDivisionRadio.setUseClearButton(false);

      patientDivisionRadio.setModel(getPatientDivisionRadioModel());

      patientDivisionRadio.setValues(new int[]{1,2});

      addPatientDivisionRadio();
    }
    return patientDivisionRadio;

  }

  /**
   * ���ݒn�敪�R���e�i���擾���܂��B
   * @return ���ݒn�敪�R���e�i
   */
  protected ACLabelContainer getPatientDivisionRadioContainer(){
    if(patientDivisionRadioContainer==null){
      patientDivisionRadioContainer = new ACLabelContainer();
      patientDivisionRadioContainer.setFollowChildEnabled(true);
      patientDivisionRadioContainer.setVAlignment(VRLayout.CENTER);
      patientDivisionRadioContainer.add(getPatientDivisionRadio(), null);
    }
    return patientDivisionRadioContainer;
  }

  /**
   * ���ݒn�敪���f�����擾���܂��B
   * @return ���ݒn�敪���f��
   */
  protected ACListModelAdapter getPatientDivisionRadioModel(){
    if(patientDivisionRadioModel==null){
      patientDivisionRadioModel = new ACListModelAdapter();
      addPatientDivisionRadioModel();
    }
    return patientDivisionRadioModel;
  }

  /**
   * ���ꌚ�����Z�҈ȊO���擾���܂��B
   * @return ���ꌚ�����Z�҈ȊO
   */
  public ACRadioButtonItem getPatientDivisionRadioItem1(){
    if(patientDivisionRadioItem1==null){

      patientDivisionRadioItem1 = new ACRadioButtonItem();

      patientDivisionRadioItem1.setText("<html>���ꌚ�����Z�҈ȊO<br>�i�w����F( I ) 503�P�ʁ^( II ) 292�P�ʁj<html>");

      patientDivisionRadioItem1.setGroup(getPatientDivisionRadio());

      patientDivisionRadioItem1.setConstraints(VRLayout.FLOW_RETURN);

      addPatientDivisionRadioItem1();
    }
    return patientDivisionRadioItem1;

  }

  /**
   * ���ꌚ�����Z�҂��擾���܂��B
   * @return ���ꌚ�����Z��
   */
  public ACRadioButtonItem getPatientDivisionRadioItem2(){
    if(patientDivisionRadioItem2==null){

      patientDivisionRadioItem2 = new ACRadioButtonItem();

      patientDivisionRadioItem2.setText("<html>���ꌚ�����Z��<br>�i�w����F( I ) 452�P�ʁ^( II ) 262�P�ʁj<html>");

      patientDivisionRadioItem2.setGroup(getPatientDivisionRadio());

      patientDivisionRadioItem2.setConstraints(VRLayout.FLOW);

      addPatientDivisionRadioItem2();
    }
    return patientDivisionRadioItem2;

  }

  /**
   * �K�����������擾���܂��B
   * @return �K��������
   */
  public ACIntegerCheckBox getRecuperationManagementGuidanceTimesCancerEndCheck(){
    if(recuperationManagementGuidanceTimesCancerEndCheck==null){

      recuperationManagementGuidanceTimesCancerEndCheck = new ACIntegerCheckBox();

      recuperationManagementGuidanceTimesCancerEndCheck.setText("�K��������");

      recuperationManagementGuidanceTimesCancerEndCheck.setBindPath("1340107");

      recuperationManagementGuidanceTimesCancerEndCheck.setSelectValue(2);

      recuperationManagementGuidanceTimesCancerEndCheck.setUnSelectValue(1);

      addRecuperationManagementGuidanceTimesCancerEndCheck();
    }
    return recuperationManagementGuidanceTimesCancerEndCheck;

  }

  /**
   * �^�u�Q���擾���܂��B
   * @return �^�u�Q
   */
  public ACPanel getTab2(){
    if(tab2==null){

      tab2 = new ACPanel();

      tab2.setFollowChildEnabled(true);

      tab2.setHgap(0);

      tab2.setLabelMargin(0);

      tab2.setVgap(0);

      addTab2();
    }
    return tab2;

  }

  /**
   * ���ʖ�܂��擾���܂��B
   * @return ���ʖ��
   */
  public ACValueArrayRadioButtonGroup getSpecialMedicineRadioGroup(){
    if(specialMedicineRadioGroup==null){

      specialMedicineRadioGroup = new ACValueArrayRadioButtonGroup();

      getSpecialMedicineRadioGroupContainer().setText("���ʖ��");

      specialMedicineRadioGroup.setBindPath("1340103");

      specialMedicineRadioGroup.setUseClearButton(false);

      specialMedicineRadioGroup.setModel(getSpecialMedicineRadioGroupModel());

      specialMedicineRadioGroup.setValues(new int[]{1,2});

      addSpecialMedicineRadioGroup();
    }
    return specialMedicineRadioGroup;

  }

  /**
   * ���ʖ�܃R���e�i���擾���܂��B
   * @return ���ʖ�܃R���e�i
   */
  protected ACLabelContainer getSpecialMedicineRadioGroupContainer(){
    if(specialMedicineRadioGroupContainer==null){
      specialMedicineRadioGroupContainer = new ACLabelContainer();
      specialMedicineRadioGroupContainer.setFollowChildEnabled(true);
      specialMedicineRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      specialMedicineRadioGroupContainer.add(getSpecialMedicineRadioGroup(), null);
    }
    return specialMedicineRadioGroupContainer;
  }

  /**
   * ���ʖ�܃��f�����擾���܂��B
   * @return ���ʖ�܃��f��
   */
  protected ACListModelAdapter getSpecialMedicineRadioGroupModel(){
    if(specialMedicineRadioGroupModel==null){
      specialMedicineRadioGroupModel = new ACListModelAdapter();
      addSpecialMedicineRadioGroupModel();
    }
    return specialMedicineRadioGroupModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getSpecialMedicineRadioItem1(){
    if(specialMedicineRadioItem1==null){

      specialMedicineRadioItem1 = new ACRadioButtonItem();

      specialMedicineRadioItem1.setText("�Ȃ�");

      specialMedicineRadioItem1.setGroup(getSpecialMedicineRadioGroup());

      specialMedicineRadioItem1.setConstraints(VRLayout.FLOW);

      addSpecialMedicineRadioItem1();
    }
    return specialMedicineRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getSpecialMedicineRadioItem2(){
    if(specialMedicineRadioItem2==null){

      specialMedicineRadioItem2 = new ACRadioButtonItem();

      specialMedicineRadioItem2.setText("����");

      specialMedicineRadioItem2.setGroup(getSpecialMedicineRadioGroup());

      specialMedicineRadioItem2.setConstraints(VRLayout.FLOW);

      addSpecialMedicineRadioItem2();
    }
    return specialMedicineRadioItem2;

  }

  /**
   * �Ō�E���敪���擾���܂��B
   * @return �Ō�E���敪
   */
  public ACValueArrayRadioButtonGroup getKyotakuClass(){
    if(kyotakuClass==null){

      kyotakuClass = new ACValueArrayRadioButtonGroup();

      getKyotakuClassContainer().setText("�Ō�E���敪");

      kyotakuClass.setBindPath("1340109");

      kyotakuClass.setUseClearButton(false);

      kyotakuClass.setModel(getKyotakuClassModel());

      kyotakuClass.setValues(new int[]{1,2});

      addKyotakuClass();
    }
    return kyotakuClass;

  }

  /**
   * �Ō�E���敪�R���e�i���擾���܂��B
   * @return �Ō�E���敪�R���e�i
   */
  protected ACLabelContainer getKyotakuClassContainer(){
    if(kyotakuClassContainer==null){
      kyotakuClassContainer = new ACLabelContainer();
      kyotakuClassContainer.setFollowChildEnabled(true);
      kyotakuClassContainer.setVAlignment(VRLayout.CENTER);
      kyotakuClassContainer.add(getKyotakuClass(), null);
    }
    return kyotakuClassContainer;
  }

  /**
   * �Ō�E���敪���f�����擾���܂��B
   * @return �Ō�E���敪���f��
   */
  protected ACListModelAdapter getKyotakuClassModel(){
    if(kyotakuClassModel==null){
      kyotakuClassModel = new ACListModelAdapter();
      addKyotakuClassModel();
    }
    return kyotakuClassModel;
  }

  /**
   * ���œ����擾���܂��B
   * @return ���œ�
   */
  public ACRadioButtonItem getKyotakuClass1(){
    if(kyotakuClass1==null){

      kyotakuClass1 = new ACRadioButtonItem();

      kyotakuClass1.setText("���œ�");

      kyotakuClass1.setGroup(getKyotakuClass());

      addKyotakuClass1();
    }
    return kyotakuClass1;

  }

  /**
   * �y�ł��擾���܂��B
   * @return �y��
   */
  public ACRadioButtonItem getKyotakuClass2(){
    if(kyotakuClass2==null){

      kyotakuClass2 = new ACRadioButtonItem();

      kyotakuClass2.setText("�y��");

      kyotakuClass2.setGroup(getKyotakuClass());

      addKyotakuClass2();
    }
    return kyotakuClass2;

  }

  /**
   * �񋟎��ԃR���e�i���擾���܂��B
   * @return �񋟎��ԃR���e�i
   */
  public ACBackLabelContainer getRecuperationManagementGuidanceTimeContena(){
    if(recuperationManagementGuidanceTimeContena==null){

      recuperationManagementGuidanceTimeContena = new ACBackLabelContainer();

      recuperationManagementGuidanceTimeContena.setFollowChildEnabled(true);

      addRecuperationManagementGuidanceTimeContena();
    }
    return recuperationManagementGuidanceTimeContena;

  }

  /**
   * �J�n�����R���{���擾���܂��B
   * @return �J�n�����R���{
   */
  public ACTimeComboBox getRecuperationManagementGuidanceBeginTime(){
    if(recuperationManagementGuidanceBeginTime==null){

      recuperationManagementGuidanceBeginTime = new ACTimeComboBox();

      getRecuperationManagementGuidanceBeginTimeContainer().setText("�J�n����");

      recuperationManagementGuidanceBeginTime.setBindPath("3");

      recuperationManagementGuidanceBeginTime.setModelBindPath("3");

      recuperationManagementGuidanceBeginTime.setRenderBindPath("CONTENT");

      recuperationManagementGuidanceBeginTime.setModel(getRecuperationManagementGuidanceBeginTimeModel());

      addRecuperationManagementGuidanceBeginTime();
    }
    return recuperationManagementGuidanceBeginTime;

  }

  /**
   * �J�n�����R���{�R���e�i���擾���܂��B
   * @return �J�n�����R���{�R���e�i
   */
  protected ACLabelContainer getRecuperationManagementGuidanceBeginTimeContainer(){
    if(recuperationManagementGuidanceBeginTimeContainer==null){
      recuperationManagementGuidanceBeginTimeContainer = new ACLabelContainer();
      recuperationManagementGuidanceBeginTimeContainer.setFollowChildEnabled(true);
      recuperationManagementGuidanceBeginTimeContainer.setVAlignment(VRLayout.CENTER);
      recuperationManagementGuidanceBeginTimeContainer.add(getRecuperationManagementGuidanceBeginTime(), null);
    }
    return recuperationManagementGuidanceBeginTimeContainer;
  }

  /**
   * �J�n�����R���{���f�����擾���܂��B
   * @return �J�n�����R���{���f��
   */
  protected ACComboBoxModelAdapter getRecuperationManagementGuidanceBeginTimeModel(){
    if(recuperationManagementGuidanceBeginTimeModel==null){
      recuperationManagementGuidanceBeginTimeModel = new ACComboBoxModelAdapter();
      addRecuperationManagementGuidanceBeginTimeModel();
    }
    return recuperationManagementGuidanceBeginTimeModel;
  }

  /**
   * �I�������R���{���擾���܂��B
   * @return �I�������R���{
   */
  public ACTimeComboBox getRecuperationManagementGuidanceEndTime(){
    if(recuperationManagementGuidanceEndTime==null){

      recuperationManagementGuidanceEndTime = new ACTimeComboBox();

      getRecuperationManagementGuidanceEndTimeContainer().setText("�I������");

      recuperationManagementGuidanceEndTime.setBindPath("4");

      recuperationManagementGuidanceEndTime.setModelBindPath("4");

      recuperationManagementGuidanceEndTime.setRenderBindPath("CONTENT");

      recuperationManagementGuidanceEndTime.setModel(getRecuperationManagementGuidanceEndTimeModel());

      addRecuperationManagementGuidanceEndTime();
    }
    return recuperationManagementGuidanceEndTime;

  }

  /**
   * �I�������R���{�R���e�i���擾���܂��B
   * @return �I�������R���{�R���e�i
   */
  protected ACLabelContainer getRecuperationManagementGuidanceEndTimeContainer(){
    if(recuperationManagementGuidanceEndTimeContainer==null){
      recuperationManagementGuidanceEndTimeContainer = new ACLabelContainer();
      recuperationManagementGuidanceEndTimeContainer.setFollowChildEnabled(true);
      recuperationManagementGuidanceEndTimeContainer.setVAlignment(VRLayout.CENTER);
      recuperationManagementGuidanceEndTimeContainer.add(getRecuperationManagementGuidanceEndTime(), null);
    }
    return recuperationManagementGuidanceEndTimeContainer;
  }

  /**
   * �I�������R���{���f�����擾���܂��B
   * @return �I�������R���{���f��
   */
  protected ACComboBoxModelAdapter getRecuperationManagementGuidanceEndTimeModel(){
    if(recuperationManagementGuidanceEndTimeModel==null){
      recuperationManagementGuidanceEndTimeModel = new ACComboBoxModelAdapter();
      addRecuperationManagementGuidanceEndTimeModel();
    }
    return recuperationManagementGuidanceEndTimeModel;
  }

  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001_13411_201504Design() {

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

    this.add(getRecuperationManagementGuidancePatterns(), VRLayout.CLIENT);

  }

  /**
   * ����×{�Ǘ��w���p�^�[���̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addRecuperationManagementGuidancePatterns(){

    recuperationManagementGuidancePatterns.add(getTabs(), VRLayout.CLIENT);

  }

  /**
   * �^�u�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTabs(){

    tabs.addTab("1", getTab1());

    tabs.addTab("2", getTab2());

  }

  /**
   * �^�u�P�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTab1(){

    tab1.add(getChargeClassificationRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getMedicineManagementRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getPatientGroup(), VRLayout.FLOW_RETURN);

  }

  /**
   * �S���ҋ敪�ɓ������ڂ�ǉ����܂��B
   */
  protected void addChargeClassificationRadioGroup(){

  }

  /**
   * �S���ҋ敪���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addChargeClassificationRadioGroupModel(){

    getChargeClassificationRadioItem1().setButtonIndex(1);

    getChargeClassificationRadioGroupModel().add(getChargeClassificationRadioItem1());

    getChargeClassificationRadioItem2().setButtonIndex(2);

    getChargeClassificationRadioGroupModel().add(getChargeClassificationRadioItem2());

    getChargeClassificationRadioItem3().setButtonIndex(3);

    getChargeClassificationRadioGroupModel().add(getChargeClassificationRadioItem3());

    getChargeClassificationRadioItem4().setButtonIndex(4);

    getChargeClassificationRadioGroupModel().add(getChargeClassificationRadioItem4());

    getChargeClassificationRadioItem5().setButtonIndex(5);

    getChargeClassificationRadioGroupModel().add(getChargeClassificationRadioItem5());

    getChargeClassificationRadioItem6().setButtonIndex(6);

    getChargeClassificationRadioGroupModel().add(getChargeClassificationRadioItem6());

    getChargeClassificationRadioItem7().setButtonIndex(7);

    getChargeClassificationRadioGroupModel().add(getChargeClassificationRadioItem7());

  }

  /**
   * ��t�ɓ������ڂ�ǉ����܂��B
   */
  protected void addChargeClassificationRadioItem1(){

  }

  /**
   * ���Ȉ�t�ɓ������ڂ�ǉ����܂��B
   */
  protected void addChargeClassificationRadioItem2(){

  }

  /**
   * ��܎t�i��Ë@�ցj�ɓ������ڂ�ǉ����܂��B
   */
  protected void addChargeClassificationRadioItem3(){

  }

  /**
   * ��܎t�i��ǁj�ɓ������ڂ�ǉ����܂��B
   */
  protected void addChargeClassificationRadioItem4(){

  }

  /**
   * �Ǘ��h�{�m�ɓ������ڂ�ǉ����܂��B
   */
  protected void addChargeClassificationRadioItem5(){

  }

  /**
   * ���ȉq���m���ɓ������ڂ�ǉ����܂��B
   */
  protected void addChargeClassificationRadioItem6(){

  }

  /**
   * �Ō�E���ɓ������ڂ�ǉ����܂��B
   */
  protected void addChargeClassificationRadioItem7(){

  }

  /**
   * ��w�����Ǘ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicineManagementRadioGroup(){

  }

  /**
   * ��w�����Ǘ������f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicineManagementRadioGroupModel(){

    getMedicineManagementRadioItem1().setButtonIndex(1);

    getMedicineManagementRadioGroupModel().add(getMedicineManagementRadioItem1());

    getMedicineManagementRadioItem2().setButtonIndex(2);

    getMedicineManagementRadioGroupModel().add(getMedicineManagementRadioItem2());

  }

  /**
   * �Ȃ��i�w���� ( I ) �j�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicineManagementRadioItem1(){

  }

  /**
   * ����i�w���� ( II ) �j�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicineManagementRadioItem2(){

  }

  /**
   * ���p�ҋ敪�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatientGroup(){

    patientGroup.add(getPatientDivisionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    patientGroup.add(getRecuperationManagementGuidanceTimesCancerEndCheck(), VRLayout.FLOW);

  }

  /**
   * ���ݒn�敪�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatientDivisionRadio(){

  }

  /**
   * ���ݒn�敪���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatientDivisionRadioModel(){

    getPatientDivisionRadioItem1().setButtonIndex(1);

    getPatientDivisionRadioModel().add(getPatientDivisionRadioItem1());

    getPatientDivisionRadioItem2().setButtonIndex(2);

    getPatientDivisionRadioModel().add(getPatientDivisionRadioItem2());

  }

  /**
   * ���ꌚ�����Z�҈ȊO�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatientDivisionRadioItem1(){

  }

  /**
   * ���ꌚ�����Z�҂ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatientDivisionRadioItem2(){

  }

  /**
   * �K���������ɓ������ڂ�ǉ����܂��B
   */
  protected void addRecuperationManagementGuidanceTimesCancerEndCheck(){

  }

  /**
   * �^�u�Q�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTab2(){

    tab2.add(getSpecialMedicineRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getKyotakuClassContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getRecuperationManagementGuidanceTimeContena(), VRLayout.FLOW_DOUBLEINSETLINE_RETURN);

  }

  /**
   * ���ʖ�܂ɓ������ڂ�ǉ����܂��B
   */
  protected void addSpecialMedicineRadioGroup(){

  }

  /**
   * ���ʖ�܃��f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addSpecialMedicineRadioGroupModel(){

    getSpecialMedicineRadioItem1().setButtonIndex(1);

    getSpecialMedicineRadioGroupModel().add(getSpecialMedicineRadioItem1());

    getSpecialMedicineRadioItem2().setButtonIndex(2);

    getSpecialMedicineRadioGroupModel().add(getSpecialMedicineRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addSpecialMedicineRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addSpecialMedicineRadioItem2(){

  }

  /**
   * �Ō�E���敪�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKyotakuClass(){

  }

  /**
   * �Ō�E���敪���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKyotakuClassModel(){

    getKyotakuClass1().setButtonIndex(1);

    getKyotakuClassModel().add(getKyotakuClass1());

    getKyotakuClass2().setButtonIndex(2);

    getKyotakuClassModel().add(getKyotakuClass2());

  }

  /**
   * ���œ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addKyotakuClass1(){

  }

  /**
   * �y�łɓ������ڂ�ǉ����܂��B
   */
  protected void addKyotakuClass2(){

  }

  /**
   * �񋟎��ԃR���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addRecuperationManagementGuidanceTimeContena(){

    recuperationManagementGuidanceTimeContena.add(getRecuperationManagementGuidanceBeginTimeContainer(), VRLayout.FLOW);

    recuperationManagementGuidanceTimeContena.add(getRecuperationManagementGuidanceEndTimeContainer(), VRLayout.FLOW);

  }

  /**
   * �J�n�����R���{�ɓ������ڂ�ǉ����܂��B
   */
  protected void addRecuperationManagementGuidanceBeginTime(){

  }

  /**
   * �J�n�����R���{���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addRecuperationManagementGuidanceBeginTimeModel(){

  }

  /**
   * �I�������R���{�ɓ������ڂ�ǉ����܂��B
   */
  protected void addRecuperationManagementGuidanceEndTime(){

  }

  /**
   * �I�������R���{���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addRecuperationManagementGuidanceEndTimeModel(){

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
      ACFrame.debugStart(new ACAffairInfo(QS001_13411_201504Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QS001_13411_201504Design getThis() {
    return this;
  }
}
