
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
 * �쐬��: 2018/02/04  ���{�R���s���[�^�[������� ����@��F �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �T�[�r�X�\��쐬/�ύX (S)
 * �v���Z�X �T�[�r�X�\��T�� (001)
 * �v���O���� �T�[�r�X�p�^�[���Z�������×{���i����×{�Ǘ��w���j (QS001_13111_201804)
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
 * �T�[�r�X�p�^�[���Z�������×{���i����×{�Ǘ��w���j��ʍ��ڃf�U�C��(QS001_13111_201804) 
 */
public class QS001_13111_201804Design extends QS001ServicePanel {
  //GUI�R���|�[�l���g

  private ACPanel recuperationManagementGuidancePatterns;

  private JTabbedPane tabs;

  private ACPanel tab1;

  private ACValueArrayRadioButtonGroup recuperationManagementGuidanceOccupationalCategory;

  private ACLabelContainer recuperationManagementGuidanceOccupationalCategoryContainer;

  private ACListModelAdapter recuperationManagementGuidanceOccupationalCategoryModel;

  private ACRadioButtonItem recuperationManagementGuidanceOccupationalCategoryDoctor1;

  private ACRadioButtonItem recuperationManagementGuidanceOccupationalCategoryDoctor2;

  private ACRadioButtonItem recuperationManagementGuidanceOccupationalCategoryDentist;

  private ACRadioButtonItem recuperationManagementGuidanceOccupationalCategoryHealth;

  private ACRadioButtonItem recuperationManagementGuidanceOccupationalCategoryHospitalPharmacist;

  private ACRadioButtonItem recuperationManagementGuidanceOccupationalCategoryDrugstorePharmacist;

  private ACRadioButtonItem recuperationManagementGuidanceOccupationalCategoryDietitian;

  private ACRadioButtonItem recuperationManagementGuidanceOccupationalCategoryEtc;

  private ACGroupBox patientGroup;

  private ACValueArrayRadioButtonGroup patientRadioGroup;

  private ACLabelContainer patientRadioGroupContainer;

  private ACListModelAdapter patientRadioGroupModel;

  private ACRadioButtonItem patientLocationRadioItem1;

  private ACRadioButtonItem patientLocationRadioItem2;

  private ACRadioButtonItem patientLocationRadioItem3;

  private ACValueArrayRadioButtonGroup patientOldRadioGroup;

  private ACLabelContainer patientOldRadioGroupContainer;

  private ACListModelAdapter patientOldRadioGroupModel;

  private ACRadioButtonItem patientRadioItem1;

  private ACRadioButtonItem patientRadioItem2;

  private ACIntegerCheckBox recuperationManagementGuidanceTimesCancerEndCheck;

  private ACPanel tab2;

  private ACValueArrayRadioButtonGroup recuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadio;

  private ACLabelContainer recuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioContainer;

  private ACListModelAdapter recuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioModel;

  private ACRadioButtonItem recuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioItem1;

  private ACRadioButtonItem recuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioItem2;

  private ACValueArrayRadioButtonGroup kyotakuClass;

  private ACLabelContainer kyotakuClassContainer;

  private ACListModelAdapter kyotakuClassModel;

  private ACRadioButtonItem kyotakuClass1;

  private ACRadioButtonItem kyotakuClass2;

  private ACValueArrayRadioButtonGroup providerAddMountainousAreaRadioGroup;

  private ACLabelContainer providerAddMountainousAreaRadioGroupContainer;

  private ACListModelAdapter providerAddMountainousAreaRadioGroupModel;

  private ACRadioButtonItem providerAddMountainousAreaItem1;

  private ACRadioButtonItem providerAddMountainousAreaItem2;

  private ACBackLabelContainer recuperationManagementGuidanceTimeContena;

  private ACTimeComboBox recuperationManagementGuidanceBeginTime;

  private ACLabelContainer recuperationManagementGuidanceBeginTimeContainer;

  private ACComboBoxModelAdapter recuperationManagementGuidanceBeginTimeModel;

  private ACTimeComboBox recuperationManagementGuidanceEndTime;

  private ACLabelContainer recuperationManagementGuidanceEndTimeContainer;

  private ACComboBoxModelAdapter recuperationManagementGuidanceEndTimeModel;

  //getter

  /**
   * �Z�������×{���i����×{�Ǘ��w���j�p�^�[���̈�j���擾���܂��B
   * @return �Z�������×{���i����×{�Ǘ��w���j�p�^�[���̈�j
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
   * �S���ҋ敪���擾���܂��B
   * @return �S���ҋ敪
   */
  public ACValueArrayRadioButtonGroup getRecuperationManagementGuidanceOccupationalCategory(){
    if(recuperationManagementGuidanceOccupationalCategory==null){

      recuperationManagementGuidanceOccupationalCategory = new ACValueArrayRadioButtonGroup();

      getRecuperationManagementGuidanceOccupationalCategoryContainer().setText("�S���ҋ敪");

      recuperationManagementGuidanceOccupationalCategory.setBindPath("1310111");

      recuperationManagementGuidanceOccupationalCategory.setUseClearButton(false);

      recuperationManagementGuidanceOccupationalCategory.setModel(getRecuperationManagementGuidanceOccupationalCategoryModel());

      recuperationManagementGuidanceOccupationalCategory.setValues(new int[]{1,8,2,7,3,4,5,6});

      addRecuperationManagementGuidanceOccupationalCategory();
    }
    return recuperationManagementGuidanceOccupationalCategory;

  }

  /**
   * �S���ҋ敪�R���e�i���擾���܂��B
   * @return �S���ҋ敪�R���e�i
   */
  protected ACLabelContainer getRecuperationManagementGuidanceOccupationalCategoryContainer(){
    if(recuperationManagementGuidanceOccupationalCategoryContainer==null){
      recuperationManagementGuidanceOccupationalCategoryContainer = new ACLabelContainer();
      recuperationManagementGuidanceOccupationalCategoryContainer.setFollowChildEnabled(true);
      recuperationManagementGuidanceOccupationalCategoryContainer.setVAlignment(VRLayout.CENTER);
      recuperationManagementGuidanceOccupationalCategoryContainer.add(getRecuperationManagementGuidanceOccupationalCategory(), null);
    }
    return recuperationManagementGuidanceOccupationalCategoryContainer;
  }

  /**
   * �S���ҋ敪���f�����擾���܂��B
   * @return �S���ҋ敪���f��
   */
  protected ACListModelAdapter getRecuperationManagementGuidanceOccupationalCategoryModel(){
    if(recuperationManagementGuidanceOccupationalCategoryModel==null){
      recuperationManagementGuidanceOccupationalCategoryModel = new ACListModelAdapter();
      addRecuperationManagementGuidanceOccupationalCategoryModel();
    }
    return recuperationManagementGuidanceOccupationalCategoryModel;
  }

  /**
   * ��t(�w����I)���擾���܂��B
   * @return ��t(�w����I)
   */
  public ACRadioButtonItem getRecuperationManagementGuidanceOccupationalCategoryDoctor1(){
    if(recuperationManagementGuidanceOccupationalCategoryDoctor1==null){

      recuperationManagementGuidanceOccupationalCategoryDoctor1 = new ACRadioButtonItem();

      recuperationManagementGuidanceOccupationalCategoryDoctor1.setText("��t(�w����I)");

      recuperationManagementGuidanceOccupationalCategoryDoctor1.setGroup(getRecuperationManagementGuidanceOccupationalCategory());

      recuperationManagementGuidanceOccupationalCategoryDoctor1.setConstraints(VRLayout.FLOW_RETURN);

      addRecuperationManagementGuidanceOccupationalCategoryDoctor1();
    }
    return recuperationManagementGuidanceOccupationalCategoryDoctor1;

  }

  /**
   * ��t(�w����II)�@��w�����Ǘ������擾���܂��B
   * @return ��t(�w����II)�@��w�����Ǘ���
   */
  public ACRadioButtonItem getRecuperationManagementGuidanceOccupationalCategoryDoctor2(){
    if(recuperationManagementGuidanceOccupationalCategoryDoctor2==null){

      recuperationManagementGuidanceOccupationalCategoryDoctor2 = new ACRadioButtonItem();

      recuperationManagementGuidanceOccupationalCategoryDoctor2.setText("��t(�w����II)�@��w�����Ǘ���");

      recuperationManagementGuidanceOccupationalCategoryDoctor2.setGroup(getRecuperationManagementGuidanceOccupationalCategory());

      recuperationManagementGuidanceOccupationalCategoryDoctor2.setConstraints(VRLayout.FLOW_RETURN);

      addRecuperationManagementGuidanceOccupationalCategoryDoctor2();
    }
    return recuperationManagementGuidanceOccupationalCategoryDoctor2;

  }

  /**
   * ���Ȉ�t���擾���܂��B
   * @return ���Ȉ�t
   */
  public ACRadioButtonItem getRecuperationManagementGuidanceOccupationalCategoryDentist(){
    if(recuperationManagementGuidanceOccupationalCategoryDentist==null){

      recuperationManagementGuidanceOccupationalCategoryDentist = new ACRadioButtonItem();

      recuperationManagementGuidanceOccupationalCategoryDentist.setText("���Ȉ�t");

      recuperationManagementGuidanceOccupationalCategoryDentist.setGroup(getRecuperationManagementGuidanceOccupationalCategory());

      recuperationManagementGuidanceOccupationalCategoryDentist.setConstraints(VRLayout.FLOW);

      addRecuperationManagementGuidanceOccupationalCategoryDentist();
    }
    return recuperationManagementGuidanceOccupationalCategoryDentist;

  }

  /**
   * �Ō�E�����擾���܂��B
   * @return �Ō�E��
   */
  public ACRadioButtonItem getRecuperationManagementGuidanceOccupationalCategoryHealth(){
    if(recuperationManagementGuidanceOccupationalCategoryHealth==null){

      recuperationManagementGuidanceOccupationalCategoryHealth = new ACRadioButtonItem();

      recuperationManagementGuidanceOccupationalCategoryHealth.setText("�Ō�E��");

      recuperationManagementGuidanceOccupationalCategoryHealth.setGroup(getRecuperationManagementGuidanceOccupationalCategory());

      recuperationManagementGuidanceOccupationalCategoryHealth.setConstraints(VRLayout.FLOW_RETURN);

      addRecuperationManagementGuidanceOccupationalCategoryHealth();
    }
    return recuperationManagementGuidanceOccupationalCategoryHealth;

  }

  /**
   * ��܎t(��Ë@��)���擾���܂��B
   * @return ��܎t(��Ë@��)
   */
  public ACRadioButtonItem getRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacist(){
    if(recuperationManagementGuidanceOccupationalCategoryHospitalPharmacist==null){

      recuperationManagementGuidanceOccupationalCategoryHospitalPharmacist = new ACRadioButtonItem();

      recuperationManagementGuidanceOccupationalCategoryHospitalPharmacist.setText("��܎t(��Ë@��)");

      recuperationManagementGuidanceOccupationalCategoryHospitalPharmacist.setGroup(getRecuperationManagementGuidanceOccupationalCategory());

      recuperationManagementGuidanceOccupationalCategoryHospitalPharmacist.setConstraints(VRLayout.FLOW);

      addRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacist();
    }
    return recuperationManagementGuidanceOccupationalCategoryHospitalPharmacist;

  }

  /**
   * ��܎t(���)���擾���܂��B
   * @return ��܎t(���)
   */
  public ACRadioButtonItem getRecuperationManagementGuidanceOccupationalCategoryDrugstorePharmacist(){
    if(recuperationManagementGuidanceOccupationalCategoryDrugstorePharmacist==null){

      recuperationManagementGuidanceOccupationalCategoryDrugstorePharmacist = new ACRadioButtonItem();

      recuperationManagementGuidanceOccupationalCategoryDrugstorePharmacist.setText("��܎t(���)");

      recuperationManagementGuidanceOccupationalCategoryDrugstorePharmacist.setGroup(getRecuperationManagementGuidanceOccupationalCategory());

      recuperationManagementGuidanceOccupationalCategoryDrugstorePharmacist.setConstraints(VRLayout.FLOW_RETURN);

      addRecuperationManagementGuidanceOccupationalCategoryDrugstorePharmacist();
    }
    return recuperationManagementGuidanceOccupationalCategoryDrugstorePharmacist;

  }

  /**
   * �Ǘ��h�{�m���擾���܂��B
   * @return �Ǘ��h�{�m
   */
  public ACRadioButtonItem getRecuperationManagementGuidanceOccupationalCategoryDietitian(){
    if(recuperationManagementGuidanceOccupationalCategoryDietitian==null){

      recuperationManagementGuidanceOccupationalCategoryDietitian = new ACRadioButtonItem();

      recuperationManagementGuidanceOccupationalCategoryDietitian.setText("�Ǘ��h�{�m");

      recuperationManagementGuidanceOccupationalCategoryDietitian.setGroup(getRecuperationManagementGuidanceOccupationalCategory());

      recuperationManagementGuidanceOccupationalCategoryDietitian.setConstraints(VRLayout.FLOW);

      addRecuperationManagementGuidanceOccupationalCategoryDietitian();
    }
    return recuperationManagementGuidanceOccupationalCategoryDietitian;

  }

  /**
   * ���ȉq���m�����擾���܂��B
   * @return ���ȉq���m��
   */
  public ACRadioButtonItem getRecuperationManagementGuidanceOccupationalCategoryEtc(){
    if(recuperationManagementGuidanceOccupationalCategoryEtc==null){

      recuperationManagementGuidanceOccupationalCategoryEtc = new ACRadioButtonItem();

      recuperationManagementGuidanceOccupationalCategoryEtc.setText("���ȉq���m��");

      recuperationManagementGuidanceOccupationalCategoryEtc.setGroup(getRecuperationManagementGuidanceOccupationalCategory());

      recuperationManagementGuidanceOccupationalCategoryEtc.setConstraints(VRLayout.FLOW_RETURN);

      addRecuperationManagementGuidanceOccupationalCategoryEtc();
    }
    return recuperationManagementGuidanceOccupationalCategoryEtc;

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
  public ACValueArrayRadioButtonGroup getPatientRadioGroup(){
    if(patientRadioGroup==null){

      patientRadioGroup = new ACValueArrayRadioButtonGroup();

      getPatientRadioGroupContainer().setText("���ݒn�敪");

      patientRadioGroup.setBindPath("1310113");

      patientRadioGroup.setNoSelectIndex(0);

      patientRadioGroup.setUseClearButton(false);

      patientRadioGroup.setModel(getPatientRadioGroupModel());

      patientRadioGroup.setValues(new int[]{1,2,3});

      addPatientRadioGroup();
    }
    return patientRadioGroup;

  }

  /**
   * ���ݒn�敪�R���e�i���擾���܂��B
   * @return ���ݒn�敪�R���e�i
   */
  protected ACLabelContainer getPatientRadioGroupContainer(){
    if(patientRadioGroupContainer==null){
      patientRadioGroupContainer = new ACLabelContainer();
      patientRadioGroupContainer.setFollowChildEnabled(true);
      patientRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      patientRadioGroupContainer.add(getPatientRadioGroup(), null);
    }
    return patientRadioGroupContainer;
  }

  /**
   * ���ݒn�敪���f�����擾���܂��B
   * @return ���ݒn�敪���f��
   */
  protected ACListModelAdapter getPatientRadioGroupModel(){
    if(patientRadioGroupModel==null){
      patientRadioGroupModel = new ACListModelAdapter();
      addPatientRadioGroupModel();
    }
    return patientRadioGroupModel;
  }

  /**
   * �P�ꌚ�����Z�ҁi1�l�j���擾���܂��B
   * @return �P�ꌚ�����Z�ҁi1�l�j
   */
  public ACRadioButtonItem getPatientLocationRadioItem1(){
    if(patientLocationRadioItem1==null){

      patientLocationRadioItem1 = new ACRadioButtonItem();

      patientLocationRadioItem1.setText("<html>�P�ꌚ�����Z�ҁi1�l�j<br>%unit%<html>");

      patientLocationRadioItem1.setGroup(getPatientRadioGroup());

      patientLocationRadioItem1.setConstraints(VRLayout.FLOW_RETURN);

      addPatientLocationRadioItem1();
    }
    return patientLocationRadioItem1;

  }

  /**
   * �P�ꌚ�����Z�ҁi2�`9�l�j���擾���܂��B
   * @return �P�ꌚ�����Z�ҁi2�`9�l�j
   */
  public ACRadioButtonItem getPatientLocationRadioItem2(){
    if(patientLocationRadioItem2==null){

      patientLocationRadioItem2 = new ACRadioButtonItem();

      patientLocationRadioItem2.setText("<html>�P�ꌚ�����Z�ҁi2�`9�l�j<br>%unit%<html>");

      patientLocationRadioItem2.setGroup(getPatientRadioGroup());

      patientLocationRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

      addPatientLocationRadioItem2();
    }
    return patientLocationRadioItem2;

  }

  /**
   * ��L�ȊO���擾���܂��B
   * @return ��L�ȊO
   */
  public ACRadioButtonItem getPatientLocationRadioItem3(){
    if(patientLocationRadioItem3==null){

      patientLocationRadioItem3 = new ACRadioButtonItem();

      patientLocationRadioItem3.setText("<html>��L�ȊO<br>%unit%<html>");

      patientLocationRadioItem3.setGroup(getPatientRadioGroup());

      patientLocationRadioItem3.setConstraints(VRLayout.FLOW);

      addPatientLocationRadioItem3();
    }
    return patientLocationRadioItem3;

  }

  /**
   * ���ݒn�敪���擾���܂��B
   * @return ���ݒn�敪
   */
  public ACValueArrayRadioButtonGroup getPatientOldRadioGroup(){
    if(patientOldRadioGroup==null){

      patientOldRadioGroup = new ACValueArrayRadioButtonGroup();

      getPatientOldRadioGroupContainer().setText("���ݒn�敪");

      patientOldRadioGroup.setBindPath("16");

      patientOldRadioGroup.setNoSelectIndex(0);

      patientOldRadioGroup.setUseClearButton(false);

      patientOldRadioGroup.setModel(getPatientOldRadioGroupModel());

      patientOldRadioGroup.setValues(new int[]{1,2});

      addPatientOldRadioGroup();
    }
    return patientOldRadioGroup;

  }

  /**
   * ���ݒn�敪�R���e�i���擾���܂��B
   * @return ���ݒn�敪�R���e�i
   */
  protected ACLabelContainer getPatientOldRadioGroupContainer(){
    if(patientOldRadioGroupContainer==null){
      patientOldRadioGroupContainer = new ACLabelContainer();
      patientOldRadioGroupContainer.setFollowChildEnabled(true);
      patientOldRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      patientOldRadioGroupContainer.add(getPatientOldRadioGroup(), null);
    }
    return patientOldRadioGroupContainer;
  }

  /**
   * ���ݒn�敪���f�����擾���܂��B
   * @return ���ݒn�敪���f��
   */
  protected ACListModelAdapter getPatientOldRadioGroupModel(){
    if(patientOldRadioGroupModel==null){
      patientOldRadioGroupModel = new ACListModelAdapter();
      addPatientOldRadioGroupModel();
    }
    return patientOldRadioGroupModel;
  }

  /**
   * ���ꌚ�����Z�҈ȊO���擾���܂��B
   * @return ���ꌚ�����Z�҈ȊO
   */
  public ACRadioButtonItem getPatientRadioItem1(){
    if(patientRadioItem1==null){

      patientRadioItem1 = new ACRadioButtonItem();

      patientRadioItem1.setText("<html>���ꌚ�����Z�҈ȊO<br>�i402�P�ʁj<html>");

      patientRadioItem1.setGroup(getPatientOldRadioGroup());

      patientRadioItem1.setConstraints(VRLayout.FLOW_RETURN);

      addPatientRadioItem1();
    }
    return patientRadioItem1;

  }

  /**
   * ����n�{�ݓ����҂��擾���܂��B
   * @return ����n�{�ݓ�����
   */
  public ACRadioButtonItem getPatientRadioItem2(){
    if(patientRadioItem2==null){

      patientRadioItem2 = new ACRadioButtonItem();

      patientRadioItem2.setText("<html>���ꌚ�����Z��<br>�i362�P�ʁj<html>");

      patientRadioItem2.setGroup(getPatientOldRadioGroup());

      patientRadioItem2.setConstraints(VRLayout.FLOW);

      addPatientRadioItem2();
    }
    return patientRadioItem2;

  }

  /**
   * �K�����������擾���܂��B
   * @return �K��������
   */
  public ACIntegerCheckBox getRecuperationManagementGuidanceTimesCancerEndCheck(){
    if(recuperationManagementGuidanceTimesCancerEndCheck==null){

      recuperationManagementGuidanceTimesCancerEndCheck = new ACIntegerCheckBox();

      recuperationManagementGuidanceTimesCancerEndCheck.setText("�K��������");

      recuperationManagementGuidanceTimesCancerEndCheck.setBindPath("1310110");

      recuperationManagementGuidanceTimesCancerEndCheck.setSelectValue(2);

      recuperationManagementGuidanceTimesCancerEndCheck.setUnSelectValue(1);

      addRecuperationManagementGuidanceTimesCancerEndCheck();
    }
    return recuperationManagementGuidanceTimesCancerEndCheck;

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
  public ACValueArrayRadioButtonGroup getRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadio(){
    if(recuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadio==null){

      recuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadio = new ACValueArrayRadioButtonGroup();

      getRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioContainer().setText("���ʖ��");

      recuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadio.setBindPath("1310105");

      recuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadio.setUseClearButton(false);

      recuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadio.setModel(getRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioModel());

      recuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadio.setValues(new int[]{1,2});

      addRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadio();
    }
    return recuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadio;

  }

  /**
   * ���ʖ�܃R���e�i���擾���܂��B
   * @return ���ʖ�܃R���e�i
   */
  protected ACLabelContainer getRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioContainer(){
    if(recuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioContainer==null){
      recuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioContainer = new ACLabelContainer();
      recuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioContainer.setFollowChildEnabled(true);
      recuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioContainer.setVAlignment(VRLayout.CENTER);
      recuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioContainer.add(getRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadio(), null);
    }
    return recuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioContainer;
  }

  /**
   * ���ʖ�܃��f�����擾���܂��B
   * @return ���ʖ�܃��f��
   */
  protected ACListModelAdapter getRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioModel(){
    if(recuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioModel==null){
      recuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioModel = new ACListModelAdapter();
      addRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioModel();
    }
    return recuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioItem1(){
    if(recuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioItem1==null){

      recuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioItem1 = new ACRadioButtonItem();

      recuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioItem1.setText("�Ȃ�");

      recuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioItem1.setGroup(getRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadio());

      recuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioItem1.setConstraints(VRLayout.FLOW);

      addRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioItem1();
    }
    return recuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioItem2(){
    if(recuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioItem2==null){

      recuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioItem2 = new ACRadioButtonItem();

      recuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioItem2.setText("����");

      recuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioItem2.setGroup(getRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadio());

      recuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioItem2.setConstraints(VRLayout.FLOW);

      addRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioItem2();
    }
    return recuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioItem2;

  }

  /**
   * �Ō�E���敪���擾���܂��B
   * @return �Ō�E���敪
   */
  public ACValueArrayRadioButtonGroup getKyotakuClass(){
    if(kyotakuClass==null){

      kyotakuClass = new ACValueArrayRadioButtonGroup();

      getKyotakuClassContainer().setText("�Ō�E���敪");

      kyotakuClass.setBindPath("1310112");

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
   * ���R�Ԓn�擙�ł̃T�[�r�X�񋟉��Z���擾���܂��B
   * @return ���R�Ԓn�擙�ł̃T�[�r�X�񋟉��Z
   */
  public ACValueArrayRadioButtonGroup getProviderAddMountainousAreaRadioGroup(){
    if(providerAddMountainousAreaRadioGroup==null){

      providerAddMountainousAreaRadioGroup = new ACValueArrayRadioButtonGroup();

      getProviderAddMountainousAreaRadioGroupContainer().setText("���R�Ԓn�擙�ł̃T�[�r�X�񋟉��Z");

      providerAddMountainousAreaRadioGroup.setBindPath("12");

      providerAddMountainousAreaRadioGroup.setNoSelectIndex(0);

      providerAddMountainousAreaRadioGroup.setUseClearButton(false);

      providerAddMountainousAreaRadioGroup.setModel(getProviderAddMountainousAreaRadioGroupModel());

      providerAddMountainousAreaRadioGroup.setValues(new int[]{1,2});

      addProviderAddMountainousAreaRadioGroup();
    }
    return providerAddMountainousAreaRadioGroup;

  }

  /**
   * ���R�Ԓn�擙�ł̃T�[�r�X�񋟉��Z�R���e�i���擾���܂��B
   * @return ���R�Ԓn�擙�ł̃T�[�r�X�񋟉��Z�R���e�i
   */
  protected ACLabelContainer getProviderAddMountainousAreaRadioGroupContainer(){
    if(providerAddMountainousAreaRadioGroupContainer==null){
      providerAddMountainousAreaRadioGroupContainer = new ACLabelContainer();
      providerAddMountainousAreaRadioGroupContainer.setFollowChildEnabled(true);
      providerAddMountainousAreaRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      providerAddMountainousAreaRadioGroupContainer.add(getProviderAddMountainousAreaRadioGroup(), null);
    }
    return providerAddMountainousAreaRadioGroupContainer;
  }

  /**
   * ���R�Ԓn�擙�ł̃T�[�r�X�񋟉��Z���f�����擾���܂��B
   * @return ���R�Ԓn�擙�ł̃T�[�r�X�񋟉��Z���f��
   */
  protected ACListModelAdapter getProviderAddMountainousAreaRadioGroupModel(){
    if(providerAddMountainousAreaRadioGroupModel==null){
      providerAddMountainousAreaRadioGroupModel = new ACListModelAdapter();
      addProviderAddMountainousAreaRadioGroupModel();
    }
    return providerAddMountainousAreaRadioGroupModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getProviderAddMountainousAreaItem1(){
    if(providerAddMountainousAreaItem1==null){

      providerAddMountainousAreaItem1 = new ACRadioButtonItem();

      providerAddMountainousAreaItem1.setText("�Ȃ�");

      providerAddMountainousAreaItem1.setGroup(getProviderAddMountainousAreaRadioGroup());

      providerAddMountainousAreaItem1.setConstraints(VRLayout.FLOW);

      addProviderAddMountainousAreaItem1();
    }
    return providerAddMountainousAreaItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getProviderAddMountainousAreaItem2(){
    if(providerAddMountainousAreaItem2==null){

      providerAddMountainousAreaItem2 = new ACRadioButtonItem();

      providerAddMountainousAreaItem2.setText("����");

      providerAddMountainousAreaItem2.setGroup(getProviderAddMountainousAreaRadioGroup());

      providerAddMountainousAreaItem2.setConstraints(VRLayout.FLOW);

      addProviderAddMountainousAreaItem2();
    }
    return providerAddMountainousAreaItem2;

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
  public QS001_13111_201804Design() {

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
   * �Z�������×{���i����×{�Ǘ��w���j�p�^�[���̈�j�ɓ������ڂ�ǉ����܂��B
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
   * �^�u1�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTab1(){

    tab1.add(getRecuperationManagementGuidanceOccupationalCategoryContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getPatientGroup(), VRLayout.FLOW_RETURN);

  }

  /**
   * �S���ҋ敪�ɓ������ڂ�ǉ����܂��B
   */
  protected void addRecuperationManagementGuidanceOccupationalCategory(){

  }

  /**
   * �S���ҋ敪���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addRecuperationManagementGuidanceOccupationalCategoryModel(){

    getRecuperationManagementGuidanceOccupationalCategoryDoctor1().setButtonIndex(1);

    getRecuperationManagementGuidanceOccupationalCategoryModel().add(getRecuperationManagementGuidanceOccupationalCategoryDoctor1());

    getRecuperationManagementGuidanceOccupationalCategoryDoctor2().setButtonIndex(8);

    getRecuperationManagementGuidanceOccupationalCategoryModel().add(getRecuperationManagementGuidanceOccupationalCategoryDoctor2());

    getRecuperationManagementGuidanceOccupationalCategoryDentist().setButtonIndex(2);

    getRecuperationManagementGuidanceOccupationalCategoryModel().add(getRecuperationManagementGuidanceOccupationalCategoryDentist());

    getRecuperationManagementGuidanceOccupationalCategoryHealth().setButtonIndex(7);

    getRecuperationManagementGuidanceOccupationalCategoryModel().add(getRecuperationManagementGuidanceOccupationalCategoryHealth());

    getRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacist().setButtonIndex(3);

    getRecuperationManagementGuidanceOccupationalCategoryModel().add(getRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacist());

    getRecuperationManagementGuidanceOccupationalCategoryDrugstorePharmacist().setButtonIndex(4);

    getRecuperationManagementGuidanceOccupationalCategoryModel().add(getRecuperationManagementGuidanceOccupationalCategoryDrugstorePharmacist());

    getRecuperationManagementGuidanceOccupationalCategoryDietitian().setButtonIndex(5);

    getRecuperationManagementGuidanceOccupationalCategoryModel().add(getRecuperationManagementGuidanceOccupationalCategoryDietitian());

    getRecuperationManagementGuidanceOccupationalCategoryEtc().setButtonIndex(6);

    getRecuperationManagementGuidanceOccupationalCategoryModel().add(getRecuperationManagementGuidanceOccupationalCategoryEtc());

  }

  /**
   * ��t(�w����I)�ɓ������ڂ�ǉ����܂��B
   */
  protected void addRecuperationManagementGuidanceOccupationalCategoryDoctor1(){

  }

  /**
   * ��t(�w����II)�@��w�����Ǘ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addRecuperationManagementGuidanceOccupationalCategoryDoctor2(){

  }

  /**
   * ���Ȉ�t�ɓ������ڂ�ǉ����܂��B
   */
  protected void addRecuperationManagementGuidanceOccupationalCategoryDentist(){

  }

  /**
   * �Ō�E���ɓ������ڂ�ǉ����܂��B
   */
  protected void addRecuperationManagementGuidanceOccupationalCategoryHealth(){

  }

  /**
   * ��܎t(��Ë@��)�ɓ������ڂ�ǉ����܂��B
   */
  protected void addRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacist(){

  }

  /**
   * ��܎t(���)�ɓ������ڂ�ǉ����܂��B
   */
  protected void addRecuperationManagementGuidanceOccupationalCategoryDrugstorePharmacist(){

  }

  /**
   * �Ǘ��h�{�m�ɓ������ڂ�ǉ����܂��B
   */
  protected void addRecuperationManagementGuidanceOccupationalCategoryDietitian(){

  }

  /**
   * ���ȉq���m���ɓ������ڂ�ǉ����܂��B
   */
  protected void addRecuperationManagementGuidanceOccupationalCategoryEtc(){

  }

  /**
   * ���p�ҋ敪�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatientGroup(){

    patientGroup.add(getPatientRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    patientGroup.add(getPatientOldRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    patientGroup.add(getRecuperationManagementGuidanceTimesCancerEndCheck(), VRLayout.FLOW);

  }

  /**
   * ���ݒn�敪�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatientRadioGroup(){

  }

  /**
   * ���ݒn�敪���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatientRadioGroupModel(){

    getPatientLocationRadioItem1().setButtonIndex(1);

    getPatientRadioGroupModel().add(getPatientLocationRadioItem1());

    getPatientLocationRadioItem2().setButtonIndex(2);

    getPatientRadioGroupModel().add(getPatientLocationRadioItem2());

    getPatientLocationRadioItem3().setButtonIndex(3);

    getPatientRadioGroupModel().add(getPatientLocationRadioItem3());

  }

  /**
   * �P�ꌚ�����Z�ҁi1�l�j�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatientLocationRadioItem1(){

  }

  /**
   * �P�ꌚ�����Z�ҁi2�`9�l�j�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatientLocationRadioItem2(){

  }

  /**
   * ��L�ȊO�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatientLocationRadioItem3(){

  }

  /**
   * ���ݒn�敪�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatientOldRadioGroup(){

  }

  /**
   * ���ݒn�敪���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatientOldRadioGroupModel(){

    getPatientRadioItem1().setButtonIndex(1);

    getPatientOldRadioGroupModel().add(getPatientRadioItem1());

    getPatientRadioItem2().setButtonIndex(2);

    getPatientOldRadioGroupModel().add(getPatientRadioItem2());

  }

  /**
   * ���ꌚ�����Z�҈ȊO�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatientRadioItem1(){

  }

  /**
   * ����n�{�ݓ����҂ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatientRadioItem2(){

  }

  /**
   * �K���������ɓ������ڂ�ǉ����܂��B
   */
  protected void addRecuperationManagementGuidanceTimesCancerEndCheck(){

  }

  /**
   * �^�u2�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTab2(){

    tab2.add(getRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getKyotakuClassContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getProviderAddMountainousAreaRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getRecuperationManagementGuidanceTimeContena(), VRLayout.FLOW_DOUBLEINSETLINE_RETURN);

  }

  /**
   * ���ʖ�܂ɓ������ڂ�ǉ����܂��B
   */
  protected void addRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadio(){

  }

  /**
   * ���ʖ�܃��f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioModel(){

    getRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioItem1().setButtonIndex(1);

    getRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioModel().add(getRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioItem1());

    getRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioItem2().setButtonIndex(2);

    getRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioModel().add(getRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioItem2(){

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
   * ���R�Ԓn�擙�ł̃T�[�r�X�񋟉��Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderAddMountainousAreaRadioGroup(){

  }

  /**
   * ���R�Ԓn�擙�ł̃T�[�r�X�񋟉��Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderAddMountainousAreaRadioGroupModel(){

    getProviderAddMountainousAreaItem1().setButtonIndex(1);

    getProviderAddMountainousAreaRadioGroupModel().add(getProviderAddMountainousAreaItem1());

    getProviderAddMountainousAreaItem2().setButtonIndex(2);

    getProviderAddMountainousAreaRadioGroupModel().add(getProviderAddMountainousAreaItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderAddMountainousAreaItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderAddMountainousAreaItem2(){

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
      ACFrame.debugStart(new ACAffairInfo(QS001_13111_201804Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QS001_13111_201804Design getThis() {
    return this;
  }
}
