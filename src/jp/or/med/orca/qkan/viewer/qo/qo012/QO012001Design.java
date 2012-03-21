
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
 * �J����: �A�� ��C
 * �쐬��: 2006/04/17  ���{�R���s���[�^�[������� �A�� ��C �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� CSV�r���[�A (O)
 * �v���Z�X CSV�r���[�A (012)
 * �v���O���� CSV������� (QO012001)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.viewer.qo.qo012;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;

import jp.nichicom.ac.ACCommon;
import jp.nichicom.ac.ACConstants;
import jp.nichicom.ac.component.ACButton;
import jp.nichicom.ac.component.ACLabel;
import jp.nichicom.ac.component.ACTextField;
import jp.nichicom.ac.container.ACGroupBox;
import jp.nichicom.ac.container.ACLabelContainer;
import jp.nichicom.ac.container.ACPanel;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.vr.layout.VRLayout;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.affair.QkanAffairDialog;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
/**
 * CSV������ʉ�ʍ��ڃf�U�C��(QO012001) 
 */
public class QO012001Design extends QkanAffairDialog {
  //GUI�R���|�[�l���g

  private ACPanel contents;

  private ACPanel fileInfoPanel;

  private ACLabel helpText;

  private ACGroupBox csvFile1Group;

  private ACLabelContainer file1Container;

  private ACTextField file1Text;

  private ACButton file1Button;

  private ACLabelContainer file1InfoContainer;

  private ACTextField file1InfoText;

  private ACGroupBox csvFile2Group;

  private ACLabelContainer file2Container;

  private ACTextField file2Text;

  private ACButton file2Button;

  private ACLabelContainer file2InfoContainer;

  private ACTextField file2InfoText;

  private ACGroupBox csvFile3Group;

  private ACLabelContainer file3Container;

  private ACTextField file3Text;

  private ACButton file3Button;

  private ACLabelContainer file4Container;

  private ACTextField file4Text;

  private ACPanel buttonPanel;

  private ACButton unitButton;

  private ACButton closeButton;

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
   * ���ʗ̈���擾���܂��B
   * @return ���ʗ̈�
   */
  public ACPanel getFileInfoPanel(){
    if(fileInfoPanel==null){

      fileInfoPanel = new ACPanel();

      fileInfoPanel.setAutoWrap(false);

      addFileInfoPanel();
    }
    return fileInfoPanel;

  }

  /**
   * �����e�L�X�g���擾���܂��B
   * @return �����e�L�X�g
   */
  public ACLabel getHelpText(){
    if(helpText==null){

      helpText = new ACLabel();

      helpText.setText("�������t�@�C���P�ƌ������t�@�C���Q�����ꂼ��I�����āA�o�͐���m�F������u�t�@�C�������v�{�^���������Ă��������B�L�����Z���̏ꍇ�͕���{�^���������Ă��������B");

      helpText.setIconPath(ACConstants.ICON_PATH_INFORMATION_16);

      helpText.setAutoWrap(true);

      addHelpText();
    }
    return helpText;

  }

  /**
   * CSV�t�@�C��1�O���[�v���擾���܂��B
   * @return CSV�t�@�C��1�O���[�v
   */
  public ACGroupBox getCsvFile1Group(){
    if(csvFile1Group==null){

      csvFile1Group = new ACGroupBox();

      csvFile1Group.setText("������CSV�t�@�C��1");

      csvFile1Group.setAutoWrap(true);

      addCsvFile1Group();
    }
    return csvFile1Group;

  }

  /**
   * �t�@�C��1�R���e�i���擾���܂��B
   * @return �t�@�C��1�R���e�i
   */
  public ACLabelContainer getFile1Container(){
    if(file1Container==null){

      file1Container = new ACLabelContainer();

      file1Container.setText("�t�@�C��");

      file1Container.setAutoWrap(false);

      file1Container.setFollowChildEnabled(true);

      file1Container.setLabelMargin(0);

      addFile1Container();
    }
    return file1Container;

  }

  /**
   * �t�@�C��1�e�L�X�g���擾���܂��B
   * @return �t�@�C��1�e�L�X�g
   */
  public ACTextField getFile1Text(){
    if(file1Text==null){

      file1Text = new ACTextField();

      file1Text.setEditable(false);

      file1Text.setColumns(30);

      addFile1Text();
    }
    return file1Text;

  }

  /**
   * �t�@�C��1�{�^�����擾���܂��B
   * @return �t�@�C��1�{�^��
   */
  public ACButton getFile1Button(){
    if(file1Button==null){

      file1Button = new ACButton();

      file1Button.setText("�Q��");

      addFile1Button();
    }
    return file1Button;

  }

  /**
   * �t�@�C��1���R���e�i���擾���܂��B
   * @return �t�@�C��1���R���e�i
   */
  public ACLabelContainer getFile1InfoContainer(){
    if(file1InfoContainer==null){

      file1InfoContainer = new ACLabelContainer();

      file1InfoContainer.setText("�t�@�C�����");

      addFile1InfoContainer();
    }
    return file1InfoContainer;

  }

  /**
   * �t�@�C��1���e�L�X�g���擾���܂��B
   * @return �t�@�C��1���e�L�X�g
   */
  public ACTextField getFile1InfoText(){
    if(file1InfoText==null){

      file1InfoText = new ACTextField();

      file1InfoText.setEditable(false);

      file1InfoText.setColumns(30);

      addFile1InfoText();
    }
    return file1InfoText;

  }

  /**
   * CSV�t�@�C��2�O���[�v���擾���܂��B
   * @return CSV�t�@�C��2�O���[�v
   */
  public ACGroupBox getCsvFile2Group(){
    if(csvFile2Group==null){

      csvFile2Group = new ACGroupBox();

      csvFile2Group.setText("������CSV�t�@�C��2");

      csvFile2Group.setAutoWrap(true);

      addCsvFile2Group();
    }
    return csvFile2Group;

  }

  /**
   * �t�@�C��2�R���e�i���擾���܂��B
   * @return �t�@�C��2�R���e�i
   */
  public ACLabelContainer getFile2Container(){
    if(file2Container==null){

      file2Container = new ACLabelContainer();

      file2Container.setText("�t�@�C��");

      file2Container.setAutoWrap(false);

      file2Container.setFollowChildEnabled(true);

      file2Container.setLabelMargin(0);

      addFile2Container();
    }
    return file2Container;

  }

  /**
   * �t�@�C��2�e�L�X�g���擾���܂��B
   * @return �t�@�C��2�e�L�X�g
   */
  public ACTextField getFile2Text(){
    if(file2Text==null){

      file2Text = new ACTextField();

      file2Text.setEditable(false);

      file2Text.setColumns(30);

      addFile2Text();
    }
    return file2Text;

  }

  /**
   * �t�@�C��2�{�^�����擾���܂��B
   * @return �t�@�C��2�{�^��
   */
  public ACButton getFile2Button(){
    if(file2Button==null){

      file2Button = new ACButton();

      file2Button.setText("�Q��");

      addFile2Button();
    }
    return file2Button;

  }

  /**
   * �t�@�C��2���R���e�i���擾���܂��B
   * @return �t�@�C��2���R���e�i
   */
  public ACLabelContainer getFile2InfoContainer(){
    if(file2InfoContainer==null){

      file2InfoContainer = new ACLabelContainer();

      file2InfoContainer.setText("�t�@�C�����");

      addFile2InfoContainer();
    }
    return file2InfoContainer;

  }

  /**
   * �t�@�C��2���e�L�X�g���擾���܂��B
   * @return �t�@�C��2���e�L�X�g
   */
  public ACTextField getFile2InfoText(){
    if(file2InfoText==null){

      file2InfoText = new ACTextField();

      file2InfoText.setEditable(false);

      file2InfoText.setColumns(30);

      addFile2InfoText();
    }
    return file2InfoText;

  }

  /**
   * CSV�t�@�C��3�O���[�v���擾���܂��B
   * @return CSV�t�@�C��3�O���[�v
   */
  public ACGroupBox getCsvFile3Group(){
    if(csvFile3Group==null){

      csvFile3Group = new ACGroupBox();

      csvFile3Group.setText("�o�͐�CSV�t�@�C��");

      csvFile3Group.setAutoWrap(true);

      addCsvFile3Group();
    }
    return csvFile3Group;

  }

  /**
   * �t�@�C��3�R���e�i���擾���܂��B
   * @return �t�@�C��3�R���e�i
   */
  public ACLabelContainer getFile3Container(){
    if(file3Container==null){

      file3Container = new ACLabelContainer();

      file3Container.setText("�t�H���_");

      file3Container.setAutoWrap(false);

      file3Container.setFollowChildEnabled(true);

      file3Container.setLabelMargin(0);

      addFile3Container();
    }
    return file3Container;

  }

  /**
   * �t�@�C��3�e�L�X�g���擾���܂��B
   * @return �t�@�C��3�e�L�X�g
   */
  public ACTextField getFile3Text(){
    if(file3Text==null){

      file3Text = new ACTextField();

      file3Text.setEditable(false);

      file3Text.setColumns(30);

      addFile3Text();
    }
    return file3Text;

  }

  /**
   * �t�@�C��3�{�^�����擾���܂��B
   * @return �t�@�C��3�{�^��
   */
  public ACButton getFile3Button(){
    if(file3Button==null){

      file3Button = new ACButton();

      file3Button.setText("�Q��");

      addFile3Button();
    }
    return file3Button;

  }

  /**
   * �t�@�C��4�R���e�i���擾���܂��B
   * @return �t�@�C��4�R���e�i
   */
  public ACLabelContainer getFile4Container(){
    if(file4Container==null){

      file4Container = new ACLabelContainer();

      file4Container.setText("�t�@�C��");

      addFile4Container();
    }
    return file4Container;

  }

  /**
   * �t�@�C��4�e�L�X�g���擾���܂��B
   * @return �t�@�C��4�e�L�X�g
   */
  public ACTextField getFile4Text(){
    if(file4Text==null){

      file4Text = new ACTextField();

      file4Text.setEditable(false);

      file4Text.setColumns(30);

      addFile4Text();
    }
    return file4Text;

  }

  /**
   * �{�^���̈���擾���܂��B
   * @return �{�^���̈�
   */
  public ACPanel getButtonPanel(){
    if(buttonPanel==null){

      buttonPanel = new ACPanel();

      addButtonPanel();
    }
    return buttonPanel;

  }

  /**
   * �������s�{�^�����擾���܂��B
   * @return �������s�{�^��
   */
  public ACButton getUnitButton(){
    if(unitButton==null){

      unitButton = new ACButton();

      unitButton.setText("�t�@�C������(E)");

      unitButton.setMnemonic('E');

      addUnitButton();
    }
    return unitButton;

  }

  /**
   * �I���{�^�����擾���܂��B
   * @return �I���{�^��
   */
  public ACButton getCloseButton(){
    if(closeButton==null){

      closeButton = new ACButton();

      closeButton.setText("����(C)");

      closeButton.setMnemonic('C');

      addCloseButton();
    }
    return closeButton;

  }

  /**
   * �R���X�g���N�^�ł��B
   */
  public QO012001Design() {

    super(ACFrame.getInstance(), true);
    this.getContentPane().setLayout(new VRLayout());
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    try {
      initialize();

      setSize(600, 350);

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

    contents.add(getFileInfoPanel(), VRLayout.CLIENT);

    contents.add(getButtonPanel(), VRLayout.SOUTH);
  }

  /**
   * ���ʗ̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addFileInfoPanel(){

    fileInfoPanel.add(getHelpText(), VRLayout.NORTH);

    fileInfoPanel.add(getCsvFile1Group(), VRLayout.NORTH);

    fileInfoPanel.add(getCsvFile2Group(), VRLayout.NORTH);

    fileInfoPanel.add(getCsvFile3Group(), VRLayout.NORTH);

  }

  /**
   * �����e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHelpText(){

  }

  /**
   * CSV�t�@�C��1�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addCsvFile1Group(){

    csvFile1Group.add(getFile1Container(), VRLayout.FLOW_INSETLINE_RETURN);

    csvFile1Group.add(getFile1InfoContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * �t�@�C��1�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addFile1Container(){

    file1Container.add(getFile1Text(), null);

    file1Container.add(getFile1Button(), null);

  }

  /**
   * �t�@�C��1�e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addFile1Text(){

  }

  /**
   * �t�@�C��1�{�^���ɓ������ڂ�ǉ����܂��B
   */
  protected void addFile1Button(){

  }

  /**
   * �t�@�C��1���R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addFile1InfoContainer(){

    file1InfoContainer.add(getFile1InfoText(), null);

  }

  /**
   * �t�@�C��1���e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addFile1InfoText(){

  }

  /**
   * CSV�t�@�C��2�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addCsvFile2Group(){

    csvFile2Group.add(getFile2Container(), VRLayout.FLOW_INSETLINE_RETURN);

    csvFile2Group.add(getFile2InfoContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * �t�@�C��2�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addFile2Container(){

    file2Container.add(getFile2Text(), null);

    file2Container.add(getFile2Button(), null);

  }

  /**
   * �t�@�C��2�e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addFile2Text(){

  }

  /**
   * �t�@�C��2�{�^���ɓ������ڂ�ǉ����܂��B
   */
  protected void addFile2Button(){

  }

  /**
   * �t�@�C��2���R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addFile2InfoContainer(){

    file2InfoContainer.add(getFile2InfoText(), null);

  }

  /**
   * �t�@�C��2���e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addFile2InfoText(){

  }

  /**
   * CSV�t�@�C��3�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addCsvFile3Group(){

    csvFile3Group.add(getFile3Container(), VRLayout.FLOW_INSETLINE_RETURN);

    csvFile3Group.add(getFile4Container(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * �t�@�C��3�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addFile3Container(){

    file3Container.add(getFile3Text(), null);

    file3Container.add(getFile3Button(), null);

  }

  /**
   * �t�@�C��3�e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addFile3Text(){

  }

  /**
   * �t�@�C��3�{�^���ɓ������ڂ�ǉ����܂��B
   */
  protected void addFile3Button(){

  }

  /**
   * �t�@�C��4�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addFile4Container(){

    file4Container.add(getFile4Text(), null);

  }

  /**
   * �t�@�C��4�e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addFile4Text(){

  }

  /**
   * �{�^���̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addButtonPanel(){

    buttonPanel.add(getCloseButton(), VRLayout.EAST);
    buttonPanel.add(getUnitButton(), VRLayout.EAST);
  }

  /**
   * �������s�{�^���ɓ������ڂ�ǉ����܂��B
   */
  protected void addUnitButton(){

  }

  /**
   * �I���{�^���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCloseButton(){

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

    return getFile1Text();

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
      new QO012001Design().setVisible(true);
      System.exit(0);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QO012001Design getThis() {
    return this;
  }
}
