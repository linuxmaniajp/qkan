
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
 * �쐬��: 2009/07/09  ���{�R���s���[�^�[������� ����@��F �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���уf�[�^�쐬 (P)
 * �v���Z�X ���׏��ڍוҏW (005)
 * �v���O���� ����f�Ô�R�[�h�ǉ� (QP005001)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qp.qp005;
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
 * ����f�Ô�R�[�h�ǉ���ʍ��ڃf�U�C��(QP005001) 
 */
public class QP005001Design extends QkanAffairDialog {
  //GUI�R���|�[�l���g

  private ACPanel contents;

  private ACPanel inputPanel;

  private ACLabelContainer serviceCodeContainer;

  private ACLabel serviceCodeKindLabel;

  private ACTextField serviceCodeDetailText;

  private ACLabelContainer serviceNameContainer;

  private ACTextField serviceNameText;

  private ACLabelContainer costContainer;

  private ACTextField costText;

  private ACLabel costUnitLabel;

  private ACLabelContainer costLimitContainer;

  private ACTextField costLimitText;

  private ACLabel costLimitUnitLabel;

  private ACLabelContainer dayContainer;

  private ACTextField dayText;

  private ACLabel dayUnitLabel;

  private ACPanel buttons;

  private ACButton addButton;

  private ACButton cancelButton;

  //getter

  /**
   * ����f�Ô�R�[�h�ݒ�̈���擾���܂��B
   * @return ����f�Ô�R�[�h�ݒ�̈�
   */
  public ACPanel getContents(){
    if(contents==null){

      contents = new ACPanel();

      addContents();
    }
    return contents;

  }

  /**
   * ���͗̈���擾���܂��B
   * @return ���͗̈�
   */
  public ACPanel getInputPanel(){
    if(inputPanel==null){

      inputPanel = new ACPanel();

      inputPanel.setAutoWrap(false);

      inputPanel.setHgap(5);

      inputPanel.setLabelMargin(0);

      inputPanel.setVgap(3);

      addInputPanel();
    }
    return inputPanel;

  }

  /**
   * �T�[�r�X�R�[�h�R���e�i���擾���܂��B
   * @return �T�[�r�X�R�[�h�R���e�i
   */
  public ACLabelContainer getServiceCodeContainer(){
    if(serviceCodeContainer==null){

      serviceCodeContainer = new ACLabelContainer();

      serviceCodeContainer.setText("�T�[�r�X�R�[�h");

      serviceCodeContainer.setVisible(true);

      serviceCodeContainer.setAutoWrap(false);

      serviceCodeContainer.setHgap(5);

      serviceCodeContainer.setLabelMargin(2);

      serviceCodeContainer.setVgap(0);

      addServiceCodeContainer();
    }
    return serviceCodeContainer;

  }

  /**
   * �T�[�r�X�R�[�h��ރ��x�����擾���܂��B
   * @return �T�[�r�X�R�[�h��ރ��x��
   */
  public ACLabel getServiceCodeKindLabel(){
    if(serviceCodeKindLabel==null){

      serviceCodeKindLabel = new ACLabel();

      serviceCodeKindLabel.setText("59");

      serviceCodeKindLabel.setBindPath("801008");

      serviceCodeKindLabel.setAutoWrap(false);

      addServiceCodeKindLabel();
    }
    return serviceCodeKindLabel;

  }

  /**
   * �T�[�r�X�R�[�h���ڃe�L�X�g���擾���܂��B
   * @return �T�[�r�X�R�[�h���ڃe�L�X�g
   */
  public ACTextField getServiceCodeDetailText(){
    if(serviceCodeDetailText==null){

      serviceCodeDetailText = new ACTextField();

      serviceCodeDetailText.setBindPath("801009");

      serviceCodeDetailText.setColumns(3);

      serviceCodeDetailText.setCharType(VRCharType.ONLY_DIGIT);

      serviceCodeDetailText.setHorizontalAlignment(SwingConstants.RIGHT);

      serviceCodeDetailText.setIMEMode(InputSubset.LATIN);

      serviceCodeDetailText.setMaxLength(4);

      addServiceCodeDetailText();
    }
    return serviceCodeDetailText;

  }

  /**
   * �T�[�r�X���̃R���e�i���擾���܂��B
   * @return �T�[�r�X���̃R���e�i
   */
  public ACLabelContainer getServiceNameContainer(){
    if(serviceNameContainer==null){

      serviceNameContainer = new ACLabelContainer();

      serviceNameContainer.setText("�T�[�r�X����");

      serviceNameContainer.setAutoWrap(false);

      serviceNameContainer.setHgap(5);

      serviceNameContainer.setLabelMargin(0);

      serviceNameContainer.setVgap(0);

      addServiceNameContainer();
    }
    return serviceNameContainer;

  }

  /**
   * �T�[�r�X���̃e�L�X�g���擾���܂��B
   * @return �T�[�r�X���̃e�L�X�g
   */
  public ACTextField getServiceNameText(){
    if(serviceNameText==null){

      serviceNameText = new ACTextField();

      serviceNameText.setBindPath("801034");

      serviceNameText.setEditable(false);

      serviceNameText.setColumns(25);

      serviceNameText.setMaxLength(50);

      addServiceNameText();
    }
    return serviceNameText;

  }

  /**
   * ��p�P���R���e�i���擾���܂��B
   * @return ��p�P���R���e�i
   */
  public ACLabelContainer getCostContainer(){
    if(costContainer==null){

      costContainer = new ACLabelContainer();

      costContainer.setText("��p�P��");

      costContainer.setAutoWrap(false);

      costContainer.setHgap(5);

      costContainer.setLabelMargin(0);

      costContainer.setVgap(0);

      addCostContainer();
    }
    return costContainer;

  }

  /**
   * ��p�P���e�L�X�g���擾���܂��B
   * @return ��p�P���e�L�X�g
   */
  public ACTextField getCostText(){
    if(costText==null){

      costText = new ACTextField();

      costText.setBindPath("801010");

      costText.setColumns(3);

      costText.setCharType(VRCharType.ONLY_DIGIT);

      costText.setHorizontalAlignment(SwingConstants.RIGHT);

      costText.setIMEMode(InputSubset.LATIN);

      costText.setMaxLength(4);

      addCostText();
    }
    return costText;

  }

  /**
   * ��p�P�����x�����擾���܂��B
   * @return ��p�P�����x��
   */
  public ACLabel getCostUnitLabel(){
    if(costUnitLabel==null){

      costUnitLabel = new ACLabel();

      costUnitLabel.setText("�~");

      costUnitLabel.setAutoWrap(false);

      addCostUnitLabel();
    }
    return costUnitLabel;

  }

  /**
   * ��p���x�z�R���e�i���擾���܂��B
   * @return ��p���x�z�R���e�i
   */
  public ACLabelContainer getCostLimitContainer(){
    if(costLimitContainer==null){

      costLimitContainer = new ACLabelContainer();

      costLimitContainer.setText("��p���x�z");

      costLimitContainer.setAutoWrap(false);

      costLimitContainer.setHgap(5);

      costLimitContainer.setLabelMargin(0);

      costLimitContainer.setVgap(0);

      addCostLimitContainer();
    }
    return costLimitContainer;

  }

  /**
   * ��p���x�z�e�L�X�g���擾���܂��B
   * @return ��p���x�z�e�L�X�g
   */
  public ACTextField getCostLimitText(){
    if(costLimitText==null){

      costLimitText = new ACTextField();

      costLimitText.setBindPath("801011");

      costLimitText.setColumns(3);

      costLimitText.setCharType(VRCharType.ONLY_NUMBER);

      costLimitText.setHorizontalAlignment(SwingConstants.RIGHT);

      costLimitText.setIMEMode(InputSubset.LATIN);

      costLimitText.setMaxLength(4);

      addCostLimitText();
    }
    return costLimitText;

  }

  /**
   * ��p���x�z���x�����擾���܂��B
   * @return ��p���x�z���x��
   */
  public ACLabel getCostLimitUnitLabel(){
    if(costLimitUnitLabel==null){

      costLimitUnitLabel = new ACLabel();

      costLimitUnitLabel.setText("�~");

      addCostLimitUnitLabel();
    }
    return costLimitUnitLabel;

  }

  /**
   * �����R���e�i���擾���܂��B
   * @return �����R���e�i
   */
  public ACLabelContainer getDayContainer(){
    if(dayContainer==null){

      dayContainer = new ACLabelContainer();

      dayContainer.setText("����");

      dayContainer.setAutoWrap(false);

      dayContainer.setHgap(5);

      dayContainer.setLabelMargin(0);

      dayContainer.setVgap(0);

      addDayContainer();
    }
    return dayContainer;

  }

  /**
   * �����e�L�X�g���擾���܂��B
   * @return �����e�L�X�g
   */
  public ACTextField getDayText(){
    if(dayText==null){

      dayText = new ACTextField();

      dayText.setBindPath("801012");

      dayText.setColumns(2);

      dayText.setCharType(VRCharType.ONLY_DIGIT);

      dayText.setHorizontalAlignment(SwingConstants.RIGHT);

      dayText.setIMEMode(InputSubset.LATIN);

      dayText.setMaxLength(2);

      addDayText();
    }
    return dayText;

  }

  /**
   * �������x�����擾���܂��B
   * @return �������x��
   */
  public ACLabel getDayUnitLabel(){
    if(dayUnitLabel==null){

      dayUnitLabel = new ACLabel();

      dayUnitLabel.setText("��");

      addDayUnitLabel();
    }
    return dayUnitLabel;

  }

  /**
   * �{�^���̈���擾���܂��B
   * @return �{�^���̈�
   */
  public ACPanel getButtons(){
    if(buttons==null){

      buttons = new ACPanel();

      buttons.setAutoWrap(false);

      buttons.setHgap(0);

      buttons.setLabelMargin(0);

      buttons.setVgap(0);

      addButtons();
    }
    return buttons;

  }

  /**
   * �ǉ����擾���܂��B
   * @return �ǉ�
   */
  public ACButton getAddButton(){
    if(addButton==null){

      addButton = new ACButton();

      addButton.setText("�ǉ�(A)");

      addButton.setMnemonic('A');

      addButton.setIconPath(ACConstants.ICON_PATH_RECORD_DOWNLOAD_16);

      addAddButton();
    }
    return addButton;

  }

  /**
   * �L�����Z�����擾���܂��B
   * @return �L�����Z��
   */
  public ACButton getCancelButton(){
    if(cancelButton==null){

      cancelButton = new ACButton();

      cancelButton.setText("�L�����Z��(C)");

      cancelButton.setMnemonic('C');

      cancelButton.setIconPath(ACConstants.ICON_PATH_CANCEL_16);

      addCancelButton();
    }
    return cancelButton;

  }

  /**
   * �R���X�g���N�^�ł��B
   */
  public QP005001Design() {

    super(ACFrame.getInstance(), true);
    this.getContentPane().setLayout(new VRLayout());
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    try {
      initialize();

      setSize(430, 190);

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
   * ����f�Ô�R�[�h�ݒ�̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addContents(){

    contents.add(getInputPanel(), VRLayout.NORTH);

    contents.add(getButtons(), VRLayout.NORTH);

  }

  /**
   * ���͗̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addInputPanel(){

    inputPanel.add(getServiceCodeContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    inputPanel.add(getServiceNameContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    inputPanel.add(getCostContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    inputPanel.add(getCostLimitContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    inputPanel.add(getDayContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * �T�[�r�X�R�[�h�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceCodeContainer(){

    serviceCodeContainer.add(getServiceCodeKindLabel(), VRLayout.FLOW);

    serviceCodeContainer.add(getServiceCodeDetailText(), VRLayout.FLOW);

  }

  /**
   * �T�[�r�X�R�[�h��ރ��x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceCodeKindLabel(){

  }

  /**
   * �T�[�r�X�R�[�h���ڃe�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceCodeDetailText(){

  }

  /**
   * �T�[�r�X���̃R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceNameContainer(){

    serviceNameContainer.add(getServiceNameText(), VRLayout.FLOW);

  }

  /**
   * �T�[�r�X���̃e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceNameText(){

  }

  /**
   * ��p�P���R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addCostContainer(){

    costContainer.add(getCostText(), VRLayout.FLOW);

    costContainer.add(getCostUnitLabel(), VRLayout.FLOW);

  }

  /**
   * ��p�P���e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addCostText(){

  }

  /**
   * ��p�P�����x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCostUnitLabel(){

  }

  /**
   * ��p���x�z�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addCostLimitContainer(){

    costLimitContainer.add(getCostLimitText(), VRLayout.FLOW);

    costLimitContainer.add(getCostLimitUnitLabel(), VRLayout.FLOW);

  }

  /**
   * ��p���x�z�e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addCostLimitText(){

  }

  /**
   * ��p���x�z���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCostLimitUnitLabel(){

  }

  /**
   * �����R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addDayContainer(){

    dayContainer.add(getDayText(), VRLayout.FLOW);

    dayContainer.add(getDayUnitLabel(), VRLayout.FLOW);

  }

  /**
   * �����e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addDayText(){

  }

  /**
   * �������x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addDayUnitLabel(){

  }

  /**
   * �{�^���̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addButtons(){

    buttons.add(getCancelButton(), VRLayout.EAST);
    buttons.add(getAddButton(), VRLayout.EAST);
  }

  /**
   * �ǉ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addAddButton(){

  }

  /**
   * �L�����Z���ɓ������ڂ�ǉ����܂��B
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
      new QP005001Design().setVisible(true);
      System.exit(0);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QP005001Design getThis() {
    return this;
  }
}
