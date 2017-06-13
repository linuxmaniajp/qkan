
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
 * 作成日: 2016/10/27  日本コンピューター株式会社 樋口　雅彦 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 予定管理 (S)
 * プロセス サービス予定 (001)
 * プログラム 計画単位数編集画面 (QS001004)
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
 * 計画単位数編集画面画面項目デザイン(QS001004) 
 */
public class QS001004Design extends QkanAffairDialog {
  //GUIコンポーネント

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
   * 計画単位数情報1を取得します。
   * @return 計画単位数情報1
   */
  public ACLabel getInformation1(){
    if(information1==null){

      information1 = new ACLabel();

      information1.setText("実績と計画単位数が異なる場合、計画単位数をこの画面で入力してください。");

      information1.setForeground(Color.red);

      information1.setAutoWrap(true);

      addInformation1();
    }
    return information1;

  }

  /**
   * 計画単位数情報2を取得します。
   * @return 計画単位数情報2
   */
  public ACLabel getInformation2(){
    if(information2==null){

      information2 = new ACLabel();

      information2.setText("計画単位数が未入力の場合は予定の情報を、予定が存在しない場合は実績の情報をもとに計画単位数を計算します。");

      information2.setVisible(false);

      information2.setAutoWrap(true);

      addInformation2();
    }
    return information2;

  }

  /**
   * 対象事業所を取得します。
   * @return 対象事業所
   */
  public ACComboBox getProvider(){
    if(provider==null){

      provider = new ACComboBox();

      getProviderContainer().setText("事業所");

      provider.setBindPath("PROVIDER_ID");

      provider.setEditable(false);

      provider.setRenderBindPath("SHOW_PROVIDER_NAME");

      provider.setModel(getProviderModel());

      addProvider();
    }
    return provider;

  }

  /**
   * 対象事業所コンテナを取得します。
   * @return 対象事業所コンテナ
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
   * 対象事業所モデルを取得します。
   * @return 対象事業所モデル
   */
  protected ACComboBoxModelAdapter getProviderModel(){
    if(providerModel==null){
      providerModel = new ACComboBoxModelAdapter();
      addProviderModel();
    }
    return providerModel;
  }

  /**
   * 計画単位数テーブルを取得します。
   * @return 計画単位数テーブル
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
   * 計画単位数テーブルカラムモデルを取得します。
   * @return 計画単位数テーブルカラムモデル
   */
  protected VRTableColumnModel getPlanUnitTableColumnModel(){
    if(planUnitTableColumnModel==null){
      planUnitTableColumnModel = new VRTableColumnModel(new TableColumn[]{});
      addPlanUnitTableColumnModel();
    }
    return planUnitTableColumnModel;
  }

  /**
   * No.を取得します。
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
   * サービス種類を取得します。
   * @return サービス種類
   */
  public ACTableColumn getPlanUnitTableServiceName(){
    if(planUnitTableServiceName==null){

      planUnitTableServiceName = new ACTableColumn();

      planUnitTableServiceName.setHeaderValue("サービス種類");

      planUnitTableServiceName.setColumnName("SERVICE_KIND_NAME");

      planUnitTableServiceName.setColumns(24);

      planUnitTableServiceName.setFormat(QkanServiceKindNameFormat.getInstance());

      addPlanUnitTableServiceName();
    }
    return planUnitTableServiceName;

  }

  /**
   * 計画単位数を取得します。
   * @return 計画単位数
   */
  public ACTableColumn getPlanUnitTableUnit(){
    if(planUnitTableUnit==null){

      planUnitTableUnit = new ACTableColumn();

      planUnitTableUnit.setHeaderValue("計画単位数");

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
   * 決定を取得します。
   * @return 決定
   */
  public ACButton getOk(){
    if(ok==null){

      ok = new ACButton();

      ok.setText("OK");

      ok.setToolTipText("入力された情報で計画単位数を更新します。");

      ok.setMnemonic('O');

      ok.setIconPath(ACConstants.ICON_PATH_OK_16);

      addOk();
    }
    return ok;

  }

  /**
   * 閉じるを取得します。
   * @return 閉じる
   */
  public ACButton getClose(){
    if(close==null){

      close = new ACButton();

      close.setText("キャンセル(C)");

      close.setToolTipText("計画単位数の更新は行わず、前の画面に戻ります。");

      close.setMnemonic('C');

      close.setIconPath(ACConstants.ICON_PATH_CANCEL_16);

      addClose();
    }
    return close;

  }

  /**
   * コンストラクタです。
   */
  public QS001004Design() {

    super(ACFrame.getInstance(), true);
    this.getContentPane().setLayout(new VRLayout());
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    try {
      initialize();

      setSize(450, 420);

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

    this.getContentPane().add(getButtons(), VRLayout.SOUTH);
  }

  /**
   * クライアント領域に内部項目を追加します。
   */
  protected void addContents(){

    contents.add(getInformation1(), VRLayout.NORTH);

    contents.add(getInformation2(), VRLayout.NORTH);

    contents.add(getProviderContainer(), VRLayout.NORTH);

    contents.add(getPlanUnitTable(), VRLayout.CLIENT);

  }

  /**
   * 計画単位数情報1に内部項目を追加します。
   */
  protected void addInformation1(){

  }

  /**
   * 計画単位数情報2に内部項目を追加します。
   */
  protected void addInformation2(){

  }

  /**
   * 対象事業所に内部項目を追加します。
   */
  protected void addProvider(){

  }

  /**
   * 対象事業所モデルに内部項目を追加します。
   */
  protected void addProviderModel(){

  }

  /**
   * 計画単位数テーブルに内部項目を追加します。
   */
  protected void addPlanUnitTable(){

  }

  /**
   * 計画単位数テーブルカラムモデルに内部項目を追加します。
   */
  protected void addPlanUnitTableColumnModel(){

    getPlanUnitTableColumnModel().addColumn(getPlanUnitTableNo());

    getPlanUnitTableColumnModel().addColumn(getPlanUnitTableServiceName());

    getPlanUnitTableColumnModel().addColumn(getPlanUnitTableUnit());

  }

  /**
   * No.に内部項目を追加します。
   */
  protected void addPlanUnitTableNo(){

  }

  /**
   * サービス種類に内部項目を追加します。
   */
  protected void addPlanUnitTableServiceName(){

  }

  /**
   * 計画単位数に内部項目を追加します。
   */
  protected void addPlanUnitTableUnit(){

  }

  /**
   * ボタン領域に内部項目を追加します。
   */
  protected void addButtons(){

    buttons.add(getClose(), VRLayout.EAST);
    buttons.add(getOk(), VRLayout.EAST);
  }

  /**
   * 決定に内部項目を追加します。
   */
  protected void addOk(){

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
      new QS001004Design().setVisible(true);
      System.exit(0);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QS001004Design getThis() {
    return this;
  }
}
