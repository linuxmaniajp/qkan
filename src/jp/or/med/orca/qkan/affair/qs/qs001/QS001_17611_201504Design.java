
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
 * �J����: ����@��F
 * �쐬��: 2015/03/02  ���{�R���s���[�^�[������� ����@��F �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �T�[�r�X�\��쐬/�ύX (S)
 * �v���Z�X �T�[�r�X�\��T�� (001)
 * �v���O���� �T�[�r�X�p�^�[���������E�����Ή��^�K����Ō� (QS001_17611_201504)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
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
 * �T�[�r�X�p�^�[���������E�����Ή��^�K����Ō��ʍ��ڃf�U�C��(QS001_17611_201504) 
 */
public class QS001_17611_201504Design extends QS001ServicePanel {
  //GUI�R���|�[�l���g

  private JTabbedPane tabs;

  private ACPanel tab1;

  private ACValueArrayRadioButtonGroup divisionRadioGroup;

  private ACLabelContainer divisionRadioGroupContainer;

  private ACListModelAdapter divisionRadioGroupModel;

  private ACRadioButtonItem divisionRadioItem1;

  private ACRadioButtonItem divisionRadioItem2;

  private ACValueArrayRadioButtonGroup sijishoOfferRadioGroup;

  private ACLabelContainer sijishoOfferRadioGroupContainer;

  private ACListModelAdapter sijishoOfferRadioGroupModel;

  private ACRadioButtonItem sijishoOfferRadioItem1;

  private ACRadioButtonItem sijishoOfferRadioItem2;

  private ACValueArrayRadioButtonGroup nurseStaffDivisionRadioGroup;

  private ACLabelContainer nurseStaffDivisionRadioGroupContainer;

  private ACListModelAdapter nurseStaffDivisionRadioGroupModel;

  private ACRadioButtonItem nurseStaffDivisionRadioItem1;

  private ACRadioButtonItem nurseStaffDivisionRadioItem2;

  private ACValueArrayRadioButtonGroup initialAddRadioGroup;

  private ACLabelContainer initialAddRadioGroupContainer;

  private ACListModelAdapter initialAddRadioGroupModel;

  private ACRadioButtonItem initialAddRadioItem1;

  private ACRadioButtonItem initialAddRadioItem2;

  private ACValueArrayRadioButtonGroup emergencyVisitRadioGroup;

  private ACLabelContainer emergencyVisitRadioGroupContainer;

  private ACListModelAdapter emergencyVisitRadioGroupModel;

  private ACRadioButtonItem emergencyVisitRadioItem1;

  private ACRadioButtonItem emergencyVisitRadioItem2;

  private ACValueArrayRadioButtonGroup specialManagementRadioGroup;

  private ACLabelContainer specialManagementRadioGroupContainer;

  private ACListModelAdapter specialManagementRadioGroupModel;

  private ACRadioButtonItem specialManagementRadioItem1;

  private ACRadioButtonItem specialManagementRadioItem2;

  private ACRadioButtonItem specialManagementRadioItem3;

  private ACLabelContainer leaveConcernContainer;

  private ACIntegerCheckBox leaveAfterVisitCheck;

  private ACValueArrayRadioButtonGroup terminalCareRadioGroup;

  private ACLabelContainer terminalCareRadioGroupContainer;

  private ACListModelAdapter terminalCareRadioGroupModel;

  private ACRadioButtonItem terminalCareRadioItem1;

  private ACRadioButtonItem terminalCareRadioItem2;

  private ACPanel tab2;

  private ACValueArrayRadioButtonGroup serviceAddProvisionStructuralRadioGroup;

  private ACLabelContainer serviceAddProvisionStructuralRadioGroupContainer;

  private ACListModelAdapter serviceAddProvisionStructuralRadioGroupModel;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem1;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem2;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem5;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem3;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem4;

  private ACValueArrayRadioButtonGroup providerAddMountainousAreaRafioRadioGroup;

  private ACLabelContainer providerAddMountainousAreaRafioRadioGroupContainer;

  private ACListModelAdapter providerAddMountainousAreaRafioRadioGroupModel;

  private ACRadioButtonItem providerAddMountainousAreaRafioItem1;

  private ACRadioButtonItem providerAddMountainousAreaRafioRadioItem2;

  private ACComboBox serviceMunicipalityAdd;

  private ACLabelContainer serviceMunicipalityAddContainer;

  private ACComboBoxModelAdapter serviceMunicipalityAddModel;

  private ACValueArrayRadioButtonGroup dayCareUseSubtractionRadioGroup;

  private ACLabelContainer dayCareUseSubtractionRadioGroupContainer;

  private ACListModelAdapter dayCareUseSubtractionRadioGroupModel;

  private ACRadioButtonItem dayCareUseSubtractionRadioItem1;

  private ACRadioButtonItem dayCareUseSubtractionRadioItem2;

  private ACValueArrayRadioButtonGroup calculationDivision;

  private ACLabelContainer calculationDivisionContainer;

  private ACListModelAdapter calculationDivisionModel;

  private ACRadioButtonItem calculationDivisionNormal;

  private ACRadioButtonItem calculationDivisionAddOnly;

  private ACIntegerCheckBox crackOnDayCheck;

  private ACIntegerCheckBox printable;

  private ACBackLabelContainer homonNyuyokuTimeContainer;

  private ACTimeComboBox homonNyuyokuBeginTime;

  private ACLabelContainer homonNyuyokuBeginTimeContainer;

  private ACComboBoxModelAdapter homonNyuyokuBeginTimeModel;

  private ACTimeComboBox homonNyuyokuEndTime;

  private ACLabelContainer homonNyuyokuEndTimeContainer;

  private ACComboBoxModelAdapter homonNyuyokuEndTimeModel;

  private ACValueArrayRadioButtonGroup sameBuildingRadioGroup;

  private ACLabelContainer sameBuildingRadioGroupContainer;

  private ACListModelAdapter sameBuildingRadioGroupModel;

  private ACRadioButtonItem sameBuildingRadioItem1;

  private ACRadioButtonItem sameBuildingRadioItem2;

  private ACValueArrayRadioButtonGroup comprehensiveManagementSystemRadioGroup;

  private ACLabelContainer comprehensiveManagementSystemRadioGroupContainer;

  private ACListModelAdapter comprehensiveManagementSystemRadioGroupModel;

  private ACRadioButtonItem comprehensiveManagementSystemRadioItem1;

  private ACRadioButtonItem comprehensiveManagementSystemRadioItem2;

  //getter

  /**
   * �^�u�y�C�����擾���܂��B
   * @return �^�u�y�C��
   */
  public JTabbedPane getTabs(){
    if(tabs==null){

      tabs = new JTabbedPane();

      addTabs();
    }
    return tabs;

  }

  /**
   * �^�u1���擾���܂��B
   * @return �^�u1
   */
  public ACPanel getTab1(){
    if(tab1==null){

      tab1 = new ACPanel();

      tab1.setFollowChildEnabled(true);

      tab1.setHgap(0);

      addTab1();
    }
    return tab1;

  }

  /**
   * �T�[�r�X�񋟂��擾���܂��B
   * @return �T�[�r�X��
   */
  public ACValueArrayRadioButtonGroup getDivisionRadioGroup(){
    if(divisionRadioGroup==null){

      divisionRadioGroup = new ACValueArrayRadioButtonGroup();

      getDivisionRadioGroupContainer().setText("�T�[�r�X��");

      divisionRadioGroup.setBindPath("1760101");

      divisionRadioGroup.setUseClearButton(false);

      divisionRadioGroup.setModel(getDivisionRadioGroupModel());

      divisionRadioGroup.setValues(new int[]{1,2});

      addDivisionRadioGroup();
    }
    return divisionRadioGroup;

  }

  /**
   * �T�[�r�X�񋟃R���e�i���擾���܂��B
   * @return �T�[�r�X�񋟃R���e�i
   */
  protected ACLabelContainer getDivisionRadioGroupContainer(){
    if(divisionRadioGroupContainer==null){
      divisionRadioGroupContainer = new ACLabelContainer();
      divisionRadioGroupContainer.setFollowChildEnabled(true);
      divisionRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      divisionRadioGroupContainer.add(getDivisionRadioGroup(), null);
    }
    return divisionRadioGroupContainer;
  }

  /**
   * �T�[�r�X�񋟃��f�����擾���܂��B
   * @return �T�[�r�X�񋟃��f��
   */
  protected ACListModelAdapter getDivisionRadioGroupModel(){
    if(divisionRadioGroupModel==null){
      divisionRadioGroupModel = new ACListModelAdapter();
      addDivisionRadioGroupModel();
    }
    return divisionRadioGroupModel;
  }

  /**
   * ��̌^���������擾���܂��B
   * @return ��̌^�������
   */
  public ACRadioButtonItem getDivisionRadioItem1(){
    if(divisionRadioItem1==null){

      divisionRadioItem1 = new ACRadioButtonItem();

      divisionRadioItem1.setText("��̌^�������");

      divisionRadioItem1.setGroup(getDivisionRadioGroup());

      divisionRadioItem1.setConstraints(VRLayout.FLOW_RETURN);

      addDivisionRadioItem1();
    }
    return divisionRadioItem1;

  }

  /**
   * �A�g�^���������擾���܂��B
   * @return �A�g�^�������
   */
  public ACRadioButtonItem getDivisionRadioItem2(){
    if(divisionRadioItem2==null){

      divisionRadioItem2 = new ACRadioButtonItem();

      divisionRadioItem2.setText("�A�g�^�������");

      divisionRadioItem2.setGroup(getDivisionRadioGroup());

      divisionRadioItem2.setConstraints(VRLayout.FLOW);

      addDivisionRadioItem2();
    }
    return divisionRadioItem2;

  }

  /**
   * �K��Ō�T�[�r�X�̒񋟂��擾���܂��B
   * @return �K��Ō�T�[�r�X�̒�
   */
  public ACValueArrayRadioButtonGroup getSijishoOfferRadioGroup(){
    if(sijishoOfferRadioGroup==null){

      sijishoOfferRadioGroup = new ACValueArrayRadioButtonGroup();

      getSijishoOfferRadioGroupContainer().setText("�K��Ō�T�[�r�X�̒�");

      sijishoOfferRadioGroup.setBindPath("1760102");

      sijishoOfferRadioGroup.setUseClearButton(false);

      sijishoOfferRadioGroup.setModel(getSijishoOfferRadioGroupModel());

      sijishoOfferRadioGroup.setValues(new int[]{1,2});

      addSijishoOfferRadioGroup();
    }
    return sijishoOfferRadioGroup;

  }

  /**
   * �K��Ō�T�[�r�X�̒񋟃R���e�i���擾���܂��B
   * @return �K��Ō�T�[�r�X�̒񋟃R���e�i
   */
  protected ACLabelContainer getSijishoOfferRadioGroupContainer(){
    if(sijishoOfferRadioGroupContainer==null){
      sijishoOfferRadioGroupContainer = new ACLabelContainer();
      sijishoOfferRadioGroupContainer.setFollowChildEnabled(true);
      sijishoOfferRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      sijishoOfferRadioGroupContainer.add(getSijishoOfferRadioGroup(), null);
    }
    return sijishoOfferRadioGroupContainer;
  }

  /**
   * �K��Ō�T�[�r�X�̒񋟃��f�����擾���܂��B
   * @return �K��Ō�T�[�r�X�̒񋟃��f��
   */
  protected ACListModelAdapter getSijishoOfferRadioGroupModel(){
    if(sijishoOfferRadioGroupModel==null){
      sijishoOfferRadioGroupModel = new ACListModelAdapter();
      addSijishoOfferRadioGroupModel();
    }
    return sijishoOfferRadioGroupModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getSijishoOfferRadioItem1(){
    if(sijishoOfferRadioItem1==null){

      sijishoOfferRadioItem1 = new ACRadioButtonItem();

      sijishoOfferRadioItem1.setText("�Ȃ�");

      sijishoOfferRadioItem1.setGroup(getSijishoOfferRadioGroup());

      sijishoOfferRadioItem1.setConstraints(VRLayout.FLOW);

      addSijishoOfferRadioItem1();
    }
    return sijishoOfferRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getSijishoOfferRadioItem2(){
    if(sijishoOfferRadioItem2==null){

      sijishoOfferRadioItem2 = new ACRadioButtonItem();

      sijishoOfferRadioItem2.setText("����");

      sijishoOfferRadioItem2.setGroup(getSijishoOfferRadioGroup());

      sijishoOfferRadioItem2.setConstraints(VRLayout.FLOW);

      addSijishoOfferRadioItem2();
    }
    return sijishoOfferRadioItem2;

  }

  /**
   * �Ō�E���敪���擾���܂��B
   * @return �Ō�E���敪
   */
  public ACValueArrayRadioButtonGroup getNurseStaffDivisionRadioGroup(){
    if(nurseStaffDivisionRadioGroup==null){

      nurseStaffDivisionRadioGroup = new ACValueArrayRadioButtonGroup();

      getNurseStaffDivisionRadioGroupContainer().setText("�Ō�E���敪");

      nurseStaffDivisionRadioGroup.setBindPath("1760103");

      nurseStaffDivisionRadioGroup.setUseClearButton(false);

      nurseStaffDivisionRadioGroup.setModel(getNurseStaffDivisionRadioGroupModel());

      nurseStaffDivisionRadioGroup.setValues(new int[]{1,2});

      addNurseStaffDivisionRadioGroup();
    }
    return nurseStaffDivisionRadioGroup;

  }

  /**
   * �Ō�E���敪�R���e�i���擾���܂��B
   * @return �Ō�E���敪�R���e�i
   */
  protected ACLabelContainer getNurseStaffDivisionRadioGroupContainer(){
    if(nurseStaffDivisionRadioGroupContainer==null){
      nurseStaffDivisionRadioGroupContainer = new ACLabelContainer();
      nurseStaffDivisionRadioGroupContainer.setFollowChildEnabled(true);
      nurseStaffDivisionRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      nurseStaffDivisionRadioGroupContainer.add(getNurseStaffDivisionRadioGroup(), null);
    }
    return nurseStaffDivisionRadioGroupContainer;
  }

  /**
   * �Ō�E���敪���f�����擾���܂��B
   * @return �Ō�E���敪���f��
   */
  protected ACListModelAdapter getNurseStaffDivisionRadioGroupModel(){
    if(nurseStaffDivisionRadioGroupModel==null){
      nurseStaffDivisionRadioGroupModel = new ACListModelAdapter();
      addNurseStaffDivisionRadioGroupModel();
    }
    return nurseStaffDivisionRadioGroupModel;
  }

  /**
   * ���œ����擾���܂��B
   * @return ���œ�
   */
  public ACRadioButtonItem getNurseStaffDivisionRadioItem1(){
    if(nurseStaffDivisionRadioItem1==null){

      nurseStaffDivisionRadioItem1 = new ACRadioButtonItem();

      nurseStaffDivisionRadioItem1.setText("���œ�");

      nurseStaffDivisionRadioItem1.setGroup(getNurseStaffDivisionRadioGroup());

      nurseStaffDivisionRadioItem1.setConstraints(VRLayout.FLOW);

      addNurseStaffDivisionRadioItem1();
    }
    return nurseStaffDivisionRadioItem1;

  }

  /**
   * �y�ł��擾���܂��B
   * @return �y��
   */
  public ACRadioButtonItem getNurseStaffDivisionRadioItem2(){
    if(nurseStaffDivisionRadioItem2==null){

      nurseStaffDivisionRadioItem2 = new ACRadioButtonItem();

      nurseStaffDivisionRadioItem2.setText("�y��");

      nurseStaffDivisionRadioItem2.setGroup(getNurseStaffDivisionRadioGroup());

      nurseStaffDivisionRadioItem2.setConstraints(VRLayout.FLOW);

      addNurseStaffDivisionRadioItem2();
    }
    return nurseStaffDivisionRadioItem2;

  }

  /**
   * �������Z���擾���܂��B
   * @return �������Z
   */
  public ACValueArrayRadioButtonGroup getInitialAddRadioGroup(){
    if(initialAddRadioGroup==null){

      initialAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getInitialAddRadioGroupContainer().setText("�������Z");

      initialAddRadioGroup.setBindPath("1760104");

      initialAddRadioGroup.setUseClearButton(false);

      initialAddRadioGroup.setModel(getInitialAddRadioGroupModel());

      initialAddRadioGroup.setValues(new int[]{1,2});

      addInitialAddRadioGroup();
    }
    return initialAddRadioGroup;

  }

  /**
   * �������Z�R���e�i���擾���܂��B
   * @return �������Z�R���e�i
   */
  protected ACLabelContainer getInitialAddRadioGroupContainer(){
    if(initialAddRadioGroupContainer==null){
      initialAddRadioGroupContainer = new ACLabelContainer();
      initialAddRadioGroupContainer.setFollowChildEnabled(true);
      initialAddRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      initialAddRadioGroupContainer.add(getInitialAddRadioGroup(), null);
    }
    return initialAddRadioGroupContainer;
  }

  /**
   * �������Z���f�����擾���܂��B
   * @return �������Z���f��
   */
  protected ACListModelAdapter getInitialAddRadioGroupModel(){
    if(initialAddRadioGroupModel==null){
      initialAddRadioGroupModel = new ACListModelAdapter();
      addInitialAddRadioGroupModel();
    }
    return initialAddRadioGroupModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getInitialAddRadioItem1(){
    if(initialAddRadioItem1==null){

      initialAddRadioItem1 = new ACRadioButtonItem();

      initialAddRadioItem1.setText("�Ȃ�");

      initialAddRadioItem1.setGroup(getInitialAddRadioGroup());

      initialAddRadioItem1.setConstraints(VRLayout.FLOW);

      addInitialAddRadioItem1();
    }
    return initialAddRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getInitialAddRadioItem2(){
    if(initialAddRadioItem2==null){

      initialAddRadioItem2 = new ACRadioButtonItem();

      initialAddRadioItem2.setText("����");

      initialAddRadioItem2.setGroup(getInitialAddRadioGroup());

      initialAddRadioItem2.setConstraints(VRLayout.FLOW);

      addInitialAddRadioItem2();
    }
    return initialAddRadioItem2;

  }

  /**
   * �ً}���K��Ō���Z���擾���܂��B
   * @return �ً}���K��Ō���Z
   */
  public ACValueArrayRadioButtonGroup getEmergencyVisitRadioGroup(){
    if(emergencyVisitRadioGroup==null){

      emergencyVisitRadioGroup = new ACValueArrayRadioButtonGroup();

      getEmergencyVisitRadioGroupContainer().setText("�ً}���K��Ō���Z");

      emergencyVisitRadioGroup.setBindPath("1760105");

      emergencyVisitRadioGroup.setUseClearButton(false);

      emergencyVisitRadioGroup.setModel(getEmergencyVisitRadioGroupModel());

      emergencyVisitRadioGroup.setValues(new int[]{1,2});

      addEmergencyVisitRadioGroup();
    }
    return emergencyVisitRadioGroup;

  }

  /**
   * �ً}���K��Ō���Z�R���e�i���擾���܂��B
   * @return �ً}���K��Ō���Z�R���e�i
   */
  protected ACLabelContainer getEmergencyVisitRadioGroupContainer(){
    if(emergencyVisitRadioGroupContainer==null){
      emergencyVisitRadioGroupContainer = new ACLabelContainer();
      emergencyVisitRadioGroupContainer.setFollowChildEnabled(true);
      emergencyVisitRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      emergencyVisitRadioGroupContainer.add(getEmergencyVisitRadioGroup(), null);
    }
    return emergencyVisitRadioGroupContainer;
  }

  /**
   * �ً}���K��Ō���Z���f�����擾���܂��B
   * @return �ً}���K��Ō���Z���f��
   */
  protected ACListModelAdapter getEmergencyVisitRadioGroupModel(){
    if(emergencyVisitRadioGroupModel==null){
      emergencyVisitRadioGroupModel = new ACListModelAdapter();
      addEmergencyVisitRadioGroupModel();
    }
    return emergencyVisitRadioGroupModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getEmergencyVisitRadioItem1(){
    if(emergencyVisitRadioItem1==null){

      emergencyVisitRadioItem1 = new ACRadioButtonItem();

      emergencyVisitRadioItem1.setText("�Ȃ�");

      emergencyVisitRadioItem1.setGroup(getEmergencyVisitRadioGroup());

      emergencyVisitRadioItem1.setConstraints(VRLayout.FLOW);

      addEmergencyVisitRadioItem1();
    }
    return emergencyVisitRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getEmergencyVisitRadioItem2(){
    if(emergencyVisitRadioItem2==null){

      emergencyVisitRadioItem2 = new ACRadioButtonItem();

      emergencyVisitRadioItem2.setText("����");

      emergencyVisitRadioItem2.setGroup(getEmergencyVisitRadioGroup());

      emergencyVisitRadioItem2.setConstraints(VRLayout.FLOW);

      addEmergencyVisitRadioItem2();
    }
    return emergencyVisitRadioItem2;

  }

  /**
   * ���ʊǗ����Z���擾���܂��B
   * @return ���ʊǗ����Z
   */
  public ACValueArrayRadioButtonGroup getSpecialManagementRadioGroup(){
    if(specialManagementRadioGroup==null){

      specialManagementRadioGroup = new ACValueArrayRadioButtonGroup();

      getSpecialManagementRadioGroupContainer().setText("���ʊǗ����Z");

      specialManagementRadioGroup.setBindPath("1760106");

      specialManagementRadioGroup.setUseClearButton(false);

      specialManagementRadioGroup.setModel(getSpecialManagementRadioGroupModel());

      specialManagementRadioGroup.setValues(new int[]{1,2,3});

      addSpecialManagementRadioGroup();
    }
    return specialManagementRadioGroup;

  }

  /**
   * ���ʊǗ����Z�R���e�i���擾���܂��B
   * @return ���ʊǗ����Z�R���e�i
   */
  protected ACLabelContainer getSpecialManagementRadioGroupContainer(){
    if(specialManagementRadioGroupContainer==null){
      specialManagementRadioGroupContainer = new ACLabelContainer();
      specialManagementRadioGroupContainer.setFollowChildEnabled(true);
      specialManagementRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      specialManagementRadioGroupContainer.add(getSpecialManagementRadioGroup(), null);
    }
    return specialManagementRadioGroupContainer;
  }

  /**
   * ���ʊǗ����Z���f�����擾���܂��B
   * @return ���ʊǗ����Z���f��
   */
  protected ACListModelAdapter getSpecialManagementRadioGroupModel(){
    if(specialManagementRadioGroupModel==null){
      specialManagementRadioGroupModel = new ACListModelAdapter();
      addSpecialManagementRadioGroupModel();
    }
    return specialManagementRadioGroupModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getSpecialManagementRadioItem1(){
    if(specialManagementRadioItem1==null){

      specialManagementRadioItem1 = new ACRadioButtonItem();

      specialManagementRadioItem1.setText("�Ȃ�");

      specialManagementRadioItem1.setGroup(getSpecialManagementRadioGroup());

      specialManagementRadioItem1.setConstraints(VRLayout.FLOW);

      addSpecialManagementRadioItem1();
    }
    return specialManagementRadioItem1;

  }

  /**
   * I�^���擾���܂��B
   * @return I�^
   */
  public ACRadioButtonItem getSpecialManagementRadioItem2(){
    if(specialManagementRadioItem2==null){

      specialManagementRadioItem2 = new ACRadioButtonItem();

      specialManagementRadioItem2.setText("I�^");

      specialManagementRadioItem2.setGroup(getSpecialManagementRadioGroup());

      specialManagementRadioItem2.setConstraints(VRLayout.FLOW);

      addSpecialManagementRadioItem2();
    }
    return specialManagementRadioItem2;

  }

  /**
   * II�^���擾���܂��B
   * @return II�^
   */
  public ACRadioButtonItem getSpecialManagementRadioItem3(){
    if(specialManagementRadioItem3==null){

      specialManagementRadioItem3 = new ACRadioButtonItem();

      specialManagementRadioItem3.setText("II�^");

      specialManagementRadioItem3.setGroup(getSpecialManagementRadioGroup());

      specialManagementRadioItem3.setConstraints(VRLayout.FLOW);

      addSpecialManagementRadioItem3();
    }
    return specialManagementRadioItem3;

  }

  /**
   * �ޏ��֘A���Z���擾���܂��B
   * @return �ޏ��֘A���Z
   */
  public ACLabelContainer getLeaveConcernContainer(){
    if(leaveConcernContainer==null){

      leaveConcernContainer = new ACLabelContainer();

      leaveConcernContainer.setText("�ޏ��֘A���Z");

      leaveConcernContainer.setFollowChildEnabled(true);

      addLeaveConcernContainer();
    }
    return leaveConcernContainer;

  }

  /**
   * �މ@�������w�����Z���擾���܂��B
   * @return �މ@�������w�����Z
   */
  public ACIntegerCheckBox getLeaveAfterVisitCheck(){
    if(leaveAfterVisitCheck==null){

      leaveAfterVisitCheck = new ACIntegerCheckBox();

      leaveAfterVisitCheck.setText("�މ@�������w�����Z");

      leaveAfterVisitCheck.setBindPath("3020111");

      leaveAfterVisitCheck.setSelectValue(2);

      leaveAfterVisitCheck.setUnSelectValue(1);

      addLeaveAfterVisitCheck();
    }
    return leaveAfterVisitCheck;

  }

  /**
   * �^�[�~�i���P�A���Z���擾���܂��B
   * @return �^�[�~�i���P�A���Z
   */
  public ACValueArrayRadioButtonGroup getTerminalCareRadioGroup(){
    if(terminalCareRadioGroup==null){

      terminalCareRadioGroup = new ACValueArrayRadioButtonGroup();

      getTerminalCareRadioGroupContainer().setText("�^�[�~�i���P�A���Z");

      terminalCareRadioGroup.setBindPath("1760107");

      terminalCareRadioGroup.setUseClearButton(false);

      terminalCareRadioGroup.setModel(getTerminalCareRadioGroupModel());

      terminalCareRadioGroup.setValues(new int[]{1,2});

      addTerminalCareRadioGroup();
    }
    return terminalCareRadioGroup;

  }

  /**
   * �^�[�~�i���P�A���Z�R���e�i���擾���܂��B
   * @return �^�[�~�i���P�A���Z�R���e�i
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
   * �^�[�~�i���P�A���Z���f�����擾���܂��B
   * @return �^�[�~�i���P�A���Z���f��
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
   * �^�u2���擾���܂��B
   * @return �^�u2
   */
  public ACPanel getTab2(){
    if(tab2==null){

      tab2 = new ACPanel();

      tab2.setFollowChildEnabled(true);

      tab2.setHgap(0);

      addTab2();
    }
    return tab2;

  }

  /**
   * �T�[�r�X�񋟑̐��������Z���擾���܂��B
   * @return �T�[�r�X�񋟑̐��������Z
   */
  public ACValueArrayRadioButtonGroup getServiceAddProvisionStructuralRadioGroup(){
    if(serviceAddProvisionStructuralRadioGroup==null){

      serviceAddProvisionStructuralRadioGroup = new ACValueArrayRadioButtonGroup();

      getServiceAddProvisionStructuralRadioGroupContainer().setText("�T�[�r�X�񋟑̐��������Z");

      serviceAddProvisionStructuralRadioGroup.setBindPath("1760108");

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
   * I�C�^���擾���܂��B
   * @return I�C�^
   */
  public ACRadioButtonItem getServiceAddProvisionStructuralRadioItem2(){
    if(serviceAddProvisionStructuralRadioItem2==null){

      serviceAddProvisionStructuralRadioItem2 = new ACRadioButtonItem();

      serviceAddProvisionStructuralRadioItem2.setText("I�C�^");

      serviceAddProvisionStructuralRadioItem2.setGroup(getServiceAddProvisionStructuralRadioGroup());

      serviceAddProvisionStructuralRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

      addServiceAddProvisionStructuralRadioItem2();
    }
    return serviceAddProvisionStructuralRadioItem2;

  }

  /**
   * I���^���擾���܂��B
   * @return I���^
   */
  public ACRadioButtonItem getServiceAddProvisionStructuralRadioItem5(){
    if(serviceAddProvisionStructuralRadioItem5==null){

      serviceAddProvisionStructuralRadioItem5 = new ACRadioButtonItem();

      serviceAddProvisionStructuralRadioItem5.setText("I���^");

      serviceAddProvisionStructuralRadioItem5.setGroup(getServiceAddProvisionStructuralRadioGroup());

      serviceAddProvisionStructuralRadioItem5.setConstraints(VRLayout.FLOW);

      addServiceAddProvisionStructuralRadioItem5();
    }
    return serviceAddProvisionStructuralRadioItem5;

  }

  /**
   * II�^���擾���܂��B
   * @return II�^
   */
  public ACRadioButtonItem getServiceAddProvisionStructuralRadioItem3(){
    if(serviceAddProvisionStructuralRadioItem3==null){

      serviceAddProvisionStructuralRadioItem3 = new ACRadioButtonItem();

      serviceAddProvisionStructuralRadioItem3.setText("II�^");

      serviceAddProvisionStructuralRadioItem3.setGroup(getServiceAddProvisionStructuralRadioGroup());

      serviceAddProvisionStructuralRadioItem3.setConstraints(VRLayout.FLOW);

      addServiceAddProvisionStructuralRadioItem3();
    }
    return serviceAddProvisionStructuralRadioItem3;

  }

  /**
   * III�^���擾���܂��B
   * @return III�^
   */
  public ACRadioButtonItem getServiceAddProvisionStructuralRadioItem4(){
    if(serviceAddProvisionStructuralRadioItem4==null){

      serviceAddProvisionStructuralRadioItem4 = new ACRadioButtonItem();

      serviceAddProvisionStructuralRadioItem4.setText("III�^");

      serviceAddProvisionStructuralRadioItem4.setGroup(getServiceAddProvisionStructuralRadioGroup());

      serviceAddProvisionStructuralRadioItem4.setConstraints(VRLayout.FLOW);

      addServiceAddProvisionStructuralRadioItem4();
    }
    return serviceAddProvisionStructuralRadioItem4;

  }

  /**
   * ���R�Ԓn�擙�ł̃T�[�r�X�񋟉��Z���擾���܂��B
   * @return ���R�Ԓn�擙�ł̃T�[�r�X�񋟉��Z
   */
  public ACValueArrayRadioButtonGroup getProviderAddMountainousAreaRafioRadioGroup(){
    if(providerAddMountainousAreaRafioRadioGroup==null){

      providerAddMountainousAreaRafioRadioGroup = new ACValueArrayRadioButtonGroup();

      getProviderAddMountainousAreaRafioRadioGroupContainer().setText("���R�Ԓn�擙�ł̃T�[�r�X�񋟉��Z");

      providerAddMountainousAreaRafioRadioGroup.setBindPath("12");

      providerAddMountainousAreaRafioRadioGroup.setNoSelectIndex(0);

      providerAddMountainousAreaRafioRadioGroup.setUseClearButton(false);

      providerAddMountainousAreaRafioRadioGroup.setModel(getProviderAddMountainousAreaRafioRadioGroupModel());

      providerAddMountainousAreaRafioRadioGroup.setValues(new int[]{1,2});

      addProviderAddMountainousAreaRafioRadioGroup();
    }
    return providerAddMountainousAreaRafioRadioGroup;

  }

  /**
   * ���R�Ԓn�擙�ł̃T�[�r�X�񋟉��Z�R���e�i���擾���܂��B
   * @return ���R�Ԓn�擙�ł̃T�[�r�X�񋟉��Z�R���e�i
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
   * ���R�Ԓn�擙�ł̃T�[�r�X�񋟉��Z���f�����擾���܂��B
   * @return ���R�Ԓn�擙�ł̃T�[�r�X�񋟉��Z���f��
   */
  protected ACListModelAdapter getProviderAddMountainousAreaRafioRadioGroupModel(){
    if(providerAddMountainousAreaRafioRadioGroupModel==null){
      providerAddMountainousAreaRafioRadioGroupModel = new ACListModelAdapter();
      addProviderAddMountainousAreaRafioRadioGroupModel();
    }
    return providerAddMountainousAreaRafioRadioGroupModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getProviderAddMountainousAreaRafioItem1(){
    if(providerAddMountainousAreaRafioItem1==null){

      providerAddMountainousAreaRafioItem1 = new ACRadioButtonItem();

      providerAddMountainousAreaRafioItem1.setText("�Ȃ�");

      providerAddMountainousAreaRafioItem1.setGroup(getProviderAddMountainousAreaRafioRadioGroup());

      providerAddMountainousAreaRafioItem1.setConstraints(VRLayout.FLOW);

      addProviderAddMountainousAreaRafioItem1();
    }
    return providerAddMountainousAreaRafioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getProviderAddMountainousAreaRafioRadioItem2(){
    if(providerAddMountainousAreaRafioRadioItem2==null){

      providerAddMountainousAreaRafioRadioItem2 = new ACRadioButtonItem();

      providerAddMountainousAreaRafioRadioItem2.setText("����");

      providerAddMountainousAreaRafioRadioItem2.setGroup(getProviderAddMountainousAreaRafioRadioGroup());

      providerAddMountainousAreaRafioRadioItem2.setConstraints(VRLayout.FLOW);

      addProviderAddMountainousAreaRafioRadioItem2();
    }
    return providerAddMountainousAreaRafioRadioItem2;

  }

  /**
   * �������s�����Ǝ����Z���擾���܂��B
   * @return �������s�����Ǝ����Z
   */
  public ACComboBox getServiceMunicipalityAdd(){
    if(serviceMunicipalityAdd==null){

      serviceMunicipalityAdd = new ACComboBox();

      getServiceMunicipalityAddContainer().setText("�������s�����Ǝ����Z");

      serviceMunicipalityAdd.setBindPath("1760109");

      serviceMunicipalityAdd.setEditable(false);

      serviceMunicipalityAdd.setModelBindPath("1760109");

      serviceMunicipalityAdd.setRenderBindPath("CONTENT");

      serviceMunicipalityAdd.setBlankable(false);

      serviceMunicipalityAdd.setModel(getServiceMunicipalityAddModel());

      addServiceMunicipalityAdd();
    }
    return serviceMunicipalityAdd;

  }

  /**
   * �������s�����Ǝ����Z�R���e�i���擾���܂��B
   * @return �������s�����Ǝ����Z�R���e�i
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
   * �������s�����Ǝ����Z���f�����擾���܂��B
   * @return �������s�����Ǝ����Z���f��
   */
  protected ACComboBoxModelAdapter getServiceMunicipalityAddModel(){
    if(serviceMunicipalityAddModel==null){
      serviceMunicipalityAddModel = new ACComboBoxModelAdapter();
      addServiceMunicipalityAddModel();
    }
    return serviceMunicipalityAddModel;
  }

  /**
   * �ʏ����p���Z���擾���܂��B
   * @return �ʏ����p���Z
   */
  public ACValueArrayRadioButtonGroup getDayCareUseSubtractionRadioGroup(){
    if(dayCareUseSubtractionRadioGroup==null){

      dayCareUseSubtractionRadioGroup = new ACValueArrayRadioButtonGroup();

      getDayCareUseSubtractionRadioGroupContainer().setText("�ʏ����p���Z");

      dayCareUseSubtractionRadioGroup.setBindPath("1760110");

      dayCareUseSubtractionRadioGroup.setUseClearButton(false);

      dayCareUseSubtractionRadioGroup.setModel(getDayCareUseSubtractionRadioGroupModel());

      dayCareUseSubtractionRadioGroup.setValues(new int[]{1,2});

      addDayCareUseSubtractionRadioGroup();
    }
    return dayCareUseSubtractionRadioGroup;

  }

  /**
   * �ʏ����p���Z�R���e�i���擾���܂��B
   * @return �ʏ����p���Z�R���e�i
   */
  protected ACLabelContainer getDayCareUseSubtractionRadioGroupContainer(){
    if(dayCareUseSubtractionRadioGroupContainer==null){
      dayCareUseSubtractionRadioGroupContainer = new ACLabelContainer();
      dayCareUseSubtractionRadioGroupContainer.setFollowChildEnabled(true);
      dayCareUseSubtractionRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      dayCareUseSubtractionRadioGroupContainer.add(getDayCareUseSubtractionRadioGroup(), null);
    }
    return dayCareUseSubtractionRadioGroupContainer;
  }

  /**
   * �ʏ����p���Z���f�����擾���܂��B
   * @return �ʏ����p���Z���f��
   */
  protected ACListModelAdapter getDayCareUseSubtractionRadioGroupModel(){
    if(dayCareUseSubtractionRadioGroupModel==null){
      dayCareUseSubtractionRadioGroupModel = new ACListModelAdapter();
      addDayCareUseSubtractionRadioGroupModel();
    }
    return dayCareUseSubtractionRadioGroupModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getDayCareUseSubtractionRadioItem1(){
    if(dayCareUseSubtractionRadioItem1==null){

      dayCareUseSubtractionRadioItem1 = new ACRadioButtonItem();

      dayCareUseSubtractionRadioItem1.setText("�Ȃ�");

      dayCareUseSubtractionRadioItem1.setGroup(getDayCareUseSubtractionRadioGroup());

      dayCareUseSubtractionRadioItem1.setConstraints(VRLayout.FLOW);

      addDayCareUseSubtractionRadioItem1();
    }
    return dayCareUseSubtractionRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getDayCareUseSubtractionRadioItem2(){
    if(dayCareUseSubtractionRadioItem2==null){

      dayCareUseSubtractionRadioItem2 = new ACRadioButtonItem();

      dayCareUseSubtractionRadioItem2.setText("����");

      dayCareUseSubtractionRadioItem2.setGroup(getDayCareUseSubtractionRadioGroup());

      dayCareUseSubtractionRadioItem2.setConstraints(VRLayout.FLOW);

      addDayCareUseSubtractionRadioItem2();
    }
    return dayCareUseSubtractionRadioItem2;

  }

  /**
   * �Z��敪���擾���܂��B
   * @return �Z��敪
   */
  public ACValueArrayRadioButtonGroup getCalculationDivision(){
    if(calculationDivision==null){

      calculationDivision = new ACValueArrayRadioButtonGroup();

      getCalculationDivisionContainer().setText("�Z��敪");

      calculationDivision.setBindPath("9");

      calculationDivision.setUseClearButton(false);

      calculationDivision.setModel(getCalculationDivisionModel());

      calculationDivision.setValues(new int[]{1,2});

      addCalculationDivision();
    }
    return calculationDivision;

  }

  /**
   * �Z��敪�R���e�i���擾���܂��B
   * @return �Z��敪�R���e�i
   */
  protected ACLabelContainer getCalculationDivisionContainer(){
    if(calculationDivisionContainer==null){
      calculationDivisionContainer = new ACLabelContainer();
      calculationDivisionContainer.setFollowChildEnabled(true);
      calculationDivisionContainer.setVAlignment(VRLayout.CENTER);
      calculationDivisionContainer.add(getCalculationDivision(), null);
    }
    return calculationDivisionContainer;
  }

  /**
   * �Z��敪���f�����擾���܂��B
   * @return �Z��敪���f��
   */
  protected ACListModelAdapter getCalculationDivisionModel(){
    if(calculationDivisionModel==null){
      calculationDivisionModel = new ACListModelAdapter();
      addCalculationDivisionModel();
    }
    return calculationDivisionModel;
  }

  /**
   * �ʏ���擾���܂��B
   * @return �ʏ�
   */
  public ACRadioButtonItem getCalculationDivisionNormal(){
    if(calculationDivisionNormal==null){

      calculationDivisionNormal = new ACRadioButtonItem();

      calculationDivisionNormal.setText("�ʏ�");

      calculationDivisionNormal.setGroup(getCalculationDivision());

      calculationDivisionNormal.setConstraints(VRLayout.FLOW);

      addCalculationDivisionNormal();
    }
    return calculationDivisionNormal;

  }

  /**
   * ���Z�݂̂��擾���܂��B
   * @return ���Z�̂�
   */
  public ACRadioButtonItem getCalculationDivisionAddOnly(){
    if(calculationDivisionAddOnly==null){

      calculationDivisionAddOnly = new ACRadioButtonItem();

      calculationDivisionAddOnly.setText("���Z�̂�");

      calculationDivisionAddOnly.setGroup(getCalculationDivision());

      calculationDivisionAddOnly.setConstraints(VRLayout.FLOW);

      addCalculationDivisionAddOnly();
    }
    return calculationDivisionAddOnly;

  }

  /**
   * �������擾���܂��B
   * @return ����
   */
  public ACIntegerCheckBox getCrackOnDayCheck(){
    if(crackOnDayCheck==null){

      crackOnDayCheck = new ACIntegerCheckBox();

      crackOnDayCheck.setText("����");

      crackOnDayCheck.setBindPath("1760111");

      crackOnDayCheck.setSelectValue(2);

      crackOnDayCheck.setUnSelectValue(1);

      addCrackOnDayCheck();
    }
    return crackOnDayCheck;

  }

  /**
   * �񋟓����擾���܂��B
   * @return �񋟓�
   */
  public ACIntegerCheckBox getPrintable(){
    if(printable==null){

      printable = new ACIntegerCheckBox();

      printable.setText("�񋟓�");

      printable.setBindPath("15");

      printable.setSelectValue(2);

      printable.setUnSelectValue(1);

      addPrintable();
    }
    return printable;

  }

  /**
   * �񋟎��ԃR���e�i���擾���܂��B
   * @return �񋟎��ԃR���e�i
   */
  public ACBackLabelContainer getHomonNyuyokuTimeContainer(){
    if(homonNyuyokuTimeContainer==null){

      homonNyuyokuTimeContainer = new ACBackLabelContainer();

      homonNyuyokuTimeContainer.setFollowChildEnabled(true);

      addHomonNyuyokuTimeContainer();
    }
    return homonNyuyokuTimeContainer;

  }

  /**
   * �J�n�����R���{���擾���܂��B
   * @return �J�n�����R���{
   */
  public ACTimeComboBox getHomonNyuyokuBeginTime(){
    if(homonNyuyokuBeginTime==null){

      homonNyuyokuBeginTime = new ACTimeComboBox();

      getHomonNyuyokuBeginTimeContainer().setText("�J�n����");

      homonNyuyokuBeginTime.setBindPath("3");

      homonNyuyokuBeginTime.setModelBindPath("3");

      homonNyuyokuBeginTime.setRenderBindPath("CONTENT");

      homonNyuyokuBeginTime.setModel(getHomonNyuyokuBeginTimeModel());

      addHomonNyuyokuBeginTime();
    }
    return homonNyuyokuBeginTime;

  }

  /**
   * �J�n�����R���{�R���e�i���擾���܂��B
   * @return �J�n�����R���{�R���e�i
   */
  protected ACLabelContainer getHomonNyuyokuBeginTimeContainer(){
    if(homonNyuyokuBeginTimeContainer==null){
      homonNyuyokuBeginTimeContainer = new ACLabelContainer();
      homonNyuyokuBeginTimeContainer.setFollowChildEnabled(true);
      homonNyuyokuBeginTimeContainer.setVAlignment(VRLayout.CENTER);
      homonNyuyokuBeginTimeContainer.add(getHomonNyuyokuBeginTime(), null);
    }
    return homonNyuyokuBeginTimeContainer;
  }

  /**
   * �J�n�����R���{���f�����擾���܂��B
   * @return �J�n�����R���{���f��
   */
  protected ACComboBoxModelAdapter getHomonNyuyokuBeginTimeModel(){
    if(homonNyuyokuBeginTimeModel==null){
      homonNyuyokuBeginTimeModel = new ACComboBoxModelAdapter();
      addHomonNyuyokuBeginTimeModel();
    }
    return homonNyuyokuBeginTimeModel;
  }

  /**
   * �I�������R���{���擾���܂��B
   * @return �I�������R���{
   */
  public ACTimeComboBox getHomonNyuyokuEndTime(){
    if(homonNyuyokuEndTime==null){

      homonNyuyokuEndTime = new ACTimeComboBox();

      getHomonNyuyokuEndTimeContainer().setText("�I������");

      homonNyuyokuEndTime.setBindPath("4");

      homonNyuyokuEndTime.setModelBindPath("4");

      homonNyuyokuEndTime.setRenderBindPath("CONTENT");

      homonNyuyokuEndTime.setModel(getHomonNyuyokuEndTimeModel());

      addHomonNyuyokuEndTime();
    }
    return homonNyuyokuEndTime;

  }

  /**
   * �I�������R���{�R���e�i���擾���܂��B
   * @return �I�������R���{�R���e�i
   */
  protected ACLabelContainer getHomonNyuyokuEndTimeContainer(){
    if(homonNyuyokuEndTimeContainer==null){
      homonNyuyokuEndTimeContainer = new ACLabelContainer();
      homonNyuyokuEndTimeContainer.setFollowChildEnabled(true);
      homonNyuyokuEndTimeContainer.setVAlignment(VRLayout.CENTER);
      homonNyuyokuEndTimeContainer.add(getHomonNyuyokuEndTime(), null);
    }
    return homonNyuyokuEndTimeContainer;
  }

  /**
   * �I�������R���{���f�����擾���܂��B
   * @return �I�������R���{���f��
   */
  protected ACComboBoxModelAdapter getHomonNyuyokuEndTimeModel(){
    if(homonNyuyokuEndTimeModel==null){
      homonNyuyokuEndTimeModel = new ACComboBoxModelAdapter();
      addHomonNyuyokuEndTimeModel();
    }
    return homonNyuyokuEndTimeModel;
  }

  /**
   * ���ꌚ�����Z�҂ւ̃T�[�r�X�񋟂��擾���܂��B
   * @return ���ꌚ�����Z�҂ւ̃T�[�r�X��
   */
  public ACValueArrayRadioButtonGroup getSameBuildingRadioGroup(){
    if(sameBuildingRadioGroup==null){

      sameBuildingRadioGroup = new ACValueArrayRadioButtonGroup();

      getSameBuildingRadioGroupContainer().setText("���ꌚ�����Z�҂ւ̃T�[�r�X��");

      sameBuildingRadioGroup.setBindPath("16");

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
   * ���ꌚ�����Z�҂ւ̃T�[�r�X�񋟃R���e�i���擾���܂��B
   * @return ���ꌚ�����Z�҂ւ̃T�[�r�X�񋟃R���e�i
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
   * ���ꌚ�����Z�҂ւ̃T�[�r�X�񋟃��f�����擾���܂��B
   * @return ���ꌚ�����Z�҂ւ̃T�[�r�X�񋟃��f��
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
   * �����}�l�W�����g�̐��������Z���擾���܂��B
   * @return �����}�l�W�����g�̐��������Z
   */
  public ACValueArrayRadioButtonGroup getComprehensiveManagementSystemRadioGroup(){
    if(comprehensiveManagementSystemRadioGroup==null){

      comprehensiveManagementSystemRadioGroup = new ACValueArrayRadioButtonGroup();

      getComprehensiveManagementSystemRadioGroupContainer().setText("�����}�l�W�����g�̐��������Z");

      comprehensiveManagementSystemRadioGroup.setBindPath("1760112");

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
   * �R���X�g���N�^�ł��B
   */
  public QS001_17611_201504Design() {

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

    this.add(getTabs(), VRLayout.CLIENT);

  }

  /**
   * �^�u�y�C���ɓ������ڂ�ǉ����܂��B
   */
  protected void addTabs(){

    tabs.addTab("1", getTab1());

    tabs.addTab("2", getTab2());

  }

  /**
   * �^�u1�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTab1(){

    tab1.add(getDivisionRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getSijishoOfferRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getNurseStaffDivisionRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getInitialAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getEmergencyVisitRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getSpecialManagementRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getLeaveConcernContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getTerminalCareRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * �T�[�r�X�񋟂ɓ������ڂ�ǉ����܂��B
   */
  protected void addDivisionRadioGroup(){

  }

  /**
   * �T�[�r�X�񋟃��f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addDivisionRadioGroupModel(){

    getDivisionRadioItem1().setButtonIndex(1);

    getDivisionRadioGroupModel().add(getDivisionRadioItem1());

    getDivisionRadioItem2().setButtonIndex(2);

    getDivisionRadioGroupModel().add(getDivisionRadioItem2());

  }

  /**
   * ��̌^�������ɓ������ڂ�ǉ����܂��B
   */
  protected void addDivisionRadioItem1(){

  }

  /**
   * �A�g�^�������ɓ������ڂ�ǉ����܂��B
   */
  protected void addDivisionRadioItem2(){

  }

  /**
   * �K��Ō�T�[�r�X�̒񋟂ɓ������ڂ�ǉ����܂��B
   */
  protected void addSijishoOfferRadioGroup(){

  }

  /**
   * �K��Ō�T�[�r�X�̒񋟃��f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addSijishoOfferRadioGroupModel(){

    getSijishoOfferRadioItem1().setButtonIndex(1);

    getSijishoOfferRadioGroupModel().add(getSijishoOfferRadioItem1());

    getSijishoOfferRadioItem2().setButtonIndex(2);

    getSijishoOfferRadioGroupModel().add(getSijishoOfferRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addSijishoOfferRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addSijishoOfferRadioItem2(){

  }

  /**
   * �Ō�E���敪�ɓ������ڂ�ǉ����܂��B
   */
  protected void addNurseStaffDivisionRadioGroup(){

  }

  /**
   * �Ō�E���敪���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addNurseStaffDivisionRadioGroupModel(){

    getNurseStaffDivisionRadioItem1().setButtonIndex(1);

    getNurseStaffDivisionRadioGroupModel().add(getNurseStaffDivisionRadioItem1());

    getNurseStaffDivisionRadioItem2().setButtonIndex(2);

    getNurseStaffDivisionRadioGroupModel().add(getNurseStaffDivisionRadioItem2());

  }

  /**
   * ���œ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addNurseStaffDivisionRadioItem1(){

  }

  /**
   * �y�łɓ������ڂ�ǉ����܂��B
   */
  protected void addNurseStaffDivisionRadioItem2(){

  }

  /**
   * �������Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addInitialAddRadioGroup(){

  }

  /**
   * �������Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addInitialAddRadioGroupModel(){

    getInitialAddRadioItem1().setButtonIndex(1);

    getInitialAddRadioGroupModel().add(getInitialAddRadioItem1());

    getInitialAddRadioItem2().setButtonIndex(2);

    getInitialAddRadioGroupModel().add(getInitialAddRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addInitialAddRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addInitialAddRadioItem2(){

  }

  /**
   * �ً}���K��Ō���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addEmergencyVisitRadioGroup(){

  }

  /**
   * �ً}���K��Ō���Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addEmergencyVisitRadioGroupModel(){

    getEmergencyVisitRadioItem1().setButtonIndex(1);

    getEmergencyVisitRadioGroupModel().add(getEmergencyVisitRadioItem1());

    getEmergencyVisitRadioItem2().setButtonIndex(2);

    getEmergencyVisitRadioGroupModel().add(getEmergencyVisitRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addEmergencyVisitRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addEmergencyVisitRadioItem2(){

  }

  /**
   * ���ʊǗ����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addSpecialManagementRadioGroup(){

  }

  /**
   * ���ʊǗ����Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addSpecialManagementRadioGroupModel(){

    getSpecialManagementRadioItem1().setButtonIndex(1);

    getSpecialManagementRadioGroupModel().add(getSpecialManagementRadioItem1());

    getSpecialManagementRadioItem2().setButtonIndex(2);

    getSpecialManagementRadioGroupModel().add(getSpecialManagementRadioItem2());

    getSpecialManagementRadioItem3().setButtonIndex(3);

    getSpecialManagementRadioGroupModel().add(getSpecialManagementRadioItem3());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addSpecialManagementRadioItem1(){

  }

  /**
   * I�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addSpecialManagementRadioItem2(){

  }

  /**
   * II�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addSpecialManagementRadioItem3(){

  }

  /**
   * �ޏ��֘A���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addLeaveConcernContainer(){

    leaveConcernContainer.add(getLeaveAfterVisitCheck(), VRLayout.FLOW_RETURN);

  }

  /**
   * �މ@�������w�����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addLeaveAfterVisitCheck(){

  }

  /**
   * �^�[�~�i���P�A���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTerminalCareRadioGroup(){

  }

  /**
   * �^�[�~�i���P�A���Z���f���ɓ������ڂ�ǉ����܂��B
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
   * �^�u2�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTab2(){

    tab2.add(getServiceAddProvisionStructuralRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getProviderAddMountainousAreaRafioRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getServiceMunicipalityAddContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getDayCareUseSubtractionRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getCalculationDivisionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getCrackOnDayCheck(), VRLayout.FLOW);

    tab2.add(getPrintable(), VRLayout.FLOW_RETURN);

    tab2.add(getHomonNyuyokuTimeContainer(), VRLayout.FLOW_DOUBLEINSETLINE_RETURN);

    tab2.add(getSameBuildingRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getComprehensiveManagementSystemRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

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

    getServiceAddProvisionStructuralRadioItem5().setButtonIndex(2);

    getServiceAddProvisionStructuralRadioGroupModel().add(getServiceAddProvisionStructuralRadioItem5());

    getServiceAddProvisionStructuralRadioItem3().setButtonIndex(3);

    getServiceAddProvisionStructuralRadioGroupModel().add(getServiceAddProvisionStructuralRadioItem3());

    getServiceAddProvisionStructuralRadioItem4().setButtonIndex(4);

    getServiceAddProvisionStructuralRadioGroupModel().add(getServiceAddProvisionStructuralRadioItem4());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceAddProvisionStructuralRadioItem1(){

  }

  /**
   * I�C�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceAddProvisionStructuralRadioItem2(){

  }

  /**
   * I���^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceAddProvisionStructuralRadioItem5(){

  }

  /**
   * II�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceAddProvisionStructuralRadioItem3(){

  }

  /**
   * III�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceAddProvisionStructuralRadioItem4(){

  }

  /**
   * ���R�Ԓn�擙�ł̃T�[�r�X�񋟉��Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderAddMountainousAreaRafioRadioGroup(){

  }

  /**
   * ���R�Ԓn�擙�ł̃T�[�r�X�񋟉��Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderAddMountainousAreaRafioRadioGroupModel(){

    getProviderAddMountainousAreaRafioItem1().setButtonIndex(1);

    getProviderAddMountainousAreaRafioRadioGroupModel().add(getProviderAddMountainousAreaRafioItem1());

    getProviderAddMountainousAreaRafioRadioItem2().setButtonIndex(2);

    getProviderAddMountainousAreaRafioRadioGroupModel().add(getProviderAddMountainousAreaRafioRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderAddMountainousAreaRafioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderAddMountainousAreaRafioRadioItem2(){

  }

  /**
   * �������s�����Ǝ����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceMunicipalityAdd(){

  }

  /**
   * �������s�����Ǝ����Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceMunicipalityAddModel(){

  }

  /**
   * �ʏ����p���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addDayCareUseSubtractionRadioGroup(){

  }

  /**
   * �ʏ����p���Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addDayCareUseSubtractionRadioGroupModel(){

    getDayCareUseSubtractionRadioItem1().setButtonIndex(1);

    getDayCareUseSubtractionRadioGroupModel().add(getDayCareUseSubtractionRadioItem1());

    getDayCareUseSubtractionRadioItem2().setButtonIndex(2);

    getDayCareUseSubtractionRadioGroupModel().add(getDayCareUseSubtractionRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addDayCareUseSubtractionRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addDayCareUseSubtractionRadioItem2(){

  }

  /**
   * �Z��敪�ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalculationDivision(){

  }

  /**
   * �Z��敪���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalculationDivisionModel(){

    getCalculationDivisionNormal().setButtonIndex(1);

    getCalculationDivisionModel().add(getCalculationDivisionNormal());

    getCalculationDivisionAddOnly().setButtonIndex(2);

    getCalculationDivisionModel().add(getCalculationDivisionAddOnly());

  }

  /**
   * �ʏ�ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalculationDivisionNormal(){

  }

  /**
   * ���Z�݂̂ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalculationDivisionAddOnly(){

  }

  /**
   * �����ɓ������ڂ�ǉ����܂��B
   */
  protected void addCrackOnDayCheck(){

  }

  /**
   * �񋟓��ɓ������ڂ�ǉ����܂��B
   */
  protected void addPrintable(){

  }

  /**
   * �񋟎��ԃR���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHomonNyuyokuTimeContainer(){

    homonNyuyokuTimeContainer.add(getHomonNyuyokuBeginTimeContainer(), VRLayout.FLOW);

    homonNyuyokuTimeContainer.add(getHomonNyuyokuEndTimeContainer(), VRLayout.FLOW);

  }

  /**
   * �J�n�����R���{�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHomonNyuyokuBeginTime(){

  }

  /**
   * �J�n�����R���{���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addHomonNyuyokuBeginTimeModel(){

  }

  /**
   * �I�������R���{�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHomonNyuyokuEndTime(){

  }

  /**
   * �I�������R���{���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addHomonNyuyokuEndTimeModel(){

  }

  /**
   * ���ꌚ�����Z�҂ւ̃T�[�r�X�񋟂ɓ������ڂ�ǉ����܂��B
   */
  protected void addSameBuildingRadioGroup(){

  }

  /**
   * ���ꌚ�����Z�҂ւ̃T�[�r�X�񋟃��f���ɓ������ڂ�ǉ����܂��B
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
      ACFrame.debugStart(new ACAffairInfo(QS001_17611_201504Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QS001_17611_201504Design getThis() {
    return this;
  }
}
