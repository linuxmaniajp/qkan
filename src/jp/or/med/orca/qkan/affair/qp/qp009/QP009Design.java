
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
 * �J����: �����F
 * �쐬��: 2006/03/19  ���{�R���s���[�^�[������� �����F �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���ъm��^�������o�� (P)
 * �v���Z�X CSV�o�� (009)
 * �v���O���� �`���m�F (QP009)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qp.qp009;
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
 * �`���m�F��ʍ��ڃf�U�C��(QP009) 
 */
public class QP009Design extends QkanAffairDialog {
  //GUI�R���|�[�l���g

  private ACPanel contents;

  private ACPanel buttons;

  private ACLabel spacer1;

  private ACLabel infoLabel1;

  private ACLabel infoLabel2;

  private ACLabel spacer2;

  private ACPanel panelNextCheck;

  private ACIntegerCheckBox nextCheck;

  private ACButton ok;

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
   * ���x���\�����擾���܂��B
   * @return ���x���\��
   */
  public ACPanel getButtons(){
    if(buttons==null){

      buttons = new ACPanel();

      addButtons();
    }
    return buttons;

  }

  /**
   * �X�y�[�T�[�P���擾���܂��B
   * @return �X�y�[�T�[�P
   */
  public ACLabel getSpacer1(){
    if(spacer1==null){

      spacer1 = new ACLabel();

      spacer1.setText("�@");

      addSpacer1();
    }
    return spacer1;

  }

  /**
   * �o�͊m�F�P���擾���܂��B
   * @return �o�͊m�F�P
   */
  public ACLabel getInfoLabel1(){
    if(infoLabel1==null){

      infoLabel1 = new ACLabel();

      infoLabel1.setText("�@�@�`���p�̂b�r�u�t�@�C�����o�͂��܂��B");

      addInfoLabel1();
    }
    return infoLabel1;

  }

  /**
   * �o�͊m�F�Q���擾���܂��B
   * @return �o�͊m�F�Q
   */
  public ACLabel getInfoLabel2(){
    if(infoLabel2==null){

      infoLabel2 = new ACLabel();

      infoLabel2.setText("�@�@���̍�Ƃœ`�����s����킯�ł͂���܂���B");

      addInfoLabel2();
    }
    return infoLabel2;

  }

  /**
   * �X�y�[�T�[�Q���擾���܂��B
   * @return �X�y�[�T�[�Q
   */
  public ACLabel getSpacer2(){
    if(spacer2==null){

      spacer2 = new ACLabel();

      spacer2.setText("�@");

      addSpacer2();
    }
    return spacer2;

  }

  /**
   * ����\�����擾���܂��B
   * @return ����\��
   */
  public ACPanel getPanelNextCheck(){
    if(panelNextCheck==null){

      panelNextCheck = new ACPanel();

      addPanelNextCheck();
    }
    return panelNextCheck;

  }

  /**
   * ����\���m�F�`�F�b�N�{�b�N�X���擾���܂��B
   * @return ����\���m�F�`�F�b�N�{�b�N�X
   */
  public ACIntegerCheckBox getNextCheck(){
    if(nextCheck==null){

      nextCheck = new ACIntegerCheckBox();

      nextCheck.setText("����ȍ~�͂��̃��b�Z�[�W��\�����Ȃ��B");

      addNextCheck();
    }
    return nextCheck;

  }

  /**
   * �n�j�{�^�����擾���܂��B
   * @return �n�j�{�^��
   */
  public ACButton getOk(){
    if(ok==null){

      ok = new ACButton();

      ok.setText("�n�j");

      addOk();
    }
    return ok;

  }

  /**
   * �R���X�g���N�^�ł��B
   */
  public QP009Design() {

    super(ACFrame.getInstance(), true);
    this.getContentPane().setLayout(new VRLayout());
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    try {
      initialize();

      setSize(420, 160);

      // �E�B���h�E�𒆉��ɔz�u
      Point pos = ACFrame.getInstance().getLocationOnScreen();
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

    contents.add(getButtons(), VRLayout.NORTH);

    contents.add(getPanelNextCheck(), VRLayout.NORTH);

  }

  /**
   * ���x���\���ɓ������ڂ�ǉ����܂��B
   */
  protected void addButtons(){

    buttons.add(getSpacer1(), VRLayout.NORTH);

    buttons.add(getInfoLabel1(), VRLayout.NORTH);

    buttons.add(getInfoLabel2(), VRLayout.NORTH);

    buttons.add(getSpacer2(), VRLayout.NORTH);

  }

  /**
   * �X�y�[�T�[�P�ɓ������ڂ�ǉ����܂��B
   */
  protected void addSpacer1(){

  }

  /**
   * �o�͊m�F�P�ɓ������ڂ�ǉ����܂��B
   */
  protected void addInfoLabel1(){

  }

  /**
   * �o�͊m�F�Q�ɓ������ڂ�ǉ����܂��B
   */
  protected void addInfoLabel2(){

  }

  /**
   * �X�y�[�T�[�Q�ɓ������ڂ�ǉ����܂��B
   */
  protected void addSpacer2(){

  }

  /**
   * ����\���ɓ������ڂ�ǉ����܂��B
   */
  protected void addPanelNextCheck(){

    panelNextCheck.add(getNextCheck(), VRLayout.FLOW);

    panelNextCheck.add(getOk(), VRLayout.FLOW);

  }

  /**
   * ����\���m�F�`�F�b�N�{�b�N�X�ɓ������ڂ�ǉ����܂��B
   */
  protected void addNextCheck(){

  }

  /**
   * �n�j�{�^���ɓ������ڂ�ǉ����܂��B
   */
  protected void addOk(){

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
      new QP009Design().setVisible(true);
      System.exit(0);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QP009Design getThis() {
    return this;
  }
}
