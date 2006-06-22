
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
 * 作成日: 2006/01/26  日本コンピューター株式会社 小笠　貴志 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム サービス予定作成/変更 (S)
 * プロセス サービス予定週間 (001)
 * プログラム サービスパターン居宅介護支援 (QS001020)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
import java.awt.Component;

import jp.nichicom.ac.component.ACClearableRadioButtonGroup;
import jp.nichicom.ac.component.ACRadioButtonItem;
import jp.nichicom.ac.container.ACLabelContainer;
import jp.nichicom.ac.container.ACPanel;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.util.adapter.ACListModelAdapter;
import jp.nichicom.vr.layout.VRLayout;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
/**
 * サービスパターン居宅介護支援画面項目デザイン(QS001020) 
 */
public class QS001020Design extends QS001ServicePanel {
  //GUIコンポーネント

  private ACPanel kaigoSupportPattern;

  private ACClearableRadioButtonGroup kaigoSupportManagementBasicRadio;

  private ACLabelContainer kaigoSupportManagementBasicRadioContainer;

  private ACListModelAdapter kaigoSupportManagementBasicRadioModel;

  private ACRadioButtonItem kaigoSupportManagementBasicRadioItem1;

  private ACRadioButtonItem kaigoSupportManagementBasicRadioItem2;

  private ACClearableRadioButtonGroup kaigoSupportKindRadio;

  private ACLabelContainer kaigoSupportKindRadioContainer;

  private ACListModelAdapter kaigoSupportKindRadioModel;

  private ACRadioButtonItem kaigoSupportKindRadioItem1;

  private ACRadioButtonItem kaigoSupportKindRadioItem2;

  //getter

  /**
   * 居宅介護支援領域を取得します。
   * @return 居宅介護支援領域
   */
  public ACPanel getKaigoSupportPattern(){
    if(kaigoSupportPattern==null){

      kaigoSupportPattern = new ACPanel();

      kaigoSupportPattern.setAutoWrap(false);

      addKaigoSupportPattern();
    }
    return kaigoSupportPattern;

  }

  /**
   * 運営基準減算を取得します。
   * @return 運営基準減算
   */
  public ACClearableRadioButtonGroup getKaigoSupportManagementBasicRadio(){
    if(kaigoSupportManagementBasicRadio==null){

      kaigoSupportManagementBasicRadio = new ACClearableRadioButtonGroup();

      getKaigoSupportManagementBasicRadioContainer().setText("運営基準減算");

      kaigoSupportManagementBasicRadio.setModel(getKaigoSupportManagementBasicRadioModel());

      kaigoSupportManagementBasicRadio.setUseClearButton(false);

      addKaigoSupportManagementBasicRadio();
    }
    return kaigoSupportManagementBasicRadio;

  }

  /**
   * 運営基準減算コンテナを取得します。
   * @return 運営基準減算コンテナ
   */
  protected ACLabelContainer getKaigoSupportManagementBasicRadioContainer(){
    if(kaigoSupportManagementBasicRadioContainer==null){
      kaigoSupportManagementBasicRadioContainer = new ACLabelContainer();
      kaigoSupportManagementBasicRadioContainer.add(getKaigoSupportManagementBasicRadio(), null);
    }
    return kaigoSupportManagementBasicRadioContainer;
  }

  /**
   * 運営基準減算モデルを取得します。
   * @return 運営基準減算モデル
   */
  protected ACListModelAdapter getKaigoSupportManagementBasicRadioModel(){
    if(kaigoSupportManagementBasicRadioModel==null){
      kaigoSupportManagementBasicRadioModel = new ACListModelAdapter();
      addKaigoSupportManagementBasicRadioModel();
    }
    return kaigoSupportManagementBasicRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getKaigoSupportManagementBasicRadioItem1(){
    if(kaigoSupportManagementBasicRadioItem1==null){

      kaigoSupportManagementBasicRadioItem1 = new ACRadioButtonItem();

      kaigoSupportManagementBasicRadioItem1.setText("なし");

      kaigoSupportManagementBasicRadioItem1.setGroup(getKaigoSupportManagementBasicRadio());

      kaigoSupportManagementBasicRadioItem1.setConstraints(VRLayout.FLOW);

      addKaigoSupportManagementBasicRadioItem1();
    }
    return kaigoSupportManagementBasicRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getKaigoSupportManagementBasicRadioItem2(){
    if(kaigoSupportManagementBasicRadioItem2==null){

      kaigoSupportManagementBasicRadioItem2 = new ACRadioButtonItem();

      kaigoSupportManagementBasicRadioItem2.setText("あり");

      kaigoSupportManagementBasicRadioItem2.setGroup(getKaigoSupportManagementBasicRadio());

      kaigoSupportManagementBasicRadioItem2.setConstraints(VRLayout.FLOW);

      addKaigoSupportManagementBasicRadioItem2();
    }
    return kaigoSupportManagementBasicRadioItem2;

  }

  /**
   * 種類加算を取得します。
   * @return 種類加算
   */
  public ACClearableRadioButtonGroup getKaigoSupportKindRadio(){
    if(kaigoSupportKindRadio==null){

      kaigoSupportKindRadio = new ACClearableRadioButtonGroup();

      getKaigoSupportKindRadioContainer().setText("種類加算");

      kaigoSupportKindRadio.setModel(getKaigoSupportKindRadioModel());

      kaigoSupportKindRadio.setUseClearButton(false);

      addKaigoSupportKindRadio();
    }
    return kaigoSupportKindRadio;

  }

  /**
   * 種類加算コンテナを取得します。
   * @return 種類加算コンテナ
   */
  protected ACLabelContainer getKaigoSupportKindRadioContainer(){
    if(kaigoSupportKindRadioContainer==null){
      kaigoSupportKindRadioContainer = new ACLabelContainer();
      kaigoSupportKindRadioContainer.add(getKaigoSupportKindRadio(), null);
    }
    return kaigoSupportKindRadioContainer;
  }

  /**
   * 種類加算モデルを取得します。
   * @return 種類加算モデル
   */
  protected ACListModelAdapter getKaigoSupportKindRadioModel(){
    if(kaigoSupportKindRadioModel==null){
      kaigoSupportKindRadioModel = new ACListModelAdapter();
      addKaigoSupportKindRadioModel();
    }
    return kaigoSupportKindRadioModel;
  }

  /**
   * 4種類未満を取得します。
   * @return 4種類未満
   */
  public ACRadioButtonItem getKaigoSupportKindRadioItem1(){
    if(kaigoSupportKindRadioItem1==null){

      kaigoSupportKindRadioItem1 = new ACRadioButtonItem();

      kaigoSupportKindRadioItem1.setText("4種類未満");

      kaigoSupportKindRadioItem1.setGroup(getKaigoSupportKindRadio());

      kaigoSupportKindRadioItem1.setConstraints(VRLayout.FLOW);

      addKaigoSupportKindRadioItem1();
    }
    return kaigoSupportKindRadioItem1;

  }

  /**
   * 4種類以上を取得します。
   * @return 4種類以上
   */
  public ACRadioButtonItem getKaigoSupportKindRadioItem2(){
    if(kaigoSupportKindRadioItem2==null){

      kaigoSupportKindRadioItem2 = new ACRadioButtonItem();

      kaigoSupportKindRadioItem2.setText("4種類以上");

      kaigoSupportKindRadioItem2.setGroup(getKaigoSupportKindRadio());

      kaigoSupportKindRadioItem2.setConstraints(VRLayout.FLOW);

      addKaigoSupportKindRadioItem2();
    }
    return kaigoSupportKindRadioItem2;

  }

  /**
   * コンストラクタです。
   */
  public QS001020Design() {

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

    this.add(getKaigoSupportPattern(), VRLayout.WEST);

  }

  /**
   * 居宅介護支援領域に内部項目を追加します。
   */
  protected void addKaigoSupportPattern(){

    kaigoSupportPattern.add(getKaigoSupportManagementBasicRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    kaigoSupportPattern.add(getKaigoSupportKindRadioContainer(), VRLayout.FLOW_INSETLINE);

  }

  /**
   * 運営基準減算に内部項目を追加します。
   */
  protected void addKaigoSupportManagementBasicRadio(){

  }

  /**
   * 運営基準減算モデルに内部項目を追加します。
   */
  protected void addKaigoSupportManagementBasicRadioModel(){

    getKaigoSupportManagementBasicRadioItem1().setButtonIndex(1);
    getKaigoSupportManagementBasicRadioModel().add(getKaigoSupportManagementBasicRadioItem1());

    getKaigoSupportManagementBasicRadioItem2().setButtonIndex(2);
    getKaigoSupportManagementBasicRadioModel().add(getKaigoSupportManagementBasicRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addKaigoSupportManagementBasicRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addKaigoSupportManagementBasicRadioItem2(){

  }

  /**
   * 種類加算に内部項目を追加します。
   */
  protected void addKaigoSupportKindRadio(){

  }

  /**
   * 種類加算モデルに内部項目を追加します。
   */
  protected void addKaigoSupportKindRadioModel(){

    getKaigoSupportKindRadioItem1().setButtonIndex(1);
    getKaigoSupportKindRadioModel().add(getKaigoSupportKindRadioItem1());

    getKaigoSupportKindRadioItem2().setButtonIndex(2);
    getKaigoSupportKindRadioModel().add(getKaigoSupportKindRadioItem2());

  }

  /**
   * 4種類未満に内部項目を追加します。
   */
  protected void addKaigoSupportKindRadioItem1(){

  }

  /**
   * 4種類以上に内部項目を追加します。
   */
  protected void addKaigoSupportKindRadioItem2(){

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
      ACFrame.getInstance().getContentPane().add(new QS001020Design());
      ACFrame.getInstance().setVisible(true);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QS001020Design getThis() {
    return this;
  }
}
