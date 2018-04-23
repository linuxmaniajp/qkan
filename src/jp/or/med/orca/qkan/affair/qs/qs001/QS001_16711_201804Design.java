
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
 * 作成日: 2012/01/31  日本コンピューター株式会社 樋口　雅彦 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム サービス予定作成/変更 (S)
 * プロセス サービス予定週間 (001)
 * プログラム サービスパターン介護予防福祉用具貸与 (QS001_16711_201804)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
import java.awt.Component;
import java.awt.im.InputSubset;

import javax.swing.SwingConstants;

import jp.nichicom.ac.component.ACComboBox;
import jp.nichicom.ac.component.ACTextField;
import jp.nichicom.ac.container.ACLabelContainer;
import jp.nichicom.ac.container.ACPanel;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.util.adapter.ACComboBoxModelAdapter;
import jp.nichicom.vr.layout.VRLayout;
import jp.nichicom.vr.text.VRCharType;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
/**
 * サービスパターン介護予防福祉用具貸与画面項目デザイン(QS001_16711_201804) 
 */
public class QS001_16711_201804Design extends QS001ServicePanel {
  //GUIコンポーネント

  private ACPanel welfareToolPatterns;

  private ACPanel welfareToolDetails;

  private ACComboBox welfareTools;

  private ACLabelContainer welfareToolsContainer;

  private ACComboBoxModelAdapter welfareToolsModel;

  private ACTextField welfarePoint;

  private ACLabelContainer welfarePointContainer;

  private ACTextField welfareTekiyo;

  private ACLabelContainer welfareTekiyoContainer;

  private ACTextField welfareTokuchiPoint;

  private ACLabelContainer welfareTokuchiPointContainer;

  private ACTextField providerAddMountainousAreaScalePoint;

  private ACLabelContainer providerAddMountainousAreaScalePointContainer;

  private ACTextField providerAddMountainousAreaRafioPoint;

  private ACLabelContainer providerAddMountainousAreaRafioPointContainer;

  //getter

  /**
   * 福祉用具パターン領域を取得します。
   * @return 福祉用具パターン領域
   */
  public ACPanel getWelfareToolPatterns(){
    if(welfareToolPatterns==null){

      welfareToolPatterns = new ACPanel();

      welfareToolPatterns.setFollowChildEnabled(true);

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

      welfareToolDetails.setFollowChildEnabled(true);

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
   * 中山間地域等小規模事業所加算を取得します。
   * @return 中山間地域等小規模事業所加算
   */
  public ACTextField getProviderAddMountainousAreaScalePoint(){
    if(providerAddMountainousAreaScalePoint==null){

      providerAddMountainousAreaScalePoint = new ACTextField();

      getProviderAddMountainousAreaScalePointContainer().setText("中山間地域等小規模事業所加算");

      providerAddMountainousAreaScalePoint.setBindPath("1670104");

      providerAddMountainousAreaScalePoint.setColumns(4);

      providerAddMountainousAreaScalePoint.setCharType(VRCharType.ONLY_DIGIT);

      providerAddMountainousAreaScalePoint.setHorizontalAlignment(SwingConstants.RIGHT);

      providerAddMountainousAreaScalePoint.setIMEMode(InputSubset.LATIN);

      providerAddMountainousAreaScalePoint.setMaxLength(6);

      addProviderAddMountainousAreaScalePoint();
    }
    return providerAddMountainousAreaScalePoint;

  }

  /**
   * 中山間地域等小規模事業所加算コンテナを取得します。
   * @return 中山間地域等小規模事業所加算コンテナ
   */
  protected ACLabelContainer getProviderAddMountainousAreaScalePointContainer(){
    if(providerAddMountainousAreaScalePointContainer==null){
      providerAddMountainousAreaScalePointContainer = new ACLabelContainer();
      providerAddMountainousAreaScalePointContainer.setFollowChildEnabled(true);
      providerAddMountainousAreaScalePointContainer.setVAlignment(VRLayout.CENTER);
      providerAddMountainousAreaScalePointContainer.add(getProviderAddMountainousAreaScalePoint(), null);
    }
    return providerAddMountainousAreaScalePointContainer;
  }

  /**
   * 中山間地域等でのサービス提供加算を取得します。
   * @return 中山間地域等でのサービス提供加算
   */
  public ACTextField getProviderAddMountainousAreaRafioPoint(){
    if(providerAddMountainousAreaRafioPoint==null){

      providerAddMountainousAreaRafioPoint = new ACTextField();

      getProviderAddMountainousAreaRafioPointContainer().setText("中山間地域等でのサービス提供加算");

      providerAddMountainousAreaRafioPoint.setBindPath("1670105");

      providerAddMountainousAreaRafioPoint.setColumns(4);

      providerAddMountainousAreaRafioPoint.setCharType(VRCharType.ONLY_DIGIT);

      providerAddMountainousAreaRafioPoint.setHorizontalAlignment(SwingConstants.RIGHT);

      providerAddMountainousAreaRafioPoint.setIMEMode(InputSubset.LATIN);

      providerAddMountainousAreaRafioPoint.setMaxLength(6);

      addProviderAddMountainousAreaRafioPoint();
    }
    return providerAddMountainousAreaRafioPoint;

  }

  /**
   * 中山間地域等でのサービス提供加算コンテナを取得します。
   * @return 中山間地域等でのサービス提供加算コンテナ
   */
  protected ACLabelContainer getProviderAddMountainousAreaRafioPointContainer(){
    if(providerAddMountainousAreaRafioPointContainer==null){
      providerAddMountainousAreaRafioPointContainer = new ACLabelContainer();
      providerAddMountainousAreaRafioPointContainer.setFollowChildEnabled(true);
      providerAddMountainousAreaRafioPointContainer.setVAlignment(VRLayout.CENTER);
      providerAddMountainousAreaRafioPointContainer.add(getProviderAddMountainousAreaRafioPoint(), null);
    }
    return providerAddMountainousAreaRafioPointContainer;
  }

  /**
   * コンストラクタです。
   */
  public QS001_16711_201804Design() {

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

    welfareToolDetails.add(getWelfarePointContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    welfareToolDetails.add(getWelfareTekiyoContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    welfareToolDetails.add(getWelfareTokuchiPointContainer(), VRLayout.FLOW_RETURN);

    welfareToolDetails.add(getProviderAddMountainousAreaScalePointContainer(), VRLayout.FLOW_RETURN);

    welfareToolDetails.add(getProviderAddMountainousAreaRafioPointContainer(), VRLayout.FLOW_RETURN);

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
   * 摘要に内部項目を追加します。
   */
  protected void addWelfareTekiyo(){

  }

  /**
   * 特地加算テキストに内部項目を追加します。
   */
  protected void addWelfareTokuchiPoint(){

  }

  /**
   * 中山間地域等小規模事業所加算に内部項目を追加します。
   */
  protected void addProviderAddMountainousAreaScalePoint(){

  }

  /**
   * 中山間地域等でのサービス提供加算に内部項目を追加します。
   */
  protected void addProviderAddMountainousAreaRafioPoint(){

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
      ACFrame.debugStart(new ACAffairInfo(QS001_16711_201804Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QS001_16711_201804Design getThis() {
    return this;
  }
}
