
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
 * �쐬��: 2006/03/08  ���{�R���s���[�^�[������� ���{�@�K�� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���̑��@�\ (O)
 * �v���Z�X ���Ǝғo�^ (004)
 * �v���O���� �K��Ō� (QO004103)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qo.qo004;
import java.awt.Component;
import java.awt.im.InputSubset;

import javax.swing.SwingConstants;

import jp.nichicom.ac.component.ACClearableRadioButtonGroup;
import jp.nichicom.ac.component.ACLabel;
import jp.nichicom.ac.component.ACRadioButtonItem;
import jp.nichicom.ac.component.ACTextField;
import jp.nichicom.ac.container.ACGroupBox;
import jp.nichicom.ac.container.ACLabelContainer;
import jp.nichicom.ac.container.ACPanel;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.util.adapter.ACListModelAdapter;
import jp.nichicom.vr.layout.VRLayout;
import jp.nichicom.vr.text.VRCharType;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.affair.qs.qs001.QS001ServicePanel;
/**
 * �K��Ō��ʍ��ڃf�U�C��(QO004103) 
 */
public class QO004103Design extends QS001ServicePanel {
  //GUI�R���|�[�l���g

  private ACGroupBox mainGroup;

  private ACPanel calculationDetails;

  private ACClearableRadioButtonGroup facilitiesDivision;

  private ACLabelContainer facilitiesDivisionContainer;

  private ACListModelAdapter facilitiesDivisionModel;

  private ACRadioButtonItem facilitiesDivisionItem1;

  private ACRadioButtonItem facilitiesDivisionItem2;

  private ACClearableRadioButtonGroup homonkangoPressing;

  private ACLabelContainer homonkangoPressingContainer;

  private ACListModelAdapter homonkangoPressingModel;

  private ACRadioButtonItem homonkangoPressingRadioItem1;

  private ACRadioButtonItem homonkangoPressingRadioItem2;

  private ACClearableRadioButtonGroup specialManagementSystem;

  private ACLabelContainer specialManagementSystemContainer;

  private ACListModelAdapter specialManagementSystemModel;

  private ACRadioButtonItem specialManagementSystemItem1;

  private ACRadioButtonItem specialManagementSystemItem2;

  private ACClearableRadioButtonGroup terminalCare;

  private ACLabelContainer terminalCareContainer;

  private ACListModelAdapter terminalCareModel;

  private ACRadioButtonItem terminalCareItem1;

  private ACRadioButtonItem terminalCareItem2;

  private ACTextField managerName;

  private ACLabelContainer managerNameContainer;

  private ACGroupBox medicalTreatmentInsurance;

  private ACTextField stationCode;

  private ACLabelContainer stationCodeContainer;

  private ACClearableRadioButtonGroup contactAllDay;

  private ACLabelContainer contactAllDayContainer;

  private ACListModelAdapter contactAllDayModel;

  private ACRadioButtonItem contactAllDayItem1;

  private ACRadioButtonItem contactAllDayItem2;

  private ACClearableRadioButtonGroup seriousCaseManagement;

  private ACLabelContainer seriousCaseManagementContainer;

  private ACListModelAdapter seriousCaseManagementModel;

  private ACRadioButtonItem seriousCaseManagementItem1;

  private ACRadioButtonItem seriousCaseManagementItem2;

  private ACPanel calculationDetails2;

  private ACLabelContainer reduceRateContainer;

  private ACTextField reduceRate;

  private ACLabel percentSign;

  //getter

  /**
   * ���ƃO���[�v���擾���܂��B
   * @return ���ƃO���[�v
   */
  public ACGroupBox getMainGroup(){
    if(mainGroup==null){

      mainGroup = new ACGroupBox();

      mainGroup.setText("�K��Ō�");

      mainGroup.setFollowChildEnabled(true);

      mainGroup.setHgrid(200);

      addMainGroup();
    }
    return mainGroup;

  }

  /**
   * �Z�荀�ڗ̈���擾���܂��B
   * @return �Z�荀�ڗ̈�
   */
  public ACPanel getCalculationDetails(){
    if(calculationDetails==null){

      calculationDetails = new ACPanel();

      calculationDetails.setFollowChildEnabled(true);

      calculationDetails.setHgrid(200);

      addCalculationDetails();
    }
    return calculationDetails;

  }

  /**
   * �{�݋敪���W�I�O���[�v���擾���܂��B
   * @return �{�݋敪���W�I�O���[�v
   */
  public ACClearableRadioButtonGroup getFacilitiesDivision(){
    if(facilitiesDivision==null){

      facilitiesDivision = new ACClearableRadioButtonGroup();

      getFacilitiesDivisionContainer().setText("�{�ݓ��̋敪");

      facilitiesDivision.setBindPath("1130101");

      facilitiesDivision.setModel(getFacilitiesDivisionModel());

      facilitiesDivision.setUseClearButton(false);

      addFacilitiesDivision();
    }
    return facilitiesDivision;

  }

  /**
   * �{�݋敪���W�I�O���[�v�R���e�i���擾���܂��B
   * @return �{�݋敪���W�I�O���[�v�R���e�i
   */
  protected ACLabelContainer getFacilitiesDivisionContainer(){
    if(facilitiesDivisionContainer==null){
      facilitiesDivisionContainer = new ACLabelContainer();
      facilitiesDivisionContainer.setFollowChildEnabled(true);
      facilitiesDivisionContainer.setVAlignment(VRLayout.CENTER);
      facilitiesDivisionContainer.add(getFacilitiesDivision(), null);
    }
    return facilitiesDivisionContainer;
  }

  /**
   * �{�݋敪���W�I�O���[�v���f�����擾���܂��B
   * @return �{�݋敪���W�I�O���[�v���f��
   */
  protected ACListModelAdapter getFacilitiesDivisionModel(){
    if(facilitiesDivisionModel==null){
      facilitiesDivisionModel = new ACListModelAdapter();
      addFacilitiesDivisionModel();
    }
    return facilitiesDivisionModel;
  }

  /**
   * �K��Ō�X�e�[�V�������擾���܂��B
   * @return �K��Ō�X�e�[�V����
   */
  public ACRadioButtonItem getFacilitiesDivisionItem1(){
    if(facilitiesDivisionItem1==null){

      facilitiesDivisionItem1 = new ACRadioButtonItem();

      facilitiesDivisionItem1.setText("�K��Ō�X�e�[�V����");

      facilitiesDivisionItem1.setGroup(getFacilitiesDivision());

      addFacilitiesDivisionItem1();
    }
    return facilitiesDivisionItem1;

  }

  /**
   * �a�@�܂��͐f�Ï����擾���܂��B
   * @return �a�@�܂��͐f�Ï�
   */
  public ACRadioButtonItem getFacilitiesDivisionItem2(){
    if(facilitiesDivisionItem2==null){

      facilitiesDivisionItem2 = new ACRadioButtonItem();

      facilitiesDivisionItem2.setText("�a�@���͐f�Ï�");

      facilitiesDivisionItem2.setGroup(getFacilitiesDivision());

      addFacilitiesDivisionItem2();
    }
    return facilitiesDivisionItem2;

  }

  /**
   * �ً}���K��Ō���Z���擾���܂��B
   * @return �ً}���K��Ō���Z
   */
  public ACClearableRadioButtonGroup getHomonkangoPressing(){
    if(homonkangoPressing==null){

      homonkangoPressing = new ACClearableRadioButtonGroup();

      getHomonkangoPressingContainer().setText("�ً}���K��Ō���Z");

      homonkangoPressing.setBindPath("1130104");

      homonkangoPressing.setModel(getHomonkangoPressingModel());

      homonkangoPressing.setUseClearButton(false);

      addHomonkangoPressing();
    }
    return homonkangoPressing;

  }

  /**
   * �ً}���K��Ō���Z�R���e�i���擾���܂��B
   * @return �ً}���K��Ō���Z�R���e�i
   */
  protected ACLabelContainer getHomonkangoPressingContainer(){
    if(homonkangoPressingContainer==null){
      homonkangoPressingContainer = new ACLabelContainer();
      homonkangoPressingContainer.setFollowChildEnabled(true);
      homonkangoPressingContainer.setVAlignment(VRLayout.CENTER);
      homonkangoPressingContainer.add(getHomonkangoPressing(), null);
    }
    return homonkangoPressingContainer;
  }

  /**
   * �ً}���K��Ō���Z���f�����擾���܂��B
   * @return �ً}���K��Ō���Z���f��
   */
  protected ACListModelAdapter getHomonkangoPressingModel(){
    if(homonkangoPressingModel==null){
      homonkangoPressingModel = new ACListModelAdapter();
      addHomonkangoPressingModel();
    }
    return homonkangoPressingModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getHomonkangoPressingRadioItem1(){
    if(homonkangoPressingRadioItem1==null){

      homonkangoPressingRadioItem1 = new ACRadioButtonItem();

      homonkangoPressingRadioItem1.setText("�Ȃ�");

      homonkangoPressingRadioItem1.setGroup(getHomonkangoPressing());

      addHomonkangoPressingRadioItem1();
    }
    return homonkangoPressingRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getHomonkangoPressingRadioItem2(){
    if(homonkangoPressingRadioItem2==null){

      homonkangoPressingRadioItem2 = new ACRadioButtonItem();

      homonkangoPressingRadioItem2.setText("����");

      homonkangoPressingRadioItem2.setGroup(getHomonkangoPressing());

      addHomonkangoPressingRadioItem2();
    }
    return homonkangoPressingRadioItem2;

  }

  /**
   * ���ʊǗ��̐����W�I�O���[�v���擾���܂��B
   * @return ���ʊǗ��̐����W�I�O���[�v
   */
  public ACClearableRadioButtonGroup getSpecialManagementSystem(){
    if(specialManagementSystem==null){

      specialManagementSystem = new ACClearableRadioButtonGroup();

      getSpecialManagementSystemContainer().setText("���ʊǗ��̐�");

      specialManagementSystem.setBindPath("1130102");

      specialManagementSystem.setModel(getSpecialManagementSystemModel());

      specialManagementSystem.setUseClearButton(false);

      addSpecialManagementSystem();
    }
    return specialManagementSystem;

  }

  /**
   * ���ʊǗ��̐����W�I�O���[�v�R���e�i���擾���܂��B
   * @return ���ʊǗ��̐����W�I�O���[�v�R���e�i
   */
  protected ACLabelContainer getSpecialManagementSystemContainer(){
    if(specialManagementSystemContainer==null){
      specialManagementSystemContainer = new ACLabelContainer();
      specialManagementSystemContainer.setFollowChildEnabled(true);
      specialManagementSystemContainer.setVAlignment(VRLayout.CENTER);
      specialManagementSystemContainer.add(getSpecialManagementSystem(), null);
    }
    return specialManagementSystemContainer;
  }

  /**
   * ���ʊǗ��̐����W�I�O���[�v���f�����擾���܂��B
   * @return ���ʊǗ��̐����W�I�O���[�v���f��
   */
  protected ACListModelAdapter getSpecialManagementSystemModel(){
    if(specialManagementSystemModel==null){
      specialManagementSystemModel = new ACListModelAdapter();
      addSpecialManagementSystemModel();
    }
    return specialManagementSystemModel;
  }

  /**
   * �Ή��s���擾���܂��B
   * @return �Ή��s��
   */
  public ACRadioButtonItem getSpecialManagementSystemItem1(){
    if(specialManagementSystemItem1==null){

      specialManagementSystemItem1 = new ACRadioButtonItem();

      specialManagementSystemItem1.setText("�Ή��s��");

      specialManagementSystemItem1.setGroup(getSpecialManagementSystem());

      addSpecialManagementSystemItem1();
    }
    return specialManagementSystemItem1;

  }

  /**
   * �Ή����擾���܂��B
   * @return �Ή���
   */
  public ACRadioButtonItem getSpecialManagementSystemItem2(){
    if(specialManagementSystemItem2==null){

      specialManagementSystemItem2 = new ACRadioButtonItem();

      specialManagementSystemItem2.setText("�Ή���");

      specialManagementSystemItem2.setGroup(getSpecialManagementSystem());

      addSpecialManagementSystemItem2();
    }
    return specialManagementSystemItem2;

  }

  /**
   * �^�[�~�i���P�A�̐����W�I�O���[�v���擾���܂��B
   * @return �^�[�~�i���P�A�̐����W�I�O���[�v
   */
  public ACClearableRadioButtonGroup getTerminalCare(){
    if(terminalCare==null){

      terminalCare = new ACClearableRadioButtonGroup();

      getTerminalCareContainer().setText("�^�[�~�i���P�A�̐�");

      terminalCare.setBindPath("1130105");

      terminalCare.setModel(getTerminalCareModel());

      terminalCare.setUseClearButton(false);

      addTerminalCare();
    }
    return terminalCare;

  }

  /**
   * �^�[�~�i���P�A�̐����W�I�O���[�v�R���e�i���擾���܂��B
   * @return �^�[�~�i���P�A�̐����W�I�O���[�v�R���e�i
   */
  protected ACLabelContainer getTerminalCareContainer(){
    if(terminalCareContainer==null){
      terminalCareContainer = new ACLabelContainer();
      terminalCareContainer.setFollowChildEnabled(true);
      terminalCareContainer.setVAlignment(VRLayout.CENTER);
      terminalCareContainer.add(getTerminalCare(), null);
    }
    return terminalCareContainer;
  }

  /**
   * �^�[�~�i���P�A�̐����W�I�O���[�v���f�����擾���܂��B
   * @return �^�[�~�i���P�A�̐����W�I�O���[�v���f��
   */
  protected ACListModelAdapter getTerminalCareModel(){
    if(terminalCareModel==null){
      terminalCareModel = new ACListModelAdapter();
      addTerminalCareModel();
    }
    return terminalCareModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getTerminalCareItem1(){
    if(terminalCareItem1==null){

      terminalCareItem1 = new ACRadioButtonItem();

      terminalCareItem1.setText("�Ȃ�");

      terminalCareItem1.setGroup(getTerminalCare());

      addTerminalCareItem1();
    }
    return terminalCareItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getTerminalCareItem2(){
    if(terminalCareItem2==null){

      terminalCareItem2 = new ACRadioButtonItem();

      terminalCareItem2.setText("����");

      terminalCareItem2.setGroup(getTerminalCare());

      addTerminalCareItem2();
    }
    return terminalCareItem2;

  }

  /**
   * �Ǘ��Ҏ������擾���܂��B
   * @return �Ǘ��Ҏ���
   */
  public ACTextField getManagerName(){
    if(managerName==null){

      managerName = new ACTextField();

      getManagerNameContainer().setText("�Ǘ��Ҏ���");

      managerName.setBindPath("1130103");

      managerName.setColumns(11);

      managerName.setIMEMode(InputSubset.KANJI);

      managerName.setMaxLength(10);

      addManagerName();
    }
    return managerName;

  }

  /**
   * �Ǘ��Ҏ����R���e�i���擾���܂��B
   * @return �Ǘ��Ҏ����R���e�i
   */
  protected ACLabelContainer getManagerNameContainer(){
    if(managerNameContainer==null){
      managerNameContainer = new ACLabelContainer();
      managerNameContainer.setFollowChildEnabled(true);
      managerNameContainer.setVAlignment(VRLayout.CENTER);
      managerNameContainer.add(getManagerName(), null);
    }
    return managerNameContainer;
  }

  /**
   * ������Õی����������擾���܂��B
   * @return ������Õی�������
   */
  public ACGroupBox getMedicalTreatmentInsurance(){
    if(medicalTreatmentInsurance==null){

      medicalTreatmentInsurance = new ACGroupBox();

      medicalTreatmentInsurance.setText("��Õی���");

      medicalTreatmentInsurance.setFollowChildEnabled(true);

      addMedicalTreatmentInsurance();
    }
    return medicalTreatmentInsurance;

  }

  /**
   * �X�e�[�V�����R�[�h���擾���܂��B
   * @return �X�e�[�V�����R�[�h
   */
  public ACTextField getStationCode(){
    if(stationCode==null){

      stationCode = new ACTextField();

      getStationCodeContainer().setText("�X�e�[�V�����R�[�h");

      stationCode.setBindPath("2010101");

      stationCode.setCharType(VRCharType.ONLY_DIGIT);

      stationCode.setColumns(5);

      stationCode.setIMEMode(InputSubset.LATIN);

      stationCode.setMaxLength(7);

      addStationCode();
    }
    return stationCode;

  }

  /**
   * �X�e�[�V�����R�[�h�R���e�i���擾���܂��B
   * @return �X�e�[�V�����R�[�h�R���e�i
   */
  protected ACLabelContainer getStationCodeContainer(){
    if(stationCodeContainer==null){
      stationCodeContainer = new ACLabelContainer();
      stationCodeContainer.setFollowChildEnabled(true);
      stationCodeContainer.setVAlignment(VRLayout.CENTER);
      stationCodeContainer.add(getStationCode(), null);
    }
    return stationCodeContainer;
  }

  /**
   * 24���ԘA���̐����Z���W�I�O���[�v���擾���܂��B
   * @return 24���ԘA���̐����Z���W�I�O���[�v
   */
  public ACClearableRadioButtonGroup getContactAllDay(){
    if(contactAllDay==null){

      contactAllDay = new ACClearableRadioButtonGroup();

      getContactAllDayContainer().setText("24���ԘA���̐����Z");

      contactAllDay.setBindPath("2010102");

      contactAllDay.setModel(getContactAllDayModel());

      contactAllDay.setUseClearButton(false);

      addContactAllDay();
    }
    return contactAllDay;

  }

  /**
   * 24���ԘA���̐����Z���W�I�O���[�v�R���e�i���擾���܂��B
   * @return 24���ԘA���̐����Z���W�I�O���[�v�R���e�i
   */
  protected ACLabelContainer getContactAllDayContainer(){
    if(contactAllDayContainer==null){
      contactAllDayContainer = new ACLabelContainer();
      contactAllDayContainer.setFollowChildEnabled(true);
      contactAllDayContainer.setVAlignment(VRLayout.CENTER);
      contactAllDayContainer.add(getContactAllDay(), null);
    }
    return contactAllDayContainer;
  }

  /**
   * 24���ԘA���̐����Z���W�I�O���[�v���f�����擾���܂��B
   * @return 24���ԘA���̐����Z���W�I�O���[�v���f��
   */
  protected ACListModelAdapter getContactAllDayModel(){
    if(contactAllDayModel==null){
      contactAllDayModel = new ACListModelAdapter();
      addContactAllDayModel();
    }
    return contactAllDayModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getContactAllDayItem1(){
    if(contactAllDayItem1==null){

      contactAllDayItem1 = new ACRadioButtonItem();

      contactAllDayItem1.setText("�Ȃ�");

      contactAllDayItem1.setGroup(getContactAllDay());

      addContactAllDayItem1();
    }
    return contactAllDayItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getContactAllDayItem2(){
    if(contactAllDayItem2==null){

      contactAllDayItem2 = new ACRadioButtonItem();

      contactAllDayItem2.setText("����");

      contactAllDayItem2.setGroup(getContactAllDay());

      addContactAllDayItem2();
    }
    return contactAllDayItem2;

  }

  /**
   * �d�ǎҊǗ����Z���W�I�O���[�v���擾���܂��B
   * @return �d�ǎҊǗ����Z���W�I�O���[�v
   */
  public ACClearableRadioButtonGroup getSeriousCaseManagement(){
    if(seriousCaseManagement==null){

      seriousCaseManagement = new ACClearableRadioButtonGroup();

      getSeriousCaseManagementContainer().setText("�d�ǎҊǗ����Z");

      seriousCaseManagement.setBindPath("2010103");

      seriousCaseManagement.setModel(getSeriousCaseManagementModel());

      seriousCaseManagement.setUseClearButton(false);

      addSeriousCaseManagement();
    }
    return seriousCaseManagement;

  }

  /**
   * �d�ǎҊǗ����Z���W�I�O���[�v�R���e�i���擾���܂��B
   * @return �d�ǎҊǗ����Z���W�I�O���[�v�R���e�i
   */
  protected ACLabelContainer getSeriousCaseManagementContainer(){
    if(seriousCaseManagementContainer==null){
      seriousCaseManagementContainer = new ACLabelContainer();
      seriousCaseManagementContainer.setFollowChildEnabled(true);
      seriousCaseManagementContainer.setVAlignment(VRLayout.CENTER);
      seriousCaseManagementContainer.add(getSeriousCaseManagement(), null);
    }
    return seriousCaseManagementContainer;
  }

  /**
   * �d�ǎҊǗ����Z���W�I�O���[�v���f�����擾���܂��B
   * @return �d�ǎҊǗ����Z���W�I�O���[�v���f��
   */
  protected ACListModelAdapter getSeriousCaseManagementModel(){
    if(seriousCaseManagementModel==null){
      seriousCaseManagementModel = new ACListModelAdapter();
      addSeriousCaseManagementModel();
    }
    return seriousCaseManagementModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getSeriousCaseManagementItem1(){
    if(seriousCaseManagementItem1==null){

      seriousCaseManagementItem1 = new ACRadioButtonItem();

      seriousCaseManagementItem1.setText("�Ȃ�");

      seriousCaseManagementItem1.setGroup(getSeriousCaseManagement());

      addSeriousCaseManagementItem1();
    }
    return seriousCaseManagementItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getSeriousCaseManagementItem2(){
    if(seriousCaseManagementItem2==null){

      seriousCaseManagementItem2 = new ACRadioButtonItem();

      seriousCaseManagementItem2.setText("����");

      seriousCaseManagementItem2.setGroup(getSeriousCaseManagement());

      addSeriousCaseManagementItem2();
    }
    return seriousCaseManagementItem2;

  }

  /**
   * �Z�荀�ڗ̈�2���擾���܂��B
   * @return �Z�荀�ڗ̈�2
   */
  public ACPanel getCalculationDetails2(){
    if(calculationDetails2==null){

      calculationDetails2 = new ACPanel();

      calculationDetails2.setFollowChildEnabled(true);

      calculationDetails2.setHgrid(200);

      addCalculationDetails2();
    }
    return calculationDetails2;

  }

  /**
   * �������R���e�i���擾���܂��B
   * @return �������R���e�i
   */
  public ACLabelContainer getReduceRateContainer(){
    if(reduceRateContainer==null){

      reduceRateContainer = new ACLabelContainer();

      reduceRateContainer.setText("������");

      reduceRateContainer.setFollowChildEnabled(true);

      addReduceRateContainer();
    }
    return reduceRateContainer;

  }

  /**
   * ���������擾���܂��B
   * @return ������
   */
  public ACTextField getReduceRate(){
    if(reduceRate==null){

      reduceRate = new ACTextField();

      reduceRate.setBindPath("REDUCT_RATE");

      reduceRate.setColumns(3);

      reduceRate.setCharType(VRCharType.ONLY_DIGIT);

      reduceRate.setHorizontalAlignment(SwingConstants.RIGHT);

      reduceRate.setIMEMode(InputSubset.LATIN);

      reduceRate.setMaxLength(3);

      addReduceRate();
    }
    return reduceRate;

  }

  /**
   * %���x�����擾���܂��B
   * @return %���x��
   */
  public ACLabel getPercentSign(){
    if(percentSign==null){

      percentSign = new ACLabel();

      percentSign.setText("��");

      addPercentSign();
    }
    return percentSign;

  }

  /**
   * �R���X�g���N�^�ł��B
   */
  public QO004103Design() {

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
   * ���ƃO���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMainGroup(){

    mainGroup.add(getCalculationDetails(), VRLayout.NORTH);

    mainGroup.add(getMedicalTreatmentInsurance(), VRLayout.NORTH);

    mainGroup.add(getCalculationDetails2(), VRLayout.NORTH);

  }

  /**
   * �Z�荀�ڗ̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalculationDetails(){

    calculationDetails.add(getFacilitiesDivisionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails.add(getHomonkangoPressingContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails.add(getSpecialManagementSystemContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails.add(getTerminalCareContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails.add(getManagerNameContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * �{�݋敪���W�I�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addFacilitiesDivision(){

  }

  /**
   * �{�݋敪���W�I�O���[�v���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addFacilitiesDivisionModel(){

    getFacilitiesDivisionItem1().setButtonIndex(1);
    getFacilitiesDivisionModel().add(getFacilitiesDivisionItem1());

    getFacilitiesDivisionItem2().setButtonIndex(2);
    getFacilitiesDivisionModel().add(getFacilitiesDivisionItem2());

  }

  /**
   * �K��Ō�X�e�[�V�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addFacilitiesDivisionItem1(){

  }

  /**
   * �a�@�܂��͐f�Ï��ɓ������ڂ�ǉ����܂��B
   */
  protected void addFacilitiesDivisionItem2(){

  }

  /**
   * �ً}���K��Ō���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHomonkangoPressing(){

  }

  /**
   * �ً}���K��Ō���Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addHomonkangoPressingModel(){

    getHomonkangoPressingRadioItem1().setButtonIndex(1);
    getHomonkangoPressingModel().add(getHomonkangoPressingRadioItem1());

    getHomonkangoPressingRadioItem2().setButtonIndex(2);
    getHomonkangoPressingModel().add(getHomonkangoPressingRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addHomonkangoPressingRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addHomonkangoPressingRadioItem2(){

  }

  /**
   * ���ʊǗ��̐����W�I�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addSpecialManagementSystem(){

  }

  /**
   * ���ʊǗ��̐����W�I�O���[�v���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addSpecialManagementSystemModel(){

    getSpecialManagementSystemItem1().setButtonIndex(1);
    getSpecialManagementSystemModel().add(getSpecialManagementSystemItem1());

    getSpecialManagementSystemItem2().setButtonIndex(2);
    getSpecialManagementSystemModel().add(getSpecialManagementSystemItem2());

  }

  /**
   * �Ή��s�ɓ������ڂ�ǉ����܂��B
   */
  protected void addSpecialManagementSystemItem1(){

  }

  /**
   * �Ή��ɓ������ڂ�ǉ����܂��B
   */
  protected void addSpecialManagementSystemItem2(){

  }

  /**
   * �^�[�~�i���P�A�̐����W�I�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTerminalCare(){

  }

  /**
   * �^�[�~�i���P�A�̐����W�I�O���[�v���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addTerminalCareModel(){

    getTerminalCareItem1().setButtonIndex(1);
    getTerminalCareModel().add(getTerminalCareItem1());

    getTerminalCareItem2().setButtonIndex(2);
    getTerminalCareModel().add(getTerminalCareItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addTerminalCareItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addTerminalCareItem2(){

  }

  /**
   * �Ǘ��Ҏ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addManagerName(){

  }

  /**
   * ������Õی��������ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalTreatmentInsurance(){

    medicalTreatmentInsurance.add(getStationCodeContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    medicalTreatmentInsurance.add(getContactAllDayContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    medicalTreatmentInsurance.add(getSeriousCaseManagementContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * �X�e�[�V�����R�[�h�ɓ������ڂ�ǉ����܂��B
   */
  protected void addStationCode(){

  }

  /**
   * 24���ԘA���̐����Z���W�I�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addContactAllDay(){

  }

  /**
   * 24���ԘA���̐����Z���W�I�O���[�v���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addContactAllDayModel(){

    getContactAllDayItem1().setButtonIndex(1);
    getContactAllDayModel().add(getContactAllDayItem1());

    getContactAllDayItem2().setButtonIndex(2);
    getContactAllDayModel().add(getContactAllDayItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addContactAllDayItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addContactAllDayItem2(){

  }

  /**
   * �d�ǎҊǗ����Z���W�I�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addSeriousCaseManagement(){

  }

  /**
   * �d�ǎҊǗ����Z���W�I�O���[�v���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addSeriousCaseManagementModel(){

    getSeriousCaseManagementItem1().setButtonIndex(1);
    getSeriousCaseManagementModel().add(getSeriousCaseManagementItem1());

    getSeriousCaseManagementItem2().setButtonIndex(2);
    getSeriousCaseManagementModel().add(getSeriousCaseManagementItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addSeriousCaseManagementItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addSeriousCaseManagementItem2(){

  }

  /**
   * �Z�荀�ڗ̈�2�ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalculationDetails2(){

    calculationDetails2.add(getReduceRateContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * �������R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addReduceRateContainer(){

    reduceRateContainer.add(getReduceRate(), VRLayout.FLOW);

    reduceRateContainer.add(getPercentSign(), VRLayout.FLOW);

  }

  /**
   * �������ɓ������ڂ�ǉ����܂��B
   */
  protected void addReduceRate(){

  }

  /**
   * %���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addPercentSign(){

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
      ACFrame.debugStart(new ACAffairInfo(QO004103Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QO004103Design getThis() {
    return this;
  }
}
