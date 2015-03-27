
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
 * �쐬��: 2015/02/19  ���{�R���s���[�^�[������� ����@��F �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �T�[�r�X�\��쐬/�ύX (S)
 * �v���Z�X �T�[�r�X�\��T�� (001)
 * �v���O���� �T�[�r�X�p�^�[�����\�h�Z�������×{���i�F�m�ǁj (QS001_12613_201504)
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
 * �T�[�r�X�p�^�[�����\�h�Z�������×{���i�F�m�ǁj��ʍ��ڃf�U�C��(QS001_12613_201504) 
 */
public class QS001_12613_201504Design extends QS001ServicePanel {
  //GUI�R���|�[�l���g

  private JTabbedPane tabs;

  private ACPanel tab1;

  private ACValueArrayRadioButtonGroup shortStayDementiaRecuperationInstitutionDivisionRadio;

  private ACLabelContainer shortStayDementiaRecuperationInstitutionDivisionRadioContainer;

  private ACListModelAdapter shortStayDementiaRecuperationInstitutionDivisionRadioModel;

  private ACRadioButtonItem shortStayDementiaRecuperationInstitutionDivisionRadioItem1;

  private ACRadioButtonItem shortStayDementiaRecuperationInstitutionDivisionRadioItem2;

  private ACRadioButtonItem shortStayDementiaRecuperationInstitutionDivisionRadioItem3;

  private ACValueArrayRadioButtonGroup shortStayDementiaRecuperationHospitalDivisionRadio;

  private ACLabelContainer shortStayDementiaRecuperationHospitalDivisionRadioContainer;

  private ACListModelAdapter shortStayDementiaRecuperationHospitalDivisionRadioModel;

  private ACRadioButtonItem shortStayDementiaRecuperationHospitalDivisionRadioItem1;

  private ACRadioButtonItem shortStayDementiaRecuperationHospitalDivisionRadioItem2;

  private ACValueArrayRadioButtonGroup shortStayDementiaRecuperationDivision;

  private ACLabelContainer shortStayDementiaRecuperationDivisionContainer;

  private ACListModelAdapter shortStayDementiaRecuperationDivisionModel;

  private ACRadioButtonItem shortStayDementiaRecuperationType1;

  private ACRadioButtonItem shortStayDementiaRecuperationType2;

  private ACRadioButtonItem shortStayDementiaRecuperationType3;

  private ACRadioButtonItem shortStayDementiaRecuperationType4;

  private ACRadioButtonItem shortStayDementiaRecuperationType5;

  private ACLabelContainer shortStayDementiaRecuperationHospitalRoomDivisionContena;

  private ACValueArrayRadioButtonGroup shortStayDementiaRecuperationHospitalRoomRadio;

  private ACListModelAdapter shortStayDementiaRecuperationHospitalRoomRadioModel;

  private ACRadioButtonItem shortStayDementiaRecuperationHospitalRoomRadioItem1;

  private ACRadioButtonItem shortStayDementiaRecuperationHospitalRoomRadioItem2;

  private ACValueArrayRadioButtonGroup shortStayDementiaRecuperationUnitHospitalRoomRadio;

  private ACListModelAdapter shortStayDementiaRecuperationUnitHospitalRoomRadioModel;

  private ACRadioButtonItem shortStayDementiaRecuperationUnitHospitalRoomRadioItem1;

  private ACRadioButtonItem shortStayDementiaRecuperationUnitHospitalRoomRadioItem2;

  private ACValueArrayRadioButtonGroup shortStayDementiaRecuperationMeetingAndSendingOff;

  private ACLabelContainer shortStayDementiaRecuperationMeetingAndSendingOffContainer;

  private ACListModelAdapter shortStayDementiaRecuperationMeetingAndSendingOffModel;

  private ACRadioButtonItem shortStayDementiaRecuperationMeetingAndSendingOffNone;

  private ACRadioButtonItem shortStayDementiaRecuperationMeetingAndSendingOffOneWay;

  private ACRadioButtonItem shortStayDementiaRecuperationMeetingAndSendingOffRoundTrip;

  private ACValueArrayRadioButtonGroup shortStayDementiaRecuperationMedicalExpensesRadio;

  private ACLabelContainer shortStayDementiaRecuperationMedicalExpensesRadioContainer;

  private ACListModelAdapter shortStayDementiaRecuperationMedicalExpensesRadioModel;

  private ACRadioButtonItem shortStayDementiaRecuperationMedicalExpensesRadioItem1;

  private ACRadioButtonItem shortStayDementiaRecuperationMedicalExpensesRadioItem2;

  private ACPanel tab2;

  private ACMapBindButton shortStayDementiaRecuperationSpecificConsultationFee;

  private ACLabel shortStayDementiaRecuperationSpecificConsultationFeeOutline;

  private ACComboBox shortStayDementiaRecuperationPersonSubtraction;

  private ACLabelContainer shortStayDementiaRecuperationPersonSubtractionContainer;

  private ACComboBoxModelAdapter shortStayDementiaRecuperationPersonSubtractionModel;

  private ACBackLabelContainer shortStayDementiaRecuperationDinnerContainer;

  private ACComboBox shortStayDementiaRecuperationDinnerOffer;

  private ACLabelContainer shortStayDementiaRecuperationDinnerOfferContainer;

  private ACComboBoxModelAdapter shortStayDementiaRecuperationDinnerOfferModel;

  private ACTextField shortStayDementiaRecuperationDinnerCost;

  private ACLabelContainer shortStayDementiaRecuperationDinnerCostContainer;

  private ACIntegerCheckBox shortStayDementiaRecuperationEtc30Over;

  private ACValueArrayRadioButtonGroup shortStayDementiaRecuperationUnitCareMaintenanceRadio;

  private ACLabelContainer shortStayDementiaRecuperationUnitCareMaintenanceRadioContainer;

  private ACListModelAdapter shortStayDementiaRecuperationUnitCareMaintenanceRadioModel;

  private ACRadioButtonItem shortStayDementiaRecuperationUnitCareMaintenanceRadioItem1;

  private ACRadioButtonItem shortStayDementiaRecuperationUnitCareMaintenanceRadioItem2;

  private ACValueArrayRadioButtonGroup serviceAddProvisionStructuralRadioGroup;

  private ACLabelContainer serviceAddProvisionStructuralRadioGroupContainer;

  private ACListModelAdapter serviceAddProvisionStructuralRadioGroupModel;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem1;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem5;

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
  public ACValueArrayRadioButtonGroup getShortStayDementiaRecuperationInstitutionDivisionRadio(){
    if(shortStayDementiaRecuperationInstitutionDivisionRadio==null){

      shortStayDementiaRecuperationInstitutionDivisionRadio = new ACValueArrayRadioButtonGroup();

      getShortStayDementiaRecuperationInstitutionDivisionRadioContainer().setText("�{�ݓ��̋敪");

      shortStayDementiaRecuperationInstitutionDivisionRadio.setBindPath("1260301");

      shortStayDementiaRecuperationInstitutionDivisionRadio.setUseClearButton(false);

      shortStayDementiaRecuperationInstitutionDivisionRadio.setModel(getShortStayDementiaRecuperationInstitutionDivisionRadioModel());

      shortStayDementiaRecuperationInstitutionDivisionRadio.setValues(new int[]{1,2,3});

      addShortStayDementiaRecuperationInstitutionDivisionRadio();
    }
    return shortStayDementiaRecuperationInstitutionDivisionRadio;

  }

  /**
   * �{�ݓ��̋敪�R���e�i���擾���܂��B
   * @return �{�ݓ��̋敪�R���e�i
   */
  protected ACLabelContainer getShortStayDementiaRecuperationInstitutionDivisionRadioContainer(){
    if(shortStayDementiaRecuperationInstitutionDivisionRadioContainer==null){
      shortStayDementiaRecuperationInstitutionDivisionRadioContainer = new ACLabelContainer();
      shortStayDementiaRecuperationInstitutionDivisionRadioContainer.setFollowChildEnabled(true);
      shortStayDementiaRecuperationInstitutionDivisionRadioContainer.setVAlignment(VRLayout.CENTER);
      shortStayDementiaRecuperationInstitutionDivisionRadioContainer.add(getShortStayDementiaRecuperationInstitutionDivisionRadio(), null);
    }
    return shortStayDementiaRecuperationInstitutionDivisionRadioContainer;
  }

  /**
   * �{�ݓ��̋敪���f�����擾���܂��B
   * @return �{�ݓ��̋敪���f��
   */
  protected ACListModelAdapter getShortStayDementiaRecuperationInstitutionDivisionRadioModel(){
    if(shortStayDementiaRecuperationInstitutionDivisionRadioModel==null){
      shortStayDementiaRecuperationInstitutionDivisionRadioModel = new ACListModelAdapter();
      addShortStayDementiaRecuperationInstitutionDivisionRadioModel();
    }
    return shortStayDementiaRecuperationInstitutionDivisionRadioModel;
  }

  /**
   * �F�m�ǎ����^���擾���܂��B
   * @return �F�m�ǎ����^
   */
  public ACRadioButtonItem getShortStayDementiaRecuperationInstitutionDivisionRadioItem1(){
    if(shortStayDementiaRecuperationInstitutionDivisionRadioItem1==null){

      shortStayDementiaRecuperationInstitutionDivisionRadioItem1 = new ACRadioButtonItem();

      shortStayDementiaRecuperationInstitutionDivisionRadioItem1.setText("�F�m�ǎ����^");

      shortStayDementiaRecuperationInstitutionDivisionRadioItem1.setGroup(getShortStayDementiaRecuperationInstitutionDivisionRadio());

      shortStayDementiaRecuperationInstitutionDivisionRadioItem1.setConstraints(VRLayout.FLOW_RETURN);

      addShortStayDementiaRecuperationInstitutionDivisionRadioItem1();
    }
    return shortStayDementiaRecuperationInstitutionDivisionRadioItem1;

  }

  /**
   * ���j�b�g�^�F�m�ǎ����^���擾���܂��B
   * @return ���j�b�g�^�F�m�ǎ����^
   */
  public ACRadioButtonItem getShortStayDementiaRecuperationInstitutionDivisionRadioItem2(){
    if(shortStayDementiaRecuperationInstitutionDivisionRadioItem2==null){

      shortStayDementiaRecuperationInstitutionDivisionRadioItem2 = new ACRadioButtonItem();

      shortStayDementiaRecuperationInstitutionDivisionRadioItem2.setText("���j�b�g�^�F�m�ǎ����^");

      shortStayDementiaRecuperationInstitutionDivisionRadioItem2.setGroup(getShortStayDementiaRecuperationInstitutionDivisionRadio());

      shortStayDementiaRecuperationInstitutionDivisionRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

      addShortStayDementiaRecuperationInstitutionDivisionRadioItem2();
    }
    return shortStayDementiaRecuperationInstitutionDivisionRadioItem2;

  }

  /**
   * �o�ߌ^���擾���܂��B
   * @return �o�ߌ^
   */
  public ACRadioButtonItem getShortStayDementiaRecuperationInstitutionDivisionRadioItem3(){
    if(shortStayDementiaRecuperationInstitutionDivisionRadioItem3==null){

      shortStayDementiaRecuperationInstitutionDivisionRadioItem3 = new ACRadioButtonItem();

      shortStayDementiaRecuperationInstitutionDivisionRadioItem3.setText("�o�ߌ^");

      shortStayDementiaRecuperationInstitutionDivisionRadioItem3.setGroup(getShortStayDementiaRecuperationInstitutionDivisionRadio());

      shortStayDementiaRecuperationInstitutionDivisionRadioItem3.setConstraints(VRLayout.FLOW);

      addShortStayDementiaRecuperationInstitutionDivisionRadioItem3();
    }
    return shortStayDementiaRecuperationInstitutionDivisionRadioItem3;

  }

  /**
   * �a�@�敪���擾���܂��B
   * @return �a�@�敪
   */
  public ACValueArrayRadioButtonGroup getShortStayDementiaRecuperationHospitalDivisionRadio(){
    if(shortStayDementiaRecuperationHospitalDivisionRadio==null){

      shortStayDementiaRecuperationHospitalDivisionRadio = new ACValueArrayRadioButtonGroup();

      getShortStayDementiaRecuperationHospitalDivisionRadioContainer().setText("�a�@�敪");

      shortStayDementiaRecuperationHospitalDivisionRadio.setBindPath("1260302");

      shortStayDementiaRecuperationHospitalDivisionRadio.setUseClearButton(false);

      shortStayDementiaRecuperationHospitalDivisionRadio.setModel(getShortStayDementiaRecuperationHospitalDivisionRadioModel());

      shortStayDementiaRecuperationHospitalDivisionRadio.setValues(new int[]{1,2});

      addShortStayDementiaRecuperationHospitalDivisionRadio();
    }
    return shortStayDementiaRecuperationHospitalDivisionRadio;

  }

  /**
   * �a�@�敪�R���e�i���擾���܂��B
   * @return �a�@�敪�R���e�i
   */
  protected ACLabelContainer getShortStayDementiaRecuperationHospitalDivisionRadioContainer(){
    if(shortStayDementiaRecuperationHospitalDivisionRadioContainer==null){
      shortStayDementiaRecuperationHospitalDivisionRadioContainer = new ACLabelContainer();
      shortStayDementiaRecuperationHospitalDivisionRadioContainer.setFollowChildEnabled(true);
      shortStayDementiaRecuperationHospitalDivisionRadioContainer.setVAlignment(VRLayout.CENTER);
      shortStayDementiaRecuperationHospitalDivisionRadioContainer.add(getShortStayDementiaRecuperationHospitalDivisionRadio(), null);
    }
    return shortStayDementiaRecuperationHospitalDivisionRadioContainer;
  }

  /**
   * �a�@�敪���f�����擾���܂��B
   * @return �a�@�敪���f��
   */
  protected ACListModelAdapter getShortStayDementiaRecuperationHospitalDivisionRadioModel(){
    if(shortStayDementiaRecuperationHospitalDivisionRadioModel==null){
      shortStayDementiaRecuperationHospitalDivisionRadioModel = new ACListModelAdapter();
      addShortStayDementiaRecuperationHospitalDivisionRadioModel();
    }
    return shortStayDementiaRecuperationHospitalDivisionRadioModel;
  }

  /**
   * ��w�a�@���擾���܂��B
   * @return ��w�a�@
   */
  public ACRadioButtonItem getShortStayDementiaRecuperationHospitalDivisionRadioItem1(){
    if(shortStayDementiaRecuperationHospitalDivisionRadioItem1==null){

      shortStayDementiaRecuperationHospitalDivisionRadioItem1 = new ACRadioButtonItem();

      shortStayDementiaRecuperationHospitalDivisionRadioItem1.setText("��w�a�@");

      shortStayDementiaRecuperationHospitalDivisionRadioItem1.setGroup(getShortStayDementiaRecuperationHospitalDivisionRadio());

      shortStayDementiaRecuperationHospitalDivisionRadioItem1.setConstraints(VRLayout.FLOW);

      addShortStayDementiaRecuperationHospitalDivisionRadioItem1();
    }
    return shortStayDementiaRecuperationHospitalDivisionRadioItem1;

  }

  /**
   * ��ʕa�@���擾���܂��B
   * @return ��ʕa�@
   */
  public ACRadioButtonItem getShortStayDementiaRecuperationHospitalDivisionRadioItem2(){
    if(shortStayDementiaRecuperationHospitalDivisionRadioItem2==null){

      shortStayDementiaRecuperationHospitalDivisionRadioItem2 = new ACRadioButtonItem();

      shortStayDementiaRecuperationHospitalDivisionRadioItem2.setText("��ʕa�@");

      shortStayDementiaRecuperationHospitalDivisionRadioItem2.setGroup(getShortStayDementiaRecuperationHospitalDivisionRadio());

      shortStayDementiaRecuperationHospitalDivisionRadioItem2.setConstraints(VRLayout.FLOW);

      addShortStayDementiaRecuperationHospitalDivisionRadioItem2();
    }
    return shortStayDementiaRecuperationHospitalDivisionRadioItem2;

  }

  /**
   * �l���z�u�敪���擾���܂��B
   * @return �l���z�u�敪
   */
  public ACValueArrayRadioButtonGroup getShortStayDementiaRecuperationDivision(){
    if(shortStayDementiaRecuperationDivision==null){

      shortStayDementiaRecuperationDivision = new ACValueArrayRadioButtonGroup();

      getShortStayDementiaRecuperationDivisionContainer().setText("�l���z�u�敪");

      shortStayDementiaRecuperationDivision.setBindPath("1260303");

      shortStayDementiaRecuperationDivision.setUseClearButton(false);

      shortStayDementiaRecuperationDivision.setModel(getShortStayDementiaRecuperationDivisionModel());

      shortStayDementiaRecuperationDivision.setValues(new int[]{1,2,3,4,5});

      addShortStayDementiaRecuperationDivision();
    }
    return shortStayDementiaRecuperationDivision;

  }

  /**
   * �l���z�u�敪�R���e�i���擾���܂��B
   * @return �l���z�u�敪�R���e�i
   */
  protected ACLabelContainer getShortStayDementiaRecuperationDivisionContainer(){
    if(shortStayDementiaRecuperationDivisionContainer==null){
      shortStayDementiaRecuperationDivisionContainer = new ACLabelContainer();
      shortStayDementiaRecuperationDivisionContainer.setFollowChildEnabled(true);
      shortStayDementiaRecuperationDivisionContainer.setVAlignment(VRLayout.CENTER);
      shortStayDementiaRecuperationDivisionContainer.add(getShortStayDementiaRecuperationDivision(), null);
    }
    return shortStayDementiaRecuperationDivisionContainer;
  }

  /**
   * �l���z�u�敪���f�����擾���܂��B
   * @return �l���z�u�敪���f��
   */
  protected ACListModelAdapter getShortStayDementiaRecuperationDivisionModel(){
    if(shortStayDementiaRecuperationDivisionModel==null){
      shortStayDementiaRecuperationDivisionModel = new ACListModelAdapter();
      addShortStayDementiaRecuperationDivisionModel();
    }
    return shortStayDementiaRecuperationDivisionModel;
  }

  /**
   * I�^���擾���܂��B
   * @return I�^
   */
  public ACRadioButtonItem getShortStayDementiaRecuperationType1(){
    if(shortStayDementiaRecuperationType1==null){

      shortStayDementiaRecuperationType1 = new ACRadioButtonItem();

      shortStayDementiaRecuperationType1.setText("I�^");

      shortStayDementiaRecuperationType1.setGroup(getShortStayDementiaRecuperationDivision());

      shortStayDementiaRecuperationType1.setConstraints(VRLayout.FLOW);

      addShortStayDementiaRecuperationType1();
    }
    return shortStayDementiaRecuperationType1;

  }

  /**
   * II�^���擾���܂��B
   * @return II�^
   */
  public ACRadioButtonItem getShortStayDementiaRecuperationType2(){
    if(shortStayDementiaRecuperationType2==null){

      shortStayDementiaRecuperationType2 = new ACRadioButtonItem();

      shortStayDementiaRecuperationType2.setText("II�^");

      shortStayDementiaRecuperationType2.setGroup(getShortStayDementiaRecuperationDivision());

      shortStayDementiaRecuperationType2.setConstraints(VRLayout.FLOW);

      addShortStayDementiaRecuperationType2();
    }
    return shortStayDementiaRecuperationType2;

  }

  /**
   * III�^���擾���܂��B
   * @return III�^
   */
  public ACRadioButtonItem getShortStayDementiaRecuperationType3(){
    if(shortStayDementiaRecuperationType3==null){

      shortStayDementiaRecuperationType3 = new ACRadioButtonItem();

      shortStayDementiaRecuperationType3.setText("III�^");

      shortStayDementiaRecuperationType3.setGroup(getShortStayDementiaRecuperationDivision());

      shortStayDementiaRecuperationType3.setConstraints(VRLayout.FLOW_RETURN);

      addShortStayDementiaRecuperationType3();
    }
    return shortStayDementiaRecuperationType3;

  }

  /**
   * IV�^���擾���܂��B
   * @return IV�^
   */
  public ACRadioButtonItem getShortStayDementiaRecuperationType4(){
    if(shortStayDementiaRecuperationType4==null){

      shortStayDementiaRecuperationType4 = new ACRadioButtonItem();

      shortStayDementiaRecuperationType4.setText("IV�^");

      shortStayDementiaRecuperationType4.setGroup(getShortStayDementiaRecuperationDivision());

      shortStayDementiaRecuperationType4.setConstraints(VRLayout.FLOW);

      addShortStayDementiaRecuperationType4();
    }
    return shortStayDementiaRecuperationType4;

  }

  /**
   * V�^���擾���܂��B
   * @return V�^
   */
  public ACRadioButtonItem getShortStayDementiaRecuperationType5(){
    if(shortStayDementiaRecuperationType5==null){

      shortStayDementiaRecuperationType5 = new ACRadioButtonItem();

      shortStayDementiaRecuperationType5.setText("V�^");

      shortStayDementiaRecuperationType5.setGroup(getShortStayDementiaRecuperationDivision());

      shortStayDementiaRecuperationType5.setConstraints(VRLayout.FLOW);

      addShortStayDementiaRecuperationType5();
    }
    return shortStayDementiaRecuperationType5;

  }

  /**
   * �a���敪�R���e�i���擾���܂��B
   * @return �a���敪�R���e�i
   */
  public ACLabelContainer getShortStayDementiaRecuperationHospitalRoomDivisionContena(){
    if(shortStayDementiaRecuperationHospitalRoomDivisionContena==null){

      shortStayDementiaRecuperationHospitalRoomDivisionContena = new ACLabelContainer();

      shortStayDementiaRecuperationHospitalRoomDivisionContena.setText("�a���敪");

      shortStayDementiaRecuperationHospitalRoomDivisionContena.setFollowChildEnabled(true);

      addShortStayDementiaRecuperationHospitalRoomDivisionContena();
    }
    return shortStayDementiaRecuperationHospitalRoomDivisionContena;

  }

  /**
   * �a���敪�i���V�l�ی��{�݁j���擾���܂��B
   * @return �a���敪�i���V�l�ی��{�݁j
   */
  public ACValueArrayRadioButtonGroup getShortStayDementiaRecuperationHospitalRoomRadio(){
    if(shortStayDementiaRecuperationHospitalRoomRadio==null){

      shortStayDementiaRecuperationHospitalRoomRadio = new ACValueArrayRadioButtonGroup();

      shortStayDementiaRecuperationHospitalRoomRadio.setBindPath("1260304");

      shortStayDementiaRecuperationHospitalRoomRadio.setUseClearButton(false);

      shortStayDementiaRecuperationHospitalRoomRadio.setModel(getShortStayDementiaRecuperationHospitalRoomRadioModel());

      shortStayDementiaRecuperationHospitalRoomRadio.setValues(new int[]{1,2});

      addShortStayDementiaRecuperationHospitalRoomRadio();
    }
    return shortStayDementiaRecuperationHospitalRoomRadio;

  }

  /**
   * �a���敪�i���V�l�ی��{�݁j���f�����擾���܂��B
   * @return �a���敪�i���V�l�ی��{�݁j���f��
   */
  protected ACListModelAdapter getShortStayDementiaRecuperationHospitalRoomRadioModel(){
    if(shortStayDementiaRecuperationHospitalRoomRadioModel==null){
      shortStayDementiaRecuperationHospitalRoomRadioModel = new ACListModelAdapter();
      addShortStayDementiaRecuperationHospitalRoomRadioModel();
    }
    return shortStayDementiaRecuperationHospitalRoomRadioModel;
  }

  /**
   * �]���^�����擾���܂��B
   * @return �]���^��
   */
  public ACRadioButtonItem getShortStayDementiaRecuperationHospitalRoomRadioItem1(){
    if(shortStayDementiaRecuperationHospitalRoomRadioItem1==null){

      shortStayDementiaRecuperationHospitalRoomRadioItem1 = new ACRadioButtonItem();

      shortStayDementiaRecuperationHospitalRoomRadioItem1.setText("�]���^��");

      shortStayDementiaRecuperationHospitalRoomRadioItem1.setGroup(getShortStayDementiaRecuperationHospitalRoomRadio());

      shortStayDementiaRecuperationHospitalRoomRadioItem1.setConstraints(VRLayout.FLOW);

      addShortStayDementiaRecuperationHospitalRoomRadioItem1();
    }
    return shortStayDementiaRecuperationHospitalRoomRadioItem1;

  }

  /**
   * ���������擾���܂��B
   * @return ������
   */
  public ACRadioButtonItem getShortStayDementiaRecuperationHospitalRoomRadioItem2(){
    if(shortStayDementiaRecuperationHospitalRoomRadioItem2==null){

      shortStayDementiaRecuperationHospitalRoomRadioItem2 = new ACRadioButtonItem();

      shortStayDementiaRecuperationHospitalRoomRadioItem2.setText("������");

      shortStayDementiaRecuperationHospitalRoomRadioItem2.setGroup(getShortStayDementiaRecuperationHospitalRoomRadio());

      shortStayDementiaRecuperationHospitalRoomRadioItem2.setConstraints(VRLayout.FLOW);

      addShortStayDementiaRecuperationHospitalRoomRadioItem2();
    }
    return shortStayDementiaRecuperationHospitalRoomRadioItem2;

  }

  /**
   * �a���敪�i���j�b�g�^�j���擾���܂��B
   * @return �a���敪�i���j�b�g�^�j
   */
  public ACValueArrayRadioButtonGroup getShortStayDementiaRecuperationUnitHospitalRoomRadio(){
    if(shortStayDementiaRecuperationUnitHospitalRoomRadio==null){

      shortStayDementiaRecuperationUnitHospitalRoomRadio = new ACValueArrayRadioButtonGroup();

      shortStayDementiaRecuperationUnitHospitalRoomRadio.setBindPath("1260305");

      shortStayDementiaRecuperationUnitHospitalRoomRadio.setUseClearButton(false);

      shortStayDementiaRecuperationUnitHospitalRoomRadio.setModel(getShortStayDementiaRecuperationUnitHospitalRoomRadioModel());

      shortStayDementiaRecuperationUnitHospitalRoomRadio.setValues(new int[]{1,2});

      addShortStayDementiaRecuperationUnitHospitalRoomRadio();
    }
    return shortStayDementiaRecuperationUnitHospitalRoomRadio;

  }

  /**
   * �a���敪�i���j�b�g�^�j���f�����擾���܂��B
   * @return �a���敪�i���j�b�g�^�j���f��
   */
  protected ACListModelAdapter getShortStayDementiaRecuperationUnitHospitalRoomRadioModel(){
    if(shortStayDementiaRecuperationUnitHospitalRoomRadioModel==null){
      shortStayDementiaRecuperationUnitHospitalRoomRadioModel = new ACListModelAdapter();
      addShortStayDementiaRecuperationUnitHospitalRoomRadioModel();
    }
    return shortStayDementiaRecuperationUnitHospitalRoomRadioModel;
  }

  /**
   * ���j�b�g�^�����擾���܂��B
   * @return ���j�b�g�^��
   */
  public ACRadioButtonItem getShortStayDementiaRecuperationUnitHospitalRoomRadioItem1(){
    if(shortStayDementiaRecuperationUnitHospitalRoomRadioItem1==null){

      shortStayDementiaRecuperationUnitHospitalRoomRadioItem1 = new ACRadioButtonItem();

      shortStayDementiaRecuperationUnitHospitalRoomRadioItem1.setText("���j�b�g�^��");

      shortStayDementiaRecuperationUnitHospitalRoomRadioItem1.setGroup(getShortStayDementiaRecuperationUnitHospitalRoomRadio());

      shortStayDementiaRecuperationUnitHospitalRoomRadioItem1.setConstraints(VRLayout.FLOW);

      addShortStayDementiaRecuperationUnitHospitalRoomRadioItem1();
    }
    return shortStayDementiaRecuperationUnitHospitalRoomRadioItem1;

  }

  /**
   * ���j�b�g�^�������擾���܂��B
   * @return ���j�b�g�^����
   */
  public ACRadioButtonItem getShortStayDementiaRecuperationUnitHospitalRoomRadioItem2(){
    if(shortStayDementiaRecuperationUnitHospitalRoomRadioItem2==null){

      shortStayDementiaRecuperationUnitHospitalRoomRadioItem2 = new ACRadioButtonItem();

      shortStayDementiaRecuperationUnitHospitalRoomRadioItem2.setText("���j�b�g�^����");

      shortStayDementiaRecuperationUnitHospitalRoomRadioItem2.setGroup(getShortStayDementiaRecuperationUnitHospitalRoomRadio());

      shortStayDementiaRecuperationUnitHospitalRoomRadioItem2.setConstraints(VRLayout.FLOW);

      addShortStayDementiaRecuperationUnitHospitalRoomRadioItem2();
    }
    return shortStayDementiaRecuperationUnitHospitalRoomRadioItem2;

  }

  /**
   * ���}�敪���擾���܂��B
   * @return ���}�敪
   */
  public ACValueArrayRadioButtonGroup getShortStayDementiaRecuperationMeetingAndSendingOff(){
    if(shortStayDementiaRecuperationMeetingAndSendingOff==null){

      shortStayDementiaRecuperationMeetingAndSendingOff = new ACValueArrayRadioButtonGroup();

      getShortStayDementiaRecuperationMeetingAndSendingOffContainer().setText("���}���Z");

      shortStayDementiaRecuperationMeetingAndSendingOff.setBindPath("6");

      shortStayDementiaRecuperationMeetingAndSendingOff.setUseClearButton(false);

      shortStayDementiaRecuperationMeetingAndSendingOff.setModel(getShortStayDementiaRecuperationMeetingAndSendingOffModel());

      shortStayDementiaRecuperationMeetingAndSendingOff.setValues(new int[]{1,2,3});

      addShortStayDementiaRecuperationMeetingAndSendingOff();
    }
    return shortStayDementiaRecuperationMeetingAndSendingOff;

  }

  /**
   * ���}�敪�R���e�i���擾���܂��B
   * @return ���}�敪�R���e�i
   */
  protected ACLabelContainer getShortStayDementiaRecuperationMeetingAndSendingOffContainer(){
    if(shortStayDementiaRecuperationMeetingAndSendingOffContainer==null){
      shortStayDementiaRecuperationMeetingAndSendingOffContainer = new ACLabelContainer();
      shortStayDementiaRecuperationMeetingAndSendingOffContainer.setFollowChildEnabled(true);
      shortStayDementiaRecuperationMeetingAndSendingOffContainer.setVAlignment(VRLayout.CENTER);
      shortStayDementiaRecuperationMeetingAndSendingOffContainer.add(getShortStayDementiaRecuperationMeetingAndSendingOff(), null);
    }
    return shortStayDementiaRecuperationMeetingAndSendingOffContainer;
  }

  /**
   * ���}�敪���f�����擾���܂��B
   * @return ���}�敪���f��
   */
  protected ACListModelAdapter getShortStayDementiaRecuperationMeetingAndSendingOffModel(){
    if(shortStayDementiaRecuperationMeetingAndSendingOffModel==null){
      shortStayDementiaRecuperationMeetingAndSendingOffModel = new ACListModelAdapter();
      addShortStayDementiaRecuperationMeetingAndSendingOffModel();
    }
    return shortStayDementiaRecuperationMeetingAndSendingOffModel;
  }

  /**
   * ���}�Ȃ����擾���܂��B
   * @return ���}�Ȃ�
   */
  public ACRadioButtonItem getShortStayDementiaRecuperationMeetingAndSendingOffNone(){
    if(shortStayDementiaRecuperationMeetingAndSendingOffNone==null){

      shortStayDementiaRecuperationMeetingAndSendingOffNone = new ACRadioButtonItem();

      shortStayDementiaRecuperationMeetingAndSendingOffNone.setText("���}�Ȃ�");

      shortStayDementiaRecuperationMeetingAndSendingOffNone.setGroup(getShortStayDementiaRecuperationMeetingAndSendingOff());

      shortStayDementiaRecuperationMeetingAndSendingOffNone.setConstraints(VRLayout.FLOW);

      addShortStayDementiaRecuperationMeetingAndSendingOffNone();
    }
    return shortStayDementiaRecuperationMeetingAndSendingOffNone;

  }

  /**
   * ���}�Г����擾���܂��B
   * @return ���}�Г�
   */
  public ACRadioButtonItem getShortStayDementiaRecuperationMeetingAndSendingOffOneWay(){
    if(shortStayDementiaRecuperationMeetingAndSendingOffOneWay==null){

      shortStayDementiaRecuperationMeetingAndSendingOffOneWay = new ACRadioButtonItem();

      shortStayDementiaRecuperationMeetingAndSendingOffOneWay.setText("���}�Г�");

      shortStayDementiaRecuperationMeetingAndSendingOffOneWay.setGroup(getShortStayDementiaRecuperationMeetingAndSendingOff());

      shortStayDementiaRecuperationMeetingAndSendingOffOneWay.setConstraints(VRLayout.FLOW);

      addShortStayDementiaRecuperationMeetingAndSendingOffOneWay();
    }
    return shortStayDementiaRecuperationMeetingAndSendingOffOneWay;

  }

  /**
   * ���}�������擾���܂��B
   * @return ���}����
   */
  public ACRadioButtonItem getShortStayDementiaRecuperationMeetingAndSendingOffRoundTrip(){
    if(shortStayDementiaRecuperationMeetingAndSendingOffRoundTrip==null){

      shortStayDementiaRecuperationMeetingAndSendingOffRoundTrip = new ACRadioButtonItem();

      shortStayDementiaRecuperationMeetingAndSendingOffRoundTrip.setText("���}����");

      shortStayDementiaRecuperationMeetingAndSendingOffRoundTrip.setGroup(getShortStayDementiaRecuperationMeetingAndSendingOff());

      shortStayDementiaRecuperationMeetingAndSendingOffRoundTrip.setConstraints(VRLayout.FLOW);

      addShortStayDementiaRecuperationMeetingAndSendingOffRoundTrip();
    }
    return shortStayDementiaRecuperationMeetingAndSendingOffRoundTrip;

  }

  /**
   * �×{�H���Z���擾���܂��B
   * @return �×{�H���Z
   */
  public ACValueArrayRadioButtonGroup getShortStayDementiaRecuperationMedicalExpensesRadio(){
    if(shortStayDementiaRecuperationMedicalExpensesRadio==null){

      shortStayDementiaRecuperationMedicalExpensesRadio = new ACValueArrayRadioButtonGroup();

      getShortStayDementiaRecuperationMedicalExpensesRadioContainer().setText("�×{�H���Z");

      shortStayDementiaRecuperationMedicalExpensesRadio.setBindPath("1260307");

      shortStayDementiaRecuperationMedicalExpensesRadio.setUseClearButton(false);

      shortStayDementiaRecuperationMedicalExpensesRadio.setModel(getShortStayDementiaRecuperationMedicalExpensesRadioModel());

      shortStayDementiaRecuperationMedicalExpensesRadio.setValues(new int[]{1,2});

      addShortStayDementiaRecuperationMedicalExpensesRadio();
    }
    return shortStayDementiaRecuperationMedicalExpensesRadio;

  }

  /**
   * �×{�H���Z�R���e�i���擾���܂��B
   * @return �×{�H���Z�R���e�i
   */
  protected ACLabelContainer getShortStayDementiaRecuperationMedicalExpensesRadioContainer(){
    if(shortStayDementiaRecuperationMedicalExpensesRadioContainer==null){
      shortStayDementiaRecuperationMedicalExpensesRadioContainer = new ACLabelContainer();
      shortStayDementiaRecuperationMedicalExpensesRadioContainer.setFollowChildEnabled(true);
      shortStayDementiaRecuperationMedicalExpensesRadioContainer.setVAlignment(VRLayout.CENTER);
      shortStayDementiaRecuperationMedicalExpensesRadioContainer.add(getShortStayDementiaRecuperationMedicalExpensesRadio(), null);
    }
    return shortStayDementiaRecuperationMedicalExpensesRadioContainer;
  }

  /**
   * �×{�H���Z���f�����擾���܂��B
   * @return �×{�H���Z���f��
   */
  protected ACListModelAdapter getShortStayDementiaRecuperationMedicalExpensesRadioModel(){
    if(shortStayDementiaRecuperationMedicalExpensesRadioModel==null){
      shortStayDementiaRecuperationMedicalExpensesRadioModel = new ACListModelAdapter();
      addShortStayDementiaRecuperationMedicalExpensesRadioModel();
    }
    return shortStayDementiaRecuperationMedicalExpensesRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getShortStayDementiaRecuperationMedicalExpensesRadioItem1(){
    if(shortStayDementiaRecuperationMedicalExpensesRadioItem1==null){

      shortStayDementiaRecuperationMedicalExpensesRadioItem1 = new ACRadioButtonItem();

      shortStayDementiaRecuperationMedicalExpensesRadioItem1.setText("�Ȃ�");

      shortStayDementiaRecuperationMedicalExpensesRadioItem1.setGroup(getShortStayDementiaRecuperationMedicalExpensesRadio());

      shortStayDementiaRecuperationMedicalExpensesRadioItem1.setConstraints(VRLayout.FLOW);

      addShortStayDementiaRecuperationMedicalExpensesRadioItem1();
    }
    return shortStayDementiaRecuperationMedicalExpensesRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getShortStayDementiaRecuperationMedicalExpensesRadioItem2(){
    if(shortStayDementiaRecuperationMedicalExpensesRadioItem2==null){

      shortStayDementiaRecuperationMedicalExpensesRadioItem2 = new ACRadioButtonItem();

      shortStayDementiaRecuperationMedicalExpensesRadioItem2.setText("����");

      shortStayDementiaRecuperationMedicalExpensesRadioItem2.setGroup(getShortStayDementiaRecuperationMedicalExpensesRadio());

      shortStayDementiaRecuperationMedicalExpensesRadioItem2.setConstraints(VRLayout.FLOW);

      addShortStayDementiaRecuperationMedicalExpensesRadioItem2();
    }
    return shortStayDementiaRecuperationMedicalExpensesRadioItem2;

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
   * ����f�Ô�{�^�����擾���܂��B
   * @return ����f�Ô�{�^��
   */
  public ACMapBindButton getShortStayDementiaRecuperationSpecificConsultationFee(){
    if(shortStayDementiaRecuperationSpecificConsultationFee==null){

      shortStayDementiaRecuperationSpecificConsultationFee = new ACMapBindButton();

      shortStayDementiaRecuperationSpecificConsultationFee.setText("����f�Ô�");

      shortStayDementiaRecuperationSpecificConsultationFee.setToolTipText("����f�Ô��ݒ肵�܂��B");

      addShortStayDementiaRecuperationSpecificConsultationFee();
    }
    return shortStayDementiaRecuperationSpecificConsultationFee;

  }

  /**
   * �ݒ胉�x�����擾���܂��B
   * @return �ݒ胉�x��
   */
  public ACLabel getShortStayDementiaRecuperationSpecificConsultationFeeOutline(){
    if(shortStayDementiaRecuperationSpecificConsultationFeeOutline==null){

      shortStayDementiaRecuperationSpecificConsultationFeeOutline = new ACLabel();

      shortStayDementiaRecuperationSpecificConsultationFeeOutline.setText("�ݒ�Ȃ�");

      shortStayDementiaRecuperationSpecificConsultationFeeOutline.setOpaque(true);
      shortStayDementiaRecuperationSpecificConsultationFeeOutline.setBackground(new Color(255,255,172));

      addShortStayDementiaRecuperationSpecificConsultationFeeOutline();
    }
    return shortStayDementiaRecuperationSpecificConsultationFeeOutline;

  }

  /**
   * �l�����Z�R���{���擾���܂��B
   * @return �l�����Z�R���{
   */
  public ACComboBox getShortStayDementiaRecuperationPersonSubtraction(){
    if(shortStayDementiaRecuperationPersonSubtraction==null){

      shortStayDementiaRecuperationPersonSubtraction = new ACComboBox();

      getShortStayDementiaRecuperationPersonSubtractionContainer().setText("�l�����Z");

      shortStayDementiaRecuperationPersonSubtraction.setBindPath("1260308");

      shortStayDementiaRecuperationPersonSubtraction.setEditable(false);

      shortStayDementiaRecuperationPersonSubtraction.setModelBindPath("1260308");

      shortStayDementiaRecuperationPersonSubtraction.setRenderBindPath("CONTENT");

      shortStayDementiaRecuperationPersonSubtraction.setModel(getShortStayDementiaRecuperationPersonSubtractionModel());

      addShortStayDementiaRecuperationPersonSubtraction();
    }
    return shortStayDementiaRecuperationPersonSubtraction;

  }

  /**
   * �l�����Z�R���{�R���e�i���擾���܂��B
   * @return �l�����Z�R���{�R���e�i
   */
  protected ACLabelContainer getShortStayDementiaRecuperationPersonSubtractionContainer(){
    if(shortStayDementiaRecuperationPersonSubtractionContainer==null){
      shortStayDementiaRecuperationPersonSubtractionContainer = new ACLabelContainer();
      shortStayDementiaRecuperationPersonSubtractionContainer.setFollowChildEnabled(true);
      shortStayDementiaRecuperationPersonSubtractionContainer.setVAlignment(VRLayout.CENTER);
      shortStayDementiaRecuperationPersonSubtractionContainer.add(getShortStayDementiaRecuperationPersonSubtraction(), null);
    }
    return shortStayDementiaRecuperationPersonSubtractionContainer;
  }

  /**
   * �l�����Z�R���{���f�����擾���܂��B
   * @return �l�����Z�R���{���f��
   */
  protected ACComboBoxModelAdapter getShortStayDementiaRecuperationPersonSubtractionModel(){
    if(shortStayDementiaRecuperationPersonSubtractionModel==null){
      shortStayDementiaRecuperationPersonSubtractionModel = new ACComboBoxModelAdapter();
      addShortStayDementiaRecuperationPersonSubtractionModel();
    }
    return shortStayDementiaRecuperationPersonSubtractionModel;
  }

  /**
   * �H���R���e�i���擾���܂��B
   * @return �H���R���e�i
   */
  public ACBackLabelContainer getShortStayDementiaRecuperationDinnerContainer(){
    if(shortStayDementiaRecuperationDinnerContainer==null){

      shortStayDementiaRecuperationDinnerContainer = new ACBackLabelContainer();

      shortStayDementiaRecuperationDinnerContainer.setFollowChildEnabled(true);

      addShortStayDementiaRecuperationDinnerContainer();
    }
    return shortStayDementiaRecuperationDinnerContainer;

  }

  /**
   * �H���񋟂��擾���܂��B
   * @return �H����
   */
  public ACComboBox getShortStayDementiaRecuperationDinnerOffer(){
    if(shortStayDementiaRecuperationDinnerOffer==null){

      shortStayDementiaRecuperationDinnerOffer = new ACComboBox();

      getShortStayDementiaRecuperationDinnerOfferContainer().setText("�H����");

      shortStayDementiaRecuperationDinnerOffer.setBindPath("1260309");

      shortStayDementiaRecuperationDinnerOffer.setEditable(false);

      shortStayDementiaRecuperationDinnerOffer.setModelBindPath("1260309");

      shortStayDementiaRecuperationDinnerOffer.setRenderBindPath("CONTENT");

      shortStayDementiaRecuperationDinnerOffer.setModel(getShortStayDementiaRecuperationDinnerOfferModel());

      addShortStayDementiaRecuperationDinnerOffer();
    }
    return shortStayDementiaRecuperationDinnerOffer;

  }

  /**
   * �H���񋟃R���e�i���擾���܂��B
   * @return �H���񋟃R���e�i
   */
  protected ACLabelContainer getShortStayDementiaRecuperationDinnerOfferContainer(){
    if(shortStayDementiaRecuperationDinnerOfferContainer==null){
      shortStayDementiaRecuperationDinnerOfferContainer = new ACLabelContainer();
      shortStayDementiaRecuperationDinnerOfferContainer.setFollowChildEnabled(true);
      shortStayDementiaRecuperationDinnerOfferContainer.setVAlignment(VRLayout.CENTER);
      shortStayDementiaRecuperationDinnerOfferContainer.add(getShortStayDementiaRecuperationDinnerOffer(), null);
    }
    return shortStayDementiaRecuperationDinnerOfferContainer;
  }

  /**
   * �H���񋟃��f�����擾���܂��B
   * @return �H���񋟃��f��
   */
  protected ACComboBoxModelAdapter getShortStayDementiaRecuperationDinnerOfferModel(){
    if(shortStayDementiaRecuperationDinnerOfferModel==null){
      shortStayDementiaRecuperationDinnerOfferModel = new ACComboBoxModelAdapter();
      addShortStayDementiaRecuperationDinnerOfferModel();
    }
    return shortStayDementiaRecuperationDinnerOfferModel;
  }

  /**
   * �H����p���擾���܂��B
   * @return �H����p
   */
  public ACTextField getShortStayDementiaRecuperationDinnerCost(){
    if(shortStayDementiaRecuperationDinnerCost==null){

      shortStayDementiaRecuperationDinnerCost = new ACTextField();

      getShortStayDementiaRecuperationDinnerCostContainer().setText("�H����p");

      shortStayDementiaRecuperationDinnerCost.setBindPath("1260310");

      shortStayDementiaRecuperationDinnerCost.setColumns(4);

      shortStayDementiaRecuperationDinnerCost.setCharType(VRCharType.ONLY_DIGIT);

      shortStayDementiaRecuperationDinnerCost.setHorizontalAlignment(SwingConstants.RIGHT);

      shortStayDementiaRecuperationDinnerCost.setIMEMode(InputSubset.LATIN);

      shortStayDementiaRecuperationDinnerCost.setMaxLength(5);

      addShortStayDementiaRecuperationDinnerCost();
    }
    return shortStayDementiaRecuperationDinnerCost;

  }

  /**
   * �H����p�R���e�i���擾���܂��B
   * @return �H����p�R���e�i
   */
  protected ACLabelContainer getShortStayDementiaRecuperationDinnerCostContainer(){
    if(shortStayDementiaRecuperationDinnerCostContainer==null){
      shortStayDementiaRecuperationDinnerCostContainer = new ACLabelContainer();
      shortStayDementiaRecuperationDinnerCostContainer.setFollowChildEnabled(true);
      shortStayDementiaRecuperationDinnerCostContainer.setVAlignment(VRLayout.CENTER);
      shortStayDementiaRecuperationDinnerCostContainer.add(getShortStayDementiaRecuperationDinnerCost(), null);
    }
    return shortStayDementiaRecuperationDinnerCostContainer;
  }

  /**
   * 30�������擾���܂��B
   * @return 30����
   */
  public ACIntegerCheckBox getShortStayDementiaRecuperationEtc30Over(){
    if(shortStayDementiaRecuperationEtc30Over==null){

      shortStayDementiaRecuperationEtc30Over = new ACIntegerCheckBox();

      shortStayDementiaRecuperationEtc30Over.setText("30����");

      shortStayDementiaRecuperationEtc30Over.setBindPath("5");

      shortStayDementiaRecuperationEtc30Over.setSelectValue(2);

      shortStayDementiaRecuperationEtc30Over.setUnSelectValue(1);

      addShortStayDementiaRecuperationEtc30Over();
    }
    return shortStayDementiaRecuperationEtc30Over;

  }

  /**
   * ���j�b�g�P�A�̐������擾���܂��B
   * @return ���j�b�g�P�A�̐���
   */
  public ACValueArrayRadioButtonGroup getShortStayDementiaRecuperationUnitCareMaintenanceRadio(){
    if(shortStayDementiaRecuperationUnitCareMaintenanceRadio==null){

      shortStayDementiaRecuperationUnitCareMaintenanceRadio = new ACValueArrayRadioButtonGroup();

      getShortStayDementiaRecuperationUnitCareMaintenanceRadioContainer().setText("���j�b�g�P�A�̐���");

      shortStayDementiaRecuperationUnitCareMaintenanceRadio.setBindPath("1260311");

      shortStayDementiaRecuperationUnitCareMaintenanceRadio.setUseClearButton(false);

      shortStayDementiaRecuperationUnitCareMaintenanceRadio.setModel(getShortStayDementiaRecuperationUnitCareMaintenanceRadioModel());

      shortStayDementiaRecuperationUnitCareMaintenanceRadio.setValues(new int[]{1,2});

      addShortStayDementiaRecuperationUnitCareMaintenanceRadio();
    }
    return shortStayDementiaRecuperationUnitCareMaintenanceRadio;

  }

  /**
   * ���j�b�g�P�A�̐����R���e�i���擾���܂��B
   * @return ���j�b�g�P�A�̐����R���e�i
   */
  protected ACLabelContainer getShortStayDementiaRecuperationUnitCareMaintenanceRadioContainer(){
    if(shortStayDementiaRecuperationUnitCareMaintenanceRadioContainer==null){
      shortStayDementiaRecuperationUnitCareMaintenanceRadioContainer = new ACLabelContainer();
      shortStayDementiaRecuperationUnitCareMaintenanceRadioContainer.setFollowChildEnabled(true);
      shortStayDementiaRecuperationUnitCareMaintenanceRadioContainer.setVAlignment(VRLayout.CENTER);
      shortStayDementiaRecuperationUnitCareMaintenanceRadioContainer.add(getShortStayDementiaRecuperationUnitCareMaintenanceRadio(), null);
    }
    return shortStayDementiaRecuperationUnitCareMaintenanceRadioContainer;
  }

  /**
   * ���j�b�g�P�A�̐������f�����擾���܂��B
   * @return ���j�b�g�P�A�̐������f��
   */
  protected ACListModelAdapter getShortStayDementiaRecuperationUnitCareMaintenanceRadioModel(){
    if(shortStayDementiaRecuperationUnitCareMaintenanceRadioModel==null){
      shortStayDementiaRecuperationUnitCareMaintenanceRadioModel = new ACListModelAdapter();
      addShortStayDementiaRecuperationUnitCareMaintenanceRadioModel();
    }
    return shortStayDementiaRecuperationUnitCareMaintenanceRadioModel;
  }

  /**
   * ���������擾���܂��B
   * @return ������
   */
  public ACRadioButtonItem getShortStayDementiaRecuperationUnitCareMaintenanceRadioItem1(){
    if(shortStayDementiaRecuperationUnitCareMaintenanceRadioItem1==null){

      shortStayDementiaRecuperationUnitCareMaintenanceRadioItem1 = new ACRadioButtonItem();

      shortStayDementiaRecuperationUnitCareMaintenanceRadioItem1.setText("������");

      shortStayDementiaRecuperationUnitCareMaintenanceRadioItem1.setGroup(getShortStayDementiaRecuperationUnitCareMaintenanceRadio());

      shortStayDementiaRecuperationUnitCareMaintenanceRadioItem1.setConstraints(VRLayout.FLOW);

      addShortStayDementiaRecuperationUnitCareMaintenanceRadioItem1();
    }
    return shortStayDementiaRecuperationUnitCareMaintenanceRadioItem1;

  }

  /**
   * �������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getShortStayDementiaRecuperationUnitCareMaintenanceRadioItem2(){
    if(shortStayDementiaRecuperationUnitCareMaintenanceRadioItem2==null){

      shortStayDementiaRecuperationUnitCareMaintenanceRadioItem2 = new ACRadioButtonItem();

      shortStayDementiaRecuperationUnitCareMaintenanceRadioItem2.setText("����");

      shortStayDementiaRecuperationUnitCareMaintenanceRadioItem2.setGroup(getShortStayDementiaRecuperationUnitCareMaintenanceRadio());

      shortStayDementiaRecuperationUnitCareMaintenanceRadioItem2.setConstraints(VRLayout.FLOW);

      addShortStayDementiaRecuperationUnitCareMaintenanceRadioItem2();
    }
    return shortStayDementiaRecuperationUnitCareMaintenanceRadioItem2;

  }

  /**
   * �T�[�r�X�񋟑̐��������Z���擾���܂��B
   * @return �T�[�r�X�񋟑̐��������Z
   */
  public ACValueArrayRadioButtonGroup getServiceAddProvisionStructuralRadioGroup(){
    if(serviceAddProvisionStructuralRadioGroup==null){

      serviceAddProvisionStructuralRadioGroup = new ACValueArrayRadioButtonGroup();

      getServiceAddProvisionStructuralRadioGroupContainer().setText("�T�[�r�X�񋟑̐��������Z");

      serviceAddProvisionStructuralRadioGroup.setBindPath("1260312");

      serviceAddProvisionStructuralRadioGroup.setNoSelectIndex(0);

      serviceAddProvisionStructuralRadioGroup.setUseClearButton(false);

      serviceAddProvisionStructuralRadioGroup.setModel(getServiceAddProvisionStructuralRadioGroupModel());

      serviceAddProvisionStructuralRadioGroup.setValues(new int[]{1,5,2,3,4});

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
   * I�C�^���擾���܂��B
   * @return I�C�^
   */
  public ACRadioButtonItem getServiceAddProvisionStructuralRadioItem5(){
    if(serviceAddProvisionStructuralRadioItem5==null){

      serviceAddProvisionStructuralRadioItem5 = new ACRadioButtonItem();

      serviceAddProvisionStructuralRadioItem5.setText("I�C�^");

      serviceAddProvisionStructuralRadioItem5.setGroup(getServiceAddProvisionStructuralRadioGroup());

      serviceAddProvisionStructuralRadioItem5.setConstraints(VRLayout.FLOW_RETURN);

      addServiceAddProvisionStructuralRadioItem5();
    }
    return serviceAddProvisionStructuralRadioItem5;

  }

  /**
   * I���^���擾���܂��B
   * @return I���^
   */
  public ACRadioButtonItem getServiceAddProvisionStructuralRadioItem2(){
    if(serviceAddProvisionStructuralRadioItem2==null){

      serviceAddProvisionStructuralRadioItem2 = new ACRadioButtonItem();

      serviceAddProvisionStructuralRadioItem2.setText("I���^");

      serviceAddProvisionStructuralRadioItem2.setGroup(getServiceAddProvisionStructuralRadioGroup());

      serviceAddProvisionStructuralRadioItem2.setConstraints(VRLayout.FLOW);

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
  public QS001_12613_201504Design() {

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

    tab1.add(getShortStayDementiaRecuperationInstitutionDivisionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getShortStayDementiaRecuperationHospitalDivisionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getShortStayDementiaRecuperationDivisionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getShortStayDementiaRecuperationHospitalRoomDivisionContena(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getShortStayDementiaRecuperationMeetingAndSendingOffContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getShortStayDementiaRecuperationMedicalExpensesRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * �{�ݓ��̋敪�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayDementiaRecuperationInstitutionDivisionRadio(){

  }

  /**
   * �{�ݓ��̋敪���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayDementiaRecuperationInstitutionDivisionRadioModel(){

    getShortStayDementiaRecuperationInstitutionDivisionRadioItem1().setButtonIndex(1);

    getShortStayDementiaRecuperationInstitutionDivisionRadioModel().add(getShortStayDementiaRecuperationInstitutionDivisionRadioItem1());

    getShortStayDementiaRecuperationInstitutionDivisionRadioItem2().setButtonIndex(2);

    getShortStayDementiaRecuperationInstitutionDivisionRadioModel().add(getShortStayDementiaRecuperationInstitutionDivisionRadioItem2());

    getShortStayDementiaRecuperationInstitutionDivisionRadioItem3().setButtonIndex(3);

    getShortStayDementiaRecuperationInstitutionDivisionRadioModel().add(getShortStayDementiaRecuperationInstitutionDivisionRadioItem3());

  }

  /**
   * �F�m�ǎ����^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayDementiaRecuperationInstitutionDivisionRadioItem1(){

  }

  /**
   * ���j�b�g�^�F�m�ǎ����^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayDementiaRecuperationInstitutionDivisionRadioItem2(){

  }

  /**
   * �o�ߌ^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayDementiaRecuperationInstitutionDivisionRadioItem3(){

  }

  /**
   * �a�@�敪�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayDementiaRecuperationHospitalDivisionRadio(){

  }

  /**
   * �a�@�敪���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayDementiaRecuperationHospitalDivisionRadioModel(){

    getShortStayDementiaRecuperationHospitalDivisionRadioItem1().setButtonIndex(1);

    getShortStayDementiaRecuperationHospitalDivisionRadioModel().add(getShortStayDementiaRecuperationHospitalDivisionRadioItem1());

    getShortStayDementiaRecuperationHospitalDivisionRadioItem2().setButtonIndex(2);

    getShortStayDementiaRecuperationHospitalDivisionRadioModel().add(getShortStayDementiaRecuperationHospitalDivisionRadioItem2());

  }

  /**
   * ��w�a�@�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayDementiaRecuperationHospitalDivisionRadioItem1(){

  }

  /**
   * ��ʕa�@�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayDementiaRecuperationHospitalDivisionRadioItem2(){

  }

  /**
   * �l���z�u�敪�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayDementiaRecuperationDivision(){

  }

  /**
   * �l���z�u�敪���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayDementiaRecuperationDivisionModel(){

    getShortStayDementiaRecuperationType1().setButtonIndex(1);

    getShortStayDementiaRecuperationDivisionModel().add(getShortStayDementiaRecuperationType1());

    getShortStayDementiaRecuperationType2().setButtonIndex(2);

    getShortStayDementiaRecuperationDivisionModel().add(getShortStayDementiaRecuperationType2());

    getShortStayDementiaRecuperationType3().setButtonIndex(3);

    getShortStayDementiaRecuperationDivisionModel().add(getShortStayDementiaRecuperationType3());

    getShortStayDementiaRecuperationType4().setButtonIndex(4);

    getShortStayDementiaRecuperationDivisionModel().add(getShortStayDementiaRecuperationType4());

    getShortStayDementiaRecuperationType5().setButtonIndex(5);

    getShortStayDementiaRecuperationDivisionModel().add(getShortStayDementiaRecuperationType5());

  }

  /**
   * I�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayDementiaRecuperationType1(){

  }

  /**
   * II�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayDementiaRecuperationType2(){

  }

  /**
   * III�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayDementiaRecuperationType3(){

  }

  /**
   * IV�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayDementiaRecuperationType4(){

  }

  /**
   * V�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayDementiaRecuperationType5(){

  }

  /**
   * �a���敪�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayDementiaRecuperationHospitalRoomDivisionContena(){

    shortStayDementiaRecuperationHospitalRoomDivisionContena.add(getShortStayDementiaRecuperationHospitalRoomRadio(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayDementiaRecuperationHospitalRoomDivisionContena.add(getShortStayDementiaRecuperationUnitHospitalRoomRadio(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * �a���敪�i���V�l�ی��{�݁j�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayDementiaRecuperationHospitalRoomRadio(){

  }

  /**
   * �a���敪�i���V�l�ی��{�݁j���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayDementiaRecuperationHospitalRoomRadioModel(){

    getShortStayDementiaRecuperationHospitalRoomRadioItem1().setButtonIndex(1);

    getShortStayDementiaRecuperationHospitalRoomRadioModel().add(getShortStayDementiaRecuperationHospitalRoomRadioItem1());

    getShortStayDementiaRecuperationHospitalRoomRadioItem2().setButtonIndex(2);

    getShortStayDementiaRecuperationHospitalRoomRadioModel().add(getShortStayDementiaRecuperationHospitalRoomRadioItem2());

  }

  /**
   * �]���^���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayDementiaRecuperationHospitalRoomRadioItem1(){

  }

  /**
   * �������ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayDementiaRecuperationHospitalRoomRadioItem2(){

  }

  /**
   * �a���敪�i���j�b�g�^�j�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayDementiaRecuperationUnitHospitalRoomRadio(){

  }

  /**
   * �a���敪�i���j�b�g�^�j���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayDementiaRecuperationUnitHospitalRoomRadioModel(){

    getShortStayDementiaRecuperationUnitHospitalRoomRadioItem1().setButtonIndex(1);

    getShortStayDementiaRecuperationUnitHospitalRoomRadioModel().add(getShortStayDementiaRecuperationUnitHospitalRoomRadioItem1());

    getShortStayDementiaRecuperationUnitHospitalRoomRadioItem2().setButtonIndex(2);

    getShortStayDementiaRecuperationUnitHospitalRoomRadioModel().add(getShortStayDementiaRecuperationUnitHospitalRoomRadioItem2());

  }

  /**
   * ���j�b�g�^���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayDementiaRecuperationUnitHospitalRoomRadioItem1(){

  }

  /**
   * ���j�b�g�^�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayDementiaRecuperationUnitHospitalRoomRadioItem2(){

  }

  /**
   * ���}�敪�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayDementiaRecuperationMeetingAndSendingOff(){

  }

  /**
   * ���}�敪���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayDementiaRecuperationMeetingAndSendingOffModel(){

    getShortStayDementiaRecuperationMeetingAndSendingOffNone().setButtonIndex(1);

    getShortStayDementiaRecuperationMeetingAndSendingOffModel().add(getShortStayDementiaRecuperationMeetingAndSendingOffNone());

    getShortStayDementiaRecuperationMeetingAndSendingOffOneWay().setButtonIndex(2);

    getShortStayDementiaRecuperationMeetingAndSendingOffModel().add(getShortStayDementiaRecuperationMeetingAndSendingOffOneWay());

    getShortStayDementiaRecuperationMeetingAndSendingOffRoundTrip().setButtonIndex(3);

    getShortStayDementiaRecuperationMeetingAndSendingOffModel().add(getShortStayDementiaRecuperationMeetingAndSendingOffRoundTrip());

  }

  /**
   * ���}�Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayDementiaRecuperationMeetingAndSendingOffNone(){

  }

  /**
   * ���}�Г��ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayDementiaRecuperationMeetingAndSendingOffOneWay(){

  }

  /**
   * ���}�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayDementiaRecuperationMeetingAndSendingOffRoundTrip(){

  }

  /**
   * �×{�H���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayDementiaRecuperationMedicalExpensesRadio(){

  }

  /**
   * �×{�H���Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayDementiaRecuperationMedicalExpensesRadioModel(){

    getShortStayDementiaRecuperationMedicalExpensesRadioItem1().setButtonIndex(1);

    getShortStayDementiaRecuperationMedicalExpensesRadioModel().add(getShortStayDementiaRecuperationMedicalExpensesRadioItem1());

    getShortStayDementiaRecuperationMedicalExpensesRadioItem2().setButtonIndex(2);

    getShortStayDementiaRecuperationMedicalExpensesRadioModel().add(getShortStayDementiaRecuperationMedicalExpensesRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayDementiaRecuperationMedicalExpensesRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayDementiaRecuperationMedicalExpensesRadioItem2(){

  }

  /**
   * �^�u2�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTab2(){

    tab2.add(getShortStayDementiaRecuperationSpecificConsultationFee(), VRLayout.FLOW);

    tab2.add(getShortStayDementiaRecuperationSpecificConsultationFeeOutline(), VRLayout.FLOW_RETURN);

    tab2.add(getShortStayDementiaRecuperationPersonSubtractionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getShortStayDementiaRecuperationDinnerContainer(), VRLayout.FLOW_DOUBLEINSETLINE_RETURN);

    tab2.add(getShortStayDementiaRecuperationEtc30Over(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getShortStayDementiaRecuperationUnitCareMaintenanceRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getServiceAddProvisionStructuralRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * ����f�Ô�{�^���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayDementiaRecuperationSpecificConsultationFee(){

  }

  /**
   * �ݒ胉�x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayDementiaRecuperationSpecificConsultationFeeOutline(){

  }

  /**
   * �l�����Z�R���{�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayDementiaRecuperationPersonSubtraction(){

  }

  /**
   * �l�����Z�R���{���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayDementiaRecuperationPersonSubtractionModel(){

  }

  /**
   * �H���R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayDementiaRecuperationDinnerContainer(){

    shortStayDementiaRecuperationDinnerContainer.add(getShortStayDementiaRecuperationDinnerOfferContainer(), VRLayout.FLOW);

    shortStayDementiaRecuperationDinnerContainer.add(getShortStayDementiaRecuperationDinnerCostContainer(), VRLayout.FLOW);

  }

  /**
   * �H���񋟂ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayDementiaRecuperationDinnerOffer(){

  }

  /**
   * �H���񋟃��f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayDementiaRecuperationDinnerOfferModel(){

  }

  /**
   * �H����p�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayDementiaRecuperationDinnerCost(){

  }

  /**
   * 30�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayDementiaRecuperationEtc30Over(){

  }

  /**
   * ���j�b�g�P�A�̐����ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayDementiaRecuperationUnitCareMaintenanceRadio(){

  }

  /**
   * ���j�b�g�P�A�̐������f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayDementiaRecuperationUnitCareMaintenanceRadioModel(){

    getShortStayDementiaRecuperationUnitCareMaintenanceRadioItem1().setButtonIndex(1);

    getShortStayDementiaRecuperationUnitCareMaintenanceRadioModel().add(getShortStayDementiaRecuperationUnitCareMaintenanceRadioItem1());

    getShortStayDementiaRecuperationUnitCareMaintenanceRadioItem2().setButtonIndex(2);

    getShortStayDementiaRecuperationUnitCareMaintenanceRadioModel().add(getShortStayDementiaRecuperationUnitCareMaintenanceRadioItem2());

  }

  /**
   * �������ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayDementiaRecuperationUnitCareMaintenanceRadioItem1(){

  }

  /**
   * �����ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayDementiaRecuperationUnitCareMaintenanceRadioItem2(){

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

    getServiceAddProvisionStructuralRadioItem5().setButtonIndex(5);

    getServiceAddProvisionStructuralRadioGroupModel().add(getServiceAddProvisionStructuralRadioItem5());

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
   * I�C�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceAddProvisionStructuralRadioItem5(){

  }

  /**
   * I���^�ɓ������ڂ�ǉ����܂��B
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
      ACFrame.debugStart(new ACAffairInfo(QS001_12613_201504Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QS001_12613_201504Design getThis() {
    return this;
  }
}
