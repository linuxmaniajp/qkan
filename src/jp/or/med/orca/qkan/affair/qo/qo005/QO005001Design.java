
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
 * �J����: �c���@����
 * �쐬��: 2006/09/06  ���{�R���s���[�^�[������� �c���@���� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���̑��@�\ (O)
 * �v���Z�X �V�X�e���ݒ� (005)
 * �v���O���� ����ŗ��ҏW (QO005001)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qo.qo005;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.im.InputSubset;

import javax.swing.SwingConstants;

import jp.nichicom.ac.ACCommon;
import jp.nichicom.ac.ACConstants;
import jp.nichicom.ac.component.ACButton;
import jp.nichicom.ac.component.ACLabel;
import jp.nichicom.ac.component.ACTextField;
import jp.nichicom.ac.container.ACLabelContainer;
import jp.nichicom.ac.container.ACPanel;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.vr.layout.VRLayout;
import jp.nichicom.vr.text.VRCharType;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.affair.QkanAffairDialog;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
/**
 * ����ŗ��ҏW��ʍ��ڃf�U�C��(QO005001) 
 */
public class QO005001Design extends QkanAffairDialog {
  //GUI�R���|�[�l���g

  private ACPanel contents;

  private ACLabelContainer taxContainer;

  private ACTextField tax;

  private ACLabel taxUnit;

  private ACPanel buttons;

  private ACButton ok;

  private ACButton close;

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
   * �ŗ��R���e�i���擾���܂��B
   * @return �ŗ��R���e�i
   */
  public ACLabelContainer getTaxContainer(){
    if(taxContainer==null){

      taxContainer = new ACLabelContainer();

      taxContainer.setText("����ŗ�");

      addTaxContainer();
    }
    return taxContainer;

  }

  /**
   * �ŗ����擾���܂��B
   * @return �ŗ�
   */
  public ACTextField getTax(){
    if(tax==null){

      tax = new ACTextField();

      tax.setBindPath("TAX");

      tax.setColumns(3);

      tax.setCharType(VRCharType.ONLY_FLOAT);

      tax.setHorizontalAlignment(SwingConstants.RIGHT);

      tax.setIMEMode(InputSubset.LATIN);

      tax.setMaxLength(3);

      addTax();
    }
    return tax;

  }

  /**
   * �ŗ��P�ʂ��擾���܂��B
   * @return �ŗ��P��
   */
  public ACLabel getTaxUnit(){
    if(taxUnit==null){

      taxUnit = new ACLabel();

      taxUnit.setText("%");

      addTaxUnit();
    }
    return taxUnit;

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
   * ������擾���܂��B
   * @return ����
   */
  public ACButton getOk(){
    if(ok==null){

      ok = new ACButton();

      ok.setText("OK");

      ok.setToolTipText("���͂��ꂽ���ŏ���ŗ����X�V���܂��B");

      ok.setMnemonic('O');

      ok.setIconPath(ACConstants.ICON_PATH_OK_16);

      addOk();
    }
    return ok;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACButton getClose(){
    if(close==null){

      close = new ACButton();

      close.setText("�L�����Z��(C)");

      close.setToolTipText("����ŗ��̍X�V�͍s�킸�A�O�̉�ʂɖ߂�܂��B");

      close.setMnemonic('C');

      close.setIconPath(ACConstants.ICON_PATH_CANCEL_16);

      addClose();
    }
    return close;

  }

  /**
   * �R���X�g���N�^�ł��B
   */
  public QO005001Design() {

    super(ACFrame.getInstance(), true);
    this.getContentPane().setLayout(new VRLayout());
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    try {
      initialize();

      setSize(300, 110);

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

    this.getContentPane().add(getButtons(), VRLayout.SOUTH);
  }

  /**
   * �N���C�A���g�̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addContents(){

    contents.add(getTaxContainer(), VRLayout.FLOW_INSETLINE);

  }

  /**
   * �ŗ��R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTaxContainer(){

    taxContainer.add(getTax(), VRLayout.FLOW);

    taxContainer.add(getTaxUnit(), VRLayout.FLOW);

  }

  /**
   * �ŗ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addTax(){

  }

  /**
   * �ŗ��P�ʂɓ������ڂ�ǉ����܂��B
   */
  protected void addTaxUnit(){

  }

  /**
   * �{�^���̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addButtons(){

    buttons.add(getClose(), VRLayout.EAST);
    buttons.add(getOk(), VRLayout.EAST);
  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addOk(){

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
      new QO005001Design().setVisible(true);
      System.exit(0);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QO005001Design getThis() {
    return this;
  }
}
