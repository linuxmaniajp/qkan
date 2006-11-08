
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
 * 開発者: 松本　幸一
 * 作成日: 2006/03/05  日本コンピューター株式会社 松本　幸一 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム その他機能 (O)
 * プロセス 事業者登録 (004)
 * プログラム 居宅介護支援 (QO004117)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qo.qo004;
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
import jp.or.med.orca.qkan.affair.qs.qs001.QS001ServicePanel;
import jp.or.med.orca.qkan.component.*;
import jp.or.med.orca.qkan.text.*;
/**
 * 居宅介護支援画面項目デザイン(QO004117) 
 */
public class QO004117Design extends QS001ServicePanel {
  //GUIコンポーネント

  private ACGroupBox mainGroup;

  private ACClearableRadioButtonGroup specificProviderAdd;

  private ACLabelContainer specificProviderAddContainer;

  private ACListModelAdapter specificProviderAddModel;

  private ACRadioButtonItem specificProviderAddItem1;

  private ACRadioButtonItem specificProviderAddItem2;

  //getter

  /**
   * 事業グループを取得します。
   * @return 事業グループ
   */
  public ACGroupBox getMainGroup(){
    if(mainGroup==null){

      mainGroup = new ACGroupBox();

      mainGroup.setText("居宅介護支援");

      mainGroup.setFollowChildEnabled(true);

      mainGroup.setHgrid(200);

      addMainGroup();
    }
    return mainGroup;

  }

  /**
   * 特定体制整備事業所加算の有無を取得します。
   * @return 特定体制整備事業所加算の有無
   */
  public ACClearableRadioButtonGroup getSpecificProviderAdd(){
    if(specificProviderAdd==null){

      specificProviderAdd = new ACClearableRadioButtonGroup();

      getSpecificProviderAddContainer().setText("特定体制整備事業所加算の有無");

      specificProviderAdd.setBindPath("1430103");

      specificProviderAdd.setModel(getSpecificProviderAddModel());

      specificProviderAdd.setUseClearButton(false);

      addSpecificProviderAdd();
    }
    return specificProviderAdd;

  }

  /**
   * 特定体制整備事業所加算の有無コンテナを取得します。
   * @return 特定体制整備事業所加算の有無コンテナ
   */
  protected ACLabelContainer getSpecificProviderAddContainer(){
    if(specificProviderAddContainer==null){
      specificProviderAddContainer = new ACLabelContainer();
      specificProviderAddContainer.setFollowChildEnabled(true);
      specificProviderAddContainer.setVAlignment(VRLayout.CENTER);
      specificProviderAddContainer.add(getSpecificProviderAdd(), null);
    }
    return specificProviderAddContainer;
  }

  /**
   * 特定体制整備事業所加算の有無モデルを取得します。
   * @return 特定体制整備事業所加算の有無モデル
   */
  protected ACListModelAdapter getSpecificProviderAddModel(){
    if(specificProviderAddModel==null){
      specificProviderAddModel = new ACListModelAdapter();
      addSpecificProviderAddModel();
    }
    return specificProviderAddModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getSpecificProviderAddItem1(){
    if(specificProviderAddItem1==null){

      specificProviderAddItem1 = new ACRadioButtonItem();

      specificProviderAddItem1.setText("なし");

      specificProviderAddItem1.setGroup(getSpecificProviderAdd());

      specificProviderAddItem1.setConstraints(VRLayout.FLOW);

      addSpecificProviderAddItem1();
    }
    return specificProviderAddItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getSpecificProviderAddItem2(){
    if(specificProviderAddItem2==null){

      specificProviderAddItem2 = new ACRadioButtonItem();

      specificProviderAddItem2.setText("あり");

      specificProviderAddItem2.setGroup(getSpecificProviderAdd());

      specificProviderAddItem2.setConstraints(VRLayout.FLOW);

      addSpecificProviderAddItem2();
    }
    return specificProviderAddItem2;

  }

  /**
   * コンストラクタです。
   */
  public QO004117Design() {

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

    this.add(getMainGroup(), VRLayout.CLIENT);

  }

  /**
   * 事業グループに内部項目を追加します。
   */
  protected void addMainGroup(){

    mainGroup.add(getSpecificProviderAddContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * 特定体制整備事業所加算の有無に内部項目を追加します。
   */
  protected void addSpecificProviderAdd(){

  }

  /**
   * 特定体制整備事業所加算の有無モデルに内部項目を追加します。
   */
  protected void addSpecificProviderAddModel(){

    getSpecificProviderAddItem1().setButtonIndex(1);
    getSpecificProviderAddModel().add(getSpecificProviderAddItem1());

    getSpecificProviderAddItem2().setButtonIndex(2);
    getSpecificProviderAddModel().add(getSpecificProviderAddItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addSpecificProviderAddItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addSpecificProviderAddItem2(){

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
      ACFrame.debugStart(new ACAffairInfo(QO004117Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QO004117Design getThis() {
    return this;
  }
}
