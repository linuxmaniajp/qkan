
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
 * �쐬��: 2015/02/28  ���{�R���s���[�^�[������� ��i�@�a�P �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���̑��@�\ (O)
 * �v���Z�X ���Ǝғo�^ (004)
 * �v���O���� ���\�h�K���� (QO004_16111_201504)
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
 * ���\�h�K�����ʍ��ڃf�U�C��(QO004_16111_201504) 
 */
public class QO004_16111_201504Design extends QO004ProviderPanel {
  //GUI�R���|�[�l���g

  private ACGroupBox mainGroup;

  private ACValueArrayRadioButtonGroup secondClassOfferRadioGroup;

  private ACLabelContainer secondClassOfferRadioGroupContainer;

  private ACListModelAdapter secondClassOfferRadioGroupModel;

  private ACRadioButtonItem secondClassOfferRadioItem1;

  private ACRadioButtonItem secondClassOfferRadioItem2;

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

  private ACValueArrayRadioButtonGroup staffUpgradeRadioGroup;

  private ACLabelContainer staffUpgradeRadioGroupContainer;

  private ACListModelAdapter staffUpgradeRadioGroupModel;

  private ACRadioButtonItem staffUpgradeRadioItem1;

  private ACRadioButtonItem staffUpgradeRadioItem2;

  private ACRadioButtonItem staffUpgradeRadioItem3;

  private ACRadioButtonItem staffUpgradeRadioItem4;

  private ACRadioButtonItem staffUpgradeRadioItem5;

  private ACLabelContainer reduceRateContainer;

  private ACTextField reduceRate;

  private ACLabel percentSign;

  private ACIntegerCheckBox ShahukuReduce;

  private ACPanel oldLowElementArea;

  //getter

  /**
   * ���ƃO���[�v���擾���܂��B
   * @return ���ƃO���[�v
   */
  public ACGroupBox getMainGroup(){
    if(mainGroup==null){

      mainGroup = new ACGroupBox();

      mainGroup.setText("���\�h�K����");

      mainGroup.setFollowChildEnabled(true);

      addMainGroup();
    }
    return mainGroup;

  }

  /**
   * �T�[�r�X�񋟐ӔC�ґ̐��̌��Z���擾���܂��B
   * @return �T�[�r�X�񋟐ӔC�ґ̐��̌��Z
   */
  public ACValueArrayRadioButtonGroup getSecondClassOfferRadioGroup(){
    if(secondClassOfferRadioGroup==null){

      secondClassOfferRadioGroup = new ACValueArrayRadioButtonGroup();

      getSecondClassOfferRadioGroupContainer().setText("�T�[�r�X�񋟐ӔC�ґ̐��̌��Z");

      secondClassOfferRadioGroup.setBindPath("1610105");

      secondClassOfferRadioGroup.setVisible(true);

      secondClassOfferRadioGroup.setEnabled(true);

      secondClassOfferRadioGroup.setNoSelectIndex(0);

      secondClassOfferRadioGroup.setUseClearButton(false);

      secondClassOfferRadioGroup.setModel(getSecondClassOfferRadioGroupModel());

      secondClassOfferRadioGroup.setValues(new int[]{1,2});

      addSecondClassOfferRadioGroup();
    }
    return secondClassOfferRadioGroup;

  }

  /**
   * �T�[�r�X�񋟐ӔC�ґ̐��̌��Z�R���e�i���擾���܂��B
   * @return �T�[�r�X�񋟐ӔC�ґ̐��̌��Z�R���e�i
   */
  protected ACLabelContainer getSecondClassOfferRadioGroupContainer(){
    if(secondClassOfferRadioGroupContainer==null){
      secondClassOfferRadioGroupContainer = new ACLabelContainer();
      secondClassOfferRadioGroupContainer.setFollowChildEnabled(true);
      secondClassOfferRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      secondClassOfferRadioGroupContainer.add(getSecondClassOfferRadioGroup(), null);
    }
    return secondClassOfferRadioGroupContainer;
  }

  /**
   * �T�[�r�X�񋟐ӔC�ґ̐��̌��Z���f�����擾���܂��B
   * @return �T�[�r�X�񋟐ӔC�ґ̐��̌��Z���f��
   */
  protected ACListModelAdapter getSecondClassOfferRadioGroupModel(){
    if(secondClassOfferRadioGroupModel==null){
      secondClassOfferRadioGroupModel = new ACListModelAdapter();
      addSecondClassOfferRadioGroupModel();
    }
    return secondClassOfferRadioGroupModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getSecondClassOfferRadioItem1(){
    if(secondClassOfferRadioItem1==null){

      secondClassOfferRadioItem1 = new ACRadioButtonItem();

      secondClassOfferRadioItem1.setText("�Ȃ�");

      secondClassOfferRadioItem1.setGroup(getSecondClassOfferRadioGroup());

      secondClassOfferRadioItem1.setConstraints(VRLayout.FLOW);

      addSecondClassOfferRadioItem1();
    }
    return secondClassOfferRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getSecondClassOfferRadioItem2(){
    if(secondClassOfferRadioItem2==null){

      secondClassOfferRadioItem2 = new ACRadioButtonItem();

      secondClassOfferRadioItem2.setText("����");

      secondClassOfferRadioItem2.setGroup(getSecondClassOfferRadioGroup());

      secondClassOfferRadioItem2.setConstraints(VRLayout.FLOW);

      addSecondClassOfferRadioItem2();
    }
    return secondClassOfferRadioItem2;

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
   * ���E���������P���Z���擾���܂��B
   * @return ���E���������P���Z
   */
  public ACValueArrayRadioButtonGroup getStaffUpgradeRadioGroup(){
    if(staffUpgradeRadioGroup==null){

      staffUpgradeRadioGroup = new ACValueArrayRadioButtonGroup();

      getStaffUpgradeRadioGroupContainer().setText("���E���������P���Z");

      staffUpgradeRadioGroup.setBindPath("4");

      staffUpgradeRadioGroup.setEnabled(true);

      staffUpgradeRadioGroup.setUseClearButton(false);

      staffUpgradeRadioGroup.setModel(getStaffUpgradeRadioGroupModel());

      staffUpgradeRadioGroup.setValues(new int[]{1,5,2,3,4});

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
   * ���ZIV���擾���܂��B
   * @return ���ZIV
   */
  public ACRadioButtonItem getStaffUpgradeRadioItem5(){
    if(staffUpgradeRadioItem5==null){

      staffUpgradeRadioItem5 = new ACRadioButtonItem();

      staffUpgradeRadioItem5.setText("���ZIV");

      staffUpgradeRadioItem5.setGroup(getStaffUpgradeRadioGroup());

      staffUpgradeRadioItem5.setConstraints(VRLayout.FLOW);

      addStaffUpgradeRadioItem5();
    }
    return staffUpgradeRadioItem5;

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
   * ���@���ڂ��擾���܂��B
   * @return ���@����
   */
  public ACPanel getOldLowElementArea(){
    if(oldLowElementArea==null){

      oldLowElementArea = new ACPanel();

      addOldLowElementArea();
    }
    return oldLowElementArea;

  }

  /**
   * �R���X�g���N�^�ł��B
   */
  public QO004_16111_201504Design() {

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

    mainGroup.add(getSecondClassOfferRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    mainGroup.add(getProviderAddMountainousAreaRafioRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    mainGroup.add(getProviderAddMountainousAreaScaleRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    mainGroup.add(getStaffUpgradeRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    mainGroup.add(getReduceRateContainer(), VRLayout.FLOW_INSETLINE);

    mainGroup.add(getShahukuReduce(), VRLayout.FLOW_RETURN);

    mainGroup.add(getOldLowElementArea(), VRLayout.FLOW_RETURN);

  }

  /**
   * �T�[�r�X�񋟐ӔC�ґ̐��̌��Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addSecondClassOfferRadioGroup(){

  }

  /**
   * �T�[�r�X�񋟐ӔC�ґ̐��̌��Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addSecondClassOfferRadioGroupModel(){

    getSecondClassOfferRadioItem1().setButtonIndex(1);

    getSecondClassOfferRadioGroupModel().add(getSecondClassOfferRadioItem1());

    getSecondClassOfferRadioItem2().setButtonIndex(2);

    getSecondClassOfferRadioGroupModel().add(getSecondClassOfferRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addSecondClassOfferRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addSecondClassOfferRadioItem2(){

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

    getStaffUpgradeRadioItem2().setButtonIndex(5);

    getStaffUpgradeRadioGroupModel().add(getStaffUpgradeRadioItem2());

    getStaffUpgradeRadioItem3().setButtonIndex(2);

    getStaffUpgradeRadioGroupModel().add(getStaffUpgradeRadioItem3());

    getStaffUpgradeRadioItem4().setButtonIndex(3);

    getStaffUpgradeRadioGroupModel().add(getStaffUpgradeRadioItem4());

    getStaffUpgradeRadioItem5().setButtonIndex(4);

    getStaffUpgradeRadioGroupModel().add(getStaffUpgradeRadioItem5());

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
   * ���ZIV�ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffUpgradeRadioItem5(){

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
   * ���@���ڂɓ������ڂ�ǉ����܂��B
   */
  protected void addOldLowElementArea(){

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
      ACFrame.debugStart(new ACAffairInfo(QO004_16111_201504Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QO004_16111_201504Design getThis() {
    return this;
  }
}
