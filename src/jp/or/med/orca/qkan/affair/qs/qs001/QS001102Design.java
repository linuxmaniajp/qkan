
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
 * �쐬��: 2006/03/26  ���{�R���s���[�^�[������� ���{�@�K�� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �\��Ǘ� (S)
 * �v���Z�X �T�[�r�X�\�� (001)
 * �v���O���� �T�[�r�X�p�^�[���K�������� (QS001102)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
import java.awt.Component;

import jp.nichicom.ac.component.ACClearableRadioButtonGroup;
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
 * �T�[�r�X�p�^�[���K���������ʍ��ڃf�U�C��(QS001102) 
 */
public class QS001102Design extends QS001ServicePanel {
  //GUI�R���|�[�l���g

  private ACPanel homonNyuyokuPatterns;

  private ACClearableRadioButtonGroup homonNyuyokuClass;

  private ACLabelContainer homonNyuyokuClassContainer;

  private ACListModelAdapter homonNyuyokuClassModel;

  private ACRadioButtonItem homonNyuyokuClassDouble;

  private ACRadioButtonItem homonNyuyokuClassSingle;

  private ACClearableRadioButtonGroup homonNyuyokuPartsRadio;

  private ACLabelContainer homonNyuyokuPartsRadioContainer;

  private ACListModelAdapter homonNyuyokuPartsRadioModel;

  private ACRadioButtonItem homonNyuyokuPartsRadioItem1;

  private ACRadioButtonItem homonNyuyokuPartsRadioItem2;

  private ACBackLabelContainer homonNyuyokuTimeContainer;

  private ACTimeComboBox homonNyuyokuBeginTime;

  private ACLabelContainer homonNyuyokuBeginTimeContainer;

  private ACComboBoxModelAdapter homonNyuyokuBeginTimeModel;

  private ACTimeComboBox homonNyuyokuEndTime;

  private ACLabelContainer homonNyuyokuEndTimeContainer;

  private ACComboBoxModelAdapter homonNyuyokuEndTimeModel;

  //getter

  /**
   * �K��������p�^�[���̈���擾���܂��B
   * @return �K��������p�^�[���̈�
   */
  public ACPanel getHomonNyuyokuPatterns(){
    if(homonNyuyokuPatterns==null){

      homonNyuyokuPatterns = new ACPanel();

      addHomonNyuyokuPatterns();
    }
    return homonNyuyokuPatterns;

  }

  /**
   * �K��҂̎�ʃ��W�I�O���[�v���擾���܂��B
   * @return �K��҂̎�ʃ��W�I�O���[�v
   */
  public ACClearableRadioButtonGroup getHomonNyuyokuClass(){
    if(homonNyuyokuClass==null){

      homonNyuyokuClass = new ACClearableRadioButtonGroup();

      getHomonNyuyokuClassContainer().setText("�K��҂̐l��");

      homonNyuyokuClass.setBindPath("1120103");

      homonNyuyokuClass.setUseClearButton(false);

      homonNyuyokuClass.setModel(getHomonNyuyokuClassModel());

      addHomonNyuyokuClass();
    }
    return homonNyuyokuClass;

  }

  /**
   * �K��҂̎�ʃ��W�I�O���[�v�R���e�i���擾���܂��B
   * @return �K��҂̎�ʃ��W�I�O���[�v�R���e�i
   */
  protected ACLabelContainer getHomonNyuyokuClassContainer(){
    if(homonNyuyokuClassContainer==null){
      homonNyuyokuClassContainer = new ACLabelContainer();
      homonNyuyokuClassContainer.setFollowChildEnabled(true);
      homonNyuyokuClassContainer.setVAlignment(VRLayout.CENTER);
      homonNyuyokuClassContainer.add(getHomonNyuyokuClass(), null);
    }
    return homonNyuyokuClassContainer;
  }

  /**
   * �K��҂̎�ʃ��W�I�O���[�v���f�����擾���܂��B
   * @return �K��҂̎�ʃ��W�I�O���[�v���f��
   */
  protected ACListModelAdapter getHomonNyuyokuClassModel(){
    if(homonNyuyokuClassModel==null){
      homonNyuyokuClassModel = new ACListModelAdapter();
      addHomonNyuyokuClassModel();
    }
    return homonNyuyokuClassModel;
  }

  /**
   * �Ō�E��1�l�{���E��2�l���擾���܂��B
   * @return �Ō�E��1�l�{���E��2�l
   */
  public ACRadioButtonItem getHomonNyuyokuClassDouble(){
    if(homonNyuyokuClassDouble==null){

      homonNyuyokuClassDouble = new ACRadioButtonItem();

      homonNyuyokuClassDouble.setText("�Ō�E��1�l�y�щ��E��2�l");

      homonNyuyokuClassDouble.setGroup(getHomonNyuyokuClass());

      homonNyuyokuClassDouble.setConstraints(VRLayout.FLOW_RETURN);

      addHomonNyuyokuClassDouble();
    }
    return homonNyuyokuClassDouble;

  }

  /**
   * ���E��3�l���擾���܂��B
   * @return ���E��3�l
   */
  public ACRadioButtonItem getHomonNyuyokuClassSingle(){
    if(homonNyuyokuClassSingle==null){

      homonNyuyokuClassSingle = new ACRadioButtonItem();

      homonNyuyokuClassSingle.setText("���E��3�l");

      homonNyuyokuClassSingle.setGroup(getHomonNyuyokuClass());

      homonNyuyokuClassSingle.setConstraints(VRLayout.FLOW);

      addHomonNyuyokuClassSingle();
    }
    return homonNyuyokuClassSingle;

  }

  /**
   * �K��������敪���W�I�O���[�v���擾���܂��B
   * @return �K��������敪���W�I�O���[�v
   */
  public ACClearableRadioButtonGroup getHomonNyuyokuPartsRadio(){
    if(homonNyuyokuPartsRadio==null){

      homonNyuyokuPartsRadio = new ACClearableRadioButtonGroup();

      getHomonNyuyokuPartsRadioContainer().setText("�������敪");

      homonNyuyokuPartsRadio.setBindPath("1120104");

      homonNyuyokuPartsRadio.setUseClearButton(false);

      homonNyuyokuPartsRadio.setModel(getHomonNyuyokuPartsRadioModel());

      addHomonNyuyokuPartsRadio();
    }
    return homonNyuyokuPartsRadio;

  }

  /**
   * �K��������敪���W�I�O���[�v�R���e�i���擾���܂��B
   * @return �K��������敪���W�I�O���[�v�R���e�i
   */
  protected ACLabelContainer getHomonNyuyokuPartsRadioContainer(){
    if(homonNyuyokuPartsRadioContainer==null){
      homonNyuyokuPartsRadioContainer = new ACLabelContainer();
      homonNyuyokuPartsRadioContainer.setFollowChildEnabled(true);
      homonNyuyokuPartsRadioContainer.setVAlignment(VRLayout.CENTER);
      homonNyuyokuPartsRadioContainer.add(getHomonNyuyokuPartsRadio(), null);
    }
    return homonNyuyokuPartsRadioContainer;
  }

  /**
   * �K��������敪���W�I�O���[�v���f�����擾���܂��B
   * @return �K��������敪���W�I�O���[�v���f��
   */
  protected ACListModelAdapter getHomonNyuyokuPartsRadioModel(){
    if(homonNyuyokuPartsRadioModel==null){
      homonNyuyokuPartsRadioModel = new ACListModelAdapter();
      addHomonNyuyokuPartsRadioModel();
    }
    return homonNyuyokuPartsRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getHomonNyuyokuPartsRadioItem1(){
    if(homonNyuyokuPartsRadioItem1==null){

      homonNyuyokuPartsRadioItem1 = new ACRadioButtonItem();

      homonNyuyokuPartsRadioItem1.setText("�Ȃ�");

      homonNyuyokuPartsRadioItem1.setGroup(getHomonNyuyokuPartsRadio());

      homonNyuyokuPartsRadioItem1.setConstraints(VRLayout.FLOW);

      addHomonNyuyokuPartsRadioItem1();
    }
    return homonNyuyokuPartsRadioItem1;

  }

  /**
   * �������E���@�݂̂��擾���܂��B
   * @return �������E���@�̂�
   */
  public ACRadioButtonItem getHomonNyuyokuPartsRadioItem2(){
    if(homonNyuyokuPartsRadioItem2==null){

      homonNyuyokuPartsRadioItem2 = new ACRadioButtonItem();

      homonNyuyokuPartsRadioItem2.setText("�������E���@�̂�");

      homonNyuyokuPartsRadioItem2.setGroup(getHomonNyuyokuPartsRadio());

      homonNyuyokuPartsRadioItem2.setConstraints(VRLayout.FLOW);

      addHomonNyuyokuPartsRadioItem2();
    }
    return homonNyuyokuPartsRadioItem2;

  }

  /**
   * �񋟎��ԃR���e�i���擾���܂��B
   * @return �񋟎��ԃR���e�i
   */
  public ACBackLabelContainer getHomonNyuyokuTimeContainer(){
    if(homonNyuyokuTimeContainer==null){

      homonNyuyokuTimeContainer = new ACBackLabelContainer();

      addHomonNyuyokuTimeContainer();
    }
    return homonNyuyokuTimeContainer;

  }

  /**
   * �J�n�����R���{���擾���܂��B
   * @return �J�n�����R���{
   */
  public ACTimeComboBox getHomonNyuyokuBeginTime(){
    if(homonNyuyokuBeginTime==null){

      homonNyuyokuBeginTime = new ACTimeComboBox();

      getHomonNyuyokuBeginTimeContainer().setText("�J�n����");

      homonNyuyokuBeginTime.setBindPath("3");

      homonNyuyokuBeginTime.setModelBindPath("3");

      homonNyuyokuBeginTime.setRenderBindPath("CONTENT");

      homonNyuyokuBeginTime.setModel(getHomonNyuyokuBeginTimeModel());

      addHomonNyuyokuBeginTime();
    }
    return homonNyuyokuBeginTime;

  }

  /**
   * �J�n�����R���{�R���e�i���擾���܂��B
   * @return �J�n�����R���{�R���e�i
   */
  protected ACLabelContainer getHomonNyuyokuBeginTimeContainer(){
    if(homonNyuyokuBeginTimeContainer==null){
      homonNyuyokuBeginTimeContainer = new ACLabelContainer();
      homonNyuyokuBeginTimeContainer.setFollowChildEnabled(true);
      homonNyuyokuBeginTimeContainer.setVAlignment(VRLayout.CENTER);
      homonNyuyokuBeginTimeContainer.add(getHomonNyuyokuBeginTime(), null);
    }
    return homonNyuyokuBeginTimeContainer;
  }

  /**
   * �J�n�����R���{���f�����擾���܂��B
   * @return �J�n�����R���{���f��
   */
  protected ACComboBoxModelAdapter getHomonNyuyokuBeginTimeModel(){
    if(homonNyuyokuBeginTimeModel==null){
      homonNyuyokuBeginTimeModel = new ACComboBoxModelAdapter();
      addHomonNyuyokuBeginTimeModel();
    }
    return homonNyuyokuBeginTimeModel;
  }

  /**
   * �I�������R���{���擾���܂��B
   * @return �I�������R���{
   */
  public ACTimeComboBox getHomonNyuyokuEndTime(){
    if(homonNyuyokuEndTime==null){

      homonNyuyokuEndTime = new ACTimeComboBox();

      getHomonNyuyokuEndTimeContainer().setText("�I������");

      homonNyuyokuEndTime.setBindPath("4");

      homonNyuyokuEndTime.setModelBindPath("4");

      homonNyuyokuEndTime.setRenderBindPath("CONTENT");

      homonNyuyokuEndTime.setModel(getHomonNyuyokuEndTimeModel());

      addHomonNyuyokuEndTime();
    }
    return homonNyuyokuEndTime;

  }

  /**
   * �I�������R���{�R���e�i���擾���܂��B
   * @return �I�������R���{�R���e�i
   */
  protected ACLabelContainer getHomonNyuyokuEndTimeContainer(){
    if(homonNyuyokuEndTimeContainer==null){
      homonNyuyokuEndTimeContainer = new ACLabelContainer();
      homonNyuyokuEndTimeContainer.setFollowChildEnabled(true);
      homonNyuyokuEndTimeContainer.setVAlignment(VRLayout.CENTER);
      homonNyuyokuEndTimeContainer.add(getHomonNyuyokuEndTime(), null);
    }
    return homonNyuyokuEndTimeContainer;
  }

  /**
   * �I�������R���{���f�����擾���܂��B
   * @return �I�������R���{���f��
   */
  protected ACComboBoxModelAdapter getHomonNyuyokuEndTimeModel(){
    if(homonNyuyokuEndTimeModel==null){
      homonNyuyokuEndTimeModel = new ACComboBoxModelAdapter();
      addHomonNyuyokuEndTimeModel();
    }
    return homonNyuyokuEndTimeModel;
  }

  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001102Design() {

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

    this.add(getHomonNyuyokuPatterns(), VRLayout.CLIENT);

  }

  /**
   * �K��������p�^�[���̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHomonNyuyokuPatterns(){

    homonNyuyokuPatterns.add(getHomonNyuyokuClassContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    homonNyuyokuPatterns.add(getHomonNyuyokuPartsRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    homonNyuyokuPatterns.add(getHomonNyuyokuTimeContainer(), VRLayout.FLOW_DOUBLEINSETLINE_RETURN);

  }

  /**
   * �K��҂̎�ʃ��W�I�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHomonNyuyokuClass(){

  }

  /**
   * �K��҂̎�ʃ��W�I�O���[�v���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addHomonNyuyokuClassModel(){

    getHomonNyuyokuClassDouble().setButtonIndex(1);
    getHomonNyuyokuClassModel().add(getHomonNyuyokuClassDouble());

    getHomonNyuyokuClassSingle().setButtonIndex(2);
    getHomonNyuyokuClassModel().add(getHomonNyuyokuClassSingle());

  }

  /**
   * �Ō�E��1�l�{���E��2�l�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHomonNyuyokuClassDouble(){

  }

  /**
   * ���E��3�l�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHomonNyuyokuClassSingle(){

  }

  /**
   * �K��������敪���W�I�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHomonNyuyokuPartsRadio(){

  }

  /**
   * �K��������敪���W�I�O���[�v���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addHomonNyuyokuPartsRadioModel(){

    getHomonNyuyokuPartsRadioItem1().setButtonIndex(1);
    getHomonNyuyokuPartsRadioModel().add(getHomonNyuyokuPartsRadioItem1());

    getHomonNyuyokuPartsRadioItem2().setButtonIndex(2);
    getHomonNyuyokuPartsRadioModel().add(getHomonNyuyokuPartsRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addHomonNyuyokuPartsRadioItem1(){

  }

  /**
   * �������E���@�݂̂ɓ������ڂ�ǉ����܂��B
   */
  protected void addHomonNyuyokuPartsRadioItem2(){

  }

  /**
   * �񋟎��ԃR���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHomonNyuyokuTimeContainer(){

    homonNyuyokuTimeContainer.add(getHomonNyuyokuBeginTimeContainer(), VRLayout.FLOW);

    homonNyuyokuTimeContainer.add(getHomonNyuyokuEndTimeContainer(), VRLayout.FLOW);

  }

  /**
   * �J�n�����R���{�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHomonNyuyokuBeginTime(){

  }

  /**
   * �J�n�����R���{���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addHomonNyuyokuBeginTimeModel(){

  }

  /**
   * �I�������R���{�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHomonNyuyokuEndTime(){

  }

  /**
   * �I�������R���{���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addHomonNyuyokuEndTimeModel(){

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
      ACFrame.debugStart(new ACAffairInfo(QS001102Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QS001102Design getThis() {
    return this;
  }
}
