
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
 * �쐬��: 2018/04/20  ���{�R���s���[�^�[������� ����@��F �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �T�[�r�X�\��쐬/�ύX (S)
 * �v���Z�X �T�[�r�X�\��T�� (001)
 * �v���O���� �T�[�r�X�p�^�[�����K�͑��@�\�^��� (QS001_17311_201804)
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
 * �T�[�r�X�p�^�[�����K�͑��@�\�^����ʍ��ڃf�U�C��(QS001_17311_201804) 
 */
public class QS001_17311_201804Design extends QS001ServicePanel {
  //GUI�R���|�[�l���g

  private ACPanel regionSmallscaleMultiPatterns;

  private JTabbedPane tabs;

  private ACPanel tab1;

  private ACValueArrayRadioButtonGroup initialAddRadio;

  private ACLabelContainer initialAddRadioContainer;

  private ACListModelAdapter initialAddRadioModel;

  private ACRadioButtonItem initialAddRadioItem1;

  private ACRadioButtonItem initialAddRadioItem2;

  private ACValueArrayRadioButtonGroup smallServiceRadio;

  private ACLabelContainer smallServiceRadioContainer;

  private ACListModelAdapter smallServiceRadioModel;

  private ACRadioButtonItem smallServiceRadioItem1;

  private ACRadioButtonItem smallServiceRadioItem2;

  private ACValueArrayRadioButtonGroup staffSubtractionRadio;

  private ACLabelContainer staffSubtractionRadioContainer;

  private ACListModelAdapter staffSubtractionRadioModel;

  private ACRadioButtonItem staffSubtractionRadioItem1;

  private ACRadioButtonItem staffSubtractionRadioItem2;

  private ACRadioButtonItem staffSubtractionRadioItem3;

  private ACValueArrayRadioButtonGroup dementiaAddRadioGroup;

  private ACLabelContainer dementiaAddRadioGroupContainer;

  private ACListModelAdapter dementiaAddRadioGroupModel;

  private ACRadioButtonItem dementiaAddRadioItem1;

  private ACRadioButtonItem dementiaAddRadioItem2;

  private ACRadioButtonItem dementiaAddRadioItem3;

  private ACValueArrayRadioButtonGroup nurseStaffDispositionAddRadioGroup;

  private ACLabelContainer nurseStaffDispositionAddRadioGroupContainer;

  private ACListModelAdapter nurseStaffDispositionAddRadioGroupModel;

  private ACRadioButtonItem nurseStaffDispositionAddRadioItem1;

  private ACRadioButtonItem nurseStaffDispositionAddRadioItem2;

  private ACRadioButtonItem nurseStaffDispositionAddRadioItem3;

  private ACRadioButtonItem nurseStaffDispositionAddRadioItem4;

  private ACValueArrayRadioButtonGroup houmonNeededRadio;

  private ACLabelContainer houmonNeededRadioContainer;

  private ACListModelAdapter houmonNeededRadioModel;

  private ACRadioButtonItem houmonNeededRadioItem1;

  private ACRadioButtonItem houmonNeededRadioItem2;

  private ACValueArrayRadioButtonGroup serviceAddProvisionStructuralRadioGroup;

  private ACLabelContainer serviceAddProvisionStructuralRadioGroupContainer;

  private ACListModelAdapter serviceAddProvisionStructuralRadioGroupModel;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem1;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem5;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem2;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem3;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem4;

  private ACComboBox municipalityAdd;

  private ACLabelContainer municipalityAddContainer;

  private ACComboBoxModelAdapter municipalityAddModel;

  private ACPanel tab2;

  private ACValueArrayRadioButtonGroup providerAddMountainousAreaRafioRadioGroup;

  private ACLabelContainer providerAddMountainousAreaRafioRadioGroupContainer;

  private ACListModelAdapter providerAddMountainousAreaRafioRadioGroupModel;

  private ACRadioButtonItem providerAddMountainousAreaRafioItem1;

  private ACRadioButtonItem providerAddMountainousAreaRafioRadioItem2;

  private ACValueArrayRadioButtonGroup terminalCareInformationRadioGroup;

  private ACLabelContainer terminalCareInformationRadioGroupContainer;

  private ACListModelAdapter terminalCareInformationRadioGroupModel;

  private ACRadioButtonItem terminalCareInformationRadioItem1;

  private ACRadioButtonItem terminalCareInformationRadioItem2;

  private ACLabelContainer terminalCareInformationAddDaysContainer;

  private ACTextField terminalCareInformationAddDays;

  private ACLabel terminalCareInformationAddDaysUnit;

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

  private ACValueArrayRadioButtonGroup youngDementiaPatinetAddRadioGroup;

  private ACLabelContainer youngDementiaPatinetAddRadioGroupContainer;

  private ACListModelAdapter youngDementiaPatinetAddRadioGroupModel;

  private ACRadioButtonItem youngDementiaPatinetAddRadioItem1;

  private ACRadioButtonItem youngDementiaPatinetAddRadioItem2;

  private ACValueArrayRadioButtonGroup rehabilitationSpecialistPersonnelCooperationRadioGroup;

  private ACLabelContainer rehabilitationSpecialistPersonnelCooperationRadioGroupContainer;

  private ACListModelAdapter rehabilitationSpecialistPersonnelCooperationRadioGroupModel;

  private ACRadioButtonItem rehabilitationSpecialistPersonnelCooperationItem1;

  private ACRadioButtonItem rehabilitationSpecialistPersonnelCooperationItem2;

  private ACRadioButtonItem rehabilitationSpecialistPersonnelCooperationItem3;

  private ACValueArrayRadioButtonGroup nutritionScreening;

  private ACLabelContainer nutritionScreeningContainer;

  private ACListModelAdapter nutritionScreeningModel;

  private ACRadioButtonItem nutritionScreeningItem1;

  private ACRadioButtonItem nutritionScreeningItem2;

  private ACValueArrayRadioButtonGroup calculationDivision;

  private ACLabelContainer calculationDivisionContainer;

  private ACListModelAdapter calculationDivisionModel;

  private ACRadioButtonItem calculationDivisionItem1;

  private ACRadioButtonItem calculationDivisionItem2;

  private ACPanel tab3;

  private ACIntegerCheckBox crackOnDayCheck;

  private ACIntegerCheckBox printable;

  private ACGroupBox infoGroup;

  private ACLabel infoLabel;

  private ACGroupBox kaigoSupportSpecialMemberContainer;

  private ACTextField kaigoSupportSpecialMemberNumber;

  private ACLabelContainer kaigoSupportSpecialMemberNumberContainer;

  private ACComboBox kaigoSupportSpecialMemberName;

  private ACLabelContainer kaigoSupportSpecialMemberNameContainer;

  private ACComboBoxModelAdapter kaigoSupportSpecialMemberNameModel;

  private ACGroupBox tekiyouGroup;

  private ACTextField tekiyouText;

  private ACLabelContainer tekiyouTextContainer;

  private ACLabel tekiyouCommentTitle;

  //getter

  /**
   * �n�斧�����K�͑��@�\�^���p�^�[���̈���擾���܂��B
   * @return �n�斧�����K�͑��@�\�^���p�^�[���̈�
   */
  public ACPanel getRegionSmallscaleMultiPatterns(){
    if(regionSmallscaleMultiPatterns==null){

      regionSmallscaleMultiPatterns = new ACPanel();

      regionSmallscaleMultiPatterns.setAutoWrap(false);

      regionSmallscaleMultiPatterns.setFollowChildEnabled(true);

      regionSmallscaleMultiPatterns.setHgrid(200);

      addRegionSmallscaleMultiPatterns();
    }
    return regionSmallscaleMultiPatterns;

  }

  /**
   * �^�u�p�l�����擾���܂��B
   * @return �^�u�p�l��
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

      tab1.setLabelMargin(0);

      tab1.setVgap(0);

      addTab1();
    }
    return tab1;

  }

  /**
   * �������Z���擾���܂��B
   * @return �������Z
   */
  public ACValueArrayRadioButtonGroup getInitialAddRadio(){
    if(initialAddRadio==null){

      initialAddRadio = new ACValueArrayRadioButtonGroup();

      getInitialAddRadioContainer().setText("�������Z");

      initialAddRadio.setBindPath("1730101");

      initialAddRadio.setUseClearButton(false);

      initialAddRadio.setModel(getInitialAddRadioModel());

      initialAddRadio.setValues(new int[]{1,2});

      addInitialAddRadio();
    }
    return initialAddRadio;

  }

  /**
   * �������Z�R���e�i���擾���܂��B
   * @return �������Z�R���e�i
   */
  protected ACLabelContainer getInitialAddRadioContainer(){
    if(initialAddRadioContainer==null){
      initialAddRadioContainer = new ACLabelContainer();
      initialAddRadioContainer.setFollowChildEnabled(true);
      initialAddRadioContainer.setVAlignment(VRLayout.CENTER);
      initialAddRadioContainer.add(getInitialAddRadio(), null);
    }
    return initialAddRadioContainer;
  }

  /**
   * �������Z���f�����擾���܂��B
   * @return �������Z���f��
   */
  protected ACListModelAdapter getInitialAddRadioModel(){
    if(initialAddRadioModel==null){
      initialAddRadioModel = new ACListModelAdapter();
      addInitialAddRadioModel();
    }
    return initialAddRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getInitialAddRadioItem1(){
    if(initialAddRadioItem1==null){

      initialAddRadioItem1 = new ACRadioButtonItem();

      initialAddRadioItem1.setText("�Ȃ�");

      initialAddRadioItem1.setGroup(getInitialAddRadio());

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

      initialAddRadioItem2.setGroup(getInitialAddRadio());

      initialAddRadioItem2.setConstraints(VRLayout.FLOW);

      addInitialAddRadioItem2();
    }
    return initialAddRadioItem2;

  }

  /**
   * �ߏ��T�[�r�X�ɑ΂��錸�Z���擾���܂��B
   * @return �ߏ��T�[�r�X�ɑ΂��錸�Z
   */
  public ACValueArrayRadioButtonGroup getSmallServiceRadio(){
    if(smallServiceRadio==null){

      smallServiceRadio = new ACValueArrayRadioButtonGroup();

      getSmallServiceRadioContainer().setText("�ߏ��T�[�r�X�ɑ΂��錸�Z");

      smallServiceRadio.setBindPath("1730106");

      smallServiceRadio.setNoSelectIndex(0);

      smallServiceRadio.setUseClearButton(false);

      smallServiceRadio.setModel(getSmallServiceRadioModel());

      smallServiceRadio.setValues(new int[]{1,2});

      addSmallServiceRadio();
    }
    return smallServiceRadio;

  }

  /**
   * �ߏ��T�[�r�X�ɑ΂��錸�Z�R���e�i���擾���܂��B
   * @return �ߏ��T�[�r�X�ɑ΂��錸�Z�R���e�i
   */
  protected ACLabelContainer getSmallServiceRadioContainer(){
    if(smallServiceRadioContainer==null){
      smallServiceRadioContainer = new ACLabelContainer();
      smallServiceRadioContainer.setFollowChildEnabled(true);
      smallServiceRadioContainer.setVAlignment(VRLayout.CENTER);
      smallServiceRadioContainer.add(getSmallServiceRadio(), null);
    }
    return smallServiceRadioContainer;
  }

  /**
   * �ߏ��T�[�r�X�ɑ΂��錸�Z���f�����擾���܂��B
   * @return �ߏ��T�[�r�X�ɑ΂��錸�Z���f��
   */
  protected ACListModelAdapter getSmallServiceRadioModel(){
    if(smallServiceRadioModel==null){
      smallServiceRadioModel = new ACListModelAdapter();
      addSmallServiceRadioModel();
    }
    return smallServiceRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getSmallServiceRadioItem1(){
    if(smallServiceRadioItem1==null){

      smallServiceRadioItem1 = new ACRadioButtonItem();

      smallServiceRadioItem1.setText("�Ȃ�");

      smallServiceRadioItem1.setGroup(getSmallServiceRadio());

      smallServiceRadioItem1.setConstraints(VRLayout.FLOW);

      addSmallServiceRadioItem1();
    }
    return smallServiceRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getSmallServiceRadioItem2(){
    if(smallServiceRadioItem2==null){

      smallServiceRadioItem2 = new ACRadioButtonItem();

      smallServiceRadioItem2.setText("����");

      smallServiceRadioItem2.setGroup(getSmallServiceRadio());

      smallServiceRadioItem2.setConstraints(VRLayout.FLOW);

      addSmallServiceRadioItem2();
    }
    return smallServiceRadioItem2;

  }

  /**
   * �l�����Z���擾���܂��B
   * @return �l�����Z
   */
  public ACValueArrayRadioButtonGroup getStaffSubtractionRadio(){
    if(staffSubtractionRadio==null){

      staffSubtractionRadio = new ACValueArrayRadioButtonGroup();

      getStaffSubtractionRadioContainer().setText("�l�����Z");

      staffSubtractionRadio.setBindPath("1730102");

      staffSubtractionRadio.setUseClearButton(false);

      staffSubtractionRadio.setModel(getStaffSubtractionRadioModel());

      staffSubtractionRadio.setValues(new int[]{1,2,3});

      addStaffSubtractionRadio();
    }
    return staffSubtractionRadio;

  }

  /**
   * �l�����Z�R���e�i���擾���܂��B
   * @return �l�����Z�R���e�i
   */
  protected ACLabelContainer getStaffSubtractionRadioContainer(){
    if(staffSubtractionRadioContainer==null){
      staffSubtractionRadioContainer = new ACLabelContainer();
      staffSubtractionRadioContainer.setFollowChildEnabled(true);
      staffSubtractionRadioContainer.setVAlignment(VRLayout.CENTER);
      staffSubtractionRadioContainer.add(getStaffSubtractionRadio(), null);
    }
    return staffSubtractionRadioContainer;
  }

  /**
   * �l�����Z���f�����擾���܂��B
   * @return �l�����Z���f��
   */
  protected ACListModelAdapter getStaffSubtractionRadioModel(){
    if(staffSubtractionRadioModel==null){
      staffSubtractionRadioModel = new ACListModelAdapter();
      addStaffSubtractionRadioModel();
    }
    return staffSubtractionRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getStaffSubtractionRadioItem1(){
    if(staffSubtractionRadioItem1==null){

      staffSubtractionRadioItem1 = new ACRadioButtonItem();

      staffSubtractionRadioItem1.setText("�Ȃ�");

      staffSubtractionRadioItem1.setGroup(getStaffSubtractionRadio());

      staffSubtractionRadioItem1.setConstraints(VRLayout.FLOW);

      addStaffSubtractionRadioItem1();
    }
    return staffSubtractionRadioItem1;

  }

  /**
   * ������߂��擾���܂��B
   * @return �������
   */
  public ACRadioButtonItem getStaffSubtractionRadioItem2(){
    if(staffSubtractionRadioItem2==null){

      staffSubtractionRadioItem2 = new ACRadioButtonItem();

      staffSubtractionRadioItem2.setText("�������");

      staffSubtractionRadioItem2.setGroup(getStaffSubtractionRadio());

      staffSubtractionRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

      addStaffSubtractionRadioItem2();
    }
    return staffSubtractionRadioItem2;

  }

  /**
   * �]�Ǝ҂̕s�����擾���܂��B
   * @return �]�Ǝ҂̕s��
   */
  public ACRadioButtonItem getStaffSubtractionRadioItem3(){
    if(staffSubtractionRadioItem3==null){

      staffSubtractionRadioItem3 = new ACRadioButtonItem();

      staffSubtractionRadioItem3.setText("�]�Ǝ҂̕s��");

      staffSubtractionRadioItem3.setGroup(getStaffSubtractionRadio());

      staffSubtractionRadioItem3.setConstraints(VRLayout.FLOW);

      addStaffSubtractionRadioItem3();
    }
    return staffSubtractionRadioItem3;

  }

  /**
   * �F�m�ǉ��Z���擾���܂��B
   * @return �F�m�ǉ��Z
   */
  public ACValueArrayRadioButtonGroup getDementiaAddRadioGroup(){
    if(dementiaAddRadioGroup==null){

      dementiaAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getDementiaAddRadioGroupContainer().setText("�F�m�ǉ��Z");

      dementiaAddRadioGroup.setBindPath("1730107");

      dementiaAddRadioGroup.setNoSelectIndex(0);

      dementiaAddRadioGroup.setUseClearButton(false);

      dementiaAddRadioGroup.setModel(getDementiaAddRadioGroupModel());

      dementiaAddRadioGroup.setValues(new int[]{1,2,3});

      addDementiaAddRadioGroup();
    }
    return dementiaAddRadioGroup;

  }

  /**
   * �F�m�ǉ��Z�R���e�i���擾���܂��B
   * @return �F�m�ǉ��Z�R���e�i
   */
  protected ACLabelContainer getDementiaAddRadioGroupContainer(){
    if(dementiaAddRadioGroupContainer==null){
      dementiaAddRadioGroupContainer = new ACLabelContainer();
      dementiaAddRadioGroupContainer.setFollowChildEnabled(true);
      dementiaAddRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      dementiaAddRadioGroupContainer.add(getDementiaAddRadioGroup(), null);
    }
    return dementiaAddRadioGroupContainer;
  }

  /**
   * �F�m�ǉ��Z���f�����擾���܂��B
   * @return �F�m�ǉ��Z���f��
   */
  protected ACListModelAdapter getDementiaAddRadioGroupModel(){
    if(dementiaAddRadioGroupModel==null){
      dementiaAddRadioGroupModel = new ACListModelAdapter();
      addDementiaAddRadioGroupModel();
    }
    return dementiaAddRadioGroupModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getDementiaAddRadioItem1(){
    if(dementiaAddRadioItem1==null){

      dementiaAddRadioItem1 = new ACRadioButtonItem();

      dementiaAddRadioItem1.setText("�Ȃ�");

      dementiaAddRadioItem1.setGroup(getDementiaAddRadioGroup());

      dementiaAddRadioItem1.setConstraints(VRLayout.FLOW);

      addDementiaAddRadioItem1();
    }
    return dementiaAddRadioItem1;

  }

  /**
   * I�^���擾���܂��B
   * @return I�^
   */
  public ACRadioButtonItem getDementiaAddRadioItem2(){
    if(dementiaAddRadioItem2==null){

      dementiaAddRadioItem2 = new ACRadioButtonItem();

      dementiaAddRadioItem2.setText("I�^");

      dementiaAddRadioItem2.setGroup(getDementiaAddRadioGroup());

      dementiaAddRadioItem2.setConstraints(VRLayout.FLOW);

      addDementiaAddRadioItem2();
    }
    return dementiaAddRadioItem2;

  }

  /**
   * II�^���擾���܂��B
   * @return II�^
   */
  public ACRadioButtonItem getDementiaAddRadioItem3(){
    if(dementiaAddRadioItem3==null){

      dementiaAddRadioItem3 = new ACRadioButtonItem();

      dementiaAddRadioItem3.setText("II�^");

      dementiaAddRadioItem3.setGroup(getDementiaAddRadioGroup());

      dementiaAddRadioItem3.setConstraints(VRLayout.FLOW);

      addDementiaAddRadioItem3();
    }
    return dementiaAddRadioItem3;

  }

  /**
   * �Ō�E���z�u���Z���擾���܂��B
   * @return �Ō�E���z�u���Z
   */
  public ACValueArrayRadioButtonGroup getNurseStaffDispositionAddRadioGroup(){
    if(nurseStaffDispositionAddRadioGroup==null){

      nurseStaffDispositionAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getNurseStaffDispositionAddRadioGroupContainer().setText("�Ō�E���z�u���Z");

      nurseStaffDispositionAddRadioGroup.setBindPath("1730108");

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
   * I�^���擾���܂��B
   * @return I�^
   */
  public ACRadioButtonItem getNurseStaffDispositionAddRadioItem2(){
    if(nurseStaffDispositionAddRadioItem2==null){

      nurseStaffDispositionAddRadioItem2 = new ACRadioButtonItem();

      nurseStaffDispositionAddRadioItem2.setText("I�^");

      nurseStaffDispositionAddRadioItem2.setGroup(getNurseStaffDispositionAddRadioGroup());

      nurseStaffDispositionAddRadioItem2.setConstraints(VRLayout.FLOW);

      addNurseStaffDispositionAddRadioItem2();
    }
    return nurseStaffDispositionAddRadioItem2;

  }

  /**
   * II�^���擾���܂��B
   * @return II�^
   */
  public ACRadioButtonItem getNurseStaffDispositionAddRadioItem3(){
    if(nurseStaffDispositionAddRadioItem3==null){

      nurseStaffDispositionAddRadioItem3 = new ACRadioButtonItem();

      nurseStaffDispositionAddRadioItem3.setText("II�^");

      nurseStaffDispositionAddRadioItem3.setGroup(getNurseStaffDispositionAddRadioGroup());

      nurseStaffDispositionAddRadioItem3.setConstraints(VRLayout.FLOW);

      addNurseStaffDispositionAddRadioItem3();
    }
    return nurseStaffDispositionAddRadioItem3;

  }

  /**
   * III�^���擾���܂��B
   * @return III�^
   */
  public ACRadioButtonItem getNurseStaffDispositionAddRadioItem4(){
    if(nurseStaffDispositionAddRadioItem4==null){

      nurseStaffDispositionAddRadioItem4 = new ACRadioButtonItem();

      nurseStaffDispositionAddRadioItem4.setText("III�^");

      nurseStaffDispositionAddRadioItem4.setGroup(getNurseStaffDispositionAddRadioGroup());

      nurseStaffDispositionAddRadioItem4.setConstraints(VRLayout.FLOW);

      addNurseStaffDispositionAddRadioItem4();
    }
    return nurseStaffDispositionAddRadioItem4;

  }

  /**
   * ���ꌚ�����Z�҂ւ̃T�[�r�X�񋟂��擾���܂��B
   * @return ���ꌚ�����Z�҂ւ̃T�[�r�X��
   */
  public ACValueArrayRadioButtonGroup getHoumonNeededRadio(){
    if(houmonNeededRadio==null){

      houmonNeededRadio = new ACValueArrayRadioButtonGroup();

      getHoumonNeededRadioContainer().setText("���ꌚ�����Z�҂ւ̃T�[�r�X��");

      houmonNeededRadio.setBindPath("16");

      houmonNeededRadio.setNoSelectIndex(0);

      houmonNeededRadio.setUseClearButton(false);

      houmonNeededRadio.setModel(getHoumonNeededRadioModel());

      houmonNeededRadio.setValues(new int[]{1,2});

      addHoumonNeededRadio();
    }
    return houmonNeededRadio;

  }

  /**
   * ���ꌚ�����Z�҂ւ̃T�[�r�X�񋟃R���e�i���擾���܂��B
   * @return ���ꌚ�����Z�҂ւ̃T�[�r�X�񋟃R���e�i
   */
  protected ACLabelContainer getHoumonNeededRadioContainer(){
    if(houmonNeededRadioContainer==null){
      houmonNeededRadioContainer = new ACLabelContainer();
      houmonNeededRadioContainer.setFollowChildEnabled(true);
      houmonNeededRadioContainer.setVAlignment(VRLayout.CENTER);
      houmonNeededRadioContainer.add(getHoumonNeededRadio(), null);
    }
    return houmonNeededRadioContainer;
  }

  /**
   * ���ꌚ�����Z�҂ւ̃T�[�r�X�񋟃��f�����擾���܂��B
   * @return ���ꌚ�����Z�҂ւ̃T�[�r�X�񋟃��f��
   */
  protected ACListModelAdapter getHoumonNeededRadioModel(){
    if(houmonNeededRadioModel==null){
      houmonNeededRadioModel = new ACListModelAdapter();
      addHoumonNeededRadioModel();
    }
    return houmonNeededRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getHoumonNeededRadioItem1(){
    if(houmonNeededRadioItem1==null){

      houmonNeededRadioItem1 = new ACRadioButtonItem();

      houmonNeededRadioItem1.setText("�Ȃ�");

      houmonNeededRadioItem1.setGroup(getHoumonNeededRadio());

      houmonNeededRadioItem1.setConstraints(VRLayout.FLOW);

      addHoumonNeededRadioItem1();
    }
    return houmonNeededRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getHoumonNeededRadioItem2(){
    if(houmonNeededRadioItem2==null){

      houmonNeededRadioItem2 = new ACRadioButtonItem();

      houmonNeededRadioItem2.setText("����");

      houmonNeededRadioItem2.setGroup(getHoumonNeededRadio());

      houmonNeededRadioItem2.setConstraints(VRLayout.FLOW);

      addHoumonNeededRadioItem2();
    }
    return houmonNeededRadioItem2;

  }

  /**
   * �T�[�r�X�񋟑̐��������Z���擾���܂��B
   * @return �T�[�r�X�񋟑̐��������Z
   */
  public ACValueArrayRadioButtonGroup getServiceAddProvisionStructuralRadioGroup(){
    if(serviceAddProvisionStructuralRadioGroup==null){

      serviceAddProvisionStructuralRadioGroup = new ACValueArrayRadioButtonGroup();

      getServiceAddProvisionStructuralRadioGroupContainer().setText("�T�[�r�X�񋟑̐��������Z");

      serviceAddProvisionStructuralRadioGroup.setBindPath("1730110");

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
   * I�C�^���擾���܂��B
   * @return I�C�^
   */
  public ACRadioButtonItem getServiceAddProvisionStructuralRadioItem5(){
    if(serviceAddProvisionStructuralRadioItem5==null){

      serviceAddProvisionStructuralRadioItem5 = new ACRadioButtonItem();

      serviceAddProvisionStructuralRadioItem5.setText("I�C�^");

      serviceAddProvisionStructuralRadioItem5.setGroup(getServiceAddProvisionStructuralRadioGroup());

      serviceAddProvisionStructuralRadioItem5.setConstraints(VRLayout.FLOW_RETURN);

      addServiceAddProvisionStructuralRadioItem5();
    }
    return serviceAddProvisionStructuralRadioItem5;

  }

  /**
   * I���^���擾���܂��B
   * @return I���^
   */
  public ACRadioButtonItem getServiceAddProvisionStructuralRadioItem2(){
    if(serviceAddProvisionStructuralRadioItem2==null){

      serviceAddProvisionStructuralRadioItem2 = new ACRadioButtonItem();

      serviceAddProvisionStructuralRadioItem2.setText("I���^");

      serviceAddProvisionStructuralRadioItem2.setGroup(getServiceAddProvisionStructuralRadioGroup());

      serviceAddProvisionStructuralRadioItem2.setConstraints(VRLayout.FLOW);

      addServiceAddProvisionStructuralRadioItem2();
    }
    return serviceAddProvisionStructuralRadioItem2;

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
   * �s�����Ǝ����Z���擾���܂��B
   * @return �s�����Ǝ����Z
   */
  public ACComboBox getMunicipalityAdd(){
    if(municipalityAdd==null){

      municipalityAdd = new ACComboBox();

      getMunicipalityAddContainer().setText("�s�����Ǝ����Z");

      municipalityAdd.setBindPath("1730111");

      municipalityAdd.setEditable(false);

      municipalityAdd.setModelBindPath("1730111");

      municipalityAdd.setRenderBindPath("CONTENT");

      municipalityAdd.setBlankable(false);

      municipalityAdd.setModel(getMunicipalityAddModel());

      addMunicipalityAdd();
    }
    return municipalityAdd;

  }

  /**
   * �s�����Ǝ����Z�R���e�i���擾���܂��B
   * @return �s�����Ǝ����Z�R���e�i
   */
  protected ACLabelContainer getMunicipalityAddContainer(){
    if(municipalityAddContainer==null){
      municipalityAddContainer = new ACLabelContainer();
      municipalityAddContainer.setFollowChildEnabled(true);
      municipalityAddContainer.setVAlignment(VRLayout.CENTER);
      municipalityAddContainer.add(getMunicipalityAdd(), null);
    }
    return municipalityAddContainer;
  }

  /**
   * �s�����Ǝ����Z���f�����擾���܂��B
   * @return �s�����Ǝ����Z���f��
   */
  protected ACComboBoxModelAdapter getMunicipalityAddModel(){
    if(municipalityAddModel==null){
      municipalityAddModel = new ACComboBoxModelAdapter();
      addMunicipalityAddModel();
    }
    return municipalityAddModel;
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

      tab2.setLabelMargin(0);

      tab2.setVgap(0);

      addTab2();
    }
    return tab2;

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
   * �Ŏ��A�g�̐����Z���擾���܂��B
   * @return �Ŏ��A�g�̐����Z
   */
  public ACValueArrayRadioButtonGroup getTerminalCareInformationRadioGroup(){
    if(terminalCareInformationRadioGroup==null){

      terminalCareInformationRadioGroup = new ACValueArrayRadioButtonGroup();

      getTerminalCareInformationRadioGroupContainer().setText("�Ŏ��A�g�̐����Z");

      terminalCareInformationRadioGroup.setBindPath("1730113");

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
   * �Ŏ��A�g�̐����Z�R���e�i���擾���܂��B
   * @return �Ŏ��A�g�̐����Z�R���e�i
   */
  public ACLabelContainer getTerminalCareInformationAddDaysContainer(){
    if(terminalCareInformationAddDaysContainer==null){

      terminalCareInformationAddDaysContainer = new ACLabelContainer();

      terminalCareInformationAddDaysContainer.setText("�Ŏ��A�g�̐����Z����");

      terminalCareInformationAddDaysContainer.setFollowChildEnabled(true);

      addTerminalCareInformationAddDaysContainer();
    }
    return terminalCareInformationAddDaysContainer;

  }

  /**
   * �Ŏ��A�g�̐����Z�������擾���܂��B
   * @return �Ŏ��A�g�̐����Z����
   */
  public ACTextField getTerminalCareInformationAddDays(){
    if(terminalCareInformationAddDays==null){

      terminalCareInformationAddDays = new ACTextField();

      terminalCareInformationAddDays.setText("1");

      terminalCareInformationAddDays.setBindPath("1730116");

      terminalCareInformationAddDays.setColumns(2);

      terminalCareInformationAddDays.setCharType(VRCharType.ONLY_DIGIT);

      terminalCareInformationAddDays.setHorizontalAlignment(SwingConstants.RIGHT);

      terminalCareInformationAddDays.setMaxLength(2);

      addTerminalCareInformationAddDays();
    }
    return terminalCareInformationAddDays;

  }

  /**
   * �Ŏ��A�g�̐����Z�����P�ʂ��擾���܂��B
   * @return �Ŏ��A�g�̐����Z�����P��
   */
  public ACLabel getTerminalCareInformationAddDaysUnit(){
    if(terminalCareInformationAddDaysUnit==null){

      terminalCareInformationAddDaysUnit = new ACLabel();

      terminalCareInformationAddDaysUnit.setText("��");

      addTerminalCareInformationAddDaysUnit();
    }
    return terminalCareInformationAddDaysUnit;

  }

  /**
   * �K��̐��������Z���擾���܂��B
   * @return �K��̐��������Z
   */
  public ACValueArrayRadioButtonGroup getVisitStrengthenAddRadioGroup(){
    if(visitStrengthenAddRadioGroup==null){

      visitStrengthenAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getVisitStrengthenAddRadioGroupContainer().setText("�K��̐��������Z");

      visitStrengthenAddRadioGroup.setBindPath("1730114");

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

      comprehensiveManagementSystemRadioGroup.setBindPath("1730115");

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
   * ��N���F�m�ǎ�����Z���擾���܂��B
   * @return ��N���F�m�ǎ�����Z
   */
  public ACValueArrayRadioButtonGroup getYoungDementiaPatinetAddRadioGroup(){
    if(youngDementiaPatinetAddRadioGroup==null){

      youngDementiaPatinetAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getYoungDementiaPatinetAddRadioGroupContainer().setText("��N���F�m�ǎ�����Z");

      youngDementiaPatinetAddRadioGroup.setBindPath("1730117");

      youngDementiaPatinetAddRadioGroup.setNoSelectIndex(0);

      youngDementiaPatinetAddRadioGroup.setUseClearButton(false);

      youngDementiaPatinetAddRadioGroup.setModel(getYoungDementiaPatinetAddRadioGroupModel());

      youngDementiaPatinetAddRadioGroup.setValues(new int[]{1,2});

      addYoungDementiaPatinetAddRadioGroup();
    }
    return youngDementiaPatinetAddRadioGroup;

  }

  /**
   * ��N���F�m�ǎ�����Z�R���e�i���擾���܂��B
   * @return ��N���F�m�ǎ�����Z�R���e�i
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
   * ��N���F�m�ǎ�����Z���f�����擾���܂��B
   * @return ��N���F�m�ǎ�����Z���f��
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
   * �����@�\����A�g���Z���擾���܂��B
   * @return �����@�\����A�g���Z
   */
  public ACValueArrayRadioButtonGroup getRehabilitationSpecialistPersonnelCooperationRadioGroup(){
    if(rehabilitationSpecialistPersonnelCooperationRadioGroup==null){

      rehabilitationSpecialistPersonnelCooperationRadioGroup = new ACValueArrayRadioButtonGroup();

      getRehabilitationSpecialistPersonnelCooperationRadioGroupContainer().setText("�����@�\����A�g���Z");

      rehabilitationSpecialistPersonnelCooperationRadioGroup.setBindPath("1730118");

      rehabilitationSpecialistPersonnelCooperationRadioGroup.setNoSelectIndex(0);

      rehabilitationSpecialistPersonnelCooperationRadioGroup.setUseClearButton(false);

      rehabilitationSpecialistPersonnelCooperationRadioGroup.setModel(getRehabilitationSpecialistPersonnelCooperationRadioGroupModel());

      rehabilitationSpecialistPersonnelCooperationRadioGroup.setValues(new int[]{1,2,3});

      addRehabilitationSpecialistPersonnelCooperationRadioGroup();
    }
    return rehabilitationSpecialistPersonnelCooperationRadioGroup;

  }

  /**
   * �����@�\����A�g���Z�R���e�i���擾���܂��B
   * @return �����@�\����A�g���Z�R���e�i
   */
  protected ACLabelContainer getRehabilitationSpecialistPersonnelCooperationRadioGroupContainer(){
    if(rehabilitationSpecialistPersonnelCooperationRadioGroupContainer==null){
      rehabilitationSpecialistPersonnelCooperationRadioGroupContainer = new ACLabelContainer();
      rehabilitationSpecialistPersonnelCooperationRadioGroupContainer.setFollowChildEnabled(true);
      rehabilitationSpecialistPersonnelCooperationRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      rehabilitationSpecialistPersonnelCooperationRadioGroupContainer.add(getRehabilitationSpecialistPersonnelCooperationRadioGroup(), null);
    }
    return rehabilitationSpecialistPersonnelCooperationRadioGroupContainer;
  }

  /**
   * �����@�\����A�g���Z���f�����擾���܂��B
   * @return �����@�\����A�g���Z���f��
   */
  protected ACListModelAdapter getRehabilitationSpecialistPersonnelCooperationRadioGroupModel(){
    if(rehabilitationSpecialistPersonnelCooperationRadioGroupModel==null){
      rehabilitationSpecialistPersonnelCooperationRadioGroupModel = new ACListModelAdapter();
      addRehabilitationSpecialistPersonnelCooperationRadioGroupModel();
    }
    return rehabilitationSpecialistPersonnelCooperationRadioGroupModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getRehabilitationSpecialistPersonnelCooperationItem1(){
    if(rehabilitationSpecialistPersonnelCooperationItem1==null){

      rehabilitationSpecialistPersonnelCooperationItem1 = new ACRadioButtonItem();

      rehabilitationSpecialistPersonnelCooperationItem1.setText("�Ȃ�");

      rehabilitationSpecialistPersonnelCooperationItem1.setGroup(getRehabilitationSpecialistPersonnelCooperationRadioGroup());

      rehabilitationSpecialistPersonnelCooperationItem1.setConstraints(VRLayout.FLOW);

      addRehabilitationSpecialistPersonnelCooperationItem1();
    }
    return rehabilitationSpecialistPersonnelCooperationItem1;

  }

  /**
   * I�^���擾���܂��B
   * @return I�^
   */
  public ACRadioButtonItem getRehabilitationSpecialistPersonnelCooperationItem2(){
    if(rehabilitationSpecialistPersonnelCooperationItem2==null){

      rehabilitationSpecialistPersonnelCooperationItem2 = new ACRadioButtonItem();

      rehabilitationSpecialistPersonnelCooperationItem2.setText("I�^");

      rehabilitationSpecialistPersonnelCooperationItem2.setGroup(getRehabilitationSpecialistPersonnelCooperationRadioGroup());

      rehabilitationSpecialistPersonnelCooperationItem2.setConstraints(VRLayout.FLOW);

      addRehabilitationSpecialistPersonnelCooperationItem2();
    }
    return rehabilitationSpecialistPersonnelCooperationItem2;

  }

  /**
   * II�^���擾���܂��B
   * @return II�^
   */
  public ACRadioButtonItem getRehabilitationSpecialistPersonnelCooperationItem3(){
    if(rehabilitationSpecialistPersonnelCooperationItem3==null){

      rehabilitationSpecialistPersonnelCooperationItem3 = new ACRadioButtonItem();

      rehabilitationSpecialistPersonnelCooperationItem3.setText("II�^");

      rehabilitationSpecialistPersonnelCooperationItem3.setGroup(getRehabilitationSpecialistPersonnelCooperationRadioGroup());

      rehabilitationSpecialistPersonnelCooperationItem3.setConstraints(VRLayout.FLOW);

      addRehabilitationSpecialistPersonnelCooperationItem3();
    }
    return rehabilitationSpecialistPersonnelCooperationItem3;

  }

  /**
   * �h�{�X�N���[�j���O���Z���擾���܂��B
   * @return �h�{�X�N���[�j���O���Z
   */
  public ACValueArrayRadioButtonGroup getNutritionScreening(){
    if(nutritionScreening==null){

      nutritionScreening = new ACValueArrayRadioButtonGroup();

      getNutritionScreeningContainer().setText("�h�{�X�N���[�j���O���Z");

      nutritionScreening.setBindPath("1730119");

      nutritionScreening.setUseClearButton(false);

      nutritionScreening.setModel(getNutritionScreeningModel());

      nutritionScreening.setValues(new int[]{1,2});

      addNutritionScreening();
    }
    return nutritionScreening;

  }

  /**
   * �h�{�X�N���[�j���O���Z�R���e�i���擾���܂��B
   * @return �h�{�X�N���[�j���O���Z�R���e�i
   */
  protected ACLabelContainer getNutritionScreeningContainer(){
    if(nutritionScreeningContainer==null){
      nutritionScreeningContainer = new ACLabelContainer();
      nutritionScreeningContainer.setFollowChildEnabled(true);
      nutritionScreeningContainer.setVAlignment(VRLayout.CENTER);
      nutritionScreeningContainer.add(getNutritionScreening(), null);
    }
    return nutritionScreeningContainer;
  }

  /**
   * �h�{�X�N���[�j���O���Z���f�����擾���܂��B
   * @return �h�{�X�N���[�j���O���Z���f��
   */
  protected ACListModelAdapter getNutritionScreeningModel(){
    if(nutritionScreeningModel==null){
      nutritionScreeningModel = new ACListModelAdapter();
      addNutritionScreeningModel();
    }
    return nutritionScreeningModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getNutritionScreeningItem1(){
    if(nutritionScreeningItem1==null){

      nutritionScreeningItem1 = new ACRadioButtonItem();

      nutritionScreeningItem1.setText("�Ȃ�");

      nutritionScreeningItem1.setGroup(getNutritionScreening());

      addNutritionScreeningItem1();
    }
    return nutritionScreeningItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getNutritionScreeningItem2(){
    if(nutritionScreeningItem2==null){

      nutritionScreeningItem2 = new ACRadioButtonItem();

      nutritionScreeningItem2.setText("����");

      nutritionScreeningItem2.setGroup(getNutritionScreening());

      addNutritionScreeningItem2();
    }
    return nutritionScreeningItem2;

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
  public ACRadioButtonItem getCalculationDivisionItem1(){
    if(calculationDivisionItem1==null){

      calculationDivisionItem1 = new ACRadioButtonItem();

      calculationDivisionItem1.setText("�ʏ�");

      calculationDivisionItem1.setGroup(getCalculationDivision());

      calculationDivisionItem1.setConstraints(VRLayout.FLOW);

      addCalculationDivisionItem1();
    }
    return calculationDivisionItem1;

  }

  /**
   * ���Z�݂̂��擾���܂��B
   * @return ���Z�̂�
   */
  public ACRadioButtonItem getCalculationDivisionItem2(){
    if(calculationDivisionItem2==null){

      calculationDivisionItem2 = new ACRadioButtonItem();

      calculationDivisionItem2.setText("���Z�̂�");

      calculationDivisionItem2.setGroup(getCalculationDivision());

      calculationDivisionItem2.setConstraints(VRLayout.FLOW);

      addCalculationDivisionItem2();
    }
    return calculationDivisionItem2;

  }

  /**
   * �^�u3���擾���܂��B
   * @return �^�u3
   */
  public ACPanel getTab3(){
    if(tab3==null){

      tab3 = new ACPanel();

      tab3.setFollowChildEnabled(true);

      tab3.setHgap(0);

      tab3.setLabelMargin(0);

      tab3.setVgap(0);

      addTab3();
    }
    return tab3;

  }

  /**
   * �������擾���܂��B
   * @return ����
   */
  public ACIntegerCheckBox getCrackOnDayCheck(){
    if(crackOnDayCheck==null){

      crackOnDayCheck = new ACIntegerCheckBox();

      crackOnDayCheck.setText("����");

      crackOnDayCheck.setBindPath("1730103");

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
   * ���ӏ����O���[�v���擾���܂��B
   * @return ���ӏ����O���[�v
   */
  public ACGroupBox getInfoGroup(){
    if(infoGroup==null){

      infoGroup = new ACGroupBox();

      infoGroup.setFollowChildEnabled(true);

      infoGroup.setHgap(0);

      infoGroup.setLabelMargin(0);

      infoGroup.setVgap(0);

      addInfoGroup();
    }
    return infoGroup;

  }

  /**
   * ���ӏ������x�����擾���܂��B
   * @return ���ӏ������x��
   */
  public ACLabel getInfoLabel(){
    if(infoLabel==null){

      infoLabel = new ACLabel();

      infoLabel.setText("���r���ŗv����ԋ敪���ύX�ɂȂ�ꍇ�́A" + ACConstants.LINE_SEPARATOR + "�e������T�[�r�X��S�Ă̓����ɓ\��t���A" + ACConstants.LINE_SEPARATOR + "���ۂ̒񋟓��ɂ́w�񋟓��x�̃`�F�b�N����" + ACConstants.LINE_SEPARATOR + "�k�ݒ�l�{�^�����N���b�N���Ă��������B");

      addInfoLabel();
    }
    return infoLabel;

  }

  /**
   * ���x�������R���e�i���擾���܂��B
   * @return ���x�������R���e�i
   */
  public ACGroupBox getKaigoSupportSpecialMemberContainer(){
    if(kaigoSupportSpecialMemberContainer==null){

      kaigoSupportSpecialMemberContainer = new ACGroupBox();

      kaigoSupportSpecialMemberContainer.setText("���x���������");

      kaigoSupportSpecialMemberContainer.setFollowChildEnabled(true);

      addKaigoSupportSpecialMemberContainer();
    }
    return kaigoSupportSpecialMemberContainer;

  }

  /**
   * ���x�������ԍ����擾���܂��B
   * @return ���x�������ԍ�
   */
  public ACTextField getKaigoSupportSpecialMemberNumber(){
    if(kaigoSupportSpecialMemberNumber==null){

      kaigoSupportSpecialMemberNumber = new ACTextField();

      getKaigoSupportSpecialMemberNumberContainer().setText("���x�������ԍ�");

      kaigoSupportSpecialMemberNumber.setBindPath("1730104");

      kaigoSupportSpecialMemberNumber.setColumns(6);

      kaigoSupportSpecialMemberNumber.setCharType(VRCharType.ONLY_DIGIT);

      kaigoSupportSpecialMemberNumber.setMaxLength(8);

      addKaigoSupportSpecialMemberNumber();
    }
    return kaigoSupportSpecialMemberNumber;

  }

  /**
   * ���x�������ԍ��R���e�i���擾���܂��B
   * @return ���x�������ԍ��R���e�i
   */
  protected ACLabelContainer getKaigoSupportSpecialMemberNumberContainer(){
    if(kaigoSupportSpecialMemberNumberContainer==null){
      kaigoSupportSpecialMemberNumberContainer = new ACLabelContainer();
      kaigoSupportSpecialMemberNumberContainer.setFollowChildEnabled(true);
      kaigoSupportSpecialMemberNumberContainer.setVAlignment(VRLayout.CENTER);
      kaigoSupportSpecialMemberNumberContainer.add(getKaigoSupportSpecialMemberNumber(), null);
    }
    return kaigoSupportSpecialMemberNumberContainer;
  }

  /**
   * ���x�������������擾���܂��B
   * @return ���x����������
   */
  public ACComboBox getKaigoSupportSpecialMemberName(){
    if(kaigoSupportSpecialMemberName==null){

      kaigoSupportSpecialMemberName = new ACComboBox();

      getKaigoSupportSpecialMemberNameContainer().setText("���x����������");

      kaigoSupportSpecialMemberName.setEditable(false);

      kaigoSupportSpecialMemberName.setRenderBindPath("STAFF_NAME");

      kaigoSupportSpecialMemberName.setMaxColumns(10);

      kaigoSupportSpecialMemberName.setModel(getKaigoSupportSpecialMemberNameModel());

      addKaigoSupportSpecialMemberName();
    }
    return kaigoSupportSpecialMemberName;

  }

  /**
   * ���x�����������R���e�i���擾���܂��B
   * @return ���x�����������R���e�i
   */
  protected ACLabelContainer getKaigoSupportSpecialMemberNameContainer(){
    if(kaigoSupportSpecialMemberNameContainer==null){
      kaigoSupportSpecialMemberNameContainer = new ACLabelContainer();
      kaigoSupportSpecialMemberNameContainer.setFollowChildEnabled(true);
      kaigoSupportSpecialMemberNameContainer.setVAlignment(VRLayout.CENTER);
      kaigoSupportSpecialMemberNameContainer.add(getKaigoSupportSpecialMemberName(), null);
    }
    return kaigoSupportSpecialMemberNameContainer;
  }

  /**
   * ���x�������������f�����擾���܂��B
   * @return ���x�������������f��
   */
  protected ACComboBoxModelAdapter getKaigoSupportSpecialMemberNameModel(){
    if(kaigoSupportSpecialMemberNameModel==null){
      kaigoSupportSpecialMemberNameModel = new ACComboBoxModelAdapter();
      addKaigoSupportSpecialMemberNameModel();
    }
    return kaigoSupportSpecialMemberNameModel;
  }

  /**
   * �E�v�������O���[�v���擾���܂��B
   * @return �E�v�������O���[�v
   */
  public ACGroupBox getTekiyouGroup(){
    if(tekiyouGroup==null){

      tekiyouGroup = new ACGroupBox();

      tekiyouGroup.setText("�E�v��");

      tekiyouGroup.setVisible(true);

      tekiyouGroup.setEnabled(true);

      tekiyouGroup.setFollowChildEnabled(true);

      tekiyouGroup.setHgap(0);

      tekiyouGroup.setLabelMargin(0);

      tekiyouGroup.setVgap(0);

      addTekiyouGroup();
    }
    return tekiyouGroup;

  }

  /**
   * �E�v���e�L�X�g���擾���܂��B
   * @return �E�v���e�L�X�g
   */
  public ACTextField getTekiyouText(){
    if(tekiyouText==null){

      tekiyouText = new ACTextField();

      getTekiyouTextContainer().setText("�ʏ��K��h������");

      tekiyouText.setBindPath("1730105");

      tekiyouText.setVisible(true);

      tekiyouText.setEnabled(true);

      tekiyouText.setEditable(true);

      tekiyouText.setColumns(5);

      tekiyouText.setCharType(VRCharType.ONLY_DIGIT);

      tekiyouText.setHorizontalAlignment(SwingConstants.LEFT);

      tekiyouText.setIMEMode(InputSubset.LATIN);

      tekiyouText.setMaxLength(6);

      addTekiyouText();
    }
    return tekiyouText;

  }

  /**
   * �E�v���e�L�X�g�R���e�i���擾���܂��B
   * @return �E�v���e�L�X�g�R���e�i
   */
  protected ACLabelContainer getTekiyouTextContainer(){
    if(tekiyouTextContainer==null){
      tekiyouTextContainer = new ACLabelContainer();
      tekiyouTextContainer.setFollowChildEnabled(true);
      tekiyouTextContainer.setVAlignment(VRLayout.CENTER);
      tekiyouTextContainer.add(getTekiyouText(), null);
    }
    return tekiyouTextContainer;
  }

  /**
   * �E�v���������x�����擾���܂��B
   * @return �E�v���������x��
   */
  public ACLabel getTekiyouCommentTitle(){
    if(tekiyouCommentTitle==null){

      tekiyouCommentTitle = new ACLabel();

      tekiyouCommentTitle.setText("���̈�ԍŏ��̗��p���ɋL�����Ă��������B");

      tekiyouCommentTitle.setIconPath(ACConstants.ICON_PATH_EXCLAMATION_16);

      tekiyouCommentTitle.setAutoWrap(true);

      addTekiyouCommentTitle();
    }
    return tekiyouCommentTitle;

  }

  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001_17311_201804Design() {

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

    this.add(getRegionSmallscaleMultiPatterns(), VRLayout.CLIENT);

  }

  /**
   * �n�斧�����K�͑��@�\�^���p�^�[���̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addRegionSmallscaleMultiPatterns(){

    regionSmallscaleMultiPatterns.add(getTabs(), VRLayout.CLIENT);

  }

  /**
   * �^�u�p�l���ɓ������ڂ�ǉ����܂��B
   */
  protected void addTabs(){

    tabs.addTab("1", getTab1());

    tabs.addTab("2", getTab2());

    tabs.addTab("3", getTab3());

  }

  /**
   * �^�u1�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTab1(){

    tab1.add(getInitialAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getSmallServiceRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getStaffSubtractionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getDementiaAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getNurseStaffDispositionAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getHoumonNeededRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getServiceAddProvisionStructuralRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getMunicipalityAddContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * �������Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addInitialAddRadio(){

  }

  /**
   * �������Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addInitialAddRadioModel(){

    getInitialAddRadioItem1().setButtonIndex(1);

    getInitialAddRadioModel().add(getInitialAddRadioItem1());

    getInitialAddRadioItem2().setButtonIndex(2);

    getInitialAddRadioModel().add(getInitialAddRadioItem2());

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
   * �ߏ��T�[�r�X�ɑ΂��錸�Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addSmallServiceRadio(){

  }

  /**
   * �ߏ��T�[�r�X�ɑ΂��錸�Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addSmallServiceRadioModel(){

    getSmallServiceRadioItem1().setButtonIndex(1);

    getSmallServiceRadioModel().add(getSmallServiceRadioItem1());

    getSmallServiceRadioItem2().setButtonIndex(2);

    getSmallServiceRadioModel().add(getSmallServiceRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addSmallServiceRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addSmallServiceRadioItem2(){

  }

  /**
   * �l�����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffSubtractionRadio(){

  }

  /**
   * �l�����Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffSubtractionRadioModel(){

    getStaffSubtractionRadioItem1().setButtonIndex(1);

    getStaffSubtractionRadioModel().add(getStaffSubtractionRadioItem1());

    getStaffSubtractionRadioItem2().setButtonIndex(2);

    getStaffSubtractionRadioModel().add(getStaffSubtractionRadioItem2());

    getStaffSubtractionRadioItem3().setButtonIndex(3);

    getStaffSubtractionRadioModel().add(getStaffSubtractionRadioItem3());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffSubtractionRadioItem1(){

  }

  /**
   * ������߂ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffSubtractionRadioItem2(){

  }

  /**
   * �]�Ǝ҂̕s���ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffSubtractionRadioItem3(){

  }

  /**
   * �F�m�ǉ��Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addDementiaAddRadioGroup(){

  }

  /**
   * �F�m�ǉ��Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addDementiaAddRadioGroupModel(){

    getDementiaAddRadioItem1().setButtonIndex(1);

    getDementiaAddRadioGroupModel().add(getDementiaAddRadioItem1());

    getDementiaAddRadioItem2().setButtonIndex(2);

    getDementiaAddRadioGroupModel().add(getDementiaAddRadioItem2());

    getDementiaAddRadioItem3().setButtonIndex(3);

    getDementiaAddRadioGroupModel().add(getDementiaAddRadioItem3());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addDementiaAddRadioItem1(){

  }

  /**
   * I�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addDementiaAddRadioItem2(){

  }

  /**
   * II�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addDementiaAddRadioItem3(){

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
   * I�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addNurseStaffDispositionAddRadioItem2(){

  }

  /**
   * II�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addNurseStaffDispositionAddRadioItem3(){

  }

  /**
   * III�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addNurseStaffDispositionAddRadioItem4(){

  }

  /**
   * ���ꌚ�����Z�҂ւ̃T�[�r�X�񋟂ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonNeededRadio(){

  }

  /**
   * ���ꌚ�����Z�҂ւ̃T�[�r�X�񋟃��f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonNeededRadioModel(){

    getHoumonNeededRadioItem1().setButtonIndex(1);

    getHoumonNeededRadioModel().add(getHoumonNeededRadioItem1());

    getHoumonNeededRadioItem2().setButtonIndex(2);

    getHoumonNeededRadioModel().add(getHoumonNeededRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonNeededRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonNeededRadioItem2(){

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

    getServiceAddProvisionStructuralRadioItem5().setButtonIndex(5);

    getServiceAddProvisionStructuralRadioGroupModel().add(getServiceAddProvisionStructuralRadioItem5());

    getServiceAddProvisionStructuralRadioItem2().setButtonIndex(2);

    getServiceAddProvisionStructuralRadioGroupModel().add(getServiceAddProvisionStructuralRadioItem2());

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
  protected void addServiceAddProvisionStructuralRadioItem5(){

  }

  /**
   * I���^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceAddProvisionStructuralRadioItem2(){

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
   * �s�����Ǝ����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMunicipalityAdd(){

  }

  /**
   * �s�����Ǝ����Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addMunicipalityAddModel(){

  }

  /**
   * �^�u2�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTab2(){

    tab2.add(getProviderAddMountainousAreaRafioRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getTerminalCareInformationRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getTerminalCareInformationAddDaysContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getVisitStrengthenAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getComprehensiveManagementSystemRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getYoungDementiaPatinetAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getRehabilitationSpecialistPersonnelCooperationRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getNutritionScreeningContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getCalculationDivisionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

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
   * �Ŏ��A�g�̐����Z�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTerminalCareInformationAddDaysContainer(){

    terminalCareInformationAddDaysContainer.add(getTerminalCareInformationAddDays(), VRLayout.FLOW);

    terminalCareInformationAddDaysContainer.add(getTerminalCareInformationAddDaysUnit(), VRLayout.FLOW);

  }

  /**
   * �Ŏ��A�g�̐����Z�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addTerminalCareInformationAddDays(){

  }

  /**
   * �Ŏ��A�g�̐����Z�����P�ʂɓ������ڂ�ǉ����܂��B
   */
  protected void addTerminalCareInformationAddDaysUnit(){

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
   * ��N���F�m�ǎ�����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addYoungDementiaPatinetAddRadioGroup(){

  }

  /**
   * ��N���F�m�ǎ�����Z���f���ɓ������ڂ�ǉ����܂��B
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
   * �����@�\����A�g���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addRehabilitationSpecialistPersonnelCooperationRadioGroup(){

  }

  /**
   * �����@�\����A�g���Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addRehabilitationSpecialistPersonnelCooperationRadioGroupModel(){

    getRehabilitationSpecialistPersonnelCooperationItem1().setButtonIndex(1);

    getRehabilitationSpecialistPersonnelCooperationRadioGroupModel().add(getRehabilitationSpecialistPersonnelCooperationItem1());

    getRehabilitationSpecialistPersonnelCooperationItem2().setButtonIndex(2);

    getRehabilitationSpecialistPersonnelCooperationRadioGroupModel().add(getRehabilitationSpecialistPersonnelCooperationItem2());

    getRehabilitationSpecialistPersonnelCooperationItem3().setButtonIndex(3);

    getRehabilitationSpecialistPersonnelCooperationRadioGroupModel().add(getRehabilitationSpecialistPersonnelCooperationItem3());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addRehabilitationSpecialistPersonnelCooperationItem1(){

  }

  /**
   * I�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addRehabilitationSpecialistPersonnelCooperationItem2(){

  }

  /**
   * II�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addRehabilitationSpecialistPersonnelCooperationItem3(){

  }

  /**
   * �h�{�X�N���[�j���O���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addNutritionScreening(){

  }

  /**
   * �h�{�X�N���[�j���O���Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addNutritionScreeningModel(){

    getNutritionScreeningItem1().setButtonIndex(1);

    getNutritionScreeningModel().add(getNutritionScreeningItem1());

    getNutritionScreeningItem2().setButtonIndex(2);

    getNutritionScreeningModel().add(getNutritionScreeningItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addNutritionScreeningItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addNutritionScreeningItem2(){

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

    getCalculationDivisionItem1().setButtonIndex(1);

    getCalculationDivisionModel().add(getCalculationDivisionItem1());

    getCalculationDivisionItem2().setButtonIndex(2);

    getCalculationDivisionModel().add(getCalculationDivisionItem2());

  }

  /**
   * �ʏ�ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalculationDivisionItem1(){

  }

  /**
   * ���Z�݂̂ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalculationDivisionItem2(){

  }

  /**
   * �^�u3�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTab3(){

    tab3.add(getCrackOnDayCheck(), VRLayout.FLOW_INSETLINE);

    tab3.add(getPrintable(), VRLayout.FLOW_RETURN);

    tab3.add(getInfoGroup(), VRLayout.FLOW);

    tab3.add(getKaigoSupportSpecialMemberContainer(), VRLayout.FLOW_RETURN);

    tab3.add(getTekiyouGroup(), VRLayout.FLOW_RETURN);

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
   * ���ӏ����O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addInfoGroup(){

    infoGroup.add(getInfoLabel(), VRLayout.FLOW);

  }

  /**
   * ���ӏ������x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addInfoLabel(){

  }

  /**
   * ���x�������R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoSupportSpecialMemberContainer(){

    kaigoSupportSpecialMemberContainer.add(getKaigoSupportSpecialMemberNumberContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    kaigoSupportSpecialMemberContainer.add(getKaigoSupportSpecialMemberNameContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * ���x�������ԍ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoSupportSpecialMemberNumber(){

  }

  /**
   * ���x�����������ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoSupportSpecialMemberName(){

  }

  /**
   * ���x�������������f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoSupportSpecialMemberNameModel(){

  }

  /**
   * �E�v�������O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTekiyouGroup(){

    tekiyouGroup.add(getTekiyouTextContainer(), VRLayout.FLOW_RETURN);

    tekiyouGroup.add(getTekiyouCommentTitle(), VRLayout.FLOW_RETURN);

  }

  /**
   * �E�v���e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTekiyouText(){

  }

  /**
   * �E�v���������x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addTekiyouCommentTitle(){

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
      ACFrame.debugStart(new ACAffairInfo(QS001_17311_201804Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QS001_17311_201804Design getThis() {
    return this;
  }
}
