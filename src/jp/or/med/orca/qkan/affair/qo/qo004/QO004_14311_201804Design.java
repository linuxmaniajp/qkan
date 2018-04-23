
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
 * �쐬��: 2018/03/06  ���{�R���s���[�^�[������� �����@���̂� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���̑��@�\ (O)
 * �v���Z�X ���Ǝғo�^ (004)
 * �v���O���� ������x�� (QO004_14311_201804)
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
 * ������x����ʍ��ڃf�U�C��(QO004_14311_201804) 
 */
public class QO004_14311_201804Design extends QO004ProviderPanel {
  //GUI�R���|�[�l���g

  private ACGroupBox mainGroup;

  private ACPanel calculationDetails;

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

  private ACValueArrayRadioButtonGroup specificProviderSub;

  private ACLabelContainer specificProviderSubContainer;

  private ACListModelAdapter specificProviderSubModel;

  private ACRadioButtonItem specificProviderSubItem1;

  private ACRadioButtonItem specificProviderSubItem2;

  private ACValueArrayRadioButtonGroup specificProviderAdd;

  private ACLabelContainer specificProviderAddContainer;

  private ACListModelAdapter specificProviderAddModel;

  private ACRadioButtonItem specificProviderAddItem1;

  private ACRadioButtonItem specificProviderAddItem2;

  private ACRadioButtonItem specificProviderAddItem3;

  private ACRadioButtonItem specificProviderAddItem4;

  private ACValueArrayRadioButtonGroup specificProviderAdd4;

  private ACLabelContainer specificProviderAdd4Container;

  private ACListModelAdapter specificProviderAdd4Model;

  private ACRadioButtonItem specificProviderAdd4Item1;

  private ACRadioButtonItem specificProviderAdd4Item2;

  private ACValueArrayRadioButtonGroup terminalCareManagement;

  private ACLabelContainer terminalCareManagementContainer;

  private ACListModelAdapter terminalCareManagementModel;

  private ACRadioButtonItem terminalCareManagementItem1;

  private ACRadioButtonItem terminalCareManagementItem2;

  //getter

  /**
   * ���ƃO���[�v���擾���܂��B
   * @return ���ƃO���[�v
   */
  public ACGroupBox getMainGroup(){
    if(mainGroup==null){

      mainGroup = new ACGroupBox();

      mainGroup.setText("������x��");

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
   * ���莖�Ə��W�����Z���擾���܂��B
   * @return ���莖�Ə��W�����Z
   */
  public ACValueArrayRadioButtonGroup getSpecificProviderSub(){
    if(specificProviderSub==null){

      specificProviderSub = new ACValueArrayRadioButtonGroup();

      getSpecificProviderSubContainer().setText("���莖�Ə��W�����Z");

      specificProviderSub.setBindPath("1430102");

      specificProviderSub.setNoSelectIndex(0);

      specificProviderSub.setUseClearButton(false);

      specificProviderSub.setModel(getSpecificProviderSubModel());

      specificProviderSub.setValues(new int[]{1,2});

      addSpecificProviderSub();
    }
    return specificProviderSub;

  }

  /**
   * ���莖�Ə��W�����Z�R���e�i���擾���܂��B
   * @return ���莖�Ə��W�����Z�R���e�i
   */
  protected ACLabelContainer getSpecificProviderSubContainer(){
    if(specificProviderSubContainer==null){
      specificProviderSubContainer = new ACLabelContainer();
      specificProviderSubContainer.setFollowChildEnabled(true);
      specificProviderSubContainer.setVAlignment(VRLayout.CENTER);
      specificProviderSubContainer.add(getSpecificProviderSub(), null);
    }
    return specificProviderSubContainer;
  }

  /**
   * ���莖�Ə��W�����Z���f�����擾���܂��B
   * @return ���莖�Ə��W�����Z���f��
   */
  protected ACListModelAdapter getSpecificProviderSubModel(){
    if(specificProviderSubModel==null){
      specificProviderSubModel = new ACListModelAdapter();
      addSpecificProviderSubModel();
    }
    return specificProviderSubModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getSpecificProviderSubItem1(){
    if(specificProviderSubItem1==null){

      specificProviderSubItem1 = new ACRadioButtonItem();

      specificProviderSubItem1.setText("�Ȃ�");

      specificProviderSubItem1.setGroup(getSpecificProviderSub());

      specificProviderSubItem1.setConstraints(VRLayout.FLOW);

      addSpecificProviderSubItem1();
    }
    return specificProviderSubItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getSpecificProviderSubItem2(){
    if(specificProviderSubItem2==null){

      specificProviderSubItem2 = new ACRadioButtonItem();

      specificProviderSubItem2.setText("����");

      specificProviderSubItem2.setGroup(getSpecificProviderSub());

      specificProviderSubItem2.setConstraints(VRLayout.FLOW);

      addSpecificProviderSubItem2();
    }
    return specificProviderSubItem2;

  }

  /**
   * ���莖�Ə����Z���擾���܂��B
   * @return ���莖�Ə����Z
   */
  public ACValueArrayRadioButtonGroup getSpecificProviderAdd(){
    if(specificProviderAdd==null){

      specificProviderAdd = new ACValueArrayRadioButtonGroup();

      getSpecificProviderAddContainer().setText("���莖�Ə����Z");

      specificProviderAdd.setBindPath("1430104");

      specificProviderAdd.setNoSelectIndex(0);

      specificProviderAdd.setUseClearButton(false);

      specificProviderAdd.setModel(getSpecificProviderAddModel());

      specificProviderAdd.setValues(new int[]{1,2,3,4});

      addSpecificProviderAdd();
    }
    return specificProviderAdd;

  }

  /**
   * ���莖�Ə����Z�R���e�i���擾���܂��B
   * @return ���莖�Ə����Z�R���e�i
   */
  protected ACLabelContainer getSpecificProviderAddContainer(){
    if(specificProviderAddContainer==null){
      specificProviderAddContainer = new ACLabelContainer();
      specificProviderAddContainer.setFollowChildEnabled(true);
      specificProviderAddContainer.setVAlignment(VRLayout.CENTER);
      specificProviderAddContainer.add(getSpecificProviderAdd(), null);
    }
    return specificProviderAddContainer;
  }

  /**
   * ���莖�Ə����Z���f�����擾���܂��B
   * @return ���莖�Ə����Z���f��
   */
  protected ACListModelAdapter getSpecificProviderAddModel(){
    if(specificProviderAddModel==null){
      specificProviderAddModel = new ACListModelAdapter();
      addSpecificProviderAddModel();
    }
    return specificProviderAddModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getSpecificProviderAddItem1(){
    if(specificProviderAddItem1==null){

      specificProviderAddItem1 = new ACRadioButtonItem();

      specificProviderAddItem1.setText("�Ȃ�");

      specificProviderAddItem1.setGroup(getSpecificProviderAdd());

      specificProviderAddItem1.setConstraints(VRLayout.FLOW);

      addSpecificProviderAddItem1();
    }
    return specificProviderAddItem1;

  }

  /**
   * ���ZI���擾���܂��B
   * @return ���ZI
   */
  public ACRadioButtonItem getSpecificProviderAddItem2(){
    if(specificProviderAddItem2==null){

      specificProviderAddItem2 = new ACRadioButtonItem();

      specificProviderAddItem2.setText("���ZI");

      specificProviderAddItem2.setGroup(getSpecificProviderAdd());

      specificProviderAddItem2.setConstraints(VRLayout.FLOW);

      addSpecificProviderAddItem2();
    }
    return specificProviderAddItem2;

  }

  /**
   * ���ZII���擾���܂��B
   * @return ���ZII
   */
  public ACRadioButtonItem getSpecificProviderAddItem3(){
    if(specificProviderAddItem3==null){

      specificProviderAddItem3 = new ACRadioButtonItem();

      specificProviderAddItem3.setText("���ZII");

      specificProviderAddItem3.setGroup(getSpecificProviderAdd());

      specificProviderAddItem3.setConstraints(VRLayout.FLOW);

      addSpecificProviderAddItem3();
    }
    return specificProviderAddItem3;

  }

  /**
   * ���ZIII���擾���܂��B
   * @return ���ZIII
   */
  public ACRadioButtonItem getSpecificProviderAddItem4(){
    if(specificProviderAddItem4==null){

      specificProviderAddItem4 = new ACRadioButtonItem();

      specificProviderAddItem4.setText("���ZIII");

      specificProviderAddItem4.setGroup(getSpecificProviderAdd());

      specificProviderAddItem4.setConstraints(VRLayout.FLOW);

      addSpecificProviderAddItem4();
    }
    return specificProviderAddItem4;

  }

  /**
   * ���莖�Ə����ZIV���擾���܂��B
   * @return ���莖�Ə����ZIV
   */
  public ACValueArrayRadioButtonGroup getSpecificProviderAdd4(){
    if(specificProviderAdd4==null){

      specificProviderAdd4 = new ACValueArrayRadioButtonGroup();

      getSpecificProviderAdd4Container().setText("���莖�Ə����ZIV");

      specificProviderAdd4.setBindPath("1430105");

      specificProviderAdd4.setNoSelectIndex(0);

      specificProviderAdd4.setUseClearButton(false);

      specificProviderAdd4.setModel(getSpecificProviderAdd4Model());

      specificProviderAdd4.setValues(new int[]{1,2});

      addSpecificProviderAdd4();
    }
    return specificProviderAdd4;

  }

  /**
   * ���莖�Ə����ZIV�R���e�i���擾���܂��B
   * @return ���莖�Ə����ZIV�R���e�i
   */
  protected ACLabelContainer getSpecificProviderAdd4Container(){
    if(specificProviderAdd4Container==null){
      specificProviderAdd4Container = new ACLabelContainer();
      specificProviderAdd4Container.setFollowChildEnabled(true);
      specificProviderAdd4Container.setVAlignment(VRLayout.CENTER);
      specificProviderAdd4Container.add(getSpecificProviderAdd4(), null);
    }
    return specificProviderAdd4Container;
  }

  /**
   * ���莖�Ə����ZIV���f�����擾���܂��B
   * @return ���莖�Ə����ZIV���f��
   */
  protected ACListModelAdapter getSpecificProviderAdd4Model(){
    if(specificProviderAdd4Model==null){
      specificProviderAdd4Model = new ACListModelAdapter();
      addSpecificProviderAdd4Model();
    }
    return specificProviderAdd4Model;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getSpecificProviderAdd4Item1(){
    if(specificProviderAdd4Item1==null){

      specificProviderAdd4Item1 = new ACRadioButtonItem();

      specificProviderAdd4Item1.setText("�Ȃ�");

      specificProviderAdd4Item1.setGroup(getSpecificProviderAdd4());

      specificProviderAdd4Item1.setConstraints(VRLayout.FLOW);

      addSpecificProviderAdd4Item1();
    }
    return specificProviderAdd4Item1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getSpecificProviderAdd4Item2(){
    if(specificProviderAdd4Item2==null){

      specificProviderAdd4Item2 = new ACRadioButtonItem();

      specificProviderAdd4Item2.setText("����");

      specificProviderAdd4Item2.setGroup(getSpecificProviderAdd4());

      specificProviderAdd4Item2.setConstraints(VRLayout.FLOW);

      addSpecificProviderAdd4Item2();
    }
    return specificProviderAdd4Item2;

  }

  /**
   * �^�[�~�i���P�A�}�l�W�����g���Z���擾���܂��B
   * @return �^�[�~�i���P�A�}�l�W�����g���Z
   */
  public ACValueArrayRadioButtonGroup getTerminalCareManagement(){
    if(terminalCareManagement==null){

      terminalCareManagement = new ACValueArrayRadioButtonGroup();

      getTerminalCareManagementContainer().setText("�^�[�~�i���P�A�}�l�W�����g���Z");

      terminalCareManagement.setBindPath("1430106");

      terminalCareManagement.setNoSelectIndex(0);

      terminalCareManagement.setUseClearButton(false);

      terminalCareManagement.setModel(getTerminalCareManagementModel());

      terminalCareManagement.setValues(new int[]{1,2});

      addTerminalCareManagement();
    }
    return terminalCareManagement;

  }

  /**
   * �^�[�~�i���P�A�}�l�W�����g���Z�R���e�i���擾���܂��B
   * @return �^�[�~�i���P�A�}�l�W�����g���Z�R���e�i
   */
  protected ACLabelContainer getTerminalCareManagementContainer(){
    if(terminalCareManagementContainer==null){
      terminalCareManagementContainer = new ACLabelContainer();
      terminalCareManagementContainer.setFollowChildEnabled(true);
      terminalCareManagementContainer.setVAlignment(VRLayout.CENTER);
      terminalCareManagementContainer.add(getTerminalCareManagement(), null);
    }
    return terminalCareManagementContainer;
  }

  /**
   * �^�[�~�i���P�A�}�l�W�����g���Z���f�����擾���܂��B
   * @return �^�[�~�i���P�A�}�l�W�����g���Z���f��
   */
  protected ACListModelAdapter getTerminalCareManagementModel(){
    if(terminalCareManagementModel==null){
      terminalCareManagementModel = new ACListModelAdapter();
      addTerminalCareManagementModel();
    }
    return terminalCareManagementModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getTerminalCareManagementItem1(){
    if(terminalCareManagementItem1==null){

      terminalCareManagementItem1 = new ACRadioButtonItem();

      terminalCareManagementItem1.setText("�Ȃ�");

      terminalCareManagementItem1.setGroup(getTerminalCareManagement());

      terminalCareManagementItem1.setConstraints(VRLayout.FLOW);

      addTerminalCareManagementItem1();
    }
    return terminalCareManagementItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getTerminalCareManagementItem2(){
    if(terminalCareManagementItem2==null){

      terminalCareManagementItem2 = new ACRadioButtonItem();

      terminalCareManagementItem2.setText("����");

      terminalCareManagementItem2.setGroup(getTerminalCareManagement());

      terminalCareManagementItem2.setConstraints(VRLayout.FLOW);

      addTerminalCareManagementItem2();
    }
    return terminalCareManagementItem2;

  }

  /**
   * �R���X�g���N�^�ł��B
   */
  public QO004_14311_201804Design() {

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

    calculationDetails.add(getProviderAddMountainousAreaRafioRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails.add(getProviderAddMountainousAreaScaleRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails.add(getSpecificProviderSubContainer(), VRLayout.FLOW_RETURN);

    calculationDetails.add(getSpecificProviderAddContainer(), VRLayout.FLOW_RETURN);

    calculationDetails.add(getSpecificProviderAdd4Container(), VRLayout.FLOW_RETURN);

    calculationDetails.add(getTerminalCareManagementContainer(), VRLayout.FLOW_RETURN);

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
   * ���莖�Ə��W�����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addSpecificProviderSub(){

  }

  /**
   * ���莖�Ə��W�����Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addSpecificProviderSubModel(){

    getSpecificProviderSubItem1().setButtonIndex(1);

    getSpecificProviderSubModel().add(getSpecificProviderSubItem1());

    getSpecificProviderSubItem2().setButtonIndex(2);

    getSpecificProviderSubModel().add(getSpecificProviderSubItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addSpecificProviderSubItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addSpecificProviderSubItem2(){

  }

  /**
   * ���莖�Ə����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addSpecificProviderAdd(){

  }

  /**
   * ���莖�Ə����Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addSpecificProviderAddModel(){

    getSpecificProviderAddItem1().setButtonIndex(1);

    getSpecificProviderAddModel().add(getSpecificProviderAddItem1());

    getSpecificProviderAddItem2().setButtonIndex(2);

    getSpecificProviderAddModel().add(getSpecificProviderAddItem2());

    getSpecificProviderAddItem3().setButtonIndex(3);

    getSpecificProviderAddModel().add(getSpecificProviderAddItem3());

    getSpecificProviderAddItem4().setButtonIndex(4);

    getSpecificProviderAddModel().add(getSpecificProviderAddItem4());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addSpecificProviderAddItem1(){

  }

  /**
   * ���ZI�ɓ������ڂ�ǉ����܂��B
   */
  protected void addSpecificProviderAddItem2(){

  }

  /**
   * ���ZII�ɓ������ڂ�ǉ����܂��B
   */
  protected void addSpecificProviderAddItem3(){

  }

  /**
   * ���ZIII�ɓ������ڂ�ǉ����܂��B
   */
  protected void addSpecificProviderAddItem4(){

  }

  /**
   * ���莖�Ə����ZIV�ɓ������ڂ�ǉ����܂��B
   */
  protected void addSpecificProviderAdd4(){

  }

  /**
   * ���莖�Ə����ZIV���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addSpecificProviderAdd4Model(){

    getSpecificProviderAdd4Item1().setButtonIndex(1);

    getSpecificProviderAdd4Model().add(getSpecificProviderAdd4Item1());

    getSpecificProviderAdd4Item2().setButtonIndex(2);

    getSpecificProviderAdd4Model().add(getSpecificProviderAdd4Item2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addSpecificProviderAdd4Item1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addSpecificProviderAdd4Item2(){

  }

  /**
   * �^�[�~�i���P�A�}�l�W�����g���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTerminalCareManagement(){

  }

  /**
   * �^�[�~�i���P�A�}�l�W�����g���Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addTerminalCareManagementModel(){

    getTerminalCareManagementItem1().setButtonIndex(1);

    getTerminalCareManagementModel().add(getTerminalCareManagementItem1());

    getTerminalCareManagementItem2().setButtonIndex(2);

    getTerminalCareManagementModel().add(getTerminalCareManagementItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addTerminalCareManagementItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addTerminalCareManagementItem2(){

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
      ACFrame.debugStart(new ACAffairInfo(QO004_14311_201804Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QO004_14311_201804Design getThis() {
    return this;
  }
}
