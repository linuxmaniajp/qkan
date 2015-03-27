
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
 * �쐬��: 2015/02/28  ���{�R���s���[�^�[������� ���{�@�K�� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���̑��@�\ (O)
 * �v���Z�X ���Ǝғo�^ (004)
 * �v���O���� ��ԑΉ��^�K��Ō� (QO004_17111_201504)
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
 * ��ԑΉ��^�K��Ō��ʍ��ڃf�U�C��(QO004_17111_201504) 
 */
public class QO004_17111_201504Design extends QO004ProviderPanel {
  //GUI�R���|�[�l���g

  private ACGroupBox mainGroup;

  private ACPanel providerMainPanel;

  private ACValueArrayRadioButtonGroup facilitiesDivision;

  private ACLabelContainer facilitiesDivisionContainer;

  private ACListModelAdapter facilitiesDivisionModel;

  private ACRadioButtonItem facilitiesDivisionItem1;

  private ACRadioButtonItem facilitiesDivisionItem2;

  private ACValueArrayRadioButtonGroup hours24MessageAddRadioGroup;

  private ACLabelContainer hours24MessageAddRadioGroupContainer;

  private ACListModelAdapter hours24MessageAddRadioGroupModel;

  private ACRadioButtonItem hours24MessageAddRadioItem1;

  private ACRadioButtonItem hours24MessageAddRadioItem2;

  private ACValueArrayRadioButtonGroup serviceAddProvisionStructuralRadioGroup;

  private ACLabelContainer serviceAddProvisionStructuralRadioGroupContainer;

  private ACListModelAdapter serviceAddProvisionStructuralRadioGroupModel;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem1;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem2;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem3;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem4;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem5;

  private ACValueArrayRadioButtonGroup staffUpgradeRadioGroup;

  private ACLabelContainer staffUpgradeRadioGroupContainer;

  private ACListModelAdapter staffUpgradeRadioGroupModel;

  private ACRadioButtonItem staffUpgradeRadioItem1;

  private ACRadioButtonItem staffUpgradeRadioItem2;

  private ACRadioButtonItem staffUpgradeRadioItem3;

  private ACRadioButtonItem staffUpgradeRadioItem4;

  private ACRadioButtonItem staffUpgradeRadioItem5;

  private ACValueArrayRadioButtonGroup baseMunicipalityAdd;

  private ACLabelContainer baseMunicipalityAddContainer;

  private ACListModelAdapter baseMunicipalityAddModel;

  private ACRadioButtonItem baseMunicipalityAddItem1;

  private ACRadioButtonItem baseMunicipalityAddItem2;

  private ACRadioButtonItem baseMunicipalityAddItem3;

  private ACRadioButtonItem baseMunicipalityAddItem4;

  private ACRadioButtonItem baseMunicipalityAddItem5;

  private ACRadioButtonItem baseMunicipalityAddItem6;

  private ACRadioButtonItem baseMunicipalityAddItem7;

  private ACValueArrayRadioButtonGroup serviceMunicipalityAdd;

  private ACLabelContainer serviceMunicipalityAddContainer;

  private ACListModelAdapter serviceMunicipalityAddModel;

  private ACRadioButtonItem serviceMunicipalityAddItem1;

  private ACRadioButtonItem serviceMunicipalityAddItem2;

  private ACRadioButtonItem serviceMunicipalityAddItem3;

  private ACRadioButtonItem serviceMunicipalityAddItem4;

  private ACRadioButtonItem serviceMunicipalityAddItem5;

  private ACRadioButtonItem serviceMunicipalityAddItem6;

  private ACRadioButtonItem serviceMunicipalityAddItem7;

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

      mainGroup.setText("��ԑΉ��^�K����");

      mainGroup.setFollowChildEnabled(true);

      mainGroup.setHgrid(200);

      addMainGroup();
    }
    return mainGroup;

  }

  /**
   * ���Ə����C���p�l�����擾���܂��B
   * @return ���Ə����C���p�l��
   */
  public ACPanel getProviderMainPanel(){
    if(providerMainPanel==null){

      providerMainPanel = new ACPanel();

      providerMainPanel.setFollowChildEnabled(true);

      providerMainPanel.setHgap(0);

      providerMainPanel.setLabelMargin(0);

      providerMainPanel.setVgap(0);

      addProviderMainPanel();
    }
    return providerMainPanel;

  }

  /**
   * �{�݋敪���W�I�O���[�v���擾���܂��B
   * @return �{�݋敪���W�I�O���[�v
   */
  public ACValueArrayRadioButtonGroup getFacilitiesDivision(){
    if(facilitiesDivision==null){

      facilitiesDivision = new ACValueArrayRadioButtonGroup();

      getFacilitiesDivisionContainer().setText("�{�ݓ��̋敪");

      facilitiesDivision.setBindPath("1710101");

      facilitiesDivision.setUseClearButton(false);

      facilitiesDivision.setModel(getFacilitiesDivisionModel());

      facilitiesDivision.setValues(new int[]{1,2});

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
   * �T�^���擾���܂��B
   * @return �T�^
   */
  public ACRadioButtonItem getFacilitiesDivisionItem1(){
    if(facilitiesDivisionItem1==null){

      facilitiesDivisionItem1 = new ACRadioButtonItem();

      facilitiesDivisionItem1.setText("I �^");

      facilitiesDivisionItem1.setGroup(getFacilitiesDivision());

      facilitiesDivisionItem1.setConstraints(VRLayout.FLOW);

      addFacilitiesDivisionItem1();
    }
    return facilitiesDivisionItem1;

  }

  /**
   * �U�^���擾���܂��B
   * @return �U�^
   */
  public ACRadioButtonItem getFacilitiesDivisionItem2(){
    if(facilitiesDivisionItem2==null){

      facilitiesDivisionItem2 = new ACRadioButtonItem();

      facilitiesDivisionItem2.setText("II �^");

      facilitiesDivisionItem2.setGroup(getFacilitiesDivision());

      facilitiesDivisionItem2.setConstraints(VRLayout.FLOW);

      addFacilitiesDivisionItem2();
    }
    return facilitiesDivisionItem2;

  }

  /**
   * 24���Ԓʕ�Ή����Z���擾���܂��B
   * @return 24���Ԓʕ�Ή����Z
   */
  public ACValueArrayRadioButtonGroup getHours24MessageAddRadioGroup(){
    if(hours24MessageAddRadioGroup==null){

      hours24MessageAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getHours24MessageAddRadioGroupContainer().setText("24���Ԓʕ�Ή����Z");

      hours24MessageAddRadioGroup.setBindPath("1710103");

      hours24MessageAddRadioGroup.setVisible(true);

      hours24MessageAddRadioGroup.setEnabled(true);

      hours24MessageAddRadioGroup.setNoSelectIndex(0);

      hours24MessageAddRadioGroup.setUseClearButton(false);

      hours24MessageAddRadioGroup.setModel(getHours24MessageAddRadioGroupModel());

      hours24MessageAddRadioGroup.setValues(new int[]{1,2});

      addHours24MessageAddRadioGroup();
    }
    return hours24MessageAddRadioGroup;

  }

  /**
   * 24���Ԓʕ�Ή����Z�R���e�i���擾���܂��B
   * @return 24���Ԓʕ�Ή����Z�R���e�i
   */
  protected ACLabelContainer getHours24MessageAddRadioGroupContainer(){
    if(hours24MessageAddRadioGroupContainer==null){
      hours24MessageAddRadioGroupContainer = new ACLabelContainer();
      hours24MessageAddRadioGroupContainer.setFollowChildEnabled(true);
      hours24MessageAddRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      hours24MessageAddRadioGroupContainer.add(getHours24MessageAddRadioGroup(), null);
    }
    return hours24MessageAddRadioGroupContainer;
  }

  /**
   * 24���Ԓʕ�Ή����Z���f�����擾���܂��B
   * @return 24���Ԓʕ�Ή����Z���f��
   */
  protected ACListModelAdapter getHours24MessageAddRadioGroupModel(){
    if(hours24MessageAddRadioGroupModel==null){
      hours24MessageAddRadioGroupModel = new ACListModelAdapter();
      addHours24MessageAddRadioGroupModel();
    }
    return hours24MessageAddRadioGroupModel;
  }

  /**
   * �Ή��s���擾���܂��B
   * @return �Ή��s��
   */
  public ACRadioButtonItem getHours24MessageAddRadioItem1(){
    if(hours24MessageAddRadioItem1==null){

      hours24MessageAddRadioItem1 = new ACRadioButtonItem();

      hours24MessageAddRadioItem1.setText("�Ή��s��");

      hours24MessageAddRadioItem1.setGroup(getHours24MessageAddRadioGroup());

      hours24MessageAddRadioItem1.setConstraints(VRLayout.FLOW);

      addHours24MessageAddRadioItem1();
    }
    return hours24MessageAddRadioItem1;

  }

  /**
   * �Ή����擾���܂��B
   * @return �Ή���
   */
  public ACRadioButtonItem getHours24MessageAddRadioItem2(){
    if(hours24MessageAddRadioItem2==null){

      hours24MessageAddRadioItem2 = new ACRadioButtonItem();

      hours24MessageAddRadioItem2.setText("�Ή���");

      hours24MessageAddRadioItem2.setGroup(getHours24MessageAddRadioGroup());

      hours24MessageAddRadioItem2.setConstraints(VRLayout.FLOW);

      addHours24MessageAddRadioItem2();
    }
    return hours24MessageAddRadioItem2;

  }

  /**
   * �T�[�r�X�񋟑̐��������Z���擾���܂��B
   * @return �T�[�r�X�񋟑̐��������Z
   */
  public ACValueArrayRadioButtonGroup getServiceAddProvisionStructuralRadioGroup(){
    if(serviceAddProvisionStructuralRadioGroup==null){

      serviceAddProvisionStructuralRadioGroup = new ACValueArrayRadioButtonGroup();

      getServiceAddProvisionStructuralRadioGroupContainer().setText("�T�[�r�X�񋟑̐��������Z");

      serviceAddProvisionStructuralRadioGroup.setBindPath("1710104");

      serviceAddProvisionStructuralRadioGroup.setVisible(true);

      serviceAddProvisionStructuralRadioGroup.setEnabled(true);

      serviceAddProvisionStructuralRadioGroup.setNoSelectIndex(0);

      serviceAddProvisionStructuralRadioGroup.setUseClearButton(false);

      serviceAddProvisionStructuralRadioGroup.setModel(getServiceAddProvisionStructuralRadioGroupModel());

      serviceAddProvisionStructuralRadioGroup.setValues(new int[]{1,4,2,5,3});

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
   * ���ZI�C���擾���܂��B
   * @return ���ZI�C
   */
  public ACRadioButtonItem getServiceAddProvisionStructuralRadioItem2(){
    if(serviceAddProvisionStructuralRadioItem2==null){

      serviceAddProvisionStructuralRadioItem2 = new ACRadioButtonItem();

      serviceAddProvisionStructuralRadioItem2.setText("���ZI�C");

      serviceAddProvisionStructuralRadioItem2.setGroup(getServiceAddProvisionStructuralRadioGroup());

      serviceAddProvisionStructuralRadioItem2.setConstraints(VRLayout.FLOW);

      addServiceAddProvisionStructuralRadioItem2();
    }
    return serviceAddProvisionStructuralRadioItem2;

  }

  /**
   * ���ZI�����擾���܂��B
   * @return ���ZI��
   */
  public ACRadioButtonItem getServiceAddProvisionStructuralRadioItem3(){
    if(serviceAddProvisionStructuralRadioItem3==null){

      serviceAddProvisionStructuralRadioItem3 = new ACRadioButtonItem();

      serviceAddProvisionStructuralRadioItem3.setText("���ZI��");

      serviceAddProvisionStructuralRadioItem3.setGroup(getServiceAddProvisionStructuralRadioGroup());

      serviceAddProvisionStructuralRadioItem3.setConstraints(VRLayout.FLOW);

      addServiceAddProvisionStructuralRadioItem3();
    }
    return serviceAddProvisionStructuralRadioItem3;

  }

  /**
   * ���ZII�C���擾���܂��B
   * @return ���ZII�C
   */
  public ACRadioButtonItem getServiceAddProvisionStructuralRadioItem4(){
    if(serviceAddProvisionStructuralRadioItem4==null){

      serviceAddProvisionStructuralRadioItem4 = new ACRadioButtonItem();

      serviceAddProvisionStructuralRadioItem4.setText("���ZII�C");

      serviceAddProvisionStructuralRadioItem4.setGroup(getServiceAddProvisionStructuralRadioGroup());

      serviceAddProvisionStructuralRadioItem4.setConstraints(VRLayout.FLOW);

      addServiceAddProvisionStructuralRadioItem4();
    }
    return serviceAddProvisionStructuralRadioItem4;

  }

  /**
   * ���ZII�����擾���܂��B
   * @return ���ZII��
   */
  public ACRadioButtonItem getServiceAddProvisionStructuralRadioItem5(){
    if(serviceAddProvisionStructuralRadioItem5==null){

      serviceAddProvisionStructuralRadioItem5 = new ACRadioButtonItem();

      serviceAddProvisionStructuralRadioItem5.setText("���ZII��");

      serviceAddProvisionStructuralRadioItem5.setGroup(getServiceAddProvisionStructuralRadioGroup());

      serviceAddProvisionStructuralRadioItem5.setConstraints(VRLayout.FLOW);

      addServiceAddProvisionStructuralRadioItem5();
    }
    return serviceAddProvisionStructuralRadioItem5;

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
   * ��{��ԖK�� I �s�����Ǝ����Z���擾���܂��B
   * @return ��{��ԖK�� I �s�����Ǝ����Z
   */
  public ACValueArrayRadioButtonGroup getBaseMunicipalityAdd(){
    if(baseMunicipalityAdd==null){

      baseMunicipalityAdd = new ACValueArrayRadioButtonGroup();

      getBaseMunicipalityAddContainer().setText("��{��ԖK�� I �s�����Ǝ����Z");

      baseMunicipalityAdd.setBindPath("1710105");

      baseMunicipalityAdd.setNoSelectIndex(0);

      baseMunicipalityAdd.setUseClearButton(false);

      baseMunicipalityAdd.setModel(getBaseMunicipalityAddModel());

      baseMunicipalityAdd.setValues(new int[]{1,2,3,4,5,6,7});

      addBaseMunicipalityAdd();
    }
    return baseMunicipalityAdd;

  }

  /**
   * ��{��ԖK�� I �s�����Ǝ����Z�R���e�i���擾���܂��B
   * @return ��{��ԖK�� I �s�����Ǝ����Z�R���e�i
   */
  protected ACLabelContainer getBaseMunicipalityAddContainer(){
    if(baseMunicipalityAddContainer==null){
      baseMunicipalityAddContainer = new ACLabelContainer();
      baseMunicipalityAddContainer.setFollowChildEnabled(true);
      baseMunicipalityAddContainer.setVAlignment(VRLayout.CENTER);
      baseMunicipalityAddContainer.add(getBaseMunicipalityAdd(), null);
    }
    return baseMunicipalityAddContainer;
  }

  /**
   * ��{��ԖK�� I �s�����Ǝ����Z���f�����擾���܂��B
   * @return ��{��ԖK�� I �s�����Ǝ����Z���f��
   */
  protected ACListModelAdapter getBaseMunicipalityAddModel(){
    if(baseMunicipalityAddModel==null){
      baseMunicipalityAddModel = new ACListModelAdapter();
      addBaseMunicipalityAddModel();
    }
    return baseMunicipalityAddModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getBaseMunicipalityAddItem1(){
    if(baseMunicipalityAddItem1==null){

      baseMunicipalityAddItem1 = new ACRadioButtonItem();

      baseMunicipalityAddItem1.setText("�Ȃ�");

      baseMunicipalityAddItem1.setGroup(getBaseMunicipalityAdd());

      baseMunicipalityAddItem1.setConstraints(VRLayout.FLOW);

      addBaseMunicipalityAddItem1();
    }
    return baseMunicipalityAddItem1;

  }

  /**
   * ���Z1���擾���܂��B
   * @return ���Z1
   */
  public ACRadioButtonItem getBaseMunicipalityAddItem2(){
    if(baseMunicipalityAddItem2==null){

      baseMunicipalityAddItem2 = new ACRadioButtonItem();

      baseMunicipalityAddItem2.setText("���Z1");

      baseMunicipalityAddItem2.setGroup(getBaseMunicipalityAdd());

      baseMunicipalityAddItem2.setConstraints(VRLayout.FLOW);

      addBaseMunicipalityAddItem2();
    }
    return baseMunicipalityAddItem2;

  }

  /**
   * ���Z2���擾���܂��B
   * @return ���Z2
   */
  public ACRadioButtonItem getBaseMunicipalityAddItem3(){
    if(baseMunicipalityAddItem3==null){

      baseMunicipalityAddItem3 = new ACRadioButtonItem();

      baseMunicipalityAddItem3.setText("���Z2");

      baseMunicipalityAddItem3.setGroup(getBaseMunicipalityAdd());

      baseMunicipalityAddItem3.setConstraints(VRLayout.FLOW);

      addBaseMunicipalityAddItem3();
    }
    return baseMunicipalityAddItem3;

  }

  /**
   * ���Z3���擾���܂��B
   * @return ���Z3
   */
  public ACRadioButtonItem getBaseMunicipalityAddItem4(){
    if(baseMunicipalityAddItem4==null){

      baseMunicipalityAddItem4 = new ACRadioButtonItem();

      baseMunicipalityAddItem4.setText("���Z3");

      baseMunicipalityAddItem4.setGroup(getBaseMunicipalityAdd());

      baseMunicipalityAddItem4.setConstraints(VRLayout.FLOW_RETURN);

      addBaseMunicipalityAddItem4();
    }
    return baseMunicipalityAddItem4;

  }

  /**
   * ���Z4���擾���܂��B
   * @return ���Z4
   */
  public ACRadioButtonItem getBaseMunicipalityAddItem5(){
    if(baseMunicipalityAddItem5==null){

      baseMunicipalityAddItem5 = new ACRadioButtonItem();

      baseMunicipalityAddItem5.setText("���Z4");

      baseMunicipalityAddItem5.setGroup(getBaseMunicipalityAdd());

      baseMunicipalityAddItem5.setConstraints(VRLayout.FLOW);

      addBaseMunicipalityAddItem5();
    }
    return baseMunicipalityAddItem5;

  }

  /**
   * ���Z5���擾���܂��B
   * @return ���Z5
   */
  public ACRadioButtonItem getBaseMunicipalityAddItem6(){
    if(baseMunicipalityAddItem6==null){

      baseMunicipalityAddItem6 = new ACRadioButtonItem();

      baseMunicipalityAddItem6.setText("���Z5");

      baseMunicipalityAddItem6.setGroup(getBaseMunicipalityAdd());

      baseMunicipalityAddItem6.setConstraints(VRLayout.FLOW);

      addBaseMunicipalityAddItem6();
    }
    return baseMunicipalityAddItem6;

  }

  /**
   * ���Z6���擾���܂��B
   * @return ���Z6
   */
  public ACRadioButtonItem getBaseMunicipalityAddItem7(){
    if(baseMunicipalityAddItem7==null){

      baseMunicipalityAddItem7 = new ACRadioButtonItem();

      baseMunicipalityAddItem7.setText("���Z6");

      baseMunicipalityAddItem7.setGroup(getBaseMunicipalityAdd());

      baseMunicipalityAddItem7.setConstraints(VRLayout.FLOW);

      addBaseMunicipalityAddItem7();
    }
    return baseMunicipalityAddItem7;

  }

  /**
   * ��ԖK���� II �s�����Ǝ����Z���擾���܂��B
   * @return ��ԖK���� II �s�����Ǝ����Z
   */
  public ACValueArrayRadioButtonGroup getServiceMunicipalityAdd(){
    if(serviceMunicipalityAdd==null){

      serviceMunicipalityAdd = new ACValueArrayRadioButtonGroup();

      getServiceMunicipalityAddContainer().setText("��ԖK���� II �s�����Ǝ����Z");

      serviceMunicipalityAdd.setBindPath("1710106");

      serviceMunicipalityAdd.setNoSelectIndex(0);

      serviceMunicipalityAdd.setUseClearButton(false);

      serviceMunicipalityAdd.setModel(getServiceMunicipalityAddModel());

      serviceMunicipalityAdd.setValues(new int[]{1,2,3,4,5,6,7});

      addServiceMunicipalityAdd();
    }
    return serviceMunicipalityAdd;

  }

  /**
   * ��ԖK���� II �s�����Ǝ����Z�R���e�i���擾���܂��B
   * @return ��ԖK���� II �s�����Ǝ����Z�R���e�i
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
   * ��ԖK���� II �s�����Ǝ����Z���f�����擾���܂��B
   * @return ��ԖK���� II �s�����Ǝ����Z���f��
   */
  protected ACListModelAdapter getServiceMunicipalityAddModel(){
    if(serviceMunicipalityAddModel==null){
      serviceMunicipalityAddModel = new ACListModelAdapter();
      addServiceMunicipalityAddModel();
    }
    return serviceMunicipalityAddModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getServiceMunicipalityAddItem1(){
    if(serviceMunicipalityAddItem1==null){

      serviceMunicipalityAddItem1 = new ACRadioButtonItem();

      serviceMunicipalityAddItem1.setText("�Ȃ�");

      serviceMunicipalityAddItem1.setGroup(getServiceMunicipalityAdd());

      serviceMunicipalityAddItem1.setConstraints(VRLayout.FLOW);

      addServiceMunicipalityAddItem1();
    }
    return serviceMunicipalityAddItem1;

  }

  /**
   * ���Z1���擾���܂��B
   * @return ���Z1
   */
  public ACRadioButtonItem getServiceMunicipalityAddItem2(){
    if(serviceMunicipalityAddItem2==null){

      serviceMunicipalityAddItem2 = new ACRadioButtonItem();

      serviceMunicipalityAddItem2.setText("���Z1");

      serviceMunicipalityAddItem2.setGroup(getServiceMunicipalityAdd());

      serviceMunicipalityAddItem2.setConstraints(VRLayout.FLOW);

      addServiceMunicipalityAddItem2();
    }
    return serviceMunicipalityAddItem2;

  }

  /**
   * ���Z2���擾���܂��B
   * @return ���Z2
   */
  public ACRadioButtonItem getServiceMunicipalityAddItem3(){
    if(serviceMunicipalityAddItem3==null){

      serviceMunicipalityAddItem3 = new ACRadioButtonItem();

      serviceMunicipalityAddItem3.setText("���Z2");

      serviceMunicipalityAddItem3.setGroup(getServiceMunicipalityAdd());

      serviceMunicipalityAddItem3.setConstraints(VRLayout.FLOW);

      addServiceMunicipalityAddItem3();
    }
    return serviceMunicipalityAddItem3;

  }

  /**
   * ���Z3���擾���܂��B
   * @return ���Z3
   */
  public ACRadioButtonItem getServiceMunicipalityAddItem4(){
    if(serviceMunicipalityAddItem4==null){

      serviceMunicipalityAddItem4 = new ACRadioButtonItem();

      serviceMunicipalityAddItem4.setText("���Z3");

      serviceMunicipalityAddItem4.setGroup(getServiceMunicipalityAdd());

      serviceMunicipalityAddItem4.setConstraints(VRLayout.FLOW_RETURN);

      addServiceMunicipalityAddItem4();
    }
    return serviceMunicipalityAddItem4;

  }

  /**
   * ���Z4���擾���܂��B
   * @return ���Z4
   */
  public ACRadioButtonItem getServiceMunicipalityAddItem5(){
    if(serviceMunicipalityAddItem5==null){

      serviceMunicipalityAddItem5 = new ACRadioButtonItem();

      serviceMunicipalityAddItem5.setText("���Z4");

      serviceMunicipalityAddItem5.setGroup(getServiceMunicipalityAdd());

      serviceMunicipalityAddItem5.setConstraints(VRLayout.FLOW);

      addServiceMunicipalityAddItem5();
    }
    return serviceMunicipalityAddItem5;

  }

  /**
   * ���Z5���擾���܂��B
   * @return ���Z5
   */
  public ACRadioButtonItem getServiceMunicipalityAddItem6(){
    if(serviceMunicipalityAddItem6==null){

      serviceMunicipalityAddItem6 = new ACRadioButtonItem();

      serviceMunicipalityAddItem6.setText("���Z5");

      serviceMunicipalityAddItem6.setGroup(getServiceMunicipalityAdd());

      serviceMunicipalityAddItem6.setConstraints(VRLayout.FLOW);

      addServiceMunicipalityAddItem6();
    }
    return serviceMunicipalityAddItem6;

  }

  /**
   * ���Z6���擾���܂��B
   * @return ���Z6
   */
  public ACRadioButtonItem getServiceMunicipalityAddItem7(){
    if(serviceMunicipalityAddItem7==null){

      serviceMunicipalityAddItem7 = new ACRadioButtonItem();

      serviceMunicipalityAddItem7.setText("���Z6");

      serviceMunicipalityAddItem7.setGroup(getServiceMunicipalityAdd());

      serviceMunicipalityAddItem7.setConstraints(VRLayout.FLOW);

      addServiceMunicipalityAddItem7();
    }
    return serviceMunicipalityAddItem7;

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
  public QO004_17111_201504Design() {

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

    mainGroup.add(getProviderMainPanel(), VRLayout.NORTH);

  }

  /**
   * ���Ə����C���p�l���ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderMainPanel(){

    providerMainPanel.add(getFacilitiesDivisionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    providerMainPanel.add(getHours24MessageAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    providerMainPanel.add(getServiceAddProvisionStructuralRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    providerMainPanel.add(getStaffUpgradeRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    providerMainPanel.add(getBaseMunicipalityAddContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    providerMainPanel.add(getServiceMunicipalityAddContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    providerMainPanel.add(getReduceRateContainer(), VRLayout.FLOW_INSETLINE);

    providerMainPanel.add(getShahukuReduce(), VRLayout.FLOW_RETURN);

    providerMainPanel.add(getOldLowElementArea(), VRLayout.FLOW_RETURN);

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
   * �T�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addFacilitiesDivisionItem1(){

  }

  /**
   * �U�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addFacilitiesDivisionItem2(){

  }

  /**
   * 24���Ԓʕ�Ή����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHours24MessageAddRadioGroup(){

  }

  /**
   * 24���Ԓʕ�Ή����Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addHours24MessageAddRadioGroupModel(){

    getHours24MessageAddRadioItem1().setButtonIndex(1);

    getHours24MessageAddRadioGroupModel().add(getHours24MessageAddRadioItem1());

    getHours24MessageAddRadioItem2().setButtonIndex(2);

    getHours24MessageAddRadioGroupModel().add(getHours24MessageAddRadioItem2());

  }

  /**
   * �Ή��s�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHours24MessageAddRadioItem1(){

  }

  /**
   * �Ή��ɓ������ڂ�ǉ����܂��B
   */
  protected void addHours24MessageAddRadioItem2(){

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

    getServiceAddProvisionStructuralRadioItem2().setButtonIndex(4);

    getServiceAddProvisionStructuralRadioGroupModel().add(getServiceAddProvisionStructuralRadioItem2());

    getServiceAddProvisionStructuralRadioItem3().setButtonIndex(2);

    getServiceAddProvisionStructuralRadioGroupModel().add(getServiceAddProvisionStructuralRadioItem3());

    getServiceAddProvisionStructuralRadioItem4().setButtonIndex(5);

    getServiceAddProvisionStructuralRadioGroupModel().add(getServiceAddProvisionStructuralRadioItem4());

    getServiceAddProvisionStructuralRadioItem5().setButtonIndex(3);

    getServiceAddProvisionStructuralRadioGroupModel().add(getServiceAddProvisionStructuralRadioItem5());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceAddProvisionStructuralRadioItem1(){

  }

  /**
   * ���ZI�C�ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceAddProvisionStructuralRadioItem2(){

  }

  /**
   * ���ZI���ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceAddProvisionStructuralRadioItem3(){

  }

  /**
   * ���ZII�C�ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceAddProvisionStructuralRadioItem4(){

  }

  /**
   * ���ZII���ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceAddProvisionStructuralRadioItem5(){

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
   * ��{��ԖK�� I �s�����Ǝ����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addBaseMunicipalityAdd(){

  }

  /**
   * ��{��ԖK�� I �s�����Ǝ����Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addBaseMunicipalityAddModel(){

    getBaseMunicipalityAddItem1().setButtonIndex(1);

    getBaseMunicipalityAddModel().add(getBaseMunicipalityAddItem1());

    getBaseMunicipalityAddItem2().setButtonIndex(2);

    getBaseMunicipalityAddModel().add(getBaseMunicipalityAddItem2());

    getBaseMunicipalityAddItem3().setButtonIndex(3);

    getBaseMunicipalityAddModel().add(getBaseMunicipalityAddItem3());

    getBaseMunicipalityAddItem4().setButtonIndex(4);

    getBaseMunicipalityAddModel().add(getBaseMunicipalityAddItem4());

    getBaseMunicipalityAddItem5().setButtonIndex(5);

    getBaseMunicipalityAddModel().add(getBaseMunicipalityAddItem5());

    getBaseMunicipalityAddItem6().setButtonIndex(6);

    getBaseMunicipalityAddModel().add(getBaseMunicipalityAddItem6());

    getBaseMunicipalityAddItem7().setButtonIndex(7);

    getBaseMunicipalityAddModel().add(getBaseMunicipalityAddItem7());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addBaseMunicipalityAddItem1(){

  }

  /**
   * ���Z1�ɓ������ڂ�ǉ����܂��B
   */
  protected void addBaseMunicipalityAddItem2(){

  }

  /**
   * ���Z2�ɓ������ڂ�ǉ����܂��B
   */
  protected void addBaseMunicipalityAddItem3(){

  }

  /**
   * ���Z3�ɓ������ڂ�ǉ����܂��B
   */
  protected void addBaseMunicipalityAddItem4(){

  }

  /**
   * ���Z4�ɓ������ڂ�ǉ����܂��B
   */
  protected void addBaseMunicipalityAddItem5(){

  }

  /**
   * ���Z5�ɓ������ڂ�ǉ����܂��B
   */
  protected void addBaseMunicipalityAddItem6(){

  }

  /**
   * ���Z6�ɓ������ڂ�ǉ����܂��B
   */
  protected void addBaseMunicipalityAddItem7(){

  }

  /**
   * ��ԖK���� II �s�����Ǝ����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceMunicipalityAdd(){

  }

  /**
   * ��ԖK���� II �s�����Ǝ����Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceMunicipalityAddModel(){

    getServiceMunicipalityAddItem1().setButtonIndex(1);

    getServiceMunicipalityAddModel().add(getServiceMunicipalityAddItem1());

    getServiceMunicipalityAddItem2().setButtonIndex(2);

    getServiceMunicipalityAddModel().add(getServiceMunicipalityAddItem2());

    getServiceMunicipalityAddItem3().setButtonIndex(3);

    getServiceMunicipalityAddModel().add(getServiceMunicipalityAddItem3());

    getServiceMunicipalityAddItem4().setButtonIndex(4);

    getServiceMunicipalityAddModel().add(getServiceMunicipalityAddItem4());

    getServiceMunicipalityAddItem5().setButtonIndex(5);

    getServiceMunicipalityAddModel().add(getServiceMunicipalityAddItem5());

    getServiceMunicipalityAddItem6().setButtonIndex(6);

    getServiceMunicipalityAddModel().add(getServiceMunicipalityAddItem6());

    getServiceMunicipalityAddItem7().setButtonIndex(7);

    getServiceMunicipalityAddModel().add(getServiceMunicipalityAddItem7());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceMunicipalityAddItem1(){

  }

  /**
   * ���Z1�ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceMunicipalityAddItem2(){

  }

  /**
   * ���Z2�ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceMunicipalityAddItem3(){

  }

  /**
   * ���Z3�ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceMunicipalityAddItem4(){

  }

  /**
   * ���Z4�ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceMunicipalityAddItem5(){

  }

  /**
   * ���Z5�ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceMunicipalityAddItem6(){

  }

  /**
   * ���Z6�ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceMunicipalityAddItem7(){

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
      ACFrame.debugStart(new ACAffairInfo(QO004_17111_201504Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QO004_17111_201504Design getThis() {
    return this;
  }
}
