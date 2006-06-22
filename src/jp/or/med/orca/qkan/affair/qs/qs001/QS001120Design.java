
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
 * �쐬��: 2006/03/17  ���{�R���s���[�^�[������� ���{�@�K�� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �T�[�r�X�\��쐬/�ύX (S)
 * �v���Z�X �T�[�r�X�\��T�� (001)
 * �v���O���� �T�[�r�X�p�^�[�����×{�^��Î{�݁i�a�@�j (QS001120)
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
 * �T�[�r�X�p�^�[�����×{�^��Î{�݁i�a�@�j��ʍ��ڃf�U�C��(QS001120) 
 */
public class QS001120Design extends QS001ServicePanel {
  //GUI�R���|�[�l���g

  private JTabbedPane tabs;

  private ACPanel tab1;

  private ACClearableRadioButtonGroup medicalFacilityHospitalInstitutionDivisionRadio;

  private ACLabelContainer medicalFacilityHospitalInstitutionDivisionRadioContainer;

  private ACListModelAdapter medicalFacilityHospitalInstitutionDivisionRadioModel;

  private ACRadioButtonItem medicalFacilityHospitalHospitalInstitutionDivisionRadioItem1;

  private ACRadioButtonItem medicalFacilityHospitalHospitalInstitutionDivisionRadioItem2;

  private ACClearableRadioButtonGroup medicalFacilityHospitalHospitalDivision;

  private ACLabelContainer medicalFacilityHospitalHospitalDivisionContainer;

  private ACListModelAdapter medicalFacilityHospitalHospitalDivisionModel;

  private ACRadioButtonItem medicalFacilityHospitalDivision1;

  private ACRadioButtonItem medicalFacilityHospitalDivision2;

  private ACRadioButtonItem medicalFacilityHospitalDivision3;

  private ACLabelContainer medicalFacilityHospitalHospitalRoomContena;

  private ACClearableRadioButtonGroup medicalFacilityHospitalHospitalRoomRadio;

  private ACListModelAdapter medicalFacilityHospitalHospitalRoomRadioModel;

  private ACRadioButtonItem medicalFacilityHospitalHospitalRoomRadioItem1;

  private ACRadioButtonItem medicalFacilityHospitalHospitalRoomRadioItem2;

  private ACClearableRadioButtonGroup medicalFacilityHospitalUnitHospitalRoomRadio;

  private ACListModelAdapter medicalFacilityHospitalUnitHospitalRoomRadioModel;

  private ACRadioButtonItem medicalFacilityHospitalUnitHospitalRoomRadioItem1;

  private ACRadioButtonItem medicalFacilityHospitalUnitHospitalRoomRadioItem2;

  private ACClearableRadioButtonGroup medicalFacilityHospitalNightShiftSubtractionRadio;

  private ACLabelContainer medicalFacilityHospitalNightShiftSubtractionRadioContainer;

  private ACListModelAdapter medicalFacilityHospitalNightShiftSubtractionRadioModel;

  private ACRadioButtonItem medicalFacilityHospitalNightShiftSubtractionRadioItem1;

  private ACRadioButtonItem medicalFacilityHospitalNightShiftSubtractionRadioItem2;

  private ACRadioButtonItem medicalFacilityHospitalNightShiftSubtractionRadioItem3;

  private ACRadioButtonItem medicalFacilityHospitalNightShiftSubtractionRadioItem4;

  private ACRadioButtonItem medicalFacilityHospitalNightShiftSubtractionRadioItem5;

  private ACClearableRadioButtonGroup medicalFacilityHospitalEnvironmentalRadio;

  private ACLabelContainer medicalFacilityHospitalEnvironmentalRadioContainer;

  private ACListModelAdapter medicalFacilityHospitalEnvironmentalRadioModel;

  private ACRadioButtonItem medicalFacilityHospitalEnvironmentalRadioItem1;

  private ACRadioButtonItem medicalFacilityHospitalEnvironmentalRadioItem2;

  private ACRadioButtonItem medicalFacilityHospitalEnvironmentalRadioItem3;

  private ACRadioButtonItem medicalFacilityHospitalEnvironmentalRadioItem4;

  private ACClearableRadioButtonGroup medicalFacilityHospitalDoctorArrangeStandardRadio;

  private ACLabelContainer medicalFacilityHospitalDoctorArrangeStandardRadioContainer;

  private ACListModelAdapter medicalFacilityHospitalDoctorArrangeStandardRadioModel;

  private ACRadioButtonItem medicalFacilityHospitalDoctorArrangeStandardRadioItem1;

  private ACRadioButtonItem medicalFacilityHospitalDoctorArrangeStandardRadioItem2;

  private ACClearableRadioButtonGroup medicalFacilityHospitalStayRadio;

  private ACLabelContainer medicalFacilityHospitalStayRadioContainer;

  private ACListModelAdapter medicalFacilityHospitalStayRadioModel;

  private ACRadioButtonItem medicalFacilityHospitalStayRadioItem1;

  private ACRadioButtonItem medicalFacilityHospitalStayRadioItem2;

  private ACPanel tab2;

  private ACClearableRadioButtonGroup medicalFacilityHospitalStandardRadio;

  private ACLabelContainer medicalFacilityHospitalStandardRadioContainer;

  private ACListModelAdapter medicalFacilityHospitalStandardRadioModel;

  private ACRadioButtonItem medicalFacilityHospitalStandardRadioItem1;

  private ACRadioButtonItem medicalFacilityHospitalStandardRadioItem2;

  private ACClearableRadioButtonGroup medicalFacilityHospitalMedicalExaminationRadio;

  private ACLabelContainer medicalFacilityHospitalMedicalExaminationRadioContainer;

  private ACListModelAdapter medicalFacilityHospitalMedicalExaminationRadioModel;

  private ACRadioButtonItem medicalFacilityHospitalMedicalExaminationRadioItem1;

  private ACRadioButtonItem medicalFacilityHospitalMedicalExaminationRadioItem2;

  private ACClearableRadioButtonGroup medicalFacilityHospitalNutritionManageRadio;

  private ACLabelContainer medicalFacilityHospitalNutritionManageRadioContainer;

  private ACListModelAdapter medicalFacilityHospitalNutritionManageRadioModel;

  private ACRadioButtonItem medicalFacilityHospitalNutritionManageRadioItem1;

  private ACRadioButtonItem medicalFacilityHospitalNutritionManageRadioItem2;

  private ACRadioButtonItem medicalFacilityHospitalNutritionManageRadioItem3;

  private ACClearableRadioButtonGroup medicalFacilityHospitalNutritionRadio;

  private ACLabelContainer medicalFacilityHospitalNutritionRadioContainer;

  private ACListModelAdapter medicalFacilityHospitalNutritionRadioModel;

  private ACRadioButtonItem medicalFacilityHospitalNutritionRadioItem1;

  private ACRadioButtonItem medicalFacilityHospitalNutritionRadioItem2;

  private ACClearableRadioButtonGroup medicalFacilityHospitalOralSwitchRadio;

  private ACLabelContainer medicalFacilityHospitalOralSwitchRadioContainer;

  private ACListModelAdapter medicalFacilityHospitalOralSwitchRadioModel;

  private ACRadioButtonItem medicalFacilityHospitalOralSwitchRadioItem1;

  private ACRadioButtonItem medicalFacilityHospitalOralSwitchRadioItem2;

  private ACClearableRadioButtonGroup oralMaintenanceRadio;

  private ACLabelContainer oralMaintenanceRadioContainer;

  private ACListModelAdapter oralMaintenanceRadioModel;

  private ACRadioButtonItem oralMaintenanceRadioItem1;

  private ACRadioButtonItem oralMaintenanceRadioItem2;

  private ACRadioButtonItem oralMaintenanceRadioItem3;

  private ACClearableRadioButtonGroup medicalFacilityHospitalRecuperateDinnerRadio;

  private ACLabelContainer medicalFacilityHospitalRecuperateDinnerRadioContainer;

  private ACListModelAdapter medicalFacilityHospitalRecuperateDinnerRadioModel;

  private ACRadioButtonItem medicalFacilityHospitalRecuperateDinnerRadioItem1;

  private ACRadioButtonItem medicalFacilityHospitalRecuperateDinnerRadioItem2;

  private ACLabelContainer medicalFacilityHospitalHijoAddition;

  private ACIntegerCheckBox leavingHospitalPreConsultationAddition;

  private ACIntegerCheckBox leavingHospitalConsultationAddition;

  private ACIntegerCheckBox leavingHospitalDissemination;

  private ACIntegerCheckBox leavingHospitalCooperationAddition;

  private ACIntegerCheckBox leavingHospital;

  private ACPanel tab3;

  private ACMapBindButton medicalFacilityHospitalConsultationFee;

  private ACLabel medicalFacilityHospitalConsultationFeeLabel;

  private ACComboBox medicalFacilityHospitalSubstraction;

  private ACLabelContainer medicalFacilityHospitalSubstractionContainer;

  private ACComboBoxModelAdapter medicalFacilityHospitalSubstractionModel;

  private ACBackLabelContainer medicalFacilityDinnerContainer;

  private ACComboBox medicalFacilityDinnerOffer;

  private ACLabelContainer medicalFacilityDinnerOfferContainer;

  private ACComboBoxModelAdapter medicalFacilityDinnerOfferModel;

  private ACTextField medicalFacilityDinnerCost;

  private ACLabelContainer medicalFacilityDinnerCostContainer;

  private ACClearableRadioButtonGroup unitCareMaintenanceRadio;

  private ACLabelContainer unitCareMaintenanceRadioContainer;

  private ACListModelAdapter unitCareMaintenanceRadioModel;

  private ACRadioButtonItem unitCareMaintenanceRadioItem1;

  private ACRadioButtonItem unitCareMaintenanceRadioItem2;

  private ACClearableRadioButtonGroup bodyRestraintAbolitionRadio;

  private ACLabelContainer bodyRestraintAbolitionRadioContainer;

  private ACListModelAdapter bodyRestraintAbolitionRadioModel;

  private ACRadioButtonItem bodyRestraintAbolitionRadioItem1;

  private ACRadioButtonItem bodyRestraintAbolitionRadioItem2;

  private ACClearableRadioButtonGroup stayReturnSupportAddRadio;

  private ACLabelContainer stayReturnSupportAddRadioContainer;

  private ACListModelAdapter stayReturnSupportAddRadioModel;

  private ACRadioButtonItem stayReturnSupportAddRadioItem1;

  private ACRadioButtonItem stayReturnSupportAddRadioItem2;

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
   * �{�ݓ��̋敪���擾���܂��B
   * @return �{�ݓ��̋敪
   */
  public ACClearableRadioButtonGroup getMedicalFacilityHospitalInstitutionDivisionRadio(){
    if(medicalFacilityHospitalInstitutionDivisionRadio==null){

      medicalFacilityHospitalInstitutionDivisionRadio = new ACClearableRadioButtonGroup();

      getMedicalFacilityHospitalInstitutionDivisionRadioContainer().setText("�{�ݓ��̋敪");

      medicalFacilityHospitalInstitutionDivisionRadio.setBindPath("1530101");

      medicalFacilityHospitalInstitutionDivisionRadio.setModel(getMedicalFacilityHospitalInstitutionDivisionRadioModel());

      medicalFacilityHospitalInstitutionDivisionRadio.setUseClearButton(false);

      addMedicalFacilityHospitalInstitutionDivisionRadio();
    }
    return medicalFacilityHospitalInstitutionDivisionRadio;

  }

  /**
   * �{�ݓ��̋敪�R���e�i���擾���܂��B
   * @return �{�ݓ��̋敪�R���e�i
   */
  protected ACLabelContainer getMedicalFacilityHospitalInstitutionDivisionRadioContainer(){
    if(medicalFacilityHospitalInstitutionDivisionRadioContainer==null){
      medicalFacilityHospitalInstitutionDivisionRadioContainer = new ACLabelContainer();
      medicalFacilityHospitalInstitutionDivisionRadioContainer.setFollowChildEnabled(true);
      medicalFacilityHospitalInstitutionDivisionRadioContainer.setVAlignment(VRLayout.CENTER);
      medicalFacilityHospitalInstitutionDivisionRadioContainer.add(getMedicalFacilityHospitalInstitutionDivisionRadio(), null);
    }
    return medicalFacilityHospitalInstitutionDivisionRadioContainer;
  }

  /**
   * �{�ݓ��̋敪���f�����擾���܂��B
   * @return �{�ݓ��̋敪���f��
   */
  protected ACListModelAdapter getMedicalFacilityHospitalInstitutionDivisionRadioModel(){
    if(medicalFacilityHospitalInstitutionDivisionRadioModel==null){
      medicalFacilityHospitalInstitutionDivisionRadioModel = new ACListModelAdapter();
      addMedicalFacilityHospitalInstitutionDivisionRadioModel();
    }
    return medicalFacilityHospitalInstitutionDivisionRadioModel;
  }

  /**
   * �a�@���擾���܂��B
   * @return �a�@
   */
  public ACRadioButtonItem getMedicalFacilityHospitalHospitalInstitutionDivisionRadioItem1(){
    if(medicalFacilityHospitalHospitalInstitutionDivisionRadioItem1==null){

      medicalFacilityHospitalHospitalInstitutionDivisionRadioItem1 = new ACRadioButtonItem();

      medicalFacilityHospitalHospitalInstitutionDivisionRadioItem1.setText("�a�@");

      medicalFacilityHospitalHospitalInstitutionDivisionRadioItem1.setGroup(getMedicalFacilityHospitalInstitutionDivisionRadio());

      medicalFacilityHospitalHospitalInstitutionDivisionRadioItem1.setConstraints(VRLayout.FLOW);

      addMedicalFacilityHospitalHospitalInstitutionDivisionRadioItem1();
    }
    return medicalFacilityHospitalHospitalInstitutionDivisionRadioItem1;

  }

  /**
   * ���j�b�g�^�a�@���擾���܂��B
   * @return ���j�b�g�^�a�@
   */
  public ACRadioButtonItem getMedicalFacilityHospitalHospitalInstitutionDivisionRadioItem2(){
    if(medicalFacilityHospitalHospitalInstitutionDivisionRadioItem2==null){

      medicalFacilityHospitalHospitalInstitutionDivisionRadioItem2 = new ACRadioButtonItem();

      medicalFacilityHospitalHospitalInstitutionDivisionRadioItem2.setText("���j�b�g�^�a�@");

      medicalFacilityHospitalHospitalInstitutionDivisionRadioItem2.setGroup(getMedicalFacilityHospitalInstitutionDivisionRadio());

      medicalFacilityHospitalHospitalInstitutionDivisionRadioItem2.setConstraints(VRLayout.FLOW);

      addMedicalFacilityHospitalHospitalInstitutionDivisionRadioItem2();
    }
    return medicalFacilityHospitalHospitalInstitutionDivisionRadioItem2;

  }

  /**
   * �l���z�u�敪���擾���܂��B
   * @return �l���z�u�敪
   */
  public ACClearableRadioButtonGroup getMedicalFacilityHospitalHospitalDivision(){
    if(medicalFacilityHospitalHospitalDivision==null){

      medicalFacilityHospitalHospitalDivision = new ACClearableRadioButtonGroup();

      getMedicalFacilityHospitalHospitalDivisionContainer().setText("�l���z�u�敪");

      medicalFacilityHospitalHospitalDivision.setBindPath("1530102");

      medicalFacilityHospitalHospitalDivision.setModel(getMedicalFacilityHospitalHospitalDivisionModel());

      medicalFacilityHospitalHospitalDivision.setUseClearButton(false);

      addMedicalFacilityHospitalHospitalDivision();
    }
    return medicalFacilityHospitalHospitalDivision;

  }

  /**
   * �l���z�u�敪�R���e�i���擾���܂��B
   * @return �l���z�u�敪�R���e�i
   */
  protected ACLabelContainer getMedicalFacilityHospitalHospitalDivisionContainer(){
    if(medicalFacilityHospitalHospitalDivisionContainer==null){
      medicalFacilityHospitalHospitalDivisionContainer = new ACLabelContainer();
      medicalFacilityHospitalHospitalDivisionContainer.setFollowChildEnabled(true);
      medicalFacilityHospitalHospitalDivisionContainer.setVAlignment(VRLayout.CENTER);
      medicalFacilityHospitalHospitalDivisionContainer.add(getMedicalFacilityHospitalHospitalDivision(), null);
    }
    return medicalFacilityHospitalHospitalDivisionContainer;
  }

  /**
   * �l���z�u�敪���f�����擾���܂��B
   * @return �l���z�u�敪���f��
   */
  protected ACListModelAdapter getMedicalFacilityHospitalHospitalDivisionModel(){
    if(medicalFacilityHospitalHospitalDivisionModel==null){
      medicalFacilityHospitalHospitalDivisionModel = new ACListModelAdapter();
      addMedicalFacilityHospitalHospitalDivisionModel();
    }
    return medicalFacilityHospitalHospitalDivisionModel;
  }

  /**
   * I�^���擾���܂��B
   * @return I�^
   */
  public ACRadioButtonItem getMedicalFacilityHospitalDivision1(){
    if(medicalFacilityHospitalDivision1==null){

      medicalFacilityHospitalDivision1 = new ACRadioButtonItem();

      medicalFacilityHospitalDivision1.setText("I�^");

      medicalFacilityHospitalDivision1.setGroup(getMedicalFacilityHospitalHospitalDivision());

      medicalFacilityHospitalDivision1.setConstraints(VRLayout.FLOW);

      addMedicalFacilityHospitalDivision1();
    }
    return medicalFacilityHospitalDivision1;

  }

  /**
   * II�^���擾���܂��B
   * @return II�^
   */
  public ACRadioButtonItem getMedicalFacilityHospitalDivision2(){
    if(medicalFacilityHospitalDivision2==null){

      medicalFacilityHospitalDivision2 = new ACRadioButtonItem();

      medicalFacilityHospitalDivision2.setText("II�^");

      medicalFacilityHospitalDivision2.setGroup(getMedicalFacilityHospitalHospitalDivision());

      medicalFacilityHospitalDivision2.setConstraints(VRLayout.FLOW);

      addMedicalFacilityHospitalDivision2();
    }
    return medicalFacilityHospitalDivision2;

  }

  /**
   * III�^���擾���܂��B
   * @return III�^
   */
  public ACRadioButtonItem getMedicalFacilityHospitalDivision3(){
    if(medicalFacilityHospitalDivision3==null){

      medicalFacilityHospitalDivision3 = new ACRadioButtonItem();

      medicalFacilityHospitalDivision3.setText("III�^");

      medicalFacilityHospitalDivision3.setGroup(getMedicalFacilityHospitalHospitalDivision());

      medicalFacilityHospitalDivision3.setConstraints(VRLayout.FLOW);

      addMedicalFacilityHospitalDivision3();
    }
    return medicalFacilityHospitalDivision3;

  }

  /**
   * �a���敪�R���e�i���擾���܂��B
   * @return �a���敪�R���e�i
   */
  public ACLabelContainer getMedicalFacilityHospitalHospitalRoomContena(){
    if(medicalFacilityHospitalHospitalRoomContena==null){

      medicalFacilityHospitalHospitalRoomContena = new ACLabelContainer();

      medicalFacilityHospitalHospitalRoomContena.setText("�a���敪");

      addMedicalFacilityHospitalHospitalRoomContena();
    }
    return medicalFacilityHospitalHospitalRoomContena;

  }

  /**
   * �a���敪�i�a�@�j���擾���܂��B
   * @return �a���敪�i�a�@�j
   */
  public ACClearableRadioButtonGroup getMedicalFacilityHospitalHospitalRoomRadio(){
    if(medicalFacilityHospitalHospitalRoomRadio==null){

      medicalFacilityHospitalHospitalRoomRadio = new ACClearableRadioButtonGroup();

      medicalFacilityHospitalHospitalRoomRadio.setBindPath("1530103");

      medicalFacilityHospitalHospitalRoomRadio.setModel(getMedicalFacilityHospitalHospitalRoomRadioModel());

      medicalFacilityHospitalHospitalRoomRadio.setUseClearButton(false);

      addMedicalFacilityHospitalHospitalRoomRadio();
    }
    return medicalFacilityHospitalHospitalRoomRadio;

  }

  /**
   * �a���敪�i�a�@�j���f�����擾���܂��B
   * @return �a���敪�i�a�@�j���f��
   */
  protected ACListModelAdapter getMedicalFacilityHospitalHospitalRoomRadioModel(){
    if(medicalFacilityHospitalHospitalRoomRadioModel==null){
      medicalFacilityHospitalHospitalRoomRadioModel = new ACListModelAdapter();
      addMedicalFacilityHospitalHospitalRoomRadioModel();
    }
    return medicalFacilityHospitalHospitalRoomRadioModel;
  }

  /**
   * �]���^�����擾���܂��B
   * @return �]���^��
   */
  public ACRadioButtonItem getMedicalFacilityHospitalHospitalRoomRadioItem1(){
    if(medicalFacilityHospitalHospitalRoomRadioItem1==null){

      medicalFacilityHospitalHospitalRoomRadioItem1 = new ACRadioButtonItem();

      medicalFacilityHospitalHospitalRoomRadioItem1.setText("�]���^��");

      medicalFacilityHospitalHospitalRoomRadioItem1.setGroup(getMedicalFacilityHospitalHospitalRoomRadio());

      medicalFacilityHospitalHospitalRoomRadioItem1.setConstraints(VRLayout.FLOW);

      addMedicalFacilityHospitalHospitalRoomRadioItem1();
    }
    return medicalFacilityHospitalHospitalRoomRadioItem1;

  }

  /**
   * ���������擾���܂��B
   * @return ������
   */
  public ACRadioButtonItem getMedicalFacilityHospitalHospitalRoomRadioItem2(){
    if(medicalFacilityHospitalHospitalRoomRadioItem2==null){

      medicalFacilityHospitalHospitalRoomRadioItem2 = new ACRadioButtonItem();

      medicalFacilityHospitalHospitalRoomRadioItem2.setText("������");

      medicalFacilityHospitalHospitalRoomRadioItem2.setGroup(getMedicalFacilityHospitalHospitalRoomRadio());

      medicalFacilityHospitalHospitalRoomRadioItem2.setConstraints(VRLayout.FLOW);

      addMedicalFacilityHospitalHospitalRoomRadioItem2();
    }
    return medicalFacilityHospitalHospitalRoomRadioItem2;

  }

  /**
   * �a���敪�i���j�b�g�^�j���擾���܂��B
   * @return �a���敪�i���j�b�g�^�j
   */
  public ACClearableRadioButtonGroup getMedicalFacilityHospitalUnitHospitalRoomRadio(){
    if(medicalFacilityHospitalUnitHospitalRoomRadio==null){

      medicalFacilityHospitalUnitHospitalRoomRadio = new ACClearableRadioButtonGroup();

      medicalFacilityHospitalUnitHospitalRoomRadio.setBindPath("1530104");

      medicalFacilityHospitalUnitHospitalRoomRadio.setModel(getMedicalFacilityHospitalUnitHospitalRoomRadioModel());

      medicalFacilityHospitalUnitHospitalRoomRadio.setUseClearButton(false);

      addMedicalFacilityHospitalUnitHospitalRoomRadio();
    }
    return medicalFacilityHospitalUnitHospitalRoomRadio;

  }

  /**
   * �a���敪�i���j�b�g�^�j���f�����擾���܂��B
   * @return �a���敪�i���j�b�g�^�j���f��
   */
  protected ACListModelAdapter getMedicalFacilityHospitalUnitHospitalRoomRadioModel(){
    if(medicalFacilityHospitalUnitHospitalRoomRadioModel==null){
      medicalFacilityHospitalUnitHospitalRoomRadioModel = new ACListModelAdapter();
      addMedicalFacilityHospitalUnitHospitalRoomRadioModel();
    }
    return medicalFacilityHospitalUnitHospitalRoomRadioModel;
  }

  /**
   * ���j�b�g�^�����擾���܂��B
   * @return ���j�b�g�^��
   */
  public ACRadioButtonItem getMedicalFacilityHospitalUnitHospitalRoomRadioItem1(){
    if(medicalFacilityHospitalUnitHospitalRoomRadioItem1==null){

      medicalFacilityHospitalUnitHospitalRoomRadioItem1 = new ACRadioButtonItem();

      medicalFacilityHospitalUnitHospitalRoomRadioItem1.setText("���j�b�g�^��");

      medicalFacilityHospitalUnitHospitalRoomRadioItem1.setGroup(getMedicalFacilityHospitalUnitHospitalRoomRadio());

      medicalFacilityHospitalUnitHospitalRoomRadioItem1.setConstraints(VRLayout.FLOW);

      addMedicalFacilityHospitalUnitHospitalRoomRadioItem1();
    }
    return medicalFacilityHospitalUnitHospitalRoomRadioItem1;

  }

  /**
   * ���j�b�g�^�������擾���܂��B
   * @return ���j�b�g�^����
   */
  public ACRadioButtonItem getMedicalFacilityHospitalUnitHospitalRoomRadioItem2(){
    if(medicalFacilityHospitalUnitHospitalRoomRadioItem2==null){

      medicalFacilityHospitalUnitHospitalRoomRadioItem2 = new ACRadioButtonItem();

      medicalFacilityHospitalUnitHospitalRoomRadioItem2.setText("���j�b�g�^����");

      medicalFacilityHospitalUnitHospitalRoomRadioItem2.setGroup(getMedicalFacilityHospitalUnitHospitalRoomRadio());

      medicalFacilityHospitalUnitHospitalRoomRadioItem2.setConstraints(VRLayout.FLOW);

      addMedicalFacilityHospitalUnitHospitalRoomRadioItem2();
    }
    return medicalFacilityHospitalUnitHospitalRoomRadioItem2;

  }

  /**
   * ��ԋΖ���������擾���܂��B
   * @return ��ԋΖ������
   */
  public ACClearableRadioButtonGroup getMedicalFacilityHospitalNightShiftSubtractionRadio(){
    if(medicalFacilityHospitalNightShiftSubtractionRadio==null){

      medicalFacilityHospitalNightShiftSubtractionRadio = new ACClearableRadioButtonGroup();

      getMedicalFacilityHospitalNightShiftSubtractionRadioContainer().setText("��ԋΖ������");

      medicalFacilityHospitalNightShiftSubtractionRadio.setBindPath("1530105");

      medicalFacilityHospitalNightShiftSubtractionRadio.setModel(getMedicalFacilityHospitalNightShiftSubtractionRadioModel());

      medicalFacilityHospitalNightShiftSubtractionRadio.setUseClearButton(false);

      addMedicalFacilityHospitalNightShiftSubtractionRadio();
    }
    return medicalFacilityHospitalNightShiftSubtractionRadio;

  }

  /**
   * ��ԋΖ�������R���e�i���擾���܂��B
   * @return ��ԋΖ�������R���e�i
   */
  protected ACLabelContainer getMedicalFacilityHospitalNightShiftSubtractionRadioContainer(){
    if(medicalFacilityHospitalNightShiftSubtractionRadioContainer==null){
      medicalFacilityHospitalNightShiftSubtractionRadioContainer = new ACLabelContainer();
      medicalFacilityHospitalNightShiftSubtractionRadioContainer.setFollowChildEnabled(true);
      medicalFacilityHospitalNightShiftSubtractionRadioContainer.setVAlignment(VRLayout.CENTER);
      medicalFacilityHospitalNightShiftSubtractionRadioContainer.add(getMedicalFacilityHospitalNightShiftSubtractionRadio(), null);
    }
    return medicalFacilityHospitalNightShiftSubtractionRadioContainer;
  }

  /**
   * ��ԋΖ���������f�����擾���܂��B
   * @return ��ԋΖ���������f��
   */
  protected ACListModelAdapter getMedicalFacilityHospitalNightShiftSubtractionRadioModel(){
    if(medicalFacilityHospitalNightShiftSubtractionRadioModel==null){
      medicalFacilityHospitalNightShiftSubtractionRadioModel = new ACListModelAdapter();
      addMedicalFacilityHospitalNightShiftSubtractionRadioModel();
    }
    return medicalFacilityHospitalNightShiftSubtractionRadioModel;
  }

  /**
   * ��^���擾���܂��B
   * @return ��^
   */
  public ACRadioButtonItem getMedicalFacilityHospitalNightShiftSubtractionRadioItem1(){
    if(medicalFacilityHospitalNightShiftSubtractionRadioItem1==null){

      medicalFacilityHospitalNightShiftSubtractionRadioItem1 = new ACRadioButtonItem();

      medicalFacilityHospitalNightShiftSubtractionRadioItem1.setText("��^");

      medicalFacilityHospitalNightShiftSubtractionRadioItem1.setGroup(getMedicalFacilityHospitalNightShiftSubtractionRadio());

      medicalFacilityHospitalNightShiftSubtractionRadioItem1.setConstraints(VRLayout.FLOW);

      addMedicalFacilityHospitalNightShiftSubtractionRadioItem1();
    }
    return medicalFacilityHospitalNightShiftSubtractionRadioItem1;

  }

  /**
   * ���Z�^I���擾���܂��B
   * @return ���Z�^I
   */
  public ACRadioButtonItem getMedicalFacilityHospitalNightShiftSubtractionRadioItem2(){
    if(medicalFacilityHospitalNightShiftSubtractionRadioItem2==null){

      medicalFacilityHospitalNightShiftSubtractionRadioItem2 = new ACRadioButtonItem();

      medicalFacilityHospitalNightShiftSubtractionRadioItem2.setText("���Z�^I");

      medicalFacilityHospitalNightShiftSubtractionRadioItem2.setGroup(getMedicalFacilityHospitalNightShiftSubtractionRadio());

      medicalFacilityHospitalNightShiftSubtractionRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

      addMedicalFacilityHospitalNightShiftSubtractionRadioItem2();
    }
    return medicalFacilityHospitalNightShiftSubtractionRadioItem2;

  }

  /**
   * ���Z�^II���擾���܂��B
   * @return ���Z�^II
   */
  public ACRadioButtonItem getMedicalFacilityHospitalNightShiftSubtractionRadioItem3(){
    if(medicalFacilityHospitalNightShiftSubtractionRadioItem3==null){

      medicalFacilityHospitalNightShiftSubtractionRadioItem3 = new ACRadioButtonItem();

      medicalFacilityHospitalNightShiftSubtractionRadioItem3.setText("���Z�^II");

      medicalFacilityHospitalNightShiftSubtractionRadioItem3.setGroup(getMedicalFacilityHospitalNightShiftSubtractionRadio());

      medicalFacilityHospitalNightShiftSubtractionRadioItem3.setConstraints(VRLayout.FLOW);

      addMedicalFacilityHospitalNightShiftSubtractionRadioItem3();
    }
    return medicalFacilityHospitalNightShiftSubtractionRadioItem3;

  }

  /**
   * ���Z�^III���擾���܂��B
   * @return ���Z�^III
   */
  public ACRadioButtonItem getMedicalFacilityHospitalNightShiftSubtractionRadioItem4(){
    if(medicalFacilityHospitalNightShiftSubtractionRadioItem4==null){

      medicalFacilityHospitalNightShiftSubtractionRadioItem4 = new ACRadioButtonItem();

      medicalFacilityHospitalNightShiftSubtractionRadioItem4.setText("���Z�^III");

      medicalFacilityHospitalNightShiftSubtractionRadioItem4.setGroup(getMedicalFacilityHospitalNightShiftSubtractionRadio());

      medicalFacilityHospitalNightShiftSubtractionRadioItem4.setConstraints(VRLayout.FLOW_RETURN);

      addMedicalFacilityHospitalNightShiftSubtractionRadioItem4();
    }
    return medicalFacilityHospitalNightShiftSubtractionRadioItem4;

  }

  /**
   * ���Z�^���擾���܂��B
   * @return ���Z�^
   */
  public ACRadioButtonItem getMedicalFacilityHospitalNightShiftSubtractionRadioItem5(){
    if(medicalFacilityHospitalNightShiftSubtractionRadioItem5==null){

      medicalFacilityHospitalNightShiftSubtractionRadioItem5 = new ACRadioButtonItem();

      medicalFacilityHospitalNightShiftSubtractionRadioItem5.setText("���Z�^");

      medicalFacilityHospitalNightShiftSubtractionRadioItem5.setGroup(getMedicalFacilityHospitalNightShiftSubtractionRadio());

      medicalFacilityHospitalNightShiftSubtractionRadioItem5.setConstraints(VRLayout.FLOW);

      addMedicalFacilityHospitalNightShiftSubtractionRadioItem5();
    }
    return medicalFacilityHospitalNightShiftSubtractionRadioItem5;

  }

  /**
   * �×{������擾���܂��B
   * @return �×{���
   */
  public ACClearableRadioButtonGroup getMedicalFacilityHospitalEnvironmentalRadio(){
    if(medicalFacilityHospitalEnvironmentalRadio==null){

      medicalFacilityHospitalEnvironmentalRadio = new ACClearableRadioButtonGroup();

      getMedicalFacilityHospitalEnvironmentalRadioContainer().setText("�×{���");

      medicalFacilityHospitalEnvironmentalRadio.setBindPath("1530106");

      medicalFacilityHospitalEnvironmentalRadio.setModel(getMedicalFacilityHospitalEnvironmentalRadioModel());

      medicalFacilityHospitalEnvironmentalRadio.setUseClearButton(false);

      addMedicalFacilityHospitalEnvironmentalRadio();
    }
    return medicalFacilityHospitalEnvironmentalRadio;

  }

  /**
   * �×{����R���e�i���擾���܂��B
   * @return �×{����R���e�i
   */
  protected ACLabelContainer getMedicalFacilityHospitalEnvironmentalRadioContainer(){
    if(medicalFacilityHospitalEnvironmentalRadioContainer==null){
      medicalFacilityHospitalEnvironmentalRadioContainer = new ACLabelContainer();
      medicalFacilityHospitalEnvironmentalRadioContainer.setFollowChildEnabled(true);
      medicalFacilityHospitalEnvironmentalRadioContainer.setVAlignment(VRLayout.CENTER);
      medicalFacilityHospitalEnvironmentalRadioContainer.add(getMedicalFacilityHospitalEnvironmentalRadio(), null);
    }
    return medicalFacilityHospitalEnvironmentalRadioContainer;
  }

  /**
   * �×{������f�����擾���܂��B
   * @return �×{������f��
   */
  protected ACListModelAdapter getMedicalFacilityHospitalEnvironmentalRadioModel(){
    if(medicalFacilityHospitalEnvironmentalRadioModel==null){
      medicalFacilityHospitalEnvironmentalRadioModel = new ACListModelAdapter();
      addMedicalFacilityHospitalEnvironmentalRadioModel();
    }
    return medicalFacilityHospitalEnvironmentalRadioModel;
  }

  /**
   * ��^���擾���܂��B
   * @return ��^
   */
  public ACRadioButtonItem getMedicalFacilityHospitalEnvironmentalRadioItem1(){
    if(medicalFacilityHospitalEnvironmentalRadioItem1==null){

      medicalFacilityHospitalEnvironmentalRadioItem1 = new ACRadioButtonItem();

      medicalFacilityHospitalEnvironmentalRadioItem1.setText("��^");

      medicalFacilityHospitalEnvironmentalRadioItem1.setGroup(getMedicalFacilityHospitalEnvironmentalRadio());

      medicalFacilityHospitalEnvironmentalRadioItem1.setConstraints(VRLayout.FLOW);

      addMedicalFacilityHospitalEnvironmentalRadioItem1();
    }
    return medicalFacilityHospitalEnvironmentalRadioItem1;

  }

  /**
   * ���ZI���擾���܂��B
   * @return ���ZI
   */
  public ACRadioButtonItem getMedicalFacilityHospitalEnvironmentalRadioItem2(){
    if(medicalFacilityHospitalEnvironmentalRadioItem2==null){

      medicalFacilityHospitalEnvironmentalRadioItem2 = new ACRadioButtonItem();

      medicalFacilityHospitalEnvironmentalRadioItem2.setText("���Z�^I");

      medicalFacilityHospitalEnvironmentalRadioItem2.setGroup(getMedicalFacilityHospitalEnvironmentalRadio());

      medicalFacilityHospitalEnvironmentalRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

      addMedicalFacilityHospitalEnvironmentalRadioItem2();
    }
    return medicalFacilityHospitalEnvironmentalRadioItem2;

  }

  /**
   * ���ZII���擾���܂��B
   * @return ���ZII
   */
  public ACRadioButtonItem getMedicalFacilityHospitalEnvironmentalRadioItem3(){
    if(medicalFacilityHospitalEnvironmentalRadioItem3==null){

      medicalFacilityHospitalEnvironmentalRadioItem3 = new ACRadioButtonItem();

      medicalFacilityHospitalEnvironmentalRadioItem3.setText("���Z�^II");

      medicalFacilityHospitalEnvironmentalRadioItem3.setGroup(getMedicalFacilityHospitalEnvironmentalRadio());

      medicalFacilityHospitalEnvironmentalRadioItem3.setConstraints(VRLayout.FLOW);

      addMedicalFacilityHospitalEnvironmentalRadioItem3();
    }
    return medicalFacilityHospitalEnvironmentalRadioItem3;

  }

  /**
   * ���ZIII���擾���܂��B
   * @return ���ZIII
   */
  public ACRadioButtonItem getMedicalFacilityHospitalEnvironmentalRadioItem4(){
    if(medicalFacilityHospitalEnvironmentalRadioItem4==null){

      medicalFacilityHospitalEnvironmentalRadioItem4 = new ACRadioButtonItem();

      medicalFacilityHospitalEnvironmentalRadioItem4.setText("���Z�^III");

      medicalFacilityHospitalEnvironmentalRadioItem4.setGroup(getMedicalFacilityHospitalEnvironmentalRadio());

      medicalFacilityHospitalEnvironmentalRadioItem4.setConstraints(VRLayout.FLOW);

      addMedicalFacilityHospitalEnvironmentalRadioItem4();
    }
    return medicalFacilityHospitalEnvironmentalRadioItem4;

  }

  /**
   * ��t�̔z�u����擾���܂��B
   * @return ��t�̔z�u�
   */
  public ACClearableRadioButtonGroup getMedicalFacilityHospitalDoctorArrangeStandardRadio(){
    if(medicalFacilityHospitalDoctorArrangeStandardRadio==null){

      medicalFacilityHospitalDoctorArrangeStandardRadio = new ACClearableRadioButtonGroup();

      getMedicalFacilityHospitalDoctorArrangeStandardRadioContainer().setText("��t�̔z�u�");

      medicalFacilityHospitalDoctorArrangeStandardRadio.setBindPath("1530107");

      medicalFacilityHospitalDoctorArrangeStandardRadio.setModel(getMedicalFacilityHospitalDoctorArrangeStandardRadioModel());

      medicalFacilityHospitalDoctorArrangeStandardRadio.setUseClearButton(false);

      addMedicalFacilityHospitalDoctorArrangeStandardRadio();
    }
    return medicalFacilityHospitalDoctorArrangeStandardRadio;

  }

  /**
   * ��t�̔z�u��R���e�i���擾���܂��B
   * @return ��t�̔z�u��R���e�i
   */
  protected ACLabelContainer getMedicalFacilityHospitalDoctorArrangeStandardRadioContainer(){
    if(medicalFacilityHospitalDoctorArrangeStandardRadioContainer==null){
      medicalFacilityHospitalDoctorArrangeStandardRadioContainer = new ACLabelContainer();
      medicalFacilityHospitalDoctorArrangeStandardRadioContainer.setFollowChildEnabled(true);
      medicalFacilityHospitalDoctorArrangeStandardRadioContainer.setVAlignment(VRLayout.CENTER);
      medicalFacilityHospitalDoctorArrangeStandardRadioContainer.add(getMedicalFacilityHospitalDoctorArrangeStandardRadio(), null);
    }
    return medicalFacilityHospitalDoctorArrangeStandardRadioContainer;
  }

  /**
   * ��t�̔z�u����f�����擾���܂��B
   * @return ��t�̔z�u����f��
   */
  protected ACListModelAdapter getMedicalFacilityHospitalDoctorArrangeStandardRadioModel(){
    if(medicalFacilityHospitalDoctorArrangeStandardRadioModel==null){
      medicalFacilityHospitalDoctorArrangeStandardRadioModel = new ACListModelAdapter();
      addMedicalFacilityHospitalDoctorArrangeStandardRadioModel();
    }
    return medicalFacilityHospitalDoctorArrangeStandardRadioModel;
  }

  /**
   * ����擾���܂��B
   * @return �
   */
  public ACRadioButtonItem getMedicalFacilityHospitalDoctorArrangeStandardRadioItem1(){
    if(medicalFacilityHospitalDoctorArrangeStandardRadioItem1==null){

      medicalFacilityHospitalDoctorArrangeStandardRadioItem1 = new ACRadioButtonItem();

      medicalFacilityHospitalDoctorArrangeStandardRadioItem1.setText("�");

      medicalFacilityHospitalDoctorArrangeStandardRadioItem1.setGroup(getMedicalFacilityHospitalDoctorArrangeStandardRadio());

      medicalFacilityHospitalDoctorArrangeStandardRadioItem1.setConstraints(VRLayout.FLOW_RETURN);

      addMedicalFacilityHospitalDoctorArrangeStandardRadioItem1();
    }
    return medicalFacilityHospitalDoctorArrangeStandardRadioItem1;

  }

  /**
   * ��Ö@�{�s�K����49��K�p���擾���܂��B
   * @return ��Ö@�{�s�K����49��K�p
   */
  public ACRadioButtonItem getMedicalFacilityHospitalDoctorArrangeStandardRadioItem2(){
    if(medicalFacilityHospitalDoctorArrangeStandardRadioItem2==null){

      medicalFacilityHospitalDoctorArrangeStandardRadioItem2 = new ACRadioButtonItem();

      medicalFacilityHospitalDoctorArrangeStandardRadioItem2.setText("��Ö@�{�s�K����49��K�p");

      medicalFacilityHospitalDoctorArrangeStandardRadioItem2.setGroup(getMedicalFacilityHospitalDoctorArrangeStandardRadio());

      medicalFacilityHospitalDoctorArrangeStandardRadioItem2.setConstraints(VRLayout.FLOW);

      addMedicalFacilityHospitalDoctorArrangeStandardRadioItem2();
    }
    return medicalFacilityHospitalDoctorArrangeStandardRadioItem2;

  }

  /**
   * �O�����Z���擾���܂��B
   * @return �O�����Z
   */
  public ACClearableRadioButtonGroup getMedicalFacilityHospitalStayRadio(){
    if(medicalFacilityHospitalStayRadio==null){

      medicalFacilityHospitalStayRadio = new ACClearableRadioButtonGroup();

      getMedicalFacilityHospitalStayRadioContainer().setText("�O�����Z");

      medicalFacilityHospitalStayRadio.setBindPath("1530108");

      medicalFacilityHospitalStayRadio.setModel(getMedicalFacilityHospitalStayRadioModel());

      medicalFacilityHospitalStayRadio.setUseClearButton(false);

      addMedicalFacilityHospitalStayRadio();
    }
    return medicalFacilityHospitalStayRadio;

  }

  /**
   * �O�����Z�R���e�i���擾���܂��B
   * @return �O�����Z�R���e�i
   */
  protected ACLabelContainer getMedicalFacilityHospitalStayRadioContainer(){
    if(medicalFacilityHospitalStayRadioContainer==null){
      medicalFacilityHospitalStayRadioContainer = new ACLabelContainer();
      medicalFacilityHospitalStayRadioContainer.setFollowChildEnabled(true);
      medicalFacilityHospitalStayRadioContainer.setVAlignment(VRLayout.CENTER);
      medicalFacilityHospitalStayRadioContainer.add(getMedicalFacilityHospitalStayRadio(), null);
    }
    return medicalFacilityHospitalStayRadioContainer;
  }

  /**
   * �O�����Z���f�����擾���܂��B
   * @return �O�����Z���f��
   */
  protected ACListModelAdapter getMedicalFacilityHospitalStayRadioModel(){
    if(medicalFacilityHospitalStayRadioModel==null){
      medicalFacilityHospitalStayRadioModel = new ACListModelAdapter();
      addMedicalFacilityHospitalStayRadioModel();
    }
    return medicalFacilityHospitalStayRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getMedicalFacilityHospitalStayRadioItem1(){
    if(medicalFacilityHospitalStayRadioItem1==null){

      medicalFacilityHospitalStayRadioItem1 = new ACRadioButtonItem();

      medicalFacilityHospitalStayRadioItem1.setText("�Ȃ�");

      medicalFacilityHospitalStayRadioItem1.setGroup(getMedicalFacilityHospitalStayRadio());

      medicalFacilityHospitalStayRadioItem1.setConstraints(VRLayout.FLOW);

      addMedicalFacilityHospitalStayRadioItem1();
    }
    return medicalFacilityHospitalStayRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getMedicalFacilityHospitalStayRadioItem2(){
    if(medicalFacilityHospitalStayRadioItem2==null){

      medicalFacilityHospitalStayRadioItem2 = new ACRadioButtonItem();

      medicalFacilityHospitalStayRadioItem2.setText("����");

      medicalFacilityHospitalStayRadioItem2.setGroup(getMedicalFacilityHospitalStayRadio());

      medicalFacilityHospitalStayRadioItem2.setConstraints(VRLayout.FLOW);

      addMedicalFacilityHospitalStayRadioItem2();
    }
    return medicalFacilityHospitalStayRadioItem2;

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
   * �������Z���擾���܂��B
   * @return �������Z
   */
  public ACClearableRadioButtonGroup getMedicalFacilityHospitalStandardRadio(){
    if(medicalFacilityHospitalStandardRadio==null){

      medicalFacilityHospitalStandardRadio = new ACClearableRadioButtonGroup();

      getMedicalFacilityHospitalStandardRadioContainer().setText("�������Z");

      medicalFacilityHospitalStandardRadio.setBindPath("1530109");

      medicalFacilityHospitalStandardRadio.setModel(getMedicalFacilityHospitalStandardRadioModel());

      medicalFacilityHospitalStandardRadio.setUseClearButton(false);

      addMedicalFacilityHospitalStandardRadio();
    }
    return medicalFacilityHospitalStandardRadio;

  }

  /**
   * �������Z�R���e�i���擾���܂��B
   * @return �������Z�R���e�i
   */
  protected ACLabelContainer getMedicalFacilityHospitalStandardRadioContainer(){
    if(medicalFacilityHospitalStandardRadioContainer==null){
      medicalFacilityHospitalStandardRadioContainer = new ACLabelContainer();
      medicalFacilityHospitalStandardRadioContainer.setFollowChildEnabled(true);
      medicalFacilityHospitalStandardRadioContainer.setVAlignment(VRLayout.CENTER);
      medicalFacilityHospitalStandardRadioContainer.add(getMedicalFacilityHospitalStandardRadio(), null);
    }
    return medicalFacilityHospitalStandardRadioContainer;
  }

  /**
   * �������Z���f�����擾���܂��B
   * @return �������Z���f��
   */
  protected ACListModelAdapter getMedicalFacilityHospitalStandardRadioModel(){
    if(medicalFacilityHospitalStandardRadioModel==null){
      medicalFacilityHospitalStandardRadioModel = new ACListModelAdapter();
      addMedicalFacilityHospitalStandardRadioModel();
    }
    return medicalFacilityHospitalStandardRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getMedicalFacilityHospitalStandardRadioItem1(){
    if(medicalFacilityHospitalStandardRadioItem1==null){

      medicalFacilityHospitalStandardRadioItem1 = new ACRadioButtonItem();

      medicalFacilityHospitalStandardRadioItem1.setText("�Ȃ�");

      medicalFacilityHospitalStandardRadioItem1.setGroup(getMedicalFacilityHospitalStandardRadio());

      medicalFacilityHospitalStandardRadioItem1.setConstraints(VRLayout.FLOW);

      addMedicalFacilityHospitalStandardRadioItem1();
    }
    return medicalFacilityHospitalStandardRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getMedicalFacilityHospitalStandardRadioItem2(){
    if(medicalFacilityHospitalStandardRadioItem2==null){

      medicalFacilityHospitalStandardRadioItem2 = new ACRadioButtonItem();

      medicalFacilityHospitalStandardRadioItem2.setText("����");

      medicalFacilityHospitalStandardRadioItem2.setGroup(getMedicalFacilityHospitalStandardRadio());

      medicalFacilityHospitalStandardRadioItem2.setConstraints(VRLayout.FLOW);

      addMedicalFacilityHospitalStandardRadioItem2();
    }
    return medicalFacilityHospitalStandardRadioItem2;

  }

  /**
   * ���Ȏ�f���擾���܂��B
   * @return ���Ȏ�f
   */
  public ACClearableRadioButtonGroup getMedicalFacilityHospitalMedicalExaminationRadio(){
    if(medicalFacilityHospitalMedicalExaminationRadio==null){

      medicalFacilityHospitalMedicalExaminationRadio = new ACClearableRadioButtonGroup();

      getMedicalFacilityHospitalMedicalExaminationRadioContainer().setText("���Ȏ�f���Z");

      medicalFacilityHospitalMedicalExaminationRadio.setBindPath("1530110");

      medicalFacilityHospitalMedicalExaminationRadio.setModel(getMedicalFacilityHospitalMedicalExaminationRadioModel());

      medicalFacilityHospitalMedicalExaminationRadio.setUseClearButton(false);

      addMedicalFacilityHospitalMedicalExaminationRadio();
    }
    return medicalFacilityHospitalMedicalExaminationRadio;

  }

  /**
   * ���Ȏ�f�R���e�i���擾���܂��B
   * @return ���Ȏ�f�R���e�i
   */
  protected ACLabelContainer getMedicalFacilityHospitalMedicalExaminationRadioContainer(){
    if(medicalFacilityHospitalMedicalExaminationRadioContainer==null){
      medicalFacilityHospitalMedicalExaminationRadioContainer = new ACLabelContainer();
      medicalFacilityHospitalMedicalExaminationRadioContainer.setFollowChildEnabled(true);
      medicalFacilityHospitalMedicalExaminationRadioContainer.setVAlignment(VRLayout.CENTER);
      medicalFacilityHospitalMedicalExaminationRadioContainer.add(getMedicalFacilityHospitalMedicalExaminationRadio(), null);
    }
    return medicalFacilityHospitalMedicalExaminationRadioContainer;
  }

  /**
   * ���Ȏ�f���f�����擾���܂��B
   * @return ���Ȏ�f���f��
   */
  protected ACListModelAdapter getMedicalFacilityHospitalMedicalExaminationRadioModel(){
    if(medicalFacilityHospitalMedicalExaminationRadioModel==null){
      medicalFacilityHospitalMedicalExaminationRadioModel = new ACListModelAdapter();
      addMedicalFacilityHospitalMedicalExaminationRadioModel();
    }
    return medicalFacilityHospitalMedicalExaminationRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getMedicalFacilityHospitalMedicalExaminationRadioItem1(){
    if(medicalFacilityHospitalMedicalExaminationRadioItem1==null){

      medicalFacilityHospitalMedicalExaminationRadioItem1 = new ACRadioButtonItem();

      medicalFacilityHospitalMedicalExaminationRadioItem1.setText("�Ȃ�");

      medicalFacilityHospitalMedicalExaminationRadioItem1.setGroup(getMedicalFacilityHospitalMedicalExaminationRadio());

      medicalFacilityHospitalMedicalExaminationRadioItem1.setConstraints(VRLayout.FLOW);

      addMedicalFacilityHospitalMedicalExaminationRadioItem1();
    }
    return medicalFacilityHospitalMedicalExaminationRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getMedicalFacilityHospitalMedicalExaminationRadioItem2(){
    if(medicalFacilityHospitalMedicalExaminationRadioItem2==null){

      medicalFacilityHospitalMedicalExaminationRadioItem2 = new ACRadioButtonItem();

      medicalFacilityHospitalMedicalExaminationRadioItem2.setText("����");

      medicalFacilityHospitalMedicalExaminationRadioItem2.setGroup(getMedicalFacilityHospitalMedicalExaminationRadio());

      medicalFacilityHospitalMedicalExaminationRadioItem2.setConstraints(VRLayout.FLOW);

      addMedicalFacilityHospitalMedicalExaminationRadioItem2();
    }
    return medicalFacilityHospitalMedicalExaminationRadioItem2;

  }

  /**
   * �h�{�Ǘ��̐����Z���擾���܂��B
   * @return �h�{�Ǘ��̐����Z
   */
  public ACClearableRadioButtonGroup getMedicalFacilityHospitalNutritionManageRadio(){
    if(medicalFacilityHospitalNutritionManageRadio==null){

      medicalFacilityHospitalNutritionManageRadio = new ACClearableRadioButtonGroup();

      getMedicalFacilityHospitalNutritionManageRadioContainer().setText("�h�{�Ǘ��̐����Z");

      medicalFacilityHospitalNutritionManageRadio.setBindPath("1530111");

      medicalFacilityHospitalNutritionManageRadio.setModel(getMedicalFacilityHospitalNutritionManageRadioModel());

      medicalFacilityHospitalNutritionManageRadio.setUseClearButton(false);

      addMedicalFacilityHospitalNutritionManageRadio();
    }
    return medicalFacilityHospitalNutritionManageRadio;

  }

  /**
   * �h�{�Ǘ��̐����Z�R���e�i���擾���܂��B
   * @return �h�{�Ǘ��̐����Z�R���e�i
   */
  protected ACLabelContainer getMedicalFacilityHospitalNutritionManageRadioContainer(){
    if(medicalFacilityHospitalNutritionManageRadioContainer==null){
      medicalFacilityHospitalNutritionManageRadioContainer = new ACLabelContainer();
      medicalFacilityHospitalNutritionManageRadioContainer.setFollowChildEnabled(true);
      medicalFacilityHospitalNutritionManageRadioContainer.setVAlignment(VRLayout.CENTER);
      medicalFacilityHospitalNutritionManageRadioContainer.add(getMedicalFacilityHospitalNutritionManageRadio(), null);
    }
    return medicalFacilityHospitalNutritionManageRadioContainer;
  }

  /**
   * �h�{�Ǘ��̐����Z���f�����擾���܂��B
   * @return �h�{�Ǘ��̐����Z���f��
   */
  protected ACListModelAdapter getMedicalFacilityHospitalNutritionManageRadioModel(){
    if(medicalFacilityHospitalNutritionManageRadioModel==null){
      medicalFacilityHospitalNutritionManageRadioModel = new ACListModelAdapter();
      addMedicalFacilityHospitalNutritionManageRadioModel();
    }
    return medicalFacilityHospitalNutritionManageRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getMedicalFacilityHospitalNutritionManageRadioItem1(){
    if(medicalFacilityHospitalNutritionManageRadioItem1==null){

      medicalFacilityHospitalNutritionManageRadioItem1 = new ACRadioButtonItem();

      medicalFacilityHospitalNutritionManageRadioItem1.setText("�Ȃ�");

      medicalFacilityHospitalNutritionManageRadioItem1.setGroup(getMedicalFacilityHospitalNutritionManageRadio());

      medicalFacilityHospitalNutritionManageRadioItem1.setConstraints(VRLayout.FLOW);

      addMedicalFacilityHospitalNutritionManageRadioItem1();
    }
    return medicalFacilityHospitalNutritionManageRadioItem1;

  }

  /**
   * �Ǘ��h�{�m���擾���܂��B
   * @return �Ǘ��h�{�m
   */
  public ACRadioButtonItem getMedicalFacilityHospitalNutritionManageRadioItem2(){
    if(medicalFacilityHospitalNutritionManageRadioItem2==null){

      medicalFacilityHospitalNutritionManageRadioItem2 = new ACRadioButtonItem();

      medicalFacilityHospitalNutritionManageRadioItem2.setText("�Ǘ��h�{�m");

      medicalFacilityHospitalNutritionManageRadioItem2.setGroup(getMedicalFacilityHospitalNutritionManageRadio());

      medicalFacilityHospitalNutritionManageRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

      addMedicalFacilityHospitalNutritionManageRadioItem2();
    }
    return medicalFacilityHospitalNutritionManageRadioItem2;

  }

  /**
   * �h�{�m���擾���܂��B
   * @return �h�{�m
   */
  public ACRadioButtonItem getMedicalFacilityHospitalNutritionManageRadioItem3(){
    if(medicalFacilityHospitalNutritionManageRadioItem3==null){

      medicalFacilityHospitalNutritionManageRadioItem3 = new ACRadioButtonItem();

      medicalFacilityHospitalNutritionManageRadioItem3.setText("�h�{�m");

      medicalFacilityHospitalNutritionManageRadioItem3.setGroup(getMedicalFacilityHospitalNutritionManageRadio());

      medicalFacilityHospitalNutritionManageRadioItem3.setConstraints(VRLayout.FLOW);

      addMedicalFacilityHospitalNutritionManageRadioItem3();
    }
    return medicalFacilityHospitalNutritionManageRadioItem3;

  }

  /**
   * �h�{�}�l�W�����g���Z���擾���܂��B
   * @return �h�{�}�l�W�����g���Z
   */
  public ACClearableRadioButtonGroup getMedicalFacilityHospitalNutritionRadio(){
    if(medicalFacilityHospitalNutritionRadio==null){

      medicalFacilityHospitalNutritionRadio = new ACClearableRadioButtonGroup();

      getMedicalFacilityHospitalNutritionRadioContainer().setText("�h�{�}�l�W�����g���Z");

      medicalFacilityHospitalNutritionRadio.setBindPath("1530112");

      medicalFacilityHospitalNutritionRadio.setModel(getMedicalFacilityHospitalNutritionRadioModel());

      medicalFacilityHospitalNutritionRadio.setUseClearButton(false);

      addMedicalFacilityHospitalNutritionRadio();
    }
    return medicalFacilityHospitalNutritionRadio;

  }

  /**
   * �h�{�}�l�W�����g���Z�R���e�i���擾���܂��B
   * @return �h�{�}�l�W�����g���Z�R���e�i
   */
  protected ACLabelContainer getMedicalFacilityHospitalNutritionRadioContainer(){
    if(medicalFacilityHospitalNutritionRadioContainer==null){
      medicalFacilityHospitalNutritionRadioContainer = new ACLabelContainer();
      medicalFacilityHospitalNutritionRadioContainer.setFollowChildEnabled(true);
      medicalFacilityHospitalNutritionRadioContainer.setVAlignment(VRLayout.CENTER);
      medicalFacilityHospitalNutritionRadioContainer.add(getMedicalFacilityHospitalNutritionRadio(), null);
    }
    return medicalFacilityHospitalNutritionRadioContainer;
  }

  /**
   * �h�{�}�l�W�����g���Z���f�����擾���܂��B
   * @return �h�{�}�l�W�����g���Z���f��
   */
  protected ACListModelAdapter getMedicalFacilityHospitalNutritionRadioModel(){
    if(medicalFacilityHospitalNutritionRadioModel==null){
      medicalFacilityHospitalNutritionRadioModel = new ACListModelAdapter();
      addMedicalFacilityHospitalNutritionRadioModel();
    }
    return medicalFacilityHospitalNutritionRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getMedicalFacilityHospitalNutritionRadioItem1(){
    if(medicalFacilityHospitalNutritionRadioItem1==null){

      medicalFacilityHospitalNutritionRadioItem1 = new ACRadioButtonItem();

      medicalFacilityHospitalNutritionRadioItem1.setText("�Ȃ�");

      medicalFacilityHospitalNutritionRadioItem1.setGroup(getMedicalFacilityHospitalNutritionRadio());

      medicalFacilityHospitalNutritionRadioItem1.setConstraints(VRLayout.FLOW);

      addMedicalFacilityHospitalNutritionRadioItem1();
    }
    return medicalFacilityHospitalNutritionRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getMedicalFacilityHospitalNutritionRadioItem2(){
    if(medicalFacilityHospitalNutritionRadioItem2==null){

      medicalFacilityHospitalNutritionRadioItem2 = new ACRadioButtonItem();

      medicalFacilityHospitalNutritionRadioItem2.setText("����");

      medicalFacilityHospitalNutritionRadioItem2.setGroup(getMedicalFacilityHospitalNutritionRadio());

      medicalFacilityHospitalNutritionRadioItem2.setConstraints(VRLayout.FLOW);

      addMedicalFacilityHospitalNutritionRadioItem2();
    }
    return medicalFacilityHospitalNutritionRadioItem2;

  }

  /**
   * �o���ڍs���Z���擾���܂��B
   * @return �o���ڍs���Z
   */
  public ACClearableRadioButtonGroup getMedicalFacilityHospitalOralSwitchRadio(){
    if(medicalFacilityHospitalOralSwitchRadio==null){

      medicalFacilityHospitalOralSwitchRadio = new ACClearableRadioButtonGroup();

      getMedicalFacilityHospitalOralSwitchRadioContainer().setText("�o���ڍs���Z");

      medicalFacilityHospitalOralSwitchRadio.setBindPath("1530113");

      medicalFacilityHospitalOralSwitchRadio.setModel(getMedicalFacilityHospitalOralSwitchRadioModel());

      medicalFacilityHospitalOralSwitchRadio.setUseClearButton(false);

      addMedicalFacilityHospitalOralSwitchRadio();
    }
    return medicalFacilityHospitalOralSwitchRadio;

  }

  /**
   * �o���ڍs���Z�R���e�i���擾���܂��B
   * @return �o���ڍs���Z�R���e�i
   */
  protected ACLabelContainer getMedicalFacilityHospitalOralSwitchRadioContainer(){
    if(medicalFacilityHospitalOralSwitchRadioContainer==null){
      medicalFacilityHospitalOralSwitchRadioContainer = new ACLabelContainer();
      medicalFacilityHospitalOralSwitchRadioContainer.setFollowChildEnabled(true);
      medicalFacilityHospitalOralSwitchRadioContainer.setVAlignment(VRLayout.CENTER);
      medicalFacilityHospitalOralSwitchRadioContainer.add(getMedicalFacilityHospitalOralSwitchRadio(), null);
    }
    return medicalFacilityHospitalOralSwitchRadioContainer;
  }

  /**
   * �o���ڍs���Z���f�����擾���܂��B
   * @return �o���ڍs���Z���f��
   */
  protected ACListModelAdapter getMedicalFacilityHospitalOralSwitchRadioModel(){
    if(medicalFacilityHospitalOralSwitchRadioModel==null){
      medicalFacilityHospitalOralSwitchRadioModel = new ACListModelAdapter();
      addMedicalFacilityHospitalOralSwitchRadioModel();
    }
    return medicalFacilityHospitalOralSwitchRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getMedicalFacilityHospitalOralSwitchRadioItem1(){
    if(medicalFacilityHospitalOralSwitchRadioItem1==null){

      medicalFacilityHospitalOralSwitchRadioItem1 = new ACRadioButtonItem();

      medicalFacilityHospitalOralSwitchRadioItem1.setText("�Ȃ�");

      medicalFacilityHospitalOralSwitchRadioItem1.setGroup(getMedicalFacilityHospitalOralSwitchRadio());

      medicalFacilityHospitalOralSwitchRadioItem1.setConstraints(VRLayout.FLOW);

      addMedicalFacilityHospitalOralSwitchRadioItem1();
    }
    return medicalFacilityHospitalOralSwitchRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getMedicalFacilityHospitalOralSwitchRadioItem2(){
    if(medicalFacilityHospitalOralSwitchRadioItem2==null){

      medicalFacilityHospitalOralSwitchRadioItem2 = new ACRadioButtonItem();

      medicalFacilityHospitalOralSwitchRadioItem2.setText("����");

      medicalFacilityHospitalOralSwitchRadioItem2.setGroup(getMedicalFacilityHospitalOralSwitchRadio());

      medicalFacilityHospitalOralSwitchRadioItem2.setConstraints(VRLayout.FLOW);

      addMedicalFacilityHospitalOralSwitchRadioItem2();
    }
    return medicalFacilityHospitalOralSwitchRadioItem2;

  }

  /**
   * �o���ێ����Z���擾���܂��B
   * @return �o���ێ����Z
   */
  public ACClearableRadioButtonGroup getOralMaintenanceRadio(){
    if(oralMaintenanceRadio==null){

      oralMaintenanceRadio = new ACClearableRadioButtonGroup();

      getOralMaintenanceRadioContainer().setText("�o���ێ����Z");

      oralMaintenanceRadio.setBindPath("1530115");

      oralMaintenanceRadio.setModel(getOralMaintenanceRadioModel());

      oralMaintenanceRadio.setUseClearButton(false);

      addOralMaintenanceRadio();
    }
    return oralMaintenanceRadio;

  }

  /**
   * �o���ێ����Z�R���e�i���擾���܂��B
   * @return �o���ێ����Z�R���e�i
   */
  protected ACLabelContainer getOralMaintenanceRadioContainer(){
    if(oralMaintenanceRadioContainer==null){
      oralMaintenanceRadioContainer = new ACLabelContainer();
      oralMaintenanceRadioContainer.setFollowChildEnabled(true);
      oralMaintenanceRadioContainer.setVAlignment(VRLayout.CENTER);
      oralMaintenanceRadioContainer.add(getOralMaintenanceRadio(), null);
    }
    return oralMaintenanceRadioContainer;
  }

  /**
   * �o���ێ����Z���f�����擾���܂��B
   * @return �o���ێ����Z���f��
   */
  protected ACListModelAdapter getOralMaintenanceRadioModel(){
    if(oralMaintenanceRadioModel==null){
      oralMaintenanceRadioModel = new ACListModelAdapter();
      addOralMaintenanceRadioModel();
    }
    return oralMaintenanceRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getOralMaintenanceRadioItem1(){
    if(oralMaintenanceRadioItem1==null){

      oralMaintenanceRadioItem1 = new ACRadioButtonItem();

      oralMaintenanceRadioItem1.setText("�Ȃ�");

      oralMaintenanceRadioItem1.setGroup(getOralMaintenanceRadio());

      oralMaintenanceRadioItem1.setConstraints(VRLayout.FLOW);

      addOralMaintenanceRadioItem1();
    }
    return oralMaintenanceRadioItem1;

  }

  /**
   * I�^���擾���܂��B
   * @return I�^
   */
  public ACRadioButtonItem getOralMaintenanceRadioItem2(){
    if(oralMaintenanceRadioItem2==null){

      oralMaintenanceRadioItem2 = new ACRadioButtonItem();

      oralMaintenanceRadioItem2.setText("I�^");

      oralMaintenanceRadioItem2.setGroup(getOralMaintenanceRadio());

      oralMaintenanceRadioItem2.setConstraints(VRLayout.FLOW);

      addOralMaintenanceRadioItem2();
    }
    return oralMaintenanceRadioItem2;

  }

  /**
   * II�^���擾���܂��B
   * @return II�^
   */
  public ACRadioButtonItem getOralMaintenanceRadioItem3(){
    if(oralMaintenanceRadioItem3==null){

      oralMaintenanceRadioItem3 = new ACRadioButtonItem();

      oralMaintenanceRadioItem3.setText("II�^");

      oralMaintenanceRadioItem3.setGroup(getOralMaintenanceRadio());

      oralMaintenanceRadioItem3.setConstraints(VRLayout.FLOW);

      addOralMaintenanceRadioItem3();
    }
    return oralMaintenanceRadioItem3;

  }

  /**
   * �×{�H���Z���擾���܂��B
   * @return �×{�H���Z
   */
  public ACClearableRadioButtonGroup getMedicalFacilityHospitalRecuperateDinnerRadio(){
    if(medicalFacilityHospitalRecuperateDinnerRadio==null){

      medicalFacilityHospitalRecuperateDinnerRadio = new ACClearableRadioButtonGroup();

      getMedicalFacilityHospitalRecuperateDinnerRadioContainer().setText("�×{�H���Z");

      medicalFacilityHospitalRecuperateDinnerRadio.setBindPath("1530114");

      medicalFacilityHospitalRecuperateDinnerRadio.setModel(getMedicalFacilityHospitalRecuperateDinnerRadioModel());

      medicalFacilityHospitalRecuperateDinnerRadio.setUseClearButton(false);

      addMedicalFacilityHospitalRecuperateDinnerRadio();
    }
    return medicalFacilityHospitalRecuperateDinnerRadio;

  }

  /**
   * �×{�H���Z�R���e�i���擾���܂��B
   * @return �×{�H���Z�R���e�i
   */
  protected ACLabelContainer getMedicalFacilityHospitalRecuperateDinnerRadioContainer(){
    if(medicalFacilityHospitalRecuperateDinnerRadioContainer==null){
      medicalFacilityHospitalRecuperateDinnerRadioContainer = new ACLabelContainer();
      medicalFacilityHospitalRecuperateDinnerRadioContainer.setFollowChildEnabled(true);
      medicalFacilityHospitalRecuperateDinnerRadioContainer.setVAlignment(VRLayout.CENTER);
      medicalFacilityHospitalRecuperateDinnerRadioContainer.add(getMedicalFacilityHospitalRecuperateDinnerRadio(), null);
    }
    return medicalFacilityHospitalRecuperateDinnerRadioContainer;
  }

  /**
   * �×{�H���Z���f�����擾���܂��B
   * @return �×{�H���Z���f��
   */
  protected ACListModelAdapter getMedicalFacilityHospitalRecuperateDinnerRadioModel(){
    if(medicalFacilityHospitalRecuperateDinnerRadioModel==null){
      medicalFacilityHospitalRecuperateDinnerRadioModel = new ACListModelAdapter();
      addMedicalFacilityHospitalRecuperateDinnerRadioModel();
    }
    return medicalFacilityHospitalRecuperateDinnerRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getMedicalFacilityHospitalRecuperateDinnerRadioItem1(){
    if(medicalFacilityHospitalRecuperateDinnerRadioItem1==null){

      medicalFacilityHospitalRecuperateDinnerRadioItem1 = new ACRadioButtonItem();

      medicalFacilityHospitalRecuperateDinnerRadioItem1.setText("�Ȃ�");

      medicalFacilityHospitalRecuperateDinnerRadioItem1.setGroup(getMedicalFacilityHospitalRecuperateDinnerRadio());

      medicalFacilityHospitalRecuperateDinnerRadioItem1.setConstraints(VRLayout.FLOW);

      addMedicalFacilityHospitalRecuperateDinnerRadioItem1();
    }
    return medicalFacilityHospitalRecuperateDinnerRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getMedicalFacilityHospitalRecuperateDinnerRadioItem2(){
    if(medicalFacilityHospitalRecuperateDinnerRadioItem2==null){

      medicalFacilityHospitalRecuperateDinnerRadioItem2 = new ACRadioButtonItem();

      medicalFacilityHospitalRecuperateDinnerRadioItem2.setText("����");

      medicalFacilityHospitalRecuperateDinnerRadioItem2.setGroup(getMedicalFacilityHospitalRecuperateDinnerRadio());

      medicalFacilityHospitalRecuperateDinnerRadioItem2.setConstraints(VRLayout.FLOW);

      addMedicalFacilityHospitalRecuperateDinnerRadioItem2();
    }
    return medicalFacilityHospitalRecuperateDinnerRadioItem2;

  }

  /**
   * �ޏ��֘A���Z���擾���܂��B
   * @return �ޏ��֘A���Z
   */
  public ACLabelContainer getMedicalFacilityHospitalHijoAddition(){
    if(medicalFacilityHospitalHijoAddition==null){

      medicalFacilityHospitalHijoAddition = new ACLabelContainer();

      medicalFacilityHospitalHijoAddition.setText("�މ@�֘A���Z");

      addMedicalFacilityHospitalHijoAddition();
    }
    return medicalFacilityHospitalHijoAddition;

  }

  /**
   * �ޏ�(�@)�O��K��w�����Z���擾���܂��B
   * @return �ޏ�(�@)�O��K��w�����Z
   */
  public ACIntegerCheckBox getLeavingHospitalPreConsultationAddition(){
    if(leavingHospitalPreConsultationAddition==null){

      leavingHospitalPreConsultationAddition = new ACIntegerCheckBox();

      leavingHospitalPreConsultationAddition.setText("�މ@�O��K��w�����Z");

      leavingHospitalPreConsultationAddition.setBindPath("3020104");

      leavingHospitalPreConsultationAddition.setSelectValue(2);

      leavingHospitalPreConsultationAddition.setUnSelectValue(1);

      addLeavingHospitalPreConsultationAddition();
    }
    return leavingHospitalPreConsultationAddition;

  }

  /**
   * �ޏ�(�@)���w�����Z���擾���܂��B
   * @return �ޏ�(�@)���w�����Z
   */
  public ACIntegerCheckBox getLeavingHospitalConsultationAddition(){
    if(leavingHospitalConsultationAddition==null){

      leavingHospitalConsultationAddition = new ACIntegerCheckBox();

      leavingHospitalConsultationAddition.setText("�މ@���w�����Z");

      leavingHospitalConsultationAddition.setBindPath("3020105");

      leavingHospitalConsultationAddition.setSelectValue(2);

      leavingHospitalConsultationAddition.setUnSelectValue(1);

      addLeavingHospitalConsultationAddition();
    }
    return leavingHospitalConsultationAddition;

  }

  /**
   * �ޏ�(�@)�����񋟉��Z���擾���܂��B
   * @return �ޏ�(�@)�����񋟉��Z
   */
  public ACIntegerCheckBox getLeavingHospitalDissemination(){
    if(leavingHospitalDissemination==null){

      leavingHospitalDissemination = new ACIntegerCheckBox();

      leavingHospitalDissemination.setText("�މ@�����񋟉��Z");

      leavingHospitalDissemination.setBindPath("3020106");

      leavingHospitalDissemination.setSelectValue(2);

      leavingHospitalDissemination.setUnSelectValue(1);

      addLeavingHospitalDissemination();
    }
    return leavingHospitalDissemination;

  }

  /**
   * �ޏ�(�@)�O�A�g���Z���擾���܂��B
   * @return �ޏ�(�@)�O�A�g���Z
   */
  public ACIntegerCheckBox getLeavingHospitalCooperationAddition(){
    if(leavingHospitalCooperationAddition==null){

      leavingHospitalCooperationAddition = new ACIntegerCheckBox();

      leavingHospitalCooperationAddition.setText("�މ@�O�A�g���Z");

      leavingHospitalCooperationAddition.setBindPath("3020107");

      leavingHospitalCooperationAddition.setSelectValue(2);

      leavingHospitalCooperationAddition.setUnSelectValue(1);

      addLeavingHospitalCooperationAddition();
    }
    return leavingHospitalCooperationAddition;

  }

  /**
   * �V�l�K��Ō�w�����Z���擾���܂��B
   * @return �V�l�K��Ō�w�����Z
   */
  public ACIntegerCheckBox getLeavingHospital(){
    if(leavingHospital==null){

      leavingHospital = new ACIntegerCheckBox();

      leavingHospital.setText("�V�l�K��Ō�w�����Z");

      leavingHospital.setBindPath("3020108");

      leavingHospital.setSelectValue(2);

      leavingHospital.setUnSelectValue(1);

      addLeavingHospital();
    }
    return leavingHospital;

  }

  /**
   * �^�u3���擾���܂��B
   * @return �^�u3
   */
  public ACPanel getTab3(){
    if(tab3==null){

      tab3 = new ACPanel();

      tab3.setHgap(0);

      addTab3();
    }
    return tab3;

  }

  /**
   * ����f�Ô���擾���܂��B
   * @return ����f�Ô�
   */
  public ACMapBindButton getMedicalFacilityHospitalConsultationFee(){
    if(medicalFacilityHospitalConsultationFee==null){

      medicalFacilityHospitalConsultationFee = new ACMapBindButton();

      medicalFacilityHospitalConsultationFee.setText("����f�Ô�");

      medicalFacilityHospitalConsultationFee.setToolTipText("����f�Ô��ݒ肵�܂��B");

      addMedicalFacilityHospitalConsultationFee();
    }
    return medicalFacilityHospitalConsultationFee;

  }

  /**
   * ���x�����擾���܂��B
   * @return ���x��
   */
  public ACLabel getMedicalFacilityHospitalConsultationFeeLabel(){
    if(medicalFacilityHospitalConsultationFeeLabel==null){

      medicalFacilityHospitalConsultationFeeLabel = new ACLabel();

      medicalFacilityHospitalConsultationFeeLabel.setText("�ݒ�Ȃ�");

      medicalFacilityHospitalConsultationFeeLabel.setOpaque(true);
      medicalFacilityHospitalConsultationFeeLabel.setBackground(new Color(255,255,172));

      addMedicalFacilityHospitalConsultationFeeLabel();
    }
    return medicalFacilityHospitalConsultationFeeLabel;

  }

  /**
   * �l�����Z���擾���܂��B
   * @return �l�����Z
   */
  public ACComboBox getMedicalFacilityHospitalSubstraction(){
    if(medicalFacilityHospitalSubstraction==null){

      medicalFacilityHospitalSubstraction = new ACComboBox();

      getMedicalFacilityHospitalSubstractionContainer().setText("�l�����Z");

      medicalFacilityHospitalSubstraction.setBindPath("1530158");

      medicalFacilityHospitalSubstraction.setEditable(false);

      medicalFacilityHospitalSubstraction.setModelBindPath("1530158");

      medicalFacilityHospitalSubstraction.setModel(getMedicalFacilityHospitalSubstractionModel());

      medicalFacilityHospitalSubstraction.setRenderBindPath("CONTENT");

      addMedicalFacilityHospitalSubstraction();
    }
    return medicalFacilityHospitalSubstraction;

  }

  /**
   * �l�����Z�R���e�i���擾���܂��B
   * @return �l�����Z�R���e�i
   */
  protected ACLabelContainer getMedicalFacilityHospitalSubstractionContainer(){
    if(medicalFacilityHospitalSubstractionContainer==null){
      medicalFacilityHospitalSubstractionContainer = new ACLabelContainer();
      medicalFacilityHospitalSubstractionContainer.setFollowChildEnabled(true);
      medicalFacilityHospitalSubstractionContainer.setVAlignment(VRLayout.CENTER);
      medicalFacilityHospitalSubstractionContainer.add(getMedicalFacilityHospitalSubstraction(), null);
    }
    return medicalFacilityHospitalSubstractionContainer;
  }

  /**
   * �l�����Z���f�����擾���܂��B
   * @return �l�����Z���f��
   */
  protected ACComboBoxModelAdapter getMedicalFacilityHospitalSubstractionModel(){
    if(medicalFacilityHospitalSubstractionModel==null){
      medicalFacilityHospitalSubstractionModel = new ACComboBoxModelAdapter();
      addMedicalFacilityHospitalSubstractionModel();
    }
    return medicalFacilityHospitalSubstractionModel;
  }

  /**
   * �H���R���e�i���擾���܂��B
   * @return �H���R���e�i
   */
  public ACBackLabelContainer getMedicalFacilityDinnerContainer(){
    if(medicalFacilityDinnerContainer==null){

      medicalFacilityDinnerContainer = new ACBackLabelContainer();

      addMedicalFacilityDinnerContainer();
    }
    return medicalFacilityDinnerContainer;

  }

  /**
   * �H���񋟂��擾���܂��B
   * @return �H����
   */
  public ACComboBox getMedicalFacilityDinnerOffer(){
    if(medicalFacilityDinnerOffer==null){

      medicalFacilityDinnerOffer = new ACComboBox();

      getMedicalFacilityDinnerOfferContainer().setText("�H����");

      medicalFacilityDinnerOffer.setBindPath("1530159");

      medicalFacilityDinnerOffer.setEditable(false);

      medicalFacilityDinnerOffer.setModelBindPath("1530159");

      medicalFacilityDinnerOffer.setModel(getMedicalFacilityDinnerOfferModel());

      medicalFacilityDinnerOffer.setRenderBindPath("CONTENT");

      addMedicalFacilityDinnerOffer();
    }
    return medicalFacilityDinnerOffer;

  }

  /**
   * �H���񋟃R���e�i���擾���܂��B
   * @return �H���񋟃R���e�i
   */
  protected ACLabelContainer getMedicalFacilityDinnerOfferContainer(){
    if(medicalFacilityDinnerOfferContainer==null){
      medicalFacilityDinnerOfferContainer = new ACLabelContainer();
      medicalFacilityDinnerOfferContainer.setFollowChildEnabled(true);
      medicalFacilityDinnerOfferContainer.setVAlignment(VRLayout.CENTER);
      medicalFacilityDinnerOfferContainer.add(getMedicalFacilityDinnerOffer(), null);
    }
    return medicalFacilityDinnerOfferContainer;
  }

  /**
   * �H���񋟃��f�����擾���܂��B
   * @return �H���񋟃��f��
   */
  protected ACComboBoxModelAdapter getMedicalFacilityDinnerOfferModel(){
    if(medicalFacilityDinnerOfferModel==null){
      medicalFacilityDinnerOfferModel = new ACComboBoxModelAdapter();
      addMedicalFacilityDinnerOfferModel();
    }
    return medicalFacilityDinnerOfferModel;
  }

  /**
   * �H����p���擾���܂��B
   * @return �H����p
   */
  public ACTextField getMedicalFacilityDinnerCost(){
    if(medicalFacilityDinnerCost==null){

      medicalFacilityDinnerCost = new ACTextField();

      getMedicalFacilityDinnerCostContainer().setText("�H����p");

      medicalFacilityDinnerCost.setBindPath("1530161");

      medicalFacilityDinnerCost.setColumns(4);

      medicalFacilityDinnerCost.setCharType(VRCharType.ONLY_DIGIT);

      medicalFacilityDinnerCost.setHorizontalAlignment(SwingConstants.RIGHT);

      medicalFacilityDinnerCost.setIMEMode(InputSubset.LATIN);

      medicalFacilityDinnerCost.setMaxLength(5);

      addMedicalFacilityDinnerCost();
    }
    return medicalFacilityDinnerCost;

  }

  /**
   * �H����p�R���e�i���擾���܂��B
   * @return �H����p�R���e�i
   */
  protected ACLabelContainer getMedicalFacilityDinnerCostContainer(){
    if(medicalFacilityDinnerCostContainer==null){
      medicalFacilityDinnerCostContainer = new ACLabelContainer();
      medicalFacilityDinnerCostContainer.setFollowChildEnabled(true);
      medicalFacilityDinnerCostContainer.setVAlignment(VRLayout.CENTER);
      medicalFacilityDinnerCostContainer.add(getMedicalFacilityDinnerCost(), null);
    }
    return medicalFacilityDinnerCostContainer;
  }

  /**
   * ���j�b�g�P�A�̐������擾���܂��B
   * @return ���j�b�g�P�A�̐���
   */
  public ACClearableRadioButtonGroup getUnitCareMaintenanceRadio(){
    if(unitCareMaintenanceRadio==null){

      unitCareMaintenanceRadio = new ACClearableRadioButtonGroup();

      getUnitCareMaintenanceRadioContainer().setText("���j�b�g�P�A�̐���");

      unitCareMaintenanceRadio.setBindPath("1530116");

      unitCareMaintenanceRadio.setModel(getUnitCareMaintenanceRadioModel());

      unitCareMaintenanceRadio.setUseClearButton(false);

      addUnitCareMaintenanceRadio();
    }
    return unitCareMaintenanceRadio;

  }

  /**
   * ���j�b�g�P�A�̐����R���e�i���擾���܂��B
   * @return ���j�b�g�P�A�̐����R���e�i
   */
  protected ACLabelContainer getUnitCareMaintenanceRadioContainer(){
    if(unitCareMaintenanceRadioContainer==null){
      unitCareMaintenanceRadioContainer = new ACLabelContainer();
      unitCareMaintenanceRadioContainer.setFollowChildEnabled(true);
      unitCareMaintenanceRadioContainer.setVAlignment(VRLayout.CENTER);
      unitCareMaintenanceRadioContainer.add(getUnitCareMaintenanceRadio(), null);
    }
    return unitCareMaintenanceRadioContainer;
  }

  /**
   * ���j�b�g�P�A�̐������f�����擾���܂��B
   * @return ���j�b�g�P�A�̐������f��
   */
  protected ACListModelAdapter getUnitCareMaintenanceRadioModel(){
    if(unitCareMaintenanceRadioModel==null){
      unitCareMaintenanceRadioModel = new ACListModelAdapter();
      addUnitCareMaintenanceRadioModel();
    }
    return unitCareMaintenanceRadioModel;
  }

  /**
   * ���������擾���܂��B
   * @return ������
   */
  public ACRadioButtonItem getUnitCareMaintenanceRadioItem1(){
    if(unitCareMaintenanceRadioItem1==null){

      unitCareMaintenanceRadioItem1 = new ACRadioButtonItem();

      unitCareMaintenanceRadioItem1.setText("������");

      unitCareMaintenanceRadioItem1.setGroup(getUnitCareMaintenanceRadio());

      unitCareMaintenanceRadioItem1.setConstraints(VRLayout.FLOW);

      addUnitCareMaintenanceRadioItem1();
    }
    return unitCareMaintenanceRadioItem1;

  }

  /**
   * �������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getUnitCareMaintenanceRadioItem2(){
    if(unitCareMaintenanceRadioItem2==null){

      unitCareMaintenanceRadioItem2 = new ACRadioButtonItem();

      unitCareMaintenanceRadioItem2.setText("����");

      unitCareMaintenanceRadioItem2.setGroup(getUnitCareMaintenanceRadio());

      unitCareMaintenanceRadioItem2.setConstraints(VRLayout.FLOW);

      addUnitCareMaintenanceRadioItem2();
    }
    return unitCareMaintenanceRadioItem2;

  }

  /**
   * �g�̍S���p�~�����{���Z���擾���܂��B
   * @return �g�̍S���p�~�����{���Z
   */
  public ACClearableRadioButtonGroup getBodyRestraintAbolitionRadio(){
    if(bodyRestraintAbolitionRadio==null){

      bodyRestraintAbolitionRadio = new ACClearableRadioButtonGroup();

      getBodyRestraintAbolitionRadioContainer().setText("�g�̍S���p�~�����{���Z");

      bodyRestraintAbolitionRadio.setBindPath("1530117");

      bodyRestraintAbolitionRadio.setModel(getBodyRestraintAbolitionRadioModel());

      bodyRestraintAbolitionRadio.setUseClearButton(false);

      addBodyRestraintAbolitionRadio();
    }
    return bodyRestraintAbolitionRadio;

  }

  /**
   * �g�̍S���p�~�����{���Z�R���e�i���擾���܂��B
   * @return �g�̍S���p�~�����{���Z�R���e�i
   */
  protected ACLabelContainer getBodyRestraintAbolitionRadioContainer(){
    if(bodyRestraintAbolitionRadioContainer==null){
      bodyRestraintAbolitionRadioContainer = new ACLabelContainer();
      bodyRestraintAbolitionRadioContainer.setFollowChildEnabled(true);
      bodyRestraintAbolitionRadioContainer.setVAlignment(VRLayout.CENTER);
      bodyRestraintAbolitionRadioContainer.add(getBodyRestraintAbolitionRadio(), null);
    }
    return bodyRestraintAbolitionRadioContainer;
  }

  /**
   * �g�̍S���p�~�����{���Z���f�����擾���܂��B
   * @return �g�̍S���p�~�����{���Z���f��
   */
  protected ACListModelAdapter getBodyRestraintAbolitionRadioModel(){
    if(bodyRestraintAbolitionRadioModel==null){
      bodyRestraintAbolitionRadioModel = new ACListModelAdapter();
      addBodyRestraintAbolitionRadioModel();
    }
    return bodyRestraintAbolitionRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getBodyRestraintAbolitionRadioItem1(){
    if(bodyRestraintAbolitionRadioItem1==null){

      bodyRestraintAbolitionRadioItem1 = new ACRadioButtonItem();

      bodyRestraintAbolitionRadioItem1.setText("�Ȃ�");

      bodyRestraintAbolitionRadioItem1.setGroup(getBodyRestraintAbolitionRadio());

      bodyRestraintAbolitionRadioItem1.setConstraints(VRLayout.FLOW);

      addBodyRestraintAbolitionRadioItem1();
    }
    return bodyRestraintAbolitionRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getBodyRestraintAbolitionRadioItem2(){
    if(bodyRestraintAbolitionRadioItem2==null){

      bodyRestraintAbolitionRadioItem2 = new ACRadioButtonItem();

      bodyRestraintAbolitionRadioItem2.setText("����");

      bodyRestraintAbolitionRadioItem2.setGroup(getBodyRestraintAbolitionRadio());

      bodyRestraintAbolitionRadioItem2.setConstraints(VRLayout.FLOW);

      addBodyRestraintAbolitionRadioItem2();
    }
    return bodyRestraintAbolitionRadioItem2;

  }

  /**
   * �ݑ�A�x���@�\���Z���擾���܂��B
   * @return �ݑ�A�x���@�\���Z
   */
  public ACClearableRadioButtonGroup getStayReturnSupportAddRadio(){
    if(stayReturnSupportAddRadio==null){

      stayReturnSupportAddRadio = new ACClearableRadioButtonGroup();

      getStayReturnSupportAddRadioContainer().setText("�ݑ�A�x���@�\���Z");

      stayReturnSupportAddRadio.setBindPath("1530118");

      stayReturnSupportAddRadio.setModel(getStayReturnSupportAddRadioModel());

      stayReturnSupportAddRadio.setUseClearButton(false);

      addStayReturnSupportAddRadio();
    }
    return stayReturnSupportAddRadio;

  }

  /**
   * �ݑ�A�x���@�\���Z�R���e�i���擾���܂��B
   * @return �ݑ�A�x���@�\���Z�R���e�i
   */
  protected ACLabelContainer getStayReturnSupportAddRadioContainer(){
    if(stayReturnSupportAddRadioContainer==null){
      stayReturnSupportAddRadioContainer = new ACLabelContainer();
      stayReturnSupportAddRadioContainer.setFollowChildEnabled(true);
      stayReturnSupportAddRadioContainer.setVAlignment(VRLayout.CENTER);
      stayReturnSupportAddRadioContainer.add(getStayReturnSupportAddRadio(), null);
    }
    return stayReturnSupportAddRadioContainer;
  }

  /**
   * �ݑ�A�x���@�\���Z���f�����擾���܂��B
   * @return �ݑ�A�x���@�\���Z���f��
   */
  protected ACListModelAdapter getStayReturnSupportAddRadioModel(){
    if(stayReturnSupportAddRadioModel==null){
      stayReturnSupportAddRadioModel = new ACListModelAdapter();
      addStayReturnSupportAddRadioModel();
    }
    return stayReturnSupportAddRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getStayReturnSupportAddRadioItem1(){
    if(stayReturnSupportAddRadioItem1==null){

      stayReturnSupportAddRadioItem1 = new ACRadioButtonItem();

      stayReturnSupportAddRadioItem1.setText("�Ȃ�");

      stayReturnSupportAddRadioItem1.setGroup(getStayReturnSupportAddRadio());

      stayReturnSupportAddRadioItem1.setConstraints(VRLayout.FLOW);

      addStayReturnSupportAddRadioItem1();
    }
    return stayReturnSupportAddRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getStayReturnSupportAddRadioItem2(){
    if(stayReturnSupportAddRadioItem2==null){

      stayReturnSupportAddRadioItem2 = new ACRadioButtonItem();

      stayReturnSupportAddRadioItem2.setText("����");

      stayReturnSupportAddRadioItem2.setGroup(getStayReturnSupportAddRadio());

      stayReturnSupportAddRadioItem2.setConstraints(VRLayout.FLOW);

      addStayReturnSupportAddRadioItem2();
    }
    return stayReturnSupportAddRadioItem2;

  }

  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001120Design() {

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

    tabs.addTab("3", getTab3());

  }

  /**
   * �^�u1�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTab1(){

    tab1.add(getMedicalFacilityHospitalInstitutionDivisionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getMedicalFacilityHospitalHospitalDivisionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getMedicalFacilityHospitalHospitalRoomContena(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getMedicalFacilityHospitalNightShiftSubtractionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getMedicalFacilityHospitalEnvironmentalRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getMedicalFacilityHospitalDoctorArrangeStandardRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getMedicalFacilityHospitalStayRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * �{�ݓ��̋敪�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityHospitalInstitutionDivisionRadio(){

  }

  /**
   * �{�ݓ��̋敪���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityHospitalInstitutionDivisionRadioModel(){

    getMedicalFacilityHospitalHospitalInstitutionDivisionRadioItem1().setButtonIndex(1);
    getMedicalFacilityHospitalInstitutionDivisionRadioModel().add(getMedicalFacilityHospitalHospitalInstitutionDivisionRadioItem1());

    getMedicalFacilityHospitalHospitalInstitutionDivisionRadioItem2().setButtonIndex(2);
    getMedicalFacilityHospitalInstitutionDivisionRadioModel().add(getMedicalFacilityHospitalHospitalInstitutionDivisionRadioItem2());

  }

  /**
   * �a�@�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityHospitalHospitalInstitutionDivisionRadioItem1(){

  }

  /**
   * ���j�b�g�^�a�@�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityHospitalHospitalInstitutionDivisionRadioItem2(){

  }

  /**
   * �l���z�u�敪�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityHospitalHospitalDivision(){

  }

  /**
   * �l���z�u�敪���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityHospitalHospitalDivisionModel(){

    getMedicalFacilityHospitalDivision1().setButtonIndex(1);
    getMedicalFacilityHospitalHospitalDivisionModel().add(getMedicalFacilityHospitalDivision1());

    getMedicalFacilityHospitalDivision2().setButtonIndex(2);
    getMedicalFacilityHospitalHospitalDivisionModel().add(getMedicalFacilityHospitalDivision2());

    getMedicalFacilityHospitalDivision3().setButtonIndex(3);
    getMedicalFacilityHospitalHospitalDivisionModel().add(getMedicalFacilityHospitalDivision3());

  }

  /**
   * I�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityHospitalDivision1(){

  }

  /**
   * II�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityHospitalDivision2(){

  }

  /**
   * III�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityHospitalDivision3(){

  }

  /**
   * �a���敪�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityHospitalHospitalRoomContena(){

    medicalFacilityHospitalHospitalRoomContena.add(getMedicalFacilityHospitalHospitalRoomRadio(), VRLayout.FLOW_INSETLINE_RETURN);

    medicalFacilityHospitalHospitalRoomContena.add(getMedicalFacilityHospitalUnitHospitalRoomRadio(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * �a���敪�i�a�@�j�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityHospitalHospitalRoomRadio(){

  }

  /**
   * �a���敪�i�a�@�j���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityHospitalHospitalRoomRadioModel(){

    getMedicalFacilityHospitalHospitalRoomRadioItem1().setButtonIndex(1);
    getMedicalFacilityHospitalHospitalRoomRadioModel().add(getMedicalFacilityHospitalHospitalRoomRadioItem1());

    getMedicalFacilityHospitalHospitalRoomRadioItem2().setButtonIndex(2);
    getMedicalFacilityHospitalHospitalRoomRadioModel().add(getMedicalFacilityHospitalHospitalRoomRadioItem2());

  }

  /**
   * �]���^���ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityHospitalHospitalRoomRadioItem1(){

  }

  /**
   * �������ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityHospitalHospitalRoomRadioItem2(){

  }

  /**
   * �a���敪�i���j�b�g�^�j�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityHospitalUnitHospitalRoomRadio(){

  }

  /**
   * �a���敪�i���j�b�g�^�j���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityHospitalUnitHospitalRoomRadioModel(){

    getMedicalFacilityHospitalUnitHospitalRoomRadioItem1().setButtonIndex(1);
    getMedicalFacilityHospitalUnitHospitalRoomRadioModel().add(getMedicalFacilityHospitalUnitHospitalRoomRadioItem1());

    getMedicalFacilityHospitalUnitHospitalRoomRadioItem2().setButtonIndex(2);
    getMedicalFacilityHospitalUnitHospitalRoomRadioModel().add(getMedicalFacilityHospitalUnitHospitalRoomRadioItem2());

  }

  /**
   * ���j�b�g�^���ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityHospitalUnitHospitalRoomRadioItem1(){

  }

  /**
   * ���j�b�g�^�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityHospitalUnitHospitalRoomRadioItem2(){

  }

  /**
   * ��ԋΖ�������ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityHospitalNightShiftSubtractionRadio(){

  }

  /**
   * ��ԋΖ���������f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityHospitalNightShiftSubtractionRadioModel(){

    getMedicalFacilityHospitalNightShiftSubtractionRadioItem1().setButtonIndex(1);
    getMedicalFacilityHospitalNightShiftSubtractionRadioModel().add(getMedicalFacilityHospitalNightShiftSubtractionRadioItem1());

    getMedicalFacilityHospitalNightShiftSubtractionRadioItem2().setButtonIndex(2);
    getMedicalFacilityHospitalNightShiftSubtractionRadioModel().add(getMedicalFacilityHospitalNightShiftSubtractionRadioItem2());

    getMedicalFacilityHospitalNightShiftSubtractionRadioItem3().setButtonIndex(3);
    getMedicalFacilityHospitalNightShiftSubtractionRadioModel().add(getMedicalFacilityHospitalNightShiftSubtractionRadioItem3());

    getMedicalFacilityHospitalNightShiftSubtractionRadioItem4().setButtonIndex(4);
    getMedicalFacilityHospitalNightShiftSubtractionRadioModel().add(getMedicalFacilityHospitalNightShiftSubtractionRadioItem4());

    getMedicalFacilityHospitalNightShiftSubtractionRadioItem5().setButtonIndex(5);
    getMedicalFacilityHospitalNightShiftSubtractionRadioModel().add(getMedicalFacilityHospitalNightShiftSubtractionRadioItem5());

  }

  /**
   * ��^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityHospitalNightShiftSubtractionRadioItem1(){

  }

  /**
   * ���Z�^I�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityHospitalNightShiftSubtractionRadioItem2(){

  }

  /**
   * ���Z�^II�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityHospitalNightShiftSubtractionRadioItem3(){

  }

  /**
   * ���Z�^III�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityHospitalNightShiftSubtractionRadioItem4(){

  }

  /**
   * ���Z�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityHospitalNightShiftSubtractionRadioItem5(){

  }

  /**
   * �×{����ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityHospitalEnvironmentalRadio(){

  }

  /**
   * �×{������f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityHospitalEnvironmentalRadioModel(){

    getMedicalFacilityHospitalEnvironmentalRadioItem1().setButtonIndex(1);
    getMedicalFacilityHospitalEnvironmentalRadioModel().add(getMedicalFacilityHospitalEnvironmentalRadioItem1());

    getMedicalFacilityHospitalEnvironmentalRadioItem2().setButtonIndex(2);
    getMedicalFacilityHospitalEnvironmentalRadioModel().add(getMedicalFacilityHospitalEnvironmentalRadioItem2());

    getMedicalFacilityHospitalEnvironmentalRadioItem3().setButtonIndex(3);
    getMedicalFacilityHospitalEnvironmentalRadioModel().add(getMedicalFacilityHospitalEnvironmentalRadioItem3());

    getMedicalFacilityHospitalEnvironmentalRadioItem4().setButtonIndex(4);
    getMedicalFacilityHospitalEnvironmentalRadioModel().add(getMedicalFacilityHospitalEnvironmentalRadioItem4());

  }

  /**
   * ��^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityHospitalEnvironmentalRadioItem1(){

  }

  /**
   * ���ZI�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityHospitalEnvironmentalRadioItem2(){

  }

  /**
   * ���ZII�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityHospitalEnvironmentalRadioItem3(){

  }

  /**
   * ���ZIII�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityHospitalEnvironmentalRadioItem4(){

  }

  /**
   * ��t�̔z�u��ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityHospitalDoctorArrangeStandardRadio(){

  }

  /**
   * ��t�̔z�u����f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityHospitalDoctorArrangeStandardRadioModel(){

    getMedicalFacilityHospitalDoctorArrangeStandardRadioItem1().setButtonIndex(1);
    getMedicalFacilityHospitalDoctorArrangeStandardRadioModel().add(getMedicalFacilityHospitalDoctorArrangeStandardRadioItem1());

    getMedicalFacilityHospitalDoctorArrangeStandardRadioItem2().setButtonIndex(2);
    getMedicalFacilityHospitalDoctorArrangeStandardRadioModel().add(getMedicalFacilityHospitalDoctorArrangeStandardRadioItem2());

  }

  /**
   * ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityHospitalDoctorArrangeStandardRadioItem1(){

  }

  /**
   * ��Ö@�{�s�K����49��K�p�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityHospitalDoctorArrangeStandardRadioItem2(){

  }

  /**
   * �O�����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityHospitalStayRadio(){

  }

  /**
   * �O�����Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityHospitalStayRadioModel(){

    getMedicalFacilityHospitalStayRadioItem1().setButtonIndex(1);
    getMedicalFacilityHospitalStayRadioModel().add(getMedicalFacilityHospitalStayRadioItem1());

    getMedicalFacilityHospitalStayRadioItem2().setButtonIndex(2);
    getMedicalFacilityHospitalStayRadioModel().add(getMedicalFacilityHospitalStayRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityHospitalStayRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityHospitalStayRadioItem2(){

  }

  /**
   * �^�u2�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTab2(){

    tab2.add(getMedicalFacilityHospitalStandardRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getMedicalFacilityHospitalMedicalExaminationRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getMedicalFacilityHospitalNutritionManageRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getMedicalFacilityHospitalNutritionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getMedicalFacilityHospitalOralSwitchRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getOralMaintenanceRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getMedicalFacilityHospitalRecuperateDinnerRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getMedicalFacilityHospitalHijoAddition(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * �������Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityHospitalStandardRadio(){

  }

  /**
   * �������Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityHospitalStandardRadioModel(){

    getMedicalFacilityHospitalStandardRadioItem1().setButtonIndex(1);
    getMedicalFacilityHospitalStandardRadioModel().add(getMedicalFacilityHospitalStandardRadioItem1());

    getMedicalFacilityHospitalStandardRadioItem2().setButtonIndex(2);
    getMedicalFacilityHospitalStandardRadioModel().add(getMedicalFacilityHospitalStandardRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityHospitalStandardRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityHospitalStandardRadioItem2(){

  }

  /**
   * ���Ȏ�f�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityHospitalMedicalExaminationRadio(){

  }

  /**
   * ���Ȏ�f���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityHospitalMedicalExaminationRadioModel(){

    getMedicalFacilityHospitalMedicalExaminationRadioItem1().setButtonIndex(1);
    getMedicalFacilityHospitalMedicalExaminationRadioModel().add(getMedicalFacilityHospitalMedicalExaminationRadioItem1());

    getMedicalFacilityHospitalMedicalExaminationRadioItem2().setButtonIndex(2);
    getMedicalFacilityHospitalMedicalExaminationRadioModel().add(getMedicalFacilityHospitalMedicalExaminationRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityHospitalMedicalExaminationRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityHospitalMedicalExaminationRadioItem2(){

  }

  /**
   * �h�{�Ǘ��̐����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityHospitalNutritionManageRadio(){

  }

  /**
   * �h�{�Ǘ��̐����Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityHospitalNutritionManageRadioModel(){

    getMedicalFacilityHospitalNutritionManageRadioItem1().setButtonIndex(1);
    getMedicalFacilityHospitalNutritionManageRadioModel().add(getMedicalFacilityHospitalNutritionManageRadioItem1());

    getMedicalFacilityHospitalNutritionManageRadioItem2().setButtonIndex(2);
    getMedicalFacilityHospitalNutritionManageRadioModel().add(getMedicalFacilityHospitalNutritionManageRadioItem2());

    getMedicalFacilityHospitalNutritionManageRadioItem3().setButtonIndex(3);
    getMedicalFacilityHospitalNutritionManageRadioModel().add(getMedicalFacilityHospitalNutritionManageRadioItem3());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityHospitalNutritionManageRadioItem1(){

  }

  /**
   * �Ǘ��h�{�m�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityHospitalNutritionManageRadioItem2(){

  }

  /**
   * �h�{�m�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityHospitalNutritionManageRadioItem3(){

  }

  /**
   * �h�{�}�l�W�����g���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityHospitalNutritionRadio(){

  }

  /**
   * �h�{�}�l�W�����g���Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityHospitalNutritionRadioModel(){

    getMedicalFacilityHospitalNutritionRadioItem1().setButtonIndex(1);
    getMedicalFacilityHospitalNutritionRadioModel().add(getMedicalFacilityHospitalNutritionRadioItem1());

    getMedicalFacilityHospitalNutritionRadioItem2().setButtonIndex(2);
    getMedicalFacilityHospitalNutritionRadioModel().add(getMedicalFacilityHospitalNutritionRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityHospitalNutritionRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityHospitalNutritionRadioItem2(){

  }

  /**
   * �o���ڍs���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityHospitalOralSwitchRadio(){

  }

  /**
   * �o���ڍs���Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityHospitalOralSwitchRadioModel(){

    getMedicalFacilityHospitalOralSwitchRadioItem1().setButtonIndex(1);
    getMedicalFacilityHospitalOralSwitchRadioModel().add(getMedicalFacilityHospitalOralSwitchRadioItem1());

    getMedicalFacilityHospitalOralSwitchRadioItem2().setButtonIndex(2);
    getMedicalFacilityHospitalOralSwitchRadioModel().add(getMedicalFacilityHospitalOralSwitchRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityHospitalOralSwitchRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityHospitalOralSwitchRadioItem2(){

  }

  /**
   * �o���ێ����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addOralMaintenanceRadio(){

  }

  /**
   * �o���ێ����Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addOralMaintenanceRadioModel(){

    getOralMaintenanceRadioItem1().setButtonIndex(1);
    getOralMaintenanceRadioModel().add(getOralMaintenanceRadioItem1());

    getOralMaintenanceRadioItem2().setButtonIndex(2);
    getOralMaintenanceRadioModel().add(getOralMaintenanceRadioItem2());

    getOralMaintenanceRadioItem3().setButtonIndex(3);
    getOralMaintenanceRadioModel().add(getOralMaintenanceRadioItem3());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addOralMaintenanceRadioItem1(){

  }

  /**
   * I�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addOralMaintenanceRadioItem2(){

  }

  /**
   * II�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addOralMaintenanceRadioItem3(){

  }

  /**
   * �×{�H���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityHospitalRecuperateDinnerRadio(){

  }

  /**
   * �×{�H���Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityHospitalRecuperateDinnerRadioModel(){

    getMedicalFacilityHospitalRecuperateDinnerRadioItem1().setButtonIndex(1);
    getMedicalFacilityHospitalRecuperateDinnerRadioModel().add(getMedicalFacilityHospitalRecuperateDinnerRadioItem1());

    getMedicalFacilityHospitalRecuperateDinnerRadioItem2().setButtonIndex(2);
    getMedicalFacilityHospitalRecuperateDinnerRadioModel().add(getMedicalFacilityHospitalRecuperateDinnerRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityHospitalRecuperateDinnerRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityHospitalRecuperateDinnerRadioItem2(){

  }

  /**
   * �ޏ��֘A���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityHospitalHijoAddition(){

    medicalFacilityHospitalHijoAddition.add(getLeavingHospitalPreConsultationAddition(), VRLayout.FLOW_RETURN);

    medicalFacilityHospitalHijoAddition.add(getLeavingHospitalConsultationAddition(), VRLayout.FLOW_RETURN);

    medicalFacilityHospitalHijoAddition.add(getLeavingHospitalDissemination(), VRLayout.FLOW_RETURN);

    medicalFacilityHospitalHijoAddition.add(getLeavingHospitalCooperationAddition(), VRLayout.FLOW_RETURN);

    medicalFacilityHospitalHijoAddition.add(getLeavingHospital(), VRLayout.FLOW_RETURN);

  }

  /**
   * �ޏ�(�@)�O��K��w�����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addLeavingHospitalPreConsultationAddition(){

  }

  /**
   * �ޏ�(�@)���w�����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addLeavingHospitalConsultationAddition(){

  }

  /**
   * �ޏ�(�@)�����񋟉��Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addLeavingHospitalDissemination(){

  }

  /**
   * �ޏ�(�@)�O�A�g���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addLeavingHospitalCooperationAddition(){

  }

  /**
   * �V�l�K��Ō�w�����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addLeavingHospital(){

  }

  /**
   * �^�u3�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTab3(){

    tab3.add(getMedicalFacilityHospitalConsultationFee(), VRLayout.FLOW);

    tab3.add(getMedicalFacilityHospitalConsultationFeeLabel(), VRLayout.FLOW_RETURN);

    tab3.add(getMedicalFacilityHospitalSubstractionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab3.add(getMedicalFacilityDinnerContainer(), VRLayout.FLOW_DOUBLEINSETLINE_RETURN);

    tab3.add(getUnitCareMaintenanceRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab3.add(getBodyRestraintAbolitionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab3.add(getStayReturnSupportAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * ����f�Ô�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityHospitalConsultationFee(){

  }

  /**
   * ���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityHospitalConsultationFeeLabel(){

  }

  /**
   * �l�����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityHospitalSubstraction(){

  }

  /**
   * �l�����Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityHospitalSubstractionModel(){

  }

  /**
   * �H���R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityDinnerContainer(){

    medicalFacilityDinnerContainer.add(getMedicalFacilityDinnerOfferContainer(), VRLayout.FLOW);

    medicalFacilityDinnerContainer.add(getMedicalFacilityDinnerCostContainer(), VRLayout.FLOW);

  }

  /**
   * �H���񋟂ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityDinnerOffer(){

  }

  /**
   * �H���񋟃��f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityDinnerOfferModel(){

  }

  /**
   * �H����p�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityDinnerCost(){

  }

  /**
   * ���j�b�g�P�A�̐����ɓ������ڂ�ǉ����܂��B
   */
  protected void addUnitCareMaintenanceRadio(){

  }

  /**
   * ���j�b�g�P�A�̐������f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addUnitCareMaintenanceRadioModel(){

    getUnitCareMaintenanceRadioItem1().setButtonIndex(1);
    getUnitCareMaintenanceRadioModel().add(getUnitCareMaintenanceRadioItem1());

    getUnitCareMaintenanceRadioItem2().setButtonIndex(2);
    getUnitCareMaintenanceRadioModel().add(getUnitCareMaintenanceRadioItem2());

  }

  /**
   * �������ɓ������ڂ�ǉ����܂��B
   */
  protected void addUnitCareMaintenanceRadioItem1(){

  }

  /**
   * �����ɓ������ڂ�ǉ����܂��B
   */
  protected void addUnitCareMaintenanceRadioItem2(){

  }

  /**
   * �g�̍S���p�~�����{���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addBodyRestraintAbolitionRadio(){

  }

  /**
   * �g�̍S���p�~�����{���Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addBodyRestraintAbolitionRadioModel(){

    getBodyRestraintAbolitionRadioItem1().setButtonIndex(1);
    getBodyRestraintAbolitionRadioModel().add(getBodyRestraintAbolitionRadioItem1());

    getBodyRestraintAbolitionRadioItem2().setButtonIndex(2);
    getBodyRestraintAbolitionRadioModel().add(getBodyRestraintAbolitionRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addBodyRestraintAbolitionRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addBodyRestraintAbolitionRadioItem2(){

  }

  /**
   * �ݑ�A�x���@�\���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addStayReturnSupportAddRadio(){

  }

  /**
   * �ݑ�A�x���@�\���Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addStayReturnSupportAddRadioModel(){

    getStayReturnSupportAddRadioItem1().setButtonIndex(1);
    getStayReturnSupportAddRadioModel().add(getStayReturnSupportAddRadioItem1());

    getStayReturnSupportAddRadioItem2().setButtonIndex(2);
    getStayReturnSupportAddRadioModel().add(getStayReturnSupportAddRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addStayReturnSupportAddRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addStayReturnSupportAddRadioItem2(){

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
      ACFrame.debugStart(new ACAffairInfo(QS001120Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QS001120Design getThis() {
    return this;
  }
}
