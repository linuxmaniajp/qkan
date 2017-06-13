
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
 * �쐬��: 2017/02/24  ���{�R���s���[�^�[������� ���{�@�K�� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���̑��@�\ (O)
 * �v���Z�X ���Ǝғo�^ (004)
 * �v���O���� ���K�͑��@�\�^������(�Z�����p�ȊO) (QO004_17311_201504)
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
 * ���K�͑��@�\�^������(�Z�����p�ȊO)��ʍ��ڃf�U�C��(QO004_17311_201504) 
 */
public class QO004_17311_201504Design extends QO004ProviderPanel {
  //GUI�R���|�[�l���g

  private ACGroupBox mainGroup;

  private ACValueArrayRadioButtonGroup facilityDivisionRadioGroup;

  private ACLabelContainer facilityDivisionRadioGroupContainer;

  private ACListModelAdapter facilityDivisionRadioGroupModel;

  private ACRadioButtonItem facilityDivisionRadioItem1;

  private ACRadioButtonItem facilityDivisionRadioItem2;

  private ACValueArrayRadioButtonGroup staffLack;

  private ACLabelContainer staffLackContainer;

  private ACListModelAdapter staffLackModel;

  private ACRadioButtonItem staffLackItem1;

  private ACRadioButtonItem staffLackItem2;

  private ACRadioButtonItem staffLackItem3;

  private ACValueArrayRadioButtonGroup nurseStaffDispositionAddRadioGroup;

  private ACLabelContainer nurseStaffDispositionAddRadioGroupContainer;

  private ACListModelAdapter nurseStaffDispositionAddRadioGroupModel;

  private ACRadioButtonItem nurseStaffDispositionAddRadioItem1;

  private ACRadioButtonItem nurseStaffDispositionAddRadioItem2;

  private ACRadioButtonItem nurseStaffDispositionAddRadioItem3;

  private ACRadioButtonItem nurseStaffDispositionAddRadioItem4;

  private ACValueArrayRadioButtonGroup terminalCareInformationRadioGroup;

  private ACLabelContainer terminalCareInformationRadioGroupContainer;

  private ACListModelAdapter terminalCareInformationRadioGroupModel;

  private ACRadioButtonItem terminalCareInformationRadioItem1;

  private ACRadioButtonItem terminalCareInformationRadioItem2;

  private ACValueArrayRadioButtonGroup visitStrengthenAddRadioGroup;

  private ACLabelContainer visitStrengthenAddRadioGroupContainer;

  private ACListModelAdapter visitStrengthenAddRadioGroupModel;

  private ACRadioButtonItem visitStrengthenAddRadioItem1;

  private ACRadioButtonItem visitStrengthenAddRadioItem2;

  private ACValueArrayRadioButtonGroup comprehensiveManagementSystemRadioGroup;

  private ACLabelContainer comprehensiveManagementSystemRadioGroupContainer;

  private ACListModelAdapter comprehensiveManagementSystemRadioGroupModel;

  private ACRadioButtonItem comprehensiveManagementSystemRadioItem1;

  private ACRadioButtonItem comprehensiveManagementSystemRadioItem2;

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

  private ACRadioButtonItem staffUpgradeRadioItem6;

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

  private ACRadioButtonItem baseMunicipalityAddItem8;

  private ACRadioButtonItem baseMunicipalityAddItem9;

  private ACRadioButtonItem baseMunicipalityAddItem10;

  private ACRadioButtonItem baseMunicipalityAddItem11;

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

      mainGroup.setText("���K�͑��@�\�^������i�Z�����p�ȊO�j");

      mainGroup.setAutoWrap(false);

      mainGroup.setFollowChildEnabled(true);

      mainGroup.setHgrid(200);

      addMainGroup();
    }
    return mainGroup;

  }

  /**
   * �{�ݓ��̋敪���擾���܂��B
   * @return �{�ݓ��̋敪
   */
  public ACValueArrayRadioButtonGroup getFacilityDivisionRadioGroup(){
    if(facilityDivisionRadioGroup==null){

      facilityDivisionRadioGroup = new ACValueArrayRadioButtonGroup();

      getFacilityDivisionRadioGroupContainer().setText("�{�ݓ��̋敪");

      facilityDivisionRadioGroup.setBindPath("1730105");

      facilityDivisionRadioGroup.setUseClearButton(false);

      facilityDivisionRadioGroup.setModel(getFacilityDivisionRadioGroupModel());

      facilityDivisionRadioGroup.setValues(new int[]{1,2});

      addFacilityDivisionRadioGroup();
    }
    return facilityDivisionRadioGroup;

  }

  /**
   * �{�ݓ��̋敪�R���e�i���擾���܂��B
   * @return �{�ݓ��̋敪�R���e�i
   */
  protected ACLabelContainer getFacilityDivisionRadioGroupContainer(){
    if(facilityDivisionRadioGroupContainer==null){
      facilityDivisionRadioGroupContainer = new ACLabelContainer();
      facilityDivisionRadioGroupContainer.setFollowChildEnabled(true);
      facilityDivisionRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      facilityDivisionRadioGroupContainer.add(getFacilityDivisionRadioGroup(), null);
    }
    return facilityDivisionRadioGroupContainer;
  }

  /**
   * �{�ݓ��̋敪���f�����擾���܂��B
   * @return �{�ݓ��̋敪���f��
   */
  protected ACListModelAdapter getFacilityDivisionRadioGroupModel(){
    if(facilityDivisionRadioGroupModel==null){
      facilityDivisionRadioGroupModel = new ACListModelAdapter();
      addFacilityDivisionRadioGroupModel();
    }
    return facilityDivisionRadioGroupModel;
  }

  /**
   * ���K�͑��@�\�^�����쎖�Ə����擾���܂��B
   * @return ���K�͑��@�\�^�����쎖�Ə�
   */
  public ACRadioButtonItem getFacilityDivisionRadioItem1(){
    if(facilityDivisionRadioItem1==null){

      facilityDivisionRadioItem1 = new ACRadioButtonItem();

      facilityDivisionRadioItem1.setText("���K�͑��@�\�^�����쎖�Ə�");

      facilityDivisionRadioItem1.setGroup(getFacilityDivisionRadioGroup());

      facilityDivisionRadioItem1.setConstraints(VRLayout.FLOW_RETURN);

      addFacilityDivisionRadioItem1();
    }
    return facilityDivisionRadioItem1;

  }

  /**
   * �T�e���C�g�^���K�͑��@�\�^�����쎖�Ə����擾���܂��B
   * @return �T�e���C�g�^���K�͑��@�\�^�����쎖�Ə�
   */
  public ACRadioButtonItem getFacilityDivisionRadioItem2(){
    if(facilityDivisionRadioItem2==null){

      facilityDivisionRadioItem2 = new ACRadioButtonItem();

      facilityDivisionRadioItem2.setText("�T�e���C�g�^���K�͑��@�\�^�����쎖�Ə�");

      facilityDivisionRadioItem2.setGroup(getFacilityDivisionRadioGroup());

      facilityDivisionRadioItem2.setConstraints(VRLayout.FLOW);

      addFacilityDivisionRadioItem2();
    }
    return facilityDivisionRadioItem2;

  }

  /**
   * �E���̌����ɂ�錸�Z�̏󋵂��擾���܂��B
   * @return �E���̌����ɂ�錸�Z�̏�
   */
  public ACValueArrayRadioButtonGroup getStaffLack(){
    if(staffLack==null){

      staffLack = new ACValueArrayRadioButtonGroup();

      getStaffLackContainer().setText("�E���̌����ɂ�錸�Z�̏�");

      staffLack.setBindPath("1730101");

      staffLack.setUseClearButton(false);

      staffLack.setModel(getStaffLackModel());

      staffLack.setValues(new int[]{1,2,3});

      addStaffLack();
    }
    return staffLack;

  }

  /**
   * �E���̌����ɂ�錸�Z�̏󋵃R���e�i���擾���܂��B
   * @return �E���̌����ɂ�錸�Z�̏󋵃R���e�i
   */
  protected ACLabelContainer getStaffLackContainer(){
    if(staffLackContainer==null){
      staffLackContainer = new ACLabelContainer();
      staffLackContainer.setFollowChildEnabled(true);
      staffLackContainer.setVAlignment(VRLayout.CENTER);
      staffLackContainer.add(getStaffLack(), null);
    }
    return staffLackContainer;
  }

  /**
   * �E���̌����ɂ�錸�Z�̏󋵃��f�����擾���܂��B
   * @return �E���̌����ɂ�錸�Z�̏󋵃��f��
   */
  protected ACListModelAdapter getStaffLackModel(){
    if(staffLackModel==null){
      staffLackModel = new ACListModelAdapter();
      addStaffLackModel();
    }
    return staffLackModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getStaffLackItem1(){
    if(staffLackItem1==null){

      staffLackItem1 = new ACRadioButtonItem();

      staffLackItem1.setText("�Ȃ�");

      staffLackItem1.setGroup(getStaffLack());

      staffLackItem1.setConstraints(VRLayout.FLOW);

      addStaffLackItem1();
    }
    return staffLackItem1;

  }

  /**
   * �Ō�E�����擾���܂��B
   * @return �Ō�E��
   */
  public ACRadioButtonItem getStaffLackItem2(){
    if(staffLackItem2==null){

      staffLackItem2 = new ACRadioButtonItem();

      staffLackItem2.setText("�Ō�E��");

      staffLackItem2.setGroup(getStaffLack());

      staffLackItem2.setConstraints(VRLayout.FLOW);

      addStaffLackItem2();
    }
    return staffLackItem2;

  }

  /**
   * ���E�����擾���܂��B
   * @return ���E��
   */
  public ACRadioButtonItem getStaffLackItem3(){
    if(staffLackItem3==null){

      staffLackItem3 = new ACRadioButtonItem();

      staffLackItem3.setText("���E��");

      staffLackItem3.setGroup(getStaffLack());

      staffLackItem3.setConstraints(VRLayout.FLOW);

      addStaffLackItem3();
    }
    return staffLackItem3;

  }

  /**
   * �Ō�E���z�u���Z���擾���܂��B
   * @return �Ō�E���z�u���Z
   */
  public ACValueArrayRadioButtonGroup getNurseStaffDispositionAddRadioGroup(){
    if(nurseStaffDispositionAddRadioGroup==null){

      nurseStaffDispositionAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getNurseStaffDispositionAddRadioGroupContainer().setText("�Ō�E���z�u���Z");

      nurseStaffDispositionAddRadioGroup.setBindPath("1730102");

      nurseStaffDispositionAddRadioGroup.setNoSelectIndex(0);

      nurseStaffDispositionAddRadioGroup.setUseClearButton(false);

      nurseStaffDispositionAddRadioGroup.setModel(getNurseStaffDispositionAddRadioGroupModel());

      nurseStaffDispositionAddRadioGroup.setValues(new int[]{1,2,3,4});

      addNurseStaffDispositionAddRadioGroup();
    }
    return nurseStaffDispositionAddRadioGroup;

  }

  /**
   * �Ō�E���z�u���Z�R���e�i���擾���܂��B
   * @return �Ō�E���z�u���Z�R���e�i
   */
  protected ACLabelContainer getNurseStaffDispositionAddRadioGroupContainer(){
    if(nurseStaffDispositionAddRadioGroupContainer==null){
      nurseStaffDispositionAddRadioGroupContainer = new ACLabelContainer();
      nurseStaffDispositionAddRadioGroupContainer.setFollowChildEnabled(true);
      nurseStaffDispositionAddRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      nurseStaffDispositionAddRadioGroupContainer.add(getNurseStaffDispositionAddRadioGroup(), null);
    }
    return nurseStaffDispositionAddRadioGroupContainer;
  }

  /**
   * �Ō�E���z�u���Z���f�����擾���܂��B
   * @return �Ō�E���z�u���Z���f��
   */
  protected ACListModelAdapter getNurseStaffDispositionAddRadioGroupModel(){
    if(nurseStaffDispositionAddRadioGroupModel==null){
      nurseStaffDispositionAddRadioGroupModel = new ACListModelAdapter();
      addNurseStaffDispositionAddRadioGroupModel();
    }
    return nurseStaffDispositionAddRadioGroupModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getNurseStaffDispositionAddRadioItem1(){
    if(nurseStaffDispositionAddRadioItem1==null){

      nurseStaffDispositionAddRadioItem1 = new ACRadioButtonItem();

      nurseStaffDispositionAddRadioItem1.setText("�Ȃ�");

      nurseStaffDispositionAddRadioItem1.setGroup(getNurseStaffDispositionAddRadioGroup());

      nurseStaffDispositionAddRadioItem1.setConstraints(VRLayout.FLOW);

      addNurseStaffDispositionAddRadioItem1();
    }
    return nurseStaffDispositionAddRadioItem1;

  }

  /**
   * ���ZI���擾���܂��B
   * @return ���ZI
   */
  public ACRadioButtonItem getNurseStaffDispositionAddRadioItem2(){
    if(nurseStaffDispositionAddRadioItem2==null){

      nurseStaffDispositionAddRadioItem2 = new ACRadioButtonItem();

      nurseStaffDispositionAddRadioItem2.setText("���ZI");

      nurseStaffDispositionAddRadioItem2.setGroup(getNurseStaffDispositionAddRadioGroup());

      nurseStaffDispositionAddRadioItem2.setConstraints(VRLayout.FLOW);

      addNurseStaffDispositionAddRadioItem2();
    }
    return nurseStaffDispositionAddRadioItem2;

  }

  /**
   * ���ZII���擾���܂��B
   * @return ���ZII
   */
  public ACRadioButtonItem getNurseStaffDispositionAddRadioItem3(){
    if(nurseStaffDispositionAddRadioItem3==null){

      nurseStaffDispositionAddRadioItem3 = new ACRadioButtonItem();

      nurseStaffDispositionAddRadioItem3.setText("���ZII");

      nurseStaffDispositionAddRadioItem3.setGroup(getNurseStaffDispositionAddRadioGroup());

      nurseStaffDispositionAddRadioItem3.setConstraints(VRLayout.FLOW);

      addNurseStaffDispositionAddRadioItem3();
    }
    return nurseStaffDispositionAddRadioItem3;

  }

  /**
   * ���ZIII���擾���܂��B
   * @return ���ZIII
   */
  public ACRadioButtonItem getNurseStaffDispositionAddRadioItem4(){
    if(nurseStaffDispositionAddRadioItem4==null){

      nurseStaffDispositionAddRadioItem4 = new ACRadioButtonItem();

      nurseStaffDispositionAddRadioItem4.setText("���ZIII");

      nurseStaffDispositionAddRadioItem4.setGroup(getNurseStaffDispositionAddRadioGroup());

      nurseStaffDispositionAddRadioItem4.setConstraints(VRLayout.FLOW);

      addNurseStaffDispositionAddRadioItem4();
    }
    return nurseStaffDispositionAddRadioItem4;

  }

  /**
   * �Ŏ��A�g�̐����Z���擾���܂��B
   * @return �Ŏ��A�g�̐����Z
   */
  public ACValueArrayRadioButtonGroup getTerminalCareInformationRadioGroup(){
    if(terminalCareInformationRadioGroup==null){

      terminalCareInformationRadioGroup = new ACValueArrayRadioButtonGroup();

      getTerminalCareInformationRadioGroupContainer().setText("�Ŏ��A�g�̐����Z");

      terminalCareInformationRadioGroup.setBindPath("1730106");

      terminalCareInformationRadioGroup.setVisible(true);

      terminalCareInformationRadioGroup.setEnabled(true);

      terminalCareInformationRadioGroup.setNoSelectIndex(0);

      terminalCareInformationRadioGroup.setUseClearButton(false);

      terminalCareInformationRadioGroup.setModel(getTerminalCareInformationRadioGroupModel());

      terminalCareInformationRadioGroup.setValues(new int[]{1,2});

      addTerminalCareInformationRadioGroup();
    }
    return terminalCareInformationRadioGroup;

  }

  /**
   * �Ŏ��A�g�̐����Z�R���e�i���擾���܂��B
   * @return �Ŏ��A�g�̐����Z�R���e�i
   */
  protected ACLabelContainer getTerminalCareInformationRadioGroupContainer(){
    if(terminalCareInformationRadioGroupContainer==null){
      terminalCareInformationRadioGroupContainer = new ACLabelContainer();
      terminalCareInformationRadioGroupContainer.setFollowChildEnabled(true);
      terminalCareInformationRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      terminalCareInformationRadioGroupContainer.add(getTerminalCareInformationRadioGroup(), null);
    }
    return terminalCareInformationRadioGroupContainer;
  }

  /**
   * �Ŏ��A�g�̐����Z���f�����擾���܂��B
   * @return �Ŏ��A�g�̐����Z���f��
   */
  protected ACListModelAdapter getTerminalCareInformationRadioGroupModel(){
    if(terminalCareInformationRadioGroupModel==null){
      terminalCareInformationRadioGroupModel = new ACListModelAdapter();
      addTerminalCareInformationRadioGroupModel();
    }
    return terminalCareInformationRadioGroupModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getTerminalCareInformationRadioItem1(){
    if(terminalCareInformationRadioItem1==null){

      terminalCareInformationRadioItem1 = new ACRadioButtonItem();

      terminalCareInformationRadioItem1.setText("�Ȃ�");

      terminalCareInformationRadioItem1.setGroup(getTerminalCareInformationRadioGroup());

      terminalCareInformationRadioItem1.setConstraints(VRLayout.FLOW);

      addTerminalCareInformationRadioItem1();
    }
    return terminalCareInformationRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getTerminalCareInformationRadioItem2(){
    if(terminalCareInformationRadioItem2==null){

      terminalCareInformationRadioItem2 = new ACRadioButtonItem();

      terminalCareInformationRadioItem2.setText("����");

      terminalCareInformationRadioItem2.setGroup(getTerminalCareInformationRadioGroup());

      terminalCareInformationRadioItem2.setConstraints(VRLayout.FLOW);

      addTerminalCareInformationRadioItem2();
    }
    return terminalCareInformationRadioItem2;

  }

  /**
   * �K��̐��������Z���擾���܂��B
   * @return �K��̐��������Z
   */
  public ACValueArrayRadioButtonGroup getVisitStrengthenAddRadioGroup(){
    if(visitStrengthenAddRadioGroup==null){

      visitStrengthenAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getVisitStrengthenAddRadioGroupContainer().setText("�K��̐��������Z");

      visitStrengthenAddRadioGroup.setBindPath("1730107");

      visitStrengthenAddRadioGroup.setVisible(true);

      visitStrengthenAddRadioGroup.setEnabled(true);

      visitStrengthenAddRadioGroup.setNoSelectIndex(0);

      visitStrengthenAddRadioGroup.setUseClearButton(false);

      visitStrengthenAddRadioGroup.setModel(getVisitStrengthenAddRadioGroupModel());

      visitStrengthenAddRadioGroup.setValues(new int[]{1,2});

      addVisitStrengthenAddRadioGroup();
    }
    return visitStrengthenAddRadioGroup;

  }

  /**
   * �K��̐��������Z�R���e�i���擾���܂��B
   * @return �K��̐��������Z�R���e�i
   */
  protected ACLabelContainer getVisitStrengthenAddRadioGroupContainer(){
    if(visitStrengthenAddRadioGroupContainer==null){
      visitStrengthenAddRadioGroupContainer = new ACLabelContainer();
      visitStrengthenAddRadioGroupContainer.setFollowChildEnabled(true);
      visitStrengthenAddRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      visitStrengthenAddRadioGroupContainer.add(getVisitStrengthenAddRadioGroup(), null);
    }
    return visitStrengthenAddRadioGroupContainer;
  }

  /**
   * �K��̐��������Z���f�����擾���܂��B
   * @return �K��̐��������Z���f��
   */
  protected ACListModelAdapter getVisitStrengthenAddRadioGroupModel(){
    if(visitStrengthenAddRadioGroupModel==null){
      visitStrengthenAddRadioGroupModel = new ACListModelAdapter();
      addVisitStrengthenAddRadioGroupModel();
    }
    return visitStrengthenAddRadioGroupModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getVisitStrengthenAddRadioItem1(){
    if(visitStrengthenAddRadioItem1==null){

      visitStrengthenAddRadioItem1 = new ACRadioButtonItem();

      visitStrengthenAddRadioItem1.setText("�Ȃ�");

      visitStrengthenAddRadioItem1.setGroup(getVisitStrengthenAddRadioGroup());

      visitStrengthenAddRadioItem1.setConstraints(VRLayout.FLOW);

      addVisitStrengthenAddRadioItem1();
    }
    return visitStrengthenAddRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getVisitStrengthenAddRadioItem2(){
    if(visitStrengthenAddRadioItem2==null){

      visitStrengthenAddRadioItem2 = new ACRadioButtonItem();

      visitStrengthenAddRadioItem2.setText("����");

      visitStrengthenAddRadioItem2.setGroup(getVisitStrengthenAddRadioGroup());

      visitStrengthenAddRadioItem2.setConstraints(VRLayout.FLOW);

      addVisitStrengthenAddRadioItem2();
    }
    return visitStrengthenAddRadioItem2;

  }

  /**
   * �����}�l�W�����g�̐��������Z���擾���܂��B
   * @return �����}�l�W�����g�̐��������Z
   */
  public ACValueArrayRadioButtonGroup getComprehensiveManagementSystemRadioGroup(){
    if(comprehensiveManagementSystemRadioGroup==null){

      comprehensiveManagementSystemRadioGroup = new ACValueArrayRadioButtonGroup();

      getComprehensiveManagementSystemRadioGroupContainer().setText("�����}�l�W�����g�̐��������Z");

      comprehensiveManagementSystemRadioGroup.setBindPath("1730108");

      comprehensiveManagementSystemRadioGroup.setVisible(true);

      comprehensiveManagementSystemRadioGroup.setEnabled(true);

      comprehensiveManagementSystemRadioGroup.setNoSelectIndex(0);

      comprehensiveManagementSystemRadioGroup.setUseClearButton(false);

      comprehensiveManagementSystemRadioGroup.setModel(getComprehensiveManagementSystemRadioGroupModel());

      comprehensiveManagementSystemRadioGroup.setValues(new int[]{1,2});

      addComprehensiveManagementSystemRadioGroup();
    }
    return comprehensiveManagementSystemRadioGroup;

  }

  /**
   * �����}�l�W�����g�̐��������Z�R���e�i���擾���܂��B
   * @return �����}�l�W�����g�̐��������Z�R���e�i
   */
  protected ACLabelContainer getComprehensiveManagementSystemRadioGroupContainer(){
    if(comprehensiveManagementSystemRadioGroupContainer==null){
      comprehensiveManagementSystemRadioGroupContainer = new ACLabelContainer();
      comprehensiveManagementSystemRadioGroupContainer.setFollowChildEnabled(true);
      comprehensiveManagementSystemRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      comprehensiveManagementSystemRadioGroupContainer.add(getComprehensiveManagementSystemRadioGroup(), null);
    }
    return comprehensiveManagementSystemRadioGroupContainer;
  }

  /**
   * �����}�l�W�����g�̐��������Z���f�����擾���܂��B
   * @return �����}�l�W�����g�̐��������Z���f��
   */
  protected ACListModelAdapter getComprehensiveManagementSystemRadioGroupModel(){
    if(comprehensiveManagementSystemRadioGroupModel==null){
      comprehensiveManagementSystemRadioGroupModel = new ACListModelAdapter();
      addComprehensiveManagementSystemRadioGroupModel();
    }
    return comprehensiveManagementSystemRadioGroupModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getComprehensiveManagementSystemRadioItem1(){
    if(comprehensiveManagementSystemRadioItem1==null){

      comprehensiveManagementSystemRadioItem1 = new ACRadioButtonItem();

      comprehensiveManagementSystemRadioItem1.setText("�Ȃ�");

      comprehensiveManagementSystemRadioItem1.setGroup(getComprehensiveManagementSystemRadioGroup());

      comprehensiveManagementSystemRadioItem1.setConstraints(VRLayout.FLOW);

      addComprehensiveManagementSystemRadioItem1();
    }
    return comprehensiveManagementSystemRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getComprehensiveManagementSystemRadioItem2(){
    if(comprehensiveManagementSystemRadioItem2==null){

      comprehensiveManagementSystemRadioItem2 = new ACRadioButtonItem();

      comprehensiveManagementSystemRadioItem2.setText("����");

      comprehensiveManagementSystemRadioItem2.setGroup(getComprehensiveManagementSystemRadioGroup());

      comprehensiveManagementSystemRadioItem2.setConstraints(VRLayout.FLOW);

      addComprehensiveManagementSystemRadioItem2();
    }
    return comprehensiveManagementSystemRadioItem2;

  }

  /**
   * �T�[�r�X�񋟑̐��������Z���擾���܂��B
   * @return �T�[�r�X�񋟑̐��������Z
   */
  public ACValueArrayRadioButtonGroup getServiceAddProvisionStructuralRadioGroup(){
    if(serviceAddProvisionStructuralRadioGroup==null){

      serviceAddProvisionStructuralRadioGroup = new ACValueArrayRadioButtonGroup();

      getServiceAddProvisionStructuralRadioGroupContainer().setText("�T�[�r�X�񋟑̐��������Z");

      serviceAddProvisionStructuralRadioGroup.setBindPath("1730103");

      serviceAddProvisionStructuralRadioGroup.setVisible(true);

      serviceAddProvisionStructuralRadioGroup.setEnabled(true);

      serviceAddProvisionStructuralRadioGroup.setNoSelectIndex(0);

      serviceAddProvisionStructuralRadioGroup.setUseClearButton(false);

      serviceAddProvisionStructuralRadioGroup.setModel(getServiceAddProvisionStructuralRadioGroupModel());

      serviceAddProvisionStructuralRadioGroup.setValues(new int[]{1,5,2,3,4});

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

      serviceAddProvisionStructuralRadioItem3.setConstraints(VRLayout.FLOW_RETURN);

      addServiceAddProvisionStructuralRadioItem3();
    }
    return serviceAddProvisionStructuralRadioItem3;

  }

  /**
   * ���ZII���擾���܂��B
   * @return ���ZII
   */
  public ACRadioButtonItem getServiceAddProvisionStructuralRadioItem4(){
    if(serviceAddProvisionStructuralRadioItem4==null){

      serviceAddProvisionStructuralRadioItem4 = new ACRadioButtonItem();

      serviceAddProvisionStructuralRadioItem4.setText("���ZII");

      serviceAddProvisionStructuralRadioItem4.setGroup(getServiceAddProvisionStructuralRadioGroup());

      serviceAddProvisionStructuralRadioItem4.setConstraints(VRLayout.FLOW);

      addServiceAddProvisionStructuralRadioItem4();
    }
    return serviceAddProvisionStructuralRadioItem4;

  }

  /**
   * ���ZIII���擾���܂��B
   * @return ���ZIII
   */
  public ACRadioButtonItem getServiceAddProvisionStructuralRadioItem5(){
    if(serviceAddProvisionStructuralRadioItem5==null){

      serviceAddProvisionStructuralRadioItem5 = new ACRadioButtonItem();

      serviceAddProvisionStructuralRadioItem5.setText("���ZIII");

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

      getStaffUpgradeRadioGroupContainer().setText("<html>���E���������P���Z<br>�i�����Z�F�`H29.3�j</html>");

      staffUpgradeRadioGroup.setBindPath("4");

      staffUpgradeRadioGroup.setEnabled(true);

      staffUpgradeRadioGroup.setUseClearButton(false);

      staffUpgradeRadioGroup.setModel(getStaffUpgradeRadioGroupModel());

      staffUpgradeRadioGroup.setValues(new int[]{1,6,5,2,3,4});

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

      staffUpgradeRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

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

      staffUpgradeRadioItem3.setText("���ZII�i�����ZI�j");

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

      staffUpgradeRadioItem4.setText("���ZIII�i�����ZII�j");

      staffUpgradeRadioItem4.setGroup(getStaffUpgradeRadioGroup());

      staffUpgradeRadioItem4.setConstraints(VRLayout.FLOW_RETURN);

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

      staffUpgradeRadioItem5.setText("���ZIV�i�����ZIII�j");

      staffUpgradeRadioItem5.setGroup(getStaffUpgradeRadioGroup());

      staffUpgradeRadioItem5.setConstraints(VRLayout.FLOW);

      addStaffUpgradeRadioItem5();
    }
    return staffUpgradeRadioItem5;

  }

  /**
   * ���ZV���擾���܂��B
   * @return ���ZV
   */
  public ACRadioButtonItem getStaffUpgradeRadioItem6(){
    if(staffUpgradeRadioItem6==null){

      staffUpgradeRadioItem6 = new ACRadioButtonItem();

      staffUpgradeRadioItem6.setText("���ZV�i�����ZIV�j");

      staffUpgradeRadioItem6.setGroup(getStaffUpgradeRadioGroup());

      staffUpgradeRadioItem6.setConstraints(VRLayout.FLOW);

      addStaffUpgradeRadioItem6();
    }
    return staffUpgradeRadioItem6;

  }

  /**
   * ���K�͑��@�\�^�s�����Ǝ����Z���擾���܂��B
   * @return ���K�͑��@�\�^�s�����Ǝ����Z
   */
  public ACValueArrayRadioButtonGroup getBaseMunicipalityAdd(){
    if(baseMunicipalityAdd==null){

      baseMunicipalityAdd = new ACValueArrayRadioButtonGroup();

      getBaseMunicipalityAddContainer().setText("���K�͑��@�\�^�s�����Ǝ����Z");

      baseMunicipalityAdd.setBindPath("1730104");

      baseMunicipalityAdd.setNoSelectIndex(0);

      baseMunicipalityAdd.setUseClearButton(false);

      baseMunicipalityAdd.setModel(getBaseMunicipalityAddModel());

      baseMunicipalityAdd.setValues(new int[]{1,2,3,4,5,6,7,8,9,10,11});

      addBaseMunicipalityAdd();
    }
    return baseMunicipalityAdd;

  }

  /**
   * ���K�͑��@�\�^�s�����Ǝ����Z�R���e�i���擾���܂��B
   * @return ���K�͑��@�\�^�s�����Ǝ����Z�R���e�i
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
   * ���K�͑��@�\�^�s�����Ǝ����Z���f�����擾���܂��B
   * @return ���K�͑��@�\�^�s�����Ǝ����Z���f��
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
   * ���Z7���擾���܂��B
   * @return ���Z7
   */
  public ACRadioButtonItem getBaseMunicipalityAddItem8(){
    if(baseMunicipalityAddItem8==null){

      baseMunicipalityAddItem8 = new ACRadioButtonItem();

      baseMunicipalityAddItem8.setText("���Z7");

      baseMunicipalityAddItem8.setGroup(getBaseMunicipalityAdd());

      baseMunicipalityAddItem8.setConstraints(VRLayout.FLOW_RETURN);

      addBaseMunicipalityAddItem8();
    }
    return baseMunicipalityAddItem8;

  }

  /**
   * ���Z8���擾���܂��B
   * @return ���Z8
   */
  public ACRadioButtonItem getBaseMunicipalityAddItem9(){
    if(baseMunicipalityAddItem9==null){

      baseMunicipalityAddItem9 = new ACRadioButtonItem();

      baseMunicipalityAddItem9.setText("���Z8");

      baseMunicipalityAddItem9.setGroup(getBaseMunicipalityAdd());

      baseMunicipalityAddItem9.setConstraints(VRLayout.FLOW);

      addBaseMunicipalityAddItem9();
    }
    return baseMunicipalityAddItem9;

  }

  /**
   * ���Z9���擾���܂��B
   * @return ���Z9
   */
  public ACRadioButtonItem getBaseMunicipalityAddItem10(){
    if(baseMunicipalityAddItem10==null){

      baseMunicipalityAddItem10 = new ACRadioButtonItem();

      baseMunicipalityAddItem10.setText("���Z9");

      baseMunicipalityAddItem10.setGroup(getBaseMunicipalityAdd());

      baseMunicipalityAddItem10.setConstraints(VRLayout.FLOW);

      addBaseMunicipalityAddItem10();
    }
    return baseMunicipalityAddItem10;

  }

  /**
   * ���Z10���擾���܂��B
   * @return ���Z10
   */
  public ACRadioButtonItem getBaseMunicipalityAddItem11(){
    if(baseMunicipalityAddItem11==null){

      baseMunicipalityAddItem11 = new ACRadioButtonItem();

      baseMunicipalityAddItem11.setText("���Z10");

      baseMunicipalityAddItem11.setGroup(getBaseMunicipalityAdd());

      baseMunicipalityAddItem11.setConstraints(VRLayout.FLOW);

      addBaseMunicipalityAddItem11();
    }
    return baseMunicipalityAddItem11;

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
  public QO004_17311_201504Design() {

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

    mainGroup.add(getFacilityDivisionRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    mainGroup.add(getStaffLackContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    mainGroup.add(getNurseStaffDispositionAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    mainGroup.add(getTerminalCareInformationRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    mainGroup.add(getVisitStrengthenAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    mainGroup.add(getComprehensiveManagementSystemRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    mainGroup.add(getServiceAddProvisionStructuralRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    mainGroup.add(getStaffUpgradeRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    mainGroup.add(getBaseMunicipalityAddContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    mainGroup.add(getReduceRateContainer(), VRLayout.FLOW_INSETLINE);

    mainGroup.add(getShahukuReduce(), VRLayout.FLOW_RETURN);

    mainGroup.add(getOldLowElementArea(), VRLayout.FLOW_RETURN);

  }

  /**
   * �{�ݓ��̋敪�ɓ������ڂ�ǉ����܂��B
   */
  protected void addFacilityDivisionRadioGroup(){

  }

  /**
   * �{�ݓ��̋敪���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addFacilityDivisionRadioGroupModel(){

    getFacilityDivisionRadioItem1().setButtonIndex(1);

    getFacilityDivisionRadioGroupModel().add(getFacilityDivisionRadioItem1());

    getFacilityDivisionRadioItem2().setButtonIndex(2);

    getFacilityDivisionRadioGroupModel().add(getFacilityDivisionRadioItem2());

  }

  /**
   * ���K�͑��@�\�^�����쎖�Ə��ɓ������ڂ�ǉ����܂��B
   */
  protected void addFacilityDivisionRadioItem1(){

  }

  /**
   * �T�e���C�g�^���K�͑��@�\�^�����쎖�Ə��ɓ������ڂ�ǉ����܂��B
   */
  protected void addFacilityDivisionRadioItem2(){

  }

  /**
   * �E���̌����ɂ�錸�Z�̏󋵂ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffLack(){

  }

  /**
   * �E���̌����ɂ�錸�Z�̏󋵃��f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffLackModel(){

    getStaffLackItem1().setButtonIndex(1);

    getStaffLackModel().add(getStaffLackItem1());

    getStaffLackItem2().setButtonIndex(2);

    getStaffLackModel().add(getStaffLackItem2());

    getStaffLackItem3().setButtonIndex(3);

    getStaffLackModel().add(getStaffLackItem3());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffLackItem1(){

  }

  /**
   * �Ō�E���ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffLackItem2(){

  }

  /**
   * ���E���ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffLackItem3(){

  }

  /**
   * �Ō�E���z�u���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addNurseStaffDispositionAddRadioGroup(){

  }

  /**
   * �Ō�E���z�u���Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addNurseStaffDispositionAddRadioGroupModel(){

    getNurseStaffDispositionAddRadioItem1().setButtonIndex(1);

    getNurseStaffDispositionAddRadioGroupModel().add(getNurseStaffDispositionAddRadioItem1());

    getNurseStaffDispositionAddRadioItem2().setButtonIndex(2);

    getNurseStaffDispositionAddRadioGroupModel().add(getNurseStaffDispositionAddRadioItem2());

    getNurseStaffDispositionAddRadioItem3().setButtonIndex(3);

    getNurseStaffDispositionAddRadioGroupModel().add(getNurseStaffDispositionAddRadioItem3());

    getNurseStaffDispositionAddRadioItem4().setButtonIndex(4);

    getNurseStaffDispositionAddRadioGroupModel().add(getNurseStaffDispositionAddRadioItem4());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addNurseStaffDispositionAddRadioItem1(){

  }

  /**
   * ���ZI�ɓ������ڂ�ǉ����܂��B
   */
  protected void addNurseStaffDispositionAddRadioItem2(){

  }

  /**
   * ���ZII�ɓ������ڂ�ǉ����܂��B
   */
  protected void addNurseStaffDispositionAddRadioItem3(){

  }

  /**
   * ���ZIII�ɓ������ڂ�ǉ����܂��B
   */
  protected void addNurseStaffDispositionAddRadioItem4(){

  }

  /**
   * �Ŏ��A�g�̐����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTerminalCareInformationRadioGroup(){

  }

  /**
   * �Ŏ��A�g�̐����Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addTerminalCareInformationRadioGroupModel(){

    getTerminalCareInformationRadioItem1().setButtonIndex(1);

    getTerminalCareInformationRadioGroupModel().add(getTerminalCareInformationRadioItem1());

    getTerminalCareInformationRadioItem2().setButtonIndex(2);

    getTerminalCareInformationRadioGroupModel().add(getTerminalCareInformationRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addTerminalCareInformationRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addTerminalCareInformationRadioItem2(){

  }

  /**
   * �K��̐��������Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addVisitStrengthenAddRadioGroup(){

  }

  /**
   * �K��̐��������Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addVisitStrengthenAddRadioGroupModel(){

    getVisitStrengthenAddRadioItem1().setButtonIndex(1);

    getVisitStrengthenAddRadioGroupModel().add(getVisitStrengthenAddRadioItem1());

    getVisitStrengthenAddRadioItem2().setButtonIndex(2);

    getVisitStrengthenAddRadioGroupModel().add(getVisitStrengthenAddRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addVisitStrengthenAddRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addVisitStrengthenAddRadioItem2(){

  }

  /**
   * �����}�l�W�����g�̐��������Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addComprehensiveManagementSystemRadioGroup(){

  }

  /**
   * �����}�l�W�����g�̐��������Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addComprehensiveManagementSystemRadioGroupModel(){

    getComprehensiveManagementSystemRadioItem1().setButtonIndex(1);

    getComprehensiveManagementSystemRadioGroupModel().add(getComprehensiveManagementSystemRadioItem1());

    getComprehensiveManagementSystemRadioItem2().setButtonIndex(2);

    getComprehensiveManagementSystemRadioGroupModel().add(getComprehensiveManagementSystemRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addComprehensiveManagementSystemRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addComprehensiveManagementSystemRadioItem2(){

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

    getServiceAddProvisionStructuralRadioItem2().setButtonIndex(5);

    getServiceAddProvisionStructuralRadioGroupModel().add(getServiceAddProvisionStructuralRadioItem2());

    getServiceAddProvisionStructuralRadioItem3().setButtonIndex(2);

    getServiceAddProvisionStructuralRadioGroupModel().add(getServiceAddProvisionStructuralRadioItem3());

    getServiceAddProvisionStructuralRadioItem4().setButtonIndex(3);

    getServiceAddProvisionStructuralRadioGroupModel().add(getServiceAddProvisionStructuralRadioItem4());

    getServiceAddProvisionStructuralRadioItem5().setButtonIndex(4);

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
   * ���ZII�ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceAddProvisionStructuralRadioItem4(){

  }

  /**
   * ���ZIII�ɓ������ڂ�ǉ����܂��B
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

    getStaffUpgradeRadioItem2().setButtonIndex(6);

    getStaffUpgradeRadioGroupModel().add(getStaffUpgradeRadioItem2());

    getStaffUpgradeRadioItem3().setButtonIndex(5);

    getStaffUpgradeRadioGroupModel().add(getStaffUpgradeRadioItem3());

    getStaffUpgradeRadioItem4().setButtonIndex(2);

    getStaffUpgradeRadioGroupModel().add(getStaffUpgradeRadioItem4());

    getStaffUpgradeRadioItem5().setButtonIndex(3);

    getStaffUpgradeRadioGroupModel().add(getStaffUpgradeRadioItem5());

    getStaffUpgradeRadioItem6().setButtonIndex(4);

    getStaffUpgradeRadioGroupModel().add(getStaffUpgradeRadioItem6());

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
   * ���ZV�ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffUpgradeRadioItem6(){

  }

  /**
   * ���K�͑��@�\�^�s�����Ǝ����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addBaseMunicipalityAdd(){

  }

  /**
   * ���K�͑��@�\�^�s�����Ǝ����Z���f���ɓ������ڂ�ǉ����܂��B
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

    getBaseMunicipalityAddItem8().setButtonIndex(8);

    getBaseMunicipalityAddModel().add(getBaseMunicipalityAddItem8());

    getBaseMunicipalityAddItem9().setButtonIndex(9);

    getBaseMunicipalityAddModel().add(getBaseMunicipalityAddItem9());

    getBaseMunicipalityAddItem10().setButtonIndex(10);

    getBaseMunicipalityAddModel().add(getBaseMunicipalityAddItem10());

    getBaseMunicipalityAddItem11().setButtonIndex(11);

    getBaseMunicipalityAddModel().add(getBaseMunicipalityAddItem11());

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
   * ���Z7�ɓ������ڂ�ǉ����܂��B
   */
  protected void addBaseMunicipalityAddItem8(){

  }

  /**
   * ���Z8�ɓ������ڂ�ǉ����܂��B
   */
  protected void addBaseMunicipalityAddItem9(){

  }

  /**
   * ���Z9�ɓ������ڂ�ǉ����܂��B
   */
  protected void addBaseMunicipalityAddItem10(){

  }

  /**
   * ���Z10�ɓ������ڂ�ǉ����܂��B
   */
  protected void addBaseMunicipalityAddItem11(){

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
      ACFrame.debugStart(new ACAffairInfo(QO004_17311_201504Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QO004_17311_201504Design getThis() {
    return this;
  }
}
