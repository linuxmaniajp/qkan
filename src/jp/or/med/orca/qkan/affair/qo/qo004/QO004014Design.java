
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
 * 作成日: 2006/02/18  日本コンピューター株式会社 小笠　貴志 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム その他機能 (O)
 * プロセス 事業者登録 (004)
 * プログラム 認知症対応型共同生活介護 (QO004014)
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
import jp.or.med.orca.qkan.component.*;
import jp.or.med.orca.qkan.text.*;
/**
 * 認知症対応型共同生活介護画面項目デザイン(QO004014) 
 */
public class QO004014Design extends ACPanel {
  //GUIコンポーネント

  private ACGroupBox dementiaSymbiosisGroup;

  private ACLabelContainer dementiaSymbiosisDiscountContainer;

  private ACTextField dementiaSymbiosisDiscountRate;

  private ACLabel percentSign;

  private ACClearableRadioButtonGroup nighttimeCare;

  private ACLabelContainer nighttimeCareContainer;

  private ACListModelAdapter nighttimeCareModel;

  private ACRadioButtonItem nighttimeCareOff;

  private ACRadioButtonItem nighttimeCareOn;

  private ACClearableRadioButtonGroup staffLack;

  private ACLabelContainer staffLackContainer;

  private ACListModelAdapter staffLackModel;

  private ACRadioButtonItem staffLackOff;

  private ACRadioButtonItem staffExcess;

  private ACRadioButtonItem kaigoWorkerOff;

  //getter

  /**
   * 事業グループを取得します。
   * @return 事業グループ
   */
  public ACGroupBox getDementiaSymbiosisGroup(){
    if(dementiaSymbiosisGroup==null){

      dementiaSymbiosisGroup = new ACGroupBox();

      dementiaSymbiosisGroup.setText("認知症対応型共同生活介護");

      dementiaSymbiosisGroup.setFollowChildEnabled(true);

      dementiaSymbiosisGroup.setHgrid(200);

      addDementiaSymbiosisGroup();
    }
    return dementiaSymbiosisGroup;

  }

  /**
   * 割引率コンテナを取得します。
   * @return 割引率コンテナ
   */
  public ACLabelContainer getDementiaSymbiosisDiscountContainer(){
    if(dementiaSymbiosisDiscountContainer==null){

      dementiaSymbiosisDiscountContainer = new ACLabelContainer();

      dementiaSymbiosisDiscountContainer.setText("割引率");

      dementiaSymbiosisDiscountContainer.setFollowChildEnabled(true);

      addDementiaSymbiosisDiscountContainer();
    }
    return dementiaSymbiosisDiscountContainer;

  }

  /**
   * 割引率を取得します。
   * @return 割引率
   */
  public ACTextField getDementiaSymbiosisDiscountRate(){
    if(dementiaSymbiosisDiscountRate==null){

      dementiaSymbiosisDiscountRate = new ACTextField();

      dementiaSymbiosisDiscountRate.setBindPath("REDUCT_RATE");

      dementiaSymbiosisDiscountRate.setColumns(3);

      dementiaSymbiosisDiscountRate.setCharType(VRCharType.ONLY_DIGIT);

      dementiaSymbiosisDiscountRate.setHorizontalAlignment(SwingConstants.RIGHT);

      dementiaSymbiosisDiscountRate.setIMEMode(InputSubset.LATIN);

      dementiaSymbiosisDiscountRate.setMaxLength(3);

      addDementiaSymbiosisDiscountRate();
    }
    return dementiaSymbiosisDiscountRate;

  }

  /**
   * ％ラベルを取得します。
   * @return ％ラベル
   */
  public ACLabel getPercentSign(){
    if(percentSign==null){

      percentSign = new ACLabel();

      percentSign.setText("％");

      addPercentSign();
    }
    return percentSign;

  }

  /**
   * 夜間ケアラジオグループを取得します。
   * @return 夜間ケアラジオグループ
   */
  public ACClearableRadioButtonGroup getNighttimeCare(){
    if(nighttimeCare==null){

      nighttimeCare = new ACClearableRadioButtonGroup();

      getNighttimeCareContainer().setText("夜間ケア");

      nighttimeCare.setBindPath("1320101");

      nighttimeCare.setModel(getNighttimeCareModel());

      nighttimeCare.setUseClearButton(false);

      addNighttimeCare();
    }
    return nighttimeCare;

  }

  /**
   * 夜間ケアラジオグループコンテナを取得します。
   * @return 夜間ケアラジオグループコンテナ
   */
  protected ACLabelContainer getNighttimeCareContainer(){
    if(nighttimeCareContainer==null){
      nighttimeCareContainer = new ACLabelContainer();
      nighttimeCareContainer.setFollowChildEnabled(true);
      nighttimeCareContainer.add(getNighttimeCare(), null);
    }
    return nighttimeCareContainer;
  }

  /**
   * 夜間ケアラジオグループモデルを取得します。
   * @return 夜間ケアラジオグループモデル
   */
  protected ACListModelAdapter getNighttimeCareModel(){
    if(nighttimeCareModel==null){
      nighttimeCareModel = new ACListModelAdapter();
      addNighttimeCareModel();
    }
    return nighttimeCareModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getNighttimeCareOff(){
    if(nighttimeCareOff==null){

      nighttimeCareOff = new ACRadioButtonItem();

      nighttimeCareOff.setText("なし");

      nighttimeCareOff.setGroup(getNighttimeCare());

      addNighttimeCareOff();
    }
    return nighttimeCareOff;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getNighttimeCareOn(){
    if(nighttimeCareOn==null){

      nighttimeCareOn = new ACRadioButtonItem();

      nighttimeCareOn.setText("あり");

      nighttimeCareOn.setGroup(getNighttimeCare());

      addNighttimeCareOn();
    }
    return nighttimeCareOn;

  }

  /**
   * 人員減算ラジオグループを取得します。
   * @return 人員減算ラジオグループ
   */
  public ACClearableRadioButtonGroup getStaffLack(){
    if(staffLack==null){

      staffLack = new ACClearableRadioButtonGroup();

      getStaffLackContainer().setText("人員減算");

      staffLack.setBindPath("1320102");

      staffLack.setModel(getStaffLackModel());

      staffLack.setUseClearButton(false);

      addStaffLack();
    }
    return staffLack;

  }

  /**
   * 人員減算ラジオグループコンテナを取得します。
   * @return 人員減算ラジオグループコンテナ
   */
  protected ACLabelContainer getStaffLackContainer(){
    if(staffLackContainer==null){
      staffLackContainer = new ACLabelContainer();
      staffLackContainer.setFollowChildEnabled(true);
      staffLackContainer.add(getStaffLack(), null);
    }
    return staffLackContainer;
  }

  /**
   * 人員減算ラジオグループモデルを取得します。
   * @return 人員減算ラジオグループモデル
   */
  protected ACListModelAdapter getStaffLackModel(){
    if(staffLackModel==null){
      staffLackModel = new ACListModelAdapter();
      addStaffLackModel();
    }
    return staffLackModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getStaffLackOff(){
    if(staffLackOff==null){

      staffLackOff = new ACRadioButtonItem();

      staffLackOff.setText("なし");

      staffLackOff.setGroup(getStaffLack());

      addStaffLackOff();
    }
    return staffLackOff;

  }

  /**
   * 定員超過を取得します。
   * @return 定員超過
   */
  public ACRadioButtonItem getStaffExcess(){
    if(staffExcess==null){

      staffExcess = new ACRadioButtonItem();

      staffExcess.setText("定員超過");

      staffExcess.setGroup(getStaffLack());

      addStaffExcess();
    }
    return staffExcess;

  }

  /**
   * 介護従業員不足を取得します。
   * @return 介護従業員不足
   */
  public ACRadioButtonItem getKaigoWorkerOff(){
    if(kaigoWorkerOff==null){

      kaigoWorkerOff = new ACRadioButtonItem();

      kaigoWorkerOff.setText("介護従業員の不足");

      kaigoWorkerOff.setGroup(getStaffLack());

      addKaigoWorkerOff();
    }
    return kaigoWorkerOff;

  }

  /**
   * コンストラクタです。
   */
  public QO004014Design() {

    try {
      initialize();

      initAffair(null);

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

    this.add(getDementiaSymbiosisGroup(), VRLayout.CLIENT);

  }

  /**
   * 事業グループに内部項目を追加します。
   */
  protected void addDementiaSymbiosisGroup(){

    dementiaSymbiosisGroup.add(getDementiaSymbiosisDiscountContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    dementiaSymbiosisGroup.add(getNighttimeCareContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    dementiaSymbiosisGroup.add(getStaffLackContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * 割引率コンテナに内部項目を追加します。
   */
  protected void addDementiaSymbiosisDiscountContainer(){

    dementiaSymbiosisDiscountContainer.add(getDementiaSymbiosisDiscountRate(), VRLayout.FLOW);

    dementiaSymbiosisDiscountContainer.add(getPercentSign(), VRLayout.FLOW);

  }

  /**
   * 割引率に内部項目を追加します。
   */
  protected void addDementiaSymbiosisDiscountRate(){

  }

  /**
   * ％ラベルに内部項目を追加します。
   */
  protected void addPercentSign(){

  }

  /**
   * 夜間ケアラジオグループに内部項目を追加します。
   */
  protected void addNighttimeCare(){

  }

  /**
   * 夜間ケアラジオグループモデルに内部項目を追加します。
   */
  protected void addNighttimeCareModel(){

    getNighttimeCareOff().setButtonIndex(1);
    getNighttimeCareModel().add(getNighttimeCareOff());

    getNighttimeCareOn().setButtonIndex(2);
    getNighttimeCareModel().add(getNighttimeCareOn());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addNighttimeCareOff(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addNighttimeCareOn(){

  }

  /**
   * 人員減算ラジオグループに内部項目を追加します。
   */
  protected void addStaffLack(){

  }

  /**
   * 人員減算ラジオグループモデルに内部項目を追加します。
   */
  protected void addStaffLackModel(){

    getStaffLackOff().setButtonIndex(1);
    getStaffLackModel().add(getStaffLackOff());

    getStaffExcess().setButtonIndex(2);
    getStaffLackModel().add(getStaffExcess());

    getKaigoWorkerOff().setButtonIndex(3);
    getStaffLackModel().add(getKaigoWorkerOff());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addStaffLackOff(){

  }

  /**
   * 定員超過に内部項目を追加します。
   */
  protected void addStaffExcess(){

  }

  /**
   * 介護従業員不足に内部項目を追加します。
   */
  protected void addKaigoWorkerOff(){

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
      ACFrame.getInstance().getContentPane().add(new QO004014Design());
      ACFrame.getInstance().setVisible(true);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QO004014Design getThis() {
    return this;
  }
}
