
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
 * �쐬��: 2008/02/27  ���{�R���s���[�^�[������� ����@��F �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �������o�� (P)
 * �v���Z�X ���p�Ҍ������ (007)
 * �v���O���� ���p�Ҍ�����������ݒ� (QP007)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qp.qp007;
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
 * ���p�Ҍ�����������ݒ��ʍ��ڃf�U�C��(QP007) 
 */
public class QP007Design extends QkanAffairDialog {
  //GUI�R���|�[�l���g

  private ACPanel contents;

  private VRLayout patientBillSetupContentsLayout;

  private ACGroupBox patientBillSetupTargetGroup;

  private VRLayout patientBillSetupTargetGroupLayout;

  private ACPanel patientBillSetupUp;

  private ACPanel patientBillSetupLeft;

  private ACVerticalRadioButtonGroup patientBillSetupPapersRadio;

  private ACLabelContainer patientBillSetupPapersRadioContainer;

  private ACListModelAdapter patientBillSetupPapersRadioModel;

  private ACRadioButtonItem patientBillSetupPapersRadioItem1;

  private ACRadioButtonItem patientBillSetupPapersRadioItem2;

  private ACRadioButtonItem patientBillSetupPapersRadioItem3;

  private ACPanel patientBillSetupRight;

  private QkanDateTextField patientBillSetupBillDate;

  private ACLabelContainer patientBillSetupBillDateContainer;

  private QkanDateTextField patientBillSetupReceiptDate;

  private ACLabelContainer patientBillSetupReceiptDateContainer;

  private ACIntegerCheckBox patientBillSetupBillAndReceiptDate;

  private ACPanel patientBillSetupUnder;

  private ACIntegerCheckBox patientBillSetupUnderPrintOn;

  private ACIntegerCheckBox patientBillSetupMedicalTreatmentOn;

  private ACIntegerCheckBox patientBillSetupDetailsPrintOn;

  private ACPanel buttons;

  private ACPanel buttonsPanelLeft;

  private ACLabel spacer1;

  private ACButton print;

  private ACPanel buttonsPanelRight;

  private ACLabel spacer2;

  private ACButton close;

  //getter

  /**
   * �N���C�A���g�̈���擾���܂��B
   * @return �N���C�A���g�̈�
   */
  public ACPanel getContents(){
    if(contents==null){

      contents = new ACPanel();

      contents.setLayout(getPatientBillSetupContentsLayout());

      addContents();
    }
    return contents;

  }

  /**
   * �N���C�A���g�̈�E���C�A�E�g���擾���܂��B
   * @return �N���C�A���g�̈�E���C�A�E�g
   */
  public VRLayout getPatientBillSetupContentsLayout(){
    if(patientBillSetupContentsLayout==null){

      patientBillSetupContentsLayout = new VRLayout();

      addPatientBillSetupContentsLayout();
    }
    return patientBillSetupContentsLayout;

  }

  /**
   * ����ΏہE�O���[�v���擾���܂��B
   * @return ����ΏہE�O���[�v
   */
  public ACGroupBox getPatientBillSetupTargetGroup(){
    if(patientBillSetupTargetGroup==null){

      patientBillSetupTargetGroup = new ACGroupBox();

      patientBillSetupTargetGroup.setText("����Ώ�");

      patientBillSetupTargetGroup.setLayout(getPatientBillSetupTargetGroupLayout());

      addPatientBillSetupTargetGroup();
    }
    return patientBillSetupTargetGroup;

  }

  /**
   * ����ΏہE�O���[�v�E���C�A�E�g���擾���܂��B
   * @return ����ΏہE�O���[�v�E���C�A�E�g
   */
  public VRLayout getPatientBillSetupTargetGroupLayout(){
    if(patientBillSetupTargetGroupLayout==null){

      patientBillSetupTargetGroupLayout = new VRLayout();

      patientBillSetupTargetGroupLayout.setAutoWrap(false);

      addPatientBillSetupTargetGroupLayout();
    }
    return patientBillSetupTargetGroupLayout;

  }

  /**
   * ����ݒ�̈�E����擾���܂��B
   * @return ����ݒ�̈�E��
   */
  public ACPanel getPatientBillSetupUp(){
    if(patientBillSetupUp==null){

      patientBillSetupUp = new ACPanel();

      addPatientBillSetupUp();
    }
    return patientBillSetupUp;

  }

  /**
   * ����ݒ�̈�E�����擾���܂��B
   * @return ����ݒ�̈�E��
   */
  public ACPanel getPatientBillSetupLeft(){
    if(patientBillSetupLeft==null){

      patientBillSetupLeft = new ACPanel();

      addPatientBillSetupLeft();
    }
    return patientBillSetupLeft;

  }

  /**
   * ���ގ�ރ��W�I�O���[�v���擾���܂��B
   * @return ���ގ�ރ��W�I�O���[�v
   */
  public ACVerticalRadioButtonGroup getPatientBillSetupPapersRadio(){
    if(patientBillSetupPapersRadio==null){

      patientBillSetupPapersRadio = new ACVerticalRadioButtonGroup();

      patientBillSetupPapersRadio.setBindPath("TARGET_RADIO");

      patientBillSetupPapersRadio.setUseClearButton(false);

      patientBillSetupPapersRadio.setModel(getPatientBillSetupPapersRadioModel());

      addPatientBillSetupPapersRadio();
    }
    return patientBillSetupPapersRadio;

  }

  /**
   * ���ގ�ރ��W�I�O���[�v�R���e�i���擾���܂��B
   * @return ���ގ�ރ��W�I�O���[�v�R���e�i
   */
  protected ACLabelContainer getPatientBillSetupPapersRadioContainer(){
    if(patientBillSetupPapersRadioContainer==null){
      patientBillSetupPapersRadioContainer = new ACLabelContainer();
      patientBillSetupPapersRadioContainer.setFollowChildEnabled(true);
      patientBillSetupPapersRadioContainer.setVAlignment(VRLayout.CENTER);
      patientBillSetupPapersRadioContainer.add(getPatientBillSetupPapersRadio(), null);
    }
    return patientBillSetupPapersRadioContainer;
  }

  /**
   * ���ގ�ރ��W�I�O���[�v���f�����擾���܂��B
   * @return ���ގ�ރ��W�I�O���[�v���f��
   */
  protected ACListModelAdapter getPatientBillSetupPapersRadioModel(){
    if(patientBillSetupPapersRadioModel==null){
      patientBillSetupPapersRadioModel = new ACListModelAdapter();
      addPatientBillSetupPapersRadioModel();
    }
    return patientBillSetupPapersRadioModel;
  }

  /**
   * ���������擾���܂��B
   * @return ������
   */
  public ACRadioButtonItem getPatientBillSetupPapersRadioItem1(){
    if(patientBillSetupPapersRadioItem1==null){

      patientBillSetupPapersRadioItem1 = new ACRadioButtonItem();

      patientBillSetupPapersRadioItem1.setText("������");

      patientBillSetupPapersRadioItem1.setGroup(getPatientBillSetupPapersRadio());

      addPatientBillSetupPapersRadioItem1();
    }
    return patientBillSetupPapersRadioItem1;

  }

  /**
   * �̎������擾���܂��B
   * @return �̎���
   */
  public ACRadioButtonItem getPatientBillSetupPapersRadioItem2(){
    if(patientBillSetupPapersRadioItem2==null){

      patientBillSetupPapersRadioItem2 = new ACRadioButtonItem();

      patientBillSetupPapersRadioItem2.setText("�̎���");

      patientBillSetupPapersRadioItem2.setGroup(getPatientBillSetupPapersRadio());

      addPatientBillSetupPapersRadioItem2();
    }
    return patientBillSetupPapersRadioItem2;

  }

  /**
   * �������E�̎������擾���܂��B
   * @return �������E�̎���
   */
  public ACRadioButtonItem getPatientBillSetupPapersRadioItem3(){
    if(patientBillSetupPapersRadioItem3==null){

      patientBillSetupPapersRadioItem3 = new ACRadioButtonItem();

      patientBillSetupPapersRadioItem3.setText("�������E�̎���");

      patientBillSetupPapersRadioItem3.setGroup(getPatientBillSetupPapersRadio());

      addPatientBillSetupPapersRadioItem3();
    }
    return patientBillSetupPapersRadioItem3;

  }

  /**
   * ����ݒ�̈�E�E���擾���܂��B
   * @return ����ݒ�̈�E�E
   */
  public ACPanel getPatientBillSetupRight(){
    if(patientBillSetupRight==null){

      patientBillSetupRight = new ACPanel();

      addPatientBillSetupRight();
    }
    return patientBillSetupRight;

  }

  /**
   * ���������t���擾���܂��B
   * @return ���������t
   */
  public QkanDateTextField getPatientBillSetupBillDate(){
    if(patientBillSetupBillDate==null){

      patientBillSetupBillDate = new QkanDateTextField();

      getPatientBillSetupBillDateContainer().setText("���������t");

      patientBillSetupBillDate.setBindPath("TARGET_DATE");

      addPatientBillSetupBillDate();
    }
    return patientBillSetupBillDate;

  }

  /**
   * ���������t�R���e�i���擾���܂��B
   * @return ���������t�R���e�i
   */
  protected ACLabelContainer getPatientBillSetupBillDateContainer(){
    if(patientBillSetupBillDateContainer==null){
      patientBillSetupBillDateContainer = new ACLabelContainer();
      patientBillSetupBillDateContainer.setFollowChildEnabled(true);
      patientBillSetupBillDateContainer.setVAlignment(VRLayout.CENTER);
      patientBillSetupBillDateContainer.add(getPatientBillSetupBillDate(), null);
    }
    return patientBillSetupBillDateContainer;
  }

  /**
   * �̎������t���擾���܂��B
   * @return �̎������t
   */
  public QkanDateTextField getPatientBillSetupReceiptDate(){
    if(patientBillSetupReceiptDate==null){

      patientBillSetupReceiptDate = new QkanDateTextField();

      getPatientBillSetupReceiptDateContainer().setText("�̎������t");

      patientBillSetupReceiptDate.setBindPath("GET_DATE");

      addPatientBillSetupReceiptDate();
    }
    return patientBillSetupReceiptDate;

  }

  /**
   * �̎������t�R���e�i���擾���܂��B
   * @return �̎������t�R���e�i
   */
  protected ACLabelContainer getPatientBillSetupReceiptDateContainer(){
    if(patientBillSetupReceiptDateContainer==null){
      patientBillSetupReceiptDateContainer = new ACLabelContainer();
      patientBillSetupReceiptDateContainer.setFollowChildEnabled(true);
      patientBillSetupReceiptDateContainer.setVAlignment(VRLayout.CENTER);
      patientBillSetupReceiptDateContainer.add(getPatientBillSetupReceiptDate(), null);
    }
    return patientBillSetupReceiptDateContainer;
  }

  /**
   * ���v�E���v�����������擾���܂��B
   * @return ���v�E���v���������
   */
  public ACIntegerCheckBox getPatientBillSetupBillAndReceiptDate(){
    if(patientBillSetupBillAndReceiptDate==null){

      patientBillSetupBillAndReceiptDate = new ACIntegerCheckBox();

      patientBillSetupBillAndReceiptDate.setText("���v�E���v���������");

      patientBillSetupBillAndReceiptDate.setBindPath("TOTAL_CHECK");

      addPatientBillSetupBillAndReceiptDate();
    }
    return patientBillSetupBillAndReceiptDate;

  }

  /**
   * ����ݒ�̈�E�����擾���܂��B
   * @return ����ݒ�̈�E��
   */
  public ACPanel getPatientBillSetupUnder(){
    if(patientBillSetupUnder==null){

      patientBillSetupUnder = new ACPanel();

      addPatientBillSetupUnder();
    }
    return patientBillSetupUnder;

  }

  /**
   * �������ɐU����̘g�����������擾���܂��B
   * @return �������ɐU����̘g���������
   */
  public ACIntegerCheckBox getPatientBillSetupUnderPrintOn(){
    if(patientBillSetupUnderPrintOn==null){

      patientBillSetupUnderPrintOn = new ACIntegerCheckBox();

      patientBillSetupUnderPrintOn.setText("�������ɐU����̘g���������");

      patientBillSetupUnderPrintOn.setBindPath("PRINT_CHECK");

      addPatientBillSetupUnderPrintOn();
    }
    return patientBillSetupUnderPrintOn;

  }

  /**
   * ��Ô�T���Ή��łŏo�͂��擾���܂��B
   * @return ��Ô�T���Ή��łŏo��
   */
  public ACIntegerCheckBox getPatientBillSetupMedicalTreatmentOn(){
    if(patientBillSetupMedicalTreatmentOn==null){

      patientBillSetupMedicalTreatmentOn = new ACIntegerCheckBox();

      patientBillSetupMedicalTreatmentOn.setText("��Ô�T���Ή��łŏo��");

      patientBillSetupMedicalTreatmentOn.setBindPath("STYLE_CHECK");

      addPatientBillSetupMedicalTreatmentOn();
    }
    return patientBillSetupMedicalTreatmentOn;

  }

  /**
   * �ڍהłň��������擾���܂��B
   * @return �ڍהłň������
   */
  public ACIntegerCheckBox getPatientBillSetupDetailsPrintOn(){
    if(patientBillSetupDetailsPrintOn==null){

      patientBillSetupDetailsPrintOn = new ACIntegerCheckBox();

      patientBillSetupDetailsPrintOn.setText("�ڍהłň������");

      patientBillSetupDetailsPrintOn.setBindPath("DETAILS_CHECK");

      addPatientBillSetupDetailsPrintOn();
    }
    return patientBillSetupDetailsPrintOn;

  }

  /**
   * �{�^���̈���擾���܂��B
   * @return �{�^���̈�
   */
  public ACPanel getButtons(){
    if(buttons==null){

      buttons = new ACPanel();

      buttons.setAutoWrap(false);

      addButtons();
    }
    return buttons;

  }

  /**
   * �{�^���z�u�p�l���i���j���擾���܂��B
   * @return �{�^���z�u�p�l���i���j
   */
  public ACPanel getButtonsPanelLeft(){
    if(buttonsPanelLeft==null){

      buttonsPanelLeft = new ACPanel();

      addButtonsPanelLeft();
    }
    return buttonsPanelLeft;

  }

  /**
   * �X�y�[�T�[�P���擾���܂��B
   * @return �X�y�[�T�[�P
   */
  public ACLabel getSpacer1(){
    if(spacer1==null){

      spacer1 = new ACLabel();

      spacer1.setText("�@�@");

      addSpacer1();
    }
    return spacer1;

  }

  /**
   * ������擾���܂��B
   * @return ���
   */
  public ACButton getPrint(){
    if(print==null){

      print = new ACButton();

      print.setText("���");

      addPrint();
    }
    return print;

  }

  /**
   * �{�^���z�u�p�l���i�E�j���擾���܂��B
   * @return �{�^���z�u�p�l���i�E�j
   */
  public ACPanel getButtonsPanelRight(){
    if(buttonsPanelRight==null){

      buttonsPanelRight = new ACPanel();

      addButtonsPanelRight();
    }
    return buttonsPanelRight;

  }

  /**
   * �X�y�[�T�[�Q���擾���܂��B
   * @return �X�y�[�T�[�Q
   */
  public ACLabel getSpacer2(){
    if(spacer2==null){

      spacer2 = new ACLabel();

      spacer2.setText("�@�@");

      addSpacer2();
    }
    return spacer2;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACButton getClose(){
    if(close==null){

      close = new ACButton();

      close.setText("����");

      addClose();
    }
    return close;

  }

  /**
   * �R���X�g���N�^�ł��B
   */
  public QP007Design() {

    super(ACFrame.getInstance(), true);
    this.getContentPane().setLayout(new VRLayout());
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    try {
      initialize();

      setSize(520, 220);

      // �E�B���h�E�𒆉��ɔz�u
      Point pos;
      try{
          pos= ACFrame.getInstance().getLocationOnScreen();
      }catch(Exception ex){
          pos = new Point(0,0);
      }
      Dimension screenSize = ACFrame.getInstance().getSize();
      Dimension frameSize = this.getSize();
      if (frameSize.height > screenSize.height) {
          frameSize.height = screenSize.height;
      }
      if (frameSize.width > screenSize.width) {
          frameSize.width = screenSize.width;
      }
      this.setLocation((int)(pos.getX()+(screenSize.width - frameSize.width) / 2),
              (int)(pos.getY()+(screenSize.height - frameSize.height) / 2));

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

    this.getContentPane().add(getContents(), VRLayout.CLIENT);

  }

  /**
   * �N���C�A���g�̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addContents(){

    contents.add(getPatientBillSetupTargetGroup(), VRLayout.NORTH);

    contents.add(getButtons(), VRLayout.NORTH);

  }

  /**
   * �N���C�A���g�̈�E���C�A�E�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatientBillSetupContentsLayout(){

  }

  /**
   * ����ΏہE�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatientBillSetupTargetGroup(){

    patientBillSetupTargetGroup.add(getPatientBillSetupUp(), VRLayout.NORTH);

    patientBillSetupTargetGroup.add(getPatientBillSetupUnder(), VRLayout.NORTH);

  }

  /**
   * ����ΏہE�O���[�v�E���C�A�E�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatientBillSetupTargetGroupLayout(){

  }

  /**
   * ����ݒ�̈�E��ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatientBillSetupUp(){

    patientBillSetupUp.add(getPatientBillSetupLeft(), VRLayout.WEST);

    patientBillSetupUp.add(getPatientBillSetupRight(), VRLayout.EAST);
  }

  /**
   * ����ݒ�̈�E���ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatientBillSetupLeft(){

    patientBillSetupLeft.add(getPatientBillSetupPapersRadioContainer(), VRLayout.FLOW);

  }

  /**
   * ���ގ�ރ��W�I�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatientBillSetupPapersRadio(){

  }

  /**
   * ���ގ�ރ��W�I�O���[�v���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatientBillSetupPapersRadioModel(){

    getPatientBillSetupPapersRadioItem1().setButtonIndex(1);

    getPatientBillSetupPapersRadioModel().add(getPatientBillSetupPapersRadioItem1());

    getPatientBillSetupPapersRadioItem2().setButtonIndex(2);

    getPatientBillSetupPapersRadioModel().add(getPatientBillSetupPapersRadioItem2());

    getPatientBillSetupPapersRadioItem3().setButtonIndex(3);

    getPatientBillSetupPapersRadioModel().add(getPatientBillSetupPapersRadioItem3());

  }

  /**
   * �������ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatientBillSetupPapersRadioItem1(){

  }

  /**
   * �̎����ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatientBillSetupPapersRadioItem2(){

  }

  /**
   * �������E�̎����ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatientBillSetupPapersRadioItem3(){

  }

  /**
   * ����ݒ�̈�E�E�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatientBillSetupRight(){

    patientBillSetupRight.add(getPatientBillSetupBillDateContainer(), VRLayout.FLOW_RETURN);

    patientBillSetupRight.add(getPatientBillSetupReceiptDateContainer(), VRLayout.FLOW_RETURN);

    patientBillSetupRight.add(getPatientBillSetupBillAndReceiptDate(), VRLayout.FLOW);

  }

  /**
   * ���������t�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatientBillSetupBillDate(){

  }

  /**
   * �̎������t�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatientBillSetupReceiptDate(){

  }

  /**
   * ���v�E���v���������ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatientBillSetupBillAndReceiptDate(){

  }

  /**
   * ����ݒ�̈�E���ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatientBillSetupUnder(){

    patientBillSetupUnder.add(getPatientBillSetupUnderPrintOn(), VRLayout.FLOW);

    patientBillSetupUnder.add(getPatientBillSetupMedicalTreatmentOn(), VRLayout.FLOW_RETURN);

    patientBillSetupUnder.add(getPatientBillSetupDetailsPrintOn(), VRLayout.FLOW);

  }

  /**
   * �������ɐU����̘g���������ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatientBillSetupUnderPrintOn(){

  }

  /**
   * ��Ô�T���Ή��łŏo�͂ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatientBillSetupMedicalTreatmentOn(){

  }

  /**
   * �ڍהłň������ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatientBillSetupDetailsPrintOn(){

  }

  /**
   * �{�^���̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addButtons(){

    buttons.add(getButtonsPanelLeft(), VRLayout.CLIENT);

    buttons.add(getButtonsPanelRight(), VRLayout.CLIENT);

  }

  /**
   * �{�^���z�u�p�l���i���j�ɓ������ڂ�ǉ����܂��B
   */
  protected void addButtonsPanelLeft(){

    buttonsPanelLeft.add(getPrint(), VRLayout.EAST);
    buttonsPanelLeft.add(getSpacer1(), VRLayout.EAST);
  }

  /**
   * �X�y�[�T�[�P�ɓ������ڂ�ǉ����܂��B
   */
  protected void addSpacer1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addPrint(){

  }

  /**
   * �{�^���z�u�p�l���i�E�j�ɓ������ڂ�ǉ����܂��B
   */
  protected void addButtonsPanelRight(){

    buttonsPanelRight.add(getSpacer2(), VRLayout.WEST);

    buttonsPanelRight.add(getClose(), VRLayout.WEST);

  }

  /**
   * �X�y�[�T�[�Q�ɓ������ڂ�ǉ����܂��B
   */
  protected void addSpacer2(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addClose(){

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

  public void setVisible(boolean visible){
    if(visible){
      try{
        initAffair(null);
      }catch(Throwable ex){
        ACCommon.getInstance().showExceptionMessage(ex);
      }
    }
    super.setVisible(visible);
  }
  public static void main(String[] args) {
    //�f�t�H���g�f�o�b�O�N��
    try {
      ACFrame.setVRLookAndFeel();
      ACFrame.getInstance().setFrameEventProcesser(new QkanFrameEventProcesser());
      new QP007Design().setVisible(true);
      System.exit(0);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QP007Design getThis() {
    return this;
  }
}
