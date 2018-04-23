
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
 * �J����: �����@�L
 * �쐬��: 2018/04/12  ���{�R���s���[�^�[������� �����@�L �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���ъm��^�������o�� (P)
 * �v���Z�X CSV�o�� (008)
 * �v���O���� �t�H���_�I�� (QP008)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qp.qp008;
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
 * �t�H���_�I����ʍ��ڃf�U�C��(QP008) 
 */
public class QP008Design extends QkanAffairDialog {
  //GUI�R���|�[�l���g

  private ACPanel contents;

  private ACPanel errorPanel;

  private ACLabel errorSpacer1;

  private ACLabel comment;

  private ACLabel errorSpacer2;

  private ACPanel fileSelects;

  private VRLayout fileSelectLayout;

  private ACLabel fileSelectLabel;

  private ACPanel saveButtons;

  private VRLayout saveButtonLayout;

  private ACButton saveStandardButton;

  private ACButton saveOptionButton;

  private ACTextField filePath;

  private ACIntegerCheckBox fileFormCheckBox;

  private ACPanel operation;

  private ACPanel mediumDivisions;

  private ACClearableRadioButtonGroup mediumDivisionRadio;

  private ACLabelContainer mediumDivisionRadioContainer;

  private ACListModelAdapter mediumDivisionRadioModel;

  private ACRadioButtonItem mediumDivisionRadioItem1;

  private ACRadioButtonItem mediumDivisionRadioItem2;

  private ACRadioButtonItem mediumDivisionRadioItem3;

  private ACRadioButtonItem mediumDivisionRadioItem4;

  private ACPanel buttons;

  private ACPanel buttonsDetail;

  private ACButton ok;

  private ACButton goBack;

  private ACButton cancel;

  //getter

  /**
   * �N���C�A���g�̈���擾���܂��B
   * @return �N���C�A���g�̈�
   */
  public ACPanel getContents(){
    if(contents==null){

      contents = new ACPanel();

      contents.setAutoWrap(false);

      addContents();
    }
    return contents;

  }

  /**
   * �G���[�\���̈���擾���܂��B
   * @return �G���[�\���̈�
   */
  public ACPanel getErrorPanel(){
    if(errorPanel==null){

      errorPanel = new ACPanel();

      errorPanel.setVisible(false);

      errorPanel.setFollowChildEnabled(true);

      addErrorPanel();
    }
    return errorPanel;

  }

  /**
   * �X�y�[�T�[���擾���܂��B
   * @return �X�y�[�T�[
   */
  public ACLabel getErrorSpacer1(){
    if(errorSpacer1==null){

      errorSpacer1 = new ACLabel();

      errorSpacer1.setText("�@" + ACConstants.LINE_SEPARATOR + "�@");

      addErrorSpacer1();
    }
    return errorSpacer1;

  }

  /**
   * ���������擾���܂��B
   * @return ������
   */
  public ACLabel getComment(){
    if(comment==null){

      comment = new ACLabel();

      comment.setText("      �f�B�X�N���h���C�u�ɑ}�����āAOK�{�^�����N���b�N���Ă��������B");

      addComment();
    }
    return comment;

  }

  /**
   * �X�y�[�T�[���擾���܂��B
   * @return �X�y�[�T�[
   */
  public ACLabel getErrorSpacer2(){
    if(errorSpacer2==null){

      errorSpacer2 = new ACLabel();

      errorSpacer2.setText("�@" + ACConstants.LINE_SEPARATOR + "�@");

      addErrorSpacer2();
    }
    return errorSpacer2;

  }

  /**
   * �t�H���_�I��̈���擾���܂��B
   * @return �t�H���_�I��̈�
   */
  public ACPanel getFileSelects(){
    if(fileSelects==null){

      fileSelects = new ACPanel();

      fileSelects.setLayout(getFileSelectLayout());

      fileSelects.setVisible(true);

      fileSelects.setFollowChildEnabled(true);

      addFileSelects();
    }
    return fileSelects;

  }

  /**
   * �t�H���_�I��̈�E���C�A�E�g���擾���܂��B
   * @return �t�H���_�I��̈�E���C�A�E�g
   */
  public VRLayout getFileSelectLayout(){
    if(fileSelectLayout==null){

      fileSelectLayout = new VRLayout();

      fileSelectLayout.setAutoWrap(false);

      addFileSelectLayout();
    }
    return fileSelectLayout;

  }

  /**
   * �t�H���_�I���R�����g�E���x�����擾���܂��B
   * @return �t�H���_�I���R�����g�E���x��
   */
  public ACLabel getFileSelectLabel(){
    if(fileSelectLabel==null){

      fileSelectLabel = new ACLabel();

      fileSelectLabel.setText("�f�[�^���������ރh���C�u��I�����āAOK�{�^�����N���b�N���Ă��������B");

      addFileSelectLabel();
    }
    return fileSelectLabel;

  }

  /**
   * �ۑ��挈��E�p�l�����擾���܂��B
   * @return �ۑ��挈��E�p�l��
   */
  public ACPanel getSaveButtons(){
    if(saveButtons==null){

      saveButtons = new ACPanel();

      saveButtons.setLayout(getSaveButtonLayout());

      addSaveButtons();
    }
    return saveButtons;

  }

  /**
   * �ۑ��挈��E���C�A�E�g���擾���܂��B
   * @return �ۑ��挈��E���C�A�E�g
   */
  public VRLayout getSaveButtonLayout(){
    if(saveButtonLayout==null){

      saveButtonLayout = new VRLayout();

      saveButtonLayout.setAutoWrap(false);

      saveButtonLayout.setHgap(0);

      saveButtonLayout.setVgap(5);

      addSaveButtonLayout();
    }
    return saveButtonLayout;

  }

  /**
   * �ۑ��挈��(�)�{�^�����擾���܂��B
   * @return �ۑ��挈��(�)�{�^��
   */
  public ACButton getSaveStandardButton(){
    if(saveStandardButton==null){

      saveStandardButton = new ACButton();

      saveStandardButton.setText("A:");

      addSaveStandardButton();
    }
    return saveStandardButton;

  }

  /**
   * �ۑ��挈��(�C��)�{�^�����擾���܂��B
   * @return �ۑ��挈��(�C��)�{�^��
   */
  public ACButton getSaveOptionButton(){
    if(saveOptionButton==null){

      saveOptionButton = new ACButton();

      saveOptionButton.setText("�C�ӂ̃t�H���_:");

      addSaveOptionButton();
    }
    return saveOptionButton;

  }

  /**
   * �t�@�C���p�X�E�e�L�X�g���擾���܂��B
   * @return �t�@�C���p�X�E�e�L�X�g
   */
  public ACTextField getFilePath(){
    if(filePath==null){

      filePath = new ACTextField();

      filePath.setBindPath("FILE_PATH");

      filePath.setColumns(30);

      addFilePath();
    }
    return filePath;

  }

  /**
   * �ۑ��`���E�`�F�b�N�{�b�N�X���擾���܂��B
   * @return �ۑ��`���E�`�F�b�N�{�b�N�X
   */
  public ACIntegerCheckBox getFileFormCheckBox(){
    if(fileFormCheckBox==null){

      fileFormCheckBox = new ACIntegerCheckBox();

      fileFormCheckBox.setText("�f�t�H���g�Ƃ��ĕۑ�(V)");

      fileFormCheckBox.setBindPath("FILE_FORM_CHECK");

      fileFormCheckBox.setMnemonic('V');

      addFileFormCheckBox();
    }
    return fileFormCheckBox;

  }

  /**
   * ����̈���擾���܂��B
   * @return ����̈�
   */
  public ACPanel getOperation(){
    if(operation==null){

      operation = new ACPanel();

      operation.setHgap(0);

      operation.setLabelMargin(0);

      addOperation();
    }
    return operation;

  }

  /**
   * �}�̋敪�̈���擾���܂��B
   * @return �}�̋敪�̈�
   */
  public ACPanel getMediumDivisions(){
    if(mediumDivisions==null){

      mediumDivisions = new ACPanel();

      mediumDivisions.setHgap(0);

      mediumDivisions.setLabelMargin(0);

      addMediumDivisions();
    }
    return mediumDivisions;

  }

  /**
   * �}�̋敪�̈�E���W�I�O���[�v���擾���܂��B
   * @return �}�̋敪�̈�E���W�I�O���[�v
   */
  public ACClearableRadioButtonGroup getMediumDivisionRadio(){
    if(mediumDivisionRadio==null){

      mediumDivisionRadio = new ACClearableRadioButtonGroup();

      getMediumDivisionRadioContainer().setText("�}�̋敪");

      mediumDivisionRadio.setBindPath("MEDIUM_DIVISION");

      mediumDivisionRadio.setUseClearButton(false);

      mediumDivisionRadio.setModel(getMediumDivisionRadioModel());

      addMediumDivisionRadio();
    }
    return mediumDivisionRadio;

  }

  /**
   * �}�̋敪�̈�E���W�I�O���[�v�R���e�i���擾���܂��B
   * @return �}�̋敪�̈�E���W�I�O���[�v�R���e�i
   */
  protected ACLabelContainer getMediumDivisionRadioContainer(){
    if(mediumDivisionRadioContainer==null){
      mediumDivisionRadioContainer = new ACLabelContainer();
      mediumDivisionRadioContainer.setFollowChildEnabled(true);
      mediumDivisionRadioContainer.setVAlignment(VRLayout.CENTER);
      mediumDivisionRadioContainer.add(getMediumDivisionRadio(), null);
    }
    return mediumDivisionRadioContainer;
  }

  /**
   * �}�̋敪�̈�E���W�I�O���[�v���f�����擾���܂��B
   * @return �}�̋敪�̈�E���W�I�O���[�v���f��
   */
  protected ACListModelAdapter getMediumDivisionRadioModel(){
    if(mediumDivisionRadioModel==null){
      mediumDivisionRadioModel = new ACListModelAdapter();
      addMediumDivisionRadioModel();
    }
    return mediumDivisionRadioModel;
  }

  /**
   * FD/CD-R���擾���܂��B
   * @return FD/CD-R
   */
  public ACRadioButtonItem getMediumDivisionRadioItem1(){
    if(mediumDivisionRadioItem1==null){

      mediumDivisionRadioItem1 = new ACRadioButtonItem();

      mediumDivisionRadioItem1.setText("FD/CD-R");

      mediumDivisionRadioItem1.setGroup(getMediumDivisionRadio());

      mediumDivisionRadioItem1.setConstraints(VRLayout.FLOW);

      addMediumDivisionRadioItem1();
    }
    return mediumDivisionRadioItem1;

  }

  /**
   * MO���擾���܂��B
   * @return MO
   */
  public ACRadioButtonItem getMediumDivisionRadioItem2(){
    if(mediumDivisionRadioItem2==null){

      mediumDivisionRadioItem2 = new ACRadioButtonItem();

      mediumDivisionRadioItem2.setText("MO");

      mediumDivisionRadioItem2.setGroup(getMediumDivisionRadio());

      mediumDivisionRadioItem2.setConstraints(VRLayout.FLOW);

      addMediumDivisionRadioItem2();
    }
    return mediumDivisionRadioItem2;

  }

  /**
   * �`���\�t�g��n���p�i�h�r�c�m�j���擾���܂��B
   * @return �`���\�t�g��n���p�i�h�r�c�m�j
   */
  public ACRadioButtonItem getMediumDivisionRadioItem3(){
    if(mediumDivisionRadioItem3==null){

      mediumDivisionRadioItem3 = new ACRadioButtonItem();

      mediumDivisionRadioItem3.setText("�`���\�t�g��n���p�i�h�r�c�m�j");

      mediumDivisionRadioItem3.setGroup(getMediumDivisionRadio());

      mediumDivisionRadioItem3.setConstraints(VRLayout.FLOW);

      addMediumDivisionRadioItem3();
    }
    return mediumDivisionRadioItem3;

  }

  /**
   * �`���\�t�g��n���p�i�C���^�[�l�b�g�j���擾���܂��B
   * @return �`���\�t�g��n���p�i�C���^�[�l�b�g�j
   */
  public ACRadioButtonItem getMediumDivisionRadioItem4(){
    if(mediumDivisionRadioItem4==null){

      mediumDivisionRadioItem4 = new ACRadioButtonItem();

      mediumDivisionRadioItem4.setText("�`���\�t�g��n���p�i�C���^�[�l�b�g�j");

      mediumDivisionRadioItem4.setGroup(getMediumDivisionRadio());

      mediumDivisionRadioItem4.setConstraints(VRLayout.FLOW);

      addMediumDivisionRadioItem4();
    }
    return mediumDivisionRadioItem4;

  }

  /**
   * �{�^���̈���擾���܂��B
   * @return �{�^���̈�
   */
  public ACPanel getButtons(){
    if(buttons==null){

      buttons = new ACPanel();

      buttons.setAutoWrap(false);

      buttons.setHgap(1);

      buttons.setLabelMargin(0);

      addButtons();
    }
    return buttons;

  }

  /**
   * �����̈���擾���܂��B
   * @return �����̈�
   */
  public ACPanel getButtonsDetail(){
    if(buttonsDetail==null){

      buttonsDetail = new ACPanel();

      buttonsDetail.setAutoWrap(false);

      buttonsDetail.setHgap(1);

      buttonsDetail.setLabelMargin(0);

      addButtonsDetail();
    }
    return buttonsDetail;

  }

  /**
   * OK�{�^�����擾���܂��B
   * @return OK�{�^��
   */
  public ACButton getOk(){
    if(ok==null){

      ok = new ACButton();

      ok.setText("OK");

      ok.setMnemonic('O');

      addOk();
    }
    return ok;

  }

  /**
   * �߂���擾���܂��B
   * @return �߂�
   */
  public ACButton getGoBack(){
    if(goBack==null){

      goBack = new ACButton();

      goBack.setText("�߂�(R)");

      goBack.setMnemonic('R');

      addGoBack();
    }
    return goBack;

  }

  /**
   * ���~�{�^�����擾���܂��B
   * @return ���~�{�^��
   */
  public ACButton getCancel(){
    if(cancel==null){

      cancel = new ACButton();

      cancel.setText("���~(C)");

      cancel.setMnemonic('C');

      addCancel();
    }
    return cancel;

  }

  /**
   * �R���X�g���N�^�ł��B
   */
  public QP008Design() {

    super(ACFrame.getInstance(), true);
    this.getContentPane().setLayout(new VRLayout());
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    try {
      initialize();

      setSize(600, 200);

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

    contents.add(getErrorPanel(), VRLayout.NORTH);

    contents.add(getFileSelects(), VRLayout.NORTH);

    contents.add(getOperation(), VRLayout.SOUTH);
  }

  /**
   * �G���[�\���̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addErrorPanel(){

    errorPanel.add(getErrorSpacer1(), VRLayout.NORTH);

    errorPanel.add(getComment(), VRLayout.NORTH);

    errorPanel.add(getErrorSpacer2(), VRLayout.NORTH);

  }

  /**
   * �X�y�[�T�[�ɓ������ڂ�ǉ����܂��B
   */
  protected void addErrorSpacer1(){

  }

  /**
   * �������ɓ������ڂ�ǉ����܂��B
   */
  protected void addComment(){

  }

  /**
   * �X�y�[�T�[�ɓ������ڂ�ǉ����܂��B
   */
  protected void addErrorSpacer2(){

  }

  /**
   * �t�H���_�I��̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addFileSelects(){

    fileSelects.add(getFileSelectLabel(), VRLayout.FLOW_RETURN);

    fileSelects.add(getSaveButtons(), VRLayout.FLOW_RETURN);

  }

  /**
   * �t�H���_�I��̈�E���C�A�E�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addFileSelectLayout(){

  }

  /**
   * �t�H���_�I���R�����g�E���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addFileSelectLabel(){

  }

  /**
   * �ۑ��挈��E�p�l���ɓ������ڂ�ǉ����܂��B
   */
  protected void addSaveButtons(){

    saveButtons.add(getSaveStandardButton(), VRLayout.FLOW);

    saveButtons.add(getSaveOptionButton(), VRLayout.FLOW_RETURN);

    saveButtons.add(getFilePath(), VRLayout.FLOW);

    saveButtons.add(getFileFormCheckBox(), VRLayout.FLOW);

  }

  /**
   * �ۑ��挈��E���C�A�E�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addSaveButtonLayout(){

  }

  /**
   * �ۑ��挈��(�)�{�^���ɓ������ڂ�ǉ����܂��B
   */
  protected void addSaveStandardButton(){

  }

  /**
   * �ۑ��挈��(�C��)�{�^���ɓ������ڂ�ǉ����܂��B
   */
  protected void addSaveOptionButton(){

  }

  /**
   * �t�@�C���p�X�E�e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addFilePath(){

  }

  /**
   * �ۑ��`���E�`�F�b�N�{�b�N�X�ɓ������ڂ�ǉ����܂��B
   */
  protected void addFileFormCheckBox(){

  }

  /**
   * ����̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addOperation(){

    operation.add(getMediumDivisions(), VRLayout.FLOW);

    operation.add(getButtons(), VRLayout.FLOW);

  }

  /**
   * �}�̋敪�̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMediumDivisions(){

    mediumDivisions.add(getMediumDivisionRadioContainer(), VRLayout.FLOW);

  }

  /**
   * �}�̋敪�̈�E���W�I�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMediumDivisionRadio(){

  }

  /**
   * �}�̋敪�̈�E���W�I�O���[�v���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addMediumDivisionRadioModel(){

    getMediumDivisionRadioItem1().setButtonIndex(1);

    getMediumDivisionRadioModel().add(getMediumDivisionRadioItem1());

    getMediumDivisionRadioItem2().setButtonIndex(2);

    getMediumDivisionRadioModel().add(getMediumDivisionRadioItem2());

    getMediumDivisionRadioItem3().setButtonIndex(3);

    getMediumDivisionRadioModel().add(getMediumDivisionRadioItem3());

    getMediumDivisionRadioItem4().setButtonIndex(4);

    getMediumDivisionRadioModel().add(getMediumDivisionRadioItem4());

  }

  /**
   * FD/CD-R�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMediumDivisionRadioItem1(){

  }

  /**
   * MO�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMediumDivisionRadioItem2(){

  }

  /**
   * �`���\�t�g��n���p�i�h�r�c�m�j�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMediumDivisionRadioItem3(){

  }

  /**
   * �`���\�t�g��n���p�i�C���^�[�l�b�g�j�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMediumDivisionRadioItem4(){

  }

  /**
   * �{�^���̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addButtons(){

    buttons.add(getButtonsDetail(), VRLayout.FLOW);

  }

  /**
   * �����̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addButtonsDetail(){

    buttonsDetail.add(getOk(), VRLayout.FLOW);

    buttonsDetail.add(getGoBack(), VRLayout.FLOW);

    buttonsDetail.add(getCancel(), VRLayout.FLOW);

  }

  /**
   * OK�{�^���ɓ������ڂ�ǉ����܂��B
   */
  protected void addOk(){

  }

  /**
   * �߂�ɓ������ڂ�ǉ����܂��B
   */
  protected void addGoBack(){

  }

  /**
   * ���~�{�^���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCancel(){

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
      new QP008Design().setVisible(true);
      System.exit(0);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QP008Design getThis() {
    return this;
  }
}
