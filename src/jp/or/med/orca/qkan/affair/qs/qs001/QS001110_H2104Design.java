
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
 * �J����: �c���@����
 * �쐬��: 2009/03/02  ���{�R���s���[�^�[������� �c���@���� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �T�[�r�X�\��쐬/�ύX (S)
 * �v���Z�X �T�[�r�X�\��T�� (001)
 * �v���O���� �T�[�r�X�p�^�[���Z�������×{���i���V�l�ی��{�݁j (QS001110_H2104)
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
 * �T�[�r�X�p�^�[���Z�������×{���i���V�l�ی��{�݁j��ʍ��ڃf�U�C��(QS001110_H2104) 
 */
public class QS001110_H2104Design extends QS001ServicePanel {
  //GUI�R���|�[�l���g

  private JTabbedPane tabs;

  private ACPanel tab1;

  private ACLabelContainer shortStayRecuperationHealthFacilityInstitutionDivisionContainar;

  private ACBackLabelContainer shortStayRecuperationHealthFacilityInstitutionDivisionBackLabel1Containar;

  private ACClearableRadioButtonGroup shortStayRecuperationHealthFacilityInstitutionDivisionRadio;

  private ACListModelAdapter shortStayRecuperationHealthFacilityInstitutionDivisionRadioModel;

  private ACRadioButtonItem shortStayRecuperationHealthFacilityInstitutionDivisionRadioItem1;

  private ACRadioButtonItem shortStayRecuperationHealthFacilityInstitutionDivisionRadioItem2;

  private ACRadioButtonItem shortStayRecuperationHealthFacilityInstitutionDivisionRadioItem3;

  private ACBackLabelContainer shortStayRecuperationHealthFacilityInstitutionDivisionBackLabel2;

  private ACValueArrayRadioButtonGroup shortStayRecuperationHealthFacilityDivision;

  private ACListModelAdapter shortStayRecuperationHealthFacilityDivisionModel;

  private ACRadioButtonItem shortStayRecuperationHealthFacilityDivisionType1;

  private ACRadioButtonItem shortStayRecuperationHealthFacilityDivisionType2;

  private ACRadioButtonItem shortStayRecuperationHealthFacilityDivisionType3;

  private ACLabelContainer shortStayRecuperationHealthFacilityHospitalRoomDivisionContena;

  private ACClearableRadioButtonGroup shortStayRecuperationHealthFacilityHospitalRoomDivisionRadio;

  private ACListModelAdapter shortStayRecuperationHealthFacilityHospitalRoomDivisionRadioModel;

  private ACRadioButtonItem shortStayRecuperationHealthFacilityHospitalRoomDivisionRadioItem1;

  private ACRadioButtonItem shortStayRecuperationHealthFacilityHospitalRoomDivisionRadioItem2;

  private ACClearableRadioButtonGroup shortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadio;

  private ACListModelAdapter shortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadioModel;

  private ACRadioButtonItem shortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadioItem1;

  private ACRadioButtonItem shortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadioItem2;

  private ACClearableRadioButtonGroup shortStayRecuperationHealthFacilitySickroomDivisionRadio;

  private ACLabelContainer shortStayRecuperationHealthFacilitySickroomDivisionRadioContainer;

  private ACListModelAdapter shortStayRecuperationHealthFacilitySickroomDivisionRadioModel;

  private ACRadioButtonItem shortStayRecuperationHealthFacilitySickroomDivisionRadioItem1;

  private ACRadioButtonItem shortStayRecuperationHealthFacilitySickroomDivisionRadioItem2;

  private ACRadioButtonItem shortStayRecuperationHealthFacilitySickroomDivisionRadioItem3;

  private ACRadioButtonItem shortStayRecuperationHealthFacilitySickroomDivisionRadioItem4;

  private ACComboBox tankinyusyoTimeDivision;

  private ACLabelContainer tankinyusyoTimeDivisionContainer;

  private ACComboBoxModelAdapter tankinyusyoTimeDivisionModel;

  private ACClearableRadioButtonGroup shortStayRecuperationHealthNightWorkConditionRadio;

  private ACLabelContainer shortStayRecuperationHealthNightWorkConditionRadioContainer;

  private ACListModelAdapter shortStayRecuperationHealthNightWorkConditionRadioModel;

  private ACRadioButtonItem shortStayRecuperationHealthNightWorkConditionRadioItem1;

  private ACRadioButtonItem shortStayRecuperationHealthNightWorkConditionRadioItem2;

  private ACValueArrayRadioButtonGroup nightStaffDispositionAddRadioGroup;

  private ACLabelContainer nightStaffDispositionAddRadioGroupContainer;

  private ACListModelAdapter nightStaffDispositionAddRadioGroupModel;

  private ACRadioButtonItem nightStaffDispositionAddRadioItem1;

  private ACRadioButtonItem nightStaffDispositionAddRadioItem2;

  private ACClearableRadioButtonGroup shortStayRecuperationHealthFacilityEtcRehabilitation;

  private ACLabelContainer shortStayRecuperationHealthFacilityEtcRehabilitationContainer;

  private ACListModelAdapter shortStayRecuperationHealthFacilityEtcRehabilitationModel;

  private ACRadioButtonItem shortStayRecuperationHealthFacilityEtcRehabilitationRadioItem2;

  private ACRadioButtonItem shortStayRecuperationHealthFacilityEtcRehabilitationRadioItem1;

  private ACValueArrayRadioButtonGroup houmonRehabilitationShortConcentrationAddRadio;

  private ACLabelContainer houmonRehabilitationShortConcentrationAddRadioContainer;

  private ACListModelAdapter houmonRehabilitationShortConcentrationAddRadioModel;

  private ACRadioButtonItem houmonRehabilitationShortConcentrationAddRadioItem1;

  private ACRadioButtonItem houmonRehabilitationShortConcentrationAddRadioItem2;

  private ACClearableRadioButtonGroup shortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadio;

  private ACLabelContainer shortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadioContainer;

  private ACListModelAdapter shortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadioModel;

  private ACRadioButtonItem shortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadioItem1;

  private ACRadioButtonItem shortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadioItem2;

  private ACPanel tab2;

  private ACValueArrayRadioButtonGroup dementiaActionAddRadioGroup;

  private ACLabelContainer dementiaActionAddRadioGroupContainer;

  private ACListModelAdapter dementiaActionAddRadioGroupModel;

  private ACRadioButtonItem dementiaActionAddRadioItem1;

  private ACRadioButtonItem dementiaActionAddRadioItem2;

  private ACValueArrayRadioButtonGroup youngDementiaPatinetAddRadioGroup;

  private ACLabelContainer youngDementiaPatinetAddRadioGroupContainer;

  private ACListModelAdapter youngDementiaPatinetAddRadioGroupModel;

  private ACRadioButtonItem youngDementiaPatinetAddRadioItem1;

  private ACRadioButtonItem youngDementiaPatinetAddRadioItem2;

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

  private ACClearableRadioButtonGroup shortStayRecuperationHealthFacilityDieticianMedicalExpensesRadio;

  private ACLabelContainer shortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioContainer;

  private ACListModelAdapter shortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioModel;

  private ACRadioButtonItem shortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioItem1;

  private ACRadioButtonItem shortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioItem2;

  private ACMapBindButton shortStayRecuperationHealthFacilitySpecialMedicalExpense;

  private ACLabel shortStayRecuperationHealthFacilitySpecialMedicalExpenseLabel;

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

  private ACPanel tab3;

  private ACClearableRadioButtonGroup shortStayRecuperationHealthUnitCareAddRadio;

  private ACLabelContainer shortStayRecuperationHealthUnitCareAddRadioContainer;

  private ACListModelAdapter shortStayRecuperationHealthUnitCareAddRadioModel;

  private ACRadioButtonItem shortStayRecuperationHealthUnitCareAddRadioItem1;

  private ACRadioButtonItem shortStayRecuperationHealthUnitCareAddRadioItem2;

  private ACClearableRadioButtonGroup shortStayRecuperationHealthFacilityRecuperationRadio;

  private ACLabelContainer shortStayRecuperationHealthFacilityRecuperationRadioContainer;

  private ACListModelAdapter shortStayRecuperationHealthFacilityRecuperationRadioModel;

  private ACRadioButtonItem shortStayRecuperationHealthFacilityRecuperationRadioItem1;

  private ACRadioButtonItem shortStayRecuperationHealthFacilityRecuperationRadioItem2;

  private ACClearableRadioButtonGroup shortStayRecuperationHealthEmergencyNetworkAddRadio;

  private ACLabelContainer shortStayRecuperationHealthEmergencyNetworkAddRadioContainer;

  private ACListModelAdapter shortStayRecuperationHealthEmergencyNetworkAddRadioModel;

  private ACRadioButtonItem shortStayRecuperationHealthEmergencyNetworkAddRadioItem1;

  private ACRadioButtonItem shortStayRecuperationHealthEmergencyNetworkAddRadioItem2;

  private ACValueArrayRadioButtonGroup serviceAddProvisionStructuralRadioGroup;

  private ACLabelContainer serviceAddProvisionStructuralRadioGroupContainer;

  private ACListModelAdapter serviceAddProvisionStructuralRadioGroupModel;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem1;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem2;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem3;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem4;

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
  public ACLabelContainer getShortStayRecuperationHealthFacilityInstitutionDivisionContainar(){
    if(shortStayRecuperationHealthFacilityInstitutionDivisionContainar==null){

      shortStayRecuperationHealthFacilityInstitutionDivisionContainar = new ACLabelContainer();

      shortStayRecuperationHealthFacilityInstitutionDivisionContainar.setText("�{�ݓ��̋敪");

      shortStayRecuperationHealthFacilityInstitutionDivisionContainar.setAutoWrap(true);

      shortStayRecuperationHealthFacilityInstitutionDivisionContainar.setHgap(0);

      shortStayRecuperationHealthFacilityInstitutionDivisionContainar.setLabelMargin(0);

      shortStayRecuperationHealthFacilityInstitutionDivisionContainar.setVgap(0);

      addShortStayRecuperationHealthFacilityInstitutionDivisionContainar();
    }
    return shortStayRecuperationHealthFacilityInstitutionDivisionContainar;

  }

  /**
   * �w�ʃ��x���R���e�i�i�{�݋敪�j���擾���܂��B
   * @return �w�ʃ��x���R���e�i�i�{�݋敪�j
   */
  public ACBackLabelContainer getShortStayRecuperationHealthFacilityInstitutionDivisionBackLabel1Containar(){
    if(shortStayRecuperationHealthFacilityInstitutionDivisionBackLabel1Containar==null){

      shortStayRecuperationHealthFacilityInstitutionDivisionBackLabel1Containar = new ACBackLabelContainer();

      shortStayRecuperationHealthFacilityInstitutionDivisionBackLabel1Containar.setAutoWrap(false);

      shortStayRecuperationHealthFacilityInstitutionDivisionBackLabel1Containar.setFollowChildEnabled(true);

      shortStayRecuperationHealthFacilityInstitutionDivisionBackLabel1Containar.setHgap(0);

      shortStayRecuperationHealthFacilityInstitutionDivisionBackLabel1Containar.setLabelMargin(0);

      shortStayRecuperationHealthFacilityInstitutionDivisionBackLabel1Containar.setVgap(0);

      addShortStayRecuperationHealthFacilityInstitutionDivisionBackLabel1Containar();
    }
    return shortStayRecuperationHealthFacilityInstitutionDivisionBackLabel1Containar;

  }

  /**
   * �{�ݓ��̋敪���擾���܂��B
   * @return �{�ݓ��̋敪
   */
  public ACClearableRadioButtonGroup getShortStayRecuperationHealthFacilityInstitutionDivisionRadio(){
    if(shortStayRecuperationHealthFacilityInstitutionDivisionRadio==null){

      shortStayRecuperationHealthFacilityInstitutionDivisionRadio = new ACClearableRadioButtonGroup();

      shortStayRecuperationHealthFacilityInstitutionDivisionRadio.setBindPath("1220101");

      shortStayRecuperationHealthFacilityInstitutionDivisionRadio.setUseClearButton(false);

      shortStayRecuperationHealthFacilityInstitutionDivisionRadio.setModel(getShortStayRecuperationHealthFacilityInstitutionDivisionRadioModel());

      addShortStayRecuperationHealthFacilityInstitutionDivisionRadio();
    }
    return shortStayRecuperationHealthFacilityInstitutionDivisionRadio;

  }

  /**
   * �{�ݓ��̋敪���f�����擾���܂��B
   * @return �{�ݓ��̋敪���f��
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

      shortStayRecuperationHealthFacilityInstitutionDivisionRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

      addShortStayRecuperationHealthFacilityInstitutionDivisionRadioItem2();
    }
    return shortStayRecuperationHealthFacilityInstitutionDivisionRadioItem2;

  }

  /**
   * ���A��V���[�g�X�e�C���擾���܂��B
   * @return ���A��V���[�g�X�e�C
   */
  public ACRadioButtonItem getShortStayRecuperationHealthFacilityInstitutionDivisionRadioItem3(){
    if(shortStayRecuperationHealthFacilityInstitutionDivisionRadioItem3==null){

      shortStayRecuperationHealthFacilityInstitutionDivisionRadioItem3 = new ACRadioButtonItem();

      shortStayRecuperationHealthFacilityInstitutionDivisionRadioItem3.setText("���A��V���[�g�X�e�C");

      shortStayRecuperationHealthFacilityInstitutionDivisionRadioItem3.setGroup(getShortStayRecuperationHealthFacilityInstitutionDivisionRadio());

      shortStayRecuperationHealthFacilityInstitutionDivisionRadioItem3.setConstraints(VRLayout.FLOW);

      addShortStayRecuperationHealthFacilityInstitutionDivisionRadioItem3();
    }
    return shortStayRecuperationHealthFacilityInstitutionDivisionRadioItem3;

  }

  /**
   * �w�ʃ��x���R���e�i�i�̐��j���擾���܂��B
   * @return �w�ʃ��x���R���e�i�i�̐��j
   */
  public ACBackLabelContainer getShortStayRecuperationHealthFacilityInstitutionDivisionBackLabel2(){
    if(shortStayRecuperationHealthFacilityInstitutionDivisionBackLabel2==null){

      shortStayRecuperationHealthFacilityInstitutionDivisionBackLabel2 = new ACBackLabelContainer();

      shortStayRecuperationHealthFacilityInstitutionDivisionBackLabel2.setAutoWrap(false);

      shortStayRecuperationHealthFacilityInstitutionDivisionBackLabel2.setFollowChildEnabled(true);

      shortStayRecuperationHealthFacilityInstitutionDivisionBackLabel2.setHgap(0);

      shortStayRecuperationHealthFacilityInstitutionDivisionBackLabel2.setLabelMargin(0);

      shortStayRecuperationHealthFacilityInstitutionDivisionBackLabel2.setVgap(0);

      addShortStayRecuperationHealthFacilityInstitutionDivisionBackLabel2();
    }
    return shortStayRecuperationHealthFacilityInstitutionDivisionBackLabel2;

  }

  /**
   * �̐����擾���܂��B
   * @return �̐�
   */
  public ACValueArrayRadioButtonGroup getShortStayRecuperationHealthFacilityDivision(){
    if(shortStayRecuperationHealthFacilityDivision==null){

      shortStayRecuperationHealthFacilityDivision = new ACValueArrayRadioButtonGroup();

      shortStayRecuperationHealthFacilityDivision.setBindPath("1220120");

      shortStayRecuperationHealthFacilityDivision.setNoSelectIndex(0);

      shortStayRecuperationHealthFacilityDivision.setUseClearButton(false);

      shortStayRecuperationHealthFacilityDivision.setModel(getShortStayRecuperationHealthFacilityDivisionModel());

      shortStayRecuperationHealthFacilityDivision.setValues(new int[]{1,2,3});

      addShortStayRecuperationHealthFacilityDivision();
    }
    return shortStayRecuperationHealthFacilityDivision;

  }

  /**
   * �̐����f�����擾���܂��B
   * @return �̐����f��
   */
  protected ACListModelAdapter getShortStayRecuperationHealthFacilityDivisionModel(){
    if(shortStayRecuperationHealthFacilityDivisionModel==null){
      shortStayRecuperationHealthFacilityDivisionModel = new ACListModelAdapter();
      addShortStayRecuperationHealthFacilityDivisionModel();
    }
    return shortStayRecuperationHealthFacilityDivisionModel;
  }

  /**
   * I�^���擾���܂��B
   * @return I�^
   */
  public ACRadioButtonItem getShortStayRecuperationHealthFacilityDivisionType1(){
    if(shortStayRecuperationHealthFacilityDivisionType1==null){

      shortStayRecuperationHealthFacilityDivisionType1 = new ACRadioButtonItem();

      shortStayRecuperationHealthFacilityDivisionType1.setText("I�^");

      shortStayRecuperationHealthFacilityDivisionType1.setGroup(getShortStayRecuperationHealthFacilityDivision());

      shortStayRecuperationHealthFacilityDivisionType1.setConstraints(VRLayout.FLOW);

      addShortStayRecuperationHealthFacilityDivisionType1();
    }
    return shortStayRecuperationHealthFacilityDivisionType1;

  }

  /**
   * II�^���擾���܂��B
   * @return II�^
   */
  public ACRadioButtonItem getShortStayRecuperationHealthFacilityDivisionType2(){
    if(shortStayRecuperationHealthFacilityDivisionType2==null){

      shortStayRecuperationHealthFacilityDivisionType2 = new ACRadioButtonItem();

      shortStayRecuperationHealthFacilityDivisionType2.setText("II�^");

      shortStayRecuperationHealthFacilityDivisionType2.setGroup(getShortStayRecuperationHealthFacilityDivision());

      shortStayRecuperationHealthFacilityDivisionType2.setConstraints(VRLayout.FLOW);

      addShortStayRecuperationHealthFacilityDivisionType2();
    }
    return shortStayRecuperationHealthFacilityDivisionType2;

  }

  /**
   * III�^���擾���܂��B
   * @return III�^
   */
  public ACRadioButtonItem getShortStayRecuperationHealthFacilityDivisionType3(){
    if(shortStayRecuperationHealthFacilityDivisionType3==null){

      shortStayRecuperationHealthFacilityDivisionType3 = new ACRadioButtonItem();

      shortStayRecuperationHealthFacilityDivisionType3.setText("III�^");

      shortStayRecuperationHealthFacilityDivisionType3.setGroup(getShortStayRecuperationHealthFacilityDivision());

      shortStayRecuperationHealthFacilityDivisionType3.setConstraints(VRLayout.FLOW);

      addShortStayRecuperationHealthFacilityDivisionType3();
    }
    return shortStayRecuperationHealthFacilityDivisionType3;

  }

  /**
   * �a���敪�R���e�i���擾���܂��B
   * @return �a���敪�R���e�i
   */
  public ACLabelContainer getShortStayRecuperationHealthFacilityHospitalRoomDivisionContena(){
    if(shortStayRecuperationHealthFacilityHospitalRoomDivisionContena==null){

      shortStayRecuperationHealthFacilityHospitalRoomDivisionContena = new ACLabelContainer();

      shortStayRecuperationHealthFacilityHospitalRoomDivisionContena.setText("�a���敪");

      shortStayRecuperationHealthFacilityHospitalRoomDivisionContena.setFollowChildEnabled(true);

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

      shortStayRecuperationHealthFacilityHospitalRoomDivisionRadio.setUseClearButton(false);

      shortStayRecuperationHealthFacilityHospitalRoomDivisionRadio.setModel(getShortStayRecuperationHealthFacilityHospitalRoomDivisionRadioModel());

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

      shortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadio.setUseClearButton(false);

      shortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadio.setModel(getShortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadioModel());

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
   * �a���敪���W�I���擾���܂��B
   * @return �a���敪���W�I
   */
  public ACClearableRadioButtonGroup getShortStayRecuperationHealthFacilitySickroomDivisionRadio(){
    if(shortStayRecuperationHealthFacilitySickroomDivisionRadio==null){

      shortStayRecuperationHealthFacilitySickroomDivisionRadio = new ACClearableRadioButtonGroup();

      getShortStayRecuperationHealthFacilitySickroomDivisionRadioContainer().setText("�a���敪");

      shortStayRecuperationHealthFacilitySickroomDivisionRadio.setBindPath("1220119");

      shortStayRecuperationHealthFacilitySickroomDivisionRadio.setUseClearButton(false);

      shortStayRecuperationHealthFacilitySickroomDivisionRadio.setModel(getShortStayRecuperationHealthFacilitySickroomDivisionRadioModel());

      addShortStayRecuperationHealthFacilitySickroomDivisionRadio();
    }
    return shortStayRecuperationHealthFacilitySickroomDivisionRadio;

  }

  /**
   * �a���敪���W�I�R���e�i���擾���܂��B
   * @return �a���敪���W�I�R���e�i
   */
  protected ACLabelContainer getShortStayRecuperationHealthFacilitySickroomDivisionRadioContainer(){
    if(shortStayRecuperationHealthFacilitySickroomDivisionRadioContainer==null){
      shortStayRecuperationHealthFacilitySickroomDivisionRadioContainer = new ACLabelContainer();
      shortStayRecuperationHealthFacilitySickroomDivisionRadioContainer.setFollowChildEnabled(true);
      shortStayRecuperationHealthFacilitySickroomDivisionRadioContainer.setVAlignment(VRLayout.CENTER);
      shortStayRecuperationHealthFacilitySickroomDivisionRadioContainer.add(getShortStayRecuperationHealthFacilitySickroomDivisionRadio(), null);
    }
    return shortStayRecuperationHealthFacilitySickroomDivisionRadioContainer;
  }

  /**
   * �a���敪���W�I���f�����擾���܂��B
   * @return �a���敪���W�I���f��
   */
  protected ACListModelAdapter getShortStayRecuperationHealthFacilitySickroomDivisionRadioModel(){
    if(shortStayRecuperationHealthFacilitySickroomDivisionRadioModel==null){
      shortStayRecuperationHealthFacilitySickroomDivisionRadioModel = new ACListModelAdapter();
      addShortStayRecuperationHealthFacilitySickroomDivisionRadioModel();
    }
    return shortStayRecuperationHealthFacilitySickroomDivisionRadioModel;
  }

  /**
   * �]���^�����擾���܂��B
   * @return �]���^��
   */
  public ACRadioButtonItem getShortStayRecuperationHealthFacilitySickroomDivisionRadioItem1(){
    if(shortStayRecuperationHealthFacilitySickroomDivisionRadioItem1==null){

      shortStayRecuperationHealthFacilitySickroomDivisionRadioItem1 = new ACRadioButtonItem();

      shortStayRecuperationHealthFacilitySickroomDivisionRadioItem1.setText("�]���^��");

      shortStayRecuperationHealthFacilitySickroomDivisionRadioItem1.setGroup(getShortStayRecuperationHealthFacilitySickroomDivisionRadio());

      shortStayRecuperationHealthFacilitySickroomDivisionRadioItem1.setConstraints(VRLayout.FLOW);

      addShortStayRecuperationHealthFacilitySickroomDivisionRadioItem1();
    }
    return shortStayRecuperationHealthFacilitySickroomDivisionRadioItem1;

  }

  /**
   * ���������擾���܂��B
   * @return ������
   */
  public ACRadioButtonItem getShortStayRecuperationHealthFacilitySickroomDivisionRadioItem2(){
    if(shortStayRecuperationHealthFacilitySickroomDivisionRadioItem2==null){

      shortStayRecuperationHealthFacilitySickroomDivisionRadioItem2 = new ACRadioButtonItem();

      shortStayRecuperationHealthFacilitySickroomDivisionRadioItem2.setText("������");

      shortStayRecuperationHealthFacilitySickroomDivisionRadioItem2.setGroup(getShortStayRecuperationHealthFacilitySickroomDivisionRadio());

      shortStayRecuperationHealthFacilitySickroomDivisionRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

      addShortStayRecuperationHealthFacilitySickroomDivisionRadioItem2();
    }
    return shortStayRecuperationHealthFacilitySickroomDivisionRadioItem2;

  }

  /**
   * ���j�b�g�^�����擾���܂��B
   * @return ���j�b�g�^��
   */
  public ACRadioButtonItem getShortStayRecuperationHealthFacilitySickroomDivisionRadioItem3(){
    if(shortStayRecuperationHealthFacilitySickroomDivisionRadioItem3==null){

      shortStayRecuperationHealthFacilitySickroomDivisionRadioItem3 = new ACRadioButtonItem();

      shortStayRecuperationHealthFacilitySickroomDivisionRadioItem3.setText("���j�b�g�^��");

      shortStayRecuperationHealthFacilitySickroomDivisionRadioItem3.setGroup(getShortStayRecuperationHealthFacilitySickroomDivisionRadio());

      shortStayRecuperationHealthFacilitySickroomDivisionRadioItem3.setConstraints(VRLayout.FLOW);

      addShortStayRecuperationHealthFacilitySickroomDivisionRadioItem3();
    }
    return shortStayRecuperationHealthFacilitySickroomDivisionRadioItem3;

  }

  /**
   * ���j�b�g�^�������擾���܂��B
   * @return ���j�b�g�^����
   */
  public ACRadioButtonItem getShortStayRecuperationHealthFacilitySickroomDivisionRadioItem4(){
    if(shortStayRecuperationHealthFacilitySickroomDivisionRadioItem4==null){

      shortStayRecuperationHealthFacilitySickroomDivisionRadioItem4 = new ACRadioButtonItem();

      shortStayRecuperationHealthFacilitySickroomDivisionRadioItem4.setText("���j�b�g�^����");

      shortStayRecuperationHealthFacilitySickroomDivisionRadioItem4.setGroup(getShortStayRecuperationHealthFacilitySickroomDivisionRadio());

      shortStayRecuperationHealthFacilitySickroomDivisionRadioItem4.setConstraints(VRLayout.FLOW);

      addShortStayRecuperationHealthFacilitySickroomDivisionRadioItem4();
    }
    return shortStayRecuperationHealthFacilitySickroomDivisionRadioItem4;

  }

  /**
   * ���ԋ敪���擾���܂��B
   * @return ���ԋ敪
   */
  public ACComboBox getTankinyusyoTimeDivision(){
    if(tankinyusyoTimeDivision==null){

      tankinyusyoTimeDivision = new ACComboBox();

      getTankinyusyoTimeDivisionContainer().setText("���ԋ敪");

      tankinyusyoTimeDivision.setBindPath("1220125");

      tankinyusyoTimeDivision.setEditable(false);

      tankinyusyoTimeDivision.setModelBindPath("1220125");

      tankinyusyoTimeDivision.setRenderBindPath("CONTENT");

      tankinyusyoTimeDivision.setModel(getTankinyusyoTimeDivisionModel());

      addTankinyusyoTimeDivision();
    }
    return tankinyusyoTimeDivision;

  }

  /**
   * ���ԋ敪�R���e�i���擾���܂��B
   * @return ���ԋ敪�R���e�i
   */
  protected ACLabelContainer getTankinyusyoTimeDivisionContainer(){
    if(tankinyusyoTimeDivisionContainer==null){
      tankinyusyoTimeDivisionContainer = new ACLabelContainer();
      tankinyusyoTimeDivisionContainer.setFollowChildEnabled(true);
      tankinyusyoTimeDivisionContainer.setVAlignment(VRLayout.CENTER);
      tankinyusyoTimeDivisionContainer.add(getTankinyusyoTimeDivision(), null);
    }
    return tankinyusyoTimeDivisionContainer;
  }

  /**
   * ���ԋ敪���f�����擾���܂��B
   * @return ���ԋ敪���f��
   */
  protected ACComboBoxModelAdapter getTankinyusyoTimeDivisionModel(){
    if(tankinyusyoTimeDivisionModel==null){
      tankinyusyoTimeDivisionModel = new ACComboBoxModelAdapter();
      addTankinyusyoTimeDivisionModel();
    }
    return tankinyusyoTimeDivisionModel;
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

      shortStayRecuperationHealthNightWorkConditionRadio.setUseClearButton(false);

      shortStayRecuperationHealthNightWorkConditionRadio.setModel(getShortStayRecuperationHealthNightWorkConditionRadioModel());

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
      shortStayRecuperationHealthNightWorkConditionRadioContainer.setVAlignment(VRLayout.CENTER);
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
   * ��ΐE���z�u���Z���擾���܂��B
   * @return ��ΐE���z�u���Z
   */
  public ACValueArrayRadioButtonGroup getNightStaffDispositionAddRadioGroup(){
    if(nightStaffDispositionAddRadioGroup==null){

      nightStaffDispositionAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getNightStaffDispositionAddRadioGroupContainer().setText("��ΐE���z�u���Z");

      nightStaffDispositionAddRadioGroup.setBindPath("1220122");

      nightStaffDispositionAddRadioGroup.setNoSelectIndex(0);

      nightStaffDispositionAddRadioGroup.setUseClearButton(false);

      nightStaffDispositionAddRadioGroup.setModel(getNightStaffDispositionAddRadioGroupModel());

      nightStaffDispositionAddRadioGroup.setValues(new int[]{1,2});

      addNightStaffDispositionAddRadioGroup();
    }
    return nightStaffDispositionAddRadioGroup;

  }

  /**
   * ��ΐE���z�u���Z�R���e�i���擾���܂��B
   * @return ��ΐE���z�u���Z�R���e�i
   */
  protected ACLabelContainer getNightStaffDispositionAddRadioGroupContainer(){
    if(nightStaffDispositionAddRadioGroupContainer==null){
      nightStaffDispositionAddRadioGroupContainer = new ACLabelContainer();
      nightStaffDispositionAddRadioGroupContainer.setFollowChildEnabled(true);
      nightStaffDispositionAddRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      nightStaffDispositionAddRadioGroupContainer.add(getNightStaffDispositionAddRadioGroup(), null);
    }
    return nightStaffDispositionAddRadioGroupContainer;
  }

  /**
   * ��ΐE���z�u���Z���f�����擾���܂��B
   * @return ��ΐE���z�u���Z���f��
   */
  protected ACListModelAdapter getNightStaffDispositionAddRadioGroupModel(){
    if(nightStaffDispositionAddRadioGroupModel==null){
      nightStaffDispositionAddRadioGroupModel = new ACListModelAdapter();
      addNightStaffDispositionAddRadioGroupModel();
    }
    return nightStaffDispositionAddRadioGroupModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getNightStaffDispositionAddRadioItem1(){
    if(nightStaffDispositionAddRadioItem1==null){

      nightStaffDispositionAddRadioItem1 = new ACRadioButtonItem();

      nightStaffDispositionAddRadioItem1.setText("�Ȃ�");

      nightStaffDispositionAddRadioItem1.setGroup(getNightStaffDispositionAddRadioGroup());

      nightStaffDispositionAddRadioItem1.setConstraints(VRLayout.FLOW);

      addNightStaffDispositionAddRadioItem1();
    }
    return nightStaffDispositionAddRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getNightStaffDispositionAddRadioItem2(){
    if(nightStaffDispositionAddRadioItem2==null){

      nightStaffDispositionAddRadioItem2 = new ACRadioButtonItem();

      nightStaffDispositionAddRadioItem2.setText("����");

      nightStaffDispositionAddRadioItem2.setGroup(getNightStaffDispositionAddRadioGroup());

      nightStaffDispositionAddRadioItem2.setConstraints(VRLayout.FLOW);

      addNightStaffDispositionAddRadioItem2();
    }
    return nightStaffDispositionAddRadioItem2;

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

      shortStayRecuperationHealthFacilityEtcRehabilitation.setUseClearButton(false);

      shortStayRecuperationHealthFacilityEtcRehabilitation.setModel(getShortStayRecuperationHealthFacilityEtcRehabilitationModel());

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
      shortStayRecuperationHealthFacilityEtcRehabilitationContainer.setVAlignment(VRLayout.CENTER);
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
   * �ʃ��n�r�����{���Z���擾���܂��B
   * @return �ʃ��n�r�����{���Z
   */
  public ACValueArrayRadioButtonGroup getHoumonRehabilitationShortConcentrationAddRadio(){
    if(houmonRehabilitationShortConcentrationAddRadio==null){

      houmonRehabilitationShortConcentrationAddRadio = new ACValueArrayRadioButtonGroup();

      getHoumonRehabilitationShortConcentrationAddRadioContainer().setText("�ʃ��n�r�����{���Z");

      houmonRehabilitationShortConcentrationAddRadio.setBindPath("1220126");

      houmonRehabilitationShortConcentrationAddRadio.setNoSelectIndex(0);

      houmonRehabilitationShortConcentrationAddRadio.setUseClearButton(false);

      houmonRehabilitationShortConcentrationAddRadio.setModel(getHoumonRehabilitationShortConcentrationAddRadioModel());

      houmonRehabilitationShortConcentrationAddRadio.setValues(new int[]{1,2});

      addHoumonRehabilitationShortConcentrationAddRadio();
    }
    return houmonRehabilitationShortConcentrationAddRadio;

  }

  /**
   * �ʃ��n�r�����{���Z�R���e�i���擾���܂��B
   * @return �ʃ��n�r�����{���Z�R���e�i
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
   * �ʃ��n�r�����{���Z���f�����擾���܂��B
   * @return �ʃ��n�r�����{���Z���f��
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
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getHoumonRehabilitationShortConcentrationAddRadioItem2(){
    if(houmonRehabilitationShortConcentrationAddRadioItem2==null){

      houmonRehabilitationShortConcentrationAddRadioItem2 = new ACRadioButtonItem();

      houmonRehabilitationShortConcentrationAddRadioItem2.setText("����");

      houmonRehabilitationShortConcentrationAddRadioItem2.setGroup(getHoumonRehabilitationShortConcentrationAddRadio());

      houmonRehabilitationShortConcentrationAddRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

      addHoumonRehabilitationShortConcentrationAddRadioItem2();
    }
    return houmonRehabilitationShortConcentrationAddRadioItem2;

  }

  /**
   * �F�m�ǃP�A���Z���擾���܂��B
   * @return �F�m�ǃP�A���Z
   */
  public ACClearableRadioButtonGroup getShortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadio(){
    if(shortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadio==null){

      shortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadio = new ACClearableRadioButtonGroup();

      getShortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadioContainer().setText("�F�m�ǃP�A���Z");

      shortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadio.setBindPath("1220116");

      shortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadio.setUseClearButton(false);

      shortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadio.setModel(getShortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadioModel());

      addShortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadio();
    }
    return shortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadio;

  }

  /**
   * �F�m�ǃP�A���Z�R���e�i���擾���܂��B
   * @return �F�m�ǃP�A���Z�R���e�i
   */
  protected ACLabelContainer getShortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadioContainer(){
    if(shortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadioContainer==null){
      shortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadioContainer = new ACLabelContainer();
      shortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadioContainer.setFollowChildEnabled(true);
      shortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadioContainer.setVAlignment(VRLayout.CENTER);
      shortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadioContainer.add(getShortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadio(), null);
    }
    return shortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadioContainer;
  }

  /**
   * �F�m�ǃP�A���Z���f�����擾���܂��B
   * @return �F�m�ǃP�A���Z���f��
   */
  protected ACListModelAdapter getShortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadioModel(){
    if(shortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadioModel==null){
      shortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadioModel = new ACListModelAdapter();
      addShortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadioModel();
    }
    return shortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getShortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadioItem1(){
    if(shortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadioItem1==null){

      shortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadioItem1 = new ACRadioButtonItem();

      shortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadioItem1.setText("�Ȃ�");

      shortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadioItem1.setGroup(getShortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadio());

      shortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadioItem1.setConstraints(VRLayout.FLOW);

      addShortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadioItem1();
    }
    return shortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getShortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadioItem2(){
    if(shortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadioItem2==null){

      shortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadioItem2 = new ACRadioButtonItem();

      shortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadioItem2.setText("����");

      shortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadioItem2.setGroup(getShortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadio());

      shortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadioItem2.setConstraints(VRLayout.FLOW);

      addShortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadioItem2();
    }
    return shortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadioItem2;

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
   * �F�m�Ǎs���E�S���Ǐ�ً}�Ή����Z���擾���܂��B
   * @return �F�m�Ǎs���E�S���Ǐ�ً}�Ή����Z
   */
  public ACValueArrayRadioButtonGroup getDementiaActionAddRadioGroup(){
    if(dementiaActionAddRadioGroup==null){

      dementiaActionAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getDementiaActionAddRadioGroupContainer().setText("�F�m�Ǎs���E" + ACConstants.LINE_SEPARATOR + "�S���Ǐ�ً}�Ή����Z");

      dementiaActionAddRadioGroup.setBindPath("1220127");

      dementiaActionAddRadioGroup.setNoSelectIndex(0);

      dementiaActionAddRadioGroup.setUseClearButton(false);

      dementiaActionAddRadioGroup.setModel(getDementiaActionAddRadioGroupModel());

      dementiaActionAddRadioGroup.setValues(new int[]{1,2});

      addDementiaActionAddRadioGroup();
    }
    return dementiaActionAddRadioGroup;

  }

  /**
   * �F�m�Ǎs���E�S���Ǐ�ً}�Ή����Z�R���e�i���擾���܂��B
   * @return �F�m�Ǎs���E�S���Ǐ�ً}�Ή����Z�R���e�i
   */
  protected ACLabelContainer getDementiaActionAddRadioGroupContainer(){
    if(dementiaActionAddRadioGroupContainer==null){
      dementiaActionAddRadioGroupContainer = new ACLabelContainer();
      dementiaActionAddRadioGroupContainer.setFollowChildEnabled(true);
      dementiaActionAddRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      dementiaActionAddRadioGroupContainer.add(getDementiaActionAddRadioGroup(), null);
    }
    return dementiaActionAddRadioGroupContainer;
  }

  /**
   * �F�m�Ǎs���E�S���Ǐ�ً}�Ή����Z���f�����擾���܂��B
   * @return �F�m�Ǎs���E�S���Ǐ�ً}�Ή����Z���f��
   */
  protected ACListModelAdapter getDementiaActionAddRadioGroupModel(){
    if(dementiaActionAddRadioGroupModel==null){
      dementiaActionAddRadioGroupModel = new ACListModelAdapter();
      addDementiaActionAddRadioGroupModel();
    }
    return dementiaActionAddRadioGroupModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getDementiaActionAddRadioItem1(){
    if(dementiaActionAddRadioItem1==null){

      dementiaActionAddRadioItem1 = new ACRadioButtonItem();

      dementiaActionAddRadioItem1.setText("�Ȃ�");

      dementiaActionAddRadioItem1.setGroup(getDementiaActionAddRadioGroup());

      dementiaActionAddRadioItem1.setConstraints(VRLayout.FLOW);

      addDementiaActionAddRadioItem1();
    }
    return dementiaActionAddRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getDementiaActionAddRadioItem2(){
    if(dementiaActionAddRadioItem2==null){

      dementiaActionAddRadioItem2 = new ACRadioButtonItem();

      dementiaActionAddRadioItem2.setText("����");

      dementiaActionAddRadioItem2.setGroup(getDementiaActionAddRadioGroup());

      dementiaActionAddRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

      addDementiaActionAddRadioItem2();
    }
    return dementiaActionAddRadioItem2;

  }

  /**
   * ��N���F�m�Ǘ��p�Ҏ�����Z���擾���܂��B
   * @return ��N���F�m�Ǘ��p�Ҏ�����Z
   */
  public ACValueArrayRadioButtonGroup getYoungDementiaPatinetAddRadioGroup(){
    if(youngDementiaPatinetAddRadioGroup==null){

      youngDementiaPatinetAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getYoungDementiaPatinetAddRadioGroupContainer().setText("��N���F�m�Ǘ��p�Ҏ�����Z");

      youngDementiaPatinetAddRadioGroup.setBindPath("1220123");

      youngDementiaPatinetAddRadioGroup.setNoSelectIndex(0);

      youngDementiaPatinetAddRadioGroup.setUseClearButton(false);

      youngDementiaPatinetAddRadioGroup.setModel(getYoungDementiaPatinetAddRadioGroupModel());

      youngDementiaPatinetAddRadioGroup.setValues(new int[]{1,2});

      addYoungDementiaPatinetAddRadioGroup();
    }
    return youngDementiaPatinetAddRadioGroup;

  }

  /**
   * ��N���F�m�Ǘ��p�Ҏ�����Z�R���e�i���擾���܂��B
   * @return ��N���F�m�Ǘ��p�Ҏ�����Z�R���e�i
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
   * ��N���F�m�Ǘ��p�Ҏ�����Z���f�����擾���܂��B
   * @return ��N���F�m�Ǘ��p�Ҏ�����Z���f��
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
   * ���}�敪���擾���܂��B
   * @return ���}�敪
   */
  public ACClearableRadioButtonGroup getShortStayRecuperationHealthFacilityMeetingAndSendingOff(){
    if(shortStayRecuperationHealthFacilityMeetingAndSendingOff==null){

      shortStayRecuperationHealthFacilityMeetingAndSendingOff = new ACClearableRadioButtonGroup();

      getShortStayRecuperationHealthFacilityMeetingAndSendingOffContainer().setText("���}���Z");

      shortStayRecuperationHealthFacilityMeetingAndSendingOff.setBindPath("6");

      shortStayRecuperationHealthFacilityMeetingAndSendingOff.setUseClearButton(false);

      shortStayRecuperationHealthFacilityMeetingAndSendingOff.setModel(getShortStayRecuperationHealthFacilityMeetingAndSendingOffModel());

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
      shortStayRecuperationHealthFacilityMeetingAndSendingOffContainer.setVAlignment(VRLayout.CENTER);
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

      shortStayRecuperationHealthFacilityUrgentTimeStepRadio.setUseClearButton(false);

      shortStayRecuperationHealthFacilityUrgentTimeStepRadio.setModel(getShortStayRecuperationHealthFacilityUrgentTimeStepRadioModel());

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
      shortStayRecuperationHealthFacilityUrgentTimeStepRadioContainer.setVAlignment(VRLayout.CENTER);
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
   * �×{�H���Z���擾���܂��B
   * @return �×{�H���Z
   */
  public ACClearableRadioButtonGroup getShortStayRecuperationHealthFacilityDieticianMedicalExpensesRadio(){
    if(shortStayRecuperationHealthFacilityDieticianMedicalExpensesRadio==null){

      shortStayRecuperationHealthFacilityDieticianMedicalExpensesRadio = new ACClearableRadioButtonGroup();

      getShortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioContainer().setText("�×{�H���Z");

      shortStayRecuperationHealthFacilityDieticianMedicalExpensesRadio.setBindPath("1220110");

      shortStayRecuperationHealthFacilityDieticianMedicalExpensesRadio.setUseClearButton(false);

      shortStayRecuperationHealthFacilityDieticianMedicalExpensesRadio.setModel(getShortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioModel());

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
      shortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioContainer.setVAlignment(VRLayout.CENTER);
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
   * ���ʗ×{����擾���܂��B
   * @return ���ʗ×{��
   */
  public ACMapBindButton getShortStayRecuperationHealthFacilitySpecialMedicalExpense(){
    if(shortStayRecuperationHealthFacilitySpecialMedicalExpense==null){

      shortStayRecuperationHealthFacilitySpecialMedicalExpense = new ACMapBindButton();

      shortStayRecuperationHealthFacilitySpecialMedicalExpense.setText("���ʗ×{��");

      shortStayRecuperationHealthFacilitySpecialMedicalExpense.setToolTipText("���ʗ×{���ݒ肵�܂��B");

      addShortStayRecuperationHealthFacilitySpecialMedicalExpense();
    }
    return shortStayRecuperationHealthFacilitySpecialMedicalExpense;

  }

  /**
   * ���x�����擾���܂��B
   * @return ���x��
   */
  public ACLabel getShortStayRecuperationHealthFacilitySpecialMedicalExpenseLabel(){
    if(shortStayRecuperationHealthFacilitySpecialMedicalExpenseLabel==null){

      shortStayRecuperationHealthFacilitySpecialMedicalExpenseLabel = new ACLabel();

      shortStayRecuperationHealthFacilitySpecialMedicalExpenseLabel.setText("�ݒ�Ȃ�");

      shortStayRecuperationHealthFacilitySpecialMedicalExpenseLabel.setOpaque(true);
      shortStayRecuperationHealthFacilitySpecialMedicalExpenseLabel.setBackground(new Color(255,255,172));

      addShortStayRecuperationHealthFacilitySpecialMedicalExpenseLabel();
    }
    return shortStayRecuperationHealthFacilitySpecialMedicalExpenseLabel;

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

      shortStayRecuperationHealthFacilityPersonSubtraction.setUseClearButton(false);

      shortStayRecuperationHealthFacilityPersonSubtraction.setModel(getShortStayRecuperationHealthFacilityPersonSubtractionModel());

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
      shortStayRecuperationHealthFacilityPersonSubtractionContainer.setVAlignment(VRLayout.CENTER);
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
   * �Ō�E���E�����͈�t�APT�EOT�EST�̕s�����擾���܂��B
   * @return �Ō�E���E�����͈�t�APT�EOT�EST�̕s��
   */
  public ACRadioButtonItem getShortStayRecuperationHealthFacilityPersonSubtractionStaffLack(){
    if(shortStayRecuperationHealthFacilityPersonSubtractionStaffLack==null){

      shortStayRecuperationHealthFacilityPersonSubtractionStaffLack = new ACRadioButtonItem();

      shortStayRecuperationHealthFacilityPersonSubtractionStaffLack.setText("<html>�Ō�E���E�����͈�t�A<br>PT�EOT�EST�̕s��</html>");

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

      shortStayRecuperationHealthFacilityDinnerOffer.setRenderBindPath("CONTENT");

      shortStayRecuperationHealthFacilityDinnerOffer.setModel(getShortStayRecuperationHealthFacilityDinnerOfferModel());

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
      shortStayRecuperationHealthFacilityDinnerOfferContainer.setVAlignment(VRLayout.CENTER);
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
      shortStayRecuperationHealthFacilityDinnerCostContainer.setVAlignment(VRLayout.CENTER);
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

      shortStayRecuperationHealthFacilityEtc30Over.setSelectValue(2);

      shortStayRecuperationHealthFacilityEtc30Over.setUnSelectValue(1);

      addShortStayRecuperationHealthFacilityEtc30Over();
    }
    return shortStayRecuperationHealthFacilityEtc30Over;

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
  public ACClearableRadioButtonGroup getShortStayRecuperationHealthUnitCareAddRadio(){
    if(shortStayRecuperationHealthUnitCareAddRadio==null){

      shortStayRecuperationHealthUnitCareAddRadio = new ACClearableRadioButtonGroup();

      getShortStayRecuperationHealthUnitCareAddRadioContainer().setText("���j�b�g�P�A�̐���");

      shortStayRecuperationHealthUnitCareAddRadio.setBindPath("1220117");

      shortStayRecuperationHealthUnitCareAddRadio.setUseClearButton(false);

      shortStayRecuperationHealthUnitCareAddRadio.setModel(getShortStayRecuperationHealthUnitCareAddRadioModel());

      addShortStayRecuperationHealthUnitCareAddRadio();
    }
    return shortStayRecuperationHealthUnitCareAddRadio;

  }

  /**
   * ���j�b�g�P�A�̐����R���e�i���擾���܂��B
   * @return ���j�b�g�P�A�̐����R���e�i
   */
  protected ACLabelContainer getShortStayRecuperationHealthUnitCareAddRadioContainer(){
    if(shortStayRecuperationHealthUnitCareAddRadioContainer==null){
      shortStayRecuperationHealthUnitCareAddRadioContainer = new ACLabelContainer();
      shortStayRecuperationHealthUnitCareAddRadioContainer.setFollowChildEnabled(true);
      shortStayRecuperationHealthUnitCareAddRadioContainer.setVAlignment(VRLayout.CENTER);
      shortStayRecuperationHealthUnitCareAddRadioContainer.add(getShortStayRecuperationHealthUnitCareAddRadio(), null);
    }
    return shortStayRecuperationHealthUnitCareAddRadioContainer;
  }

  /**
   * ���j�b�g�P�A�̐������f�����擾���܂��B
   * @return ���j�b�g�P�A�̐������f��
   */
  protected ACListModelAdapter getShortStayRecuperationHealthUnitCareAddRadioModel(){
    if(shortStayRecuperationHealthUnitCareAddRadioModel==null){
      shortStayRecuperationHealthUnitCareAddRadioModel = new ACListModelAdapter();
      addShortStayRecuperationHealthUnitCareAddRadioModel();
    }
    return shortStayRecuperationHealthUnitCareAddRadioModel;
  }

  /**
   * ���������擾���܂��B
   * @return ������
   */
  public ACRadioButtonItem getShortStayRecuperationHealthUnitCareAddRadioItem1(){
    if(shortStayRecuperationHealthUnitCareAddRadioItem1==null){

      shortStayRecuperationHealthUnitCareAddRadioItem1 = new ACRadioButtonItem();

      shortStayRecuperationHealthUnitCareAddRadioItem1.setText("������");

      shortStayRecuperationHealthUnitCareAddRadioItem1.setGroup(getShortStayRecuperationHealthUnitCareAddRadio());

      shortStayRecuperationHealthUnitCareAddRadioItem1.setConstraints(VRLayout.FLOW);

      addShortStayRecuperationHealthUnitCareAddRadioItem1();
    }
    return shortStayRecuperationHealthUnitCareAddRadioItem1;

  }

  /**
   * �������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getShortStayRecuperationHealthUnitCareAddRadioItem2(){
    if(shortStayRecuperationHealthUnitCareAddRadioItem2==null){

      shortStayRecuperationHealthUnitCareAddRadioItem2 = new ACRadioButtonItem();

      shortStayRecuperationHealthUnitCareAddRadioItem2.setText("����");

      shortStayRecuperationHealthUnitCareAddRadioItem2.setGroup(getShortStayRecuperationHealthUnitCareAddRadio());

      shortStayRecuperationHealthUnitCareAddRadioItem2.setConstraints(VRLayout.FLOW);

      addShortStayRecuperationHealthUnitCareAddRadioItem2();
    }
    return shortStayRecuperationHealthUnitCareAddRadioItem2;

  }

  /**
   * �×{�̐��ێ����ʉ��Z���擾���܂��B
   * @return �×{�̐��ێ����ʉ��Z
   */
  public ACClearableRadioButtonGroup getShortStayRecuperationHealthFacilityRecuperationRadio(){
    if(shortStayRecuperationHealthFacilityRecuperationRadio==null){

      shortStayRecuperationHealthFacilityRecuperationRadio = new ACClearableRadioButtonGroup();

      getShortStayRecuperationHealthFacilityRecuperationRadioContainer().setText("�×{�̐��ێ����ʉ��Z");

      shortStayRecuperationHealthFacilityRecuperationRadio.setBindPath("1220121");

      shortStayRecuperationHealthFacilityRecuperationRadio.setUseClearButton(false);

      shortStayRecuperationHealthFacilityRecuperationRadio.setModel(getShortStayRecuperationHealthFacilityRecuperationRadioModel());

      addShortStayRecuperationHealthFacilityRecuperationRadio();
    }
    return shortStayRecuperationHealthFacilityRecuperationRadio;

  }

  /**
   * �×{�̐��ێ����ʉ��Z�R���e�i���擾���܂��B
   * @return �×{�̐��ێ����ʉ��Z�R���e�i
   */
  protected ACLabelContainer getShortStayRecuperationHealthFacilityRecuperationRadioContainer(){
    if(shortStayRecuperationHealthFacilityRecuperationRadioContainer==null){
      shortStayRecuperationHealthFacilityRecuperationRadioContainer = new ACLabelContainer();
      shortStayRecuperationHealthFacilityRecuperationRadioContainer.setFollowChildEnabled(true);
      shortStayRecuperationHealthFacilityRecuperationRadioContainer.setVAlignment(VRLayout.CENTER);
      shortStayRecuperationHealthFacilityRecuperationRadioContainer.add(getShortStayRecuperationHealthFacilityRecuperationRadio(), null);
    }
    return shortStayRecuperationHealthFacilityRecuperationRadioContainer;
  }

  /**
   * �×{�̐��ێ����ʉ��Z���f�����擾���܂��B
   * @return �×{�̐��ێ����ʉ��Z���f��
   */
  protected ACListModelAdapter getShortStayRecuperationHealthFacilityRecuperationRadioModel(){
    if(shortStayRecuperationHealthFacilityRecuperationRadioModel==null){
      shortStayRecuperationHealthFacilityRecuperationRadioModel = new ACListModelAdapter();
      addShortStayRecuperationHealthFacilityRecuperationRadioModel();
    }
    return shortStayRecuperationHealthFacilityRecuperationRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getShortStayRecuperationHealthFacilityRecuperationRadioItem1(){
    if(shortStayRecuperationHealthFacilityRecuperationRadioItem1==null){

      shortStayRecuperationHealthFacilityRecuperationRadioItem1 = new ACRadioButtonItem();

      shortStayRecuperationHealthFacilityRecuperationRadioItem1.setText("�Ȃ�");

      shortStayRecuperationHealthFacilityRecuperationRadioItem1.setGroup(getShortStayRecuperationHealthFacilityRecuperationRadio());

      shortStayRecuperationHealthFacilityRecuperationRadioItem1.setConstraints(VRLayout.FLOW);

      addShortStayRecuperationHealthFacilityRecuperationRadioItem1();
    }
    return shortStayRecuperationHealthFacilityRecuperationRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getShortStayRecuperationHealthFacilityRecuperationRadioItem2(){
    if(shortStayRecuperationHealthFacilityRecuperationRadioItem2==null){

      shortStayRecuperationHealthFacilityRecuperationRadioItem2 = new ACRadioButtonItem();

      shortStayRecuperationHealthFacilityRecuperationRadioItem2.setText("����");

      shortStayRecuperationHealthFacilityRecuperationRadioItem2.setGroup(getShortStayRecuperationHealthFacilityRecuperationRadio());

      shortStayRecuperationHealthFacilityRecuperationRadioItem2.setConstraints(VRLayout.FLOW);

      addShortStayRecuperationHealthFacilityRecuperationRadioItem2();
    }
    return shortStayRecuperationHealthFacilityRecuperationRadioItem2;

  }

  /**
   * �ً}�Z�������l�b�g���[�N���Z���擾���܂��B
   * @return �ً}�Z�������l�b�g���[�N���Z
   */
  public ACClearableRadioButtonGroup getShortStayRecuperationHealthEmergencyNetworkAddRadio(){
    if(shortStayRecuperationHealthEmergencyNetworkAddRadio==null){

      shortStayRecuperationHealthEmergencyNetworkAddRadio = new ACClearableRadioButtonGroup();

      getShortStayRecuperationHealthEmergencyNetworkAddRadioContainer().setText("�ً}�Z�������l�b�g���[�N���Z");

      shortStayRecuperationHealthEmergencyNetworkAddRadio.setBindPath("1220118");

      shortStayRecuperationHealthEmergencyNetworkAddRadio.setUseClearButton(false);

      shortStayRecuperationHealthEmergencyNetworkAddRadio.setModel(getShortStayRecuperationHealthEmergencyNetworkAddRadioModel());

      addShortStayRecuperationHealthEmergencyNetworkAddRadio();
    }
    return shortStayRecuperationHealthEmergencyNetworkAddRadio;

  }

  /**
   * �ً}�Z�������l�b�g���[�N���Z�R���e�i���擾���܂��B
   * @return �ً}�Z�������l�b�g���[�N���Z�R���e�i
   */
  protected ACLabelContainer getShortStayRecuperationHealthEmergencyNetworkAddRadioContainer(){
    if(shortStayRecuperationHealthEmergencyNetworkAddRadioContainer==null){
      shortStayRecuperationHealthEmergencyNetworkAddRadioContainer = new ACLabelContainer();
      shortStayRecuperationHealthEmergencyNetworkAddRadioContainer.setFollowChildEnabled(true);
      shortStayRecuperationHealthEmergencyNetworkAddRadioContainer.setVAlignment(VRLayout.CENTER);
      shortStayRecuperationHealthEmergencyNetworkAddRadioContainer.add(getShortStayRecuperationHealthEmergencyNetworkAddRadio(), null);
    }
    return shortStayRecuperationHealthEmergencyNetworkAddRadioContainer;
  }

  /**
   * �ً}�Z�������l�b�g���[�N���Z���f�����擾���܂��B
   * @return �ً}�Z�������l�b�g���[�N���Z���f��
   */
  protected ACListModelAdapter getShortStayRecuperationHealthEmergencyNetworkAddRadioModel(){
    if(shortStayRecuperationHealthEmergencyNetworkAddRadioModel==null){
      shortStayRecuperationHealthEmergencyNetworkAddRadioModel = new ACListModelAdapter();
      addShortStayRecuperationHealthEmergencyNetworkAddRadioModel();
    }
    return shortStayRecuperationHealthEmergencyNetworkAddRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getShortStayRecuperationHealthEmergencyNetworkAddRadioItem1(){
    if(shortStayRecuperationHealthEmergencyNetworkAddRadioItem1==null){

      shortStayRecuperationHealthEmergencyNetworkAddRadioItem1 = new ACRadioButtonItem();

      shortStayRecuperationHealthEmergencyNetworkAddRadioItem1.setText("�Ȃ�");

      shortStayRecuperationHealthEmergencyNetworkAddRadioItem1.setGroup(getShortStayRecuperationHealthEmergencyNetworkAddRadio());

      shortStayRecuperationHealthEmergencyNetworkAddRadioItem1.setConstraints(VRLayout.FLOW);

      addShortStayRecuperationHealthEmergencyNetworkAddRadioItem1();
    }
    return shortStayRecuperationHealthEmergencyNetworkAddRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getShortStayRecuperationHealthEmergencyNetworkAddRadioItem2(){
    if(shortStayRecuperationHealthEmergencyNetworkAddRadioItem2==null){

      shortStayRecuperationHealthEmergencyNetworkAddRadioItem2 = new ACRadioButtonItem();

      shortStayRecuperationHealthEmergencyNetworkAddRadioItem2.setText("����");

      shortStayRecuperationHealthEmergencyNetworkAddRadioItem2.setGroup(getShortStayRecuperationHealthEmergencyNetworkAddRadio());

      shortStayRecuperationHealthEmergencyNetworkAddRadioItem2.setConstraints(VRLayout.FLOW);

      addShortStayRecuperationHealthEmergencyNetworkAddRadioItem2();
    }
    return shortStayRecuperationHealthEmergencyNetworkAddRadioItem2;

  }

  /**
   * �T�[�r�X�񋟑̐��������Z���擾���܂��B
   * @return �T�[�r�X�񋟑̐��������Z
   */
  public ACValueArrayRadioButtonGroup getServiceAddProvisionStructuralRadioGroup(){
    if(serviceAddProvisionStructuralRadioGroup==null){

      serviceAddProvisionStructuralRadioGroup = new ACValueArrayRadioButtonGroup();

      getServiceAddProvisionStructuralRadioGroupContainer().setText("�T�[�r�X�񋟑̐�" + ACConstants.LINE_SEPARATOR + "�������Z");

      serviceAddProvisionStructuralRadioGroup.setBindPath("1220124");

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
   * �R���X�g���N�^�ł��B
   */
  public QS001110_H2104Design() {

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

    tab1.add(getShortStayRecuperationHealthFacilityInstitutionDivisionContainar(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getShortStayRecuperationHealthFacilityHospitalRoomDivisionContena(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getShortStayRecuperationHealthFacilitySickroomDivisionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getTankinyusyoTimeDivisionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getShortStayRecuperationHealthNightWorkConditionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getNightStaffDispositionAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getShortStayRecuperationHealthFacilityEtcRehabilitationContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getHoumonRehabilitationShortConcentrationAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getShortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * �{�ݓ��̋敪�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperationHealthFacilityInstitutionDivisionContainar(){

    shortStayRecuperationHealthFacilityInstitutionDivisionContainar.add(getShortStayRecuperationHealthFacilityInstitutionDivisionBackLabel1Containar(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayRecuperationHealthFacilityInstitutionDivisionContainar.add(getShortStayRecuperationHealthFacilityInstitutionDivisionBackLabel2(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * �w�ʃ��x���R���e�i�i�{�݋敪�j�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperationHealthFacilityInstitutionDivisionBackLabel1Containar(){

    shortStayRecuperationHealthFacilityInstitutionDivisionBackLabel1Containar.add(getShortStayRecuperationHealthFacilityInstitutionDivisionRadio(), VRLayout.FLOW_INSETLINE);

  }

  /**
   * �{�ݓ��̋敪�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperationHealthFacilityInstitutionDivisionRadio(){

  }

  /**
   * �{�ݓ��̋敪���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperationHealthFacilityInstitutionDivisionRadioModel(){

    getShortStayRecuperationHealthFacilityInstitutionDivisionRadioItem1().setButtonIndex(1);

    getShortStayRecuperationHealthFacilityInstitutionDivisionRadioModel().add(getShortStayRecuperationHealthFacilityInstitutionDivisionRadioItem1());

    getShortStayRecuperationHealthFacilityInstitutionDivisionRadioItem2().setButtonIndex(2);

    getShortStayRecuperationHealthFacilityInstitutionDivisionRadioModel().add(getShortStayRecuperationHealthFacilityInstitutionDivisionRadioItem2());

    getShortStayRecuperationHealthFacilityInstitutionDivisionRadioItem3().setButtonIndex(3);

    getShortStayRecuperationHealthFacilityInstitutionDivisionRadioModel().add(getShortStayRecuperationHealthFacilityInstitutionDivisionRadioItem3());

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
   * ���A��V���[�g�X�e�C�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperationHealthFacilityInstitutionDivisionRadioItem3(){

  }

  /**
   * �w�ʃ��x���R���e�i�i�̐��j�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperationHealthFacilityInstitutionDivisionBackLabel2(){

    shortStayRecuperationHealthFacilityInstitutionDivisionBackLabel2.add(getShortStayRecuperationHealthFacilityDivision(), VRLayout.FLOW_INSETLINE);

  }

  /**
   * �̐��ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperationHealthFacilityDivision(){

  }

  /**
   * �̐����f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperationHealthFacilityDivisionModel(){

    getShortStayRecuperationHealthFacilityDivisionType1().setButtonIndex(1);

    getShortStayRecuperationHealthFacilityDivisionModel().add(getShortStayRecuperationHealthFacilityDivisionType1());

    getShortStayRecuperationHealthFacilityDivisionType2().setButtonIndex(2);

    getShortStayRecuperationHealthFacilityDivisionModel().add(getShortStayRecuperationHealthFacilityDivisionType2());

    getShortStayRecuperationHealthFacilityDivisionType3().setButtonIndex(3);

    getShortStayRecuperationHealthFacilityDivisionModel().add(getShortStayRecuperationHealthFacilityDivisionType3());

  }

  /**
   * I�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperationHealthFacilityDivisionType1(){

  }

  /**
   * II�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperationHealthFacilityDivisionType2(){

  }

  /**
   * III�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperationHealthFacilityDivisionType3(){

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
   * �a���敪���W�I�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperationHealthFacilitySickroomDivisionRadio(){

  }

  /**
   * �a���敪���W�I���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperationHealthFacilitySickroomDivisionRadioModel(){

    getShortStayRecuperationHealthFacilitySickroomDivisionRadioItem1().setButtonIndex(1);

    getShortStayRecuperationHealthFacilitySickroomDivisionRadioModel().add(getShortStayRecuperationHealthFacilitySickroomDivisionRadioItem1());

    getShortStayRecuperationHealthFacilitySickroomDivisionRadioItem2().setButtonIndex(2);

    getShortStayRecuperationHealthFacilitySickroomDivisionRadioModel().add(getShortStayRecuperationHealthFacilitySickroomDivisionRadioItem2());

    getShortStayRecuperationHealthFacilitySickroomDivisionRadioItem3().setButtonIndex(3);

    getShortStayRecuperationHealthFacilitySickroomDivisionRadioModel().add(getShortStayRecuperationHealthFacilitySickroomDivisionRadioItem3());

    getShortStayRecuperationHealthFacilitySickroomDivisionRadioItem4().setButtonIndex(4);

    getShortStayRecuperationHealthFacilitySickroomDivisionRadioModel().add(getShortStayRecuperationHealthFacilitySickroomDivisionRadioItem4());

  }

  /**
   * �]���^���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperationHealthFacilitySickroomDivisionRadioItem1(){

  }

  /**
   * �������ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperationHealthFacilitySickroomDivisionRadioItem2(){

  }

  /**
   * ���j�b�g�^���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperationHealthFacilitySickroomDivisionRadioItem3(){

  }

  /**
   * ���j�b�g�^�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperationHealthFacilitySickroomDivisionRadioItem4(){

  }

  /**
   * ���ԋ敪�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTankinyusyoTimeDivision(){

  }

  /**
   * ���ԋ敪���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addTankinyusyoTimeDivisionModel(){

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
   * ��ΐE���z�u���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addNightStaffDispositionAddRadioGroup(){

  }

  /**
   * ��ΐE���z�u���Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addNightStaffDispositionAddRadioGroupModel(){

    getNightStaffDispositionAddRadioItem1().setButtonIndex(1);

    getNightStaffDispositionAddRadioGroupModel().add(getNightStaffDispositionAddRadioItem1());

    getNightStaffDispositionAddRadioItem2().setButtonIndex(2);

    getNightStaffDispositionAddRadioGroupModel().add(getNightStaffDispositionAddRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addNightStaffDispositionAddRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addNightStaffDispositionAddRadioItem2(){

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
   * �ʃ��n�r�����{���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonRehabilitationShortConcentrationAddRadio(){

  }

  /**
   * �ʃ��n�r�����{���Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonRehabilitationShortConcentrationAddRadioModel(){

    getHoumonRehabilitationShortConcentrationAddRadioItem1().setButtonIndex(1);

    getHoumonRehabilitationShortConcentrationAddRadioModel().add(getHoumonRehabilitationShortConcentrationAddRadioItem1());

    getHoumonRehabilitationShortConcentrationAddRadioItem2().setButtonIndex(2);

    getHoumonRehabilitationShortConcentrationAddRadioModel().add(getHoumonRehabilitationShortConcentrationAddRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonRehabilitationShortConcentrationAddRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonRehabilitationShortConcentrationAddRadioItem2(){

  }

  /**
   * �F�m�ǃP�A���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadio(){

  }

  /**
   * �F�m�ǃP�A���Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadioModel(){

    getShortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadioItem1().setButtonIndex(1);

    getShortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadioModel().add(getShortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadioItem1());

    getShortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadioItem2().setButtonIndex(2);

    getShortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadioModel().add(getShortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadioItem2(){

  }

  /**
   * �^�u2�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTab2(){

    tab2.add(getDementiaActionAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getYoungDementiaPatinetAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getShortStayRecuperationHealthFacilityMeetingAndSendingOffContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getShortStayRecuperationHealthFacilityUrgentTimeStepRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getShortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getShortStayRecuperationHealthFacilitySpecialMedicalExpense(), VRLayout.FLOW);

    tab2.add(getShortStayRecuperationHealthFacilitySpecialMedicalExpenseLabel(), VRLayout.FLOW_RETURN);

    tab2.add(getShortStayRecuperationHealthFacilityPersonSubtractionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getShortStayRecuperationHealthFacilityDinnerContainer(), VRLayout.FLOW_DOUBLEINSETLINE_RETURN);

    tab2.add(getShortStayRecuperationHealthFacilityEtc30Over(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * �F�m�Ǎs���E�S���Ǐ�ً}�Ή����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addDementiaActionAddRadioGroup(){

  }

  /**
   * �F�m�Ǎs���E�S���Ǐ�ً}�Ή����Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addDementiaActionAddRadioGroupModel(){

    getDementiaActionAddRadioItem1().setButtonIndex(1);

    getDementiaActionAddRadioGroupModel().add(getDementiaActionAddRadioItem1());

    getDementiaActionAddRadioItem2().setButtonIndex(2);

    getDementiaActionAddRadioGroupModel().add(getDementiaActionAddRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addDementiaActionAddRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addDementiaActionAddRadioItem2(){

  }

  /**
   * ��N���F�m�Ǘ��p�Ҏ�����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addYoungDementiaPatinetAddRadioGroup(){

  }

  /**
   * ��N���F�m�Ǘ��p�Ҏ�����Z���f���ɓ������ڂ�ǉ����܂��B
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
   * ���ʗ×{��ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperationHealthFacilitySpecialMedicalExpense(){

  }

  /**
   * ���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperationHealthFacilitySpecialMedicalExpenseLabel(){

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
   * �Ō�E���E�����͈�t�APT�EOT�EST�̕s���ɓ������ڂ�ǉ����܂��B
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
   * �^�u3�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTab3(){

    tab3.add(getShortStayRecuperationHealthUnitCareAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab3.add(getShortStayRecuperationHealthFacilityRecuperationRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab3.add(getShortStayRecuperationHealthEmergencyNetworkAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab3.add(getServiceAddProvisionStructuralRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * ���j�b�g�P�A�̐����ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperationHealthUnitCareAddRadio(){

  }

  /**
   * ���j�b�g�P�A�̐������f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperationHealthUnitCareAddRadioModel(){

    getShortStayRecuperationHealthUnitCareAddRadioItem1().setButtonIndex(1);

    getShortStayRecuperationHealthUnitCareAddRadioModel().add(getShortStayRecuperationHealthUnitCareAddRadioItem1());

    getShortStayRecuperationHealthUnitCareAddRadioItem2().setButtonIndex(2);

    getShortStayRecuperationHealthUnitCareAddRadioModel().add(getShortStayRecuperationHealthUnitCareAddRadioItem2());

  }

  /**
   * �������ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperationHealthUnitCareAddRadioItem1(){

  }

  /**
   * �����ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperationHealthUnitCareAddRadioItem2(){

  }

  /**
   * �×{�̐��ێ����ʉ��Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperationHealthFacilityRecuperationRadio(){

  }

  /**
   * �×{�̐��ێ����ʉ��Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperationHealthFacilityRecuperationRadioModel(){

    getShortStayRecuperationHealthFacilityRecuperationRadioItem1().setButtonIndex(1);

    getShortStayRecuperationHealthFacilityRecuperationRadioModel().add(getShortStayRecuperationHealthFacilityRecuperationRadioItem1());

    getShortStayRecuperationHealthFacilityRecuperationRadioItem2().setButtonIndex(2);

    getShortStayRecuperationHealthFacilityRecuperationRadioModel().add(getShortStayRecuperationHealthFacilityRecuperationRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperationHealthFacilityRecuperationRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperationHealthFacilityRecuperationRadioItem2(){

  }

  /**
   * �ً}�Z�������l�b�g���[�N���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperationHealthEmergencyNetworkAddRadio(){

  }

  /**
   * �ً}�Z�������l�b�g���[�N���Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperationHealthEmergencyNetworkAddRadioModel(){

    getShortStayRecuperationHealthEmergencyNetworkAddRadioItem1().setButtonIndex(1);

    getShortStayRecuperationHealthEmergencyNetworkAddRadioModel().add(getShortStayRecuperationHealthEmergencyNetworkAddRadioItem1());

    getShortStayRecuperationHealthEmergencyNetworkAddRadioItem2().setButtonIndex(2);

    getShortStayRecuperationHealthEmergencyNetworkAddRadioModel().add(getShortStayRecuperationHealthEmergencyNetworkAddRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperationHealthEmergencyNetworkAddRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperationHealthEmergencyNetworkAddRadioItem2(){

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
      ACFrame.debugStart(new ACAffairInfo(QS001110_H2104Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QS001110_H2104Design getThis() {
    return this;
  }
}
