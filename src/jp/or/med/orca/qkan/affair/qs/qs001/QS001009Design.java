
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
 * �J����: ���}�@�M�u
 * �쐬��: 2006/02/14  ���{�R���s���[�^�[������� ���}�@�M�u �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �\��Ǘ� (S)
 * �v���Z�X ���p�҈ꗗ�i�T�[�r�X�\��쐬/�ύX�j (001)
 * �v���O���� �T�[�r�X�p�^�[���ʏ����n (QS001009)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
import java.awt.Component;

import javax.swing.JTabbedPane;

import jp.nichicom.ac.component.ACClearableRadioButtonGroup;
import jp.nichicom.ac.component.ACComboBox;
import jp.nichicom.ac.component.ACRadioButtonItem;
import jp.nichicom.ac.component.ACTimeComboBox;
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
 * �T�[�r�X�p�^�[���ʏ����n��ʍ��ڃf�U�C��(QS001009) 
 */
public class QS001009Design extends QS001ServicePanel {
  //GUI�R���|�[�l���g

  private JTabbedPane tabs;

  private ACPanel tab1;

  private ACBackLabelContainer houmonRehabilitationTimeContena;

  private ACTimeComboBox houmonRehabilitationTimeContenaBeginTime;

  private ACLabelContainer houmonRehabilitationTimeContenaBeginTimeContainer;

  private ACComboBoxModelAdapter houmonRehabilitationTimeContenaBeginTimeModel;

  private ACTimeComboBox houmonRehabilitationTimeContenaEndTime;

  private ACLabelContainer houmonRehabilitationTimeContenaEndTimeContainer;

  private ACComboBoxModelAdapter houmonRehabilitationTimeContenaEndTimeModel;

  private ACClearableRadioButtonGroup houmonRehabilitationTimeContenaFacilityDivision;

  private ACLabelContainer houmonRehabilitationTimeContenaFacilityDivisionContainer;

  private ACListModelAdapter houmonRehabilitationTimeContenaFacilityDivisionModel;

  private ACRadioButtonItem houmonRehabilitationMedicalInstitution;

  private ACRadioButtonItem houmonRehabilitationDouble;

  private ACRadioButtonItem houmonRehabilitationClinic;

  private ACComboBox houmonRehabilitationTimeDivision;

  private ACLabelContainer houmonRehabilitationTimeDivisionContainer;

  private ACComboBoxModelAdapter houmonRehabilitationTimeDivisionModel;

  private ACClearableRadioButtonGroup houmonRehabilitationBathRadio;

  private ACLabelContainer houmonRehabilitationBathRadioContainer;

  private ACListModelAdapter houmonRehabilitationBathRadioModel;

  private ACRadioButtonItem houmonRehabilitationBathRadioItem1;

  private ACRadioButtonItem houmonRehabilitationBathRadioItem2;

  private ACRadioButtonItem houmonRehabilitationBathRadioItem3;

  private ACClearableRadioButtonGroup houmonRehabilitationMeetingAndSendingOff;

  private ACLabelContainer houmonRehabilitationMeetingAndSendingOffContainer;

  private ACListModelAdapter houmonRehabilitationMeetingAndSendingOffModel;

  private ACRadioButtonItem houmonRehabilitationMeetingAndSendingOffNone;

  private ACRadioButtonItem houmonRehabilitationMeetingAndSendingOffOneWay;

  private ACRadioButtonItem houmonRehabilitationMeetingAndSendingOffRoundTrip;

  private ACClearableRadioButtonGroup houmonRehabilitationAdditionTreatmentPersonRadio;

  private ACLabelContainer houmonRehabilitationAdditionTreatmentPersonRadioContainer;

  private ACListModelAdapter houmonRehabilitationAdditionTreatmentPersonRadioModel;

  private ACRadioButtonItem houmonRehabilitationAdditionTreatmentPersonRadioItem1;

  private ACRadioButtonItem houmonRehabilitationAdditionTreatmentPersonRadioItem2;

  private ACClearableRadioButtonGroup houmonRehabilitationIndividualRadio;

  private ACLabelContainer houmonRehabilitationIndividualRadioContainer;

  private ACListModelAdapter houmonRehabilitationIndividualRadioModel;

  private ACRadioButtonItem houmonRehabilitationIndividualRadioItem1;

  private ACRadioButtonItem houmonRehabilitationIndividualRadioItem2;

  private ACRadioButtonItem houmonRehabilitationIndividualRadioItem3;

  private ACPanel tab2;

  private ACClearableRadioButtonGroup houmonRehabilitationSubtraction;

  private ACLabelContainer houmonRehabilitationSubtractionContainer;

  private ACListModelAdapter houmonRehabilitationSubtractionModel;

  private ACRadioButtonItem houmonRehabilitationSubtractionNot;

  private ACRadioButtonItem houmonRehabilitationSubtractionExcess;

  private ACRadioButtonItem houmonRehabilitationSubtractionLack;

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

      tab1.setHgap(0);

      addTab1();
    }
    return tab1;

  }

  /**
   * �񋟎��ԃR���e�i���擾���܂��B
   * @return �񋟎��ԃR���e�i
   */
  public ACBackLabelContainer getHoumonRehabilitationTimeContena(){
    if(houmonRehabilitationTimeContena==null){

      houmonRehabilitationTimeContena = new ACBackLabelContainer();

      addHoumonRehabilitationTimeContena();
    }
    return houmonRehabilitationTimeContena;

  }

  /**
   * �J�n�����R���{���擾���܂��B
   * @return �J�n�����R���{
   */
  public ACTimeComboBox getHoumonRehabilitationTimeContenaBeginTime(){
    if(houmonRehabilitationTimeContenaBeginTime==null){

      houmonRehabilitationTimeContenaBeginTime = new ACTimeComboBox();

      getHoumonRehabilitationTimeContenaBeginTimeContainer().setText("�J�n����");

      houmonRehabilitationTimeContenaBeginTime.setBindPath("3");

      houmonRehabilitationTimeContenaBeginTime.setModelBindPath("3");

      houmonRehabilitationTimeContenaBeginTime.setModel(getHoumonRehabilitationTimeContenaBeginTimeModel());

      houmonRehabilitationTimeContenaBeginTime.setRenderBindPath("CONTENT");

      addHoumonRehabilitationTimeContenaBeginTime();
    }
    return houmonRehabilitationTimeContenaBeginTime;

  }

  /**
   * �J�n�����R���{�R���e�i���擾���܂��B
   * @return �J�n�����R���{�R���e�i
   */
  protected ACLabelContainer getHoumonRehabilitationTimeContenaBeginTimeContainer(){
    if(houmonRehabilitationTimeContenaBeginTimeContainer==null){
      houmonRehabilitationTimeContenaBeginTimeContainer = new ACLabelContainer();
      houmonRehabilitationTimeContenaBeginTimeContainer.setFollowChildEnabled(true);
      houmonRehabilitationTimeContenaBeginTimeContainer.add(getHoumonRehabilitationTimeContenaBeginTime(), null);
    }
    return houmonRehabilitationTimeContenaBeginTimeContainer;
  }

  /**
   * �J�n�����R���{���f�����擾���܂��B
   * @return �J�n�����R���{���f��
   */
  protected ACComboBoxModelAdapter getHoumonRehabilitationTimeContenaBeginTimeModel(){
    if(houmonRehabilitationTimeContenaBeginTimeModel==null){
      houmonRehabilitationTimeContenaBeginTimeModel = new ACComboBoxModelAdapter();
      addHoumonRehabilitationTimeContenaBeginTimeModel();
    }
    return houmonRehabilitationTimeContenaBeginTimeModel;
  }

  /**
   * �I�������R���{���擾���܂��B
   * @return �I�������R���{
   */
  public ACTimeComboBox getHoumonRehabilitationTimeContenaEndTime(){
    if(houmonRehabilitationTimeContenaEndTime==null){

      houmonRehabilitationTimeContenaEndTime = new ACTimeComboBox();

      getHoumonRehabilitationTimeContenaEndTimeContainer().setText("�I������");

      houmonRehabilitationTimeContenaEndTime.setBindPath("4");

      houmonRehabilitationTimeContenaEndTime.setModelBindPath("4");

      houmonRehabilitationTimeContenaEndTime.setModel(getHoumonRehabilitationTimeContenaEndTimeModel());

      houmonRehabilitationTimeContenaEndTime.setRenderBindPath("CONTENT");

      addHoumonRehabilitationTimeContenaEndTime();
    }
    return houmonRehabilitationTimeContenaEndTime;

  }

  /**
   * �I�������R���{�R���e�i���擾���܂��B
   * @return �I�������R���{�R���e�i
   */
  protected ACLabelContainer getHoumonRehabilitationTimeContenaEndTimeContainer(){
    if(houmonRehabilitationTimeContenaEndTimeContainer==null){
      houmonRehabilitationTimeContenaEndTimeContainer = new ACLabelContainer();
      houmonRehabilitationTimeContenaEndTimeContainer.setFollowChildEnabled(true);
      houmonRehabilitationTimeContenaEndTimeContainer.add(getHoumonRehabilitationTimeContenaEndTime(), null);
    }
    return houmonRehabilitationTimeContenaEndTimeContainer;
  }

  /**
   * �I�������R���{���f�����擾���܂��B
   * @return �I�������R���{���f��
   */
  protected ACComboBoxModelAdapter getHoumonRehabilitationTimeContenaEndTimeModel(){
    if(houmonRehabilitationTimeContenaEndTimeModel==null){
      houmonRehabilitationTimeContenaEndTimeModel = new ACComboBoxModelAdapter();
      addHoumonRehabilitationTimeContenaEndTimeModel();
    }
    return houmonRehabilitationTimeContenaEndTimeModel;
  }

  /**
   * �{�݋敪���擾���܂��B
   * @return �{�݋敪
   */
  public ACClearableRadioButtonGroup getHoumonRehabilitationTimeContenaFacilityDivision(){
    if(houmonRehabilitationTimeContenaFacilityDivision==null){

      houmonRehabilitationTimeContenaFacilityDivision = new ACClearableRadioButtonGroup();

      getHoumonRehabilitationTimeContenaFacilityDivisionContainer().setText("�{�݋敪");

      houmonRehabilitationTimeContenaFacilityDivision.setBindPath("1160103");

      houmonRehabilitationTimeContenaFacilityDivision.setModel(getHoumonRehabilitationTimeContenaFacilityDivisionModel());

      houmonRehabilitationTimeContenaFacilityDivision.setUseClearButton(false);

      addHoumonRehabilitationTimeContenaFacilityDivision();
    }
    return houmonRehabilitationTimeContenaFacilityDivision;

  }

  /**
   * �{�݋敪�R���e�i���擾���܂��B
   * @return �{�݋敪�R���e�i
   */
  protected ACLabelContainer getHoumonRehabilitationTimeContenaFacilityDivisionContainer(){
    if(houmonRehabilitationTimeContenaFacilityDivisionContainer==null){
      houmonRehabilitationTimeContenaFacilityDivisionContainer = new ACLabelContainer();
      houmonRehabilitationTimeContenaFacilityDivisionContainer.setFollowChildEnabled(true);
      houmonRehabilitationTimeContenaFacilityDivisionContainer.add(getHoumonRehabilitationTimeContenaFacilityDivision(), null);
    }
    return houmonRehabilitationTimeContenaFacilityDivisionContainer;
  }

  /**
   * �{�݋敪���f�����擾���܂��B
   * @return �{�݋敪���f��
   */
  protected ACListModelAdapter getHoumonRehabilitationTimeContenaFacilityDivisionModel(){
    if(houmonRehabilitationTimeContenaFacilityDivisionModel==null){
      houmonRehabilitationTimeContenaFacilityDivisionModel = new ACListModelAdapter();
      addHoumonRehabilitationTimeContenaFacilityDivisionModel();
    }
    return houmonRehabilitationTimeContenaFacilityDivisionModel;
  }

  /**
   * �ʏ�K�͈�Ë@�ւ��擾���܂��B
   * @return �ʏ�K�͈�Ë@��
   */
  public ACRadioButtonItem getHoumonRehabilitationMedicalInstitution(){
    if(houmonRehabilitationMedicalInstitution==null){

      houmonRehabilitationMedicalInstitution = new ACRadioButtonItem();

      houmonRehabilitationMedicalInstitution.setText("�ʏ�K�͈�Ë@��");

      houmonRehabilitationMedicalInstitution.setGroup(getHoumonRehabilitationTimeContenaFacilityDivision());

      houmonRehabilitationMedicalInstitution.setConstraints(VRLayout.FLOW);

      addHoumonRehabilitationMedicalInstitution();
    }
    return houmonRehabilitationMedicalInstitution;

  }

  /**
   * ���K�͐f�Ï����擾���܂��B
   * @return ���K�͐f�Ï�
   */
  public ACRadioButtonItem getHoumonRehabilitationDouble(){
    if(houmonRehabilitationDouble==null){

      houmonRehabilitationDouble = new ACRadioButtonItem();

      houmonRehabilitationDouble.setText("���K�͐f�Ï�");

      houmonRehabilitationDouble.setGroup(getHoumonRehabilitationTimeContenaFacilityDivision());

      houmonRehabilitationDouble.setConstraints(VRLayout.FLOW_RETURN);

      addHoumonRehabilitationDouble();
    }
    return houmonRehabilitationDouble;

  }

  /**
   * ���V�l�ی��{�݂��擾���܂��B
   * @return ���V�l�ی��{��
   */
  public ACRadioButtonItem getHoumonRehabilitationClinic(){
    if(houmonRehabilitationClinic==null){

      houmonRehabilitationClinic = new ACRadioButtonItem();

      houmonRehabilitationClinic.setText("���V�l�ی��{��");

      houmonRehabilitationClinic.setGroup(getHoumonRehabilitationTimeContenaFacilityDivision());

      houmonRehabilitationClinic.setConstraints(VRLayout.FLOW);

      addHoumonRehabilitationClinic();
    }
    return houmonRehabilitationClinic;

  }

  /**
   * ���ԋ敪���擾���܂��B
   * @return ���ԋ敪
   */
  public ACComboBox getHoumonRehabilitationTimeDivision(){
    if(houmonRehabilitationTimeDivision==null){

      houmonRehabilitationTimeDivision = new ACComboBox();

      getHoumonRehabilitationTimeDivisionContainer().setText("���ԋ敪");

      houmonRehabilitationTimeDivision.setBindPath("1160104");

      houmonRehabilitationTimeDivision.setEditable(false);

      houmonRehabilitationTimeDivision.setModelBindPath("1160104");

      houmonRehabilitationTimeDivision.setModel(getHoumonRehabilitationTimeDivisionModel());

      houmonRehabilitationTimeDivision.setRenderBindPath("CONTENT");

      addHoumonRehabilitationTimeDivision();
    }
    return houmonRehabilitationTimeDivision;

  }

  /**
   * ���ԋ敪�R���e�i���擾���܂��B
   * @return ���ԋ敪�R���e�i
   */
  protected ACLabelContainer getHoumonRehabilitationTimeDivisionContainer(){
    if(houmonRehabilitationTimeDivisionContainer==null){
      houmonRehabilitationTimeDivisionContainer = new ACLabelContainer();
      houmonRehabilitationTimeDivisionContainer.setFollowChildEnabled(true);
      houmonRehabilitationTimeDivisionContainer.add(getHoumonRehabilitationTimeDivision(), null);
    }
    return houmonRehabilitationTimeDivisionContainer;
  }

  /**
   * ���ԋ敪���f�����擾���܂��B
   * @return ���ԋ敪���f��
   */
  protected ACComboBoxModelAdapter getHoumonRehabilitationTimeDivisionModel(){
    if(houmonRehabilitationTimeDivisionModel==null){
      houmonRehabilitationTimeDivisionModel = new ACComboBoxModelAdapter();
      addHoumonRehabilitationTimeDivisionModel();
    }
    return houmonRehabilitationTimeDivisionModel;
  }

  /**
   * �������Z���擾���܂��B
   * @return �������Z
   */
  public ACClearableRadioButtonGroup getHoumonRehabilitationBathRadio(){
    if(houmonRehabilitationBathRadio==null){

      houmonRehabilitationBathRadio = new ACClearableRadioButtonGroup();

      getHoumonRehabilitationBathRadioContainer().setText("�������Z");

      houmonRehabilitationBathRadio.setBindPath("1160105");

      houmonRehabilitationBathRadio.setModel(getHoumonRehabilitationBathRadioModel());

      houmonRehabilitationBathRadio.setUseClearButton(false);

      addHoumonRehabilitationBathRadio();
    }
    return houmonRehabilitationBathRadio;

  }

  /**
   * �������Z�R���e�i���擾���܂��B
   * @return �������Z�R���e�i
   */
  protected ACLabelContainer getHoumonRehabilitationBathRadioContainer(){
    if(houmonRehabilitationBathRadioContainer==null){
      houmonRehabilitationBathRadioContainer = new ACLabelContainer();
      houmonRehabilitationBathRadioContainer.setFollowChildEnabled(true);
      houmonRehabilitationBathRadioContainer.add(getHoumonRehabilitationBathRadio(), null);
    }
    return houmonRehabilitationBathRadioContainer;
  }

  /**
   * �������Z���f�����擾���܂��B
   * @return �������Z���f��
   */
  protected ACListModelAdapter getHoumonRehabilitationBathRadioModel(){
    if(houmonRehabilitationBathRadioModel==null){
      houmonRehabilitationBathRadioModel = new ACListModelAdapter();
      addHoumonRehabilitationBathRadioModel();
    }
    return houmonRehabilitationBathRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getHoumonRehabilitationBathRadioItem1(){
    if(houmonRehabilitationBathRadioItem1==null){

      houmonRehabilitationBathRadioItem1 = new ACRadioButtonItem();

      houmonRehabilitationBathRadioItem1.setText("�Ȃ�");

      houmonRehabilitationBathRadioItem1.setGroup(getHoumonRehabilitationBathRadio());

      houmonRehabilitationBathRadioItem1.setConstraints(VRLayout.FLOW);

      addHoumonRehabilitationBathRadioItem1();
    }
    return houmonRehabilitationBathRadioItem1;

  }

  /**
   * �ʏ���擾���܂��B
   * @return �ʏ�
   */
  public ACRadioButtonItem getHoumonRehabilitationBathRadioItem2(){
    if(houmonRehabilitationBathRadioItem2==null){

      houmonRehabilitationBathRadioItem2 = new ACRadioButtonItem();

      houmonRehabilitationBathRadioItem2.setText("�ʏ����");

      houmonRehabilitationBathRadioItem2.setGroup(getHoumonRehabilitationBathRadio());

      houmonRehabilitationBathRadioItem2.setConstraints(VRLayout.FLOW);

      addHoumonRehabilitationBathRadioItem2();
    }
    return houmonRehabilitationBathRadioItem2;

  }

  /**
   * ���ʓ������擾���܂��B
   * @return ���ʓ���
   */
  public ACRadioButtonItem getHoumonRehabilitationBathRadioItem3(){
    if(houmonRehabilitationBathRadioItem3==null){

      houmonRehabilitationBathRadioItem3 = new ACRadioButtonItem();

      houmonRehabilitationBathRadioItem3.setText("���ʓ���");

      houmonRehabilitationBathRadioItem3.setGroup(getHoumonRehabilitationBathRadio());

      houmonRehabilitationBathRadioItem3.setConstraints(VRLayout.FLOW);

      addHoumonRehabilitationBathRadioItem3();
    }
    return houmonRehabilitationBathRadioItem3;

  }

  /**
   * ���}�敪���擾���܂��B
   * @return ���}�敪
   */
  public ACClearableRadioButtonGroup getHoumonRehabilitationMeetingAndSendingOff(){
    if(houmonRehabilitationMeetingAndSendingOff==null){

      houmonRehabilitationMeetingAndSendingOff = new ACClearableRadioButtonGroup();

      getHoumonRehabilitationMeetingAndSendingOffContainer().setText("���}���Z");

      houmonRehabilitationMeetingAndSendingOff.setBindPath("6");

      houmonRehabilitationMeetingAndSendingOff.setModel(getHoumonRehabilitationMeetingAndSendingOffModel());

      houmonRehabilitationMeetingAndSendingOff.setUseClearButton(false);

      addHoumonRehabilitationMeetingAndSendingOff();
    }
    return houmonRehabilitationMeetingAndSendingOff;

  }

  /**
   * ���}�敪�R���e�i���擾���܂��B
   * @return ���}�敪�R���e�i
   */
  protected ACLabelContainer getHoumonRehabilitationMeetingAndSendingOffContainer(){
    if(houmonRehabilitationMeetingAndSendingOffContainer==null){
      houmonRehabilitationMeetingAndSendingOffContainer = new ACLabelContainer();
      houmonRehabilitationMeetingAndSendingOffContainer.setFollowChildEnabled(true);
      houmonRehabilitationMeetingAndSendingOffContainer.add(getHoumonRehabilitationMeetingAndSendingOff(), null);
    }
    return houmonRehabilitationMeetingAndSendingOffContainer;
  }

  /**
   * ���}�敪���f�����擾���܂��B
   * @return ���}�敪���f��
   */
  protected ACListModelAdapter getHoumonRehabilitationMeetingAndSendingOffModel(){
    if(houmonRehabilitationMeetingAndSendingOffModel==null){
      houmonRehabilitationMeetingAndSendingOffModel = new ACListModelAdapter();
      addHoumonRehabilitationMeetingAndSendingOffModel();
    }
    return houmonRehabilitationMeetingAndSendingOffModel;
  }

  /**
   * ���}�Ȃ����擾���܂��B
   * @return ���}�Ȃ�
   */
  public ACRadioButtonItem getHoumonRehabilitationMeetingAndSendingOffNone(){
    if(houmonRehabilitationMeetingAndSendingOffNone==null){

      houmonRehabilitationMeetingAndSendingOffNone = new ACRadioButtonItem();

      houmonRehabilitationMeetingAndSendingOffNone.setText("���}�Ȃ�");

      houmonRehabilitationMeetingAndSendingOffNone.setGroup(getHoumonRehabilitationMeetingAndSendingOff());

      houmonRehabilitationMeetingAndSendingOffNone.setConstraints(VRLayout.FLOW);

      addHoumonRehabilitationMeetingAndSendingOffNone();
    }
    return houmonRehabilitationMeetingAndSendingOffNone;

  }

  /**
   * ���}�Г����擾���܂��B
   * @return ���}�Г�
   */
  public ACRadioButtonItem getHoumonRehabilitationMeetingAndSendingOffOneWay(){
    if(houmonRehabilitationMeetingAndSendingOffOneWay==null){

      houmonRehabilitationMeetingAndSendingOffOneWay = new ACRadioButtonItem();

      houmonRehabilitationMeetingAndSendingOffOneWay.setText("���}�Г�");

      houmonRehabilitationMeetingAndSendingOffOneWay.setGroup(getHoumonRehabilitationMeetingAndSendingOff());

      houmonRehabilitationMeetingAndSendingOffOneWay.setConstraints(VRLayout.FLOW);

      addHoumonRehabilitationMeetingAndSendingOffOneWay();
    }
    return houmonRehabilitationMeetingAndSendingOffOneWay;

  }

  /**
   * ���}�������擾���܂��B
   * @return ���}����
   */
  public ACRadioButtonItem getHoumonRehabilitationMeetingAndSendingOffRoundTrip(){
    if(houmonRehabilitationMeetingAndSendingOffRoundTrip==null){

      houmonRehabilitationMeetingAndSendingOffRoundTrip = new ACRadioButtonItem();

      houmonRehabilitationMeetingAndSendingOffRoundTrip.setText("���}����");

      houmonRehabilitationMeetingAndSendingOffRoundTrip.setGroup(getHoumonRehabilitationMeetingAndSendingOff());

      houmonRehabilitationMeetingAndSendingOffRoundTrip.setConstraints(VRLayout.FLOW);

      addHoumonRehabilitationMeetingAndSendingOffRoundTrip();
    }
    return houmonRehabilitationMeetingAndSendingOffRoundTrip;

  }

  /**
   * ���n�r���K��w�����Z���擾���܂��B
   * @return ���n�r���K��w�����Z
   */
  public ACClearableRadioButtonGroup getHoumonRehabilitationAdditionTreatmentPersonRadio(){
    if(houmonRehabilitationAdditionTreatmentPersonRadio==null){

      houmonRehabilitationAdditionTreatmentPersonRadio = new ACClearableRadioButtonGroup();

      getHoumonRehabilitationAdditionTreatmentPersonRadioContainer().setText("���n�r���K��w�����Z");

      houmonRehabilitationAdditionTreatmentPersonRadio.setBindPath("1160107");

      houmonRehabilitationAdditionTreatmentPersonRadio.setModel(getHoumonRehabilitationAdditionTreatmentPersonRadioModel());

      houmonRehabilitationAdditionTreatmentPersonRadio.setUseClearButton(false);

      addHoumonRehabilitationAdditionTreatmentPersonRadio();
    }
    return houmonRehabilitationAdditionTreatmentPersonRadio;

  }

  /**
   * ���n�r���K��w�����Z�R���e�i���擾���܂��B
   * @return ���n�r���K��w�����Z�R���e�i
   */
  protected ACLabelContainer getHoumonRehabilitationAdditionTreatmentPersonRadioContainer(){
    if(houmonRehabilitationAdditionTreatmentPersonRadioContainer==null){
      houmonRehabilitationAdditionTreatmentPersonRadioContainer = new ACLabelContainer();
      houmonRehabilitationAdditionTreatmentPersonRadioContainer.setFollowChildEnabled(true);
      houmonRehabilitationAdditionTreatmentPersonRadioContainer.add(getHoumonRehabilitationAdditionTreatmentPersonRadio(), null);
    }
    return houmonRehabilitationAdditionTreatmentPersonRadioContainer;
  }

  /**
   * ���n�r���K��w�����Z���f�����擾���܂��B
   * @return ���n�r���K��w�����Z���f��
   */
  protected ACListModelAdapter getHoumonRehabilitationAdditionTreatmentPersonRadioModel(){
    if(houmonRehabilitationAdditionTreatmentPersonRadioModel==null){
      houmonRehabilitationAdditionTreatmentPersonRadioModel = new ACListModelAdapter();
      addHoumonRehabilitationAdditionTreatmentPersonRadioModel();
    }
    return houmonRehabilitationAdditionTreatmentPersonRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getHoumonRehabilitationAdditionTreatmentPersonRadioItem1(){
    if(houmonRehabilitationAdditionTreatmentPersonRadioItem1==null){

      houmonRehabilitationAdditionTreatmentPersonRadioItem1 = new ACRadioButtonItem();

      houmonRehabilitationAdditionTreatmentPersonRadioItem1.setText("�Ȃ�");

      houmonRehabilitationAdditionTreatmentPersonRadioItem1.setGroup(getHoumonRehabilitationAdditionTreatmentPersonRadio());

      houmonRehabilitationAdditionTreatmentPersonRadioItem1.setConstraints(VRLayout.FLOW);

      addHoumonRehabilitationAdditionTreatmentPersonRadioItem1();
    }
    return houmonRehabilitationAdditionTreatmentPersonRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getHoumonRehabilitationAdditionTreatmentPersonRadioItem2(){
    if(houmonRehabilitationAdditionTreatmentPersonRadioItem2==null){

      houmonRehabilitationAdditionTreatmentPersonRadioItem2 = new ACRadioButtonItem();

      houmonRehabilitationAdditionTreatmentPersonRadioItem2.setText("����");

      houmonRehabilitationAdditionTreatmentPersonRadioItem2.setGroup(getHoumonRehabilitationAdditionTreatmentPersonRadio());

      houmonRehabilitationAdditionTreatmentPersonRadioItem2.setConstraints(VRLayout.FLOW);

      addHoumonRehabilitationAdditionTreatmentPersonRadioItem2();
    }
    return houmonRehabilitationAdditionTreatmentPersonRadioItem2;

  }

  /**
   * �ʃ��n���擾���܂��B
   * @return �ʃ��n
   */
  public ACClearableRadioButtonGroup getHoumonRehabilitationIndividualRadio(){
    if(houmonRehabilitationIndividualRadio==null){

      houmonRehabilitationIndividualRadio = new ACClearableRadioButtonGroup();

      getHoumonRehabilitationIndividualRadioContainer().setText("�ʃ��n�r�����Z");

      houmonRehabilitationIndividualRadio.setBindPath("1160108");

      houmonRehabilitationIndividualRadio.setModel(getHoumonRehabilitationIndividualRadioModel());

      houmonRehabilitationIndividualRadio.setUseClearButton(false);

      addHoumonRehabilitationIndividualRadio();
    }
    return houmonRehabilitationIndividualRadio;

  }

  /**
   * �ʃ��n�R���e�i���擾���܂��B
   * @return �ʃ��n�R���e�i
   */
  protected ACLabelContainer getHoumonRehabilitationIndividualRadioContainer(){
    if(houmonRehabilitationIndividualRadioContainer==null){
      houmonRehabilitationIndividualRadioContainer = new ACLabelContainer();
      houmonRehabilitationIndividualRadioContainer.setFollowChildEnabled(true);
      houmonRehabilitationIndividualRadioContainer.add(getHoumonRehabilitationIndividualRadio(), null);
    }
    return houmonRehabilitationIndividualRadioContainer;
  }

  /**
   * �ʃ��n���f�����擾���܂��B
   * @return �ʃ��n���f��
   */
  protected ACListModelAdapter getHoumonRehabilitationIndividualRadioModel(){
    if(houmonRehabilitationIndividualRadioModel==null){
      houmonRehabilitationIndividualRadioModel = new ACListModelAdapter();
      addHoumonRehabilitationIndividualRadioModel();
    }
    return houmonRehabilitationIndividualRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getHoumonRehabilitationIndividualRadioItem1(){
    if(houmonRehabilitationIndividualRadioItem1==null){

      houmonRehabilitationIndividualRadioItem1 = new ACRadioButtonItem();

      houmonRehabilitationIndividualRadioItem1.setText("�Ȃ�");

      houmonRehabilitationIndividualRadioItem1.setGroup(getHoumonRehabilitationIndividualRadio());

      houmonRehabilitationIndividualRadioItem1.setConstraints(VRLayout.FLOW_RETURN);

      addHoumonRehabilitationIndividualRadioItem1();
    }
    return houmonRehabilitationIndividualRadioItem1;

  }

  /**
   * �މ@�E�ޏ���P�N�ȓ����擾���܂��B
   * @return �މ@�E�ޏ���P�N�ȓ�
   */
  public ACRadioButtonItem getHoumonRehabilitationIndividualRadioItem2(){
    if(houmonRehabilitationIndividualRadioItem2==null){

      houmonRehabilitationIndividualRadioItem2 = new ACRadioButtonItem();

      houmonRehabilitationIndividualRadioItem2.setText("�މ@�E�ޏ���P�N�ȓ�");

      houmonRehabilitationIndividualRadioItem2.setGroup(getHoumonRehabilitationIndividualRadio());

      houmonRehabilitationIndividualRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

      addHoumonRehabilitationIndividualRadioItem2();
    }
    return houmonRehabilitationIndividualRadioItem2;

  }

  /**
   * �މ@�E�ޏ���P�N�����擾���܂��B
   * @return �މ@�E�ޏ���P�N��
   */
  public ACRadioButtonItem getHoumonRehabilitationIndividualRadioItem3(){
    if(houmonRehabilitationIndividualRadioItem3==null){

      houmonRehabilitationIndividualRadioItem3 = new ACRadioButtonItem();

      houmonRehabilitationIndividualRadioItem3.setText("�މ@�E�ޏ���P�N��");

      houmonRehabilitationIndividualRadioItem3.setGroup(getHoumonRehabilitationIndividualRadio());

      houmonRehabilitationIndividualRadioItem3.setConstraints(VRLayout.FLOW);

      addHoumonRehabilitationIndividualRadioItem3();
    }
    return houmonRehabilitationIndividualRadioItem3;

  }

  /**
   * �^�u2���擾���܂��B
   * @return �^�u2
   */
  public ACPanel getTab2(){
    if(tab2==null){

      tab2 = new ACPanel();

      tab2.setHgap(0);

      addTab2();
    }
    return tab2;

  }

  /**
   * �l�����Z���擾���܂��B
   * @return �l�����Z
   */
  public ACClearableRadioButtonGroup getHoumonRehabilitationSubtraction(){
    if(houmonRehabilitationSubtraction==null){

      houmonRehabilitationSubtraction = new ACClearableRadioButtonGroup();

      getHoumonRehabilitationSubtractionContainer().setText("�l�����Z");

      houmonRehabilitationSubtraction.setBindPath("1160109");

      houmonRehabilitationSubtraction.setModel(getHoumonRehabilitationSubtractionModel());

      houmonRehabilitationSubtraction.setUseClearButton(false);

      addHoumonRehabilitationSubtraction();
    }
    return houmonRehabilitationSubtraction;

  }

  /**
   * �l�����Z�R���e�i���擾���܂��B
   * @return �l�����Z�R���e�i
   */
  protected ACLabelContainer getHoumonRehabilitationSubtractionContainer(){
    if(houmonRehabilitationSubtractionContainer==null){
      houmonRehabilitationSubtractionContainer = new ACLabelContainer();
      houmonRehabilitationSubtractionContainer.setFollowChildEnabled(true);
      houmonRehabilitationSubtractionContainer.add(getHoumonRehabilitationSubtraction(), null);
    }
    return houmonRehabilitationSubtractionContainer;
  }

  /**
   * �l�����Z���f�����擾���܂��B
   * @return �l�����Z���f��
   */
  protected ACListModelAdapter getHoumonRehabilitationSubtractionModel(){
    if(houmonRehabilitationSubtractionModel==null){
      houmonRehabilitationSubtractionModel = new ACListModelAdapter();
      addHoumonRehabilitationSubtractionModel();
    }
    return houmonRehabilitationSubtractionModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getHoumonRehabilitationSubtractionNot(){
    if(houmonRehabilitationSubtractionNot==null){

      houmonRehabilitationSubtractionNot = new ACRadioButtonItem();

      houmonRehabilitationSubtractionNot.setText("�Ȃ�");

      houmonRehabilitationSubtractionNot.setGroup(getHoumonRehabilitationSubtraction());

      houmonRehabilitationSubtractionNot.setConstraints(VRLayout.FLOW);

      addHoumonRehabilitationSubtractionNot();
    }
    return houmonRehabilitationSubtractionNot;

  }

  /**
   * ������߂��擾���܂��B
   * @return �������
   */
  public ACRadioButtonItem getHoumonRehabilitationSubtractionExcess(){
    if(houmonRehabilitationSubtractionExcess==null){

      houmonRehabilitationSubtractionExcess = new ACRadioButtonItem();

      houmonRehabilitationSubtractionExcess.setText("�������");

      houmonRehabilitationSubtractionExcess.setGroup(getHoumonRehabilitationSubtraction());

      houmonRehabilitationSubtractionExcess.setConstraints(VRLayout.FLOW_RETURN);

      addHoumonRehabilitationSubtractionExcess();
    }
    return houmonRehabilitationSubtractionExcess;

  }

  /**
   * ��t�APT�EOT�EST�A�Ō�E���E���̕s�����擾���܂��B
   * @return ��t�APT�EOT�EST�A�Ō�E���E���̕s��
   */
  public ACRadioButtonItem getHoumonRehabilitationSubtractionLack(){
    if(houmonRehabilitationSubtractionLack==null){

      houmonRehabilitationSubtractionLack = new ACRadioButtonItem();

      houmonRehabilitationSubtractionLack.setText("<html>��t�APT�EOT�EST�A<br>�Ō�E���E���̕s��</html>");

      houmonRehabilitationSubtractionLack.setGroup(getHoumonRehabilitationSubtraction());

      houmonRehabilitationSubtractionLack.setConstraints(VRLayout.FLOW);

      addHoumonRehabilitationSubtractionLack();
    }
    return houmonRehabilitationSubtractionLack;

  }

  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001009Design() {

    try {
      initialize();

      initAffair(null);

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

    this.add(getTabs(), VRLayout.WEST);

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

    tab1.add(getHoumonRehabilitationTimeContena(), VRLayout.FLOW_DOUBLEINSETLINE_RETURN);

    tab1.add(getHoumonRehabilitationTimeContenaFacilityDivisionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getHoumonRehabilitationTimeDivisionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getHoumonRehabilitationBathRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getHoumonRehabilitationMeetingAndSendingOffContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getHoumonRehabilitationAdditionTreatmentPersonRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getHoumonRehabilitationIndividualRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * �񋟎��ԃR���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonRehabilitationTimeContena(){

    houmonRehabilitationTimeContena.add(getHoumonRehabilitationTimeContenaBeginTimeContainer(), VRLayout.FLOW);

    houmonRehabilitationTimeContena.add(getHoumonRehabilitationTimeContenaEndTimeContainer(), VRLayout.FLOW);

  }

  /**
   * �J�n�����R���{�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonRehabilitationTimeContenaBeginTime(){

  }

  /**
   * �J�n�����R���{���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonRehabilitationTimeContenaBeginTimeModel(){

  }

  /**
   * �I�������R���{�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonRehabilitationTimeContenaEndTime(){

  }

  /**
   * �I�������R���{���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonRehabilitationTimeContenaEndTimeModel(){

  }

  /**
   * �{�݋敪�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonRehabilitationTimeContenaFacilityDivision(){

  }

  /**
   * �{�݋敪���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonRehabilitationTimeContenaFacilityDivisionModel(){

    getHoumonRehabilitationMedicalInstitution().setButtonIndex(1);
    getHoumonRehabilitationTimeContenaFacilityDivisionModel().add(getHoumonRehabilitationMedicalInstitution());

    getHoumonRehabilitationDouble().setButtonIndex(2);
    getHoumonRehabilitationTimeContenaFacilityDivisionModel().add(getHoumonRehabilitationDouble());

    getHoumonRehabilitationClinic().setButtonIndex(3);
    getHoumonRehabilitationTimeContenaFacilityDivisionModel().add(getHoumonRehabilitationClinic());

  }

  /**
   * �ʏ�K�͈�Ë@�ւɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonRehabilitationMedicalInstitution(){

  }

  /**
   * ���K�͐f�Ï��ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonRehabilitationDouble(){

  }

  /**
   * ���V�l�ی��{�݂ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonRehabilitationClinic(){

  }

  /**
   * ���ԋ敪�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonRehabilitationTimeDivision(){

  }

  /**
   * ���ԋ敪���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonRehabilitationTimeDivisionModel(){

  }

  /**
   * �������Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonRehabilitationBathRadio(){

  }

  /**
   * �������Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonRehabilitationBathRadioModel(){

    getHoumonRehabilitationBathRadioItem1().setButtonIndex(1);
    getHoumonRehabilitationBathRadioModel().add(getHoumonRehabilitationBathRadioItem1());

    getHoumonRehabilitationBathRadioItem2().setButtonIndex(2);
    getHoumonRehabilitationBathRadioModel().add(getHoumonRehabilitationBathRadioItem2());

    getHoumonRehabilitationBathRadioItem3().setButtonIndex(3);
    getHoumonRehabilitationBathRadioModel().add(getHoumonRehabilitationBathRadioItem3());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonRehabilitationBathRadioItem1(){

  }

  /**
   * �ʏ�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonRehabilitationBathRadioItem2(){

  }

  /**
   * ���ʓ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonRehabilitationBathRadioItem3(){

  }

  /**
   * ���}�敪�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonRehabilitationMeetingAndSendingOff(){

  }

  /**
   * ���}�敪���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonRehabilitationMeetingAndSendingOffModel(){

    getHoumonRehabilitationMeetingAndSendingOffNone().setButtonIndex(1);
    getHoumonRehabilitationMeetingAndSendingOffModel().add(getHoumonRehabilitationMeetingAndSendingOffNone());

    getHoumonRehabilitationMeetingAndSendingOffOneWay().setButtonIndex(2);
    getHoumonRehabilitationMeetingAndSendingOffModel().add(getHoumonRehabilitationMeetingAndSendingOffOneWay());

    getHoumonRehabilitationMeetingAndSendingOffRoundTrip().setButtonIndex(3);
    getHoumonRehabilitationMeetingAndSendingOffModel().add(getHoumonRehabilitationMeetingAndSendingOffRoundTrip());

  }

  /**
   * ���}�Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonRehabilitationMeetingAndSendingOffNone(){

  }

  /**
   * ���}�Г��ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonRehabilitationMeetingAndSendingOffOneWay(){

  }

  /**
   * ���}�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonRehabilitationMeetingAndSendingOffRoundTrip(){

  }

  /**
   * ���n�r���K��w�����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonRehabilitationAdditionTreatmentPersonRadio(){

  }

  /**
   * ���n�r���K��w�����Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonRehabilitationAdditionTreatmentPersonRadioModel(){

    getHoumonRehabilitationAdditionTreatmentPersonRadioItem1().setButtonIndex(1);
    getHoumonRehabilitationAdditionTreatmentPersonRadioModel().add(getHoumonRehabilitationAdditionTreatmentPersonRadioItem1());

    getHoumonRehabilitationAdditionTreatmentPersonRadioItem2().setButtonIndex(2);
    getHoumonRehabilitationAdditionTreatmentPersonRadioModel().add(getHoumonRehabilitationAdditionTreatmentPersonRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonRehabilitationAdditionTreatmentPersonRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonRehabilitationAdditionTreatmentPersonRadioItem2(){

  }

  /**
   * �ʃ��n�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonRehabilitationIndividualRadio(){

  }

  /**
   * �ʃ��n���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonRehabilitationIndividualRadioModel(){

    getHoumonRehabilitationIndividualRadioItem1().setButtonIndex(1);
    getHoumonRehabilitationIndividualRadioModel().add(getHoumonRehabilitationIndividualRadioItem1());

    getHoumonRehabilitationIndividualRadioItem2().setButtonIndex(2);
    getHoumonRehabilitationIndividualRadioModel().add(getHoumonRehabilitationIndividualRadioItem2());

    getHoumonRehabilitationIndividualRadioItem3().setButtonIndex(3);
    getHoumonRehabilitationIndividualRadioModel().add(getHoumonRehabilitationIndividualRadioItem3());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonRehabilitationIndividualRadioItem1(){

  }

  /**
   * �މ@�E�ޏ���P�N�ȓ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonRehabilitationIndividualRadioItem2(){

  }

  /**
   * �މ@�E�ޏ���P�N���ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonRehabilitationIndividualRadioItem3(){

  }

  /**
   * �^�u2�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTab2(){

    tab2.add(getHoumonRehabilitationSubtractionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * �l�����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonRehabilitationSubtraction(){

  }

  /**
   * �l�����Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonRehabilitationSubtractionModel(){

    getHoumonRehabilitationSubtractionNot().setButtonIndex(1);
    getHoumonRehabilitationSubtractionModel().add(getHoumonRehabilitationSubtractionNot());

    getHoumonRehabilitationSubtractionExcess().setButtonIndex(2);
    getHoumonRehabilitationSubtractionModel().add(getHoumonRehabilitationSubtractionExcess());

    getHoumonRehabilitationSubtractionLack().setButtonIndex(3);
    getHoumonRehabilitationSubtractionModel().add(getHoumonRehabilitationSubtractionLack());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonRehabilitationSubtractionNot(){

  }

  /**
   * ������߂ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonRehabilitationSubtractionExcess(){

  }

  /**
   * ��t�APT�EOT�EST�A�Ō�E���E���̕s���ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonRehabilitationSubtractionLack(){

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
      ACFrame.setVRLookAndFeel();
      ACFrame.getInstance().setFrameEventProcesser(new QkanFrameEventProcesser());
      ACFrame.getInstance().getContentPane().add(new QS001009Design());
      ACFrame.getInstance().setVisible(true);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QS001009Design getThis() {
    return this;
  }
}
