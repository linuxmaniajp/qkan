
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
 * �쐬��: 2006/03/14  ���{�R���s���[�^�[������� ���{�@�K�� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �T�[�r�X�\��쐬/�ύX (S)
 * �v���Z�X �T�[�r�X�\��T�� (001)
 * �v���O���� �T�[�r�X�p�^�[���Z������������� (QS001109)
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
import jp.or.med.orca.qkan.text.*;
/**
 * �T�[�r�X�p�^�[���Z��������������ʍ��ڃf�U�C��(QS001109) 
 */
public class QS001109Design extends QS001ServicePanel {
  //GUI�R���|�[�l���g

  private JTabbedPane tabs;

  private ACPanel tab1;

  private ACClearableRadioButtonGroup shortStayLifeTimeContenaFacilityDivision;

  private ACLabelContainer shortStayLifeTimeContenaFacilityDivisionContainer;

  private ACListModelAdapter shortStayLifeTimeContenaFacilityDivisionModel;

  private ACRadioButtonItem shortStayLifeSingle;

  private ACRadioButtonItem shortStayLifeDouble;

  private ACRadioButtonItem shortStayLifeSingleUnit;

  private ACRadioButtonItem shortStayLifeDoubleUnit;

  private ACLabelContainer shortStayLifeHospitalRoomDivisionContena;

  private ACClearableRadioButtonGroup shortStayLifeHospitalRoomDivisionRadio;

  private ACListModelAdapter shortStayLifeHospitalRoomDivisionRadioModel;

  private ACRadioButtonItem shortStayLifeHospitalRoomDivisionRadioItem1;

  private ACRadioButtonItem shortStayLifeHospitalRoomDivisionRadioItem2;

  private ACClearableRadioButtonGroup shortStayLifeUnitHospitalRoomDivisionRadio;

  private ACListModelAdapter shortStayLifeUnitHospitalRoomDivisionRadioModel;

  private ACRadioButtonItem shortStayLifeUnitHospitalRoomDivisionRadioItem1;

  private ACRadioButtonItem shortStayLifeUnitHospitalRoomDivisionRadioItem2;

  private ACClearableRadioButtonGroup nightWorkConditionRadio;

  private ACLabelContainer nightWorkConditionRadioContainer;

  private ACListModelAdapter nightWorkConditionRadioModel;

  private ACRadioButtonItem nightWorkConditionRadioItem1;

  private ACRadioButtonItem nightWorkConditionRadioItem2;

  private ACClearableRadioButtonGroup shortStayLifeAdditionFunctionTrainingRadio;

  private ACLabelContainer shortStayLifeAdditionFunctionTrainingRadioContainer;

  private ACListModelAdapter shortStayLifeAdditionFunctionTrainingRadioModel;

  private ACRadioButtonItem shortStayLifeAdditionFunctionTrainingRadioItem2;

  private ACRadioButtonItem shortStayLifeAdditionFunctionTrainingRadioItem1;

  private ACClearableRadioButtonGroup shortStayLifeMeetingAndSendingOff;

  private ACLabelContainer shortStayLifeMeetingAndSendingOffContainer;

  private ACListModelAdapter shortStayLifeMeetingAndSendingOffModel;

  private ACRadioButtonItem shortStayLifeMeetingAndSendingOffNone;

  private ACRadioButtonItem shortStayLifeMeetingAndSendingOffOneWay;

  private ACRadioButtonItem shortStayLifeMeetingAndSendingOffRoundTrip;

  private ACClearableRadioButtonGroup shortStayLifeDieticianManageRadio;

  private ACLabelContainer shortStayLifeDieticianManageRadioContainer;

  private ACListModelAdapter shortStayLifeDieticianManageRadioModel;

  private ACRadioButtonItem shortStayLifeDieticianManageRadioItem1;

  private ACRadioButtonItem shortStayLifeDieticianManageRadioItem2;

  private ACRadioButtonItem shortStayLifeDieticianManageRadioItem3;

  private ACPanel tab2;

  private ACClearableRadioButtonGroup shortStayLifeMedicalExpensesRadio;

  private ACLabelContainer shortStayLifeMedicalExpensesRadioContainer;

  private ACListModelAdapter shortStayLifeMedicalExpensesRadioModel;

  private ACRadioButtonItem shortStayLifeMedicalExpensesRadioItem1;

  private ACRadioButtonItem shortStayLifeMedicalExpensesRadioItem2;

  private ACClearableRadioButtonGroup shortStayLifeSubtraction;

  private ACLabelContainer shortStayLifeSubtractionContainer;

  private ACListModelAdapter shortStayLifeSubtractionModel;

  private ACRadioButtonItem shortStayLifeSubtractionNot;

  private ACRadioButtonItem shortStayLifeSubtractionExcess;

  private ACRadioButtonItem shortStayLifeSubtractionLack;

  private ACBackLabelContainer shortStayLifeDinnerContainer;

  private ACComboBox shortStayLifeDinnerOffer;

  private ACLabelContainer shortStayLifeDinnerOfferContainer;

  private ACComboBoxModelAdapter shortStayLifeDinnerOfferModel;

  private ACTextField shortStayLifeDinnerCost;

  private ACLabelContainer shortStayLifeDinnerCostContainer;

  private ACIntegerCheckBox shortStayLifeAddition30Orver;

  private ACClearableRadioButtonGroup shortStayLifeUnitCareAddRadio;

  private ACLabelContainer shortStayLifeUnitCareAddRadioContainer;

  private ACListModelAdapter shortStayLifeUnitCareAddRadioModel;

  private ACRadioButtonItem shortStayLifeUnitCareAddRadioItem1;

  private ACRadioButtonItem shortStayLifeUnitCareAddRadioItem2;

  private ACClearableRadioButtonGroup shortStayLifeEmergencyShortNetworkAddRadio;

  private ACLabelContainer shortStayLifeEmergencyShortNetworkAddRadioContainer;

  private ACListModelAdapter shortStayLifeEmergencyShortNetworkAddRadioModel;

  private ACRadioButtonItem shortStayLifeEmergencyShortNetworkAddRadioItem1;

  private ACRadioButtonItem shortStayLifeEmergencyShortNetworkAddRadioItem2;

  private ACGroupBox shortStayLifeStayheavyAddGroup;

  private ACClearableRadioButtonGroup shortStayLifeNightNursingSystemAddRadio;

  private ACLabelContainer shortStayLifeNightNursingSystemAddRadioContainer;

  private ACListModelAdapter shortStayLifeNightNursingSystemAddRadioModel;

  private ACRadioButtonItem shortStayLifeNightNursingSystemAddRadioItem1;

  private ACRadioButtonItem shortStayLifeNightNursingSystemAddRadioItem2;

  private ACClearableRadioButtonGroup shortStayLifeStayheavyAddRadio;

  private ACLabelContainer shortStayLifeStayheavyAddRadioContainer;

  private ACListModelAdapter shortStayLifeStayheavyAddRadioModel;

  private ACRadioButtonItem shortStayLifeStayheavyAddRadioItem1;

  private ACRadioButtonItem shortStayLifeStayheavyAddRadioItem2;

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
  public ACClearableRadioButtonGroup getShortStayLifeTimeContenaFacilityDivision(){
    if(shortStayLifeTimeContenaFacilityDivision==null){

      shortStayLifeTimeContenaFacilityDivision = new ACClearableRadioButtonGroup();

      getShortStayLifeTimeContenaFacilityDivisionContainer().setText("�{�ݓ��̋敪");

      shortStayLifeTimeContenaFacilityDivision.setBindPath("1210101");

      shortStayLifeTimeContenaFacilityDivision.setModel(getShortStayLifeTimeContenaFacilityDivisionModel());

      shortStayLifeTimeContenaFacilityDivision.setUseClearButton(false);

      addShortStayLifeTimeContenaFacilityDivision();
    }
    return shortStayLifeTimeContenaFacilityDivision;

  }

  /**
   * �{�ݓ��̋敪�R���e�i���擾���܂��B
   * @return �{�ݓ��̋敪�R���e�i
   */
  protected ACLabelContainer getShortStayLifeTimeContenaFacilityDivisionContainer(){
    if(shortStayLifeTimeContenaFacilityDivisionContainer==null){
      shortStayLifeTimeContenaFacilityDivisionContainer = new ACLabelContainer();
      shortStayLifeTimeContenaFacilityDivisionContainer.setFollowChildEnabled(true);
      shortStayLifeTimeContenaFacilityDivisionContainer.setVAlignment(VRLayout.CENTER);
      shortStayLifeTimeContenaFacilityDivisionContainer.add(getShortStayLifeTimeContenaFacilityDivision(), null);
    }
    return shortStayLifeTimeContenaFacilityDivisionContainer;
  }

  /**
   * �{�ݓ��̋敪���f�����擾���܂��B
   * @return �{�ݓ��̋敪���f��
   */
  protected ACListModelAdapter getShortStayLifeTimeContenaFacilityDivisionModel(){
    if(shortStayLifeTimeContenaFacilityDivisionModel==null){
      shortStayLifeTimeContenaFacilityDivisionModel = new ACListModelAdapter();
      addShortStayLifeTimeContenaFacilityDivisionModel();
    }
    return shortStayLifeTimeContenaFacilityDivisionModel;
  }

  /**
   * �P�ƌ^���擾���܂��B
   * @return �P�ƌ^
   */
  public ACRadioButtonItem getShortStayLifeSingle(){
    if(shortStayLifeSingle==null){

      shortStayLifeSingle = new ACRadioButtonItem();

      shortStayLifeSingle.setText("�P�ƌ^");

      shortStayLifeSingle.setGroup(getShortStayLifeTimeContenaFacilityDivision());

      shortStayLifeSingle.setConstraints(VRLayout.FLOW);

      addShortStayLifeSingle();
    }
    return shortStayLifeSingle;

  }

  /**
   * ���݌^���擾���܂��B
   * @return ���݌^
   */
  public ACRadioButtonItem getShortStayLifeDouble(){
    if(shortStayLifeDouble==null){

      shortStayLifeDouble = new ACRadioButtonItem();

      shortStayLifeDouble.setText("���݌^");

      shortStayLifeDouble.setGroup(getShortStayLifeTimeContenaFacilityDivision());

      shortStayLifeDouble.setConstraints(VRLayout.FLOW_RETURN);

      addShortStayLifeDouble();
    }
    return shortStayLifeDouble;

  }

  /**
   * �P�ƌ^���j�b�g�^���擾���܂��B
   * @return �P�ƌ^���j�b�g�^
   */
  public ACRadioButtonItem getShortStayLifeSingleUnit(){
    if(shortStayLifeSingleUnit==null){

      shortStayLifeSingleUnit = new ACRadioButtonItem();

      shortStayLifeSingleUnit.setText("�P�ƌ^���j�b�g�^");

      shortStayLifeSingleUnit.setGroup(getShortStayLifeTimeContenaFacilityDivision());

      shortStayLifeSingleUnit.setConstraints(VRLayout.FLOW_RETURN);

      addShortStayLifeSingleUnit();
    }
    return shortStayLifeSingleUnit;

  }

  /**
   * ���݌^���j�b�g�^���擾���܂��B
   * @return ���݌^���j�b�g�^
   */
  public ACRadioButtonItem getShortStayLifeDoubleUnit(){
    if(shortStayLifeDoubleUnit==null){

      shortStayLifeDoubleUnit = new ACRadioButtonItem();

      shortStayLifeDoubleUnit.setText("���݌^���j�b�g�^");

      shortStayLifeDoubleUnit.setGroup(getShortStayLifeTimeContenaFacilityDivision());

      shortStayLifeDoubleUnit.setConstraints(VRLayout.FLOW);

      addShortStayLifeDoubleUnit();
    }
    return shortStayLifeDoubleUnit;

  }

  /**
   * �a���敪�R���e�i���擾���܂��B
   * @return �a���敪�R���e�i
   */
  public ACLabelContainer getShortStayLifeHospitalRoomDivisionContena(){
    if(shortStayLifeHospitalRoomDivisionContena==null){

      shortStayLifeHospitalRoomDivisionContena = new ACLabelContainer();

      shortStayLifeHospitalRoomDivisionContena.setText("�a���敪");

      addShortStayLifeHospitalRoomDivisionContena();
    }
    return shortStayLifeHospitalRoomDivisionContena;

  }

  /**
   * �a���敪�i�ʏ�j���擾���܂��B
   * @return �a���敪�i�ʏ�j
   */
  public ACClearableRadioButtonGroup getShortStayLifeHospitalRoomDivisionRadio(){
    if(shortStayLifeHospitalRoomDivisionRadio==null){

      shortStayLifeHospitalRoomDivisionRadio = new ACClearableRadioButtonGroup();

      shortStayLifeHospitalRoomDivisionRadio.setBindPath("1210103");

      shortStayLifeHospitalRoomDivisionRadio.setModel(getShortStayLifeHospitalRoomDivisionRadioModel());

      shortStayLifeHospitalRoomDivisionRadio.setUseClearButton(false);

      addShortStayLifeHospitalRoomDivisionRadio();
    }
    return shortStayLifeHospitalRoomDivisionRadio;

  }

  /**
   * �a���敪�i�ʏ�j���f�����擾���܂��B
   * @return �a���敪�i�ʏ�j���f��
   */
  protected ACListModelAdapter getShortStayLifeHospitalRoomDivisionRadioModel(){
    if(shortStayLifeHospitalRoomDivisionRadioModel==null){
      shortStayLifeHospitalRoomDivisionRadioModel = new ACListModelAdapter();
      addShortStayLifeHospitalRoomDivisionRadioModel();
    }
    return shortStayLifeHospitalRoomDivisionRadioModel;
  }

  /**
   * �]���^�����擾���܂��B
   * @return �]���^��
   */
  public ACRadioButtonItem getShortStayLifeHospitalRoomDivisionRadioItem1(){
    if(shortStayLifeHospitalRoomDivisionRadioItem1==null){

      shortStayLifeHospitalRoomDivisionRadioItem1 = new ACRadioButtonItem();

      shortStayLifeHospitalRoomDivisionRadioItem1.setText("�]���^��");

      shortStayLifeHospitalRoomDivisionRadioItem1.setGroup(getShortStayLifeHospitalRoomDivisionRadio());

      shortStayLifeHospitalRoomDivisionRadioItem1.setConstraints(VRLayout.FLOW);

      addShortStayLifeHospitalRoomDivisionRadioItem1();
    }
    return shortStayLifeHospitalRoomDivisionRadioItem1;

  }

  /**
   * ���������擾���܂��B
   * @return ������
   */
  public ACRadioButtonItem getShortStayLifeHospitalRoomDivisionRadioItem2(){
    if(shortStayLifeHospitalRoomDivisionRadioItem2==null){

      shortStayLifeHospitalRoomDivisionRadioItem2 = new ACRadioButtonItem();

      shortStayLifeHospitalRoomDivisionRadioItem2.setText("������");

      shortStayLifeHospitalRoomDivisionRadioItem2.setGroup(getShortStayLifeHospitalRoomDivisionRadio());

      shortStayLifeHospitalRoomDivisionRadioItem2.setConstraints(VRLayout.FLOW);

      addShortStayLifeHospitalRoomDivisionRadioItem2();
    }
    return shortStayLifeHospitalRoomDivisionRadioItem2;

  }

  /**
   * �a���敪�i���j�b�g�j���擾���܂��B
   * @return �a���敪�i���j�b�g�j
   */
  public ACClearableRadioButtonGroup getShortStayLifeUnitHospitalRoomDivisionRadio(){
    if(shortStayLifeUnitHospitalRoomDivisionRadio==null){

      shortStayLifeUnitHospitalRoomDivisionRadio = new ACClearableRadioButtonGroup();

      shortStayLifeUnitHospitalRoomDivisionRadio.setBindPath("1210104");

      shortStayLifeUnitHospitalRoomDivisionRadio.setModel(getShortStayLifeUnitHospitalRoomDivisionRadioModel());

      shortStayLifeUnitHospitalRoomDivisionRadio.setUseClearButton(false);

      addShortStayLifeUnitHospitalRoomDivisionRadio();
    }
    return shortStayLifeUnitHospitalRoomDivisionRadio;

  }

  /**
   * �a���敪�i���j�b�g�j���f�����擾���܂��B
   * @return �a���敪�i���j�b�g�j���f��
   */
  protected ACListModelAdapter getShortStayLifeUnitHospitalRoomDivisionRadioModel(){
    if(shortStayLifeUnitHospitalRoomDivisionRadioModel==null){
      shortStayLifeUnitHospitalRoomDivisionRadioModel = new ACListModelAdapter();
      addShortStayLifeUnitHospitalRoomDivisionRadioModel();
    }
    return shortStayLifeUnitHospitalRoomDivisionRadioModel;
  }

  /**
   * ���j�b�g�^�����擾���܂��B
   * @return ���j�b�g�^��
   */
  public ACRadioButtonItem getShortStayLifeUnitHospitalRoomDivisionRadioItem1(){
    if(shortStayLifeUnitHospitalRoomDivisionRadioItem1==null){

      shortStayLifeUnitHospitalRoomDivisionRadioItem1 = new ACRadioButtonItem();

      shortStayLifeUnitHospitalRoomDivisionRadioItem1.setText("���j�b�g�^��");

      shortStayLifeUnitHospitalRoomDivisionRadioItem1.setGroup(getShortStayLifeUnitHospitalRoomDivisionRadio());

      shortStayLifeUnitHospitalRoomDivisionRadioItem1.setConstraints(VRLayout.FLOW_RETURN);

      addShortStayLifeUnitHospitalRoomDivisionRadioItem1();
    }
    return shortStayLifeUnitHospitalRoomDivisionRadioItem1;

  }

  /**
   * ���j�b�g�^�������擾���܂��B
   * @return ���j�b�g�^����
   */
  public ACRadioButtonItem getShortStayLifeUnitHospitalRoomDivisionRadioItem2(){
    if(shortStayLifeUnitHospitalRoomDivisionRadioItem2==null){

      shortStayLifeUnitHospitalRoomDivisionRadioItem2 = new ACRadioButtonItem();

      shortStayLifeUnitHospitalRoomDivisionRadioItem2.setText("���j�b�g�^����");

      shortStayLifeUnitHospitalRoomDivisionRadioItem2.setGroup(getShortStayLifeUnitHospitalRoomDivisionRadio());

      shortStayLifeUnitHospitalRoomDivisionRadioItem2.setConstraints(VRLayout.FLOW);

      addShortStayLifeUnitHospitalRoomDivisionRadioItem2();
    }
    return shortStayLifeUnitHospitalRoomDivisionRadioItem2;

  }

  /**
   * ��ԋΖ���������擾���܂��B
   * @return ��ԋΖ������
   */
  public ACClearableRadioButtonGroup getNightWorkConditionRadio(){
    if(nightWorkConditionRadio==null){

      nightWorkConditionRadio = new ACClearableRadioButtonGroup();

      getNightWorkConditionRadioContainer().setText("��ԋΖ������");

      nightWorkConditionRadio.setBindPath("1210105");

      nightWorkConditionRadio.setModel(getNightWorkConditionRadioModel());

      nightWorkConditionRadio.setUseClearButton(false);

      addNightWorkConditionRadio();
    }
    return nightWorkConditionRadio;

  }

  /**
   * ��ԋΖ�������R���e�i���擾���܂��B
   * @return ��ԋΖ�������R���e�i
   */
  protected ACLabelContainer getNightWorkConditionRadioContainer(){
    if(nightWorkConditionRadioContainer==null){
      nightWorkConditionRadioContainer = new ACLabelContainer();
      nightWorkConditionRadioContainer.setFollowChildEnabled(true);
      nightWorkConditionRadioContainer.setVAlignment(VRLayout.CENTER);
      nightWorkConditionRadioContainer.add(getNightWorkConditionRadio(), null);
    }
    return nightWorkConditionRadioContainer;
  }

  /**
   * ��ԋΖ���������f�����擾���܂��B
   * @return ��ԋΖ���������f��
   */
  protected ACListModelAdapter getNightWorkConditionRadioModel(){
    if(nightWorkConditionRadioModel==null){
      nightWorkConditionRadioModel = new ACListModelAdapter();
      addNightWorkConditionRadioModel();
    }
    return nightWorkConditionRadioModel;
  }

  /**
   * ��^���擾���܂��B
   * @return ��^
   */
  public ACRadioButtonItem getNightWorkConditionRadioItem1(){
    if(nightWorkConditionRadioItem1==null){

      nightWorkConditionRadioItem1 = new ACRadioButtonItem();

      nightWorkConditionRadioItem1.setText("��^");

      nightWorkConditionRadioItem1.setGroup(getNightWorkConditionRadio());

      nightWorkConditionRadioItem1.setConstraints(VRLayout.FLOW);

      addNightWorkConditionRadioItem1();
    }
    return nightWorkConditionRadioItem1;

  }

  /**
   * ���Z�^���擾���܂��B
   * @return ���Z�^
   */
  public ACRadioButtonItem getNightWorkConditionRadioItem2(){
    if(nightWorkConditionRadioItem2==null){

      nightWorkConditionRadioItem2 = new ACRadioButtonItem();

      nightWorkConditionRadioItem2.setText("���Z�^");

      nightWorkConditionRadioItem2.setGroup(getNightWorkConditionRadio());

      nightWorkConditionRadioItem2.setConstraints(VRLayout.FLOW);

      addNightWorkConditionRadioItem2();
    }
    return nightWorkConditionRadioItem2;

  }

  /**
   * �@�\�P���w���̐����Z���擾���܂��B
   * @return �@�\�P���w���̐����Z
   */
  public ACClearableRadioButtonGroup getShortStayLifeAdditionFunctionTrainingRadio(){
    if(shortStayLifeAdditionFunctionTrainingRadio==null){

      shortStayLifeAdditionFunctionTrainingRadio = new ACClearableRadioButtonGroup();

      getShortStayLifeAdditionFunctionTrainingRadioContainer().setText("�@�\�P���w�����Z");

      shortStayLifeAdditionFunctionTrainingRadio.setBindPath("1210106");

      shortStayLifeAdditionFunctionTrainingRadio.setModel(getShortStayLifeAdditionFunctionTrainingRadioModel());

      shortStayLifeAdditionFunctionTrainingRadio.setUseClearButton(false);

      addShortStayLifeAdditionFunctionTrainingRadio();
    }
    return shortStayLifeAdditionFunctionTrainingRadio;

  }

  /**
   * �@�\�P���w���̐����Z�R���e�i���擾���܂��B
   * @return �@�\�P���w���̐����Z�R���e�i
   */
  protected ACLabelContainer getShortStayLifeAdditionFunctionTrainingRadioContainer(){
    if(shortStayLifeAdditionFunctionTrainingRadioContainer==null){
      shortStayLifeAdditionFunctionTrainingRadioContainer = new ACLabelContainer();
      shortStayLifeAdditionFunctionTrainingRadioContainer.setFollowChildEnabled(true);
      shortStayLifeAdditionFunctionTrainingRadioContainer.setVAlignment(VRLayout.CENTER);
      shortStayLifeAdditionFunctionTrainingRadioContainer.add(getShortStayLifeAdditionFunctionTrainingRadio(), null);
    }
    return shortStayLifeAdditionFunctionTrainingRadioContainer;
  }

  /**
   * �@�\�P���w���̐����Z���f�����擾���܂��B
   * @return �@�\�P���w���̐����Z���f��
   */
  protected ACListModelAdapter getShortStayLifeAdditionFunctionTrainingRadioModel(){
    if(shortStayLifeAdditionFunctionTrainingRadioModel==null){
      shortStayLifeAdditionFunctionTrainingRadioModel = new ACListModelAdapter();
      addShortStayLifeAdditionFunctionTrainingRadioModel();
    }
    return shortStayLifeAdditionFunctionTrainingRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getShortStayLifeAdditionFunctionTrainingRadioItem2(){
    if(shortStayLifeAdditionFunctionTrainingRadioItem2==null){

      shortStayLifeAdditionFunctionTrainingRadioItem2 = new ACRadioButtonItem();

      shortStayLifeAdditionFunctionTrainingRadioItem2.setText("�Ȃ�");

      shortStayLifeAdditionFunctionTrainingRadioItem2.setGroup(getShortStayLifeAdditionFunctionTrainingRadio());

      shortStayLifeAdditionFunctionTrainingRadioItem2.setConstraints(VRLayout.FLOW);

      addShortStayLifeAdditionFunctionTrainingRadioItem2();
    }
    return shortStayLifeAdditionFunctionTrainingRadioItem2;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getShortStayLifeAdditionFunctionTrainingRadioItem1(){
    if(shortStayLifeAdditionFunctionTrainingRadioItem1==null){

      shortStayLifeAdditionFunctionTrainingRadioItem1 = new ACRadioButtonItem();

      shortStayLifeAdditionFunctionTrainingRadioItem1.setText("����");

      shortStayLifeAdditionFunctionTrainingRadioItem1.setGroup(getShortStayLifeAdditionFunctionTrainingRadio());

      shortStayLifeAdditionFunctionTrainingRadioItem1.setConstraints(VRLayout.FLOW);

      addShortStayLifeAdditionFunctionTrainingRadioItem1();
    }
    return shortStayLifeAdditionFunctionTrainingRadioItem1;

  }

  /**
   * ���}�敪���擾���܂��B
   * @return ���}�敪
   */
  public ACClearableRadioButtonGroup getShortStayLifeMeetingAndSendingOff(){
    if(shortStayLifeMeetingAndSendingOff==null){

      shortStayLifeMeetingAndSendingOff = new ACClearableRadioButtonGroup();

      getShortStayLifeMeetingAndSendingOffContainer().setText("���}���Z");

      shortStayLifeMeetingAndSendingOff.setBindPath("6");

      shortStayLifeMeetingAndSendingOff.setModel(getShortStayLifeMeetingAndSendingOffModel());

      shortStayLifeMeetingAndSendingOff.setUseClearButton(false);

      addShortStayLifeMeetingAndSendingOff();
    }
    return shortStayLifeMeetingAndSendingOff;

  }

  /**
   * ���}�敪�R���e�i���擾���܂��B
   * @return ���}�敪�R���e�i
   */
  protected ACLabelContainer getShortStayLifeMeetingAndSendingOffContainer(){
    if(shortStayLifeMeetingAndSendingOffContainer==null){
      shortStayLifeMeetingAndSendingOffContainer = new ACLabelContainer();
      shortStayLifeMeetingAndSendingOffContainer.setFollowChildEnabled(true);
      shortStayLifeMeetingAndSendingOffContainer.setVAlignment(VRLayout.CENTER);
      shortStayLifeMeetingAndSendingOffContainer.add(getShortStayLifeMeetingAndSendingOff(), null);
    }
    return shortStayLifeMeetingAndSendingOffContainer;
  }

  /**
   * ���}�敪���f�����擾���܂��B
   * @return ���}�敪���f��
   */
  protected ACListModelAdapter getShortStayLifeMeetingAndSendingOffModel(){
    if(shortStayLifeMeetingAndSendingOffModel==null){
      shortStayLifeMeetingAndSendingOffModel = new ACListModelAdapter();
      addShortStayLifeMeetingAndSendingOffModel();
    }
    return shortStayLifeMeetingAndSendingOffModel;
  }

  /**
   * ���}�Ȃ����擾���܂��B
   * @return ���}�Ȃ�
   */
  public ACRadioButtonItem getShortStayLifeMeetingAndSendingOffNone(){
    if(shortStayLifeMeetingAndSendingOffNone==null){

      shortStayLifeMeetingAndSendingOffNone = new ACRadioButtonItem();

      shortStayLifeMeetingAndSendingOffNone.setText("���}�Ȃ�");

      shortStayLifeMeetingAndSendingOffNone.setGroup(getShortStayLifeMeetingAndSendingOff());

      shortStayLifeMeetingAndSendingOffNone.setConstraints(VRLayout.FLOW);

      addShortStayLifeMeetingAndSendingOffNone();
    }
    return shortStayLifeMeetingAndSendingOffNone;

  }

  /**
   * ���}�Г����擾���܂��B
   * @return ���}�Г�
   */
  public ACRadioButtonItem getShortStayLifeMeetingAndSendingOffOneWay(){
    if(shortStayLifeMeetingAndSendingOffOneWay==null){

      shortStayLifeMeetingAndSendingOffOneWay = new ACRadioButtonItem();

      shortStayLifeMeetingAndSendingOffOneWay.setText("���}�Г�");

      shortStayLifeMeetingAndSendingOffOneWay.setGroup(getShortStayLifeMeetingAndSendingOff());

      shortStayLifeMeetingAndSendingOffOneWay.setConstraints(VRLayout.FLOW);

      addShortStayLifeMeetingAndSendingOffOneWay();
    }
    return shortStayLifeMeetingAndSendingOffOneWay;

  }

  /**
   * ���}�������擾���܂��B
   * @return ���}����
   */
  public ACRadioButtonItem getShortStayLifeMeetingAndSendingOffRoundTrip(){
    if(shortStayLifeMeetingAndSendingOffRoundTrip==null){

      shortStayLifeMeetingAndSendingOffRoundTrip = new ACRadioButtonItem();

      shortStayLifeMeetingAndSendingOffRoundTrip.setText("���}����");

      shortStayLifeMeetingAndSendingOffRoundTrip.setGroup(getShortStayLifeMeetingAndSendingOff());

      shortStayLifeMeetingAndSendingOffRoundTrip.setConstraints(VRLayout.FLOW);

      addShortStayLifeMeetingAndSendingOffRoundTrip();
    }
    return shortStayLifeMeetingAndSendingOffRoundTrip;

  }

  /**
   * �h�{�Ǘ��̐����Z���擾���܂��B
   * @return �h�{�Ǘ��̐����Z
   */
  public ACClearableRadioButtonGroup getShortStayLifeDieticianManageRadio(){
    if(shortStayLifeDieticianManageRadio==null){

      shortStayLifeDieticianManageRadio = new ACClearableRadioButtonGroup();

      getShortStayLifeDieticianManageRadioContainer().setText("�h�{�Ǘ��̐����Z");

      shortStayLifeDieticianManageRadio.setBindPath("1210108");

      shortStayLifeDieticianManageRadio.setModel(getShortStayLifeDieticianManageRadioModel());

      shortStayLifeDieticianManageRadio.setUseClearButton(false);

      addShortStayLifeDieticianManageRadio();
    }
    return shortStayLifeDieticianManageRadio;

  }

  /**
   * �h�{�Ǘ��̐����Z�R���e�i���擾���܂��B
   * @return �h�{�Ǘ��̐����Z�R���e�i
   */
  protected ACLabelContainer getShortStayLifeDieticianManageRadioContainer(){
    if(shortStayLifeDieticianManageRadioContainer==null){
      shortStayLifeDieticianManageRadioContainer = new ACLabelContainer();
      shortStayLifeDieticianManageRadioContainer.setFollowChildEnabled(true);
      shortStayLifeDieticianManageRadioContainer.setVAlignment(VRLayout.CENTER);
      shortStayLifeDieticianManageRadioContainer.add(getShortStayLifeDieticianManageRadio(), null);
    }
    return shortStayLifeDieticianManageRadioContainer;
  }

  /**
   * �h�{�Ǘ��̐����Z���f�����擾���܂��B
   * @return �h�{�Ǘ��̐����Z���f��
   */
  protected ACListModelAdapter getShortStayLifeDieticianManageRadioModel(){
    if(shortStayLifeDieticianManageRadioModel==null){
      shortStayLifeDieticianManageRadioModel = new ACListModelAdapter();
      addShortStayLifeDieticianManageRadioModel();
    }
    return shortStayLifeDieticianManageRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getShortStayLifeDieticianManageRadioItem1(){
    if(shortStayLifeDieticianManageRadioItem1==null){

      shortStayLifeDieticianManageRadioItem1 = new ACRadioButtonItem();

      shortStayLifeDieticianManageRadioItem1.setText("�Ȃ�");

      shortStayLifeDieticianManageRadioItem1.setGroup(getShortStayLifeDieticianManageRadio());

      shortStayLifeDieticianManageRadioItem1.setConstraints(VRLayout.FLOW);

      addShortStayLifeDieticianManageRadioItem1();
    }
    return shortStayLifeDieticianManageRadioItem1;

  }

  /**
   * �Ǘ��h�{�m���擾���܂��B
   * @return �Ǘ��h�{�m
   */
  public ACRadioButtonItem getShortStayLifeDieticianManageRadioItem2(){
    if(shortStayLifeDieticianManageRadioItem2==null){

      shortStayLifeDieticianManageRadioItem2 = new ACRadioButtonItem();

      shortStayLifeDieticianManageRadioItem2.setText("�Ǘ��h�{�m");

      shortStayLifeDieticianManageRadioItem2.setGroup(getShortStayLifeDieticianManageRadio());

      shortStayLifeDieticianManageRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

      addShortStayLifeDieticianManageRadioItem2();
    }
    return shortStayLifeDieticianManageRadioItem2;

  }

  /**
   * �h�{�m���擾���܂��B
   * @return �h�{�m
   */
  public ACRadioButtonItem getShortStayLifeDieticianManageRadioItem3(){
    if(shortStayLifeDieticianManageRadioItem3==null){

      shortStayLifeDieticianManageRadioItem3 = new ACRadioButtonItem();

      shortStayLifeDieticianManageRadioItem3.setText("�h�{�m");

      shortStayLifeDieticianManageRadioItem3.setGroup(getShortStayLifeDieticianManageRadio());

      shortStayLifeDieticianManageRadioItem3.setConstraints(VRLayout.FLOW);

      addShortStayLifeDieticianManageRadioItem3();
    }
    return shortStayLifeDieticianManageRadioItem3;

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
   * �×{�H���Z���擾���܂��B
   * @return �×{�H���Z
   */
  public ACClearableRadioButtonGroup getShortStayLifeMedicalExpensesRadio(){
    if(shortStayLifeMedicalExpensesRadio==null){

      shortStayLifeMedicalExpensesRadio = new ACClearableRadioButtonGroup();

      getShortStayLifeMedicalExpensesRadioContainer().setText("�×{�H���Z");

      shortStayLifeMedicalExpensesRadio.setBindPath("1210109");

      shortStayLifeMedicalExpensesRadio.setModel(getShortStayLifeMedicalExpensesRadioModel());

      shortStayLifeMedicalExpensesRadio.setUseClearButton(false);

      addShortStayLifeMedicalExpensesRadio();
    }
    return shortStayLifeMedicalExpensesRadio;

  }

  /**
   * �×{�H���Z�R���e�i���擾���܂��B
   * @return �×{�H���Z�R���e�i
   */
  protected ACLabelContainer getShortStayLifeMedicalExpensesRadioContainer(){
    if(shortStayLifeMedicalExpensesRadioContainer==null){
      shortStayLifeMedicalExpensesRadioContainer = new ACLabelContainer();
      shortStayLifeMedicalExpensesRadioContainer.setFollowChildEnabled(true);
      shortStayLifeMedicalExpensesRadioContainer.setVAlignment(VRLayout.CENTER);
      shortStayLifeMedicalExpensesRadioContainer.add(getShortStayLifeMedicalExpensesRadio(), null);
    }
    return shortStayLifeMedicalExpensesRadioContainer;
  }

  /**
   * �×{�H���Z���f�����擾���܂��B
   * @return �×{�H���Z���f��
   */
  protected ACListModelAdapter getShortStayLifeMedicalExpensesRadioModel(){
    if(shortStayLifeMedicalExpensesRadioModel==null){
      shortStayLifeMedicalExpensesRadioModel = new ACListModelAdapter();
      addShortStayLifeMedicalExpensesRadioModel();
    }
    return shortStayLifeMedicalExpensesRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getShortStayLifeMedicalExpensesRadioItem1(){
    if(shortStayLifeMedicalExpensesRadioItem1==null){

      shortStayLifeMedicalExpensesRadioItem1 = new ACRadioButtonItem();

      shortStayLifeMedicalExpensesRadioItem1.setText("�Ȃ�");

      shortStayLifeMedicalExpensesRadioItem1.setGroup(getShortStayLifeMedicalExpensesRadio());

      shortStayLifeMedicalExpensesRadioItem1.setConstraints(VRLayout.FLOW);

      addShortStayLifeMedicalExpensesRadioItem1();
    }
    return shortStayLifeMedicalExpensesRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getShortStayLifeMedicalExpensesRadioItem2(){
    if(shortStayLifeMedicalExpensesRadioItem2==null){

      shortStayLifeMedicalExpensesRadioItem2 = new ACRadioButtonItem();

      shortStayLifeMedicalExpensesRadioItem2.setText("����");

      shortStayLifeMedicalExpensesRadioItem2.setGroup(getShortStayLifeMedicalExpensesRadio());

      shortStayLifeMedicalExpensesRadioItem2.setConstraints(VRLayout.FLOW);

      addShortStayLifeMedicalExpensesRadioItem2();
    }
    return shortStayLifeMedicalExpensesRadioItem2;

  }

  /**
   * �l�����Z���擾���܂��B
   * @return �l�����Z
   */
  public ACClearableRadioButtonGroup getShortStayLifeSubtraction(){
    if(shortStayLifeSubtraction==null){

      shortStayLifeSubtraction = new ACClearableRadioButtonGroup();

      getShortStayLifeSubtractionContainer().setText("�l�����Z");

      shortStayLifeSubtraction.setBindPath("1210110");

      shortStayLifeSubtraction.setModel(getShortStayLifeSubtractionModel());

      shortStayLifeSubtraction.setUseClearButton(false);

      addShortStayLifeSubtraction();
    }
    return shortStayLifeSubtraction;

  }

  /**
   * �l�����Z�R���e�i���擾���܂��B
   * @return �l�����Z�R���e�i
   */
  protected ACLabelContainer getShortStayLifeSubtractionContainer(){
    if(shortStayLifeSubtractionContainer==null){
      shortStayLifeSubtractionContainer = new ACLabelContainer();
      shortStayLifeSubtractionContainer.setFollowChildEnabled(true);
      shortStayLifeSubtractionContainer.setVAlignment(VRLayout.CENTER);
      shortStayLifeSubtractionContainer.add(getShortStayLifeSubtraction(), null);
    }
    return shortStayLifeSubtractionContainer;
  }

  /**
   * �l�����Z���f�����擾���܂��B
   * @return �l�����Z���f��
   */
  protected ACListModelAdapter getShortStayLifeSubtractionModel(){
    if(shortStayLifeSubtractionModel==null){
      shortStayLifeSubtractionModel = new ACListModelAdapter();
      addShortStayLifeSubtractionModel();
    }
    return shortStayLifeSubtractionModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getShortStayLifeSubtractionNot(){
    if(shortStayLifeSubtractionNot==null){

      shortStayLifeSubtractionNot = new ACRadioButtonItem();

      shortStayLifeSubtractionNot.setText("�Ȃ�");

      shortStayLifeSubtractionNot.setGroup(getShortStayLifeSubtraction());

      shortStayLifeSubtractionNot.setConstraints(VRLayout.FLOW);

      addShortStayLifeSubtractionNot();
    }
    return shortStayLifeSubtractionNot;

  }

  /**
   * ������߂��擾���܂��B
   * @return �������
   */
  public ACRadioButtonItem getShortStayLifeSubtractionExcess(){
    if(shortStayLifeSubtractionExcess==null){

      shortStayLifeSubtractionExcess = new ACRadioButtonItem();

      shortStayLifeSubtractionExcess.setText("�������");

      shortStayLifeSubtractionExcess.setGroup(getShortStayLifeSubtraction());

      shortStayLifeSubtractionExcess.setConstraints(VRLayout.FLOW_RETURN);

      addShortStayLifeSubtractionExcess();
    }
    return shortStayLifeSubtractionExcess;

  }

  /**
   * �Ō�E���E���̕s�����擾���܂��B
   * @return �Ō�E���E���̕s��
   */
  public ACRadioButtonItem getShortStayLifeSubtractionLack(){
    if(shortStayLifeSubtractionLack==null){

      shortStayLifeSubtractionLack = new ACRadioButtonItem();

      shortStayLifeSubtractionLack.setText("�Ō�E���E���̕s��");

      shortStayLifeSubtractionLack.setGroup(getShortStayLifeSubtraction());

      shortStayLifeSubtractionLack.setConstraints(VRLayout.FLOW);

      addShortStayLifeSubtractionLack();
    }
    return shortStayLifeSubtractionLack;

  }

  /**
   * �H���R���e�i���擾���܂��B
   * @return �H���R���e�i
   */
  public ACBackLabelContainer getShortStayLifeDinnerContainer(){
    if(shortStayLifeDinnerContainer==null){

      shortStayLifeDinnerContainer = new ACBackLabelContainer();

      addShortStayLifeDinnerContainer();
    }
    return shortStayLifeDinnerContainer;

  }

  /**
   * �H���񋟂��擾���܂��B
   * @return �H����
   */
  public ACComboBox getShortStayLifeDinnerOffer(){
    if(shortStayLifeDinnerOffer==null){

      shortStayLifeDinnerOffer = new ACComboBox();

      getShortStayLifeDinnerOfferContainer().setText("�H����");

      shortStayLifeDinnerOffer.setBindPath("1210111");

      shortStayLifeDinnerOffer.setEditable(false);

      shortStayLifeDinnerOffer.setModelBindPath("1210111");

      shortStayLifeDinnerOffer.setModel(getShortStayLifeDinnerOfferModel());

      shortStayLifeDinnerOffer.setRenderBindPath("CONTENT");

      addShortStayLifeDinnerOffer();
    }
    return shortStayLifeDinnerOffer;

  }

  /**
   * �H���񋟃R���e�i���擾���܂��B
   * @return �H���񋟃R���e�i
   */
  protected ACLabelContainer getShortStayLifeDinnerOfferContainer(){
    if(shortStayLifeDinnerOfferContainer==null){
      shortStayLifeDinnerOfferContainer = new ACLabelContainer();
      shortStayLifeDinnerOfferContainer.setFollowChildEnabled(true);
      shortStayLifeDinnerOfferContainer.setVAlignment(VRLayout.CENTER);
      shortStayLifeDinnerOfferContainer.add(getShortStayLifeDinnerOffer(), null);
    }
    return shortStayLifeDinnerOfferContainer;
  }

  /**
   * �H���񋟃��f�����擾���܂��B
   * @return �H���񋟃��f��
   */
  protected ACComboBoxModelAdapter getShortStayLifeDinnerOfferModel(){
    if(shortStayLifeDinnerOfferModel==null){
      shortStayLifeDinnerOfferModel = new ACComboBoxModelAdapter();
      addShortStayLifeDinnerOfferModel();
    }
    return shortStayLifeDinnerOfferModel;
  }

  /**
   * �H����p���擾���܂��B
   * @return �H����p
   */
  public ACTextField getShortStayLifeDinnerCost(){
    if(shortStayLifeDinnerCost==null){

      shortStayLifeDinnerCost = new ACTextField();

      getShortStayLifeDinnerCostContainer().setText("�H����p");

      shortStayLifeDinnerCost.setBindPath("1210114");

      shortStayLifeDinnerCost.setColumns(4);

      shortStayLifeDinnerCost.setCharType(VRCharType.ONLY_DIGIT);

      shortStayLifeDinnerCost.setHorizontalAlignment(SwingConstants.RIGHT);

      shortStayLifeDinnerCost.setIMEMode(InputSubset.LATIN);

      shortStayLifeDinnerCost.setMaxLength(5);

      addShortStayLifeDinnerCost();
    }
    return shortStayLifeDinnerCost;

  }

  /**
   * �H����p�R���e�i���擾���܂��B
   * @return �H����p�R���e�i
   */
  protected ACLabelContainer getShortStayLifeDinnerCostContainer(){
    if(shortStayLifeDinnerCostContainer==null){
      shortStayLifeDinnerCostContainer = new ACLabelContainer();
      shortStayLifeDinnerCostContainer.setFollowChildEnabled(true);
      shortStayLifeDinnerCostContainer.setVAlignment(VRLayout.CENTER);
      shortStayLifeDinnerCostContainer.add(getShortStayLifeDinnerCost(), null);
    }
    return shortStayLifeDinnerCostContainer;
  }

  /**
   * 30�������擾���܂��B
   * @return 30����
   */
  public ACIntegerCheckBox getShortStayLifeAddition30Orver(){
    if(shortStayLifeAddition30Orver==null){

      shortStayLifeAddition30Orver = new ACIntegerCheckBox();

      shortStayLifeAddition30Orver.setText("30����");

      shortStayLifeAddition30Orver.setBindPath("5");

      shortStayLifeAddition30Orver.setSelectValue(2);

      shortStayLifeAddition30Orver.setUnSelectValue(1);

      addShortStayLifeAddition30Orver();
    }
    return shortStayLifeAddition30Orver;

  }

  /**
   * ���j�b�g�P�A�̐������擾���܂��B
   * @return ���j�b�g�P�A�̐���
   */
  public ACClearableRadioButtonGroup getShortStayLifeUnitCareAddRadio(){
    if(shortStayLifeUnitCareAddRadio==null){

      shortStayLifeUnitCareAddRadio = new ACClearableRadioButtonGroup();

      getShortStayLifeUnitCareAddRadioContainer().setText("���j�b�g�P�A�̐���");

      shortStayLifeUnitCareAddRadio.setBindPath("1210115");

      shortStayLifeUnitCareAddRadio.setModel(getShortStayLifeUnitCareAddRadioModel());

      shortStayLifeUnitCareAddRadio.setUseClearButton(false);

      addShortStayLifeUnitCareAddRadio();
    }
    return shortStayLifeUnitCareAddRadio;

  }

  /**
   * ���j�b�g�P�A�̐����R���e�i���擾���܂��B
   * @return ���j�b�g�P�A�̐����R���e�i
   */
  protected ACLabelContainer getShortStayLifeUnitCareAddRadioContainer(){
    if(shortStayLifeUnitCareAddRadioContainer==null){
      shortStayLifeUnitCareAddRadioContainer = new ACLabelContainer();
      shortStayLifeUnitCareAddRadioContainer.setFollowChildEnabled(true);
      shortStayLifeUnitCareAddRadioContainer.setVAlignment(VRLayout.CENTER);
      shortStayLifeUnitCareAddRadioContainer.add(getShortStayLifeUnitCareAddRadio(), null);
    }
    return shortStayLifeUnitCareAddRadioContainer;
  }

  /**
   * ���j�b�g�P�A�̐������f�����擾���܂��B
   * @return ���j�b�g�P�A�̐������f��
   */
  protected ACListModelAdapter getShortStayLifeUnitCareAddRadioModel(){
    if(shortStayLifeUnitCareAddRadioModel==null){
      shortStayLifeUnitCareAddRadioModel = new ACListModelAdapter();
      addShortStayLifeUnitCareAddRadioModel();
    }
    return shortStayLifeUnitCareAddRadioModel;
  }

  /**
   * ���������擾���܂��B
   * @return ������
   */
  public ACRadioButtonItem getShortStayLifeUnitCareAddRadioItem1(){
    if(shortStayLifeUnitCareAddRadioItem1==null){

      shortStayLifeUnitCareAddRadioItem1 = new ACRadioButtonItem();

      shortStayLifeUnitCareAddRadioItem1.setText("������");

      shortStayLifeUnitCareAddRadioItem1.setGroup(getShortStayLifeUnitCareAddRadio());

      shortStayLifeUnitCareAddRadioItem1.setConstraints(VRLayout.FLOW);

      addShortStayLifeUnitCareAddRadioItem1();
    }
    return shortStayLifeUnitCareAddRadioItem1;

  }

  /**
   * �������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getShortStayLifeUnitCareAddRadioItem2(){
    if(shortStayLifeUnitCareAddRadioItem2==null){

      shortStayLifeUnitCareAddRadioItem2 = new ACRadioButtonItem();

      shortStayLifeUnitCareAddRadioItem2.setText("����");

      shortStayLifeUnitCareAddRadioItem2.setGroup(getShortStayLifeUnitCareAddRadio());

      shortStayLifeUnitCareAddRadioItem2.setConstraints(VRLayout.FLOW);

      addShortStayLifeUnitCareAddRadioItem2();
    }
    return shortStayLifeUnitCareAddRadioItem2;

  }

  /**
   * �ً}�Z�������l�b�g���[�N���Z���擾���܂��B
   * @return �ً}�Z�������l�b�g���[�N���Z
   */
  public ACClearableRadioButtonGroup getShortStayLifeEmergencyShortNetworkAddRadio(){
    if(shortStayLifeEmergencyShortNetworkAddRadio==null){

      shortStayLifeEmergencyShortNetworkAddRadio = new ACClearableRadioButtonGroup();

      getShortStayLifeEmergencyShortNetworkAddRadioContainer().setText("�ً}�Z�������l�b�g���[�N���Z");

      shortStayLifeEmergencyShortNetworkAddRadio.setBindPath("1210116");

      shortStayLifeEmergencyShortNetworkAddRadio.setModel(getShortStayLifeEmergencyShortNetworkAddRadioModel());

      shortStayLifeEmergencyShortNetworkAddRadio.setUseClearButton(false);

      addShortStayLifeEmergencyShortNetworkAddRadio();
    }
    return shortStayLifeEmergencyShortNetworkAddRadio;

  }

  /**
   * �ً}�Z�������l�b�g���[�N���Z�R���e�i���擾���܂��B
   * @return �ً}�Z�������l�b�g���[�N���Z�R���e�i
   */
  protected ACLabelContainer getShortStayLifeEmergencyShortNetworkAddRadioContainer(){
    if(shortStayLifeEmergencyShortNetworkAddRadioContainer==null){
      shortStayLifeEmergencyShortNetworkAddRadioContainer = new ACLabelContainer();
      shortStayLifeEmergencyShortNetworkAddRadioContainer.setFollowChildEnabled(true);
      shortStayLifeEmergencyShortNetworkAddRadioContainer.setVAlignment(VRLayout.CENTER);
      shortStayLifeEmergencyShortNetworkAddRadioContainer.add(getShortStayLifeEmergencyShortNetworkAddRadio(), null);
    }
    return shortStayLifeEmergencyShortNetworkAddRadioContainer;
  }

  /**
   * �ً}�Z�������l�b�g���[�N���Z���f�����擾���܂��B
   * @return �ً}�Z�������l�b�g���[�N���Z���f��
   */
  protected ACListModelAdapter getShortStayLifeEmergencyShortNetworkAddRadioModel(){
    if(shortStayLifeEmergencyShortNetworkAddRadioModel==null){
      shortStayLifeEmergencyShortNetworkAddRadioModel = new ACListModelAdapter();
      addShortStayLifeEmergencyShortNetworkAddRadioModel();
    }
    return shortStayLifeEmergencyShortNetworkAddRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getShortStayLifeEmergencyShortNetworkAddRadioItem1(){
    if(shortStayLifeEmergencyShortNetworkAddRadioItem1==null){

      shortStayLifeEmergencyShortNetworkAddRadioItem1 = new ACRadioButtonItem();

      shortStayLifeEmergencyShortNetworkAddRadioItem1.setText("�Ȃ�");

      shortStayLifeEmergencyShortNetworkAddRadioItem1.setGroup(getShortStayLifeEmergencyShortNetworkAddRadio());

      shortStayLifeEmergencyShortNetworkAddRadioItem1.setConstraints(VRLayout.FLOW);

      addShortStayLifeEmergencyShortNetworkAddRadioItem1();
    }
    return shortStayLifeEmergencyShortNetworkAddRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getShortStayLifeEmergencyShortNetworkAddRadioItem2(){
    if(shortStayLifeEmergencyShortNetworkAddRadioItem2==null){

      shortStayLifeEmergencyShortNetworkAddRadioItem2 = new ACRadioButtonItem();

      shortStayLifeEmergencyShortNetworkAddRadioItem2.setText("����");

      shortStayLifeEmergencyShortNetworkAddRadioItem2.setGroup(getShortStayLifeEmergencyShortNetworkAddRadio());

      shortStayLifeEmergencyShortNetworkAddRadioItem2.setConstraints(VRLayout.FLOW);

      addShortStayLifeEmergencyShortNetworkAddRadioItem2();
    }
    return shortStayLifeEmergencyShortNetworkAddRadioItem2;

  }

  /**
   * �ݑ�d�x���Z���擾���܂��B
   * @return �ݑ�d�x���Z
   */
  public ACGroupBox getShortStayLifeStayheavyAddGroup(){
    if(shortStayLifeStayheavyAddGroup==null){

      shortStayLifeStayheavyAddGroup = new ACGroupBox();

      shortStayLifeStayheavyAddGroup.setText("�ݑ�d�x���Z");

      addShortStayLifeStayheavyAddGroup();
    }
    return shortStayLifeStayheavyAddGroup;

  }

  /**
   * ��ԊŌ�̐����Z���擾���܂��B
   * @return ��ԊŌ�̐����Z
   */
  public ACClearableRadioButtonGroup getShortStayLifeNightNursingSystemAddRadio(){
    if(shortStayLifeNightNursingSystemAddRadio==null){

      shortStayLifeNightNursingSystemAddRadio = new ACClearableRadioButtonGroup();

      getShortStayLifeNightNursingSystemAddRadioContainer().setText("��ԊŌ�̐����Z");

      shortStayLifeNightNursingSystemAddRadio.setBindPath("1210117");

      shortStayLifeNightNursingSystemAddRadio.setModel(getShortStayLifeNightNursingSystemAddRadioModel());

      shortStayLifeNightNursingSystemAddRadio.setUseClearButton(false);

      addShortStayLifeNightNursingSystemAddRadio();
    }
    return shortStayLifeNightNursingSystemAddRadio;

  }

  /**
   * ��ԊŌ�̐����Z�R���e�i���擾���܂��B
   * @return ��ԊŌ�̐����Z�R���e�i
   */
  protected ACLabelContainer getShortStayLifeNightNursingSystemAddRadioContainer(){
    if(shortStayLifeNightNursingSystemAddRadioContainer==null){
      shortStayLifeNightNursingSystemAddRadioContainer = new ACLabelContainer();
      shortStayLifeNightNursingSystemAddRadioContainer.setFollowChildEnabled(true);
      shortStayLifeNightNursingSystemAddRadioContainer.setVAlignment(VRLayout.CENTER);
      shortStayLifeNightNursingSystemAddRadioContainer.add(getShortStayLifeNightNursingSystemAddRadio(), null);
    }
    return shortStayLifeNightNursingSystemAddRadioContainer;
  }

  /**
   * ��ԊŌ�̐����Z���f�����擾���܂��B
   * @return ��ԊŌ�̐����Z���f��
   */
  protected ACListModelAdapter getShortStayLifeNightNursingSystemAddRadioModel(){
    if(shortStayLifeNightNursingSystemAddRadioModel==null){
      shortStayLifeNightNursingSystemAddRadioModel = new ACListModelAdapter();
      addShortStayLifeNightNursingSystemAddRadioModel();
    }
    return shortStayLifeNightNursingSystemAddRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getShortStayLifeNightNursingSystemAddRadioItem1(){
    if(shortStayLifeNightNursingSystemAddRadioItem1==null){

      shortStayLifeNightNursingSystemAddRadioItem1 = new ACRadioButtonItem();

      shortStayLifeNightNursingSystemAddRadioItem1.setText("�Ȃ�");

      shortStayLifeNightNursingSystemAddRadioItem1.setGroup(getShortStayLifeNightNursingSystemAddRadio());

      shortStayLifeNightNursingSystemAddRadioItem1.setConstraints(VRLayout.FLOW);

      addShortStayLifeNightNursingSystemAddRadioItem1();
    }
    return shortStayLifeNightNursingSystemAddRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getShortStayLifeNightNursingSystemAddRadioItem2(){
    if(shortStayLifeNightNursingSystemAddRadioItem2==null){

      shortStayLifeNightNursingSystemAddRadioItem2 = new ACRadioButtonItem();

      shortStayLifeNightNursingSystemAddRadioItem2.setText("����");

      shortStayLifeNightNursingSystemAddRadioItem2.setGroup(getShortStayLifeNightNursingSystemAddRadio());

      shortStayLifeNightNursingSystemAddRadioItem2.setConstraints(VRLayout.FLOW);

      addShortStayLifeNightNursingSystemAddRadioItem2();
    }
    return shortStayLifeNightNursingSystemAddRadioItem2;

  }

  /**
   * �ݑ�d�x�Ҏ�����Z���擾���܂��B
   * @return �ݑ�d�x�Ҏ�����Z
   */
  public ACClearableRadioButtonGroup getShortStayLifeStayheavyAddRadio(){
    if(shortStayLifeStayheavyAddRadio==null){

      shortStayLifeStayheavyAddRadio = new ACClearableRadioButtonGroup();

      getShortStayLifeStayheavyAddRadioContainer().setText("�ݑ�d�x�Ҏ�����Z");

      shortStayLifeStayheavyAddRadio.setBindPath("1210118");

      shortStayLifeStayheavyAddRadio.setModel(getShortStayLifeStayheavyAddRadioModel());

      shortStayLifeStayheavyAddRadio.setUseClearButton(false);

      addShortStayLifeStayheavyAddRadio();
    }
    return shortStayLifeStayheavyAddRadio;

  }

  /**
   * �ݑ�d�x�Ҏ�����Z�R���e�i���擾���܂��B
   * @return �ݑ�d�x�Ҏ�����Z�R���e�i
   */
  protected ACLabelContainer getShortStayLifeStayheavyAddRadioContainer(){
    if(shortStayLifeStayheavyAddRadioContainer==null){
      shortStayLifeStayheavyAddRadioContainer = new ACLabelContainer();
      shortStayLifeStayheavyAddRadioContainer.setFollowChildEnabled(true);
      shortStayLifeStayheavyAddRadioContainer.setVAlignment(VRLayout.CENTER);
      shortStayLifeStayheavyAddRadioContainer.add(getShortStayLifeStayheavyAddRadio(), null);
    }
    return shortStayLifeStayheavyAddRadioContainer;
  }

  /**
   * �ݑ�d�x�Ҏ�����Z���f�����擾���܂��B
   * @return �ݑ�d�x�Ҏ�����Z���f��
   */
  protected ACListModelAdapter getShortStayLifeStayheavyAddRadioModel(){
    if(shortStayLifeStayheavyAddRadioModel==null){
      shortStayLifeStayheavyAddRadioModel = new ACListModelAdapter();
      addShortStayLifeStayheavyAddRadioModel();
    }
    return shortStayLifeStayheavyAddRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getShortStayLifeStayheavyAddRadioItem1(){
    if(shortStayLifeStayheavyAddRadioItem1==null){

      shortStayLifeStayheavyAddRadioItem1 = new ACRadioButtonItem();

      shortStayLifeStayheavyAddRadioItem1.setText("�Ȃ�");

      shortStayLifeStayheavyAddRadioItem1.setGroup(getShortStayLifeStayheavyAddRadio());

      shortStayLifeStayheavyAddRadioItem1.setConstraints(VRLayout.FLOW);

      addShortStayLifeStayheavyAddRadioItem1();
    }
    return shortStayLifeStayheavyAddRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getShortStayLifeStayheavyAddRadioItem2(){
    if(shortStayLifeStayheavyAddRadioItem2==null){

      shortStayLifeStayheavyAddRadioItem2 = new ACRadioButtonItem();

      shortStayLifeStayheavyAddRadioItem2.setText("����");

      shortStayLifeStayheavyAddRadioItem2.setGroup(getShortStayLifeStayheavyAddRadio());

      shortStayLifeStayheavyAddRadioItem2.setConstraints(VRLayout.FLOW);

      addShortStayLifeStayheavyAddRadioItem2();
    }
    return shortStayLifeStayheavyAddRadioItem2;

  }

  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001109Design() {

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

    tab1.add(getShortStayLifeTimeContenaFacilityDivisionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getShortStayLifeHospitalRoomDivisionContena(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getNightWorkConditionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getShortStayLifeAdditionFunctionTrainingRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getShortStayLifeMeetingAndSendingOffContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getShortStayLifeDieticianManageRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * �{�ݓ��̋敪�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayLifeTimeContenaFacilityDivision(){

  }

  /**
   * �{�ݓ��̋敪���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayLifeTimeContenaFacilityDivisionModel(){

    getShortStayLifeSingle().setButtonIndex(1);
    getShortStayLifeTimeContenaFacilityDivisionModel().add(getShortStayLifeSingle());

    getShortStayLifeDouble().setButtonIndex(2);
    getShortStayLifeTimeContenaFacilityDivisionModel().add(getShortStayLifeDouble());

    getShortStayLifeSingleUnit().setButtonIndex(3);
    getShortStayLifeTimeContenaFacilityDivisionModel().add(getShortStayLifeSingleUnit());

    getShortStayLifeDoubleUnit().setButtonIndex(4);
    getShortStayLifeTimeContenaFacilityDivisionModel().add(getShortStayLifeDoubleUnit());

  }

  /**
   * �P�ƌ^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayLifeSingle(){

  }

  /**
   * ���݌^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayLifeDouble(){

  }

  /**
   * �P�ƌ^���j�b�g�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayLifeSingleUnit(){

  }

  /**
   * ���݌^���j�b�g�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayLifeDoubleUnit(){

  }

  /**
   * �a���敪�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayLifeHospitalRoomDivisionContena(){

    shortStayLifeHospitalRoomDivisionContena.add(getShortStayLifeHospitalRoomDivisionRadio(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayLifeHospitalRoomDivisionContena.add(getShortStayLifeUnitHospitalRoomDivisionRadio(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * �a���敪�i�ʏ�j�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayLifeHospitalRoomDivisionRadio(){

  }

  /**
   * �a���敪�i�ʏ�j���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayLifeHospitalRoomDivisionRadioModel(){

    getShortStayLifeHospitalRoomDivisionRadioItem1().setButtonIndex(1);
    getShortStayLifeHospitalRoomDivisionRadioModel().add(getShortStayLifeHospitalRoomDivisionRadioItem1());

    getShortStayLifeHospitalRoomDivisionRadioItem2().setButtonIndex(2);
    getShortStayLifeHospitalRoomDivisionRadioModel().add(getShortStayLifeHospitalRoomDivisionRadioItem2());

  }

  /**
   * �]���^���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayLifeHospitalRoomDivisionRadioItem1(){

  }

  /**
   * �������ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayLifeHospitalRoomDivisionRadioItem2(){

  }

  /**
   * �a���敪�i���j�b�g�j�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayLifeUnitHospitalRoomDivisionRadio(){

  }

  /**
   * �a���敪�i���j�b�g�j���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayLifeUnitHospitalRoomDivisionRadioModel(){

    getShortStayLifeUnitHospitalRoomDivisionRadioItem1().setButtonIndex(1);
    getShortStayLifeUnitHospitalRoomDivisionRadioModel().add(getShortStayLifeUnitHospitalRoomDivisionRadioItem1());

    getShortStayLifeUnitHospitalRoomDivisionRadioItem2().setButtonIndex(2);
    getShortStayLifeUnitHospitalRoomDivisionRadioModel().add(getShortStayLifeUnitHospitalRoomDivisionRadioItem2());

  }

  /**
   * ���j�b�g�^���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayLifeUnitHospitalRoomDivisionRadioItem1(){

  }

  /**
   * ���j�b�g�^�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayLifeUnitHospitalRoomDivisionRadioItem2(){

  }

  /**
   * ��ԋΖ�������ɓ������ڂ�ǉ����܂��B
   */
  protected void addNightWorkConditionRadio(){

  }

  /**
   * ��ԋΖ���������f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addNightWorkConditionRadioModel(){

    getNightWorkConditionRadioItem1().setButtonIndex(1);
    getNightWorkConditionRadioModel().add(getNightWorkConditionRadioItem1());

    getNightWorkConditionRadioItem2().setButtonIndex(2);
    getNightWorkConditionRadioModel().add(getNightWorkConditionRadioItem2());

  }

  /**
   * ��^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addNightWorkConditionRadioItem1(){

  }

  /**
   * ���Z�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addNightWorkConditionRadioItem2(){

  }

  /**
   * �@�\�P���w���̐����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayLifeAdditionFunctionTrainingRadio(){

  }

  /**
   * �@�\�P���w���̐����Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayLifeAdditionFunctionTrainingRadioModel(){

    getShortStayLifeAdditionFunctionTrainingRadioItem2().setButtonIndex(1);
    getShortStayLifeAdditionFunctionTrainingRadioModel().add(getShortStayLifeAdditionFunctionTrainingRadioItem2());

    getShortStayLifeAdditionFunctionTrainingRadioItem1().setButtonIndex(2);
    getShortStayLifeAdditionFunctionTrainingRadioModel().add(getShortStayLifeAdditionFunctionTrainingRadioItem1());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayLifeAdditionFunctionTrainingRadioItem2(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayLifeAdditionFunctionTrainingRadioItem1(){

  }

  /**
   * ���}�敪�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayLifeMeetingAndSendingOff(){

  }

  /**
   * ���}�敪���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayLifeMeetingAndSendingOffModel(){

    getShortStayLifeMeetingAndSendingOffNone().setButtonIndex(1);
    getShortStayLifeMeetingAndSendingOffModel().add(getShortStayLifeMeetingAndSendingOffNone());

    getShortStayLifeMeetingAndSendingOffOneWay().setButtonIndex(2);
    getShortStayLifeMeetingAndSendingOffModel().add(getShortStayLifeMeetingAndSendingOffOneWay());

    getShortStayLifeMeetingAndSendingOffRoundTrip().setButtonIndex(3);
    getShortStayLifeMeetingAndSendingOffModel().add(getShortStayLifeMeetingAndSendingOffRoundTrip());

  }

  /**
   * ���}�Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayLifeMeetingAndSendingOffNone(){

  }

  /**
   * ���}�Г��ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayLifeMeetingAndSendingOffOneWay(){

  }

  /**
   * ���}�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayLifeMeetingAndSendingOffRoundTrip(){

  }

  /**
   * �h�{�Ǘ��̐����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayLifeDieticianManageRadio(){

  }

  /**
   * �h�{�Ǘ��̐����Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayLifeDieticianManageRadioModel(){

    getShortStayLifeDieticianManageRadioItem1().setButtonIndex(1);
    getShortStayLifeDieticianManageRadioModel().add(getShortStayLifeDieticianManageRadioItem1());

    getShortStayLifeDieticianManageRadioItem2().setButtonIndex(2);
    getShortStayLifeDieticianManageRadioModel().add(getShortStayLifeDieticianManageRadioItem2());

    getShortStayLifeDieticianManageRadioItem3().setButtonIndex(3);
    getShortStayLifeDieticianManageRadioModel().add(getShortStayLifeDieticianManageRadioItem3());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayLifeDieticianManageRadioItem1(){

  }

  /**
   * �Ǘ��h�{�m�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayLifeDieticianManageRadioItem2(){

  }

  /**
   * �h�{�m�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayLifeDieticianManageRadioItem3(){

  }

  /**
   * �^�u2�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTab2(){

    tab2.add(getShortStayLifeMedicalExpensesRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getShortStayLifeSubtractionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getShortStayLifeDinnerContainer(), VRLayout.FLOW_DOUBLEINSETLINE_RETURN);

    tab2.add(getShortStayLifeAddition30Orver(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getShortStayLifeUnitCareAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getShortStayLifeEmergencyShortNetworkAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getShortStayLifeStayheavyAddGroup(), VRLayout.FLOW_RETURN);

  }

  /**
   * �×{�H���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayLifeMedicalExpensesRadio(){

  }

  /**
   * �×{�H���Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayLifeMedicalExpensesRadioModel(){

    getShortStayLifeMedicalExpensesRadioItem1().setButtonIndex(1);
    getShortStayLifeMedicalExpensesRadioModel().add(getShortStayLifeMedicalExpensesRadioItem1());

    getShortStayLifeMedicalExpensesRadioItem2().setButtonIndex(2);
    getShortStayLifeMedicalExpensesRadioModel().add(getShortStayLifeMedicalExpensesRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayLifeMedicalExpensesRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayLifeMedicalExpensesRadioItem2(){

  }

  /**
   * �l�����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayLifeSubtraction(){

  }

  /**
   * �l�����Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayLifeSubtractionModel(){

    getShortStayLifeSubtractionNot().setButtonIndex(1);
    getShortStayLifeSubtractionModel().add(getShortStayLifeSubtractionNot());

    getShortStayLifeSubtractionExcess().setButtonIndex(2);
    getShortStayLifeSubtractionModel().add(getShortStayLifeSubtractionExcess());

    getShortStayLifeSubtractionLack().setButtonIndex(3);
    getShortStayLifeSubtractionModel().add(getShortStayLifeSubtractionLack());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayLifeSubtractionNot(){

  }

  /**
   * ������߂ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayLifeSubtractionExcess(){

  }

  /**
   * �Ō�E���E���̕s���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayLifeSubtractionLack(){

  }

  /**
   * �H���R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayLifeDinnerContainer(){

    shortStayLifeDinnerContainer.add(getShortStayLifeDinnerOfferContainer(), VRLayout.FLOW);

    shortStayLifeDinnerContainer.add(getShortStayLifeDinnerCostContainer(), VRLayout.FLOW);

  }

  /**
   * �H���񋟂ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayLifeDinnerOffer(){

  }

  /**
   * �H���񋟃��f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayLifeDinnerOfferModel(){

  }

  /**
   * �H����p�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayLifeDinnerCost(){

  }

  /**
   * 30�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayLifeAddition30Orver(){

  }

  /**
   * ���j�b�g�P�A�̐����ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayLifeUnitCareAddRadio(){

  }

  /**
   * ���j�b�g�P�A�̐������f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayLifeUnitCareAddRadioModel(){

    getShortStayLifeUnitCareAddRadioItem1().setButtonIndex(1);
    getShortStayLifeUnitCareAddRadioModel().add(getShortStayLifeUnitCareAddRadioItem1());

    getShortStayLifeUnitCareAddRadioItem2().setButtonIndex(2);
    getShortStayLifeUnitCareAddRadioModel().add(getShortStayLifeUnitCareAddRadioItem2());

  }

  /**
   * �������ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayLifeUnitCareAddRadioItem1(){

  }

  /**
   * �����ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayLifeUnitCareAddRadioItem2(){

  }

  /**
   * �ً}�Z�������l�b�g���[�N���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayLifeEmergencyShortNetworkAddRadio(){

  }

  /**
   * �ً}�Z�������l�b�g���[�N���Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayLifeEmergencyShortNetworkAddRadioModel(){

    getShortStayLifeEmergencyShortNetworkAddRadioItem1().setButtonIndex(1);
    getShortStayLifeEmergencyShortNetworkAddRadioModel().add(getShortStayLifeEmergencyShortNetworkAddRadioItem1());

    getShortStayLifeEmergencyShortNetworkAddRadioItem2().setButtonIndex(2);
    getShortStayLifeEmergencyShortNetworkAddRadioModel().add(getShortStayLifeEmergencyShortNetworkAddRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayLifeEmergencyShortNetworkAddRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayLifeEmergencyShortNetworkAddRadioItem2(){

  }

  /**
   * �ݑ�d�x���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayLifeStayheavyAddGroup(){

    shortStayLifeStayheavyAddGroup.add(getShortStayLifeNightNursingSystemAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayLifeStayheavyAddGroup.add(getShortStayLifeStayheavyAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * ��ԊŌ�̐����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayLifeNightNursingSystemAddRadio(){

  }

  /**
   * ��ԊŌ�̐����Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayLifeNightNursingSystemAddRadioModel(){

    getShortStayLifeNightNursingSystemAddRadioItem1().setButtonIndex(1);
    getShortStayLifeNightNursingSystemAddRadioModel().add(getShortStayLifeNightNursingSystemAddRadioItem1());

    getShortStayLifeNightNursingSystemAddRadioItem2().setButtonIndex(2);
    getShortStayLifeNightNursingSystemAddRadioModel().add(getShortStayLifeNightNursingSystemAddRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayLifeNightNursingSystemAddRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayLifeNightNursingSystemAddRadioItem2(){

  }

  /**
   * �ݑ�d�x�Ҏ�����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayLifeStayheavyAddRadio(){

  }

  /**
   * �ݑ�d�x�Ҏ�����Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayLifeStayheavyAddRadioModel(){

    getShortStayLifeStayheavyAddRadioItem1().setButtonIndex(1);
    getShortStayLifeStayheavyAddRadioModel().add(getShortStayLifeStayheavyAddRadioItem1());

    getShortStayLifeStayheavyAddRadioItem2().setButtonIndex(2);
    getShortStayLifeStayheavyAddRadioModel().add(getShortStayLifeStayheavyAddRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayLifeStayheavyAddRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayLifeStayheavyAddRadioItem2(){

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
      ACFrame.debugStart(new ACAffairInfo(QS001109Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QS001109Design getThis() {
    return this;
  }
}
