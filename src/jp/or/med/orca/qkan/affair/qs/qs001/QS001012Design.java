
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
 * �쐬��: 2006/02/14  ���{�R���s���[�^�[������� ���}�@�M�u �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �T�[�r�X�\��쐬/�ύX (S)
 * �v���Z�X �T�[�r�X�\��T�� (001)
 * �v���O���� �T�[�r�X�p�^�[���Z�������×{���i���V�l�ی��{�݁j (QS001012)
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
 * �T�[�r�X�p�^�[���Z�������×{���i���V�l�ی��{�݁j��ʍ��ڃf�U�C��(QS001012) 
 */
public class QS001012Design extends QS001ServicePanel {
  //GUI�R���|�[�l���g

  private JTabbedPane tabs;

  private ACPanel tab1;

  private ACClearableRadioButtonGroup shortStayRecuperationHealthFacilityInstitutionDivisionRadio;

  private ACLabelContainer shortStayRecuperationHealthFacilityInstitutionDivisionRadioContainer;

  private ACListModelAdapter shortStayRecuperationHealthFacilityInstitutionDivisionRadioModel;

  private ACRadioButtonItem shortStayRecuperationHealthFacilityInstitutionDivisionRadioItem1;

  private ACRadioButtonItem shortStayRecuperationHealthFacilityInstitutionDivisionRadioItem2;

  private ACLabelContainer shortStayRecuperationHealthFacilityHospitalRoomDivisionContena;

  private ACClearableRadioButtonGroup shortStayRecuperationHealthFacilityHospitalRoomDivisionRadio;

  private ACListModelAdapter shortStayRecuperationHealthFacilityHospitalRoomDivisionRadioModel;

  private ACRadioButtonItem shortStayRecuperationHealthFacilityHospitalRoomDivisionRadioItem1;

  private ACRadioButtonItem shortStayRecuperationHealthFacilityHospitalRoomDivisionRadioItem2;

  private ACClearableRadioButtonGroup shortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadio;

  private ACListModelAdapter shortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadioModel;

  private ACRadioButtonItem shortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadioItem1;

  private ACRadioButtonItem shortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadioItem2;

  private ACClearableRadioButtonGroup shortStayRecuperationHealthNightWorkConditionRadio;

  private ACLabelContainer shortStayRecuperationHealthNightWorkConditionRadioContainer;

  private ACListModelAdapter shortStayRecuperationHealthNightWorkConditionRadioModel;

  private ACRadioButtonItem shortStayRecuperationHealthNightWorkConditionRadioItem1;

  private ACRadioButtonItem shortStayRecuperationHealthNightWorkConditionRadioItem2;

  private ACClearableRadioButtonGroup shortStayRecuperationHealthFacilityEtcRehabilitation;

  private ACLabelContainer shortStayRecuperationHealthFacilityEtcRehabilitationContainer;

  private ACListModelAdapter shortStayRecuperationHealthFacilityEtcRehabilitationModel;

  private ACRadioButtonItem shortStayRecuperationHealthFacilityEtcRehabilitationRadioItem2;

  private ACRadioButtonItem shortStayRecuperationHealthFacilityEtcRehabilitationRadioItem1;

  private ACClearableRadioButtonGroup shortStayRecuperationHealthFacilityEtcDementiaSpecialBuildingRadio;

  private ACLabelContainer shortStayRecuperationHealthFacilityEtcDementiaSpecialBuildingRadioContainer;

  private ACListModelAdapter shortStayRecuperationHealthFacilityEtcDementiaSpecialBuildingRadioModel;

  private ACRadioButtonItem shortStayRecuperationHealthFacilityEtcDementiaSpecialBuildingRadioItem2;

  private ACRadioButtonItem shortStayRecuperationHealthFacilityEtcDementiaSpecialBuildingRadioItem1;

  private ACClearableRadioButtonGroup shortStayRecuperationHealthFacilityMeetingAndSendingOff;

  private ACLabelContainer shortStayRecuperationHealthFacilityMeetingAndSendingOffContainer;

  private ACListModelAdapter shortStayRecuperationHealthFacilityMeetingAndSendingOffModel;

  private ACRadioButtonItem shortStayRecuperationHealthFacilityMeetingAndSendingOffNone;

  private ACRadioButtonItem shortStayRecuperationHealthFacilityMeetingAndSendingOffOneWay;

  private ACRadioButtonItem shortStayRecuperationHealthFacilityMeetingAndSendingOffRoundTrip;

  private ACClearableRadioButtonGroup shortStayRecuperationHealthFacilityUrgentTimeStepRadio;

  private ACLabelContainer shortStayRecuperationHealthFacilityUrgentTimeStepRadioContainer;

  private ACListModelAdapter shortStayRecuperationHealthFacilityUrgentTimeStepRadioModel;

  private ACRadioButtonItem shortStayRecuperationHealthFacilityUrgentTimeStepRadioItem1;

  private ACRadioButtonItem shortStayRecuperationHealthFacilityUrgentTimeStepRadioItem2;

  private ACPanel tab2;

  private ACClearableRadioButtonGroup shortStayRecuperationHealthFacilityDieticianManageRadio;

  private ACLabelContainer shortStayRecuperationHealthFacilityDieticianManageRadioContainer;

  private ACListModelAdapter shortStayRecuperationHealthFacilityDieticianManageRadioModel;

  private ACRadioButtonItem shortStayRecuperationHealthFacilityDieticianManageRadioItem1;

  private ACRadioButtonItem shortStayRecuperationHealthFacilityDieticianManageRadioItem2;

  private ACRadioButtonItem shortStayRecuperationHealthFacilityDieticianManageRadioItem3;

  private ACClearableRadioButtonGroup shortStayRecuperationHealthFacilityDieticianMedicalExpensesRadio;

  private ACLabelContainer shortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioContainer;

  private ACListModelAdapter shortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioModel;

  private ACRadioButtonItem shortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioItem1;

  private ACRadioButtonItem shortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioItem2;

  private ACClearableRadioButtonGroup shortStayRecuperationHealthFacilityPersonSubtraction;

  private ACLabelContainer shortStayRecuperationHealthFacilityPersonSubtractionContainer;

  private ACListModelAdapter shortStayRecuperationHealthFacilityPersonSubtractionModel;

  private ACRadioButtonItem shortStayRecuperationHealthFacilityPersonSubtractionNot;

  private ACRadioButtonItem shortStayRecuperationHealthFacilityPersonSubtractionExcess;

  private ACRadioButtonItem shortStayRecuperationHealthFacilityPersonSubtractionStaffLack;

  private ACBackLabelContainer shortStayRecuperationHealthFacilityDinnerContainer;

  private ACComboBox shortStayRecuperationHealthFacilityDinnerOffer;

  private ACLabelContainer shortStayRecuperationHealthFacilityDinnerOfferContainer;

  private ACComboBoxModelAdapter shortStayRecuperationHealthFacilityDinnerOfferModel;

  private ACTextField shortStayRecuperationHealthFacilityDinnerCost;

  private ACLabelContainer shortStayRecuperationHealthFacilityDinnerCostContainer;

  private ACIntegerCheckBox shortStayRecuperationHealthFacilityEtc30Over;

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
  public ACClearableRadioButtonGroup getShortStayRecuperationHealthFacilityInstitutionDivisionRadio(){
    if(shortStayRecuperationHealthFacilityInstitutionDivisionRadio==null){

      shortStayRecuperationHealthFacilityInstitutionDivisionRadio = new ACClearableRadioButtonGroup();

      getShortStayRecuperationHealthFacilityInstitutionDivisionRadioContainer().setText("�{�݋敪");

      shortStayRecuperationHealthFacilityInstitutionDivisionRadio.setBindPath("1220101");

      shortStayRecuperationHealthFacilityInstitutionDivisionRadio.setModel(getShortStayRecuperationHealthFacilityInstitutionDivisionRadioModel());

      shortStayRecuperationHealthFacilityInstitutionDivisionRadio.setUseClearButton(false);

      addShortStayRecuperationHealthFacilityInstitutionDivisionRadio();
    }
    return shortStayRecuperationHealthFacilityInstitutionDivisionRadio;

  }

  /**
   * �{�݋敪�R���e�i���擾���܂��B
   * @return �{�݋敪�R���e�i
   */
  protected ACLabelContainer getShortStayRecuperationHealthFacilityInstitutionDivisionRadioContainer(){
    if(shortStayRecuperationHealthFacilityInstitutionDivisionRadioContainer==null){
      shortStayRecuperationHealthFacilityInstitutionDivisionRadioContainer = new ACLabelContainer();
      shortStayRecuperationHealthFacilityInstitutionDivisionRadioContainer.setFollowChildEnabled(true);
      shortStayRecuperationHealthFacilityInstitutionDivisionRadioContainer.add(getShortStayRecuperationHealthFacilityInstitutionDivisionRadio(), null);
    }
    return shortStayRecuperationHealthFacilityInstitutionDivisionRadioContainer;
  }

  /**
   * �{�݋敪���f�����擾���܂��B
   * @return �{�݋敪���f��
   */
  protected ACListModelAdapter getShortStayRecuperationHealthFacilityInstitutionDivisionRadioModel(){
    if(shortStayRecuperationHealthFacilityInstitutionDivisionRadioModel==null){
      shortStayRecuperationHealthFacilityInstitutionDivisionRadioModel = new ACListModelAdapter();
      addShortStayRecuperationHealthFacilityInstitutionDivisionRadioModel();
    }
    return shortStayRecuperationHealthFacilityInstitutionDivisionRadioModel;
  }

  /**
   * ���V�l�ی��{�݂��擾���܂��B
   * @return ���V�l�ی��{��
   */
  public ACRadioButtonItem getShortStayRecuperationHealthFacilityInstitutionDivisionRadioItem1(){
    if(shortStayRecuperationHealthFacilityInstitutionDivisionRadioItem1==null){

      shortStayRecuperationHealthFacilityInstitutionDivisionRadioItem1 = new ACRadioButtonItem();

      shortStayRecuperationHealthFacilityInstitutionDivisionRadioItem1.setText("���V�l�ی��{��");

      shortStayRecuperationHealthFacilityInstitutionDivisionRadioItem1.setGroup(getShortStayRecuperationHealthFacilityInstitutionDivisionRadio());

      shortStayRecuperationHealthFacilityInstitutionDivisionRadioItem1.setConstraints(VRLayout.FLOW_RETURN);

      addShortStayRecuperationHealthFacilityInstitutionDivisionRadioItem1();
    }
    return shortStayRecuperationHealthFacilityInstitutionDivisionRadioItem1;

  }

  /**
   * ���j�b�g�^���V�l�ی��{�݂��擾���܂��B
   * @return ���j�b�g�^���V�l�ی��{��
   */
  public ACRadioButtonItem getShortStayRecuperationHealthFacilityInstitutionDivisionRadioItem2(){
    if(shortStayRecuperationHealthFacilityInstitutionDivisionRadioItem2==null){

      shortStayRecuperationHealthFacilityInstitutionDivisionRadioItem2 = new ACRadioButtonItem();

      shortStayRecuperationHealthFacilityInstitutionDivisionRadioItem2.setText("���j�b�g�^���V�l�ی��{��");

      shortStayRecuperationHealthFacilityInstitutionDivisionRadioItem2.setGroup(getShortStayRecuperationHealthFacilityInstitutionDivisionRadio());

      shortStayRecuperationHealthFacilityInstitutionDivisionRadioItem2.setConstraints(VRLayout.FLOW);

      addShortStayRecuperationHealthFacilityInstitutionDivisionRadioItem2();
    }
    return shortStayRecuperationHealthFacilityInstitutionDivisionRadioItem2;

  }

  /**
   * �a���敪�R���e�i���擾���܂��B
   * @return �a���敪�R���e�i
   */
  public ACLabelContainer getShortStayRecuperationHealthFacilityHospitalRoomDivisionContena(){
    if(shortStayRecuperationHealthFacilityHospitalRoomDivisionContena==null){

      shortStayRecuperationHealthFacilityHospitalRoomDivisionContena = new ACLabelContainer();

      shortStayRecuperationHealthFacilityHospitalRoomDivisionContena.setText("�a���敪");

      addShortStayRecuperationHealthFacilityHospitalRoomDivisionContena();
    }
    return shortStayRecuperationHealthFacilityHospitalRoomDivisionContena;

  }

  /**
   * �a���敪�i���V�l�ی��{�݁j���擾���܂��B
   * @return �a���敪�i���V�l�ی��{�݁j
   */
  public ACClearableRadioButtonGroup getShortStayRecuperationHealthFacilityHospitalRoomDivisionRadio(){
    if(shortStayRecuperationHealthFacilityHospitalRoomDivisionRadio==null){

      shortStayRecuperationHealthFacilityHospitalRoomDivisionRadio = new ACClearableRadioButtonGroup();

      shortStayRecuperationHealthFacilityHospitalRoomDivisionRadio.setBindPath("1220102");

      shortStayRecuperationHealthFacilityHospitalRoomDivisionRadio.setModel(getShortStayRecuperationHealthFacilityHospitalRoomDivisionRadioModel());

      shortStayRecuperationHealthFacilityHospitalRoomDivisionRadio.setUseClearButton(false);

      addShortStayRecuperationHealthFacilityHospitalRoomDivisionRadio();
    }
    return shortStayRecuperationHealthFacilityHospitalRoomDivisionRadio;

  }

  /**
   * �a���敪�i���V�l�ی��{�݁j���f�����擾���܂��B
   * @return �a���敪�i���V�l�ی��{�݁j���f��
   */
  protected ACListModelAdapter getShortStayRecuperationHealthFacilityHospitalRoomDivisionRadioModel(){
    if(shortStayRecuperationHealthFacilityHospitalRoomDivisionRadioModel==null){
      shortStayRecuperationHealthFacilityHospitalRoomDivisionRadioModel = new ACListModelAdapter();
      addShortStayRecuperationHealthFacilityHospitalRoomDivisionRadioModel();
    }
    return shortStayRecuperationHealthFacilityHospitalRoomDivisionRadioModel;
  }

  /**
   * �]���^�����擾���܂��B
   * @return �]���^��
   */
  public ACRadioButtonItem getShortStayRecuperationHealthFacilityHospitalRoomDivisionRadioItem1(){
    if(shortStayRecuperationHealthFacilityHospitalRoomDivisionRadioItem1==null){

      shortStayRecuperationHealthFacilityHospitalRoomDivisionRadioItem1 = new ACRadioButtonItem();

      shortStayRecuperationHealthFacilityHospitalRoomDivisionRadioItem1.setText("�]���^��");

      shortStayRecuperationHealthFacilityHospitalRoomDivisionRadioItem1.setGroup(getShortStayRecuperationHealthFacilityHospitalRoomDivisionRadio());

      shortStayRecuperationHealthFacilityHospitalRoomDivisionRadioItem1.setConstraints(VRLayout.FLOW);

      addShortStayRecuperationHealthFacilityHospitalRoomDivisionRadioItem1();
    }
    return shortStayRecuperationHealthFacilityHospitalRoomDivisionRadioItem1;

  }

  /**
   * ���������擾���܂��B
   * @return ������
   */
  public ACRadioButtonItem getShortStayRecuperationHealthFacilityHospitalRoomDivisionRadioItem2(){
    if(shortStayRecuperationHealthFacilityHospitalRoomDivisionRadioItem2==null){

      shortStayRecuperationHealthFacilityHospitalRoomDivisionRadioItem2 = new ACRadioButtonItem();

      shortStayRecuperationHealthFacilityHospitalRoomDivisionRadioItem2.setText("������");

      shortStayRecuperationHealthFacilityHospitalRoomDivisionRadioItem2.setGroup(getShortStayRecuperationHealthFacilityHospitalRoomDivisionRadio());

      shortStayRecuperationHealthFacilityHospitalRoomDivisionRadioItem2.setConstraints(VRLayout.FLOW);

      addShortStayRecuperationHealthFacilityHospitalRoomDivisionRadioItem2();
    }
    return shortStayRecuperationHealthFacilityHospitalRoomDivisionRadioItem2;

  }

  /**
   * �a���敪�i���j�b�g�^���V�l�ی��{�݁j���擾���܂��B
   * @return �a���敪�i���j�b�g�^���V�l�ی��{�݁j
   */
  public ACClearableRadioButtonGroup getShortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadio(){
    if(shortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadio==null){

      shortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadio = new ACClearableRadioButtonGroup();

      shortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadio.setBindPath("1220103");

      shortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadio.setModel(getShortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadioModel());

      shortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadio.setUseClearButton(false);

      addShortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadio();
    }
    return shortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadio;

  }

  /**
   * �a���敪�i���j�b�g�^���V�l�ی��{�݁j���f�����擾���܂��B
   * @return �a���敪�i���j�b�g�^���V�l�ی��{�݁j���f��
   */
  protected ACListModelAdapter getShortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadioModel(){
    if(shortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadioModel==null){
      shortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadioModel = new ACListModelAdapter();
      addShortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadioModel();
    }
    return shortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadioModel;
  }

  /**
   * ���j�b�g�^�����擾���܂��B
   * @return ���j�b�g�^��
   */
  public ACRadioButtonItem getShortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadioItem1(){
    if(shortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadioItem1==null){

      shortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadioItem1 = new ACRadioButtonItem();

      shortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadioItem1.setText("���j�b�g�^��");

      shortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadioItem1.setGroup(getShortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadio());

      shortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadioItem1.setConstraints(VRLayout.FLOW);

      addShortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadioItem1();
    }
    return shortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadioItem1;

  }

  /**
   * ���j�b�g�^�������擾���܂��B
   * @return ���j�b�g�^����
   */
  public ACRadioButtonItem getShortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadioItem2(){
    if(shortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadioItem2==null){

      shortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadioItem2 = new ACRadioButtonItem();

      shortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadioItem2.setText("���j�b�g�^����");

      shortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadioItem2.setGroup(getShortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadio());

      shortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadioItem2.setConstraints(VRLayout.FLOW);

      addShortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadioItem2();
    }
    return shortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadioItem2;

  }

  /**
   * ��ԋΖ���������擾���܂��B
   * @return ��ԋΖ������
   */
  public ACClearableRadioButtonGroup getShortStayRecuperationHealthNightWorkConditionRadio(){
    if(shortStayRecuperationHealthNightWorkConditionRadio==null){

      shortStayRecuperationHealthNightWorkConditionRadio = new ACClearableRadioButtonGroup();

      getShortStayRecuperationHealthNightWorkConditionRadioContainer().setText("��ԋΖ������");

      shortStayRecuperationHealthNightWorkConditionRadio.setBindPath("1220104");

      shortStayRecuperationHealthNightWorkConditionRadio.setModel(getShortStayRecuperationHealthNightWorkConditionRadioModel());

      shortStayRecuperationHealthNightWorkConditionRadio.setUseClearButton(false);

      addShortStayRecuperationHealthNightWorkConditionRadio();
    }
    return shortStayRecuperationHealthNightWorkConditionRadio;

  }

  /**
   * ��ԋΖ�������R���e�i���擾���܂��B
   * @return ��ԋΖ�������R���e�i
   */
  protected ACLabelContainer getShortStayRecuperationHealthNightWorkConditionRadioContainer(){
    if(shortStayRecuperationHealthNightWorkConditionRadioContainer==null){
      shortStayRecuperationHealthNightWorkConditionRadioContainer = new ACLabelContainer();
      shortStayRecuperationHealthNightWorkConditionRadioContainer.setFollowChildEnabled(true);
      shortStayRecuperationHealthNightWorkConditionRadioContainer.add(getShortStayRecuperationHealthNightWorkConditionRadio(), null);
    }
    return shortStayRecuperationHealthNightWorkConditionRadioContainer;
  }

  /**
   * ��ԋΖ���������f�����擾���܂��B
   * @return ��ԋΖ���������f��
   */
  protected ACListModelAdapter getShortStayRecuperationHealthNightWorkConditionRadioModel(){
    if(shortStayRecuperationHealthNightWorkConditionRadioModel==null){
      shortStayRecuperationHealthNightWorkConditionRadioModel = new ACListModelAdapter();
      addShortStayRecuperationHealthNightWorkConditionRadioModel();
    }
    return shortStayRecuperationHealthNightWorkConditionRadioModel;
  }

  /**
   * ��^���擾���܂��B
   * @return ��^
   */
  public ACRadioButtonItem getShortStayRecuperationHealthNightWorkConditionRadioItem1(){
    if(shortStayRecuperationHealthNightWorkConditionRadioItem1==null){

      shortStayRecuperationHealthNightWorkConditionRadioItem1 = new ACRadioButtonItem();

      shortStayRecuperationHealthNightWorkConditionRadioItem1.setText("��^");

      shortStayRecuperationHealthNightWorkConditionRadioItem1.setGroup(getShortStayRecuperationHealthNightWorkConditionRadio());

      shortStayRecuperationHealthNightWorkConditionRadioItem1.setConstraints(VRLayout.FLOW);

      addShortStayRecuperationHealthNightWorkConditionRadioItem1();
    }
    return shortStayRecuperationHealthNightWorkConditionRadioItem1;

  }

  /**
   * ���Z�^���擾���܂��B
   * @return ���Z�^
   */
  public ACRadioButtonItem getShortStayRecuperationHealthNightWorkConditionRadioItem2(){
    if(shortStayRecuperationHealthNightWorkConditionRadioItem2==null){

      shortStayRecuperationHealthNightWorkConditionRadioItem2 = new ACRadioButtonItem();

      shortStayRecuperationHealthNightWorkConditionRadioItem2.setText("���Z�^");

      shortStayRecuperationHealthNightWorkConditionRadioItem2.setGroup(getShortStayRecuperationHealthNightWorkConditionRadio());

      shortStayRecuperationHealthNightWorkConditionRadioItem2.setConstraints(VRLayout.FLOW);

      addShortStayRecuperationHealthNightWorkConditionRadioItem2();
    }
    return shortStayRecuperationHealthNightWorkConditionRadioItem2;

  }

  /**
   * ���n�r���@�\�������Z���擾���܂��B
   * @return ���n�r���@�\�������Z
   */
  public ACClearableRadioButtonGroup getShortStayRecuperationHealthFacilityEtcRehabilitation(){
    if(shortStayRecuperationHealthFacilityEtcRehabilitation==null){

      shortStayRecuperationHealthFacilityEtcRehabilitation = new ACClearableRadioButtonGroup();

      getShortStayRecuperationHealthFacilityEtcRehabilitationContainer().setText("���n�r���@�\�������Z");

      shortStayRecuperationHealthFacilityEtcRehabilitation.setBindPath("1220105");

      shortStayRecuperationHealthFacilityEtcRehabilitation.setModel(getShortStayRecuperationHealthFacilityEtcRehabilitationModel());

      shortStayRecuperationHealthFacilityEtcRehabilitation.setUseClearButton(false);

      addShortStayRecuperationHealthFacilityEtcRehabilitation();
    }
    return shortStayRecuperationHealthFacilityEtcRehabilitation;

  }

  /**
   * ���n�r���@�\�������Z�R���e�i���擾���܂��B
   * @return ���n�r���@�\�������Z�R���e�i
   */
  protected ACLabelContainer getShortStayRecuperationHealthFacilityEtcRehabilitationContainer(){
    if(shortStayRecuperationHealthFacilityEtcRehabilitationContainer==null){
      shortStayRecuperationHealthFacilityEtcRehabilitationContainer = new ACLabelContainer();
      shortStayRecuperationHealthFacilityEtcRehabilitationContainer.setFollowChildEnabled(true);
      shortStayRecuperationHealthFacilityEtcRehabilitationContainer.add(getShortStayRecuperationHealthFacilityEtcRehabilitation(), null);
    }
    return shortStayRecuperationHealthFacilityEtcRehabilitationContainer;
  }

  /**
   * ���n�r���@�\�������Z���f�����擾���܂��B
   * @return ���n�r���@�\�������Z���f��
   */
  protected ACListModelAdapter getShortStayRecuperationHealthFacilityEtcRehabilitationModel(){
    if(shortStayRecuperationHealthFacilityEtcRehabilitationModel==null){
      shortStayRecuperationHealthFacilityEtcRehabilitationModel = new ACListModelAdapter();
      addShortStayRecuperationHealthFacilityEtcRehabilitationModel();
    }
    return shortStayRecuperationHealthFacilityEtcRehabilitationModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getShortStayRecuperationHealthFacilityEtcRehabilitationRadioItem2(){
    if(shortStayRecuperationHealthFacilityEtcRehabilitationRadioItem2==null){

      shortStayRecuperationHealthFacilityEtcRehabilitationRadioItem2 = new ACRadioButtonItem();

      shortStayRecuperationHealthFacilityEtcRehabilitationRadioItem2.setText("�Ȃ�");

      shortStayRecuperationHealthFacilityEtcRehabilitationRadioItem2.setGroup(getShortStayRecuperationHealthFacilityEtcRehabilitation());

      shortStayRecuperationHealthFacilityEtcRehabilitationRadioItem2.setConstraints(VRLayout.FLOW);

      addShortStayRecuperationHealthFacilityEtcRehabilitationRadioItem2();
    }
    return shortStayRecuperationHealthFacilityEtcRehabilitationRadioItem2;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getShortStayRecuperationHealthFacilityEtcRehabilitationRadioItem1(){
    if(shortStayRecuperationHealthFacilityEtcRehabilitationRadioItem1==null){

      shortStayRecuperationHealthFacilityEtcRehabilitationRadioItem1 = new ACRadioButtonItem();

      shortStayRecuperationHealthFacilityEtcRehabilitationRadioItem1.setText("����");

      shortStayRecuperationHealthFacilityEtcRehabilitationRadioItem1.setGroup(getShortStayRecuperationHealthFacilityEtcRehabilitation());

      shortStayRecuperationHealthFacilityEtcRehabilitationRadioItem1.setConstraints(VRLayout.FLOW);

      addShortStayRecuperationHealthFacilityEtcRehabilitationRadioItem1();
    }
    return shortStayRecuperationHealthFacilityEtcRehabilitationRadioItem1;

  }

  /**
   * �F�m�ǐ����Z���擾���܂��B
   * @return �F�m�ǐ����Z
   */
  public ACClearableRadioButtonGroup getShortStayRecuperationHealthFacilityEtcDementiaSpecialBuildingRadio(){
    if(shortStayRecuperationHealthFacilityEtcDementiaSpecialBuildingRadio==null){

      shortStayRecuperationHealthFacilityEtcDementiaSpecialBuildingRadio = new ACClearableRadioButtonGroup();

      getShortStayRecuperationHealthFacilityEtcDementiaSpecialBuildingRadioContainer().setText("�F�m�ǐ�哏���Z");

      shortStayRecuperationHealthFacilityEtcDementiaSpecialBuildingRadio.setBindPath("1220106");

      shortStayRecuperationHealthFacilityEtcDementiaSpecialBuildingRadio.setModel(getShortStayRecuperationHealthFacilityEtcDementiaSpecialBuildingRadioModel());

      shortStayRecuperationHealthFacilityEtcDementiaSpecialBuildingRadio.setUseClearButton(false);

      addShortStayRecuperationHealthFacilityEtcDementiaSpecialBuildingRadio();
    }
    return shortStayRecuperationHealthFacilityEtcDementiaSpecialBuildingRadio;

  }

  /**
   * �F�m�ǐ����Z�R���e�i���擾���܂��B
   * @return �F�m�ǐ����Z�R���e�i
   */
  protected ACLabelContainer getShortStayRecuperationHealthFacilityEtcDementiaSpecialBuildingRadioContainer(){
    if(shortStayRecuperationHealthFacilityEtcDementiaSpecialBuildingRadioContainer==null){
      shortStayRecuperationHealthFacilityEtcDementiaSpecialBuildingRadioContainer = new ACLabelContainer();
      shortStayRecuperationHealthFacilityEtcDementiaSpecialBuildingRadioContainer.setFollowChildEnabled(true);
      shortStayRecuperationHealthFacilityEtcDementiaSpecialBuildingRadioContainer.add(getShortStayRecuperationHealthFacilityEtcDementiaSpecialBuildingRadio(), null);
    }
    return shortStayRecuperationHealthFacilityEtcDementiaSpecialBuildingRadioContainer;
  }

  /**
   * �F�m�ǐ����Z���f�����擾���܂��B
   * @return �F�m�ǐ����Z���f��
   */
  protected ACListModelAdapter getShortStayRecuperationHealthFacilityEtcDementiaSpecialBuildingRadioModel(){
    if(shortStayRecuperationHealthFacilityEtcDementiaSpecialBuildingRadioModel==null){
      shortStayRecuperationHealthFacilityEtcDementiaSpecialBuildingRadioModel = new ACListModelAdapter();
      addShortStayRecuperationHealthFacilityEtcDementiaSpecialBuildingRadioModel();
    }
    return shortStayRecuperationHealthFacilityEtcDementiaSpecialBuildingRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getShortStayRecuperationHealthFacilityEtcDementiaSpecialBuildingRadioItem2(){
    if(shortStayRecuperationHealthFacilityEtcDementiaSpecialBuildingRadioItem2==null){

      shortStayRecuperationHealthFacilityEtcDementiaSpecialBuildingRadioItem2 = new ACRadioButtonItem();

      shortStayRecuperationHealthFacilityEtcDementiaSpecialBuildingRadioItem2.setText("�Ȃ�");

      shortStayRecuperationHealthFacilityEtcDementiaSpecialBuildingRadioItem2.setGroup(getShortStayRecuperationHealthFacilityEtcDementiaSpecialBuildingRadio());

      shortStayRecuperationHealthFacilityEtcDementiaSpecialBuildingRadioItem2.setConstraints(VRLayout.FLOW);

      addShortStayRecuperationHealthFacilityEtcDementiaSpecialBuildingRadioItem2();
    }
    return shortStayRecuperationHealthFacilityEtcDementiaSpecialBuildingRadioItem2;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getShortStayRecuperationHealthFacilityEtcDementiaSpecialBuildingRadioItem1(){
    if(shortStayRecuperationHealthFacilityEtcDementiaSpecialBuildingRadioItem1==null){

      shortStayRecuperationHealthFacilityEtcDementiaSpecialBuildingRadioItem1 = new ACRadioButtonItem();

      shortStayRecuperationHealthFacilityEtcDementiaSpecialBuildingRadioItem1.setText("����");

      shortStayRecuperationHealthFacilityEtcDementiaSpecialBuildingRadioItem1.setGroup(getShortStayRecuperationHealthFacilityEtcDementiaSpecialBuildingRadio());

      shortStayRecuperationHealthFacilityEtcDementiaSpecialBuildingRadioItem1.setConstraints(VRLayout.FLOW);

      addShortStayRecuperationHealthFacilityEtcDementiaSpecialBuildingRadioItem1();
    }
    return shortStayRecuperationHealthFacilityEtcDementiaSpecialBuildingRadioItem1;

  }

  /**
   * ���}�敪���擾���܂��B
   * @return ���}�敪
   */
  public ACClearableRadioButtonGroup getShortStayRecuperationHealthFacilityMeetingAndSendingOff(){
    if(shortStayRecuperationHealthFacilityMeetingAndSendingOff==null){

      shortStayRecuperationHealthFacilityMeetingAndSendingOff = new ACClearableRadioButtonGroup();

      getShortStayRecuperationHealthFacilityMeetingAndSendingOffContainer().setText("���}���Z");

      shortStayRecuperationHealthFacilityMeetingAndSendingOff.setBindPath("6");

      shortStayRecuperationHealthFacilityMeetingAndSendingOff.setModel(getShortStayRecuperationHealthFacilityMeetingAndSendingOffModel());

      shortStayRecuperationHealthFacilityMeetingAndSendingOff.setUseClearButton(false);

      addShortStayRecuperationHealthFacilityMeetingAndSendingOff();
    }
    return shortStayRecuperationHealthFacilityMeetingAndSendingOff;

  }

  /**
   * ���}�敪�R���e�i���擾���܂��B
   * @return ���}�敪�R���e�i
   */
  protected ACLabelContainer getShortStayRecuperationHealthFacilityMeetingAndSendingOffContainer(){
    if(shortStayRecuperationHealthFacilityMeetingAndSendingOffContainer==null){
      shortStayRecuperationHealthFacilityMeetingAndSendingOffContainer = new ACLabelContainer();
      shortStayRecuperationHealthFacilityMeetingAndSendingOffContainer.setFollowChildEnabled(true);
      shortStayRecuperationHealthFacilityMeetingAndSendingOffContainer.add(getShortStayRecuperationHealthFacilityMeetingAndSendingOff(), null);
    }
    return shortStayRecuperationHealthFacilityMeetingAndSendingOffContainer;
  }

  /**
   * ���}�敪���f�����擾���܂��B
   * @return ���}�敪���f��
   */
  protected ACListModelAdapter getShortStayRecuperationHealthFacilityMeetingAndSendingOffModel(){
    if(shortStayRecuperationHealthFacilityMeetingAndSendingOffModel==null){
      shortStayRecuperationHealthFacilityMeetingAndSendingOffModel = new ACListModelAdapter();
      addShortStayRecuperationHealthFacilityMeetingAndSendingOffModel();
    }
    return shortStayRecuperationHealthFacilityMeetingAndSendingOffModel;
  }

  /**
   * ���}�Ȃ����擾���܂��B
   * @return ���}�Ȃ�
   */
  public ACRadioButtonItem getShortStayRecuperationHealthFacilityMeetingAndSendingOffNone(){
    if(shortStayRecuperationHealthFacilityMeetingAndSendingOffNone==null){

      shortStayRecuperationHealthFacilityMeetingAndSendingOffNone = new ACRadioButtonItem();

      shortStayRecuperationHealthFacilityMeetingAndSendingOffNone.setText("���}�Ȃ�");

      shortStayRecuperationHealthFacilityMeetingAndSendingOffNone.setGroup(getShortStayRecuperationHealthFacilityMeetingAndSendingOff());

      shortStayRecuperationHealthFacilityMeetingAndSendingOffNone.setConstraints(VRLayout.FLOW);

      addShortStayRecuperationHealthFacilityMeetingAndSendingOffNone();
    }
    return shortStayRecuperationHealthFacilityMeetingAndSendingOffNone;

  }

  /**
   * ���}�Г����擾���܂��B
   * @return ���}�Г�
   */
  public ACRadioButtonItem getShortStayRecuperationHealthFacilityMeetingAndSendingOffOneWay(){
    if(shortStayRecuperationHealthFacilityMeetingAndSendingOffOneWay==null){

      shortStayRecuperationHealthFacilityMeetingAndSendingOffOneWay = new ACRadioButtonItem();

      shortStayRecuperationHealthFacilityMeetingAndSendingOffOneWay.setText("���}�Г�");

      shortStayRecuperationHealthFacilityMeetingAndSendingOffOneWay.setGroup(getShortStayRecuperationHealthFacilityMeetingAndSendingOff());

      shortStayRecuperationHealthFacilityMeetingAndSendingOffOneWay.setConstraints(VRLayout.FLOW);

      addShortStayRecuperationHealthFacilityMeetingAndSendingOffOneWay();
    }
    return shortStayRecuperationHealthFacilityMeetingAndSendingOffOneWay;

  }

  /**
   * ���}�������擾���܂��B
   * @return ���}����
   */
  public ACRadioButtonItem getShortStayRecuperationHealthFacilityMeetingAndSendingOffRoundTrip(){
    if(shortStayRecuperationHealthFacilityMeetingAndSendingOffRoundTrip==null){

      shortStayRecuperationHealthFacilityMeetingAndSendingOffRoundTrip = new ACRadioButtonItem();

      shortStayRecuperationHealthFacilityMeetingAndSendingOffRoundTrip.setText("���}����");

      shortStayRecuperationHealthFacilityMeetingAndSendingOffRoundTrip.setGroup(getShortStayRecuperationHealthFacilityMeetingAndSendingOff());

      shortStayRecuperationHealthFacilityMeetingAndSendingOffRoundTrip.setConstraints(VRLayout.FLOW);

      addShortStayRecuperationHealthFacilityMeetingAndSendingOffRoundTrip();
    }
    return shortStayRecuperationHealthFacilityMeetingAndSendingOffRoundTrip;

  }

  /**
   * �ً}�����ÊǗ����Z���擾���܂��B
   * @return �ً}�����ÊǗ����Z
   */
  public ACClearableRadioButtonGroup getShortStayRecuperationHealthFacilityUrgentTimeStepRadio(){
    if(shortStayRecuperationHealthFacilityUrgentTimeStepRadio==null){

      shortStayRecuperationHealthFacilityUrgentTimeStepRadio = new ACClearableRadioButtonGroup();

      getShortStayRecuperationHealthFacilityUrgentTimeStepRadioContainer().setText("�ً}�����ÊǗ����Z");

      shortStayRecuperationHealthFacilityUrgentTimeStepRadio.setBindPath("1220108");

      shortStayRecuperationHealthFacilityUrgentTimeStepRadio.setModel(getShortStayRecuperationHealthFacilityUrgentTimeStepRadioModel());

      shortStayRecuperationHealthFacilityUrgentTimeStepRadio.setUseClearButton(false);

      addShortStayRecuperationHealthFacilityUrgentTimeStepRadio();
    }
    return shortStayRecuperationHealthFacilityUrgentTimeStepRadio;

  }

  /**
   * �ً}�����ÊǗ����Z�R���e�i���擾���܂��B
   * @return �ً}�����ÊǗ����Z�R���e�i
   */
  protected ACLabelContainer getShortStayRecuperationHealthFacilityUrgentTimeStepRadioContainer(){
    if(shortStayRecuperationHealthFacilityUrgentTimeStepRadioContainer==null){
      shortStayRecuperationHealthFacilityUrgentTimeStepRadioContainer = new ACLabelContainer();
      shortStayRecuperationHealthFacilityUrgentTimeStepRadioContainer.setFollowChildEnabled(true);
      shortStayRecuperationHealthFacilityUrgentTimeStepRadioContainer.add(getShortStayRecuperationHealthFacilityUrgentTimeStepRadio(), null);
    }
    return shortStayRecuperationHealthFacilityUrgentTimeStepRadioContainer;
  }

  /**
   * �ً}�����ÊǗ����Z���f�����擾���܂��B
   * @return �ً}�����ÊǗ����Z���f��
   */
  protected ACListModelAdapter getShortStayRecuperationHealthFacilityUrgentTimeStepRadioModel(){
    if(shortStayRecuperationHealthFacilityUrgentTimeStepRadioModel==null){
      shortStayRecuperationHealthFacilityUrgentTimeStepRadioModel = new ACListModelAdapter();
      addShortStayRecuperationHealthFacilityUrgentTimeStepRadioModel();
    }
    return shortStayRecuperationHealthFacilityUrgentTimeStepRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getShortStayRecuperationHealthFacilityUrgentTimeStepRadioItem1(){
    if(shortStayRecuperationHealthFacilityUrgentTimeStepRadioItem1==null){

      shortStayRecuperationHealthFacilityUrgentTimeStepRadioItem1 = new ACRadioButtonItem();

      shortStayRecuperationHealthFacilityUrgentTimeStepRadioItem1.setText("�Ȃ�");

      shortStayRecuperationHealthFacilityUrgentTimeStepRadioItem1.setGroup(getShortStayRecuperationHealthFacilityUrgentTimeStepRadio());

      shortStayRecuperationHealthFacilityUrgentTimeStepRadioItem1.setConstraints(VRLayout.FLOW);

      addShortStayRecuperationHealthFacilityUrgentTimeStepRadioItem1();
    }
    return shortStayRecuperationHealthFacilityUrgentTimeStepRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getShortStayRecuperationHealthFacilityUrgentTimeStepRadioItem2(){
    if(shortStayRecuperationHealthFacilityUrgentTimeStepRadioItem2==null){

      shortStayRecuperationHealthFacilityUrgentTimeStepRadioItem2 = new ACRadioButtonItem();

      shortStayRecuperationHealthFacilityUrgentTimeStepRadioItem2.setText("����");

      shortStayRecuperationHealthFacilityUrgentTimeStepRadioItem2.setGroup(getShortStayRecuperationHealthFacilityUrgentTimeStepRadio());

      shortStayRecuperationHealthFacilityUrgentTimeStepRadioItem2.setConstraints(VRLayout.FLOW);

      addShortStayRecuperationHealthFacilityUrgentTimeStepRadioItem2();
    }
    return shortStayRecuperationHealthFacilityUrgentTimeStepRadioItem2;

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
  public ACClearableRadioButtonGroup getShortStayRecuperationHealthFacilityDieticianManageRadio(){
    if(shortStayRecuperationHealthFacilityDieticianManageRadio==null){

      shortStayRecuperationHealthFacilityDieticianManageRadio = new ACClearableRadioButtonGroup();

      getShortStayRecuperationHealthFacilityDieticianManageRadioContainer().setText("�h�{�Ǘ��̐����Z");

      shortStayRecuperationHealthFacilityDieticianManageRadio.setBindPath("1220109");

      shortStayRecuperationHealthFacilityDieticianManageRadio.setModel(getShortStayRecuperationHealthFacilityDieticianManageRadioModel());

      shortStayRecuperationHealthFacilityDieticianManageRadio.setUseClearButton(false);

      addShortStayRecuperationHealthFacilityDieticianManageRadio();
    }
    return shortStayRecuperationHealthFacilityDieticianManageRadio;

  }

  /**
   * �h�{�Ǘ��̐����Z�R���e�i���擾���܂��B
   * @return �h�{�Ǘ��̐����Z�R���e�i
   */
  protected ACLabelContainer getShortStayRecuperationHealthFacilityDieticianManageRadioContainer(){
    if(shortStayRecuperationHealthFacilityDieticianManageRadioContainer==null){
      shortStayRecuperationHealthFacilityDieticianManageRadioContainer = new ACLabelContainer();
      shortStayRecuperationHealthFacilityDieticianManageRadioContainer.setFollowChildEnabled(true);
      shortStayRecuperationHealthFacilityDieticianManageRadioContainer.add(getShortStayRecuperationHealthFacilityDieticianManageRadio(), null);
    }
    return shortStayRecuperationHealthFacilityDieticianManageRadioContainer;
  }

  /**
   * �h�{�Ǘ��̐����Z���f�����擾���܂��B
   * @return �h�{�Ǘ��̐����Z���f��
   */
  protected ACListModelAdapter getShortStayRecuperationHealthFacilityDieticianManageRadioModel(){
    if(shortStayRecuperationHealthFacilityDieticianManageRadioModel==null){
      shortStayRecuperationHealthFacilityDieticianManageRadioModel = new ACListModelAdapter();
      addShortStayRecuperationHealthFacilityDieticianManageRadioModel();
    }
    return shortStayRecuperationHealthFacilityDieticianManageRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getShortStayRecuperationHealthFacilityDieticianManageRadioItem1(){
    if(shortStayRecuperationHealthFacilityDieticianManageRadioItem1==null){

      shortStayRecuperationHealthFacilityDieticianManageRadioItem1 = new ACRadioButtonItem();

      shortStayRecuperationHealthFacilityDieticianManageRadioItem1.setText("�Ȃ�");

      shortStayRecuperationHealthFacilityDieticianManageRadioItem1.setGroup(getShortStayRecuperationHealthFacilityDieticianManageRadio());

      shortStayRecuperationHealthFacilityDieticianManageRadioItem1.setConstraints(VRLayout.FLOW_RETURN);

      addShortStayRecuperationHealthFacilityDieticianManageRadioItem1();
    }
    return shortStayRecuperationHealthFacilityDieticianManageRadioItem1;

  }

  /**
   * �Ǘ��h�{�m�z�u���Z���擾���܂��B
   * @return �Ǘ��h�{�m�z�u���Z
   */
  public ACRadioButtonItem getShortStayRecuperationHealthFacilityDieticianManageRadioItem2(){
    if(shortStayRecuperationHealthFacilityDieticianManageRadioItem2==null){

      shortStayRecuperationHealthFacilityDieticianManageRadioItem2 = new ACRadioButtonItem();

      shortStayRecuperationHealthFacilityDieticianManageRadioItem2.setText("�Ǘ��h�{�m�z�u���Z");

      shortStayRecuperationHealthFacilityDieticianManageRadioItem2.setGroup(getShortStayRecuperationHealthFacilityDieticianManageRadio());

      shortStayRecuperationHealthFacilityDieticianManageRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

      addShortStayRecuperationHealthFacilityDieticianManageRadioItem2();
    }
    return shortStayRecuperationHealthFacilityDieticianManageRadioItem2;

  }

  /**
   * �h�{�m�z�u���Z���擾���܂��B
   * @return �h�{�m�z�u���Z
   */
  public ACRadioButtonItem getShortStayRecuperationHealthFacilityDieticianManageRadioItem3(){
    if(shortStayRecuperationHealthFacilityDieticianManageRadioItem3==null){

      shortStayRecuperationHealthFacilityDieticianManageRadioItem3 = new ACRadioButtonItem();

      shortStayRecuperationHealthFacilityDieticianManageRadioItem3.setText("�h�{�m�z�u���Z");

      shortStayRecuperationHealthFacilityDieticianManageRadioItem3.setGroup(getShortStayRecuperationHealthFacilityDieticianManageRadio());

      shortStayRecuperationHealthFacilityDieticianManageRadioItem3.setConstraints(VRLayout.FLOW);

      addShortStayRecuperationHealthFacilityDieticianManageRadioItem3();
    }
    return shortStayRecuperationHealthFacilityDieticianManageRadioItem3;

  }

  /**
   * �×{�H���Z���擾���܂��B
   * @return �×{�H���Z
   */
  public ACClearableRadioButtonGroup getShortStayRecuperationHealthFacilityDieticianMedicalExpensesRadio(){
    if(shortStayRecuperationHealthFacilityDieticianMedicalExpensesRadio==null){

      shortStayRecuperationHealthFacilityDieticianMedicalExpensesRadio = new ACClearableRadioButtonGroup();

      getShortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioContainer().setText("�×{�H���Z");

      shortStayRecuperationHealthFacilityDieticianMedicalExpensesRadio.setBindPath("1220110");

      shortStayRecuperationHealthFacilityDieticianMedicalExpensesRadio.setModel(getShortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioModel());

      shortStayRecuperationHealthFacilityDieticianMedicalExpensesRadio.setUseClearButton(false);

      addShortStayRecuperationHealthFacilityDieticianMedicalExpensesRadio();
    }
    return shortStayRecuperationHealthFacilityDieticianMedicalExpensesRadio;

  }

  /**
   * �×{�H���Z�R���e�i���擾���܂��B
   * @return �×{�H���Z�R���e�i
   */
  protected ACLabelContainer getShortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioContainer(){
    if(shortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioContainer==null){
      shortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioContainer = new ACLabelContainer();
      shortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioContainer.setFollowChildEnabled(true);
      shortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioContainer.add(getShortStayRecuperationHealthFacilityDieticianMedicalExpensesRadio(), null);
    }
    return shortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioContainer;
  }

  /**
   * �×{�H���Z���f�����擾���܂��B
   * @return �×{�H���Z���f��
   */
  protected ACListModelAdapter getShortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioModel(){
    if(shortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioModel==null){
      shortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioModel = new ACListModelAdapter();
      addShortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioModel();
    }
    return shortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getShortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioItem1(){
    if(shortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioItem1==null){

      shortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioItem1 = new ACRadioButtonItem();

      shortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioItem1.setText("�Ȃ�");

      shortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioItem1.setGroup(getShortStayRecuperationHealthFacilityDieticianMedicalExpensesRadio());

      shortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioItem1.setConstraints(VRLayout.FLOW);

      addShortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioItem1();
    }
    return shortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getShortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioItem2(){
    if(shortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioItem2==null){

      shortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioItem2 = new ACRadioButtonItem();

      shortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioItem2.setText("����");

      shortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioItem2.setGroup(getShortStayRecuperationHealthFacilityDieticianMedicalExpensesRadio());

      shortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioItem2.setConstraints(VRLayout.FLOW);

      addShortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioItem2();
    }
    return shortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioItem2;

  }

  /**
   * �l�����Z���擾���܂��B
   * @return �l�����Z
   */
  public ACClearableRadioButtonGroup getShortStayRecuperationHealthFacilityPersonSubtraction(){
    if(shortStayRecuperationHealthFacilityPersonSubtraction==null){

      shortStayRecuperationHealthFacilityPersonSubtraction = new ACClearableRadioButtonGroup();

      getShortStayRecuperationHealthFacilityPersonSubtractionContainer().setText("�l�����Z");

      shortStayRecuperationHealthFacilityPersonSubtraction.setBindPath("1220111");

      shortStayRecuperationHealthFacilityPersonSubtraction.setModel(getShortStayRecuperationHealthFacilityPersonSubtractionModel());

      shortStayRecuperationHealthFacilityPersonSubtraction.setUseClearButton(false);

      addShortStayRecuperationHealthFacilityPersonSubtraction();
    }
    return shortStayRecuperationHealthFacilityPersonSubtraction;

  }

  /**
   * �l�����Z�R���e�i���擾���܂��B
   * @return �l�����Z�R���e�i
   */
  protected ACLabelContainer getShortStayRecuperationHealthFacilityPersonSubtractionContainer(){
    if(shortStayRecuperationHealthFacilityPersonSubtractionContainer==null){
      shortStayRecuperationHealthFacilityPersonSubtractionContainer = new ACLabelContainer();
      shortStayRecuperationHealthFacilityPersonSubtractionContainer.setFollowChildEnabled(true);
      shortStayRecuperationHealthFacilityPersonSubtractionContainer.add(getShortStayRecuperationHealthFacilityPersonSubtraction(), null);
    }
    return shortStayRecuperationHealthFacilityPersonSubtractionContainer;
  }

  /**
   * �l�����Z���f�����擾���܂��B
   * @return �l�����Z���f��
   */
  protected ACListModelAdapter getShortStayRecuperationHealthFacilityPersonSubtractionModel(){
    if(shortStayRecuperationHealthFacilityPersonSubtractionModel==null){
      shortStayRecuperationHealthFacilityPersonSubtractionModel = new ACListModelAdapter();
      addShortStayRecuperationHealthFacilityPersonSubtractionModel();
    }
    return shortStayRecuperationHealthFacilityPersonSubtractionModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getShortStayRecuperationHealthFacilityPersonSubtractionNot(){
    if(shortStayRecuperationHealthFacilityPersonSubtractionNot==null){

      shortStayRecuperationHealthFacilityPersonSubtractionNot = new ACRadioButtonItem();

      shortStayRecuperationHealthFacilityPersonSubtractionNot.setText("�Ȃ�");

      shortStayRecuperationHealthFacilityPersonSubtractionNot.setGroup(getShortStayRecuperationHealthFacilityPersonSubtraction());

      shortStayRecuperationHealthFacilityPersonSubtractionNot.setConstraints(VRLayout.FLOW);

      addShortStayRecuperationHealthFacilityPersonSubtractionNot();
    }
    return shortStayRecuperationHealthFacilityPersonSubtractionNot;

  }

  /**
   * ������߂��擾���܂��B
   * @return �������
   */
  public ACRadioButtonItem getShortStayRecuperationHealthFacilityPersonSubtractionExcess(){
    if(shortStayRecuperationHealthFacilityPersonSubtractionExcess==null){

      shortStayRecuperationHealthFacilityPersonSubtractionExcess = new ACRadioButtonItem();

      shortStayRecuperationHealthFacilityPersonSubtractionExcess.setText("�������");

      shortStayRecuperationHealthFacilityPersonSubtractionExcess.setGroup(getShortStayRecuperationHealthFacilityPersonSubtraction());

      shortStayRecuperationHealthFacilityPersonSubtractionExcess.setConstraints(VRLayout.FLOW_RETURN);

      addShortStayRecuperationHealthFacilityPersonSubtractionExcess();
    }
    return shortStayRecuperationHealthFacilityPersonSubtractionExcess;

  }

  /**
   * �Ō�E���E�����͈�t�APT�EOT�̕s�����擾���܂��B
   * @return �Ō�E���E�����͈�t�APT�EOT�̕s��
   */
  public ACRadioButtonItem getShortStayRecuperationHealthFacilityPersonSubtractionStaffLack(){
    if(shortStayRecuperationHealthFacilityPersonSubtractionStaffLack==null){

      shortStayRecuperationHealthFacilityPersonSubtractionStaffLack = new ACRadioButtonItem();

      shortStayRecuperationHealthFacilityPersonSubtractionStaffLack.setText("<html>�Ō�E���E�����͈�t�A<br>PT�EOT�̕s��</html>");

      shortStayRecuperationHealthFacilityPersonSubtractionStaffLack.setGroup(getShortStayRecuperationHealthFacilityPersonSubtraction());

      shortStayRecuperationHealthFacilityPersonSubtractionStaffLack.setConstraints(VRLayout.FLOW);

      addShortStayRecuperationHealthFacilityPersonSubtractionStaffLack();
    }
    return shortStayRecuperationHealthFacilityPersonSubtractionStaffLack;

  }

  /**
   * �H���R���e�i���擾���܂��B
   * @return �H���R���e�i
   */
  public ACBackLabelContainer getShortStayRecuperationHealthFacilityDinnerContainer(){
    if(shortStayRecuperationHealthFacilityDinnerContainer==null){

      shortStayRecuperationHealthFacilityDinnerContainer = new ACBackLabelContainer();

      addShortStayRecuperationHealthFacilityDinnerContainer();
    }
    return shortStayRecuperationHealthFacilityDinnerContainer;

  }

  /**
   * �H���񋟂��擾���܂��B
   * @return �H����
   */
  public ACComboBox getShortStayRecuperationHealthFacilityDinnerOffer(){
    if(shortStayRecuperationHealthFacilityDinnerOffer==null){

      shortStayRecuperationHealthFacilityDinnerOffer = new ACComboBox();

      getShortStayRecuperationHealthFacilityDinnerOfferContainer().setText("�H����");

      shortStayRecuperationHealthFacilityDinnerOffer.setBindPath("1220112");

      shortStayRecuperationHealthFacilityDinnerOffer.setEditable(false);

      shortStayRecuperationHealthFacilityDinnerOffer.setModelBindPath("1220112");

      shortStayRecuperationHealthFacilityDinnerOffer.setModel(getShortStayRecuperationHealthFacilityDinnerOfferModel());

      shortStayRecuperationHealthFacilityDinnerOffer.setRenderBindPath("CONTENT");

      addShortStayRecuperationHealthFacilityDinnerOffer();
    }
    return shortStayRecuperationHealthFacilityDinnerOffer;

  }

  /**
   * �H���񋟃R���e�i���擾���܂��B
   * @return �H���񋟃R���e�i
   */
  protected ACLabelContainer getShortStayRecuperationHealthFacilityDinnerOfferContainer(){
    if(shortStayRecuperationHealthFacilityDinnerOfferContainer==null){
      shortStayRecuperationHealthFacilityDinnerOfferContainer = new ACLabelContainer();
      shortStayRecuperationHealthFacilityDinnerOfferContainer.setFollowChildEnabled(true);
      shortStayRecuperationHealthFacilityDinnerOfferContainer.add(getShortStayRecuperationHealthFacilityDinnerOffer(), null);
    }
    return shortStayRecuperationHealthFacilityDinnerOfferContainer;
  }

  /**
   * �H���񋟃��f�����擾���܂��B
   * @return �H���񋟃��f��
   */
  protected ACComboBoxModelAdapter getShortStayRecuperationHealthFacilityDinnerOfferModel(){
    if(shortStayRecuperationHealthFacilityDinnerOfferModel==null){
      shortStayRecuperationHealthFacilityDinnerOfferModel = new ACComboBoxModelAdapter();
      addShortStayRecuperationHealthFacilityDinnerOfferModel();
    }
    return shortStayRecuperationHealthFacilityDinnerOfferModel;
  }

  /**
   * �H����p���擾���܂��B
   * @return �H����p
   */
  public ACTextField getShortStayRecuperationHealthFacilityDinnerCost(){
    if(shortStayRecuperationHealthFacilityDinnerCost==null){

      shortStayRecuperationHealthFacilityDinnerCost = new ACTextField();

      getShortStayRecuperationHealthFacilityDinnerCostContainer().setText("�H����p");

      shortStayRecuperationHealthFacilityDinnerCost.setBindPath("1220115");

      shortStayRecuperationHealthFacilityDinnerCost.setColumns(4);

      shortStayRecuperationHealthFacilityDinnerCost.setCharType(VRCharType.ONLY_DIGIT);

      shortStayRecuperationHealthFacilityDinnerCost.setHorizontalAlignment(SwingConstants.RIGHT);

      shortStayRecuperationHealthFacilityDinnerCost.setIMEMode(InputSubset.LATIN);

      shortStayRecuperationHealthFacilityDinnerCost.setMaxLength(5);

      addShortStayRecuperationHealthFacilityDinnerCost();
    }
    return shortStayRecuperationHealthFacilityDinnerCost;

  }

  /**
   * �H����p�R���e�i���擾���܂��B
   * @return �H����p�R���e�i
   */
  protected ACLabelContainer getShortStayRecuperationHealthFacilityDinnerCostContainer(){
    if(shortStayRecuperationHealthFacilityDinnerCostContainer==null){
      shortStayRecuperationHealthFacilityDinnerCostContainer = new ACLabelContainer();
      shortStayRecuperationHealthFacilityDinnerCostContainer.setFollowChildEnabled(true);
      shortStayRecuperationHealthFacilityDinnerCostContainer.add(getShortStayRecuperationHealthFacilityDinnerCost(), null);
    }
    return shortStayRecuperationHealthFacilityDinnerCostContainer;
  }

  /**
   * 30�������擾���܂��B
   * @return 30����
   */
  public ACIntegerCheckBox getShortStayRecuperationHealthFacilityEtc30Over(){
    if(shortStayRecuperationHealthFacilityEtc30Over==null){

      shortStayRecuperationHealthFacilityEtc30Over = new ACIntegerCheckBox();

      shortStayRecuperationHealthFacilityEtc30Over.setText("30����");

      shortStayRecuperationHealthFacilityEtc30Over.setBindPath("5");

      addShortStayRecuperationHealthFacilityEtc30Over();
    }
    return shortStayRecuperationHealthFacilityEtc30Over;

  }

  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001012Design() {

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

    tab1.add(getShortStayRecuperationHealthFacilityInstitutionDivisionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getShortStayRecuperationHealthFacilityHospitalRoomDivisionContena(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getShortStayRecuperationHealthNightWorkConditionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getShortStayRecuperationHealthFacilityEtcRehabilitationContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getShortStayRecuperationHealthFacilityEtcDementiaSpecialBuildingRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getShortStayRecuperationHealthFacilityMeetingAndSendingOffContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getShortStayRecuperationHealthFacilityUrgentTimeStepRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * �{�݋敪�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperationHealthFacilityInstitutionDivisionRadio(){

  }

  /**
   * �{�݋敪���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperationHealthFacilityInstitutionDivisionRadioModel(){

    getShortStayRecuperationHealthFacilityInstitutionDivisionRadioItem1().setButtonIndex(1);
    getShortStayRecuperationHealthFacilityInstitutionDivisionRadioModel().add(getShortStayRecuperationHealthFacilityInstitutionDivisionRadioItem1());

    getShortStayRecuperationHealthFacilityInstitutionDivisionRadioItem2().setButtonIndex(2);
    getShortStayRecuperationHealthFacilityInstitutionDivisionRadioModel().add(getShortStayRecuperationHealthFacilityInstitutionDivisionRadioItem2());

  }

  /**
   * ���V�l�ی��{�݂ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperationHealthFacilityInstitutionDivisionRadioItem1(){

  }

  /**
   * ���j�b�g�^���V�l�ی��{�݂ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperationHealthFacilityInstitutionDivisionRadioItem2(){

  }

  /**
   * �a���敪�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperationHealthFacilityHospitalRoomDivisionContena(){

    shortStayRecuperationHealthFacilityHospitalRoomDivisionContena.add(getShortStayRecuperationHealthFacilityHospitalRoomDivisionRadio(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayRecuperationHealthFacilityHospitalRoomDivisionContena.add(getShortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadio(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * �a���敪�i���V�l�ی��{�݁j�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperationHealthFacilityHospitalRoomDivisionRadio(){

  }

  /**
   * �a���敪�i���V�l�ی��{�݁j���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperationHealthFacilityHospitalRoomDivisionRadioModel(){

    getShortStayRecuperationHealthFacilityHospitalRoomDivisionRadioItem1().setButtonIndex(1);
    getShortStayRecuperationHealthFacilityHospitalRoomDivisionRadioModel().add(getShortStayRecuperationHealthFacilityHospitalRoomDivisionRadioItem1());

    getShortStayRecuperationHealthFacilityHospitalRoomDivisionRadioItem2().setButtonIndex(2);
    getShortStayRecuperationHealthFacilityHospitalRoomDivisionRadioModel().add(getShortStayRecuperationHealthFacilityHospitalRoomDivisionRadioItem2());

  }

  /**
   * �]���^���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperationHealthFacilityHospitalRoomDivisionRadioItem1(){

  }

  /**
   * �������ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperationHealthFacilityHospitalRoomDivisionRadioItem2(){

  }

  /**
   * �a���敪�i���j�b�g�^���V�l�ی��{�݁j�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadio(){

  }

  /**
   * �a���敪�i���j�b�g�^���V�l�ی��{�݁j���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadioModel(){

    getShortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadioItem1().setButtonIndex(1);
    getShortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadioModel().add(getShortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadioItem1());

    getShortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadioItem2().setButtonIndex(2);
    getShortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadioModel().add(getShortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadioItem2());

  }

  /**
   * ���j�b�g�^���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadioItem1(){

  }

  /**
   * ���j�b�g�^�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadioItem2(){

  }

  /**
   * ��ԋΖ�������ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperationHealthNightWorkConditionRadio(){

  }

  /**
   * ��ԋΖ���������f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperationHealthNightWorkConditionRadioModel(){

    getShortStayRecuperationHealthNightWorkConditionRadioItem1().setButtonIndex(1);
    getShortStayRecuperationHealthNightWorkConditionRadioModel().add(getShortStayRecuperationHealthNightWorkConditionRadioItem1());

    getShortStayRecuperationHealthNightWorkConditionRadioItem2().setButtonIndex(2);
    getShortStayRecuperationHealthNightWorkConditionRadioModel().add(getShortStayRecuperationHealthNightWorkConditionRadioItem2());

  }

  /**
   * ��^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperationHealthNightWorkConditionRadioItem1(){

  }

  /**
   * ���Z�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperationHealthNightWorkConditionRadioItem2(){

  }

  /**
   * ���n�r���@�\�������Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperationHealthFacilityEtcRehabilitation(){

  }

  /**
   * ���n�r���@�\�������Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperationHealthFacilityEtcRehabilitationModel(){

    getShortStayRecuperationHealthFacilityEtcRehabilitationRadioItem2().setButtonIndex(1);
    getShortStayRecuperationHealthFacilityEtcRehabilitationModel().add(getShortStayRecuperationHealthFacilityEtcRehabilitationRadioItem2());

    getShortStayRecuperationHealthFacilityEtcRehabilitationRadioItem1().setButtonIndex(2);
    getShortStayRecuperationHealthFacilityEtcRehabilitationModel().add(getShortStayRecuperationHealthFacilityEtcRehabilitationRadioItem1());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperationHealthFacilityEtcRehabilitationRadioItem2(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperationHealthFacilityEtcRehabilitationRadioItem1(){

  }

  /**
   * �F�m�ǐ����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperationHealthFacilityEtcDementiaSpecialBuildingRadio(){

  }

  /**
   * �F�m�ǐ����Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperationHealthFacilityEtcDementiaSpecialBuildingRadioModel(){

    getShortStayRecuperationHealthFacilityEtcDementiaSpecialBuildingRadioItem2().setButtonIndex(1);
    getShortStayRecuperationHealthFacilityEtcDementiaSpecialBuildingRadioModel().add(getShortStayRecuperationHealthFacilityEtcDementiaSpecialBuildingRadioItem2());

    getShortStayRecuperationHealthFacilityEtcDementiaSpecialBuildingRadioItem1().setButtonIndex(2);
    getShortStayRecuperationHealthFacilityEtcDementiaSpecialBuildingRadioModel().add(getShortStayRecuperationHealthFacilityEtcDementiaSpecialBuildingRadioItem1());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperationHealthFacilityEtcDementiaSpecialBuildingRadioItem2(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperationHealthFacilityEtcDementiaSpecialBuildingRadioItem1(){

  }

  /**
   * ���}�敪�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperationHealthFacilityMeetingAndSendingOff(){

  }

  /**
   * ���}�敪���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperationHealthFacilityMeetingAndSendingOffModel(){

    getShortStayRecuperationHealthFacilityMeetingAndSendingOffNone().setButtonIndex(1);
    getShortStayRecuperationHealthFacilityMeetingAndSendingOffModel().add(getShortStayRecuperationHealthFacilityMeetingAndSendingOffNone());

    getShortStayRecuperationHealthFacilityMeetingAndSendingOffOneWay().setButtonIndex(2);
    getShortStayRecuperationHealthFacilityMeetingAndSendingOffModel().add(getShortStayRecuperationHealthFacilityMeetingAndSendingOffOneWay());

    getShortStayRecuperationHealthFacilityMeetingAndSendingOffRoundTrip().setButtonIndex(3);
    getShortStayRecuperationHealthFacilityMeetingAndSendingOffModel().add(getShortStayRecuperationHealthFacilityMeetingAndSendingOffRoundTrip());

  }

  /**
   * ���}�Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperationHealthFacilityMeetingAndSendingOffNone(){

  }

  /**
   * ���}�Г��ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperationHealthFacilityMeetingAndSendingOffOneWay(){

  }

  /**
   * ���}�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperationHealthFacilityMeetingAndSendingOffRoundTrip(){

  }

  /**
   * �ً}�����ÊǗ����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperationHealthFacilityUrgentTimeStepRadio(){

  }

  /**
   * �ً}�����ÊǗ����Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperationHealthFacilityUrgentTimeStepRadioModel(){

    getShortStayRecuperationHealthFacilityUrgentTimeStepRadioItem1().setButtonIndex(1);
    getShortStayRecuperationHealthFacilityUrgentTimeStepRadioModel().add(getShortStayRecuperationHealthFacilityUrgentTimeStepRadioItem1());

    getShortStayRecuperationHealthFacilityUrgentTimeStepRadioItem2().setButtonIndex(2);
    getShortStayRecuperationHealthFacilityUrgentTimeStepRadioModel().add(getShortStayRecuperationHealthFacilityUrgentTimeStepRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperationHealthFacilityUrgentTimeStepRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperationHealthFacilityUrgentTimeStepRadioItem2(){

  }

  /**
   * �^�u2�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTab2(){

    tab2.add(getShortStayRecuperationHealthFacilityDieticianManageRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getShortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getShortStayRecuperationHealthFacilityPersonSubtractionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getShortStayRecuperationHealthFacilityDinnerContainer(), VRLayout.FLOW_DOUBLEINSETLINE_RETURN);

    tab2.add(getShortStayRecuperationHealthFacilityEtc30Over(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * �h�{�Ǘ��̐����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperationHealthFacilityDieticianManageRadio(){

  }

  /**
   * �h�{�Ǘ��̐����Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperationHealthFacilityDieticianManageRadioModel(){

    getShortStayRecuperationHealthFacilityDieticianManageRadioItem1().setButtonIndex(1);
    getShortStayRecuperationHealthFacilityDieticianManageRadioModel().add(getShortStayRecuperationHealthFacilityDieticianManageRadioItem1());

    getShortStayRecuperationHealthFacilityDieticianManageRadioItem2().setButtonIndex(2);
    getShortStayRecuperationHealthFacilityDieticianManageRadioModel().add(getShortStayRecuperationHealthFacilityDieticianManageRadioItem2());

    getShortStayRecuperationHealthFacilityDieticianManageRadioItem3().setButtonIndex(3);
    getShortStayRecuperationHealthFacilityDieticianManageRadioModel().add(getShortStayRecuperationHealthFacilityDieticianManageRadioItem3());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperationHealthFacilityDieticianManageRadioItem1(){

  }

  /**
   * �Ǘ��h�{�m�z�u���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperationHealthFacilityDieticianManageRadioItem2(){

  }

  /**
   * �h�{�m�z�u���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperationHealthFacilityDieticianManageRadioItem3(){

  }

  /**
   * �×{�H���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperationHealthFacilityDieticianMedicalExpensesRadio(){

  }

  /**
   * �×{�H���Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioModel(){

    getShortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioItem1().setButtonIndex(1);
    getShortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioModel().add(getShortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioItem1());

    getShortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioItem2().setButtonIndex(2);
    getShortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioModel().add(getShortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioItem2(){

  }

  /**
   * �l�����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperationHealthFacilityPersonSubtraction(){

  }

  /**
   * �l�����Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperationHealthFacilityPersonSubtractionModel(){

    getShortStayRecuperationHealthFacilityPersonSubtractionNot().setButtonIndex(1);
    getShortStayRecuperationHealthFacilityPersonSubtractionModel().add(getShortStayRecuperationHealthFacilityPersonSubtractionNot());

    getShortStayRecuperationHealthFacilityPersonSubtractionExcess().setButtonIndex(2);
    getShortStayRecuperationHealthFacilityPersonSubtractionModel().add(getShortStayRecuperationHealthFacilityPersonSubtractionExcess());

    getShortStayRecuperationHealthFacilityPersonSubtractionStaffLack().setButtonIndex(3);
    getShortStayRecuperationHealthFacilityPersonSubtractionModel().add(getShortStayRecuperationHealthFacilityPersonSubtractionStaffLack());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperationHealthFacilityPersonSubtractionNot(){

  }

  /**
   * ������߂ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperationHealthFacilityPersonSubtractionExcess(){

  }

  /**
   * �Ō�E���E�����͈�t�APT�EOT�̕s���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperationHealthFacilityPersonSubtractionStaffLack(){

  }

  /**
   * �H���R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperationHealthFacilityDinnerContainer(){

    shortStayRecuperationHealthFacilityDinnerContainer.add(getShortStayRecuperationHealthFacilityDinnerOfferContainer(), VRLayout.FLOW);

    shortStayRecuperationHealthFacilityDinnerContainer.add(getShortStayRecuperationHealthFacilityDinnerCostContainer(), VRLayout.FLOW);

  }

  /**
   * �H���񋟂ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperationHealthFacilityDinnerOffer(){

  }

  /**
   * �H���񋟃��f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperationHealthFacilityDinnerOfferModel(){

  }

  /**
   * �H����p�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperationHealthFacilityDinnerCost(){

  }

  /**
   * 30�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperationHealthFacilityEtc30Over(){

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
      ACFrame.getInstance().getContentPane().add(new QS001012Design());
      ACFrame.getInstance().setVisible(true);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QS001012Design getThis() {
    return this;
  }
}
