
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
 * �쐬��: 2009/03/16  ���{�R���s���[�^�[������� �c���@���� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �T�[�r�X�\��쐬/�ύX (S)
 * �v���Z�X �T�[�r�X�\��T�� (001)
 * �v���O���� �T�[�r�X�p�^�[�����\�h����×{�Ǘ��w�� (QS001134_H2104)
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
 * �T�[�r�X�p�^�[�����\�h����×{�Ǘ��w����ʍ��ڃf�U�C��(QS001134_H2104) 
 */
public class QS001134_H2104Design extends QS001ServicePanel {
  //GUI�R���|�[�l���g

  private ACPanel recuperationManagementGuidancePatterns;

  private JTabbedPane tabs;

  private ACPanel tab1;

  private ACValueArrayRadioButtonGroup recuperationManagementGuidanceOccupationalCategory;

  private ACLabelContainer recuperationManagementGuidanceOccupationalCategoryContainer;

  private ACListModelAdapter recuperationManagementGuidanceOccupationalCategoryModel;

  private ACRadioButtonItem recuperationManagementGuidanceOccupationalCategoryDoctor;

  private ACRadioButtonItem recuperationManagementGuidanceOccupationalCategoryDentist;

  private ACRadioButtonItem recuperationManagementGuidanceOccupationalCategoryHospitalPharmacist;

  private ACRadioButtonItem recuperationManagementGuidanceOccupationalCategoryDrugstorePharmacist;

  private ACRadioButtonItem recuperationManagementGuidanceOccupationalCategoryDietitian;

  private ACRadioButtonItem recuperationManagementGuidanceOccupationalCategoryEtc;

  private ACRadioButtonItem recuperationManagementGuidanceOccupationalCategoryHealth;

  private ACClearableRadioButtonGroup recuperationManagementGuidanceOccupationalCategoryZaiSouShinRadio;

  private ACLabelContainer recuperationManagementGuidanceOccupationalCategoryZaiSouShinRadioContainer;

  private ACListModelAdapter recuperationManagementGuidanceOccupationalCategoryZaiSouShinRadioModel;

  private ACRadioButtonItem recuperationManagementGuidanceOccupationalCategoryZaiSouShinRadioItem1;

  private ACRadioButtonItem recuperationManagementGuidanceOccupationalCategoryZaiSouShinRadioItem2;

  private ACClearableRadioButtonGroup recuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadio;

  private ACLabelContainer recuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioContainer;

  private ACListModelAdapter recuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioModel;

  private ACRadioButtonItem recuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioItem1;

  private ACRadioButtonItem recuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioItem2;

  private ACClearableRadioButtonGroup recuperationManagementGuidanceInfoAddRadio;

  private ACLabelContainer recuperationManagementGuidanceInfoAddRadioContainer;

  private ACListModelAdapter recuperationManagementGuidanceInfoAddRadioModel;

  private ACRadioButtonItem recuperationManagementGuidanceInfoAddRadioItem1;

  private ACRadioButtonItem recuperationManagementGuidanceInfoAddRadioItem2;

  private ACGroupBox recuperationManagementGuidanceTimesGroup;

  private ACValueArrayRadioButtonGroup patientDivisionRadio;

  private ACLabelContainer patientDivisionRadioContainer;

  private ACListModelAdapter patientDivisionRadioModel;

  private ACRadioButtonItem patientDivisionRadioItem1;

  private ACRadioButtonItem patientDivisionRadioItem2;

  private ACIntegerCheckBox recuperationManagementGuidanceTimesCancerEndCheck;

  private ACPanel tab2;

  private ACClearableRadioButtonGroup kyotakuClass;

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
  public ACValueArrayRadioButtonGroup getRecuperationManagementGuidanceOccupationalCategory(){
    if(recuperationManagementGuidanceOccupationalCategory==null){

      recuperationManagementGuidanceOccupationalCategory = new ACValueArrayRadioButtonGroup();

      getRecuperationManagementGuidanceOccupationalCategoryContainer().setText("�S���ҋ敪");

      recuperationManagementGuidanceOccupationalCategory.setBindPath("1340108");

      recuperationManagementGuidanceOccupationalCategory.setNoSelectIndex(0);

      recuperationManagementGuidanceOccupationalCategory.setUseClearButton(false);

      recuperationManagementGuidanceOccupationalCategory.setModel(getRecuperationManagementGuidanceOccupationalCategoryModel());

      recuperationManagementGuidanceOccupationalCategory.setValues(new int[]{1,2,3,4,5,6,7});

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
   * ��t���擾���܂��B
   * @return ��t
   */
  public ACRadioButtonItem getRecuperationManagementGuidanceOccupationalCategoryDoctor(){
    if(recuperationManagementGuidanceOccupationalCategoryDoctor==null){

      recuperationManagementGuidanceOccupationalCategoryDoctor = new ACRadioButtonItem();

      recuperationManagementGuidanceOccupationalCategoryDoctor.setText("��t");

      recuperationManagementGuidanceOccupationalCategoryDoctor.setGroup(getRecuperationManagementGuidanceOccupationalCategory());

      recuperationManagementGuidanceOccupationalCategoryDoctor.setConstraints(VRLayout.FLOW);

      addRecuperationManagementGuidanceOccupationalCategoryDoctor();
    }
    return recuperationManagementGuidanceOccupationalCategoryDoctor;

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

      recuperationManagementGuidanceOccupationalCategoryDentist.setConstraints(VRLayout.FLOW_RETURN);

      addRecuperationManagementGuidanceOccupationalCategoryDentist();
    }
    return recuperationManagementGuidanceOccupationalCategoryDentist;

  }

  /**
   * ��܎t�i��Ë@�ցj���擾���܂��B
   * @return ��܎t�i��Ë@�ցj
   */
  public ACRadioButtonItem getRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacist(){
    if(recuperationManagementGuidanceOccupationalCategoryHospitalPharmacist==null){

      recuperationManagementGuidanceOccupationalCategoryHospitalPharmacist = new ACRadioButtonItem();

      recuperationManagementGuidanceOccupationalCategoryHospitalPharmacist.setText("��܎t�i��Ë@�ցj");

      recuperationManagementGuidanceOccupationalCategoryHospitalPharmacist.setGroup(getRecuperationManagementGuidanceOccupationalCategory());

      recuperationManagementGuidanceOccupationalCategoryHospitalPharmacist.setConstraints(VRLayout.FLOW_RETURN);

      addRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacist();
    }
    return recuperationManagementGuidanceOccupationalCategoryHospitalPharmacist;

  }

  /**
   * ��܎t�i��ǁj���擾���܂��B
   * @return ��܎t�i��ǁj
   */
  public ACRadioButtonItem getRecuperationManagementGuidanceOccupationalCategoryDrugstorePharmacist(){
    if(recuperationManagementGuidanceOccupationalCategoryDrugstorePharmacist==null){

      recuperationManagementGuidanceOccupationalCategoryDrugstorePharmacist = new ACRadioButtonItem();

      recuperationManagementGuidanceOccupationalCategoryDrugstorePharmacist.setText("��܎t�i��ǁj");

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
   * ��w�����Ǘ������擾���܂��B
   * @return ��w�����Ǘ���
   */
  public ACClearableRadioButtonGroup getRecuperationManagementGuidanceOccupationalCategoryZaiSouShinRadio(){
    if(recuperationManagementGuidanceOccupationalCategoryZaiSouShinRadio==null){

      recuperationManagementGuidanceOccupationalCategoryZaiSouShinRadio = new ACClearableRadioButtonGroup();

      getRecuperationManagementGuidanceOccupationalCategoryZaiSouShinRadioContainer().setText("��w�����Ǘ���");

      recuperationManagementGuidanceOccupationalCategoryZaiSouShinRadio.setBindPath("1340102");

      recuperationManagementGuidanceOccupationalCategoryZaiSouShinRadio.setUseClearButton(false);

      recuperationManagementGuidanceOccupationalCategoryZaiSouShinRadio.setModel(getRecuperationManagementGuidanceOccupationalCategoryZaiSouShinRadioModel());

      addRecuperationManagementGuidanceOccupationalCategoryZaiSouShinRadio();
    }
    return recuperationManagementGuidanceOccupationalCategoryZaiSouShinRadio;

  }

  /**
   * ��w�����Ǘ����R���e�i���擾���܂��B
   * @return ��w�����Ǘ����R���e�i
   */
  protected ACLabelContainer getRecuperationManagementGuidanceOccupationalCategoryZaiSouShinRadioContainer(){
    if(recuperationManagementGuidanceOccupationalCategoryZaiSouShinRadioContainer==null){
      recuperationManagementGuidanceOccupationalCategoryZaiSouShinRadioContainer = new ACLabelContainer();
      recuperationManagementGuidanceOccupationalCategoryZaiSouShinRadioContainer.setFollowChildEnabled(true);
      recuperationManagementGuidanceOccupationalCategoryZaiSouShinRadioContainer.setVAlignment(VRLayout.CENTER);
      recuperationManagementGuidanceOccupationalCategoryZaiSouShinRadioContainer.add(getRecuperationManagementGuidanceOccupationalCategoryZaiSouShinRadio(), null);
    }
    return recuperationManagementGuidanceOccupationalCategoryZaiSouShinRadioContainer;
  }

  /**
   * ��w�����Ǘ������f�����擾���܂��B
   * @return ��w�����Ǘ������f��
   */
  protected ACListModelAdapter getRecuperationManagementGuidanceOccupationalCategoryZaiSouShinRadioModel(){
    if(recuperationManagementGuidanceOccupationalCategoryZaiSouShinRadioModel==null){
      recuperationManagementGuidanceOccupationalCategoryZaiSouShinRadioModel = new ACListModelAdapter();
      addRecuperationManagementGuidanceOccupationalCategoryZaiSouShinRadioModel();
    }
    return recuperationManagementGuidanceOccupationalCategoryZaiSouShinRadioModel;
  }

  /**
   * �Ȃ��i�w���� ( I ) 500�P�ʁj���擾���܂��B
   * @return �Ȃ��i�w���� ( I ) 500�P�ʁj
   */
  public ACRadioButtonItem getRecuperationManagementGuidanceOccupationalCategoryZaiSouShinRadioItem1(){
    if(recuperationManagementGuidanceOccupationalCategoryZaiSouShinRadioItem1==null){

      recuperationManagementGuidanceOccupationalCategoryZaiSouShinRadioItem1 = new ACRadioButtonItem();

      recuperationManagementGuidanceOccupationalCategoryZaiSouShinRadioItem1.setText("�Ȃ��i�w���� ( I ) 500�P�ʁj");

      recuperationManagementGuidanceOccupationalCategoryZaiSouShinRadioItem1.setGroup(getRecuperationManagementGuidanceOccupationalCategoryZaiSouShinRadio());

      recuperationManagementGuidanceOccupationalCategoryZaiSouShinRadioItem1.setConstraints(VRLayout.FLOW_RETURN);

      addRecuperationManagementGuidanceOccupationalCategoryZaiSouShinRadioItem1();
    }
    return recuperationManagementGuidanceOccupationalCategoryZaiSouShinRadioItem1;

  }

  /**
   * ����i�w���� ( II ) 290�P�ʁj���擾���܂��B
   * @return ����i�w���� ( II ) 290�P�ʁj
   */
  public ACRadioButtonItem getRecuperationManagementGuidanceOccupationalCategoryZaiSouShinRadioItem2(){
    if(recuperationManagementGuidanceOccupationalCategoryZaiSouShinRadioItem2==null){

      recuperationManagementGuidanceOccupationalCategoryZaiSouShinRadioItem2 = new ACRadioButtonItem();

      recuperationManagementGuidanceOccupationalCategoryZaiSouShinRadioItem2.setText("����i�w���� ( II ) 290�P�ʁj");

      recuperationManagementGuidanceOccupationalCategoryZaiSouShinRadioItem2.setGroup(getRecuperationManagementGuidanceOccupationalCategoryZaiSouShinRadio());

      recuperationManagementGuidanceOccupationalCategoryZaiSouShinRadioItem2.setConstraints(VRLayout.FLOW);

      addRecuperationManagementGuidanceOccupationalCategoryZaiSouShinRadioItem2();
    }
    return recuperationManagementGuidanceOccupationalCategoryZaiSouShinRadioItem2;

  }

  /**
   * ���ʖ�܂��擾���܂��B
   * @return ���ʖ��
   */
  public ACClearableRadioButtonGroup getRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadio(){
    if(recuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadio==null){

      recuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadio = new ACClearableRadioButtonGroup();

      getRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioContainer().setText("���ʖ��");

      recuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadio.setBindPath("1340103");

      recuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadio.setUseClearButton(false);

      recuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadio.setModel(getRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioModel());

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
   * ���񋟖����{���Z���擾���܂��B
   * @return ���񋟖����{���Z
   */
  public ACClearableRadioButtonGroup getRecuperationManagementGuidanceInfoAddRadio(){
    if(recuperationManagementGuidanceInfoAddRadio==null){

      recuperationManagementGuidanceInfoAddRadio = new ACClearableRadioButtonGroup();

      getRecuperationManagementGuidanceInfoAddRadioContainer().setText("���񋟖����{���Z");

      recuperationManagementGuidanceInfoAddRadio.setBindPath("1340104");

      recuperationManagementGuidanceInfoAddRadio.setUseClearButton(false);

      recuperationManagementGuidanceInfoAddRadio.setModel(getRecuperationManagementGuidanceInfoAddRadioModel());

      addRecuperationManagementGuidanceInfoAddRadio();
    }
    return recuperationManagementGuidanceInfoAddRadio;

  }

  /**
   * ���񋟖����{���Z�R���e�i���擾���܂��B
   * @return ���񋟖����{���Z�R���e�i
   */
  protected ACLabelContainer getRecuperationManagementGuidanceInfoAddRadioContainer(){
    if(recuperationManagementGuidanceInfoAddRadioContainer==null){
      recuperationManagementGuidanceInfoAddRadioContainer = new ACLabelContainer();
      recuperationManagementGuidanceInfoAddRadioContainer.setFollowChildEnabled(true);
      recuperationManagementGuidanceInfoAddRadioContainer.setVAlignment(VRLayout.CENTER);
      recuperationManagementGuidanceInfoAddRadioContainer.add(getRecuperationManagementGuidanceInfoAddRadio(), null);
    }
    return recuperationManagementGuidanceInfoAddRadioContainer;
  }

  /**
   * ���񋟖����{���Z���f�����擾���܂��B
   * @return ���񋟖����{���Z���f��
   */
  protected ACListModelAdapter getRecuperationManagementGuidanceInfoAddRadioModel(){
    if(recuperationManagementGuidanceInfoAddRadioModel==null){
      recuperationManagementGuidanceInfoAddRadioModel = new ACListModelAdapter();
      addRecuperationManagementGuidanceInfoAddRadioModel();
    }
    return recuperationManagementGuidanceInfoAddRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getRecuperationManagementGuidanceInfoAddRadioItem1(){
    if(recuperationManagementGuidanceInfoAddRadioItem1==null){

      recuperationManagementGuidanceInfoAddRadioItem1 = new ACRadioButtonItem();

      recuperationManagementGuidanceInfoAddRadioItem1.setText("�Ȃ�");

      recuperationManagementGuidanceInfoAddRadioItem1.setGroup(getRecuperationManagementGuidanceInfoAddRadio());

      recuperationManagementGuidanceInfoAddRadioItem1.setConstraints(VRLayout.FLOW);

      addRecuperationManagementGuidanceInfoAddRadioItem1();
    }
    return recuperationManagementGuidanceInfoAddRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getRecuperationManagementGuidanceInfoAddRadioItem2(){
    if(recuperationManagementGuidanceInfoAddRadioItem2==null){

      recuperationManagementGuidanceInfoAddRadioItem2 = new ACRadioButtonItem();

      recuperationManagementGuidanceInfoAddRadioItem2.setText("����");

      recuperationManagementGuidanceInfoAddRadioItem2.setGroup(getRecuperationManagementGuidanceInfoAddRadio());

      recuperationManagementGuidanceInfoAddRadioItem2.setConstraints(VRLayout.FLOW);

      addRecuperationManagementGuidanceInfoAddRadioItem2();
    }
    return recuperationManagementGuidanceInfoAddRadioItem2;

  }

  /**
   * �����ҋ敪���擾���܂��B
   * @return �����ҋ敪
   */
  public ACGroupBox getRecuperationManagementGuidanceTimesGroup(){
    if(recuperationManagementGuidanceTimesGroup==null){

      recuperationManagementGuidanceTimesGroup = new ACGroupBox();

      recuperationManagementGuidanceTimesGroup.setText("��܎t����×{�Ǘ��w����");

      recuperationManagementGuidanceTimesGroup.setFollowChildEnabled(false);

      addRecuperationManagementGuidanceTimesGroup();
    }
    return recuperationManagementGuidanceTimesGroup;

  }

  /**
   * ���ݒn�敪���擾���܂��B
   * @return ���ݒn�敪
   */
  public ACValueArrayRadioButtonGroup getPatientDivisionRadio(){
    if(patientDivisionRadio==null){

      patientDivisionRadio = new ACValueArrayRadioButtonGroup();

      getPatientDivisionRadioContainer().setText("���ݒn�敪");

      patientDivisionRadio.setBindPath("1340110");

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
   * �ݑ�p�҂��擾���܂��B
   * @return �ݑ�p��
   */
  public ACRadioButtonItem getPatientDivisionRadioItem1(){
    if(patientDivisionRadioItem1==null){

      patientDivisionRadioItem1 = new ACRadioButtonItem();

      patientDivisionRadioItem1.setText("�ݑ�p��");

      patientDivisionRadioItem1.setGroup(getPatientDivisionRadio());

      patientDivisionRadioItem1.setConstraints(VRLayout.FLOW_RETURN);

      addPatientDivisionRadioItem1();
    }
    return patientDivisionRadioItem1;

  }

  /**
   * ����n�{�ݓ����҂��擾���܂��B
   * @return ����n�{�ݓ�����
   */
  public ACRadioButtonItem getPatientDivisionRadioItem2(){
    if(patientDivisionRadioItem2==null){

      patientDivisionRadioItem2 = new ACRadioButtonItem();

      patientDivisionRadioItem2.setText("����n�{�ݓ�����");

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
   * �Ō�E���敪���擾���܂��B
   * @return �Ō�E���敪
   */
  public ACClearableRadioButtonGroup getKyotakuClass(){
    if(kyotakuClass==null){

      kyotakuClass = new ACClearableRadioButtonGroup();

      getKyotakuClassContainer().setText("�Ō�E���敪");

      kyotakuClass.setBindPath("1340109");

      kyotakuClass.setUseClearButton(false);

      kyotakuClass.setModel(getKyotakuClassModel());

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
  public QS001134_H2104Design() {

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

    tab1.add(getRecuperationManagementGuidanceOccupationalCategoryContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getRecuperationManagementGuidanceOccupationalCategoryZaiSouShinRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getRecuperationManagementGuidanceInfoAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getRecuperationManagementGuidanceTimesGroup(), VRLayout.FLOW_RETURN);

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

    getRecuperationManagementGuidanceOccupationalCategoryDoctor().setButtonIndex(1);

    getRecuperationManagementGuidanceOccupationalCategoryModel().add(getRecuperationManagementGuidanceOccupationalCategoryDoctor());

    getRecuperationManagementGuidanceOccupationalCategoryDentist().setButtonIndex(2);

    getRecuperationManagementGuidanceOccupationalCategoryModel().add(getRecuperationManagementGuidanceOccupationalCategoryDentist());

    getRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacist().setButtonIndex(3);

    getRecuperationManagementGuidanceOccupationalCategoryModel().add(getRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacist());

    getRecuperationManagementGuidanceOccupationalCategoryDrugstorePharmacist().setButtonIndex(4);

    getRecuperationManagementGuidanceOccupationalCategoryModel().add(getRecuperationManagementGuidanceOccupationalCategoryDrugstorePharmacist());

    getRecuperationManagementGuidanceOccupationalCategoryDietitian().setButtonIndex(5);

    getRecuperationManagementGuidanceOccupationalCategoryModel().add(getRecuperationManagementGuidanceOccupationalCategoryDietitian());

    getRecuperationManagementGuidanceOccupationalCategoryEtc().setButtonIndex(6);

    getRecuperationManagementGuidanceOccupationalCategoryModel().add(getRecuperationManagementGuidanceOccupationalCategoryEtc());

    getRecuperationManagementGuidanceOccupationalCategoryHealth().setButtonIndex(7);

    getRecuperationManagementGuidanceOccupationalCategoryModel().add(getRecuperationManagementGuidanceOccupationalCategoryHealth());

  }

  /**
   * ��t�ɓ������ڂ�ǉ����܂��B
   */
  protected void addRecuperationManagementGuidanceOccupationalCategoryDoctor(){

  }

  /**
   * ���Ȉ�t�ɓ������ڂ�ǉ����܂��B
   */
  protected void addRecuperationManagementGuidanceOccupationalCategoryDentist(){

  }

  /**
   * ��܎t�i��Ë@�ցj�ɓ������ڂ�ǉ����܂��B
   */
  protected void addRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacist(){

  }

  /**
   * ��܎t�i��ǁj�ɓ������ڂ�ǉ����܂��B
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
   * �Ō�E���ɓ������ڂ�ǉ����܂��B
   */
  protected void addRecuperationManagementGuidanceOccupationalCategoryHealth(){

  }

  /**
   * ��w�����Ǘ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addRecuperationManagementGuidanceOccupationalCategoryZaiSouShinRadio(){

  }

  /**
   * ��w�����Ǘ������f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addRecuperationManagementGuidanceOccupationalCategoryZaiSouShinRadioModel(){

    getRecuperationManagementGuidanceOccupationalCategoryZaiSouShinRadioItem1().setButtonIndex(1);

    getRecuperationManagementGuidanceOccupationalCategoryZaiSouShinRadioModel().add(getRecuperationManagementGuidanceOccupationalCategoryZaiSouShinRadioItem1());

    getRecuperationManagementGuidanceOccupationalCategoryZaiSouShinRadioItem2().setButtonIndex(2);

    getRecuperationManagementGuidanceOccupationalCategoryZaiSouShinRadioModel().add(getRecuperationManagementGuidanceOccupationalCategoryZaiSouShinRadioItem2());

  }

  /**
   * �Ȃ��i�w���� ( I ) 500�P�ʁj�ɓ������ڂ�ǉ����܂��B
   */
  protected void addRecuperationManagementGuidanceOccupationalCategoryZaiSouShinRadioItem1(){

  }

  /**
   * ����i�w���� ( II ) 290�P�ʁj�ɓ������ڂ�ǉ����܂��B
   */
  protected void addRecuperationManagementGuidanceOccupationalCategoryZaiSouShinRadioItem2(){

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
   * ���񋟖����{���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addRecuperationManagementGuidanceInfoAddRadio(){

  }

  /**
   * ���񋟖����{���Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addRecuperationManagementGuidanceInfoAddRadioModel(){

    getRecuperationManagementGuidanceInfoAddRadioItem1().setButtonIndex(1);

    getRecuperationManagementGuidanceInfoAddRadioModel().add(getRecuperationManagementGuidanceInfoAddRadioItem1());

    getRecuperationManagementGuidanceInfoAddRadioItem2().setButtonIndex(2);

    getRecuperationManagementGuidanceInfoAddRadioModel().add(getRecuperationManagementGuidanceInfoAddRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addRecuperationManagementGuidanceInfoAddRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addRecuperationManagementGuidanceInfoAddRadioItem2(){

  }

  /**
   * �����ҋ敪�ɓ������ڂ�ǉ����܂��B
   */
  protected void addRecuperationManagementGuidanceTimesGroup(){

    recuperationManagementGuidanceTimesGroup.add(getPatientDivisionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    recuperationManagementGuidanceTimesGroup.add(getRecuperationManagementGuidanceTimesCancerEndCheck(), VRLayout.FLOW);

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
   * �ݑ�p�҂ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatientDivisionRadioItem1(){

  }

  /**
   * ����n�{�ݓ����҂ɓ������ڂ�ǉ����܂��B
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

    tab2.add(getKyotakuClassContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getRecuperationManagementGuidanceTimeContena(), VRLayout.FLOW_DOUBLEINSETLINE_RETURN);

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
      ACFrame.debugStart(new ACAffairInfo(QS001134_H2104Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QS001134_H2104Design getThis() {
    return this;
  }
}
