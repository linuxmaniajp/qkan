
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
 * �J����: ���{�@�K��
 * �쐬��: 2006/04/11  ���{�R���s���[�^�[������� ���{�@�K�� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �T�[�r�X�\��쐬/�ύX (S)
 * �v���Z�X �T�[�r�X�\��T�� (001)
 * �v���O���� �T�[�r�X�p�^�[���Z�������×{���i�f�Ï��×{�j (QS001112)
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
 * �T�[�r�X�p�^�[���Z�������×{���i�f�Ï��×{�j��ʍ��ڃf�U�C��(QS001112) 
 */
public class QS001112Design extends QS001ServicePanel {
  //GUI�R���|�[�l���g

  private JTabbedPane tabs;

  private ACPanel tab1;

  private ACClearableRadioButtonGroup shortStayClinicRecuperationInstitutionDivisionRadio;

  private ACLabelContainer shortStayClinicRecuperationInstitutionDivisionRadioContainer;

  private ACListModelAdapter shortStayClinicRecuperationInstitutionDivisionRadioModel;

  private ACRadioButtonItem shortStayClinicRecuperationInstitutionDivisionRadioItem1;

  private ACRadioButtonItem shortStayClinicRecuperationInstitutionDivisionRadioItem2;

  private ACRadioButtonItem shortStayClinicRecuperationInstitutionDivisionRadioItem3;

  private ACClearableRadioButtonGroup shortStayClinicRecuperationDivision;

  private ACLabelContainer shortStayClinicRecuperationDivisionContainer;

  private ACListModelAdapter shortStayClinicRecuperationDivisionModel;

  private ACRadioButtonItem shortStayClinicRecuperationType1;

  private ACRadioButtonItem shortStayClinicRecuperationType2;

  private ACLabelContainer shortStayClinicRecuperationHospitalRoomContena;

  private ACClearableRadioButtonGroup shortStayClinicRecuperationHospitalRoomRadio;

  private ACListModelAdapter shortStayClinicRecuperationHospitalRoomRadioModel;

  private ACRadioButtonItem shortStayClinicRecuperationHospitalRoomRadioItem1;

  private ACRadioButtonItem shortStayClinicRecuperationHospitalRoomRadioItem2;

  private ACClearableRadioButtonGroup shortStayClinicRecuperationUnitHospitalRoomRadio;

  private ACListModelAdapter shortStayClinicRecuperationUnitHospitalRoomRadioModel;

  private ACRadioButtonItem shortStayClinicRecuperationUnitHospitalRoomRadioItem1;

  private ACRadioButtonItem shortStayClinicRecuperationUnitHospitalRoomRadioItem2;

  private ACClearableRadioButtonGroup shortStayClinicRecuperationSickroomDivisionRadio;

  private ACLabelContainer shortStayClinicRecuperationSickroomDivisionRadioContainer;

  private ACListModelAdapter shortStayClinicRecuperationSickroomDivisionRadioModel;

  private ACRadioButtonItem shortStayClinicRecuperationSickroomDivisionRadioItem1;

  private ACRadioButtonItem shortStayClinicRecuperationSickroomDivisionRadioItem2;

  private ACRadioButtonItem shortStayClinicRecuperationSickroomDivisionRadioItem3;

  private ACRadioButtonItem shortStayClinicRecuperationSickroomDivisionRadioItem4;

  private ACClearableRadioButtonGroup shortStayClinicRecuperationSubtractionType;

  private ACLabelContainer shortStayClinicRecuperationSubtractionTypeContainer;

  private ACListModelAdapter shortStayClinicRecuperationSubtractionTypeModel;

  private ACRadioButtonItem shortStayClinicRecuperationSubtractionTypeNormal;

  private ACRadioButtonItem shortStayClinicRecuperationSubtractionType1;

  private ACRadioButtonItem shortStayClinicRecuperationSubtractionType2;

  private ACClearableRadioButtonGroup shortStayClinicRecuperationMeetingAndSendingOff;

  private ACLabelContainer shortStayClinicRecuperationMeetingAndSendingOffContainer;

  private ACListModelAdapter shortStayClinicRecuperationMeetingAndSendingOffModel;

  private ACRadioButtonItem shortStayClinicRecuperationMeetingAndSendingOffNone;

  private ACRadioButtonItem shortStayClinicRecuperationMeetingAndSendingOffOneWay;

  private ACRadioButtonItem shortStayClinicRecuperationMeetingAndSendingOffRoundTrip;

  private ACClearableRadioButtonGroup shortStayClinicRecuperationDieticianManageRadio;

  private ACLabelContainer shortStayClinicRecuperationDieticianManageRadioContainer;

  private ACListModelAdapter shortStayClinicRecuperationDieticianManageRadioModel;

  private ACRadioButtonItem shortStayClinicRecuperationDieticianManageRadioItem1;

  private ACRadioButtonItem shortStayClinicRecuperationDieticianManageRadioItem2;

  private ACRadioButtonItem shortStayClinicRecuperationDieticianManageRadioItem3;

  private ACClearableRadioButtonGroup shortStayClinicRecuperationMedicalExpensesRadio;

  private ACLabelContainer shortStayClinicRecuperationMedicalExpensesRadioContainer;

  private ACListModelAdapter shortStayClinicRecuperationMedicalExpensesRadioModel;

  private ACRadioButtonItem shortStayClinicRecuperationMedicalExpensesRadioItem1;

  private ACRadioButtonItem shortStayClinicRecuperationMedicalExpensesRadioItem2;

  private ACClearableRadioButtonGroup shortStayClinicRecuperationStaffReduceRadio;

  private ACLabelContainer shortStayClinicRecuperationStaffReduceRadioContainer;

  private ACListModelAdapter shortStayClinicRecuperationStaffReduceRadioModel;

  private ACRadioButtonItem shortStayClinicRecuperationStaffReduceRadioItem1;

  private ACRadioButtonItem shortStayClinicRecuperationStaffReduceRadioItem2;

  private ACPanel tab2;

  private ACMapBindButton shortStayClinicRecuperationSpecificConsultationFee;

  private ACLabel shortStayClinicRecuperationSpecificConsultationFeeOutline;

  private ACBackLabelContainer shortStayClinicRecuperationDinnerContainer;

  private ACComboBox shortStayClinicRecuperationDinnerOffer;

  private ACLabelContainer shortStayClinicRecuperationDinnerOfferContainer;

  private ACComboBoxModelAdapter shortStayClinicRecuperationDinnerOfferModel;

  private ACTextField shortStayClinicRecuperationDinnerCost;

  private ACLabelContainer shortStayClinicRecuperationDinnerCostContainer;

  private ACIntegerCheckBox shortStayClinicRecuperationEtc30Over;

  private ACClearableRadioButtonGroup shortStayClinicRecuperationUnitCareMaintenanceRadio;

  private ACLabelContainer shortStayClinicRecuperationUnitCareMaintenanceRadioContainer;

  private ACListModelAdapter shortStayClinicRecuperationUnitCareMaintenanceRadioModel;

  private ACRadioButtonItem shortStayClinicRecuperationUnitCareMaintenanceRadioitem1;

  private ACRadioButtonItem shortStayClinicRecuperationUnitCareMaintenanceRadioitem2;

  private ACClearableRadioButtonGroup shortStayClinicRecuperationEmergencyNetworkAddRadio;

  private ACLabelContainer shortStayClinicRecuperationEmergencyNetworkAddRadioContainer;

  private ACListModelAdapter shortStayClinicRecuperationEmergencyNetworkAddRadioModel;

  private ACRadioButtonItem shortStayClinicRecuperationEmergencyNetworkAddRadioItem1;

  private ACRadioButtonItem shortStayClinicRecuperationEmergencyNetworkAddRadioItem2;

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
  public ACClearableRadioButtonGroup getShortStayClinicRecuperationInstitutionDivisionRadio(){
    if(shortStayClinicRecuperationInstitutionDivisionRadio==null){

      shortStayClinicRecuperationInstitutionDivisionRadio = new ACClearableRadioButtonGroup();

      getShortStayClinicRecuperationInstitutionDivisionRadioContainer().setText("�{�ݓ��̋敪");

      shortStayClinicRecuperationInstitutionDivisionRadio.setBindPath("1230201");

      shortStayClinicRecuperationInstitutionDivisionRadio.setUseClearButton(false);

      shortStayClinicRecuperationInstitutionDivisionRadio.setModel(getShortStayClinicRecuperationInstitutionDivisionRadioModel());

      addShortStayClinicRecuperationInstitutionDivisionRadio();
    }
    return shortStayClinicRecuperationInstitutionDivisionRadio;

  }

  /**
   * �{�ݓ��̋敪�R���e�i���擾���܂��B
   * @return �{�ݓ��̋敪�R���e�i
   */
  protected ACLabelContainer getShortStayClinicRecuperationInstitutionDivisionRadioContainer(){
    if(shortStayClinicRecuperationInstitutionDivisionRadioContainer==null){
      shortStayClinicRecuperationInstitutionDivisionRadioContainer = new ACLabelContainer();
      shortStayClinicRecuperationInstitutionDivisionRadioContainer.setFollowChildEnabled(true);
      shortStayClinicRecuperationInstitutionDivisionRadioContainer.setVAlignment(VRLayout.CENTER);
      shortStayClinicRecuperationInstitutionDivisionRadioContainer.add(getShortStayClinicRecuperationInstitutionDivisionRadio(), null);
    }
    return shortStayClinicRecuperationInstitutionDivisionRadioContainer;
  }

  /**
   * �{�ݓ��̋敪���f�����擾���܂��B
   * @return �{�ݓ��̋敪���f��
   */
  protected ACListModelAdapter getShortStayClinicRecuperationInstitutionDivisionRadioModel(){
    if(shortStayClinicRecuperationInstitutionDivisionRadioModel==null){
      shortStayClinicRecuperationInstitutionDivisionRadioModel = new ACListModelAdapter();
      addShortStayClinicRecuperationInstitutionDivisionRadioModel();
    }
    return shortStayClinicRecuperationInstitutionDivisionRadioModel;
  }

  /**
   * �f�Ï����擾���܂��B
   * @return �f�Ï�
   */
  public ACRadioButtonItem getShortStayClinicRecuperationInstitutionDivisionRadioItem1(){
    if(shortStayClinicRecuperationInstitutionDivisionRadioItem1==null){

      shortStayClinicRecuperationInstitutionDivisionRadioItem1 = new ACRadioButtonItem();

      shortStayClinicRecuperationInstitutionDivisionRadioItem1.setText("�f�Ï�");

      shortStayClinicRecuperationInstitutionDivisionRadioItem1.setGroup(getShortStayClinicRecuperationInstitutionDivisionRadio());

      shortStayClinicRecuperationInstitutionDivisionRadioItem1.setConstraints(VRLayout.FLOW);

      addShortStayClinicRecuperationInstitutionDivisionRadioItem1();
    }
    return shortStayClinicRecuperationInstitutionDivisionRadioItem1;

  }

  /**
   * ���j�b�g�^�f�Ï����擾���܂��B
   * @return ���j�b�g�^�f�Ï�
   */
  public ACRadioButtonItem getShortStayClinicRecuperationInstitutionDivisionRadioItem2(){
    if(shortStayClinicRecuperationInstitutionDivisionRadioItem2==null){

      shortStayClinicRecuperationInstitutionDivisionRadioItem2 = new ACRadioButtonItem();

      shortStayClinicRecuperationInstitutionDivisionRadioItem2.setText("���j�b�g�^�f�Ï�");

      shortStayClinicRecuperationInstitutionDivisionRadioItem2.setGroup(getShortStayClinicRecuperationInstitutionDivisionRadio());

      shortStayClinicRecuperationInstitutionDivisionRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

      addShortStayClinicRecuperationInstitutionDivisionRadioItem2();
    }
    return shortStayClinicRecuperationInstitutionDivisionRadioItem2;

  }

  /**
   * ���A��V���[�g�X�e�C���擾���܂��B
   * @return ���A��V���[�g�X�e�C
   */
  public ACRadioButtonItem getShortStayClinicRecuperationInstitutionDivisionRadioItem3(){
    if(shortStayClinicRecuperationInstitutionDivisionRadioItem3==null){

      shortStayClinicRecuperationInstitutionDivisionRadioItem3 = new ACRadioButtonItem();

      shortStayClinicRecuperationInstitutionDivisionRadioItem3.setText("���A��V���[�g�X�e�C");

      shortStayClinicRecuperationInstitutionDivisionRadioItem3.setGroup(getShortStayClinicRecuperationInstitutionDivisionRadio());

      shortStayClinicRecuperationInstitutionDivisionRadioItem3.setConstraints(VRLayout.FLOW);

      addShortStayClinicRecuperationInstitutionDivisionRadioItem3();
    }
    return shortStayClinicRecuperationInstitutionDivisionRadioItem3;

  }

  /**
   * �l���z�u�敪���擾���܂��B
   * @return �l���z�u�敪
   */
  public ACClearableRadioButtonGroup getShortStayClinicRecuperationDivision(){
    if(shortStayClinicRecuperationDivision==null){

      shortStayClinicRecuperationDivision = new ACClearableRadioButtonGroup();

      getShortStayClinicRecuperationDivisionContainer().setText("�l���z�u�敪");

      shortStayClinicRecuperationDivision.setBindPath("1230202");

      shortStayClinicRecuperationDivision.setUseClearButton(false);

      shortStayClinicRecuperationDivision.setModel(getShortStayClinicRecuperationDivisionModel());

      addShortStayClinicRecuperationDivision();
    }
    return shortStayClinicRecuperationDivision;

  }

  /**
   * �l���z�u�敪�R���e�i���擾���܂��B
   * @return �l���z�u�敪�R���e�i
   */
  protected ACLabelContainer getShortStayClinicRecuperationDivisionContainer(){
    if(shortStayClinicRecuperationDivisionContainer==null){
      shortStayClinicRecuperationDivisionContainer = new ACLabelContainer();
      shortStayClinicRecuperationDivisionContainer.setFollowChildEnabled(true);
      shortStayClinicRecuperationDivisionContainer.setVAlignment(VRLayout.CENTER);
      shortStayClinicRecuperationDivisionContainer.add(getShortStayClinicRecuperationDivision(), null);
    }
    return shortStayClinicRecuperationDivisionContainer;
  }

  /**
   * �l���z�u�敪���f�����擾���܂��B
   * @return �l���z�u�敪���f��
   */
  protected ACListModelAdapter getShortStayClinicRecuperationDivisionModel(){
    if(shortStayClinicRecuperationDivisionModel==null){
      shortStayClinicRecuperationDivisionModel = new ACListModelAdapter();
      addShortStayClinicRecuperationDivisionModel();
    }
    return shortStayClinicRecuperationDivisionModel;
  }

  /**
   * I�^���擾���܂��B
   * @return I�^
   */
  public ACRadioButtonItem getShortStayClinicRecuperationType1(){
    if(shortStayClinicRecuperationType1==null){

      shortStayClinicRecuperationType1 = new ACRadioButtonItem();

      shortStayClinicRecuperationType1.setText("I�^");

      shortStayClinicRecuperationType1.setGroup(getShortStayClinicRecuperationDivision());

      shortStayClinicRecuperationType1.setConstraints(VRLayout.FLOW);

      addShortStayClinicRecuperationType1();
    }
    return shortStayClinicRecuperationType1;

  }

  /**
   * II�^���擾���܂��B
   * @return II�^
   */
  public ACRadioButtonItem getShortStayClinicRecuperationType2(){
    if(shortStayClinicRecuperationType2==null){

      shortStayClinicRecuperationType2 = new ACRadioButtonItem();

      shortStayClinicRecuperationType2.setText("II�^");

      shortStayClinicRecuperationType2.setGroup(getShortStayClinicRecuperationDivision());

      shortStayClinicRecuperationType2.setConstraints(VRLayout.FLOW);

      addShortStayClinicRecuperationType2();
    }
    return shortStayClinicRecuperationType2;

  }

  /**
   * �a���敪�R���e�i���擾���܂��B
   * @return �a���敪�R���e�i
   */
  public ACLabelContainer getShortStayClinicRecuperationHospitalRoomContena(){
    if(shortStayClinicRecuperationHospitalRoomContena==null){

      shortStayClinicRecuperationHospitalRoomContena = new ACLabelContainer();

      shortStayClinicRecuperationHospitalRoomContena.setText("�a���敪");

      addShortStayClinicRecuperationHospitalRoomContena();
    }
    return shortStayClinicRecuperationHospitalRoomContena;

  }

  /**
   * �a���i�f�Ï��j���擾���܂��B
   * @return �a���i�f�Ï��j
   */
  public ACClearableRadioButtonGroup getShortStayClinicRecuperationHospitalRoomRadio(){
    if(shortStayClinicRecuperationHospitalRoomRadio==null){

      shortStayClinicRecuperationHospitalRoomRadio = new ACClearableRadioButtonGroup();

      shortStayClinicRecuperationHospitalRoomRadio.setBindPath("1230203");

      shortStayClinicRecuperationHospitalRoomRadio.setUseClearButton(false);

      shortStayClinicRecuperationHospitalRoomRadio.setModel(getShortStayClinicRecuperationHospitalRoomRadioModel());

      addShortStayClinicRecuperationHospitalRoomRadio();
    }
    return shortStayClinicRecuperationHospitalRoomRadio;

  }

  /**
   * �a���i�f�Ï��j���f�����擾���܂��B
   * @return �a���i�f�Ï��j���f��
   */
  protected ACListModelAdapter getShortStayClinicRecuperationHospitalRoomRadioModel(){
    if(shortStayClinicRecuperationHospitalRoomRadioModel==null){
      shortStayClinicRecuperationHospitalRoomRadioModel = new ACListModelAdapter();
      addShortStayClinicRecuperationHospitalRoomRadioModel();
    }
    return shortStayClinicRecuperationHospitalRoomRadioModel;
  }

  /**
   * �]���^�����擾���܂��B
   * @return �]���^��
   */
  public ACRadioButtonItem getShortStayClinicRecuperationHospitalRoomRadioItem1(){
    if(shortStayClinicRecuperationHospitalRoomRadioItem1==null){

      shortStayClinicRecuperationHospitalRoomRadioItem1 = new ACRadioButtonItem();

      shortStayClinicRecuperationHospitalRoomRadioItem1.setText("�]���^��");

      shortStayClinicRecuperationHospitalRoomRadioItem1.setGroup(getShortStayClinicRecuperationHospitalRoomRadio());

      shortStayClinicRecuperationHospitalRoomRadioItem1.setConstraints(VRLayout.FLOW);

      addShortStayClinicRecuperationHospitalRoomRadioItem1();
    }
    return shortStayClinicRecuperationHospitalRoomRadioItem1;

  }

  /**
   * ���������擾���܂��B
   * @return ������
   */
  public ACRadioButtonItem getShortStayClinicRecuperationHospitalRoomRadioItem2(){
    if(shortStayClinicRecuperationHospitalRoomRadioItem2==null){

      shortStayClinicRecuperationHospitalRoomRadioItem2 = new ACRadioButtonItem();

      shortStayClinicRecuperationHospitalRoomRadioItem2.setText("������");

      shortStayClinicRecuperationHospitalRoomRadioItem2.setGroup(getShortStayClinicRecuperationHospitalRoomRadio());

      shortStayClinicRecuperationHospitalRoomRadioItem2.setConstraints(VRLayout.FLOW);

      addShortStayClinicRecuperationHospitalRoomRadioItem2();
    }
    return shortStayClinicRecuperationHospitalRoomRadioItem2;

  }

  /**
   * �a���i���j�b�g�^�j���擾���܂��B
   * @return �a���i���j�b�g�^�j
   */
  public ACClearableRadioButtonGroup getShortStayClinicRecuperationUnitHospitalRoomRadio(){
    if(shortStayClinicRecuperationUnitHospitalRoomRadio==null){

      shortStayClinicRecuperationUnitHospitalRoomRadio = new ACClearableRadioButtonGroup();

      shortStayClinicRecuperationUnitHospitalRoomRadio.setBindPath("1230204");

      shortStayClinicRecuperationUnitHospitalRoomRadio.setUseClearButton(false);

      shortStayClinicRecuperationUnitHospitalRoomRadio.setModel(getShortStayClinicRecuperationUnitHospitalRoomRadioModel());

      addShortStayClinicRecuperationUnitHospitalRoomRadio();
    }
    return shortStayClinicRecuperationUnitHospitalRoomRadio;

  }

  /**
   * �a���i���j�b�g�^�j���f�����擾���܂��B
   * @return �a���i���j�b�g�^�j���f��
   */
  protected ACListModelAdapter getShortStayClinicRecuperationUnitHospitalRoomRadioModel(){
    if(shortStayClinicRecuperationUnitHospitalRoomRadioModel==null){
      shortStayClinicRecuperationUnitHospitalRoomRadioModel = new ACListModelAdapter();
      addShortStayClinicRecuperationUnitHospitalRoomRadioModel();
    }
    return shortStayClinicRecuperationUnitHospitalRoomRadioModel;
  }

  /**
   * ���j�b�g�^�����擾���܂��B
   * @return ���j�b�g�^��
   */
  public ACRadioButtonItem getShortStayClinicRecuperationUnitHospitalRoomRadioItem1(){
    if(shortStayClinicRecuperationUnitHospitalRoomRadioItem1==null){

      shortStayClinicRecuperationUnitHospitalRoomRadioItem1 = new ACRadioButtonItem();

      shortStayClinicRecuperationUnitHospitalRoomRadioItem1.setText("���j�b�g�^��");

      shortStayClinicRecuperationUnitHospitalRoomRadioItem1.setGroup(getShortStayClinicRecuperationUnitHospitalRoomRadio());

      shortStayClinicRecuperationUnitHospitalRoomRadioItem1.setConstraints(VRLayout.FLOW);

      addShortStayClinicRecuperationUnitHospitalRoomRadioItem1();
    }
    return shortStayClinicRecuperationUnitHospitalRoomRadioItem1;

  }

  /**
   * ���j�b�g�^�������擾���܂��B
   * @return ���j�b�g�^����
   */
  public ACRadioButtonItem getShortStayClinicRecuperationUnitHospitalRoomRadioItem2(){
    if(shortStayClinicRecuperationUnitHospitalRoomRadioItem2==null){

      shortStayClinicRecuperationUnitHospitalRoomRadioItem2 = new ACRadioButtonItem();

      shortStayClinicRecuperationUnitHospitalRoomRadioItem2.setText("���j�b�g�^����");

      shortStayClinicRecuperationUnitHospitalRoomRadioItem2.setGroup(getShortStayClinicRecuperationUnitHospitalRoomRadio());

      shortStayClinicRecuperationUnitHospitalRoomRadioItem2.setConstraints(VRLayout.FLOW);

      addShortStayClinicRecuperationUnitHospitalRoomRadioItem2();
    }
    return shortStayClinicRecuperationUnitHospitalRoomRadioItem2;

  }

  /**
   * �a���敪���W�I���擾���܂��B
   * @return �a���敪���W�I
   */
  public ACClearableRadioButtonGroup getShortStayClinicRecuperationSickroomDivisionRadio(){
    if(shortStayClinicRecuperationSickroomDivisionRadio==null){

      shortStayClinicRecuperationSickroomDivisionRadio = new ACClearableRadioButtonGroup();

      getShortStayClinicRecuperationSickroomDivisionRadioContainer().setText("�a���敪");

      shortStayClinicRecuperationSickroomDivisionRadio.setBindPath("1230212");

      shortStayClinicRecuperationSickroomDivisionRadio.setUseClearButton(false);

      shortStayClinicRecuperationSickroomDivisionRadio.setModel(getShortStayClinicRecuperationSickroomDivisionRadioModel());

      addShortStayClinicRecuperationSickroomDivisionRadio();
    }
    return shortStayClinicRecuperationSickroomDivisionRadio;

  }

  /**
   * �a���敪���W�I�R���e�i���擾���܂��B
   * @return �a���敪���W�I�R���e�i
   */
  protected ACLabelContainer getShortStayClinicRecuperationSickroomDivisionRadioContainer(){
    if(shortStayClinicRecuperationSickroomDivisionRadioContainer==null){
      shortStayClinicRecuperationSickroomDivisionRadioContainer = new ACLabelContainer();
      shortStayClinicRecuperationSickroomDivisionRadioContainer.setFollowChildEnabled(true);
      shortStayClinicRecuperationSickroomDivisionRadioContainer.setVAlignment(VRLayout.CENTER);
      shortStayClinicRecuperationSickroomDivisionRadioContainer.add(getShortStayClinicRecuperationSickroomDivisionRadio(), null);
    }
    return shortStayClinicRecuperationSickroomDivisionRadioContainer;
  }

  /**
   * �a���敪���W�I���f�����擾���܂��B
   * @return �a���敪���W�I���f��
   */
  protected ACListModelAdapter getShortStayClinicRecuperationSickroomDivisionRadioModel(){
    if(shortStayClinicRecuperationSickroomDivisionRadioModel==null){
      shortStayClinicRecuperationSickroomDivisionRadioModel = new ACListModelAdapter();
      addShortStayClinicRecuperationSickroomDivisionRadioModel();
    }
    return shortStayClinicRecuperationSickroomDivisionRadioModel;
  }

  /**
   * �]���^�����擾���܂��B
   * @return �]���^��
   */
  public ACRadioButtonItem getShortStayClinicRecuperationSickroomDivisionRadioItem1(){
    if(shortStayClinicRecuperationSickroomDivisionRadioItem1==null){

      shortStayClinicRecuperationSickroomDivisionRadioItem1 = new ACRadioButtonItem();

      shortStayClinicRecuperationSickroomDivisionRadioItem1.setText("�]���^��");

      shortStayClinicRecuperationSickroomDivisionRadioItem1.setGroup(getShortStayClinicRecuperationSickroomDivisionRadio());

      shortStayClinicRecuperationSickroomDivisionRadioItem1.setConstraints(VRLayout.FLOW);

      addShortStayClinicRecuperationSickroomDivisionRadioItem1();
    }
    return shortStayClinicRecuperationSickroomDivisionRadioItem1;

  }

  /**
   * ���������擾���܂��B
   * @return ������
   */
  public ACRadioButtonItem getShortStayClinicRecuperationSickroomDivisionRadioItem2(){
    if(shortStayClinicRecuperationSickroomDivisionRadioItem2==null){

      shortStayClinicRecuperationSickroomDivisionRadioItem2 = new ACRadioButtonItem();

      shortStayClinicRecuperationSickroomDivisionRadioItem2.setText("������");

      shortStayClinicRecuperationSickroomDivisionRadioItem2.setGroup(getShortStayClinicRecuperationSickroomDivisionRadio());

      shortStayClinicRecuperationSickroomDivisionRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

      addShortStayClinicRecuperationSickroomDivisionRadioItem2();
    }
    return shortStayClinicRecuperationSickroomDivisionRadioItem2;

  }

  /**
   * ���j�b�g�^�����擾���܂��B
   * @return ���j�b�g�^��
   */
  public ACRadioButtonItem getShortStayClinicRecuperationSickroomDivisionRadioItem3(){
    if(shortStayClinicRecuperationSickroomDivisionRadioItem3==null){

      shortStayClinicRecuperationSickroomDivisionRadioItem3 = new ACRadioButtonItem();

      shortStayClinicRecuperationSickroomDivisionRadioItem3.setText("���j�b�g�^��");

      shortStayClinicRecuperationSickroomDivisionRadioItem3.setGroup(getShortStayClinicRecuperationSickroomDivisionRadio());

      shortStayClinicRecuperationSickroomDivisionRadioItem3.setConstraints(VRLayout.FLOW);

      addShortStayClinicRecuperationSickroomDivisionRadioItem3();
    }
    return shortStayClinicRecuperationSickroomDivisionRadioItem3;

  }

  /**
   * ���j�b�g�^�������擾���܂��B
   * @return ���j�b�g�^����
   */
  public ACRadioButtonItem getShortStayClinicRecuperationSickroomDivisionRadioItem4(){
    if(shortStayClinicRecuperationSickroomDivisionRadioItem4==null){

      shortStayClinicRecuperationSickroomDivisionRadioItem4 = new ACRadioButtonItem();

      shortStayClinicRecuperationSickroomDivisionRadioItem4.setText("���j�b�g�^����");

      shortStayClinicRecuperationSickroomDivisionRadioItem4.setGroup(getShortStayClinicRecuperationSickroomDivisionRadio());

      shortStayClinicRecuperationSickroomDivisionRadioItem4.setConstraints(VRLayout.FLOW);

      addShortStayClinicRecuperationSickroomDivisionRadioItem4();
    }
    return shortStayClinicRecuperationSickroomDivisionRadioItem4;

  }

  /**
   * �×{�����Z���擾���܂��B
   * @return �×{�����Z
   */
  public ACClearableRadioButtonGroup getShortStayClinicRecuperationSubtractionType(){
    if(shortStayClinicRecuperationSubtractionType==null){

      shortStayClinicRecuperationSubtractionType = new ACClearableRadioButtonGroup();

      getShortStayClinicRecuperationSubtractionTypeContainer().setText("�×{�����Z");

      shortStayClinicRecuperationSubtractionType.setBindPath("1230205");

      shortStayClinicRecuperationSubtractionType.setUseClearButton(false);

      shortStayClinicRecuperationSubtractionType.setModel(getShortStayClinicRecuperationSubtractionTypeModel());

      addShortStayClinicRecuperationSubtractionType();
    }
    return shortStayClinicRecuperationSubtractionType;

  }

  /**
   * �×{�����Z�R���e�i���擾���܂��B
   * @return �×{�����Z�R���e�i
   */
  protected ACLabelContainer getShortStayClinicRecuperationSubtractionTypeContainer(){
    if(shortStayClinicRecuperationSubtractionTypeContainer==null){
      shortStayClinicRecuperationSubtractionTypeContainer = new ACLabelContainer();
      shortStayClinicRecuperationSubtractionTypeContainer.setFollowChildEnabled(true);
      shortStayClinicRecuperationSubtractionTypeContainer.setVAlignment(VRLayout.CENTER);
      shortStayClinicRecuperationSubtractionTypeContainer.add(getShortStayClinicRecuperationSubtractionType(), null);
    }
    return shortStayClinicRecuperationSubtractionTypeContainer;
  }

  /**
   * �×{�����Z���f�����擾���܂��B
   * @return �×{�����Z���f��
   */
  protected ACListModelAdapter getShortStayClinicRecuperationSubtractionTypeModel(){
    if(shortStayClinicRecuperationSubtractionTypeModel==null){
      shortStayClinicRecuperationSubtractionTypeModel = new ACListModelAdapter();
      addShortStayClinicRecuperationSubtractionTypeModel();
    }
    return shortStayClinicRecuperationSubtractionTypeModel;
  }

  /**
   * ����擾���܂��B
   * @return �
   */
  public ACRadioButtonItem getShortStayClinicRecuperationSubtractionTypeNormal(){
    if(shortStayClinicRecuperationSubtractionTypeNormal==null){

      shortStayClinicRecuperationSubtractionTypeNormal = new ACRadioButtonItem();

      shortStayClinicRecuperationSubtractionTypeNormal.setText("��^");

      shortStayClinicRecuperationSubtractionTypeNormal.setGroup(getShortStayClinicRecuperationSubtractionType());

      shortStayClinicRecuperationSubtractionTypeNormal.setConstraints(VRLayout.FLOW);

      addShortStayClinicRecuperationSubtractionTypeNormal();
    }
    return shortStayClinicRecuperationSubtractionTypeNormal;

  }

  /**
   * ��I���擾���܂��B
   * @return ��I
   */
  public ACRadioButtonItem getShortStayClinicRecuperationSubtractionType1(){
    if(shortStayClinicRecuperationSubtractionType1==null){

      shortStayClinicRecuperationSubtractionType1 = new ACRadioButtonItem();

      shortStayClinicRecuperationSubtractionType1.setText("���Z�^I");

      shortStayClinicRecuperationSubtractionType1.setGroup(getShortStayClinicRecuperationSubtractionType());

      shortStayClinicRecuperationSubtractionType1.setConstraints(VRLayout.FLOW);

      addShortStayClinicRecuperationSubtractionType1();
    }
    return shortStayClinicRecuperationSubtractionType1;

  }

  /**
   * ��II���擾���܂��B
   * @return ��II
   */
  public ACRadioButtonItem getShortStayClinicRecuperationSubtractionType2(){
    if(shortStayClinicRecuperationSubtractionType2==null){

      shortStayClinicRecuperationSubtractionType2 = new ACRadioButtonItem();

      shortStayClinicRecuperationSubtractionType2.setText("���Z�^II");

      shortStayClinicRecuperationSubtractionType2.setGroup(getShortStayClinicRecuperationSubtractionType());

      shortStayClinicRecuperationSubtractionType2.setConstraints(VRLayout.FLOW);

      addShortStayClinicRecuperationSubtractionType2();
    }
    return shortStayClinicRecuperationSubtractionType2;

  }

  /**
   * ���}���Z���擾���܂��B
   * @return ���}���Z
   */
  public ACClearableRadioButtonGroup getShortStayClinicRecuperationMeetingAndSendingOff(){
    if(shortStayClinicRecuperationMeetingAndSendingOff==null){

      shortStayClinicRecuperationMeetingAndSendingOff = new ACClearableRadioButtonGroup();

      getShortStayClinicRecuperationMeetingAndSendingOffContainer().setText("���}���Z");

      shortStayClinicRecuperationMeetingAndSendingOff.setBindPath("6");

      shortStayClinicRecuperationMeetingAndSendingOff.setUseClearButton(false);

      shortStayClinicRecuperationMeetingAndSendingOff.setModel(getShortStayClinicRecuperationMeetingAndSendingOffModel());

      addShortStayClinicRecuperationMeetingAndSendingOff();
    }
    return shortStayClinicRecuperationMeetingAndSendingOff;

  }

  /**
   * ���}���Z�R���e�i���擾���܂��B
   * @return ���}���Z�R���e�i
   */
  protected ACLabelContainer getShortStayClinicRecuperationMeetingAndSendingOffContainer(){
    if(shortStayClinicRecuperationMeetingAndSendingOffContainer==null){
      shortStayClinicRecuperationMeetingAndSendingOffContainer = new ACLabelContainer();
      shortStayClinicRecuperationMeetingAndSendingOffContainer.setFollowChildEnabled(true);
      shortStayClinicRecuperationMeetingAndSendingOffContainer.setVAlignment(VRLayout.CENTER);
      shortStayClinicRecuperationMeetingAndSendingOffContainer.add(getShortStayClinicRecuperationMeetingAndSendingOff(), null);
    }
    return shortStayClinicRecuperationMeetingAndSendingOffContainer;
  }

  /**
   * ���}���Z���f�����擾���܂��B
   * @return ���}���Z���f��
   */
  protected ACListModelAdapter getShortStayClinicRecuperationMeetingAndSendingOffModel(){
    if(shortStayClinicRecuperationMeetingAndSendingOffModel==null){
      shortStayClinicRecuperationMeetingAndSendingOffModel = new ACListModelAdapter();
      addShortStayClinicRecuperationMeetingAndSendingOffModel();
    }
    return shortStayClinicRecuperationMeetingAndSendingOffModel;
  }

  /**
   * ���}�Ȃ����擾���܂��B
   * @return ���}�Ȃ�
   */
  public ACRadioButtonItem getShortStayClinicRecuperationMeetingAndSendingOffNone(){
    if(shortStayClinicRecuperationMeetingAndSendingOffNone==null){

      shortStayClinicRecuperationMeetingAndSendingOffNone = new ACRadioButtonItem();

      shortStayClinicRecuperationMeetingAndSendingOffNone.setText("���}�Ȃ�");

      shortStayClinicRecuperationMeetingAndSendingOffNone.setGroup(getShortStayClinicRecuperationMeetingAndSendingOff());

      shortStayClinicRecuperationMeetingAndSendingOffNone.setConstraints(VRLayout.FLOW);

      addShortStayClinicRecuperationMeetingAndSendingOffNone();
    }
    return shortStayClinicRecuperationMeetingAndSendingOffNone;

  }

  /**
   * ���}�Г����擾���܂��B
   * @return ���}�Г�
   */
  public ACRadioButtonItem getShortStayClinicRecuperationMeetingAndSendingOffOneWay(){
    if(shortStayClinicRecuperationMeetingAndSendingOffOneWay==null){

      shortStayClinicRecuperationMeetingAndSendingOffOneWay = new ACRadioButtonItem();

      shortStayClinicRecuperationMeetingAndSendingOffOneWay.setText("���}�Г�");

      shortStayClinicRecuperationMeetingAndSendingOffOneWay.setGroup(getShortStayClinicRecuperationMeetingAndSendingOff());

      shortStayClinicRecuperationMeetingAndSendingOffOneWay.setConstraints(VRLayout.FLOW);

      addShortStayClinicRecuperationMeetingAndSendingOffOneWay();
    }
    return shortStayClinicRecuperationMeetingAndSendingOffOneWay;

  }

  /**
   * ���}�������擾���܂��B
   * @return ���}����
   */
  public ACRadioButtonItem getShortStayClinicRecuperationMeetingAndSendingOffRoundTrip(){
    if(shortStayClinicRecuperationMeetingAndSendingOffRoundTrip==null){

      shortStayClinicRecuperationMeetingAndSendingOffRoundTrip = new ACRadioButtonItem();

      shortStayClinicRecuperationMeetingAndSendingOffRoundTrip.setText("���}����");

      shortStayClinicRecuperationMeetingAndSendingOffRoundTrip.setGroup(getShortStayClinicRecuperationMeetingAndSendingOff());

      shortStayClinicRecuperationMeetingAndSendingOffRoundTrip.setConstraints(VRLayout.FLOW);

      addShortStayClinicRecuperationMeetingAndSendingOffRoundTrip();
    }
    return shortStayClinicRecuperationMeetingAndSendingOffRoundTrip;

  }

  /**
   * �h�{�Ǘ��̐����Z���擾���܂��B
   * @return �h�{�Ǘ��̐����Z
   */
  public ACClearableRadioButtonGroup getShortStayClinicRecuperationDieticianManageRadio(){
    if(shortStayClinicRecuperationDieticianManageRadio==null){

      shortStayClinicRecuperationDieticianManageRadio = new ACClearableRadioButtonGroup();

      getShortStayClinicRecuperationDieticianManageRadioContainer().setText("�h�{�Ǘ��̐����Z");

      shortStayClinicRecuperationDieticianManageRadio.setBindPath("1230207");

      shortStayClinicRecuperationDieticianManageRadio.setUseClearButton(false);

      shortStayClinicRecuperationDieticianManageRadio.setModel(getShortStayClinicRecuperationDieticianManageRadioModel());

      addShortStayClinicRecuperationDieticianManageRadio();
    }
    return shortStayClinicRecuperationDieticianManageRadio;

  }

  /**
   * �h�{�Ǘ��̐����Z�R���e�i���擾���܂��B
   * @return �h�{�Ǘ��̐����Z�R���e�i
   */
  protected ACLabelContainer getShortStayClinicRecuperationDieticianManageRadioContainer(){
    if(shortStayClinicRecuperationDieticianManageRadioContainer==null){
      shortStayClinicRecuperationDieticianManageRadioContainer = new ACLabelContainer();
      shortStayClinicRecuperationDieticianManageRadioContainer.setFollowChildEnabled(true);
      shortStayClinicRecuperationDieticianManageRadioContainer.setVAlignment(VRLayout.CENTER);
      shortStayClinicRecuperationDieticianManageRadioContainer.add(getShortStayClinicRecuperationDieticianManageRadio(), null);
    }
    return shortStayClinicRecuperationDieticianManageRadioContainer;
  }

  /**
   * �h�{�Ǘ��̐����Z���f�����擾���܂��B
   * @return �h�{�Ǘ��̐����Z���f��
   */
  protected ACListModelAdapter getShortStayClinicRecuperationDieticianManageRadioModel(){
    if(shortStayClinicRecuperationDieticianManageRadioModel==null){
      shortStayClinicRecuperationDieticianManageRadioModel = new ACListModelAdapter();
      addShortStayClinicRecuperationDieticianManageRadioModel();
    }
    return shortStayClinicRecuperationDieticianManageRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getShortStayClinicRecuperationDieticianManageRadioItem1(){
    if(shortStayClinicRecuperationDieticianManageRadioItem1==null){

      shortStayClinicRecuperationDieticianManageRadioItem1 = new ACRadioButtonItem();

      shortStayClinicRecuperationDieticianManageRadioItem1.setText("�Ȃ�");

      shortStayClinicRecuperationDieticianManageRadioItem1.setGroup(getShortStayClinicRecuperationDieticianManageRadio());

      shortStayClinicRecuperationDieticianManageRadioItem1.setConstraints(VRLayout.FLOW);

      addShortStayClinicRecuperationDieticianManageRadioItem1();
    }
    return shortStayClinicRecuperationDieticianManageRadioItem1;

  }

  /**
   * �Ǘ��h�{�m���擾���܂��B
   * @return �Ǘ��h�{�m
   */
  public ACRadioButtonItem getShortStayClinicRecuperationDieticianManageRadioItem2(){
    if(shortStayClinicRecuperationDieticianManageRadioItem2==null){

      shortStayClinicRecuperationDieticianManageRadioItem2 = new ACRadioButtonItem();

      shortStayClinicRecuperationDieticianManageRadioItem2.setText("�Ǘ��h�{�m");

      shortStayClinicRecuperationDieticianManageRadioItem2.setGroup(getShortStayClinicRecuperationDieticianManageRadio());

      shortStayClinicRecuperationDieticianManageRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

      addShortStayClinicRecuperationDieticianManageRadioItem2();
    }
    return shortStayClinicRecuperationDieticianManageRadioItem2;

  }

  /**
   * �h�{�m���擾���܂��B
   * @return �h�{�m
   */
  public ACRadioButtonItem getShortStayClinicRecuperationDieticianManageRadioItem3(){
    if(shortStayClinicRecuperationDieticianManageRadioItem3==null){

      shortStayClinicRecuperationDieticianManageRadioItem3 = new ACRadioButtonItem();

      shortStayClinicRecuperationDieticianManageRadioItem3.setText("�h�{�m");

      shortStayClinicRecuperationDieticianManageRadioItem3.setGroup(getShortStayClinicRecuperationDieticianManageRadio());

      shortStayClinicRecuperationDieticianManageRadioItem3.setConstraints(VRLayout.FLOW);

      addShortStayClinicRecuperationDieticianManageRadioItem3();
    }
    return shortStayClinicRecuperationDieticianManageRadioItem3;

  }

  /**
   * �×{�H���Z���擾���܂��B
   * @return �×{�H���Z
   */
  public ACClearableRadioButtonGroup getShortStayClinicRecuperationMedicalExpensesRadio(){
    if(shortStayClinicRecuperationMedicalExpensesRadio==null){

      shortStayClinicRecuperationMedicalExpensesRadio = new ACClearableRadioButtonGroup();

      getShortStayClinicRecuperationMedicalExpensesRadioContainer().setText("�×{�H���Z");

      shortStayClinicRecuperationMedicalExpensesRadio.setBindPath("1230208");

      shortStayClinicRecuperationMedicalExpensesRadio.setUseClearButton(false);

      shortStayClinicRecuperationMedicalExpensesRadio.setModel(getShortStayClinicRecuperationMedicalExpensesRadioModel());

      addShortStayClinicRecuperationMedicalExpensesRadio();
    }
    return shortStayClinicRecuperationMedicalExpensesRadio;

  }

  /**
   * �×{�H���Z�R���e�i���擾���܂��B
   * @return �×{�H���Z�R���e�i
   */
  protected ACLabelContainer getShortStayClinicRecuperationMedicalExpensesRadioContainer(){
    if(shortStayClinicRecuperationMedicalExpensesRadioContainer==null){
      shortStayClinicRecuperationMedicalExpensesRadioContainer = new ACLabelContainer();
      shortStayClinicRecuperationMedicalExpensesRadioContainer.setFollowChildEnabled(true);
      shortStayClinicRecuperationMedicalExpensesRadioContainer.setVAlignment(VRLayout.CENTER);
      shortStayClinicRecuperationMedicalExpensesRadioContainer.add(getShortStayClinicRecuperationMedicalExpensesRadio(), null);
    }
    return shortStayClinicRecuperationMedicalExpensesRadioContainer;
  }

  /**
   * �×{�H���Z���f�����擾���܂��B
   * @return �×{�H���Z���f��
   */
  protected ACListModelAdapter getShortStayClinicRecuperationMedicalExpensesRadioModel(){
    if(shortStayClinicRecuperationMedicalExpensesRadioModel==null){
      shortStayClinicRecuperationMedicalExpensesRadioModel = new ACListModelAdapter();
      addShortStayClinicRecuperationMedicalExpensesRadioModel();
    }
    return shortStayClinicRecuperationMedicalExpensesRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getShortStayClinicRecuperationMedicalExpensesRadioItem1(){
    if(shortStayClinicRecuperationMedicalExpensesRadioItem1==null){

      shortStayClinicRecuperationMedicalExpensesRadioItem1 = new ACRadioButtonItem();

      shortStayClinicRecuperationMedicalExpensesRadioItem1.setText("�Ȃ�");

      shortStayClinicRecuperationMedicalExpensesRadioItem1.setGroup(getShortStayClinicRecuperationMedicalExpensesRadio());

      shortStayClinicRecuperationMedicalExpensesRadioItem1.setConstraints(VRLayout.FLOW);

      addShortStayClinicRecuperationMedicalExpensesRadioItem1();
    }
    return shortStayClinicRecuperationMedicalExpensesRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getShortStayClinicRecuperationMedicalExpensesRadioItem2(){
    if(shortStayClinicRecuperationMedicalExpensesRadioItem2==null){

      shortStayClinicRecuperationMedicalExpensesRadioItem2 = new ACRadioButtonItem();

      shortStayClinicRecuperationMedicalExpensesRadioItem2.setText("����");

      shortStayClinicRecuperationMedicalExpensesRadioItem2.setGroup(getShortStayClinicRecuperationMedicalExpensesRadio());

      shortStayClinicRecuperationMedicalExpensesRadioItem2.setConstraints(VRLayout.FLOW);

      addShortStayClinicRecuperationMedicalExpensesRadioItem2();
    }
    return shortStayClinicRecuperationMedicalExpensesRadioItem2;

  }

  /**
   * �l�����Z���擾���܂��B
   * @return �l�����Z
   */
  public ACClearableRadioButtonGroup getShortStayClinicRecuperationStaffReduceRadio(){
    if(shortStayClinicRecuperationStaffReduceRadio==null){

      shortStayClinicRecuperationStaffReduceRadio = new ACClearableRadioButtonGroup();

      getShortStayClinicRecuperationStaffReduceRadioContainer().setText("�l�����Z");

      shortStayClinicRecuperationStaffReduceRadio.setBindPath("1230209");

      shortStayClinicRecuperationStaffReduceRadio.setUseClearButton(false);

      shortStayClinicRecuperationStaffReduceRadio.setModel(getShortStayClinicRecuperationStaffReduceRadioModel());

      addShortStayClinicRecuperationStaffReduceRadio();
    }
    return shortStayClinicRecuperationStaffReduceRadio;

  }

  /**
   * �l�����Z�R���e�i���擾���܂��B
   * @return �l�����Z�R���e�i
   */
  protected ACLabelContainer getShortStayClinicRecuperationStaffReduceRadioContainer(){
    if(shortStayClinicRecuperationStaffReduceRadioContainer==null){
      shortStayClinicRecuperationStaffReduceRadioContainer = new ACLabelContainer();
      shortStayClinicRecuperationStaffReduceRadioContainer.setFollowChildEnabled(true);
      shortStayClinicRecuperationStaffReduceRadioContainer.setVAlignment(VRLayout.CENTER);
      shortStayClinicRecuperationStaffReduceRadioContainer.add(getShortStayClinicRecuperationStaffReduceRadio(), null);
    }
    return shortStayClinicRecuperationStaffReduceRadioContainer;
  }

  /**
   * �l�����Z���f�����擾���܂��B
   * @return �l�����Z���f��
   */
  protected ACListModelAdapter getShortStayClinicRecuperationStaffReduceRadioModel(){
    if(shortStayClinicRecuperationStaffReduceRadioModel==null){
      shortStayClinicRecuperationStaffReduceRadioModel = new ACListModelAdapter();
      addShortStayClinicRecuperationStaffReduceRadioModel();
    }
    return shortStayClinicRecuperationStaffReduceRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getShortStayClinicRecuperationStaffReduceRadioItem1(){
    if(shortStayClinicRecuperationStaffReduceRadioItem1==null){

      shortStayClinicRecuperationStaffReduceRadioItem1 = new ACRadioButtonItem();

      shortStayClinicRecuperationStaffReduceRadioItem1.setText("�Ȃ�");

      shortStayClinicRecuperationStaffReduceRadioItem1.setGroup(getShortStayClinicRecuperationStaffReduceRadio());

      shortStayClinicRecuperationStaffReduceRadioItem1.setConstraints(VRLayout.FLOW);

      addShortStayClinicRecuperationStaffReduceRadioItem1();
    }
    return shortStayClinicRecuperationStaffReduceRadioItem1;

  }

  /**
   * ������߂��擾���܂��B
   * @return �������
   */
  public ACRadioButtonItem getShortStayClinicRecuperationStaffReduceRadioItem2(){
    if(shortStayClinicRecuperationStaffReduceRadioItem2==null){

      shortStayClinicRecuperationStaffReduceRadioItem2 = new ACRadioButtonItem();

      shortStayClinicRecuperationStaffReduceRadioItem2.setText("�������");

      shortStayClinicRecuperationStaffReduceRadioItem2.setGroup(getShortStayClinicRecuperationStaffReduceRadio());

      shortStayClinicRecuperationStaffReduceRadioItem2.setConstraints(VRLayout.FLOW);

      addShortStayClinicRecuperationStaffReduceRadioItem2();
    }
    return shortStayClinicRecuperationStaffReduceRadioItem2;

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
   * ����f�Ô�{�^�����擾���܂��B
   * @return ����f�Ô�{�^��
   */
  public ACMapBindButton getShortStayClinicRecuperationSpecificConsultationFee(){
    if(shortStayClinicRecuperationSpecificConsultationFee==null){

      shortStayClinicRecuperationSpecificConsultationFee = new ACMapBindButton();

      shortStayClinicRecuperationSpecificConsultationFee.setText("����f�Ô�");

      shortStayClinicRecuperationSpecificConsultationFee.setToolTipText("����f�Ô��ݒ肵�܂��B");

      addShortStayClinicRecuperationSpecificConsultationFee();
    }
    return shortStayClinicRecuperationSpecificConsultationFee;

  }

  /**
   * �ݒ胉�x�����擾���܂��B
   * @return �ݒ胉�x��
   */
  public ACLabel getShortStayClinicRecuperationSpecificConsultationFeeOutline(){
    if(shortStayClinicRecuperationSpecificConsultationFeeOutline==null){

      shortStayClinicRecuperationSpecificConsultationFeeOutline = new ACLabel();

      shortStayClinicRecuperationSpecificConsultationFeeOutline.setText("�ݒ�Ȃ�");

      shortStayClinicRecuperationSpecificConsultationFeeOutline.setOpaque(true);
      shortStayClinicRecuperationSpecificConsultationFeeOutline.setBackground(new Color(255,255,172));

      addShortStayClinicRecuperationSpecificConsultationFeeOutline();
    }
    return shortStayClinicRecuperationSpecificConsultationFeeOutline;

  }

  /**
   * �H���R���e�i���擾���܂��B
   * @return �H���R���e�i
   */
  public ACBackLabelContainer getShortStayClinicRecuperationDinnerContainer(){
    if(shortStayClinicRecuperationDinnerContainer==null){

      shortStayClinicRecuperationDinnerContainer = new ACBackLabelContainer();

      addShortStayClinicRecuperationDinnerContainer();
    }
    return shortStayClinicRecuperationDinnerContainer;

  }

  /**
   * �H���񋟂��擾���܂��B
   * @return �H����
   */
  public ACComboBox getShortStayClinicRecuperationDinnerOffer(){
    if(shortStayClinicRecuperationDinnerOffer==null){

      shortStayClinicRecuperationDinnerOffer = new ACComboBox();

      getShortStayClinicRecuperationDinnerOfferContainer().setText("�H����");

      shortStayClinicRecuperationDinnerOffer.setBindPath("1230249");

      shortStayClinicRecuperationDinnerOffer.setEditable(false);

      shortStayClinicRecuperationDinnerOffer.setModelBindPath("1230249");

      shortStayClinicRecuperationDinnerOffer.setRenderBindPath("CONTENT");

      shortStayClinicRecuperationDinnerOffer.setModel(getShortStayClinicRecuperationDinnerOfferModel());

      addShortStayClinicRecuperationDinnerOffer();
    }
    return shortStayClinicRecuperationDinnerOffer;

  }

  /**
   * �H���񋟃R���e�i���擾���܂��B
   * @return �H���񋟃R���e�i
   */
  protected ACLabelContainer getShortStayClinicRecuperationDinnerOfferContainer(){
    if(shortStayClinicRecuperationDinnerOfferContainer==null){
      shortStayClinicRecuperationDinnerOfferContainer = new ACLabelContainer();
      shortStayClinicRecuperationDinnerOfferContainer.setFollowChildEnabled(true);
      shortStayClinicRecuperationDinnerOfferContainer.setVAlignment(VRLayout.CENTER);
      shortStayClinicRecuperationDinnerOfferContainer.add(getShortStayClinicRecuperationDinnerOffer(), null);
    }
    return shortStayClinicRecuperationDinnerOfferContainer;
  }

  /**
   * �H���񋟃��f�����擾���܂��B
   * @return �H���񋟃��f��
   */
  protected ACComboBoxModelAdapter getShortStayClinicRecuperationDinnerOfferModel(){
    if(shortStayClinicRecuperationDinnerOfferModel==null){
      shortStayClinicRecuperationDinnerOfferModel = new ACComboBoxModelAdapter();
      addShortStayClinicRecuperationDinnerOfferModel();
    }
    return shortStayClinicRecuperationDinnerOfferModel;
  }

  /**
   * �H����p���擾���܂��B
   * @return �H����p
   */
  public ACTextField getShortStayClinicRecuperationDinnerCost(){
    if(shortStayClinicRecuperationDinnerCost==null){

      shortStayClinicRecuperationDinnerCost = new ACTextField();

      getShortStayClinicRecuperationDinnerCostContainer().setText("�H����p");

      shortStayClinicRecuperationDinnerCost.setBindPath("1230251");

      shortStayClinicRecuperationDinnerCost.setColumns(4);

      shortStayClinicRecuperationDinnerCost.setCharType(VRCharType.ONLY_DIGIT);

      shortStayClinicRecuperationDinnerCost.setHorizontalAlignment(SwingConstants.RIGHT);

      shortStayClinicRecuperationDinnerCost.setIMEMode(InputSubset.LATIN);

      shortStayClinicRecuperationDinnerCost.setMaxLength(5);

      addShortStayClinicRecuperationDinnerCost();
    }
    return shortStayClinicRecuperationDinnerCost;

  }

  /**
   * �H����p�R���e�i���擾���܂��B
   * @return �H����p�R���e�i
   */
  protected ACLabelContainer getShortStayClinicRecuperationDinnerCostContainer(){
    if(shortStayClinicRecuperationDinnerCostContainer==null){
      shortStayClinicRecuperationDinnerCostContainer = new ACLabelContainer();
      shortStayClinicRecuperationDinnerCostContainer.setFollowChildEnabled(true);
      shortStayClinicRecuperationDinnerCostContainer.setVAlignment(VRLayout.CENTER);
      shortStayClinicRecuperationDinnerCostContainer.add(getShortStayClinicRecuperationDinnerCost(), null);
    }
    return shortStayClinicRecuperationDinnerCostContainer;
  }

  /**
   * 30�������擾���܂��B
   * @return 30����
   */
  public ACIntegerCheckBox getShortStayClinicRecuperationEtc30Over(){
    if(shortStayClinicRecuperationEtc30Over==null){

      shortStayClinicRecuperationEtc30Over = new ACIntegerCheckBox();

      shortStayClinicRecuperationEtc30Over.setText("30����");

      shortStayClinicRecuperationEtc30Over.setBindPath("5");

      shortStayClinicRecuperationEtc30Over.setSelectValue(2);

      shortStayClinicRecuperationEtc30Over.setUnSelectValue(1);

      addShortStayClinicRecuperationEtc30Over();
    }
    return shortStayClinicRecuperationEtc30Over;

  }

  /**
   * ���j�b�g�P�A�̐������擾���܂��B
   * @return ���j�b�g�P�A�̐���
   */
  public ACClearableRadioButtonGroup getShortStayClinicRecuperationUnitCareMaintenanceRadio(){
    if(shortStayClinicRecuperationUnitCareMaintenanceRadio==null){

      shortStayClinicRecuperationUnitCareMaintenanceRadio = new ACClearableRadioButtonGroup();

      getShortStayClinicRecuperationUnitCareMaintenanceRadioContainer().setText("���j�b�g�P�A�̐���");

      shortStayClinicRecuperationUnitCareMaintenanceRadio.setBindPath("1230210");

      shortStayClinicRecuperationUnitCareMaintenanceRadio.setUseClearButton(false);

      shortStayClinicRecuperationUnitCareMaintenanceRadio.setModel(getShortStayClinicRecuperationUnitCareMaintenanceRadioModel());

      addShortStayClinicRecuperationUnitCareMaintenanceRadio();
    }
    return shortStayClinicRecuperationUnitCareMaintenanceRadio;

  }

  /**
   * ���j�b�g�P�A�̐����R���e�i���擾���܂��B
   * @return ���j�b�g�P�A�̐����R���e�i
   */
  protected ACLabelContainer getShortStayClinicRecuperationUnitCareMaintenanceRadioContainer(){
    if(shortStayClinicRecuperationUnitCareMaintenanceRadioContainer==null){
      shortStayClinicRecuperationUnitCareMaintenanceRadioContainer = new ACLabelContainer();
      shortStayClinicRecuperationUnitCareMaintenanceRadioContainer.setFollowChildEnabled(true);
      shortStayClinicRecuperationUnitCareMaintenanceRadioContainer.setVAlignment(VRLayout.CENTER);
      shortStayClinicRecuperationUnitCareMaintenanceRadioContainer.add(getShortStayClinicRecuperationUnitCareMaintenanceRadio(), null);
    }
    return shortStayClinicRecuperationUnitCareMaintenanceRadioContainer;
  }

  /**
   * ���j�b�g�P�A�̐������f�����擾���܂��B
   * @return ���j�b�g�P�A�̐������f��
   */
  protected ACListModelAdapter getShortStayClinicRecuperationUnitCareMaintenanceRadioModel(){
    if(shortStayClinicRecuperationUnitCareMaintenanceRadioModel==null){
      shortStayClinicRecuperationUnitCareMaintenanceRadioModel = new ACListModelAdapter();
      addShortStayClinicRecuperationUnitCareMaintenanceRadioModel();
    }
    return shortStayClinicRecuperationUnitCareMaintenanceRadioModel;
  }

  /**
   * ���������擾���܂��B
   * @return ������
   */
  public ACRadioButtonItem getShortStayClinicRecuperationUnitCareMaintenanceRadioitem1(){
    if(shortStayClinicRecuperationUnitCareMaintenanceRadioitem1==null){

      shortStayClinicRecuperationUnitCareMaintenanceRadioitem1 = new ACRadioButtonItem();

      shortStayClinicRecuperationUnitCareMaintenanceRadioitem1.setText("������");

      shortStayClinicRecuperationUnitCareMaintenanceRadioitem1.setGroup(getShortStayClinicRecuperationUnitCareMaintenanceRadio());

      shortStayClinicRecuperationUnitCareMaintenanceRadioitem1.setConstraints(VRLayout.FLOW);

      addShortStayClinicRecuperationUnitCareMaintenanceRadioitem1();
    }
    return shortStayClinicRecuperationUnitCareMaintenanceRadioitem1;

  }

  /**
   * �������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getShortStayClinicRecuperationUnitCareMaintenanceRadioitem2(){
    if(shortStayClinicRecuperationUnitCareMaintenanceRadioitem2==null){

      shortStayClinicRecuperationUnitCareMaintenanceRadioitem2 = new ACRadioButtonItem();

      shortStayClinicRecuperationUnitCareMaintenanceRadioitem2.setText("����");

      shortStayClinicRecuperationUnitCareMaintenanceRadioitem2.setGroup(getShortStayClinicRecuperationUnitCareMaintenanceRadio());

      shortStayClinicRecuperationUnitCareMaintenanceRadioitem2.setConstraints(VRLayout.FLOW);

      addShortStayClinicRecuperationUnitCareMaintenanceRadioitem2();
    }
    return shortStayClinicRecuperationUnitCareMaintenanceRadioitem2;

  }

  /**
   * �ً}�Z�������l�b�g���[�N���Z���擾���܂��B
   * @return �ً}�Z�������l�b�g���[�N���Z
   */
  public ACClearableRadioButtonGroup getShortStayClinicRecuperationEmergencyNetworkAddRadio(){
    if(shortStayClinicRecuperationEmergencyNetworkAddRadio==null){

      shortStayClinicRecuperationEmergencyNetworkAddRadio = new ACClearableRadioButtonGroup();

      getShortStayClinicRecuperationEmergencyNetworkAddRadioContainer().setText("�ً}�Z�������l�b�g���[�N���Z");

      shortStayClinicRecuperationEmergencyNetworkAddRadio.setBindPath("1230211");

      shortStayClinicRecuperationEmergencyNetworkAddRadio.setUseClearButton(false);

      shortStayClinicRecuperationEmergencyNetworkAddRadio.setModel(getShortStayClinicRecuperationEmergencyNetworkAddRadioModel());

      addShortStayClinicRecuperationEmergencyNetworkAddRadio();
    }
    return shortStayClinicRecuperationEmergencyNetworkAddRadio;

  }

  /**
   * �ً}�Z�������l�b�g���[�N���Z�R���e�i���擾���܂��B
   * @return �ً}�Z�������l�b�g���[�N���Z�R���e�i
   */
  protected ACLabelContainer getShortStayClinicRecuperationEmergencyNetworkAddRadioContainer(){
    if(shortStayClinicRecuperationEmergencyNetworkAddRadioContainer==null){
      shortStayClinicRecuperationEmergencyNetworkAddRadioContainer = new ACLabelContainer();
      shortStayClinicRecuperationEmergencyNetworkAddRadioContainer.setFollowChildEnabled(true);
      shortStayClinicRecuperationEmergencyNetworkAddRadioContainer.setVAlignment(VRLayout.CENTER);
      shortStayClinicRecuperationEmergencyNetworkAddRadioContainer.add(getShortStayClinicRecuperationEmergencyNetworkAddRadio(), null);
    }
    return shortStayClinicRecuperationEmergencyNetworkAddRadioContainer;
  }

  /**
   * �ً}�Z�������l�b�g���[�N���Z���f�����擾���܂��B
   * @return �ً}�Z�������l�b�g���[�N���Z���f��
   */
  protected ACListModelAdapter getShortStayClinicRecuperationEmergencyNetworkAddRadioModel(){
    if(shortStayClinicRecuperationEmergencyNetworkAddRadioModel==null){
      shortStayClinicRecuperationEmergencyNetworkAddRadioModel = new ACListModelAdapter();
      addShortStayClinicRecuperationEmergencyNetworkAddRadioModel();
    }
    return shortStayClinicRecuperationEmergencyNetworkAddRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getShortStayClinicRecuperationEmergencyNetworkAddRadioItem1(){
    if(shortStayClinicRecuperationEmergencyNetworkAddRadioItem1==null){

      shortStayClinicRecuperationEmergencyNetworkAddRadioItem1 = new ACRadioButtonItem();

      shortStayClinicRecuperationEmergencyNetworkAddRadioItem1.setText("�Ȃ�");

      shortStayClinicRecuperationEmergencyNetworkAddRadioItem1.setGroup(getShortStayClinicRecuperationEmergencyNetworkAddRadio());

      shortStayClinicRecuperationEmergencyNetworkAddRadioItem1.setConstraints(VRLayout.FLOW);

      addShortStayClinicRecuperationEmergencyNetworkAddRadioItem1();
    }
    return shortStayClinicRecuperationEmergencyNetworkAddRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getShortStayClinicRecuperationEmergencyNetworkAddRadioItem2(){
    if(shortStayClinicRecuperationEmergencyNetworkAddRadioItem2==null){

      shortStayClinicRecuperationEmergencyNetworkAddRadioItem2 = new ACRadioButtonItem();

      shortStayClinicRecuperationEmergencyNetworkAddRadioItem2.setText("����");

      shortStayClinicRecuperationEmergencyNetworkAddRadioItem2.setGroup(getShortStayClinicRecuperationEmergencyNetworkAddRadio());

      shortStayClinicRecuperationEmergencyNetworkAddRadioItem2.setConstraints(VRLayout.FLOW);

      addShortStayClinicRecuperationEmergencyNetworkAddRadioItem2();
    }
    return shortStayClinicRecuperationEmergencyNetworkAddRadioItem2;

  }

  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001112Design() {

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

  }

  /**
   * �^�u1�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTab1(){

    tab1.add(getShortStayClinicRecuperationInstitutionDivisionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getShortStayClinicRecuperationDivisionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getShortStayClinicRecuperationHospitalRoomContena(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getShortStayClinicRecuperationSickroomDivisionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getShortStayClinicRecuperationSubtractionTypeContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getShortStayClinicRecuperationMeetingAndSendingOffContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getShortStayClinicRecuperationDieticianManageRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getShortStayClinicRecuperationMedicalExpensesRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getShortStayClinicRecuperationStaffReduceRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * �{�ݓ��̋敪�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayClinicRecuperationInstitutionDivisionRadio(){

  }

  /**
   * �{�ݓ��̋敪���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayClinicRecuperationInstitutionDivisionRadioModel(){

    getShortStayClinicRecuperationInstitutionDivisionRadioItem1().setButtonIndex(1);
    getShortStayClinicRecuperationInstitutionDivisionRadioModel().add(getShortStayClinicRecuperationInstitutionDivisionRadioItem1());

    getShortStayClinicRecuperationInstitutionDivisionRadioItem2().setButtonIndex(2);
    getShortStayClinicRecuperationInstitutionDivisionRadioModel().add(getShortStayClinicRecuperationInstitutionDivisionRadioItem2());

    getShortStayClinicRecuperationInstitutionDivisionRadioItem3().setButtonIndex(3);
    getShortStayClinicRecuperationInstitutionDivisionRadioModel().add(getShortStayClinicRecuperationInstitutionDivisionRadioItem3());

  }

  /**
   * �f�Ï��ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayClinicRecuperationInstitutionDivisionRadioItem1(){

  }

  /**
   * ���j�b�g�^�f�Ï��ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayClinicRecuperationInstitutionDivisionRadioItem2(){

  }

  /**
   * ���A��V���[�g�X�e�C�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayClinicRecuperationInstitutionDivisionRadioItem3(){

  }

  /**
   * �l���z�u�敪�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayClinicRecuperationDivision(){

  }

  /**
   * �l���z�u�敪���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayClinicRecuperationDivisionModel(){

    getShortStayClinicRecuperationType1().setButtonIndex(1);
    getShortStayClinicRecuperationDivisionModel().add(getShortStayClinicRecuperationType1());

    getShortStayClinicRecuperationType2().setButtonIndex(2);
    getShortStayClinicRecuperationDivisionModel().add(getShortStayClinicRecuperationType2());

  }

  /**
   * I�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayClinicRecuperationType1(){

  }

  /**
   * II�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayClinicRecuperationType2(){

  }

  /**
   * �a���敪�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayClinicRecuperationHospitalRoomContena(){

    shortStayClinicRecuperationHospitalRoomContena.add(getShortStayClinicRecuperationHospitalRoomRadio(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayClinicRecuperationHospitalRoomContena.add(getShortStayClinicRecuperationUnitHospitalRoomRadio(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * �a���i�f�Ï��j�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayClinicRecuperationHospitalRoomRadio(){

  }

  /**
   * �a���i�f�Ï��j���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayClinicRecuperationHospitalRoomRadioModel(){

    getShortStayClinicRecuperationHospitalRoomRadioItem1().setButtonIndex(1);
    getShortStayClinicRecuperationHospitalRoomRadioModel().add(getShortStayClinicRecuperationHospitalRoomRadioItem1());

    getShortStayClinicRecuperationHospitalRoomRadioItem2().setButtonIndex(2);
    getShortStayClinicRecuperationHospitalRoomRadioModel().add(getShortStayClinicRecuperationHospitalRoomRadioItem2());

  }

  /**
   * �]���^���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayClinicRecuperationHospitalRoomRadioItem1(){

  }

  /**
   * �������ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayClinicRecuperationHospitalRoomRadioItem2(){

  }

  /**
   * �a���i���j�b�g�^�j�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayClinicRecuperationUnitHospitalRoomRadio(){

  }

  /**
   * �a���i���j�b�g�^�j���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayClinicRecuperationUnitHospitalRoomRadioModel(){

    getShortStayClinicRecuperationUnitHospitalRoomRadioItem1().setButtonIndex(1);
    getShortStayClinicRecuperationUnitHospitalRoomRadioModel().add(getShortStayClinicRecuperationUnitHospitalRoomRadioItem1());

    getShortStayClinicRecuperationUnitHospitalRoomRadioItem2().setButtonIndex(2);
    getShortStayClinicRecuperationUnitHospitalRoomRadioModel().add(getShortStayClinicRecuperationUnitHospitalRoomRadioItem2());

  }

  /**
   * ���j�b�g�^���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayClinicRecuperationUnitHospitalRoomRadioItem1(){

  }

  /**
   * ���j�b�g�^�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayClinicRecuperationUnitHospitalRoomRadioItem2(){

  }

  /**
   * �a���敪���W�I�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayClinicRecuperationSickroomDivisionRadio(){

  }

  /**
   * �a���敪���W�I���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayClinicRecuperationSickroomDivisionRadioModel(){

    getShortStayClinicRecuperationSickroomDivisionRadioItem1().setButtonIndex(1);
    getShortStayClinicRecuperationSickroomDivisionRadioModel().add(getShortStayClinicRecuperationSickroomDivisionRadioItem1());

    getShortStayClinicRecuperationSickroomDivisionRadioItem2().setButtonIndex(2);
    getShortStayClinicRecuperationSickroomDivisionRadioModel().add(getShortStayClinicRecuperationSickroomDivisionRadioItem2());

    getShortStayClinicRecuperationSickroomDivisionRadioItem3().setButtonIndex(3);
    getShortStayClinicRecuperationSickroomDivisionRadioModel().add(getShortStayClinicRecuperationSickroomDivisionRadioItem3());

    getShortStayClinicRecuperationSickroomDivisionRadioItem4().setButtonIndex(4);
    getShortStayClinicRecuperationSickroomDivisionRadioModel().add(getShortStayClinicRecuperationSickroomDivisionRadioItem4());

  }

  /**
   * �]���^���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayClinicRecuperationSickroomDivisionRadioItem1(){

  }

  /**
   * �������ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayClinicRecuperationSickroomDivisionRadioItem2(){

  }

  /**
   * ���j�b�g�^���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayClinicRecuperationSickroomDivisionRadioItem3(){

  }

  /**
   * ���j�b�g�^�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayClinicRecuperationSickroomDivisionRadioItem4(){

  }

  /**
   * �×{�����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayClinicRecuperationSubtractionType(){

  }

  /**
   * �×{�����Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayClinicRecuperationSubtractionTypeModel(){

    getShortStayClinicRecuperationSubtractionTypeNormal().setButtonIndex(1);
    getShortStayClinicRecuperationSubtractionTypeModel().add(getShortStayClinicRecuperationSubtractionTypeNormal());

    getShortStayClinicRecuperationSubtractionType1().setButtonIndex(2);
    getShortStayClinicRecuperationSubtractionTypeModel().add(getShortStayClinicRecuperationSubtractionType1());

    getShortStayClinicRecuperationSubtractionType2().setButtonIndex(3);
    getShortStayClinicRecuperationSubtractionTypeModel().add(getShortStayClinicRecuperationSubtractionType2());

  }

  /**
   * ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayClinicRecuperationSubtractionTypeNormal(){

  }

  /**
   * ��I�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayClinicRecuperationSubtractionType1(){

  }

  /**
   * ��II�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayClinicRecuperationSubtractionType2(){

  }

  /**
   * ���}���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayClinicRecuperationMeetingAndSendingOff(){

  }

  /**
   * ���}���Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayClinicRecuperationMeetingAndSendingOffModel(){

    getShortStayClinicRecuperationMeetingAndSendingOffNone().setButtonIndex(1);
    getShortStayClinicRecuperationMeetingAndSendingOffModel().add(getShortStayClinicRecuperationMeetingAndSendingOffNone());

    getShortStayClinicRecuperationMeetingAndSendingOffOneWay().setButtonIndex(2);
    getShortStayClinicRecuperationMeetingAndSendingOffModel().add(getShortStayClinicRecuperationMeetingAndSendingOffOneWay());

    getShortStayClinicRecuperationMeetingAndSendingOffRoundTrip().setButtonIndex(3);
    getShortStayClinicRecuperationMeetingAndSendingOffModel().add(getShortStayClinicRecuperationMeetingAndSendingOffRoundTrip());

  }

  /**
   * ���}�Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayClinicRecuperationMeetingAndSendingOffNone(){

  }

  /**
   * ���}�Г��ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayClinicRecuperationMeetingAndSendingOffOneWay(){

  }

  /**
   * ���}�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayClinicRecuperationMeetingAndSendingOffRoundTrip(){

  }

  /**
   * �h�{�Ǘ��̐����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayClinicRecuperationDieticianManageRadio(){

  }

  /**
   * �h�{�Ǘ��̐����Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayClinicRecuperationDieticianManageRadioModel(){

    getShortStayClinicRecuperationDieticianManageRadioItem1().setButtonIndex(1);
    getShortStayClinicRecuperationDieticianManageRadioModel().add(getShortStayClinicRecuperationDieticianManageRadioItem1());

    getShortStayClinicRecuperationDieticianManageRadioItem2().setButtonIndex(2);
    getShortStayClinicRecuperationDieticianManageRadioModel().add(getShortStayClinicRecuperationDieticianManageRadioItem2());

    getShortStayClinicRecuperationDieticianManageRadioItem3().setButtonIndex(3);
    getShortStayClinicRecuperationDieticianManageRadioModel().add(getShortStayClinicRecuperationDieticianManageRadioItem3());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayClinicRecuperationDieticianManageRadioItem1(){

  }

  /**
   * �Ǘ��h�{�m�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayClinicRecuperationDieticianManageRadioItem2(){

  }

  /**
   * �h�{�m�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayClinicRecuperationDieticianManageRadioItem3(){

  }

  /**
   * �×{�H���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayClinicRecuperationMedicalExpensesRadio(){

  }

  /**
   * �×{�H���Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayClinicRecuperationMedicalExpensesRadioModel(){

    getShortStayClinicRecuperationMedicalExpensesRadioItem1().setButtonIndex(1);
    getShortStayClinicRecuperationMedicalExpensesRadioModel().add(getShortStayClinicRecuperationMedicalExpensesRadioItem1());

    getShortStayClinicRecuperationMedicalExpensesRadioItem2().setButtonIndex(2);
    getShortStayClinicRecuperationMedicalExpensesRadioModel().add(getShortStayClinicRecuperationMedicalExpensesRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayClinicRecuperationMedicalExpensesRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayClinicRecuperationMedicalExpensesRadioItem2(){

  }

  /**
   * �l�����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayClinicRecuperationStaffReduceRadio(){

  }

  /**
   * �l�����Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayClinicRecuperationStaffReduceRadioModel(){

    getShortStayClinicRecuperationStaffReduceRadioItem1().setButtonIndex(1);
    getShortStayClinicRecuperationStaffReduceRadioModel().add(getShortStayClinicRecuperationStaffReduceRadioItem1());

    getShortStayClinicRecuperationStaffReduceRadioItem2().setButtonIndex(2);
    getShortStayClinicRecuperationStaffReduceRadioModel().add(getShortStayClinicRecuperationStaffReduceRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayClinicRecuperationStaffReduceRadioItem1(){

  }

  /**
   * ������߂ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayClinicRecuperationStaffReduceRadioItem2(){

  }

  /**
   * �^�u2�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTab2(){

    tab2.add(getShortStayClinicRecuperationSpecificConsultationFee(), VRLayout.FLOW);

    tab2.add(getShortStayClinicRecuperationSpecificConsultationFeeOutline(), VRLayout.FLOW_RETURN);

    tab2.add(getShortStayClinicRecuperationDinnerContainer(), VRLayout.FLOW_DOUBLEINSETLINE_RETURN);

    tab2.add(getShortStayClinicRecuperationEtc30Over(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getShortStayClinicRecuperationUnitCareMaintenanceRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getShortStayClinicRecuperationEmergencyNetworkAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * ����f�Ô�{�^���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayClinicRecuperationSpecificConsultationFee(){

  }

  /**
   * �ݒ胉�x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayClinicRecuperationSpecificConsultationFeeOutline(){

  }

  /**
   * �H���R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayClinicRecuperationDinnerContainer(){

    shortStayClinicRecuperationDinnerContainer.add(getShortStayClinicRecuperationDinnerOfferContainer(), VRLayout.FLOW);

    shortStayClinicRecuperationDinnerContainer.add(getShortStayClinicRecuperationDinnerCostContainer(), VRLayout.FLOW);

  }

  /**
   * �H���񋟂ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayClinicRecuperationDinnerOffer(){

  }

  /**
   * �H���񋟃��f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayClinicRecuperationDinnerOfferModel(){

  }

  /**
   * �H����p�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayClinicRecuperationDinnerCost(){

  }

  /**
   * 30�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayClinicRecuperationEtc30Over(){

  }

  /**
   * ���j�b�g�P�A�̐����ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayClinicRecuperationUnitCareMaintenanceRadio(){

  }

  /**
   * ���j�b�g�P�A�̐������f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayClinicRecuperationUnitCareMaintenanceRadioModel(){

    getShortStayClinicRecuperationUnitCareMaintenanceRadioitem1().setButtonIndex(1);
    getShortStayClinicRecuperationUnitCareMaintenanceRadioModel().add(getShortStayClinicRecuperationUnitCareMaintenanceRadioitem1());

    getShortStayClinicRecuperationUnitCareMaintenanceRadioitem2().setButtonIndex(2);
    getShortStayClinicRecuperationUnitCareMaintenanceRadioModel().add(getShortStayClinicRecuperationUnitCareMaintenanceRadioitem2());

  }

  /**
   * �������ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayClinicRecuperationUnitCareMaintenanceRadioitem1(){

  }

  /**
   * �����ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayClinicRecuperationUnitCareMaintenanceRadioitem2(){

  }

  /**
   * �ً}�Z�������l�b�g���[�N���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayClinicRecuperationEmergencyNetworkAddRadio(){

  }

  /**
   * �ً}�Z�������l�b�g���[�N���Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayClinicRecuperationEmergencyNetworkAddRadioModel(){

    getShortStayClinicRecuperationEmergencyNetworkAddRadioItem1().setButtonIndex(1);
    getShortStayClinicRecuperationEmergencyNetworkAddRadioModel().add(getShortStayClinicRecuperationEmergencyNetworkAddRadioItem1());

    getShortStayClinicRecuperationEmergencyNetworkAddRadioItem2().setButtonIndex(2);
    getShortStayClinicRecuperationEmergencyNetworkAddRadioModel().add(getShortStayClinicRecuperationEmergencyNetworkAddRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayClinicRecuperationEmergencyNetworkAddRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayClinicRecuperationEmergencyNetworkAddRadioItem2(){

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
      ACFrame.debugStart(new ACAffairInfo(QS001112Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QS001112Design getThis() {
    return this;
  }
}
