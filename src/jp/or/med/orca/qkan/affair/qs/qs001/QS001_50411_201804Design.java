
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
 * 開発者: 日高　しのぶ
 * 作成日: 2016/09/09  日本コンピューター株式会社 日高　しのぶ 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 予定管理 (S)
 * プロセス サービス予定 (001)
 * プログラム サービスパターン訪問型サービス(独自定額) (QS001_50411_201804)
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
 * サービスパターン訪問型サービス(独自定額)画面項目デザイン(QS001_50411_201804) 
 */
public class QS001_50411_201804Design extends QS001ServicePanelSogo {
  //GUIコンポーネント

  private ACPanel soA4Patterns;

  private ACPanel soA4Detail;

  private ACBackLabelContainer soA4TimeContena;

  private ACTimeComboBox soA4BeginTime;

  private ACLabelContainer soA4BeginTimeContainer;

  private ACComboBoxModelAdapter soA4BeginTimeModel;

  private ACTimeComboBox soA4EndTime;

  private ACLabelContainer soA4EndTimeContainer;

  private ACComboBoxModelAdapter soA4EndTimeModel;

  private ACComboBox insurerName;

  private ACLabelContainer insurerNameContainer;

  private ACComboBoxModelAdapter insurerNameModel;

  private ACBackLabelContainer soA4ItemCodeContena;

  private ACTextField itemCodeText;

  private ACLabelContainer itemCodeTextContainer;

  private ACButton addCodeToListButton;

  private ACButton codeFindButton;

  private ACButton deleteCodeButton;

  private ACTable svCodeTable;

  private VRTableColumnModel svCodeTableColumnModel;

  private ACTableColumn svCodeTableColumn1;

  private ACTableColumn svCodeTableColumn2;

  private ACTableColumn svCodeTableColumn3;

  private ACTableColumn svCodeTableColumn4;

  private ACTableColumn svCodeTableColumn5;

  private ACGroupBox infoGroup;

  private ACLabel infoLabel;

  //getter

  /**
   * 訪問型サービス独自定額パターン領域を取得します。
   * @return 訪問型サービス独自定額パターン領域
   */
  public ACPanel getSoA4Patterns(){
    if(soA4Patterns==null){

      soA4Patterns = new ACPanel();

      soA4Patterns.setAutoWrap(false);

      addSoA4Patterns();
    }
    return soA4Patterns;

  }

  /**
   * 内容パネルを取得します。
   * @return 内容パネル
   */
  public ACPanel getSoA4Detail(){
    if(soA4Detail==null){

      soA4Detail = new ACPanel();

      soA4Detail.setHgrid(200);

      addSoA4Detail();
    }
    return soA4Detail;

  }

  /**
   * 提供時間コンテナを取得します。
   * @return 提供時間コンテナ
   */
  public ACBackLabelContainer getSoA4TimeContena(){
    if(soA4TimeContena==null){

      soA4TimeContena = new ACBackLabelContainer();

      addSoA4TimeContena();
    }
    return soA4TimeContena;

  }

  /**
   * 開始時刻コンボを取得します。
   * @return 開始時刻コンボ
   */
  public ACTimeComboBox getSoA4BeginTime(){
    if(soA4BeginTime==null){

      soA4BeginTime = new ACTimeComboBox();

      getSoA4BeginTimeContainer().setText("開始時刻");

      soA4BeginTime.setBindPath("3");

      soA4BeginTime.setModelBindPath("3");

      soA4BeginTime.setRenderBindPath("CONTENT");

      soA4BeginTime.setModel(getSoA4BeginTimeModel());

      addSoA4BeginTime();
    }
    return soA4BeginTime;

  }

  /**
   * 開始時刻コンボコンテナを取得します。
   * @return 開始時刻コンボコンテナ
   */
  protected ACLabelContainer getSoA4BeginTimeContainer(){
    if(soA4BeginTimeContainer==null){
      soA4BeginTimeContainer = new ACLabelContainer();
      soA4BeginTimeContainer.setFollowChildEnabled(true);
      soA4BeginTimeContainer.setVAlignment(VRLayout.CENTER);
      soA4BeginTimeContainer.add(getSoA4BeginTime(), null);
    }
    return soA4BeginTimeContainer;
  }

  /**
   * 開始時刻コンボモデルを取得します。
   * @return 開始時刻コンボモデル
   */
  protected ACComboBoxModelAdapter getSoA4BeginTimeModel(){
    if(soA4BeginTimeModel==null){
      soA4BeginTimeModel = new ACComboBoxModelAdapter();
      addSoA4BeginTimeModel();
    }
    return soA4BeginTimeModel;
  }

  /**
   * 終了時刻コンボを取得します。
   * @return 終了時刻コンボ
   */
  public ACTimeComboBox getSoA4EndTime(){
    if(soA4EndTime==null){

      soA4EndTime = new ACTimeComboBox();

      getSoA4EndTimeContainer().setText("終了時刻");

      soA4EndTime.setBindPath("4");

      soA4EndTime.setModelBindPath("4");

      soA4EndTime.setRenderBindPath("CONTENT");

      soA4EndTime.setModel(getSoA4EndTimeModel());

      addSoA4EndTime();
    }
    return soA4EndTime;

  }

  /**
   * 終了時刻コンボコンテナを取得します。
   * @return 終了時刻コンボコンテナ
   */
  protected ACLabelContainer getSoA4EndTimeContainer(){
    if(soA4EndTimeContainer==null){
      soA4EndTimeContainer = new ACLabelContainer();
      soA4EndTimeContainer.setFollowChildEnabled(true);
      soA4EndTimeContainer.setVAlignment(VRLayout.CENTER);
      soA4EndTimeContainer.add(getSoA4EndTime(), null);
    }
    return soA4EndTimeContainer;
  }

  /**
   * 終了時刻コンボモデルを取得します。
   * @return 終了時刻コンボモデル
   */
  protected ACComboBoxModelAdapter getSoA4EndTimeModel(){
    if(soA4EndTimeModel==null){
      soA4EndTimeModel = new ACComboBoxModelAdapter();
      addSoA4EndTimeModel();
    }
    return soA4EndTimeModel;
  }

  /**
   * 保険者名を取得します。
   * @return 保険者名
   */
  public ACComboBox getInsurerName(){
    if(insurerName==null){

      insurerName = new ACComboBox();

      getInsurerNameContainer().setText("保険者名");

      insurerName.setBindPath("500");

      insurerName.setEditable(false);

      insurerName.setColumns(10);

      insurerName.setModelBindPath("INSURER");

      insurerName.setRenderBindPath("INSURER_NAME");

      insurerName.setModel(getInsurerNameModel());

      addInsurerName();
    }
    return insurerName;

  }

  /**
   * 保険者名コンテナを取得します。
   * @return 保険者名コンテナ
   */
  protected ACLabelContainer getInsurerNameContainer(){
    if(insurerNameContainer==null){
      insurerNameContainer = new ACLabelContainer();
      insurerNameContainer.setFollowChildEnabled(true);
      insurerNameContainer.setVAlignment(VRLayout.CENTER);
      insurerNameContainer.add(getInsurerName(), null);
    }
    return insurerNameContainer;
  }

  /**
   * 保険者名モデルを取得します。
   * @return 保険者名モデル
   */
  protected ACComboBoxModelAdapter getInsurerNameModel(){
    if(insurerNameModel==null){
      insurerNameModel = new ACComboBoxModelAdapter();
      addInsurerNameModel();
    }
    return insurerNameModel;
  }

  /**
   * サービス項目コードコンテナを取得します。
   * @return サービス項目コードコンテナ
   */
  public ACBackLabelContainer getSoA4ItemCodeContena(){
    if(soA4ItemCodeContena==null){

      soA4ItemCodeContena = new ACBackLabelContainer();

      addSoA4ItemCodeContena();
    }
    return soA4ItemCodeContena;

  }

  /**
   * サービス項目コードテキストを取得します。
   * @return サービス項目コードテキスト
   */
  public ACTextField getItemCodeText(){
    if(itemCodeText==null){

      itemCodeText = new ACTextField();

      getItemCodeTextContainer().setText("A4");

      itemCodeText.setColumns(4);

      itemCodeText.setIMEMode(InputSubset.LATIN);

      itemCodeText.setMaxLength(4);

      addItemCodeText();
    }
    return itemCodeText;

  }

  /**
   * サービス項目コードテキストコンテナを取得します。
   * @return サービス項目コードテキストコンテナ
   */
  protected ACLabelContainer getItemCodeTextContainer(){
    if(itemCodeTextContainer==null){
      itemCodeTextContainer = new ACLabelContainer();
      itemCodeTextContainer.setFollowChildEnabled(true);
      itemCodeTextContainer.setVAlignment(VRLayout.CENTER);
      itemCodeTextContainer.add(getItemCodeText(), null);
    }
    return itemCodeTextContainer;
  }

  /**
   * コードを一覧へ追加を取得します。
   * @return コードを一覧へ追加
   */
  public ACButton getAddCodeToListButton(){
    if(addCodeToListButton==null){

      addCodeToListButton = new ACButton();

      addCodeToListButton.setText("コードを一覧へ追加");

      addAddCodeToListButton();
    }
    return addCodeToListButton;

  }

  /**
   * コード選択を取得します。
   * @return コード選択
   */
  public ACButton getCodeFindButton(){
    if(codeFindButton==null){

      codeFindButton = new ACButton();

      codeFindButton.setText("コード選択");

      addCodeFindButton();
    }
    return codeFindButton;

  }

  /**
   * コード削除を取得します。
   * @return コード削除
   */
  public ACButton getDeleteCodeButton(){
    if(deleteCodeButton==null){

      deleteCodeButton = new ACButton();

      deleteCodeButton.setText("コード削除");

      addDeleteCodeButton();
    }
    return deleteCodeButton;

  }

  /**
   * サービスコードテーブルを取得します。
   * @return サービスコードテーブル
   */
  public ACTable getSvCodeTable(){
    if(svCodeTable==null){

      svCodeTable = new ACTable();

      svCodeTable.setColumnModel(getSvCodeTableColumnModel());

      svCodeTable.setPreferredSize(new Dimension(305,100));

      addSvCodeTable();
    }
    return svCodeTable;

  }

  /**
   * サービスコードテーブルカラムモデルを取得します。
   * @return サービスコードテーブルカラムモデル
   */
  protected VRTableColumnModel getSvCodeTableColumnModel(){
    if(svCodeTableColumnModel==null){
      svCodeTableColumnModel = new VRTableColumnModel(new TableColumn[]{});
      addSvCodeTableColumnModel();
    }
    return svCodeTableColumnModel;
  }

  /**
   * コードを取得します。
   * @return コード
   */
  public ACTableColumn getSvCodeTableColumn1(){
    if(svCodeTableColumn1==null){

      svCodeTableColumn1 = new ACTableColumn();

      svCodeTableColumn1.setHeaderValue("コード");

      svCodeTableColumn1.setColumnName("SERVICE_CODE_ITEM");

      svCodeTableColumn1.setColumns(5);

      addSvCodeTableColumn1();
    }
    return svCodeTableColumn1;

  }

  /**
   * 名称を取得します。
   * @return 名称
   */
  public ACTableColumn getSvCodeTableColumn2(){
    if(svCodeTableColumn2==null){

      svCodeTableColumn2 = new ACTableColumn();

      svCodeTableColumn2.setHeaderValue("名称");

      svCodeTableColumn2.setColumnName("SERVICE_NAME");

      svCodeTableColumn2.setColumns(14);

      addSvCodeTableColumn2();
    }
    return svCodeTableColumn2;

  }

  /**
   * 単位数を取得します。
   * @return 単位数
   */
  public ACTableColumn getSvCodeTableColumn3(){
    if(svCodeTableColumn3==null){

      svCodeTableColumn3 = new ACTableColumn();

      svCodeTableColumn3.setHeaderValue("単位数");

      svCodeTableColumn3.setColumnName("SERVICE_UNIT");

      svCodeTableColumn3.setColumns(3);

      svCodeTableColumn3.setHorizontalAlignment(SwingConstants.RIGHT);

      addSvCodeTableColumn3();
    }
    return svCodeTableColumn3;

  }

  /**
   * 負担額を取得します。
   * @return 負担額
   */
  public ACTableColumn getSvCodeTableColumn4(){
    if(svCodeTableColumn4==null){

      svCodeTableColumn4 = new ACTableColumn();

      svCodeTableColumn4.setHeaderValue("負担額");

      svCodeTableColumn4.setColumnName("FUTANGAKU");

      svCodeTableColumn4.setColumns(3);

      svCodeTableColumn4.setHorizontalAlignment(SwingConstants.RIGHT);

      addSvCodeTableColumn4();
    }
    return svCodeTableColumn4;

  }

  /**
   * 保険者番号を取得します。
   * @return 保険者番号
   */
  public ACTableColumn getSvCodeTableColumn5(){
    if(svCodeTableColumn5==null){

      svCodeTableColumn5 = new ACTableColumn();

      svCodeTableColumn5.setHeaderValue("保険者番号");

      svCodeTableColumn5.setColumnName("INSURER_ID");

      svCodeTableColumn5.setColumns(6);

      addSvCodeTableColumn5();
    }
    return svCodeTableColumn5;

  }

  /**
   * 注意書きグループを取得します。
   * @return 注意書きグループ
   */
  public ACGroupBox getInfoGroup(){
    if(infoGroup==null){

      infoGroup = new ACGroupBox();

      infoGroup.setFollowChildEnabled(true);

      infoGroup.setHgap(0);

      infoGroup.setLabelMargin(0);

      infoGroup.setVgap(0);

      addInfoGroup();
    }
    return infoGroup;

  }

  /**
   * 注意書きラベルを取得します。
   * @return 注意書きラベル
   */
  public ACLabel getInfoLabel(){
    if(infoLabel==null){

      infoLabel = new ACLabel();

      infoLabel.setText("定額の場合、一覧に追加できるコードは１件です。" + ACConstants.LINE_SEPARATOR + "追加や選択をすると、既存のコードを書替えます。");

      addInfoLabel();
    }
    return infoLabel;

  }

  /**
   * コンストラクタです。
   */
  public QS001_50411_201804Design() {

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

    this.add(getSoA4Patterns(), VRLayout.WEST);

  }

  /**
   * 訪問型サービス独自定額パターン領域に内部項目を追加します。
   */
  protected void addSoA4Patterns(){

    soA4Patterns.add(getSoA4Detail(), VRLayout.NORTH);

    soA4Patterns.add(getInfoGroup(), VRLayout.FLOW);

  }

  /**
   * 内容パネルに内部項目を追加します。
   */
  protected void addSoA4Detail(){

    soA4Detail.add(getSoA4TimeContena(), VRLayout.FLOW_DOUBLEINSETLINE_RETURN);

    soA4Detail.add(getInsurerNameContainer(), VRLayout.FLOW_INSETLINE);

    soA4Detail.add(getSoA4ItemCodeContena(), VRLayout.FLOW_DOUBLEINSETLINE_RETURN);

    soA4Detail.add(getCodeFindButton(), VRLayout.FLOW);

    soA4Detail.add(getDeleteCodeButton(), VRLayout.FLOW_RETURN);

    soA4Detail.add(getSvCodeTable(), VRLayout.FLOW_RETURN);

  }

  /**
   * 提供時間コンテナに内部項目を追加します。
   */
  protected void addSoA4TimeContena(){

    soA4TimeContena.add(getSoA4BeginTimeContainer(), VRLayout.FLOW);

    soA4TimeContena.add(getSoA4EndTimeContainer(), VRLayout.FLOW);

  }

  /**
   * 開始時刻コンボに内部項目を追加します。
   */
  protected void addSoA4BeginTime(){

  }

  /**
   * 開始時刻コンボモデルに内部項目を追加します。
   */
  protected void addSoA4BeginTimeModel(){

  }

  /**
   * 終了時刻コンボに内部項目を追加します。
   */
  protected void addSoA4EndTime(){

  }

  /**
   * 終了時刻コンボモデルに内部項目を追加します。
   */
  protected void addSoA4EndTimeModel(){

  }

  /**
   * 保険者名に内部項目を追加します。
   */
  protected void addInsurerName(){

  }

  /**
   * 保険者名モデルに内部項目を追加します。
   */
  protected void addInsurerNameModel(){

  }

  /**
   * サービス項目コードコンテナに内部項目を追加します。
   */
  protected void addSoA4ItemCodeContena(){

    soA4ItemCodeContena.add(getItemCodeTextContainer(), VRLayout.FLOW);

    soA4ItemCodeContena.add(getAddCodeToListButton(), VRLayout.FLOW);

  }

  /**
   * サービス項目コードテキストに内部項目を追加します。
   */
  protected void addItemCodeText(){

  }

  /**
   * コードを一覧へ追加に内部項目を追加します。
   */
  protected void addAddCodeToListButton(){

  }

  /**
   * コード選択に内部項目を追加します。
   */
  protected void addCodeFindButton(){

  }

  /**
   * コード削除に内部項目を追加します。
   */
  protected void addDeleteCodeButton(){

  }

  /**
   * サービスコードテーブルに内部項目を追加します。
   */
  protected void addSvCodeTable(){

  }

  /**
   * サービスコードテーブルカラムモデルに内部項目を追加します。
   */
  protected void addSvCodeTableColumnModel(){

    getSvCodeTableColumnModel().addColumn(getSvCodeTableColumn1());

    getSvCodeTableColumnModel().addColumn(getSvCodeTableColumn2());

    getSvCodeTableColumnModel().addColumn(getSvCodeTableColumn3());

    getSvCodeTableColumnModel().addColumn(getSvCodeTableColumn4());

    getSvCodeTableColumnModel().addColumn(getSvCodeTableColumn5());

  }

  /**
   * コードに内部項目を追加します。
   */
  protected void addSvCodeTableColumn1(){

  }

  /**
   * 名称に内部項目を追加します。
   */
  protected void addSvCodeTableColumn2(){

  }

  /**
   * 単位数に内部項目を追加します。
   */
  protected void addSvCodeTableColumn3(){

  }

  /**
   * 負担額に内部項目を追加します。
   */
  protected void addSvCodeTableColumn4(){

  }

  /**
   * 保険者番号に内部項目を追加します。
   */
  protected void addSvCodeTableColumn5(){

  }

  /**
   * 注意書きグループに内部項目を追加します。
   */
  protected void addInfoGroup(){

    infoGroup.add(getInfoLabel(), VRLayout.FLOW);

  }

  /**
   * 注意書きラベルに内部項目を追加します。
   */
  protected void addInfoLabel(){

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
      ACFrame.getInstance().setFrameEventProcesser(new QkanFrameEventProcesser());
      ACFrame.debugStart(new ACAffairInfo(QS001_50411_201804Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QS001_50411_201804Design getThis() {
    return this;
  }
}
