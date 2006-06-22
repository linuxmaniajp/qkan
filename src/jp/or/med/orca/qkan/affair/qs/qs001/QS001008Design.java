
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
 * �T�u�V�X�e�� �T�[�r�X�\��쐬/�ύX (S)
 * �v���Z�X �T�[�r�X�\��T�� (001)
 * �v���O���� �T�[�r�X�p�^�[���ʏ���� (QS001008)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
import java.awt.Component;

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
 * �T�[�r�X�p�^�[���ʏ�����ʍ��ڃf�U�C��(QS001008) 
 */
public class QS001008Design extends QS001ServicePanel {
  //GUI�R���|�[�l���g

  private ACPanel tsuusyoKaigoPatterns;

  private ACBackLabelContainer tsuusyoKaigoTimeContena;

  private ACTimeComboBox tsuusyoKaigoTimeBeginTime;

  private ACLabelContainer tsuusyoKaigoTimeBeginTimeContainer;

  private ACComboBoxModelAdapter tsuusyoKaigoTimeBeginTimeModel;

  private ACTimeComboBox tsuusyoKaigoTimeEndTime;

  private ACLabelContainer tsuusyoKaigoTimeEndTimeContainer;

  private ACComboBoxModelAdapter tsuusyoKaigoTimeEndTimeModel;

  private ACClearableRadioButtonGroup tsuusyoKaigoTimeContenaFacilityDivision;

  private ACLabelContainer tsuusyoKaigoTimeContenaFacilityDivisionContainer;

  private ACListModelAdapter tsuusyoKaigoTimeContenaFacilityDivisionModel;

  private ACRadioButtonItem tsuusyoKaigoSingle;

  private ACRadioButtonItem tsuusyoKaigoDouble;

  private ACRadioButtonItem tsuusyoKaigoDementiaSingle;

  private ACRadioButtonItem tsuusyoKaigoDementiaDouble;

  private ACComboBox tsuusyoKaigoTimeDivision;

  private ACLabelContainer tsuusyoKaigoTimeDivisionContainer;

  private ACComboBoxModelAdapter tsuusyoKaigoTimeDivisionModel;

  private ACClearableRadioButtonGroup tsuusyoKaigoAdditionFunctionTrainingRadio;

  private ACLabelContainer tsuusyoKaigoAdditionFunctionTrainingRadioContainer;

  private ACListModelAdapter tsuusyoKaigoAdditionFunctionTrainingRadioModel;

  private ACRadioButtonItem tsuusyoKaigoAdditionFunctionTrainingRadioItem1;

  private ACRadioButtonItem tsuusyoKaigoAdditionFunctionTrainingRadioItem2;

  private ACClearableRadioButtonGroup tsuusyoKaigoAdditionFunctionBathRadio;

  private ACLabelContainer tsuusyoKaigoAdditionFunctionBathRadioContainer;

  private ACListModelAdapter tsuusyoKaigoAdditionFunctionBathRadioModel;

  private ACRadioButtonItem tsuusyoKaigoAdditionFunctionBathRadioItem1;

  private ACRadioButtonItem tsuusyoKaigoAdditionFunctionBathRadioItem2;

  private ACRadioButtonItem tsuusyoKaigoAdditionFunctionBathRadioItem3;

  private ACClearableRadioButtonGroup tsuusyoKaigoMeetingAndSendingOff;

  private ACLabelContainer tsuusyoKaigoMeetingAndSendingOffContainer;

  private ACListModelAdapter tsuusyoKaigoMeetingAndSendingOffModel;

  private ACRadioButtonItem tsuusyoKaigoMeetingAndSendingOffNone;

  private ACRadioButtonItem tsuusyoKaigoMeetingAndSendingOffOneWay;

  private ACRadioButtonItem tsuusyoKaigoMeetingAndSendingOffRoundTrip;

  private ACClearableRadioButtonGroup tsuusyoKaigoSubtraction;

  private ACLabelContainer tsuusyoKaigoSubtractionContainer;

  private ACListModelAdapter tsuusyoKaigoSubtractionModel;

  private ACRadioButtonItem tsuusyoKaigoSubtractionNot;

  private ACRadioButtonItem tsuusyoKaigoSubtractionExcess;

  private ACRadioButtonItem tsuusyoKaigoSubtractionLack;

  //getter

  /**
   * �ʏ����p�^�[���̈���擾���܂��B
   * @return �ʏ����p�^�[���̈�
   */
  public ACPanel getTsuusyoKaigoPatterns(){
    if(tsuusyoKaigoPatterns==null){

      tsuusyoKaigoPatterns = new ACPanel();

      tsuusyoKaigoPatterns.setHgap(0);

      addTsuusyoKaigoPatterns();
    }
    return tsuusyoKaigoPatterns;

  }

  /**
   * �񋟎��ԃR���e�i���擾���܂��B
   * @return �񋟎��ԃR���e�i
   */
  public ACBackLabelContainer getTsuusyoKaigoTimeContena(){
    if(tsuusyoKaigoTimeContena==null){

      tsuusyoKaigoTimeContena = new ACBackLabelContainer();

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

      tsuusyoKaigoTimeBeginTime.setModel(getTsuusyoKaigoTimeBeginTimeModel());

      tsuusyoKaigoTimeBeginTime.setRenderBindPath("CONTENT");

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

      tsuusyoKaigoTimeEndTime.setModel(getTsuusyoKaigoTimeEndTimeModel());

      tsuusyoKaigoTimeEndTime.setRenderBindPath("CONTENT");

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
   * �{�݋敪���擾���܂��B
   * @return �{�݋敪
   */
  public ACClearableRadioButtonGroup getTsuusyoKaigoTimeContenaFacilityDivision(){
    if(tsuusyoKaigoTimeContenaFacilityDivision==null){

      tsuusyoKaigoTimeContenaFacilityDivision = new ACClearableRadioButtonGroup();

      getTsuusyoKaigoTimeContenaFacilityDivisionContainer().setText("�{�݋敪");

      tsuusyoKaigoTimeContenaFacilityDivision.setBindPath("1150103");

      tsuusyoKaigoTimeContenaFacilityDivision.setModel(getTsuusyoKaigoTimeContenaFacilityDivisionModel());

      tsuusyoKaigoTimeContenaFacilityDivision.setUseClearButton(false);

      addTsuusyoKaigoTimeContenaFacilityDivision();
    }
    return tsuusyoKaigoTimeContenaFacilityDivision;

  }

  /**
   * �{�݋敪�R���e�i���擾���܂��B
   * @return �{�݋敪�R���e�i
   */
  protected ACLabelContainer getTsuusyoKaigoTimeContenaFacilityDivisionContainer(){
    if(tsuusyoKaigoTimeContenaFacilityDivisionContainer==null){
      tsuusyoKaigoTimeContenaFacilityDivisionContainer = new ACLabelContainer();
      tsuusyoKaigoTimeContenaFacilityDivisionContainer.setFollowChildEnabled(true);
      tsuusyoKaigoTimeContenaFacilityDivisionContainer.add(getTsuusyoKaigoTimeContenaFacilityDivision(), null);
    }
    return tsuusyoKaigoTimeContenaFacilityDivisionContainer;
  }

  /**
   * �{�݋敪���f�����擾���܂��B
   * @return �{�݋敪���f��
   */
  protected ACListModelAdapter getTsuusyoKaigoTimeContenaFacilityDivisionModel(){
    if(tsuusyoKaigoTimeContenaFacilityDivisionModel==null){
      tsuusyoKaigoTimeContenaFacilityDivisionModel = new ACListModelAdapter();
      addTsuusyoKaigoTimeContenaFacilityDivisionModel();
    }
    return tsuusyoKaigoTimeContenaFacilityDivisionModel;
  }

  /**
   * �P�ƌ^���擾���܂��B
   * @return �P�ƌ^
   */
  public ACRadioButtonItem getTsuusyoKaigoSingle(){
    if(tsuusyoKaigoSingle==null){

      tsuusyoKaigoSingle = new ACRadioButtonItem();

      tsuusyoKaigoSingle.setText("�P�ƌ^");

      tsuusyoKaigoSingle.setGroup(getTsuusyoKaigoTimeContenaFacilityDivision());

      tsuusyoKaigoSingle.setConstraints(VRLayout.FLOW);

      addTsuusyoKaigoSingle();
    }
    return tsuusyoKaigoSingle;

  }

  /**
   * ���݌^���擾���܂��B
   * @return ���݌^
   */
  public ACRadioButtonItem getTsuusyoKaigoDouble(){
    if(tsuusyoKaigoDouble==null){

      tsuusyoKaigoDouble = new ACRadioButtonItem();

      tsuusyoKaigoDouble.setText("���݌^");

      tsuusyoKaigoDouble.setGroup(getTsuusyoKaigoTimeContenaFacilityDivision());

      tsuusyoKaigoDouble.setConstraints(VRLayout.FLOW_RETURN);

      addTsuusyoKaigoDouble();
    }
    return tsuusyoKaigoDouble;

  }

  /**
   * �s���p�P�ƌ^���擾���܂��B
   * @return �s���p�P�ƌ^
   */
  public ACRadioButtonItem getTsuusyoKaigoDementiaSingle(){
    if(tsuusyoKaigoDementiaSingle==null){

      tsuusyoKaigoDementiaSingle = new ACRadioButtonItem();

      tsuusyoKaigoDementiaSingle.setText("�F�m�ǐ�p�P�ƌ^");

      tsuusyoKaigoDementiaSingle.setGroup(getTsuusyoKaigoTimeContenaFacilityDivision());

      tsuusyoKaigoDementiaSingle.setConstraints(VRLayout.FLOW);

      addTsuusyoKaigoDementiaSingle();
    }
    return tsuusyoKaigoDementiaSingle;

  }

  /**
   * �s���p���݌^���擾���܂��B
   * @return �s���p���݌^
   */
  public ACRadioButtonItem getTsuusyoKaigoDementiaDouble(){
    if(tsuusyoKaigoDementiaDouble==null){

      tsuusyoKaigoDementiaDouble = new ACRadioButtonItem();

      tsuusyoKaigoDementiaDouble.setText("�F�m�ǐ�p���݌^");

      tsuusyoKaigoDementiaDouble.setGroup(getTsuusyoKaigoTimeContenaFacilityDivision());

      tsuusyoKaigoDementiaDouble.setConstraints(VRLayout.FLOW);

      addTsuusyoKaigoDementiaDouble();
    }
    return tsuusyoKaigoDementiaDouble;

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

      tsuusyoKaigoTimeDivision.setModel(getTsuusyoKaigoTimeDivisionModel());

      tsuusyoKaigoTimeDivision.setRenderBindPath("CONTENT");

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
   * �@�\�P���w�����Z���擾���܂��B
   * @return �@�\�P���w�����Z
   */
  public ACClearableRadioButtonGroup getTsuusyoKaigoAdditionFunctionTrainingRadio(){
    if(tsuusyoKaigoAdditionFunctionTrainingRadio==null){

      tsuusyoKaigoAdditionFunctionTrainingRadio = new ACClearableRadioButtonGroup();

      getTsuusyoKaigoAdditionFunctionTrainingRadioContainer().setText("�@�\�P�����Z");

      tsuusyoKaigoAdditionFunctionTrainingRadio.setBindPath("1150105");

      tsuusyoKaigoAdditionFunctionTrainingRadio.setModel(getTsuusyoKaigoAdditionFunctionTrainingRadioModel());

      tsuusyoKaigoAdditionFunctionTrainingRadio.setUseClearButton(false);

      addTsuusyoKaigoAdditionFunctionTrainingRadio();
    }
    return tsuusyoKaigoAdditionFunctionTrainingRadio;

  }

  /**
   * �@�\�P���w�����Z�R���e�i���擾���܂��B
   * @return �@�\�P���w�����Z�R���e�i
   */
  protected ACLabelContainer getTsuusyoKaigoAdditionFunctionTrainingRadioContainer(){
    if(tsuusyoKaigoAdditionFunctionTrainingRadioContainer==null){
      tsuusyoKaigoAdditionFunctionTrainingRadioContainer = new ACLabelContainer();
      tsuusyoKaigoAdditionFunctionTrainingRadioContainer.setFollowChildEnabled(true);
      tsuusyoKaigoAdditionFunctionTrainingRadioContainer.add(getTsuusyoKaigoAdditionFunctionTrainingRadio(), null);
    }
    return tsuusyoKaigoAdditionFunctionTrainingRadioContainer;
  }

  /**
   * �@�\�P���w�����Z���f�����擾���܂��B
   * @return �@�\�P���w�����Z���f��
   */
  protected ACListModelAdapter getTsuusyoKaigoAdditionFunctionTrainingRadioModel(){
    if(tsuusyoKaigoAdditionFunctionTrainingRadioModel==null){
      tsuusyoKaigoAdditionFunctionTrainingRadioModel = new ACListModelAdapter();
      addTsuusyoKaigoAdditionFunctionTrainingRadioModel();
    }
    return tsuusyoKaigoAdditionFunctionTrainingRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getTsuusyoKaigoAdditionFunctionTrainingRadioItem1(){
    if(tsuusyoKaigoAdditionFunctionTrainingRadioItem1==null){

      tsuusyoKaigoAdditionFunctionTrainingRadioItem1 = new ACRadioButtonItem();

      tsuusyoKaigoAdditionFunctionTrainingRadioItem1.setText("�Ȃ�");

      tsuusyoKaigoAdditionFunctionTrainingRadioItem1.setGroup(getTsuusyoKaigoAdditionFunctionTrainingRadio());

      tsuusyoKaigoAdditionFunctionTrainingRadioItem1.setConstraints(VRLayout.FLOW);

      addTsuusyoKaigoAdditionFunctionTrainingRadioItem1();
    }
    return tsuusyoKaigoAdditionFunctionTrainingRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getTsuusyoKaigoAdditionFunctionTrainingRadioItem2(){
    if(tsuusyoKaigoAdditionFunctionTrainingRadioItem2==null){

      tsuusyoKaigoAdditionFunctionTrainingRadioItem2 = new ACRadioButtonItem();

      tsuusyoKaigoAdditionFunctionTrainingRadioItem2.setText("����");

      tsuusyoKaigoAdditionFunctionTrainingRadioItem2.setGroup(getTsuusyoKaigoAdditionFunctionTrainingRadio());

      tsuusyoKaigoAdditionFunctionTrainingRadioItem2.setConstraints(VRLayout.FLOW);

      addTsuusyoKaigoAdditionFunctionTrainingRadioItem2();
    }
    return tsuusyoKaigoAdditionFunctionTrainingRadioItem2;

  }

  /**
   * �������Z���擾���܂��B
   * @return �������Z
   */
  public ACClearableRadioButtonGroup getTsuusyoKaigoAdditionFunctionBathRadio(){
    if(tsuusyoKaigoAdditionFunctionBathRadio==null){

      tsuusyoKaigoAdditionFunctionBathRadio = new ACClearableRadioButtonGroup();

      getTsuusyoKaigoAdditionFunctionBathRadioContainer().setText("�������Z");

      tsuusyoKaigoAdditionFunctionBathRadio.setBindPath("1150106");

      tsuusyoKaigoAdditionFunctionBathRadio.setModel(getTsuusyoKaigoAdditionFunctionBathRadioModel());

      tsuusyoKaigoAdditionFunctionBathRadio.setUseClearButton(false);

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
   * �ʏ���擾���܂��B
   * @return �ʏ�
   */
  public ACRadioButtonItem getTsuusyoKaigoAdditionFunctionBathRadioItem2(){
    if(tsuusyoKaigoAdditionFunctionBathRadioItem2==null){

      tsuusyoKaigoAdditionFunctionBathRadioItem2 = new ACRadioButtonItem();

      tsuusyoKaigoAdditionFunctionBathRadioItem2.setText("�ʏ����");

      tsuusyoKaigoAdditionFunctionBathRadioItem2.setGroup(getTsuusyoKaigoAdditionFunctionBathRadio());

      tsuusyoKaigoAdditionFunctionBathRadioItem2.setConstraints(VRLayout.FLOW);

      addTsuusyoKaigoAdditionFunctionBathRadioItem2();
    }
    return tsuusyoKaigoAdditionFunctionBathRadioItem2;

  }

  /**
   * ���ʓ������擾���܂��B
   * @return ���ʓ���
   */
  public ACRadioButtonItem getTsuusyoKaigoAdditionFunctionBathRadioItem3(){
    if(tsuusyoKaigoAdditionFunctionBathRadioItem3==null){

      tsuusyoKaigoAdditionFunctionBathRadioItem3 = new ACRadioButtonItem();

      tsuusyoKaigoAdditionFunctionBathRadioItem3.setText("���ʓ���");

      tsuusyoKaigoAdditionFunctionBathRadioItem3.setGroup(getTsuusyoKaigoAdditionFunctionBathRadio());

      tsuusyoKaigoAdditionFunctionBathRadioItem3.setConstraints(VRLayout.FLOW);

      addTsuusyoKaigoAdditionFunctionBathRadioItem3();
    }
    return tsuusyoKaigoAdditionFunctionBathRadioItem3;

  }

  /**
   * ���}�敪���擾���܂��B
   * @return ���}�敪
   */
  public ACClearableRadioButtonGroup getTsuusyoKaigoMeetingAndSendingOff(){
    if(tsuusyoKaigoMeetingAndSendingOff==null){

      tsuusyoKaigoMeetingAndSendingOff = new ACClearableRadioButtonGroup();

      getTsuusyoKaigoMeetingAndSendingOffContainer().setText("���}���Z");

      tsuusyoKaigoMeetingAndSendingOff.setBindPath("6");

      tsuusyoKaigoMeetingAndSendingOff.setModel(getTsuusyoKaigoMeetingAndSendingOffModel());

      tsuusyoKaigoMeetingAndSendingOff.setUseClearButton(false);

      addTsuusyoKaigoMeetingAndSendingOff();
    }
    return tsuusyoKaigoMeetingAndSendingOff;

  }

  /**
   * ���}�敪�R���e�i���擾���܂��B
   * @return ���}�敪�R���e�i
   */
  protected ACLabelContainer getTsuusyoKaigoMeetingAndSendingOffContainer(){
    if(tsuusyoKaigoMeetingAndSendingOffContainer==null){
      tsuusyoKaigoMeetingAndSendingOffContainer = new ACLabelContainer();
      tsuusyoKaigoMeetingAndSendingOffContainer.setFollowChildEnabled(true);
      tsuusyoKaigoMeetingAndSendingOffContainer.add(getTsuusyoKaigoMeetingAndSendingOff(), null);
    }
    return tsuusyoKaigoMeetingAndSendingOffContainer;
  }

  /**
   * ���}�敪���f�����擾���܂��B
   * @return ���}�敪���f��
   */
  protected ACListModelAdapter getTsuusyoKaigoMeetingAndSendingOffModel(){
    if(tsuusyoKaigoMeetingAndSendingOffModel==null){
      tsuusyoKaigoMeetingAndSendingOffModel = new ACListModelAdapter();
      addTsuusyoKaigoMeetingAndSendingOffModel();
    }
    return tsuusyoKaigoMeetingAndSendingOffModel;
  }

  /**
   * ���}�Ȃ����擾���܂��B
   * @return ���}�Ȃ�
   */
  public ACRadioButtonItem getTsuusyoKaigoMeetingAndSendingOffNone(){
    if(tsuusyoKaigoMeetingAndSendingOffNone==null){

      tsuusyoKaigoMeetingAndSendingOffNone = new ACRadioButtonItem();

      tsuusyoKaigoMeetingAndSendingOffNone.setText("���}�Ȃ�");

      tsuusyoKaigoMeetingAndSendingOffNone.setGroup(getTsuusyoKaigoMeetingAndSendingOff());

      tsuusyoKaigoMeetingAndSendingOffNone.setConstraints(VRLayout.FLOW);

      addTsuusyoKaigoMeetingAndSendingOffNone();
    }
    return tsuusyoKaigoMeetingAndSendingOffNone;

  }

  /**
   * ���}�Г����擾���܂��B
   * @return ���}�Г�
   */
  public ACRadioButtonItem getTsuusyoKaigoMeetingAndSendingOffOneWay(){
    if(tsuusyoKaigoMeetingAndSendingOffOneWay==null){

      tsuusyoKaigoMeetingAndSendingOffOneWay = new ACRadioButtonItem();

      tsuusyoKaigoMeetingAndSendingOffOneWay.setText("���}�Г�");

      tsuusyoKaigoMeetingAndSendingOffOneWay.setGroup(getTsuusyoKaigoMeetingAndSendingOff());

      tsuusyoKaigoMeetingAndSendingOffOneWay.setConstraints(VRLayout.FLOW);

      addTsuusyoKaigoMeetingAndSendingOffOneWay();
    }
    return tsuusyoKaigoMeetingAndSendingOffOneWay;

  }

  /**
   * ���}�������擾���܂��B
   * @return ���}����
   */
  public ACRadioButtonItem getTsuusyoKaigoMeetingAndSendingOffRoundTrip(){
    if(tsuusyoKaigoMeetingAndSendingOffRoundTrip==null){

      tsuusyoKaigoMeetingAndSendingOffRoundTrip = new ACRadioButtonItem();

      tsuusyoKaigoMeetingAndSendingOffRoundTrip.setText("���}����");

      tsuusyoKaigoMeetingAndSendingOffRoundTrip.setGroup(getTsuusyoKaigoMeetingAndSendingOff());

      tsuusyoKaigoMeetingAndSendingOffRoundTrip.setConstraints(VRLayout.FLOW);

      addTsuusyoKaigoMeetingAndSendingOffRoundTrip();
    }
    return tsuusyoKaigoMeetingAndSendingOffRoundTrip;

  }

  /**
   * �l�����Z���擾���܂��B
   * @return �l�����Z
   */
  public ACClearableRadioButtonGroup getTsuusyoKaigoSubtraction(){
    if(tsuusyoKaigoSubtraction==null){

      tsuusyoKaigoSubtraction = new ACClearableRadioButtonGroup();

      getTsuusyoKaigoSubtractionContainer().setText("�l�����Z");

      tsuusyoKaigoSubtraction.setBindPath("1150108");

      tsuusyoKaigoSubtraction.setModel(getTsuusyoKaigoSubtractionModel());

      tsuusyoKaigoSubtraction.setUseClearButton(false);

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
   * �R���X�g���N�^�ł��B
   */
  public QS001008Design() {

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

    this.add(getTsuusyoKaigoPatterns(), VRLayout.WEST);

  }

  /**
   * �ʏ����p�^�[���̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTsuusyoKaigoPatterns(){

    tsuusyoKaigoPatterns.add(getTsuusyoKaigoTimeContena(), VRLayout.FLOW_DOUBLEINSETLINE_RETURN);

    tsuusyoKaigoPatterns.add(getTsuusyoKaigoTimeContenaFacilityDivisionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tsuusyoKaigoPatterns.add(getTsuusyoKaigoTimeDivisionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tsuusyoKaigoPatterns.add(getTsuusyoKaigoAdditionFunctionTrainingRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tsuusyoKaigoPatterns.add(getTsuusyoKaigoAdditionFunctionBathRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tsuusyoKaigoPatterns.add(getTsuusyoKaigoMeetingAndSendingOffContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tsuusyoKaigoPatterns.add(getTsuusyoKaigoSubtractionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

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
   * �{�݋敪�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTsuusyoKaigoTimeContenaFacilityDivision(){

  }

  /**
   * �{�݋敪���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addTsuusyoKaigoTimeContenaFacilityDivisionModel(){

    getTsuusyoKaigoSingle().setButtonIndex(1);
    getTsuusyoKaigoTimeContenaFacilityDivisionModel().add(getTsuusyoKaigoSingle());

    getTsuusyoKaigoDouble().setButtonIndex(2);
    getTsuusyoKaigoTimeContenaFacilityDivisionModel().add(getTsuusyoKaigoDouble());

    getTsuusyoKaigoDementiaSingle().setButtonIndex(3);
    getTsuusyoKaigoTimeContenaFacilityDivisionModel().add(getTsuusyoKaigoDementiaSingle());

    getTsuusyoKaigoDementiaDouble().setButtonIndex(4);
    getTsuusyoKaigoTimeContenaFacilityDivisionModel().add(getTsuusyoKaigoDementiaDouble());

  }

  /**
   * �P�ƌ^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTsuusyoKaigoSingle(){

  }

  /**
   * ���݌^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTsuusyoKaigoDouble(){

  }

  /**
   * �s���p�P�ƌ^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTsuusyoKaigoDementiaSingle(){

  }

  /**
   * �s���p���݌^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTsuusyoKaigoDementiaDouble(){

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
   * �@�\�P���w�����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTsuusyoKaigoAdditionFunctionTrainingRadio(){

  }

  /**
   * �@�\�P���w�����Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addTsuusyoKaigoAdditionFunctionTrainingRadioModel(){

    getTsuusyoKaigoAdditionFunctionTrainingRadioItem1().setButtonIndex(1);
    getTsuusyoKaigoAdditionFunctionTrainingRadioModel().add(getTsuusyoKaigoAdditionFunctionTrainingRadioItem1());

    getTsuusyoKaigoAdditionFunctionTrainingRadioItem2().setButtonIndex(2);
    getTsuusyoKaigoAdditionFunctionTrainingRadioModel().add(getTsuusyoKaigoAdditionFunctionTrainingRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addTsuusyoKaigoAdditionFunctionTrainingRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
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

    getTsuusyoKaigoAdditionFunctionBathRadioItem3().setButtonIndex(3);
    getTsuusyoKaigoAdditionFunctionBathRadioModel().add(getTsuusyoKaigoAdditionFunctionBathRadioItem3());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addTsuusyoKaigoAdditionFunctionBathRadioItem1(){

  }

  /**
   * �ʏ�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTsuusyoKaigoAdditionFunctionBathRadioItem2(){

  }

  /**
   * ���ʓ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addTsuusyoKaigoAdditionFunctionBathRadioItem3(){

  }

  /**
   * ���}�敪�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTsuusyoKaigoMeetingAndSendingOff(){

  }

  /**
   * ���}�敪���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addTsuusyoKaigoMeetingAndSendingOffModel(){

    getTsuusyoKaigoMeetingAndSendingOffNone().setButtonIndex(1);
    getTsuusyoKaigoMeetingAndSendingOffModel().add(getTsuusyoKaigoMeetingAndSendingOffNone());

    getTsuusyoKaigoMeetingAndSendingOffOneWay().setButtonIndex(2);
    getTsuusyoKaigoMeetingAndSendingOffModel().add(getTsuusyoKaigoMeetingAndSendingOffOneWay());

    getTsuusyoKaigoMeetingAndSendingOffRoundTrip().setButtonIndex(3);
    getTsuusyoKaigoMeetingAndSendingOffModel().add(getTsuusyoKaigoMeetingAndSendingOffRoundTrip());

  }

  /**
   * ���}�Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addTsuusyoKaigoMeetingAndSendingOffNone(){

  }

  /**
   * ���}�Г��ɓ������ڂ�ǉ����܂��B
   */
  protected void addTsuusyoKaigoMeetingAndSendingOffOneWay(){

  }

  /**
   * ���}�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addTsuusyoKaigoMeetingAndSendingOffRoundTrip(){

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
      ACFrame.getInstance().getContentPane().add(new QS001008Design());
      ACFrame.getInstance().setVisible(true);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QS001008Design getThis() {
    return this;
  }
}
