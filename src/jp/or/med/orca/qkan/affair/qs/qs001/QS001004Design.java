
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
 * �쐬��: 2006/06/05  ���{�R���s���[�^�[������� �c���@���� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �\��Ǘ� (S)
 * �v���Z�X �T�[�r�X�\�� (001)
 * �v���O���� �v��P�ʐ��ҏW��� (QS001032)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;

import javax.swing.SwingConstants;
import javax.swing.table.TableColumn;

import jp.nichicom.ac.ACCommon;
import jp.nichicom.ac.ACConstants;
import jp.nichicom.ac.component.ACButton;
import jp.nichicom.ac.component.ACComboBox;
import jp.nichicom.ac.component.ACLabel;
import jp.nichicom.ac.component.table.ACTable;
import jp.nichicom.ac.component.table.ACTableCellViewer;
import jp.nichicom.ac.component.table.ACTableColumn;
import jp.nichicom.ac.container.ACLabelContainer;
import jp.nichicom.ac.container.ACPanel;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.util.adapter.ACComboBoxModelAdapter;
import jp.nichicom.vr.component.table.VRTableCellViewer;
import jp.nichicom.vr.component.table.VRTableColumnModel;
import jp.nichicom.vr.layout.VRLayout;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.affair.QkanAffairDialog;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.text.QkanServiceKindNameFormat;
import jp.or.med.orca.qkan.text.QkanZeroToBlankIntegerFormat;
/**
 * �v��P�ʐ��ҏW��ʉ�ʍ��ڃf�U�C��(QS001032) 
 */
@SuppressWarnings("serial")
public class QS001004Design extends QkanAffairDialog {
  //GUI�R���|�[�l���g

  private ACPanel contents;

  private ACLabel information1;

  private ACLabel information2;

  private ACComboBox provider;

  private ACLabelContainer providerContainer;

  private ACComboBoxModelAdapter providerModel;

  private ACTable planUnitTable;

  private VRTableColumnModel planUnitTableColumnModel;

  private ACTableColumn planUnitTableNo;

  private ACTableColumn planUnitTableServiceName;

  private ACTableColumn planUnitTableUnit;

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
   * �v��P�ʐ����1���擾���܂��B
   * @return �v��P�ʐ����1
   */
  public ACLabel getInformation1(){
    if(information1==null){

      information1 = new ACLabel();

      information1.setText("���тƌv��P�ʐ����قȂ�ꍇ�A�v��P�ʐ������̉�ʂœ��͂��Ă��������B");

      information1.setForeground(Color.red);

      information1.setAutoWrap(true);

      addInformation1();
    }
    return information1;

  }

  /**
   * �v��P�ʐ����2���擾���܂��B
   * @return �v��P�ʐ����2
   */
  public ACLabel getInformation2(){
    if(information2==null){

      information2 = new ACLabel();

      information2.setText("�v��P�ʐ��������͂̏ꍇ�͗\��̏����A�\�肪���݂��Ȃ��ꍇ�͎��т̏������ƂɌv��P�ʐ����v�Z���܂��B");

      information2.setAutoWrap(true);

      addInformation2();
    }
    return information2;

  }

  /**
   * �Ώێ��Ə����擾���܂��B
   * @return �Ώێ��Ə�
   */
  public ACComboBox getProvider(){
    if(provider==null){

      provider = new ACComboBox();

      getProviderContainer().setText("���Ə�");

      provider.setBindPath("PROVIDER_ID");

      provider.setEditable(false);

      provider.setRenderBindPath("SHOW_PROVIDER_NAME");

      provider.setModel(getProviderModel());

      addProvider();
    }
    return provider;

  }

  /**
   * �Ώێ��Ə��R���e�i���擾���܂��B
   * @return �Ώێ��Ə��R���e�i
   */
  protected ACLabelContainer getProviderContainer(){
    if(providerContainer==null){
      providerContainer = new ACLabelContainer();
      providerContainer.setFollowChildEnabled(true);
      providerContainer.setVAlignment(VRLayout.CENTER);
      providerContainer.add(getProvider(), VRLayout.CLIENT);
    }
    return providerContainer;
  }

  /**
   * �Ώێ��Ə����f�����擾���܂��B
   * @return �Ώێ��Ə����f��
   */
  protected ACComboBoxModelAdapter getProviderModel(){
    if(providerModel==null){
      providerModel = new ACComboBoxModelAdapter();
      addProviderModel();
    }
    return providerModel;
  }

  /**
   * �v��P�ʐ��e�[�u�����擾���܂��B
   * @return �v��P�ʐ��e�[�u��
   */
  public ACTable getPlanUnitTable(){
    if(planUnitTable==null){

      planUnitTable = new ACTable();

      planUnitTable.setColumnModel(getPlanUnitTableColumnModel());

      addPlanUnitTable();
    }
    return planUnitTable;

  }

  /**
   * �v��P�ʐ��e�[�u���J�������f�����擾���܂��B
   * @return �v��P�ʐ��e�[�u���J�������f��
   */
  protected VRTableColumnModel getPlanUnitTableColumnModel(){
    if(planUnitTableColumnModel==null){
      planUnitTableColumnModel = new VRTableColumnModel(new TableColumn[]{});
      addPlanUnitTableColumnModel();
    }
    return planUnitTableColumnModel;
  }

  /**
   * No.���擾���܂��B
   * @return No.
   */
  public ACTableColumn getPlanUnitTableNo(){
    if(planUnitTableNo==null){

      planUnitTableNo = new ACTableColumn();

      planUnitTableNo.setHeaderValue("No.");

      planUnitTableNo.setColumnName("SERVICE_KIND_NAME");

      planUnitTableNo.setColumns(2);

      planUnitTableNo.setRendererType(ACTableCellViewer.RENDERER_TYPE_SERIAL_NO);

      planUnitTableNo.setSortable(false);

      addPlanUnitTableNo();
    }
    return planUnitTableNo;

  }

  /**
   * �T�[�r�X��ނ��擾���܂��B
   * @return �T�[�r�X���
   */
  public ACTableColumn getPlanUnitTableServiceName(){
    if(planUnitTableServiceName==null){

      planUnitTableServiceName = new ACTableColumn();

      planUnitTableServiceName.setHeaderValue("�T�[�r�X���");

      planUnitTableServiceName.setColumnName("SERVICE_KIND_NAME");

      planUnitTableServiceName.setColumns(24);

      planUnitTableServiceName.setFormat(QkanServiceKindNameFormat.getInstance());

      addPlanUnitTableServiceName();
    }
    return planUnitTableServiceName;

  }

  /**
   * �v��P�ʐ����擾���܂��B
   * @return �v��P�ʐ�
   */
  public ACTableColumn getPlanUnitTableUnit(){
    if(planUnitTableUnit==null){

      planUnitTableUnit = new ACTableColumn();

      planUnitTableUnit.setHeaderValue("�v��P�ʐ�");

      planUnitTableUnit.setColumnName("UNIT");

      planUnitTableUnit.setEditable(true);

      planUnitTableUnit.setColumns(6);

      planUnitTableUnit.setHorizontalAlignment(SwingConstants.RIGHT);

      planUnitTableUnit.setFormat(new QkanZeroToBlankIntegerFormat());

      planUnitTableUnit.setEditorType(VRTableCellViewer.EDITOR_TYPE_TEXT_FIELD);

      addPlanUnitTableUnit();
    }
    return planUnitTableUnit;

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

      ok.setToolTipText("���͂��ꂽ���Ōv��P�ʐ����X�V���܂��B");

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

      close.setToolTipText("�v��P�ʐ��̍X�V�͍s�킸�A�O�̉�ʂɖ߂�܂��B");

      close.setMnemonic('C');

      close.setIconPath(ACConstants.ICON_PATH_CANCEL_16);

      addClose();
    }
    return close;

  }

  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001004Design() {

    super(ACFrame.getInstance(), true);
    this.getContentPane().setLayout(new VRLayout());
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    try {
      initialize();

      setSize(450, 420);

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

    contents.add(getInformation1(), VRLayout.NORTH);

    contents.add(getInformation2(), VRLayout.NORTH);

    contents.add(getProviderContainer(), VRLayout.NORTH);

    contents.add(getPlanUnitTable(), VRLayout.CLIENT);

  }

  /**
   * �v��P�ʐ����1�ɓ������ڂ�ǉ����܂��B
   */
  protected void addInformation1(){

  }

  /**
   * �v��P�ʐ����2�ɓ������ڂ�ǉ����܂��B
   */
  protected void addInformation2(){

  }

  /**
   * �Ώێ��Ə��ɓ������ڂ�ǉ����܂��B
   */
  protected void addProvider(){

  }

  /**
   * �Ώێ��Ə����f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderModel(){

  }

  /**
   * �v��P�ʐ��e�[�u���ɓ������ڂ�ǉ����܂��B
   */
  protected void addPlanUnitTable(){

  }

  /**
   * �v��P�ʐ��e�[�u���J�������f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addPlanUnitTableColumnModel(){

    getPlanUnitTableColumnModel().addColumn(getPlanUnitTableNo());

    getPlanUnitTableColumnModel().addColumn(getPlanUnitTableServiceName());

    getPlanUnitTableColumnModel().addColumn(getPlanUnitTableUnit());

  }

  /**
   * No.�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPlanUnitTableNo(){

  }

  /**
   * �T�[�r�X��ނɓ������ڂ�ǉ����܂��B
   */
  protected void addPlanUnitTableServiceName(){

  }

  /**
   * �v��P�ʐ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addPlanUnitTableUnit(){

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
      new QS001004Design().setVisible(true);
      System.exit(0);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QS001004Design getThis() {
    return this;
  }
}
