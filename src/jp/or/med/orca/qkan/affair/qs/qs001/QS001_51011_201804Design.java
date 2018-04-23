
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
 * プログラム サービスパターンその他の生活支援サービス(配食定額) (QS001_51011_201804)
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
 * サービスパターンその他の生活支援サービス(配食定額)画面項目デザイン(QS001_51011_201804) 
 */
public class QS001_51011_201804Design extends QS001ServicePanelSogo {
  //GUIコンポーネント

  private ACPanel soAAPatterns;

  private ACPanel soAADetail;

  private ACBackLabelContainer soAATimeContena;

  private ACTimeComboBox soAABeginTime;

  private ACLabelContainer soAABeginTimeContainer;

  private ACComboBoxModelAdapter soAABeginTimeModel;

  private ACTimeComboBox soAAEndTime;

  private ACLabelContainer soAAEndTimeContainer;

  private ACComboBoxModelAdapter soAAEndTimeModel;

  private ACComboBox insurerName;

  private ACLabelContainer insurerNameContainer;

  private ACComboBoxModelAdapter insurerNameModel;

  private ACBackLabelContainer soAAItemCodeContena;

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
   * その他の生活支援サービス配食定額パターン領域を取得します。
   * @return その他の生活支援サービス配食定額パターン領域
   */
  public ACPanel getSoAAPatterns(){
    if(soAAPatterns==null){

      soAAPatterns = new ACPanel();

      soAAPatterns.setAutoWrap(false);

      addSoAAPatterns();
    }
    return soAAPatterns;

  }

  /**
   * 内容パネルを取得します。
   * @return 内容パネル
   */
  public ACPanel getSoAADetail(){
    if(soAADetail==null){

      soAADetail = new ACPanel();

      soAADetail.setHgrid(200);

      addSoAADetail();
    }
    return soAADetail;

  }

  /**
   * 提供時間コンテナを取得します。
   * @return 提供時間コンテナ
   */
  public ACBackLabelContainer getSoAATimeContena(){
    if(soAATimeContena==null){

      soAATimeContena = new ACBackLabelContainer();

      addSoAATimeContena();
    }
    return soAATimeContena;

  }

  /**
   * 開始時刻コンボを取得します。
   * @return 開始時刻コンボ
   */
  public ACTimeComboBox getSoAABeginTime(){
    if(soAABeginTime==null){

      soAABeginTime = new ACTimeComboBox();

      getSoAABeginTimeContainer().setText("開始時刻");

      soAABeginTime.setBindPath("3");

      soAABeginTime.setModelBindPath("3");

      soAABeginTime.setRenderBindPath("CONTENT");

      soAABeginTime.setModel(getSoAABeginTimeModel());

      addSoAABeginTime();
    }
    return soAABeginTime;

  }

  /**
   * 開始時刻コンボコンテナを取得します。
   * @return 開始時刻コンボコンテナ
   */
  protected ACLabelContainer getSoAABeginTimeContainer(){
    if(soAABeginTimeContainer==null){
      soAABeginTimeContainer = new ACLabelContainer();
      soAABeginTimeContainer.setFollowChildEnabled(true);
      soAABeginTimeContainer.setVAlignment(VRLayout.CENTER);
      soAABeginTimeContainer.add(getSoAABeginTime(), null);
    }
    return soAABeginTimeContainer;
  }

  /**
   * 開始時刻コンボモデルを取得します。
   * @return 開始時刻コンボモデル
   */
  protected ACComboBoxModelAdapter getSoAABeginTimeModel(){
    if(soAABeginTimeModel==null){
      soAABeginTimeModel = new ACComboBoxModelAdapter();
      addSoAABeginTimeModel();
    }
    return soAABeginTimeModel;
  }

  /**
   * 終了時刻コンボを取得します。
   * @return 終了時刻コンボ
   */
  public ACTimeComboBox getSoAAEndTime(){
    if(soAAEndTime==null){

      soAAEndTime = new ACTimeComboBox();

      getSoAAEndTimeContainer().setText("終了時刻");

      soAAEndTime.setBindPath("4");

      soAAEndTime.setModelBindPath("4");

      soAAEndTime.setRenderBindPath("CONTENT");

      soAAEndTime.setModel(getSoAAEndTimeModel());

      addSoAAEndTime();
    }
    return soAAEndTime;

  }

  /**
   * 終了時刻コンボコンテナを取得します。
   * @return 終了時刻コンボコンテナ
   */
  protected ACLabelContainer getSoAAEndTimeContainer(){
    if(soAAEndTimeContainer==null){
      soAAEndTimeContainer = new ACLabelContainer();
      soAAEndTimeContainer.setFollowChildEnabled(true);
      soAAEndTimeContainer.setVAlignment(VRLayout.CENTER);
      soAAEndTimeContainer.add(getSoAAEndTime(), null);
    }
    return soAAEndTimeContainer;
  }

  /**
   * 終了時刻コンボモデルを取得します。
   * @return 終了時刻コンボモデル
   */
  protected ACComboBoxModelAdapter getSoAAEndTimeModel(){
    if(soAAEndTimeModel==null){
      soAAEndTimeModel = new ACComboBoxModelAdapter();
      addSoAAEndTimeModel();
    }
    return soAAEndTimeModel;
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
  public ACBackLabelContainer getSoAAItemCodeContena(){
    if(soAAItemCodeContena==null){

      soAAItemCodeContena = new ACBackLabelContainer();

      addSoAAItemCodeContena();
    }
    return soAAItemCodeContena;

  }

  /**
   * サービス項目コードテキストを取得します。
   * @return サービス項目コードテキスト
   */
  public ACTextField getItemCodeText(){
    if(itemCodeText==null){

      itemCodeText = new ACTextField();

      getItemCodeTextContainer().setText("AA");

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
  public QS001_51011_201804Design() {

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

    this.add(getSoAAPatterns(), VRLayout.WEST);

  }

  /**
   * その他の生活支援サービス配食定額パターン領域に内部項目を追加します。
   */
  protected void addSoAAPatterns(){

    soAAPatterns.add(getSoAADetail(), VRLayout.NORTH);

    soAAPatterns.add(getInfoGroup(), VRLayout.FLOW);

  }

  /**
   * 内容パネルに内部項目を追加します。
   */
  protected void addSoAADetail(){

    soAADetail.add(getSoAATimeContena(), VRLayout.FLOW_DOUBLEINSETLINE_RETURN);

    soAADetail.add(getInsurerNameContainer(), VRLayout.FLOW_INSETLINE);

    soAADetail.add(getSoAAItemCodeContena(), VRLayout.FLOW_DOUBLEINSETLINE_RETURN);

    soAADetail.add(getCodeFindButton(), VRLayout.FLOW);

    soAADetail.add(getDeleteCodeButton(), VRLayout.FLOW_RETURN);

    soAADetail.add(getSvCodeTable(), VRLayout.FLOW_RETURN);

  }

  /**
   * 提供時間コンテナに内部項目を追加します。
   */
  protected void addSoAATimeContena(){

    soAATimeContena.add(getSoAABeginTimeContainer(), VRLayout.FLOW);

    soAATimeContena.add(getSoAAEndTimeContainer(), VRLayout.FLOW);

  }

  /**
   * 開始時刻コンボに内部項目を追加します。
   */
  protected void addSoAABeginTime(){

  }

  /**
   * 開始時刻コンボモデルに内部項目を追加します。
   */
  protected void addSoAABeginTimeModel(){

  }

  /**
   * 終了時刻コンボに内部項目を追加します。
   */
  protected void addSoAAEndTime(){

  }

  /**
   * 終了時刻コンボモデルに内部項目を追加します。
   */
  protected void addSoAAEndTimeModel(){

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
  protected void addSoAAItemCodeContena(){

    soAAItemCodeContena.add(getItemCodeTextContainer(), VRLayout.FLOW);

    soAAItemCodeContena.add(getAddCodeToListButton(), VRLayout.FLOW);

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
      ACFrame.debugStart(new ACAffairInfo(QS001_51011_201804Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QS001_51011_201804Design getThis() {
    return this;
  }
}
