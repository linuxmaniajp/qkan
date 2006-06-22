
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
 * �v���O���� �T�[�r�X�p�^�[���Z�������×{���i�a�@�×{�j (QS001013)
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
 * �T�[�r�X�p�^�[���Z�������×{���i�a�@�×{�j��ʍ��ڃf�U�C��(QS001013) 
 */
public class QS001013Design extends QS001ServicePanel {
  //GUI�R���|�[�l���g

  private JTabbedPane tabs;

  private ACPanel tab1;

  private ACClearableRadioButtonGroup shortStayHospitalRecuperationInstitutionDivisionRadio;

  private ACLabelContainer shortStayHospitalRecuperationInstitutionDivisionRadioContainer;

  private ACListModelAdapter shortStayHospitalRecuperationInstitutionDivisionRadioModel;

  private ACRadioButtonItem shortStayHospitalRecuperationInstitutionDivisionRadioItem1;

  private ACRadioButtonItem shortStayHospitalRecuperationInstitutionDivisionRadioItem2;

  private ACClearableRadioButtonGroup shortStayHospitalRecuperationDivision;

  private ACLabelContainer shortStayHospitalRecuperationDivisionContainer;

  private ACListModelAdapter shortStayHospitalRecuperationDivisionModel;

  private ACRadioButtonItem shortStayHospitalRecuperationType1;

  private ACRadioButtonItem shortStayHospitalRecuperationType2;

  private ACRadioButtonItem shortStayHospitalRecuperationType3;

  private ACLabelContainer shortStayHospitalRecuperationHospitalRoomContena;

  private ACClearableRadioButtonGroup shortStayHospitalRecuperationHospitalRoomRadio;

  private ACListModelAdapter shortStayHospitalRecuperationHospitalRoomRadioModel;

  private ACRadioButtonItem shortStayHospitalRecuperationHospitalRoomRadioItem1;

  private ACRadioButtonItem shortStayHospitalRecuperationHospitalRoomRadioItem2;

  private ACClearableRadioButtonGroup shortStayHospitalRecuperationUnitHospitalRoomRadio;

  private ACListModelAdapter shortStayHospitalRecuperationUnitHospitalRoomRadioModel;

  private ACRadioButtonItem shortStayHospitalRecuperationUnitHospitalRoomRadioItem1;

  private ACRadioButtonItem shortStayHospitalRecuperationUnitHospitalRoomRadioItem2;

  private ACClearableRadioButtonGroup shortStayHospitalRecuperationAdditionType;

  private ACLabelContainer shortStayHospitalRecuperationAdditionTypeContainer;

  private ACListModelAdapter shortStayHospitalRecuperationAdditionTypeModel;

  private ACRadioButtonItem shortStayHospitalRecuperationAdditionTypeNormal;

  private ACRadioButtonItem shortStayHospitalRecuperationAdditionType1;

  private ACRadioButtonItem shortStayHospitalRecuperationAdditionType2;

  private ACRadioButtonItem shortStayHospitalRecuperationAdditionType3;

  private ACRadioButtonItem shortStayHospitalRecuperationAdditionTypeNone;

  private ACClearableRadioButtonGroup shortStayHospitalRecuperationSubtractionType;

  private ACLabelContainer shortStayHospitalRecuperationSubtractionTypeContainer;

  private ACListModelAdapter shortStayHospitalRecuperationSubtractionTypeModel;

  private ACRadioButtonItem shortStayHospitalRecuperationSubtractionTypeNormal;

  private ACRadioButtonItem shortStayHospitalRecuperationSubtractionType1;

  private ACRadioButtonItem shortStayHospitalRecuperationSubtractionType2;

  private ACRadioButtonItem shortStayHospitalRecuperationSubtractionType3;

  private ACClearableRadioButtonGroup shortStayHospitalRecuperationApplicationType;

  private ACLabelContainer shortStayHospitalRecuperationApplicationTypeContainer;

  private ACListModelAdapter shortStayHospitalRecuperationApplicationTypeModel;

  private ACRadioButtonItem shortStayHospitalRecuperationApplicationTypeNormal;

  private ACRadioButtonItem shortStayHospitalRecuperationApplicationType49;

  private ACClearableRadioButtonGroup shortStayHospitalRecuperationMeetingAndSendingOff;

  private ACLabelContainer shortStayHospitalRecuperationMeetingAndSendingOffContainer;

  private ACListModelAdapter shortStayHospitalRecuperationMeetingAndSendingOffModel;

  private ACRadioButtonItem shortStayHospitalRecuperationMeetingAndSendingOffNone;

  private ACRadioButtonItem shortStayHospitalRecuperationMeetingAndSendingOffOneWay;

  private ACRadioButtonItem shortStayHospitalRecuperationMeetingAndSendingOffRoundTrip;

  private ACPanel tab2;

  private ACClearableRadioButtonGroup shortStayHospitalRecuperationDieticianManageRadio;

  private ACLabelContainer shortStayHospitalRecuperationDieticianManageRadioContainer;

  private ACListModelAdapter shortStayHospitalRecuperationDieticianManageRadioModel;

  private ACRadioButtonItem shortStayHospitalRecuperationDieticianManageRadioItem1;

  private ACRadioButtonItem shortStayHospitalRecuperationDieticianManageRadioItem2;

  private ACRadioButtonItem shortStayHospitalRecuperationDieticianManageRadioItem3;

  private ACClearableRadioButtonGroup shortStayHospitalRecuperationMedicalExpensesRadio;

  private ACLabelContainer shortStayHospitalRecuperationMedicalExpensesRadioContainer;

  private ACListModelAdapter shortStayHospitalRecuperationMedicalExpensesRadioModel;

  private ACRadioButtonItem shortStayHospitalRecuperationMedicalExpensesRadioItem1;

  private ACRadioButtonItem shortStayHospitalRecuperationMedicalExpensesRadioItem2;

  private ACMapBindButton shortStayHospitalRecuperationSpecificConsultationFee;

  private ACLabel shortStayHospitalRecuperationSpecificConsultationFeeOutline;

  private ACComboBox shortStayHospitalRecuperationPersonSubtraction;

  private ACLabelContainer shortStayHospitalRecuperationPersonSubtractionContainer;

  private ACComboBoxModelAdapter shortStayHospitalRecuperationPersonSubtractionModel;

  private ACBackLabelContainer shortStayRecuperationHealthFacilityDinnerContainer;

  private ACComboBox shortStayRecuperationHealthFacilityDinnerOffer;

  private ACLabelContainer shortStayRecuperationHealthFacilityDinnerOfferContainer;

  private ACComboBoxModelAdapter shortStayRecuperationHealthFacilityDinnerOfferModel;

  private ACTextField shortStayRecuperationHealthFacilityDinnerCost;

  private ACLabelContainer shortStayRecuperationHealthFacilityDinnerCostContainer;

  private ACIntegerCheckBox shortStayHospitalRecuperationEtc30Over;

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
  public ACClearableRadioButtonGroup getShortStayHospitalRecuperationInstitutionDivisionRadio(){
    if(shortStayHospitalRecuperationInstitutionDivisionRadio==null){

      shortStayHospitalRecuperationInstitutionDivisionRadio = new ACClearableRadioButtonGroup();

      getShortStayHospitalRecuperationInstitutionDivisionRadioContainer().setText("�{�݋敪");

      shortStayHospitalRecuperationInstitutionDivisionRadio.setBindPath("1230101");

      shortStayHospitalRecuperationInstitutionDivisionRadio.setModel(getShortStayHospitalRecuperationInstitutionDivisionRadioModel());

      shortStayHospitalRecuperationInstitutionDivisionRadio.setUseClearButton(false);

      addShortStayHospitalRecuperationInstitutionDivisionRadio();
    }
    return shortStayHospitalRecuperationInstitutionDivisionRadio;

  }

  /**
   * �{�݋敪�R���e�i���擾���܂��B
   * @return �{�݋敪�R���e�i
   */
  protected ACLabelContainer getShortStayHospitalRecuperationInstitutionDivisionRadioContainer(){
    if(shortStayHospitalRecuperationInstitutionDivisionRadioContainer==null){
      shortStayHospitalRecuperationInstitutionDivisionRadioContainer = new ACLabelContainer();
      shortStayHospitalRecuperationInstitutionDivisionRadioContainer.setFollowChildEnabled(true);
      shortStayHospitalRecuperationInstitutionDivisionRadioContainer.add(getShortStayHospitalRecuperationInstitutionDivisionRadio(), null);
    }
    return shortStayHospitalRecuperationInstitutionDivisionRadioContainer;
  }

  /**
   * �{�݋敪���f�����擾���܂��B
   * @return �{�݋敪���f��
   */
  protected ACListModelAdapter getShortStayHospitalRecuperationInstitutionDivisionRadioModel(){
    if(shortStayHospitalRecuperationInstitutionDivisionRadioModel==null){
      shortStayHospitalRecuperationInstitutionDivisionRadioModel = new ACListModelAdapter();
      addShortStayHospitalRecuperationInstitutionDivisionRadioModel();
    }
    return shortStayHospitalRecuperationInstitutionDivisionRadioModel;
  }

  /**
   * �a�@���擾���܂��B
   * @return �a�@
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationInstitutionDivisionRadioItem1(){
    if(shortStayHospitalRecuperationInstitutionDivisionRadioItem1==null){

      shortStayHospitalRecuperationInstitutionDivisionRadioItem1 = new ACRadioButtonItem();

      shortStayHospitalRecuperationInstitutionDivisionRadioItem1.setText("�a�@");

      shortStayHospitalRecuperationInstitutionDivisionRadioItem1.setGroup(getShortStayHospitalRecuperationInstitutionDivisionRadio());

      shortStayHospitalRecuperationInstitutionDivisionRadioItem1.setConstraints(VRLayout.FLOW);

      addShortStayHospitalRecuperationInstitutionDivisionRadioItem1();
    }
    return shortStayHospitalRecuperationInstitutionDivisionRadioItem1;

  }

  /**
   * ���j�b�g�^�a�@���擾���܂��B
   * @return ���j�b�g�^�a�@
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationInstitutionDivisionRadioItem2(){
    if(shortStayHospitalRecuperationInstitutionDivisionRadioItem2==null){

      shortStayHospitalRecuperationInstitutionDivisionRadioItem2 = new ACRadioButtonItem();

      shortStayHospitalRecuperationInstitutionDivisionRadioItem2.setText("���j�b�g�^�a�@");

      shortStayHospitalRecuperationInstitutionDivisionRadioItem2.setGroup(getShortStayHospitalRecuperationInstitutionDivisionRadio());

      shortStayHospitalRecuperationInstitutionDivisionRadioItem2.setConstraints(VRLayout.FLOW);

      addShortStayHospitalRecuperationInstitutionDivisionRadioItem2();
    }
    return shortStayHospitalRecuperationInstitutionDivisionRadioItem2;

  }

  /**
   * �l���z�u�敪���擾���܂��B
   * @return �l���z�u�敪
   */
  public ACClearableRadioButtonGroup getShortStayHospitalRecuperationDivision(){
    if(shortStayHospitalRecuperationDivision==null){

      shortStayHospitalRecuperationDivision = new ACClearableRadioButtonGroup();

      getShortStayHospitalRecuperationDivisionContainer().setText("�l���z�u�敪");

      shortStayHospitalRecuperationDivision.setBindPath("1230102");

      shortStayHospitalRecuperationDivision.setModel(getShortStayHospitalRecuperationDivisionModel());

      shortStayHospitalRecuperationDivision.setUseClearButton(false);

      addShortStayHospitalRecuperationDivision();
    }
    return shortStayHospitalRecuperationDivision;

  }

  /**
   * �l���z�u�敪�R���e�i���擾���܂��B
   * @return �l���z�u�敪�R���e�i
   */
  protected ACLabelContainer getShortStayHospitalRecuperationDivisionContainer(){
    if(shortStayHospitalRecuperationDivisionContainer==null){
      shortStayHospitalRecuperationDivisionContainer = new ACLabelContainer();
      shortStayHospitalRecuperationDivisionContainer.setFollowChildEnabled(true);
      shortStayHospitalRecuperationDivisionContainer.add(getShortStayHospitalRecuperationDivision(), null);
    }
    return shortStayHospitalRecuperationDivisionContainer;
  }

  /**
   * �l���z�u�敪���f�����擾���܂��B
   * @return �l���z�u�敪���f��
   */
  protected ACListModelAdapter getShortStayHospitalRecuperationDivisionModel(){
    if(shortStayHospitalRecuperationDivisionModel==null){
      shortStayHospitalRecuperationDivisionModel = new ACListModelAdapter();
      addShortStayHospitalRecuperationDivisionModel();
    }
    return shortStayHospitalRecuperationDivisionModel;
  }

  /**
   * I�^���擾���܂��B
   * @return I�^
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationType1(){
    if(shortStayHospitalRecuperationType1==null){

      shortStayHospitalRecuperationType1 = new ACRadioButtonItem();

      shortStayHospitalRecuperationType1.setText("I�^");

      shortStayHospitalRecuperationType1.setGroup(getShortStayHospitalRecuperationDivision());

      shortStayHospitalRecuperationType1.setConstraints(VRLayout.FLOW);

      addShortStayHospitalRecuperationType1();
    }
    return shortStayHospitalRecuperationType1;

  }

  /**
   * II�^���擾���܂��B
   * @return II�^
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationType2(){
    if(shortStayHospitalRecuperationType2==null){

      shortStayHospitalRecuperationType2 = new ACRadioButtonItem();

      shortStayHospitalRecuperationType2.setText("II�^");

      shortStayHospitalRecuperationType2.setGroup(getShortStayHospitalRecuperationDivision());

      shortStayHospitalRecuperationType2.setConstraints(VRLayout.FLOW);

      addShortStayHospitalRecuperationType2();
    }
    return shortStayHospitalRecuperationType2;

  }

  /**
   * III�^���擾���܂��B
   * @return III�^
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationType3(){
    if(shortStayHospitalRecuperationType3==null){

      shortStayHospitalRecuperationType3 = new ACRadioButtonItem();

      shortStayHospitalRecuperationType3.setText("III�^");

      shortStayHospitalRecuperationType3.setGroup(getShortStayHospitalRecuperationDivision());

      shortStayHospitalRecuperationType3.setConstraints(VRLayout.FLOW);

      addShortStayHospitalRecuperationType3();
    }
    return shortStayHospitalRecuperationType3;

  }

  /**
   * �a���敪�E�R���e�i���擾���܂��B
   * @return �a���敪�E�R���e�i
   */
  public ACLabelContainer getShortStayHospitalRecuperationHospitalRoomContena(){
    if(shortStayHospitalRecuperationHospitalRoomContena==null){

      shortStayHospitalRecuperationHospitalRoomContena = new ACLabelContainer();

      shortStayHospitalRecuperationHospitalRoomContena.setText("�a���敪");

      addShortStayHospitalRecuperationHospitalRoomContena();
    }
    return shortStayHospitalRecuperationHospitalRoomContena;

  }

  /**
   * �a���敪�i�a���j���擾���܂��B
   * @return �a���敪�i�a���j
   */
  public ACClearableRadioButtonGroup getShortStayHospitalRecuperationHospitalRoomRadio(){
    if(shortStayHospitalRecuperationHospitalRoomRadio==null){

      shortStayHospitalRecuperationHospitalRoomRadio = new ACClearableRadioButtonGroup();

      shortStayHospitalRecuperationHospitalRoomRadio.setBindPath("1230103");

      shortStayHospitalRecuperationHospitalRoomRadio.setModel(getShortStayHospitalRecuperationHospitalRoomRadioModel());

      shortStayHospitalRecuperationHospitalRoomRadio.setUseClearButton(false);

      addShortStayHospitalRecuperationHospitalRoomRadio();
    }
    return shortStayHospitalRecuperationHospitalRoomRadio;

  }

  /**
   * �a���敪�i�a���j���f�����擾���܂��B
   * @return �a���敪�i�a���j���f��
   */
  protected ACListModelAdapter getShortStayHospitalRecuperationHospitalRoomRadioModel(){
    if(shortStayHospitalRecuperationHospitalRoomRadioModel==null){
      shortStayHospitalRecuperationHospitalRoomRadioModel = new ACListModelAdapter();
      addShortStayHospitalRecuperationHospitalRoomRadioModel();
    }
    return shortStayHospitalRecuperationHospitalRoomRadioModel;
  }

  /**
   * �]���^�����擾���܂��B
   * @return �]���^��
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationHospitalRoomRadioItem1(){
    if(shortStayHospitalRecuperationHospitalRoomRadioItem1==null){

      shortStayHospitalRecuperationHospitalRoomRadioItem1 = new ACRadioButtonItem();

      shortStayHospitalRecuperationHospitalRoomRadioItem1.setText("�]���^��");

      shortStayHospitalRecuperationHospitalRoomRadioItem1.setGroup(getShortStayHospitalRecuperationHospitalRoomRadio());

      shortStayHospitalRecuperationHospitalRoomRadioItem1.setConstraints(VRLayout.FLOW);

      addShortStayHospitalRecuperationHospitalRoomRadioItem1();
    }
    return shortStayHospitalRecuperationHospitalRoomRadioItem1;

  }

  /**
   * ���������擾���܂��B
   * @return ������
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationHospitalRoomRadioItem2(){
    if(shortStayHospitalRecuperationHospitalRoomRadioItem2==null){

      shortStayHospitalRecuperationHospitalRoomRadioItem2 = new ACRadioButtonItem();

      shortStayHospitalRecuperationHospitalRoomRadioItem2.setText("������");

      shortStayHospitalRecuperationHospitalRoomRadioItem2.setGroup(getShortStayHospitalRecuperationHospitalRoomRadio());

      shortStayHospitalRecuperationHospitalRoomRadioItem2.setConstraints(VRLayout.FLOW);

      addShortStayHospitalRecuperationHospitalRoomRadioItem2();
    }
    return shortStayHospitalRecuperationHospitalRoomRadioItem2;

  }

  /**
   * �a���敪�i���j�b�g�^�a�@�j���擾���܂��B
   * @return �a���敪�i���j�b�g�^�a�@�j
   */
  public ACClearableRadioButtonGroup getShortStayHospitalRecuperationUnitHospitalRoomRadio(){
    if(shortStayHospitalRecuperationUnitHospitalRoomRadio==null){

      shortStayHospitalRecuperationUnitHospitalRoomRadio = new ACClearableRadioButtonGroup();

      shortStayHospitalRecuperationUnitHospitalRoomRadio.setBindPath("1230104");

      shortStayHospitalRecuperationUnitHospitalRoomRadio.setModel(getShortStayHospitalRecuperationUnitHospitalRoomRadioModel());

      shortStayHospitalRecuperationUnitHospitalRoomRadio.setUseClearButton(false);

      addShortStayHospitalRecuperationUnitHospitalRoomRadio();
    }
    return shortStayHospitalRecuperationUnitHospitalRoomRadio;

  }

  /**
   * �a���敪�i���j�b�g�^�a�@�j���f�����擾���܂��B
   * @return �a���敪�i���j�b�g�^�a�@�j���f��
   */
  protected ACListModelAdapter getShortStayHospitalRecuperationUnitHospitalRoomRadioModel(){
    if(shortStayHospitalRecuperationUnitHospitalRoomRadioModel==null){
      shortStayHospitalRecuperationUnitHospitalRoomRadioModel = new ACListModelAdapter();
      addShortStayHospitalRecuperationUnitHospitalRoomRadioModel();
    }
    return shortStayHospitalRecuperationUnitHospitalRoomRadioModel;
  }

  /**
   * ���j�b�g�^�����擾���܂��B
   * @return ���j�b�g�^��
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationUnitHospitalRoomRadioItem1(){
    if(shortStayHospitalRecuperationUnitHospitalRoomRadioItem1==null){

      shortStayHospitalRecuperationUnitHospitalRoomRadioItem1 = new ACRadioButtonItem();

      shortStayHospitalRecuperationUnitHospitalRoomRadioItem1.setText("���j�b�g�^��");

      shortStayHospitalRecuperationUnitHospitalRoomRadioItem1.setGroup(getShortStayHospitalRecuperationUnitHospitalRoomRadio());

      shortStayHospitalRecuperationUnitHospitalRoomRadioItem1.setConstraints(VRLayout.FLOW);

      addShortStayHospitalRecuperationUnitHospitalRoomRadioItem1();
    }
    return shortStayHospitalRecuperationUnitHospitalRoomRadioItem1;

  }

  /**
   * ���j�b�g�^�������擾���܂��B
   * @return ���j�b�g�^����
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationUnitHospitalRoomRadioItem2(){
    if(shortStayHospitalRecuperationUnitHospitalRoomRadioItem2==null){

      shortStayHospitalRecuperationUnitHospitalRoomRadioItem2 = new ACRadioButtonItem();

      shortStayHospitalRecuperationUnitHospitalRoomRadioItem2.setText("���j�b�g�^����");

      shortStayHospitalRecuperationUnitHospitalRoomRadioItem2.setGroup(getShortStayHospitalRecuperationUnitHospitalRoomRadio());

      shortStayHospitalRecuperationUnitHospitalRoomRadioItem2.setConstraints(VRLayout.FLOW);

      addShortStayHospitalRecuperationUnitHospitalRoomRadioItem2();
    }
    return shortStayHospitalRecuperationUnitHospitalRoomRadioItem2;

  }

  /**
   * ��ԋΖ���������擾���܂��B
   * @return ��ԋΖ������
   */
  public ACClearableRadioButtonGroup getShortStayHospitalRecuperationAdditionType(){
    if(shortStayHospitalRecuperationAdditionType==null){

      shortStayHospitalRecuperationAdditionType = new ACClearableRadioButtonGroup();

      getShortStayHospitalRecuperationAdditionTypeContainer().setText("��ԋΖ������");

      shortStayHospitalRecuperationAdditionType.setBindPath("1230105");

      shortStayHospitalRecuperationAdditionType.setModel(getShortStayHospitalRecuperationAdditionTypeModel());

      shortStayHospitalRecuperationAdditionType.setUseClearButton(false);

      addShortStayHospitalRecuperationAdditionType();
    }
    return shortStayHospitalRecuperationAdditionType;

  }

  /**
   * ��ԋΖ�������R���e�i���擾���܂��B
   * @return ��ԋΖ�������R���e�i
   */
  protected ACLabelContainer getShortStayHospitalRecuperationAdditionTypeContainer(){
    if(shortStayHospitalRecuperationAdditionTypeContainer==null){
      shortStayHospitalRecuperationAdditionTypeContainer = new ACLabelContainer();
      shortStayHospitalRecuperationAdditionTypeContainer.setFollowChildEnabled(true);
      shortStayHospitalRecuperationAdditionTypeContainer.add(getShortStayHospitalRecuperationAdditionType(), null);
    }
    return shortStayHospitalRecuperationAdditionTypeContainer;
  }

  /**
   * ��ԋΖ���������f�����擾���܂��B
   * @return ��ԋΖ���������f��
   */
  protected ACListModelAdapter getShortStayHospitalRecuperationAdditionTypeModel(){
    if(shortStayHospitalRecuperationAdditionTypeModel==null){
      shortStayHospitalRecuperationAdditionTypeModel = new ACListModelAdapter();
      addShortStayHospitalRecuperationAdditionTypeModel();
    }
    return shortStayHospitalRecuperationAdditionTypeModel;
  }

  /**
   * �ʏ���擾���܂��B
   * @return �ʏ�
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationAdditionTypeNormal(){
    if(shortStayHospitalRecuperationAdditionTypeNormal==null){

      shortStayHospitalRecuperationAdditionTypeNormal = new ACRadioButtonItem();

      shortStayHospitalRecuperationAdditionTypeNormal.setText("��^");

      shortStayHospitalRecuperationAdditionTypeNormal.setGroup(getShortStayHospitalRecuperationAdditionType());

      shortStayHospitalRecuperationAdditionTypeNormal.setConstraints(VRLayout.FLOW);

      addShortStayHospitalRecuperationAdditionTypeNormal();
    }
    return shortStayHospitalRecuperationAdditionTypeNormal;

  }

  /**
   * ���Z�^I���擾���܂��B
   * @return ���Z�^I
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationAdditionType1(){
    if(shortStayHospitalRecuperationAdditionType1==null){

      shortStayHospitalRecuperationAdditionType1 = new ACRadioButtonItem();

      shortStayHospitalRecuperationAdditionType1.setText("���Z�^I");

      shortStayHospitalRecuperationAdditionType1.setGroup(getShortStayHospitalRecuperationAdditionType());

      shortStayHospitalRecuperationAdditionType1.setConstraints(VRLayout.FLOW_RETURN);

      addShortStayHospitalRecuperationAdditionType1();
    }
    return shortStayHospitalRecuperationAdditionType1;

  }

  /**
   * ���Z�^II���擾���܂��B
   * @return ���Z�^II
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationAdditionType2(){
    if(shortStayHospitalRecuperationAdditionType2==null){

      shortStayHospitalRecuperationAdditionType2 = new ACRadioButtonItem();

      shortStayHospitalRecuperationAdditionType2.setText("���Z�^II");

      shortStayHospitalRecuperationAdditionType2.setGroup(getShortStayHospitalRecuperationAdditionType());

      shortStayHospitalRecuperationAdditionType2.setConstraints(VRLayout.FLOW);

      addShortStayHospitalRecuperationAdditionType2();
    }
    return shortStayHospitalRecuperationAdditionType2;

  }

  /**
   * ���Z�^III���擾���܂��B
   * @return ���Z�^III
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationAdditionType3(){
    if(shortStayHospitalRecuperationAdditionType3==null){

      shortStayHospitalRecuperationAdditionType3 = new ACRadioButtonItem();

      shortStayHospitalRecuperationAdditionType3.setText("���Z�^III");

      shortStayHospitalRecuperationAdditionType3.setGroup(getShortStayHospitalRecuperationAdditionType());

      shortStayHospitalRecuperationAdditionType3.setConstraints(VRLayout.FLOW_RETURN);

      addShortStayHospitalRecuperationAdditionType3();
    }
    return shortStayHospitalRecuperationAdditionType3;

  }

  /**
   * ���Z�^���擾���܂��B
   * @return ���Z�^
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationAdditionTypeNone(){
    if(shortStayHospitalRecuperationAdditionTypeNone==null){

      shortStayHospitalRecuperationAdditionTypeNone = new ACRadioButtonItem();

      shortStayHospitalRecuperationAdditionTypeNone.setText("���Z�^");

      shortStayHospitalRecuperationAdditionTypeNone.setGroup(getShortStayHospitalRecuperationAdditionType());

      shortStayHospitalRecuperationAdditionTypeNone.setConstraints(VRLayout.FLOW);

      addShortStayHospitalRecuperationAdditionTypeNone();
    }
    return shortStayHospitalRecuperationAdditionTypeNone;

  }

  /**
   * �×{�����Z�^���擾���܂��B
   * @return �×{�����Z�^
   */
  public ACClearableRadioButtonGroup getShortStayHospitalRecuperationSubtractionType(){
    if(shortStayHospitalRecuperationSubtractionType==null){

      shortStayHospitalRecuperationSubtractionType = new ACClearableRadioButtonGroup();

      getShortStayHospitalRecuperationSubtractionTypeContainer().setText("�×{�����Z");

      shortStayHospitalRecuperationSubtractionType.setBindPath("1230106");

      shortStayHospitalRecuperationSubtractionType.setModel(getShortStayHospitalRecuperationSubtractionTypeModel());

      shortStayHospitalRecuperationSubtractionType.setUseClearButton(false);

      addShortStayHospitalRecuperationSubtractionType();
    }
    return shortStayHospitalRecuperationSubtractionType;

  }

  /**
   * �×{�����Z�^�R���e�i���擾���܂��B
   * @return �×{�����Z�^�R���e�i
   */
  protected ACLabelContainer getShortStayHospitalRecuperationSubtractionTypeContainer(){
    if(shortStayHospitalRecuperationSubtractionTypeContainer==null){
      shortStayHospitalRecuperationSubtractionTypeContainer = new ACLabelContainer();
      shortStayHospitalRecuperationSubtractionTypeContainer.setFollowChildEnabled(true);
      shortStayHospitalRecuperationSubtractionTypeContainer.add(getShortStayHospitalRecuperationSubtractionType(), null);
    }
    return shortStayHospitalRecuperationSubtractionTypeContainer;
  }

  /**
   * �×{�����Z�^���f�����擾���܂��B
   * @return �×{�����Z�^���f��
   */
  protected ACListModelAdapter getShortStayHospitalRecuperationSubtractionTypeModel(){
    if(shortStayHospitalRecuperationSubtractionTypeModel==null){
      shortStayHospitalRecuperationSubtractionTypeModel = new ACListModelAdapter();
      addShortStayHospitalRecuperationSubtractionTypeModel();
    }
    return shortStayHospitalRecuperationSubtractionTypeModel;
  }

  /**
   * ����擾���܂��B
   * @return �
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationSubtractionTypeNormal(){
    if(shortStayHospitalRecuperationSubtractionTypeNormal==null){

      shortStayHospitalRecuperationSubtractionTypeNormal = new ACRadioButtonItem();

      shortStayHospitalRecuperationSubtractionTypeNormal.setText("��^");

      shortStayHospitalRecuperationSubtractionTypeNormal.setGroup(getShortStayHospitalRecuperationSubtractionType());

      shortStayHospitalRecuperationSubtractionTypeNormal.setConstraints(VRLayout.FLOW);

      addShortStayHospitalRecuperationSubtractionTypeNormal();
    }
    return shortStayHospitalRecuperationSubtractionTypeNormal;

  }

  /**
   * ��I���擾���܂��B
   * @return ��I
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationSubtractionType1(){
    if(shortStayHospitalRecuperationSubtractionType1==null){

      shortStayHospitalRecuperationSubtractionType1 = new ACRadioButtonItem();

      shortStayHospitalRecuperationSubtractionType1.setText("���Z�^I");

      shortStayHospitalRecuperationSubtractionType1.setGroup(getShortStayHospitalRecuperationSubtractionType());

      shortStayHospitalRecuperationSubtractionType1.setConstraints(VRLayout.FLOW_RETURN);

      addShortStayHospitalRecuperationSubtractionType1();
    }
    return shortStayHospitalRecuperationSubtractionType1;

  }

  /**
   * ��II���擾���܂��B
   * @return ��II
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationSubtractionType2(){
    if(shortStayHospitalRecuperationSubtractionType2==null){

      shortStayHospitalRecuperationSubtractionType2 = new ACRadioButtonItem();

      shortStayHospitalRecuperationSubtractionType2.setText("���Z�^II");

      shortStayHospitalRecuperationSubtractionType2.setGroup(getShortStayHospitalRecuperationSubtractionType());

      shortStayHospitalRecuperationSubtractionType2.setConstraints(VRLayout.FLOW);

      addShortStayHospitalRecuperationSubtractionType2();
    }
    return shortStayHospitalRecuperationSubtractionType2;

  }

  /**
   * ��III���擾���܂��B
   * @return ��III
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationSubtractionType3(){
    if(shortStayHospitalRecuperationSubtractionType3==null){

      shortStayHospitalRecuperationSubtractionType3 = new ACRadioButtonItem();

      shortStayHospitalRecuperationSubtractionType3.setText("���Z�^III");

      shortStayHospitalRecuperationSubtractionType3.setGroup(getShortStayHospitalRecuperationSubtractionType());

      shortStayHospitalRecuperationSubtractionType3.setConstraints(VRLayout.FLOW);

      addShortStayHospitalRecuperationSubtractionType3();
    }
    return shortStayHospitalRecuperationSubtractionType3;

  }

  /**
   * ��t�̔z�u����擾���܂��B
   * @return ��t�̔z�u�
   */
  public ACClearableRadioButtonGroup getShortStayHospitalRecuperationApplicationType(){
    if(shortStayHospitalRecuperationApplicationType==null){

      shortStayHospitalRecuperationApplicationType = new ACClearableRadioButtonGroup();

      getShortStayHospitalRecuperationApplicationTypeContainer().setText("��t�̔z�u�");

      shortStayHospitalRecuperationApplicationType.setBindPath("1230107");

      shortStayHospitalRecuperationApplicationType.setModel(getShortStayHospitalRecuperationApplicationTypeModel());

      shortStayHospitalRecuperationApplicationType.setUseClearButton(false);

      addShortStayHospitalRecuperationApplicationType();
    }
    return shortStayHospitalRecuperationApplicationType;

  }

  /**
   * ��t�̔z�u��R���e�i���擾���܂��B
   * @return ��t�̔z�u��R���e�i
   */
  protected ACLabelContainer getShortStayHospitalRecuperationApplicationTypeContainer(){
    if(shortStayHospitalRecuperationApplicationTypeContainer==null){
      shortStayHospitalRecuperationApplicationTypeContainer = new ACLabelContainer();
      shortStayHospitalRecuperationApplicationTypeContainer.setFollowChildEnabled(true);
      shortStayHospitalRecuperationApplicationTypeContainer.add(getShortStayHospitalRecuperationApplicationType(), null);
    }
    return shortStayHospitalRecuperationApplicationTypeContainer;
  }

  /**
   * ��t�̔z�u����f�����擾���܂��B
   * @return ��t�̔z�u����f��
   */
  protected ACListModelAdapter getShortStayHospitalRecuperationApplicationTypeModel(){
    if(shortStayHospitalRecuperationApplicationTypeModel==null){
      shortStayHospitalRecuperationApplicationTypeModel = new ACListModelAdapter();
      addShortStayHospitalRecuperationApplicationTypeModel();
    }
    return shortStayHospitalRecuperationApplicationTypeModel;
  }

  /**
   * ����擾���܂��B
   * @return �
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationApplicationTypeNormal(){
    if(shortStayHospitalRecuperationApplicationTypeNormal==null){

      shortStayHospitalRecuperationApplicationTypeNormal = new ACRadioButtonItem();

      shortStayHospitalRecuperationApplicationTypeNormal.setText("�");

      shortStayHospitalRecuperationApplicationTypeNormal.setGroup(getShortStayHospitalRecuperationApplicationType());

      shortStayHospitalRecuperationApplicationTypeNormal.setConstraints(VRLayout.FLOW);

      addShortStayHospitalRecuperationApplicationTypeNormal();
    }
    return shortStayHospitalRecuperationApplicationTypeNormal;

  }

  /**
   * 49��K�p���擾���܂��B
   * @return 49��K�p
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationApplicationType49(){
    if(shortStayHospitalRecuperationApplicationType49==null){

      shortStayHospitalRecuperationApplicationType49 = new ACRadioButtonItem();

      shortStayHospitalRecuperationApplicationType49.setText("49��K�p");

      shortStayHospitalRecuperationApplicationType49.setGroup(getShortStayHospitalRecuperationApplicationType());

      shortStayHospitalRecuperationApplicationType49.setConstraints(VRLayout.FLOW);

      addShortStayHospitalRecuperationApplicationType49();
    }
    return shortStayHospitalRecuperationApplicationType49;

  }

  /**
   * ���}���Z���擾���܂��B
   * @return ���}���Z
   */
  public ACClearableRadioButtonGroup getShortStayHospitalRecuperationMeetingAndSendingOff(){
    if(shortStayHospitalRecuperationMeetingAndSendingOff==null){

      shortStayHospitalRecuperationMeetingAndSendingOff = new ACClearableRadioButtonGroup();

      getShortStayHospitalRecuperationMeetingAndSendingOffContainer().setText("���}���Z");

      shortStayHospitalRecuperationMeetingAndSendingOff.setBindPath("6");

      shortStayHospitalRecuperationMeetingAndSendingOff.setModel(getShortStayHospitalRecuperationMeetingAndSendingOffModel());

      shortStayHospitalRecuperationMeetingAndSendingOff.setUseClearButton(false);

      addShortStayHospitalRecuperationMeetingAndSendingOff();
    }
    return shortStayHospitalRecuperationMeetingAndSendingOff;

  }

  /**
   * ���}���Z�R���e�i���擾���܂��B
   * @return ���}���Z�R���e�i
   */
  protected ACLabelContainer getShortStayHospitalRecuperationMeetingAndSendingOffContainer(){
    if(shortStayHospitalRecuperationMeetingAndSendingOffContainer==null){
      shortStayHospitalRecuperationMeetingAndSendingOffContainer = new ACLabelContainer();
      shortStayHospitalRecuperationMeetingAndSendingOffContainer.setFollowChildEnabled(true);
      shortStayHospitalRecuperationMeetingAndSendingOffContainer.add(getShortStayHospitalRecuperationMeetingAndSendingOff(), null);
    }
    return shortStayHospitalRecuperationMeetingAndSendingOffContainer;
  }

  /**
   * ���}���Z���f�����擾���܂��B
   * @return ���}���Z���f��
   */
  protected ACListModelAdapter getShortStayHospitalRecuperationMeetingAndSendingOffModel(){
    if(shortStayHospitalRecuperationMeetingAndSendingOffModel==null){
      shortStayHospitalRecuperationMeetingAndSendingOffModel = new ACListModelAdapter();
      addShortStayHospitalRecuperationMeetingAndSendingOffModel();
    }
    return shortStayHospitalRecuperationMeetingAndSendingOffModel;
  }

  /**
   * ���}�Ȃ����擾���܂��B
   * @return ���}�Ȃ�
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationMeetingAndSendingOffNone(){
    if(shortStayHospitalRecuperationMeetingAndSendingOffNone==null){

      shortStayHospitalRecuperationMeetingAndSendingOffNone = new ACRadioButtonItem();

      shortStayHospitalRecuperationMeetingAndSendingOffNone.setText("���}�Ȃ�");

      shortStayHospitalRecuperationMeetingAndSendingOffNone.setGroup(getShortStayHospitalRecuperationMeetingAndSendingOff());

      shortStayHospitalRecuperationMeetingAndSendingOffNone.setConstraints(VRLayout.FLOW);

      addShortStayHospitalRecuperationMeetingAndSendingOffNone();
    }
    return shortStayHospitalRecuperationMeetingAndSendingOffNone;

  }

  /**
   * ���}�Г����擾���܂��B
   * @return ���}�Г�
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationMeetingAndSendingOffOneWay(){
    if(shortStayHospitalRecuperationMeetingAndSendingOffOneWay==null){

      shortStayHospitalRecuperationMeetingAndSendingOffOneWay = new ACRadioButtonItem();

      shortStayHospitalRecuperationMeetingAndSendingOffOneWay.setText("���}�Г�");

      shortStayHospitalRecuperationMeetingAndSendingOffOneWay.setGroup(getShortStayHospitalRecuperationMeetingAndSendingOff());

      shortStayHospitalRecuperationMeetingAndSendingOffOneWay.setConstraints(VRLayout.FLOW);

      addShortStayHospitalRecuperationMeetingAndSendingOffOneWay();
    }
    return shortStayHospitalRecuperationMeetingAndSendingOffOneWay;

  }

  /**
   * ���}�������擾���܂��B
   * @return ���}����
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationMeetingAndSendingOffRoundTrip(){
    if(shortStayHospitalRecuperationMeetingAndSendingOffRoundTrip==null){

      shortStayHospitalRecuperationMeetingAndSendingOffRoundTrip = new ACRadioButtonItem();

      shortStayHospitalRecuperationMeetingAndSendingOffRoundTrip.setText("���}����");

      shortStayHospitalRecuperationMeetingAndSendingOffRoundTrip.setGroup(getShortStayHospitalRecuperationMeetingAndSendingOff());

      shortStayHospitalRecuperationMeetingAndSendingOffRoundTrip.setConstraints(VRLayout.FLOW);

      addShortStayHospitalRecuperationMeetingAndSendingOffRoundTrip();
    }
    return shortStayHospitalRecuperationMeetingAndSendingOffRoundTrip;

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
  public ACClearableRadioButtonGroup getShortStayHospitalRecuperationDieticianManageRadio(){
    if(shortStayHospitalRecuperationDieticianManageRadio==null){

      shortStayHospitalRecuperationDieticianManageRadio = new ACClearableRadioButtonGroup();

      getShortStayHospitalRecuperationDieticianManageRadioContainer().setText("�h�{�Ǘ��̐����Z");

      shortStayHospitalRecuperationDieticianManageRadio.setBindPath("1230109");

      shortStayHospitalRecuperationDieticianManageRadio.setModel(getShortStayHospitalRecuperationDieticianManageRadioModel());

      shortStayHospitalRecuperationDieticianManageRadio.setUseClearButton(false);

      addShortStayHospitalRecuperationDieticianManageRadio();
    }
    return shortStayHospitalRecuperationDieticianManageRadio;

  }

  /**
   * �h�{�Ǘ��̐����Z�R���e�i���擾���܂��B
   * @return �h�{�Ǘ��̐����Z�R���e�i
   */
  protected ACLabelContainer getShortStayHospitalRecuperationDieticianManageRadioContainer(){
    if(shortStayHospitalRecuperationDieticianManageRadioContainer==null){
      shortStayHospitalRecuperationDieticianManageRadioContainer = new ACLabelContainer();
      shortStayHospitalRecuperationDieticianManageRadioContainer.setFollowChildEnabled(true);
      shortStayHospitalRecuperationDieticianManageRadioContainer.add(getShortStayHospitalRecuperationDieticianManageRadio(), null);
    }
    return shortStayHospitalRecuperationDieticianManageRadioContainer;
  }

  /**
   * �h�{�Ǘ��̐����Z���f�����擾���܂��B
   * @return �h�{�Ǘ��̐����Z���f��
   */
  protected ACListModelAdapter getShortStayHospitalRecuperationDieticianManageRadioModel(){
    if(shortStayHospitalRecuperationDieticianManageRadioModel==null){
      shortStayHospitalRecuperationDieticianManageRadioModel = new ACListModelAdapter();
      addShortStayHospitalRecuperationDieticianManageRadioModel();
    }
    return shortStayHospitalRecuperationDieticianManageRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationDieticianManageRadioItem1(){
    if(shortStayHospitalRecuperationDieticianManageRadioItem1==null){

      shortStayHospitalRecuperationDieticianManageRadioItem1 = new ACRadioButtonItem();

      shortStayHospitalRecuperationDieticianManageRadioItem1.setText("�Ȃ�");

      shortStayHospitalRecuperationDieticianManageRadioItem1.setGroup(getShortStayHospitalRecuperationDieticianManageRadio());

      shortStayHospitalRecuperationDieticianManageRadioItem1.setConstraints(VRLayout.FLOW);

      addShortStayHospitalRecuperationDieticianManageRadioItem1();
    }
    return shortStayHospitalRecuperationDieticianManageRadioItem1;

  }

  /**
   * �Ǘ��h�{�m�z�u���擾���܂��B
   * @return �Ǘ��h�{�m�z�u
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationDieticianManageRadioItem2(){
    if(shortStayHospitalRecuperationDieticianManageRadioItem2==null){

      shortStayHospitalRecuperationDieticianManageRadioItem2 = new ACRadioButtonItem();

      shortStayHospitalRecuperationDieticianManageRadioItem2.setText("�Ǘ��h�{�m�z�u���Z");

      shortStayHospitalRecuperationDieticianManageRadioItem2.setGroup(getShortStayHospitalRecuperationDieticianManageRadio());

      shortStayHospitalRecuperationDieticianManageRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

      addShortStayHospitalRecuperationDieticianManageRadioItem2();
    }
    return shortStayHospitalRecuperationDieticianManageRadioItem2;

  }

  /**
   * �h�{�m�z�u���Z���擾���܂��B
   * @return �h�{�m�z�u���Z
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationDieticianManageRadioItem3(){
    if(shortStayHospitalRecuperationDieticianManageRadioItem3==null){

      shortStayHospitalRecuperationDieticianManageRadioItem3 = new ACRadioButtonItem();

      shortStayHospitalRecuperationDieticianManageRadioItem3.setText("�h�{�m�z�u���Z");

      shortStayHospitalRecuperationDieticianManageRadioItem3.setGroup(getShortStayHospitalRecuperationDieticianManageRadio());

      shortStayHospitalRecuperationDieticianManageRadioItem3.setConstraints(VRLayout.FLOW);

      addShortStayHospitalRecuperationDieticianManageRadioItem3();
    }
    return shortStayHospitalRecuperationDieticianManageRadioItem3;

  }

  /**
   * �×{�H���Z���擾���܂��B
   * @return �×{�H���Z
   */
  public ACClearableRadioButtonGroup getShortStayHospitalRecuperationMedicalExpensesRadio(){
    if(shortStayHospitalRecuperationMedicalExpensesRadio==null){

      shortStayHospitalRecuperationMedicalExpensesRadio = new ACClearableRadioButtonGroup();

      getShortStayHospitalRecuperationMedicalExpensesRadioContainer().setText("�×{�H���Z");

      shortStayHospitalRecuperationMedicalExpensesRadio.setBindPath("1230110");

      shortStayHospitalRecuperationMedicalExpensesRadio.setModel(getShortStayHospitalRecuperationMedicalExpensesRadioModel());

      shortStayHospitalRecuperationMedicalExpensesRadio.setUseClearButton(false);

      addShortStayHospitalRecuperationMedicalExpensesRadio();
    }
    return shortStayHospitalRecuperationMedicalExpensesRadio;

  }

  /**
   * �×{�H���Z�R���e�i���擾���܂��B
   * @return �×{�H���Z�R���e�i
   */
  protected ACLabelContainer getShortStayHospitalRecuperationMedicalExpensesRadioContainer(){
    if(shortStayHospitalRecuperationMedicalExpensesRadioContainer==null){
      shortStayHospitalRecuperationMedicalExpensesRadioContainer = new ACLabelContainer();
      shortStayHospitalRecuperationMedicalExpensesRadioContainer.setFollowChildEnabled(true);
      shortStayHospitalRecuperationMedicalExpensesRadioContainer.add(getShortStayHospitalRecuperationMedicalExpensesRadio(), null);
    }
    return shortStayHospitalRecuperationMedicalExpensesRadioContainer;
  }

  /**
   * �×{�H���Z���f�����擾���܂��B
   * @return �×{�H���Z���f��
   */
  protected ACListModelAdapter getShortStayHospitalRecuperationMedicalExpensesRadioModel(){
    if(shortStayHospitalRecuperationMedicalExpensesRadioModel==null){
      shortStayHospitalRecuperationMedicalExpensesRadioModel = new ACListModelAdapter();
      addShortStayHospitalRecuperationMedicalExpensesRadioModel();
    }
    return shortStayHospitalRecuperationMedicalExpensesRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationMedicalExpensesRadioItem1(){
    if(shortStayHospitalRecuperationMedicalExpensesRadioItem1==null){

      shortStayHospitalRecuperationMedicalExpensesRadioItem1 = new ACRadioButtonItem();

      shortStayHospitalRecuperationMedicalExpensesRadioItem1.setText("�Ȃ�");

      shortStayHospitalRecuperationMedicalExpensesRadioItem1.setGroup(getShortStayHospitalRecuperationMedicalExpensesRadio());

      shortStayHospitalRecuperationMedicalExpensesRadioItem1.setConstraints(VRLayout.FLOW);

      addShortStayHospitalRecuperationMedicalExpensesRadioItem1();
    }
    return shortStayHospitalRecuperationMedicalExpensesRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationMedicalExpensesRadioItem2(){
    if(shortStayHospitalRecuperationMedicalExpensesRadioItem2==null){

      shortStayHospitalRecuperationMedicalExpensesRadioItem2 = new ACRadioButtonItem();

      shortStayHospitalRecuperationMedicalExpensesRadioItem2.setText("����");

      shortStayHospitalRecuperationMedicalExpensesRadioItem2.setGroup(getShortStayHospitalRecuperationMedicalExpensesRadio());

      shortStayHospitalRecuperationMedicalExpensesRadioItem2.setConstraints(VRLayout.FLOW);

      addShortStayHospitalRecuperationMedicalExpensesRadioItem2();
    }
    return shortStayHospitalRecuperationMedicalExpensesRadioItem2;

  }

  /**
   * ����f�Ô�{�^�����擾���܂��B
   * @return ����f�Ô�{�^��
   */
  public ACMapBindButton getShortStayHospitalRecuperationSpecificConsultationFee(){
    if(shortStayHospitalRecuperationSpecificConsultationFee==null){

      shortStayHospitalRecuperationSpecificConsultationFee = new ACMapBindButton();

      shortStayHospitalRecuperationSpecificConsultationFee.setText("����f�Ô�");

      shortStayHospitalRecuperationSpecificConsultationFee.setToolTipText("����f�Ô��ݒ肵�܂��B");

      addShortStayHospitalRecuperationSpecificConsultationFee();
    }
    return shortStayHospitalRecuperationSpecificConsultationFee;

  }

  /**
   * �ݒ胉�x�����擾���܂��B
   * @return �ݒ胉�x��
   */
  public ACLabel getShortStayHospitalRecuperationSpecificConsultationFeeOutline(){
    if(shortStayHospitalRecuperationSpecificConsultationFeeOutline==null){

      shortStayHospitalRecuperationSpecificConsultationFeeOutline = new ACLabel();

      shortStayHospitalRecuperationSpecificConsultationFeeOutline.setText("�ݒ�Ȃ�");

      shortStayHospitalRecuperationSpecificConsultationFeeOutline.setOpaque(true);
      shortStayHospitalRecuperationSpecificConsultationFeeOutline.setBackground(new Color(255,255,172));

      addShortStayHospitalRecuperationSpecificConsultationFeeOutline();
    }
    return shortStayHospitalRecuperationSpecificConsultationFeeOutline;

  }

  /**
   * �l�����Z�R���{���擾���܂��B
   * @return �l�����Z�R���{
   */
  public ACComboBox getShortStayHospitalRecuperationPersonSubtraction(){
    if(shortStayHospitalRecuperationPersonSubtraction==null){

      shortStayHospitalRecuperationPersonSubtraction = new ACComboBox();

      getShortStayHospitalRecuperationPersonSubtractionContainer().setText("�l�����Z");

      shortStayHospitalRecuperationPersonSubtraction.setBindPath("1230149");

      shortStayHospitalRecuperationPersonSubtraction.setEditable(false);

      shortStayHospitalRecuperationPersonSubtraction.setModelBindPath("1230149");

      shortStayHospitalRecuperationPersonSubtraction.setModel(getShortStayHospitalRecuperationPersonSubtractionModel());

      shortStayHospitalRecuperationPersonSubtraction.setRenderBindPath("CONTENT");

      addShortStayHospitalRecuperationPersonSubtraction();
    }
    return shortStayHospitalRecuperationPersonSubtraction;

  }

  /**
   * �l�����Z�R���{�R���e�i���擾���܂��B
   * @return �l�����Z�R���{�R���e�i
   */
  protected ACLabelContainer getShortStayHospitalRecuperationPersonSubtractionContainer(){
    if(shortStayHospitalRecuperationPersonSubtractionContainer==null){
      shortStayHospitalRecuperationPersonSubtractionContainer = new ACLabelContainer();
      shortStayHospitalRecuperationPersonSubtractionContainer.setFollowChildEnabled(true);
      shortStayHospitalRecuperationPersonSubtractionContainer.add(getShortStayHospitalRecuperationPersonSubtraction(), null);
    }
    return shortStayHospitalRecuperationPersonSubtractionContainer;
  }

  /**
   * �l�����Z�R���{���f�����擾���܂��B
   * @return �l�����Z�R���{���f��
   */
  protected ACComboBoxModelAdapter getShortStayHospitalRecuperationPersonSubtractionModel(){
    if(shortStayHospitalRecuperationPersonSubtractionModel==null){
      shortStayHospitalRecuperationPersonSubtractionModel = new ACComboBoxModelAdapter();
      addShortStayHospitalRecuperationPersonSubtractionModel();
    }
    return shortStayHospitalRecuperationPersonSubtractionModel;
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

      shortStayRecuperationHealthFacilityDinnerOffer.setBindPath("1230150");

      shortStayRecuperationHealthFacilityDinnerOffer.setEditable(false);

      shortStayRecuperationHealthFacilityDinnerOffer.setModelBindPath("1230150");

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

      shortStayRecuperationHealthFacilityDinnerCost.setBindPath("1230153");

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
  public ACIntegerCheckBox getShortStayHospitalRecuperationEtc30Over(){
    if(shortStayHospitalRecuperationEtc30Over==null){

      shortStayHospitalRecuperationEtc30Over = new ACIntegerCheckBox();

      shortStayHospitalRecuperationEtc30Over.setText("30����");

      shortStayHospitalRecuperationEtc30Over.setBindPath("5");

      addShortStayHospitalRecuperationEtc30Over();
    }
    return shortStayHospitalRecuperationEtc30Over;

  }

  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001013Design() {

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

    tab1.add(getShortStayHospitalRecuperationInstitutionDivisionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getShortStayHospitalRecuperationDivisionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getShortStayHospitalRecuperationHospitalRoomContena(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getShortStayHospitalRecuperationAdditionTypeContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getShortStayHospitalRecuperationSubtractionTypeContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getShortStayHospitalRecuperationApplicationTypeContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getShortStayHospitalRecuperationMeetingAndSendingOffContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * �{�݋敪�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationInstitutionDivisionRadio(){

  }

  /**
   * �{�݋敪���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationInstitutionDivisionRadioModel(){

    getShortStayHospitalRecuperationInstitutionDivisionRadioItem1().setButtonIndex(1);
    getShortStayHospitalRecuperationInstitutionDivisionRadioModel().add(getShortStayHospitalRecuperationInstitutionDivisionRadioItem1());

    getShortStayHospitalRecuperationInstitutionDivisionRadioItem2().setButtonIndex(2);
    getShortStayHospitalRecuperationInstitutionDivisionRadioModel().add(getShortStayHospitalRecuperationInstitutionDivisionRadioItem2());

  }

  /**
   * �a�@�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationInstitutionDivisionRadioItem1(){

  }

  /**
   * ���j�b�g�^�a�@�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationInstitutionDivisionRadioItem2(){

  }

  /**
   * �l���z�u�敪�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationDivision(){

  }

  /**
   * �l���z�u�敪���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationDivisionModel(){

    getShortStayHospitalRecuperationType1().setButtonIndex(1);
    getShortStayHospitalRecuperationDivisionModel().add(getShortStayHospitalRecuperationType1());

    getShortStayHospitalRecuperationType2().setButtonIndex(2);
    getShortStayHospitalRecuperationDivisionModel().add(getShortStayHospitalRecuperationType2());

    getShortStayHospitalRecuperationType3().setButtonIndex(3);
    getShortStayHospitalRecuperationDivisionModel().add(getShortStayHospitalRecuperationType3());

  }

  /**
   * I�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationType1(){

  }

  /**
   * II�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationType2(){

  }

  /**
   * III�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationType3(){

  }

  /**
   * �a���敪�E�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationHospitalRoomContena(){

    shortStayHospitalRecuperationHospitalRoomContena.add(getShortStayHospitalRecuperationHospitalRoomRadio(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayHospitalRecuperationHospitalRoomContena.add(getShortStayHospitalRecuperationUnitHospitalRoomRadio(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * �a���敪�i�a���j�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationHospitalRoomRadio(){

  }

  /**
   * �a���敪�i�a���j���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationHospitalRoomRadioModel(){

    getShortStayHospitalRecuperationHospitalRoomRadioItem1().setButtonIndex(1);
    getShortStayHospitalRecuperationHospitalRoomRadioModel().add(getShortStayHospitalRecuperationHospitalRoomRadioItem1());

    getShortStayHospitalRecuperationHospitalRoomRadioItem2().setButtonIndex(2);
    getShortStayHospitalRecuperationHospitalRoomRadioModel().add(getShortStayHospitalRecuperationHospitalRoomRadioItem2());

  }

  /**
   * �]���^���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationHospitalRoomRadioItem1(){

  }

  /**
   * �������ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationHospitalRoomRadioItem2(){

  }

  /**
   * �a���敪�i���j�b�g�^�a�@�j�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationUnitHospitalRoomRadio(){

  }

  /**
   * �a���敪�i���j�b�g�^�a�@�j���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationUnitHospitalRoomRadioModel(){

    getShortStayHospitalRecuperationUnitHospitalRoomRadioItem1().setButtonIndex(1);
    getShortStayHospitalRecuperationUnitHospitalRoomRadioModel().add(getShortStayHospitalRecuperationUnitHospitalRoomRadioItem1());

    getShortStayHospitalRecuperationUnitHospitalRoomRadioItem2().setButtonIndex(2);
    getShortStayHospitalRecuperationUnitHospitalRoomRadioModel().add(getShortStayHospitalRecuperationUnitHospitalRoomRadioItem2());

  }

  /**
   * ���j�b�g�^���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationUnitHospitalRoomRadioItem1(){

  }

  /**
   * ���j�b�g�^�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationUnitHospitalRoomRadioItem2(){

  }

  /**
   * ��ԋΖ�������ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationAdditionType(){

  }

  /**
   * ��ԋΖ���������f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationAdditionTypeModel(){

    getShortStayHospitalRecuperationAdditionTypeNormal().setButtonIndex(1);
    getShortStayHospitalRecuperationAdditionTypeModel().add(getShortStayHospitalRecuperationAdditionTypeNormal());

    getShortStayHospitalRecuperationAdditionType1().setButtonIndex(2);
    getShortStayHospitalRecuperationAdditionTypeModel().add(getShortStayHospitalRecuperationAdditionType1());

    getShortStayHospitalRecuperationAdditionType2().setButtonIndex(3);
    getShortStayHospitalRecuperationAdditionTypeModel().add(getShortStayHospitalRecuperationAdditionType2());

    getShortStayHospitalRecuperationAdditionType3().setButtonIndex(4);
    getShortStayHospitalRecuperationAdditionTypeModel().add(getShortStayHospitalRecuperationAdditionType3());

    getShortStayHospitalRecuperationAdditionTypeNone().setButtonIndex(5);
    getShortStayHospitalRecuperationAdditionTypeModel().add(getShortStayHospitalRecuperationAdditionTypeNone());

  }

  /**
   * �ʏ�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationAdditionTypeNormal(){

  }

  /**
   * ���Z�^I�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationAdditionType1(){

  }

  /**
   * ���Z�^II�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationAdditionType2(){

  }

  /**
   * ���Z�^III�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationAdditionType3(){

  }

  /**
   * ���Z�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationAdditionTypeNone(){

  }

  /**
   * �×{�����Z�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationSubtractionType(){

  }

  /**
   * �×{�����Z�^���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationSubtractionTypeModel(){

    getShortStayHospitalRecuperationSubtractionTypeNormal().setButtonIndex(1);
    getShortStayHospitalRecuperationSubtractionTypeModel().add(getShortStayHospitalRecuperationSubtractionTypeNormal());

    getShortStayHospitalRecuperationSubtractionType1().setButtonIndex(2);
    getShortStayHospitalRecuperationSubtractionTypeModel().add(getShortStayHospitalRecuperationSubtractionType1());

    getShortStayHospitalRecuperationSubtractionType2().setButtonIndex(3);
    getShortStayHospitalRecuperationSubtractionTypeModel().add(getShortStayHospitalRecuperationSubtractionType2());

    getShortStayHospitalRecuperationSubtractionType3().setButtonIndex(4);
    getShortStayHospitalRecuperationSubtractionTypeModel().add(getShortStayHospitalRecuperationSubtractionType3());

  }

  /**
   * ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationSubtractionTypeNormal(){

  }

  /**
   * ��I�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationSubtractionType1(){

  }

  /**
   * ��II�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationSubtractionType2(){

  }

  /**
   * ��III�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationSubtractionType3(){

  }

  /**
   * ��t�̔z�u��ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationApplicationType(){

  }

  /**
   * ��t�̔z�u����f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationApplicationTypeModel(){

    getShortStayHospitalRecuperationApplicationTypeNormal().setButtonIndex(1);
    getShortStayHospitalRecuperationApplicationTypeModel().add(getShortStayHospitalRecuperationApplicationTypeNormal());

    getShortStayHospitalRecuperationApplicationType49().setButtonIndex(2);
    getShortStayHospitalRecuperationApplicationTypeModel().add(getShortStayHospitalRecuperationApplicationType49());

  }

  /**
   * ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationApplicationTypeNormal(){

  }

  /**
   * 49��K�p�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationApplicationType49(){

  }

  /**
   * ���}���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationMeetingAndSendingOff(){

  }

  /**
   * ���}���Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationMeetingAndSendingOffModel(){

    getShortStayHospitalRecuperationMeetingAndSendingOffNone().setButtonIndex(1);
    getShortStayHospitalRecuperationMeetingAndSendingOffModel().add(getShortStayHospitalRecuperationMeetingAndSendingOffNone());

    getShortStayHospitalRecuperationMeetingAndSendingOffOneWay().setButtonIndex(2);
    getShortStayHospitalRecuperationMeetingAndSendingOffModel().add(getShortStayHospitalRecuperationMeetingAndSendingOffOneWay());

    getShortStayHospitalRecuperationMeetingAndSendingOffRoundTrip().setButtonIndex(3);
    getShortStayHospitalRecuperationMeetingAndSendingOffModel().add(getShortStayHospitalRecuperationMeetingAndSendingOffRoundTrip());

  }

  /**
   * ���}�Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationMeetingAndSendingOffNone(){

  }

  /**
   * ���}�Г��ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationMeetingAndSendingOffOneWay(){

  }

  /**
   * ���}�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationMeetingAndSendingOffRoundTrip(){

  }

  /**
   * �^�u2�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTab2(){

    tab2.add(getShortStayHospitalRecuperationDieticianManageRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getShortStayHospitalRecuperationMedicalExpensesRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getShortStayHospitalRecuperationSpecificConsultationFee(), VRLayout.FLOW);

    tab2.add(getShortStayHospitalRecuperationSpecificConsultationFeeOutline(), VRLayout.FLOW_RETURN);

    tab2.add(getShortStayHospitalRecuperationPersonSubtractionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getShortStayRecuperationHealthFacilityDinnerContainer(), VRLayout.FLOW_DOUBLEINSETLINE_RETURN);

    tab2.add(getShortStayHospitalRecuperationEtc30Over(), VRLayout.FLOW_INSETLINE);

  }

  /**
   * �h�{�Ǘ��̐����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationDieticianManageRadio(){

  }

  /**
   * �h�{�Ǘ��̐����Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationDieticianManageRadioModel(){

    getShortStayHospitalRecuperationDieticianManageRadioItem1().setButtonIndex(1);
    getShortStayHospitalRecuperationDieticianManageRadioModel().add(getShortStayHospitalRecuperationDieticianManageRadioItem1());

    getShortStayHospitalRecuperationDieticianManageRadioItem2().setButtonIndex(2);
    getShortStayHospitalRecuperationDieticianManageRadioModel().add(getShortStayHospitalRecuperationDieticianManageRadioItem2());

    getShortStayHospitalRecuperationDieticianManageRadioItem3().setButtonIndex(3);
    getShortStayHospitalRecuperationDieticianManageRadioModel().add(getShortStayHospitalRecuperationDieticianManageRadioItem3());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationDieticianManageRadioItem1(){

  }

  /**
   * �Ǘ��h�{�m�z�u�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationDieticianManageRadioItem2(){

  }

  /**
   * �h�{�m�z�u���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationDieticianManageRadioItem3(){

  }

  /**
   * �×{�H���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationMedicalExpensesRadio(){

  }

  /**
   * �×{�H���Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationMedicalExpensesRadioModel(){

    getShortStayHospitalRecuperationMedicalExpensesRadioItem1().setButtonIndex(1);
    getShortStayHospitalRecuperationMedicalExpensesRadioModel().add(getShortStayHospitalRecuperationMedicalExpensesRadioItem1());

    getShortStayHospitalRecuperationMedicalExpensesRadioItem2().setButtonIndex(2);
    getShortStayHospitalRecuperationMedicalExpensesRadioModel().add(getShortStayHospitalRecuperationMedicalExpensesRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationMedicalExpensesRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationMedicalExpensesRadioItem2(){

  }

  /**
   * ����f�Ô�{�^���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationSpecificConsultationFee(){

  }

  /**
   * �ݒ胉�x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationSpecificConsultationFeeOutline(){

  }

  /**
   * �l�����Z�R���{�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationPersonSubtraction(){

  }

  /**
   * �l�����Z�R���{���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationPersonSubtractionModel(){

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
  protected void addShortStayHospitalRecuperationEtc30Over(){

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
      ACFrame.getInstance().getContentPane().add(new QS001013Design());
      ACFrame.getInstance().setVisible(true);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QS001013Design getThis() {
    return this;
  }
}
