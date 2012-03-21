
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
 * �쐬��: 2012/03/09  ���{�R���s���[�^�[������� ����@��F �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �T�[�r�X�\��쐬/�ύX (S)
 * �v���Z�X �T�[�r�X�\��T�� (001)
 * �v���O���� �T�[�r�X�p�^�[���Z�������×{���i�a�@�×{�j (QS001_12311_201204)
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
 * �T�[�r�X�p�^�[���Z�������×{���i�a�@�×{�j��ʍ��ڃf�U�C��(QS001_12311_201204) 
 */
public class QS001_12311_201204Design extends QS001ServicePanel {
  //GUI�R���|�[�l���g

  private JTabbedPane tabs;

  private ACPanel tab1;

  private ACValueArrayRadioButtonGroup shortStayHospitalRecuperationInstitutionDivisionRadio;

  private ACLabelContainer shortStayHospitalRecuperationInstitutionDivisionRadioContainer;

  private ACListModelAdapter shortStayHospitalRecuperationInstitutionDivisionRadioModel;

  private ACRadioButtonItem shortStayHospitalRecuperationInstitutionDivisionRadioItem1;

  private ACRadioButtonItem shortStayHospitalRecuperationInstitutionDivisionRadioItem2;

  private ACRadioButtonItem shortStayHospitalRecuperationInstitutionDivisionRadioItem4;

  private ACRadioButtonItem shortStayHospitalRecuperationInstitutionDivisionRadioItem5;

  private ACRadioButtonItem shortStayHospitalRecuperationInstitutionDivisionRadioItem3;

  private ACValueArrayRadioButtonGroup shortStayHospitalRecuperationDivision;

  private ACLabelContainer shortStayHospitalRecuperationDivisionContainer;

  private ACListModelAdapter shortStayHospitalRecuperationDivisionModel;

  private ACRadioButtonItem shortStayHospitalRecuperationType1;

  private ACRadioButtonItem shortStayHospitalRecuperationType2;

  private ACRadioButtonItem shortStayHospitalRecuperationType3;

  private ACLabelContainer shortStayHospitalRecuperationHospitalRoomContena;

  private ACValueArrayRadioButtonGroup shortStayHospitalRecuperationHospitalRoomRadio;

  private ACListModelAdapter shortStayHospitalRecuperationHospitalRoomRadioModel;

  private ACRadioButtonItem shortStayHospitalRecuperationHospitalRoomRadioItem1;

  private ACRadioButtonItem shortStayHospitalRecuperationHospitalRoomRadioItem2;

  private ACValueArrayRadioButtonGroup shortStayHospitalRecuperationUnitHospitalRoomRadio;

  private ACListModelAdapter shortStayHospitalRecuperationUnitHospitalRoomRadioModel;

  private ACRadioButtonItem shortStayHospitalRecuperationUnitHospitalRoomRadioItem1;

  private ACRadioButtonItem shortStayHospitalRecuperationUnitHospitalRoomRadioItem2;

  private ACValueArrayRadioButtonGroup shortStayHospitalRecuperationSickroomDivisionRadio;

  private ACLabelContainer shortStayHospitalRecuperationSickroomDivisionRadioContainer;

  private ACListModelAdapter shortStayHospitalRecuperationSickroomDivisionRadioModel;

  private ACRadioButtonItem shortStayHospitalRecuperationSickroomDivisionRadioItem1;

  private ACRadioButtonItem shortStayHospitalRecuperationSickroomDivisionRadioItem2;

  private ACRadioButtonItem shortStayHospitalRecuperationSickroomDivisionRadioItem3;

  private ACRadioButtonItem shortStayHospitalRecuperationSickroomDivisionRadioItem4;

  private ACComboBox tankinyusyoTimeDivision;

  private ACLabelContainer tankinyusyoTimeDivisionContainer;

  private ACComboBoxModelAdapter tankinyusyoTimeDivisionModel;

  private ACValueArrayRadioButtonGroup shortStayHospitalRecuperationAdditionType;

  private ACLabelContainer shortStayHospitalRecuperationAdditionTypeContainer;

  private ACListModelAdapter shortStayHospitalRecuperationAdditionTypeModel;

  private ACRadioButtonItem shortStayHospitalRecuperationAdditionTypeNormal;

  private ACRadioButtonItem shortStayHospitalRecuperationAdditionType1;

  private ACRadioButtonItem shortStayHospitalRecuperationAdditionType2;

  private ACRadioButtonItem shortStayHospitalRecuperationAdditionType3;

  private ACRadioButtonItem shortStayHospitalRecuperationAdditionType4;

  private ACRadioButtonItem shortStayHospitalRecuperationAdditionTypeNone;

  private ACValueArrayRadioButtonGroup shortStayHospitalRecuperationAdditionTypeForShortstay;

  private ACLabelContainer shortStayHospitalRecuperationAdditionTypeForShortstayContainer;

  private ACListModelAdapter shortStayHospitalRecuperationAdditionTypeForShortstayModel;

  private ACRadioButtonItem shortStayHospitalRecuperationAdditionTypeForShortstayNormal;

  private ACRadioButtonItem shortStayHospitalRecuperationAdditionTypeForShortstayNone;

  private ACPanel tab2;

  private ACValueArrayRadioButtonGroup shortStayHospitalRecuperationSubtractionType;

  private ACLabelContainer shortStayHospitalRecuperationSubtractionTypeContainer;

  private ACListModelAdapter shortStayHospitalRecuperationSubtractionTypeModel;

  private ACRadioButtonItem shortStayHospitalRecuperationSubtractionTypeNormal;

  private ACRadioButtonItem shortStayHospitalRecuperationSubtractionType1;

  private ACRadioButtonItem shortStayHospitalRecuperationSubtractionType2;

  private ACValueArrayRadioButtonGroup shortStayHospitalRecuperationApplicationType;

  private ACLabelContainer shortStayHospitalRecuperationApplicationTypeContainer;

  private ACListModelAdapter shortStayHospitalRecuperationApplicationTypeModel;

  private ACRadioButtonItem shortStayHospitalRecuperationApplicationTypeNormal;

  private ACRadioButtonItem shortStayHospitalRecuperationApplicationType49;

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

  private ACValueArrayRadioButtonGroup shortStayHospitalRecuperationMeetingAndSendingOff;

  private ACLabelContainer shortStayHospitalRecuperationMeetingAndSendingOffContainer;

  private ACListModelAdapter shortStayHospitalRecuperationMeetingAndSendingOffModel;

  private ACRadioButtonItem shortStayHospitalRecuperationMeetingAndSendingOffNone;

  private ACRadioButtonItem shortStayHospitalRecuperationMeetingAndSendingOffOneWay;

  private ACRadioButtonItem shortStayHospitalRecuperationMeetingAndSendingOffRoundTrip;

  private ACValueArrayRadioButtonGroup shortStayHospitalRecuperationMedicalExpensesRadio;

  private ACLabelContainer shortStayHospitalRecuperationMedicalExpensesRadioContainer;

  private ACListModelAdapter shortStayHospitalRecuperationMedicalExpensesRadioModel;

  private ACRadioButtonItem shortStayHospitalRecuperationMedicalExpensesRadioItem1;

  private ACRadioButtonItem shortStayHospitalRecuperationMedicalExpensesRadioItem2;

  private ACMapBindButton shortStayHospitalRecuperationSpecificConsultationFee;

  private ACLabel shortStayHospitalRecuperationSpecificConsultationFeeOutline;

  private ACComboBox shortStayHospitalRecuperationPersonSubtraction;

  private ACLabelContainer shortStayHospitalRecuperationPersonSubtractionContainer;

  private ACComboBoxModelAdapter shortStayHospitalRecuperationPersonSubtractionModel;

  private ACPanel tab3;

  private ACBackLabelContainer shortStayRecuperationHealthFacilityDinnerContainer;

  private ACComboBox shortStayRecuperationHealthFacilityDinnerOffer;

  private ACLabelContainer shortStayRecuperationHealthFacilityDinnerOfferContainer;

  private ACComboBoxModelAdapter shortStayRecuperationHealthFacilityDinnerOfferModel;

  private ACTextField shortStayRecuperationHealthFacilityDinnerCost;

  private ACLabelContainer shortStayRecuperationHealthFacilityDinnerCostContainer;

  private ACIntegerCheckBox shortStayHospitalRecuperationEtc30Over;

  private ACValueArrayRadioButtonGroup shortStayHospitalRecuperationUnitCareMaintenanceRadio;

  private ACLabelContainer shortStayHospitalRecuperationUnitCareMaintenanceRadioContainer;

  private ACListModelAdapter shortStayHospitalRecuperationUnitCareMaintenanceRadioModel;

  private ACRadioButtonItem shortStayHospitalRecuperationUnitCareMaintenanceRadioItem1;

  private ACRadioButtonItem shortStayHospitalRecuperationUnitCareMaintenanceRadioItem2;

  private ACValueArrayRadioButtonGroup emergencyAcceptanceRadioGroup;

  private ACLabelContainer emergencyAcceptanceRadioGroupContainer;

  private ACListModelAdapter emergencyAcceptanceRadioGroupModel;

  private ACRadioButtonItem emergencyAcceptanceRadioItem1;

  private ACRadioButtonItem emergencyAcceptanceRadioItem2;

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
  public ACValueArrayRadioButtonGroup getShortStayHospitalRecuperationInstitutionDivisionRadio(){
    if(shortStayHospitalRecuperationInstitutionDivisionRadio==null){

      shortStayHospitalRecuperationInstitutionDivisionRadio = new ACValueArrayRadioButtonGroup();

      getShortStayHospitalRecuperationInstitutionDivisionRadioContainer().setText("�{�ݓ��̋敪");

      shortStayHospitalRecuperationInstitutionDivisionRadio.setBindPath("1230101");

      shortStayHospitalRecuperationInstitutionDivisionRadio.setNoSelectIndex(0);

      shortStayHospitalRecuperationInstitutionDivisionRadio.setUseClearButton(false);

      shortStayHospitalRecuperationInstitutionDivisionRadio.setModel(getShortStayHospitalRecuperationInstitutionDivisionRadioModel());

      shortStayHospitalRecuperationInstitutionDivisionRadio.setValues(new int[]{1,2,3,4,5});

      addShortStayHospitalRecuperationInstitutionDivisionRadio();
    }
    return shortStayHospitalRecuperationInstitutionDivisionRadio;

  }

  /**
   * �{�ݓ��̋敪�R���e�i���擾���܂��B
   * @return �{�ݓ��̋敪�R���e�i
   */
  protected ACLabelContainer getShortStayHospitalRecuperationInstitutionDivisionRadioContainer(){
    if(shortStayHospitalRecuperationInstitutionDivisionRadioContainer==null){
      shortStayHospitalRecuperationInstitutionDivisionRadioContainer = new ACLabelContainer();
      shortStayHospitalRecuperationInstitutionDivisionRadioContainer.setFollowChildEnabled(true);
      shortStayHospitalRecuperationInstitutionDivisionRadioContainer.setVAlignment(VRLayout.CENTER);
      shortStayHospitalRecuperationInstitutionDivisionRadioContainer.add(getShortStayHospitalRecuperationInstitutionDivisionRadio(), null);
    }
    return shortStayHospitalRecuperationInstitutionDivisionRadioContainer;
  }

  /**
   * �{�ݓ��̋敪���f�����擾���܂��B
   * @return �{�ݓ��̋敪���f��
   */
  protected ACListModelAdapter getShortStayHospitalRecuperationInstitutionDivisionRadioModel(){
    if(shortStayHospitalRecuperationInstitutionDivisionRadioModel==null){
      shortStayHospitalRecuperationInstitutionDivisionRadioModel = new ACListModelAdapter();
      addShortStayHospitalRecuperationInstitutionDivisionRadioModel();
    }
    return shortStayHospitalRecuperationInstitutionDivisionRadioModel;
  }

  /**
   * �a�@�×{�^���擾���܂��B
   * @return �a�@�×{�^
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationInstitutionDivisionRadioItem1(){
    if(shortStayHospitalRecuperationInstitutionDivisionRadioItem1==null){

      shortStayHospitalRecuperationInstitutionDivisionRadioItem1 = new ACRadioButtonItem();

      shortStayHospitalRecuperationInstitutionDivisionRadioItem1.setText("�a�@�×{�^");

      shortStayHospitalRecuperationInstitutionDivisionRadioItem1.setGroup(getShortStayHospitalRecuperationInstitutionDivisionRadio());

      shortStayHospitalRecuperationInstitutionDivisionRadioItem1.setConstraints(VRLayout.FLOW_RETURN);

      addShortStayHospitalRecuperationInstitutionDivisionRadioItem1();
    }
    return shortStayHospitalRecuperationInstitutionDivisionRadioItem1;

  }

  /**
   * ���j�b�g�^�a�@�×{�^���擾���܂��B
   * @return ���j�b�g�^�a�@�×{�^
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationInstitutionDivisionRadioItem2(){
    if(shortStayHospitalRecuperationInstitutionDivisionRadioItem2==null){

      shortStayHospitalRecuperationInstitutionDivisionRadioItem2 = new ACRadioButtonItem();

      shortStayHospitalRecuperationInstitutionDivisionRadioItem2.setText("���j�b�g�^�a�@�×{�^");

      shortStayHospitalRecuperationInstitutionDivisionRadioItem2.setGroup(getShortStayHospitalRecuperationInstitutionDivisionRadio());

      shortStayHospitalRecuperationInstitutionDivisionRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

      addShortStayHospitalRecuperationInstitutionDivisionRadioItem2();
    }
    return shortStayHospitalRecuperationInstitutionDivisionRadioItem2;

  }

  /**
   * �a�@�o�ߌ^���擾���܂��B
   * @return �a�@�o�ߌ^
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationInstitutionDivisionRadioItem4(){
    if(shortStayHospitalRecuperationInstitutionDivisionRadioItem4==null){

      shortStayHospitalRecuperationInstitutionDivisionRadioItem4 = new ACRadioButtonItem();

      shortStayHospitalRecuperationInstitutionDivisionRadioItem4.setText("�a�@�o�ߌ^");

      shortStayHospitalRecuperationInstitutionDivisionRadioItem4.setGroup(getShortStayHospitalRecuperationInstitutionDivisionRadio());

      shortStayHospitalRecuperationInstitutionDivisionRadioItem4.setConstraints(VRLayout.FLOW_RETURN);

      addShortStayHospitalRecuperationInstitutionDivisionRadioItem4();
    }
    return shortStayHospitalRecuperationInstitutionDivisionRadioItem4;

  }

  /**
   * ���j�b�g�^�a�@�o�ߌ^���擾���܂��B
   * @return ���j�b�g�^�a�@�o�ߌ^
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationInstitutionDivisionRadioItem5(){
    if(shortStayHospitalRecuperationInstitutionDivisionRadioItem5==null){

      shortStayHospitalRecuperationInstitutionDivisionRadioItem5 = new ACRadioButtonItem();

      shortStayHospitalRecuperationInstitutionDivisionRadioItem5.setText("���j�b�g�^�a�@�o�ߌ^");

      shortStayHospitalRecuperationInstitutionDivisionRadioItem5.setGroup(getShortStayHospitalRecuperationInstitutionDivisionRadio());

      shortStayHospitalRecuperationInstitutionDivisionRadioItem5.setConstraints(VRLayout.FLOW_RETURN);

      addShortStayHospitalRecuperationInstitutionDivisionRadioItem5();
    }
    return shortStayHospitalRecuperationInstitutionDivisionRadioItem5;

  }

  /**
   * ���A��V���[�g�X�e�C���擾���܂��B
   * @return ���A��V���[�g�X�e�C
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationInstitutionDivisionRadioItem3(){
    if(shortStayHospitalRecuperationInstitutionDivisionRadioItem3==null){

      shortStayHospitalRecuperationInstitutionDivisionRadioItem3 = new ACRadioButtonItem();

      shortStayHospitalRecuperationInstitutionDivisionRadioItem3.setText("���A��V���[�g�X�e�C");

      shortStayHospitalRecuperationInstitutionDivisionRadioItem3.setGroup(getShortStayHospitalRecuperationInstitutionDivisionRadio());

      shortStayHospitalRecuperationInstitutionDivisionRadioItem3.setConstraints(VRLayout.FLOW_RETURN);

      addShortStayHospitalRecuperationInstitutionDivisionRadioItem3();
    }
    return shortStayHospitalRecuperationInstitutionDivisionRadioItem3;

  }

  /**
   * �l���z�u�敪���擾���܂��B
   * @return �l���z�u�敪
   */
  public ACValueArrayRadioButtonGroup getShortStayHospitalRecuperationDivision(){
    if(shortStayHospitalRecuperationDivision==null){

      shortStayHospitalRecuperationDivision = new ACValueArrayRadioButtonGroup();

      getShortStayHospitalRecuperationDivisionContainer().setText("�l���z�u�敪");

      shortStayHospitalRecuperationDivision.setBindPath("1230102");

      shortStayHospitalRecuperationDivision.setUseClearButton(false);

      shortStayHospitalRecuperationDivision.setModel(getShortStayHospitalRecuperationDivisionModel());

      shortStayHospitalRecuperationDivision.setValues(new int[]{1,2,3});

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
      shortStayHospitalRecuperationDivisionContainer.setVAlignment(VRLayout.CENTER);
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
   * �a���敪�R���e�i(�V���[�g�X�e�C�ȊO�p)���擾���܂��B
   * @return �a���敪�R���e�i(�V���[�g�X�e�C�ȊO�p)
   */
  public ACLabelContainer getShortStayHospitalRecuperationHospitalRoomContena(){
    if(shortStayHospitalRecuperationHospitalRoomContena==null){

      shortStayHospitalRecuperationHospitalRoomContena = new ACLabelContainer();

      shortStayHospitalRecuperationHospitalRoomContena.setText("�a���敪");

      shortStayHospitalRecuperationHospitalRoomContena.setFollowChildEnabled(true);

      addShortStayHospitalRecuperationHospitalRoomContena();
    }
    return shortStayHospitalRecuperationHospitalRoomContena;

  }

  /**
   * �a���敪�i�a���j���擾���܂��B
   * @return �a���敪�i�a���j
   */
  public ACValueArrayRadioButtonGroup getShortStayHospitalRecuperationHospitalRoomRadio(){
    if(shortStayHospitalRecuperationHospitalRoomRadio==null){

      shortStayHospitalRecuperationHospitalRoomRadio = new ACValueArrayRadioButtonGroup();

      shortStayHospitalRecuperationHospitalRoomRadio.setBindPath("1230103");

      shortStayHospitalRecuperationHospitalRoomRadio.setUseClearButton(false);

      shortStayHospitalRecuperationHospitalRoomRadio.setModel(getShortStayHospitalRecuperationHospitalRoomRadioModel());

      shortStayHospitalRecuperationHospitalRoomRadio.setValues(new int[]{1,2});

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
  public ACValueArrayRadioButtonGroup getShortStayHospitalRecuperationUnitHospitalRoomRadio(){
    if(shortStayHospitalRecuperationUnitHospitalRoomRadio==null){

      shortStayHospitalRecuperationUnitHospitalRoomRadio = new ACValueArrayRadioButtonGroup();

      shortStayHospitalRecuperationUnitHospitalRoomRadio.setBindPath("1230104");

      shortStayHospitalRecuperationUnitHospitalRoomRadio.setUseClearButton(false);

      shortStayHospitalRecuperationUnitHospitalRoomRadio.setModel(getShortStayHospitalRecuperationUnitHospitalRoomRadioModel());

      shortStayHospitalRecuperationUnitHospitalRoomRadio.setValues(new int[]{1,2});

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
   * �a���敪���W�I(�V���[�g�X�e�C�p)���擾���܂��B
   * @return �a���敪���W�I(�V���[�g�X�e�C�p)
   */
  public ACValueArrayRadioButtonGroup getShortStayHospitalRecuperationSickroomDivisionRadio(){
    if(shortStayHospitalRecuperationSickroomDivisionRadio==null){

      shortStayHospitalRecuperationSickroomDivisionRadio = new ACValueArrayRadioButtonGroup();

      getShortStayHospitalRecuperationSickroomDivisionRadioContainer().setText("�a���敪");

      shortStayHospitalRecuperationSickroomDivisionRadio.setBindPath("1230113");

      shortStayHospitalRecuperationSickroomDivisionRadio.setUseClearButton(false);

      shortStayHospitalRecuperationSickroomDivisionRadio.setModel(getShortStayHospitalRecuperationSickroomDivisionRadioModel());

      shortStayHospitalRecuperationSickroomDivisionRadio.setValues(new int[]{1,2,3,4});

      addShortStayHospitalRecuperationSickroomDivisionRadio();
    }
    return shortStayHospitalRecuperationSickroomDivisionRadio;

  }

  /**
   * �a���敪���W�I(�V���[�g�X�e�C�p)�R���e�i���擾���܂��B
   * @return �a���敪���W�I(�V���[�g�X�e�C�p)�R���e�i
   */
  protected ACLabelContainer getShortStayHospitalRecuperationSickroomDivisionRadioContainer(){
    if(shortStayHospitalRecuperationSickroomDivisionRadioContainer==null){
      shortStayHospitalRecuperationSickroomDivisionRadioContainer = new ACLabelContainer();
      shortStayHospitalRecuperationSickroomDivisionRadioContainer.setFollowChildEnabled(true);
      shortStayHospitalRecuperationSickroomDivisionRadioContainer.setVAlignment(VRLayout.CENTER);
      shortStayHospitalRecuperationSickroomDivisionRadioContainer.add(getShortStayHospitalRecuperationSickroomDivisionRadio(), null);
    }
    return shortStayHospitalRecuperationSickroomDivisionRadioContainer;
  }

  /**
   * �a���敪���W�I(�V���[�g�X�e�C�p)���f�����擾���܂��B
   * @return �a���敪���W�I(�V���[�g�X�e�C�p)���f��
   */
  protected ACListModelAdapter getShortStayHospitalRecuperationSickroomDivisionRadioModel(){
    if(shortStayHospitalRecuperationSickroomDivisionRadioModel==null){
      shortStayHospitalRecuperationSickroomDivisionRadioModel = new ACListModelAdapter();
      addShortStayHospitalRecuperationSickroomDivisionRadioModel();
    }
    return shortStayHospitalRecuperationSickroomDivisionRadioModel;
  }

  /**
   * �]���^�����擾���܂��B
   * @return �]���^��
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationSickroomDivisionRadioItem1(){
    if(shortStayHospitalRecuperationSickroomDivisionRadioItem1==null){

      shortStayHospitalRecuperationSickroomDivisionRadioItem1 = new ACRadioButtonItem();

      shortStayHospitalRecuperationSickroomDivisionRadioItem1.setText("�]���^��");

      shortStayHospitalRecuperationSickroomDivisionRadioItem1.setGroup(getShortStayHospitalRecuperationSickroomDivisionRadio());

      shortStayHospitalRecuperationSickroomDivisionRadioItem1.setConstraints(VRLayout.FLOW);

      addShortStayHospitalRecuperationSickroomDivisionRadioItem1();
    }
    return shortStayHospitalRecuperationSickroomDivisionRadioItem1;

  }

  /**
   * ���������擾���܂��B
   * @return ������
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationSickroomDivisionRadioItem2(){
    if(shortStayHospitalRecuperationSickroomDivisionRadioItem2==null){

      shortStayHospitalRecuperationSickroomDivisionRadioItem2 = new ACRadioButtonItem();

      shortStayHospitalRecuperationSickroomDivisionRadioItem2.setText("������");

      shortStayHospitalRecuperationSickroomDivisionRadioItem2.setGroup(getShortStayHospitalRecuperationSickroomDivisionRadio());

      shortStayHospitalRecuperationSickroomDivisionRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

      addShortStayHospitalRecuperationSickroomDivisionRadioItem2();
    }
    return shortStayHospitalRecuperationSickroomDivisionRadioItem2;

  }

  /**
   * ���j�b�g�^�����擾���܂��B
   * @return ���j�b�g�^��
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationSickroomDivisionRadioItem3(){
    if(shortStayHospitalRecuperationSickroomDivisionRadioItem3==null){

      shortStayHospitalRecuperationSickroomDivisionRadioItem3 = new ACRadioButtonItem();

      shortStayHospitalRecuperationSickroomDivisionRadioItem3.setText("���j�b�g�^��");

      shortStayHospitalRecuperationSickroomDivisionRadioItem3.setGroup(getShortStayHospitalRecuperationSickroomDivisionRadio());

      shortStayHospitalRecuperationSickroomDivisionRadioItem3.setConstraints(VRLayout.FLOW);

      addShortStayHospitalRecuperationSickroomDivisionRadioItem3();
    }
    return shortStayHospitalRecuperationSickroomDivisionRadioItem3;

  }

  /**
   * ���j�b�g�^�������擾���܂��B
   * @return ���j�b�g�^����
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationSickroomDivisionRadioItem4(){
    if(shortStayHospitalRecuperationSickroomDivisionRadioItem4==null){

      shortStayHospitalRecuperationSickroomDivisionRadioItem4 = new ACRadioButtonItem();

      shortStayHospitalRecuperationSickroomDivisionRadioItem4.setText("���j�b�g�^����");

      shortStayHospitalRecuperationSickroomDivisionRadioItem4.setGroup(getShortStayHospitalRecuperationSickroomDivisionRadio());

      shortStayHospitalRecuperationSickroomDivisionRadioItem4.setConstraints(VRLayout.FLOW);

      addShortStayHospitalRecuperationSickroomDivisionRadioItem4();
    }
    return shortStayHospitalRecuperationSickroomDivisionRadioItem4;

  }

  /**
   * ���ԋ敪���擾���܂��B
   * @return ���ԋ敪
   */
  public ACComboBox getTankinyusyoTimeDivision(){
    if(tankinyusyoTimeDivision==null){

      tankinyusyoTimeDivision = new ACComboBox();

      getTankinyusyoTimeDivisionContainer().setText("���ԋ敪");

      tankinyusyoTimeDivision.setBindPath("1230117");

      tankinyusyoTimeDivision.setEditable(false);

      tankinyusyoTimeDivision.setModelBindPath("1230117");

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
   * ��ԋΖ������(�V���[�g�X�e�C�ȊO�p)���擾���܂��B
   * @return ��ԋΖ������(�V���[�g�X�e�C�ȊO�p)
   */
  public ACValueArrayRadioButtonGroup getShortStayHospitalRecuperationAdditionType(){
    if(shortStayHospitalRecuperationAdditionType==null){

      shortStayHospitalRecuperationAdditionType = new ACValueArrayRadioButtonGroup();

      getShortStayHospitalRecuperationAdditionTypeContainer().setText("��ԋΖ������");

      shortStayHospitalRecuperationAdditionType.setBindPath("1230105");

      shortStayHospitalRecuperationAdditionType.setUseClearButton(false);

      shortStayHospitalRecuperationAdditionType.setModel(getShortStayHospitalRecuperationAdditionTypeModel());

      shortStayHospitalRecuperationAdditionType.setValues(new int[]{1,2,3,4,6,5});

      addShortStayHospitalRecuperationAdditionType();
    }
    return shortStayHospitalRecuperationAdditionType;

  }

  /**
   * ��ԋΖ������(�V���[�g�X�e�C�ȊO�p)�R���e�i���擾���܂��B
   * @return ��ԋΖ������(�V���[�g�X�e�C�ȊO�p)�R���e�i
   */
  protected ACLabelContainer getShortStayHospitalRecuperationAdditionTypeContainer(){
    if(shortStayHospitalRecuperationAdditionTypeContainer==null){
      shortStayHospitalRecuperationAdditionTypeContainer = new ACLabelContainer();
      shortStayHospitalRecuperationAdditionTypeContainer.setFollowChildEnabled(true);
      shortStayHospitalRecuperationAdditionTypeContainer.setVAlignment(VRLayout.CENTER);
      shortStayHospitalRecuperationAdditionTypeContainer.add(getShortStayHospitalRecuperationAdditionType(), null);
    }
    return shortStayHospitalRecuperationAdditionTypeContainer;
  }

  /**
   * ��ԋΖ������(�V���[�g�X�e�C�ȊO�p)���f�����擾���܂��B
   * @return ��ԋΖ������(�V���[�g�X�e�C�ȊO�p)���f��
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
   * ���Z�^IV���擾���܂��B
   * @return ���Z�^IV
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationAdditionType4(){
    if(shortStayHospitalRecuperationAdditionType4==null){

      shortStayHospitalRecuperationAdditionType4 = new ACRadioButtonItem();

      shortStayHospitalRecuperationAdditionType4.setText("���Z�^IV");

      shortStayHospitalRecuperationAdditionType4.setGroup(getShortStayHospitalRecuperationAdditionType());

      shortStayHospitalRecuperationAdditionType4.setConstraints(VRLayout.FLOW);

      addShortStayHospitalRecuperationAdditionType4();
    }
    return shortStayHospitalRecuperationAdditionType4;

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
   * ��ԋΖ������(�V���[�g�X�e�C�p)���擾���܂��B
   * @return ��ԋΖ������(�V���[�g�X�e�C�p)
   */
  public ACValueArrayRadioButtonGroup getShortStayHospitalRecuperationAdditionTypeForShortstay(){
    if(shortStayHospitalRecuperationAdditionTypeForShortstay==null){

      shortStayHospitalRecuperationAdditionTypeForShortstay = new ACValueArrayRadioButtonGroup();

      getShortStayHospitalRecuperationAdditionTypeForShortstayContainer().setText("��ԋΖ������");

      shortStayHospitalRecuperationAdditionTypeForShortstay.setBindPath("1230118");

      shortStayHospitalRecuperationAdditionTypeForShortstay.setUseClearButton(false);

      shortStayHospitalRecuperationAdditionTypeForShortstay.setModel(getShortStayHospitalRecuperationAdditionTypeForShortstayModel());

      shortStayHospitalRecuperationAdditionTypeForShortstay.setValues(new int[]{1,2});

      addShortStayHospitalRecuperationAdditionTypeForShortstay();
    }
    return shortStayHospitalRecuperationAdditionTypeForShortstay;

  }

  /**
   * ��ԋΖ������(�V���[�g�X�e�C�p)�R���e�i���擾���܂��B
   * @return ��ԋΖ������(�V���[�g�X�e�C�p)�R���e�i
   */
  protected ACLabelContainer getShortStayHospitalRecuperationAdditionTypeForShortstayContainer(){
    if(shortStayHospitalRecuperationAdditionTypeForShortstayContainer==null){
      shortStayHospitalRecuperationAdditionTypeForShortstayContainer = new ACLabelContainer();
      shortStayHospitalRecuperationAdditionTypeForShortstayContainer.setFollowChildEnabled(true);
      shortStayHospitalRecuperationAdditionTypeForShortstayContainer.setVAlignment(VRLayout.CENTER);
      shortStayHospitalRecuperationAdditionTypeForShortstayContainer.add(getShortStayHospitalRecuperationAdditionTypeForShortstay(), null);
    }
    return shortStayHospitalRecuperationAdditionTypeForShortstayContainer;
  }

  /**
   * ��ԋΖ������(�V���[�g�X�e�C�p)���f�����擾���܂��B
   * @return ��ԋΖ������(�V���[�g�X�e�C�p)���f��
   */
  protected ACListModelAdapter getShortStayHospitalRecuperationAdditionTypeForShortstayModel(){
    if(shortStayHospitalRecuperationAdditionTypeForShortstayModel==null){
      shortStayHospitalRecuperationAdditionTypeForShortstayModel = new ACListModelAdapter();
      addShortStayHospitalRecuperationAdditionTypeForShortstayModel();
    }
    return shortStayHospitalRecuperationAdditionTypeForShortstayModel;
  }

  /**
   * �ʏ���擾���܂��B
   * @return �ʏ�
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationAdditionTypeForShortstayNormal(){
    if(shortStayHospitalRecuperationAdditionTypeForShortstayNormal==null){

      shortStayHospitalRecuperationAdditionTypeForShortstayNormal = new ACRadioButtonItem();

      shortStayHospitalRecuperationAdditionTypeForShortstayNormal.setText("��^");

      shortStayHospitalRecuperationAdditionTypeForShortstayNormal.setGroup(getShortStayHospitalRecuperationAdditionTypeForShortstay());

      shortStayHospitalRecuperationAdditionTypeForShortstayNormal.setConstraints(VRLayout.FLOW);

      addShortStayHospitalRecuperationAdditionTypeForShortstayNormal();
    }
    return shortStayHospitalRecuperationAdditionTypeForShortstayNormal;

  }

  /**
   * ���Z�^���擾���܂��B
   * @return ���Z�^
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationAdditionTypeForShortstayNone(){
    if(shortStayHospitalRecuperationAdditionTypeForShortstayNone==null){

      shortStayHospitalRecuperationAdditionTypeForShortstayNone = new ACRadioButtonItem();

      shortStayHospitalRecuperationAdditionTypeForShortstayNone.setText("���Z�^");

      shortStayHospitalRecuperationAdditionTypeForShortstayNone.setGroup(getShortStayHospitalRecuperationAdditionTypeForShortstay());

      shortStayHospitalRecuperationAdditionTypeForShortstayNone.setConstraints(VRLayout.FLOW);

      addShortStayHospitalRecuperationAdditionTypeForShortstayNone();
    }
    return shortStayHospitalRecuperationAdditionTypeForShortstayNone;

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
   * �×{�����Z���擾���܂��B
   * @return �×{�����Z
   */
  public ACValueArrayRadioButtonGroup getShortStayHospitalRecuperationSubtractionType(){
    if(shortStayHospitalRecuperationSubtractionType==null){

      shortStayHospitalRecuperationSubtractionType = new ACValueArrayRadioButtonGroup();

      getShortStayHospitalRecuperationSubtractionTypeContainer().setText("�×{�����Z");

      shortStayHospitalRecuperationSubtractionType.setBindPath("1230116");

      shortStayHospitalRecuperationSubtractionType.setNoSelectIndex(0);

      shortStayHospitalRecuperationSubtractionType.setUseClearButton(false);

      shortStayHospitalRecuperationSubtractionType.setModel(getShortStayHospitalRecuperationSubtractionTypeModel());

      shortStayHospitalRecuperationSubtractionType.setValues(new int[]{1,2,4});

      addShortStayHospitalRecuperationSubtractionType();
    }
    return shortStayHospitalRecuperationSubtractionType;

  }

  /**
   * �×{�����Z�R���e�i���擾���܂��B
   * @return �×{�����Z�R���e�i
   */
  protected ACLabelContainer getShortStayHospitalRecuperationSubtractionTypeContainer(){
    if(shortStayHospitalRecuperationSubtractionTypeContainer==null){
      shortStayHospitalRecuperationSubtractionTypeContainer = new ACLabelContainer();
      shortStayHospitalRecuperationSubtractionTypeContainer.setFollowChildEnabled(true);
      shortStayHospitalRecuperationSubtractionTypeContainer.setVAlignment(VRLayout.CENTER);
      shortStayHospitalRecuperationSubtractionTypeContainer.add(getShortStayHospitalRecuperationSubtractionType(), null);
    }
    return shortStayHospitalRecuperationSubtractionTypeContainer;
  }

  /**
   * �×{�����Z���f�����擾���܂��B
   * @return �×{�����Z���f��
   */
  protected ACListModelAdapter getShortStayHospitalRecuperationSubtractionTypeModel(){
    if(shortStayHospitalRecuperationSubtractionTypeModel==null){
      shortStayHospitalRecuperationSubtractionTypeModel = new ACListModelAdapter();
      addShortStayHospitalRecuperationSubtractionTypeModel();
    }
    return shortStayHospitalRecuperationSubtractionTypeModel;
  }

  /**
   * ��^���擾���܂��B
   * @return ��^
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
   * ���Z�^���擾���܂��B
   * @return ���Z�^
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationSubtractionType1(){
    if(shortStayHospitalRecuperationSubtractionType1==null){

      shortStayHospitalRecuperationSubtractionType1 = new ACRadioButtonItem();

      shortStayHospitalRecuperationSubtractionType1.setText("���Z�^");

      shortStayHospitalRecuperationSubtractionType1.setGroup(getShortStayHospitalRecuperationSubtractionType());

      shortStayHospitalRecuperationSubtractionType1.setConstraints(VRLayout.FLOW_RETURN);

      addShortStayHospitalRecuperationSubtractionType1();
    }
    return shortStayHospitalRecuperationSubtractionType1;

  }

  /**
   * ���Z�^III���擾���܂��B
   * @return ���Z�^III
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationSubtractionType2(){
    if(shortStayHospitalRecuperationSubtractionType2==null){

      shortStayHospitalRecuperationSubtractionType2 = new ACRadioButtonItem();

      shortStayHospitalRecuperationSubtractionType2.setText("���Z�^III");

      shortStayHospitalRecuperationSubtractionType2.setGroup(getShortStayHospitalRecuperationSubtractionType());

      shortStayHospitalRecuperationSubtractionType2.setConstraints(VRLayout.FLOW);

      addShortStayHospitalRecuperationSubtractionType2();
    }
    return shortStayHospitalRecuperationSubtractionType2;

  }

  /**
   * ��t�̔z�u����擾���܂��B
   * @return ��t�̔z�u�
   */
  public ACValueArrayRadioButtonGroup getShortStayHospitalRecuperationApplicationType(){
    if(shortStayHospitalRecuperationApplicationType==null){

      shortStayHospitalRecuperationApplicationType = new ACValueArrayRadioButtonGroup();

      getShortStayHospitalRecuperationApplicationTypeContainer().setText("��t�̔z�u�");

      shortStayHospitalRecuperationApplicationType.setBindPath("1230107");

      shortStayHospitalRecuperationApplicationType.setUseClearButton(false);

      shortStayHospitalRecuperationApplicationType.setModel(getShortStayHospitalRecuperationApplicationTypeModel());

      shortStayHospitalRecuperationApplicationType.setValues(new int[]{1,2});

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
      shortStayHospitalRecuperationApplicationTypeContainer.setVAlignment(VRLayout.CENTER);
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

      shortStayHospitalRecuperationApplicationTypeNormal.setConstraints(VRLayout.FLOW_RETURN);

      addShortStayHospitalRecuperationApplicationTypeNormal();
    }
    return shortStayHospitalRecuperationApplicationTypeNormal;

  }

  /**
   * ��Ö@�{�s�K����49��K�p���擾���܂��B
   * @return ��Ö@�{�s�K����49��K�p
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationApplicationType49(){
    if(shortStayHospitalRecuperationApplicationType49==null){

      shortStayHospitalRecuperationApplicationType49 = new ACRadioButtonItem();

      shortStayHospitalRecuperationApplicationType49.setText("��Ö@�{�s�K����49��K�p");

      shortStayHospitalRecuperationApplicationType49.setGroup(getShortStayHospitalRecuperationApplicationType());

      shortStayHospitalRecuperationApplicationType49.setConstraints(VRLayout.FLOW);

      addShortStayHospitalRecuperationApplicationType49();
    }
    return shortStayHospitalRecuperationApplicationType49;

  }

  /**
   * �F�m�Ǎs���E�S���Ǐ�ً}�Ή����Z���擾���܂��B
   * @return �F�m�Ǎs���E�S���Ǐ�ً}�Ή����Z
   */
  public ACValueArrayRadioButtonGroup getDementiaActionAddRadioGroup(){
    if(dementiaActionAddRadioGroup==null){

      dementiaActionAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getDementiaActionAddRadioGroupContainer().setText("�F�m�Ǎs���E" + ACConstants.LINE_SEPARATOR + "�S���Ǐ�ً}�Ή����Z" + ACConstants.LINE_SEPARATOR + "�i1����7�������x�j");

      dementiaActionAddRadioGroup.setBindPath("1230120");

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

      dementiaActionAddRadioItem2.setConstraints(VRLayout.FLOW);

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

      youngDementiaPatinetAddRadioGroup.setBindPath("1230114");

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
   * ���}���Z���擾���܂��B
   * @return ���}���Z
   */
  public ACValueArrayRadioButtonGroup getShortStayHospitalRecuperationMeetingAndSendingOff(){
    if(shortStayHospitalRecuperationMeetingAndSendingOff==null){

      shortStayHospitalRecuperationMeetingAndSendingOff = new ACValueArrayRadioButtonGroup();

      getShortStayHospitalRecuperationMeetingAndSendingOffContainer().setText("���}���Z");

      shortStayHospitalRecuperationMeetingAndSendingOff.setBindPath("6");

      shortStayHospitalRecuperationMeetingAndSendingOff.setUseClearButton(false);

      shortStayHospitalRecuperationMeetingAndSendingOff.setModel(getShortStayHospitalRecuperationMeetingAndSendingOffModel());

      shortStayHospitalRecuperationMeetingAndSendingOff.setValues(new int[]{1,2,3});

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
      shortStayHospitalRecuperationMeetingAndSendingOffContainer.setVAlignment(VRLayout.CENTER);
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
   * �×{�H���Z���擾���܂��B
   * @return �×{�H���Z
   */
  public ACValueArrayRadioButtonGroup getShortStayHospitalRecuperationMedicalExpensesRadio(){
    if(shortStayHospitalRecuperationMedicalExpensesRadio==null){

      shortStayHospitalRecuperationMedicalExpensesRadio = new ACValueArrayRadioButtonGroup();

      getShortStayHospitalRecuperationMedicalExpensesRadioContainer().setText("�×{�H���Z");

      shortStayHospitalRecuperationMedicalExpensesRadio.setBindPath("1230110");

      shortStayHospitalRecuperationMedicalExpensesRadio.setUseClearButton(false);

      shortStayHospitalRecuperationMedicalExpensesRadio.setModel(getShortStayHospitalRecuperationMedicalExpensesRadioModel());

      shortStayHospitalRecuperationMedicalExpensesRadio.setValues(new int[]{1,2});

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
      shortStayHospitalRecuperationMedicalExpensesRadioContainer.setVAlignment(VRLayout.CENTER);
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

      shortStayHospitalRecuperationPersonSubtraction.setRenderBindPath("CONTENT");

      shortStayHospitalRecuperationPersonSubtraction.setModel(getShortStayHospitalRecuperationPersonSubtractionModel());

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
      shortStayHospitalRecuperationPersonSubtractionContainer.setVAlignment(VRLayout.CENTER);
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
   * �H���R���e�i���擾���܂��B
   * @return �H���R���e�i
   */
  public ACBackLabelContainer getShortStayRecuperationHealthFacilityDinnerContainer(){
    if(shortStayRecuperationHealthFacilityDinnerContainer==null){

      shortStayRecuperationHealthFacilityDinnerContainer = new ACBackLabelContainer();

      shortStayRecuperationHealthFacilityDinnerContainer.setFollowChildEnabled(true);

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
      shortStayRecuperationHealthFacilityDinnerCostContainer.setVAlignment(VRLayout.CENTER);
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

      shortStayHospitalRecuperationEtc30Over.setSelectValue(2);

      shortStayHospitalRecuperationEtc30Over.setUnSelectValue(1);

      addShortStayHospitalRecuperationEtc30Over();
    }
    return shortStayHospitalRecuperationEtc30Over;

  }

  /**
   * ���j�b�g�P�A�̐������擾���܂��B
   * @return ���j�b�g�P�A�̐���
   */
  public ACValueArrayRadioButtonGroup getShortStayHospitalRecuperationUnitCareMaintenanceRadio(){
    if(shortStayHospitalRecuperationUnitCareMaintenanceRadio==null){

      shortStayHospitalRecuperationUnitCareMaintenanceRadio = new ACValueArrayRadioButtonGroup();

      getShortStayHospitalRecuperationUnitCareMaintenanceRadioContainer().setText("���j�b�g�P�A�̐���");

      shortStayHospitalRecuperationUnitCareMaintenanceRadio.setBindPath("1230111");

      shortStayHospitalRecuperationUnitCareMaintenanceRadio.setUseClearButton(false);

      shortStayHospitalRecuperationUnitCareMaintenanceRadio.setModel(getShortStayHospitalRecuperationUnitCareMaintenanceRadioModel());

      shortStayHospitalRecuperationUnitCareMaintenanceRadio.setValues(new int[]{1,2});

      addShortStayHospitalRecuperationUnitCareMaintenanceRadio();
    }
    return shortStayHospitalRecuperationUnitCareMaintenanceRadio;

  }

  /**
   * ���j�b�g�P�A�̐����R���e�i���擾���܂��B
   * @return ���j�b�g�P�A�̐����R���e�i
   */
  protected ACLabelContainer getShortStayHospitalRecuperationUnitCareMaintenanceRadioContainer(){
    if(shortStayHospitalRecuperationUnitCareMaintenanceRadioContainer==null){
      shortStayHospitalRecuperationUnitCareMaintenanceRadioContainer = new ACLabelContainer();
      shortStayHospitalRecuperationUnitCareMaintenanceRadioContainer.setFollowChildEnabled(true);
      shortStayHospitalRecuperationUnitCareMaintenanceRadioContainer.setVAlignment(VRLayout.CENTER);
      shortStayHospitalRecuperationUnitCareMaintenanceRadioContainer.add(getShortStayHospitalRecuperationUnitCareMaintenanceRadio(), null);
    }
    return shortStayHospitalRecuperationUnitCareMaintenanceRadioContainer;
  }

  /**
   * ���j�b�g�P�A�̐������f�����擾���܂��B
   * @return ���j�b�g�P�A�̐������f��
   */
  protected ACListModelAdapter getShortStayHospitalRecuperationUnitCareMaintenanceRadioModel(){
    if(shortStayHospitalRecuperationUnitCareMaintenanceRadioModel==null){
      shortStayHospitalRecuperationUnitCareMaintenanceRadioModel = new ACListModelAdapter();
      addShortStayHospitalRecuperationUnitCareMaintenanceRadioModel();
    }
    return shortStayHospitalRecuperationUnitCareMaintenanceRadioModel;
  }

  /**
   * ���������擾���܂��B
   * @return ������
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationUnitCareMaintenanceRadioItem1(){
    if(shortStayHospitalRecuperationUnitCareMaintenanceRadioItem1==null){

      shortStayHospitalRecuperationUnitCareMaintenanceRadioItem1 = new ACRadioButtonItem();

      shortStayHospitalRecuperationUnitCareMaintenanceRadioItem1.setText("������");

      shortStayHospitalRecuperationUnitCareMaintenanceRadioItem1.setGroup(getShortStayHospitalRecuperationUnitCareMaintenanceRadio());

      shortStayHospitalRecuperationUnitCareMaintenanceRadioItem1.setConstraints(VRLayout.FLOW);

      addShortStayHospitalRecuperationUnitCareMaintenanceRadioItem1();
    }
    return shortStayHospitalRecuperationUnitCareMaintenanceRadioItem1;

  }

  /**
   * �������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationUnitCareMaintenanceRadioItem2(){
    if(shortStayHospitalRecuperationUnitCareMaintenanceRadioItem2==null){

      shortStayHospitalRecuperationUnitCareMaintenanceRadioItem2 = new ACRadioButtonItem();

      shortStayHospitalRecuperationUnitCareMaintenanceRadioItem2.setText("����");

      shortStayHospitalRecuperationUnitCareMaintenanceRadioItem2.setGroup(getShortStayHospitalRecuperationUnitCareMaintenanceRadio());

      shortStayHospitalRecuperationUnitCareMaintenanceRadioItem2.setConstraints(VRLayout.FLOW);

      addShortStayHospitalRecuperationUnitCareMaintenanceRadioItem2();
    }
    return shortStayHospitalRecuperationUnitCareMaintenanceRadioItem2;

  }

  /**
   * �ً}�Z������������Z���擾���܂��B
   * @return �ً}�Z������������Z
   */
  public ACValueArrayRadioButtonGroup getEmergencyAcceptanceRadioGroup(){
    if(emergencyAcceptanceRadioGroup==null){

      emergencyAcceptanceRadioGroup = new ACValueArrayRadioButtonGroup();

      getEmergencyAcceptanceRadioGroupContainer().setText("�ً}�Z������������Z" + ACConstants.LINE_SEPARATOR + "�i1����7�������x�j");

      emergencyAcceptanceRadioGroup.setBindPath("1230121");

      emergencyAcceptanceRadioGroup.setUseClearButton(false);

      emergencyAcceptanceRadioGroup.setModel(getEmergencyAcceptanceRadioGroupModel());

      emergencyAcceptanceRadioGroup.setValues(new int[]{1,2});

      addEmergencyAcceptanceRadioGroup();
    }
    return emergencyAcceptanceRadioGroup;

  }

  /**
   * �ً}�Z������������Z�R���e�i���擾���܂��B
   * @return �ً}�Z������������Z�R���e�i
   */
  protected ACLabelContainer getEmergencyAcceptanceRadioGroupContainer(){
    if(emergencyAcceptanceRadioGroupContainer==null){
      emergencyAcceptanceRadioGroupContainer = new ACLabelContainer();
      emergencyAcceptanceRadioGroupContainer.setFollowChildEnabled(true);
      emergencyAcceptanceRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      emergencyAcceptanceRadioGroupContainer.add(getEmergencyAcceptanceRadioGroup(), null);
    }
    return emergencyAcceptanceRadioGroupContainer;
  }

  /**
   * �ً}�Z������������Z���f�����擾���܂��B
   * @return �ً}�Z������������Z���f��
   */
  protected ACListModelAdapter getEmergencyAcceptanceRadioGroupModel(){
    if(emergencyAcceptanceRadioGroupModel==null){
      emergencyAcceptanceRadioGroupModel = new ACListModelAdapter();
      addEmergencyAcceptanceRadioGroupModel();
    }
    return emergencyAcceptanceRadioGroupModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getEmergencyAcceptanceRadioItem1(){
    if(emergencyAcceptanceRadioItem1==null){

      emergencyAcceptanceRadioItem1 = new ACRadioButtonItem();

      emergencyAcceptanceRadioItem1.setText("�Ȃ�");

      emergencyAcceptanceRadioItem1.setGroup(getEmergencyAcceptanceRadioGroup());

      emergencyAcceptanceRadioItem1.setConstraints(VRLayout.FLOW);

      addEmergencyAcceptanceRadioItem1();
    }
    return emergencyAcceptanceRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getEmergencyAcceptanceRadioItem2(){
    if(emergencyAcceptanceRadioItem2==null){

      emergencyAcceptanceRadioItem2 = new ACRadioButtonItem();

      emergencyAcceptanceRadioItem2.setText("����");

      emergencyAcceptanceRadioItem2.setGroup(getEmergencyAcceptanceRadioGroup());

      emergencyAcceptanceRadioItem2.setConstraints(VRLayout.FLOW);

      addEmergencyAcceptanceRadioItem2();
    }
    return emergencyAcceptanceRadioItem2;

  }

  /**
   * �T�[�r�X�񋟑̐��������Z���擾���܂��B
   * @return �T�[�r�X�񋟑̐��������Z
   */
  public ACValueArrayRadioButtonGroup getServiceAddProvisionStructuralRadioGroup(){
    if(serviceAddProvisionStructuralRadioGroup==null){

      serviceAddProvisionStructuralRadioGroup = new ACValueArrayRadioButtonGroup();

      getServiceAddProvisionStructuralRadioGroupContainer().setText("�T�[�r�X�񋟑̐��������Z");

      serviceAddProvisionStructuralRadioGroup.setBindPath("1230115");

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
  public QS001_12311_201204Design() {

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

    tab1.add(getShortStayHospitalRecuperationInstitutionDivisionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getShortStayHospitalRecuperationDivisionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getShortStayHospitalRecuperationHospitalRoomContena(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getShortStayHospitalRecuperationSickroomDivisionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getTankinyusyoTimeDivisionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getShortStayHospitalRecuperationAdditionTypeContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getShortStayHospitalRecuperationAdditionTypeForShortstayContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * �{�ݓ��̋敪�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationInstitutionDivisionRadio(){

  }

  /**
   * �{�ݓ��̋敪���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationInstitutionDivisionRadioModel(){

    getShortStayHospitalRecuperationInstitutionDivisionRadioItem1().setButtonIndex(1);

    getShortStayHospitalRecuperationInstitutionDivisionRadioModel().add(getShortStayHospitalRecuperationInstitutionDivisionRadioItem1());

    getShortStayHospitalRecuperationInstitutionDivisionRadioItem2().setButtonIndex(2);

    getShortStayHospitalRecuperationInstitutionDivisionRadioModel().add(getShortStayHospitalRecuperationInstitutionDivisionRadioItem2());

    getShortStayHospitalRecuperationInstitutionDivisionRadioItem4().setButtonIndex(3);

    getShortStayHospitalRecuperationInstitutionDivisionRadioModel().add(getShortStayHospitalRecuperationInstitutionDivisionRadioItem4());

    getShortStayHospitalRecuperationInstitutionDivisionRadioItem5().setButtonIndex(4);

    getShortStayHospitalRecuperationInstitutionDivisionRadioModel().add(getShortStayHospitalRecuperationInstitutionDivisionRadioItem5());

    getShortStayHospitalRecuperationInstitutionDivisionRadioItem3().setButtonIndex(5);

    getShortStayHospitalRecuperationInstitutionDivisionRadioModel().add(getShortStayHospitalRecuperationInstitutionDivisionRadioItem3());

  }

  /**
   * �a�@�×{�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationInstitutionDivisionRadioItem1(){

  }

  /**
   * ���j�b�g�^�a�@�×{�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationInstitutionDivisionRadioItem2(){

  }

  /**
   * �a�@�o�ߌ^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationInstitutionDivisionRadioItem4(){

  }

  /**
   * ���j�b�g�^�a�@�o�ߌ^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationInstitutionDivisionRadioItem5(){

  }

  /**
   * ���A��V���[�g�X�e�C�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationInstitutionDivisionRadioItem3(){

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
   * �a���敪�R���e�i(�V���[�g�X�e�C�ȊO�p)�ɓ������ڂ�ǉ����܂��B
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
   * �a���敪���W�I(�V���[�g�X�e�C�p)�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationSickroomDivisionRadio(){

  }

  /**
   * �a���敪���W�I(�V���[�g�X�e�C�p)���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationSickroomDivisionRadioModel(){

    getShortStayHospitalRecuperationSickroomDivisionRadioItem1().setButtonIndex(1);

    getShortStayHospitalRecuperationSickroomDivisionRadioModel().add(getShortStayHospitalRecuperationSickroomDivisionRadioItem1());

    getShortStayHospitalRecuperationSickroomDivisionRadioItem2().setButtonIndex(2);

    getShortStayHospitalRecuperationSickroomDivisionRadioModel().add(getShortStayHospitalRecuperationSickroomDivisionRadioItem2());

    getShortStayHospitalRecuperationSickroomDivisionRadioItem3().setButtonIndex(3);

    getShortStayHospitalRecuperationSickroomDivisionRadioModel().add(getShortStayHospitalRecuperationSickroomDivisionRadioItem3());

    getShortStayHospitalRecuperationSickroomDivisionRadioItem4().setButtonIndex(4);

    getShortStayHospitalRecuperationSickroomDivisionRadioModel().add(getShortStayHospitalRecuperationSickroomDivisionRadioItem4());

  }

  /**
   * �]���^���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationSickroomDivisionRadioItem1(){

  }

  /**
   * �������ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationSickroomDivisionRadioItem2(){

  }

  /**
   * ���j�b�g�^���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationSickroomDivisionRadioItem3(){

  }

  /**
   * ���j�b�g�^�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationSickroomDivisionRadioItem4(){

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
   * ��ԋΖ������(�V���[�g�X�e�C�ȊO�p)�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationAdditionType(){

  }

  /**
   * ��ԋΖ������(�V���[�g�X�e�C�ȊO�p)���f���ɓ������ڂ�ǉ����܂��B
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

    getShortStayHospitalRecuperationAdditionType4().setButtonIndex(6);

    getShortStayHospitalRecuperationAdditionTypeModel().add(getShortStayHospitalRecuperationAdditionType4());

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
   * ���Z�^IV�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationAdditionType4(){

  }

  /**
   * ���Z�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationAdditionTypeNone(){

  }

  /**
   * ��ԋΖ������(�V���[�g�X�e�C�p)�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationAdditionTypeForShortstay(){

  }

  /**
   * ��ԋΖ������(�V���[�g�X�e�C�p)���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationAdditionTypeForShortstayModel(){

    getShortStayHospitalRecuperationAdditionTypeForShortstayNormal().setButtonIndex(1);

    getShortStayHospitalRecuperationAdditionTypeForShortstayModel().add(getShortStayHospitalRecuperationAdditionTypeForShortstayNormal());

    getShortStayHospitalRecuperationAdditionTypeForShortstayNone().setButtonIndex(2);

    getShortStayHospitalRecuperationAdditionTypeForShortstayModel().add(getShortStayHospitalRecuperationAdditionTypeForShortstayNone());

  }

  /**
   * �ʏ�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationAdditionTypeForShortstayNormal(){

  }

  /**
   * ���Z�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationAdditionTypeForShortstayNone(){

  }

  /**
   * �^�u2�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTab2(){

    tab2.add(getShortStayHospitalRecuperationSubtractionTypeContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getShortStayHospitalRecuperationApplicationTypeContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getDementiaActionAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getYoungDementiaPatinetAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getShortStayHospitalRecuperationMeetingAndSendingOffContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getShortStayHospitalRecuperationMedicalExpensesRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getShortStayHospitalRecuperationSpecificConsultationFee(), VRLayout.FLOW);

    tab2.add(getShortStayHospitalRecuperationSpecificConsultationFeeOutline(), VRLayout.FLOW_RETURN);

    tab2.add(getShortStayHospitalRecuperationPersonSubtractionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * �×{�����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationSubtractionType(){

  }

  /**
   * �×{�����Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationSubtractionTypeModel(){

    getShortStayHospitalRecuperationSubtractionTypeNormal().setButtonIndex(1);

    getShortStayHospitalRecuperationSubtractionTypeModel().add(getShortStayHospitalRecuperationSubtractionTypeNormal());

    getShortStayHospitalRecuperationSubtractionType1().setButtonIndex(2);

    getShortStayHospitalRecuperationSubtractionTypeModel().add(getShortStayHospitalRecuperationSubtractionType1());

    getShortStayHospitalRecuperationSubtractionType2().setButtonIndex(4);

    getShortStayHospitalRecuperationSubtractionTypeModel().add(getShortStayHospitalRecuperationSubtractionType2());

  }

  /**
   * ��^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationSubtractionTypeNormal(){

  }

  /**
   * ���Z�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationSubtractionType1(){

  }

  /**
   * ���Z�^III�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationSubtractionType2(){

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
   * ��Ö@�{�s�K����49��K�p�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationApplicationType49(){

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
   * �^�u3�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTab3(){

    tab3.add(getShortStayRecuperationHealthFacilityDinnerContainer(), VRLayout.FLOW_DOUBLEINSETLINE_RETURN);

    tab3.add(getShortStayHospitalRecuperationEtc30Over(), VRLayout.FLOW_INSETLINE);

    tab3.add(getShortStayHospitalRecuperationUnitCareMaintenanceRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab3.add(getEmergencyAcceptanceRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab3.add(getServiceAddProvisionStructuralRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

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
   * ���j�b�g�P�A�̐����ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationUnitCareMaintenanceRadio(){

  }

  /**
   * ���j�b�g�P�A�̐������f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationUnitCareMaintenanceRadioModel(){

    getShortStayHospitalRecuperationUnitCareMaintenanceRadioItem1().setButtonIndex(1);

    getShortStayHospitalRecuperationUnitCareMaintenanceRadioModel().add(getShortStayHospitalRecuperationUnitCareMaintenanceRadioItem1());

    getShortStayHospitalRecuperationUnitCareMaintenanceRadioItem2().setButtonIndex(2);

    getShortStayHospitalRecuperationUnitCareMaintenanceRadioModel().add(getShortStayHospitalRecuperationUnitCareMaintenanceRadioItem2());

  }

  /**
   * �������ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationUnitCareMaintenanceRadioItem1(){

  }

  /**
   * �����ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayHospitalRecuperationUnitCareMaintenanceRadioItem2(){

  }

  /**
   * �ً}�Z������������Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addEmergencyAcceptanceRadioGroup(){

  }

  /**
   * �ً}�Z������������Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addEmergencyAcceptanceRadioGroupModel(){

    getEmergencyAcceptanceRadioItem1().setButtonIndex(1);

    getEmergencyAcceptanceRadioGroupModel().add(getEmergencyAcceptanceRadioItem1());

    getEmergencyAcceptanceRadioItem2().setButtonIndex(2);

    getEmergencyAcceptanceRadioGroupModel().add(getEmergencyAcceptanceRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addEmergencyAcceptanceRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addEmergencyAcceptanceRadioItem2(){

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
      ACFrame.debugStart(new ACAffairInfo(QS001_12311_201204Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QS001_12311_201204Design getThis() {
    return this;
  }
}
