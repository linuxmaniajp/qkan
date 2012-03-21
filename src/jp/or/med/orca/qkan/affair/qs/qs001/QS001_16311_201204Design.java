
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
 * �쐬��: 2012/03/07  ���{�R���s���[�^�[������� ����@��F �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �T�[�r�X�\��쐬/�ύX (S)
 * �v���Z�X �T�[�r�X�\��T�� (001)
 * �v���O���� �T�[�r�X�p�^�[�����\�h�K��Ō� (QS001_16311_201204)
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
 * �T�[�r�X�p�^�[�����\�h�K��Ō��ʍ��ڃf�U�C��(QS001_16311_201204) 
 */
public class QS001_16311_201204Design extends QS001ServicePanel {
  //GUI�R���|�[�l���g

  private JTabbedPane preventionVisitNursingPatterns;

  private ACPanel tab1;

  private ACValueArrayRadioButtonGroup houmonKangoKaigoFacilityType;

  private ACLabelContainer houmonKangoKaigoFacilityTypeContainer;

  private ACListModelAdapter houmonKangoKaigoFacilityTypeModel;

  private ACRadioButtonItem houmonKangoKaigoStation;

  private ACRadioButtonItem houmonKangoKaigoMedicalInstitution;

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

  private ACValueArrayRadioButtonGroup houmonKangoKaigoSpecialManageRadio;

  private ACLabelContainer houmonKangoKaigoSpecialManageRadioContainer;

  private ACListModelAdapter houmonKangoKaigoSpecialManageRadioModel;

  private ACRadioButtonItem houmonKangoKaigoSpecialManageRadioItem1;

  private ACRadioButtonItem houmonKangoKaigoSpecialManageRadioItem2;

  private ACRadioButtonItem houmonKangoKaigoSpecialManageRadioItem3;

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

  private ACIntegerCheckBox twoOrMoreTimesCheck;

  private ACBackLabelContainer houmonKangoKaigoTimeContena;

  private ACTimeComboBox houmonKangoKaigoBeginTime;

  private ACLabelContainer houmonKangoKaigoBeginTimeContainer;

  private ACComboBoxModelAdapter houmonKangoKaigoBeginTimeModel;

  private ACTimeComboBox houmonKangoKaigoEndTime;

  private ACLabelContainer houmonKangoKaigoEndTimeContainer;

  private ACComboBoxModelAdapter houmonKangoKaigoEndTimeModel;

  private ACPanel tab2;

  private ACValueArrayRadioButtonGroup visitDemandRadioGroup;

  private ACLabelContainer visitDemandRadioGroupContainer;

  private ACListModelAdapter visitDemandRadioGroupModel;

  private ACRadioButtonItem visitDemandRadioItem1;

  private ACRadioButtonItem visitDemandRadioItem2;

  private ACValueArrayRadioButtonGroup serviceAddProvisionStructuralRadioGroup;

  private ACLabelContainer serviceAddProvisionStructuralRadioGroupContainer;

  private ACListModelAdapter serviceAddProvisionStructuralRadioGroupModel;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem1;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem2;

  private ACValueArrayRadioButtonGroup visitPersonAddRadio;

  private ACLabelContainer visitPersonAddRadioContainer;

  private ACListModelAdapter visitPersonAddRadioModel;

  private ACRadioButtonItem visitPersonAddRadioItem1;

  private ACRadioButtonItem visitPersonAddRadioItem2;

  private ACValueArrayRadioButtonGroup houmonKangoNumberOfPeopleTime;

  private ACLabelContainer houmonKangoNumberOfPeopleTimeContainer;

  private ACListModelAdapter houmonKangoNumberOfPeopleTimeModel;

  private ACRadioButtonItem houmonKangoNumberOfPeopleTimeItem1;

  private ACRadioButtonItem houmonKangoNumberOfPeopleTimeItem2;

  private ACValueArrayRadioButtonGroup houmonKaigoFirstAddRadioGroup;

  private ACLabelContainer houmonKaigoFirstAddRadioGroupContainer;

  private ACListModelAdapter houmonKaigoFirstAddRadioGroupModel;

  private ACRadioButtonItem houmonKaigoFirstAddRadioItem1;

  private ACRadioButtonItem houmonKaigoFirstAddRadioItem2;

  private ACValueArrayRadioButtonGroup leavingHospitalGuidanceAddRadioGroup;

  private ACLabelContainer leavingHospitalGuidanceAddRadioGroupContainer;

  private ACListModelAdapter leavingHospitalGuidanceAddRadioGroupModel;

  private ACRadioButtonItem leavingHospitalGuidanceAddRadioItem1;

  private ACRadioButtonItem leavingHospitalGuidanceAddRadioItem2;

  private ACValueArrayRadioButtonGroup providerAddMountainousAreaRafioRadioGroup;

  private ACLabelContainer providerAddMountainousAreaRafioRadioGroupContainer;

  private ACListModelAdapter providerAddMountainousAreaRafioRadioGroupModel;

  private ACRadioButtonItem providerAddMountainousAreaRafioItem1;

  private ACRadioButtonItem providerAddMountainousAreaRafioRadioItem2;

  private ACValueArrayRadioButtonGroup calculationDivision;

  private ACLabelContainer calculationDivisionContainer;

  private ACListModelAdapter calculationDivisionModel;

  private ACRadioButtonItem calculationDivisionNormal;

  private ACRadioButtonItem calculationDivisionAddOnly;

  //getter

  /**
   * ���\�h�K��Ō�p�^�[���̈���擾���܂��B
   * @return ���\�h�K��Ō�p�^�[���̈�
   */
  public JTabbedPane getPreventionVisitNursingPatterns(){
    if(preventionVisitNursingPatterns==null){

      preventionVisitNursingPatterns = new JTabbedPane();

      addPreventionVisitNursingPatterns();
    }
    return preventionVisitNursingPatterns;

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
   * �K��Ō�{�ݎ�ʂ��擾���܂��B
   * @return �K��Ō�{�ݎ��
   */
  public ACValueArrayRadioButtonGroup getHoumonKangoKaigoFacilityType(){
    if(houmonKangoKaigoFacilityType==null){

      houmonKangoKaigoFacilityType = new ACValueArrayRadioButtonGroup();

      getHoumonKangoKaigoFacilityTypeContainer().setText("�{�ݓ��̋敪");

      houmonKangoKaigoFacilityType.setBindPath("1630101");

      houmonKangoKaigoFacilityType.setUseClearButton(false);

      houmonKangoKaigoFacilityType.setModel(getHoumonKangoKaigoFacilityTypeModel());

      houmonKangoKaigoFacilityType.setValues(new int[]{1,2});

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

      houmonKangoKaigoMedicalInstitution.setConstraints(VRLayout.FLOW);

      addHoumonKangoKaigoMedicalInstitution();
    }
    return houmonKangoKaigoMedicalInstitution;

  }

  /**
   * �K��Ō�E���敪���擾���܂��B
   * @return �K��Ō�E���敪
   */
  public ACValueArrayRadioButtonGroup getHoumonKangoKaigoClass(){
    if(houmonKangoKaigoClass==null){

      houmonKangoKaigoClass = new ACValueArrayRadioButtonGroup();

      getHoumonKangoKaigoClassContainer().setText("�E���敪");

      houmonKangoKaigoClass.setBindPath("1630102");

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

      houmonKangoKaigoTime.setBindPath("1630107");

      houmonKangoKaigoTime.setNoSelectIndex(0);

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
   * 30���ȏ�A�ꎞ�Ԗ������擾���܂��B
   * @return 30���ȏ�A�ꎞ�Ԗ���
   */
  public ACRadioButtonItem getHoumonKangoKaigoTime3(){
    if(houmonKangoKaigoTime3==null){

      houmonKangoKaigoTime3 = new ACRadioButtonItem();

      houmonKangoKaigoTime3.setText("30���ȏ�A�ꎞ�Ԗ���");

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

      houmonKangoKaigoTimeZone.setBindPath("1630104");

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
  public ACValueArrayRadioButtonGroup getHoumonKangoKaigoSpecialManageRadio(){
    if(houmonKangoKaigoSpecialManageRadio==null){

      houmonKangoKaigoSpecialManageRadio = new ACValueArrayRadioButtonGroup();

      getHoumonKangoKaigoSpecialManageRadioContainer().setText("���ʊǗ����Z");

      houmonKangoKaigoSpecialManageRadio.setBindPath("1630106");

      houmonKangoKaigoSpecialManageRadio.setUseClearButton(false);

      houmonKangoKaigoSpecialManageRadio.setModel(getHoumonKangoKaigoSpecialManageRadioModel());

      houmonKangoKaigoSpecialManageRadio.setValues(new int[]{1,2,3});

      addHoumonKangoKaigoSpecialManageRadio();
    }
    return houmonKangoKaigoSpecialManageRadio;

  }

  /**
   * ���ʊǗ����Z�R���e�i���擾���܂��B
   * @return ���ʊǗ����Z�R���e�i
   */
  protected ACLabelContainer getHoumonKangoKaigoSpecialManageRadioContainer(){
    if(houmonKangoKaigoSpecialManageRadioContainer==null){
      houmonKangoKaigoSpecialManageRadioContainer = new ACLabelContainer();
      houmonKangoKaigoSpecialManageRadioContainer.setFollowChildEnabled(true);
      houmonKangoKaigoSpecialManageRadioContainer.setVAlignment(VRLayout.CENTER);
      houmonKangoKaigoSpecialManageRadioContainer.add(getHoumonKangoKaigoSpecialManageRadio(), null);
    }
    return houmonKangoKaigoSpecialManageRadioContainer;
  }

  /**
   * ���ʊǗ����Z���f�����擾���܂��B
   * @return ���ʊǗ����Z���f��
   */
  protected ACListModelAdapter getHoumonKangoKaigoSpecialManageRadioModel(){
    if(houmonKangoKaigoSpecialManageRadioModel==null){
      houmonKangoKaigoSpecialManageRadioModel = new ACListModelAdapter();
      addHoumonKangoKaigoSpecialManageRadioModel();
    }
    return houmonKangoKaigoSpecialManageRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getHoumonKangoKaigoSpecialManageRadioItem1(){
    if(houmonKangoKaigoSpecialManageRadioItem1==null){

      houmonKangoKaigoSpecialManageRadioItem1 = new ACRadioButtonItem();

      houmonKangoKaigoSpecialManageRadioItem1.setText("�Ȃ�");

      houmonKangoKaigoSpecialManageRadioItem1.setGroup(getHoumonKangoKaigoSpecialManageRadio());

      houmonKangoKaigoSpecialManageRadioItem1.setConstraints(VRLayout.FLOW);

      addHoumonKangoKaigoSpecialManageRadioItem1();
    }
    return houmonKangoKaigoSpecialManageRadioItem1;

  }

  /**
   * I�^���擾���܂��B
   * @return I�^
   */
  public ACRadioButtonItem getHoumonKangoKaigoSpecialManageRadioItem2(){
    if(houmonKangoKaigoSpecialManageRadioItem2==null){

      houmonKangoKaigoSpecialManageRadioItem2 = new ACRadioButtonItem();

      houmonKangoKaigoSpecialManageRadioItem2.setText("I�^");

      houmonKangoKaigoSpecialManageRadioItem2.setGroup(getHoumonKangoKaigoSpecialManageRadio());

      houmonKangoKaigoSpecialManageRadioItem2.setConstraints(VRLayout.FLOW);

      addHoumonKangoKaigoSpecialManageRadioItem2();
    }
    return houmonKangoKaigoSpecialManageRadioItem2;

  }

  /**
   * II�^���擾���܂��B
   * @return II�^
   */
  public ACRadioButtonItem getHoumonKangoKaigoSpecialManageRadioItem3(){
    if(houmonKangoKaigoSpecialManageRadioItem3==null){

      houmonKangoKaigoSpecialManageRadioItem3 = new ACRadioButtonItem();

      houmonKangoKaigoSpecialManageRadioItem3.setText("II�^");

      houmonKangoKaigoSpecialManageRadioItem3.setGroup(getHoumonKangoKaigoSpecialManageRadio());

      houmonKangoKaigoSpecialManageRadioItem3.setConstraints(VRLayout.FLOW);

      addHoumonKangoKaigoSpecialManageRadioItem3();
    }
    return houmonKangoKaigoSpecialManageRadioItem3;

  }

  /**
   * �����ԖK��Ō���Z���擾���܂��B
   * @return �����ԖK��Ō���Z
   */
  public ACValueArrayRadioButtonGroup getHoumonKangoKaigoLongTime(){
    if(houmonKangoKaigoLongTime==null){

      houmonKangoKaigoLongTime = new ACValueArrayRadioButtonGroup();

      getHoumonKangoKaigoLongTimeContainer().setText("�����ԖK��Ō���Z");

      houmonKangoKaigoLongTime.setBindPath("1630110");

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

      houmonKangoKaigoUrgentTimeRadio.setBindPath("1630105");

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
   * 1����2����z���Ď��{���擾���܂��B
   * @return 1����2����z���Ď��{
   */
  public ACIntegerCheckBox getTwoOrMoreTimesCheck(){
    if(twoOrMoreTimesCheck==null){

      twoOrMoreTimesCheck = new ACIntegerCheckBox();

      twoOrMoreTimesCheck.setText("1����2����z���Ď��{");

      twoOrMoreTimesCheck.setBindPath("1630116");

      twoOrMoreTimesCheck.setSelectValue(2);

      twoOrMoreTimesCheck.setUnSelectValue(1);

      addTwoOrMoreTimesCheck();
    }
    return twoOrMoreTimesCheck;

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

      tab2.setHgap(0);

      tab2.setLabelMargin(0);

      tab2.setVgap(0);

      addTab2();
    }
    return tab2;

  }

  /**
   * ���ꌚ�����Z�҂ւ̃T�[�r�X�񋟂��擾���܂��B
   * @return ���ꌚ�����Z�҂ւ̃T�[�r�X��
   */
  public ACValueArrayRadioButtonGroup getVisitDemandRadioGroup(){
    if(visitDemandRadioGroup==null){

      visitDemandRadioGroup = new ACValueArrayRadioButtonGroup();

      getVisitDemandRadioGroupContainer().setText("���ꌚ�����Z�҂ւ̃T�[�r�X��");

      visitDemandRadioGroup.setBindPath("16");

      visitDemandRadioGroup.setUseClearButton(false);

      visitDemandRadioGroup.setModel(getVisitDemandRadioGroupModel());

      visitDemandRadioGroup.setValues(new int[]{1,2});

      addVisitDemandRadioGroup();
    }
    return visitDemandRadioGroup;

  }

  /**
   * ���ꌚ�����Z�҂ւ̃T�[�r�X�񋟃R���e�i���擾���܂��B
   * @return ���ꌚ�����Z�҂ւ̃T�[�r�X�񋟃R���e�i
   */
  protected ACLabelContainer getVisitDemandRadioGroupContainer(){
    if(visitDemandRadioGroupContainer==null){
      visitDemandRadioGroupContainer = new ACLabelContainer();
      visitDemandRadioGroupContainer.setFollowChildEnabled(true);
      visitDemandRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      visitDemandRadioGroupContainer.add(getVisitDemandRadioGroup(), null);
    }
    return visitDemandRadioGroupContainer;
  }

  /**
   * ���ꌚ�����Z�҂ւ̃T�[�r�X�񋟃��f�����擾���܂��B
   * @return ���ꌚ�����Z�҂ւ̃T�[�r�X�񋟃��f��
   */
  protected ACListModelAdapter getVisitDemandRadioGroupModel(){
    if(visitDemandRadioGroupModel==null){
      visitDemandRadioGroupModel = new ACListModelAdapter();
      addVisitDemandRadioGroupModel();
    }
    return visitDemandRadioGroupModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getVisitDemandRadioItem1(){
    if(visitDemandRadioItem1==null){

      visitDemandRadioItem1 = new ACRadioButtonItem();

      visitDemandRadioItem1.setText("�Ȃ�");

      visitDemandRadioItem1.setGroup(getVisitDemandRadioGroup());

      visitDemandRadioItem1.setConstraints(VRLayout.FLOW);

      addVisitDemandRadioItem1();
    }
    return visitDemandRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getVisitDemandRadioItem2(){
    if(visitDemandRadioItem2==null){

      visitDemandRadioItem2 = new ACRadioButtonItem();

      visitDemandRadioItem2.setText("����");

      visitDemandRadioItem2.setGroup(getVisitDemandRadioGroup());

      visitDemandRadioItem2.setConstraints(VRLayout.FLOW);

      addVisitDemandRadioItem2();
    }
    return visitDemandRadioItem2;

  }

  /**
   * �T�[�r�X�񋟑̐��������Z���擾���܂��B
   * @return �T�[�r�X�񋟑̐��������Z
   */
  public ACValueArrayRadioButtonGroup getServiceAddProvisionStructuralRadioGroup(){
    if(serviceAddProvisionStructuralRadioGroup==null){

      serviceAddProvisionStructuralRadioGroup = new ACValueArrayRadioButtonGroup();

      getServiceAddProvisionStructuralRadioGroupContainer().setText("�T�[�r�X�񋟑̐��������Z");

      serviceAddProvisionStructuralRadioGroup.setBindPath("1630109");

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
   * �K��҂̐l�����擾���܂��B
   * @return �K��҂̐l��
   */
  public ACValueArrayRadioButtonGroup getVisitPersonAddRadio(){
    if(visitPersonAddRadio==null){

      visitPersonAddRadio = new ACValueArrayRadioButtonGroup();

      getVisitPersonAddRadioContainer().setText("�K��҂̐l��");

      visitPersonAddRadio.setBindPath("1630108");

      visitPersonAddRadio.setNoSelectIndex(0);

      visitPersonAddRadio.setUseClearButton(false);

      visitPersonAddRadio.setModel(getVisitPersonAddRadioModel());

      visitPersonAddRadio.setValues(new int[]{1,2});

      addVisitPersonAddRadio();
    }
    return visitPersonAddRadio;

  }

  /**
   * �K��҂̐l���R���e�i���擾���܂��B
   * @return �K��҂̐l���R���e�i
   */
  protected ACLabelContainer getVisitPersonAddRadioContainer(){
    if(visitPersonAddRadioContainer==null){
      visitPersonAddRadioContainer = new ACLabelContainer();
      visitPersonAddRadioContainer.setFollowChildEnabled(true);
      visitPersonAddRadioContainer.setVAlignment(VRLayout.CENTER);
      visitPersonAddRadioContainer.add(getVisitPersonAddRadio(), null);
    }
    return visitPersonAddRadioContainer;
  }

  /**
   * �K��҂̐l�����f�����擾���܂��B
   * @return �K��҂̐l�����f��
   */
  protected ACListModelAdapter getVisitPersonAddRadioModel(){
    if(visitPersonAddRadioModel==null){
      visitPersonAddRadioModel = new ACListModelAdapter();
      addVisitPersonAddRadioModel();
    }
    return visitPersonAddRadioModel;
  }

  /**
   * �Ō�E��1�l�y�щ��E��1�l���擾���܂��B
   * @return �Ō�E��1�l�y�щ��E��1�l
   */
  public ACRadioButtonItem getVisitPersonAddRadioItem1(){
    if(visitPersonAddRadioItem1==null){

      visitPersonAddRadioItem1 = new ACRadioButtonItem();

      visitPersonAddRadioItem1.setText("1�l");

      visitPersonAddRadioItem1.setGroup(getVisitPersonAddRadio());

      visitPersonAddRadioItem1.setConstraints(VRLayout.FLOW);

      addVisitPersonAddRadioItem1();
    }
    return visitPersonAddRadioItem1;

  }

  /**
   * ���E��2�l���擾���܂��B
   * @return ���E��2�l
   */
  public ACRadioButtonItem getVisitPersonAddRadioItem2(){
    if(visitPersonAddRadioItem2==null){

      visitPersonAddRadioItem2 = new ACRadioButtonItem();

      visitPersonAddRadioItem2.setText("2�l�ȏ�");

      visitPersonAddRadioItem2.setGroup(getVisitPersonAddRadio());

      visitPersonAddRadioItem2.setConstraints(VRLayout.FLOW);

      addVisitPersonAddRadioItem2();
    }
    return visitPersonAddRadioItem2;

  }

  /**
   * 2�l�ڂ̖K�⎞�Ԃ��擾���܂��B
   * @return 2�l�ڂ̖K�⎞��
   */
  public ACValueArrayRadioButtonGroup getHoumonKangoNumberOfPeopleTime(){
    if(houmonKangoNumberOfPeopleTime==null){

      houmonKangoNumberOfPeopleTime = new ACValueArrayRadioButtonGroup();

      getHoumonKangoNumberOfPeopleTimeContainer().setText("2�l�ڂ̖K�⎞��");

      houmonKangoNumberOfPeopleTime.setBindPath("1630111");

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
   * ������Z���擾���܂��B
   * @return ������Z
   */
  public ACValueArrayRadioButtonGroup getHoumonKaigoFirstAddRadioGroup(){
    if(houmonKaigoFirstAddRadioGroup==null){

      houmonKaigoFirstAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getHoumonKaigoFirstAddRadioGroupContainer().setText("������Z");

      houmonKaigoFirstAddRadioGroup.setBindPath("1630112");

      houmonKaigoFirstAddRadioGroup.setNoSelectIndex(0);

      houmonKaigoFirstAddRadioGroup.setUseClearButton(false);

      houmonKaigoFirstAddRadioGroup.setModel(getHoumonKaigoFirstAddRadioGroupModel());

      houmonKaigoFirstAddRadioGroup.setValues(new int[]{1,2});

      addHoumonKaigoFirstAddRadioGroup();
    }
    return houmonKaigoFirstAddRadioGroup;

  }

  /**
   * ������Z�R���e�i���擾���܂��B
   * @return ������Z�R���e�i
   */
  protected ACLabelContainer getHoumonKaigoFirstAddRadioGroupContainer(){
    if(houmonKaigoFirstAddRadioGroupContainer==null){
      houmonKaigoFirstAddRadioGroupContainer = new ACLabelContainer();
      houmonKaigoFirstAddRadioGroupContainer.setFollowChildEnabled(true);
      houmonKaigoFirstAddRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      houmonKaigoFirstAddRadioGroupContainer.add(getHoumonKaigoFirstAddRadioGroup(), null);
    }
    return houmonKaigoFirstAddRadioGroupContainer;
  }

  /**
   * ������Z���f�����擾���܂��B
   * @return ������Z���f��
   */
  protected ACListModelAdapter getHoumonKaigoFirstAddRadioGroupModel(){
    if(houmonKaigoFirstAddRadioGroupModel==null){
      houmonKaigoFirstAddRadioGroupModel = new ACListModelAdapter();
      addHoumonKaigoFirstAddRadioGroupModel();
    }
    return houmonKaigoFirstAddRadioGroupModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getHoumonKaigoFirstAddRadioItem1(){
    if(houmonKaigoFirstAddRadioItem1==null){

      houmonKaigoFirstAddRadioItem1 = new ACRadioButtonItem();

      houmonKaigoFirstAddRadioItem1.setText("�Ȃ�");

      houmonKaigoFirstAddRadioItem1.setGroup(getHoumonKaigoFirstAddRadioGroup());

      houmonKaigoFirstAddRadioItem1.setConstraints(VRLayout.FLOW);

      addHoumonKaigoFirstAddRadioItem1();
    }
    return houmonKaigoFirstAddRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getHoumonKaigoFirstAddRadioItem2(){
    if(houmonKaigoFirstAddRadioItem2==null){

      houmonKaigoFirstAddRadioItem2 = new ACRadioButtonItem();

      houmonKaigoFirstAddRadioItem2.setText("����");

      houmonKaigoFirstAddRadioItem2.setGroup(getHoumonKaigoFirstAddRadioGroup());

      houmonKaigoFirstAddRadioItem2.setConstraints(VRLayout.FLOW);

      addHoumonKaigoFirstAddRadioItem2();
    }
    return houmonKaigoFirstAddRadioItem2;

  }

  /**
   * �މ@�������w�����Z���擾���܂��B
   * @return �މ@�������w�����Z
   */
  public ACValueArrayRadioButtonGroup getLeavingHospitalGuidanceAddRadioGroup(){
    if(leavingHospitalGuidanceAddRadioGroup==null){

      leavingHospitalGuidanceAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getLeavingHospitalGuidanceAddRadioGroupContainer().setText("�މ@�������w�����Z");

      leavingHospitalGuidanceAddRadioGroup.setBindPath("1630113");

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
  public QS001_16311_201204Design() {

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

    this.add(getPreventionVisitNursingPatterns(), VRLayout.CLIENT);

  }

  /**
   * ���\�h�K��Ō�p�^�[���̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPreventionVisitNursingPatterns(){

    preventionVisitNursingPatterns.addTab("1", getTab1());

    preventionVisitNursingPatterns.addTab("2", getTab2());

  }

  /**
   * �^�u1�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTab1(){

    tab1.add(getHoumonKangoKaigoFacilityTypeContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getHoumonKangoKaigoClassContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getHoumonKangoKaigoTimeContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getHoumonKangoKaigoTimeZoneContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getHoumonKangoKaigoSpecialManageRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getHoumonKangoKaigoLongTimeContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getHoumonKangoKaigoUrgentTimeRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getTwoOrMoreTimesCheck(), VRLayout.FLOW);

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
   * 30���ȏ�A�ꎞ�Ԗ����ɓ������ڂ�ǉ����܂��B
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
  protected void addHoumonKangoKaigoSpecialManageRadio(){

  }

  /**
   * ���ʊǗ����Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKangoKaigoSpecialManageRadioModel(){

    getHoumonKangoKaigoSpecialManageRadioItem1().setButtonIndex(1);

    getHoumonKangoKaigoSpecialManageRadioModel().add(getHoumonKangoKaigoSpecialManageRadioItem1());

    getHoumonKangoKaigoSpecialManageRadioItem2().setButtonIndex(2);

    getHoumonKangoKaigoSpecialManageRadioModel().add(getHoumonKangoKaigoSpecialManageRadioItem2());

    getHoumonKangoKaigoSpecialManageRadioItem3().setButtonIndex(3);

    getHoumonKangoKaigoSpecialManageRadioModel().add(getHoumonKangoKaigoSpecialManageRadioItem3());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKangoKaigoSpecialManageRadioItem1(){

  }

  /**
   * I�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKangoKaigoSpecialManageRadioItem2(){

  }

  /**
   * II�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKangoKaigoSpecialManageRadioItem3(){

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
   * 1����2����z���Ď��{�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTwoOrMoreTimesCheck(){

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

    tab2.add(getVisitDemandRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getServiceAddProvisionStructuralRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getVisitPersonAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getHoumonKangoNumberOfPeopleTimeContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getHoumonKaigoFirstAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getLeavingHospitalGuidanceAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getProviderAddMountainousAreaRafioRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getCalculationDivisionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * ���ꌚ�����Z�҂ւ̃T�[�r�X�񋟂ɓ������ڂ�ǉ����܂��B
   */
  protected void addVisitDemandRadioGroup(){

  }

  /**
   * ���ꌚ�����Z�҂ւ̃T�[�r�X�񋟃��f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addVisitDemandRadioGroupModel(){

    getVisitDemandRadioItem1().setButtonIndex(1);

    getVisitDemandRadioGroupModel().add(getVisitDemandRadioItem1());

    getVisitDemandRadioItem2().setButtonIndex(2);

    getVisitDemandRadioGroupModel().add(getVisitDemandRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addVisitDemandRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addVisitDemandRadioItem2(){

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
   * �K��҂̐l���ɓ������ڂ�ǉ����܂��B
   */
  protected void addVisitPersonAddRadio(){

  }

  /**
   * �K��҂̐l�����f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addVisitPersonAddRadioModel(){

    getVisitPersonAddRadioItem1().setButtonIndex(1);

    getVisitPersonAddRadioModel().add(getVisitPersonAddRadioItem1());

    getVisitPersonAddRadioItem2().setButtonIndex(2);

    getVisitPersonAddRadioModel().add(getVisitPersonAddRadioItem2());

  }

  /**
   * �Ō�E��1�l�y�щ��E��1�l�ɓ������ڂ�ǉ����܂��B
   */
  protected void addVisitPersonAddRadioItem1(){

  }

  /**
   * ���E��2�l�ɓ������ڂ�ǉ����܂��B
   */
  protected void addVisitPersonAddRadioItem2(){

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
   * ������Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKaigoFirstAddRadioGroup(){

  }

  /**
   * ������Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKaigoFirstAddRadioGroupModel(){

    getHoumonKaigoFirstAddRadioItem1().setButtonIndex(1);

    getHoumonKaigoFirstAddRadioGroupModel().add(getHoumonKaigoFirstAddRadioItem1());

    getHoumonKaigoFirstAddRadioItem2().setButtonIndex(2);

    getHoumonKaigoFirstAddRadioGroupModel().add(getHoumonKaigoFirstAddRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKaigoFirstAddRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKaigoFirstAddRadioItem2(){

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
      ACFrame.debugStart(new ACAffairInfo(QS001_16311_201204Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QS001_16311_201204Design getThis() {
    return this;
  }
}
