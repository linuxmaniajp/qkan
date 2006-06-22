
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
 * �쐬��: 2006/03/19  ���{�R���s���[�^�[������� ���{�@�K�� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �\��Ǘ� (S)
 * �v���Z�X ���p�҈ꗗ�i�T�[�r�X�\��쐬/�ύX�j (001)
 * �v���O���� �T�[�r�X�p�^�[���ʏ����n (QS001108)
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
import jp.or.med.orca.qkan.text.*;
/**
 * �T�[�r�X�p�^�[���ʏ����n��ʍ��ڃf�U�C��(QS001108) 
 */
public class QS001108Design extends QS001ServicePanel {
  //GUI�R���|�[�l���g

  private JTabbedPane tabs;

  private ACPanel tab1;

  private ACLabelContainer houmonRehabilitationTimeFacilityDivisionContena;

  private ACClearableRadioButtonGroup houmonRehabilitationTimeContenaFacilityDivision;

  private ACListModelAdapter houmonRehabilitationTimeContenaFacilityDivisionModel;

  private ACRadioButtonItem houmonRehabilitationMedicalInstitution;

  private ACRadioButtonItem houmonRehabilitationDouble;

  private ACRadioButtonItem houmonRehabilitationClinic;

  private ACIntegerCheckBox houmonRehabilitationLarge;

  private ACComboBox houmonRehabilitationTimeDivision;

  private ACLabelContainer houmonRehabilitationTimeDivisionContainer;

  private ACComboBoxModelAdapter houmonRehabilitationTimeDivisionModel;

  private ACClearableRadioButtonGroup houmonRehabilitationBathRadio;

  private ACLabelContainer houmonRehabilitationBathRadioContainer;

  private ACListModelAdapter houmonRehabilitationBathRadioModel;

  private ACRadioButtonItem houmonRehabilitationBathRadioItem1;

  private ACRadioButtonItem houmonRehabilitationBathRadioItem2;

  private ACClearableRadioButtonGroup houmonRehabilitationAdditionTreatmentPersonRadio;

  private ACLabelContainer houmonRehabilitationAdditionTreatmentPersonRadioContainer;

  private ACListModelAdapter houmonRehabilitationAdditionTreatmentPersonRadioModel;

  private ACRadioButtonItem houmonRehabilitationAdditionTreatmentPersonRadioItem1;

  private ACRadioButtonItem houmonRehabilitationAdditionTreatmentPersonRadioItem2;

  private ACClearableRadioButtonGroup houmonRehabilitationManagementAddRadio;

  private ACLabelContainer houmonRehabilitationManagementAddRadioContainer;

  private ACListModelAdapter houmonRehabilitationManagementAddRadioModel;

  private ACRadioButtonItem houmonRehabilitationManagementAddRadioItem1;

  private ACRadioButtonItem houmonRehabilitationManagementAddRadioItem2;

  private ACClearableRadioButtonGroup houmonRehabilitationShortConcentrationAddRadio;

  private ACLabelContainer houmonRehabilitationShortConcentrationAddRadioContainer;

  private ACListModelAdapter houmonRehabilitationShortConcentrationAddRadioModel;

  private ACRadioButtonItem houmonRehabilitationShortConcentrationAddRadioItem1;

  private ACRadioButtonItem houmonRehabilitationShortConcentrationAddRadioItem2;

  private ACRadioButtonItem houmonRehabilitationShortConcentrationAddRadioItem3;

  private ACRadioButtonItem houmonRehabilitationShortConcentrationAddRadioItem4;

  private ACBackLabelContainer houmonRehabilitationTimeContena;

  private ACTimeComboBox houmonRehabilitationTimeContenaBeginTime;

  private ACLabelContainer houmonRehabilitationTimeContenaBeginTimeContainer;

  private ACComboBoxModelAdapter houmonRehabilitationTimeContenaBeginTimeModel;

  private ACTimeComboBox houmonRehabilitationTimeContenaEndTime;

  private ACLabelContainer houmonRehabilitationTimeContenaEndTimeContainer;

  private ACComboBoxModelAdapter houmonRehabilitationTimeContenaEndTimeModel;

  private ACPanel tab2;

  private ACClearableRadioButtonGroup houmonRehabilitationYouthNinchishoAddRadio;

  private ACLabelContainer houmonRehabilitationYouthNinchishoAddRadioContainer;

  private ACListModelAdapter houmonRehabilitationYouthNinchishoAddRadioModel;

  private ACRadioButtonItem houmonRehabilitationYouthNinchishoAddRadioItem1;

  private ACRadioButtonItem houmonRehabilitationYouthNinchishoAddRadioItem2;

  private ACClearableRadioButtonGroup houmonRehabilitationNourishmentManagementAddRadio;

  private ACLabelContainer houmonRehabilitationNourishmentManagementAddRadioContainer;

  private ACListModelAdapter houmonRehabilitationNourishmentManagementAddRadioModel;

  private ACRadioButtonItem houmonRehabilitationNourishmentManagementAddRadioItem1;

  private ACRadioButtonItem houmonRehabilitationNourishmentManagementAddRadioItem2;

  private ACClearableRadioButtonGroup houmonRehabilitationMouthFunctionAddRadio;

  private ACLabelContainer houmonRehabilitationMouthFunctionAddRadioContainer;

  private ACListModelAdapter houmonRehabilitationMouthFunctionAddRadioModel;

  private ACRadioButtonItem houmonRehabilitationMouthFunctionAddRadioItem1;

  private ACRadioButtonItem houmonRehabilitationMouthFunctionAddRadioItem2;

  private ACClearableRadioButtonGroup houmonRehabilitationSubtraction;

  private ACLabelContainer houmonRehabilitationSubtractionContainer;

  private ACListModelAdapter houmonRehabilitationSubtractionModel;

  private ACRadioButtonItem houmonRehabilitationSubtractionNot;

  private ACRadioButtonItem houmonRehabilitationSubtractionExcess;

  private ACRadioButtonItem houmonRehabilitationSubtractionLack;

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

      tab1.setHgap(0);

      addTab1();
    }
    return tab1;

  }

  /**
   * �{�ݓ��̋敪�R���e�i���擾���܂��B
   * @return �{�ݓ��̋敪�R���e�i
   */
  public ACLabelContainer getHoumonRehabilitationTimeFacilityDivisionContena(){
    if(houmonRehabilitationTimeFacilityDivisionContena==null){

      houmonRehabilitationTimeFacilityDivisionContena = new ACLabelContainer();

      houmonRehabilitationTimeFacilityDivisionContena.setText("�{�ݓ��̋敪");

      addHoumonRehabilitationTimeFacilityDivisionContena();
    }
    return houmonRehabilitationTimeFacilityDivisionContena;

  }

  /**
   * �{�ݓ��̋敪���擾���܂��B
   * @return �{�ݓ��̋敪
   */
  public ACClearableRadioButtonGroup getHoumonRehabilitationTimeContenaFacilityDivision(){
    if(houmonRehabilitationTimeContenaFacilityDivision==null){

      houmonRehabilitationTimeContenaFacilityDivision = new ACClearableRadioButtonGroup();

      houmonRehabilitationTimeContenaFacilityDivision.setBindPath("1160103");

      houmonRehabilitationTimeContenaFacilityDivision.setModel(getHoumonRehabilitationTimeContenaFacilityDivisionModel());

      houmonRehabilitationTimeContenaFacilityDivision.setUseClearButton(false);

      addHoumonRehabilitationTimeContenaFacilityDivision();
    }
    return houmonRehabilitationTimeContenaFacilityDivision;

  }

  /**
   * �{�ݓ��̋敪���f�����擾���܂��B
   * @return �{�ݓ��̋敪���f��
   */
  protected ACListModelAdapter getHoumonRehabilitationTimeContenaFacilityDivisionModel(){
    if(houmonRehabilitationTimeContenaFacilityDivisionModel==null){
      houmonRehabilitationTimeContenaFacilityDivisionModel = new ACListModelAdapter();
      addHoumonRehabilitationTimeContenaFacilityDivisionModel();
    }
    return houmonRehabilitationTimeContenaFacilityDivisionModel;
  }

  /**
   * �ʏ�K�͈�Ë@�ւ��擾���܂��B
   * @return �ʏ�K�͈�Ë@��
   */
  public ACRadioButtonItem getHoumonRehabilitationMedicalInstitution(){
    if(houmonRehabilitationMedicalInstitution==null){

      houmonRehabilitationMedicalInstitution = new ACRadioButtonItem();

      houmonRehabilitationMedicalInstitution.setText("�ʏ�K�͈�Ë@��");

      houmonRehabilitationMedicalInstitution.setGroup(getHoumonRehabilitationTimeContenaFacilityDivision());

      houmonRehabilitationMedicalInstitution.setConstraints(VRLayout.FLOW);

      addHoumonRehabilitationMedicalInstitution();
    }
    return houmonRehabilitationMedicalInstitution;

  }

  /**
   * ���K�͐f�Ï����擾���܂��B
   * @return ���K�͐f�Ï�
   */
  public ACRadioButtonItem getHoumonRehabilitationDouble(){
    if(houmonRehabilitationDouble==null){

      houmonRehabilitationDouble = new ACRadioButtonItem();

      houmonRehabilitationDouble.setText("���K�͐f�Ï�");

      houmonRehabilitationDouble.setGroup(getHoumonRehabilitationTimeContenaFacilityDivision());

      houmonRehabilitationDouble.setConstraints(VRLayout.FLOW_RETURN);

      addHoumonRehabilitationDouble();
    }
    return houmonRehabilitationDouble;

  }

  /**
   * ���V�l�ی��{�݂��擾���܂��B
   * @return ���V�l�ی��{��
   */
  public ACRadioButtonItem getHoumonRehabilitationClinic(){
    if(houmonRehabilitationClinic==null){

      houmonRehabilitationClinic = new ACRadioButtonItem();

      houmonRehabilitationClinic.setText("���V�l�ی��{��");

      houmonRehabilitationClinic.setGroup(getHoumonRehabilitationTimeContenaFacilityDivision());

      houmonRehabilitationClinic.setConstraints(VRLayout.FLOW);

      addHoumonRehabilitationClinic();
    }
    return houmonRehabilitationClinic;

  }

  /**
   * ��K�͎��Ə����擾���܂��B
   * @return ��K�͎��Ə�
   */
  public ACIntegerCheckBox getHoumonRehabilitationLarge(){
    if(houmonRehabilitationLarge==null){

      houmonRehabilitationLarge = new ACIntegerCheckBox();

      houmonRehabilitationLarge.setText("��K�͎��Ə�");

      houmonRehabilitationLarge.setBindPath("1160110");

      houmonRehabilitationLarge.setSelectValue(2);

      houmonRehabilitationLarge.setUnSelectValue(1);

      addHoumonRehabilitationLarge();
    }
    return houmonRehabilitationLarge;

  }

  /**
   * ���ԋ敪���擾���܂��B
   * @return ���ԋ敪
   */
  public ACComboBox getHoumonRehabilitationTimeDivision(){
    if(houmonRehabilitationTimeDivision==null){

      houmonRehabilitationTimeDivision = new ACComboBox();

      getHoumonRehabilitationTimeDivisionContainer().setText("���ԋ敪");

      houmonRehabilitationTimeDivision.setBindPath("1160104");

      houmonRehabilitationTimeDivision.setEditable(false);

      houmonRehabilitationTimeDivision.setModelBindPath("1160104");

      houmonRehabilitationTimeDivision.setModel(getHoumonRehabilitationTimeDivisionModel());

      houmonRehabilitationTimeDivision.setRenderBindPath("CONTENT");

      addHoumonRehabilitationTimeDivision();
    }
    return houmonRehabilitationTimeDivision;

  }

  /**
   * ���ԋ敪�R���e�i���擾���܂��B
   * @return ���ԋ敪�R���e�i
   */
  protected ACLabelContainer getHoumonRehabilitationTimeDivisionContainer(){
    if(houmonRehabilitationTimeDivisionContainer==null){
      houmonRehabilitationTimeDivisionContainer = new ACLabelContainer();
      houmonRehabilitationTimeDivisionContainer.setFollowChildEnabled(true);
      houmonRehabilitationTimeDivisionContainer.setVAlignment(VRLayout.CENTER);
      houmonRehabilitationTimeDivisionContainer.add(getHoumonRehabilitationTimeDivision(), null);
    }
    return houmonRehabilitationTimeDivisionContainer;
  }

  /**
   * ���ԋ敪���f�����擾���܂��B
   * @return ���ԋ敪���f��
   */
  protected ACComboBoxModelAdapter getHoumonRehabilitationTimeDivisionModel(){
    if(houmonRehabilitationTimeDivisionModel==null){
      houmonRehabilitationTimeDivisionModel = new ACComboBoxModelAdapter();
      addHoumonRehabilitationTimeDivisionModel();
    }
    return houmonRehabilitationTimeDivisionModel;
  }

  /**
   * �������Z���擾���܂��B
   * @return �������Z
   */
  public ACClearableRadioButtonGroup getHoumonRehabilitationBathRadio(){
    if(houmonRehabilitationBathRadio==null){

      houmonRehabilitationBathRadio = new ACClearableRadioButtonGroup();

      getHoumonRehabilitationBathRadioContainer().setText("�������Z");

      houmonRehabilitationBathRadio.setBindPath("1160105");

      houmonRehabilitationBathRadio.setModel(getHoumonRehabilitationBathRadioModel());

      houmonRehabilitationBathRadio.setUseClearButton(false);

      addHoumonRehabilitationBathRadio();
    }
    return houmonRehabilitationBathRadio;

  }

  /**
   * �������Z�R���e�i���擾���܂��B
   * @return �������Z�R���e�i
   */
  protected ACLabelContainer getHoumonRehabilitationBathRadioContainer(){
    if(houmonRehabilitationBathRadioContainer==null){
      houmonRehabilitationBathRadioContainer = new ACLabelContainer();
      houmonRehabilitationBathRadioContainer.setFollowChildEnabled(true);
      houmonRehabilitationBathRadioContainer.setVAlignment(VRLayout.CENTER);
      houmonRehabilitationBathRadioContainer.add(getHoumonRehabilitationBathRadio(), null);
    }
    return houmonRehabilitationBathRadioContainer;
  }

  /**
   * �������Z���f�����擾���܂��B
   * @return �������Z���f��
   */
  protected ACListModelAdapter getHoumonRehabilitationBathRadioModel(){
    if(houmonRehabilitationBathRadioModel==null){
      houmonRehabilitationBathRadioModel = new ACListModelAdapter();
      addHoumonRehabilitationBathRadioModel();
    }
    return houmonRehabilitationBathRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getHoumonRehabilitationBathRadioItem1(){
    if(houmonRehabilitationBathRadioItem1==null){

      houmonRehabilitationBathRadioItem1 = new ACRadioButtonItem();

      houmonRehabilitationBathRadioItem1.setText("�Ȃ�");

      houmonRehabilitationBathRadioItem1.setGroup(getHoumonRehabilitationBathRadio());

      houmonRehabilitationBathRadioItem1.setConstraints(VRLayout.FLOW);

      addHoumonRehabilitationBathRadioItem1();
    }
    return houmonRehabilitationBathRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getHoumonRehabilitationBathRadioItem2(){
    if(houmonRehabilitationBathRadioItem2==null){

      houmonRehabilitationBathRadioItem2 = new ACRadioButtonItem();

      houmonRehabilitationBathRadioItem2.setText("����");

      houmonRehabilitationBathRadioItem2.setGroup(getHoumonRehabilitationBathRadio());

      houmonRehabilitationBathRadioItem2.setConstraints(VRLayout.FLOW);

      addHoumonRehabilitationBathRadioItem2();
    }
    return houmonRehabilitationBathRadioItem2;

  }

  /**
   * ���n�r���K��w�������Z���擾���܂��B
   * @return ���n�r���K��w�������Z
   */
  public ACClearableRadioButtonGroup getHoumonRehabilitationAdditionTreatmentPersonRadio(){
    if(houmonRehabilitationAdditionTreatmentPersonRadio==null){

      houmonRehabilitationAdditionTreatmentPersonRadio = new ACClearableRadioButtonGroup();

      getHoumonRehabilitationAdditionTreatmentPersonRadioContainer().setText("���n�r���K��w�������Z");

      houmonRehabilitationAdditionTreatmentPersonRadio.setBindPath("1160107");

      houmonRehabilitationAdditionTreatmentPersonRadio.setModel(getHoumonRehabilitationAdditionTreatmentPersonRadioModel());

      houmonRehabilitationAdditionTreatmentPersonRadio.setUseClearButton(false);

      addHoumonRehabilitationAdditionTreatmentPersonRadio();
    }
    return houmonRehabilitationAdditionTreatmentPersonRadio;

  }

  /**
   * ���n�r���K��w�������Z�R���e�i���擾���܂��B
   * @return ���n�r���K��w�������Z�R���e�i
   */
  protected ACLabelContainer getHoumonRehabilitationAdditionTreatmentPersonRadioContainer(){
    if(houmonRehabilitationAdditionTreatmentPersonRadioContainer==null){
      houmonRehabilitationAdditionTreatmentPersonRadioContainer = new ACLabelContainer();
      houmonRehabilitationAdditionTreatmentPersonRadioContainer.setFollowChildEnabled(true);
      houmonRehabilitationAdditionTreatmentPersonRadioContainer.setVAlignment(VRLayout.CENTER);
      houmonRehabilitationAdditionTreatmentPersonRadioContainer.add(getHoumonRehabilitationAdditionTreatmentPersonRadio(), null);
    }
    return houmonRehabilitationAdditionTreatmentPersonRadioContainer;
  }

  /**
   * ���n�r���K��w�������Z���f�����擾���܂��B
   * @return ���n�r���K��w�������Z���f��
   */
  protected ACListModelAdapter getHoumonRehabilitationAdditionTreatmentPersonRadioModel(){
    if(houmonRehabilitationAdditionTreatmentPersonRadioModel==null){
      houmonRehabilitationAdditionTreatmentPersonRadioModel = new ACListModelAdapter();
      addHoumonRehabilitationAdditionTreatmentPersonRadioModel();
    }
    return houmonRehabilitationAdditionTreatmentPersonRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getHoumonRehabilitationAdditionTreatmentPersonRadioItem1(){
    if(houmonRehabilitationAdditionTreatmentPersonRadioItem1==null){

      houmonRehabilitationAdditionTreatmentPersonRadioItem1 = new ACRadioButtonItem();

      houmonRehabilitationAdditionTreatmentPersonRadioItem1.setText("�Ȃ�");

      houmonRehabilitationAdditionTreatmentPersonRadioItem1.setGroup(getHoumonRehabilitationAdditionTreatmentPersonRadio());

      houmonRehabilitationAdditionTreatmentPersonRadioItem1.setConstraints(VRLayout.FLOW);

      addHoumonRehabilitationAdditionTreatmentPersonRadioItem1();
    }
    return houmonRehabilitationAdditionTreatmentPersonRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getHoumonRehabilitationAdditionTreatmentPersonRadioItem2(){
    if(houmonRehabilitationAdditionTreatmentPersonRadioItem2==null){

      houmonRehabilitationAdditionTreatmentPersonRadioItem2 = new ACRadioButtonItem();

      houmonRehabilitationAdditionTreatmentPersonRadioItem2.setText("����");

      houmonRehabilitationAdditionTreatmentPersonRadioItem2.setGroup(getHoumonRehabilitationAdditionTreatmentPersonRadio());

      houmonRehabilitationAdditionTreatmentPersonRadioItem2.setConstraints(VRLayout.FLOW);

      addHoumonRehabilitationAdditionTreatmentPersonRadioItem2();
    }
    return houmonRehabilitationAdditionTreatmentPersonRadioItem2;

  }

  /**
   * ���n�r���E�}�l�W�����g���Z���擾���܂��B
   * @return ���n�r���E�}�l�W�����g���Z
   */
  public ACClearableRadioButtonGroup getHoumonRehabilitationManagementAddRadio(){
    if(houmonRehabilitationManagementAddRadio==null){

      houmonRehabilitationManagementAddRadio = new ACClearableRadioButtonGroup();

      getHoumonRehabilitationManagementAddRadioContainer().setText("���n�r���E�}�l�W�����g���Z");

      houmonRehabilitationManagementAddRadio.setBindPath("1160111");

      houmonRehabilitationManagementAddRadio.setModel(getHoumonRehabilitationManagementAddRadioModel());

      houmonRehabilitationManagementAddRadio.setUseClearButton(false);

      addHoumonRehabilitationManagementAddRadio();
    }
    return houmonRehabilitationManagementAddRadio;

  }

  /**
   * ���n�r���E�}�l�W�����g���Z�R���e�i���擾���܂��B
   * @return ���n�r���E�}�l�W�����g���Z�R���e�i
   */
  protected ACLabelContainer getHoumonRehabilitationManagementAddRadioContainer(){
    if(houmonRehabilitationManagementAddRadioContainer==null){
      houmonRehabilitationManagementAddRadioContainer = new ACLabelContainer();
      houmonRehabilitationManagementAddRadioContainer.setFollowChildEnabled(true);
      houmonRehabilitationManagementAddRadioContainer.setVAlignment(VRLayout.CENTER);
      houmonRehabilitationManagementAddRadioContainer.add(getHoumonRehabilitationManagementAddRadio(), null);
    }
    return houmonRehabilitationManagementAddRadioContainer;
  }

  /**
   * ���n�r���E�}�l�W�����g���Z���f�����擾���܂��B
   * @return ���n�r���E�}�l�W�����g���Z���f��
   */
  protected ACListModelAdapter getHoumonRehabilitationManagementAddRadioModel(){
    if(houmonRehabilitationManagementAddRadioModel==null){
      houmonRehabilitationManagementAddRadioModel = new ACListModelAdapter();
      addHoumonRehabilitationManagementAddRadioModel();
    }
    return houmonRehabilitationManagementAddRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getHoumonRehabilitationManagementAddRadioItem1(){
    if(houmonRehabilitationManagementAddRadioItem1==null){

      houmonRehabilitationManagementAddRadioItem1 = new ACRadioButtonItem();

      houmonRehabilitationManagementAddRadioItem1.setText("�Ȃ�");

      houmonRehabilitationManagementAddRadioItem1.setGroup(getHoumonRehabilitationManagementAddRadio());

      houmonRehabilitationManagementAddRadioItem1.setConstraints(VRLayout.FLOW);

      addHoumonRehabilitationManagementAddRadioItem1();
    }
    return houmonRehabilitationManagementAddRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getHoumonRehabilitationManagementAddRadioItem2(){
    if(houmonRehabilitationManagementAddRadioItem2==null){

      houmonRehabilitationManagementAddRadioItem2 = new ACRadioButtonItem();

      houmonRehabilitationManagementAddRadioItem2.setText("����");

      houmonRehabilitationManagementAddRadioItem2.setGroup(getHoumonRehabilitationManagementAddRadio());

      houmonRehabilitationManagementAddRadioItem2.setConstraints(VRLayout.FLOW);

      addHoumonRehabilitationManagementAddRadioItem2();
    }
    return houmonRehabilitationManagementAddRadioItem2;

  }

  /**
   * �Z���W�����n�r�����Z���擾���܂��B
   * @return �Z���W�����n�r�����Z
   */
  public ACClearableRadioButtonGroup getHoumonRehabilitationShortConcentrationAddRadio(){
    if(houmonRehabilitationShortConcentrationAddRadio==null){

      houmonRehabilitationShortConcentrationAddRadio = new ACClearableRadioButtonGroup();

      getHoumonRehabilitationShortConcentrationAddRadioContainer().setText("�Z���W�����n�r�����Z");

      houmonRehabilitationShortConcentrationAddRadio.setBindPath("1160112");

      houmonRehabilitationShortConcentrationAddRadio.setModel(getHoumonRehabilitationShortConcentrationAddRadioModel());

      houmonRehabilitationShortConcentrationAddRadio.setUseClearButton(false);

      addHoumonRehabilitationShortConcentrationAddRadio();
    }
    return houmonRehabilitationShortConcentrationAddRadio;

  }

  /**
   * �Z���W�����n�r�����Z�R���e�i���擾���܂��B
   * @return �Z���W�����n�r�����Z�R���e�i
   */
  protected ACLabelContainer getHoumonRehabilitationShortConcentrationAddRadioContainer(){
    if(houmonRehabilitationShortConcentrationAddRadioContainer==null){
      houmonRehabilitationShortConcentrationAddRadioContainer = new ACLabelContainer();
      houmonRehabilitationShortConcentrationAddRadioContainer.setFollowChildEnabled(true);
      houmonRehabilitationShortConcentrationAddRadioContainer.setVAlignment(VRLayout.CENTER);
      houmonRehabilitationShortConcentrationAddRadioContainer.add(getHoumonRehabilitationShortConcentrationAddRadio(), null);
    }
    return houmonRehabilitationShortConcentrationAddRadioContainer;
  }

  /**
   * �Z���W�����n�r�����Z���f�����擾���܂��B
   * @return �Z���W�����n�r�����Z���f��
   */
  protected ACListModelAdapter getHoumonRehabilitationShortConcentrationAddRadioModel(){
    if(houmonRehabilitationShortConcentrationAddRadioModel==null){
      houmonRehabilitationShortConcentrationAddRadioModel = new ACListModelAdapter();
      addHoumonRehabilitationShortConcentrationAddRadioModel();
    }
    return houmonRehabilitationShortConcentrationAddRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getHoumonRehabilitationShortConcentrationAddRadioItem1(){
    if(houmonRehabilitationShortConcentrationAddRadioItem1==null){

      houmonRehabilitationShortConcentrationAddRadioItem1 = new ACRadioButtonItem();

      houmonRehabilitationShortConcentrationAddRadioItem1.setText("�Ȃ�");

      houmonRehabilitationShortConcentrationAddRadioItem1.setGroup(getHoumonRehabilitationShortConcentrationAddRadio());

      houmonRehabilitationShortConcentrationAddRadioItem1.setConstraints(VRLayout.FLOW);

      addHoumonRehabilitationShortConcentrationAddRadioItem1();
    }
    return houmonRehabilitationShortConcentrationAddRadioItem1;

  }

  /**
   * 1���ȓ����擾���܂��B
   * @return 1���ȓ�
   */
  public ACRadioButtonItem getHoumonRehabilitationShortConcentrationAddRadioItem2(){
    if(houmonRehabilitationShortConcentrationAddRadioItem2==null){

      houmonRehabilitationShortConcentrationAddRadioItem2 = new ACRadioButtonItem();

      houmonRehabilitationShortConcentrationAddRadioItem2.setText("1���ȓ�");

      houmonRehabilitationShortConcentrationAddRadioItem2.setGroup(getHoumonRehabilitationShortConcentrationAddRadio());

      houmonRehabilitationShortConcentrationAddRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

      addHoumonRehabilitationShortConcentrationAddRadioItem2();
    }
    return houmonRehabilitationShortConcentrationAddRadioItem2;

  }

  /**
   * 1����3���ȓ����擾���܂��B
   * @return 1����3���ȓ�
   */
  public ACRadioButtonItem getHoumonRehabilitationShortConcentrationAddRadioItem3(){
    if(houmonRehabilitationShortConcentrationAddRadioItem3==null){

      houmonRehabilitationShortConcentrationAddRadioItem3 = new ACRadioButtonItem();

      houmonRehabilitationShortConcentrationAddRadioItem3.setText("1����3���ȓ�");

      houmonRehabilitationShortConcentrationAddRadioItem3.setGroup(getHoumonRehabilitationShortConcentrationAddRadio());

      houmonRehabilitationShortConcentrationAddRadioItem3.setConstraints(VRLayout.FLOW);

      addHoumonRehabilitationShortConcentrationAddRadioItem3();
    }
    return houmonRehabilitationShortConcentrationAddRadioItem3;

  }

  /**
   * 3�������擾���܂��B
   * @return 3����
   */
  public ACRadioButtonItem getHoumonRehabilitationShortConcentrationAddRadioItem4(){
    if(houmonRehabilitationShortConcentrationAddRadioItem4==null){

      houmonRehabilitationShortConcentrationAddRadioItem4 = new ACRadioButtonItem();

      houmonRehabilitationShortConcentrationAddRadioItem4.setText("3����");

      houmonRehabilitationShortConcentrationAddRadioItem4.setGroup(getHoumonRehabilitationShortConcentrationAddRadio());

      houmonRehabilitationShortConcentrationAddRadioItem4.setConstraints(VRLayout.FLOW);

      addHoumonRehabilitationShortConcentrationAddRadioItem4();
    }
    return houmonRehabilitationShortConcentrationAddRadioItem4;

  }

  /**
   * �񋟎��ԃR���e�i���擾���܂��B
   * @return �񋟎��ԃR���e�i
   */
  public ACBackLabelContainer getHoumonRehabilitationTimeContena(){
    if(houmonRehabilitationTimeContena==null){

      houmonRehabilitationTimeContena = new ACBackLabelContainer();

      addHoumonRehabilitationTimeContena();
    }
    return houmonRehabilitationTimeContena;

  }

  /**
   * �J�n�����R���{���擾���܂��B
   * @return �J�n�����R���{
   */
  public ACTimeComboBox getHoumonRehabilitationTimeContenaBeginTime(){
    if(houmonRehabilitationTimeContenaBeginTime==null){

      houmonRehabilitationTimeContenaBeginTime = new ACTimeComboBox();

      getHoumonRehabilitationTimeContenaBeginTimeContainer().setText("�J�n����");

      houmonRehabilitationTimeContenaBeginTime.setBindPath("3");

      houmonRehabilitationTimeContenaBeginTime.setModelBindPath("3");

      houmonRehabilitationTimeContenaBeginTime.setModel(getHoumonRehabilitationTimeContenaBeginTimeModel());

      houmonRehabilitationTimeContenaBeginTime.setRenderBindPath("CONTENT");

      addHoumonRehabilitationTimeContenaBeginTime();
    }
    return houmonRehabilitationTimeContenaBeginTime;

  }

  /**
   * �J�n�����R���{�R���e�i���擾���܂��B
   * @return �J�n�����R���{�R���e�i
   */
  protected ACLabelContainer getHoumonRehabilitationTimeContenaBeginTimeContainer(){
    if(houmonRehabilitationTimeContenaBeginTimeContainer==null){
      houmonRehabilitationTimeContenaBeginTimeContainer = new ACLabelContainer();
      houmonRehabilitationTimeContenaBeginTimeContainer.setFollowChildEnabled(true);
      houmonRehabilitationTimeContenaBeginTimeContainer.setVAlignment(VRLayout.CENTER);
      houmonRehabilitationTimeContenaBeginTimeContainer.add(getHoumonRehabilitationTimeContenaBeginTime(), null);
    }
    return houmonRehabilitationTimeContenaBeginTimeContainer;
  }

  /**
   * �J�n�����R���{���f�����擾���܂��B
   * @return �J�n�����R���{���f��
   */
  protected ACComboBoxModelAdapter getHoumonRehabilitationTimeContenaBeginTimeModel(){
    if(houmonRehabilitationTimeContenaBeginTimeModel==null){
      houmonRehabilitationTimeContenaBeginTimeModel = new ACComboBoxModelAdapter();
      addHoumonRehabilitationTimeContenaBeginTimeModel();
    }
    return houmonRehabilitationTimeContenaBeginTimeModel;
  }

  /**
   * �I�������R���{���擾���܂��B
   * @return �I�������R���{
   */
  public ACTimeComboBox getHoumonRehabilitationTimeContenaEndTime(){
    if(houmonRehabilitationTimeContenaEndTime==null){

      houmonRehabilitationTimeContenaEndTime = new ACTimeComboBox();

      getHoumonRehabilitationTimeContenaEndTimeContainer().setText("�I������");

      houmonRehabilitationTimeContenaEndTime.setBindPath("4");

      houmonRehabilitationTimeContenaEndTime.setModelBindPath("4");

      houmonRehabilitationTimeContenaEndTime.setModel(getHoumonRehabilitationTimeContenaEndTimeModel());

      houmonRehabilitationTimeContenaEndTime.setRenderBindPath("CONTENT");

      addHoumonRehabilitationTimeContenaEndTime();
    }
    return houmonRehabilitationTimeContenaEndTime;

  }

  /**
   * �I�������R���{�R���e�i���擾���܂��B
   * @return �I�������R���{�R���e�i
   */
  protected ACLabelContainer getHoumonRehabilitationTimeContenaEndTimeContainer(){
    if(houmonRehabilitationTimeContenaEndTimeContainer==null){
      houmonRehabilitationTimeContenaEndTimeContainer = new ACLabelContainer();
      houmonRehabilitationTimeContenaEndTimeContainer.setFollowChildEnabled(true);
      houmonRehabilitationTimeContenaEndTimeContainer.setVAlignment(VRLayout.CENTER);
      houmonRehabilitationTimeContenaEndTimeContainer.add(getHoumonRehabilitationTimeContenaEndTime(), null);
    }
    return houmonRehabilitationTimeContenaEndTimeContainer;
  }

  /**
   * �I�������R���{���f�����擾���܂��B
   * @return �I�������R���{���f��
   */
  protected ACComboBoxModelAdapter getHoumonRehabilitationTimeContenaEndTimeModel(){
    if(houmonRehabilitationTimeContenaEndTimeModel==null){
      houmonRehabilitationTimeContenaEndTimeModel = new ACComboBoxModelAdapter();
      addHoumonRehabilitationTimeContenaEndTimeModel();
    }
    return houmonRehabilitationTimeContenaEndTimeModel;
  }

  /**
   * �^�u2���擾���܂��B
   * @return �^�u2
   */
  public ACPanel getTab2(){
    if(tab2==null){

      tab2 = new ACPanel();

      tab2.setHgap(0);

      addTab2();
    }
    return tab2;

  }

  /**
   * ��N���F�m�ǃP�A���Z���擾���܂��B
   * @return ��N���F�m�ǃP�A���Z
   */
  public ACClearableRadioButtonGroup getHoumonRehabilitationYouthNinchishoAddRadio(){
    if(houmonRehabilitationYouthNinchishoAddRadio==null){

      houmonRehabilitationYouthNinchishoAddRadio = new ACClearableRadioButtonGroup();

      getHoumonRehabilitationYouthNinchishoAddRadioContainer().setText("��N���F�m�ǃP�A���Z");

      houmonRehabilitationYouthNinchishoAddRadio.setBindPath("1160113");

      houmonRehabilitationYouthNinchishoAddRadio.setModel(getHoumonRehabilitationYouthNinchishoAddRadioModel());

      houmonRehabilitationYouthNinchishoAddRadio.setUseClearButton(false);

      addHoumonRehabilitationYouthNinchishoAddRadio();
    }
    return houmonRehabilitationYouthNinchishoAddRadio;

  }

  /**
   * ��N���F�m�ǃP�A���Z�R���e�i���擾���܂��B
   * @return ��N���F�m�ǃP�A���Z�R���e�i
   */
  protected ACLabelContainer getHoumonRehabilitationYouthNinchishoAddRadioContainer(){
    if(houmonRehabilitationYouthNinchishoAddRadioContainer==null){
      houmonRehabilitationYouthNinchishoAddRadioContainer = new ACLabelContainer();
      houmonRehabilitationYouthNinchishoAddRadioContainer.setFollowChildEnabled(true);
      houmonRehabilitationYouthNinchishoAddRadioContainer.setVAlignment(VRLayout.CENTER);
      houmonRehabilitationYouthNinchishoAddRadioContainer.add(getHoumonRehabilitationYouthNinchishoAddRadio(), null);
    }
    return houmonRehabilitationYouthNinchishoAddRadioContainer;
  }

  /**
   * ��N���F�m�ǃP�A���Z���f�����擾���܂��B
   * @return ��N���F�m�ǃP�A���Z���f��
   */
  protected ACListModelAdapter getHoumonRehabilitationYouthNinchishoAddRadioModel(){
    if(houmonRehabilitationYouthNinchishoAddRadioModel==null){
      houmonRehabilitationYouthNinchishoAddRadioModel = new ACListModelAdapter();
      addHoumonRehabilitationYouthNinchishoAddRadioModel();
    }
    return houmonRehabilitationYouthNinchishoAddRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getHoumonRehabilitationYouthNinchishoAddRadioItem1(){
    if(houmonRehabilitationYouthNinchishoAddRadioItem1==null){

      houmonRehabilitationYouthNinchishoAddRadioItem1 = new ACRadioButtonItem();

      houmonRehabilitationYouthNinchishoAddRadioItem1.setText("�Ȃ�");

      houmonRehabilitationYouthNinchishoAddRadioItem1.setGroup(getHoumonRehabilitationYouthNinchishoAddRadio());

      houmonRehabilitationYouthNinchishoAddRadioItem1.setConstraints(VRLayout.FLOW);

      addHoumonRehabilitationYouthNinchishoAddRadioItem1();
    }
    return houmonRehabilitationYouthNinchishoAddRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getHoumonRehabilitationYouthNinchishoAddRadioItem2(){
    if(houmonRehabilitationYouthNinchishoAddRadioItem2==null){

      houmonRehabilitationYouthNinchishoAddRadioItem2 = new ACRadioButtonItem();

      houmonRehabilitationYouthNinchishoAddRadioItem2.setText("����");

      houmonRehabilitationYouthNinchishoAddRadioItem2.setGroup(getHoumonRehabilitationYouthNinchishoAddRadio());

      houmonRehabilitationYouthNinchishoAddRadioItem2.setConstraints(VRLayout.FLOW);

      addHoumonRehabilitationYouthNinchishoAddRadioItem2();
    }
    return houmonRehabilitationYouthNinchishoAddRadioItem2;

  }

  /**
   * �h�{�}�l�W�����g���Z���擾���܂��B
   * @return �h�{�}�l�W�����g���Z
   */
  public ACClearableRadioButtonGroup getHoumonRehabilitationNourishmentManagementAddRadio(){
    if(houmonRehabilitationNourishmentManagementAddRadio==null){

      houmonRehabilitationNourishmentManagementAddRadio = new ACClearableRadioButtonGroup();

      getHoumonRehabilitationNourishmentManagementAddRadioContainer().setText("�h�{�}�l�W�����g���Z");

      houmonRehabilitationNourishmentManagementAddRadio.setBindPath("1160114");

      houmonRehabilitationNourishmentManagementAddRadio.setModel(getHoumonRehabilitationNourishmentManagementAddRadioModel());

      houmonRehabilitationNourishmentManagementAddRadio.setUseClearButton(false);

      addHoumonRehabilitationNourishmentManagementAddRadio();
    }
    return houmonRehabilitationNourishmentManagementAddRadio;

  }

  /**
   * �h�{�}�l�W�����g���Z�R���e�i���擾���܂��B
   * @return �h�{�}�l�W�����g���Z�R���e�i
   */
  protected ACLabelContainer getHoumonRehabilitationNourishmentManagementAddRadioContainer(){
    if(houmonRehabilitationNourishmentManagementAddRadioContainer==null){
      houmonRehabilitationNourishmentManagementAddRadioContainer = new ACLabelContainer();
      houmonRehabilitationNourishmentManagementAddRadioContainer.setFollowChildEnabled(true);
      houmonRehabilitationNourishmentManagementAddRadioContainer.setVAlignment(VRLayout.CENTER);
      houmonRehabilitationNourishmentManagementAddRadioContainer.add(getHoumonRehabilitationNourishmentManagementAddRadio(), null);
    }
    return houmonRehabilitationNourishmentManagementAddRadioContainer;
  }

  /**
   * �h�{�}�l�W�����g���Z���f�����擾���܂��B
   * @return �h�{�}�l�W�����g���Z���f��
   */
  protected ACListModelAdapter getHoumonRehabilitationNourishmentManagementAddRadioModel(){
    if(houmonRehabilitationNourishmentManagementAddRadioModel==null){
      houmonRehabilitationNourishmentManagementAddRadioModel = new ACListModelAdapter();
      addHoumonRehabilitationNourishmentManagementAddRadioModel();
    }
    return houmonRehabilitationNourishmentManagementAddRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getHoumonRehabilitationNourishmentManagementAddRadioItem1(){
    if(houmonRehabilitationNourishmentManagementAddRadioItem1==null){

      houmonRehabilitationNourishmentManagementAddRadioItem1 = new ACRadioButtonItem();

      houmonRehabilitationNourishmentManagementAddRadioItem1.setText("�Ȃ�");

      houmonRehabilitationNourishmentManagementAddRadioItem1.setGroup(getHoumonRehabilitationNourishmentManagementAddRadio());

      houmonRehabilitationNourishmentManagementAddRadioItem1.setConstraints(VRLayout.FLOW);

      addHoumonRehabilitationNourishmentManagementAddRadioItem1();
    }
    return houmonRehabilitationNourishmentManagementAddRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getHoumonRehabilitationNourishmentManagementAddRadioItem2(){
    if(houmonRehabilitationNourishmentManagementAddRadioItem2==null){

      houmonRehabilitationNourishmentManagementAddRadioItem2 = new ACRadioButtonItem();

      houmonRehabilitationNourishmentManagementAddRadioItem2.setText("����");

      houmonRehabilitationNourishmentManagementAddRadioItem2.setGroup(getHoumonRehabilitationNourishmentManagementAddRadio());

      houmonRehabilitationNourishmentManagementAddRadioItem2.setConstraints(VRLayout.FLOW);

      addHoumonRehabilitationNourishmentManagementAddRadioItem2();
    }
    return houmonRehabilitationNourishmentManagementAddRadioItem2;

  }

  /**
   * ���o�@�\������Z���擾���܂��B
   * @return ���o�@�\������Z
   */
  public ACClearableRadioButtonGroup getHoumonRehabilitationMouthFunctionAddRadio(){
    if(houmonRehabilitationMouthFunctionAddRadio==null){

      houmonRehabilitationMouthFunctionAddRadio = new ACClearableRadioButtonGroup();

      getHoumonRehabilitationMouthFunctionAddRadioContainer().setText("���o�@�\������Z");

      houmonRehabilitationMouthFunctionAddRadio.setBindPath("1160115");

      houmonRehabilitationMouthFunctionAddRadio.setModel(getHoumonRehabilitationMouthFunctionAddRadioModel());

      houmonRehabilitationMouthFunctionAddRadio.setUseClearButton(false);

      addHoumonRehabilitationMouthFunctionAddRadio();
    }
    return houmonRehabilitationMouthFunctionAddRadio;

  }

  /**
   * ���o�@�\������Z�R���e�i���擾���܂��B
   * @return ���o�@�\������Z�R���e�i
   */
  protected ACLabelContainer getHoumonRehabilitationMouthFunctionAddRadioContainer(){
    if(houmonRehabilitationMouthFunctionAddRadioContainer==null){
      houmonRehabilitationMouthFunctionAddRadioContainer = new ACLabelContainer();
      houmonRehabilitationMouthFunctionAddRadioContainer.setFollowChildEnabled(true);
      houmonRehabilitationMouthFunctionAddRadioContainer.setVAlignment(VRLayout.CENTER);
      houmonRehabilitationMouthFunctionAddRadioContainer.add(getHoumonRehabilitationMouthFunctionAddRadio(), null);
    }
    return houmonRehabilitationMouthFunctionAddRadioContainer;
  }

  /**
   * ���o�@�\������Z���f�����擾���܂��B
   * @return ���o�@�\������Z���f��
   */
  protected ACListModelAdapter getHoumonRehabilitationMouthFunctionAddRadioModel(){
    if(houmonRehabilitationMouthFunctionAddRadioModel==null){
      houmonRehabilitationMouthFunctionAddRadioModel = new ACListModelAdapter();
      addHoumonRehabilitationMouthFunctionAddRadioModel();
    }
    return houmonRehabilitationMouthFunctionAddRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getHoumonRehabilitationMouthFunctionAddRadioItem1(){
    if(houmonRehabilitationMouthFunctionAddRadioItem1==null){

      houmonRehabilitationMouthFunctionAddRadioItem1 = new ACRadioButtonItem();

      houmonRehabilitationMouthFunctionAddRadioItem1.setText("�Ȃ�");

      houmonRehabilitationMouthFunctionAddRadioItem1.setGroup(getHoumonRehabilitationMouthFunctionAddRadio());

      houmonRehabilitationMouthFunctionAddRadioItem1.setConstraints(VRLayout.FLOW);

      addHoumonRehabilitationMouthFunctionAddRadioItem1();
    }
    return houmonRehabilitationMouthFunctionAddRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getHoumonRehabilitationMouthFunctionAddRadioItem2(){
    if(houmonRehabilitationMouthFunctionAddRadioItem2==null){

      houmonRehabilitationMouthFunctionAddRadioItem2 = new ACRadioButtonItem();

      houmonRehabilitationMouthFunctionAddRadioItem2.setText("����");

      houmonRehabilitationMouthFunctionAddRadioItem2.setGroup(getHoumonRehabilitationMouthFunctionAddRadio());

      houmonRehabilitationMouthFunctionAddRadioItem2.setConstraints(VRLayout.FLOW);

      addHoumonRehabilitationMouthFunctionAddRadioItem2();
    }
    return houmonRehabilitationMouthFunctionAddRadioItem2;

  }

  /**
   * �l�����Z���擾���܂��B
   * @return �l�����Z
   */
  public ACClearableRadioButtonGroup getHoumonRehabilitationSubtraction(){
    if(houmonRehabilitationSubtraction==null){

      houmonRehabilitationSubtraction = new ACClearableRadioButtonGroup();

      getHoumonRehabilitationSubtractionContainer().setText("�l�����Z");

      houmonRehabilitationSubtraction.setBindPath("1160109");

      houmonRehabilitationSubtraction.setModel(getHoumonRehabilitationSubtractionModel());

      houmonRehabilitationSubtraction.setUseClearButton(false);

      addHoumonRehabilitationSubtraction();
    }
    return houmonRehabilitationSubtraction;

  }

  /**
   * �l�����Z�R���e�i���擾���܂��B
   * @return �l�����Z�R���e�i
   */
  protected ACLabelContainer getHoumonRehabilitationSubtractionContainer(){
    if(houmonRehabilitationSubtractionContainer==null){
      houmonRehabilitationSubtractionContainer = new ACLabelContainer();
      houmonRehabilitationSubtractionContainer.setFollowChildEnabled(true);
      houmonRehabilitationSubtractionContainer.setVAlignment(VRLayout.CENTER);
      houmonRehabilitationSubtractionContainer.add(getHoumonRehabilitationSubtraction(), null);
    }
    return houmonRehabilitationSubtractionContainer;
  }

  /**
   * �l�����Z���f�����擾���܂��B
   * @return �l�����Z���f��
   */
  protected ACListModelAdapter getHoumonRehabilitationSubtractionModel(){
    if(houmonRehabilitationSubtractionModel==null){
      houmonRehabilitationSubtractionModel = new ACListModelAdapter();
      addHoumonRehabilitationSubtractionModel();
    }
    return houmonRehabilitationSubtractionModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getHoumonRehabilitationSubtractionNot(){
    if(houmonRehabilitationSubtractionNot==null){

      houmonRehabilitationSubtractionNot = new ACRadioButtonItem();

      houmonRehabilitationSubtractionNot.setText("�Ȃ�");

      houmonRehabilitationSubtractionNot.setGroup(getHoumonRehabilitationSubtraction());

      houmonRehabilitationSubtractionNot.setConstraints(VRLayout.FLOW);

      addHoumonRehabilitationSubtractionNot();
    }
    return houmonRehabilitationSubtractionNot;

  }

  /**
   * ������߂��擾���܂��B
   * @return �������
   */
  public ACRadioButtonItem getHoumonRehabilitationSubtractionExcess(){
    if(houmonRehabilitationSubtractionExcess==null){

      houmonRehabilitationSubtractionExcess = new ACRadioButtonItem();

      houmonRehabilitationSubtractionExcess.setText("�������");

      houmonRehabilitationSubtractionExcess.setGroup(getHoumonRehabilitationSubtraction());

      houmonRehabilitationSubtractionExcess.setConstraints(VRLayout.FLOW_RETURN);

      addHoumonRehabilitationSubtractionExcess();
    }
    return houmonRehabilitationSubtractionExcess;

  }

  /**
   * ��t�APT�EOT�EST�A�Ō�E���E���̕s�����擾���܂��B
   * @return ��t�APT�EOT�EST�A�Ō�E���E���̕s��
   */
  public ACRadioButtonItem getHoumonRehabilitationSubtractionLack(){
    if(houmonRehabilitationSubtractionLack==null){

      houmonRehabilitationSubtractionLack = new ACRadioButtonItem();

      houmonRehabilitationSubtractionLack.setText("<html>��t�APT�EOT�EST�A<br>�Ō�E���E���̕s��</html>");

      houmonRehabilitationSubtractionLack.setGroup(getHoumonRehabilitationSubtraction());

      houmonRehabilitationSubtractionLack.setConstraints(VRLayout.FLOW);

      addHoumonRehabilitationSubtractionLack();
    }
    return houmonRehabilitationSubtractionLack;

  }

  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001108Design() {

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

    tab1.add(getHoumonRehabilitationTimeFacilityDivisionContena(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getHoumonRehabilitationTimeDivisionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getHoumonRehabilitationBathRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getHoumonRehabilitationAdditionTreatmentPersonRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getHoumonRehabilitationManagementAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getHoumonRehabilitationShortConcentrationAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getHoumonRehabilitationTimeContena(), VRLayout.FLOW_DOUBLEINSETLINE_RETURN);

  }

  /**
   * �{�ݓ��̋敪�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonRehabilitationTimeFacilityDivisionContena(){

    houmonRehabilitationTimeFacilityDivisionContena.add(getHoumonRehabilitationTimeContenaFacilityDivision(), VRLayout.FLOW_INSETLINE_RETURN);

    houmonRehabilitationTimeFacilityDivisionContena.add(getHoumonRehabilitationLarge(), VRLayout.FLOW);

  }

  /**
   * �{�ݓ��̋敪�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonRehabilitationTimeContenaFacilityDivision(){

  }

  /**
   * �{�ݓ��̋敪���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonRehabilitationTimeContenaFacilityDivisionModel(){

    getHoumonRehabilitationMedicalInstitution().setButtonIndex(1);
    getHoumonRehabilitationTimeContenaFacilityDivisionModel().add(getHoumonRehabilitationMedicalInstitution());

    getHoumonRehabilitationDouble().setButtonIndex(2);
    getHoumonRehabilitationTimeContenaFacilityDivisionModel().add(getHoumonRehabilitationDouble());

    getHoumonRehabilitationClinic().setButtonIndex(3);
    getHoumonRehabilitationTimeContenaFacilityDivisionModel().add(getHoumonRehabilitationClinic());

  }

  /**
   * �ʏ�K�͈�Ë@�ւɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonRehabilitationMedicalInstitution(){

  }

  /**
   * ���K�͐f�Ï��ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonRehabilitationDouble(){

  }

  /**
   * ���V�l�ی��{�݂ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonRehabilitationClinic(){

  }

  /**
   * ��K�͎��Ə��ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonRehabilitationLarge(){

  }

  /**
   * ���ԋ敪�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonRehabilitationTimeDivision(){

  }

  /**
   * ���ԋ敪���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonRehabilitationTimeDivisionModel(){

  }

  /**
   * �������Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonRehabilitationBathRadio(){

  }

  /**
   * �������Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonRehabilitationBathRadioModel(){

    getHoumonRehabilitationBathRadioItem1().setButtonIndex(1);
    getHoumonRehabilitationBathRadioModel().add(getHoumonRehabilitationBathRadioItem1());

    getHoumonRehabilitationBathRadioItem2().setButtonIndex(2);
    getHoumonRehabilitationBathRadioModel().add(getHoumonRehabilitationBathRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonRehabilitationBathRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonRehabilitationBathRadioItem2(){

  }

  /**
   * ���n�r���K��w�������Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonRehabilitationAdditionTreatmentPersonRadio(){

  }

  /**
   * ���n�r���K��w�������Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonRehabilitationAdditionTreatmentPersonRadioModel(){

    getHoumonRehabilitationAdditionTreatmentPersonRadioItem1().setButtonIndex(1);
    getHoumonRehabilitationAdditionTreatmentPersonRadioModel().add(getHoumonRehabilitationAdditionTreatmentPersonRadioItem1());

    getHoumonRehabilitationAdditionTreatmentPersonRadioItem2().setButtonIndex(2);
    getHoumonRehabilitationAdditionTreatmentPersonRadioModel().add(getHoumonRehabilitationAdditionTreatmentPersonRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonRehabilitationAdditionTreatmentPersonRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonRehabilitationAdditionTreatmentPersonRadioItem2(){

  }

  /**
   * ���n�r���E�}�l�W�����g���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonRehabilitationManagementAddRadio(){

  }

  /**
   * ���n�r���E�}�l�W�����g���Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonRehabilitationManagementAddRadioModel(){

    getHoumonRehabilitationManagementAddRadioItem1().setButtonIndex(1);
    getHoumonRehabilitationManagementAddRadioModel().add(getHoumonRehabilitationManagementAddRadioItem1());

    getHoumonRehabilitationManagementAddRadioItem2().setButtonIndex(2);
    getHoumonRehabilitationManagementAddRadioModel().add(getHoumonRehabilitationManagementAddRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonRehabilitationManagementAddRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonRehabilitationManagementAddRadioItem2(){

  }

  /**
   * �Z���W�����n�r�����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonRehabilitationShortConcentrationAddRadio(){

  }

  /**
   * �Z���W�����n�r�����Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonRehabilitationShortConcentrationAddRadioModel(){

    getHoumonRehabilitationShortConcentrationAddRadioItem1().setButtonIndex(1);
    getHoumonRehabilitationShortConcentrationAddRadioModel().add(getHoumonRehabilitationShortConcentrationAddRadioItem1());

    getHoumonRehabilitationShortConcentrationAddRadioItem2().setButtonIndex(2);
    getHoumonRehabilitationShortConcentrationAddRadioModel().add(getHoumonRehabilitationShortConcentrationAddRadioItem2());

    getHoumonRehabilitationShortConcentrationAddRadioItem3().setButtonIndex(3);
    getHoumonRehabilitationShortConcentrationAddRadioModel().add(getHoumonRehabilitationShortConcentrationAddRadioItem3());

    getHoumonRehabilitationShortConcentrationAddRadioItem4().setButtonIndex(4);
    getHoumonRehabilitationShortConcentrationAddRadioModel().add(getHoumonRehabilitationShortConcentrationAddRadioItem4());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonRehabilitationShortConcentrationAddRadioItem1(){

  }

  /**
   * 1���ȓ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonRehabilitationShortConcentrationAddRadioItem2(){

  }

  /**
   * 1����3���ȓ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonRehabilitationShortConcentrationAddRadioItem3(){

  }

  /**
   * 3�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonRehabilitationShortConcentrationAddRadioItem4(){

  }

  /**
   * �񋟎��ԃR���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonRehabilitationTimeContena(){

    houmonRehabilitationTimeContena.add(getHoumonRehabilitationTimeContenaBeginTimeContainer(), VRLayout.FLOW);

    houmonRehabilitationTimeContena.add(getHoumonRehabilitationTimeContenaEndTimeContainer(), VRLayout.FLOW);

  }

  /**
   * �J�n�����R���{�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonRehabilitationTimeContenaBeginTime(){

  }

  /**
   * �J�n�����R���{���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonRehabilitationTimeContenaBeginTimeModel(){

  }

  /**
   * �I�������R���{�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonRehabilitationTimeContenaEndTime(){

  }

  /**
   * �I�������R���{���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonRehabilitationTimeContenaEndTimeModel(){

  }

  /**
   * �^�u2�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTab2(){

    tab2.add(getHoumonRehabilitationYouthNinchishoAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getHoumonRehabilitationNourishmentManagementAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getHoumonRehabilitationMouthFunctionAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getHoumonRehabilitationSubtractionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * ��N���F�m�ǃP�A���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonRehabilitationYouthNinchishoAddRadio(){

  }

  /**
   * ��N���F�m�ǃP�A���Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonRehabilitationYouthNinchishoAddRadioModel(){

    getHoumonRehabilitationYouthNinchishoAddRadioItem1().setButtonIndex(1);
    getHoumonRehabilitationYouthNinchishoAddRadioModel().add(getHoumonRehabilitationYouthNinchishoAddRadioItem1());

    getHoumonRehabilitationYouthNinchishoAddRadioItem2().setButtonIndex(2);
    getHoumonRehabilitationYouthNinchishoAddRadioModel().add(getHoumonRehabilitationYouthNinchishoAddRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonRehabilitationYouthNinchishoAddRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonRehabilitationYouthNinchishoAddRadioItem2(){

  }

  /**
   * �h�{�}�l�W�����g���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonRehabilitationNourishmentManagementAddRadio(){

  }

  /**
   * �h�{�}�l�W�����g���Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonRehabilitationNourishmentManagementAddRadioModel(){

    getHoumonRehabilitationNourishmentManagementAddRadioItem1().setButtonIndex(1);
    getHoumonRehabilitationNourishmentManagementAddRadioModel().add(getHoumonRehabilitationNourishmentManagementAddRadioItem1());

    getHoumonRehabilitationNourishmentManagementAddRadioItem2().setButtonIndex(2);
    getHoumonRehabilitationNourishmentManagementAddRadioModel().add(getHoumonRehabilitationNourishmentManagementAddRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonRehabilitationNourishmentManagementAddRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonRehabilitationNourishmentManagementAddRadioItem2(){

  }

  /**
   * ���o�@�\������Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonRehabilitationMouthFunctionAddRadio(){

  }

  /**
   * ���o�@�\������Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonRehabilitationMouthFunctionAddRadioModel(){

    getHoumonRehabilitationMouthFunctionAddRadioItem1().setButtonIndex(1);
    getHoumonRehabilitationMouthFunctionAddRadioModel().add(getHoumonRehabilitationMouthFunctionAddRadioItem1());

    getHoumonRehabilitationMouthFunctionAddRadioItem2().setButtonIndex(2);
    getHoumonRehabilitationMouthFunctionAddRadioModel().add(getHoumonRehabilitationMouthFunctionAddRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonRehabilitationMouthFunctionAddRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonRehabilitationMouthFunctionAddRadioItem2(){

  }

  /**
   * �l�����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonRehabilitationSubtraction(){

  }

  /**
   * �l�����Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonRehabilitationSubtractionModel(){

    getHoumonRehabilitationSubtractionNot().setButtonIndex(1);
    getHoumonRehabilitationSubtractionModel().add(getHoumonRehabilitationSubtractionNot());

    getHoumonRehabilitationSubtractionExcess().setButtonIndex(2);
    getHoumonRehabilitationSubtractionModel().add(getHoumonRehabilitationSubtractionExcess());

    getHoumonRehabilitationSubtractionLack().setButtonIndex(3);
    getHoumonRehabilitationSubtractionModel().add(getHoumonRehabilitationSubtractionLack());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonRehabilitationSubtractionNot(){

  }

  /**
   * ������߂ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonRehabilitationSubtractionExcess(){

  }

  /**
   * ��t�APT�EOT�EST�A�Ō�E���E���̕s���ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonRehabilitationSubtractionLack(){

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
      ACFrame.debugStart(new ACAffairInfo(QS001108Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QS001108Design getThis() {
    return this;
  }
}
