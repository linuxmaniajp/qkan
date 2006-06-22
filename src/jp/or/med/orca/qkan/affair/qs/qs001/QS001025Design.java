
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
 * �쐬��: 2006/02/05  ���{�R���s���[�^�[������� ���}�@�M�u �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �T�[�r�X�\��쐬/�ύX (S)
 * �v���Z�X �T�[�r�X�\��T�� (001)
 * �v���O���� �T�[�r�X�p�^�[�����×{�^��Î{�݁i�F�m�ǁj (QS001025)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
import java.awt.Color;
import java.awt.Component;
import java.awt.im.InputSubset;

import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;

import jp.nichicom.ac.component.ACClearableRadioButtonGroup;
import jp.nichicom.ac.component.ACComboBox;
import jp.nichicom.ac.component.ACIntegerCheckBox;
import jp.nichicom.ac.component.ACLabel;
import jp.nichicom.ac.component.ACMapBindButton;
import jp.nichicom.ac.component.ACRadioButtonItem;
import jp.nichicom.ac.component.ACTextField;
import jp.nichicom.ac.container.ACBackLabelContainer;
import jp.nichicom.ac.container.ACLabelContainer;
import jp.nichicom.ac.container.ACPanel;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.util.adapter.ACComboBoxModelAdapter;
import jp.nichicom.ac.util.adapter.ACListModelAdapter;
import jp.nichicom.vr.layout.VRLayout;
import jp.nichicom.vr.text.VRCharType;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
/**
 * �T�[�r�X�p�^�[�����×{�^��Î{�݁i�F�m�ǁj��ʍ��ڃf�U�C��(QS001025) 
 */
public class QS001025Design extends QS001ServicePanel {
  //GUI�R���|�[�l���g

  private JTabbedPane tabs;

  private ACPanel tab1;

  private ACClearableRadioButtonGroup medicalFacilityCognitiveHospitalInstitutionDivisionRadio;

  private ACLabelContainer medicalFacilityCognitiveHospitalInstitutionDivisionRadioContainer;

  private ACListModelAdapter medicalFacilityCognitiveHospitalInstitutionDivisionRadioModel;

  private ACRadioButtonItem medicalFacilityCognitiveHospitalHospitalInstitutionDivisionRadioItem1;

  private ACRadioButtonItem medicalFacilityCognitiveHospitalHospitalInstitutionDivisionRadioItem2;

  private ACClearableRadioButtonGroup medicalFacilityCognitiveHospitalHospitalDivision;

  private ACLabelContainer medicalFacilityCognitiveHospitalHospitalDivisionContainer;

  private ACListModelAdapter medicalFacilityCognitiveHospitalHospitalDivisionModel;

  private ACRadioButtonItem medicalFacilityCognitiveHospitalDivision1;

  private ACRadioButtonItem medicalFacilityCognitiveHospitalDivision2;

  private ACRadioButtonItem medicalFacilityCognitiveHospitalDivision3;

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

  private ACClearableRadioButtonGroup medicalFacilityCognitiveHospitalNutritionManageRadio;

  private ACLabelContainer medicalFacilityCognitiveHospitalNutritionManageRadioContainer;

  private ACListModelAdapter medicalFacilityCognitiveHospitalNutritionManageRadioModel;

  private ACRadioButtonItem medicalFacilityCognitiveHospitalNutritionManageRadioItem1;

  private ACRadioButtonItem medicalFacilityCognitiveHospitalNutritionManageRadioItem2;

  private ACRadioButtonItem medicalFacilityCognitiveHospitalNutritionManageRadioItem3;

  private ACClearableRadioButtonGroup medicalFacilityCognitiveHospitalNutritionRadio;

  private ACLabelContainer medicalFacilityCognitiveHospitalNutritionRadioContainer;

  private ACListModelAdapter medicalFacilityCognitiveHospitalNutritionRadioModel;

  private ACRadioButtonItem medicalFacilityCognitiveHospitalNutritionRadioItem1;

  private ACRadioButtonItem medicalFacilityCognitiveHospitalNutritionRadioItem2;

  private ACClearableRadioButtonGroup medicalFacilityCognitiveHospitalOralSwitchRadio;

  private ACLabelContainer medicalFacilityCognitiveHospitalOralSwitchRadioContainer;

  private ACListModelAdapter medicalFacilityCognitiveHospitalOralSwitchRadioModel;

  private ACRadioButtonItem medicalFacilityCognitiveHospitalOralSwitchRadioItem1;

  private ACRadioButtonItem medicalFacilityCognitiveHospitalOralSwitchRadioItem2;

  private ACClearableRadioButtonGroup medicalFacilityCognitiveHospitalRecuperateDinnerRadio;

  private ACLabelContainer medicalFacilityCognitiveHospitalRecuperateDinnerRadioContainer;

  private ACListModelAdapter medicalFacilityCognitiveHospitalRecuperateDinnerRadioModel;

  private ACRadioButtonItem medicalFacilityCognitiveHospitalRecuperateDinnerRadioItem1;

  private ACRadioButtonItem medicalFacilityCognitiveHospitalRecuperateDinnerRadioItem2;

  private ACPanel tab2;

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
  public ACClearableRadioButtonGroup getMedicalFacilityCognitiveHospitalInstitutionDivisionRadio(){
    if(medicalFacilityCognitiveHospitalInstitutionDivisionRadio==null){

      medicalFacilityCognitiveHospitalInstitutionDivisionRadio = new ACClearableRadioButtonGroup();

      getMedicalFacilityCognitiveHospitalInstitutionDivisionRadioContainer().setText("�{�݋敪");

      medicalFacilityCognitiveHospitalInstitutionDivisionRadio.setBindPath("1530301");

      medicalFacilityCognitiveHospitalInstitutionDivisionRadio.setModel(getMedicalFacilityCognitiveHospitalInstitutionDivisionRadioModel());

      medicalFacilityCognitiveHospitalInstitutionDivisionRadio.setUseClearButton(false);

      addMedicalFacilityCognitiveHospitalInstitutionDivisionRadio();
    }
    return medicalFacilityCognitiveHospitalInstitutionDivisionRadio;

  }

  /**
   * �{�݋敪�R���e�i���擾���܂��B
   * @return �{�݋敪�R���e�i
   */
  protected ACLabelContainer getMedicalFacilityCognitiveHospitalInstitutionDivisionRadioContainer(){
    if(medicalFacilityCognitiveHospitalInstitutionDivisionRadioContainer==null){
      medicalFacilityCognitiveHospitalInstitutionDivisionRadioContainer = new ACLabelContainer();
      medicalFacilityCognitiveHospitalInstitutionDivisionRadioContainer.add(getMedicalFacilityCognitiveHospitalInstitutionDivisionRadio(), null);
    }
    return medicalFacilityCognitiveHospitalInstitutionDivisionRadioContainer;
  }

  /**
   * �{�݋敪���f�����擾���܂��B
   * @return �{�݋敪���f��
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

      medicalFacilityCognitiveHospitalHospitalInstitutionDivisionRadioItem2.setConstraints(VRLayout.FLOW);

      addMedicalFacilityCognitiveHospitalHospitalInstitutionDivisionRadioItem2();
    }
    return medicalFacilityCognitiveHospitalHospitalInstitutionDivisionRadioItem2;

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

      medicalFacilityCognitiveHospitalHospitalDivision.setModel(getMedicalFacilityCognitiveHospitalHospitalDivisionModel());

      medicalFacilityCognitiveHospitalHospitalDivision.setUseClearButton(false);

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

      medicalFacilityCognitiveHospitalDivision3.setConstraints(VRLayout.FLOW);

      addMedicalFacilityCognitiveHospitalDivision3();
    }
    return medicalFacilityCognitiveHospitalDivision3;

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

      medicalFacilityCognitiveHospitalHospitalRoomRadio.setModel(getMedicalFacilityCognitiveHospitalHospitalRoomRadioModel());

      medicalFacilityCognitiveHospitalHospitalRoomRadio.setUseClearButton(false);

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

      medicalFacilityCognitiveHospitalUnitHospitalRoomRadio.setModel(getMedicalFacilityCognitiveHospitalUnitHospitalRoomRadioModel());

      medicalFacilityCognitiveHospitalUnitHospitalRoomRadio.setUseClearButton(false);

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

      medicalFacilityCognitiveHospitalStayRadio.setModel(getMedicalFacilityCognitiveHospitalStayRadioModel());

      medicalFacilityCognitiveHospitalStayRadio.setUseClearButton(false);

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

      medicalFacilityCognitiveHospitalStandardRadio.setModel(getMedicalFacilityCognitiveHospitalStandardRadioModel());

      medicalFacilityCognitiveHospitalStandardRadio.setUseClearButton(false);

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

      medicalFacilityCognitiveHospitalMedicalExaminationRadio.setModel(getMedicalFacilityCognitiveHospitalMedicalExaminationRadioModel());

      medicalFacilityCognitiveHospitalMedicalExaminationRadio.setUseClearButton(false);

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
   * �h�{�Ǘ��̐����Z���擾���܂��B
   * @return �h�{�Ǘ��̐����Z
   */
  public ACClearableRadioButtonGroup getMedicalFacilityCognitiveHospitalNutritionManageRadio(){
    if(medicalFacilityCognitiveHospitalNutritionManageRadio==null){

      medicalFacilityCognitiveHospitalNutritionManageRadio = new ACClearableRadioButtonGroup();

      getMedicalFacilityCognitiveHospitalNutritionManageRadioContainer().setText("�h�{�Ǘ��̐����Z");

      medicalFacilityCognitiveHospitalNutritionManageRadio.setBindPath("1530308");

      medicalFacilityCognitiveHospitalNutritionManageRadio.setModel(getMedicalFacilityCognitiveHospitalNutritionManageRadioModel());

      medicalFacilityCognitiveHospitalNutritionManageRadio.setUseClearButton(false);

      addMedicalFacilityCognitiveHospitalNutritionManageRadio();
    }
    return medicalFacilityCognitiveHospitalNutritionManageRadio;

  }

  /**
   * �h�{�Ǘ��̐����Z�R���e�i���擾���܂��B
   * @return �h�{�Ǘ��̐����Z�R���e�i
   */
  protected ACLabelContainer getMedicalFacilityCognitiveHospitalNutritionManageRadioContainer(){
    if(medicalFacilityCognitiveHospitalNutritionManageRadioContainer==null){
      medicalFacilityCognitiveHospitalNutritionManageRadioContainer = new ACLabelContainer();
      medicalFacilityCognitiveHospitalNutritionManageRadioContainer.add(getMedicalFacilityCognitiveHospitalNutritionManageRadio(), null);
    }
    return medicalFacilityCognitiveHospitalNutritionManageRadioContainer;
  }

  /**
   * �h�{�Ǘ��̐����Z���f�����擾���܂��B
   * @return �h�{�Ǘ��̐����Z���f��
   */
  protected ACListModelAdapter getMedicalFacilityCognitiveHospitalNutritionManageRadioModel(){
    if(medicalFacilityCognitiveHospitalNutritionManageRadioModel==null){
      medicalFacilityCognitiveHospitalNutritionManageRadioModel = new ACListModelAdapter();
      addMedicalFacilityCognitiveHospitalNutritionManageRadioModel();
    }
    return medicalFacilityCognitiveHospitalNutritionManageRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getMedicalFacilityCognitiveHospitalNutritionManageRadioItem1(){
    if(medicalFacilityCognitiveHospitalNutritionManageRadioItem1==null){

      medicalFacilityCognitiveHospitalNutritionManageRadioItem1 = new ACRadioButtonItem();

      medicalFacilityCognitiveHospitalNutritionManageRadioItem1.setText("�Ȃ�");

      medicalFacilityCognitiveHospitalNutritionManageRadioItem1.setGroup(getMedicalFacilityCognitiveHospitalNutritionManageRadio());

      medicalFacilityCognitiveHospitalNutritionManageRadioItem1.setConstraints(VRLayout.FLOW);

      addMedicalFacilityCognitiveHospitalNutritionManageRadioItem1();
    }
    return medicalFacilityCognitiveHospitalNutritionManageRadioItem1;

  }

  /**
   * �Ǘ��h�{�m�z�u���Z���擾���܂��B
   * @return �Ǘ��h�{�m�z�u���Z
   */
  public ACRadioButtonItem getMedicalFacilityCognitiveHospitalNutritionManageRadioItem2(){
    if(medicalFacilityCognitiveHospitalNutritionManageRadioItem2==null){

      medicalFacilityCognitiveHospitalNutritionManageRadioItem2 = new ACRadioButtonItem();

      medicalFacilityCognitiveHospitalNutritionManageRadioItem2.setText("�Ǘ��h�{�m�z�u���Z");

      medicalFacilityCognitiveHospitalNutritionManageRadioItem2.setGroup(getMedicalFacilityCognitiveHospitalNutritionManageRadio());

      medicalFacilityCognitiveHospitalNutritionManageRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

      addMedicalFacilityCognitiveHospitalNutritionManageRadioItem2();
    }
    return medicalFacilityCognitiveHospitalNutritionManageRadioItem2;

  }

  /**
   * �h�{�m�z�u���Z���擾���܂��B
   * @return �h�{�m�z�u���Z
   */
  public ACRadioButtonItem getMedicalFacilityCognitiveHospitalNutritionManageRadioItem3(){
    if(medicalFacilityCognitiveHospitalNutritionManageRadioItem3==null){

      medicalFacilityCognitiveHospitalNutritionManageRadioItem3 = new ACRadioButtonItem();

      medicalFacilityCognitiveHospitalNutritionManageRadioItem3.setText("�h�{�m�z�u���Z");

      medicalFacilityCognitiveHospitalNutritionManageRadioItem3.setGroup(getMedicalFacilityCognitiveHospitalNutritionManageRadio());

      medicalFacilityCognitiveHospitalNutritionManageRadioItem3.setConstraints(VRLayout.FLOW);

      addMedicalFacilityCognitiveHospitalNutritionManageRadioItem3();
    }
    return medicalFacilityCognitiveHospitalNutritionManageRadioItem3;

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

      medicalFacilityCognitiveHospitalNutritionRadio.setModel(getMedicalFacilityCognitiveHospitalNutritionRadioModel());

      medicalFacilityCognitiveHospitalNutritionRadio.setUseClearButton(false);

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
  public ACClearableRadioButtonGroup getMedicalFacilityCognitiveHospitalOralSwitchRadio(){
    if(medicalFacilityCognitiveHospitalOralSwitchRadio==null){

      medicalFacilityCognitiveHospitalOralSwitchRadio = new ACClearableRadioButtonGroup();

      getMedicalFacilityCognitiveHospitalOralSwitchRadioContainer().setText("�o���ڍs���Z");

      medicalFacilityCognitiveHospitalOralSwitchRadio.setBindPath("1530310");

      medicalFacilityCognitiveHospitalOralSwitchRadio.setModel(getMedicalFacilityCognitiveHospitalOralSwitchRadioModel());

      medicalFacilityCognitiveHospitalOralSwitchRadio.setUseClearButton(false);

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
   * �×{�H���Z���擾���܂��B
   * @return �×{�H���Z
   */
  public ACClearableRadioButtonGroup getMedicalFacilityCognitiveHospitalRecuperateDinnerRadio(){
    if(medicalFacilityCognitiveHospitalRecuperateDinnerRadio==null){

      medicalFacilityCognitiveHospitalRecuperateDinnerRadio = new ACClearableRadioButtonGroup();

      getMedicalFacilityCognitiveHospitalRecuperateDinnerRadioContainer().setText("�×{�H���Z");

      medicalFacilityCognitiveHospitalRecuperateDinnerRadio.setBindPath("1530311");

      medicalFacilityCognitiveHospitalRecuperateDinnerRadio.setModel(getMedicalFacilityCognitiveHospitalRecuperateDinnerRadioModel());

      medicalFacilityCognitiveHospitalRecuperateDinnerRadio.setUseClearButton(false);

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
  public ACLabelContainer getMedicalFacilityCognitiveHospitalHijoAddition(){
    if(medicalFacilityCognitiveHospitalHijoAddition==null){

      medicalFacilityCognitiveHospitalHijoAddition = new ACLabelContainer();

      medicalFacilityCognitiveHospitalHijoAddition.setText("�ޏ��֘A���Z");

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

      medicalFacilityCognitiveHospitalSubstraction.setModel(getMedicalFacilityCognitiveHospitalSubstractionModel());

      medicalFacilityCognitiveHospitalSubstraction.setRenderBindPath("CONTENT");

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

      medicalFacilityCognitiveHospitalDinnerOffer.setModel(getMedicalFacilityCognitiveHospitalDinnerOfferModel());

      medicalFacilityCognitiveHospitalDinnerOffer.setRenderBindPath("CONTENT");

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
      medicalFacilityCognitiveHospitalDinnerCostContainer.add(getMedicalFacilityCognitiveHospitalDinnerCost(), null);
    }
    return medicalFacilityCognitiveHospitalDinnerCostContainer;
  }

  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001025Design() {

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

    tab1.add(getMedicalFacilityCognitiveHospitalInstitutionDivisionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getMedicalFacilityCognitiveHospitalHospitalDivisionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getMedicalFacilityCognitiveHospitalHospitalRoomContena(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getMedicalFacilityCognitiveHospitalStayRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getMedicalFacilityCognitiveHospitalStandardRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getMedicalFacilityCognitiveHospitalMedicalExaminationRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getMedicalFacilityCognitiveHospitalNutritionManageRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getMedicalFacilityCognitiveHospitalNutritionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getMedicalFacilityCognitiveHospitalOralSwitchRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getMedicalFacilityCognitiveHospitalRecuperateDinnerRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * �{�݋敪�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityCognitiveHospitalInstitutionDivisionRadio(){

  }

  /**
   * �{�݋敪���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityCognitiveHospitalInstitutionDivisionRadioModel(){

    getMedicalFacilityCognitiveHospitalHospitalInstitutionDivisionRadioItem1().setButtonIndex(1);
    getMedicalFacilityCognitiveHospitalInstitutionDivisionRadioModel().add(getMedicalFacilityCognitiveHospitalHospitalInstitutionDivisionRadioItem1());

    getMedicalFacilityCognitiveHospitalHospitalInstitutionDivisionRadioItem2().setButtonIndex(2);
    getMedicalFacilityCognitiveHospitalInstitutionDivisionRadioModel().add(getMedicalFacilityCognitiveHospitalHospitalInstitutionDivisionRadioItem2());

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
   * �h�{�Ǘ��̐����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityCognitiveHospitalNutritionManageRadio(){

  }

  /**
   * �h�{�Ǘ��̐����Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityCognitiveHospitalNutritionManageRadioModel(){

    getMedicalFacilityCognitiveHospitalNutritionManageRadioItem1().setButtonIndex(1);
    getMedicalFacilityCognitiveHospitalNutritionManageRadioModel().add(getMedicalFacilityCognitiveHospitalNutritionManageRadioItem1());

    getMedicalFacilityCognitiveHospitalNutritionManageRadioItem2().setButtonIndex(2);
    getMedicalFacilityCognitiveHospitalNutritionManageRadioModel().add(getMedicalFacilityCognitiveHospitalNutritionManageRadioItem2());

    getMedicalFacilityCognitiveHospitalNutritionManageRadioItem3().setButtonIndex(3);
    getMedicalFacilityCognitiveHospitalNutritionManageRadioModel().add(getMedicalFacilityCognitiveHospitalNutritionManageRadioItem3());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityCognitiveHospitalNutritionManageRadioItem1(){

  }

  /**
   * �Ǘ��h�{�m�z�u���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityCognitiveHospitalNutritionManageRadioItem2(){

  }

  /**
   * �h�{�m�z�u���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityCognitiveHospitalNutritionManageRadioItem3(){

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
   * �^�u2�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTab2(){

    tab2.add(getMedicalFacilityCognitiveHospitalHijoAddition(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getMedicalFacilityCognitiveHospitalConsultationFee(), VRLayout.FLOW);

    tab2.add(getMedicalFacilityCognitiveHospitalConsultationFeeLabel(), VRLayout.FLOW_RETURN);

    tab2.add(getMedicalFacilityCognitiveHospitalSubstractionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getMedicalFacilityCognitiveHospitalDinnerContainer(), VRLayout.FLOW_DOUBLEINSETLINE_RETURN);

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
      ACFrame.getInstance().getContentPane().add(new QS001025Design());
      ACFrame.getInstance().setVisible(true);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QS001025Design getThis() {
    return this;
  }
}
