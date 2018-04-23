
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
 * �쐬��: 2018/02/27  ���{�R���s���[�^�[������� ����@��F �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �\��Ǘ� (S)
 * �v���Z�X ���p�҈ꗗ�i�T�[�r�X�\��쐬/�ύX�j (001)
 * �v���O���� �T�[�r�X�p�^�[���ʏ����n (QS001_11611_201804)
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
 * �T�[�r�X�p�^�[���ʏ����n��ʍ��ڃf�U�C��(QS001_11611_201804) 
 */
public class QS001_11611_201804Design extends QS001ServicePanel {
  //GUI�R���|�[�l���g

  private JTabbedPane tabs;

  private ACPanel tab1;

  private ACValueArrayRadioButtonGroup facilityDivisionRadioGroup;

  private ACLabelContainer facilityDivisionRadioGroupContainer;

  private ACListModelAdapter facilityDivisionRadioGroupModel;

  private ACRadioButtonItem facilityDivisionRadioItem1;

  private ACRadioButtonItem facilityDivisionRadioItem2;

  private ACRadioButtonItem facilityDivisionRadioItem3;

  private ACRadioButtonItem facilityDivisionRadioItem4;

  private ACRadioButtonItem facilityDivisionRadioItem5;

  private ACRadioButtonItem facilityDivisionRadioItem6;

  private ACRadioButtonItem facilityDivisionRadioItem7;

  private ACRadioButtonItem facilityDivisionRadioItem8;

  private ACRadioButtonItem facilityDivisionRadioItem9;

  private ACComboBox houmonRehabilitationTimeDivision;

  private ACLabelContainer houmonRehabilitationTimeDivisionContainer;

  private ACComboBoxModelAdapter houmonRehabilitationTimeDivisionModel;

  private ACBackLabelContainer houmonRehabilitationTimeContena;

  private ACTimeComboBox houmonRehabilitationTimeContenaBeginTime;

  private ACLabelContainer houmonRehabilitationTimeContenaBeginTimeContainer;

  private ACComboBoxModelAdapter houmonRehabilitationTimeContenaBeginTimeModel;

  private ACTimeComboBox houmonRehabilitationTimeContenaEndTime;

  private ACLabelContainer houmonRehabilitationTimeContenaEndTimeContainer;

  private ACComboBoxModelAdapter houmonRehabilitationTimeContenaEndTimeModel;

  private ACPanel tab2;

  private ACValueArrayRadioButtonGroup houmonRehabilitationSubtraction;

  private ACLabelContainer houmonRehabilitationSubtractionContainer;

  private ACListModelAdapter houmonRehabilitationSubtractionModel;

  private ACRadioButtonItem houmonRehabilitationSubtractionNot;

  private ACRadioButtonItem houmonRehabilitationSubtractionExcess;

  private ACRadioButtonItem houmonRehabilitationSubtractionLack;

  private ACValueArrayRadioButtonGroup houmonRehabilitationBathRadio;

  private ACLabelContainer houmonRehabilitationBathRadioContainer;

  private ACListModelAdapter houmonRehabilitationBathRadioModel;

  private ACRadioButtonItem houmonRehabilitationBathRadioItem1;

  private ACRadioButtonItem houmonRehabilitationBathRadioItem2;

  private ACValueArrayRadioButtonGroup houmonRehabilitationManagementAddRadio;

  private ACLabelContainer houmonRehabilitationManagementAddRadioContainer;

  private ACListModelAdapter houmonRehabilitationManagementAddRadioModel;

  private ACRadioButtonItem houmonRehabilitationManagementAddRadioItem1;

  private ACRadioButtonItem houmonRehabilitationManagementAddRadioItem2;

  private ACRadioButtonItem houmonRehabilitationManagementAddRadioItem3;

  private ACRadioButtonItem houmonRehabilitationManagementAddRadioItem4;

  private ACRadioButtonItem houmonRehabilitationManagementAddRadioItem5;

  private ACRadioButtonItem houmonRehabilitationManagementAddRadioItem6;

  private ACRadioButtonItem houmonRehabilitationManagementAddRadioItem7;

  private ACRadioButtonItem houmonRehabilitationManagementAddRadioItem8;

  private ACValueArrayRadioButtonGroup houmonRehabilitationShortConcentrationAddRadio;

  private ACLabelContainer houmonRehabilitationShortConcentrationAddRadioContainer;

  private ACListModelAdapter houmonRehabilitationShortConcentrationAddRadioModel;

  private ACRadioButtonItem houmonRehabilitationShortConcentrationAddRadioItem1;

  private ACRadioButtonItem houmonRehabilitationShortConcentrationAddRadioItem2;

  private ACValueArrayRadioButtonGroup physiotherapistStrengthenedAddRadioGroup;

  private ACLabelContainer physiotherapistStrengthenedAddRadioGroupContainer;

  private ACListModelAdapter physiotherapistStrengthenedAddRadioGroupModel;

  private ACRadioButtonItem physiotherapistStrengthenedAddRadioItem1;

  private ACRadioButtonItem physiotherapistStrengthenedAddRadioItem2;

  private ACPanel tab3;

  private ACValueArrayRadioButtonGroup dementiaRehabilitationShortConcentrationAddRadio;

  private ACLabelContainer dementiaRehabilitationShortConcentrationAddRadioContainer;

  private ACListModelAdapter dementiaRehabilitationShortConcentrationAddRadioModel;

  private ACRadioButtonItem dementiaRehabilitationShortConcentrationAddRadioItem1;

  private ACRadioButtonItem dementiaRehabilitationShortConcentrationAddRadioItem2;

  private ACRadioButtonItem dementiaRehabilitationShortConcentrationAddRadioItem3;

  private ACValueArrayRadioButtonGroup youngDementiaPatinetAddRadioGroup;

  private ACLabelContainer youngDementiaPatinetAddRadioGroupContainer;

  private ACListModelAdapter youngDementiaPatinetAddRadioGroupModel;

  private ACRadioButtonItem youngDementiaPatinetAddRadioItem1;

  private ACRadioButtonItem youngDementiaPatinetAddRadioItem2;

  private ACValueArrayRadioButtonGroup houmonRehabilitationNourishmentManagementAddRadio;

  private ACLabelContainer houmonRehabilitationNourishmentManagementAddRadioContainer;

  private ACListModelAdapter houmonRehabilitationNourishmentManagementAddRadioModel;

  private ACRadioButtonItem houmonRehabilitationNourishmentManagementAddRadioItem1;

  private ACRadioButtonItem houmonRehabilitationNourishmentManagementAddRadioItem2;

  private ACValueArrayRadioButtonGroup houmonRehabilitationMouthFunctionAddRadio;

  private ACLabelContainer houmonRehabilitationMouthFunctionAddRadioContainer;

  private ACListModelAdapter houmonRehabilitationMouthFunctionAddRadioModel;

  private ACRadioButtonItem houmonRehabilitationMouthFunctionAddRadioItem1;

  private ACRadioButtonItem houmonRehabilitationMouthFunctionAddRadioItem2;

  private ACValueArrayRadioButtonGroup medicalManagementRadioGroup;

  private ACLabelContainer medicalManagementRadioGroupContainer;

  private ACListModelAdapter medicalManagementRadioGroupModel;

  private ACRadioButtonItem medicalManagementRadioItem1;

  private ACRadioButtonItem medicalManagementRadioItem2;

  private ACValueArrayRadioButtonGroup transportationCallRadioGroup;

  private ACLabelContainer transportationCallRadioGroupContainer;

  private ACListModelAdapter transportationCallRadioGroupModel;

  private ACRadioButtonItem transportationCallRadioItem1;

  private ACRadioButtonItem transportationCallRadioItem2;

  private ACValueArrayRadioButtonGroup serviceAddProvisionStructuralRadioGroup;

  private ACLabelContainer serviceAddProvisionStructuralRadioGroupContainer;

  private ACListModelAdapter serviceAddProvisionStructuralRadioGroupModel;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem1;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem4;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem2;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem3;

  private ACValueArrayRadioButtonGroup providerAddMountainousAreaRadioGroup;

  private ACLabelContainer providerAddMountainousAreaRadioGroupContainer;

  private ACListModelAdapter providerAddMountainousAreaRadioGroupModel;

  private ACRadioButtonItem providerAddMountainousAreaRadioItem1;

  private ACRadioButtonItem providerAddMountainousAreaRadioItem2;

  private ACPanel tab4;

  private ACValueArrayRadioButtonGroup lifeActsImproveRehabilitationRadioGroup;

  private ACLabelContainer lifeActsImproveRehabilitationRadioGroupContainer;

  private ACListModelAdapter lifeActsImproveRehabilitationRadioGroupModel;

  private ACRadioButtonItem lifeActsImproveRehabilitationRadioItem1;

  private ACRadioButtonItem lifeActsImproveRehabilitationRadioItem2;

  private ACRadioButtonItem lifeActsImproveRehabilitationRadioItem3;

  private ACValueArrayRadioButtonGroup lifeActsImproveRehaSubtractionRadioGroup;

  private ACLabelContainer lifeActsImproveRehaSubtractionRadioGroupContainer;

  private ACListModelAdapter lifeActsImproveRehaSubtractionRadioGroupModel;

  private ACRadioButtonItem lifeActsImproveRehaSubtractionRadioItem1;

  private ACRadioButtonItem lifeActsImproveRehaSubtractionRadioItem2;

  private ACValueArrayRadioButtonGroup severeCareRecipientsAccepted;

  private ACLabelContainer severeCareRecipientsAcceptedContainer;

  private ACListModelAdapter severeCareRecipientsAcceptedModel;

  private ACRadioButtonItem severeCareRecipientsAcceptedItem1;

  private ACRadioButtonItem severeCareRecipientsAcceptedItem2;

  private ACValueArrayRadioButtonGroup MeetingAndSendingOff;

  private ACLabelContainer MeetingAndSendingOffContainer;

  private ACListModelAdapter MeetingAndSendingOffModel;

  private ACRadioButtonItem MeetingAndSendingOffRoundTrip;

  private ACRadioButtonItem MeetingAndSendingOffOneWay;

  private ACRadioButtonItem MeetingAndSendingOffNone;

  private ACValueArrayRadioButtonGroup regionalServiceRadioGroup;

  private ACLabelContainer regionalServiceRadioGroupContainer;

  private ACListModelAdapter regionalServiceRadioGroupModel;

  private ACRadioButtonItem regionalServiceRadioItem1;

  private ACRadioButtonItem regionalServiceRadioItem2;

  private ACValueArrayRadioButtonGroup rehabilitationSystem;

  private ACLabelContainer rehabilitationSystemContainer;

  private ACListModelAdapter rehabilitationSystemModel;

  private ACRadioButtonItem rehabilitationSystemItem1;

  private ACRadioButtonItem rehabilitationSystemItem2;

  private ACValueArrayRadioButtonGroup nutritionScreening;

  private ACLabelContainer nutritionScreeningContainer;

  private ACListModelAdapter nutritionScreeningModel;

  private ACRadioButtonItem nutritionScreeningItem1;

  private ACRadioButtonItem nutritionScreeningItem2;

  private ACValueArrayRadioButtonGroup calculationDivision;

  private ACLabelContainer calculationDivisionContainer;

  private ACListModelAdapter calculationDivisionModel;

  private ACRadioButtonItem calculationDivisionNormal;

  private ACRadioButtonItem calculationDivisionAddOnly;

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
   * �{�ݓ��̋敪���擾���܂��B
   * @return �{�ݓ��̋敪
   */
  public ACValueArrayRadioButtonGroup getFacilityDivisionRadioGroup(){
    if(facilityDivisionRadioGroup==null){

      facilityDivisionRadioGroup = new ACValueArrayRadioButtonGroup();

      getFacilityDivisionRadioGroupContainer().setText("�{�ݓ��̋敪");

      facilityDivisionRadioGroup.setBindPath("1160116");

      facilityDivisionRadioGroup.setNoSelectIndex(0);

      facilityDivisionRadioGroup.setUseClearButton(false);

      facilityDivisionRadioGroup.setModel(getFacilityDivisionRadioGroupModel());

      facilityDivisionRadioGroup.setValues(new int[]{1,2,7,3,4,8,5,6,9});

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
   * �ʏ�K�́i�a�@�E�f�Ï��j���擾���܂��B
   * @return �ʏ�K�́i�a�@�E�f�Ï��j
   */
  public ACRadioButtonItem getFacilityDivisionRadioItem1(){
    if(facilityDivisionRadioItem1==null){

      facilityDivisionRadioItem1 = new ACRadioButtonItem();

      facilityDivisionRadioItem1.setText("�ʏ�K�́i�a�@�E�f�Ï��j");

      facilityDivisionRadioItem1.setGroup(getFacilityDivisionRadioGroup());

      facilityDivisionRadioItem1.setConstraints(VRLayout.FLOW_RETURN);

      addFacilityDivisionRadioItem1();
    }
    return facilityDivisionRadioItem1;

  }

  /**
   * �ʏ�K�́i�V���{�݁j���擾���܂��B
   * @return �ʏ�K�́i�V���{�݁j
   */
  public ACRadioButtonItem getFacilityDivisionRadioItem2(){
    if(facilityDivisionRadioItem2==null){

      facilityDivisionRadioItem2 = new ACRadioButtonItem();

      facilityDivisionRadioItem2.setText("�ʏ�K�́i�V���{�݁j");

      facilityDivisionRadioItem2.setGroup(getFacilityDivisionRadioGroup());

      facilityDivisionRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

      addFacilityDivisionRadioItem2();
    }
    return facilityDivisionRadioItem2;

  }

  /**
   * �ʏ�K�́i����É@�j���擾���܂��B
   * @return �ʏ�K�́i����É@�j
   */
  public ACRadioButtonItem getFacilityDivisionRadioItem3(){
    if(facilityDivisionRadioItem3==null){

      facilityDivisionRadioItem3 = new ACRadioButtonItem();

      facilityDivisionRadioItem3.setText("�ʏ�K�́i����É@�j");

      facilityDivisionRadioItem3.setGroup(getFacilityDivisionRadioGroup());

      facilityDivisionRadioItem3.setConstraints(VRLayout.FLOW_RETURN);

      addFacilityDivisionRadioItem3();
    }
    return facilityDivisionRadioItem3;

  }

  /**
   * ��K�́iI�j�i�a�@�E�f�Ï��j���擾���܂��B
   * @return ��K�́iI�j�i�a�@�E�f�Ï��j
   */
  public ACRadioButtonItem getFacilityDivisionRadioItem4(){
    if(facilityDivisionRadioItem4==null){

      facilityDivisionRadioItem4 = new ACRadioButtonItem();

      facilityDivisionRadioItem4.setText("��K�́iI�j�i�a�@�E�f�Ï��j");

      facilityDivisionRadioItem4.setGroup(getFacilityDivisionRadioGroup());

      facilityDivisionRadioItem4.setConstraints(VRLayout.FLOW_RETURN);

      addFacilityDivisionRadioItem4();
    }
    return facilityDivisionRadioItem4;

  }

  /**
   * ��K�́iI�j�i�V���{�݁j���擾���܂��B
   * @return ��K�́iI�j�i�V���{�݁j
   */
  public ACRadioButtonItem getFacilityDivisionRadioItem5(){
    if(facilityDivisionRadioItem5==null){

      facilityDivisionRadioItem5 = new ACRadioButtonItem();

      facilityDivisionRadioItem5.setText("��K�́iI�j�i�V���{�݁j");

      facilityDivisionRadioItem5.setGroup(getFacilityDivisionRadioGroup());

      facilityDivisionRadioItem5.setConstraints(VRLayout.FLOW_RETURN);

      addFacilityDivisionRadioItem5();
    }
    return facilityDivisionRadioItem5;

  }

  /**
   * ��K�́iI�j�i����É@�j���擾���܂��B
   * @return ��K�́iI�j�i����É@�j
   */
  public ACRadioButtonItem getFacilityDivisionRadioItem6(){
    if(facilityDivisionRadioItem6==null){

      facilityDivisionRadioItem6 = new ACRadioButtonItem();

      facilityDivisionRadioItem6.setText("��K�́iI�j�i����É@�j");

      facilityDivisionRadioItem6.setGroup(getFacilityDivisionRadioGroup());

      facilityDivisionRadioItem6.setConstraints(VRLayout.FLOW_RETURN);

      addFacilityDivisionRadioItem6();
    }
    return facilityDivisionRadioItem6;

  }

  /**
   * ��K�́iII�j�i�a�@�E�f�Ï��j���擾���܂��B
   * @return ��K�́iII�j�i�a�@�E�f�Ï��j
   */
  public ACRadioButtonItem getFacilityDivisionRadioItem7(){
    if(facilityDivisionRadioItem7==null){

      facilityDivisionRadioItem7 = new ACRadioButtonItem();

      facilityDivisionRadioItem7.setText("��K�́iII�j�i�a�@�E�f�Ï��j");

      facilityDivisionRadioItem7.setGroup(getFacilityDivisionRadioGroup());

      facilityDivisionRadioItem7.setConstraints(VRLayout.FLOW_RETURN);

      addFacilityDivisionRadioItem7();
    }
    return facilityDivisionRadioItem7;

  }

  /**
   * ��K�́iII�j�i�V���{�݁j���擾���܂��B
   * @return ��K�́iII�j�i�V���{�݁j
   */
  public ACRadioButtonItem getFacilityDivisionRadioItem8(){
    if(facilityDivisionRadioItem8==null){

      facilityDivisionRadioItem8 = new ACRadioButtonItem();

      facilityDivisionRadioItem8.setText("��K�́iII�j�i�V���{�݁j");

      facilityDivisionRadioItem8.setGroup(getFacilityDivisionRadioGroup());

      facilityDivisionRadioItem8.setConstraints(VRLayout.FLOW_RETURN);

      addFacilityDivisionRadioItem8();
    }
    return facilityDivisionRadioItem8;

  }

  /**
   * ��K�́iII�j�i����É@�j���擾���܂��B
   * @return ��K�́iII�j�i����É@�j
   */
  public ACRadioButtonItem getFacilityDivisionRadioItem9(){
    if(facilityDivisionRadioItem9==null){

      facilityDivisionRadioItem9 = new ACRadioButtonItem();

      facilityDivisionRadioItem9.setText("��K�́iII�j�i����É@�j");

      facilityDivisionRadioItem9.setGroup(getFacilityDivisionRadioGroup());

      facilityDivisionRadioItem9.setConstraints(VRLayout.FLOW_RETURN);

      addFacilityDivisionRadioItem9();
    }
    return facilityDivisionRadioItem9;

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

      houmonRehabilitationTimeDivision.setRenderBindPath("CONTENT");

      houmonRehabilitationTimeDivision.setModel(getHoumonRehabilitationTimeDivisionModel());

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
      houmonRehabilitationTimeDivisionContainer.setVAlignment(VRLayout.CENTER);
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

      houmonRehabilitationTimeContenaBeginTime.setRenderBindPath("CONTENT");

      houmonRehabilitationTimeContenaBeginTime.setModel(getHoumonRehabilitationTimeContenaBeginTimeModel());

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
      houmonRehabilitationTimeContenaBeginTimeContainer.setVAlignment(VRLayout.CENTER);
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

      houmonRehabilitationTimeContenaEndTime.setRenderBindPath("CONTENT");

      houmonRehabilitationTimeContenaEndTime.setModel(getHoumonRehabilitationTimeContenaEndTimeModel());

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
      houmonRehabilitationTimeContenaEndTimeContainer.setVAlignment(VRLayout.CENTER);
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
   * �l�����Z���擾���܂��B
   * @return �l�����Z
   */
  public ACValueArrayRadioButtonGroup getHoumonRehabilitationSubtraction(){
    if(houmonRehabilitationSubtraction==null){

      houmonRehabilitationSubtraction = new ACValueArrayRadioButtonGroup();

      getHoumonRehabilitationSubtractionContainer().setText("�l�����Z");

      houmonRehabilitationSubtraction.setBindPath("1160109");

      houmonRehabilitationSubtraction.setUseClearButton(false);

      houmonRehabilitationSubtraction.setModel(getHoumonRehabilitationSubtractionModel());

      houmonRehabilitationSubtraction.setValues(new int[]{1,2,3});

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
      houmonRehabilitationSubtractionContainer.setVAlignment(VRLayout.CENTER);
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
   * �������Z���擾���܂��B
   * @return �������Z
   */
  public ACValueArrayRadioButtonGroup getHoumonRehabilitationBathRadio(){
    if(houmonRehabilitationBathRadio==null){

      houmonRehabilitationBathRadio = new ACValueArrayRadioButtonGroup();

      getHoumonRehabilitationBathRadioContainer().setText("�������Z");

      houmonRehabilitationBathRadio.setBindPath("1160105");

      houmonRehabilitationBathRadio.setUseClearButton(false);

      houmonRehabilitationBathRadio.setModel(getHoumonRehabilitationBathRadioModel());

      houmonRehabilitationBathRadio.setValues(new int[]{1,2});

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
      houmonRehabilitationBathRadioContainer.setVAlignment(VRLayout.CENTER);
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
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getHoumonRehabilitationBathRadioItem2(){
    if(houmonRehabilitationBathRadioItem2==null){

      houmonRehabilitationBathRadioItem2 = new ACRadioButtonItem();

      houmonRehabilitationBathRadioItem2.setText("����");

      houmonRehabilitationBathRadioItem2.setGroup(getHoumonRehabilitationBathRadio());

      houmonRehabilitationBathRadioItem2.setConstraints(VRLayout.FLOW);

      addHoumonRehabilitationBathRadioItem2();
    }
    return houmonRehabilitationBathRadioItem2;

  }

  /**
   * ���n�r���e�[�V�����}�l�W�����g���Z���擾���܂��B
   * @return ���n�r���e�[�V�����}�l�W�����g���Z
   */
  public ACValueArrayRadioButtonGroup getHoumonRehabilitationManagementAddRadio(){
    if(houmonRehabilitationManagementAddRadio==null){

      houmonRehabilitationManagementAddRadio = new ACValueArrayRadioButtonGroup();

      getHoumonRehabilitationManagementAddRadioContainer().setText("<html>���n�r���e�[�V����<br>�}�l�W�����g���Z<html>");

      houmonRehabilitationManagementAddRadio.setBindPath("1160111");

      houmonRehabilitationManagementAddRadio.setUseClearButton(false);

      houmonRehabilitationManagementAddRadio.setModel(getHoumonRehabilitationManagementAddRadioModel());

      houmonRehabilitationManagementAddRadio.setValues(new int[]{1,2,3,4,5,6,7,8});

      addHoumonRehabilitationManagementAddRadio();
    }
    return houmonRehabilitationManagementAddRadio;

  }

  /**
   * ���n�r���e�[�V�����}�l�W�����g���Z�R���e�i���擾���܂��B
   * @return ���n�r���e�[�V�����}�l�W�����g���Z�R���e�i
   */
  protected ACLabelContainer getHoumonRehabilitationManagementAddRadioContainer(){
    if(houmonRehabilitationManagementAddRadioContainer==null){
      houmonRehabilitationManagementAddRadioContainer = new ACLabelContainer();
      houmonRehabilitationManagementAddRadioContainer.setFollowChildEnabled(true);
      houmonRehabilitationManagementAddRadioContainer.setVAlignment(VRLayout.CENTER);
      houmonRehabilitationManagementAddRadioContainer.add(getHoumonRehabilitationManagementAddRadio(), null);
    }
    return houmonRehabilitationManagementAddRadioContainer;
  }

  /**
   * ���n�r���e�[�V�����}�l�W�����g���Z���f�����擾���܂��B
   * @return ���n�r���e�[�V�����}�l�W�����g���Z���f��
   */
  protected ACListModelAdapter getHoumonRehabilitationManagementAddRadioModel(){
    if(houmonRehabilitationManagementAddRadioModel==null){
      houmonRehabilitationManagementAddRadioModel = new ACListModelAdapter();
      addHoumonRehabilitationManagementAddRadioModel();
    }
    return houmonRehabilitationManagementAddRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getHoumonRehabilitationManagementAddRadioItem1(){
    if(houmonRehabilitationManagementAddRadioItem1==null){

      houmonRehabilitationManagementAddRadioItem1 = new ACRadioButtonItem();

      houmonRehabilitationManagementAddRadioItem1.setText("�Ȃ�");

      houmonRehabilitationManagementAddRadioItem1.setGroup(getHoumonRehabilitationManagementAddRadio());

      houmonRehabilitationManagementAddRadioItem1.setConstraints(VRLayout.FLOW);

      addHoumonRehabilitationManagementAddRadioItem1();
    }
    return houmonRehabilitationManagementAddRadioItem1;

  }

  /**
   * I�^���擾���܂��B
   * @return I�^
   */
  public ACRadioButtonItem getHoumonRehabilitationManagementAddRadioItem2(){
    if(houmonRehabilitationManagementAddRadioItem2==null){

      houmonRehabilitationManagementAddRadioItem2 = new ACRadioButtonItem();

      houmonRehabilitationManagementAddRadioItem2.setText("I�^");

      houmonRehabilitationManagementAddRadioItem2.setGroup(getHoumonRehabilitationManagementAddRadio());

      houmonRehabilitationManagementAddRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

      addHoumonRehabilitationManagementAddRadioItem2();
    }
    return houmonRehabilitationManagementAddRadioItem2;

  }

  /**
   * II�^(6���ȓ�)���擾���܂��B
   * @return II�^(6���ȓ�)
   */
  public ACRadioButtonItem getHoumonRehabilitationManagementAddRadioItem3(){
    if(houmonRehabilitationManagementAddRadioItem3==null){

      houmonRehabilitationManagementAddRadioItem3 = new ACRadioButtonItem();

      houmonRehabilitationManagementAddRadioItem3.setText("II�^(6���ȓ�)");

      houmonRehabilitationManagementAddRadioItem3.setGroup(getHoumonRehabilitationManagementAddRadio());

      houmonRehabilitationManagementAddRadioItem3.setConstraints(VRLayout.FLOW);

      addHoumonRehabilitationManagementAddRadioItem3();
    }
    return houmonRehabilitationManagementAddRadioItem3;

  }

  /**
   * II�^(6����)���擾���܂��B
   * @return II�^(6����)
   */
  public ACRadioButtonItem getHoumonRehabilitationManagementAddRadioItem4(){
    if(houmonRehabilitationManagementAddRadioItem4==null){

      houmonRehabilitationManagementAddRadioItem4 = new ACRadioButtonItem();

      houmonRehabilitationManagementAddRadioItem4.setText("II�^(6����)");

      houmonRehabilitationManagementAddRadioItem4.setGroup(getHoumonRehabilitationManagementAddRadio());

      houmonRehabilitationManagementAddRadioItem4.setConstraints(VRLayout.FLOW_RETURN);

      addHoumonRehabilitationManagementAddRadioItem4();
    }
    return houmonRehabilitationManagementAddRadioItem4;

  }

  /**
   * III�^(6���ȓ�)���擾���܂��B
   * @return III�^(6���ȓ�)
   */
  public ACRadioButtonItem getHoumonRehabilitationManagementAddRadioItem5(){
    if(houmonRehabilitationManagementAddRadioItem5==null){

      houmonRehabilitationManagementAddRadioItem5 = new ACRadioButtonItem();

      houmonRehabilitationManagementAddRadioItem5.setText("III�^(6���ȓ�)");

      houmonRehabilitationManagementAddRadioItem5.setGroup(getHoumonRehabilitationManagementAddRadio());

      houmonRehabilitationManagementAddRadioItem5.setConstraints(VRLayout.FLOW);

      addHoumonRehabilitationManagementAddRadioItem5();
    }
    return houmonRehabilitationManagementAddRadioItem5;

  }

  /**
   * III�^(6����)���擾���܂��B
   * @return III�^(6����)
   */
  public ACRadioButtonItem getHoumonRehabilitationManagementAddRadioItem6(){
    if(houmonRehabilitationManagementAddRadioItem6==null){

      houmonRehabilitationManagementAddRadioItem6 = new ACRadioButtonItem();

      houmonRehabilitationManagementAddRadioItem6.setText("III�^(6����)");

      houmonRehabilitationManagementAddRadioItem6.setGroup(getHoumonRehabilitationManagementAddRadio());

      houmonRehabilitationManagementAddRadioItem6.setConstraints(VRLayout.FLOW_RETURN);

      addHoumonRehabilitationManagementAddRadioItem6();
    }
    return houmonRehabilitationManagementAddRadioItem6;

  }

  /**
   * IV�^(6���ȓ�)���擾���܂��B
   * @return IV�^(6���ȓ�)
   */
  public ACRadioButtonItem getHoumonRehabilitationManagementAddRadioItem7(){
    if(houmonRehabilitationManagementAddRadioItem7==null){

      houmonRehabilitationManagementAddRadioItem7 = new ACRadioButtonItem();

      houmonRehabilitationManagementAddRadioItem7.setText("IV�^(6���ȓ�)");

      houmonRehabilitationManagementAddRadioItem7.setGroup(getHoumonRehabilitationManagementAddRadio());

      houmonRehabilitationManagementAddRadioItem7.setConstraints(VRLayout.FLOW);

      addHoumonRehabilitationManagementAddRadioItem7();
    }
    return houmonRehabilitationManagementAddRadioItem7;

  }

  /**
   * IV�^(6����)���擾���܂��B
   * @return IV�^(6����)
   */
  public ACRadioButtonItem getHoumonRehabilitationManagementAddRadioItem8(){
    if(houmonRehabilitationManagementAddRadioItem8==null){

      houmonRehabilitationManagementAddRadioItem8 = new ACRadioButtonItem();

      houmonRehabilitationManagementAddRadioItem8.setText("IV�^(6����)");

      houmonRehabilitationManagementAddRadioItem8.setGroup(getHoumonRehabilitationManagementAddRadio());

      houmonRehabilitationManagementAddRadioItem8.setConstraints(VRLayout.FLOW);

      addHoumonRehabilitationManagementAddRadioItem8();
    }
    return houmonRehabilitationManagementAddRadioItem8;

  }

  /**
   * �Z���W���ʃ��n�r�����{���Z���擾���܂��B
   * @return �Z���W���ʃ��n�r�����{���Z
   */
  public ACValueArrayRadioButtonGroup getHoumonRehabilitationShortConcentrationAddRadio(){
    if(houmonRehabilitationShortConcentrationAddRadio==null){

      houmonRehabilitationShortConcentrationAddRadio = new ACValueArrayRadioButtonGroup();

      getHoumonRehabilitationShortConcentrationAddRadioContainer().setText("�Z���W���ʃ��n�r�����{���Z");

      houmonRehabilitationShortConcentrationAddRadio.setBindPath("1160112");

      houmonRehabilitationShortConcentrationAddRadio.setUseClearButton(false);

      houmonRehabilitationShortConcentrationAddRadio.setModel(getHoumonRehabilitationShortConcentrationAddRadioModel());

      houmonRehabilitationShortConcentrationAddRadio.setValues(new int[]{1,2});

      addHoumonRehabilitationShortConcentrationAddRadio();
    }
    return houmonRehabilitationShortConcentrationAddRadio;

  }

  /**
   * �Z���W���ʃ��n�r�����{���Z�R���e�i���擾���܂��B
   * @return �Z���W���ʃ��n�r�����{���Z�R���e�i
   */
  protected ACLabelContainer getHoumonRehabilitationShortConcentrationAddRadioContainer(){
    if(houmonRehabilitationShortConcentrationAddRadioContainer==null){
      houmonRehabilitationShortConcentrationAddRadioContainer = new ACLabelContainer();
      houmonRehabilitationShortConcentrationAddRadioContainer.setFollowChildEnabled(true);
      houmonRehabilitationShortConcentrationAddRadioContainer.setVAlignment(VRLayout.CENTER);
      houmonRehabilitationShortConcentrationAddRadioContainer.add(getHoumonRehabilitationShortConcentrationAddRadio(), null);
    }
    return houmonRehabilitationShortConcentrationAddRadioContainer;
  }

  /**
   * �Z���W���ʃ��n�r�����{���Z���f�����擾���܂��B
   * @return �Z���W���ʃ��n�r�����{���Z���f��
   */
  protected ACListModelAdapter getHoumonRehabilitationShortConcentrationAddRadioModel(){
    if(houmonRehabilitationShortConcentrationAddRadioModel==null){
      houmonRehabilitationShortConcentrationAddRadioModel = new ACListModelAdapter();
      addHoumonRehabilitationShortConcentrationAddRadioModel();
    }
    return houmonRehabilitationShortConcentrationAddRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getHoumonRehabilitationShortConcentrationAddRadioItem1(){
    if(houmonRehabilitationShortConcentrationAddRadioItem1==null){

      houmonRehabilitationShortConcentrationAddRadioItem1 = new ACRadioButtonItem();

      houmonRehabilitationShortConcentrationAddRadioItem1.setText("�Ȃ�");

      houmonRehabilitationShortConcentrationAddRadioItem1.setGroup(getHoumonRehabilitationShortConcentrationAddRadio());

      houmonRehabilitationShortConcentrationAddRadioItem1.setConstraints(VRLayout.FLOW);

      addHoumonRehabilitationShortConcentrationAddRadioItem1();
    }
    return houmonRehabilitationShortConcentrationAddRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getHoumonRehabilitationShortConcentrationAddRadioItem2(){
    if(houmonRehabilitationShortConcentrationAddRadioItem2==null){

      houmonRehabilitationShortConcentrationAddRadioItem2 = new ACRadioButtonItem();

      houmonRehabilitationShortConcentrationAddRadioItem2.setText("����");

      houmonRehabilitationShortConcentrationAddRadioItem2.setGroup(getHoumonRehabilitationShortConcentrationAddRadio());

      houmonRehabilitationShortConcentrationAddRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

      addHoumonRehabilitationShortConcentrationAddRadioItem2();
    }
    return houmonRehabilitationShortConcentrationAddRadioItem2;

  }

  /**
   * ���w�Ö@�m���̐��������Z���擾���܂��B
   * @return ���w�Ö@�m���̐��������Z
   */
  public ACValueArrayRadioButtonGroup getPhysiotherapistStrengthenedAddRadioGroup(){
    if(physiotherapistStrengthenedAddRadioGroup==null){

      physiotherapistStrengthenedAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getPhysiotherapistStrengthenedAddRadioGroupContainer().setText("���w�Ö@�m���̐��������Z");

      physiotherapistStrengthenedAddRadioGroup.setBindPath("1160119");

      physiotherapistStrengthenedAddRadioGroup.setNoSelectIndex(0);

      physiotherapistStrengthenedAddRadioGroup.setUseClearButton(false);

      physiotherapistStrengthenedAddRadioGroup.setModel(getPhysiotherapistStrengthenedAddRadioGroupModel());

      physiotherapistStrengthenedAddRadioGroup.setValues(new int[]{1,2});

      addPhysiotherapistStrengthenedAddRadioGroup();
    }
    return physiotherapistStrengthenedAddRadioGroup;

  }

  /**
   * ���w�Ö@�m���̐��������Z�R���e�i���擾���܂��B
   * @return ���w�Ö@�m���̐��������Z�R���e�i
   */
  protected ACLabelContainer getPhysiotherapistStrengthenedAddRadioGroupContainer(){
    if(physiotherapistStrengthenedAddRadioGroupContainer==null){
      physiotherapistStrengthenedAddRadioGroupContainer = new ACLabelContainer();
      physiotherapistStrengthenedAddRadioGroupContainer.setFollowChildEnabled(true);
      physiotherapistStrengthenedAddRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      physiotherapistStrengthenedAddRadioGroupContainer.add(getPhysiotherapistStrengthenedAddRadioGroup(), null);
    }
    return physiotherapistStrengthenedAddRadioGroupContainer;
  }

  /**
   * ���w�Ö@�m���̐��������Z���f�����擾���܂��B
   * @return ���w�Ö@�m���̐��������Z���f��
   */
  protected ACListModelAdapter getPhysiotherapistStrengthenedAddRadioGroupModel(){
    if(physiotherapistStrengthenedAddRadioGroupModel==null){
      physiotherapistStrengthenedAddRadioGroupModel = new ACListModelAdapter();
      addPhysiotherapistStrengthenedAddRadioGroupModel();
    }
    return physiotherapistStrengthenedAddRadioGroupModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getPhysiotherapistStrengthenedAddRadioItem1(){
    if(physiotherapistStrengthenedAddRadioItem1==null){

      physiotherapistStrengthenedAddRadioItem1 = new ACRadioButtonItem();

      physiotherapistStrengthenedAddRadioItem1.setText("�Ȃ�");

      physiotherapistStrengthenedAddRadioItem1.setGroup(getPhysiotherapistStrengthenedAddRadioGroup());

      physiotherapistStrengthenedAddRadioItem1.setConstraints(VRLayout.FLOW);

      addPhysiotherapistStrengthenedAddRadioItem1();
    }
    return physiotherapistStrengthenedAddRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getPhysiotherapistStrengthenedAddRadioItem2(){
    if(physiotherapistStrengthenedAddRadioItem2==null){

      physiotherapistStrengthenedAddRadioItem2 = new ACRadioButtonItem();

      physiotherapistStrengthenedAddRadioItem2.setText("����");

      physiotherapistStrengthenedAddRadioItem2.setGroup(getPhysiotherapistStrengthenedAddRadioGroup());

      physiotherapistStrengthenedAddRadioItem2.setConstraints(VRLayout.FLOW);

      addPhysiotherapistStrengthenedAddRadioItem2();
    }
    return physiotherapistStrengthenedAddRadioItem2;

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

      addTab3();
    }
    return tab3;

  }

  /**
   * �F�m�ǒZ���W�����n�r�����{���Z���擾���܂��B
   * @return �F�m�ǒZ���W�����n�r�����{���Z
   */
  public ACValueArrayRadioButtonGroup getDementiaRehabilitationShortConcentrationAddRadio(){
    if(dementiaRehabilitationShortConcentrationAddRadio==null){

      dementiaRehabilitationShortConcentrationAddRadio = new ACValueArrayRadioButtonGroup();

      getDementiaRehabilitationShortConcentrationAddRadioContainer().setText("�F�m�ǒZ���W�����n�r�����{���Z");

      dementiaRehabilitationShortConcentrationAddRadio.setBindPath("1160120");

      dementiaRehabilitationShortConcentrationAddRadio.setUseClearButton(false);

      dementiaRehabilitationShortConcentrationAddRadio.setModel(getDementiaRehabilitationShortConcentrationAddRadioModel());

      dementiaRehabilitationShortConcentrationAddRadio.setValues(new int[]{1,2,3});

      addDementiaRehabilitationShortConcentrationAddRadio();
    }
    return dementiaRehabilitationShortConcentrationAddRadio;

  }

  /**
   * �F�m�ǒZ���W�����n�r�����{���Z�R���e�i���擾���܂��B
   * @return �F�m�ǒZ���W�����n�r�����{���Z�R���e�i
   */
  protected ACLabelContainer getDementiaRehabilitationShortConcentrationAddRadioContainer(){
    if(dementiaRehabilitationShortConcentrationAddRadioContainer==null){
      dementiaRehabilitationShortConcentrationAddRadioContainer = new ACLabelContainer();
      dementiaRehabilitationShortConcentrationAddRadioContainer.setFollowChildEnabled(true);
      dementiaRehabilitationShortConcentrationAddRadioContainer.setVAlignment(VRLayout.CENTER);
      dementiaRehabilitationShortConcentrationAddRadioContainer.add(getDementiaRehabilitationShortConcentrationAddRadio(), null);
    }
    return dementiaRehabilitationShortConcentrationAddRadioContainer;
  }

  /**
   * �F�m�ǒZ���W�����n�r�����{���Z���f�����擾���܂��B
   * @return �F�m�ǒZ���W�����n�r�����{���Z���f��
   */
  protected ACListModelAdapter getDementiaRehabilitationShortConcentrationAddRadioModel(){
    if(dementiaRehabilitationShortConcentrationAddRadioModel==null){
      dementiaRehabilitationShortConcentrationAddRadioModel = new ACListModelAdapter();
      addDementiaRehabilitationShortConcentrationAddRadioModel();
    }
    return dementiaRehabilitationShortConcentrationAddRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getDementiaRehabilitationShortConcentrationAddRadioItem1(){
    if(dementiaRehabilitationShortConcentrationAddRadioItem1==null){

      dementiaRehabilitationShortConcentrationAddRadioItem1 = new ACRadioButtonItem();

      dementiaRehabilitationShortConcentrationAddRadioItem1.setText("�Ȃ�");

      dementiaRehabilitationShortConcentrationAddRadioItem1.setGroup(getDementiaRehabilitationShortConcentrationAddRadio());

      dementiaRehabilitationShortConcentrationAddRadioItem1.setConstraints(VRLayout.FLOW_RETURN);

      addDementiaRehabilitationShortConcentrationAddRadioItem1();
    }
    return dementiaRehabilitationShortConcentrationAddRadioItem1;

  }

  /**
   * I�^���擾���܂��B
   * @return I�^
   */
  public ACRadioButtonItem getDementiaRehabilitationShortConcentrationAddRadioItem2(){
    if(dementiaRehabilitationShortConcentrationAddRadioItem2==null){

      dementiaRehabilitationShortConcentrationAddRadioItem2 = new ACRadioButtonItem();

      dementiaRehabilitationShortConcentrationAddRadioItem2.setText("I�^");

      dementiaRehabilitationShortConcentrationAddRadioItem2.setGroup(getDementiaRehabilitationShortConcentrationAddRadio());

      dementiaRehabilitationShortConcentrationAddRadioItem2.setConstraints(VRLayout.FLOW);

      addDementiaRehabilitationShortConcentrationAddRadioItem2();
    }
    return dementiaRehabilitationShortConcentrationAddRadioItem2;

  }

  /**
   * II�^���擾���܂��B
   * @return II�^
   */
  public ACRadioButtonItem getDementiaRehabilitationShortConcentrationAddRadioItem3(){
    if(dementiaRehabilitationShortConcentrationAddRadioItem3==null){

      dementiaRehabilitationShortConcentrationAddRadioItem3 = new ACRadioButtonItem();

      dementiaRehabilitationShortConcentrationAddRadioItem3.setText("II�^");

      dementiaRehabilitationShortConcentrationAddRadioItem3.setGroup(getDementiaRehabilitationShortConcentrationAddRadio());

      dementiaRehabilitationShortConcentrationAddRadioItem3.setConstraints(VRLayout.FLOW);

      addDementiaRehabilitationShortConcentrationAddRadioItem3();
    }
    return dementiaRehabilitationShortConcentrationAddRadioItem3;

  }

  /**
   * ��N���F�m�Ǘ��p�Ҏ�����Z���擾���܂��B
   * @return ��N���F�m�Ǘ��p�Ҏ�����Z
   */
  public ACValueArrayRadioButtonGroup getYoungDementiaPatinetAddRadioGroup(){
    if(youngDementiaPatinetAddRadioGroup==null){

      youngDementiaPatinetAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getYoungDementiaPatinetAddRadioGroupContainer().setText("��N���F�m�Ǘ��p�Ҏ�����Z");

      youngDementiaPatinetAddRadioGroup.setBindPath("1160121");

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
  public ACValueArrayRadioButtonGroup getHoumonRehabilitationNourishmentManagementAddRadio(){
    if(houmonRehabilitationNourishmentManagementAddRadio==null){

      houmonRehabilitationNourishmentManagementAddRadio = new ACValueArrayRadioButtonGroup();

      getHoumonRehabilitationNourishmentManagementAddRadioContainer().setText("�h�{���P���Z");

      houmonRehabilitationNourishmentManagementAddRadio.setBindPath("1160114");

      houmonRehabilitationNourishmentManagementAddRadio.setUseClearButton(false);

      houmonRehabilitationNourishmentManagementAddRadio.setModel(getHoumonRehabilitationNourishmentManagementAddRadioModel());

      houmonRehabilitationNourishmentManagementAddRadio.setValues(new int[]{1,2});

      addHoumonRehabilitationNourishmentManagementAddRadio();
    }
    return houmonRehabilitationNourishmentManagementAddRadio;

  }

  /**
   * �h�{���P���Z�R���e�i���擾���܂��B
   * @return �h�{���P���Z�R���e�i
   */
  protected ACLabelContainer getHoumonRehabilitationNourishmentManagementAddRadioContainer(){
    if(houmonRehabilitationNourishmentManagementAddRadioContainer==null){
      houmonRehabilitationNourishmentManagementAddRadioContainer = new ACLabelContainer();
      houmonRehabilitationNourishmentManagementAddRadioContainer.setFollowChildEnabled(true);
      houmonRehabilitationNourishmentManagementAddRadioContainer.setVAlignment(VRLayout.CENTER);
      houmonRehabilitationNourishmentManagementAddRadioContainer.add(getHoumonRehabilitationNourishmentManagementAddRadio(), null);
    }
    return houmonRehabilitationNourishmentManagementAddRadioContainer;
  }

  /**
   * �h�{���P���Z���f�����擾���܂��B
   * @return �h�{���P���Z���f��
   */
  protected ACListModelAdapter getHoumonRehabilitationNourishmentManagementAddRadioModel(){
    if(houmonRehabilitationNourishmentManagementAddRadioModel==null){
      houmonRehabilitationNourishmentManagementAddRadioModel = new ACListModelAdapter();
      addHoumonRehabilitationNourishmentManagementAddRadioModel();
    }
    return houmonRehabilitationNourishmentManagementAddRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getHoumonRehabilitationNourishmentManagementAddRadioItem1(){
    if(houmonRehabilitationNourishmentManagementAddRadioItem1==null){

      houmonRehabilitationNourishmentManagementAddRadioItem1 = new ACRadioButtonItem();

      houmonRehabilitationNourishmentManagementAddRadioItem1.setText("�Ȃ�");

      houmonRehabilitationNourishmentManagementAddRadioItem1.setGroup(getHoumonRehabilitationNourishmentManagementAddRadio());

      houmonRehabilitationNourishmentManagementAddRadioItem1.setConstraints(VRLayout.FLOW);

      addHoumonRehabilitationNourishmentManagementAddRadioItem1();
    }
    return houmonRehabilitationNourishmentManagementAddRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getHoumonRehabilitationNourishmentManagementAddRadioItem2(){
    if(houmonRehabilitationNourishmentManagementAddRadioItem2==null){

      houmonRehabilitationNourishmentManagementAddRadioItem2 = new ACRadioButtonItem();

      houmonRehabilitationNourishmentManagementAddRadioItem2.setText("����");

      houmonRehabilitationNourishmentManagementAddRadioItem2.setGroup(getHoumonRehabilitationNourishmentManagementAddRadio());

      houmonRehabilitationNourishmentManagementAddRadioItem2.setConstraints(VRLayout.FLOW);

      addHoumonRehabilitationNourishmentManagementAddRadioItem2();
    }
    return houmonRehabilitationNourishmentManagementAddRadioItem2;

  }

  /**
   * ���o�@�\������Z���擾���܂��B
   * @return ���o�@�\������Z
   */
  public ACValueArrayRadioButtonGroup getHoumonRehabilitationMouthFunctionAddRadio(){
    if(houmonRehabilitationMouthFunctionAddRadio==null){

      houmonRehabilitationMouthFunctionAddRadio = new ACValueArrayRadioButtonGroup();

      getHoumonRehabilitationMouthFunctionAddRadioContainer().setText("���o�@�\������Z");

      houmonRehabilitationMouthFunctionAddRadio.setBindPath("1160115");

      houmonRehabilitationMouthFunctionAddRadio.setUseClearButton(false);

      houmonRehabilitationMouthFunctionAddRadio.setModel(getHoumonRehabilitationMouthFunctionAddRadioModel());

      houmonRehabilitationMouthFunctionAddRadio.setValues(new int[]{1,2});

      addHoumonRehabilitationMouthFunctionAddRadio();
    }
    return houmonRehabilitationMouthFunctionAddRadio;

  }

  /**
   * ���o�@�\������Z�R���e�i���擾���܂��B
   * @return ���o�@�\������Z�R���e�i
   */
  protected ACLabelContainer getHoumonRehabilitationMouthFunctionAddRadioContainer(){
    if(houmonRehabilitationMouthFunctionAddRadioContainer==null){
      houmonRehabilitationMouthFunctionAddRadioContainer = new ACLabelContainer();
      houmonRehabilitationMouthFunctionAddRadioContainer.setFollowChildEnabled(true);
      houmonRehabilitationMouthFunctionAddRadioContainer.setVAlignment(VRLayout.CENTER);
      houmonRehabilitationMouthFunctionAddRadioContainer.add(getHoumonRehabilitationMouthFunctionAddRadio(), null);
    }
    return houmonRehabilitationMouthFunctionAddRadioContainer;
  }

  /**
   * ���o�@�\������Z���f�����擾���܂��B
   * @return ���o�@�\������Z���f��
   */
  protected ACListModelAdapter getHoumonRehabilitationMouthFunctionAddRadioModel(){
    if(houmonRehabilitationMouthFunctionAddRadioModel==null){
      houmonRehabilitationMouthFunctionAddRadioModel = new ACListModelAdapter();
      addHoumonRehabilitationMouthFunctionAddRadioModel();
    }
    return houmonRehabilitationMouthFunctionAddRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getHoumonRehabilitationMouthFunctionAddRadioItem1(){
    if(houmonRehabilitationMouthFunctionAddRadioItem1==null){

      houmonRehabilitationMouthFunctionAddRadioItem1 = new ACRadioButtonItem();

      houmonRehabilitationMouthFunctionAddRadioItem1.setText("�Ȃ�");

      houmonRehabilitationMouthFunctionAddRadioItem1.setGroup(getHoumonRehabilitationMouthFunctionAddRadio());

      houmonRehabilitationMouthFunctionAddRadioItem1.setConstraints(VRLayout.FLOW);

      addHoumonRehabilitationMouthFunctionAddRadioItem1();
    }
    return houmonRehabilitationMouthFunctionAddRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getHoumonRehabilitationMouthFunctionAddRadioItem2(){
    if(houmonRehabilitationMouthFunctionAddRadioItem2==null){

      houmonRehabilitationMouthFunctionAddRadioItem2 = new ACRadioButtonItem();

      houmonRehabilitationMouthFunctionAddRadioItem2.setText("����");

      houmonRehabilitationMouthFunctionAddRadioItem2.setGroup(getHoumonRehabilitationMouthFunctionAddRadio());

      houmonRehabilitationMouthFunctionAddRadioItem2.setConstraints(VRLayout.FLOW);

      addHoumonRehabilitationMouthFunctionAddRadioItem2();
    }
    return houmonRehabilitationMouthFunctionAddRadioItem2;

  }

  /**
   * �d�x�×{�Ǘ����Z���擾���܂��B
   * @return �d�x�×{�Ǘ����Z
   */
  public ACValueArrayRadioButtonGroup getMedicalManagementRadioGroup(){
    if(medicalManagementRadioGroup==null){

      medicalManagementRadioGroup = new ACValueArrayRadioButtonGroup();

      getMedicalManagementRadioGroupContainer().setText("�d�x�×{�Ǘ����Z");

      medicalManagementRadioGroup.setBindPath("1160123");

      medicalManagementRadioGroup.setUseClearButton(false);

      medicalManagementRadioGroup.setModel(getMedicalManagementRadioGroupModel());

      medicalManagementRadioGroup.setValues(new int[]{1,2});

      addMedicalManagementRadioGroup();
    }
    return medicalManagementRadioGroup;

  }

  /**
   * �d�x�×{�Ǘ����Z�R���e�i���擾���܂��B
   * @return �d�x�×{�Ǘ����Z�R���e�i
   */
  protected ACLabelContainer getMedicalManagementRadioGroupContainer(){
    if(medicalManagementRadioGroupContainer==null){
      medicalManagementRadioGroupContainer = new ACLabelContainer();
      medicalManagementRadioGroupContainer.setFollowChildEnabled(true);
      medicalManagementRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      medicalManagementRadioGroupContainer.add(getMedicalManagementRadioGroup(), null);
    }
    return medicalManagementRadioGroupContainer;
  }

  /**
   * �d�x�×{�Ǘ����Z���f�����擾���܂��B
   * @return �d�x�×{�Ǘ����Z���f��
   */
  protected ACListModelAdapter getMedicalManagementRadioGroupModel(){
    if(medicalManagementRadioGroupModel==null){
      medicalManagementRadioGroupModel = new ACListModelAdapter();
      addMedicalManagementRadioGroupModel();
    }
    return medicalManagementRadioGroupModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getMedicalManagementRadioItem1(){
    if(medicalManagementRadioItem1==null){

      medicalManagementRadioItem1 = new ACRadioButtonItem();

      medicalManagementRadioItem1.setText("�Ȃ�");

      medicalManagementRadioItem1.setGroup(getMedicalManagementRadioGroup());

      medicalManagementRadioItem1.setConstraints(VRLayout.FLOW);

      addMedicalManagementRadioItem1();
    }
    return medicalManagementRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getMedicalManagementRadioItem2(){
    if(medicalManagementRadioItem2==null){

      medicalManagementRadioItem2 = new ACRadioButtonItem();

      medicalManagementRadioItem2.setText("����");

      medicalManagementRadioItem2.setGroup(getMedicalManagementRadioGroup());

      medicalManagementRadioItem2.setConstraints(VRLayout.FLOW);

      addMedicalManagementRadioItem2();
    }
    return medicalManagementRadioItem2;

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

      serviceAddProvisionStructuralRadioGroup.setBindPath("1160122");

      serviceAddProvisionStructuralRadioGroup.setNoSelectIndex(0);

      serviceAddProvisionStructuralRadioGroup.setUseClearButton(false);

      serviceAddProvisionStructuralRadioGroup.setModel(getServiceAddProvisionStructuralRadioGroupModel());

      serviceAddProvisionStructuralRadioGroup.setValues(new int[]{1,4,2,3});

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
  public ACRadioButtonItem getServiceAddProvisionStructuralRadioItem4(){
    if(serviceAddProvisionStructuralRadioItem4==null){

      serviceAddProvisionStructuralRadioItem4 = new ACRadioButtonItem();

      serviceAddProvisionStructuralRadioItem4.setText("I�C�^");

      serviceAddProvisionStructuralRadioItem4.setGroup(getServiceAddProvisionStructuralRadioGroup());

      serviceAddProvisionStructuralRadioItem4.setConstraints(VRLayout.FLOW_RETURN);

      addServiceAddProvisionStructuralRadioItem4();
    }
    return serviceAddProvisionStructuralRadioItem4;

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
   * �^�u4���擾���܂��B
   * @return �^�u4
   */
  public ACPanel getTab4(){
    if(tab4==null){

      tab4 = new ACPanel();

      tab4.setFollowChildEnabled(true);

      tab4.setHgap(0);

      addTab4();
    }
    return tab4;

  }

  /**
   * �����s�׌��ナ�n�r�����{���Z���擾���܂��B
   * @return �����s�׌��ナ�n�r�����{���Z
   */
  public ACValueArrayRadioButtonGroup getLifeActsImproveRehabilitationRadioGroup(){
    if(lifeActsImproveRehabilitationRadioGroup==null){

      lifeActsImproveRehabilitationRadioGroup = new ACValueArrayRadioButtonGroup();

      getLifeActsImproveRehabilitationRadioGroupContainer().setText("�����s�׌��ナ�n�r�����{���Z");

      lifeActsImproveRehabilitationRadioGroup.setBindPath("1160124");

      lifeActsImproveRehabilitationRadioGroup.setUseClearButton(false);

      lifeActsImproveRehabilitationRadioGroup.setModel(getLifeActsImproveRehabilitationRadioGroupModel());

      lifeActsImproveRehabilitationRadioGroup.setValues(new int[]{1,2,3});

      addLifeActsImproveRehabilitationRadioGroup();
    }
    return lifeActsImproveRehabilitationRadioGroup;

  }

  /**
   * �����s�׌��ナ�n�r�����{���Z�R���e�i���擾���܂��B
   * @return �����s�׌��ナ�n�r�����{���Z�R���e�i
   */
  protected ACLabelContainer getLifeActsImproveRehabilitationRadioGroupContainer(){
    if(lifeActsImproveRehabilitationRadioGroupContainer==null){
      lifeActsImproveRehabilitationRadioGroupContainer = new ACLabelContainer();
      lifeActsImproveRehabilitationRadioGroupContainer.setFollowChildEnabled(true);
      lifeActsImproveRehabilitationRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      lifeActsImproveRehabilitationRadioGroupContainer.add(getLifeActsImproveRehabilitationRadioGroup(), null);
    }
    return lifeActsImproveRehabilitationRadioGroupContainer;
  }

  /**
   * �����s�׌��ナ�n�r�����{���Z���f�����擾���܂��B
   * @return �����s�׌��ナ�n�r�����{���Z���f��
   */
  protected ACListModelAdapter getLifeActsImproveRehabilitationRadioGroupModel(){
    if(lifeActsImproveRehabilitationRadioGroupModel==null){
      lifeActsImproveRehabilitationRadioGroupModel = new ACListModelAdapter();
      addLifeActsImproveRehabilitationRadioGroupModel();
    }
    return lifeActsImproveRehabilitationRadioGroupModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getLifeActsImproveRehabilitationRadioItem1(){
    if(lifeActsImproveRehabilitationRadioItem1==null){

      lifeActsImproveRehabilitationRadioItem1 = new ACRadioButtonItem();

      lifeActsImproveRehabilitationRadioItem1.setText("�Ȃ�");

      lifeActsImproveRehabilitationRadioItem1.setGroup(getLifeActsImproveRehabilitationRadioGroup());

      lifeActsImproveRehabilitationRadioItem1.setConstraints(VRLayout.FLOW);

      addLifeActsImproveRehabilitationRadioItem1();
    }
    return lifeActsImproveRehabilitationRadioItem1;

  }

  /**
   * 3���ȓ����擾���܂��B
   * @return 3���ȓ�
   */
  public ACRadioButtonItem getLifeActsImproveRehabilitationRadioItem2(){
    if(lifeActsImproveRehabilitationRadioItem2==null){

      lifeActsImproveRehabilitationRadioItem2 = new ACRadioButtonItem();

      lifeActsImproveRehabilitationRadioItem2.setText("3���ȓ�");

      lifeActsImproveRehabilitationRadioItem2.setGroup(getLifeActsImproveRehabilitationRadioGroup());

      lifeActsImproveRehabilitationRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

      addLifeActsImproveRehabilitationRadioItem2();
    }
    return lifeActsImproveRehabilitationRadioItem2;

  }

  /**
   * 3����6���ȓ����擾���܂��B
   * @return 3����6���ȓ�
   */
  public ACRadioButtonItem getLifeActsImproveRehabilitationRadioItem3(){
    if(lifeActsImproveRehabilitationRadioItem3==null){

      lifeActsImproveRehabilitationRadioItem3 = new ACRadioButtonItem();

      lifeActsImproveRehabilitationRadioItem3.setText("3����6���ȓ�");

      lifeActsImproveRehabilitationRadioItem3.setGroup(getLifeActsImproveRehabilitationRadioGroup());

      lifeActsImproveRehabilitationRadioItem3.setConstraints(VRLayout.FLOW_RETURN);

      addLifeActsImproveRehabilitationRadioItem3();
    }
    return lifeActsImproveRehabilitationRadioItem3;

  }

  /**
   * �����s�׌��ナ�n�r���e�[�V������̌p�����Z���擾���܂��B
   * @return �����s�׌��ナ�n�r���e�[�V������̌p�����Z
   */
  public ACValueArrayRadioButtonGroup getLifeActsImproveRehaSubtractionRadioGroup(){
    if(lifeActsImproveRehaSubtractionRadioGroup==null){

      lifeActsImproveRehaSubtractionRadioGroup = new ACValueArrayRadioButtonGroup();

      getLifeActsImproveRehaSubtractionRadioGroupContainer().setText("�����s�׌��ナ�n�r����̌p�����Z");

      lifeActsImproveRehaSubtractionRadioGroup.setBindPath("1160127");

      lifeActsImproveRehaSubtractionRadioGroup.setVisible(true);

      lifeActsImproveRehaSubtractionRadioGroup.setEnabled(true);

      lifeActsImproveRehaSubtractionRadioGroup.setNoSelectIndex(0);

      lifeActsImproveRehaSubtractionRadioGroup.setUseClearButton(false);

      lifeActsImproveRehaSubtractionRadioGroup.setModel(getLifeActsImproveRehaSubtractionRadioGroupModel());

      lifeActsImproveRehaSubtractionRadioGroup.setValues(new int[]{1,2});

      addLifeActsImproveRehaSubtractionRadioGroup();
    }
    return lifeActsImproveRehaSubtractionRadioGroup;

  }

  /**
   * �����s�׌��ナ�n�r���e�[�V������̌p�����Z�R���e�i���擾���܂��B
   * @return �����s�׌��ナ�n�r���e�[�V������̌p�����Z�R���e�i
   */
  protected ACLabelContainer getLifeActsImproveRehaSubtractionRadioGroupContainer(){
    if(lifeActsImproveRehaSubtractionRadioGroupContainer==null){
      lifeActsImproveRehaSubtractionRadioGroupContainer = new ACLabelContainer();
      lifeActsImproveRehaSubtractionRadioGroupContainer.setFollowChildEnabled(true);
      lifeActsImproveRehaSubtractionRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      lifeActsImproveRehaSubtractionRadioGroupContainer.add(getLifeActsImproveRehaSubtractionRadioGroup(), null);
    }
    return lifeActsImproveRehaSubtractionRadioGroupContainer;
  }

  /**
   * �����s�׌��ナ�n�r���e�[�V������̌p�����Z���f�����擾���܂��B
   * @return �����s�׌��ナ�n�r���e�[�V������̌p�����Z���f��
   */
  protected ACListModelAdapter getLifeActsImproveRehaSubtractionRadioGroupModel(){
    if(lifeActsImproveRehaSubtractionRadioGroupModel==null){
      lifeActsImproveRehaSubtractionRadioGroupModel = new ACListModelAdapter();
      addLifeActsImproveRehaSubtractionRadioGroupModel();
    }
    return lifeActsImproveRehaSubtractionRadioGroupModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getLifeActsImproveRehaSubtractionRadioItem1(){
    if(lifeActsImproveRehaSubtractionRadioItem1==null){

      lifeActsImproveRehaSubtractionRadioItem1 = new ACRadioButtonItem();

      lifeActsImproveRehaSubtractionRadioItem1.setText("�Ȃ�");

      lifeActsImproveRehaSubtractionRadioItem1.setGroup(getLifeActsImproveRehaSubtractionRadioGroup());

      lifeActsImproveRehaSubtractionRadioItem1.setConstraints(VRLayout.FLOW);

      addLifeActsImproveRehaSubtractionRadioItem1();
    }
    return lifeActsImproveRehaSubtractionRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getLifeActsImproveRehaSubtractionRadioItem2(){
    if(lifeActsImproveRehaSubtractionRadioItem2==null){

      lifeActsImproveRehaSubtractionRadioItem2 = new ACRadioButtonItem();

      lifeActsImproveRehaSubtractionRadioItem2.setText("����");

      lifeActsImproveRehaSubtractionRadioItem2.setGroup(getLifeActsImproveRehaSubtractionRadioGroup());

      lifeActsImproveRehaSubtractionRadioItem2.setConstraints(VRLayout.FLOW);

      addLifeActsImproveRehaSubtractionRadioItem2();
    }
    return lifeActsImproveRehaSubtractionRadioItem2;

  }

  /**
   * ���d�x�҃P�A�̐����Z���擾���܂��B
   * @return ���d�x�҃P�A�̐����Z
   */
  public ACValueArrayRadioButtonGroup getSevereCareRecipientsAccepted(){
    if(severeCareRecipientsAccepted==null){

      severeCareRecipientsAccepted = new ACValueArrayRadioButtonGroup();

      getSevereCareRecipientsAcceptedContainer().setText("���d�x�҃P�A�̐����Z");

      severeCareRecipientsAccepted.setBindPath("1160125");

      severeCareRecipientsAccepted.setUseClearButton(false);

      severeCareRecipientsAccepted.setModel(getSevereCareRecipientsAcceptedModel());

      severeCareRecipientsAccepted.setValues(new int[]{1,2});

      addSevereCareRecipientsAccepted();
    }
    return severeCareRecipientsAccepted;

  }

  /**
   * ���d�x�҃P�A�̐����Z�R���e�i���擾���܂��B
   * @return ���d�x�҃P�A�̐����Z�R���e�i
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
   * ���d�x�҃P�A�̐����Z���f�����擾���܂��B
   * @return ���d�x�҃P�A�̐����Z���f��
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
   * �Љ�Q���x�����Z���擾���܂��B
   * @return �Љ�Q���x�����Z
   */
  public ACValueArrayRadioButtonGroup getRegionalServiceRadioGroup(){
    if(regionalServiceRadioGroup==null){

      regionalServiceRadioGroup = new ACValueArrayRadioButtonGroup();

      getRegionalServiceRadioGroupContainer().setText("�Љ�Q���x�����Z");

      regionalServiceRadioGroup.setBindPath("1160126");

      regionalServiceRadioGroup.setVisible(true);

      regionalServiceRadioGroup.setEnabled(true);

      regionalServiceRadioGroup.setNoSelectIndex(0);

      regionalServiceRadioGroup.setUseClearButton(false);

      regionalServiceRadioGroup.setModel(getRegionalServiceRadioGroupModel());

      regionalServiceRadioGroup.setValues(new int[]{1,2});

      addRegionalServiceRadioGroup();
    }
    return regionalServiceRadioGroup;

  }

  /**
   * �Љ�Q���x�����Z�R���e�i���擾���܂��B
   * @return �Љ�Q���x�����Z�R���e�i
   */
  protected ACLabelContainer getRegionalServiceRadioGroupContainer(){
    if(regionalServiceRadioGroupContainer==null){
      regionalServiceRadioGroupContainer = new ACLabelContainer();
      regionalServiceRadioGroupContainer.setFollowChildEnabled(true);
      regionalServiceRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      regionalServiceRadioGroupContainer.add(getRegionalServiceRadioGroup(), null);
    }
    return regionalServiceRadioGroupContainer;
  }

  /**
   * �Љ�Q���x�����Z���f�����擾���܂��B
   * @return �Љ�Q���x�����Z���f��
   */
  protected ACListModelAdapter getRegionalServiceRadioGroupModel(){
    if(regionalServiceRadioGroupModel==null){
      regionalServiceRadioGroupModel = new ACListModelAdapter();
      addRegionalServiceRadioGroupModel();
    }
    return regionalServiceRadioGroupModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getRegionalServiceRadioItem1(){
    if(regionalServiceRadioItem1==null){

      regionalServiceRadioItem1 = new ACRadioButtonItem();

      regionalServiceRadioItem1.setText("�Ȃ�");

      regionalServiceRadioItem1.setGroup(getRegionalServiceRadioGroup());

      regionalServiceRadioItem1.setConstraints(VRLayout.FLOW);

      addRegionalServiceRadioItem1();
    }
    return regionalServiceRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getRegionalServiceRadioItem2(){
    if(regionalServiceRadioItem2==null){

      regionalServiceRadioItem2 = new ACRadioButtonItem();

      regionalServiceRadioItem2.setText("����");

      regionalServiceRadioItem2.setGroup(getRegionalServiceRadioGroup());

      regionalServiceRadioItem2.setConstraints(VRLayout.FLOW);

      addRegionalServiceRadioItem2();
    }
    return regionalServiceRadioItem2;

  }

  /**
   * ���n�r���e�[�V�����񋟑̐����Z���擾���܂��B
   * @return ���n�r���e�[�V�����񋟑̐����Z
   */
  public ACValueArrayRadioButtonGroup getRehabilitationSystem(){
    if(rehabilitationSystem==null){

      rehabilitationSystem = new ACValueArrayRadioButtonGroup();

      getRehabilitationSystemContainer().setText("���n�r���e�[�V�����񋟑̐����Z");

      rehabilitationSystem.setBindPath("1160128");

      rehabilitationSystem.setNoSelectIndex(0);

      rehabilitationSystem.setUseClearButton(false);

      rehabilitationSystem.setModel(getRehabilitationSystemModel());

      rehabilitationSystem.setValues(new int[]{1,2});

      addRehabilitationSystem();
    }
    return rehabilitationSystem;

  }

  /**
   * ���n�r���e�[�V�����񋟑̐����Z�R���e�i���擾���܂��B
   * @return ���n�r���e�[�V�����񋟑̐����Z�R���e�i
   */
  protected ACLabelContainer getRehabilitationSystemContainer(){
    if(rehabilitationSystemContainer==null){
      rehabilitationSystemContainer = new ACLabelContainer();
      rehabilitationSystemContainer.setFollowChildEnabled(true);
      rehabilitationSystemContainer.setVAlignment(VRLayout.CENTER);
      rehabilitationSystemContainer.add(getRehabilitationSystem(), null);
    }
    return rehabilitationSystemContainer;
  }

  /**
   * ���n�r���e�[�V�����񋟑̐����Z���f�����擾���܂��B
   * @return ���n�r���e�[�V�����񋟑̐����Z���f��
   */
  protected ACListModelAdapter getRehabilitationSystemModel(){
    if(rehabilitationSystemModel==null){
      rehabilitationSystemModel = new ACListModelAdapter();
      addRehabilitationSystemModel();
    }
    return rehabilitationSystemModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getRehabilitationSystemItem1(){
    if(rehabilitationSystemItem1==null){

      rehabilitationSystemItem1 = new ACRadioButtonItem();

      rehabilitationSystemItem1.setText("�Ȃ�");

      rehabilitationSystemItem1.setGroup(getRehabilitationSystem());

      rehabilitationSystemItem1.setConstraints(VRLayout.FLOW);

      addRehabilitationSystemItem1();
    }
    return rehabilitationSystemItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getRehabilitationSystemItem2(){
    if(rehabilitationSystemItem2==null){

      rehabilitationSystemItem2 = new ACRadioButtonItem();

      rehabilitationSystemItem2.setText("����");

      rehabilitationSystemItem2.setGroup(getRehabilitationSystem());

      rehabilitationSystemItem2.setConstraints(VRLayout.FLOW);

      addRehabilitationSystemItem2();
    }
    return rehabilitationSystemItem2;

  }

  /**
   * �h�{�X�N���[�j���O���Z���擾���܂��B
   * @return �h�{�X�N���[�j���O���Z
   */
  public ACValueArrayRadioButtonGroup getNutritionScreening(){
    if(nutritionScreening==null){

      nutritionScreening = new ACValueArrayRadioButtonGroup();

      getNutritionScreeningContainer().setText("�h�{�X�N���[�j���O���Z");

      nutritionScreening.setBindPath("1160129");

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
  public QS001_11611_201804Design() {

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

    tabs.addTab("3", getTab3());

    tabs.addTab("4", getTab4());

  }

  /**
   * �^�u1�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTab1(){

    tab1.add(getFacilityDivisionRadioGroupContainer(), VRLayout.FLOW_INSETLINE);

    tab1.add(getHoumonRehabilitationTimeDivisionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getHoumonRehabilitationTimeContena(), VRLayout.FLOW_DOUBLEINSETLINE_RETURN);

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

    getFacilityDivisionRadioItem3().setButtonIndex(7);

    getFacilityDivisionRadioGroupModel().add(getFacilityDivisionRadioItem3());

    getFacilityDivisionRadioItem4().setButtonIndex(3);

    getFacilityDivisionRadioGroupModel().add(getFacilityDivisionRadioItem4());

    getFacilityDivisionRadioItem5().setButtonIndex(4);

    getFacilityDivisionRadioGroupModel().add(getFacilityDivisionRadioItem5());

    getFacilityDivisionRadioItem6().setButtonIndex(8);

    getFacilityDivisionRadioGroupModel().add(getFacilityDivisionRadioItem6());

    getFacilityDivisionRadioItem7().setButtonIndex(5);

    getFacilityDivisionRadioGroupModel().add(getFacilityDivisionRadioItem7());

    getFacilityDivisionRadioItem8().setButtonIndex(6);

    getFacilityDivisionRadioGroupModel().add(getFacilityDivisionRadioItem8());

    getFacilityDivisionRadioItem9().setButtonIndex(9);

    getFacilityDivisionRadioGroupModel().add(getFacilityDivisionRadioItem9());

  }

  /**
   * �ʏ�K�́i�a�@�E�f�Ï��j�ɓ������ڂ�ǉ����܂��B
   */
  protected void addFacilityDivisionRadioItem1(){

  }

  /**
   * �ʏ�K�́i�V���{�݁j�ɓ������ڂ�ǉ����܂��B
   */
  protected void addFacilityDivisionRadioItem2(){

  }

  /**
   * �ʏ�K�́i����É@�j�ɓ������ڂ�ǉ����܂��B
   */
  protected void addFacilityDivisionRadioItem3(){

  }

  /**
   * ��K�́iI�j�i�a�@�E�f�Ï��j�ɓ������ڂ�ǉ����܂��B
   */
  protected void addFacilityDivisionRadioItem4(){

  }

  /**
   * ��K�́iI�j�i�V���{�݁j�ɓ������ڂ�ǉ����܂��B
   */
  protected void addFacilityDivisionRadioItem5(){

  }

  /**
   * ��K�́iI�j�i����É@�j�ɓ������ڂ�ǉ����܂��B
   */
  protected void addFacilityDivisionRadioItem6(){

  }

  /**
   * ��K�́iII�j�i�a�@�E�f�Ï��j�ɓ������ڂ�ǉ����܂��B
   */
  protected void addFacilityDivisionRadioItem7(){

  }

  /**
   * ��K�́iII�j�i�V���{�݁j�ɓ������ڂ�ǉ����܂��B
   */
  protected void addFacilityDivisionRadioItem8(){

  }

  /**
   * ��K�́iII�j�i����É@�j�ɓ������ڂ�ǉ����܂��B
   */
  protected void addFacilityDivisionRadioItem9(){

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
   * �^�u2�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTab2(){

    tab2.add(getHoumonRehabilitationSubtractionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getHoumonRehabilitationBathRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getHoumonRehabilitationManagementAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getHoumonRehabilitationShortConcentrationAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getPhysiotherapistStrengthenedAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

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

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonRehabilitationBathRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonRehabilitationBathRadioItem2(){

  }

  /**
   * ���n�r���e�[�V�����}�l�W�����g���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonRehabilitationManagementAddRadio(){

  }

  /**
   * ���n�r���e�[�V�����}�l�W�����g���Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonRehabilitationManagementAddRadioModel(){

    getHoumonRehabilitationManagementAddRadioItem1().setButtonIndex(1);

    getHoumonRehabilitationManagementAddRadioModel().add(getHoumonRehabilitationManagementAddRadioItem1());

    getHoumonRehabilitationManagementAddRadioItem2().setButtonIndex(2);

    getHoumonRehabilitationManagementAddRadioModel().add(getHoumonRehabilitationManagementAddRadioItem2());

    getHoumonRehabilitationManagementAddRadioItem3().setButtonIndex(3);

    getHoumonRehabilitationManagementAddRadioModel().add(getHoumonRehabilitationManagementAddRadioItem3());

    getHoumonRehabilitationManagementAddRadioItem4().setButtonIndex(4);

    getHoumonRehabilitationManagementAddRadioModel().add(getHoumonRehabilitationManagementAddRadioItem4());

    getHoumonRehabilitationManagementAddRadioItem5().setButtonIndex(5);

    getHoumonRehabilitationManagementAddRadioModel().add(getHoumonRehabilitationManagementAddRadioItem5());

    getHoumonRehabilitationManagementAddRadioItem6().setButtonIndex(6);

    getHoumonRehabilitationManagementAddRadioModel().add(getHoumonRehabilitationManagementAddRadioItem6());

    getHoumonRehabilitationManagementAddRadioItem7().setButtonIndex(7);

    getHoumonRehabilitationManagementAddRadioModel().add(getHoumonRehabilitationManagementAddRadioItem7());

    getHoumonRehabilitationManagementAddRadioItem8().setButtonIndex(8);

    getHoumonRehabilitationManagementAddRadioModel().add(getHoumonRehabilitationManagementAddRadioItem8());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonRehabilitationManagementAddRadioItem1(){

  }

  /**
   * I�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonRehabilitationManagementAddRadioItem2(){

  }

  /**
   * II�^(6���ȓ�)�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonRehabilitationManagementAddRadioItem3(){

  }

  /**
   * II�^(6����)�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonRehabilitationManagementAddRadioItem4(){

  }

  /**
   * III�^(6���ȓ�)�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonRehabilitationManagementAddRadioItem5(){

  }

  /**
   * III�^(6����)�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonRehabilitationManagementAddRadioItem6(){

  }

  /**
   * IV�^(6���ȓ�)�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonRehabilitationManagementAddRadioItem7(){

  }

  /**
   * IV�^(6����)�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonRehabilitationManagementAddRadioItem8(){

  }

  /**
   * �Z���W���ʃ��n�r�����{���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonRehabilitationShortConcentrationAddRadio(){

  }

  /**
   * �Z���W���ʃ��n�r�����{���Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonRehabilitationShortConcentrationAddRadioModel(){

    getHoumonRehabilitationShortConcentrationAddRadioItem1().setButtonIndex(1);

    getHoumonRehabilitationShortConcentrationAddRadioModel().add(getHoumonRehabilitationShortConcentrationAddRadioItem1());

    getHoumonRehabilitationShortConcentrationAddRadioItem2().setButtonIndex(2);

    getHoumonRehabilitationShortConcentrationAddRadioModel().add(getHoumonRehabilitationShortConcentrationAddRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonRehabilitationShortConcentrationAddRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonRehabilitationShortConcentrationAddRadioItem2(){

  }

  /**
   * ���w�Ö@�m���̐��������Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPhysiotherapistStrengthenedAddRadioGroup(){

  }

  /**
   * ���w�Ö@�m���̐��������Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addPhysiotherapistStrengthenedAddRadioGroupModel(){

    getPhysiotherapistStrengthenedAddRadioItem1().setButtonIndex(1);

    getPhysiotherapistStrengthenedAddRadioGroupModel().add(getPhysiotherapistStrengthenedAddRadioItem1());

    getPhysiotherapistStrengthenedAddRadioItem2().setButtonIndex(2);

    getPhysiotherapistStrengthenedAddRadioGroupModel().add(getPhysiotherapistStrengthenedAddRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addPhysiotherapistStrengthenedAddRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addPhysiotherapistStrengthenedAddRadioItem2(){

  }

  /**
   * �^�u3�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTab3(){

    tab3.add(getDementiaRehabilitationShortConcentrationAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab3.add(getYoungDementiaPatinetAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab3.add(getHoumonRehabilitationNourishmentManagementAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab3.add(getHoumonRehabilitationMouthFunctionAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab3.add(getMedicalManagementRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab3.add(getTransportationCallRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab3.add(getServiceAddProvisionStructuralRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab3.add(getProviderAddMountainousAreaRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * �F�m�ǒZ���W�����n�r�����{���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addDementiaRehabilitationShortConcentrationAddRadio(){

  }

  /**
   * �F�m�ǒZ���W�����n�r�����{���Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addDementiaRehabilitationShortConcentrationAddRadioModel(){

    getDementiaRehabilitationShortConcentrationAddRadioItem1().setButtonIndex(1);

    getDementiaRehabilitationShortConcentrationAddRadioModel().add(getDementiaRehabilitationShortConcentrationAddRadioItem1());

    getDementiaRehabilitationShortConcentrationAddRadioItem2().setButtonIndex(2);

    getDementiaRehabilitationShortConcentrationAddRadioModel().add(getDementiaRehabilitationShortConcentrationAddRadioItem2());

    getDementiaRehabilitationShortConcentrationAddRadioItem3().setButtonIndex(3);

    getDementiaRehabilitationShortConcentrationAddRadioModel().add(getDementiaRehabilitationShortConcentrationAddRadioItem3());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addDementiaRehabilitationShortConcentrationAddRadioItem1(){

  }

  /**
   * I�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addDementiaRehabilitationShortConcentrationAddRadioItem2(){

  }

  /**
   * II�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addDementiaRehabilitationShortConcentrationAddRadioItem3(){

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
  protected void addHoumonRehabilitationNourishmentManagementAddRadio(){

  }

  /**
   * �h�{���P���Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonRehabilitationNourishmentManagementAddRadioModel(){

    getHoumonRehabilitationNourishmentManagementAddRadioItem1().setButtonIndex(1);

    getHoumonRehabilitationNourishmentManagementAddRadioModel().add(getHoumonRehabilitationNourishmentManagementAddRadioItem1());

    getHoumonRehabilitationNourishmentManagementAddRadioItem2().setButtonIndex(2);

    getHoumonRehabilitationNourishmentManagementAddRadioModel().add(getHoumonRehabilitationNourishmentManagementAddRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonRehabilitationNourishmentManagementAddRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonRehabilitationNourishmentManagementAddRadioItem2(){

  }

  /**
   * ���o�@�\������Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonRehabilitationMouthFunctionAddRadio(){

  }

  /**
   * ���o�@�\������Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonRehabilitationMouthFunctionAddRadioModel(){

    getHoumonRehabilitationMouthFunctionAddRadioItem1().setButtonIndex(1);

    getHoumonRehabilitationMouthFunctionAddRadioModel().add(getHoumonRehabilitationMouthFunctionAddRadioItem1());

    getHoumonRehabilitationMouthFunctionAddRadioItem2().setButtonIndex(2);

    getHoumonRehabilitationMouthFunctionAddRadioModel().add(getHoumonRehabilitationMouthFunctionAddRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonRehabilitationMouthFunctionAddRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonRehabilitationMouthFunctionAddRadioItem2(){

  }

  /**
   * �d�x�×{�Ǘ����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalManagementRadioGroup(){

  }

  /**
   * �d�x�×{�Ǘ����Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalManagementRadioGroupModel(){

    getMedicalManagementRadioItem1().setButtonIndex(1);

    getMedicalManagementRadioGroupModel().add(getMedicalManagementRadioItem1());

    getMedicalManagementRadioItem2().setButtonIndex(2);

    getMedicalManagementRadioGroupModel().add(getMedicalManagementRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalManagementRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalManagementRadioItem2(){

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

    getServiceAddProvisionStructuralRadioItem4().setButtonIndex(4);

    getServiceAddProvisionStructuralRadioGroupModel().add(getServiceAddProvisionStructuralRadioItem4());

    getServiceAddProvisionStructuralRadioItem2().setButtonIndex(2);

    getServiceAddProvisionStructuralRadioGroupModel().add(getServiceAddProvisionStructuralRadioItem2());

    getServiceAddProvisionStructuralRadioItem3().setButtonIndex(3);

    getServiceAddProvisionStructuralRadioGroupModel().add(getServiceAddProvisionStructuralRadioItem3());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceAddProvisionStructuralRadioItem1(){

  }

  /**
   * I�C�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceAddProvisionStructuralRadioItem4(){

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
   * �^�u4�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTab4(){

    tab4.add(getLifeActsImproveRehabilitationRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab4.add(getLifeActsImproveRehaSubtractionRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab4.add(getSevereCareRecipientsAcceptedContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab4.add(getMeetingAndSendingOffContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab4.add(getRegionalServiceRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab4.add(getRehabilitationSystemContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab4.add(getNutritionScreeningContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab4.add(getCalculationDivisionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * �����s�׌��ナ�n�r�����{���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addLifeActsImproveRehabilitationRadioGroup(){

  }

  /**
   * �����s�׌��ナ�n�r�����{���Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addLifeActsImproveRehabilitationRadioGroupModel(){

    getLifeActsImproveRehabilitationRadioItem1().setButtonIndex(1);

    getLifeActsImproveRehabilitationRadioGroupModel().add(getLifeActsImproveRehabilitationRadioItem1());

    getLifeActsImproveRehabilitationRadioItem2().setButtonIndex(2);

    getLifeActsImproveRehabilitationRadioGroupModel().add(getLifeActsImproveRehabilitationRadioItem2());

    getLifeActsImproveRehabilitationRadioItem3().setButtonIndex(3);

    getLifeActsImproveRehabilitationRadioGroupModel().add(getLifeActsImproveRehabilitationRadioItem3());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addLifeActsImproveRehabilitationRadioItem1(){

  }

  /**
   * 3���ȓ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addLifeActsImproveRehabilitationRadioItem2(){

  }

  /**
   * 3����6���ȓ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addLifeActsImproveRehabilitationRadioItem3(){

  }

  /**
   * �����s�׌��ナ�n�r���e�[�V������̌p�����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addLifeActsImproveRehaSubtractionRadioGroup(){

  }

  /**
   * �����s�׌��ナ�n�r���e�[�V������̌p�����Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addLifeActsImproveRehaSubtractionRadioGroupModel(){

    getLifeActsImproveRehaSubtractionRadioItem1().setButtonIndex(1);

    getLifeActsImproveRehaSubtractionRadioGroupModel().add(getLifeActsImproveRehaSubtractionRadioItem1());

    getLifeActsImproveRehaSubtractionRadioItem2().setButtonIndex(2);

    getLifeActsImproveRehaSubtractionRadioGroupModel().add(getLifeActsImproveRehaSubtractionRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addLifeActsImproveRehaSubtractionRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addLifeActsImproveRehaSubtractionRadioItem2(){

  }

  /**
   * ���d�x�҃P�A�̐����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addSevereCareRecipientsAccepted(){

  }

  /**
   * ���d�x�҃P�A�̐����Z���f���ɓ������ڂ�ǉ����܂��B
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
   * �Љ�Q���x�����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addRegionalServiceRadioGroup(){

  }

  /**
   * �Љ�Q���x�����Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addRegionalServiceRadioGroupModel(){

    getRegionalServiceRadioItem1().setButtonIndex(1);

    getRegionalServiceRadioGroupModel().add(getRegionalServiceRadioItem1());

    getRegionalServiceRadioItem2().setButtonIndex(2);

    getRegionalServiceRadioGroupModel().add(getRegionalServiceRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addRegionalServiceRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addRegionalServiceRadioItem2(){

  }

  /**
   * ���n�r���e�[�V�����񋟑̐����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addRehabilitationSystem(){

  }

  /**
   * ���n�r���e�[�V�����񋟑̐����Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addRehabilitationSystemModel(){

    getRehabilitationSystemItem1().setButtonIndex(1);

    getRehabilitationSystemModel().add(getRehabilitationSystemItem1());

    getRehabilitationSystemItem2().setButtonIndex(2);

    getRehabilitationSystemModel().add(getRehabilitationSystemItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addRehabilitationSystemItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addRehabilitationSystemItem2(){

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
      ACFrame.debugStart(new ACAffairInfo(QS001_11611_201804Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QS001_11611_201804Design getThis() {
    return this;
  }
}
