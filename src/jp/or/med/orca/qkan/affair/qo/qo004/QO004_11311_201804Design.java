
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
 * �J����: �����@���̂�
 * �쐬��: 2018/01/26  ���{�R���s���[�^�[������� �����@���̂� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���̑��@�\ (O)
 * �v���Z�X ���Ǝғo�^ (004)
 * �v���O���� �K��Ō� (QO004_11311_201804)
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
 * �K��Ō��ʍ��ڃf�U�C��(QO004_11311_201804) 
 */
public class QO004_11311_201804Design extends QO004ProviderPanel {
  //GUI�R���|�[�l���g

  private ACGroupBox mainGroup;

  private ACPanel calculationDetails;

  private ACValueArrayRadioButtonGroup facilitiesDivision;

  private ACLabelContainer facilitiesDivisionContainer;

  private ACListModelAdapter facilitiesDivisionModel;

  private ACRadioButtonItem facilitiesDivisionItem1;

  private ACRadioButtonItem facilitiesDivisionItem2;

  private ACRadioButtonItem facilitiesDivisionItem3;

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

  private ACValueArrayRadioButtonGroup homonkangoPressing;

  private ACLabelContainer homonkangoPressingContainer;

  private ACListModelAdapter homonkangoPressingModel;

  private ACRadioButtonItem homonkangoPressingRadioItem1;

  private ACRadioButtonItem homonkangoPressingRadioItem2;

  private ACValueArrayRadioButtonGroup specialManagementSystem;

  private ACLabelContainer specialManagementSystemContainer;

  private ACListModelAdapter specialManagementSystemModel;

  private ACRadioButtonItem specialManagementSystemItem1;

  private ACRadioButtonItem specialManagementSystemItem2;

  private ACValueArrayRadioButtonGroup terminalCare;

  private ACLabelContainer terminalCareContainer;

  private ACListModelAdapter terminalCareModel;

  private ACRadioButtonItem terminalCareItem1;

  private ACRadioButtonItem terminalCareItem2;

  private ACValueArrayRadioButtonGroup careSupportSystem;

  private ACLabelContainer careSupportSystemContainer;

  private ACListModelAdapter careSupportSystemModel;

  private ACRadioButtonItem careSupportSystemItem1;

  private ACRadioButtonItem careSupportSystemItem2;

  private ACRadioButtonItem careSupportSystemItem3;

  private ACValueArrayRadioButtonGroup serviceAddProvisionStructuralRadioGroup;

  private ACLabelContainer serviceAddProvisionStructuralRadioGroupContainer;

  private ACListModelAdapter serviceAddProvisionStructuralRadioGroupModel;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem1;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem2;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem3;

  private ACTextField managerName;

  private ACLabelContainer managerNameContainer;

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
  public ACValueArrayRadioButtonGroup getFacilitiesDivision(){
    if(facilitiesDivision==null){

      facilitiesDivision = new ACValueArrayRadioButtonGroup();

      getFacilitiesDivisionContainer().setText("�{�ݓ��̋敪");

      facilitiesDivision.setBindPath("1130101");

      facilitiesDivision.setUseClearButton(false);

      facilitiesDivision.setModel(getFacilitiesDivisionModel());

      facilitiesDivision.setValues(new int[]{1,2,3});

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

      facilitiesDivisionItem1.setConstraints(VRLayout.FLOW);

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

      facilitiesDivisionItem2.setConstraints(VRLayout.FLOW_RETURN);

      addFacilitiesDivisionItem2();
    }
    return facilitiesDivisionItem2;

  }

  /**
   * �������E�����Ή��T�[�r�X�A�g���擾���܂��B
   * @return �������E�����Ή��T�[�r�X�A�g
   */
  public ACRadioButtonItem getFacilitiesDivisionItem3(){
    if(facilitiesDivisionItem3==null){

      facilitiesDivisionItem3 = new ACRadioButtonItem();

      facilitiesDivisionItem3.setText("�������E�����Ή��T�[�r�X�A�g");

      facilitiesDivisionItem3.setGroup(getFacilitiesDivision());

      facilitiesDivisionItem3.setConstraints(VRLayout.FLOW);

      addFacilitiesDivisionItem3();
    }
    return facilitiesDivisionItem3;

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
   * �ً}���K��Ō���Z���擾���܂��B
   * @return �ً}���K��Ō���Z
   */
  public ACValueArrayRadioButtonGroup getHomonkangoPressing(){
    if(homonkangoPressing==null){

      homonkangoPressing = new ACValueArrayRadioButtonGroup();

      getHomonkangoPressingContainer().setText("�ً}���K��Ō���Z");

      homonkangoPressing.setBindPath("1130104");

      homonkangoPressing.setUseClearButton(false);

      homonkangoPressing.setModel(getHomonkangoPressingModel());

      homonkangoPressing.setValues(new int[]{1,2});

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

      homonkangoPressingRadioItem1.setConstraints(VRLayout.FLOW);

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

      homonkangoPressingRadioItem2.setConstraints(VRLayout.FLOW);

      addHomonkangoPressingRadioItem2();
    }
    return homonkangoPressingRadioItem2;

  }

  /**
   * ���ʊǗ��̐����W�I�O���[�v���擾���܂��B
   * @return ���ʊǗ��̐����W�I�O���[�v
   */
  public ACValueArrayRadioButtonGroup getSpecialManagementSystem(){
    if(specialManagementSystem==null){

      specialManagementSystem = new ACValueArrayRadioButtonGroup();

      getSpecialManagementSystemContainer().setText("���ʊǗ��̐�");

      specialManagementSystem.setBindPath("1130102");

      specialManagementSystem.setUseClearButton(false);

      specialManagementSystem.setModel(getSpecialManagementSystemModel());

      specialManagementSystem.setValues(new int[]{1,2});

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

      specialManagementSystemItem1.setConstraints(VRLayout.FLOW);

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

      specialManagementSystemItem2.setConstraints(VRLayout.FLOW);

      addSpecialManagementSystemItem2();
    }
    return specialManagementSystemItem2;

  }

  /**
   * �^�[�~�i���P�A�̐����W�I�O���[�v���擾���܂��B
   * @return �^�[�~�i���P�A�̐����W�I�O���[�v
   */
  public ACValueArrayRadioButtonGroup getTerminalCare(){
    if(terminalCare==null){

      terminalCare = new ACValueArrayRadioButtonGroup();

      getTerminalCareContainer().setText("�^�[�~�i���P�A�̐�");

      terminalCare.setBindPath("1130105");

      terminalCare.setUseClearButton(false);

      terminalCare.setModel(getTerminalCareModel());

      terminalCare.setValues(new int[]{1,2});

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

      terminalCareItem1.setConstraints(VRLayout.FLOW);

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

      terminalCareItem2.setConstraints(VRLayout.FLOW);

      addTerminalCareItem2();
    }
    return terminalCareItem2;

  }

  /**
   * �Ō�̐��������Z���擾���܂��B
   * @return �Ō�̐��������Z
   */
  public ACValueArrayRadioButtonGroup getCareSupportSystem(){
    if(careSupportSystem==null){

      careSupportSystem = new ACValueArrayRadioButtonGroup();

      getCareSupportSystemContainer().setText("�Ō�̐��������Z");

      careSupportSystem.setBindPath("1130109");

      careSupportSystem.setUseClearButton(false);

      careSupportSystem.setModel(getCareSupportSystemModel());

      careSupportSystem.setValues(new int[]{1,3,2});

      addCareSupportSystem();
    }
    return careSupportSystem;

  }

  /**
   * �Ō�̐��������Z�R���e�i���擾���܂��B
   * @return �Ō�̐��������Z�R���e�i
   */
  protected ACLabelContainer getCareSupportSystemContainer(){
    if(careSupportSystemContainer==null){
      careSupportSystemContainer = new ACLabelContainer();
      careSupportSystemContainer.setFollowChildEnabled(true);
      careSupportSystemContainer.setVAlignment(VRLayout.CENTER);
      careSupportSystemContainer.add(getCareSupportSystem(), null);
    }
    return careSupportSystemContainer;
  }

  /**
   * �Ō�̐��������Z���f�����擾���܂��B
   * @return �Ō�̐��������Z���f��
   */
  protected ACListModelAdapter getCareSupportSystemModel(){
    if(careSupportSystemModel==null){
      careSupportSystemModel = new ACListModelAdapter();
      addCareSupportSystemModel();
    }
    return careSupportSystemModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getCareSupportSystemItem1(){
    if(careSupportSystemItem1==null){

      careSupportSystemItem1 = new ACRadioButtonItem();

      careSupportSystemItem1.setText("�Ȃ�");

      careSupportSystemItem1.setGroup(getCareSupportSystem());

      careSupportSystemItem1.setConstraints(VRLayout.FLOW);

      addCareSupportSystemItem1();
    }
    return careSupportSystemItem1;

  }

  /**
   * ���ZI���擾���܂��B
   * @return ���ZI
   */
  public ACRadioButtonItem getCareSupportSystemItem2(){
    if(careSupportSystemItem2==null){

      careSupportSystemItem2 = new ACRadioButtonItem();

      careSupportSystemItem2.setText("���ZI");

      careSupportSystemItem2.setGroup(getCareSupportSystem());

      careSupportSystemItem2.setConstraints(VRLayout.FLOW);

      addCareSupportSystemItem2();
    }
    return careSupportSystemItem2;

  }

  /**
   * ���ZII���擾���܂��B
   * @return ���ZII
   */
  public ACRadioButtonItem getCareSupportSystemItem3(){
    if(careSupportSystemItem3==null){

      careSupportSystemItem3 = new ACRadioButtonItem();

      careSupportSystemItem3.setText("���ZII");

      careSupportSystemItem3.setGroup(getCareSupportSystem());

      careSupportSystemItem3.setConstraints(VRLayout.FLOW);

      addCareSupportSystemItem3();
    }
    return careSupportSystemItem3;

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

      serviceAddProvisionStructuralRadioGroup.setValues(new int[]{1,2,3});

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
   * �C�y�у��̏ꍇ���擾���܂��B
   * @return �C�y�у��̏ꍇ
   */
  public ACRadioButtonItem getServiceAddProvisionStructuralRadioItem2(){
    if(serviceAddProvisionStructuralRadioItem2==null){

      serviceAddProvisionStructuralRadioItem2 = new ACRadioButtonItem();

      serviceAddProvisionStructuralRadioItem2.setText("�C�y�у��̏ꍇ");

      serviceAddProvisionStructuralRadioItem2.setGroup(getServiceAddProvisionStructuralRadioGroup());

      serviceAddProvisionStructuralRadioItem2.setConstraints(VRLayout.FLOW);

      addServiceAddProvisionStructuralRadioItem2();
    }
    return serviceAddProvisionStructuralRadioItem2;

  }

  /**
   * �n�̏ꍇ���擾���܂��B
   * @return �n�̏ꍇ
   */
  public ACRadioButtonItem getServiceAddProvisionStructuralRadioItem3(){
    if(serviceAddProvisionStructuralRadioItem3==null){

      serviceAddProvisionStructuralRadioItem3 = new ACRadioButtonItem();

      serviceAddProvisionStructuralRadioItem3.setText("�n�̏ꍇ");

      serviceAddProvisionStructuralRadioItem3.setGroup(getServiceAddProvisionStructuralRadioGroup());

      serviceAddProvisionStructuralRadioItem3.setConstraints(VRLayout.FLOW);

      addServiceAddProvisionStructuralRadioItem3();
    }
    return serviceAddProvisionStructuralRadioItem3;

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
   * �R���X�g���N�^�ł��B
   */
  public QO004_11311_201804Design() {

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

  }

  /**
   * �Z�荀�ڗ̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalculationDetails(){

    calculationDetails.add(getFacilitiesDivisionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails.add(getProviderAddMountainousAreaRafioRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails.add(getProviderAddMountainousAreaScaleRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails.add(getHomonkangoPressingContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails.add(getSpecialManagementSystemContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails.add(getTerminalCareContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails.add(getCareSupportSystemContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails.add(getServiceAddProvisionStructuralRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

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

    getFacilitiesDivisionItem3().setButtonIndex(3);

    getFacilitiesDivisionModel().add(getFacilitiesDivisionItem3());

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
   * �������E�����Ή��T�[�r�X�A�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addFacilitiesDivisionItem3(){

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
   * �Ō�̐��������Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addCareSupportSystem(){

  }

  /**
   * �Ō�̐��������Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCareSupportSystemModel(){

    getCareSupportSystemItem1().setButtonIndex(1);

    getCareSupportSystemModel().add(getCareSupportSystemItem1());

    getCareSupportSystemItem2().setButtonIndex(3);

    getCareSupportSystemModel().add(getCareSupportSystemItem2());

    getCareSupportSystemItem3().setButtonIndex(2);

    getCareSupportSystemModel().add(getCareSupportSystemItem3());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addCareSupportSystemItem1(){

  }

  /**
   * ���ZI�ɓ������ڂ�ǉ����܂��B
   */
  protected void addCareSupportSystemItem2(){

  }

  /**
   * ���ZII�ɓ������ڂ�ǉ����܂��B
   */
  protected void addCareSupportSystemItem3(){

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

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceAddProvisionStructuralRadioItem1(){

  }

  /**
   * �C�y�у��̏ꍇ�ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceAddProvisionStructuralRadioItem2(){

  }

  /**
   * �n�̏ꍇ�ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceAddProvisionStructuralRadioItem3(){

  }

  /**
   * �Ǘ��Ҏ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addManagerName(){

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
      ACFrame.debugStart(new ACAffairInfo(QO004_11311_201804Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QO004_11311_201804Design getThis() {
    return this;
  }
}
