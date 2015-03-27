
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
 * �쐬��: 2015/02/27  ���{�R���s���[�^�[������� �����@���̂� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �T�[�r�X�\��쐬/�ύX (S)
 * �v���Z�X �T�[�r�X�\��T�� (001)
 * �v���O���� �T�[�r�X�p�^�[���Ō쏬�K�͑��@�\�^������ (QS001_17911_201504)
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
 * �T�[�r�X�p�^�[���Ō쏬�K�͑��@�\�^�������ʍ��ڃf�U�C��(QS001_17911_201504) 
 */
public class QS001_17911_201504Design extends QS001ServicePanel {
  //GUI�R���|�[�l���g

  private ACPanel mainGroup;

  private ACValueArrayRadioButtonGroup staffSubtractionRadio;

  private ACLabelContainer staffSubtractionRadioContainer;

  private ACListModelAdapter staffSubtractionRadioModel;

  private ACRadioButtonItem staffSubtractionRadioItem1;

  private ACRadioButtonItem staffSubtractionRadioItem2;

  private ACRadioButtonItem staffSubtractionRadioItem3;

  private ACValueArrayRadioButtonGroup serviceProvisionStructuralAddRadio;

  private ACLabelContainer serviceProvisionStructuralAddRadioContainer;

  private ACListModelAdapter serviceProvisionStructuralAddRadioModel;

  private ACRadioButtonItem serviceProvisionStructuralAddRadioItem1;

  private ACRadioButtonItem serviceProvisionStructuralAddRadioItem2;

  private ACRadioButtonItem serviceProvisionStructuralAddRadioItem3;

  private ACRadioButtonItem serviceProvisionStructuralAddRadioItem4;

  private ACRadioButtonItem serviceProvisionStructuralAddRadioItem5;

  private ACGroupBox tekiyouGroup;

  private ACTextField tekiyouText;

  private ACLabelContainer tekiyouTextContainer;

  private ACLabel tekiyouCommentTitle;

  //getter

  /**
   * �p�^�[���̈���擾���܂��B
   * @return �p�^�[���̈�
   */
  public ACPanel getMainGroup(){
    if(mainGroup==null){

      mainGroup = new ACPanel();

      mainGroup.setFollowChildEnabled(true);

      addMainGroup();
    }
    return mainGroup;

  }

  /**
   * �l�����Z���擾���܂��B
   * @return �l�����Z
   */
  public ACValueArrayRadioButtonGroup getStaffSubtractionRadio(){
    if(staffSubtractionRadio==null){

      staffSubtractionRadio = new ACValueArrayRadioButtonGroup();

      getStaffSubtractionRadioContainer().setText("�l�����Z");

      staffSubtractionRadio.setBindPath("1790101");

      staffSubtractionRadio.setUseClearButton(false);

      staffSubtractionRadio.setModel(getStaffSubtractionRadioModel());

      staffSubtractionRadio.setValues(new int[]{1,2,3});

      addStaffSubtractionRadio();
    }
    return staffSubtractionRadio;

  }

  /**
   * �l�����Z�R���e�i���擾���܂��B
   * @return �l�����Z�R���e�i
   */
  protected ACLabelContainer getStaffSubtractionRadioContainer(){
    if(staffSubtractionRadioContainer==null){
      staffSubtractionRadioContainer = new ACLabelContainer();
      staffSubtractionRadioContainer.setFollowChildEnabled(true);
      staffSubtractionRadioContainer.setVAlignment(VRLayout.CENTER);
      staffSubtractionRadioContainer.add(getStaffSubtractionRadio(), null);
    }
    return staffSubtractionRadioContainer;
  }

  /**
   * �l�����Z���f�����擾���܂��B
   * @return �l�����Z���f��
   */
  protected ACListModelAdapter getStaffSubtractionRadioModel(){
    if(staffSubtractionRadioModel==null){
      staffSubtractionRadioModel = new ACListModelAdapter();
      addStaffSubtractionRadioModel();
    }
    return staffSubtractionRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getStaffSubtractionRadioItem1(){
    if(staffSubtractionRadioItem1==null){

      staffSubtractionRadioItem1 = new ACRadioButtonItem();

      staffSubtractionRadioItem1.setText("�Ȃ�");

      staffSubtractionRadioItem1.setGroup(getStaffSubtractionRadio());

      staffSubtractionRadioItem1.setConstraints(VRLayout.FLOW);

      addStaffSubtractionRadioItem1();
    }
    return staffSubtractionRadioItem1;

  }

  /**
   * ������߂��擾���܂��B
   * @return �������
   */
  public ACRadioButtonItem getStaffSubtractionRadioItem2(){
    if(staffSubtractionRadioItem2==null){

      staffSubtractionRadioItem2 = new ACRadioButtonItem();

      staffSubtractionRadioItem2.setText("�������");

      staffSubtractionRadioItem2.setGroup(getStaffSubtractionRadio());

      staffSubtractionRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

      addStaffSubtractionRadioItem2();
    }
    return staffSubtractionRadioItem2;

  }

  /**
   * �]�ƈ��̕s�����擾���܂��B
   * @return �]�ƈ��̕s��
   */
  public ACRadioButtonItem getStaffSubtractionRadioItem3(){
    if(staffSubtractionRadioItem3==null){

      staffSubtractionRadioItem3 = new ACRadioButtonItem();

      staffSubtractionRadioItem3.setText("�]�ƈ��̕s��");

      staffSubtractionRadioItem3.setGroup(getStaffSubtractionRadio());

      staffSubtractionRadioItem3.setConstraints(VRLayout.FLOW);

      addStaffSubtractionRadioItem3();
    }
    return staffSubtractionRadioItem3;

  }

  /**
   * �T�[�r�X�񋟑̐��������Z���擾���܂��B
   * @return �T�[�r�X�񋟑̐��������Z
   */
  public ACValueArrayRadioButtonGroup getServiceProvisionStructuralAddRadio(){
    if(serviceProvisionStructuralAddRadio==null){

      serviceProvisionStructuralAddRadio = new ACValueArrayRadioButtonGroup();

      getServiceProvisionStructuralAddRadioContainer().setText("�T�[�r�X�񋟑̐��������Z");

      serviceProvisionStructuralAddRadio.setBindPath("1790102");

      serviceProvisionStructuralAddRadio.setNoSelectIndex(0);

      serviceProvisionStructuralAddRadio.setUseClearButton(false);

      serviceProvisionStructuralAddRadio.setModel(getServiceProvisionStructuralAddRadioModel());

      serviceProvisionStructuralAddRadio.setValues(new int[]{1,5,2,3,4});

      addServiceProvisionStructuralAddRadio();
    }
    return serviceProvisionStructuralAddRadio;

  }

  /**
   * �T�[�r�X�񋟑̐��������Z�R���e�i���擾���܂��B
   * @return �T�[�r�X�񋟑̐��������Z�R���e�i
   */
  protected ACLabelContainer getServiceProvisionStructuralAddRadioContainer(){
    if(serviceProvisionStructuralAddRadioContainer==null){
      serviceProvisionStructuralAddRadioContainer = new ACLabelContainer();
      serviceProvisionStructuralAddRadioContainer.setFollowChildEnabled(true);
      serviceProvisionStructuralAddRadioContainer.setVAlignment(VRLayout.CENTER);
      serviceProvisionStructuralAddRadioContainer.add(getServiceProvisionStructuralAddRadio(), null);
    }
    return serviceProvisionStructuralAddRadioContainer;
  }

  /**
   * �T�[�r�X�񋟑̐��������Z���f�����擾���܂��B
   * @return �T�[�r�X�񋟑̐��������Z���f��
   */
  protected ACListModelAdapter getServiceProvisionStructuralAddRadioModel(){
    if(serviceProvisionStructuralAddRadioModel==null){
      serviceProvisionStructuralAddRadioModel = new ACListModelAdapter();
      addServiceProvisionStructuralAddRadioModel();
    }
    return serviceProvisionStructuralAddRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getServiceProvisionStructuralAddRadioItem1(){
    if(serviceProvisionStructuralAddRadioItem1==null){

      serviceProvisionStructuralAddRadioItem1 = new ACRadioButtonItem();

      serviceProvisionStructuralAddRadioItem1.setText("�Ȃ�");

      serviceProvisionStructuralAddRadioItem1.setGroup(getServiceProvisionStructuralAddRadio());

      serviceProvisionStructuralAddRadioItem1.setConstraints(VRLayout.FLOW);

      addServiceProvisionStructuralAddRadioItem1();
    }
    return serviceProvisionStructuralAddRadioItem1;

  }

  /**
   * I�C�^���擾���܂��B
   * @return I�C�^
   */
  public ACRadioButtonItem getServiceProvisionStructuralAddRadioItem2(){
    if(serviceProvisionStructuralAddRadioItem2==null){

      serviceProvisionStructuralAddRadioItem2 = new ACRadioButtonItem();

      serviceProvisionStructuralAddRadioItem2.setText("I�C�^");

      serviceProvisionStructuralAddRadioItem2.setGroup(getServiceProvisionStructuralAddRadio());

      serviceProvisionStructuralAddRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

      addServiceProvisionStructuralAddRadioItem2();
    }
    return serviceProvisionStructuralAddRadioItem2;

  }

  /**
   * I���^���擾���܂��B
   * @return I���^
   */
  public ACRadioButtonItem getServiceProvisionStructuralAddRadioItem3(){
    if(serviceProvisionStructuralAddRadioItem3==null){

      serviceProvisionStructuralAddRadioItem3 = new ACRadioButtonItem();

      serviceProvisionStructuralAddRadioItem3.setText("I���^");

      serviceProvisionStructuralAddRadioItem3.setGroup(getServiceProvisionStructuralAddRadio());

      serviceProvisionStructuralAddRadioItem3.setConstraints(VRLayout.FLOW);

      addServiceProvisionStructuralAddRadioItem3();
    }
    return serviceProvisionStructuralAddRadioItem3;

  }

  /**
   * II�^���擾���܂��B
   * @return II�^
   */
  public ACRadioButtonItem getServiceProvisionStructuralAddRadioItem4(){
    if(serviceProvisionStructuralAddRadioItem4==null){

      serviceProvisionStructuralAddRadioItem4 = new ACRadioButtonItem();

      serviceProvisionStructuralAddRadioItem4.setText("II�^");

      serviceProvisionStructuralAddRadioItem4.setGroup(getServiceProvisionStructuralAddRadio());

      serviceProvisionStructuralAddRadioItem4.setConstraints(VRLayout.FLOW);

      addServiceProvisionStructuralAddRadioItem4();
    }
    return serviceProvisionStructuralAddRadioItem4;

  }

  /**
   * III�^���擾���܂��B
   * @return III�^
   */
  public ACRadioButtonItem getServiceProvisionStructuralAddRadioItem5(){
    if(serviceProvisionStructuralAddRadioItem5==null){

      serviceProvisionStructuralAddRadioItem5 = new ACRadioButtonItem();

      serviceProvisionStructuralAddRadioItem5.setText("III�^");

      serviceProvisionStructuralAddRadioItem5.setGroup(getServiceProvisionStructuralAddRadio());

      serviceProvisionStructuralAddRadioItem5.setConstraints(VRLayout.FLOW);

      addServiceProvisionStructuralAddRadioItem5();
    }
    return serviceProvisionStructuralAddRadioItem5;

  }

  /**
   * �E�v�������O���[�v���擾���܂��B
   * @return �E�v�������O���[�v
   */
  public ACGroupBox getTekiyouGroup(){
    if(tekiyouGroup==null){

      tekiyouGroup = new ACGroupBox();

      tekiyouGroup.setText("�E�v��");

      tekiyouGroup.setVisible(false);

      tekiyouGroup.setEnabled(true);

      tekiyouGroup.setFollowChildEnabled(true);

      tekiyouGroup.setHgap(0);

      tekiyouGroup.setLabelMargin(0);

      tekiyouGroup.setVgap(0);

      addTekiyouGroup();
    }
    return tekiyouGroup;

  }

  /**
   * �E�v���e�L�X�g���擾���܂��B
   * @return �E�v���e�L�X�g
   */
  public ACTextField getTekiyouText(){
    if(tekiyouText==null){

      tekiyouText = new ACTextField();

      getTekiyouTextContainer().setText("�Ō�ʏ��K��h������");

      tekiyouText.setBindPath("1790103");

      tekiyouText.setVisible(false);

      tekiyouText.setEnabled(true);

      tekiyouText.setEditable(true);

      tekiyouText.setColumns(6);

      tekiyouText.setCharType(VRCharType.ONLY_DIGIT);

      tekiyouText.setHorizontalAlignment(SwingConstants.LEFT);

      tekiyouText.setIMEMode(InputSubset.LATIN);

      tekiyouText.setMaxLength(8);

      addTekiyouText();
    }
    return tekiyouText;

  }

  /**
   * �E�v���e�L�X�g�R���e�i���擾���܂��B
   * @return �E�v���e�L�X�g�R���e�i
   */
  protected ACLabelContainer getTekiyouTextContainer(){
    if(tekiyouTextContainer==null){
      tekiyouTextContainer = new ACLabelContainer();
      tekiyouTextContainer.setFollowChildEnabled(true);
      tekiyouTextContainer.setVAlignment(VRLayout.CENTER);
      tekiyouTextContainer.add(getTekiyouText(), null);
    }
    return tekiyouTextContainer;
  }

  /**
   * �E�v���������x�����擾���܂��B
   * @return �E�v���������x��
   */
  public ACLabel getTekiyouCommentTitle(){
    if(tekiyouCommentTitle==null){

      tekiyouCommentTitle = new ACLabel();

      tekiyouCommentTitle.setText("���̈�ԍŏ��̗��p���ɋL�����Ă��������B");

      tekiyouCommentTitle.setIconPath(ACConstants.ICON_PATH_EXCLAMATION_16);

      tekiyouCommentTitle.setAutoWrap(true);

      addTekiyouCommentTitle();
    }
    return tekiyouCommentTitle;

  }

  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001_17911_201504Design() {

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

    this.add(getMainGroup(), VRLayout.CLIENT);

  }

  /**
   * �p�^�[���̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMainGroup(){

    mainGroup.add(getStaffSubtractionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    mainGroup.add(getServiceProvisionStructuralAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    mainGroup.add(getTekiyouGroup(), VRLayout.FLOW_RETURN);

  }

  /**
   * �l�����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffSubtractionRadio(){

  }

  /**
   * �l�����Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffSubtractionRadioModel(){

    getStaffSubtractionRadioItem1().setButtonIndex(1);

    getStaffSubtractionRadioModel().add(getStaffSubtractionRadioItem1());

    getStaffSubtractionRadioItem2().setButtonIndex(2);

    getStaffSubtractionRadioModel().add(getStaffSubtractionRadioItem2());

    getStaffSubtractionRadioItem3().setButtonIndex(3);

    getStaffSubtractionRadioModel().add(getStaffSubtractionRadioItem3());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffSubtractionRadioItem1(){

  }

  /**
   * ������߂ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffSubtractionRadioItem2(){

  }

  /**
   * �]�ƈ��̕s���ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffSubtractionRadioItem3(){

  }

  /**
   * �T�[�r�X�񋟑̐��������Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceProvisionStructuralAddRadio(){

  }

  /**
   * �T�[�r�X�񋟑̐��������Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceProvisionStructuralAddRadioModel(){

    getServiceProvisionStructuralAddRadioItem1().setButtonIndex(1);

    getServiceProvisionStructuralAddRadioModel().add(getServiceProvisionStructuralAddRadioItem1());

    getServiceProvisionStructuralAddRadioItem2().setButtonIndex(5);

    getServiceProvisionStructuralAddRadioModel().add(getServiceProvisionStructuralAddRadioItem2());

    getServiceProvisionStructuralAddRadioItem3().setButtonIndex(2);

    getServiceProvisionStructuralAddRadioModel().add(getServiceProvisionStructuralAddRadioItem3());

    getServiceProvisionStructuralAddRadioItem4().setButtonIndex(3);

    getServiceProvisionStructuralAddRadioModel().add(getServiceProvisionStructuralAddRadioItem4());

    getServiceProvisionStructuralAddRadioItem5().setButtonIndex(4);

    getServiceProvisionStructuralAddRadioModel().add(getServiceProvisionStructuralAddRadioItem5());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceProvisionStructuralAddRadioItem1(){

  }

  /**
   * I�C�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceProvisionStructuralAddRadioItem2(){

  }

  /**
   * I���^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceProvisionStructuralAddRadioItem3(){

  }

  /**
   * II�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceProvisionStructuralAddRadioItem4(){

  }

  /**
   * III�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceProvisionStructuralAddRadioItem5(){

  }

  /**
   * �E�v�������O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTekiyouGroup(){

    tekiyouGroup.add(getTekiyouTextContainer(), VRLayout.FLOW_RETURN);

    tekiyouGroup.add(getTekiyouCommentTitle(), VRLayout.FLOW_RETURN);

  }

  /**
   * �E�v���e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTekiyouText(){

  }

  /**
   * �E�v���������x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addTekiyouCommentTitle(){

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
      ACFrame.debugStart(new ACAffairInfo(QS001_17911_201504Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QS001_17911_201504Design getThis() {
    return this;
  }
}
