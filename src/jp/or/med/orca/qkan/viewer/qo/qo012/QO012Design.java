
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
 * 作成日: 2006/04/17  日本コンピューター株式会社 廣瀬 一海 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム CSVビューア (O)
 * プロセス CSVビューア (012)
 * プログラム CSVビューア画面 (QO012)
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
 * CSVビューア画面画面項目デザイン(QO012) 
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

  private ACLabel providerLabel;

  private ACLabel providerId;

  private ACLabel providerName;

  private ACLabel targetYearAndMonthLabel;

  private ACLabel targetYearAndMonth;

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

  private ACTableColumn csvDataTableColumn15;

  private ACTableColumn csvDataTableColumn16;

  private ACTableColumn csvDataTableColumn17;

  private ACTableColumn csvDataTableColumn18;

  private ACTableColumn csvDataTableColumn19;

  private ACTableColumn csvDataTableColumn20;

  private ACTableColumn csvDataTableColumn21;

  private ACTableColumn csvDataTableColumn22;

  private ACTableColumn csvDataTableColumn23;

  private ACTableColumn csvDataTableColumn24;

  private ACTableColumn csvDataTableColumn25;

  private ACTableColumn csvDataTableColumn26;

  private ACTableColumn csvDataTableColumn27;

  private ACTableColumn csvDataTableColumn28;

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

      openButton.setText("開く(C)");

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

      fileTypeLabel.setText("種類：");

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

      mediaTypeLabel.setText("媒体：");

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
   * 事業所ラベルを取得します。
   * @return 事業所ラベル
   */
  public ACLabel getProviderLabel(){
    if(providerLabel==null){

      providerLabel = new ACLabel();

      providerLabel.setText("事業所：");

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
   * 処理対象年月ラベルを取得します。
   * @return 処理対象年月ラベル
   */
  public ACLabel getTargetYearAndMonthLabel(){
    if(targetYearAndMonthLabel==null){

      targetYearAndMonthLabel = new ACLabel();

      targetYearAndMonthLabel.setText("処理対象月：");

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

      totalInfoTableColumn6.setHeaderValue("保険請求額");

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

      csvDataTable.setHeaderRows(3);

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

      csvDataTableColumn5.setHeaderValue("<html>訪<br>介</html>");

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

      csvDataTableColumn6.setHeaderValue("<html>入<br>浴</html>");

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

      csvDataTableColumn7.setHeaderValue("<html>看<br>介</html>");

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

      csvDataTableColumn8.setHeaderValue("<html>訪<br>リ</html>");

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

      csvDataTableColumn9.setHeaderValue("<html>通<br>介</html>");

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

      csvDataTableColumn10.setHeaderValue("<html>通<br>リ</html>");

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

      csvDataTableColumn11.setHeaderValue("<html>用<br>具</html>");

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

      csvDataTableColumn12.setHeaderValue("<html>短<br>生</html>");

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

      csvDataTableColumn13.setHeaderValue("<html>短<br>老</html>");

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

      csvDataTableColumn14.setHeaderValue("<html>短<br>医</html>");

      csvDataTableColumn14.setColumnName("23");

      csvDataTableColumn14.setEditable(false);

      csvDataTableColumn14.setColumns(3);

      csvDataTableColumn14.setRendererType(VRTableCellViewer.RENDERER_TYPE_LABEL);

      addCsvDataTableColumn14();
    }
    return csvDataTableColumn14;

  }

  /**
   * 居宅カラムを取得します。
   * @return 居宅カラム
   */
  public ACTableColumn getCsvDataTableColumn15(){
    if(csvDataTableColumn15==null){

      csvDataTableColumn15 = new ACTableColumn();

      csvDataTableColumn15.setHeaderValue("<html>居<br>宅</html>");

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

      csvDataTableColumn16.setHeaderValue("<html>認<br>知</html>");

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

      csvDataTableColumn17.setHeaderValue("<html>特<br>定</html>");

      csvDataTableColumn17.setColumnName("33");

      csvDataTableColumn17.setEditable(false);

      csvDataTableColumn17.setColumns(3);

      csvDataTableColumn17.setRendererType(VRTableCellViewer.RENDERER_TYPE_LABEL);

      addCsvDataTableColumn17();
    }
    return csvDataTableColumn17;

  }

  /**
   * 地特カラムを取得します。
   * @return 地特カラム
   */
  public ACTableColumn getCsvDataTableColumn18(){
    if(csvDataTableColumn18==null){

      csvDataTableColumn18 = new ACTableColumn();

      csvDataTableColumn18.setHeaderValue("<html>地<br>特</html>");

      csvDataTableColumn18.setColumnName("36");

      csvDataTableColumn18.setEditable(false);

      csvDataTableColumn18.setColumns(3);

      csvDataTableColumn18.setRendererType(VRTableCellViewer.RENDERER_TYPE_LABEL);

      addCsvDataTableColumn18();
    }
    return csvDataTableColumn18;

  }

  /**
   * 認短カラムを取得します。
   * @return 認短カラム
   */
  public ACTableColumn getCsvDataTableColumn19(){
    if(csvDataTableColumn19==null){

      csvDataTableColumn19 = new ACTableColumn();

      csvDataTableColumn19.setHeaderValue("<html>認<br>短</html>");

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

      csvDataTableColumn20.setHeaderValue("<html>特<br>養</html>");

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

      csvDataTableColumn21.setHeaderValue("<html>老<br>健</html>");

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

      csvDataTableColumn22.setHeaderValue("<html>療<br>養</html>");

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

      csvDataTableColumn23.setHeaderValue("<html>地<br>養</html>");

      csvDataTableColumn23.setColumnName("54");

      csvDataTableColumn23.setEditable(false);

      csvDataTableColumn23.setColumns(3);

      csvDataTableColumn23.setRendererType(VRTableCellViewer.RENDERER_TYPE_LABEL);

      addCsvDataTableColumn23();
    }
    return csvDataTableColumn23;

  }

  /**
   * 夜介カラムを取得します。
   * @return 夜介カラム
   */
  public ACTableColumn getCsvDataTableColumn24(){
    if(csvDataTableColumn24==null){

      csvDataTableColumn24 = new ACTableColumn();

      csvDataTableColumn24.setHeaderValue("<html>夜<br>介</html>");

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

      csvDataTableColumn25.setHeaderValue("<html>認<br>通</html>");

      csvDataTableColumn25.setColumnName("72");

      csvDataTableColumn25.setEditable(false);

      csvDataTableColumn25.setColumns(3);

      csvDataTableColumn25.setRendererType(VRTableCellViewer.RENDERER_TYPE_LABEL);

      addCsvDataTableColumn25();
    }
    return csvDataTableColumn25;

  }

  /**
   * 認通カラムを取得します。
   * @return 認通カラム
   */
  public ACTableColumn getCsvDataTableColumn26(){
    if(csvDataTableColumn26==null){

      csvDataTableColumn26 = new ACTableColumn();

      csvDataTableColumn26.setHeaderValue("<html>小<br>規<br>模</html>");

      csvDataTableColumn26.setColumnName("73");

      csvDataTableColumn26.setEditable(false);

      csvDataTableColumn26.setColumns(3);

      csvDataTableColumn26.setRendererType(VRTableCellViewer.RENDERER_TYPE_LABEL);

      addCsvDataTableColumn26();
    }
    return csvDataTableColumn26;

  }

  /**
   * プランカラムを取得します。
   * @return プランカラム
   */
  public ACTableColumn getCsvDataTableColumn27(){
    if(csvDataTableColumn27==null){

      csvDataTableColumn27 = new ACTableColumn();

      csvDataTableColumn27.setHeaderValue("<html>プ<br>ラ<br>ン</html>");

      csvDataTableColumn27.setColumnName("43");

      csvDataTableColumn27.setEditable(false);

      csvDataTableColumn27.setColumns(3);

      csvDataTableColumn27.setRendererType(VRTableCellViewer.RENDERER_TYPE_LABEL);

      addCsvDataTableColumn27();
    }
    return csvDataTableColumn27;

  }

  /**
   * 単位数カラムを取得します。
   * @return 単位数カラム
   */
  public ACTableColumn getCsvDataTableColumn28(){
    if(csvDataTableColumn28==null){

      csvDataTableColumn28 = new ACTableColumn();

      csvDataTableColumn28.setHeaderValue("単位数");

      csvDataTableColumn28.setColumnName("UNIT_TOTAL");

      csvDataTableColumn28.setEditable(false);

      csvDataTableColumn28.setHorizontalAlignment(SwingConstants.RIGHT);

      csvDataTableColumn28.setRendererType(VRTableCellViewer.RENDERER_TYPE_LABEL);

      addCsvDataTableColumn28();
    }
    return csvDataTableColumn28;

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

    fileInfoGroup.add(getMediaType(), null);

    fileInfoGroup.add(getProviderLabel(), null);

    fileInfoGroup.add(getProviderId(), null);

    fileInfoGroup.add(getProviderName(), null);

    fileInfoGroup.add(getTargetYearAndMonthLabel(), null);

    fileInfoGroup.add(getTargetYearAndMonth(), null);

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

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn15());

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn16());

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn17());

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn18());

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn19());

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn20());

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn21());

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn22());

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn23());

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn24());

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn25());

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn26());

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn27());

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn28());

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
   * 地特カラムに内部項目を追加します。
   */
  protected void addCsvDataTableColumn18(){

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
   * 認通カラムに内部項目を追加します。
   */
  protected void addCsvDataTableColumn26(){

  }

  /**
   * プランカラムに内部項目を追加します。
   */
  protected void addCsvDataTableColumn27(){

  }

  /**
   * 単位数カラムに内部項目を追加します。
   */
  protected void addCsvDataTableColumn28(){

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
