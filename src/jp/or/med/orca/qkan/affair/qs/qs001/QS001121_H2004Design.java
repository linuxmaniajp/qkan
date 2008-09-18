
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
 * �쐬��: 2008/03/18  ���{�R���s���[�^�[������� ����@��F �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �T�[�r�X�\��쐬/�ύX (S)
 * �v���Z�X �T�[�r�X�\��T�� (001)
 * �v���O���� �T�[�r�X�p�^�[�����×{�^��Î{�݁i�f�Ï��j (QS001121_H2004)
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
 * �T�[�r�X�p�^�[�����×{�^��Î{�݁i�f�Ï��j��ʍ��ڃf�U�C��(QS001121_H2004) 
 */
public class QS001121_H2004Design extends QS001ServicePanel {
  //GUI�R���|�[�l���g

  private JTabbedPane tabs;

  private ACPanel tab1;

  private ACClearableRadioButtonGroup medicalFacilityClinicInstitutionDivisionRadio;

  private ACLabelContainer medicalFacilityClinicInstitutionDivisionRadioContainer;

  private ACListModelAdapter medicalFacilityClinicInstitutionDivisionRadioModel;

  private ACRadioButtonItem medicalFacilityClinicInstitutionDivisionRadioItem1;

  private ACRadioButtonItem medicalFacilityClinicInstitutionDivisionRadioItem2;

  private ACClearableRadioButtonGroup medicalFacilityClinicDivision;

  private ACLabelContainer medicalFacilityClinicDivisionContainer;

  private ACListModelAdapter medicalFacilityClinicDivisionModel;

  private ACRadioButtonItem medicalFacilityClinicDivision1;

  private ACRadioButtonItem medicalFacilityClinicDivision2;

  private ACLabelContainer medicalFacilityClinicHospitalRoomContena;

  private ACClearableRadioButtonGroup medicalFacilityClinicHospitalRoomRadio;

  private ACListModelAdapter medicalFacilityClinicHospitalRoomRadioModel;

  private ACRadioButtonItem medicalFacilityClinicHospitalRoomRadioItem1;

  private ACRadioButtonItem medicalFacilityClinicHospitalRoomRadioItem2;

  private ACClearableRadioButtonGroup medicalFacilityClinicUnitHospitalRoomRadio;

  private ACListModelAdapter medicalFacilityClinicUnitHospitalRoomRadioModel;

  private ACRadioButtonItem medicalFacilityClinicUnitHospitalRoomRadioItem1;

  private ACRadioButtonItem medicalFacilityClinicUnitHospitalRoomRadioItem2;

  private ACValueArrayRadioButtonGroup medicalFacilityClinicEnvironmentalRadio;

  private ACLabelContainer medicalFacilityClinicEnvironmentalRadioContainer;

  private ACListModelAdapter medicalFacilityClinicEnvironmentalRadioModel;

  private ACRadioButtonItem medicalFacilityClinicEnvironmentalRadioItem1;

  private ACRadioButtonItem medicalFacilityClinicEnvironmentalRadioItem3;

  private ACValueArrayRadioButtonGroup medicalFacilityClinicProvisionBaseRadio;

  private ACLabelContainer medicalFacilityClinicProvisionBaseRadioContainer;

  private ACListModelAdapter medicalFacilityClinicProvisionBaseRadioModel;

  private ACRadioButtonItem medicalFacilityClinicProvisionBaseRadioItem1;

  private ACRadioButtonItem medicalFacilityClinicProvisionBaseRadioItem2;

  private ACClearableRadioButtonGroup medicalFacilityClinicStayRadio;

  private ACLabelContainer medicalFacilityClinicStayRadioContainer;

  private ACListModelAdapter medicalFacilityClinicStayRadioModel;

  private ACRadioButtonItem medicalFacilityClinicStayRadioItem1;

  private ACRadioButtonItem medicalFacilityClinicStayRadioItem2;

  private ACClearableRadioButtonGroup medicalFacilityClinicStandardRadio;

  private ACLabelContainer medicalFacilityClinicStandardRadioContainer;

  private ACListModelAdapter medicalFacilityClinicStandardRadioModel;

  private ACRadioButtonItem medicalFacilityClinicStandardRadioItem1;

  private ACRadioButtonItem medicalFacilityClinicStandardRadioItem2;

  private ACClearableRadioButtonGroup medicalFacilityClinicMedicalExaminationRadio;

  private ACLabelContainer medicalFacilityClinicMedicalExaminationRadioContainer;

  private ACListModelAdapter medicalFacilityClinicMedicalExaminationRadioModel;

  private ACRadioButtonItem medicalFacilityClinicMedicalExaminationRadioItem1;

  private ACRadioButtonItem medicalFacilityClinicMedicalExaminationRadioItem2;

  private ACClearableRadioButtonGroup medicalFacilityClinicNutritionManageRadio;

  private ACLabelContainer medicalFacilityClinicNutritionManageRadioContainer;

  private ACListModelAdapter medicalFacilityClinicNutritionManageRadioModel;

  private ACRadioButtonItem medicalFacilityClinicNutritionManageRadioItem1;

  private ACRadioButtonItem medicalFacilityClinicNutritionManageRadioItem2;

  private ACRadioButtonItem medicalFacilityClinicNutritionManageRadioItem3;

  private ACClearableRadioButtonGroup medicalFacilityClinicNutritionRadio;

  private ACLabelContainer medicalFacilityClinicNutritionRadioContainer;

  private ACListModelAdapter medicalFacilityClinicNutritionRadioModel;

  private ACRadioButtonItem medicalFacilityClinicNutritionRadioItem1;

  private ACRadioButtonItem medicalFacilityClinicNutritionRadioItem2;

  private ACPanel tab2;

  private ACClearableRadioButtonGroup medicalFacilityClinicOralSwitchRadio;

  private ACLabelContainer medicalFacilityClinicOralSwitchRadioContainer;

  private ACListModelAdapter medicalFacilityClinicOralSwitchRadioModel;

  private ACRadioButtonItem medicalFacilityClinicOralSwitchRadioItem1;

  private ACRadioButtonItem medicalFacilityClinicOralSwitchRadioItem2;

  private ACClearableRadioButtonGroup oralMaintenanceAddRadio;

  private ACLabelContainer oralMaintenanceAddRadioContainer;

  private ACListModelAdapter oralMaintenanceAddRadioModel;

  private ACRadioButtonItem oralMaintenanceAddRadioItem1;

  private ACRadioButtonItem oralMaintenanceAddRadioItem2;

  private ACRadioButtonItem oralMaintenanceAddRadioItem3;

  private ACClearableRadioButtonGroup medicalFacilityClinicRecuperateDinnerRadio;

  private ACLabelContainer medicalFacilityClinicRecuperateDinnerRadioContainer;

  private ACListModelAdapter medicalFacilityClinicRecuperateDinnerRadioModel;

  private ACRadioButtonItem medicalFacilityClinicRecuperateDinnerRadioItem1;

  private ACRadioButtonItem medicalFacilityClinicRecuperateDinnerRadioItem2;

  private ACLabelContainer medicalFacilityClinicHijoAddition;

  private ACIntegerCheckBox leavingHospitalPreConsultationAddition;

  private ACIntegerCheckBox leavingHospitalConsultationAddition;

  private ACIntegerCheckBox leavingHospitalDissemination;

  private ACIntegerCheckBox leavingHospitalCooperationAddition;

  private ACIntegerCheckBox leavingHospital;

  private ACMapBindButton medicalFacilityClinicConsultationFee;

  private ACLabel medicalFacilityClinicConsultationFeeLabel;

  private ACClearableRadioButtonGroup medicalFacilityClinicSubstractionRadio;

  private ACLabelContainer medicalFacilityClinicSubstractionRadioContainer;

  private ACListModelAdapter medicalFacilityClinicSubstractionRadioModel;

  private ACRadioButtonItem medicalFacilityClinicSubstractionRadioItem1;

  private ACRadioButtonItem medicalFacilityClinicSubstractionRadioItem2;

  private ACBackLabelContainer medicalFacilityClinicDinnerContainer;

  private ACComboBox medicalFacilityClinicDinnerOffer;

  private ACLabelContainer medicalFacilityClinicDinnerOfferContainer;

  private ACComboBoxModelAdapter medicalFacilityClinicDinnerOfferModel;

  private ACTextField medicalFacilityClinicDinnerCost;

  private ACLabelContainer medicalFacilityClinicDinnerCostContainer;

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

  private ACRadioButtonItem stayReturnSupportAddRadioItem1;

  private ACRadioButtonItem stayReturnSupportAddRadioItem2;

  private ACClearableRadioButtonGroup medicalFacilityClinicCalculationDivisionRadio;

  private ACLabelContainer medicalFacilityClinicCalculationDivisionRadioContainer;

  private ACListModelAdapter medicalFacilityClinicCalculationDivisionRadioModel;

  private ACRadioButtonItem medicalFacilityClinicCalculationDivisionRadioItem1;

  private ACRadioButtonItem medicalFacilityClinicCalculationDivisionRadioItem2;

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
  public ACClearableRadioButtonGroup getMedicalFacilityClinicInstitutionDivisionRadio(){
    if(medicalFacilityClinicInstitutionDivisionRadio==null){

      medicalFacilityClinicInstitutionDivisionRadio = new ACClearableRadioButtonGroup();

      getMedicalFacilityClinicInstitutionDivisionRadioContainer().setText("�{�ݓ��̋敪");

      medicalFacilityClinicInstitutionDivisionRadio.setBindPath("1530201");

      medicalFacilityClinicInstitutionDivisionRadio.setUseClearButton(false);

      medicalFacilityClinicInstitutionDivisionRadio.setModel(getMedicalFacilityClinicInstitutionDivisionRadioModel());

      addMedicalFacilityClinicInstitutionDivisionRadio();
    }
    return medicalFacilityClinicInstitutionDivisionRadio;

  }

  /**
   * �{�ݓ��̋敪�R���e�i���擾���܂��B
   * @return �{�ݓ��̋敪�R���e�i
   */
  protected ACLabelContainer getMedicalFacilityClinicInstitutionDivisionRadioContainer(){
    if(medicalFacilityClinicInstitutionDivisionRadioContainer==null){
      medicalFacilityClinicInstitutionDivisionRadioContainer = new ACLabelContainer();
      medicalFacilityClinicInstitutionDivisionRadioContainer.setFollowChildEnabled(true);
      medicalFacilityClinicInstitutionDivisionRadioContainer.setVAlignment(VRLayout.CENTER);
      medicalFacilityClinicInstitutionDivisionRadioContainer.add(getMedicalFacilityClinicInstitutionDivisionRadio(), null);
    }
    return medicalFacilityClinicInstitutionDivisionRadioContainer;
  }

  /**
   * �{�ݓ��̋敪���f�����擾���܂��B
   * @return �{�ݓ��̋敪���f��
   */
  protected ACListModelAdapter getMedicalFacilityClinicInstitutionDivisionRadioModel(){
    if(medicalFacilityClinicInstitutionDivisionRadioModel==null){
      medicalFacilityClinicInstitutionDivisionRadioModel = new ACListModelAdapter();
      addMedicalFacilityClinicInstitutionDivisionRadioModel();
    }
    return medicalFacilityClinicInstitutionDivisionRadioModel;
  }

  /**
   * �f�Ï����擾���܂��B
   * @return �f�Ï�
   */
  public ACRadioButtonItem getMedicalFacilityClinicInstitutionDivisionRadioItem1(){
    if(medicalFacilityClinicInstitutionDivisionRadioItem1==null){

      medicalFacilityClinicInstitutionDivisionRadioItem1 = new ACRadioButtonItem();

      medicalFacilityClinicInstitutionDivisionRadioItem1.setText("�f�Ï�");

      medicalFacilityClinicInstitutionDivisionRadioItem1.setGroup(getMedicalFacilityClinicInstitutionDivisionRadio());

      medicalFacilityClinicInstitutionDivisionRadioItem1.setConstraints(VRLayout.FLOW);

      addMedicalFacilityClinicInstitutionDivisionRadioItem1();
    }
    return medicalFacilityClinicInstitutionDivisionRadioItem1;

  }

  /**
   * ���j�b�g�^�f�Ï����擾���܂��B
   * @return ���j�b�g�^�f�Ï�
   */
  public ACRadioButtonItem getMedicalFacilityClinicInstitutionDivisionRadioItem2(){
    if(medicalFacilityClinicInstitutionDivisionRadioItem2==null){

      medicalFacilityClinicInstitutionDivisionRadioItem2 = new ACRadioButtonItem();

      medicalFacilityClinicInstitutionDivisionRadioItem2.setText("���j�b�g�^�f�Ï�");

      medicalFacilityClinicInstitutionDivisionRadioItem2.setGroup(getMedicalFacilityClinicInstitutionDivisionRadio());

      medicalFacilityClinicInstitutionDivisionRadioItem2.setConstraints(VRLayout.FLOW);

      addMedicalFacilityClinicInstitutionDivisionRadioItem2();
    }
    return medicalFacilityClinicInstitutionDivisionRadioItem2;

  }

  /**
   * �l���z�u�敪���擾���܂��B
   * @return �l���z�u�敪
   */
  public ACClearableRadioButtonGroup getMedicalFacilityClinicDivision(){
    if(medicalFacilityClinicDivision==null){

      medicalFacilityClinicDivision = new ACClearableRadioButtonGroup();

      getMedicalFacilityClinicDivisionContainer().setText("�l���z�u�敪");

      medicalFacilityClinicDivision.setBindPath("1530202");

      medicalFacilityClinicDivision.setUseClearButton(false);

      medicalFacilityClinicDivision.setModel(getMedicalFacilityClinicDivisionModel());

      addMedicalFacilityClinicDivision();
    }
    return medicalFacilityClinicDivision;

  }

  /**
   * �l���z�u�敪�R���e�i���擾���܂��B
   * @return �l���z�u�敪�R���e�i
   */
  protected ACLabelContainer getMedicalFacilityClinicDivisionContainer(){
    if(medicalFacilityClinicDivisionContainer==null){
      medicalFacilityClinicDivisionContainer = new ACLabelContainer();
      medicalFacilityClinicDivisionContainer.setFollowChildEnabled(true);
      medicalFacilityClinicDivisionContainer.setVAlignment(VRLayout.CENTER);
      medicalFacilityClinicDivisionContainer.add(getMedicalFacilityClinicDivision(), null);
    }
    return medicalFacilityClinicDivisionContainer;
  }

  /**
   * �l���z�u�敪���f�����擾���܂��B
   * @return �l���z�u�敪���f��
   */
  protected ACListModelAdapter getMedicalFacilityClinicDivisionModel(){
    if(medicalFacilityClinicDivisionModel==null){
      medicalFacilityClinicDivisionModel = new ACListModelAdapter();
      addMedicalFacilityClinicDivisionModel();
    }
    return medicalFacilityClinicDivisionModel;
  }

  /**
   * I�^���擾���܂��B
   * @return I�^
   */
  public ACRadioButtonItem getMedicalFacilityClinicDivision1(){
    if(medicalFacilityClinicDivision1==null){

      medicalFacilityClinicDivision1 = new ACRadioButtonItem();

      medicalFacilityClinicDivision1.setText("I�^");

      medicalFacilityClinicDivision1.setGroup(getMedicalFacilityClinicDivision());

      medicalFacilityClinicDivision1.setConstraints(VRLayout.FLOW);

      addMedicalFacilityClinicDivision1();
    }
    return medicalFacilityClinicDivision1;

  }

  /**
   * II�^���擾���܂��B
   * @return II�^
   */
  public ACRadioButtonItem getMedicalFacilityClinicDivision2(){
    if(medicalFacilityClinicDivision2==null){

      medicalFacilityClinicDivision2 = new ACRadioButtonItem();

      medicalFacilityClinicDivision2.setText("II�^");

      medicalFacilityClinicDivision2.setGroup(getMedicalFacilityClinicDivision());

      medicalFacilityClinicDivision2.setConstraints(VRLayout.FLOW);

      addMedicalFacilityClinicDivision2();
    }
    return medicalFacilityClinicDivision2;

  }

  /**
   * �a���敪�R���e�i���擾���܂��B
   * @return �a���敪�R���e�i
   */
  public ACLabelContainer getMedicalFacilityClinicHospitalRoomContena(){
    if(medicalFacilityClinicHospitalRoomContena==null){

      medicalFacilityClinicHospitalRoomContena = new ACLabelContainer();

      medicalFacilityClinicHospitalRoomContena.setText("�a���敪");

      addMedicalFacilityClinicHospitalRoomContena();
    }
    return medicalFacilityClinicHospitalRoomContena;

  }

  /**
   * �a���敪�i�a�@�j���擾���܂��B
   * @return �a���敪�i�a�@�j
   */
  public ACClearableRadioButtonGroup getMedicalFacilityClinicHospitalRoomRadio(){
    if(medicalFacilityClinicHospitalRoomRadio==null){

      medicalFacilityClinicHospitalRoomRadio = new ACClearableRadioButtonGroup();

      medicalFacilityClinicHospitalRoomRadio.setBindPath("1530203");

      medicalFacilityClinicHospitalRoomRadio.setUseClearButton(false);

      medicalFacilityClinicHospitalRoomRadio.setModel(getMedicalFacilityClinicHospitalRoomRadioModel());

      addMedicalFacilityClinicHospitalRoomRadio();
    }
    return medicalFacilityClinicHospitalRoomRadio;

  }

  /**
   * �a���敪�i�a�@�j���f�����擾���܂��B
   * @return �a���敪�i�a�@�j���f��
   */
  protected ACListModelAdapter getMedicalFacilityClinicHospitalRoomRadioModel(){
    if(medicalFacilityClinicHospitalRoomRadioModel==null){
      medicalFacilityClinicHospitalRoomRadioModel = new ACListModelAdapter();
      addMedicalFacilityClinicHospitalRoomRadioModel();
    }
    return medicalFacilityClinicHospitalRoomRadioModel;
  }

  /**
   * �]���^�����擾���܂��B
   * @return �]���^��
   */
  public ACRadioButtonItem getMedicalFacilityClinicHospitalRoomRadioItem1(){
    if(medicalFacilityClinicHospitalRoomRadioItem1==null){

      medicalFacilityClinicHospitalRoomRadioItem1 = new ACRadioButtonItem();

      medicalFacilityClinicHospitalRoomRadioItem1.setText("�]���^��");

      medicalFacilityClinicHospitalRoomRadioItem1.setGroup(getMedicalFacilityClinicHospitalRoomRadio());

      medicalFacilityClinicHospitalRoomRadioItem1.setConstraints(VRLayout.FLOW);

      addMedicalFacilityClinicHospitalRoomRadioItem1();
    }
    return medicalFacilityClinicHospitalRoomRadioItem1;

  }

  /**
   * ���������擾���܂��B
   * @return ������
   */
  public ACRadioButtonItem getMedicalFacilityClinicHospitalRoomRadioItem2(){
    if(medicalFacilityClinicHospitalRoomRadioItem2==null){

      medicalFacilityClinicHospitalRoomRadioItem2 = new ACRadioButtonItem();

      medicalFacilityClinicHospitalRoomRadioItem2.setText("������");

      medicalFacilityClinicHospitalRoomRadioItem2.setGroup(getMedicalFacilityClinicHospitalRoomRadio());

      medicalFacilityClinicHospitalRoomRadioItem2.setConstraints(VRLayout.FLOW);

      addMedicalFacilityClinicHospitalRoomRadioItem2();
    }
    return medicalFacilityClinicHospitalRoomRadioItem2;

  }

  /**
   * �a���敪�i���j�b�g�^�j���擾���܂��B
   * @return �a���敪�i���j�b�g�^�j
   */
  public ACClearableRadioButtonGroup getMedicalFacilityClinicUnitHospitalRoomRadio(){
    if(medicalFacilityClinicUnitHospitalRoomRadio==null){

      medicalFacilityClinicUnitHospitalRoomRadio = new ACClearableRadioButtonGroup();

      medicalFacilityClinicUnitHospitalRoomRadio.setBindPath("1530204");

      medicalFacilityClinicUnitHospitalRoomRadio.setUseClearButton(false);

      medicalFacilityClinicUnitHospitalRoomRadio.setModel(getMedicalFacilityClinicUnitHospitalRoomRadioModel());

      addMedicalFacilityClinicUnitHospitalRoomRadio();
    }
    return medicalFacilityClinicUnitHospitalRoomRadio;

  }

  /**
   * �a���敪�i���j�b�g�^�j���f�����擾���܂��B
   * @return �a���敪�i���j�b�g�^�j���f��
   */
  protected ACListModelAdapter getMedicalFacilityClinicUnitHospitalRoomRadioModel(){
    if(medicalFacilityClinicUnitHospitalRoomRadioModel==null){
      medicalFacilityClinicUnitHospitalRoomRadioModel = new ACListModelAdapter();
      addMedicalFacilityClinicUnitHospitalRoomRadioModel();
    }
    return medicalFacilityClinicUnitHospitalRoomRadioModel;
  }

  /**
   * ���j�b�g�^�����擾���܂��B
   * @return ���j�b�g�^��
   */
  public ACRadioButtonItem getMedicalFacilityClinicUnitHospitalRoomRadioItem1(){
    if(medicalFacilityClinicUnitHospitalRoomRadioItem1==null){

      medicalFacilityClinicUnitHospitalRoomRadioItem1 = new ACRadioButtonItem();

      medicalFacilityClinicUnitHospitalRoomRadioItem1.setText("���j�b�g�^��");

      medicalFacilityClinicUnitHospitalRoomRadioItem1.setGroup(getMedicalFacilityClinicUnitHospitalRoomRadio());

      medicalFacilityClinicUnitHospitalRoomRadioItem1.setConstraints(VRLayout.FLOW);

      addMedicalFacilityClinicUnitHospitalRoomRadioItem1();
    }
    return medicalFacilityClinicUnitHospitalRoomRadioItem1;

  }

  /**
   * ���j�b�g�^�������擾���܂��B
   * @return ���j�b�g�^����
   */
  public ACRadioButtonItem getMedicalFacilityClinicUnitHospitalRoomRadioItem2(){
    if(medicalFacilityClinicUnitHospitalRoomRadioItem2==null){

      medicalFacilityClinicUnitHospitalRoomRadioItem2 = new ACRadioButtonItem();

      medicalFacilityClinicUnitHospitalRoomRadioItem2.setText("���j�b�g�^����");

      medicalFacilityClinicUnitHospitalRoomRadioItem2.setGroup(getMedicalFacilityClinicUnitHospitalRoomRadio());

      medicalFacilityClinicUnitHospitalRoomRadioItem2.setConstraints(VRLayout.FLOW);

      addMedicalFacilityClinicUnitHospitalRoomRadioItem2();
    }
    return medicalFacilityClinicUnitHospitalRoomRadioItem2;

  }

  /**
   * �×{������擾���܂��B
   * @return �×{���
   */
  public ACValueArrayRadioButtonGroup getMedicalFacilityClinicEnvironmentalRadio(){
    if(medicalFacilityClinicEnvironmentalRadio==null){

      medicalFacilityClinicEnvironmentalRadio = new ACValueArrayRadioButtonGroup();

      getMedicalFacilityClinicEnvironmentalRadioContainer().setText("�×{���");

      medicalFacilityClinicEnvironmentalRadio.setBindPath("1530205");

      medicalFacilityClinicEnvironmentalRadio.setNoSelectIndex(0);

      medicalFacilityClinicEnvironmentalRadio.setUseClearButton(false);

      medicalFacilityClinicEnvironmentalRadio.setModel(getMedicalFacilityClinicEnvironmentalRadioModel());

      medicalFacilityClinicEnvironmentalRadio.setValues(new int[]{1,3});

      addMedicalFacilityClinicEnvironmentalRadio();
    }
    return medicalFacilityClinicEnvironmentalRadio;

  }

  /**
   * �×{����R���e�i���擾���܂��B
   * @return �×{����R���e�i
   */
  protected ACLabelContainer getMedicalFacilityClinicEnvironmentalRadioContainer(){
    if(medicalFacilityClinicEnvironmentalRadioContainer==null){
      medicalFacilityClinicEnvironmentalRadioContainer = new ACLabelContainer();
      medicalFacilityClinicEnvironmentalRadioContainer.setFollowChildEnabled(true);
      medicalFacilityClinicEnvironmentalRadioContainer.setVAlignment(VRLayout.CENTER);
      medicalFacilityClinicEnvironmentalRadioContainer.add(getMedicalFacilityClinicEnvironmentalRadio(), null);
    }
    return medicalFacilityClinicEnvironmentalRadioContainer;
  }

  /**
   * �×{������f�����擾���܂��B
   * @return �×{������f��
   */
  protected ACListModelAdapter getMedicalFacilityClinicEnvironmentalRadioModel(){
    if(medicalFacilityClinicEnvironmentalRadioModel==null){
      medicalFacilityClinicEnvironmentalRadioModel = new ACListModelAdapter();
      addMedicalFacilityClinicEnvironmentalRadioModel();
    }
    return medicalFacilityClinicEnvironmentalRadioModel;
  }

  /**
   * ��^���擾���܂��B
   * @return ��^
   */
  public ACRadioButtonItem getMedicalFacilityClinicEnvironmentalRadioItem1(){
    if(medicalFacilityClinicEnvironmentalRadioItem1==null){

      medicalFacilityClinicEnvironmentalRadioItem1 = new ACRadioButtonItem();

      medicalFacilityClinicEnvironmentalRadioItem1.setText("��^");

      medicalFacilityClinicEnvironmentalRadioItem1.setGroup(getMedicalFacilityClinicEnvironmentalRadio());

      medicalFacilityClinicEnvironmentalRadioItem1.setConstraints(VRLayout.FLOW);

      addMedicalFacilityClinicEnvironmentalRadioItem1();
    }
    return medicalFacilityClinicEnvironmentalRadioItem1;

  }

  /**
   * ���ZII���擾���܂��B
   * @return ���ZII
   */
  public ACRadioButtonItem getMedicalFacilityClinicEnvironmentalRadioItem3(){
    if(medicalFacilityClinicEnvironmentalRadioItem3==null){

      medicalFacilityClinicEnvironmentalRadioItem3 = new ACRadioButtonItem();

      medicalFacilityClinicEnvironmentalRadioItem3.setText("���Z�^II");

      medicalFacilityClinicEnvironmentalRadioItem3.setGroup(getMedicalFacilityClinicEnvironmentalRadio());

      medicalFacilityClinicEnvironmentalRadioItem3.setConstraints(VRLayout.FLOW);

      addMedicalFacilityClinicEnvironmentalRadioItem3();
    }
    return medicalFacilityClinicEnvironmentalRadioItem3;

  }

  /**
   * �ݔ������擾���܂��B
   * @return �ݔ���
   */
  public ACValueArrayRadioButtonGroup getMedicalFacilityClinicProvisionBaseRadio(){
    if(medicalFacilityClinicProvisionBaseRadio==null){

      medicalFacilityClinicProvisionBaseRadio = new ACValueArrayRadioButtonGroup();

      getMedicalFacilityClinicProvisionBaseRadioContainer().setText("�ݔ�����Z");

      medicalFacilityClinicProvisionBaseRadio.setBindPath("1530260");

      medicalFacilityClinicProvisionBaseRadio.setNoSelectIndex(0);

      medicalFacilityClinicProvisionBaseRadio.setUseClearButton(false);

      medicalFacilityClinicProvisionBaseRadio.setModel(getMedicalFacilityClinicProvisionBaseRadioModel());

      medicalFacilityClinicProvisionBaseRadio.setValues(new int[]{1,2});

      addMedicalFacilityClinicProvisionBaseRadio();
    }
    return medicalFacilityClinicProvisionBaseRadio;

  }

  /**
   * �ݔ����R���e�i���擾���܂��B
   * @return �ݔ����R���e�i
   */
  protected ACLabelContainer getMedicalFacilityClinicProvisionBaseRadioContainer(){
    if(medicalFacilityClinicProvisionBaseRadioContainer==null){
      medicalFacilityClinicProvisionBaseRadioContainer = new ACLabelContainer();
      medicalFacilityClinicProvisionBaseRadioContainer.setFollowChildEnabled(true);
      medicalFacilityClinicProvisionBaseRadioContainer.setVAlignment(VRLayout.CENTER);
      medicalFacilityClinicProvisionBaseRadioContainer.add(getMedicalFacilityClinicProvisionBaseRadio(), null);
    }
    return medicalFacilityClinicProvisionBaseRadioContainer;
  }

  /**
   * �ݔ������f�����擾���܂��B
   * @return �ݔ������f��
   */
  protected ACListModelAdapter getMedicalFacilityClinicProvisionBaseRadioModel(){
    if(medicalFacilityClinicProvisionBaseRadioModel==null){
      medicalFacilityClinicProvisionBaseRadioModel = new ACListModelAdapter();
      addMedicalFacilityClinicProvisionBaseRadioModel();
    }
    return medicalFacilityClinicProvisionBaseRadioModel;
  }

  /**
   * ��^���擾���܂��B
   * @return ��^
   */
  public ACRadioButtonItem getMedicalFacilityClinicProvisionBaseRadioItem1(){
    if(medicalFacilityClinicProvisionBaseRadioItem1==null){

      medicalFacilityClinicProvisionBaseRadioItem1 = new ACRadioButtonItem();

      medicalFacilityClinicProvisionBaseRadioItem1.setText("��^");

      medicalFacilityClinicProvisionBaseRadioItem1.setGroup(getMedicalFacilityClinicProvisionBaseRadio());

      medicalFacilityClinicProvisionBaseRadioItem1.setConstraints(VRLayout.FLOW);

      addMedicalFacilityClinicProvisionBaseRadioItem1();
    }
    return medicalFacilityClinicProvisionBaseRadioItem1;

  }

  /**
   * ���Z�^���擾���܂��B
   * @return ���Z�^
   */
  public ACRadioButtonItem getMedicalFacilityClinicProvisionBaseRadioItem2(){
    if(medicalFacilityClinicProvisionBaseRadioItem2==null){

      medicalFacilityClinicProvisionBaseRadioItem2 = new ACRadioButtonItem();

      medicalFacilityClinicProvisionBaseRadioItem2.setText("���Z�^");

      medicalFacilityClinicProvisionBaseRadioItem2.setGroup(getMedicalFacilityClinicProvisionBaseRadio());

      medicalFacilityClinicProvisionBaseRadioItem2.setConstraints(VRLayout.FLOW);

      addMedicalFacilityClinicProvisionBaseRadioItem2();
    }
    return medicalFacilityClinicProvisionBaseRadioItem2;

  }

  /**
   * �O�����Z���擾���܂��B
   * @return �O�����Z
   */
  public ACClearableRadioButtonGroup getMedicalFacilityClinicStayRadio(){
    if(medicalFacilityClinicStayRadio==null){

      medicalFacilityClinicStayRadio = new ACClearableRadioButtonGroup();

      getMedicalFacilityClinicStayRadioContainer().setText("�O�����Z");

      medicalFacilityClinicStayRadio.setBindPath("1530206");

      medicalFacilityClinicStayRadio.setUseClearButton(false);

      medicalFacilityClinicStayRadio.setModel(getMedicalFacilityClinicStayRadioModel());

      addMedicalFacilityClinicStayRadio();
    }
    return medicalFacilityClinicStayRadio;

  }

  /**
   * �O�����Z�R���e�i���擾���܂��B
   * @return �O�����Z�R���e�i
   */
  protected ACLabelContainer getMedicalFacilityClinicStayRadioContainer(){
    if(medicalFacilityClinicStayRadioContainer==null){
      medicalFacilityClinicStayRadioContainer = new ACLabelContainer();
      medicalFacilityClinicStayRadioContainer.setFollowChildEnabled(true);
      medicalFacilityClinicStayRadioContainer.setVAlignment(VRLayout.CENTER);
      medicalFacilityClinicStayRadioContainer.add(getMedicalFacilityClinicStayRadio(), null);
    }
    return medicalFacilityClinicStayRadioContainer;
  }

  /**
   * �O�����Z���f�����擾���܂��B
   * @return �O�����Z���f��
   */
  protected ACListModelAdapter getMedicalFacilityClinicStayRadioModel(){
    if(medicalFacilityClinicStayRadioModel==null){
      medicalFacilityClinicStayRadioModel = new ACListModelAdapter();
      addMedicalFacilityClinicStayRadioModel();
    }
    return medicalFacilityClinicStayRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getMedicalFacilityClinicStayRadioItem1(){
    if(medicalFacilityClinicStayRadioItem1==null){

      medicalFacilityClinicStayRadioItem1 = new ACRadioButtonItem();

      medicalFacilityClinicStayRadioItem1.setText("�Ȃ�");

      medicalFacilityClinicStayRadioItem1.setGroup(getMedicalFacilityClinicStayRadio());

      medicalFacilityClinicStayRadioItem1.setConstraints(VRLayout.FLOW);

      addMedicalFacilityClinicStayRadioItem1();
    }
    return medicalFacilityClinicStayRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getMedicalFacilityClinicStayRadioItem2(){
    if(medicalFacilityClinicStayRadioItem2==null){

      medicalFacilityClinicStayRadioItem2 = new ACRadioButtonItem();

      medicalFacilityClinicStayRadioItem2.setText("����");

      medicalFacilityClinicStayRadioItem2.setGroup(getMedicalFacilityClinicStayRadio());

      medicalFacilityClinicStayRadioItem2.setConstraints(VRLayout.FLOW);

      addMedicalFacilityClinicStayRadioItem2();
    }
    return medicalFacilityClinicStayRadioItem2;

  }

  /**
   * �������Z���擾���܂��B
   * @return �������Z
   */
  public ACClearableRadioButtonGroup getMedicalFacilityClinicStandardRadio(){
    if(medicalFacilityClinicStandardRadio==null){

      medicalFacilityClinicStandardRadio = new ACClearableRadioButtonGroup();

      getMedicalFacilityClinicStandardRadioContainer().setText("�������Z");

      medicalFacilityClinicStandardRadio.setBindPath("1530207");

      medicalFacilityClinicStandardRadio.setUseClearButton(false);

      medicalFacilityClinicStandardRadio.setModel(getMedicalFacilityClinicStandardRadioModel());

      addMedicalFacilityClinicStandardRadio();
    }
    return medicalFacilityClinicStandardRadio;

  }

  /**
   * �������Z�R���e�i���擾���܂��B
   * @return �������Z�R���e�i
   */
  protected ACLabelContainer getMedicalFacilityClinicStandardRadioContainer(){
    if(medicalFacilityClinicStandardRadioContainer==null){
      medicalFacilityClinicStandardRadioContainer = new ACLabelContainer();
      medicalFacilityClinicStandardRadioContainer.setFollowChildEnabled(true);
      medicalFacilityClinicStandardRadioContainer.setVAlignment(VRLayout.CENTER);
      medicalFacilityClinicStandardRadioContainer.add(getMedicalFacilityClinicStandardRadio(), null);
    }
    return medicalFacilityClinicStandardRadioContainer;
  }

  /**
   * �������Z���f�����擾���܂��B
   * @return �������Z���f��
   */
  protected ACListModelAdapter getMedicalFacilityClinicStandardRadioModel(){
    if(medicalFacilityClinicStandardRadioModel==null){
      medicalFacilityClinicStandardRadioModel = new ACListModelAdapter();
      addMedicalFacilityClinicStandardRadioModel();
    }
    return medicalFacilityClinicStandardRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getMedicalFacilityClinicStandardRadioItem1(){
    if(medicalFacilityClinicStandardRadioItem1==null){

      medicalFacilityClinicStandardRadioItem1 = new ACRadioButtonItem();

      medicalFacilityClinicStandardRadioItem1.setText("�Ȃ�");

      medicalFacilityClinicStandardRadioItem1.setGroup(getMedicalFacilityClinicStandardRadio());

      medicalFacilityClinicStandardRadioItem1.setConstraints(VRLayout.FLOW);

      addMedicalFacilityClinicStandardRadioItem1();
    }
    return medicalFacilityClinicStandardRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getMedicalFacilityClinicStandardRadioItem2(){
    if(medicalFacilityClinicStandardRadioItem2==null){

      medicalFacilityClinicStandardRadioItem2 = new ACRadioButtonItem();

      medicalFacilityClinicStandardRadioItem2.setText("����");

      medicalFacilityClinicStandardRadioItem2.setGroup(getMedicalFacilityClinicStandardRadio());

      medicalFacilityClinicStandardRadioItem2.setConstraints(VRLayout.FLOW);

      addMedicalFacilityClinicStandardRadioItem2();
    }
    return medicalFacilityClinicStandardRadioItem2;

  }

  /**
   * ���Ȏ�f���擾���܂��B
   * @return ���Ȏ�f
   */
  public ACClearableRadioButtonGroup getMedicalFacilityClinicMedicalExaminationRadio(){
    if(medicalFacilityClinicMedicalExaminationRadio==null){

      medicalFacilityClinicMedicalExaminationRadio = new ACClearableRadioButtonGroup();

      getMedicalFacilityClinicMedicalExaminationRadioContainer().setText("���Ȏ�f���Z");

      medicalFacilityClinicMedicalExaminationRadio.setBindPath("1530208");

      medicalFacilityClinicMedicalExaminationRadio.setUseClearButton(false);

      medicalFacilityClinicMedicalExaminationRadio.setModel(getMedicalFacilityClinicMedicalExaminationRadioModel());

      addMedicalFacilityClinicMedicalExaminationRadio();
    }
    return medicalFacilityClinicMedicalExaminationRadio;

  }

  /**
   * ���Ȏ�f�R���e�i���擾���܂��B
   * @return ���Ȏ�f�R���e�i
   */
  protected ACLabelContainer getMedicalFacilityClinicMedicalExaminationRadioContainer(){
    if(medicalFacilityClinicMedicalExaminationRadioContainer==null){
      medicalFacilityClinicMedicalExaminationRadioContainer = new ACLabelContainer();
      medicalFacilityClinicMedicalExaminationRadioContainer.setFollowChildEnabled(true);
      medicalFacilityClinicMedicalExaminationRadioContainer.setVAlignment(VRLayout.CENTER);
      medicalFacilityClinicMedicalExaminationRadioContainer.add(getMedicalFacilityClinicMedicalExaminationRadio(), null);
    }
    return medicalFacilityClinicMedicalExaminationRadioContainer;
  }

  /**
   * ���Ȏ�f���f�����擾���܂��B
   * @return ���Ȏ�f���f��
   */
  protected ACListModelAdapter getMedicalFacilityClinicMedicalExaminationRadioModel(){
    if(medicalFacilityClinicMedicalExaminationRadioModel==null){
      medicalFacilityClinicMedicalExaminationRadioModel = new ACListModelAdapter();
      addMedicalFacilityClinicMedicalExaminationRadioModel();
    }
    return medicalFacilityClinicMedicalExaminationRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getMedicalFacilityClinicMedicalExaminationRadioItem1(){
    if(medicalFacilityClinicMedicalExaminationRadioItem1==null){

      medicalFacilityClinicMedicalExaminationRadioItem1 = new ACRadioButtonItem();

      medicalFacilityClinicMedicalExaminationRadioItem1.setText("�Ȃ�");

      medicalFacilityClinicMedicalExaminationRadioItem1.setGroup(getMedicalFacilityClinicMedicalExaminationRadio());

      medicalFacilityClinicMedicalExaminationRadioItem1.setConstraints(VRLayout.FLOW);

      addMedicalFacilityClinicMedicalExaminationRadioItem1();
    }
    return medicalFacilityClinicMedicalExaminationRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getMedicalFacilityClinicMedicalExaminationRadioItem2(){
    if(medicalFacilityClinicMedicalExaminationRadioItem2==null){

      medicalFacilityClinicMedicalExaminationRadioItem2 = new ACRadioButtonItem();

      medicalFacilityClinicMedicalExaminationRadioItem2.setText("����");

      medicalFacilityClinicMedicalExaminationRadioItem2.setGroup(getMedicalFacilityClinicMedicalExaminationRadio());

      medicalFacilityClinicMedicalExaminationRadioItem2.setConstraints(VRLayout.FLOW);

      addMedicalFacilityClinicMedicalExaminationRadioItem2();
    }
    return medicalFacilityClinicMedicalExaminationRadioItem2;

  }

  /**
   * �h�{�Ǘ��̐����Z���擾���܂��B
   * @return �h�{�Ǘ��̐����Z
   */
  public ACClearableRadioButtonGroup getMedicalFacilityClinicNutritionManageRadio(){
    if(medicalFacilityClinicNutritionManageRadio==null){

      medicalFacilityClinicNutritionManageRadio = new ACClearableRadioButtonGroup();

      getMedicalFacilityClinicNutritionManageRadioContainer().setText("�h�{�Ǘ��̐����Z");

      medicalFacilityClinicNutritionManageRadio.setBindPath("1530209");

      medicalFacilityClinicNutritionManageRadio.setUseClearButton(false);

      medicalFacilityClinicNutritionManageRadio.setModel(getMedicalFacilityClinicNutritionManageRadioModel());

      addMedicalFacilityClinicNutritionManageRadio();
    }
    return medicalFacilityClinicNutritionManageRadio;

  }

  /**
   * �h�{�Ǘ��̐����Z�R���e�i���擾���܂��B
   * @return �h�{�Ǘ��̐����Z�R���e�i
   */
  protected ACLabelContainer getMedicalFacilityClinicNutritionManageRadioContainer(){
    if(medicalFacilityClinicNutritionManageRadioContainer==null){
      medicalFacilityClinicNutritionManageRadioContainer = new ACLabelContainer();
      medicalFacilityClinicNutritionManageRadioContainer.setFollowChildEnabled(true);
      medicalFacilityClinicNutritionManageRadioContainer.setVAlignment(VRLayout.CENTER);
      medicalFacilityClinicNutritionManageRadioContainer.add(getMedicalFacilityClinicNutritionManageRadio(), null);
    }
    return medicalFacilityClinicNutritionManageRadioContainer;
  }

  /**
   * �h�{�Ǘ��̐����Z���f�����擾���܂��B
   * @return �h�{�Ǘ��̐����Z���f��
   */
  protected ACListModelAdapter getMedicalFacilityClinicNutritionManageRadioModel(){
    if(medicalFacilityClinicNutritionManageRadioModel==null){
      medicalFacilityClinicNutritionManageRadioModel = new ACListModelAdapter();
      addMedicalFacilityClinicNutritionManageRadioModel();
    }
    return medicalFacilityClinicNutritionManageRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getMedicalFacilityClinicNutritionManageRadioItem1(){
    if(medicalFacilityClinicNutritionManageRadioItem1==null){

      medicalFacilityClinicNutritionManageRadioItem1 = new ACRadioButtonItem();

      medicalFacilityClinicNutritionManageRadioItem1.setText("�Ȃ�");

      medicalFacilityClinicNutritionManageRadioItem1.setGroup(getMedicalFacilityClinicNutritionManageRadio());

      medicalFacilityClinicNutritionManageRadioItem1.setConstraints(VRLayout.FLOW);

      addMedicalFacilityClinicNutritionManageRadioItem1();
    }
    return medicalFacilityClinicNutritionManageRadioItem1;

  }

  /**
   * �Ǘ��h�{�m���擾���܂��B
   * @return �Ǘ��h�{�m
   */
  public ACRadioButtonItem getMedicalFacilityClinicNutritionManageRadioItem2(){
    if(medicalFacilityClinicNutritionManageRadioItem2==null){

      medicalFacilityClinicNutritionManageRadioItem2 = new ACRadioButtonItem();

      medicalFacilityClinicNutritionManageRadioItem2.setText("�Ǘ��h�{�m");

      medicalFacilityClinicNutritionManageRadioItem2.setGroup(getMedicalFacilityClinicNutritionManageRadio());

      medicalFacilityClinicNutritionManageRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

      addMedicalFacilityClinicNutritionManageRadioItem2();
    }
    return medicalFacilityClinicNutritionManageRadioItem2;

  }

  /**
   * �h�{�m���擾���܂��B
   * @return �h�{�m
   */
  public ACRadioButtonItem getMedicalFacilityClinicNutritionManageRadioItem3(){
    if(medicalFacilityClinicNutritionManageRadioItem3==null){

      medicalFacilityClinicNutritionManageRadioItem3 = new ACRadioButtonItem();

      medicalFacilityClinicNutritionManageRadioItem3.setText("�h�{�m");

      medicalFacilityClinicNutritionManageRadioItem3.setGroup(getMedicalFacilityClinicNutritionManageRadio());

      medicalFacilityClinicNutritionManageRadioItem3.setConstraints(VRLayout.FLOW);

      addMedicalFacilityClinicNutritionManageRadioItem3();
    }
    return medicalFacilityClinicNutritionManageRadioItem3;

  }

  /**
   * �h�{�}�l�W�����g���Z���擾���܂��B
   * @return �h�{�}�l�W�����g���Z
   */
  public ACClearableRadioButtonGroup getMedicalFacilityClinicNutritionRadio(){
    if(medicalFacilityClinicNutritionRadio==null){

      medicalFacilityClinicNutritionRadio = new ACClearableRadioButtonGroup();

      getMedicalFacilityClinicNutritionRadioContainer().setText("�h�{�}�l�W�����g���Z");

      medicalFacilityClinicNutritionRadio.setBindPath("1530210");

      medicalFacilityClinicNutritionRadio.setUseClearButton(false);

      medicalFacilityClinicNutritionRadio.setModel(getMedicalFacilityClinicNutritionRadioModel());

      addMedicalFacilityClinicNutritionRadio();
    }
    return medicalFacilityClinicNutritionRadio;

  }

  /**
   * �h�{�}�l�W�����g���Z�R���e�i���擾���܂��B
   * @return �h�{�}�l�W�����g���Z�R���e�i
   */
  protected ACLabelContainer getMedicalFacilityClinicNutritionRadioContainer(){
    if(medicalFacilityClinicNutritionRadioContainer==null){
      medicalFacilityClinicNutritionRadioContainer = new ACLabelContainer();
      medicalFacilityClinicNutritionRadioContainer.setFollowChildEnabled(true);
      medicalFacilityClinicNutritionRadioContainer.setVAlignment(VRLayout.CENTER);
      medicalFacilityClinicNutritionRadioContainer.add(getMedicalFacilityClinicNutritionRadio(), null);
    }
    return medicalFacilityClinicNutritionRadioContainer;
  }

  /**
   * �h�{�}�l�W�����g���Z���f�����擾���܂��B
   * @return �h�{�}�l�W�����g���Z���f��
   */
  protected ACListModelAdapter getMedicalFacilityClinicNutritionRadioModel(){
    if(medicalFacilityClinicNutritionRadioModel==null){
      medicalFacilityClinicNutritionRadioModel = new ACListModelAdapter();
      addMedicalFacilityClinicNutritionRadioModel();
    }
    return medicalFacilityClinicNutritionRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getMedicalFacilityClinicNutritionRadioItem1(){
    if(medicalFacilityClinicNutritionRadioItem1==null){

      medicalFacilityClinicNutritionRadioItem1 = new ACRadioButtonItem();

      medicalFacilityClinicNutritionRadioItem1.setText("�Ȃ�");

      medicalFacilityClinicNutritionRadioItem1.setGroup(getMedicalFacilityClinicNutritionRadio());

      medicalFacilityClinicNutritionRadioItem1.setConstraints(VRLayout.FLOW);

      addMedicalFacilityClinicNutritionRadioItem1();
    }
    return medicalFacilityClinicNutritionRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getMedicalFacilityClinicNutritionRadioItem2(){
    if(medicalFacilityClinicNutritionRadioItem2==null){

      medicalFacilityClinicNutritionRadioItem2 = new ACRadioButtonItem();

      medicalFacilityClinicNutritionRadioItem2.setText("����");

      medicalFacilityClinicNutritionRadioItem2.setGroup(getMedicalFacilityClinicNutritionRadio());

      medicalFacilityClinicNutritionRadioItem2.setConstraints(VRLayout.FLOW);

      addMedicalFacilityClinicNutritionRadioItem2();
    }
    return medicalFacilityClinicNutritionRadioItem2;

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
  public ACClearableRadioButtonGroup getMedicalFacilityClinicOralSwitchRadio(){
    if(medicalFacilityClinicOralSwitchRadio==null){

      medicalFacilityClinicOralSwitchRadio = new ACClearableRadioButtonGroup();

      getMedicalFacilityClinicOralSwitchRadioContainer().setText("�o���ڍs���Z");

      medicalFacilityClinicOralSwitchRadio.setBindPath("1530211");

      medicalFacilityClinicOralSwitchRadio.setUseClearButton(false);

      medicalFacilityClinicOralSwitchRadio.setModel(getMedicalFacilityClinicOralSwitchRadioModel());

      addMedicalFacilityClinicOralSwitchRadio();
    }
    return medicalFacilityClinicOralSwitchRadio;

  }

  /**
   * �o���ڍs���Z�R���e�i���擾���܂��B
   * @return �o���ڍs���Z�R���e�i
   */
  protected ACLabelContainer getMedicalFacilityClinicOralSwitchRadioContainer(){
    if(medicalFacilityClinicOralSwitchRadioContainer==null){
      medicalFacilityClinicOralSwitchRadioContainer = new ACLabelContainer();
      medicalFacilityClinicOralSwitchRadioContainer.setFollowChildEnabled(true);
      medicalFacilityClinicOralSwitchRadioContainer.setVAlignment(VRLayout.CENTER);
      medicalFacilityClinicOralSwitchRadioContainer.add(getMedicalFacilityClinicOralSwitchRadio(), null);
    }
    return medicalFacilityClinicOralSwitchRadioContainer;
  }

  /**
   * �o���ڍs���Z���f�����擾���܂��B
   * @return �o���ڍs���Z���f��
   */
  protected ACListModelAdapter getMedicalFacilityClinicOralSwitchRadioModel(){
    if(medicalFacilityClinicOralSwitchRadioModel==null){
      medicalFacilityClinicOralSwitchRadioModel = new ACListModelAdapter();
      addMedicalFacilityClinicOralSwitchRadioModel();
    }
    return medicalFacilityClinicOralSwitchRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getMedicalFacilityClinicOralSwitchRadioItem1(){
    if(medicalFacilityClinicOralSwitchRadioItem1==null){

      medicalFacilityClinicOralSwitchRadioItem1 = new ACRadioButtonItem();

      medicalFacilityClinicOralSwitchRadioItem1.setText("�Ȃ�");

      medicalFacilityClinicOralSwitchRadioItem1.setGroup(getMedicalFacilityClinicOralSwitchRadio());

      medicalFacilityClinicOralSwitchRadioItem1.setConstraints(VRLayout.FLOW);

      addMedicalFacilityClinicOralSwitchRadioItem1();
    }
    return medicalFacilityClinicOralSwitchRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getMedicalFacilityClinicOralSwitchRadioItem2(){
    if(medicalFacilityClinicOralSwitchRadioItem2==null){

      medicalFacilityClinicOralSwitchRadioItem2 = new ACRadioButtonItem();

      medicalFacilityClinicOralSwitchRadioItem2.setText("����");

      medicalFacilityClinicOralSwitchRadioItem2.setGroup(getMedicalFacilityClinicOralSwitchRadio());

      medicalFacilityClinicOralSwitchRadioItem2.setConstraints(VRLayout.FLOW);

      addMedicalFacilityClinicOralSwitchRadioItem2();
    }
    return medicalFacilityClinicOralSwitchRadioItem2;

  }

  /**
   * �o���ێ����Z���擾���܂��B
   * @return �o���ێ����Z
   */
  public ACClearableRadioButtonGroup getOralMaintenanceAddRadio(){
    if(oralMaintenanceAddRadio==null){

      oralMaintenanceAddRadio = new ACClearableRadioButtonGroup();

      getOralMaintenanceAddRadioContainer().setText("�o���ێ����Z");

      oralMaintenanceAddRadio.setBindPath("1530213");

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
   * �×{�H���Z���擾���܂��B
   * @return �×{�H���Z
   */
  public ACClearableRadioButtonGroup getMedicalFacilityClinicRecuperateDinnerRadio(){
    if(medicalFacilityClinicRecuperateDinnerRadio==null){

      medicalFacilityClinicRecuperateDinnerRadio = new ACClearableRadioButtonGroup();

      getMedicalFacilityClinicRecuperateDinnerRadioContainer().setText("�×{�H���Z");

      medicalFacilityClinicRecuperateDinnerRadio.setBindPath("1530212");

      medicalFacilityClinicRecuperateDinnerRadio.setUseClearButton(false);

      medicalFacilityClinicRecuperateDinnerRadio.setModel(getMedicalFacilityClinicRecuperateDinnerRadioModel());

      addMedicalFacilityClinicRecuperateDinnerRadio();
    }
    return medicalFacilityClinicRecuperateDinnerRadio;

  }

  /**
   * �×{�H���Z�R���e�i���擾���܂��B
   * @return �×{�H���Z�R���e�i
   */
  protected ACLabelContainer getMedicalFacilityClinicRecuperateDinnerRadioContainer(){
    if(medicalFacilityClinicRecuperateDinnerRadioContainer==null){
      medicalFacilityClinicRecuperateDinnerRadioContainer = new ACLabelContainer();
      medicalFacilityClinicRecuperateDinnerRadioContainer.setFollowChildEnabled(true);
      medicalFacilityClinicRecuperateDinnerRadioContainer.setVAlignment(VRLayout.CENTER);
      medicalFacilityClinicRecuperateDinnerRadioContainer.add(getMedicalFacilityClinicRecuperateDinnerRadio(), null);
    }
    return medicalFacilityClinicRecuperateDinnerRadioContainer;
  }

  /**
   * �×{�H���Z���f�����擾���܂��B
   * @return �×{�H���Z���f��
   */
  protected ACListModelAdapter getMedicalFacilityClinicRecuperateDinnerRadioModel(){
    if(medicalFacilityClinicRecuperateDinnerRadioModel==null){
      medicalFacilityClinicRecuperateDinnerRadioModel = new ACListModelAdapter();
      addMedicalFacilityClinicRecuperateDinnerRadioModel();
    }
    return medicalFacilityClinicRecuperateDinnerRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getMedicalFacilityClinicRecuperateDinnerRadioItem1(){
    if(medicalFacilityClinicRecuperateDinnerRadioItem1==null){

      medicalFacilityClinicRecuperateDinnerRadioItem1 = new ACRadioButtonItem();

      medicalFacilityClinicRecuperateDinnerRadioItem1.setText("�Ȃ�");

      medicalFacilityClinicRecuperateDinnerRadioItem1.setGroup(getMedicalFacilityClinicRecuperateDinnerRadio());

      medicalFacilityClinicRecuperateDinnerRadioItem1.setConstraints(VRLayout.FLOW);

      addMedicalFacilityClinicRecuperateDinnerRadioItem1();
    }
    return medicalFacilityClinicRecuperateDinnerRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getMedicalFacilityClinicRecuperateDinnerRadioItem2(){
    if(medicalFacilityClinicRecuperateDinnerRadioItem2==null){

      medicalFacilityClinicRecuperateDinnerRadioItem2 = new ACRadioButtonItem();

      medicalFacilityClinicRecuperateDinnerRadioItem2.setText("����");

      medicalFacilityClinicRecuperateDinnerRadioItem2.setGroup(getMedicalFacilityClinicRecuperateDinnerRadio());

      medicalFacilityClinicRecuperateDinnerRadioItem2.setConstraints(VRLayout.FLOW);

      addMedicalFacilityClinicRecuperateDinnerRadioItem2();
    }
    return medicalFacilityClinicRecuperateDinnerRadioItem2;

  }

  /**
   * �ޏ��֘A���Z���擾���܂��B
   * @return �ޏ��֘A���Z
   */
  public ACLabelContainer getMedicalFacilityClinicHijoAddition(){
    if(medicalFacilityClinicHijoAddition==null){

      medicalFacilityClinicHijoAddition = new ACLabelContainer();

      medicalFacilityClinicHijoAddition.setText("�މ@�֘A���Z");

      addMedicalFacilityClinicHijoAddition();
    }
    return medicalFacilityClinicHijoAddition;

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
  public ACMapBindButton getMedicalFacilityClinicConsultationFee(){
    if(medicalFacilityClinicConsultationFee==null){

      medicalFacilityClinicConsultationFee = new ACMapBindButton();

      medicalFacilityClinicConsultationFee.setText("����f�Ô�");

      medicalFacilityClinicConsultationFee.setToolTipText("����f�Ô��ݒ肵�܂��B");

      addMedicalFacilityClinicConsultationFee();
    }
    return medicalFacilityClinicConsultationFee;

  }

  /**
   * ���x�����擾���܂��B
   * @return ���x��
   */
  public ACLabel getMedicalFacilityClinicConsultationFeeLabel(){
    if(medicalFacilityClinicConsultationFeeLabel==null){

      medicalFacilityClinicConsultationFeeLabel = new ACLabel();

      medicalFacilityClinicConsultationFeeLabel.setText("�ݒ�Ȃ�");

      medicalFacilityClinicConsultationFeeLabel.setOpaque(true);
      medicalFacilityClinicConsultationFeeLabel.setBackground(new Color(255,255,172));

      addMedicalFacilityClinicConsultationFeeLabel();
    }
    return medicalFacilityClinicConsultationFeeLabel;

  }

  /**
   * �l�����Z���擾���܂��B
   * @return �l�����Z
   */
  public ACClearableRadioButtonGroup getMedicalFacilityClinicSubstractionRadio(){
    if(medicalFacilityClinicSubstractionRadio==null){

      medicalFacilityClinicSubstractionRadio = new ACClearableRadioButtonGroup();

      getMedicalFacilityClinicSubstractionRadioContainer().setText("�l�����Z");

      medicalFacilityClinicSubstractionRadio.setBindPath("1530256");

      medicalFacilityClinicSubstractionRadio.setUseClearButton(false);

      medicalFacilityClinicSubstractionRadio.setModel(getMedicalFacilityClinicSubstractionRadioModel());

      addMedicalFacilityClinicSubstractionRadio();
    }
    return medicalFacilityClinicSubstractionRadio;

  }

  /**
   * �l�����Z�R���e�i���擾���܂��B
   * @return �l�����Z�R���e�i
   */
  protected ACLabelContainer getMedicalFacilityClinicSubstractionRadioContainer(){
    if(medicalFacilityClinicSubstractionRadioContainer==null){
      medicalFacilityClinicSubstractionRadioContainer = new ACLabelContainer();
      medicalFacilityClinicSubstractionRadioContainer.setFollowChildEnabled(true);
      medicalFacilityClinicSubstractionRadioContainer.setVAlignment(VRLayout.CENTER);
      medicalFacilityClinicSubstractionRadioContainer.add(getMedicalFacilityClinicSubstractionRadio(), null);
    }
    return medicalFacilityClinicSubstractionRadioContainer;
  }

  /**
   * �l�����Z���f�����擾���܂��B
   * @return �l�����Z���f��
   */
  protected ACListModelAdapter getMedicalFacilityClinicSubstractionRadioModel(){
    if(medicalFacilityClinicSubstractionRadioModel==null){
      medicalFacilityClinicSubstractionRadioModel = new ACListModelAdapter();
      addMedicalFacilityClinicSubstractionRadioModel();
    }
    return medicalFacilityClinicSubstractionRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getMedicalFacilityClinicSubstractionRadioItem1(){
    if(medicalFacilityClinicSubstractionRadioItem1==null){

      medicalFacilityClinicSubstractionRadioItem1 = new ACRadioButtonItem();

      medicalFacilityClinicSubstractionRadioItem1.setText("�Ȃ�");

      medicalFacilityClinicSubstractionRadioItem1.setGroup(getMedicalFacilityClinicSubstractionRadio());

      medicalFacilityClinicSubstractionRadioItem1.setConstraints(VRLayout.FLOW);

      addMedicalFacilityClinicSubstractionRadioItem1();
    }
    return medicalFacilityClinicSubstractionRadioItem1;

  }

  /**
   * ������߂��擾���܂��B
   * @return �������
   */
  public ACRadioButtonItem getMedicalFacilityClinicSubstractionRadioItem2(){
    if(medicalFacilityClinicSubstractionRadioItem2==null){

      medicalFacilityClinicSubstractionRadioItem2 = new ACRadioButtonItem();

      medicalFacilityClinicSubstractionRadioItem2.setText("�������");

      medicalFacilityClinicSubstractionRadioItem2.setGroup(getMedicalFacilityClinicSubstractionRadio());

      medicalFacilityClinicSubstractionRadioItem2.setConstraints(VRLayout.FLOW);

      addMedicalFacilityClinicSubstractionRadioItem2();
    }
    return medicalFacilityClinicSubstractionRadioItem2;

  }

  /**
   * �H���R���e�i���擾���܂��B
   * @return �H���R���e�i
   */
  public ACBackLabelContainer getMedicalFacilityClinicDinnerContainer(){
    if(medicalFacilityClinicDinnerContainer==null){

      medicalFacilityClinicDinnerContainer = new ACBackLabelContainer();

      addMedicalFacilityClinicDinnerContainer();
    }
    return medicalFacilityClinicDinnerContainer;

  }

  /**
   * �H���񋟂��擾���܂��B
   * @return �H����
   */
  public ACComboBox getMedicalFacilityClinicDinnerOffer(){
    if(medicalFacilityClinicDinnerOffer==null){

      medicalFacilityClinicDinnerOffer = new ACComboBox();

      getMedicalFacilityClinicDinnerOfferContainer().setText("�H����");

      medicalFacilityClinicDinnerOffer.setBindPath("1530257");

      medicalFacilityClinicDinnerOffer.setEditable(false);

      medicalFacilityClinicDinnerOffer.setModelBindPath("1530257");

      medicalFacilityClinicDinnerOffer.setRenderBindPath("CONTENT");

      medicalFacilityClinicDinnerOffer.setModel(getMedicalFacilityClinicDinnerOfferModel());

      addMedicalFacilityClinicDinnerOffer();
    }
    return medicalFacilityClinicDinnerOffer;

  }

  /**
   * �H���񋟃R���e�i���擾���܂��B
   * @return �H���񋟃R���e�i
   */
  protected ACLabelContainer getMedicalFacilityClinicDinnerOfferContainer(){
    if(medicalFacilityClinicDinnerOfferContainer==null){
      medicalFacilityClinicDinnerOfferContainer = new ACLabelContainer();
      medicalFacilityClinicDinnerOfferContainer.setFollowChildEnabled(true);
      medicalFacilityClinicDinnerOfferContainer.setVAlignment(VRLayout.CENTER);
      medicalFacilityClinicDinnerOfferContainer.add(getMedicalFacilityClinicDinnerOffer(), null);
    }
    return medicalFacilityClinicDinnerOfferContainer;
  }

  /**
   * �H���񋟃��f�����擾���܂��B
   * @return �H���񋟃��f��
   */
  protected ACComboBoxModelAdapter getMedicalFacilityClinicDinnerOfferModel(){
    if(medicalFacilityClinicDinnerOfferModel==null){
      medicalFacilityClinicDinnerOfferModel = new ACComboBoxModelAdapter();
      addMedicalFacilityClinicDinnerOfferModel();
    }
    return medicalFacilityClinicDinnerOfferModel;
  }

  /**
   * �H����p���擾���܂��B
   * @return �H����p
   */
  public ACTextField getMedicalFacilityClinicDinnerCost(){
    if(medicalFacilityClinicDinnerCost==null){

      medicalFacilityClinicDinnerCost = new ACTextField();

      getMedicalFacilityClinicDinnerCostContainer().setText("�H����p");

      medicalFacilityClinicDinnerCost.setBindPath("1530259");

      medicalFacilityClinicDinnerCost.setColumns(4);

      medicalFacilityClinicDinnerCost.setCharType(VRCharType.ONLY_DIGIT);

      medicalFacilityClinicDinnerCost.setHorizontalAlignment(SwingConstants.RIGHT);

      medicalFacilityClinicDinnerCost.setIMEMode(InputSubset.LATIN);

      medicalFacilityClinicDinnerCost.setMaxLength(5);

      addMedicalFacilityClinicDinnerCost();
    }
    return medicalFacilityClinicDinnerCost;

  }

  /**
   * �H����p�R���e�i���擾���܂��B
   * @return �H����p�R���e�i
   */
  protected ACLabelContainer getMedicalFacilityClinicDinnerCostContainer(){
    if(medicalFacilityClinicDinnerCostContainer==null){
      medicalFacilityClinicDinnerCostContainer = new ACLabelContainer();
      medicalFacilityClinicDinnerCostContainer.setFollowChildEnabled(true);
      medicalFacilityClinicDinnerCostContainer.setVAlignment(VRLayout.CENTER);
      medicalFacilityClinicDinnerCostContainer.add(getMedicalFacilityClinicDinnerCost(), null);
    }
    return medicalFacilityClinicDinnerCostContainer;
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

      unitCareMaintenanceRadio.setBindPath("1530214");

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

      bodyRestraintAbolitionRadio.setBindPath("1530215");

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

      stayReturnSupportAddRadio.setBindPath("1530216");

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
   * �Z��敪���擾���܂��B
   * @return �Z��敪
   */
  public ACClearableRadioButtonGroup getMedicalFacilityClinicCalculationDivisionRadio(){
    if(medicalFacilityClinicCalculationDivisionRadio==null){

      medicalFacilityClinicCalculationDivisionRadio = new ACClearableRadioButtonGroup();

      getMedicalFacilityClinicCalculationDivisionRadioContainer().setText("�Z��敪");

      medicalFacilityClinicCalculationDivisionRadio.setBindPath("9");

      medicalFacilityClinicCalculationDivisionRadio.setUseClearButton(false);

      medicalFacilityClinicCalculationDivisionRadio.setModel(getMedicalFacilityClinicCalculationDivisionRadioModel());

      addMedicalFacilityClinicCalculationDivisionRadio();
    }
    return medicalFacilityClinicCalculationDivisionRadio;

  }

  /**
   * �Z��敪�R���e�i���擾���܂��B
   * @return �Z��敪�R���e�i
   */
  protected ACLabelContainer getMedicalFacilityClinicCalculationDivisionRadioContainer(){
    if(medicalFacilityClinicCalculationDivisionRadioContainer==null){
      medicalFacilityClinicCalculationDivisionRadioContainer = new ACLabelContainer();
      medicalFacilityClinicCalculationDivisionRadioContainer.setFollowChildEnabled(true);
      medicalFacilityClinicCalculationDivisionRadioContainer.setVAlignment(VRLayout.CENTER);
      medicalFacilityClinicCalculationDivisionRadioContainer.add(getMedicalFacilityClinicCalculationDivisionRadio(), null);
    }
    return medicalFacilityClinicCalculationDivisionRadioContainer;
  }

  /**
   * �Z��敪���f�����擾���܂��B
   * @return �Z��敪���f��
   */
  protected ACListModelAdapter getMedicalFacilityClinicCalculationDivisionRadioModel(){
    if(medicalFacilityClinicCalculationDivisionRadioModel==null){
      medicalFacilityClinicCalculationDivisionRadioModel = new ACListModelAdapter();
      addMedicalFacilityClinicCalculationDivisionRadioModel();
    }
    return medicalFacilityClinicCalculationDivisionRadioModel;
  }

  /**
   * �ʏ���擾���܂��B
   * @return �ʏ�
   */
  public ACRadioButtonItem getMedicalFacilityClinicCalculationDivisionRadioItem1(){
    if(medicalFacilityClinicCalculationDivisionRadioItem1==null){

      medicalFacilityClinicCalculationDivisionRadioItem1 = new ACRadioButtonItem();

      medicalFacilityClinicCalculationDivisionRadioItem1.setText("�ʏ�");

      medicalFacilityClinicCalculationDivisionRadioItem1.setGroup(getMedicalFacilityClinicCalculationDivisionRadio());

      medicalFacilityClinicCalculationDivisionRadioItem1.setConstraints(VRLayout.FLOW);

      addMedicalFacilityClinicCalculationDivisionRadioItem1();
    }
    return medicalFacilityClinicCalculationDivisionRadioItem1;

  }

  /**
   * ���Z�݂̂��擾���܂��B
   * @return ���Z�̂�
   */
  public ACRadioButtonItem getMedicalFacilityClinicCalculationDivisionRadioItem2(){
    if(medicalFacilityClinicCalculationDivisionRadioItem2==null){

      medicalFacilityClinicCalculationDivisionRadioItem2 = new ACRadioButtonItem();

      medicalFacilityClinicCalculationDivisionRadioItem2.setText("���Z�̂�");

      medicalFacilityClinicCalculationDivisionRadioItem2.setGroup(getMedicalFacilityClinicCalculationDivisionRadio());

      medicalFacilityClinicCalculationDivisionRadioItem2.setConstraints(VRLayout.FLOW);

      addMedicalFacilityClinicCalculationDivisionRadioItem2();
    }
    return medicalFacilityClinicCalculationDivisionRadioItem2;

  }

  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001121_H2004Design() {

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

    tab1.add(getMedicalFacilityClinicInstitutionDivisionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getMedicalFacilityClinicDivisionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getMedicalFacilityClinicHospitalRoomContena(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getMedicalFacilityClinicEnvironmentalRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getMedicalFacilityClinicProvisionBaseRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getMedicalFacilityClinicStayRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getMedicalFacilityClinicStandardRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getMedicalFacilityClinicMedicalExaminationRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getMedicalFacilityClinicNutritionManageRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getMedicalFacilityClinicNutritionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * �{�ݓ��̋敪�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityClinicInstitutionDivisionRadio(){

  }

  /**
   * �{�ݓ��̋敪���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityClinicInstitutionDivisionRadioModel(){

    getMedicalFacilityClinicInstitutionDivisionRadioItem1().setButtonIndex(1);

    getMedicalFacilityClinicInstitutionDivisionRadioModel().add(getMedicalFacilityClinicInstitutionDivisionRadioItem1());

    getMedicalFacilityClinicInstitutionDivisionRadioItem2().setButtonIndex(2);

    getMedicalFacilityClinicInstitutionDivisionRadioModel().add(getMedicalFacilityClinicInstitutionDivisionRadioItem2());

  }

  /**
   * �f�Ï��ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityClinicInstitutionDivisionRadioItem1(){

  }

  /**
   * ���j�b�g�^�f�Ï��ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityClinicInstitutionDivisionRadioItem2(){

  }

  /**
   * �l���z�u�敪�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityClinicDivision(){

  }

  /**
   * �l���z�u�敪���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityClinicDivisionModel(){

    getMedicalFacilityClinicDivision1().setButtonIndex(1);

    getMedicalFacilityClinicDivisionModel().add(getMedicalFacilityClinicDivision1());

    getMedicalFacilityClinicDivision2().setButtonIndex(2);

    getMedicalFacilityClinicDivisionModel().add(getMedicalFacilityClinicDivision2());

  }

  /**
   * I�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityClinicDivision1(){

  }

  /**
   * II�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityClinicDivision2(){

  }

  /**
   * �a���敪�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityClinicHospitalRoomContena(){

    medicalFacilityClinicHospitalRoomContena.add(getMedicalFacilityClinicHospitalRoomRadio(), VRLayout.FLOW_INSETLINE_RETURN);

    medicalFacilityClinicHospitalRoomContena.add(getMedicalFacilityClinicUnitHospitalRoomRadio(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * �a���敪�i�a�@�j�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityClinicHospitalRoomRadio(){

  }

  /**
   * �a���敪�i�a�@�j���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityClinicHospitalRoomRadioModel(){

    getMedicalFacilityClinicHospitalRoomRadioItem1().setButtonIndex(1);

    getMedicalFacilityClinicHospitalRoomRadioModel().add(getMedicalFacilityClinicHospitalRoomRadioItem1());

    getMedicalFacilityClinicHospitalRoomRadioItem2().setButtonIndex(2);

    getMedicalFacilityClinicHospitalRoomRadioModel().add(getMedicalFacilityClinicHospitalRoomRadioItem2());

  }

  /**
   * �]���^���ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityClinicHospitalRoomRadioItem1(){

  }

  /**
   * �������ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityClinicHospitalRoomRadioItem2(){

  }

  /**
   * �a���敪�i���j�b�g�^�j�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityClinicUnitHospitalRoomRadio(){

  }

  /**
   * �a���敪�i���j�b�g�^�j���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityClinicUnitHospitalRoomRadioModel(){

    getMedicalFacilityClinicUnitHospitalRoomRadioItem1().setButtonIndex(1);

    getMedicalFacilityClinicUnitHospitalRoomRadioModel().add(getMedicalFacilityClinicUnitHospitalRoomRadioItem1());

    getMedicalFacilityClinicUnitHospitalRoomRadioItem2().setButtonIndex(2);

    getMedicalFacilityClinicUnitHospitalRoomRadioModel().add(getMedicalFacilityClinicUnitHospitalRoomRadioItem2());

  }

  /**
   * ���j�b�g�^���ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityClinicUnitHospitalRoomRadioItem1(){

  }

  /**
   * ���j�b�g�^�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityClinicUnitHospitalRoomRadioItem2(){

  }

  /**
   * �×{����ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityClinicEnvironmentalRadio(){

  }

  /**
   * �×{������f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityClinicEnvironmentalRadioModel(){

    getMedicalFacilityClinicEnvironmentalRadioItem1().setButtonIndex(1);

    getMedicalFacilityClinicEnvironmentalRadioModel().add(getMedicalFacilityClinicEnvironmentalRadioItem1());

    getMedicalFacilityClinicEnvironmentalRadioItem3().setButtonIndex(3);

    getMedicalFacilityClinicEnvironmentalRadioModel().add(getMedicalFacilityClinicEnvironmentalRadioItem3());

  }

  /**
   * ��^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityClinicEnvironmentalRadioItem1(){

  }

  /**
   * ���ZII�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityClinicEnvironmentalRadioItem3(){

  }

  /**
   * �ݔ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityClinicProvisionBaseRadio(){

  }

  /**
   * �ݔ������f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityClinicProvisionBaseRadioModel(){

    getMedicalFacilityClinicProvisionBaseRadioItem1().setButtonIndex(1);

    getMedicalFacilityClinicProvisionBaseRadioModel().add(getMedicalFacilityClinicProvisionBaseRadioItem1());

    getMedicalFacilityClinicProvisionBaseRadioItem2().setButtonIndex(2);

    getMedicalFacilityClinicProvisionBaseRadioModel().add(getMedicalFacilityClinicProvisionBaseRadioItem2());

  }

  /**
   * ��^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityClinicProvisionBaseRadioItem1(){

  }

  /**
   * ���Z�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityClinicProvisionBaseRadioItem2(){

  }

  /**
   * �O�����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityClinicStayRadio(){

  }

  /**
   * �O�����Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityClinicStayRadioModel(){

    getMedicalFacilityClinicStayRadioItem1().setButtonIndex(1);

    getMedicalFacilityClinicStayRadioModel().add(getMedicalFacilityClinicStayRadioItem1());

    getMedicalFacilityClinicStayRadioItem2().setButtonIndex(2);

    getMedicalFacilityClinicStayRadioModel().add(getMedicalFacilityClinicStayRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityClinicStayRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityClinicStayRadioItem2(){

  }

  /**
   * �������Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityClinicStandardRadio(){

  }

  /**
   * �������Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityClinicStandardRadioModel(){

    getMedicalFacilityClinicStandardRadioItem1().setButtonIndex(1);

    getMedicalFacilityClinicStandardRadioModel().add(getMedicalFacilityClinicStandardRadioItem1());

    getMedicalFacilityClinicStandardRadioItem2().setButtonIndex(2);

    getMedicalFacilityClinicStandardRadioModel().add(getMedicalFacilityClinicStandardRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityClinicStandardRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityClinicStandardRadioItem2(){

  }

  /**
   * ���Ȏ�f�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityClinicMedicalExaminationRadio(){

  }

  /**
   * ���Ȏ�f���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityClinicMedicalExaminationRadioModel(){

    getMedicalFacilityClinicMedicalExaminationRadioItem1().setButtonIndex(1);

    getMedicalFacilityClinicMedicalExaminationRadioModel().add(getMedicalFacilityClinicMedicalExaminationRadioItem1());

    getMedicalFacilityClinicMedicalExaminationRadioItem2().setButtonIndex(2);

    getMedicalFacilityClinicMedicalExaminationRadioModel().add(getMedicalFacilityClinicMedicalExaminationRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityClinicMedicalExaminationRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityClinicMedicalExaminationRadioItem2(){

  }

  /**
   * �h�{�Ǘ��̐����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityClinicNutritionManageRadio(){

  }

  /**
   * �h�{�Ǘ��̐����Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityClinicNutritionManageRadioModel(){

    getMedicalFacilityClinicNutritionManageRadioItem1().setButtonIndex(1);

    getMedicalFacilityClinicNutritionManageRadioModel().add(getMedicalFacilityClinicNutritionManageRadioItem1());

    getMedicalFacilityClinicNutritionManageRadioItem2().setButtonIndex(2);

    getMedicalFacilityClinicNutritionManageRadioModel().add(getMedicalFacilityClinicNutritionManageRadioItem2());

    getMedicalFacilityClinicNutritionManageRadioItem3().setButtonIndex(3);

    getMedicalFacilityClinicNutritionManageRadioModel().add(getMedicalFacilityClinicNutritionManageRadioItem3());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityClinicNutritionManageRadioItem1(){

  }

  /**
   * �Ǘ��h�{�m�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityClinicNutritionManageRadioItem2(){

  }

  /**
   * �h�{�m�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityClinicNutritionManageRadioItem3(){

  }

  /**
   * �h�{�}�l�W�����g���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityClinicNutritionRadio(){

  }

  /**
   * �h�{�}�l�W�����g���Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityClinicNutritionRadioModel(){

    getMedicalFacilityClinicNutritionRadioItem1().setButtonIndex(1);

    getMedicalFacilityClinicNutritionRadioModel().add(getMedicalFacilityClinicNutritionRadioItem1());

    getMedicalFacilityClinicNutritionRadioItem2().setButtonIndex(2);

    getMedicalFacilityClinicNutritionRadioModel().add(getMedicalFacilityClinicNutritionRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityClinicNutritionRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityClinicNutritionRadioItem2(){

  }

  /**
   * �^�u2�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTab2(){

    tab2.add(getMedicalFacilityClinicOralSwitchRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getOralMaintenanceAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getMedicalFacilityClinicRecuperateDinnerRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getMedicalFacilityClinicHijoAddition(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getMedicalFacilityClinicConsultationFee(), VRLayout.FLOW);

    tab2.add(getMedicalFacilityClinicConsultationFeeLabel(), VRLayout.FLOW_RETURN);

    tab2.add(getMedicalFacilityClinicSubstractionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getMedicalFacilityClinicDinnerContainer(), VRLayout.FLOW_DOUBLEINSETLINE_RETURN);

  }

  /**
   * �o���ڍs���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityClinicOralSwitchRadio(){

  }

  /**
   * �o���ڍs���Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityClinicOralSwitchRadioModel(){

    getMedicalFacilityClinicOralSwitchRadioItem1().setButtonIndex(1);

    getMedicalFacilityClinicOralSwitchRadioModel().add(getMedicalFacilityClinicOralSwitchRadioItem1());

    getMedicalFacilityClinicOralSwitchRadioItem2().setButtonIndex(2);

    getMedicalFacilityClinicOralSwitchRadioModel().add(getMedicalFacilityClinicOralSwitchRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityClinicOralSwitchRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityClinicOralSwitchRadioItem2(){

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
   * �×{�H���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityClinicRecuperateDinnerRadio(){

  }

  /**
   * �×{�H���Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityClinicRecuperateDinnerRadioModel(){

    getMedicalFacilityClinicRecuperateDinnerRadioItem1().setButtonIndex(1);

    getMedicalFacilityClinicRecuperateDinnerRadioModel().add(getMedicalFacilityClinicRecuperateDinnerRadioItem1());

    getMedicalFacilityClinicRecuperateDinnerRadioItem2().setButtonIndex(2);

    getMedicalFacilityClinicRecuperateDinnerRadioModel().add(getMedicalFacilityClinicRecuperateDinnerRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityClinicRecuperateDinnerRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityClinicRecuperateDinnerRadioItem2(){

  }

  /**
   * �ޏ��֘A���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityClinicHijoAddition(){

    medicalFacilityClinicHijoAddition.add(getLeavingHospitalPreConsultationAddition(), VRLayout.FLOW_RETURN);

    medicalFacilityClinicHijoAddition.add(getLeavingHospitalConsultationAddition(), VRLayout.FLOW_RETURN);

    medicalFacilityClinicHijoAddition.add(getLeavingHospitalDissemination(), VRLayout.FLOW_RETURN);

    medicalFacilityClinicHijoAddition.add(getLeavingHospitalCooperationAddition(), VRLayout.FLOW_RETURN);

    medicalFacilityClinicHijoAddition.add(getLeavingHospital(), VRLayout.FLOW_RETURN);

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
  protected void addMedicalFacilityClinicConsultationFee(){

  }

  /**
   * ���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityClinicConsultationFeeLabel(){

  }

  /**
   * �l�����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityClinicSubstractionRadio(){

  }

  /**
   * �l�����Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityClinicSubstractionRadioModel(){

    getMedicalFacilityClinicSubstractionRadioItem1().setButtonIndex(1);

    getMedicalFacilityClinicSubstractionRadioModel().add(getMedicalFacilityClinicSubstractionRadioItem1());

    getMedicalFacilityClinicSubstractionRadioItem2().setButtonIndex(2);

    getMedicalFacilityClinicSubstractionRadioModel().add(getMedicalFacilityClinicSubstractionRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityClinicSubstractionRadioItem1(){

  }

  /**
   * ������߂ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityClinicSubstractionRadioItem2(){

  }

  /**
   * �H���R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityClinicDinnerContainer(){

    medicalFacilityClinicDinnerContainer.add(getMedicalFacilityClinicDinnerOfferContainer(), VRLayout.FLOW);

    medicalFacilityClinicDinnerContainer.add(getMedicalFacilityClinicDinnerCostContainer(), VRLayout.FLOW);

  }

  /**
   * �H���񋟂ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityClinicDinnerOffer(){

  }

  /**
   * �H���񋟃��f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityClinicDinnerOfferModel(){

  }

  /**
   * �H����p�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityClinicDinnerCost(){

  }

  /**
   * �^�u3�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTab3(){

    tab3.add(getUnitCareMaintenanceRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab3.add(getBodyRestraintAbolitionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab3.add(getStayReturnSupportAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab3.add(getMedicalFacilityClinicCalculationDivisionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

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
   * �Z��敪�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityClinicCalculationDivisionRadio(){

  }

  /**
   * �Z��敪���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityClinicCalculationDivisionRadioModel(){

    getMedicalFacilityClinicCalculationDivisionRadioItem1().setButtonIndex(1);

    getMedicalFacilityClinicCalculationDivisionRadioModel().add(getMedicalFacilityClinicCalculationDivisionRadioItem1());

    getMedicalFacilityClinicCalculationDivisionRadioItem2().setButtonIndex(2);

    getMedicalFacilityClinicCalculationDivisionRadioModel().add(getMedicalFacilityClinicCalculationDivisionRadioItem2());

  }

  /**
   * �ʏ�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityClinicCalculationDivisionRadioItem1(){

  }

  /**
   * ���Z�݂̂ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityClinicCalculationDivisionRadioItem2(){

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
      ACFrame.debugStart(new ACAffairInfo(QS001121_H2004Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QS001121_H2004Design getThis() {
    return this;
  }
}
