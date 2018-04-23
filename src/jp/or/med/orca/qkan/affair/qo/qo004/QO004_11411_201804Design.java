
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
 * �쐬��: 2018/01/27  ���{�R���s���[�^�[������� �����@���̂� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���̑��@�\ (O)
 * �v���Z�X ���Ǝғo�^ (004)
 * �v���O���� �K�⃊�n (QO004_11411_201804)
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
 * �K�⃊�n��ʍ��ڃf�U�C��(QO004_11411_201804) 
 */
public class QO004_11411_201804Design extends QO004ProviderPanel {
  //GUI�R���|�[�l���g

  private ACGroupBox mainGroup;

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

  private ACValueArrayRadioButtonGroup intensiveRehabilitationRadioGroup;

  private ACLabelContainer intensiveRehabilitationRadioGroupContainer;

  private ACListModelAdapter intensiveRehabilitationRadioGroupModel;

  private ACRadioButtonItem intensiveRehabilitationRadioItem1;

  private ACRadioButtonItem intensiveRehabilitationRadioItem2;

  private ACValueArrayRadioButtonGroup rehabilitationManagementRadioGroup;

  private ACLabelContainer rehabilitationManagementRadioGroupContainer;

  private ACListModelAdapter rehabilitationManagementRadioGroupModel;

  private ACRadioButtonItem rehabilitationManagementRadioItem1;

  private ACRadioButtonItem rehabilitationManagementRadioItem2;

  private ACRadioButtonItem rehabilitationManagementRadioItem3;

  private ACRadioButtonItem rehabilitationManagementRadioItem4;

  private ACRadioButtonItem rehabilitationManagementRadioItem5;

  private ACValueArrayRadioButtonGroup socialSupportRadioGroup;

  private ACLabelContainer socialSupportRadioGroupContainer;

  private ACListModelAdapter socialSupportRadioGroupModel;

  private ACRadioButtonItem socialSupportRadioItem1;

  private ACRadioButtonItem socialSupportRadioItem2;

  private ACValueArrayRadioButtonGroup serviceAddProvisionStructuralRadioGroup;

  private ACLabelContainer serviceAddProvisionStructuralRadioGroupContainer;

  private ACListModelAdapter serviceAddProvisionStructuralRadioGroupModel;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem1;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem2;

  //getter

  /**
   * ���ƃO���[�v���擾���܂��B
   * @return ���ƃO���[�v
   */
  public ACGroupBox getMainGroup(){
    if(mainGroup==null){

      mainGroup = new ACGroupBox();

      mainGroup.setText("�K�⃊�n");

      mainGroup.setFollowChildEnabled(true);

      mainGroup.setHgrid(200);

      addMainGroup();
    }
    return mainGroup;

  }

  /**
   * �{�݋敪���W�I�O���[�v���擾���܂��B
   * @return �{�݋敪���W�I�O���[�v
   */
  public ACValueArrayRadioButtonGroup getFacilitiesDivision(){
    if(facilitiesDivision==null){

      facilitiesDivision = new ACValueArrayRadioButtonGroup();

      getFacilitiesDivisionContainer().setText("�{�ݓ��̋敪");

      facilitiesDivision.setBindPath("1140101");

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
   * �a�@���͐f�Ï����擾���܂��B
   * @return �a�@���͐f�Ï�
   */
  public ACRadioButtonItem getFacilitiesDivisionItem1(){
    if(facilitiesDivisionItem1==null){

      facilitiesDivisionItem1 = new ACRadioButtonItem();

      facilitiesDivisionItem1.setText("�a�@���͐f�Ï�");

      facilitiesDivisionItem1.setGroup(getFacilitiesDivision());

      facilitiesDivisionItem1.setConstraints(VRLayout.FLOW);

      addFacilitiesDivisionItem1();
    }
    return facilitiesDivisionItem1;

  }

  /**
   * ���V�l�ی��{�݂��擾���܂��B
   * @return ���V�l�ی��{��
   */
  public ACRadioButtonItem getFacilitiesDivisionItem2(){
    if(facilitiesDivisionItem2==null){

      facilitiesDivisionItem2 = new ACRadioButtonItem();

      facilitiesDivisionItem2.setText("���V�l�ی��{��");

      facilitiesDivisionItem2.setGroup(getFacilitiesDivision());

      facilitiesDivisionItem2.setConstraints(VRLayout.FLOW);

      addFacilitiesDivisionItem2();
    }
    return facilitiesDivisionItem2;

  }

  /**
   * ����É@���擾���܂��B
   * @return ����É@
   */
  public ACRadioButtonItem getFacilitiesDivisionItem3(){
    if(facilitiesDivisionItem3==null){

      facilitiesDivisionItem3 = new ACRadioButtonItem();

      facilitiesDivisionItem3.setText("����É@");

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
   * �Z���W�����n�r���e�[�V�������{���Z���擾���܂��B
   * @return �Z���W�����n�r���e�[�V�������{���Z
   */
  public ACValueArrayRadioButtonGroup getIntensiveRehabilitationRadioGroup(){
    if(intensiveRehabilitationRadioGroup==null){

      intensiveRehabilitationRadioGroup = new ACValueArrayRadioButtonGroup();

      getIntensiveRehabilitationRadioGroupContainer().setText("�Z���W�����n�r���e�[�V�������{���Z");

      intensiveRehabilitationRadioGroup.setBindPath("1140103");

      intensiveRehabilitationRadioGroup.setVisible(true);

      intensiveRehabilitationRadioGroup.setEnabled(true);

      intensiveRehabilitationRadioGroup.setNoSelectIndex(0);

      intensiveRehabilitationRadioGroup.setUseClearButton(false);

      intensiveRehabilitationRadioGroup.setModel(getIntensiveRehabilitationRadioGroupModel());

      intensiveRehabilitationRadioGroup.setValues(new int[]{1,2});

      addIntensiveRehabilitationRadioGroup();
    }
    return intensiveRehabilitationRadioGroup;

  }

  /**
   * �Z���W�����n�r���e�[�V�������{���Z�R���e�i���擾���܂��B
   * @return �Z���W�����n�r���e�[�V�������{���Z�R���e�i
   */
  protected ACLabelContainer getIntensiveRehabilitationRadioGroupContainer(){
    if(intensiveRehabilitationRadioGroupContainer==null){
      intensiveRehabilitationRadioGroupContainer = new ACLabelContainer();
      intensiveRehabilitationRadioGroupContainer.setFollowChildEnabled(true);
      intensiveRehabilitationRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      intensiveRehabilitationRadioGroupContainer.add(getIntensiveRehabilitationRadioGroup(), null);
    }
    return intensiveRehabilitationRadioGroupContainer;
  }

  /**
   * �Z���W�����n�r���e�[�V�������{���Z���f�����擾���܂��B
   * @return �Z���W�����n�r���e�[�V�������{���Z���f��
   */
  protected ACListModelAdapter getIntensiveRehabilitationRadioGroupModel(){
    if(intensiveRehabilitationRadioGroupModel==null){
      intensiveRehabilitationRadioGroupModel = new ACListModelAdapter();
      addIntensiveRehabilitationRadioGroupModel();
    }
    return intensiveRehabilitationRadioGroupModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getIntensiveRehabilitationRadioItem1(){
    if(intensiveRehabilitationRadioItem1==null){

      intensiveRehabilitationRadioItem1 = new ACRadioButtonItem();

      intensiveRehabilitationRadioItem1.setText("�Ȃ�");

      intensiveRehabilitationRadioItem1.setGroup(getIntensiveRehabilitationRadioGroup());

      intensiveRehabilitationRadioItem1.setConstraints(VRLayout.FLOW);

      addIntensiveRehabilitationRadioItem1();
    }
    return intensiveRehabilitationRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getIntensiveRehabilitationRadioItem2(){
    if(intensiveRehabilitationRadioItem2==null){

      intensiveRehabilitationRadioItem2 = new ACRadioButtonItem();

      intensiveRehabilitationRadioItem2.setText("����");

      intensiveRehabilitationRadioItem2.setGroup(getIntensiveRehabilitationRadioGroup());

      intensiveRehabilitationRadioItem2.setConstraints(VRLayout.FLOW);

      addIntensiveRehabilitationRadioItem2();
    }
    return intensiveRehabilitationRadioItem2;

  }

  /**
   * ���n�r���e�[�V�����}�l�W�����g���Z���擾���܂��B
   * @return ���n�r���e�[�V�����}�l�W�����g���Z
   */
  public ACValueArrayRadioButtonGroup getRehabilitationManagementRadioGroup(){
    if(rehabilitationManagementRadioGroup==null){

      rehabilitationManagementRadioGroup = new ACValueArrayRadioButtonGroup();

      getRehabilitationManagementRadioGroupContainer().setText("���n�r���e�[�V�����}�l�W�����g���Z");

      rehabilitationManagementRadioGroup.setBindPath("1140104");

      rehabilitationManagementRadioGroup.setVisible(true);

      rehabilitationManagementRadioGroup.setEnabled(true);

      rehabilitationManagementRadioGroup.setNoSelectIndex(0);

      rehabilitationManagementRadioGroup.setUseClearButton(false);

      rehabilitationManagementRadioGroup.setModel(getRehabilitationManagementRadioGroupModel());

      rehabilitationManagementRadioGroup.setValues(new int[]{1,2,3,4,5});

      addRehabilitationManagementRadioGroup();
    }
    return rehabilitationManagementRadioGroup;

  }

  /**
   * ���n�r���e�[�V�����}�l�W�����g���Z�R���e�i���擾���܂��B
   * @return ���n�r���e�[�V�����}�l�W�����g���Z�R���e�i
   */
  protected ACLabelContainer getRehabilitationManagementRadioGroupContainer(){
    if(rehabilitationManagementRadioGroupContainer==null){
      rehabilitationManagementRadioGroupContainer = new ACLabelContainer();
      rehabilitationManagementRadioGroupContainer.setFollowChildEnabled(true);
      rehabilitationManagementRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      rehabilitationManagementRadioGroupContainer.add(getRehabilitationManagementRadioGroup(), null);
    }
    return rehabilitationManagementRadioGroupContainer;
  }

  /**
   * ���n�r���e�[�V�����}�l�W�����g���Z���f�����擾���܂��B
   * @return ���n�r���e�[�V�����}�l�W�����g���Z���f��
   */
  protected ACListModelAdapter getRehabilitationManagementRadioGroupModel(){
    if(rehabilitationManagementRadioGroupModel==null){
      rehabilitationManagementRadioGroupModel = new ACListModelAdapter();
      addRehabilitationManagementRadioGroupModel();
    }
    return rehabilitationManagementRadioGroupModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getRehabilitationManagementRadioItem1(){
    if(rehabilitationManagementRadioItem1==null){

      rehabilitationManagementRadioItem1 = new ACRadioButtonItem();

      rehabilitationManagementRadioItem1.setText("�Ȃ�");

      rehabilitationManagementRadioItem1.setGroup(getRehabilitationManagementRadioGroup());

      rehabilitationManagementRadioItem1.setConstraints(VRLayout.FLOW);

      addRehabilitationManagementRadioItem1();
    }
    return rehabilitationManagementRadioItem1;

  }

  /**
   * ���ZI���擾���܂��B
   * @return ���ZI
   */
  public ACRadioButtonItem getRehabilitationManagementRadioItem2(){
    if(rehabilitationManagementRadioItem2==null){

      rehabilitationManagementRadioItem2 = new ACRadioButtonItem();

      rehabilitationManagementRadioItem2.setText("���ZI");

      rehabilitationManagementRadioItem2.setGroup(getRehabilitationManagementRadioGroup());

      rehabilitationManagementRadioItem2.setConstraints(VRLayout.FLOW);

      addRehabilitationManagementRadioItem2();
    }
    return rehabilitationManagementRadioItem2;

  }

  /**
   * ���ZII���擾���܂��B
   * @return ���ZII
   */
  public ACRadioButtonItem getRehabilitationManagementRadioItem3(){
    if(rehabilitationManagementRadioItem3==null){

      rehabilitationManagementRadioItem3 = new ACRadioButtonItem();

      rehabilitationManagementRadioItem3.setText("���ZII");

      rehabilitationManagementRadioItem3.setGroup(getRehabilitationManagementRadioGroup());

      rehabilitationManagementRadioItem3.setConstraints(VRLayout.FLOW_RETURN);

      addRehabilitationManagementRadioItem3();
    }
    return rehabilitationManagementRadioItem3;

  }

  /**
   * ���ZIII���擾���܂��B
   * @return ���ZIII
   */
  public ACRadioButtonItem getRehabilitationManagementRadioItem4(){
    if(rehabilitationManagementRadioItem4==null){

      rehabilitationManagementRadioItem4 = new ACRadioButtonItem();

      rehabilitationManagementRadioItem4.setText("���ZIII");

      rehabilitationManagementRadioItem4.setGroup(getRehabilitationManagementRadioGroup());

      rehabilitationManagementRadioItem4.setConstraints(VRLayout.FLOW);

      addRehabilitationManagementRadioItem4();
    }
    return rehabilitationManagementRadioItem4;

  }

  /**
   * ���ZIV���擾���܂��B
   * @return ���ZIV
   */
  public ACRadioButtonItem getRehabilitationManagementRadioItem5(){
    if(rehabilitationManagementRadioItem5==null){

      rehabilitationManagementRadioItem5 = new ACRadioButtonItem();

      rehabilitationManagementRadioItem5.setText("���ZIV");

      rehabilitationManagementRadioItem5.setGroup(getRehabilitationManagementRadioGroup());

      rehabilitationManagementRadioItem5.setConstraints(VRLayout.FLOW);

      addRehabilitationManagementRadioItem5();
    }
    return rehabilitationManagementRadioItem5;

  }

  /**
   * �Љ�Q���x�����Z���擾���܂��B
   * @return �Љ�Q���x�����Z
   */
  public ACValueArrayRadioButtonGroup getSocialSupportRadioGroup(){
    if(socialSupportRadioGroup==null){

      socialSupportRadioGroup = new ACValueArrayRadioButtonGroup();

      getSocialSupportRadioGroupContainer().setText("�Љ�Q���x�����Z");

      socialSupportRadioGroup.setBindPath("1140105");

      socialSupportRadioGroup.setVisible(true);

      socialSupportRadioGroup.setEnabled(true);

      socialSupportRadioGroup.setNoSelectIndex(0);

      socialSupportRadioGroup.setUseClearButton(false);

      socialSupportRadioGroup.setModel(getSocialSupportRadioGroupModel());

      socialSupportRadioGroup.setValues(new int[]{1,2});

      addSocialSupportRadioGroup();
    }
    return socialSupportRadioGroup;

  }

  /**
   * �Љ�Q���x�����Z�R���e�i���擾���܂��B
   * @return �Љ�Q���x�����Z�R���e�i
   */
  protected ACLabelContainer getSocialSupportRadioGroupContainer(){
    if(socialSupportRadioGroupContainer==null){
      socialSupportRadioGroupContainer = new ACLabelContainer();
      socialSupportRadioGroupContainer.setFollowChildEnabled(true);
      socialSupportRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      socialSupportRadioGroupContainer.add(getSocialSupportRadioGroup(), null);
    }
    return socialSupportRadioGroupContainer;
  }

  /**
   * �Љ�Q���x�����Z���f�����擾���܂��B
   * @return �Љ�Q���x�����Z���f��
   */
  protected ACListModelAdapter getSocialSupportRadioGroupModel(){
    if(socialSupportRadioGroupModel==null){
      socialSupportRadioGroupModel = new ACListModelAdapter();
      addSocialSupportRadioGroupModel();
    }
    return socialSupportRadioGroupModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getSocialSupportRadioItem1(){
    if(socialSupportRadioItem1==null){

      socialSupportRadioItem1 = new ACRadioButtonItem();

      socialSupportRadioItem1.setText("�Ȃ�");

      socialSupportRadioItem1.setGroup(getSocialSupportRadioGroup());

      socialSupportRadioItem1.setConstraints(VRLayout.FLOW);

      addSocialSupportRadioItem1();
    }
    return socialSupportRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getSocialSupportRadioItem2(){
    if(socialSupportRadioItem2==null){

      socialSupportRadioItem2 = new ACRadioButtonItem();

      socialSupportRadioItem2.setText("����");

      socialSupportRadioItem2.setGroup(getSocialSupportRadioGroup());

      socialSupportRadioItem2.setConstraints(VRLayout.FLOW);

      addSocialSupportRadioItem2();
    }
    return socialSupportRadioItem2;

  }

  /**
   * �T�[�r�X�񋟑̐��������Z���擾���܂��B
   * @return �T�[�r�X�񋟑̐��������Z
   */
  public ACValueArrayRadioButtonGroup getServiceAddProvisionStructuralRadioGroup(){
    if(serviceAddProvisionStructuralRadioGroup==null){

      serviceAddProvisionStructuralRadioGroup = new ACValueArrayRadioButtonGroup();

      getServiceAddProvisionStructuralRadioGroupContainer().setText("�T�[�r�X�񋟑̐��������Z");

      serviceAddProvisionStructuralRadioGroup.setBindPath("1140102");

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
   * �R���X�g���N�^�ł��B
   */
  public QO004_11411_201804Design() {

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

    mainGroup.add(getFacilitiesDivisionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    mainGroup.add(getProviderAddMountainousAreaRafioRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    mainGroup.add(getProviderAddMountainousAreaScaleRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    mainGroup.add(getIntensiveRehabilitationRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    mainGroup.add(getRehabilitationManagementRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    mainGroup.add(getSocialSupportRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    mainGroup.add(getServiceAddProvisionStructuralRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

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
   * �a�@���͐f�Ï��ɓ������ڂ�ǉ����܂��B
   */
  protected void addFacilitiesDivisionItem1(){

  }

  /**
   * ���V�l�ی��{�݂ɓ������ڂ�ǉ����܂��B
   */
  protected void addFacilitiesDivisionItem2(){

  }

  /**
   * ����É@�ɓ������ڂ�ǉ����܂��B
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
   * �Z���W�����n�r���e�[�V�������{���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addIntensiveRehabilitationRadioGroup(){

  }

  /**
   * �Z���W�����n�r���e�[�V�������{���Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addIntensiveRehabilitationRadioGroupModel(){

    getIntensiveRehabilitationRadioItem1().setButtonIndex(1);

    getIntensiveRehabilitationRadioGroupModel().add(getIntensiveRehabilitationRadioItem1());

    getIntensiveRehabilitationRadioItem2().setButtonIndex(2);

    getIntensiveRehabilitationRadioGroupModel().add(getIntensiveRehabilitationRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addIntensiveRehabilitationRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addIntensiveRehabilitationRadioItem2(){

  }

  /**
   * ���n�r���e�[�V�����}�l�W�����g���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addRehabilitationManagementRadioGroup(){

  }

  /**
   * ���n�r���e�[�V�����}�l�W�����g���Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addRehabilitationManagementRadioGroupModel(){

    getRehabilitationManagementRadioItem1().setButtonIndex(1);

    getRehabilitationManagementRadioGroupModel().add(getRehabilitationManagementRadioItem1());

    getRehabilitationManagementRadioItem2().setButtonIndex(2);

    getRehabilitationManagementRadioGroupModel().add(getRehabilitationManagementRadioItem2());

    getRehabilitationManagementRadioItem3().setButtonIndex(3);

    getRehabilitationManagementRadioGroupModel().add(getRehabilitationManagementRadioItem3());

    getRehabilitationManagementRadioItem4().setButtonIndex(4);

    getRehabilitationManagementRadioGroupModel().add(getRehabilitationManagementRadioItem4());

    getRehabilitationManagementRadioItem5().setButtonIndex(5);

    getRehabilitationManagementRadioGroupModel().add(getRehabilitationManagementRadioItem5());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addRehabilitationManagementRadioItem1(){

  }

  /**
   * ���ZI�ɓ������ڂ�ǉ����܂��B
   */
  protected void addRehabilitationManagementRadioItem2(){

  }

  /**
   * ���ZII�ɓ������ڂ�ǉ����܂��B
   */
  protected void addRehabilitationManagementRadioItem3(){

  }

  /**
   * ���ZIII�ɓ������ڂ�ǉ����܂��B
   */
  protected void addRehabilitationManagementRadioItem4(){

  }

  /**
   * ���ZIV�ɓ������ڂ�ǉ����܂��B
   */
  protected void addRehabilitationManagementRadioItem5(){

  }

  /**
   * �Љ�Q���x�����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addSocialSupportRadioGroup(){

  }

  /**
   * �Љ�Q���x�����Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addSocialSupportRadioGroupModel(){

    getSocialSupportRadioItem1().setButtonIndex(1);

    getSocialSupportRadioGroupModel().add(getSocialSupportRadioItem1());

    getSocialSupportRadioItem2().setButtonIndex(2);

    getSocialSupportRadioGroupModel().add(getSocialSupportRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addSocialSupportRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addSocialSupportRadioItem2(){

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
      ACFrame.debugStart(new ACAffairInfo(QO004_11411_201804Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QO004_11411_201804Design getThis() {
    return this;
  }
}
