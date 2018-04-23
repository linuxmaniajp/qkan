
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
 * �쐬��: 2018/02/19  ���{�R���s���[�^�[������� �����@���̂� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���̑��@�\ (O)
 * �v���Z�X ���Ǝғo�^ (004)
 * �v���O���� �����^�T�[�r�X�i�Ō쏬�K�͑��@�\�^������E�Z�����p�ȊO�j (QO004_17711_201804)
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
 * �����^�T�[�r�X�i�Ō쏬�K�͑��@�\�^������E�Z�����p�ȊO�j��ʍ��ڃf�U�C��(QO004_17711_201804) 
 */
public class QO004_17711_201804Design extends QO004ProviderPanel {
  //GUI�R���|�[�l���g

  private ACGroupBox mainGroup;

  private ACValueArrayRadioButtonGroup facilityDivisionRadioGroup;

  private ACLabelContainer facilityDivisionRadioGroupContainer;

  private ACListModelAdapter facilityDivisionRadioGroupModel;

  private ACRadioButtonItem facilityDivisionRadioItem1;

  private ACRadioButtonItem facilityDivisionRadioItem2;

  private ACValueArrayRadioButtonGroup staffLackRadioGroup;

  private ACLabelContainer staffLackRadioGroupContainer;

  private ACListModelAdapter staffLackRadioGroupModel;

  private ACRadioButtonItem staffLackRadioItem1;

  private ACRadioButtonItem staffLackRadioItem2;

  private ACRadioButtonItem staffLackRadioItem3;

  private ACValueArrayRadioButtonGroup nursingSystemSubtractionRadioGroup;

  private ACLabelContainer nursingSystemSubtractionRadioGroupContainer;

  private ACListModelAdapter nursingSystemSubtractionRadioGroupModel;

  private ACRadioButtonItem nursingSystemSubtractionRadioItem1;

  private ACRadioButtonItem nursingSystemSubtractionRadioItem2;

  private ACValueArrayRadioButtonGroup satelliteSystemRadioGroup;

  private ACLabelContainer satelliteSystemRadioGroupContainer;

  private ACListModelAdapter satelliteSystemRadioGroupModel;

  private ACRadioButtonItem satelliteSystemRadioItem1;

  private ACRadioButtonItem satelliteSystemRadioItem2;

  private ACValueArrayRadioButtonGroup youngDementiaPatinetAddRadioGroup;

  private ACLabelContainer youngDementiaPatinetAddRadioGroupContainer;

  private ACListModelAdapter youngDementiaPatinetAddRadioGroupModel;

  private ACRadioButtonItem youngDementiaPatinetAddRadioItem1;

  private ACRadioButtonItem youngDementiaPatinetAddRadioItem2;

  private ACValueArrayRadioButtonGroup emergencyRadioGroup;

  private ACLabelContainer emergencyRadioGroupContainer;

  private ACListModelAdapter emergencyRadioGroupModel;

  private ACRadioButtonItem emergencyRadioItem1;

  private ACRadioButtonItem emergencyRadioItem2;

  private ACValueArrayRadioButtonGroup specialManagementSystemRadioGroup;

  private ACLabelContainer specialManagementSystemRadioGroupContainer;

  private ACListModelAdapter specialManagementSystemRadioGroupModel;

  private ACRadioButtonItem specialManagementSystemRadioItem1;

  private ACRadioButtonItem specialManagementSystemRadioItem2;

  private ACValueArrayRadioButtonGroup terminalCareRadioGroup;

  private ACLabelContainer terminalCareRadioGroupContainer;

  private ACListModelAdapter terminalCareRadioGroupModel;

  private ACRadioButtonItem terminalCareRadioItem1;

  private ACRadioButtonItem terminalCareRadioItem2;

  private ACValueArrayRadioButtonGroup nursingStrengthenAddRadioGroup;

  private ACLabelContainer nursingStrengthenAddRadioGroupContainer;

  private ACListModelAdapter nursingStrengthenAddRadioGroupModel;

  private ACRadioButtonItem nursingStrengthenAddRadioItem1;

  private ACRadioButtonItem nursingStrengthenAddRadioItem2;

  private ACRadioButtonItem nursingStrengthenAddRadioItem3;

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

      mainGroup.setText("�����^�T�[�r�X�i�Ō쏬�K�͑��@�\�^������E�Z�����p�ȊO�j");

      mainGroup.setFollowChildEnabled(true);

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

      facilityDivisionRadioGroup.setBindPath("1770109");

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
   * �Ō쏬�K�͑��@�\�^�����쎖�Ə����擾���܂��B
   * @return �Ō쏬�K�͑��@�\�^�����쎖�Ə�
   */
  public ACRadioButtonItem getFacilityDivisionRadioItem1(){
    if(facilityDivisionRadioItem1==null){

      facilityDivisionRadioItem1 = new ACRadioButtonItem();

      facilityDivisionRadioItem1.setText("�Ō쏬�K�͑��@�\�^�����쎖�Ə�");

      facilityDivisionRadioItem1.setGroup(getFacilityDivisionRadioGroup());

      facilityDivisionRadioItem1.setConstraints(VRLayout.FLOW_RETURN);

      addFacilityDivisionRadioItem1();
    }
    return facilityDivisionRadioItem1;

  }

  /**
   * �T�e���C�g�^�Ō쏬�K�͑��@�\�^�����쎖�Ə����擾���܂��B
   * @return �T�e���C�g�^�Ō쏬�K�͑��@�\�^�����쎖�Ə�
   */
  public ACRadioButtonItem getFacilityDivisionRadioItem2(){
    if(facilityDivisionRadioItem2==null){

      facilityDivisionRadioItem2 = new ACRadioButtonItem();

      facilityDivisionRadioItem2.setText("�T�e���C�g�^�Ō쏬�K�͑��@�\�^�����쎖�Ə�");

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
  public ACValueArrayRadioButtonGroup getStaffLackRadioGroup(){
    if(staffLackRadioGroup==null){

      staffLackRadioGroup = new ACValueArrayRadioButtonGroup();

      getStaffLackRadioGroupContainer().setText("�E���̌����ɂ�錸�Z�̏�");

      staffLackRadioGroup.setBindPath("1770101");

      staffLackRadioGroup.setVisible(true);

      staffLackRadioGroup.setEnabled(true);

      staffLackRadioGroup.setNoSelectIndex(0);

      staffLackRadioGroup.setUseClearButton(false);

      staffLackRadioGroup.setModel(getStaffLackRadioGroupModel());

      staffLackRadioGroup.setValues(new int[]{1,2,3});

      addStaffLackRadioGroup();
    }
    return staffLackRadioGroup;

  }

  /**
   * �E���̌����ɂ�錸�Z�̏󋵃R���e�i���擾���܂��B
   * @return �E���̌����ɂ�錸�Z�̏󋵃R���e�i
   */
  protected ACLabelContainer getStaffLackRadioGroupContainer(){
    if(staffLackRadioGroupContainer==null){
      staffLackRadioGroupContainer = new ACLabelContainer();
      staffLackRadioGroupContainer.setFollowChildEnabled(true);
      staffLackRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      staffLackRadioGroupContainer.add(getStaffLackRadioGroup(), null);
    }
    return staffLackRadioGroupContainer;
  }

  /**
   * �E���̌����ɂ�錸�Z�̏󋵃��f�����擾���܂��B
   * @return �E���̌����ɂ�錸�Z�̏󋵃��f��
   */
  protected ACListModelAdapter getStaffLackRadioGroupModel(){
    if(staffLackRadioGroupModel==null){
      staffLackRadioGroupModel = new ACListModelAdapter();
      addStaffLackRadioGroupModel();
    }
    return staffLackRadioGroupModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getStaffLackRadioItem1(){
    if(staffLackRadioItem1==null){

      staffLackRadioItem1 = new ACRadioButtonItem();

      staffLackRadioItem1.setText("�Ȃ�");

      staffLackRadioItem1.setGroup(getStaffLackRadioGroup());

      staffLackRadioItem1.setConstraints(VRLayout.FLOW);

      addStaffLackRadioItem1();
    }
    return staffLackRadioItem1;

  }

  /**
   * �Ō�E�����擾���܂��B
   * @return �Ō�E��
   */
  public ACRadioButtonItem getStaffLackRadioItem2(){
    if(staffLackRadioItem2==null){

      staffLackRadioItem2 = new ACRadioButtonItem();

      staffLackRadioItem2.setText("�Ō�E��");

      staffLackRadioItem2.setGroup(getStaffLackRadioGroup());

      staffLackRadioItem2.setConstraints(VRLayout.FLOW);

      addStaffLackRadioItem2();
    }
    return staffLackRadioItem2;

  }

  /**
   * ���E�����擾���܂��B
   * @return ���E��
   */
  public ACRadioButtonItem getStaffLackRadioItem3(){
    if(staffLackRadioItem3==null){

      staffLackRadioItem3 = new ACRadioButtonItem();

      staffLackRadioItem3.setText("���E��");

      staffLackRadioItem3.setGroup(getStaffLackRadioGroup());

      staffLackRadioItem3.setConstraints(VRLayout.FLOW);

      addStaffLackRadioItem3();
    }
    return staffLackRadioItem3;

  }

  /**
   * �K��Ō�̐����Z���擾���܂��B
   * @return �K��Ō�̐����Z
   */
  public ACValueArrayRadioButtonGroup getNursingSystemSubtractionRadioGroup(){
    if(nursingSystemSubtractionRadioGroup==null){

      nursingSystemSubtractionRadioGroup = new ACValueArrayRadioButtonGroup();

      getNursingSystemSubtractionRadioGroupContainer().setText("�K��Ō�̐����Z");

      nursingSystemSubtractionRadioGroup.setBindPath("1770106");

      nursingSystemSubtractionRadioGroup.setVisible(true);

      nursingSystemSubtractionRadioGroup.setEnabled(true);

      nursingSystemSubtractionRadioGroup.setNoSelectIndex(0);

      nursingSystemSubtractionRadioGroup.setUseClearButton(false);

      nursingSystemSubtractionRadioGroup.setModel(getNursingSystemSubtractionRadioGroupModel());

      nursingSystemSubtractionRadioGroup.setValues(new int[]{1,2});

      addNursingSystemSubtractionRadioGroup();
    }
    return nursingSystemSubtractionRadioGroup;

  }

  /**
   * �K��Ō�̐����Z�R���e�i���擾���܂��B
   * @return �K��Ō�̐����Z�R���e�i
   */
  protected ACLabelContainer getNursingSystemSubtractionRadioGroupContainer(){
    if(nursingSystemSubtractionRadioGroupContainer==null){
      nursingSystemSubtractionRadioGroupContainer = new ACLabelContainer();
      nursingSystemSubtractionRadioGroupContainer.setFollowChildEnabled(true);
      nursingSystemSubtractionRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      nursingSystemSubtractionRadioGroupContainer.add(getNursingSystemSubtractionRadioGroup(), null);
    }
    return nursingSystemSubtractionRadioGroupContainer;
  }

  /**
   * �K��Ō�̐����Z���f�����擾���܂��B
   * @return �K��Ō�̐����Z���f��
   */
  protected ACListModelAdapter getNursingSystemSubtractionRadioGroupModel(){
    if(nursingSystemSubtractionRadioGroupModel==null){
      nursingSystemSubtractionRadioGroupModel = new ACListModelAdapter();
      addNursingSystemSubtractionRadioGroupModel();
    }
    return nursingSystemSubtractionRadioGroupModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getNursingSystemSubtractionRadioItem1(){
    if(nursingSystemSubtractionRadioItem1==null){

      nursingSystemSubtractionRadioItem1 = new ACRadioButtonItem();

      nursingSystemSubtractionRadioItem1.setText("�Ȃ�");

      nursingSystemSubtractionRadioItem1.setGroup(getNursingSystemSubtractionRadioGroup());

      nursingSystemSubtractionRadioItem1.setConstraints(VRLayout.FLOW);

      addNursingSystemSubtractionRadioItem1();
    }
    return nursingSystemSubtractionRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getNursingSystemSubtractionRadioItem2(){
    if(nursingSystemSubtractionRadioItem2==null){

      nursingSystemSubtractionRadioItem2 = new ACRadioButtonItem();

      nursingSystemSubtractionRadioItem2.setText("����");

      nursingSystemSubtractionRadioItem2.setGroup(getNursingSystemSubtractionRadioGroup());

      nursingSystemSubtractionRadioItem2.setConstraints(VRLayout.FLOW);

      addNursingSystemSubtractionRadioItem2();
    }
    return nursingSystemSubtractionRadioItem2;

  }

  /**
   * �T�e���C�g�̐����擾���܂��B
   * @return �T�e���C�g�̐�
   */
  public ACValueArrayRadioButtonGroup getSatelliteSystemRadioGroup(){
    if(satelliteSystemRadioGroup==null){

      satelliteSystemRadioGroup = new ACValueArrayRadioButtonGroup();

      getSatelliteSystemRadioGroupContainer().setText("�T�e���C�g�̐�");

      satelliteSystemRadioGroup.setBindPath("1770110");

      satelliteSystemRadioGroup.setVisible(true);

      satelliteSystemRadioGroup.setEnabled(true);

      satelliteSystemRadioGroup.setNoSelectIndex(0);

      satelliteSystemRadioGroup.setUseClearButton(false);

      satelliteSystemRadioGroup.setModel(getSatelliteSystemRadioGroupModel());

      satelliteSystemRadioGroup.setValues(new int[]{1,2});

      addSatelliteSystemRadioGroup();
    }
    return satelliteSystemRadioGroup;

  }

  /**
   * �T�e���C�g�̐��R���e�i���擾���܂��B
   * @return �T�e���C�g�̐��R���e�i
   */
  protected ACLabelContainer getSatelliteSystemRadioGroupContainer(){
    if(satelliteSystemRadioGroupContainer==null){
      satelliteSystemRadioGroupContainer = new ACLabelContainer();
      satelliteSystemRadioGroupContainer.setFollowChildEnabled(true);
      satelliteSystemRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      satelliteSystemRadioGroupContainer.add(getSatelliteSystemRadioGroup(), null);
    }
    return satelliteSystemRadioGroupContainer;
  }

  /**
   * �T�e���C�g�̐����f�����擾���܂��B
   * @return �T�e���C�g�̐����f��
   */
  protected ACListModelAdapter getSatelliteSystemRadioGroupModel(){
    if(satelliteSystemRadioGroupModel==null){
      satelliteSystemRadioGroupModel = new ACListModelAdapter();
      addSatelliteSystemRadioGroupModel();
    }
    return satelliteSystemRadioGroupModel;
  }

  /**
   * ��^���擾���܂��B
   * @return ��^
   */
  public ACRadioButtonItem getSatelliteSystemRadioItem1(){
    if(satelliteSystemRadioItem1==null){

      satelliteSystemRadioItem1 = new ACRadioButtonItem();

      satelliteSystemRadioItem1.setText("��^");

      satelliteSystemRadioItem1.setGroup(getSatelliteSystemRadioGroup());

      satelliteSystemRadioItem1.setConstraints(VRLayout.FLOW);

      addSatelliteSystemRadioItem1();
    }
    return satelliteSystemRadioItem1;

  }

  /**
   * ���Z�^���擾���܂��B
   * @return ���Z�^
   */
  public ACRadioButtonItem getSatelliteSystemRadioItem2(){
    if(satelliteSystemRadioItem2==null){

      satelliteSystemRadioItem2 = new ACRadioButtonItem();

      satelliteSystemRadioItem2.setText("���Z�^");

      satelliteSystemRadioItem2.setGroup(getSatelliteSystemRadioGroup());

      satelliteSystemRadioItem2.setConstraints(VRLayout.FLOW);

      addSatelliteSystemRadioItem2();
    }
    return satelliteSystemRadioItem2;

  }

  /**
   * ��N���F�m�Ǘ��p�Ҏ�����Z���擾���܂��B
   * @return ��N���F�m�Ǘ��p�Ҏ�����Z
   */
  public ACValueArrayRadioButtonGroup getYoungDementiaPatinetAddRadioGroup(){
    if(youngDementiaPatinetAddRadioGroup==null){

      youngDementiaPatinetAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getYoungDementiaPatinetAddRadioGroupContainer().setText("��N���F�m�Ǘ��p�Ҏ�����Z");

      youngDementiaPatinetAddRadioGroup.setBindPath("1770111");

      youngDementiaPatinetAddRadioGroup.setNoSelectIndex(0);

      youngDementiaPatinetAddRadioGroup.setUseClearButton(false);

      youngDementiaPatinetAddRadioGroup.setModel(getYoungDementiaPatinetAddRadioGroupModel());

      youngDementiaPatinetAddRadioGroup.setValues(new int[]{1,2});

      addYoungDementiaPatinetAddRadioGroup();
    }
    return youngDementiaPatinetAddRadioGroup;

  }

  /**
   * ��N���F�m�Ǘ��p�Ҏ�����Z�R���e�i���擾���܂��B
   * @return ��N���F�m�Ǘ��p�Ҏ�����Z�R���e�i
   */
  protected ACLabelContainer getYoungDementiaPatinetAddRadioGroupContainer(){
    if(youngDementiaPatinetAddRadioGroupContainer==null){
      youngDementiaPatinetAddRadioGroupContainer = new ACLabelContainer();
      youngDementiaPatinetAddRadioGroupContainer.setFollowChildEnabled(true);
      youngDementiaPatinetAddRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      youngDementiaPatinetAddRadioGroupContainer.add(getYoungDementiaPatinetAddRadioGroup(), null);
    }
    return youngDementiaPatinetAddRadioGroupContainer;
  }

  /**
   * ��N���F�m�Ǘ��p�Ҏ�����Z���f�����擾���܂��B
   * @return ��N���F�m�Ǘ��p�Ҏ�����Z���f��
   */
  protected ACListModelAdapter getYoungDementiaPatinetAddRadioGroupModel(){
    if(youngDementiaPatinetAddRadioGroupModel==null){
      youngDementiaPatinetAddRadioGroupModel = new ACListModelAdapter();
      addYoungDementiaPatinetAddRadioGroupModel();
    }
    return youngDementiaPatinetAddRadioGroupModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getYoungDementiaPatinetAddRadioItem1(){
    if(youngDementiaPatinetAddRadioItem1==null){

      youngDementiaPatinetAddRadioItem1 = new ACRadioButtonItem();

      youngDementiaPatinetAddRadioItem1.setText("�Ȃ�");

      youngDementiaPatinetAddRadioItem1.setGroup(getYoungDementiaPatinetAddRadioGroup());

      youngDementiaPatinetAddRadioItem1.setConstraints(VRLayout.FLOW);

      addYoungDementiaPatinetAddRadioItem1();
    }
    return youngDementiaPatinetAddRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getYoungDementiaPatinetAddRadioItem2(){
    if(youngDementiaPatinetAddRadioItem2==null){

      youngDementiaPatinetAddRadioItem2 = new ACRadioButtonItem();

      youngDementiaPatinetAddRadioItem2.setText("����");

      youngDementiaPatinetAddRadioItem2.setGroup(getYoungDementiaPatinetAddRadioGroup());

      youngDementiaPatinetAddRadioItem2.setConstraints(VRLayout.FLOW);

      addYoungDementiaPatinetAddRadioItem2();
    }
    return youngDementiaPatinetAddRadioItem2;

  }

  /**
   * �ً}���K��Ō���Z���擾���܂��B
   * @return �ً}���K��Ō���Z
   */
  public ACValueArrayRadioButtonGroup getEmergencyRadioGroup(){
    if(emergencyRadioGroup==null){

      emergencyRadioGroup = new ACValueArrayRadioButtonGroup();

      getEmergencyRadioGroupContainer().setText("�ً}���K��Ō���Z");

      emergencyRadioGroup.setBindPath("1770105");

      emergencyRadioGroup.setVisible(true);

      emergencyRadioGroup.setEnabled(true);

      emergencyRadioGroup.setNoSelectIndex(0);

      emergencyRadioGroup.setUseClearButton(false);

      emergencyRadioGroup.setModel(getEmergencyRadioGroupModel());

      emergencyRadioGroup.setValues(new int[]{1,2});

      addEmergencyRadioGroup();
    }
    return emergencyRadioGroup;

  }

  /**
   * �ً}���K��Ō���Z�R���e�i���擾���܂��B
   * @return �ً}���K��Ō���Z�R���e�i
   */
  protected ACLabelContainer getEmergencyRadioGroupContainer(){
    if(emergencyRadioGroupContainer==null){
      emergencyRadioGroupContainer = new ACLabelContainer();
      emergencyRadioGroupContainer.setFollowChildEnabled(true);
      emergencyRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      emergencyRadioGroupContainer.add(getEmergencyRadioGroup(), null);
    }
    return emergencyRadioGroupContainer;
  }

  /**
   * �ً}���K��Ō���Z���f�����擾���܂��B
   * @return �ً}���K��Ō���Z���f��
   */
  protected ACListModelAdapter getEmergencyRadioGroupModel(){
    if(emergencyRadioGroupModel==null){
      emergencyRadioGroupModel = new ACListModelAdapter();
      addEmergencyRadioGroupModel();
    }
    return emergencyRadioGroupModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getEmergencyRadioItem1(){
    if(emergencyRadioItem1==null){

      emergencyRadioItem1 = new ACRadioButtonItem();

      emergencyRadioItem1.setText("�Ȃ�");

      emergencyRadioItem1.setGroup(getEmergencyRadioGroup());

      emergencyRadioItem1.setConstraints(VRLayout.FLOW);

      addEmergencyRadioItem1();
    }
    return emergencyRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getEmergencyRadioItem2(){
    if(emergencyRadioItem2==null){

      emergencyRadioItem2 = new ACRadioButtonItem();

      emergencyRadioItem2.setText("����");

      emergencyRadioItem2.setGroup(getEmergencyRadioGroup());

      emergencyRadioItem2.setConstraints(VRLayout.FLOW);

      addEmergencyRadioItem2();
    }
    return emergencyRadioItem2;

  }

  /**
   * ���ʊǗ��̐����擾���܂��B
   * @return ���ʊǗ��̐�
   */
  public ACValueArrayRadioButtonGroup getSpecialManagementSystemRadioGroup(){
    if(specialManagementSystemRadioGroup==null){

      specialManagementSystemRadioGroup = new ACValueArrayRadioButtonGroup();

      getSpecialManagementSystemRadioGroupContainer().setText("���ʊǗ��̐�");

      specialManagementSystemRadioGroup.setBindPath("1770102");

      specialManagementSystemRadioGroup.setVisible(true);

      specialManagementSystemRadioGroup.setEnabled(true);

      specialManagementSystemRadioGroup.setNoSelectIndex(0);

      specialManagementSystemRadioGroup.setUseClearButton(false);

      specialManagementSystemRadioGroup.setModel(getSpecialManagementSystemRadioGroupModel());

      specialManagementSystemRadioGroup.setValues(new int[]{1,2});

      addSpecialManagementSystemRadioGroup();
    }
    return specialManagementSystemRadioGroup;

  }

  /**
   * ���ʊǗ��̐��R���e�i���擾���܂��B
   * @return ���ʊǗ��̐��R���e�i
   */
  protected ACLabelContainer getSpecialManagementSystemRadioGroupContainer(){
    if(specialManagementSystemRadioGroupContainer==null){
      specialManagementSystemRadioGroupContainer = new ACLabelContainer();
      specialManagementSystemRadioGroupContainer.setFollowChildEnabled(true);
      specialManagementSystemRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      specialManagementSystemRadioGroupContainer.add(getSpecialManagementSystemRadioGroup(), null);
    }
    return specialManagementSystemRadioGroupContainer;
  }

  /**
   * ���ʊǗ��̐����f�����擾���܂��B
   * @return ���ʊǗ��̐����f��
   */
  protected ACListModelAdapter getSpecialManagementSystemRadioGroupModel(){
    if(specialManagementSystemRadioGroupModel==null){
      specialManagementSystemRadioGroupModel = new ACListModelAdapter();
      addSpecialManagementSystemRadioGroupModel();
    }
    return specialManagementSystemRadioGroupModel;
  }

  /**
   * �Ή��s���擾���܂��B
   * @return �Ή��s��
   */
  public ACRadioButtonItem getSpecialManagementSystemRadioItem1(){
    if(specialManagementSystemRadioItem1==null){

      specialManagementSystemRadioItem1 = new ACRadioButtonItem();

      specialManagementSystemRadioItem1.setText("�Ή��s��");

      specialManagementSystemRadioItem1.setGroup(getSpecialManagementSystemRadioGroup());

      specialManagementSystemRadioItem1.setConstraints(VRLayout.FLOW);

      addSpecialManagementSystemRadioItem1();
    }
    return specialManagementSystemRadioItem1;

  }

  /**
   * �Ή����擾���܂��B
   * @return �Ή���
   */
  public ACRadioButtonItem getSpecialManagementSystemRadioItem2(){
    if(specialManagementSystemRadioItem2==null){

      specialManagementSystemRadioItem2 = new ACRadioButtonItem();

      specialManagementSystemRadioItem2.setText("�Ή���");

      specialManagementSystemRadioItem2.setGroup(getSpecialManagementSystemRadioGroup());

      specialManagementSystemRadioItem2.setConstraints(VRLayout.FLOW);

      addSpecialManagementSystemRadioItem2();
    }
    return specialManagementSystemRadioItem2;

  }

  /**
   * �^�[�~�i���P�A�̐����擾���܂��B
   * @return �^�[�~�i���P�A�̐�
   */
  public ACValueArrayRadioButtonGroup getTerminalCareRadioGroup(){
    if(terminalCareRadioGroup==null){

      terminalCareRadioGroup = new ACValueArrayRadioButtonGroup();

      getTerminalCareRadioGroupContainer().setText("�^�[�~�i���P�A�̐�");

      terminalCareRadioGroup.setBindPath("1770103");

      terminalCareRadioGroup.setVisible(true);

      terminalCareRadioGroup.setEnabled(true);

      terminalCareRadioGroup.setNoSelectIndex(0);

      terminalCareRadioGroup.setUseClearButton(false);

      terminalCareRadioGroup.setModel(getTerminalCareRadioGroupModel());

      terminalCareRadioGroup.setValues(new int[]{1,2});

      addTerminalCareRadioGroup();
    }
    return terminalCareRadioGroup;

  }

  /**
   * �^�[�~�i���P�A�̐��R���e�i���擾���܂��B
   * @return �^�[�~�i���P�A�̐��R���e�i
   */
  protected ACLabelContainer getTerminalCareRadioGroupContainer(){
    if(terminalCareRadioGroupContainer==null){
      terminalCareRadioGroupContainer = new ACLabelContainer();
      terminalCareRadioGroupContainer.setFollowChildEnabled(true);
      terminalCareRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      terminalCareRadioGroupContainer.add(getTerminalCareRadioGroup(), null);
    }
    return terminalCareRadioGroupContainer;
  }

  /**
   * �^�[�~�i���P�A�̐����f�����擾���܂��B
   * @return �^�[�~�i���P�A�̐����f��
   */
  protected ACListModelAdapter getTerminalCareRadioGroupModel(){
    if(terminalCareRadioGroupModel==null){
      terminalCareRadioGroupModel = new ACListModelAdapter();
      addTerminalCareRadioGroupModel();
    }
    return terminalCareRadioGroupModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getTerminalCareRadioItem1(){
    if(terminalCareRadioItem1==null){

      terminalCareRadioItem1 = new ACRadioButtonItem();

      terminalCareRadioItem1.setText("�Ȃ�");

      terminalCareRadioItem1.setGroup(getTerminalCareRadioGroup());

      terminalCareRadioItem1.setConstraints(VRLayout.FLOW);

      addTerminalCareRadioItem1();
    }
    return terminalCareRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getTerminalCareRadioItem2(){
    if(terminalCareRadioItem2==null){

      terminalCareRadioItem2 = new ACRadioButtonItem();

      terminalCareRadioItem2.setText("����");

      terminalCareRadioItem2.setGroup(getTerminalCareRadioGroup());

      terminalCareRadioItem2.setConstraints(VRLayout.FLOW);

      addTerminalCareRadioItem2();
    }
    return terminalCareRadioItem2;

  }

  /**
   * �Ō�̐��������Z���擾���܂��B
   * @return �Ō�̐��������Z
   */
  public ACValueArrayRadioButtonGroup getNursingStrengthenAddRadioGroup(){
    if(nursingStrengthenAddRadioGroup==null){

      nursingStrengthenAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getNursingStrengthenAddRadioGroupContainer().setText("�Ō�̐��������Z");

      nursingStrengthenAddRadioGroup.setBindPath("1770107");

      nursingStrengthenAddRadioGroup.setVisible(true);

      nursingStrengthenAddRadioGroup.setEnabled(true);

      nursingStrengthenAddRadioGroup.setNoSelectIndex(0);

      nursingStrengthenAddRadioGroup.setUseClearButton(false);

      nursingStrengthenAddRadioGroup.setModel(getNursingStrengthenAddRadioGroupModel());

      nursingStrengthenAddRadioGroup.setValues(new int[]{1,3,2});

      addNursingStrengthenAddRadioGroup();
    }
    return nursingStrengthenAddRadioGroup;

  }

  /**
   * �Ō�̐��������Z�R���e�i���擾���܂��B
   * @return �Ō�̐��������Z�R���e�i
   */
  protected ACLabelContainer getNursingStrengthenAddRadioGroupContainer(){
    if(nursingStrengthenAddRadioGroupContainer==null){
      nursingStrengthenAddRadioGroupContainer = new ACLabelContainer();
      nursingStrengthenAddRadioGroupContainer.setFollowChildEnabled(true);
      nursingStrengthenAddRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      nursingStrengthenAddRadioGroupContainer.add(getNursingStrengthenAddRadioGroup(), null);
    }
    return nursingStrengthenAddRadioGroupContainer;
  }

  /**
   * �Ō�̐��������Z���f�����擾���܂��B
   * @return �Ō�̐��������Z���f��
   */
  protected ACListModelAdapter getNursingStrengthenAddRadioGroupModel(){
    if(nursingStrengthenAddRadioGroupModel==null){
      nursingStrengthenAddRadioGroupModel = new ACListModelAdapter();
      addNursingStrengthenAddRadioGroupModel();
    }
    return nursingStrengthenAddRadioGroupModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getNursingStrengthenAddRadioItem1(){
    if(nursingStrengthenAddRadioItem1==null){

      nursingStrengthenAddRadioItem1 = new ACRadioButtonItem();

      nursingStrengthenAddRadioItem1.setText("�Ȃ�");

      nursingStrengthenAddRadioItem1.setGroup(getNursingStrengthenAddRadioGroup());

      nursingStrengthenAddRadioItem1.setConstraints(VRLayout.FLOW);

      addNursingStrengthenAddRadioItem1();
    }
    return nursingStrengthenAddRadioItem1;

  }

  /**
   * ���ZI���擾���܂��B
   * @return ���ZI
   */
  public ACRadioButtonItem getNursingStrengthenAddRadioItem2(){
    if(nursingStrengthenAddRadioItem2==null){

      nursingStrengthenAddRadioItem2 = new ACRadioButtonItem();

      nursingStrengthenAddRadioItem2.setText("���ZI");

      nursingStrengthenAddRadioItem2.setGroup(getNursingStrengthenAddRadioGroup());

      nursingStrengthenAddRadioItem2.setConstraints(VRLayout.FLOW);

      addNursingStrengthenAddRadioItem2();
    }
    return nursingStrengthenAddRadioItem2;

  }

  /**
   * ���ZII���擾���܂��B
   * @return ���ZII
   */
  public ACRadioButtonItem getNursingStrengthenAddRadioItem3(){
    if(nursingStrengthenAddRadioItem3==null){

      nursingStrengthenAddRadioItem3 = new ACRadioButtonItem();

      nursingStrengthenAddRadioItem3.setText("���ZII");

      nursingStrengthenAddRadioItem3.setGroup(getNursingStrengthenAddRadioGroup());

      nursingStrengthenAddRadioItem3.setConstraints(VRLayout.FLOW);

      addNursingStrengthenAddRadioItem3();
    }
    return nursingStrengthenAddRadioItem3;

  }

  /**
   * �K��̐��������Z���擾���܂��B
   * @return �K��̐��������Z
   */
  public ACValueArrayRadioButtonGroup getVisitStrengthenAddRadioGroup(){
    if(visitStrengthenAddRadioGroup==null){

      visitStrengthenAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getVisitStrengthenAddRadioGroupContainer().setText("�K��̐��������Z");

      visitStrengthenAddRadioGroup.setBindPath("1770112");

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

      comprehensiveManagementSystemRadioGroup.setBindPath("1770108");

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

      serviceAddProvisionStructuralRadioGroup.setBindPath("1770104");

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

      getStaffUpgradeRadioGroupContainer().setText("���E���������P���Z");

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

      staffUpgradeRadioItem5.setText("���ZIV");

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

      staffUpgradeRadioItem6.setText("���ZV");

      staffUpgradeRadioItem6.setGroup(getStaffUpgradeRadioGroup());

      staffUpgradeRadioItem6.setConstraints(VRLayout.FLOW);

      addStaffUpgradeRadioItem6();
    }
    return staffUpgradeRadioItem6;

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
  public QO004_17711_201804Design() {

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

    mainGroup.add(getStaffLackRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    mainGroup.add(getNursingSystemSubtractionRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    mainGroup.add(getSatelliteSystemRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    mainGroup.add(getYoungDementiaPatinetAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    mainGroup.add(getEmergencyRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    mainGroup.add(getSpecialManagementSystemRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    mainGroup.add(getTerminalCareRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    mainGroup.add(getNursingStrengthenAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    mainGroup.add(getVisitStrengthenAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    mainGroup.add(getComprehensiveManagementSystemRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    mainGroup.add(getServiceAddProvisionStructuralRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    mainGroup.add(getStaffUpgradeRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

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
   * �Ō쏬�K�͑��@�\�^�����쎖�Ə��ɓ������ڂ�ǉ����܂��B
   */
  protected void addFacilityDivisionRadioItem1(){

  }

  /**
   * �T�e���C�g�^�Ō쏬�K�͑��@�\�^�����쎖�Ə��ɓ������ڂ�ǉ����܂��B
   */
  protected void addFacilityDivisionRadioItem2(){

  }

  /**
   * �E���̌����ɂ�錸�Z�̏󋵂ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffLackRadioGroup(){

  }

  /**
   * �E���̌����ɂ�錸�Z�̏󋵃��f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffLackRadioGroupModel(){

    getStaffLackRadioItem1().setButtonIndex(1);

    getStaffLackRadioGroupModel().add(getStaffLackRadioItem1());

    getStaffLackRadioItem2().setButtonIndex(2);

    getStaffLackRadioGroupModel().add(getStaffLackRadioItem2());

    getStaffLackRadioItem3().setButtonIndex(3);

    getStaffLackRadioGroupModel().add(getStaffLackRadioItem3());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffLackRadioItem1(){

  }

  /**
   * �Ō�E���ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffLackRadioItem2(){

  }

  /**
   * ���E���ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffLackRadioItem3(){

  }

  /**
   * �K��Ō�̐����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addNursingSystemSubtractionRadioGroup(){

  }

  /**
   * �K��Ō�̐����Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addNursingSystemSubtractionRadioGroupModel(){

    getNursingSystemSubtractionRadioItem1().setButtonIndex(1);

    getNursingSystemSubtractionRadioGroupModel().add(getNursingSystemSubtractionRadioItem1());

    getNursingSystemSubtractionRadioItem2().setButtonIndex(2);

    getNursingSystemSubtractionRadioGroupModel().add(getNursingSystemSubtractionRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addNursingSystemSubtractionRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addNursingSystemSubtractionRadioItem2(){

  }

  /**
   * �T�e���C�g�̐��ɓ������ڂ�ǉ����܂��B
   */
  protected void addSatelliteSystemRadioGroup(){

  }

  /**
   * �T�e���C�g�̐����f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addSatelliteSystemRadioGroupModel(){

    getSatelliteSystemRadioItem1().setButtonIndex(1);

    getSatelliteSystemRadioGroupModel().add(getSatelliteSystemRadioItem1());

    getSatelliteSystemRadioItem2().setButtonIndex(2);

    getSatelliteSystemRadioGroupModel().add(getSatelliteSystemRadioItem2());

  }

  /**
   * ��^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addSatelliteSystemRadioItem1(){

  }

  /**
   * ���Z�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addSatelliteSystemRadioItem2(){

  }

  /**
   * ��N���F�m�Ǘ��p�Ҏ�����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addYoungDementiaPatinetAddRadioGroup(){

  }

  /**
   * ��N���F�m�Ǘ��p�Ҏ�����Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addYoungDementiaPatinetAddRadioGroupModel(){

    getYoungDementiaPatinetAddRadioItem1().setButtonIndex(1);

    getYoungDementiaPatinetAddRadioGroupModel().add(getYoungDementiaPatinetAddRadioItem1());

    getYoungDementiaPatinetAddRadioItem2().setButtonIndex(2);

    getYoungDementiaPatinetAddRadioGroupModel().add(getYoungDementiaPatinetAddRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addYoungDementiaPatinetAddRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addYoungDementiaPatinetAddRadioItem2(){

  }

  /**
   * �ً}���K��Ō���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addEmergencyRadioGroup(){

  }

  /**
   * �ً}���K��Ō���Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addEmergencyRadioGroupModel(){

    getEmergencyRadioItem1().setButtonIndex(1);

    getEmergencyRadioGroupModel().add(getEmergencyRadioItem1());

    getEmergencyRadioItem2().setButtonIndex(2);

    getEmergencyRadioGroupModel().add(getEmergencyRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addEmergencyRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addEmergencyRadioItem2(){

  }

  /**
   * ���ʊǗ��̐��ɓ������ڂ�ǉ����܂��B
   */
  protected void addSpecialManagementSystemRadioGroup(){

  }

  /**
   * ���ʊǗ��̐����f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addSpecialManagementSystemRadioGroupModel(){

    getSpecialManagementSystemRadioItem1().setButtonIndex(1);

    getSpecialManagementSystemRadioGroupModel().add(getSpecialManagementSystemRadioItem1());

    getSpecialManagementSystemRadioItem2().setButtonIndex(2);

    getSpecialManagementSystemRadioGroupModel().add(getSpecialManagementSystemRadioItem2());

  }

  /**
   * �Ή��s�ɓ������ڂ�ǉ����܂��B
   */
  protected void addSpecialManagementSystemRadioItem1(){

  }

  /**
   * �Ή��ɓ������ڂ�ǉ����܂��B
   */
  protected void addSpecialManagementSystemRadioItem2(){

  }

  /**
   * �^�[�~�i���P�A�̐��ɓ������ڂ�ǉ����܂��B
   */
  protected void addTerminalCareRadioGroup(){

  }

  /**
   * �^�[�~�i���P�A�̐����f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addTerminalCareRadioGroupModel(){

    getTerminalCareRadioItem1().setButtonIndex(1);

    getTerminalCareRadioGroupModel().add(getTerminalCareRadioItem1());

    getTerminalCareRadioItem2().setButtonIndex(2);

    getTerminalCareRadioGroupModel().add(getTerminalCareRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addTerminalCareRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addTerminalCareRadioItem2(){

  }

  /**
   * �Ō�̐��������Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addNursingStrengthenAddRadioGroup(){

  }

  /**
   * �Ō�̐��������Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addNursingStrengthenAddRadioGroupModel(){

    getNursingStrengthenAddRadioItem1().setButtonIndex(1);

    getNursingStrengthenAddRadioGroupModel().add(getNursingStrengthenAddRadioItem1());

    getNursingStrengthenAddRadioItem2().setButtonIndex(3);

    getNursingStrengthenAddRadioGroupModel().add(getNursingStrengthenAddRadioItem2());

    getNursingStrengthenAddRadioItem3().setButtonIndex(2);

    getNursingStrengthenAddRadioGroupModel().add(getNursingStrengthenAddRadioItem3());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addNursingStrengthenAddRadioItem1(){

  }

  /**
   * ���ZI�ɓ������ڂ�ǉ����܂��B
   */
  protected void addNursingStrengthenAddRadioItem2(){

  }

  /**
   * ���ZII�ɓ������ڂ�ǉ����܂��B
   */
  protected void addNursingStrengthenAddRadioItem3(){

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
      ACFrame.debugStart(new ACAffairInfo(QO004_17711_201804Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QO004_17711_201804Design getThis() {
    return this;
  }
}
