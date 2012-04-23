
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
 * �쐬��: 2012/03/26  ���{�R���s���[�^�[������� ����@��F �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �T�[�r�X�\��쐬/�ύX (S)
 * �v���Z�X �T�[�r�X�\��T�� (001)
 * �v���O���� �T�[�r�X�p�^�[��������x�� (QS001_14311_201204)
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
 * �T�[�r�X�p�^�[��������x����ʍ��ڃf�U�C��(QS001_14311_201204) 
 */
public class QS001_14311_201204Design extends QS001ServicePanel {
  //GUI�R���|�[�l���g

  private ACPanel kaigoSupportPattern;

  private JTabbedPane tabs;

  private ACPanel tab1;

  private ACValueArrayRadioButtonGroup kaigoSupportDivisionRadio;

  private ACLabelContainer kaigoSupportDivisionRadioContainer;

  private ACListModelAdapter kaigoSupportDivisionRadioModel;

  private ACRadioButtonItem kaigoSupportDivisionRadioItem1;

  private ACRadioButtonItem kaigoSupportDivisionRadioItem2;

  private ACRadioButtonItem kaigoSupportDivisionRadioItem3;

  private ACValueArrayRadioButtonGroup kaigoSupportManagementBasicRadio;

  private ACLabelContainer kaigoSupportManagementBasicRadioContainer;

  private ACListModelAdapter kaigoSupportManagementBasicRadioModel;

  private ACRadioButtonItem kaigoSupportManagementBasicRadioItem1;

  private ACRadioButtonItem kaigoSupportManagementBasicRadioItem2;

  private ACValueArrayRadioButtonGroup kaigoSupportSpecificProviderSubtractionRadio;

  private ACLabelContainer kaigoSupportSpecificProviderSubtractionRadioContainer;

  private ACListModelAdapter kaigoSupportSpecificProviderSubtractionRadioModel;

  private ACRadioButtonItem kaigoSupportSpecificProviderSubtractionRadioItem1;

  private ACRadioButtonItem kaigoSupportSpecificProviderSubtractionRadioItem2;

  private ACValueArrayRadioButtonGroup kaigoSupportStandardRadio;

  private ACLabelContainer kaigoSupportStandardRadioContainer;

  private ACListModelAdapter kaigoSupportStandardRadioModel;

  private ACRadioButtonItem kaigoSupportStandardRadioItem1;

  private ACRadioButtonItem kaigoSupportStandardRadioItem2;

  private ACValueArrayRadioButtonGroup hospitalInfoRadioGroup;

  private ACLabelContainer hospitalInfoRadioGroupContainer;

  private ACListModelAdapter hospitalInfoRadioGroupModel;

  private ACRadioButtonItem hospitalInfoRadioItem1;

  private ACRadioButtonItem hospitalInfoRadioItem2;

  private ACRadioButtonItem hospitalInfoRadioItem3;

  private ACValueArrayRadioButtonGroup dischargeAddRadio;

  private ACLabelContainer dischargeAddRadioContainer;

  private ACListModelAdapter dischargeAddRadioModel;

  private ACRadioButtonItem dischargeAddRadioItem1;

  private ACRadioButtonItem dischargeAddRadioItem2;

  private ACValueArrayRadioButtonGroup kaigoSupportSpecificStandardRadio;

  private ACLabelContainer kaigoSupportSpecificStandardRadioContainer;

  private ACListModelAdapter kaigoSupportSpecificStandardRadioModel;

  private ACRadioButtonItem kaigoSupportSpecificStandardRadioItem1;

  private ACRadioButtonItem kaigoSupportSpecificStandardRadioItem2;

  private ACRadioButtonItem kaigoSupportSpecificStandardRadioItem3;

  private ACValueArrayRadioButtonGroup dementiaAddRadioGroup;

  private ACLabelContainer dementiaAddRadioGroupContainer;

  private ACListModelAdapter dementiaAddRadioGroupModel;

  private ACRadioButtonItem dementiaAddRadioItem1;

  private ACRadioButtonItem dementiaAddRadioItem2;

  private ACValueArrayRadioButtonGroup solitaryOldPeopleRadioGroup;

  private ACLabelContainer solitaryOldPeopleRadioGroupContainer;

  private ACListModelAdapter solitaryOldPeopleRadioGroupModel;

  private ACRadioButtonItem solitaryOldPeopleRadioItem1;

  private ACRadioButtonItem solitaryOldPeopleRadioItem2;

  private ACValueArrayRadioButtonGroup smallScaleProviderHelpAddRadioGroup;

  private ACLabelContainer smallScaleProviderHelpAddRadioGroupContainer;

  private ACListModelAdapter smallScaleProviderHelpAddRadioGroupModel;

  private ACRadioButtonItem smallScaleProviderHelpAddRadioItem1;

  private ACRadioButtonItem smallScaleProviderHelpAddRadioItem2;

  private ACPanel tab2;

  private ACValueArrayRadioButtonGroup compositionServiceRadioGroup;

  private ACLabelContainer compositionServiceRadioGroupContainer;

  private ACListModelAdapter compositionServiceRadioGroupModel;

  private ACRadioButtonItem compositionServiceRadioItem1;

  private ACRadioButtonItem compositionServiceRadioItem2;

  private ACValueArrayRadioButtonGroup providerAddMountainousAreaRafioRadioGroup;

  private ACLabelContainer providerAddMountainousAreaRafioRadioGroupContainer;

  private ACListModelAdapter providerAddMountainousAreaRafioRadioGroupModel;

  private ACRadioButtonItem providerAddMountainousAreaRafioItem1;

  private ACRadioButtonItem providerAddMountainousAreaRafioRadioItem2;

  private ACValueArrayRadioButtonGroup homeEmergencyConferenceAddRadioGroup;

  private ACLabelContainer homeEmergencyConferenceAddRadioGroupContainer;

  private ACListModelAdapter homeEmergencyConferenceAddRadioGroupModel;

  private ACRadioButtonItem homeEmergencyConferenceAddRadioItem1;

  private ACRadioButtonItem homeEmergencyConferenceAddRadioItem2;

  private ACGroupBox kaigoSupportSpecialMemberContainer;

  private ACTextField kaigoSupportSpecialMemberNumber;

  private ACLabelContainer kaigoSupportSpecialMemberNumberContainer;

  private ACComboBox kaigoSupportSpecialMemberName;

  private ACLabelContainer kaigoSupportSpecialMemberNameContainer;

  private ACComboBoxModelAdapter kaigoSupportSpecialMemberNameModel;

  private ACValueArrayRadioButtonGroup calculationDivision;

  private ACLabelContainer calculationDivisionContainer;

  private ACListModelAdapter calculationDivisionModel;

  private ACRadioButtonItem calculationDivisionNormal;

  private ACRadioButtonItem calculationDivisionAddOnly;

  //getter

  /**
   * ������x���̈���擾���܂��B
   * @return ������x���̈�
   */
  public ACPanel getKaigoSupportPattern(){
    if(kaigoSupportPattern==null){

      kaigoSupportPattern = new ACPanel();

      kaigoSupportPattern.setAutoWrap(false);

      kaigoSupportPattern.setFollowChildEnabled(true);

      addKaigoSupportPattern();
    }
    return kaigoSupportPattern;

  }

  /**
   * �^�u�p�l�����擾���܂��B
   * @return �^�u�p�l��
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

      tab1.setLabelMargin(0);

      tab1.setVgap(0);

      addTab1();
    }
    return tab1;

  }

  /**
   * ������x������擾���܂��B
   * @return ������x����
   */
  public ACValueArrayRadioButtonGroup getKaigoSupportDivisionRadio(){
    if(kaigoSupportDivisionRadio==null){

      kaigoSupportDivisionRadio = new ACValueArrayRadioButtonGroup();

      getKaigoSupportDivisionRadioContainer().setText("������x����");

      kaigoSupportDivisionRadio.setBindPath("1430103");

      kaigoSupportDivisionRadio.setUseClearButton(false);

      kaigoSupportDivisionRadio.setModel(getKaigoSupportDivisionRadioModel());

      kaigoSupportDivisionRadio.setValues(new int[]{1,2,3});

      addKaigoSupportDivisionRadio();
    }
    return kaigoSupportDivisionRadio;

  }

  /**
   * ������x����R���e�i���擾���܂��B
   * @return ������x����R���e�i
   */
  protected ACLabelContainer getKaigoSupportDivisionRadioContainer(){
    if(kaigoSupportDivisionRadioContainer==null){
      kaigoSupportDivisionRadioContainer = new ACLabelContainer();
      kaigoSupportDivisionRadioContainer.setFollowChildEnabled(true);
      kaigoSupportDivisionRadioContainer.setVAlignment(VRLayout.CENTER);
      kaigoSupportDivisionRadioContainer.add(getKaigoSupportDivisionRadio(), null);
    }
    return kaigoSupportDivisionRadioContainer;
  }

  /**
   * ������x����f�����擾���܂��B
   * @return ������x����f��
   */
  protected ACListModelAdapter getKaigoSupportDivisionRadioModel(){
    if(kaigoSupportDivisionRadioModel==null){
      kaigoSupportDivisionRadioModel = new ACListModelAdapter();
      addKaigoSupportDivisionRadioModel();
    }
    return kaigoSupportDivisionRadioModel;
  }

  /**
   * I�^���擾���܂��B
   * @return I�^
   */
  public ACRadioButtonItem getKaigoSupportDivisionRadioItem1(){
    if(kaigoSupportDivisionRadioItem1==null){

      kaigoSupportDivisionRadioItem1 = new ACRadioButtonItem();

      kaigoSupportDivisionRadioItem1.setText("I�^");

      kaigoSupportDivisionRadioItem1.setGroup(getKaigoSupportDivisionRadio());

      kaigoSupportDivisionRadioItem1.setConstraints(VRLayout.FLOW);

      addKaigoSupportDivisionRadioItem1();
    }
    return kaigoSupportDivisionRadioItem1;

  }

  /**
   * II�^���擾���܂��B
   * @return II�^
   */
  public ACRadioButtonItem getKaigoSupportDivisionRadioItem2(){
    if(kaigoSupportDivisionRadioItem2==null){

      kaigoSupportDivisionRadioItem2 = new ACRadioButtonItem();

      kaigoSupportDivisionRadioItem2.setText("II�^");

      kaigoSupportDivisionRadioItem2.setGroup(getKaigoSupportDivisionRadio());

      kaigoSupportDivisionRadioItem2.setConstraints(VRLayout.FLOW);

      addKaigoSupportDivisionRadioItem2();
    }
    return kaigoSupportDivisionRadioItem2;

  }

  /**
   * III�^���擾���܂��B
   * @return III�^
   */
  public ACRadioButtonItem getKaigoSupportDivisionRadioItem3(){
    if(kaigoSupportDivisionRadioItem3==null){

      kaigoSupportDivisionRadioItem3 = new ACRadioButtonItem();

      kaigoSupportDivisionRadioItem3.setText("III�^");

      kaigoSupportDivisionRadioItem3.setGroup(getKaigoSupportDivisionRadio());

      kaigoSupportDivisionRadioItem3.setConstraints(VRLayout.FLOW_RETURN);

      addKaigoSupportDivisionRadioItem3();
    }
    return kaigoSupportDivisionRadioItem3;

  }

  /**
   * �^�c����Z���擾���܂��B
   * @return �^�c����Z
   */
  public ACValueArrayRadioButtonGroup getKaigoSupportManagementBasicRadio(){
    if(kaigoSupportManagementBasicRadio==null){

      kaigoSupportManagementBasicRadio = new ACValueArrayRadioButtonGroup();

      getKaigoSupportManagementBasicRadioContainer().setText("�^�c����Z");

      kaigoSupportManagementBasicRadio.setBindPath("1430101");

      kaigoSupportManagementBasicRadio.setUseClearButton(false);

      kaigoSupportManagementBasicRadio.setModel(getKaigoSupportManagementBasicRadioModel());

      kaigoSupportManagementBasicRadio.setValues(new int[]{1,2});

      addKaigoSupportManagementBasicRadio();
    }
    return kaigoSupportManagementBasicRadio;

  }

  /**
   * �^�c����Z�R���e�i���擾���܂��B
   * @return �^�c����Z�R���e�i
   */
  protected ACLabelContainer getKaigoSupportManagementBasicRadioContainer(){
    if(kaigoSupportManagementBasicRadioContainer==null){
      kaigoSupportManagementBasicRadioContainer = new ACLabelContainer();
      kaigoSupportManagementBasicRadioContainer.setFollowChildEnabled(true);
      kaigoSupportManagementBasicRadioContainer.setVAlignment(VRLayout.CENTER);
      kaigoSupportManagementBasicRadioContainer.add(getKaigoSupportManagementBasicRadio(), null);
    }
    return kaigoSupportManagementBasicRadioContainer;
  }

  /**
   * �^�c����Z���f�����擾���܂��B
   * @return �^�c����Z���f��
   */
  protected ACListModelAdapter getKaigoSupportManagementBasicRadioModel(){
    if(kaigoSupportManagementBasicRadioModel==null){
      kaigoSupportManagementBasicRadioModel = new ACListModelAdapter();
      addKaigoSupportManagementBasicRadioModel();
    }
    return kaigoSupportManagementBasicRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getKaigoSupportManagementBasicRadioItem1(){
    if(kaigoSupportManagementBasicRadioItem1==null){

      kaigoSupportManagementBasicRadioItem1 = new ACRadioButtonItem();

      kaigoSupportManagementBasicRadioItem1.setText("�Ȃ�");

      kaigoSupportManagementBasicRadioItem1.setGroup(getKaigoSupportManagementBasicRadio());

      kaigoSupportManagementBasicRadioItem1.setConstraints(VRLayout.FLOW);

      addKaigoSupportManagementBasicRadioItem1();
    }
    return kaigoSupportManagementBasicRadioItem1;

  }

  /**
   * ���Z�v���Y�����擾���܂��B
   * @return ���Z�v���Y��
   */
  public ACRadioButtonItem getKaigoSupportManagementBasicRadioItem2(){
    if(kaigoSupportManagementBasicRadioItem2==null){

      kaigoSupportManagementBasicRadioItem2 = new ACRadioButtonItem();

      kaigoSupportManagementBasicRadioItem2.setText("I�^");

      kaigoSupportManagementBasicRadioItem2.setGroup(getKaigoSupportManagementBasicRadio());

      kaigoSupportManagementBasicRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

      addKaigoSupportManagementBasicRadioItem2();
    }
    return kaigoSupportManagementBasicRadioItem2;

  }

  /**
   * ���莖�Ə��W�����Z���擾���܂��B
   * @return ���莖�Ə��W�����Z
   */
  public ACValueArrayRadioButtonGroup getKaigoSupportSpecificProviderSubtractionRadio(){
    if(kaigoSupportSpecificProviderSubtractionRadio==null){

      kaigoSupportSpecificProviderSubtractionRadio = new ACValueArrayRadioButtonGroup();

      getKaigoSupportSpecificProviderSubtractionRadioContainer().setText("���莖�Ə��W�����Z");

      kaigoSupportSpecificProviderSubtractionRadio.setBindPath("1430104");

      kaigoSupportSpecificProviderSubtractionRadio.setNoSelectIndex(0);

      kaigoSupportSpecificProviderSubtractionRadio.setUseClearButton(false);

      kaigoSupportSpecificProviderSubtractionRadio.setModel(getKaigoSupportSpecificProviderSubtractionRadioModel());

      kaigoSupportSpecificProviderSubtractionRadio.setValues(new int[]{1,2});

      addKaigoSupportSpecificProviderSubtractionRadio();
    }
    return kaigoSupportSpecificProviderSubtractionRadio;

  }

  /**
   * ���莖�Ə��W�����Z�R���e�i���擾���܂��B
   * @return ���莖�Ə��W�����Z�R���e�i
   */
  protected ACLabelContainer getKaigoSupportSpecificProviderSubtractionRadioContainer(){
    if(kaigoSupportSpecificProviderSubtractionRadioContainer==null){
      kaigoSupportSpecificProviderSubtractionRadioContainer = new ACLabelContainer();
      kaigoSupportSpecificProviderSubtractionRadioContainer.setFollowChildEnabled(true);
      kaigoSupportSpecificProviderSubtractionRadioContainer.setVAlignment(VRLayout.CENTER);
      kaigoSupportSpecificProviderSubtractionRadioContainer.add(getKaigoSupportSpecificProviderSubtractionRadio(), null);
    }
    return kaigoSupportSpecificProviderSubtractionRadioContainer;
  }

  /**
   * ���莖�Ə��W�����Z���f�����擾���܂��B
   * @return ���莖�Ə��W�����Z���f��
   */
  protected ACListModelAdapter getKaigoSupportSpecificProviderSubtractionRadioModel(){
    if(kaigoSupportSpecificProviderSubtractionRadioModel==null){
      kaigoSupportSpecificProviderSubtractionRadioModel = new ACListModelAdapter();
      addKaigoSupportSpecificProviderSubtractionRadioModel();
    }
    return kaigoSupportSpecificProviderSubtractionRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getKaigoSupportSpecificProviderSubtractionRadioItem1(){
    if(kaigoSupportSpecificProviderSubtractionRadioItem1==null){

      kaigoSupportSpecificProviderSubtractionRadioItem1 = new ACRadioButtonItem();

      kaigoSupportSpecificProviderSubtractionRadioItem1.setText("�Ȃ�");

      kaigoSupportSpecificProviderSubtractionRadioItem1.setGroup(getKaigoSupportSpecificProviderSubtractionRadio());

      kaigoSupportSpecificProviderSubtractionRadioItem1.setConstraints(VRLayout.FLOW);

      addKaigoSupportSpecificProviderSubtractionRadioItem1();
    }
    return kaigoSupportSpecificProviderSubtractionRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getKaigoSupportSpecificProviderSubtractionRadioItem2(){
    if(kaigoSupportSpecificProviderSubtractionRadioItem2==null){

      kaigoSupportSpecificProviderSubtractionRadioItem2 = new ACRadioButtonItem();

      kaigoSupportSpecificProviderSubtractionRadioItem2.setText("����");

      kaigoSupportSpecificProviderSubtractionRadioItem2.setGroup(getKaigoSupportSpecificProviderSubtractionRadio());

      kaigoSupportSpecificProviderSubtractionRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

      addKaigoSupportSpecificProviderSubtractionRadioItem2();
    }
    return kaigoSupportSpecificProviderSubtractionRadioItem2;

  }

  /**
   * ������Z���擾���܂��B
   * @return ������Z
   */
  public ACValueArrayRadioButtonGroup getKaigoSupportStandardRadio(){
    if(kaigoSupportStandardRadio==null){

      kaigoSupportStandardRadio = new ACValueArrayRadioButtonGroup();

      getKaigoSupportStandardRadioContainer().setText("������Z");

      kaigoSupportStandardRadio.setBindPath("1430108");

      kaigoSupportStandardRadio.setNoSelectIndex(0);

      kaigoSupportStandardRadio.setUseClearButton(false);

      kaigoSupportStandardRadio.setModel(getKaigoSupportStandardRadioModel());

      kaigoSupportStandardRadio.setValues(new int[]{1,2});

      addKaigoSupportStandardRadio();
    }
    return kaigoSupportStandardRadio;

  }

  /**
   * ������Z�R���e�i���擾���܂��B
   * @return ������Z�R���e�i
   */
  protected ACLabelContainer getKaigoSupportStandardRadioContainer(){
    if(kaigoSupportStandardRadioContainer==null){
      kaigoSupportStandardRadioContainer = new ACLabelContainer();
      kaigoSupportStandardRadioContainer.setFollowChildEnabled(true);
      kaigoSupportStandardRadioContainer.setVAlignment(VRLayout.CENTER);
      kaigoSupportStandardRadioContainer.add(getKaigoSupportStandardRadio(), null);
    }
    return kaigoSupportStandardRadioContainer;
  }

  /**
   * ������Z���f�����擾���܂��B
   * @return ������Z���f��
   */
  protected ACListModelAdapter getKaigoSupportStandardRadioModel(){
    if(kaigoSupportStandardRadioModel==null){
      kaigoSupportStandardRadioModel = new ACListModelAdapter();
      addKaigoSupportStandardRadioModel();
    }
    return kaigoSupportStandardRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getKaigoSupportStandardRadioItem1(){
    if(kaigoSupportStandardRadioItem1==null){

      kaigoSupportStandardRadioItem1 = new ACRadioButtonItem();

      kaigoSupportStandardRadioItem1.setText("�Ȃ�");

      kaigoSupportStandardRadioItem1.setGroup(getKaigoSupportStandardRadio());

      kaigoSupportStandardRadioItem1.setConstraints(VRLayout.FLOW);

      addKaigoSupportStandardRadioItem1();
    }
    return kaigoSupportStandardRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getKaigoSupportStandardRadioItem2(){
    if(kaigoSupportStandardRadioItem2==null){

      kaigoSupportStandardRadioItem2 = new ACRadioButtonItem();

      kaigoSupportStandardRadioItem2.setText("����");

      kaigoSupportStandardRadioItem2.setGroup(getKaigoSupportStandardRadio());

      kaigoSupportStandardRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

      addKaigoSupportStandardRadioItem2();
    }
    return kaigoSupportStandardRadioItem2;

  }

  /**
   * ���@�����A�g���Z���擾���܂��B
   * @return ���@�����A�g���Z
   */
  public ACValueArrayRadioButtonGroup getHospitalInfoRadioGroup(){
    if(hospitalInfoRadioGroup==null){

      hospitalInfoRadioGroup = new ACValueArrayRadioButtonGroup();

      getHospitalInfoRadioGroupContainer().setText("���@�����A�g���Z");

      hospitalInfoRadioGroup.setBindPath("1430115");

      hospitalInfoRadioGroup.setNoSelectIndex(0);

      hospitalInfoRadioGroup.setUseClearButton(false);

      hospitalInfoRadioGroup.setModel(getHospitalInfoRadioGroupModel());

      hospitalInfoRadioGroup.setValues(new int[]{1,2,3});

      addHospitalInfoRadioGroup();
    }
    return hospitalInfoRadioGroup;

  }

  /**
   * ���@�����A�g���Z�R���e�i���擾���܂��B
   * @return ���@�����A�g���Z�R���e�i
   */
  protected ACLabelContainer getHospitalInfoRadioGroupContainer(){
    if(hospitalInfoRadioGroupContainer==null){
      hospitalInfoRadioGroupContainer = new ACLabelContainer();
      hospitalInfoRadioGroupContainer.setFollowChildEnabled(true);
      hospitalInfoRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      hospitalInfoRadioGroupContainer.add(getHospitalInfoRadioGroup(), null);
    }
    return hospitalInfoRadioGroupContainer;
  }

  /**
   * ���@�����A�g���Z���f�����擾���܂��B
   * @return ���@�����A�g���Z���f��
   */
  protected ACListModelAdapter getHospitalInfoRadioGroupModel(){
    if(hospitalInfoRadioGroupModel==null){
      hospitalInfoRadioGroupModel = new ACListModelAdapter();
      addHospitalInfoRadioGroupModel();
    }
    return hospitalInfoRadioGroupModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getHospitalInfoRadioItem1(){
    if(hospitalInfoRadioItem1==null){

      hospitalInfoRadioItem1 = new ACRadioButtonItem();

      hospitalInfoRadioItem1.setText("�Ȃ�");

      hospitalInfoRadioItem1.setGroup(getHospitalInfoRadioGroup());

      hospitalInfoRadioItem1.setConstraints(VRLayout.FLOW);

      addHospitalInfoRadioItem1();
    }
    return hospitalInfoRadioItem1;

  }

  /**
   * I�^���擾���܂��B
   * @return I�^
   */
  public ACRadioButtonItem getHospitalInfoRadioItem2(){
    if(hospitalInfoRadioItem2==null){

      hospitalInfoRadioItem2 = new ACRadioButtonItem();

      hospitalInfoRadioItem2.setText("I�^");

      hospitalInfoRadioItem2.setGroup(getHospitalInfoRadioGroup());

      hospitalInfoRadioItem2.setConstraints(VRLayout.FLOW);

      addHospitalInfoRadioItem2();
    }
    return hospitalInfoRadioItem2;

  }

  /**
   * II�^���擾���܂��B
   * @return II�^
   */
  public ACRadioButtonItem getHospitalInfoRadioItem3(){
    if(hospitalInfoRadioItem3==null){

      hospitalInfoRadioItem3 = new ACRadioButtonItem();

      hospitalInfoRadioItem3.setText("II�^");

      hospitalInfoRadioItem3.setGroup(getHospitalInfoRadioGroup());

      hospitalInfoRadioItem3.setConstraints(VRLayout.FLOW);

      addHospitalInfoRadioItem3();
    }
    return hospitalInfoRadioItem3;

  }

  /**
   * �މ@�E�ޏ����Z���擾���܂��B
   * @return �މ@�E�ޏ����Z
   */
  public ACValueArrayRadioButtonGroup getDischargeAddRadio(){
    if(dischargeAddRadio==null){

      dischargeAddRadio = new ACValueArrayRadioButtonGroup();

      getDischargeAddRadioContainer().setText("�މ@�E�ޏ����Z");

      dischargeAddRadio.setBindPath("1430113");

      dischargeAddRadio.setNoSelectIndex(0);

      dischargeAddRadio.setUseClearButton(false);

      dischargeAddRadio.setModel(getDischargeAddRadioModel());

      dischargeAddRadio.setValues(new int[]{1,2});

      addDischargeAddRadio();
    }
    return dischargeAddRadio;

  }

  /**
   * �މ@�E�ޏ����Z�R���e�i���擾���܂��B
   * @return �މ@�E�ޏ����Z�R���e�i
   */
  protected ACLabelContainer getDischargeAddRadioContainer(){
    if(dischargeAddRadioContainer==null){
      dischargeAddRadioContainer = new ACLabelContainer();
      dischargeAddRadioContainer.setFollowChildEnabled(true);
      dischargeAddRadioContainer.setVAlignment(VRLayout.CENTER);
      dischargeAddRadioContainer.add(getDischargeAddRadio(), null);
    }
    return dischargeAddRadioContainer;
  }

  /**
   * �މ@�E�ޏ����Z���f�����擾���܂��B
   * @return �މ@�E�ޏ����Z���f��
   */
  protected ACListModelAdapter getDischargeAddRadioModel(){
    if(dischargeAddRadioModel==null){
      dischargeAddRadioModel = new ACListModelAdapter();
      addDischargeAddRadioModel();
    }
    return dischargeAddRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getDischargeAddRadioItem1(){
    if(dischargeAddRadioItem1==null){

      dischargeAddRadioItem1 = new ACRadioButtonItem();

      dischargeAddRadioItem1.setText("�Ȃ�");

      dischargeAddRadioItem1.setGroup(getDischargeAddRadio());

      dischargeAddRadioItem1.setConstraints(VRLayout.FLOW);

      addDischargeAddRadioItem1();
    }
    return dischargeAddRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getDischargeAddRadioItem2(){
    if(dischargeAddRadioItem2==null){

      dischargeAddRadioItem2 = new ACRadioButtonItem();

      dischargeAddRadioItem2.setText("����");

      dischargeAddRadioItem2.setGroup(getDischargeAddRadio());

      dischargeAddRadioItem2.setConstraints(VRLayout.FLOW);

      addDischargeAddRadioItem2();
    }
    return dischargeAddRadioItem2;

  }

  /**
   * ���莖�Ə����Z���擾���܂��B
   * @return ���莖�Ə����Z
   */
  public ACValueArrayRadioButtonGroup getKaigoSupportSpecificStandardRadio(){
    if(kaigoSupportSpecificStandardRadio==null){

      kaigoSupportSpecificStandardRadio = new ACValueArrayRadioButtonGroup();

      getKaigoSupportSpecificStandardRadioContainer().setText("���莖�Ə����Z");

      kaigoSupportSpecificStandardRadio.setBindPath("1430106");

      kaigoSupportSpecificStandardRadio.setNoSelectIndex(0);

      kaigoSupportSpecificStandardRadio.setUseClearButton(false);

      kaigoSupportSpecificStandardRadio.setModel(getKaigoSupportSpecificStandardRadioModel());

      kaigoSupportSpecificStandardRadio.setValues(new int[]{1,2,3});

      addKaigoSupportSpecificStandardRadio();
    }
    return kaigoSupportSpecificStandardRadio;

  }

  /**
   * ���莖�Ə����Z�R���e�i���擾���܂��B
   * @return ���莖�Ə����Z�R���e�i
   */
  protected ACLabelContainer getKaigoSupportSpecificStandardRadioContainer(){
    if(kaigoSupportSpecificStandardRadioContainer==null){
      kaigoSupportSpecificStandardRadioContainer = new ACLabelContainer();
      kaigoSupportSpecificStandardRadioContainer.setFollowChildEnabled(true);
      kaigoSupportSpecificStandardRadioContainer.setVAlignment(VRLayout.CENTER);
      kaigoSupportSpecificStandardRadioContainer.add(getKaigoSupportSpecificStandardRadio(), null);
    }
    return kaigoSupportSpecificStandardRadioContainer;
  }

  /**
   * ���莖�Ə����Z���f�����擾���܂��B
   * @return ���莖�Ə����Z���f��
   */
  protected ACListModelAdapter getKaigoSupportSpecificStandardRadioModel(){
    if(kaigoSupportSpecificStandardRadioModel==null){
      kaigoSupportSpecificStandardRadioModel = new ACListModelAdapter();
      addKaigoSupportSpecificStandardRadioModel();
    }
    return kaigoSupportSpecificStandardRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getKaigoSupportSpecificStandardRadioItem1(){
    if(kaigoSupportSpecificStandardRadioItem1==null){

      kaigoSupportSpecificStandardRadioItem1 = new ACRadioButtonItem();

      kaigoSupportSpecificStandardRadioItem1.setText("�Ȃ�");

      kaigoSupportSpecificStandardRadioItem1.setGroup(getKaigoSupportSpecificStandardRadio());

      kaigoSupportSpecificStandardRadioItem1.setConstraints(VRLayout.FLOW);

      addKaigoSupportSpecificStandardRadioItem1();
    }
    return kaigoSupportSpecificStandardRadioItem1;

  }

  /**
   * I�^���擾���܂��B
   * @return I�^
   */
  public ACRadioButtonItem getKaigoSupportSpecificStandardRadioItem2(){
    if(kaigoSupportSpecificStandardRadioItem2==null){

      kaigoSupportSpecificStandardRadioItem2 = new ACRadioButtonItem();

      kaigoSupportSpecificStandardRadioItem2.setText("I�^");

      kaigoSupportSpecificStandardRadioItem2.setGroup(getKaigoSupportSpecificStandardRadio());

      kaigoSupportSpecificStandardRadioItem2.setConstraints(VRLayout.FLOW);

      addKaigoSupportSpecificStandardRadioItem2();
    }
    return kaigoSupportSpecificStandardRadioItem2;

  }

  /**
   * II�^���擾���܂��B
   * @return II�^
   */
  public ACRadioButtonItem getKaigoSupportSpecificStandardRadioItem3(){
    if(kaigoSupportSpecificStandardRadioItem3==null){

      kaigoSupportSpecificStandardRadioItem3 = new ACRadioButtonItem();

      kaigoSupportSpecificStandardRadioItem3.setText("II�^");

      kaigoSupportSpecificStandardRadioItem3.setGroup(getKaigoSupportSpecificStandardRadio());

      kaigoSupportSpecificStandardRadioItem3.setConstraints(VRLayout.FLOW);

      addKaigoSupportSpecificStandardRadioItem3();
    }
    return kaigoSupportSpecificStandardRadioItem3;

  }

  /**
   * �F�m�ǉ��Z���擾���܂��B
   * @return �F�m�ǉ��Z
   */
  public ACValueArrayRadioButtonGroup getDementiaAddRadioGroup(){
    if(dementiaAddRadioGroup==null){

      dementiaAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getDementiaAddRadioGroupContainer().setText("�F�m�ǉ��Z");

      dementiaAddRadioGroup.setBindPath("1430110");

      dementiaAddRadioGroup.setNoSelectIndex(0);

      dementiaAddRadioGroup.setUseClearButton(false);

      dementiaAddRadioGroup.setModel(getDementiaAddRadioGroupModel());

      dementiaAddRadioGroup.setValues(new int[]{1,2});

      addDementiaAddRadioGroup();
    }
    return dementiaAddRadioGroup;

  }

  /**
   * �F�m�ǉ��Z�R���e�i���擾���܂��B
   * @return �F�m�ǉ��Z�R���e�i
   */
  protected ACLabelContainer getDementiaAddRadioGroupContainer(){
    if(dementiaAddRadioGroupContainer==null){
      dementiaAddRadioGroupContainer = new ACLabelContainer();
      dementiaAddRadioGroupContainer.setFollowChildEnabled(true);
      dementiaAddRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      dementiaAddRadioGroupContainer.add(getDementiaAddRadioGroup(), null);
    }
    return dementiaAddRadioGroupContainer;
  }

  /**
   * �F�m�ǉ��Z���f�����擾���܂��B
   * @return �F�m�ǉ��Z���f��
   */
  protected ACListModelAdapter getDementiaAddRadioGroupModel(){
    if(dementiaAddRadioGroupModel==null){
      dementiaAddRadioGroupModel = new ACListModelAdapter();
      addDementiaAddRadioGroupModel();
    }
    return dementiaAddRadioGroupModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getDementiaAddRadioItem1(){
    if(dementiaAddRadioItem1==null){

      dementiaAddRadioItem1 = new ACRadioButtonItem();

      dementiaAddRadioItem1.setText("�Ȃ�");

      dementiaAddRadioItem1.setGroup(getDementiaAddRadioGroup());

      dementiaAddRadioItem1.setConstraints(VRLayout.FLOW);

      addDementiaAddRadioItem1();
    }
    return dementiaAddRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getDementiaAddRadioItem2(){
    if(dementiaAddRadioItem2==null){

      dementiaAddRadioItem2 = new ACRadioButtonItem();

      dementiaAddRadioItem2.setText("����");

      dementiaAddRadioItem2.setGroup(getDementiaAddRadioGroup());

      dementiaAddRadioItem2.setConstraints(VRLayout.FLOW);

      addDementiaAddRadioItem2();
    }
    return dementiaAddRadioItem2;

  }

  /**
   * �Ƌ�����҉��Z���擾���܂��B
   * @return �Ƌ�����҉��Z
   */
  public ACValueArrayRadioButtonGroup getSolitaryOldPeopleRadioGroup(){
    if(solitaryOldPeopleRadioGroup==null){

      solitaryOldPeopleRadioGroup = new ACValueArrayRadioButtonGroup();

      getSolitaryOldPeopleRadioGroupContainer().setText("�Ƌ�����҉��Z");

      solitaryOldPeopleRadioGroup.setBindPath("1430111");

      solitaryOldPeopleRadioGroup.setNoSelectIndex(0);

      solitaryOldPeopleRadioGroup.setUseClearButton(false);

      solitaryOldPeopleRadioGroup.setModel(getSolitaryOldPeopleRadioGroupModel());

      solitaryOldPeopleRadioGroup.setValues(new int[]{1,2});

      addSolitaryOldPeopleRadioGroup();
    }
    return solitaryOldPeopleRadioGroup;

  }

  /**
   * �Ƌ�����҉��Z�R���e�i���擾���܂��B
   * @return �Ƌ�����҉��Z�R���e�i
   */
  protected ACLabelContainer getSolitaryOldPeopleRadioGroupContainer(){
    if(solitaryOldPeopleRadioGroupContainer==null){
      solitaryOldPeopleRadioGroupContainer = new ACLabelContainer();
      solitaryOldPeopleRadioGroupContainer.setFollowChildEnabled(true);
      solitaryOldPeopleRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      solitaryOldPeopleRadioGroupContainer.add(getSolitaryOldPeopleRadioGroup(), null);
    }
    return solitaryOldPeopleRadioGroupContainer;
  }

  /**
   * �Ƌ�����҉��Z���f�����擾���܂��B
   * @return �Ƌ�����҉��Z���f��
   */
  protected ACListModelAdapter getSolitaryOldPeopleRadioGroupModel(){
    if(solitaryOldPeopleRadioGroupModel==null){
      solitaryOldPeopleRadioGroupModel = new ACListModelAdapter();
      addSolitaryOldPeopleRadioGroupModel();
    }
    return solitaryOldPeopleRadioGroupModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getSolitaryOldPeopleRadioItem1(){
    if(solitaryOldPeopleRadioItem1==null){

      solitaryOldPeopleRadioItem1 = new ACRadioButtonItem();

      solitaryOldPeopleRadioItem1.setText("�Ȃ�");

      solitaryOldPeopleRadioItem1.setGroup(getSolitaryOldPeopleRadioGroup());

      solitaryOldPeopleRadioItem1.setConstraints(VRLayout.FLOW);

      addSolitaryOldPeopleRadioItem1();
    }
    return solitaryOldPeopleRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getSolitaryOldPeopleRadioItem2(){
    if(solitaryOldPeopleRadioItem2==null){

      solitaryOldPeopleRadioItem2 = new ACRadioButtonItem();

      solitaryOldPeopleRadioItem2.setText("����");

      solitaryOldPeopleRadioItem2.setGroup(getSolitaryOldPeopleRadioGroup());

      solitaryOldPeopleRadioItem2.setConstraints(VRLayout.FLOW);

      addSolitaryOldPeopleRadioItem2();
    }
    return solitaryOldPeopleRadioItem2;

  }

  /**
   * ���K�͑��@�\�^�����쎖�Ə��A�g���Z���擾���܂��B
   * @return ���K�͑��@�\�^�����쎖�Ə��A�g���Z
   */
  public ACValueArrayRadioButtonGroup getSmallScaleProviderHelpAddRadioGroup(){
    if(smallScaleProviderHelpAddRadioGroup==null){

      smallScaleProviderHelpAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getSmallScaleProviderHelpAddRadioGroupContainer().setText("���K�͑��@�\�^������" + ACConstants.LINE_SEPARATOR + "���Ə��A�g���Z");

      smallScaleProviderHelpAddRadioGroup.setBindPath("1430112");

      smallScaleProviderHelpAddRadioGroup.setNoSelectIndex(0);

      smallScaleProviderHelpAddRadioGroup.setUseClearButton(false);

      smallScaleProviderHelpAddRadioGroup.setModel(getSmallScaleProviderHelpAddRadioGroupModel());

      smallScaleProviderHelpAddRadioGroup.setValues(new int[]{1,2});

      addSmallScaleProviderHelpAddRadioGroup();
    }
    return smallScaleProviderHelpAddRadioGroup;

  }

  /**
   * ���K�͑��@�\�^�����쎖�Ə��A�g���Z�R���e�i���擾���܂��B
   * @return ���K�͑��@�\�^�����쎖�Ə��A�g���Z�R���e�i
   */
  protected ACLabelContainer getSmallScaleProviderHelpAddRadioGroupContainer(){
    if(smallScaleProviderHelpAddRadioGroupContainer==null){
      smallScaleProviderHelpAddRadioGroupContainer = new ACLabelContainer();
      smallScaleProviderHelpAddRadioGroupContainer.setFollowChildEnabled(true);
      smallScaleProviderHelpAddRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      smallScaleProviderHelpAddRadioGroupContainer.add(getSmallScaleProviderHelpAddRadioGroup(), null);
    }
    return smallScaleProviderHelpAddRadioGroupContainer;
  }

  /**
   * ���K�͑��@�\�^�����쎖�Ə��A�g���Z���f�����擾���܂��B
   * @return ���K�͑��@�\�^�����쎖�Ə��A�g���Z���f��
   */
  protected ACListModelAdapter getSmallScaleProviderHelpAddRadioGroupModel(){
    if(smallScaleProviderHelpAddRadioGroupModel==null){
      smallScaleProviderHelpAddRadioGroupModel = new ACListModelAdapter();
      addSmallScaleProviderHelpAddRadioGroupModel();
    }
    return smallScaleProviderHelpAddRadioGroupModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getSmallScaleProviderHelpAddRadioItem1(){
    if(smallScaleProviderHelpAddRadioItem1==null){

      smallScaleProviderHelpAddRadioItem1 = new ACRadioButtonItem();

      smallScaleProviderHelpAddRadioItem1.setText("�Ȃ�");

      smallScaleProviderHelpAddRadioItem1.setGroup(getSmallScaleProviderHelpAddRadioGroup());

      smallScaleProviderHelpAddRadioItem1.setConstraints(VRLayout.FLOW);

      addSmallScaleProviderHelpAddRadioItem1();
    }
    return smallScaleProviderHelpAddRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getSmallScaleProviderHelpAddRadioItem2(){
    if(smallScaleProviderHelpAddRadioItem2==null){

      smallScaleProviderHelpAddRadioItem2 = new ACRadioButtonItem();

      smallScaleProviderHelpAddRadioItem2.setText("����");

      smallScaleProviderHelpAddRadioItem2.setGroup(getSmallScaleProviderHelpAddRadioGroup());

      smallScaleProviderHelpAddRadioItem2.setConstraints(VRLayout.FLOW);

      addSmallScaleProviderHelpAddRadioItem2();
    }
    return smallScaleProviderHelpAddRadioItem2;

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

      tab2.setLabelMargin(0);

      tab2.setVgap(0);

      addTab2();
    }
    return tab2;

  }

  /**
   * �����^�T�[�r�X���Ə��A�g���Z���擾���܂��B
   * @return �����^�T�[�r�X���Ə��A�g���Z
   */
  public ACValueArrayRadioButtonGroup getCompositionServiceRadioGroup(){
    if(compositionServiceRadioGroup==null){

      compositionServiceRadioGroup = new ACValueArrayRadioButtonGroup();

      getCompositionServiceRadioGroupContainer().setText("�����^�T�[�r�X���Ə��A�g���Z");

      compositionServiceRadioGroup.setBindPath("1430116");

      compositionServiceRadioGroup.setNoSelectIndex(0);

      compositionServiceRadioGroup.setUseClearButton(false);

      compositionServiceRadioGroup.setModel(getCompositionServiceRadioGroupModel());

      compositionServiceRadioGroup.setValues(new int[]{1,2});

      addCompositionServiceRadioGroup();
    }
    return compositionServiceRadioGroup;

  }

  /**
   * �����^�T�[�r�X���Ə��A�g���Z�R���e�i���擾���܂��B
   * @return �����^�T�[�r�X���Ə��A�g���Z�R���e�i
   */
  protected ACLabelContainer getCompositionServiceRadioGroupContainer(){
    if(compositionServiceRadioGroupContainer==null){
      compositionServiceRadioGroupContainer = new ACLabelContainer();
      compositionServiceRadioGroupContainer.setFollowChildEnabled(true);
      compositionServiceRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      compositionServiceRadioGroupContainer.add(getCompositionServiceRadioGroup(), null);
    }
    return compositionServiceRadioGroupContainer;
  }

  /**
   * �����^�T�[�r�X���Ə��A�g���Z���f�����擾���܂��B
   * @return �����^�T�[�r�X���Ə��A�g���Z���f��
   */
  protected ACListModelAdapter getCompositionServiceRadioGroupModel(){
    if(compositionServiceRadioGroupModel==null){
      compositionServiceRadioGroupModel = new ACListModelAdapter();
      addCompositionServiceRadioGroupModel();
    }
    return compositionServiceRadioGroupModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getCompositionServiceRadioItem1(){
    if(compositionServiceRadioItem1==null){

      compositionServiceRadioItem1 = new ACRadioButtonItem();

      compositionServiceRadioItem1.setText("�Ȃ�");

      compositionServiceRadioItem1.setGroup(getCompositionServiceRadioGroup());

      compositionServiceRadioItem1.setConstraints(VRLayout.FLOW);

      addCompositionServiceRadioItem1();
    }
    return compositionServiceRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getCompositionServiceRadioItem2(){
    if(compositionServiceRadioItem2==null){

      compositionServiceRadioItem2 = new ACRadioButtonItem();

      compositionServiceRadioItem2.setText("����");

      compositionServiceRadioItem2.setGroup(getCompositionServiceRadioGroup());

      compositionServiceRadioItem2.setConstraints(VRLayout.FLOW);

      addCompositionServiceRadioItem2();
    }
    return compositionServiceRadioItem2;

  }

  /**
   * ���R�Ԓn�擙�ł̃T�[�r�X�񋟉��Z���擾���܂��B
   * @return ���R�Ԓn�擙�ł̃T�[�r�X�񋟉��Z
   */
  public ACValueArrayRadioButtonGroup getProviderAddMountainousAreaRafioRadioGroup(){
    if(providerAddMountainousAreaRafioRadioGroup==null){

      providerAddMountainousAreaRafioRadioGroup = new ACValueArrayRadioButtonGroup();

      getProviderAddMountainousAreaRafioRadioGroupContainer().setText("���R�Ԓn�擙�ł̃T�[�r�X" + ACConstants.LINE_SEPARATOR + "�񋟉��Z");

      providerAddMountainousAreaRafioRadioGroup.setBindPath("12");

      providerAddMountainousAreaRafioRadioGroup.setNoSelectIndex(0);

      providerAddMountainousAreaRafioRadioGroup.setUseClearButton(false);

      providerAddMountainousAreaRafioRadioGroup.setModel(getProviderAddMountainousAreaRafioRadioGroupModel());

      providerAddMountainousAreaRafioRadioGroup.setValues(new int[]{1,2});

      addProviderAddMountainousAreaRafioRadioGroup();
    }
    return providerAddMountainousAreaRafioRadioGroup;

  }

  /**
   * ���R�Ԓn�擙�ł̃T�[�r�X�񋟉��Z�R���e�i���擾���܂��B
   * @return ���R�Ԓn�擙�ł̃T�[�r�X�񋟉��Z�R���e�i
   */
  protected ACLabelContainer getProviderAddMountainousAreaRafioRadioGroupContainer(){
    if(providerAddMountainousAreaRafioRadioGroupContainer==null){
      providerAddMountainousAreaRafioRadioGroupContainer = new ACLabelContainer();
      providerAddMountainousAreaRafioRadioGroupContainer.setFollowChildEnabled(true);
      providerAddMountainousAreaRafioRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      providerAddMountainousAreaRafioRadioGroupContainer.add(getProviderAddMountainousAreaRafioRadioGroup(), null);
    }
    return providerAddMountainousAreaRafioRadioGroupContainer;
  }

  /**
   * ���R�Ԓn�擙�ł̃T�[�r�X�񋟉��Z���f�����擾���܂��B
   * @return ���R�Ԓn�擙�ł̃T�[�r�X�񋟉��Z���f��
   */
  protected ACListModelAdapter getProviderAddMountainousAreaRafioRadioGroupModel(){
    if(providerAddMountainousAreaRafioRadioGroupModel==null){
      providerAddMountainousAreaRafioRadioGroupModel = new ACListModelAdapter();
      addProviderAddMountainousAreaRafioRadioGroupModel();
    }
    return providerAddMountainousAreaRafioRadioGroupModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getProviderAddMountainousAreaRafioItem1(){
    if(providerAddMountainousAreaRafioItem1==null){

      providerAddMountainousAreaRafioItem1 = new ACRadioButtonItem();

      providerAddMountainousAreaRafioItem1.setText("�Ȃ�");

      providerAddMountainousAreaRafioItem1.setGroup(getProviderAddMountainousAreaRafioRadioGroup());

      providerAddMountainousAreaRafioItem1.setConstraints(VRLayout.FLOW);

      addProviderAddMountainousAreaRafioItem1();
    }
    return providerAddMountainousAreaRafioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getProviderAddMountainousAreaRafioRadioItem2(){
    if(providerAddMountainousAreaRafioRadioItem2==null){

      providerAddMountainousAreaRafioRadioItem2 = new ACRadioButtonItem();

      providerAddMountainousAreaRafioRadioItem2.setText("����");

      providerAddMountainousAreaRafioRadioItem2.setGroup(getProviderAddMountainousAreaRafioRadioGroup());

      providerAddMountainousAreaRafioRadioItem2.setConstraints(VRLayout.FLOW);

      addProviderAddMountainousAreaRafioRadioItem2();
    }
    return providerAddMountainousAreaRafioRadioItem2;

  }

  /**
   * �ً}��������J���t�@�����X���Z���擾���܂��B
   * @return �ً}��������J���t�@�����X���Z
   */
  public ACValueArrayRadioButtonGroup getHomeEmergencyConferenceAddRadioGroup(){
    if(homeEmergencyConferenceAddRadioGroup==null){

      homeEmergencyConferenceAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getHomeEmergencyConferenceAddRadioGroupContainer().setText("�ً}��������J���t�@�����X���Z");

      homeEmergencyConferenceAddRadioGroup.setBindPath("1430114");

      homeEmergencyConferenceAddRadioGroup.setNoSelectIndex(0);

      homeEmergencyConferenceAddRadioGroup.setUseClearButton(false);

      homeEmergencyConferenceAddRadioGroup.setModel(getHomeEmergencyConferenceAddRadioGroupModel());

      homeEmergencyConferenceAddRadioGroup.setValues(new int[]{1,2});

      addHomeEmergencyConferenceAddRadioGroup();
    }
    return homeEmergencyConferenceAddRadioGroup;

  }

  /**
   * �ً}��������J���t�@�����X���Z�R���e�i���擾���܂��B
   * @return �ً}��������J���t�@�����X���Z�R���e�i
   */
  protected ACLabelContainer getHomeEmergencyConferenceAddRadioGroupContainer(){
    if(homeEmergencyConferenceAddRadioGroupContainer==null){
      homeEmergencyConferenceAddRadioGroupContainer = new ACLabelContainer();
      homeEmergencyConferenceAddRadioGroupContainer.setFollowChildEnabled(true);
      homeEmergencyConferenceAddRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      homeEmergencyConferenceAddRadioGroupContainer.add(getHomeEmergencyConferenceAddRadioGroup(), null);
    }
    return homeEmergencyConferenceAddRadioGroupContainer;
  }

  /**
   * �ً}��������J���t�@�����X���Z���f�����擾���܂��B
   * @return �ً}��������J���t�@�����X���Z���f��
   */
  protected ACListModelAdapter getHomeEmergencyConferenceAddRadioGroupModel(){
    if(homeEmergencyConferenceAddRadioGroupModel==null){
      homeEmergencyConferenceAddRadioGroupModel = new ACListModelAdapter();
      addHomeEmergencyConferenceAddRadioGroupModel();
    }
    return homeEmergencyConferenceAddRadioGroupModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getHomeEmergencyConferenceAddRadioItem1(){
    if(homeEmergencyConferenceAddRadioItem1==null){

      homeEmergencyConferenceAddRadioItem1 = new ACRadioButtonItem();

      homeEmergencyConferenceAddRadioItem1.setText("�Ȃ�");

      homeEmergencyConferenceAddRadioItem1.setGroup(getHomeEmergencyConferenceAddRadioGroup());

      homeEmergencyConferenceAddRadioItem1.setConstraints(VRLayout.FLOW);

      addHomeEmergencyConferenceAddRadioItem1();
    }
    return homeEmergencyConferenceAddRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getHomeEmergencyConferenceAddRadioItem2(){
    if(homeEmergencyConferenceAddRadioItem2==null){

      homeEmergencyConferenceAddRadioItem2 = new ACRadioButtonItem();

      homeEmergencyConferenceAddRadioItem2.setText("����");

      homeEmergencyConferenceAddRadioItem2.setGroup(getHomeEmergencyConferenceAddRadioGroup());

      homeEmergencyConferenceAddRadioItem2.setConstraints(VRLayout.FLOW);

      addHomeEmergencyConferenceAddRadioItem2();
    }
    return homeEmergencyConferenceAddRadioItem2;

  }

  /**
   * ���x�������R���e�i���擾���܂��B
   * @return ���x�������R���e�i
   */
  public ACGroupBox getKaigoSupportSpecialMemberContainer(){
    if(kaigoSupportSpecialMemberContainer==null){

      kaigoSupportSpecialMemberContainer = new ACGroupBox();

      kaigoSupportSpecialMemberContainer.setText("���x���������");

      addKaigoSupportSpecialMemberContainer();
    }
    return kaigoSupportSpecialMemberContainer;

  }

  /**
   * ���x�������ԍ����擾���܂��B
   * @return ���x�������ԍ�
   */
  public ACTextField getKaigoSupportSpecialMemberNumber(){
    if(kaigoSupportSpecialMemberNumber==null){

      kaigoSupportSpecialMemberNumber = new ACTextField();

      getKaigoSupportSpecialMemberNumberContainer().setText("���x�������ԍ�");

      kaigoSupportSpecialMemberNumber.setBindPath("1430107");

      kaigoSupportSpecialMemberNumber.setColumns(6);

      kaigoSupportSpecialMemberNumber.setCharType(VRCharType.ONLY_DIGIT);

      kaigoSupportSpecialMemberNumber.setMaxLength(8);

      addKaigoSupportSpecialMemberNumber();
    }
    return kaigoSupportSpecialMemberNumber;

  }

  /**
   * ���x�������ԍ��R���e�i���擾���܂��B
   * @return ���x�������ԍ��R���e�i
   */
  protected ACLabelContainer getKaigoSupportSpecialMemberNumberContainer(){
    if(kaigoSupportSpecialMemberNumberContainer==null){
      kaigoSupportSpecialMemberNumberContainer = new ACLabelContainer();
      kaigoSupportSpecialMemberNumberContainer.setFollowChildEnabled(true);
      kaigoSupportSpecialMemberNumberContainer.setVAlignment(VRLayout.CENTER);
      kaigoSupportSpecialMemberNumberContainer.add(getKaigoSupportSpecialMemberNumber(), null);
    }
    return kaigoSupportSpecialMemberNumberContainer;
  }

  /**
   * ���x�������������擾���܂��B
   * @return ���x����������
   */
  public ACComboBox getKaigoSupportSpecialMemberName(){
    if(kaigoSupportSpecialMemberName==null){

      kaigoSupportSpecialMemberName = new ACComboBox();

      getKaigoSupportSpecialMemberNameContainer().setText("���x����������");

      kaigoSupportSpecialMemberName.setEditable(false);

      kaigoSupportSpecialMemberName.setRenderBindPath("STAFF_NAME");

      kaigoSupportSpecialMemberName.setMaxColumns(10);

      kaigoSupportSpecialMemberName.setModel(getKaigoSupportSpecialMemberNameModel());

      addKaigoSupportSpecialMemberName();
    }
    return kaigoSupportSpecialMemberName;

  }

  /**
   * ���x�����������R���e�i���擾���܂��B
   * @return ���x�����������R���e�i
   */
  protected ACLabelContainer getKaigoSupportSpecialMemberNameContainer(){
    if(kaigoSupportSpecialMemberNameContainer==null){
      kaigoSupportSpecialMemberNameContainer = new ACLabelContainer();
      kaigoSupportSpecialMemberNameContainer.setFollowChildEnabled(true);
      kaigoSupportSpecialMemberNameContainer.setVAlignment(VRLayout.CENTER);
      kaigoSupportSpecialMemberNameContainer.add(getKaigoSupportSpecialMemberName(), null);
    }
    return kaigoSupportSpecialMemberNameContainer;
  }

  /**
   * ���x�������������f�����擾���܂��B
   * @return ���x�������������f��
   */
  protected ACComboBoxModelAdapter getKaigoSupportSpecialMemberNameModel(){
    if(kaigoSupportSpecialMemberNameModel==null){
      kaigoSupportSpecialMemberNameModel = new ACComboBoxModelAdapter();
      addKaigoSupportSpecialMemberNameModel();
    }
    return kaigoSupportSpecialMemberNameModel;
  }

  /**
   * �Z��敪���擾���܂��B
   * @return �Z��敪
   */
  public ACValueArrayRadioButtonGroup getCalculationDivision(){
    if(calculationDivision==null){

      calculationDivision = new ACValueArrayRadioButtonGroup();

      getCalculationDivisionContainer().setText("�Z��敪");

      calculationDivision.setBindPath("9");

      calculationDivision.setUseClearButton(false);

      calculationDivision.setModel(getCalculationDivisionModel());

      calculationDivision.setValues(new int[]{1,2});

      addCalculationDivision();
    }
    return calculationDivision;

  }

  /**
   * �Z��敪�R���e�i���擾���܂��B
   * @return �Z��敪�R���e�i
   */
  protected ACLabelContainer getCalculationDivisionContainer(){
    if(calculationDivisionContainer==null){
      calculationDivisionContainer = new ACLabelContainer();
      calculationDivisionContainer.setFollowChildEnabled(true);
      calculationDivisionContainer.setVAlignment(VRLayout.CENTER);
      calculationDivisionContainer.add(getCalculationDivision(), null);
    }
    return calculationDivisionContainer;
  }

  /**
   * �Z��敪���f�����擾���܂��B
   * @return �Z��敪���f��
   */
  protected ACListModelAdapter getCalculationDivisionModel(){
    if(calculationDivisionModel==null){
      calculationDivisionModel = new ACListModelAdapter();
      addCalculationDivisionModel();
    }
    return calculationDivisionModel;
  }

  /**
   * �ʏ���擾���܂��B
   * @return �ʏ�
   */
  public ACRadioButtonItem getCalculationDivisionNormal(){
    if(calculationDivisionNormal==null){

      calculationDivisionNormal = new ACRadioButtonItem();

      calculationDivisionNormal.setText("�ʏ�");

      calculationDivisionNormal.setGroup(getCalculationDivision());

      calculationDivisionNormal.setConstraints(VRLayout.FLOW);

      addCalculationDivisionNormal();
    }
    return calculationDivisionNormal;

  }

  /**
   * ���Z�݂̂��擾���܂��B
   * @return ���Z�̂�
   */
  public ACRadioButtonItem getCalculationDivisionAddOnly(){
    if(calculationDivisionAddOnly==null){

      calculationDivisionAddOnly = new ACRadioButtonItem();

      calculationDivisionAddOnly.setText("���Z�̂�");

      calculationDivisionAddOnly.setGroup(getCalculationDivision());

      calculationDivisionAddOnly.setConstraints(VRLayout.FLOW);

      addCalculationDivisionAddOnly();
    }
    return calculationDivisionAddOnly;

  }

  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001_14311_201204Design() {

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

    this.add(getKaigoSupportPattern(), VRLayout.CLIENT);

  }

  /**
   * ������x���̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoSupportPattern(){

    kaigoSupportPattern.add(getTabs(), VRLayout.CLIENT);

  }

  /**
   * �^�u�p�l���ɓ������ڂ�ǉ����܂��B
   */
  protected void addTabs(){

    tabs.addTab("1", getTab1());

    tabs.addTab("2", getTab2());

  }

  /**
   * �^�u1�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTab1(){

    tab1.add(getKaigoSupportDivisionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getKaigoSupportManagementBasicRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getKaigoSupportSpecificProviderSubtractionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getKaigoSupportStandardRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getHospitalInfoRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getDischargeAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getKaigoSupportSpecificStandardRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getDementiaAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getSolitaryOldPeopleRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getSmallScaleProviderHelpAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * ������x����ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoSupportDivisionRadio(){

  }

  /**
   * ������x����f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoSupportDivisionRadioModel(){

    getKaigoSupportDivisionRadioItem1().setButtonIndex(1);

    getKaigoSupportDivisionRadioModel().add(getKaigoSupportDivisionRadioItem1());

    getKaigoSupportDivisionRadioItem2().setButtonIndex(2);

    getKaigoSupportDivisionRadioModel().add(getKaigoSupportDivisionRadioItem2());

    getKaigoSupportDivisionRadioItem3().setButtonIndex(3);

    getKaigoSupportDivisionRadioModel().add(getKaigoSupportDivisionRadioItem3());

  }

  /**
   * I�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoSupportDivisionRadioItem1(){

  }

  /**
   * II�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoSupportDivisionRadioItem2(){

  }

  /**
   * III�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoSupportDivisionRadioItem3(){

  }

  /**
   * �^�c����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoSupportManagementBasicRadio(){

  }

  /**
   * �^�c����Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoSupportManagementBasicRadioModel(){

    getKaigoSupportManagementBasicRadioItem1().setButtonIndex(1);

    getKaigoSupportManagementBasicRadioModel().add(getKaigoSupportManagementBasicRadioItem1());

    getKaigoSupportManagementBasicRadioItem2().setButtonIndex(2);

    getKaigoSupportManagementBasicRadioModel().add(getKaigoSupportManagementBasicRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoSupportManagementBasicRadioItem1(){

  }

  /**
   * ���Z�v���Y���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoSupportManagementBasicRadioItem2(){

  }

  /**
   * ���莖�Ə��W�����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoSupportSpecificProviderSubtractionRadio(){

  }

  /**
   * ���莖�Ə��W�����Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoSupportSpecificProviderSubtractionRadioModel(){

    getKaigoSupportSpecificProviderSubtractionRadioItem1().setButtonIndex(1);

    getKaigoSupportSpecificProviderSubtractionRadioModel().add(getKaigoSupportSpecificProviderSubtractionRadioItem1());

    getKaigoSupportSpecificProviderSubtractionRadioItem2().setButtonIndex(2);

    getKaigoSupportSpecificProviderSubtractionRadioModel().add(getKaigoSupportSpecificProviderSubtractionRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoSupportSpecificProviderSubtractionRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoSupportSpecificProviderSubtractionRadioItem2(){

  }

  /**
   * ������Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoSupportStandardRadio(){

  }

  /**
   * ������Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoSupportStandardRadioModel(){

    getKaigoSupportStandardRadioItem1().setButtonIndex(1);

    getKaigoSupportStandardRadioModel().add(getKaigoSupportStandardRadioItem1());

    getKaigoSupportStandardRadioItem2().setButtonIndex(2);

    getKaigoSupportStandardRadioModel().add(getKaigoSupportStandardRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoSupportStandardRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoSupportStandardRadioItem2(){

  }

  /**
   * ���@�����A�g���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHospitalInfoRadioGroup(){

  }

  /**
   * ���@�����A�g���Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addHospitalInfoRadioGroupModel(){

    getHospitalInfoRadioItem1().setButtonIndex(1);

    getHospitalInfoRadioGroupModel().add(getHospitalInfoRadioItem1());

    getHospitalInfoRadioItem2().setButtonIndex(2);

    getHospitalInfoRadioGroupModel().add(getHospitalInfoRadioItem2());

    getHospitalInfoRadioItem3().setButtonIndex(3);

    getHospitalInfoRadioGroupModel().add(getHospitalInfoRadioItem3());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addHospitalInfoRadioItem1(){

  }

  /**
   * I�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHospitalInfoRadioItem2(){

  }

  /**
   * II�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHospitalInfoRadioItem3(){

  }

  /**
   * �މ@�E�ޏ����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addDischargeAddRadio(){

  }

  /**
   * �މ@�E�ޏ����Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addDischargeAddRadioModel(){

    getDischargeAddRadioItem1().setButtonIndex(1);

    getDischargeAddRadioModel().add(getDischargeAddRadioItem1());

    getDischargeAddRadioItem2().setButtonIndex(2);

    getDischargeAddRadioModel().add(getDischargeAddRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addDischargeAddRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addDischargeAddRadioItem2(){

  }

  /**
   * ���莖�Ə����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoSupportSpecificStandardRadio(){

  }

  /**
   * ���莖�Ə����Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoSupportSpecificStandardRadioModel(){

    getKaigoSupportSpecificStandardRadioItem1().setButtonIndex(1);

    getKaigoSupportSpecificStandardRadioModel().add(getKaigoSupportSpecificStandardRadioItem1());

    getKaigoSupportSpecificStandardRadioItem2().setButtonIndex(2);

    getKaigoSupportSpecificStandardRadioModel().add(getKaigoSupportSpecificStandardRadioItem2());

    getKaigoSupportSpecificStandardRadioItem3().setButtonIndex(3);

    getKaigoSupportSpecificStandardRadioModel().add(getKaigoSupportSpecificStandardRadioItem3());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoSupportSpecificStandardRadioItem1(){

  }

  /**
   * I�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoSupportSpecificStandardRadioItem2(){

  }

  /**
   * II�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoSupportSpecificStandardRadioItem3(){

  }

  /**
   * �F�m�ǉ��Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addDementiaAddRadioGroup(){

  }

  /**
   * �F�m�ǉ��Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addDementiaAddRadioGroupModel(){

    getDementiaAddRadioItem1().setButtonIndex(1);

    getDementiaAddRadioGroupModel().add(getDementiaAddRadioItem1());

    getDementiaAddRadioItem2().setButtonIndex(2);

    getDementiaAddRadioGroupModel().add(getDementiaAddRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addDementiaAddRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addDementiaAddRadioItem2(){

  }

  /**
   * �Ƌ�����҉��Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addSolitaryOldPeopleRadioGroup(){

  }

  /**
   * �Ƌ�����҉��Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addSolitaryOldPeopleRadioGroupModel(){

    getSolitaryOldPeopleRadioItem1().setButtonIndex(1);

    getSolitaryOldPeopleRadioGroupModel().add(getSolitaryOldPeopleRadioItem1());

    getSolitaryOldPeopleRadioItem2().setButtonIndex(2);

    getSolitaryOldPeopleRadioGroupModel().add(getSolitaryOldPeopleRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addSolitaryOldPeopleRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addSolitaryOldPeopleRadioItem2(){

  }

  /**
   * ���K�͑��@�\�^�����쎖�Ə��A�g���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addSmallScaleProviderHelpAddRadioGroup(){

  }

  /**
   * ���K�͑��@�\�^�����쎖�Ə��A�g���Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addSmallScaleProviderHelpAddRadioGroupModel(){

    getSmallScaleProviderHelpAddRadioItem1().setButtonIndex(1);

    getSmallScaleProviderHelpAddRadioGroupModel().add(getSmallScaleProviderHelpAddRadioItem1());

    getSmallScaleProviderHelpAddRadioItem2().setButtonIndex(2);

    getSmallScaleProviderHelpAddRadioGroupModel().add(getSmallScaleProviderHelpAddRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addSmallScaleProviderHelpAddRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addSmallScaleProviderHelpAddRadioItem2(){

  }

  /**
   * �^�u2�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTab2(){

    tab2.add(getCompositionServiceRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getProviderAddMountainousAreaRafioRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getHomeEmergencyConferenceAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getKaigoSupportSpecialMemberContainer(), VRLayout.FLOW);

    tab2.add(getCalculationDivisionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * �����^�T�[�r�X���Ə��A�g���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addCompositionServiceRadioGroup(){

  }

  /**
   * �����^�T�[�r�X���Ə��A�g���Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCompositionServiceRadioGroupModel(){

    getCompositionServiceRadioItem1().setButtonIndex(1);

    getCompositionServiceRadioGroupModel().add(getCompositionServiceRadioItem1());

    getCompositionServiceRadioItem2().setButtonIndex(2);

    getCompositionServiceRadioGroupModel().add(getCompositionServiceRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addCompositionServiceRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addCompositionServiceRadioItem2(){

  }

  /**
   * ���R�Ԓn�擙�ł̃T�[�r�X�񋟉��Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderAddMountainousAreaRafioRadioGroup(){

  }

  /**
   * ���R�Ԓn�擙�ł̃T�[�r�X�񋟉��Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderAddMountainousAreaRafioRadioGroupModel(){

    getProviderAddMountainousAreaRafioItem1().setButtonIndex(1);

    getProviderAddMountainousAreaRafioRadioGroupModel().add(getProviderAddMountainousAreaRafioItem1());

    getProviderAddMountainousAreaRafioRadioItem2().setButtonIndex(2);

    getProviderAddMountainousAreaRafioRadioGroupModel().add(getProviderAddMountainousAreaRafioRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderAddMountainousAreaRafioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderAddMountainousAreaRafioRadioItem2(){

  }

  /**
   * �ً}��������J���t�@�����X���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHomeEmergencyConferenceAddRadioGroup(){

  }

  /**
   * �ً}��������J���t�@�����X���Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addHomeEmergencyConferenceAddRadioGroupModel(){

    getHomeEmergencyConferenceAddRadioItem1().setButtonIndex(1);

    getHomeEmergencyConferenceAddRadioGroupModel().add(getHomeEmergencyConferenceAddRadioItem1());

    getHomeEmergencyConferenceAddRadioItem2().setButtonIndex(2);

    getHomeEmergencyConferenceAddRadioGroupModel().add(getHomeEmergencyConferenceAddRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addHomeEmergencyConferenceAddRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addHomeEmergencyConferenceAddRadioItem2(){

  }

  /**
   * ���x�������R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoSupportSpecialMemberContainer(){

    kaigoSupportSpecialMemberContainer.add(getKaigoSupportSpecialMemberNumberContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    kaigoSupportSpecialMemberContainer.add(getKaigoSupportSpecialMemberNameContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * ���x�������ԍ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoSupportSpecialMemberNumber(){

  }

  /**
   * ���x�����������ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoSupportSpecialMemberName(){

  }

  /**
   * ���x�������������f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoSupportSpecialMemberNameModel(){

  }

  /**
   * �Z��敪�ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalculationDivision(){

  }

  /**
   * �Z��敪���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalculationDivisionModel(){

    getCalculationDivisionNormal().setButtonIndex(1);

    getCalculationDivisionModel().add(getCalculationDivisionNormal());

    getCalculationDivisionAddOnly().setButtonIndex(2);

    getCalculationDivisionModel().add(getCalculationDivisionAddOnly());

  }

  /**
   * �ʏ�ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalculationDivisionNormal(){

  }

  /**
   * ���Z�݂̂ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalculationDivisionAddOnly(){

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
      ACFrame.debugStart(new ACAffairInfo(QS001_14311_201204Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QS001_14311_201204Design getThis() {
    return this;
  }
}
