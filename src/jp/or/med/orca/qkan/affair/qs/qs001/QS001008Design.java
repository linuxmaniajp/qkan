
/*
 * Project code name "ORCA"
 * 給付管理台帳ソフト QKANCHO（JMA care benefit management software）
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
 * アプリ: QKANCHO
 * 開発者: 樋口　雅彦
 * 作成日: 2012/08/08  日本コンピューター株式会社 樋口　雅彦 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム サービス管理 (S)
 * プロセス 特定診療費・特別療養費集計 (001)
 * プログラム 特定診療費・特別療養費集計画面 (QS001008)
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
 * 特定診療費・特別療養費集計画面画面項目デザイン(QS001008) 
 */
public class QS001008Design extends QkanAffairDialog {
  //GUIコンポーネント

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
   * クライアント領域を取得します。
   * @return クライアント領域
   */
  public ACPanel getContents(){
    if(contents==null){

      contents = new ACPanel();

      addContents();
    }
    return contents;

  }

  /**
   * 特定診療費・特別療養費グループを取得します。
   * @return 特定診療費・特別療養費グループ
   */
  public ACGroupBox getTokubetsuGroup(){
    if(tokubetsuGroup==null){

      tokubetsuGroup = new ACGroupBox();

      tokubetsuGroup.setText("特定診療費・特別療養費");

      tokubetsuGroup.setLayout(getTokubetsuGroupLayout());

      tokubetsuGroup.setFollowChildEnabled(true);

      addTokubetsuGroup();
    }
    return tokubetsuGroup;

  }

  /**
   * グループレイアウトを取得します。
   * @return グループレイアウト
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
   * サービス種類領域を取得します。
   * @return サービス種類領域
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
   * サービス種類レイアウトを取得します。
   * @return サービス種類レイアウト
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
   * 事業所コンボを取得します。
   * @return 事業所コンボ
   */
  public ACComboBox getProviderCombo(){
    if(providerCombo==null){

      providerCombo = new ACComboBox();

      getProviderComboContainer().setText("事業所");

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
   * 事業所コンボコンテナを取得します。
   * @return 事業所コンボコンテナ
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
   * 事業所コンボモデルを取得します。
   * @return 事業所コンボモデル
   */
  protected ACComboBoxModelAdapter getProviderComboModel(){
    if(providerComboModel==null){
      providerComboModel = new ACComboBoxModelAdapter();
      addProviderComboModel();
    }
    return providerComboModel;
  }

  /**
   * サービス種類名コンボを取得します。
   * @return サービス種類名コンボ
   */
  public ACComboBox getServiceCombo(){
    if(serviceCombo==null){

      serviceCombo = new ACComboBox();

      getServiceComboContainer().setText("サービス種類");

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
   * サービス種類名コンボコンテナを取得します。
   * @return サービス種類名コンボコンテナ
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
   * サービス種類名コンボモデルを取得します。
   * @return サービス種類名コンボモデル
   */
  protected ACComboBoxModelAdapter getServiceComboModel(){
    if(serviceComboModel==null){
      serviceComboModel = new ACComboBoxModelAdapter();
      addServiceComboModel();
    }
    return serviceComboModel;
  }

  /**
   * 特定診療費・特別療養費明細テーブルを取得します。
   * @return 特定診療費・特別療養費明細テーブル
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
   * 特定診療費・特別療養費明細テーブルカラムモデルを取得します。
   * @return 特定診療費・特別療養費明細テーブルカラムモデル
   */
  protected VRTableColumnModel getTokubetsuTableColumnModel(){
    if(tokubetsuTableColumnModel==null){
      tokubetsuTableColumnModel = new VRTableColumnModel(new TableColumn[]{});
      addTokubetsuTableColumnModel();
    }
    return tokubetsuTableColumnModel;
  }

  /**
   * No.を取得します。
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
   * サービス名を取得します。
   * @return サービス名
   */
  public ACTableColumn getTokubetsuTableColumn2(){
    if(tokubetsuTableColumn2==null){

      tokubetsuTableColumn2 = new ACTableColumn();

      tokubetsuTableColumn2.setHeaderValue("サービス名");

      tokubetsuTableColumn2.setColumnName("NAME");

      tokubetsuTableColumn2.setColumns(22);

      addTokubetsuTableColumn2();
    }
    return tokubetsuTableColumn2;

  }

  /**
   * 回数を取得します。
   * @return 回数
   */
  public ACTableColumn getTokubetsuTableColumn3(){
    if(tokubetsuTableColumn3==null){

      tokubetsuTableColumn3 = new ACTableColumn();

      tokubetsuTableColumn3.setHeaderValue("回数");

      tokubetsuTableColumn3.setColumnName("TOTAL_COUNT");

      tokubetsuTableColumn3.setColumns(5);

      tokubetsuTableColumn3.setHorizontalAlignment(SwingConstants.RIGHT);

      addTokubetsuTableColumn3();
    }
    return tokubetsuTableColumn3;

  }

  /**
   * 詳細情報領域を取得します。
   * @return 詳細情報領域
   */
  public ACGroupBox getDayDetailGroup(){
    if(dayDetailGroup==null){

      dayDetailGroup = new ACGroupBox();

      dayDetailGroup.setText("詳細情報");

      dayDetailGroup.setFollowChildEnabled(true);

      addDayDetailGroup();
    }
    return dayDetailGroup;

  }

  /**
   * 詳細情報テーブルを取得します。
   * @return 詳細情報テーブル
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
   * 詳細情報テーブルカラムモデルを取得します。
   * @return 詳細情報テーブルカラムモデル
   */
  protected VRTableColumnModel getDayDetailTableColumnModel(){
    if(dayDetailTableColumnModel==null){
      dayDetailTableColumnModel = new VRTableColumnModel(new TableColumn[]{});
      addDayDetailTableColumnModel();
    }
    return dayDetailTableColumnModel;
  }

  /**
   * 設定日を取得します。
   * @return 設定日
   */
  public ACTableColumn getDayDetailTableColumn1(){
    if(dayDetailTableColumn1==null){

      dayDetailTableColumn1 = new ACTableColumn();

      dayDetailTableColumn1.setHeaderValue("設定日");

      dayDetailTableColumn1.setColumnName("SERVICE_DATE");

      dayDetailTableColumn1.setColumns(12);

      dayDetailTableColumn1.setFormat(new ACBorderBlankDateFormat("gggee年MM月dd日"));

      addDayDetailTableColumn1();
    }
    return dayDetailTableColumn1;

  }

  /**
   * 回数を取得します。
   * @return 回数
   */
  public ACTableColumn getDayDetailTableColumn2(){
    if(dayDetailTableColumn2==null){

      dayDetailTableColumn2 = new ACTableColumn();

      dayDetailTableColumn2.setHeaderValue("回数");

      dayDetailTableColumn2.setColumnName("DAY_IN_COUNT");

      dayDetailTableColumn2.setColumns(6);

      dayDetailTableColumn2.setHorizontalAlignment(SwingConstants.RIGHT);

      addDayDetailTableColumn2();
    }
    return dayDetailTableColumn2;

  }

  /**
   * ボタン領域を取得します。
   * @return ボタン領域
   */
  public ACPanel getButtons(){
    if(buttons==null){

      buttons = new ACPanel();

      addButtons();
    }
    return buttons;

  }

  /**
   * 閉じるを取得します。
   * @return 閉じる
   */
  public ACButton getClose(){
    if(close==null){

      close = new ACButton();

      close.setText("閉じる(C)");

      close.setMnemonic('C');

      addClose();
    }
    return close;

  }

  /**
   * コンストラクタです。
   */
  public QS001008Design() {

    super(ACFrame.getInstance(), true);
    this.getContentPane().setLayout(new VRLayout());
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    try {
      initialize();

      setSize(400, 450);

      // ウィンドウを中央に配置
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
   * 自身の設定を行ないます。
   */
  protected void initThis(){
  }

  /**
   * thisに内部項目を追加します。
   */
  protected void addThis(){

    this.getContentPane().add(getContents(), VRLayout.CLIENT);

  }

  /**
   * クライアント領域に内部項目を追加します。
   */
  protected void addContents(){

    contents.add(getTokubetsuGroup(), VRLayout.NORTH);

    contents.add(getDayDetailGroup(), VRLayout.CLIENT);

    contents.add(getButtons(), VRLayout.SOUTH);
  }

  /**
   * 特定診療費・特別療養費グループに内部項目を追加します。
   */
  protected void addTokubetsuGroup(){

    tokubetsuGroup.add(getServicePanel(), VRLayout.FLOW_RETURN);

    tokubetsuGroup.add(getTokubetsuTable(), VRLayout.FLOW_RETURN);

  }

  /**
   * グループレイアウトに内部項目を追加します。
   */
  protected void addTokubetsuGroupLayout(){

  }

  /**
   * サービス種類領域に内部項目を追加します。
   */
  protected void addServicePanel(){

    servicePanel.add(getProviderComboContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    servicePanel.add(getServiceComboContainer(), VRLayout.FLOW_INSETLINE);

  }

  /**
   * サービス種類レイアウトに内部項目を追加します。
   */
  protected void addServicePanelLayout(){

  }

  /**
   * 事業所コンボに内部項目を追加します。
   */
  protected void addProviderCombo(){

  }

  /**
   * 事業所コンボモデルに内部項目を追加します。
   */
  protected void addProviderComboModel(){

  }

  /**
   * サービス種類名コンボに内部項目を追加します。
   */
  protected void addServiceCombo(){

  }

  /**
   * サービス種類名コンボモデルに内部項目を追加します。
   */
  protected void addServiceComboModel(){

  }

  /**
   * 特定診療費・特別療養費明細テーブルに内部項目を追加します。
   */
  protected void addTokubetsuTable(){

  }

  /**
   * 特定診療費・特別療養費明細テーブルカラムモデルに内部項目を追加します。
   */
  protected void addTokubetsuTableColumnModel(){

    getTokubetsuTableColumnModel().addColumn(getTokubetsuTableColumn1());

    getTokubetsuTableColumnModel().addColumn(getTokubetsuTableColumn2());

    getTokubetsuTableColumnModel().addColumn(getTokubetsuTableColumn3());

  }

  /**
   * No.に内部項目を追加します。
   */
  protected void addTokubetsuTableColumn1(){

  }

  /**
   * サービス名に内部項目を追加します。
   */
  protected void addTokubetsuTableColumn2(){

  }

  /**
   * 回数に内部項目を追加します。
   */
  protected void addTokubetsuTableColumn3(){

  }

  /**
   * 詳細情報領域に内部項目を追加します。
   */
  protected void addDayDetailGroup(){

    dayDetailGroup.add(getDayDetailTable(), VRLayout.CLIENT);

  }

  /**
   * 詳細情報テーブルに内部項目を追加します。
   */
  protected void addDayDetailTable(){

  }

  /**
   * 詳細情報テーブルカラムモデルに内部項目を追加します。
   */
  protected void addDayDetailTableColumnModel(){

    getDayDetailTableColumnModel().addColumn(getDayDetailTableColumn1());

    getDayDetailTableColumnModel().addColumn(getDayDetailTableColumn2());

  }

  /**
   * 設定日に内部項目を追加します。
   */
  protected void addDayDetailTableColumn1(){

  }

  /**
   * 回数に内部項目を追加します。
   */
  protected void addDayDetailTableColumn2(){

  }

  /**
   * ボタン領域に内部項目を追加します。
   */
  protected void addButtons(){

    buttons.add(getClose(), VRLayout.EAST);
  }

  /**
   * 閉じるに内部項目を追加します。
   */
  protected void addClose(){

  }

  /**
   * コンポーネントを初期化します。
   * @throws Exception 初期化例外
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
    //デフォルトデバッグ起動
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
   * 自身を返します。
   */
  protected QS001008Design getThis() {
    return this;
  }
}
