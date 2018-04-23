
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
 * �쐬��: 2018/03/15  ���{�R���s���[�^�[������� ����@��F �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �T�[�r�X�\��쐬/�ύX (S)
 * �v���Z�X �T�[�r�X�\��T�� (001)
 * �v���O���� �T�[�r�X�p�^�[�����×{�^��Î{�݁i�F�m�ǁj (QS001_15313_201804)
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
 * �T�[�r�X�p�^�[�����×{�^��Î{�݁i�F�m�ǁj��ʍ��ڃf�U�C��(QS001_15313_201804) 
 */
public class QS001_15313_201804Design extends QS001ServicePanel {
  //GUI�R���|�[�l���g

  private JTabbedPane tabs;

  private ACPanel tab1;

  private ACValueArrayRadioButtonGroup medicalFacilityCognitiveHospitalInstitutionDivisionRadio;

  private ACLabelContainer medicalFacilityCognitiveHospitalInstitutionDivisionRadioContainer;

  private ACListModelAdapter medicalFacilityCognitiveHospitalInstitutionDivisionRadioModel;

  private ACRadioButtonItem medicalFacilityCognitiveHospitalHospitalInstitutionDivisionRadioItem1;

  private ACRadioButtonItem medicalFacilityCognitiveHospitalHospitalInstitutionDivisionRadioItem2;

  private ACRadioButtonItem medicalFacilityCognitiveHospitalHospitalInstitutionDivisionRadioItem3;

  private ACValueArrayRadioButtonGroup hospitalDivisionRadio;

  private ACLabelContainer hospitalDivisionRadioContainer;

  private ACListModelAdapter hospitalDivisionRadioModel;

  private ACRadioButtonItem hospitalDivisionRadioItem1;

  private ACRadioButtonItem hospitalDivisionRadioItem2;

  private ACValueArrayRadioButtonGroup medicalFacilityCognitiveHospitalHospitalDivision;

  private ACLabelContainer medicalFacilityCognitiveHospitalHospitalDivisionContainer;

  private ACListModelAdapter medicalFacilityCognitiveHospitalHospitalDivisionModel;

  private ACRadioButtonItem medicalFacilityCognitiveHospitalDivision1;

  private ACRadioButtonItem medicalFacilityCognitiveHospitalDivision2;

  private ACRadioButtonItem medicalFacilityCognitiveHospitalDivision3;

  private ACRadioButtonItem medicalFacilityCognitiveHospitalDivision4;

  private ACRadioButtonItem medicalFacilityCognitiveHospitalDivision5;

  private ACLabelContainer medicalFacilityCognitiveHospitalHospitalRoomContena;

  private ACValueArrayRadioButtonGroup medicalFacilityCognitiveHospitalHospitalRoomRadio;

  private ACListModelAdapter medicalFacilityCognitiveHospitalHospitalRoomRadioModel;

  private ACRadioButtonItem medicalFacilityCognitiveHospitalHospitalRoomRadioItem1;

  private ACRadioButtonItem medicalFacilityCognitiveHospitalHospitalRoomRadioItem2;

  private ACValueArrayRadioButtonGroup medicalFacilityCognitiveHospitalUnitHospitalRoomRadio;

  private ACListModelAdapter medicalFacilityCognitiveHospitalUnitHospitalRoomRadioModel;

  private ACRadioButtonItem medicalFacilityCognitiveHospitalUnitHospitalRoomRadioItem1;

  private ACRadioButtonItem medicalFacilityCognitiveHospitalUnitHospitalRoomRadioItem2;

  private ACValueArrayRadioButtonGroup hospitalizedPatientsCriteriaRadio;

  private ACLabelContainer hospitalizedPatientsCriteriaRadioContainer;

  private ACListModelAdapter hospitalizedPatientsCriteriaRadioModel;

  private ACRadioButtonItem hospitalizedPatientsCriteriaRadioItem1;

  private ACRadioButtonItem hospitalizedPatientsCriteriaRadioItem2;

  private ACValueArrayRadioButtonGroup unitCareMaintenanceRadio;

  private ACLabelContainer unitCareMaintenanceRadioContainer;

  private ACListModelAdapter unitCareMaintenanceRadioModel;

  private ACRadioButtonItem unitCareMaintenanceRadioItem1;

  private ACRadioButtonItem unitCareMaintenanceRadioItem2;

  private ACPanel tab2;

  private ACValueArrayRadioButtonGroup medicalFacilityCognitiveHospitalStayRadio;

  private ACLabelContainer medicalFacilityCognitiveHospitalStayRadioContainer;

  private ACListModelAdapter medicalFacilityCognitiveHospitalStayRadioModel;

  private ACRadioButtonItem medicalFacilityCognitiveHospitalStayRadioItem1;

  private ACRadioButtonItem medicalFacilityCognitiveHospitalStayRadioItem2;

  private ACValueArrayRadioButtonGroup medicalFacilityCognitiveHospitalStandardRadio;

  private ACLabelContainer medicalFacilityCognitiveHospitalStandardRadioContainer;

  private ACListModelAdapter medicalFacilityCognitiveHospitalStandardRadioModel;

  private ACRadioButtonItem medicalFacilityCognitiveHospitalStandardRadioItem1;

  private ACRadioButtonItem medicalFacilityCognitiveHospitalStandardRadioItem2;

  private ACValueArrayRadioButtonGroup medicalFacilityCognitiveHospitalMedicalExaminationRadio;

  private ACLabelContainer medicalFacilityCognitiveHospitalMedicalExaminationRadioContainer;

  private ACListModelAdapter medicalFacilityCognitiveHospitalMedicalExaminationRadioModel;

  private ACRadioButtonItem medicalFacilityCognitiveHospitalMedicalExaminationRadioItem1;

  private ACRadioButtonItem medicalFacilityCognitiveHospitalMedicalExaminationRadioItem2;

  private ACValueArrayRadioButtonGroup medicalFacilityCognitiveHospitalNutritionRadio;

  private ACLabelContainer medicalFacilityCognitiveHospitalNutritionRadioContainer;

  private ACListModelAdapter medicalFacilityCognitiveHospitalNutritionRadioModel;

  private ACRadioButtonItem medicalFacilityCognitiveHospitalNutritionRadioItem1;

  private ACRadioButtonItem medicalFacilityCognitiveHospitalNutritionRadioItem2;

  private ACValueArrayRadioButtonGroup medicalFacilityCognitiveHospitalOralSwitchRadio;

  private ACLabelContainer medicalFacilityCognitiveHospitalOralSwitchRadioContainer;

  private ACListModelAdapter medicalFacilityCognitiveHospitalOralSwitchRadioModel;

  private ACRadioButtonItem medicalFacilityCognitiveHospitalOralSwitchRadioItem1;

  private ACRadioButtonItem medicalFacilityCognitiveHospitalOralSwitchRadioItem2;

  private ACLabelContainer oralMaintenanceAddContainer;

  private ACValueArrayRadioButtonGroup oralMaintenanceAdd;

  private ACListModelAdapter oralMaintenanceAddModel;

  private ACRadioButtonItem oralMaintenanceAddItem1;

  private ACRadioButtonItem oralMaintenanceAddItem2;

  private ACIntegerCheckBox oralMaintenanceAddItem3;

  private ACValueArrayRadioButtonGroup oralKeepStructureAddRadioGroup;

  private ACLabelContainer oralKeepStructureAddRadioGroupContainer;

  private ACListModelAdapter oralKeepStructureAddRadioGroupModel;

  private ACRadioButtonItem oralKeepStructureAddRadioItem1;

  private ACRadioButtonItem oralKeepStructureAddRadioItem2;

  private ACValueArrayRadioButtonGroup youngDementiaPatinetAddRadioGroup;

  private ACLabelContainer youngDementiaPatinetAddRadioGroupContainer;

  private ACListModelAdapter youngDementiaPatinetAddRadioGroupModel;

  private ACRadioButtonItem youngDementiaPatinetAddRadioItem1;

  private ACRadioButtonItem youngDementiaPatinetAddRadioItem2;

  private ACValueArrayRadioButtonGroup medicalFacilityCognitiveHospitalRecuperateDinnerRadio;

  private ACLabelContainer medicalFacilityCognitiveHospitalRecuperateDinnerRadioContainer;

  private ACListModelAdapter medicalFacilityCognitiveHospitalRecuperateDinnerRadioModel;

  private ACRadioButtonItem medicalFacilityCognitiveHospitalRecuperateDinnerRadioItem1;

  private ACRadioButtonItem medicalFacilityCognitiveHospitalRecuperateDinnerRadioItem2;

  private ACRadioButtonItem medicalFacilityCognitiveHospitalRecuperateDinnerRadioItem3;

  private ACRadioButtonItem medicalFacilityCognitiveHospitalRecuperateDinnerRadioItem4;

  private ACPanel tab3;

  private ACLabelContainer medicalFacilityCognitiveHospitalHijoAddition;

  private ACIntegerCheckBox leavingHospitalPreConsultationAddition;

  private ACIntegerCheckBox leavingHospitalAfterConsultationAddition;

  private ACIntegerCheckBox leavingHospitalConsultationAddition;

  private ACIntegerCheckBox leavingHospitalDissemination;

  private ACIntegerCheckBox leavingHospitalCooperationAddition;

  private ACIntegerCheckBox leavingHospital;

  private ACMapBindButton medicalFacilityCognitiveHospitalConsultationFee;

  private ACLabel medicalFacilityCognitiveHospitalConsultationFeeLabel;

  private ACComboBox medicalFacilityCognitiveHospitalSubstraction;

  private ACLabelContainer medicalFacilityCognitiveHospitalSubstractionContainer;

  private ACComboBoxModelAdapter medicalFacilityCognitiveHospitalSubstractionModel;

  private ACBackLabelContainer medicalFacilityCognitiveHospitalDinnerContainer;

  private ACComboBox medicalFacilityCognitiveHospitalDinnerOffer;

  private ACLabelContainer medicalFacilityCognitiveHospitalDinnerOfferContainer;

  private ACComboBoxModelAdapter medicalFacilityCognitiveHospitalDinnerOfferModel;

  private ACTextField medicalFacilityCognitiveHospitalDinnerCost;

  private ACLabelContainer medicalFacilityCognitiveHospitalDinnerCostContainer;

  private ACPanel tab4;

  private ACValueArrayRadioButtonGroup bodyRestraintAbolitionRadio;

  private ACLabelContainer bodyRestraintAbolitionRadioContainer;

  private ACListModelAdapter bodyRestraintAbolitionRadioModel;

  private ACRadioButtonItem bodyRestraintAbolitionRadioItem1;

  private ACRadioButtonItem bodyRestraintAbolitionRadioItem2;

  private ACValueArrayRadioButtonGroup stayReturnSupportAddRadio;

  private ACLabelContainer stayReturnSupportAddRadioContainer;

  private ACListModelAdapter stayReturnSupportAddRadioModel;

  private ACRadioButtonItem stayReturnSupportAddRadioitem1;

  private ACRadioButtonItem stayReturnSupportAddRadioitem2;

  private ACValueArrayRadioButtonGroup serviceAddProvisionStructuralRadioGroup;

  private ACLabelContainer serviceAddProvisionStructuralRadioGroupContainer;

  private ACListModelAdapter serviceAddProvisionStructuralRadioGroupModel;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem1;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem5;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem2;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem3;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem4;

  private ACValueArrayRadioButtonGroup lowNutritionalRiskImprovementAdd;

  private ACLabelContainer lowNutritionalRiskImprovementAddContainer;

  private ACListModelAdapter lowNutritionalRiskImprovementAddModel;

  private ACRadioButtonItem lowNutritionalRiskImprovementAddItem1;

  private ACRadioButtonItem lowNutritionalRiskImprovementAddItem2;

  private ACValueArrayRadioButtonGroup excretionSupport;

  private ACLabelContainer excretionSupportContainer;

  private ACListModelAdapter excretionSupportModel;

  private ACRadioButtonItem excretionSupportItem1;

  private ACRadioButtonItem excretionSupportItem2;

  private ACValueArrayRadioButtonGroup medicalFacilityCognitiveHospitalCalculationDivisionRadio;

  private ACLabelContainer medicalFacilityCognitiveHospitalCalculationDivisionRadioContainer;

  private ACListModelAdapter medicalFacilityCognitiveHospitalCalculationDivisionRadioModel;

  private ACRadioButtonItem medicalFacilityCognitiveHospitalCalculationDivisionRadioItem1;

  private ACRadioButtonItem medicalFacilityCognitiveHospitalCalculationDivisionRadioItem2;

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

      addTab1();
    }
    return tab1;

  }

  /**
   * �{�ݓ��̋敪���擾���܂��B
   * @return �{�ݓ��̋敪
   */
  public ACValueArrayRadioButtonGroup getMedicalFacilityCognitiveHospitalInstitutionDivisionRadio(){
    if(medicalFacilityCognitiveHospitalInstitutionDivisionRadio==null){

      medicalFacilityCognitiveHospitalInstitutionDivisionRadio = new ACValueArrayRadioButtonGroup();

      getMedicalFacilityCognitiveHospitalInstitutionDivisionRadioContainer().setText("�{�ݓ��̋敪");

      medicalFacilityCognitiveHospitalInstitutionDivisionRadio.setBindPath("1530301");

      medicalFacilityCognitiveHospitalInstitutionDivisionRadio.setUseClearButton(false);

      medicalFacilityCognitiveHospitalInstitutionDivisionRadio.setModel(getMedicalFacilityCognitiveHospitalInstitutionDivisionRadioModel());

      medicalFacilityCognitiveHospitalInstitutionDivisionRadio.setValues(new int[]{1,2,3});

      addMedicalFacilityCognitiveHospitalInstitutionDivisionRadio();
    }
    return medicalFacilityCognitiveHospitalInstitutionDivisionRadio;

  }

  /**
   * �{�ݓ��̋敪�R���e�i���擾���܂��B
   * @return �{�ݓ��̋敪�R���e�i
   */
  protected ACLabelContainer getMedicalFacilityCognitiveHospitalInstitutionDivisionRadioContainer(){
    if(medicalFacilityCognitiveHospitalInstitutionDivisionRadioContainer==null){
      medicalFacilityCognitiveHospitalInstitutionDivisionRadioContainer = new ACLabelContainer();
      medicalFacilityCognitiveHospitalInstitutionDivisionRadioContainer.setFollowChildEnabled(true);
      medicalFacilityCognitiveHospitalInstitutionDivisionRadioContainer.setVAlignment(VRLayout.CENTER);
      medicalFacilityCognitiveHospitalInstitutionDivisionRadioContainer.add(getMedicalFacilityCognitiveHospitalInstitutionDivisionRadio(), null);
    }
    return medicalFacilityCognitiveHospitalInstitutionDivisionRadioContainer;
  }

  /**
   * �{�ݓ��̋敪���f�����擾���܂��B
   * @return �{�ݓ��̋敪���f��
   */
  protected ACListModelAdapter getMedicalFacilityCognitiveHospitalInstitutionDivisionRadioModel(){
    if(medicalFacilityCognitiveHospitalInstitutionDivisionRadioModel==null){
      medicalFacilityCognitiveHospitalInstitutionDivisionRadioModel = new ACListModelAdapter();
      addMedicalFacilityCognitiveHospitalInstitutionDivisionRadioModel();
    }
    return medicalFacilityCognitiveHospitalInstitutionDivisionRadioModel;
  }

  /**
   * �F�m�ǎ����^���擾���܂��B
   * @return �F�m�ǎ����^
   */
  public ACRadioButtonItem getMedicalFacilityCognitiveHospitalHospitalInstitutionDivisionRadioItem1(){
    if(medicalFacilityCognitiveHospitalHospitalInstitutionDivisionRadioItem1==null){

      medicalFacilityCognitiveHospitalHospitalInstitutionDivisionRadioItem1 = new ACRadioButtonItem();

      medicalFacilityCognitiveHospitalHospitalInstitutionDivisionRadioItem1.setText("�F�m�ǎ����^");

      medicalFacilityCognitiveHospitalHospitalInstitutionDivisionRadioItem1.setGroup(getMedicalFacilityCognitiveHospitalInstitutionDivisionRadio());

      medicalFacilityCognitiveHospitalHospitalInstitutionDivisionRadioItem1.setConstraints(VRLayout.FLOW_RETURN);

      addMedicalFacilityCognitiveHospitalHospitalInstitutionDivisionRadioItem1();
    }
    return medicalFacilityCognitiveHospitalHospitalInstitutionDivisionRadioItem1;

  }

  /**
   * ���j�b�g�^�F�m�ǎ����^���擾���܂��B
   * @return ���j�b�g�^�F�m�ǎ����^
   */
  public ACRadioButtonItem getMedicalFacilityCognitiveHospitalHospitalInstitutionDivisionRadioItem2(){
    if(medicalFacilityCognitiveHospitalHospitalInstitutionDivisionRadioItem2==null){

      medicalFacilityCognitiveHospitalHospitalInstitutionDivisionRadioItem2 = new ACRadioButtonItem();

      medicalFacilityCognitiveHospitalHospitalInstitutionDivisionRadioItem2.setText("���j�b�g�^�F�m�ǎ����^");

      medicalFacilityCognitiveHospitalHospitalInstitutionDivisionRadioItem2.setGroup(getMedicalFacilityCognitiveHospitalInstitutionDivisionRadio());

      medicalFacilityCognitiveHospitalHospitalInstitutionDivisionRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

      addMedicalFacilityCognitiveHospitalHospitalInstitutionDivisionRadioItem2();
    }
    return medicalFacilityCognitiveHospitalHospitalInstitutionDivisionRadioItem2;

  }

  /**
   * �o�ߌ^���擾���܂��B
   * @return �o�ߌ^
   */
  public ACRadioButtonItem getMedicalFacilityCognitiveHospitalHospitalInstitutionDivisionRadioItem3(){
    if(medicalFacilityCognitiveHospitalHospitalInstitutionDivisionRadioItem3==null){

      medicalFacilityCognitiveHospitalHospitalInstitutionDivisionRadioItem3 = new ACRadioButtonItem();

      medicalFacilityCognitiveHospitalHospitalInstitutionDivisionRadioItem3.setText("�o�ߌ^");

      medicalFacilityCognitiveHospitalHospitalInstitutionDivisionRadioItem3.setGroup(getMedicalFacilityCognitiveHospitalInstitutionDivisionRadio());

      medicalFacilityCognitiveHospitalHospitalInstitutionDivisionRadioItem3.setConstraints(VRLayout.FLOW);

      addMedicalFacilityCognitiveHospitalHospitalInstitutionDivisionRadioItem3();
    }
    return medicalFacilityCognitiveHospitalHospitalInstitutionDivisionRadioItem3;

  }

  /**
   * �a�@�敪���擾���܂��B
   * @return �a�@�敪
   */
  public ACValueArrayRadioButtonGroup getHospitalDivisionRadio(){
    if(hospitalDivisionRadio==null){

      hospitalDivisionRadio = new ACValueArrayRadioButtonGroup();

      getHospitalDivisionRadioContainer().setText("�a�@�敪");

      hospitalDivisionRadio.setBindPath("1530316");

      hospitalDivisionRadio.setUseClearButton(false);

      hospitalDivisionRadio.setModel(getHospitalDivisionRadioModel());

      hospitalDivisionRadio.setValues(new int[]{1,2});

      addHospitalDivisionRadio();
    }
    return hospitalDivisionRadio;

  }

  /**
   * �a�@�敪�R���e�i���擾���܂��B
   * @return �a�@�敪�R���e�i
   */
  protected ACLabelContainer getHospitalDivisionRadioContainer(){
    if(hospitalDivisionRadioContainer==null){
      hospitalDivisionRadioContainer = new ACLabelContainer();
      hospitalDivisionRadioContainer.setFollowChildEnabled(true);
      hospitalDivisionRadioContainer.setVAlignment(VRLayout.CENTER);
      hospitalDivisionRadioContainer.add(getHospitalDivisionRadio(), null);
    }
    return hospitalDivisionRadioContainer;
  }

  /**
   * �a�@�敪���f�����擾���܂��B
   * @return �a�@�敪���f��
   */
  protected ACListModelAdapter getHospitalDivisionRadioModel(){
    if(hospitalDivisionRadioModel==null){
      hospitalDivisionRadioModel = new ACListModelAdapter();
      addHospitalDivisionRadioModel();
    }
    return hospitalDivisionRadioModel;
  }

  /**
   * ��w�a�@���擾���܂��B
   * @return ��w�a�@
   */
  public ACRadioButtonItem getHospitalDivisionRadioItem1(){
    if(hospitalDivisionRadioItem1==null){

      hospitalDivisionRadioItem1 = new ACRadioButtonItem();

      hospitalDivisionRadioItem1.setText("��w�a�@");

      hospitalDivisionRadioItem1.setGroup(getHospitalDivisionRadio());

      hospitalDivisionRadioItem1.setConstraints(VRLayout.FLOW);

      addHospitalDivisionRadioItem1();
    }
    return hospitalDivisionRadioItem1;

  }

  /**
   * ��ʕa�@���擾���܂��B
   * @return ��ʕa�@
   */
  public ACRadioButtonItem getHospitalDivisionRadioItem2(){
    if(hospitalDivisionRadioItem2==null){

      hospitalDivisionRadioItem2 = new ACRadioButtonItem();

      hospitalDivisionRadioItem2.setText("��ʕa�@");

      hospitalDivisionRadioItem2.setGroup(getHospitalDivisionRadio());

      hospitalDivisionRadioItem2.setConstraints(VRLayout.FLOW);

      addHospitalDivisionRadioItem2();
    }
    return hospitalDivisionRadioItem2;

  }

  /**
   * �l���z�u�敪���擾���܂��B
   * @return �l���z�u�敪
   */
  public ACValueArrayRadioButtonGroup getMedicalFacilityCognitiveHospitalHospitalDivision(){
    if(medicalFacilityCognitiveHospitalHospitalDivision==null){

      medicalFacilityCognitiveHospitalHospitalDivision = new ACValueArrayRadioButtonGroup();

      getMedicalFacilityCognitiveHospitalHospitalDivisionContainer().setText("�l���z�u�敪");

      medicalFacilityCognitiveHospitalHospitalDivision.setBindPath("1530302");

      medicalFacilityCognitiveHospitalHospitalDivision.setUseClearButton(false);

      medicalFacilityCognitiveHospitalHospitalDivision.setModel(getMedicalFacilityCognitiveHospitalHospitalDivisionModel());

      medicalFacilityCognitiveHospitalHospitalDivision.setValues(new int[]{1,2,3,4,5});

      addMedicalFacilityCognitiveHospitalHospitalDivision();
    }
    return medicalFacilityCognitiveHospitalHospitalDivision;

  }

  /**
   * �l���z�u�敪�R���e�i���擾���܂��B
   * @return �l���z�u�敪�R���e�i
   */
  protected ACLabelContainer getMedicalFacilityCognitiveHospitalHospitalDivisionContainer(){
    if(medicalFacilityCognitiveHospitalHospitalDivisionContainer==null){
      medicalFacilityCognitiveHospitalHospitalDivisionContainer = new ACLabelContainer();
      medicalFacilityCognitiveHospitalHospitalDivisionContainer.setFollowChildEnabled(true);
      medicalFacilityCognitiveHospitalHospitalDivisionContainer.setVAlignment(VRLayout.CENTER);
      medicalFacilityCognitiveHospitalHospitalDivisionContainer.add(getMedicalFacilityCognitiveHospitalHospitalDivision(), null);
    }
    return medicalFacilityCognitiveHospitalHospitalDivisionContainer;
  }

  /**
   * �l���z�u�敪���f�����擾���܂��B
   * @return �l���z�u�敪���f��
   */
  protected ACListModelAdapter getMedicalFacilityCognitiveHospitalHospitalDivisionModel(){
    if(medicalFacilityCognitiveHospitalHospitalDivisionModel==null){
      medicalFacilityCognitiveHospitalHospitalDivisionModel = new ACListModelAdapter();
      addMedicalFacilityCognitiveHospitalHospitalDivisionModel();
    }
    return medicalFacilityCognitiveHospitalHospitalDivisionModel;
  }

  /**
   * I�^���擾���܂��B
   * @return I�^
   */
  public ACRadioButtonItem getMedicalFacilityCognitiveHospitalDivision1(){
    if(medicalFacilityCognitiveHospitalDivision1==null){

      medicalFacilityCognitiveHospitalDivision1 = new ACRadioButtonItem();

      medicalFacilityCognitiveHospitalDivision1.setText("I�^");

      medicalFacilityCognitiveHospitalDivision1.setGroup(getMedicalFacilityCognitiveHospitalHospitalDivision());

      medicalFacilityCognitiveHospitalDivision1.setConstraints(VRLayout.FLOW);

      addMedicalFacilityCognitiveHospitalDivision1();
    }
    return medicalFacilityCognitiveHospitalDivision1;

  }

  /**
   * II�^���擾���܂��B
   * @return II�^
   */
  public ACRadioButtonItem getMedicalFacilityCognitiveHospitalDivision2(){
    if(medicalFacilityCognitiveHospitalDivision2==null){

      medicalFacilityCognitiveHospitalDivision2 = new ACRadioButtonItem();

      medicalFacilityCognitiveHospitalDivision2.setText("II�^");

      medicalFacilityCognitiveHospitalDivision2.setGroup(getMedicalFacilityCognitiveHospitalHospitalDivision());

      medicalFacilityCognitiveHospitalDivision2.setConstraints(VRLayout.FLOW);

      addMedicalFacilityCognitiveHospitalDivision2();
    }
    return medicalFacilityCognitiveHospitalDivision2;

  }

  /**
   * III�^���擾���܂��B
   * @return III�^
   */
  public ACRadioButtonItem getMedicalFacilityCognitiveHospitalDivision3(){
    if(medicalFacilityCognitiveHospitalDivision3==null){

      medicalFacilityCognitiveHospitalDivision3 = new ACRadioButtonItem();

      medicalFacilityCognitiveHospitalDivision3.setText("III�^");

      medicalFacilityCognitiveHospitalDivision3.setGroup(getMedicalFacilityCognitiveHospitalHospitalDivision());

      medicalFacilityCognitiveHospitalDivision3.setConstraints(VRLayout.FLOW_RETURN);

      addMedicalFacilityCognitiveHospitalDivision3();
    }
    return medicalFacilityCognitiveHospitalDivision3;

  }

  /**
   * IV�^���擾���܂��B
   * @return IV�^
   */
  public ACRadioButtonItem getMedicalFacilityCognitiveHospitalDivision4(){
    if(medicalFacilityCognitiveHospitalDivision4==null){

      medicalFacilityCognitiveHospitalDivision4 = new ACRadioButtonItem();

      medicalFacilityCognitiveHospitalDivision4.setText("IV�^");

      medicalFacilityCognitiveHospitalDivision4.setGroup(getMedicalFacilityCognitiveHospitalHospitalDivision());

      medicalFacilityCognitiveHospitalDivision4.setConstraints(VRLayout.FLOW);

      addMedicalFacilityCognitiveHospitalDivision4();
    }
    return medicalFacilityCognitiveHospitalDivision4;

  }

  /**
   * V�^���擾���܂��B
   * @return V�^
   */
  public ACRadioButtonItem getMedicalFacilityCognitiveHospitalDivision5(){
    if(medicalFacilityCognitiveHospitalDivision5==null){

      medicalFacilityCognitiveHospitalDivision5 = new ACRadioButtonItem();

      medicalFacilityCognitiveHospitalDivision5.setText("V�^");

      medicalFacilityCognitiveHospitalDivision5.setGroup(getMedicalFacilityCognitiveHospitalHospitalDivision());

      medicalFacilityCognitiveHospitalDivision5.setConstraints(VRLayout.FLOW);

      addMedicalFacilityCognitiveHospitalDivision5();
    }
    return medicalFacilityCognitiveHospitalDivision5;

  }

  /**
   * �a���敪�R���e�i���擾���܂��B
   * @return �a���敪�R���e�i
   */
  public ACLabelContainer getMedicalFacilityCognitiveHospitalHospitalRoomContena(){
    if(medicalFacilityCognitiveHospitalHospitalRoomContena==null){

      medicalFacilityCognitiveHospitalHospitalRoomContena = new ACLabelContainer();

      medicalFacilityCognitiveHospitalHospitalRoomContena.setText("�a���敪");

      medicalFacilityCognitiveHospitalHospitalRoomContena.setFollowChildEnabled(true);

      addMedicalFacilityCognitiveHospitalHospitalRoomContena();
    }
    return medicalFacilityCognitiveHospitalHospitalRoomContena;

  }

  /**
   * �a���敪�i�a�@�j���擾���܂��B
   * @return �a���敪�i�a�@�j
   */
  public ACValueArrayRadioButtonGroup getMedicalFacilityCognitiveHospitalHospitalRoomRadio(){
    if(medicalFacilityCognitiveHospitalHospitalRoomRadio==null){

      medicalFacilityCognitiveHospitalHospitalRoomRadio = new ACValueArrayRadioButtonGroup();

      medicalFacilityCognitiveHospitalHospitalRoomRadio.setBindPath("1530303");

      medicalFacilityCognitiveHospitalHospitalRoomRadio.setUseClearButton(false);

      medicalFacilityCognitiveHospitalHospitalRoomRadio.setModel(getMedicalFacilityCognitiveHospitalHospitalRoomRadioModel());

      medicalFacilityCognitiveHospitalHospitalRoomRadio.setValues(new int[]{1,2});

      addMedicalFacilityCognitiveHospitalHospitalRoomRadio();
    }
    return medicalFacilityCognitiveHospitalHospitalRoomRadio;

  }

  /**
   * �a���敪�i�a�@�j���f�����擾���܂��B
   * @return �a���敪�i�a�@�j���f��
   */
  protected ACListModelAdapter getMedicalFacilityCognitiveHospitalHospitalRoomRadioModel(){
    if(medicalFacilityCognitiveHospitalHospitalRoomRadioModel==null){
      medicalFacilityCognitiveHospitalHospitalRoomRadioModel = new ACListModelAdapter();
      addMedicalFacilityCognitiveHospitalHospitalRoomRadioModel();
    }
    return medicalFacilityCognitiveHospitalHospitalRoomRadioModel;
  }

  /**
   * �]���^�����擾���܂��B
   * @return �]���^��
   */
  public ACRadioButtonItem getMedicalFacilityCognitiveHospitalHospitalRoomRadioItem1(){
    if(medicalFacilityCognitiveHospitalHospitalRoomRadioItem1==null){

      medicalFacilityCognitiveHospitalHospitalRoomRadioItem1 = new ACRadioButtonItem();

      medicalFacilityCognitiveHospitalHospitalRoomRadioItem1.setText("�]���^��");

      medicalFacilityCognitiveHospitalHospitalRoomRadioItem1.setGroup(getMedicalFacilityCognitiveHospitalHospitalRoomRadio());

      medicalFacilityCognitiveHospitalHospitalRoomRadioItem1.setConstraints(VRLayout.FLOW);

      addMedicalFacilityCognitiveHospitalHospitalRoomRadioItem1();
    }
    return medicalFacilityCognitiveHospitalHospitalRoomRadioItem1;

  }

  /**
   * ���������擾���܂��B
   * @return ������
   */
  public ACRadioButtonItem getMedicalFacilityCognitiveHospitalHospitalRoomRadioItem2(){
    if(medicalFacilityCognitiveHospitalHospitalRoomRadioItem2==null){

      medicalFacilityCognitiveHospitalHospitalRoomRadioItem2 = new ACRadioButtonItem();

      medicalFacilityCognitiveHospitalHospitalRoomRadioItem2.setText("������");

      medicalFacilityCognitiveHospitalHospitalRoomRadioItem2.setGroup(getMedicalFacilityCognitiveHospitalHospitalRoomRadio());

      medicalFacilityCognitiveHospitalHospitalRoomRadioItem2.setConstraints(VRLayout.FLOW);

      addMedicalFacilityCognitiveHospitalHospitalRoomRadioItem2();
    }
    return medicalFacilityCognitiveHospitalHospitalRoomRadioItem2;

  }

  /**
   * �a���敪�i���j�b�g�^�j���擾���܂��B
   * @return �a���敪�i���j�b�g�^�j
   */
  public ACValueArrayRadioButtonGroup getMedicalFacilityCognitiveHospitalUnitHospitalRoomRadio(){
    if(medicalFacilityCognitiveHospitalUnitHospitalRoomRadio==null){

      medicalFacilityCognitiveHospitalUnitHospitalRoomRadio = new ACValueArrayRadioButtonGroup();

      medicalFacilityCognitiveHospitalUnitHospitalRoomRadio.setBindPath("1530304");

      medicalFacilityCognitiveHospitalUnitHospitalRoomRadio.setUseClearButton(false);

      medicalFacilityCognitiveHospitalUnitHospitalRoomRadio.setModel(getMedicalFacilityCognitiveHospitalUnitHospitalRoomRadioModel());

      medicalFacilityCognitiveHospitalUnitHospitalRoomRadio.setValues(new int[]{1,2});

      addMedicalFacilityCognitiveHospitalUnitHospitalRoomRadio();
    }
    return medicalFacilityCognitiveHospitalUnitHospitalRoomRadio;

  }

  /**
   * �a���敪�i���j�b�g�^�j���f�����擾���܂��B
   * @return �a���敪�i���j�b�g�^�j���f��
   */
  protected ACListModelAdapter getMedicalFacilityCognitiveHospitalUnitHospitalRoomRadioModel(){
    if(medicalFacilityCognitiveHospitalUnitHospitalRoomRadioModel==null){
      medicalFacilityCognitiveHospitalUnitHospitalRoomRadioModel = new ACListModelAdapter();
      addMedicalFacilityCognitiveHospitalUnitHospitalRoomRadioModel();
    }
    return medicalFacilityCognitiveHospitalUnitHospitalRoomRadioModel;
  }

  /**
   * ���j�b�g�^�����擾���܂��B
   * @return ���j�b�g�^��
   */
  public ACRadioButtonItem getMedicalFacilityCognitiveHospitalUnitHospitalRoomRadioItem1(){
    if(medicalFacilityCognitiveHospitalUnitHospitalRoomRadioItem1==null){

      medicalFacilityCognitiveHospitalUnitHospitalRoomRadioItem1 = new ACRadioButtonItem();

      medicalFacilityCognitiveHospitalUnitHospitalRoomRadioItem1.setText("�ƯČ^��");

      medicalFacilityCognitiveHospitalUnitHospitalRoomRadioItem1.setGroup(getMedicalFacilityCognitiveHospitalUnitHospitalRoomRadio());

      medicalFacilityCognitiveHospitalUnitHospitalRoomRadioItem1.setConstraints(VRLayout.FLOW);

      addMedicalFacilityCognitiveHospitalUnitHospitalRoomRadioItem1();
    }
    return medicalFacilityCognitiveHospitalUnitHospitalRoomRadioItem1;

  }

  /**
   * ���j�b�g�^���I���������擾���܂��B
   * @return ���j�b�g�^���I������
   */
  public ACRadioButtonItem getMedicalFacilityCognitiveHospitalUnitHospitalRoomRadioItem2(){
    if(medicalFacilityCognitiveHospitalUnitHospitalRoomRadioItem2==null){

      medicalFacilityCognitiveHospitalUnitHospitalRoomRadioItem2 = new ACRadioButtonItem();

      medicalFacilityCognitiveHospitalUnitHospitalRoomRadioItem2.setText("�ƯČ^���I������");

      medicalFacilityCognitiveHospitalUnitHospitalRoomRadioItem2.setGroup(getMedicalFacilityCognitiveHospitalUnitHospitalRoomRadio());

      medicalFacilityCognitiveHospitalUnitHospitalRoomRadioItem2.setConstraints(VRLayout.FLOW);

      addMedicalFacilityCognitiveHospitalUnitHospitalRoomRadioItem2();
    }
    return medicalFacilityCognitiveHospitalUnitHospitalRoomRadioItem2;

  }

  /**
   * ���@���҂Ɋւ������擾���܂��B
   * @return ���@���҂Ɋւ���
   */
  public ACValueArrayRadioButtonGroup getHospitalizedPatientsCriteriaRadio(){
    if(hospitalizedPatientsCriteriaRadio==null){

      hospitalizedPatientsCriteriaRadio = new ACValueArrayRadioButtonGroup();

      getHospitalizedPatientsCriteriaRadioContainer().setText("���@���҂Ɋւ���");

      hospitalizedPatientsCriteriaRadio.setBindPath("1530362");

      hospitalizedPatientsCriteriaRadio.setNoSelectIndex(0);

      hospitalizedPatientsCriteriaRadio.setUseClearButton(false);

      hospitalizedPatientsCriteriaRadio.setModel(getHospitalizedPatientsCriteriaRadioModel());

      hospitalizedPatientsCriteriaRadio.setValues(new int[]{2,1});

      addHospitalizedPatientsCriteriaRadio();
    }
    return hospitalizedPatientsCriteriaRadio;

  }

  /**
   * ���@���҂Ɋւ����R���e�i���擾���܂��B
   * @return ���@���҂Ɋւ����R���e�i
   */
  protected ACLabelContainer getHospitalizedPatientsCriteriaRadioContainer(){
    if(hospitalizedPatientsCriteriaRadioContainer==null){
      hospitalizedPatientsCriteriaRadioContainer = new ACLabelContainer();
      hospitalizedPatientsCriteriaRadioContainer.setFollowChildEnabled(true);
      hospitalizedPatientsCriteriaRadioContainer.setVAlignment(VRLayout.CENTER);
      hospitalizedPatientsCriteriaRadioContainer.add(getHospitalizedPatientsCriteriaRadio(), null);
    }
    return hospitalizedPatientsCriteriaRadioContainer;
  }

  /**
   * ���@���҂Ɋւ������f�����擾���܂��B
   * @return ���@���҂Ɋւ������f��
   */
  protected ACListModelAdapter getHospitalizedPatientsCriteriaRadioModel(){
    if(hospitalizedPatientsCriteriaRadioModel==null){
      hospitalizedPatientsCriteriaRadioModel = new ACListModelAdapter();
      addHospitalizedPatientsCriteriaRadioModel();
    }
    return hospitalizedPatientsCriteriaRadioModel;
  }

  /**
   * ��^���擾���܂��B
   * @return ��^
   */
  public ACRadioButtonItem getHospitalizedPatientsCriteriaRadioItem1(){
    if(hospitalizedPatientsCriteriaRadioItem1==null){

      hospitalizedPatientsCriteriaRadioItem1 = new ACRadioButtonItem();

      hospitalizedPatientsCriteriaRadioItem1.setText("��^");

      hospitalizedPatientsCriteriaRadioItem1.setGroup(getHospitalizedPatientsCriteriaRadio());

      hospitalizedPatientsCriteriaRadioItem1.setConstraints(VRLayout.FLOW);

      addHospitalizedPatientsCriteriaRadioItem1();
    }
    return hospitalizedPatientsCriteriaRadioItem1;

  }

  /**
   * ���Z�^���擾���܂��B
   * @return ���Z�^
   */
  public ACRadioButtonItem getHospitalizedPatientsCriteriaRadioItem2(){
    if(hospitalizedPatientsCriteriaRadioItem2==null){

      hospitalizedPatientsCriteriaRadioItem2 = new ACRadioButtonItem();

      hospitalizedPatientsCriteriaRadioItem2.setText("���Z�^");

      hospitalizedPatientsCriteriaRadioItem2.setGroup(getHospitalizedPatientsCriteriaRadio());

      hospitalizedPatientsCriteriaRadioItem2.setConstraints(VRLayout.FLOW);

      addHospitalizedPatientsCriteriaRadioItem2();
    }
    return hospitalizedPatientsCriteriaRadioItem2;

  }

  /**
   * ���j�b�g�P�A�̐������擾���܂��B
   * @return ���j�b�g�P�A�̐���
   */
  public ACValueArrayRadioButtonGroup getUnitCareMaintenanceRadio(){
    if(unitCareMaintenanceRadio==null){

      unitCareMaintenanceRadio = new ACValueArrayRadioButtonGroup();

      getUnitCareMaintenanceRadioContainer().setText("���j�b�g�P�A�̐���");

      unitCareMaintenanceRadio.setBindPath("1530313");

      unitCareMaintenanceRadio.setUseClearButton(false);

      unitCareMaintenanceRadio.setModel(getUnitCareMaintenanceRadioModel());

      unitCareMaintenanceRadio.setValues(new int[]{1,2});

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
   * �O�����Z���擾���܂��B
   * @return �O�����Z
   */
  public ACValueArrayRadioButtonGroup getMedicalFacilityCognitiveHospitalStayRadio(){
    if(medicalFacilityCognitiveHospitalStayRadio==null){

      medicalFacilityCognitiveHospitalStayRadio = new ACValueArrayRadioButtonGroup();

      getMedicalFacilityCognitiveHospitalStayRadioContainer().setText("�O�����Z");

      medicalFacilityCognitiveHospitalStayRadio.setBindPath("1530305");

      medicalFacilityCognitiveHospitalStayRadio.setUseClearButton(false);

      medicalFacilityCognitiveHospitalStayRadio.setModel(getMedicalFacilityCognitiveHospitalStayRadioModel());

      medicalFacilityCognitiveHospitalStayRadio.setValues(new int[]{1,2});

      addMedicalFacilityCognitiveHospitalStayRadio();
    }
    return medicalFacilityCognitiveHospitalStayRadio;

  }

  /**
   * �O�����Z�R���e�i���擾���܂��B
   * @return �O�����Z�R���e�i
   */
  protected ACLabelContainer getMedicalFacilityCognitiveHospitalStayRadioContainer(){
    if(medicalFacilityCognitiveHospitalStayRadioContainer==null){
      medicalFacilityCognitiveHospitalStayRadioContainer = new ACLabelContainer();
      medicalFacilityCognitiveHospitalStayRadioContainer.setFollowChildEnabled(true);
      medicalFacilityCognitiveHospitalStayRadioContainer.setVAlignment(VRLayout.CENTER);
      medicalFacilityCognitiveHospitalStayRadioContainer.add(getMedicalFacilityCognitiveHospitalStayRadio(), null);
    }
    return medicalFacilityCognitiveHospitalStayRadioContainer;
  }

  /**
   * �O�����Z���f�����擾���܂��B
   * @return �O�����Z���f��
   */
  protected ACListModelAdapter getMedicalFacilityCognitiveHospitalStayRadioModel(){
    if(medicalFacilityCognitiveHospitalStayRadioModel==null){
      medicalFacilityCognitiveHospitalStayRadioModel = new ACListModelAdapter();
      addMedicalFacilityCognitiveHospitalStayRadioModel();
    }
    return medicalFacilityCognitiveHospitalStayRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getMedicalFacilityCognitiveHospitalStayRadioItem1(){
    if(medicalFacilityCognitiveHospitalStayRadioItem1==null){

      medicalFacilityCognitiveHospitalStayRadioItem1 = new ACRadioButtonItem();

      medicalFacilityCognitiveHospitalStayRadioItem1.setText("�Ȃ�");

      medicalFacilityCognitiveHospitalStayRadioItem1.setGroup(getMedicalFacilityCognitiveHospitalStayRadio());

      medicalFacilityCognitiveHospitalStayRadioItem1.setConstraints(VRLayout.FLOW);

      addMedicalFacilityCognitiveHospitalStayRadioItem1();
    }
    return medicalFacilityCognitiveHospitalStayRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getMedicalFacilityCognitiveHospitalStayRadioItem2(){
    if(medicalFacilityCognitiveHospitalStayRadioItem2==null){

      medicalFacilityCognitiveHospitalStayRadioItem2 = new ACRadioButtonItem();

      medicalFacilityCognitiveHospitalStayRadioItem2.setText("����");

      medicalFacilityCognitiveHospitalStayRadioItem2.setGroup(getMedicalFacilityCognitiveHospitalStayRadio());

      medicalFacilityCognitiveHospitalStayRadioItem2.setConstraints(VRLayout.FLOW);

      addMedicalFacilityCognitiveHospitalStayRadioItem2();
    }
    return medicalFacilityCognitiveHospitalStayRadioItem2;

  }

  /**
   * �������Z���擾���܂��B
   * @return �������Z
   */
  public ACValueArrayRadioButtonGroup getMedicalFacilityCognitiveHospitalStandardRadio(){
    if(medicalFacilityCognitiveHospitalStandardRadio==null){

      medicalFacilityCognitiveHospitalStandardRadio = new ACValueArrayRadioButtonGroup();

      getMedicalFacilityCognitiveHospitalStandardRadioContainer().setText("�������Z");

      medicalFacilityCognitiveHospitalStandardRadio.setBindPath("1530306");

      medicalFacilityCognitiveHospitalStandardRadio.setUseClearButton(false);

      medicalFacilityCognitiveHospitalStandardRadio.setModel(getMedicalFacilityCognitiveHospitalStandardRadioModel());

      medicalFacilityCognitiveHospitalStandardRadio.setValues(new int[]{1,2});

      addMedicalFacilityCognitiveHospitalStandardRadio();
    }
    return medicalFacilityCognitiveHospitalStandardRadio;

  }

  /**
   * �������Z�R���e�i���擾���܂��B
   * @return �������Z�R���e�i
   */
  protected ACLabelContainer getMedicalFacilityCognitiveHospitalStandardRadioContainer(){
    if(medicalFacilityCognitiveHospitalStandardRadioContainer==null){
      medicalFacilityCognitiveHospitalStandardRadioContainer = new ACLabelContainer();
      medicalFacilityCognitiveHospitalStandardRadioContainer.setFollowChildEnabled(true);
      medicalFacilityCognitiveHospitalStandardRadioContainer.setVAlignment(VRLayout.CENTER);
      medicalFacilityCognitiveHospitalStandardRadioContainer.add(getMedicalFacilityCognitiveHospitalStandardRadio(), null);
    }
    return medicalFacilityCognitiveHospitalStandardRadioContainer;
  }

  /**
   * �������Z���f�����擾���܂��B
   * @return �������Z���f��
   */
  protected ACListModelAdapter getMedicalFacilityCognitiveHospitalStandardRadioModel(){
    if(medicalFacilityCognitiveHospitalStandardRadioModel==null){
      medicalFacilityCognitiveHospitalStandardRadioModel = new ACListModelAdapter();
      addMedicalFacilityCognitiveHospitalStandardRadioModel();
    }
    return medicalFacilityCognitiveHospitalStandardRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getMedicalFacilityCognitiveHospitalStandardRadioItem1(){
    if(medicalFacilityCognitiveHospitalStandardRadioItem1==null){

      medicalFacilityCognitiveHospitalStandardRadioItem1 = new ACRadioButtonItem();

      medicalFacilityCognitiveHospitalStandardRadioItem1.setText("�Ȃ�");

      medicalFacilityCognitiveHospitalStandardRadioItem1.setGroup(getMedicalFacilityCognitiveHospitalStandardRadio());

      medicalFacilityCognitiveHospitalStandardRadioItem1.setConstraints(VRLayout.FLOW);

      addMedicalFacilityCognitiveHospitalStandardRadioItem1();
    }
    return medicalFacilityCognitiveHospitalStandardRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getMedicalFacilityCognitiveHospitalStandardRadioItem2(){
    if(medicalFacilityCognitiveHospitalStandardRadioItem2==null){

      medicalFacilityCognitiveHospitalStandardRadioItem2 = new ACRadioButtonItem();

      medicalFacilityCognitiveHospitalStandardRadioItem2.setText("����");

      medicalFacilityCognitiveHospitalStandardRadioItem2.setGroup(getMedicalFacilityCognitiveHospitalStandardRadio());

      medicalFacilityCognitiveHospitalStandardRadioItem2.setConstraints(VRLayout.FLOW);

      addMedicalFacilityCognitiveHospitalStandardRadioItem2();
    }
    return medicalFacilityCognitiveHospitalStandardRadioItem2;

  }

  /**
   * ���Ȏ�f���擾���܂��B
   * @return ���Ȏ�f
   */
  public ACValueArrayRadioButtonGroup getMedicalFacilityCognitiveHospitalMedicalExaminationRadio(){
    if(medicalFacilityCognitiveHospitalMedicalExaminationRadio==null){

      medicalFacilityCognitiveHospitalMedicalExaminationRadio = new ACValueArrayRadioButtonGroup();

      getMedicalFacilityCognitiveHospitalMedicalExaminationRadioContainer().setText("���Ȏ�f���Z");

      medicalFacilityCognitiveHospitalMedicalExaminationRadio.setBindPath("1530307");

      medicalFacilityCognitiveHospitalMedicalExaminationRadio.setUseClearButton(false);

      medicalFacilityCognitiveHospitalMedicalExaminationRadio.setModel(getMedicalFacilityCognitiveHospitalMedicalExaminationRadioModel());

      medicalFacilityCognitiveHospitalMedicalExaminationRadio.setValues(new int[]{1,2});

      addMedicalFacilityCognitiveHospitalMedicalExaminationRadio();
    }
    return medicalFacilityCognitiveHospitalMedicalExaminationRadio;

  }

  /**
   * ���Ȏ�f�R���e�i���擾���܂��B
   * @return ���Ȏ�f�R���e�i
   */
  protected ACLabelContainer getMedicalFacilityCognitiveHospitalMedicalExaminationRadioContainer(){
    if(medicalFacilityCognitiveHospitalMedicalExaminationRadioContainer==null){
      medicalFacilityCognitiveHospitalMedicalExaminationRadioContainer = new ACLabelContainer();
      medicalFacilityCognitiveHospitalMedicalExaminationRadioContainer.setFollowChildEnabled(true);
      medicalFacilityCognitiveHospitalMedicalExaminationRadioContainer.setVAlignment(VRLayout.CENTER);
      medicalFacilityCognitiveHospitalMedicalExaminationRadioContainer.add(getMedicalFacilityCognitiveHospitalMedicalExaminationRadio(), null);
    }
    return medicalFacilityCognitiveHospitalMedicalExaminationRadioContainer;
  }

  /**
   * ���Ȏ�f���f�����擾���܂��B
   * @return ���Ȏ�f���f��
   */
  protected ACListModelAdapter getMedicalFacilityCognitiveHospitalMedicalExaminationRadioModel(){
    if(medicalFacilityCognitiveHospitalMedicalExaminationRadioModel==null){
      medicalFacilityCognitiveHospitalMedicalExaminationRadioModel = new ACListModelAdapter();
      addMedicalFacilityCognitiveHospitalMedicalExaminationRadioModel();
    }
    return medicalFacilityCognitiveHospitalMedicalExaminationRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getMedicalFacilityCognitiveHospitalMedicalExaminationRadioItem1(){
    if(medicalFacilityCognitiveHospitalMedicalExaminationRadioItem1==null){

      medicalFacilityCognitiveHospitalMedicalExaminationRadioItem1 = new ACRadioButtonItem();

      medicalFacilityCognitiveHospitalMedicalExaminationRadioItem1.setText("�Ȃ�");

      medicalFacilityCognitiveHospitalMedicalExaminationRadioItem1.setGroup(getMedicalFacilityCognitiveHospitalMedicalExaminationRadio());

      medicalFacilityCognitiveHospitalMedicalExaminationRadioItem1.setConstraints(VRLayout.FLOW);

      addMedicalFacilityCognitiveHospitalMedicalExaminationRadioItem1();
    }
    return medicalFacilityCognitiveHospitalMedicalExaminationRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getMedicalFacilityCognitiveHospitalMedicalExaminationRadioItem2(){
    if(medicalFacilityCognitiveHospitalMedicalExaminationRadioItem2==null){

      medicalFacilityCognitiveHospitalMedicalExaminationRadioItem2 = new ACRadioButtonItem();

      medicalFacilityCognitiveHospitalMedicalExaminationRadioItem2.setText("����");

      medicalFacilityCognitiveHospitalMedicalExaminationRadioItem2.setGroup(getMedicalFacilityCognitiveHospitalMedicalExaminationRadio());

      medicalFacilityCognitiveHospitalMedicalExaminationRadioItem2.setConstraints(VRLayout.FLOW);

      addMedicalFacilityCognitiveHospitalMedicalExaminationRadioItem2();
    }
    return medicalFacilityCognitiveHospitalMedicalExaminationRadioItem2;

  }

  /**
   * �h�{�}�l�W�����g���Z���擾���܂��B
   * @return �h�{�}�l�W�����g���Z
   */
  public ACValueArrayRadioButtonGroup getMedicalFacilityCognitiveHospitalNutritionRadio(){
    if(medicalFacilityCognitiveHospitalNutritionRadio==null){

      medicalFacilityCognitiveHospitalNutritionRadio = new ACValueArrayRadioButtonGroup();

      getMedicalFacilityCognitiveHospitalNutritionRadioContainer().setText("�h�{�}�l�W�����g���Z");

      medicalFacilityCognitiveHospitalNutritionRadio.setBindPath("1530309");

      medicalFacilityCognitiveHospitalNutritionRadio.setUseClearButton(false);

      medicalFacilityCognitiveHospitalNutritionRadio.setModel(getMedicalFacilityCognitiveHospitalNutritionRadioModel());

      medicalFacilityCognitiveHospitalNutritionRadio.setValues(new int[]{1,2});

      addMedicalFacilityCognitiveHospitalNutritionRadio();
    }
    return medicalFacilityCognitiveHospitalNutritionRadio;

  }

  /**
   * �h�{�}�l�W�����g���Z�R���e�i���擾���܂��B
   * @return �h�{�}�l�W�����g���Z�R���e�i
   */
  protected ACLabelContainer getMedicalFacilityCognitiveHospitalNutritionRadioContainer(){
    if(medicalFacilityCognitiveHospitalNutritionRadioContainer==null){
      medicalFacilityCognitiveHospitalNutritionRadioContainer = new ACLabelContainer();
      medicalFacilityCognitiveHospitalNutritionRadioContainer.setFollowChildEnabled(true);
      medicalFacilityCognitiveHospitalNutritionRadioContainer.setVAlignment(VRLayout.CENTER);
      medicalFacilityCognitiveHospitalNutritionRadioContainer.add(getMedicalFacilityCognitiveHospitalNutritionRadio(), null);
    }
    return medicalFacilityCognitiveHospitalNutritionRadioContainer;
  }

  /**
   * �h�{�}�l�W�����g���Z���f�����擾���܂��B
   * @return �h�{�}�l�W�����g���Z���f��
   */
  protected ACListModelAdapter getMedicalFacilityCognitiveHospitalNutritionRadioModel(){
    if(medicalFacilityCognitiveHospitalNutritionRadioModel==null){
      medicalFacilityCognitiveHospitalNutritionRadioModel = new ACListModelAdapter();
      addMedicalFacilityCognitiveHospitalNutritionRadioModel();
    }
    return medicalFacilityCognitiveHospitalNutritionRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getMedicalFacilityCognitiveHospitalNutritionRadioItem1(){
    if(medicalFacilityCognitiveHospitalNutritionRadioItem1==null){

      medicalFacilityCognitiveHospitalNutritionRadioItem1 = new ACRadioButtonItem();

      medicalFacilityCognitiveHospitalNutritionRadioItem1.setText("�Ȃ�");

      medicalFacilityCognitiveHospitalNutritionRadioItem1.setGroup(getMedicalFacilityCognitiveHospitalNutritionRadio());

      medicalFacilityCognitiveHospitalNutritionRadioItem1.setConstraints(VRLayout.FLOW);

      addMedicalFacilityCognitiveHospitalNutritionRadioItem1();
    }
    return medicalFacilityCognitiveHospitalNutritionRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getMedicalFacilityCognitiveHospitalNutritionRadioItem2(){
    if(medicalFacilityCognitiveHospitalNutritionRadioItem2==null){

      medicalFacilityCognitiveHospitalNutritionRadioItem2 = new ACRadioButtonItem();

      medicalFacilityCognitiveHospitalNutritionRadioItem2.setText("����");

      medicalFacilityCognitiveHospitalNutritionRadioItem2.setGroup(getMedicalFacilityCognitiveHospitalNutritionRadio());

      medicalFacilityCognitiveHospitalNutritionRadioItem2.setConstraints(VRLayout.FLOW);

      addMedicalFacilityCognitiveHospitalNutritionRadioItem2();
    }
    return medicalFacilityCognitiveHospitalNutritionRadioItem2;

  }

  /**
   * �o���ڍs���Z���擾���܂��B
   * @return �o���ڍs���Z
   */
  public ACValueArrayRadioButtonGroup getMedicalFacilityCognitiveHospitalOralSwitchRadio(){
    if(medicalFacilityCognitiveHospitalOralSwitchRadio==null){

      medicalFacilityCognitiveHospitalOralSwitchRadio = new ACValueArrayRadioButtonGroup();

      getMedicalFacilityCognitiveHospitalOralSwitchRadioContainer().setText("�o���ڍs���Z");

      medicalFacilityCognitiveHospitalOralSwitchRadio.setBindPath("1530310");

      medicalFacilityCognitiveHospitalOralSwitchRadio.setUseClearButton(false);

      medicalFacilityCognitiveHospitalOralSwitchRadio.setModel(getMedicalFacilityCognitiveHospitalOralSwitchRadioModel());

      medicalFacilityCognitiveHospitalOralSwitchRadio.setValues(new int[]{1,2});

      addMedicalFacilityCognitiveHospitalOralSwitchRadio();
    }
    return medicalFacilityCognitiveHospitalOralSwitchRadio;

  }

  /**
   * �o���ڍs���Z�R���e�i���擾���܂��B
   * @return �o���ڍs���Z�R���e�i
   */
  protected ACLabelContainer getMedicalFacilityCognitiveHospitalOralSwitchRadioContainer(){
    if(medicalFacilityCognitiveHospitalOralSwitchRadioContainer==null){
      medicalFacilityCognitiveHospitalOralSwitchRadioContainer = new ACLabelContainer();
      medicalFacilityCognitiveHospitalOralSwitchRadioContainer.setFollowChildEnabled(true);
      medicalFacilityCognitiveHospitalOralSwitchRadioContainer.setVAlignment(VRLayout.CENTER);
      medicalFacilityCognitiveHospitalOralSwitchRadioContainer.add(getMedicalFacilityCognitiveHospitalOralSwitchRadio(), null);
    }
    return medicalFacilityCognitiveHospitalOralSwitchRadioContainer;
  }

  /**
   * �o���ڍs���Z���f�����擾���܂��B
   * @return �o���ڍs���Z���f��
   */
  protected ACListModelAdapter getMedicalFacilityCognitiveHospitalOralSwitchRadioModel(){
    if(medicalFacilityCognitiveHospitalOralSwitchRadioModel==null){
      medicalFacilityCognitiveHospitalOralSwitchRadioModel = new ACListModelAdapter();
      addMedicalFacilityCognitiveHospitalOralSwitchRadioModel();
    }
    return medicalFacilityCognitiveHospitalOralSwitchRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getMedicalFacilityCognitiveHospitalOralSwitchRadioItem1(){
    if(medicalFacilityCognitiveHospitalOralSwitchRadioItem1==null){

      medicalFacilityCognitiveHospitalOralSwitchRadioItem1 = new ACRadioButtonItem();

      medicalFacilityCognitiveHospitalOralSwitchRadioItem1.setText("�Ȃ�");

      medicalFacilityCognitiveHospitalOralSwitchRadioItem1.setGroup(getMedicalFacilityCognitiveHospitalOralSwitchRadio());

      medicalFacilityCognitiveHospitalOralSwitchRadioItem1.setConstraints(VRLayout.FLOW);

      addMedicalFacilityCognitiveHospitalOralSwitchRadioItem1();
    }
    return medicalFacilityCognitiveHospitalOralSwitchRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getMedicalFacilityCognitiveHospitalOralSwitchRadioItem2(){
    if(medicalFacilityCognitiveHospitalOralSwitchRadioItem2==null){

      medicalFacilityCognitiveHospitalOralSwitchRadioItem2 = new ACRadioButtonItem();

      medicalFacilityCognitiveHospitalOralSwitchRadioItem2.setText("����");

      medicalFacilityCognitiveHospitalOralSwitchRadioItem2.setGroup(getMedicalFacilityCognitiveHospitalOralSwitchRadio());

      medicalFacilityCognitiveHospitalOralSwitchRadioItem2.setConstraints(VRLayout.FLOW);

      addMedicalFacilityCognitiveHospitalOralSwitchRadioItem2();
    }
    return medicalFacilityCognitiveHospitalOralSwitchRadioItem2;

  }

  /**
   * �o���ێ����Z�R���e�i���擾���܂��B
   * @return �o���ێ����Z�R���e�i
   */
  public ACLabelContainer getOralMaintenanceAddContainer(){
    if(oralMaintenanceAddContainer==null){

      oralMaintenanceAddContainer = new ACLabelContainer();

      oralMaintenanceAddContainer.setText("�o���ێ����Z");

      oralMaintenanceAddContainer.setFollowChildEnabled(true);

      addOralMaintenanceAddContainer();
    }
    return oralMaintenanceAddContainer;

  }

  /**
   * �o���ێ����Z���擾���܂��B
   * @return �o���ێ����Z
   */
  public ACValueArrayRadioButtonGroup getOralMaintenanceAdd(){
    if(oralMaintenanceAdd==null){

      oralMaintenanceAdd = new ACValueArrayRadioButtonGroup();

      oralMaintenanceAdd.setBindPath("1530312");

      oralMaintenanceAdd.setUseClearButton(false);

      oralMaintenanceAdd.setModel(getOralMaintenanceAddModel());

      oralMaintenanceAdd.setValues(new int[]{1,2});

      addOralMaintenanceAdd();
    }
    return oralMaintenanceAdd;

  }

  /**
   * �o���ێ����Z���f�����擾���܂��B
   * @return �o���ێ����Z���f��
   */
  protected ACListModelAdapter getOralMaintenanceAddModel(){
    if(oralMaintenanceAddModel==null){
      oralMaintenanceAddModel = new ACListModelAdapter();
      addOralMaintenanceAddModel();
    }
    return oralMaintenanceAddModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getOralMaintenanceAddItem1(){
    if(oralMaintenanceAddItem1==null){

      oralMaintenanceAddItem1 = new ACRadioButtonItem();

      oralMaintenanceAddItem1.setText("�Ȃ�");

      oralMaintenanceAddItem1.setGroup(getOralMaintenanceAdd());

      oralMaintenanceAddItem1.setConstraints(VRLayout.FLOW);

      addOralMaintenanceAddItem1();
    }
    return oralMaintenanceAddItem1;

  }

  /**
   * I�^���擾���܂��B
   * @return I�^
   */
  public ACRadioButtonItem getOralMaintenanceAddItem2(){
    if(oralMaintenanceAddItem2==null){

      oralMaintenanceAddItem2 = new ACRadioButtonItem();

      oralMaintenanceAddItem2.setText("I�^");

      oralMaintenanceAddItem2.setGroup(getOralMaintenanceAdd());

      oralMaintenanceAddItem2.setConstraints(VRLayout.FLOW);

      addOralMaintenanceAddItem2();
    }
    return oralMaintenanceAddItem2;

  }

  /**
   * II�^���擾���܂��B
   * @return II�^
   */
  public ACIntegerCheckBox getOralMaintenanceAddItem3(){
    if(oralMaintenanceAddItem3==null){

      oralMaintenanceAddItem3 = new ACIntegerCheckBox();

      oralMaintenanceAddItem3.setText("II�^");

      oralMaintenanceAddItem3.setBindPath("1530317");

      oralMaintenanceAddItem3.setSelectValue(2);

      oralMaintenanceAddItem3.setUnSelectValue(1);

      addOralMaintenanceAddItem3();
    }
    return oralMaintenanceAddItem3;

  }

  /**
   * ���o�q���Ǘ��̐����Z���擾���܂��B
   * @return ���o�q���Ǘ��̐����Z
   */
  public ACValueArrayRadioButtonGroup getOralKeepStructureAddRadioGroup(){
    if(oralKeepStructureAddRadioGroup==null){

      oralKeepStructureAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getOralKeepStructureAddRadioGroupContainer().setText("���o�q���Ǘ��̐����Z");

      oralKeepStructureAddRadioGroup.setBindPath("1530361");

      oralKeepStructureAddRadioGroup.setNoSelectIndex(0);

      oralKeepStructureAddRadioGroup.setUseClearButton(false);

      oralKeepStructureAddRadioGroup.setModel(getOralKeepStructureAddRadioGroupModel());

      oralKeepStructureAddRadioGroup.setValues(new int[]{1,2});

      addOralKeepStructureAddRadioGroup();
    }
    return oralKeepStructureAddRadioGroup;

  }

  /**
   * ���o�q���Ǘ��̐����Z�R���e�i���擾���܂��B
   * @return ���o�q���Ǘ��̐����Z�R���e�i
   */
  protected ACLabelContainer getOralKeepStructureAddRadioGroupContainer(){
    if(oralKeepStructureAddRadioGroupContainer==null){
      oralKeepStructureAddRadioGroupContainer = new ACLabelContainer();
      oralKeepStructureAddRadioGroupContainer.setFollowChildEnabled(true);
      oralKeepStructureAddRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      oralKeepStructureAddRadioGroupContainer.add(getOralKeepStructureAddRadioGroup(), null);
    }
    return oralKeepStructureAddRadioGroupContainer;
  }

  /**
   * ���o�q���Ǘ��̐����Z���f�����擾���܂��B
   * @return ���o�q���Ǘ��̐����Z���f��
   */
  protected ACListModelAdapter getOralKeepStructureAddRadioGroupModel(){
    if(oralKeepStructureAddRadioGroupModel==null){
      oralKeepStructureAddRadioGroupModel = new ACListModelAdapter();
      addOralKeepStructureAddRadioGroupModel();
    }
    return oralKeepStructureAddRadioGroupModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getOralKeepStructureAddRadioItem1(){
    if(oralKeepStructureAddRadioItem1==null){

      oralKeepStructureAddRadioItem1 = new ACRadioButtonItem();

      oralKeepStructureAddRadioItem1.setText("�Ȃ�");

      oralKeepStructureAddRadioItem1.setGroup(getOralKeepStructureAddRadioGroup());

      oralKeepStructureAddRadioItem1.setConstraints(VRLayout.FLOW);

      addOralKeepStructureAddRadioItem1();
    }
    return oralKeepStructureAddRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getOralKeepStructureAddRadioItem2(){
    if(oralKeepStructureAddRadioItem2==null){

      oralKeepStructureAddRadioItem2 = new ACRadioButtonItem();

      oralKeepStructureAddRadioItem2.setText("����");

      oralKeepStructureAddRadioItem2.setGroup(getOralKeepStructureAddRadioGroup());

      oralKeepStructureAddRadioItem2.setConstraints(VRLayout.FLOW);

      addOralKeepStructureAddRadioItem2();
    }
    return oralKeepStructureAddRadioItem2;

  }

  /**
   * ���o�q���Ǘ����Z���擾���܂��B
   * @return ���o�q���Ǘ����Z
   */
  public ACValueArrayRadioButtonGroup getYoungDementiaPatinetAddRadioGroup(){
    if(youngDementiaPatinetAddRadioGroup==null){

      youngDementiaPatinetAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getYoungDementiaPatinetAddRadioGroupContainer().setText("���o�q���Ǘ����Z");

      youngDementiaPatinetAddRadioGroup.setBindPath("1530359");

      youngDementiaPatinetAddRadioGroup.setNoSelectIndex(0);

      youngDementiaPatinetAddRadioGroup.setUseClearButton(false);

      youngDementiaPatinetAddRadioGroup.setModel(getYoungDementiaPatinetAddRadioGroupModel());

      youngDementiaPatinetAddRadioGroup.setValues(new int[]{1,2});

      addYoungDementiaPatinetAddRadioGroup();
    }
    return youngDementiaPatinetAddRadioGroup;

  }

  /**
   * ���o�q���Ǘ����Z�R���e�i���擾���܂��B
   * @return ���o�q���Ǘ����Z�R���e�i
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
   * ���o�q���Ǘ����Z���f�����擾���܂��B
   * @return ���o�q���Ǘ����Z���f��
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
   * �×{�H���Z���擾���܂��B
   * @return �×{�H���Z
   */
  public ACValueArrayRadioButtonGroup getMedicalFacilityCognitiveHospitalRecuperateDinnerRadio(){
    if(medicalFacilityCognitiveHospitalRecuperateDinnerRadio==null){

      medicalFacilityCognitiveHospitalRecuperateDinnerRadio = new ACValueArrayRadioButtonGroup();

      getMedicalFacilityCognitiveHospitalRecuperateDinnerRadioContainer().setText("�×{�H���Z");

      medicalFacilityCognitiveHospitalRecuperateDinnerRadio.setBindPath("1530311");

      medicalFacilityCognitiveHospitalRecuperateDinnerRadio.setUseClearButton(false);

      medicalFacilityCognitiveHospitalRecuperateDinnerRadio.setModel(getMedicalFacilityCognitiveHospitalRecuperateDinnerRadioModel());

      medicalFacilityCognitiveHospitalRecuperateDinnerRadio.setValues(new int[]{1,2,3,4});

      addMedicalFacilityCognitiveHospitalRecuperateDinnerRadio();
    }
    return medicalFacilityCognitiveHospitalRecuperateDinnerRadio;

  }

  /**
   * �×{�H���Z�R���e�i���擾���܂��B
   * @return �×{�H���Z�R���e�i
   */
  protected ACLabelContainer getMedicalFacilityCognitiveHospitalRecuperateDinnerRadioContainer(){
    if(medicalFacilityCognitiveHospitalRecuperateDinnerRadioContainer==null){
      medicalFacilityCognitiveHospitalRecuperateDinnerRadioContainer = new ACLabelContainer();
      medicalFacilityCognitiveHospitalRecuperateDinnerRadioContainer.setFollowChildEnabled(true);
      medicalFacilityCognitiveHospitalRecuperateDinnerRadioContainer.setVAlignment(VRLayout.CENTER);
      medicalFacilityCognitiveHospitalRecuperateDinnerRadioContainer.add(getMedicalFacilityCognitiveHospitalRecuperateDinnerRadio(), null);
    }
    return medicalFacilityCognitiveHospitalRecuperateDinnerRadioContainer;
  }

  /**
   * �×{�H���Z���f�����擾���܂��B
   * @return �×{�H���Z���f��
   */
  protected ACListModelAdapter getMedicalFacilityCognitiveHospitalRecuperateDinnerRadioModel(){
    if(medicalFacilityCognitiveHospitalRecuperateDinnerRadioModel==null){
      medicalFacilityCognitiveHospitalRecuperateDinnerRadioModel = new ACListModelAdapter();
      addMedicalFacilityCognitiveHospitalRecuperateDinnerRadioModel();
    }
    return medicalFacilityCognitiveHospitalRecuperateDinnerRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getMedicalFacilityCognitiveHospitalRecuperateDinnerRadioItem1(){
    if(medicalFacilityCognitiveHospitalRecuperateDinnerRadioItem1==null){

      medicalFacilityCognitiveHospitalRecuperateDinnerRadioItem1 = new ACRadioButtonItem();

      medicalFacilityCognitiveHospitalRecuperateDinnerRadioItem1.setText("�Ȃ�");

      medicalFacilityCognitiveHospitalRecuperateDinnerRadioItem1.setGroup(getMedicalFacilityCognitiveHospitalRecuperateDinnerRadio());

      medicalFacilityCognitiveHospitalRecuperateDinnerRadioItem1.setConstraints(VRLayout.FLOW);

      addMedicalFacilityCognitiveHospitalRecuperateDinnerRadioItem1();
    }
    return medicalFacilityCognitiveHospitalRecuperateDinnerRadioItem1;

  }

  /**
   * 3����擾���܂��B
   * @return 3��
   */
  public ACRadioButtonItem getMedicalFacilityCognitiveHospitalRecuperateDinnerRadioItem2(){
    if(medicalFacilityCognitiveHospitalRecuperateDinnerRadioItem2==null){

      medicalFacilityCognitiveHospitalRecuperateDinnerRadioItem2 = new ACRadioButtonItem();

      medicalFacilityCognitiveHospitalRecuperateDinnerRadioItem2.setText("3��");

      medicalFacilityCognitiveHospitalRecuperateDinnerRadioItem2.setGroup(getMedicalFacilityCognitiveHospitalRecuperateDinnerRadio());

      medicalFacilityCognitiveHospitalRecuperateDinnerRadioItem2.setConstraints(VRLayout.FLOW);

      addMedicalFacilityCognitiveHospitalRecuperateDinnerRadioItem2();
    }
    return medicalFacilityCognitiveHospitalRecuperateDinnerRadioItem2;

  }

  /**
   * 2����擾���܂��B
   * @return 2��
   */
  public ACRadioButtonItem getMedicalFacilityCognitiveHospitalRecuperateDinnerRadioItem3(){
    if(medicalFacilityCognitiveHospitalRecuperateDinnerRadioItem3==null){

      medicalFacilityCognitiveHospitalRecuperateDinnerRadioItem3 = new ACRadioButtonItem();

      medicalFacilityCognitiveHospitalRecuperateDinnerRadioItem3.setText("2��");

      medicalFacilityCognitiveHospitalRecuperateDinnerRadioItem3.setGroup(getMedicalFacilityCognitiveHospitalRecuperateDinnerRadio());

      medicalFacilityCognitiveHospitalRecuperateDinnerRadioItem3.setConstraints(VRLayout.FLOW);

      addMedicalFacilityCognitiveHospitalRecuperateDinnerRadioItem3();
    }
    return medicalFacilityCognitiveHospitalRecuperateDinnerRadioItem3;

  }

  /**
   * 1����擾���܂��B
   * @return 1��
   */
  public ACRadioButtonItem getMedicalFacilityCognitiveHospitalRecuperateDinnerRadioItem4(){
    if(medicalFacilityCognitiveHospitalRecuperateDinnerRadioItem4==null){

      medicalFacilityCognitiveHospitalRecuperateDinnerRadioItem4 = new ACRadioButtonItem();

      medicalFacilityCognitiveHospitalRecuperateDinnerRadioItem4.setText("1��");

      medicalFacilityCognitiveHospitalRecuperateDinnerRadioItem4.setGroup(getMedicalFacilityCognitiveHospitalRecuperateDinnerRadio());

      medicalFacilityCognitiveHospitalRecuperateDinnerRadioItem4.setConstraints(VRLayout.FLOW);

      addMedicalFacilityCognitiveHospitalRecuperateDinnerRadioItem4();
    }
    return medicalFacilityCognitiveHospitalRecuperateDinnerRadioItem4;

  }

  /**
   * �^�u3���擾���܂��B
   * @return �^�u3
   */
  public ACPanel getTab3(){
    if(tab3==null){

      tab3 = new ACPanel();

      tab3.setFollowChildEnabled(true);

      tab3.setHgap(0);

      addTab3();
    }
    return tab3;

  }

  /**
   * �ޏ��֘A���Z���擾���܂��B
   * @return �ޏ��֘A���Z
   */
  public ACLabelContainer getMedicalFacilityCognitiveHospitalHijoAddition(){
    if(medicalFacilityCognitiveHospitalHijoAddition==null){

      medicalFacilityCognitiveHospitalHijoAddition = new ACLabelContainer();

      medicalFacilityCognitiveHospitalHijoAddition.setText("�މ@�֘A���Z");

      medicalFacilityCognitiveHospitalHijoAddition.setFollowChildEnabled(true);

      addMedicalFacilityCognitiveHospitalHijoAddition();
    }
    return medicalFacilityCognitiveHospitalHijoAddition;

  }

  /**
   * �ޏ�(�@)�O�K��w�����Z���擾���܂��B
   * @return �ޏ�(�@)�O�K��w�����Z
   */
  public ACIntegerCheckBox getLeavingHospitalPreConsultationAddition(){
    if(leavingHospitalPreConsultationAddition==null){

      leavingHospitalPreConsultationAddition = new ACIntegerCheckBox();

      leavingHospitalPreConsultationAddition.setText("�މ@�O�K��w�����Z");

      leavingHospitalPreConsultationAddition.setBindPath("3020109");

      leavingHospitalPreConsultationAddition.setSelectValue(2);

      leavingHospitalPreConsultationAddition.setUnSelectValue(1);

      addLeavingHospitalPreConsultationAddition();
    }
    return leavingHospitalPreConsultationAddition;

  }

  /**
   * �ޏ�(�@)��K��w�����Z���擾���܂��B
   * @return �ޏ�(�@)��K��w�����Z
   */
  public ACIntegerCheckBox getLeavingHospitalAfterConsultationAddition(){
    if(leavingHospitalAfterConsultationAddition==null){

      leavingHospitalAfterConsultationAddition = new ACIntegerCheckBox();

      leavingHospitalAfterConsultationAddition.setText("�މ@��K��w�����Z");

      leavingHospitalAfterConsultationAddition.setBindPath("3020110");

      leavingHospitalAfterConsultationAddition.setSelectValue(2);

      leavingHospitalAfterConsultationAddition.setUnSelectValue(1);

      addLeavingHospitalAfterConsultationAddition();
    }
    return leavingHospitalAfterConsultationAddition;

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
   * �K��Ō�w�����Z���擾���܂��B
   * @return �K��Ō�w�����Z
   */
  public ACIntegerCheckBox getLeavingHospital(){
    if(leavingHospital==null){

      leavingHospital = new ACIntegerCheckBox();

      leavingHospital.setText("�K��Ō�w�����Z");

      leavingHospital.setBindPath("3020108");

      leavingHospital.setSelectValue(2);

      leavingHospital.setUnSelectValue(1);

      addLeavingHospital();
    }
    return leavingHospital;

  }

  /**
   * ����f�Ô���擾���܂��B
   * @return ����f�Ô�
   */
  public ACMapBindButton getMedicalFacilityCognitiveHospitalConsultationFee(){
    if(medicalFacilityCognitiveHospitalConsultationFee==null){

      medicalFacilityCognitiveHospitalConsultationFee = new ACMapBindButton();

      medicalFacilityCognitiveHospitalConsultationFee.setText("����f�Ô�");

      medicalFacilityCognitiveHospitalConsultationFee.setToolTipText("����f�Ô��ݒ肵�܂��B");

      addMedicalFacilityCognitiveHospitalConsultationFee();
    }
    return medicalFacilityCognitiveHospitalConsultationFee;

  }

  /**
   * ���x�����擾���܂��B
   * @return ���x��
   */
  public ACLabel getMedicalFacilityCognitiveHospitalConsultationFeeLabel(){
    if(medicalFacilityCognitiveHospitalConsultationFeeLabel==null){

      medicalFacilityCognitiveHospitalConsultationFeeLabel = new ACLabel();

      medicalFacilityCognitiveHospitalConsultationFeeLabel.setText("�ݒ�Ȃ�");

      medicalFacilityCognitiveHospitalConsultationFeeLabel.setOpaque(true);
      medicalFacilityCognitiveHospitalConsultationFeeLabel.setBackground(new Color(255,255,172));

      addMedicalFacilityCognitiveHospitalConsultationFeeLabel();
    }
    return medicalFacilityCognitiveHospitalConsultationFeeLabel;

  }

  /**
   * �l�����Z���擾���܂��B
   * @return �l�����Z
   */
  public ACComboBox getMedicalFacilityCognitiveHospitalSubstraction(){
    if(medicalFacilityCognitiveHospitalSubstraction==null){

      medicalFacilityCognitiveHospitalSubstraction = new ACComboBox();

      getMedicalFacilityCognitiveHospitalSubstractionContainer().setText("�l�����Z");

      medicalFacilityCognitiveHospitalSubstraction.setBindPath("1530355");

      medicalFacilityCognitiveHospitalSubstraction.setEditable(false);

      medicalFacilityCognitiveHospitalSubstraction.setModelBindPath("1530355");

      medicalFacilityCognitiveHospitalSubstraction.setRenderBindPath("CONTENT");

      medicalFacilityCognitiveHospitalSubstraction.setModel(getMedicalFacilityCognitiveHospitalSubstractionModel());

      addMedicalFacilityCognitiveHospitalSubstraction();
    }
    return medicalFacilityCognitiveHospitalSubstraction;

  }

  /**
   * �l�����Z�R���e�i���擾���܂��B
   * @return �l�����Z�R���e�i
   */
  protected ACLabelContainer getMedicalFacilityCognitiveHospitalSubstractionContainer(){
    if(medicalFacilityCognitiveHospitalSubstractionContainer==null){
      medicalFacilityCognitiveHospitalSubstractionContainer = new ACLabelContainer();
      medicalFacilityCognitiveHospitalSubstractionContainer.setFollowChildEnabled(true);
      medicalFacilityCognitiveHospitalSubstractionContainer.setVAlignment(VRLayout.CENTER);
      medicalFacilityCognitiveHospitalSubstractionContainer.add(getMedicalFacilityCognitiveHospitalSubstraction(), null);
    }
    return medicalFacilityCognitiveHospitalSubstractionContainer;
  }

  /**
   * �l�����Z���f�����擾���܂��B
   * @return �l�����Z���f��
   */
  protected ACComboBoxModelAdapter getMedicalFacilityCognitiveHospitalSubstractionModel(){
    if(medicalFacilityCognitiveHospitalSubstractionModel==null){
      medicalFacilityCognitiveHospitalSubstractionModel = new ACComboBoxModelAdapter();
      addMedicalFacilityCognitiveHospitalSubstractionModel();
    }
    return medicalFacilityCognitiveHospitalSubstractionModel;
  }

  /**
   * �H���R���e�i���擾���܂��B
   * @return �H���R���e�i
   */
  public ACBackLabelContainer getMedicalFacilityCognitiveHospitalDinnerContainer(){
    if(medicalFacilityCognitiveHospitalDinnerContainer==null){

      medicalFacilityCognitiveHospitalDinnerContainer = new ACBackLabelContainer();

      medicalFacilityCognitiveHospitalDinnerContainer.setFollowChildEnabled(true);

      addMedicalFacilityCognitiveHospitalDinnerContainer();
    }
    return medicalFacilityCognitiveHospitalDinnerContainer;

  }

  /**
   * �H���񋟂��擾���܂��B
   * @return �H����
   */
  public ACComboBox getMedicalFacilityCognitiveHospitalDinnerOffer(){
    if(medicalFacilityCognitiveHospitalDinnerOffer==null){

      medicalFacilityCognitiveHospitalDinnerOffer = new ACComboBox();

      getMedicalFacilityCognitiveHospitalDinnerOfferContainer().setText("�H����");

      medicalFacilityCognitiveHospitalDinnerOffer.setBindPath("1530356");

      medicalFacilityCognitiveHospitalDinnerOffer.setEditable(false);

      medicalFacilityCognitiveHospitalDinnerOffer.setModelBindPath("1530356");

      medicalFacilityCognitiveHospitalDinnerOffer.setRenderBindPath("CONTENT");

      medicalFacilityCognitiveHospitalDinnerOffer.setModel(getMedicalFacilityCognitiveHospitalDinnerOfferModel());

      addMedicalFacilityCognitiveHospitalDinnerOffer();
    }
    return medicalFacilityCognitiveHospitalDinnerOffer;

  }

  /**
   * �H���񋟃R���e�i���擾���܂��B
   * @return �H���񋟃R���e�i
   */
  protected ACLabelContainer getMedicalFacilityCognitiveHospitalDinnerOfferContainer(){
    if(medicalFacilityCognitiveHospitalDinnerOfferContainer==null){
      medicalFacilityCognitiveHospitalDinnerOfferContainer = new ACLabelContainer();
      medicalFacilityCognitiveHospitalDinnerOfferContainer.setFollowChildEnabled(true);
      medicalFacilityCognitiveHospitalDinnerOfferContainer.setVAlignment(VRLayout.CENTER);
      medicalFacilityCognitiveHospitalDinnerOfferContainer.add(getMedicalFacilityCognitiveHospitalDinnerOffer(), null);
    }
    return medicalFacilityCognitiveHospitalDinnerOfferContainer;
  }

  /**
   * �H���񋟃��f�����擾���܂��B
   * @return �H���񋟃��f��
   */
  protected ACComboBoxModelAdapter getMedicalFacilityCognitiveHospitalDinnerOfferModel(){
    if(medicalFacilityCognitiveHospitalDinnerOfferModel==null){
      medicalFacilityCognitiveHospitalDinnerOfferModel = new ACComboBoxModelAdapter();
      addMedicalFacilityCognitiveHospitalDinnerOfferModel();
    }
    return medicalFacilityCognitiveHospitalDinnerOfferModel;
  }

  /**
   * �H����p���擾���܂��B
   * @return �H����p
   */
  public ACTextField getMedicalFacilityCognitiveHospitalDinnerCost(){
    if(medicalFacilityCognitiveHospitalDinnerCost==null){

      medicalFacilityCognitiveHospitalDinnerCost = new ACTextField();

      getMedicalFacilityCognitiveHospitalDinnerCostContainer().setText("�H����p");

      medicalFacilityCognitiveHospitalDinnerCost.setBindPath("1530358");

      medicalFacilityCognitiveHospitalDinnerCost.setColumns(4);

      medicalFacilityCognitiveHospitalDinnerCost.setCharType(VRCharType.ONLY_DIGIT);

      medicalFacilityCognitiveHospitalDinnerCost.setHorizontalAlignment(SwingConstants.RIGHT);

      medicalFacilityCognitiveHospitalDinnerCost.setIMEMode(InputSubset.LATIN);

      medicalFacilityCognitiveHospitalDinnerCost.setMaxLength(5);

      addMedicalFacilityCognitiveHospitalDinnerCost();
    }
    return medicalFacilityCognitiveHospitalDinnerCost;

  }

  /**
   * �H����p�R���e�i���擾���܂��B
   * @return �H����p�R���e�i
   */
  protected ACLabelContainer getMedicalFacilityCognitiveHospitalDinnerCostContainer(){
    if(medicalFacilityCognitiveHospitalDinnerCostContainer==null){
      medicalFacilityCognitiveHospitalDinnerCostContainer = new ACLabelContainer();
      medicalFacilityCognitiveHospitalDinnerCostContainer.setFollowChildEnabled(true);
      medicalFacilityCognitiveHospitalDinnerCostContainer.setVAlignment(VRLayout.CENTER);
      medicalFacilityCognitiveHospitalDinnerCostContainer.add(getMedicalFacilityCognitiveHospitalDinnerCost(), null);
    }
    return medicalFacilityCognitiveHospitalDinnerCostContainer;
  }

  /**
   * �^�u4���擾���܂��B
   * @return �^�u4
   */
  public ACPanel getTab4(){
    if(tab4==null){

      tab4 = new ACPanel();

      tab4.setFollowChildEnabled(true);

      tab4.setHgap(0);

      addTab4();
    }
    return tab4;

  }

  /**
   * �g�̍S���p�~�����{���Z���擾���܂��B
   * @return �g�̍S���p�~�����{���Z
   */
  public ACValueArrayRadioButtonGroup getBodyRestraintAbolitionRadio(){
    if(bodyRestraintAbolitionRadio==null){

      bodyRestraintAbolitionRadio = new ACValueArrayRadioButtonGroup();

      getBodyRestraintAbolitionRadioContainer().setText("�g�̍S���p�~�����{���Z");

      bodyRestraintAbolitionRadio.setBindPath("1530314");

      bodyRestraintAbolitionRadio.setUseClearButton(false);

      bodyRestraintAbolitionRadio.setModel(getBodyRestraintAbolitionRadioModel());

      bodyRestraintAbolitionRadio.setValues(new int[]{1,2});

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
  public ACValueArrayRadioButtonGroup getStayReturnSupportAddRadio(){
    if(stayReturnSupportAddRadio==null){

      stayReturnSupportAddRadio = new ACValueArrayRadioButtonGroup();

      getStayReturnSupportAddRadioContainer().setText("�ݑ�A�x���@�\���Z");

      stayReturnSupportAddRadio.setBindPath("1530315");

      stayReturnSupportAddRadio.setUseClearButton(false);

      stayReturnSupportAddRadio.setModel(getStayReturnSupportAddRadioModel());

      stayReturnSupportAddRadio.setValues(new int[]{1,2});

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
  public ACRadioButtonItem getStayReturnSupportAddRadioitem1(){
    if(stayReturnSupportAddRadioitem1==null){

      stayReturnSupportAddRadioitem1 = new ACRadioButtonItem();

      stayReturnSupportAddRadioitem1.setText("�Ȃ�");

      stayReturnSupportAddRadioitem1.setGroup(getStayReturnSupportAddRadio());

      stayReturnSupportAddRadioitem1.setConstraints(VRLayout.FLOW);

      addStayReturnSupportAddRadioitem1();
    }
    return stayReturnSupportAddRadioitem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getStayReturnSupportAddRadioitem2(){
    if(stayReturnSupportAddRadioitem2==null){

      stayReturnSupportAddRadioitem2 = new ACRadioButtonItem();

      stayReturnSupportAddRadioitem2.setText("����");

      stayReturnSupportAddRadioitem2.setGroup(getStayReturnSupportAddRadio());

      stayReturnSupportAddRadioitem2.setConstraints(VRLayout.FLOW);

      addStayReturnSupportAddRadioitem2();
    }
    return stayReturnSupportAddRadioitem2;

  }

  /**
   * �T�[�r�X�񋟑̐��������Z���擾���܂��B
   * @return �T�[�r�X�񋟑̐��������Z
   */
  public ACValueArrayRadioButtonGroup getServiceAddProvisionStructuralRadioGroup(){
    if(serviceAddProvisionStructuralRadioGroup==null){

      serviceAddProvisionStructuralRadioGroup = new ACValueArrayRadioButtonGroup();

      getServiceAddProvisionStructuralRadioGroupContainer().setText("�T�[�r�X�񋟑̐��������Z");

      serviceAddProvisionStructuralRadioGroup.setBindPath("1530360");

      serviceAddProvisionStructuralRadioGroup.setVisible(true);

      serviceAddProvisionStructuralRadioGroup.setEnabled(true);

      serviceAddProvisionStructuralRadioGroup.setNoSelectIndex(0);

      serviceAddProvisionStructuralRadioGroup.setUseClearButton(false);

      serviceAddProvisionStructuralRadioGroup.setModel(getServiceAddProvisionStructuralRadioGroupModel());

      serviceAddProvisionStructuralRadioGroup.setValues(new int[]{1,5,2,3,4});

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
   * I�C�^���擾���܂��B
   * @return I�C�^
   */
  public ACRadioButtonItem getServiceAddProvisionStructuralRadioItem5(){
    if(serviceAddProvisionStructuralRadioItem5==null){

      serviceAddProvisionStructuralRadioItem5 = new ACRadioButtonItem();

      serviceAddProvisionStructuralRadioItem5.setText("I�C�^");

      serviceAddProvisionStructuralRadioItem5.setGroup(getServiceAddProvisionStructuralRadioGroup());

      serviceAddProvisionStructuralRadioItem5.setConstraints(VRLayout.FLOW_RETURN);

      addServiceAddProvisionStructuralRadioItem5();
    }
    return serviceAddProvisionStructuralRadioItem5;

  }

  /**
   * I���^���擾���܂��B
   * @return I���^
   */
  public ACRadioButtonItem getServiceAddProvisionStructuralRadioItem2(){
    if(serviceAddProvisionStructuralRadioItem2==null){

      serviceAddProvisionStructuralRadioItem2 = new ACRadioButtonItem();

      serviceAddProvisionStructuralRadioItem2.setText("I���^");

      serviceAddProvisionStructuralRadioItem2.setGroup(getServiceAddProvisionStructuralRadioGroup());

      serviceAddProvisionStructuralRadioItem2.setConstraints(VRLayout.FLOW);

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
   * ��h�{���X�N���P���Z���擾���܂��B
   * @return ��h�{���X�N���P���Z
   */
  public ACValueArrayRadioButtonGroup getLowNutritionalRiskImprovementAdd(){
    if(lowNutritionalRiskImprovementAdd==null){

      lowNutritionalRiskImprovementAdd = new ACValueArrayRadioButtonGroup();

      getLowNutritionalRiskImprovementAddContainer().setText("��h�{���X�N���P���Z");

      lowNutritionalRiskImprovementAdd.setBindPath("1530363");

      lowNutritionalRiskImprovementAdd.setUseClearButton(false);

      lowNutritionalRiskImprovementAdd.setModel(getLowNutritionalRiskImprovementAddModel());

      lowNutritionalRiskImprovementAdd.setValues(new int[]{1,2});

      addLowNutritionalRiskImprovementAdd();
    }
    return lowNutritionalRiskImprovementAdd;

  }

  /**
   * ��h�{���X�N���P���Z�R���e�i���擾���܂��B
   * @return ��h�{���X�N���P���Z�R���e�i
   */
  protected ACLabelContainer getLowNutritionalRiskImprovementAddContainer(){
    if(lowNutritionalRiskImprovementAddContainer==null){
      lowNutritionalRiskImprovementAddContainer = new ACLabelContainer();
      lowNutritionalRiskImprovementAddContainer.setFollowChildEnabled(true);
      lowNutritionalRiskImprovementAddContainer.setVAlignment(VRLayout.CENTER);
      lowNutritionalRiskImprovementAddContainer.add(getLowNutritionalRiskImprovementAdd(), null);
    }
    return lowNutritionalRiskImprovementAddContainer;
  }

  /**
   * ��h�{���X�N���P���Z���f�����擾���܂��B
   * @return ��h�{���X�N���P���Z���f��
   */
  protected ACListModelAdapter getLowNutritionalRiskImprovementAddModel(){
    if(lowNutritionalRiskImprovementAddModel==null){
      lowNutritionalRiskImprovementAddModel = new ACListModelAdapter();
      addLowNutritionalRiskImprovementAddModel();
    }
    return lowNutritionalRiskImprovementAddModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getLowNutritionalRiskImprovementAddItem1(){
    if(lowNutritionalRiskImprovementAddItem1==null){

      lowNutritionalRiskImprovementAddItem1 = new ACRadioButtonItem();

      lowNutritionalRiskImprovementAddItem1.setText("�Ȃ�");

      lowNutritionalRiskImprovementAddItem1.setGroup(getLowNutritionalRiskImprovementAdd());

      lowNutritionalRiskImprovementAddItem1.setConstraints(VRLayout.FLOW);

      addLowNutritionalRiskImprovementAddItem1();
    }
    return lowNutritionalRiskImprovementAddItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getLowNutritionalRiskImprovementAddItem2(){
    if(lowNutritionalRiskImprovementAddItem2==null){

      lowNutritionalRiskImprovementAddItem2 = new ACRadioButtonItem();

      lowNutritionalRiskImprovementAddItem2.setText("����");

      lowNutritionalRiskImprovementAddItem2.setGroup(getLowNutritionalRiskImprovementAdd());

      lowNutritionalRiskImprovementAddItem2.setConstraints(VRLayout.FLOW);

      addLowNutritionalRiskImprovementAddItem2();
    }
    return lowNutritionalRiskImprovementAddItem2;

  }

  /**
   * �r���x�����Z���擾���܂��B
   * @return �r���x�����Z
   */
  public ACValueArrayRadioButtonGroup getExcretionSupport(){
    if(excretionSupport==null){

      excretionSupport = new ACValueArrayRadioButtonGroup();

      getExcretionSupportContainer().setText("�r���x�����Z");

      excretionSupport.setBindPath("1530364");

      excretionSupport.setUseClearButton(false);

      excretionSupport.setModel(getExcretionSupportModel());

      excretionSupport.setValues(new int[]{1,2});

      addExcretionSupport();
    }
    return excretionSupport;

  }

  /**
   * �r���x�����Z�R���e�i���擾���܂��B
   * @return �r���x�����Z�R���e�i
   */
  protected ACLabelContainer getExcretionSupportContainer(){
    if(excretionSupportContainer==null){
      excretionSupportContainer = new ACLabelContainer();
      excretionSupportContainer.setFollowChildEnabled(true);
      excretionSupportContainer.setVAlignment(VRLayout.CENTER);
      excretionSupportContainer.add(getExcretionSupport(), null);
    }
    return excretionSupportContainer;
  }

  /**
   * �r���x�����Z���f�����擾���܂��B
   * @return �r���x�����Z���f��
   */
  protected ACListModelAdapter getExcretionSupportModel(){
    if(excretionSupportModel==null){
      excretionSupportModel = new ACListModelAdapter();
      addExcretionSupportModel();
    }
    return excretionSupportModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getExcretionSupportItem1(){
    if(excretionSupportItem1==null){

      excretionSupportItem1 = new ACRadioButtonItem();

      excretionSupportItem1.setText("�Ȃ�");

      excretionSupportItem1.setGroup(getExcretionSupport());

      excretionSupportItem1.setConstraints(VRLayout.FLOW);

      addExcretionSupportItem1();
    }
    return excretionSupportItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getExcretionSupportItem2(){
    if(excretionSupportItem2==null){

      excretionSupportItem2 = new ACRadioButtonItem();

      excretionSupportItem2.setText("����");

      excretionSupportItem2.setGroup(getExcretionSupport());

      excretionSupportItem2.setConstraints(VRLayout.FLOW);

      addExcretionSupportItem2();
    }
    return excretionSupportItem2;

  }

  /**
   * �Z��敪���擾���܂��B
   * @return �Z��敪
   */
  public ACValueArrayRadioButtonGroup getMedicalFacilityCognitiveHospitalCalculationDivisionRadio(){
    if(medicalFacilityCognitiveHospitalCalculationDivisionRadio==null){

      medicalFacilityCognitiveHospitalCalculationDivisionRadio = new ACValueArrayRadioButtonGroup();

      getMedicalFacilityCognitiveHospitalCalculationDivisionRadioContainer().setText("�Z��敪");

      medicalFacilityCognitiveHospitalCalculationDivisionRadio.setBindPath("9");

      medicalFacilityCognitiveHospitalCalculationDivisionRadio.setUseClearButton(false);

      medicalFacilityCognitiveHospitalCalculationDivisionRadio.setModel(getMedicalFacilityCognitiveHospitalCalculationDivisionRadioModel());

      medicalFacilityCognitiveHospitalCalculationDivisionRadio.setValues(new int[]{1,2});

      addMedicalFacilityCognitiveHospitalCalculationDivisionRadio();
    }
    return medicalFacilityCognitiveHospitalCalculationDivisionRadio;

  }

  /**
   * �Z��敪�R���e�i���擾���܂��B
   * @return �Z��敪�R���e�i
   */
  protected ACLabelContainer getMedicalFacilityCognitiveHospitalCalculationDivisionRadioContainer(){
    if(medicalFacilityCognitiveHospitalCalculationDivisionRadioContainer==null){
      medicalFacilityCognitiveHospitalCalculationDivisionRadioContainer = new ACLabelContainer();
      medicalFacilityCognitiveHospitalCalculationDivisionRadioContainer.setFollowChildEnabled(true);
      medicalFacilityCognitiveHospitalCalculationDivisionRadioContainer.setVAlignment(VRLayout.CENTER);
      medicalFacilityCognitiveHospitalCalculationDivisionRadioContainer.add(getMedicalFacilityCognitiveHospitalCalculationDivisionRadio(), null);
    }
    return medicalFacilityCognitiveHospitalCalculationDivisionRadioContainer;
  }

  /**
   * �Z��敪���f�����擾���܂��B
   * @return �Z��敪���f��
   */
  protected ACListModelAdapter getMedicalFacilityCognitiveHospitalCalculationDivisionRadioModel(){
    if(medicalFacilityCognitiveHospitalCalculationDivisionRadioModel==null){
      medicalFacilityCognitiveHospitalCalculationDivisionRadioModel = new ACListModelAdapter();
      addMedicalFacilityCognitiveHospitalCalculationDivisionRadioModel();
    }
    return medicalFacilityCognitiveHospitalCalculationDivisionRadioModel;
  }

  /**
   * �ʏ���擾���܂��B
   * @return �ʏ�
   */
  public ACRadioButtonItem getMedicalFacilityCognitiveHospitalCalculationDivisionRadioItem1(){
    if(medicalFacilityCognitiveHospitalCalculationDivisionRadioItem1==null){

      medicalFacilityCognitiveHospitalCalculationDivisionRadioItem1 = new ACRadioButtonItem();

      medicalFacilityCognitiveHospitalCalculationDivisionRadioItem1.setText("�ʏ�");

      medicalFacilityCognitiveHospitalCalculationDivisionRadioItem1.setGroup(getMedicalFacilityCognitiveHospitalCalculationDivisionRadio());

      medicalFacilityCognitiveHospitalCalculationDivisionRadioItem1.setConstraints(VRLayout.FLOW);

      addMedicalFacilityCognitiveHospitalCalculationDivisionRadioItem1();
    }
    return medicalFacilityCognitiveHospitalCalculationDivisionRadioItem1;

  }

  /**
   * ���Z�݂̂��擾���܂��B
   * @return ���Z�̂�
   */
  public ACRadioButtonItem getMedicalFacilityCognitiveHospitalCalculationDivisionRadioItem2(){
    if(medicalFacilityCognitiveHospitalCalculationDivisionRadioItem2==null){

      medicalFacilityCognitiveHospitalCalculationDivisionRadioItem2 = new ACRadioButtonItem();

      medicalFacilityCognitiveHospitalCalculationDivisionRadioItem2.setText("���Z�̂�");

      medicalFacilityCognitiveHospitalCalculationDivisionRadioItem2.setGroup(getMedicalFacilityCognitiveHospitalCalculationDivisionRadio());

      medicalFacilityCognitiveHospitalCalculationDivisionRadioItem2.setConstraints(VRLayout.FLOW);

      addMedicalFacilityCognitiveHospitalCalculationDivisionRadioItem2();
    }
    return medicalFacilityCognitiveHospitalCalculationDivisionRadioItem2;

  }

  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001_15313_201804Design() {

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

    tabs.addTab("4", getTab4());

  }

  /**
   * �^�u1�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTab1(){

    tab1.add(getMedicalFacilityCognitiveHospitalInstitutionDivisionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getHospitalDivisionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getMedicalFacilityCognitiveHospitalHospitalDivisionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getMedicalFacilityCognitiveHospitalHospitalRoomContena(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getHospitalizedPatientsCriteriaRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getUnitCareMaintenanceRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * �{�ݓ��̋敪�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityCognitiveHospitalInstitutionDivisionRadio(){

  }

  /**
   * �{�ݓ��̋敪���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityCognitiveHospitalInstitutionDivisionRadioModel(){

    getMedicalFacilityCognitiveHospitalHospitalInstitutionDivisionRadioItem1().setButtonIndex(1);

    getMedicalFacilityCognitiveHospitalInstitutionDivisionRadioModel().add(getMedicalFacilityCognitiveHospitalHospitalInstitutionDivisionRadioItem1());

    getMedicalFacilityCognitiveHospitalHospitalInstitutionDivisionRadioItem2().setButtonIndex(2);

    getMedicalFacilityCognitiveHospitalInstitutionDivisionRadioModel().add(getMedicalFacilityCognitiveHospitalHospitalInstitutionDivisionRadioItem2());

    getMedicalFacilityCognitiveHospitalHospitalInstitutionDivisionRadioItem3().setButtonIndex(3);

    getMedicalFacilityCognitiveHospitalInstitutionDivisionRadioModel().add(getMedicalFacilityCognitiveHospitalHospitalInstitutionDivisionRadioItem3());

  }

  /**
   * �F�m�ǎ����^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityCognitiveHospitalHospitalInstitutionDivisionRadioItem1(){

  }

  /**
   * ���j�b�g�^�F�m�ǎ����^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityCognitiveHospitalHospitalInstitutionDivisionRadioItem2(){

  }

  /**
   * �o�ߌ^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityCognitiveHospitalHospitalInstitutionDivisionRadioItem3(){

  }

  /**
   * �a�@�敪�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHospitalDivisionRadio(){

  }

  /**
   * �a�@�敪���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addHospitalDivisionRadioModel(){

    getHospitalDivisionRadioItem1().setButtonIndex(1);

    getHospitalDivisionRadioModel().add(getHospitalDivisionRadioItem1());

    getHospitalDivisionRadioItem2().setButtonIndex(2);

    getHospitalDivisionRadioModel().add(getHospitalDivisionRadioItem2());

  }

  /**
   * ��w�a�@�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHospitalDivisionRadioItem1(){

  }

  /**
   * ��ʕa�@�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHospitalDivisionRadioItem2(){

  }

  /**
   * �l���z�u�敪�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityCognitiveHospitalHospitalDivision(){

  }

  /**
   * �l���z�u�敪���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityCognitiveHospitalHospitalDivisionModel(){

    getMedicalFacilityCognitiveHospitalDivision1().setButtonIndex(1);

    getMedicalFacilityCognitiveHospitalHospitalDivisionModel().add(getMedicalFacilityCognitiveHospitalDivision1());

    getMedicalFacilityCognitiveHospitalDivision2().setButtonIndex(2);

    getMedicalFacilityCognitiveHospitalHospitalDivisionModel().add(getMedicalFacilityCognitiveHospitalDivision2());

    getMedicalFacilityCognitiveHospitalDivision3().setButtonIndex(3);

    getMedicalFacilityCognitiveHospitalHospitalDivisionModel().add(getMedicalFacilityCognitiveHospitalDivision3());

    getMedicalFacilityCognitiveHospitalDivision4().setButtonIndex(4);

    getMedicalFacilityCognitiveHospitalHospitalDivisionModel().add(getMedicalFacilityCognitiveHospitalDivision4());

    getMedicalFacilityCognitiveHospitalDivision5().setButtonIndex(5);

    getMedicalFacilityCognitiveHospitalHospitalDivisionModel().add(getMedicalFacilityCognitiveHospitalDivision5());

  }

  /**
   * I�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityCognitiveHospitalDivision1(){

  }

  /**
   * II�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityCognitiveHospitalDivision2(){

  }

  /**
   * III�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityCognitiveHospitalDivision3(){

  }

  /**
   * IV�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityCognitiveHospitalDivision4(){

  }

  /**
   * V�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityCognitiveHospitalDivision5(){

  }

  /**
   * �a���敪�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityCognitiveHospitalHospitalRoomContena(){

    medicalFacilityCognitiveHospitalHospitalRoomContena.add(getMedicalFacilityCognitiveHospitalHospitalRoomRadio(), VRLayout.FLOW_INSETLINE_RETURN);

    medicalFacilityCognitiveHospitalHospitalRoomContena.add(getMedicalFacilityCognitiveHospitalUnitHospitalRoomRadio(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * �a���敪�i�a�@�j�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityCognitiveHospitalHospitalRoomRadio(){

  }

  /**
   * �a���敪�i�a�@�j���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityCognitiveHospitalHospitalRoomRadioModel(){

    getMedicalFacilityCognitiveHospitalHospitalRoomRadioItem1().setButtonIndex(1);

    getMedicalFacilityCognitiveHospitalHospitalRoomRadioModel().add(getMedicalFacilityCognitiveHospitalHospitalRoomRadioItem1());

    getMedicalFacilityCognitiveHospitalHospitalRoomRadioItem2().setButtonIndex(2);

    getMedicalFacilityCognitiveHospitalHospitalRoomRadioModel().add(getMedicalFacilityCognitiveHospitalHospitalRoomRadioItem2());

  }

  /**
   * �]���^���ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityCognitiveHospitalHospitalRoomRadioItem1(){

  }

  /**
   * �������ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityCognitiveHospitalHospitalRoomRadioItem2(){

  }

  /**
   * �a���敪�i���j�b�g�^�j�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityCognitiveHospitalUnitHospitalRoomRadio(){

  }

  /**
   * �a���敪�i���j�b�g�^�j���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityCognitiveHospitalUnitHospitalRoomRadioModel(){

    getMedicalFacilityCognitiveHospitalUnitHospitalRoomRadioItem1().setButtonIndex(1);

    getMedicalFacilityCognitiveHospitalUnitHospitalRoomRadioModel().add(getMedicalFacilityCognitiveHospitalUnitHospitalRoomRadioItem1());

    getMedicalFacilityCognitiveHospitalUnitHospitalRoomRadioItem2().setButtonIndex(2);

    getMedicalFacilityCognitiveHospitalUnitHospitalRoomRadioModel().add(getMedicalFacilityCognitiveHospitalUnitHospitalRoomRadioItem2());

  }

  /**
   * ���j�b�g�^���ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityCognitiveHospitalUnitHospitalRoomRadioItem1(){

  }

  /**
   * ���j�b�g�^���I�������ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityCognitiveHospitalUnitHospitalRoomRadioItem2(){

  }

  /**
   * ���@���҂Ɋւ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addHospitalizedPatientsCriteriaRadio(){

  }

  /**
   * ���@���҂Ɋւ������f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addHospitalizedPatientsCriteriaRadioModel(){

    getHospitalizedPatientsCriteriaRadioItem1().setButtonIndex(2);

    getHospitalizedPatientsCriteriaRadioModel().add(getHospitalizedPatientsCriteriaRadioItem1());

    getHospitalizedPatientsCriteriaRadioItem2().setButtonIndex(1);

    getHospitalizedPatientsCriteriaRadioModel().add(getHospitalizedPatientsCriteriaRadioItem2());

  }

  /**
   * ��^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHospitalizedPatientsCriteriaRadioItem1(){

  }

  /**
   * ���Z�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHospitalizedPatientsCriteriaRadioItem2(){

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
   * �^�u2�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTab2(){

    tab2.add(getMedicalFacilityCognitiveHospitalStayRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getMedicalFacilityCognitiveHospitalStandardRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getMedicalFacilityCognitiveHospitalMedicalExaminationRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getMedicalFacilityCognitiveHospitalNutritionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getMedicalFacilityCognitiveHospitalOralSwitchRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getOralMaintenanceAddContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getOralKeepStructureAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getYoungDementiaPatinetAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getMedicalFacilityCognitiveHospitalRecuperateDinnerRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * �O�����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityCognitiveHospitalStayRadio(){

  }

  /**
   * �O�����Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityCognitiveHospitalStayRadioModel(){

    getMedicalFacilityCognitiveHospitalStayRadioItem1().setButtonIndex(1);

    getMedicalFacilityCognitiveHospitalStayRadioModel().add(getMedicalFacilityCognitiveHospitalStayRadioItem1());

    getMedicalFacilityCognitiveHospitalStayRadioItem2().setButtonIndex(2);

    getMedicalFacilityCognitiveHospitalStayRadioModel().add(getMedicalFacilityCognitiveHospitalStayRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityCognitiveHospitalStayRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityCognitiveHospitalStayRadioItem2(){

  }

  /**
   * �������Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityCognitiveHospitalStandardRadio(){

  }

  /**
   * �������Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityCognitiveHospitalStandardRadioModel(){

    getMedicalFacilityCognitiveHospitalStandardRadioItem1().setButtonIndex(1);

    getMedicalFacilityCognitiveHospitalStandardRadioModel().add(getMedicalFacilityCognitiveHospitalStandardRadioItem1());

    getMedicalFacilityCognitiveHospitalStandardRadioItem2().setButtonIndex(2);

    getMedicalFacilityCognitiveHospitalStandardRadioModel().add(getMedicalFacilityCognitiveHospitalStandardRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityCognitiveHospitalStandardRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityCognitiveHospitalStandardRadioItem2(){

  }

  /**
   * ���Ȏ�f�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityCognitiveHospitalMedicalExaminationRadio(){

  }

  /**
   * ���Ȏ�f���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityCognitiveHospitalMedicalExaminationRadioModel(){

    getMedicalFacilityCognitiveHospitalMedicalExaminationRadioItem1().setButtonIndex(1);

    getMedicalFacilityCognitiveHospitalMedicalExaminationRadioModel().add(getMedicalFacilityCognitiveHospitalMedicalExaminationRadioItem1());

    getMedicalFacilityCognitiveHospitalMedicalExaminationRadioItem2().setButtonIndex(2);

    getMedicalFacilityCognitiveHospitalMedicalExaminationRadioModel().add(getMedicalFacilityCognitiveHospitalMedicalExaminationRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityCognitiveHospitalMedicalExaminationRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityCognitiveHospitalMedicalExaminationRadioItem2(){

  }

  /**
   * �h�{�}�l�W�����g���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityCognitiveHospitalNutritionRadio(){

  }

  /**
   * �h�{�}�l�W�����g���Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityCognitiveHospitalNutritionRadioModel(){

    getMedicalFacilityCognitiveHospitalNutritionRadioItem1().setButtonIndex(1);

    getMedicalFacilityCognitiveHospitalNutritionRadioModel().add(getMedicalFacilityCognitiveHospitalNutritionRadioItem1());

    getMedicalFacilityCognitiveHospitalNutritionRadioItem2().setButtonIndex(2);

    getMedicalFacilityCognitiveHospitalNutritionRadioModel().add(getMedicalFacilityCognitiveHospitalNutritionRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityCognitiveHospitalNutritionRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityCognitiveHospitalNutritionRadioItem2(){

  }

  /**
   * �o���ڍs���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityCognitiveHospitalOralSwitchRadio(){

  }

  /**
   * �o���ڍs���Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityCognitiveHospitalOralSwitchRadioModel(){

    getMedicalFacilityCognitiveHospitalOralSwitchRadioItem1().setButtonIndex(1);

    getMedicalFacilityCognitiveHospitalOralSwitchRadioModel().add(getMedicalFacilityCognitiveHospitalOralSwitchRadioItem1());

    getMedicalFacilityCognitiveHospitalOralSwitchRadioItem2().setButtonIndex(2);

    getMedicalFacilityCognitiveHospitalOralSwitchRadioModel().add(getMedicalFacilityCognitiveHospitalOralSwitchRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityCognitiveHospitalOralSwitchRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityCognitiveHospitalOralSwitchRadioItem2(){

  }

  /**
   * �o���ێ����Z�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addOralMaintenanceAddContainer(){

    oralMaintenanceAddContainer.add(getOralMaintenanceAdd(), null);

    oralMaintenanceAddContainer.add(getOralMaintenanceAddItem3(), VRLayout.FLOW);

  }

  /**
   * �o���ێ����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addOralMaintenanceAdd(){

  }

  /**
   * �o���ێ����Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addOralMaintenanceAddModel(){

    getOralMaintenanceAddItem1().setButtonIndex(1);

    getOralMaintenanceAddModel().add(getOralMaintenanceAddItem1());

    getOralMaintenanceAddItem2().setButtonIndex(2);

    getOralMaintenanceAddModel().add(getOralMaintenanceAddItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addOralMaintenanceAddItem1(){

  }

  /**
   * I�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addOralMaintenanceAddItem2(){

  }

  /**
   * II�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addOralMaintenanceAddItem3(){

  }

  /**
   * ���o�q���Ǘ��̐����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addOralKeepStructureAddRadioGroup(){

  }

  /**
   * ���o�q���Ǘ��̐����Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addOralKeepStructureAddRadioGroupModel(){

    getOralKeepStructureAddRadioItem1().setButtonIndex(1);

    getOralKeepStructureAddRadioGroupModel().add(getOralKeepStructureAddRadioItem1());

    getOralKeepStructureAddRadioItem2().setButtonIndex(2);

    getOralKeepStructureAddRadioGroupModel().add(getOralKeepStructureAddRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addOralKeepStructureAddRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addOralKeepStructureAddRadioItem2(){

  }

  /**
   * ���o�q���Ǘ����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addYoungDementiaPatinetAddRadioGroup(){

  }

  /**
   * ���o�q���Ǘ����Z���f���ɓ������ڂ�ǉ����܂��B
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
   * �×{�H���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityCognitiveHospitalRecuperateDinnerRadio(){

  }

  /**
   * �×{�H���Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityCognitiveHospitalRecuperateDinnerRadioModel(){

    getMedicalFacilityCognitiveHospitalRecuperateDinnerRadioItem1().setButtonIndex(1);

    getMedicalFacilityCognitiveHospitalRecuperateDinnerRadioModel().add(getMedicalFacilityCognitiveHospitalRecuperateDinnerRadioItem1());

    getMedicalFacilityCognitiveHospitalRecuperateDinnerRadioItem2().setButtonIndex(2);

    getMedicalFacilityCognitiveHospitalRecuperateDinnerRadioModel().add(getMedicalFacilityCognitiveHospitalRecuperateDinnerRadioItem2());

    getMedicalFacilityCognitiveHospitalRecuperateDinnerRadioItem3().setButtonIndex(3);

    getMedicalFacilityCognitiveHospitalRecuperateDinnerRadioModel().add(getMedicalFacilityCognitiveHospitalRecuperateDinnerRadioItem3());

    getMedicalFacilityCognitiveHospitalRecuperateDinnerRadioItem4().setButtonIndex(4);

    getMedicalFacilityCognitiveHospitalRecuperateDinnerRadioModel().add(getMedicalFacilityCognitiveHospitalRecuperateDinnerRadioItem4());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityCognitiveHospitalRecuperateDinnerRadioItem1(){

  }

  /**
   * 3��ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityCognitiveHospitalRecuperateDinnerRadioItem2(){

  }

  /**
   * 2��ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityCognitiveHospitalRecuperateDinnerRadioItem3(){

  }

  /**
   * 1��ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityCognitiveHospitalRecuperateDinnerRadioItem4(){

  }

  /**
   * �^�u3�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTab3(){

    tab3.add(getMedicalFacilityCognitiveHospitalHijoAddition(), VRLayout.FLOW_INSETLINE_RETURN);

    tab3.add(getMedicalFacilityCognitiveHospitalConsultationFee(), VRLayout.FLOW);

    tab3.add(getMedicalFacilityCognitiveHospitalConsultationFeeLabel(), VRLayout.FLOW_RETURN);

    tab3.add(getMedicalFacilityCognitiveHospitalSubstractionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab3.add(getMedicalFacilityCognitiveHospitalDinnerContainer(), VRLayout.FLOW_DOUBLEINSETLINE_RETURN);

  }

  /**
   * �ޏ��֘A���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityCognitiveHospitalHijoAddition(){

    medicalFacilityCognitiveHospitalHijoAddition.add(getLeavingHospitalPreConsultationAddition(), VRLayout.FLOW_RETURN);

    medicalFacilityCognitiveHospitalHijoAddition.add(getLeavingHospitalAfterConsultationAddition(), VRLayout.FLOW_RETURN);

    medicalFacilityCognitiveHospitalHijoAddition.add(getLeavingHospitalConsultationAddition(), VRLayout.FLOW_RETURN);

    medicalFacilityCognitiveHospitalHijoAddition.add(getLeavingHospitalDissemination(), VRLayout.FLOW_RETURN);

    medicalFacilityCognitiveHospitalHijoAddition.add(getLeavingHospitalCooperationAddition(), VRLayout.FLOW_RETURN);

    medicalFacilityCognitiveHospitalHijoAddition.add(getLeavingHospital(), VRLayout.FLOW_RETURN);

  }

  /**
   * �ޏ�(�@)�O�K��w�����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addLeavingHospitalPreConsultationAddition(){

  }

  /**
   * �ޏ�(�@)��K��w�����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addLeavingHospitalAfterConsultationAddition(){

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
   * �K��Ō�w�����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addLeavingHospital(){

  }

  /**
   * ����f�Ô�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityCognitiveHospitalConsultationFee(){

  }

  /**
   * ���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityCognitiveHospitalConsultationFeeLabel(){

  }

  /**
   * �l�����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityCognitiveHospitalSubstraction(){

  }

  /**
   * �l�����Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityCognitiveHospitalSubstractionModel(){

  }

  /**
   * �H���R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityCognitiveHospitalDinnerContainer(){

    medicalFacilityCognitiveHospitalDinnerContainer.add(getMedicalFacilityCognitiveHospitalDinnerOfferContainer(), VRLayout.FLOW);

    medicalFacilityCognitiveHospitalDinnerContainer.add(getMedicalFacilityCognitiveHospitalDinnerCostContainer(), VRLayout.FLOW);

  }

  /**
   * �H���񋟂ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityCognitiveHospitalDinnerOffer(){

  }

  /**
   * �H���񋟃��f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityCognitiveHospitalDinnerOfferModel(){

  }

  /**
   * �H����p�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityCognitiveHospitalDinnerCost(){

  }

  /**
   * �^�u4�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTab4(){

    tab4.add(getBodyRestraintAbolitionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab4.add(getStayReturnSupportAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab4.add(getServiceAddProvisionStructuralRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab4.add(getLowNutritionalRiskImprovementAddContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab4.add(getExcretionSupportContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab4.add(getMedicalFacilityCognitiveHospitalCalculationDivisionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

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

    getStayReturnSupportAddRadioitem1().setButtonIndex(1);

    getStayReturnSupportAddRadioModel().add(getStayReturnSupportAddRadioitem1());

    getStayReturnSupportAddRadioitem2().setButtonIndex(2);

    getStayReturnSupportAddRadioModel().add(getStayReturnSupportAddRadioitem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addStayReturnSupportAddRadioitem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addStayReturnSupportAddRadioitem2(){

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

    getServiceAddProvisionStructuralRadioItem5().setButtonIndex(5);

    getServiceAddProvisionStructuralRadioGroupModel().add(getServiceAddProvisionStructuralRadioItem5());

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
   * I�C�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceAddProvisionStructuralRadioItem5(){

  }

  /**
   * I���^�ɓ������ڂ�ǉ����܂��B
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
   * ��h�{���X�N���P���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addLowNutritionalRiskImprovementAdd(){

  }

  /**
   * ��h�{���X�N���P���Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addLowNutritionalRiskImprovementAddModel(){

    getLowNutritionalRiskImprovementAddItem1().setButtonIndex(1);

    getLowNutritionalRiskImprovementAddModel().add(getLowNutritionalRiskImprovementAddItem1());

    getLowNutritionalRiskImprovementAddItem2().setButtonIndex(2);

    getLowNutritionalRiskImprovementAddModel().add(getLowNutritionalRiskImprovementAddItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addLowNutritionalRiskImprovementAddItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addLowNutritionalRiskImprovementAddItem2(){

  }

  /**
   * �r���x�����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addExcretionSupport(){

  }

  /**
   * �r���x�����Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addExcretionSupportModel(){

    getExcretionSupportItem1().setButtonIndex(1);

    getExcretionSupportModel().add(getExcretionSupportItem1());

    getExcretionSupportItem2().setButtonIndex(2);

    getExcretionSupportModel().add(getExcretionSupportItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addExcretionSupportItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addExcretionSupportItem2(){

  }

  /**
   * �Z��敪�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityCognitiveHospitalCalculationDivisionRadio(){

  }

  /**
   * �Z��敪���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityCognitiveHospitalCalculationDivisionRadioModel(){

    getMedicalFacilityCognitiveHospitalCalculationDivisionRadioItem1().setButtonIndex(1);

    getMedicalFacilityCognitiveHospitalCalculationDivisionRadioModel().add(getMedicalFacilityCognitiveHospitalCalculationDivisionRadioItem1());

    getMedicalFacilityCognitiveHospitalCalculationDivisionRadioItem2().setButtonIndex(2);

    getMedicalFacilityCognitiveHospitalCalculationDivisionRadioModel().add(getMedicalFacilityCognitiveHospitalCalculationDivisionRadioItem2());

  }

  /**
   * �ʏ�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityCognitiveHospitalCalculationDivisionRadioItem1(){

  }

  /**
   * ���Z�݂̂ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityCognitiveHospitalCalculationDivisionRadioItem2(){

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
      ACFrame.debugStart(new ACAffairInfo(QS001_15313_201804Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QS001_15313_201804Design getThis() {
    return this;
  }
}
