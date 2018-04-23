
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
 * 開発者: 
 * 作成日: 2016/09/14  日本コンピューター株式会社  新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム その他 (O)
 * プロセス 総合事業サービスコード一覧 (016)
 * プログラム 総合事業サービスコード一覧 (QO016)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qo.qo016;
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
 * 総合事業サービスコード一覧画面項目デザイン(QO016) 
 */
public class QO016Design extends QkanAffairContainer implements ACAffairable {
  //GUIコンポーネント

  private ACAffairButtonBar buttons;

  private ACAffairButton find;

  private ACAffairButton detail;

  private ACAffairButton insert;

  private ACAffairButton delete;

  private ACPanel sjServiceCodeInfoFind;

  private ACLabelContainer insurerContena;

  private ACTextField insurerNoText;

  private ACComboBox insurerNoCombo;

  private ACComboBoxModelAdapter insurerNoComboModel;

  private ACLabelContainer serviceCodeKindContena;

  private ACComboBox serviceCodeKindCombo;

  private ACComboBoxModelAdapter serviceCodeKindComboModel;

  private ACLabelContainer targetDateContena;

  private QkanYearDateTextField targetDate;

  private ACPanel comment;

  private ACLabel targetDateComment;

  private ACPanel sjServiceCodeInfos;

  private ACTable sjServiceCodeInfoTable;

  private VRTableColumnModel sjServiceCodeInfoTableColumnModel;

  private ACTableColumn sjServiceCodeTableColum1;

  private ACTableColumn sjServiceCodeTableColum2;

  private ACTableColumn sjServiceCodeTableColum3;

  private ACTableColumn sjServiceCodeTableColum4;

  private ACTableColumn sjServiceCodeTableColum5;

  private ACTableColumn sjServiceCodeTableColum6;

  private ACTableColumn sjServiceCodeTableColum7;

  //getter

  /**
   * ボタンバーを取得します。
   * @return ボタンバー
   */
  public ACAffairButtonBar getButtons(){
    if(buttons==null){

      buttons = new ACAffairButtonBar();

      buttons.setText("総合事業サービスコード一覧");

      addButtons();
    }
    return buttons;

  }

  /**
   * 検索(F)を取得します。
   * @return 検索(F)
   */
  public ACAffairButton getFind(){
    if(find==null){

      find = new ACAffairButton();

      find.setText("検索(F)");

      find.setToolTipText("総合事業サービスコード情報を検索します。");

      find.setMnemonic('F');

      find.setIconPath(ACConstants.ICON_PATH_FIND_24);

      addFind();
    }
    return find;

  }

  /**
   * 詳細(E)を取得します。
   * @return 詳細(E)
   */
  public ACAffairButton getDetail(){
    if(detail==null){

      detail = new ACAffairButton();

      detail.setText("詳細(E)");

      detail.setToolTipText("選択された総合事業サービスコードの編集画面へ移ります。");

      detail.setMnemonic('E');

      detail.setIconPath(ACConstants.ICON_PATH_DETAIL_24);

      addDetail();
    }
    return detail;

  }

  /**
   * 新規(N)を取得します。
   * @return 新規(N)
   */
  public ACAffairButton getInsert(){
    if(insert==null){

      insert = new ACAffairButton();

      insert.setText("新規(N)");

      insert.setToolTipText("総合事業サービスコードを新規に作成します。");

      insert.setMnemonic('N');

      insert.setIconPath(ACConstants.ICON_PATH_NEW_24);

      addInsert();
    }
    return insert;

  }

  /**
   * 削除(D)を取得します。
   * @return 削除(D)
   */
  public ACAffairButton getDelete(){
    if(delete==null){

      delete = new ACAffairButton();

      delete.setText("削除(D)");

      delete.setToolTipText("選択された総合事業サービスコードの情報を削除します。");

      delete.setMnemonic('D');

      delete.setIconPath(ACConstants.ICON_PATH_DELETE_24);

      addDelete();
    }
    return delete;

  }

  /**
   * 総合事業サービスコード情報検索領域を取得します。
   * @return 総合事業サービスコード情報検索領域
   */
  public ACPanel getSjServiceCodeInfoFind(){
    if(sjServiceCodeInfoFind==null){

      sjServiceCodeInfoFind = new ACPanel();

      sjServiceCodeInfoFind.setVgap(4);

      addSjServiceCodeInfoFind();
    }
    return sjServiceCodeInfoFind;

  }

  /**
   * 保険者番号・コンテナを取得します。
   * @return 保険者番号・コンテナ
   */
  public ACLabelContainer getInsurerContena(){
    if(insurerContena==null){

      insurerContena = new ACLabelContainer();

      insurerContena.setText("保険者番号");

      addInsurerContena();
    }
    return insurerContena;

  }

  /**
   * 保険者番号・テキストを取得します。
   * @return 保険者番号・テキスト
   */
  public ACTextField getInsurerNoText(){
    if(insurerNoText==null){

      insurerNoText = new ACTextField();

      insurerNoText.setBindPath("INSURER_ID");

      insurerNoText.setColumns(6);

      insurerNoText.setCharType(VRCharType.ONLY_DIGIT);

      insurerNoText.setIMEMode(InputSubset.LATIN);

      insurerNoText.setMaxLength(6);

      addInsurerNoText();
    }
    return insurerNoText;

  }

  /**
   * 保険者番号・コンボを取得します。
   * @return 保険者番号・コンボ
   */
  public ACComboBox getInsurerNoCombo(){
    if(insurerNoCombo==null){

      insurerNoCombo = new ACComboBox();

      insurerNoCombo.setBindPath("INSURER_NAME");

      insurerNoCombo.setEditable(false);

      insurerNoCombo.setModelBindPath("INSURER_ID");

      insurerNoCombo.setRenderBindPath("INSURER_NAME");

      insurerNoCombo.setModel(getInsurerNoComboModel());

      addInsurerNoCombo();
    }
    return insurerNoCombo;

  }

  /**
   * 保険者番号・コンボモデルを取得します。
   * @return 保険者番号・コンボモデル
   */
  protected ACComboBoxModelAdapter getInsurerNoComboModel(){
    if(insurerNoComboModel==null){
      insurerNoComboModel = new ACComboBoxModelAdapter();
      addInsurerNoComboModel();
    }
    return insurerNoComboModel;
  }

  /**
   * サービス種類・コンテナを取得します。
   * @return サービス種類・コンテナ
   */
  public ACLabelContainer getServiceCodeKindContena(){
    if(serviceCodeKindContena==null){

      serviceCodeKindContena = new ACLabelContainer();

      serviceCodeKindContena.setText("サービス種類");

      addServiceCodeKindContena();
    }
    return serviceCodeKindContena;

  }

  /**
   * サービス種類・コンボを取得します。
   * @return サービス種類・コンボ
   */
  public ACComboBox getServiceCodeKindCombo(){
    if(serviceCodeKindCombo==null){

      serviceCodeKindCombo = new ACComboBox();

      serviceCodeKindCombo.setBindPath("SERVICE_CODE_KIND");

      serviceCodeKindCombo.setEditable(false);

      serviceCodeKindCombo.setModelBindPath("SERVICE_CODE_KIND");

      serviceCodeKindCombo.setRenderBindPath("SERVICE_NAME");

      serviceCodeKindCombo.setBlankable(true);

      serviceCodeKindCombo.setModel(getServiceCodeKindComboModel());

      addServiceCodeKindCombo();
    }
    return serviceCodeKindCombo;

  }

  /**
   * サービス種類・コンボモデルを取得します。
   * @return サービス種類・コンボモデル
   */
  protected ACComboBoxModelAdapter getServiceCodeKindComboModel(){
    if(serviceCodeKindComboModel==null){
      serviceCodeKindComboModel = new ACComboBoxModelAdapter();
      addServiceCodeKindComboModel();
    }
    return serviceCodeKindComboModel;
  }

  /**
   * 対象年月・コンテナを取得します。
   * @return 対象年月・コンテナ
   */
  public ACLabelContainer getTargetDateContena(){
    if(targetDateContena==null){

      targetDateContena = new ACLabelContainer();

      targetDateContena.setText("対象年月");

      addTargetDateContena();
    }
    return targetDateContena;

  }

  /**
   * 対象年月を取得します。
   * @return 対象年月
   */
  public QkanYearDateTextField getTargetDate(){
    if(targetDate==null){

      targetDate = new QkanYearDateTextField();

      targetDate.setBindPath("TARGET_DATE");

      try{
        targetDate.setMinimumDate(QkanConstants.H3004);
      }catch(Throwable ex){
        ACCommon.getInstance().showExceptionMessage(new IllegalArgumentException("targetDate の最小年月日に不正な日付が指定されています。"));
      }

      addTargetDate();
    }
    return targetDate;

  }

  /**
   * コメント領域を取得します。
   * @return コメント領域
   */
  public ACPanel getComment(){
    if(comment==null){

      comment = new ACPanel();

      addComment();
    }
    return comment;

  }

  /**
   * 対象年月コメントを取得します。
   * @return 対象年月コメント
   */
  public ACLabel getTargetDateComment(){
    if(targetDateComment==null){

      targetDateComment = new ACLabel();

      targetDateComment.setText("（指定された年月時点で有効なデータを検索します）");

      targetDateComment.setAutoWrap(true);

      addTargetDateComment();
    }
    return targetDateComment;

  }

  /**
   * 総合事業サービスコード情報表示領域を取得します。
   * @return 総合事業サービスコード情報表示領域
   */
  public ACPanel getSjServiceCodeInfos(){
    if(sjServiceCodeInfos==null){

      sjServiceCodeInfos = new ACPanel();

      addSjServiceCodeInfos();
    }
    return sjServiceCodeInfos;

  }

  /**
   * 総合事業サービスコード情報テーブルを取得します。
   * @return 総合事業サービスコード情報テーブル
   */
  public ACTable getSjServiceCodeInfoTable(){
    if(sjServiceCodeInfoTable==null){

      sjServiceCodeInfoTable = new ACTable();

      sjServiceCodeInfoTable.setColumnModel(getSjServiceCodeInfoTableColumnModel());

      addSjServiceCodeInfoTable();
    }
    return sjServiceCodeInfoTable;

  }

  /**
   * 総合事業サービスコード情報テーブルカラムモデルを取得します。
   * @return 総合事業サービスコード情報テーブルカラムモデル
   */
  protected VRTableColumnModel getSjServiceCodeInfoTableColumnModel(){
    if(sjServiceCodeInfoTableColumnModel==null){
      sjServiceCodeInfoTableColumnModel = new VRTableColumnModel(new TableColumn[]{});
      addSjServiceCodeInfoTableColumnModel();
    }
    return sjServiceCodeInfoTableColumnModel;
  }

  /**
   * No.を取得します。
   * @return No.
   */
  public ACTableColumn getSjServiceCodeTableColum1(){
    if(sjServiceCodeTableColum1==null){

      sjServiceCodeTableColum1 = new ACTableColumn();

      sjServiceCodeTableColum1.setHeaderValue("No.");

      sjServiceCodeTableColum1.setColumnName("SYSTEM_SERVICE_CODE_ITEM");

      sjServiceCodeTableColum1.setColumns(3);

      sjServiceCodeTableColum1.setHorizontalAlignment(SwingConstants.LEFT);

      sjServiceCodeTableColum1.setRendererType(ACTableCellViewer.RENDERER_TYPE_SERIAL_NO);

      sjServiceCodeTableColum1.setSortable(false);

      addSjServiceCodeTableColum1();
    }
    return sjServiceCodeTableColum1;

  }

  /**
   * コードを取得します。
   * @return コード
   */
  public ACTableColumn getSjServiceCodeTableColum2(){
    if(sjServiceCodeTableColum2==null){

      sjServiceCodeTableColum2 = new ACTableColumn();

      sjServiceCodeTableColum2.setHeaderValue("コード");

      sjServiceCodeTableColum2.setColumnName("SERVICE_CODE");

      sjServiceCodeTableColum2.setColumns(6);

      sjServiceCodeTableColum2.setHorizontalAlignment(SwingConstants.LEFT);

      addSjServiceCodeTableColum2();
    }
    return sjServiceCodeTableColum2;

  }

  /**
   * 適用開始年月日を取得します。
   * @return 適用開始年月日
   */
  public ACTableColumn getSjServiceCodeTableColum3(){
    if(sjServiceCodeTableColum3==null){

      sjServiceCodeTableColum3 = new ACTableColumn();

      sjServiceCodeTableColum3.setHeaderValue("適用開始年月日");

      sjServiceCodeTableColum3.setColumnName("TEKIYO_ST_DATE");

      sjServiceCodeTableColum3.setColumns(10);

      sjServiceCodeTableColum3.setHorizontalAlignment(SwingConstants.LEFT);

      sjServiceCodeTableColum3.setFormat(new ACBorderBlankDateFormat("gggee年MM月dd日"));

      addSjServiceCodeTableColum3();
    }
    return sjServiceCodeTableColum3;

  }

  /**
   * 適用終了年月日を取得します。
   * @return 適用終了年月日
   */
  public ACTableColumn getSjServiceCodeTableColum4(){
    if(sjServiceCodeTableColum4==null){

      sjServiceCodeTableColum4 = new ACTableColumn();

      sjServiceCodeTableColum4.setHeaderValue("適用終了年月日");

      sjServiceCodeTableColum4.setColumnName("TEKIYO_ED_DATE");

      sjServiceCodeTableColum4.setColumns(10);

      sjServiceCodeTableColum4.setHorizontalAlignment(SwingConstants.LEFT);

      sjServiceCodeTableColum4.setFormat(new ACBorderBlankDateFormat("gggee年MM月dd日"));

      addSjServiceCodeTableColum4();
    }
    return sjServiceCodeTableColum4;

  }

  /**
   * サービス名称を取得します。
   * @return サービス名称
   */
  public ACTableColumn getSjServiceCodeTableColum5(){
    if(sjServiceCodeTableColum5==null){

      sjServiceCodeTableColum5 = new ACTableColumn();

      sjServiceCodeTableColum5.setHeaderValue("サービス名称");

      sjServiceCodeTableColum5.setColumnName("SERVICE_NAME");

      sjServiceCodeTableColum5.setColumns(32);

      sjServiceCodeTableColum5.setHorizontalAlignment(SwingConstants.LEFT);

      addSjServiceCodeTableColum5();
    }
    return sjServiceCodeTableColum5;

  }

  /**
   * 単位数を取得します。
   * @return 単位数
   */
  public ACTableColumn getSjServiceCodeTableColum6(){
    if(sjServiceCodeTableColum6==null){

      sjServiceCodeTableColum6 = new ACTableColumn();

      sjServiceCodeTableColum6.setHeaderValue("単位数");

      sjServiceCodeTableColum6.setColumnName("SERVICE_UNIT");

      sjServiceCodeTableColum6.setColumns(6);

      sjServiceCodeTableColum6.setHorizontalAlignment(SwingConstants.RIGHT);

      addSjServiceCodeTableColum6();
    }
    return sjServiceCodeTableColum6;

  }

  /**
   * 作成年月日を取得します。
   * @return 作成年月日
   */
  public ACTableColumn getSjServiceCodeTableColum7(){
    if(sjServiceCodeTableColum7==null){

      sjServiceCodeTableColum7 = new ACTableColumn();

      sjServiceCodeTableColum7.setHeaderValue("作成年月日");

      sjServiceCodeTableColum7.setColumnName("SAKUSEI_DATE");

      sjServiceCodeTableColum7.setColumns(10);

      sjServiceCodeTableColum7.setHorizontalAlignment(SwingConstants.LEFT);

      sjServiceCodeTableColum7.setFormat(new ACBorderBlankDateFormat("gggee年MM月dd日"));

      addSjServiceCodeTableColum7();
    }
    return sjServiceCodeTableColum7;

  }

  /**
   * コンストラクタです。
   */
  public QO016Design() {

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

    this.add(getSjServiceCodeInfoFind(), VRLayout.NORTH);

    this.add(getSjServiceCodeInfos(), VRLayout.CLIENT);

  }

  /**
   * ボタンバーに内部項目を追加します。
   */
  protected void addButtons(){

    buttons.add(getDelete(), VRLayout.EAST);
    buttons.add(getInsert(), VRLayout.EAST);
    buttons.add(getDetail(), VRLayout.EAST);
    buttons.add(getFind(), VRLayout.EAST);
  }

  /**
   * 検索(F)に内部項目を追加します。
   */
  protected void addFind(){

  }

  /**
   * 詳細(E)に内部項目を追加します。
   */
  protected void addDetail(){

  }

  /**
   * 新規(N)に内部項目を追加します。
   */
  protected void addInsert(){

  }

  /**
   * 削除(D)に内部項目を追加します。
   */
  protected void addDelete(){

  }

  /**
   * 総合事業サービスコード情報検索領域に内部項目を追加します。
   */
  protected void addSjServiceCodeInfoFind(){

    sjServiceCodeInfoFind.add(getInsurerContena(), VRLayout.FLOW_INSETLINE_RETURN);

    sjServiceCodeInfoFind.add(getServiceCodeKindContena(), VRLayout.FLOW_INSETLINE_RETURN);

    sjServiceCodeInfoFind.add(getTargetDateContena(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * 保険者番号・コンテナに内部項目を追加します。
   */
  protected void addInsurerContena(){

    insurerContena.add(getInsurerNoText(), VRLayout.FLOW);

    insurerContena.add(getInsurerNoCombo(), VRLayout.FLOW);

  }

  /**
   * 保険者番号・テキストに内部項目を追加します。
   */
  protected void addInsurerNoText(){

  }

  /**
   * 保険者番号・コンボに内部項目を追加します。
   */
  protected void addInsurerNoCombo(){

  }

  /**
   * 保険者番号・コンボモデルに内部項目を追加します。
   */
  protected void addInsurerNoComboModel(){

  }

  /**
   * サービス種類・コンテナに内部項目を追加します。
   */
  protected void addServiceCodeKindContena(){

    serviceCodeKindContena.add(getServiceCodeKindCombo(), VRLayout.FLOW);

  }

  /**
   * サービス種類・コンボに内部項目を追加します。
   */
  protected void addServiceCodeKindCombo(){

  }

  /**
   * サービス種類・コンボモデルに内部項目を追加します。
   */
  protected void addServiceCodeKindComboModel(){

  }

  /**
   * 対象年月・コンテナに内部項目を追加します。
   */
  protected void addTargetDateContena(){

    targetDateContena.add(getTargetDate(), VRLayout.FLOW);

    targetDateContena.add(getComment(), VRLayout.FLOW_RETURN);

  }

  /**
   * 対象年月に内部項目を追加します。
   */
  protected void addTargetDate(){

  }

  /**
   * コメント領域に内部項目を追加します。
   */
  protected void addComment(){

    comment.add(getTargetDateComment(), VRLayout.NORTH);

  }

  /**
   * 対象年月コメントに内部項目を追加します。
   */
  protected void addTargetDateComment(){

  }

  /**
   * 総合事業サービスコード情報表示領域に内部項目を追加します。
   */
  protected void addSjServiceCodeInfos(){

    sjServiceCodeInfos.add(getSjServiceCodeInfoTable(), VRLayout.CLIENT);

  }

  /**
   * 総合事業サービスコード情報テーブルに内部項目を追加します。
   */
  protected void addSjServiceCodeInfoTable(){

  }

  /**
   * 総合事業サービスコード情報テーブルカラムモデルに内部項目を追加します。
   */
  protected void addSjServiceCodeInfoTableColumnModel(){

    getSjServiceCodeInfoTableColumnModel().addColumn(getSjServiceCodeTableColum1());

    getSjServiceCodeInfoTableColumnModel().addColumn(getSjServiceCodeTableColum2());

    getSjServiceCodeInfoTableColumnModel().addColumn(getSjServiceCodeTableColum3());

    getSjServiceCodeInfoTableColumnModel().addColumn(getSjServiceCodeTableColum4());

    getSjServiceCodeInfoTableColumnModel().addColumn(getSjServiceCodeTableColum5());

    getSjServiceCodeInfoTableColumnModel().addColumn(getSjServiceCodeTableColum6());

    getSjServiceCodeInfoTableColumnModel().addColumn(getSjServiceCodeTableColum7());

  }

  /**
   * No.に内部項目を追加します。
   */
  protected void addSjServiceCodeTableColum1(){

  }

  /**
   * コードに内部項目を追加します。
   */
  protected void addSjServiceCodeTableColum2(){

  }

  /**
   * 適用開始年月日に内部項目を追加します。
   */
  protected void addSjServiceCodeTableColum3(){

  }

  /**
   * 適用終了年月日に内部項目を追加します。
   */
  protected void addSjServiceCodeTableColum4(){

  }

  /**
   * サービス名称に内部項目を追加します。
   */
  protected void addSjServiceCodeTableColum5(){

  }

  /**
   * 単位数に内部項目を追加します。
   */
  protected void addSjServiceCodeTableColum6(){

  }

  /**
   * 作成年月日に内部項目を追加します。
   */
  protected void addSjServiceCodeTableColum7(){

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

    return getInsurerNoText();

  }
  public void initAffair(ACAffairInfo affair) throws Exception {
  }

  public static void main(String[] args) {
    //デフォルトデバッグ起動
    try {
      ACFrame.getInstance().setFrameEventProcesser(new QkanFrameEventProcesser());
      ACFrame.debugStart(new ACAffairInfo(QO016Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QO016Design getThis() {
    return this;
  }
}
