
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
 * 作成日: 2006/04/10  日本コンピューター株式会社 松本　幸一 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム サービス予定作成/変更 (S)
 * プロセス サービス予定週間 (001)
 * プログラム サービスパターン居宅介護支援 (QS001117)
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
 * サービスパターン居宅介護支援画面項目デザイン(QS001117) 
 */
public class QS001117Design extends QS001ServicePanel {
  //GUIコンポーネント

  private ACPanel kaigoSupportPattern;

  private ACClearableRadioButtonGroup kaigoSupportDivisionRadio;

  private ACLabelContainer kaigoSupportDivisionRadioContainer;

  private ACListModelAdapter kaigoSupportDivisionRadioModel;

  private ACRadioButtonItem kaigoSupportDivisionRadioItem1;

  private ACRadioButtonItem kaigoSupportDivisionRadioItem2;

  private ACRadioButtonItem kaigoSupportDivisionRadioItem3;

  private ACRadioButtonItem kaigoSupportDivisionRadioItem4;

  private ACClearableRadioButtonGroup kaigoSupportManagementBasicRadio;

  private ACLabelContainer kaigoSupportManagementBasicRadioContainer;

  private ACListModelAdapter kaigoSupportManagementBasicRadioModel;

  private ACRadioButtonItem kaigoSupportManagementBasicRadioItem1;

  private ACRadioButtonItem kaigoSupportManagementBasicRadioItem2;

  private ACRadioButtonItem kaigoSupportManagementBasicRadioItem3;

  private ACClearableRadioButtonGroup kaigoSupportSpecificProviderSubtractionRadio;

  private ACLabelContainer kaigoSupportSpecificProviderSubtractionRadioContainer;

  private ACListModelAdapter kaigoSupportSpecificProviderSubtractionRadioModel;

  private ACRadioButtonItem kaigoSupportSpecificProviderSubtractionRadioItem1;

  private ACRadioButtonItem kaigoSupportSpecificProviderSubtractionRadioItem2;

  private ACClearableRadioButtonGroup kaigoSupportStandardRadio;

  private ACLabelContainer kaigoSupportStandardRadioContainer;

  private ACListModelAdapter kaigoSupportStandardRadioModel;

  private ACRadioButtonItem kaigoSupportStandardRadioItem1;

  private ACRadioButtonItem kaigoSupportStandardRadioItem2;

  private ACRadioButtonItem kaigoSupportStandardRadioItem3;

  private ACClearableRadioButtonGroup kaigoSupportSpecificStandardRadio;

  private ACLabelContainer kaigoSupportSpecificStandardRadioContainer;

  private ACListModelAdapter kaigoSupportSpecificStandardRadioModel;

  private ACRadioButtonItem kaigoSupportSpecificStandardRadioItem1;

  private ACRadioButtonItem kaigoSupportSpecificStandardRadioItem2;

  private ACGroupBox kaigoSupportSpecialMemberContainer;

  private ACTextField kaigoSupportSpecialMemberNumber;

  private ACLabelContainer kaigoSupportSpecialMemberNumberContainer;

  private ACComboBox kaigoSupportSpecialMemberName;

  private ACLabelContainer kaigoSupportSpecialMemberNameContainer;

  private ACComboBoxModelAdapter kaigoSupportSpecialMemberNameModel;

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
   * 居宅介護支援費を取得します。
   * @return 居宅介護支援費
   */
  public ACClearableRadioButtonGroup getKaigoSupportDivisionRadio(){
    if(kaigoSupportDivisionRadio==null){

      kaigoSupportDivisionRadio = new ACClearableRadioButtonGroup();

      getKaigoSupportDivisionRadioContainer().setText("居宅介護支援費");

      kaigoSupportDivisionRadio.setBindPath("1430103");

      kaigoSupportDivisionRadio.setUseClearButton(false);

      kaigoSupportDivisionRadio.setModel(getKaigoSupportDivisionRadioModel());

      addKaigoSupportDivisionRadio();
    }
    return kaigoSupportDivisionRadio;

  }

  /**
   * 居宅介護支援費コンテナを取得します。
   * @return 居宅介護支援費コンテナ
   */
  protected ACLabelContainer getKaigoSupportDivisionRadioContainer(){
    if(kaigoSupportDivisionRadioContainer==null){
      kaigoSupportDivisionRadioContainer = new ACLabelContainer();
      kaigoSupportDivisionRadioContainer.setFollowChildEnabled(true);
      kaigoSupportDivisionRadioContainer.setVAlignment(VRLayout.CENTER);
      kaigoSupportDivisionRadioContainer.add(getKaigoSupportDivisionRadio(), null);
    }
    return kaigoSupportDivisionRadioContainer;
  }

  /**
   * 居宅介護支援費モデルを取得します。
   * @return 居宅介護支援費モデル
   */
  protected ACListModelAdapter getKaigoSupportDivisionRadioModel(){
    if(kaigoSupportDivisionRadioModel==null){
      kaigoSupportDivisionRadioModel = new ACListModelAdapter();
      addKaigoSupportDivisionRadioModel();
    }
    return kaigoSupportDivisionRadioModel;
  }

  /**
   * I型を取得します。
   * @return I型
   */
  public ACRadioButtonItem getKaigoSupportDivisionRadioItem1(){
    if(kaigoSupportDivisionRadioItem1==null){

      kaigoSupportDivisionRadioItem1 = new ACRadioButtonItem();

      kaigoSupportDivisionRadioItem1.setText("I型");

      kaigoSupportDivisionRadioItem1.setGroup(getKaigoSupportDivisionRadio());

      kaigoSupportDivisionRadioItem1.setConstraints(VRLayout.FLOW);

      addKaigoSupportDivisionRadioItem1();
    }
    return kaigoSupportDivisionRadioItem1;

  }

  /**
   * II型を取得します。
   * @return II型
   */
  public ACRadioButtonItem getKaigoSupportDivisionRadioItem2(){
    if(kaigoSupportDivisionRadioItem2==null){

      kaigoSupportDivisionRadioItem2 = new ACRadioButtonItem();

      kaigoSupportDivisionRadioItem2.setText("II型");

      kaigoSupportDivisionRadioItem2.setGroup(getKaigoSupportDivisionRadio());

      kaigoSupportDivisionRadioItem2.setConstraints(VRLayout.FLOW);

      addKaigoSupportDivisionRadioItem2();
    }
    return kaigoSupportDivisionRadioItem2;

  }

  /**
   * III型を取得します。
   * @return III型
   */
  public ACRadioButtonItem getKaigoSupportDivisionRadioItem3(){
    if(kaigoSupportDivisionRadioItem3==null){

      kaigoSupportDivisionRadioItem3 = new ACRadioButtonItem();

      kaigoSupportDivisionRadioItem3.setText("III型");

      kaigoSupportDivisionRadioItem3.setGroup(getKaigoSupportDivisionRadio());

      kaigoSupportDivisionRadioItem3.setConstraints(VRLayout.FLOW_RETURN);

      addKaigoSupportDivisionRadioItem3();
    }
    return kaigoSupportDivisionRadioItem3;

  }

  /**
   * 経過的要介護を取得します。
   * @return 経過的要介護
   */
  public ACRadioButtonItem getKaigoSupportDivisionRadioItem4(){
    if(kaigoSupportDivisionRadioItem4==null){

      kaigoSupportDivisionRadioItem4 = new ACRadioButtonItem();

      kaigoSupportDivisionRadioItem4.setText("経過的要介護");

      kaigoSupportDivisionRadioItem4.setGroup(getKaigoSupportDivisionRadio());

      kaigoSupportDivisionRadioItem4.setConstraints(VRLayout.FLOW);

      addKaigoSupportDivisionRadioItem4();
    }
    return kaigoSupportDivisionRadioItem4;

  }

  /**
   * 運営基準減算を取得します。
   * @return 運営基準減算
   */
  public ACClearableRadioButtonGroup getKaigoSupportManagementBasicRadio(){
    if(kaigoSupportManagementBasicRadio==null){

      kaigoSupportManagementBasicRadio = new ACClearableRadioButtonGroup();

      getKaigoSupportManagementBasicRadioContainer().setText("運営基準減算");

      kaigoSupportManagementBasicRadio.setBindPath("1430101");

      kaigoSupportManagementBasicRadio.setUseClearButton(false);

      kaigoSupportManagementBasicRadio.setModel(getKaigoSupportManagementBasicRadioModel());

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
      kaigoSupportManagementBasicRadioContainer.setFollowChildEnabled(true);
      kaigoSupportManagementBasicRadioContainer.setVAlignment(VRLayout.CENTER);
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
   * 減算要件該当を取得します。
   * @return 減算要件該当
   */
  public ACRadioButtonItem getKaigoSupportManagementBasicRadioItem2(){
    if(kaigoSupportManagementBasicRadioItem2==null){

      kaigoSupportManagementBasicRadioItem2 = new ACRadioButtonItem();

      kaigoSupportManagementBasicRadioItem2.setText("I型");

      kaigoSupportManagementBasicRadioItem2.setGroup(getKaigoSupportManagementBasicRadio());

      kaigoSupportManagementBasicRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

      addKaigoSupportManagementBasicRadioItem2();
    }
    return kaigoSupportManagementBasicRadioItem2;

  }

  /**
   * 減算要件該当が2ヶ月以上を取得します。
   * @return 減算要件該当が2ヶ月以上
   */
  public ACRadioButtonItem getKaigoSupportManagementBasicRadioItem3(){
    if(kaigoSupportManagementBasicRadioItem3==null){

      kaigoSupportManagementBasicRadioItem3 = new ACRadioButtonItem();

      kaigoSupportManagementBasicRadioItem3.setText("II型(I型の減算が2ヶ月以上継続)");

      kaigoSupportManagementBasicRadioItem3.setGroup(getKaigoSupportManagementBasicRadio());

      kaigoSupportManagementBasicRadioItem3.setConstraints(VRLayout.FLOW);

      addKaigoSupportManagementBasicRadioItem3();
    }
    return kaigoSupportManagementBasicRadioItem3;

  }

  /**
   * 特定事業所集中減算を取得します。
   * @return 特定事業所集中減算
   */
  public ACClearableRadioButtonGroup getKaigoSupportSpecificProviderSubtractionRadio(){
    if(kaigoSupportSpecificProviderSubtractionRadio==null){

      kaigoSupportSpecificProviderSubtractionRadio = new ACClearableRadioButtonGroup();

      getKaigoSupportSpecificProviderSubtractionRadioContainer().setText("特定事業所集中減算");

      kaigoSupportSpecificProviderSubtractionRadio.setBindPath("1430104");

      kaigoSupportSpecificProviderSubtractionRadio.setUseClearButton(false);

      kaigoSupportSpecificProviderSubtractionRadio.setModel(getKaigoSupportSpecificProviderSubtractionRadioModel());

      addKaigoSupportSpecificProviderSubtractionRadio();
    }
    return kaigoSupportSpecificProviderSubtractionRadio;

  }

  /**
   * 特定事業所集中減算コンテナを取得します。
   * @return 特定事業所集中減算コンテナ
   */
  protected ACLabelContainer getKaigoSupportSpecificProviderSubtractionRadioContainer(){
    if(kaigoSupportSpecificProviderSubtractionRadioContainer==null){
      kaigoSupportSpecificProviderSubtractionRadioContainer = new ACLabelContainer();
      kaigoSupportSpecificProviderSubtractionRadioContainer.setFollowChildEnabled(true);
      kaigoSupportSpecificProviderSubtractionRadioContainer.setVAlignment(VRLayout.CENTER);
      kaigoSupportSpecificProviderSubtractionRadioContainer.add(getKaigoSupportSpecificProviderSubtractionRadio(), null);
    }
    return kaigoSupportSpecificProviderSubtractionRadioContainer;
  }

  /**
   * 特定事業所集中減算モデルを取得します。
   * @return 特定事業所集中減算モデル
   */
  protected ACListModelAdapter getKaigoSupportSpecificProviderSubtractionRadioModel(){
    if(kaigoSupportSpecificProviderSubtractionRadioModel==null){
      kaigoSupportSpecificProviderSubtractionRadioModel = new ACListModelAdapter();
      addKaigoSupportSpecificProviderSubtractionRadioModel();
    }
    return kaigoSupportSpecificProviderSubtractionRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getKaigoSupportSpecificProviderSubtractionRadioItem1(){
    if(kaigoSupportSpecificProviderSubtractionRadioItem1==null){

      kaigoSupportSpecificProviderSubtractionRadioItem1 = new ACRadioButtonItem();

      kaigoSupportSpecificProviderSubtractionRadioItem1.setText("なし");

      kaigoSupportSpecificProviderSubtractionRadioItem1.setGroup(getKaigoSupportSpecificProviderSubtractionRadio());

      kaigoSupportSpecificProviderSubtractionRadioItem1.setConstraints(VRLayout.FLOW);

      addKaigoSupportSpecificProviderSubtractionRadioItem1();
    }
    return kaigoSupportSpecificProviderSubtractionRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getKaigoSupportSpecificProviderSubtractionRadioItem2(){
    if(kaigoSupportSpecificProviderSubtractionRadioItem2==null){

      kaigoSupportSpecificProviderSubtractionRadioItem2 = new ACRadioButtonItem();

      kaigoSupportSpecificProviderSubtractionRadioItem2.setText("あり");

      kaigoSupportSpecificProviderSubtractionRadioItem2.setGroup(getKaigoSupportSpecificProviderSubtractionRadio());

      kaigoSupportSpecificProviderSubtractionRadioItem2.setConstraints(VRLayout.FLOW);

      addKaigoSupportSpecificProviderSubtractionRadioItem2();
    }
    return kaigoSupportSpecificProviderSubtractionRadioItem2;

  }

  /**
   * 初回加算を取得します。
   * @return 初回加算
   */
  public ACClearableRadioButtonGroup getKaigoSupportStandardRadio(){
    if(kaigoSupportStandardRadio==null){

      kaigoSupportStandardRadio = new ACClearableRadioButtonGroup();

      getKaigoSupportStandardRadioContainer().setText("初回加算");

      kaigoSupportStandardRadio.setBindPath("1430105");

      kaigoSupportStandardRadio.setUseClearButton(false);

      kaigoSupportStandardRadio.setModel(getKaigoSupportStandardRadioModel());

      addKaigoSupportStandardRadio();
    }
    return kaigoSupportStandardRadio;

  }

  /**
   * 初回加算コンテナを取得します。
   * @return 初回加算コンテナ
   */
  protected ACLabelContainer getKaigoSupportStandardRadioContainer(){
    if(kaigoSupportStandardRadioContainer==null){
      kaigoSupportStandardRadioContainer = new ACLabelContainer();
      kaigoSupportStandardRadioContainer.setFollowChildEnabled(true);
      kaigoSupportStandardRadioContainer.setVAlignment(VRLayout.CENTER);
      kaigoSupportStandardRadioContainer.add(getKaigoSupportStandardRadio(), null);
    }
    return kaigoSupportStandardRadioContainer;
  }

  /**
   * 初回加算モデルを取得します。
   * @return 初回加算モデル
   */
  protected ACListModelAdapter getKaigoSupportStandardRadioModel(){
    if(kaigoSupportStandardRadioModel==null){
      kaigoSupportStandardRadioModel = new ACListModelAdapter();
      addKaigoSupportStandardRadioModel();
    }
    return kaigoSupportStandardRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getKaigoSupportStandardRadioItem1(){
    if(kaigoSupportStandardRadioItem1==null){

      kaigoSupportStandardRadioItem1 = new ACRadioButtonItem();

      kaigoSupportStandardRadioItem1.setText("なし");

      kaigoSupportStandardRadioItem1.setGroup(getKaigoSupportStandardRadio());

      kaigoSupportStandardRadioItem1.setConstraints(VRLayout.FLOW);

      addKaigoSupportStandardRadioItem1();
    }
    return kaigoSupportStandardRadioItem1;

  }

  /**
   * 初回を取得します。
   * @return 初回
   */
  public ACRadioButtonItem getKaigoSupportStandardRadioItem2(){
    if(kaigoSupportStandardRadioItem2==null){

      kaigoSupportStandardRadioItem2 = new ACRadioButtonItem();

      kaigoSupportStandardRadioItem2.setText("初回");

      kaigoSupportStandardRadioItem2.setGroup(getKaigoSupportStandardRadio());

      kaigoSupportStandardRadioItem2.setConstraints(VRLayout.FLOW);

      addKaigoSupportStandardRadioItem2();
    }
    return kaigoSupportStandardRadioItem2;

  }

  /**
   * 退院・退所時を取得します。
   * @return 退院・退所時
   */
  public ACRadioButtonItem getKaigoSupportStandardRadioItem3(){
    if(kaigoSupportStandardRadioItem3==null){

      kaigoSupportStandardRadioItem3 = new ACRadioButtonItem();

      kaigoSupportStandardRadioItem3.setText("退院・退所時");

      kaigoSupportStandardRadioItem3.setGroup(getKaigoSupportStandardRadio());

      kaigoSupportStandardRadioItem3.setConstraints(VRLayout.FLOW);

      addKaigoSupportStandardRadioItem3();
    }
    return kaigoSupportStandardRadioItem3;

  }

  /**
   * 特定事業所加算を取得します。
   * @return 特定事業所加算
   */
  public ACClearableRadioButtonGroup getKaigoSupportSpecificStandardRadio(){
    if(kaigoSupportSpecificStandardRadio==null){

      kaigoSupportSpecificStandardRadio = new ACClearableRadioButtonGroup();

      getKaigoSupportSpecificStandardRadioContainer().setText("特定事業所加算");

      kaigoSupportSpecificStandardRadio.setBindPath("1430106");

      kaigoSupportSpecificStandardRadio.setUseClearButton(false);

      kaigoSupportSpecificStandardRadio.setModel(getKaigoSupportSpecificStandardRadioModel());

      addKaigoSupportSpecificStandardRadio();
    }
    return kaigoSupportSpecificStandardRadio;

  }

  /**
   * 特定事業所加算コンテナを取得します。
   * @return 特定事業所加算コンテナ
   */
  protected ACLabelContainer getKaigoSupportSpecificStandardRadioContainer(){
    if(kaigoSupportSpecificStandardRadioContainer==null){
      kaigoSupportSpecificStandardRadioContainer = new ACLabelContainer();
      kaigoSupportSpecificStandardRadioContainer.setFollowChildEnabled(true);
      kaigoSupportSpecificStandardRadioContainer.setVAlignment(VRLayout.CENTER);
      kaigoSupportSpecificStandardRadioContainer.add(getKaigoSupportSpecificStandardRadio(), null);
    }
    return kaigoSupportSpecificStandardRadioContainer;
  }

  /**
   * 特定事業所加算モデルを取得します。
   * @return 特定事業所加算モデル
   */
  protected ACListModelAdapter getKaigoSupportSpecificStandardRadioModel(){
    if(kaigoSupportSpecificStandardRadioModel==null){
      kaigoSupportSpecificStandardRadioModel = new ACListModelAdapter();
      addKaigoSupportSpecificStandardRadioModel();
    }
    return kaigoSupportSpecificStandardRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getKaigoSupportSpecificStandardRadioItem1(){
    if(kaigoSupportSpecificStandardRadioItem1==null){

      kaigoSupportSpecificStandardRadioItem1 = new ACRadioButtonItem();

      kaigoSupportSpecificStandardRadioItem1.setText("なし");

      kaigoSupportSpecificStandardRadioItem1.setGroup(getKaigoSupportSpecificStandardRadio());

      kaigoSupportSpecificStandardRadioItem1.setConstraints(VRLayout.FLOW);

      addKaigoSupportSpecificStandardRadioItem1();
    }
    return kaigoSupportSpecificStandardRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getKaigoSupportSpecificStandardRadioItem2(){
    if(kaigoSupportSpecificStandardRadioItem2==null){

      kaigoSupportSpecificStandardRadioItem2 = new ACRadioButtonItem();

      kaigoSupportSpecificStandardRadioItem2.setText("あり");

      kaigoSupportSpecificStandardRadioItem2.setGroup(getKaigoSupportSpecificStandardRadio());

      kaigoSupportSpecificStandardRadioItem2.setConstraints(VRLayout.FLOW);

      addKaigoSupportSpecificStandardRadioItem2();
    }
    return kaigoSupportSpecificStandardRadioItem2;

  }

  /**
   * 介護支援専門員コンテナを取得します。
   * @return 介護支援専門員コンテナ
   */
  public ACGroupBox getKaigoSupportSpecialMemberContainer(){
    if(kaigoSupportSpecialMemberContainer==null){

      kaigoSupportSpecialMemberContainer = new ACGroupBox();

      kaigoSupportSpecialMemberContainer.setText("介護支援専門員情報");

      addKaigoSupportSpecialMemberContainer();
    }
    return kaigoSupportSpecialMemberContainer;

  }

  /**
   * 介護支援専門員番号を取得します。
   * @return 介護支援専門員番号
   */
  public ACTextField getKaigoSupportSpecialMemberNumber(){
    if(kaigoSupportSpecialMemberNumber==null){

      kaigoSupportSpecialMemberNumber = new ACTextField();

      getKaigoSupportSpecialMemberNumberContainer().setText("介護支援専門員番号");

      kaigoSupportSpecialMemberNumber.setBindPath("1430107");

      kaigoSupportSpecialMemberNumber.setColumns(6);

      kaigoSupportSpecialMemberNumber.setCharType(VRCharType.ONLY_DIGIT);

      kaigoSupportSpecialMemberNumber.setMaxLength(8);

      addKaigoSupportSpecialMemberNumber();
    }
    return kaigoSupportSpecialMemberNumber;

  }

  /**
   * 介護支援専門員番号コンテナを取得します。
   * @return 介護支援専門員番号コンテナ
   */
  protected ACLabelContainer getKaigoSupportSpecialMemberNumberContainer(){
    if(kaigoSupportSpecialMemberNumberContainer==null){
      kaigoSupportSpecialMemberNumberContainer = new ACLabelContainer();
      kaigoSupportSpecialMemberNumberContainer.setFollowChildEnabled(true);
      kaigoSupportSpecialMemberNumberContainer.setVAlignment(VRLayout.CENTER);
      kaigoSupportSpecialMemberNumberContainer.add(getKaigoSupportSpecialMemberNumber(), null);
    }
    return kaigoSupportSpecialMemberNumberContainer;
  }

  /**
   * 介護支援専門員氏名を取得します。
   * @return 介護支援専門員氏名
   */
  public ACComboBox getKaigoSupportSpecialMemberName(){
    if(kaigoSupportSpecialMemberName==null){

      kaigoSupportSpecialMemberName = new ACComboBox();

      getKaigoSupportSpecialMemberNameContainer().setText("介護支援専門員氏名");

      kaigoSupportSpecialMemberName.setEditable(false);

      kaigoSupportSpecialMemberName.setRenderBindPath("STAFF_NAME");

      kaigoSupportSpecialMemberName.setMaxLength(10);

      kaigoSupportSpecialMemberName.setModel(getKaigoSupportSpecialMemberNameModel());

      addKaigoSupportSpecialMemberName();
    }
    return kaigoSupportSpecialMemberName;

  }

  /**
   * 介護支援専門員氏名コンテナを取得します。
   * @return 介護支援専門員氏名コンテナ
   */
  protected ACLabelContainer getKaigoSupportSpecialMemberNameContainer(){
    if(kaigoSupportSpecialMemberNameContainer==null){
      kaigoSupportSpecialMemberNameContainer = new ACLabelContainer();
      kaigoSupportSpecialMemberNameContainer.setFollowChildEnabled(true);
      kaigoSupportSpecialMemberNameContainer.setVAlignment(VRLayout.CENTER);
      kaigoSupportSpecialMemberNameContainer.add(getKaigoSupportSpecialMemberName(), null);
    }
    return kaigoSupportSpecialMemberNameContainer;
  }

  /**
   * 介護支援専門員氏名モデルを取得します。
   * @return 介護支援専門員氏名モデル
   */
  protected ACComboBoxModelAdapter getKaigoSupportSpecialMemberNameModel(){
    if(kaigoSupportSpecialMemberNameModel==null){
      kaigoSupportSpecialMemberNameModel = new ACComboBoxModelAdapter();
      addKaigoSupportSpecialMemberNameModel();
    }
    return kaigoSupportSpecialMemberNameModel;
  }

  /**
   * コンストラクタです。
   */
  public QS001117Design() {

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

    this.add(getKaigoSupportPattern(), VRLayout.CLIENT);

  }

  /**
   * 居宅介護支援領域に内部項目を追加します。
   */
  protected void addKaigoSupportPattern(){

    kaigoSupportPattern.add(getKaigoSupportDivisionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    kaigoSupportPattern.add(getKaigoSupportManagementBasicRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    kaigoSupportPattern.add(getKaigoSupportSpecificProviderSubtractionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    kaigoSupportPattern.add(getKaigoSupportStandardRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    kaigoSupportPattern.add(getKaigoSupportSpecificStandardRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    kaigoSupportPattern.add(getKaigoSupportSpecialMemberContainer(), VRLayout.FLOW);

  }

  /**
   * 居宅介護支援費に内部項目を追加します。
   */
  protected void addKaigoSupportDivisionRadio(){

  }

  /**
   * 居宅介護支援費モデルに内部項目を追加します。
   */
  protected void addKaigoSupportDivisionRadioModel(){

    getKaigoSupportDivisionRadioItem1().setButtonIndex(1);
    getKaigoSupportDivisionRadioModel().add(getKaigoSupportDivisionRadioItem1());

    getKaigoSupportDivisionRadioItem2().setButtonIndex(2);
    getKaigoSupportDivisionRadioModel().add(getKaigoSupportDivisionRadioItem2());

    getKaigoSupportDivisionRadioItem3().setButtonIndex(3);
    getKaigoSupportDivisionRadioModel().add(getKaigoSupportDivisionRadioItem3());

    getKaigoSupportDivisionRadioItem4().setButtonIndex(4);
    getKaigoSupportDivisionRadioModel().add(getKaigoSupportDivisionRadioItem4());

  }

  /**
   * I型に内部項目を追加します。
   */
  protected void addKaigoSupportDivisionRadioItem1(){

  }

  /**
   * II型に内部項目を追加します。
   */
  protected void addKaigoSupportDivisionRadioItem2(){

  }

  /**
   * III型に内部項目を追加します。
   */
  protected void addKaigoSupportDivisionRadioItem3(){

  }

  /**
   * 経過的要介護に内部項目を追加します。
   */
  protected void addKaigoSupportDivisionRadioItem4(){

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

    getKaigoSupportManagementBasicRadioItem3().setButtonIndex(3);
    getKaigoSupportManagementBasicRadioModel().add(getKaigoSupportManagementBasicRadioItem3());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addKaigoSupportManagementBasicRadioItem1(){

  }

  /**
   * 減算要件該当に内部項目を追加します。
   */
  protected void addKaigoSupportManagementBasicRadioItem2(){

  }

  /**
   * 減算要件該当が2ヶ月以上に内部項目を追加します。
   */
  protected void addKaigoSupportManagementBasicRadioItem3(){

  }

  /**
   * 特定事業所集中減算に内部項目を追加します。
   */
  protected void addKaigoSupportSpecificProviderSubtractionRadio(){

  }

  /**
   * 特定事業所集中減算モデルに内部項目を追加します。
   */
  protected void addKaigoSupportSpecificProviderSubtractionRadioModel(){

    getKaigoSupportSpecificProviderSubtractionRadioItem1().setButtonIndex(1);
    getKaigoSupportSpecificProviderSubtractionRadioModel().add(getKaigoSupportSpecificProviderSubtractionRadioItem1());

    getKaigoSupportSpecificProviderSubtractionRadioItem2().setButtonIndex(2);
    getKaigoSupportSpecificProviderSubtractionRadioModel().add(getKaigoSupportSpecificProviderSubtractionRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addKaigoSupportSpecificProviderSubtractionRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addKaigoSupportSpecificProviderSubtractionRadioItem2(){

  }

  /**
   * 初回加算に内部項目を追加します。
   */
  protected void addKaigoSupportStandardRadio(){

  }

  /**
   * 初回加算モデルに内部項目を追加します。
   */
  protected void addKaigoSupportStandardRadioModel(){

    getKaigoSupportStandardRadioItem1().setButtonIndex(1);
    getKaigoSupportStandardRadioModel().add(getKaigoSupportStandardRadioItem1());

    getKaigoSupportStandardRadioItem2().setButtonIndex(2);
    getKaigoSupportStandardRadioModel().add(getKaigoSupportStandardRadioItem2());

    getKaigoSupportStandardRadioItem3().setButtonIndex(3);
    getKaigoSupportStandardRadioModel().add(getKaigoSupportStandardRadioItem3());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addKaigoSupportStandardRadioItem1(){

  }

  /**
   * 初回に内部項目を追加します。
   */
  protected void addKaigoSupportStandardRadioItem2(){

  }

  /**
   * 退院・退所時に内部項目を追加します。
   */
  protected void addKaigoSupportStandardRadioItem3(){

  }

  /**
   * 特定事業所加算に内部項目を追加します。
   */
  protected void addKaigoSupportSpecificStandardRadio(){

  }

  /**
   * 特定事業所加算モデルに内部項目を追加します。
   */
  protected void addKaigoSupportSpecificStandardRadioModel(){

    getKaigoSupportSpecificStandardRadioItem1().setButtonIndex(1);
    getKaigoSupportSpecificStandardRadioModel().add(getKaigoSupportSpecificStandardRadioItem1());

    getKaigoSupportSpecificStandardRadioItem2().setButtonIndex(2);
    getKaigoSupportSpecificStandardRadioModel().add(getKaigoSupportSpecificStandardRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addKaigoSupportSpecificStandardRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addKaigoSupportSpecificStandardRadioItem2(){

  }

  /**
   * 介護支援専門員コンテナに内部項目を追加します。
   */
  protected void addKaigoSupportSpecialMemberContainer(){

    kaigoSupportSpecialMemberContainer.add(getKaigoSupportSpecialMemberNumberContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    kaigoSupportSpecialMemberContainer.add(getKaigoSupportSpecialMemberNameContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * 介護支援専門員番号に内部項目を追加します。
   */
  protected void addKaigoSupportSpecialMemberNumber(){

  }

  /**
   * 介護支援専門員氏名に内部項目を追加します。
   */
  protected void addKaigoSupportSpecialMemberName(){

  }

  /**
   * 介護支援専門員氏名モデルに内部項目を追加します。
   */
  protected void addKaigoSupportSpecialMemberNameModel(){

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
      ACFrame.debugStart(new ACAffairInfo(QS001117Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QS001117Design getThis() {
    return this;
  }
}
