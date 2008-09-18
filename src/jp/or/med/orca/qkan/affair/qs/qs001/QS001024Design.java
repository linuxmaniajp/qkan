
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
 * �J����: ���}�@�M�u
 * �쐬��: 2006/02/16  ���{�R���s���[�^�[������� ���}�@�M�u �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �T�[�r�X�\��쐬/�ύX (S)
 * �v���Z�X �T�[�r�X�\��T�� (001)
 * �v���O���� �T�[�r�X�p�^�[�����×{�^��Î{�݁i�f�Ï��j (QS001024)
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
import jp.or.med.orca.qkan.lib.*;
import jp.or.med.orca.qkan.text.*;
/**
 * �T�[�r�X�p�^�[�����×{�^��Î{�݁i�f�Ï��j��ʍ��ڃf�U�C��(QS001024) 
 */
public class QS001024Design extends QS001ServicePanel {
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

  private ACClearableRadioButtonGroup medicalFacilityClinicEnvironmentalRadio;

  private ACLabelContainer medicalFacilityClinicEnvironmentalRadioContainer;

  private ACListModelAdapter medicalFacilityClinicEnvironmentalRadioModel;

  private ACRadioButtonItem medicalFacilityClinicEnvironmentalRadioItem1;

  private ACRadioButtonItem medicalFacilityClinicEnvironmentalRadioItem2;

  private ACRadioButtonItem medicalFacilityClinicEnvironmentalRadioItem3;

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

  private ACClearableRadioButtonGroup medicalFacilityClinicOralSwitchRadio;

  private ACLabelContainer medicalFacilityClinicOralSwitchRadioContainer;

  private ACListModelAdapter medicalFacilityClinicOralSwitchRadioModel;

  private ACRadioButtonItem medicalFacilityClinicOralSwitchRadioItem1;

  private ACRadioButtonItem medicalFacilityClinicOralSwitchRadioItem2;

  private ACClearableRadioButtonGroup medicalFacilityClinicRecuperateDinnerRadio;

  private ACLabelContainer medicalFacilityClinicRecuperateDinnerRadioContainer;

  private ACListModelAdapter medicalFacilityClinicRecuperateDinnerRadioModel;

  private ACRadioButtonItem medicalFacilityClinicRecuperateDinnerRadioItem1;

  private ACRadioButtonItem medicalFacilityClinicRecuperateDinnerRadioItem2;

  private ACPanel tab2;

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
   * �{�݋敪���擾���܂��B
   * @return �{�݋敪
   */
  public ACClearableRadioButtonGroup getMedicalFacilityClinicInstitutionDivisionRadio(){
    if(medicalFacilityClinicInstitutionDivisionRadio==null){

      medicalFacilityClinicInstitutionDivisionRadio = new ACClearableRadioButtonGroup();

      getMedicalFacilityClinicInstitutionDivisionRadioContainer().setText("�{�݋敪");

      medicalFacilityClinicInstitutionDivisionRadio.setBindPath("1530201");

      medicalFacilityClinicInstitutionDivisionRadio.setModel(getMedicalFacilityClinicInstitutionDivisionRadioModel());

      medicalFacilityClinicInstitutionDivisionRadio.setUseClearButton(false);

      addMedicalFacilityClinicInstitutionDivisionRadio();
    }
    return medicalFacilityClinicInstitutionDivisionRadio;

  }

  /**
   * �{�݋敪�R���e�i���擾���܂��B
   * @return �{�݋敪�R���e�i
   */
  protected ACLabelContainer getMedicalFacilityClinicInstitutionDivisionRadioContainer(){
    if(medicalFacilityClinicInstitutionDivisionRadioContainer==null){
      medicalFacilityClinicInstitutionDivisionRadioContainer = new ACLabelContainer();
      medicalFacilityClinicInstitutionDivisionRadioContainer.setFollowChildEnabled(true);
      medicalFacilityClinicInstitutionDivisionRadioContainer.add(getMedicalFacilityClinicInstitutionDivisionRadio(), null);
    }
    return medicalFacilityClinicInstitutionDivisionRadioContainer;
  }

  /**
   * �{�݋敪���f�����擾���܂��B
   * @return �{�݋敪���f��
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

      medicalFacilityClinicDivision.setModel(getMedicalFacilityClinicDivisionModel());

      medicalFacilityClinicDivision.setUseClearButton(false);

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

      medicalFacilityClinicHospitalRoomRadio.setModel(getMedicalFacilityClinicHospitalRoomRadioModel());

      medicalFacilityClinicHospitalRoomRadio.setUseClearButton(false);

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

      medicalFacilityClinicUnitHospitalRoomRadio.setModel(getMedicalFacilityClinicUnitHospitalRoomRadioModel());

      medicalFacilityClinicUnitHospitalRoomRadio.setUseClearButton(false);

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
  public ACClearableRadioButtonGroup getMedicalFacilityClinicEnvironmentalRadio(){
    if(medicalFacilityClinicEnvironmentalRadio==null){

      medicalFacilityClinicEnvironmentalRadio = new ACClearableRadioButtonGroup();

      getMedicalFacilityClinicEnvironmentalRadioContainer().setText("�×{���");

      medicalFacilityClinicEnvironmentalRadio.setBindPath("1530205");

      medicalFacilityClinicEnvironmentalRadio.setModel(getMedicalFacilityClinicEnvironmentalRadioModel());

      medicalFacilityClinicEnvironmentalRadio.setUseClearButton(false);

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
   * ���ZI���擾���܂��B
   * @return ���ZI
   */
  public ACRadioButtonItem getMedicalFacilityClinicEnvironmentalRadioItem2(){
    if(medicalFacilityClinicEnvironmentalRadioItem2==null){

      medicalFacilityClinicEnvironmentalRadioItem2 = new ACRadioButtonItem();

      medicalFacilityClinicEnvironmentalRadioItem2.setText("���Z�^I");

      medicalFacilityClinicEnvironmentalRadioItem2.setGroup(getMedicalFacilityClinicEnvironmentalRadio());

      medicalFacilityClinicEnvironmentalRadioItem2.setConstraints(VRLayout.FLOW);

      addMedicalFacilityClinicEnvironmentalRadioItem2();
    }
    return medicalFacilityClinicEnvironmentalRadioItem2;

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
   * �O�����Z���擾���܂��B
   * @return �O�����Z
   */
  public ACClearableRadioButtonGroup getMedicalFacilityClinicStayRadio(){
    if(medicalFacilityClinicStayRadio==null){

      medicalFacilityClinicStayRadio = new ACClearableRadioButtonGroup();

      getMedicalFacilityClinicStayRadioContainer().setText("�O�����Z");

      medicalFacilityClinicStayRadio.setBindPath("1530206");

      medicalFacilityClinicStayRadio.setModel(getMedicalFacilityClinicStayRadioModel());

      medicalFacilityClinicStayRadio.setUseClearButton(false);

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

      medicalFacilityClinicStandardRadio.setModel(getMedicalFacilityClinicStandardRadioModel());

      medicalFacilityClinicStandardRadio.setUseClearButton(false);

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

      medicalFacilityClinicMedicalExaminationRadio.setModel(getMedicalFacilityClinicMedicalExaminationRadioModel());

      medicalFacilityClinicMedicalExaminationRadio.setUseClearButton(false);

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

      medicalFacilityClinicNutritionManageRadio.setModel(getMedicalFacilityClinicNutritionManageRadioModel());

      medicalFacilityClinicNutritionManageRadio.setUseClearButton(false);

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
   * �Ǘ��h�{�m�z�u���Z���擾���܂��B
   * @return �Ǘ��h�{�m�z�u���Z
   */
  public ACRadioButtonItem getMedicalFacilityClinicNutritionManageRadioItem2(){
    if(medicalFacilityClinicNutritionManageRadioItem2==null){

      medicalFacilityClinicNutritionManageRadioItem2 = new ACRadioButtonItem();

      medicalFacilityClinicNutritionManageRadioItem2.setText("�Ǘ��h�{�m�z�u���Z");

      medicalFacilityClinicNutritionManageRadioItem2.setGroup(getMedicalFacilityClinicNutritionManageRadio());

      medicalFacilityClinicNutritionManageRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

      addMedicalFacilityClinicNutritionManageRadioItem2();
    }
    return medicalFacilityClinicNutritionManageRadioItem2;

  }

  /**
   * �h�{�m�z�u���Z���擾���܂��B
   * @return �h�{�m�z�u���Z
   */
  public ACRadioButtonItem getMedicalFacilityClinicNutritionManageRadioItem3(){
    if(medicalFacilityClinicNutritionManageRadioItem3==null){

      medicalFacilityClinicNutritionManageRadioItem3 = new ACRadioButtonItem();

      medicalFacilityClinicNutritionManageRadioItem3.setText("�h�{�m�z�u���Z");

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

      medicalFacilityClinicNutritionRadio.setModel(getMedicalFacilityClinicNutritionRadioModel());

      medicalFacilityClinicNutritionRadio.setUseClearButton(false);

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
   * �o���ڍs���Z���擾���܂��B
   * @return �o���ڍs���Z
   */
  public ACClearableRadioButtonGroup getMedicalFacilityClinicOralSwitchRadio(){
    if(medicalFacilityClinicOralSwitchRadio==null){

      medicalFacilityClinicOralSwitchRadio = new ACClearableRadioButtonGroup();

      getMedicalFacilityClinicOralSwitchRadioContainer().setText("�o���ڍs���Z");

      medicalFacilityClinicOralSwitchRadio.setBindPath("1530211");

      medicalFacilityClinicOralSwitchRadio.setModel(getMedicalFacilityClinicOralSwitchRadioModel());

      medicalFacilityClinicOralSwitchRadio.setUseClearButton(false);

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
   * �×{�H���Z���擾���܂��B
   * @return �×{�H���Z
   */
  public ACClearableRadioButtonGroup getMedicalFacilityClinicRecuperateDinnerRadio(){
    if(medicalFacilityClinicRecuperateDinnerRadio==null){

      medicalFacilityClinicRecuperateDinnerRadio = new ACClearableRadioButtonGroup();

      getMedicalFacilityClinicRecuperateDinnerRadioContainer().setText("�×{�H���Z");

      medicalFacilityClinicRecuperateDinnerRadio.setBindPath("1530212");

      medicalFacilityClinicRecuperateDinnerRadio.setModel(getMedicalFacilityClinicRecuperateDinnerRadioModel());

      medicalFacilityClinicRecuperateDinnerRadio.setUseClearButton(false);

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
   * �ޏ��֘A���Z���擾���܂��B
   * @return �ޏ��֘A���Z
   */
  public ACLabelContainer getMedicalFacilityClinicHijoAddition(){
    if(medicalFacilityClinicHijoAddition==null){

      medicalFacilityClinicHijoAddition = new ACLabelContainer();

      medicalFacilityClinicHijoAddition.setText("�ޏ��֘A���Z");

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

      leavingHospitalPreConsultationAddition.setText("�ޏ��O��K��w�����Z");

      leavingHospitalPreConsultationAddition.setBindPath("3020104");

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

      leavingHospitalConsultationAddition.setText("�ޏ����w�����Z");

      leavingHospitalConsultationAddition.setBindPath("3020105");

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

      leavingHospitalDissemination.setText("�ޏ������񋟉��Z");

      leavingHospitalDissemination.setBindPath("3020106");

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

      leavingHospitalCooperationAddition.setText("�ޏ��O�A�g���Z");

      leavingHospitalCooperationAddition.setBindPath("3020107");

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

      medicalFacilityClinicSubstractionRadio.setModel(getMedicalFacilityClinicSubstractionRadioModel());

      medicalFacilityClinicSubstractionRadio.setUseClearButton(false);

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

      medicalFacilityClinicDinnerOffer.setModel(getMedicalFacilityClinicDinnerOfferModel());

      medicalFacilityClinicDinnerOffer.setRenderBindPath("CONTENT");

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
      medicalFacilityClinicDinnerCostContainer.add(getMedicalFacilityClinicDinnerCost(), null);
    }
    return medicalFacilityClinicDinnerCostContainer;
  }

  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001024Design() {

    try {
      initialize();

      initAffair(null);

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

    this.add(getTabs(), VRLayout.WEST);

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

    tab1.add(getMedicalFacilityClinicInstitutionDivisionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getMedicalFacilityClinicDivisionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getMedicalFacilityClinicHospitalRoomContena(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getMedicalFacilityClinicEnvironmentalRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getMedicalFacilityClinicStayRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getMedicalFacilityClinicStandardRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getMedicalFacilityClinicMedicalExaminationRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getMedicalFacilityClinicNutritionManageRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getMedicalFacilityClinicNutritionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getMedicalFacilityClinicOralSwitchRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getMedicalFacilityClinicRecuperateDinnerRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * �{�݋敪�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityClinicInstitutionDivisionRadio(){

  }

  /**
   * �{�݋敪���f���ɓ������ڂ�ǉ����܂��B
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

    getMedicalFacilityClinicEnvironmentalRadioItem2().setButtonIndex(2);
    getMedicalFacilityClinicEnvironmentalRadioModel().add(getMedicalFacilityClinicEnvironmentalRadioItem2());

    getMedicalFacilityClinicEnvironmentalRadioItem3().setButtonIndex(3);
    getMedicalFacilityClinicEnvironmentalRadioModel().add(getMedicalFacilityClinicEnvironmentalRadioItem3());

  }

  /**
   * ��^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityClinicEnvironmentalRadioItem1(){

  }

  /**
   * ���ZI�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityClinicEnvironmentalRadioItem2(){

  }

  /**
   * ���ZII�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityClinicEnvironmentalRadioItem3(){

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
   * �Ǘ��h�{�m�z�u���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityClinicNutritionManageRadioItem2(){

  }

  /**
   * �h�{�m�z�u���Z�ɓ������ڂ�ǉ����܂��B
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
   * �^�u2�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTab2(){

    tab2.add(getMedicalFacilityClinicHijoAddition(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getMedicalFacilityClinicConsultationFee(), VRLayout.FLOW);

    tab2.add(getMedicalFacilityClinicConsultationFeeLabel(), VRLayout.FLOW_RETURN);

    tab2.add(getMedicalFacilityClinicSubstractionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getMedicalFacilityClinicDinnerContainer(), VRLayout.FLOW_DOUBLEINSETLINE_RETURN);

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
      ACFrame.getInstance().getContentPane().add(new QS001024Design());
      ACFrame.getInstance().setVisible(true);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QS001024Design getThis() {
    return this;
  }
}
