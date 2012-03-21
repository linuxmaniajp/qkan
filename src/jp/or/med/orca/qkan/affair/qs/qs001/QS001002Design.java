
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
 * �쐬��: 2006/06/05  ���{�R���s���[�^�[������� �� ���� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �\��Ǘ� (S)
 * �v���Z�X �T�[�r�X�\�� (001)
 * �v���O���� �T�ԕ\ (QS001002)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
import java.awt.Color;
import java.awt.Component;

import javax.swing.SwingConstants;

import jp.nichicom.ac.component.ACButton;
import jp.nichicom.ac.component.ACTextField;
import jp.nichicom.ac.container.ACGroupBox;
import jp.nichicom.ac.container.ACLabelContainer;
import jp.nichicom.ac.container.ACPanel;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.vr.layout.VRLayout;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
/**
 * �T�ԕ\��ʍ��ڃf�U�C��(QS001002) 
 */
public class QS001002Design extends ACPanel {
  //GUI�R���|�[�l���g

  private ACPanel contents;

  private ACPanel uppers;

  private ACGroupBox sumups;

  private ACTextField limit;

  private ACLabelContainer limitContainer;

  private ACTextField limitAmount;

  private ACLabelContainer limitAmountContainer;

  private ACTextField over;

  private ACLabelContainer overContainer;

  private ACButton calcurate;

  private ACTextField afterAdjustment;

  private ACLabelContainer afterAdjustmentContainer;

  private ACTextField adjustment;

  private ACLabelContainer adjustmentContainer;

  private ACPanel buttons;

  private ACButton coordinatePrivateExpenses;

  private ACButton detailsbutton;

  private ACPanel addInfomations;

  private ACButton planUnit;

  private ACPanel monthlyCharts;

  private QS001MonthSchedule monthlySchedule;

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
   * �㕔�̈���擾���܂��B
   * @return �㕔�̈�
   */
  public ACPanel getUppers(){
    if(uppers==null){

      uppers = new ACPanel();

      addUppers();
    }
    return uppers;

  }

  /**
   * �W�v���̈���擾���܂��B
   * @return �W�v���̈�
   */
  public ACGroupBox getSumups(){
    if(sumups==null){

      sumups = new ACGroupBox();

      sumups.setText("�W�v���");

      sumups.setAutoWrap(false);

      sumups.setHgap(0);

      sumups.setHgrid(100);

      sumups.setAlignment(SwingConstants.RIGHT);

      addSumups();
    }
    return sumups;

  }

  /**
   * ���x�z���擾���܂��B
   * @return ���x�z
   */
  public ACTextField getLimit(){
    if(limit==null){

      limit = new ACTextField();

      getLimitContainer().setText("���x�z");

      limit.setEditable(false);

      limit.setColumns(6);

      limit.setHorizontalAlignment(SwingConstants.RIGHT);

      addLimit();
    }
    return limit;

  }

  /**
   * ���x�z�R���e�i���擾���܂��B
   * @return ���x�z�R���e�i
   */
  protected ACLabelContainer getLimitContainer(){
    if(limitContainer==null){
      limitContainer = new ACLabelContainer();
      limitContainer.setFollowChildEnabled(true);
      limitContainer.setVAlignment(VRLayout.CENTER);
      limitContainer.add(getLimit(), null);
    }
    return limitContainer;
  }

  /**
   * ���x�z�Ǘ��Ώۓ��P�ʐ����擾���܂��B
   * @return ���x�z�Ǘ��Ώۓ��P�ʐ�
   */
  public ACTextField getLimitAmount(){
    if(limitAmount==null){

      limitAmount = new ACTextField();

      getLimitAmountContainer().setText("�Ǘ��Ώۓ�");

      limitAmount.setEditable(false);

      limitAmount.setColumns(6);

      limitAmount.setHorizontalAlignment(SwingConstants.RIGHT);

      addLimitAmount();
    }
    return limitAmount;

  }

  /**
   * ���x�z�Ǘ��Ώۓ��P�ʐ��R���e�i���擾���܂��B
   * @return ���x�z�Ǘ��Ώۓ��P�ʐ��R���e�i
   */
  protected ACLabelContainer getLimitAmountContainer(){
    if(limitAmountContainer==null){
      limitAmountContainer = new ACLabelContainer();
      limitAmountContainer.setFollowChildEnabled(true);
      limitAmountContainer.setVAlignment(VRLayout.CENTER);
      limitAmountContainer.add(getLimitAmount(), null);
    }
    return limitAmountContainer;
  }

  /**
   * ���ߒP�ʐ����擾���܂��B
   * @return ���ߒP�ʐ�
   */
  public ACTextField getOver(){
    if(over==null){

      over = new ACTextField();

      getOverContainer().setText("���ߕ�");

      over.setEditable(false);

      over.setColumns(6);

      over.setHorizontalAlignment(SwingConstants.RIGHT);

      addOver();
    }
    return over;

  }

  /**
   * ���ߒP�ʐ��R���e�i���擾���܂��B
   * @return ���ߒP�ʐ��R���e�i
   */
  protected ACLabelContainer getOverContainer(){
    if(overContainer==null){
      overContainer = new ACLabelContainer();
      overContainer.setFollowChildEnabled(true);
      overContainer.setVAlignment(VRLayout.CENTER);
      overContainer.add(getOver(), null);
    }
    return overContainer;
  }

  /**
   * �ďW�v���擾���܂��B
   * @return �ďW�v
   */
  public ACButton getCalcurate(){
    if(calcurate==null){

      calcurate = new ACButton();

      calcurate.setText("�ďW�v");

      calcurate.setToolTipText("�T�[�r�X�P�ʐ����ďW�v���܂��B");

      addCalcurate();
    }
    return calcurate;

  }

  /**
   * �����㍇�v�P�ʐ����擾���܂��B
   * @return �����㍇�v�P�ʐ�
   */
  public ACTextField getAfterAdjustment(){
    if(afterAdjustment==null){

      afterAdjustment = new ACTextField();

      getAfterAdjustmentContainer().setText("�����㍇�v");

      afterAdjustment.setEditable(false);

      afterAdjustment.setColumns(6);

      afterAdjustment.setHorizontalAlignment(SwingConstants.RIGHT);

      addAfterAdjustment();
    }
    return afterAdjustment;

  }

  /**
   * �����㍇�v�P�ʐ��R���e�i���擾���܂��B
   * @return �����㍇�v�P�ʐ��R���e�i
   */
  protected ACLabelContainer getAfterAdjustmentContainer(){
    if(afterAdjustmentContainer==null){
      afterAdjustmentContainer = new ACLabelContainer();
      afterAdjustmentContainer.setFollowChildEnabled(true);
      afterAdjustmentContainer.setVAlignment(VRLayout.CENTER);
      afterAdjustmentContainer.add(getAfterAdjustment(), null);
    }
    return afterAdjustmentContainer;
  }

  /**
   * �����P�ʐ����擾���܂��B
   * @return �����P�ʐ�
   */
  public ACTextField getAdjustment(){
    if(adjustment==null){

      adjustment = new ACTextField();

      getAdjustmentContainer().setText("������");

      adjustment.setEditable(false);

      adjustment.setColumns(6);

      adjustment.setHorizontalAlignment(SwingConstants.RIGHT);

      addAdjustment();
    }
    return adjustment;

  }

  /**
   * �����P�ʐ��R���e�i���擾���܂��B
   * @return �����P�ʐ��R���e�i
   */
  protected ACLabelContainer getAdjustmentContainer(){
    if(adjustmentContainer==null){
      adjustmentContainer = new ACLabelContainer();
      adjustmentContainer.setFollowChildEnabled(true);
      adjustmentContainer.setVAlignment(VRLayout.CENTER);
      adjustmentContainer.add(getAdjustment(), null);
    }
    return adjustmentContainer;
  }

  /**
   * �{�^���̈���擾���܂��B
   * @return �{�^���̈�
   */
  public ACPanel getButtons(){
    if(buttons==null){

      buttons = new ACPanel();

      addButtons();
    }
    return buttons;

  }

  /**
   * ���ȕ��S������ʂ��擾���܂��B
   * @return ���ȕ��S�������
   */
  public ACButton getCoordinatePrivateExpenses(){
    if(coordinatePrivateExpenses==null){

      coordinatePrivateExpenses = new ACButton();

      coordinatePrivateExpenses.setText("���ȕ��S����");

      coordinatePrivateExpenses.setEnabled(false);

      coordinatePrivateExpenses.setToolTipText("���p�҂̎��ȕ��S���𒲐����܂��B");

      addCoordinatePrivateExpenses();
    }
    return coordinatePrivateExpenses;

  }

  /**
   * �W�v���׉�ʂ��擾���܂��B
   * @return �W�v���׉��
   */
  public ACButton getDetailsbutton(){
    if(detailsbutton==null){

      detailsbutton = new ACButton();

      detailsbutton.setText("�W�v����");

      detailsbutton.setToolTipText("�T�[�r�X���Ƃ̏W�v����\�����܂��B");

      addDetailsbutton();
    }
    return detailsbutton;

  }

  /**
   * �ǉ����̈���擾���܂��B
   * @return �ǉ����̈�
   */
  public ACPanel getAddInfomations(){
    if(addInfomations==null){

      addInfomations = new ACPanel();

      addAddInfomations();
    }
    return addInfomations;

  }

  /**
   * �v��P�ʐ����擾���܂��B
   * @return �v��P�ʐ�
   */
  public ACButton getPlanUnit(){
    if(planUnit==null){

      planUnit = new ACButton();

      planUnit.setText("�v��P�ʐ�");

      planUnit.setToolTipText("�v��P�ʐ���ҏW���܂��B");

      addPlanUnit();
    }
    return planUnit;

  }

  /**
   * ���ԕ\�̈���擾���܂��B
   * @return ���ԕ\�̈�
   */
  public ACPanel getMonthlyCharts(){
    if(monthlyCharts==null){

      monthlyCharts = new ACPanel();

      monthlyCharts.setBackground(new Color(233,255,240));

      addMonthlyCharts();
    }
    return monthlyCharts;

  }

  /**
   * ���ԕ\���擾���܂��B
   * @return ���ԕ\
   */
  public QS001MonthSchedule getMonthlySchedule(){
    if(monthlySchedule==null){

      monthlySchedule = new QS001MonthSchedule();

      addMonthlySchedule();
    }
    return monthlySchedule;

  }

  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001002Design() {

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

    contents.add(getUppers(), VRLayout.NORTH);

    contents.add(getMonthlyCharts(), VRLayout.CLIENT);

  }

  /**
   * �㕔�̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addUppers(){

    uppers.add(getSumups(), VRLayout.WEST);

    uppers.add(getButtons(), VRLayout.CLIENT);

    uppers.add(getAddInfomations(), VRLayout.SOUTH);
  }

  /**
   * �W�v���̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addSumups(){

    sumups.add(getLimitContainer(), VRLayout.FLOW_INSETLINE);

    sumups.add(getLimitAmountContainer(), VRLayout.FLOW_INSETLINE);

    sumups.add(getOverContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    sumups.add(getCalcurate(), VRLayout.FLOW_INSETLINE);

    sumups.add(getAfterAdjustmentContainer(), VRLayout.FLOW_INSETLINE);

    sumups.add(getAdjustmentContainer(), VRLayout.FLOW_INSETLINE);

  }

  /**
   * ���x�z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addLimit(){

  }

  /**
   * ���x�z�Ǘ��Ώۓ��P�ʐ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addLimitAmount(){

  }

  /**
   * ���ߒP�ʐ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addOver(){

  }

  /**
   * �ďW�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalcurate(){

  }

  /**
   * �����㍇�v�P�ʐ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addAfterAdjustment(){

  }

  /**
   * �����P�ʐ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addAdjustment(){

  }

  /**
   * �{�^���̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addButtons(){

    buttons.add(getCoordinatePrivateExpenses(), VRLayout.FLOW_RETURN);

    buttons.add(getDetailsbutton(), VRLayout.FLOW);

  }

  /**
   * ���ȕ��S������ʂɓ������ڂ�ǉ����܂��B
   */
  protected void addCoordinatePrivateExpenses(){

  }

  /**
   * �W�v���׉�ʂɓ������ڂ�ǉ����܂��B
   */
  protected void addDetailsbutton(){

  }

  /**
   * �ǉ����̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addAddInfomations(){

    addInfomations.add(getPlanUnit(), VRLayout.FLOW);

  }

  /**
   * �v��P�ʐ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addPlanUnit(){

  }

  /**
   * ���ԕ\�̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMonthlyCharts(){

    monthlyCharts.add(getMonthlySchedule(), VRLayout.CLIENT);

  }

  /**
   * ���ԕ\�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMonthlySchedule(){

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
      ACFrame.getInstance().getContentPane().add(new QS001002Design());
      ACFrame.getInstance().setVisible(true);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QS001002Design getThis() {
    return this;
  }
}
