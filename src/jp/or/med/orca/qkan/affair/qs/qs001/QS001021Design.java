
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
 * �v���O���� �T�[�r�X�p�^�[����앟���{�� (QS001021)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
import java.awt.Component;
import java.awt.im.InputSubset;

import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;

import jp.nichicom.ac.component.ACClearableRadioButtonGroup;
import jp.nichicom.ac.component.ACComboBox;
import jp.nichicom.ac.component.ACIntegerCheckBox;
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
 * �T�[�r�X�p�^�[����앟���{�݉�ʍ��ڃf�U�C��(QS001021) 
 */
public class QS001021Design extends QS001ServicePanel {
  //GUI�R���|�[�l���g

  private JTabbedPane tabs;

  private ACPanel tab1;

  private ACClearableRadioButtonGroup kaigoWelfareFacilityInstitutionDivisionRadio;

  private ACLabelContainer kaigoWelfareFacilityInstitutionDivisionRadioContainer;

  private ACListModelAdapter kaigoWelfareFacilityInstitutionDivisionRadioModel;

  private ACRadioButtonItem kaigoWelfareFacilityInstitutionDivisionRadioItem1;

  private ACRadioButtonItem kaigoWelfareFacilityInstitutionDivisionRadioItem2;

  private ACRadioButtonItem kaigoWelfareFacilityInstitutionDivisionRadioItem3;

  private ACRadioButtonItem kaigoWelfareFacilityInstitutionDivisionRadioItem4;

  private ACLabelContainer kaigoWelfareFacilityHospitalRoomDivisionContena;

  private ACClearableRadioButtonGroup kaigoWelfareFacilityHospitalRoomDivisionRadio;

  private ACListModelAdapter kaigoWelfareFacilityHospitalRoomDivisionRadioModel;

  private ACRadioButtonItem kaigoWelfareFacilityHospitalRoomDivisionRadioItem1;

  private ACRadioButtonItem kaigoWelfareFacilityHospitalRoomDivisionRadioItem2;

  private ACClearableRadioButtonGroup kaigoWelfareFacilityUnitHospitalRoomDivisionRadio;

  private ACListModelAdapter kaigoWelfareFacilityUnitHospitalRoomDivisionRadioModel;

  private ACRadioButtonItem kaigoWelfareFacilityUnitHospitalRoomDivisionRadioItem1;

  private ACRadioButtonItem kaigoWelfareFacilityUnitHospitalRoomDivisionRadioItem2;

  private ACClearableRadioButtonGroup kaigoWelfareFacilityNightShiftSubtractionRadio;

  private ACLabelContainer kaigoWelfareFacilityNightShiftSubtractionRadioContainer;

  private ACListModelAdapter kaigoWelfareFacilityNightShiftSubtractionRadioModel;

  private ACRadioButtonItem kaigoWelfareFacilityNightShiftSubtractionRadioItem1;

  private ACRadioButtonItem kaigoWelfareFacilityNightShiftSubtractionRadioItem2;

  private ACClearableRadioButtonGroup kaigoWelfareFacilityFunctionTrainingRadio;

  private ACLabelContainer kaigoWelfareFacilityFunctionTrainingRadioContainer;

  private ACListModelAdapter kaigoWelfareFacilityFunctionTrainingRadioModel;

  private ACRadioButtonItem kaigoWelfareFacilityFunctionTrainingRadioItem2;

  private ACRadioButtonItem kaigoWelfareFacilityFunctionTrainingRadioItem1;

  private ACClearableRadioButtonGroup kaigoWelfareFacilityFacilityFulltimeDoctorRadio;

  private ACLabelContainer kaigoWelfareFacilityFacilityFulltimeDoctorRadioContainer;

  private ACListModelAdapter kaigoWelfareFacilityFacilityFulltimeDoctorRadioModel;

  private ACRadioButtonItem kaigoWelfareFacilityFacilityFulltimeDoctorRadioItem1;

  private ACRadioButtonItem kaigoWelfareFacilityFacilityFulltimeDoctorRadioItem2;

  private ACClearableRadioButtonGroup kaigoWelfareFacilityPsychiatristRadio;

  private ACLabelContainer kaigoWelfareFacilityPsychiatristRadioContainer;

  private ACListModelAdapter kaigoWelfareFacilityPsychiatristRadioModel;

  private ACRadioButtonItem kaigoWelfareFacilityPsychiatristRadioItem1;

  private ACRadioButtonItem kaigoWelfareFacilityPsychiatristRadioItem2;

  private ACClearableRadioButtonGroup kaigoWelfareFacilityHandicappedRadio;

  private ACLabelContainer kaigoWelfareFacilityHandicappedRadioContainer;

  private ACListModelAdapter kaigoWelfareFacilityHandicappedRadioModel;

  private ACRadioButtonItem kaigoWelfareFacilityHandicappedRadioItem1;

  private ACRadioButtonItem kaigoWelfareFacilityHandicappedRadioItem2;

  private ACClearableRadioButtonGroup kaigoWelfareFacilityStayingOutOvernightCostRadio;

  private ACLabelContainer kaigoWelfareFacilityStayingOutOvernightCostRadioContainer;

  private ACListModelAdapter kaigoWelfareFacilityStayingOutOvernightCostRadioModel;

  private ACRadioButtonItem kaigoWelfareFacilityStayingOutOvernightCostRadioItem1;

  private ACRadioButtonItem kaigoWelfareFacilityStayingOutOvernightCostRadioItem2;

  private ACClearableRadioButtonGroup kaigoWelfareFacilityDefaultRadio;

  private ACLabelContainer kaigoWelfareFacilityDefaultRadioContainer;

  private ACListModelAdapter kaigoWelfareFacilityDefaultRadioModel;

  private ACRadioButtonItem kaigoWelfareFacilityDefaultRadioItem1;

  private ACRadioButtonItem kaigoWelfareFacilityDefaultRadioItem2;

  private ACPanel tab2;

  private ACClearableRadioButtonGroup kaigoWelfareFacilityDieticianManageRadio;

  private ACLabelContainer kaigoWelfareFacilityDieticianManageRadioContainer;

  private ACListModelAdapter kaigoWelfareFacilityDieticianManageRadioModel;

  private ACRadioButtonItem kaigoWelfareFacilityDieticianManageRadioItem1;

  private ACRadioButtonItem kaigoWelfareFacilityDieticianManageRadioItem2;

  private ACRadioButtonItem kaigoWelfareFacilityDieticianManageRadioItem3;

  private ACClearableRadioButtonGroup kaigoWelfareFacilityNutritionRadio;

  private ACLabelContainer kaigoWelfareFacilityNutritionRadioContainer;

  private ACListModelAdapter kaigoWelfareFacilityNutritionRadioModel;

  private ACRadioButtonItem kaigoWelfareFacilityNutritionRadioItem1;

  private ACRadioButtonItem kaigoWelfareFacilityNutritionRadioItem2;

  private ACClearableRadioButtonGroup kaigoWelfareFacilityOralSwitchRadio;

  private ACLabelContainer kaigoWelfareFacilityOralSwitchRadioContainer;

  private ACListModelAdapter kaigoWelfareFacilityOralSwitchRadioModel;

  private ACRadioButtonItem kaigoWelfareFacilityOralSwitchRadioItem1;

  private ACRadioButtonItem kaigoWelfareFacilityOralSwitchRadioItem2;

  private ACClearableRadioButtonGroup kaigoWelfareFacilityRecuperateDinnerRadio;

  private ACLabelContainer kaigoWelfareFacilityRecuperateDinnerRadioContainer;

  private ACListModelAdapter kaigoWelfareFacilityRecuperateDinnerRadioModel;

  private ACRadioButtonItem kaigoWelfareFacilityRecuperateDinnerRadioItem1;

  private ACRadioButtonItem kaigoWelfareFacilityRecuperateDinnerRadioItem2;

  private ACLabelContainer kaigoWelfareFacilityHijoAddition;

  private ACIntegerCheckBox hijoPreConsultationAddition;

  private ACIntegerCheckBox hijoConsultationAddition;

  private ACIntegerCheckBox hijoCooperationAddition;

  private ACClearableRadioButtonGroup kaigoWelfareFacilityStaffSubtraction;

  private ACLabelContainer kaigoWelfareFacilityStaffSubtractionContainer;

  private ACListModelAdapter kaigoWelfareFacilityStaffSubtractionModel;

  private ACRadioButtonItem kaigoWelfareFacilityStaffSubtractionCapacityNot;

  private ACRadioButtonItem kaigoWelfareFacilityStaffSubtractionCapacityExcess;

  private ACRadioButtonItem kaigoWelfareFacilityStaffSubtractionPersonLack;

  private ACBackLabelContainer kaigoWelfareFacilityDinnerContainer;

  private ACComboBox kaigoWelfareFacilityDinnerOffer;

  private ACLabelContainer kaigoWelfareFacilityDinnerOfferContainer;

  private ACComboBoxModelAdapter kaigoWelfareFacilityDinnerOfferModel;

  private ACTextField kaigoWelfareFacilityDinnerCost;

  private ACLabelContainer kaigoWelfareFacilityDinnerCostContainer;

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
  public ACClearableRadioButtonGroup getKaigoWelfareFacilityInstitutionDivisionRadio(){
    if(kaigoWelfareFacilityInstitutionDivisionRadio==null){

      kaigoWelfareFacilityInstitutionDivisionRadio = new ACClearableRadioButtonGroup();

      getKaigoWelfareFacilityInstitutionDivisionRadioContainer().setText("�{�݋敪");

      kaigoWelfareFacilityInstitutionDivisionRadio.setBindPath("1510101");

      kaigoWelfareFacilityInstitutionDivisionRadio.setModel(getKaigoWelfareFacilityInstitutionDivisionRadioModel());

      kaigoWelfareFacilityInstitutionDivisionRadio.setUseClearButton(false);

      addKaigoWelfareFacilityInstitutionDivisionRadio();
    }
    return kaigoWelfareFacilityInstitutionDivisionRadio;

  }

  /**
   * �{�݋敪�R���e�i���擾���܂��B
   * @return �{�݋敪�R���e�i
   */
  protected ACLabelContainer getKaigoWelfareFacilityInstitutionDivisionRadioContainer(){
    if(kaigoWelfareFacilityInstitutionDivisionRadioContainer==null){
      kaigoWelfareFacilityInstitutionDivisionRadioContainer = new ACLabelContainer();
      kaigoWelfareFacilityInstitutionDivisionRadioContainer.add(getKaigoWelfareFacilityInstitutionDivisionRadio(), null);
    }
    return kaigoWelfareFacilityInstitutionDivisionRadioContainer;
  }

  /**
   * �{�݋敪���f�����擾���܂��B
   * @return �{�݋敪���f��
   */
  protected ACListModelAdapter getKaigoWelfareFacilityInstitutionDivisionRadioModel(){
    if(kaigoWelfareFacilityInstitutionDivisionRadioModel==null){
      kaigoWelfareFacilityInstitutionDivisionRadioModel = new ACListModelAdapter();
      addKaigoWelfareFacilityInstitutionDivisionRadioModel();
    }
    return kaigoWelfareFacilityInstitutionDivisionRadioModel;
  }

  /**
   * ��앟���{�݂��擾���܂��B
   * @return ��앟���{��
   */
  public ACRadioButtonItem getKaigoWelfareFacilityInstitutionDivisionRadioItem1(){
    if(kaigoWelfareFacilityInstitutionDivisionRadioItem1==null){

      kaigoWelfareFacilityInstitutionDivisionRadioItem1 = new ACRadioButtonItem();

      kaigoWelfareFacilityInstitutionDivisionRadioItem1.setText("��앟���{��");

      kaigoWelfareFacilityInstitutionDivisionRadioItem1.setGroup(getKaigoWelfareFacilityInstitutionDivisionRadio());

      kaigoWelfareFacilityInstitutionDivisionRadioItem1.setConstraints(VRLayout.FLOW);

      addKaigoWelfareFacilityInstitutionDivisionRadioItem1();
    }
    return kaigoWelfareFacilityInstitutionDivisionRadioItem1;

  }

  /**
   * ���K�͉�앟���{�݂��擾���܂��B
   * @return ���K�͉�앟���{��
   */
  public ACRadioButtonItem getKaigoWelfareFacilityInstitutionDivisionRadioItem2(){
    if(kaigoWelfareFacilityInstitutionDivisionRadioItem2==null){

      kaigoWelfareFacilityInstitutionDivisionRadioItem2 = new ACRadioButtonItem();

      kaigoWelfareFacilityInstitutionDivisionRadioItem2.setText("���K�͉�앟���{��");

      kaigoWelfareFacilityInstitutionDivisionRadioItem2.setGroup(getKaigoWelfareFacilityInstitutionDivisionRadio());

      kaigoWelfareFacilityInstitutionDivisionRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

      addKaigoWelfareFacilityInstitutionDivisionRadioItem2();
    }
    return kaigoWelfareFacilityInstitutionDivisionRadioItem2;

  }

  /**
   * ���j�b�g�^��앟���{�݂��擾���܂��B
   * @return ���j�b�g�^��앟���{��
   */
  public ACRadioButtonItem getKaigoWelfareFacilityInstitutionDivisionRadioItem3(){
    if(kaigoWelfareFacilityInstitutionDivisionRadioItem3==null){

      kaigoWelfareFacilityInstitutionDivisionRadioItem3 = new ACRadioButtonItem();

      kaigoWelfareFacilityInstitutionDivisionRadioItem3.setText("���j�b�g�^��앟���{��");

      kaigoWelfareFacilityInstitutionDivisionRadioItem3.setGroup(getKaigoWelfareFacilityInstitutionDivisionRadio());

      kaigoWelfareFacilityInstitutionDivisionRadioItem3.setConstraints(VRLayout.FLOW_RETURN);

      addKaigoWelfareFacilityInstitutionDivisionRadioItem3();
    }
    return kaigoWelfareFacilityInstitutionDivisionRadioItem3;

  }

  /**
   * ���j�b�g�^���K�͉�앟���{�݂��擾���܂��B
   * @return ���j�b�g�^���K�͉�앟���{��
   */
  public ACRadioButtonItem getKaigoWelfareFacilityInstitutionDivisionRadioItem4(){
    if(kaigoWelfareFacilityInstitutionDivisionRadioItem4==null){

      kaigoWelfareFacilityInstitutionDivisionRadioItem4 = new ACRadioButtonItem();

      kaigoWelfareFacilityInstitutionDivisionRadioItem4.setText("���j�b�g�^���K�͉�앟���{��");

      kaigoWelfareFacilityInstitutionDivisionRadioItem4.setGroup(getKaigoWelfareFacilityInstitutionDivisionRadio());

      kaigoWelfareFacilityInstitutionDivisionRadioItem4.setConstraints(VRLayout.FLOW);

      addKaigoWelfareFacilityInstitutionDivisionRadioItem4();
    }
    return kaigoWelfareFacilityInstitutionDivisionRadioItem4;

  }

  /**
   * �a���敪�R���e�i���擾���܂��B
   * @return �a���敪�R���e�i
   */
  public ACLabelContainer getKaigoWelfareFacilityHospitalRoomDivisionContena(){
    if(kaigoWelfareFacilityHospitalRoomDivisionContena==null){

      kaigoWelfareFacilityHospitalRoomDivisionContena = new ACLabelContainer();

      kaigoWelfareFacilityHospitalRoomDivisionContena.setText("�a���敪");

      kaigoWelfareFacilityHospitalRoomDivisionContena.setFollowChildEnabled(false);

      addKaigoWelfareFacilityHospitalRoomDivisionContena();
    }
    return kaigoWelfareFacilityHospitalRoomDivisionContena;

  }

  /**
   * �a���敪�i��앟���{�݁j���擾���܂��B
   * @return �a���敪�i��앟���{�݁j
   */
  public ACClearableRadioButtonGroup getKaigoWelfareFacilityHospitalRoomDivisionRadio(){
    if(kaigoWelfareFacilityHospitalRoomDivisionRadio==null){

      kaigoWelfareFacilityHospitalRoomDivisionRadio = new ACClearableRadioButtonGroup();

      kaigoWelfareFacilityHospitalRoomDivisionRadio.setBindPath("1510102");

      kaigoWelfareFacilityHospitalRoomDivisionRadio.setModel(getKaigoWelfareFacilityHospitalRoomDivisionRadioModel());

      kaigoWelfareFacilityHospitalRoomDivisionRadio.setUseClearButton(false);

      addKaigoWelfareFacilityHospitalRoomDivisionRadio();
    }
    return kaigoWelfareFacilityHospitalRoomDivisionRadio;

  }

  /**
   * �a���敪�i��앟���{�݁j���f�����擾���܂��B
   * @return �a���敪�i��앟���{�݁j���f��
   */
  protected ACListModelAdapter getKaigoWelfareFacilityHospitalRoomDivisionRadioModel(){
    if(kaigoWelfareFacilityHospitalRoomDivisionRadioModel==null){
      kaigoWelfareFacilityHospitalRoomDivisionRadioModel = new ACListModelAdapter();
      addKaigoWelfareFacilityHospitalRoomDivisionRadioModel();
    }
    return kaigoWelfareFacilityHospitalRoomDivisionRadioModel;
  }

  /**
   * �]���^�����擾���܂��B
   * @return �]���^��
   */
  public ACRadioButtonItem getKaigoWelfareFacilityHospitalRoomDivisionRadioItem1(){
    if(kaigoWelfareFacilityHospitalRoomDivisionRadioItem1==null){

      kaigoWelfareFacilityHospitalRoomDivisionRadioItem1 = new ACRadioButtonItem();

      kaigoWelfareFacilityHospitalRoomDivisionRadioItem1.setText("�]���^��");

      kaigoWelfareFacilityHospitalRoomDivisionRadioItem1.setGroup(getKaigoWelfareFacilityHospitalRoomDivisionRadio());

      kaigoWelfareFacilityHospitalRoomDivisionRadioItem1.setConstraints(VRLayout.FLOW);

      addKaigoWelfareFacilityHospitalRoomDivisionRadioItem1();
    }
    return kaigoWelfareFacilityHospitalRoomDivisionRadioItem1;

  }

  /**
   * ���������擾���܂��B
   * @return ������
   */
  public ACRadioButtonItem getKaigoWelfareFacilityHospitalRoomDivisionRadioItem2(){
    if(kaigoWelfareFacilityHospitalRoomDivisionRadioItem2==null){

      kaigoWelfareFacilityHospitalRoomDivisionRadioItem2 = new ACRadioButtonItem();

      kaigoWelfareFacilityHospitalRoomDivisionRadioItem2.setText("������");

      kaigoWelfareFacilityHospitalRoomDivisionRadioItem2.setGroup(getKaigoWelfareFacilityHospitalRoomDivisionRadio());

      kaigoWelfareFacilityHospitalRoomDivisionRadioItem2.setConstraints(VRLayout.FLOW);

      addKaigoWelfareFacilityHospitalRoomDivisionRadioItem2();
    }
    return kaigoWelfareFacilityHospitalRoomDivisionRadioItem2;

  }

  /**
   * �a���敪�i���j�b�g�^��앟���{�݁j���擾���܂��B
   * @return �a���敪�i���j�b�g�^��앟���{�݁j
   */
  public ACClearableRadioButtonGroup getKaigoWelfareFacilityUnitHospitalRoomDivisionRadio(){
    if(kaigoWelfareFacilityUnitHospitalRoomDivisionRadio==null){

      kaigoWelfareFacilityUnitHospitalRoomDivisionRadio = new ACClearableRadioButtonGroup();

      kaigoWelfareFacilityUnitHospitalRoomDivisionRadio.setBindPath("1510103");

      kaigoWelfareFacilityUnitHospitalRoomDivisionRadio.setModel(getKaigoWelfareFacilityUnitHospitalRoomDivisionRadioModel());

      kaigoWelfareFacilityUnitHospitalRoomDivisionRadio.setUseClearButton(false);

      addKaigoWelfareFacilityUnitHospitalRoomDivisionRadio();
    }
    return kaigoWelfareFacilityUnitHospitalRoomDivisionRadio;

  }

  /**
   * �a���敪�i���j�b�g�^��앟���{�݁j���f�����擾���܂��B
   * @return �a���敪�i���j�b�g�^��앟���{�݁j���f��
   */
  protected ACListModelAdapter getKaigoWelfareFacilityUnitHospitalRoomDivisionRadioModel(){
    if(kaigoWelfareFacilityUnitHospitalRoomDivisionRadioModel==null){
      kaigoWelfareFacilityUnitHospitalRoomDivisionRadioModel = new ACListModelAdapter();
      addKaigoWelfareFacilityUnitHospitalRoomDivisionRadioModel();
    }
    return kaigoWelfareFacilityUnitHospitalRoomDivisionRadioModel;
  }

  /**
   * ���j�b�g�^�����擾���܂��B
   * @return ���j�b�g�^��
   */
  public ACRadioButtonItem getKaigoWelfareFacilityUnitHospitalRoomDivisionRadioItem1(){
    if(kaigoWelfareFacilityUnitHospitalRoomDivisionRadioItem1==null){

      kaigoWelfareFacilityUnitHospitalRoomDivisionRadioItem1 = new ACRadioButtonItem();

      kaigoWelfareFacilityUnitHospitalRoomDivisionRadioItem1.setText("���j�b�g�^��");

      kaigoWelfareFacilityUnitHospitalRoomDivisionRadioItem1.setGroup(getKaigoWelfareFacilityUnitHospitalRoomDivisionRadio());

      kaigoWelfareFacilityUnitHospitalRoomDivisionRadioItem1.setConstraints(VRLayout.FLOW);

      addKaigoWelfareFacilityUnitHospitalRoomDivisionRadioItem1();
    }
    return kaigoWelfareFacilityUnitHospitalRoomDivisionRadioItem1;

  }

  /**
   * ���j�b�g�^�������擾���܂��B
   * @return ���j�b�g�^����
   */
  public ACRadioButtonItem getKaigoWelfareFacilityUnitHospitalRoomDivisionRadioItem2(){
    if(kaigoWelfareFacilityUnitHospitalRoomDivisionRadioItem2==null){

      kaigoWelfareFacilityUnitHospitalRoomDivisionRadioItem2 = new ACRadioButtonItem();

      kaigoWelfareFacilityUnitHospitalRoomDivisionRadioItem2.setText("���j�b�g�^����");

      kaigoWelfareFacilityUnitHospitalRoomDivisionRadioItem2.setGroup(getKaigoWelfareFacilityUnitHospitalRoomDivisionRadio());

      kaigoWelfareFacilityUnitHospitalRoomDivisionRadioItem2.setConstraints(VRLayout.FLOW);

      addKaigoWelfareFacilityUnitHospitalRoomDivisionRadioItem2();
    }
    return kaigoWelfareFacilityUnitHospitalRoomDivisionRadioItem2;

  }

  /**
   * ��Α̐����Z���擾���܂��B
   * @return ��Α̐����Z
   */
  public ACClearableRadioButtonGroup getKaigoWelfareFacilityNightShiftSubtractionRadio(){
    if(kaigoWelfareFacilityNightShiftSubtractionRadio==null){

      kaigoWelfareFacilityNightShiftSubtractionRadio = new ACClearableRadioButtonGroup();

      getKaigoWelfareFacilityNightShiftSubtractionRadioContainer().setText("��ԋΖ������");

      kaigoWelfareFacilityNightShiftSubtractionRadio.setBindPath("1510106");

      kaigoWelfareFacilityNightShiftSubtractionRadio.setModel(getKaigoWelfareFacilityNightShiftSubtractionRadioModel());

      kaigoWelfareFacilityNightShiftSubtractionRadio.setUseClearButton(false);

      addKaigoWelfareFacilityNightShiftSubtractionRadio();
    }
    return kaigoWelfareFacilityNightShiftSubtractionRadio;

  }

  /**
   * ��Α̐����Z�R���e�i���擾���܂��B
   * @return ��Α̐����Z�R���e�i
   */
  protected ACLabelContainer getKaigoWelfareFacilityNightShiftSubtractionRadioContainer(){
    if(kaigoWelfareFacilityNightShiftSubtractionRadioContainer==null){
      kaigoWelfareFacilityNightShiftSubtractionRadioContainer = new ACLabelContainer();
      kaigoWelfareFacilityNightShiftSubtractionRadioContainer.add(getKaigoWelfareFacilityNightShiftSubtractionRadio(), null);
    }
    return kaigoWelfareFacilityNightShiftSubtractionRadioContainer;
  }

  /**
   * ��Α̐����Z���f�����擾���܂��B
   * @return ��Α̐����Z���f��
   */
  protected ACListModelAdapter getKaigoWelfareFacilityNightShiftSubtractionRadioModel(){
    if(kaigoWelfareFacilityNightShiftSubtractionRadioModel==null){
      kaigoWelfareFacilityNightShiftSubtractionRadioModel = new ACListModelAdapter();
      addKaigoWelfareFacilityNightShiftSubtractionRadioModel();
    }
    return kaigoWelfareFacilityNightShiftSubtractionRadioModel;
  }

  /**
   * ��^���擾���܂��B
   * @return ��^
   */
  public ACRadioButtonItem getKaigoWelfareFacilityNightShiftSubtractionRadioItem1(){
    if(kaigoWelfareFacilityNightShiftSubtractionRadioItem1==null){

      kaigoWelfareFacilityNightShiftSubtractionRadioItem1 = new ACRadioButtonItem();

      kaigoWelfareFacilityNightShiftSubtractionRadioItem1.setText("��^");

      kaigoWelfareFacilityNightShiftSubtractionRadioItem1.setGroup(getKaigoWelfareFacilityNightShiftSubtractionRadio());

      kaigoWelfareFacilityNightShiftSubtractionRadioItem1.setConstraints(VRLayout.FLOW);

      addKaigoWelfareFacilityNightShiftSubtractionRadioItem1();
    }
    return kaigoWelfareFacilityNightShiftSubtractionRadioItem1;

  }

  /**
   * ���Z�^���擾���܂��B
   * @return ���Z�^
   */
  public ACRadioButtonItem getKaigoWelfareFacilityNightShiftSubtractionRadioItem2(){
    if(kaigoWelfareFacilityNightShiftSubtractionRadioItem2==null){

      kaigoWelfareFacilityNightShiftSubtractionRadioItem2 = new ACRadioButtonItem();

      kaigoWelfareFacilityNightShiftSubtractionRadioItem2.setText("���Z�^");

      kaigoWelfareFacilityNightShiftSubtractionRadioItem2.setGroup(getKaigoWelfareFacilityNightShiftSubtractionRadio());

      kaigoWelfareFacilityNightShiftSubtractionRadioItem2.setConstraints(VRLayout.FLOW);

      addKaigoWelfareFacilityNightShiftSubtractionRadioItem2();
    }
    return kaigoWelfareFacilityNightShiftSubtractionRadioItem2;

  }

  /**
   * �@�\�P���w���̐����擾���܂��B
   * @return �@�\�P���w���̐�
   */
  public ACClearableRadioButtonGroup getKaigoWelfareFacilityFunctionTrainingRadio(){
    if(kaigoWelfareFacilityFunctionTrainingRadio==null){

      kaigoWelfareFacilityFunctionTrainingRadio = new ACClearableRadioButtonGroup();

      getKaigoWelfareFacilityFunctionTrainingRadioContainer().setText("�@�\�P�����Z");

      kaigoWelfareFacilityFunctionTrainingRadio.setBindPath("1510107");

      kaigoWelfareFacilityFunctionTrainingRadio.setModel(getKaigoWelfareFacilityFunctionTrainingRadioModel());

      kaigoWelfareFacilityFunctionTrainingRadio.setUseClearButton(false);

      addKaigoWelfareFacilityFunctionTrainingRadio();
    }
    return kaigoWelfareFacilityFunctionTrainingRadio;

  }

  /**
   * �@�\�P���w���̐��R���e�i���擾���܂��B
   * @return �@�\�P���w���̐��R���e�i
   */
  protected ACLabelContainer getKaigoWelfareFacilityFunctionTrainingRadioContainer(){
    if(kaigoWelfareFacilityFunctionTrainingRadioContainer==null){
      kaigoWelfareFacilityFunctionTrainingRadioContainer = new ACLabelContainer();
      kaigoWelfareFacilityFunctionTrainingRadioContainer.add(getKaigoWelfareFacilityFunctionTrainingRadio(), null);
    }
    return kaigoWelfareFacilityFunctionTrainingRadioContainer;
  }

  /**
   * �@�\�P���w���̐����f�����擾���܂��B
   * @return �@�\�P���w���̐����f��
   */
  protected ACListModelAdapter getKaigoWelfareFacilityFunctionTrainingRadioModel(){
    if(kaigoWelfareFacilityFunctionTrainingRadioModel==null){
      kaigoWelfareFacilityFunctionTrainingRadioModel = new ACListModelAdapter();
      addKaigoWelfareFacilityFunctionTrainingRadioModel();
    }
    return kaigoWelfareFacilityFunctionTrainingRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getKaigoWelfareFacilityFunctionTrainingRadioItem2(){
    if(kaigoWelfareFacilityFunctionTrainingRadioItem2==null){

      kaigoWelfareFacilityFunctionTrainingRadioItem2 = new ACRadioButtonItem();

      kaigoWelfareFacilityFunctionTrainingRadioItem2.setText("�Ȃ�");

      kaigoWelfareFacilityFunctionTrainingRadioItem2.setGroup(getKaigoWelfareFacilityFunctionTrainingRadio());

      kaigoWelfareFacilityFunctionTrainingRadioItem2.setConstraints(VRLayout.FLOW);

      addKaigoWelfareFacilityFunctionTrainingRadioItem2();
    }
    return kaigoWelfareFacilityFunctionTrainingRadioItem2;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getKaigoWelfareFacilityFunctionTrainingRadioItem1(){
    if(kaigoWelfareFacilityFunctionTrainingRadioItem1==null){

      kaigoWelfareFacilityFunctionTrainingRadioItem1 = new ACRadioButtonItem();

      kaigoWelfareFacilityFunctionTrainingRadioItem1.setText("����");

      kaigoWelfareFacilityFunctionTrainingRadioItem1.setGroup(getKaigoWelfareFacilityFunctionTrainingRadio());

      kaigoWelfareFacilityFunctionTrainingRadioItem1.setConstraints(VRLayout.FLOW);

      addKaigoWelfareFacilityFunctionTrainingRadioItem1();
    }
    return kaigoWelfareFacilityFunctionTrainingRadioItem1;

  }

  /**
   * ��t��Ή��Z���擾���܂��B
   * @return ��t��Ή��Z
   */
  public ACClearableRadioButtonGroup getKaigoWelfareFacilityFacilityFulltimeDoctorRadio(){
    if(kaigoWelfareFacilityFacilityFulltimeDoctorRadio==null){

      kaigoWelfareFacilityFacilityFulltimeDoctorRadio = new ACClearableRadioButtonGroup();

      getKaigoWelfareFacilityFacilityFulltimeDoctorRadioContainer().setText("��t��Ή��Z");

      kaigoWelfareFacilityFacilityFulltimeDoctorRadio.setBindPath("1510108");

      kaigoWelfareFacilityFacilityFulltimeDoctorRadio.setModel(getKaigoWelfareFacilityFacilityFulltimeDoctorRadioModel());

      kaigoWelfareFacilityFacilityFulltimeDoctorRadio.setUseClearButton(false);

      addKaigoWelfareFacilityFacilityFulltimeDoctorRadio();
    }
    return kaigoWelfareFacilityFacilityFulltimeDoctorRadio;

  }

  /**
   * ��t��Ή��Z�R���e�i���擾���܂��B
   * @return ��t��Ή��Z�R���e�i
   */
  protected ACLabelContainer getKaigoWelfareFacilityFacilityFulltimeDoctorRadioContainer(){
    if(kaigoWelfareFacilityFacilityFulltimeDoctorRadioContainer==null){
      kaigoWelfareFacilityFacilityFulltimeDoctorRadioContainer = new ACLabelContainer();
      kaigoWelfareFacilityFacilityFulltimeDoctorRadioContainer.add(getKaigoWelfareFacilityFacilityFulltimeDoctorRadio(), null);
    }
    return kaigoWelfareFacilityFacilityFulltimeDoctorRadioContainer;
  }

  /**
   * ��t��Ή��Z���f�����擾���܂��B
   * @return ��t��Ή��Z���f��
   */
  protected ACListModelAdapter getKaigoWelfareFacilityFacilityFulltimeDoctorRadioModel(){
    if(kaigoWelfareFacilityFacilityFulltimeDoctorRadioModel==null){
      kaigoWelfareFacilityFacilityFulltimeDoctorRadioModel = new ACListModelAdapter();
      addKaigoWelfareFacilityFacilityFulltimeDoctorRadioModel();
    }
    return kaigoWelfareFacilityFacilityFulltimeDoctorRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getKaigoWelfareFacilityFacilityFulltimeDoctorRadioItem1(){
    if(kaigoWelfareFacilityFacilityFulltimeDoctorRadioItem1==null){

      kaigoWelfareFacilityFacilityFulltimeDoctorRadioItem1 = new ACRadioButtonItem();

      kaigoWelfareFacilityFacilityFulltimeDoctorRadioItem1.setText("�Ȃ�");

      kaigoWelfareFacilityFacilityFulltimeDoctorRadioItem1.setGroup(getKaigoWelfareFacilityFacilityFulltimeDoctorRadio());

      kaigoWelfareFacilityFacilityFulltimeDoctorRadioItem1.setConstraints(VRLayout.FLOW);

      addKaigoWelfareFacilityFacilityFulltimeDoctorRadioItem1();
    }
    return kaigoWelfareFacilityFacilityFulltimeDoctorRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getKaigoWelfareFacilityFacilityFulltimeDoctorRadioItem2(){
    if(kaigoWelfareFacilityFacilityFulltimeDoctorRadioItem2==null){

      kaigoWelfareFacilityFacilityFulltimeDoctorRadioItem2 = new ACRadioButtonItem();

      kaigoWelfareFacilityFacilityFulltimeDoctorRadioItem2.setText("����");

      kaigoWelfareFacilityFacilityFulltimeDoctorRadioItem2.setGroup(getKaigoWelfareFacilityFacilityFulltimeDoctorRadio());

      kaigoWelfareFacilityFacilityFulltimeDoctorRadioItem2.setConstraints(VRLayout.FLOW);

      addKaigoWelfareFacilityFacilityFulltimeDoctorRadioItem2();
    }
    return kaigoWelfareFacilityFacilityFulltimeDoctorRadioItem2;

  }

  /**
   * ���_�Ȉ�w�����Z���擾���܂��B
   * @return ���_�Ȉ�w�����Z
   */
  public ACClearableRadioButtonGroup getKaigoWelfareFacilityPsychiatristRadio(){
    if(kaigoWelfareFacilityPsychiatristRadio==null){

      kaigoWelfareFacilityPsychiatristRadio = new ACClearableRadioButtonGroup();

      getKaigoWelfareFacilityPsychiatristRadioContainer().setText("���_�Ȉ�w�����Z");

      kaigoWelfareFacilityPsychiatristRadio.setBindPath("1510109");

      kaigoWelfareFacilityPsychiatristRadio.setModel(getKaigoWelfareFacilityPsychiatristRadioModel());

      kaigoWelfareFacilityPsychiatristRadio.setUseClearButton(false);

      addKaigoWelfareFacilityPsychiatristRadio();
    }
    return kaigoWelfareFacilityPsychiatristRadio;

  }

  /**
   * ���_�Ȉ�w�����Z�R���e�i���擾���܂��B
   * @return ���_�Ȉ�w�����Z�R���e�i
   */
  protected ACLabelContainer getKaigoWelfareFacilityPsychiatristRadioContainer(){
    if(kaigoWelfareFacilityPsychiatristRadioContainer==null){
      kaigoWelfareFacilityPsychiatristRadioContainer = new ACLabelContainer();
      kaigoWelfareFacilityPsychiatristRadioContainer.add(getKaigoWelfareFacilityPsychiatristRadio(), null);
    }
    return kaigoWelfareFacilityPsychiatristRadioContainer;
  }

  /**
   * ���_�Ȉ�w�����Z���f�����擾���܂��B
   * @return ���_�Ȉ�w�����Z���f��
   */
  protected ACListModelAdapter getKaigoWelfareFacilityPsychiatristRadioModel(){
    if(kaigoWelfareFacilityPsychiatristRadioModel==null){
      kaigoWelfareFacilityPsychiatristRadioModel = new ACListModelAdapter();
      addKaigoWelfareFacilityPsychiatristRadioModel();
    }
    return kaigoWelfareFacilityPsychiatristRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getKaigoWelfareFacilityPsychiatristRadioItem1(){
    if(kaigoWelfareFacilityPsychiatristRadioItem1==null){

      kaigoWelfareFacilityPsychiatristRadioItem1 = new ACRadioButtonItem();

      kaigoWelfareFacilityPsychiatristRadioItem1.setText("�Ȃ�");

      kaigoWelfareFacilityPsychiatristRadioItem1.setGroup(getKaigoWelfareFacilityPsychiatristRadio());

      kaigoWelfareFacilityPsychiatristRadioItem1.setConstraints(VRLayout.FLOW);

      addKaigoWelfareFacilityPsychiatristRadioItem1();
    }
    return kaigoWelfareFacilityPsychiatristRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getKaigoWelfareFacilityPsychiatristRadioItem2(){
    if(kaigoWelfareFacilityPsychiatristRadioItem2==null){

      kaigoWelfareFacilityPsychiatristRadioItem2 = new ACRadioButtonItem();

      kaigoWelfareFacilityPsychiatristRadioItem2.setText("����");

      kaigoWelfareFacilityPsychiatristRadioItem2.setGroup(getKaigoWelfareFacilityPsychiatristRadio());

      kaigoWelfareFacilityPsychiatristRadioItem2.setConstraints(VRLayout.FLOW);

      addKaigoWelfareFacilityPsychiatristRadioItem2();
    }
    return kaigoWelfareFacilityPsychiatristRadioItem2;

  }

  /**
   * ��Q�Ґ�����������Ή��Z���擾���܂��B
   * @return ��Q�Ґ�����������Ή��Z
   */
  public ACClearableRadioButtonGroup getKaigoWelfareFacilityHandicappedRadio(){
    if(kaigoWelfareFacilityHandicappedRadio==null){

      kaigoWelfareFacilityHandicappedRadio = new ACClearableRadioButtonGroup();

      getKaigoWelfareFacilityHandicappedRadioContainer().setText("��Q�Ґ�����������Ή��Z");

      kaigoWelfareFacilityHandicappedRadio.setBindPath("1510110");

      kaigoWelfareFacilityHandicappedRadio.setModel(getKaigoWelfareFacilityHandicappedRadioModel());

      kaigoWelfareFacilityHandicappedRadio.setUseClearButton(false);

      addKaigoWelfareFacilityHandicappedRadio();
    }
    return kaigoWelfareFacilityHandicappedRadio;

  }

  /**
   * ��Q�Ґ�����������Ή��Z�R���e�i���擾���܂��B
   * @return ��Q�Ґ�����������Ή��Z�R���e�i
   */
  protected ACLabelContainer getKaigoWelfareFacilityHandicappedRadioContainer(){
    if(kaigoWelfareFacilityHandicappedRadioContainer==null){
      kaigoWelfareFacilityHandicappedRadioContainer = new ACLabelContainer();
      kaigoWelfareFacilityHandicappedRadioContainer.add(getKaigoWelfareFacilityHandicappedRadio(), null);
    }
    return kaigoWelfareFacilityHandicappedRadioContainer;
  }

  /**
   * ��Q�Ґ�����������Ή��Z���f�����擾���܂��B
   * @return ��Q�Ґ�����������Ή��Z���f��
   */
  protected ACListModelAdapter getKaigoWelfareFacilityHandicappedRadioModel(){
    if(kaigoWelfareFacilityHandicappedRadioModel==null){
      kaigoWelfareFacilityHandicappedRadioModel = new ACListModelAdapter();
      addKaigoWelfareFacilityHandicappedRadioModel();
    }
    return kaigoWelfareFacilityHandicappedRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getKaigoWelfareFacilityHandicappedRadioItem1(){
    if(kaigoWelfareFacilityHandicappedRadioItem1==null){

      kaigoWelfareFacilityHandicappedRadioItem1 = new ACRadioButtonItem();

      kaigoWelfareFacilityHandicappedRadioItem1.setText("�Ȃ�");

      kaigoWelfareFacilityHandicappedRadioItem1.setGroup(getKaigoWelfareFacilityHandicappedRadio());

      kaigoWelfareFacilityHandicappedRadioItem1.setConstraints(VRLayout.FLOW);

      addKaigoWelfareFacilityHandicappedRadioItem1();
    }
    return kaigoWelfareFacilityHandicappedRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getKaigoWelfareFacilityHandicappedRadioItem2(){
    if(kaigoWelfareFacilityHandicappedRadioItem2==null){

      kaigoWelfareFacilityHandicappedRadioItem2 = new ACRadioButtonItem();

      kaigoWelfareFacilityHandicappedRadioItem2.setText("����");

      kaigoWelfareFacilityHandicappedRadioItem2.setGroup(getKaigoWelfareFacilityHandicappedRadio());

      kaigoWelfareFacilityHandicappedRadioItem2.setConstraints(VRLayout.FLOW);

      addKaigoWelfareFacilityHandicappedRadioItem2();
    }
    return kaigoWelfareFacilityHandicappedRadioItem2;

  }

  /**
   * �O�����Z���擾���܂��B
   * @return �O�����Z
   */
  public ACClearableRadioButtonGroup getKaigoWelfareFacilityStayingOutOvernightCostRadio(){
    if(kaigoWelfareFacilityStayingOutOvernightCostRadio==null){

      kaigoWelfareFacilityStayingOutOvernightCostRadio = new ACClearableRadioButtonGroup();

      getKaigoWelfareFacilityStayingOutOvernightCostRadioContainer().setText("�O�����Z");

      kaigoWelfareFacilityStayingOutOvernightCostRadio.setBindPath("1510111");

      kaigoWelfareFacilityStayingOutOvernightCostRadio.setModel(getKaigoWelfareFacilityStayingOutOvernightCostRadioModel());

      kaigoWelfareFacilityStayingOutOvernightCostRadio.setUseClearButton(false);

      addKaigoWelfareFacilityStayingOutOvernightCostRadio();
    }
    return kaigoWelfareFacilityStayingOutOvernightCostRadio;

  }

  /**
   * �O�����Z�R���e�i���擾���܂��B
   * @return �O�����Z�R���e�i
   */
  protected ACLabelContainer getKaigoWelfareFacilityStayingOutOvernightCostRadioContainer(){
    if(kaigoWelfareFacilityStayingOutOvernightCostRadioContainer==null){
      kaigoWelfareFacilityStayingOutOvernightCostRadioContainer = new ACLabelContainer();
      kaigoWelfareFacilityStayingOutOvernightCostRadioContainer.add(getKaigoWelfareFacilityStayingOutOvernightCostRadio(), null);
    }
    return kaigoWelfareFacilityStayingOutOvernightCostRadioContainer;
  }

  /**
   * �O�����Z���f�����擾���܂��B
   * @return �O�����Z���f��
   */
  protected ACListModelAdapter getKaigoWelfareFacilityStayingOutOvernightCostRadioModel(){
    if(kaigoWelfareFacilityStayingOutOvernightCostRadioModel==null){
      kaigoWelfareFacilityStayingOutOvernightCostRadioModel = new ACListModelAdapter();
      addKaigoWelfareFacilityStayingOutOvernightCostRadioModel();
    }
    return kaigoWelfareFacilityStayingOutOvernightCostRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getKaigoWelfareFacilityStayingOutOvernightCostRadioItem1(){
    if(kaigoWelfareFacilityStayingOutOvernightCostRadioItem1==null){

      kaigoWelfareFacilityStayingOutOvernightCostRadioItem1 = new ACRadioButtonItem();

      kaigoWelfareFacilityStayingOutOvernightCostRadioItem1.setText("�Ȃ�");

      kaigoWelfareFacilityStayingOutOvernightCostRadioItem1.setGroup(getKaigoWelfareFacilityStayingOutOvernightCostRadio());

      kaigoWelfareFacilityStayingOutOvernightCostRadioItem1.setConstraints(VRLayout.FLOW);

      addKaigoWelfareFacilityStayingOutOvernightCostRadioItem1();
    }
    return kaigoWelfareFacilityStayingOutOvernightCostRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getKaigoWelfareFacilityStayingOutOvernightCostRadioItem2(){
    if(kaigoWelfareFacilityStayingOutOvernightCostRadioItem2==null){

      kaigoWelfareFacilityStayingOutOvernightCostRadioItem2 = new ACRadioButtonItem();

      kaigoWelfareFacilityStayingOutOvernightCostRadioItem2.setText("����");

      kaigoWelfareFacilityStayingOutOvernightCostRadioItem2.setGroup(getKaigoWelfareFacilityStayingOutOvernightCostRadio());

      kaigoWelfareFacilityStayingOutOvernightCostRadioItem2.setConstraints(VRLayout.FLOW);

      addKaigoWelfareFacilityStayingOutOvernightCostRadioItem2();
    }
    return kaigoWelfareFacilityStayingOutOvernightCostRadioItem2;

  }

  /**
   * �������Z���擾���܂��B
   * @return �������Z
   */
  public ACClearableRadioButtonGroup getKaigoWelfareFacilityDefaultRadio(){
    if(kaigoWelfareFacilityDefaultRadio==null){

      kaigoWelfareFacilityDefaultRadio = new ACClearableRadioButtonGroup();

      getKaigoWelfareFacilityDefaultRadioContainer().setText("�������Z");

      kaigoWelfareFacilityDefaultRadio.setBindPath("1510112");

      kaigoWelfareFacilityDefaultRadio.setModel(getKaigoWelfareFacilityDefaultRadioModel());

      kaigoWelfareFacilityDefaultRadio.setUseClearButton(false);

      addKaigoWelfareFacilityDefaultRadio();
    }
    return kaigoWelfareFacilityDefaultRadio;

  }

  /**
   * �������Z�R���e�i���擾���܂��B
   * @return �������Z�R���e�i
   */
  protected ACLabelContainer getKaigoWelfareFacilityDefaultRadioContainer(){
    if(kaigoWelfareFacilityDefaultRadioContainer==null){
      kaigoWelfareFacilityDefaultRadioContainer = new ACLabelContainer();
      kaigoWelfareFacilityDefaultRadioContainer.add(getKaigoWelfareFacilityDefaultRadio(), null);
    }
    return kaigoWelfareFacilityDefaultRadioContainer;
  }

  /**
   * �������Z���f�����擾���܂��B
   * @return �������Z���f��
   */
  protected ACListModelAdapter getKaigoWelfareFacilityDefaultRadioModel(){
    if(kaigoWelfareFacilityDefaultRadioModel==null){
      kaigoWelfareFacilityDefaultRadioModel = new ACListModelAdapter();
      addKaigoWelfareFacilityDefaultRadioModel();
    }
    return kaigoWelfareFacilityDefaultRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getKaigoWelfareFacilityDefaultRadioItem1(){
    if(kaigoWelfareFacilityDefaultRadioItem1==null){

      kaigoWelfareFacilityDefaultRadioItem1 = new ACRadioButtonItem();

      kaigoWelfareFacilityDefaultRadioItem1.setText("�Ȃ�");

      kaigoWelfareFacilityDefaultRadioItem1.setGroup(getKaigoWelfareFacilityDefaultRadio());

      kaigoWelfareFacilityDefaultRadioItem1.setConstraints(VRLayout.FLOW);

      addKaigoWelfareFacilityDefaultRadioItem1();
    }
    return kaigoWelfareFacilityDefaultRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getKaigoWelfareFacilityDefaultRadioItem2(){
    if(kaigoWelfareFacilityDefaultRadioItem2==null){

      kaigoWelfareFacilityDefaultRadioItem2 = new ACRadioButtonItem();

      kaigoWelfareFacilityDefaultRadioItem2.setText("����");

      kaigoWelfareFacilityDefaultRadioItem2.setGroup(getKaigoWelfareFacilityDefaultRadio());

      kaigoWelfareFacilityDefaultRadioItem2.setConstraints(VRLayout.FLOW);

      addKaigoWelfareFacilityDefaultRadioItem2();
    }
    return kaigoWelfareFacilityDefaultRadioItem2;

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
   * �h�{�Ǘ��̐����Z���擾���܂��B
   * @return �h�{�Ǘ��̐����Z
   */
  public ACClearableRadioButtonGroup getKaigoWelfareFacilityDieticianManageRadio(){
    if(kaigoWelfareFacilityDieticianManageRadio==null){

      kaigoWelfareFacilityDieticianManageRadio = new ACClearableRadioButtonGroup();

      getKaigoWelfareFacilityDieticianManageRadioContainer().setText("�h�{�Ǘ��̐����Z");

      kaigoWelfareFacilityDieticianManageRadio.setBindPath("1510113");

      kaigoWelfareFacilityDieticianManageRadio.setModel(getKaigoWelfareFacilityDieticianManageRadioModel());

      kaigoWelfareFacilityDieticianManageRadio.setUseClearButton(false);

      addKaigoWelfareFacilityDieticianManageRadio();
    }
    return kaigoWelfareFacilityDieticianManageRadio;

  }

  /**
   * �h�{�Ǘ��̐����Z�R���e�i���擾���܂��B
   * @return �h�{�Ǘ��̐����Z�R���e�i
   */
  protected ACLabelContainer getKaigoWelfareFacilityDieticianManageRadioContainer(){
    if(kaigoWelfareFacilityDieticianManageRadioContainer==null){
      kaigoWelfareFacilityDieticianManageRadioContainer = new ACLabelContainer();
      kaigoWelfareFacilityDieticianManageRadioContainer.add(getKaigoWelfareFacilityDieticianManageRadio(), null);
    }
    return kaigoWelfareFacilityDieticianManageRadioContainer;
  }

  /**
   * �h�{�Ǘ��̐����Z���f�����擾���܂��B
   * @return �h�{�Ǘ��̐����Z���f��
   */
  protected ACListModelAdapter getKaigoWelfareFacilityDieticianManageRadioModel(){
    if(kaigoWelfareFacilityDieticianManageRadioModel==null){
      kaigoWelfareFacilityDieticianManageRadioModel = new ACListModelAdapter();
      addKaigoWelfareFacilityDieticianManageRadioModel();
    }
    return kaigoWelfareFacilityDieticianManageRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getKaigoWelfareFacilityDieticianManageRadioItem1(){
    if(kaigoWelfareFacilityDieticianManageRadioItem1==null){

      kaigoWelfareFacilityDieticianManageRadioItem1 = new ACRadioButtonItem();

      kaigoWelfareFacilityDieticianManageRadioItem1.setText("�Ȃ�");

      kaigoWelfareFacilityDieticianManageRadioItem1.setGroup(getKaigoWelfareFacilityDieticianManageRadio());

      kaigoWelfareFacilityDieticianManageRadioItem1.setConstraints(VRLayout.FLOW);

      addKaigoWelfareFacilityDieticianManageRadioItem1();
    }
    return kaigoWelfareFacilityDieticianManageRadioItem1;

  }

  /**
   * �Ǘ��h�{�m�z�u���Z���擾���܂��B
   * @return �Ǘ��h�{�m�z�u���Z
   */
  public ACRadioButtonItem getKaigoWelfareFacilityDieticianManageRadioItem2(){
    if(kaigoWelfareFacilityDieticianManageRadioItem2==null){

      kaigoWelfareFacilityDieticianManageRadioItem2 = new ACRadioButtonItem();

      kaigoWelfareFacilityDieticianManageRadioItem2.setText("�Ǘ��h�{�m�z�u���Z");

      kaigoWelfareFacilityDieticianManageRadioItem2.setGroup(getKaigoWelfareFacilityDieticianManageRadio());

      kaigoWelfareFacilityDieticianManageRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

      addKaigoWelfareFacilityDieticianManageRadioItem2();
    }
    return kaigoWelfareFacilityDieticianManageRadioItem2;

  }

  /**
   * �h�{�m�z�u���Z���擾���܂��B
   * @return �h�{�m�z�u���Z
   */
  public ACRadioButtonItem getKaigoWelfareFacilityDieticianManageRadioItem3(){
    if(kaigoWelfareFacilityDieticianManageRadioItem3==null){

      kaigoWelfareFacilityDieticianManageRadioItem3 = new ACRadioButtonItem();

      kaigoWelfareFacilityDieticianManageRadioItem3.setText("�h�{�m�z�u���Z");

      kaigoWelfareFacilityDieticianManageRadioItem3.setGroup(getKaigoWelfareFacilityDieticianManageRadio());

      kaigoWelfareFacilityDieticianManageRadioItem3.setConstraints(VRLayout.FLOW);

      addKaigoWelfareFacilityDieticianManageRadioItem3();
    }
    return kaigoWelfareFacilityDieticianManageRadioItem3;

  }

  /**
   * �h�{�}�l�W�����g���Z���擾���܂��B
   * @return �h�{�}�l�W�����g���Z
   */
  public ACClearableRadioButtonGroup getKaigoWelfareFacilityNutritionRadio(){
    if(kaigoWelfareFacilityNutritionRadio==null){

      kaigoWelfareFacilityNutritionRadio = new ACClearableRadioButtonGroup();

      getKaigoWelfareFacilityNutritionRadioContainer().setText("�h�{�}�l�W�����g���Z");

      kaigoWelfareFacilityNutritionRadio.setBindPath("1510114");

      kaigoWelfareFacilityNutritionRadio.setModel(getKaigoWelfareFacilityNutritionRadioModel());

      kaigoWelfareFacilityNutritionRadio.setUseClearButton(false);

      addKaigoWelfareFacilityNutritionRadio();
    }
    return kaigoWelfareFacilityNutritionRadio;

  }

  /**
   * �h�{�}�l�W�����g���Z�R���e�i���擾���܂��B
   * @return �h�{�}�l�W�����g���Z�R���e�i
   */
  protected ACLabelContainer getKaigoWelfareFacilityNutritionRadioContainer(){
    if(kaigoWelfareFacilityNutritionRadioContainer==null){
      kaigoWelfareFacilityNutritionRadioContainer = new ACLabelContainer();
      kaigoWelfareFacilityNutritionRadioContainer.add(getKaigoWelfareFacilityNutritionRadio(), null);
    }
    return kaigoWelfareFacilityNutritionRadioContainer;
  }

  /**
   * �h�{�}�l�W�����g���Z���f�����擾���܂��B
   * @return �h�{�}�l�W�����g���Z���f��
   */
  protected ACListModelAdapter getKaigoWelfareFacilityNutritionRadioModel(){
    if(kaigoWelfareFacilityNutritionRadioModel==null){
      kaigoWelfareFacilityNutritionRadioModel = new ACListModelAdapter();
      addKaigoWelfareFacilityNutritionRadioModel();
    }
    return kaigoWelfareFacilityNutritionRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getKaigoWelfareFacilityNutritionRadioItem1(){
    if(kaigoWelfareFacilityNutritionRadioItem1==null){

      kaigoWelfareFacilityNutritionRadioItem1 = new ACRadioButtonItem();

      kaigoWelfareFacilityNutritionRadioItem1.setText("�Ȃ�");

      kaigoWelfareFacilityNutritionRadioItem1.setGroup(getKaigoWelfareFacilityNutritionRadio());

      kaigoWelfareFacilityNutritionRadioItem1.setConstraints(VRLayout.FLOW);

      addKaigoWelfareFacilityNutritionRadioItem1();
    }
    return kaigoWelfareFacilityNutritionRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getKaigoWelfareFacilityNutritionRadioItem2(){
    if(kaigoWelfareFacilityNutritionRadioItem2==null){

      kaigoWelfareFacilityNutritionRadioItem2 = new ACRadioButtonItem();

      kaigoWelfareFacilityNutritionRadioItem2.setText("����");

      kaigoWelfareFacilityNutritionRadioItem2.setGroup(getKaigoWelfareFacilityNutritionRadio());

      kaigoWelfareFacilityNutritionRadioItem2.setConstraints(VRLayout.FLOW);

      addKaigoWelfareFacilityNutritionRadioItem2();
    }
    return kaigoWelfareFacilityNutritionRadioItem2;

  }

  /**
   * �o���ڍs���Z���擾���܂��B
   * @return �o���ڍs���Z
   */
  public ACClearableRadioButtonGroup getKaigoWelfareFacilityOralSwitchRadio(){
    if(kaigoWelfareFacilityOralSwitchRadio==null){

      kaigoWelfareFacilityOralSwitchRadio = new ACClearableRadioButtonGroup();

      getKaigoWelfareFacilityOralSwitchRadioContainer().setText("�o���ڍs���Z");

      kaigoWelfareFacilityOralSwitchRadio.setBindPath("1510115");

      kaigoWelfareFacilityOralSwitchRadio.setModel(getKaigoWelfareFacilityOralSwitchRadioModel());

      kaigoWelfareFacilityOralSwitchRadio.setUseClearButton(false);

      addKaigoWelfareFacilityOralSwitchRadio();
    }
    return kaigoWelfareFacilityOralSwitchRadio;

  }

  /**
   * �o���ڍs���Z�R���e�i���擾���܂��B
   * @return �o���ڍs���Z�R���e�i
   */
  protected ACLabelContainer getKaigoWelfareFacilityOralSwitchRadioContainer(){
    if(kaigoWelfareFacilityOralSwitchRadioContainer==null){
      kaigoWelfareFacilityOralSwitchRadioContainer = new ACLabelContainer();
      kaigoWelfareFacilityOralSwitchRadioContainer.add(getKaigoWelfareFacilityOralSwitchRadio(), null);
    }
    return kaigoWelfareFacilityOralSwitchRadioContainer;
  }

  /**
   * �o���ڍs���Z���f�����擾���܂��B
   * @return �o���ڍs���Z���f��
   */
  protected ACListModelAdapter getKaigoWelfareFacilityOralSwitchRadioModel(){
    if(kaigoWelfareFacilityOralSwitchRadioModel==null){
      kaigoWelfareFacilityOralSwitchRadioModel = new ACListModelAdapter();
      addKaigoWelfareFacilityOralSwitchRadioModel();
    }
    return kaigoWelfareFacilityOralSwitchRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getKaigoWelfareFacilityOralSwitchRadioItem1(){
    if(kaigoWelfareFacilityOralSwitchRadioItem1==null){

      kaigoWelfareFacilityOralSwitchRadioItem1 = new ACRadioButtonItem();

      kaigoWelfareFacilityOralSwitchRadioItem1.setText("�Ȃ�");

      kaigoWelfareFacilityOralSwitchRadioItem1.setGroup(getKaigoWelfareFacilityOralSwitchRadio());

      kaigoWelfareFacilityOralSwitchRadioItem1.setConstraints(VRLayout.FLOW);

      addKaigoWelfareFacilityOralSwitchRadioItem1();
    }
    return kaigoWelfareFacilityOralSwitchRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getKaigoWelfareFacilityOralSwitchRadioItem2(){
    if(kaigoWelfareFacilityOralSwitchRadioItem2==null){

      kaigoWelfareFacilityOralSwitchRadioItem2 = new ACRadioButtonItem();

      kaigoWelfareFacilityOralSwitchRadioItem2.setText("����");

      kaigoWelfareFacilityOralSwitchRadioItem2.setGroup(getKaigoWelfareFacilityOralSwitchRadio());

      kaigoWelfareFacilityOralSwitchRadioItem2.setConstraints(VRLayout.FLOW);

      addKaigoWelfareFacilityOralSwitchRadioItem2();
    }
    return kaigoWelfareFacilityOralSwitchRadioItem2;

  }

  /**
   * �×{�H���Z���擾���܂��B
   * @return �×{�H���Z
   */
  public ACClearableRadioButtonGroup getKaigoWelfareFacilityRecuperateDinnerRadio(){
    if(kaigoWelfareFacilityRecuperateDinnerRadio==null){

      kaigoWelfareFacilityRecuperateDinnerRadio = new ACClearableRadioButtonGroup();

      getKaigoWelfareFacilityRecuperateDinnerRadioContainer().setText("�×{�H���Z");

      kaigoWelfareFacilityRecuperateDinnerRadio.setBindPath("1510116");

      kaigoWelfareFacilityRecuperateDinnerRadio.setModel(getKaigoWelfareFacilityRecuperateDinnerRadioModel());

      kaigoWelfareFacilityRecuperateDinnerRadio.setUseClearButton(false);

      addKaigoWelfareFacilityRecuperateDinnerRadio();
    }
    return kaigoWelfareFacilityRecuperateDinnerRadio;

  }

  /**
   * �×{�H���Z�R���e�i���擾���܂��B
   * @return �×{�H���Z�R���e�i
   */
  protected ACLabelContainer getKaigoWelfareFacilityRecuperateDinnerRadioContainer(){
    if(kaigoWelfareFacilityRecuperateDinnerRadioContainer==null){
      kaigoWelfareFacilityRecuperateDinnerRadioContainer = new ACLabelContainer();
      kaigoWelfareFacilityRecuperateDinnerRadioContainer.add(getKaigoWelfareFacilityRecuperateDinnerRadio(), null);
    }
    return kaigoWelfareFacilityRecuperateDinnerRadioContainer;
  }

  /**
   * �×{�H���Z���f�����擾���܂��B
   * @return �×{�H���Z���f��
   */
  protected ACListModelAdapter getKaigoWelfareFacilityRecuperateDinnerRadioModel(){
    if(kaigoWelfareFacilityRecuperateDinnerRadioModel==null){
      kaigoWelfareFacilityRecuperateDinnerRadioModel = new ACListModelAdapter();
      addKaigoWelfareFacilityRecuperateDinnerRadioModel();
    }
    return kaigoWelfareFacilityRecuperateDinnerRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getKaigoWelfareFacilityRecuperateDinnerRadioItem1(){
    if(kaigoWelfareFacilityRecuperateDinnerRadioItem1==null){

      kaigoWelfareFacilityRecuperateDinnerRadioItem1 = new ACRadioButtonItem();

      kaigoWelfareFacilityRecuperateDinnerRadioItem1.setText("�Ȃ�");

      kaigoWelfareFacilityRecuperateDinnerRadioItem1.setGroup(getKaigoWelfareFacilityRecuperateDinnerRadio());

      kaigoWelfareFacilityRecuperateDinnerRadioItem1.setConstraints(VRLayout.FLOW);

      addKaigoWelfareFacilityRecuperateDinnerRadioItem1();
    }
    return kaigoWelfareFacilityRecuperateDinnerRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getKaigoWelfareFacilityRecuperateDinnerRadioItem2(){
    if(kaigoWelfareFacilityRecuperateDinnerRadioItem2==null){

      kaigoWelfareFacilityRecuperateDinnerRadioItem2 = new ACRadioButtonItem();

      kaigoWelfareFacilityRecuperateDinnerRadioItem2.setText("����");

      kaigoWelfareFacilityRecuperateDinnerRadioItem2.setGroup(getKaigoWelfareFacilityRecuperateDinnerRadio());

      kaigoWelfareFacilityRecuperateDinnerRadioItem2.setConstraints(VRLayout.FLOW);

      addKaigoWelfareFacilityRecuperateDinnerRadioItem2();
    }
    return kaigoWelfareFacilityRecuperateDinnerRadioItem2;

  }

  /**
   * �ޏ��֘A���Z���擾���܂��B
   * @return �ޏ��֘A���Z
   */
  public ACLabelContainer getKaigoWelfareFacilityHijoAddition(){
    if(kaigoWelfareFacilityHijoAddition==null){

      kaigoWelfareFacilityHijoAddition = new ACLabelContainer();

      kaigoWelfareFacilityHijoAddition.setText("�ޏ��֘A���Z");

      addKaigoWelfareFacilityHijoAddition();
    }
    return kaigoWelfareFacilityHijoAddition;

  }

  /**
   * �ޏ��O��K�⑊�k�������Z���擾���܂��B
   * @return �ޏ��O��K�⑊�k�������Z
   */
  public ACIntegerCheckBox getHijoPreConsultationAddition(){
    if(hijoPreConsultationAddition==null){

      hijoPreConsultationAddition = new ACIntegerCheckBox();

      hijoPreConsultationAddition.setText("�ޏ��O��K�⑊�k�������Z");

      hijoPreConsultationAddition.setBindPath("3020101");

      addHijoPreConsultationAddition();
    }
    return hijoPreConsultationAddition;

  }

  /**
   * �ޏ������k�������Z���擾���܂��B
   * @return �ޏ������k�������Z
   */
  public ACIntegerCheckBox getHijoConsultationAddition(){
    if(hijoConsultationAddition==null){

      hijoConsultationAddition = new ACIntegerCheckBox();

      hijoConsultationAddition.setText("�ޏ������k�������Z");

      hijoConsultationAddition.setBindPath("3020102");

      addHijoConsultationAddition();
    }
    return hijoConsultationAddition;

  }

  /**
   * �ޏ��O�A�g���Z���擾���܂��B
   * @return �ޏ��O�A�g���Z
   */
  public ACIntegerCheckBox getHijoCooperationAddition(){
    if(hijoCooperationAddition==null){

      hijoCooperationAddition = new ACIntegerCheckBox();

      hijoCooperationAddition.setText("�ޏ��O�A�g���Z");

      hijoCooperationAddition.setBindPath("3020103");

      addHijoCooperationAddition();
    }
    return hijoCooperationAddition;

  }

  /**
   * �l�����Z���擾���܂��B
   * @return �l�����Z
   */
  public ACClearableRadioButtonGroup getKaigoWelfareFacilityStaffSubtraction(){
    if(kaigoWelfareFacilityStaffSubtraction==null){

      kaigoWelfareFacilityStaffSubtraction = new ACClearableRadioButtonGroup();

      getKaigoWelfareFacilityStaffSubtractionContainer().setText("�l�����Z");

      kaigoWelfareFacilityStaffSubtraction.setBindPath("1510120");

      kaigoWelfareFacilityStaffSubtraction.setModel(getKaigoWelfareFacilityStaffSubtractionModel());

      kaigoWelfareFacilityStaffSubtraction.setUseClearButton(false);

      addKaigoWelfareFacilityStaffSubtraction();
    }
    return kaigoWelfareFacilityStaffSubtraction;

  }

  /**
   * �l�����Z�R���e�i���擾���܂��B
   * @return �l�����Z�R���e�i
   */
  protected ACLabelContainer getKaigoWelfareFacilityStaffSubtractionContainer(){
    if(kaigoWelfareFacilityStaffSubtractionContainer==null){
      kaigoWelfareFacilityStaffSubtractionContainer = new ACLabelContainer();
      kaigoWelfareFacilityStaffSubtractionContainer.add(getKaigoWelfareFacilityStaffSubtraction(), null);
    }
    return kaigoWelfareFacilityStaffSubtractionContainer;
  }

  /**
   * �l�����Z���f�����擾���܂��B
   * @return �l�����Z���f��
   */
  protected ACListModelAdapter getKaigoWelfareFacilityStaffSubtractionModel(){
    if(kaigoWelfareFacilityStaffSubtractionModel==null){
      kaigoWelfareFacilityStaffSubtractionModel = new ACListModelAdapter();
      addKaigoWelfareFacilityStaffSubtractionModel();
    }
    return kaigoWelfareFacilityStaffSubtractionModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getKaigoWelfareFacilityStaffSubtractionCapacityNot(){
    if(kaigoWelfareFacilityStaffSubtractionCapacityNot==null){

      kaigoWelfareFacilityStaffSubtractionCapacityNot = new ACRadioButtonItem();

      kaigoWelfareFacilityStaffSubtractionCapacityNot.setText("�Ȃ�");

      kaigoWelfareFacilityStaffSubtractionCapacityNot.setGroup(getKaigoWelfareFacilityStaffSubtraction());

      kaigoWelfareFacilityStaffSubtractionCapacityNot.setConstraints(VRLayout.FLOW);

      addKaigoWelfareFacilityStaffSubtractionCapacityNot();
    }
    return kaigoWelfareFacilityStaffSubtractionCapacityNot;

  }

  /**
   * ������߂��擾���܂��B
   * @return �������
   */
  public ACRadioButtonItem getKaigoWelfareFacilityStaffSubtractionCapacityExcess(){
    if(kaigoWelfareFacilityStaffSubtractionCapacityExcess==null){

      kaigoWelfareFacilityStaffSubtractionCapacityExcess = new ACRadioButtonItem();

      kaigoWelfareFacilityStaffSubtractionCapacityExcess.setText("�������");

      kaigoWelfareFacilityStaffSubtractionCapacityExcess.setGroup(getKaigoWelfareFacilityStaffSubtraction());

      kaigoWelfareFacilityStaffSubtractionCapacityExcess.setConstraints(VRLayout.FLOW_RETURN);

      addKaigoWelfareFacilityStaffSubtractionCapacityExcess();
    }
    return kaigoWelfareFacilityStaffSubtractionCapacityExcess;

  }

  /**
   * �Ō�E���E�����͉��x�������̕s�����擾���܂��B
   * @return �Ō�E���E�����͉��x�������̕s��
   */
  public ACRadioButtonItem getKaigoWelfareFacilityStaffSubtractionPersonLack(){
    if(kaigoWelfareFacilityStaffSubtractionPersonLack==null){

      kaigoWelfareFacilityStaffSubtractionPersonLack = new ACRadioButtonItem();

      kaigoWelfareFacilityStaffSubtractionPersonLack.setText("<html>�Ō�E���E������<br>���x�������̕s��</html>");

      kaigoWelfareFacilityStaffSubtractionPersonLack.setGroup(getKaigoWelfareFacilityStaffSubtraction());

      kaigoWelfareFacilityStaffSubtractionPersonLack.setConstraints(VRLayout.FLOW);

      addKaigoWelfareFacilityStaffSubtractionPersonLack();
    }
    return kaigoWelfareFacilityStaffSubtractionPersonLack;

  }

  /**
   * �H���R���e�i���擾���܂��B
   * @return �H���R���e�i
   */
  public ACBackLabelContainer getKaigoWelfareFacilityDinnerContainer(){
    if(kaigoWelfareFacilityDinnerContainer==null){

      kaigoWelfareFacilityDinnerContainer = new ACBackLabelContainer();

      addKaigoWelfareFacilityDinnerContainer();
    }
    return kaigoWelfareFacilityDinnerContainer;

  }

  /**
   * �H���񋟂��擾���܂��B
   * @return �H����
   */
  public ACComboBox getKaigoWelfareFacilityDinnerOffer(){
    if(kaigoWelfareFacilityDinnerOffer==null){

      kaigoWelfareFacilityDinnerOffer = new ACComboBox();

      getKaigoWelfareFacilityDinnerOfferContainer().setText("�H����");

      kaigoWelfareFacilityDinnerOffer.setBindPath("1510121");

      kaigoWelfareFacilityDinnerOffer.setEditable(false);

      kaigoWelfareFacilityDinnerOffer.setModelBindPath("1510121");

      kaigoWelfareFacilityDinnerOffer.setModel(getKaigoWelfareFacilityDinnerOfferModel());

      kaigoWelfareFacilityDinnerOffer.setRenderBindPath("CONTENT");

      addKaigoWelfareFacilityDinnerOffer();
    }
    return kaigoWelfareFacilityDinnerOffer;

  }

  /**
   * �H���񋟃R���e�i���擾���܂��B
   * @return �H���񋟃R���e�i
   */
  protected ACLabelContainer getKaigoWelfareFacilityDinnerOfferContainer(){
    if(kaigoWelfareFacilityDinnerOfferContainer==null){
      kaigoWelfareFacilityDinnerOfferContainer = new ACLabelContainer();
      kaigoWelfareFacilityDinnerOfferContainer.add(getKaigoWelfareFacilityDinnerOffer(), null);
    }
    return kaigoWelfareFacilityDinnerOfferContainer;
  }

  /**
   * �H���񋟃��f�����擾���܂��B
   * @return �H���񋟃��f��
   */
  protected ACComboBoxModelAdapter getKaigoWelfareFacilityDinnerOfferModel(){
    if(kaigoWelfareFacilityDinnerOfferModel==null){
      kaigoWelfareFacilityDinnerOfferModel = new ACComboBoxModelAdapter();
      addKaigoWelfareFacilityDinnerOfferModel();
    }
    return kaigoWelfareFacilityDinnerOfferModel;
  }

  /**
   * �H����p���擾���܂��B
   * @return �H����p
   */
  public ACTextField getKaigoWelfareFacilityDinnerCost(){
    if(kaigoWelfareFacilityDinnerCost==null){

      kaigoWelfareFacilityDinnerCost = new ACTextField();

      getKaigoWelfareFacilityDinnerCostContainer().setText("�H����p");

      kaigoWelfareFacilityDinnerCost.setBindPath("1510123");

      kaigoWelfareFacilityDinnerCost.setColumns(4);

      kaigoWelfareFacilityDinnerCost.setCharType(VRCharType.ONLY_DIGIT);

      kaigoWelfareFacilityDinnerCost.setHorizontalAlignment(SwingConstants.RIGHT);

      kaigoWelfareFacilityDinnerCost.setIMEMode(InputSubset.LATIN);

      kaigoWelfareFacilityDinnerCost.setMaxLength(5);

      addKaigoWelfareFacilityDinnerCost();
    }
    return kaigoWelfareFacilityDinnerCost;

  }

  /**
   * �H����p�R���e�i���擾���܂��B
   * @return �H����p�R���e�i
   */
  protected ACLabelContainer getKaigoWelfareFacilityDinnerCostContainer(){
    if(kaigoWelfareFacilityDinnerCostContainer==null){
      kaigoWelfareFacilityDinnerCostContainer = new ACLabelContainer();
      kaigoWelfareFacilityDinnerCostContainer.add(getKaigoWelfareFacilityDinnerCost(), null);
    }
    return kaigoWelfareFacilityDinnerCostContainer;
  }

  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001021Design() {

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

    tab1.add(getKaigoWelfareFacilityInstitutionDivisionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getKaigoWelfareFacilityHospitalRoomDivisionContena(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getKaigoWelfareFacilityNightShiftSubtractionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getKaigoWelfareFacilityFunctionTrainingRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getKaigoWelfareFacilityFacilityFulltimeDoctorRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getKaigoWelfareFacilityPsychiatristRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getKaigoWelfareFacilityHandicappedRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getKaigoWelfareFacilityStayingOutOvernightCostRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getKaigoWelfareFacilityDefaultRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * �{�݋敪�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityInstitutionDivisionRadio(){

  }

  /**
   * �{�݋敪���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityInstitutionDivisionRadioModel(){

    getKaigoWelfareFacilityInstitutionDivisionRadioItem1().setButtonIndex(1);
    getKaigoWelfareFacilityInstitutionDivisionRadioModel().add(getKaigoWelfareFacilityInstitutionDivisionRadioItem1());

    getKaigoWelfareFacilityInstitutionDivisionRadioItem2().setButtonIndex(2);
    getKaigoWelfareFacilityInstitutionDivisionRadioModel().add(getKaigoWelfareFacilityInstitutionDivisionRadioItem2());

    getKaigoWelfareFacilityInstitutionDivisionRadioItem3().setButtonIndex(3);
    getKaigoWelfareFacilityInstitutionDivisionRadioModel().add(getKaigoWelfareFacilityInstitutionDivisionRadioItem3());

    getKaigoWelfareFacilityInstitutionDivisionRadioItem4().setButtonIndex(4);
    getKaigoWelfareFacilityInstitutionDivisionRadioModel().add(getKaigoWelfareFacilityInstitutionDivisionRadioItem4());

  }

  /**
   * ��앟���{�݂ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityInstitutionDivisionRadioItem1(){

  }

  /**
   * ���K�͉�앟���{�݂ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityInstitutionDivisionRadioItem2(){

  }

  /**
   * ���j�b�g�^��앟���{�݂ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityInstitutionDivisionRadioItem3(){

  }

  /**
   * ���j�b�g�^���K�͉�앟���{�݂ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityInstitutionDivisionRadioItem4(){

  }

  /**
   * �a���敪�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityHospitalRoomDivisionContena(){

    kaigoWelfareFacilityHospitalRoomDivisionContena.add(getKaigoWelfareFacilityHospitalRoomDivisionRadio(), VRLayout.FLOW_INSETLINE_RETURN);

    kaigoWelfareFacilityHospitalRoomDivisionContena.add(getKaigoWelfareFacilityUnitHospitalRoomDivisionRadio(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * �a���敪�i��앟���{�݁j�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityHospitalRoomDivisionRadio(){

  }

  /**
   * �a���敪�i��앟���{�݁j���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityHospitalRoomDivisionRadioModel(){

    getKaigoWelfareFacilityHospitalRoomDivisionRadioItem1().setButtonIndex(1);
    getKaigoWelfareFacilityHospitalRoomDivisionRadioModel().add(getKaigoWelfareFacilityHospitalRoomDivisionRadioItem1());

    getKaigoWelfareFacilityHospitalRoomDivisionRadioItem2().setButtonIndex(2);
    getKaigoWelfareFacilityHospitalRoomDivisionRadioModel().add(getKaigoWelfareFacilityHospitalRoomDivisionRadioItem2());

  }

  /**
   * �]���^���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityHospitalRoomDivisionRadioItem1(){

  }

  /**
   * �������ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityHospitalRoomDivisionRadioItem2(){

  }

  /**
   * �a���敪�i���j�b�g�^��앟���{�݁j�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityUnitHospitalRoomDivisionRadio(){

  }

  /**
   * �a���敪�i���j�b�g�^��앟���{�݁j���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityUnitHospitalRoomDivisionRadioModel(){

    getKaigoWelfareFacilityUnitHospitalRoomDivisionRadioItem1().setButtonIndex(1);
    getKaigoWelfareFacilityUnitHospitalRoomDivisionRadioModel().add(getKaigoWelfareFacilityUnitHospitalRoomDivisionRadioItem1());

    getKaigoWelfareFacilityUnitHospitalRoomDivisionRadioItem2().setButtonIndex(2);
    getKaigoWelfareFacilityUnitHospitalRoomDivisionRadioModel().add(getKaigoWelfareFacilityUnitHospitalRoomDivisionRadioItem2());

  }

  /**
   * ���j�b�g�^���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityUnitHospitalRoomDivisionRadioItem1(){

  }

  /**
   * ���j�b�g�^�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityUnitHospitalRoomDivisionRadioItem2(){

  }

  /**
   * ��Α̐����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityNightShiftSubtractionRadio(){

  }

  /**
   * ��Α̐����Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityNightShiftSubtractionRadioModel(){

    getKaigoWelfareFacilityNightShiftSubtractionRadioItem1().setButtonIndex(1);
    getKaigoWelfareFacilityNightShiftSubtractionRadioModel().add(getKaigoWelfareFacilityNightShiftSubtractionRadioItem1());

    getKaigoWelfareFacilityNightShiftSubtractionRadioItem2().setButtonIndex(2);
    getKaigoWelfareFacilityNightShiftSubtractionRadioModel().add(getKaigoWelfareFacilityNightShiftSubtractionRadioItem2());

  }

  /**
   * ��^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityNightShiftSubtractionRadioItem1(){

  }

  /**
   * ���Z�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityNightShiftSubtractionRadioItem2(){

  }

  /**
   * �@�\�P���w���̐��ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityFunctionTrainingRadio(){

  }

  /**
   * �@�\�P���w���̐����f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityFunctionTrainingRadioModel(){

    getKaigoWelfareFacilityFunctionTrainingRadioItem2().setButtonIndex(1);
    getKaigoWelfareFacilityFunctionTrainingRadioModel().add(getKaigoWelfareFacilityFunctionTrainingRadioItem2());

    getKaigoWelfareFacilityFunctionTrainingRadioItem1().setButtonIndex(2);
    getKaigoWelfareFacilityFunctionTrainingRadioModel().add(getKaigoWelfareFacilityFunctionTrainingRadioItem1());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityFunctionTrainingRadioItem2(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityFunctionTrainingRadioItem1(){

  }

  /**
   * ��t��Ή��Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityFacilityFulltimeDoctorRadio(){

  }

  /**
   * ��t��Ή��Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityFacilityFulltimeDoctorRadioModel(){

    getKaigoWelfareFacilityFacilityFulltimeDoctorRadioItem1().setButtonIndex(1);
    getKaigoWelfareFacilityFacilityFulltimeDoctorRadioModel().add(getKaigoWelfareFacilityFacilityFulltimeDoctorRadioItem1());

    getKaigoWelfareFacilityFacilityFulltimeDoctorRadioItem2().setButtonIndex(2);
    getKaigoWelfareFacilityFacilityFulltimeDoctorRadioModel().add(getKaigoWelfareFacilityFacilityFulltimeDoctorRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityFacilityFulltimeDoctorRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityFacilityFulltimeDoctorRadioItem2(){

  }

  /**
   * ���_�Ȉ�w�����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityPsychiatristRadio(){

  }

  /**
   * ���_�Ȉ�w�����Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityPsychiatristRadioModel(){

    getKaigoWelfareFacilityPsychiatristRadioItem1().setButtonIndex(1);
    getKaigoWelfareFacilityPsychiatristRadioModel().add(getKaigoWelfareFacilityPsychiatristRadioItem1());

    getKaigoWelfareFacilityPsychiatristRadioItem2().setButtonIndex(2);
    getKaigoWelfareFacilityPsychiatristRadioModel().add(getKaigoWelfareFacilityPsychiatristRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityPsychiatristRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityPsychiatristRadioItem2(){

  }

  /**
   * ��Q�Ґ�����������Ή��Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityHandicappedRadio(){

  }

  /**
   * ��Q�Ґ�����������Ή��Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityHandicappedRadioModel(){

    getKaigoWelfareFacilityHandicappedRadioItem1().setButtonIndex(1);
    getKaigoWelfareFacilityHandicappedRadioModel().add(getKaigoWelfareFacilityHandicappedRadioItem1());

    getKaigoWelfareFacilityHandicappedRadioItem2().setButtonIndex(2);
    getKaigoWelfareFacilityHandicappedRadioModel().add(getKaigoWelfareFacilityHandicappedRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityHandicappedRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityHandicappedRadioItem2(){

  }

  /**
   * �O�����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityStayingOutOvernightCostRadio(){

  }

  /**
   * �O�����Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityStayingOutOvernightCostRadioModel(){

    getKaigoWelfareFacilityStayingOutOvernightCostRadioItem1().setButtonIndex(1);
    getKaigoWelfareFacilityStayingOutOvernightCostRadioModel().add(getKaigoWelfareFacilityStayingOutOvernightCostRadioItem1());

    getKaigoWelfareFacilityStayingOutOvernightCostRadioItem2().setButtonIndex(2);
    getKaigoWelfareFacilityStayingOutOvernightCostRadioModel().add(getKaigoWelfareFacilityStayingOutOvernightCostRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityStayingOutOvernightCostRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityStayingOutOvernightCostRadioItem2(){

  }

  /**
   * �������Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityDefaultRadio(){

  }

  /**
   * �������Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityDefaultRadioModel(){

    getKaigoWelfareFacilityDefaultRadioItem1().setButtonIndex(1);
    getKaigoWelfareFacilityDefaultRadioModel().add(getKaigoWelfareFacilityDefaultRadioItem1());

    getKaigoWelfareFacilityDefaultRadioItem2().setButtonIndex(2);
    getKaigoWelfareFacilityDefaultRadioModel().add(getKaigoWelfareFacilityDefaultRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityDefaultRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityDefaultRadioItem2(){

  }

  /**
   * �^�u2�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTab2(){

    tab2.add(getKaigoWelfareFacilityDieticianManageRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getKaigoWelfareFacilityNutritionRadioContainer(), VRLayout.FLOW_INSETLINE);

    tab2.add(getKaigoWelfareFacilityOralSwitchRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getKaigoWelfareFacilityRecuperateDinnerRadioContainer(), VRLayout.FLOW_INSETLINE);

    tab2.add(getKaigoWelfareFacilityHijoAddition(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getKaigoWelfareFacilityStaffSubtractionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getKaigoWelfareFacilityDinnerContainer(), VRLayout.FLOW_DOUBLEINSETLINE_RETURN);

  }

  /**
   * �h�{�Ǘ��̐����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityDieticianManageRadio(){

  }

  /**
   * �h�{�Ǘ��̐����Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityDieticianManageRadioModel(){

    getKaigoWelfareFacilityDieticianManageRadioItem1().setButtonIndex(1);
    getKaigoWelfareFacilityDieticianManageRadioModel().add(getKaigoWelfareFacilityDieticianManageRadioItem1());

    getKaigoWelfareFacilityDieticianManageRadioItem2().setButtonIndex(2);
    getKaigoWelfareFacilityDieticianManageRadioModel().add(getKaigoWelfareFacilityDieticianManageRadioItem2());

    getKaigoWelfareFacilityDieticianManageRadioItem3().setButtonIndex(3);
    getKaigoWelfareFacilityDieticianManageRadioModel().add(getKaigoWelfareFacilityDieticianManageRadioItem3());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityDieticianManageRadioItem1(){

  }

  /**
   * �Ǘ��h�{�m�z�u���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityDieticianManageRadioItem2(){

  }

  /**
   * �h�{�m�z�u���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityDieticianManageRadioItem3(){

  }

  /**
   * �h�{�}�l�W�����g���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityNutritionRadio(){

  }

  /**
   * �h�{�}�l�W�����g���Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityNutritionRadioModel(){

    getKaigoWelfareFacilityNutritionRadioItem1().setButtonIndex(1);
    getKaigoWelfareFacilityNutritionRadioModel().add(getKaigoWelfareFacilityNutritionRadioItem1());

    getKaigoWelfareFacilityNutritionRadioItem2().setButtonIndex(2);
    getKaigoWelfareFacilityNutritionRadioModel().add(getKaigoWelfareFacilityNutritionRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityNutritionRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityNutritionRadioItem2(){

  }

  /**
   * �o���ڍs���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityOralSwitchRadio(){

  }

  /**
   * �o���ڍs���Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityOralSwitchRadioModel(){

    getKaigoWelfareFacilityOralSwitchRadioItem1().setButtonIndex(1);
    getKaigoWelfareFacilityOralSwitchRadioModel().add(getKaigoWelfareFacilityOralSwitchRadioItem1());

    getKaigoWelfareFacilityOralSwitchRadioItem2().setButtonIndex(2);
    getKaigoWelfareFacilityOralSwitchRadioModel().add(getKaigoWelfareFacilityOralSwitchRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityOralSwitchRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityOralSwitchRadioItem2(){

  }

  /**
   * �×{�H���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityRecuperateDinnerRadio(){

  }

  /**
   * �×{�H���Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityRecuperateDinnerRadioModel(){

    getKaigoWelfareFacilityRecuperateDinnerRadioItem1().setButtonIndex(1);
    getKaigoWelfareFacilityRecuperateDinnerRadioModel().add(getKaigoWelfareFacilityRecuperateDinnerRadioItem1());

    getKaigoWelfareFacilityRecuperateDinnerRadioItem2().setButtonIndex(2);
    getKaigoWelfareFacilityRecuperateDinnerRadioModel().add(getKaigoWelfareFacilityRecuperateDinnerRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityRecuperateDinnerRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityRecuperateDinnerRadioItem2(){

  }

  /**
   * �ޏ��֘A���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityHijoAddition(){

    kaigoWelfareFacilityHijoAddition.add(getHijoPreConsultationAddition(), VRLayout.FLOW_RETURN);

    kaigoWelfareFacilityHijoAddition.add(getHijoConsultationAddition(), VRLayout.FLOW_RETURN);

    kaigoWelfareFacilityHijoAddition.add(getHijoCooperationAddition(), VRLayout.FLOW_RETURN);

  }

  /**
   * �ޏ��O��K�⑊�k�������Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHijoPreConsultationAddition(){

  }

  /**
   * �ޏ������k�������Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHijoConsultationAddition(){

  }

  /**
   * �ޏ��O�A�g���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHijoCooperationAddition(){

  }

  /**
   * �l�����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityStaffSubtraction(){

  }

  /**
   * �l�����Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityStaffSubtractionModel(){

    getKaigoWelfareFacilityStaffSubtractionCapacityNot().setButtonIndex(1);
    getKaigoWelfareFacilityStaffSubtractionModel().add(getKaigoWelfareFacilityStaffSubtractionCapacityNot());

    getKaigoWelfareFacilityStaffSubtractionCapacityExcess().setButtonIndex(2);
    getKaigoWelfareFacilityStaffSubtractionModel().add(getKaigoWelfareFacilityStaffSubtractionCapacityExcess());

    getKaigoWelfareFacilityStaffSubtractionPersonLack().setButtonIndex(3);
    getKaigoWelfareFacilityStaffSubtractionModel().add(getKaigoWelfareFacilityStaffSubtractionPersonLack());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityStaffSubtractionCapacityNot(){

  }

  /**
   * ������߂ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityStaffSubtractionCapacityExcess(){

  }

  /**
   * �Ō�E���E�����͉��x�������̕s���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityStaffSubtractionPersonLack(){

  }

  /**
   * �H���R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityDinnerContainer(){

    kaigoWelfareFacilityDinnerContainer.add(getKaigoWelfareFacilityDinnerOfferContainer(), VRLayout.FLOW);

    kaigoWelfareFacilityDinnerContainer.add(getKaigoWelfareFacilityDinnerCostContainer(), VRLayout.FLOW);

  }

  /**
   * �H���񋟂ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityDinnerOffer(){

  }

  /**
   * �H���񋟃��f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityDinnerOfferModel(){

  }

  /**
   * �H����p�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityDinnerCost(){

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
      ACFrame.getInstance().getContentPane().add(new QS001021Design());
      ACFrame.getInstance().setVisible(true);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QS001021Design getThis() {
    return this;
  }
}
