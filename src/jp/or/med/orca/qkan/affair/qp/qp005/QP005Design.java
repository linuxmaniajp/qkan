
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
 * 作成日: 2015/03/13  日本コンピューター株式会社 樋口　雅彦 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 請求データ作成 (P)
 * プロセス 実績確定・請求データ作成 (005)
 * プログラム 明細書詳細編集 (QP005)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qp.qp005;
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
 * 明細書詳細編集画面項目デザイン(QP005) 
 */
public class QP005Design extends QkanAffairContainer implements ACAffairable {
  //GUIコンポーネント

  private ACAffairButtonBar buttons;

  private ACAffairButton retotal;

  private ACAffairButton renewal;

  private ACPanel contens;

  private ACPanel commonInfoPanle;

  private ACPanel commonInfos;

  private ACLabel commonInfoPattern;

  private ACLabel commonInfoProvider;

  private ACLabel commonInfoDate;

  private ACLabel commmonInfoName;

  private ACLabel commonInfoPublicExpenseLabelAll;

  private ACLabel commonInfoPublicExpenseText;

  private JTabbedPane etcInfoTabs;

  private ACPanel basicInfos;

  private ACPanel basicInfo;

  private ACLabel basicInfoLabel;

  private ACTable basicInfoTable;

  private VRTableColumnModel basicInfoTableColumnModel;

  private ACTableColumn basicInfoTablecolumn0;

  private ACTableColumn basicInfoTablecolumn1;

  private ACTableColumn basicInfoTablecolumn2;

  private ACTableColumn basicInfoTablecolumn3;

  private ACTableColumn basicInfoTablecolumn4;

  private ACTableColumn basicInfoTablecolumn5;

  private ACTableColumn basicInfoTablecolumn6;

  private ACTableColumn basicInfoTablecolumn7;

  private ACTableColumn basicInfoTablecolumn8;

  private ACTableColumn basicInfoTablecolumn9;

  private ACTableColumn basicInfoTablecolumn10;

  private ACTableColumn basicInfoTablecolumn11;

  private ACTableColumn basicInfoTablecolumn12;

  private ACTableColumn basicInfoTablecolumn13;

  private ACTableColumn basicInfoTablecolumn14;

  private ACPanel basicInfoRevisionPanel;

  private ACLabel basicInfoRevisionLabel;

  private ACLabel basicInfoRevisionLabel2;

  private ACIntegerCheckBox basicInfoRevisionCheck;

  private ACTable basicInfoRevisionTable;

  private VRTableColumnModel basicInfoRevisionTableColumnModel;

  private ACTableColumn basicInfoRevisionTablecolumn0;

  private ACTableColumn basicInfoRevisionTablecolumn1;

  private ACTableColumn basicInfoRevisionTablecolumn2;

  private ACTableColumn basicInfoRevisionTablecolumn3;

  private ACPanel detailsInfos;

  private ACPanel detailsInfoPanel;

  private ACLabel detailsInfoLabel;

  private ACButton detailsDelButton;

  private ACTable detailsInfoTable;

  private VRTableColumnModel detailsInfoTableColumnModel;

  private ACTableColumn detailsInfoTablecolumn0;

  private ACTableColumn detailsInfoTablecolumn1;

  private ACTableColumn detailsInfoTablecolumn2;

  private ACTableColumn detailsInfoTablecolumn3;

  private ACTableColumn detailsInfoTablecolumn4;

  private ACTableColumn detailsInfoTablecolumn5;

  private ACTableColumn detailsInfoTablecolumn6;

  private ACTableColumn detailsInfoTablecolumn7;

  private ACTableColumn detailsInfoTablecolumn8;

  private ACTableColumn detailsInfoTablecolumn9;

  private ACTableColumn detailsInfoTablecolumn10;

  private ACTableColumn detailsInfoTablecolumn11;

  private ACTableColumn detailsInfoTablecolumn12;

  private ACTable kyotakuDetailsInfoTable;

  private VRTableColumnModel kyotakuDetailsInfoTableColumnModel;

  private ACTableColumn kyotakuDetailsInfoTablecolumn0;

  private ACTableColumn kyotakuDetailsInfoTablecolumn1;

  private ACTableColumn kyotakuDetailsInfoTablecolumn2;

  private ACTableColumn kyotakuDetailsInfoTablecolumn3;

  private ACTableColumn kyotakuDetailsInfoTablecolumn4;

  private ACTableColumn kyotakuDetailsInfoTablecolumn5;

  private ACTableColumn kyotakuDetailsInfoTablecolumn6;

  private ACTableColumn kyotakuDetailsInfoTablecolumn7;

  private ACTableColumn kyotakuDetailsInfoTablecolumn8;

  private ACTableColumn kyotakuDetailsInfoTablecolumn9;

  private ACTableColumn kyotakuDetailsInfoTablecolumn10;

  private ACPanel detailsInfoRevisionPanel;

  private ACLabel detailsInfoRevisionLabel;

  private ACLabel detailsInfoRevision;

  private ACIntegerCheckBox detailsInfoRevisionCheck;

  private ACTable detailsInfoRevisionTable;

  private VRTableColumnModel detailsInfoRevisionTableColumnModel;

  private ACTableColumn detailsInfoRevisionTablecolumn0;

  private ACTableColumn detailsInfoRevisionTablecolumn1;

  private ACTableColumn detailsInfoRevisionTablecolumn2;

  private ACTableColumn detailsInfoRevisionTablecolumn3;

  private ACPanel particularInfos;

  private ACPanel particularInfoPanel;

  private ACLabel particularInfoLabel;

  private ACTable particularInfoTable;

  private VRTableColumnModel particularInfoTableColumnModel;

  private ACTableColumn particularInfoTablecolumn0;

  private ACTableColumn particularInfoTablecolumn1;

  private ACTableColumn particularInfoTablecolumn2;

  private ACTableColumn particularInfoTablecolumn3;

  private ACTableColumn particularInfoTablecolumn4;

  private ACTableColumn particularInfoTablecolumn5;

  private ACTableColumn particularInfoTablecolumn6;

  private ACTableColumn particularInfoTablecolumn7;

  private ACTableColumn particularInfoTablecolumn8;

  private ACTableColumn particularInfoTablecolumn9;

  private ACTableColumn particularInfoTablecolumn10;

  private ACTableColumn particularInfoTablecolumn11;

  private ACTableColumn particularInfoTablecolumn12;

  private ACTableColumn particularInfoTablecolumn13;

  private ACTableColumn particularInfoTablecolumn14;

  private ACTableColumn particularInfoTablecolumn15;

  private ACTableColumn particularInfoTablecolumn16;

  private ACTableColumn particularInfoTablecolumn17;

  private ACTableColumn particularInfoTablecolumn18;

  private ACTableColumn particularInfoTablecolumn19;

  private ACTable specialClinicInfoTable;

  private VRTableColumnModel specialClinicInfoTableColumnModel;

  private ACTableColumn specialClinicInfoTablecolumn0;

  private ACTableColumn specialClinicInfoTablecolumn1;

  private ACTableColumn specialClinicInfoTablecolumn2;

  private ACTableColumn specialClinicInfoTablecolumn3;

  private ACTableColumn specialClinicInfoTablecolumn4;

  private ACTableColumn specialClinicInfoTablecolumn5;

  private ACTableColumn specialClinicInfoTablecolumn6;

  private ACTableColumn specialClinicInfoTablecolumn7;

  private ACTableColumn specialClinicInfoTablecolumn8;

  private ACTableColumn specialClinicInfoTablecolumn9;

  private ACTableColumn specialClinicInfoTablecolumn10;

  private ACTableColumn specialClinicInfoTablecolumn11;

  private ACTableColumn specialClinicInfoTablecolumn12;

  private ACPanel particularInfoRevisionPanel;

  private ACLabel particularInfoRevisionLabel;

  private ACLabel particularInfoRevision;

  private ACIntegerCheckBox particularInfoRevisionCheck;

  private ACTable particularInfoRevisionTable;

  private VRTableColumnModel particularInfoRevisionTableColumnModel;

  private ACTableColumn particularInfoRevisionTablecolumn0;

  private ACTableColumn particularInfoRevisionTablecolumn1;

  private ACTableColumn particularInfoRevisionTablecolumn2;

  private ACTableColumn particularInfoRevisionTablecolumn3;

  private ACPanel totalInfos;

  private ACPanel totalInfoPanel;

  private ACLabel totalInfoLabel;

  private ACTable totalInfoTable;

  private VRTableColumnModel totalInfoTableColumnModel;

  private ACTableColumn totalInfoTablecolumn0;

  private ACTableColumn totalInfoTablecolumn1;

  private ACTableColumn totalInfoTablecolumn2;

  private ACTableColumn totalInfoTablecolumn3;

  private ACTableColumn totalInfoTablecolumn4;

  private ACTableColumn totalInfoTablecolumn5;

  private ACTableColumn totalInfoTablecolumn6;

  private ACTableColumn totalInfoTablecolumn7;

  private ACTableColumn totalInfoTablecolumn8;

  private ACTableColumn totalInfoTablecolumn9;

  private ACTableColumn totalInfoTablecolumn10;

  private ACTableColumn totalInfoTablecolumn11;

  private ACTableColumn totalInfoTablecolumn12;

  private ACTableColumn totalInfoTablecolumn13;

  private ACTableColumn totalInfoTablecolumn14;

  private ACTableColumn totalInfoTablecolumn15;

  private ACTableColumn totalInfoTablecolumn16;

  private ACTableColumn totalInfoTablecolumn17;

  private ACTableColumn totalInfoTablecolumn18;

  private ACTableColumn totalInfoTablecolumn19;

  private ACTableColumn totalInfoTablecolumn20;

  private ACPanel totalInfoRevisionPanel;

  private ACLabel totalInfoRevisionLabel;

  private ACLabel totalInfoRevision;

  private ACIntegerCheckBox totalInfoRevisionCheck;

  private ACTable totalInfoRevisionTable;

  private VRTableColumnModel totalInfoRevisionTableColumnModel;

  private ACTableColumn totalInfoRevisionTablecolumn0;

  private ACTableColumn totalInfoRevisionTablecolumn1;

  private ACTableColumn totalInfoRevisionTablecolumn2;

  private ACTableColumn totalInfoRevisionTablecolumn3;

  private ACPanel nyushoInfos;

  private ACPanel nyushoInfoPanel;

  private ACLabel nyushoInfoLabel;

  private ACButton serviceAddButton;

  private ACButton serviceDelButton;

  private ACTable nyushoInfoTable;

  private VRTableColumnModel nyushoInfoTableColumnModel;

  private ACTableColumn nyushoInfoTablecolumn0;

  private ACTableColumn nyushoInfoTablecolumn1;

  private ACTableColumn nyushoInfoTablecolumn2;

  private ACTableColumn nyushoInfoTablecolumn3;

  private ACTableColumn nyushoInfoTablecolumn4;

  private ACTableColumn nyushoInfoTablecolumn5;

  private ACTableColumn nyushoInfoTablecolumn6;

  private ACTableColumn nyushoInfoTablecolumn7;

  private ACTableColumn nyushoInfoTablecolumn8;

  private ACTableColumn nyushoInfoTablecolumn9;

  private ACTableColumn nyushoInfoTablecolumn10;

  private ACTableColumn nyushoInfoTablecolumn11;

  private ACTableColumn nyushoInfoTablecolumn12;

  private ACTableColumn nyushoInfoTablecolumn13;

  private ACTableColumn nyushoInfoTablecolumn14;

  private ACTableColumn nyushoInfoTablecolumn15;

  private ACTableColumn nyushoInfoTablecolumn16;

  private ACTableColumn nyushoInfoTablecolumn17;

  private ACTableColumn nyushoInfoTablecolumn18;

  private ACTableColumn nyushoInfoTablecolumn19;

  private ACTableColumn nyushoInfoTablecolumn20;

  private ACTableColumn nyushoInfoTablecolumn21;

  private ACTableColumn nyushoInfoTablecolumn22;

  private ACTableColumn nyushoInfoTablecolumn23;

  private ACTableColumn nyushoInfoTablecolumn24;

  private ACTableColumn nyushoInfoTablecolumn25;

  private ACTableColumn nyushoInfoTablecolumn26;

  private ACTableColumn nyushoInfoTablecolumn27;

  private ACPanel nyushoInfoRevisionPanel;

  private ACLabel nyushoInfoRevisionLabel;

  private ACLabel nyushoInfoRevision;

  private ACIntegerCheckBox nyushoInfoRevisionCheck;

  private ACTable nyushoInfoRevisionTable;

  private VRTableColumnModel nyushoInfoRevisionTableColumnModel;

  private ACTableColumn nyushoInfoRevisionTablecolumn0;

  private ACTableColumn nyushoInfoRevisionTablecolumn1;

  private ACTableColumn nyushoInfoRevisionTablecolumn2;

  private ACTableColumn nyushoInfoRevisionTablecolumn3;

  private ACPanel shahukuInfos;

  private ACPanel shahukuInfoPanel;

  private ACLabel shahukuInfoLabel;

  private ACTable shahukuInfoTable;

  private VRTableColumnModel shahukuInfoTableColumnModel;

  private ACTableColumn shahukuInfoTablecolumn0;

  private ACTableColumn shahukuInfoTablecolumn1;

  private ACTableColumn shahukuInfoTablecolumn2;

  private ACTableColumn shahukuInfoTablecolumn3;

  private ACTableColumn shahukuInfoTablecolumn4;

  private ACTableColumn shahukuInfoTablecolumn5;

  private ACTableColumn shahukuInfoTablecolumn6;

  private ACPanel shahukuInfoRevisionPanel;

  private ACLabel shahukuInfoRevisionLabel;

  private ACLabel shahukuInfoRevision;

  private ACIntegerCheckBox shahukuInfoRevisionCheck;

  private ACTable shahukuInfoRevisionTable;

  private VRTableColumnModel shahukuInfoRevisionTableColumnModel;

  private ACTableColumn shahukuInfoRevisionTablecolumn0;

  private ACTableColumn shahukuInfoRevisionTablecolumn1;

  private ACTableColumn shahukuInfoRevisionTablecolumn2;

  private ACTableColumn shahukuInfoRevisionTablecolumn3;

  private ACPanel recuperationInfos;

  private ACPanel recuperationInfoPanel;

  private ACLabel recuperationInfoLabel;

  private ACTable recuperationInfoTable;

  private VRTableColumnModel recuperationInfoTableColumnModel;

  private ACTableColumn recuperationInfoTablecolumn0;

  private ACTableColumn recuperationInfoTablecolumn1;

  private ACTableColumn recuperationInfoTablecolumn2;

  private ACTableColumn recuperationInfoTablecolumn3;

  private ACTableColumn recuperationInfoTablecolumn4;

  private ACTableColumn recuperationInfoTablecolumn5;

  private ACTableColumn recuperationInfoTablecolumn6;

  private ACTableColumn recuperationInfoTablecolumn7;

  private ACTableColumn recuperationInfoTablecolumn8;

  private ACTableColumn recuperationInfoTablecolumn9;

  private ACTableColumn recuperationInfoTablecolumn10;

  private ACTableColumn recuperationInfoTablecolumn11;

  private ACTableColumn recuperationInfoTablecolumn12;

  private ACPanel recuperationInfoRevisionPanel;

  private ACLabel recuperationInfoRevisionLabel;

  private ACLabel recuperationInfoRevision;

  private ACIntegerCheckBox recuperationInfoRevisionCheck;

  private ACTable recuperationInfoRevisionTable;

  private VRTableColumnModel recuperationInfoRevisionTableColumnModel;

  private ACTableColumn recuperationInfoRevisionTablecolumn0;

  private ACTableColumn recuperationInfoRevisionTablecolumn1;

  private ACTableColumn recuperationInfoRevisionTablecolumn2;

  private ACTableColumn recuperationInfoRevisionTablecolumn3;

  private ACPanel detailsJushotiTokureiInfos;

  private ACPanel detailsJushotiTokureiPanel;

  private ACLabel detailsJushotiTokureiLabel;

  private ACButton detailsJushotiTokureiDelButton;

  private ACTable detailsJushotiTokureiInfoTable;

  private VRTableColumnModel detailsJushotiTokureiInfoTableColumnModel;

  private ACTableColumn detailsJushotiTokureiInfoTablecolumn0;

  private ACTableColumn detailsJushotiTokureiInfoTablecolumn1;

  private ACTableColumn detailsJushotiTokureiInfoTablecolumn2;

  private ACTableColumn detailsJushotiTokureiInfoTablecolumn3;

  private ACTableColumn detailsJushotiTokureiInfoTablecolumn4;

  private ACTableColumn detailsJushotiTokureiInfoTablecolumn5;

  private ACTableColumn detailsJushotiTokureiInfoTablecolumn6;

  private ACTableColumn detailsJushotiTokureiInfoTablecolumn7;

  private ACTableColumn detailsJushotiTokureiInfoTablecolumn8;

  private ACTableColumn detailsJushotiTokureiInfoTablecolumn9;

  private ACTableColumn detailsJushotiTokureiInfoTablecolumn10;

  private ACTableColumn detailsJushotiTokureiInfoTablecolumn11;

  private ACTableColumn detailsJushotiTokureiInfoTablecolumn12;

  private ACTableColumn detailsJushotiTokureiInfoTablecolumn13;

  private ACPanel detailsJushotiTokureiInfoRevisionPanel;

  private ACLabel detailsJushotiTokureiInfoRevisionLabel;

  private ACLabel detailsJushotiTokureiInfoRevision;

  private ACIntegerCheckBox detailsJushotiTokureiInfoRevisionCheck;

  private ACTable detailsJushotiTokureiInfoRevisionTable;

  private VRTableColumnModel detailsJushotiTokureiInfoRevisionTableColumnModel;

  private ACTableColumn detailsJushotiTokureiInfoRevisionTablecolumn0;

  private ACTableColumn detailsJushotiTokureiInfoRevisionTablecolumn1;

  private ACTableColumn detailsJushotiTokureiInfoRevisionTablecolumn2;

  private ACTableColumn detailsJushotiTokureiInfoRevisionTablecolumn3;

  //getter

  /**
   * 業務ボタンバーを取得します。
   * @return 業務ボタンバー
   */
  public ACAffairButtonBar getButtons(){
    if(buttons==null){

      buttons = new ACAffairButtonBar();

      buttons.setText("明細書情報編集画面");

      addButtons();
    }
    return buttons;

  }

  /**
   * 再集計を取得します。
   * @return 再集計
   */
  public ACAffairButton getRetotal(){
    if(retotal==null){

      retotal = new ACAffairButton();

      retotal.setText("再集計(T)");

      retotal.setMnemonic('T');

      retotal.setIconPath(ACConstants.ICON_PATH_CALC_24);

      addRetotal();
    }
    return retotal;

  }

  /**
   * 更新を取得します。
   * @return 更新
   */
  public ACAffairButton getRenewal(){
    if(renewal==null){

      renewal = new ACAffairButton();

      renewal.setText("更新(S)");

      renewal.setMnemonic('S');

      renewal.setIconPath(ACConstants.ICON_PATH_UPDATE_24);

      addRenewal();
    }
    return renewal;

  }

  /**
   * クライアント領域を取得します。
   * @return クライアント領域
   */
  public ACPanel getContens(){
    if(contens==null){

      contens = new ACPanel();

      addContens();
    }
    return contens;

  }

  /**
   * 共通領域を取得します。
   * @return 共通領域
   */
  public ACPanel getCommonInfoPanle(){
    if(commonInfoPanle==null){

      commonInfoPanle = new ACPanel();

      addCommonInfoPanle();
    }
    return commonInfoPanle;

  }

  /**
   * 情報領域を取得します。
   * @return 情報領域
   */
  public ACPanel getCommonInfos(){
    if(commonInfos==null){

      commonInfos = new ACPanel();

      commonInfos.setAutoWrap(false);

      addCommonInfos();
    }
    return commonInfos;

  }

  /**
   * 様式テキストを取得します。
   * @return 様式テキスト
   */
  public ACLabel getCommonInfoPattern(){
    if(commonInfoPattern==null){

      commonInfoPattern = new ACLabel();

      commonInfoPattern.setText("様式入力");

      commonInfoPattern.setBindPath("CLAIM_STYLE_NAME");

      addCommonInfoPattern();
    }
    return commonInfoPattern;

  }

  /**
   * 事業者テキストを取得します。
   * @return 事業者テキスト
   */
  public ACLabel getCommonInfoProvider(){
    if(commonInfoProvider==null){

      commonInfoProvider = new ACLabel();

      commonInfoProvider.setText("事業所入力");

      commonInfoProvider.setBindPath("PROVIDER_NAME");

      addCommonInfoProvider();
    }
    return commonInfoProvider;

  }

  /**
   * 月日テキストを取得します。
   * @return 月日テキスト
   */
  public ACLabel getCommonInfoDate(){
    if(commonInfoDate==null){

      commonInfoDate = new ACLabel();

      commonInfoDate.setText("月日入力");

      commonInfoDate.setBindPath("TARGET_DATE");

      addCommonInfoDate();
    }
    return commonInfoDate;

  }

  /**
   * 名前テキストを取得します。
   * @return 名前テキスト
   */
  public ACLabel getCommmonInfoName(){
    if(commmonInfoName==null){

      commmonInfoName = new ACLabel();

      commmonInfoName.setText("名前入力");

      commmonInfoName.setBindPath("PATIENT_NAME");

      addCommmonInfoName();
    }
    return commmonInfoName;

  }

  /**
   * 該当公費一覧ラベルを取得します。
   * @return 該当公費一覧ラベル
   */
  public ACLabel getCommonInfoPublicExpenseLabelAll(){
    if(commonInfoPublicExpenseLabelAll==null){

      commonInfoPublicExpenseLabelAll = new ACLabel();

      commonInfoPublicExpenseLabelAll.setText("該当公費：");

      addCommonInfoPublicExpenseLabelAll();
    }
    return commonInfoPublicExpenseLabelAll;

  }

  /**
   * 該当公費・テキストを取得します。
   * @return 該当公費・テキスト
   */
  public ACLabel getCommonInfoPublicExpenseText(){
    if(commonInfoPublicExpenseText==null){

      commonInfoPublicExpenseText = new ACLabel();

      commonInfoPublicExpenseText.setText("1.原爆（100%）");

      commonInfoPublicExpenseText.setBindPath("KOHI_NAME");

      commonInfoPublicExpenseText.setColumns(60);

      addCommonInfoPublicExpenseText();
    }
    return commonInfoPublicExpenseText;

  }

  /**
   * 種類別タブを取得します。
   * @return 種類別タブ
   */
  public JTabbedPane getEtcInfoTabs(){
    if(etcInfoTabs==null){

      etcInfoTabs = new JTabbedPane();

      addEtcInfoTabs();
    }
    return etcInfoTabs;

  }

  /**
   * 基本情報領域を取得します。
   * @return 基本情報領域
   */
  public ACPanel getBasicInfos(){
    if(basicInfos==null){

      basicInfos = new ACPanel();

      addBasicInfos();
    }
    return basicInfos;

  }

  /**
   * 基本情報パネルを取得します。
   * @return 基本情報パネル
   */
  public ACPanel getBasicInfo(){
    if(basicInfo==null){

      basicInfo = new ACPanel();

      addBasicInfo();
    }
    return basicInfo;

  }

  /**
   * 基本情報ラベルを取得します。
   * @return 基本情報ラベル
   */
  public ACLabel getBasicInfoLabel(){
    if(basicInfoLabel==null){

      basicInfoLabel = new ACLabel();

      basicInfoLabel.setText("基本情報");

      addBasicInfoLabel();
    }
    return basicInfoLabel;

  }

  /**
   * 基本情報テーブルを取得します。
   * @return 基本情報テーブル
   */
  public ACTable getBasicInfoTable(){
    if(basicInfoTable==null){

      basicInfoTable = new ACTable();

      basicInfoTable.setColumnModel(getBasicInfoTableColumnModel());

      basicInfoTable.setColumnSort(false);

      addBasicInfoTable();
    }
    return basicInfoTable;

  }

  /**
   * 基本情報テーブルカラムモデルを取得します。
   * @return 基本情報テーブルカラムモデル
   */
  protected VRTableColumnModel getBasicInfoTableColumnModel(){
    if(basicInfoTableColumnModel==null){
      basicInfoTableColumnModel = new VRTableColumnModel(new TableColumn[]{});
      addBasicInfoTableColumnModel();
    }
    return basicInfoTableColumnModel;
  }

  /**
   * No.を取得します。
   * @return No.
   */
  public ACTableColumn getBasicInfoTablecolumn0(){
    if(basicInfoTablecolumn0==null){

      basicInfoTablecolumn0 = new ACTableColumn(0, 30);

      basicInfoTablecolumn0.setHeaderValue("　");

      basicInfoTablecolumn0.setRendererType(ACTableCellViewer.RENDERER_TYPE_SERIAL_NO);

      basicInfoTablecolumn0.setSortable(false);

      addBasicInfoTablecolumn0();
    }
    return basicInfoTablecolumn0;

  }

  /**
   * 保険者番号を取得します。
   * @return 保険者番号
   */
  public ACTableColumn getBasicInfoTablecolumn1(){
    if(basicInfoTablecolumn1==null){

      basicInfoTablecolumn1 = new ACTableColumn(0, 80);

      basicInfoTablecolumn1.setHeaderValue("保険者番号");

      addBasicInfoTablecolumn1();
    }
    return basicInfoTablecolumn1;

  }

  /**
   * 被保険者番号を取得します。
   * @return 被保険者番号
   */
  public ACTableColumn getBasicInfoTablecolumn2(){
    if(basicInfoTablecolumn2==null){

      basicInfoTablecolumn2 = new ACTableColumn(1, 100);

      basicInfoTablecolumn2.setHeaderValue("被保険者番号");

      addBasicInfoTablecolumn2();
    }
    return basicInfoTablecolumn2;

  }

  /**
   * 要介護状態区分コードを取得します。
   * @return 要介護状態区分コード
   */
  public ACTableColumn getBasicInfoTablecolumn3(){
    if(basicInfoTablecolumn3==null){

      basicInfoTablecolumn3 = new ACTableColumn(2, 140);

      basicInfoTablecolumn3.setHeaderValue("要介護状態区分コード");

      addBasicInfoTablecolumn3();
    }
    return basicInfoTablecolumn3;

  }

  /**
   * 認定有効期間開始年月日を取得します。
   * @return 認定有効期間開始年月日
   */
  public ACTableColumn getBasicInfoTablecolumn4(){
    if(basicInfoTablecolumn4==null){

      basicInfoTablecolumn4 = new ACTableColumn(3, 150);

      basicInfoTablecolumn4.setHeaderValue("認定有効期間開始年月日");

      addBasicInfoTablecolumn4();
    }
    return basicInfoTablecolumn4;

  }

  /**
   * 認定有効期間終了年月日を取得します。
   * @return 認定有効期間終了年月日
   */
  public ACTableColumn getBasicInfoTablecolumn5(){
    if(basicInfoTablecolumn5==null){

      basicInfoTablecolumn5 = new ACTableColumn(4, 150);

      basicInfoTablecolumn5.setHeaderValue("認定有効期間終了年月日");

      addBasicInfoTablecolumn5();
    }
    return basicInfoTablecolumn5;

  }

  /**
   * 居宅サービス計画者事業所番号を取得します。
   * @return 居宅サービス計画者事業所番号
   */
  public ACTableColumn getBasicInfoTablecolumn6(){
    if(basicInfoTablecolumn6==null){

      basicInfoTablecolumn6 = new ACTableColumn(5, 185);

      basicInfoTablecolumn6.setHeaderValue("居宅サービス計画者事業所番号");

      addBasicInfoTablecolumn6();
    }
    return basicInfoTablecolumn6;

  }

  /**
   * 居宅サービス計画者事業所名を取得します。
   * @return 居宅サービス計画者事業所名
   */
  public ACTableColumn getBasicInfoTablecolumn7(){
    if(basicInfoTablecolumn7==null){

      basicInfoTablecolumn7 = new ACTableColumn(6, 175);

      basicInfoTablecolumn7.setHeaderValue("居宅サービス計画者事業所名");

      addBasicInfoTablecolumn7();
    }
    return basicInfoTablecolumn7;

  }

  /**
   * 開始年月日を取得します。
   * @return 開始年月日
   */
  public ACTableColumn getBasicInfoTablecolumn8(){
    if(basicInfoTablecolumn8==null){

      basicInfoTablecolumn8 = new ACTableColumn(7, 80);

      basicInfoTablecolumn8.setHeaderValue("開始年月日");

      addBasicInfoTablecolumn8();
    }
    return basicInfoTablecolumn8;

  }

  /**
   * 中止年月日を取得します。
   * @return 中止年月日
   */
  public ACTableColumn getBasicInfoTablecolumn9(){
    if(basicInfoTablecolumn9==null){

      basicInfoTablecolumn9 = new ACTableColumn(8, 80);

      basicInfoTablecolumn9.setHeaderValue("中止年月日");

      addBasicInfoTablecolumn9();
    }
    return basicInfoTablecolumn9;

  }

  /**
   * 中止理由コードを取得します。
   * @return 中止理由コード
   */
  public ACTableColumn getBasicInfoTablecolumn10(){
    if(basicInfoTablecolumn10==null){

      basicInfoTablecolumn10 = new ACTableColumn(9, 100);

      basicInfoTablecolumn10.setHeaderValue("中止理由コード");

      addBasicInfoTablecolumn10();
    }
    return basicInfoTablecolumn10;

  }

  /**
   * 入所(院)年月日を取得します。
   * @return 入所(院)年月日
   */
  public ACTableColumn getBasicInfoTablecolumn11(){
    if(basicInfoTablecolumn11==null){

      basicInfoTablecolumn11 = new ACTableColumn(10, 100);

      basicInfoTablecolumn11.setHeaderValue("入所(院)年月日");

      addBasicInfoTablecolumn11();
    }
    return basicInfoTablecolumn11;

  }

  /**
   * 退所(院)年月日を取得します。
   * @return 退所(院)年月日
   */
  public ACTableColumn getBasicInfoTablecolumn12(){
    if(basicInfoTablecolumn12==null){

      basicInfoTablecolumn12 = new ACTableColumn(11, 100);

      basicInfoTablecolumn12.setHeaderValue("退所(院)年月日");

      addBasicInfoTablecolumn12();
    }
    return basicInfoTablecolumn12;

  }

  /**
   * 入所(院)実日数を取得します。
   * @return 入所(院)実日数
   */
  public ACTableColumn getBasicInfoTablecolumn13(){
    if(basicInfoTablecolumn13==null){

      basicInfoTablecolumn13 = new ACTableColumn(12, 120);

      basicInfoTablecolumn13.setHeaderValue("入所(院)実日数");

      addBasicInfoTablecolumn13();
    }
    return basicInfoTablecolumn13;

  }

  /**
   * 主傷病を取得します。
   * @return 主傷病
   */
  public ACTableColumn getBasicInfoTablecolumn14(){
    if(basicInfoTablecolumn14==null){

      basicInfoTablecolumn14 = new ACTableColumn(13, 60);

      basicInfoTablecolumn14.setHeaderValue("主傷病");

      addBasicInfoTablecolumn14();
    }
    return basicInfoTablecolumn14;

  }

  /**
   * 基本設定内容修正パネルを取得します。
   * @return 基本設定内容修正パネル
   */
  public ACPanel getBasicInfoRevisionPanel(){
    if(basicInfoRevisionPanel==null){

      basicInfoRevisionPanel = new ACPanel();

      addBasicInfoRevisionPanel();
    }
    return basicInfoRevisionPanel;

  }

  /**
   * 設定内容修正欄ラベルを取得します。
   * @return 設定内容修正欄ラベル
   */
  public ACLabel getBasicInfoRevisionLabel(){
    if(basicInfoRevisionLabel==null){

      basicInfoRevisionLabel = new ACLabel();

      basicInfoRevisionLabel.setText("設定内容修正欄");

      addBasicInfoRevisionLabel();
    }
    return basicInfoRevisionLabel;

  }

  /**
   * 基本情報を取得します。
   * @return 基本情報
   */
  public ACLabel getBasicInfoRevisionLabel2(){
    if(basicInfoRevisionLabel2==null){

      basicInfoRevisionLabel2 = new ACLabel();

      basicInfoRevisionLabel2.setText("基本情報");

      addBasicInfoRevisionLabel2();
    }
    return basicInfoRevisionLabel2;

  }

  /**
   * 全ての情報を表示を取得します。
   * @return 全ての情報を表示
   */
  public ACIntegerCheckBox getBasicInfoRevisionCheck(){
    if(basicInfoRevisionCheck==null){

      basicInfoRevisionCheck = new ACIntegerCheckBox();

      basicInfoRevisionCheck.setText("すべての情報を表示（A）");

      basicInfoRevisionCheck.setMnemonic('A');

      addBasicInfoRevisionCheck();
    }
    return basicInfoRevisionCheck;

  }

  /**
   * 基本情報詳細テーブルを取得します。
   * @return 基本情報詳細テーブル
   */
  public ACTable getBasicInfoRevisionTable(){
    if(basicInfoRevisionTable==null){

      basicInfoRevisionTable = new ACTable();

      basicInfoRevisionTable.setColumnModel(getBasicInfoRevisionTableColumnModel());

      basicInfoRevisionTable.setColumnSort(false);

      addBasicInfoRevisionTable();
    }
    return basicInfoRevisionTable;

  }

  /**
   * 基本情報詳細テーブルカラムモデルを取得します。
   * @return 基本情報詳細テーブルカラムモデル
   */
  protected VRTableColumnModel getBasicInfoRevisionTableColumnModel(){
    if(basicInfoRevisionTableColumnModel==null){
      basicInfoRevisionTableColumnModel = new VRTableColumnModel(new TableColumn[]{});
      addBasicInfoRevisionTableColumnModel();
    }
    return basicInfoRevisionTableColumnModel;
  }

  /**
   * No.を取得します。
   * @return No.
   */
  public ACTableColumn getBasicInfoRevisionTablecolumn0(){
    if(basicInfoRevisionTablecolumn0==null){

      basicInfoRevisionTablecolumn0 = new ACTableColumn(0, 30);

      basicInfoRevisionTablecolumn0.setHeaderValue("　");

      basicInfoRevisionTablecolumn0.setRendererType(ACTableCellViewer.RENDERER_TYPE_SERIAL_NO);

      basicInfoRevisionTablecolumn0.setSortable(false);

      addBasicInfoRevisionTablecolumn0();
    }
    return basicInfoRevisionTablecolumn0;

  }

  /**
   * 項目名を取得します。
   * @return 項目名
   */
  public ACTableColumn getBasicInfoRevisionTablecolumn1(){
    if(basicInfoRevisionTablecolumn1==null){

      basicInfoRevisionTablecolumn1 = new ACTableColumn(0, 55);

      basicInfoRevisionTablecolumn1.setHeaderValue("項目名");

      basicInfoRevisionTablecolumn1.setColumns(15);

      addBasicInfoRevisionTablecolumn1();
    }
    return basicInfoRevisionTablecolumn1;

  }

  /**
   * 設定値を取得します。
   * @return 設定値
   */
  public ACTableColumn getBasicInfoRevisionTablecolumn2(){
    if(basicInfoRevisionTablecolumn2==null){

      basicInfoRevisionTablecolumn2 = new ACTableColumn(1, 55);

      basicInfoRevisionTablecolumn2.setHeaderValue("設定値");

      basicInfoRevisionTablecolumn2.setEditable(true);

      basicInfoRevisionTablecolumn2.setColumns(8);

      addBasicInfoRevisionTablecolumn2();
    }
    return basicInfoRevisionTablecolumn2;

  }

  /**
   * コメントを取得します。
   * @return コメント
   */
  public ACTableColumn getBasicInfoRevisionTablecolumn3(){
    if(basicInfoRevisionTablecolumn3==null){

      basicInfoRevisionTablecolumn3 = new ACTableColumn(2, 55);

      basicInfoRevisionTablecolumn3.setHeaderValue("コメント");

      basicInfoRevisionTablecolumn3.setColumns(30);

      addBasicInfoRevisionTablecolumn3();
    }
    return basicInfoRevisionTablecolumn3;

  }

  /**
   * 明細情報領域を取得します。
   * @return 明細情報領域
   */
  public ACPanel getDetailsInfos(){
    if(detailsInfos==null){

      detailsInfos = new ACPanel();

      addDetailsInfos();
    }
    return detailsInfos;

  }

  /**
   * 明細情報パネルを取得します。
   * @return 明細情報パネル
   */
  public ACPanel getDetailsInfoPanel(){
    if(detailsInfoPanel==null){

      detailsInfoPanel = new ACPanel();

      addDetailsInfoPanel();
    }
    return detailsInfoPanel;

  }

  /**
   * 明細情報ラベルを取得します。
   * @return 明細情報ラベル
   */
  public ACLabel getDetailsInfoLabel(){
    if(detailsInfoLabel==null){

      detailsInfoLabel = new ACLabel();

      detailsInfoLabel.setText("明細情報");

      addDetailsInfoLabel();
    }
    return detailsInfoLabel;

  }

  /**
   * サービス削除ボタンを取得します。
   * @return サービス削除ボタン
   */
  public ACButton getDetailsDelButton(){
    if(detailsDelButton==null){

      detailsDelButton = new ACButton();

      detailsDelButton.setText("サービス削除");

      detailsDelButton.setIconPath(ACConstants.ICON_PATH_STATE_DELETE_16);

      addDetailsDelButton();
    }
    return detailsDelButton;

  }

  /**
   * 明細情報テーブルを取得します。
   * @return 明細情報テーブル
   */
  public ACTable getDetailsInfoTable(){
    if(detailsInfoTable==null){

      detailsInfoTable = new ACTable();

      detailsInfoTable.setColumnModel(getDetailsInfoTableColumnModel());

      detailsInfoTable.setColumnSort(false);

      addDetailsInfoTable();
    }
    return detailsInfoTable;

  }

  /**
   * 明細情報テーブルカラムモデルを取得します。
   * @return 明細情報テーブルカラムモデル
   */
  protected VRTableColumnModel getDetailsInfoTableColumnModel(){
    if(detailsInfoTableColumnModel==null){
      detailsInfoTableColumnModel = new VRTableColumnModel(new TableColumn[]{});
      addDetailsInfoTableColumnModel();
    }
    return detailsInfoTableColumnModel;
  }

  /**
   * No.を取得します。
   * @return No.
   */
  public ACTableColumn getDetailsInfoTablecolumn0(){
    if(detailsInfoTablecolumn0==null){

      detailsInfoTablecolumn0 = new ACTableColumn(0, 30);

      detailsInfoTablecolumn0.setHeaderValue("　");

      detailsInfoTablecolumn0.setRendererType(ACTableCellViewer.RENDERER_TYPE_SERIAL_NO);

      detailsInfoTablecolumn0.setSortable(false);

      addDetailsInfoTablecolumn0();
    }
    return detailsInfoTablecolumn0;

  }

  /**
   * サービスコードを取得します。
   * @return サービスコード
   */
  public ACTableColumn getDetailsInfoTablecolumn1(){
    if(detailsInfoTablecolumn1==null){

      detailsInfoTablecolumn1 = new ACTableColumn(0, 105);

      detailsInfoTablecolumn1.setHeaderValue("サービスコード");

      addDetailsInfoTablecolumn1();
    }
    return detailsInfoTablecolumn1;

  }

  /**
   * サービス名称を取得します。
   * @return サービス名称
   */
  public ACTableColumn getDetailsInfoTablecolumn2(){
    if(detailsInfoTablecolumn2==null){

      detailsInfoTablecolumn2 = new ACTableColumn(1, 90);

      detailsInfoTablecolumn2.setHeaderValue("サービス名称");

      addDetailsInfoTablecolumn2();
    }
    return detailsInfoTablecolumn2;

  }

  /**
   * 単位数を取得します。
   * @return 単位数
   */
  public ACTableColumn getDetailsInfoTablecolumn3(){
    if(detailsInfoTablecolumn3==null){

      detailsInfoTablecolumn3 = new ACTableColumn(2, 55);

      detailsInfoTablecolumn3.setHeaderValue("単位数");

      addDetailsInfoTablecolumn3();
    }
    return detailsInfoTablecolumn3;

  }

  /**
   * 日数・回数を取得します。
   * @return 日数・回数
   */
  public ACTableColumn getDetailsInfoTablecolumn4(){
    if(detailsInfoTablecolumn4==null){

      detailsInfoTablecolumn4 = new ACTableColumn(3, 75);

      detailsInfoTablecolumn4.setHeaderValue("日数・回数");

      addDetailsInfoTablecolumn4();
    }
    return detailsInfoTablecolumn4;

  }

  /**
   * 公費1対象日数・回数を取得します。
   * @return 公費1対象日数・回数
   */
  public ACTableColumn getDetailsInfoTablecolumn5(){
    if(detailsInfoTablecolumn5==null){

      detailsInfoTablecolumn5 = new ACTableColumn(4, 135);

      detailsInfoTablecolumn5.setHeaderValue("公費1対象日数・回数");

      addDetailsInfoTablecolumn5();
    }
    return detailsInfoTablecolumn5;

  }

  /**
   * 公費2対象日数・回数を取得します。
   * @return 公費2対象日数・回数
   */
  public ACTableColumn getDetailsInfoTablecolumn6(){
    if(detailsInfoTablecolumn6==null){

      detailsInfoTablecolumn6 = new ACTableColumn(5, 135);

      detailsInfoTablecolumn6.setHeaderValue("公費2対象日数・回数");

      addDetailsInfoTablecolumn6();
    }
    return detailsInfoTablecolumn6;

  }

  /**
   * 公費3対象日数・回数を取得します。
   * @return 公費3対象日数・回数
   */
  public ACTableColumn getDetailsInfoTablecolumn7(){
    if(detailsInfoTablecolumn7==null){

      detailsInfoTablecolumn7 = new ACTableColumn(6, 135);

      detailsInfoTablecolumn7.setHeaderValue("公費3対象日数・回数");

      addDetailsInfoTablecolumn7();
    }
    return detailsInfoTablecolumn7;

  }

  /**
   * サービス単位数を取得します。
   * @return サービス単位数
   */
  public ACTableColumn getDetailsInfoTablecolumn8(){
    if(detailsInfoTablecolumn8==null){

      detailsInfoTablecolumn8 = new ACTableColumn(7, 105);

      detailsInfoTablecolumn8.setHeaderValue("サービス単位数");

      addDetailsInfoTablecolumn8();
    }
    return detailsInfoTablecolumn8;

  }

  /**
   * 公費1対象サービス単位数を取得します。
   * @return 公費1対象サービス単位数
   */
  public ACTableColumn getDetailsInfoTablecolumn9(){
    if(detailsInfoTablecolumn9==null){

      detailsInfoTablecolumn9 = new ACTableColumn(8, 165);

      detailsInfoTablecolumn9.setHeaderValue("公費1対象サービス単位数");

      addDetailsInfoTablecolumn9();
    }
    return detailsInfoTablecolumn9;

  }

  /**
   * 公費2対象サービス単位数を取得します。
   * @return 公費2対象サービス単位数
   */
  public ACTableColumn getDetailsInfoTablecolumn10(){
    if(detailsInfoTablecolumn10==null){

      detailsInfoTablecolumn10 = new ACTableColumn(9, 165);

      detailsInfoTablecolumn10.setHeaderValue("公費2対象サービス単位数");

      addDetailsInfoTablecolumn10();
    }
    return detailsInfoTablecolumn10;

  }

  /**
   * 公費3対象サービス単位数を取得します。
   * @return 公費3対象サービス単位数
   */
  public ACTableColumn getDetailsInfoTablecolumn11(){
    if(detailsInfoTablecolumn11==null){

      detailsInfoTablecolumn11 = new ACTableColumn(10, 165);

      detailsInfoTablecolumn11.setHeaderValue("公費3対象サービス単位数");

      addDetailsInfoTablecolumn11();
    }
    return detailsInfoTablecolumn11;

  }

  /**
   * 摘要(英数)を取得します。
   * @return 摘要(英数)
   */
  public ACTableColumn getDetailsInfoTablecolumn12(){
    if(detailsInfoTablecolumn12==null){

      detailsInfoTablecolumn12 = new ACTableColumn(11, 105);

      detailsInfoTablecolumn12.setHeaderValue("摘要(英数)");

      addDetailsInfoTablecolumn12();
    }
    return detailsInfoTablecolumn12;

  }

  /**
   * 居宅介護支援明細情報テーブルを取得します。
   * @return 居宅介護支援明細情報テーブル
   */
  public ACTable getKyotakuDetailsInfoTable(){
    if(kyotakuDetailsInfoTable==null){

      kyotakuDetailsInfoTable = new ACTable();

      kyotakuDetailsInfoTable.setColumnModel(getKyotakuDetailsInfoTableColumnModel());

      kyotakuDetailsInfoTable.setColumnSort(false);

      addKyotakuDetailsInfoTable();
    }
    return kyotakuDetailsInfoTable;

  }

  /**
   * 居宅介護支援明細情報テーブルカラムモデルを取得します。
   * @return 居宅介護支援明細情報テーブルカラムモデル
   */
  protected VRTableColumnModel getKyotakuDetailsInfoTableColumnModel(){
    if(kyotakuDetailsInfoTableColumnModel==null){
      kyotakuDetailsInfoTableColumnModel = new VRTableColumnModel(new TableColumn[]{});
      addKyotakuDetailsInfoTableColumnModel();
    }
    return kyotakuDetailsInfoTableColumnModel;
  }

  /**
   * No.を取得します。
   * @return No.
   */
  public ACTableColumn getKyotakuDetailsInfoTablecolumn0(){
    if(kyotakuDetailsInfoTablecolumn0==null){

      kyotakuDetailsInfoTablecolumn0 = new ACTableColumn(0, 30);

      kyotakuDetailsInfoTablecolumn0.setHeaderValue("　");

      kyotakuDetailsInfoTablecolumn0.setRendererType(ACTableCellViewer.RENDERER_TYPE_SERIAL_NO);

      kyotakuDetailsInfoTablecolumn0.setSortable(false);

      addKyotakuDetailsInfoTablecolumn0();
    }
    return kyotakuDetailsInfoTablecolumn0;

  }

  /**
   * 生年月日を取得します。
   * @return 生年月日
   */
  public ACTableColumn getKyotakuDetailsInfoTablecolumn1(){
    if(kyotakuDetailsInfoTablecolumn1==null){

      kyotakuDetailsInfoTablecolumn1 = new ACTableColumn(0, 105);

      kyotakuDetailsInfoTablecolumn1.setHeaderValue("生年月日");

      addKyotakuDetailsInfoTablecolumn1();
    }
    return kyotakuDetailsInfoTablecolumn1;

  }

  /**
   * 性別コードを取得します。
   * @return 性別コード
   */
  public ACTableColumn getKyotakuDetailsInfoTablecolumn2(){
    if(kyotakuDetailsInfoTablecolumn2==null){

      kyotakuDetailsInfoTablecolumn2 = new ACTableColumn(1, 90);

      kyotakuDetailsInfoTablecolumn2.setHeaderValue("性別コード");

      addKyotakuDetailsInfoTablecolumn2();
    }
    return kyotakuDetailsInfoTablecolumn2;

  }

  /**
   * 要介護状態区分コードを取得します。
   * @return 要介護状態区分コード
   */
  public ACTableColumn getKyotakuDetailsInfoTablecolumn3(){
    if(kyotakuDetailsInfoTablecolumn3==null){

      kyotakuDetailsInfoTablecolumn3 = new ACTableColumn(2, 55);

      kyotakuDetailsInfoTablecolumn3.setHeaderValue("要介護状態区分コード");

      addKyotakuDetailsInfoTablecolumn3();
    }
    return kyotakuDetailsInfoTablecolumn3;

  }

  /**
   * 認定有効期間開始日を取得します。
   * @return 認定有効期間開始日
   */
  public ACTableColumn getKyotakuDetailsInfoTablecolumn4(){
    if(kyotakuDetailsInfoTablecolumn4==null){

      kyotakuDetailsInfoTablecolumn4 = new ACTableColumn(3, 75);

      kyotakuDetailsInfoTablecolumn4.setHeaderValue("認定有効期間開始日");

      addKyotakuDetailsInfoTablecolumn4();
    }
    return kyotakuDetailsInfoTablecolumn4;

  }

  /**
   * 認定有効期間終了日を取得します。
   * @return 認定有効期間終了日
   */
  public ACTableColumn getKyotakuDetailsInfoTablecolumn5(){
    if(kyotakuDetailsInfoTablecolumn5==null){

      kyotakuDetailsInfoTablecolumn5 = new ACTableColumn(4, 135);

      kyotakuDetailsInfoTablecolumn5.setHeaderValue("認定有効期間終了日");

      addKyotakuDetailsInfoTablecolumn5();
    }
    return kyotakuDetailsInfoTablecolumn5;

  }

  /**
   * 居宅サービス計画作成依頼届出年月日を取得します。
   * @return 居宅サービス計画作成依頼届出年月日
   */
  public ACTableColumn getKyotakuDetailsInfoTablecolumn6(){
    if(kyotakuDetailsInfoTablecolumn6==null){

      kyotakuDetailsInfoTablecolumn6 = new ACTableColumn(5, 135);

      kyotakuDetailsInfoTablecolumn6.setHeaderValue("居宅サービス計画作成依頼届出年月日");

      addKyotakuDetailsInfoTablecolumn6();
    }
    return kyotakuDetailsInfoTablecolumn6;

  }

  /**
   * サービスコードを取得します。
   * @return サービスコード
   */
  public ACTableColumn getKyotakuDetailsInfoTablecolumn7(){
    if(kyotakuDetailsInfoTablecolumn7==null){

      kyotakuDetailsInfoTablecolumn7 = new ACTableColumn(6, 135);

      kyotakuDetailsInfoTablecolumn7.setHeaderValue("サービスコード");

      addKyotakuDetailsInfoTablecolumn7();
    }
    return kyotakuDetailsInfoTablecolumn7;

  }

  /**
   * サービス名称を取得します。
   * @return サービス名称
   */
  public ACTableColumn getKyotakuDetailsInfoTablecolumn8(){
    if(kyotakuDetailsInfoTablecolumn8==null){

      kyotakuDetailsInfoTablecolumn8 = new ACTableColumn(7, 105);

      kyotakuDetailsInfoTablecolumn8.setHeaderValue("サービス名称");

      addKyotakuDetailsInfoTablecolumn8();
    }
    return kyotakuDetailsInfoTablecolumn8;

  }

  /**
   * 単位数を取得します。
   * @return 単位数
   */
  public ACTableColumn getKyotakuDetailsInfoTablecolumn9(){
    if(kyotakuDetailsInfoTablecolumn9==null){

      kyotakuDetailsInfoTablecolumn9 = new ACTableColumn(8, 165);

      kyotakuDetailsInfoTablecolumn9.setHeaderValue("単位数");

      addKyotakuDetailsInfoTablecolumn9();
    }
    return kyotakuDetailsInfoTablecolumn9;

  }

  /**
   * 請求金額を取得します。
   * @return 請求金額
   */
  public ACTableColumn getKyotakuDetailsInfoTablecolumn10(){
    if(kyotakuDetailsInfoTablecolumn10==null){

      kyotakuDetailsInfoTablecolumn10 = new ACTableColumn(9, 165);

      kyotakuDetailsInfoTablecolumn10.setHeaderValue("請求金額");

      addKyotakuDetailsInfoTablecolumn10();
    }
    return kyotakuDetailsInfoTablecolumn10;

  }

  /**
   * 明細設定内容修正パネルを取得します。
   * @return 明細設定内容修正パネル
   */
  public ACPanel getDetailsInfoRevisionPanel(){
    if(detailsInfoRevisionPanel==null){

      detailsInfoRevisionPanel = new ACPanel();

      addDetailsInfoRevisionPanel();
    }
    return detailsInfoRevisionPanel;

  }

  /**
   * 設定内容修正欄ラベルを取得します。
   * @return 設定内容修正欄ラベル
   */
  public ACLabel getDetailsInfoRevisionLabel(){
    if(detailsInfoRevisionLabel==null){

      detailsInfoRevisionLabel = new ACLabel();

      detailsInfoRevisionLabel.setText("設定内容修正欄");

      addDetailsInfoRevisionLabel();
    }
    return detailsInfoRevisionLabel;

  }

  /**
   * 明細情報を取得します。
   * @return 明細情報
   */
  public ACLabel getDetailsInfoRevision(){
    if(detailsInfoRevision==null){

      detailsInfoRevision = new ACLabel();

      detailsInfoRevision.setText("明細情報");

      addDetailsInfoRevision();
    }
    return detailsInfoRevision;

  }

  /**
   * 全ての情報を表示を取得します。
   * @return 全ての情報を表示
   */
  public ACIntegerCheckBox getDetailsInfoRevisionCheck(){
    if(detailsInfoRevisionCheck==null){

      detailsInfoRevisionCheck = new ACIntegerCheckBox();

      detailsInfoRevisionCheck.setText("すべての情報を表示（A）");

      detailsInfoRevisionCheck.setMnemonic('A');

      addDetailsInfoRevisionCheck();
    }
    return detailsInfoRevisionCheck;

  }

  /**
   * 明細情報詳細テーブルを取得します。
   * @return 明細情報詳細テーブル
   */
  public ACTable getDetailsInfoRevisionTable(){
    if(detailsInfoRevisionTable==null){

      detailsInfoRevisionTable = new ACTable();

      detailsInfoRevisionTable.setColumnModel(getDetailsInfoRevisionTableColumnModel());

      detailsInfoRevisionTable.setColumnSort(false);

      addDetailsInfoRevisionTable();
    }
    return detailsInfoRevisionTable;

  }

  /**
   * 明細情報詳細テーブルカラムモデルを取得します。
   * @return 明細情報詳細テーブルカラムモデル
   */
  protected VRTableColumnModel getDetailsInfoRevisionTableColumnModel(){
    if(detailsInfoRevisionTableColumnModel==null){
      detailsInfoRevisionTableColumnModel = new VRTableColumnModel(new TableColumn[]{});
      addDetailsInfoRevisionTableColumnModel();
    }
    return detailsInfoRevisionTableColumnModel;
  }

  /**
   * No.を取得します。
   * @return No.
   */
  public ACTableColumn getDetailsInfoRevisionTablecolumn0(){
    if(detailsInfoRevisionTablecolumn0==null){

      detailsInfoRevisionTablecolumn0 = new ACTableColumn(0, 30);

      detailsInfoRevisionTablecolumn0.setHeaderValue("　");

      detailsInfoRevisionTablecolumn0.setRendererType(ACTableCellViewer.RENDERER_TYPE_SERIAL_NO);

      detailsInfoRevisionTablecolumn0.setSortable(false);

      addDetailsInfoRevisionTablecolumn0();
    }
    return detailsInfoRevisionTablecolumn0;

  }

  /**
   * 項目名を取得します。
   * @return 項目名
   */
  public ACTableColumn getDetailsInfoRevisionTablecolumn1(){
    if(detailsInfoRevisionTablecolumn1==null){

      detailsInfoRevisionTablecolumn1 = new ACTableColumn(0, 55);

      detailsInfoRevisionTablecolumn1.setHeaderValue("項目名");

      detailsInfoRevisionTablecolumn1.setColumns(15);

      addDetailsInfoRevisionTablecolumn1();
    }
    return detailsInfoRevisionTablecolumn1;

  }

  /**
   * 設定値を取得します。
   * @return 設定値
   */
  public ACTableColumn getDetailsInfoRevisionTablecolumn2(){
    if(detailsInfoRevisionTablecolumn2==null){

      detailsInfoRevisionTablecolumn2 = new ACTableColumn(1, 55);

      detailsInfoRevisionTablecolumn2.setHeaderValue("設定値");

      detailsInfoRevisionTablecolumn2.setEditable(true);

      detailsInfoRevisionTablecolumn2.setColumns(8);

      addDetailsInfoRevisionTablecolumn2();
    }
    return detailsInfoRevisionTablecolumn2;

  }

  /**
   * コメントを取得します。
   * @return コメント
   */
  public ACTableColumn getDetailsInfoRevisionTablecolumn3(){
    if(detailsInfoRevisionTablecolumn3==null){

      detailsInfoRevisionTablecolumn3 = new ACTableColumn(2, 55);

      detailsInfoRevisionTablecolumn3.setHeaderValue("コメント");

      detailsInfoRevisionTablecolumn3.setColumns(30);

      addDetailsInfoRevisionTablecolumn3();
    }
    return detailsInfoRevisionTablecolumn3;

  }

  /**
   * 特定治療・特定診療情報領域を取得します。
   * @return 特定治療・特定診療情報領域
   */
  public ACPanel getParticularInfos(){
    if(particularInfos==null){

      particularInfos = new ACPanel();

      addParticularInfos();
    }
    return particularInfos;

  }

  /**
   * 特定治療費情報パネルを取得します。
   * @return 特定治療費情報パネル
   */
  public ACPanel getParticularInfoPanel(){
    if(particularInfoPanel==null){

      particularInfoPanel = new ACPanel();

      addParticularInfoPanel();
    }
    return particularInfoPanel;

  }

  /**
   * 特定治療費情報ラベルを取得します。
   * @return 特定治療費情報ラベル
   */
  public ACLabel getParticularInfoLabel(){
    if(particularInfoLabel==null){

      particularInfoLabel = new ACLabel();

      particularInfoLabel.setText("特定治療費情報");

      addParticularInfoLabel();
    }
    return particularInfoLabel;

  }

  /**
   * 特定治療費情報テーブルを取得します。
   * @return 特定治療費情報テーブル
   */
  public ACTable getParticularInfoTable(){
    if(particularInfoTable==null){

      particularInfoTable = new ACTable();

      particularInfoTable.setColumnModel(getParticularInfoTableColumnModel());

      particularInfoTable.setColumnSort(false);

      addParticularInfoTable();
    }
    return particularInfoTable;

  }

  /**
   * 特定治療費情報テーブルカラムモデルを取得します。
   * @return 特定治療費情報テーブルカラムモデル
   */
  protected VRTableColumnModel getParticularInfoTableColumnModel(){
    if(particularInfoTableColumnModel==null){
      particularInfoTableColumnModel = new VRTableColumnModel(new TableColumn[]{});
      addParticularInfoTableColumnModel();
    }
    return particularInfoTableColumnModel;
  }

  /**
   * No.を取得します。
   * @return No.
   */
  public ACTableColumn getParticularInfoTablecolumn0(){
    if(particularInfoTablecolumn0==null){

      particularInfoTablecolumn0 = new ACTableColumn(0, 30);

      particularInfoTablecolumn0.setHeaderValue("　");

      particularInfoTablecolumn0.setRendererType(ACTableCellViewer.RENDERER_TYPE_SERIAL_NO);

      particularInfoTablecolumn0.setSortable(false);

      addParticularInfoTablecolumn0();
    }
    return particularInfoTablecolumn0;

  }

  /**
   * 事業所番号を取得します。
   * @return 事業所番号
   */
  public ACTableColumn getParticularInfoTablecolumn1(){
    if(particularInfoTablecolumn1==null){

      particularInfoTablecolumn1 = new ACTableColumn(0, 75);

      particularInfoTablecolumn1.setHeaderValue("事業所番号");

      addParticularInfoTablecolumn1();
    }
    return particularInfoTablecolumn1;

  }

  /**
   * 緊急時傷病名1を取得します。
   * @return 緊急時傷病名1
   */
  public ACTableColumn getParticularInfoTablecolumn2(){
    if(particularInfoTablecolumn2==null){

      particularInfoTablecolumn2 = new ACTableColumn(1, 100);

      particularInfoTablecolumn2.setHeaderValue("緊急時傷病名1");

      addParticularInfoTablecolumn2();
    }
    return particularInfoTablecolumn2;

  }

  /**
   * 緊急時傷病名2を取得します。
   * @return 緊急時傷病名2
   */
  public ACTableColumn getParticularInfoTablecolumn3(){
    if(particularInfoTablecolumn3==null){

      particularInfoTablecolumn3 = new ACTableColumn(2, 100);

      particularInfoTablecolumn3.setHeaderValue("緊急時傷病名2");

      addParticularInfoTablecolumn3();
    }
    return particularInfoTablecolumn3;

  }

  /**
   * 緊急時傷病名3を取得します。
   * @return 緊急時傷病名3
   */
  public ACTableColumn getParticularInfoTablecolumn4(){
    if(particularInfoTablecolumn4==null){

      particularInfoTablecolumn4 = new ACTableColumn(3, 100);

      particularInfoTablecolumn4.setHeaderValue("緊急時傷病名3");

      addParticularInfoTablecolumn4();
    }
    return particularInfoTablecolumn4;

  }

  /**
   * 緊急時治療開始年月日1を取得します。
   * @return 緊急時治療開始年月日1
   */
  public ACTableColumn getParticularInfoTablecolumn5(){
    if(particularInfoTablecolumn5==null){

      particularInfoTablecolumn5 = new ACTableColumn(4, 150);

      particularInfoTablecolumn5.setHeaderValue("緊急時治療開始年月日1");

      addParticularInfoTablecolumn5();
    }
    return particularInfoTablecolumn5;

  }

  /**
   * 緊急時治療開始年月日2を取得します。
   * @return 緊急時治療開始年月日2
   */
  public ACTableColumn getParticularInfoTablecolumn6(){
    if(particularInfoTablecolumn6==null){

      particularInfoTablecolumn6 = new ACTableColumn(5, 150);

      particularInfoTablecolumn6.setHeaderValue("緊急時治療開始年月日2");

      addParticularInfoTablecolumn6();
    }
    return particularInfoTablecolumn6;

  }

  /**
   * 緊急時治療開始年月日3を取得します。
   * @return 緊急時治療開始年月日3
   */
  public ACTableColumn getParticularInfoTablecolumn7(){
    if(particularInfoTablecolumn7==null){

      particularInfoTablecolumn7 = new ACTableColumn(6, 150);

      particularInfoTablecolumn7.setHeaderValue("緊急時治療開始年月日3");

      addParticularInfoTablecolumn7();
    }
    return particularInfoTablecolumn7;

  }

  /**
   * 往診日数を取得します。
   * @return 往診日数
   */
  public ACTableColumn getParticularInfoTablecolumn8(){
    if(particularInfoTablecolumn8==null){

      particularInfoTablecolumn8 = new ACTableColumn(7, 70);

      particularInfoTablecolumn8.setHeaderValue("往診日数");

      addParticularInfoTablecolumn8();
    }
    return particularInfoTablecolumn8;

  }

  /**
   * 往診医療機関名を取得します。
   * @return 往診医療機関名
   */
  public ACTableColumn getParticularInfoTablecolumn9(){
    if(particularInfoTablecolumn9==null){

      particularInfoTablecolumn9 = new ACTableColumn(8, 105);

      particularInfoTablecolumn9.setHeaderValue("往診医療機関名");

      addParticularInfoTablecolumn9();
    }
    return particularInfoTablecolumn9;

  }

  /**
   * 通院日数を取得します。
   * @return 通院日数
   */
  public ACTableColumn getParticularInfoTablecolumn10(){
    if(particularInfoTablecolumn10==null){

      particularInfoTablecolumn10 = new ACTableColumn(9, 70);

      particularInfoTablecolumn10.setHeaderValue("通院日数");

      addParticularInfoTablecolumn10();
    }
    return particularInfoTablecolumn10;

  }

  /**
   * 通院医療機関名を取得します。
   * @return 通院医療機関名
   */
  public ACTableColumn getParticularInfoTablecolumn11(){
    if(particularInfoTablecolumn11==null){

      particularInfoTablecolumn11 = new ACTableColumn(10, 105);

      particularInfoTablecolumn11.setHeaderValue("通院医療機関名");

      addParticularInfoTablecolumn11();
    }
    return particularInfoTablecolumn11;

  }

  /**
   * 緊急時治療管理単位数を取得します。
   * @return 緊急時治療管理単位数
   */
  public ACTableColumn getParticularInfoTablecolumn12(){
    if(particularInfoTablecolumn12==null){

      particularInfoTablecolumn12 = new ACTableColumn(11, 140);

      particularInfoTablecolumn12.setHeaderValue("緊急時治療管理単位数");

      addParticularInfoTablecolumn12();
    }
    return particularInfoTablecolumn12;

  }

  /**
   * 緊急時治療管理日数を取得します。
   * @return 緊急時治療管理日数
   */
  public ACTableColumn getParticularInfoTablecolumn13(){
    if(particularInfoTablecolumn13==null){

      particularInfoTablecolumn13 = new ACTableColumn(12, 120);

      particularInfoTablecolumn13.setHeaderValue("緊急時治療管理日数");

      addParticularInfoTablecolumn13();
    }
    return particularInfoTablecolumn13;

  }

  /**
   * 緊急時治療管理小計を取得します。
   * @return 緊急時治療管理小計
   */
  public ACTableColumn getParticularInfoTablecolumn14(){
    if(particularInfoTablecolumn14==null){

      particularInfoTablecolumn14 = new ACTableColumn(13, 120);

      particularInfoTablecolumn14.setHeaderValue("緊急時治療管理小計");

      addParticularInfoTablecolumn14();
    }
    return particularInfoTablecolumn14;

  }

  /**
   * リハビリテーション点数を取得します。
   * @return リハビリテーション点数
   */
  public ACTableColumn getParticularInfoTablecolumn15(){
    if(particularInfoTablecolumn15==null){

      particularInfoTablecolumn15 = new ACTableColumn(14, 160);

      particularInfoTablecolumn15.setHeaderValue("リハビリテーション点数");

      addParticularInfoTablecolumn15();
    }
    return particularInfoTablecolumn15;

  }

  /**
   * 処置点数を取得します。
   * @return 処置点数
   */
  public ACTableColumn getParticularInfoTablecolumn16(){
    if(particularInfoTablecolumn16==null){

      particularInfoTablecolumn16 = new ACTableColumn(15, 70);

      particularInfoTablecolumn16.setHeaderValue("処置点数");

      addParticularInfoTablecolumn16();
    }
    return particularInfoTablecolumn16;

  }

  /**
   * 手術点数を取得します。
   * @return 手術点数
   */
  public ACTableColumn getParticularInfoTablecolumn17(){
    if(particularInfoTablecolumn17==null){

      particularInfoTablecolumn17 = new ACTableColumn(16, 70);

      particularInfoTablecolumn17.setHeaderValue("手術点数");

      addParticularInfoTablecolumn17();
    }
    return particularInfoTablecolumn17;

  }

  /**
   * 麻酔点数を取得します。
   * @return 麻酔点数
   */
  public ACTableColumn getParticularInfoTablecolumn18(){
    if(particularInfoTablecolumn18==null){

      particularInfoTablecolumn18 = new ACTableColumn(17, 70);

      particularInfoTablecolumn18.setHeaderValue("麻酔点数");

      addParticularInfoTablecolumn18();
    }
    return particularInfoTablecolumn18;

  }

  /**
   * 放射線治療点数を取得します。
   * @return 放射線治療点数
   */
  public ACTableColumn getParticularInfoTablecolumn19(){
    if(particularInfoTablecolumn19==null){

      particularInfoTablecolumn19 = new ACTableColumn(18, 105);

      particularInfoTablecolumn19.setHeaderValue("放射線治療点数");

      addParticularInfoTablecolumn19();
    }
    return particularInfoTablecolumn19;

  }

  /**
   * 特定診療費情報テーブルを取得します。
   * @return 特定診療費情報テーブル
   */
  public ACTable getSpecialClinicInfoTable(){
    if(specialClinicInfoTable==null){

      specialClinicInfoTable = new ACTable();

      specialClinicInfoTable.setColumnModel(getSpecialClinicInfoTableColumnModel());

      specialClinicInfoTable.setColumnSort(false);

      addSpecialClinicInfoTable();
    }
    return specialClinicInfoTable;

  }

  /**
   * 特定診療費情報テーブルカラムモデルを取得します。
   * @return 特定診療費情報テーブルカラムモデル
   */
  protected VRTableColumnModel getSpecialClinicInfoTableColumnModel(){
    if(specialClinicInfoTableColumnModel==null){
      specialClinicInfoTableColumnModel = new VRTableColumnModel(new TableColumn[]{});
      addSpecialClinicInfoTableColumnModel();
    }
    return specialClinicInfoTableColumnModel;
  }

  /**
   * No.を取得します。
   * @return No.
   */
  public ACTableColumn getSpecialClinicInfoTablecolumn0(){
    if(specialClinicInfoTablecolumn0==null){

      specialClinicInfoTablecolumn0 = new ACTableColumn(0, 30);

      specialClinicInfoTablecolumn0.setHeaderValue("　");

      specialClinicInfoTablecolumn0.setRendererType(ACTableCellViewer.RENDERER_TYPE_SERIAL_NO);

      specialClinicInfoTablecolumn0.setSortable(false);

      addSpecialClinicInfoTablecolumn0();
    }
    return specialClinicInfoTablecolumn0;

  }

  /**
   * 事業所番号を取得します。
   * @return 事業所番号
   */
  public ACTableColumn getSpecialClinicInfoTablecolumn1(){
    if(specialClinicInfoTablecolumn1==null){

      specialClinicInfoTablecolumn1 = new ACTableColumn(0, 75);

      specialClinicInfoTablecolumn1.setHeaderValue("事業所番号");

      addSpecialClinicInfoTablecolumn1();
    }
    return specialClinicInfoTablecolumn1;

  }

  /**
   * レコード順次番号を取得します。
   * @return レコード順次番号
   */
  public ACTableColumn getSpecialClinicInfoTablecolumn2(){
    if(specialClinicInfoTablecolumn2==null){

      specialClinicInfoTablecolumn2 = new ACTableColumn(1, 100);

      specialClinicInfoTablecolumn2.setHeaderValue("レコード順次番号");

      addSpecialClinicInfoTablecolumn2();
    }
    return specialClinicInfoTablecolumn2;

  }

  /**
   * 傷病名を取得します。
   * @return 傷病名
   */
  public ACTableColumn getSpecialClinicInfoTablecolumn3(){
    if(specialClinicInfoTablecolumn3==null){

      specialClinicInfoTablecolumn3 = new ACTableColumn(2, 100);

      specialClinicInfoTablecolumn3.setHeaderValue("傷病名");

      addSpecialClinicInfoTablecolumn3();
    }
    return specialClinicInfoTablecolumn3;

  }

  /**
   * 識別番号を取得します。
   * @return 識別番号
   */
  public ACTableColumn getSpecialClinicInfoTablecolumn4(){
    if(specialClinicInfoTablecolumn4==null){

      specialClinicInfoTablecolumn4 = new ACTableColumn(3, 100);

      specialClinicInfoTablecolumn4.setHeaderValue("識別番号");

      addSpecialClinicInfoTablecolumn4();
    }
    return specialClinicInfoTablecolumn4;

  }

  /**
   * 単位数を取得します。
   * @return 単位数
   */
  public ACTableColumn getSpecialClinicInfoTablecolumn5(){
    if(specialClinicInfoTablecolumn5==null){

      specialClinicInfoTablecolumn5 = new ACTableColumn(4, 150);

      specialClinicInfoTablecolumn5.setHeaderValue("単位数");

      addSpecialClinicInfoTablecolumn5();
    }
    return specialClinicInfoTablecolumn5;

  }

  /**
   * 保険回数を取得します。
   * @return 保険回数
   */
  public ACTableColumn getSpecialClinicInfoTablecolumn6(){
    if(specialClinicInfoTablecolumn6==null){

      specialClinicInfoTablecolumn6 = new ACTableColumn(5, 150);

      specialClinicInfoTablecolumn6.setHeaderValue("保険回数");

      addSpecialClinicInfoTablecolumn6();
    }
    return specialClinicInfoTablecolumn6;

  }

  /**
   * 保険サービス単位数を取得します。
   * @return 保険サービス単位数
   */
  public ACTableColumn getSpecialClinicInfoTablecolumn7(){
    if(specialClinicInfoTablecolumn7==null){

      specialClinicInfoTablecolumn7 = new ACTableColumn(6, 150);

      specialClinicInfoTablecolumn7.setHeaderValue("保険サービス単位数");

      addSpecialClinicInfoTablecolumn7();
    }
    return specialClinicInfoTablecolumn7;

  }

  /**
   * 保険合計単位数を取得します。
   * @return 保険合計単位数
   */
  public ACTableColumn getSpecialClinicInfoTablecolumn8(){
    if(specialClinicInfoTablecolumn8==null){

      specialClinicInfoTablecolumn8 = new ACTableColumn(7, 70);

      specialClinicInfoTablecolumn8.setHeaderValue("保険合計単位数");

      addSpecialClinicInfoTablecolumn8();
    }
    return specialClinicInfoTablecolumn8;

  }

  /**
   * 公費1回数を取得します。
   * @return 公費1回数
   */
  public ACTableColumn getSpecialClinicInfoTablecolumn9(){
    if(specialClinicInfoTablecolumn9==null){

      specialClinicInfoTablecolumn9 = new ACTableColumn(8, 105);

      specialClinicInfoTablecolumn9.setHeaderValue("公費1回数");

      addSpecialClinicInfoTablecolumn9();
    }
    return specialClinicInfoTablecolumn9;

  }

  /**
   * 公費2回数を取得します。
   * @return 公費2回数
   */
  public ACTableColumn getSpecialClinicInfoTablecolumn10(){
    if(specialClinicInfoTablecolumn10==null){

      specialClinicInfoTablecolumn10 = new ACTableColumn(9, 70);

      specialClinicInfoTablecolumn10.setHeaderValue("公費2回数");

      addSpecialClinicInfoTablecolumn10();
    }
    return specialClinicInfoTablecolumn10;

  }

  /**
   * 公費3回数を取得します。
   * @return 公費3回数
   */
  public ACTableColumn getSpecialClinicInfoTablecolumn11(){
    if(specialClinicInfoTablecolumn11==null){

      specialClinicInfoTablecolumn11 = new ACTableColumn(10, 105);

      specialClinicInfoTablecolumn11.setHeaderValue("公費3回数");

      addSpecialClinicInfoTablecolumn11();
    }
    return specialClinicInfoTablecolumn11;

  }

  /**
   * 摘要を取得します。
   * @return 摘要
   */
  public ACTableColumn getSpecialClinicInfoTablecolumn12(){
    if(specialClinicInfoTablecolumn12==null){

      specialClinicInfoTablecolumn12 = new ACTableColumn(11, 140);

      specialClinicInfoTablecolumn12.setHeaderValue("摘要");

      addSpecialClinicInfoTablecolumn12();
    }
    return specialClinicInfoTablecolumn12;

  }

  /**
   * 特定治療費・特定診療費設定内容修正パネルを取得します。
   * @return 特定治療費・特定診療費設定内容修正パネル
   */
  public ACPanel getParticularInfoRevisionPanel(){
    if(particularInfoRevisionPanel==null){

      particularInfoRevisionPanel = new ACPanel();

      addParticularInfoRevisionPanel();
    }
    return particularInfoRevisionPanel;

  }

  /**
   * 特定治療費・特定診療費設定内容修正欄ラベルを取得します。
   * @return 特定治療費・特定診療費設定内容修正欄ラベル
   */
  public ACLabel getParticularInfoRevisionLabel(){
    if(particularInfoRevisionLabel==null){

      particularInfoRevisionLabel = new ACLabel();

      particularInfoRevisionLabel.setText("設定内容修正欄");

      addParticularInfoRevisionLabel();
    }
    return particularInfoRevisionLabel;

  }

  /**
   * 特定治療費・特定診療費情報を取得します。
   * @return 特定治療費・特定診療費情報
   */
  public ACLabel getParticularInfoRevision(){
    if(particularInfoRevision==null){

      particularInfoRevision = new ACLabel();

      particularInfoRevision.setText("特定治療費情報");

      addParticularInfoRevision();
    }
    return particularInfoRevision;

  }

  /**
   * 全ての情報を表示を取得します。
   * @return 全ての情報を表示
   */
  public ACIntegerCheckBox getParticularInfoRevisionCheck(){
    if(particularInfoRevisionCheck==null){

      particularInfoRevisionCheck = new ACIntegerCheckBox();

      particularInfoRevisionCheck.setText("すべての情報を表示（A）");

      particularInfoRevisionCheck.setMnemonic('A');

      addParticularInfoRevisionCheck();
    }
    return particularInfoRevisionCheck;

  }

  /**
   * 特定治療費・特定診療費情報詳細テーブルを取得します。
   * @return 特定治療費・特定診療費情報詳細テーブル
   */
  public ACTable getParticularInfoRevisionTable(){
    if(particularInfoRevisionTable==null){

      particularInfoRevisionTable = new ACTable();

      particularInfoRevisionTable.setColumnModel(getParticularInfoRevisionTableColumnModel());

      particularInfoRevisionTable.setColumnSort(false);

      addParticularInfoRevisionTable();
    }
    return particularInfoRevisionTable;

  }

  /**
   * 特定治療費・特定診療費情報詳細テーブルカラムモデルを取得します。
   * @return 特定治療費・特定診療費情報詳細テーブルカラムモデル
   */
  protected VRTableColumnModel getParticularInfoRevisionTableColumnModel(){
    if(particularInfoRevisionTableColumnModel==null){
      particularInfoRevisionTableColumnModel = new VRTableColumnModel(new TableColumn[]{});
      addParticularInfoRevisionTableColumnModel();
    }
    return particularInfoRevisionTableColumnModel;
  }

  /**
   * No.を取得します。
   * @return No.
   */
  public ACTableColumn getParticularInfoRevisionTablecolumn0(){
    if(particularInfoRevisionTablecolumn0==null){

      particularInfoRevisionTablecolumn0 = new ACTableColumn(0, 30);

      particularInfoRevisionTablecolumn0.setHeaderValue("　");

      particularInfoRevisionTablecolumn0.setRendererType(ACTableCellViewer.RENDERER_TYPE_SERIAL_NO);

      particularInfoRevisionTablecolumn0.setSortable(false);

      addParticularInfoRevisionTablecolumn0();
    }
    return particularInfoRevisionTablecolumn0;

  }

  /**
   * 項目名を取得します。
   * @return 項目名
   */
  public ACTableColumn getParticularInfoRevisionTablecolumn1(){
    if(particularInfoRevisionTablecolumn1==null){

      particularInfoRevisionTablecolumn1 = new ACTableColumn(0, 55);

      particularInfoRevisionTablecolumn1.setHeaderValue("項目名");

      particularInfoRevisionTablecolumn1.setColumns(15);

      addParticularInfoRevisionTablecolumn1();
    }
    return particularInfoRevisionTablecolumn1;

  }

  /**
   * 設定値を取得します。
   * @return 設定値
   */
  public ACTableColumn getParticularInfoRevisionTablecolumn2(){
    if(particularInfoRevisionTablecolumn2==null){

      particularInfoRevisionTablecolumn2 = new ACTableColumn(1, 55);

      particularInfoRevisionTablecolumn2.setHeaderValue("設定値");

      particularInfoRevisionTablecolumn2.setEditable(true);

      particularInfoRevisionTablecolumn2.setColumns(8);

      addParticularInfoRevisionTablecolumn2();
    }
    return particularInfoRevisionTablecolumn2;

  }

  /**
   * コメントを取得します。
   * @return コメント
   */
  public ACTableColumn getParticularInfoRevisionTablecolumn3(){
    if(particularInfoRevisionTablecolumn3==null){

      particularInfoRevisionTablecolumn3 = new ACTableColumn(2, 55);

      particularInfoRevisionTablecolumn3.setHeaderValue("コメント");

      particularInfoRevisionTablecolumn3.setColumns(30);

      addParticularInfoRevisionTablecolumn3();
    }
    return particularInfoRevisionTablecolumn3;

  }

  /**
   * 集計情報領域を取得します。
   * @return 集計情報領域
   */
  public ACPanel getTotalInfos(){
    if(totalInfos==null){

      totalInfos = new ACPanel();

      addTotalInfos();
    }
    return totalInfos;

  }

  /**
   * 集計情報パネルを取得します。
   * @return 集計情報パネル
   */
  public ACPanel getTotalInfoPanel(){
    if(totalInfoPanel==null){

      totalInfoPanel = new ACPanel();

      addTotalInfoPanel();
    }
    return totalInfoPanel;

  }

  /**
   * 集計情報ラベルを取得します。
   * @return 集計情報ラベル
   */
  public ACLabel getTotalInfoLabel(){
    if(totalInfoLabel==null){

      totalInfoLabel = new ACLabel();

      totalInfoLabel.setText("集計情報");

      addTotalInfoLabel();
    }
    return totalInfoLabel;

  }

  /**
   * 集計情報テーブルを取得します。
   * @return 集計情報テーブル
   */
  public ACTable getTotalInfoTable(){
    if(totalInfoTable==null){

      totalInfoTable = new ACTable();

      totalInfoTable.setColumnModel(getTotalInfoTableColumnModel());

      totalInfoTable.setColumnSort(false);

      addTotalInfoTable();
    }
    return totalInfoTable;

  }

  /**
   * 集計情報テーブルカラムモデルを取得します。
   * @return 集計情報テーブルカラムモデル
   */
  protected VRTableColumnModel getTotalInfoTableColumnModel(){
    if(totalInfoTableColumnModel==null){
      totalInfoTableColumnModel = new VRTableColumnModel(new TableColumn[]{});
      addTotalInfoTableColumnModel();
    }
    return totalInfoTableColumnModel;
  }

  /**
   * No.を取得します。
   * @return No.
   */
  public ACTableColumn getTotalInfoTablecolumn0(){
    if(totalInfoTablecolumn0==null){

      totalInfoTablecolumn0 = new ACTableColumn(0, 30);

      totalInfoTablecolumn0.setHeaderValue("　");

      totalInfoTablecolumn0.setRendererType(ACTableCellViewer.RENDERER_TYPE_SERIAL_NO);

      totalInfoTablecolumn0.setSortable(false);

      addTotalInfoTablecolumn0();
    }
    return totalInfoTablecolumn0;

  }

  /**
   * サービス種類コードを取得します。
   * @return サービス種類コード
   */
  public ACTableColumn getTotalInfoTablecolumn1(){
    if(totalInfoTablecolumn1==null){

      totalInfoTablecolumn1 = new ACTableColumn(0, 135);

      totalInfoTablecolumn1.setHeaderValue("サービス種類コード");

      addTotalInfoTablecolumn1();
    }
    return totalInfoTablecolumn1;

  }

  /**
   * サービス実日数を取得します。
   * @return サービス実日数
   */
  public ACTableColumn getTotalInfoTablecolumn2(){
    if(totalInfoTablecolumn2==null){

      totalInfoTablecolumn2 = new ACTableColumn(1, 105);

      totalInfoTablecolumn2.setHeaderValue("サービス実日数");

      addTotalInfoTablecolumn2();
    }
    return totalInfoTablecolumn2;

  }

  /**
   * 計画単位数を取得します。
   * @return 計画単位数
   */
  public ACTableColumn getTotalInfoTablecolumn3(){
    if(totalInfoTablecolumn3==null){

      totalInfoTablecolumn3 = new ACTableColumn(2, 77);

      totalInfoTablecolumn3.setHeaderValue("計画単位数");

      addTotalInfoTablecolumn3();
    }
    return totalInfoTablecolumn3;

  }

  /**
   * 限度額管理対象単位数を取得します。
   * @return 限度額管理対象単位数
   */
  public ACTableColumn getTotalInfoTablecolumn4(){
    if(totalInfoTablecolumn4==null){

      totalInfoTablecolumn4 = new ACTableColumn(3, 140);

      totalInfoTablecolumn4.setHeaderValue("限度額管理対象単位数");

      addTotalInfoTablecolumn4();
    }
    return totalInfoTablecolumn4;

  }

  /**
   * 限度額管理対象外単位数を取得します。
   * @return 限度額管理対象外単位数
   */
  public ACTableColumn getTotalInfoTablecolumn5(){
    if(totalInfoTablecolumn5==null){

      totalInfoTablecolumn5 = new ACTableColumn(4, 155);

      totalInfoTablecolumn5.setHeaderValue("限度額管理対象外単位数");

      addTotalInfoTablecolumn5();
    }
    return totalInfoTablecolumn5;

  }

  /**
   * 短期入所計画日数を取得します。
   * @return 短期入所計画日数
   */
  public ACTableColumn getTotalInfoTablecolumn6(){
    if(totalInfoTablecolumn6==null){

      totalInfoTablecolumn6 = new ACTableColumn(5, 120);

      totalInfoTablecolumn6.setHeaderValue("短期入所計画日数");

      addTotalInfoTablecolumn6();
    }
    return totalInfoTablecolumn6;

  }

  /**
   * 短期入所実日数を取得します。
   * @return 短期入所実日数
   */
  public ACTableColumn getTotalInfoTablecolumn7(){
    if(totalInfoTablecolumn7==null){

      totalInfoTablecolumn7 = new ACTableColumn(6, 105);

      totalInfoTablecolumn7.setHeaderValue("短期入所実日数");

      addTotalInfoTablecolumn7();
    }
    return totalInfoTablecolumn7;

  }

  /**
   * 保険単位数合計を取得します。
   * @return 保険単位数合計
   */
  public ACTableColumn getTotalInfoTablecolumn8(){
    if(totalInfoTablecolumn8==null){

      totalInfoTablecolumn8 = new ACTableColumn(7, 105);

      totalInfoTablecolumn8.setHeaderValue("保険単位数合計");

      addTotalInfoTablecolumn8();
    }
    return totalInfoTablecolumn8;

  }

  /**
   * 保険単位数単価を取得します。
   * @return 保険単位数単価
   */
  public ACTableColumn getTotalInfoTablecolumn9(){
    if(totalInfoTablecolumn9==null){

      totalInfoTablecolumn9 = new ACTableColumn(8, 105);

      totalInfoTablecolumn9.setHeaderValue("保険単位数単価");

      addTotalInfoTablecolumn9();
    }
    return totalInfoTablecolumn9;

  }

  /**
   * 保険請求額を取得します。
   * @return 保険請求額
   */
  public ACTableColumn getTotalInfoTablecolumn10(){
    if(totalInfoTablecolumn10==null){

      totalInfoTablecolumn10 = new ACTableColumn(9, 77);

      totalInfoTablecolumn10.setHeaderValue("保険請求額");

      addTotalInfoTablecolumn10();
    }
    return totalInfoTablecolumn10;

  }

  /**
   * 保険利用者負担額を取得します。
   * @return 保険利用者負担額
   */
  public ACTableColumn getTotalInfoTablecolumn11(){
    if(totalInfoTablecolumn11==null){

      totalInfoTablecolumn11 = new ACTableColumn(10, 120);

      totalInfoTablecolumn11.setHeaderValue("保険利用者負担額");

      addTotalInfoTablecolumn11();
    }
    return totalInfoTablecolumn11;

  }

  /**
   * 公費1請求額を取得します。
   * @return 公費1請求額
   */
  public ACTableColumn getTotalInfoTablecolumn12(){
    if(totalInfoTablecolumn12==null){

      totalInfoTablecolumn12 = new ACTableColumn(11, 90);

      totalInfoTablecolumn12.setHeaderValue("公費1請求額");

      addTotalInfoTablecolumn12();
    }
    return totalInfoTablecolumn12;

  }

  /**
   * 公費1本人負担額を取得します。
   * @return 公費1本人負担額
   */
  public ACTableColumn getTotalInfoTablecolumn13(){
    if(totalInfoTablecolumn13==null){

      totalInfoTablecolumn13 = new ACTableColumn(12, 110);

      totalInfoTablecolumn13.setHeaderValue("公費1本人負担額");

      addTotalInfoTablecolumn13();
    }
    return totalInfoTablecolumn13;

  }

  /**
   * 公費2請求額を取得します。
   * @return 公費2請求額
   */
  public ACTableColumn getTotalInfoTablecolumn14(){
    if(totalInfoTablecolumn14==null){

      totalInfoTablecolumn14 = new ACTableColumn(13, 90);

      totalInfoTablecolumn14.setHeaderValue("公費2請求額");

      addTotalInfoTablecolumn14();
    }
    return totalInfoTablecolumn14;

  }

  /**
   * 公費2本人負担額を取得します。
   * @return 公費2本人負担額
   */
  public ACTableColumn getTotalInfoTablecolumn15(){
    if(totalInfoTablecolumn15==null){

      totalInfoTablecolumn15 = new ACTableColumn(14, 110);

      totalInfoTablecolumn15.setHeaderValue("公費2本人負担額");

      addTotalInfoTablecolumn15();
    }
    return totalInfoTablecolumn15;

  }

  /**
   * 公費3請求額を取得します。
   * @return 公費3請求額
   */
  public ACTableColumn getTotalInfoTablecolumn16(){
    if(totalInfoTablecolumn16==null){

      totalInfoTablecolumn16 = new ACTableColumn(15, 90);

      totalInfoTablecolumn16.setHeaderValue("公費3請求額");

      addTotalInfoTablecolumn16();
    }
    return totalInfoTablecolumn16;

  }

  /**
   * 公費3本人負担額を取得します。
   * @return 公費3本人負担額
   */
  public ACTableColumn getTotalInfoTablecolumn17(){
    if(totalInfoTablecolumn17==null){

      totalInfoTablecolumn17 = new ACTableColumn(16, 110);

      totalInfoTablecolumn17.setHeaderValue("公費3本人負担額");

      addTotalInfoTablecolumn17();
    }
    return totalInfoTablecolumn17;

  }

  /**
   * 保険分出来高医療費単位数合計を取得します。
   * @return 保険分出来高医療費単位数合計
   */
  public ACTableColumn getTotalInfoTablecolumn18(){
    if(totalInfoTablecolumn18==null){

      totalInfoTablecolumn18 = new ACTableColumn(17, 195);

      totalInfoTablecolumn18.setHeaderValue("保険分出来高医療費単位数合計");

      addTotalInfoTablecolumn18();
    }
    return totalInfoTablecolumn18;

  }

  /**
   * 保険分出来高医療費請求額を取得します。
   * @return 保険分出来高医療費請求額
   */
  public ACTableColumn getTotalInfoTablecolumn19(){
    if(totalInfoTablecolumn19==null){

      totalInfoTablecolumn19 = new ACTableColumn(18, 175);

      totalInfoTablecolumn19.setHeaderValue("保険分出来高医療費請求額");

      addTotalInfoTablecolumn19();
    }
    return totalInfoTablecolumn19;

  }

  /**
   * 保険分出来高医療費利用者負担額を取得します。
   * @return 保険分出来高医療費利用者負担額
   */
  public ACTableColumn getTotalInfoTablecolumn20(){
    if(totalInfoTablecolumn20==null){

      totalInfoTablecolumn20 = new ACTableColumn(19, 210);

      totalInfoTablecolumn20.setHeaderValue("保険分出来高医療費利用者負担額");

      addTotalInfoTablecolumn20();
    }
    return totalInfoTablecolumn20;

  }

  /**
   * 集計情報設定内容修正パネルを取得します。
   * @return 集計情報設定内容修正パネル
   */
  public ACPanel getTotalInfoRevisionPanel(){
    if(totalInfoRevisionPanel==null){

      totalInfoRevisionPanel = new ACPanel();

      addTotalInfoRevisionPanel();
    }
    return totalInfoRevisionPanel;

  }

  /**
   * 集計設定内容修正欄ラベルを取得します。
   * @return 集計設定内容修正欄ラベル
   */
  public ACLabel getTotalInfoRevisionLabel(){
    if(totalInfoRevisionLabel==null){

      totalInfoRevisionLabel = new ACLabel();

      totalInfoRevisionLabel.setText("設定内容修正欄");

      addTotalInfoRevisionLabel();
    }
    return totalInfoRevisionLabel;

  }

  /**
   * 集計情報を取得します。
   * @return 集計情報
   */
  public ACLabel getTotalInfoRevision(){
    if(totalInfoRevision==null){

      totalInfoRevision = new ACLabel();

      totalInfoRevision.setText("集計情報");

      addTotalInfoRevision();
    }
    return totalInfoRevision;

  }

  /**
   * 全ての情報を表示を取得します。
   * @return 全ての情報を表示
   */
  public ACIntegerCheckBox getTotalInfoRevisionCheck(){
    if(totalInfoRevisionCheck==null){

      totalInfoRevisionCheck = new ACIntegerCheckBox();

      totalInfoRevisionCheck.setText("すべての情報を表示（A）");

      totalInfoRevisionCheck.setMnemonic('A');

      addTotalInfoRevisionCheck();
    }
    return totalInfoRevisionCheck;

  }

  /**
   * 集計情報詳細テーブルを取得します。
   * @return 集計情報詳細テーブル
   */
  public ACTable getTotalInfoRevisionTable(){
    if(totalInfoRevisionTable==null){

      totalInfoRevisionTable = new ACTable();

      totalInfoRevisionTable.setColumnModel(getTotalInfoRevisionTableColumnModel());

      totalInfoRevisionTable.setColumnSort(false);

      addTotalInfoRevisionTable();
    }
    return totalInfoRevisionTable;

  }

  /**
   * 集計情報詳細テーブルカラムモデルを取得します。
   * @return 集計情報詳細テーブルカラムモデル
   */
  protected VRTableColumnModel getTotalInfoRevisionTableColumnModel(){
    if(totalInfoRevisionTableColumnModel==null){
      totalInfoRevisionTableColumnModel = new VRTableColumnModel(new TableColumn[]{});
      addTotalInfoRevisionTableColumnModel();
    }
    return totalInfoRevisionTableColumnModel;
  }

  /**
   * No.を取得します。
   * @return No.
   */
  public ACTableColumn getTotalInfoRevisionTablecolumn0(){
    if(totalInfoRevisionTablecolumn0==null){

      totalInfoRevisionTablecolumn0 = new ACTableColumn(0, 30);

      totalInfoRevisionTablecolumn0.setHeaderValue("　");

      totalInfoRevisionTablecolumn0.setRendererType(ACTableCellViewer.RENDERER_TYPE_SERIAL_NO);

      totalInfoRevisionTablecolumn0.setSortable(false);

      addTotalInfoRevisionTablecolumn0();
    }
    return totalInfoRevisionTablecolumn0;

  }

  /**
   * 項目名を取得します。
   * @return 項目名
   */
  public ACTableColumn getTotalInfoRevisionTablecolumn1(){
    if(totalInfoRevisionTablecolumn1==null){

      totalInfoRevisionTablecolumn1 = new ACTableColumn(0, 55);

      totalInfoRevisionTablecolumn1.setHeaderValue("項目名");

      totalInfoRevisionTablecolumn1.setColumns(15);

      addTotalInfoRevisionTablecolumn1();
    }
    return totalInfoRevisionTablecolumn1;

  }

  /**
   * 設定値を取得します。
   * @return 設定値
   */
  public ACTableColumn getTotalInfoRevisionTablecolumn2(){
    if(totalInfoRevisionTablecolumn2==null){

      totalInfoRevisionTablecolumn2 = new ACTableColumn(1, 55);

      totalInfoRevisionTablecolumn2.setHeaderValue("設定値");

      totalInfoRevisionTablecolumn2.setEditable(true);

      totalInfoRevisionTablecolumn2.setColumns(8);

      addTotalInfoRevisionTablecolumn2();
    }
    return totalInfoRevisionTablecolumn2;

  }

  /**
   * コメントを取得します。
   * @return コメント
   */
  public ACTableColumn getTotalInfoRevisionTablecolumn3(){
    if(totalInfoRevisionTablecolumn3==null){

      totalInfoRevisionTablecolumn3 = new ACTableColumn(2, 55);

      totalInfoRevisionTablecolumn3.setHeaderValue("コメント");

      totalInfoRevisionTablecolumn3.setColumns(30);

      addTotalInfoRevisionTablecolumn3();
    }
    return totalInfoRevisionTablecolumn3;

  }

  /**
   * 特定入所者介護費情報領域を取得します。
   * @return 特定入所者介護費情報領域
   */
  public ACPanel getNyushoInfos(){
    if(nyushoInfos==null){

      nyushoInfos = new ACPanel();

      addNyushoInfos();
    }
    return nyushoInfos;

  }

  /**
   * 特定入所者介護費情報パネルを取得します。
   * @return 特定入所者介護費情報パネル
   */
  public ACPanel getNyushoInfoPanel(){
    if(nyushoInfoPanel==null){

      nyushoInfoPanel = new ACPanel();

      addNyushoInfoPanel();
    }
    return nyushoInfoPanel;

  }

  /**
   * 特定入所者介護費情報ラベルを取得します。
   * @return 特定入所者介護費情報ラベル
   */
  public ACLabel getNyushoInfoLabel(){
    if(nyushoInfoLabel==null){

      nyushoInfoLabel = new ACLabel();

      nyushoInfoLabel.setText("特定入所者介護費情報");

      addNyushoInfoLabel();
    }
    return nyushoInfoLabel;

  }

  /**
   * サービス追加ボタンを取得します。
   * @return サービス追加ボタン
   */
  public ACButton getServiceAddButton(){
    if(serviceAddButton==null){

      serviceAddButton = new ACButton();

      serviceAddButton.setText("サービス追加");

      serviceAddButton.setIconPath(ACConstants.ICON_PATH_RECORD_DOWNLOAD_16);

      addServiceAddButton();
    }
    return serviceAddButton;

  }

  /**
   * サービス削除ボタンを取得します。
   * @return サービス削除ボタン
   */
  public ACButton getServiceDelButton(){
    if(serviceDelButton==null){

      serviceDelButton = new ACButton();

      serviceDelButton.setText("サービス削除");

      serviceDelButton.setIconPath(ACConstants.ICON_PATH_STATE_DELETE_16);

      addServiceDelButton();
    }
    return serviceDelButton;

  }

  /**
   * 特定入所者介護費情報テーブルを取得します。
   * @return 特定入所者介護費情報テーブル
   */
  public ACTable getNyushoInfoTable(){
    if(nyushoInfoTable==null){

      nyushoInfoTable = new ACTable();

      nyushoInfoTable.setColumnModel(getNyushoInfoTableColumnModel());

      nyushoInfoTable.setColumnSort(false);

      addNyushoInfoTable();
    }
    return nyushoInfoTable;

  }

  /**
   * 特定入所者介護費情報テーブルカラムモデルを取得します。
   * @return 特定入所者介護費情報テーブルカラムモデル
   */
  protected VRTableColumnModel getNyushoInfoTableColumnModel(){
    if(nyushoInfoTableColumnModel==null){
      nyushoInfoTableColumnModel = new VRTableColumnModel(new TableColumn[]{});
      addNyushoInfoTableColumnModel();
    }
    return nyushoInfoTableColumnModel;
  }

  /**
   * No.を取得します。
   * @return No.
   */
  public ACTableColumn getNyushoInfoTablecolumn0(){
    if(nyushoInfoTablecolumn0==null){

      nyushoInfoTablecolumn0 = new ACTableColumn(0, 30);

      nyushoInfoTablecolumn0.setHeaderValue("　");

      nyushoInfoTablecolumn0.setRendererType(ACTableCellViewer.RENDERER_TYPE_SERIAL_NO);

      nyushoInfoTablecolumn0.setSortable(false);

      addNyushoInfoTablecolumn0();
    }
    return nyushoInfoTablecolumn0;

  }

  /**
   * レコード順を取得します。
   * @return レコード順
   */
  public ACTableColumn getNyushoInfoTablecolumn1(){
    if(nyushoInfoTablecolumn1==null){

      nyushoInfoTablecolumn1 = new ACTableColumn(0, 80);

      nyushoInfoTablecolumn1.setHeaderValue("レコード順");

      addNyushoInfoTablecolumn1();
    }
    return nyushoInfoTablecolumn1;

  }

  /**
   * サービスコードを取得します。
   * @return サービスコード
   */
  public ACTableColumn getNyushoInfoTablecolumn2(){
    if(nyushoInfoTablecolumn2==null){

      nyushoInfoTablecolumn2 = new ACTableColumn(1, 110);

      nyushoInfoTablecolumn2.setHeaderValue("サービスコード");

      addNyushoInfoTablecolumn2();
    }
    return nyushoInfoTablecolumn2;

  }

  /**
   * サービス名を取得します。
   * @return サービス名
   */
  public ACTableColumn getNyushoInfoTablecolumn3(){
    if(nyushoInfoTablecolumn3==null){

      nyushoInfoTablecolumn3 = new ACTableColumn(2, 110);

      nyushoInfoTablecolumn3.setHeaderValue("サービス名");

      addNyushoInfoTablecolumn3();
    }
    return nyushoInfoTablecolumn3;

  }

  /**
   * 費用単価を取得します。
   * @return 費用単価
   */
  public ACTableColumn getNyushoInfoTablecolumn4(){
    if(nyushoInfoTablecolumn4==null){

      nyushoInfoTablecolumn4 = new ACTableColumn(3, 80);

      nyushoInfoTablecolumn4.setHeaderValue("費用単価");

      addNyushoInfoTablecolumn4();
    }
    return nyushoInfoTablecolumn4;

  }

  /**
   * 負担限度額を取得します。
   * @return 負担限度額
   */
  public ACTableColumn getNyushoInfoTablecolumn5(){
    if(nyushoInfoTablecolumn5==null){

      nyushoInfoTablecolumn5 = new ACTableColumn(4, 80);

      nyushoInfoTablecolumn5.setHeaderValue("負担限度額");

      addNyushoInfoTablecolumn5();
    }
    return nyushoInfoTablecolumn5;

  }

  /**
   * 日数を取得します。
   * @return 日数
   */
  public ACTableColumn getNyushoInfoTablecolumn6(){
    if(nyushoInfoTablecolumn6==null){

      nyushoInfoTablecolumn6 = new ACTableColumn(5, 50);

      nyushoInfoTablecolumn6.setHeaderValue("日数");

      addNyushoInfoTablecolumn6();
    }
    return nyushoInfoTablecolumn6;

  }

  /**
   * 公費1日数を取得します。
   * @return 公費1日数
   */
  public ACTableColumn getNyushoInfoTablecolumn7(){
    if(nyushoInfoTablecolumn7==null){

      nyushoInfoTablecolumn7 = new ACTableColumn(6, 80);

      nyushoInfoTablecolumn7.setHeaderValue("公費1日数");

      addNyushoInfoTablecolumn7();
    }
    return nyushoInfoTablecolumn7;

  }

  /**
   * 公費2日数を取得します。
   * @return 公費2日数
   */
  public ACTableColumn getNyushoInfoTablecolumn8(){
    if(nyushoInfoTablecolumn8==null){

      nyushoInfoTablecolumn8 = new ACTableColumn(7, 80);

      nyushoInfoTablecolumn8.setHeaderValue("公費2日数");

      addNyushoInfoTablecolumn8();
    }
    return nyushoInfoTablecolumn8;

  }

  /**
   * 公費3日数を取得します。
   * @return 公費3日数
   */
  public ACTableColumn getNyushoInfoTablecolumn9(){
    if(nyushoInfoTablecolumn9==null){

      nyushoInfoTablecolumn9 = new ACTableColumn(8, 80);

      nyushoInfoTablecolumn9.setHeaderValue("公費3日数");

      addNyushoInfoTablecolumn9();
    }
    return nyushoInfoTablecolumn9;

  }

  /**
   * 費用額を取得します。
   * @return 費用額
   */
  public ACTableColumn getNyushoInfoTablecolumn10(){
    if(nyushoInfoTablecolumn10==null){

      nyushoInfoTablecolumn10 = new ACTableColumn(9, 50);

      nyushoInfoTablecolumn10.setHeaderValue("費用額");

      addNyushoInfoTablecolumn10();
    }
    return nyushoInfoTablecolumn10;

  }

  /**
   * 保険分請求額を取得します。
   * @return 保険分請求額
   */
  public ACTableColumn getNyushoInfoTablecolumn11(){
    if(nyushoInfoTablecolumn11==null){

      nyushoInfoTablecolumn11 = new ACTableColumn(10, 100);

      nyushoInfoTablecolumn11.setHeaderValue("保険分請求額");

      addNyushoInfoTablecolumn11();
    }
    return nyushoInfoTablecolumn11;

  }

  /**
   * 公費1負担額を取得します。
   * @return 公費1負担額
   */
  public ACTableColumn getNyushoInfoTablecolumn12(){
    if(nyushoInfoTablecolumn12==null){

      nyushoInfoTablecolumn12 = new ACTableColumn(11, 80);

      nyushoInfoTablecolumn12.setHeaderValue("公費1負担額");

      addNyushoInfoTablecolumn12();
    }
    return nyushoInfoTablecolumn12;

  }

  /**
   * 公費2負担額を取得します。
   * @return 公費2負担額
   */
  public ACTableColumn getNyushoInfoTablecolumn13(){
    if(nyushoInfoTablecolumn13==null){

      nyushoInfoTablecolumn13 = new ACTableColumn(12, 80);

      nyushoInfoTablecolumn13.setHeaderValue("公費2負担額");

      addNyushoInfoTablecolumn13();
    }
    return nyushoInfoTablecolumn13;

  }

  /**
   * 公費3負担額を取得します。
   * @return 公費3負担額
   */
  public ACTableColumn getNyushoInfoTablecolumn14(){
    if(nyushoInfoTablecolumn14==null){

      nyushoInfoTablecolumn14 = new ACTableColumn(13, 80);

      nyushoInfoTablecolumn14.setHeaderValue("公費3負担額");

      addNyushoInfoTablecolumn14();
    }
    return nyushoInfoTablecolumn14;

  }

  /**
   * 利用者負担額を取得します。
   * @return 利用者負担額
   */
  public ACTableColumn getNyushoInfoTablecolumn15(){
    if(nyushoInfoTablecolumn15==null){

      nyushoInfoTablecolumn15 = new ACTableColumn(14, 100);

      nyushoInfoTablecolumn15.setHeaderValue("利用者負担額");

      addNyushoInfoTablecolumn15();
    }
    return nyushoInfoTablecolumn15;

  }

  /**
   * 費用額合計を取得します。
   * @return 費用額合計
   */
  public ACTableColumn getNyushoInfoTablecolumn16(){
    if(nyushoInfoTablecolumn16==null){

      nyushoInfoTablecolumn16 = new ACTableColumn(15, 80);

      nyushoInfoTablecolumn16.setHeaderValue("費用額合計");

      addNyushoInfoTablecolumn16();
    }
    return nyushoInfoTablecolumn16;

  }

  /**
   * 保険分請求額合計を取得します。
   * @return 保険分請求額合計
   */
  public ACTableColumn getNyushoInfoTablecolumn17(){
    if(nyushoInfoTablecolumn17==null){

      nyushoInfoTablecolumn17 = new ACTableColumn(16, 140);

      nyushoInfoTablecolumn17.setHeaderValue("保険分請求額合計");

      addNyushoInfoTablecolumn17();
    }
    return nyushoInfoTablecolumn17;

  }

  /**
   * 利用者負担額合計を取得します。
   * @return 利用者負担額合計
   */
  public ACTableColumn getNyushoInfoTablecolumn18(){
    if(nyushoInfoTablecolumn18==null){

      nyushoInfoTablecolumn18 = new ACTableColumn(17, 140);

      nyushoInfoTablecolumn18.setHeaderValue("利用者負担額合計");

      addNyushoInfoTablecolumn18();
    }
    return nyushoInfoTablecolumn18;

  }

  /**
   * 公費1負担額合計を取得します。
   * @return 公費1負担額合計
   */
  public ACTableColumn getNyushoInfoTablecolumn19(){
    if(nyushoInfoTablecolumn19==null){

      nyushoInfoTablecolumn19 = new ACTableColumn(18, 120);

      nyushoInfoTablecolumn19.setHeaderValue("公費1負担額合計");

      addNyushoInfoTablecolumn19();
    }
    return nyushoInfoTablecolumn19;

  }

  /**
   * 公費1請求額を取得します。
   * @return 公費1請求額
   */
  public ACTableColumn getNyushoInfoTablecolumn20(){
    if(nyushoInfoTablecolumn20==null){

      nyushoInfoTablecolumn20 = new ACTableColumn(19, 100);

      nyushoInfoTablecolumn20.setHeaderValue("公費1請求額");

      addNyushoInfoTablecolumn20();
    }
    return nyushoInfoTablecolumn20;

  }

  /**
   * 公費1本人負担月額を取得します。
   * @return 公費1本人負担月額
   */
  public ACTableColumn getNyushoInfoTablecolumn21(){
    if(nyushoInfoTablecolumn21==null){

      nyushoInfoTablecolumn21 = new ACTableColumn(20, 150);

      nyushoInfoTablecolumn21.setHeaderValue("公費1本人負担月額");

      addNyushoInfoTablecolumn21();
    }
    return nyushoInfoTablecolumn21;

  }

  /**
   * 公費2負担額合計を取得します。
   * @return 公費2負担額合計
   */
  public ACTableColumn getNyushoInfoTablecolumn22(){
    if(nyushoInfoTablecolumn22==null){

      nyushoInfoTablecolumn22 = new ACTableColumn(21, 140);

      nyushoInfoTablecolumn22.setHeaderValue("公費2負担額合計");

      addNyushoInfoTablecolumn22();
    }
    return nyushoInfoTablecolumn22;

  }

  /**
   * 公費2請求額を取得します。
   * @return 公費2請求額
   */
  public ACTableColumn getNyushoInfoTablecolumn23(){
    if(nyushoInfoTablecolumn23==null){

      nyushoInfoTablecolumn23 = new ACTableColumn(22, 100);

      nyushoInfoTablecolumn23.setHeaderValue("公費2請求額");

      addNyushoInfoTablecolumn23();
    }
    return nyushoInfoTablecolumn23;

  }

  /**
   * 公費2本人負担月額を取得します。
   * @return 公費2本人負担月額
   */
  public ACTableColumn getNyushoInfoTablecolumn24(){
    if(nyushoInfoTablecolumn24==null){

      nyushoInfoTablecolumn24 = new ACTableColumn(23, 150);

      nyushoInfoTablecolumn24.setHeaderValue("公費2本人負担月額");

      addNyushoInfoTablecolumn24();
    }
    return nyushoInfoTablecolumn24;

  }

  /**
   * 公費3負担額合計を取得します。
   * @return 公費3負担額合計
   */
  public ACTableColumn getNyushoInfoTablecolumn25(){
    if(nyushoInfoTablecolumn25==null){

      nyushoInfoTablecolumn25 = new ACTableColumn(24, 140);

      nyushoInfoTablecolumn25.setHeaderValue("公費3負担額合計");

      addNyushoInfoTablecolumn25();
    }
    return nyushoInfoTablecolumn25;

  }

  /**
   * 公費3請求額を取得します。
   * @return 公費3請求額
   */
  public ACTableColumn getNyushoInfoTablecolumn26(){
    if(nyushoInfoTablecolumn26==null){

      nyushoInfoTablecolumn26 = new ACTableColumn(25, 100);

      nyushoInfoTablecolumn26.setHeaderValue("公費3請求額");

      addNyushoInfoTablecolumn26();
    }
    return nyushoInfoTablecolumn26;

  }

  /**
   * 公費3本人負担月額を取得します。
   * @return 公費3本人負担月額
   */
  public ACTableColumn getNyushoInfoTablecolumn27(){
    if(nyushoInfoTablecolumn27==null){

      nyushoInfoTablecolumn27 = new ACTableColumn(26, 150);

      nyushoInfoTablecolumn27.setHeaderValue("公費3本人負担月額");

      addNyushoInfoTablecolumn27();
    }
    return nyushoInfoTablecolumn27;

  }

  /**
   * 特定入所者介護費設定内容修正パネルを取得します。
   * @return 特定入所者介護費設定内容修正パネル
   */
  public ACPanel getNyushoInfoRevisionPanel(){
    if(nyushoInfoRevisionPanel==null){

      nyushoInfoRevisionPanel = new ACPanel();

      addNyushoInfoRevisionPanel();
    }
    return nyushoInfoRevisionPanel;

  }

  /**
   * 特定入所者介護費設定内容修正欄ラベルを取得します。
   * @return 特定入所者介護費設定内容修正欄ラベル
   */
  public ACLabel getNyushoInfoRevisionLabel(){
    if(nyushoInfoRevisionLabel==null){

      nyushoInfoRevisionLabel = new ACLabel();

      nyushoInfoRevisionLabel.setText("設定内容修正欄");

      addNyushoInfoRevisionLabel();
    }
    return nyushoInfoRevisionLabel;

  }

  /**
   * 特定入所者介護費情報を取得します。
   * @return 特定入所者介護費情報
   */
  public ACLabel getNyushoInfoRevision(){
    if(nyushoInfoRevision==null){

      nyushoInfoRevision = new ACLabel();

      nyushoInfoRevision.setText("特定入所者介護費情報");

      addNyushoInfoRevision();
    }
    return nyushoInfoRevision;

  }

  /**
   * 全ての情報を表示を取得します。
   * @return 全ての情報を表示
   */
  public ACIntegerCheckBox getNyushoInfoRevisionCheck(){
    if(nyushoInfoRevisionCheck==null){

      nyushoInfoRevisionCheck = new ACIntegerCheckBox();

      nyushoInfoRevisionCheck.setText("すべての情報を表示（A）");

      nyushoInfoRevisionCheck.setMnemonic('A');

      addNyushoInfoRevisionCheck();
    }
    return nyushoInfoRevisionCheck;

  }

  /**
   * 特定入所者介護費情報詳細テーブルを取得します。
   * @return 特定入所者介護費情報詳細テーブル
   */
  public ACTable getNyushoInfoRevisionTable(){
    if(nyushoInfoRevisionTable==null){

      nyushoInfoRevisionTable = new ACTable();

      nyushoInfoRevisionTable.setColumnModel(getNyushoInfoRevisionTableColumnModel());

      nyushoInfoRevisionTable.setColumnSort(false);

      addNyushoInfoRevisionTable();
    }
    return nyushoInfoRevisionTable;

  }

  /**
   * 特定入所者介護費情報詳細テーブルカラムモデルを取得します。
   * @return 特定入所者介護費情報詳細テーブルカラムモデル
   */
  protected VRTableColumnModel getNyushoInfoRevisionTableColumnModel(){
    if(nyushoInfoRevisionTableColumnModel==null){
      nyushoInfoRevisionTableColumnModel = new VRTableColumnModel(new TableColumn[]{});
      addNyushoInfoRevisionTableColumnModel();
    }
    return nyushoInfoRevisionTableColumnModel;
  }

  /**
   * No.を取得します。
   * @return No.
   */
  public ACTableColumn getNyushoInfoRevisionTablecolumn0(){
    if(nyushoInfoRevisionTablecolumn0==null){

      nyushoInfoRevisionTablecolumn0 = new ACTableColumn(0, 30);

      nyushoInfoRevisionTablecolumn0.setHeaderValue("　");

      nyushoInfoRevisionTablecolumn0.setRendererType(ACTableCellViewer.RENDERER_TYPE_SERIAL_NO);

      nyushoInfoRevisionTablecolumn0.setSortable(false);

      addNyushoInfoRevisionTablecolumn0();
    }
    return nyushoInfoRevisionTablecolumn0;

  }

  /**
   * 項目名を取得します。
   * @return 項目名
   */
  public ACTableColumn getNyushoInfoRevisionTablecolumn1(){
    if(nyushoInfoRevisionTablecolumn1==null){

      nyushoInfoRevisionTablecolumn1 = new ACTableColumn(0, 55);

      nyushoInfoRevisionTablecolumn1.setHeaderValue("項目名");

      nyushoInfoRevisionTablecolumn1.setColumns(15);

      addNyushoInfoRevisionTablecolumn1();
    }
    return nyushoInfoRevisionTablecolumn1;

  }

  /**
   * 設定値を取得します。
   * @return 設定値
   */
  public ACTableColumn getNyushoInfoRevisionTablecolumn2(){
    if(nyushoInfoRevisionTablecolumn2==null){

      nyushoInfoRevisionTablecolumn2 = new ACTableColumn(1, 55);

      nyushoInfoRevisionTablecolumn2.setHeaderValue("設定値");

      nyushoInfoRevisionTablecolumn2.setEditable(true);

      nyushoInfoRevisionTablecolumn2.setColumns(8);

      addNyushoInfoRevisionTablecolumn2();
    }
    return nyushoInfoRevisionTablecolumn2;

  }

  /**
   * コメントを取得します。
   * @return コメント
   */
  public ACTableColumn getNyushoInfoRevisionTablecolumn3(){
    if(nyushoInfoRevisionTablecolumn3==null){

      nyushoInfoRevisionTablecolumn3 = new ACTableColumn(2, 55);

      nyushoInfoRevisionTablecolumn3.setHeaderValue("コメント");

      nyushoInfoRevisionTablecolumn3.setColumns(30);

      addNyushoInfoRevisionTablecolumn3();
    }
    return nyushoInfoRevisionTablecolumn3;

  }

  /**
   * 社会福祉法人軽減額情報領域を取得します。
   * @return 社会福祉法人軽減額情報領域
   */
  public ACPanel getShahukuInfos(){
    if(shahukuInfos==null){

      shahukuInfos = new ACPanel();

      addShahukuInfos();
    }
    return shahukuInfos;

  }

  /**
   * 社会福祉法人軽減額情報パネルを取得します。
   * @return 社会福祉法人軽減額情報パネル
   */
  public ACPanel getShahukuInfoPanel(){
    if(shahukuInfoPanel==null){

      shahukuInfoPanel = new ACPanel();

      addShahukuInfoPanel();
    }
    return shahukuInfoPanel;

  }

  /**
   * 社会福祉法人軽減額情報ラベルを取得します。
   * @return 社会福祉法人軽減額情報ラベル
   */
  public ACLabel getShahukuInfoLabel(){
    if(shahukuInfoLabel==null){

      shahukuInfoLabel = new ACLabel();

      shahukuInfoLabel.setText("社会福祉法人軽減情報");

      addShahukuInfoLabel();
    }
    return shahukuInfoLabel;

  }

  /**
   * 社会福祉法人軽減額情報テーブルを取得します。
   * @return 社会福祉法人軽減額情報テーブル
   */
  public ACTable getShahukuInfoTable(){
    if(shahukuInfoTable==null){

      shahukuInfoTable = new ACTable();

      shahukuInfoTable.setColumnModel(getShahukuInfoTableColumnModel());

      shahukuInfoTable.setColumnSort(false);

      addShahukuInfoTable();
    }
    return shahukuInfoTable;

  }

  /**
   * 社会福祉法人軽減額情報テーブルカラムモデルを取得します。
   * @return 社会福祉法人軽減額情報テーブルカラムモデル
   */
  protected VRTableColumnModel getShahukuInfoTableColumnModel(){
    if(shahukuInfoTableColumnModel==null){
      shahukuInfoTableColumnModel = new VRTableColumnModel(new TableColumn[]{});
      addShahukuInfoTableColumnModel();
    }
    return shahukuInfoTableColumnModel;
  }

  /**
   * No.を取得します。
   * @return No.
   */
  public ACTableColumn getShahukuInfoTablecolumn0(){
    if(shahukuInfoTablecolumn0==null){

      shahukuInfoTablecolumn0 = new ACTableColumn(0, 30);

      shahukuInfoTablecolumn0.setHeaderValue("　");

      shahukuInfoTablecolumn0.setRendererType(ACTableCellViewer.RENDERER_TYPE_SERIAL_NO);

      shahukuInfoTablecolumn0.setSortable(false);

      addShahukuInfoTablecolumn0();
    }
    return shahukuInfoTablecolumn0;

  }

  /**
   * 軽減率を取得します。
   * @return 軽減率
   */
  public ACTableColumn getShahukuInfoTablecolumn1(){
    if(shahukuInfoTablecolumn1==null){

      shahukuInfoTablecolumn1 = new ACTableColumn(0, 50);

      shahukuInfoTablecolumn1.setHeaderValue("軽減率");

      addShahukuInfoTablecolumn1();
    }
    return shahukuInfoTablecolumn1;

  }

  /**
   * サービス種類コードを取得します。
   * @return サービス種類コード
   */
  public ACTableColumn getShahukuInfoTablecolumn2(){
    if(shahukuInfoTablecolumn2==null){

      shahukuInfoTablecolumn2 = new ACTableColumn(1, 120);

      shahukuInfoTablecolumn2.setHeaderValue("サービス種類コード");

      addShahukuInfoTablecolumn2();
    }
    return shahukuInfoTablecolumn2;

  }

  /**
   * 受領すべき利用者負担の総額を取得します。
   * @return 受領すべき利用者負担の総額
   */
  public ACTableColumn getShahukuInfoTablecolumn3(){
    if(shahukuInfoTablecolumn3==null){

      shahukuInfoTablecolumn3 = new ACTableColumn(2, 180);

      shahukuInfoTablecolumn3.setHeaderValue("受領すべき利用者負担の総額");

      addShahukuInfoTablecolumn3();
    }
    return shahukuInfoTablecolumn3;

  }

  /**
   * 軽減額を取得します。
   * @return 軽減額
   */
  public ACTableColumn getShahukuInfoTablecolumn4(){
    if(shahukuInfoTablecolumn4==null){

      shahukuInfoTablecolumn4 = new ACTableColumn(3, 50);

      shahukuInfoTablecolumn4.setHeaderValue("軽減額");

      addShahukuInfoTablecolumn4();
    }
    return shahukuInfoTablecolumn4;

  }

  /**
   * 軽減後利用者負担額を取得します。
   * @return 軽減後利用者負担額
   */
  public ACTableColumn getShahukuInfoTablecolumn5(){
    if(shahukuInfoTablecolumn5==null){

      shahukuInfoTablecolumn5 = new ACTableColumn(4, 150);

      shahukuInfoTablecolumn5.setHeaderValue("軽減後利用者負担額");

      addShahukuInfoTablecolumn5();
    }
    return shahukuInfoTablecolumn5;

  }

  /**
   * 備考を取得します。
   * @return 備考
   */
  public ACTableColumn getShahukuInfoTablecolumn6(){
    if(shahukuInfoTablecolumn6==null){

      shahukuInfoTablecolumn6 = new ACTableColumn(5, 180);

      shahukuInfoTablecolumn6.setHeaderValue("備考");

      addShahukuInfoTablecolumn6();
    }
    return shahukuInfoTablecolumn6;

  }

  /**
   * 社会福祉法人軽減額設定内容修正パネルを取得します。
   * @return 社会福祉法人軽減額設定内容修正パネル
   */
  public ACPanel getShahukuInfoRevisionPanel(){
    if(shahukuInfoRevisionPanel==null){

      shahukuInfoRevisionPanel = new ACPanel();

      addShahukuInfoRevisionPanel();
    }
    return shahukuInfoRevisionPanel;

  }

  /**
   * 社会福祉法人軽減額設定内容修正欄ラベルを取得します。
   * @return 社会福祉法人軽減額設定内容修正欄ラベル
   */
  public ACLabel getShahukuInfoRevisionLabel(){
    if(shahukuInfoRevisionLabel==null){

      shahukuInfoRevisionLabel = new ACLabel();

      shahukuInfoRevisionLabel.setText("設定内容修正欄");

      addShahukuInfoRevisionLabel();
    }
    return shahukuInfoRevisionLabel;

  }

  /**
   * 社会福祉法人軽減額情報を取得します。
   * @return 社会福祉法人軽減額情報
   */
  public ACLabel getShahukuInfoRevision(){
    if(shahukuInfoRevision==null){

      shahukuInfoRevision = new ACLabel();

      shahukuInfoRevision.setText("社会福祉法人軽減情報");

      addShahukuInfoRevision();
    }
    return shahukuInfoRevision;

  }

  /**
   * 全ての情報を表示を取得します。
   * @return 全ての情報を表示
   */
  public ACIntegerCheckBox getShahukuInfoRevisionCheck(){
    if(shahukuInfoRevisionCheck==null){

      shahukuInfoRevisionCheck = new ACIntegerCheckBox();

      shahukuInfoRevisionCheck.setText("すべての情報を表示（A）");

      shahukuInfoRevisionCheck.setMnemonic('A');

      addShahukuInfoRevisionCheck();
    }
    return shahukuInfoRevisionCheck;

  }

  /**
   * 社会福祉法人軽減額情報詳細テーブルを取得します。
   * @return 社会福祉法人軽減額情報詳細テーブル
   */
  public ACTable getShahukuInfoRevisionTable(){
    if(shahukuInfoRevisionTable==null){

      shahukuInfoRevisionTable = new ACTable();

      shahukuInfoRevisionTable.setColumnModel(getShahukuInfoRevisionTableColumnModel());

      shahukuInfoRevisionTable.setColumnSort(false);

      addShahukuInfoRevisionTable();
    }
    return shahukuInfoRevisionTable;

  }

  /**
   * 社会福祉法人軽減額情報詳細テーブルカラムモデルを取得します。
   * @return 社会福祉法人軽減額情報詳細テーブルカラムモデル
   */
  protected VRTableColumnModel getShahukuInfoRevisionTableColumnModel(){
    if(shahukuInfoRevisionTableColumnModel==null){
      shahukuInfoRevisionTableColumnModel = new VRTableColumnModel(new TableColumn[]{});
      addShahukuInfoRevisionTableColumnModel();
    }
    return shahukuInfoRevisionTableColumnModel;
  }

  /**
   * No.を取得します。
   * @return No.
   */
  public ACTableColumn getShahukuInfoRevisionTablecolumn0(){
    if(shahukuInfoRevisionTablecolumn0==null){

      shahukuInfoRevisionTablecolumn0 = new ACTableColumn(0, 30);

      shahukuInfoRevisionTablecolumn0.setHeaderValue("　");

      shahukuInfoRevisionTablecolumn0.setRendererType(ACTableCellViewer.RENDERER_TYPE_SERIAL_NO);

      shahukuInfoRevisionTablecolumn0.setSortable(false);

      addShahukuInfoRevisionTablecolumn0();
    }
    return shahukuInfoRevisionTablecolumn0;

  }

  /**
   * 項目名を取得します。
   * @return 項目名
   */
  public ACTableColumn getShahukuInfoRevisionTablecolumn1(){
    if(shahukuInfoRevisionTablecolumn1==null){

      shahukuInfoRevisionTablecolumn1 = new ACTableColumn(0, 55);

      shahukuInfoRevisionTablecolumn1.setHeaderValue("項目名");

      shahukuInfoRevisionTablecolumn1.setColumns(15);

      addShahukuInfoRevisionTablecolumn1();
    }
    return shahukuInfoRevisionTablecolumn1;

  }

  /**
   * 設定値を取得します。
   * @return 設定値
   */
  public ACTableColumn getShahukuInfoRevisionTablecolumn2(){
    if(shahukuInfoRevisionTablecolumn2==null){

      shahukuInfoRevisionTablecolumn2 = new ACTableColumn(1, 55);

      shahukuInfoRevisionTablecolumn2.setHeaderValue("設定値");

      shahukuInfoRevisionTablecolumn2.setEditable(true);

      shahukuInfoRevisionTablecolumn2.setColumns(8);

      addShahukuInfoRevisionTablecolumn2();
    }
    return shahukuInfoRevisionTablecolumn2;

  }

  /**
   * コメントを取得します。
   * @return コメント
   */
  public ACTableColumn getShahukuInfoRevisionTablecolumn3(){
    if(shahukuInfoRevisionTablecolumn3==null){

      shahukuInfoRevisionTablecolumn3 = new ACTableColumn(2, 55);

      shahukuInfoRevisionTablecolumn3.setHeaderValue("コメント");

      shahukuInfoRevisionTablecolumn3.setColumns(30);

      addShahukuInfoRevisionTablecolumn3();
    }
    return shahukuInfoRevisionTablecolumn3;

  }

  /**
   * 特定療養費情報領域を取得します。
   * @return 特定療養費情報領域
   */
  public ACPanel getRecuperationInfos(){
    if(recuperationInfos==null){

      recuperationInfos = new ACPanel();

      addRecuperationInfos();
    }
    return recuperationInfos;

  }

  /**
   * 特定療養費情報パネルを取得します。
   * @return 特定療養費情報パネル
   */
  public ACPanel getRecuperationInfoPanel(){
    if(recuperationInfoPanel==null){

      recuperationInfoPanel = new ACPanel();

      addRecuperationInfoPanel();
    }
    return recuperationInfoPanel;

  }

  /**
   * 特定療養費情報ラベルを取得します。
   * @return 特定療養費情報ラベル
   */
  public ACLabel getRecuperationInfoLabel(){
    if(recuperationInfoLabel==null){

      recuperationInfoLabel = new ACLabel();

      recuperationInfoLabel.setText("特別療養費情報");

      addRecuperationInfoLabel();
    }
    return recuperationInfoLabel;

  }

  /**
   * 特定療養費情報テーブルを取得します。
   * @return 特定療養費情報テーブル
   */
  public ACTable getRecuperationInfoTable(){
    if(recuperationInfoTable==null){

      recuperationInfoTable = new ACTable();

      recuperationInfoTable.setColumnModel(getRecuperationInfoTableColumnModel());

      recuperationInfoTable.setColumnSort(false);

      addRecuperationInfoTable();
    }
    return recuperationInfoTable;

  }

  /**
   * 特定療養費情報テーブルカラムモデルを取得します。
   * @return 特定療養費情報テーブルカラムモデル
   */
  protected VRTableColumnModel getRecuperationInfoTableColumnModel(){
    if(recuperationInfoTableColumnModel==null){
      recuperationInfoTableColumnModel = new VRTableColumnModel(new TableColumn[]{});
      addRecuperationInfoTableColumnModel();
    }
    return recuperationInfoTableColumnModel;
  }

  /**
   * No.を取得します。
   * @return No.
   */
  public ACTableColumn getRecuperationInfoTablecolumn0(){
    if(recuperationInfoTablecolumn0==null){

      recuperationInfoTablecolumn0 = new ACTableColumn(0, 30);

      recuperationInfoTablecolumn0.setHeaderValue("　");

      recuperationInfoTablecolumn0.setRendererType(ACTableCellViewer.RENDERER_TYPE_SERIAL_NO);

      recuperationInfoTablecolumn0.setSortable(false);

      addRecuperationInfoTablecolumn0();
    }
    return recuperationInfoTablecolumn0;

  }

  /**
   * 事業所番号を取得します。
   * @return 事業所番号
   */
  public ACTableColumn getRecuperationInfoTablecolumn1(){
    if(recuperationInfoTablecolumn1==null){

      recuperationInfoTablecolumn1 = new ACTableColumn(0, 75);

      recuperationInfoTablecolumn1.setHeaderValue("事業所番号");

      addRecuperationInfoTablecolumn1();
    }
    return recuperationInfoTablecolumn1;

  }

  /**
   * レコード順次番号を取得します。
   * @return レコード順次番号
   */
  public ACTableColumn getRecuperationInfoTablecolumn2(){
    if(recuperationInfoTablecolumn2==null){

      recuperationInfoTablecolumn2 = new ACTableColumn(1, 100);

      recuperationInfoTablecolumn2.setHeaderValue("レコード順次番号");

      addRecuperationInfoTablecolumn2();
    }
    return recuperationInfoTablecolumn2;

  }

  /**
   * 傷病名を取得します。
   * @return 傷病名
   */
  public ACTableColumn getRecuperationInfoTablecolumn3(){
    if(recuperationInfoTablecolumn3==null){

      recuperationInfoTablecolumn3 = new ACTableColumn(2, 100);

      recuperationInfoTablecolumn3.setHeaderValue("傷病名");

      addRecuperationInfoTablecolumn3();
    }
    return recuperationInfoTablecolumn3;

  }

  /**
   * 識別番号を取得します。
   * @return 識別番号
   */
  public ACTableColumn getRecuperationInfoTablecolumn4(){
    if(recuperationInfoTablecolumn4==null){

      recuperationInfoTablecolumn4 = new ACTableColumn(3, 100);

      recuperationInfoTablecolumn4.setHeaderValue("識別番号");

      addRecuperationInfoTablecolumn4();
    }
    return recuperationInfoTablecolumn4;

  }

  /**
   * 単位数を取得します。
   * @return 単位数
   */
  public ACTableColumn getRecuperationInfoTablecolumn5(){
    if(recuperationInfoTablecolumn5==null){

      recuperationInfoTablecolumn5 = new ACTableColumn(4, 150);

      recuperationInfoTablecolumn5.setHeaderValue("単位数");

      addRecuperationInfoTablecolumn5();
    }
    return recuperationInfoTablecolumn5;

  }

  /**
   * 保険回数を取得します。
   * @return 保険回数
   */
  public ACTableColumn getRecuperationInfoTablecolumn6(){
    if(recuperationInfoTablecolumn6==null){

      recuperationInfoTablecolumn6 = new ACTableColumn(5, 150);

      recuperationInfoTablecolumn6.setHeaderValue("保険回数");

      addRecuperationInfoTablecolumn6();
    }
    return recuperationInfoTablecolumn6;

  }

  /**
   * 保険サービス単位数を取得します。
   * @return 保険サービス単位数
   */
  public ACTableColumn getRecuperationInfoTablecolumn7(){
    if(recuperationInfoTablecolumn7==null){

      recuperationInfoTablecolumn7 = new ACTableColumn(6, 150);

      recuperationInfoTablecolumn7.setHeaderValue("保険サービス単位数");

      addRecuperationInfoTablecolumn7();
    }
    return recuperationInfoTablecolumn7;

  }

  /**
   * 保険合計単位数を取得します。
   * @return 保険合計単位数
   */
  public ACTableColumn getRecuperationInfoTablecolumn8(){
    if(recuperationInfoTablecolumn8==null){

      recuperationInfoTablecolumn8 = new ACTableColumn(7, 70);

      recuperationInfoTablecolumn8.setHeaderValue("保険合計単位数");

      addRecuperationInfoTablecolumn8();
    }
    return recuperationInfoTablecolumn8;

  }

  /**
   * 公費1回数を取得します。
   * @return 公費1回数
   */
  public ACTableColumn getRecuperationInfoTablecolumn9(){
    if(recuperationInfoTablecolumn9==null){

      recuperationInfoTablecolumn9 = new ACTableColumn(8, 105);

      recuperationInfoTablecolumn9.setHeaderValue("公費1回数");

      addRecuperationInfoTablecolumn9();
    }
    return recuperationInfoTablecolumn9;

  }

  /**
   * 公費2回数を取得します。
   * @return 公費2回数
   */
  public ACTableColumn getRecuperationInfoTablecolumn10(){
    if(recuperationInfoTablecolumn10==null){

      recuperationInfoTablecolumn10 = new ACTableColumn(9, 70);

      recuperationInfoTablecolumn10.setHeaderValue("公費2回数");

      addRecuperationInfoTablecolumn10();
    }
    return recuperationInfoTablecolumn10;

  }

  /**
   * 公費3回数を取得します。
   * @return 公費3回数
   */
  public ACTableColumn getRecuperationInfoTablecolumn11(){
    if(recuperationInfoTablecolumn11==null){

      recuperationInfoTablecolumn11 = new ACTableColumn(10, 105);

      recuperationInfoTablecolumn11.setHeaderValue("公費3回数");

      addRecuperationInfoTablecolumn11();
    }
    return recuperationInfoTablecolumn11;

  }

  /**
   * 摘要を取得します。
   * @return 摘要
   */
  public ACTableColumn getRecuperationInfoTablecolumn12(){
    if(recuperationInfoTablecolumn12==null){

      recuperationInfoTablecolumn12 = new ACTableColumn(11, 140);

      recuperationInfoTablecolumn12.setHeaderValue("摘要");

      addRecuperationInfoTablecolumn12();
    }
    return recuperationInfoTablecolumn12;

  }

  /**
   * 特定療養費情報設定内容修正パネルを取得します。
   * @return 特定療養費情報設定内容修正パネル
   */
  public ACPanel getRecuperationInfoRevisionPanel(){
    if(recuperationInfoRevisionPanel==null){

      recuperationInfoRevisionPanel = new ACPanel();

      addRecuperationInfoRevisionPanel();
    }
    return recuperationInfoRevisionPanel;

  }

  /**
   * 特定療養費情報設定内容修正欄ラベルを取得します。
   * @return 特定療養費情報設定内容修正欄ラベル
   */
  public ACLabel getRecuperationInfoRevisionLabel(){
    if(recuperationInfoRevisionLabel==null){

      recuperationInfoRevisionLabel = new ACLabel();

      recuperationInfoRevisionLabel.setText("設定内容修正欄");

      addRecuperationInfoRevisionLabel();
    }
    return recuperationInfoRevisionLabel;

  }

  /**
   * 特定療養費情報情報を取得します。
   * @return 特定療養費情報情報
   */
  public ACLabel getRecuperationInfoRevision(){
    if(recuperationInfoRevision==null){

      recuperationInfoRevision = new ACLabel();

      recuperationInfoRevision.setText("特別療養費情報");

      addRecuperationInfoRevision();
    }
    return recuperationInfoRevision;

  }

  /**
   * 全ての情報を表示を取得します。
   * @return 全ての情報を表示
   */
  public ACIntegerCheckBox getRecuperationInfoRevisionCheck(){
    if(recuperationInfoRevisionCheck==null){

      recuperationInfoRevisionCheck = new ACIntegerCheckBox();

      recuperationInfoRevisionCheck.setText("すべての情報を表示（A）");

      recuperationInfoRevisionCheck.setMnemonic('A');

      addRecuperationInfoRevisionCheck();
    }
    return recuperationInfoRevisionCheck;

  }

  /**
   * 特定療養費情報情報詳細テーブルを取得します。
   * @return 特定療養費情報情報詳細テーブル
   */
  public ACTable getRecuperationInfoRevisionTable(){
    if(recuperationInfoRevisionTable==null){

      recuperationInfoRevisionTable = new ACTable();

      recuperationInfoRevisionTable.setColumnModel(getRecuperationInfoRevisionTableColumnModel());

      recuperationInfoRevisionTable.setColumnSort(false);

      addRecuperationInfoRevisionTable();
    }
    return recuperationInfoRevisionTable;

  }

  /**
   * 特定療養費情報情報詳細テーブルカラムモデルを取得します。
   * @return 特定療養費情報情報詳細テーブルカラムモデル
   */
  protected VRTableColumnModel getRecuperationInfoRevisionTableColumnModel(){
    if(recuperationInfoRevisionTableColumnModel==null){
      recuperationInfoRevisionTableColumnModel = new VRTableColumnModel(new TableColumn[]{});
      addRecuperationInfoRevisionTableColumnModel();
    }
    return recuperationInfoRevisionTableColumnModel;
  }

  /**
   * No.を取得します。
   * @return No.
   */
  public ACTableColumn getRecuperationInfoRevisionTablecolumn0(){
    if(recuperationInfoRevisionTablecolumn0==null){

      recuperationInfoRevisionTablecolumn0 = new ACTableColumn(0, 30);

      recuperationInfoRevisionTablecolumn0.setHeaderValue("　");

      recuperationInfoRevisionTablecolumn0.setRendererType(ACTableCellViewer.RENDERER_TYPE_SERIAL_NO);

      recuperationInfoRevisionTablecolumn0.setSortable(false);

      addRecuperationInfoRevisionTablecolumn0();
    }
    return recuperationInfoRevisionTablecolumn0;

  }

  /**
   * 項目名を取得します。
   * @return 項目名
   */
  public ACTableColumn getRecuperationInfoRevisionTablecolumn1(){
    if(recuperationInfoRevisionTablecolumn1==null){

      recuperationInfoRevisionTablecolumn1 = new ACTableColumn(0, 55);

      recuperationInfoRevisionTablecolumn1.setHeaderValue("項目名");

      recuperationInfoRevisionTablecolumn1.setColumns(15);

      addRecuperationInfoRevisionTablecolumn1();
    }
    return recuperationInfoRevisionTablecolumn1;

  }

  /**
   * 設定値を取得します。
   * @return 設定値
   */
  public ACTableColumn getRecuperationInfoRevisionTablecolumn2(){
    if(recuperationInfoRevisionTablecolumn2==null){

      recuperationInfoRevisionTablecolumn2 = new ACTableColumn(1, 55);

      recuperationInfoRevisionTablecolumn2.setHeaderValue("設定値");

      recuperationInfoRevisionTablecolumn2.setEditable(true);

      recuperationInfoRevisionTablecolumn2.setColumns(8);

      addRecuperationInfoRevisionTablecolumn2();
    }
    return recuperationInfoRevisionTablecolumn2;

  }

  /**
   * コメントを取得します。
   * @return コメント
   */
  public ACTableColumn getRecuperationInfoRevisionTablecolumn3(){
    if(recuperationInfoRevisionTablecolumn3==null){

      recuperationInfoRevisionTablecolumn3 = new ACTableColumn(2, 55);

      recuperationInfoRevisionTablecolumn3.setHeaderValue("コメント");

      recuperationInfoRevisionTablecolumn3.setColumns(30);

      addRecuperationInfoRevisionTablecolumn3();
    }
    return recuperationInfoRevisionTablecolumn3;

  }

  /**
   * 明細情報（住所地特例）領域を取得します。
   * @return 明細情報（住所地特例）領域
   */
  public ACPanel getDetailsJushotiTokureiInfos(){
    if(detailsJushotiTokureiInfos==null){

      detailsJushotiTokureiInfos = new ACPanel();

      addDetailsJushotiTokureiInfos();
    }
    return detailsJushotiTokureiInfos;

  }

  /**
   * 明細情報（住所地特例）パネルを取得します。
   * @return 明細情報（住所地特例）パネル
   */
  public ACPanel getDetailsJushotiTokureiPanel(){
    if(detailsJushotiTokureiPanel==null){

      detailsJushotiTokureiPanel = new ACPanel();

      addDetailsJushotiTokureiPanel();
    }
    return detailsJushotiTokureiPanel;

  }

  /**
   * 明細情報（住所地特例）ラベルを取得します。
   * @return 明細情報（住所地特例）ラベル
   */
  public ACLabel getDetailsJushotiTokureiLabel(){
    if(detailsJushotiTokureiLabel==null){

      detailsJushotiTokureiLabel = new ACLabel();

      detailsJushotiTokureiLabel.setText("明細情報（住所地特例）");

      addDetailsJushotiTokureiLabel();
    }
    return detailsJushotiTokureiLabel;

  }

  /**
   * サービス削除ボタンを取得します。
   * @return サービス削除ボタン
   */
  public ACButton getDetailsJushotiTokureiDelButton(){
    if(detailsJushotiTokureiDelButton==null){

      detailsJushotiTokureiDelButton = new ACButton();

      detailsJushotiTokureiDelButton.setText("サービス削除");

      detailsJushotiTokureiDelButton.setIconPath(ACConstants.ICON_PATH_STATE_DELETE_16);

      addDetailsJushotiTokureiDelButton();
    }
    return detailsJushotiTokureiDelButton;

  }

  /**
   * 明細情報（住所地特例）テーブルを取得します。
   * @return 明細情報（住所地特例）テーブル
   */
  public ACTable getDetailsJushotiTokureiInfoTable(){
    if(detailsJushotiTokureiInfoTable==null){

      detailsJushotiTokureiInfoTable = new ACTable();

      detailsJushotiTokureiInfoTable.setColumnModel(getDetailsJushotiTokureiInfoTableColumnModel());

      detailsJushotiTokureiInfoTable.setColumnSort(false);

      addDetailsJushotiTokureiInfoTable();
    }
    return detailsJushotiTokureiInfoTable;

  }

  /**
   * 明細情報（住所地特例）テーブルカラムモデルを取得します。
   * @return 明細情報（住所地特例）テーブルカラムモデル
   */
  protected VRTableColumnModel getDetailsJushotiTokureiInfoTableColumnModel(){
    if(detailsJushotiTokureiInfoTableColumnModel==null){
      detailsJushotiTokureiInfoTableColumnModel = new VRTableColumnModel(new TableColumn[]{});
      addDetailsJushotiTokureiInfoTableColumnModel();
    }
    return detailsJushotiTokureiInfoTableColumnModel;
  }

  /**
   * No.を取得します。
   * @return No.
   */
  public ACTableColumn getDetailsJushotiTokureiInfoTablecolumn0(){
    if(detailsJushotiTokureiInfoTablecolumn0==null){

      detailsJushotiTokureiInfoTablecolumn0 = new ACTableColumn(0, 30);

      detailsJushotiTokureiInfoTablecolumn0.setHeaderValue("　");

      detailsJushotiTokureiInfoTablecolumn0.setRendererType(ACTableCellViewer.RENDERER_TYPE_SERIAL_NO);

      detailsJushotiTokureiInfoTablecolumn0.setSortable(false);

      addDetailsJushotiTokureiInfoTablecolumn0();
    }
    return detailsJushotiTokureiInfoTablecolumn0;

  }

  /**
   * サービスコードを取得します。
   * @return サービスコード
   */
  public ACTableColumn getDetailsJushotiTokureiInfoTablecolumn1(){
    if(detailsJushotiTokureiInfoTablecolumn1==null){

      detailsJushotiTokureiInfoTablecolumn1 = new ACTableColumn(0, 105);

      detailsJushotiTokureiInfoTablecolumn1.setHeaderValue("サービスコード");

      addDetailsJushotiTokureiInfoTablecolumn1();
    }
    return detailsJushotiTokureiInfoTablecolumn1;

  }

  /**
   * サービス名称を取得します。
   * @return サービス名称
   */
  public ACTableColumn getDetailsJushotiTokureiInfoTablecolumn2(){
    if(detailsJushotiTokureiInfoTablecolumn2==null){

      detailsJushotiTokureiInfoTablecolumn2 = new ACTableColumn(1, 90);

      detailsJushotiTokureiInfoTablecolumn2.setHeaderValue("サービス名称");

      addDetailsJushotiTokureiInfoTablecolumn2();
    }
    return detailsJushotiTokureiInfoTablecolumn2;

  }

  /**
   * 単位数を取得します。
   * @return 単位数
   */
  public ACTableColumn getDetailsJushotiTokureiInfoTablecolumn3(){
    if(detailsJushotiTokureiInfoTablecolumn3==null){

      detailsJushotiTokureiInfoTablecolumn3 = new ACTableColumn(2, 55);

      detailsJushotiTokureiInfoTablecolumn3.setHeaderValue("単位数");

      addDetailsJushotiTokureiInfoTablecolumn3();
    }
    return detailsJushotiTokureiInfoTablecolumn3;

  }

  /**
   * 日数・回数を取得します。
   * @return 日数・回数
   */
  public ACTableColumn getDetailsJushotiTokureiInfoTablecolumn4(){
    if(detailsJushotiTokureiInfoTablecolumn4==null){

      detailsJushotiTokureiInfoTablecolumn4 = new ACTableColumn(3, 75);

      detailsJushotiTokureiInfoTablecolumn4.setHeaderValue("日数・回数");

      addDetailsJushotiTokureiInfoTablecolumn4();
    }
    return detailsJushotiTokureiInfoTablecolumn4;

  }

  /**
   * 公費1対象日数・回数を取得します。
   * @return 公費1対象日数・回数
   */
  public ACTableColumn getDetailsJushotiTokureiInfoTablecolumn5(){
    if(detailsJushotiTokureiInfoTablecolumn5==null){

      detailsJushotiTokureiInfoTablecolumn5 = new ACTableColumn(4, 135);

      detailsJushotiTokureiInfoTablecolumn5.setHeaderValue("公費1対象日数・回数");

      addDetailsJushotiTokureiInfoTablecolumn5();
    }
    return detailsJushotiTokureiInfoTablecolumn5;

  }

  /**
   * 公費2対象日数・回数を取得します。
   * @return 公費2対象日数・回数
   */
  public ACTableColumn getDetailsJushotiTokureiInfoTablecolumn6(){
    if(detailsJushotiTokureiInfoTablecolumn6==null){

      detailsJushotiTokureiInfoTablecolumn6 = new ACTableColumn(5, 135);

      detailsJushotiTokureiInfoTablecolumn6.setHeaderValue("公費2対象日数・回数");

      addDetailsJushotiTokureiInfoTablecolumn6();
    }
    return detailsJushotiTokureiInfoTablecolumn6;

  }

  /**
   * 公費3対象日数・回数を取得します。
   * @return 公費3対象日数・回数
   */
  public ACTableColumn getDetailsJushotiTokureiInfoTablecolumn7(){
    if(detailsJushotiTokureiInfoTablecolumn7==null){

      detailsJushotiTokureiInfoTablecolumn7 = new ACTableColumn(6, 135);

      detailsJushotiTokureiInfoTablecolumn7.setHeaderValue("公費3対象日数・回数");

      addDetailsJushotiTokureiInfoTablecolumn7();
    }
    return detailsJushotiTokureiInfoTablecolumn7;

  }

  /**
   * サービス単位数を取得します。
   * @return サービス単位数
   */
  public ACTableColumn getDetailsJushotiTokureiInfoTablecolumn8(){
    if(detailsJushotiTokureiInfoTablecolumn8==null){

      detailsJushotiTokureiInfoTablecolumn8 = new ACTableColumn(7, 105);

      detailsJushotiTokureiInfoTablecolumn8.setHeaderValue("サービス単位数");

      addDetailsJushotiTokureiInfoTablecolumn8();
    }
    return detailsJushotiTokureiInfoTablecolumn8;

  }

  /**
   * 公費1対象サービス単位数を取得します。
   * @return 公費1対象サービス単位数
   */
  public ACTableColumn getDetailsJushotiTokureiInfoTablecolumn9(){
    if(detailsJushotiTokureiInfoTablecolumn9==null){

      detailsJushotiTokureiInfoTablecolumn9 = new ACTableColumn(8, 165);

      detailsJushotiTokureiInfoTablecolumn9.setHeaderValue("公費1対象サービス単位数");

      addDetailsJushotiTokureiInfoTablecolumn9();
    }
    return detailsJushotiTokureiInfoTablecolumn9;

  }

  /**
   * 公費2対象サービス単位数を取得します。
   * @return 公費2対象サービス単位数
   */
  public ACTableColumn getDetailsJushotiTokureiInfoTablecolumn10(){
    if(detailsJushotiTokureiInfoTablecolumn10==null){

      detailsJushotiTokureiInfoTablecolumn10 = new ACTableColumn(9, 165);

      detailsJushotiTokureiInfoTablecolumn10.setHeaderValue("公費2対象サービス単位数");

      addDetailsJushotiTokureiInfoTablecolumn10();
    }
    return detailsJushotiTokureiInfoTablecolumn10;

  }

  /**
   * 公費3対象サービス単位数を取得します。
   * @return 公費3対象サービス単位数
   */
  public ACTableColumn getDetailsJushotiTokureiInfoTablecolumn11(){
    if(detailsJushotiTokureiInfoTablecolumn11==null){

      detailsJushotiTokureiInfoTablecolumn11 = new ACTableColumn(10, 165);

      detailsJushotiTokureiInfoTablecolumn11.setHeaderValue("公費3対象サービス単位数");

      addDetailsJushotiTokureiInfoTablecolumn11();
    }
    return detailsJushotiTokureiInfoTablecolumn11;

  }

  /**
   * 施設所在保険者番号を取得します。
   * @return 施設所在保険者番号
   */
  public ACTableColumn getDetailsJushotiTokureiInfoTablecolumn12(){
    if(detailsJushotiTokureiInfoTablecolumn12==null){

      detailsJushotiTokureiInfoTablecolumn12 = new ACTableColumn(11, 135);

      detailsJushotiTokureiInfoTablecolumn12.setHeaderValue("施設所在保険者番号");

      addDetailsJushotiTokureiInfoTablecolumn12();
    }
    return detailsJushotiTokureiInfoTablecolumn12;

  }

  /**
   * 摘要(英数)を取得します。
   * @return 摘要(英数)
   */
  public ACTableColumn getDetailsJushotiTokureiInfoTablecolumn13(){
    if(detailsJushotiTokureiInfoTablecolumn13==null){

      detailsJushotiTokureiInfoTablecolumn13 = new ACTableColumn(12, 105);

      detailsJushotiTokureiInfoTablecolumn13.setHeaderValue("摘要(英数)");

      addDetailsJushotiTokureiInfoTablecolumn13();
    }
    return detailsJushotiTokureiInfoTablecolumn13;

  }

  /**
   * 明細設定内容修正パネルを取得します。
   * @return 明細設定内容修正パネル
   */
  public ACPanel getDetailsJushotiTokureiInfoRevisionPanel(){
    if(detailsJushotiTokureiInfoRevisionPanel==null){

      detailsJushotiTokureiInfoRevisionPanel = new ACPanel();

      addDetailsJushotiTokureiInfoRevisionPanel();
    }
    return detailsJushotiTokureiInfoRevisionPanel;

  }

  /**
   * 設定内容修正欄ラベルを取得します。
   * @return 設定内容修正欄ラベル
   */
  public ACLabel getDetailsJushotiTokureiInfoRevisionLabel(){
    if(detailsJushotiTokureiInfoRevisionLabel==null){

      detailsJushotiTokureiInfoRevisionLabel = new ACLabel();

      detailsJushotiTokureiInfoRevisionLabel.setText("設定内容修正欄");

      addDetailsJushotiTokureiInfoRevisionLabel();
    }
    return detailsJushotiTokureiInfoRevisionLabel;

  }

  /**
   * 明細情報（住所地特例）を取得します。
   * @return 明細情報（住所地特例）
   */
  public ACLabel getDetailsJushotiTokureiInfoRevision(){
    if(detailsJushotiTokureiInfoRevision==null){

      detailsJushotiTokureiInfoRevision = new ACLabel();

      detailsJushotiTokureiInfoRevision.setText("明細情報（住所地特例）");

      addDetailsJushotiTokureiInfoRevision();
    }
    return detailsJushotiTokureiInfoRevision;

  }

  /**
   * 全ての情報を表示を取得します。
   * @return 全ての情報を表示
   */
  public ACIntegerCheckBox getDetailsJushotiTokureiInfoRevisionCheck(){
    if(detailsJushotiTokureiInfoRevisionCheck==null){

      detailsJushotiTokureiInfoRevisionCheck = new ACIntegerCheckBox();

      detailsJushotiTokureiInfoRevisionCheck.setText("すべての情報を表示（A）");

      detailsJushotiTokureiInfoRevisionCheck.setMnemonic('A');

      addDetailsJushotiTokureiInfoRevisionCheck();
    }
    return detailsJushotiTokureiInfoRevisionCheck;

  }

  /**
   * 明細情報詳細テーブルを取得します。
   * @return 明細情報詳細テーブル
   */
  public ACTable getDetailsJushotiTokureiInfoRevisionTable(){
    if(detailsJushotiTokureiInfoRevisionTable==null){

      detailsJushotiTokureiInfoRevisionTable = new ACTable();

      detailsJushotiTokureiInfoRevisionTable.setColumnModel(getDetailsJushotiTokureiInfoRevisionTableColumnModel());

      detailsJushotiTokureiInfoRevisionTable.setColumnSort(false);

      addDetailsJushotiTokureiInfoRevisionTable();
    }
    return detailsJushotiTokureiInfoRevisionTable;

  }

  /**
   * 明細情報詳細テーブルカラムモデルを取得します。
   * @return 明細情報詳細テーブルカラムモデル
   */
  protected VRTableColumnModel getDetailsJushotiTokureiInfoRevisionTableColumnModel(){
    if(detailsJushotiTokureiInfoRevisionTableColumnModel==null){
      detailsJushotiTokureiInfoRevisionTableColumnModel = new VRTableColumnModel(new TableColumn[]{});
      addDetailsJushotiTokureiInfoRevisionTableColumnModel();
    }
    return detailsJushotiTokureiInfoRevisionTableColumnModel;
  }

  /**
   * No.を取得します。
   * @return No.
   */
  public ACTableColumn getDetailsJushotiTokureiInfoRevisionTablecolumn0(){
    if(detailsJushotiTokureiInfoRevisionTablecolumn0==null){

      detailsJushotiTokureiInfoRevisionTablecolumn0 = new ACTableColumn(0, 30);

      detailsJushotiTokureiInfoRevisionTablecolumn0.setHeaderValue("　");

      detailsJushotiTokureiInfoRevisionTablecolumn0.setRendererType(ACTableCellViewer.RENDERER_TYPE_SERIAL_NO);

      detailsJushotiTokureiInfoRevisionTablecolumn0.setSortable(false);

      addDetailsJushotiTokureiInfoRevisionTablecolumn0();
    }
    return detailsJushotiTokureiInfoRevisionTablecolumn0;

  }

  /**
   * 項目名を取得します。
   * @return 項目名
   */
  public ACTableColumn getDetailsJushotiTokureiInfoRevisionTablecolumn1(){
    if(detailsJushotiTokureiInfoRevisionTablecolumn1==null){

      detailsJushotiTokureiInfoRevisionTablecolumn1 = new ACTableColumn(0, 55);

      detailsJushotiTokureiInfoRevisionTablecolumn1.setHeaderValue("項目名");

      detailsJushotiTokureiInfoRevisionTablecolumn1.setColumns(15);

      addDetailsJushotiTokureiInfoRevisionTablecolumn1();
    }
    return detailsJushotiTokureiInfoRevisionTablecolumn1;

  }

  /**
   * 設定値を取得します。
   * @return 設定値
   */
  public ACTableColumn getDetailsJushotiTokureiInfoRevisionTablecolumn2(){
    if(detailsJushotiTokureiInfoRevisionTablecolumn2==null){

      detailsJushotiTokureiInfoRevisionTablecolumn2 = new ACTableColumn(1, 55);

      detailsJushotiTokureiInfoRevisionTablecolumn2.setHeaderValue("設定値");

      detailsJushotiTokureiInfoRevisionTablecolumn2.setEditable(true);

      detailsJushotiTokureiInfoRevisionTablecolumn2.setColumns(8);

      addDetailsJushotiTokureiInfoRevisionTablecolumn2();
    }
    return detailsJushotiTokureiInfoRevisionTablecolumn2;

  }

  /**
   * コメントを取得します。
   * @return コメント
   */
  public ACTableColumn getDetailsJushotiTokureiInfoRevisionTablecolumn3(){
    if(detailsJushotiTokureiInfoRevisionTablecolumn3==null){

      detailsJushotiTokureiInfoRevisionTablecolumn3 = new ACTableColumn(2, 55);

      detailsJushotiTokureiInfoRevisionTablecolumn3.setHeaderValue("コメント");

      detailsJushotiTokureiInfoRevisionTablecolumn3.setColumns(30);

      addDetailsJushotiTokureiInfoRevisionTablecolumn3();
    }
    return detailsJushotiTokureiInfoRevisionTablecolumn3;

  }

  /**
   * コンストラクタです。
   */
  public QP005Design() {

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

    this.add(getContens(), VRLayout.CLIENT);

  }

  /**
   * 業務ボタンバーに内部項目を追加します。
   */
  protected void addButtons(){

    buttons.add(getRenewal(), VRLayout.EAST);
    buttons.add(getRetotal(), VRLayout.EAST);
  }

  /**
   * 再集計に内部項目を追加します。
   */
  protected void addRetotal(){

  }

  /**
   * 更新に内部項目を追加します。
   */
  protected void addRenewal(){

  }

  /**
   * クライアント領域に内部項目を追加します。
   */
  protected void addContens(){

    contens.add(getCommonInfoPanle(), VRLayout.NORTH);

    contens.add(getEtcInfoTabs(), VRLayout.CLIENT);

  }

  /**
   * 共通領域に内部項目を追加します。
   */
  protected void addCommonInfoPanle(){

    commonInfoPanle.add(getCommonInfos(), VRLayout.WEST);

  }

  /**
   * 情報領域に内部項目を追加します。
   */
  protected void addCommonInfos(){

    commonInfos.add(getCommonInfoPattern(), VRLayout.FLOW_RETURN);

    commonInfos.add(getCommonInfoProvider(), VRLayout.FLOW_RETURN);

    commonInfos.add(getCommonInfoDate(), VRLayout.FLOW);

    commonInfos.add(getCommmonInfoName(), VRLayout.FLOW_RETURN);

    commonInfos.add(getCommonInfoPublicExpenseLabelAll(), VRLayout.FLOW);

    commonInfos.add(getCommonInfoPublicExpenseText(), VRLayout.FLOW);

  }

  /**
   * 様式テキストに内部項目を追加します。
   */
  protected void addCommonInfoPattern(){

  }

  /**
   * 事業者テキストに内部項目を追加します。
   */
  protected void addCommonInfoProvider(){

  }

  /**
   * 月日テキストに内部項目を追加します。
   */
  protected void addCommonInfoDate(){

  }

  /**
   * 名前テキストに内部項目を追加します。
   */
  protected void addCommmonInfoName(){

  }

  /**
   * 該当公費一覧ラベルに内部項目を追加します。
   */
  protected void addCommonInfoPublicExpenseLabelAll(){

  }

  /**
   * 該当公費・テキストに内部項目を追加します。
   */
  protected void addCommonInfoPublicExpenseText(){

  }

  /**
   * 種類別タブに内部項目を追加します。
   */
  protected void addEtcInfoTabs(){

    etcInfoTabs.addTab("基本情報", getBasicInfos());

    etcInfoTabs.addTab("明細情報", getDetailsInfos());

    etcInfoTabs.addTab("特定治療・特定診療情報", getParticularInfos());

    etcInfoTabs.addTab("集計情報", getTotalInfos());

    etcInfoTabs.addTab("特定入所者介護費情報", getNyushoInfos());

    etcInfoTabs.addTab("社会福祉法人軽減情報", getShahukuInfos());

    etcInfoTabs.addTab("特別療養費情報", getRecuperationInfos());

    etcInfoTabs.addTab("明細情報（住所地特例）", getDetailsJushotiTokureiInfos());

  }

  /**
   * 基本情報領域に内部項目を追加します。
   */
  protected void addBasicInfos(){

    basicInfos.add(getBasicInfo(), VRLayout.NORTH);

    basicInfos.add(getBasicInfoTable(), VRLayout.NORTH);

    basicInfos.add(getBasicInfoRevisionPanel(), VRLayout.NORTH);

    basicInfos.add(getBasicInfoRevisionTable(), VRLayout.CLIENT);

  }

  /**
   * 基本情報パネルに内部項目を追加します。
   */
  protected void addBasicInfo(){

    basicInfo.add(getBasicInfoLabel(), VRLayout.FLOW);

  }

  /**
   * 基本情報ラベルに内部項目を追加します。
   */
  protected void addBasicInfoLabel(){

  }

  /**
   * 基本情報テーブルに内部項目を追加します。
   */
  protected void addBasicInfoTable(){

  }

  /**
   * 基本情報テーブルカラムモデルに内部項目を追加します。
   */
  protected void addBasicInfoTableColumnModel(){

    getBasicInfoTableColumnModel().addColumn(getBasicInfoTablecolumn0());

    getBasicInfoTableColumnModel().addColumn(getBasicInfoTablecolumn1());

    getBasicInfoTableColumnModel().addColumn(getBasicInfoTablecolumn2());

    getBasicInfoTableColumnModel().addColumn(getBasicInfoTablecolumn3());

    getBasicInfoTableColumnModel().addColumn(getBasicInfoTablecolumn4());

    getBasicInfoTableColumnModel().addColumn(getBasicInfoTablecolumn5());

    getBasicInfoTableColumnModel().addColumn(getBasicInfoTablecolumn6());

    getBasicInfoTableColumnModel().addColumn(getBasicInfoTablecolumn7());

    getBasicInfoTableColumnModel().addColumn(getBasicInfoTablecolumn8());

    getBasicInfoTableColumnModel().addColumn(getBasicInfoTablecolumn9());

    getBasicInfoTableColumnModel().addColumn(getBasicInfoTablecolumn10());

    getBasicInfoTableColumnModel().addColumn(getBasicInfoTablecolumn11());

    getBasicInfoTableColumnModel().addColumn(getBasicInfoTablecolumn12());

    getBasicInfoTableColumnModel().addColumn(getBasicInfoTablecolumn13());

    getBasicInfoTableColumnModel().addColumn(getBasicInfoTablecolumn14());

  }

  /**
   * No.に内部項目を追加します。
   */
  protected void addBasicInfoTablecolumn0(){

  }

  /**
   * 保険者番号に内部項目を追加します。
   */
  protected void addBasicInfoTablecolumn1(){

  }

  /**
   * 被保険者番号に内部項目を追加します。
   */
  protected void addBasicInfoTablecolumn2(){

  }

  /**
   * 要介護状態区分コードに内部項目を追加します。
   */
  protected void addBasicInfoTablecolumn3(){

  }

  /**
   * 認定有効期間開始年月日に内部項目を追加します。
   */
  protected void addBasicInfoTablecolumn4(){

  }

  /**
   * 認定有効期間終了年月日に内部項目を追加します。
   */
  protected void addBasicInfoTablecolumn5(){

  }

  /**
   * 居宅サービス計画者事業所番号に内部項目を追加します。
   */
  protected void addBasicInfoTablecolumn6(){

  }

  /**
   * 居宅サービス計画者事業所名に内部項目を追加します。
   */
  protected void addBasicInfoTablecolumn7(){

  }

  /**
   * 開始年月日に内部項目を追加します。
   */
  protected void addBasicInfoTablecolumn8(){

  }

  /**
   * 中止年月日に内部項目を追加します。
   */
  protected void addBasicInfoTablecolumn9(){

  }

  /**
   * 中止理由コードに内部項目を追加します。
   */
  protected void addBasicInfoTablecolumn10(){

  }

  /**
   * 入所(院)年月日に内部項目を追加します。
   */
  protected void addBasicInfoTablecolumn11(){

  }

  /**
   * 退所(院)年月日に内部項目を追加します。
   */
  protected void addBasicInfoTablecolumn12(){

  }

  /**
   * 入所(院)実日数に内部項目を追加します。
   */
  protected void addBasicInfoTablecolumn13(){

  }

  /**
   * 主傷病に内部項目を追加します。
   */
  protected void addBasicInfoTablecolumn14(){

  }

  /**
   * 基本設定内容修正パネルに内部項目を追加します。
   */
  protected void addBasicInfoRevisionPanel(){

    basicInfoRevisionPanel.add(getBasicInfoRevisionLabel(), VRLayout.FLOW);

    basicInfoRevisionPanel.add(getBasicInfoRevisionLabel2(), VRLayout.FLOW);

    basicInfoRevisionPanel.add(getBasicInfoRevisionCheck(), VRLayout.FLOW);

  }

  /**
   * 設定内容修正欄ラベルに内部項目を追加します。
   */
  protected void addBasicInfoRevisionLabel(){

  }

  /**
   * 基本情報に内部項目を追加します。
   */
  protected void addBasicInfoRevisionLabel2(){

  }

  /**
   * 全ての情報を表示に内部項目を追加します。
   */
  protected void addBasicInfoRevisionCheck(){

  }

  /**
   * 基本情報詳細テーブルに内部項目を追加します。
   */
  protected void addBasicInfoRevisionTable(){

  }

  /**
   * 基本情報詳細テーブルカラムモデルに内部項目を追加します。
   */
  protected void addBasicInfoRevisionTableColumnModel(){

    getBasicInfoRevisionTableColumnModel().addColumn(getBasicInfoRevisionTablecolumn0());

    getBasicInfoRevisionTableColumnModel().addColumn(getBasicInfoRevisionTablecolumn1());

    getBasicInfoRevisionTableColumnModel().addColumn(getBasicInfoRevisionTablecolumn2());

    getBasicInfoRevisionTableColumnModel().addColumn(getBasicInfoRevisionTablecolumn3());

  }

  /**
   * No.に内部項目を追加します。
   */
  protected void addBasicInfoRevisionTablecolumn0(){

  }

  /**
   * 項目名に内部項目を追加します。
   */
  protected void addBasicInfoRevisionTablecolumn1(){

  }

  /**
   * 設定値に内部項目を追加します。
   */
  protected void addBasicInfoRevisionTablecolumn2(){

  }

  /**
   * コメントに内部項目を追加します。
   */
  protected void addBasicInfoRevisionTablecolumn3(){

  }

  /**
   * 明細情報領域に内部項目を追加します。
   */
  protected void addDetailsInfos(){

    detailsInfos.add(getDetailsInfoPanel(), VRLayout.NORTH);

    detailsInfos.add(getDetailsInfoTable(), VRLayout.NORTH);

    detailsInfos.add(getKyotakuDetailsInfoTable(), VRLayout.NORTH);

    detailsInfos.add(getDetailsInfoRevisionPanel(), VRLayout.NORTH);

    detailsInfos.add(getDetailsInfoRevisionTable(), VRLayout.CLIENT);

  }

  /**
   * 明細情報パネルに内部項目を追加します。
   */
  protected void addDetailsInfoPanel(){

    detailsInfoPanel.add(getDetailsInfoLabel(), VRLayout.FLOW);

    detailsInfoPanel.add(getDetailsDelButton(), VRLayout.EAST);
  }

  /**
   * 明細情報ラベルに内部項目を追加します。
   */
  protected void addDetailsInfoLabel(){

  }

  /**
   * サービス削除ボタンに内部項目を追加します。
   */
  protected void addDetailsDelButton(){

  }

  /**
   * 明細情報テーブルに内部項目を追加します。
   */
  protected void addDetailsInfoTable(){

  }

  /**
   * 明細情報テーブルカラムモデルに内部項目を追加します。
   */
  protected void addDetailsInfoTableColumnModel(){

    getDetailsInfoTableColumnModel().addColumn(getDetailsInfoTablecolumn0());

    getDetailsInfoTableColumnModel().addColumn(getDetailsInfoTablecolumn1());

    getDetailsInfoTableColumnModel().addColumn(getDetailsInfoTablecolumn2());

    getDetailsInfoTableColumnModel().addColumn(getDetailsInfoTablecolumn3());

    getDetailsInfoTableColumnModel().addColumn(getDetailsInfoTablecolumn4());

    getDetailsInfoTableColumnModel().addColumn(getDetailsInfoTablecolumn5());

    getDetailsInfoTableColumnModel().addColumn(getDetailsInfoTablecolumn6());

    getDetailsInfoTableColumnModel().addColumn(getDetailsInfoTablecolumn7());

    getDetailsInfoTableColumnModel().addColumn(getDetailsInfoTablecolumn8());

    getDetailsInfoTableColumnModel().addColumn(getDetailsInfoTablecolumn9());

    getDetailsInfoTableColumnModel().addColumn(getDetailsInfoTablecolumn10());

    getDetailsInfoTableColumnModel().addColumn(getDetailsInfoTablecolumn11());

    getDetailsInfoTableColumnModel().addColumn(getDetailsInfoTablecolumn12());

  }

  /**
   * No.に内部項目を追加します。
   */
  protected void addDetailsInfoTablecolumn0(){

  }

  /**
   * サービスコードに内部項目を追加します。
   */
  protected void addDetailsInfoTablecolumn1(){

  }

  /**
   * サービス名称に内部項目を追加します。
   */
  protected void addDetailsInfoTablecolumn2(){

  }

  /**
   * 単位数に内部項目を追加します。
   */
  protected void addDetailsInfoTablecolumn3(){

  }

  /**
   * 日数・回数に内部項目を追加します。
   */
  protected void addDetailsInfoTablecolumn4(){

  }

  /**
   * 公費1対象日数・回数に内部項目を追加します。
   */
  protected void addDetailsInfoTablecolumn5(){

  }

  /**
   * 公費2対象日数・回数に内部項目を追加します。
   */
  protected void addDetailsInfoTablecolumn6(){

  }

  /**
   * 公費3対象日数・回数に内部項目を追加します。
   */
  protected void addDetailsInfoTablecolumn7(){

  }

  /**
   * サービス単位数に内部項目を追加します。
   */
  protected void addDetailsInfoTablecolumn8(){

  }

  /**
   * 公費1対象サービス単位数に内部項目を追加します。
   */
  protected void addDetailsInfoTablecolumn9(){

  }

  /**
   * 公費2対象サービス単位数に内部項目を追加します。
   */
  protected void addDetailsInfoTablecolumn10(){

  }

  /**
   * 公費3対象サービス単位数に内部項目を追加します。
   */
  protected void addDetailsInfoTablecolumn11(){

  }

  /**
   * 摘要(英数)に内部項目を追加します。
   */
  protected void addDetailsInfoTablecolumn12(){

  }

  /**
   * 居宅介護支援明細情報テーブルに内部項目を追加します。
   */
  protected void addKyotakuDetailsInfoTable(){

  }

  /**
   * 居宅介護支援明細情報テーブルカラムモデルに内部項目を追加します。
   */
  protected void addKyotakuDetailsInfoTableColumnModel(){

    getKyotakuDetailsInfoTableColumnModel().addColumn(getKyotakuDetailsInfoTablecolumn0());

    getKyotakuDetailsInfoTableColumnModel().addColumn(getKyotakuDetailsInfoTablecolumn1());

    getKyotakuDetailsInfoTableColumnModel().addColumn(getKyotakuDetailsInfoTablecolumn2());

    getKyotakuDetailsInfoTableColumnModel().addColumn(getKyotakuDetailsInfoTablecolumn3());

    getKyotakuDetailsInfoTableColumnModel().addColumn(getKyotakuDetailsInfoTablecolumn4());

    getKyotakuDetailsInfoTableColumnModel().addColumn(getKyotakuDetailsInfoTablecolumn5());

    getKyotakuDetailsInfoTableColumnModel().addColumn(getKyotakuDetailsInfoTablecolumn6());

    getKyotakuDetailsInfoTableColumnModel().addColumn(getKyotakuDetailsInfoTablecolumn7());

    getKyotakuDetailsInfoTableColumnModel().addColumn(getKyotakuDetailsInfoTablecolumn8());

    getKyotakuDetailsInfoTableColumnModel().addColumn(getKyotakuDetailsInfoTablecolumn9());

    getKyotakuDetailsInfoTableColumnModel().addColumn(getKyotakuDetailsInfoTablecolumn10());

  }

  /**
   * No.に内部項目を追加します。
   */
  protected void addKyotakuDetailsInfoTablecolumn0(){

  }

  /**
   * 生年月日に内部項目を追加します。
   */
  protected void addKyotakuDetailsInfoTablecolumn1(){

  }

  /**
   * 性別コードに内部項目を追加します。
   */
  protected void addKyotakuDetailsInfoTablecolumn2(){

  }

  /**
   * 要介護状態区分コードに内部項目を追加します。
   */
  protected void addKyotakuDetailsInfoTablecolumn3(){

  }

  /**
   * 認定有効期間開始日に内部項目を追加します。
   */
  protected void addKyotakuDetailsInfoTablecolumn4(){

  }

  /**
   * 認定有効期間終了日に内部項目を追加します。
   */
  protected void addKyotakuDetailsInfoTablecolumn5(){

  }

  /**
   * 居宅サービス計画作成依頼届出年月日に内部項目を追加します。
   */
  protected void addKyotakuDetailsInfoTablecolumn6(){

  }

  /**
   * サービスコードに内部項目を追加します。
   */
  protected void addKyotakuDetailsInfoTablecolumn7(){

  }

  /**
   * サービス名称に内部項目を追加します。
   */
  protected void addKyotakuDetailsInfoTablecolumn8(){

  }

  /**
   * 単位数に内部項目を追加します。
   */
  protected void addKyotakuDetailsInfoTablecolumn9(){

  }

  /**
   * 請求金額に内部項目を追加します。
   */
  protected void addKyotakuDetailsInfoTablecolumn10(){

  }

  /**
   * 明細設定内容修正パネルに内部項目を追加します。
   */
  protected void addDetailsInfoRevisionPanel(){

    detailsInfoRevisionPanel.add(getDetailsInfoRevisionLabel(), VRLayout.FLOW);

    detailsInfoRevisionPanel.add(getDetailsInfoRevision(), VRLayout.FLOW);

    detailsInfoRevisionPanel.add(getDetailsInfoRevisionCheck(), VRLayout.FLOW);

  }

  /**
   * 設定内容修正欄ラベルに内部項目を追加します。
   */
  protected void addDetailsInfoRevisionLabel(){

  }

  /**
   * 明細情報に内部項目を追加します。
   */
  protected void addDetailsInfoRevision(){

  }

  /**
   * 全ての情報を表示に内部項目を追加します。
   */
  protected void addDetailsInfoRevisionCheck(){

  }

  /**
   * 明細情報詳細テーブルに内部項目を追加します。
   */
  protected void addDetailsInfoRevisionTable(){

  }

  /**
   * 明細情報詳細テーブルカラムモデルに内部項目を追加します。
   */
  protected void addDetailsInfoRevisionTableColumnModel(){

    getDetailsInfoRevisionTableColumnModel().addColumn(getDetailsInfoRevisionTablecolumn0());

    getDetailsInfoRevisionTableColumnModel().addColumn(getDetailsInfoRevisionTablecolumn1());

    getDetailsInfoRevisionTableColumnModel().addColumn(getDetailsInfoRevisionTablecolumn2());

    getDetailsInfoRevisionTableColumnModel().addColumn(getDetailsInfoRevisionTablecolumn3());

  }

  /**
   * No.に内部項目を追加します。
   */
  protected void addDetailsInfoRevisionTablecolumn0(){

  }

  /**
   * 項目名に内部項目を追加します。
   */
  protected void addDetailsInfoRevisionTablecolumn1(){

  }

  /**
   * 設定値に内部項目を追加します。
   */
  protected void addDetailsInfoRevisionTablecolumn2(){

  }

  /**
   * コメントに内部項目を追加します。
   */
  protected void addDetailsInfoRevisionTablecolumn3(){

  }

  /**
   * 特定治療・特定診療情報領域に内部項目を追加します。
   */
  protected void addParticularInfos(){

    particularInfos.add(getParticularInfoPanel(), VRLayout.NORTH);

    particularInfos.add(getParticularInfoTable(), VRLayout.NORTH);

    particularInfos.add(getSpecialClinicInfoTable(), VRLayout.NORTH);

    particularInfos.add(getParticularInfoRevisionPanel(), VRLayout.NORTH);

    particularInfos.add(getParticularInfoRevisionTable(), VRLayout.CLIENT);

  }

  /**
   * 特定治療費情報パネルに内部項目を追加します。
   */
  protected void addParticularInfoPanel(){

    particularInfoPanel.add(getParticularInfoLabel(), VRLayout.FLOW);

  }

  /**
   * 特定治療費情報ラベルに内部項目を追加します。
   */
  protected void addParticularInfoLabel(){

  }

  /**
   * 特定治療費情報テーブルに内部項目を追加します。
   */
  protected void addParticularInfoTable(){

  }

  /**
   * 特定治療費情報テーブルカラムモデルに内部項目を追加します。
   */
  protected void addParticularInfoTableColumnModel(){

    getParticularInfoTableColumnModel().addColumn(getParticularInfoTablecolumn0());

    getParticularInfoTableColumnModel().addColumn(getParticularInfoTablecolumn1());

    getParticularInfoTableColumnModel().addColumn(getParticularInfoTablecolumn2());

    getParticularInfoTableColumnModel().addColumn(getParticularInfoTablecolumn3());

    getParticularInfoTableColumnModel().addColumn(getParticularInfoTablecolumn4());

    getParticularInfoTableColumnModel().addColumn(getParticularInfoTablecolumn5());

    getParticularInfoTableColumnModel().addColumn(getParticularInfoTablecolumn6());

    getParticularInfoTableColumnModel().addColumn(getParticularInfoTablecolumn7());

    getParticularInfoTableColumnModel().addColumn(getParticularInfoTablecolumn8());

    getParticularInfoTableColumnModel().addColumn(getParticularInfoTablecolumn9());

    getParticularInfoTableColumnModel().addColumn(getParticularInfoTablecolumn10());

    getParticularInfoTableColumnModel().addColumn(getParticularInfoTablecolumn11());

    getParticularInfoTableColumnModel().addColumn(getParticularInfoTablecolumn12());

    getParticularInfoTableColumnModel().addColumn(getParticularInfoTablecolumn13());

    getParticularInfoTableColumnModel().addColumn(getParticularInfoTablecolumn14());

    getParticularInfoTableColumnModel().addColumn(getParticularInfoTablecolumn15());

    getParticularInfoTableColumnModel().addColumn(getParticularInfoTablecolumn16());

    getParticularInfoTableColumnModel().addColumn(getParticularInfoTablecolumn17());

    getParticularInfoTableColumnModel().addColumn(getParticularInfoTablecolumn18());

    getParticularInfoTableColumnModel().addColumn(getParticularInfoTablecolumn19());

  }

  /**
   * No.に内部項目を追加します。
   */
  protected void addParticularInfoTablecolumn0(){

  }

  /**
   * 事業所番号に内部項目を追加します。
   */
  protected void addParticularInfoTablecolumn1(){

  }

  /**
   * 緊急時傷病名1に内部項目を追加します。
   */
  protected void addParticularInfoTablecolumn2(){

  }

  /**
   * 緊急時傷病名2に内部項目を追加します。
   */
  protected void addParticularInfoTablecolumn3(){

  }

  /**
   * 緊急時傷病名3に内部項目を追加します。
   */
  protected void addParticularInfoTablecolumn4(){

  }

  /**
   * 緊急時治療開始年月日1に内部項目を追加します。
   */
  protected void addParticularInfoTablecolumn5(){

  }

  /**
   * 緊急時治療開始年月日2に内部項目を追加します。
   */
  protected void addParticularInfoTablecolumn6(){

  }

  /**
   * 緊急時治療開始年月日3に内部項目を追加します。
   */
  protected void addParticularInfoTablecolumn7(){

  }

  /**
   * 往診日数に内部項目を追加します。
   */
  protected void addParticularInfoTablecolumn8(){

  }

  /**
   * 往診医療機関名に内部項目を追加します。
   */
  protected void addParticularInfoTablecolumn9(){

  }

  /**
   * 通院日数に内部項目を追加します。
   */
  protected void addParticularInfoTablecolumn10(){

  }

  /**
   * 通院医療機関名に内部項目を追加します。
   */
  protected void addParticularInfoTablecolumn11(){

  }

  /**
   * 緊急時治療管理単位数に内部項目を追加します。
   */
  protected void addParticularInfoTablecolumn12(){

  }

  /**
   * 緊急時治療管理日数に内部項目を追加します。
   */
  protected void addParticularInfoTablecolumn13(){

  }

  /**
   * 緊急時治療管理小計に内部項目を追加します。
   */
  protected void addParticularInfoTablecolumn14(){

  }

  /**
   * リハビリテーション点数に内部項目を追加します。
   */
  protected void addParticularInfoTablecolumn15(){

  }

  /**
   * 処置点数に内部項目を追加します。
   */
  protected void addParticularInfoTablecolumn16(){

  }

  /**
   * 手術点数に内部項目を追加します。
   */
  protected void addParticularInfoTablecolumn17(){

  }

  /**
   * 麻酔点数に内部項目を追加します。
   */
  protected void addParticularInfoTablecolumn18(){

  }

  /**
   * 放射線治療点数に内部項目を追加します。
   */
  protected void addParticularInfoTablecolumn19(){

  }

  /**
   * 特定診療費情報テーブルに内部項目を追加します。
   */
  protected void addSpecialClinicInfoTable(){

  }

  /**
   * 特定診療費情報テーブルカラムモデルに内部項目を追加します。
   */
  protected void addSpecialClinicInfoTableColumnModel(){

    getSpecialClinicInfoTableColumnModel().addColumn(getSpecialClinicInfoTablecolumn0());

    getSpecialClinicInfoTableColumnModel().addColumn(getSpecialClinicInfoTablecolumn1());

    getSpecialClinicInfoTableColumnModel().addColumn(getSpecialClinicInfoTablecolumn2());

    getSpecialClinicInfoTableColumnModel().addColumn(getSpecialClinicInfoTablecolumn3());

    getSpecialClinicInfoTableColumnModel().addColumn(getSpecialClinicInfoTablecolumn4());

    getSpecialClinicInfoTableColumnModel().addColumn(getSpecialClinicInfoTablecolumn5());

    getSpecialClinicInfoTableColumnModel().addColumn(getSpecialClinicInfoTablecolumn6());

    getSpecialClinicInfoTableColumnModel().addColumn(getSpecialClinicInfoTablecolumn7());

    getSpecialClinicInfoTableColumnModel().addColumn(getSpecialClinicInfoTablecolumn8());

    getSpecialClinicInfoTableColumnModel().addColumn(getSpecialClinicInfoTablecolumn9());

    getSpecialClinicInfoTableColumnModel().addColumn(getSpecialClinicInfoTablecolumn10());

    getSpecialClinicInfoTableColumnModel().addColumn(getSpecialClinicInfoTablecolumn11());

    getSpecialClinicInfoTableColumnModel().addColumn(getSpecialClinicInfoTablecolumn12());

  }

  /**
   * No.に内部項目を追加します。
   */
  protected void addSpecialClinicInfoTablecolumn0(){

  }

  /**
   * 事業所番号に内部項目を追加します。
   */
  protected void addSpecialClinicInfoTablecolumn1(){

  }

  /**
   * レコード順次番号に内部項目を追加します。
   */
  protected void addSpecialClinicInfoTablecolumn2(){

  }

  /**
   * 傷病名に内部項目を追加します。
   */
  protected void addSpecialClinicInfoTablecolumn3(){

  }

  /**
   * 識別番号に内部項目を追加します。
   */
  protected void addSpecialClinicInfoTablecolumn4(){

  }

  /**
   * 単位数に内部項目を追加します。
   */
  protected void addSpecialClinicInfoTablecolumn5(){

  }

  /**
   * 保険回数に内部項目を追加します。
   */
  protected void addSpecialClinicInfoTablecolumn6(){

  }

  /**
   * 保険サービス単位数に内部項目を追加します。
   */
  protected void addSpecialClinicInfoTablecolumn7(){

  }

  /**
   * 保険合計単位数に内部項目を追加します。
   */
  protected void addSpecialClinicInfoTablecolumn8(){

  }

  /**
   * 公費1回数に内部項目を追加します。
   */
  protected void addSpecialClinicInfoTablecolumn9(){

  }

  /**
   * 公費2回数に内部項目を追加します。
   */
  protected void addSpecialClinicInfoTablecolumn10(){

  }

  /**
   * 公費3回数に内部項目を追加します。
   */
  protected void addSpecialClinicInfoTablecolumn11(){

  }

  /**
   * 摘要に内部項目を追加します。
   */
  protected void addSpecialClinicInfoTablecolumn12(){

  }

  /**
   * 特定治療費・特定診療費設定内容修正パネルに内部項目を追加します。
   */
  protected void addParticularInfoRevisionPanel(){

    particularInfoRevisionPanel.add(getParticularInfoRevisionLabel(), null);

    particularInfoRevisionPanel.add(getParticularInfoRevision(), null);

    particularInfoRevisionPanel.add(getParticularInfoRevisionCheck(), null);

  }

  /**
   * 特定治療費・特定診療費設定内容修正欄ラベルに内部項目を追加します。
   */
  protected void addParticularInfoRevisionLabel(){

  }

  /**
   * 特定治療費・特定診療費情報に内部項目を追加します。
   */
  protected void addParticularInfoRevision(){

  }

  /**
   * 全ての情報を表示に内部項目を追加します。
   */
  protected void addParticularInfoRevisionCheck(){

  }

  /**
   * 特定治療費・特定診療費情報詳細テーブルに内部項目を追加します。
   */
  protected void addParticularInfoRevisionTable(){

  }

  /**
   * 特定治療費・特定診療費情報詳細テーブルカラムモデルに内部項目を追加します。
   */
  protected void addParticularInfoRevisionTableColumnModel(){

    getParticularInfoRevisionTableColumnModel().addColumn(getParticularInfoRevisionTablecolumn0());

    getParticularInfoRevisionTableColumnModel().addColumn(getParticularInfoRevisionTablecolumn1());

    getParticularInfoRevisionTableColumnModel().addColumn(getParticularInfoRevisionTablecolumn2());

    getParticularInfoRevisionTableColumnModel().addColumn(getParticularInfoRevisionTablecolumn3());

  }

  /**
   * No.に内部項目を追加します。
   */
  protected void addParticularInfoRevisionTablecolumn0(){

  }

  /**
   * 項目名に内部項目を追加します。
   */
  protected void addParticularInfoRevisionTablecolumn1(){

  }

  /**
   * 設定値に内部項目を追加します。
   */
  protected void addParticularInfoRevisionTablecolumn2(){

  }

  /**
   * コメントに内部項目を追加します。
   */
  protected void addParticularInfoRevisionTablecolumn3(){

  }

  /**
   * 集計情報領域に内部項目を追加します。
   */
  protected void addTotalInfos(){

    totalInfos.add(getTotalInfoPanel(), VRLayout.NORTH);

    totalInfos.add(getTotalInfoTable(), VRLayout.NORTH);

    totalInfos.add(getTotalInfoRevisionPanel(), VRLayout.NORTH);

    totalInfos.add(getTotalInfoRevisionTable(), VRLayout.CLIENT);

  }

  /**
   * 集計情報パネルに内部項目を追加します。
   */
  protected void addTotalInfoPanel(){

    totalInfoPanel.add(getTotalInfoLabel(), VRLayout.FLOW);

  }

  /**
   * 集計情報ラベルに内部項目を追加します。
   */
  protected void addTotalInfoLabel(){

  }

  /**
   * 集計情報テーブルに内部項目を追加します。
   */
  protected void addTotalInfoTable(){

  }

  /**
   * 集計情報テーブルカラムモデルに内部項目を追加します。
   */
  protected void addTotalInfoTableColumnModel(){

    getTotalInfoTableColumnModel().addColumn(getTotalInfoTablecolumn0());

    getTotalInfoTableColumnModel().addColumn(getTotalInfoTablecolumn1());

    getTotalInfoTableColumnModel().addColumn(getTotalInfoTablecolumn2());

    getTotalInfoTableColumnModel().addColumn(getTotalInfoTablecolumn3());

    getTotalInfoTableColumnModel().addColumn(getTotalInfoTablecolumn4());

    getTotalInfoTableColumnModel().addColumn(getTotalInfoTablecolumn5());

    getTotalInfoTableColumnModel().addColumn(getTotalInfoTablecolumn6());

    getTotalInfoTableColumnModel().addColumn(getTotalInfoTablecolumn7());

    getTotalInfoTableColumnModel().addColumn(getTotalInfoTablecolumn8());

    getTotalInfoTableColumnModel().addColumn(getTotalInfoTablecolumn9());

    getTotalInfoTableColumnModel().addColumn(getTotalInfoTablecolumn10());

    getTotalInfoTableColumnModel().addColumn(getTotalInfoTablecolumn11());

    getTotalInfoTableColumnModel().addColumn(getTotalInfoTablecolumn12());

    getTotalInfoTableColumnModel().addColumn(getTotalInfoTablecolumn13());

    getTotalInfoTableColumnModel().addColumn(getTotalInfoTablecolumn14());

    getTotalInfoTableColumnModel().addColumn(getTotalInfoTablecolumn15());

    getTotalInfoTableColumnModel().addColumn(getTotalInfoTablecolumn16());

    getTotalInfoTableColumnModel().addColumn(getTotalInfoTablecolumn17());

    getTotalInfoTableColumnModel().addColumn(getTotalInfoTablecolumn18());

    getTotalInfoTableColumnModel().addColumn(getTotalInfoTablecolumn19());

    getTotalInfoTableColumnModel().addColumn(getTotalInfoTablecolumn20());

  }

  /**
   * No.に内部項目を追加します。
   */
  protected void addTotalInfoTablecolumn0(){

  }

  /**
   * サービス種類コードに内部項目を追加します。
   */
  protected void addTotalInfoTablecolumn1(){

  }

  /**
   * サービス実日数に内部項目を追加します。
   */
  protected void addTotalInfoTablecolumn2(){

  }

  /**
   * 計画単位数に内部項目を追加します。
   */
  protected void addTotalInfoTablecolumn3(){

  }

  /**
   * 限度額管理対象単位数に内部項目を追加します。
   */
  protected void addTotalInfoTablecolumn4(){

  }

  /**
   * 限度額管理対象外単位数に内部項目を追加します。
   */
  protected void addTotalInfoTablecolumn5(){

  }

  /**
   * 短期入所計画日数に内部項目を追加します。
   */
  protected void addTotalInfoTablecolumn6(){

  }

  /**
   * 短期入所実日数に内部項目を追加します。
   */
  protected void addTotalInfoTablecolumn7(){

  }

  /**
   * 保険単位数合計に内部項目を追加します。
   */
  protected void addTotalInfoTablecolumn8(){

  }

  /**
   * 保険単位数単価に内部項目を追加します。
   */
  protected void addTotalInfoTablecolumn9(){

  }

  /**
   * 保険請求額に内部項目を追加します。
   */
  protected void addTotalInfoTablecolumn10(){

  }

  /**
   * 保険利用者負担額に内部項目を追加します。
   */
  protected void addTotalInfoTablecolumn11(){

  }

  /**
   * 公費1請求額に内部項目を追加します。
   */
  protected void addTotalInfoTablecolumn12(){

  }

  /**
   * 公費1本人負担額に内部項目を追加します。
   */
  protected void addTotalInfoTablecolumn13(){

  }

  /**
   * 公費2請求額に内部項目を追加します。
   */
  protected void addTotalInfoTablecolumn14(){

  }

  /**
   * 公費2本人負担額に内部項目を追加します。
   */
  protected void addTotalInfoTablecolumn15(){

  }

  /**
   * 公費3請求額に内部項目を追加します。
   */
  protected void addTotalInfoTablecolumn16(){

  }

  /**
   * 公費3本人負担額に内部項目を追加します。
   */
  protected void addTotalInfoTablecolumn17(){

  }

  /**
   * 保険分出来高医療費単位数合計に内部項目を追加します。
   */
  protected void addTotalInfoTablecolumn18(){

  }

  /**
   * 保険分出来高医療費請求額に内部項目を追加します。
   */
  protected void addTotalInfoTablecolumn19(){

  }

  /**
   * 保険分出来高医療費利用者負担額に内部項目を追加します。
   */
  protected void addTotalInfoTablecolumn20(){

  }

  /**
   * 集計情報設定内容修正パネルに内部項目を追加します。
   */
  protected void addTotalInfoRevisionPanel(){

    totalInfoRevisionPanel.add(getTotalInfoRevisionLabel(), null);

    totalInfoRevisionPanel.add(getTotalInfoRevision(), null);

    totalInfoRevisionPanel.add(getTotalInfoRevisionCheck(), null);

  }

  /**
   * 集計設定内容修正欄ラベルに内部項目を追加します。
   */
  protected void addTotalInfoRevisionLabel(){

  }

  /**
   * 集計情報に内部項目を追加します。
   */
  protected void addTotalInfoRevision(){

  }

  /**
   * 全ての情報を表示に内部項目を追加します。
   */
  protected void addTotalInfoRevisionCheck(){

  }

  /**
   * 集計情報詳細テーブルに内部項目を追加します。
   */
  protected void addTotalInfoRevisionTable(){

  }

  /**
   * 集計情報詳細テーブルカラムモデルに内部項目を追加します。
   */
  protected void addTotalInfoRevisionTableColumnModel(){

    getTotalInfoRevisionTableColumnModel().addColumn(getTotalInfoRevisionTablecolumn0());

    getTotalInfoRevisionTableColumnModel().addColumn(getTotalInfoRevisionTablecolumn1());

    getTotalInfoRevisionTableColumnModel().addColumn(getTotalInfoRevisionTablecolumn2());

    getTotalInfoRevisionTableColumnModel().addColumn(getTotalInfoRevisionTablecolumn3());

  }

  /**
   * No.に内部項目を追加します。
   */
  protected void addTotalInfoRevisionTablecolumn0(){

  }

  /**
   * 項目名に内部項目を追加します。
   */
  protected void addTotalInfoRevisionTablecolumn1(){

  }

  /**
   * 設定値に内部項目を追加します。
   */
  protected void addTotalInfoRevisionTablecolumn2(){

  }

  /**
   * コメントに内部項目を追加します。
   */
  protected void addTotalInfoRevisionTablecolumn3(){

  }

  /**
   * 特定入所者介護費情報領域に内部項目を追加します。
   */
  protected void addNyushoInfos(){

    nyushoInfos.add(getNyushoInfoPanel(), VRLayout.NORTH);

    nyushoInfos.add(getNyushoInfoTable(), VRLayout.NORTH);

    nyushoInfos.add(getNyushoInfoRevisionPanel(), VRLayout.NORTH);

    nyushoInfos.add(getNyushoInfoRevisionTable(), VRLayout.CLIENT);

  }

  /**
   * 特定入所者介護費情報パネルに内部項目を追加します。
   */
  protected void addNyushoInfoPanel(){

    nyushoInfoPanel.add(getNyushoInfoLabel(), VRLayout.FLOW);

    nyushoInfoPanel.add(getServiceDelButton(), VRLayout.EAST);
    nyushoInfoPanel.add(getServiceAddButton(), VRLayout.EAST);
  }

  /**
   * 特定入所者介護費情報ラベルに内部項目を追加します。
   */
  protected void addNyushoInfoLabel(){

  }

  /**
   * サービス追加ボタンに内部項目を追加します。
   */
  protected void addServiceAddButton(){

  }

  /**
   * サービス削除ボタンに内部項目を追加します。
   */
  protected void addServiceDelButton(){

  }

  /**
   * 特定入所者介護費情報テーブルに内部項目を追加します。
   */
  protected void addNyushoInfoTable(){

  }

  /**
   * 特定入所者介護費情報テーブルカラムモデルに内部項目を追加します。
   */
  protected void addNyushoInfoTableColumnModel(){

    getNyushoInfoTableColumnModel().addColumn(getNyushoInfoTablecolumn0());

    getNyushoInfoTableColumnModel().addColumn(getNyushoInfoTablecolumn1());

    getNyushoInfoTableColumnModel().addColumn(getNyushoInfoTablecolumn2());

    getNyushoInfoTableColumnModel().addColumn(getNyushoInfoTablecolumn3());

    getNyushoInfoTableColumnModel().addColumn(getNyushoInfoTablecolumn4());

    getNyushoInfoTableColumnModel().addColumn(getNyushoInfoTablecolumn5());

    getNyushoInfoTableColumnModel().addColumn(getNyushoInfoTablecolumn6());

    getNyushoInfoTableColumnModel().addColumn(getNyushoInfoTablecolumn7());

    getNyushoInfoTableColumnModel().addColumn(getNyushoInfoTablecolumn8());

    getNyushoInfoTableColumnModel().addColumn(getNyushoInfoTablecolumn9());

    getNyushoInfoTableColumnModel().addColumn(getNyushoInfoTablecolumn10());

    getNyushoInfoTableColumnModel().addColumn(getNyushoInfoTablecolumn11());

    getNyushoInfoTableColumnModel().addColumn(getNyushoInfoTablecolumn12());

    getNyushoInfoTableColumnModel().addColumn(getNyushoInfoTablecolumn13());

    getNyushoInfoTableColumnModel().addColumn(getNyushoInfoTablecolumn14());

    getNyushoInfoTableColumnModel().addColumn(getNyushoInfoTablecolumn15());

    getNyushoInfoTableColumnModel().addColumn(getNyushoInfoTablecolumn16());

    getNyushoInfoTableColumnModel().addColumn(getNyushoInfoTablecolumn17());

    getNyushoInfoTableColumnModel().addColumn(getNyushoInfoTablecolumn18());

    getNyushoInfoTableColumnModel().addColumn(getNyushoInfoTablecolumn19());

    getNyushoInfoTableColumnModel().addColumn(getNyushoInfoTablecolumn20());

    getNyushoInfoTableColumnModel().addColumn(getNyushoInfoTablecolumn21());

    getNyushoInfoTableColumnModel().addColumn(getNyushoInfoTablecolumn22());

    getNyushoInfoTableColumnModel().addColumn(getNyushoInfoTablecolumn23());

    getNyushoInfoTableColumnModel().addColumn(getNyushoInfoTablecolumn24());

    getNyushoInfoTableColumnModel().addColumn(getNyushoInfoTablecolumn25());

    getNyushoInfoTableColumnModel().addColumn(getNyushoInfoTablecolumn26());

    getNyushoInfoTableColumnModel().addColumn(getNyushoInfoTablecolumn27());

  }

  /**
   * No.に内部項目を追加します。
   */
  protected void addNyushoInfoTablecolumn0(){

  }

  /**
   * レコード順に内部項目を追加します。
   */
  protected void addNyushoInfoTablecolumn1(){

  }

  /**
   * サービスコードに内部項目を追加します。
   */
  protected void addNyushoInfoTablecolumn2(){

  }

  /**
   * サービス名に内部項目を追加します。
   */
  protected void addNyushoInfoTablecolumn3(){

  }

  /**
   * 費用単価に内部項目を追加します。
   */
  protected void addNyushoInfoTablecolumn4(){

  }

  /**
   * 負担限度額に内部項目を追加します。
   */
  protected void addNyushoInfoTablecolumn5(){

  }

  /**
   * 日数に内部項目を追加します。
   */
  protected void addNyushoInfoTablecolumn6(){

  }

  /**
   * 公費1日数に内部項目を追加します。
   */
  protected void addNyushoInfoTablecolumn7(){

  }

  /**
   * 公費2日数に内部項目を追加します。
   */
  protected void addNyushoInfoTablecolumn8(){

  }

  /**
   * 公費3日数に内部項目を追加します。
   */
  protected void addNyushoInfoTablecolumn9(){

  }

  /**
   * 費用額に内部項目を追加します。
   */
  protected void addNyushoInfoTablecolumn10(){

  }

  /**
   * 保険分請求額に内部項目を追加します。
   */
  protected void addNyushoInfoTablecolumn11(){

  }

  /**
   * 公費1負担額に内部項目を追加します。
   */
  protected void addNyushoInfoTablecolumn12(){

  }

  /**
   * 公費2負担額に内部項目を追加します。
   */
  protected void addNyushoInfoTablecolumn13(){

  }

  /**
   * 公費3負担額に内部項目を追加します。
   */
  protected void addNyushoInfoTablecolumn14(){

  }

  /**
   * 利用者負担額に内部項目を追加します。
   */
  protected void addNyushoInfoTablecolumn15(){

  }

  /**
   * 費用額合計に内部項目を追加します。
   */
  protected void addNyushoInfoTablecolumn16(){

  }

  /**
   * 保険分請求額合計に内部項目を追加します。
   */
  protected void addNyushoInfoTablecolumn17(){

  }

  /**
   * 利用者負担額合計に内部項目を追加します。
   */
  protected void addNyushoInfoTablecolumn18(){

  }

  /**
   * 公費1負担額合計に内部項目を追加します。
   */
  protected void addNyushoInfoTablecolumn19(){

  }

  /**
   * 公費1請求額に内部項目を追加します。
   */
  protected void addNyushoInfoTablecolumn20(){

  }

  /**
   * 公費1本人負担月額に内部項目を追加します。
   */
  protected void addNyushoInfoTablecolumn21(){

  }

  /**
   * 公費2負担額合計に内部項目を追加します。
   */
  protected void addNyushoInfoTablecolumn22(){

  }

  /**
   * 公費2請求額に内部項目を追加します。
   */
  protected void addNyushoInfoTablecolumn23(){

  }

  /**
   * 公費2本人負担月額に内部項目を追加します。
   */
  protected void addNyushoInfoTablecolumn24(){

  }

  /**
   * 公費3負担額合計に内部項目を追加します。
   */
  protected void addNyushoInfoTablecolumn25(){

  }

  /**
   * 公費3請求額に内部項目を追加します。
   */
  protected void addNyushoInfoTablecolumn26(){

  }

  /**
   * 公費3本人負担月額に内部項目を追加します。
   */
  protected void addNyushoInfoTablecolumn27(){

  }

  /**
   * 特定入所者介護費設定内容修正パネルに内部項目を追加します。
   */
  protected void addNyushoInfoRevisionPanel(){

    nyushoInfoRevisionPanel.add(getNyushoInfoRevisionLabel(), null);

    nyushoInfoRevisionPanel.add(getNyushoInfoRevision(), null);

    nyushoInfoRevisionPanel.add(getNyushoInfoRevisionCheck(), null);

  }

  /**
   * 特定入所者介護費設定内容修正欄ラベルに内部項目を追加します。
   */
  protected void addNyushoInfoRevisionLabel(){

  }

  /**
   * 特定入所者介護費情報に内部項目を追加します。
   */
  protected void addNyushoInfoRevision(){

  }

  /**
   * 全ての情報を表示に内部項目を追加します。
   */
  protected void addNyushoInfoRevisionCheck(){

  }

  /**
   * 特定入所者介護費情報詳細テーブルに内部項目を追加します。
   */
  protected void addNyushoInfoRevisionTable(){

  }

  /**
   * 特定入所者介護費情報詳細テーブルカラムモデルに内部項目を追加します。
   */
  protected void addNyushoInfoRevisionTableColumnModel(){

    getNyushoInfoRevisionTableColumnModel().addColumn(getNyushoInfoRevisionTablecolumn0());

    getNyushoInfoRevisionTableColumnModel().addColumn(getNyushoInfoRevisionTablecolumn1());

    getNyushoInfoRevisionTableColumnModel().addColumn(getNyushoInfoRevisionTablecolumn2());

    getNyushoInfoRevisionTableColumnModel().addColumn(getNyushoInfoRevisionTablecolumn3());

  }

  /**
   * No.に内部項目を追加します。
   */
  protected void addNyushoInfoRevisionTablecolumn0(){

  }

  /**
   * 項目名に内部項目を追加します。
   */
  protected void addNyushoInfoRevisionTablecolumn1(){

  }

  /**
   * 設定値に内部項目を追加します。
   */
  protected void addNyushoInfoRevisionTablecolumn2(){

  }

  /**
   * コメントに内部項目を追加します。
   */
  protected void addNyushoInfoRevisionTablecolumn3(){

  }

  /**
   * 社会福祉法人軽減額情報領域に内部項目を追加します。
   */
  protected void addShahukuInfos(){

    shahukuInfos.add(getShahukuInfoPanel(), VRLayout.NORTH);

    shahukuInfos.add(getShahukuInfoTable(), VRLayout.NORTH);

    shahukuInfos.add(getShahukuInfoRevisionPanel(), VRLayout.NORTH);

    shahukuInfos.add(getShahukuInfoRevisionTable(), VRLayout.CLIENT);

  }

  /**
   * 社会福祉法人軽減額情報パネルに内部項目を追加します。
   */
  protected void addShahukuInfoPanel(){

    shahukuInfoPanel.add(getShahukuInfoLabel(), VRLayout.FLOW);

  }

  /**
   * 社会福祉法人軽減額情報ラベルに内部項目を追加します。
   */
  protected void addShahukuInfoLabel(){

  }

  /**
   * 社会福祉法人軽減額情報テーブルに内部項目を追加します。
   */
  protected void addShahukuInfoTable(){

  }

  /**
   * 社会福祉法人軽減額情報テーブルカラムモデルに内部項目を追加します。
   */
  protected void addShahukuInfoTableColumnModel(){

    getShahukuInfoTableColumnModel().addColumn(getShahukuInfoTablecolumn0());

    getShahukuInfoTableColumnModel().addColumn(getShahukuInfoTablecolumn1());

    getShahukuInfoTableColumnModel().addColumn(getShahukuInfoTablecolumn2());

    getShahukuInfoTableColumnModel().addColumn(getShahukuInfoTablecolumn3());

    getShahukuInfoTableColumnModel().addColumn(getShahukuInfoTablecolumn4());

    getShahukuInfoTableColumnModel().addColumn(getShahukuInfoTablecolumn5());

    getShahukuInfoTableColumnModel().addColumn(getShahukuInfoTablecolumn6());

  }

  /**
   * No.に内部項目を追加します。
   */
  protected void addShahukuInfoTablecolumn0(){

  }

  /**
   * 軽減率に内部項目を追加します。
   */
  protected void addShahukuInfoTablecolumn1(){

  }

  /**
   * サービス種類コードに内部項目を追加します。
   */
  protected void addShahukuInfoTablecolumn2(){

  }

  /**
   * 受領すべき利用者負担の総額に内部項目を追加します。
   */
  protected void addShahukuInfoTablecolumn3(){

  }

  /**
   * 軽減額に内部項目を追加します。
   */
  protected void addShahukuInfoTablecolumn4(){

  }

  /**
   * 軽減後利用者負担額に内部項目を追加します。
   */
  protected void addShahukuInfoTablecolumn5(){

  }

  /**
   * 備考に内部項目を追加します。
   */
  protected void addShahukuInfoTablecolumn6(){

  }

  /**
   * 社会福祉法人軽減額設定内容修正パネルに内部項目を追加します。
   */
  protected void addShahukuInfoRevisionPanel(){

    shahukuInfoRevisionPanel.add(getShahukuInfoRevisionLabel(), null);

    shahukuInfoRevisionPanel.add(getShahukuInfoRevision(), null);

    shahukuInfoRevisionPanel.add(getShahukuInfoRevisionCheck(), null);

  }

  /**
   * 社会福祉法人軽減額設定内容修正欄ラベルに内部項目を追加します。
   */
  protected void addShahukuInfoRevisionLabel(){

  }

  /**
   * 社会福祉法人軽減額情報に内部項目を追加します。
   */
  protected void addShahukuInfoRevision(){

  }

  /**
   * 全ての情報を表示に内部項目を追加します。
   */
  protected void addShahukuInfoRevisionCheck(){

  }

  /**
   * 社会福祉法人軽減額情報詳細テーブルに内部項目を追加します。
   */
  protected void addShahukuInfoRevisionTable(){

  }

  /**
   * 社会福祉法人軽減額情報詳細テーブルカラムモデルに内部項目を追加します。
   */
  protected void addShahukuInfoRevisionTableColumnModel(){

    getShahukuInfoRevisionTableColumnModel().addColumn(getShahukuInfoRevisionTablecolumn0());

    getShahukuInfoRevisionTableColumnModel().addColumn(getShahukuInfoRevisionTablecolumn1());

    getShahukuInfoRevisionTableColumnModel().addColumn(getShahukuInfoRevisionTablecolumn2());

    getShahukuInfoRevisionTableColumnModel().addColumn(getShahukuInfoRevisionTablecolumn3());

  }

  /**
   * No.に内部項目を追加します。
   */
  protected void addShahukuInfoRevisionTablecolumn0(){

  }

  /**
   * 項目名に内部項目を追加します。
   */
  protected void addShahukuInfoRevisionTablecolumn1(){

  }

  /**
   * 設定値に内部項目を追加します。
   */
  protected void addShahukuInfoRevisionTablecolumn2(){

  }

  /**
   * コメントに内部項目を追加します。
   */
  protected void addShahukuInfoRevisionTablecolumn3(){

  }

  /**
   * 特定療養費情報領域に内部項目を追加します。
   */
  protected void addRecuperationInfos(){

    recuperationInfos.add(getRecuperationInfoPanel(), VRLayout.NORTH);

    recuperationInfos.add(getRecuperationInfoTable(), VRLayout.NORTH);

    recuperationInfos.add(getRecuperationInfoRevisionPanel(), VRLayout.NORTH);

    recuperationInfos.add(getRecuperationInfoRevisionTable(), VRLayout.CLIENT);

  }

  /**
   * 特定療養費情報パネルに内部項目を追加します。
   */
  protected void addRecuperationInfoPanel(){

    recuperationInfoPanel.add(getRecuperationInfoLabel(), VRLayout.FLOW);

  }

  /**
   * 特定療養費情報ラベルに内部項目を追加します。
   */
  protected void addRecuperationInfoLabel(){

  }

  /**
   * 特定療養費情報テーブルに内部項目を追加します。
   */
  protected void addRecuperationInfoTable(){

  }

  /**
   * 特定療養費情報テーブルカラムモデルに内部項目を追加します。
   */
  protected void addRecuperationInfoTableColumnModel(){

    getRecuperationInfoTableColumnModel().addColumn(getRecuperationInfoTablecolumn0());

    getRecuperationInfoTableColumnModel().addColumn(getRecuperationInfoTablecolumn1());

    getRecuperationInfoTableColumnModel().addColumn(getRecuperationInfoTablecolumn2());

    getRecuperationInfoTableColumnModel().addColumn(getRecuperationInfoTablecolumn3());

    getRecuperationInfoTableColumnModel().addColumn(getRecuperationInfoTablecolumn4());

    getRecuperationInfoTableColumnModel().addColumn(getRecuperationInfoTablecolumn5());

    getRecuperationInfoTableColumnModel().addColumn(getRecuperationInfoTablecolumn6());

    getRecuperationInfoTableColumnModel().addColumn(getRecuperationInfoTablecolumn7());

    getRecuperationInfoTableColumnModel().addColumn(getRecuperationInfoTablecolumn8());

    getRecuperationInfoTableColumnModel().addColumn(getRecuperationInfoTablecolumn9());

    getRecuperationInfoTableColumnModel().addColumn(getRecuperationInfoTablecolumn10());

    getRecuperationInfoTableColumnModel().addColumn(getRecuperationInfoTablecolumn11());

    getRecuperationInfoTableColumnModel().addColumn(getRecuperationInfoTablecolumn12());

  }

  /**
   * No.に内部項目を追加します。
   */
  protected void addRecuperationInfoTablecolumn0(){

  }

  /**
   * 事業所番号に内部項目を追加します。
   */
  protected void addRecuperationInfoTablecolumn1(){

  }

  /**
   * レコード順次番号に内部項目を追加します。
   */
  protected void addRecuperationInfoTablecolumn2(){

  }

  /**
   * 傷病名に内部項目を追加します。
   */
  protected void addRecuperationInfoTablecolumn3(){

  }

  /**
   * 識別番号に内部項目を追加します。
   */
  protected void addRecuperationInfoTablecolumn4(){

  }

  /**
   * 単位数に内部項目を追加します。
   */
  protected void addRecuperationInfoTablecolumn5(){

  }

  /**
   * 保険回数に内部項目を追加します。
   */
  protected void addRecuperationInfoTablecolumn6(){

  }

  /**
   * 保険サービス単位数に内部項目を追加します。
   */
  protected void addRecuperationInfoTablecolumn7(){

  }

  /**
   * 保険合計単位数に内部項目を追加します。
   */
  protected void addRecuperationInfoTablecolumn8(){

  }

  /**
   * 公費1回数に内部項目を追加します。
   */
  protected void addRecuperationInfoTablecolumn9(){

  }

  /**
   * 公費2回数に内部項目を追加します。
   */
  protected void addRecuperationInfoTablecolumn10(){

  }

  /**
   * 公費3回数に内部項目を追加します。
   */
  protected void addRecuperationInfoTablecolumn11(){

  }

  /**
   * 摘要に内部項目を追加します。
   */
  protected void addRecuperationInfoTablecolumn12(){

  }

  /**
   * 特定療養費情報設定内容修正パネルに内部項目を追加します。
   */
  protected void addRecuperationInfoRevisionPanel(){

    recuperationInfoRevisionPanel.add(getRecuperationInfoRevisionLabel(), null);

    recuperationInfoRevisionPanel.add(getRecuperationInfoRevision(), null);

    recuperationInfoRevisionPanel.add(getRecuperationInfoRevisionCheck(), null);

  }

  /**
   * 特定療養費情報設定内容修正欄ラベルに内部項目を追加します。
   */
  protected void addRecuperationInfoRevisionLabel(){

  }

  /**
   * 特定療養費情報情報に内部項目を追加します。
   */
  protected void addRecuperationInfoRevision(){

  }

  /**
   * 全ての情報を表示に内部項目を追加します。
   */
  protected void addRecuperationInfoRevisionCheck(){

  }

  /**
   * 特定療養費情報情報詳細テーブルに内部項目を追加します。
   */
  protected void addRecuperationInfoRevisionTable(){

  }

  /**
   * 特定療養費情報情報詳細テーブルカラムモデルに内部項目を追加します。
   */
  protected void addRecuperationInfoRevisionTableColumnModel(){

    getRecuperationInfoRevisionTableColumnModel().addColumn(getRecuperationInfoRevisionTablecolumn0());

    getRecuperationInfoRevisionTableColumnModel().addColumn(getRecuperationInfoRevisionTablecolumn1());

    getRecuperationInfoRevisionTableColumnModel().addColumn(getRecuperationInfoRevisionTablecolumn2());

    getRecuperationInfoRevisionTableColumnModel().addColumn(getRecuperationInfoRevisionTablecolumn3());

  }

  /**
   * No.に内部項目を追加します。
   */
  protected void addRecuperationInfoRevisionTablecolumn0(){

  }

  /**
   * 項目名に内部項目を追加します。
   */
  protected void addRecuperationInfoRevisionTablecolumn1(){

  }

  /**
   * 設定値に内部項目を追加します。
   */
  protected void addRecuperationInfoRevisionTablecolumn2(){

  }

  /**
   * コメントに内部項目を追加します。
   */
  protected void addRecuperationInfoRevisionTablecolumn3(){

  }

  /**
   * 明細情報（住所地特例）領域に内部項目を追加します。
   */
  protected void addDetailsJushotiTokureiInfos(){

    detailsJushotiTokureiInfos.add(getDetailsJushotiTokureiPanel(), VRLayout.NORTH);

    detailsJushotiTokureiInfos.add(getDetailsJushotiTokureiInfoTable(), VRLayout.NORTH);

    detailsJushotiTokureiInfos.add(getDetailsJushotiTokureiInfoRevisionPanel(), VRLayout.NORTH);

    detailsJushotiTokureiInfos.add(getDetailsJushotiTokureiInfoRevisionTable(), VRLayout.CLIENT);

  }

  /**
   * 明細情報（住所地特例）パネルに内部項目を追加します。
   */
  protected void addDetailsJushotiTokureiPanel(){

    detailsJushotiTokureiPanel.add(getDetailsJushotiTokureiLabel(), VRLayout.FLOW);

    detailsJushotiTokureiPanel.add(getDetailsJushotiTokureiDelButton(), VRLayout.EAST);
  }

  /**
   * 明細情報（住所地特例）ラベルに内部項目を追加します。
   */
  protected void addDetailsJushotiTokureiLabel(){

  }

  /**
   * サービス削除ボタンに内部項目を追加します。
   */
  protected void addDetailsJushotiTokureiDelButton(){

  }

  /**
   * 明細情報（住所地特例）テーブルに内部項目を追加します。
   */
  protected void addDetailsJushotiTokureiInfoTable(){

  }

  /**
   * 明細情報（住所地特例）テーブルカラムモデルに内部項目を追加します。
   */
  protected void addDetailsJushotiTokureiInfoTableColumnModel(){

    getDetailsJushotiTokureiInfoTableColumnModel().addColumn(getDetailsJushotiTokureiInfoTablecolumn0());

    getDetailsJushotiTokureiInfoTableColumnModel().addColumn(getDetailsJushotiTokureiInfoTablecolumn1());

    getDetailsJushotiTokureiInfoTableColumnModel().addColumn(getDetailsJushotiTokureiInfoTablecolumn2());

    getDetailsJushotiTokureiInfoTableColumnModel().addColumn(getDetailsJushotiTokureiInfoTablecolumn3());

    getDetailsJushotiTokureiInfoTableColumnModel().addColumn(getDetailsJushotiTokureiInfoTablecolumn4());

    getDetailsJushotiTokureiInfoTableColumnModel().addColumn(getDetailsJushotiTokureiInfoTablecolumn5());

    getDetailsJushotiTokureiInfoTableColumnModel().addColumn(getDetailsJushotiTokureiInfoTablecolumn6());

    getDetailsJushotiTokureiInfoTableColumnModel().addColumn(getDetailsJushotiTokureiInfoTablecolumn7());

    getDetailsJushotiTokureiInfoTableColumnModel().addColumn(getDetailsJushotiTokureiInfoTablecolumn8());

    getDetailsJushotiTokureiInfoTableColumnModel().addColumn(getDetailsJushotiTokureiInfoTablecolumn9());

    getDetailsJushotiTokureiInfoTableColumnModel().addColumn(getDetailsJushotiTokureiInfoTablecolumn10());

    getDetailsJushotiTokureiInfoTableColumnModel().addColumn(getDetailsJushotiTokureiInfoTablecolumn11());

    getDetailsJushotiTokureiInfoTableColumnModel().addColumn(getDetailsJushotiTokureiInfoTablecolumn12());

    getDetailsJushotiTokureiInfoTableColumnModel().addColumn(getDetailsJushotiTokureiInfoTablecolumn13());

  }

  /**
   * No.に内部項目を追加します。
   */
  protected void addDetailsJushotiTokureiInfoTablecolumn0(){

  }

  /**
   * サービスコードに内部項目を追加します。
   */
  protected void addDetailsJushotiTokureiInfoTablecolumn1(){

  }

  /**
   * サービス名称に内部項目を追加します。
   */
  protected void addDetailsJushotiTokureiInfoTablecolumn2(){

  }

  /**
   * 単位数に内部項目を追加します。
   */
  protected void addDetailsJushotiTokureiInfoTablecolumn3(){

  }

  /**
   * 日数・回数に内部項目を追加します。
   */
  protected void addDetailsJushotiTokureiInfoTablecolumn4(){

  }

  /**
   * 公費1対象日数・回数に内部項目を追加します。
   */
  protected void addDetailsJushotiTokureiInfoTablecolumn5(){

  }

  /**
   * 公費2対象日数・回数に内部項目を追加します。
   */
  protected void addDetailsJushotiTokureiInfoTablecolumn6(){

  }

  /**
   * 公費3対象日数・回数に内部項目を追加します。
   */
  protected void addDetailsJushotiTokureiInfoTablecolumn7(){

  }

  /**
   * サービス単位数に内部項目を追加します。
   */
  protected void addDetailsJushotiTokureiInfoTablecolumn8(){

  }

  /**
   * 公費1対象サービス単位数に内部項目を追加します。
   */
  protected void addDetailsJushotiTokureiInfoTablecolumn9(){

  }

  /**
   * 公費2対象サービス単位数に内部項目を追加します。
   */
  protected void addDetailsJushotiTokureiInfoTablecolumn10(){

  }

  /**
   * 公費3対象サービス単位数に内部項目を追加します。
   */
  protected void addDetailsJushotiTokureiInfoTablecolumn11(){

  }

  /**
   * 施設所在保険者番号に内部項目を追加します。
   */
  protected void addDetailsJushotiTokureiInfoTablecolumn12(){

  }

  /**
   * 摘要(英数)に内部項目を追加します。
   */
  protected void addDetailsJushotiTokureiInfoTablecolumn13(){

  }

  /**
   * 明細設定内容修正パネルに内部項目を追加します。
   */
  protected void addDetailsJushotiTokureiInfoRevisionPanel(){

    detailsJushotiTokureiInfoRevisionPanel.add(getDetailsJushotiTokureiInfoRevisionLabel(), VRLayout.FLOW);

    detailsJushotiTokureiInfoRevisionPanel.add(getDetailsJushotiTokureiInfoRevision(), VRLayout.FLOW);

    detailsJushotiTokureiInfoRevisionPanel.add(getDetailsJushotiTokureiInfoRevisionCheck(), VRLayout.FLOW);

  }

  /**
   * 設定内容修正欄ラベルに内部項目を追加します。
   */
  protected void addDetailsJushotiTokureiInfoRevisionLabel(){

  }

  /**
   * 明細情報（住所地特例）に内部項目を追加します。
   */
  protected void addDetailsJushotiTokureiInfoRevision(){

  }

  /**
   * 全ての情報を表示に内部項目を追加します。
   */
  protected void addDetailsJushotiTokureiInfoRevisionCheck(){

  }

  /**
   * 明細情報詳細テーブルに内部項目を追加します。
   */
  protected void addDetailsJushotiTokureiInfoRevisionTable(){

  }

  /**
   * 明細情報詳細テーブルカラムモデルに内部項目を追加します。
   */
  protected void addDetailsJushotiTokureiInfoRevisionTableColumnModel(){

    getDetailsJushotiTokureiInfoRevisionTableColumnModel().addColumn(getDetailsJushotiTokureiInfoRevisionTablecolumn0());

    getDetailsJushotiTokureiInfoRevisionTableColumnModel().addColumn(getDetailsJushotiTokureiInfoRevisionTablecolumn1());

    getDetailsJushotiTokureiInfoRevisionTableColumnModel().addColumn(getDetailsJushotiTokureiInfoRevisionTablecolumn2());

    getDetailsJushotiTokureiInfoRevisionTableColumnModel().addColumn(getDetailsJushotiTokureiInfoRevisionTablecolumn3());

  }

  /**
   * No.に内部項目を追加します。
   */
  protected void addDetailsJushotiTokureiInfoRevisionTablecolumn0(){

  }

  /**
   * 項目名に内部項目を追加します。
   */
  protected void addDetailsJushotiTokureiInfoRevisionTablecolumn1(){

  }

  /**
   * 設定値に内部項目を追加します。
   */
  protected void addDetailsJushotiTokureiInfoRevisionTablecolumn2(){

  }

  /**
   * コメントに内部項目を追加します。
   */
  protected void addDetailsJushotiTokureiInfoRevisionTablecolumn3(){

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
      ACFrame.debugStart(new ACAffairInfo(QP005Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QP005Design getThis() {
    return this;
  }
}
