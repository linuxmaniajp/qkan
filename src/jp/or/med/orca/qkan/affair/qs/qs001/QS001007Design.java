
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
 * �쐬��: 2007/12/17  ���{�R���s���[�^�[������� ����@��F �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �\��Ǘ� (S)
 * �v���Z�X �T�[�r�X�\�� (001)
 * �v���O���� �p�^�[�����̕ύX (QS001033)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.im.InputSubset;

import javax.swing.SwingConstants;

import jp.nichicom.ac.ACCommon;
import jp.nichicom.ac.ACConstants;
import jp.nichicom.ac.component.ACButton;
import jp.nichicom.ac.component.ACTextField;
import jp.nichicom.ac.container.ACLabelContainer;
import jp.nichicom.ac.container.ACPanel;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.vr.layout.VRLayout;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.affair.QkanAffairDialog;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
/**
 * �p�^�[�����̕ύX��ʍ��ڃf�U�C��(QS001033) 
 */
@SuppressWarnings("serial")
public class QS001007Design extends QkanAffairDialog {
  //GUI�R���|�[�l���g

  private ACPanel contents;

  private ACPanel changePanel;

  private ACTextField afterServiceText;

  private ACLabelContainer afterServiceTextContainer;

  private ACPanel buttonsPanel;

  private ACButton okButton;

  private ACButton cancelButton;

  //getter

  /**
   * �T�[�r�X�p�^�[�����̕ύX�̈���擾���܂��B
   * @return �T�[�r�X�p�^�[�����̕ύX�̈�
   */
  public ACPanel getContents(){
    if(contents==null){

      contents = new ACPanel();

      contents.setBackground(Color.blue);

      addContents();
    }
    return contents;

  }

  /**
   * �e�L�X�g�̈���擾���܂��B
   * @return �e�L�X�g�̈�
   */
  public ACPanel getChangePanel(){
    if(changePanel==null){

      changePanel = new ACPanel();

      changePanel.setVisible(true);

      addChangePanel();
    }
    return changePanel;

  }

  /**
   * �ύX��e�L�X�g���擾���܂��B
   * @return �ύX��e�L�X�g
   */
  public ACTextField getAfterServiceText(){
    if(afterServiceText==null){

      afterServiceText = new ACTextField();

      getAfterServiceTextContainer().setText("�ύX��T�[�r�X�p�^�[����");

      afterServiceText.setBindPath("11");

      afterServiceText.setVisible(true);

      afterServiceText.setEnabled(true);

      afterServiceText.setEditable(true);

      afterServiceText.setColumns(21);

      afterServiceText.setHorizontalAlignment(SwingConstants.LEFT);

      afterServiceText.setIMEMode(InputSubset.KANJI);

      afterServiceText.setMaxLength(20);

      addAfterServiceText();
    }
    return afterServiceText;

  }

  /**
   * �ύX��e�L�X�g�R���e�i���擾���܂��B
   * @return �ύX��e�L�X�g�R���e�i
   */
  protected ACLabelContainer getAfterServiceTextContainer(){
    if(afterServiceTextContainer==null){
      afterServiceTextContainer = new ACLabelContainer();
      afterServiceTextContainer.setFollowChildEnabled(true);
      afterServiceTextContainer.setVAlignment(VRLayout.CENTER);
      afterServiceTextContainer.add(getAfterServiceText(), null);
    }
    return afterServiceTextContainer;
  }

  /**
   * �{�^���̈���擾���܂��B
   * @return �{�^���̈�
   */
  public ACPanel getButtonsPanel(){
    if(buttonsPanel==null){

      buttonsPanel = new ACPanel();

      buttonsPanel.setVisible(true);

      addButtonsPanel();
    }
    return buttonsPanel;

  }

  /**
   * OK�{�^�����擾���܂��B
   * @return OK�{�^��
   */
  public ACButton getOkButton(){
    if(okButton==null){

      okButton = new ACButton();

      okButton.setText("OK");

      okButton.setVisible(true);

      okButton.setEnabled(true);

      okButton.setMnemonic('O');

      okButton.setIconPath(ACConstants.ICON_PATH_OK_16);

      addOkButton();
    }
    return okButton;

  }

  /**
   * �L�����Z���{�^�����擾���܂��B
   * @return �L�����Z���{�^��
   */
  public ACButton getCancelButton(){
    if(cancelButton==null){

      cancelButton = new ACButton();

      cancelButton.setText("�L�����Z��(C)");

      cancelButton.setVisible(true);

      cancelButton.setEnabled(true);

      cancelButton.setMnemonic('C');

      cancelButton.setIconPath(ACConstants.ICON_PATH_CANCEL_16);

      addCancelButton();
    }
    return cancelButton;

  }

  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001007Design() {

    super(ACFrame.getInstance(), true);
    this.getContentPane().setLayout(new VRLayout());
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    try {
      initialize();

      setSize(450, 85);

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
   * �T�[�r�X�p�^�[�����̕ύX�̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addContents(){

    contents.add(getChangePanel(), VRLayout.CLIENT);

    contents.add(getButtonsPanel(), VRLayout.SOUTH);
  }

  /**
   * �e�L�X�g�̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addChangePanel(){

    changePanel.add(getAfterServiceTextContainer(), VRLayout.FLOW_INSETLINE);

  }

  /**
   * �ύX��e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addAfterServiceText(){

  }

  /**
   * �{�^���̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addButtonsPanel(){

    buttonsPanel.add(getCancelButton(), VRLayout.EAST);
    buttonsPanel.add(getOkButton(), VRLayout.EAST);
  }

  /**
   * OK�{�^���ɓ������ڂ�ǉ����܂��B
   */
  protected void addOkButton(){

  }

  /**
   * �L�����Z���{�^���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCancelButton(){

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
      new QS001007Design().setVisible(true);
      System.exit(0);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QS001007Design getThis() {
    return this;
  }
}
