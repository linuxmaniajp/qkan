
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
 * �쐬��: 2012/08/08  ���{�R���s���[�^�[������� ����@��F �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �T�[�r�X�Ǘ� (S)
 * �v���Z�X ����f�Ô�E���ʗ×{��W�v (001)
 * �v���O���� ����f�Ô�E���ʗ×{��W�v��� (QS001008)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;

import javax.swing.SwingConstants;
import javax.swing.table.TableColumn;

import jp.nichicom.ac.ACCommon;
import jp.nichicom.ac.component.ACButton;
import jp.nichicom.ac.component.ACComboBox;
import jp.nichicom.ac.component.table.ACTable;
import jp.nichicom.ac.component.table.ACTableCellViewer;
import jp.nichicom.ac.component.table.ACTableColumn;
import jp.nichicom.ac.container.ACGroupBox;
import jp.nichicom.ac.container.ACLabelContainer;
import jp.nichicom.ac.container.ACPanel;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.text.ACBorderBlankDateFormat;
import jp.nichicom.ac.util.adapter.ACComboBoxModelAdapter;
import jp.nichicom.vr.component.table.VRTableColumnModel;
import jp.nichicom.vr.layout.VRLayout;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.affair.QkanAffairDialog;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
/**
 * ����f�Ô�E���ʗ×{��W�v��ʉ�ʍ��ڃf�U�C��(QS001008) 
 */
public class QS001008Design extends QkanAffairDialog {
  //GUI�R���|�[�l���g

  private ACPanel contents;

  private ACGroupBox tokubetsuGroup;

  private VRLayout tokubetsuGroupLayout;

  private ACPanel servicePanel;

  private VRLayout servicePanelLayout;

  private ACComboBox providerCombo;

  private ACLabelContainer providerComboContainer;

  private ACComboBoxModelAdapter providerComboModel;

  private ACComboBox serviceCombo;

  private ACLabelContainer serviceComboContainer;

  private ACComboBoxModelAdapter serviceComboModel;

  private ACTable tokubetsuTable;

  private VRTableColumnModel tokubetsuTableColumnModel;

  private ACTableColumn tokubetsuTableColumn1;

  private ACTableColumn tokubetsuTableColumn2;

  private ACTableColumn tokubetsuTableColumn3;

  private ACGroupBox dayDetailGroup;

  private ACTable dayDetailTable;

  private VRTableColumnModel dayDetailTableColumnModel;

  private ACTableColumn dayDetailTableColumn1;

  private ACTableColumn dayDetailTableColumn2;

  private ACPanel buttons;

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
   * ����f�Ô�E���ʗ×{��O���[�v���擾���܂��B
   * @return ����f�Ô�E���ʗ×{��O���[�v
   */
  public ACGroupBox getTokubetsuGroup(){
    if(tokubetsuGroup==null){

      tokubetsuGroup = new ACGroupBox();

      tokubetsuGroup.setText("����f�Ô�E���ʗ×{��");

      tokubetsuGroup.setLayout(getTokubetsuGroupLayout());

      tokubetsuGroup.setFollowChildEnabled(true);

      addTokubetsuGroup();
    }
    return tokubetsuGroup;

  }

  /**
   * �O���[�v���C�A�E�g���擾���܂��B
   * @return �O���[�v���C�A�E�g
   */
  public VRLayout getTokubetsuGroupLayout(){
    if(tokubetsuGroupLayout==null){

      tokubetsuGroupLayout = new VRLayout();

      tokubetsuGroupLayout.setHgap(2);

      tokubetsuGroupLayout.setLabelMargin(0);

      tokubetsuGroupLayout.setVgap(0);

      addTokubetsuGroupLayout();
    }
    return tokubetsuGroupLayout;

  }

  /**
   * �T�[�r�X��ޗ̈���擾���܂��B
   * @return �T�[�r�X��ޗ̈�
   */
  public ACPanel getServicePanel(){
    if(servicePanel==null){

      servicePanel = new ACPanel();

      servicePanel.setLayout(getServicePanelLayout());

      servicePanel.setFollowChildEnabled(true);

      addServicePanel();
    }
    return servicePanel;

  }

  /**
   * �T�[�r�X��ރ��C�A�E�g���擾���܂��B
   * @return �T�[�r�X��ރ��C�A�E�g
   */
  public VRLayout getServicePanelLayout(){
    if(servicePanelLayout==null){

      servicePanelLayout = new VRLayout();

      servicePanelLayout.setHgap(0);

      servicePanelLayout.setLabelMargin(0);

      servicePanelLayout.setVgap(0);

      addServicePanelLayout();
    }
    return servicePanelLayout;

  }

  /**
   * ���Ə��R���{���擾���܂��B
   * @return ���Ə��R���{
   */
  public ACComboBox getProviderCombo(){
    if(providerCombo==null){

      providerCombo = new ACComboBox();

      getProviderComboContainer().setText("���Ə�");

      providerCombo.setBindPath("PROVIDER_ID");

      providerCombo.setEditable(false);

      providerCombo.setColumns(20);

      providerCombo.setModelBindPath("PROVIDER");

      providerCombo.setRenderBindPath("PROVIDER_NAME");

      providerCombo.setBlankable(false);

      providerCombo.setModel(getProviderComboModel());

      addProviderCombo();
    }
    return providerCombo;

  }

  /**
   * ���Ə��R���{�R���e�i���擾���܂��B
   * @return ���Ə��R���{�R���e�i
   */
  protected ACLabelContainer getProviderComboContainer(){
    if(providerComboContainer==null){
      providerComboContainer = new ACLabelContainer();
      providerComboContainer.setFollowChildEnabled(true);
      providerComboContainer.setVAlignment(VRLayout.CENTER);
      providerComboContainer.add(getProviderCombo(), null);
    }
    return providerComboContainer;
  }

  /**
   * ���Ə��R���{���f�����擾���܂��B
   * @return ���Ə��R���{���f��
   */
  protected ACComboBoxModelAdapter getProviderComboModel(){
    if(providerComboModel==null){
      providerComboModel = new ACComboBoxModelAdapter();
      addProviderComboModel();
    }
    return providerComboModel;
  }

  /**
   * �T�[�r�X��ޖ��R���{���擾���܂��B
   * @return �T�[�r�X��ޖ��R���{
   */
  public ACComboBox getServiceCombo(){
    if(serviceCombo==null){

      serviceCombo = new ACComboBox();

      getServiceComboContainer().setText("�T�[�r�X���");

      serviceCombo.setBindPath("SERVICE_TYPE");

      serviceCombo.setEditable(false);

      serviceCombo.setColumns(20);

      serviceCombo.setModelBindPath("SERVICE");

      serviceCombo.setRenderBindPath("SERVICE_ABBREVIATION");

      serviceCombo.setBlankable(false);

      serviceCombo.setModel(getServiceComboModel());

      addServiceCombo();
    }
    return serviceCombo;

  }

  /**
   * �T�[�r�X��ޖ��R���{�R���e�i���擾���܂��B
   * @return �T�[�r�X��ޖ��R���{�R���e�i
   */
  protected ACLabelContainer getServiceComboContainer(){
    if(serviceComboContainer==null){
      serviceComboContainer = new ACLabelContainer();
      serviceComboContainer.setFollowChildEnabled(true);
      serviceComboContainer.setVAlignment(VRLayout.CENTER);
      serviceComboContainer.add(getServiceCombo(), null);
    }
    return serviceComboContainer;
  }

  /**
   * �T�[�r�X��ޖ��R���{���f�����擾���܂��B
   * @return �T�[�r�X��ޖ��R���{���f��
   */
  protected ACComboBoxModelAdapter getServiceComboModel(){
    if(serviceComboModel==null){
      serviceComboModel = new ACComboBoxModelAdapter();
      addServiceComboModel();
    }
    return serviceComboModel;
  }

  /**
   * ����f�Ô�E���ʗ×{��׃e�[�u�����擾���܂��B
   * @return ����f�Ô�E���ʗ×{��׃e�[�u��
   */
  public ACTable getTokubetsuTable(){
    if(tokubetsuTable==null){

      tokubetsuTable = new ACTable();

      tokubetsuTable.setColumnModel(getTokubetsuTableColumnModel());

      tokubetsuTable.setPreferredSize(new Dimension(370,150));

      addTokubetsuTable();
    }
    return tokubetsuTable;

  }

  /**
   * ����f�Ô�E���ʗ×{��׃e�[�u���J�������f�����擾���܂��B
   * @return ����f�Ô�E���ʗ×{��׃e�[�u���J�������f��
   */
  protected VRTableColumnModel getTokubetsuTableColumnModel(){
    if(tokubetsuTableColumnModel==null){
      tokubetsuTableColumnModel = new VRTableColumnModel(new TableColumn[]{});
      addTokubetsuTableColumnModel();
    }
    return tokubetsuTableColumnModel;
  }

  /**
   * No.���擾���܂��B
   * @return No.
   */
  public ACTableColumn getTokubetsuTableColumn1(){
    if(tokubetsuTableColumn1==null){

      tokubetsuTableColumn1 = new ACTableColumn();

      tokubetsuTableColumn1.setHeaderValue("No.");

      tokubetsuTableColumn1.setColumnName("NAME");

      tokubetsuTableColumn1.setColumns(2);

      tokubetsuTableColumn1.setRendererType(ACTableCellViewer.RENDERER_TYPE_SERIAL_NO);

      tokubetsuTableColumn1.setSortable(false);

      addTokubetsuTableColumn1();
    }
    return tokubetsuTableColumn1;

  }

  /**
   * �T�[�r�X�����擾���܂��B
   * @return �T�[�r�X��
   */
  public ACTableColumn getTokubetsuTableColumn2(){
    if(tokubetsuTableColumn2==null){

      tokubetsuTableColumn2 = new ACTableColumn();

      tokubetsuTableColumn2.setHeaderValue("�T�[�r�X��");

      tokubetsuTableColumn2.setColumnName("NAME");

      tokubetsuTableColumn2.setColumns(22);

      addTokubetsuTableColumn2();
    }
    return tokubetsuTableColumn2;

  }

  /**
   * �񐔂��擾���܂��B
   * @return ��
   */
  public ACTableColumn getTokubetsuTableColumn3(){
    if(tokubetsuTableColumn3==null){

      tokubetsuTableColumn3 = new ACTableColumn();

      tokubetsuTableColumn3.setHeaderValue("��");

      tokubetsuTableColumn3.setColumnName("TOTAL_COUNT");

      tokubetsuTableColumn3.setColumns(5);

      tokubetsuTableColumn3.setHorizontalAlignment(SwingConstants.RIGHT);

      addTokubetsuTableColumn3();
    }
    return tokubetsuTableColumn3;

  }

  /**
   * �ڍ׏��̈���擾���܂��B
   * @return �ڍ׏��̈�
   */
  public ACGroupBox getDayDetailGroup(){
    if(dayDetailGroup==null){

      dayDetailGroup = new ACGroupBox();

      dayDetailGroup.setText("�ڍ׏��");

      dayDetailGroup.setFollowChildEnabled(true);

      addDayDetailGroup();
    }
    return dayDetailGroup;

  }

  /**
   * �ڍ׏��e�[�u�����擾���܂��B
   * @return �ڍ׏��e�[�u��
   */
  public ACTable getDayDetailTable(){
    if(dayDetailTable==null){

      dayDetailTable = new ACTable();

      dayDetailTable.setColumnModel(getDayDetailTableColumnModel());

      dayDetailTable.setPreferredSize(new Dimension(100,50));

      addDayDetailTable();
    }
    return dayDetailTable;

  }

  /**
   * �ڍ׏��e�[�u���J�������f�����擾���܂��B
   * @return �ڍ׏��e�[�u���J�������f��
   */
  protected VRTableColumnModel getDayDetailTableColumnModel(){
    if(dayDetailTableColumnModel==null){
      dayDetailTableColumnModel = new VRTableColumnModel(new TableColumn[]{});
      addDayDetailTableColumnModel();
    }
    return dayDetailTableColumnModel;
  }

  /**
   * �ݒ�����擾���܂��B
   * @return �ݒ��
   */
  public ACTableColumn getDayDetailTableColumn1(){
    if(dayDetailTableColumn1==null){

      dayDetailTableColumn1 = new ACTableColumn();

      dayDetailTableColumn1.setHeaderValue("�ݒ��");

      dayDetailTableColumn1.setColumnName("SERVICE_DATE");

      dayDetailTableColumn1.setColumns(12);

      dayDetailTableColumn1.setFormat(new ACBorderBlankDateFormat("gggee�NMM��dd��"));

      addDayDetailTableColumn1();
    }
    return dayDetailTableColumn1;

  }

  /**
   * �񐔂��擾���܂��B
   * @return ��
   */
  public ACTableColumn getDayDetailTableColumn2(){
    if(dayDetailTableColumn2==null){

      dayDetailTableColumn2 = new ACTableColumn();

      dayDetailTableColumn2.setHeaderValue("��");

      dayDetailTableColumn2.setColumnName("DAY_IN_COUNT");

      dayDetailTableColumn2.setColumns(6);

      dayDetailTableColumn2.setHorizontalAlignment(SwingConstants.RIGHT);

      addDayDetailTableColumn2();
    }
    return dayDetailTableColumn2;

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
   * ������擾���܂��B
   * @return ����
   */
  public ACButton getClose(){
    if(close==null){

      close = new ACButton();

      close.setText("����(C)");

      close.setMnemonic('C');

      addClose();
    }
    return close;

  }

  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001008Design() {

    super(ACFrame.getInstance(), true);
    this.getContentPane().setLayout(new VRLayout());
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    try {
      initialize();

      setSize(400, 450);

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

    contents.add(getTokubetsuGroup(), VRLayout.NORTH);

    contents.add(getDayDetailGroup(), VRLayout.CLIENT);

    contents.add(getButtons(), VRLayout.SOUTH);
  }

  /**
   * ����f�Ô�E���ʗ×{��O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTokubetsuGroup(){

    tokubetsuGroup.add(getServicePanel(), VRLayout.FLOW_RETURN);

    tokubetsuGroup.add(getTokubetsuTable(), VRLayout.FLOW_RETURN);

  }

  /**
   * �O���[�v���C�A�E�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTokubetsuGroupLayout(){

  }

  /**
   * �T�[�r�X��ޗ̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addServicePanel(){

    servicePanel.add(getProviderComboContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    servicePanel.add(getServiceComboContainer(), VRLayout.FLOW_INSETLINE);

  }

  /**
   * �T�[�r�X��ރ��C�A�E�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addServicePanelLayout(){

  }

  /**
   * ���Ə��R���{�ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderCombo(){

  }

  /**
   * ���Ə��R���{���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderComboModel(){

  }

  /**
   * �T�[�r�X��ޖ��R���{�ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceCombo(){

  }

  /**
   * �T�[�r�X��ޖ��R���{���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceComboModel(){

  }

  /**
   * ����f�Ô�E���ʗ×{��׃e�[�u���ɓ������ڂ�ǉ����܂��B
   */
  protected void addTokubetsuTable(){

  }

  /**
   * ����f�Ô�E���ʗ×{��׃e�[�u���J�������f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addTokubetsuTableColumnModel(){

    getTokubetsuTableColumnModel().addColumn(getTokubetsuTableColumn1());

    getTokubetsuTableColumnModel().addColumn(getTokubetsuTableColumn2());

    getTokubetsuTableColumnModel().addColumn(getTokubetsuTableColumn3());

  }

  /**
   * No.�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTokubetsuTableColumn1(){

  }

  /**
   * �T�[�r�X���ɓ������ڂ�ǉ����܂��B
   */
  protected void addTokubetsuTableColumn2(){

  }

  /**
   * �񐔂ɓ������ڂ�ǉ����܂��B
   */
  protected void addTokubetsuTableColumn3(){

  }

  /**
   * �ڍ׏��̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addDayDetailGroup(){

    dayDetailGroup.add(getDayDetailTable(), VRLayout.CLIENT);

  }

  /**
   * �ڍ׏��e�[�u���ɓ������ڂ�ǉ����܂��B
   */
  protected void addDayDetailTable(){

  }

  /**
   * �ڍ׏��e�[�u���J�������f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addDayDetailTableColumnModel(){

    getDayDetailTableColumnModel().addColumn(getDayDetailTableColumn1());

    getDayDetailTableColumnModel().addColumn(getDayDetailTableColumn2());

  }

  /**
   * �ݒ���ɓ������ڂ�ǉ����܂��B
   */
  protected void addDayDetailTableColumn1(){

  }

  /**
   * �񐔂ɓ������ڂ�ǉ����܂��B
   */
  protected void addDayDetailTableColumn2(){

  }

  /**
   * �{�^���̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addButtons(){

    buttons.add(getClose(), VRLayout.EAST);
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
      new QS001008Design().setVisible(true);
      System.exit(0);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QS001008Design getThis() {
    return this;
  }
}
