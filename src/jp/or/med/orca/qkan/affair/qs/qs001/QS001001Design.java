
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
 * �J����: �� ����
 * �쐬��: 2006/01/31  ���{�R���s���[�^�[������� �� ���� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �\��Ǘ� (S)
 * �v���Z�X �T�[�r�X�\�� (001)
 * �v���O���� �T�ԕ\ (QS001001)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
import java.awt.Color;
import java.awt.Component;
import java.awt.im.InputSubset;

import jp.nichicom.ac.ACConstants;
import jp.nichicom.ac.component.ACButton;
import jp.nichicom.ac.component.ACComboBox;
import jp.nichicom.ac.component.ACIntegerCheckBox;
import jp.nichicom.ac.component.ACLabel;
import jp.nichicom.ac.component.ACTextField;
import jp.nichicom.ac.component.ACTimeComboBox;
import jp.nichicom.ac.container.ACBackLabelContainer;
import jp.nichicom.ac.container.ACGroupBox;
import jp.nichicom.ac.container.ACLabelContainer;
import jp.nichicom.ac.container.ACPanel;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.util.adapter.ACComboBoxModelAdapter;
import jp.nichicom.vr.layout.VRLayout;
import jp.nichicom.vr.text.VRCharType;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.component.QkanDateTextField;
/**
 * �T�ԕ\��ʍ��ڃf�U�C��(QS001001) 
 */
public class QS001001Design extends ACPanel {
  //GUI�R���|�[�l���g

  private ACPanel contents;

  private ACGroupBox timeContentLabelWeeks;

  private ACPanel timeContentLabelWeeksLeft;

  private ACBackLabelContainer timeComboContainer;

  private ACTimeComboBox beginCombo;

  private ACLabelContainer beginComboContainer;

  private ACComboBoxModelAdapter beginComboModel;

  private ACLabel timeComboCaption;

  private ACTimeComboBox endCombo;

  private ACLabelContainer endComboContainer;

  private ACComboBoxModelAdapter endComboModel;

  private ACLabelContainer dayoftheWeekContainer;

  private ACIntegerCheckBox mondayCheck;

  private ACIntegerCheckBox tuesdayCheck;

  private ACIntegerCheckBox wednesdayCheck;

  private ACIntegerCheckBox thursdayCheck;

  private ACIntegerCheckBox fridayCheck;

  private ACIntegerCheckBox saturdayCheck;

  private ACIntegerCheckBox sundayCheck;

  private ACPanel timeButtons;

  private ACButton timeButton;

  private ACGroupBox exceptionServiceCombos;

  private ACBackLabelContainer exceptionComboContena;

  private ACComboBox exceptionBeginCombo;

  private ACLabelContainer exceptionBeginComboContainer;

  private ACComboBoxModelAdapter exceptionBeginComboModel;

  private ACLabel exceptionBeginLabel;

  private ACComboBox exceptionEndCombo;

  private ACLabelContainer exceptionEndComboContainer;

  private ACComboBoxModelAdapter exceptionEndComboModel;

  private ACLabel exceptionEndLabel;

  private ACButton everydayButton;

  private ACButton exceptionButton;

  private ACPanel weeklyCharts;

  private QS001WeekSchedule weeklySchedule;

  private ACPanel bottoms;

  private ACGroupBox nonWeeks;

  private QS001DaySchedule freedayServices;

  private ACPanel lowerRights;

  private ACGroupBox expansions;

  private ACLabelContainer expansionStartDateContainer;

  private ACTextField expansionStartDate;

  private ACLabel expansionStartDateCaption;

  private ACButton expansionButton;

  private ACGroupBox weeklyServicePlans;

  private QkanDateTextField createDate;

  private ACLabelContainer createDateContainer;

  //getter

  /**
   * �N���C�A���g�̈���擾���܂��B
   * @return �N���C�A���g�̈�
   */
  public ACPanel getContents(){
    if(contents==null){

      contents = new ACPanel();

      addContents();
    }
    return contents;

  }

  /**
   * �����j���ݒ胉�x�������̈���擾���܂��B
   * @return �����j���ݒ胉�x�������̈�
   */
  public ACGroupBox getTimeContentLabelWeeks(){
    if(timeContentLabelWeeks==null){

      timeContentLabelWeeks = new ACGroupBox();

      timeContentLabelWeeks.setText("�R�D�����E�j���̑I��");

      addTimeContentLabelWeeks();
    }
    return timeContentLabelWeeks;

  }

  /**
   * �����j���ݒ胉�x�������̈捶���擾���܂��B
   * @return �����j���ݒ胉�x�������̈捶
   */
  public ACPanel getTimeContentLabelWeeksLeft(){
    if(timeContentLabelWeeksLeft==null){

      timeContentLabelWeeksLeft = new ACPanel();

      addTimeContentLabelWeeksLeft();
    }
    return timeContentLabelWeeksLeft;

  }

  /**
   * �R���{�R���e�i���擾���܂��B
   * @return �R���{�R���e�i
   */
  public ACBackLabelContainer getTimeComboContainer(){
    if(timeComboContainer==null){

      timeComboContainer = new ACBackLabelContainer();

      timeComboContainer.setText("����");

      addTimeComboContainer();
    }
    return timeComboContainer;

  }

  /**
   * �J�n�����R���{���擾���܂��B
   * @return �J�n�����R���{
   */
  public ACTimeComboBox getBeginCombo(){
    if(beginCombo==null){

      beginCombo = new ACTimeComboBox();

      beginCombo.setBindPath("3");

      beginCombo.setModelBindPath("3");

      beginCombo.setModel(getBeginComboModel());

      beginCombo.setRenderBindPath("CONTENT");

      addBeginCombo();
    }
    return beginCombo;

  }

  /**
   * �J�n�����R���{�R���e�i���擾���܂��B
   * @return �J�n�����R���{�R���e�i
   */
  protected ACLabelContainer getBeginComboContainer(){
    if(beginComboContainer==null){
      beginComboContainer = new ACLabelContainer();
      beginComboContainer.add(getBeginCombo(), null);
    }
    return beginComboContainer;
  }

  /**
   * �J�n�����R���{���f�����擾���܂��B
   * @return �J�n�����R���{���f��
   */
  protected ACComboBoxModelAdapter getBeginComboModel(){
    if(beginComboModel==null){
      beginComboModel = new ACComboBoxModelAdapter();
      addBeginComboModel();
    }
    return beginComboModel;
  }

  /**
   * �����L���v�V�������擾���܂��B
   * @return �����L���v�V����
   */
  public ACLabel getTimeComboCaption(){
    if(timeComboCaption==null){

      timeComboCaption = new ACLabel();

      timeComboCaption.setText("����");

      addTimeComboCaption();
    }
    return timeComboCaption;

  }

  /**
   * �I�������R���{���擾���܂��B
   * @return �I�������R���{
   */
  public ACTimeComboBox getEndCombo(){
    if(endCombo==null){

      endCombo = new ACTimeComboBox();

      endCombo.setBindPath("4");

      endCombo.setModelBindPath("4");

      endCombo.setModel(getEndComboModel());

      endCombo.setRenderBindPath("CONTENT");

      addEndCombo();
    }
    return endCombo;

  }

  /**
   * �I�������R���{�R���e�i���擾���܂��B
   * @return �I�������R���{�R���e�i
   */
  protected ACLabelContainer getEndComboContainer(){
    if(endComboContainer==null){
      endComboContainer = new ACLabelContainer();
      endComboContainer.add(getEndCombo(), null);
    }
    return endComboContainer;
  }

  /**
   * �I�������R���{���f�����擾���܂��B
   * @return �I�������R���{���f��
   */
  protected ACComboBoxModelAdapter getEndComboModel(){
    if(endComboModel==null){
      endComboModel = new ACComboBoxModelAdapter();
      addEndComboModel();
    }
    return endComboModel;
  }

  /**
   * �j���ݒ�̈�R���e�i���擾���܂��B
   * @return �j���ݒ�̈�R���e�i
   */
  public ACLabelContainer getDayoftheWeekContainer(){
    if(dayoftheWeekContainer==null){

      dayoftheWeekContainer = new ACLabelContainer();

      addDayoftheWeekContainer();
    }
    return dayoftheWeekContainer;

  }

  /**
   * �`�F�b�N�{�b�N�X���j���擾���܂��B
   * @return �`�F�b�N�{�b�N�X���j
   */
  public ACIntegerCheckBox getMondayCheck(){
    if(mondayCheck==null){

      mondayCheck = new ACIntegerCheckBox();

      mondayCheck.setText("��");

      addMondayCheck();
    }
    return mondayCheck;

  }

  /**
   * �`�F�b�N�{�b�N�X�Ηj���擾���܂��B
   * @return �`�F�b�N�{�b�N�X�Ηj
   */
  public ACIntegerCheckBox getTuesdayCheck(){
    if(tuesdayCheck==null){

      tuesdayCheck = new ACIntegerCheckBox();

      tuesdayCheck.setText("��");

      addTuesdayCheck();
    }
    return tuesdayCheck;

  }

  /**
   * �`�F�b�N�{�b�N�X���j���擾���܂��B
   * @return �`�F�b�N�{�b�N�X���j
   */
  public ACIntegerCheckBox getWednesdayCheck(){
    if(wednesdayCheck==null){

      wednesdayCheck = new ACIntegerCheckBox();

      wednesdayCheck.setText("��");

      addWednesdayCheck();
    }
    return wednesdayCheck;

  }

  /**
   * �`�F�b�N�{�b�N�X�ؗj���擾���܂��B
   * @return �`�F�b�N�{�b�N�X�ؗj
   */
  public ACIntegerCheckBox getThursdayCheck(){
    if(thursdayCheck==null){

      thursdayCheck = new ACIntegerCheckBox();

      thursdayCheck.setText("��");

      addThursdayCheck();
    }
    return thursdayCheck;

  }

  /**
   * �`�F�b�N�{�b�N�X���j���擾���܂��B
   * @return �`�F�b�N�{�b�N�X���j
   */
  public ACIntegerCheckBox getFridayCheck(){
    if(fridayCheck==null){

      fridayCheck = new ACIntegerCheckBox();

      fridayCheck.setText("��");

      addFridayCheck();
    }
    return fridayCheck;

  }

  /**
   * �`�F�b�N�{�b�N�X�y�j���擾���܂��B
   * @return �`�F�b�N�{�b�N�X�y�j
   */
  public ACIntegerCheckBox getSaturdayCheck(){
    if(saturdayCheck==null){

      saturdayCheck = new ACIntegerCheckBox();

      saturdayCheck.setText("�y");

      addSaturdayCheck();
    }
    return saturdayCheck;

  }

  /**
   * �`�F�b�N�{�b�N�X���j���擾���܂��B
   * @return �`�F�b�N�{�b�N�X���j
   */
  public ACIntegerCheckBox getSundayCheck(){
    if(sundayCheck==null){

      sundayCheck = new ACIntegerCheckBox();

      sundayCheck.setText("��");

      addSundayCheck();
    }
    return sundayCheck;

  }

  /**
   * �\��t���{�^���̈���擾���܂��B
   * @return �\��t���{�^���̈�
   */
  public ACPanel getTimeButtons(){
    if(timeButtons==null){

      timeButtons = new ACPanel();

      addTimeButtons();
    }
    return timeButtons;

  }

  /**
   * �\��t���{�^�����擾���܂��B
   * @return �\��t���{�^��
   */
  public ACButton getTimeButton(){
    if(timeButton==null){

      timeButton = new ACButton();

      timeButton.setText("�\��t��");

      timeButton.setToolTipText("�T�[�r�X���T�ԕ\�ɓ\��t���܂��B");

      timeButton.setIconPath(ACConstants.ICON_PATH_DOWN_24);

      addTimeButton();
    }
    return timeButton;

  }

  /**
   * �T�P�ʈȊO�̃T�[�r�X�̈���擾���܂��B
   * @return �T�P�ʈȊO�̃T�[�r�X�̈�
   */
  public ACGroupBox getExceptionServiceCombos(){
    if(exceptionServiceCombos==null){

      exceptionServiceCombos = new ACGroupBox();

      exceptionServiceCombos.setText("�S�D�T�P�ʈȊO�̃T�[�r�X");

      exceptionServiceCombos.setFollowChildEnabled(true);

      addExceptionServiceCombos();
    }
    return exceptionServiceCombos;

  }

  /**
   * �R���{�R���e�i���擾���܂��B
   * @return �R���{�R���e�i
   */
  public ACBackLabelContainer getExceptionComboContena(){
    if(exceptionComboContena==null){

      exceptionComboContena = new ACBackLabelContainer();

      exceptionComboContena.setText("����");

      addExceptionComboContena();
    }
    return exceptionComboContena;

  }

  /**
   * �J�n�R���{���擾���܂��B
   * @return �J�n�R���{
   */
  public ACComboBox getExceptionBeginCombo(){
    if(exceptionBeginCombo==null){

      exceptionBeginCombo = new ACComboBox();

      exceptionBeginCombo.setBindPath("24");

      exceptionBeginCombo.setEditable(false);

      exceptionBeginCombo.setModelBindPath("24");

      exceptionBeginCombo.setModel(getExceptionBeginComboModel());

      exceptionBeginCombo.setRenderBindPath("CONTENT");

      addExceptionBeginCombo();
    }
    return exceptionBeginCombo;

  }

  /**
   * �J�n�R���{�R���e�i���擾���܂��B
   * @return �J�n�R���{�R���e�i
   */
  protected ACLabelContainer getExceptionBeginComboContainer(){
    if(exceptionBeginComboContainer==null){
      exceptionBeginComboContainer = new ACLabelContainer();
      exceptionBeginComboContainer.add(getExceptionBeginCombo(), null);
    }
    return exceptionBeginComboContainer;
  }

  /**
   * �J�n�R���{���f�����擾���܂��B
   * @return �J�n�R���{���f��
   */
  protected ACComboBoxModelAdapter getExceptionBeginComboModel(){
    if(exceptionBeginComboModel==null){
      exceptionBeginComboModel = new ACComboBoxModelAdapter();
      addExceptionBeginComboModel();
    }
    return exceptionBeginComboModel;
  }

  /**
   * ���烉�x�����擾���܂��B
   * @return ���烉�x��
   */
  public ACLabel getExceptionBeginLabel(){
    if(exceptionBeginLabel==null){

      exceptionBeginLabel = new ACLabel();

      exceptionBeginLabel.setText("����");

      addExceptionBeginLabel();
    }
    return exceptionBeginLabel;

  }

  /**
   * �I���R���{���擾���܂��B
   * @return �I���R���{
   */
  public ACComboBox getExceptionEndCombo(){
    if(exceptionEndCombo==null){

      exceptionEndCombo = new ACComboBox();

      exceptionEndCombo.setBindPath("25");

      exceptionEndCombo.setEditable(false);

      exceptionEndCombo.setModelBindPath("25");

      exceptionEndCombo.setModel(getExceptionEndComboModel());

      exceptionEndCombo.setRenderBindPath("CONTENT");

      exceptionEndCombo.setBlankable(true);

      addExceptionEndCombo();
    }
    return exceptionEndCombo;

  }

  /**
   * �I���R���{�R���e�i���擾���܂��B
   * @return �I���R���{�R���e�i
   */
  protected ACLabelContainer getExceptionEndComboContainer(){
    if(exceptionEndComboContainer==null){
      exceptionEndComboContainer = new ACLabelContainer();
      exceptionEndComboContainer.add(getExceptionEndCombo(), null);
    }
    return exceptionEndComboContainer;
  }

  /**
   * �I���R���{���f�����擾���܂��B
   * @return �I���R���{���f��
   */
  protected ACComboBoxModelAdapter getExceptionEndComboModel(){
    if(exceptionEndComboModel==null){
      exceptionEndComboModel = new ACComboBoxModelAdapter();
      addExceptionEndComboModel();
    }
    return exceptionEndComboModel;
  }

  /**
   * ���ԃ��x�����擾���܂��B
   * @return ���ԃ��x��
   */
  public ACLabel getExceptionEndLabel(){
    if(exceptionEndLabel==null){

      exceptionEndLabel = new ACLabel();

      exceptionEndLabel.setText("����");

      addExceptionEndLabel();
    }
    return exceptionEndLabel;

  }

  /**
   * �����{�^�����擾���܂��B
   * @return �����{�^��
   */
  public ACButton getEverydayButton(){
    if(everydayButton==null){

      everydayButton = new ACButton();

      everydayButton.setText("����");

      everydayButton.setToolTipText("�S�������Ƃ��ē\��t���܂��B");

      addEverydayButton();
    }
    return everydayButton;

  }

  /**
   * �\��t���{�^�����擾���܂��B
   * @return �\��t���{�^��
   */
  public ACButton getExceptionButton(){
    if(exceptionButton==null){

      exceptionButton = new ACButton();

      exceptionButton.setText("�\��t��");

      exceptionButton.setToolTipText("�T�[�r�X���T�ԕ\�ɓ\��t���܂��B");

      exceptionButton.setIconPath(ACConstants.ICON_PATH_DOWN_24);

      addExceptionButton();
    }
    return exceptionButton;

  }

  /**
   * �T�ԕ\�̈���擾���܂��B
   * @return �T�ԕ\�̈�
   */
  public ACPanel getWeeklyCharts(){
    if(weeklyCharts==null){

      weeklyCharts = new ACPanel();

      weeklyCharts.setBackground(new Color(233,255,240));

      addWeeklyCharts();
    }
    return weeklyCharts;

  }

  /**
   * �T�ԕ\���擾���܂��B
   * @return �T�ԕ\
   */
  public QS001WeekSchedule getWeeklySchedule(){
    if(weeklySchedule==null){

      weeklySchedule = new QS001WeekSchedule();

      addWeeklySchedule();
    }
    return weeklySchedule;

  }

  /**
   * �����̈���擾���܂��B
   * @return �����̈�
   */
  public ACPanel getBottoms(){
    if(bottoms==null){

      bottoms = new ACPanel();

      addBottoms();
    }
    return bottoms;

  }

  /**
   * �T�P�ʈȊO�̈���擾���܂��B
   * @return �T�P�ʈȊO�̈�
   */
  public ACGroupBox getNonWeeks(){
    if(nonWeeks==null){

      nonWeeks = new ACGroupBox();

      nonWeeks.setText("�T�P�ʈȊO");

      addNonWeeks();
    }
    return nonWeeks;

  }

  /**
   * �T�P�ʈȊO�̃T�[�r�X���擾���܂��B
   * @return �T�P�ʈȊO�̃T�[�r�X
   */
  public QS001DaySchedule getFreedayServices(){
    if(freedayServices==null){

      freedayServices = new QS001DaySchedule();

      addFreedayServices();
    }
    return freedayServices;

  }

  /**
   * �����E�̈���擾���܂��B
   * @return �����E�̈�
   */
  public ACPanel getLowerRights(){
    if(lowerRights==null){

      lowerRights = new ACPanel();

      addLowerRights();
    }
    return lowerRights;

  }

  /**
   * ���ԂɓW�J�̈���擾���܂��B
   * @return ���ԂɓW�J�̈�
   */
  public ACGroupBox getExpansions(){
    if(expansions==null){

      expansions = new ACGroupBox();

      expansions.setText("���Ԃ֓W�J");

      addExpansions();
    }
    return expansions;

  }

  /**
   * �W�J�J�n���R���e�i���擾���܂��B
   * @return �W�J�J�n���R���e�i
   */
  public ACLabelContainer getExpansionStartDateContainer(){
    if(expansionStartDateContainer==null){

      expansionStartDateContainer = new ACLabelContainer();

      addExpansionStartDateContainer();
    }
    return expansionStartDateContainer;

  }

  /**
   * ���t���擾���܂��B
   * @return ���t
   */
  public ACTextField getExpansionStartDate(){
    if(expansionStartDate==null){

      expansionStartDate = new ACTextField();

      expansionStartDate.setColumns(2);

      expansionStartDate.setCharType(VRCharType.ONLY_DIGIT);

      expansionStartDate.setIMEMode(InputSubset.LATIN);

      expansionStartDate.setMaxLength(2);

      addExpansionStartDate();
    }
    return expansionStartDate;

  }

  /**
   * �L���v�V�������擾���܂��B
   * @return �L���v�V����
   */
  public ACLabel getExpansionStartDateCaption(){
    if(expansionStartDateCaption==null){

      expansionStartDateCaption = new ACLabel();

      expansionStartDateCaption.setText("������");

      addExpansionStartDateCaption();
    }
    return expansionStartDateCaption;

  }

  /**
   * �W�J�{�^�����擾���܂��B
   * @return �W�J�{�^��
   */
  public ACButton getExpansionButton(){
    if(expansionButton==null){

      expansionButton = new ACButton();

      expansionButton.setText("���Ԃ֓W�J");

      expansionButton.setToolTipText("�T�ԕ\�̃T�[�r�X�����ԕ\�ɓW�J���܂��B");

      addExpansionButton();
    }
    return expansionButton;

  }

  /**
   * �T�ԃT�[�r�X�v��\�̈���擾���܂��B
   * @return �T�ԃT�[�r�X�v��\�̈�
   */
  public ACGroupBox getWeeklyServicePlans(){
    if(weeklyServicePlans==null){

      weeklyServicePlans = new ACGroupBox();

      weeklyServicePlans.setText("�T�ԃT�[�r�X�v��\");

      addWeeklyServicePlans();
    }
    return weeklyServicePlans;

  }

  /**
   * �쐬�N�������擾���܂��B
   * @return �쐬�N����
   */
  public QkanDateTextField getCreateDate(){
    if(createDate==null){

      createDate = new QkanDateTextField();

      getCreateDateContainer().setText("�쐬�N����");

      addCreateDate();
    }
    return createDate;

  }

  /**
   * �쐬�N�����R���e�i���擾���܂��B
   * @return �쐬�N�����R���e�i
   */
  protected ACLabelContainer getCreateDateContainer(){
    if(createDateContainer==null){
      createDateContainer = new ACLabelContainer();
      createDateContainer.add(getCreateDate(), null);
    }
    return createDateContainer;
  }

  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001001Design() {

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

    this.add(getContents(), VRLayout.CLIENT);

  }

  /**
   * �N���C�A���g�̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addContents(){

    contents.add(getTimeContentLabelWeeks(), VRLayout.NORTH);

    contents.add(getExceptionServiceCombos(), VRLayout.NORTH);

    contents.add(getWeeklyCharts(), VRLayout.CLIENT);

    contents.add(getBottoms(), VRLayout.SOUTH);
  }

  /**
   * �����j���ݒ胉�x�������̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTimeContentLabelWeeks(){

    timeContentLabelWeeks.add(getTimeContentLabelWeeksLeft(), VRLayout.CLIENT);

    timeContentLabelWeeks.add(getTimeButtons(), VRLayout.EAST);
  }

  /**
   * �����j���ݒ胉�x�������̈捶�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTimeContentLabelWeeksLeft(){

    timeContentLabelWeeksLeft.add(getTimeComboContainer(), VRLayout.FLOW_RETURN);

    timeContentLabelWeeksLeft.add(getDayoftheWeekContainer(), VRLayout.FLOW_RETURN);

  }

  /**
   * �R���{�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTimeComboContainer(){

    timeComboContainer.add(getBeginComboContainer(), VRLayout.FLOW);

    timeComboContainer.add(getTimeComboCaption(), VRLayout.FLOW);

    timeComboContainer.add(getEndComboContainer(), VRLayout.FLOW);

  }

  /**
   * �J�n�����R���{�ɓ������ڂ�ǉ����܂��B
   */
  protected void addBeginCombo(){

  }

  /**
   * �J�n�����R���{���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addBeginComboModel(){

  }

  /**
   * �����L���v�V�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addTimeComboCaption(){

  }

  /**
   * �I�������R���{�ɓ������ڂ�ǉ����܂��B
   */
  protected void addEndCombo(){

  }

  /**
   * �I�������R���{���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addEndComboModel(){

  }

  /**
   * �j���ݒ�̈�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addDayoftheWeekContainer(){

    dayoftheWeekContainer.add(getMondayCheck(), VRLayout.FLOW);

    dayoftheWeekContainer.add(getTuesdayCheck(), VRLayout.FLOW);

    dayoftheWeekContainer.add(getWednesdayCheck(), VRLayout.FLOW);

    dayoftheWeekContainer.add(getThursdayCheck(), VRLayout.FLOW);

    dayoftheWeekContainer.add(getFridayCheck(), VRLayout.FLOW);

    dayoftheWeekContainer.add(getSaturdayCheck(), VRLayout.FLOW);

    dayoftheWeekContainer.add(getSundayCheck(), VRLayout.FLOW);

  }

  /**
   * �`�F�b�N�{�b�N�X���j�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMondayCheck(){

  }

  /**
   * �`�F�b�N�{�b�N�X�Ηj�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTuesdayCheck(){

  }

  /**
   * �`�F�b�N�{�b�N�X���j�ɓ������ڂ�ǉ����܂��B
   */
  protected void addWednesdayCheck(){

  }

  /**
   * �`�F�b�N�{�b�N�X�ؗj�ɓ������ڂ�ǉ����܂��B
   */
  protected void addThursdayCheck(){

  }

  /**
   * �`�F�b�N�{�b�N�X���j�ɓ������ڂ�ǉ����܂��B
   */
  protected void addFridayCheck(){

  }

  /**
   * �`�F�b�N�{�b�N�X�y�j�ɓ������ڂ�ǉ����܂��B
   */
  protected void addSaturdayCheck(){

  }

  /**
   * �`�F�b�N�{�b�N�X���j�ɓ������ڂ�ǉ����܂��B
   */
  protected void addSundayCheck(){

  }

  /**
   * �\��t���{�^���̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTimeButtons(){

    timeButtons.add(getTimeButton(), VRLayout.SOUTH);
  }

  /**
   * �\��t���{�^���ɓ������ڂ�ǉ����܂��B
   */
  protected void addTimeButton(){

  }

  /**
   * �T�P�ʈȊO�̃T�[�r�X�̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addExceptionServiceCombos(){

    exceptionServiceCombos.add(getExceptionComboContena(), VRLayout.FLOW);

    exceptionServiceCombos.add(getExceptionButton(), VRLayout.EAST);
    exceptionServiceCombos.add(getEverydayButton(), VRLayout.EAST);
  }

  /**
   * �R���{�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addExceptionComboContena(){

    exceptionComboContena.add(getExceptionBeginComboContainer(), VRLayout.FLOW);

    exceptionComboContena.add(getExceptionBeginLabel(), VRLayout.FLOW);

    exceptionComboContena.add(getExceptionEndComboContainer(), VRLayout.FLOW);

    exceptionComboContena.add(getExceptionEndLabel(), VRLayout.FLOW);

  }

  /**
   * �J�n�R���{�ɓ������ڂ�ǉ����܂��B
   */
  protected void addExceptionBeginCombo(){

  }

  /**
   * �J�n�R���{���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addExceptionBeginComboModel(){

  }

  /**
   * ���烉�x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addExceptionBeginLabel(){

  }

  /**
   * �I���R���{�ɓ������ڂ�ǉ����܂��B
   */
  protected void addExceptionEndCombo(){

  }

  /**
   * �I���R���{���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addExceptionEndComboModel(){

  }

  /**
   * ���ԃ��x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addExceptionEndLabel(){

  }

  /**
   * �����{�^���ɓ������ڂ�ǉ����܂��B
   */
  protected void addEverydayButton(){

  }

  /**
   * �\��t���{�^���ɓ������ڂ�ǉ����܂��B
   */
  protected void addExceptionButton(){

  }

  /**
   * �T�ԕ\�̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addWeeklyCharts(){

    weeklyCharts.add(getWeeklySchedule(), VRLayout.CLIENT);

  }

  /**
   * �T�ԕ\�ɓ������ڂ�ǉ����܂��B
   */
  protected void addWeeklySchedule(){

  }

  /**
   * �����̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addBottoms(){

    bottoms.add(getNonWeeks(), VRLayout.CLIENT);

    bottoms.add(getLowerRights(), VRLayout.EAST);
  }

  /**
   * �T�P�ʈȊO�̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addNonWeeks(){

    nonWeeks.add(getFreedayServices(), VRLayout.CLIENT);

  }

  /**
   * �T�P�ʈȊO�̃T�[�r�X�ɓ������ڂ�ǉ����܂��B
   */
  protected void addFreedayServices(){

  }

  /**
   * �����E�̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addLowerRights(){

    lowerRights.add(getExpansions(), VRLayout.CLIENT);

    lowerRights.add(getWeeklyServicePlans(), VRLayout.SOUTH);
  }

  /**
   * ���ԂɓW�J�̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addExpansions(){

    expansions.add(getExpansionStartDateContainer(), VRLayout.FLOW);

    expansions.add(getExpansionButton(), VRLayout.FLOW_RETURN);

  }

  /**
   * �W�J�J�n���R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addExpansionStartDateContainer(){

    expansionStartDateContainer.add(getExpansionStartDate(), VRLayout.FLOW);

    expansionStartDateContainer.add(getExpansionStartDateCaption(), VRLayout.FLOW);

  }

  /**
   * ���t�ɓ������ڂ�ǉ����܂��B
   */
  protected void addExpansionStartDate(){

  }

  /**
   * �L���v�V�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addExpansionStartDateCaption(){

  }

  /**
   * �W�J�{�^���ɓ������ڂ�ǉ����܂��B
   */
  protected void addExpansionButton(){

  }

  /**
   * �T�ԃT�[�r�X�v��\�̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addWeeklyServicePlans(){

    weeklyServicePlans.add(getCreateDateContainer(), VRLayout.FLOW);

  }

  /**
   * �쐬�N�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addCreateDate(){

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
      ACFrame.getInstance().getContentPane().add(new QS001001Design());
      ACFrame.getInstance().setVisible(true);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QS001001Design getThis() {
    return this;
  }
}
