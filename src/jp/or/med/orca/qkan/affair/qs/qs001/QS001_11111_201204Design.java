
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
 * �쐬��: 2012/03/05  ���{�R���s���[�^�[������� ����@��F �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �\��Ǘ� (S)
 * �v���Z�X �T�[�r�X�\�� (001)
 * �v���O���� �T�[�r�X�p�^�[���K���� (QS001_11111_201204)
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
 * �T�[�r�X�p�^�[���K�����ʍ��ڃf�U�C��(QS001_11111_201204) 
 */
public class QS001_11111_201204Design extends QS001ServicePanel {
  //GUI�R���|�[�l���g

  private JTabbedPane tabs;

  private ACPanel tab1;

  private ACComboBox houmonKaigoServicePattern;

  private ACLabelContainer houmonKaigoServicePatternContainer;

  private ACComboBoxModelAdapter houmonKaigoServicePatternModel;

  private ACComboBox homonkaigoTeikyoTime;

  private ACLabelContainer homonkaigoTeikyoTimeContainer;

  private ACComboBoxModelAdapter homonkaigoTeikyoTimeModel;

  private ACComboBox houmonKaigoInTime;

  private ACLabelContainer houmonKaigoInTimeContainer;

  private ACComboBoxModelAdapter houmonKaigoInTimeModel;

  private ACValueArrayRadioButtonGroup houmonKaigoClass;

  private ACLabelContainer houmonKaigoClassContainer;

  private ACListModelAdapter houmonKaigoClassModel;

  private ACRadioButtonItem houmonKaigoClassOther;

  private ACRadioButtonItem houmonKaigoClass3;

  private ACValueArrayRadioButtonGroup houmonKaigoNumberOfPeople;

  private ACLabelContainer houmonKaigoNumberOfPeopleContainer;

  private ACListModelAdapter houmonKaigoNumberOfPeopleModel;

  private ACRadioButtonItem houmonKaigoNumberOfPeople1;

  private ACRadioButtonItem houmonKaigoNumberOfPeople2;

  private ACValueArrayRadioButtonGroup houmonKaigoTimeZone;

  private ACLabelContainer houmonKaigoTimeZoneContainer;

  private ACListModelAdapter houmonKaigoTimeZoneModel;

  private ACRadioButtonItem houmonKaigoTimeZoneNormal;

  private ACRadioButtonItem houmonKaigoTimeZoneEarlyMorning;

  private ACRadioButtonItem houmonKaigoTimeZoneNighttime;

  private ACRadioButtonItem houmonKaigoTimeZoneMidnight;

  private ACValueArrayRadioButtonGroup specificProviderAddRadio;

  private ACLabelContainer specificProviderAddRadioContainer;

  private ACListModelAdapter specificProviderAddRadioModel;

  private ACRadioButtonItem specificProviderAddRadioItem1;

  private ACRadioButtonItem specificProviderAddRadioItem2;

  private ACRadioButtonItem specificProviderAddRadioItem3;

  private ACRadioButtonItem specificProviderAddRadioItem4;

  private ACValueArrayRadioButtonGroup houmonKaigoFirstAddRadioGroup;

  private ACLabelContainer houmonKaigoFirstAddRadioGroupContainer;

  private ACListModelAdapter houmonKaigoFirstAddRadioGroupModel;

  private ACRadioButtonItem houmonKaigoFirstAddRadioItem1;

  private ACRadioButtonItem houmonKaigoFirstAddRadioItem2;

  private ACValueArrayRadioButtonGroup rehabilitationSpecialistPersonnelCooperationRadioGroup;

  private ACLabelContainer rehabilitationSpecialistPersonnelCooperationRadioGroupContainer;

  private ACListModelAdapter rehabilitationSpecialistPersonnelCooperationRadioGroupModel;

  private ACRadioButtonItem rehabilitationSpecialistPersonnelCooperationItem1;

  private ACRadioButtonItem rehabilitationSpecialistPersonnelCooperationItem2;

  private ACValueArrayRadioButtonGroup houmonKaigoEmergencyAddRadioGroup;

  private ACLabelContainer houmonKaigoEmergencyAddRadioGroupContainer;

  private ACListModelAdapter houmonKaigoEmergencyAddRadioGroupModel;

  private ACRadioButtonItem houmonKaigoEmergencyAddRadioItem1;

  private ACRadioButtonItem houmonKaigoEmergencyAddRadioItem2;

  private ACBackLabelContainer houmonKaigoTimeContainer;

  private ACTimeComboBox houmonKaigoBeginTime;

  private ACLabelContainer houmonKaigoBeginTimeContainer;

  private ACComboBoxModelAdapter houmonKaigoBeginTimeModel;

  private ACTimeComboBox houmonKaigoEndTime;

  private ACLabelContainer houmonKaigoEndTimeContainer;

  private ACComboBoxModelAdapter houmonKaigoEndTimeModel;

  private ACPanel tab2;

  private ACValueArrayRadioButtonGroup providerAddMountainousAreaRafioRadioGroup;

  private ACLabelContainer providerAddMountainousAreaRafioRadioGroupContainer;

  private ACListModelAdapter providerAddMountainousAreaRafioRadioGroupModel;

  private ACRadioButtonItem providerAddMountainousAreaRafioItem1;

  private ACRadioButtonItem providerAddMountainousAreaRafioRadioItem2;

  private ACValueArrayRadioButtonGroup houmonNeededRadio;

  private ACLabelContainer houmonNeededRadioContainer;

  private ACListModelAdapter houmonNeededRadioModel;

  private ACRadioButtonItem houmonNeededRadioItem1;

  private ACRadioButtonItem houmonNeededRadioItem2;

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
   * �T�[�r�X�R���{���擾���܂��B
   * @return �T�[�r�X�R���{
   */
  public ACComboBox getHoumonKaigoServicePattern(){
    if(houmonKaigoServicePattern==null){

      houmonKaigoServicePattern = new ACComboBox();

      getHoumonKaigoServicePatternContainer().setText("�K����");

      houmonKaigoServicePattern.setBindPath("1110101");

      houmonKaigoServicePattern.setEditable(false);

      houmonKaigoServicePattern.setModelBindPath("1110101");

      houmonKaigoServicePattern.setRenderBindPath("CONTENT");

      houmonKaigoServicePattern.setModel(getHoumonKaigoServicePatternModel());

      addHoumonKaigoServicePattern();
    }
    return houmonKaigoServicePattern;

  }

  /**
   * �T�[�r�X�R���{�R���e�i���擾���܂��B
   * @return �T�[�r�X�R���{�R���e�i
   */
  protected ACLabelContainer getHoumonKaigoServicePatternContainer(){
    if(houmonKaigoServicePatternContainer==null){
      houmonKaigoServicePatternContainer = new ACLabelContainer();
      houmonKaigoServicePatternContainer.setFollowChildEnabled(true);
      houmonKaigoServicePatternContainer.setVAlignment(VRLayout.CENTER);
      houmonKaigoServicePatternContainer.add(getHoumonKaigoServicePattern(), null);
    }
    return houmonKaigoServicePatternContainer;
  }

  /**
   * �T�[�r�X�R���{���f�����擾���܂��B
   * @return �T�[�r�X�R���{���f��
   */
  protected ACComboBoxModelAdapter getHoumonKaigoServicePatternModel(){
    if(houmonKaigoServicePatternModel==null){
      houmonKaigoServicePatternModel = new ACComboBoxModelAdapter();
      addHoumonKaigoServicePatternModel();
    }
    return houmonKaigoServicePatternModel;
  }

  /**
   * �g�̉����擾���܂��B
   * @return �g�̉��
   */
  public ACComboBox getHomonkaigoTeikyoTime(){
    if(homonkaigoTeikyoTime==null){

      homonkaigoTeikyoTime = new ACComboBox();

      getHomonkaigoTeikyoTimeContainer().setText("�g�̉��");

      homonkaigoTeikyoTime.setBindPath("1110104");

      homonkaigoTeikyoTime.setEditable(false);

      homonkaigoTeikyoTime.setModelBindPath("1110104");

      homonkaigoTeikyoTime.setRenderBindPath("CONTENT");

      homonkaigoTeikyoTime.setBlankable(false);

      homonkaigoTeikyoTime.setModel(getHomonkaigoTeikyoTimeModel());

      addHomonkaigoTeikyoTime();
    }
    return homonkaigoTeikyoTime;

  }

  /**
   * �g�̉��R���e�i���擾���܂��B
   * @return �g�̉��R���e�i
   */
  protected ACLabelContainer getHomonkaigoTeikyoTimeContainer(){
    if(homonkaigoTeikyoTimeContainer==null){
      homonkaigoTeikyoTimeContainer = new ACLabelContainer();
      homonkaigoTeikyoTimeContainer.setFollowChildEnabled(true);
      homonkaigoTeikyoTimeContainer.setVAlignment(VRLayout.CENTER);
      homonkaigoTeikyoTimeContainer.add(getHomonkaigoTeikyoTime(), null);
    }
    return homonkaigoTeikyoTimeContainer;
  }

  /**
   * �g�̉�샂�f�����擾���܂��B
   * @return �g�̉�샂�f��
   */
  protected ACComboBoxModelAdapter getHomonkaigoTeikyoTimeModel(){
    if(homonkaigoTeikyoTimeModel==null){
      homonkaigoTeikyoTimeModel = new ACComboBoxModelAdapter();
      addHomonkaigoTeikyoTimeModel();
    }
    return homonkaigoTeikyoTimeModel;
  }

  /**
   * �����������擾���܂��B
   * @return ��������
   */
  public ACComboBox getHoumonKaigoInTime(){
    if(houmonKaigoInTime==null){

      houmonKaigoInTime = new ACComboBox();

      getHoumonKaigoInTimeContainer().setText("��������");

      houmonKaigoInTime.setBindPath("1110105");

      houmonKaigoInTime.setEditable(false);

      houmonKaigoInTime.setModelBindPath("1110105");

      houmonKaigoInTime.setRenderBindPath("CONTENT");

      houmonKaigoInTime.setModel(getHoumonKaigoInTimeModel());

      addHoumonKaigoInTime();
    }
    return houmonKaigoInTime;

  }

  /**
   * ���������R���e�i���擾���܂��B
   * @return ���������R���e�i
   */
  protected ACLabelContainer getHoumonKaigoInTimeContainer(){
    if(houmonKaigoInTimeContainer==null){
      houmonKaigoInTimeContainer = new ACLabelContainer();
      houmonKaigoInTimeContainer.setFollowChildEnabled(true);
      houmonKaigoInTimeContainer.setVAlignment(VRLayout.CENTER);
      houmonKaigoInTimeContainer.add(getHoumonKaigoInTime(), null);
    }
    return houmonKaigoInTimeContainer;
  }

  /**
   * �����������f�����擾���܂��B
   * @return �����������f��
   */
  protected ACComboBoxModelAdapter getHoumonKaigoInTimeModel(){
    if(houmonKaigoInTimeModel==null){
      houmonKaigoInTimeModel = new ACComboBoxModelAdapter();
      addHoumonKaigoInTimeModel();
    }
    return houmonKaigoInTimeModel;
  }

  /**
   * �T�[�r�X�񋟐ӔC�҂̋��E���擾���܂��B
   * @return �T�[�r�X�񋟐ӔC�҂̋��E
   */
  public ACValueArrayRadioButtonGroup getHoumonKaigoClass(){
    if(houmonKaigoClass==null){

      houmonKaigoClass = new ACValueArrayRadioButtonGroup();

      getHoumonKaigoClassContainer().setText("�T�[�r�X�񋟐ӔC�҂̋��E");

      houmonKaigoClass.setBindPath("1110113");

      houmonKaigoClass.setUseClearButton(false);

      houmonKaigoClass.setModel(getHoumonKaigoClassModel());

      houmonKaigoClass.setValues(new int[]{1,2});

      addHoumonKaigoClass();
    }
    return houmonKaigoClass;

  }

  /**
   * �T�[�r�X�񋟐ӔC�҂̋��E�R���e�i���擾���܂��B
   * @return �T�[�r�X�񋟐ӔC�҂̋��E�R���e�i
   */
  protected ACLabelContainer getHoumonKaigoClassContainer(){
    if(houmonKaigoClassContainer==null){
      houmonKaigoClassContainer = new ACLabelContainer();
      houmonKaigoClassContainer.setFollowChildEnabled(true);
      houmonKaigoClassContainer.setVAlignment(VRLayout.CENTER);
      houmonKaigoClassContainer.add(getHoumonKaigoClass(), null);
    }
    return houmonKaigoClassContainer;
  }

  /**
   * �T�[�r�X�񋟐ӔC�҂̋��E���f�����擾���܂��B
   * @return �T�[�r�X�񋟐ӔC�҂̋��E���f��
   */
  protected ACListModelAdapter getHoumonKaigoClassModel(){
    if(houmonKaigoClassModel==null){
      houmonKaigoClassModel = new ACListModelAdapter();
      addHoumonKaigoClassModel();
    }
    return houmonKaigoClassModel;
  }

  /**
   * 2���ȊO���擾���܂��B
   * @return 2���ȊO
   */
  public ACRadioButtonItem getHoumonKaigoClassOther(){
    if(houmonKaigoClassOther==null){

      houmonKaigoClassOther = new ACRadioButtonItem();

      houmonKaigoClassOther.setText("2���ȊO");

      houmonKaigoClassOther.setGroup(getHoumonKaigoClass());

      addHoumonKaigoClassOther();
    }
    return houmonKaigoClassOther;

  }

  /**
   * 2�����擾���܂��B
   * @return 2��
   */
  public ACRadioButtonItem getHoumonKaigoClass3(){
    if(houmonKaigoClass3==null){

      houmonKaigoClass3 = new ACRadioButtonItem();

      houmonKaigoClass3.setText("2��");

      houmonKaigoClass3.setGroup(getHoumonKaigoClass());

      addHoumonKaigoClass3();
    }
    return houmonKaigoClass3;

  }

  /**
   * �K��l�����擾���܂��B
   * @return �K��l��
   */
  public ACValueArrayRadioButtonGroup getHoumonKaigoNumberOfPeople(){
    if(houmonKaigoNumberOfPeople==null){

      houmonKaigoNumberOfPeople = new ACValueArrayRadioButtonGroup();

      getHoumonKaigoNumberOfPeopleContainer().setText("�K��l��");

      houmonKaigoNumberOfPeople.setBindPath("1110107");

      houmonKaigoNumberOfPeople.setUseClearButton(false);

      houmonKaigoNumberOfPeople.setModel(getHoumonKaigoNumberOfPeopleModel());

      houmonKaigoNumberOfPeople.setValues(new int[]{1,2});

      addHoumonKaigoNumberOfPeople();
    }
    return houmonKaigoNumberOfPeople;

  }

  /**
   * �K��l���R���e�i���擾���܂��B
   * @return �K��l���R���e�i
   */
  protected ACLabelContainer getHoumonKaigoNumberOfPeopleContainer(){
    if(houmonKaigoNumberOfPeopleContainer==null){
      houmonKaigoNumberOfPeopleContainer = new ACLabelContainer();
      houmonKaigoNumberOfPeopleContainer.setFollowChildEnabled(true);
      houmonKaigoNumberOfPeopleContainer.setVAlignment(VRLayout.CENTER);
      houmonKaigoNumberOfPeopleContainer.add(getHoumonKaigoNumberOfPeople(), null);
    }
    return houmonKaigoNumberOfPeopleContainer;
  }

  /**
   * �K��l�����f�����擾���܂��B
   * @return �K��l�����f��
   */
  protected ACListModelAdapter getHoumonKaigoNumberOfPeopleModel(){
    if(houmonKaigoNumberOfPeopleModel==null){
      houmonKaigoNumberOfPeopleModel = new ACListModelAdapter();
      addHoumonKaigoNumberOfPeopleModel();
    }
    return houmonKaigoNumberOfPeopleModel;
  }

  /**
   * 1�l���擾���܂��B
   * @return 1�l
   */
  public ACRadioButtonItem getHoumonKaigoNumberOfPeople1(){
    if(houmonKaigoNumberOfPeople1==null){

      houmonKaigoNumberOfPeople1 = new ACRadioButtonItem();

      houmonKaigoNumberOfPeople1.setText("1�l");

      houmonKaigoNumberOfPeople1.setGroup(getHoumonKaigoNumberOfPeople());

      addHoumonKaigoNumberOfPeople1();
    }
    return houmonKaigoNumberOfPeople1;

  }

  /**
   * 2�l���擾���܂��B
   * @return 2�l
   */
  public ACRadioButtonItem getHoumonKaigoNumberOfPeople2(){
    if(houmonKaigoNumberOfPeople2==null){

      houmonKaigoNumberOfPeople2 = new ACRadioButtonItem();

      houmonKaigoNumberOfPeople2.setText("2�l");

      houmonKaigoNumberOfPeople2.setGroup(getHoumonKaigoNumberOfPeople());

      addHoumonKaigoNumberOfPeople2();
    }
    return houmonKaigoNumberOfPeople2;

  }

  /**
   * ���ԑт��擾���܂��B
   * @return ���ԑ�
   */
  public ACValueArrayRadioButtonGroup getHoumonKaigoTimeZone(){
    if(houmonKaigoTimeZone==null){

      houmonKaigoTimeZone = new ACValueArrayRadioButtonGroup();

      getHoumonKaigoTimeZoneContainer().setText("���ԑ�");

      houmonKaigoTimeZone.setBindPath("1110108");

      houmonKaigoTimeZone.setUseClearButton(false);

      houmonKaigoTimeZone.setModel(getHoumonKaigoTimeZoneModel());

      houmonKaigoTimeZone.setValues(new int[]{1,2,3,4});

      addHoumonKaigoTimeZone();
    }
    return houmonKaigoTimeZone;

  }

  /**
   * ���ԑуR���e�i���擾���܂��B
   * @return ���ԑуR���e�i
   */
  protected ACLabelContainer getHoumonKaigoTimeZoneContainer(){
    if(houmonKaigoTimeZoneContainer==null){
      houmonKaigoTimeZoneContainer = new ACLabelContainer();
      houmonKaigoTimeZoneContainer.setFollowChildEnabled(true);
      houmonKaigoTimeZoneContainer.setVAlignment(VRLayout.CENTER);
      houmonKaigoTimeZoneContainer.add(getHoumonKaigoTimeZone(), null);
    }
    return houmonKaigoTimeZoneContainer;
  }

  /**
   * ���ԑу��f�����擾���܂��B
   * @return ���ԑу��f��
   */
  protected ACListModelAdapter getHoumonKaigoTimeZoneModel(){
    if(houmonKaigoTimeZoneModel==null){
      houmonKaigoTimeZoneModel = new ACListModelAdapter();
      addHoumonKaigoTimeZoneModel();
    }
    return houmonKaigoTimeZoneModel;
  }

  /**
   * �ʏ���擾���܂��B
   * @return �ʏ�
   */
  public ACRadioButtonItem getHoumonKaigoTimeZoneNormal(){
    if(houmonKaigoTimeZoneNormal==null){

      houmonKaigoTimeZoneNormal = new ACRadioButtonItem();

      houmonKaigoTimeZoneNormal.setText("�ʏ�");

      houmonKaigoTimeZoneNormal.setGroup(getHoumonKaigoTimeZone());

      addHoumonKaigoTimeZoneNormal();
    }
    return houmonKaigoTimeZoneNormal;

  }

  /**
   * �������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getHoumonKaigoTimeZoneEarlyMorning(){
    if(houmonKaigoTimeZoneEarlyMorning==null){

      houmonKaigoTimeZoneEarlyMorning = new ACRadioButtonItem();

      houmonKaigoTimeZoneEarlyMorning.setText("����");

      houmonKaigoTimeZoneEarlyMorning.setGroup(getHoumonKaigoTimeZone());

      addHoumonKaigoTimeZoneEarlyMorning();
    }
    return houmonKaigoTimeZoneEarlyMorning;

  }

  /**
   * ��Ԃ��擾���܂��B
   * @return ���
   */
  public ACRadioButtonItem getHoumonKaigoTimeZoneNighttime(){
    if(houmonKaigoTimeZoneNighttime==null){

      houmonKaigoTimeZoneNighttime = new ACRadioButtonItem();

      houmonKaigoTimeZoneNighttime.setText("���");

      houmonKaigoTimeZoneNighttime.setGroup(getHoumonKaigoTimeZone());

      addHoumonKaigoTimeZoneNighttime();
    }
    return houmonKaigoTimeZoneNighttime;

  }

  /**
   * �[����擾���܂��B
   * @return �[��
   */
  public ACRadioButtonItem getHoumonKaigoTimeZoneMidnight(){
    if(houmonKaigoTimeZoneMidnight==null){

      houmonKaigoTimeZoneMidnight = new ACRadioButtonItem();

      houmonKaigoTimeZoneMidnight.setText("�[��");

      houmonKaigoTimeZoneMidnight.setGroup(getHoumonKaigoTimeZone());

      addHoumonKaigoTimeZoneMidnight();
    }
    return houmonKaigoTimeZoneMidnight;

  }

  /**
   * ���莖�Ə����Z���擾���܂��B
   * @return ���莖�Ə����Z
   */
  public ACValueArrayRadioButtonGroup getSpecificProviderAddRadio(){
    if(specificProviderAddRadio==null){

      specificProviderAddRadio = new ACValueArrayRadioButtonGroup();

      getSpecificProviderAddRadioContainer().setText("���莖�Ə����Z");

      specificProviderAddRadio.setBindPath("1110109");

      specificProviderAddRadio.setUseClearButton(false);

      specificProviderAddRadio.setModel(getSpecificProviderAddRadioModel());

      specificProviderAddRadio.setValues(new int[]{1,2,3,4});

      addSpecificProviderAddRadio();
    }
    return specificProviderAddRadio;

  }

  /**
   * ���莖�Ə����Z�R���e�i���擾���܂��B
   * @return ���莖�Ə����Z�R���e�i
   */
  protected ACLabelContainer getSpecificProviderAddRadioContainer(){
    if(specificProviderAddRadioContainer==null){
      specificProviderAddRadioContainer = new ACLabelContainer();
      specificProviderAddRadioContainer.setFollowChildEnabled(true);
      specificProviderAddRadioContainer.setVAlignment(VRLayout.CENTER);
      specificProviderAddRadioContainer.add(getSpecificProviderAddRadio(), null);
    }
    return specificProviderAddRadioContainer;
  }

  /**
   * ���莖�Ə����Z���f�����擾���܂��B
   * @return ���莖�Ə����Z���f��
   */
  protected ACListModelAdapter getSpecificProviderAddRadioModel(){
    if(specificProviderAddRadioModel==null){
      specificProviderAddRadioModel = new ACListModelAdapter();
      addSpecificProviderAddRadioModel();
    }
    return specificProviderAddRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getSpecificProviderAddRadioItem1(){
    if(specificProviderAddRadioItem1==null){

      specificProviderAddRadioItem1 = new ACRadioButtonItem();

      specificProviderAddRadioItem1.setText("�Ȃ�");

      specificProviderAddRadioItem1.setGroup(getSpecificProviderAddRadio());

      specificProviderAddRadioItem1.setConstraints(VRLayout.FLOW);

      addSpecificProviderAddRadioItem1();
    }
    return specificProviderAddRadioItem1;

  }

  /**
   * I�^���擾���܂��B
   * @return I�^
   */
  public ACRadioButtonItem getSpecificProviderAddRadioItem2(){
    if(specificProviderAddRadioItem2==null){

      specificProviderAddRadioItem2 = new ACRadioButtonItem();

      specificProviderAddRadioItem2.setText("I�^");

      specificProviderAddRadioItem2.setGroup(getSpecificProviderAddRadio());

      specificProviderAddRadioItem2.setConstraints(VRLayout.FLOW);

      addSpecificProviderAddRadioItem2();
    }
    return specificProviderAddRadioItem2;

  }

  /**
   * II�^���擾���܂��B
   * @return II�^
   */
  public ACRadioButtonItem getSpecificProviderAddRadioItem3(){
    if(specificProviderAddRadioItem3==null){

      specificProviderAddRadioItem3 = new ACRadioButtonItem();

      specificProviderAddRadioItem3.setText("II�^");

      specificProviderAddRadioItem3.setGroup(getSpecificProviderAddRadio());

      specificProviderAddRadioItem3.setConstraints(VRLayout.FLOW);

      addSpecificProviderAddRadioItem3();
    }
    return specificProviderAddRadioItem3;

  }

  /**
   * III�^���擾���܂��B
   * @return III�^
   */
  public ACRadioButtonItem getSpecificProviderAddRadioItem4(){
    if(specificProviderAddRadioItem4==null){

      specificProviderAddRadioItem4 = new ACRadioButtonItem();

      specificProviderAddRadioItem4.setText("III�^");

      specificProviderAddRadioItem4.setGroup(getSpecificProviderAddRadio());

      specificProviderAddRadioItem4.setConstraints(VRLayout.FLOW);

      addSpecificProviderAddRadioItem4();
    }
    return specificProviderAddRadioItem4;

  }

  /**
   * ������Z���擾���܂��B
   * @return ������Z
   */
  public ACValueArrayRadioButtonGroup getHoumonKaigoFirstAddRadioGroup(){
    if(houmonKaigoFirstAddRadioGroup==null){

      houmonKaigoFirstAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getHoumonKaigoFirstAddRadioGroupContainer().setText("������Z");

      houmonKaigoFirstAddRadioGroup.setBindPath("1110110");

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
   * �����@�\����A�g���Z���擾���܂��B
   * @return �����@�\����A�g���Z
   */
  public ACValueArrayRadioButtonGroup getRehabilitationSpecialistPersonnelCooperationRadioGroup(){
    if(rehabilitationSpecialistPersonnelCooperationRadioGroup==null){

      rehabilitationSpecialistPersonnelCooperationRadioGroup = new ACValueArrayRadioButtonGroup();

      getRehabilitationSpecialistPersonnelCooperationRadioGroupContainer().setText("�����@�\����A�g���Z");

      rehabilitationSpecialistPersonnelCooperationRadioGroup.setBindPath("1110112");

      rehabilitationSpecialistPersonnelCooperationRadioGroup.setNoSelectIndex(0);

      rehabilitationSpecialistPersonnelCooperationRadioGroup.setUseClearButton(false);

      rehabilitationSpecialistPersonnelCooperationRadioGroup.setModel(getRehabilitationSpecialistPersonnelCooperationRadioGroupModel());

      rehabilitationSpecialistPersonnelCooperationRadioGroup.setValues(new int[]{1,2});

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
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getRehabilitationSpecialistPersonnelCooperationItem2(){
    if(rehabilitationSpecialistPersonnelCooperationItem2==null){

      rehabilitationSpecialistPersonnelCooperationItem2 = new ACRadioButtonItem();

      rehabilitationSpecialistPersonnelCooperationItem2.setText("����");

      rehabilitationSpecialistPersonnelCooperationItem2.setGroup(getRehabilitationSpecialistPersonnelCooperationRadioGroup());

      rehabilitationSpecialistPersonnelCooperationItem2.setConstraints(VRLayout.FLOW);

      addRehabilitationSpecialistPersonnelCooperationItem2();
    }
    return rehabilitationSpecialistPersonnelCooperationItem2;

  }

  /**
   * �ً}���K������Z���擾���܂��B
   * @return �ً}���K������Z
   */
  public ACValueArrayRadioButtonGroup getHoumonKaigoEmergencyAddRadioGroup(){
    if(houmonKaigoEmergencyAddRadioGroup==null){

      houmonKaigoEmergencyAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getHoumonKaigoEmergencyAddRadioGroupContainer().setText("�ً}���K������Z");

      houmonKaigoEmergencyAddRadioGroup.setBindPath("1110111");

      houmonKaigoEmergencyAddRadioGroup.setNoSelectIndex(0);

      houmonKaigoEmergencyAddRadioGroup.setUseClearButton(false);

      houmonKaigoEmergencyAddRadioGroup.setModel(getHoumonKaigoEmergencyAddRadioGroupModel());

      houmonKaigoEmergencyAddRadioGroup.setValues(new int[]{1,2});

      addHoumonKaigoEmergencyAddRadioGroup();
    }
    return houmonKaigoEmergencyAddRadioGroup;

  }

  /**
   * �ً}���K������Z�R���e�i���擾���܂��B
   * @return �ً}���K������Z�R���e�i
   */
  protected ACLabelContainer getHoumonKaigoEmergencyAddRadioGroupContainer(){
    if(houmonKaigoEmergencyAddRadioGroupContainer==null){
      houmonKaigoEmergencyAddRadioGroupContainer = new ACLabelContainer();
      houmonKaigoEmergencyAddRadioGroupContainer.setFollowChildEnabled(true);
      houmonKaigoEmergencyAddRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      houmonKaigoEmergencyAddRadioGroupContainer.add(getHoumonKaigoEmergencyAddRadioGroup(), null);
    }
    return houmonKaigoEmergencyAddRadioGroupContainer;
  }

  /**
   * �ً}���K������Z���f�����擾���܂��B
   * @return �ً}���K������Z���f��
   */
  protected ACListModelAdapter getHoumonKaigoEmergencyAddRadioGroupModel(){
    if(houmonKaigoEmergencyAddRadioGroupModel==null){
      houmonKaigoEmergencyAddRadioGroupModel = new ACListModelAdapter();
      addHoumonKaigoEmergencyAddRadioGroupModel();
    }
    return houmonKaigoEmergencyAddRadioGroupModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getHoumonKaigoEmergencyAddRadioItem1(){
    if(houmonKaigoEmergencyAddRadioItem1==null){

      houmonKaigoEmergencyAddRadioItem1 = new ACRadioButtonItem();

      houmonKaigoEmergencyAddRadioItem1.setText("�Ȃ�");

      houmonKaigoEmergencyAddRadioItem1.setGroup(getHoumonKaigoEmergencyAddRadioGroup());

      houmonKaigoEmergencyAddRadioItem1.setConstraints(VRLayout.FLOW);

      addHoumonKaigoEmergencyAddRadioItem1();
    }
    return houmonKaigoEmergencyAddRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getHoumonKaigoEmergencyAddRadioItem2(){
    if(houmonKaigoEmergencyAddRadioItem2==null){

      houmonKaigoEmergencyAddRadioItem2 = new ACRadioButtonItem();

      houmonKaigoEmergencyAddRadioItem2.setText("����");

      houmonKaigoEmergencyAddRadioItem2.setGroup(getHoumonKaigoEmergencyAddRadioGroup());

      houmonKaigoEmergencyAddRadioItem2.setConstraints(VRLayout.FLOW);

      addHoumonKaigoEmergencyAddRadioItem2();
    }
    return houmonKaigoEmergencyAddRadioItem2;

  }

  /**
   * �񋟎��ԃR���e�i���擾���܂��B
   * @return �񋟎��ԃR���e�i
   */
  public ACBackLabelContainer getHoumonKaigoTimeContainer(){
    if(houmonKaigoTimeContainer==null){

      houmonKaigoTimeContainer = new ACBackLabelContainer();

      houmonKaigoTimeContainer.setFollowChildEnabled(true);

      addHoumonKaigoTimeContainer();
    }
    return houmonKaigoTimeContainer;

  }

  /**
   * �J�n�����R���{���擾���܂��B
   * @return �J�n�����R���{
   */
  public ACTimeComboBox getHoumonKaigoBeginTime(){
    if(houmonKaigoBeginTime==null){

      houmonKaigoBeginTime = new ACTimeComboBox();

      getHoumonKaigoBeginTimeContainer().setText("�J�n����");

      houmonKaigoBeginTime.setBindPath("3");

      houmonKaigoBeginTime.setModelBindPath("3");

      houmonKaigoBeginTime.setRenderBindPath("CONTENT");

      houmonKaigoBeginTime.setModel(getHoumonKaigoBeginTimeModel());

      addHoumonKaigoBeginTime();
    }
    return houmonKaigoBeginTime;

  }

  /**
   * �J�n�����R���{�R���e�i���擾���܂��B
   * @return �J�n�����R���{�R���e�i
   */
  protected ACLabelContainer getHoumonKaigoBeginTimeContainer(){
    if(houmonKaigoBeginTimeContainer==null){
      houmonKaigoBeginTimeContainer = new ACLabelContainer();
      houmonKaigoBeginTimeContainer.setFollowChildEnabled(true);
      houmonKaigoBeginTimeContainer.setVAlignment(VRLayout.CENTER);
      houmonKaigoBeginTimeContainer.add(getHoumonKaigoBeginTime(), null);
    }
    return houmonKaigoBeginTimeContainer;
  }

  /**
   * �J�n�����R���{���f�����擾���܂��B
   * @return �J�n�����R���{���f��
   */
  protected ACComboBoxModelAdapter getHoumonKaigoBeginTimeModel(){
    if(houmonKaigoBeginTimeModel==null){
      houmonKaigoBeginTimeModel = new ACComboBoxModelAdapter();
      addHoumonKaigoBeginTimeModel();
    }
    return houmonKaigoBeginTimeModel;
  }

  /**
   * �I�������R���{���擾���܂��B
   * @return �I�������R���{
   */
  public ACTimeComboBox getHoumonKaigoEndTime(){
    if(houmonKaigoEndTime==null){

      houmonKaigoEndTime = new ACTimeComboBox();

      getHoumonKaigoEndTimeContainer().setText("�I������");

      houmonKaigoEndTime.setBindPath("4");

      houmonKaigoEndTime.setModelBindPath("4");

      houmonKaigoEndTime.setRenderBindPath("CONTENT");

      houmonKaigoEndTime.setModel(getHoumonKaigoEndTimeModel());

      addHoumonKaigoEndTime();
    }
    return houmonKaigoEndTime;

  }

  /**
   * �I�������R���{�R���e�i���擾���܂��B
   * @return �I�������R���{�R���e�i
   */
  protected ACLabelContainer getHoumonKaigoEndTimeContainer(){
    if(houmonKaigoEndTimeContainer==null){
      houmonKaigoEndTimeContainer = new ACLabelContainer();
      houmonKaigoEndTimeContainer.setFollowChildEnabled(true);
      houmonKaigoEndTimeContainer.setVAlignment(VRLayout.CENTER);
      houmonKaigoEndTimeContainer.add(getHoumonKaigoEndTime(), null);
    }
    return houmonKaigoEndTimeContainer;
  }

  /**
   * �I�������R���{���f�����擾���܂��B
   * @return �I�������R���{���f��
   */
  protected ACComboBoxModelAdapter getHoumonKaigoEndTimeModel(){
    if(houmonKaigoEndTimeModel==null){
      houmonKaigoEndTimeModel = new ACComboBoxModelAdapter();
      addHoumonKaigoEndTimeModel();
    }
    return houmonKaigoEndTimeModel;
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
   * �R���X�g���N�^�ł��B
   */
  public QS001_11111_201204Design() {

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

    tab1.add(getHoumonKaigoServicePatternContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getHomonkaigoTeikyoTimeContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getHoumonKaigoInTimeContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getHoumonKaigoClassContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getHoumonKaigoNumberOfPeopleContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getHoumonKaigoTimeZoneContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getSpecificProviderAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getHoumonKaigoFirstAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getRehabilitationSpecialistPersonnelCooperationRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getHoumonKaigoEmergencyAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getHoumonKaigoTimeContainer(), VRLayout.FLOW_DOUBLEINSETLINE_RETURN);

  }

  /**
   * �T�[�r�X�R���{�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKaigoServicePattern(){

  }

  /**
   * �T�[�r�X�R���{���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKaigoServicePatternModel(){

  }

  /**
   * �g�̉��ɓ������ڂ�ǉ����܂��B
   */
  protected void addHomonkaigoTeikyoTime(){

  }

  /**
   * �g�̉�샂�f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addHomonkaigoTeikyoTimeModel(){

  }

  /**
   * ���������ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKaigoInTime(){

  }

  /**
   * �����������f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKaigoInTimeModel(){

  }

  /**
   * �T�[�r�X�񋟐ӔC�҂̋��E�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKaigoClass(){

  }

  /**
   * �T�[�r�X�񋟐ӔC�҂̋��E���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKaigoClassModel(){

    getHoumonKaigoClassOther().setButtonIndex(1);

    getHoumonKaigoClassModel().add(getHoumonKaigoClassOther());

    getHoumonKaigoClass3().setButtonIndex(2);

    getHoumonKaigoClassModel().add(getHoumonKaigoClass3());

  }

  /**
   * 2���ȊO�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKaigoClassOther(){

  }

  /**
   * 2���ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKaigoClass3(){

  }

  /**
   * �K��l���ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKaigoNumberOfPeople(){

  }

  /**
   * �K��l�����f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKaigoNumberOfPeopleModel(){

    getHoumonKaigoNumberOfPeople1().setButtonIndex(1);

    getHoumonKaigoNumberOfPeopleModel().add(getHoumonKaigoNumberOfPeople1());

    getHoumonKaigoNumberOfPeople2().setButtonIndex(2);

    getHoumonKaigoNumberOfPeopleModel().add(getHoumonKaigoNumberOfPeople2());

  }

  /**
   * 1�l�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKaigoNumberOfPeople1(){

  }

  /**
   * 2�l�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKaigoNumberOfPeople2(){

  }

  /**
   * ���ԑтɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKaigoTimeZone(){

  }

  /**
   * ���ԑу��f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKaigoTimeZoneModel(){

    getHoumonKaigoTimeZoneNormal().setButtonIndex(1);

    getHoumonKaigoTimeZoneModel().add(getHoumonKaigoTimeZoneNormal());

    getHoumonKaigoTimeZoneEarlyMorning().setButtonIndex(2);

    getHoumonKaigoTimeZoneModel().add(getHoumonKaigoTimeZoneEarlyMorning());

    getHoumonKaigoTimeZoneNighttime().setButtonIndex(3);

    getHoumonKaigoTimeZoneModel().add(getHoumonKaigoTimeZoneNighttime());

    getHoumonKaigoTimeZoneMidnight().setButtonIndex(4);

    getHoumonKaigoTimeZoneModel().add(getHoumonKaigoTimeZoneMidnight());

  }

  /**
   * �ʏ�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKaigoTimeZoneNormal(){

  }

  /**
   * �����ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKaigoTimeZoneEarlyMorning(){

  }

  /**
   * ��Ԃɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKaigoTimeZoneNighttime(){

  }

  /**
   * �[��ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKaigoTimeZoneMidnight(){

  }

  /**
   * ���莖�Ə����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addSpecificProviderAddRadio(){

  }

  /**
   * ���莖�Ə����Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addSpecificProviderAddRadioModel(){

    getSpecificProviderAddRadioItem1().setButtonIndex(1);

    getSpecificProviderAddRadioModel().add(getSpecificProviderAddRadioItem1());

    getSpecificProviderAddRadioItem2().setButtonIndex(2);

    getSpecificProviderAddRadioModel().add(getSpecificProviderAddRadioItem2());

    getSpecificProviderAddRadioItem3().setButtonIndex(3);

    getSpecificProviderAddRadioModel().add(getSpecificProviderAddRadioItem3());

    getSpecificProviderAddRadioItem4().setButtonIndex(4);

    getSpecificProviderAddRadioModel().add(getSpecificProviderAddRadioItem4());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addSpecificProviderAddRadioItem1(){

  }

  /**
   * I�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addSpecificProviderAddRadioItem2(){

  }

  /**
   * II�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addSpecificProviderAddRadioItem3(){

  }

  /**
   * III�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addSpecificProviderAddRadioItem4(){

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

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addRehabilitationSpecialistPersonnelCooperationItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addRehabilitationSpecialistPersonnelCooperationItem2(){

  }

  /**
   * �ً}���K������Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKaigoEmergencyAddRadioGroup(){

  }

  /**
   * �ً}���K������Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKaigoEmergencyAddRadioGroupModel(){

    getHoumonKaigoEmergencyAddRadioItem1().setButtonIndex(1);

    getHoumonKaigoEmergencyAddRadioGroupModel().add(getHoumonKaigoEmergencyAddRadioItem1());

    getHoumonKaigoEmergencyAddRadioItem2().setButtonIndex(2);

    getHoumonKaigoEmergencyAddRadioGroupModel().add(getHoumonKaigoEmergencyAddRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKaigoEmergencyAddRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKaigoEmergencyAddRadioItem2(){

  }

  /**
   * �񋟎��ԃR���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKaigoTimeContainer(){

    houmonKaigoTimeContainer.add(getHoumonKaigoBeginTimeContainer(), VRLayout.FLOW);

    houmonKaigoTimeContainer.add(getHoumonKaigoEndTimeContainer(), VRLayout.FLOW);

  }

  /**
   * �J�n�����R���{�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKaigoBeginTime(){

  }

  /**
   * �J�n�����R���{���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKaigoBeginTimeModel(){

  }

  /**
   * �I�������R���{�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKaigoEndTime(){

  }

  /**
   * �I�������R���{���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKaigoEndTimeModel(){

  }

  /**
   * �^�u2�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTab2(){

    tab2.add(getProviderAddMountainousAreaRafioRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getHoumonNeededRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

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
      ACFrame.debugStart(new ACAffairInfo(QS001_11111_201204Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QS001_11111_201204Design getThis() {
    return this;
  }
}
