
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
 * �쐬��: 2012/03/06  ���{�R���s���[�^�[������� ����@��F �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �\��Ǘ� (S)
 * �v���Z�X �T�[�r�X�\�� (001)
 * �v���O���� �T�[�r�X�p�^�[���K��Ō�i���j (QS001_11311_201204)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
import java.awt.Component;

import javax.swing.JTabbedPane;

import jp.nichicom.ac.component.ACIntegerCheckBox;
import jp.nichicom.ac.component.ACRadioButtonItem;
import jp.nichicom.ac.component.ACTimeComboBox;
import jp.nichicom.ac.component.ACValueArrayRadioButtonGroup;
import jp.nichicom.ac.container.ACBackLabelContainer;
import jp.nichicom.ac.container.ACLabelContainer;
import jp.nichicom.ac.container.ACPanel;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.util.adapter.ACComboBoxModelAdapter;
import jp.nichicom.ac.util.adapter.ACListModelAdapter;
import jp.nichicom.vr.layout.VRLayout;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
/**
 * �T�[�r�X�p�^�[���K��Ō�i���j��ʍ��ڃf�U�C��(QS001_11311_201204) 
 */
public class QS001_11311_201204Design extends QS001ServicePanel {
  //GUI�R���|�[�l���g

  private ACPanel houmonKangoKaigoPatterns;

  private JTabbedPane tabs;

  private ACPanel tab1;

  private ACValueArrayRadioButtonGroup houmonKangoKaigoFacilityType;

  private ACLabelContainer houmonKangoKaigoFacilityTypeContainer;

  private ACListModelAdapter houmonKangoKaigoFacilityTypeModel;

  private ACRadioButtonItem houmonKangoKaigoStation;

  private ACRadioButtonItem houmonKangoKaigoMedicalInstitution;

  private ACRadioButtonItem houmonKangoKaigoFacilityTypeItem3;

  private ACValueArrayRadioButtonGroup houmonKangoKaigoClass;

  private ACLabelContainer houmonKangoKaigoClassContainer;

  private ACListModelAdapter houmonKangoKaigoClassModel;

  private ACRadioButtonItem houmonKangoKaigoClass1;

  private ACRadioButtonItem houmonKangoKaigoClass2;

  private ACRadioButtonItem houmonKangoKaigoClass3;

  private ACValueArrayRadioButtonGroup houmonKangoKaigoTime;

  private ACLabelContainer houmonKangoKaigoTimeContainer;

  private ACListModelAdapter houmonKangoKaigoTimeModel;

  private ACRadioButtonItem houmonKangoKaigoTime1;

  private ACRadioButtonItem houmonKangoKaigoTime2;

  private ACRadioButtonItem houmonKangoKaigoTime3;

  private ACRadioButtonItem houmonKangoKaigoTime4;

  private ACValueArrayRadioButtonGroup houmonKangoKaigoTimeZone;

  private ACLabelContainer houmonKangoKaigoTimeZoneContainer;

  private ACListModelAdapter houmonKangoKaigoTimeZoneModel;

  private ACRadioButtonItem houmonKangoKaigoTimeZoneNormal;

  private ACRadioButtonItem houmonKangoKaigoTimeZoneEarlyMorning;

  private ACRadioButtonItem houmonKangoKaigoTimeZoneNighttime;

  private ACRadioButtonItem houmonKangoKaigoTimeZoneMidnight;

  private ACValueArrayRadioButtonGroup specialManagementRadioGroup;

  private ACLabelContainer specialManagementRadioGroupContainer;

  private ACListModelAdapter specialManagementRadioGroupModel;

  private ACRadioButtonItem specialManagementRadioItem1;

  private ACRadioButtonItem specialManagementRadioItem2;

  private ACRadioButtonItem specialManagementRadioItem3;

  private ACIntegerCheckBox twoOrMoreTimesCheck;

  private ACIntegerCheckBox crackOnDayCheck;

  private ACIntegerCheckBox printable;

  private ACBackLabelContainer houmonKangoKaigoTimeContena;

  private ACTimeComboBox houmonKangoKaigoBeginTime;

  private ACLabelContainer houmonKangoKaigoBeginTimeContainer;

  private ACComboBoxModelAdapter houmonKangoKaigoBeginTimeModel;

  private ACTimeComboBox houmonKangoKaigoEndTime;

  private ACLabelContainer houmonKangoKaigoEndTimeContainer;

  private ACComboBoxModelAdapter houmonKangoKaigoEndTimeModel;

  private ACPanel tab2;

  private ACValueArrayRadioButtonGroup houmonKangoKaigoLongTime;

  private ACLabelContainer houmonKangoKaigoLongTimeContainer;

  private ACListModelAdapter houmonKangoKaigoLongTimeModel;

  private ACRadioButtonItem houmonKangoKaigoLongTimeItem1;

  private ACRadioButtonItem houmonKangoKaigoLongTimeItem2;

  private ACValueArrayRadioButtonGroup houmonKangoKaigoUrgentTimeRadio;

  private ACLabelContainer houmonKangoKaigoUrgentTimeRadioContainer;

  private ACListModelAdapter houmonKangoKaigoUrgentTimeRadioModel;

  private ACRadioButtonItem houmonKangoKaigoUrgentTimeRadioItem1;

  private ACRadioButtonItem houmonKangoKaigoUrgentTimeRadioItem2;

  private ACValueArrayRadioButtonGroup houmonKangoKaigoUrgentTime2Radio;

  private ACLabelContainer houmonKangoKaigoUrgentTime2RadioContainer;

  private ACListModelAdapter houmonKangoKaigoUrgentTime2RadioModel;

  private ACRadioButtonItem houmonKangoKaigoUrgentTime2RadioItem1;

  private ACRadioButtonItem houmonKangoKaigoUrgentTime2RadioItem2;

  private ACRadioButtonItem houmonKangoKaigoUrgentTime2RadioItem3;

  private ACValueArrayRadioButtonGroup houmonKangoKaigoTerminalRadio;

  private ACLabelContainer houmonKangoKaigoTerminalRadioContainer;

  private ACListModelAdapter houmonKangoKaigoTerminalRadioModel;

  private ACRadioButtonItem houmonKangoKaigoTerminalRadioItem1;

  private ACRadioButtonItem houmonKangoKaigoTerminalRadioItem2;

  private ACValueArrayRadioButtonGroup initialAddRadioGroup;

  private ACLabelContainer initialAddRadioGroupContainer;

  private ACListModelAdapter initialAddRadioGroupModel;

  private ACRadioButtonItem initialAddRadioItem1;

  private ACRadioButtonItem initialAddRadioItem2;

  private ACValueArrayRadioButtonGroup leavingHospitalGuidanceAddRadioGroup;

  private ACLabelContainer leavingHospitalGuidanceAddRadioGroupContainer;

  private ACListModelAdapter leavingHospitalGuidanceAddRadioGroupModel;

  private ACRadioButtonItem leavingHospitalGuidanceAddRadioItem1;

  private ACRadioButtonItem leavingHospitalGuidanceAddRadioItem2;

  private ACValueArrayRadioButtonGroup cooperationMedicalCareAddRadioGroup;

  private ACLabelContainer cooperationMedicalCareAddRadioGroupContainer;

  private ACListModelAdapter cooperationMedicalCareAddRadioGroupModel;

  private ACRadioButtonItem cooperationMedicalCareAddRadioItem1;

  private ACRadioButtonItem cooperationMedicalCareAddRadioItem2;

  private ACValueArrayRadioButtonGroup serviceAddProvisionStructuralRadioGroup;

  private ACLabelContainer serviceAddProvisionStructuralRadioGroupContainer;

  private ACListModelAdapter serviceAddProvisionStructuralRadioGroupModel;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem1;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem2;

  private ACValueArrayRadioButtonGroup houmonKangoNumberOfPeople;

  private ACLabelContainer houmonKangoNumberOfPeopleContainer;

  private ACListModelAdapter houmonKangoNumberOfPeopleModel;

  private ACRadioButtonItem houmonKangoNumberOfPeople1;

  private ACRadioButtonItem houmonKangoNumberOfPeople2;

  private ACValueArrayRadioButtonGroup houmonKangoNumberOfPeopleTime;

  private ACLabelContainer houmonKangoNumberOfPeopleTimeContainer;

  private ACListModelAdapter houmonKangoNumberOfPeopleTimeModel;

  private ACRadioButtonItem houmonKangoNumberOfPeopleTimeItem1;

  private ACRadioButtonItem houmonKangoNumberOfPeopleTimeItem2;

  private ACValueArrayRadioButtonGroup providerAddMountainousAreaRafioRadioGroup;

  private ACLabelContainer providerAddMountainousAreaRafioRadioGroupContainer;

  private ACListModelAdapter providerAddMountainousAreaRafioRadioGroupModel;

  private ACRadioButtonItem providerAddMountainousAreaRafioRadioItem1;

  private ACRadioButtonItem providerAddMountainousAreaRafioRadioItem2;

  private ACPanel tab3;

  private ACValueArrayRadioButtonGroup houmonNeededRadio;

  private ACLabelContainer houmonNeededRadioContainer;

  private ACListModelAdapter houmonNeededRadioModel;

  private ACRadioButtonItem houmonNeededRadioItem1;

  private ACRadioButtonItem houmonNeededRadioItem2;

  private ACValueArrayRadioButtonGroup houmonNissuReduceRadio;

  private ACLabelContainer houmonNissuReduceRadioContainer;

  private ACListModelAdapter houmonNissuReduceRadioModel;

  private ACRadioButtonItem houmonNissuReduceRadioItem1;

  private ACRadioButtonItem houmonNissuReduceRadioItem2;

  private ACValueArrayRadioButtonGroup calculationDivision;

  private ACLabelContainer calculationDivisionContainer;

  private ACListModelAdapter calculationDivisionModel;

  private ACRadioButtonItem calculationDivisionNormal;

  private ACRadioButtonItem calculationDivisionAddOnly;

  //getter

  /**
   * �K��Ō�i���j�p�^�[���̈�j���擾���܂��B
   * @return �K��Ō�i���j�p�^�[���̈�j
   */
  public ACPanel getHoumonKangoKaigoPatterns(){
    if(houmonKangoKaigoPatterns==null){

      houmonKangoKaigoPatterns = new ACPanel();

      houmonKangoKaigoPatterns.setFollowChildEnabled(true);

      addHoumonKangoKaigoPatterns();
    }
    return houmonKangoKaigoPatterns;

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

      addTab1();
    }
    return tab1;

  }

  /**
   * �K��Ō�{�ݎ�ʂ��擾���܂��B
   * @return �K��Ō�{�ݎ��
   */
  public ACValueArrayRadioButtonGroup getHoumonKangoKaigoFacilityType(){
    if(houmonKangoKaigoFacilityType==null){

      houmonKangoKaigoFacilityType = new ACValueArrayRadioButtonGroup();

      getHoumonKangoKaigoFacilityTypeContainer().setText("�{�ݓ��̋敪");

      houmonKangoKaigoFacilityType.setBindPath("1130103");

      houmonKangoKaigoFacilityType.setUseClearButton(false);

      houmonKangoKaigoFacilityType.setModel(getHoumonKangoKaigoFacilityTypeModel());

      houmonKangoKaigoFacilityType.setValues(new int[]{1,2,3});

      addHoumonKangoKaigoFacilityType();
    }
    return houmonKangoKaigoFacilityType;

  }

  /**
   * �K��Ō�{�ݎ�ʃR���e�i���擾���܂��B
   * @return �K��Ō�{�ݎ�ʃR���e�i
   */
  protected ACLabelContainer getHoumonKangoKaigoFacilityTypeContainer(){
    if(houmonKangoKaigoFacilityTypeContainer==null){
      houmonKangoKaigoFacilityTypeContainer = new ACLabelContainer();
      houmonKangoKaigoFacilityTypeContainer.setFollowChildEnabled(true);
      houmonKangoKaigoFacilityTypeContainer.setVAlignment(VRLayout.CENTER);
      houmonKangoKaigoFacilityTypeContainer.add(getHoumonKangoKaigoFacilityType(), null);
    }
    return houmonKangoKaigoFacilityTypeContainer;
  }

  /**
   * �K��Ō�{�ݎ�ʃ��f�����擾���܂��B
   * @return �K��Ō�{�ݎ�ʃ��f��
   */
  protected ACListModelAdapter getHoumonKangoKaigoFacilityTypeModel(){
    if(houmonKangoKaigoFacilityTypeModel==null){
      houmonKangoKaigoFacilityTypeModel = new ACListModelAdapter();
      addHoumonKangoKaigoFacilityTypeModel();
    }
    return houmonKangoKaigoFacilityTypeModel;
  }

  /**
   * �w��K��Ō�X�e�[�V�������擾���܂��B
   * @return �w��K��Ō�X�e�[�V����
   */
  public ACRadioButtonItem getHoumonKangoKaigoStation(){
    if(houmonKangoKaigoStation==null){

      houmonKangoKaigoStation = new ACRadioButtonItem();

      houmonKangoKaigoStation.setText("�w��K��Ō�X�e�[�V����");

      houmonKangoKaigoStation.setGroup(getHoumonKangoKaigoFacilityType());

      houmonKangoKaigoStation.setConstraints(VRLayout.FLOW_RETURN);

      addHoumonKangoKaigoStation();
    }
    return houmonKangoKaigoStation;

  }

  /**
   * ��Ë@�ւ��擾���܂��B
   * @return ��Ë@��
   */
  public ACRadioButtonItem getHoumonKangoKaigoMedicalInstitution(){
    if(houmonKangoKaigoMedicalInstitution==null){

      houmonKangoKaigoMedicalInstitution = new ACRadioButtonItem();

      houmonKangoKaigoMedicalInstitution.setText("�a�@���͐f�Ï�");

      houmonKangoKaigoMedicalInstitution.setGroup(getHoumonKangoKaigoFacilityType());

      houmonKangoKaigoMedicalInstitution.setConstraints(VRLayout.FLOW_RETURN);

      addHoumonKangoKaigoMedicalInstitution();
    }
    return houmonKangoKaigoMedicalInstitution;

  }

  /**
   * �������E�����Ή��T�[�r�X���擾���܂��B
   * @return �������E�����Ή��T�[�r�X
   */
  public ACRadioButtonItem getHoumonKangoKaigoFacilityTypeItem3(){
    if(houmonKangoKaigoFacilityTypeItem3==null){

      houmonKangoKaigoFacilityTypeItem3 = new ACRadioButtonItem();

      houmonKangoKaigoFacilityTypeItem3.setText("�������E�����Ή��T�[�r�X");

      houmonKangoKaigoFacilityTypeItem3.setGroup(getHoumonKangoKaigoFacilityType());

      houmonKangoKaigoFacilityTypeItem3.setConstraints(VRLayout.FLOW);

      addHoumonKangoKaigoFacilityTypeItem3();
    }
    return houmonKangoKaigoFacilityTypeItem3;

  }

  /**
   * �K��Ō�E���敪���擾���܂��B
   * @return �K��Ō�E���敪
   */
  public ACValueArrayRadioButtonGroup getHoumonKangoKaigoClass(){
    if(houmonKangoKaigoClass==null){

      houmonKangoKaigoClass = new ACValueArrayRadioButtonGroup();

      getHoumonKangoKaigoClassContainer().setText("�E���敪");

      houmonKangoKaigoClass.setBindPath("1130104");

      houmonKangoKaigoClass.setUseClearButton(false);

      houmonKangoKaigoClass.setModel(getHoumonKangoKaigoClassModel());

      houmonKangoKaigoClass.setValues(new int[]{1,2,3});

      addHoumonKangoKaigoClass();
    }
    return houmonKangoKaigoClass;

  }

  /**
   * �K��Ō�E���敪�R���e�i���擾���܂��B
   * @return �K��Ō�E���敪�R���e�i
   */
  protected ACLabelContainer getHoumonKangoKaigoClassContainer(){
    if(houmonKangoKaigoClassContainer==null){
      houmonKangoKaigoClassContainer = new ACLabelContainer();
      houmonKangoKaigoClassContainer.setFollowChildEnabled(true);
      houmonKangoKaigoClassContainer.setVAlignment(VRLayout.CENTER);
      houmonKangoKaigoClassContainer.add(getHoumonKangoKaigoClass(), null);
    }
    return houmonKangoKaigoClassContainer;
  }

  /**
   * �K��Ō�E���敪���f�����擾���܂��B
   * @return �K��Ō�E���敪���f��
   */
  protected ACListModelAdapter getHoumonKangoKaigoClassModel(){
    if(houmonKangoKaigoClassModel==null){
      houmonKangoKaigoClassModel = new ACListModelAdapter();
      addHoumonKangoKaigoClassModel();
    }
    return houmonKangoKaigoClassModel;
  }

  /**
   * ���ł��擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getHoumonKangoKaigoClass1(){
    if(houmonKangoKaigoClass1==null){

      houmonKangoKaigoClass1 = new ACRadioButtonItem();

      houmonKangoKaigoClass1.setText("���œ�");

      houmonKangoKaigoClass1.setGroup(getHoumonKangoKaigoClass());

      houmonKangoKaigoClass1.setConstraints(VRLayout.FLOW);

      addHoumonKangoKaigoClass1();
    }
    return houmonKangoKaigoClass1;

  }

  /**
   * �y�ł��擾���܂��B
   * @return �y��
   */
  public ACRadioButtonItem getHoumonKangoKaigoClass2(){
    if(houmonKangoKaigoClass2==null){

      houmonKangoKaigoClass2 = new ACRadioButtonItem();

      houmonKangoKaigoClass2.setText("�y��");

      houmonKangoKaigoClass2.setGroup(getHoumonKangoKaigoClass());

      houmonKangoKaigoClass2.setConstraints(VRLayout.FLOW_RETURN);

      addHoumonKangoKaigoClass2();
    }
    return houmonKangoKaigoClass2;

  }

  /**
   * ���w�Ö@�m���͍�ƗÖ@�m���͌��꒮�o�m���擾���܂��B
   * @return ���w�Ö@�m���͍�ƗÖ@�m���͌��꒮�o�m
   */
  public ACRadioButtonItem getHoumonKangoKaigoClass3(){
    if(houmonKangoKaigoClass3==null){

      houmonKangoKaigoClass3 = new ACRadioButtonItem();

      houmonKangoKaigoClass3.setText("PT�AOT�AST");

      houmonKangoKaigoClass3.setGroup(getHoumonKangoKaigoClass());

      houmonKangoKaigoClass3.setConstraints(VRLayout.FLOW);

      addHoumonKangoKaigoClass3();
    }
    return houmonKangoKaigoClass3;

  }

  /**
   * �K��Ō쎞�ԋ敪���擾���܂��B
   * @return �K��Ō쎞�ԋ敪
   */
  public ACValueArrayRadioButtonGroup getHoumonKangoKaigoTime(){
    if(houmonKangoKaigoTime==null){

      houmonKangoKaigoTime = new ACValueArrayRadioButtonGroup();

      getHoumonKangoKaigoTimeContainer().setText("���ԋ敪");

      houmonKangoKaigoTime.setBindPath("1130111");

      houmonKangoKaigoTime.setUseClearButton(false);

      houmonKangoKaigoTime.setModel(getHoumonKangoKaigoTimeModel());

      houmonKangoKaigoTime.setValues(new int[]{1,2,3,4});

      addHoumonKangoKaigoTime();
    }
    return houmonKangoKaigoTime;

  }

  /**
   * �K��Ō쎞�ԋ敪�R���e�i���擾���܂��B
   * @return �K��Ō쎞�ԋ敪�R���e�i
   */
  protected ACLabelContainer getHoumonKangoKaigoTimeContainer(){
    if(houmonKangoKaigoTimeContainer==null){
      houmonKangoKaigoTimeContainer = new ACLabelContainer();
      houmonKangoKaigoTimeContainer.setFollowChildEnabled(true);
      houmonKangoKaigoTimeContainer.setVAlignment(VRLayout.CENTER);
      houmonKangoKaigoTimeContainer.add(getHoumonKangoKaigoTime(), null);
    }
    return houmonKangoKaigoTimeContainer;
  }

  /**
   * �K��Ō쎞�ԋ敪���f�����擾���܂��B
   * @return �K��Ō쎞�ԋ敪���f��
   */
  protected ACListModelAdapter getHoumonKangoKaigoTimeModel(){
    if(houmonKangoKaigoTimeModel==null){
      houmonKangoKaigoTimeModel = new ACListModelAdapter();
      addHoumonKangoKaigoTimeModel();
    }
    return houmonKangoKaigoTimeModel;
  }

  /**
   * 20���������擾���܂��B
   * @return 20������
   */
  public ACRadioButtonItem getHoumonKangoKaigoTime1(){
    if(houmonKangoKaigoTime1==null){

      houmonKangoKaigoTime1 = new ACRadioButtonItem();

      houmonKangoKaigoTime1.setText("20������");

      houmonKangoKaigoTime1.setGroup(getHoumonKangoKaigoTime());

      houmonKangoKaigoTime1.setConstraints(VRLayout.FLOW);

      addHoumonKangoKaigoTime1();
    }
    return houmonKangoKaigoTime1;

  }

  /**
   * 30���������擾���܂��B
   * @return 30������
   */
  public ACRadioButtonItem getHoumonKangoKaigoTime2(){
    if(houmonKangoKaigoTime2==null){

      houmonKangoKaigoTime2 = new ACRadioButtonItem();

      houmonKangoKaigoTime2.setText("30������");

      houmonKangoKaigoTime2.setGroup(getHoumonKangoKaigoTime());

      houmonKangoKaigoTime2.setConstraints(VRLayout.FLOW_RETURN);

      addHoumonKangoKaigoTime2();
    }
    return houmonKangoKaigoTime2;

  }

  /**
   * 30���ȏ�A1���Ԗ������擾���܂��B
   * @return 30���ȏ�A1���Ԗ���
   */
  public ACRadioButtonItem getHoumonKangoKaigoTime3(){
    if(houmonKangoKaigoTime3==null){

      houmonKangoKaigoTime3 = new ACRadioButtonItem();

      houmonKangoKaigoTime3.setText("30���ȏ�A1���Ԗ���");

      houmonKangoKaigoTime3.setGroup(getHoumonKangoKaigoTime());

      houmonKangoKaigoTime3.setConstraints(VRLayout.FLOW_RETURN);

      addHoumonKangoKaigoTime3();
    }
    return houmonKangoKaigoTime3;

  }

  /**
   * 1���Ԉȏ�A1���Ԕ��������擾���܂��B
   * @return 1���Ԉȏ�A1���Ԕ�����
   */
  public ACRadioButtonItem getHoumonKangoKaigoTime4(){
    if(houmonKangoKaigoTime4==null){

      houmonKangoKaigoTime4 = new ACRadioButtonItem();

      houmonKangoKaigoTime4.setText("1���Ԉȏ�A1���Ԕ�����");

      houmonKangoKaigoTime4.setGroup(getHoumonKangoKaigoTime());

      houmonKangoKaigoTime4.setConstraints(VRLayout.FLOW_RETURN);

      addHoumonKangoKaigoTime4();
    }
    return houmonKangoKaigoTime4;

  }

  /**
   * �K��Ō��쎞�ԑт��擾���܂��B
   * @return �K��Ō��쎞�ԑ�
   */
  public ACValueArrayRadioButtonGroup getHoumonKangoKaigoTimeZone(){
    if(houmonKangoKaigoTimeZone==null){

      houmonKangoKaigoTimeZone = new ACValueArrayRadioButtonGroup();

      getHoumonKangoKaigoTimeZoneContainer().setText("���ԑ�");

      houmonKangoKaigoTimeZone.setBindPath("1130106");

      houmonKangoKaigoTimeZone.setUseClearButton(false);

      houmonKangoKaigoTimeZone.setModel(getHoumonKangoKaigoTimeZoneModel());

      houmonKangoKaigoTimeZone.setValues(new int[]{1,2,3,4});

      addHoumonKangoKaigoTimeZone();
    }
    return houmonKangoKaigoTimeZone;

  }

  /**
   * �K��Ō��쎞�ԑуR���e�i���擾���܂��B
   * @return �K��Ō��쎞�ԑуR���e�i
   */
  protected ACLabelContainer getHoumonKangoKaigoTimeZoneContainer(){
    if(houmonKangoKaigoTimeZoneContainer==null){
      houmonKangoKaigoTimeZoneContainer = new ACLabelContainer();
      houmonKangoKaigoTimeZoneContainer.setFollowChildEnabled(true);
      houmonKangoKaigoTimeZoneContainer.setVAlignment(VRLayout.CENTER);
      houmonKangoKaigoTimeZoneContainer.add(getHoumonKangoKaigoTimeZone(), null);
    }
    return houmonKangoKaigoTimeZoneContainer;
  }

  /**
   * �K��Ō��쎞�ԑу��f�����擾���܂��B
   * @return �K��Ō��쎞�ԑу��f��
   */
  protected ACListModelAdapter getHoumonKangoKaigoTimeZoneModel(){
    if(houmonKangoKaigoTimeZoneModel==null){
      houmonKangoKaigoTimeZoneModel = new ACListModelAdapter();
      addHoumonKangoKaigoTimeZoneModel();
    }
    return houmonKangoKaigoTimeZoneModel;
  }

  /**
   * �ʏ���擾���܂��B
   * @return �ʏ�
   */
  public ACRadioButtonItem getHoumonKangoKaigoTimeZoneNormal(){
    if(houmonKangoKaigoTimeZoneNormal==null){

      houmonKangoKaigoTimeZoneNormal = new ACRadioButtonItem();

      houmonKangoKaigoTimeZoneNormal.setText("�ʏ�");

      houmonKangoKaigoTimeZoneNormal.setGroup(getHoumonKangoKaigoTimeZone());

      houmonKangoKaigoTimeZoneNormal.setConstraints(VRLayout.FLOW);

      addHoumonKangoKaigoTimeZoneNormal();
    }
    return houmonKangoKaigoTimeZoneNormal;

  }

  /**
   * �������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getHoumonKangoKaigoTimeZoneEarlyMorning(){
    if(houmonKangoKaigoTimeZoneEarlyMorning==null){

      houmonKangoKaigoTimeZoneEarlyMorning = new ACRadioButtonItem();

      houmonKangoKaigoTimeZoneEarlyMorning.setText("����");

      houmonKangoKaigoTimeZoneEarlyMorning.setGroup(getHoumonKangoKaigoTimeZone());

      houmonKangoKaigoTimeZoneEarlyMorning.setConstraints(VRLayout.FLOW);

      addHoumonKangoKaigoTimeZoneEarlyMorning();
    }
    return houmonKangoKaigoTimeZoneEarlyMorning;

  }

  /**
   * ��Ԃ��擾���܂��B
   * @return ���
   */
  public ACRadioButtonItem getHoumonKangoKaigoTimeZoneNighttime(){
    if(houmonKangoKaigoTimeZoneNighttime==null){

      houmonKangoKaigoTimeZoneNighttime = new ACRadioButtonItem();

      houmonKangoKaigoTimeZoneNighttime.setText("���");

      houmonKangoKaigoTimeZoneNighttime.setGroup(getHoumonKangoKaigoTimeZone());

      houmonKangoKaigoTimeZoneNighttime.setConstraints(VRLayout.FLOW);

      addHoumonKangoKaigoTimeZoneNighttime();
    }
    return houmonKangoKaigoTimeZoneNighttime;

  }

  /**
   * �[����擾���܂��B
   * @return �[��
   */
  public ACRadioButtonItem getHoumonKangoKaigoTimeZoneMidnight(){
    if(houmonKangoKaigoTimeZoneMidnight==null){

      houmonKangoKaigoTimeZoneMidnight = new ACRadioButtonItem();

      houmonKangoKaigoTimeZoneMidnight.setText("�[��");

      houmonKangoKaigoTimeZoneMidnight.setGroup(getHoumonKangoKaigoTimeZone());

      houmonKangoKaigoTimeZoneMidnight.setConstraints(VRLayout.FLOW);

      addHoumonKangoKaigoTimeZoneMidnight();
    }
    return houmonKangoKaigoTimeZoneMidnight;

  }

  /**
   * ���ʊǗ����Z���擾���܂��B
   * @return ���ʊǗ����Z
   */
  public ACValueArrayRadioButtonGroup getSpecialManagementRadioGroup(){
    if(specialManagementRadioGroup==null){

      specialManagementRadioGroup = new ACValueArrayRadioButtonGroup();

      getSpecialManagementRadioGroupContainer().setText("���ʊǗ����Z");

      specialManagementRadioGroup.setBindPath("1130116");

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
   * 1����2����z���Ď��{���擾���܂��B
   * @return 1����2����z���Ď��{
   */
  public ACIntegerCheckBox getTwoOrMoreTimesCheck(){
    if(twoOrMoreTimesCheck==null){

      twoOrMoreTimesCheck = new ACIntegerCheckBox();

      twoOrMoreTimesCheck.setText("1����2����z���Ď��{");

      twoOrMoreTimesCheck.setBindPath("1130121");

      twoOrMoreTimesCheck.setSelectValue(2);

      twoOrMoreTimesCheck.setUnSelectValue(1);

      addTwoOrMoreTimesCheck();
    }
    return twoOrMoreTimesCheck;

  }

  /**
   * �������擾���܂��B
   * @return ����
   */
  public ACIntegerCheckBox getCrackOnDayCheck(){
    if(crackOnDayCheck==null){

      crackOnDayCheck = new ACIntegerCheckBox();

      crackOnDayCheck.setText("����");

      crackOnDayCheck.setBindPath("1130123");

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
  public ACBackLabelContainer getHoumonKangoKaigoTimeContena(){
    if(houmonKangoKaigoTimeContena==null){

      houmonKangoKaigoTimeContena = new ACBackLabelContainer();

      houmonKangoKaigoTimeContena.setFollowChildEnabled(true);

      addHoumonKangoKaigoTimeContena();
    }
    return houmonKangoKaigoTimeContena;

  }

  /**
   * �J�n�����R���{���擾���܂��B
   * @return �J�n�����R���{
   */
  public ACTimeComboBox getHoumonKangoKaigoBeginTime(){
    if(houmonKangoKaigoBeginTime==null){

      houmonKangoKaigoBeginTime = new ACTimeComboBox();

      getHoumonKangoKaigoBeginTimeContainer().setText("�J�n����");

      houmonKangoKaigoBeginTime.setBindPath("3");

      houmonKangoKaigoBeginTime.setModelBindPath("3");

      houmonKangoKaigoBeginTime.setRenderBindPath("CONTENT");

      houmonKangoKaigoBeginTime.setModel(getHoumonKangoKaigoBeginTimeModel());

      addHoumonKangoKaigoBeginTime();
    }
    return houmonKangoKaigoBeginTime;

  }

  /**
   * �J�n�����R���{�R���e�i���擾���܂��B
   * @return �J�n�����R���{�R���e�i
   */
  protected ACLabelContainer getHoumonKangoKaigoBeginTimeContainer(){
    if(houmonKangoKaigoBeginTimeContainer==null){
      houmonKangoKaigoBeginTimeContainer = new ACLabelContainer();
      houmonKangoKaigoBeginTimeContainer.setFollowChildEnabled(true);
      houmonKangoKaigoBeginTimeContainer.setVAlignment(VRLayout.CENTER);
      houmonKangoKaigoBeginTimeContainer.add(getHoumonKangoKaigoBeginTime(), null);
    }
    return houmonKangoKaigoBeginTimeContainer;
  }

  /**
   * �J�n�����R���{���f�����擾���܂��B
   * @return �J�n�����R���{���f��
   */
  protected ACComboBoxModelAdapter getHoumonKangoKaigoBeginTimeModel(){
    if(houmonKangoKaigoBeginTimeModel==null){
      houmonKangoKaigoBeginTimeModel = new ACComboBoxModelAdapter();
      addHoumonKangoKaigoBeginTimeModel();
    }
    return houmonKangoKaigoBeginTimeModel;
  }

  /**
   * �I�������R���{���擾���܂��B
   * @return �I�������R���{
   */
  public ACTimeComboBox getHoumonKangoKaigoEndTime(){
    if(houmonKangoKaigoEndTime==null){

      houmonKangoKaigoEndTime = new ACTimeComboBox();

      getHoumonKangoKaigoEndTimeContainer().setText("�I������");

      houmonKangoKaigoEndTime.setBindPath("4");

      houmonKangoKaigoEndTime.setModelBindPath("4");

      houmonKangoKaigoEndTime.setRenderBindPath("CONTENT");

      houmonKangoKaigoEndTime.setModel(getHoumonKangoKaigoEndTimeModel());

      addHoumonKangoKaigoEndTime();
    }
    return houmonKangoKaigoEndTime;

  }

  /**
   * �I�������R���{�R���e�i���擾���܂��B
   * @return �I�������R���{�R���e�i
   */
  protected ACLabelContainer getHoumonKangoKaigoEndTimeContainer(){
    if(houmonKangoKaigoEndTimeContainer==null){
      houmonKangoKaigoEndTimeContainer = new ACLabelContainer();
      houmonKangoKaigoEndTimeContainer.setFollowChildEnabled(true);
      houmonKangoKaigoEndTimeContainer.setVAlignment(VRLayout.CENTER);
      houmonKangoKaigoEndTimeContainer.add(getHoumonKangoKaigoEndTime(), null);
    }
    return houmonKangoKaigoEndTimeContainer;
  }

  /**
   * �I�������R���{���f�����擾���܂��B
   * @return �I�������R���{���f��
   */
  protected ACComboBoxModelAdapter getHoumonKangoKaigoEndTimeModel(){
    if(houmonKangoKaigoEndTimeModel==null){
      houmonKangoKaigoEndTimeModel = new ACComboBoxModelAdapter();
      addHoumonKangoKaigoEndTimeModel();
    }
    return houmonKangoKaigoEndTimeModel;
  }

  /**
   * �^�u2���擾���܂��B
   * @return �^�u2
   */
  public ACPanel getTab2(){
    if(tab2==null){

      tab2 = new ACPanel();

      tab2.setFollowChildEnabled(true);

      addTab2();
    }
    return tab2;

  }

  /**
   * �����ԖK��Ō���Z���擾���܂��B
   * @return �����ԖK��Ō���Z
   */
  public ACValueArrayRadioButtonGroup getHoumonKangoKaigoLongTime(){
    if(houmonKangoKaigoLongTime==null){

      houmonKangoKaigoLongTime = new ACValueArrayRadioButtonGroup();

      getHoumonKangoKaigoLongTimeContainer().setText("�����ԖK��Ō���Z");

      houmonKangoKaigoLongTime.setBindPath("1130114");

      houmonKangoKaigoLongTime.setUseClearButton(false);

      houmonKangoKaigoLongTime.setModel(getHoumonKangoKaigoLongTimeModel());

      houmonKangoKaigoLongTime.setValues(new int[]{1,2});

      addHoumonKangoKaigoLongTime();
    }
    return houmonKangoKaigoLongTime;

  }

  /**
   * �����ԖK��Ō���Z�R���e�i���擾���܂��B
   * @return �����ԖK��Ō���Z�R���e�i
   */
  protected ACLabelContainer getHoumonKangoKaigoLongTimeContainer(){
    if(houmonKangoKaigoLongTimeContainer==null){
      houmonKangoKaigoLongTimeContainer = new ACLabelContainer();
      houmonKangoKaigoLongTimeContainer.setFollowChildEnabled(true);
      houmonKangoKaigoLongTimeContainer.setVAlignment(VRLayout.CENTER);
      houmonKangoKaigoLongTimeContainer.add(getHoumonKangoKaigoLongTime(), null);
    }
    return houmonKangoKaigoLongTimeContainer;
  }

  /**
   * �����ԖK��Ō���Z���f�����擾���܂��B
   * @return �����ԖK��Ō���Z���f��
   */
  protected ACListModelAdapter getHoumonKangoKaigoLongTimeModel(){
    if(houmonKangoKaigoLongTimeModel==null){
      houmonKangoKaigoLongTimeModel = new ACListModelAdapter();
      addHoumonKangoKaigoLongTimeModel();
    }
    return houmonKangoKaigoLongTimeModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getHoumonKangoKaigoLongTimeItem1(){
    if(houmonKangoKaigoLongTimeItem1==null){

      houmonKangoKaigoLongTimeItem1 = new ACRadioButtonItem();

      houmonKangoKaigoLongTimeItem1.setText("�Ȃ�");

      houmonKangoKaigoLongTimeItem1.setGroup(getHoumonKangoKaigoLongTime());

      houmonKangoKaigoLongTimeItem1.setConstraints(VRLayout.FLOW);

      addHoumonKangoKaigoLongTimeItem1();
    }
    return houmonKangoKaigoLongTimeItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getHoumonKangoKaigoLongTimeItem2(){
    if(houmonKangoKaigoLongTimeItem2==null){

      houmonKangoKaigoLongTimeItem2 = new ACRadioButtonItem();

      houmonKangoKaigoLongTimeItem2.setText("����");

      houmonKangoKaigoLongTimeItem2.setGroup(getHoumonKangoKaigoLongTime());

      houmonKangoKaigoLongTimeItem2.setConstraints(VRLayout.FLOW);

      addHoumonKangoKaigoLongTimeItem2();
    }
    return houmonKangoKaigoLongTimeItem2;

  }

  /**
   * �ً}���K��Ō���Z���擾���܂��B
   * @return �ً}���K��Ō���Z
   */
  public ACValueArrayRadioButtonGroup getHoumonKangoKaigoUrgentTimeRadio(){
    if(houmonKangoKaigoUrgentTimeRadio==null){

      houmonKangoKaigoUrgentTimeRadio = new ACValueArrayRadioButtonGroup();

      getHoumonKangoKaigoUrgentTimeRadioContainer().setText("�ً}���K��Ō���Z");

      houmonKangoKaigoUrgentTimeRadio.setBindPath("1130108");

      houmonKangoKaigoUrgentTimeRadio.setUseClearButton(false);

      houmonKangoKaigoUrgentTimeRadio.setModel(getHoumonKangoKaigoUrgentTimeRadioModel());

      houmonKangoKaigoUrgentTimeRadio.setValues(new int[]{1,2});

      addHoumonKangoKaigoUrgentTimeRadio();
    }
    return houmonKangoKaigoUrgentTimeRadio;

  }

  /**
   * �ً}���K��Ō���Z�R���e�i���擾���܂��B
   * @return �ً}���K��Ō���Z�R���e�i
   */
  protected ACLabelContainer getHoumonKangoKaigoUrgentTimeRadioContainer(){
    if(houmonKangoKaigoUrgentTimeRadioContainer==null){
      houmonKangoKaigoUrgentTimeRadioContainer = new ACLabelContainer();
      houmonKangoKaigoUrgentTimeRadioContainer.setFollowChildEnabled(true);
      houmonKangoKaigoUrgentTimeRadioContainer.setVAlignment(VRLayout.CENTER);
      houmonKangoKaigoUrgentTimeRadioContainer.add(getHoumonKangoKaigoUrgentTimeRadio(), null);
    }
    return houmonKangoKaigoUrgentTimeRadioContainer;
  }

  /**
   * �ً}���K��Ō���Z���f�����擾���܂��B
   * @return �ً}���K��Ō���Z���f��
   */
  protected ACListModelAdapter getHoumonKangoKaigoUrgentTimeRadioModel(){
    if(houmonKangoKaigoUrgentTimeRadioModel==null){
      houmonKangoKaigoUrgentTimeRadioModel = new ACListModelAdapter();
      addHoumonKangoKaigoUrgentTimeRadioModel();
    }
    return houmonKangoKaigoUrgentTimeRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getHoumonKangoKaigoUrgentTimeRadioItem1(){
    if(houmonKangoKaigoUrgentTimeRadioItem1==null){

      houmonKangoKaigoUrgentTimeRadioItem1 = new ACRadioButtonItem();

      houmonKangoKaigoUrgentTimeRadioItem1.setText("�Ȃ�");

      houmonKangoKaigoUrgentTimeRadioItem1.setGroup(getHoumonKangoKaigoUrgentTimeRadio());

      houmonKangoKaigoUrgentTimeRadioItem1.setConstraints(VRLayout.FLOW);

      addHoumonKangoKaigoUrgentTimeRadioItem1();
    }
    return houmonKangoKaigoUrgentTimeRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getHoumonKangoKaigoUrgentTimeRadioItem2(){
    if(houmonKangoKaigoUrgentTimeRadioItem2==null){

      houmonKangoKaigoUrgentTimeRadioItem2 = new ACRadioButtonItem();

      houmonKangoKaigoUrgentTimeRadioItem2.setText("����");

      houmonKangoKaigoUrgentTimeRadioItem2.setGroup(getHoumonKangoKaigoUrgentTimeRadio());

      houmonKangoKaigoUrgentTimeRadioItem2.setConstraints(VRLayout.FLOW);

      addHoumonKangoKaigoUrgentTimeRadioItem2();
    }
    return houmonKangoKaigoUrgentTimeRadioItem2;

  }

  /**
   * �ً}���K��Ō���Z���擾���܂��B
   * @return �ً}���K��Ō���Z
   */
  public ACValueArrayRadioButtonGroup getHoumonKangoKaigoUrgentTime2Radio(){
    if(houmonKangoKaigoUrgentTime2Radio==null){

      houmonKangoKaigoUrgentTime2Radio = new ACValueArrayRadioButtonGroup();

      getHoumonKangoKaigoUrgentTime2RadioContainer().setText("�ً}���K��Ō���Z");

      houmonKangoKaigoUrgentTime2Radio.setBindPath("1130122");

      houmonKangoKaigoUrgentTime2Radio.setUseClearButton(false);

      houmonKangoKaigoUrgentTime2Radio.setModel(getHoumonKangoKaigoUrgentTime2RadioModel());

      houmonKangoKaigoUrgentTime2Radio.setValues(new int[]{1,2,3});

      addHoumonKangoKaigoUrgentTime2Radio();
    }
    return houmonKangoKaigoUrgentTime2Radio;

  }

  /**
   * �ً}���K��Ō���Z�R���e�i���擾���܂��B
   * @return �ً}���K��Ō���Z�R���e�i
   */
  protected ACLabelContainer getHoumonKangoKaigoUrgentTime2RadioContainer(){
    if(houmonKangoKaigoUrgentTime2RadioContainer==null){
      houmonKangoKaigoUrgentTime2RadioContainer = new ACLabelContainer();
      houmonKangoKaigoUrgentTime2RadioContainer.setFollowChildEnabled(true);
      houmonKangoKaigoUrgentTime2RadioContainer.setVAlignment(VRLayout.CENTER);
      houmonKangoKaigoUrgentTime2RadioContainer.add(getHoumonKangoKaigoUrgentTime2Radio(), null);
    }
    return houmonKangoKaigoUrgentTime2RadioContainer;
  }

  /**
   * �ً}���K��Ō���Z���f�����擾���܂��B
   * @return �ً}���K��Ō���Z���f��
   */
  protected ACListModelAdapter getHoumonKangoKaigoUrgentTime2RadioModel(){
    if(houmonKangoKaigoUrgentTime2RadioModel==null){
      houmonKangoKaigoUrgentTime2RadioModel = new ACListModelAdapter();
      addHoumonKangoKaigoUrgentTime2RadioModel();
    }
    return houmonKangoKaigoUrgentTime2RadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getHoumonKangoKaigoUrgentTime2RadioItem1(){
    if(houmonKangoKaigoUrgentTime2RadioItem1==null){

      houmonKangoKaigoUrgentTime2RadioItem1 = new ACRadioButtonItem();

      houmonKangoKaigoUrgentTime2RadioItem1.setText("�Ȃ�");

      houmonKangoKaigoUrgentTime2RadioItem1.setGroup(getHoumonKangoKaigoUrgentTime2Radio());

      houmonKangoKaigoUrgentTime2RadioItem1.setConstraints(VRLayout.FLOW_RETURN);

      addHoumonKangoKaigoUrgentTime2RadioItem1();
    }
    return houmonKangoKaigoUrgentTime2RadioItem1;

  }

  /**
   * �w��K��Ō�X�e�[�V�������擾���܂��B
   * @return �w��K��Ō�X�e�[�V����
   */
  public ACRadioButtonItem getHoumonKangoKaigoUrgentTime2RadioItem2(){
    if(houmonKangoKaigoUrgentTime2RadioItem2==null){

      houmonKangoKaigoUrgentTime2RadioItem2 = new ACRadioButtonItem();

      houmonKangoKaigoUrgentTime2RadioItem2.setText("�w��K��Ō�X�e�[�V����");

      houmonKangoKaigoUrgentTime2RadioItem2.setGroup(getHoumonKangoKaigoUrgentTime2Radio());

      houmonKangoKaigoUrgentTime2RadioItem2.setConstraints(VRLayout.FLOW_RETURN);

      addHoumonKangoKaigoUrgentTime2RadioItem2();
    }
    return houmonKangoKaigoUrgentTime2RadioItem2;

  }

  /**
   * ��Ë@�ւ��擾���܂��B
   * @return ��Ë@��
   */
  public ACRadioButtonItem getHoumonKangoKaigoUrgentTime2RadioItem3(){
    if(houmonKangoKaigoUrgentTime2RadioItem3==null){

      houmonKangoKaigoUrgentTime2RadioItem3 = new ACRadioButtonItem();

      houmonKangoKaigoUrgentTime2RadioItem3.setText("��Ë@��");

      houmonKangoKaigoUrgentTime2RadioItem3.setGroup(getHoumonKangoKaigoUrgentTime2Radio());

      houmonKangoKaigoUrgentTime2RadioItem3.setConstraints(VRLayout.FLOW);

      addHoumonKangoKaigoUrgentTime2RadioItem3();
    }
    return houmonKangoKaigoUrgentTime2RadioItem3;

  }

  /**
   * �^�[�~�i���P�A���Z���擾���܂��B
   * @return �^�[�~�i���P�A���Z
   */
  public ACValueArrayRadioButtonGroup getHoumonKangoKaigoTerminalRadio(){
    if(houmonKangoKaigoTerminalRadio==null){

      houmonKangoKaigoTerminalRadio = new ACValueArrayRadioButtonGroup();

      getHoumonKangoKaigoTerminalRadioContainer().setText("�^�[�~�i���P�A���Z");

      houmonKangoKaigoTerminalRadio.setBindPath("1130110");

      houmonKangoKaigoTerminalRadio.setUseClearButton(false);

      houmonKangoKaigoTerminalRadio.setModel(getHoumonKangoKaigoTerminalRadioModel());

      houmonKangoKaigoTerminalRadio.setValues(new int[]{1,2});

      addHoumonKangoKaigoTerminalRadio();
    }
    return houmonKangoKaigoTerminalRadio;

  }

  /**
   * �^�[�~�i���P�A���Z�R���e�i���擾���܂��B
   * @return �^�[�~�i���P�A���Z�R���e�i
   */
  protected ACLabelContainer getHoumonKangoKaigoTerminalRadioContainer(){
    if(houmonKangoKaigoTerminalRadioContainer==null){
      houmonKangoKaigoTerminalRadioContainer = new ACLabelContainer();
      houmonKangoKaigoTerminalRadioContainer.setFollowChildEnabled(true);
      houmonKangoKaigoTerminalRadioContainer.setVAlignment(VRLayout.CENTER);
      houmonKangoKaigoTerminalRadioContainer.add(getHoumonKangoKaigoTerminalRadio(), null);
    }
    return houmonKangoKaigoTerminalRadioContainer;
  }

  /**
   * �^�[�~�i���P�A���Z���f�����擾���܂��B
   * @return �^�[�~�i���P�A���Z���f��
   */
  protected ACListModelAdapter getHoumonKangoKaigoTerminalRadioModel(){
    if(houmonKangoKaigoTerminalRadioModel==null){
      houmonKangoKaigoTerminalRadioModel = new ACListModelAdapter();
      addHoumonKangoKaigoTerminalRadioModel();
    }
    return houmonKangoKaigoTerminalRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getHoumonKangoKaigoTerminalRadioItem1(){
    if(houmonKangoKaigoTerminalRadioItem1==null){

      houmonKangoKaigoTerminalRadioItem1 = new ACRadioButtonItem();

      houmonKangoKaigoTerminalRadioItem1.setText("�Ȃ�");

      houmonKangoKaigoTerminalRadioItem1.setGroup(getHoumonKangoKaigoTerminalRadio());

      houmonKangoKaigoTerminalRadioItem1.setConstraints(VRLayout.FLOW);

      addHoumonKangoKaigoTerminalRadioItem1();
    }
    return houmonKangoKaigoTerminalRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getHoumonKangoKaigoTerminalRadioItem2(){
    if(houmonKangoKaigoTerminalRadioItem2==null){

      houmonKangoKaigoTerminalRadioItem2 = new ACRadioButtonItem();

      houmonKangoKaigoTerminalRadioItem2.setText("����");

      houmonKangoKaigoTerminalRadioItem2.setGroup(getHoumonKangoKaigoTerminalRadio());

      houmonKangoKaigoTerminalRadioItem2.setConstraints(VRLayout.FLOW);

      addHoumonKangoKaigoTerminalRadioItem2();
    }
    return houmonKangoKaigoTerminalRadioItem2;

  }

  /**
   * ������Z���擾���܂��B
   * @return ������Z
   */
  public ACValueArrayRadioButtonGroup getInitialAddRadioGroup(){
    if(initialAddRadioGroup==null){

      initialAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getInitialAddRadioGroupContainer().setText("������Z");

      initialAddRadioGroup.setBindPath("1130117");

      initialAddRadioGroup.setNoSelectIndex(0);

      initialAddRadioGroup.setUseClearButton(false);

      initialAddRadioGroup.setModel(getInitialAddRadioGroupModel());

      initialAddRadioGroup.setValues(new int[]{1,2});

      addInitialAddRadioGroup();
    }
    return initialAddRadioGroup;

  }

  /**
   * ������Z�R���e�i���擾���܂��B
   * @return ������Z�R���e�i
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
   * ������Z���f�����擾���܂��B
   * @return ������Z���f��
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
   * �މ@�������w�����Z���擾���܂��B
   * @return �މ@�������w�����Z
   */
  public ACValueArrayRadioButtonGroup getLeavingHospitalGuidanceAddRadioGroup(){
    if(leavingHospitalGuidanceAddRadioGroup==null){

      leavingHospitalGuidanceAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getLeavingHospitalGuidanceAddRadioGroupContainer().setText("�މ@�������w�����Z");

      leavingHospitalGuidanceAddRadioGroup.setBindPath("1130118");

      leavingHospitalGuidanceAddRadioGroup.setNoSelectIndex(0);

      leavingHospitalGuidanceAddRadioGroup.setUseClearButton(false);

      leavingHospitalGuidanceAddRadioGroup.setModel(getLeavingHospitalGuidanceAddRadioGroupModel());

      leavingHospitalGuidanceAddRadioGroup.setValues(new int[]{1,2});

      addLeavingHospitalGuidanceAddRadioGroup();
    }
    return leavingHospitalGuidanceAddRadioGroup;

  }

  /**
   * �މ@�������w�����Z�R���e�i���擾���܂��B
   * @return �މ@�������w�����Z�R���e�i
   */
  protected ACLabelContainer getLeavingHospitalGuidanceAddRadioGroupContainer(){
    if(leavingHospitalGuidanceAddRadioGroupContainer==null){
      leavingHospitalGuidanceAddRadioGroupContainer = new ACLabelContainer();
      leavingHospitalGuidanceAddRadioGroupContainer.setFollowChildEnabled(true);
      leavingHospitalGuidanceAddRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      leavingHospitalGuidanceAddRadioGroupContainer.add(getLeavingHospitalGuidanceAddRadioGroup(), null);
    }
    return leavingHospitalGuidanceAddRadioGroupContainer;
  }

  /**
   * �މ@�������w�����Z���f�����擾���܂��B
   * @return �މ@�������w�����Z���f��
   */
  protected ACListModelAdapter getLeavingHospitalGuidanceAddRadioGroupModel(){
    if(leavingHospitalGuidanceAddRadioGroupModel==null){
      leavingHospitalGuidanceAddRadioGroupModel = new ACListModelAdapter();
      addLeavingHospitalGuidanceAddRadioGroupModel();
    }
    return leavingHospitalGuidanceAddRadioGroupModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getLeavingHospitalGuidanceAddRadioItem1(){
    if(leavingHospitalGuidanceAddRadioItem1==null){

      leavingHospitalGuidanceAddRadioItem1 = new ACRadioButtonItem();

      leavingHospitalGuidanceAddRadioItem1.setText("�Ȃ�");

      leavingHospitalGuidanceAddRadioItem1.setGroup(getLeavingHospitalGuidanceAddRadioGroup());

      leavingHospitalGuidanceAddRadioItem1.setConstraints(VRLayout.FLOW);

      addLeavingHospitalGuidanceAddRadioItem1();
    }
    return leavingHospitalGuidanceAddRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getLeavingHospitalGuidanceAddRadioItem2(){
    if(leavingHospitalGuidanceAddRadioItem2==null){

      leavingHospitalGuidanceAddRadioItem2 = new ACRadioButtonItem();

      leavingHospitalGuidanceAddRadioItem2.setText("����");

      leavingHospitalGuidanceAddRadioItem2.setGroup(getLeavingHospitalGuidanceAddRadioGroup());

      leavingHospitalGuidanceAddRadioItem2.setConstraints(VRLayout.FLOW);

      addLeavingHospitalGuidanceAddRadioItem2();
    }
    return leavingHospitalGuidanceAddRadioItem2;

  }

  /**
   * �Ō�E���E���A�g�������Z���擾���܂��B
   * @return �Ō�E���E���A�g�������Z
   */
  public ACValueArrayRadioButtonGroup getCooperationMedicalCareAddRadioGroup(){
    if(cooperationMedicalCareAddRadioGroup==null){

      cooperationMedicalCareAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getCooperationMedicalCareAddRadioGroupContainer().setText("�Ō�E���E���A�g�������Z");

      cooperationMedicalCareAddRadioGroup.setBindPath("1130119");

      cooperationMedicalCareAddRadioGroup.setNoSelectIndex(0);

      cooperationMedicalCareAddRadioGroup.setUseClearButton(false);

      cooperationMedicalCareAddRadioGroup.setModel(getCooperationMedicalCareAddRadioGroupModel());

      cooperationMedicalCareAddRadioGroup.setValues(new int[]{1,2});

      addCooperationMedicalCareAddRadioGroup();
    }
    return cooperationMedicalCareAddRadioGroup;

  }

  /**
   * �Ō�E���E���A�g�������Z�R���e�i���擾���܂��B
   * @return �Ō�E���E���A�g�������Z�R���e�i
   */
  protected ACLabelContainer getCooperationMedicalCareAddRadioGroupContainer(){
    if(cooperationMedicalCareAddRadioGroupContainer==null){
      cooperationMedicalCareAddRadioGroupContainer = new ACLabelContainer();
      cooperationMedicalCareAddRadioGroupContainer.setFollowChildEnabled(true);
      cooperationMedicalCareAddRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      cooperationMedicalCareAddRadioGroupContainer.add(getCooperationMedicalCareAddRadioGroup(), null);
    }
    return cooperationMedicalCareAddRadioGroupContainer;
  }

  /**
   * �Ō�E���E���A�g�������Z���f�����擾���܂��B
   * @return �Ō�E���E���A�g�������Z���f��
   */
  protected ACListModelAdapter getCooperationMedicalCareAddRadioGroupModel(){
    if(cooperationMedicalCareAddRadioGroupModel==null){
      cooperationMedicalCareAddRadioGroupModel = new ACListModelAdapter();
      addCooperationMedicalCareAddRadioGroupModel();
    }
    return cooperationMedicalCareAddRadioGroupModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getCooperationMedicalCareAddRadioItem1(){
    if(cooperationMedicalCareAddRadioItem1==null){

      cooperationMedicalCareAddRadioItem1 = new ACRadioButtonItem();

      cooperationMedicalCareAddRadioItem1.setText("�Ȃ�");

      cooperationMedicalCareAddRadioItem1.setGroup(getCooperationMedicalCareAddRadioGroup());

      cooperationMedicalCareAddRadioItem1.setConstraints(VRLayout.FLOW);

      addCooperationMedicalCareAddRadioItem1();
    }
    return cooperationMedicalCareAddRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getCooperationMedicalCareAddRadioItem2(){
    if(cooperationMedicalCareAddRadioItem2==null){

      cooperationMedicalCareAddRadioItem2 = new ACRadioButtonItem();

      cooperationMedicalCareAddRadioItem2.setText("����");

      cooperationMedicalCareAddRadioItem2.setGroup(getCooperationMedicalCareAddRadioGroup());

      cooperationMedicalCareAddRadioItem2.setConstraints(VRLayout.FLOW);

      addCooperationMedicalCareAddRadioItem2();
    }
    return cooperationMedicalCareAddRadioItem2;

  }

  /**
   * �T�[�r�X�񋟑̐��������Z���擾���܂��B
   * @return �T�[�r�X�񋟑̐��������Z
   */
  public ACValueArrayRadioButtonGroup getServiceAddProvisionStructuralRadioGroup(){
    if(serviceAddProvisionStructuralRadioGroup==null){

      serviceAddProvisionStructuralRadioGroup = new ACValueArrayRadioButtonGroup();

      getServiceAddProvisionStructuralRadioGroupContainer().setText("�T�[�r�X�񋟑̐��������Z");

      serviceAddProvisionStructuralRadioGroup.setBindPath("1130113");

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
   * �K��l�����擾���܂��B
   * @return �K��l��
   */
  public ACValueArrayRadioButtonGroup getHoumonKangoNumberOfPeople(){
    if(houmonKangoNumberOfPeople==null){

      houmonKangoNumberOfPeople = new ACValueArrayRadioButtonGroup();

      getHoumonKangoNumberOfPeopleContainer().setText("�K��l��");

      houmonKangoNumberOfPeople.setBindPath("1130112");

      houmonKangoNumberOfPeople.setNoSelectIndex(0);

      houmonKangoNumberOfPeople.setUseClearButton(false);

      houmonKangoNumberOfPeople.setModel(getHoumonKangoNumberOfPeopleModel());

      houmonKangoNumberOfPeople.setValues(new int[]{1,2});

      addHoumonKangoNumberOfPeople();
    }
    return houmonKangoNumberOfPeople;

  }

  /**
   * �K��l���R���e�i���擾���܂��B
   * @return �K��l���R���e�i
   */
  protected ACLabelContainer getHoumonKangoNumberOfPeopleContainer(){
    if(houmonKangoNumberOfPeopleContainer==null){
      houmonKangoNumberOfPeopleContainer = new ACLabelContainer();
      houmonKangoNumberOfPeopleContainer.setFollowChildEnabled(true);
      houmonKangoNumberOfPeopleContainer.setVAlignment(VRLayout.CENTER);
      houmonKangoNumberOfPeopleContainer.add(getHoumonKangoNumberOfPeople(), null);
    }
    return houmonKangoNumberOfPeopleContainer;
  }

  /**
   * �K��l�����f�����擾���܂��B
   * @return �K��l�����f��
   */
  protected ACListModelAdapter getHoumonKangoNumberOfPeopleModel(){
    if(houmonKangoNumberOfPeopleModel==null){
      houmonKangoNumberOfPeopleModel = new ACListModelAdapter();
      addHoumonKangoNumberOfPeopleModel();
    }
    return houmonKangoNumberOfPeopleModel;
  }

  /**
   * 1�l���擾���܂��B
   * @return 1�l
   */
  public ACRadioButtonItem getHoumonKangoNumberOfPeople1(){
    if(houmonKangoNumberOfPeople1==null){

      houmonKangoNumberOfPeople1 = new ACRadioButtonItem();

      houmonKangoNumberOfPeople1.setText("1�l");

      houmonKangoNumberOfPeople1.setGroup(getHoumonKangoNumberOfPeople());

      houmonKangoNumberOfPeople1.setConstraints(VRLayout.FLOW);

      addHoumonKangoNumberOfPeople1();
    }
    return houmonKangoNumberOfPeople1;

  }

  /**
   * 2�l���擾���܂��B
   * @return 2�l
   */
  public ACRadioButtonItem getHoumonKangoNumberOfPeople2(){
    if(houmonKangoNumberOfPeople2==null){

      houmonKangoNumberOfPeople2 = new ACRadioButtonItem();

      houmonKangoNumberOfPeople2.setText("2�l");

      houmonKangoNumberOfPeople2.setGroup(getHoumonKangoNumberOfPeople());

      houmonKangoNumberOfPeople2.setConstraints(VRLayout.FLOW);

      addHoumonKangoNumberOfPeople2();
    }
    return houmonKangoNumberOfPeople2;

  }

  /**
   * 2�l�ڂ̖K�⎞�Ԃ��擾���܂��B
   * @return 2�l�ڂ̖K�⎞��
   */
  public ACValueArrayRadioButtonGroup getHoumonKangoNumberOfPeopleTime(){
    if(houmonKangoNumberOfPeopleTime==null){

      houmonKangoNumberOfPeopleTime = new ACValueArrayRadioButtonGroup();

      getHoumonKangoNumberOfPeopleTimeContainer().setText("2�l�ڂ̖K�⎞��");

      houmonKangoNumberOfPeopleTime.setBindPath("1130115");

      houmonKangoNumberOfPeopleTime.setNoSelectIndex(0);

      houmonKangoNumberOfPeopleTime.setUseClearButton(false);

      houmonKangoNumberOfPeopleTime.setModel(getHoumonKangoNumberOfPeopleTimeModel());

      houmonKangoNumberOfPeopleTime.setValues(new int[]{1,2});

      addHoumonKangoNumberOfPeopleTime();
    }
    return houmonKangoNumberOfPeopleTime;

  }

  /**
   * 2�l�ڂ̖K�⎞�ԃR���e�i���擾���܂��B
   * @return 2�l�ڂ̖K�⎞�ԃR���e�i
   */
  protected ACLabelContainer getHoumonKangoNumberOfPeopleTimeContainer(){
    if(houmonKangoNumberOfPeopleTimeContainer==null){
      houmonKangoNumberOfPeopleTimeContainer = new ACLabelContainer();
      houmonKangoNumberOfPeopleTimeContainer.setFollowChildEnabled(true);
      houmonKangoNumberOfPeopleTimeContainer.setVAlignment(VRLayout.CENTER);
      houmonKangoNumberOfPeopleTimeContainer.add(getHoumonKangoNumberOfPeopleTime(), null);
    }
    return houmonKangoNumberOfPeopleTimeContainer;
  }

  /**
   * 2�l�ڂ̖K�⎞�ԃ��f�����擾���܂��B
   * @return 2�l�ڂ̖K�⎞�ԃ��f��
   */
  protected ACListModelAdapter getHoumonKangoNumberOfPeopleTimeModel(){
    if(houmonKangoNumberOfPeopleTimeModel==null){
      houmonKangoNumberOfPeopleTimeModel = new ACListModelAdapter();
      addHoumonKangoNumberOfPeopleTimeModel();
    }
    return houmonKangoNumberOfPeopleTimeModel;
  }

  /**
   * 30���������擾���܂��B
   * @return 30������
   */
  public ACRadioButtonItem getHoumonKangoNumberOfPeopleTimeItem1(){
    if(houmonKangoNumberOfPeopleTimeItem1==null){

      houmonKangoNumberOfPeopleTimeItem1 = new ACRadioButtonItem();

      houmonKangoNumberOfPeopleTimeItem1.setText("30������");

      houmonKangoNumberOfPeopleTimeItem1.setGroup(getHoumonKangoNumberOfPeopleTime());

      houmonKangoNumberOfPeopleTimeItem1.setConstraints(VRLayout.FLOW);

      addHoumonKangoNumberOfPeopleTimeItem1();
    }
    return houmonKangoNumberOfPeopleTimeItem1;

  }

  /**
   * 30���ȏ���擾���܂��B
   * @return 30���ȏ�
   */
  public ACRadioButtonItem getHoumonKangoNumberOfPeopleTimeItem2(){
    if(houmonKangoNumberOfPeopleTimeItem2==null){

      houmonKangoNumberOfPeopleTimeItem2 = new ACRadioButtonItem();

      houmonKangoNumberOfPeopleTimeItem2.setText("30���ȏ�");

      houmonKangoNumberOfPeopleTimeItem2.setGroup(getHoumonKangoNumberOfPeopleTime());

      houmonKangoNumberOfPeopleTimeItem2.setConstraints(VRLayout.FLOW);

      addHoumonKangoNumberOfPeopleTimeItem2();
    }
    return houmonKangoNumberOfPeopleTimeItem2;

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
  public ACRadioButtonItem getProviderAddMountainousAreaRafioRadioItem1(){
    if(providerAddMountainousAreaRafioRadioItem1==null){

      providerAddMountainousAreaRafioRadioItem1 = new ACRadioButtonItem();

      providerAddMountainousAreaRafioRadioItem1.setText("�Ȃ�");

      providerAddMountainousAreaRafioRadioItem1.setGroup(getProviderAddMountainousAreaRafioRadioGroup());

      providerAddMountainousAreaRafioRadioItem1.setConstraints(VRLayout.FLOW);

      addProviderAddMountainousAreaRafioRadioItem1();
    }
    return providerAddMountainousAreaRafioRadioItem1;

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
   * �^�u�R���擾���܂��B
   * @return �^�u�R
   */
  public ACPanel getTab3(){
    if(tab3==null){

      tab3 = new ACPanel();

      tab3.setFollowChildEnabled(true);

      addTab3();
    }
    return tab3;

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
   * �K��Ō�w�����Ԃ̓������Z���擾���܂��B
   * @return �K��Ō�w�����Ԃ̓������Z
   */
  public ACValueArrayRadioButtonGroup getHoumonNissuReduceRadio(){
    if(houmonNissuReduceRadio==null){

      houmonNissuReduceRadio = new ACValueArrayRadioButtonGroup();

      getHoumonNissuReduceRadioContainer().setText("�K��Ō�w�����Ԃ̓������Z");

      houmonNissuReduceRadio.setBindPath("1130120");

      houmonNissuReduceRadio.setNoSelectIndex(0);

      houmonNissuReduceRadio.setUseClearButton(false);

      houmonNissuReduceRadio.setModel(getHoumonNissuReduceRadioModel());

      houmonNissuReduceRadio.setValues(new int[]{1,2});

      addHoumonNissuReduceRadio();
    }
    return houmonNissuReduceRadio;

  }

  /**
   * �K��Ō�w�����Ԃ̓������Z�R���e�i���擾���܂��B
   * @return �K��Ō�w�����Ԃ̓������Z�R���e�i
   */
  protected ACLabelContainer getHoumonNissuReduceRadioContainer(){
    if(houmonNissuReduceRadioContainer==null){
      houmonNissuReduceRadioContainer = new ACLabelContainer();
      houmonNissuReduceRadioContainer.setFollowChildEnabled(true);
      houmonNissuReduceRadioContainer.setVAlignment(VRLayout.CENTER);
      houmonNissuReduceRadioContainer.add(getHoumonNissuReduceRadio(), null);
    }
    return houmonNissuReduceRadioContainer;
  }

  /**
   * �K��Ō�w�����Ԃ̓������Z���f�����擾���܂��B
   * @return �K��Ō�w�����Ԃ̓������Z���f��
   */
  protected ACListModelAdapter getHoumonNissuReduceRadioModel(){
    if(houmonNissuReduceRadioModel==null){
      houmonNissuReduceRadioModel = new ACListModelAdapter();
      addHoumonNissuReduceRadioModel();
    }
    return houmonNissuReduceRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getHoumonNissuReduceRadioItem1(){
    if(houmonNissuReduceRadioItem1==null){

      houmonNissuReduceRadioItem1 = new ACRadioButtonItem();

      houmonNissuReduceRadioItem1.setText("�Ȃ�");

      houmonNissuReduceRadioItem1.setGroup(getHoumonNissuReduceRadio());

      houmonNissuReduceRadioItem1.setConstraints(VRLayout.FLOW);

      addHoumonNissuReduceRadioItem1();
    }
    return houmonNissuReduceRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getHoumonNissuReduceRadioItem2(){
    if(houmonNissuReduceRadioItem2==null){

      houmonNissuReduceRadioItem2 = new ACRadioButtonItem();

      houmonNissuReduceRadioItem2.setText("����");

      houmonNissuReduceRadioItem2.setGroup(getHoumonNissuReduceRadio());

      houmonNissuReduceRadioItem2.setConstraints(VRLayout.FLOW);

      addHoumonNissuReduceRadioItem2();
    }
    return houmonNissuReduceRadioItem2;

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
   * �R���X�g���N�^�ł��B
   */
  public QS001_11311_201204Design() {

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

    this.add(getHoumonKangoKaigoPatterns(), VRLayout.CLIENT);

  }

  /**
   * �K��Ō�i���j�p�^�[���̈�j�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKangoKaigoPatterns(){

    houmonKangoKaigoPatterns.add(getTabs(), VRLayout.CLIENT);

  }

  /**
   * �^�u�ɓ������ڂ�ǉ����܂��B
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

    tab1.add(getHoumonKangoKaigoFacilityTypeContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getHoumonKangoKaigoClassContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getHoumonKangoKaigoTimeContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getHoumonKangoKaigoTimeZoneContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getSpecialManagementRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getTwoOrMoreTimesCheck(), VRLayout.FLOW);

    tab1.add(getCrackOnDayCheck(), VRLayout.FLOW_INSETLINE);

    tab1.add(getPrintable(), VRLayout.FLOW_RETURN);

    tab1.add(getHoumonKangoKaigoTimeContena(), VRLayout.FLOW_DOUBLEINSETLINE_RETURN);

  }

  /**
   * �K��Ō�{�ݎ�ʂɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKangoKaigoFacilityType(){

  }

  /**
   * �K��Ō�{�ݎ�ʃ��f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKangoKaigoFacilityTypeModel(){

    getHoumonKangoKaigoStation().setButtonIndex(1);

    getHoumonKangoKaigoFacilityTypeModel().add(getHoumonKangoKaigoStation());

    getHoumonKangoKaigoMedicalInstitution().setButtonIndex(2);

    getHoumonKangoKaigoFacilityTypeModel().add(getHoumonKangoKaigoMedicalInstitution());

    getHoumonKangoKaigoFacilityTypeItem3().setButtonIndex(3);

    getHoumonKangoKaigoFacilityTypeModel().add(getHoumonKangoKaigoFacilityTypeItem3());

  }

  /**
   * �w��K��Ō�X�e�[�V�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKangoKaigoStation(){

  }

  /**
   * ��Ë@�ւɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKangoKaigoMedicalInstitution(){

  }

  /**
   * �������E�����Ή��T�[�r�X�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKangoKaigoFacilityTypeItem3(){

  }

  /**
   * �K��Ō�E���敪�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKangoKaigoClass(){

  }

  /**
   * �K��Ō�E���敪���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKangoKaigoClassModel(){

    getHoumonKangoKaigoClass1().setButtonIndex(1);

    getHoumonKangoKaigoClassModel().add(getHoumonKangoKaigoClass1());

    getHoumonKangoKaigoClass2().setButtonIndex(2);

    getHoumonKangoKaigoClassModel().add(getHoumonKangoKaigoClass2());

    getHoumonKangoKaigoClass3().setButtonIndex(3);

    getHoumonKangoKaigoClassModel().add(getHoumonKangoKaigoClass3());

  }

  /**
   * ���łɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKangoKaigoClass1(){

  }

  /**
   * �y�łɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKangoKaigoClass2(){

  }

  /**
   * ���w�Ö@�m���͍�ƗÖ@�m���͌��꒮�o�m�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKangoKaigoClass3(){

  }

  /**
   * �K��Ō쎞�ԋ敪�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKangoKaigoTime(){

  }

  /**
   * �K��Ō쎞�ԋ敪���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKangoKaigoTimeModel(){

    getHoumonKangoKaigoTime1().setButtonIndex(1);

    getHoumonKangoKaigoTimeModel().add(getHoumonKangoKaigoTime1());

    getHoumonKangoKaigoTime2().setButtonIndex(2);

    getHoumonKangoKaigoTimeModel().add(getHoumonKangoKaigoTime2());

    getHoumonKangoKaigoTime3().setButtonIndex(3);

    getHoumonKangoKaigoTimeModel().add(getHoumonKangoKaigoTime3());

    getHoumonKangoKaigoTime4().setButtonIndex(4);

    getHoumonKangoKaigoTimeModel().add(getHoumonKangoKaigoTime4());

  }

  /**
   * 20�������ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKangoKaigoTime1(){

  }

  /**
   * 30�������ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKangoKaigoTime2(){

  }

  /**
   * 30���ȏ�A1���Ԗ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKangoKaigoTime3(){

  }

  /**
   * 1���Ԉȏ�A1���Ԕ������ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKangoKaigoTime4(){

  }

  /**
   * �K��Ō��쎞�ԑтɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKangoKaigoTimeZone(){

  }

  /**
   * �K��Ō��쎞�ԑу��f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKangoKaigoTimeZoneModel(){

    getHoumonKangoKaigoTimeZoneNormal().setButtonIndex(1);

    getHoumonKangoKaigoTimeZoneModel().add(getHoumonKangoKaigoTimeZoneNormal());

    getHoumonKangoKaigoTimeZoneEarlyMorning().setButtonIndex(2);

    getHoumonKangoKaigoTimeZoneModel().add(getHoumonKangoKaigoTimeZoneEarlyMorning());

    getHoumonKangoKaigoTimeZoneNighttime().setButtonIndex(3);

    getHoumonKangoKaigoTimeZoneModel().add(getHoumonKangoKaigoTimeZoneNighttime());

    getHoumonKangoKaigoTimeZoneMidnight().setButtonIndex(4);

    getHoumonKangoKaigoTimeZoneModel().add(getHoumonKangoKaigoTimeZoneMidnight());

  }

  /**
   * �ʏ�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKangoKaigoTimeZoneNormal(){

  }

  /**
   * �����ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKangoKaigoTimeZoneEarlyMorning(){

  }

  /**
   * ��Ԃɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKangoKaigoTimeZoneNighttime(){

  }

  /**
   * �[��ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKangoKaigoTimeZoneMidnight(){

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
   * 1����2����z���Ď��{�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTwoOrMoreTimesCheck(){

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
  protected void addHoumonKangoKaigoTimeContena(){

    houmonKangoKaigoTimeContena.add(getHoumonKangoKaigoBeginTimeContainer(), VRLayout.FLOW);

    houmonKangoKaigoTimeContena.add(getHoumonKangoKaigoEndTimeContainer(), VRLayout.FLOW);

  }

  /**
   * �J�n�����R���{�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKangoKaigoBeginTime(){

  }

  /**
   * �J�n�����R���{���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKangoKaigoBeginTimeModel(){

  }

  /**
   * �I�������R���{�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKangoKaigoEndTime(){

  }

  /**
   * �I�������R���{���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKangoKaigoEndTimeModel(){

  }

  /**
   * �^�u2�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTab2(){

    tab2.add(getHoumonKangoKaigoLongTimeContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getHoumonKangoKaigoUrgentTimeRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getHoumonKangoKaigoUrgentTime2RadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getHoumonKangoKaigoTerminalRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getInitialAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getLeavingHospitalGuidanceAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getCooperationMedicalCareAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getServiceAddProvisionStructuralRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getHoumonKangoNumberOfPeopleContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getHoumonKangoNumberOfPeopleTimeContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getProviderAddMountainousAreaRafioRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * �����ԖK��Ō���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKangoKaigoLongTime(){

  }

  /**
   * �����ԖK��Ō���Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKangoKaigoLongTimeModel(){

    getHoumonKangoKaigoLongTimeItem1().setButtonIndex(1);

    getHoumonKangoKaigoLongTimeModel().add(getHoumonKangoKaigoLongTimeItem1());

    getHoumonKangoKaigoLongTimeItem2().setButtonIndex(2);

    getHoumonKangoKaigoLongTimeModel().add(getHoumonKangoKaigoLongTimeItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKangoKaigoLongTimeItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKangoKaigoLongTimeItem2(){

  }

  /**
   * �ً}���K��Ō���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKangoKaigoUrgentTimeRadio(){

  }

  /**
   * �ً}���K��Ō���Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKangoKaigoUrgentTimeRadioModel(){

    getHoumonKangoKaigoUrgentTimeRadioItem1().setButtonIndex(1);

    getHoumonKangoKaigoUrgentTimeRadioModel().add(getHoumonKangoKaigoUrgentTimeRadioItem1());

    getHoumonKangoKaigoUrgentTimeRadioItem2().setButtonIndex(2);

    getHoumonKangoKaigoUrgentTimeRadioModel().add(getHoumonKangoKaigoUrgentTimeRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKangoKaigoUrgentTimeRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKangoKaigoUrgentTimeRadioItem2(){

  }

  /**
   * �ً}���K��Ō���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKangoKaigoUrgentTime2Radio(){

  }

  /**
   * �ً}���K��Ō���Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKangoKaigoUrgentTime2RadioModel(){

    getHoumonKangoKaigoUrgentTime2RadioItem1().setButtonIndex(1);

    getHoumonKangoKaigoUrgentTime2RadioModel().add(getHoumonKangoKaigoUrgentTime2RadioItem1());

    getHoumonKangoKaigoUrgentTime2RadioItem2().setButtonIndex(2);

    getHoumonKangoKaigoUrgentTime2RadioModel().add(getHoumonKangoKaigoUrgentTime2RadioItem2());

    getHoumonKangoKaigoUrgentTime2RadioItem3().setButtonIndex(3);

    getHoumonKangoKaigoUrgentTime2RadioModel().add(getHoumonKangoKaigoUrgentTime2RadioItem3());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKangoKaigoUrgentTime2RadioItem1(){

  }

  /**
   * �w��K��Ō�X�e�[�V�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKangoKaigoUrgentTime2RadioItem2(){

  }

  /**
   * ��Ë@�ւɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKangoKaigoUrgentTime2RadioItem3(){

  }

  /**
   * �^�[�~�i���P�A���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKangoKaigoTerminalRadio(){

  }

  /**
   * �^�[�~�i���P�A���Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKangoKaigoTerminalRadioModel(){

    getHoumonKangoKaigoTerminalRadioItem1().setButtonIndex(1);

    getHoumonKangoKaigoTerminalRadioModel().add(getHoumonKangoKaigoTerminalRadioItem1());

    getHoumonKangoKaigoTerminalRadioItem2().setButtonIndex(2);

    getHoumonKangoKaigoTerminalRadioModel().add(getHoumonKangoKaigoTerminalRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKangoKaigoTerminalRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKangoKaigoTerminalRadioItem2(){

  }

  /**
   * ������Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addInitialAddRadioGroup(){

  }

  /**
   * ������Z���f���ɓ������ڂ�ǉ����܂��B
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
   * �މ@�������w�����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addLeavingHospitalGuidanceAddRadioGroup(){

  }

  /**
   * �މ@�������w�����Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addLeavingHospitalGuidanceAddRadioGroupModel(){

    getLeavingHospitalGuidanceAddRadioItem1().setButtonIndex(1);

    getLeavingHospitalGuidanceAddRadioGroupModel().add(getLeavingHospitalGuidanceAddRadioItem1());

    getLeavingHospitalGuidanceAddRadioItem2().setButtonIndex(2);

    getLeavingHospitalGuidanceAddRadioGroupModel().add(getLeavingHospitalGuidanceAddRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addLeavingHospitalGuidanceAddRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addLeavingHospitalGuidanceAddRadioItem2(){

  }

  /**
   * �Ō�E���E���A�g�������Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addCooperationMedicalCareAddRadioGroup(){

  }

  /**
   * �Ō�E���E���A�g�������Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCooperationMedicalCareAddRadioGroupModel(){

    getCooperationMedicalCareAddRadioItem1().setButtonIndex(1);

    getCooperationMedicalCareAddRadioGroupModel().add(getCooperationMedicalCareAddRadioItem1());

    getCooperationMedicalCareAddRadioItem2().setButtonIndex(2);

    getCooperationMedicalCareAddRadioGroupModel().add(getCooperationMedicalCareAddRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addCooperationMedicalCareAddRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addCooperationMedicalCareAddRadioItem2(){

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
   * �K��l���ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKangoNumberOfPeople(){

  }

  /**
   * �K��l�����f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKangoNumberOfPeopleModel(){

    getHoumonKangoNumberOfPeople1().setButtonIndex(1);

    getHoumonKangoNumberOfPeopleModel().add(getHoumonKangoNumberOfPeople1());

    getHoumonKangoNumberOfPeople2().setButtonIndex(2);

    getHoumonKangoNumberOfPeopleModel().add(getHoumonKangoNumberOfPeople2());

  }

  /**
   * 1�l�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKangoNumberOfPeople1(){

  }

  /**
   * 2�l�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKangoNumberOfPeople2(){

  }

  /**
   * 2�l�ڂ̖K�⎞�Ԃɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKangoNumberOfPeopleTime(){

  }

  /**
   * 2�l�ڂ̖K�⎞�ԃ��f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKangoNumberOfPeopleTimeModel(){

    getHoumonKangoNumberOfPeopleTimeItem1().setButtonIndex(1);

    getHoumonKangoNumberOfPeopleTimeModel().add(getHoumonKangoNumberOfPeopleTimeItem1());

    getHoumonKangoNumberOfPeopleTimeItem2().setButtonIndex(2);

    getHoumonKangoNumberOfPeopleTimeModel().add(getHoumonKangoNumberOfPeopleTimeItem2());

  }

  /**
   * 30�������ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKangoNumberOfPeopleTimeItem1(){

  }

  /**
   * 30���ȏ�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKangoNumberOfPeopleTimeItem2(){

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

    getProviderAddMountainousAreaRafioRadioItem1().setButtonIndex(1);

    getProviderAddMountainousAreaRafioRadioGroupModel().add(getProviderAddMountainousAreaRafioRadioItem1());

    getProviderAddMountainousAreaRafioRadioItem2().setButtonIndex(2);

    getProviderAddMountainousAreaRafioRadioGroupModel().add(getProviderAddMountainousAreaRafioRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderAddMountainousAreaRafioRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderAddMountainousAreaRafioRadioItem2(){

  }

  /**
   * �^�u�R�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTab3(){

    tab3.add(getHoumonNeededRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab3.add(getHoumonNissuReduceRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab3.add(getCalculationDivisionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

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
   * �K��Ō�w�����Ԃ̓������Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonNissuReduceRadio(){

  }

  /**
   * �K��Ō�w�����Ԃ̓������Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonNissuReduceRadioModel(){

    getHoumonNissuReduceRadioItem1().setButtonIndex(1);

    getHoumonNissuReduceRadioModel().add(getHoumonNissuReduceRadioItem1());

    getHoumonNissuReduceRadioItem2().setButtonIndex(2);

    getHoumonNissuReduceRadioModel().add(getHoumonNissuReduceRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonNissuReduceRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonNissuReduceRadioItem2(){

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
      ACFrame.debugStart(new ACAffairInfo(QS001_11311_201204Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QS001_11311_201204Design getThis() {
    return this;
  }
}
