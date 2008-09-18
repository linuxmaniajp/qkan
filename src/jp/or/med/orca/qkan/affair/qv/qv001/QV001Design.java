
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
 * �쐬��: 2006/03/10  ���{�R���s���[�^�[������� ����@��F �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �o�[�W���� (V)
 * �v���Z�X �o�[�W������� (001)
 * �v���O���� �o�[�W������� (QV001)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qv.qv001;
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
 * �o�[�W��������ʍ��ڃf�U�C��(QV001) 
 */
public class QV001Design extends QkanAffairDialog {
  //GUI�R���|�[�l���g

  private ACPanel contents;

  private ACPanel qkanInfo;

  private ACTextArea qkanInfoText;

  private JTabbedPane tabs;

  private ACPanel versionArea;

  private ACPanel comments;

  private ACLabel warningCommetn;

  private ACPanel buttons;

  private ACButton close;

  private ACLabel spacer;

  //getter

  /**
   * �o�[�W�������̈���擾���܂��B
   * @return �o�[�W�������̈�
   */
  public ACPanel getContents(){
    if(contents==null){

      contents = new ACPanel();

      addContents();
    }
    return contents;

  }

  /**
   * ���ǒ��ڍ׏��̈���擾���܂��B
   * @return ���ǒ��ڍ׏��̈�
   */
  public ACPanel getQkanInfo(){
    if(qkanInfo==null){

      qkanInfo = new ACPanel();

      addQkanInfo();
    }
    return qkanInfo;

  }

  /**
   * ���ǒ��ڍ׃e�L�X�g�G���A���擾���܂��B
   * @return ���ǒ��ڍ׃e�L�X�g�G���A
   */
  public ACTextArea getQkanInfoText(){
    if(qkanInfoText==null){

      qkanInfoText = new ACTextArea();

      qkanInfoText.setText("���t�Ǘ��䒠Ver45" + ACConstants.LINE_SEPARATOR + "�o�[�W���� 4.5" + ACConstants.LINE_SEPARATOR + "�u���t�Ǘ�/����V�����x���\�t�g�v" + ACConstants.LINE_SEPARATOR + "�@���s���F�Вc�@�l���{��t��" + ACConstants.LINE_SEPARATOR + "�@���E�J���F���{��t������􌤋��@�\" + ACConstants.LINE_SEPARATOR + "�@�J�����F���{�R���s���[�^�[�������" + ACConstants.LINE_SEPARATOR + "" + ACConstants.LINE_SEPARATOR + "�@�@Copyright�i�Ёj���{��t�� 2006");

      qkanInfoText.setEditable(false);

      qkanInfoText.setColumns(35);

      qkanInfoText.setRows(9);

      addQkanInfoText();
    }
    return qkanInfoText;

  }

  /**
   * �^�u���擾���܂��B
   * @return �^�u
   */
  public JTabbedPane getTabs(){
    if(tabs==null){

      tabs = new JTabbedPane();

      addTabs();
    }
    return tabs;

  }

  /**
   * �o�[�W�������̈���擾���܂��B
   * @return �o�[�W�������̈�
   */
  public ACPanel getVersionArea(){
    if(versionArea==null){

      versionArea = new ACPanel();

      versionArea.setAutoWrap(false);

      addVersionArea();
    }
    return versionArea;

  }

  /**
   * �R�����g�̈���擾���܂��B
   * @return �R�����g�̈�
   */
  public ACPanel getComments(){
    if(comments==null){

      comments = new ACPanel();

      comments.setAutoWrap(true);

      addComments();
    }
    return comments;

  }

  /**
   * ���ӏ������x�����擾���܂��B
   * @return ���ӏ������x��
   */
  public ACLabel getWarningCommetn(){
    if(warningCommetn==null){

      warningCommetn = new ACLabel();

      warningCommetn.setText("�{�v���O�����̎g�p�ɂ�蔭�����������Ȃ鑹�Q�ɂ��ē����͐ӔC�𕉂��܂���B");

      warningCommetn.setRows(2);

      warningCommetn.setAutoWrap(true);

      addWarningCommetn();
    }
    return warningCommetn;

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
   * �{�^�����擾���܂��B
   * @return �{�^��
   */
  public ACButton getClose(){
    if(close==null){

      close = new ACButton();

      close.setText("����(C)");

      close.setToolTipText("�o�[�W����������܂��B");

      close.setMnemonic('C');

      addClose();
    }
    return close;

  }

  /**
   * �X�y�[�T�[���擾���܂��B
   * @return �X�y�[�T�[
   */
  public ACLabel getSpacer(){
    if(spacer==null){

      spacer = new ACLabel();

      spacer.setText("�@");

      addSpacer();
    }
    return spacer;

  }

  /**
   * �R���X�g���N�^�ł��B
   */
  public QV001Design() {

    super(ACFrame.getInstance(), true);
    this.getContentPane().setLayout(new VRLayout());
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    try {
      initialize();

      setSize(450, 500);

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
   * �o�[�W�������̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addContents(){

    contents.add(getQkanInfo(), VRLayout.NORTH);

    contents.add(getTabs(), VRLayout.CLIENT);

    contents.add(getVersionArea(), VRLayout.SOUTH);
  }

  /**
   * ���ǒ��ڍ׏��̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addQkanInfo(){

    qkanInfo.add(getQkanInfoText(), VRLayout.CLIENT);

  }

  /**
   * ���ǒ��ڍ׃e�L�X�g�G���A�ɓ������ڂ�ǉ����܂��B
   */
  protected void addQkanInfoText(){

  }

  /**
   * �^�u�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTabs(){

  }

  /**
   * �o�[�W�������̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addVersionArea(){

    versionArea.add(getComments(), VRLayout.CLIENT);

    versionArea.add(getButtons(), VRLayout.EAST);
    versionArea.add(getSpacer(), VRLayout.SOUTH);
  }

  /**
   * �R�����g�̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addComments(){

    comments.add(getWarningCommetn(), VRLayout.CLIENT);

  }

  /**
   * ���ӏ������x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addWarningCommetn(){

  }

  /**
   * �{�^���̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addButtons(){

    buttons.add(getClose(), VRLayout.FLOW);

  }

  /**
   * �{�^���ɓ������ڂ�ǉ����܂��B
   */
  protected void addClose(){

  }

  /**
   * �X�y�[�T�[�ɓ������ڂ�ǉ����܂��B
   */
  protected void addSpacer(){

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
      new QV001Design().setVisible(true);
      System.exit(0);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QV001Design getThis() {
    return this;
  }
}
