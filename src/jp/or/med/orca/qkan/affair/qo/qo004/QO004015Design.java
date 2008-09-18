
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
 * �쐬��: 2006/02/18  ���{�R���s���[�^�[������� ���}�@�M�u �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���̑��@�\ (O)
 * �v���Z�X ���Ǝғo�^ (004)
 * �v���O���� ����{�ݓ����҉�� (QO004015)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qo.qo004;
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
import jp.or.med.orca.qkan.lib.*;
import jp.or.med.orca.qkan.text.*;
/**
 * ����{�ݓ����҉���ʍ��ڃf�U�C��(QO004015) 
 */
public class QO004015Design extends ACPanel {
  //GUI�R���|�[�l���g

  private ACGroupBox specificFacilityGroup;

  private ACLabelContainer specificFacilityDiscountContainer;

  private ACTextField specificFacilityDiscountRate;

  private ACLabel specificFacilityDiscountPercentSign;

  private ACClearableRadioButtonGroup functionTrainingGuidanceSystem;

  private ACLabelContainer functionTrainingGuidanceSystemContainer;

  private ACListModelAdapter functionTrainingGuidanceSystemModel;

  private ACRadioButtonItem functionTrainingGuidanceSystemOff;

  private ACRadioButtonItem functionTrainingGuidanceSystemOn;

  private ACClearableRadioButtonGroup staffLack;

  private ACLabelContainer staffLackContainer;

  private ACListModelAdapter staffLackModel;

  private ACRadioButtonItem staffLackOff;

  private ACRadioButtonItem staffLackKango;

  //getter

  /**
   * ���ƃO���[�v���擾���܂��B
   * @return ���ƃO���[�v
   */
  public ACGroupBox getSpecificFacilityGroup(){
    if(specificFacilityGroup==null){

      specificFacilityGroup = new ACGroupBox();

      specificFacilityGroup.setText("����{�ݓ����҉��");

      specificFacilityGroup.setFollowChildEnabled(true);

      specificFacilityGroup.setHgrid(200);

      addSpecificFacilityGroup();
    }
    return specificFacilityGroup;

  }

  /**
   * �������R���e�i���擾���܂��B
   * @return �������R���e�i
   */
  public ACLabelContainer getSpecificFacilityDiscountContainer(){
    if(specificFacilityDiscountContainer==null){

      specificFacilityDiscountContainer = new ACLabelContainer();

      specificFacilityDiscountContainer.setText("������");

      specificFacilityDiscountContainer.setFollowChildEnabled(true);

      addSpecificFacilityDiscountContainer();
    }
    return specificFacilityDiscountContainer;

  }

  /**
   * ���������擾���܂��B
   * @return ������
   */
  public ACTextField getSpecificFacilityDiscountRate(){
    if(specificFacilityDiscountRate==null){

      specificFacilityDiscountRate = new ACTextField();

      specificFacilityDiscountRate.setBindPath("REDUCT_RATE");

      specificFacilityDiscountRate.setColumns(3);

      specificFacilityDiscountRate.setCharType(VRCharType.ONLY_DIGIT);

      specificFacilityDiscountRate.setHorizontalAlignment(SwingConstants.RIGHT);

      specificFacilityDiscountRate.setIMEMode(InputSubset.LATIN);

      specificFacilityDiscountRate.setMaxLength(3);

      addSpecificFacilityDiscountRate();
    }
    return specificFacilityDiscountRate;

  }

  /**
   * �����x�����擾���܂��B
   * @return �����x��
   */
  public ACLabel getSpecificFacilityDiscountPercentSign(){
    if(specificFacilityDiscountPercentSign==null){

      specificFacilityDiscountPercentSign = new ACLabel();

      specificFacilityDiscountPercentSign.setText("��");

      addSpecificFacilityDiscountPercentSign();
    }
    return specificFacilityDiscountPercentSign;

  }

  /**
   * �@�\�P���w���̐����W�I�O���[�v���擾���܂��B
   * @return �@�\�P���w���̐����W�I�O���[�v
   */
  public ACClearableRadioButtonGroup getFunctionTrainingGuidanceSystem(){
    if(functionTrainingGuidanceSystem==null){

      functionTrainingGuidanceSystem = new ACClearableRadioButtonGroup();

      getFunctionTrainingGuidanceSystemContainer().setText("�@�\�P���w���̐�");

      functionTrainingGuidanceSystem.setBindPath("1330101");

      functionTrainingGuidanceSystem.setModel(getFunctionTrainingGuidanceSystemModel());

      functionTrainingGuidanceSystem.setUseClearButton(false);

      addFunctionTrainingGuidanceSystem();
    }
    return functionTrainingGuidanceSystem;

  }

  /**
   * �@�\�P���w���̐����W�I�O���[�v�R���e�i���擾���܂��B
   * @return �@�\�P���w���̐����W�I�O���[�v�R���e�i
   */
  protected ACLabelContainer getFunctionTrainingGuidanceSystemContainer(){
    if(functionTrainingGuidanceSystemContainer==null){
      functionTrainingGuidanceSystemContainer = new ACLabelContainer();
      functionTrainingGuidanceSystemContainer.setFollowChildEnabled(true);
      functionTrainingGuidanceSystemContainer.add(getFunctionTrainingGuidanceSystem(), null);
    }
    return functionTrainingGuidanceSystemContainer;
  }

  /**
   * �@�\�P���w���̐����W�I�O���[�v���f�����擾���܂��B
   * @return �@�\�P���w���̐����W�I�O���[�v���f��
   */
  protected ACListModelAdapter getFunctionTrainingGuidanceSystemModel(){
    if(functionTrainingGuidanceSystemModel==null){
      functionTrainingGuidanceSystemModel = new ACListModelAdapter();
      addFunctionTrainingGuidanceSystemModel();
    }
    return functionTrainingGuidanceSystemModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getFunctionTrainingGuidanceSystemOff(){
    if(functionTrainingGuidanceSystemOff==null){

      functionTrainingGuidanceSystemOff = new ACRadioButtonItem();

      functionTrainingGuidanceSystemOff.setText("�Ȃ�");

      functionTrainingGuidanceSystemOff.setGroup(getFunctionTrainingGuidanceSystem());

      addFunctionTrainingGuidanceSystemOff();
    }
    return functionTrainingGuidanceSystemOff;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getFunctionTrainingGuidanceSystemOn(){
    if(functionTrainingGuidanceSystemOn==null){

      functionTrainingGuidanceSystemOn = new ACRadioButtonItem();

      functionTrainingGuidanceSystemOn.setText("����");

      functionTrainingGuidanceSystemOn.setGroup(getFunctionTrainingGuidanceSystem());

      addFunctionTrainingGuidanceSystemOn();
    }
    return functionTrainingGuidanceSystemOn;

  }

  /**
   * �l�����Z���W�I�O���[�v���擾���܂��B
   * @return �l�����Z���W�I�O���[�v
   */
  public ACClearableRadioButtonGroup getStaffLack(){
    if(staffLack==null){

      staffLack = new ACClearableRadioButtonGroup();

      getStaffLackContainer().setText("�l�����Z");

      staffLack.setBindPath("1330102");

      staffLack.setModel(getStaffLackModel());

      staffLack.setUseClearButton(false);

      addStaffLack();
    }
    return staffLack;

  }

  /**
   * �l�����Z���W�I�O���[�v�R���e�i���擾���܂��B
   * @return �l�����Z���W�I�O���[�v�R���e�i
   */
  protected ACLabelContainer getStaffLackContainer(){
    if(staffLackContainer==null){
      staffLackContainer = new ACLabelContainer();
      staffLackContainer.setFollowChildEnabled(true);
      staffLackContainer.add(getStaffLack(), null);
    }
    return staffLackContainer;
  }

  /**
   * �l�����Z���W�I�O���[�v���f�����擾���܂��B
   * @return �l�����Z���W�I�O���[�v���f��
   */
  protected ACListModelAdapter getStaffLackModel(){
    if(staffLackModel==null){
      staffLackModel = new ACListModelAdapter();
      addStaffLackModel();
    }
    return staffLackModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getStaffLackOff(){
    if(staffLackOff==null){

      staffLackOff = new ACRadioButtonItem();

      staffLackOff.setText("�Ȃ�");

      staffLackOff.setGroup(getStaffLack());

      addStaffLackOff();
    }
    return staffLackOff;

  }

  /**
   * �Ō�E���E���̕s�����擾���܂��B
   * @return �Ō�E���E���̕s��
   */
  public ACRadioButtonItem getStaffLackKango(){
    if(staffLackKango==null){

      staffLackKango = new ACRadioButtonItem();

      staffLackKango.setText("�Ō�E���E���̕s��");

      staffLackKango.setGroup(getStaffLack());

      addStaffLackKango();
    }
    return staffLackKango;

  }

  /**
   * �R���X�g���N�^�ł��B
   */
  public QO004015Design() {

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

    this.add(getSpecificFacilityGroup(), VRLayout.CLIENT);

  }

  /**
   * ���ƃO���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addSpecificFacilityGroup(){

    specificFacilityGroup.add(getSpecificFacilityDiscountContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    specificFacilityGroup.add(getFunctionTrainingGuidanceSystemContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    specificFacilityGroup.add(getStaffLackContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * �������R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addSpecificFacilityDiscountContainer(){

    specificFacilityDiscountContainer.add(getSpecificFacilityDiscountRate(), VRLayout.FLOW);

    specificFacilityDiscountContainer.add(getSpecificFacilityDiscountPercentSign(), VRLayout.FLOW);

  }

  /**
   * �������ɓ������ڂ�ǉ����܂��B
   */
  protected void addSpecificFacilityDiscountRate(){

  }

  /**
   * �����x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addSpecificFacilityDiscountPercentSign(){

  }

  /**
   * �@�\�P���w���̐����W�I�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addFunctionTrainingGuidanceSystem(){

  }

  /**
   * �@�\�P���w���̐����W�I�O���[�v���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addFunctionTrainingGuidanceSystemModel(){

    getFunctionTrainingGuidanceSystemOff().setButtonIndex(1);
    getFunctionTrainingGuidanceSystemModel().add(getFunctionTrainingGuidanceSystemOff());

    getFunctionTrainingGuidanceSystemOn().setButtonIndex(2);
    getFunctionTrainingGuidanceSystemModel().add(getFunctionTrainingGuidanceSystemOn());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addFunctionTrainingGuidanceSystemOff(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addFunctionTrainingGuidanceSystemOn(){

  }

  /**
   * �l�����Z���W�I�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffLack(){

  }

  /**
   * �l�����Z���W�I�O���[�v���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffLackModel(){

    getStaffLackOff().setButtonIndex(1);
    getStaffLackModel().add(getStaffLackOff());

    getStaffLackKango().setButtonIndex(2);
    getStaffLackModel().add(getStaffLackKango());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffLackOff(){

  }

  /**
   * �Ō�E���E���̕s���ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffLackKango(){

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
      ACFrame.getInstance().getContentPane().add(new QO004015Design());
      ACFrame.getInstance().setVisible(true);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QO004015Design getThis() {
    return this;
  }
}
