
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
 * 作成日: 2009/07/29  日本コンピューター株式会社 藤原　伸 新規作成
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

  private ACPanel contentsCommon;

  private ACPanel contentPatients;

  private ACTextField contentPatientText;

  private ACLabel contentPatientID;

  private ACLabel contentPatientName;

  private ACPanel contentProviders;

  private ACTextField contentProviderText;

  private ACLabel contentProviderId;

  private ACLabel contentProviderName;

  private ACPanel contentBillTitle;

  private ACTextField contentBill;

  private JTabbedPane tabs;

  private ACPanel contentMoney;

  private ACPanel contentJikohutanArea;

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

  private ACTextField contentEtcUnit;

  private ACTextField contentEtcCount;

  private ACTextField contentEtcUseTitle;

  private ACPanel contentEtc1;

  private ACComboBox contentEtcHimoku1;

  private ACComboBoxModelAdapter contentEtcHimoku1Model;

  private ACTextField contentEtcUnit1;

  private ACTextField contentEtcCount1;

  private ACTextField contentEtcUse1;

  private ACPanel contentEtc2;

  private ACComboBox contentEtcHimoku2;

  private ACComboBoxModelAdapter contentEtcHimoku2Model;

  private ACTextField contentEtcUnit2;

  private ACTextField contentEtcCount2;

  private ACTextField contentEtcUse2;

  private ACPanel contentEtc3;

  private ACComboBox contentEtcHimoku3;

  private ACComboBoxModelAdapter contentEtcHimoku3Model;

  private ACTextField contentEtcUnit3;

  private ACTextField contentEtcCount3;

  private ACTextField contentEtcUse3;

  private ACPanel contentEtc4;

  private ACComboBox contentEtcHimoku4;

  private ACComboBoxModelAdapter contentEtcHimoku4Model;

  private ACTextField contentEtcUnit4;

  private ACTextField contentEtcCount4;

  private ACTextField contentEtcUse4;

  private ACPanel contentEtc5;

  private ACComboBox contentEtcHimoku5;

  private ACComboBoxModelAdapter contentEtcHimoku5Model;

  private ACTextField contentEtcUnit5;

  private ACTextField contentEtcCount5;

  private ACTextField contentEtcUse5;

  private ACPanel contentEtc6;

  private ACComboBox contentEtcHimoku6;

  private ACComboBoxModelAdapter contentEtcHimoku6Model;

  private ACTextField contentEtcUnit6;

  private ACTextField contentEtcCount6;

  private ACTextField contentEtcUse6;

  private ACPanel contentEtcTitleArea;

  private ACTextField contentEtcSubtotalTitle;

  private ACTextField contentEtcSubtotal;

  private ACLabel contentSpace3;

  private ACPanel contentBottoms;

  private ACPanel contentTotals;

  private ACLabel contentTotalLabel;

  private ACTextField contentTotalText;

  private ACLabel contentInnerTaxLabel;

  private ACTextField contentInnerTaxText;

  private ACLabel contentKoujyoLabel;

  private ACTextField contentKoujyoText;

  private ACPanel contentDay;

  private ACPanel contentCalendarUp;

  private ACGroupBox contentCalendar;

  private QP003ResultCalendar calendar01;

  private QP003ResultCalendar calendar02;

  private QP003ResultCalendar calendar03;

  private QP003ResultCalendar calendar04;

  private QP003ResultCalendar calendar05;

  private QP003ResultCalendar calendar06;

  private QP003ResultCalendar calendar07;

  private QP003ResultCalendar calendar08;

  private QP003ResultCalendar calendar09;

  private QP003ResultCalendar calendar10;

  private QP003ResultCalendar calendar11;

  private QP003ResultCalendar calendar12;

  private QP003ResultCalendar calendar13;

  private QP003ResultCalendar calendar14;

  private QP003ResultCalendar calendar15;

  private QP003ResultCalendar calendar16;

  private QP003ResultCalendar calendar17;

  private QP003ResultCalendar calendar18;

  private QP003ResultCalendar calendar19;

  private QP003ResultCalendar calendar20;

  private QP003ResultCalendar calendar21;

  private QP003ResultCalendar calendar22;

  private QP003ResultCalendar calendar23;

  private QP003ResultCalendar calendar24;

  private QP003ResultCalendar calendar25;

  private QP003ResultCalendar calendar26;

  private QP003ResultCalendar calendar27;

  private QP003ResultCalendar calendar28;

  private QP003ResultCalendar calendar29;

  private QP003ResultCalendar calendar30;

  private QP003ResultCalendar calendar31;

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
   * 共通領域を取得します。
   * @return 共通領域
   */
  public ACPanel getContentsCommon(){
    if(contentsCommon==null){

      contentsCommon = new ACPanel();

      contentsCommon.setHgap(3);

      addContentsCommon();
    }
    return contentsCommon;

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
   * タブを取得します。
   * @return タブ
   */
  public JTabbedPane getTabs(){
    if(tabs==null){

      tabs = new JTabbedPane();

      addTabs();
    }
    return tabs;

  }

  /**
   * 金額領域を取得します。
   * @return 金額領域
   */
  public ACPanel getContentMoney(){
    if(contentMoney==null){

      contentMoney = new ACPanel();

      addContentMoney();
    }
    return contentMoney;

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
   * その他単位数タイトルを取得します。
   * @return その他単位数タイトル
   */
  public ACTextField getContentEtcUnit(){
    if(contentEtcUnit==null){

      contentEtcUnit = new ACTextField();

      contentEtcUnit.setText("単価");

      contentEtcUnit.setEditable(false);

      contentEtcUnit.setColumns(4);

      contentEtcUnit.setHorizontalAlignment(SwingConstants.CENTER);

      addContentEtcUnit();
    }
    return contentEtcUnit;

  }

  /**
   * その他回数タイトルを取得します。
   * @return その他回数タイトル
   */
  public ACTextField getContentEtcCount(){
    if(contentEtcCount==null){

      contentEtcCount = new ACTextField();

      contentEtcCount.setText("数量");

      contentEtcCount.setEditable(false);

      contentEtcCount.setColumns(3);

      contentEtcCount.setHorizontalAlignment(SwingConstants.CENTER);

      addContentEtcCount();
    }
    return contentEtcCount;

  }

  /**
   * その他利用料タイトルを取得します。
   * @return その他利用料タイトル
   */
  public ACTextField getContentEtcUseTitle(){
    if(contentEtcUseTitle==null){

      contentEtcUseTitle = new ACTextField();

      contentEtcUseTitle.setText("利用料(税込)");

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
   * その他単位数１を取得します。
   * @return その他単位数１
   */
  public ACTextField getContentEtcUnit1(){
    if(contentEtcUnit1==null){

      contentEtcUnit1 = new ACTextField();

      contentEtcUnit1.setBindPath("OTHER_UNIT_NO1");

      contentEtcUnit1.setEditable(true);

      contentEtcUnit1.setColumns(4);

      contentEtcUnit1.setCharType(VRCharType.ONLY_NUMBER);

      contentEtcUnit1.setHorizontalAlignment(SwingConstants.RIGHT);

      contentEtcUnit1.setIMEMode(InputSubset.LATIN);

      contentEtcUnit1.setMaxLength(6);

      addContentEtcUnit1();
    }
    return contentEtcUnit1;

  }

  /**
   * その他回数１を取得します。
   * @return その他回数１
   */
  public ACTextField getContentEtcCount1(){
    if(contentEtcCount1==null){

      contentEtcCount1 = new ACTextField();

      contentEtcCount1.setBindPath("OTHER_COUNT_NO1");

      contentEtcCount1.setEditable(true);

      contentEtcCount1.setColumns(3);

      contentEtcCount1.setCharType(VRCharType.ONLY_NUMBER);

      contentEtcCount1.setHorizontalAlignment(SwingConstants.RIGHT);

      contentEtcCount1.setIMEMode(InputSubset.LATIN);

      contentEtcCount1.setMaxLength(2);

      addContentEtcCount1();
    }
    return contentEtcCount1;

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
   * その他単位数２を取得します。
   * @return その他単位数２
   */
  public ACTextField getContentEtcUnit2(){
    if(contentEtcUnit2==null){

      contentEtcUnit2 = new ACTextField();

      contentEtcUnit2.setBindPath("OTHER_UNIT_NO2");

      contentEtcUnit2.setEditable(true);

      contentEtcUnit2.setColumns(4);

      contentEtcUnit2.setCharType(VRCharType.ONLY_NUMBER);

      contentEtcUnit2.setHorizontalAlignment(SwingConstants.RIGHT);

      contentEtcUnit2.setIMEMode(InputSubset.LATIN);

      contentEtcUnit2.setMaxLength(6);

      addContentEtcUnit2();
    }
    return contentEtcUnit2;

  }

  /**
   * その他回数２を取得します。
   * @return その他回数２
   */
  public ACTextField getContentEtcCount2(){
    if(contentEtcCount2==null){

      contentEtcCount2 = new ACTextField();

      contentEtcCount2.setBindPath("OTHER_COUNT_NO2");

      contentEtcCount2.setEditable(true);

      contentEtcCount2.setColumns(3);

      contentEtcCount2.setCharType(VRCharType.ONLY_NUMBER);

      contentEtcCount2.setHorizontalAlignment(SwingConstants.RIGHT);

      contentEtcCount2.setIMEMode(InputSubset.LATIN);

      contentEtcCount2.setMaxLength(2);

      addContentEtcCount2();
    }
    return contentEtcCount2;

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
   * その他単位数３を取得します。
   * @return その他単位数３
   */
  public ACTextField getContentEtcUnit3(){
    if(contentEtcUnit3==null){

      contentEtcUnit3 = new ACTextField();

      contentEtcUnit3.setBindPath("OTHER_UNIT_NO3");

      contentEtcUnit3.setEditable(true);

      contentEtcUnit3.setColumns(4);

      contentEtcUnit3.setCharType(VRCharType.ONLY_NUMBER);

      contentEtcUnit3.setHorizontalAlignment(SwingConstants.RIGHT);

      contentEtcUnit3.setIMEMode(InputSubset.LATIN);

      contentEtcUnit3.setMaxLength(6);

      addContentEtcUnit3();
    }
    return contentEtcUnit3;

  }

  /**
   * その他回数３を取得します。
   * @return その他回数３
   */
  public ACTextField getContentEtcCount3(){
    if(contentEtcCount3==null){

      contentEtcCount3 = new ACTextField();

      contentEtcCount3.setBindPath("OTHER_COUNT_NO3");

      contentEtcCount3.setEditable(true);

      contentEtcCount3.setColumns(3);

      contentEtcCount3.setCharType(VRCharType.ONLY_NUMBER);

      contentEtcCount3.setHorizontalAlignment(SwingConstants.RIGHT);

      contentEtcCount3.setIMEMode(InputSubset.LATIN);

      contentEtcCount3.setMaxLength(2);

      addContentEtcCount3();
    }
    return contentEtcCount3;

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
   * その他単位数４を取得します。
   * @return その他単位数４
   */
  public ACTextField getContentEtcUnit4(){
    if(contentEtcUnit4==null){

      contentEtcUnit4 = new ACTextField();

      contentEtcUnit4.setBindPath("OTHER_UNIT_NO4");

      contentEtcUnit4.setEditable(true);

      contentEtcUnit4.setColumns(4);

      contentEtcUnit4.setCharType(VRCharType.ONLY_NUMBER);

      contentEtcUnit4.setHorizontalAlignment(SwingConstants.RIGHT);

      contentEtcUnit4.setIMEMode(InputSubset.LATIN);

      contentEtcUnit4.setMaxLength(6);

      addContentEtcUnit4();
    }
    return contentEtcUnit4;

  }

  /**
   * その他回数４を取得します。
   * @return その他回数４
   */
  public ACTextField getContentEtcCount4(){
    if(contentEtcCount4==null){

      contentEtcCount4 = new ACTextField();

      contentEtcCount4.setBindPath("OTHER_COUNT_NO4");

      contentEtcCount4.setEditable(true);

      contentEtcCount4.setColumns(3);

      contentEtcCount4.setCharType(VRCharType.ONLY_NUMBER);

      contentEtcCount4.setHorizontalAlignment(SwingConstants.RIGHT);

      contentEtcCount4.setIMEMode(InputSubset.LATIN);

      contentEtcCount4.setMaxLength(2);

      addContentEtcCount4();
    }
    return contentEtcCount4;

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
   * その他単位数５を取得します。
   * @return その他単位数５
   */
  public ACTextField getContentEtcUnit5(){
    if(contentEtcUnit5==null){

      contentEtcUnit5 = new ACTextField();

      contentEtcUnit5.setBindPath("OTHER_UNIT_NO5");

      contentEtcUnit5.setEditable(true);

      contentEtcUnit5.setColumns(4);

      contentEtcUnit5.setCharType(VRCharType.ONLY_NUMBER);

      contentEtcUnit5.setHorizontalAlignment(SwingConstants.RIGHT);

      contentEtcUnit5.setIMEMode(InputSubset.LATIN);

      contentEtcUnit5.setMaxLength(6);

      addContentEtcUnit5();
    }
    return contentEtcUnit5;

  }

  /**
   * その他回数５を取得します。
   * @return その他回数５
   */
  public ACTextField getContentEtcCount5(){
    if(contentEtcCount5==null){

      contentEtcCount5 = new ACTextField();

      contentEtcCount5.setBindPath("OTHER_COUNT_NO5");

      contentEtcCount5.setEditable(true);

      contentEtcCount5.setColumns(3);

      contentEtcCount5.setCharType(VRCharType.ONLY_NUMBER);

      contentEtcCount5.setHorizontalAlignment(SwingConstants.RIGHT);

      contentEtcCount5.setIMEMode(InputSubset.LATIN);

      contentEtcCount5.setMaxLength(2);

      addContentEtcCount5();
    }
    return contentEtcCount5;

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
   * その他６を取得します。
   * @return その他６
   */
  public ACPanel getContentEtc6(){
    if(contentEtc6==null){

      contentEtc6 = new ACPanel();

      contentEtc6.setAutoWrap(false);

      addContentEtc6();
    }
    return contentEtc6;

  }

  /**
   * その他費目６を取得します。
   * @return その他費目６
   */
  public ACComboBox getContentEtcHimoku6(){
    if(contentEtcHimoku6==null){

      contentEtcHimoku6 = new ACComboBox();

      contentEtcHimoku6.setBindPath("OTHER_HIMOKU_NO6");

      contentEtcHimoku6.setEditable(true);

      contentEtcHimoku6.setColumns(25);

      contentEtcHimoku6.setModelBindPath("OTHER");

      contentEtcHimoku6.setBlankable(false);

      contentEtcHimoku6.setIMEMode(InputSubset.KANJI);

      contentEtcHimoku6.setMaxLength(75);

      contentEtcHimoku6.setMaxColumns(25);

      contentEtcHimoku6.setModel(getContentEtcHimoku6Model());

      addContentEtcHimoku6();
    }
    return contentEtcHimoku6;

  }

  /**
   * その他費目６モデルを取得します。
   * @return その他費目６モデル
   */
  protected ACComboBoxModelAdapter getContentEtcHimoku6Model(){
    if(contentEtcHimoku6Model==null){
      contentEtcHimoku6Model = new ACComboBoxModelAdapter();
      addContentEtcHimoku6Model();
    }
    return contentEtcHimoku6Model;
  }

  /**
   * その他単位数６を取得します。
   * @return その他単位数６
   */
  public ACTextField getContentEtcUnit6(){
    if(contentEtcUnit6==null){

      contentEtcUnit6 = new ACTextField();

      contentEtcUnit6.setBindPath("OTHER_UNIT_NO6");

      contentEtcUnit6.setEditable(true);

      contentEtcUnit6.setColumns(4);

      contentEtcUnit6.setCharType(VRCharType.ONLY_NUMBER);

      contentEtcUnit6.setHorizontalAlignment(SwingConstants.RIGHT);

      contentEtcUnit6.setIMEMode(InputSubset.LATIN);

      contentEtcUnit6.setMaxLength(6);

      addContentEtcUnit6();
    }
    return contentEtcUnit6;

  }

  /**
   * その他回数６を取得します。
   * @return その他回数６
   */
  public ACTextField getContentEtcCount6(){
    if(contentEtcCount6==null){

      contentEtcCount6 = new ACTextField();

      contentEtcCount6.setBindPath("OTHER_COUNT_NO6");

      contentEtcCount6.setEditable(true);

      contentEtcCount6.setColumns(3);

      contentEtcCount6.setCharType(VRCharType.ONLY_NUMBER);

      contentEtcCount6.setHorizontalAlignment(SwingConstants.RIGHT);

      contentEtcCount6.setIMEMode(InputSubset.LATIN);

      contentEtcCount6.setMaxLength(2);

      addContentEtcCount6();
    }
    return contentEtcCount6;

  }

  /**
   * その他利用料６を取得します。
   * @return その他利用料６
   */
  public ACTextField getContentEtcUse6(){
    if(contentEtcUse6==null){

      contentEtcUse6 = new ACTextField();

      contentEtcUse6.setBindPath("OTHER_PAY_NO6");

      contentEtcUse6.setColumns(9);

      contentEtcUse6.setCharType(VRCharType.ONLY_NUMBER);

      contentEtcUse6.setHorizontalAlignment(SwingConstants.RIGHT);

      contentEtcUse6.setIMEMode(InputSubset.LATIN);

      contentEtcUse6.setMaxLength(8);

      addContentEtcUse6();
    }
    return contentEtcUse6;

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

      contentEtcSubtotalTitle.setColumns(34);

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

      contentTotalText.setEditable(false);

      contentTotalText.setColumns(10);

      contentTotalText.setHorizontalAlignment(SwingConstants.RIGHT);

      addContentTotalText();
    }
    return contentTotalText;

  }

  /**
   * うち消費税ラベルを取得します。
   * @return うち消費税ラベル
   */
  public ACLabel getContentInnerTaxLabel(){
    if(contentInnerTaxLabel==null){

      contentInnerTaxLabel = new ACLabel();

      contentInnerTaxLabel.setText("うち消費税");

      addContentInnerTaxLabel();
    }
    return contentInnerTaxLabel;

  }

  /**
   * うち消費税を取得します。
   * @return うち消費税
   */
  public ACTextField getContentInnerTaxText(){
    if(contentInnerTaxText==null){

      contentInnerTaxText = new ACTextField();

      contentInnerTaxText.setBindPath("INNER_TAX");

      contentInnerTaxText.setColumns(10);

      contentInnerTaxText.setCharType(VRCharType.ONLY_DIGIT);

      contentInnerTaxText.setHorizontalAlignment(SwingConstants.RIGHT);

      contentInnerTaxText.setIMEMode(InputSubset.LATIN);

      contentInnerTaxText.setMaxLength(8);

      addContentInnerTaxText();
    }
    return contentInnerTaxText;

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
   * 日付領域を取得します。
   * @return 日付領域
   */
  public ACPanel getContentDay(){
    if(contentDay==null){

      contentDay = new ACPanel();

      contentDay.setHgap(0);

      contentDay.setLabelMargin(0);

      contentDay.setVgap(0);

      addContentDay();
    }
    return contentDay;

  }

  /**
   * 上部領域を取得します。
   * @return 上部領域
   */
  public ACPanel getContentCalendarUp(){
    if(contentCalendarUp==null){

      contentCalendarUp = new ACPanel();

      addContentCalendarUp();
    }
    return contentCalendarUp;

  }

  /**
   * カレンダー領域を取得します。
   * @return カレンダー領域
   */
  public ACGroupBox getContentCalendar(){
    if(contentCalendar==null){

      contentCalendar = new ACGroupBox();

      contentCalendar.setText("提供日");

      contentCalendar.setFollowChildEnabled(false);

      contentCalendar.setHgap(0);

      contentCalendar.setVgap(0);

      addContentCalendar();
    }
    return contentCalendar;

  }

  /**
   * カレンダー1日を取得します。
   * @return カレンダー1日
   */
  public QP003ResultCalendar getCalendar01(){
    if(calendar01==null){

      calendar01 = new QP003ResultCalendar();

      addCalendar01();
    }
    return calendar01;

  }

  /**
   * カレンダー2日を取得します。
   * @return カレンダー2日
   */
  public QP003ResultCalendar getCalendar02(){
    if(calendar02==null){

      calendar02 = new QP003ResultCalendar();

      addCalendar02();
    }
    return calendar02;

  }

  /**
   * カレンダー3日を取得します。
   * @return カレンダー3日
   */
  public QP003ResultCalendar getCalendar03(){
    if(calendar03==null){

      calendar03 = new QP003ResultCalendar();

      addCalendar03();
    }
    return calendar03;

  }

  /**
   * カレンダー4日を取得します。
   * @return カレンダー4日
   */
  public QP003ResultCalendar getCalendar04(){
    if(calendar04==null){

      calendar04 = new QP003ResultCalendar();

      addCalendar04();
    }
    return calendar04;

  }

  /**
   * カレンダー5日を取得します。
   * @return カレンダー5日
   */
  public QP003ResultCalendar getCalendar05(){
    if(calendar05==null){

      calendar05 = new QP003ResultCalendar();

      addCalendar05();
    }
    return calendar05;

  }

  /**
   * カレンダー6日を取得します。
   * @return カレンダー6日
   */
  public QP003ResultCalendar getCalendar06(){
    if(calendar06==null){

      calendar06 = new QP003ResultCalendar();

      addCalendar06();
    }
    return calendar06;

  }

  /**
   * カレンダー7日を取得します。
   * @return カレンダー7日
   */
  public QP003ResultCalendar getCalendar07(){
    if(calendar07==null){

      calendar07 = new QP003ResultCalendar();

      addCalendar07();
    }
    return calendar07;

  }

  /**
   * カレンダー8日を取得します。
   * @return カレンダー8日
   */
  public QP003ResultCalendar getCalendar08(){
    if(calendar08==null){

      calendar08 = new QP003ResultCalendar();

      addCalendar08();
    }
    return calendar08;

  }

  /**
   * カレンダー9日を取得します。
   * @return カレンダー9日
   */
  public QP003ResultCalendar getCalendar09(){
    if(calendar09==null){

      calendar09 = new QP003ResultCalendar();

      addCalendar09();
    }
    return calendar09;

  }

  /**
   * カレンダー10日を取得します。
   * @return カレンダー10日
   */
  public QP003ResultCalendar getCalendar10(){
    if(calendar10==null){

      calendar10 = new QP003ResultCalendar();

      addCalendar10();
    }
    return calendar10;

  }

  /**
   * カレンダー11日を取得します。
   * @return カレンダー11日
   */
  public QP003ResultCalendar getCalendar11(){
    if(calendar11==null){

      calendar11 = new QP003ResultCalendar();

      addCalendar11();
    }
    return calendar11;

  }

  /**
   * カレンダー12日を取得します。
   * @return カレンダー12日
   */
  public QP003ResultCalendar getCalendar12(){
    if(calendar12==null){

      calendar12 = new QP003ResultCalendar();

      addCalendar12();
    }
    return calendar12;

  }

  /**
   * カレンダー13日を取得します。
   * @return カレンダー13日
   */
  public QP003ResultCalendar getCalendar13(){
    if(calendar13==null){

      calendar13 = new QP003ResultCalendar();

      addCalendar13();
    }
    return calendar13;

  }

  /**
   * カレンダー14日を取得します。
   * @return カレンダー14日
   */
  public QP003ResultCalendar getCalendar14(){
    if(calendar14==null){

      calendar14 = new QP003ResultCalendar();

      addCalendar14();
    }
    return calendar14;

  }

  /**
   * カレンダー15日を取得します。
   * @return カレンダー15日
   */
  public QP003ResultCalendar getCalendar15(){
    if(calendar15==null){

      calendar15 = new QP003ResultCalendar();

      addCalendar15();
    }
    return calendar15;

  }

  /**
   * カレンダー16日を取得します。
   * @return カレンダー16日
   */
  public QP003ResultCalendar getCalendar16(){
    if(calendar16==null){

      calendar16 = new QP003ResultCalendar();

      addCalendar16();
    }
    return calendar16;

  }

  /**
   * カレンダー17日を取得します。
   * @return カレンダー17日
   */
  public QP003ResultCalendar getCalendar17(){
    if(calendar17==null){

      calendar17 = new QP003ResultCalendar();

      addCalendar17();
    }
    return calendar17;

  }

  /**
   * カレンダー18日を取得します。
   * @return カレンダー18日
   */
  public QP003ResultCalendar getCalendar18(){
    if(calendar18==null){

      calendar18 = new QP003ResultCalendar();

      addCalendar18();
    }
    return calendar18;

  }

  /**
   * カレンダー19日を取得します。
   * @return カレンダー19日
   */
  public QP003ResultCalendar getCalendar19(){
    if(calendar19==null){

      calendar19 = new QP003ResultCalendar();

      addCalendar19();
    }
    return calendar19;

  }

  /**
   * カレンダー20日を取得します。
   * @return カレンダー20日
   */
  public QP003ResultCalendar getCalendar20(){
    if(calendar20==null){

      calendar20 = new QP003ResultCalendar();

      addCalendar20();
    }
    return calendar20;

  }

  /**
   * カレンダー21日を取得します。
   * @return カレンダー21日
   */
  public QP003ResultCalendar getCalendar21(){
    if(calendar21==null){

      calendar21 = new QP003ResultCalendar();

      addCalendar21();
    }
    return calendar21;

  }

  /**
   * カレンダー22日を取得します。
   * @return カレンダー22日
   */
  public QP003ResultCalendar getCalendar22(){
    if(calendar22==null){

      calendar22 = new QP003ResultCalendar();

      addCalendar22();
    }
    return calendar22;

  }

  /**
   * カレンダー23日を取得します。
   * @return カレンダー23日
   */
  public QP003ResultCalendar getCalendar23(){
    if(calendar23==null){

      calendar23 = new QP003ResultCalendar();

      addCalendar23();
    }
    return calendar23;

  }

  /**
   * カレンダー24日を取得します。
   * @return カレンダー24日
   */
  public QP003ResultCalendar getCalendar24(){
    if(calendar24==null){

      calendar24 = new QP003ResultCalendar();

      addCalendar24();
    }
    return calendar24;

  }

  /**
   * カレンダー25日を取得します。
   * @return カレンダー25日
   */
  public QP003ResultCalendar getCalendar25(){
    if(calendar25==null){

      calendar25 = new QP003ResultCalendar();

      addCalendar25();
    }
    return calendar25;

  }

  /**
   * カレンダー26日を取得します。
   * @return カレンダー26日
   */
  public QP003ResultCalendar getCalendar26(){
    if(calendar26==null){

      calendar26 = new QP003ResultCalendar();

      addCalendar26();
    }
    return calendar26;

  }

  /**
   * カレンダー27日を取得します。
   * @return カレンダー27日
   */
  public QP003ResultCalendar getCalendar27(){
    if(calendar27==null){

      calendar27 = new QP003ResultCalendar();

      addCalendar27();
    }
    return calendar27;

  }

  /**
   * カレンダー28日を取得します。
   * @return カレンダー28日
   */
  public QP003ResultCalendar getCalendar28(){
    if(calendar28==null){

      calendar28 = new QP003ResultCalendar();

      addCalendar28();
    }
    return calendar28;

  }

  /**
   * カレンダー29日を取得します。
   * @return カレンダー29日
   */
  public QP003ResultCalendar getCalendar29(){
    if(calendar29==null){

      calendar29 = new QP003ResultCalendar();

      addCalendar29();
    }
    return calendar29;

  }

  /**
   * カレンダー30日を取得します。
   * @return カレンダー30日
   */
  public QP003ResultCalendar getCalendar30(){
    if(calendar30==null){

      calendar30 = new QP003ResultCalendar();

      addCalendar30();
    }
    return calendar30;

  }

  /**
   * カレンダー31日を取得します。
   * @return カレンダー31日
   */
  public QP003ResultCalendar getCalendar31(){
    if(calendar31==null){

      calendar31 = new QP003ResultCalendar();

      addCalendar31();
    }
    return calendar31;

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

    contents.add(getContentsCommon(), VRLayout.NORTH);

    contents.add(getTabs(), VRLayout.CLIENT);

  }

  /**
   * 共通領域に内部項目を追加します。
   */
  protected void addContentsCommon(){

    contentsCommon.add(getContentPatients(), VRLayout.FLOW_RETURN);

    contentsCommon.add(getContentProviders(), VRLayout.FLOW_RETURN);

    contentsCommon.add(getContentBillTitle(), VRLayout.FLOW_RETURN);

  }

  /**
   * 利用者情報領域に内部項目を追加します。
   */
  protected void addContentPatients(){

    contentPatients.add(getContentPatientText(), VRLayout.FLOW);

    contentPatients.add(getContentPatientID(), VRLayout.FLOW);

    contentPatients.add(getContentPatientName(), VRLayout.FLOW);

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

    contentProviders.add(getContentProviderText(), VRLayout.FLOW);

    contentProviders.add(getContentProviderId(), VRLayout.FLOW);

    contentProviders.add(getContentProviderName(), VRLayout.FLOW);

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
   * 項目タイトルに内部項目を追加します。
   */
  protected void addContentBillTitle(){

    contentBillTitle.add(getContentBill(), VRLayout.FLOW);

  }

  /**
   * 請求対象年月に内部項目を追加します。
   */
  protected void addContentBill(){

  }

  /**
   * タブに内部項目を追加します。
   */
  protected void addTabs(){

    tabs.addTab("請求金額", getContentMoney());

    tabs.addTab("サービス提供日", getContentDay());

  }

  /**
   * 金額領域に内部項目を追加します。
   */
  protected void addContentMoney(){

    contentMoney.add(getContentJikohutanArea(), VRLayout.FLOW_RETURN);

    contentMoney.add(getContentSpace2(), VRLayout.FLOW_RETURN);

    contentMoney.add(getContentEtcs(), VRLayout.FLOW_RETURN);

    contentMoney.add(getContentSpace3(), VRLayout.FLOW_RETURN);

    contentMoney.add(getContentBottoms(), VRLayout.FLOW_RETURN);

  }

  /**
   * 自己負担分領域に内部項目を追加します。
   */
  protected void addContentJikohutanArea(){

    contentJikohutanArea.add(getContentJikohutanTitle(), VRLayout.FLOW_RETURN);

    contentJikohutanArea.add(getContentJikohutan1(), VRLayout.FLOW_RETURN);

    contentJikohutanArea.add(getContentJikohutan2(), VRLayout.FLOW_RETURN);

    contentJikohutanArea.add(getContentJikohutan3(), VRLayout.FLOW_RETURN);

    contentJikohutanArea.add(getContentJikohutanTitleArea(), VRLayout.FLOW_RETURN);

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

    contentEtcs.add(getContentEtc6(), VRLayout.FLOW_RETURN);

    contentEtcs.add(getContentEtcTitleArea(), VRLayout.FLOW_RETURN);

  }

  /**
   * その他タイトルに内部項目を追加します。
   */
  protected void addContentEtcTitle(){

    contentEtcTitle.add(getContentEtcHimokuTitle(), VRLayout.CLIENT);

    contentEtcTitle.add(getContentEtcUseTitle(), VRLayout.EAST);
    contentEtcTitle.add(getContentEtcCount(), VRLayout.EAST);
    contentEtcTitle.add(getContentEtcUnit(), VRLayout.EAST);
  }

  /**
   * その他費目タイトルに内部項目を追加します。
   */
  protected void addContentEtcHimokuTitle(){

  }

  /**
   * その他単位数タイトルに内部項目を追加します。
   */
  protected void addContentEtcUnit(){

  }

  /**
   * その他回数タイトルに内部項目を追加します。
   */
  protected void addContentEtcCount(){

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
    contentEtc1.add(getContentEtcCount1(), VRLayout.EAST);
    contentEtc1.add(getContentEtcUnit1(), VRLayout.EAST);
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
   * その他単位数１に内部項目を追加します。
   */
  protected void addContentEtcUnit1(){

  }

  /**
   * その他回数１に内部項目を追加します。
   */
  protected void addContentEtcCount1(){

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
    contentEtc2.add(getContentEtcCount2(), VRLayout.EAST);
    contentEtc2.add(getContentEtcUnit2(), VRLayout.EAST);
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
   * その他単位数２に内部項目を追加します。
   */
  protected void addContentEtcUnit2(){

  }

  /**
   * その他回数２に内部項目を追加します。
   */
  protected void addContentEtcCount2(){

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
    contentEtc3.add(getContentEtcCount3(), VRLayout.EAST);
    contentEtc3.add(getContentEtcUnit3(), VRLayout.EAST);
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
   * その他単位数３に内部項目を追加します。
   */
  protected void addContentEtcUnit3(){

  }

  /**
   * その他回数３に内部項目を追加します。
   */
  protected void addContentEtcCount3(){

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
    contentEtc4.add(getContentEtcCount4(), VRLayout.EAST);
    contentEtc4.add(getContentEtcUnit4(), VRLayout.EAST);
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
   * その他単位数４に内部項目を追加します。
   */
  protected void addContentEtcUnit4(){

  }

  /**
   * その他回数４に内部項目を追加します。
   */
  protected void addContentEtcCount4(){

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
    contentEtc5.add(getContentEtcCount5(), VRLayout.EAST);
    contentEtc5.add(getContentEtcUnit5(), VRLayout.EAST);
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
   * その他単位数５に内部項目を追加します。
   */
  protected void addContentEtcUnit5(){

  }

  /**
   * その他回数５に内部項目を追加します。
   */
  protected void addContentEtcCount5(){

  }

  /**
   * その他利用料５に内部項目を追加します。
   */
  protected void addContentEtcUse5(){

  }

  /**
   * その他６に内部項目を追加します。
   */
  protected void addContentEtc6(){

    contentEtc6.add(getContentEtcHimoku6(), VRLayout.CLIENT);

    contentEtc6.add(getContentEtcUse6(), VRLayout.EAST);
    contentEtc6.add(getContentEtcCount6(), VRLayout.EAST);
    contentEtc6.add(getContentEtcUnit6(), VRLayout.EAST);
  }

  /**
   * その他費目６に内部項目を追加します。
   */
  protected void addContentEtcHimoku6(){

  }

  /**
   * その他費目６モデルに内部項目を追加します。
   */
  protected void addContentEtcHimoku6Model(){

  }

  /**
   * その他単位数６に内部項目を追加します。
   */
  protected void addContentEtcUnit6(){

  }

  /**
   * その他回数６に内部項目を追加します。
   */
  protected void addContentEtcCount6(){

  }

  /**
   * その他利用料６に内部項目を追加します。
   */
  protected void addContentEtcUse6(){

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

    contentTotals.add(getContentInnerTaxLabel(), VRLayout.FLOW_RETURN);

    contentTotals.add(getContentInnerTaxText(), VRLayout.FLOW);

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
   * うち消費税ラベルに内部項目を追加します。
   */
  protected void addContentInnerTaxLabel(){

  }

  /**
   * うち消費税に内部項目を追加します。
   */
  protected void addContentInnerTaxText(){

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
   * 日付領域に内部項目を追加します。
   */
  protected void addContentDay(){

    contentDay.add(getContentCalendarUp(), VRLayout.NORTH);

    contentDay.add(getContentCalendar(), VRLayout.CLIENT);

  }

  /**
   * 上部領域に内部項目を追加します。
   */
  protected void addContentCalendarUp(){

  }

  /**
   * カレンダー領域に内部項目を追加します。
   */
  protected void addContentCalendar(){

    contentCalendar.add(getCalendar01(), VRLayout.FLOW);

    contentCalendar.add(getCalendar02(), VRLayout.FLOW);

    contentCalendar.add(getCalendar03(), VRLayout.FLOW);

    contentCalendar.add(getCalendar04(), VRLayout.FLOW);

    contentCalendar.add(getCalendar05(), VRLayout.FLOW);

    contentCalendar.add(getCalendar06(), VRLayout.FLOW);

    contentCalendar.add(getCalendar07(), VRLayout.FLOW_RETURN);

    contentCalendar.add(getCalendar08(), VRLayout.FLOW);

    contentCalendar.add(getCalendar09(), VRLayout.FLOW);

    contentCalendar.add(getCalendar10(), VRLayout.FLOW);

    contentCalendar.add(getCalendar11(), VRLayout.FLOW);

    contentCalendar.add(getCalendar12(), VRLayout.FLOW);

    contentCalendar.add(getCalendar13(), VRLayout.FLOW);

    contentCalendar.add(getCalendar14(), VRLayout.FLOW_RETURN);

    contentCalendar.add(getCalendar15(), VRLayout.FLOW);

    contentCalendar.add(getCalendar16(), VRLayout.FLOW);

    contentCalendar.add(getCalendar17(), VRLayout.FLOW);

    contentCalendar.add(getCalendar18(), VRLayout.FLOW);

    contentCalendar.add(getCalendar19(), VRLayout.FLOW);

    contentCalendar.add(getCalendar20(), VRLayout.FLOW);

    contentCalendar.add(getCalendar21(), VRLayout.FLOW_RETURN);

    contentCalendar.add(getCalendar22(), VRLayout.FLOW);

    contentCalendar.add(getCalendar23(), VRLayout.FLOW);

    contentCalendar.add(getCalendar24(), VRLayout.FLOW);

    contentCalendar.add(getCalendar25(), VRLayout.FLOW);

    contentCalendar.add(getCalendar26(), VRLayout.FLOW);

    contentCalendar.add(getCalendar27(), VRLayout.FLOW);

    contentCalendar.add(getCalendar28(), VRLayout.FLOW_RETURN);

    contentCalendar.add(getCalendar29(), VRLayout.FLOW);

    contentCalendar.add(getCalendar30(), VRLayout.FLOW);

    contentCalendar.add(getCalendar31(), VRLayout.FLOW);

  }

  /**
   * カレンダー1日に内部項目を追加します。
   */
  protected void addCalendar01(){

  }

  /**
   * カレンダー2日に内部項目を追加します。
   */
  protected void addCalendar02(){

  }

  /**
   * カレンダー3日に内部項目を追加します。
   */
  protected void addCalendar03(){

  }

  /**
   * カレンダー4日に内部項目を追加します。
   */
  protected void addCalendar04(){

  }

  /**
   * カレンダー5日に内部項目を追加します。
   */
  protected void addCalendar05(){

  }

  /**
   * カレンダー6日に内部項目を追加します。
   */
  protected void addCalendar06(){

  }

  /**
   * カレンダー7日に内部項目を追加します。
   */
  protected void addCalendar07(){

  }

  /**
   * カレンダー8日に内部項目を追加します。
   */
  protected void addCalendar08(){

  }

  /**
   * カレンダー9日に内部項目を追加します。
   */
  protected void addCalendar09(){

  }

  /**
   * カレンダー10日に内部項目を追加します。
   */
  protected void addCalendar10(){

  }

  /**
   * カレンダー11日に内部項目を追加します。
   */
  protected void addCalendar11(){

  }

  /**
   * カレンダー12日に内部項目を追加します。
   */
  protected void addCalendar12(){

  }

  /**
   * カレンダー13日に内部項目を追加します。
   */
  protected void addCalendar13(){

  }

  /**
   * カレンダー14日に内部項目を追加します。
   */
  protected void addCalendar14(){

  }

  /**
   * カレンダー15日に内部項目を追加します。
   */
  protected void addCalendar15(){

  }

  /**
   * カレンダー16日に内部項目を追加します。
   */
  protected void addCalendar16(){

  }

  /**
   * カレンダー17日に内部項目を追加します。
   */
  protected void addCalendar17(){

  }

  /**
   * カレンダー18日に内部項目を追加します。
   */
  protected void addCalendar18(){

  }

  /**
   * カレンダー19日に内部項目を追加します。
   */
  protected void addCalendar19(){

  }

  /**
   * カレンダー20日に内部項目を追加します。
   */
  protected void addCalendar20(){

  }

  /**
   * カレンダー21日に内部項目を追加します。
   */
  protected void addCalendar21(){

  }

  /**
   * カレンダー22日に内部項目を追加します。
   */
  protected void addCalendar22(){

  }

  /**
   * カレンダー23日に内部項目を追加します。
   */
  protected void addCalendar23(){

  }

  /**
   * カレンダー24日に内部項目を追加します。
   */
  protected void addCalendar24(){

  }

  /**
   * カレンダー25日に内部項目を追加します。
   */
  protected void addCalendar25(){

  }

  /**
   * カレンダー26日に内部項目を追加します。
   */
  protected void addCalendar26(){

  }

  /**
   * カレンダー27日に内部項目を追加します。
   */
  protected void addCalendar27(){

  }

  /**
   * カレンダー28日に内部項目を追加します。
   */
  protected void addCalendar28(){

  }

  /**
   * カレンダー29日に内部項目を追加します。
   */
  protected void addCalendar29(){

  }

  /**
   * カレンダー30日に内部項目を追加します。
   */
  protected void addCalendar30(){

  }

  /**
   * カレンダー31日に内部項目を追加します。
   */
  protected void addCalendar31(){

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
