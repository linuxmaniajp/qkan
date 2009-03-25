
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
 * �쐬��: 2009/03/06  ���{�R���s���[�^�[������� �c���@���� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �T�[�r�X�\��쐬/�ύX (S)
 * �v���Z�X �T�[�r�X�\��T�� (001)
 * �v���O���� �T�[�r�X�p�^�[�����\�h�Z�������×{���i�V�l�ی��{�݁j (QS001138_H2104)
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
 * �T�[�r�X�p�^�[�����\�h�Z�������×{���i�V�l�ی��{�݁j��ʍ��ڃf�U�C��(QS001138_H2104) 
 */
public class QS001138_H2104Design extends QS001ServicePanel {
  //GUI�R���|�[�l���g

  private JTabbedPane tabs;

  private ACPanel tab1;

  private ACLabelContainer shortStayRecuperationHealthFacilityInstitutionDivisionContainar;

  private ACBackLabelContainer shortStayRecuperationHealthFacilityInstitutionDivisionBackLabelContainar1;

  private ACClearableRadioButtonGroup shortStayRecuperationHealthFacilityInstitutionDivisionRadio;

  private ACListModelAdapter shortStayRecuperationHealthFacilityInstitutionDivisionRadioModel;

  private ACRadioButtonItem shortStayRecuperationHealthFacilityInstitutionDivisionRadioItem1;

  private ACRadioButtonItem shortStayRecuperationHealthFacilityInstitutionDivisionRadioItem2;

  private ACBackLabelContainer shortStayRecuperationHealthFacilityInstitutionDivisionBackLabelContainar2;

  private ACValueArrayRadioButtonGroup shortStayRecuperationHealthDivision;

  private ACListModelAdapter shortStayRecuperationHealthDivisionModel;

  private ACRadioButtonItem shortStayRecuperationHealthDivisionType1;

  private ACRadioButtonItem shortStayRecuperationHealthDivisionType2;

  private ACRadioButtonItem shortStayRecuperationHealthDivisionType3;

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

  private ACPanel tab2;

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

  private ACMapBindButton specialMedicalExpense;

  private ACLabel specialMedicalExpenseLabel;

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

  private ACClearableRadioButtonGroup shortStayRecuperationHealthUnitCareAddRadio;

  private ACLabelContainer shortStayRecuperationHealthUnitCareAddRadioContainer;

  private ACListModelAdapter shortStayRecuperationHealthUnitCareAddRadioModel;

  private ACRadioButtonItem shortStayRecuperationHealthUnitCareAddRadioItem1;

  private ACRadioButtonItem shortStayRecuperationHealthUnitCareAddRadioItem2;

  private ACClearableRadioButtonGroup recuperationRadio;

  private ACLabelContainer recuperationRadioContainer;

  private ACListModelAdapter recuperationRadioModel;

  private ACRadioButtonItem recuperationRadioItem1;

  private ACRadioButtonItem recuperationRadioItem2;

  private ACPanel tab3;

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

      shortStayRecuperationHealthFacilityInstitutionDivisionContainar.setAutoWrap(false);

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
  public ACBackLabelContainer getShortStayRecuperationHealthFacilityInstitutionDivisionBackLabelContainar1(){
    if(shortStayRecuperationHealthFacilityInstitutionDivisionBackLabelContainar1==null){

      shortStayRecuperationHealthFacilityInstitutionDivisionBackLabelContainar1 = new ACBackLabelContainer();

      shortStayRecuperationHealthFacilityInstitutionDivisionBackLabelContainar1.setAutoWrap(false);

      shortStayRecuperationHealthFacilityInstitutionDivisionBackLabelContainar1.setFollowChildEnabled(true);

      shortStayRecuperationHealthFacilityInstitutionDivisionBackLabelContainar1.setHgap(0);

      shortStayRecuperationHealthFacilityInstitutionDivisionBackLabelContainar1.setLabelMargin(0);

      shortStayRecuperationHealthFacilityInstitutionDivisionBackLabelContainar1.setVgap(0);

      addShortStayRecuperationHealthFacilityInstitutionDivisionBackLabelContainar1();
    }
    return shortStayRecuperationHealthFacilityInstitutionDivisionBackLabelContainar1;

  }

  /**
   * �{�ݓ��̋敪���擾���܂��B
   * @return �{�ݓ��̋敪
   */
  public ACClearableRadioButtonGroup getShortStayRecuperationHealthFacilityInstitutionDivisionRadio(){
    if(shortStayRecuperationHealthFacilityInstitutionDivisionRadio==null){

      shortStayRecuperationHealthFacilityInstitutionDivisionRadio = new ACClearableRadioButtonGroup();

      shortStayRecuperationHealthFacilityInstitutionDivisionRadio.setBindPath("1250101");

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
   * �w�ʃ��x���R���e�i�i�̐��j���擾���܂��B
   * @return �w�ʃ��x���R���e�i�i�̐��j
   */
  public ACBackLabelContainer getShortStayRecuperationHealthFacilityInstitutionDivisionBackLabelContainar2(){
    if(shortStayRecuperationHealthFacilityInstitutionDivisionBackLabelContainar2==null){

      shortStayRecuperationHealthFacilityInstitutionDivisionBackLabelContainar2 = new ACBackLabelContainer();

      shortStayRecuperationHealthFacilityInstitutionDivisionBackLabelContainar2.setAutoWrap(false);

      shortStayRecuperationHealthFacilityInstitutionDivisionBackLabelContainar2.setFollowChildEnabled(true);

      shortStayRecuperationHealthFacilityInstitutionDivisionBackLabelContainar2.setHgap(0);

      shortStayRecuperationHealthFacilityInstitutionDivisionBackLabelContainar2.setLabelMargin(0);

      shortStayRecuperationHealthFacilityInstitutionDivisionBackLabelContainar2.setVgap(0);

      addShortStayRecuperationHealthFacilityInstitutionDivisionBackLabelContainar2();
    }
    return shortStayRecuperationHealthFacilityInstitutionDivisionBackLabelContainar2;

  }

  /**
   * �̐����擾���܂��B
   * @return �̐�
   */
  public ACValueArrayRadioButtonGroup getShortStayRecuperationHealthDivision(){
    if(shortStayRecuperationHealthDivision==null){

      shortStayRecuperationHealthDivision = new ACValueArrayRadioButtonGroup();

      shortStayRecuperationHealthDivision.setBindPath("1250113");

      shortStayRecuperationHealthDivision.setNoSelectIndex(0);

      shortStayRecuperationHealthDivision.setUseClearButton(false);

      shortStayRecuperationHealthDivision.setModel(getShortStayRecuperationHealthDivisionModel());

      shortStayRecuperationHealthDivision.setValues(new int[]{1,2,3});

      addShortStayRecuperationHealthDivision();
    }
    return shortStayRecuperationHealthDivision;

  }

  /**
   * �̐����f�����擾���܂��B
   * @return �̐����f��
   */
  protected ACListModelAdapter getShortStayRecuperationHealthDivisionModel(){
    if(shortStayRecuperationHealthDivisionModel==null){
      shortStayRecuperationHealthDivisionModel = new ACListModelAdapter();
      addShortStayRecuperationHealthDivisionModel();
    }
    return shortStayRecuperationHealthDivisionModel;
  }

  /**
   * I�^���擾���܂��B
   * @return I�^
   */
  public ACRadioButtonItem getShortStayRecuperationHealthDivisionType1(){
    if(shortStayRecuperationHealthDivisionType1==null){

      shortStayRecuperationHealthDivisionType1 = new ACRadioButtonItem();

      shortStayRecuperationHealthDivisionType1.setText("I�^");

      shortStayRecuperationHealthDivisionType1.setGroup(getShortStayRecuperationHealthDivision());

      shortStayRecuperationHealthDivisionType1.setConstraints(VRLayout.FLOW);

      addShortStayRecuperationHealthDivisionType1();
    }
    return shortStayRecuperationHealthDivisionType1;

  }

  /**
   * II�^���擾���܂��B
   * @return II�^
   */
  public ACRadioButtonItem getShortStayRecuperationHealthDivisionType2(){
    if(shortStayRecuperationHealthDivisionType2==null){

      shortStayRecuperationHealthDivisionType2 = new ACRadioButtonItem();

      shortStayRecuperationHealthDivisionType2.setText("II�^");

      shortStayRecuperationHealthDivisionType2.setGroup(getShortStayRecuperationHealthDivision());

      shortStayRecuperationHealthDivisionType2.setConstraints(VRLayout.FLOW);

      addShortStayRecuperationHealthDivisionType2();
    }
    return shortStayRecuperationHealthDivisionType2;

  }

  /**
   * III�^���擾���܂��B
   * @return III�^
   */
  public ACRadioButtonItem getShortStayRecuperationHealthDivisionType3(){
    if(shortStayRecuperationHealthDivisionType3==null){

      shortStayRecuperationHealthDivisionType3 = new ACRadioButtonItem();

      shortStayRecuperationHealthDivisionType3.setText("III�^");

      shortStayRecuperationHealthDivisionType3.setGroup(getShortStayRecuperationHealthDivision());

      shortStayRecuperationHealthDivisionType3.setConstraints(VRLayout.FLOW);

      addShortStayRecuperationHealthDivisionType3();
    }
    return shortStayRecuperationHealthDivisionType3;

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

      shortStayRecuperationHealthFacilityHospitalRoomDivisionRadio.setBindPath("1250102");

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

      shortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadio.setBindPath("1250103");

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
   * ��ԋΖ���������擾���܂��B
   * @return ��ԋΖ������
   */
  public ACClearableRadioButtonGroup getShortStayRecuperationHealthNightWorkConditionRadio(){
    if(shortStayRecuperationHealthNightWorkConditionRadio==null){

      shortStayRecuperationHealthNightWorkConditionRadio = new ACClearableRadioButtonGroup();

      getShortStayRecuperationHealthNightWorkConditionRadioContainer().setText("��ԋΖ������");

      shortStayRecuperationHealthNightWorkConditionRadio.setBindPath("1250104");

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

      nightStaffDispositionAddRadioGroup.setBindPath("1250120");

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

      shortStayRecuperationHealthFacilityEtcRehabilitation.setBindPath("1250105");

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

      houmonRehabilitationShortConcentrationAddRadio.setBindPath("1250121");

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
   * �F�m�Ǎs���E�S���Ǐ�ً}�Ή����Z���擾���܂��B
   * @return �F�m�Ǎs���E�S���Ǐ�ً}�Ή����Z
   */
  public ACValueArrayRadioButtonGroup getDementiaActionAddRadioGroup(){
    if(dementiaActionAddRadioGroup==null){

      dementiaActionAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getDementiaActionAddRadioGroupContainer().setText("�F�m�Ǎs���E" + ACConstants.LINE_SEPARATOR + "�S���Ǐ�ً}�Ή����Z");

      dementiaActionAddRadioGroup.setBindPath("1250122");

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

      youngDementiaPatinetAddRadioGroup.setBindPath("1250123");

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

      shortStayRecuperationHealthFacilityUrgentTimeStepRadio.setBindPath("1250106");

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

      shortStayRecuperationHealthFacilityDieticianMedicalExpensesRadio.setBindPath("1250108");

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
  public ACMapBindButton getSpecialMedicalExpense(){
    if(specialMedicalExpense==null){

      specialMedicalExpense = new ACMapBindButton();

      specialMedicalExpense.setText("���ʗ×{��");

      specialMedicalExpense.setToolTipText("���ʗ×{���ݒ肵�܂��B");

      addSpecialMedicalExpense();
    }
    return specialMedicalExpense;

  }

  /**
   * ���x�����擾���܂��B
   * @return ���x��
   */
  public ACLabel getSpecialMedicalExpenseLabel(){
    if(specialMedicalExpenseLabel==null){

      specialMedicalExpenseLabel = new ACLabel();

      specialMedicalExpenseLabel.setText("�ݒ�Ȃ�");

      specialMedicalExpenseLabel.setOpaque(true);
      specialMedicalExpenseLabel.setBackground(new Color(255,255,172));

      addSpecialMedicalExpenseLabel();
    }
    return specialMedicalExpenseLabel;

  }

  /**
   * �l�����Z���擾���܂��B
   * @return �l�����Z
   */
  public ACClearableRadioButtonGroup getShortStayRecuperationHealthFacilityPersonSubtraction(){
    if(shortStayRecuperationHealthFacilityPersonSubtraction==null){

      shortStayRecuperationHealthFacilityPersonSubtraction = new ACClearableRadioButtonGroup();

      getShortStayRecuperationHealthFacilityPersonSubtractionContainer().setText("�l�����Z");

      shortStayRecuperationHealthFacilityPersonSubtraction.setBindPath("1250109");

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
   * �Ō�E���E�����͈�t�APT�EOT�EST���������擾���܂��B
   * @return �Ō�E���E�����͈�t�APT�EOT�EST������
   */
  public ACRadioButtonItem getShortStayRecuperationHealthFacilityPersonSubtractionStaffLack(){
    if(shortStayRecuperationHealthFacilityPersonSubtractionStaffLack==null){

      shortStayRecuperationHealthFacilityPersonSubtractionStaffLack = new ACRadioButtonItem();

      shortStayRecuperationHealthFacilityPersonSubtractionStaffLack.setText("<html>�Ō�E���E�����͈�t�A<br>PT�EOT�EST������</html>");

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

      shortStayRecuperationHealthFacilityDinnerOffer.setBindPath("1250110");

      shortStayRecuperationHealthFacilityDinnerOffer.setEditable(false);

      shortStayRecuperationHealthFacilityDinnerOffer.setModelBindPath("1250110");

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

      shortStayRecuperationHealthFacilityDinnerCost.setBindPath("1250111");

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
   * ���j�b�g�P�A�̐������擾���܂��B
   * @return ���j�b�g�P�A�̐���
   */
  public ACClearableRadioButtonGroup getShortStayRecuperationHealthUnitCareAddRadio(){
    if(shortStayRecuperationHealthUnitCareAddRadio==null){

      shortStayRecuperationHealthUnitCareAddRadio = new ACClearableRadioButtonGroup();

      getShortStayRecuperationHealthUnitCareAddRadioContainer().setText("���j�b�g�P�A�̐���");

      shortStayRecuperationHealthUnitCareAddRadio.setBindPath("1250112");

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
  public ACClearableRadioButtonGroup getRecuperationRadio(){
    if(recuperationRadio==null){

      recuperationRadio = new ACClearableRadioButtonGroup();

      getRecuperationRadioContainer().setText("�×{�̐��ێ����ʉ��Z");

      recuperationRadio.setBindPath("1250114");

      recuperationRadio.setUseClearButton(false);

      recuperationRadio.setModel(getRecuperationRadioModel());

      addRecuperationRadio();
    }
    return recuperationRadio;

  }

  /**
   * �×{�̐��ێ����ʉ��Z�R���e�i���擾���܂��B
   * @return �×{�̐��ێ����ʉ��Z�R���e�i
   */
  protected ACLabelContainer getRecuperationRadioContainer(){
    if(recuperationRadioContainer==null){
      recuperationRadioContainer = new ACLabelContainer();
      recuperationRadioContainer.setFollowChildEnabled(true);
      recuperationRadioContainer.setVAlignment(VRLayout.CENTER);
      recuperationRadioContainer.add(getRecuperationRadio(), null);
    }
    return recuperationRadioContainer;
  }

  /**
   * �×{�̐��ێ����ʉ��Z���f�����擾���܂��B
   * @return �×{�̐��ێ����ʉ��Z���f��
   */
  protected ACListModelAdapter getRecuperationRadioModel(){
    if(recuperationRadioModel==null){
      recuperationRadioModel = new ACListModelAdapter();
      addRecuperationRadioModel();
    }
    return recuperationRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getRecuperationRadioItem1(){
    if(recuperationRadioItem1==null){

      recuperationRadioItem1 = new ACRadioButtonItem();

      recuperationRadioItem1.setText("�Ȃ�");

      recuperationRadioItem1.setGroup(getRecuperationRadio());

      recuperationRadioItem1.setConstraints(VRLayout.FLOW);

      addRecuperationRadioItem1();
    }
    return recuperationRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getRecuperationRadioItem2(){
    if(recuperationRadioItem2==null){

      recuperationRadioItem2 = new ACRadioButtonItem();

      recuperationRadioItem2.setText("����");

      recuperationRadioItem2.setGroup(getRecuperationRadio());

      recuperationRadioItem2.setConstraints(VRLayout.FLOW);

      addRecuperationRadioItem2();
    }
    return recuperationRadioItem2;

  }

  /**
   * �^�u2���擾���܂��B
   * @return �^�u2
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
   * �T�[�r�X�񋟑̐��������Z���擾���܂��B
   * @return �T�[�r�X�񋟑̐��������Z
   */
  public ACValueArrayRadioButtonGroup getServiceAddProvisionStructuralRadioGroup(){
    if(serviceAddProvisionStructuralRadioGroup==null){

      serviceAddProvisionStructuralRadioGroup = new ACValueArrayRadioButtonGroup();

      getServiceAddProvisionStructuralRadioGroupContainer().setText("�T�[�r�X�񋟑̐��������Z");

      serviceAddProvisionStructuralRadioGroup.setBindPath("1250117");

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
  public QS001138_H2104Design() {

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

    tab1.add(getShortStayRecuperationHealthNightWorkConditionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getNightStaffDispositionAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getShortStayRecuperationHealthFacilityEtcRehabilitationContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getHoumonRehabilitationShortConcentrationAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getDementiaActionAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getYoungDementiaPatinetAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * �{�ݓ��̋敪�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperationHealthFacilityInstitutionDivisionContainar(){

    shortStayRecuperationHealthFacilityInstitutionDivisionContainar.add(getShortStayRecuperationHealthFacilityInstitutionDivisionBackLabelContainar1(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayRecuperationHealthFacilityInstitutionDivisionContainar.add(getShortStayRecuperationHealthFacilityInstitutionDivisionBackLabelContainar2(), VRLayout.FLOW_INSETLINE);

  }

  /**
   * �w�ʃ��x���R���e�i�i�{�݋敪�j�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperationHealthFacilityInstitutionDivisionBackLabelContainar1(){

    shortStayRecuperationHealthFacilityInstitutionDivisionBackLabelContainar1.add(getShortStayRecuperationHealthFacilityInstitutionDivisionRadio(), VRLayout.FLOW_INSETLINE);

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
   * �w�ʃ��x���R���e�i�i�̐��j�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperationHealthFacilityInstitutionDivisionBackLabelContainar2(){

    shortStayRecuperationHealthFacilityInstitutionDivisionBackLabelContainar2.add(getShortStayRecuperationHealthDivision(), VRLayout.FLOW_INSETLINE);

  }

  /**
   * �̐��ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperationHealthDivision(){

  }

  /**
   * �̐����f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperationHealthDivisionModel(){

    getShortStayRecuperationHealthDivisionType1().setButtonIndex(1);

    getShortStayRecuperationHealthDivisionModel().add(getShortStayRecuperationHealthDivisionType1());

    getShortStayRecuperationHealthDivisionType2().setButtonIndex(2);

    getShortStayRecuperationHealthDivisionModel().add(getShortStayRecuperationHealthDivisionType2());

    getShortStayRecuperationHealthDivisionType3().setButtonIndex(3);

    getShortStayRecuperationHealthDivisionModel().add(getShortStayRecuperationHealthDivisionType3());

  }

  /**
   * I�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperationHealthDivisionType1(){

  }

  /**
   * II�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperationHealthDivisionType2(){

  }

  /**
   * III�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayRecuperationHealthDivisionType3(){

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
   * �^�u2�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTab2(){

    tab2.add(getShortStayRecuperationHealthFacilityMeetingAndSendingOffContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getShortStayRecuperationHealthFacilityUrgentTimeStepRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getShortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getSpecialMedicalExpense(), VRLayout.FLOW);

    tab2.add(getSpecialMedicalExpenseLabel(), VRLayout.FLOW_RETURN);

    tab2.add(getShortStayRecuperationHealthFacilityPersonSubtractionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getShortStayRecuperationHealthFacilityDinnerContainer(), VRLayout.FLOW_DOUBLEINSETLINE_RETURN);

    tab2.add(getShortStayRecuperationHealthFacilityEtc30Over(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getShortStayRecuperationHealthUnitCareAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getRecuperationRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

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
  protected void addSpecialMedicalExpense(){

  }

  /**
   * ���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addSpecialMedicalExpenseLabel(){

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
   * �Ō�E���E�����͈�t�APT�EOT�EST�������ɓ������ڂ�ǉ����܂��B
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
  protected void addRecuperationRadio(){

  }

  /**
   * �×{�̐��ێ����ʉ��Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addRecuperationRadioModel(){

    getRecuperationRadioItem1().setButtonIndex(1);

    getRecuperationRadioModel().add(getRecuperationRadioItem1());

    getRecuperationRadioItem2().setButtonIndex(2);

    getRecuperationRadioModel().add(getRecuperationRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addRecuperationRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addRecuperationRadioItem2(){

  }

  /**
   * �^�u2�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTab3(){

    tab3.add(getServiceAddProvisionStructuralRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

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
      ACFrame.debugStart(new ACAffairInfo(QS001138_H2104Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QS001138_H2104Design getThis() {
    return this;
  }
}
