
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
 * 開発者: 藤原　伸
 * 作成日: 2006/09/19  日本コンピューター株式会社 藤原　伸 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 請求データ作成 (P)
 * プロセス 確認・修正 (003)
 * プログラム 利用者向け請求詳細編集 (QP003)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qp.qp003;
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
 * 利用者向け請求詳細編集画面項目デザイン(QP003) 
 */
public class QP003Design extends QkanAffairContainer implements ACAffairable {
  //GUIコンポーネント

  private ACAffairButtonBar buttons;

  private ACAffairButton open;

  private ACAffairButton insert;

  private ACAffairButton update;

  private ACPanel contents;

  private ACPanel contentPatients;

  private ACTextField contentPatientText;

  private ACLabel contentPatientID;

  private ACLabel contentPatientName;

  private ACPanel contentProviders;

  private ACTextField contentProviderText;

  private ACLabel contentProviderId;

  private ACLabel contentProviderName;

  private ACLabel contentSpace1;

  private ACPanel contentJikohutanArea;

  private ACPanel contentBillTitle;

  private ACTextField contentBill;

  private ACPanel contentJikohutanTitle;

  private ACTextField contentJikohutanHimokuTitle;

  private ACTextField contentJikohutanUseTitle;

  private ACPanel contentJikohutan1;

  private ACComboBox contentJikohutanHimoku1;

  private ACComboBoxModelAdapter contentJikohutanHimoku1Model;

  private ACTextField contentJikohutanUse1;

  private ACPanel contentJikohutan2;

  private ACComboBox contentJikohutanHimoku2;

  private ACComboBoxModelAdapter contentJikohutanHimoku2Model;

  private ACTextField contentJikohutanUse2;

  private ACPanel contentJikohutan3;

  private ACComboBox contentJikohutanHimoku3;

  private ACComboBoxModelAdapter contentJikohutanHimoku3Model;

  private ACTextField contentJikohutanUse3;

  private ACPanel contentJikohutanTitleArea;

  private ACTextField contentJikohutanSubtotalTitle;

  private ACTextField contentJikohutanSubtotal;

  private ACLabel contentSpace2;

  private ACPanel contentEtcs;

  private ACPanel contentEtcTitle;

  private ACTextField contentEtcHimokuTitle;

  private ACTextField contentEtcUseTitle;

  private ACPanel contentEtc1;

  private ACComboBox contentEtcHimoku1;

  private ACComboBoxModelAdapter contentEtcHimoku1Model;

  private ACTextField contentEtcUse1;

  private ACPanel contentEtc2;

  private ACComboBox contentEtcHimoku2;

  private ACComboBoxModelAdapter contentEtcHimoku2Model;

  private ACTextField contentEtcUse2;

  private ACPanel contentEtc3;

  private ACComboBox contentEtcHimoku3;

  private ACComboBoxModelAdapter contentEtcHimoku3Model;

  private ACTextField contentEtcUse3;

  private ACPanel contentEtc4;

  private ACComboBox contentEtcHimoku4;

  private ACComboBoxModelAdapter contentEtcHimoku4Model;

  private ACTextField contentEtcUse4;

  private ACPanel contentEtc5;

  private ACComboBox contentEtcHimoku5;

  private ACComboBoxModelAdapter contentEtcHimoku5Model;

  private ACTextField contentEtcUse5;

  private ACPanel contentEtcTitleArea;

  private ACTextField contentEtcSubtotalTitle;

  private ACTextField contentEtcSubtotal;

  private ACLabel contentSpace3;

  private ACPanel contentBottoms;

  private ACPanel contentTotals;

  private ACLabel contentTotalLabel;

  private ACTextField contentTotalText;

  private ACLabel contentKoujyoLabel;

  private ACTextField contentKoujyoText;

  //getter

  /**
   * ボタンバーを取得します。
   * @return ボタンバー
   */
  public ACAffairButtonBar getButtons(){
    if(buttons==null){

      buttons = new ACAffairButtonBar();

      buttons.setText("利用者向け請求詳細編集画面");

      addButtons();
    }
    return buttons;

  }

  /**
   * 前回読込み(O)を取得します。
   * @return 前回読込み(O)
   */
  public ACAffairButton getOpen(){
    if(open==null){

      open = new ACAffairButton();

      open.setText("前回読込(O)");

      open.setToolTipText("過去のデータの中で、最新のデータを引き継ぎます。");

      open.setMnemonic('O');

      open.setIconPath(ACConstants.ICON_PATH_OPEN_24);

      addOpen();
    }
    return open;

  }

  /**
   * 登録ボタン(S)を取得します。
   * @return 登録ボタン(S)
   */
  public ACAffairButton getInsert(){
    if(insert==null){

      insert = new ACAffairButton();

      insert.setText("登録(S)");

      insert.setToolTipText("現在の内容を登録します。");

      insert.setMnemonic('S');

      insert.setIconPath(ACConstants.ICON_PATH_UPDATE_24);

      addInsert();
    }
    return insert;

  }

  /**
   * 更新ボタン(S)を取得します。
   * @return 更新ボタン(S)
   */
  public ACAffairButton getUpdate(){
    if(update==null){

      update = new ACAffairButton();

      update.setText("更新(S)");

      update.setToolTipText("現在の内容を更新します。");

      update.setMnemonic('S');

      update.setIconPath(ACConstants.ICON_PATH_UPDATE_24);

      addUpdate();
    }
    return update;

  }

  /**
   * クライアント領域を取得します。
   * @return クライアント領域
   */
  public ACPanel getContents(){
    if(contents==null){

      contents = new ACPanel();

      contents.setAutoWrap(false);

      contents.setHgap(0);

      addContents();
    }
    return contents;

  }

  /**
   * 利用者情報領域を取得します。
   * @return 利用者情報領域
   */
  public ACPanel getContentPatients(){
    if(contentPatients==null){

      contentPatients = new ACPanel();

      contentPatients.setAutoWrap(false);

      addContentPatients();
    }
    return contentPatients;

  }

  /**
   * 利用者を取得します。
   * @return 利用者
   */
  public ACTextField getContentPatientText(){
    if(contentPatientText==null){

      contentPatientText = new ACTextField();

      contentPatientText.setText("利用者");

      contentPatientText.setEditable(false);

      addContentPatientText();
    }
    return contentPatientText;

  }

  /**
   * 利用者IDを取得します。
   * @return 利用者ID
   */
  public ACLabel getContentPatientID(){
    if(contentPatientID==null){

      contentPatientID = new ACLabel();

      contentPatientID.setText("9999999999");

      contentPatientID.setBindPath("PATIENT_CODE");

      addContentPatientID();
    }
    return contentPatientID;

  }

  /**
   * 利用者名を取得します。
   * @return 利用者名
   */
  public ACLabel getContentPatientName(){
    if(contentPatientName==null){

      contentPatientName = new ACLabel();

      contentPatientName.setText("利用者　氏名");

      contentPatientName.setBindPath("PATIENT_NAME");

      addContentPatientName();
    }
    return contentPatientName;

  }

  /**
   * 事業所情報領域を取得します。
   * @return 事業所情報領域
   */
  public ACPanel getContentProviders(){
    if(contentProviders==null){

      contentProviders = new ACPanel();

      contentProviders.setAutoWrap(false);

      addContentProviders();
    }
    return contentProviders;

  }

  /**
   * 事業所を取得します。
   * @return 事業所
   */
  public ACTextField getContentProviderText(){
    if(contentProviderText==null){

      contentProviderText = new ACTextField();

      contentProviderText.setText("事業所");

      contentProviderText.setEditable(false);

      addContentProviderText();
    }
    return contentProviderText;

  }

  /**
   * 事業所IDを取得します。
   * @return 事業所ID
   */
  public ACLabel getContentProviderId(){
    if(contentProviderId==null){

      contentProviderId = new ACLabel();

      contentProviderId.setText("9999999999");

      contentProviderId.setBindPath("PROVIDER_ID");

      addContentProviderId();
    }
    return contentProviderId;

  }

  /**
   * 事業所名称を取得します。
   * @return 事業所名称
   */
  public ACLabel getContentProviderName(){
    if(contentProviderName==null){

      contentProviderName = new ACLabel();

      contentProviderName.setText("事業所　名称");

      contentProviderName.setBindPath("PROVIDER_NAME");

      addContentProviderName();
    }
    return contentProviderName;

  }

  /**
   * スペーサーを取得します。
   * @return スペーサー
   */
  public ACLabel getContentSpace1(){
    if(contentSpace1==null){

      contentSpace1 = new ACLabel();

      contentSpace1.setText(" ");

      addContentSpace1();
    }
    return contentSpace1;

  }

  /**
   * 自己負担分領域を取得します。
   * @return 自己負担分領域
   */
  public ACPanel getContentJikohutanArea(){
    if(contentJikohutanArea==null){

      contentJikohutanArea = new ACPanel();

      contentJikohutanArea.setAutoWrap(false);

      addContentJikohutanArea();
    }
    return contentJikohutanArea;

  }

  /**
   * 項目タイトルを取得します。
   * @return 項目タイトル
   */
  public ACPanel getContentBillTitle(){
    if(contentBillTitle==null){

      contentBillTitle = new ACPanel();

      addContentBillTitle();
    }
    return contentBillTitle;

  }

  /**
   * 請求対象年月を取得します。
   * @return 請求対象年月
   */
  public ACTextField getContentBill(){
    if(contentBill==null){

      contentBill = new ACTextField();

      contentBill.setText("平成○○年○○月分請求");

      contentBill.setBindPath("TARGET_DATE");

      contentBill.setEditable(false);

      contentBill.setColumns(26);

      contentBill.setFormat(new ACBorderBlankDateFormat("gggee年MM月"));

      contentBill.setHorizontalAlignment(SwingConstants.CENTER);

      addContentBill();
    }
    return contentBill;

  }

  /**
   * 全額自己負担分タイトルを取得します。
   * @return 全額自己負担分タイトル
   */
  public ACPanel getContentJikohutanTitle(){
    if(contentJikohutanTitle==null){

      contentJikohutanTitle = new ACPanel();

      contentJikohutanTitle.setAutoWrap(false);

      addContentJikohutanTitle();
    }
    return contentJikohutanTitle;

  }

  /**
   * 全額自己負担分費目タイトルを取得します。
   * @return 全額自己負担分費目タイトル
   */
  public ACTextField getContentJikohutanHimokuTitle(){
    if(contentJikohutanHimokuTitle==null){

      contentJikohutanHimokuTitle = new ACTextField();

      contentJikohutanHimokuTitle.setText("全額自己負担分　費目");

      contentJikohutanHimokuTitle.setEditable(false);

      contentJikohutanHimokuTitle.setColumns(26);

      contentJikohutanHimokuTitle.setHorizontalAlignment(SwingConstants.CENTER);

      addContentJikohutanHimokuTitle();
    }
    return contentJikohutanHimokuTitle;

  }

  /**
   * 全額自己負担分利用料タイトルを取得します。
   * @return 全額自己負担分利用料タイトル
   */
  public ACTextField getContentJikohutanUseTitle(){
    if(contentJikohutanUseTitle==null){

      contentJikohutanUseTitle = new ACTextField();

      contentJikohutanUseTitle.setText("利用料");

      contentJikohutanUseTitle.setEditable(false);

      contentJikohutanUseTitle.setColumns(9);

      contentJikohutanUseTitle.setHorizontalAlignment(SwingConstants.CENTER);

      addContentJikohutanUseTitle();
    }
    return contentJikohutanUseTitle;

  }

  /**
   * 全額自己負担分１を取得します。
   * @return 全額自己負担分１
   */
  public ACPanel getContentJikohutan1(){
    if(contentJikohutan1==null){

      contentJikohutan1 = new ACPanel();

      contentJikohutan1.setAutoWrap(false);

      addContentJikohutan1();
    }
    return contentJikohutan1;

  }

  /**
   * 全額自己負担分費目１を取得します。
   * @return 全額自己負担分費目１
   */
  public ACComboBox getContentJikohutanHimoku1(){
    if(contentJikohutanHimoku1==null){

      contentJikohutanHimoku1 = new ACComboBox();

      contentJikohutanHimoku1.setBindPath("SELF_SERVICE_NO1");

      contentJikohutanHimoku1.setEditable(true);

      contentJikohutanHimoku1.setColumns(25);

      contentJikohutanHimoku1.setModelBindPath("SELF_PAY");

      contentJikohutanHimoku1.setBlankable(false);

      contentJikohutanHimoku1.setIMEMode(InputSubset.KANJI);

      contentJikohutanHimoku1.setMaxLength(75);

      contentJikohutanHimoku1.setMaxColumns(25);

      contentJikohutanHimoku1.setModel(getContentJikohutanHimoku1Model());

      addContentJikohutanHimoku1();
    }
    return contentJikohutanHimoku1;

  }

  /**
   * 全額自己負担分費目１モデルを取得します。
   * @return 全額自己負担分費目１モデル
   */
  protected ACComboBoxModelAdapter getContentJikohutanHimoku1Model(){
    if(contentJikohutanHimoku1Model==null){
      contentJikohutanHimoku1Model = new ACComboBoxModelAdapter();
      addContentJikohutanHimoku1Model();
    }
    return contentJikohutanHimoku1Model;
  }

  /**
   * 全額自己負担分利用料１を取得します。
   * @return 全額自己負担分利用料１
   */
  public ACTextField getContentJikohutanUse1(){
    if(contentJikohutanUse1==null){

      contentJikohutanUse1 = new ACTextField();

      contentJikohutanUse1.setBindPath("SELF_PAY_NO1");

      contentJikohutanUse1.setColumns(9);

      contentJikohutanUse1.setCharType(VRCharType.ONLY_NUMBER);

      contentJikohutanUse1.setHorizontalAlignment(SwingConstants.RIGHT);

      contentJikohutanUse1.setIMEMode(InputSubset.LATIN);

      contentJikohutanUse1.setMaxLength(8);

      addContentJikohutanUse1();
    }
    return contentJikohutanUse1;

  }

  /**
   * 全額自己負担分２を取得します。
   * @return 全額自己負担分２
   */
  public ACPanel getContentJikohutan2(){
    if(contentJikohutan2==null){

      contentJikohutan2 = new ACPanel();

      contentJikohutan2.setAutoWrap(false);

      addContentJikohutan2();
    }
    return contentJikohutan2;

  }

  /**
   * 全額自己負担分費目２を取得します。
   * @return 全額自己負担分費目２
   */
  public ACComboBox getContentJikohutanHimoku2(){
    if(contentJikohutanHimoku2==null){

      contentJikohutanHimoku2 = new ACComboBox();

      contentJikohutanHimoku2.setBindPath("SELF_SERVICE_NO2");

      contentJikohutanHimoku2.setEditable(true);

      contentJikohutanHimoku2.setColumns(25);

      contentJikohutanHimoku2.setModelBindPath("SELF_PAY");

      contentJikohutanHimoku2.setBlankable(false);

      contentJikohutanHimoku2.setIMEMode(InputSubset.KANJI);

      contentJikohutanHimoku2.setMaxLength(75);

      contentJikohutanHimoku2.setMaxColumns(25);

      contentJikohutanHimoku2.setModel(getContentJikohutanHimoku2Model());

      addContentJikohutanHimoku2();
    }
    return contentJikohutanHimoku2;

  }

  /**
   * 全額自己負担分費目２モデルを取得します。
   * @return 全額自己負担分費目２モデル
   */
  protected ACComboBoxModelAdapter getContentJikohutanHimoku2Model(){
    if(contentJikohutanHimoku2Model==null){
      contentJikohutanHimoku2Model = new ACComboBoxModelAdapter();
      addContentJikohutanHimoku2Model();
    }
    return contentJikohutanHimoku2Model;
  }

  /**
   * 全額自己負担分利用料２を取得します。
   * @return 全額自己負担分利用料２
   */
  public ACTextField getContentJikohutanUse2(){
    if(contentJikohutanUse2==null){

      contentJikohutanUse2 = new ACTextField();

      contentJikohutanUse2.setBindPath("SELF_PAY_NO2");

      contentJikohutanUse2.setColumns(9);

      contentJikohutanUse2.setCharType(VRCharType.ONLY_NUMBER);

      contentJikohutanUse2.setHorizontalAlignment(SwingConstants.RIGHT);

      contentJikohutanUse2.setIMEMode(InputSubset.LATIN);

      contentJikohutanUse2.setMaxLength(8);

      addContentJikohutanUse2();
    }
    return contentJikohutanUse2;

  }

  /**
   * 全額自己負担分３を取得します。
   * @return 全額自己負担分３
   */
  public ACPanel getContentJikohutan3(){
    if(contentJikohutan3==null){

      contentJikohutan3 = new ACPanel();

      contentJikohutan3.setAutoWrap(false);

      addContentJikohutan3();
    }
    return contentJikohutan3;

  }

  /**
   * 全額自己負担分費目３を取得します。
   * @return 全額自己負担分費目３
   */
  public ACComboBox getContentJikohutanHimoku3(){
    if(contentJikohutanHimoku3==null){

      contentJikohutanHimoku3 = new ACComboBox();

      contentJikohutanHimoku3.setBindPath("SELF_SERVICE_NO3");

      contentJikohutanHimoku3.setEditable(true);

      contentJikohutanHimoku3.setColumns(25);

      contentJikohutanHimoku3.setModelBindPath("SELF_PAY");

      contentJikohutanHimoku3.setBlankable(false);

      contentJikohutanHimoku3.setIMEMode(InputSubset.KANJI);

      contentJikohutanHimoku3.setMaxLength(75);

      contentJikohutanHimoku3.setMaxColumns(25);

      contentJikohutanHimoku3.setModel(getContentJikohutanHimoku3Model());

      addContentJikohutanHimoku3();
    }
    return contentJikohutanHimoku3;

  }

  /**
   * 全額自己負担分費目３モデルを取得します。
   * @return 全額自己負担分費目３モデル
   */
  protected ACComboBoxModelAdapter getContentJikohutanHimoku3Model(){
    if(contentJikohutanHimoku3Model==null){
      contentJikohutanHimoku3Model = new ACComboBoxModelAdapter();
      addContentJikohutanHimoku3Model();
    }
    return contentJikohutanHimoku3Model;
  }

  /**
   * 全額自己負担分利用料３を取得します。
   * @return 全額自己負担分利用料３
   */
  public ACTextField getContentJikohutanUse3(){
    if(contentJikohutanUse3==null){

      contentJikohutanUse3 = new ACTextField();

      contentJikohutanUse3.setBindPath("SELF_PAY_NO3");

      contentJikohutanUse3.setColumns(9);

      contentJikohutanUse3.setCharType(VRCharType.ONLY_NUMBER);

      contentJikohutanUse3.setHorizontalAlignment(SwingConstants.RIGHT);

      contentJikohutanUse3.setIMEMode(InputSubset.LATIN);

      contentJikohutanUse3.setMaxLength(8);

      addContentJikohutanUse3();
    }
    return contentJikohutanUse3;

  }

  /**
   * 全額自己負担分小計を取得します。
   * @return 全額自己負担分小計
   */
  public ACPanel getContentJikohutanTitleArea(){
    if(contentJikohutanTitleArea==null){

      contentJikohutanTitleArea = new ACPanel();

      contentJikohutanTitleArea.setAutoWrap(false);

      addContentJikohutanTitleArea();
    }
    return contentJikohutanTitleArea;

  }

  /**
   * 全額自己負担小計タイトルを取得します。
   * @return 全額自己負担小計タイトル
   */
  public ACTextField getContentJikohutanSubtotalTitle(){
    if(contentJikohutanSubtotalTitle==null){

      contentJikohutanSubtotalTitle = new ACTextField();

      contentJikohutanSubtotalTitle.setText("小計");

      contentJikohutanSubtotalTitle.setEditable(false);

      contentJikohutanSubtotalTitle.setColumns(26);

      contentJikohutanSubtotalTitle.setHorizontalAlignment(SwingConstants.CENTER);

      addContentJikohutanSubtotalTitle();
    }
    return contentJikohutanSubtotalTitle;

  }

  /**
   * 全額自己負担小計を取得します。
   * @return 全額自己負担小計
   */
  public ACTextField getContentJikohutanSubtotal(){
    if(contentJikohutanSubtotal==null){

      contentJikohutanSubtotal = new ACTextField();

      contentJikohutanSubtotal.setEditable(false);

      contentJikohutanSubtotal.setColumns(9);

      contentJikohutanSubtotal.setHorizontalAlignment(SwingConstants.RIGHT);

      addContentJikohutanSubtotal();
    }
    return contentJikohutanSubtotal;

  }

  /**
   * スペーサーを取得します。
   * @return スペーサー
   */
  public ACLabel getContentSpace2(){
    if(contentSpace2==null){

      contentSpace2 = new ACLabel();

      contentSpace2.setText(" ");

      addContentSpace2();
    }
    return contentSpace2;

  }

  /**
   * その他パネルを取得します。
   * @return その他パネル
   */
  public ACPanel getContentEtcs(){
    if(contentEtcs==null){

      contentEtcs = new ACPanel();

      addContentEtcs();
    }
    return contentEtcs;

  }

  /**
   * その他タイトルを取得します。
   * @return その他タイトル
   */
  public ACPanel getContentEtcTitle(){
    if(contentEtcTitle==null){

      contentEtcTitle = new ACPanel();

      contentEtcTitle.setAutoWrap(false);

      addContentEtcTitle();
    }
    return contentEtcTitle;

  }

  /**
   * その他費目タイトルを取得します。
   * @return その他費目タイトル
   */
  public ACTextField getContentEtcHimokuTitle(){
    if(contentEtcHimokuTitle==null){

      contentEtcHimokuTitle = new ACTextField();

      contentEtcHimokuTitle.setText("その他　費目");

      contentEtcHimokuTitle.setEditable(false);

      contentEtcHimokuTitle.setColumns(26);

      contentEtcHimokuTitle.setHorizontalAlignment(SwingConstants.CENTER);

      addContentEtcHimokuTitle();
    }
    return contentEtcHimokuTitle;

  }

  /**
   * その他利用料タイトルを取得します。
   * @return その他利用料タイトル
   */
  public ACTextField getContentEtcUseTitle(){
    if(contentEtcUseTitle==null){

      contentEtcUseTitle = new ACTextField();

      contentEtcUseTitle.setText("利用料");

      contentEtcUseTitle.setEditable(false);

      contentEtcUseTitle.setColumns(9);

      contentEtcUseTitle.setHorizontalAlignment(SwingConstants.CENTER);

      addContentEtcUseTitle();
    }
    return contentEtcUseTitle;

  }

  /**
   * その他１を取得します。
   * @return その他１
   */
  public ACPanel getContentEtc1(){
    if(contentEtc1==null){

      contentEtc1 = new ACPanel();

      contentEtc1.setAutoWrap(false);

      addContentEtc1();
    }
    return contentEtc1;

  }

  /**
   * その他費目１を取得します。
   * @return その他費目１
   */
  public ACComboBox getContentEtcHimoku1(){
    if(contentEtcHimoku1==null){

      contentEtcHimoku1 = new ACComboBox();

      contentEtcHimoku1.setBindPath("OTHER_HIMOKU_NO1");

      contentEtcHimoku1.setEditable(true);

      contentEtcHimoku1.setColumns(25);

      contentEtcHimoku1.setModelBindPath("OTHER");

      contentEtcHimoku1.setBlankable(false);

      contentEtcHimoku1.setIMEMode(InputSubset.KANJI);

      contentEtcHimoku1.setMaxLength(75);

      contentEtcHimoku1.setMaxColumns(25);

      contentEtcHimoku1.setModel(getContentEtcHimoku1Model());

      addContentEtcHimoku1();
    }
    return contentEtcHimoku1;

  }

  /**
   * その他費目１モデルを取得します。
   * @return その他費目１モデル
   */
  protected ACComboBoxModelAdapter getContentEtcHimoku1Model(){
    if(contentEtcHimoku1Model==null){
      contentEtcHimoku1Model = new ACComboBoxModelAdapter();
      addContentEtcHimoku1Model();
    }
    return contentEtcHimoku1Model;
  }

  /**
   * その他利用料１を取得します。
   * @return その他利用料１
   */
  public ACTextField getContentEtcUse1(){
    if(contentEtcUse1==null){

      contentEtcUse1 = new ACTextField();

      contentEtcUse1.setBindPath("OTHER_PAY_NO1");

      contentEtcUse1.setColumns(9);

      contentEtcUse1.setCharType(VRCharType.ONLY_NUMBER);

      contentEtcUse1.setHorizontalAlignment(SwingConstants.RIGHT);

      contentEtcUse1.setIMEMode(InputSubset.LATIN);

      contentEtcUse1.setMaxLength(8);

      addContentEtcUse1();
    }
    return contentEtcUse1;

  }

  /**
   * その他２を取得します。
   * @return その他２
   */
  public ACPanel getContentEtc2(){
    if(contentEtc2==null){

      contentEtc2 = new ACPanel();

      contentEtc2.setAutoWrap(false);

      addContentEtc2();
    }
    return contentEtc2;

  }

  /**
   * その他費目２を取得します。
   * @return その他費目２
   */
  public ACComboBox getContentEtcHimoku2(){
    if(contentEtcHimoku2==null){

      contentEtcHimoku2 = new ACComboBox();

      contentEtcHimoku2.setBindPath("OTHER_HIMOKU_NO2");

      contentEtcHimoku2.setEditable(true);

      contentEtcHimoku2.setColumns(25);

      contentEtcHimoku2.setModelBindPath("OTHER");

      contentEtcHimoku2.setBlankable(false);

      contentEtcHimoku2.setIMEMode(InputSubset.KANJI);

      contentEtcHimoku2.setMaxLength(75);

      contentEtcHimoku2.setMaxColumns(25);

      contentEtcHimoku2.setModel(getContentEtcHimoku2Model());

      addContentEtcHimoku2();
    }
    return contentEtcHimoku2;

  }

  /**
   * その他費目２モデルを取得します。
   * @return その他費目２モデル
   */
  protected ACComboBoxModelAdapter getContentEtcHimoku2Model(){
    if(contentEtcHimoku2Model==null){
      contentEtcHimoku2Model = new ACComboBoxModelAdapter();
      addContentEtcHimoku2Model();
    }
    return contentEtcHimoku2Model;
  }

  /**
   * その他利用料２を取得します。
   * @return その他利用料２
   */
  public ACTextField getContentEtcUse2(){
    if(contentEtcUse2==null){

      contentEtcUse2 = new ACTextField();

      contentEtcUse2.setBindPath("OTHER_PAY_NO2");

      contentEtcUse2.setColumns(9);

      contentEtcUse2.setCharType(VRCharType.ONLY_NUMBER);

      contentEtcUse2.setHorizontalAlignment(SwingConstants.RIGHT);

      contentEtcUse2.setIMEMode(InputSubset.LATIN);

      contentEtcUse2.setMaxLength(8);

      addContentEtcUse2();
    }
    return contentEtcUse2;

  }

  /**
   * その他３を取得します。
   * @return その他３
   */
  public ACPanel getContentEtc3(){
    if(contentEtc3==null){

      contentEtc3 = new ACPanel();

      contentEtc3.setAutoWrap(false);

      addContentEtc3();
    }
    return contentEtc3;

  }

  /**
   * その他費目３を取得します。
   * @return その他費目３
   */
  public ACComboBox getContentEtcHimoku3(){
    if(contentEtcHimoku3==null){

      contentEtcHimoku3 = new ACComboBox();

      contentEtcHimoku3.setBindPath("OTHER_HIMOKU_NO3");

      contentEtcHimoku3.setEditable(true);

      contentEtcHimoku3.setColumns(25);

      contentEtcHimoku3.setModelBindPath("OTHER");

      contentEtcHimoku3.setBlankable(false);

      contentEtcHimoku3.setIMEMode(InputSubset.KANJI);

      contentEtcHimoku3.setMaxLength(75);

      contentEtcHimoku3.setMaxColumns(25);

      contentEtcHimoku3.setModel(getContentEtcHimoku3Model());

      addContentEtcHimoku3();
    }
    return contentEtcHimoku3;

  }

  /**
   * その他費目３モデルを取得します。
   * @return その他費目３モデル
   */
  protected ACComboBoxModelAdapter getContentEtcHimoku3Model(){
    if(contentEtcHimoku3Model==null){
      contentEtcHimoku3Model = new ACComboBoxModelAdapter();
      addContentEtcHimoku3Model();
    }
    return contentEtcHimoku3Model;
  }

  /**
   * その他利用料３を取得します。
   * @return その他利用料３
   */
  public ACTextField getContentEtcUse3(){
    if(contentEtcUse3==null){

      contentEtcUse3 = new ACTextField();

      contentEtcUse3.setBindPath("OTHER_PAY_NO3");

      contentEtcUse3.setColumns(9);

      contentEtcUse3.setCharType(VRCharType.ONLY_NUMBER);

      contentEtcUse3.setHorizontalAlignment(SwingConstants.RIGHT);

      contentEtcUse3.setIMEMode(InputSubset.LATIN);

      contentEtcUse3.setMaxLength(8);

      addContentEtcUse3();
    }
    return contentEtcUse3;

  }

  /**
   * その他４を取得します。
   * @return その他４
   */
  public ACPanel getContentEtc4(){
    if(contentEtc4==null){

      contentEtc4 = new ACPanel();

      contentEtc4.setAutoWrap(false);

      addContentEtc4();
    }
    return contentEtc4;

  }

  /**
   * その他費目４を取得します。
   * @return その他費目４
   */
  public ACComboBox getContentEtcHimoku4(){
    if(contentEtcHimoku4==null){

      contentEtcHimoku4 = new ACComboBox();

      contentEtcHimoku4.setBindPath("OTHER_HIMOKU_NO4");

      contentEtcHimoku4.setEditable(true);

      contentEtcHimoku4.setColumns(25);

      contentEtcHimoku4.setModelBindPath("OTHER");

      contentEtcHimoku4.setBlankable(false);

      contentEtcHimoku4.setIMEMode(InputSubset.KANJI);

      contentEtcHimoku4.setMaxLength(75);

      contentEtcHimoku4.setMaxColumns(25);

      contentEtcHimoku4.setModel(getContentEtcHimoku4Model());

      addContentEtcHimoku4();
    }
    return contentEtcHimoku4;

  }

  /**
   * その他費目４モデルを取得します。
   * @return その他費目４モデル
   */
  protected ACComboBoxModelAdapter getContentEtcHimoku4Model(){
    if(contentEtcHimoku4Model==null){
      contentEtcHimoku4Model = new ACComboBoxModelAdapter();
      addContentEtcHimoku4Model();
    }
    return contentEtcHimoku4Model;
  }

  /**
   * その他利用料４を取得します。
   * @return その他利用料４
   */
  public ACTextField getContentEtcUse4(){
    if(contentEtcUse4==null){

      contentEtcUse4 = new ACTextField();

      contentEtcUse4.setBindPath("OTHER_PAY_NO4");

      contentEtcUse4.setColumns(9);

      contentEtcUse4.setCharType(VRCharType.ONLY_NUMBER);

      contentEtcUse4.setHorizontalAlignment(SwingConstants.RIGHT);

      contentEtcUse4.setIMEMode(InputSubset.LATIN);

      contentEtcUse4.setMaxLength(8);

      addContentEtcUse4();
    }
    return contentEtcUse4;

  }

  /**
   * その他５を取得します。
   * @return その他５
   */
  public ACPanel getContentEtc5(){
    if(contentEtc5==null){

      contentEtc5 = new ACPanel();

      contentEtc5.setAutoWrap(false);

      addContentEtc5();
    }
    return contentEtc5;

  }

  /**
   * その他費目５を取得します。
   * @return その他費目５
   */
  public ACComboBox getContentEtcHimoku5(){
    if(contentEtcHimoku5==null){

      contentEtcHimoku5 = new ACComboBox();

      contentEtcHimoku5.setBindPath("OTHER_HIMOKU_NO5");

      contentEtcHimoku5.setEditable(true);

      contentEtcHimoku5.setColumns(25);

      contentEtcHimoku5.setModelBindPath("OTHER");

      contentEtcHimoku5.setBlankable(false);

      contentEtcHimoku5.setIMEMode(InputSubset.KANJI);

      contentEtcHimoku5.setMaxLength(75);

      contentEtcHimoku5.setMaxColumns(25);

      contentEtcHimoku5.setModel(getContentEtcHimoku5Model());

      addContentEtcHimoku5();
    }
    return contentEtcHimoku5;

  }

  /**
   * その他費目５モデルを取得します。
   * @return その他費目５モデル
   */
  protected ACComboBoxModelAdapter getContentEtcHimoku5Model(){
    if(contentEtcHimoku5Model==null){
      contentEtcHimoku5Model = new ACComboBoxModelAdapter();
      addContentEtcHimoku5Model();
    }
    return contentEtcHimoku5Model;
  }

  /**
   * その他利用料５を取得します。
   * @return その他利用料５
   */
  public ACTextField getContentEtcUse5(){
    if(contentEtcUse5==null){

      contentEtcUse5 = new ACTextField();

      contentEtcUse5.setBindPath("OTHER_PAY_NO5");

      contentEtcUse5.setColumns(9);

      contentEtcUse5.setCharType(VRCharType.ONLY_NUMBER);

      contentEtcUse5.setHorizontalAlignment(SwingConstants.RIGHT);

      contentEtcUse5.setIMEMode(InputSubset.LATIN);

      contentEtcUse5.setMaxLength(8);

      addContentEtcUse5();
    }
    return contentEtcUse5;

  }

  /**
   * その他小計を取得します。
   * @return その他小計
   */
  public ACPanel getContentEtcTitleArea(){
    if(contentEtcTitleArea==null){

      contentEtcTitleArea = new ACPanel();

      contentEtcTitleArea.setAutoWrap(false);

      addContentEtcTitleArea();
    }
    return contentEtcTitleArea;

  }

  /**
   * その他費用小計タイトルを取得します。
   * @return その他費用小計タイトル
   */
  public ACTextField getContentEtcSubtotalTitle(){
    if(contentEtcSubtotalTitle==null){

      contentEtcSubtotalTitle = new ACTextField();

      contentEtcSubtotalTitle.setText("小計");

      contentEtcSubtotalTitle.setEditable(false);

      contentEtcSubtotalTitle.setColumns(26);

      contentEtcSubtotalTitle.setHorizontalAlignment(SwingConstants.CENTER);

      addContentEtcSubtotalTitle();
    }
    return contentEtcSubtotalTitle;

  }

  /**
   * その他費用小計を取得します。
   * @return その他費用小計
   */
  public ACTextField getContentEtcSubtotal(){
    if(contentEtcSubtotal==null){

      contentEtcSubtotal = new ACTextField();

      contentEtcSubtotal.setEditable(false);

      contentEtcSubtotal.setColumns(9);

      contentEtcSubtotal.setHorizontalAlignment(SwingConstants.RIGHT);

      addContentEtcSubtotal();
    }
    return contentEtcSubtotal;

  }

  /**
   * スペーサーを取得します。
   * @return スペーサー
   */
  public ACLabel getContentSpace3(){
    if(contentSpace3==null){

      contentSpace3 = new ACLabel();

      contentSpace3.setText(" ");

      addContentSpace3();
    }
    return contentSpace3;

  }

  /**
   * 画面下部パネルを取得します。
   * @return 画面下部パネル
   */
  public ACPanel getContentBottoms(){
    if(contentBottoms==null){

      contentBottoms = new ACPanel();

      addContentBottoms();
    }
    return contentBottoms;

  }

  /**
   * 金額パネルを取得します。
   * @return 金額パネル
   */
  public ACPanel getContentTotals(){
    if(contentTotals==null){

      contentTotals = new ACPanel();

      addContentTotals();
    }
    return contentTotals;

  }

  /**
   * 合計額ラベルを取得します。
   * @return 合計額ラベル
   */
  public ACLabel getContentTotalLabel(){
    if(contentTotalLabel==null){

      contentTotalLabel = new ACLabel();

      contentTotalLabel.setText("合計額");

      addContentTotalLabel();
    }
    return contentTotalLabel;

  }

  /**
   * 合計額を取得します。
   * @return 合計額
   */
  public ACTextField getContentTotalText(){
    if(contentTotalText==null){

      contentTotalText = new ACTextField();

      contentTotalText.setBindPath("SUM");

      contentTotalText.setEnabled(false);

      contentTotalText.setColumns(10);

      contentTotalText.setHorizontalAlignment(SwingConstants.RIGHT);

      addContentTotalText();
    }
    return contentTotalText;

  }

  /**
   * 医療費控除対象額ラベルを取得します。
   * @return 医療費控除対象額ラベル
   */
  public ACLabel getContentKoujyoLabel(){
    if(contentKoujyoLabel==null){

      contentKoujyoLabel = new ACLabel();

      contentKoujyoLabel.setText("うち医療費控除対象額");

      addContentKoujyoLabel();
    }
    return contentKoujyoLabel;

  }

  /**
   * 医療費控除対象額を取得します。
   * @return 医療費控除対象額
   */
  public ACTextField getContentKoujyoText(){
    if(contentKoujyoText==null){

      contentKoujyoText = new ACTextField();

      contentKoujyoText.setBindPath("KOJO_TARGET");

      contentKoujyoText.setColumns(10);

      contentKoujyoText.setCharType(VRCharType.ONLY_DIGIT);

      contentKoujyoText.setHorizontalAlignment(SwingConstants.RIGHT);

      contentKoujyoText.setIMEMode(InputSubset.LATIN);

      contentKoujyoText.setMaxLength(8);

      addContentKoujyoText();
    }
    return contentKoujyoText;

  }

  /**
   * コンストラクタです。
   */
  public QP003Design() {

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

    this.add(getContents(), VRLayout.CLIENT);

  }

  /**
   * ボタンバーに内部項目を追加します。
   */
  protected void addButtons(){

    buttons.add(getUpdate(), VRLayout.EAST);
    buttons.add(getInsert(), VRLayout.EAST);
    buttons.add(getOpen(), VRLayout.EAST);
  }

  /**
   * 前回読込み(O)に内部項目を追加します。
   */
  protected void addOpen(){

  }

  /**
   * 登録ボタン(S)に内部項目を追加します。
   */
  protected void addInsert(){

  }

  /**
   * 更新ボタン(S)に内部項目を追加します。
   */
  protected void addUpdate(){

  }

  /**
   * クライアント領域に内部項目を追加します。
   */
  protected void addContents(){

    contents.add(getContentPatients(), VRLayout.FLOW_RETURN);

    contents.add(getContentProviders(), VRLayout.FLOW_RETURN);

    contents.add(getContentSpace1(), VRLayout.FLOW_RETURN);

    contents.add(getContentJikohutanArea(), VRLayout.FLOW_RETURN);

    contents.add(getContentSpace2(), VRLayout.FLOW_RETURN);

    contents.add(getContentEtcs(), VRLayout.FLOW_RETURN);

    contents.add(getContentSpace3(), VRLayout.FLOW_RETURN);

    contents.add(getContentBottoms(), VRLayout.FLOW_RETURN);

  }

  /**
   * 利用者情報領域に内部項目を追加します。
   */
  protected void addContentPatients(){

    contentPatients.add(getContentPatientText(), VRLayout.FLOW_INSETLINE);

    contentPatients.add(getContentPatientID(), VRLayout.FLOW_INSETLINE);

    contentPatients.add(getContentPatientName(), VRLayout.FLOW_INSETLINE);

  }

  /**
   * 利用者に内部項目を追加します。
   */
  protected void addContentPatientText(){

  }

  /**
   * 利用者IDに内部項目を追加します。
   */
  protected void addContentPatientID(){

  }

  /**
   * 利用者名に内部項目を追加します。
   */
  protected void addContentPatientName(){

  }

  /**
   * 事業所情報領域に内部項目を追加します。
   */
  protected void addContentProviders(){

    contentProviders.add(getContentProviderText(), VRLayout.FLOW_INSETLINE);

    contentProviders.add(getContentProviderId(), VRLayout.FLOW_INSETLINE);

    contentProviders.add(getContentProviderName(), VRLayout.FLOW_INSETLINE);

  }

  /**
   * 事業所に内部項目を追加します。
   */
  protected void addContentProviderText(){

  }

  /**
   * 事業所IDに内部項目を追加します。
   */
  protected void addContentProviderId(){

  }

  /**
   * 事業所名称に内部項目を追加します。
   */
  protected void addContentProviderName(){

  }

  /**
   * スペーサーに内部項目を追加します。
   */
  protected void addContentSpace1(){

  }

  /**
   * 自己負担分領域に内部項目を追加します。
   */
  protected void addContentJikohutanArea(){

    contentJikohutanArea.add(getContentBillTitle(), VRLayout.FLOW_RETURN);

    contentJikohutanArea.add(getContentJikohutanTitle(), VRLayout.FLOW_RETURN);

    contentJikohutanArea.add(getContentJikohutan1(), VRLayout.FLOW_RETURN);

    contentJikohutanArea.add(getContentJikohutan2(), VRLayout.FLOW_RETURN);

    contentJikohutanArea.add(getContentJikohutan3(), VRLayout.FLOW_RETURN);

    contentJikohutanArea.add(getContentJikohutanTitleArea(), VRLayout.FLOW_RETURN);

  }

  /**
   * 項目タイトルに内部項目を追加します。
   */
  protected void addContentBillTitle(){

    contentBillTitle.add(getContentBill(), VRLayout.WEST);

  }

  /**
   * 請求対象年月に内部項目を追加します。
   */
  protected void addContentBill(){

  }

  /**
   * 全額自己負担分タイトルに内部項目を追加します。
   */
  protected void addContentJikohutanTitle(){

    contentJikohutanTitle.add(getContentJikohutanHimokuTitle(), VRLayout.CLIENT);

    contentJikohutanTitle.add(getContentJikohutanUseTitle(), VRLayout.EAST);
  }

  /**
   * 全額自己負担分費目タイトルに内部項目を追加します。
   */
  protected void addContentJikohutanHimokuTitle(){

  }

  /**
   * 全額自己負担分利用料タイトルに内部項目を追加します。
   */
  protected void addContentJikohutanUseTitle(){

  }

  /**
   * 全額自己負担分１に内部項目を追加します。
   */
  protected void addContentJikohutan1(){

    contentJikohutan1.add(getContentJikohutanHimoku1(), VRLayout.CLIENT);

    contentJikohutan1.add(getContentJikohutanUse1(), VRLayout.EAST);
  }

  /**
   * 全額自己負担分費目１に内部項目を追加します。
   */
  protected void addContentJikohutanHimoku1(){

  }

  /**
   * 全額自己負担分費目１モデルに内部項目を追加します。
   */
  protected void addContentJikohutanHimoku1Model(){

  }

  /**
   * 全額自己負担分利用料１に内部項目を追加します。
   */
  protected void addContentJikohutanUse1(){

  }

  /**
   * 全額自己負担分２に内部項目を追加します。
   */
  protected void addContentJikohutan2(){

    contentJikohutan2.add(getContentJikohutanHimoku2(), VRLayout.CLIENT);

    contentJikohutan2.add(getContentJikohutanUse2(), VRLayout.EAST);
  }

  /**
   * 全額自己負担分費目２に内部項目を追加します。
   */
  protected void addContentJikohutanHimoku2(){

  }

  /**
   * 全額自己負担分費目２モデルに内部項目を追加します。
   */
  protected void addContentJikohutanHimoku2Model(){

  }

  /**
   * 全額自己負担分利用料２に内部項目を追加します。
   */
  protected void addContentJikohutanUse2(){

  }

  /**
   * 全額自己負担分３に内部項目を追加します。
   */
  protected void addContentJikohutan3(){

    contentJikohutan3.add(getContentJikohutanHimoku3(), VRLayout.CLIENT);

    contentJikohutan3.add(getContentJikohutanUse3(), VRLayout.EAST);
  }

  /**
   * 全額自己負担分費目３に内部項目を追加します。
   */
  protected void addContentJikohutanHimoku3(){

  }

  /**
   * 全額自己負担分費目３モデルに内部項目を追加します。
   */
  protected void addContentJikohutanHimoku3Model(){

  }

  /**
   * 全額自己負担分利用料３に内部項目を追加します。
   */
  protected void addContentJikohutanUse3(){

  }

  /**
   * 全額自己負担分小計に内部項目を追加します。
   */
  protected void addContentJikohutanTitleArea(){

    contentJikohutanTitleArea.add(getContentJikohutanSubtotalTitle(), VRLayout.CLIENT);

    contentJikohutanTitleArea.add(getContentJikohutanSubtotal(), VRLayout.EAST);
  }

  /**
   * 全額自己負担小計タイトルに内部項目を追加します。
   */
  protected void addContentJikohutanSubtotalTitle(){

  }

  /**
   * 全額自己負担小計に内部項目を追加します。
   */
  protected void addContentJikohutanSubtotal(){

  }

  /**
   * スペーサーに内部項目を追加します。
   */
  protected void addContentSpace2(){

  }

  /**
   * その他パネルに内部項目を追加します。
   */
  protected void addContentEtcs(){

    contentEtcs.add(getContentEtcTitle(), VRLayout.FLOW_RETURN);

    contentEtcs.add(getContentEtc1(), VRLayout.FLOW_RETURN);

    contentEtcs.add(getContentEtc2(), VRLayout.FLOW_RETURN);

    contentEtcs.add(getContentEtc3(), VRLayout.FLOW_RETURN);

    contentEtcs.add(getContentEtc4(), VRLayout.FLOW_RETURN);

    contentEtcs.add(getContentEtc5(), VRLayout.FLOW_RETURN);

    contentEtcs.add(getContentEtcTitleArea(), VRLayout.FLOW_RETURN);

  }

  /**
   * その他タイトルに内部項目を追加します。
   */
  protected void addContentEtcTitle(){

    contentEtcTitle.add(getContentEtcHimokuTitle(), VRLayout.CLIENT);

    contentEtcTitle.add(getContentEtcUseTitle(), VRLayout.EAST);
  }

  /**
   * その他費目タイトルに内部項目を追加します。
   */
  protected void addContentEtcHimokuTitle(){

  }

  /**
   * その他利用料タイトルに内部項目を追加します。
   */
  protected void addContentEtcUseTitle(){

  }

  /**
   * その他１に内部項目を追加します。
   */
  protected void addContentEtc1(){

    contentEtc1.add(getContentEtcHimoku1(), VRLayout.CLIENT);

    contentEtc1.add(getContentEtcUse1(), VRLayout.EAST);
  }

  /**
   * その他費目１に内部項目を追加します。
   */
  protected void addContentEtcHimoku1(){

  }

  /**
   * その他費目１モデルに内部項目を追加します。
   */
  protected void addContentEtcHimoku1Model(){

  }

  /**
   * その他利用料１に内部項目を追加します。
   */
  protected void addContentEtcUse1(){

  }

  /**
   * その他２に内部項目を追加します。
   */
  protected void addContentEtc2(){

    contentEtc2.add(getContentEtcHimoku2(), VRLayout.CLIENT);

    contentEtc2.add(getContentEtcUse2(), VRLayout.EAST);
  }

  /**
   * その他費目２に内部項目を追加します。
   */
  protected void addContentEtcHimoku2(){

  }

  /**
   * その他費目２モデルに内部項目を追加します。
   */
  protected void addContentEtcHimoku2Model(){

  }

  /**
   * その他利用料２に内部項目を追加します。
   */
  protected void addContentEtcUse2(){

  }

  /**
   * その他３に内部項目を追加します。
   */
  protected void addContentEtc3(){

    contentEtc3.add(getContentEtcHimoku3(), VRLayout.CLIENT);

    contentEtc3.add(getContentEtcUse3(), VRLayout.EAST);
  }

  /**
   * その他費目３に内部項目を追加します。
   */
  protected void addContentEtcHimoku3(){

  }

  /**
   * その他費目３モデルに内部項目を追加します。
   */
  protected void addContentEtcHimoku3Model(){

  }

  /**
   * その他利用料３に内部項目を追加します。
   */
  protected void addContentEtcUse3(){

  }

  /**
   * その他４に内部項目を追加します。
   */
  protected void addContentEtc4(){

    contentEtc4.add(getContentEtcHimoku4(), VRLayout.CLIENT);

    contentEtc4.add(getContentEtcUse4(), VRLayout.EAST);
  }

  /**
   * その他費目４に内部項目を追加します。
   */
  protected void addContentEtcHimoku4(){

  }

  /**
   * その他費目４モデルに内部項目を追加します。
   */
  protected void addContentEtcHimoku4Model(){

  }

  /**
   * その他利用料４に内部項目を追加します。
   */
  protected void addContentEtcUse4(){

  }

  /**
   * その他５に内部項目を追加します。
   */
  protected void addContentEtc5(){

    contentEtc5.add(getContentEtcHimoku5(), VRLayout.CLIENT);

    contentEtc5.add(getContentEtcUse5(), VRLayout.EAST);
  }

  /**
   * その他費目５に内部項目を追加します。
   */
  protected void addContentEtcHimoku5(){

  }

  /**
   * その他費目５モデルに内部項目を追加します。
   */
  protected void addContentEtcHimoku5Model(){

  }

  /**
   * その他利用料５に内部項目を追加します。
   */
  protected void addContentEtcUse5(){

  }

  /**
   * その他小計に内部項目を追加します。
   */
  protected void addContentEtcTitleArea(){

    contentEtcTitleArea.add(getContentEtcSubtotalTitle(), VRLayout.CLIENT);

    contentEtcTitleArea.add(getContentEtcSubtotal(), VRLayout.EAST);
  }

  /**
   * その他費用小計タイトルに内部項目を追加します。
   */
  protected void addContentEtcSubtotalTitle(){

  }

  /**
   * その他費用小計に内部項目を追加します。
   */
  protected void addContentEtcSubtotal(){

  }

  /**
   * スペーサーに内部項目を追加します。
   */
  protected void addContentSpace3(){

  }

  /**
   * 画面下部パネルに内部項目を追加します。
   */
  protected void addContentBottoms(){

    contentBottoms.add(getContentTotals(), VRLayout.WEST);

  }

  /**
   * 金額パネルに内部項目を追加します。
   */
  protected void addContentTotals(){

    contentTotals.add(getContentTotalLabel(), VRLayout.FLOW_RETURN);

    contentTotals.add(getContentTotalText(), VRLayout.FLOW_RETURN);

    contentTotals.add(getContentKoujyoLabel(), VRLayout.FLOW_RETURN);

    contentTotals.add(getContentKoujyoText(), VRLayout.FLOW);

  }

  /**
   * 合計額ラベルに内部項目を追加します。
   */
  protected void addContentTotalLabel(){

  }

  /**
   * 合計額に内部項目を追加します。
   */
  protected void addContentTotalText(){

  }

  /**
   * 医療費控除対象額ラベルに内部項目を追加します。
   */
  protected void addContentKoujyoLabel(){

  }

  /**
   * 医療費控除対象額に内部項目を追加します。
   */
  protected void addContentKoujyoText(){

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
      ACFrame.debugStart(new ACAffairInfo(QP003Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QP003Design getThis() {
    return this;
  }
}
