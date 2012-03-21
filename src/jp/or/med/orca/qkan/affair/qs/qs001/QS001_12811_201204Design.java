
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
 * 作成日: 2012/02/02  日本コンピューター株式会社 樋口　雅彦 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム サービス予定作成/変更 (S)
 * プロセス サービス予定週間 (001)
 * プログラム サービスパターン地域密着型特定施設入所者生活介護（短期利用） (QS001_12811_201204)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
import java.awt.Component;

import jp.nichicom.ac.component.ACIntegerCheckBox;
import jp.nichicom.ac.component.ACRadioButtonItem;
import jp.nichicom.ac.component.ACValueArrayRadioButtonGroup;
import jp.nichicom.ac.container.ACLabelContainer;
import jp.nichicom.ac.container.ACPanel;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.util.adapter.ACListModelAdapter;
import jp.nichicom.vr.layout.VRLayout;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
/**
 * サービスパターン地域密着型特定施設入所者生活介護（短期利用）画面項目デザイン(QS001_12811_201204) 
 */
public class QS001_12811_201204Design extends QS001ServicePanel {
  //GUIコンポーネント

  private ACPanel regionSpecificFacilityPatterns;

  private ACValueArrayRadioButtonGroup regionStaffSubtractionRadio;

  private ACLabelContainer regionStaffSubtractionRadioContainer;

  private ACListModelAdapter regionStaffSubtractionRadioModel;

  private ACRadioButtonItem regionSubtractionNo;

  private ACRadioButtonItem regionSubtractionPersonLack;

  private ACValueArrayRadioButtonGroup regionNightStandardRadio;

  private ACLabelContainer regionNightStandardRadioContainer;

  private ACListModelAdapter regionNightStandardRadioModel;

  private ACRadioButtonItem regionNightStandardRadioItem1;

  private ACRadioButtonItem regionNightStandardRadioItem2;

  private ACIntegerCheckBox Addition30Orver;

  //getter

  /**
   * 地域密着特定施設入所者生活介護（短期利用）パターン領域を取得します。
   * @return 地域密着特定施設入所者生活介護（短期利用）パターン領域
   */
  public ACPanel getRegionSpecificFacilityPatterns(){
    if(regionSpecificFacilityPatterns==null){

      regionSpecificFacilityPatterns = new ACPanel();

      regionSpecificFacilityPatterns.setAutoWrap(false);

      regionSpecificFacilityPatterns.setFollowChildEnabled(true);

      regionSpecificFacilityPatterns.setHgrid(200);

      addRegionSpecificFacilityPatterns();
    }
    return regionSpecificFacilityPatterns;

  }

  /**
   * 人員減算を取得します。
   * @return 人員減算
   */
  public ACValueArrayRadioButtonGroup getRegionStaffSubtractionRadio(){
    if(regionStaffSubtractionRadio==null){

      regionStaffSubtractionRadio = new ACValueArrayRadioButtonGroup();

      getRegionStaffSubtractionRadioContainer().setText("人員減算");

      regionStaffSubtractionRadio.setBindPath("1280101");

      regionStaffSubtractionRadio.setUseClearButton(false);

      regionStaffSubtractionRadio.setModel(getRegionStaffSubtractionRadioModel());

      regionStaffSubtractionRadio.setValues(new int[]{1,2});

      addRegionStaffSubtractionRadio();
    }
    return regionStaffSubtractionRadio;

  }

  /**
   * 人員減算コンテナを取得します。
   * @return 人員減算コンテナ
   */
  protected ACLabelContainer getRegionStaffSubtractionRadioContainer(){
    if(regionStaffSubtractionRadioContainer==null){
      regionStaffSubtractionRadioContainer = new ACLabelContainer();
      regionStaffSubtractionRadioContainer.setFollowChildEnabled(true);
      regionStaffSubtractionRadioContainer.setVAlignment(VRLayout.CENTER);
      regionStaffSubtractionRadioContainer.add(getRegionStaffSubtractionRadio(), null);
    }
    return regionStaffSubtractionRadioContainer;
  }

  /**
   * 人員減算モデルを取得します。
   * @return 人員減算モデル
   */
  protected ACListModelAdapter getRegionStaffSubtractionRadioModel(){
    if(regionStaffSubtractionRadioModel==null){
      regionStaffSubtractionRadioModel = new ACListModelAdapter();
      addRegionStaffSubtractionRadioModel();
    }
    return regionStaffSubtractionRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getRegionSubtractionNo(){
    if(regionSubtractionNo==null){

      regionSubtractionNo = new ACRadioButtonItem();

      regionSubtractionNo.setText("なし");

      regionSubtractionNo.setGroup(getRegionStaffSubtractionRadio());

      regionSubtractionNo.setConstraints(VRLayout.FLOW);

      addRegionSubtractionNo();
    }
    return regionSubtractionNo;

  }

  /**
   * 看護・介護職員の不足を取得します。
   * @return 看護・介護職員の不足
   */
  public ACRadioButtonItem getRegionSubtractionPersonLack(){
    if(regionSubtractionPersonLack==null){

      regionSubtractionPersonLack = new ACRadioButtonItem();

      regionSubtractionPersonLack.setText("看護・介護職員の不足");

      regionSubtractionPersonLack.setGroup(getRegionStaffSubtractionRadio());

      regionSubtractionPersonLack.setConstraints(VRLayout.FLOW);

      addRegionSubtractionPersonLack();
    }
    return regionSubtractionPersonLack;

  }

  /**
   * 夜間看護体制加算を取得します。
   * @return 夜間看護体制加算
   */
  public ACValueArrayRadioButtonGroup getRegionNightStandardRadio(){
    if(regionNightStandardRadio==null){

      regionNightStandardRadio = new ACValueArrayRadioButtonGroup();

      getRegionNightStandardRadioContainer().setText("夜間看護体制");

      regionNightStandardRadio.setBindPath("1280102");

      regionNightStandardRadio.setUseClearButton(false);

      regionNightStandardRadio.setModel(getRegionNightStandardRadioModel());

      regionNightStandardRadio.setValues(new int[]{1,2});

      addRegionNightStandardRadio();
    }
    return regionNightStandardRadio;

  }

  /**
   * 夜間看護体制加算コンテナを取得します。
   * @return 夜間看護体制加算コンテナ
   */
  protected ACLabelContainer getRegionNightStandardRadioContainer(){
    if(regionNightStandardRadioContainer==null){
      regionNightStandardRadioContainer = new ACLabelContainer();
      regionNightStandardRadioContainer.setFollowChildEnabled(true);
      regionNightStandardRadioContainer.setVAlignment(VRLayout.CENTER);
      regionNightStandardRadioContainer.add(getRegionNightStandardRadio(), null);
    }
    return regionNightStandardRadioContainer;
  }

  /**
   * 夜間看護体制加算モデルを取得します。
   * @return 夜間看護体制加算モデル
   */
  protected ACListModelAdapter getRegionNightStandardRadioModel(){
    if(regionNightStandardRadioModel==null){
      regionNightStandardRadioModel = new ACListModelAdapter();
      addRegionNightStandardRadioModel();
    }
    return regionNightStandardRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getRegionNightStandardRadioItem1(){
    if(regionNightStandardRadioItem1==null){

      regionNightStandardRadioItem1 = new ACRadioButtonItem();

      regionNightStandardRadioItem1.setText("なし");

      regionNightStandardRadioItem1.setGroup(getRegionNightStandardRadio());

      regionNightStandardRadioItem1.setConstraints(VRLayout.FLOW);

      addRegionNightStandardRadioItem1();
    }
    return regionNightStandardRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getRegionNightStandardRadioItem2(){
    if(regionNightStandardRadioItem2==null){

      regionNightStandardRadioItem2 = new ACRadioButtonItem();

      regionNightStandardRadioItem2.setText("あり");

      regionNightStandardRadioItem2.setGroup(getRegionNightStandardRadio());

      regionNightStandardRadioItem2.setConstraints(VRLayout.FLOW);

      addRegionNightStandardRadioItem2();
    }
    return regionNightStandardRadioItem2;

  }

  /**
   * 30日超を取得します。
   * @return 30日超
   */
  public ACIntegerCheckBox getAddition30Orver(){
    if(Addition30Orver==null){

      Addition30Orver = new ACIntegerCheckBox();

      Addition30Orver.setText("30日超");

      Addition30Orver.setBindPath("5");

      Addition30Orver.setSelectValue(2);

      Addition30Orver.setUnSelectValue(1);

      addAddition30Orver();
    }
    return Addition30Orver;

  }

  /**
   * コンストラクタです。
   */
  public QS001_12811_201204Design() {

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

    this.add(getRegionSpecificFacilityPatterns(), VRLayout.CLIENT);

  }

  /**
   * 地域密着特定施設入所者生活介護（短期利用）パターン領域に内部項目を追加します。
   */
  protected void addRegionSpecificFacilityPatterns(){

    regionSpecificFacilityPatterns.add(getRegionStaffSubtractionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    regionSpecificFacilityPatterns.add(getRegionNightStandardRadioContainer(), VRLayout.FLOW_RETURN);

    regionSpecificFacilityPatterns.add(getAddition30Orver(), VRLayout.FLOW);

  }

  /**
   * 人員減算に内部項目を追加します。
   */
  protected void addRegionStaffSubtractionRadio(){

  }

  /**
   * 人員減算モデルに内部項目を追加します。
   */
  protected void addRegionStaffSubtractionRadioModel(){

    getRegionSubtractionNo().setButtonIndex(1);

    getRegionStaffSubtractionRadioModel().add(getRegionSubtractionNo());

    getRegionSubtractionPersonLack().setButtonIndex(2);

    getRegionStaffSubtractionRadioModel().add(getRegionSubtractionPersonLack());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addRegionSubtractionNo(){

  }

  /**
   * 看護・介護職員の不足に内部項目を追加します。
   */
  protected void addRegionSubtractionPersonLack(){

  }

  /**
   * 夜間看護体制加算に内部項目を追加します。
   */
  protected void addRegionNightStandardRadio(){

  }

  /**
   * 夜間看護体制加算モデルに内部項目を追加します。
   */
  protected void addRegionNightStandardRadioModel(){

    getRegionNightStandardRadioItem1().setButtonIndex(1);

    getRegionNightStandardRadioModel().add(getRegionNightStandardRadioItem1());

    getRegionNightStandardRadioItem2().setButtonIndex(2);

    getRegionNightStandardRadioModel().add(getRegionNightStandardRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addRegionNightStandardRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addRegionNightStandardRadioItem2(){

  }

  /**
   * 30日超に内部項目を追加します。
   */
  protected void addAddition30Orver(){

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
      ACFrame.debugStart(new ACAffairInfo(QS001_12811_201204Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QS001_12811_201204Design getThis() {
    return this;
  }
}
