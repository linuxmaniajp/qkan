
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
 * �쐬��: 2009/03/06  ���{�R���s���[�^�[������� ����@��F �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �T�[�r�X�\��쐬/�ύX (S)
 * �v���Z�X �T�[�r�X�\��T�� (001)
 * �v���O���� �T�[�r�X�p�^�[�����×{�^��Î{�݁i�F�m�ǁj (QS001122_H2104)
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
 * �T�[�r�X�p�^�[�����×{�^��Î{�݁i�F�m�ǁj��ʍ��ڃf�U�C��(QS001122_H2104) 
 */
public class QS001122_H2104Design extends QS001ServicePanel {
  //GUI�R���|�[�l���g

  private JTabbedPane tabs;

  private ACPanel tab1;

  private ACClearableRadioButtonGroup medicalFacilityCognitiveHospitalInstitutionDivisionRadio;

  private ACLabelContainer medicalFacilityCognitiveHospitalInstitutionDivisionRadioContainer;

  private ACListModelAdapter medicalFacilityCognitiveHospitalInstitutionDivisionRadioModel;

  private ACRadioButtonItem medicalFacilityCognitiveHospitalHospitalInstitutionDivisionRadioItem1;

  private ACRadioButtonItem medicalFacilityCognitiveHospitalHospitalInstitutionDivisionRadioItem2;

  private ACRadioButtonItem medicalFacilityCognitiveHospitalHospitalInstitutionDivisionRadioItem3;

  private ACClearableRadioButtonGroup medicalFacilityCognitiveHospitalHospitalDivision;

  private ACLabelContainer medicalFacilityCognitiveHospitalHospitalDivisionContainer;

  private ACListModelAdapter medicalFacilityCognitiveHospitalHospitalDivisionModel;

  private ACRadioButtonItem medicalFacilityCognitiveHospitalDivision1;

  private ACRadioButtonItem medicalFacilityCognitiveHospitalDivision2;

  private ACRadioButtonItem medicalFacilityCognitiveHospitalDivision3;

  private ACRadioButtonItem medicalFacilityCognitiveHospitalDivision4;

  private ACRadioButtonItem medicalFacilityCognitiveHospitalDivision5;

  private ACClearableRadioButtonGroup hospitalDivisionRadio;

  private ACLabelContainer hospitalDivisionRadioContainer;

  private ACListModelAdapter hospitalDivisionRadioModel;

  private ACRadioButtonItem hospitalDivisionRadioItem1;

  private ACRadioButtonItem hospitalDivisionRadioItem2;

  private ACLabelContainer medicalFacilityCognitiveHospitalHospitalRoomContena;

  private ACClearableRadioButtonGroup medicalFacilityCognitiveHospitalHospitalRoomRadio;

  private ACListModelAdapter medicalFacilityCognitiveHospitalHospitalRoomRadioModel;

  private ACRadioButtonItem medicalFacilityCognitiveHospitalHospitalRoomRadioItem1;

  private ACRadioButtonItem medicalFacilityCognitiveHospitalHospitalRoomRadioItem2;

  private ACClearableRadioButtonGroup medicalFacilityCognitiveHospitalUnitHospitalRoomRadio;

  private ACListModelAdapter medicalFacilityCognitiveHospitalUnitHospitalRoomRadioModel;

  private ACRadioButtonItem medicalFacilityCognitiveHospitalUnitHospitalRoomRadioItem1;

  private ACRadioButtonItem medicalFacilityCognitiveHospitalUnitHospitalRoomRadioItem2;

  private ACClearableRadioButtonGroup medicalFacilityCognitiveHospitalStayRadio;

  private ACLabelContainer medicalFacilityCognitiveHospitalStayRadioContainer;

  private ACListModelAdapter medicalFacilityCognitiveHospitalStayRadioModel;

  private ACRadioButtonItem medicalFacilityCognitiveHospitalStayRadioItem1;

  private ACRadioButtonItem medicalFacilityCognitiveHospitalStayRadioItem2;

  private ACClearableRadioButtonGroup medicalFacilityCognitiveHospitalStandardRadio;

  private ACLabelContainer medicalFacilityCognitiveHospitalStandardRadioContainer;

  private ACListModelAdapter medicalFacilityCognitiveHospitalStandardRadioModel;

  private ACRadioButtonItem medicalFacilityCognitiveHospitalStandardRadioItem1;

  private ACRadioButtonItem medicalFacilityCognitiveHospitalStandardRadioItem2;

  private ACClearableRadioButtonGroup medicalFacilityCognitiveHospitalMedicalExaminationRadio;

  private ACLabelContainer medicalFacilityCognitiveHospitalMedicalExaminationRadioContainer;

  private ACListModelAdapter medicalFacilityCognitiveHospitalMedicalExaminationRadioModel;

  private ACRadioButtonItem medicalFacilityCognitiveHospitalMedicalExaminationRadioItem1;

  private ACRadioButtonItem medicalFacilityCognitiveHospitalMedicalExaminationRadioItem2;

  private ACClearableRadioButtonGroup medicalFacilityCognitiveHospitalNutritionRadio;

  private ACLabelContainer medicalFacilityCognitiveHospitalNutritionRadioContainer;

  private ACListModelAdapter medicalFacilityCognitiveHospitalNutritionRadioModel;

  private ACRadioButtonItem medicalFacilityCognitiveHospitalNutritionRadioItem1;

  private ACRadioButtonItem medicalFacilityCognitiveHospitalNutritionRadioItem2;

  private ACPanel tab2;

  private ACClearableRadioButtonGroup medicalFacilityCognitiveHospitalOralSwitchRadio;

  private ACLabelContainer medicalFacilityCognitiveHospitalOralSwitchRadioContainer;

  private ACListModelAdapter medicalFacilityCognitiveHospitalOralSwitchRadioModel;

  private ACRadioButtonItem medicalFacilityCognitiveHospitalOralSwitchRadioItem1;

  private ACRadioButtonItem medicalFacilityCognitiveHospitalOralSwitchRadioItem2;

  private ACClearableRadioButtonGroup oralMaintenanceAddRadio;

  private ACLabelContainer oralMaintenanceAddRadioContainer;

  private ACListModelAdapter oralMaintenanceAddRadioModel;

  private ACRadioButtonItem oralMaintenanceAddRadioItem1;

  private ACRadioButtonItem oralMaintenanceAddRadioItem2;

  private ACRadioButtonItem oralMaintenanceAddRadioItem3;

  private ACValueArrayRadioButtonGroup youngDementiaPatinetAddRadioGroup;

  private ACLabelContainer youngDementiaPatinetAddRadioGroupContainer;

  private ACListModelAdapter youngDementiaPatinetAddRadioGroupModel;

  private ACRadioButtonItem youngDementiaPatinetAddRadioItem1;

  private ACRadioButtonItem youngDementiaPatinetAddRadioItem2;

  private ACClearableRadioButtonGroup medicalFacilityCognitiveHospitalRecuperateDinnerRadio;

  private ACLabelContainer medicalFacilityCognitiveHospitalRecuperateDinnerRadioContainer;

  private ACListModelAdapter medicalFacilityCognitiveHospitalRecuperateDinnerRadioModel;

  private ACRadioButtonItem medicalFacilityCognitiveHospitalRecuperateDinnerRadioItem1;

  private ACRadioButtonItem medicalFacilityCognitiveHospitalRecuperateDinnerRadioItem2;

  private ACLabelContainer medicalFacilityCognitiveHospitalHijoAddition;

  private ACIntegerCheckBox leavingHospitalPreConsultationAddition;

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

  private ACPanel tab3;

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

  private ACRadioButtonItem stayReturnSupportAddRadioitem1;

  private ACRadioButtonItem stayReturnSupportAddRadioitem2;

  private ACValueArrayRadioButtonGroup serviceAddProvisionStructuralRadioGroup;

  private ACLabelContainer serviceAddProvisionStructuralRadioGroupContainer;

  private ACListModelAdapter serviceAddProvisionStructuralRadioGroupModel;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem1;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem2;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem3;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem4;

  private ACClearableRadioButtonGroup medicalFacilityCognitiveHospitalCalculationDivisionRadio;

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

      tab1.setHgap(0);

      addTab1();
    }
    return tab1;

  }

  /**
   * �{�ݓ��̋敪���擾���܂��B
   * @return �{�ݓ��̋敪
   */
  public ACClearableRadioButtonGroup getMedicalFacilityCognitiveHospitalInstitutionDivisionRadio(){
    if(medicalFacilityCognitiveHospitalInstitutionDivisionRadio==null){

      medicalFacilityCognitiveHospitalInstitutionDivisionRadio = new ACClearableRadioButtonGroup();

      getMedicalFacilityCognitiveHospitalInstitutionDivisionRadioContainer().setText("�{�ݓ��̋敪");

      medicalFacilityCognitiveHospitalInstitutionDivisionRadio.setBindPath("1530301");

      medicalFacilityCognitiveHospitalInstitutionDivisionRadio.setUseClearButton(false);

      medicalFacilityCognitiveHospitalInstitutionDivisionRadio.setModel(getMedicalFacilityCognitiveHospitalInstitutionDivisionRadioModel());

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
   * �l���z�u�敪���擾���܂��B
   * @return �l���z�u�敪
   */
  public ACClearableRadioButtonGroup getMedicalFacilityCognitiveHospitalHospitalDivision(){
    if(medicalFacilityCognitiveHospitalHospitalDivision==null){

      medicalFacilityCognitiveHospitalHospitalDivision = new ACClearableRadioButtonGroup();

      getMedicalFacilityCognitiveHospitalHospitalDivisionContainer().setText("�l���z�u�敪");

      medicalFacilityCognitiveHospitalHospitalDivision.setBindPath("1530302");

      medicalFacilityCognitiveHospitalHospitalDivision.setUseClearButton(false);

      medicalFacilityCognitiveHospitalHospitalDivision.setModel(getMedicalFacilityCognitiveHospitalHospitalDivisionModel());

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
   * �a�@�敪���擾���܂��B
   * @return �a�@�敪
   */
  public ACClearableRadioButtonGroup getHospitalDivisionRadio(){
    if(hospitalDivisionRadio==null){

      hospitalDivisionRadio = new ACClearableRadioButtonGroup();

      getHospitalDivisionRadioContainer().setText("�a�@�敪");

      hospitalDivisionRadio.setBindPath("1530316");

      hospitalDivisionRadio.setUseClearButton(false);

      hospitalDivisionRadio.setModel(getHospitalDivisionRadioModel());

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
   * �a���敪�R���e�i���擾���܂��B
   * @return �a���敪�R���e�i
   */
  public ACLabelContainer getMedicalFacilityCognitiveHospitalHospitalRoomContena(){
    if(medicalFacilityCognitiveHospitalHospitalRoomContena==null){

      medicalFacilityCognitiveHospitalHospitalRoomContena = new ACLabelContainer();

      medicalFacilityCognitiveHospitalHospitalRoomContena.setText("�a���敪");

      addMedicalFacilityCognitiveHospitalHospitalRoomContena();
    }
    return medicalFacilityCognitiveHospitalHospitalRoomContena;

  }

  /**
   * �a���敪�i�a�@�j���擾���܂��B
   * @return �a���敪�i�a�@�j
   */
  public ACClearableRadioButtonGroup getMedicalFacilityCognitiveHospitalHospitalRoomRadio(){
    if(medicalFacilityCognitiveHospitalHospitalRoomRadio==null){

      medicalFacilityCognitiveHospitalHospitalRoomRadio = new ACClearableRadioButtonGroup();

      medicalFacilityCognitiveHospitalHospitalRoomRadio.setBindPath("1530303");

      medicalFacilityCognitiveHospitalHospitalRoomRadio.setUseClearButton(false);

      medicalFacilityCognitiveHospitalHospitalRoomRadio.setModel(getMedicalFacilityCognitiveHospitalHospitalRoomRadioModel());

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
  public ACClearableRadioButtonGroup getMedicalFacilityCognitiveHospitalUnitHospitalRoomRadio(){
    if(medicalFacilityCognitiveHospitalUnitHospitalRoomRadio==null){

      medicalFacilityCognitiveHospitalUnitHospitalRoomRadio = new ACClearableRadioButtonGroup();

      medicalFacilityCognitiveHospitalUnitHospitalRoomRadio.setBindPath("1530304");

      medicalFacilityCognitiveHospitalUnitHospitalRoomRadio.setUseClearButton(false);

      medicalFacilityCognitiveHospitalUnitHospitalRoomRadio.setModel(getMedicalFacilityCognitiveHospitalUnitHospitalRoomRadioModel());

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

      medicalFacilityCognitiveHospitalUnitHospitalRoomRadioItem1.setText("���j�b�g�^��");

      medicalFacilityCognitiveHospitalUnitHospitalRoomRadioItem1.setGroup(getMedicalFacilityCognitiveHospitalUnitHospitalRoomRadio());

      medicalFacilityCognitiveHospitalUnitHospitalRoomRadioItem1.setConstraints(VRLayout.FLOW);

      addMedicalFacilityCognitiveHospitalUnitHospitalRoomRadioItem1();
    }
    return medicalFacilityCognitiveHospitalUnitHospitalRoomRadioItem1;

  }

  /**
   * ���j�b�g�^�������擾���܂��B
   * @return ���j�b�g�^����
   */
  public ACRadioButtonItem getMedicalFacilityCognitiveHospitalUnitHospitalRoomRadioItem2(){
    if(medicalFacilityCognitiveHospitalUnitHospitalRoomRadioItem2==null){

      medicalFacilityCognitiveHospitalUnitHospitalRoomRadioItem2 = new ACRadioButtonItem();

      medicalFacilityCognitiveHospitalUnitHospitalRoomRadioItem2.setText("���j�b�g�^����");

      medicalFacilityCognitiveHospitalUnitHospitalRoomRadioItem2.setGroup(getMedicalFacilityCognitiveHospitalUnitHospitalRoomRadio());

      medicalFacilityCognitiveHospitalUnitHospitalRoomRadioItem2.setConstraints(VRLayout.FLOW);

      addMedicalFacilityCognitiveHospitalUnitHospitalRoomRadioItem2();
    }
    return medicalFacilityCognitiveHospitalUnitHospitalRoomRadioItem2;

  }

  /**
   * �O�����Z���擾���܂��B
   * @return �O�����Z
   */
  public ACClearableRadioButtonGroup getMedicalFacilityCognitiveHospitalStayRadio(){
    if(medicalFacilityCognitiveHospitalStayRadio==null){

      medicalFacilityCognitiveHospitalStayRadio = new ACClearableRadioButtonGroup();

      getMedicalFacilityCognitiveHospitalStayRadioContainer().setText("�O�����Z");

      medicalFacilityCognitiveHospitalStayRadio.setBindPath("1530305");

      medicalFacilityCognitiveHospitalStayRadio.setUseClearButton(false);

      medicalFacilityCognitiveHospitalStayRadio.setModel(getMedicalFacilityCognitiveHospitalStayRadioModel());

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
  public ACClearableRadioButtonGroup getMedicalFacilityCognitiveHospitalStandardRadio(){
    if(medicalFacilityCognitiveHospitalStandardRadio==null){

      medicalFacilityCognitiveHospitalStandardRadio = new ACClearableRadioButtonGroup();

      getMedicalFacilityCognitiveHospitalStandardRadioContainer().setText("�������Z");

      medicalFacilityCognitiveHospitalStandardRadio.setBindPath("1530306");

      medicalFacilityCognitiveHospitalStandardRadio.setUseClearButton(false);

      medicalFacilityCognitiveHospitalStandardRadio.setModel(getMedicalFacilityCognitiveHospitalStandardRadioModel());

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
  public ACClearableRadioButtonGroup getMedicalFacilityCognitiveHospitalMedicalExaminationRadio(){
    if(medicalFacilityCognitiveHospitalMedicalExaminationRadio==null){

      medicalFacilityCognitiveHospitalMedicalExaminationRadio = new ACClearableRadioButtonGroup();

      getMedicalFacilityCognitiveHospitalMedicalExaminationRadioContainer().setText("���Ȏ�f���Z");

      medicalFacilityCognitiveHospitalMedicalExaminationRadio.setBindPath("1530307");

      medicalFacilityCognitiveHospitalMedicalExaminationRadio.setUseClearButton(false);

      medicalFacilityCognitiveHospitalMedicalExaminationRadio.setModel(getMedicalFacilityCognitiveHospitalMedicalExaminationRadioModel());

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
  public ACClearableRadioButtonGroup getMedicalFacilityCognitiveHospitalNutritionRadio(){
    if(medicalFacilityCognitiveHospitalNutritionRadio==null){

      medicalFacilityCognitiveHospitalNutritionRadio = new ACClearableRadioButtonGroup();

      getMedicalFacilityCognitiveHospitalNutritionRadioContainer().setText("�h�{�}�l�W�����g���Z");

      medicalFacilityCognitiveHospitalNutritionRadio.setBindPath("1530309");

      medicalFacilityCognitiveHospitalNutritionRadio.setUseClearButton(false);

      medicalFacilityCognitiveHospitalNutritionRadio.setModel(getMedicalFacilityCognitiveHospitalNutritionRadioModel());

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
   * �o���ڍs���Z���擾���܂��B
   * @return �o���ڍs���Z
   */
  public ACClearableRadioButtonGroup getMedicalFacilityCognitiveHospitalOralSwitchRadio(){
    if(medicalFacilityCognitiveHospitalOralSwitchRadio==null){

      medicalFacilityCognitiveHospitalOralSwitchRadio = new ACClearableRadioButtonGroup();

      getMedicalFacilityCognitiveHospitalOralSwitchRadioContainer().setText("�o���ڍs���Z");

      medicalFacilityCognitiveHospitalOralSwitchRadio.setBindPath("1530310");

      medicalFacilityCognitiveHospitalOralSwitchRadio.setUseClearButton(false);

      medicalFacilityCognitiveHospitalOralSwitchRadio.setModel(getMedicalFacilityCognitiveHospitalOralSwitchRadioModel());

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
   * �o���ێ����Z���擾���܂��B
   * @return �o���ێ����Z
   */
  public ACClearableRadioButtonGroup getOralMaintenanceAddRadio(){
    if(oralMaintenanceAddRadio==null){

      oralMaintenanceAddRadio = new ACClearableRadioButtonGroup();

      getOralMaintenanceAddRadioContainer().setText("�o���ێ����Z");

      oralMaintenanceAddRadio.setBindPath("1530312");

      oralMaintenanceAddRadio.setUseClearButton(false);

      oralMaintenanceAddRadio.setModel(getOralMaintenanceAddRadioModel());

      addOralMaintenanceAddRadio();
    }
    return oralMaintenanceAddRadio;

  }

  /**
   * �o���ێ����Z�R���e�i���擾���܂��B
   * @return �o���ێ����Z�R���e�i
   */
  protected ACLabelContainer getOralMaintenanceAddRadioContainer(){
    if(oralMaintenanceAddRadioContainer==null){
      oralMaintenanceAddRadioContainer = new ACLabelContainer();
      oralMaintenanceAddRadioContainer.setFollowChildEnabled(true);
      oralMaintenanceAddRadioContainer.setVAlignment(VRLayout.CENTER);
      oralMaintenanceAddRadioContainer.add(getOralMaintenanceAddRadio(), null);
    }
    return oralMaintenanceAddRadioContainer;
  }

  /**
   * �o���ێ����Z���f�����擾���܂��B
   * @return �o���ێ����Z���f��
   */
  protected ACListModelAdapter getOralMaintenanceAddRadioModel(){
    if(oralMaintenanceAddRadioModel==null){
      oralMaintenanceAddRadioModel = new ACListModelAdapter();
      addOralMaintenanceAddRadioModel();
    }
    return oralMaintenanceAddRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getOralMaintenanceAddRadioItem1(){
    if(oralMaintenanceAddRadioItem1==null){

      oralMaintenanceAddRadioItem1 = new ACRadioButtonItem();

      oralMaintenanceAddRadioItem1.setText("�Ȃ�");

      oralMaintenanceAddRadioItem1.setGroup(getOralMaintenanceAddRadio());

      oralMaintenanceAddRadioItem1.setConstraints(VRLayout.FLOW);

      addOralMaintenanceAddRadioItem1();
    }
    return oralMaintenanceAddRadioItem1;

  }

  /**
   * I�^���擾���܂��B
   * @return I�^
   */
  public ACRadioButtonItem getOralMaintenanceAddRadioItem2(){
    if(oralMaintenanceAddRadioItem2==null){

      oralMaintenanceAddRadioItem2 = new ACRadioButtonItem();

      oralMaintenanceAddRadioItem2.setText("I�^");

      oralMaintenanceAddRadioItem2.setGroup(getOralMaintenanceAddRadio());

      oralMaintenanceAddRadioItem2.setConstraints(VRLayout.FLOW);

      addOralMaintenanceAddRadioItem2();
    }
    return oralMaintenanceAddRadioItem2;

  }

  /**
   * II�^���擾���܂��B
   * @return II�^
   */
  public ACRadioButtonItem getOralMaintenanceAddRadioItem3(){
    if(oralMaintenanceAddRadioItem3==null){

      oralMaintenanceAddRadioItem3 = new ACRadioButtonItem();

      oralMaintenanceAddRadioItem3.setText("II�^");

      oralMaintenanceAddRadioItem3.setGroup(getOralMaintenanceAddRadio());

      oralMaintenanceAddRadioItem3.setConstraints(VRLayout.FLOW);

      addOralMaintenanceAddRadioItem3();
    }
    return oralMaintenanceAddRadioItem3;

  }

  /**
   * ���o�@�\�ێ��Ǘ����Z���擾���܂��B
   * @return ���o�@�\�ێ��Ǘ����Z
   */
  public ACValueArrayRadioButtonGroup getYoungDementiaPatinetAddRadioGroup(){
    if(youngDementiaPatinetAddRadioGroup==null){

      youngDementiaPatinetAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getYoungDementiaPatinetAddRadioGroupContainer().setText("���o�@�\�ێ��Ǘ����Z");

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
   * ���o�@�\�ێ��Ǘ����Z�R���e�i���擾���܂��B
   * @return ���o�@�\�ێ��Ǘ����Z�R���e�i
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
   * ���o�@�\�ێ��Ǘ����Z���f�����擾���܂��B
   * @return ���o�@�\�ێ��Ǘ����Z���f��
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
  public ACClearableRadioButtonGroup getMedicalFacilityCognitiveHospitalRecuperateDinnerRadio(){
    if(medicalFacilityCognitiveHospitalRecuperateDinnerRadio==null){

      medicalFacilityCognitiveHospitalRecuperateDinnerRadio = new ACClearableRadioButtonGroup();

      getMedicalFacilityCognitiveHospitalRecuperateDinnerRadioContainer().setText("�×{�H���Z");

      medicalFacilityCognitiveHospitalRecuperateDinnerRadio.setBindPath("1530311");

      medicalFacilityCognitiveHospitalRecuperateDinnerRadio.setUseClearButton(false);

      medicalFacilityCognitiveHospitalRecuperateDinnerRadio.setModel(getMedicalFacilityCognitiveHospitalRecuperateDinnerRadioModel());

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
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getMedicalFacilityCognitiveHospitalRecuperateDinnerRadioItem2(){
    if(medicalFacilityCognitiveHospitalRecuperateDinnerRadioItem2==null){

      medicalFacilityCognitiveHospitalRecuperateDinnerRadioItem2 = new ACRadioButtonItem();

      medicalFacilityCognitiveHospitalRecuperateDinnerRadioItem2.setText("����");

      medicalFacilityCognitiveHospitalRecuperateDinnerRadioItem2.setGroup(getMedicalFacilityCognitiveHospitalRecuperateDinnerRadio());

      medicalFacilityCognitiveHospitalRecuperateDinnerRadioItem2.setConstraints(VRLayout.FLOW);

      addMedicalFacilityCognitiveHospitalRecuperateDinnerRadioItem2();
    }
    return medicalFacilityCognitiveHospitalRecuperateDinnerRadioItem2;

  }

  /**
   * �ޏ��֘A���Z���擾���܂��B
   * @return �ޏ��֘A���Z
   */
  public ACLabelContainer getMedicalFacilityCognitiveHospitalHijoAddition(){
    if(medicalFacilityCognitiveHospitalHijoAddition==null){

      medicalFacilityCognitiveHospitalHijoAddition = new ACLabelContainer();

      medicalFacilityCognitiveHospitalHijoAddition.setText("�މ@�֘A���Z");

      addMedicalFacilityCognitiveHospitalHijoAddition();
    }
    return medicalFacilityCognitiveHospitalHijoAddition;

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
   * ���j�b�g�P�A�̐������擾���܂��B
   * @return ���j�b�g�P�A�̐���
   */
  public ACClearableRadioButtonGroup getUnitCareMaintenanceRadio(){
    if(unitCareMaintenanceRadio==null){

      unitCareMaintenanceRadio = new ACClearableRadioButtonGroup();

      getUnitCareMaintenanceRadioContainer().setText("���j�b�g�P�A�̐���");

      unitCareMaintenanceRadio.setBindPath("1530313");

      unitCareMaintenanceRadio.setUseClearButton(false);

      unitCareMaintenanceRadio.setModel(getUnitCareMaintenanceRadioModel());

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

      bodyRestraintAbolitionRadio.setBindPath("1530314");

      bodyRestraintAbolitionRadio.setUseClearButton(false);

      bodyRestraintAbolitionRadio.setModel(getBodyRestraintAbolitionRadioModel());

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

      stayReturnSupportAddRadio.setBindPath("1530315");

      stayReturnSupportAddRadio.setUseClearButton(false);

      stayReturnSupportAddRadio.setModel(getStayReturnSupportAddRadioModel());

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
   * �Z��敪���擾���܂��B
   * @return �Z��敪
   */
  public ACClearableRadioButtonGroup getMedicalFacilityCognitiveHospitalCalculationDivisionRadio(){
    if(medicalFacilityCognitiveHospitalCalculationDivisionRadio==null){

      medicalFacilityCognitiveHospitalCalculationDivisionRadio = new ACClearableRadioButtonGroup();

      getMedicalFacilityCognitiveHospitalCalculationDivisionRadioContainer().setText("�Z��敪");

      medicalFacilityCognitiveHospitalCalculationDivisionRadio.setBindPath("9");

      medicalFacilityCognitiveHospitalCalculationDivisionRadio.setUseClearButton(false);

      medicalFacilityCognitiveHospitalCalculationDivisionRadio.setModel(getMedicalFacilityCognitiveHospitalCalculationDivisionRadioModel());

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
  public QS001122_H2104Design() {

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

    tab1.add(getMedicalFacilityCognitiveHospitalInstitutionDivisionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getMedicalFacilityCognitiveHospitalHospitalDivisionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getHospitalDivisionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getMedicalFacilityCognitiveHospitalHospitalRoomContena(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getMedicalFacilityCognitiveHospitalStayRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getMedicalFacilityCognitiveHospitalStandardRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getMedicalFacilityCognitiveHospitalMedicalExaminationRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getMedicalFacilityCognitiveHospitalNutritionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

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
   * ���j�b�g�^�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityCognitiveHospitalUnitHospitalRoomRadioItem2(){

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
   * �^�u2�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTab2(){

    tab2.add(getMedicalFacilityCognitiveHospitalOralSwitchRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getOralMaintenanceAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getYoungDementiaPatinetAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getMedicalFacilityCognitiveHospitalRecuperateDinnerRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getMedicalFacilityCognitiveHospitalHijoAddition(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getMedicalFacilityCognitiveHospitalConsultationFee(), VRLayout.FLOW);

    tab2.add(getMedicalFacilityCognitiveHospitalConsultationFeeLabel(), VRLayout.FLOW_RETURN);

    tab2.add(getMedicalFacilityCognitiveHospitalSubstractionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getMedicalFacilityCognitiveHospitalDinnerContainer(), VRLayout.FLOW_DOUBLEINSETLINE_RETURN);

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
   * �o���ێ����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addOralMaintenanceAddRadio(){

  }

  /**
   * �o���ێ����Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addOralMaintenanceAddRadioModel(){

    getOralMaintenanceAddRadioItem1().setButtonIndex(1);

    getOralMaintenanceAddRadioModel().add(getOralMaintenanceAddRadioItem1());

    getOralMaintenanceAddRadioItem2().setButtonIndex(2);

    getOralMaintenanceAddRadioModel().add(getOralMaintenanceAddRadioItem2());

    getOralMaintenanceAddRadioItem3().setButtonIndex(3);

    getOralMaintenanceAddRadioModel().add(getOralMaintenanceAddRadioItem3());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addOralMaintenanceAddRadioItem1(){

  }

  /**
   * I�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addOralMaintenanceAddRadioItem2(){

  }

  /**
   * II�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addOralMaintenanceAddRadioItem3(){

  }

  /**
   * ���o�@�\�ێ��Ǘ����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addYoungDementiaPatinetAddRadioGroup(){

  }

  /**
   * ���o�@�\�ێ��Ǘ����Z���f���ɓ������ڂ�ǉ����܂��B
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

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityCognitiveHospitalRecuperateDinnerRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityCognitiveHospitalRecuperateDinnerRadioItem2(){

  }

  /**
   * �ޏ��֘A���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityCognitiveHospitalHijoAddition(){

    medicalFacilityCognitiveHospitalHijoAddition.add(getLeavingHospitalPreConsultationAddition(), VRLayout.FLOW_RETURN);

    medicalFacilityCognitiveHospitalHijoAddition.add(getLeavingHospitalConsultationAddition(), VRLayout.FLOW_RETURN);

    medicalFacilityCognitiveHospitalHijoAddition.add(getLeavingHospitalDissemination(), VRLayout.FLOW_RETURN);

    medicalFacilityCognitiveHospitalHijoAddition.add(getLeavingHospitalCooperationAddition(), VRLayout.FLOW_RETURN);

    medicalFacilityCognitiveHospitalHijoAddition.add(getLeavingHospital(), VRLayout.FLOW_RETURN);

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
   * �^�u3�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTab3(){

    tab3.add(getUnitCareMaintenanceRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab3.add(getBodyRestraintAbolitionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab3.add(getStayReturnSupportAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab3.add(getServiceAddProvisionStructuralRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab3.add(getMedicalFacilityCognitiveHospitalCalculationDivisionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

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
      ACFrame.debugStart(new ACAffairInfo(QS001122_H2104Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QS001122_H2104Design getThis() {
    return this;
  }
}
