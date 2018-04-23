
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
 * �쐬��: 2018/02/07  ���{�R���s���[�^�[������� �����@���̂� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �T�[�r�X�\��쐬/�ύX (S)
 * �v���Z�X �T�[�r�X�\��T�� (001)
 * �v���O���� �T�[�r�X�p�^�[���n�斧���^�ʏ���� (QS001_17811_201804)
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
 * �T�[�r�X�p�^�[���n�斧���^�ʏ�����ʍ��ڃf�U�C��(QS001_17811_201804) 
 */
public class QS001_17811_201804Design extends QS001ServicePanel {
  //GUI�R���|�[�l���g

  private JTabbedPane tsuusyoKaigoPatterns;

  private ACPanel tab1;

  private ACLabelContainer tsuusyoKaigoFacilitiesDivisionContainer;

  private ACValueArrayRadioButtonGroup tsuusyoKaigoTimeContenaFacilityDivision;

  private ACListModelAdapter tsuusyoKaigoTimeContenaFacilityDivisionModel;

  private ACRadioButtonItem tsuusyoKaigoTimeContenaFacilityDivisionItem1;

  private ACRadioButtonItem tsuusyoKaigoTimeContenaFacilityDivisionItem2;

  private ACComboBox tsuusyoKaigoTimeDivision;

  private ACLabelContainer tsuusyoKaigoTimeDivisionContainer;

  private ACComboBoxModelAdapter tsuusyoKaigoTimeDivisionModel;

  private ACValueArrayRadioButtonGroup tsuusyoKaigoSubtraction;

  private ACLabelContainer tsuusyoKaigoSubtractionContainer;

  private ACListModelAdapter tsuusyoKaigoSubtractionModel;

  private ACRadioButtonItem tsuusyoKaigoSubtractionNot;

  private ACRadioButtonItem tsuusyoKaigoSubtractionExcess;

  private ACRadioButtonItem tsuusyoKaigoSubtractionLack;

  private ACValueArrayRadioButtonGroup providerAddMountainousAreaRadioGroup;

  private ACLabelContainer providerAddMountainousAreaRadioGroupContainer;

  private ACListModelAdapter providerAddMountainousAreaRadioGroupModel;

  private ACRadioButtonItem providerAddMountainousAreaRadioItem1;

  private ACRadioButtonItem providerAddMountainousAreaRadioItem2;

  private ACValueArrayRadioButtonGroup tsuusyoKaigoAdditionFunctionBathRadio;

  private ACLabelContainer tsuusyoKaigoAdditionFunctionBathRadioContainer;

  private ACListModelAdapter tsuusyoKaigoAdditionFunctionBathRadioModel;

  private ACRadioButtonItem tsuusyoKaigoAdditionFunctionBathRadioItem1;

  private ACRadioButtonItem tsuusyoKaigoAdditionFunctionBathRadioItem2;

  private ACValueArrayRadioButtonGroup severeCareRecipientsAccepted;

  private ACLabelContainer severeCareRecipientsAcceptedContainer;

  private ACListModelAdapter severeCareRecipientsAcceptedModel;

  private ACRadioButtonItem severeCareRecipientsAcceptedItem1;

  private ACRadioButtonItem severeCareRecipientsAcceptedItem2;

  private ACLabelContainer tsuusyoKaigoAdditionFunctionTrainingRadio;

  private ACIntegerCheckBox tsuusyoKaigoAdditionFunctionTrainingRadioItem1;

  private ACIntegerCheckBox tsuusyoKaigoAdditionFunctionTrainingRadioItem2;

  private ACValueArrayRadioButtonGroup dementiaElderlyAccepted;

  private ACLabelContainer dementiaElderlyAcceptedContainer;

  private ACListModelAdapter dementiaElderlyAcceptedModel;

  private ACRadioButtonItem dementiaElderlyAcceptedItem1;

  private ACRadioButtonItem dementiaElderlyAcceptedItem2;

  private ACBackLabelContainer tsuusyoKaigoTimeContena;

  private ACTimeComboBox tsuusyoKaigoTimeBeginTime;

  private ACLabelContainer tsuusyoKaigoTimeBeginTimeContainer;

  private ACComboBoxModelAdapter tsuusyoKaigoTimeBeginTimeModel;

  private ACTimeComboBox tsuusyoKaigoTimeEndTime;

  private ACLabelContainer tsuusyoKaigoTimeEndTimeContainer;

  private ACComboBoxModelAdapter tsuusyoKaigoTimeEndTimeModel;

  private ACPanel tab2;

  private ACValueArrayRadioButtonGroup youngDementiaPatinetAddRadioGroup;

  private ACLabelContainer youngDementiaPatinetAddRadioGroupContainer;

  private ACListModelAdapter youngDementiaPatinetAddRadioGroupModel;

  private ACRadioButtonItem youngDementiaPatinetAddRadioItem1;

  private ACRadioButtonItem youngDementiaPatinetAddRadioItem2;

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

  private ACValueArrayRadioButtonGroup individualPickupSystem;

  private ACLabelContainer individualPickupSystemContainer;

  private ACListModelAdapter individualPickupSystemModel;

  private ACRadioButtonItem individualPickupSystemItem1;

  private ACRadioButtonItem individualPickupSystemItem2;

  private ACValueArrayRadioButtonGroup bathingAssistanceSystem;

  private ACLabelContainer bathingAssistanceSystemContainer;

  private ACListModelAdapter bathingAssistanceSystemModel;

  private ACRadioButtonItem bathingAssistanceSystemItem1;

  private ACRadioButtonItem bathingAssistanceSystemItem2;

  private ACValueArrayRadioButtonGroup transportationCallRadioGroup;

  private ACLabelContainer transportationCallRadioGroupContainer;

  private ACListModelAdapter transportationCallRadioGroupModel;

  private ACRadioButtonItem transportationCallRadioItem1;

  private ACRadioButtonItem transportationCallRadioItem2;

  private ACValueArrayRadioButtonGroup MeetingAndSendingOff;

  private ACLabelContainer MeetingAndSendingOffContainer;

  private ACListModelAdapter MeetingAndSendingOffModel;

  private ACRadioButtonItem MeetingAndSendingOffRoundTrip;

  private ACRadioButtonItem MeetingAndSendingOffOneWay;

  private ACRadioButtonItem MeetingAndSendingOffNone;

  private ACValueArrayRadioButtonGroup serviceAddProvisionStructuralRadioGroup;

  private ACLabelContainer serviceAddProvisionStructuralRadioGroupContainer;

  private ACListModelAdapter serviceAddProvisionStructuralRadioGroupModel;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem1;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem5;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem2;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem3;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem4;

  private ACValueArrayRadioButtonGroup improvementCollaboration;

  private ACLabelContainer improvementCollaborationContainer;

  private ACListModelAdapter improvementCollaborationModel;

  private ACRadioButtonItem improvementCollaborationItem1;

  private ACRadioButtonItem improvementCollaborationItem2;

  private ACValueArrayRadioButtonGroup adlMaintenanceRadioGroup;

  private ACLabelContainer adlMaintenanceRadioGroupContainer;

  private ACListModelAdapter adlMaintenanceRadioGroupModel;

  private ACRadioButtonItem adlMaintenanceItem1;

  private ACRadioButtonItem adlMaintenanceItem2;

  private ACRadioButtonItem adlMaintenanceItem3;

  private ACPanel tab3;

  private ACValueArrayRadioButtonGroup nutritionScreening;

  private ACLabelContainer nutritionScreeningContainer;

  private ACListModelAdapter nutritionScreeningModel;

  private ACRadioButtonItem nutritionScreeningItem1;

  private ACRadioButtonItem nutritionScreeningItem2;

  private ACValueArrayRadioButtonGroup symbiosisTypeRadio;

  private ACLabelContainer symbiosisTypeRadioContainer;

  private ACListModelAdapter symbiosisTypeRadioModel;

  private ACRadioButtonItem symbiosisTypeRadioItem1;

  private ACRadioButtonItem symbiosisTypeRadioItem2;

  private ACRadioButtonItem symbiosisTypeRadioItem3;

  private ACRadioButtonItem symbiosisTypeRadioItem4;

  private ACRadioButtonItem symbiosisTypeRadioItem5;

  private ACValueArrayRadioButtonGroup deploymentLifeCounselor;

  private ACLabelContainer deploymentLifeCounselorContainer;

  private ACListModelAdapter deploymentLifeCounselorModel;

  private ACRadioButtonItem deploymentLifeCounselorItem1;

  private ACRadioButtonItem deploymentLifeCounselorItem2;

  //getter

  /**
   * �n�斧���^�ʏ����p�^�[���̈���擾���܂��B
   * @return �n�斧���^�ʏ����p�^�[���̈�
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

      tsuusyoKaigoTimeContenaFacilityDivision.setBindPath("1780101");

      tsuusyoKaigoTimeContenaFacilityDivision.setNoSelectIndex(0);

      tsuusyoKaigoTimeContenaFacilityDivision.setUseClearButton(false);

      tsuusyoKaigoTimeContenaFacilityDivision.setModel(getTsuusyoKaigoTimeContenaFacilityDivisionModel());

      tsuusyoKaigoTimeContenaFacilityDivision.setValues(new int[]{1,2});

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
   * �n�斧���^�ʏ������擾���܂��B
   * @return �n�斧���^�ʏ����
   */
  public ACRadioButtonItem getTsuusyoKaigoTimeContenaFacilityDivisionItem1(){
    if(tsuusyoKaigoTimeContenaFacilityDivisionItem1==null){

      tsuusyoKaigoTimeContenaFacilityDivisionItem1 = new ACRadioButtonItem();

      tsuusyoKaigoTimeContenaFacilityDivisionItem1.setText("�n�斧���^�ʏ����");

      tsuusyoKaigoTimeContenaFacilityDivisionItem1.setGroup(getTsuusyoKaigoTimeContenaFacilityDivision());

      tsuusyoKaigoTimeContenaFacilityDivisionItem1.setConstraints(VRLayout.FLOW_RETURN);

      addTsuusyoKaigoTimeContenaFacilityDivisionItem1();
    }
    return tsuusyoKaigoTimeContenaFacilityDivisionItem1;

  }

  /**
   * �×{�ʏ������擾���܂��B
   * @return �×{�ʏ����
   */
  public ACRadioButtonItem getTsuusyoKaigoTimeContenaFacilityDivisionItem2(){
    if(tsuusyoKaigoTimeContenaFacilityDivisionItem2==null){

      tsuusyoKaigoTimeContenaFacilityDivisionItem2 = new ACRadioButtonItem();

      tsuusyoKaigoTimeContenaFacilityDivisionItem2.setText("�×{�ʏ����");

      tsuusyoKaigoTimeContenaFacilityDivisionItem2.setGroup(getTsuusyoKaigoTimeContenaFacilityDivision());

      tsuusyoKaigoTimeContenaFacilityDivisionItem2.setConstraints(VRLayout.FLOW);

      addTsuusyoKaigoTimeContenaFacilityDivisionItem2();
    }
    return tsuusyoKaigoTimeContenaFacilityDivisionItem2;

  }

  /**
   * ���ԋ敪���擾���܂��B
   * @return ���ԋ敪
   */
  public ACComboBox getTsuusyoKaigoTimeDivision(){
    if(tsuusyoKaigoTimeDivision==null){

      tsuusyoKaigoTimeDivision = new ACComboBox();

      getTsuusyoKaigoTimeDivisionContainer().setText("���ԋ敪");

      tsuusyoKaigoTimeDivision.setBindPath("1780102");

      tsuusyoKaigoTimeDivision.setEditable(false);

      tsuusyoKaigoTimeDivision.setModelBindPath("1780102");

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
   * �l�����Z���擾���܂��B
   * @return �l�����Z
   */
  public ACValueArrayRadioButtonGroup getTsuusyoKaigoSubtraction(){
    if(tsuusyoKaigoSubtraction==null){

      tsuusyoKaigoSubtraction = new ACValueArrayRadioButtonGroup();

      getTsuusyoKaigoSubtractionContainer().setText("�l�����Z");

      tsuusyoKaigoSubtraction.setBindPath("1780103");

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
   * �������Z���擾���܂��B
   * @return �������Z
   */
  public ACValueArrayRadioButtonGroup getTsuusyoKaigoAdditionFunctionBathRadio(){
    if(tsuusyoKaigoAdditionFunctionBathRadio==null){

      tsuusyoKaigoAdditionFunctionBathRadio = new ACValueArrayRadioButtonGroup();

      getTsuusyoKaigoAdditionFunctionBathRadioContainer().setText("�������Z");

      tsuusyoKaigoAdditionFunctionBathRadio.setBindPath("1780104");

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
   * ���d�x�҃P�A�̐����Z���W�I�O���[�v���擾���܂��B
   * @return ���d�x�҃P�A�̐����Z���W�I�O���[�v
   */
  public ACValueArrayRadioButtonGroup getSevereCareRecipientsAccepted(){
    if(severeCareRecipientsAccepted==null){

      severeCareRecipientsAccepted = new ACValueArrayRadioButtonGroup();

      getSevereCareRecipientsAcceptedContainer().setText("���d�x�҃P�A�̐����Z");

      severeCareRecipientsAccepted.setBindPath("1780105");

      severeCareRecipientsAccepted.setUseClearButton(false);

      severeCareRecipientsAccepted.setModel(getSevereCareRecipientsAcceptedModel());

      severeCareRecipientsAccepted.setValues(new int[]{1,2});

      addSevereCareRecipientsAccepted();
    }
    return severeCareRecipientsAccepted;

  }

  /**
   * ���d�x�҃P�A�̐����Z���W�I�O���[�v�R���e�i���擾���܂��B
   * @return ���d�x�҃P�A�̐����Z���W�I�O���[�v�R���e�i
   */
  protected ACLabelContainer getSevereCareRecipientsAcceptedContainer(){
    if(severeCareRecipientsAcceptedContainer==null){
      severeCareRecipientsAcceptedContainer = new ACLabelContainer();
      severeCareRecipientsAcceptedContainer.setFollowChildEnabled(true);
      severeCareRecipientsAcceptedContainer.setVAlignment(VRLayout.CENTER);
      severeCareRecipientsAcceptedContainer.add(getSevereCareRecipientsAccepted(), null);
    }
    return severeCareRecipientsAcceptedContainer;
  }

  /**
   * ���d�x�҃P�A�̐����Z���W�I�O���[�v���f�����擾���܂��B
   * @return ���d�x�҃P�A�̐����Z���W�I�O���[�v���f��
   */
  protected ACListModelAdapter getSevereCareRecipientsAcceptedModel(){
    if(severeCareRecipientsAcceptedModel==null){
      severeCareRecipientsAcceptedModel = new ACListModelAdapter();
      addSevereCareRecipientsAcceptedModel();
    }
    return severeCareRecipientsAcceptedModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getSevereCareRecipientsAcceptedItem1(){
    if(severeCareRecipientsAcceptedItem1==null){

      severeCareRecipientsAcceptedItem1 = new ACRadioButtonItem();

      severeCareRecipientsAcceptedItem1.setText("�Ȃ�");

      severeCareRecipientsAcceptedItem1.setGroup(getSevereCareRecipientsAccepted());

      severeCareRecipientsAcceptedItem1.setConstraints(VRLayout.FLOW);

      addSevereCareRecipientsAcceptedItem1();
    }
    return severeCareRecipientsAcceptedItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getSevereCareRecipientsAcceptedItem2(){
    if(severeCareRecipientsAcceptedItem2==null){

      severeCareRecipientsAcceptedItem2 = new ACRadioButtonItem();

      severeCareRecipientsAcceptedItem2.setText("����");

      severeCareRecipientsAcceptedItem2.setGroup(getSevereCareRecipientsAccepted());

      severeCareRecipientsAcceptedItem2.setConstraints(VRLayout.FLOW);

      addSevereCareRecipientsAcceptedItem2();
    }
    return severeCareRecipientsAcceptedItem2;

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

      tsuusyoKaigoAdditionFunctionTrainingRadioItem1.setBindPath("1780106");

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

      tsuusyoKaigoAdditionFunctionTrainingRadioItem2.setBindPath("1780107");

      tsuusyoKaigoAdditionFunctionTrainingRadioItem2.setSelectValue(2);

      tsuusyoKaigoAdditionFunctionTrainingRadioItem2.setUnSelectValue(1);

      addTsuusyoKaigoAdditionFunctionTrainingRadioItem2();
    }
    return tsuusyoKaigoAdditionFunctionTrainingRadioItem2;

  }

  /**
   * �F�m�ǉ��Z���W�I�O���[�v���擾���܂��B
   * @return �F�m�ǉ��Z���W�I�O���[�v
   */
  public ACValueArrayRadioButtonGroup getDementiaElderlyAccepted(){
    if(dementiaElderlyAccepted==null){

      dementiaElderlyAccepted = new ACValueArrayRadioButtonGroup();

      getDementiaElderlyAcceptedContainer().setText("�F�m�ǉ��Z");

      dementiaElderlyAccepted.setBindPath("1780108");

      dementiaElderlyAccepted.setUseClearButton(false);

      dementiaElderlyAccepted.setModel(getDementiaElderlyAcceptedModel());

      dementiaElderlyAccepted.setValues(new int[]{1,2});

      addDementiaElderlyAccepted();
    }
    return dementiaElderlyAccepted;

  }

  /**
   * �F�m�ǉ��Z���W�I�O���[�v�R���e�i���擾���܂��B
   * @return �F�m�ǉ��Z���W�I�O���[�v�R���e�i
   */
  protected ACLabelContainer getDementiaElderlyAcceptedContainer(){
    if(dementiaElderlyAcceptedContainer==null){
      dementiaElderlyAcceptedContainer = new ACLabelContainer();
      dementiaElderlyAcceptedContainer.setFollowChildEnabled(true);
      dementiaElderlyAcceptedContainer.setVAlignment(VRLayout.CENTER);
      dementiaElderlyAcceptedContainer.add(getDementiaElderlyAccepted(), null);
    }
    return dementiaElderlyAcceptedContainer;
  }

  /**
   * �F�m�ǉ��Z���W�I�O���[�v���f�����擾���܂��B
   * @return �F�m�ǉ��Z���W�I�O���[�v���f��
   */
  protected ACListModelAdapter getDementiaElderlyAcceptedModel(){
    if(dementiaElderlyAcceptedModel==null){
      dementiaElderlyAcceptedModel = new ACListModelAdapter();
      addDementiaElderlyAcceptedModel();
    }
    return dementiaElderlyAcceptedModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getDementiaElderlyAcceptedItem1(){
    if(dementiaElderlyAcceptedItem1==null){

      dementiaElderlyAcceptedItem1 = new ACRadioButtonItem();

      dementiaElderlyAcceptedItem1.setText("�Ȃ�");

      dementiaElderlyAcceptedItem1.setGroup(getDementiaElderlyAccepted());

      dementiaElderlyAcceptedItem1.setConstraints(VRLayout.FLOW);

      addDementiaElderlyAcceptedItem1();
    }
    return dementiaElderlyAcceptedItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getDementiaElderlyAcceptedItem2(){
    if(dementiaElderlyAcceptedItem2==null){

      dementiaElderlyAcceptedItem2 = new ACRadioButtonItem();

      dementiaElderlyAcceptedItem2.setText("����");

      dementiaElderlyAcceptedItem2.setGroup(getDementiaElderlyAccepted());

      dementiaElderlyAcceptedItem2.setConstraints(VRLayout.FLOW);

      addDementiaElderlyAcceptedItem2();
    }
    return dementiaElderlyAcceptedItem2;

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
   * ��N���F�m�Ǘ��p�Ҏ�����Z���擾���܂��B
   * @return ��N���F�m�Ǘ��p�Ҏ�����Z
   */
  public ACValueArrayRadioButtonGroup getYoungDementiaPatinetAddRadioGroup(){
    if(youngDementiaPatinetAddRadioGroup==null){

      youngDementiaPatinetAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getYoungDementiaPatinetAddRadioGroupContainer().setText("��N���F�m�Ǘ��p�Ҏ�����Z");

      youngDementiaPatinetAddRadioGroup.setBindPath("1780109");

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
   * �h�{���P���Z���擾���܂��B
   * @return �h�{���P���Z
   */
  public ACValueArrayRadioButtonGroup getTsuusyoKaigoNourishmentManagementAddRadio(){
    if(tsuusyoKaigoNourishmentManagementAddRadio==null){

      tsuusyoKaigoNourishmentManagementAddRadio = new ACValueArrayRadioButtonGroup();

      getTsuusyoKaigoNourishmentManagementAddRadioContainer().setText("�h�{���P���Z");

      tsuusyoKaigoNourishmentManagementAddRadio.setBindPath("1780110");

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

      tsuusyoKaigoMouthFunctionAddRadio.setBindPath("1780111");

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
   * �ʑ��}�̐��������Z���擾���܂��B
   * @return �ʑ��}�̐��������Z
   */
  public ACValueArrayRadioButtonGroup getIndividualPickupSystem(){
    if(individualPickupSystem==null){

      individualPickupSystem = new ACValueArrayRadioButtonGroup();

      getIndividualPickupSystemContainer().setText("�ʑ��}�̐��������Z");

      individualPickupSystem.setBindPath("1780112");

      individualPickupSystem.setUseClearButton(false);

      individualPickupSystem.setModel(getIndividualPickupSystemModel());

      individualPickupSystem.setValues(new int[]{1,2});

      addIndividualPickupSystem();
    }
    return individualPickupSystem;

  }

  /**
   * �ʑ��}�̐��������Z�R���e�i���擾���܂��B
   * @return �ʑ��}�̐��������Z�R���e�i
   */
  protected ACLabelContainer getIndividualPickupSystemContainer(){
    if(individualPickupSystemContainer==null){
      individualPickupSystemContainer = new ACLabelContainer();
      individualPickupSystemContainer.setFollowChildEnabled(true);
      individualPickupSystemContainer.setVAlignment(VRLayout.CENTER);
      individualPickupSystemContainer.add(getIndividualPickupSystem(), null);
    }
    return individualPickupSystemContainer;
  }

  /**
   * �ʑ��}�̐��������Z���f�����擾���܂��B
   * @return �ʑ��}�̐��������Z���f��
   */
  protected ACListModelAdapter getIndividualPickupSystemModel(){
    if(individualPickupSystemModel==null){
      individualPickupSystemModel = new ACListModelAdapter();
      addIndividualPickupSystemModel();
    }
    return individualPickupSystemModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getIndividualPickupSystemItem1(){
    if(individualPickupSystemItem1==null){

      individualPickupSystemItem1 = new ACRadioButtonItem();

      individualPickupSystemItem1.setText("�Ȃ�");

      individualPickupSystemItem1.setGroup(getIndividualPickupSystem());

      addIndividualPickupSystemItem1();
    }
    return individualPickupSystemItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getIndividualPickupSystemItem2(){
    if(individualPickupSystemItem2==null){

      individualPickupSystemItem2 = new ACRadioButtonItem();

      individualPickupSystemItem2.setText("����");

      individualPickupSystemItem2.setGroup(getIndividualPickupSystem());

      addIndividualPickupSystemItem2();
    }
    return individualPickupSystemItem2;

  }

  /**
   * ������̐��������Z���擾���܂��B
   * @return ������̐��������Z
   */
  public ACValueArrayRadioButtonGroup getBathingAssistanceSystem(){
    if(bathingAssistanceSystem==null){

      bathingAssistanceSystem = new ACValueArrayRadioButtonGroup();

      getBathingAssistanceSystemContainer().setText("������̐��������Z");

      bathingAssistanceSystem.setBindPath("1780113");

      bathingAssistanceSystem.setUseClearButton(false);

      bathingAssistanceSystem.setModel(getBathingAssistanceSystemModel());

      bathingAssistanceSystem.setValues(new int[]{1,2});

      addBathingAssistanceSystem();
    }
    return bathingAssistanceSystem;

  }

  /**
   * ������̐��������Z�R���e�i���擾���܂��B
   * @return ������̐��������Z�R���e�i
   */
  protected ACLabelContainer getBathingAssistanceSystemContainer(){
    if(bathingAssistanceSystemContainer==null){
      bathingAssistanceSystemContainer = new ACLabelContainer();
      bathingAssistanceSystemContainer.setFollowChildEnabled(true);
      bathingAssistanceSystemContainer.setVAlignment(VRLayout.CENTER);
      bathingAssistanceSystemContainer.add(getBathingAssistanceSystem(), null);
    }
    return bathingAssistanceSystemContainer;
  }

  /**
   * ������̐��������Z���f�����擾���܂��B
   * @return ������̐��������Z���f��
   */
  protected ACListModelAdapter getBathingAssistanceSystemModel(){
    if(bathingAssistanceSystemModel==null){
      bathingAssistanceSystemModel = new ACListModelAdapter();
      addBathingAssistanceSystemModel();
    }
    return bathingAssistanceSystemModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getBathingAssistanceSystemItem1(){
    if(bathingAssistanceSystemItem1==null){

      bathingAssistanceSystemItem1 = new ACRadioButtonItem();

      bathingAssistanceSystemItem1.setText("�Ȃ�");

      bathingAssistanceSystemItem1.setGroup(getBathingAssistanceSystem());

      bathingAssistanceSystemItem1.setConstraints(VRLayout.FLOW);

      addBathingAssistanceSystemItem1();
    }
    return bathingAssistanceSystemItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getBathingAssistanceSystemItem2(){
    if(bathingAssistanceSystemItem2==null){

      bathingAssistanceSystemItem2 = new ACRadioButtonItem();

      bathingAssistanceSystemItem2.setText("����");

      bathingAssistanceSystemItem2.setGroup(getBathingAssistanceSystem());

      bathingAssistanceSystemItem2.setConstraints(VRLayout.FLOW);

      addBathingAssistanceSystemItem2();
    }
    return bathingAssistanceSystemItem2;

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
   * ���}�敪���擾���܂��B
   * @return ���}�敪
   */
  public ACValueArrayRadioButtonGroup getMeetingAndSendingOff(){
    if(MeetingAndSendingOff==null){

      MeetingAndSendingOff = new ACValueArrayRadioButtonGroup();

      getMeetingAndSendingOffContainer().setText("���}���Z");

      MeetingAndSendingOff.setBindPath("18");

      MeetingAndSendingOff.setUseClearButton(false);

      MeetingAndSendingOff.setModel(getMeetingAndSendingOffModel());

      MeetingAndSendingOff.setValues(new int[]{1,2,3});

      addMeetingAndSendingOff();
    }
    return MeetingAndSendingOff;

  }

  /**
   * ���}�敪�R���e�i���擾���܂��B
   * @return ���}�敪�R���e�i
   */
  protected ACLabelContainer getMeetingAndSendingOffContainer(){
    if(MeetingAndSendingOffContainer==null){
      MeetingAndSendingOffContainer = new ACLabelContainer();
      MeetingAndSendingOffContainer.setFollowChildEnabled(true);
      MeetingAndSendingOffContainer.setVAlignment(VRLayout.CENTER);
      MeetingAndSendingOffContainer.add(getMeetingAndSendingOff(), null);
    }
    return MeetingAndSendingOffContainer;
  }

  /**
   * ���}�敪���f�����擾���܂��B
   * @return ���}�敪���f��
   */
  protected ACListModelAdapter getMeetingAndSendingOffModel(){
    if(MeetingAndSendingOffModel==null){
      MeetingAndSendingOffModel = new ACListModelAdapter();
      addMeetingAndSendingOffModel();
    }
    return MeetingAndSendingOffModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getMeetingAndSendingOffRoundTrip(){
    if(MeetingAndSendingOffRoundTrip==null){

      MeetingAndSendingOffRoundTrip = new ACRadioButtonItem();

      MeetingAndSendingOffRoundTrip.setText("�Ȃ�");

      MeetingAndSendingOffRoundTrip.setGroup(getMeetingAndSendingOff());

      MeetingAndSendingOffRoundTrip.setConstraints(VRLayout.FLOW);

      addMeetingAndSendingOffRoundTrip();
    }
    return MeetingAndSendingOffRoundTrip;

  }

  /**
   * �Г����Z���擾���܂��B
   * @return �Г����Z
   */
  public ACRadioButtonItem getMeetingAndSendingOffOneWay(){
    if(MeetingAndSendingOffOneWay==null){

      MeetingAndSendingOffOneWay = new ACRadioButtonItem();

      MeetingAndSendingOffOneWay.setText("�Г����Z");

      MeetingAndSendingOffOneWay.setGroup(getMeetingAndSendingOff());

      MeetingAndSendingOffOneWay.setConstraints(VRLayout.FLOW);

      addMeetingAndSendingOffOneWay();
    }
    return MeetingAndSendingOffOneWay;

  }

  /**
   * �������Z���擾���܂��B
   * @return �������Z
   */
  public ACRadioButtonItem getMeetingAndSendingOffNone(){
    if(MeetingAndSendingOffNone==null){

      MeetingAndSendingOffNone = new ACRadioButtonItem();

      MeetingAndSendingOffNone.setText("�������Z");

      MeetingAndSendingOffNone.setGroup(getMeetingAndSendingOff());

      MeetingAndSendingOffNone.setConstraints(VRLayout.FLOW);

      addMeetingAndSendingOffNone();
    }
    return MeetingAndSendingOffNone;

  }

  /**
   * �T�[�r�X�񋟑̐��������Z���擾���܂��B
   * @return �T�[�r�X�񋟑̐��������Z
   */
  public ACValueArrayRadioButtonGroup getServiceAddProvisionStructuralRadioGroup(){
    if(serviceAddProvisionStructuralRadioGroup==null){

      serviceAddProvisionStructuralRadioGroup = new ACValueArrayRadioButtonGroup();

      getServiceAddProvisionStructuralRadioGroupContainer().setText("�T�[�r�X�񋟑̐��������Z");

      serviceAddProvisionStructuralRadioGroup.setBindPath("1780114");

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
   * �����@�\����A�g���Z���擾���܂��B
   * @return �����@�\����A�g���Z
   */
  public ACValueArrayRadioButtonGroup getImprovementCollaboration(){
    if(improvementCollaboration==null){

      improvementCollaboration = new ACValueArrayRadioButtonGroup();

      getImprovementCollaborationContainer().setText("�����@�\����A�g���Z");

      improvementCollaboration.setBindPath("1780116");

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
   * ADL�ێ������Z���擾���܂��B
   * @return ADL�ێ������Z
   */
  public ACValueArrayRadioButtonGroup getAdlMaintenanceRadioGroup(){
    if(adlMaintenanceRadioGroup==null){

      adlMaintenanceRadioGroup = new ACValueArrayRadioButtonGroup();

      getAdlMaintenanceRadioGroupContainer().setText("ADL�ێ������Z");

      adlMaintenanceRadioGroup.setBindPath("1780117");

      adlMaintenanceRadioGroup.setNoSelectIndex(0);

      adlMaintenanceRadioGroup.setUseClearButton(false);

      adlMaintenanceRadioGroup.setModel(getAdlMaintenanceRadioGroupModel());

      adlMaintenanceRadioGroup.setValues(new int[]{1,2,3});

      addAdlMaintenanceRadioGroup();
    }
    return adlMaintenanceRadioGroup;

  }

  /**
   * ADL�ێ������Z�R���e�i���擾���܂��B
   * @return ADL�ێ������Z�R���e�i
   */
  protected ACLabelContainer getAdlMaintenanceRadioGroupContainer(){
    if(adlMaintenanceRadioGroupContainer==null){
      adlMaintenanceRadioGroupContainer = new ACLabelContainer();
      adlMaintenanceRadioGroupContainer.setFollowChildEnabled(true);
      adlMaintenanceRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      adlMaintenanceRadioGroupContainer.add(getAdlMaintenanceRadioGroup(), null);
    }
    return adlMaintenanceRadioGroupContainer;
  }

  /**
   * ADL�ێ������Z���f�����擾���܂��B
   * @return ADL�ێ������Z���f��
   */
  protected ACListModelAdapter getAdlMaintenanceRadioGroupModel(){
    if(adlMaintenanceRadioGroupModel==null){
      adlMaintenanceRadioGroupModel = new ACListModelAdapter();
      addAdlMaintenanceRadioGroupModel();
    }
    return adlMaintenanceRadioGroupModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getAdlMaintenanceItem1(){
    if(adlMaintenanceItem1==null){

      adlMaintenanceItem1 = new ACRadioButtonItem();

      adlMaintenanceItem1.setText("�Ȃ�");

      adlMaintenanceItem1.setGroup(getAdlMaintenanceRadioGroup());

      adlMaintenanceItem1.setConstraints(VRLayout.FLOW);

      addAdlMaintenanceItem1();
    }
    return adlMaintenanceItem1;

  }

  /**
   * I�^���擾���܂��B
   * @return I�^
   */
  public ACRadioButtonItem getAdlMaintenanceItem2(){
    if(adlMaintenanceItem2==null){

      adlMaintenanceItem2 = new ACRadioButtonItem();

      adlMaintenanceItem2.setText("I�^");

      adlMaintenanceItem2.setGroup(getAdlMaintenanceRadioGroup());

      adlMaintenanceItem2.setConstraints(VRLayout.FLOW);

      addAdlMaintenanceItem2();
    }
    return adlMaintenanceItem2;

  }

  /**
   * II�^���擾���܂��B
   * @return II�^
   */
  public ACRadioButtonItem getAdlMaintenanceItem3(){
    if(adlMaintenanceItem3==null){

      adlMaintenanceItem3 = new ACRadioButtonItem();

      adlMaintenanceItem3.setText("II�^");

      adlMaintenanceItem3.setGroup(getAdlMaintenanceRadioGroup());

      adlMaintenanceItem3.setConstraints(VRLayout.FLOW);

      addAdlMaintenanceItem3();
    }
    return adlMaintenanceItem3;

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
   * �h�{�X�N���[�j���O���Z���擾���܂��B
   * @return �h�{�X�N���[�j���O���Z
   */
  public ACValueArrayRadioButtonGroup getNutritionScreening(){
    if(nutritionScreening==null){

      nutritionScreening = new ACValueArrayRadioButtonGroup();

      getNutritionScreeningContainer().setText("�h�{�X�N���[�j���O���Z");

      nutritionScreening.setBindPath("1780118");

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
   * �����^���擾���܂��B
   * @return �����^
   */
  public ACValueArrayRadioButtonGroup getSymbiosisTypeRadio(){
    if(symbiosisTypeRadio==null){

      symbiosisTypeRadio = new ACValueArrayRadioButtonGroup();

      getSymbiosisTypeRadioContainer().setText("�����^");

      symbiosisTypeRadio.setBindPath("22");

      symbiosisTypeRadio.setNoSelectIndex(0);

      symbiosisTypeRadio.setUseClearButton(false);

      symbiosisTypeRadio.setModel(getSymbiosisTypeRadioModel());

      symbiosisTypeRadio.setValues(new int[]{1,5,6,7,8});

      addSymbiosisTypeRadio();
    }
    return symbiosisTypeRadio;

  }

  /**
   * �����^�R���e�i���擾���܂��B
   * @return �����^�R���e�i
   */
  protected ACLabelContainer getSymbiosisTypeRadioContainer(){
    if(symbiosisTypeRadioContainer==null){
      symbiosisTypeRadioContainer = new ACLabelContainer();
      symbiosisTypeRadioContainer.setFollowChildEnabled(true);
      symbiosisTypeRadioContainer.setVAlignment(VRLayout.CENTER);
      symbiosisTypeRadioContainer.add(getSymbiosisTypeRadio(), null);
    }
    return symbiosisTypeRadioContainer;
  }

  /**
   * �����^���f�����擾���܂��B
   * @return �����^���f��
   */
  protected ACListModelAdapter getSymbiosisTypeRadioModel(){
    if(symbiosisTypeRadioModel==null){
      symbiosisTypeRadioModel = new ACListModelAdapter();
      addSymbiosisTypeRadioModel();
    }
    return symbiosisTypeRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getSymbiosisTypeRadioItem1(){
    if(symbiosisTypeRadioItem1==null){

      symbiosisTypeRadioItem1 = new ACRadioButtonItem();

      symbiosisTypeRadioItem1.setText("�Ȃ�");

      symbiosisTypeRadioItem1.setGroup(getSymbiosisTypeRadio());

      symbiosisTypeRadioItem1.setConstraints(VRLayout.FLOW);

      addSymbiosisTypeRadioItem1();
    }
    return symbiosisTypeRadioItem1;

  }

  /**
   * ���������擾���܂��B
   * @return �������
   */
  public ACRadioButtonItem getSymbiosisTypeRadioItem2(){
    if(symbiosisTypeRadioItem2==null){

      symbiosisTypeRadioItem2 = new ACRadioButtonItem();

      symbiosisTypeRadioItem2.setText("�������");

      symbiosisTypeRadioItem2.setGroup(getSymbiosisTypeRadio());

      symbiosisTypeRadioItem2.setConstraints(VRLayout.FLOW);

      addSymbiosisTypeRadioItem2();
    }
    return symbiosisTypeRadioItem2;

  }

  /**
   * �����P�����擾���܂��B
   * @return �����P��
   */
  public ACRadioButtonItem getSymbiosisTypeRadioItem3(){
    if(symbiosisTypeRadioItem3==null){

      symbiosisTypeRadioItem3 = new ACRadioButtonItem();

      symbiosisTypeRadioItem3.setText("�����P��");

      symbiosisTypeRadioItem3.setGroup(getSymbiosisTypeRadio());

      symbiosisTypeRadioItem3.setConstraints(VRLayout.FLOW_RETURN);

      addSymbiosisTypeRadioItem3();
    }
    return symbiosisTypeRadioItem3;

  }

  /**
   * �������B�x�����擾���܂��B
   * @return �������B�x��
   */
  public ACRadioButtonItem getSymbiosisTypeRadioItem4(){
    if(symbiosisTypeRadioItem4==null){

      symbiosisTypeRadioItem4 = new ACRadioButtonItem();

      symbiosisTypeRadioItem4.setText("�������B�x��");

      symbiosisTypeRadioItem4.setGroup(getSymbiosisTypeRadio());

      symbiosisTypeRadioItem4.setConstraints(VRLayout.FLOW);

      addSymbiosisTypeRadioItem4();
    }
    return symbiosisTypeRadioItem4;

  }

  /**
   * ���ی㓙�f�C���擾���܂��B
   * @return ���ی㓙�f�C
   */
  public ACRadioButtonItem getSymbiosisTypeRadioItem5(){
    if(symbiosisTypeRadioItem5==null){

      symbiosisTypeRadioItem5 = new ACRadioButtonItem();

      symbiosisTypeRadioItem5.setText("���ی㓙�f�C");

      symbiosisTypeRadioItem5.setGroup(getSymbiosisTypeRadio());

      symbiosisTypeRadioItem5.setConstraints(VRLayout.FLOW);

      addSymbiosisTypeRadioItem5();
    }
    return symbiosisTypeRadioItem5;

  }

  /**
   * �������k���z�u�����Z���擾���܂��B
   * @return �������k���z�u�����Z
   */
  public ACValueArrayRadioButtonGroup getDeploymentLifeCounselor(){
    if(deploymentLifeCounselor==null){

      deploymentLifeCounselor = new ACValueArrayRadioButtonGroup();

      getDeploymentLifeCounselorContainer().setText("�������k���z�u�����Z");

      deploymentLifeCounselor.setBindPath("1780115");

      deploymentLifeCounselor.setUseClearButton(false);

      deploymentLifeCounselor.setModel(getDeploymentLifeCounselorModel());

      deploymentLifeCounselor.setValues(new int[]{1,2});

      addDeploymentLifeCounselor();
    }
    return deploymentLifeCounselor;

  }

  /**
   * �������k���z�u�����Z�R���e�i���擾���܂��B
   * @return �������k���z�u�����Z�R���e�i
   */
  protected ACLabelContainer getDeploymentLifeCounselorContainer(){
    if(deploymentLifeCounselorContainer==null){
      deploymentLifeCounselorContainer = new ACLabelContainer();
      deploymentLifeCounselorContainer.setFollowChildEnabled(true);
      deploymentLifeCounselorContainer.setVAlignment(VRLayout.CENTER);
      deploymentLifeCounselorContainer.add(getDeploymentLifeCounselor(), null);
    }
    return deploymentLifeCounselorContainer;
  }

  /**
   * �������k���z�u�����Z���f�����擾���܂��B
   * @return �������k���z�u�����Z���f��
   */
  protected ACListModelAdapter getDeploymentLifeCounselorModel(){
    if(deploymentLifeCounselorModel==null){
      deploymentLifeCounselorModel = new ACListModelAdapter();
      addDeploymentLifeCounselorModel();
    }
    return deploymentLifeCounselorModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getDeploymentLifeCounselorItem1(){
    if(deploymentLifeCounselorItem1==null){

      deploymentLifeCounselorItem1 = new ACRadioButtonItem();

      deploymentLifeCounselorItem1.setText("�Ȃ�");

      deploymentLifeCounselorItem1.setGroup(getDeploymentLifeCounselor());

      addDeploymentLifeCounselorItem1();
    }
    return deploymentLifeCounselorItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getDeploymentLifeCounselorItem2(){
    if(deploymentLifeCounselorItem2==null){

      deploymentLifeCounselorItem2 = new ACRadioButtonItem();

      deploymentLifeCounselorItem2.setText("����");

      deploymentLifeCounselorItem2.setGroup(getDeploymentLifeCounselor());

      addDeploymentLifeCounselorItem2();
    }
    return deploymentLifeCounselorItem2;

  }

  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001_17811_201804Design() {

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
   * �n�斧���^�ʏ����p�^�[���̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTsuusyoKaigoPatterns(){

    tsuusyoKaigoPatterns.addTab("1", getTab1());

    tsuusyoKaigoPatterns.addTab("2", getTab2());

    tsuusyoKaigoPatterns.addTab("3", getTab3());

  }

  /**
   * �^�u1�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTab1(){

    tab1.add(getTsuusyoKaigoFacilitiesDivisionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getTsuusyoKaigoTimeDivisionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getTsuusyoKaigoSubtractionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getProviderAddMountainousAreaRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getTsuusyoKaigoAdditionFunctionBathRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getSevereCareRecipientsAcceptedContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getTsuusyoKaigoAdditionFunctionTrainingRadio(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getDementiaElderlyAcceptedContainer(), VRLayout.FLOW_INSETLINE_RETURN);

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

  }

  /**
   * �n�斧���^�ʏ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addTsuusyoKaigoTimeContenaFacilityDivisionItem1(){

  }

  /**
   * �×{�ʏ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addTsuusyoKaigoTimeContenaFacilityDivisionItem2(){

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
   * ���d�x�҃P�A�̐����Z���W�I�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addSevereCareRecipientsAccepted(){

  }

  /**
   * ���d�x�҃P�A�̐����Z���W�I�O���[�v���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addSevereCareRecipientsAcceptedModel(){

    getSevereCareRecipientsAcceptedItem1().setButtonIndex(1);

    getSevereCareRecipientsAcceptedModel().add(getSevereCareRecipientsAcceptedItem1());

    getSevereCareRecipientsAcceptedItem2().setButtonIndex(2);

    getSevereCareRecipientsAcceptedModel().add(getSevereCareRecipientsAcceptedItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addSevereCareRecipientsAcceptedItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addSevereCareRecipientsAcceptedItem2(){

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
   * �F�m�ǉ��Z���W�I�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addDementiaElderlyAccepted(){

  }

  /**
   * �F�m�ǉ��Z���W�I�O���[�v���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addDementiaElderlyAcceptedModel(){

    getDementiaElderlyAcceptedItem1().setButtonIndex(1);

    getDementiaElderlyAcceptedModel().add(getDementiaElderlyAcceptedItem1());

    getDementiaElderlyAcceptedItem2().setButtonIndex(2);

    getDementiaElderlyAcceptedModel().add(getDementiaElderlyAcceptedItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addDementiaElderlyAcceptedItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addDementiaElderlyAcceptedItem2(){

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

    tab2.add(getYoungDementiaPatinetAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getTsuusyoKaigoNourishmentManagementAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getTsuusyoKaigoMouthFunctionAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getIndividualPickupSystemContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getBathingAssistanceSystemContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getTransportationCallRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getMeetingAndSendingOffContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getServiceAddProvisionStructuralRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getImprovementCollaborationContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getAdlMaintenanceRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

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
   * �ʑ��}�̐��������Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addIndividualPickupSystem(){

  }

  /**
   * �ʑ��}�̐��������Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addIndividualPickupSystemModel(){

    getIndividualPickupSystemItem1().setButtonIndex(1);

    getIndividualPickupSystemModel().add(getIndividualPickupSystemItem1());

    getIndividualPickupSystemItem2().setButtonIndex(2);

    getIndividualPickupSystemModel().add(getIndividualPickupSystemItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addIndividualPickupSystemItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addIndividualPickupSystemItem2(){

  }

  /**
   * ������̐��������Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addBathingAssistanceSystem(){

  }

  /**
   * ������̐��������Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addBathingAssistanceSystemModel(){

    getBathingAssistanceSystemItem1().setButtonIndex(1);

    getBathingAssistanceSystemModel().add(getBathingAssistanceSystemItem1());

    getBathingAssistanceSystemItem2().setButtonIndex(2);

    getBathingAssistanceSystemModel().add(getBathingAssistanceSystemItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addBathingAssistanceSystemItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addBathingAssistanceSystemItem2(){

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
   * ���}�敪�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMeetingAndSendingOff(){

  }

  /**
   * ���}�敪���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addMeetingAndSendingOffModel(){

    getMeetingAndSendingOffRoundTrip().setButtonIndex(1);

    getMeetingAndSendingOffModel().add(getMeetingAndSendingOffRoundTrip());

    getMeetingAndSendingOffOneWay().setButtonIndex(2);

    getMeetingAndSendingOffModel().add(getMeetingAndSendingOffOneWay());

    getMeetingAndSendingOffNone().setButtonIndex(3);

    getMeetingAndSendingOffModel().add(getMeetingAndSendingOffNone());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addMeetingAndSendingOffRoundTrip(){

  }

  /**
   * �Г����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMeetingAndSendingOffOneWay(){

  }

  /**
   * �������Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMeetingAndSendingOffNone(){

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

    getServiceAddProvisionStructuralRadioItem5().setButtonIndex(2);

    getServiceAddProvisionStructuralRadioGroupModel().add(getServiceAddProvisionStructuralRadioItem5());

    getServiceAddProvisionStructuralRadioItem2().setButtonIndex(3);

    getServiceAddProvisionStructuralRadioGroupModel().add(getServiceAddProvisionStructuralRadioItem2());

    getServiceAddProvisionStructuralRadioItem3().setButtonIndex(4);

    getServiceAddProvisionStructuralRadioGroupModel().add(getServiceAddProvisionStructuralRadioItem3());

    getServiceAddProvisionStructuralRadioItem4().setButtonIndex(5);

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
   * ADL�ێ������Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addAdlMaintenanceRadioGroup(){

  }

  /**
   * ADL�ێ������Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addAdlMaintenanceRadioGroupModel(){

    getAdlMaintenanceItem1().setButtonIndex(1);

    getAdlMaintenanceRadioGroupModel().add(getAdlMaintenanceItem1());

    getAdlMaintenanceItem2().setButtonIndex(2);

    getAdlMaintenanceRadioGroupModel().add(getAdlMaintenanceItem2());

    getAdlMaintenanceItem3().setButtonIndex(3);

    getAdlMaintenanceRadioGroupModel().add(getAdlMaintenanceItem3());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addAdlMaintenanceItem1(){

  }

  /**
   * I�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addAdlMaintenanceItem2(){

  }

  /**
   * II�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addAdlMaintenanceItem3(){

  }

  /**
   * �^�u3�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTab3(){

    tab3.add(getNutritionScreeningContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab3.add(getSymbiosisTypeRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab3.add(getDeploymentLifeCounselorContainer(), VRLayout.FLOW_INSETLINE_RETURN);

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
   * �����^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addSymbiosisTypeRadio(){

  }

  /**
   * �����^���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addSymbiosisTypeRadioModel(){

    getSymbiosisTypeRadioItem1().setButtonIndex(1);

    getSymbiosisTypeRadioModel().add(getSymbiosisTypeRadioItem1());

    getSymbiosisTypeRadioItem2().setButtonIndex(5);

    getSymbiosisTypeRadioModel().add(getSymbiosisTypeRadioItem2());

    getSymbiosisTypeRadioItem3().setButtonIndex(6);

    getSymbiosisTypeRadioModel().add(getSymbiosisTypeRadioItem3());

    getSymbiosisTypeRadioItem4().setButtonIndex(7);

    getSymbiosisTypeRadioModel().add(getSymbiosisTypeRadioItem4());

    getSymbiosisTypeRadioItem5().setButtonIndex(8);

    getSymbiosisTypeRadioModel().add(getSymbiosisTypeRadioItem5());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addSymbiosisTypeRadioItem1(){

  }

  /**
   * �������ɓ������ڂ�ǉ����܂��B
   */
  protected void addSymbiosisTypeRadioItem2(){

  }

  /**
   * �����P���ɓ������ڂ�ǉ����܂��B
   */
  protected void addSymbiosisTypeRadioItem3(){

  }

  /**
   * �������B�x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addSymbiosisTypeRadioItem4(){

  }

  /**
   * ���ی㓙�f�C�ɓ������ڂ�ǉ����܂��B
   */
  protected void addSymbiosisTypeRadioItem5(){

  }

  /**
   * �������k���z�u�����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addDeploymentLifeCounselor(){

  }

  /**
   * �������k���z�u�����Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addDeploymentLifeCounselorModel(){

    getDeploymentLifeCounselorItem1().setButtonIndex(1);

    getDeploymentLifeCounselorModel().add(getDeploymentLifeCounselorItem1());

    getDeploymentLifeCounselorItem2().setButtonIndex(2);

    getDeploymentLifeCounselorModel().add(getDeploymentLifeCounselorItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addDeploymentLifeCounselorItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addDeploymentLifeCounselorItem2(){

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
      ACFrame.debugStart(new ACAffairInfo(QS001_17811_201804Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QS001_17811_201804Design getThis() {
    return this;
  }
}
