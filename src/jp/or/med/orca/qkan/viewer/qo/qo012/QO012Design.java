
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
 * 開発者: 廣瀬 一海
 * 作成日: 2018/02/20  日本コンピューター株式会社 廣瀬 一海 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム その他機能 (O)
 * プロセス CSVビューア (012)
 * プログラム CSVビューア (QO012)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.viewer.qo.qo012;
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
 * CSVビューア画面項目デザイン(QO012) 
 */
public class QO012Design extends QkanAffairContainer implements ACAffairable {
  //GUIコンポーネント

  private ACAffairButtonBar buttons;

  private ACAffairButton openButton;

  private ACAffairButton unitingButton;

  private ACPanel contents;

  private ACPanel fileInfoPanel;

  private ACGroupBox fileInfoGroup;

  private ACLabel fileTypeLabel;

  private ACLabel fileType;

  private ACLabel mediaTypeLabel;

  private ACLabel mediaType;

  private ACLabel targetYearAndMonthLabel;

  private ACLabel targetYearAndMonth;

  private ACLabel providerLabel;

  private ACLabel providerId;

  private ACLabel providerName;

  private ACTable totalInfoTable;

  private VRTableColumnModel totalInfoTableColumnModel;

  private ACTableColumn totalInfoTableColumn1;

  private ACTableColumn totalInfoTableColumn2;

  private ACTableColumn totalInfoTableColumn3;

  private ACTableColumn totalInfoTableColumn4;

  private ACTableColumn totalInfoTableColumn5;

  private ACTableColumn totalInfoTableColumn6;

  private ACTable csvDataTable;

  private VRTableColumnModel csvDataTableColumnModel;

  private ACTableColumn csvDataTableColumn1;

  private ACTableColumn csvDataTableColumn2;

  private ACTableColumn csvDataTableColumn3;

  private ACTableColumn csvDataTableColumn4;

  private ACTableColumn csvDataTableColumn5;

  private ACTableColumn csvDataTableColumn6;

  private ACTableColumn csvDataTableColumn7;

  private ACTableColumn csvDataTableColumn8;

  private ACTableColumn csvDataTableColumn9;

  private ACTableColumn csvDataTableColumn10;

  private ACTableColumn csvDataTableColumn11;

  private ACTableColumn csvDataTableColumn12;

  private ACTableColumn csvDataTableColumn13;

  private ACTableColumn csvDataTableColumn14;

  private ACTableColumn csvDataTableColumn69;

  private ACTableColumn csvDataTableColumn15;

  private ACTableColumn csvDataTableColumn16;

  private ACTableColumn csvDataTableColumn17;

  private ACTableColumn csvDataTableColumn46;

  private ACTableColumn csvDataTableColumn18;

  private ACTableColumn csvDataTableColumn47;

  private ACTableColumn csvDataTableColumn19;

  private ACTableColumn csvDataTableColumn20;

  private ACTableColumn csvDataTableColumn21;

  private ACTableColumn csvDataTableColumn22;

  private ACTableColumn csvDataTableColumn23;

  private ACTableColumn csvDataTableColumn70;

  private ACTableColumn csvDataTableColumn24;

  private ACTableColumn csvDataTableColumn25;

  private ACTableColumn csvDataTableColumn48;

  private ACTableColumn csvDataTableColumn49;

  private ACTableColumn csvDataTableColumn50;

  private ACTableColumn csvDataTableColumn26;

  private ACTableColumn csvDataTableColumn51;

  private ACTableColumn csvDataTableColumn53;

  private ACTableColumn csvDataTableColumn27;

  private ACTableColumn csvDataTableColumn28;

  private ACTableColumn csvDataTableColumn29;

  private ACTableColumn csvDataTableColumn30;

  private ACTableColumn csvDataTableColumn31;

  private ACTableColumn csvDataTableColumn32;

  private ACTableColumn csvDataTableColumn33;

  private ACTableColumn csvDataTableColumn34;

  private ACTableColumn csvDataTableColumn35;

  private ACTableColumn csvDataTableColumn36;

  private ACTableColumn csvDataTableColumn37;

  private ACTableColumn csvDataTableColumn71;

  private ACTableColumn csvDataTableColumn38;

  private ACTableColumn csvDataTableColumn39;

  private ACTableColumn csvDataTableColumn40;

  private ACTableColumn csvDataTableColumn41;

  private ACTableColumn csvDataTableColumn42;

  private ACTableColumn csvDataTableColumn52;

  private ACTableColumn csvDataTableColumn43;

  private ACTableColumn csvDataTableColumn44;

  private ACTableColumn csvDataTableColumn54;

  private ACTableColumn csvDataTableColumn55;

  private ACTableColumn csvDataTableColumn56;

  private ACTableColumn csvDataTableColumn57;

  private ACTableColumn csvDataTableColumn58;

  private ACTableColumn csvDataTableColumn59;

  private ACTableColumn csvDataTableColumn60;

  private ACTableColumn csvDataTableColumn61;

  private ACTableColumn csvDataTableColumn62;

  private ACTableColumn csvDataTableColumn63;

  private ACTableColumn csvDataTableColumn64;

  private ACTableColumn csvDataTableColumn65;

  private ACTableColumn csvDataTableColumn66;

  private ACTableColumn csvDataTableColumn67;

  private ACTableColumn csvDataTableColumn68;

  private ACTableColumn csvDataTableColumn45;

  //getter

  /**
   * 業務ボタンバーを取得します。
   * @return 業務ボタンバー
   */
  public ACAffairButtonBar getButtons(){
    if(buttons==null){

      buttons = new ACAffairButtonBar();

      buttons.setText("給付管理/介護報酬請求 CSVファイルビューア");

      buttons.setBackVisible(false);

      addButtons();
    }
    return buttons;

  }

  /**
   * 開くを取得します。
   * @return 開く
   */
  public ACAffairButton getOpenButton(){
    if(openButton==null){

      openButton = new ACAffairButton();

      openButton.setText("開く(O)");

      openButton.setMnemonic('O');

      openButton.setIconPath(ACConstants.ICON_PATH_OPEN_24);

      addOpenButton();
    }
    return openButton;

  }

  /**
   * 結合を取得します。
   * @return 結合
   */
  public ACAffairButton getUnitingButton(){
    if(unitingButton==null){

      unitingButton = new ACAffairButton();

      unitingButton.setText("結合(U)");

      unitingButton.setMnemonic('U');

      unitingButton.setIconPath(ACConstants.ICON_PATH_COPY_24);

      addUnitingButton();
    }
    return unitingButton;

  }

  /**
   * クライアント領域を取得します。
   * @return クライアント領域
   */
  public ACPanel getContents(){
    if(contents==null){

      contents = new ACPanel();

      addContents();
    }
    return contents;

  }

  /**
   * 共通領域を取得します。
   * @return 共通領域
   */
  public ACPanel getFileInfoPanel(){
    if(fileInfoPanel==null){

      fileInfoPanel = new ACPanel();

      fileInfoPanel.setAutoWrap(false);

      addFileInfoPanel();
    }
    return fileInfoPanel;

  }

  /**
   * ファイル情報グループを取得します。
   * @return ファイル情報グループ
   */
  public ACGroupBox getFileInfoGroup(){
    if(fileInfoGroup==null){

      fileInfoGroup = new ACGroupBox();

      fileInfoGroup.setText("ファイル情報");

      addFileInfoGroup();
    }
    return fileInfoGroup;

  }

  /**
   * 種類ラベルを取得します。
   * @return 種類ラベル
   */
  public ACLabel getFileTypeLabel(){
    if(fileTypeLabel==null){

      fileTypeLabel = new ACLabel();

      fileTypeLabel.setText("【　種　類　】");

      addFileTypeLabel();
    }
    return fileTypeLabel;

  }

  /**
   * 種類を取得します。
   * @return 種類
   */
  public ACLabel getFileType(){
    if(fileType==null){

      fileType = new ACLabel();

      fileType.setBindPath("FILE_TYPE");

      addFileType();
    }
    return fileType;

  }

  /**
   * 媒体ラベルを取得します。
   * @return 媒体ラベル
   */
  public ACLabel getMediaTypeLabel(){
    if(mediaTypeLabel==null){

      mediaTypeLabel = new ACLabel();

      mediaTypeLabel.setText("【　媒　体　】");

      addMediaTypeLabel();
    }
    return mediaTypeLabel;

  }

  /**
   * 媒体を取得します。
   * @return 媒体
   */
  public ACLabel getMediaType(){
    if(mediaType==null){

      mediaType = new ACLabel();

      mediaType.setBindPath("MEDIA_TYPE");

      addMediaType();
    }
    return mediaType;

  }

  /**
   * 処理対象年月ラベルを取得します。
   * @return 処理対象年月ラベル
   */
  public ACLabel getTargetYearAndMonthLabel(){
    if(targetYearAndMonthLabel==null){

      targetYearAndMonthLabel = new ACLabel();

      targetYearAndMonthLabel.setText("【処理対象月】");

      addTargetYearAndMonthLabel();
    }
    return targetYearAndMonthLabel;

  }

  /**
   * 処理対象年月を取得します。
   * @return 処理対象年月
   */
  public ACLabel getTargetYearAndMonth(){
    if(targetYearAndMonth==null){

      targetYearAndMonth = new ACLabel();

      targetYearAndMonth.setBindPath("TARGET_MONTH");

      targetYearAndMonth.setFormat(new ACBorderBlankDateFormat("yyyy年MM月"));

      addTargetYearAndMonth();
    }
    return targetYearAndMonth;

  }

  /**
   * 事業所ラベルを取得します。
   * @return 事業所ラベル
   */
  public ACLabel getProviderLabel(){
    if(providerLabel==null){

      providerLabel = new ACLabel();

      providerLabel.setText("【事　業　所】");

      addProviderLabel();
    }
    return providerLabel;

  }

  /**
   * 事業所番号を取得します。
   * @return 事業所番号
   */
  public ACLabel getProviderId(){
    if(providerId==null){

      providerId = new ACLabel();

      providerId.setBindPath("PROVIDER_ID");

      addProviderId();
    }
    return providerId;

  }

  /**
   * 事業所名称を取得します。
   * @return 事業所名称
   */
  public ACLabel getProviderName(){
    if(providerName==null){

      providerName = new ACLabel();

      providerName.setBindPath("PROVIDER_NAME");

      addProviderName();
    }
    return providerName;

  }

  /**
   * 集計情報テーブルを取得します。
   * @return 集計情報テーブル
   */
  public ACTable getTotalInfoTable(){
    if(totalInfoTable==null){

      totalInfoTable = new ACTable();

      totalInfoTable.setColumnModel(getTotalInfoTableColumnModel());

      totalInfoTable.setColumnSort(true);

      totalInfoTable.setRows(3);

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
   * 月カラムを取得します。
   * @return 月カラム
   */
  public ACTableColumn getTotalInfoTableColumn1(){
    if(totalInfoTableColumn1==null){

      totalInfoTableColumn1 = new ACTableColumn();

      totalInfoTableColumn1.setHeaderValue("月分");

      totalInfoTableColumn1.setColumnName("TOTAL1");

      totalInfoTableColumn1.setEditable(false);

      totalInfoTableColumn1.setColumns(10);

      totalInfoTableColumn1.setFormat(new ACBorderBlankDateFormat("yyyy年MM月"));

      addTotalInfoTableColumn1();
    }
    return totalInfoTableColumn1;

  }

  /**
   * 人数カラムを取得します。
   * @return 人数カラム
   */
  public ACTableColumn getTotalInfoTableColumn2(){
    if(totalInfoTableColumn2==null){

      totalInfoTableColumn2 = new ACTableColumn();

      totalInfoTableColumn2.setHeaderValue("人数");

      totalInfoTableColumn2.setColumnName("TOTAL2");

      totalInfoTableColumn2.setEditable(false);

      totalInfoTableColumn2.setColumns(10);

      addTotalInfoTableColumn2();
    }
    return totalInfoTableColumn2;

  }

  /**
   * サービス件数カラムを取得します。
   * @return サービス件数カラム
   */
  public ACTableColumn getTotalInfoTableColumn3(){
    if(totalInfoTableColumn3==null){

      totalInfoTableColumn3 = new ACTableColumn();

      totalInfoTableColumn3.setHeaderValue("サービス件数");

      totalInfoTableColumn3.setColumnName("TOTAL3");

      totalInfoTableColumn3.setEditable(false);

      totalInfoTableColumn3.setColumns(10);

      addTotalInfoTableColumn3();
    }
    return totalInfoTableColumn3;

  }

  /**
   * ケアプラン件数カラムを取得します。
   * @return ケアプラン件数カラム
   */
  public ACTableColumn getTotalInfoTableColumn4(){
    if(totalInfoTableColumn4==null){

      totalInfoTableColumn4 = new ACTableColumn();

      totalInfoTableColumn4.setHeaderValue("ケアプラン件数");

      totalInfoTableColumn4.setColumnName("TOTAL4");

      totalInfoTableColumn4.setEditable(false);

      totalInfoTableColumn4.setColumns(10);

      addTotalInfoTableColumn4();
    }
    return totalInfoTableColumn4;

  }

  /**
   * 単位数カラムを取得します。
   * @return 単位数カラム
   */
  public ACTableColumn getTotalInfoTableColumn5(){
    if(totalInfoTableColumn5==null){

      totalInfoTableColumn5 = new ACTableColumn();

      totalInfoTableColumn5.setHeaderValue("単位数");

      totalInfoTableColumn5.setColumnName("TOTAL5");

      totalInfoTableColumn5.setEditable(false);

      totalInfoTableColumn5.setColumns(10);

      addTotalInfoTableColumn5();
    }
    return totalInfoTableColumn5;

  }

  /**
   * 保険請求額カラムを取得します。
   * @return 保険請求額カラム
   */
  public ACTableColumn getTotalInfoTableColumn6(){
    if(totalInfoTableColumn6==null){

      totalInfoTableColumn6 = new ACTableColumn();

      totalInfoTableColumn6.setHeaderValue("保険／事業費請求額");

      totalInfoTableColumn6.setColumnName("TOTAL6");

      totalInfoTableColumn6.setEditable(false);

      totalInfoTableColumn6.setColumns(10);

      addTotalInfoTableColumn6();
    }
    return totalInfoTableColumn6;

  }

  /**
   * CSVデータテーブルを取得します。
   * @return CSVデータテーブル
   */
  public ACTable getCsvDataTable(){
    if(csvDataTable==null){

      csvDataTable = new ACTable();

      csvDataTable.setColumnModel(getCsvDataTableColumnModel());

      csvDataTable.setColumnSort(true);

      csvDataTable.setHeaderRows(5);

      addCsvDataTable();
    }
    return csvDataTable;

  }

  /**
   * CSVデータテーブルカラムモデルを取得します。
   * @return CSVデータテーブルカラムモデル
   */
  protected VRTableColumnModel getCsvDataTableColumnModel(){
    if(csvDataTableColumnModel==null){
      csvDataTableColumnModel = new VRTableColumnModel(new TableColumn[]{});
      addCsvDataTableColumnModel();
    }
    return csvDataTableColumnModel;
  }

  /**
   * 年月カラムを取得します。
   * @return 年月カラム
   */
  public ACTableColumn getCsvDataTableColumn1(){
    if(csvDataTableColumn1==null){

      csvDataTableColumn1 = new ACTableColumn();

      csvDataTableColumn1.setHeaderValue("年月");

      csvDataTableColumn1.setColumnName("YEAR_AND_MONTH");

      csvDataTableColumn1.setEditable(false);

      csvDataTableColumn1.setColumns(8);

      csvDataTableColumn1.setFormat(new ACBorderBlankDateFormat("yyyy年MM月"));

      csvDataTableColumn1.setRendererType(VRTableCellViewer.RENDERER_TYPE_LABEL);

      addCsvDataTableColumn1();
    }
    return csvDataTableColumn1;

  }

  /**
   * 被保険者番号カラムを取得します。
   * @return 被保険者番号カラム
   */
  public ACTableColumn getCsvDataTableColumn2(){
    if(csvDataTableColumn2==null){

      csvDataTableColumn2 = new ACTableColumn();

      csvDataTableColumn2.setHeaderValue("被保険者番号");

      csvDataTableColumn2.setColumnName("INSURED_ID");

      csvDataTableColumn2.setEditable(false);

      csvDataTableColumn2.setColumns(8);

      csvDataTableColumn2.setRendererType(VRTableCellViewer.RENDERER_TYPE_LABEL);

      addCsvDataTableColumn2();
    }
    return csvDataTableColumn2;

  }

  /**
   * 氏名カラムを取得します。
   * @return 氏名カラム
   */
  public ACTableColumn getCsvDataTableColumn3(){
    if(csvDataTableColumn3==null){

      csvDataTableColumn3 = new ACTableColumn();

      csvDataTableColumn3.setHeaderValue("氏名");

      csvDataTableColumn3.setColumnName("NAME");

      csvDataTableColumn3.setEditable(false);

      csvDataTableColumn3.setColumns(8);

      csvDataTableColumn3.setRendererType(VRTableCellViewer.RENDERER_TYPE_LABEL);

      addCsvDataTableColumn3();
    }
    return csvDataTableColumn3;

  }

  /**
   * 要介護度カラムを取得します。
   * @return 要介護度カラム
   */
  public ACTableColumn getCsvDataTableColumn4(){
    if(csvDataTableColumn4==null){

      csvDataTableColumn4 = new ACTableColumn();

      csvDataTableColumn4.setHeaderValue("要介護度");

      csvDataTableColumn4.setColumnName("CARE_LEVEL");

      csvDataTableColumn4.setEditable(false);

      csvDataTableColumn4.setColumns(8);

      csvDataTableColumn4.setRendererType(VRTableCellViewer.RENDERER_TYPE_LABEL);

      addCsvDataTableColumn4();
    }
    return csvDataTableColumn4;

  }

  /**
   * 訪介カラムを取得します。
   * @return 訪介カラム
   */
  public ACTableColumn getCsvDataTableColumn5(){
    if(csvDataTableColumn5==null){

      csvDataTableColumn5 = new ACTableColumn();

      csvDataTableColumn5.setHeaderValue("<html>11<br>訪<br>介<br><br>　</html>");

      csvDataTableColumn5.setColumnName("11");

      csvDataTableColumn5.setEditable(false);

      csvDataTableColumn5.setColumns(3);

      csvDataTableColumn5.setRendererType(VRTableCellViewer.RENDERER_TYPE_LABEL);

      addCsvDataTableColumn5();
    }
    return csvDataTableColumn5;

  }

  /**
   * 入浴カラムを取得します。
   * @return 入浴カラム
   */
  public ACTableColumn getCsvDataTableColumn6(){
    if(csvDataTableColumn6==null){

      csvDataTableColumn6 = new ACTableColumn();

      csvDataTableColumn6.setHeaderValue("<html>12<br>入<br>浴<br><br>　</html>");

      csvDataTableColumn6.setColumnName("12");

      csvDataTableColumn6.setEditable(false);

      csvDataTableColumn6.setColumns(3);

      csvDataTableColumn6.setRendererType(VRTableCellViewer.RENDERER_TYPE_LABEL);

      addCsvDataTableColumn6();
    }
    return csvDataTableColumn6;

  }

  /**
   * 看介カラムを取得します。
   * @return 看介カラム
   */
  public ACTableColumn getCsvDataTableColumn7(){
    if(csvDataTableColumn7==null){

      csvDataTableColumn7 = new ACTableColumn();

      csvDataTableColumn7.setHeaderValue("<html>13<br>看<br>介<br><br>　</html>");

      csvDataTableColumn7.setColumnName("13");

      csvDataTableColumn7.setEditable(false);

      csvDataTableColumn7.setColumns(3);

      csvDataTableColumn7.setRendererType(VRTableCellViewer.RENDERER_TYPE_LABEL);

      addCsvDataTableColumn7();
    }
    return csvDataTableColumn7;

  }

  /**
   * 訪リカラムを取得します。
   * @return 訪リカラム
   */
  public ACTableColumn getCsvDataTableColumn8(){
    if(csvDataTableColumn8==null){

      csvDataTableColumn8 = new ACTableColumn();

      csvDataTableColumn8.setHeaderValue("<html>14<br>訪<br>リ<br><br>　</html>");

      csvDataTableColumn8.setColumnName("14");

      csvDataTableColumn8.setEditable(false);

      csvDataTableColumn8.setColumns(3);

      csvDataTableColumn8.setRendererType(VRTableCellViewer.RENDERER_TYPE_LABEL);

      addCsvDataTableColumn8();
    }
    return csvDataTableColumn8;

  }

  /**
   * 通介カラムを取得します。
   * @return 通介カラム
   */
  public ACTableColumn getCsvDataTableColumn9(){
    if(csvDataTableColumn9==null){

      csvDataTableColumn9 = new ACTableColumn();

      csvDataTableColumn9.setHeaderValue("<html>15<br>通<br>介<br><br>　</html>");

      csvDataTableColumn9.setColumnName("15");

      csvDataTableColumn9.setEditable(false);

      csvDataTableColumn9.setColumns(3);

      csvDataTableColumn9.setRendererType(VRTableCellViewer.RENDERER_TYPE_LABEL);

      addCsvDataTableColumn9();
    }
    return csvDataTableColumn9;

  }

  /**
   * 通リカラムを取得します。
   * @return 通リカラム
   */
  public ACTableColumn getCsvDataTableColumn10(){
    if(csvDataTableColumn10==null){

      csvDataTableColumn10 = new ACTableColumn();

      csvDataTableColumn10.setHeaderValue("<html>16<br>通<br>リ<br><br>　</html>");

      csvDataTableColumn10.setColumnName("16");

      csvDataTableColumn10.setEditable(false);

      csvDataTableColumn10.setColumns(3);

      csvDataTableColumn10.setRendererType(VRTableCellViewer.RENDERER_TYPE_LABEL);

      addCsvDataTableColumn10();
    }
    return csvDataTableColumn10;

  }

  /**
   * 用具カラムを取得します。
   * @return 用具カラム
   */
  public ACTableColumn getCsvDataTableColumn11(){
    if(csvDataTableColumn11==null){

      csvDataTableColumn11 = new ACTableColumn();

      csvDataTableColumn11.setHeaderValue("<html>17<br>用<br>具<br><br>　</html>");

      csvDataTableColumn11.setColumnName("17");

      csvDataTableColumn11.setEditable(false);

      csvDataTableColumn11.setColumns(3);

      csvDataTableColumn11.setRendererType(VRTableCellViewer.RENDERER_TYPE_LABEL);

      addCsvDataTableColumn11();
    }
    return csvDataTableColumn11;

  }

  /**
   * 短生カラムを取得します。
   * @return 短生カラム
   */
  public ACTableColumn getCsvDataTableColumn12(){
    if(csvDataTableColumn12==null){

      csvDataTableColumn12 = new ACTableColumn();

      csvDataTableColumn12.setHeaderValue("<html>21<br>短<br>生<br><br>　</html>");

      csvDataTableColumn12.setColumnName("21");

      csvDataTableColumn12.setEditable(false);

      csvDataTableColumn12.setColumns(3);

      csvDataTableColumn12.setRendererType(VRTableCellViewer.RENDERER_TYPE_LABEL);

      addCsvDataTableColumn12();
    }
    return csvDataTableColumn12;

  }

  /**
   * 短老カラムを取得します。
   * @return 短老カラム
   */
  public ACTableColumn getCsvDataTableColumn13(){
    if(csvDataTableColumn13==null){

      csvDataTableColumn13 = new ACTableColumn();

      csvDataTableColumn13.setHeaderValue("<html>22<br>短<br>老<br><br>　</html>");

      csvDataTableColumn13.setColumnName("22");

      csvDataTableColumn13.setEditable(false);

      csvDataTableColumn13.setColumns(3);

      csvDataTableColumn13.setRendererType(VRTableCellViewer.RENDERER_TYPE_LABEL);

      addCsvDataTableColumn13();
    }
    return csvDataTableColumn13;

  }

  /**
   * 短医カラムを取得します。
   * @return 短医カラム
   */
  public ACTableColumn getCsvDataTableColumn14(){
    if(csvDataTableColumn14==null){

      csvDataTableColumn14 = new ACTableColumn();

      csvDataTableColumn14.setHeaderValue("<html>23<br>短<br>医<br><br>　</html>");

      csvDataTableColumn14.setColumnName("23");

      csvDataTableColumn14.setEditable(false);

      csvDataTableColumn14.setColumns(3);

      csvDataTableColumn14.setRendererType(VRTableCellViewer.RENDERER_TYPE_LABEL);

      addCsvDataTableColumn14();
    }
    return csvDataTableColumn14;

  }

  /**
   * 短介医カラムを取得します。
   * @return 短介医カラム
   */
  public ACTableColumn getCsvDataTableColumn69(){
    if(csvDataTableColumn69==null){

      csvDataTableColumn69 = new ACTableColumn();

      csvDataTableColumn69.setHeaderValue("<html>2A<br>短<br>介<br>医<br>　</html>");

      csvDataTableColumn69.setColumnName("2A");

      csvDataTableColumn69.setEditable(false);

      csvDataTableColumn69.setColumns(3);

      csvDataTableColumn69.setRendererType(VRTableCellViewer.RENDERER_TYPE_LABEL);

      addCsvDataTableColumn69();
    }
    return csvDataTableColumn69;

  }

  /**
   * 居宅カラムを取得します。
   * @return 居宅カラム
   */
  public ACTableColumn getCsvDataTableColumn15(){
    if(csvDataTableColumn15==null){

      csvDataTableColumn15 = new ACTableColumn();

      csvDataTableColumn15.setHeaderValue("<html>31<br>居<br>宅<br><br>　</html>");

      csvDataTableColumn15.setColumnName("31");

      csvDataTableColumn15.setEditable(false);

      csvDataTableColumn15.setColumns(3);

      csvDataTableColumn15.setRendererType(VRTableCellViewer.RENDERER_TYPE_LABEL);

      addCsvDataTableColumn15();
    }
    return csvDataTableColumn15;

  }

  /**
   * 認知カラムを取得します。
   * @return 認知カラム
   */
  public ACTableColumn getCsvDataTableColumn16(){
    if(csvDataTableColumn16==null){

      csvDataTableColumn16 = new ACTableColumn();

      csvDataTableColumn16.setHeaderValue("<html>32<br>認<br>知<br><br>　</html>");

      csvDataTableColumn16.setColumnName("32");

      csvDataTableColumn16.setEditable(false);

      csvDataTableColumn16.setColumns(3);

      csvDataTableColumn16.setRendererType(VRTableCellViewer.RENDERER_TYPE_LABEL);

      addCsvDataTableColumn16();
    }
    return csvDataTableColumn16;

  }

  /**
   * 特定カラムを取得します。
   * @return 特定カラム
   */
  public ACTableColumn getCsvDataTableColumn17(){
    if(csvDataTableColumn17==null){

      csvDataTableColumn17 = new ACTableColumn();

      csvDataTableColumn17.setHeaderValue("<html>33<br>特<br>定<br><br>　</html>");

      csvDataTableColumn17.setColumnName("33");

      csvDataTableColumn17.setEditable(false);

      csvDataTableColumn17.setColumns(3);

      csvDataTableColumn17.setRendererType(VRTableCellViewer.RENDERER_TYPE_LABEL);

      addCsvDataTableColumn17();
    }
    return csvDataTableColumn17;

  }

  /**
   * 特定短カラムを取得します。
   * @return 特定短カラム
   */
  public ACTableColumn getCsvDataTableColumn46(){
    if(csvDataTableColumn46==null){

      csvDataTableColumn46 = new ACTableColumn();

      csvDataTableColumn46.setHeaderValue("<html>27<br>特<br>定<br>短<br>　</html>");

      csvDataTableColumn46.setColumnName("27");

      csvDataTableColumn46.setEditable(false);

      csvDataTableColumn46.setColumns(3);

      csvDataTableColumn46.setRendererType(VRTableCellViewer.RENDERER_TYPE_LABEL);

      addCsvDataTableColumn46();
    }
    return csvDataTableColumn46;

  }

  /**
   * 地特カラムを取得します。
   * @return 地特カラム
   */
  public ACTableColumn getCsvDataTableColumn18(){
    if(csvDataTableColumn18==null){

      csvDataTableColumn18 = new ACTableColumn();

      csvDataTableColumn18.setHeaderValue("<html>36<br>地<br>特<br><br>　</html>");

      csvDataTableColumn18.setColumnName("36");

      csvDataTableColumn18.setEditable(false);

      csvDataTableColumn18.setColumns(3);

      csvDataTableColumn18.setRendererType(VRTableCellViewer.RENDERER_TYPE_LABEL);

      addCsvDataTableColumn18();
    }
    return csvDataTableColumn18;

  }

  /**
   * 地特短カラムを取得します。
   * @return 地特短カラム
   */
  public ACTableColumn getCsvDataTableColumn47(){
    if(csvDataTableColumn47==null){

      csvDataTableColumn47 = new ACTableColumn();

      csvDataTableColumn47.setHeaderValue("<html>28<br>地<br>特<br>短<br>　</html>");

      csvDataTableColumn47.setColumnName("28");

      csvDataTableColumn47.setEditable(false);

      csvDataTableColumn47.setColumns(3);

      csvDataTableColumn47.setRendererType(VRTableCellViewer.RENDERER_TYPE_LABEL);

      addCsvDataTableColumn47();
    }
    return csvDataTableColumn47;

  }

  /**
   * 認短カラムを取得します。
   * @return 認短カラム
   */
  public ACTableColumn getCsvDataTableColumn19(){
    if(csvDataTableColumn19==null){

      csvDataTableColumn19 = new ACTableColumn();

      csvDataTableColumn19.setHeaderValue("<html>38<br>認<br>短<br><br>　</html>");

      csvDataTableColumn19.setColumnName("38");

      csvDataTableColumn19.setEditable(false);

      csvDataTableColumn19.setColumns(3);

      csvDataTableColumn19.setRendererType(VRTableCellViewer.RENDERER_TYPE_LABEL);

      addCsvDataTableColumn19();
    }
    return csvDataTableColumn19;

  }

  /**
   * 特養カラムを取得します。
   * @return 特養カラム
   */
  public ACTableColumn getCsvDataTableColumn20(){
    if(csvDataTableColumn20==null){

      csvDataTableColumn20 = new ACTableColumn();

      csvDataTableColumn20.setHeaderValue("<html>51<br>特<br>養<br><br>　</html>");

      csvDataTableColumn20.setColumnName("51");

      csvDataTableColumn20.setEditable(false);

      csvDataTableColumn20.setColumns(3);

      csvDataTableColumn20.setRendererType(VRTableCellViewer.RENDERER_TYPE_LABEL);

      addCsvDataTableColumn20();
    }
    return csvDataTableColumn20;

  }

  /**
   * 老健カラムを取得します。
   * @return 老健カラム
   */
  public ACTableColumn getCsvDataTableColumn21(){
    if(csvDataTableColumn21==null){

      csvDataTableColumn21 = new ACTableColumn();

      csvDataTableColumn21.setHeaderValue("<html>52<br>老<br>健<br><br>　</html>");

      csvDataTableColumn21.setColumnName("52");

      csvDataTableColumn21.setEditable(false);

      csvDataTableColumn21.setColumns(3);

      csvDataTableColumn21.setRendererType(VRTableCellViewer.RENDERER_TYPE_LABEL);

      addCsvDataTableColumn21();
    }
    return csvDataTableColumn21;

  }

  /**
   * 療養カラムを取得します。
   * @return 療養カラム
   */
  public ACTableColumn getCsvDataTableColumn22(){
    if(csvDataTableColumn22==null){

      csvDataTableColumn22 = new ACTableColumn();

      csvDataTableColumn22.setHeaderValue("<html>53<br>療<br>養<br><br>　</html>");

      csvDataTableColumn22.setColumnName("53");

      csvDataTableColumn22.setEditable(false);

      csvDataTableColumn22.setColumns(3);

      csvDataTableColumn22.setRendererType(VRTableCellViewer.RENDERER_TYPE_LABEL);

      addCsvDataTableColumn22();
    }
    return csvDataTableColumn22;

  }

  /**
   * 地養カラムを取得します。
   * @return 地養カラム
   */
  public ACTableColumn getCsvDataTableColumn23(){
    if(csvDataTableColumn23==null){

      csvDataTableColumn23 = new ACTableColumn();

      csvDataTableColumn23.setHeaderValue("<html>54<br>地<br>養<br><br>　</html>");

      csvDataTableColumn23.setColumnName("54");

      csvDataTableColumn23.setEditable(false);

      csvDataTableColumn23.setColumns(3);

      csvDataTableColumn23.setRendererType(VRTableCellViewer.RENDERER_TYPE_LABEL);

      addCsvDataTableColumn23();
    }
    return csvDataTableColumn23;

  }

  /**
   * 介医カラムを取得します。
   * @return 介医カラム
   */
  public ACTableColumn getCsvDataTableColumn70(){
    if(csvDataTableColumn70==null){

      csvDataTableColumn70 = new ACTableColumn();

      csvDataTableColumn70.setHeaderValue("<html>55<br>介<br>医<br><br>　</html>");

      csvDataTableColumn70.setColumnName("55");

      csvDataTableColumn70.setEditable(false);

      csvDataTableColumn70.setColumns(3);

      csvDataTableColumn70.setRendererType(VRTableCellViewer.RENDERER_TYPE_LABEL);

      addCsvDataTableColumn70();
    }
    return csvDataTableColumn70;

  }

  /**
   * 夜介カラムを取得します。
   * @return 夜介カラム
   */
  public ACTableColumn getCsvDataTableColumn24(){
    if(csvDataTableColumn24==null){

      csvDataTableColumn24 = new ACTableColumn();

      csvDataTableColumn24.setHeaderValue("<html>71<br>夜<br>介<br><br>　</html>");

      csvDataTableColumn24.setColumnName("71");

      csvDataTableColumn24.setEditable(false);

      csvDataTableColumn24.setColumns(3);

      csvDataTableColumn24.setRendererType(VRTableCellViewer.RENDERER_TYPE_LABEL);

      addCsvDataTableColumn24();
    }
    return csvDataTableColumn24;

  }

  /**
   * 認通カラムを取得します。
   * @return 認通カラム
   */
  public ACTableColumn getCsvDataTableColumn25(){
    if(csvDataTableColumn25==null){

      csvDataTableColumn25 = new ACTableColumn();

      csvDataTableColumn25.setHeaderValue("<html>72<br>認<br>通<br><br>　</html>");

      csvDataTableColumn25.setColumnName("72");

      csvDataTableColumn25.setEditable(false);

      csvDataTableColumn25.setColumns(3);

      csvDataTableColumn25.setRendererType(VRTableCellViewer.RENDERER_TYPE_LABEL);

      addCsvDataTableColumn25();
    }
    return csvDataTableColumn25;

  }

  /**
   * 定訪看カラムを取得します。
   * @return 定訪看カラム
   */
  public ACTableColumn getCsvDataTableColumn48(){
    if(csvDataTableColumn48==null){

      csvDataTableColumn48 = new ACTableColumn();

      csvDataTableColumn48.setHeaderValue("<html>76<br>定<br>巡<br>訪<br>　</html>");

      csvDataTableColumn48.setColumnName("76");

      csvDataTableColumn48.setEditable(false);

      csvDataTableColumn48.setColumns(3);

      csvDataTableColumn48.setRendererType(VRTableCellViewer.RENDERER_TYPE_LABEL);

      addCsvDataTableColumn48();
    }
    return csvDataTableColumn48;

  }

  /**
   * 複合カラムを取得します。
   * @return 複合カラム
   */
  public ACTableColumn getCsvDataTableColumn49(){
    if(csvDataTableColumn49==null){

      csvDataTableColumn49 = new ACTableColumn();

      csvDataTableColumn49.setHeaderValue("<html>77<br>複<br>合<br><br>　</html>");

      csvDataTableColumn49.setColumnName("77");

      csvDataTableColumn49.setEditable(false);

      csvDataTableColumn49.setColumns(3);

      csvDataTableColumn49.setRendererType(VRTableCellViewer.RENDERER_TYPE_LABEL);

      addCsvDataTableColumn49();
    }
    return csvDataTableColumn49;

  }

  /**
   * 複合短カラムを取得します。
   * @return 複合短カラム
   */
  public ACTableColumn getCsvDataTableColumn50(){
    if(csvDataTableColumn50==null){

      csvDataTableColumn50 = new ACTableColumn();

      csvDataTableColumn50.setHeaderValue("<html>79<br>複<br>合<br>短<br>　</html>");

      csvDataTableColumn50.setColumnName("79");

      csvDataTableColumn50.setEditable(false);

      csvDataTableColumn50.setColumns(3);

      csvDataTableColumn50.setRendererType(VRTableCellViewer.RENDERER_TYPE_LABEL);

      addCsvDataTableColumn50();
    }
    return csvDataTableColumn50;

  }

  /**
   * 小規模多機能カラムを取得します。
   * @return 小規模多機能カラム
   */
  public ACTableColumn getCsvDataTableColumn26(){
    if(csvDataTableColumn26==null){

      csvDataTableColumn26 = new ACTableColumn();

      csvDataTableColumn26.setHeaderValue("<html>73<br>居<br>介<br><br>　</html>");

      csvDataTableColumn26.setColumnName("73");

      csvDataTableColumn26.setEditable(false);

      csvDataTableColumn26.setColumns(3);

      csvDataTableColumn26.setRendererType(VRTableCellViewer.RENDERER_TYPE_LABEL);

      addCsvDataTableColumn26();
    }
    return csvDataTableColumn26;

  }

  /**
   * 小規模多機能短カラムを取得します。
   * @return 小規模多機能短カラム
   */
  public ACTableColumn getCsvDataTableColumn51(){
    if(csvDataTableColumn51==null){

      csvDataTableColumn51 = new ACTableColumn();

      csvDataTableColumn51.setHeaderValue("<html>68<br>居<br>短<br><br>　</html>");

      csvDataTableColumn51.setColumnName("68");

      csvDataTableColumn51.setEditable(false);

      csvDataTableColumn51.setColumns(3);

      csvDataTableColumn51.setRendererType(VRTableCellViewer.RENDERER_TYPE_LABEL);

      addCsvDataTableColumn51();
    }
    return csvDataTableColumn51;

  }

  /**
   * 地通介カラムを取得します。
   * @return 地通介カラム
   */
  public ACTableColumn getCsvDataTableColumn53(){
    if(csvDataTableColumn53==null){

      csvDataTableColumn53 = new ACTableColumn();

      csvDataTableColumn53.setHeaderValue("<html>78<br>地<br>通<br>介<br>　</html>");

      csvDataTableColumn53.setColumnName("78");

      csvDataTableColumn53.setEditable(false);

      csvDataTableColumn53.setColumns(3);

      csvDataTableColumn53.setRendererType(VRTableCellViewer.RENDERER_TYPE_LABEL);

      addCsvDataTableColumn53();
    }
    return csvDataTableColumn53;

  }

  /**
   * プランカラムを取得します。
   * @return プランカラム
   */
  public ACTableColumn getCsvDataTableColumn27(){
    if(csvDataTableColumn27==null){

      csvDataTableColumn27 = new ACTableColumn();

      csvDataTableColumn27.setHeaderValue("<html>43<br>プ<br>ラ<br>ン<br>　</html>");

      csvDataTableColumn27.setColumnName("43");

      csvDataTableColumn27.setEditable(false);

      csvDataTableColumn27.setColumns(3);

      csvDataTableColumn27.setRendererType(VRTableCellViewer.RENDERER_TYPE_LABEL);

      addCsvDataTableColumn27();
    }
    return csvDataTableColumn27;

  }

  /**
   * 予防介カラムを取得します。
   * @return 予防介カラム
   */
  public ACTableColumn getCsvDataTableColumn28(){
    if(csvDataTableColumn28==null){

      csvDataTableColumn28 = new ACTableColumn();

      csvDataTableColumn28.setHeaderValue("<html>61<br>予<br>防<br>介<br>　</html>");

      csvDataTableColumn28.setColumnName("61");

      csvDataTableColumn28.setEditable(false);

      csvDataTableColumn28.setColumns(3);

      csvDataTableColumn28.setRendererType(VRTableCellViewer.RENDERER_TYPE_LABEL);

      addCsvDataTableColumn28();
    }
    return csvDataTableColumn28;

  }

  /**
   * 予入浴カラムを取得します。
   * @return 予入浴カラム
   */
  public ACTableColumn getCsvDataTableColumn29(){
    if(csvDataTableColumn29==null){

      csvDataTableColumn29 = new ACTableColumn();

      csvDataTableColumn29.setHeaderValue("<html>62<br>予<br>入<br>浴<br>　</html>");

      csvDataTableColumn29.setColumnName("62");

      csvDataTableColumn29.setEditable(false);

      csvDataTableColumn29.setColumns(3);

      csvDataTableColumn29.setRendererType(VRTableCellViewer.RENDERER_TYPE_LABEL);

      addCsvDataTableColumn29();
    }
    return csvDataTableColumn29;

  }

  /**
   * 予看介カラムを取得します。
   * @return 予看介カラム
   */
  public ACTableColumn getCsvDataTableColumn30(){
    if(csvDataTableColumn30==null){

      csvDataTableColumn30 = new ACTableColumn();

      csvDataTableColumn30.setHeaderValue("<html>63<br>予<br>看<br>介<br>　</html>");

      csvDataTableColumn30.setColumnName("63");

      csvDataTableColumn30.setEditable(false);

      csvDataTableColumn30.setColumns(3);

      csvDataTableColumn30.setRendererType(VRTableCellViewer.RENDERER_TYPE_LABEL);

      addCsvDataTableColumn30();
    }
    return csvDataTableColumn30;

  }

  /**
   * 予訪リカラムを取得します。
   * @return 予訪リカラム
   */
  public ACTableColumn getCsvDataTableColumn31(){
    if(csvDataTableColumn31==null){

      csvDataTableColumn31 = new ACTableColumn();

      csvDataTableColumn31.setHeaderValue("<html>64<br>予<br>訪<br>リ<br>　</html>");

      csvDataTableColumn31.setColumnName("64");

      csvDataTableColumn31.setEditable(false);

      csvDataTableColumn31.setColumns(3);

      csvDataTableColumn31.setRendererType(VRTableCellViewer.RENDERER_TYPE_LABEL);

      addCsvDataTableColumn31();
    }
    return csvDataTableColumn31;

  }

  /**
   * 予通介カラムを取得します。
   * @return 予通介カラム
   */
  public ACTableColumn getCsvDataTableColumn32(){
    if(csvDataTableColumn32==null){

      csvDataTableColumn32 = new ACTableColumn();

      csvDataTableColumn32.setHeaderValue("<html>65<br>予<br>通<br>介<br>　</html>");

      csvDataTableColumn32.setColumnName("65");

      csvDataTableColumn32.setEditable(false);

      csvDataTableColumn32.setColumns(3);

      csvDataTableColumn32.setRendererType(VRTableCellViewer.RENDERER_TYPE_LABEL);

      addCsvDataTableColumn32();
    }
    return csvDataTableColumn32;

  }

  /**
   * 予通リカラムを取得します。
   * @return 予通リカラム
   */
  public ACTableColumn getCsvDataTableColumn33(){
    if(csvDataTableColumn33==null){

      csvDataTableColumn33 = new ACTableColumn();

      csvDataTableColumn33.setHeaderValue("<html>66<br>予<br>通<br>リ<br>　</html>");

      csvDataTableColumn33.setColumnName("66");

      csvDataTableColumn33.setEditable(false);

      csvDataTableColumn33.setColumns(3);

      csvDataTableColumn33.setRendererType(VRTableCellViewer.RENDERER_TYPE_LABEL);

      addCsvDataTableColumn33();
    }
    return csvDataTableColumn33;

  }

  /**
   * 予用具カラムを取得します。
   * @return 予用具カラム
   */
  public ACTableColumn getCsvDataTableColumn34(){
    if(csvDataTableColumn34==null){

      csvDataTableColumn34 = new ACTableColumn();

      csvDataTableColumn34.setHeaderValue("<html>67<br>予<br>用<br>具<br>　</html>");

      csvDataTableColumn34.setColumnName("67");

      csvDataTableColumn34.setEditable(false);

      csvDataTableColumn34.setColumns(3);

      csvDataTableColumn34.setRendererType(VRTableCellViewer.RENDERER_TYPE_LABEL);

      addCsvDataTableColumn34();
    }
    return csvDataTableColumn34;

  }

  /**
   * 予短生カラムを取得します。
   * @return 予短生カラム
   */
  public ACTableColumn getCsvDataTableColumn35(){
    if(csvDataTableColumn35==null){

      csvDataTableColumn35 = new ACTableColumn();

      csvDataTableColumn35.setHeaderValue("<html>24<br>予<br>短<br>生<br>　</html>");

      csvDataTableColumn35.setColumnName("24");

      csvDataTableColumn35.setEditable(false);

      csvDataTableColumn35.setColumns(3);

      csvDataTableColumn35.setRendererType(VRTableCellViewer.RENDERER_TYPE_LABEL);

      addCsvDataTableColumn35();
    }
    return csvDataTableColumn35;

  }

  /**
   * 予老健カラムを取得します。
   * @return 予老健カラム
   */
  public ACTableColumn getCsvDataTableColumn36(){
    if(csvDataTableColumn36==null){

      csvDataTableColumn36 = new ACTableColumn();

      csvDataTableColumn36.setHeaderValue("<html>25<br>予<br>老<br>健<br>　</html>");

      csvDataTableColumn36.setColumnName("25");

      csvDataTableColumn36.setEditable(false);

      csvDataTableColumn36.setColumns(3);

      csvDataTableColumn36.setRendererType(VRTableCellViewer.RENDERER_TYPE_LABEL);

      addCsvDataTableColumn36();
    }
    return csvDataTableColumn36;

  }

  /**
   * 予療養カラムを取得します。
   * @return 予療養カラム
   */
  public ACTableColumn getCsvDataTableColumn37(){
    if(csvDataTableColumn37==null){

      csvDataTableColumn37 = new ACTableColumn();

      csvDataTableColumn37.setHeaderValue("<html>26<br>予<br>療<br>養<br>　</html>");

      csvDataTableColumn37.setColumnName("26");

      csvDataTableColumn37.setEditable(false);

      csvDataTableColumn37.setColumns(3);

      csvDataTableColumn37.setRendererType(VRTableCellViewer.RENDERER_TYPE_LABEL);

      addCsvDataTableColumn37();
    }
    return csvDataTableColumn37;

  }

  /**
   * 予介医カラムを取得します。
   * @return 予介医カラム
   */
  public ACTableColumn getCsvDataTableColumn71(){
    if(csvDataTableColumn71==null){

      csvDataTableColumn71 = new ACTableColumn();

      csvDataTableColumn71.setHeaderValue("<html>2B<br>予<br>介<br>医<br>　</html>");

      csvDataTableColumn71.setColumnName("2B");

      csvDataTableColumn71.setEditable(false);

      csvDataTableColumn71.setColumns(3);

      csvDataTableColumn71.setRendererType(VRTableCellViewer.RENDERER_TYPE_LABEL);

      addCsvDataTableColumn71();
    }
    return csvDataTableColumn71;

  }

  /**
   * 予居宅カラムを取得します。
   * @return 予居宅カラム
   */
  public ACTableColumn getCsvDataTableColumn38(){
    if(csvDataTableColumn38==null){

      csvDataTableColumn38 = new ACTableColumn();

      csvDataTableColumn38.setHeaderValue("<html>34<br>予<br>居<br>宅<br>　</html>");

      csvDataTableColumn38.setColumnName("34");

      csvDataTableColumn38.setEditable(false);

      csvDataTableColumn38.setColumns(3);

      csvDataTableColumn38.setRendererType(VRTableCellViewer.RENDERER_TYPE_LABEL);

      addCsvDataTableColumn38();
    }
    return csvDataTableColumn38;

  }

  /**
   * 予特定カラムを取得します。
   * @return 予特定カラム
   */
  public ACTableColumn getCsvDataTableColumn39(){
    if(csvDataTableColumn39==null){

      csvDataTableColumn39 = new ACTableColumn();

      csvDataTableColumn39.setHeaderValue("<html>35<br>予<br>特<br>定<br>　</html>");

      csvDataTableColumn39.setColumnName("35");

      csvDataTableColumn39.setEditable(false);

      csvDataTableColumn39.setColumns(3);

      csvDataTableColumn39.setRendererType(VRTableCellViewer.RENDERER_TYPE_LABEL);

      addCsvDataTableColumn39();
    }
    return csvDataTableColumn39;

  }

  /**
   * 予プランカラムを取得します。
   * @return 予プランカラム
   */
  public ACTableColumn getCsvDataTableColumn40(){
    if(csvDataTableColumn40==null){

      csvDataTableColumn40 = new ACTableColumn();

      csvDataTableColumn40.setHeaderValue("<html>46<br>予<br>プ<br>ラ<br>ン</html>");

      csvDataTableColumn40.setColumnName("46");

      csvDataTableColumn40.setEditable(false);

      csvDataTableColumn40.setColumns(3);

      csvDataTableColumn40.setRendererType(VRTableCellViewer.RENDERER_TYPE_LABEL);

      addCsvDataTableColumn40();
    }
    return csvDataTableColumn40;

  }

  /**
   * 予認通カラムを取得します。
   * @return 予認通カラム
   */
  public ACTableColumn getCsvDataTableColumn41(){
    if(csvDataTableColumn41==null){

      csvDataTableColumn41 = new ACTableColumn();

      csvDataTableColumn41.setHeaderValue("<html>74<br>予<br>認<br>通<br>　</html>");

      csvDataTableColumn41.setColumnName("74");

      csvDataTableColumn41.setEditable(false);

      csvDataTableColumn41.setColumns(3);

      csvDataTableColumn41.setRendererType(VRTableCellViewer.RENDERER_TYPE_LABEL);

      addCsvDataTableColumn41();
    }
    return csvDataTableColumn41;

  }

  /**
   * 予小規模カラムを取得します。
   * @return 予小規模カラム
   */
  public ACTableColumn getCsvDataTableColumn42(){
    if(csvDataTableColumn42==null){

      csvDataTableColumn42 = new ACTableColumn();

      csvDataTableColumn42.setHeaderValue("<html>75<br>予<br>居<br>介<br>　</html>");

      csvDataTableColumn42.setColumnName("75");

      csvDataTableColumn42.setEditable(false);

      csvDataTableColumn42.setColumns(3);

      csvDataTableColumn42.setRendererType(VRTableCellViewer.RENDERER_TYPE_LABEL);

      addCsvDataTableColumn42();
    }
    return csvDataTableColumn42;

  }

  /**
   * 予小規模短カラムを取得します。
   * @return 予小規模短カラム
   */
  public ACTableColumn getCsvDataTableColumn52(){
    if(csvDataTableColumn52==null){

      csvDataTableColumn52 = new ACTableColumn();

      csvDataTableColumn52.setHeaderValue("<html>69<br>予<br>居<br>短<br>　</html>");

      csvDataTableColumn52.setColumnName("69");

      csvDataTableColumn52.setEditable(false);

      csvDataTableColumn52.setColumns(3);

      csvDataTableColumn52.setRendererType(VRTableCellViewer.RENDERER_TYPE_LABEL);

      addCsvDataTableColumn52();
    }
    return csvDataTableColumn52;

  }

  /**
   * 予認知カラムを取得します。
   * @return 予認知カラム
   */
  public ACTableColumn getCsvDataTableColumn43(){
    if(csvDataTableColumn43==null){

      csvDataTableColumn43 = new ACTableColumn();

      csvDataTableColumn43.setHeaderValue("<html>37<br>予<br>認<br>知<br>　</html>");

      csvDataTableColumn43.setColumnName("37");

      csvDataTableColumn43.setEditable(false);

      csvDataTableColumn43.setColumns(3);

      csvDataTableColumn43.setRendererType(VRTableCellViewer.RENDERER_TYPE_LABEL);

      addCsvDataTableColumn43();
    }
    return csvDataTableColumn43;

  }

  /**
   * 予認短カラムを取得します。
   * @return 予認短カラム
   */
  public ACTableColumn getCsvDataTableColumn44(){
    if(csvDataTableColumn44==null){

      csvDataTableColumn44 = new ACTableColumn();

      csvDataTableColumn44.setHeaderValue("<html>39<br>予<br>認<br>短<br>　</html>");

      csvDataTableColumn44.setColumnName("39");

      csvDataTableColumn44.setEditable(false);

      csvDataTableColumn44.setColumns(3);

      csvDataTableColumn44.setRendererType(VRTableCellViewer.RENDERER_TYPE_LABEL);

      addCsvDataTableColumn44();
    }
    return csvDataTableColumn44;

  }

  /**
   * 総訪みカラムを取得します。
   * @return 総訪みカラム
   */
  public ACTableColumn getCsvDataTableColumn54(){
    if(csvDataTableColumn54==null){

      csvDataTableColumn54 = new ACTableColumn();

      csvDataTableColumn54.setHeaderValue("<html>A1<br>総<br>訪<br>み<br>　</html>");

      csvDataTableColumn54.setColumnName("A1");

      csvDataTableColumn54.setEditable(false);

      csvDataTableColumn54.setColumns(3);

      csvDataTableColumn54.setRendererType(VRTableCellViewer.RENDERER_TYPE_LABEL);

      addCsvDataTableColumn54();
    }
    return csvDataTableColumn54;

  }

  /**
   * 総訪独カラムを取得します。
   * @return 総訪独カラム
   */
  public ACTableColumn getCsvDataTableColumn55(){
    if(csvDataTableColumn55==null){

      csvDataTableColumn55 = new ACTableColumn();

      csvDataTableColumn55.setHeaderValue("<html>A2<br>総<br>訪<br>独<br>　</html>");

      csvDataTableColumn55.setColumnName("A2");

      csvDataTableColumn55.setEditable(false);

      csvDataTableColumn55.setColumns(3);

      csvDataTableColumn55.setRendererType(VRTableCellViewer.RENDERER_TYPE_LABEL);

      addCsvDataTableColumn55();
    }
    return csvDataTableColumn55;

  }

  /**
   * 総訪率カラムを取得します。
   * @return 総訪率カラム
   */
  public ACTableColumn getCsvDataTableColumn56(){
    if(csvDataTableColumn56==null){

      csvDataTableColumn56 = new ACTableColumn();

      csvDataTableColumn56.setHeaderValue("<html>A3<br>総<br>訪<br>率<br>　</html>");

      csvDataTableColumn56.setColumnName("A3");

      csvDataTableColumn56.setEditable(false);

      csvDataTableColumn56.setColumns(3);

      csvDataTableColumn56.setRendererType(VRTableCellViewer.RENDERER_TYPE_LABEL);

      addCsvDataTableColumn56();
    }
    return csvDataTableColumn56;

  }

  /**
   * 総訪額カラムを取得します。
   * @return 総訪額カラム
   */
  public ACTableColumn getCsvDataTableColumn57(){
    if(csvDataTableColumn57==null){

      csvDataTableColumn57 = new ACTableColumn();

      csvDataTableColumn57.setHeaderValue("<html>A4<br>総<br>訪<br>額<br>　</html>");

      csvDataTableColumn57.setColumnName("A4");

      csvDataTableColumn57.setEditable(false);

      csvDataTableColumn57.setColumns(3);

      csvDataTableColumn57.setRendererType(VRTableCellViewer.RENDERER_TYPE_LABEL);

      addCsvDataTableColumn57();
    }
    return csvDataTableColumn57;

  }

  /**
   * 総通みカラムを取得します。
   * @return 総通みカラム
   */
  public ACTableColumn getCsvDataTableColumn58(){
    if(csvDataTableColumn58==null){

      csvDataTableColumn58 = new ACTableColumn();

      csvDataTableColumn58.setHeaderValue("<html>A5<br>総<br>通<br>み<br>　</html>");

      csvDataTableColumn58.setColumnName("A5");

      csvDataTableColumn58.setEditable(false);

      csvDataTableColumn58.setColumns(3);

      csvDataTableColumn58.setRendererType(VRTableCellViewer.RENDERER_TYPE_LABEL);

      addCsvDataTableColumn58();
    }
    return csvDataTableColumn58;

  }

  /**
   * 総通独カラムを取得します。
   * @return 総通独カラム
   */
  public ACTableColumn getCsvDataTableColumn59(){
    if(csvDataTableColumn59==null){

      csvDataTableColumn59 = new ACTableColumn();

      csvDataTableColumn59.setHeaderValue("<html>A6<br>総<br>通<br>独<br>　</html>");

      csvDataTableColumn59.setColumnName("A6");

      csvDataTableColumn59.setEditable(false);

      csvDataTableColumn59.setColumns(3);

      csvDataTableColumn59.setRendererType(VRTableCellViewer.RENDERER_TYPE_LABEL);

      addCsvDataTableColumn59();
    }
    return csvDataTableColumn59;

  }

  /**
   * 総通率カラムを取得します。
   * @return 総通率カラム
   */
  public ACTableColumn getCsvDataTableColumn60(){
    if(csvDataTableColumn60==null){

      csvDataTableColumn60 = new ACTableColumn();

      csvDataTableColumn60.setHeaderValue("<html>A7<br>総<br>通<br>率<br>　</html>");

      csvDataTableColumn60.setColumnName("A7");

      csvDataTableColumn60.setEditable(false);

      csvDataTableColumn60.setColumns(3);

      csvDataTableColumn60.setRendererType(VRTableCellViewer.RENDERER_TYPE_LABEL);

      addCsvDataTableColumn60();
    }
    return csvDataTableColumn60;

  }

  /**
   * 総通額カラムを取得します。
   * @return 総通額カラム
   */
  public ACTableColumn getCsvDataTableColumn61(){
    if(csvDataTableColumn61==null){

      csvDataTableColumn61 = new ACTableColumn();

      csvDataTableColumn61.setHeaderValue("<html>A8<br>総<br>通<br>額<br>　</html>");

      csvDataTableColumn61.setColumnName("A8");

      csvDataTableColumn61.setEditable(false);

      csvDataTableColumn61.setColumns(3);

      csvDataTableColumn61.setRendererType(VRTableCellViewer.RENDERER_TYPE_LABEL);

      addCsvDataTableColumn61();
    }
    return csvDataTableColumn61;

  }

  /**
   * 総食率カラムを取得します。
   * @return 総食率カラム
   */
  public ACTableColumn getCsvDataTableColumn62(){
    if(csvDataTableColumn62==null){

      csvDataTableColumn62 = new ACTableColumn();

      csvDataTableColumn62.setHeaderValue("<html>A9<br>総<br>食<br>率<br>　</html>");

      csvDataTableColumn62.setColumnName("A9");

      csvDataTableColumn62.setEditable(false);

      csvDataTableColumn62.setColumns(3);

      csvDataTableColumn62.setRendererType(VRTableCellViewer.RENDERER_TYPE_LABEL);

      addCsvDataTableColumn62();
    }
    return csvDataTableColumn62;

  }

  /**
   * 総食額カラムを取得します。
   * @return 総食額カラム
   */
  public ACTableColumn getCsvDataTableColumn63(){
    if(csvDataTableColumn63==null){

      csvDataTableColumn63 = new ACTableColumn();

      csvDataTableColumn63.setHeaderValue("<html>AA<br>総<br>食<br>額<br>　</html>");

      csvDataTableColumn63.setColumnName("AA");

      csvDataTableColumn63.setEditable(false);

      csvDataTableColumn63.setColumns(3);

      csvDataTableColumn63.setRendererType(VRTableCellViewer.RENDERER_TYPE_LABEL);

      addCsvDataTableColumn63();
    }
    return csvDataTableColumn63;

  }

  /**
   * 総守率カラムを取得します。
   * @return 総守率カラム
   */
  public ACTableColumn getCsvDataTableColumn64(){
    if(csvDataTableColumn64==null){

      csvDataTableColumn64 = new ACTableColumn();

      csvDataTableColumn64.setHeaderValue("<html>AB<br>総<br>守<br>率<br>　</html>");

      csvDataTableColumn64.setColumnName("AB");

      csvDataTableColumn64.setEditable(false);

      csvDataTableColumn64.setColumns(3);

      csvDataTableColumn64.setRendererType(VRTableCellViewer.RENDERER_TYPE_LABEL);

      addCsvDataTableColumn64();
    }
    return csvDataTableColumn64;

  }

  /**
   * 総守額カラムを取得します。
   * @return 総守額カラム
   */
  public ACTableColumn getCsvDataTableColumn65(){
    if(csvDataTableColumn65==null){

      csvDataTableColumn65 = new ACTableColumn();

      csvDataTableColumn65.setHeaderValue("<html>AC<br>総<br>守<br>額<br>　</html>");

      csvDataTableColumn65.setColumnName("AC");

      csvDataTableColumn65.setEditable(false);

      csvDataTableColumn65.setColumns(3);

      csvDataTableColumn65.setRendererType(VRTableCellViewer.RENDERER_TYPE_LABEL);

      addCsvDataTableColumn65();
    }
    return csvDataTableColumn65;

  }

  /**
   * 総他率カラムを取得します。
   * @return 総他率カラム
   */
  public ACTableColumn getCsvDataTableColumn66(){
    if(csvDataTableColumn66==null){

      csvDataTableColumn66 = new ACTableColumn();

      csvDataTableColumn66.setHeaderValue("<html>AD<br>総<br>他<br>率<br>　</html>");

      csvDataTableColumn66.setColumnName("AD");

      csvDataTableColumn66.setEditable(false);

      csvDataTableColumn66.setColumns(3);

      csvDataTableColumn66.setRendererType(VRTableCellViewer.RENDERER_TYPE_LABEL);

      addCsvDataTableColumn66();
    }
    return csvDataTableColumn66;

  }

  /**
   * 総他額カラムを取得します。
   * @return 総他額カラム
   */
  public ACTableColumn getCsvDataTableColumn67(){
    if(csvDataTableColumn67==null){

      csvDataTableColumn67 = new ACTableColumn();

      csvDataTableColumn67.setHeaderValue("<html>AE<br>総<br>他<br>額<br>　</html>");

      csvDataTableColumn67.setColumnName("AE");

      csvDataTableColumn67.setEditable(false);

      csvDataTableColumn67.setColumns(3);

      csvDataTableColumn67.setRendererType(VRTableCellViewer.RENDERER_TYPE_LABEL);

      addCsvDataTableColumn67();
    }
    return csvDataTableColumn67;

  }

  /**
   * 総予ケアカラムを取得します。
   * @return 総予ケアカラム
   */
  public ACTableColumn getCsvDataTableColumn68(){
    if(csvDataTableColumn68==null){

      csvDataTableColumn68 = new ACTableColumn();

      csvDataTableColumn68.setHeaderValue("<html>AF<br>総<br>予<br>ケ<br>ア</html>");

      csvDataTableColumn68.setColumnName("AF");

      csvDataTableColumn68.setEditable(false);

      csvDataTableColumn68.setColumns(3);

      csvDataTableColumn68.setRendererType(VRTableCellViewer.RENDERER_TYPE_LABEL);

      addCsvDataTableColumn68();
    }
    return csvDataTableColumn68;

  }

  /**
   * 単位数カラムを取得します。
   * @return 単位数カラム
   */
  public ACTableColumn getCsvDataTableColumn45(){
    if(csvDataTableColumn45==null){

      csvDataTableColumn45 = new ACTableColumn();

      csvDataTableColumn45.setHeaderValue("単位数");

      csvDataTableColumn45.setColumnName("UNIT_TOTAL");

      csvDataTableColumn45.setEditable(false);

      csvDataTableColumn45.setColumns(6);

      csvDataTableColumn45.setHorizontalAlignment(SwingConstants.RIGHT);

      csvDataTableColumn45.setRendererType(VRTableCellViewer.RENDERER_TYPE_LABEL);

      addCsvDataTableColumn45();
    }
    return csvDataTableColumn45;

  }

  /**
   * コンストラクタです。
   */
  public QO012Design() {

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
   * 業務ボタンバーに内部項目を追加します。
   */
  protected void addButtons(){

    buttons.add(getUnitingButton(), VRLayout.EAST);
    buttons.add(getOpenButton(), VRLayout.EAST);
  }

  /**
   * 開くに内部項目を追加します。
   */
  protected void addOpenButton(){

  }

  /**
   * 結合に内部項目を追加します。
   */
  protected void addUnitingButton(){

  }

  /**
   * クライアント領域に内部項目を追加します。
   */
  protected void addContents(){

    contents.add(getFileInfoPanel(), VRLayout.NORTH);

    contents.add(getTotalInfoTable(), VRLayout.NORTH);

    contents.add(getCsvDataTable(), VRLayout.CLIENT);

  }

  /**
   * 共通領域に内部項目を追加します。
   */
  protected void addFileInfoPanel(){

    fileInfoPanel.add(getFileInfoGroup(), VRLayout.NORTH);

  }

  /**
   * ファイル情報グループに内部項目を追加します。
   */
  protected void addFileInfoGroup(){

    fileInfoGroup.add(getFileTypeLabel(), null);

    fileInfoGroup.add(getFileType(), null);

    fileInfoGroup.add(getMediaTypeLabel(), null);

    fileInfoGroup.add(getMediaType(), VRLayout.FLOW_INSETLINE_RETURN);

    fileInfoGroup.add(getTargetYearAndMonthLabel(), null);

    fileInfoGroup.add(getTargetYearAndMonth(), null);

    fileInfoGroup.add(getProviderLabel(), null);

    fileInfoGroup.add(getProviderId(), null);

    fileInfoGroup.add(getProviderName(), null);

  }

  /**
   * 種類ラベルに内部項目を追加します。
   */
  protected void addFileTypeLabel(){

  }

  /**
   * 種類に内部項目を追加します。
   */
  protected void addFileType(){

  }

  /**
   * 媒体ラベルに内部項目を追加します。
   */
  protected void addMediaTypeLabel(){

  }

  /**
   * 媒体に内部項目を追加します。
   */
  protected void addMediaType(){

  }

  /**
   * 処理対象年月ラベルに内部項目を追加します。
   */
  protected void addTargetYearAndMonthLabel(){

  }

  /**
   * 処理対象年月に内部項目を追加します。
   */
  protected void addTargetYearAndMonth(){

  }

  /**
   * 事業所ラベルに内部項目を追加します。
   */
  protected void addProviderLabel(){

  }

  /**
   * 事業所番号に内部項目を追加します。
   */
  protected void addProviderId(){

  }

  /**
   * 事業所名称に内部項目を追加します。
   */
  protected void addProviderName(){

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

    getTotalInfoTableColumnModel().addColumn(getTotalInfoTableColumn1());

    getTotalInfoTableColumnModel().addColumn(getTotalInfoTableColumn2());

    getTotalInfoTableColumnModel().addColumn(getTotalInfoTableColumn3());

    getTotalInfoTableColumnModel().addColumn(getTotalInfoTableColumn4());

    getTotalInfoTableColumnModel().addColumn(getTotalInfoTableColumn5());

    getTotalInfoTableColumnModel().addColumn(getTotalInfoTableColumn6());

  }

  /**
   * 月カラムに内部項目を追加します。
   */
  protected void addTotalInfoTableColumn1(){

  }

  /**
   * 人数カラムに内部項目を追加します。
   */
  protected void addTotalInfoTableColumn2(){

  }

  /**
   * サービス件数カラムに内部項目を追加します。
   */
  protected void addTotalInfoTableColumn3(){

  }

  /**
   * ケアプラン件数カラムに内部項目を追加します。
   */
  protected void addTotalInfoTableColumn4(){

  }

  /**
   * 単位数カラムに内部項目を追加します。
   */
  protected void addTotalInfoTableColumn5(){

  }

  /**
   * 保険請求額カラムに内部項目を追加します。
   */
  protected void addTotalInfoTableColumn6(){

  }

  /**
   * CSVデータテーブルに内部項目を追加します。
   */
  protected void addCsvDataTable(){

  }

  /**
   * CSVデータテーブルカラムモデルに内部項目を追加します。
   */
  protected void addCsvDataTableColumnModel(){

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn1());

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn2());

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn3());

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn4());

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn5());

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn6());

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn7());

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn8());

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn9());

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn10());

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn11());

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn12());

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn13());

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn14());

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn69());

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn15());

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn16());

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn17());

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn46());

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn18());

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn47());

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn19());

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn20());

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn21());

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn22());

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn23());

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn70());

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn24());

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn25());

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn48());

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn49());

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn50());

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn26());

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn51());

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn53());

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn27());

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn28());

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn29());

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn30());

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn31());

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn32());

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn33());

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn34());

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn35());

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn36());

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn37());

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn71());

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn38());

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn39());

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn40());

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn41());

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn42());

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn52());

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn43());

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn44());

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn54());

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn55());

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn56());

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn57());

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn58());

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn59());

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn60());

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn61());

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn62());

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn63());

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn64());

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn65());

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn66());

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn67());

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn68());

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn45());

  }

  /**
   * 年月カラムに内部項目を追加します。
   */
  protected void addCsvDataTableColumn1(){

  }

  /**
   * 被保険者番号カラムに内部項目を追加します。
   */
  protected void addCsvDataTableColumn2(){

  }

  /**
   * 氏名カラムに内部項目を追加します。
   */
  protected void addCsvDataTableColumn3(){

  }

  /**
   * 要介護度カラムに内部項目を追加します。
   */
  protected void addCsvDataTableColumn4(){

  }

  /**
   * 訪介カラムに内部項目を追加します。
   */
  protected void addCsvDataTableColumn5(){

  }

  /**
   * 入浴カラムに内部項目を追加します。
   */
  protected void addCsvDataTableColumn6(){

  }

  /**
   * 看介カラムに内部項目を追加します。
   */
  protected void addCsvDataTableColumn7(){

  }

  /**
   * 訪リカラムに内部項目を追加します。
   */
  protected void addCsvDataTableColumn8(){

  }

  /**
   * 通介カラムに内部項目を追加します。
   */
  protected void addCsvDataTableColumn9(){

  }

  /**
   * 通リカラムに内部項目を追加します。
   */
  protected void addCsvDataTableColumn10(){

  }

  /**
   * 用具カラムに内部項目を追加します。
   */
  protected void addCsvDataTableColumn11(){

  }

  /**
   * 短生カラムに内部項目を追加します。
   */
  protected void addCsvDataTableColumn12(){

  }

  /**
   * 短老カラムに内部項目を追加します。
   */
  protected void addCsvDataTableColumn13(){

  }

  /**
   * 短医カラムに内部項目を追加します。
   */
  protected void addCsvDataTableColumn14(){

  }

  /**
   * 短介医カラムに内部項目を追加します。
   */
  protected void addCsvDataTableColumn69(){

  }

  /**
   * 居宅カラムに内部項目を追加します。
   */
  protected void addCsvDataTableColumn15(){

  }

  /**
   * 認知カラムに内部項目を追加します。
   */
  protected void addCsvDataTableColumn16(){

  }

  /**
   * 特定カラムに内部項目を追加します。
   */
  protected void addCsvDataTableColumn17(){

  }

  /**
   * 特定短カラムに内部項目を追加します。
   */
  protected void addCsvDataTableColumn46(){

  }

  /**
   * 地特カラムに内部項目を追加します。
   */
  protected void addCsvDataTableColumn18(){

  }

  /**
   * 地特短カラムに内部項目を追加します。
   */
  protected void addCsvDataTableColumn47(){

  }

  /**
   * 認短カラムに内部項目を追加します。
   */
  protected void addCsvDataTableColumn19(){

  }

  /**
   * 特養カラムに内部項目を追加します。
   */
  protected void addCsvDataTableColumn20(){

  }

  /**
   * 老健カラムに内部項目を追加します。
   */
  protected void addCsvDataTableColumn21(){

  }

  /**
   * 療養カラムに内部項目を追加します。
   */
  protected void addCsvDataTableColumn22(){

  }

  /**
   * 地養カラムに内部項目を追加します。
   */
  protected void addCsvDataTableColumn23(){

  }

  /**
   * 介医カラムに内部項目を追加します。
   */
  protected void addCsvDataTableColumn70(){

  }

  /**
   * 夜介カラムに内部項目を追加します。
   */
  protected void addCsvDataTableColumn24(){

  }

  /**
   * 認通カラムに内部項目を追加します。
   */
  protected void addCsvDataTableColumn25(){

  }

  /**
   * 定訪看カラムに内部項目を追加します。
   */
  protected void addCsvDataTableColumn48(){

  }

  /**
   * 複合カラムに内部項目を追加します。
   */
  protected void addCsvDataTableColumn49(){

  }

  /**
   * 複合短カラムに内部項目を追加します。
   */
  protected void addCsvDataTableColumn50(){

  }

  /**
   * 小規模多機能カラムに内部項目を追加します。
   */
  protected void addCsvDataTableColumn26(){

  }

  /**
   * 小規模多機能短カラムに内部項目を追加します。
   */
  protected void addCsvDataTableColumn51(){

  }

  /**
   * 地通介カラムに内部項目を追加します。
   */
  protected void addCsvDataTableColumn53(){

  }

  /**
   * プランカラムに内部項目を追加します。
   */
  protected void addCsvDataTableColumn27(){

  }

  /**
   * 予防介カラムに内部項目を追加します。
   */
  protected void addCsvDataTableColumn28(){

  }

  /**
   * 予入浴カラムに内部項目を追加します。
   */
  protected void addCsvDataTableColumn29(){

  }

  /**
   * 予看介カラムに内部項目を追加します。
   */
  protected void addCsvDataTableColumn30(){

  }

  /**
   * 予訪リカラムに内部項目を追加します。
   */
  protected void addCsvDataTableColumn31(){

  }

  /**
   * 予通介カラムに内部項目を追加します。
   */
  protected void addCsvDataTableColumn32(){

  }

  /**
   * 予通リカラムに内部項目を追加します。
   */
  protected void addCsvDataTableColumn33(){

  }

  /**
   * 予用具カラムに内部項目を追加します。
   */
  protected void addCsvDataTableColumn34(){

  }

  /**
   * 予短生カラムに内部項目を追加します。
   */
  protected void addCsvDataTableColumn35(){

  }

  /**
   * 予老健カラムに内部項目を追加します。
   */
  protected void addCsvDataTableColumn36(){

  }

  /**
   * 予療養カラムに内部項目を追加します。
   */
  protected void addCsvDataTableColumn37(){

  }

  /**
   * 予介医カラムに内部項目を追加します。
   */
  protected void addCsvDataTableColumn71(){

  }

  /**
   * 予居宅カラムに内部項目を追加します。
   */
  protected void addCsvDataTableColumn38(){

  }

  /**
   * 予特定カラムに内部項目を追加します。
   */
  protected void addCsvDataTableColumn39(){

  }

  /**
   * 予プランカラムに内部項目を追加します。
   */
  protected void addCsvDataTableColumn40(){

  }

  /**
   * 予認通カラムに内部項目を追加します。
   */
  protected void addCsvDataTableColumn41(){

  }

  /**
   * 予小規模カラムに内部項目を追加します。
   */
  protected void addCsvDataTableColumn42(){

  }

  /**
   * 予小規模短カラムに内部項目を追加します。
   */
  protected void addCsvDataTableColumn52(){

  }

  /**
   * 予認知カラムに内部項目を追加します。
   */
  protected void addCsvDataTableColumn43(){

  }

  /**
   * 予認短カラムに内部項目を追加します。
   */
  protected void addCsvDataTableColumn44(){

  }

  /**
   * 総訪みカラムに内部項目を追加します。
   */
  protected void addCsvDataTableColumn54(){

  }

  /**
   * 総訪独カラムに内部項目を追加します。
   */
  protected void addCsvDataTableColumn55(){

  }

  /**
   * 総訪率カラムに内部項目を追加します。
   */
  protected void addCsvDataTableColumn56(){

  }

  /**
   * 総訪額カラムに内部項目を追加します。
   */
  protected void addCsvDataTableColumn57(){

  }

  /**
   * 総通みカラムに内部項目を追加します。
   */
  protected void addCsvDataTableColumn58(){

  }

  /**
   * 総通独カラムに内部項目を追加します。
   */
  protected void addCsvDataTableColumn59(){

  }

  /**
   * 総通率カラムに内部項目を追加します。
   */
  protected void addCsvDataTableColumn60(){

  }

  /**
   * 総通額カラムに内部項目を追加します。
   */
  protected void addCsvDataTableColumn61(){

  }

  /**
   * 総食率カラムに内部項目を追加します。
   */
  protected void addCsvDataTableColumn62(){

  }

  /**
   * 総食額カラムに内部項目を追加します。
   */
  protected void addCsvDataTableColumn63(){

  }

  /**
   * 総守率カラムに内部項目を追加します。
   */
  protected void addCsvDataTableColumn64(){

  }

  /**
   * 総守額カラムに内部項目を追加します。
   */
  protected void addCsvDataTableColumn65(){

  }

  /**
   * 総他率カラムに内部項目を追加します。
   */
  protected void addCsvDataTableColumn66(){

  }

  /**
   * 総他額カラムに内部項目を追加します。
   */
  protected void addCsvDataTableColumn67(){

  }

  /**
   * 総予ケアカラムに内部項目を追加します。
   */
  protected void addCsvDataTableColumn68(){

  }

  /**
   * 単位数カラムに内部項目を追加します。
   */
  protected void addCsvDataTableColumn45(){

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
      ACFrame.debugStart(new ACAffairInfo(QO012Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QO012Design getThis() {
    return this;
  }
}
