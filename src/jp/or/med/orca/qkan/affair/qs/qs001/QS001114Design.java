
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
 * �v���O���� �T�[�r�X�p�^�[���Z�������×{���i��K���f�Ï��j (QS001114)
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
 * �T�[�r�X�p�^�[���Z�������×{���i��K���f�Ï��j��ʍ��ڃf�U�C��(QS001114) 
 */
public class QS001114Design extends QS001ServicePanel {
  //GUI�R���|�[�l���g

  private ACPanel shortStayStandardRecuperationPatterns;

  private ACClearableRadioButtonGroup shortStayStandardRecuperationProviderDivision;

  private ACLabelContainer shortStayStandardRecuperationProviderDivisionContainer;

  private ACListModelAdapter shortStayStandardRecuperationProviderDivisionModel;

  private ACRadioButtonItem shortStayStandardRecuperationProviderDivisionItem1;

  private ACRadioButtonItem shortStayStandardRecuperationProviderDivisionItem2;

  private ACClearableRadioButtonGroup shortStayStandardRecuperationHospitalRoomDivisionRadio;

  private ACLabelContainer shortStayStandardRecuperationHospitalRoomDivisionRadioContainer;

  private ACListModelAdapter shortStayStandardRecuperationHospitalRoomDivisionRadioModel;

  private ACRadioButtonItem shortStayStandardRecuperationHospitalRoomDivisionRadioItem1;

  private ACRadioButtonItem shortStayStandardRecuperationHospitalRoomDivisionRadioItem2;

  private ACClearableRadioButtonGroup shortStayStandardRecuperationSickroomDivisionRadio;

  private ACLabelContainer shortStayStandardRecuperationSickroomDivisionRadioContainer;

  private ACListModelAdapter shortStayStandardRecuperationSickroomDivisionRadioModel;

  private ACRadioButtonItem shortStayStandardRecuperationSickroomDivisionRadioItem1;

  private ACRadioButtonItem shortStayStandardRecuperationSickroomDivisionRadioItem2;

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
   * �{�ݓ��̋敪���擾���܂��B
   * @return �{�ݓ��̋敪
   */
  public ACClearableRadioButtonGroup getShortStayStandardRecuperationProviderDivision(){
    if(shortStayStandardRecuperationProviderDivision==null){

      shortStayStandardRecuperationProviderDivision = new ACClearableRadioButtonGroup();

      getShortStayStandardRecuperationProviderDivisionContainer().setText("�{�ݓ��̋敪");

      shortStayStandardRecuperationProviderDivision.setBindPath("1230410");

      shortStayStandardRecuperationProviderDivision.setUseClearButton(false);

      shortStayStandardRecuperationProviderDivision.setModel(getShortStayStandardRecuperationProviderDivisionModel());

      addShortStayStandardRecuperationProviderDivision();
    }
    return shortStayStandardRecuperationProviderDivision;

  }

  /**
   * �{�ݓ��̋敪�R���e�i���擾���܂��B
   * @return �{�ݓ��̋敪�R���e�i
   */
  protected ACLabelContainer getShortStayStandardRecuperationProviderDivisionContainer(){
    if(shortStayStandardRecuperationProviderDivisionContainer==null){
      shortStayStandardRecuperationProviderDivisionContainer = new ACLabelContainer();
      shortStayStandardRecuperationProviderDivisionContainer.setFollowChildEnabled(true);
      shortStayStandardRecuperationProviderDivisionContainer.setVAlignment(VRLayout.CENTER);
      shortStayStandardRecuperationProviderDivisionContainer.add(getShortStayStandardRecuperationProviderDivision(), null);
    }
    return shortStayStandardRecuperationProviderDivisionContainer;
  }

  /**
   * �{�ݓ��̋敪���f�����擾���܂��B
   * @return �{�ݓ��̋敪���f��
   */
  protected ACListModelAdapter getShortStayStandardRecuperationProviderDivisionModel(){
    if(shortStayStandardRecuperationProviderDivisionModel==null){
      shortStayStandardRecuperationProviderDivisionModel = new ACListModelAdapter();
      addShortStayStandardRecuperationProviderDivisionModel();
    }
    return shortStayStandardRecuperationProviderDivisionModel;
  }

  /**
   * ��K���f�Ï����擾���܂��B
   * @return ��K���f�Ï�
   */
  public ACRadioButtonItem getShortStayStandardRecuperationProviderDivisionItem1(){
    if(shortStayStandardRecuperationProviderDivisionItem1==null){

      shortStayStandardRecuperationProviderDivisionItem1 = new ACRadioButtonItem();

      shortStayStandardRecuperationProviderDivisionItem1.setText("��K���f�Ï�");

      shortStayStandardRecuperationProviderDivisionItem1.setGroup(getShortStayStandardRecuperationProviderDivision());

      shortStayStandardRecuperationProviderDivisionItem1.setConstraints(VRLayout.FLOW_RETURN);

      addShortStayStandardRecuperationProviderDivisionItem1();
    }
    return shortStayStandardRecuperationProviderDivisionItem1;

  }

  /**
   * ���A��V���[�g�X�e�C���擾���܂��B
   * @return ���A��V���[�g�X�e�C
   */
  public ACRadioButtonItem getShortStayStandardRecuperationProviderDivisionItem2(){
    if(shortStayStandardRecuperationProviderDivisionItem2==null){

      shortStayStandardRecuperationProviderDivisionItem2 = new ACRadioButtonItem();

      shortStayStandardRecuperationProviderDivisionItem2.setText("���A��V���[�g�X�e�C");

      shortStayStandardRecuperationProviderDivisionItem2.setGroup(getShortStayStandardRecuperationProviderDivision());

      shortStayStandardRecuperationProviderDivisionItem2.setConstraints(VRLayout.FLOW);

      addShortStayStandardRecuperationProviderDivisionItem2();
    }
    return shortStayStandardRecuperationProviderDivisionItem2;

  }

  /**
   * �a���敪���擾���܂��B
   * @return �a���敪
   */
  public ACClearableRadioButtonGroup getShortStayStandardRecuperationHospitalRoomDivisionRadio(){
    if(shortStayStandardRecuperationHospitalRoomDivisionRadio==null){

      shortStayStandardRecuperationHospitalRoomDivisionRadio = new ACClearableRadioButtonGroup();

      getShortStayStandardRecuperationHospitalRoomDivisionRadioContainer().setText("�a���敪");

      shortStayStandardRecuperationHospitalRoomDivisionRadio.setBindPath("1230401");

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
   * �a���敪���W�I���擾���܂��B
   * @return �a���敪���W�I
   */
  public ACClearableRadioButtonGroup getShortStayStandardRecuperationSickroomDivisionRadio(){
    if(shortStayStandardRecuperationSickroomDivisionRadio==null){

      shortStayStandardRecuperationSickroomDivisionRadio = new ACClearableRadioButtonGroup();

      getShortStayStandardRecuperationSickroomDivisionRadioContainer().setText("�a���敪");

      shortStayStandardRecuperationSickroomDivisionRadio.setBindPath("1230411");

      shortStayStandardRecuperationSickroomDivisionRadio.setUseClearButton(false);

      shortStayStandardRecuperationSickroomDivisionRadio.setModel(getShortStayStandardRecuperationSickroomDivisionRadioModel());

      addShortStayStandardRecuperationSickroomDivisionRadio();
    }
    return shortStayStandardRecuperationSickroomDivisionRadio;

  }

  /**
   * �a���敪���W�I�R���e�i���擾���܂��B
   * @return �a���敪���W�I�R���e�i
   */
  protected ACLabelContainer getShortStayStandardRecuperationSickroomDivisionRadioContainer(){
    if(shortStayStandardRecuperationSickroomDivisionRadioContainer==null){
      shortStayStandardRecuperationSickroomDivisionRadioContainer = new ACLabelContainer();
      shortStayStandardRecuperationSickroomDivisionRadioContainer.setFollowChildEnabled(true);
      shortStayStandardRecuperationSickroomDivisionRadioContainer.setVAlignment(VRLayout.CENTER);
      shortStayStandardRecuperationSickroomDivisionRadioContainer.add(getShortStayStandardRecuperationSickroomDivisionRadio(), null);
    }
    return shortStayStandardRecuperationSickroomDivisionRadioContainer;
  }

  /**
   * �a���敪���W�I���f�����擾���܂��B
   * @return �a���敪���W�I���f��
   */
  protected ACListModelAdapter getShortStayStandardRecuperationSickroomDivisionRadioModel(){
    if(shortStayStandardRecuperationSickroomDivisionRadioModel==null){
      shortStayStandardRecuperationSickroomDivisionRadioModel = new ACListModelAdapter();
      addShortStayStandardRecuperationSickroomDivisionRadioModel();
    }
    return shortStayStandardRecuperationSickroomDivisionRadioModel;
  }

  /**
   * �]���^�����擾���܂��B
   * @return �]���^��
   */
  public ACRadioButtonItem getShortStayStandardRecuperationSickroomDivisionRadioItem1(){
    if(shortStayStandardRecuperationSickroomDivisionRadioItem1==null){

      shortStayStandardRecuperationSickroomDivisionRadioItem1 = new ACRadioButtonItem();

      shortStayStandardRecuperationSickroomDivisionRadioItem1.setText("�]���^��");

      shortStayStandardRecuperationSickroomDivisionRadioItem1.setGroup(getShortStayStandardRecuperationSickroomDivisionRadio());

      shortStayStandardRecuperationSickroomDivisionRadioItem1.setConstraints(VRLayout.FLOW);

      addShortStayStandardRecuperationSickroomDivisionRadioItem1();
    }
    return shortStayStandardRecuperationSickroomDivisionRadioItem1;

  }

  /**
   * ���������擾���܂��B
   * @return ������
   */
  public ACRadioButtonItem getShortStayStandardRecuperationSickroomDivisionRadioItem2(){
    if(shortStayStandardRecuperationSickroomDivisionRadioItem2==null){

      shortStayStandardRecuperationSickroomDivisionRadioItem2 = new ACRadioButtonItem();

      shortStayStandardRecuperationSickroomDivisionRadioItem2.setText("������");

      shortStayStandardRecuperationSickroomDivisionRadioItem2.setGroup(getShortStayStandardRecuperationSickroomDivisionRadio());

      shortStayStandardRecuperationSickroomDivisionRadioItem2.setConstraints(VRLayout.FLOW);

      addShortStayStandardRecuperationSickroomDivisionRadioItem2();
    }
    return shortStayStandardRecuperationSickroomDivisionRadioItem2;

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

      shortStayStandardRecuperationDieticianManageRadio.setBindPath("1230403");

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

      shortStayStandardRecuperationMedicalExpensesRadio.setBindPath("1230404");

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

      shortStayStandardRecuperationEtcShiftSubtractionRadio.setBindPath("1230405");

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

      shortStayStandardRecuperationDinnerOffer.setBindPath("1230406");

      shortStayStandardRecuperationDinnerOffer.setEditable(false);

      shortStayStandardRecuperationDinnerOffer.setModelBindPath("1230406");

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

      shortStayStandardRecuperationDinnerCost.setBindPath("1230409");

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
  public QS001114Design() {

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

    shortStayStandardRecuperationPatterns.add(getShortStayStandardRecuperationProviderDivisionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayStandardRecuperationPatterns.add(getShortStayStandardRecuperationHospitalRoomDivisionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayStandardRecuperationPatterns.add(getShortStayStandardRecuperationSickroomDivisionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayStandardRecuperationPatterns.add(getShortStayStandardRecuperationMeetingAndSendingOffContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayStandardRecuperationPatterns.add(getShortStayStandardRecuperationDieticianManageRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayStandardRecuperationPatterns.add(getShortStayStandardRecuperationMedicalExpensesRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayStandardRecuperationPatterns.add(getShortStayStandardRecuperationEtcShiftSubtractionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayStandardRecuperationPatterns.add(getShortStayStandardRecuperationDinnerContainer(), VRLayout.FLOW_DOUBLEINSETLINE_RETURN);

    shortStayStandardRecuperationPatterns.add(getShortStayStandardRecuperationEtc30Over(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * �{�ݓ��̋敪�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayStandardRecuperationProviderDivision(){

  }

  /**
   * �{�ݓ��̋敪���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayStandardRecuperationProviderDivisionModel(){

    getShortStayStandardRecuperationProviderDivisionItem1().setButtonIndex(1);
    getShortStayStandardRecuperationProviderDivisionModel().add(getShortStayStandardRecuperationProviderDivisionItem1());

    getShortStayStandardRecuperationProviderDivisionItem2().setButtonIndex(2);
    getShortStayStandardRecuperationProviderDivisionModel().add(getShortStayStandardRecuperationProviderDivisionItem2());

  }

  /**
   * ��K���f�Ï��ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayStandardRecuperationProviderDivisionItem1(){

  }

  /**
   * ���A��V���[�g�X�e�C�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayStandardRecuperationProviderDivisionItem2(){

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
   * �a���敪���W�I�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayStandardRecuperationSickroomDivisionRadio(){

  }

  /**
   * �a���敪���W�I���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayStandardRecuperationSickroomDivisionRadioModel(){

    getShortStayStandardRecuperationSickroomDivisionRadioItem1().setButtonIndex(1);
    getShortStayStandardRecuperationSickroomDivisionRadioModel().add(getShortStayStandardRecuperationSickroomDivisionRadioItem1());

    getShortStayStandardRecuperationSickroomDivisionRadioItem2().setButtonIndex(2);
    getShortStayStandardRecuperationSickroomDivisionRadioModel().add(getShortStayStandardRecuperationSickroomDivisionRadioItem2());

  }

  /**
   * �]���^���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayStandardRecuperationSickroomDivisionRadioItem1(){

  }

  /**
   * �������ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayStandardRecuperationSickroomDivisionRadioItem2(){

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
      ACFrame.setVRLookAndFeel();
      ACFrame.getInstance().setFrameEventProcesser(new QkanFrameEventProcesser());
      ACFrame.debugStart(new ACAffairInfo(QS001114Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QS001114Design getThis() {
    return this;
  }
}
