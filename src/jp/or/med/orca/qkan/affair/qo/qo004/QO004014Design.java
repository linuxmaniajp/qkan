
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
 * �v���O���� �F�m�ǑΉ��^����������� (QO004014)
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
import jp.or.med.orca.qkan.text.*;
/**
 * �F�m�ǑΉ��^������������ʍ��ڃf�U�C��(QO004014) 
 */
public class QO004014Design extends ACPanel {
  //GUI�R���|�[�l���g

  private ACGroupBox dementiaSymbiosisGroup;

  private ACLabelContainer dementiaSymbiosisDiscountContainer;

  private ACTextField dementiaSymbiosisDiscountRate;

  private ACLabel percentSign;

  private ACClearableRadioButtonGroup nighttimeCare;

  private ACLabelContainer nighttimeCareContainer;

  private ACListModelAdapter nighttimeCareModel;

  private ACRadioButtonItem nighttimeCareOff;

  private ACRadioButtonItem nighttimeCareOn;

  private ACClearableRadioButtonGroup staffLack;

  private ACLabelContainer staffLackContainer;

  private ACListModelAdapter staffLackModel;

  private ACRadioButtonItem staffLackOff;

  private ACRadioButtonItem staffExcess;

  private ACRadioButtonItem kaigoWorkerOff;

  //getter

  /**
   * ���ƃO���[�v���擾���܂��B
   * @return ���ƃO���[�v
   */
  public ACGroupBox getDementiaSymbiosisGroup(){
    if(dementiaSymbiosisGroup==null){

      dementiaSymbiosisGroup = new ACGroupBox();

      dementiaSymbiosisGroup.setText("�F�m�ǑΉ��^�����������");

      dementiaSymbiosisGroup.setFollowChildEnabled(true);

      dementiaSymbiosisGroup.setHgrid(200);

      addDementiaSymbiosisGroup();
    }
    return dementiaSymbiosisGroup;

  }

  /**
   * �������R���e�i���擾���܂��B
   * @return �������R���e�i
   */
  public ACLabelContainer getDementiaSymbiosisDiscountContainer(){
    if(dementiaSymbiosisDiscountContainer==null){

      dementiaSymbiosisDiscountContainer = new ACLabelContainer();

      dementiaSymbiosisDiscountContainer.setText("������");

      dementiaSymbiosisDiscountContainer.setFollowChildEnabled(true);

      addDementiaSymbiosisDiscountContainer();
    }
    return dementiaSymbiosisDiscountContainer;

  }

  /**
   * ���������擾���܂��B
   * @return ������
   */
  public ACTextField getDementiaSymbiosisDiscountRate(){
    if(dementiaSymbiosisDiscountRate==null){

      dementiaSymbiosisDiscountRate = new ACTextField();

      dementiaSymbiosisDiscountRate.setBindPath("REDUCT_RATE");

      dementiaSymbiosisDiscountRate.setColumns(3);

      dementiaSymbiosisDiscountRate.setCharType(VRCharType.ONLY_DIGIT);

      dementiaSymbiosisDiscountRate.setHorizontalAlignment(SwingConstants.RIGHT);

      dementiaSymbiosisDiscountRate.setIMEMode(InputSubset.LATIN);

      dementiaSymbiosisDiscountRate.setMaxLength(3);

      addDementiaSymbiosisDiscountRate();
    }
    return dementiaSymbiosisDiscountRate;

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
   * ��ԃP�A���W�I�O���[�v���擾���܂��B
   * @return ��ԃP�A���W�I�O���[�v
   */
  public ACClearableRadioButtonGroup getNighttimeCare(){
    if(nighttimeCare==null){

      nighttimeCare = new ACClearableRadioButtonGroup();

      getNighttimeCareContainer().setText("��ԃP�A");

      nighttimeCare.setBindPath("1320101");

      nighttimeCare.setModel(getNighttimeCareModel());

      nighttimeCare.setUseClearButton(false);

      addNighttimeCare();
    }
    return nighttimeCare;

  }

  /**
   * ��ԃP�A���W�I�O���[�v�R���e�i���擾���܂��B
   * @return ��ԃP�A���W�I�O���[�v�R���e�i
   */
  protected ACLabelContainer getNighttimeCareContainer(){
    if(nighttimeCareContainer==null){
      nighttimeCareContainer = new ACLabelContainer();
      nighttimeCareContainer.setFollowChildEnabled(true);
      nighttimeCareContainer.add(getNighttimeCare(), null);
    }
    return nighttimeCareContainer;
  }

  /**
   * ��ԃP�A���W�I�O���[�v���f�����擾���܂��B
   * @return ��ԃP�A���W�I�O���[�v���f��
   */
  protected ACListModelAdapter getNighttimeCareModel(){
    if(nighttimeCareModel==null){
      nighttimeCareModel = new ACListModelAdapter();
      addNighttimeCareModel();
    }
    return nighttimeCareModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getNighttimeCareOff(){
    if(nighttimeCareOff==null){

      nighttimeCareOff = new ACRadioButtonItem();

      nighttimeCareOff.setText("�Ȃ�");

      nighttimeCareOff.setGroup(getNighttimeCare());

      addNighttimeCareOff();
    }
    return nighttimeCareOff;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getNighttimeCareOn(){
    if(nighttimeCareOn==null){

      nighttimeCareOn = new ACRadioButtonItem();

      nighttimeCareOn.setText("����");

      nighttimeCareOn.setGroup(getNighttimeCare());

      addNighttimeCareOn();
    }
    return nighttimeCareOn;

  }

  /**
   * �l�����Z���W�I�O���[�v���擾���܂��B
   * @return �l�����Z���W�I�O���[�v
   */
  public ACClearableRadioButtonGroup getStaffLack(){
    if(staffLack==null){

      staffLack = new ACClearableRadioButtonGroup();

      getStaffLackContainer().setText("�l�����Z");

      staffLack.setBindPath("1320102");

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
   * ������߂��擾���܂��B
   * @return �������
   */
  public ACRadioButtonItem getStaffExcess(){
    if(staffExcess==null){

      staffExcess = new ACRadioButtonItem();

      staffExcess.setText("�������");

      staffExcess.setGroup(getStaffLack());

      addStaffExcess();
    }
    return staffExcess;

  }

  /**
   * ���]�ƈ��s�����擾���܂��B
   * @return ���]�ƈ��s��
   */
  public ACRadioButtonItem getKaigoWorkerOff(){
    if(kaigoWorkerOff==null){

      kaigoWorkerOff = new ACRadioButtonItem();

      kaigoWorkerOff.setText("���]�ƈ��̕s��");

      kaigoWorkerOff.setGroup(getStaffLack());

      addKaigoWorkerOff();
    }
    return kaigoWorkerOff;

  }

  /**
   * �R���X�g���N�^�ł��B
   */
  public QO004014Design() {

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

    this.add(getDementiaSymbiosisGroup(), VRLayout.CLIENT);

  }

  /**
   * ���ƃO���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addDementiaSymbiosisGroup(){

    dementiaSymbiosisGroup.add(getDementiaSymbiosisDiscountContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    dementiaSymbiosisGroup.add(getNighttimeCareContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    dementiaSymbiosisGroup.add(getStaffLackContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * �������R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addDementiaSymbiosisDiscountContainer(){

    dementiaSymbiosisDiscountContainer.add(getDementiaSymbiosisDiscountRate(), VRLayout.FLOW);

    dementiaSymbiosisDiscountContainer.add(getPercentSign(), VRLayout.FLOW);

  }

  /**
   * �������ɓ������ڂ�ǉ����܂��B
   */
  protected void addDementiaSymbiosisDiscountRate(){

  }

  /**
   * �����x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addPercentSign(){

  }

  /**
   * ��ԃP�A���W�I�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addNighttimeCare(){

  }

  /**
   * ��ԃP�A���W�I�O���[�v���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addNighttimeCareModel(){

    getNighttimeCareOff().setButtonIndex(1);
    getNighttimeCareModel().add(getNighttimeCareOff());

    getNighttimeCareOn().setButtonIndex(2);
    getNighttimeCareModel().add(getNighttimeCareOn());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addNighttimeCareOff(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addNighttimeCareOn(){

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

    getStaffExcess().setButtonIndex(2);
    getStaffLackModel().add(getStaffExcess());

    getKaigoWorkerOff().setButtonIndex(3);
    getStaffLackModel().add(getKaigoWorkerOff());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffLackOff(){

  }

  /**
   * ������߂ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffExcess(){

  }

  /**
   * ���]�ƈ��s���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWorkerOff(){

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
      ACFrame.getInstance().getContentPane().add(new QO004014Design());
      ACFrame.getInstance().setVisible(true);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QO004014Design getThis() {
    return this;
  }
}
