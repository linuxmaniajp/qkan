
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
 * �쐬��: 2006/01/26  ���{�R���s���[�^�[������� ���}�@�M�u �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �T�[�r�X�\��쐬/�ύX (S)
 * �v���Z�X �T�[�r�X�\��T�� (001)
 * �v���O���� �T�[�r�X�p�^�[��������x�� (QS001020)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
import java.awt.Component;

import jp.nichicom.ac.component.ACClearableRadioButtonGroup;
import jp.nichicom.ac.component.ACRadioButtonItem;
import jp.nichicom.ac.container.ACLabelContainer;
import jp.nichicom.ac.container.ACPanel;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.util.adapter.ACListModelAdapter;
import jp.nichicom.vr.layout.VRLayout;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
/**
 * �T�[�r�X�p�^�[��������x����ʍ��ڃf�U�C��(QS001020) 
 */
public class QS001020Design extends QS001ServicePanel {
  //GUI�R���|�[�l���g

  private ACPanel kaigoSupportPattern;

  private ACClearableRadioButtonGroup kaigoSupportManagementBasicRadio;

  private ACLabelContainer kaigoSupportManagementBasicRadioContainer;

  private ACListModelAdapter kaigoSupportManagementBasicRadioModel;

  private ACRadioButtonItem kaigoSupportManagementBasicRadioItem1;

  private ACRadioButtonItem kaigoSupportManagementBasicRadioItem2;

  private ACClearableRadioButtonGroup kaigoSupportKindRadio;

  private ACLabelContainer kaigoSupportKindRadioContainer;

  private ACListModelAdapter kaigoSupportKindRadioModel;

  private ACRadioButtonItem kaigoSupportKindRadioItem1;

  private ACRadioButtonItem kaigoSupportKindRadioItem2;

  //getter

  /**
   * ������x���̈���擾���܂��B
   * @return ������x���̈�
   */
  public ACPanel getKaigoSupportPattern(){
    if(kaigoSupportPattern==null){

      kaigoSupportPattern = new ACPanel();

      kaigoSupportPattern.setAutoWrap(false);

      addKaigoSupportPattern();
    }
    return kaigoSupportPattern;

  }

  /**
   * �^�c����Z���擾���܂��B
   * @return �^�c����Z
   */
  public ACClearableRadioButtonGroup getKaigoSupportManagementBasicRadio(){
    if(kaigoSupportManagementBasicRadio==null){

      kaigoSupportManagementBasicRadio = new ACClearableRadioButtonGroup();

      getKaigoSupportManagementBasicRadioContainer().setText("�^�c����Z");

      kaigoSupportManagementBasicRadio.setModel(getKaigoSupportManagementBasicRadioModel());

      kaigoSupportManagementBasicRadio.setUseClearButton(false);

      addKaigoSupportManagementBasicRadio();
    }
    return kaigoSupportManagementBasicRadio;

  }

  /**
   * �^�c����Z�R���e�i���擾���܂��B
   * @return �^�c����Z�R���e�i
   */
  protected ACLabelContainer getKaigoSupportManagementBasicRadioContainer(){
    if(kaigoSupportManagementBasicRadioContainer==null){
      kaigoSupportManagementBasicRadioContainer = new ACLabelContainer();
      kaigoSupportManagementBasicRadioContainer.add(getKaigoSupportManagementBasicRadio(), null);
    }
    return kaigoSupportManagementBasicRadioContainer;
  }

  /**
   * �^�c����Z���f�����擾���܂��B
   * @return �^�c����Z���f��
   */
  protected ACListModelAdapter getKaigoSupportManagementBasicRadioModel(){
    if(kaigoSupportManagementBasicRadioModel==null){
      kaigoSupportManagementBasicRadioModel = new ACListModelAdapter();
      addKaigoSupportManagementBasicRadioModel();
    }
    return kaigoSupportManagementBasicRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getKaigoSupportManagementBasicRadioItem1(){
    if(kaigoSupportManagementBasicRadioItem1==null){

      kaigoSupportManagementBasicRadioItem1 = new ACRadioButtonItem();

      kaigoSupportManagementBasicRadioItem1.setText("�Ȃ�");

      kaigoSupportManagementBasicRadioItem1.setGroup(getKaigoSupportManagementBasicRadio());

      kaigoSupportManagementBasicRadioItem1.setConstraints(VRLayout.FLOW);

      addKaigoSupportManagementBasicRadioItem1();
    }
    return kaigoSupportManagementBasicRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getKaigoSupportManagementBasicRadioItem2(){
    if(kaigoSupportManagementBasicRadioItem2==null){

      kaigoSupportManagementBasicRadioItem2 = new ACRadioButtonItem();

      kaigoSupportManagementBasicRadioItem2.setText("����");

      kaigoSupportManagementBasicRadioItem2.setGroup(getKaigoSupportManagementBasicRadio());

      kaigoSupportManagementBasicRadioItem2.setConstraints(VRLayout.FLOW);

      addKaigoSupportManagementBasicRadioItem2();
    }
    return kaigoSupportManagementBasicRadioItem2;

  }

  /**
   * ��މ��Z���擾���܂��B
   * @return ��މ��Z
   */
  public ACClearableRadioButtonGroup getKaigoSupportKindRadio(){
    if(kaigoSupportKindRadio==null){

      kaigoSupportKindRadio = new ACClearableRadioButtonGroup();

      getKaigoSupportKindRadioContainer().setText("��މ��Z");

      kaigoSupportKindRadio.setModel(getKaigoSupportKindRadioModel());

      kaigoSupportKindRadio.setUseClearButton(false);

      addKaigoSupportKindRadio();
    }
    return kaigoSupportKindRadio;

  }

  /**
   * ��މ��Z�R���e�i���擾���܂��B
   * @return ��މ��Z�R���e�i
   */
  protected ACLabelContainer getKaigoSupportKindRadioContainer(){
    if(kaigoSupportKindRadioContainer==null){
      kaigoSupportKindRadioContainer = new ACLabelContainer();
      kaigoSupportKindRadioContainer.add(getKaigoSupportKindRadio(), null);
    }
    return kaigoSupportKindRadioContainer;
  }

  /**
   * ��މ��Z���f�����擾���܂��B
   * @return ��މ��Z���f��
   */
  protected ACListModelAdapter getKaigoSupportKindRadioModel(){
    if(kaigoSupportKindRadioModel==null){
      kaigoSupportKindRadioModel = new ACListModelAdapter();
      addKaigoSupportKindRadioModel();
    }
    return kaigoSupportKindRadioModel;
  }

  /**
   * 4��ޖ������擾���܂��B
   * @return 4��ޖ���
   */
  public ACRadioButtonItem getKaigoSupportKindRadioItem1(){
    if(kaigoSupportKindRadioItem1==null){

      kaigoSupportKindRadioItem1 = new ACRadioButtonItem();

      kaigoSupportKindRadioItem1.setText("4��ޖ���");

      kaigoSupportKindRadioItem1.setGroup(getKaigoSupportKindRadio());

      kaigoSupportKindRadioItem1.setConstraints(VRLayout.FLOW);

      addKaigoSupportKindRadioItem1();
    }
    return kaigoSupportKindRadioItem1;

  }

  /**
   * 4��ވȏ���擾���܂��B
   * @return 4��ވȏ�
   */
  public ACRadioButtonItem getKaigoSupportKindRadioItem2(){
    if(kaigoSupportKindRadioItem2==null){

      kaigoSupportKindRadioItem2 = new ACRadioButtonItem();

      kaigoSupportKindRadioItem2.setText("4��ވȏ�");

      kaigoSupportKindRadioItem2.setGroup(getKaigoSupportKindRadio());

      kaigoSupportKindRadioItem2.setConstraints(VRLayout.FLOW);

      addKaigoSupportKindRadioItem2();
    }
    return kaigoSupportKindRadioItem2;

  }

  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001020Design() {

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

    this.add(getKaigoSupportPattern(), VRLayout.WEST);

  }

  /**
   * ������x���̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoSupportPattern(){

    kaigoSupportPattern.add(getKaigoSupportManagementBasicRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    kaigoSupportPattern.add(getKaigoSupportKindRadioContainer(), VRLayout.FLOW_INSETLINE);

  }

  /**
   * �^�c����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoSupportManagementBasicRadio(){

  }

  /**
   * �^�c����Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoSupportManagementBasicRadioModel(){

    getKaigoSupportManagementBasicRadioItem1().setButtonIndex(1);
    getKaigoSupportManagementBasicRadioModel().add(getKaigoSupportManagementBasicRadioItem1());

    getKaigoSupportManagementBasicRadioItem2().setButtonIndex(2);
    getKaigoSupportManagementBasicRadioModel().add(getKaigoSupportManagementBasicRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoSupportManagementBasicRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoSupportManagementBasicRadioItem2(){

  }

  /**
   * ��މ��Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoSupportKindRadio(){

  }

  /**
   * ��މ��Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoSupportKindRadioModel(){

    getKaigoSupportKindRadioItem1().setButtonIndex(1);
    getKaigoSupportKindRadioModel().add(getKaigoSupportKindRadioItem1());

    getKaigoSupportKindRadioItem2().setButtonIndex(2);
    getKaigoSupportKindRadioModel().add(getKaigoSupportKindRadioItem2());

  }

  /**
   * 4��ޖ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoSupportKindRadioItem1(){

  }

  /**
   * 4��ވȏ�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoSupportKindRadioItem2(){

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
      ACFrame.getInstance().getContentPane().add(new QS001020Design());
      ACFrame.getInstance().setVisible(true);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QS001020Design getThis() {
    return this;
  }
}
