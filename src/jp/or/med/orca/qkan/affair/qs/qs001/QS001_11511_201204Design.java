
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
 * �쐬��: 2012/02/29  ���{�R���s���[�^�[������� ����@��F �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �T�[�r�X�\��쐬/�ύX (S)
 * �v���Z�X �T�[�r�X�\��T�� (001)
 * �v���O���� �T�[�r�X�p�^�[���ʏ���� (QS001_11511_201204)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
import java.awt.Component;

import javax.swing.JTabbedPane;

import jp.nichicom.ac.component.ACComboBox;
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
 * �T�[�r�X�p�^�[���ʏ�����ʍ��ڃf�U�C��(QS001_11511_201204) 
 */
public class QS001_11511_201204Design extends QS001ServicePanel {
  //GUI�R���|�[�l���g

  private JTabbedPane tsuusyoKaigoPatterns;

  private ACPanel tab1;

  private ACLabelContainer tsuusyoKaigoFacilitiesDivisionContainer;

  private ACValueArrayRadioButtonGroup tsuusyoKaigoTimeContenaFacilityDivision;

  private ACListModelAdapter tsuusyoKaigoTimeContenaFacilityDivisionModel;

  private ACRadioButtonItem tsuusyoKaigoTimeContenaFacilityDivisionItem1;

  private ACRadioButtonItem tsuusyoKaigoTimeContenaFacilityDivisionItem2;

  private ACRadioButtonItem tsuusyoKaigoFacilitiesDivisionProviderTypeRadio2;

  private ACRadioButtonItem tsuusyoKaigoFacilitiesDivisionProviderTypeRadio3;

  private ACRadioButtonItem tsuusyoKaigoTimeContenaFacilityDivisionItem3;

  private ACComboBox tsuusyoKaigoTimeDivision;

  private ACLabelContainer tsuusyoKaigoTimeDivisionContainer;

  private ACComboBoxModelAdapter tsuusyoKaigoTimeDivisionModel;

  private ACLabelContainer tsuusyoKaigoAdditionFunctionTrainingRadio;

  private ACIntegerCheckBox tsuusyoKaigoAdditionFunctionTrainingRadioItem1;

  private ACIntegerCheckBox tsuusyoKaigoAdditionFunctionTrainingRadioItem2;

  private ACValueArrayRadioButtonGroup tsuusyoKaigoAdditionFunctionBathRadio;

  private ACLabelContainer tsuusyoKaigoAdditionFunctionBathRadioContainer;

  private ACListModelAdapter tsuusyoKaigoAdditionFunctionBathRadioModel;

  private ACRadioButtonItem tsuusyoKaigoAdditionFunctionBathRadioItem1;

  private ACRadioButtonItem tsuusyoKaigoAdditionFunctionBathRadioItem2;

  private ACValueArrayRadioButtonGroup tsuusyoKaigoSubtraction;

  private ACLabelContainer tsuusyoKaigoSubtractionContainer;

  private ACListModelAdapter tsuusyoKaigoSubtractionModel;

  private ACRadioButtonItem tsuusyoKaigoSubtractionNot;

  private ACRadioButtonItem tsuusyoKaigoSubtractionExcess;

  private ACRadioButtonItem tsuusyoKaigoSubtractionLack;

  private ACValueArrayRadioButtonGroup tsuusyoKaigoNourishmentManagementAddRadio;

  private ACLabelContainer tsuusyoKaigoNourishmentManagementAddRadioContainer;

  private ACListModelAdapter tsuusyoKaigoNourishmentManagementAddRadioModel;

  private ACRadioButtonItem tsuusyoKaigoNourishmentManagementAddRadioItem1;

  private ACRadioButtonItem tsuusyoKaigoNourishmentManagementAddRadioItem2;

  private ACValueArrayRadioButtonGroup tsuusyoKaigoMouthFunctionAddRadio;

  private ACLabelContainer tsuusyoKaigoMouthFunctionAddRadioContainer;

  private ACListModelAdapter tsuusyoKaigoMouthFunctionAddRadioModel;

  private ACRadioButtonItem tsuusyoKaigoMouthFunctionAddRadioItem1;

  private ACRadioButtonItem tsuusyoKaigoMouthFunctionAddRadioItem2;

  private ACBackLabelContainer tsuusyoKaigoTimeContena;

  private ACTimeComboBox tsuusyoKaigoTimeBeginTime;

  private ACLabelContainer tsuusyoKaigoTimeBeginTimeContainer;

  private ACComboBoxModelAdapter tsuusyoKaigoTimeBeginTimeModel;

  private ACTimeComboBox tsuusyoKaigoTimeEndTime;

  private ACLabelContainer tsuusyoKaigoTimeEndTimeContainer;

  private ACComboBoxModelAdapter tsuusyoKaigoTimeEndTimeModel;

  private ACPanel tab2;

  private ACValueArrayRadioButtonGroup transportationCallRadioGroup;

  private ACLabelContainer transportationCallRadioGroupContainer;

  private ACListModelAdapter transportationCallRadioGroupModel;

  private ACRadioButtonItem transportationCallRadioItem1;

  private ACRadioButtonItem transportationCallRadioItem2;

  private ACValueArrayRadioButtonGroup serviceAddProvisionStructuralRadioGroup;

  private ACLabelContainer serviceAddProvisionStructuralRadioGroupContainer;

  private ACListModelAdapter serviceAddProvisionStructuralRadioGroupModel;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem1;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem2;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem3;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem4;

  private ACValueArrayRadioButtonGroup youngDementiaPatinetAddRadioGroup;

  private ACLabelContainer youngDementiaPatinetAddRadioGroupContainer;

  private ACListModelAdapter youngDementiaPatinetAddRadioGroupModel;

  private ACRadioButtonItem youngDementiaPatinetAddRadioItem1;

  private ACRadioButtonItem youngDementiaPatinetAddRadioItem2;

  private ACValueArrayRadioButtonGroup providerAddMountainousAreaRadioGroup;

  private ACLabelContainer providerAddMountainousAreaRadioGroupContainer;

  private ACListModelAdapter providerAddMountainousAreaRadioGroupModel;

  private ACRadioButtonItem providerAddMountainousAreaRadioItem1;

  private ACRadioButtonItem providerAddMountainousAreaRadioItem2;

  //getter

  /**
   * �ʏ����p�^�[���̈���擾���܂��B
   * @return �ʏ����p�^�[���̈�
   */
  public JTabbedPane getTsuusyoKaigoPatterns(){
    if(tsuusyoKaigoPatterns==null){

      tsuusyoKaigoPatterns = new JTabbedPane();

      addTsuusyoKaigoPatterns();
    }
    return tsuusyoKaigoPatterns;

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
   * �{�ݓ��̋敪�R���e�i���擾���܂��B
   * @return �{�ݓ��̋敪�R���e�i
   */
  public ACLabelContainer getTsuusyoKaigoFacilitiesDivisionContainer(){
    if(tsuusyoKaigoFacilitiesDivisionContainer==null){

      tsuusyoKaigoFacilitiesDivisionContainer = new ACLabelContainer();

      tsuusyoKaigoFacilitiesDivisionContainer.setText("�{�ݓ��̋敪");

      tsuusyoKaigoFacilitiesDivisionContainer.setFollowChildEnabled(true);

      tsuusyoKaigoFacilitiesDivisionContainer.setHgap(0);

      tsuusyoKaigoFacilitiesDivisionContainer.setLabelMargin(0);

      tsuusyoKaigoFacilitiesDivisionContainer.setVgap(0);

      addTsuusyoKaigoFacilitiesDivisionContainer();
    }
    return tsuusyoKaigoFacilitiesDivisionContainer;

  }

  /**
   * �{�ݓ��̋敪���W�I�O���[�v1���擾���܂��B
   * @return �{�ݓ��̋敪���W�I�O���[�v1
   */
  public ACValueArrayRadioButtonGroup getTsuusyoKaigoTimeContenaFacilityDivision(){
    if(tsuusyoKaigoTimeContenaFacilityDivision==null){

      tsuusyoKaigoTimeContenaFacilityDivision = new ACValueArrayRadioButtonGroup();

      tsuusyoKaigoTimeContenaFacilityDivision.setBindPath("1150113");

      tsuusyoKaigoTimeContenaFacilityDivision.setNoSelectIndex(0);

      tsuusyoKaigoTimeContenaFacilityDivision.setUseClearButton(false);

      tsuusyoKaigoTimeContenaFacilityDivision.setModel(getTsuusyoKaigoTimeContenaFacilityDivisionModel());

      tsuusyoKaigoTimeContenaFacilityDivision.setValues(new int[]{1,2,3,4,5});

      addTsuusyoKaigoTimeContenaFacilityDivision();
    }
    return tsuusyoKaigoTimeContenaFacilityDivision;

  }

  /**
   * �{�ݓ��̋敪���W�I�O���[�v1���f�����擾���܂��B
   * @return �{�ݓ��̋敪���W�I�O���[�v1���f��
   */
  protected ACListModelAdapter getTsuusyoKaigoTimeContenaFacilityDivisionModel(){
    if(tsuusyoKaigoTimeContenaFacilityDivisionModel==null){
      tsuusyoKaigoTimeContenaFacilityDivisionModel = new ACListModelAdapter();
      addTsuusyoKaigoTimeContenaFacilityDivisionModel();
    }
    return tsuusyoKaigoTimeContenaFacilityDivisionModel;
  }

  /**
   * ���K�͂��擾���܂��B
   * @return ���K��
   */
  public ACRadioButtonItem getTsuusyoKaigoTimeContenaFacilityDivisionItem1(){
    if(tsuusyoKaigoTimeContenaFacilityDivisionItem1==null){

      tsuusyoKaigoTimeContenaFacilityDivisionItem1 = new ACRadioButtonItem();

      tsuusyoKaigoTimeContenaFacilityDivisionItem1.setText("���K��");

      tsuusyoKaigoTimeContenaFacilityDivisionItem1.setGroup(getTsuusyoKaigoTimeContenaFacilityDivision());

      tsuusyoKaigoTimeContenaFacilityDivisionItem1.setConstraints(VRLayout.FLOW);

      addTsuusyoKaigoTimeContenaFacilityDivisionItem1();
    }
    return tsuusyoKaigoTimeContenaFacilityDivisionItem1;

  }

  /**
   * �ʏ�K�͂��擾���܂��B
   * @return �ʏ�K��
   */
  public ACRadioButtonItem getTsuusyoKaigoTimeContenaFacilityDivisionItem2(){
    if(tsuusyoKaigoTimeContenaFacilityDivisionItem2==null){

      tsuusyoKaigoTimeContenaFacilityDivisionItem2 = new ACRadioButtonItem();

      tsuusyoKaigoTimeContenaFacilityDivisionItem2.setText("�ʏ�K��");

      tsuusyoKaigoTimeContenaFacilityDivisionItem2.setGroup(getTsuusyoKaigoTimeContenaFacilityDivision());

      tsuusyoKaigoTimeContenaFacilityDivisionItem2.setConstraints(VRLayout.FLOW_RETURN);

      addTsuusyoKaigoTimeContenaFacilityDivisionItem2();
    }
    return tsuusyoKaigoTimeContenaFacilityDivisionItem2;

  }

  /**
   * ��K��I�i���p�Ґ�900�l�ȓ��j���擾���܂��B
   * @return ��K��I�i���p�Ґ�900�l�ȓ��j
   */
  public ACRadioButtonItem getTsuusyoKaigoFacilitiesDivisionProviderTypeRadio2(){
    if(tsuusyoKaigoFacilitiesDivisionProviderTypeRadio2==null){

      tsuusyoKaigoFacilitiesDivisionProviderTypeRadio2 = new ACRadioButtonItem();

      tsuusyoKaigoFacilitiesDivisionProviderTypeRadio2.setText("��K��I");

      tsuusyoKaigoFacilitiesDivisionProviderTypeRadio2.setGroup(getTsuusyoKaigoTimeContenaFacilityDivision());

      tsuusyoKaigoFacilitiesDivisionProviderTypeRadio2.setConstraints(VRLayout.FLOW);

      addTsuusyoKaigoFacilitiesDivisionProviderTypeRadio2();
    }
    return tsuusyoKaigoFacilitiesDivisionProviderTypeRadio2;

  }

  /**
   * ��K��II�i���p�Ґ�900�l���j���擾���܂��B
   * @return ��K��II�i���p�Ґ�900�l���j
   */
  public ACRadioButtonItem getTsuusyoKaigoFacilitiesDivisionProviderTypeRadio3(){
    if(tsuusyoKaigoFacilitiesDivisionProviderTypeRadio3==null){

      tsuusyoKaigoFacilitiesDivisionProviderTypeRadio3 = new ACRadioButtonItem();

      tsuusyoKaigoFacilitiesDivisionProviderTypeRadio3.setText("��K��II");

      tsuusyoKaigoFacilitiesDivisionProviderTypeRadio3.setGroup(getTsuusyoKaigoTimeContenaFacilityDivision());

      tsuusyoKaigoFacilitiesDivisionProviderTypeRadio3.setConstraints(VRLayout.FLOW_RETURN);

      addTsuusyoKaigoFacilitiesDivisionProviderTypeRadio3();
    }
    return tsuusyoKaigoFacilitiesDivisionProviderTypeRadio3;

  }

  /**
   * �×{�ʏ����擾���܂��B
   * @return �×{�ʏ�
   */
  public ACRadioButtonItem getTsuusyoKaigoTimeContenaFacilityDivisionItem3(){
    if(tsuusyoKaigoTimeContenaFacilityDivisionItem3==null){

      tsuusyoKaigoTimeContenaFacilityDivisionItem3 = new ACRadioButtonItem();

      tsuusyoKaigoTimeContenaFacilityDivisionItem3.setText("�×{�ʏ�");

      tsuusyoKaigoTimeContenaFacilityDivisionItem3.setGroup(getTsuusyoKaigoTimeContenaFacilityDivision());

      tsuusyoKaigoTimeContenaFacilityDivisionItem3.setConstraints(VRLayout.FLOW);

      addTsuusyoKaigoTimeContenaFacilityDivisionItem3();
    }
    return tsuusyoKaigoTimeContenaFacilityDivisionItem3;

  }

  /**
   * ���ԋ敪���擾���܂��B
   * @return ���ԋ敪
   */
  public ACComboBox getTsuusyoKaigoTimeDivision(){
    if(tsuusyoKaigoTimeDivision==null){

      tsuusyoKaigoTimeDivision = new ACComboBox();

      getTsuusyoKaigoTimeDivisionContainer().setText("���ԋ敪");

      tsuusyoKaigoTimeDivision.setBindPath("1150104");

      tsuusyoKaigoTimeDivision.setEditable(false);

      tsuusyoKaigoTimeDivision.setModelBindPath("1150104");

      tsuusyoKaigoTimeDivision.setRenderBindPath("CONTENT");

      tsuusyoKaigoTimeDivision.setModel(getTsuusyoKaigoTimeDivisionModel());

      addTsuusyoKaigoTimeDivision();
    }
    return tsuusyoKaigoTimeDivision;

  }

  /**
   * ���ԋ敪�R���e�i���擾���܂��B
   * @return ���ԋ敪�R���e�i
   */
  protected ACLabelContainer getTsuusyoKaigoTimeDivisionContainer(){
    if(tsuusyoKaigoTimeDivisionContainer==null){
      tsuusyoKaigoTimeDivisionContainer = new ACLabelContainer();
      tsuusyoKaigoTimeDivisionContainer.setFollowChildEnabled(true);
      tsuusyoKaigoTimeDivisionContainer.setVAlignment(VRLayout.CENTER);
      tsuusyoKaigoTimeDivisionContainer.add(getTsuusyoKaigoTimeDivision(), null);
    }
    return tsuusyoKaigoTimeDivisionContainer;
  }

  /**
   * ���ԋ敪���f�����擾���܂��B
   * @return ���ԋ敪���f��
   */
  protected ACComboBoxModelAdapter getTsuusyoKaigoTimeDivisionModel(){
    if(tsuusyoKaigoTimeDivisionModel==null){
      tsuusyoKaigoTimeDivisionModel = new ACComboBoxModelAdapter();
      addTsuusyoKaigoTimeDivisionModel();
    }
    return tsuusyoKaigoTimeDivisionModel;
  }

  /**
   * �ʋ@�\�P���w�����Z���擾���܂��B
   * @return �ʋ@�\�P���w�����Z
   */
  public ACLabelContainer getTsuusyoKaigoAdditionFunctionTrainingRadio(){
    if(tsuusyoKaigoAdditionFunctionTrainingRadio==null){

      tsuusyoKaigoAdditionFunctionTrainingRadio = new ACLabelContainer();

      tsuusyoKaigoAdditionFunctionTrainingRadio.setText("�ʋ@�\�P���w�����Z");

      tsuusyoKaigoAdditionFunctionTrainingRadio.setFollowChildEnabled(true);

      addTsuusyoKaigoAdditionFunctionTrainingRadio();
    }
    return tsuusyoKaigoAdditionFunctionTrainingRadio;

  }

  /**
   * ���Z�^I���擾���܂��B
   * @return ���Z�^I
   */
  public ACIntegerCheckBox getTsuusyoKaigoAdditionFunctionTrainingRadioItem1(){
    if(tsuusyoKaigoAdditionFunctionTrainingRadioItem1==null){

      tsuusyoKaigoAdditionFunctionTrainingRadioItem1 = new ACIntegerCheckBox();

      tsuusyoKaigoAdditionFunctionTrainingRadioItem1.setText("���Z�^I");

      tsuusyoKaigoAdditionFunctionTrainingRadioItem1.setBindPath("1150119");

      tsuusyoKaigoAdditionFunctionTrainingRadioItem1.setSelectValue(2);

      tsuusyoKaigoAdditionFunctionTrainingRadioItem1.setUnSelectValue(1);

      addTsuusyoKaigoAdditionFunctionTrainingRadioItem1();
    }
    return tsuusyoKaigoAdditionFunctionTrainingRadioItem1;

  }

  /**
   * ���Z�^II���擾���܂��B
   * @return ���Z�^II
   */
  public ACIntegerCheckBox getTsuusyoKaigoAdditionFunctionTrainingRadioItem2(){
    if(tsuusyoKaigoAdditionFunctionTrainingRadioItem2==null){

      tsuusyoKaigoAdditionFunctionTrainingRadioItem2 = new ACIntegerCheckBox();

      tsuusyoKaigoAdditionFunctionTrainingRadioItem2.setText("���Z�^II");

      tsuusyoKaigoAdditionFunctionTrainingRadioItem2.setBindPath("1150120");

      tsuusyoKaigoAdditionFunctionTrainingRadioItem2.setSelectValue(2);

      tsuusyoKaigoAdditionFunctionTrainingRadioItem2.setUnSelectValue(1);

      addTsuusyoKaigoAdditionFunctionTrainingRadioItem2();
    }
    return tsuusyoKaigoAdditionFunctionTrainingRadioItem2;

  }

  /**
   * �������Z���擾���܂��B
   * @return �������Z
   */
  public ACValueArrayRadioButtonGroup getTsuusyoKaigoAdditionFunctionBathRadio(){
    if(tsuusyoKaigoAdditionFunctionBathRadio==null){

      tsuusyoKaigoAdditionFunctionBathRadio = new ACValueArrayRadioButtonGroup();

      getTsuusyoKaigoAdditionFunctionBathRadioContainer().setText("�������Z");

      tsuusyoKaigoAdditionFunctionBathRadio.setBindPath("1150106");

      tsuusyoKaigoAdditionFunctionBathRadio.setUseClearButton(false);

      tsuusyoKaigoAdditionFunctionBathRadio.setModel(getTsuusyoKaigoAdditionFunctionBathRadioModel());

      tsuusyoKaigoAdditionFunctionBathRadio.setValues(new int[]{1,2});

      addTsuusyoKaigoAdditionFunctionBathRadio();
    }
    return tsuusyoKaigoAdditionFunctionBathRadio;

  }

  /**
   * �������Z�R���e�i���擾���܂��B
   * @return �������Z�R���e�i
   */
  protected ACLabelContainer getTsuusyoKaigoAdditionFunctionBathRadioContainer(){
    if(tsuusyoKaigoAdditionFunctionBathRadioContainer==null){
      tsuusyoKaigoAdditionFunctionBathRadioContainer = new ACLabelContainer();
      tsuusyoKaigoAdditionFunctionBathRadioContainer.setFollowChildEnabled(true);
      tsuusyoKaigoAdditionFunctionBathRadioContainer.setVAlignment(VRLayout.CENTER);
      tsuusyoKaigoAdditionFunctionBathRadioContainer.add(getTsuusyoKaigoAdditionFunctionBathRadio(), null);
    }
    return tsuusyoKaigoAdditionFunctionBathRadioContainer;
  }

  /**
   * �������Z���f�����擾���܂��B
   * @return �������Z���f��
   */
  protected ACListModelAdapter getTsuusyoKaigoAdditionFunctionBathRadioModel(){
    if(tsuusyoKaigoAdditionFunctionBathRadioModel==null){
      tsuusyoKaigoAdditionFunctionBathRadioModel = new ACListModelAdapter();
      addTsuusyoKaigoAdditionFunctionBathRadioModel();
    }
    return tsuusyoKaigoAdditionFunctionBathRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getTsuusyoKaigoAdditionFunctionBathRadioItem1(){
    if(tsuusyoKaigoAdditionFunctionBathRadioItem1==null){

      tsuusyoKaigoAdditionFunctionBathRadioItem1 = new ACRadioButtonItem();

      tsuusyoKaigoAdditionFunctionBathRadioItem1.setText("�Ȃ�");

      tsuusyoKaigoAdditionFunctionBathRadioItem1.setGroup(getTsuusyoKaigoAdditionFunctionBathRadio());

      tsuusyoKaigoAdditionFunctionBathRadioItem1.setConstraints(VRLayout.FLOW);

      addTsuusyoKaigoAdditionFunctionBathRadioItem1();
    }
    return tsuusyoKaigoAdditionFunctionBathRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getTsuusyoKaigoAdditionFunctionBathRadioItem2(){
    if(tsuusyoKaigoAdditionFunctionBathRadioItem2==null){

      tsuusyoKaigoAdditionFunctionBathRadioItem2 = new ACRadioButtonItem();

      tsuusyoKaigoAdditionFunctionBathRadioItem2.setText("����");

      tsuusyoKaigoAdditionFunctionBathRadioItem2.setGroup(getTsuusyoKaigoAdditionFunctionBathRadio());

      tsuusyoKaigoAdditionFunctionBathRadioItem2.setConstraints(VRLayout.FLOW);

      addTsuusyoKaigoAdditionFunctionBathRadioItem2();
    }
    return tsuusyoKaigoAdditionFunctionBathRadioItem2;

  }

  /**
   * �l�����Z���擾���܂��B
   * @return �l�����Z
   */
  public ACValueArrayRadioButtonGroup getTsuusyoKaigoSubtraction(){
    if(tsuusyoKaigoSubtraction==null){

      tsuusyoKaigoSubtraction = new ACValueArrayRadioButtonGroup();

      getTsuusyoKaigoSubtractionContainer().setText("�l�����Z");

      tsuusyoKaigoSubtraction.setBindPath("1150108");

      tsuusyoKaigoSubtraction.setUseClearButton(false);

      tsuusyoKaigoSubtraction.setModel(getTsuusyoKaigoSubtractionModel());

      tsuusyoKaigoSubtraction.setValues(new int[]{1,2,3});

      addTsuusyoKaigoSubtraction();
    }
    return tsuusyoKaigoSubtraction;

  }

  /**
   * �l�����Z�R���e�i���擾���܂��B
   * @return �l�����Z�R���e�i
   */
  protected ACLabelContainer getTsuusyoKaigoSubtractionContainer(){
    if(tsuusyoKaigoSubtractionContainer==null){
      tsuusyoKaigoSubtractionContainer = new ACLabelContainer();
      tsuusyoKaigoSubtractionContainer.setFollowChildEnabled(true);
      tsuusyoKaigoSubtractionContainer.setVAlignment(VRLayout.CENTER);
      tsuusyoKaigoSubtractionContainer.add(getTsuusyoKaigoSubtraction(), null);
    }
    return tsuusyoKaigoSubtractionContainer;
  }

  /**
   * �l�����Z���f�����擾���܂��B
   * @return �l�����Z���f��
   */
  protected ACListModelAdapter getTsuusyoKaigoSubtractionModel(){
    if(tsuusyoKaigoSubtractionModel==null){
      tsuusyoKaigoSubtractionModel = new ACListModelAdapter();
      addTsuusyoKaigoSubtractionModel();
    }
    return tsuusyoKaigoSubtractionModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getTsuusyoKaigoSubtractionNot(){
    if(tsuusyoKaigoSubtractionNot==null){

      tsuusyoKaigoSubtractionNot = new ACRadioButtonItem();

      tsuusyoKaigoSubtractionNot.setText("�Ȃ�");

      tsuusyoKaigoSubtractionNot.setGroup(getTsuusyoKaigoSubtraction());

      tsuusyoKaigoSubtractionNot.setConstraints(VRLayout.FLOW);

      addTsuusyoKaigoSubtractionNot();
    }
    return tsuusyoKaigoSubtractionNot;

  }

  /**
   * ������߂��擾���܂��B
   * @return �������
   */
  public ACRadioButtonItem getTsuusyoKaigoSubtractionExcess(){
    if(tsuusyoKaigoSubtractionExcess==null){

      tsuusyoKaigoSubtractionExcess = new ACRadioButtonItem();

      tsuusyoKaigoSubtractionExcess.setText("�������");

      tsuusyoKaigoSubtractionExcess.setGroup(getTsuusyoKaigoSubtraction());

      tsuusyoKaigoSubtractionExcess.setConstraints(VRLayout.FLOW_RETURN);

      addTsuusyoKaigoSubtractionExcess();
    }
    return tsuusyoKaigoSubtractionExcess;

  }

  /**
   * �Ō�E���E���̕s�����擾���܂��B
   * @return �Ō�E���E���̕s��
   */
  public ACRadioButtonItem getTsuusyoKaigoSubtractionLack(){
    if(tsuusyoKaigoSubtractionLack==null){

      tsuusyoKaigoSubtractionLack = new ACRadioButtonItem();

      tsuusyoKaigoSubtractionLack.setText("�Ō�E���E���̕s��");

      tsuusyoKaigoSubtractionLack.setGroup(getTsuusyoKaigoSubtraction());

      tsuusyoKaigoSubtractionLack.setConstraints(VRLayout.FLOW);

      addTsuusyoKaigoSubtractionLack();
    }
    return tsuusyoKaigoSubtractionLack;

  }

  /**
   * �h�{���P���Z���擾���܂��B
   * @return �h�{���P���Z
   */
  public ACValueArrayRadioButtonGroup getTsuusyoKaigoNourishmentManagementAddRadio(){
    if(tsuusyoKaigoNourishmentManagementAddRadio==null){

      tsuusyoKaigoNourishmentManagementAddRadio = new ACValueArrayRadioButtonGroup();

      getTsuusyoKaigoNourishmentManagementAddRadioContainer().setText("�h�{���P���Z");

      tsuusyoKaigoNourishmentManagementAddRadio.setBindPath("1150116");

      tsuusyoKaigoNourishmentManagementAddRadio.setUseClearButton(false);

      tsuusyoKaigoNourishmentManagementAddRadio.setModel(getTsuusyoKaigoNourishmentManagementAddRadioModel());

      tsuusyoKaigoNourishmentManagementAddRadio.setValues(new int[]{1,2});

      addTsuusyoKaigoNourishmentManagementAddRadio();
    }
    return tsuusyoKaigoNourishmentManagementAddRadio;

  }

  /**
   * �h�{���P���Z�R���e�i���擾���܂��B
   * @return �h�{���P���Z�R���e�i
   */
  protected ACLabelContainer getTsuusyoKaigoNourishmentManagementAddRadioContainer(){
    if(tsuusyoKaigoNourishmentManagementAddRadioContainer==null){
      tsuusyoKaigoNourishmentManagementAddRadioContainer = new ACLabelContainer();
      tsuusyoKaigoNourishmentManagementAddRadioContainer.setFollowChildEnabled(true);
      tsuusyoKaigoNourishmentManagementAddRadioContainer.setVAlignment(VRLayout.CENTER);
      tsuusyoKaigoNourishmentManagementAddRadioContainer.add(getTsuusyoKaigoNourishmentManagementAddRadio(), null);
    }
    return tsuusyoKaigoNourishmentManagementAddRadioContainer;
  }

  /**
   * �h�{���P���Z���f�����擾���܂��B
   * @return �h�{���P���Z���f��
   */
  protected ACListModelAdapter getTsuusyoKaigoNourishmentManagementAddRadioModel(){
    if(tsuusyoKaigoNourishmentManagementAddRadioModel==null){
      tsuusyoKaigoNourishmentManagementAddRadioModel = new ACListModelAdapter();
      addTsuusyoKaigoNourishmentManagementAddRadioModel();
    }
    return tsuusyoKaigoNourishmentManagementAddRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getTsuusyoKaigoNourishmentManagementAddRadioItem1(){
    if(tsuusyoKaigoNourishmentManagementAddRadioItem1==null){

      tsuusyoKaigoNourishmentManagementAddRadioItem1 = new ACRadioButtonItem();

      tsuusyoKaigoNourishmentManagementAddRadioItem1.setText("�Ȃ�");

      tsuusyoKaigoNourishmentManagementAddRadioItem1.setGroup(getTsuusyoKaigoNourishmentManagementAddRadio());

      tsuusyoKaigoNourishmentManagementAddRadioItem1.setConstraints(VRLayout.FLOW);

      addTsuusyoKaigoNourishmentManagementAddRadioItem1();
    }
    return tsuusyoKaigoNourishmentManagementAddRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getTsuusyoKaigoNourishmentManagementAddRadioItem2(){
    if(tsuusyoKaigoNourishmentManagementAddRadioItem2==null){

      tsuusyoKaigoNourishmentManagementAddRadioItem2 = new ACRadioButtonItem();

      tsuusyoKaigoNourishmentManagementAddRadioItem2.setText("����");

      tsuusyoKaigoNourishmentManagementAddRadioItem2.setGroup(getTsuusyoKaigoNourishmentManagementAddRadio());

      tsuusyoKaigoNourishmentManagementAddRadioItem2.setConstraints(VRLayout.FLOW);

      addTsuusyoKaigoNourishmentManagementAddRadioItem2();
    }
    return tsuusyoKaigoNourishmentManagementAddRadioItem2;

  }

  /**
   * ���o�@�\������Z���擾���܂��B
   * @return ���o�@�\������Z
   */
  public ACValueArrayRadioButtonGroup getTsuusyoKaigoMouthFunctionAddRadio(){
    if(tsuusyoKaigoMouthFunctionAddRadio==null){

      tsuusyoKaigoMouthFunctionAddRadio = new ACValueArrayRadioButtonGroup();

      getTsuusyoKaigoMouthFunctionAddRadioContainer().setText("���o�@�\������Z");

      tsuusyoKaigoMouthFunctionAddRadio.setBindPath("1150112");

      tsuusyoKaigoMouthFunctionAddRadio.setUseClearButton(false);

      tsuusyoKaigoMouthFunctionAddRadio.setModel(getTsuusyoKaigoMouthFunctionAddRadioModel());

      tsuusyoKaigoMouthFunctionAddRadio.setValues(new int[]{1,2});

      addTsuusyoKaigoMouthFunctionAddRadio();
    }
    return tsuusyoKaigoMouthFunctionAddRadio;

  }

  /**
   * ���o�@�\������Z�R���e�i���擾���܂��B
   * @return ���o�@�\������Z�R���e�i
   */
  protected ACLabelContainer getTsuusyoKaigoMouthFunctionAddRadioContainer(){
    if(tsuusyoKaigoMouthFunctionAddRadioContainer==null){
      tsuusyoKaigoMouthFunctionAddRadioContainer = new ACLabelContainer();
      tsuusyoKaigoMouthFunctionAddRadioContainer.setFollowChildEnabled(true);
      tsuusyoKaigoMouthFunctionAddRadioContainer.setVAlignment(VRLayout.CENTER);
      tsuusyoKaigoMouthFunctionAddRadioContainer.add(getTsuusyoKaigoMouthFunctionAddRadio(), null);
    }
    return tsuusyoKaigoMouthFunctionAddRadioContainer;
  }

  /**
   * ���o�@�\������Z���f�����擾���܂��B
   * @return ���o�@�\������Z���f��
   */
  protected ACListModelAdapter getTsuusyoKaigoMouthFunctionAddRadioModel(){
    if(tsuusyoKaigoMouthFunctionAddRadioModel==null){
      tsuusyoKaigoMouthFunctionAddRadioModel = new ACListModelAdapter();
      addTsuusyoKaigoMouthFunctionAddRadioModel();
    }
    return tsuusyoKaigoMouthFunctionAddRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getTsuusyoKaigoMouthFunctionAddRadioItem1(){
    if(tsuusyoKaigoMouthFunctionAddRadioItem1==null){

      tsuusyoKaigoMouthFunctionAddRadioItem1 = new ACRadioButtonItem();

      tsuusyoKaigoMouthFunctionAddRadioItem1.setText("�Ȃ�");

      tsuusyoKaigoMouthFunctionAddRadioItem1.setGroup(getTsuusyoKaigoMouthFunctionAddRadio());

      tsuusyoKaigoMouthFunctionAddRadioItem1.setConstraints(VRLayout.FLOW);

      addTsuusyoKaigoMouthFunctionAddRadioItem1();
    }
    return tsuusyoKaigoMouthFunctionAddRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getTsuusyoKaigoMouthFunctionAddRadioItem2(){
    if(tsuusyoKaigoMouthFunctionAddRadioItem2==null){

      tsuusyoKaigoMouthFunctionAddRadioItem2 = new ACRadioButtonItem();

      tsuusyoKaigoMouthFunctionAddRadioItem2.setText("����");

      tsuusyoKaigoMouthFunctionAddRadioItem2.setGroup(getTsuusyoKaigoMouthFunctionAddRadio());

      tsuusyoKaigoMouthFunctionAddRadioItem2.setConstraints(VRLayout.FLOW);

      addTsuusyoKaigoMouthFunctionAddRadioItem2();
    }
    return tsuusyoKaigoMouthFunctionAddRadioItem2;

  }

  /**
   * �񋟎��ԃR���e�i���擾���܂��B
   * @return �񋟎��ԃR���e�i
   */
  public ACBackLabelContainer getTsuusyoKaigoTimeContena(){
    if(tsuusyoKaigoTimeContena==null){

      tsuusyoKaigoTimeContena = new ACBackLabelContainer();

      tsuusyoKaigoTimeContena.setFollowChildEnabled(true);

      addTsuusyoKaigoTimeContena();
    }
    return tsuusyoKaigoTimeContena;

  }

  /**
   * �J�n�����R���{���擾���܂��B
   * @return �J�n�����R���{
   */
  public ACTimeComboBox getTsuusyoKaigoTimeBeginTime(){
    if(tsuusyoKaigoTimeBeginTime==null){

      tsuusyoKaigoTimeBeginTime = new ACTimeComboBox();

      getTsuusyoKaigoTimeBeginTimeContainer().setText("�J�n����");

      tsuusyoKaigoTimeBeginTime.setBindPath("3");

      tsuusyoKaigoTimeBeginTime.setModelBindPath("3");

      tsuusyoKaigoTimeBeginTime.setRenderBindPath("CONTENT");

      tsuusyoKaigoTimeBeginTime.setModel(getTsuusyoKaigoTimeBeginTimeModel());

      addTsuusyoKaigoTimeBeginTime();
    }
    return tsuusyoKaigoTimeBeginTime;

  }

  /**
   * �J�n�����R���{�R���e�i���擾���܂��B
   * @return �J�n�����R���{�R���e�i
   */
  protected ACLabelContainer getTsuusyoKaigoTimeBeginTimeContainer(){
    if(tsuusyoKaigoTimeBeginTimeContainer==null){
      tsuusyoKaigoTimeBeginTimeContainer = new ACLabelContainer();
      tsuusyoKaigoTimeBeginTimeContainer.setFollowChildEnabled(true);
      tsuusyoKaigoTimeBeginTimeContainer.setVAlignment(VRLayout.CENTER);
      tsuusyoKaigoTimeBeginTimeContainer.add(getTsuusyoKaigoTimeBeginTime(), null);
    }
    return tsuusyoKaigoTimeBeginTimeContainer;
  }

  /**
   * �J�n�����R���{���f�����擾���܂��B
   * @return �J�n�����R���{���f��
   */
  protected ACComboBoxModelAdapter getTsuusyoKaigoTimeBeginTimeModel(){
    if(tsuusyoKaigoTimeBeginTimeModel==null){
      tsuusyoKaigoTimeBeginTimeModel = new ACComboBoxModelAdapter();
      addTsuusyoKaigoTimeBeginTimeModel();
    }
    return tsuusyoKaigoTimeBeginTimeModel;
  }

  /**
   * �I�������R���{���擾���܂��B
   * @return �I�������R���{
   */
  public ACTimeComboBox getTsuusyoKaigoTimeEndTime(){
    if(tsuusyoKaigoTimeEndTime==null){

      tsuusyoKaigoTimeEndTime = new ACTimeComboBox();

      getTsuusyoKaigoTimeEndTimeContainer().setText("�I������");

      tsuusyoKaigoTimeEndTime.setBindPath("4");

      tsuusyoKaigoTimeEndTime.setModelBindPath("4");

      tsuusyoKaigoTimeEndTime.setRenderBindPath("CONTENT");

      tsuusyoKaigoTimeEndTime.setModel(getTsuusyoKaigoTimeEndTimeModel());

      addTsuusyoKaigoTimeEndTime();
    }
    return tsuusyoKaigoTimeEndTime;

  }

  /**
   * �I�������R���{�R���e�i���擾���܂��B
   * @return �I�������R���{�R���e�i
   */
  protected ACLabelContainer getTsuusyoKaigoTimeEndTimeContainer(){
    if(tsuusyoKaigoTimeEndTimeContainer==null){
      tsuusyoKaigoTimeEndTimeContainer = new ACLabelContainer();
      tsuusyoKaigoTimeEndTimeContainer.setFollowChildEnabled(true);
      tsuusyoKaigoTimeEndTimeContainer.setVAlignment(VRLayout.CENTER);
      tsuusyoKaigoTimeEndTimeContainer.add(getTsuusyoKaigoTimeEndTime(), null);
    }
    return tsuusyoKaigoTimeEndTimeContainer;
  }

  /**
   * �I�������R���{���f�����擾���܂��B
   * @return �I�������R���{���f��
   */
  protected ACComboBoxModelAdapter getTsuusyoKaigoTimeEndTimeModel(){
    if(tsuusyoKaigoTimeEndTimeModel==null){
      tsuusyoKaigoTimeEndTimeModel = new ACComboBoxModelAdapter();
      addTsuusyoKaigoTimeEndTimeModel();
    }
    return tsuusyoKaigoTimeEndTimeModel;
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
  public ACValueArrayRadioButtonGroup getTransportationCallRadioGroup(){
    if(transportationCallRadioGroup==null){

      transportationCallRadioGroup = new ACValueArrayRadioButtonGroup();

      getTransportationCallRadioGroupContainer().setText("���ꌚ�����Z�҂ւ̃T�[�r�X��");

      transportationCallRadioGroup.setBindPath("16");

      transportationCallRadioGroup.setNoSelectIndex(0);

      transportationCallRadioGroup.setUseClearButton(false);

      transportationCallRadioGroup.setModel(getTransportationCallRadioGroupModel());

      transportationCallRadioGroup.setValues(new int[]{1,2});

      addTransportationCallRadioGroup();
    }
    return transportationCallRadioGroup;

  }

  /**
   * ���ꌚ�����Z�҂ւ̃T�[�r�X�񋟃R���e�i���擾���܂��B
   * @return ���ꌚ�����Z�҂ւ̃T�[�r�X�񋟃R���e�i
   */
  protected ACLabelContainer getTransportationCallRadioGroupContainer(){
    if(transportationCallRadioGroupContainer==null){
      transportationCallRadioGroupContainer = new ACLabelContainer();
      transportationCallRadioGroupContainer.setFollowChildEnabled(true);
      transportationCallRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      transportationCallRadioGroupContainer.add(getTransportationCallRadioGroup(), null);
    }
    return transportationCallRadioGroupContainer;
  }

  /**
   * ���ꌚ�����Z�҂ւ̃T�[�r�X�񋟃��f�����擾���܂��B
   * @return ���ꌚ�����Z�҂ւ̃T�[�r�X�񋟃��f��
   */
  protected ACListModelAdapter getTransportationCallRadioGroupModel(){
    if(transportationCallRadioGroupModel==null){
      transportationCallRadioGroupModel = new ACListModelAdapter();
      addTransportationCallRadioGroupModel();
    }
    return transportationCallRadioGroupModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getTransportationCallRadioItem1(){
    if(transportationCallRadioItem1==null){

      transportationCallRadioItem1 = new ACRadioButtonItem();

      transportationCallRadioItem1.setText("�Ȃ�");

      transportationCallRadioItem1.setGroup(getTransportationCallRadioGroup());

      transportationCallRadioItem1.setConstraints(VRLayout.FLOW);

      addTransportationCallRadioItem1();
    }
    return transportationCallRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getTransportationCallRadioItem2(){
    if(transportationCallRadioItem2==null){

      transportationCallRadioItem2 = new ACRadioButtonItem();

      transportationCallRadioItem2.setText("����");

      transportationCallRadioItem2.setGroup(getTransportationCallRadioGroup());

      transportationCallRadioItem2.setConstraints(VRLayout.FLOW);

      addTransportationCallRadioItem2();
    }
    return transportationCallRadioItem2;

  }

  /**
   * �T�[�r�X�񋟑̐��������Z���擾���܂��B
   * @return �T�[�r�X�񋟑̐��������Z
   */
  public ACValueArrayRadioButtonGroup getServiceAddProvisionStructuralRadioGroup(){
    if(serviceAddProvisionStructuralRadioGroup==null){

      serviceAddProvisionStructuralRadioGroup = new ACValueArrayRadioButtonGroup();

      getServiceAddProvisionStructuralRadioGroupContainer().setText("�T�[�r�X�񋟑̐��������Z");

      serviceAddProvisionStructuralRadioGroup.setBindPath("1150117");

      serviceAddProvisionStructuralRadioGroup.setNoSelectIndex(0);

      serviceAddProvisionStructuralRadioGroup.setUseClearButton(false);

      serviceAddProvisionStructuralRadioGroup.setModel(getServiceAddProvisionStructuralRadioGroupModel());

      serviceAddProvisionStructuralRadioGroup.setValues(new int[]{1,2,3,4});

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
   * I�^���擾���܂��B
   * @return I�^
   */
  public ACRadioButtonItem getServiceAddProvisionStructuralRadioItem2(){
    if(serviceAddProvisionStructuralRadioItem2==null){

      serviceAddProvisionStructuralRadioItem2 = new ACRadioButtonItem();

      serviceAddProvisionStructuralRadioItem2.setText("I�^");

      serviceAddProvisionStructuralRadioItem2.setGroup(getServiceAddProvisionStructuralRadioGroup());

      serviceAddProvisionStructuralRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

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
   * ��N���F�m�Ǘ��p�Ҏ�����Z���擾���܂��B
   * @return ��N���F�m�Ǘ��p�Ҏ�����Z
   */
  public ACValueArrayRadioButtonGroup getYoungDementiaPatinetAddRadioGroup(){
    if(youngDementiaPatinetAddRadioGroup==null){

      youngDementiaPatinetAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getYoungDementiaPatinetAddRadioGroupContainer().setText("��N���F�m�Ǘ��p�Ҏ�����Z");

      youngDementiaPatinetAddRadioGroup.setBindPath("1150115");

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
   * ���R�Ԓn�擙�ł̃T�[�r�X�񋟉��Z���擾���܂��B
   * @return ���R�Ԓn�擙�ł̃T�[�r�X�񋟉��Z
   */
  public ACValueArrayRadioButtonGroup getProviderAddMountainousAreaRadioGroup(){
    if(providerAddMountainousAreaRadioGroup==null){

      providerAddMountainousAreaRadioGroup = new ACValueArrayRadioButtonGroup();

      getProviderAddMountainousAreaRadioGroupContainer().setText("���R�Ԓn�擙�ł̃T�[�r�X�񋟉��Z");

      providerAddMountainousAreaRadioGroup.setBindPath("12");

      providerAddMountainousAreaRadioGroup.setNoSelectIndex(0);

      providerAddMountainousAreaRadioGroup.setUseClearButton(false);

      providerAddMountainousAreaRadioGroup.setModel(getProviderAddMountainousAreaRadioGroupModel());

      providerAddMountainousAreaRadioGroup.setValues(new int[]{1,2});

      addProviderAddMountainousAreaRadioGroup();
    }
    return providerAddMountainousAreaRadioGroup;

  }

  /**
   * ���R�Ԓn�擙�ł̃T�[�r�X�񋟉��Z�R���e�i���擾���܂��B
   * @return ���R�Ԓn�擙�ł̃T�[�r�X�񋟉��Z�R���e�i
   */
  protected ACLabelContainer getProviderAddMountainousAreaRadioGroupContainer(){
    if(providerAddMountainousAreaRadioGroupContainer==null){
      providerAddMountainousAreaRadioGroupContainer = new ACLabelContainer();
      providerAddMountainousAreaRadioGroupContainer.setFollowChildEnabled(true);
      providerAddMountainousAreaRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      providerAddMountainousAreaRadioGroupContainer.add(getProviderAddMountainousAreaRadioGroup(), null);
    }
    return providerAddMountainousAreaRadioGroupContainer;
  }

  /**
   * ���R�Ԓn�擙�ł̃T�[�r�X�񋟉��Z���f�����擾���܂��B
   * @return ���R�Ԓn�擙�ł̃T�[�r�X�񋟉��Z���f��
   */
  protected ACListModelAdapter getProviderAddMountainousAreaRadioGroupModel(){
    if(providerAddMountainousAreaRadioGroupModel==null){
      providerAddMountainousAreaRadioGroupModel = new ACListModelAdapter();
      addProviderAddMountainousAreaRadioGroupModel();
    }
    return providerAddMountainousAreaRadioGroupModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getProviderAddMountainousAreaRadioItem1(){
    if(providerAddMountainousAreaRadioItem1==null){

      providerAddMountainousAreaRadioItem1 = new ACRadioButtonItem();

      providerAddMountainousAreaRadioItem1.setText("�Ȃ�");

      providerAddMountainousAreaRadioItem1.setGroup(getProviderAddMountainousAreaRadioGroup());

      providerAddMountainousAreaRadioItem1.setConstraints(VRLayout.FLOW);

      addProviderAddMountainousAreaRadioItem1();
    }
    return providerAddMountainousAreaRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getProviderAddMountainousAreaRadioItem2(){
    if(providerAddMountainousAreaRadioItem2==null){

      providerAddMountainousAreaRadioItem2 = new ACRadioButtonItem();

      providerAddMountainousAreaRadioItem2.setText("����");

      providerAddMountainousAreaRadioItem2.setGroup(getProviderAddMountainousAreaRadioGroup());

      providerAddMountainousAreaRadioItem2.setConstraints(VRLayout.FLOW);

      addProviderAddMountainousAreaRadioItem2();
    }
    return providerAddMountainousAreaRadioItem2;

  }

  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001_11511_201204Design() {

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

    this.add(getTsuusyoKaigoPatterns(), VRLayout.CLIENT);

  }

  /**
   * �ʏ����p�^�[���̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTsuusyoKaigoPatterns(){

    tsuusyoKaigoPatterns.addTab("1", getTab1());

    tsuusyoKaigoPatterns.addTab("2", getTab2());

  }

  /**
   * �^�u1�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTab1(){

    tab1.add(getTsuusyoKaigoFacilitiesDivisionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getTsuusyoKaigoTimeDivisionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getTsuusyoKaigoAdditionFunctionTrainingRadio(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getTsuusyoKaigoAdditionFunctionBathRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getTsuusyoKaigoSubtractionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getTsuusyoKaigoNourishmentManagementAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getTsuusyoKaigoMouthFunctionAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getTsuusyoKaigoTimeContena(), VRLayout.FLOW_DOUBLEINSETLINE_RETURN);

  }

  /**
   * �{�ݓ��̋敪�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTsuusyoKaigoFacilitiesDivisionContainer(){

    tsuusyoKaigoFacilitiesDivisionContainer.add(getTsuusyoKaigoTimeContenaFacilityDivision(), VRLayout.FLOW_RETURN);

  }

  /**
   * �{�ݓ��̋敪���W�I�O���[�v1�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTsuusyoKaigoTimeContenaFacilityDivision(){

  }

  /**
   * �{�ݓ��̋敪���W�I�O���[�v1���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addTsuusyoKaigoTimeContenaFacilityDivisionModel(){

    getTsuusyoKaigoTimeContenaFacilityDivisionItem1().setButtonIndex(1);

    getTsuusyoKaigoTimeContenaFacilityDivisionModel().add(getTsuusyoKaigoTimeContenaFacilityDivisionItem1());

    getTsuusyoKaigoTimeContenaFacilityDivisionItem2().setButtonIndex(2);

    getTsuusyoKaigoTimeContenaFacilityDivisionModel().add(getTsuusyoKaigoTimeContenaFacilityDivisionItem2());

    getTsuusyoKaigoFacilitiesDivisionProviderTypeRadio2().setButtonIndex(3);

    getTsuusyoKaigoTimeContenaFacilityDivisionModel().add(getTsuusyoKaigoFacilitiesDivisionProviderTypeRadio2());

    getTsuusyoKaigoFacilitiesDivisionProviderTypeRadio3().setButtonIndex(4);

    getTsuusyoKaigoTimeContenaFacilityDivisionModel().add(getTsuusyoKaigoFacilitiesDivisionProviderTypeRadio3());

    getTsuusyoKaigoTimeContenaFacilityDivisionItem3().setButtonIndex(5);

    getTsuusyoKaigoTimeContenaFacilityDivisionModel().add(getTsuusyoKaigoTimeContenaFacilityDivisionItem3());

  }

  /**
   * ���K�͂ɓ������ڂ�ǉ����܂��B
   */
  protected void addTsuusyoKaigoTimeContenaFacilityDivisionItem1(){

  }

  /**
   * �ʏ�K�͂ɓ������ڂ�ǉ����܂��B
   */
  protected void addTsuusyoKaigoTimeContenaFacilityDivisionItem2(){

  }

  /**
   * ��K��I�i���p�Ґ�900�l�ȓ��j�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTsuusyoKaigoFacilitiesDivisionProviderTypeRadio2(){

  }

  /**
   * ��K��II�i���p�Ґ�900�l���j�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTsuusyoKaigoFacilitiesDivisionProviderTypeRadio3(){

  }

  /**
   * �×{�ʏ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addTsuusyoKaigoTimeContenaFacilityDivisionItem3(){

  }

  /**
   * ���ԋ敪�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTsuusyoKaigoTimeDivision(){

  }

  /**
   * ���ԋ敪���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addTsuusyoKaigoTimeDivisionModel(){

  }

  /**
   * �ʋ@�\�P���w�����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTsuusyoKaigoAdditionFunctionTrainingRadio(){

    tsuusyoKaigoAdditionFunctionTrainingRadio.add(getTsuusyoKaigoAdditionFunctionTrainingRadioItem1(), VRLayout.FLOW);

    tsuusyoKaigoAdditionFunctionTrainingRadio.add(getTsuusyoKaigoAdditionFunctionTrainingRadioItem2(), VRLayout.FLOW);

  }

  /**
   * ���Z�^I�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTsuusyoKaigoAdditionFunctionTrainingRadioItem1(){

  }

  /**
   * ���Z�^II�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTsuusyoKaigoAdditionFunctionTrainingRadioItem2(){

  }

  /**
   * �������Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTsuusyoKaigoAdditionFunctionBathRadio(){

  }

  /**
   * �������Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addTsuusyoKaigoAdditionFunctionBathRadioModel(){

    getTsuusyoKaigoAdditionFunctionBathRadioItem1().setButtonIndex(1);

    getTsuusyoKaigoAdditionFunctionBathRadioModel().add(getTsuusyoKaigoAdditionFunctionBathRadioItem1());

    getTsuusyoKaigoAdditionFunctionBathRadioItem2().setButtonIndex(2);

    getTsuusyoKaigoAdditionFunctionBathRadioModel().add(getTsuusyoKaigoAdditionFunctionBathRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addTsuusyoKaigoAdditionFunctionBathRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addTsuusyoKaigoAdditionFunctionBathRadioItem2(){

  }

  /**
   * �l�����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTsuusyoKaigoSubtraction(){

  }

  /**
   * �l�����Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addTsuusyoKaigoSubtractionModel(){

    getTsuusyoKaigoSubtractionNot().setButtonIndex(1);

    getTsuusyoKaigoSubtractionModel().add(getTsuusyoKaigoSubtractionNot());

    getTsuusyoKaigoSubtractionExcess().setButtonIndex(2);

    getTsuusyoKaigoSubtractionModel().add(getTsuusyoKaigoSubtractionExcess());

    getTsuusyoKaigoSubtractionLack().setButtonIndex(3);

    getTsuusyoKaigoSubtractionModel().add(getTsuusyoKaigoSubtractionLack());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addTsuusyoKaigoSubtractionNot(){

  }

  /**
   * ������߂ɓ������ڂ�ǉ����܂��B
   */
  protected void addTsuusyoKaigoSubtractionExcess(){

  }

  /**
   * �Ō�E���E���̕s���ɓ������ڂ�ǉ����܂��B
   */
  protected void addTsuusyoKaigoSubtractionLack(){

  }

  /**
   * �h�{���P���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTsuusyoKaigoNourishmentManagementAddRadio(){

  }

  /**
   * �h�{���P���Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addTsuusyoKaigoNourishmentManagementAddRadioModel(){

    getTsuusyoKaigoNourishmentManagementAddRadioItem1().setButtonIndex(1);

    getTsuusyoKaigoNourishmentManagementAddRadioModel().add(getTsuusyoKaigoNourishmentManagementAddRadioItem1());

    getTsuusyoKaigoNourishmentManagementAddRadioItem2().setButtonIndex(2);

    getTsuusyoKaigoNourishmentManagementAddRadioModel().add(getTsuusyoKaigoNourishmentManagementAddRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addTsuusyoKaigoNourishmentManagementAddRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addTsuusyoKaigoNourishmentManagementAddRadioItem2(){

  }

  /**
   * ���o�@�\������Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTsuusyoKaigoMouthFunctionAddRadio(){

  }

  /**
   * ���o�@�\������Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addTsuusyoKaigoMouthFunctionAddRadioModel(){

    getTsuusyoKaigoMouthFunctionAddRadioItem1().setButtonIndex(1);

    getTsuusyoKaigoMouthFunctionAddRadioModel().add(getTsuusyoKaigoMouthFunctionAddRadioItem1());

    getTsuusyoKaigoMouthFunctionAddRadioItem2().setButtonIndex(2);

    getTsuusyoKaigoMouthFunctionAddRadioModel().add(getTsuusyoKaigoMouthFunctionAddRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addTsuusyoKaigoMouthFunctionAddRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addTsuusyoKaigoMouthFunctionAddRadioItem2(){

  }

  /**
   * �񋟎��ԃR���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTsuusyoKaigoTimeContena(){

    tsuusyoKaigoTimeContena.add(getTsuusyoKaigoTimeBeginTimeContainer(), VRLayout.FLOW);

    tsuusyoKaigoTimeContena.add(getTsuusyoKaigoTimeEndTimeContainer(), VRLayout.FLOW);

  }

  /**
   * �J�n�����R���{�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTsuusyoKaigoTimeBeginTime(){

  }

  /**
   * �J�n�����R���{���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addTsuusyoKaigoTimeBeginTimeModel(){

  }

  /**
   * �I�������R���{�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTsuusyoKaigoTimeEndTime(){

  }

  /**
   * �I�������R���{���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addTsuusyoKaigoTimeEndTimeModel(){

  }

  /**
   * �^�u2�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTab2(){

    tab2.add(getTransportationCallRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getServiceAddProvisionStructuralRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getYoungDementiaPatinetAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getProviderAddMountainousAreaRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * ���ꌚ�����Z�҂ւ̃T�[�r�X�񋟂ɓ������ڂ�ǉ����܂��B
   */
  protected void addTransportationCallRadioGroup(){

  }

  /**
   * ���ꌚ�����Z�҂ւ̃T�[�r�X�񋟃��f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addTransportationCallRadioGroupModel(){

    getTransportationCallRadioItem1().setButtonIndex(1);

    getTransportationCallRadioGroupModel().add(getTransportationCallRadioItem1());

    getTransportationCallRadioItem2().setButtonIndex(2);

    getTransportationCallRadioGroupModel().add(getTransportationCallRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addTransportationCallRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addTransportationCallRadioItem2(){

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

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceAddProvisionStructuralRadioItem1(){

  }

  /**
   * I�^�ɓ������ڂ�ǉ����܂��B
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
   * ���R�Ԓn�擙�ł̃T�[�r�X�񋟉��Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderAddMountainousAreaRadioGroup(){

  }

  /**
   * ���R�Ԓn�擙�ł̃T�[�r�X�񋟉��Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderAddMountainousAreaRadioGroupModel(){

    getProviderAddMountainousAreaRadioItem1().setButtonIndex(1);

    getProviderAddMountainousAreaRadioGroupModel().add(getProviderAddMountainousAreaRadioItem1());

    getProviderAddMountainousAreaRadioItem2().setButtonIndex(2);

    getProviderAddMountainousAreaRadioGroupModel().add(getProviderAddMountainousAreaRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderAddMountainousAreaRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderAddMountainousAreaRadioItem2(){

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
      ACFrame.debugStart(new ACAffairInfo(QS001_11511_201204Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QS001_11511_201204Design getThis() {
    return this;
  }
}
