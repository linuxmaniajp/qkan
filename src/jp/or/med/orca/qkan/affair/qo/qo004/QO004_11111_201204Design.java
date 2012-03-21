
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
 * �쐬��: 2012/02/03  ���{�R���s���[�^�[������� ���{�@�K�� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���̑��@�\ (O)
 * �v���Z�X ���Ǝғo�^ (004)
 * �v���O���� �K���� (QO004_11111_201204)
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
 * �K�����ʍ��ڃf�U�C��(QO004_11111_201204) 
 */
public class QO004_11111_201204Design extends QO004ProviderPanel {
  //GUI�R���|�[�l���g

  private ACGroupBox mainGroup;

  private ACValueArrayRadioButtonGroup dayTimeRadioGroup;

  private ACLabelContainer dayTimeRadioGroupContainer;

  private ACListModelAdapter dayTimeRadioGroupModel;

  private ACRadioButtonItem dayTimeRadioItem1;

  private ACRadioButtonItem dayTimeRadioItem2;

  private ACValueArrayRadioButtonGroup secondClassServiceRadioGroup;

  private ACLabelContainer secondClassServiceRadioGroupContainer;

  private ACListModelAdapter secondClassServiceRadioGroupModel;

  private ACRadioButtonItem secondClassServiceRadioItem1;

  private ACRadioButtonItem secondClassServiceRadioItem2;

  private ACValueArrayRadioButtonGroup sameBuildingRadioGroup;

  private ACLabelContainer sameBuildingRadioGroupContainer;

  private ACListModelAdapter sameBuildingRadioGroupModel;

  private ACRadioButtonItem sameBuildingRadioItem1;

  private ACRadioButtonItem sameBuildingRadioItem2;

  private ACValueArrayRadioButtonGroup specificProviderAdd;

  private ACLabelContainer specificProviderAddContainer;

  private ACListModelAdapter specificProviderAddModel;

  private ACRadioButtonItem specificProviderAddItem1;

  private ACRadioButtonItem specificProviderAddItem2;

  private ACRadioButtonItem specificProviderAddItem3;

  private ACRadioButtonItem specificProviderAddItem4;

  private ACValueArrayRadioButtonGroup staffUpgradeRadioGroup;

  private ACLabelContainer staffUpgradeRadioGroupContainer;

  private ACListModelAdapter staffUpgradeRadioGroupModel;

  private ACRadioButtonItem staffUpgradeRadioItem1;

  private ACRadioButtonItem staffUpgradeRadioItem2;

  private ACRadioButtonItem staffUpgradeRadioItem3;

  private ACRadioButtonItem staffUpgradeRadioItem4;

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

  private ACLabelContainer reduceRateContainer;

  private ACTextField reduceRate;

  private ACLabel percentSign;

  private ACIntegerCheckBox ShahukuReduce;

  //getter

  /**
   * ���ƃO���[�v���擾���܂��B
   * @return ���ƃO���[�v
   */
  public ACGroupBox getMainGroup(){
    if(mainGroup==null){

      mainGroup = new ACGroupBox();

      mainGroup.setText("�K����");

      mainGroup.setFollowChildEnabled(true);

      addMainGroup();
    }
    return mainGroup;

  }

  /**
   * �����̐g�̉��20�������̐����擾���܂��B
   * @return �����̐g�̉��20�������̐�
   */
  public ACValueArrayRadioButtonGroup getDayTimeRadioGroup(){
    if(dayTimeRadioGroup==null){

      dayTimeRadioGroup = new ACValueArrayRadioButtonGroup();

      getDayTimeRadioGroupContainer().setText("�����̐g�̉��20�������̐�");

      dayTimeRadioGroup.setBindPath("1110104");

      dayTimeRadioGroup.setVisible(true);

      dayTimeRadioGroup.setEnabled(true);

      dayTimeRadioGroup.setNoSelectIndex(0);

      dayTimeRadioGroup.setUseClearButton(false);

      dayTimeRadioGroup.setModel(getDayTimeRadioGroupModel());

      dayTimeRadioGroup.setValues(new int[]{1,2});

      addDayTimeRadioGroup();
    }
    return dayTimeRadioGroup;

  }

  /**
   * �����̐g�̉��20�������̐��R���e�i���擾���܂��B
   * @return �����̐g�̉��20�������̐��R���e�i
   */
  protected ACLabelContainer getDayTimeRadioGroupContainer(){
    if(dayTimeRadioGroupContainer==null){
      dayTimeRadioGroupContainer = new ACLabelContainer();
      dayTimeRadioGroupContainer.setFollowChildEnabled(true);
      dayTimeRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      dayTimeRadioGroupContainer.add(getDayTimeRadioGroup(), null);
    }
    return dayTimeRadioGroupContainer;
  }

  /**
   * �����̐g�̉��20�������̐����f�����擾���܂��B
   * @return �����̐g�̉��20�������̐����f��
   */
  protected ACListModelAdapter getDayTimeRadioGroupModel(){
    if(dayTimeRadioGroupModel==null){
      dayTimeRadioGroupModel = new ACListModelAdapter();
      addDayTimeRadioGroupModel();
    }
    return dayTimeRadioGroupModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getDayTimeRadioItem1(){
    if(dayTimeRadioItem1==null){

      dayTimeRadioItem1 = new ACRadioButtonItem();

      dayTimeRadioItem1.setText("�Ȃ�");

      dayTimeRadioItem1.setGroup(getDayTimeRadioGroup());

      dayTimeRadioItem1.setConstraints(VRLayout.FLOW);

      addDayTimeRadioItem1();
    }
    return dayTimeRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getDayTimeRadioItem2(){
    if(dayTimeRadioItem2==null){

      dayTimeRadioItem2 = new ACRadioButtonItem();

      dayTimeRadioItem2.setText("����");

      dayTimeRadioItem2.setGroup(getDayTimeRadioGroup());

      dayTimeRadioItem2.setConstraints(VRLayout.FLOW);

      addDayTimeRadioItem2();
    }
    return dayTimeRadioItem2;

  }

  /**
   * �T�[�r�X�񋟐ӔC�ґ̐����擾���܂��B
   * @return �T�[�r�X�񋟐ӔC�ґ̐�
   */
  public ACValueArrayRadioButtonGroup getSecondClassServiceRadioGroup(){
    if(secondClassServiceRadioGroup==null){

      secondClassServiceRadioGroup = new ACValueArrayRadioButtonGroup();

      getSecondClassServiceRadioGroupContainer().setText("�T�[�r�X�񋟐ӔC�ґ̐�");

      secondClassServiceRadioGroup.setBindPath("1110103");

      secondClassServiceRadioGroup.setVisible(true);

      secondClassServiceRadioGroup.setEnabled(true);

      secondClassServiceRadioGroup.setNoSelectIndex(0);

      secondClassServiceRadioGroup.setUseClearButton(false);

      secondClassServiceRadioGroup.setModel(getSecondClassServiceRadioGroupModel());

      secondClassServiceRadioGroup.setValues(new int[]{1,2});

      addSecondClassServiceRadioGroup();
    }
    return secondClassServiceRadioGroup;

  }

  /**
   * �T�[�r�X�񋟐ӔC�ґ̐��R���e�i���擾���܂��B
   * @return �T�[�r�X�񋟐ӔC�ґ̐��R���e�i
   */
  protected ACLabelContainer getSecondClassServiceRadioGroupContainer(){
    if(secondClassServiceRadioGroupContainer==null){
      secondClassServiceRadioGroupContainer = new ACLabelContainer();
      secondClassServiceRadioGroupContainer.setFollowChildEnabled(true);
      secondClassServiceRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      secondClassServiceRadioGroupContainer.add(getSecondClassServiceRadioGroup(), null);
    }
    return secondClassServiceRadioGroupContainer;
  }

  /**
   * �T�[�r�X�񋟐ӔC�ґ̐����f�����擾���܂��B
   * @return �T�[�r�X�񋟐ӔC�ґ̐����f��
   */
  protected ACListModelAdapter getSecondClassServiceRadioGroupModel(){
    if(secondClassServiceRadioGroupModel==null){
      secondClassServiceRadioGroupModel = new ACListModelAdapter();
      addSecondClassServiceRadioGroupModel();
    }
    return secondClassServiceRadioGroupModel;
  }

  /**
   * ���Z�Ȃ����擾���܂��B
   * @return ���Z�Ȃ�
   */
  public ACRadioButtonItem getSecondClassServiceRadioItem1(){
    if(secondClassServiceRadioItem1==null){

      secondClassServiceRadioItem1 = new ACRadioButtonItem();

      secondClassServiceRadioItem1.setText("���Z�Ȃ�");

      secondClassServiceRadioItem1.setGroup(getSecondClassServiceRadioGroup());

      secondClassServiceRadioItem1.setConstraints(VRLayout.FLOW);

      addSecondClassServiceRadioItem1();
    }
    return secondClassServiceRadioItem1;

  }

  /**
   * ���Z������擾���܂��B
   * @return ���Z����
   */
  public ACRadioButtonItem getSecondClassServiceRadioItem2(){
    if(secondClassServiceRadioItem2==null){

      secondClassServiceRadioItem2 = new ACRadioButtonItem();

      secondClassServiceRadioItem2.setText("���Z����");

      secondClassServiceRadioItem2.setGroup(getSecondClassServiceRadioGroup());

      secondClassServiceRadioItem2.setConstraints(VRLayout.FLOW);

      addSecondClassServiceRadioItem2();
    }
    return secondClassServiceRadioItem2;

  }

  /**
   * ���ꌚ���ɋ��Z���闘�p�҂̌��Z���擾���܂��B
   * @return ���ꌚ���ɋ��Z���闘�p�҂̌��Z
   */
  public ACValueArrayRadioButtonGroup getSameBuildingRadioGroup(){
    if(sameBuildingRadioGroup==null){

      sameBuildingRadioGroup = new ACValueArrayRadioButtonGroup();

      getSameBuildingRadioGroupContainer().setText("���ꌚ���ɋ��Z���闘�p�҂̌��Z");

      sameBuildingRadioGroup.setBindPath("5");

      sameBuildingRadioGroup.setVisible(true);

      sameBuildingRadioGroup.setEnabled(true);

      sameBuildingRadioGroup.setNoSelectIndex(0);

      sameBuildingRadioGroup.setUseClearButton(false);

      sameBuildingRadioGroup.setModel(getSameBuildingRadioGroupModel());

      sameBuildingRadioGroup.setValues(new int[]{1,2});

      addSameBuildingRadioGroup();
    }
    return sameBuildingRadioGroup;

  }

  /**
   * ���ꌚ���ɋ��Z���闘�p�҂̌��Z�R���e�i���擾���܂��B
   * @return ���ꌚ���ɋ��Z���闘�p�҂̌��Z�R���e�i
   */
  protected ACLabelContainer getSameBuildingRadioGroupContainer(){
    if(sameBuildingRadioGroupContainer==null){
      sameBuildingRadioGroupContainer = new ACLabelContainer();
      sameBuildingRadioGroupContainer.setFollowChildEnabled(true);
      sameBuildingRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      sameBuildingRadioGroupContainer.add(getSameBuildingRadioGroup(), null);
    }
    return sameBuildingRadioGroupContainer;
  }

  /**
   * ���ꌚ���ɋ��Z���闘�p�҂̌��Z���f�����擾���܂��B
   * @return ���ꌚ���ɋ��Z���闘�p�҂̌��Z���f��
   */
  protected ACListModelAdapter getSameBuildingRadioGroupModel(){
    if(sameBuildingRadioGroupModel==null){
      sameBuildingRadioGroupModel = new ACListModelAdapter();
      addSameBuildingRadioGroupModel();
    }
    return sameBuildingRadioGroupModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getSameBuildingRadioItem1(){
    if(sameBuildingRadioItem1==null){

      sameBuildingRadioItem1 = new ACRadioButtonItem();

      sameBuildingRadioItem1.setText("�Ȃ�");

      sameBuildingRadioItem1.setGroup(getSameBuildingRadioGroup());

      sameBuildingRadioItem1.setConstraints(VRLayout.FLOW);

      addSameBuildingRadioItem1();
    }
    return sameBuildingRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getSameBuildingRadioItem2(){
    if(sameBuildingRadioItem2==null){

      sameBuildingRadioItem2 = new ACRadioButtonItem();

      sameBuildingRadioItem2.setText("����");

      sameBuildingRadioItem2.setGroup(getSameBuildingRadioGroup());

      sameBuildingRadioItem2.setConstraints(VRLayout.FLOW);

      addSameBuildingRadioItem2();
    }
    return sameBuildingRadioItem2;

  }

  /**
   * ���莖�Ə����Z���擾���܂��B
   * @return ���莖�Ə����Z
   */
  public ACValueArrayRadioButtonGroup getSpecificProviderAdd(){
    if(specificProviderAdd==null){

      specificProviderAdd = new ACValueArrayRadioButtonGroup();

      getSpecificProviderAddContainer().setText("���莖�Ə����Z");

      specificProviderAdd.setBindPath("1110101");

      specificProviderAdd.setEnabled(true);

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
   * ���E���������P���Z���擾���܂��B
   * @return ���E���������P���Z
   */
  public ACValueArrayRadioButtonGroup getStaffUpgradeRadioGroup(){
    if(staffUpgradeRadioGroup==null){

      staffUpgradeRadioGroup = new ACValueArrayRadioButtonGroup();

      getStaffUpgradeRadioGroupContainer().setText("���E���������P���Z");

      staffUpgradeRadioGroup.setBindPath("4");

      staffUpgradeRadioGroup.setVisible(true);

      staffUpgradeRadioGroup.setEnabled(true);

      staffUpgradeRadioGroup.setUseClearButton(false);

      staffUpgradeRadioGroup.setModel(getStaffUpgradeRadioGroupModel());

      staffUpgradeRadioGroup.setValues(new int[]{1,2,3,4});

      addStaffUpgradeRadioGroup();
    }
    return staffUpgradeRadioGroup;

  }

  /**
   * ���E���������P���Z�R���e�i���擾���܂��B
   * @return ���E���������P���Z�R���e�i
   */
  protected ACLabelContainer getStaffUpgradeRadioGroupContainer(){
    if(staffUpgradeRadioGroupContainer==null){
      staffUpgradeRadioGroupContainer = new ACLabelContainer();
      staffUpgradeRadioGroupContainer.setFollowChildEnabled(true);
      staffUpgradeRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      staffUpgradeRadioGroupContainer.add(getStaffUpgradeRadioGroup(), null);
    }
    return staffUpgradeRadioGroupContainer;
  }

  /**
   * ���E���������P���Z���f�����擾���܂��B
   * @return ���E���������P���Z���f��
   */
  protected ACListModelAdapter getStaffUpgradeRadioGroupModel(){
    if(staffUpgradeRadioGroupModel==null){
      staffUpgradeRadioGroupModel = new ACListModelAdapter();
      addStaffUpgradeRadioGroupModel();
    }
    return staffUpgradeRadioGroupModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getStaffUpgradeRadioItem1(){
    if(staffUpgradeRadioItem1==null){

      staffUpgradeRadioItem1 = new ACRadioButtonItem();

      staffUpgradeRadioItem1.setText("�Ȃ�");

      staffUpgradeRadioItem1.setGroup(getStaffUpgradeRadioGroup());

      staffUpgradeRadioItem1.setConstraints(VRLayout.FLOW);

      addStaffUpgradeRadioItem1();
    }
    return staffUpgradeRadioItem1;

  }

  /**
   * ���ZI���擾���܂��B
   * @return ���ZI
   */
  public ACRadioButtonItem getStaffUpgradeRadioItem2(){
    if(staffUpgradeRadioItem2==null){

      staffUpgradeRadioItem2 = new ACRadioButtonItem();

      staffUpgradeRadioItem2.setText("���ZI");

      staffUpgradeRadioItem2.setGroup(getStaffUpgradeRadioGroup());

      staffUpgradeRadioItem2.setConstraints(VRLayout.FLOW);

      addStaffUpgradeRadioItem2();
    }
    return staffUpgradeRadioItem2;

  }

  /**
   * ���ZII���擾���܂��B
   * @return ���ZII
   */
  public ACRadioButtonItem getStaffUpgradeRadioItem3(){
    if(staffUpgradeRadioItem3==null){

      staffUpgradeRadioItem3 = new ACRadioButtonItem();

      staffUpgradeRadioItem3.setText("���ZII");

      staffUpgradeRadioItem3.setGroup(getStaffUpgradeRadioGroup());

      staffUpgradeRadioItem3.setConstraints(VRLayout.FLOW);

      addStaffUpgradeRadioItem3();
    }
    return staffUpgradeRadioItem3;

  }

  /**
   * ���ZIII���擾���܂��B
   * @return ���ZIII
   */
  public ACRadioButtonItem getStaffUpgradeRadioItem4(){
    if(staffUpgradeRadioItem4==null){

      staffUpgradeRadioItem4 = new ACRadioButtonItem();

      staffUpgradeRadioItem4.setText("���ZIII");

      staffUpgradeRadioItem4.setGroup(getStaffUpgradeRadioGroup());

      staffUpgradeRadioItem4.setConstraints(VRLayout.FLOW);

      addStaffUpgradeRadioItem4();
    }
    return staffUpgradeRadioItem4;

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
   * �����x�����擾���܂��B
   * @return �����x��
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
   * �Е����ƑΏێ��Ǝ҂��擾���܂��B
   * @return �Е����ƑΏێ��Ǝ�
   */
  public ACIntegerCheckBox getShahukuReduce(){
    if(ShahukuReduce==null){

      ShahukuReduce = new ACIntegerCheckBox();

      ShahukuReduce.setText("�Љ���@�l���̌y�����x");

      ShahukuReduce.setBindPath("1");

      ShahukuReduce.setSelectValue(2);

      ShahukuReduce.setUnSelectValue(1);

      addShahukuReduce();
    }
    return ShahukuReduce;

  }

  /**
   * �R���X�g���N�^�ł��B
   */
  public QO004_11111_201204Design() {

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

    mainGroup.add(getDayTimeRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    mainGroup.add(getSecondClassServiceRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    mainGroup.add(getSameBuildingRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    mainGroup.add(getSpecificProviderAddContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    mainGroup.add(getStaffUpgradeRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    mainGroup.add(getProviderAddMountainousAreaRafioRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    mainGroup.add(getProviderAddMountainousAreaScaleRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    mainGroup.add(getReduceRateContainer(), VRLayout.FLOW_INSETLINE);

    mainGroup.add(getShahukuReduce(), VRLayout.FLOW_RETURN);

  }

  /**
   * �����̐g�̉��20�������̐��ɓ������ڂ�ǉ����܂��B
   */
  protected void addDayTimeRadioGroup(){

  }

  /**
   * �����̐g�̉��20�������̐����f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addDayTimeRadioGroupModel(){

    getDayTimeRadioItem1().setButtonIndex(1);

    getDayTimeRadioGroupModel().add(getDayTimeRadioItem1());

    getDayTimeRadioItem2().setButtonIndex(2);

    getDayTimeRadioGroupModel().add(getDayTimeRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addDayTimeRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addDayTimeRadioItem2(){

  }

  /**
   * �T�[�r�X�񋟐ӔC�ґ̐��ɓ������ڂ�ǉ����܂��B
   */
  protected void addSecondClassServiceRadioGroup(){

  }

  /**
   * �T�[�r�X�񋟐ӔC�ґ̐����f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addSecondClassServiceRadioGroupModel(){

    getSecondClassServiceRadioItem1().setButtonIndex(1);

    getSecondClassServiceRadioGroupModel().add(getSecondClassServiceRadioItem1());

    getSecondClassServiceRadioItem2().setButtonIndex(2);

    getSecondClassServiceRadioGroupModel().add(getSecondClassServiceRadioItem2());

  }

  /**
   * ���Z�Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addSecondClassServiceRadioItem1(){

  }

  /**
   * ���Z����ɓ������ڂ�ǉ����܂��B
   */
  protected void addSecondClassServiceRadioItem2(){

  }

  /**
   * ���ꌚ���ɋ��Z���闘�p�҂̌��Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addSameBuildingRadioGroup(){

  }

  /**
   * ���ꌚ���ɋ��Z���闘�p�҂̌��Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addSameBuildingRadioGroupModel(){

    getSameBuildingRadioItem1().setButtonIndex(1);

    getSameBuildingRadioGroupModel().add(getSameBuildingRadioItem1());

    getSameBuildingRadioItem2().setButtonIndex(2);

    getSameBuildingRadioGroupModel().add(getSameBuildingRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addSameBuildingRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addSameBuildingRadioItem2(){

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
   * ���E���������P���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffUpgradeRadioGroup(){

  }

  /**
   * ���E���������P���Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffUpgradeRadioGroupModel(){

    getStaffUpgradeRadioItem1().setButtonIndex(1);

    getStaffUpgradeRadioGroupModel().add(getStaffUpgradeRadioItem1());

    getStaffUpgradeRadioItem2().setButtonIndex(2);

    getStaffUpgradeRadioGroupModel().add(getStaffUpgradeRadioItem2());

    getStaffUpgradeRadioItem3().setButtonIndex(3);

    getStaffUpgradeRadioGroupModel().add(getStaffUpgradeRadioItem3());

    getStaffUpgradeRadioItem4().setButtonIndex(4);

    getStaffUpgradeRadioGroupModel().add(getStaffUpgradeRadioItem4());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffUpgradeRadioItem1(){

  }

  /**
   * ���ZI�ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffUpgradeRadioItem2(){

  }

  /**
   * ���ZII�ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffUpgradeRadioItem3(){

  }

  /**
   * ���ZIII�ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffUpgradeRadioItem4(){

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
   * �����x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addPercentSign(){

  }

  /**
   * �Е����ƑΏێ��Ǝ҂ɓ������ڂ�ǉ����܂��B
   */
  protected void addShahukuReduce(){

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
      ACFrame.debugStart(new ACAffairInfo(QO004_11111_201204Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QO004_11111_201204Design getThis() {
    return this;
  }
}
