
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
 * �쐬��: 2009/03/04  ���{�R���s���[�^�[������� ���{�@�K�� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���̑��@�\ (O)
 * �v���Z�X ���Ǝғo�^ (004)
 * �v���O���� �K��Ō� (QO004103)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qo.qo004;
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
 * �K��Ō��ʍ��ڃf�U�C��(QO004103) 
 */
public class QO004103Design extends QO004ProviderPanel {
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

  private ACValueArrayRadioButtonGroup serviceAddProvisionStructuralRadioGroup;

  private ACLabelContainer serviceAddProvisionStructuralRadioGroupContainer;

  private ACListModelAdapter serviceAddProvisionStructuralRadioGroupModel;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem1;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem2;

  private ACValueArrayRadioButtonGroup providerAddMountainousAreaRafioRadioGroup;

  private ACLabelContainer providerAddMountainousAreaRafioRadioGroupContainer;

  private ACListModelAdapter providerAddMountainousAreaRafioRadioGroupModel;

  private ACRadioButtonItem providerAddMountainousAreaRafioRadioItem1;

  private ACRadioButtonItem providerAddMountainousAreaRafioRadioItem2;

  private ACValueArrayRadioButtonGroup providerAddMountainousAreaScaleRadioGroup;

  private ACLabelContainer providerAddMountainousAreaScaleRadioGroupContainer;

  private ACListModelAdapter providerAddMountainousAreaScaleRadioGroupModel;

  private ACRadioButtonItem providerAddMountainousAreaScaleRadioItem1;

  private ACRadioButtonItem providerAddMountainousAreaScaleRadioItem2;

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

      facilitiesDivision.setUseClearButton(false);

      facilitiesDivision.setModel(getFacilitiesDivisionModel());

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

      homonkangoPressing.setUseClearButton(false);

      homonkangoPressing.setModel(getHomonkangoPressingModel());

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

      specialManagementSystem.setUseClearButton(false);

      specialManagementSystem.setModel(getSpecialManagementSystemModel());

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

      terminalCare.setUseClearButton(false);

      terminalCare.setModel(getTerminalCareModel());

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
   * �T�[�r�X�񋟑̐��������Z���擾���܂��B
   * @return �T�[�r�X�񋟑̐��������Z
   */
  public ACValueArrayRadioButtonGroup getServiceAddProvisionStructuralRadioGroup(){
    if(serviceAddProvisionStructuralRadioGroup==null){

      serviceAddProvisionStructuralRadioGroup = new ACValueArrayRadioButtonGroup();

      getServiceAddProvisionStructuralRadioGroupContainer().setText("�T�[�r�X�񋟑̐��������Z");

      serviceAddProvisionStructuralRadioGroup.setBindPath("1130108");

      serviceAddProvisionStructuralRadioGroup.setVisible(true);

      serviceAddProvisionStructuralRadioGroup.setEnabled(true);

      serviceAddProvisionStructuralRadioGroup.setNoSelectIndex(0);

      serviceAddProvisionStructuralRadioGroup.setUseClearButton(false);

      serviceAddProvisionStructuralRadioGroup.setModel(getServiceAddProvisionStructuralRadioGroupModel());

      serviceAddProvisionStructuralRadioGroup.setValues(new int[]{1,2});

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
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getServiceAddProvisionStructuralRadioItem2(){
    if(serviceAddProvisionStructuralRadioItem2==null){

      serviceAddProvisionStructuralRadioItem2 = new ACRadioButtonItem();

      serviceAddProvisionStructuralRadioItem2.setText("����");

      serviceAddProvisionStructuralRadioItem2.setGroup(getServiceAddProvisionStructuralRadioGroup());

      serviceAddProvisionStructuralRadioItem2.setConstraints(VRLayout.FLOW);

      addServiceAddProvisionStructuralRadioItem2();
    }
    return serviceAddProvisionStructuralRadioItem2;

  }

  /**
   * ���R�Ԓn�擙�ɂ����鏬�K�͎��Ə����Z�i�n��Ɋւ���󋵁j���擾���܂��B
   * @return ���R�Ԓn�擙�ɂ����鏬�K�͎��Ə����Z�i�n��Ɋւ���󋵁j
   */
  public ACValueArrayRadioButtonGroup getProviderAddMountainousAreaRafioRadioGroup(){
    if(providerAddMountainousAreaRafioRadioGroup==null){

      providerAddMountainousAreaRafioRadioGroup = new ACValueArrayRadioButtonGroup();

      getProviderAddMountainousAreaRafioRadioGroupContainer().setText("���R�Ԓn�擙�ɂ����鏬�K�͎��Ə����Z�i�n��Ɋւ���󋵁j");

      providerAddMountainousAreaRafioRadioGroup.setBindPath("2");

      providerAddMountainousAreaRafioRadioGroup.setVisible(true);

      providerAddMountainousAreaRafioRadioGroup.setEnabled(true);

      providerAddMountainousAreaRafioRadioGroup.setNoSelectIndex(0);

      providerAddMountainousAreaRafioRadioGroup.setUseClearButton(false);

      providerAddMountainousAreaRafioRadioGroup.setModel(getProviderAddMountainousAreaRafioRadioGroupModel());

      providerAddMountainousAreaRafioRadioGroup.setValues(new int[]{1,2});

      addProviderAddMountainousAreaRafioRadioGroup();
    }
    return providerAddMountainousAreaRafioRadioGroup;

  }

  /**
   * ���R�Ԓn�擙�ɂ����鏬�K�͎��Ə����Z�i�n��Ɋւ���󋵁j�R���e�i���擾���܂��B
   * @return ���R�Ԓn�擙�ɂ����鏬�K�͎��Ə����Z�i�n��Ɋւ���󋵁j�R���e�i
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
   * ���R�Ԓn�擙�ɂ����鏬�K�͎��Ə����Z�i�n��Ɋւ���󋵁j���f�����擾���܂��B
   * @return ���R�Ԓn�擙�ɂ����鏬�K�͎��Ə����Z�i�n��Ɋւ���󋵁j���f��
   */
  protected ACListModelAdapter getProviderAddMountainousAreaRafioRadioGroupModel(){
    if(providerAddMountainousAreaRafioRadioGroupModel==null){
      providerAddMountainousAreaRafioRadioGroupModel = new ACListModelAdapter();
      addProviderAddMountainousAreaRafioRadioGroupModel();
    }
    return providerAddMountainousAreaRafioRadioGroupModel;
  }

  /**
   * ��Y�����擾���܂��B
   * @return ��Y��
   */
  public ACRadioButtonItem getProviderAddMountainousAreaRafioRadioItem1(){
    if(providerAddMountainousAreaRafioRadioItem1==null){

      providerAddMountainousAreaRafioRadioItem1 = new ACRadioButtonItem();

      providerAddMountainousAreaRafioRadioItem1.setText("��Y��");

      providerAddMountainousAreaRafioRadioItem1.setGroup(getProviderAddMountainousAreaRafioRadioGroup());

      providerAddMountainousAreaRafioRadioItem1.setConstraints(VRLayout.FLOW);

      addProviderAddMountainousAreaRafioRadioItem1();
    }
    return providerAddMountainousAreaRafioRadioItem1;

  }

  /**
   * �Y�����擾���܂��B
   * @return �Y��
   */
  public ACRadioButtonItem getProviderAddMountainousAreaRafioRadioItem2(){
    if(providerAddMountainousAreaRafioRadioItem2==null){

      providerAddMountainousAreaRafioRadioItem2 = new ACRadioButtonItem();

      providerAddMountainousAreaRafioRadioItem2.setText("�Y��");

      providerAddMountainousAreaRafioRadioItem2.setGroup(getProviderAddMountainousAreaRafioRadioGroup());

      providerAddMountainousAreaRafioRadioItem2.setConstraints(VRLayout.FLOW);

      addProviderAddMountainousAreaRafioRadioItem2();
    }
    return providerAddMountainousAreaRafioRadioItem2;

  }

  /**
   * ���R�Ԓn�擙�ɂ����鏬�K�͎��Ə����Z�i�K�͂Ɋւ���󋵁j���擾���܂��B
   * @return ���R�Ԓn�擙�ɂ����鏬�K�͎��Ə����Z�i�K�͂Ɋւ���󋵁j
   */
  public ACValueArrayRadioButtonGroup getProviderAddMountainousAreaScaleRadioGroup(){
    if(providerAddMountainousAreaScaleRadioGroup==null){

      providerAddMountainousAreaScaleRadioGroup = new ACValueArrayRadioButtonGroup();

      getProviderAddMountainousAreaScaleRadioGroupContainer().setText("���R�Ԓn�擙�ɂ����鏬�K�͎��Ə����Z�i�K�͂Ɋւ���󋵁j");

      providerAddMountainousAreaScaleRadioGroup.setBindPath("3");

      providerAddMountainousAreaScaleRadioGroup.setVisible(true);

      providerAddMountainousAreaScaleRadioGroup.setEnabled(true);

      providerAddMountainousAreaScaleRadioGroup.setNoSelectIndex(0);

      providerAddMountainousAreaScaleRadioGroup.setUseClearButton(false);

      providerAddMountainousAreaScaleRadioGroup.setModel(getProviderAddMountainousAreaScaleRadioGroupModel());

      providerAddMountainousAreaScaleRadioGroup.setValues(new int[]{1,2});

      addProviderAddMountainousAreaScaleRadioGroup();
    }
    return providerAddMountainousAreaScaleRadioGroup;

  }

  /**
   * ���R�Ԓn�擙�ɂ����鏬�K�͎��Ə����Z�i�K�͂Ɋւ���󋵁j�R���e�i���擾���܂��B
   * @return ���R�Ԓn�擙�ɂ����鏬�K�͎��Ə����Z�i�K�͂Ɋւ���󋵁j�R���e�i
   */
  protected ACLabelContainer getProviderAddMountainousAreaScaleRadioGroupContainer(){
    if(providerAddMountainousAreaScaleRadioGroupContainer==null){
      providerAddMountainousAreaScaleRadioGroupContainer = new ACLabelContainer();
      providerAddMountainousAreaScaleRadioGroupContainer.setFollowChildEnabled(true);
      providerAddMountainousAreaScaleRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      providerAddMountainousAreaScaleRadioGroupContainer.add(getProviderAddMountainousAreaScaleRadioGroup(), null);
    }
    return providerAddMountainousAreaScaleRadioGroupContainer;
  }

  /**
   * ���R�Ԓn�擙�ɂ����鏬�K�͎��Ə����Z�i�K�͂Ɋւ���󋵁j���f�����擾���܂��B
   * @return ���R�Ԓn�擙�ɂ����鏬�K�͎��Ə����Z�i�K�͂Ɋւ���󋵁j���f��
   */
  protected ACListModelAdapter getProviderAddMountainousAreaScaleRadioGroupModel(){
    if(providerAddMountainousAreaScaleRadioGroupModel==null){
      providerAddMountainousAreaScaleRadioGroupModel = new ACListModelAdapter();
      addProviderAddMountainousAreaScaleRadioGroupModel();
    }
    return providerAddMountainousAreaScaleRadioGroupModel;
  }

  /**
   * ��Y�����擾���܂��B
   * @return ��Y��
   */
  public ACRadioButtonItem getProviderAddMountainousAreaScaleRadioItem1(){
    if(providerAddMountainousAreaScaleRadioItem1==null){

      providerAddMountainousAreaScaleRadioItem1 = new ACRadioButtonItem();

      providerAddMountainousAreaScaleRadioItem1.setText("��Y��");

      providerAddMountainousAreaScaleRadioItem1.setGroup(getProviderAddMountainousAreaScaleRadioGroup());

      providerAddMountainousAreaScaleRadioItem1.setConstraints(VRLayout.FLOW);

      addProviderAddMountainousAreaScaleRadioItem1();
    }
    return providerAddMountainousAreaScaleRadioItem1;

  }

  /**
   * �Y�����擾���܂��B
   * @return �Y��
   */
  public ACRadioButtonItem getProviderAddMountainousAreaScaleRadioItem2(){
    if(providerAddMountainousAreaScaleRadioItem2==null){

      providerAddMountainousAreaScaleRadioItem2 = new ACRadioButtonItem();

      providerAddMountainousAreaScaleRadioItem2.setText("�Y��");

      providerAddMountainousAreaScaleRadioItem2.setGroup(getProviderAddMountainousAreaScaleRadioGroup());

      providerAddMountainousAreaScaleRadioItem2.setConstraints(VRLayout.FLOW);

      addProviderAddMountainousAreaScaleRadioItem2();
    }
    return providerAddMountainousAreaScaleRadioItem2;

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

      stationCode.setColumns(5);

      stationCode.setCharType(VRCharType.ONLY_DIGIT);

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

      contactAllDay.setUseClearButton(false);

      contactAllDay.setModel(getContactAllDayModel());

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

      seriousCaseManagement.setUseClearButton(false);

      seriousCaseManagement.setModel(getSeriousCaseManagementModel());

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

      reduceRateContainer.setForeground(java.awt.Color.gray);

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

      percentSign.setForeground(java.awt.Color.gray);

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

    calculationDetails.add(getServiceAddProvisionStructuralRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails.add(getProviderAddMountainousAreaRafioRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails.add(getProviderAddMountainousAreaScaleRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

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

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceAddProvisionStructuralRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceAddProvisionStructuralRadioItem2(){

  }

  /**
   * ���R�Ԓn�擙�ɂ����鏬�K�͎��Ə����Z�i�n��Ɋւ���󋵁j�ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderAddMountainousAreaRafioRadioGroup(){

  }

  /**
   * ���R�Ԓn�擙�ɂ����鏬�K�͎��Ə����Z�i�n��Ɋւ���󋵁j���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderAddMountainousAreaRafioRadioGroupModel(){

    getProviderAddMountainousAreaRafioRadioItem1().setButtonIndex(1);

    getProviderAddMountainousAreaRafioRadioGroupModel().add(getProviderAddMountainousAreaRafioRadioItem1());

    getProviderAddMountainousAreaRafioRadioItem2().setButtonIndex(2);

    getProviderAddMountainousAreaRafioRadioGroupModel().add(getProviderAddMountainousAreaRafioRadioItem2());

  }

  /**
   * ��Y���ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderAddMountainousAreaRafioRadioItem1(){

  }

  /**
   * �Y���ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderAddMountainousAreaRafioRadioItem2(){

  }

  /**
   * ���R�Ԓn�擙�ɂ����鏬�K�͎��Ə����Z�i�K�͂Ɋւ���󋵁j�ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderAddMountainousAreaScaleRadioGroup(){

  }

  /**
   * ���R�Ԓn�擙�ɂ����鏬�K�͎��Ə����Z�i�K�͂Ɋւ���󋵁j���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderAddMountainousAreaScaleRadioGroupModel(){

    getProviderAddMountainousAreaScaleRadioItem1().setButtonIndex(1);

    getProviderAddMountainousAreaScaleRadioGroupModel().add(getProviderAddMountainousAreaScaleRadioItem1());

    getProviderAddMountainousAreaScaleRadioItem2().setButtonIndex(2);

    getProviderAddMountainousAreaScaleRadioGroupModel().add(getProviderAddMountainousAreaScaleRadioItem2());

  }

  /**
   * ��Y���ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderAddMountainousAreaScaleRadioItem1(){

  }

  /**
   * �Y���ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderAddMountainousAreaScaleRadioItem2(){

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
