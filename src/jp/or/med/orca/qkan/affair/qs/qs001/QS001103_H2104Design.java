
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
 * �J����: �c���@����
 * �쐬��: 2009/03/13  ���{�R���s���[�^�[������� �c���@���� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �\��Ǘ� (S)
 * �v���Z�X �T�[�r�X�\�� (001)
 * �v���O���� �T�[�r�X�p�^�[���K��Ō�i���j (QS001103_H2104)
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
 * �T�[�r�X�p�^�[���K��Ō�i���j��ʍ��ڃf�U�C��(QS001103_H2104) 
 */
public class QS001103_H2104Design extends QS001ServicePanel {
  //GUI�R���|�[�l���g

  private ACPanel houmonKangoKaigoPatterns;

  private JTabbedPane tabs;

  private ACPanel tab1;

  private ACClearableRadioButtonGroup houmonKangoKaigoFacilityType;

  private ACLabelContainer houmonKangoKaigoFacilityTypeContainer;

  private ACListModelAdapter houmonKangoKaigoFacilityTypeModel;

  private ACRadioButtonItem houmonKangoKaigoStation;

  private ACRadioButtonItem houmonKangoKaigoMedicalInstitution;

  private ACClearableRadioButtonGroup houmonKangoKaigoClass;

  private ACLabelContainer houmonKangoKaigoClassContainer;

  private ACListModelAdapter houmonKangoKaigoClassModel;

  private ACRadioButtonItem houmonKangoKaigoClass1;

  private ACRadioButtonItem houmonKangoKaigoClass2;

  private ACRadioButtonItem houmonKangoKaigoClass3;

  private ACClearableRadioButtonGroup houmonKangoKaigoTime;

  private ACLabelContainer houmonKangoKaigoTimeContainer;

  private ACListModelAdapter houmonKangoKaigoTimeModel;

  private ACRadioButtonItem houmonKangoKaigoTime4;

  private ACRadioButtonItem houmonKangoKaigoTime1;

  private ACRadioButtonItem houmonKangoKaigoTime2;

  private ACRadioButtonItem houmonKangoKaigoTime3;

  private ACClearableRadioButtonGroup houmonKangoKaigoTimeZone;

  private ACLabelContainer houmonKangoKaigoTimeZoneContainer;

  private ACListModelAdapter houmonKangoKaigoTimeZoneModel;

  private ACRadioButtonItem houmonKangoKaigoTimeZoneNormal;

  private ACRadioButtonItem houmonKangoKaigoTimeZoneEarlyMorning;

  private ACRadioButtonItem houmonKangoKaigoTimeZoneNighttime;

  private ACRadioButtonItem houmonKangoKaigoTimeZoneMidnight;

  private ACClearableRadioButtonGroup houmonKangoKaigoSpecialManageRadio;

  private ACLabelContainer houmonKangoKaigoSpecialManageRadioContainer;

  private ACListModelAdapter houmonKangoKaigoSpecialManageRadioModel;

  private ACRadioButtonItem houmonKangoKaigoSpecialManageRadioItem1;

  private ACRadioButtonItem houmonKangoKaigoSpecialManageRadioItem2;

  private ACClearableRadioButtonGroup houmonKangoKaigoLongTime;

  private ACLabelContainer houmonKangoKaigoLongTimeContainer;

  private ACListModelAdapter houmonKangoKaigoLongTimeModel;

  private ACRadioButtonItem houmonKangoKaigoLongTimeItem1;

  private ACRadioButtonItem houmonKangoKaigoLongTimeItem2;

  private ACBackLabelContainer houmonKangoKaigoTimeContena;

  private ACTimeComboBox houmonKangoKaigoBeginTime;

  private ACLabelContainer houmonKangoKaigoBeginTimeContainer;

  private ACComboBoxModelAdapter houmonKangoKaigoBeginTimeModel;

  private ACTimeComboBox houmonKangoKaigoEndTime;

  private ACLabelContainer houmonKangoKaigoEndTimeContainer;

  private ACComboBoxModelAdapter houmonKangoKaigoEndTimeModel;

  private ACPanel tab2;

  private ACClearableRadioButtonGroup houmonKangoKaigoUrgentTimeRadio;

  private ACLabelContainer houmonKangoKaigoUrgentTimeRadioContainer;

  private ACListModelAdapter houmonKangoKaigoUrgentTimeRadioModel;

  private ACRadioButtonItem houmonKangoKaigoUrgentTimeRadioItem1;

  private ACRadioButtonItem houmonKangoKaigoUrgentTimeRadioItem2;

  private ACClearableRadioButtonGroup houmonKangoKaigoTerminalRadio;

  private ACLabelContainer houmonKangoKaigoTerminalRadioContainer;

  private ACListModelAdapter houmonKangoKaigoTerminalRadioModel;

  private ACRadioButtonItem houmonKangoKaigoTerminalRadioItem1;

  private ACRadioButtonItem houmonKangoKaigoTerminalRadioItem2;

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

  private ACValueArrayRadioButtonGroup providerAddMountainousAreaRafioRadioGroup;

  private ACLabelContainer providerAddMountainousAreaRafioRadioGroupContainer;

  private ACListModelAdapter providerAddMountainousAreaRafioRadioGroupModel;

  private ACRadioButtonItem providerAddMountainousAreaRafioRadioItem1;

  private ACRadioButtonItem providerAddMountainousAreaRafioRadioItem2;

  //getter

  /**
   * �K��Ō�i���j�p�^�[���̈�j���擾���܂��B
   * @return �K��Ō�i���j�p�^�[���̈�j
   */
  public ACPanel getHoumonKangoKaigoPatterns(){
    if(houmonKangoKaigoPatterns==null){

      houmonKangoKaigoPatterns = new ACPanel();

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
  public ACClearableRadioButtonGroup getHoumonKangoKaigoFacilityType(){
    if(houmonKangoKaigoFacilityType==null){

      houmonKangoKaigoFacilityType = new ACClearableRadioButtonGroup();

      getHoumonKangoKaigoFacilityTypeContainer().setText("�{�ݓ��̋敪");

      houmonKangoKaigoFacilityType.setBindPath("1130103");

      houmonKangoKaigoFacilityType.setUseClearButton(false);

      houmonKangoKaigoFacilityType.setModel(getHoumonKangoKaigoFacilityTypeModel());

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
  public ACClearableRadioButtonGroup getHoumonKangoKaigoClass(){
    if(houmonKangoKaigoClass==null){

      houmonKangoKaigoClass = new ACClearableRadioButtonGroup();

      getHoumonKangoKaigoClassContainer().setText("�E���敪");

      houmonKangoKaigoClass.setBindPath("1130104");

      houmonKangoKaigoClass.setUseClearButton(false);

      houmonKangoKaigoClass.setModel(getHoumonKangoKaigoClassModel());

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
  public ACClearableRadioButtonGroup getHoumonKangoKaigoTime(){
    if(houmonKangoKaigoTime==null){

      houmonKangoKaigoTime = new ACClearableRadioButtonGroup();

      getHoumonKangoKaigoTimeContainer().setText("���ԋ敪");

      houmonKangoKaigoTime.setBindPath("1130111");

      houmonKangoKaigoTime.setUseClearButton(false);

      houmonKangoKaigoTime.setModel(getHoumonKangoKaigoTimeModel());

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
  public ACRadioButtonItem getHoumonKangoKaigoTime4(){
    if(houmonKangoKaigoTime4==null){

      houmonKangoKaigoTime4 = new ACRadioButtonItem();

      houmonKangoKaigoTime4.setText("20������");

      houmonKangoKaigoTime4.setGroup(getHoumonKangoKaigoTime());

      houmonKangoKaigoTime4.setConstraints(VRLayout.FLOW);

      addHoumonKangoKaigoTime4();
    }
    return houmonKangoKaigoTime4;

  }

  /**
   * 30���������擾���܂��B
   * @return 30������
   */
  public ACRadioButtonItem getHoumonKangoKaigoTime1(){
    if(houmonKangoKaigoTime1==null){

      houmonKangoKaigoTime1 = new ACRadioButtonItem();

      houmonKangoKaigoTime1.setText("30������");

      houmonKangoKaigoTime1.setGroup(getHoumonKangoKaigoTime());

      houmonKangoKaigoTime1.setConstraints(VRLayout.FLOW_RETURN);

      addHoumonKangoKaigoTime1();
    }
    return houmonKangoKaigoTime1;

  }

  /**
   * 30���ȏ�A1���Ԗ������擾���܂��B
   * @return 30���ȏ�A1���Ԗ���
   */
  public ACRadioButtonItem getHoumonKangoKaigoTime2(){
    if(houmonKangoKaigoTime2==null){

      houmonKangoKaigoTime2 = new ACRadioButtonItem();

      houmonKangoKaigoTime2.setText("30���ȏ�A1���Ԗ���");

      houmonKangoKaigoTime2.setGroup(getHoumonKangoKaigoTime());

      houmonKangoKaigoTime2.setConstraints(VRLayout.FLOW_RETURN);

      addHoumonKangoKaigoTime2();
    }
    return houmonKangoKaigoTime2;

  }

  /**
   * 1���Ԉȏ�A1���Ԕ��������擾���܂��B
   * @return 1���Ԉȏ�A1���Ԕ�����
   */
  public ACRadioButtonItem getHoumonKangoKaigoTime3(){
    if(houmonKangoKaigoTime3==null){

      houmonKangoKaigoTime3 = new ACRadioButtonItem();

      houmonKangoKaigoTime3.setText("1���Ԉȏ�A1���Ԕ�����");

      houmonKangoKaigoTime3.setGroup(getHoumonKangoKaigoTime());

      houmonKangoKaigoTime3.setConstraints(VRLayout.FLOW_RETURN);

      addHoumonKangoKaigoTime3();
    }
    return houmonKangoKaigoTime3;

  }

  /**
   * �K��Ō��쎞�ԑт��擾���܂��B
   * @return �K��Ō��쎞�ԑ�
   */
  public ACClearableRadioButtonGroup getHoumonKangoKaigoTimeZone(){
    if(houmonKangoKaigoTimeZone==null){

      houmonKangoKaigoTimeZone = new ACClearableRadioButtonGroup();

      getHoumonKangoKaigoTimeZoneContainer().setText("���ԑ�");

      houmonKangoKaigoTimeZone.setBindPath("1130106");

      houmonKangoKaigoTimeZone.setUseClearButton(false);

      houmonKangoKaigoTimeZone.setModel(getHoumonKangoKaigoTimeZoneModel());

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
  public ACClearableRadioButtonGroup getHoumonKangoKaigoSpecialManageRadio(){
    if(houmonKangoKaigoSpecialManageRadio==null){

      houmonKangoKaigoSpecialManageRadio = new ACClearableRadioButtonGroup();

      getHoumonKangoKaigoSpecialManageRadioContainer().setText("���ʊǗ����Z");

      houmonKangoKaigoSpecialManageRadio.setBindPath("1130109");

      houmonKangoKaigoSpecialManageRadio.setUseClearButton(false);

      houmonKangoKaigoSpecialManageRadio.setModel(getHoumonKangoKaigoSpecialManageRadioModel());

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
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getHoumonKangoKaigoSpecialManageRadioItem2(){
    if(houmonKangoKaigoSpecialManageRadioItem2==null){

      houmonKangoKaigoSpecialManageRadioItem2 = new ACRadioButtonItem();

      houmonKangoKaigoSpecialManageRadioItem2.setText("����");

      houmonKangoKaigoSpecialManageRadioItem2.setGroup(getHoumonKangoKaigoSpecialManageRadio());

      houmonKangoKaigoSpecialManageRadioItem2.setConstraints(VRLayout.FLOW);

      addHoumonKangoKaigoSpecialManageRadioItem2();
    }
    return houmonKangoKaigoSpecialManageRadioItem2;

  }

  /**
   * �����ԖK��Ō���Z���擾���܂��B
   * @return �����ԖK��Ō���Z
   */
  public ACClearableRadioButtonGroup getHoumonKangoKaigoLongTime(){
    if(houmonKangoKaigoLongTime==null){

      houmonKangoKaigoLongTime = new ACClearableRadioButtonGroup();

      getHoumonKangoKaigoLongTimeContainer().setText("�����ԖK��Ō���Z");

      houmonKangoKaigoLongTime.setBindPath("1130114");

      houmonKangoKaigoLongTime.setUseClearButton(false);

      houmonKangoKaigoLongTime.setModel(getHoumonKangoKaigoLongTimeModel());

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
   * �񋟎��ԃR���e�i���擾���܂��B
   * @return �񋟎��ԃR���e�i
   */
  public ACBackLabelContainer getHoumonKangoKaigoTimeContena(){
    if(houmonKangoKaigoTimeContena==null){

      houmonKangoKaigoTimeContena = new ACBackLabelContainer();

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
   * �ً}���K��Ō���Z���擾���܂��B
   * @return �ً}���K��Ō���Z
   */
  public ACClearableRadioButtonGroup getHoumonKangoKaigoUrgentTimeRadio(){
    if(houmonKangoKaigoUrgentTimeRadio==null){

      houmonKangoKaigoUrgentTimeRadio = new ACClearableRadioButtonGroup();

      getHoumonKangoKaigoUrgentTimeRadioContainer().setText("�ً}���K��Ō���Z");

      houmonKangoKaigoUrgentTimeRadio.setBindPath("1130108");

      houmonKangoKaigoUrgentTimeRadio.setUseClearButton(false);

      houmonKangoKaigoUrgentTimeRadio.setModel(getHoumonKangoKaigoUrgentTimeRadioModel());

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
   * �^�[�~�i���P�A���Z���擾���܂��B
   * @return �^�[�~�i���P�A���Z
   */
  public ACClearableRadioButtonGroup getHoumonKangoKaigoTerminalRadio(){
    if(houmonKangoKaigoTerminalRadio==null){

      houmonKangoKaigoTerminalRadio = new ACClearableRadioButtonGroup();

      getHoumonKangoKaigoTerminalRadioContainer().setText("�^�[�~�i���P�A���Z");

      houmonKangoKaigoTerminalRadio.setBindPath("1130110");

      houmonKangoKaigoTerminalRadio.setUseClearButton(false);

      houmonKangoKaigoTerminalRadio.setModel(getHoumonKangoKaigoTerminalRadioModel());

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
   * �R���X�g���N�^�ł��B
   */
  public QS001103_H2104Design() {

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

    getHoumonKangoKaigoTime4().setButtonIndex(1);

    getHoumonKangoKaigoTimeModel().add(getHoumonKangoKaigoTime4());

    getHoumonKangoKaigoTime1().setButtonIndex(2);

    getHoumonKangoKaigoTimeModel().add(getHoumonKangoKaigoTime1());

    getHoumonKangoKaigoTime2().setButtonIndex(3);

    getHoumonKangoKaigoTimeModel().add(getHoumonKangoKaigoTime2());

    getHoumonKangoKaigoTime3().setButtonIndex(4);

    getHoumonKangoKaigoTimeModel().add(getHoumonKangoKaigoTime3());

  }

  /**
   * 20�������ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKangoKaigoTime4(){

  }

  /**
   * 30�������ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKangoKaigoTime1(){

  }

  /**
   * 30���ȏ�A1���Ԗ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKangoKaigoTime2(){

  }

  /**
   * 1���Ԉȏ�A1���Ԕ������ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKangoKaigoTime3(){

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

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKangoKaigoSpecialManageRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKangoKaigoSpecialManageRadioItem2(){

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

    tab2.add(getHoumonKangoKaigoUrgentTimeRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getHoumonKangoKaigoTerminalRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getServiceAddProvisionStructuralRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getHoumonKangoNumberOfPeopleContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getProviderAddMountainousAreaRafioRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

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
      ACFrame.debugStart(new ACAffairInfo(QS001103_H2104Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QS001103_H2104Design getThis() {
    return this;
  }
}
