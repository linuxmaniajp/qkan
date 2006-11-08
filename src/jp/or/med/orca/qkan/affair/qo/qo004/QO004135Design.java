
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
 * �J����: ��i�@�a�P
 * �쐬��: 2006/05/02  ���{�R���s���[�^�[������� ��i�@�a�P �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���̑��@�\ (O)
 * �v���Z�X ���Ǝғo�^ (004)
 * �v���O���� ���\�h�ʏ���� (QO004135)
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
import jp.or.med.orca.qkan.affair.qs.qs001.QS001ServicePanel;
import jp.or.med.orca.qkan.component.*;
import jp.or.med.orca.qkan.text.*;
/**
 * ���\�h�ʏ�����ʍ��ڃf�U�C��(QO004135) 
 */
public class QO004135Design  extends QS001ServicePanel {
  //GUI�R���|�[�l���g

  private ACGroupBox mainGroup;

  private ACClearableRadioButtonGroup staffLack;

  private ACLabelContainer staffLackContainer;

  private ACListModelAdapter staffLackModel;

  private ACRadioButtonItem staffLackItem1;

  private ACRadioButtonItem staffLackItem2;

  private ACRadioButtonItem staffLackItem3;

  private ACClearableRadioButtonGroup functionImprovement;

  private ACLabelContainer functionImprovementContainer;

  private ACListModelAdapter functionImprovementModel;

  private ACRadioButtonItem functionImprovementItem1;

  private ACRadioButtonItem functionImprovementItem2;

  private ACClearableRadioButtonGroup nourishmentImprovement;

  private ACLabelContainer nourishmentImprovementContainer;

  private ACListModelAdapter nourishmentImprovementModel;

  private ACRadioButtonItem nourishmentImprovementItem1;

  private ACRadioButtonItem nourishmentImprovementItem2;

  private ACClearableRadioButtonGroup mouthImprovementAdd;

  private ACLabelContainer mouthImprovementAddContainer;

  private ACListModelAdapter mouthImprovementAddModel;

  private ACRadioButtonItem mouthImprovementAddItem1;

  private ACRadioButtonItem mouthImprovementAddItem2;

  private ACClearableRadioButtonGroup providerEvaluation;

  private ACLabelContainer providerEvaluationContainer;

  private ACListModelAdapter providerEvaluationModel;

  private ACRadioButtonItem providerEvaluationItem1;

  private ACRadioButtonItem providerEvaluationItem2;

  private ACLabelContainer reduceRateContainer;

  private ACTextField reduceRate;

  private ACLabel percentSign;

  private ACIntegerCheckBox ShahukuReduce;

  //getter

  /**
   * ���ƃO���[�v���擾���܂��B
   * @return ���ƃO���[�v
   */
  public ACGroupBox getMainGroup(){
    if(mainGroup==null){

      mainGroup = new ACGroupBox();

      mainGroup.setText("���\�h�ʏ����");

      mainGroup.setFollowChildEnabled(true);

      mainGroup.setHgrid(200);

      addMainGroup();
    }
    return mainGroup;

  }

  /**
   * �E���̌����ɂ�錸�Z�̏󋵃��W�I�O���[�v���擾���܂��B
   * @return �E���̌����ɂ�錸�Z�̏󋵃��W�I�O���[�v
   */
  public ACClearableRadioButtonGroup getStaffLack(){
    if(staffLack==null){

      staffLack = new ACClearableRadioButtonGroup();

      getStaffLackContainer().setText("�E���̌����ɂ�錸�Z�̏�");

      staffLack.setBindPath("1650101");

      staffLack.setUseClearButton(false);

      staffLack.setModel(getStaffLackModel());

      addStaffLack();
    }
    return staffLack;

  }

  /**
   * �E���̌����ɂ�錸�Z�̏󋵃��W�I�O���[�v�R���e�i���擾���܂��B
   * @return �E���̌����ɂ�錸�Z�̏󋵃��W�I�O���[�v�R���e�i
   */
  protected ACLabelContainer getStaffLackContainer(){
    if(staffLackContainer==null){
      staffLackContainer = new ACLabelContainer();
      staffLackContainer.setFollowChildEnabled(true);
      staffLackContainer.setVAlignment(VRLayout.CENTER);
      staffLackContainer.add(getStaffLack(), null);
    }
    return staffLackContainer;
  }

  /**
   * �E���̌����ɂ�錸�Z�̏󋵃��W�I�O���[�v���f�����擾���܂��B
   * @return �E���̌����ɂ�錸�Z�̏󋵃��W�I�O���[�v���f��
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
  public ACRadioButtonItem getStaffLackItem1(){
    if(staffLackItem1==null){

      staffLackItem1 = new ACRadioButtonItem();

      staffLackItem1.setText("�Ȃ�");

      staffLackItem1.setGroup(getStaffLack());

      staffLackItem1.setConstraints(VRLayout.FLOW);

      addStaffLackItem1();
    }
    return staffLackItem1;

  }

  /**
   * �Ō�E�����擾���܂��B
   * @return �Ō�E��
   */
  public ACRadioButtonItem getStaffLackItem2(){
    if(staffLackItem2==null){

      staffLackItem2 = new ACRadioButtonItem();

      staffLackItem2.setText("�Ō�E��");

      staffLackItem2.setGroup(getStaffLack());

      staffLackItem2.setConstraints(VRLayout.FLOW);

      addStaffLackItem2();
    }
    return staffLackItem2;

  }

  /**
   * ���E�����擾���܂��B
   * @return ���E��
   */
  public ACRadioButtonItem getStaffLackItem3(){
    if(staffLackItem3==null){

      staffLackItem3 = new ACRadioButtonItem();

      staffLackItem3.setText("���E��");

      staffLackItem3.setGroup(getStaffLack());

      staffLackItem3.setConstraints(VRLayout.FLOW);

      addStaffLackItem3();
    }
    return staffLackItem3;

  }

  /**
   * �^����@�\����̐����W�I�O���[�v���擾���܂��B
   * @return �^����@�\����̐����W�I�O���[�v
   */
  public ACClearableRadioButtonGroup getFunctionImprovement(){
    if(functionImprovement==null){

      functionImprovement = new ACClearableRadioButtonGroup();

      getFunctionImprovementContainer().setText("�^����@�\����̐�");

      functionImprovement.setBindPath("1650102");

      functionImprovement.setUseClearButton(false);

      functionImprovement.setModel(getFunctionImprovementModel());

      addFunctionImprovement();
    }
    return functionImprovement;

  }

  /**
   * �^����@�\����̐����W�I�O���[�v�R���e�i���擾���܂��B
   * @return �^����@�\����̐����W�I�O���[�v�R���e�i
   */
  protected ACLabelContainer getFunctionImprovementContainer(){
    if(functionImprovementContainer==null){
      functionImprovementContainer = new ACLabelContainer();
      functionImprovementContainer.setFollowChildEnabled(true);
      functionImprovementContainer.setVAlignment(VRLayout.CENTER);
      functionImprovementContainer.add(getFunctionImprovement(), null);
    }
    return functionImprovementContainer;
  }

  /**
   * �^����@�\����̐����W�I�O���[�v���f�����擾���܂��B
   * @return �^����@�\����̐����W�I�O���[�v���f��
   */
  protected ACListModelAdapter getFunctionImprovementModel(){
    if(functionImprovementModel==null){
      functionImprovementModel = new ACListModelAdapter();
      addFunctionImprovementModel();
    }
    return functionImprovementModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getFunctionImprovementItem1(){
    if(functionImprovementItem1==null){

      functionImprovementItem1 = new ACRadioButtonItem();

      functionImprovementItem1.setText("�Ȃ�");

      functionImprovementItem1.setGroup(getFunctionImprovement());

      functionImprovementItem1.setConstraints(VRLayout.FLOW);

      addFunctionImprovementItem1();
    }
    return functionImprovementItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getFunctionImprovementItem2(){
    if(functionImprovementItem2==null){

      functionImprovementItem2 = new ACRadioButtonItem();

      functionImprovementItem2.setText("����");

      functionImprovementItem2.setGroup(getFunctionImprovement());

      functionImprovementItem2.setConstraints(VRLayout.FLOW);

      addFunctionImprovementItem2();
    }
    return functionImprovementItem2;

  }

  /**
   * �h�{���P�̐����W�I�O���[�v���擾���܂��B
   * @return �h�{���P�̐����W�I�O���[�v
   */
  public ACClearableRadioButtonGroup getNourishmentImprovement(){
    if(nourishmentImprovement==null){

      nourishmentImprovement = new ACClearableRadioButtonGroup();

      getNourishmentImprovementContainer().setText("�h�{���P�̐�");

      nourishmentImprovement.setBindPath("1650103");

      nourishmentImprovement.setUseClearButton(false);

      nourishmentImprovement.setModel(getNourishmentImprovementModel());

      addNourishmentImprovement();
    }
    return nourishmentImprovement;

  }

  /**
   * �h�{���P�̐����W�I�O���[�v�R���e�i���擾���܂��B
   * @return �h�{���P�̐����W�I�O���[�v�R���e�i
   */
  protected ACLabelContainer getNourishmentImprovementContainer(){
    if(nourishmentImprovementContainer==null){
      nourishmentImprovementContainer = new ACLabelContainer();
      nourishmentImprovementContainer.setFollowChildEnabled(true);
      nourishmentImprovementContainer.setVAlignment(VRLayout.CENTER);
      nourishmentImprovementContainer.add(getNourishmentImprovement(), null);
    }
    return nourishmentImprovementContainer;
  }

  /**
   * �h�{���P�̐����W�I�O���[�v���f�����擾���܂��B
   * @return �h�{���P�̐����W�I�O���[�v���f��
   */
  protected ACListModelAdapter getNourishmentImprovementModel(){
    if(nourishmentImprovementModel==null){
      nourishmentImprovementModel = new ACListModelAdapter();
      addNourishmentImprovementModel();
    }
    return nourishmentImprovementModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getNourishmentImprovementItem1(){
    if(nourishmentImprovementItem1==null){

      nourishmentImprovementItem1 = new ACRadioButtonItem();

      nourishmentImprovementItem1.setText("�Ȃ�");

      nourishmentImprovementItem1.setGroup(getNourishmentImprovement());

      nourishmentImprovementItem1.setConstraints(VRLayout.FLOW);

      addNourishmentImprovementItem1();
    }
    return nourishmentImprovementItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getNourishmentImprovementItem2(){
    if(nourishmentImprovementItem2==null){

      nourishmentImprovementItem2 = new ACRadioButtonItem();

      nourishmentImprovementItem2.setText("����");

      nourishmentImprovementItem2.setGroup(getNourishmentImprovement());

      nourishmentImprovementItem2.setConstraints(VRLayout.FLOW);

      addNourishmentImprovementItem2();
    }
    return nourishmentImprovementItem2;

  }

  /**
   * ���o�@�\����̐����W�I�O���[�v���擾���܂��B
   * @return ���o�@�\����̐����W�I�O���[�v
   */
  public ACClearableRadioButtonGroup getMouthImprovementAdd(){
    if(mouthImprovementAdd==null){

      mouthImprovementAdd = new ACClearableRadioButtonGroup();

      getMouthImprovementAddContainer().setText("���o�@�\����̐�");

      mouthImprovementAdd.setBindPath("1650104");

      mouthImprovementAdd.setUseClearButton(false);

      mouthImprovementAdd.setModel(getMouthImprovementAddModel());

      addMouthImprovementAdd();
    }
    return mouthImprovementAdd;

  }

  /**
   * ���o�@�\����̐����W�I�O���[�v�R���e�i���擾���܂��B
   * @return ���o�@�\����̐����W�I�O���[�v�R���e�i
   */
  protected ACLabelContainer getMouthImprovementAddContainer(){
    if(mouthImprovementAddContainer==null){
      mouthImprovementAddContainer = new ACLabelContainer();
      mouthImprovementAddContainer.setFollowChildEnabled(true);
      mouthImprovementAddContainer.setVAlignment(VRLayout.CENTER);
      mouthImprovementAddContainer.add(getMouthImprovementAdd(), null);
    }
    return mouthImprovementAddContainer;
  }

  /**
   * ���o�@�\����̐����W�I�O���[�v���f�����擾���܂��B
   * @return ���o�@�\����̐����W�I�O���[�v���f��
   */
  protected ACListModelAdapter getMouthImprovementAddModel(){
    if(mouthImprovementAddModel==null){
      mouthImprovementAddModel = new ACListModelAdapter();
      addMouthImprovementAddModel();
    }
    return mouthImprovementAddModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getMouthImprovementAddItem1(){
    if(mouthImprovementAddItem1==null){

      mouthImprovementAddItem1 = new ACRadioButtonItem();

      mouthImprovementAddItem1.setText("�Ȃ�");

      mouthImprovementAddItem1.setGroup(getMouthImprovementAdd());

      mouthImprovementAddItem1.setConstraints(VRLayout.FLOW);

      addMouthImprovementAddItem1();
    }
    return mouthImprovementAddItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getMouthImprovementAddItem2(){
    if(mouthImprovementAddItem2==null){

      mouthImprovementAddItem2 = new ACRadioButtonItem();

      mouthImprovementAddItem2.setText("����");

      mouthImprovementAddItem2.setGroup(getMouthImprovementAdd());

      mouthImprovementAddItem2.setConstraints(VRLayout.FLOW);

      addMouthImprovementAddItem2();
    }
    return mouthImprovementAddItem2;

  }

  /**
   * ���Ə��]�����Z�i�\�o�j�̗L�����W�I�O���[�v���擾���܂��B
   * @return ���Ə��]�����Z�i�\�o�j�̗L�����W�I�O���[�v
   */
  public ACClearableRadioButtonGroup getProviderEvaluation(){
    if(providerEvaluation==null){

      providerEvaluation = new ACClearableRadioButtonGroup();

      getProviderEvaluationContainer().setText("���Ə��]�����Z�i�\�o�j�̗L��");

      providerEvaluation.setBindPath("1650105");

      providerEvaluation.setUseClearButton(false);

      providerEvaluation.setModel(getProviderEvaluationModel());

      addProviderEvaluation();
    }
    return providerEvaluation;

  }

  /**
   * ���Ə��]�����Z�i�\�o�j�̗L�����W�I�O���[�v�R���e�i���擾���܂��B
   * @return ���Ə��]�����Z�i�\�o�j�̗L�����W�I�O���[�v�R���e�i
   */
  protected ACLabelContainer getProviderEvaluationContainer(){
    if(providerEvaluationContainer==null){
      providerEvaluationContainer = new ACLabelContainer();
      providerEvaluationContainer.setFollowChildEnabled(true);
      providerEvaluationContainer.setVAlignment(VRLayout.CENTER);
      providerEvaluationContainer.add(getProviderEvaluation(), null);
    }
    return providerEvaluationContainer;
  }

  /**
   * ���Ə��]�����Z�i�\�o�j�̗L�����W�I�O���[�v���f�����擾���܂��B
   * @return ���Ə��]�����Z�i�\�o�j�̗L�����W�I�O���[�v���f��
   */
  protected ACListModelAdapter getProviderEvaluationModel(){
    if(providerEvaluationModel==null){
      providerEvaluationModel = new ACListModelAdapter();
      addProviderEvaluationModel();
    }
    return providerEvaluationModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getProviderEvaluationItem1(){
    if(providerEvaluationItem1==null){

      providerEvaluationItem1 = new ACRadioButtonItem();

      providerEvaluationItem1.setText("�Ȃ�");

      providerEvaluationItem1.setGroup(getProviderEvaluation());

      providerEvaluationItem1.setConstraints(VRLayout.FLOW);

      addProviderEvaluationItem1();
    }
    return providerEvaluationItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getProviderEvaluationItem2(){
    if(providerEvaluationItem2==null){

      providerEvaluationItem2 = new ACRadioButtonItem();

      providerEvaluationItem2.setText("����");

      providerEvaluationItem2.setGroup(getProviderEvaluation());

      providerEvaluationItem2.setConstraints(VRLayout.FLOW);

      addProviderEvaluationItem2();
    }
    return providerEvaluationItem2;

  }

  /**
   * �������R���e�i���擾���܂��B
   * @return �������R���e�i
   */
  public ACLabelContainer getReduceRateContainer(){
    if(reduceRateContainer==null){

      reduceRateContainer = new ACLabelContainer();

      reduceRateContainer.setText("������");

      reduceRateContainer.setFollowChildEnabled(true);

      addReduceRateContainer();
    }
    return reduceRateContainer;

  }

  /**
   * ���������擾���܂��B
   * @return ������
   */
  public ACTextField getReduceRate(){
    if(reduceRate==null){

      reduceRate = new ACTextField();

      reduceRate.setBindPath("REDUCT_RATE");

      reduceRate.setColumns(3);

      reduceRate.setCharType(VRCharType.ONLY_DIGIT);

      reduceRate.setHorizontalAlignment(SwingConstants.RIGHT);

      reduceRate.setIMEMode(InputSubset.LATIN);

      reduceRate.setMaxLength(3);

      addReduceRate();
    }
    return reduceRate;

  }

  /**
   * �����x�����擾���܂��B
   * @return �����x��
   */
  public ACLabel getPercentSign(){
    if(percentSign==null){

      percentSign = new ACLabel();

      percentSign.setText("��");

      addPercentSign();
    }
    return percentSign;

  }

  /**
   * �Е����ƑΏێ��Ǝ҂��擾���܂��B
   * @return �Е����ƑΏێ��Ǝ�
   */
  public ACIntegerCheckBox getShahukuReduce(){
    if(ShahukuReduce==null){

      ShahukuReduce = new ACIntegerCheckBox();

      ShahukuReduce.setText("�Љ���@�l���̌y�����x");

      ShahukuReduce.setBindPath("1");

      ShahukuReduce.setSelectValue(2);

      ShahukuReduce.setUnSelectValue(1);

      addShahukuReduce();
    }
    return ShahukuReduce;

  }

  /**
   * �R���X�g���N�^�ł��B
   */
  public QO004135Design() {

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
   * ���ƃO���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMainGroup(){

    mainGroup.add(getStaffLackContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    mainGroup.add(getFunctionImprovementContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    mainGroup.add(getNourishmentImprovementContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    mainGroup.add(getMouthImprovementAddContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    mainGroup.add(getProviderEvaluationContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    mainGroup.add(getReduceRateContainer(), VRLayout.FLOW_INSETLINE);

    mainGroup.add(getShahukuReduce(), VRLayout.FLOW_RETURN);

  }

  /**
   * �E���̌����ɂ�錸�Z�̏󋵃��W�I�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffLack(){

  }

  /**
   * �E���̌����ɂ�錸�Z�̏󋵃��W�I�O���[�v���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffLackModel(){

    getStaffLackItem1().setButtonIndex(1);
    getStaffLackModel().add(getStaffLackItem1());

    getStaffLackItem2().setButtonIndex(2);
    getStaffLackModel().add(getStaffLackItem2());

    getStaffLackItem3().setButtonIndex(3);
    getStaffLackModel().add(getStaffLackItem3());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffLackItem1(){

  }

  /**
   * �Ō�E���ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffLackItem2(){

  }

  /**
   * ���E���ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffLackItem3(){

  }

  /**
   * �^����@�\����̐����W�I�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addFunctionImprovement(){

  }

  /**
   * �^����@�\����̐����W�I�O���[�v���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addFunctionImprovementModel(){

    getFunctionImprovementItem1().setButtonIndex(1);
    getFunctionImprovementModel().add(getFunctionImprovementItem1());

    getFunctionImprovementItem2().setButtonIndex(2);
    getFunctionImprovementModel().add(getFunctionImprovementItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addFunctionImprovementItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addFunctionImprovementItem2(){

  }

  /**
   * �h�{���P�̐����W�I�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addNourishmentImprovement(){

  }

  /**
   * �h�{���P�̐����W�I�O���[�v���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addNourishmentImprovementModel(){

    getNourishmentImprovementItem1().setButtonIndex(1);
    getNourishmentImprovementModel().add(getNourishmentImprovementItem1());

    getNourishmentImprovementItem2().setButtonIndex(2);
    getNourishmentImprovementModel().add(getNourishmentImprovementItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addNourishmentImprovementItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addNourishmentImprovementItem2(){

  }

  /**
   * ���o�@�\����̐����W�I�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMouthImprovementAdd(){

  }

  /**
   * ���o�@�\����̐����W�I�O���[�v���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addMouthImprovementAddModel(){

    getMouthImprovementAddItem1().setButtonIndex(1);
    getMouthImprovementAddModel().add(getMouthImprovementAddItem1());

    getMouthImprovementAddItem2().setButtonIndex(2);
    getMouthImprovementAddModel().add(getMouthImprovementAddItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addMouthImprovementAddItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addMouthImprovementAddItem2(){

  }

  /**
   * ���Ə��]�����Z�i�\�o�j�̗L�����W�I�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderEvaluation(){

  }

  /**
   * ���Ə��]�����Z�i�\�o�j�̗L�����W�I�O���[�v���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderEvaluationModel(){

    getProviderEvaluationItem1().setButtonIndex(1);
    getProviderEvaluationModel().add(getProviderEvaluationItem1());

    getProviderEvaluationItem2().setButtonIndex(2);
    getProviderEvaluationModel().add(getProviderEvaluationItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderEvaluationItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderEvaluationItem2(){

  }

  /**
   * �������R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addReduceRateContainer(){

    reduceRateContainer.add(getReduceRate(), VRLayout.FLOW);

    reduceRateContainer.add(getPercentSign(), VRLayout.FLOW);

  }

  /**
   * �������ɓ������ڂ�ǉ����܂��B
   */
  protected void addReduceRate(){

  }

  /**
   * �����x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addPercentSign(){

  }

  /**
   * �Е����ƑΏێ��Ǝ҂ɓ������ڂ�ǉ����܂��B
   */
  protected void addShahukuReduce(){

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
      ACFrame.debugStart(new ACAffairInfo(QO004135Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QO004135Design getThis() {
    return this;
  }
}
