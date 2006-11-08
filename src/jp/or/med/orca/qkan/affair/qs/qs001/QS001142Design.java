
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
 * �쐬��: 2006/05/16  ���{�R���s���[�^�[������� ���{�@�K�� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �T�[�r�X�\��쐬/�ύX (S)
 * �v���Z�X �T�[�r�X�\��T�� (001)
 * �v���O���� �T�[�r�X�p�^�[�����\�h�Z�������×{���i��K���f�Ï��j (QS001142)
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
 * �T�[�r�X�p�^�[�����\�h�Z�������×{���i��K���f�Ï��j��ʍ��ڃf�U�C��(QS001142) 
 */
public class QS001142Design extends QS001ServicePanel {
  //GUI�R���|�[�l���g

  private ACPanel shortStayStandardRecuperationPatterns;

  private ACClearableRadioButtonGroup shortStayStandardRecuperationHospitalRoomDivisionRadio;

  private ACLabelContainer shortStayStandardRecuperationHospitalRoomDivisionRadioContainer;

  private ACListModelAdapter shortStayStandardRecuperationHospitalRoomDivisionRadioModel;

  private ACRadioButtonItem shortStayStandardRecuperationHospitalRoomDivisionRadioItem1;

  private ACRadioButtonItem shortStayStandardRecuperationHospitalRoomDivisionRadioItem2;

  private ACClearableRadioButtonGroup shortStayStandardRecuperationMeetingAndSendingOff;

  private ACLabelContainer shortStayStandardRecuperationMeetingAndSendingOffContainer;

  private ACListModelAdapter shortStayStandardRecuperationMeetingAndSendingOffModel;

  private ACRadioButtonItem shortStayStandardRecuperationMeetingAndSendingOffNone;

  private ACRadioButtonItem shortStayStandardRecuperationMeetingAndSendingOffOneWay;

  private ACRadioButtonItem shortStayStandardRecuperationMeetingAndSendingOffRoundTrip;

  private ACClearableRadioButtonGroup shortStayStandardRecuperationDieticianManageRadio;

  private ACLabelContainer shortStayStandardRecuperationDieticianManageRadioContainer;

  private ACListModelAdapter shortStayStandardRecuperationDieticianManageRadioModel;

  private ACRadioButtonItem shortStayStandardRecuperationDieticianManageRadioItem1;

  private ACRadioButtonItem shortStayStandardRecuperationDieticianManageRadioItem2;

  private ACRadioButtonItem shortStayStandardRecuperationDieticianManageRadioItem3;

  private ACClearableRadioButtonGroup shortStayStandardRecuperationMedicalExpensesRadio;

  private ACLabelContainer shortStayStandardRecuperationMedicalExpensesRadioContainer;

  private ACListModelAdapter shortStayStandardRecuperationMedicalExpensesRadioModel;

  private ACRadioButtonItem shortStayStandardRecuperationMedicalExpensesRadioItem1;

  private ACRadioButtonItem shortStayStandardRecuperationMedicalExpensesRadioItem2;

  private ACClearableRadioButtonGroup shortStayStandardRecuperationEtcShiftSubtractionRadio;

  private ACLabelContainer shortStayStandardRecuperationEtcShiftSubtractionRadioContainer;

  private ACListModelAdapter shortStayStandardRecuperationEtcShiftSubtractionRadioModel;

  private ACRadioButtonItem shortStayStandardRecuperationEtcShiftSubtractionRadioItem1;

  private ACRadioButtonItem shortStayStandardRecuperationEtcShiftSubtractionRadioItem2;

  private ACBackLabelContainer shortStayStandardRecuperationDinnerContainer;

  private ACComboBox shortStayStandardRecuperationDinnerOffer;

  private ACLabelContainer shortStayStandardRecuperationDinnerOfferContainer;

  private ACComboBoxModelAdapter shortStayStandardRecuperationDinnerOfferModel;

  private ACTextField shortStayStandardRecuperationDinnerCost;

  private ACLabelContainer shortStayStandardRecuperationDinnerCostContainer;

  private ACIntegerCheckBox shortStayStandardRecuperationEtc30Over;

  //getter

  /**
   * �Z�������×{���i��K���f�Ï��j�p�^�[���̈�j���擾���܂��B
   * @return �Z�������×{���i��K���f�Ï��j�p�^�[���̈�j
   */
  public ACPanel getShortStayStandardRecuperationPatterns(){
    if(shortStayStandardRecuperationPatterns==null){

      shortStayStandardRecuperationPatterns = new ACPanel();

      shortStayStandardRecuperationPatterns.setHgap(0);

      addShortStayStandardRecuperationPatterns();
    }
    return shortStayStandardRecuperationPatterns;

  }

  /**
   * �a���敪���擾���܂��B
   * @return �a���敪
   */
  public ACClearableRadioButtonGroup getShortStayStandardRecuperationHospitalRoomDivisionRadio(){
    if(shortStayStandardRecuperationHospitalRoomDivisionRadio==null){

      shortStayStandardRecuperationHospitalRoomDivisionRadio = new ACClearableRadioButtonGroup();

      getShortStayStandardRecuperationHospitalRoomDivisionRadioContainer().setText("�a���敪");

      shortStayStandardRecuperationHospitalRoomDivisionRadio.setBindPath("1260401");

      shortStayStandardRecuperationHospitalRoomDivisionRadio.setUseClearButton(false);

      shortStayStandardRecuperationHospitalRoomDivisionRadio.setModel(getShortStayStandardRecuperationHospitalRoomDivisionRadioModel());

      addShortStayStandardRecuperationHospitalRoomDivisionRadio();
    }
    return shortStayStandardRecuperationHospitalRoomDivisionRadio;

  }

  /**
   * �a���敪�R���e�i���擾���܂��B
   * @return �a���敪�R���e�i
   */
  protected ACLabelContainer getShortStayStandardRecuperationHospitalRoomDivisionRadioContainer(){
    if(shortStayStandardRecuperationHospitalRoomDivisionRadioContainer==null){
      shortStayStandardRecuperationHospitalRoomDivisionRadioContainer = new ACLabelContainer();
      shortStayStandardRecuperationHospitalRoomDivisionRadioContainer.setFollowChildEnabled(true);
      shortStayStandardRecuperationHospitalRoomDivisionRadioContainer.setVAlignment(VRLayout.CENTER);
      shortStayStandardRecuperationHospitalRoomDivisionRadioContainer.add(getShortStayStandardRecuperationHospitalRoomDivisionRadio(), null);
    }
    return shortStayStandardRecuperationHospitalRoomDivisionRadioContainer;
  }

  /**
   * �a���敪���f�����擾���܂��B
   * @return �a���敪���f��
   */
  protected ACListModelAdapter getShortStayStandardRecuperationHospitalRoomDivisionRadioModel(){
    if(shortStayStandardRecuperationHospitalRoomDivisionRadioModel==null){
      shortStayStandardRecuperationHospitalRoomDivisionRadioModel = new ACListModelAdapter();
      addShortStayStandardRecuperationHospitalRoomDivisionRadioModel();
    }
    return shortStayStandardRecuperationHospitalRoomDivisionRadioModel;
  }

  /**
   * �]���^�����擾���܂��B
   * @return �]���^��
   */
  public ACRadioButtonItem getShortStayStandardRecuperationHospitalRoomDivisionRadioItem1(){
    if(shortStayStandardRecuperationHospitalRoomDivisionRadioItem1==null){

      shortStayStandardRecuperationHospitalRoomDivisionRadioItem1 = new ACRadioButtonItem();

      shortStayStandardRecuperationHospitalRoomDivisionRadioItem1.setText("�]���^��");

      shortStayStandardRecuperationHospitalRoomDivisionRadioItem1.setGroup(getShortStayStandardRecuperationHospitalRoomDivisionRadio());

      shortStayStandardRecuperationHospitalRoomDivisionRadioItem1.setConstraints(VRLayout.FLOW);

      addShortStayStandardRecuperationHospitalRoomDivisionRadioItem1();
    }
    return shortStayStandardRecuperationHospitalRoomDivisionRadioItem1;

  }

  /**
   * ���������擾���܂��B
   * @return ������
   */
  public ACRadioButtonItem getShortStayStandardRecuperationHospitalRoomDivisionRadioItem2(){
    if(shortStayStandardRecuperationHospitalRoomDivisionRadioItem2==null){

      shortStayStandardRecuperationHospitalRoomDivisionRadioItem2 = new ACRadioButtonItem();

      shortStayStandardRecuperationHospitalRoomDivisionRadioItem2.setText("������");

      shortStayStandardRecuperationHospitalRoomDivisionRadioItem2.setGroup(getShortStayStandardRecuperationHospitalRoomDivisionRadio());

      shortStayStandardRecuperationHospitalRoomDivisionRadioItem2.setConstraints(VRLayout.FLOW);

      addShortStayStandardRecuperationHospitalRoomDivisionRadioItem2();
    }
    return shortStayStandardRecuperationHospitalRoomDivisionRadioItem2;

  }

  /**
   * ���}���擾���܂��B
   * @return ���}
   */
  public ACClearableRadioButtonGroup getShortStayStandardRecuperationMeetingAndSendingOff(){
    if(shortStayStandardRecuperationMeetingAndSendingOff==null){

      shortStayStandardRecuperationMeetingAndSendingOff = new ACClearableRadioButtonGroup();

      getShortStayStandardRecuperationMeetingAndSendingOffContainer().setText("���}���Z");

      shortStayStandardRecuperationMeetingAndSendingOff.setBindPath("6");

      shortStayStandardRecuperationMeetingAndSendingOff.setUseClearButton(false);

      shortStayStandardRecuperationMeetingAndSendingOff.setModel(getShortStayStandardRecuperationMeetingAndSendingOffModel());

      addShortStayStandardRecuperationMeetingAndSendingOff();
    }
    return shortStayStandardRecuperationMeetingAndSendingOff;

  }

  /**
   * ���}�R���e�i���擾���܂��B
   * @return ���}�R���e�i
   */
  protected ACLabelContainer getShortStayStandardRecuperationMeetingAndSendingOffContainer(){
    if(shortStayStandardRecuperationMeetingAndSendingOffContainer==null){
      shortStayStandardRecuperationMeetingAndSendingOffContainer = new ACLabelContainer();
      shortStayStandardRecuperationMeetingAndSendingOffContainer.setFollowChildEnabled(true);
      shortStayStandardRecuperationMeetingAndSendingOffContainer.setVAlignment(VRLayout.CENTER);
      shortStayStandardRecuperationMeetingAndSendingOffContainer.add(getShortStayStandardRecuperationMeetingAndSendingOff(), null);
    }
    return shortStayStandardRecuperationMeetingAndSendingOffContainer;
  }

  /**
   * ���}���f�����擾���܂��B
   * @return ���}���f��
   */
  protected ACListModelAdapter getShortStayStandardRecuperationMeetingAndSendingOffModel(){
    if(shortStayStandardRecuperationMeetingAndSendingOffModel==null){
      shortStayStandardRecuperationMeetingAndSendingOffModel = new ACListModelAdapter();
      addShortStayStandardRecuperationMeetingAndSendingOffModel();
    }
    return shortStayStandardRecuperationMeetingAndSendingOffModel;
  }

  /**
   * ���}�Ȃ����擾���܂��B
   * @return ���}�Ȃ�
   */
  public ACRadioButtonItem getShortStayStandardRecuperationMeetingAndSendingOffNone(){
    if(shortStayStandardRecuperationMeetingAndSendingOffNone==null){

      shortStayStandardRecuperationMeetingAndSendingOffNone = new ACRadioButtonItem();

      shortStayStandardRecuperationMeetingAndSendingOffNone.setText("���}�Ȃ�");

      shortStayStandardRecuperationMeetingAndSendingOffNone.setGroup(getShortStayStandardRecuperationMeetingAndSendingOff());

      shortStayStandardRecuperationMeetingAndSendingOffNone.setConstraints(VRLayout.FLOW);

      addShortStayStandardRecuperationMeetingAndSendingOffNone();
    }
    return shortStayStandardRecuperationMeetingAndSendingOffNone;

  }

  /**
   * ���}�Г����擾���܂��B
   * @return ���}�Г�
   */
  public ACRadioButtonItem getShortStayStandardRecuperationMeetingAndSendingOffOneWay(){
    if(shortStayStandardRecuperationMeetingAndSendingOffOneWay==null){

      shortStayStandardRecuperationMeetingAndSendingOffOneWay = new ACRadioButtonItem();

      shortStayStandardRecuperationMeetingAndSendingOffOneWay.setText("���}�Г�");

      shortStayStandardRecuperationMeetingAndSendingOffOneWay.setGroup(getShortStayStandardRecuperationMeetingAndSendingOff());

      shortStayStandardRecuperationMeetingAndSendingOffOneWay.setConstraints(VRLayout.FLOW);

      addShortStayStandardRecuperationMeetingAndSendingOffOneWay();
    }
    return shortStayStandardRecuperationMeetingAndSendingOffOneWay;

  }

  /**
   * ���}�������擾���܂��B
   * @return ���}����
   */
  public ACRadioButtonItem getShortStayStandardRecuperationMeetingAndSendingOffRoundTrip(){
    if(shortStayStandardRecuperationMeetingAndSendingOffRoundTrip==null){

      shortStayStandardRecuperationMeetingAndSendingOffRoundTrip = new ACRadioButtonItem();

      shortStayStandardRecuperationMeetingAndSendingOffRoundTrip.setText("���}����");

      shortStayStandardRecuperationMeetingAndSendingOffRoundTrip.setGroup(getShortStayStandardRecuperationMeetingAndSendingOff());

      shortStayStandardRecuperationMeetingAndSendingOffRoundTrip.setConstraints(VRLayout.FLOW);

      addShortStayStandardRecuperationMeetingAndSendingOffRoundTrip();
    }
    return shortStayStandardRecuperationMeetingAndSendingOffRoundTrip;

  }

  /**
   * �h�{�Ǘ��̐����Z���擾���܂��B
   * @return �h�{�Ǘ��̐����Z
   */
  public ACClearableRadioButtonGroup getShortStayStandardRecuperationDieticianManageRadio(){
    if(shortStayStandardRecuperationDieticianManageRadio==null){

      shortStayStandardRecuperationDieticianManageRadio = new ACClearableRadioButtonGroup();

      getShortStayStandardRecuperationDieticianManageRadioContainer().setText("�h�{�Ǘ��̐����Z");

      shortStayStandardRecuperationDieticianManageRadio.setBindPath("1260402");

      shortStayStandardRecuperationDieticianManageRadio.setUseClearButton(false);

      shortStayStandardRecuperationDieticianManageRadio.setModel(getShortStayStandardRecuperationDieticianManageRadioModel());

      addShortStayStandardRecuperationDieticianManageRadio();
    }
    return shortStayStandardRecuperationDieticianManageRadio;

  }

  /**
   * �h�{�Ǘ��̐����Z�R���e�i���擾���܂��B
   * @return �h�{�Ǘ��̐����Z�R���e�i
   */
  protected ACLabelContainer getShortStayStandardRecuperationDieticianManageRadioContainer(){
    if(shortStayStandardRecuperationDieticianManageRadioContainer==null){
      shortStayStandardRecuperationDieticianManageRadioContainer = new ACLabelContainer();
      shortStayStandardRecuperationDieticianManageRadioContainer.setFollowChildEnabled(true);
      shortStayStandardRecuperationDieticianManageRadioContainer.setVAlignment(VRLayout.CENTER);
      shortStayStandardRecuperationDieticianManageRadioContainer.add(getShortStayStandardRecuperationDieticianManageRadio(), null);
    }
    return shortStayStandardRecuperationDieticianManageRadioContainer;
  }

  /**
   * �h�{�Ǘ��̐����Z���f�����擾���܂��B
   * @return �h�{�Ǘ��̐����Z���f��
   */
  protected ACListModelAdapter getShortStayStandardRecuperationDieticianManageRadioModel(){
    if(shortStayStandardRecuperationDieticianManageRadioModel==null){
      shortStayStandardRecuperationDieticianManageRadioModel = new ACListModelAdapter();
      addShortStayStandardRecuperationDieticianManageRadioModel();
    }
    return shortStayStandardRecuperationDieticianManageRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getShortStayStandardRecuperationDieticianManageRadioItem1(){
    if(shortStayStandardRecuperationDieticianManageRadioItem1==null){

      shortStayStandardRecuperationDieticianManageRadioItem1 = new ACRadioButtonItem();

      shortStayStandardRecuperationDieticianManageRadioItem1.setText("�Ȃ�");

      shortStayStandardRecuperationDieticianManageRadioItem1.setGroup(getShortStayStandardRecuperationDieticianManageRadio());

      shortStayStandardRecuperationDieticianManageRadioItem1.setConstraints(VRLayout.FLOW);

      addShortStayStandardRecuperationDieticianManageRadioItem1();
    }
    return shortStayStandardRecuperationDieticianManageRadioItem1;

  }

  /**
   * �Ǘ��h�{�m���擾���܂��B
   * @return �Ǘ��h�{�m
   */
  public ACRadioButtonItem getShortStayStandardRecuperationDieticianManageRadioItem2(){
    if(shortStayStandardRecuperationDieticianManageRadioItem2==null){

      shortStayStandardRecuperationDieticianManageRadioItem2 = new ACRadioButtonItem();

      shortStayStandardRecuperationDieticianManageRadioItem2.setText("�Ǘ��h�{�m");

      shortStayStandardRecuperationDieticianManageRadioItem2.setGroup(getShortStayStandardRecuperationDieticianManageRadio());

      shortStayStandardRecuperationDieticianManageRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

      addShortStayStandardRecuperationDieticianManageRadioItem2();
    }
    return shortStayStandardRecuperationDieticianManageRadioItem2;

  }

  /**
   * �h�{�m���擾���܂��B
   * @return �h�{�m
   */
  public ACRadioButtonItem getShortStayStandardRecuperationDieticianManageRadioItem3(){
    if(shortStayStandardRecuperationDieticianManageRadioItem3==null){

      shortStayStandardRecuperationDieticianManageRadioItem3 = new ACRadioButtonItem();

      shortStayStandardRecuperationDieticianManageRadioItem3.setText("�h�{�m");

      shortStayStandardRecuperationDieticianManageRadioItem3.setGroup(getShortStayStandardRecuperationDieticianManageRadio());

      shortStayStandardRecuperationDieticianManageRadioItem3.setConstraints(VRLayout.FLOW);

      addShortStayStandardRecuperationDieticianManageRadioItem3();
    }
    return shortStayStandardRecuperationDieticianManageRadioItem3;

  }

  /**
   * �×{�H���Z���擾���܂��B
   * @return �×{�H���Z
   */
  public ACClearableRadioButtonGroup getShortStayStandardRecuperationMedicalExpensesRadio(){
    if(shortStayStandardRecuperationMedicalExpensesRadio==null){

      shortStayStandardRecuperationMedicalExpensesRadio = new ACClearableRadioButtonGroup();

      getShortStayStandardRecuperationMedicalExpensesRadioContainer().setText("�×{�H���Z");

      shortStayStandardRecuperationMedicalExpensesRadio.setBindPath("1260403");

      shortStayStandardRecuperationMedicalExpensesRadio.setUseClearButton(false);

      shortStayStandardRecuperationMedicalExpensesRadio.setModel(getShortStayStandardRecuperationMedicalExpensesRadioModel());

      addShortStayStandardRecuperationMedicalExpensesRadio();
    }
    return shortStayStandardRecuperationMedicalExpensesRadio;

  }

  /**
   * �×{�H���Z�R���e�i���擾���܂��B
   * @return �×{�H���Z�R���e�i
   */
  protected ACLabelContainer getShortStayStandardRecuperationMedicalExpensesRadioContainer(){
    if(shortStayStandardRecuperationMedicalExpensesRadioContainer==null){
      shortStayStandardRecuperationMedicalExpensesRadioContainer = new ACLabelContainer();
      shortStayStandardRecuperationMedicalExpensesRadioContainer.setFollowChildEnabled(true);
      shortStayStandardRecuperationMedicalExpensesRadioContainer.setVAlignment(VRLayout.CENTER);
      shortStayStandardRecuperationMedicalExpensesRadioContainer.add(getShortStayStandardRecuperationMedicalExpensesRadio(), null);
    }
    return shortStayStandardRecuperationMedicalExpensesRadioContainer;
  }

  /**
   * �×{�H���Z���f�����擾���܂��B
   * @return �×{�H���Z���f��
   */
  protected ACListModelAdapter getShortStayStandardRecuperationMedicalExpensesRadioModel(){
    if(shortStayStandardRecuperationMedicalExpensesRadioModel==null){
      shortStayStandardRecuperationMedicalExpensesRadioModel = new ACListModelAdapter();
      addShortStayStandardRecuperationMedicalExpensesRadioModel();
    }
    return shortStayStandardRecuperationMedicalExpensesRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getShortStayStandardRecuperationMedicalExpensesRadioItem1(){
    if(shortStayStandardRecuperationMedicalExpensesRadioItem1==null){

      shortStayStandardRecuperationMedicalExpensesRadioItem1 = new ACRadioButtonItem();

      shortStayStandardRecuperationMedicalExpensesRadioItem1.setText("�Ȃ�");

      shortStayStandardRecuperationMedicalExpensesRadioItem1.setGroup(getShortStayStandardRecuperationMedicalExpensesRadio());

      shortStayStandardRecuperationMedicalExpensesRadioItem1.setConstraints(VRLayout.FLOW);

      addShortStayStandardRecuperationMedicalExpensesRadioItem1();
    }
    return shortStayStandardRecuperationMedicalExpensesRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getShortStayStandardRecuperationMedicalExpensesRadioItem2(){
    if(shortStayStandardRecuperationMedicalExpensesRadioItem2==null){

      shortStayStandardRecuperationMedicalExpensesRadioItem2 = new ACRadioButtonItem();

      shortStayStandardRecuperationMedicalExpensesRadioItem2.setText("����");

      shortStayStandardRecuperationMedicalExpensesRadioItem2.setGroup(getShortStayStandardRecuperationMedicalExpensesRadio());

      shortStayStandardRecuperationMedicalExpensesRadioItem2.setConstraints(VRLayout.FLOW);

      addShortStayStandardRecuperationMedicalExpensesRadioItem2();
    }
    return shortStayStandardRecuperationMedicalExpensesRadioItem2;

  }

  /**
   * �l�����Z���擾���܂��B
   * @return �l�����Z
   */
  public ACClearableRadioButtonGroup getShortStayStandardRecuperationEtcShiftSubtractionRadio(){
    if(shortStayStandardRecuperationEtcShiftSubtractionRadio==null){

      shortStayStandardRecuperationEtcShiftSubtractionRadio = new ACClearableRadioButtonGroup();

      getShortStayStandardRecuperationEtcShiftSubtractionRadioContainer().setText("�l�����Z");

      shortStayStandardRecuperationEtcShiftSubtractionRadio.setBindPath("1260404");

      shortStayStandardRecuperationEtcShiftSubtractionRadio.setUseClearButton(false);

      shortStayStandardRecuperationEtcShiftSubtractionRadio.setModel(getShortStayStandardRecuperationEtcShiftSubtractionRadioModel());

      addShortStayStandardRecuperationEtcShiftSubtractionRadio();
    }
    return shortStayStandardRecuperationEtcShiftSubtractionRadio;

  }

  /**
   * �l�����Z�R���e�i���擾���܂��B
   * @return �l�����Z�R���e�i
   */
  protected ACLabelContainer getShortStayStandardRecuperationEtcShiftSubtractionRadioContainer(){
    if(shortStayStandardRecuperationEtcShiftSubtractionRadioContainer==null){
      shortStayStandardRecuperationEtcShiftSubtractionRadioContainer = new ACLabelContainer();
      shortStayStandardRecuperationEtcShiftSubtractionRadioContainer.setFollowChildEnabled(true);
      shortStayStandardRecuperationEtcShiftSubtractionRadioContainer.setVAlignment(VRLayout.CENTER);
      shortStayStandardRecuperationEtcShiftSubtractionRadioContainer.add(getShortStayStandardRecuperationEtcShiftSubtractionRadio(), null);
    }
    return shortStayStandardRecuperationEtcShiftSubtractionRadioContainer;
  }

  /**
   * �l�����Z���f�����擾���܂��B
   * @return �l�����Z���f��
   */
  protected ACListModelAdapter getShortStayStandardRecuperationEtcShiftSubtractionRadioModel(){
    if(shortStayStandardRecuperationEtcShiftSubtractionRadioModel==null){
      shortStayStandardRecuperationEtcShiftSubtractionRadioModel = new ACListModelAdapter();
      addShortStayStandardRecuperationEtcShiftSubtractionRadioModel();
    }
    return shortStayStandardRecuperationEtcShiftSubtractionRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getShortStayStandardRecuperationEtcShiftSubtractionRadioItem1(){
    if(shortStayStandardRecuperationEtcShiftSubtractionRadioItem1==null){

      shortStayStandardRecuperationEtcShiftSubtractionRadioItem1 = new ACRadioButtonItem();

      shortStayStandardRecuperationEtcShiftSubtractionRadioItem1.setText("�Ȃ�");

      shortStayStandardRecuperationEtcShiftSubtractionRadioItem1.setGroup(getShortStayStandardRecuperationEtcShiftSubtractionRadio());

      shortStayStandardRecuperationEtcShiftSubtractionRadioItem1.setConstraints(VRLayout.FLOW);

      addShortStayStandardRecuperationEtcShiftSubtractionRadioItem1();
    }
    return shortStayStandardRecuperationEtcShiftSubtractionRadioItem1;

  }

  /**
   * ������߂��擾���܂��B
   * @return �������
   */
  public ACRadioButtonItem getShortStayStandardRecuperationEtcShiftSubtractionRadioItem2(){
    if(shortStayStandardRecuperationEtcShiftSubtractionRadioItem2==null){

      shortStayStandardRecuperationEtcShiftSubtractionRadioItem2 = new ACRadioButtonItem();

      shortStayStandardRecuperationEtcShiftSubtractionRadioItem2.setText("�������");

      shortStayStandardRecuperationEtcShiftSubtractionRadioItem2.setGroup(getShortStayStandardRecuperationEtcShiftSubtractionRadio());

      shortStayStandardRecuperationEtcShiftSubtractionRadioItem2.setConstraints(VRLayout.FLOW);

      addShortStayStandardRecuperationEtcShiftSubtractionRadioItem2();
    }
    return shortStayStandardRecuperationEtcShiftSubtractionRadioItem2;

  }

  /**
   * �H���R���e�i���擾���܂��B
   * @return �H���R���e�i
   */
  public ACBackLabelContainer getShortStayStandardRecuperationDinnerContainer(){
    if(shortStayStandardRecuperationDinnerContainer==null){

      shortStayStandardRecuperationDinnerContainer = new ACBackLabelContainer();

      addShortStayStandardRecuperationDinnerContainer();
    }
    return shortStayStandardRecuperationDinnerContainer;

  }

  /**
   * �H���񋟂��擾���܂��B
   * @return �H����
   */
  public ACComboBox getShortStayStandardRecuperationDinnerOffer(){
    if(shortStayStandardRecuperationDinnerOffer==null){

      shortStayStandardRecuperationDinnerOffer = new ACComboBox();

      getShortStayStandardRecuperationDinnerOfferContainer().setText("�H����");

      shortStayStandardRecuperationDinnerOffer.setBindPath("1260405");

      shortStayStandardRecuperationDinnerOffer.setEditable(false);

      shortStayStandardRecuperationDinnerOffer.setModelBindPath("1260405");

      shortStayStandardRecuperationDinnerOffer.setRenderBindPath("CONTENT");

      shortStayStandardRecuperationDinnerOffer.setModel(getShortStayStandardRecuperationDinnerOfferModel());

      addShortStayStandardRecuperationDinnerOffer();
    }
    return shortStayStandardRecuperationDinnerOffer;

  }

  /**
   * �H���񋟃R���e�i���擾���܂��B
   * @return �H���񋟃R���e�i
   */
  protected ACLabelContainer getShortStayStandardRecuperationDinnerOfferContainer(){
    if(shortStayStandardRecuperationDinnerOfferContainer==null){
      shortStayStandardRecuperationDinnerOfferContainer = new ACLabelContainer();
      shortStayStandardRecuperationDinnerOfferContainer.setFollowChildEnabled(true);
      shortStayStandardRecuperationDinnerOfferContainer.setVAlignment(VRLayout.CENTER);
      shortStayStandardRecuperationDinnerOfferContainer.add(getShortStayStandardRecuperationDinnerOffer(), null);
    }
    return shortStayStandardRecuperationDinnerOfferContainer;
  }

  /**
   * �H���񋟃��f�����擾���܂��B
   * @return �H���񋟃��f��
   */
  protected ACComboBoxModelAdapter getShortStayStandardRecuperationDinnerOfferModel(){
    if(shortStayStandardRecuperationDinnerOfferModel==null){
      shortStayStandardRecuperationDinnerOfferModel = new ACComboBoxModelAdapter();
      addShortStayStandardRecuperationDinnerOfferModel();
    }
    return shortStayStandardRecuperationDinnerOfferModel;
  }

  /**
   * �H����p���擾���܂��B
   * @return �H����p
   */
  public ACTextField getShortStayStandardRecuperationDinnerCost(){
    if(shortStayStandardRecuperationDinnerCost==null){

      shortStayStandardRecuperationDinnerCost = new ACTextField();

      getShortStayStandardRecuperationDinnerCostContainer().setText("�H����p");

      shortStayStandardRecuperationDinnerCost.setBindPath("1260406");

      shortStayStandardRecuperationDinnerCost.setColumns(4);

      shortStayStandardRecuperationDinnerCost.setCharType(VRCharType.ONLY_DIGIT);

      shortStayStandardRecuperationDinnerCost.setHorizontalAlignment(SwingConstants.RIGHT);

      shortStayStandardRecuperationDinnerCost.setIMEMode(InputSubset.LATIN);

      shortStayStandardRecuperationDinnerCost.setMaxLength(5);

      addShortStayStandardRecuperationDinnerCost();
    }
    return shortStayStandardRecuperationDinnerCost;

  }

  /**
   * �H����p�R���e�i���擾���܂��B
   * @return �H����p�R���e�i
   */
  protected ACLabelContainer getShortStayStandardRecuperationDinnerCostContainer(){
    if(shortStayStandardRecuperationDinnerCostContainer==null){
      shortStayStandardRecuperationDinnerCostContainer = new ACLabelContainer();
      shortStayStandardRecuperationDinnerCostContainer.setFollowChildEnabled(true);
      shortStayStandardRecuperationDinnerCostContainer.setVAlignment(VRLayout.CENTER);
      shortStayStandardRecuperationDinnerCostContainer.add(getShortStayStandardRecuperationDinnerCost(), null);
    }
    return shortStayStandardRecuperationDinnerCostContainer;
  }

  /**
   * 30�������擾���܂��B
   * @return 30����
   */
  public ACIntegerCheckBox getShortStayStandardRecuperationEtc30Over(){
    if(shortStayStandardRecuperationEtc30Over==null){

      shortStayStandardRecuperationEtc30Over = new ACIntegerCheckBox();

      shortStayStandardRecuperationEtc30Over.setText("30����");

      shortStayStandardRecuperationEtc30Over.setBindPath("5");

      shortStayStandardRecuperationEtc30Over.setSelectValue(2);

      shortStayStandardRecuperationEtc30Over.setUnSelectValue(1);

      addShortStayStandardRecuperationEtc30Over();
    }
    return shortStayStandardRecuperationEtc30Over;

  }

  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001142Design() {

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

    this.add(getShortStayStandardRecuperationPatterns(), VRLayout.CLIENT);

  }

  /**
   * �Z�������×{���i��K���f�Ï��j�p�^�[���̈�j�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayStandardRecuperationPatterns(){

    shortStayStandardRecuperationPatterns.add(getShortStayStandardRecuperationHospitalRoomDivisionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayStandardRecuperationPatterns.add(getShortStayStandardRecuperationMeetingAndSendingOffContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayStandardRecuperationPatterns.add(getShortStayStandardRecuperationDieticianManageRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayStandardRecuperationPatterns.add(getShortStayStandardRecuperationMedicalExpensesRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayStandardRecuperationPatterns.add(getShortStayStandardRecuperationEtcShiftSubtractionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayStandardRecuperationPatterns.add(getShortStayStandardRecuperationDinnerContainer(), VRLayout.FLOW_DOUBLEINSETLINE_RETURN);

    shortStayStandardRecuperationPatterns.add(getShortStayStandardRecuperationEtc30Over(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * �a���敪�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayStandardRecuperationHospitalRoomDivisionRadio(){

  }

  /**
   * �a���敪���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayStandardRecuperationHospitalRoomDivisionRadioModel(){

    getShortStayStandardRecuperationHospitalRoomDivisionRadioItem1().setButtonIndex(1);
    getShortStayStandardRecuperationHospitalRoomDivisionRadioModel().add(getShortStayStandardRecuperationHospitalRoomDivisionRadioItem1());

    getShortStayStandardRecuperationHospitalRoomDivisionRadioItem2().setButtonIndex(2);
    getShortStayStandardRecuperationHospitalRoomDivisionRadioModel().add(getShortStayStandardRecuperationHospitalRoomDivisionRadioItem2());

  }

  /**
   * �]���^���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayStandardRecuperationHospitalRoomDivisionRadioItem1(){

  }

  /**
   * �������ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayStandardRecuperationHospitalRoomDivisionRadioItem2(){

  }

  /**
   * ���}�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayStandardRecuperationMeetingAndSendingOff(){

  }

  /**
   * ���}���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayStandardRecuperationMeetingAndSendingOffModel(){

    getShortStayStandardRecuperationMeetingAndSendingOffNone().setButtonIndex(1);
    getShortStayStandardRecuperationMeetingAndSendingOffModel().add(getShortStayStandardRecuperationMeetingAndSendingOffNone());

    getShortStayStandardRecuperationMeetingAndSendingOffOneWay().setButtonIndex(2);
    getShortStayStandardRecuperationMeetingAndSendingOffModel().add(getShortStayStandardRecuperationMeetingAndSendingOffOneWay());

    getShortStayStandardRecuperationMeetingAndSendingOffRoundTrip().setButtonIndex(3);
    getShortStayStandardRecuperationMeetingAndSendingOffModel().add(getShortStayStandardRecuperationMeetingAndSendingOffRoundTrip());

  }

  /**
   * ���}�Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayStandardRecuperationMeetingAndSendingOffNone(){

  }

  /**
   * ���}�Г��ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayStandardRecuperationMeetingAndSendingOffOneWay(){

  }

  /**
   * ���}�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayStandardRecuperationMeetingAndSendingOffRoundTrip(){

  }

  /**
   * �h�{�Ǘ��̐����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayStandardRecuperationDieticianManageRadio(){

  }

  /**
   * �h�{�Ǘ��̐����Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayStandardRecuperationDieticianManageRadioModel(){

    getShortStayStandardRecuperationDieticianManageRadioItem1().setButtonIndex(1);
    getShortStayStandardRecuperationDieticianManageRadioModel().add(getShortStayStandardRecuperationDieticianManageRadioItem1());

    getShortStayStandardRecuperationDieticianManageRadioItem2().setButtonIndex(2);
    getShortStayStandardRecuperationDieticianManageRadioModel().add(getShortStayStandardRecuperationDieticianManageRadioItem2());

    getShortStayStandardRecuperationDieticianManageRadioItem3().setButtonIndex(3);
    getShortStayStandardRecuperationDieticianManageRadioModel().add(getShortStayStandardRecuperationDieticianManageRadioItem3());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayStandardRecuperationDieticianManageRadioItem1(){

  }

  /**
   * �Ǘ��h�{�m�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayStandardRecuperationDieticianManageRadioItem2(){

  }

  /**
   * �h�{�m�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayStandardRecuperationDieticianManageRadioItem3(){

  }

  /**
   * �×{�H���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayStandardRecuperationMedicalExpensesRadio(){

  }

  /**
   * �×{�H���Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayStandardRecuperationMedicalExpensesRadioModel(){

    getShortStayStandardRecuperationMedicalExpensesRadioItem1().setButtonIndex(1);
    getShortStayStandardRecuperationMedicalExpensesRadioModel().add(getShortStayStandardRecuperationMedicalExpensesRadioItem1());

    getShortStayStandardRecuperationMedicalExpensesRadioItem2().setButtonIndex(2);
    getShortStayStandardRecuperationMedicalExpensesRadioModel().add(getShortStayStandardRecuperationMedicalExpensesRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayStandardRecuperationMedicalExpensesRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayStandardRecuperationMedicalExpensesRadioItem2(){

  }

  /**
   * �l�����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayStandardRecuperationEtcShiftSubtractionRadio(){

  }

  /**
   * �l�����Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayStandardRecuperationEtcShiftSubtractionRadioModel(){

    getShortStayStandardRecuperationEtcShiftSubtractionRadioItem1().setButtonIndex(1);
    getShortStayStandardRecuperationEtcShiftSubtractionRadioModel().add(getShortStayStandardRecuperationEtcShiftSubtractionRadioItem1());

    getShortStayStandardRecuperationEtcShiftSubtractionRadioItem2().setButtonIndex(2);
    getShortStayStandardRecuperationEtcShiftSubtractionRadioModel().add(getShortStayStandardRecuperationEtcShiftSubtractionRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayStandardRecuperationEtcShiftSubtractionRadioItem1(){

  }

  /**
   * ������߂ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayStandardRecuperationEtcShiftSubtractionRadioItem2(){

  }

  /**
   * �H���R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayStandardRecuperationDinnerContainer(){

    shortStayStandardRecuperationDinnerContainer.add(getShortStayStandardRecuperationDinnerOfferContainer(), VRLayout.FLOW);

    shortStayStandardRecuperationDinnerContainer.add(getShortStayStandardRecuperationDinnerCostContainer(), VRLayout.FLOW);

  }

  /**
   * �H���񋟂ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayStandardRecuperationDinnerOffer(){

  }

  /**
   * �H���񋟃��f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayStandardRecuperationDinnerOfferModel(){

  }

  /**
   * �H����p�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayStandardRecuperationDinnerCost(){

  }

  /**
   * 30�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayStandardRecuperationEtc30Over(){

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
      ACFrame.debugStart(new ACAffairInfo(QS001142Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QS001142Design getThis() {
    return this;
  }
}
