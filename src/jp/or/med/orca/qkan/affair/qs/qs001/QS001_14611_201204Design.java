
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
 * �쐬��: 2012/01/31  ���{�R���s���[�^�[������� ����@��F �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �T�[�r�X�\��쐬/�ύX (S)
 * �v���Z�X �T�[�r�X�\��T�� (001)
 * �v���O���� �T�[�r�X�p�^�[�����\�h�x���� (QS001_14611_201204)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
import java.awt.Component;
import java.awt.im.InputSubset;

import jp.nichicom.ac.ACConstants;
import jp.nichicom.ac.component.ACComboBox;
import jp.nichicom.ac.component.ACRadioButtonItem;
import jp.nichicom.ac.component.ACTextField;
import jp.nichicom.ac.component.ACValueArrayRadioButtonGroup;
import jp.nichicom.ac.container.ACGroupBox;
import jp.nichicom.ac.container.ACLabelContainer;
import jp.nichicom.ac.container.ACPanel;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.util.adapter.ACComboBoxModelAdapter;
import jp.nichicom.ac.util.adapter.ACListModelAdapter;
import jp.nichicom.vr.layout.VRLayout;
import jp.nichicom.vr.text.VRCharType;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
/**
 * �T�[�r�X�p�^�[�����\�h�x�����ʍ��ڃf�U�C��(QS001_14611_201204) 
 */
public class QS001_14611_201204Design extends QS001ServicePanel {
  //GUI�R���|�[�l���g

  private ACPanel preventiveSupportExpensePatterns;

  private ACValueArrayRadioButtonGroup firstTimeAddRadio;

  private ACLabelContainer firstTimeAddRadioContainer;

  private ACListModelAdapter firstTimeAddRadioModel;

  private ACRadioButtonItem firstTimeAddRadioItem1;

  private ACRadioButtonItem firstTimeAddRadioItem2;

  private ACValueArrayRadioButtonGroup kaigoSupportCooperateAddRadio;

  private ACLabelContainer kaigoSupportCooperateAddRadioContainer;

  private ACListModelAdapter kaigoSupportCooperateAddRadioModel;

  private ACRadioButtonItem kaigoSupportCooperateAddRadioItem1;

  private ACRadioButtonItem kaigoSupportCooperateAddRadioItem2;

  private ACTextField careManagerNoText;

  private ACLabelContainer careManagerNoTextContainer;

  private ACComboBox careManagerNameCombo;

  private ACLabelContainer careManagerNameComboContainer;

  private ACComboBoxModelAdapter careManagerNameComboModel;

  private ACGroupBox consignmentGroup;

  private ACComboBox consignmentProvider;

  private ACLabelContainer consignmentProviderContainer;

  private ACComboBoxModelAdapter consignmentProviderModel;

  private ACTextField consignmentCareManagerNoText;

  private ACLabelContainer consignmentCareManagerNoTextContainer;

  private ACComboBox consignmentCareManagerNameCombo;

  private ACLabelContainer consignmentCareManagerNameComboContainer;

  private ACComboBoxModelAdapter consignmentCareManagerNameComboModel;

  //getter

  /**
   * �\�h�x����p�^�[���̈���擾���܂��B
   * @return �\�h�x����p�^�[���̈�
   */
  public ACPanel getPreventiveSupportExpensePatterns(){
    if(preventiveSupportExpensePatterns==null){

      preventiveSupportExpensePatterns = new ACPanel();

      preventiveSupportExpensePatterns.setFollowChildEnabled(true);

      addPreventiveSupportExpensePatterns();
    }
    return preventiveSupportExpensePatterns;

  }

  /**
   * ������Z���擾���܂��B
   * @return ������Z
   */
  public ACValueArrayRadioButtonGroup getFirstTimeAddRadio(){
    if(firstTimeAddRadio==null){

      firstTimeAddRadio = new ACValueArrayRadioButtonGroup();

      getFirstTimeAddRadioContainer().setText("������Z");

      firstTimeAddRadio.setBindPath("1460101");

      firstTimeAddRadio.setUseClearButton(false);

      firstTimeAddRadio.setModel(getFirstTimeAddRadioModel());

      firstTimeAddRadio.setValues(new int[]{1,2});

      addFirstTimeAddRadio();
    }
    return firstTimeAddRadio;

  }

  /**
   * ������Z�R���e�i���擾���܂��B
   * @return ������Z�R���e�i
   */
  protected ACLabelContainer getFirstTimeAddRadioContainer(){
    if(firstTimeAddRadioContainer==null){
      firstTimeAddRadioContainer = new ACLabelContainer();
      firstTimeAddRadioContainer.setFollowChildEnabled(true);
      firstTimeAddRadioContainer.setVAlignment(VRLayout.CENTER);
      firstTimeAddRadioContainer.add(getFirstTimeAddRadio(), null);
    }
    return firstTimeAddRadioContainer;
  }

  /**
   * ������Z���f�����擾���܂��B
   * @return ������Z���f��
   */
  protected ACListModelAdapter getFirstTimeAddRadioModel(){
    if(firstTimeAddRadioModel==null){
      firstTimeAddRadioModel = new ACListModelAdapter();
      addFirstTimeAddRadioModel();
    }
    return firstTimeAddRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getFirstTimeAddRadioItem1(){
    if(firstTimeAddRadioItem1==null){

      firstTimeAddRadioItem1 = new ACRadioButtonItem();

      firstTimeAddRadioItem1.setText("�Ȃ�");

      firstTimeAddRadioItem1.setGroup(getFirstTimeAddRadio());

      firstTimeAddRadioItem1.setConstraints(VRLayout.FLOW);

      addFirstTimeAddRadioItem1();
    }
    return firstTimeAddRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getFirstTimeAddRadioItem2(){
    if(firstTimeAddRadioItem2==null){

      firstTimeAddRadioItem2 = new ACRadioButtonItem();

      firstTimeAddRadioItem2.setText("����");

      firstTimeAddRadioItem2.setGroup(getFirstTimeAddRadio());

      firstTimeAddRadioItem2.setConstraints(VRLayout.FLOW);

      addFirstTimeAddRadioItem2();
    }
    return firstTimeAddRadioItem2;

  }

  /**
   * ���\�h���K�͑��@�\�^<���s>�����쎖�Ə��A�g���Z���擾���܂��B
   * @return ���\�h���K�͑��@�\�^<���s>�����쎖�Ə��A�g���Z
   */
  public ACValueArrayRadioButtonGroup getKaigoSupportCooperateAddRadio(){
    if(kaigoSupportCooperateAddRadio==null){

      kaigoSupportCooperateAddRadio = new ACValueArrayRadioButtonGroup();

      getKaigoSupportCooperateAddRadioContainer().setText("���\�h���K�͑��@�\�^" + ACConstants.LINE_SEPARATOR + "�����쎖�Ə��A�g���Z");

      kaigoSupportCooperateAddRadio.setBindPath("1460104");

      kaigoSupportCooperateAddRadio.setUseClearButton(false);

      kaigoSupportCooperateAddRadio.setModel(getKaigoSupportCooperateAddRadioModel());

      kaigoSupportCooperateAddRadio.setValues(new int[]{1,2});

      addKaigoSupportCooperateAddRadio();
    }
    return kaigoSupportCooperateAddRadio;

  }

  /**
   * ���\�h���K�͑��@�\�^<���s>�����쎖�Ə��A�g���Z�R���e�i���擾���܂��B
   * @return ���\�h���K�͑��@�\�^<���s>�����쎖�Ə��A�g���Z�R���e�i
   */
  protected ACLabelContainer getKaigoSupportCooperateAddRadioContainer(){
    if(kaigoSupportCooperateAddRadioContainer==null){
      kaigoSupportCooperateAddRadioContainer = new ACLabelContainer();
      kaigoSupportCooperateAddRadioContainer.setFollowChildEnabled(true);
      kaigoSupportCooperateAddRadioContainer.setVAlignment(VRLayout.CENTER);
      kaigoSupportCooperateAddRadioContainer.add(getKaigoSupportCooperateAddRadio(), null);
    }
    return kaigoSupportCooperateAddRadioContainer;
  }

  /**
   * ���\�h���K�͑��@�\�^<���s>�����쎖�Ə��A�g���Z���f�����擾���܂��B
   * @return ���\�h���K�͑��@�\�^<���s>�����쎖�Ə��A�g���Z���f��
   */
  protected ACListModelAdapter getKaigoSupportCooperateAddRadioModel(){
    if(kaigoSupportCooperateAddRadioModel==null){
      kaigoSupportCooperateAddRadioModel = new ACListModelAdapter();
      addKaigoSupportCooperateAddRadioModel();
    }
    return kaigoSupportCooperateAddRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getKaigoSupportCooperateAddRadioItem1(){
    if(kaigoSupportCooperateAddRadioItem1==null){

      kaigoSupportCooperateAddRadioItem1 = new ACRadioButtonItem();

      kaigoSupportCooperateAddRadioItem1.setText("�Ȃ�");

      kaigoSupportCooperateAddRadioItem1.setGroup(getKaigoSupportCooperateAddRadio());

      kaigoSupportCooperateAddRadioItem1.setConstraints(VRLayout.FLOW);

      addKaigoSupportCooperateAddRadioItem1();
    }
    return kaigoSupportCooperateAddRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getKaigoSupportCooperateAddRadioItem2(){
    if(kaigoSupportCooperateAddRadioItem2==null){

      kaigoSupportCooperateAddRadioItem2 = new ACRadioButtonItem();

      kaigoSupportCooperateAddRadioItem2.setText("����");

      kaigoSupportCooperateAddRadioItem2.setGroup(getKaigoSupportCooperateAddRadio());

      kaigoSupportCooperateAddRadioItem2.setConstraints(VRLayout.FLOW);

      addKaigoSupportCooperateAddRadioItem2();
    }
    return kaigoSupportCooperateAddRadioItem2;

  }

  /**
   * ���x�������ԍ����擾���܂��B
   * @return ���x�������ԍ�
   */
  public ACTextField getCareManagerNoText(){
    if(careManagerNoText==null){

      careManagerNoText = new ACTextField();

      getCareManagerNoTextContainer().setText("���x�������ԍ�");

      careManagerNoText.setBindPath("1430107");

      careManagerNoText.setColumns(10);

      careManagerNoText.setCharType(VRCharType.ONLY_DIGIT);

      careManagerNoText.setMaxLength(8);

      addCareManagerNoText();
    }
    return careManagerNoText;

  }

  /**
   * ���x�������ԍ��R���e�i���擾���܂��B
   * @return ���x�������ԍ��R���e�i
   */
  protected ACLabelContainer getCareManagerNoTextContainer(){
    if(careManagerNoTextContainer==null){
      careManagerNoTextContainer = new ACLabelContainer();
      careManagerNoTextContainer.setFollowChildEnabled(true);
      careManagerNoTextContainer.setVAlignment(VRLayout.CENTER);
      careManagerNoTextContainer.add(getCareManagerNoText(), null);
    }
    return careManagerNoTextContainer;
  }

  /**
   * ���x�������������擾���܂��B
   * @return ���x����������
   */
  public ACComboBox getCareManagerNameCombo(){
    if(careManagerNameCombo==null){

      careManagerNameCombo = new ACComboBox();

      getCareManagerNameComboContainer().setText("���x����������");

      careManagerNameCombo.setEditable(false);

      careManagerNameCombo.setRenderBindPath("STAFF_NAME");

      careManagerNameCombo.setBlankable(true);

      careManagerNameCombo.setIMEMode(InputSubset.KANJI);

      careManagerNameCombo.setMaxLength(30);

      careManagerNameCombo.setMaxColumns(10);

      careManagerNameCombo.setModel(getCareManagerNameComboModel());

      addCareManagerNameCombo();
    }
    return careManagerNameCombo;

  }

  /**
   * ���x�����������R���e�i���擾���܂��B
   * @return ���x�����������R���e�i
   */
  protected ACLabelContainer getCareManagerNameComboContainer(){
    if(careManagerNameComboContainer==null){
      careManagerNameComboContainer = new ACLabelContainer();
      careManagerNameComboContainer.setFollowChildEnabled(true);
      careManagerNameComboContainer.setVAlignment(VRLayout.CENTER);
      careManagerNameComboContainer.add(getCareManagerNameCombo(), null);
    }
    return careManagerNameComboContainer;
  }

  /**
   * ���x�������������f�����擾���܂��B
   * @return ���x�������������f��
   */
  protected ACComboBoxModelAdapter getCareManagerNameComboModel(){
    if(careManagerNameComboModel==null){
      careManagerNameComboModel = new ACComboBoxModelAdapter();
      addCareManagerNameComboModel();
    }
    return careManagerNameComboModel;
  }

  /**
   * �ϑ���O���[�v���擾���܂��B
   * @return �ϑ���O���[�v
   */
  public ACGroupBox getConsignmentGroup(){
    if(consignmentGroup==null){

      consignmentGroup = new ACGroupBox();

      consignmentGroup.setText("�ϑ���");

      consignmentGroup.setFollowChildEnabled(true);

      consignmentGroup.setHgap(0);

      consignmentGroup.setLabelMargin(0);

      consignmentGroup.setVgap(0);

      addConsignmentGroup();
    }
    return consignmentGroup;

  }

  /**
   * �ϑ��掖�Ə����擾���܂��B
   * @return �ϑ��掖�Ə�
   */
  public ACComboBox getConsignmentProvider(){
    if(consignmentProvider==null){

      consignmentProvider = new ACComboBox();

      getConsignmentProviderContainer().setText("�ϑ��掖�Ə�");

      consignmentProvider.setBindPath("1460102");

      consignmentProvider.setEditable(false);

      consignmentProvider.setRenderBindPath("PROVIDER_NAME");

      consignmentProvider.setBlankable(true);

      consignmentProvider.setIMEMode(InputSubset.KANJI);

      consignmentProvider.setMaxLength(60);

      consignmentProvider.setMaxColumns(10);

      consignmentProvider.setModel(getConsignmentProviderModel());

      addConsignmentProvider();
    }
    return consignmentProvider;

  }

  /**
   * �ϑ��掖�Ə��R���e�i���擾���܂��B
   * @return �ϑ��掖�Ə��R���e�i
   */
  protected ACLabelContainer getConsignmentProviderContainer(){
    if(consignmentProviderContainer==null){
      consignmentProviderContainer = new ACLabelContainer();
      consignmentProviderContainer.setFollowChildEnabled(true);
      consignmentProviderContainer.setVAlignment(VRLayout.CENTER);
      consignmentProviderContainer.add(getConsignmentProvider(), null);
    }
    return consignmentProviderContainer;
  }

  /**
   * �ϑ��掖�Ə����f�����擾���܂��B
   * @return �ϑ��掖�Ə����f��
   */
  protected ACComboBoxModelAdapter getConsignmentProviderModel(){
    if(consignmentProviderModel==null){
      consignmentProviderModel = new ACComboBoxModelAdapter();
      addConsignmentProviderModel();
    }
    return consignmentProviderModel;
  }

  /**
   * ���x�������ԍ����擾���܂��B
   * @return ���x�������ԍ�
   */
  public ACTextField getConsignmentCareManagerNoText(){
    if(consignmentCareManagerNoText==null){

      consignmentCareManagerNoText = new ACTextField();

      getConsignmentCareManagerNoTextContainer().setText("���x�������ԍ�");

      consignmentCareManagerNoText.setBindPath("1460103");

      consignmentCareManagerNoText.setColumns(10);

      consignmentCareManagerNoText.setCharType(VRCharType.ONLY_DIGIT);

      consignmentCareManagerNoText.setMaxLength(8);

      addConsignmentCareManagerNoText();
    }
    return consignmentCareManagerNoText;

  }

  /**
   * ���x�������ԍ��R���e�i���擾���܂��B
   * @return ���x�������ԍ��R���e�i
   */
  protected ACLabelContainer getConsignmentCareManagerNoTextContainer(){
    if(consignmentCareManagerNoTextContainer==null){
      consignmentCareManagerNoTextContainer = new ACLabelContainer();
      consignmentCareManagerNoTextContainer.setFollowChildEnabled(true);
      consignmentCareManagerNoTextContainer.setVAlignment(VRLayout.CENTER);
      consignmentCareManagerNoTextContainer.add(getConsignmentCareManagerNoText(), null);
    }
    return consignmentCareManagerNoTextContainer;
  }

  /**
   * ���x�����������擾���܂��B
   * @return ���x��������
   */
  public ACComboBox getConsignmentCareManagerNameCombo(){
    if(consignmentCareManagerNameCombo==null){

      consignmentCareManagerNameCombo = new ACComboBox();

      getConsignmentCareManagerNameComboContainer().setText("���x����������");

      consignmentCareManagerNameCombo.setEditable(false);

      consignmentCareManagerNameCombo.setRenderBindPath("CONSIGNMENT_STAFF_NAME");

      consignmentCareManagerNameCombo.setBlankable(true);

      consignmentCareManagerNameCombo.setIMEMode(InputSubset.KANJI);

      consignmentCareManagerNameCombo.setMaxLength(30);

      consignmentCareManagerNameCombo.setMaxColumns(10);

      consignmentCareManagerNameCombo.setModel(getConsignmentCareManagerNameComboModel());

      addConsignmentCareManagerNameCombo();
    }
    return consignmentCareManagerNameCombo;

  }

  /**
   * ���x���������R���e�i���擾���܂��B
   * @return ���x���������R���e�i
   */
  protected ACLabelContainer getConsignmentCareManagerNameComboContainer(){
    if(consignmentCareManagerNameComboContainer==null){
      consignmentCareManagerNameComboContainer = new ACLabelContainer();
      consignmentCareManagerNameComboContainer.setFollowChildEnabled(true);
      consignmentCareManagerNameComboContainer.setVAlignment(VRLayout.CENTER);
      consignmentCareManagerNameComboContainer.add(getConsignmentCareManagerNameCombo(), null);
    }
    return consignmentCareManagerNameComboContainer;
  }

  /**
   * ���x�����������f�����擾���܂��B
   * @return ���x�����������f��
   */
  protected ACComboBoxModelAdapter getConsignmentCareManagerNameComboModel(){
    if(consignmentCareManagerNameComboModel==null){
      consignmentCareManagerNameComboModel = new ACComboBoxModelAdapter();
      addConsignmentCareManagerNameComboModel();
    }
    return consignmentCareManagerNameComboModel;
  }

  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001_14611_201204Design() {

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

    this.add(getPreventiveSupportExpensePatterns(), VRLayout.CLIENT);

  }

  /**
   * �\�h�x����p�^�[���̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPreventiveSupportExpensePatterns(){

    preventiveSupportExpensePatterns.add(getFirstTimeAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    preventiveSupportExpensePatterns.add(getKaigoSupportCooperateAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    preventiveSupportExpensePatterns.add(getCareManagerNoTextContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    preventiveSupportExpensePatterns.add(getCareManagerNameComboContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    preventiveSupportExpensePatterns.add(getConsignmentGroup(), VRLayout.FLOW);

  }

  /**
   * ������Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addFirstTimeAddRadio(){

  }

  /**
   * ������Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addFirstTimeAddRadioModel(){

    getFirstTimeAddRadioItem1().setButtonIndex(1);

    getFirstTimeAddRadioModel().add(getFirstTimeAddRadioItem1());

    getFirstTimeAddRadioItem2().setButtonIndex(2);

    getFirstTimeAddRadioModel().add(getFirstTimeAddRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addFirstTimeAddRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addFirstTimeAddRadioItem2(){

  }

  /**
   * ���\�h���K�͑��@�\�^<���s>�����쎖�Ə��A�g���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoSupportCooperateAddRadio(){

  }

  /**
   * ���\�h���K�͑��@�\�^<���s>�����쎖�Ə��A�g���Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoSupportCooperateAddRadioModel(){

    getKaigoSupportCooperateAddRadioItem1().setButtonIndex(1);

    getKaigoSupportCooperateAddRadioModel().add(getKaigoSupportCooperateAddRadioItem1());

    getKaigoSupportCooperateAddRadioItem2().setButtonIndex(2);

    getKaigoSupportCooperateAddRadioModel().add(getKaigoSupportCooperateAddRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoSupportCooperateAddRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoSupportCooperateAddRadioItem2(){

  }

  /**
   * ���x�������ԍ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addCareManagerNoText(){

  }

  /**
   * ���x�����������ɓ������ڂ�ǉ����܂��B
   */
  protected void addCareManagerNameCombo(){

  }

  /**
   * ���x�������������f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCareManagerNameComboModel(){

  }

  /**
   * �ϑ���O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addConsignmentGroup(){

    consignmentGroup.add(getConsignmentProviderContainer(), VRLayout.FLOW_RETURN);

    consignmentGroup.add(getConsignmentCareManagerNoTextContainer(), VRLayout.FLOW_RETURN);

    consignmentGroup.add(getConsignmentCareManagerNameComboContainer(), VRLayout.FLOW);

  }

  /**
   * �ϑ��掖�Ə��ɓ������ڂ�ǉ����܂��B
   */
  protected void addConsignmentProvider(){

  }

  /**
   * �ϑ��掖�Ə����f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addConsignmentProviderModel(){

  }

  /**
   * ���x�������ԍ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addConsignmentCareManagerNoText(){

  }

  /**
   * ���x���������ɓ������ڂ�ǉ����܂��B
   */
  protected void addConsignmentCareManagerNameCombo(){

  }

  /**
   * ���x�����������f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addConsignmentCareManagerNameComboModel(){

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
      ACFrame.debugStart(new ACAffairInfo(QS001_14611_201204Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QS001_14611_201204Design getThis() {
    return this;
  }
}
