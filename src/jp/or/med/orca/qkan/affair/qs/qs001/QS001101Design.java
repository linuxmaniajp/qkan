
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
 * �J����: ���{�@�K��
 * �쐬��: 2006/03/19  ���{�R���s���[�^�[������� ���{�@�K�� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �\��Ǘ� (S)
 * �v���Z�X �T�[�r�X�\�� (001)
 * �v���O���� �T�[�r�X�p�^�[���K���� (QS001101)
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
 * �T�[�r�X�p�^�[���K�����ʍ��ڃf�U�C��(QS001101) 
 */
public class QS001101Design extends QS001ServicePanel {
  //GUI�R���|�[�l���g

  private ACPanel houmonKaigoPatterns;

  private ACComboBox houmonKaigoServicePattern;

  private ACLabelContainer houmonKaigoServicePatternContainer;

  private ACComboBoxModelAdapter houmonKaigoServicePatternModel;

  private ACComboBox homonkaigoTeikyoTime;

  private ACLabelContainer homonkaigoTeikyoTimeContainer;

  private ACComboBoxModelAdapter homonkaigoTeikyoTimeModel;

  private ACComboBox houmonKaigoInTime;

  private ACLabelContainer houmonKaigoInTimeContainer;

  private ACComboBoxModelAdapter houmonKaigoInTimeModel;

  private ACClearableRadioButtonGroup houmonKaigoClass;

  private ACLabelContainer houmonKaigoClassContainer;

  private ACListModelAdapter houmonKaigoClassModel;

  private ACRadioButtonItem houmonKaigoClassOther;

  private ACRadioButtonItem houmonKaigoClass3;

  private ACClearableRadioButtonGroup houmonKaigoNumberOfPeople;

  private ACLabelContainer houmonKaigoNumberOfPeopleContainer;

  private ACListModelAdapter houmonKaigoNumberOfPeopleModel;

  private ACRadioButtonItem houmonKaigoNumberOfPeople1;

  private ACRadioButtonItem houmonKaigoNumberOfPeople2;

  private ACClearableRadioButtonGroup houmonKaigoTimeZone;

  private ACLabelContainer houmonKaigoTimeZoneContainer;

  private ACListModelAdapter houmonKaigoTimeZoneModel;

  private ACRadioButtonItem houmonKaigoTimeZoneNormal;

  private ACRadioButtonItem houmonKaigoTimeZoneEarlyMorning;

  private ACRadioButtonItem houmonKaigoTimeZoneNighttime;

  private ACRadioButtonItem houmonKaigoTimeZoneMidnight;

  private ACClearableRadioButtonGroup specificProviderAddRadio;

  private ACLabelContainer specificProviderAddRadioContainer;

  private ACListModelAdapter specificProviderAddRadioModel;

  private ACRadioButtonItem specificProviderAddRadioItem1;

  private ACRadioButtonItem specificProviderAddRadioItem2;

  private ACRadioButtonItem specificProviderAddRadioItem3;

  private ACRadioButtonItem specificProviderAddRadioItem4;

  private ACBackLabelContainer houmonKaigoTimeContainer;

  private ACTimeComboBox houmonKaigoBeginTime;

  private ACLabelContainer houmonKaigoBeginTimeContainer;

  private ACComboBoxModelAdapter houmonKaigoBeginTimeModel;

  private ACTimeComboBox houmonKaigoEndTime;

  private ACLabelContainer houmonKaigoEndTimeContainer;

  private ACComboBoxModelAdapter houmonKaigoEndTimeModel;

  //getter

  /**
   * �K����p�^�[���̈���擾���܂��B
   * @return �K����p�^�[���̈�
   */
  public ACPanel getHoumonKaigoPatterns(){
    if(houmonKaigoPatterns==null){

      houmonKaigoPatterns = new ACPanel();

      addHoumonKaigoPatterns();
    }
    return houmonKaigoPatterns;

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

      houmonKaigoServicePattern.setModel(getHoumonKaigoServicePatternModel());

      houmonKaigoServicePattern.setRenderBindPath("CONTENT");

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

      homonkaigoTeikyoTime.setModelBindPath("1110105");

      homonkaigoTeikyoTime.setModel(getHomonkaigoTeikyoTimeModel());

      homonkaigoTeikyoTime.setRenderBindPath("CONTENT");

      homonkaigoTeikyoTime.setBlankable(false);

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

      houmonKaigoInTime.setModelBindPath("1110104");

      houmonKaigoInTime.setModel(getHoumonKaigoInTimeModel());

      houmonKaigoInTime.setRenderBindPath("CONTENT");

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
   * �K��҂̋��E���擾���܂��B
   * @return �K��҂̋��E
   */
  public ACClearableRadioButtonGroup getHoumonKaigoClass(){
    if(houmonKaigoClass==null){

      houmonKaigoClass = new ACClearableRadioButtonGroup();

      getHoumonKaigoClassContainer().setText("�K��҂̋��E");

      houmonKaigoClass.setBindPath("1110106");

      houmonKaigoClass.setModel(getHoumonKaigoClassModel());

      houmonKaigoClass.setUseClearButton(false);

      addHoumonKaigoClass();
    }
    return houmonKaigoClass;

  }

  /**
   * �K��҂̋��E�R���e�i���擾���܂��B
   * @return �K��҂̋��E�R���e�i
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
   * �K��҂̋��E���f�����擾���܂��B
   * @return �K��҂̋��E���f��
   */
  protected ACListModelAdapter getHoumonKaigoClassModel(){
    if(houmonKaigoClassModel==null){
      houmonKaigoClassModel = new ACListModelAdapter();
      addHoumonKaigoClassModel();
    }
    return houmonKaigoClassModel;
  }

  /**
   * �R���ȊO���擾���܂��B
   * @return �R���ȊO
   */
  public ACRadioButtonItem getHoumonKaigoClassOther(){
    if(houmonKaigoClassOther==null){

      houmonKaigoClassOther = new ACRadioButtonItem();

      houmonKaigoClassOther.setText("3���ȊO");

      houmonKaigoClassOther.setGroup(getHoumonKaigoClass());

      addHoumonKaigoClassOther();
    }
    return houmonKaigoClassOther;

  }

  /**
   * �R�����擾���܂��B
   * @return �R��
   */
  public ACRadioButtonItem getHoumonKaigoClass3(){
    if(houmonKaigoClass3==null){

      houmonKaigoClass3 = new ACRadioButtonItem();

      houmonKaigoClass3.setText("3��");

      houmonKaigoClass3.setGroup(getHoumonKaigoClass());

      addHoumonKaigoClass3();
    }
    return houmonKaigoClass3;

  }

  /**
   * �K��l�����擾���܂��B
   * @return �K��l��
   */
  public ACClearableRadioButtonGroup getHoumonKaigoNumberOfPeople(){
    if(houmonKaigoNumberOfPeople==null){

      houmonKaigoNumberOfPeople = new ACClearableRadioButtonGroup();

      getHoumonKaigoNumberOfPeopleContainer().setText("�K��l��");

      houmonKaigoNumberOfPeople.setBindPath("1110107");

      houmonKaigoNumberOfPeople.setModel(getHoumonKaigoNumberOfPeopleModel());

      houmonKaigoNumberOfPeople.setUseClearButton(false);

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
  public ACClearableRadioButtonGroup getHoumonKaigoTimeZone(){
    if(houmonKaigoTimeZone==null){

      houmonKaigoTimeZone = new ACClearableRadioButtonGroup();

      getHoumonKaigoTimeZoneContainer().setText("���ԑ�");

      houmonKaigoTimeZone.setBindPath("1110108");

      houmonKaigoTimeZone.setModel(getHoumonKaigoTimeZoneModel());

      houmonKaigoTimeZone.setUseClearButton(false);

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
  public ACClearableRadioButtonGroup getSpecificProviderAddRadio(){
    if(specificProviderAddRadio==null){

      specificProviderAddRadio = new ACClearableRadioButtonGroup();

      getSpecificProviderAddRadioContainer().setText("���莖�Ə����Z");

      specificProviderAddRadio.setBindPath("1110109");

      specificProviderAddRadio.setModel(getSpecificProviderAddRadioModel());

      specificProviderAddRadio.setUseClearButton(false);

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

      specificProviderAddRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

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
   * �񋟎��ԃR���e�i���擾���܂��B
   * @return �񋟎��ԃR���e�i
   */
  public ACBackLabelContainer getHoumonKaigoTimeContainer(){
    if(houmonKaigoTimeContainer==null){

      houmonKaigoTimeContainer = new ACBackLabelContainer();

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

      houmonKaigoBeginTime.setModel(getHoumonKaigoBeginTimeModel());

      houmonKaigoBeginTime.setRenderBindPath("CONTENT");

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

      houmonKaigoEndTime.setModel(getHoumonKaigoEndTimeModel());

      houmonKaigoEndTime.setRenderBindPath("CONTENT");

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
   * �R���X�g���N�^�ł��B
   */
  public QS001101Design() {

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

    this.add(getHoumonKaigoPatterns(), VRLayout.CLIENT);

  }

  /**
   * �K����p�^�[���̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKaigoPatterns(){

    houmonKaigoPatterns.add(getHoumonKaigoServicePatternContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    houmonKaigoPatterns.add(getHomonkaigoTeikyoTimeContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    houmonKaigoPatterns.add(getHoumonKaigoInTimeContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    houmonKaigoPatterns.add(getHoumonKaigoClassContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    houmonKaigoPatterns.add(getHoumonKaigoNumberOfPeopleContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    houmonKaigoPatterns.add(getHoumonKaigoTimeZoneContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    houmonKaigoPatterns.add(getSpecificProviderAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    houmonKaigoPatterns.add(getHoumonKaigoTimeContainer(), VRLayout.FLOW_DOUBLEINSETLINE_RETURN);

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
   * �K��҂̋��E�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKaigoClass(){

  }

  /**
   * �K��҂̋��E���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKaigoClassModel(){

    getHoumonKaigoClassOther().setButtonIndex(1);
    getHoumonKaigoClassModel().add(getHoumonKaigoClassOther());

    getHoumonKaigoClass3().setButtonIndex(2);
    getHoumonKaigoClassModel().add(getHoumonKaigoClass3());

  }

  /**
   * �R���ȊO�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKaigoClassOther(){

  }

  /**
   * �R���ɓ������ڂ�ǉ����܂��B
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
      ACFrame.debugStart(new ACAffairInfo(QS001101Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QS001101Design getThis() {
    return this;
  }
}
