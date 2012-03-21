
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
 * �J����: ��i�@�a�P
 * �쐬��: 2012/03/07  ���{�R���s���[�^�[������� ��i�@�a�P �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �T�[�r�X�\��쐬/�ύX (S)
 * �v���Z�X �T�[�r�X�\��T�� (001)
 * �v���O���� �T�[�r�X�p�^�[�������^�T�[�r�XI (QS001_17711_201204)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
import java.awt.Component;
import java.awt.im.InputSubset;

import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;

import jp.nichicom.ac.ACConstants;
import jp.nichicom.ac.component.ACComboBox;
import jp.nichicom.ac.component.ACIntegerCheckBox;
import jp.nichicom.ac.component.ACLabel;
import jp.nichicom.ac.component.ACRadioButtonItem;
import jp.nichicom.ac.component.ACTextField;
import jp.nichicom.ac.component.ACTimeComboBox;
import jp.nichicom.ac.component.ACValueArrayRadioButtonGroup;
import jp.nichicom.ac.container.ACBackLabelContainer;
import jp.nichicom.ac.container.ACGroupBox;
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
 * �T�[�r�X�p�^�[�������^�T�[�r�XI��ʍ��ڃf�U�C��(QS001_17711_201204) 
 */
public class QS001_17711_201204Design extends QS001ServicePanel {
  //GUI�R���|�[�l���g

  private ACPanel mainGroup;

  private JTabbedPane tab;

  private ACPanel tab1;

  private ACValueArrayRadioButtonGroup staffSubtractionRadio;

  private ACLabelContainer staffSubtractionRadioContainer;

  private ACListModelAdapter staffSubtractionRadioModel;

  private ACRadioButtonItem staffSubtractionRadioItem1;

  private ACRadioButtonItem staffSubtractionRadioItem2;

  private ACRadioButtonItem staffSubtractionRadioItem3;

  private ACValueArrayRadioButtonGroup smallServiceRadio;

  private ACLabelContainer smallServiceRadioContainer;

  private ACListModelAdapter smallServiceRadioModel;

  private ACRadioButtonItem smallServiceRadioItem1;

  private ACRadioButtonItem smallServiceRadioItem2;

  private ACValueArrayRadioButtonGroup initialAddRadio;

  private ACLabelContainer initialAddRadioContainer;

  private ACListModelAdapter initialAddRadioModel;

  private ACRadioButtonItem initialAddRadioItem1;

  private ACRadioButtonItem initialAddRadioItem2;

  private ACValueArrayRadioButtonGroup dementiaRadio;

  private ACLabelContainer dementiaRadioContainer;

  private ACListModelAdapter dementiaRadioModel;

  private ACRadioButtonItem dementiaRadioItem1;

  private ACRadioButtonItem dementiaRadioItem2;

  private ACRadioButtonItem dementiaRadioItem3;

  private ACValueArrayRadioButtonGroup leavingHospitalGuidanceAddRadio;

  private ACLabelContainer leavingHospitalGuidanceAddRadioContainer;

  private ACListModelAdapter leavingHospitalGuidanceAddRadioModel;

  private ACRadioButtonItem leavingHospitalGuidanceAddRadioItem1;

  private ACRadioButtonItem leavingHospitalGuidanceAddRadioItem2;

  private ACValueArrayRadioButtonGroup businessBeginnerAddRadio;

  private ACLabelContainer businessBeginnerAddRadioContainer;

  private ACListModelAdapter businessBeginnerAddRadioModel;

  private ACRadioButtonItem businessBeginnerAddRadioItem1;

  private ACRadioButtonItem businessBeginnerAddRadioItem2;

  private ACValueArrayRadioButtonGroup urgentTimeAddRadio;

  private ACLabelContainer urgentTimeAddRadioContainer;

  private ACListModelAdapter urgentTimeAddRadioModel;

  private ACRadioButtonItem urgentTimeAddRadioItem1;

  private ACRadioButtonItem urgentTimeAddRadioItem2;

  private ACValueArrayRadioButtonGroup serviceProvisionStructuralAddRadio;

  private ACLabelContainer serviceProvisionStructuralAddRadioContainer;

  private ACListModelAdapter serviceProvisionStructuralAddRadioModel;

  private ACRadioButtonItem serviceProvisionStructuralAddRadioItem1;

  private ACRadioButtonItem serviceProvisionStructuralAddRadioItem2;

  private ACRadioButtonItem serviceProvisionStructuralAddRadioItem3;

  private ACRadioButtonItem serviceProvisionStructuralAddRadioItem4;

  private ACValueArrayRadioButtonGroup specialManagementRadio;

  private ACLabelContainer specialManagementRadioContainer;

  private ACListModelAdapter specialManagementRadioModel;

  private ACRadioButtonItem specialManagementRadioItem1;

  private ACRadioButtonItem specialManagementRadioItem2;

  private ACRadioButtonItem specialManagementRadioItem3;

  private ACValueArrayRadioButtonGroup terminalCareAddRadio;

  private ACLabelContainer terminalCareAddRadioContainer;

  private ACListModelAdapter terminalCareAddRadioModel;

  private ACRadioButtonItem terminalCareAddRadioItem1;

  private ACRadioButtonItem terminalCareAddRadioItem2;

  private ACPanel tab2;

  private ACComboBox serviceMunicipalityAdd;

  private ACLabelContainer serviceMunicipalityAddContainer;

  private ACComboBoxModelAdapter serviceMunicipalityAddModel;

  private ACValueArrayRadioButtonGroup subtractVisitingNurseRadioGroup;

  private ACLabelContainer subtractVisitingNurseRadioGroupContainer;

  private ACListModelAdapter subtractVisitingNurseRadioGroupModel;

  private ACRadioButtonItem subtractVisitingNurseRadioItem1;

  private ACRadioButtonItem subtractVisitingNurseRadioItem2;

  private ACValueArrayRadioButtonGroup subtractSpecialVisitingNursingSupportRadioGroup;

  private ACLabelContainer subtractSpecialVisitingNursingSupportRadioGroupContainer;

  private ACListModelAdapter subtractSpecialVisitingNursingSupportRadioGroupModel;

  private ACRadioButtonItem subtractSpecialVisitingNursingSupportRadioItem1;

  private ACRadioButtonItem subtractSpecialVisitingNursingSupportRadioItem2;

  private ACGroupBox kaigoSupportSpecialMemberContainer;

  private ACTextField kaigoSupportSpecialMemberNumber;

  private ACLabelContainer kaigoSupportSpecialMemberNumberContainer;

  private ACComboBox kaigoSupportSpecialMemberName;

  private ACLabelContainer kaigoSupportSpecialMemberNameContainer;

  private ACComboBoxModelAdapter kaigoSupportSpecialMemberNameModel;

  private ACGroupBox tekiyouGroup;

  private ACTextField tekiyouText;

  private ACLabelContainer tekiyouTextContainer;

  private ACLabel tekiyouCommentTitle;

  private ACValueArrayRadioButtonGroup calculationDivision;

  private ACLabelContainer calculationDivisionContainer;

  private ACListModelAdapter calculationDivisionModel;

  private ACRadioButtonItem calculationDivisionNormal;

  private ACRadioButtonItem calculationDivisionAddOnly;

  private ACIntegerCheckBox crackOnDayCheck;

  private ACIntegerCheckBox printable;

  private ACBackLabelContainer homonNyuyokuTimeContainer;

  private ACTimeComboBox homonNyuyokuBeginTime;

  private ACLabelContainer homonNyuyokuBeginTimeContainer;

  private ACComboBoxModelAdapter homonNyuyokuBeginTimeModel;

  private ACTimeComboBox homonNyuyokuEndTime;

  private ACLabelContainer homonNyuyokuEndTimeContainer;

  private ACComboBoxModelAdapter homonNyuyokuEndTimeModel;

  //getter

  /**
   * �p�^�[���̈���擾���܂��B
   * @return �p�^�[���̈�
   */
  public ACPanel getMainGroup(){
    if(mainGroup==null){

      mainGroup = new ACPanel();

      mainGroup.setFollowChildEnabled(true);

      addMainGroup();
    }
    return mainGroup;

  }

  /**
   * �^�u���擾���܂��B
   * @return �^�u
   */
  public JTabbedPane getTab(){
    if(tab==null){

      tab = new JTabbedPane();

      addTab();
    }
    return tab;

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
   * �l�����Z���擾���܂��B
   * @return �l�����Z
   */
  public ACValueArrayRadioButtonGroup getStaffSubtractionRadio(){
    if(staffSubtractionRadio==null){

      staffSubtractionRadio = new ACValueArrayRadioButtonGroup();

      getStaffSubtractionRadioContainer().setText("�l�����Z");

      staffSubtractionRadio.setBindPath("1770101");

      staffSubtractionRadio.setUseClearButton(false);

      staffSubtractionRadio.setModel(getStaffSubtractionRadioModel());

      staffSubtractionRadio.setValues(new int[]{1,2,3});

      addStaffSubtractionRadio();
    }
    return staffSubtractionRadio;

  }

  /**
   * �l�����Z�R���e�i���擾���܂��B
   * @return �l�����Z�R���e�i
   */
  protected ACLabelContainer getStaffSubtractionRadioContainer(){
    if(staffSubtractionRadioContainer==null){
      staffSubtractionRadioContainer = new ACLabelContainer();
      staffSubtractionRadioContainer.setFollowChildEnabled(true);
      staffSubtractionRadioContainer.setVAlignment(VRLayout.CENTER);
      staffSubtractionRadioContainer.add(getStaffSubtractionRadio(), null);
    }
    return staffSubtractionRadioContainer;
  }

  /**
   * �l�����Z���f�����擾���܂��B
   * @return �l�����Z���f��
   */
  protected ACListModelAdapter getStaffSubtractionRadioModel(){
    if(staffSubtractionRadioModel==null){
      staffSubtractionRadioModel = new ACListModelAdapter();
      addStaffSubtractionRadioModel();
    }
    return staffSubtractionRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getStaffSubtractionRadioItem1(){
    if(staffSubtractionRadioItem1==null){

      staffSubtractionRadioItem1 = new ACRadioButtonItem();

      staffSubtractionRadioItem1.setText("�Ȃ�");

      staffSubtractionRadioItem1.setGroup(getStaffSubtractionRadio());

      staffSubtractionRadioItem1.setConstraints(VRLayout.FLOW);

      addStaffSubtractionRadioItem1();
    }
    return staffSubtractionRadioItem1;

  }

  /**
   * ������߂��擾���܂��B
   * @return �������
   */
  public ACRadioButtonItem getStaffSubtractionRadioItem2(){
    if(staffSubtractionRadioItem2==null){

      staffSubtractionRadioItem2 = new ACRadioButtonItem();

      staffSubtractionRadioItem2.setText("�������");

      staffSubtractionRadioItem2.setGroup(getStaffSubtractionRadio());

      staffSubtractionRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

      addStaffSubtractionRadioItem2();
    }
    return staffSubtractionRadioItem2;

  }

  /**
   * �]�ƈ��̕s�����擾���܂��B
   * @return �]�ƈ��̕s��
   */
  public ACRadioButtonItem getStaffSubtractionRadioItem3(){
    if(staffSubtractionRadioItem3==null){

      staffSubtractionRadioItem3 = new ACRadioButtonItem();

      staffSubtractionRadioItem3.setText("�]�ƈ��̕s��");

      staffSubtractionRadioItem3.setGroup(getStaffSubtractionRadio());

      staffSubtractionRadioItem3.setConstraints(VRLayout.FLOW);

      addStaffSubtractionRadioItem3();
    }
    return staffSubtractionRadioItem3;

  }

  /**
   * �ߏ��T�[�r�X�ɑ΂��錸�Z���擾���܂��B
   * @return �ߏ��T�[�r�X�ɑ΂��錸�Z
   */
  public ACValueArrayRadioButtonGroup getSmallServiceRadio(){
    if(smallServiceRadio==null){

      smallServiceRadio = new ACValueArrayRadioButtonGroup();

      getSmallServiceRadioContainer().setText("�ߏ��T�[�r�X�ɑ΂��錸�Z");

      smallServiceRadio.setBindPath("1770102");

      smallServiceRadio.setNoSelectIndex(0);

      smallServiceRadio.setUseClearButton(false);

      smallServiceRadio.setModel(getSmallServiceRadioModel());

      smallServiceRadio.setValues(new int[]{1,2});

      addSmallServiceRadio();
    }
    return smallServiceRadio;

  }

  /**
   * �ߏ��T�[�r�X�ɑ΂��錸�Z�R���e�i���擾���܂��B
   * @return �ߏ��T�[�r�X�ɑ΂��錸�Z�R���e�i
   */
  protected ACLabelContainer getSmallServiceRadioContainer(){
    if(smallServiceRadioContainer==null){
      smallServiceRadioContainer = new ACLabelContainer();
      smallServiceRadioContainer.setFollowChildEnabled(true);
      smallServiceRadioContainer.setVAlignment(VRLayout.CENTER);
      smallServiceRadioContainer.add(getSmallServiceRadio(), null);
    }
    return smallServiceRadioContainer;
  }

  /**
   * �ߏ��T�[�r�X�ɑ΂��錸�Z���f�����擾���܂��B
   * @return �ߏ��T�[�r�X�ɑ΂��錸�Z���f��
   */
  protected ACListModelAdapter getSmallServiceRadioModel(){
    if(smallServiceRadioModel==null){
      smallServiceRadioModel = new ACListModelAdapter();
      addSmallServiceRadioModel();
    }
    return smallServiceRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getSmallServiceRadioItem1(){
    if(smallServiceRadioItem1==null){

      smallServiceRadioItem1 = new ACRadioButtonItem();

      smallServiceRadioItem1.setText("�Ȃ�");

      smallServiceRadioItem1.setGroup(getSmallServiceRadio());

      smallServiceRadioItem1.setConstraints(VRLayout.FLOW);

      addSmallServiceRadioItem1();
    }
    return smallServiceRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getSmallServiceRadioItem2(){
    if(smallServiceRadioItem2==null){

      smallServiceRadioItem2 = new ACRadioButtonItem();

      smallServiceRadioItem2.setText("����");

      smallServiceRadioItem2.setGroup(getSmallServiceRadio());

      smallServiceRadioItem2.setConstraints(VRLayout.FLOW);

      addSmallServiceRadioItem2();
    }
    return smallServiceRadioItem2;

  }

  /**
   * �������Z���擾���܂��B
   * @return �������Z
   */
  public ACValueArrayRadioButtonGroup getInitialAddRadio(){
    if(initialAddRadio==null){

      initialAddRadio = new ACValueArrayRadioButtonGroup();

      getInitialAddRadioContainer().setText("�������Z");

      initialAddRadio.setBindPath("1770104");

      initialAddRadio.setUseClearButton(false);

      initialAddRadio.setModel(getInitialAddRadioModel());

      initialAddRadio.setValues(new int[]{1,2});

      addInitialAddRadio();
    }
    return initialAddRadio;

  }

  /**
   * �������Z�R���e�i���擾���܂��B
   * @return �������Z�R���e�i
   */
  protected ACLabelContainer getInitialAddRadioContainer(){
    if(initialAddRadioContainer==null){
      initialAddRadioContainer = new ACLabelContainer();
      initialAddRadioContainer.setFollowChildEnabled(true);
      initialAddRadioContainer.setVAlignment(VRLayout.CENTER);
      initialAddRadioContainer.add(getInitialAddRadio(), null);
    }
    return initialAddRadioContainer;
  }

  /**
   * �������Z���f�����擾���܂��B
   * @return �������Z���f��
   */
  protected ACListModelAdapter getInitialAddRadioModel(){
    if(initialAddRadioModel==null){
      initialAddRadioModel = new ACListModelAdapter();
      addInitialAddRadioModel();
    }
    return initialAddRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getInitialAddRadioItem1(){
    if(initialAddRadioItem1==null){

      initialAddRadioItem1 = new ACRadioButtonItem();

      initialAddRadioItem1.setText("�Ȃ�");

      initialAddRadioItem1.setGroup(getInitialAddRadio());

      initialAddRadioItem1.setConstraints(VRLayout.FLOW);

      addInitialAddRadioItem1();
    }
    return initialAddRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getInitialAddRadioItem2(){
    if(initialAddRadioItem2==null){

      initialAddRadioItem2 = new ACRadioButtonItem();

      initialAddRadioItem2.setText("����");

      initialAddRadioItem2.setGroup(getInitialAddRadio());

      initialAddRadioItem2.setConstraints(VRLayout.FLOW);

      addInitialAddRadioItem2();
    }
    return initialAddRadioItem2;

  }

  /**
   * �F�m�ǉ��Z���擾���܂��B
   * @return �F�m�ǉ��Z
   */
  public ACValueArrayRadioButtonGroup getDementiaRadio(){
    if(dementiaRadio==null){

      dementiaRadio = new ACValueArrayRadioButtonGroup();

      getDementiaRadioContainer().setText("�F�m�ǉ��Z");

      dementiaRadio.setBindPath("1770105");

      dementiaRadio.setUseClearButton(false);

      dementiaRadio.setModel(getDementiaRadioModel());

      dementiaRadio.setValues(new int[]{1,2,3});

      addDementiaRadio();
    }
    return dementiaRadio;

  }

  /**
   * �F�m�ǉ��Z�R���e�i���擾���܂��B
   * @return �F�m�ǉ��Z�R���e�i
   */
  protected ACLabelContainer getDementiaRadioContainer(){
    if(dementiaRadioContainer==null){
      dementiaRadioContainer = new ACLabelContainer();
      dementiaRadioContainer.setFollowChildEnabled(true);
      dementiaRadioContainer.setVAlignment(VRLayout.CENTER);
      dementiaRadioContainer.add(getDementiaRadio(), null);
    }
    return dementiaRadioContainer;
  }

  /**
   * �F�m�ǉ��Z���f�����擾���܂��B
   * @return �F�m�ǉ��Z���f��
   */
  protected ACListModelAdapter getDementiaRadioModel(){
    if(dementiaRadioModel==null){
      dementiaRadioModel = new ACListModelAdapter();
      addDementiaRadioModel();
    }
    return dementiaRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getDementiaRadioItem1(){
    if(dementiaRadioItem1==null){

      dementiaRadioItem1 = new ACRadioButtonItem();

      dementiaRadioItem1.setText("�Ȃ�");

      dementiaRadioItem1.setGroup(getDementiaRadio());

      dementiaRadioItem1.setConstraints(VRLayout.FLOW);

      addDementiaRadioItem1();
    }
    return dementiaRadioItem1;

  }

  /**
   * I�^���擾���܂��B
   * @return I�^
   */
  public ACRadioButtonItem getDementiaRadioItem2(){
    if(dementiaRadioItem2==null){

      dementiaRadioItem2 = new ACRadioButtonItem();

      dementiaRadioItem2.setText("I�^");

      dementiaRadioItem2.setGroup(getDementiaRadio());

      dementiaRadioItem2.setConstraints(VRLayout.FLOW);

      addDementiaRadioItem2();
    }
    return dementiaRadioItem2;

  }

  /**
   * II�^���擾���܂��B
   * @return II�^
   */
  public ACRadioButtonItem getDementiaRadioItem3(){
    if(dementiaRadioItem3==null){

      dementiaRadioItem3 = new ACRadioButtonItem();

      dementiaRadioItem3.setText("II�^");

      dementiaRadioItem3.setGroup(getDementiaRadio());

      dementiaRadioItem3.setConstraints(VRLayout.FLOW);

      addDementiaRadioItem3();
    }
    return dementiaRadioItem3;

  }

  /**
   * �މ@�������w�����Z���擾���܂��B
   * @return �މ@�������w�����Z
   */
  public ACValueArrayRadioButtonGroup getLeavingHospitalGuidanceAddRadio(){
    if(leavingHospitalGuidanceAddRadio==null){

      leavingHospitalGuidanceAddRadio = new ACValueArrayRadioButtonGroup();

      getLeavingHospitalGuidanceAddRadioContainer().setText("�މ@�������w�����Z");

      leavingHospitalGuidanceAddRadio.setBindPath("1770106");

      leavingHospitalGuidanceAddRadio.setNoSelectIndex(0);

      leavingHospitalGuidanceAddRadio.setUseClearButton(false);

      leavingHospitalGuidanceAddRadio.setModel(getLeavingHospitalGuidanceAddRadioModel());

      leavingHospitalGuidanceAddRadio.setValues(new int[]{1,2});

      addLeavingHospitalGuidanceAddRadio();
    }
    return leavingHospitalGuidanceAddRadio;

  }

  /**
   * �މ@�������w�����Z�R���e�i���擾���܂��B
   * @return �މ@�������w�����Z�R���e�i
   */
  protected ACLabelContainer getLeavingHospitalGuidanceAddRadioContainer(){
    if(leavingHospitalGuidanceAddRadioContainer==null){
      leavingHospitalGuidanceAddRadioContainer = new ACLabelContainer();
      leavingHospitalGuidanceAddRadioContainer.setFollowChildEnabled(true);
      leavingHospitalGuidanceAddRadioContainer.setVAlignment(VRLayout.CENTER);
      leavingHospitalGuidanceAddRadioContainer.add(getLeavingHospitalGuidanceAddRadio(), null);
    }
    return leavingHospitalGuidanceAddRadioContainer;
  }

  /**
   * �މ@�������w�����Z���f�����擾���܂��B
   * @return �މ@�������w�����Z���f��
   */
  protected ACListModelAdapter getLeavingHospitalGuidanceAddRadioModel(){
    if(leavingHospitalGuidanceAddRadioModel==null){
      leavingHospitalGuidanceAddRadioModel = new ACListModelAdapter();
      addLeavingHospitalGuidanceAddRadioModel();
    }
    return leavingHospitalGuidanceAddRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getLeavingHospitalGuidanceAddRadioItem1(){
    if(leavingHospitalGuidanceAddRadioItem1==null){

      leavingHospitalGuidanceAddRadioItem1 = new ACRadioButtonItem();

      leavingHospitalGuidanceAddRadioItem1.setText("�Ȃ�");

      leavingHospitalGuidanceAddRadioItem1.setGroup(getLeavingHospitalGuidanceAddRadio());

      leavingHospitalGuidanceAddRadioItem1.setConstraints(VRLayout.FLOW);

      addLeavingHospitalGuidanceAddRadioItem1();
    }
    return leavingHospitalGuidanceAddRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getLeavingHospitalGuidanceAddRadioItem2(){
    if(leavingHospitalGuidanceAddRadioItem2==null){

      leavingHospitalGuidanceAddRadioItem2 = new ACRadioButtonItem();

      leavingHospitalGuidanceAddRadioItem2.setText("����");

      leavingHospitalGuidanceAddRadioItem2.setGroup(getLeavingHospitalGuidanceAddRadio());

      leavingHospitalGuidanceAddRadioItem2.setConstraints(VRLayout.FLOW);

      addLeavingHospitalGuidanceAddRadioItem2();
    }
    return leavingHospitalGuidanceAddRadioItem2;

  }

  /**
   * ���ƊJ�n���x�����Z���擾���܂��B
   * @return ���ƊJ�n���x�����Z
   */
  public ACValueArrayRadioButtonGroup getBusinessBeginnerAddRadio(){
    if(businessBeginnerAddRadio==null){

      businessBeginnerAddRadio = new ACValueArrayRadioButtonGroup();

      getBusinessBeginnerAddRadioContainer().setText("���ƊJ�n���x�����Z");

      businessBeginnerAddRadio.setBindPath("1770107");

      businessBeginnerAddRadio.setUseClearButton(false);

      businessBeginnerAddRadio.setModel(getBusinessBeginnerAddRadioModel());

      businessBeginnerAddRadio.setValues(new int[]{1,2});

      addBusinessBeginnerAddRadio();
    }
    return businessBeginnerAddRadio;

  }

  /**
   * ���ƊJ�n���x�����Z�R���e�i���擾���܂��B
   * @return ���ƊJ�n���x�����Z�R���e�i
   */
  protected ACLabelContainer getBusinessBeginnerAddRadioContainer(){
    if(businessBeginnerAddRadioContainer==null){
      businessBeginnerAddRadioContainer = new ACLabelContainer();
      businessBeginnerAddRadioContainer.setFollowChildEnabled(true);
      businessBeginnerAddRadioContainer.setVAlignment(VRLayout.CENTER);
      businessBeginnerAddRadioContainer.add(getBusinessBeginnerAddRadio(), null);
    }
    return businessBeginnerAddRadioContainer;
  }

  /**
   * ���ƊJ�n���x�����Z���f�����擾���܂��B
   * @return ���ƊJ�n���x�����Z���f��
   */
  protected ACListModelAdapter getBusinessBeginnerAddRadioModel(){
    if(businessBeginnerAddRadioModel==null){
      businessBeginnerAddRadioModel = new ACListModelAdapter();
      addBusinessBeginnerAddRadioModel();
    }
    return businessBeginnerAddRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getBusinessBeginnerAddRadioItem1(){
    if(businessBeginnerAddRadioItem1==null){

      businessBeginnerAddRadioItem1 = new ACRadioButtonItem();

      businessBeginnerAddRadioItem1.setText("�Ȃ�");

      businessBeginnerAddRadioItem1.setGroup(getBusinessBeginnerAddRadio());

      businessBeginnerAddRadioItem1.setConstraints(VRLayout.FLOW);

      addBusinessBeginnerAddRadioItem1();
    }
    return businessBeginnerAddRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getBusinessBeginnerAddRadioItem2(){
    if(businessBeginnerAddRadioItem2==null){

      businessBeginnerAddRadioItem2 = new ACRadioButtonItem();

      businessBeginnerAddRadioItem2.setText("����");

      businessBeginnerAddRadioItem2.setGroup(getBusinessBeginnerAddRadio());

      businessBeginnerAddRadioItem2.setConstraints(VRLayout.FLOW);

      addBusinessBeginnerAddRadioItem2();
    }
    return businessBeginnerAddRadioItem2;

  }

  /**
   * �ً}���K��Ō���Z���擾���܂��B
   * @return �ً}���K��Ō���Z
   */
  public ACValueArrayRadioButtonGroup getUrgentTimeAddRadio(){
    if(urgentTimeAddRadio==null){

      urgentTimeAddRadio = new ACValueArrayRadioButtonGroup();

      getUrgentTimeAddRadioContainer().setText("�ً}���K��Ō���Z");

      urgentTimeAddRadio.setBindPath("1770108");

      urgentTimeAddRadio.setUseClearButton(false);

      urgentTimeAddRadio.setModel(getUrgentTimeAddRadioModel());

      urgentTimeAddRadio.setValues(new int[]{1,2});

      addUrgentTimeAddRadio();
    }
    return urgentTimeAddRadio;

  }

  /**
   * �ً}���K��Ō���Z�R���e�i���擾���܂��B
   * @return �ً}���K��Ō���Z�R���e�i
   */
  protected ACLabelContainer getUrgentTimeAddRadioContainer(){
    if(urgentTimeAddRadioContainer==null){
      urgentTimeAddRadioContainer = new ACLabelContainer();
      urgentTimeAddRadioContainer.setFollowChildEnabled(true);
      urgentTimeAddRadioContainer.setVAlignment(VRLayout.CENTER);
      urgentTimeAddRadioContainer.add(getUrgentTimeAddRadio(), null);
    }
    return urgentTimeAddRadioContainer;
  }

  /**
   * �ً}���K��Ō���Z���f�����擾���܂��B
   * @return �ً}���K��Ō���Z���f��
   */
  protected ACListModelAdapter getUrgentTimeAddRadioModel(){
    if(urgentTimeAddRadioModel==null){
      urgentTimeAddRadioModel = new ACListModelAdapter();
      addUrgentTimeAddRadioModel();
    }
    return urgentTimeAddRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getUrgentTimeAddRadioItem1(){
    if(urgentTimeAddRadioItem1==null){

      urgentTimeAddRadioItem1 = new ACRadioButtonItem();

      urgentTimeAddRadioItem1.setText("�Ȃ�");

      urgentTimeAddRadioItem1.setGroup(getUrgentTimeAddRadio());

      urgentTimeAddRadioItem1.setConstraints(VRLayout.FLOW);

      addUrgentTimeAddRadioItem1();
    }
    return urgentTimeAddRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getUrgentTimeAddRadioItem2(){
    if(urgentTimeAddRadioItem2==null){

      urgentTimeAddRadioItem2 = new ACRadioButtonItem();

      urgentTimeAddRadioItem2.setText("����");

      urgentTimeAddRadioItem2.setGroup(getUrgentTimeAddRadio());

      urgentTimeAddRadioItem2.setConstraints(VRLayout.FLOW);

      addUrgentTimeAddRadioItem2();
    }
    return urgentTimeAddRadioItem2;

  }

  /**
   * �T�[�r�X�񋟑̐��������Z���擾���܂��B
   * @return �T�[�r�X�񋟑̐��������Z
   */
  public ACValueArrayRadioButtonGroup getServiceProvisionStructuralAddRadio(){
    if(serviceProvisionStructuralAddRadio==null){

      serviceProvisionStructuralAddRadio = new ACValueArrayRadioButtonGroup();

      getServiceProvisionStructuralAddRadioContainer().setText("�T�[�r�X�񋟑̐��������Z");

      serviceProvisionStructuralAddRadio.setBindPath("1770111");

      serviceProvisionStructuralAddRadio.setNoSelectIndex(0);

      serviceProvisionStructuralAddRadio.setUseClearButton(false);

      serviceProvisionStructuralAddRadio.setModel(getServiceProvisionStructuralAddRadioModel());

      serviceProvisionStructuralAddRadio.setValues(new int[]{1,2,3,4});

      addServiceProvisionStructuralAddRadio();
    }
    return serviceProvisionStructuralAddRadio;

  }

  /**
   * �T�[�r�X�񋟑̐��������Z�R���e�i���擾���܂��B
   * @return �T�[�r�X�񋟑̐��������Z�R���e�i
   */
  protected ACLabelContainer getServiceProvisionStructuralAddRadioContainer(){
    if(serviceProvisionStructuralAddRadioContainer==null){
      serviceProvisionStructuralAddRadioContainer = new ACLabelContainer();
      serviceProvisionStructuralAddRadioContainer.setFollowChildEnabled(true);
      serviceProvisionStructuralAddRadioContainer.setVAlignment(VRLayout.CENTER);
      serviceProvisionStructuralAddRadioContainer.add(getServiceProvisionStructuralAddRadio(), null);
    }
    return serviceProvisionStructuralAddRadioContainer;
  }

  /**
   * �T�[�r�X�񋟑̐��������Z���f�����擾���܂��B
   * @return �T�[�r�X�񋟑̐��������Z���f��
   */
  protected ACListModelAdapter getServiceProvisionStructuralAddRadioModel(){
    if(serviceProvisionStructuralAddRadioModel==null){
      serviceProvisionStructuralAddRadioModel = new ACListModelAdapter();
      addServiceProvisionStructuralAddRadioModel();
    }
    return serviceProvisionStructuralAddRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getServiceProvisionStructuralAddRadioItem1(){
    if(serviceProvisionStructuralAddRadioItem1==null){

      serviceProvisionStructuralAddRadioItem1 = new ACRadioButtonItem();

      serviceProvisionStructuralAddRadioItem1.setText("�Ȃ�");

      serviceProvisionStructuralAddRadioItem1.setGroup(getServiceProvisionStructuralAddRadio());

      serviceProvisionStructuralAddRadioItem1.setConstraints(VRLayout.FLOW);

      addServiceProvisionStructuralAddRadioItem1();
    }
    return serviceProvisionStructuralAddRadioItem1;

  }

  /**
   * I�^���擾���܂��B
   * @return I�^
   */
  public ACRadioButtonItem getServiceProvisionStructuralAddRadioItem2(){
    if(serviceProvisionStructuralAddRadioItem2==null){

      serviceProvisionStructuralAddRadioItem2 = new ACRadioButtonItem();

      serviceProvisionStructuralAddRadioItem2.setText("I�^");

      serviceProvisionStructuralAddRadioItem2.setGroup(getServiceProvisionStructuralAddRadio());

      serviceProvisionStructuralAddRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

      addServiceProvisionStructuralAddRadioItem2();
    }
    return serviceProvisionStructuralAddRadioItem2;

  }

  /**
   * II�^���擾���܂��B
   * @return II�^
   */
  public ACRadioButtonItem getServiceProvisionStructuralAddRadioItem3(){
    if(serviceProvisionStructuralAddRadioItem3==null){

      serviceProvisionStructuralAddRadioItem3 = new ACRadioButtonItem();

      serviceProvisionStructuralAddRadioItem3.setText("II�^");

      serviceProvisionStructuralAddRadioItem3.setGroup(getServiceProvisionStructuralAddRadio());

      serviceProvisionStructuralAddRadioItem3.setConstraints(VRLayout.FLOW);

      addServiceProvisionStructuralAddRadioItem3();
    }
    return serviceProvisionStructuralAddRadioItem3;

  }

  /**
   * III�^���擾���܂��B
   * @return III�^
   */
  public ACRadioButtonItem getServiceProvisionStructuralAddRadioItem4(){
    if(serviceProvisionStructuralAddRadioItem4==null){

      serviceProvisionStructuralAddRadioItem4 = new ACRadioButtonItem();

      serviceProvisionStructuralAddRadioItem4.setText("III�^");

      serviceProvisionStructuralAddRadioItem4.setGroup(getServiceProvisionStructuralAddRadio());

      serviceProvisionStructuralAddRadioItem4.setConstraints(VRLayout.FLOW);

      addServiceProvisionStructuralAddRadioItem4();
    }
    return serviceProvisionStructuralAddRadioItem4;

  }

  /**
   * ���ʊǗ����Z���擾���܂��B
   * @return ���ʊǗ����Z
   */
  public ACValueArrayRadioButtonGroup getSpecialManagementRadio(){
    if(specialManagementRadio==null){

      specialManagementRadio = new ACValueArrayRadioButtonGroup();

      getSpecialManagementRadioContainer().setText("���ʊǗ����Z");

      specialManagementRadio.setBindPath("1770109");

      specialManagementRadio.setUseClearButton(false);

      specialManagementRadio.setModel(getSpecialManagementRadioModel());

      specialManagementRadio.setValues(new int[]{1,2,3});

      addSpecialManagementRadio();
    }
    return specialManagementRadio;

  }

  /**
   * ���ʊǗ����Z�R���e�i���擾���܂��B
   * @return ���ʊǗ����Z�R���e�i
   */
  protected ACLabelContainer getSpecialManagementRadioContainer(){
    if(specialManagementRadioContainer==null){
      specialManagementRadioContainer = new ACLabelContainer();
      specialManagementRadioContainer.setFollowChildEnabled(true);
      specialManagementRadioContainer.setVAlignment(VRLayout.CENTER);
      specialManagementRadioContainer.add(getSpecialManagementRadio(), null);
    }
    return specialManagementRadioContainer;
  }

  /**
   * ���ʊǗ����Z���f�����擾���܂��B
   * @return ���ʊǗ����Z���f��
   */
  protected ACListModelAdapter getSpecialManagementRadioModel(){
    if(specialManagementRadioModel==null){
      specialManagementRadioModel = new ACListModelAdapter();
      addSpecialManagementRadioModel();
    }
    return specialManagementRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getSpecialManagementRadioItem1(){
    if(specialManagementRadioItem1==null){

      specialManagementRadioItem1 = new ACRadioButtonItem();

      specialManagementRadioItem1.setText("�Ȃ�");

      specialManagementRadioItem1.setGroup(getSpecialManagementRadio());

      specialManagementRadioItem1.setConstraints(VRLayout.FLOW);

      addSpecialManagementRadioItem1();
    }
    return specialManagementRadioItem1;

  }

  /**
   * I�^���擾���܂��B
   * @return I�^
   */
  public ACRadioButtonItem getSpecialManagementRadioItem2(){
    if(specialManagementRadioItem2==null){

      specialManagementRadioItem2 = new ACRadioButtonItem();

      specialManagementRadioItem2.setText("I�^");

      specialManagementRadioItem2.setGroup(getSpecialManagementRadio());

      specialManagementRadioItem2.setConstraints(VRLayout.FLOW);

      addSpecialManagementRadioItem2();
    }
    return specialManagementRadioItem2;

  }

  /**
   * II�^���擾���܂��B
   * @return II�^
   */
  public ACRadioButtonItem getSpecialManagementRadioItem3(){
    if(specialManagementRadioItem3==null){

      specialManagementRadioItem3 = new ACRadioButtonItem();

      specialManagementRadioItem3.setText("II�^");

      specialManagementRadioItem3.setGroup(getSpecialManagementRadio());

      specialManagementRadioItem3.setConstraints(VRLayout.FLOW);

      addSpecialManagementRadioItem3();
    }
    return specialManagementRadioItem3;

  }

  /**
   * �^�[�~�i���P�A���Z���擾���܂��B
   * @return �^�[�~�i���P�A���Z
   */
  public ACValueArrayRadioButtonGroup getTerminalCareAddRadio(){
    if(terminalCareAddRadio==null){

      terminalCareAddRadio = new ACValueArrayRadioButtonGroup();

      getTerminalCareAddRadioContainer().setText("�^�[�~�i���P�A���Z");

      terminalCareAddRadio.setBindPath("1770110");

      terminalCareAddRadio.setUseClearButton(false);

      terminalCareAddRadio.setModel(getTerminalCareAddRadioModel());

      terminalCareAddRadio.setValues(new int[]{1,2});

      addTerminalCareAddRadio();
    }
    return terminalCareAddRadio;

  }

  /**
   * �^�[�~�i���P�A���Z�R���e�i���擾���܂��B
   * @return �^�[�~�i���P�A���Z�R���e�i
   */
  protected ACLabelContainer getTerminalCareAddRadioContainer(){
    if(terminalCareAddRadioContainer==null){
      terminalCareAddRadioContainer = new ACLabelContainer();
      terminalCareAddRadioContainer.setFollowChildEnabled(true);
      terminalCareAddRadioContainer.setVAlignment(VRLayout.CENTER);
      terminalCareAddRadioContainer.add(getTerminalCareAddRadio(), null);
    }
    return terminalCareAddRadioContainer;
  }

  /**
   * �^�[�~�i���P�A���Z���f�����擾���܂��B
   * @return �^�[�~�i���P�A���Z���f��
   */
  protected ACListModelAdapter getTerminalCareAddRadioModel(){
    if(terminalCareAddRadioModel==null){
      terminalCareAddRadioModel = new ACListModelAdapter();
      addTerminalCareAddRadioModel();
    }
    return terminalCareAddRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getTerminalCareAddRadioItem1(){
    if(terminalCareAddRadioItem1==null){

      terminalCareAddRadioItem1 = new ACRadioButtonItem();

      terminalCareAddRadioItem1.setText("�Ȃ�");

      terminalCareAddRadioItem1.setGroup(getTerminalCareAddRadio());

      terminalCareAddRadioItem1.setConstraints(VRLayout.FLOW);

      addTerminalCareAddRadioItem1();
    }
    return terminalCareAddRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getTerminalCareAddRadioItem2(){
    if(terminalCareAddRadioItem2==null){

      terminalCareAddRadioItem2 = new ACRadioButtonItem();

      terminalCareAddRadioItem2.setText("����");

      terminalCareAddRadioItem2.setGroup(getTerminalCareAddRadio());

      terminalCareAddRadioItem2.setConstraints(VRLayout.FLOW);

      addTerminalCareAddRadioItem2();
    }
    return terminalCareAddRadioItem2;

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
   * �����^�s�����Ǝ����Z���擾���܂��B
   * @return �����^�s�����Ǝ����Z
   */
  public ACComboBox getServiceMunicipalityAdd(){
    if(serviceMunicipalityAdd==null){

      serviceMunicipalityAdd = new ACComboBox();

      getServiceMunicipalityAddContainer().setText("�����^�s�����Ǝ����Z");

      serviceMunicipalityAdd.setBindPath("1770112");

      serviceMunicipalityAdd.setEditable(false);

      serviceMunicipalityAdd.setModelBindPath("1770112");

      serviceMunicipalityAdd.setRenderBindPath("CONTENT");

      serviceMunicipalityAdd.setBlankable(false);

      serviceMunicipalityAdd.setModel(getServiceMunicipalityAddModel());

      addServiceMunicipalityAdd();
    }
    return serviceMunicipalityAdd;

  }

  /**
   * �����^�s�����Ǝ����Z�R���e�i���擾���܂��B
   * @return �����^�s�����Ǝ����Z�R���e�i
   */
  protected ACLabelContainer getServiceMunicipalityAddContainer(){
    if(serviceMunicipalityAddContainer==null){
      serviceMunicipalityAddContainer = new ACLabelContainer();
      serviceMunicipalityAddContainer.setFollowChildEnabled(true);
      serviceMunicipalityAddContainer.setVAlignment(VRLayout.CENTER);
      serviceMunicipalityAddContainer.add(getServiceMunicipalityAdd(), null);
    }
    return serviceMunicipalityAddContainer;
  }

  /**
   * �����^�s�����Ǝ����Z���f�����擾���܂��B
   * @return �����^�s�����Ǝ����Z���f��
   */
  protected ACComboBoxModelAdapter getServiceMunicipalityAddModel(){
    if(serviceMunicipalityAddModel==null){
      serviceMunicipalityAddModel = new ACComboBoxModelAdapter();
      addServiceMunicipalityAddModel();
    }
    return serviceMunicipalityAddModel;
  }

  /**
   * �K��Ō쌸�Z���擾���܂��B
   * @return �K��Ō쌸�Z
   */
  public ACValueArrayRadioButtonGroup getSubtractVisitingNurseRadioGroup(){
    if(subtractVisitingNurseRadioGroup==null){

      subtractVisitingNurseRadioGroup = new ACValueArrayRadioButtonGroup();

      getSubtractVisitingNurseRadioGroupContainer().setText("�K��Ō쌸�Z");

      subtractVisitingNurseRadioGroup.setBindPath("1770113");

      subtractVisitingNurseRadioGroup.setUseClearButton(false);

      subtractVisitingNurseRadioGroup.setModel(getSubtractVisitingNurseRadioGroupModel());

      subtractVisitingNurseRadioGroup.setValues(new int[]{1,2});

      addSubtractVisitingNurseRadioGroup();
    }
    return subtractVisitingNurseRadioGroup;

  }

  /**
   * �K��Ō쌸�Z�R���e�i���擾���܂��B
   * @return �K��Ō쌸�Z�R���e�i
   */
  protected ACLabelContainer getSubtractVisitingNurseRadioGroupContainer(){
    if(subtractVisitingNurseRadioGroupContainer==null){
      subtractVisitingNurseRadioGroupContainer = new ACLabelContainer();
      subtractVisitingNurseRadioGroupContainer.setFollowChildEnabled(true);
      subtractVisitingNurseRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      subtractVisitingNurseRadioGroupContainer.add(getSubtractVisitingNurseRadioGroup(), null);
    }
    return subtractVisitingNurseRadioGroupContainer;
  }

  /**
   * �K��Ō쌸�Z���f�����擾���܂��B
   * @return �K��Ō쌸�Z���f��
   */
  protected ACListModelAdapter getSubtractVisitingNurseRadioGroupModel(){
    if(subtractVisitingNurseRadioGroupModel==null){
      subtractVisitingNurseRadioGroupModel = new ACListModelAdapter();
      addSubtractVisitingNurseRadioGroupModel();
    }
    return subtractVisitingNurseRadioGroupModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getSubtractVisitingNurseRadioItem1(){
    if(subtractVisitingNurseRadioItem1==null){

      subtractVisitingNurseRadioItem1 = new ACRadioButtonItem();

      subtractVisitingNurseRadioItem1.setText("�Ȃ�");

      subtractVisitingNurseRadioItem1.setGroup(getSubtractVisitingNurseRadioGroup());

      subtractVisitingNurseRadioItem1.setConstraints(VRLayout.FLOW);

      addSubtractVisitingNurseRadioItem1();
    }
    return subtractVisitingNurseRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getSubtractVisitingNurseRadioItem2(){
    if(subtractVisitingNurseRadioItem2==null){

      subtractVisitingNurseRadioItem2 = new ACRadioButtonItem();

      subtractVisitingNurseRadioItem2.setText("����");

      subtractVisitingNurseRadioItem2.setGroup(getSubtractVisitingNurseRadioGroup());

      subtractVisitingNurseRadioItem2.setConstraints(VRLayout.FLOW);

      addSubtractVisitingNurseRadioItem2();
    }
    return subtractVisitingNurseRadioItem2;

  }

  /**
   * �K��Ō���ʎw�����Z���擾���܂��B
   * @return �K��Ō���ʎw�����Z
   */
  public ACValueArrayRadioButtonGroup getSubtractSpecialVisitingNursingSupportRadioGroup(){
    if(subtractSpecialVisitingNursingSupportRadioGroup==null){

      subtractSpecialVisitingNursingSupportRadioGroup = new ACValueArrayRadioButtonGroup();

      getSubtractSpecialVisitingNursingSupportRadioGroupContainer().setText("�K��Ō���ʎw�����Z");

      subtractSpecialVisitingNursingSupportRadioGroup.setBindPath("1770114");

      subtractSpecialVisitingNursingSupportRadioGroup.setUseClearButton(false);

      subtractSpecialVisitingNursingSupportRadioGroup.setModel(getSubtractSpecialVisitingNursingSupportRadioGroupModel());

      subtractSpecialVisitingNursingSupportRadioGroup.setValues(new int[]{1,2});

      addSubtractSpecialVisitingNursingSupportRadioGroup();
    }
    return subtractSpecialVisitingNursingSupportRadioGroup;

  }

  /**
   * �K��Ō���ʎw�����Z�R���e�i���擾���܂��B
   * @return �K��Ō���ʎw�����Z�R���e�i
   */
  protected ACLabelContainer getSubtractSpecialVisitingNursingSupportRadioGroupContainer(){
    if(subtractSpecialVisitingNursingSupportRadioGroupContainer==null){
      subtractSpecialVisitingNursingSupportRadioGroupContainer = new ACLabelContainer();
      subtractSpecialVisitingNursingSupportRadioGroupContainer.setFollowChildEnabled(true);
      subtractSpecialVisitingNursingSupportRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      subtractSpecialVisitingNursingSupportRadioGroupContainer.add(getSubtractSpecialVisitingNursingSupportRadioGroup(), null);
    }
    return subtractSpecialVisitingNursingSupportRadioGroupContainer;
  }

  /**
   * �K��Ō���ʎw�����Z���f�����擾���܂��B
   * @return �K��Ō���ʎw�����Z���f��
   */
  protected ACListModelAdapter getSubtractSpecialVisitingNursingSupportRadioGroupModel(){
    if(subtractSpecialVisitingNursingSupportRadioGroupModel==null){
      subtractSpecialVisitingNursingSupportRadioGroupModel = new ACListModelAdapter();
      addSubtractSpecialVisitingNursingSupportRadioGroupModel();
    }
    return subtractSpecialVisitingNursingSupportRadioGroupModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getSubtractSpecialVisitingNursingSupportRadioItem1(){
    if(subtractSpecialVisitingNursingSupportRadioItem1==null){

      subtractSpecialVisitingNursingSupportRadioItem1 = new ACRadioButtonItem();

      subtractSpecialVisitingNursingSupportRadioItem1.setText("�Ȃ�");

      subtractSpecialVisitingNursingSupportRadioItem1.setGroup(getSubtractSpecialVisitingNursingSupportRadioGroup());

      subtractSpecialVisitingNursingSupportRadioItem1.setConstraints(VRLayout.FLOW);

      addSubtractSpecialVisitingNursingSupportRadioItem1();
    }
    return subtractSpecialVisitingNursingSupportRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getSubtractSpecialVisitingNursingSupportRadioItem2(){
    if(subtractSpecialVisitingNursingSupportRadioItem2==null){

      subtractSpecialVisitingNursingSupportRadioItem2 = new ACRadioButtonItem();

      subtractSpecialVisitingNursingSupportRadioItem2.setText("����");

      subtractSpecialVisitingNursingSupportRadioItem2.setGroup(getSubtractSpecialVisitingNursingSupportRadioGroup());

      subtractSpecialVisitingNursingSupportRadioItem2.setConstraints(VRLayout.FLOW);

      addSubtractSpecialVisitingNursingSupportRadioItem2();
    }
    return subtractSpecialVisitingNursingSupportRadioItem2;

  }

  /**
   * ���x�������R���e�i���擾���܂��B
   * @return ���x�������R���e�i
   */
  public ACGroupBox getKaigoSupportSpecialMemberContainer(){
    if(kaigoSupportSpecialMemberContainer==null){

      kaigoSupportSpecialMemberContainer = new ACGroupBox();

      kaigoSupportSpecialMemberContainer.setText("���x���������");

      kaigoSupportSpecialMemberContainer.setFollowChildEnabled(true);

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

      kaigoSupportSpecialMemberNumber.setBindPath("1770116");

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
   * �E�v�������O���[�v���擾���܂��B
   * @return �E�v�������O���[�v
   */
  public ACGroupBox getTekiyouGroup(){
    if(tekiyouGroup==null){

      tekiyouGroup = new ACGroupBox();

      tekiyouGroup.setText("�E�v��");

      tekiyouGroup.setVisible(true);

      tekiyouGroup.setEnabled(true);

      tekiyouGroup.setFollowChildEnabled(true);

      tekiyouGroup.setHgap(0);

      tekiyouGroup.setLabelMargin(0);

      tekiyouGroup.setVgap(0);

      addTekiyouGroup();
    }
    return tekiyouGroup;

  }

  /**
   * �E�v���e�L�X�g���擾���܂��B
   * @return �E�v���e�L�X�g
   */
  public ACTextField getTekiyouText(){
    if(tekiyouText==null){

      tekiyouText = new ACTextField();

      getTekiyouTextContainer().setText("�Ō�ʏ��K��h������");

      tekiyouText.setBindPath("1770117");

      tekiyouText.setVisible(true);

      tekiyouText.setEnabled(true);

      tekiyouText.setEditable(true);

      tekiyouText.setColumns(6);

      tekiyouText.setCharType(VRCharType.ONLY_DIGIT);

      tekiyouText.setHorizontalAlignment(SwingConstants.LEFT);

      tekiyouText.setIMEMode(InputSubset.LATIN);

      tekiyouText.setMaxLength(8);

      addTekiyouText();
    }
    return tekiyouText;

  }

  /**
   * �E�v���e�L�X�g�R���e�i���擾���܂��B
   * @return �E�v���e�L�X�g�R���e�i
   */
  protected ACLabelContainer getTekiyouTextContainer(){
    if(tekiyouTextContainer==null){
      tekiyouTextContainer = new ACLabelContainer();
      tekiyouTextContainer.setFollowChildEnabled(true);
      tekiyouTextContainer.setVAlignment(VRLayout.CENTER);
      tekiyouTextContainer.add(getTekiyouText(), null);
    }
    return tekiyouTextContainer;
  }

  /**
   * �E�v���������x�����擾���܂��B
   * @return �E�v���������x��
   */
  public ACLabel getTekiyouCommentTitle(){
    if(tekiyouCommentTitle==null){

      tekiyouCommentTitle = new ACLabel();

      tekiyouCommentTitle.setText("���̈�ԍŏ��̗��p���ɋL�����Ă��������B");

      tekiyouCommentTitle.setIconPath(ACConstants.ICON_PATH_EXCLAMATION_16);

      tekiyouCommentTitle.setAutoWrap(true);

      addTekiyouCommentTitle();
    }
    return tekiyouCommentTitle;

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
   * �������擾���܂��B
   * @return ����
   */
  public ACIntegerCheckBox getCrackOnDayCheck(){
    if(crackOnDayCheck==null){

      crackOnDayCheck = new ACIntegerCheckBox();

      crackOnDayCheck.setText("����");

      crackOnDayCheck.setBindPath("1770115");

      crackOnDayCheck.setSelectValue(2);

      crackOnDayCheck.setUnSelectValue(1);

      addCrackOnDayCheck();
    }
    return crackOnDayCheck;

  }

  /**
   * �񋟓����擾���܂��B
   * @return �񋟓�
   */
  public ACIntegerCheckBox getPrintable(){
    if(printable==null){

      printable = new ACIntegerCheckBox();

      printable.setText("�񋟓�");

      printable.setBindPath("15");

      printable.setSelectValue(2);

      printable.setUnSelectValue(1);

      addPrintable();
    }
    return printable;

  }

  /**
   * �񋟎��ԃR���e�i���擾���܂��B
   * @return �񋟎��ԃR���e�i
   */
  public ACBackLabelContainer getHomonNyuyokuTimeContainer(){
    if(homonNyuyokuTimeContainer==null){

      homonNyuyokuTimeContainer = new ACBackLabelContainer();

      homonNyuyokuTimeContainer.setFollowChildEnabled(true);

      addHomonNyuyokuTimeContainer();
    }
    return homonNyuyokuTimeContainer;

  }

  /**
   * �J�n�����R���{���擾���܂��B
   * @return �J�n�����R���{
   */
  public ACTimeComboBox getHomonNyuyokuBeginTime(){
    if(homonNyuyokuBeginTime==null){

      homonNyuyokuBeginTime = new ACTimeComboBox();

      getHomonNyuyokuBeginTimeContainer().setText("�J�n����");

      homonNyuyokuBeginTime.setBindPath("3");

      homonNyuyokuBeginTime.setModelBindPath("3");

      homonNyuyokuBeginTime.setRenderBindPath("CONTENT");

      homonNyuyokuBeginTime.setModel(getHomonNyuyokuBeginTimeModel());

      addHomonNyuyokuBeginTime();
    }
    return homonNyuyokuBeginTime;

  }

  /**
   * �J�n�����R���{�R���e�i���擾���܂��B
   * @return �J�n�����R���{�R���e�i
   */
  protected ACLabelContainer getHomonNyuyokuBeginTimeContainer(){
    if(homonNyuyokuBeginTimeContainer==null){
      homonNyuyokuBeginTimeContainer = new ACLabelContainer();
      homonNyuyokuBeginTimeContainer.setFollowChildEnabled(true);
      homonNyuyokuBeginTimeContainer.setVAlignment(VRLayout.CENTER);
      homonNyuyokuBeginTimeContainer.add(getHomonNyuyokuBeginTime(), null);
    }
    return homonNyuyokuBeginTimeContainer;
  }

  /**
   * �J�n�����R���{���f�����擾���܂��B
   * @return �J�n�����R���{���f��
   */
  protected ACComboBoxModelAdapter getHomonNyuyokuBeginTimeModel(){
    if(homonNyuyokuBeginTimeModel==null){
      homonNyuyokuBeginTimeModel = new ACComboBoxModelAdapter();
      addHomonNyuyokuBeginTimeModel();
    }
    return homonNyuyokuBeginTimeModel;
  }

  /**
   * �I�������R���{���擾���܂��B
   * @return �I�������R���{
   */
  public ACTimeComboBox getHomonNyuyokuEndTime(){
    if(homonNyuyokuEndTime==null){

      homonNyuyokuEndTime = new ACTimeComboBox();

      getHomonNyuyokuEndTimeContainer().setText("�I������");

      homonNyuyokuEndTime.setBindPath("4");

      homonNyuyokuEndTime.setModelBindPath("4");

      homonNyuyokuEndTime.setRenderBindPath("CONTENT");

      homonNyuyokuEndTime.setModel(getHomonNyuyokuEndTimeModel());

      addHomonNyuyokuEndTime();
    }
    return homonNyuyokuEndTime;

  }

  /**
   * �I�������R���{�R���e�i���擾���܂��B
   * @return �I�������R���{�R���e�i
   */
  protected ACLabelContainer getHomonNyuyokuEndTimeContainer(){
    if(homonNyuyokuEndTimeContainer==null){
      homonNyuyokuEndTimeContainer = new ACLabelContainer();
      homonNyuyokuEndTimeContainer.setFollowChildEnabled(true);
      homonNyuyokuEndTimeContainer.setVAlignment(VRLayout.CENTER);
      homonNyuyokuEndTimeContainer.add(getHomonNyuyokuEndTime(), null);
    }
    return homonNyuyokuEndTimeContainer;
  }

  /**
   * �I�������R���{���f�����擾���܂��B
   * @return �I�������R���{���f��
   */
  protected ACComboBoxModelAdapter getHomonNyuyokuEndTimeModel(){
    if(homonNyuyokuEndTimeModel==null){
      homonNyuyokuEndTimeModel = new ACComboBoxModelAdapter();
      addHomonNyuyokuEndTimeModel();
    }
    return homonNyuyokuEndTimeModel;
  }

  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001_17711_201204Design() {

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

    this.add(getMainGroup(), VRLayout.CLIENT);

  }

  /**
   * �p�^�[���̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMainGroup(){

    mainGroup.add(getTab(), VRLayout.CLIENT);

  }

  /**
   * �^�u�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTab(){

    tab.addTab("1", getTab1());

    tab.addTab("2", getTab2());

  }

  /**
   * �^�u1�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTab1(){

    tab1.add(getStaffSubtractionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getSmallServiceRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getInitialAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getDementiaRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getLeavingHospitalGuidanceAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getBusinessBeginnerAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getUrgentTimeAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getServiceProvisionStructuralAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getSpecialManagementRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getTerminalCareAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * �l�����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffSubtractionRadio(){

  }

  /**
   * �l�����Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffSubtractionRadioModel(){

    getStaffSubtractionRadioItem1().setButtonIndex(1);

    getStaffSubtractionRadioModel().add(getStaffSubtractionRadioItem1());

    getStaffSubtractionRadioItem2().setButtonIndex(2);

    getStaffSubtractionRadioModel().add(getStaffSubtractionRadioItem2());

    getStaffSubtractionRadioItem3().setButtonIndex(3);

    getStaffSubtractionRadioModel().add(getStaffSubtractionRadioItem3());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffSubtractionRadioItem1(){

  }

  /**
   * ������߂ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffSubtractionRadioItem2(){

  }

  /**
   * �]�ƈ��̕s���ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffSubtractionRadioItem3(){

  }

  /**
   * �ߏ��T�[�r�X�ɑ΂��錸�Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addSmallServiceRadio(){

  }

  /**
   * �ߏ��T�[�r�X�ɑ΂��錸�Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addSmallServiceRadioModel(){

    getSmallServiceRadioItem1().setButtonIndex(1);

    getSmallServiceRadioModel().add(getSmallServiceRadioItem1());

    getSmallServiceRadioItem2().setButtonIndex(2);

    getSmallServiceRadioModel().add(getSmallServiceRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addSmallServiceRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addSmallServiceRadioItem2(){

  }

  /**
   * �������Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addInitialAddRadio(){

  }

  /**
   * �������Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addInitialAddRadioModel(){

    getInitialAddRadioItem1().setButtonIndex(1);

    getInitialAddRadioModel().add(getInitialAddRadioItem1());

    getInitialAddRadioItem2().setButtonIndex(2);

    getInitialAddRadioModel().add(getInitialAddRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addInitialAddRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addInitialAddRadioItem2(){

  }

  /**
   * �F�m�ǉ��Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addDementiaRadio(){

  }

  /**
   * �F�m�ǉ��Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addDementiaRadioModel(){

    getDementiaRadioItem1().setButtonIndex(1);

    getDementiaRadioModel().add(getDementiaRadioItem1());

    getDementiaRadioItem2().setButtonIndex(2);

    getDementiaRadioModel().add(getDementiaRadioItem2());

    getDementiaRadioItem3().setButtonIndex(3);

    getDementiaRadioModel().add(getDementiaRadioItem3());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addDementiaRadioItem1(){

  }

  /**
   * I�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addDementiaRadioItem2(){

  }

  /**
   * II�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addDementiaRadioItem3(){

  }

  /**
   * �މ@�������w�����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addLeavingHospitalGuidanceAddRadio(){

  }

  /**
   * �މ@�������w�����Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addLeavingHospitalGuidanceAddRadioModel(){

    getLeavingHospitalGuidanceAddRadioItem1().setButtonIndex(1);

    getLeavingHospitalGuidanceAddRadioModel().add(getLeavingHospitalGuidanceAddRadioItem1());

    getLeavingHospitalGuidanceAddRadioItem2().setButtonIndex(2);

    getLeavingHospitalGuidanceAddRadioModel().add(getLeavingHospitalGuidanceAddRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addLeavingHospitalGuidanceAddRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addLeavingHospitalGuidanceAddRadioItem2(){

  }

  /**
   * ���ƊJ�n���x�����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addBusinessBeginnerAddRadio(){

  }

  /**
   * ���ƊJ�n���x�����Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addBusinessBeginnerAddRadioModel(){

    getBusinessBeginnerAddRadioItem1().setButtonIndex(1);

    getBusinessBeginnerAddRadioModel().add(getBusinessBeginnerAddRadioItem1());

    getBusinessBeginnerAddRadioItem2().setButtonIndex(2);

    getBusinessBeginnerAddRadioModel().add(getBusinessBeginnerAddRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addBusinessBeginnerAddRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addBusinessBeginnerAddRadioItem2(){

  }

  /**
   * �ً}���K��Ō���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addUrgentTimeAddRadio(){

  }

  /**
   * �ً}���K��Ō���Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addUrgentTimeAddRadioModel(){

    getUrgentTimeAddRadioItem1().setButtonIndex(1);

    getUrgentTimeAddRadioModel().add(getUrgentTimeAddRadioItem1());

    getUrgentTimeAddRadioItem2().setButtonIndex(2);

    getUrgentTimeAddRadioModel().add(getUrgentTimeAddRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addUrgentTimeAddRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addUrgentTimeAddRadioItem2(){

  }

  /**
   * �T�[�r�X�񋟑̐��������Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceProvisionStructuralAddRadio(){

  }

  /**
   * �T�[�r�X�񋟑̐��������Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceProvisionStructuralAddRadioModel(){

    getServiceProvisionStructuralAddRadioItem1().setButtonIndex(1);

    getServiceProvisionStructuralAddRadioModel().add(getServiceProvisionStructuralAddRadioItem1());

    getServiceProvisionStructuralAddRadioItem2().setButtonIndex(2);

    getServiceProvisionStructuralAddRadioModel().add(getServiceProvisionStructuralAddRadioItem2());

    getServiceProvisionStructuralAddRadioItem3().setButtonIndex(3);

    getServiceProvisionStructuralAddRadioModel().add(getServiceProvisionStructuralAddRadioItem3());

    getServiceProvisionStructuralAddRadioItem4().setButtonIndex(4);

    getServiceProvisionStructuralAddRadioModel().add(getServiceProvisionStructuralAddRadioItem4());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceProvisionStructuralAddRadioItem1(){

  }

  /**
   * I�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceProvisionStructuralAddRadioItem2(){

  }

  /**
   * II�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceProvisionStructuralAddRadioItem3(){

  }

  /**
   * III�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceProvisionStructuralAddRadioItem4(){

  }

  /**
   * ���ʊǗ����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addSpecialManagementRadio(){

  }

  /**
   * ���ʊǗ����Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addSpecialManagementRadioModel(){

    getSpecialManagementRadioItem1().setButtonIndex(1);

    getSpecialManagementRadioModel().add(getSpecialManagementRadioItem1());

    getSpecialManagementRadioItem2().setButtonIndex(2);

    getSpecialManagementRadioModel().add(getSpecialManagementRadioItem2());

    getSpecialManagementRadioItem3().setButtonIndex(3);

    getSpecialManagementRadioModel().add(getSpecialManagementRadioItem3());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addSpecialManagementRadioItem1(){

  }

  /**
   * I�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addSpecialManagementRadioItem2(){

  }

  /**
   * II�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addSpecialManagementRadioItem3(){

  }

  /**
   * �^�[�~�i���P�A���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTerminalCareAddRadio(){

  }

  /**
   * �^�[�~�i���P�A���Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addTerminalCareAddRadioModel(){

    getTerminalCareAddRadioItem1().setButtonIndex(1);

    getTerminalCareAddRadioModel().add(getTerminalCareAddRadioItem1());

    getTerminalCareAddRadioItem2().setButtonIndex(2);

    getTerminalCareAddRadioModel().add(getTerminalCareAddRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addTerminalCareAddRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addTerminalCareAddRadioItem2(){

  }

  /**
   * �^�u2�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTab2(){

    tab2.add(getServiceMunicipalityAddContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getSubtractVisitingNurseRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getSubtractSpecialVisitingNursingSupportRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getKaigoSupportSpecialMemberContainer(), VRLayout.FLOW_RETURN);

    tab2.add(getTekiyouGroup(), VRLayout.FLOW_RETURN);

    tab2.add(getCalculationDivisionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getCrackOnDayCheck(), VRLayout.FLOW);

    tab2.add(getPrintable(), VRLayout.FLOW_RETURN);

    tab2.add(getHomonNyuyokuTimeContainer(), VRLayout.FLOW_DOUBLEINSETLINE_RETURN);

  }

  /**
   * �����^�s�����Ǝ����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceMunicipalityAdd(){

  }

  /**
   * �����^�s�����Ǝ����Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceMunicipalityAddModel(){

  }

  /**
   * �K��Ō쌸�Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addSubtractVisitingNurseRadioGroup(){

  }

  /**
   * �K��Ō쌸�Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addSubtractVisitingNurseRadioGroupModel(){

    getSubtractVisitingNurseRadioItem1().setButtonIndex(1);

    getSubtractVisitingNurseRadioGroupModel().add(getSubtractVisitingNurseRadioItem1());

    getSubtractVisitingNurseRadioItem2().setButtonIndex(2);

    getSubtractVisitingNurseRadioGroupModel().add(getSubtractVisitingNurseRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addSubtractVisitingNurseRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addSubtractVisitingNurseRadioItem2(){

  }

  /**
   * �K��Ō���ʎw�����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addSubtractSpecialVisitingNursingSupportRadioGroup(){

  }

  /**
   * �K��Ō���ʎw�����Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addSubtractSpecialVisitingNursingSupportRadioGroupModel(){

    getSubtractSpecialVisitingNursingSupportRadioItem1().setButtonIndex(1);

    getSubtractSpecialVisitingNursingSupportRadioGroupModel().add(getSubtractSpecialVisitingNursingSupportRadioItem1());

    getSubtractSpecialVisitingNursingSupportRadioItem2().setButtonIndex(2);

    getSubtractSpecialVisitingNursingSupportRadioGroupModel().add(getSubtractSpecialVisitingNursingSupportRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addSubtractSpecialVisitingNursingSupportRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addSubtractSpecialVisitingNursingSupportRadioItem2(){

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
   * �E�v�������O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTekiyouGroup(){

    tekiyouGroup.add(getTekiyouTextContainer(), VRLayout.FLOW_RETURN);

    tekiyouGroup.add(getTekiyouCommentTitle(), VRLayout.FLOW_RETURN);

  }

  /**
   * �E�v���e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTekiyouText(){

  }

  /**
   * �E�v���������x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addTekiyouCommentTitle(){

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
   * �����ɓ������ڂ�ǉ����܂��B
   */
  protected void addCrackOnDayCheck(){

  }

  /**
   * �񋟓��ɓ������ڂ�ǉ����܂��B
   */
  protected void addPrintable(){

  }

  /**
   * �񋟎��ԃR���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHomonNyuyokuTimeContainer(){

    homonNyuyokuTimeContainer.add(getHomonNyuyokuBeginTimeContainer(), VRLayout.FLOW);

    homonNyuyokuTimeContainer.add(getHomonNyuyokuEndTimeContainer(), VRLayout.FLOW);

  }

  /**
   * �J�n�����R���{�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHomonNyuyokuBeginTime(){

  }

  /**
   * �J�n�����R���{���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addHomonNyuyokuBeginTimeModel(){

  }

  /**
   * �I�������R���{�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHomonNyuyokuEndTime(){

  }

  /**
   * �I�������R���{���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addHomonNyuyokuEndTimeModel(){

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
      ACFrame.debugStart(new ACAffairInfo(QS001_17711_201204Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QS001_17711_201204Design getThis() {
    return this;
  }
}
