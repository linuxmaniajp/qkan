
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
 * 開発者: 小笠　貴志
 * 作成日: 2006/02/28  日本コンピューター株式会社 小笠　貴志 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 予定管理 (S)
 * プロセス サービス予定 (001)
 * プログラム サービスパターン主な日常生活上の活動 (QS001027)
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
import jp.or.med.orca.qkan.lib.*;
import jp.or.med.orca.qkan.text.*;
/**
 * サービスパターン主な日常生活上の活動画面項目デザイン(QS001027) 
 */
public class QS001027Design extends QS001ServicePanel {
  //GUIコンポーネント

  private ACPanel etcContentDetailPatterns;

  private ACPanel etcContentDetail;

  private ACBackLabelContainer etcContentDetailTimeContena;

  private ACTimeComboBox etcContentDetailBeginTime;

  private ACLabelContainer etcContentDetailBeginTimeContainer;

  private ACComboBoxModelAdapter etcContentDetailBeginTimeModel;

  private ACTimeComboBox etcContentDetailEndTime;

  private ACLabelContainer etcContentDetailEndTimeContainer;

  private ACComboBoxModelAdapter etcContentDetailEndTimeModel;

  private QS001OtherItemListBox etcContentDetailIList;

  private ACLabelContainer etcContentDetailIListContainer;

  private ACListModelAdapter etcContentDetailIListModel;

  private ACTextField etcContentDetailInput;

  private ACLabelContainer etcContentDetailInputContainer;

  private ACButton etcContentInsertButton;

  private ACButton etcContentFindButton;

  private ACButton etcContentDeleteButton;

  //getter

  /**
   * その他内容詳細パターン領域を取得します。
   * @return その他内容詳細パターン領域
   */
  public ACPanel getEtcContentDetailPatterns(){
    if(etcContentDetailPatterns==null){

      etcContentDetailPatterns = new ACPanel();

      etcContentDetailPatterns.setAutoWrap(false);

      addEtcContentDetailPatterns();
    }
    return etcContentDetailPatterns;

  }

  /**
   * 内容パネルを取得します。
   * @return 内容パネル
   */
  public ACPanel getEtcContentDetail(){
    if(etcContentDetail==null){

      etcContentDetail = new ACPanel();

      etcContentDetail.setHgrid(200);

      addEtcContentDetail();
    }
    return etcContentDetail;

  }

  /**
   * 提供時間コンテナを取得します。
   * @return 提供時間コンテナ
   */
  public ACBackLabelContainer getEtcContentDetailTimeContena(){
    if(etcContentDetailTimeContena==null){

      etcContentDetailTimeContena = new ACBackLabelContainer();

      addEtcContentDetailTimeContena();
    }
    return etcContentDetailTimeContena;

  }

  /**
   * 開始時刻コンボを取得します。
   * @return 開始時刻コンボ
   */
  public ACTimeComboBox getEtcContentDetailBeginTime(){
    if(etcContentDetailBeginTime==null){

      etcContentDetailBeginTime = new ACTimeComboBox();

      getEtcContentDetailBeginTimeContainer().setText("開始時刻");

      etcContentDetailBeginTime.setBindPath("3");

      etcContentDetailBeginTime.setModelBindPath("3");

      etcContentDetailBeginTime.setModel(getEtcContentDetailBeginTimeModel());

      etcContentDetailBeginTime.setRenderBindPath("CONTENT");

      addEtcContentDetailBeginTime();
    }
    return etcContentDetailBeginTime;

  }

  /**
   * 開始時刻コンボコンテナを取得します。
   * @return 開始時刻コンボコンテナ
   */
  protected ACLabelContainer getEtcContentDetailBeginTimeContainer(){
    if(etcContentDetailBeginTimeContainer==null){
      etcContentDetailBeginTimeContainer = new ACLabelContainer();
      etcContentDetailBeginTimeContainer.setFollowChildEnabled(true);
      etcContentDetailBeginTimeContainer.setVAlignment(VRLayout.CENTER);
      etcContentDetailBeginTimeContainer.add(getEtcContentDetailBeginTime(), null);
    }
    return etcContentDetailBeginTimeContainer;
  }

  /**
   * 開始時刻コンボモデルを取得します。
   * @return 開始時刻コンボモデル
   */
  protected ACComboBoxModelAdapter getEtcContentDetailBeginTimeModel(){
    if(etcContentDetailBeginTimeModel==null){
      etcContentDetailBeginTimeModel = new ACComboBoxModelAdapter();
      addEtcContentDetailBeginTimeModel();
    }
    return etcContentDetailBeginTimeModel;
  }

  /**
   * 終了時刻コンボを取得します。
   * @return 終了時刻コンボ
   */
  public ACTimeComboBox getEtcContentDetailEndTime(){
    if(etcContentDetailEndTime==null){

      etcContentDetailEndTime = new ACTimeComboBox();

      getEtcContentDetailEndTimeContainer().setText("終了時刻");

      etcContentDetailEndTime.setBindPath("4");

      etcContentDetailEndTime.setModelBindPath("4");

      etcContentDetailEndTime.setModel(getEtcContentDetailEndTimeModel());

      etcContentDetailEndTime.setRenderBindPath("CONTENT");

      addEtcContentDetailEndTime();
    }
    return etcContentDetailEndTime;

  }

  /**
   * 終了時刻コンボコンテナを取得します。
   * @return 終了時刻コンボコンテナ
   */
  protected ACLabelContainer getEtcContentDetailEndTimeContainer(){
    if(etcContentDetailEndTimeContainer==null){
      etcContentDetailEndTimeContainer = new ACLabelContainer();
      etcContentDetailEndTimeContainer.setFollowChildEnabled(true);
      etcContentDetailEndTimeContainer.setVAlignment(VRLayout.CENTER);
      etcContentDetailEndTimeContainer.add(getEtcContentDetailEndTime(), null);
    }
    return etcContentDetailEndTimeContainer;
  }

  /**
   * 終了時刻コンボモデルを取得します。
   * @return 終了時刻コンボモデル
   */
  protected ACComboBoxModelAdapter getEtcContentDetailEndTimeModel(){
    if(etcContentDetailEndTimeModel==null){
      etcContentDetailEndTimeModel = new ACComboBoxModelAdapter();
      addEtcContentDetailEndTimeModel();
    }
    return etcContentDetailEndTimeModel;
  }

  /**
   * 内容詳細リストを取得します。
   * @return 内容詳細リスト
   */
  public QS001OtherItemListBox getEtcContentDetailIList(){
    if(etcContentDetailIList==null){

      etcContentDetailIList = new QS001OtherItemListBox();

      getEtcContentDetailIListContainer().setText("入力候補");

      etcContentDetailIList.setBindPath("dummy");

      etcContentDetailIList.setColumns(12);

      etcContentDetailIList.setModel(getEtcContentDetailIListModel());

      etcContentDetailIList.setVisibleRowCount(11);

      addEtcContentDetailIList();
    }
    return etcContentDetailIList;

  }

  /**
   * 内容詳細リストコンテナを取得します。
   * @return 内容詳細リストコンテナ
   */
  protected ACLabelContainer getEtcContentDetailIListContainer(){
    if(etcContentDetailIListContainer==null){
      etcContentDetailIListContainer = new ACLabelContainer();
      etcContentDetailIListContainer.setFollowChildEnabled(true);
      etcContentDetailIListContainer.setVAlignment(VRLayout.CENTER);
      etcContentDetailIListContainer.add(getEtcContentDetailIList(), null);
    }
    return etcContentDetailIListContainer;
  }

  /**
   * 内容詳細リストモデルを取得します。
   * @return 内容詳細リストモデル
   */
  protected ACListModelAdapter getEtcContentDetailIListModel(){
    if(etcContentDetailIListModel==null){
      etcContentDetailIListModel = new ACListModelAdapter();
      addEtcContentDetailIListModel();
    }
    return etcContentDetailIListModel;
  }

  /**
   * 内容詳細テキストを取得します。
   * @return 内容詳細テキスト
   */
  public ACTextField getEtcContentDetailInput(){
    if(etcContentDetailInput==null){

      etcContentDetailInput = new ACTextField();

      getEtcContentDetailInputContainer().setText("内容詳細");

      etcContentDetailInput.setBindPath("9020101");

      etcContentDetailInput.setColumns(11);

      etcContentDetailInput.setIMEMode(InputSubset.KANJI);

      etcContentDetailInput.setMaxLength(10);

      addEtcContentDetailInput();
    }
    return etcContentDetailInput;

  }

  /**
   * 内容詳細テキストコンテナを取得します。
   * @return 内容詳細テキストコンテナ
   */
  protected ACLabelContainer getEtcContentDetailInputContainer(){
    if(etcContentDetailInputContainer==null){
      etcContentDetailInputContainer = new ACLabelContainer();
      etcContentDetailInputContainer.setFollowChildEnabled(true);
      etcContentDetailInputContainer.setVAlignment(VRLayout.CENTER);
      etcContentDetailInputContainer.add(getEtcContentDetailInput(), null);
    }
    return etcContentDetailInputContainer;
  }

  /**
   * 追加を取得します。
   * @return 追加
   */
  public ACButton getEtcContentInsertButton(){
    if(etcContentInsertButton==null){

      etcContentInsertButton = new ACButton();

      etcContentInsertButton.setText("追加");

      addEtcContentInsertButton();
    }
    return etcContentInsertButton;

  }

  /**
   * 編集を取得します。
   * @return 編集
   */
  public ACButton getEtcContentFindButton(){
    if(etcContentFindButton==null){

      etcContentFindButton = new ACButton();

      etcContentFindButton.setText("編集");

      addEtcContentFindButton();
    }
    return etcContentFindButton;

  }

  /**
   * 削除を取得します。
   * @return 削除
   */
  public ACButton getEtcContentDeleteButton(){
    if(etcContentDeleteButton==null){

      etcContentDeleteButton = new ACButton();

      etcContentDeleteButton.setText("削除");

      addEtcContentDeleteButton();
    }
    return etcContentDeleteButton;

  }

  /**
   * コンストラクタです。
   */
  public QS001027Design() {

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

    this.add(getEtcContentDetailPatterns(), VRLayout.WEST);

  }

  /**
   * その他内容詳細パターン領域に内部項目を追加します。
   */
  protected void addEtcContentDetailPatterns(){

    etcContentDetailPatterns.add(getEtcContentDetail(), VRLayout.NORTH);

  }

  /**
   * 内容パネルに内部項目を追加します。
   */
  protected void addEtcContentDetail(){

    etcContentDetail.add(getEtcContentDetailTimeContena(), VRLayout.FLOW_DOUBLEINSETLINE_RETURN);

    etcContentDetail.add(getEtcContentDetailIListContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    etcContentDetail.add(getEtcContentDetailInputContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    etcContentDetail.add(getEtcContentInsertButton(), VRLayout.FLOW);

    etcContentDetail.add(getEtcContentFindButton(), VRLayout.FLOW);

    etcContentDetail.add(getEtcContentDeleteButton(), VRLayout.FLOW);

  }

  /**
   * 提供時間コンテナに内部項目を追加します。
   */
  protected void addEtcContentDetailTimeContena(){

    etcContentDetailTimeContena.add(getEtcContentDetailBeginTimeContainer(), VRLayout.FLOW);

    etcContentDetailTimeContena.add(getEtcContentDetailEndTimeContainer(), VRLayout.FLOW);

  }

  /**
   * 開始時刻コンボに内部項目を追加します。
   */
  protected void addEtcContentDetailBeginTime(){

  }

  /**
   * 開始時刻コンボモデルに内部項目を追加します。
   */
  protected void addEtcContentDetailBeginTimeModel(){

  }

  /**
   * 終了時刻コンボに内部項目を追加します。
   */
  protected void addEtcContentDetailEndTime(){

  }

  /**
   * 終了時刻コンボモデルに内部項目を追加します。
   */
  protected void addEtcContentDetailEndTimeModel(){

  }

  /**
   * 内容詳細リストに内部項目を追加します。
   */
  protected void addEtcContentDetailIList(){

  }

  /**
   * 内容詳細リストモデルに内部項目を追加します。
   */
  protected void addEtcContentDetailIListModel(){

  }

  /**
   * 内容詳細テキストに内部項目を追加します。
   */
  protected void addEtcContentDetailInput(){

  }

  /**
   * 追加に内部項目を追加します。
   */
  protected void addEtcContentInsertButton(){

  }

  /**
   * 編集に内部項目を追加します。
   */
  protected void addEtcContentFindButton(){

  }

  /**
   * 削除に内部項目を追加します。
   */
  protected void addEtcContentDeleteButton(){

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
      ACFrame.setVRLookAndFeel();
      ACFrame.getInstance().setFrameEventProcesser(new QkanFrameEventProcesser());
      ACFrame.debugStart(new ACAffairInfo(QS001027Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QS001027Design getThis() {
    return this;
  }
}
