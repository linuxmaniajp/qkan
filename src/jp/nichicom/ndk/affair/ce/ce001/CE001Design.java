
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
 * 開発者: 田中　統蔵
 * 作成日: 2006/04/26  日本コンピューター株式会社 田中　統蔵 新規作成
 * 更新日: ----/--/--
 * システム CodeWall (C)
 * サブシステム CodeWall (E)
 * プロセス 暗号化 (001)
 * プログラム 暗号化 (CE001)
 *
 *****************************************************************
 */
package jp.nichicom.ndk.affair.ce.ce001;
import java.awt.Component;

import javax.swing.table.TableColumn;

import jp.nichicom.ac.ACConstants;
import jp.nichicom.ac.component.ACAffairButton;
import jp.nichicom.ac.component.ACAffairButtonBar;
import jp.nichicom.ac.component.ACButton;
import jp.nichicom.ac.component.ACClearableRadioButtonGroup;
import jp.nichicom.ac.component.ACIntegerCheckBox;
import jp.nichicom.ac.component.ACRadioButtonItem;
import jp.nichicom.ac.component.ACTextArea;
import jp.nichicom.ac.component.ACTextField;
import jp.nichicom.ac.component.table.ACTable;
import jp.nichicom.ac.component.table.ACTableCellViewer;
import jp.nichicom.ac.component.table.ACTableColumn;
import jp.nichicom.ac.container.ACGroupBox;
import jp.nichicom.ac.container.ACLabelContainer;
import jp.nichicom.ac.container.ACPanel;
import jp.nichicom.ac.core.ACAffairContainer;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACAffairable;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.util.adapter.ACListModelAdapter;
import jp.nichicom.vr.component.table.VRTableColumnModel;
import jp.nichicom.vr.layout.VRLayout;
import jp.nichicom.vr.util.VRMap;
/**
 * 暗号化画面項目デザイン(CE001) 
 */
@SuppressWarnings("serial")
public class CE001Design extends ACAffairContainer implements ACAffairable {
  //GUIコンポーネント

  private ACAffairButtonBar buttons;

  private ACAffairButton encode;

  private ACAffairButton decode;

  private ACAffairButton stubOut;

  private ACGroupBox setting;

  private ACLabelContainer encodeVersionContainer;

  private ACTextField encodeVersion;

  private ACLabelContainer informationContainer;

  private ACTextArea information;

  private ACLabelContainer stubOutPathContainer;

  private ACTextField stubOutPath;

  private ACButton stubOutPathBrose;

  private ACGroupBox targetPanel;

  private ACTable targets;

  private VRTableColumnModel targetsColumnModel;

  private ACTableColumn targetsNo;

  private ACTableColumn targetsType;

  private ACTableColumn targetsFilter;

  private ACTableColumn targetsPath;

  private ACGroupBox targetSetting;

  private ACClearableRadioButtonGroup targetType;

  private ACLabelContainer targetTypeContainer;

  private ACListModelAdapter targetTypeModel;

  private ACRadioButtonItem targetTypeFile;

  private ACRadioButtonItem targetTypeFolder;

  private ACClearableRadioButtonGroup targetFilter;

  private ACLabelContainer targetFilterContainer;

  private ACListModelAdapter targetFilterModel;

  private ACRadioButtonItem targetTypeAdd;

  private ACRadioButtonItem targetTypeExclusive;

  private ACLabelContainer targetPathContainer;

  private ACTextField targetPath;

  private ACButton targetPathBrose;

  private ACIntegerCheckBox targetSerial;

  private ACPanel targetSettingButtons;

  private ACButton targetSettingInsert;

  private ACButton targetSettingUpdate;

  private ACButton targetSettingDelete;

  //getter

  /**
   * 業務ボタンバーを取得します。
   * @return 業務ボタンバー
   */
  public ACAffairButtonBar getButtons(){
    if(buttons==null){

      buttons = new ACAffairButtonBar();

      buttons.setText("暗号化");

      addButtons();
    }
    return buttons;

  }

  /**
   * 暗号化を取得します。
   * @return 暗号化
   */
  public ACAffairButton getEncode(){
    if(encode==null){

      encode = new ACAffairButton();

      encode.setText("暗号化(E)");

      encode.setMnemonic('E');

      encode.setIconPath(ACConstants.ICON_PATH_EXPORT_24);

      addEncode();
    }
    return encode;

  }

  /**
   * 復号化を取得します。
   * @return 復号化
   */
  public ACAffairButton getDecode(){
    if(decode==null){

      decode = new ACAffairButton();

      decode.setText("複合化(D)");

      decode.setMnemonic('D');

      decode.setIconPath(ACConstants.ICON_PATH_PARSE_24);

      addDecode();
    }
    return decode;

  }

  /**
   * スタブを取得します。
   * @return スタブ
   */
  public ACAffairButton getStubOut(){
    if(stubOut==null){

      stubOut = new ACAffairButton();

      stubOut.setText("スタブ(S)");

      stubOut.setMnemonic('S');

      stubOut.setIconPath(ACConstants.ICON_PATH_UPDATE_24);

      addStubOut();
    }
    return stubOut;

  }

  /**
   * 設定を取得します。
   * @return 設定
   */
  public ACGroupBox getSetting(){
    if(setting==null){

      setting = new ACGroupBox();

      setting.setText("設定");

      addSetting();
    }
    return setting;

  }

  /**
   * 暗号バージョンコンテナを取得します。
   * @return 暗号バージョンコンテナ
   */
  public ACLabelContainer getEncodeVersionContainer(){
    if(encodeVersionContainer==null){

      encodeVersionContainer = new ACLabelContainer();

      encodeVersionContainer.setText("暗号バージョン");

      addEncodeVersionContainer();
    }
    return encodeVersionContainer;

  }

  /**
   * 暗号バージョンを取得します。
   * @return 暗号バージョン
   */
  public ACTextField getEncodeVersion(){
    if(encodeVersion==null){

      encodeVersion = new ACTextField();

      encodeVersion.setText("1.0(シフト暗号化)");

      encodeVersion.setEditable(false);

      addEncodeVersion();
    }
    return encodeVersion;

  }

  /**
   * 埋め込む情報コンテナを取得します。
   * @return 埋め込む情報コンテナ
   */
  public ACLabelContainer getInformationContainer(){
    if(informationContainer==null){

      informationContainer = new ACLabelContainer();

      informationContainer.setText("埋め込む情報");

      addInformationContainer();
    }
    return informationContainer;

  }

  /**
   * 埋め込む情報を取得します。
   * @return 埋め込む情報
   */
  public ACTextArea getInformation(){
    if(information==null){

      information = new ACTextArea();

      information.setText("All  Rights Reserved , Copyright (C) Nippon Computer Corporation  2005");

      information.setColumns(100);

      information.setRows(3);

      addInformation();
    }
    return information;

  }

  /**
   * スタブ出力先コンテナを取得します。
   * @return スタブ出力先コンテナ
   */
  public ACLabelContainer getStubOutPathContainer(){
    if(stubOutPathContainer==null){

      stubOutPathContainer = new ACLabelContainer();

      stubOutPathContainer.setText("スタブ出力先");

      addStubOutPathContainer();
    }
    return stubOutPathContainer;

  }

  /**
   * スタブ出力先を取得します。
   * @return スタブ出力先
   */
  public ACTextField getStubOutPath(){
    if(stubOutPath==null){

      stubOutPath = new ACTextField();

      stubOutPath.setColumns(50);

      addStubOutPath();
    }
    return stubOutPath;

  }

  /**
   * スタブ出力先参照を取得します。
   * @return スタブ出力先参照
   */
  public ACButton getStubOutPathBrose(){
    if(stubOutPathBrose==null){

      stubOutPathBrose = new ACButton();

      stubOutPathBrose.setText("参照(T)");

      stubOutPathBrose.setMnemonic('T');

      addStubOutPathBrose();
    }
    return stubOutPathBrose;

  }

  /**
   * 暗号化対象を取得します。
   * @return 暗号化対象
   */
  public ACGroupBox getTargetPanel(){
    if(targetPanel==null){

      targetPanel = new ACGroupBox();

      targetPanel.setText("暗号化対象");

      addTargetPanel();
    }
    return targetPanel;

  }

  /**
   * 暗号化対象一覧を取得します。
   * @return 暗号化対象一覧
   */
  public ACTable getTargets(){
    if(targets==null){

      targets = new ACTable();

      targets.setColumnModel(getTargetsColumnModel());

      addTargets();
    }
    return targets;

  }

  /**
   * 暗号化対象一覧カラムモデルを取得します。
   * @return 暗号化対象一覧カラムモデル
   */
  protected VRTableColumnModel getTargetsColumnModel(){
    if(targetsColumnModel==null){
      targetsColumnModel = new VRTableColumnModel(new TableColumn[]{});
      addTargetsColumnModel();
    }
    return targetsColumnModel;
  }

  /**
   * No.を取得します。
   * @return No.
   */
  public ACTableColumn getTargetsNo(){
    if(targetsNo==null){

      targetsNo = new ACTableColumn();

      targetsNo.setHeaderValue("No.");

      targetsNo.setColumnName("TARGET_TYPE");

      targetsNo.setColumns(3);

      targetsNo.setRendererType(ACTableCellViewer.RENDERER_TYPE_SERIAL_NO);

      targetsNo.setSortable(false);

      addTargetsNo();
    }
    return targetsNo;

  }

  /**
   * 種類を取得します。
   * @return 種類
   */
  public ACTableColumn getTargetsType(){
    if(targetsType==null){

      targetsType = new ACTableColumn();

      targetsType.setHeaderValue("種類");

      targetsType.setColumnName("TARGET_TYPE");

      targetsType.setColumns(6);

      addTargetsType();
    }
    return targetsType;

  }

  /**
   * フィルタを取得します。
   * @return フィルタ
   */
  public ACTableColumn getTargetsFilter(){
    if(targetsFilter==null){

      targetsFilter = new ACTableColumn();

      targetsFilter.setHeaderValue("フィルタ");

      targetsFilter.setColumnName("TARGET_FILTER");

      targetsFilter.setColumns(6);

      addTargetsFilter();
    }
    return targetsFilter;

  }

  /**
   * 対象を取得します。
   * @return 対象
   */
  public ACTableColumn getTargetsPath(){
    if(targetsPath==null){

      targetsPath = new ACTableColumn();

      targetsPath.setHeaderValue("対象");

      targetsPath.setColumnName("TARGET_PATH");

      targetsPath.setColumns(20);

      addTargetsPath();
    }
    return targetsPath;

  }

  /**
   * 対象設定を取得します。
   * @return 対象設定
   */
  public ACGroupBox getTargetSetting(){
    if(targetSetting==null){

      targetSetting = new ACGroupBox();

      targetSetting.setText("対象設定");

      addTargetSetting();
    }
    return targetSetting;

  }

  /**
   * 種類を取得します。
   * @return 種類
   */
  public ACClearableRadioButtonGroup getTargetType(){
    if(targetType==null){

      targetType = new ACClearableRadioButtonGroup();

      getTargetTypeContainer().setText("種類");

      targetType.setBindPath("TARGET_TYPE");

      targetType.setUseClearButton(false);

      targetType.setModel(getTargetTypeModel());

      addTargetType();
    }
    return targetType;

  }

  /**
   * 種類コンテナを取得します。
   * @return 種類コンテナ
   */
  protected ACLabelContainer getTargetTypeContainer(){
    if(targetTypeContainer==null){
      targetTypeContainer = new ACLabelContainer();
      targetTypeContainer.setFollowChildEnabled(true);
      targetTypeContainer.setVAlignment(VRLayout.CENTER);
      targetTypeContainer.add(getTargetType(), null);
    }
    return targetTypeContainer;
  }

  /**
   * 種類モデルを取得します。
   * @return 種類モデル
   */
  protected ACListModelAdapter getTargetTypeModel(){
    if(targetTypeModel==null){
      targetTypeModel = new ACListModelAdapter();
      addTargetTypeModel();
    }
    return targetTypeModel;
  }

  /**
   * フォルダを取得します。
   * @return フォルダ
   */
  public ACRadioButtonItem getTargetTypeFile(){
    if(targetTypeFile==null){

      targetTypeFile = new ACRadioButtonItem();

      targetTypeFile.setText("フォルダ");

      targetTypeFile.setGroup(getTargetType());

      targetTypeFile.setConstraints(VRLayout.FLOW);

      addTargetTypeFile();
    }
    return targetTypeFile;

  }

  /**
   * ファイルを取得します。
   * @return ファイル
   */
  public ACRadioButtonItem getTargetTypeFolder(){
    if(targetTypeFolder==null){

      targetTypeFolder = new ACRadioButtonItem();

      targetTypeFolder.setText("ファイル");

      targetTypeFolder.setGroup(getTargetType());

      targetTypeFolder.setConstraints(VRLayout.FLOW);

      addTargetTypeFolder();
    }
    return targetTypeFolder;

  }

  /**
   * フィルタを取得します。
   * @return フィルタ
   */
  public ACClearableRadioButtonGroup getTargetFilter(){
    if(targetFilter==null){

      targetFilter = new ACClearableRadioButtonGroup();

      getTargetFilterContainer().setText("フィルタ");

      targetFilter.setBindPath("TARGET_FILTER");

      targetFilter.setUseClearButton(false);

      targetFilter.setModel(getTargetFilterModel());

      addTargetFilter();
    }
    return targetFilter;

  }

  /**
   * フィルタコンテナを取得します。
   * @return フィルタコンテナ
   */
  protected ACLabelContainer getTargetFilterContainer(){
    if(targetFilterContainer==null){
      targetFilterContainer = new ACLabelContainer();
      targetFilterContainer.setFollowChildEnabled(true);
      targetFilterContainer.setVAlignment(VRLayout.CENTER);
      targetFilterContainer.add(getTargetFilter(), null);
    }
    return targetFilterContainer;
  }

  /**
   * フィルタモデルを取得します。
   * @return フィルタモデル
   */
  protected ACListModelAdapter getTargetFilterModel(){
    if(targetFilterModel==null){
      targetFilterModel = new ACListModelAdapter();
      addTargetFilterModel();
    }
    return targetFilterModel;
  }

  /**
   * 追加を取得します。
   * @return 追加
   */
  public ACRadioButtonItem getTargetTypeAdd(){
    if(targetTypeAdd==null){

      targetTypeAdd = new ACRadioButtonItem();

      targetTypeAdd.setText("追加");

      targetTypeAdd.setGroup(getTargetFilter());

      targetTypeAdd.setConstraints(VRLayout.FLOW);

      addTargetTypeAdd();
    }
    return targetTypeAdd;

  }

  /**
   * 除外を取得します。
   * @return 除外
   */
  public ACRadioButtonItem getTargetTypeExclusive(){
    if(targetTypeExclusive==null){

      targetTypeExclusive = new ACRadioButtonItem();

      targetTypeExclusive.setText("除外");

      targetTypeExclusive.setGroup(getTargetFilter());

      targetTypeExclusive.setConstraints(VRLayout.FLOW);

      addTargetTypeExclusive();
    }
    return targetTypeExclusive;

  }

  /**
   * 対象コンテナを取得します。
   * @return 対象コンテナ
   */
  public ACLabelContainer getTargetPathContainer(){
    if(targetPathContainer==null){

      targetPathContainer = new ACLabelContainer();

      targetPathContainer.setText("対象");

      addTargetPathContainer();
    }
    return targetPathContainer;

  }

  /**
   * 対象を取得します。
   * @return 対象
   */
  public ACTextField getTargetPath(){
    if(targetPath==null){

      targetPath = new ACTextField();

      targetPath.setBindPath("TARGET_PATH");

      targetPath.setColumns(50);

      addTargetPath();
    }
    return targetPath;

  }

  /**
   * 対象参照を取得します。
   * @return 対象参照
   */
  public ACButton getTargetPathBrose(){
    if(targetPathBrose==null){

      targetPathBrose = new ACButton();

      targetPathBrose.setText("参照(B)");

      targetPathBrose.setMnemonic('B');

      addTargetPathBrose();
    }
    return targetPathBrose;

  }

  /**
   * 連番データを取得します。
   * @return 連番データ
   */
  public ACIntegerCheckBox getTargetSerial(){
    if(targetSerial==null){

      targetSerial = new ACIntegerCheckBox();

      targetSerial.setBindPath("TARGET_SERIAL");

      targetSerial.setVisible(false);

      addTargetSerial();
    }
    return targetSerial;

  }

  /**
   * 対象設定ボタンバーを取得します。
   * @return 対象設定ボタンバー
   */
  public ACPanel getTargetSettingButtons(){
    if(targetSettingButtons==null){

      targetSettingButtons = new ACPanel();

      addTargetSettingButtons();
    }
    return targetSettingButtons;

  }

  /**
   * 対象の追加を取得します。
   * @return 対象の追加
   */
  public ACButton getTargetSettingInsert(){
    if(targetSettingInsert==null){

      targetSettingInsert = new ACButton();

      targetSettingInsert.setText("追加(I)");

      targetSettingInsert.setMnemonic('I');

      addTargetSettingInsert();
    }
    return targetSettingInsert;

  }

  /**
   * 対象の更新を取得します。
   * @return 対象の更新
   */
  public ACButton getTargetSettingUpdate(){
    if(targetSettingUpdate==null){

      targetSettingUpdate = new ACButton();

      targetSettingUpdate.setText("更新(U)");

      targetSettingUpdate.setEnabled(false);

      targetSettingUpdate.setMnemonic('U');

      addTargetSettingUpdate();
    }
    return targetSettingUpdate;

  }

  /**
   * 対象の削除を取得します。
   * @return 対象の削除
   */
  public ACButton getTargetSettingDelete(){
    if(targetSettingDelete==null){

      targetSettingDelete = new ACButton();

      targetSettingDelete.setText("削除(D)");

      targetSettingDelete.setEnabled(false);

      targetSettingDelete.setMnemonic('D');

      addTargetSettingDelete();
    }
    return targetSettingDelete;

  }

  /**
   * コンストラクタです。
   */
  public CE001Design() {

    try {
      initialize();

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

    this.add(getButtons(), VRLayout.NORTH);

    this.add(getSetting(), VRLayout.NORTH);

    this.add(getTargetPanel(), VRLayout.CLIENT);

  }

  /**
   * 業務ボタンバーに内部項目を追加します。
   */
  protected void addButtons(){

    buttons.add(getStubOut(), VRLayout.EAST);
    buttons.add(getDecode(), VRLayout.EAST);
    buttons.add(getEncode(), VRLayout.EAST);
  }

  /**
   * 暗号化に内部項目を追加します。
   */
  protected void addEncode(){

  }

  /**
   * 復号化に内部項目を追加します。
   */
  protected void addDecode(){

  }

  /**
   * スタブに内部項目を追加します。
   */
  protected void addStubOut(){

  }

  /**
   * 設定に内部項目を追加します。
   */
  protected void addSetting(){

    setting.add(getEncodeVersionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    setting.add(getInformationContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    setting.add(getStubOutPathContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * 暗号バージョンコンテナに内部項目を追加します。
   */
  protected void addEncodeVersionContainer(){

    encodeVersionContainer.add(getEncodeVersion(), VRLayout.FLOW);

  }

  /**
   * 暗号バージョンに内部項目を追加します。
   */
  protected void addEncodeVersion(){

  }

  /**
   * 埋め込む情報コンテナに内部項目を追加します。
   */
  protected void addInformationContainer(){

    informationContainer.add(getInformation(), VRLayout.FLOW);

  }

  /**
   * 埋め込む情報に内部項目を追加します。
   */
  protected void addInformation(){

  }

  /**
   * スタブ出力先コンテナに内部項目を追加します。
   */
  protected void addStubOutPathContainer(){

    stubOutPathContainer.add(getStubOutPath(), VRLayout.FLOW);

    stubOutPathContainer.add(getStubOutPathBrose(), VRLayout.FLOW);

  }

  /**
   * スタブ出力先に内部項目を追加します。
   */
  protected void addStubOutPath(){

  }

  /**
   * スタブ出力先参照に内部項目を追加します。
   */
  protected void addStubOutPathBrose(){

  }

  /**
   * 暗号化対象に内部項目を追加します。
   */
  protected void addTargetPanel(){

    targetPanel.add(getTargets(), VRLayout.CLIENT);

    targetPanel.add(getTargetSetting(), VRLayout.SOUTH);
  }

  /**
   * 暗号化対象一覧に内部項目を追加します。
   */
  protected void addTargets(){

  }

  /**
   * 暗号化対象一覧カラムモデルに内部項目を追加します。
   */
  protected void addTargetsColumnModel(){

    getTargetsColumnModel().addColumn(getTargetsNo());

    getTargetsColumnModel().addColumn(getTargetsType());

    getTargetsColumnModel().addColumn(getTargetsFilter());

    getTargetsColumnModel().addColumn(getTargetsPath());

  }

  /**
   * No.に内部項目を追加します。
   */
  protected void addTargetsNo(){

  }

  /**
   * 種類に内部項目を追加します。
   */
  protected void addTargetsType(){

  }

  /**
   * フィルタに内部項目を追加します。
   */
  protected void addTargetsFilter(){

  }

  /**
   * 対象に内部項目を追加します。
   */
  protected void addTargetsPath(){

  }

  /**
   * 対象設定に内部項目を追加します。
   */
  protected void addTargetSetting(){

    targetSetting.add(getTargetTypeContainer(), VRLayout.FLOW_INSETLINE);

    targetSetting.add(getTargetFilterContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    targetSetting.add(getTargetPathContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    targetSetting.add(getTargetSerial(), VRLayout.FLOW);

    targetSetting.add(getTargetSettingButtons(), VRLayout.SOUTH);
  }

  /**
   * 種類に内部項目を追加します。
   */
  protected void addTargetType(){

  }

  /**
   * 種類モデルに内部項目を追加します。
   */
  protected void addTargetTypeModel(){

    getTargetTypeFile().setButtonIndex(1);
    getTargetTypeModel().add(getTargetTypeFile());

    getTargetTypeFolder().setButtonIndex(2);
    getTargetTypeModel().add(getTargetTypeFolder());

  }

  /**
   * フォルダに内部項目を追加します。
   */
  protected void addTargetTypeFile(){

  }

  /**
   * ファイルに内部項目を追加します。
   */
  protected void addTargetTypeFolder(){

  }

  /**
   * フィルタに内部項目を追加します。
   */
  protected void addTargetFilter(){

  }

  /**
   * フィルタモデルに内部項目を追加します。
   */
  protected void addTargetFilterModel(){

    getTargetTypeAdd().setButtonIndex(1);
    getTargetFilterModel().add(getTargetTypeAdd());

    getTargetTypeExclusive().setButtonIndex(2);
    getTargetFilterModel().add(getTargetTypeExclusive());

  }

  /**
   * 追加に内部項目を追加します。
   */
  protected void addTargetTypeAdd(){

  }

  /**
   * 除外に内部項目を追加します。
   */
  protected void addTargetTypeExclusive(){

  }

  /**
   * 対象コンテナに内部項目を追加します。
   */
  protected void addTargetPathContainer(){

    targetPathContainer.add(getTargetPath(), VRLayout.FLOW);

    targetPathContainer.add(getTargetPathBrose(), VRLayout.FLOW);

  }

  /**
   * 対象に内部項目を追加します。
   */
  protected void addTargetPath(){

  }

  /**
   * 対象参照に内部項目を追加します。
   */
  protected void addTargetPathBrose(){

  }

  /**
   * 連番データに内部項目を追加します。
   */
  protected void addTargetSerial(){

  }

  /**
   * 対象設定ボタンバーに内部項目を追加します。
   */
  protected void addTargetSettingButtons(){

    targetSettingButtons.add(getTargetSettingDelete(), VRLayout.EAST);
    targetSettingButtons.add(getTargetSettingUpdate(), VRLayout.EAST);
    targetSettingButtons.add(getTargetSettingInsert(), VRLayout.EAST);
  }

  /**
   * 対象の追加に内部項目を追加します。
   */
  protected void addTargetSettingInsert(){

  }

  /**
   * 対象の更新に内部項目を追加します。
   */
  protected void addTargetSettingUpdate(){

  }

  /**
   * 対象の削除に内部項目を追加します。
   */
  protected void addTargetSettingDelete(){

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

  public static void main(String[] args) {
    //デフォルトデバッグ起動
    try {
      ACFrame.debugStart(new ACAffairInfo(CE001Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected CE001Design getThis() {
    return this;
  }
}
