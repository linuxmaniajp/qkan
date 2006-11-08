
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
 * 作成日: 2006/05/18  日本コンピューター株式会社 松本　幸一 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム サービス予定作成/変更 (S)
 * プロセス サービス予定週間 (001)
 * プログラム サービスパターン介護予防福祉用具貸与 (QS001144)
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
 * サービスパターン介護予防福祉用具貸与画面項目デザイン(QS001144) 
 */
public class QS001144Design extends QS001ServicePanel {
  //GUIコンポーネント

  private ACPanel welfareToolPatterns;

  private ACPanel welfareToolDetails;

  private ACComboBox welfareTools;

  private ACLabelContainer welfareToolsContainer;

  private ACComboBoxModelAdapter welfareToolsModel;

  private ACTextField welfarePoint;

  private ACLabelContainer welfarePointContainer;

  private ACTextField welfareTokuchiPoint;

  private ACLabelContainer welfareTokuchiPointContainer;

  private ACTextField welfareTekiyo;

  private ACLabelContainer welfareTekiyoContainer;

  //getter

  /**
   * 福祉用具パターン領域を取得します。
   * @return 福祉用具パターン領域
   */
  public ACPanel getWelfareToolPatterns(){
    if(welfareToolPatterns==null){

      welfareToolPatterns = new ACPanel();

      addWelfareToolPatterns();
    }
    return welfareToolPatterns;

  }

  /**
   * 福祉用具内容パネルを取得します。
   * @return 福祉用具内容パネル
   */
  public ACPanel getWelfareToolDetails(){
    if(welfareToolDetails==null){

      welfareToolDetails = new ACPanel();

      welfareToolDetails.setAutoWrap(false);

      welfareToolDetails.setHgrid(200);

      addWelfareToolDetails();
    }
    return welfareToolDetails;

  }

  /**
   * 用具コンボを取得します。
   * @return 用具コンボ
   */
  public ACComboBox getWelfareTools(){
    if(welfareTools==null){

      welfareTools = new ACComboBox();

      getWelfareToolsContainer().setText("用具");

      welfareTools.setBindPath("1670101");

      welfareTools.setEditable(false);

      welfareTools.setModelBindPath("1670101");

      welfareTools.setRenderBindPath("CONTENT");

      welfareTools.setModel(getWelfareToolsModel());

      addWelfareTools();
    }
    return welfareTools;

  }

  /**
   * 用具コンボコンテナを取得します。
   * @return 用具コンボコンテナ
   */
  protected ACLabelContainer getWelfareToolsContainer(){
    if(welfareToolsContainer==null){
      welfareToolsContainer = new ACLabelContainer();
      welfareToolsContainer.setFollowChildEnabled(true);
      welfareToolsContainer.setVAlignment(VRLayout.CENTER);
      welfareToolsContainer.add(getWelfareTools(), null);
    }
    return welfareToolsContainer;
  }

  /**
   * 用具コンボモデルを取得します。
   * @return 用具コンボモデル
   */
  protected ACComboBoxModelAdapter getWelfareToolsModel(){
    if(welfareToolsModel==null){
      welfareToolsModel = new ACComboBoxModelAdapter();
      addWelfareToolsModel();
    }
    return welfareToolsModel;
  }

  /**
   * 単位数テキストを取得します。
   * @return 単位数テキスト
   */
  public ACTextField getWelfarePoint(){
    if(welfarePoint==null){

      welfarePoint = new ACTextField();

      getWelfarePointContainer().setText("単位数");

      welfarePoint.setBindPath("1670102");

      welfarePoint.setColumns(4);

      welfarePoint.setCharType(VRCharType.ONLY_DIGIT);

      welfarePoint.setHorizontalAlignment(SwingConstants.RIGHT);

      welfarePoint.setIMEMode(InputSubset.LATIN);

      welfarePoint.setMaxLength(6);

      addWelfarePoint();
    }
    return welfarePoint;

  }

  /**
   * 単位数テキストコンテナを取得します。
   * @return 単位数テキストコンテナ
   */
  protected ACLabelContainer getWelfarePointContainer(){
    if(welfarePointContainer==null){
      welfarePointContainer = new ACLabelContainer();
      welfarePointContainer.setFollowChildEnabled(true);
      welfarePointContainer.setVAlignment(VRLayout.CENTER);
      welfarePointContainer.add(getWelfarePoint(), null);
    }
    return welfarePointContainer;
  }

  /**
   * 特地加算テキストを取得します。
   * @return 特地加算テキスト
   */
  public ACTextField getWelfareTokuchiPoint(){
    if(welfareTokuchiPoint==null){

      welfareTokuchiPoint = new ACTextField();

      getWelfareTokuchiPointContainer().setText("特地加算");

      welfareTokuchiPoint.setBindPath("1670103");

      welfareTokuchiPoint.setColumns(4);

      welfareTokuchiPoint.setCharType(VRCharType.ONLY_DIGIT);

      welfareTokuchiPoint.setHorizontalAlignment(SwingConstants.RIGHT);

      welfareTokuchiPoint.setIMEMode(InputSubset.LATIN);

      welfareTokuchiPoint.setMaxLength(6);

      addWelfareTokuchiPoint();
    }
    return welfareTokuchiPoint;

  }

  /**
   * 特地加算テキストコンテナを取得します。
   * @return 特地加算テキストコンテナ
   */
  protected ACLabelContainer getWelfareTokuchiPointContainer(){
    if(welfareTokuchiPointContainer==null){
      welfareTokuchiPointContainer = new ACLabelContainer();
      welfareTokuchiPointContainer.setFollowChildEnabled(true);
      welfareTokuchiPointContainer.setVAlignment(VRLayout.CENTER);
      welfareTokuchiPointContainer.add(getWelfareTokuchiPoint(), null);
    }
    return welfareTokuchiPointContainer;
  }

  /**
   * 摘要を取得します。
   * @return 摘要
   */
  public ACTextField getWelfareTekiyo(){
    if(welfareTekiyo==null){

      welfareTekiyo = new ACTextField();

      getWelfareTekiyoContainer().setText("摘要");

      welfareTekiyo.setBindPath("1170104");

      welfareTekiyo.setColumns(15);

      welfareTekiyo.setCharType(VRCharType.ONLY_HALF_CHAR);

      welfareTekiyo.setHorizontalAlignment(SwingConstants.LEFT);

      welfareTekiyo.setIMEMode(InputSubset.LATIN);

      welfareTekiyo.setMaxLength(20);

      addWelfareTekiyo();
    }
    return welfareTekiyo;

  }

  /**
   * 摘要コンテナを取得します。
   * @return 摘要コンテナ
   */
  protected ACLabelContainer getWelfareTekiyoContainer(){
    if(welfareTekiyoContainer==null){
      welfareTekiyoContainer = new ACLabelContainer();
      welfareTekiyoContainer.setFollowChildEnabled(true);
      welfareTekiyoContainer.setVAlignment(VRLayout.CENTER);
      welfareTekiyoContainer.add(getWelfareTekiyo(), null);
    }
    return welfareTekiyoContainer;
  }

  /**
   * コンストラクタです。
   */
  public QS001144Design() {

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

    this.add(getWelfareToolPatterns(), VRLayout.CLIENT);

  }

  /**
   * 福祉用具パターン領域に内部項目を追加します。
   */
  protected void addWelfareToolPatterns(){

    welfareToolPatterns.add(getWelfareToolDetails(), VRLayout.NORTH);

  }

  /**
   * 福祉用具内容パネルに内部項目を追加します。
   */
  protected void addWelfareToolDetails(){

    welfareToolDetails.add(getWelfareToolsContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    welfareToolDetails.add(getWelfarePointContainer(), VRLayout.FLOW_INSETLINE);

    welfareToolDetails.add(getWelfareTokuchiPointContainer(), VRLayout.FLOW_RETURN);

    welfareToolDetails.add(getWelfareTekiyoContainer(), VRLayout.FLOW_INSETLINE);

  }

  /**
   * 用具コンボに内部項目を追加します。
   */
  protected void addWelfareTools(){

  }

  /**
   * 用具コンボモデルに内部項目を追加します。
   */
  protected void addWelfareToolsModel(){

  }

  /**
   * 単位数テキストに内部項目を追加します。
   */
  protected void addWelfarePoint(){

  }

  /**
   * 特地加算テキストに内部項目を追加します。
   */
  protected void addWelfareTokuchiPoint(){

  }

  /**
   * 摘要に内部項目を追加します。
   */
  protected void addWelfareTekiyo(){

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
      ACFrame.debugStart(new ACAffairInfo(QS001144Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QS001144Design getThis() {
    return this;
  }
}
