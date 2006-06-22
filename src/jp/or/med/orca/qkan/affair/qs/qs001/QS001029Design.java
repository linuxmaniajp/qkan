
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
 * �쐬��: 2006/03/15  ���{�R���s���[�^�[������� ���}�@�M�u �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �\��Ǘ� (S)
 * �v���Z�X �T�[�r�X�\�� (001)
 * �v���O���� ���x�z���ߒ������ (QS001029)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
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
 * ���x�z���ߒ�����ʉ�ʍ��ڃf�U�C��(QS001029) 
 */
public class QS001029Design extends QkanAffairDialog {
  //GUI�R���|�[�l���g

  private ACPanel contents;

  private ACDateTextField serviceDate;

  private ACLabelContainer serviceDateContainer;

  private ACBackLabelContainer serviceTime;

  private ACTimeTextField serviceStartTime;

  private ACLabelContainer serviceStartTimeContainer;

  private ACLabel serviceMidCode;

  private ACTimeTextField serviceEndTime;

  private ACLabelContainer serviceEndTimeContainer;

  private ACTextField providerNames;

  private ACLabelContainer providerNamesContainer;

  private ACTextField serviceName;

  private ACLabelContainer serviceNameContainer;

  private ACTextField serviceUnit;

  private ACLabelContainer serviceUnitContainer;

  private ACTextField serviceAdjustUnit;

  private ACLabelContainer serviceAdjustUnitContainer;

  private ACIntegerCheckBox serviceIndependence;

  private ACLabelContainer serviceIndependenceContainer;

  private ACTextField serviceResultUnit;

  private ACLabelContainer serviceResultUnitContainer;

  private ACPanel buttons;

  private ACButton submit;

  private ACButton close;

  //getter

  /**
   * ���x�z���ߒ�����ʗ̈���擾���܂��B
   * @return ���x�z���ߒ�����ʗ̈�
   */
  public ACPanel getContents(){
    if(contents==null){

      contents = new ACPanel();

      contents.setAutoWrap(false);

      contents.setHgrid(200);

      addContents();
    }
    return contents;

  }

  /**
   * ���t���擾���܂��B
   * @return ���t
   */
  public ACDateTextField getServiceDate(){
    if(serviceDate==null){

      serviceDate = new ACDateTextField();

      getServiceDateContainer().setText("�N����");

      serviceDate.setEditable(false);

      addServiceDate();
    }
    return serviceDate;

  }

  /**
   * ���t�R���e�i���擾���܂��B
   * @return ���t�R���e�i
   */
  protected ACLabelContainer getServiceDateContainer(){
    if(serviceDateContainer==null){
      serviceDateContainer = new ACLabelContainer();
      serviceDateContainer.setFollowChildEnabled(true);
      serviceDateContainer.setVAlignment(VRLayout.CENTER);
      serviceDateContainer.add(getServiceDate(), null);
    }
    return serviceDateContainer;
  }

  /**
   * �������擾���܂��B
   * @return ����
   */
  public ACBackLabelContainer getServiceTime(){
    if(serviceTime==null){

      serviceTime = new ACBackLabelContainer();

      serviceTime.setText("����");

      addServiceTime();
    }
    return serviceTime;

  }

  /**
   * �J�n�������擾���܂��B
   * @return �J�n����
   */
  public ACTimeTextField getServiceStartTime(){
    if(serviceStartTime==null){

      serviceStartTime = new ACTimeTextField();

      serviceStartTime.setBindPath("3");

      serviceStartTime.setEditable(false);

      serviceStartTime.setColumns(5);

      addServiceStartTime();
    }
    return serviceStartTime;

  }

  /**
   * �J�n�����R���e�i���擾���܂��B
   * @return �J�n�����R���e�i
   */
  protected ACLabelContainer getServiceStartTimeContainer(){
    if(serviceStartTimeContainer==null){
      serviceStartTimeContainer = new ACLabelContainer();
      serviceStartTimeContainer.setFollowChildEnabled(true);
      serviceStartTimeContainer.setVAlignment(VRLayout.CENTER);
      serviceStartTimeContainer.add(getServiceStartTime(), null);
    }
    return serviceStartTimeContainer;
  }

  /**
   * �`���x�����擾���܂��B
   * @return �`���x��
   */
  public ACLabel getServiceMidCode(){
    if(serviceMidCode==null){

      serviceMidCode = new ACLabel();

      serviceMidCode.setText("����");

      addServiceMidCode();
    }
    return serviceMidCode;

  }

  /**
   * �I���������擾���܂��B
   * @return �I������
   */
  public ACTimeTextField getServiceEndTime(){
    if(serviceEndTime==null){

      serviceEndTime = new ACTimeTextField();

      serviceEndTime.setBindPath("4");

      serviceEndTime.setEditable(false);

      serviceEndTime.setColumns(5);

      addServiceEndTime();
    }
    return serviceEndTime;

  }

  /**
   * �I�������R���e�i���擾���܂��B
   * @return �I�������R���e�i
   */
  protected ACLabelContainer getServiceEndTimeContainer(){
    if(serviceEndTimeContainer==null){
      serviceEndTimeContainer = new ACLabelContainer();
      serviceEndTimeContainer.setFollowChildEnabled(true);
      serviceEndTimeContainer.setVAlignment(VRLayout.CENTER);
      serviceEndTimeContainer.add(getServiceEndTime(), null);
    }
    return serviceEndTimeContainer;
  }

  /**
   * ���Ə����̂��擾���܂��B
   * @return ���Ə�����
   */
  public ACTextField getProviderNames(){
    if(providerNames==null){

      providerNames = new ACTextField();

      getProviderNamesContainer().setText("���Ə�����");

      providerNames.setEditable(false);

      providerNames.setColumns(15);

      addProviderNames();
    }
    return providerNames;

  }

  /**
   * ���Ə����̃R���e�i���擾���܂��B
   * @return ���Ə����̃R���e�i
   */
  protected ACLabelContainer getProviderNamesContainer(){
    if(providerNamesContainer==null){
      providerNamesContainer = new ACLabelContainer();
      providerNamesContainer.setFollowChildEnabled(true);
      providerNamesContainer.setVAlignment(VRLayout.CENTER);
      providerNamesContainer.add(getProviderNames(), null);
    }
    return providerNamesContainer;
  }

  /**
   * �T�[�r�X���̂��擾���܂��B
   * @return �T�[�r�X����
   */
  public ACTextField getServiceName(){
    if(serviceName==null){

      serviceName = new ACTextField();

      getServiceNameContainer().setText("�T�[�r�X����");

      serviceName.setEditable(false);

      serviceName.setColumns(18);

      addServiceName();
    }
    return serviceName;

  }

  /**
   * �T�[�r�X���̃R���e�i���擾���܂��B
   * @return �T�[�r�X���̃R���e�i
   */
  protected ACLabelContainer getServiceNameContainer(){
    if(serviceNameContainer==null){
      serviceNameContainer = new ACLabelContainer();
      serviceNameContainer.setFollowChildEnabled(true);
      serviceNameContainer.setVAlignment(VRLayout.CENTER);
      serviceNameContainer.add(getServiceName(), null);
    }
    return serviceNameContainer;
  }

  /**
   * �P�ʐ����擾���܂��B
   * @return �P�ʐ�
   */
  public ACTextField getServiceUnit(){
    if(serviceUnit==null){

      serviceUnit = new ACTextField();

      getServiceUnitContainer().setText("�P�ʐ�");

      serviceUnit.setEditable(false);

      serviceUnit.setColumns(5);

      serviceUnit.setHorizontalAlignment(SwingConstants.RIGHT);

      addServiceUnit();
    }
    return serviceUnit;

  }

  /**
   * �P�ʐ��R���e�i���擾���܂��B
   * @return �P�ʐ��R���e�i
   */
  protected ACLabelContainer getServiceUnitContainer(){
    if(serviceUnitContainer==null){
      serviceUnitContainer = new ACLabelContainer();
      serviceUnitContainer.setFollowChildEnabled(true);
      serviceUnitContainer.setVAlignment(VRLayout.CENTER);
      serviceUnitContainer.add(getServiceUnit(), null);
    }
    return serviceUnitContainer;
  }

  /**
   * �����z���擾���܂��B
   * @return �����z
   */
  public ACTextField getServiceAdjustUnit(){
    if(serviceAdjustUnit==null){

      serviceAdjustUnit = new ACTextField();

      getServiceAdjustUnitContainer().setText("���p�ҕ��S�P�ʐ�");

      serviceAdjustUnit.setBindPath("REGULATION_RATE");

      serviceAdjustUnit.setColumns(5);

      serviceAdjustUnit.setCharType(VRCharType.ONLY_DIGIT);

      serviceAdjustUnit.setHorizontalAlignment(SwingConstants.RIGHT);

      serviceAdjustUnit.setIMEMode(InputSubset.LATIN);

      serviceAdjustUnit.setMaxLength(6);

      addServiceAdjustUnit();
    }
    return serviceAdjustUnit;

  }

  /**
   * �����z�R���e�i���擾���܂��B
   * @return �����z�R���e�i
   */
  protected ACLabelContainer getServiceAdjustUnitContainer(){
    if(serviceAdjustUnitContainer==null){
      serviceAdjustUnitContainer = new ACLabelContainer();
      serviceAdjustUnitContainer.setFollowChildEnabled(true);
      serviceAdjustUnitContainer.setVAlignment(VRLayout.CENTER);
      serviceAdjustUnitContainer.add(getServiceAdjustUnit(), null);
    }
    return serviceAdjustUnitContainer;
  }

  /**
   * �S�z���ȕ��S���擾���܂��B
   * @return �S�z���ȕ��S
   */
  public ACIntegerCheckBox getServiceIndependence(){
    if(serviceIndependence==null){

      serviceIndependence = new ACIntegerCheckBox();

      getServiceIndependenceContainer().setText("�S�z���ȕ��S");

      addServiceIndependence();
    }
    return serviceIndependence;

  }

  /**
   * �S�z���ȕ��S�R���e�i���擾���܂��B
   * @return �S�z���ȕ��S�R���e�i
   */
  protected ACLabelContainer getServiceIndependenceContainer(){
    if(serviceIndependenceContainer==null){
      serviceIndependenceContainer = new ACLabelContainer();
      serviceIndependenceContainer.setFollowChildEnabled(true);
      serviceIndependenceContainer.setVAlignment(VRLayout.CENTER);
      serviceIndependenceContainer.add(getServiceIndependence(), null);
    }
    return serviceIndependenceContainer;
  }

  /**
   * ������P�ʐ����擾���܂��B
   * @return ������P�ʐ�
   */
  public ACTextField getServiceResultUnit(){
    if(serviceResultUnit==null){

      serviceResultUnit = new ACTextField();

      getServiceResultUnitContainer().setText("�ی��ҕ��S�P�ʐ�");

      serviceResultUnit.setEditable(false);

      serviceResultUnit.setColumns(5);

      serviceResultUnit.setHorizontalAlignment(SwingConstants.RIGHT);

      addServiceResultUnit();
    }
    return serviceResultUnit;

  }

  /**
   * ������P�ʐ��R���e�i���擾���܂��B
   * @return ������P�ʐ��R���e�i
   */
  protected ACLabelContainer getServiceResultUnitContainer(){
    if(serviceResultUnitContainer==null){
      serviceResultUnitContainer = new ACLabelContainer();
      serviceResultUnitContainer.setFollowChildEnabled(true);
      serviceResultUnitContainer.setVAlignment(VRLayout.CENTER);
      serviceResultUnitContainer.add(getServiceResultUnit(), null);
    }
    return serviceResultUnitContainer;
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
  public ACButton getSubmit(){
    if(submit==null){

      submit = new ACButton();

      submit.setText("OK");

      submit.setToolTipText("���͂��ꂽ���Œ����z���X�V���܂��B");

      submit.setMnemonic('O');

      submit.setIconPath(ACConstants.ICON_PATH_OK_16);

      addSubmit();
    }
    return submit;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACButton getClose(){
    if(close==null){

      close = new ACButton();

      close.setText("�L�����Z��(C)");

      close.setToolTipText("�����z�̍X�V�͍s�킸�A�O�̉�ʂɖ߂�܂��B");

      close.setMnemonic('C');

      close.setIconPath(ACConstants.ICON_PATH_CANCEL_16);

      addClose();
    }
    return close;

  }

  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001029Design() {

    super(ACFrame.getInstance(), true);
    this.getContentPane().setLayout(new VRLayout());
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    try {
      initialize();

      setSize(380, 230);

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
   * ���x�z���ߒ�����ʗ̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addContents(){

    contents.add(getServiceDateContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    contents.add(getServiceTime(), VRLayout.FLOW_DOUBLEINSETLINE_RETURN);

    contents.add(getProviderNamesContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    contents.add(getServiceNameContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    contents.add(getServiceUnitContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    contents.add(getServiceAdjustUnitContainer(), VRLayout.FLOW_INSETLINE);

    contents.add(getServiceIndependenceContainer(), VRLayout.FLOW_RETURN);

    contents.add(getServiceResultUnitContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    contents.add(getButtons(), VRLayout.SOUTH);
  }

  /**
   * ���t�ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceDate(){

  }

  /**
   * �����ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceTime(){

    serviceTime.add(getServiceStartTimeContainer(), VRLayout.FLOW);

    serviceTime.add(getServiceMidCode(), VRLayout.FLOW);

    serviceTime.add(getServiceEndTimeContainer(), VRLayout.FLOW);

  }

  /**
   * �J�n�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceStartTime(){

  }

  /**
   * �`���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceMidCode(){

  }

  /**
   * �I�������ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceEndTime(){

  }

  /**
   * ���Ə����̂ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderNames(){

  }

  /**
   * �T�[�r�X���̂ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceName(){

  }

  /**
   * �P�ʐ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceUnit(){

  }

  /**
   * �����z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceAdjustUnit(){

  }

  /**
   * �S�z���ȕ��S�ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceIndependence(){

  }

  /**
   * ������P�ʐ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceResultUnit(){

  }

  /**
   * �{�^���̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addButtons(){

    buttons.add(getClose(), VRLayout.EAST);
    buttons.add(getSubmit(), VRLayout.EAST);
  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addSubmit(){

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
      new QS001029Design().setVisible(true);
      System.exit(0);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QS001029Design getThis() {
    return this;
  }
}
