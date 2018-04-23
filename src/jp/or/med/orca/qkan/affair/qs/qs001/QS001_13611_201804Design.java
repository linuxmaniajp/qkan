
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
 * �쐬��: 2018/02/22  ���{�R���s���[�^�[������� ����@��F �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �T�[�r�X�\��쐬/�ύX (S)
 * �v���Z�X �T�[�r�X�\��T�� (001)
 * �v���O���� �T�[�r�X�p�^�[���n�斧���^����{�ݓ����Ґ������ (QS001_13611_201804)
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
 * �T�[�r�X�p�^�[���n�斧���^����{�ݓ����Ґ�������ʍ��ڃf�U�C��(QS001_13611_201804) 
 */
public class QS001_13611_201804Design extends QS001ServicePanel {
  //GUI�R���|�[�l���g

  private ACPanel regionSpecificFacilityPatterns;

  private JTabbedPane tabs;

  private ACPanel tab1;

  private ACValueArrayRadioButtonGroup regionStaffSubtractionRadio;

  private ACLabelContainer regionStaffSubtractionRadioContainer;

  private ACListModelAdapter regionStaffSubtractionRadioModel;

  private ACRadioButtonItem regionSubtractionNo;

  private ACRadioButtonItem regionSubtractionPersonLack;

  private ACValueArrayRadioButtonGroup regionTrainingRadio;

  private ACLabelContainer regionTrainingRadioContainer;

  private ACListModelAdapter regionTrainingRadioModel;

  private ACRadioButtonItem regionTrainingRadioItem1;

  private ACRadioButtonItem regionTrainingRadioItem2;

  private ACValueArrayRadioButtonGroup regionNightStandardRadio;

  private ACLabelContainer regionNightStandardRadioContainer;

  private ACListModelAdapter regionNightStandardRadioModel;

  private ACRadioButtonItem regionNightStandardRadioItem1;

  private ACRadioButtonItem regionNightStandardRadioItem2;

  private ACValueArrayRadioButtonGroup medicalCoordinateAddRadioGroup;

  private ACLabelContainer medicalCoordinateAddRadioGroupContainer;

  private ACListModelAdapter medicalCoordinateAddRadioGroupModel;

  private ACRadioButtonItem medicalCoordinateAddRadioItem1;

  private ACRadioButtonItem medicalCoordinateAddRadioItem2;

  private ACValueArrayRadioButtonGroup watchCareRadioGroup;

  private ACLabelContainer watchCareRadioGroupContainer;

  private ACListModelAdapter watchCareRadioGroupModel;

  private ACRadioButtonItem watchCareRadioItem1;

  private ACRadioButtonItem watchCareRadioItem2;

  private ACRadioButtonItem watchCareRadioItem3;

  private ACRadioButtonItem watchCareRadioItem4;

  private ACValueArrayRadioButtonGroup dementiaProfessionalCareAddRadioGroup;

  private ACLabelContainer dementiaProfessionalCareAddRadioGroupContainer;

  private ACListModelAdapter dementiaProfessionalCareAddRadioGroupModel;

  private ACRadioButtonItem dementiaProfessionalCareAddRadioItem1;

  private ACRadioButtonItem dementiaProfessionalCareAddRadioItem2;

  private ACRadioButtonItem dementiaProfessionalCareAddRadioItem3;

  private ACValueArrayRadioButtonGroup serviceAddProvisionStructuralRadioGroup;

  private ACLabelContainer serviceAddProvisionStructuralRadioGroupContainer;

  private ACListModelAdapter serviceAddProvisionStructuralRadioGroupModel;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem1;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem2;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem3;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem4;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem5;

  private ACPanel tab2;

  private ACValueArrayRadioButtonGroup physicalRestraintNotRepealed;

  private ACLabelContainer physicalRestraintNotRepealedContainer;

  private ACListModelAdapter physicalRestraintNotRepealedModel;

  private ACRadioButtonItem physicalRestraintNotRepealedItem1;

  private ACRadioButtonItem physicalRestraintNotRepealedItem2;

  private ACValueArrayRadioButtonGroup supportForContinuedTenancy;

  private ACLabelContainer supportForContinuedTenancyContainer;

  private ACListModelAdapter supportForContinuedTenancyModel;

  private ACRadioButtonItem supportForContinuedTenancyItem1;

  private ACRadioButtonItem supportForContinuedTenancyItem2;

  private ACValueArrayRadioButtonGroup improvementCollaboration;

  private ACLabelContainer improvementCollaborationContainer;

  private ACListModelAdapter improvementCollaborationModel;

  private ACRadioButtonItem improvementCollaborationItem1;

  private ACRadioButtonItem improvementCollaborationItem2;

  private ACValueArrayRadioButtonGroup youngDementiaPatinetAddRadioGroup;

  private ACLabelContainer youngDementiaPatinetAddRadioGroupContainer;

  private ACListModelAdapter youngDementiaPatinetAddRadioGroupModel;

  private ACRadioButtonItem youngDementiaPatinetAddRadioItem1;

  private ACRadioButtonItem youngDementiaPatinetAddRadioItem2;

  private ACValueArrayRadioButtonGroup oralHygieneControlSystem;

  private ACLabelContainer oralHygieneControlSystemContainer;

  private ACListModelAdapter oralHygieneControlSystemModel;

  private ACRadioButtonItem oralHygieneControlSystemItem1;

  private ACRadioButtonItem oralHygieneControlSystemItem2;

  private ACValueArrayRadioButtonGroup nutritionScreening;

  private ACLabelContainer nutritionScreeningContainer;

  private ACListModelAdapter nutritionScreeningModel;

  private ACRadioButtonItem nutritionScreeningItem1;

  private ACRadioButtonItem nutritionScreeningItem2;

  private ACValueArrayRadioButtonGroup collaborationAtDischargeRadioGroup;

  private ACLabelContainer collaborationAtDischargeRadioGroupContainer;

  private ACListModelAdapter collaborationAtDischargeRadioGroupModel;

  private ACRadioButtonItem collaborationAtDischargeRadioItem1;

  private ACRadioButtonItem collaborationAtDischargeRadioItem2;

  //getter

  /**
   * �n�斧������{�ݓ����Ґ������p�^�[���̈���擾���܂��B
   * @return �n�斧������{�ݓ����Ґ������p�^�[���̈�
   */
  public ACPanel getRegionSpecificFacilityPatterns(){
    if(regionSpecificFacilityPatterns==null){

      regionSpecificFacilityPatterns = new ACPanel();

      regionSpecificFacilityPatterns.setAutoWrap(false);

      regionSpecificFacilityPatterns.setFollowChildEnabled(true);

      regionSpecificFacilityPatterns.setHgrid(200);

      addRegionSpecificFacilityPatterns();
    }
    return regionSpecificFacilityPatterns;

  }

  /**
   * �^�u���擾���܂��B
   * @return �^�u
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
   * �l�����Z���擾���܂��B
   * @return �l�����Z
   */
  public ACValueArrayRadioButtonGroup getRegionStaffSubtractionRadio(){
    if(regionStaffSubtractionRadio==null){

      regionStaffSubtractionRadio = new ACValueArrayRadioButtonGroup();

      getRegionStaffSubtractionRadioContainer().setText("�l�����Z");

      regionStaffSubtractionRadio.setBindPath("1360101");

      regionStaffSubtractionRadio.setUseClearButton(false);

      regionStaffSubtractionRadio.setModel(getRegionStaffSubtractionRadioModel());

      regionStaffSubtractionRadio.setValues(new int[]{1,2});

      addRegionStaffSubtractionRadio();
    }
    return regionStaffSubtractionRadio;

  }

  /**
   * �l�����Z�R���e�i���擾���܂��B
   * @return �l�����Z�R���e�i
   */
  protected ACLabelContainer getRegionStaffSubtractionRadioContainer(){
    if(regionStaffSubtractionRadioContainer==null){
      regionStaffSubtractionRadioContainer = new ACLabelContainer();
      regionStaffSubtractionRadioContainer.setFollowChildEnabled(true);
      regionStaffSubtractionRadioContainer.setVAlignment(VRLayout.CENTER);
      regionStaffSubtractionRadioContainer.add(getRegionStaffSubtractionRadio(), null);
    }
    return regionStaffSubtractionRadioContainer;
  }

  /**
   * �l�����Z���f�����擾���܂��B
   * @return �l�����Z���f��
   */
  protected ACListModelAdapter getRegionStaffSubtractionRadioModel(){
    if(regionStaffSubtractionRadioModel==null){
      regionStaffSubtractionRadioModel = new ACListModelAdapter();
      addRegionStaffSubtractionRadioModel();
    }
    return regionStaffSubtractionRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getRegionSubtractionNo(){
    if(regionSubtractionNo==null){

      regionSubtractionNo = new ACRadioButtonItem();

      regionSubtractionNo.setText("�Ȃ�");

      regionSubtractionNo.setGroup(getRegionStaffSubtractionRadio());

      regionSubtractionNo.setConstraints(VRLayout.FLOW);

      addRegionSubtractionNo();
    }
    return regionSubtractionNo;

  }

  /**
   * �Ō�E���E���̕s�����擾���܂��B
   * @return �Ō�E���E���̕s��
   */
  public ACRadioButtonItem getRegionSubtractionPersonLack(){
    if(regionSubtractionPersonLack==null){

      regionSubtractionPersonLack = new ACRadioButtonItem();

      regionSubtractionPersonLack.setText("�Ō�E���E���̕s��");

      regionSubtractionPersonLack.setGroup(getRegionStaffSubtractionRadio());

      regionSubtractionPersonLack.setConstraints(VRLayout.FLOW);

      addRegionSubtractionPersonLack();
    }
    return regionSubtractionPersonLack;

  }

  /**
   * �ʋ@�\�P���w���̐����Z���擾���܂��B
   * @return �ʋ@�\�P���w���̐����Z
   */
  public ACValueArrayRadioButtonGroup getRegionTrainingRadio(){
    if(regionTrainingRadio==null){

      regionTrainingRadio = new ACValueArrayRadioButtonGroup();

      getRegionTrainingRadioContainer().setText("�ʋ@�\�P���w�����Z");

      regionTrainingRadio.setBindPath("1360102");

      regionTrainingRadio.setUseClearButton(false);

      regionTrainingRadio.setModel(getRegionTrainingRadioModel());

      regionTrainingRadio.setValues(new int[]{1,2});

      addRegionTrainingRadio();
    }
    return regionTrainingRadio;

  }

  /**
   * �ʋ@�\�P���w���̐����Z�R���e�i���擾���܂��B
   * @return �ʋ@�\�P���w���̐����Z�R���e�i
   */
  protected ACLabelContainer getRegionTrainingRadioContainer(){
    if(regionTrainingRadioContainer==null){
      regionTrainingRadioContainer = new ACLabelContainer();
      regionTrainingRadioContainer.setFollowChildEnabled(true);
      regionTrainingRadioContainer.setVAlignment(VRLayout.CENTER);
      regionTrainingRadioContainer.add(getRegionTrainingRadio(), null);
    }
    return regionTrainingRadioContainer;
  }

  /**
   * �ʋ@�\�P���w���̐����Z���f�����擾���܂��B
   * @return �ʋ@�\�P���w���̐����Z���f��
   */
  protected ACListModelAdapter getRegionTrainingRadioModel(){
    if(regionTrainingRadioModel==null){
      regionTrainingRadioModel = new ACListModelAdapter();
      addRegionTrainingRadioModel();
    }
    return regionTrainingRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getRegionTrainingRadioItem1(){
    if(regionTrainingRadioItem1==null){

      regionTrainingRadioItem1 = new ACRadioButtonItem();

      regionTrainingRadioItem1.setText("�Ȃ�");

      regionTrainingRadioItem1.setGroup(getRegionTrainingRadio());

      regionTrainingRadioItem1.setConstraints(VRLayout.FLOW);

      addRegionTrainingRadioItem1();
    }
    return regionTrainingRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getRegionTrainingRadioItem2(){
    if(regionTrainingRadioItem2==null){

      regionTrainingRadioItem2 = new ACRadioButtonItem();

      regionTrainingRadioItem2.setText("����");

      regionTrainingRadioItem2.setGroup(getRegionTrainingRadio());

      regionTrainingRadioItem2.setConstraints(VRLayout.FLOW);

      addRegionTrainingRadioItem2();
    }
    return regionTrainingRadioItem2;

  }

  /**
   * ��ԊŌ�̐����Z���擾���܂��B
   * @return ��ԊŌ�̐����Z
   */
  public ACValueArrayRadioButtonGroup getRegionNightStandardRadio(){
    if(regionNightStandardRadio==null){

      regionNightStandardRadio = new ACValueArrayRadioButtonGroup();

      getRegionNightStandardRadioContainer().setText("��ԊŌ�̐�");

      regionNightStandardRadio.setBindPath("1360103");

      regionNightStandardRadio.setUseClearButton(false);

      regionNightStandardRadio.setModel(getRegionNightStandardRadioModel());

      regionNightStandardRadio.setValues(new int[]{1,2});

      addRegionNightStandardRadio();
    }
    return regionNightStandardRadio;

  }

  /**
   * ��ԊŌ�̐����Z�R���e�i���擾���܂��B
   * @return ��ԊŌ�̐����Z�R���e�i
   */
  protected ACLabelContainer getRegionNightStandardRadioContainer(){
    if(regionNightStandardRadioContainer==null){
      regionNightStandardRadioContainer = new ACLabelContainer();
      regionNightStandardRadioContainer.setFollowChildEnabled(true);
      regionNightStandardRadioContainer.setVAlignment(VRLayout.CENTER);
      regionNightStandardRadioContainer.add(getRegionNightStandardRadio(), null);
    }
    return regionNightStandardRadioContainer;
  }

  /**
   * ��ԊŌ�̐����Z���f�����擾���܂��B
   * @return ��ԊŌ�̐����Z���f��
   */
  protected ACListModelAdapter getRegionNightStandardRadioModel(){
    if(regionNightStandardRadioModel==null){
      regionNightStandardRadioModel = new ACListModelAdapter();
      addRegionNightStandardRadioModel();
    }
    return regionNightStandardRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getRegionNightStandardRadioItem1(){
    if(regionNightStandardRadioItem1==null){

      regionNightStandardRadioItem1 = new ACRadioButtonItem();

      regionNightStandardRadioItem1.setText("�Ȃ�");

      regionNightStandardRadioItem1.setGroup(getRegionNightStandardRadio());

      regionNightStandardRadioItem1.setConstraints(VRLayout.FLOW);

      addRegionNightStandardRadioItem1();
    }
    return regionNightStandardRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getRegionNightStandardRadioItem2(){
    if(regionNightStandardRadioItem2==null){

      regionNightStandardRadioItem2 = new ACRadioButtonItem();

      regionNightStandardRadioItem2.setText("����");

      regionNightStandardRadioItem2.setGroup(getRegionNightStandardRadio());

      regionNightStandardRadioItem2.setConstraints(VRLayout.FLOW);

      addRegionNightStandardRadioItem2();
    }
    return regionNightStandardRadioItem2;

  }

  /**
   * ��Ë@�֘A�g���Z���擾���܂��B
   * @return ��Ë@�֘A�g���Z
   */
  public ACValueArrayRadioButtonGroup getMedicalCoordinateAddRadioGroup(){
    if(medicalCoordinateAddRadioGroup==null){

      medicalCoordinateAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getMedicalCoordinateAddRadioGroupContainer().setText("��Ë@�֘A�g���Z");

      medicalCoordinateAddRadioGroup.setBindPath("1360104");

      medicalCoordinateAddRadioGroup.setUseClearButton(false);

      medicalCoordinateAddRadioGroup.setModel(getMedicalCoordinateAddRadioGroupModel());

      medicalCoordinateAddRadioGroup.setValues(new int[]{1,2});

      addMedicalCoordinateAddRadioGroup();
    }
    return medicalCoordinateAddRadioGroup;

  }

  /**
   * ��Ë@�֘A�g���Z�R���e�i���擾���܂��B
   * @return ��Ë@�֘A�g���Z�R���e�i
   */
  protected ACLabelContainer getMedicalCoordinateAddRadioGroupContainer(){
    if(medicalCoordinateAddRadioGroupContainer==null){
      medicalCoordinateAddRadioGroupContainer = new ACLabelContainer();
      medicalCoordinateAddRadioGroupContainer.setFollowChildEnabled(true);
      medicalCoordinateAddRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      medicalCoordinateAddRadioGroupContainer.add(getMedicalCoordinateAddRadioGroup(), null);
    }
    return medicalCoordinateAddRadioGroupContainer;
  }

  /**
   * ��Ë@�֘A�g���Z���f�����擾���܂��B
   * @return ��Ë@�֘A�g���Z���f��
   */
  protected ACListModelAdapter getMedicalCoordinateAddRadioGroupModel(){
    if(medicalCoordinateAddRadioGroupModel==null){
      medicalCoordinateAddRadioGroupModel = new ACListModelAdapter();
      addMedicalCoordinateAddRadioGroupModel();
    }
    return medicalCoordinateAddRadioGroupModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getMedicalCoordinateAddRadioItem1(){
    if(medicalCoordinateAddRadioItem1==null){

      medicalCoordinateAddRadioItem1 = new ACRadioButtonItem();

      medicalCoordinateAddRadioItem1.setText("�Ȃ�");

      medicalCoordinateAddRadioItem1.setGroup(getMedicalCoordinateAddRadioGroup());

      medicalCoordinateAddRadioItem1.setConstraints(VRLayout.FLOW);

      addMedicalCoordinateAddRadioItem1();
    }
    return medicalCoordinateAddRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getMedicalCoordinateAddRadioItem2(){
    if(medicalCoordinateAddRadioItem2==null){

      medicalCoordinateAddRadioItem2 = new ACRadioButtonItem();

      medicalCoordinateAddRadioItem2.setText("����");

      medicalCoordinateAddRadioItem2.setGroup(getMedicalCoordinateAddRadioGroup());

      medicalCoordinateAddRadioItem2.setConstraints(VRLayout.FLOW);

      addMedicalCoordinateAddRadioItem2();
    }
    return medicalCoordinateAddRadioItem2;

  }

  /**
   * �Ŏ������Z���擾���܂��B
   * @return �Ŏ������Z
   */
  public ACValueArrayRadioButtonGroup getWatchCareRadioGroup(){
    if(watchCareRadioGroup==null){

      watchCareRadioGroup = new ACValueArrayRadioButtonGroup();

      getWatchCareRadioGroupContainer().setText("�Ŏ������Z");

      watchCareRadioGroup.setBindPath("1360106");

      watchCareRadioGroup.setUseClearButton(false);

      watchCareRadioGroup.setModel(getWatchCareRadioGroupModel());

      watchCareRadioGroup.setValues(new int[]{1,2,3,4});

      addWatchCareRadioGroup();
    }
    return watchCareRadioGroup;

  }

  /**
   * �Ŏ������Z�R���e�i���擾���܂��B
   * @return �Ŏ������Z�R���e�i
   */
  protected ACLabelContainer getWatchCareRadioGroupContainer(){
    if(watchCareRadioGroupContainer==null){
      watchCareRadioGroupContainer = new ACLabelContainer();
      watchCareRadioGroupContainer.setFollowChildEnabled(true);
      watchCareRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      watchCareRadioGroupContainer.add(getWatchCareRadioGroup(), null);
    }
    return watchCareRadioGroupContainer;
  }

  /**
   * �Ŏ������Z���f�����擾���܂��B
   * @return �Ŏ������Z���f��
   */
  protected ACListModelAdapter getWatchCareRadioGroupModel(){
    if(watchCareRadioGroupModel==null){
      watchCareRadioGroupModel = new ACListModelAdapter();
      addWatchCareRadioGroupModel();
    }
    return watchCareRadioGroupModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getWatchCareRadioItem1(){
    if(watchCareRadioItem1==null){

      watchCareRadioItem1 = new ACRadioButtonItem();

      watchCareRadioItem1.setText("�Ȃ�");

      watchCareRadioItem1.setGroup(getWatchCareRadioGroup());

      watchCareRadioItem1.setConstraints(VRLayout.FLOW_RETURN);

      addWatchCareRadioItem1();
    }
    return watchCareRadioItem1;

  }

  /**
   * ���S���ȑO4���ȏ�30���ȉ����擾���܂��B
   * @return ���S���ȑO4���ȏ�30���ȉ�
   */
  public ACRadioButtonItem getWatchCareRadioItem2(){
    if(watchCareRadioItem2==null){

      watchCareRadioItem2 = new ACRadioButtonItem();

      watchCareRadioItem2.setText("���S���ȑO4���ȏ�30���ȉ�");

      watchCareRadioItem2.setGroup(getWatchCareRadioGroup());

      watchCareRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

      addWatchCareRadioItem2();
    }
    return watchCareRadioItem2;

  }

  /**
   * ���S���ȑO2������3�����擾���܂��B
   * @return ���S���ȑO2������3��
   */
  public ACRadioButtonItem getWatchCareRadioItem3(){
    if(watchCareRadioItem3==null){

      watchCareRadioItem3 = new ACRadioButtonItem();

      watchCareRadioItem3.setText("���S���ȑO2������3��");

      watchCareRadioItem3.setGroup(getWatchCareRadioGroup());

      watchCareRadioItem3.setConstraints(VRLayout.FLOW_RETURN);

      addWatchCareRadioItem3();
    }
    return watchCareRadioItem3;

  }

  /**
   * ���S�����擾���܂��B
   * @return ���S��
   */
  public ACRadioButtonItem getWatchCareRadioItem4(){
    if(watchCareRadioItem4==null){

      watchCareRadioItem4 = new ACRadioButtonItem();

      watchCareRadioItem4.setText("���S��");

      watchCareRadioItem4.setGroup(getWatchCareRadioGroup());

      watchCareRadioItem4.setConstraints(VRLayout.FLOW);

      addWatchCareRadioItem4();
    }
    return watchCareRadioItem4;

  }

  /**
   * �F�m�ǐ��P�A���Z���擾���܂��B
   * @return �F�m�ǐ��P�A���Z
   */
  public ACValueArrayRadioButtonGroup getDementiaProfessionalCareAddRadioGroup(){
    if(dementiaProfessionalCareAddRadioGroup==null){

      dementiaProfessionalCareAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getDementiaProfessionalCareAddRadioGroupContainer().setText("�F�m�ǐ��P�A���Z");

      dementiaProfessionalCareAddRadioGroup.setBindPath("1360107");

      dementiaProfessionalCareAddRadioGroup.setVisible(true);

      dementiaProfessionalCareAddRadioGroup.setEnabled(true);

      dementiaProfessionalCareAddRadioGroup.setNoSelectIndex(0);

      dementiaProfessionalCareAddRadioGroup.setUseClearButton(false);

      dementiaProfessionalCareAddRadioGroup.setModel(getDementiaProfessionalCareAddRadioGroupModel());

      dementiaProfessionalCareAddRadioGroup.setValues(new int[]{1,2,3});

      addDementiaProfessionalCareAddRadioGroup();
    }
    return dementiaProfessionalCareAddRadioGroup;

  }

  /**
   * �F�m�ǐ��P�A���Z�R���e�i���擾���܂��B
   * @return �F�m�ǐ��P�A���Z�R���e�i
   */
  protected ACLabelContainer getDementiaProfessionalCareAddRadioGroupContainer(){
    if(dementiaProfessionalCareAddRadioGroupContainer==null){
      dementiaProfessionalCareAddRadioGroupContainer = new ACLabelContainer();
      dementiaProfessionalCareAddRadioGroupContainer.setFollowChildEnabled(true);
      dementiaProfessionalCareAddRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      dementiaProfessionalCareAddRadioGroupContainer.add(getDementiaProfessionalCareAddRadioGroup(), null);
    }
    return dementiaProfessionalCareAddRadioGroupContainer;
  }

  /**
   * �F�m�ǐ��P�A���Z���f�����擾���܂��B
   * @return �F�m�ǐ��P�A���Z���f��
   */
  protected ACListModelAdapter getDementiaProfessionalCareAddRadioGroupModel(){
    if(dementiaProfessionalCareAddRadioGroupModel==null){
      dementiaProfessionalCareAddRadioGroupModel = new ACListModelAdapter();
      addDementiaProfessionalCareAddRadioGroupModel();
    }
    return dementiaProfessionalCareAddRadioGroupModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getDementiaProfessionalCareAddRadioItem1(){
    if(dementiaProfessionalCareAddRadioItem1==null){

      dementiaProfessionalCareAddRadioItem1 = new ACRadioButtonItem();

      dementiaProfessionalCareAddRadioItem1.setText("�Ȃ�");

      dementiaProfessionalCareAddRadioItem1.setGroup(getDementiaProfessionalCareAddRadioGroup());

      dementiaProfessionalCareAddRadioItem1.setConstraints(VRLayout.FLOW);

      addDementiaProfessionalCareAddRadioItem1();
    }
    return dementiaProfessionalCareAddRadioItem1;

  }

  /**
   * I�^���擾���܂��B
   * @return I�^
   */
  public ACRadioButtonItem getDementiaProfessionalCareAddRadioItem2(){
    if(dementiaProfessionalCareAddRadioItem2==null){

      dementiaProfessionalCareAddRadioItem2 = new ACRadioButtonItem();

      dementiaProfessionalCareAddRadioItem2.setText("I�^");

      dementiaProfessionalCareAddRadioItem2.setGroup(getDementiaProfessionalCareAddRadioGroup());

      dementiaProfessionalCareAddRadioItem2.setConstraints(VRLayout.FLOW);

      addDementiaProfessionalCareAddRadioItem2();
    }
    return dementiaProfessionalCareAddRadioItem2;

  }

  /**
   * II�^���擾���܂��B
   * @return II�^
   */
  public ACRadioButtonItem getDementiaProfessionalCareAddRadioItem3(){
    if(dementiaProfessionalCareAddRadioItem3==null){

      dementiaProfessionalCareAddRadioItem3 = new ACRadioButtonItem();

      dementiaProfessionalCareAddRadioItem3.setText("II�^");

      dementiaProfessionalCareAddRadioItem3.setGroup(getDementiaProfessionalCareAddRadioGroup());

      dementiaProfessionalCareAddRadioItem3.setConstraints(VRLayout.FLOW);

      addDementiaProfessionalCareAddRadioItem3();
    }
    return dementiaProfessionalCareAddRadioItem3;

  }

  /**
   * �T�[�r�X�񋟑̐��������Z���擾���܂��B
   * @return �T�[�r�X�񋟑̐��������Z
   */
  public ACValueArrayRadioButtonGroup getServiceAddProvisionStructuralRadioGroup(){
    if(serviceAddProvisionStructuralRadioGroup==null){

      serviceAddProvisionStructuralRadioGroup = new ACValueArrayRadioButtonGroup();

      getServiceAddProvisionStructuralRadioGroupContainer().setText("�T�[�r�X�񋟑̐��������Z");

      serviceAddProvisionStructuralRadioGroup.setBindPath("1360108");

      serviceAddProvisionStructuralRadioGroup.setVisible(true);

      serviceAddProvisionStructuralRadioGroup.setEnabled(true);

      serviceAddProvisionStructuralRadioGroup.setNoSelectIndex(0);

      serviceAddProvisionStructuralRadioGroup.setUseClearButton(false);

      serviceAddProvisionStructuralRadioGroup.setModel(getServiceAddProvisionStructuralRadioGroupModel());

      serviceAddProvisionStructuralRadioGroup.setValues(new int[]{1,2,3,4,5});

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
  public ACRadioButtonItem getServiceAddProvisionStructuralRadioItem3(){
    if(serviceAddProvisionStructuralRadioItem3==null){

      serviceAddProvisionStructuralRadioItem3 = new ACRadioButtonItem();

      serviceAddProvisionStructuralRadioItem3.setText("I���^");

      serviceAddProvisionStructuralRadioItem3.setGroup(getServiceAddProvisionStructuralRadioGroup());

      serviceAddProvisionStructuralRadioItem3.setConstraints(VRLayout.FLOW);

      addServiceAddProvisionStructuralRadioItem3();
    }
    return serviceAddProvisionStructuralRadioItem3;

  }

  /**
   * II�^���擾���܂��B
   * @return II�^
   */
  public ACRadioButtonItem getServiceAddProvisionStructuralRadioItem4(){
    if(serviceAddProvisionStructuralRadioItem4==null){

      serviceAddProvisionStructuralRadioItem4 = new ACRadioButtonItem();

      serviceAddProvisionStructuralRadioItem4.setText("II�^");

      serviceAddProvisionStructuralRadioItem4.setGroup(getServiceAddProvisionStructuralRadioGroup());

      serviceAddProvisionStructuralRadioItem4.setConstraints(VRLayout.FLOW);

      addServiceAddProvisionStructuralRadioItem4();
    }
    return serviceAddProvisionStructuralRadioItem4;

  }

  /**
   * III�^���擾���܂��B
   * @return III�^
   */
  public ACRadioButtonItem getServiceAddProvisionStructuralRadioItem5(){
    if(serviceAddProvisionStructuralRadioItem5==null){

      serviceAddProvisionStructuralRadioItem5 = new ACRadioButtonItem();

      serviceAddProvisionStructuralRadioItem5.setText("III�^");

      serviceAddProvisionStructuralRadioItem5.setGroup(getServiceAddProvisionStructuralRadioGroup());

      serviceAddProvisionStructuralRadioItem5.setConstraints(VRLayout.FLOW);

      addServiceAddProvisionStructuralRadioItem5();
    }
    return serviceAddProvisionStructuralRadioItem5;

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
   * �g�̍S���p�~�����{���Z���擾���܂��B
   * @return �g�̍S���p�~�����{���Z
   */
  public ACValueArrayRadioButtonGroup getPhysicalRestraintNotRepealed(){
    if(physicalRestraintNotRepealed==null){

      physicalRestraintNotRepealed = new ACValueArrayRadioButtonGroup();

      getPhysicalRestraintNotRepealedContainer().setText("�g�̍S���p�~�����{���Z");

      physicalRestraintNotRepealed.setBindPath("1360109");

      physicalRestraintNotRepealed.setUseClearButton(false);

      physicalRestraintNotRepealed.setModel(getPhysicalRestraintNotRepealedModel());

      physicalRestraintNotRepealed.setValues(new int[]{1,2});

      addPhysicalRestraintNotRepealed();
    }
    return physicalRestraintNotRepealed;

  }

  /**
   * �g�̍S���p�~�����{���Z�R���e�i���擾���܂��B
   * @return �g�̍S���p�~�����{���Z�R���e�i
   */
  protected ACLabelContainer getPhysicalRestraintNotRepealedContainer(){
    if(physicalRestraintNotRepealedContainer==null){
      physicalRestraintNotRepealedContainer = new ACLabelContainer();
      physicalRestraintNotRepealedContainer.setFollowChildEnabled(true);
      physicalRestraintNotRepealedContainer.setVAlignment(VRLayout.CENTER);
      physicalRestraintNotRepealedContainer.add(getPhysicalRestraintNotRepealed(), null);
    }
    return physicalRestraintNotRepealedContainer;
  }

  /**
   * �g�̍S���p�~�����{���Z���f�����擾���܂��B
   * @return �g�̍S���p�~�����{���Z���f��
   */
  protected ACListModelAdapter getPhysicalRestraintNotRepealedModel(){
    if(physicalRestraintNotRepealedModel==null){
      physicalRestraintNotRepealedModel = new ACListModelAdapter();
      addPhysicalRestraintNotRepealedModel();
    }
    return physicalRestraintNotRepealedModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getPhysicalRestraintNotRepealedItem1(){
    if(physicalRestraintNotRepealedItem1==null){

      physicalRestraintNotRepealedItem1 = new ACRadioButtonItem();

      physicalRestraintNotRepealedItem1.setText("�Ȃ�");

      physicalRestraintNotRepealedItem1.setGroup(getPhysicalRestraintNotRepealed());

      addPhysicalRestraintNotRepealedItem1();
    }
    return physicalRestraintNotRepealedItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getPhysicalRestraintNotRepealedItem2(){
    if(physicalRestraintNotRepealedItem2==null){

      physicalRestraintNotRepealedItem2 = new ACRadioButtonItem();

      physicalRestraintNotRepealedItem2.setText("����");

      physicalRestraintNotRepealedItem2.setGroup(getPhysicalRestraintNotRepealed());

      addPhysicalRestraintNotRepealedItem2();
    }
    return physicalRestraintNotRepealedItem2;

  }

  /**
   * �����p���x�����Z���擾���܂��B
   * @return �����p���x�����Z
   */
  public ACValueArrayRadioButtonGroup getSupportForContinuedTenancy(){
    if(supportForContinuedTenancy==null){

      supportForContinuedTenancy = new ACValueArrayRadioButtonGroup();

      getSupportForContinuedTenancyContainer().setText("�����p���x�����Z");

      supportForContinuedTenancy.setBindPath("1360110");

      supportForContinuedTenancy.setUseClearButton(false);

      supportForContinuedTenancy.setModel(getSupportForContinuedTenancyModel());

      supportForContinuedTenancy.setValues(new int[]{1,2});

      addSupportForContinuedTenancy();
    }
    return supportForContinuedTenancy;

  }

  /**
   * �����p���x�����Z�R���e�i���擾���܂��B
   * @return �����p���x�����Z�R���e�i
   */
  protected ACLabelContainer getSupportForContinuedTenancyContainer(){
    if(supportForContinuedTenancyContainer==null){
      supportForContinuedTenancyContainer = new ACLabelContainer();
      supportForContinuedTenancyContainer.setFollowChildEnabled(true);
      supportForContinuedTenancyContainer.setVAlignment(VRLayout.CENTER);
      supportForContinuedTenancyContainer.add(getSupportForContinuedTenancy(), null);
    }
    return supportForContinuedTenancyContainer;
  }

  /**
   * �����p���x�����Z���f�����擾���܂��B
   * @return �����p���x�����Z���f��
   */
  protected ACListModelAdapter getSupportForContinuedTenancyModel(){
    if(supportForContinuedTenancyModel==null){
      supportForContinuedTenancyModel = new ACListModelAdapter();
      addSupportForContinuedTenancyModel();
    }
    return supportForContinuedTenancyModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getSupportForContinuedTenancyItem1(){
    if(supportForContinuedTenancyItem1==null){

      supportForContinuedTenancyItem1 = new ACRadioButtonItem();

      supportForContinuedTenancyItem1.setText("�Ȃ�");

      supportForContinuedTenancyItem1.setGroup(getSupportForContinuedTenancy());

      addSupportForContinuedTenancyItem1();
    }
    return supportForContinuedTenancyItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getSupportForContinuedTenancyItem2(){
    if(supportForContinuedTenancyItem2==null){

      supportForContinuedTenancyItem2 = new ACRadioButtonItem();

      supportForContinuedTenancyItem2.setText("����");

      supportForContinuedTenancyItem2.setGroup(getSupportForContinuedTenancy());

      addSupportForContinuedTenancyItem2();
    }
    return supportForContinuedTenancyItem2;

  }

  /**
   * �����@�\����A�g���Z���擾���܂��B
   * @return �����@�\����A�g���Z
   */
  public ACValueArrayRadioButtonGroup getImprovementCollaboration(){
    if(improvementCollaboration==null){

      improvementCollaboration = new ACValueArrayRadioButtonGroup();

      getImprovementCollaborationContainer().setText("�����@�\����A�g���Z");

      improvementCollaboration.setBindPath("1360111");

      improvementCollaboration.setUseClearButton(false);

      improvementCollaboration.setModel(getImprovementCollaborationModel());

      improvementCollaboration.setValues(new int[]{1,2});

      addImprovementCollaboration();
    }
    return improvementCollaboration;

  }

  /**
   * �����@�\����A�g���Z�R���e�i���擾���܂��B
   * @return �����@�\����A�g���Z�R���e�i
   */
  protected ACLabelContainer getImprovementCollaborationContainer(){
    if(improvementCollaborationContainer==null){
      improvementCollaborationContainer = new ACLabelContainer();
      improvementCollaborationContainer.setFollowChildEnabled(true);
      improvementCollaborationContainer.setVAlignment(VRLayout.CENTER);
      improvementCollaborationContainer.add(getImprovementCollaboration(), null);
    }
    return improvementCollaborationContainer;
  }

  /**
   * �����@�\����A�g���Z���f�����擾���܂��B
   * @return �����@�\����A�g���Z���f��
   */
  protected ACListModelAdapter getImprovementCollaborationModel(){
    if(improvementCollaborationModel==null){
      improvementCollaborationModel = new ACListModelAdapter();
      addImprovementCollaborationModel();
    }
    return improvementCollaborationModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getImprovementCollaborationItem1(){
    if(improvementCollaborationItem1==null){

      improvementCollaborationItem1 = new ACRadioButtonItem();

      improvementCollaborationItem1.setText("�Ȃ�");

      improvementCollaborationItem1.setGroup(getImprovementCollaboration());

      addImprovementCollaborationItem1();
    }
    return improvementCollaborationItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getImprovementCollaborationItem2(){
    if(improvementCollaborationItem2==null){

      improvementCollaborationItem2 = new ACRadioButtonItem();

      improvementCollaborationItem2.setText("����");

      improvementCollaborationItem2.setGroup(getImprovementCollaboration());

      addImprovementCollaborationItem2();
    }
    return improvementCollaborationItem2;

  }

  /**
   * ��N���F�m�ǎ�����Z���擾���܂��B
   * @return ��N���F�m�ǎ�����Z
   */
  public ACValueArrayRadioButtonGroup getYoungDementiaPatinetAddRadioGroup(){
    if(youngDementiaPatinetAddRadioGroup==null){

      youngDementiaPatinetAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getYoungDementiaPatinetAddRadioGroupContainer().setText("��N���F�m�ǎ�����Z");

      youngDementiaPatinetAddRadioGroup.setBindPath("1360112");

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
   * ���o�q���Ǘ��̐����Z���擾���܂��B
   * @return ���o�q���Ǘ��̐����Z
   */
  public ACValueArrayRadioButtonGroup getOralHygieneControlSystem(){
    if(oralHygieneControlSystem==null){

      oralHygieneControlSystem = new ACValueArrayRadioButtonGroup();

      getOralHygieneControlSystemContainer().setText("���o�q���Ǘ��̐����Z");

      oralHygieneControlSystem.setBindPath("1360113");

      oralHygieneControlSystem.setUseClearButton(false);

      oralHygieneControlSystem.setModel(getOralHygieneControlSystemModel());

      oralHygieneControlSystem.setValues(new int[]{1,2});

      addOralHygieneControlSystem();
    }
    return oralHygieneControlSystem;

  }

  /**
   * ���o�q���Ǘ��̐����Z�R���e�i���擾���܂��B
   * @return ���o�q���Ǘ��̐����Z�R���e�i
   */
  protected ACLabelContainer getOralHygieneControlSystemContainer(){
    if(oralHygieneControlSystemContainer==null){
      oralHygieneControlSystemContainer = new ACLabelContainer();
      oralHygieneControlSystemContainer.setFollowChildEnabled(true);
      oralHygieneControlSystemContainer.setVAlignment(VRLayout.CENTER);
      oralHygieneControlSystemContainer.add(getOralHygieneControlSystem(), null);
    }
    return oralHygieneControlSystemContainer;
  }

  /**
   * ���o�q���Ǘ��̐����Z���f�����擾���܂��B
   * @return ���o�q���Ǘ��̐����Z���f��
   */
  protected ACListModelAdapter getOralHygieneControlSystemModel(){
    if(oralHygieneControlSystemModel==null){
      oralHygieneControlSystemModel = new ACListModelAdapter();
      addOralHygieneControlSystemModel();
    }
    return oralHygieneControlSystemModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getOralHygieneControlSystemItem1(){
    if(oralHygieneControlSystemItem1==null){

      oralHygieneControlSystemItem1 = new ACRadioButtonItem();

      oralHygieneControlSystemItem1.setText("�Ȃ�");

      oralHygieneControlSystemItem1.setGroup(getOralHygieneControlSystem());

      addOralHygieneControlSystemItem1();
    }
    return oralHygieneControlSystemItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getOralHygieneControlSystemItem2(){
    if(oralHygieneControlSystemItem2==null){

      oralHygieneControlSystemItem2 = new ACRadioButtonItem();

      oralHygieneControlSystemItem2.setText("����");

      oralHygieneControlSystemItem2.setGroup(getOralHygieneControlSystem());

      addOralHygieneControlSystemItem2();
    }
    return oralHygieneControlSystemItem2;

  }

  /**
   * �h�{�X�N���[�j���O���Z���擾���܂��B
   * @return �h�{�X�N���[�j���O���Z
   */
  public ACValueArrayRadioButtonGroup getNutritionScreening(){
    if(nutritionScreening==null){

      nutritionScreening = new ACValueArrayRadioButtonGroup();

      getNutritionScreeningContainer().setText("�h�{�X�N���[�j���O���Z");

      nutritionScreening.setBindPath("1360114");

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
   * �މ@�E�ޏ����A�g���Z���擾���܂��B
   * @return �މ@�E�ޏ����A�g���Z
   */
  public ACValueArrayRadioButtonGroup getCollaborationAtDischargeRadioGroup(){
    if(collaborationAtDischargeRadioGroup==null){

      collaborationAtDischargeRadioGroup = new ACValueArrayRadioButtonGroup();

      getCollaborationAtDischargeRadioGroupContainer().setText("�މ@�E�ޏ����A�g���Z");

      collaborationAtDischargeRadioGroup.setBindPath("1360115");

      collaborationAtDischargeRadioGroup.setNoSelectIndex(0);

      collaborationAtDischargeRadioGroup.setUseClearButton(false);

      collaborationAtDischargeRadioGroup.setModel(getCollaborationAtDischargeRadioGroupModel());

      collaborationAtDischargeRadioGroup.setValues(new int[]{1,2});

      addCollaborationAtDischargeRadioGroup();
    }
    return collaborationAtDischargeRadioGroup;

  }

  /**
   * �މ@�E�ޏ����A�g���Z�R���e�i���擾���܂��B
   * @return �މ@�E�ޏ����A�g���Z�R���e�i
   */
  protected ACLabelContainer getCollaborationAtDischargeRadioGroupContainer(){
    if(collaborationAtDischargeRadioGroupContainer==null){
      collaborationAtDischargeRadioGroupContainer = new ACLabelContainer();
      collaborationAtDischargeRadioGroupContainer.setFollowChildEnabled(true);
      collaborationAtDischargeRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      collaborationAtDischargeRadioGroupContainer.add(getCollaborationAtDischargeRadioGroup(), null);
    }
    return collaborationAtDischargeRadioGroupContainer;
  }

  /**
   * �މ@�E�ޏ����A�g���Z���f�����擾���܂��B
   * @return �މ@�E�ޏ����A�g���Z���f��
   */
  protected ACListModelAdapter getCollaborationAtDischargeRadioGroupModel(){
    if(collaborationAtDischargeRadioGroupModel==null){
      collaborationAtDischargeRadioGroupModel = new ACListModelAdapter();
      addCollaborationAtDischargeRadioGroupModel();
    }
    return collaborationAtDischargeRadioGroupModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getCollaborationAtDischargeRadioItem1(){
    if(collaborationAtDischargeRadioItem1==null){

      collaborationAtDischargeRadioItem1 = new ACRadioButtonItem();

      collaborationAtDischargeRadioItem1.setText("�Ȃ�");

      collaborationAtDischargeRadioItem1.setGroup(getCollaborationAtDischargeRadioGroup());

      collaborationAtDischargeRadioItem1.setConstraints(VRLayout.FLOW);

      addCollaborationAtDischargeRadioItem1();
    }
    return collaborationAtDischargeRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getCollaborationAtDischargeRadioItem2(){
    if(collaborationAtDischargeRadioItem2==null){

      collaborationAtDischargeRadioItem2 = new ACRadioButtonItem();

      collaborationAtDischargeRadioItem2.setText("����");

      collaborationAtDischargeRadioItem2.setGroup(getCollaborationAtDischargeRadioGroup());

      collaborationAtDischargeRadioItem2.setConstraints(VRLayout.FLOW);

      addCollaborationAtDischargeRadioItem2();
    }
    return collaborationAtDischargeRadioItem2;

  }

  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001_13611_201804Design() {

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

    this.add(getRegionSpecificFacilityPatterns(), VRLayout.CLIENT);

  }

  /**
   * �n�斧������{�ݓ����Ґ������p�^�[���̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addRegionSpecificFacilityPatterns(){

    regionSpecificFacilityPatterns.add(getTabs(), VRLayout.CLIENT);

  }

  /**
   * �^�u�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTabs(){

    tabs.addTab("1", getTab1());

    tabs.addTab("2", getTab2());

  }

  /**
   * �^�u1�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTab1(){

    tab1.add(getRegionStaffSubtractionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getRegionTrainingRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getRegionNightStandardRadioContainer(), VRLayout.FLOW_RETURN);

    tab1.add(getMedicalCoordinateAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getWatchCareRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getDementiaProfessionalCareAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getServiceAddProvisionStructuralRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * �l�����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addRegionStaffSubtractionRadio(){

  }

  /**
   * �l�����Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addRegionStaffSubtractionRadioModel(){

    getRegionSubtractionNo().setButtonIndex(1);

    getRegionStaffSubtractionRadioModel().add(getRegionSubtractionNo());

    getRegionSubtractionPersonLack().setButtonIndex(2);

    getRegionStaffSubtractionRadioModel().add(getRegionSubtractionPersonLack());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addRegionSubtractionNo(){

  }

  /**
   * �Ō�E���E���̕s���ɓ������ڂ�ǉ����܂��B
   */
  protected void addRegionSubtractionPersonLack(){

  }

  /**
   * �ʋ@�\�P���w���̐����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addRegionTrainingRadio(){

  }

  /**
   * �ʋ@�\�P���w���̐����Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addRegionTrainingRadioModel(){

    getRegionTrainingRadioItem1().setButtonIndex(1);

    getRegionTrainingRadioModel().add(getRegionTrainingRadioItem1());

    getRegionTrainingRadioItem2().setButtonIndex(2);

    getRegionTrainingRadioModel().add(getRegionTrainingRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addRegionTrainingRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addRegionTrainingRadioItem2(){

  }

  /**
   * ��ԊŌ�̐����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addRegionNightStandardRadio(){

  }

  /**
   * ��ԊŌ�̐����Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addRegionNightStandardRadioModel(){

    getRegionNightStandardRadioItem1().setButtonIndex(1);

    getRegionNightStandardRadioModel().add(getRegionNightStandardRadioItem1());

    getRegionNightStandardRadioItem2().setButtonIndex(2);

    getRegionNightStandardRadioModel().add(getRegionNightStandardRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addRegionNightStandardRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addRegionNightStandardRadioItem2(){

  }

  /**
   * ��Ë@�֘A�g���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalCoordinateAddRadioGroup(){

  }

  /**
   * ��Ë@�֘A�g���Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalCoordinateAddRadioGroupModel(){

    getMedicalCoordinateAddRadioItem1().setButtonIndex(1);

    getMedicalCoordinateAddRadioGroupModel().add(getMedicalCoordinateAddRadioItem1());

    getMedicalCoordinateAddRadioItem2().setButtonIndex(2);

    getMedicalCoordinateAddRadioGroupModel().add(getMedicalCoordinateAddRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalCoordinateAddRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalCoordinateAddRadioItem2(){

  }

  /**
   * �Ŏ������Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addWatchCareRadioGroup(){

  }

  /**
   * �Ŏ������Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addWatchCareRadioGroupModel(){

    getWatchCareRadioItem1().setButtonIndex(1);

    getWatchCareRadioGroupModel().add(getWatchCareRadioItem1());

    getWatchCareRadioItem2().setButtonIndex(2);

    getWatchCareRadioGroupModel().add(getWatchCareRadioItem2());

    getWatchCareRadioItem3().setButtonIndex(3);

    getWatchCareRadioGroupModel().add(getWatchCareRadioItem3());

    getWatchCareRadioItem4().setButtonIndex(4);

    getWatchCareRadioGroupModel().add(getWatchCareRadioItem4());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addWatchCareRadioItem1(){

  }

  /**
   * ���S���ȑO4���ȏ�30���ȉ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addWatchCareRadioItem2(){

  }

  /**
   * ���S���ȑO2������3���ɓ������ڂ�ǉ����܂��B
   */
  protected void addWatchCareRadioItem3(){

  }

  /**
   * ���S���ɓ������ڂ�ǉ����܂��B
   */
  protected void addWatchCareRadioItem4(){

  }

  /**
   * �F�m�ǐ��P�A���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addDementiaProfessionalCareAddRadioGroup(){

  }

  /**
   * �F�m�ǐ��P�A���Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addDementiaProfessionalCareAddRadioGroupModel(){

    getDementiaProfessionalCareAddRadioItem1().setButtonIndex(1);

    getDementiaProfessionalCareAddRadioGroupModel().add(getDementiaProfessionalCareAddRadioItem1());

    getDementiaProfessionalCareAddRadioItem2().setButtonIndex(2);

    getDementiaProfessionalCareAddRadioGroupModel().add(getDementiaProfessionalCareAddRadioItem2());

    getDementiaProfessionalCareAddRadioItem3().setButtonIndex(3);

    getDementiaProfessionalCareAddRadioGroupModel().add(getDementiaProfessionalCareAddRadioItem3());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addDementiaProfessionalCareAddRadioItem1(){

  }

  /**
   * I�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addDementiaProfessionalCareAddRadioItem2(){

  }

  /**
   * II�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addDementiaProfessionalCareAddRadioItem3(){

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

    getServiceAddProvisionStructuralRadioItem4().setButtonIndex(4);

    getServiceAddProvisionStructuralRadioGroupModel().add(getServiceAddProvisionStructuralRadioItem4());

    getServiceAddProvisionStructuralRadioItem5().setButtonIndex(5);

    getServiceAddProvisionStructuralRadioGroupModel().add(getServiceAddProvisionStructuralRadioItem5());

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
  protected void addServiceAddProvisionStructuralRadioItem3(){

  }

  /**
   * II�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceAddProvisionStructuralRadioItem4(){

  }

  /**
   * III�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceAddProvisionStructuralRadioItem5(){

  }

  /**
   * �^�u2�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTab2(){

    tab2.add(getPhysicalRestraintNotRepealedContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getSupportForContinuedTenancyContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getImprovementCollaborationContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getYoungDementiaPatinetAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getOralHygieneControlSystemContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getNutritionScreeningContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getCollaborationAtDischargeRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * �g�̍S���p�~�����{���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPhysicalRestraintNotRepealed(){

  }

  /**
   * �g�̍S���p�~�����{���Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addPhysicalRestraintNotRepealedModel(){

    getPhysicalRestraintNotRepealedItem1().setButtonIndex(1);

    getPhysicalRestraintNotRepealedModel().add(getPhysicalRestraintNotRepealedItem1());

    getPhysicalRestraintNotRepealedItem2().setButtonIndex(2);

    getPhysicalRestraintNotRepealedModel().add(getPhysicalRestraintNotRepealedItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addPhysicalRestraintNotRepealedItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addPhysicalRestraintNotRepealedItem2(){

  }

  /**
   * �����p���x�����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addSupportForContinuedTenancy(){

  }

  /**
   * �����p���x�����Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addSupportForContinuedTenancyModel(){

    getSupportForContinuedTenancyItem1().setButtonIndex(1);

    getSupportForContinuedTenancyModel().add(getSupportForContinuedTenancyItem1());

    getSupportForContinuedTenancyItem2().setButtonIndex(2);

    getSupportForContinuedTenancyModel().add(getSupportForContinuedTenancyItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addSupportForContinuedTenancyItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addSupportForContinuedTenancyItem2(){

  }

  /**
   * �����@�\����A�g���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addImprovementCollaboration(){

  }

  /**
   * �����@�\����A�g���Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addImprovementCollaborationModel(){

    getImprovementCollaborationItem1().setButtonIndex(1);

    getImprovementCollaborationModel().add(getImprovementCollaborationItem1());

    getImprovementCollaborationItem2().setButtonIndex(2);

    getImprovementCollaborationModel().add(getImprovementCollaborationItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addImprovementCollaborationItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addImprovementCollaborationItem2(){

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
   * ���o�q���Ǘ��̐����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addOralHygieneControlSystem(){

  }

  /**
   * ���o�q���Ǘ��̐����Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addOralHygieneControlSystemModel(){

    getOralHygieneControlSystemItem1().setButtonIndex(1);

    getOralHygieneControlSystemModel().add(getOralHygieneControlSystemItem1());

    getOralHygieneControlSystemItem2().setButtonIndex(2);

    getOralHygieneControlSystemModel().add(getOralHygieneControlSystemItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addOralHygieneControlSystemItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addOralHygieneControlSystemItem2(){

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
   * �މ@�E�ޏ����A�g���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addCollaborationAtDischargeRadioGroup(){

  }

  /**
   * �މ@�E�ޏ����A�g���Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCollaborationAtDischargeRadioGroupModel(){

    getCollaborationAtDischargeRadioItem1().setButtonIndex(1);

    getCollaborationAtDischargeRadioGroupModel().add(getCollaborationAtDischargeRadioItem1());

    getCollaborationAtDischargeRadioItem2().setButtonIndex(2);

    getCollaborationAtDischargeRadioGroupModel().add(getCollaborationAtDischargeRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addCollaborationAtDischargeRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addCollaborationAtDischargeRadioItem2(){

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
      ACFrame.debugStart(new ACAffairInfo(QS001_13611_201804Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QS001_13611_201804Design getThis() {
    return this;
  }
}
