
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
 * 開発者: 田中　統蔵
 * 作成日: 2006/04/07  日本コンピューター株式会社 田中　統蔵 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 請求データ作成 (P)
 * プロセス 確認・修正 (004)
 * プログラム 特定治療費編集画面 (QP004001)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qp.qp004;
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
 * 特定治療費編集画面画面項目デザイン(QP004001) 
 */
public class QP004001Design extends QkanAffairDialog {
  //GUIコンポーネント

  private ACGroupBox contents;

  private ACPanel editors;

  private ACGroupBox points;

  private ACTextField rehavilitationPoint;

  private ACLabelContainer rehavilitationPointContainer;

  private ACTextField processPoint;

  private ACLabelContainer processPointContainer;

  private ACTextField operationPoint;

  private ACLabelContainer operationPointContainer;

  private ACTextField anesthesiaPoint;

  private ACLabelContainer anesthesiaPointContainer;

  private ACTextField radiationPoint;

  private ACLabelContainer radiationPointContainer;

  private ACPanel recordEditors;

  private ACBackLabelContainer sicks1;

  private ACTextField sickName1;

  private ACLabelContainer sickName1Container;

  private QkanDateTextField sickDate1;

  private ACLabelContainer sickDate1Container;

  private ACBackLabelContainer sicks2;

  private ACTextField sickName2;

  private ACLabelContainer sickName2Container;

  private QkanDateTextField sickDate2;

  private ACLabelContainer sickDate2Container;

  private ACBackLabelContainer sicks3;

  private ACTextField sickName3;

  private ACLabelContainer sickName3Container;

  private QkanDateTextField sickDate3;

  private ACLabelContainer sickDate3Container;

  private ACTextField houseCallProviderName;

  private ACLabelContainer houseCallProviderNameContainer;

  private ACTextField attendProviderName;

  private ACLabelContainer attendProviderNameContainer;

  private ACPanel hiddens;

  private ACTextField summary1;

  private ACTextField summary2;

  private ACTextField summary3;

  private ACTextField summary4;

  private ACTextField summary5;

  private ACTextField summary6;

  private ACTextField summary7;

  private ACTextField summary8;

  private ACTextField summary9;

  private ACTextField summary10;

  private ACTextField summary11;

  private ACTextField summary12;

  private ACTextField summary13;

  private ACTextField summary14;

  private ACTextField summary15;

  private ACTextField summary16;

  private ACTextField summary17;

  private ACTextField summary18;

  private ACTextField summary19;

  private ACTextField summary20;

  private ACPanel medicalButtons;

  private ACButton medicalClear;

  private ACButton medicalInsert;

  private ACButton medicalUpdate;

  private ACButton medicalDelete;

  private ACTable medicalTable;

  private VRTableColumnModel medicalTableColumnModel;

  private ACTableColumn medicalNo;

  private ACTableColumn medicalSickName1;

  private ACTableColumn medicalSickDate1;

  private ACTableColumn medicalSickName2;

  private ACTableColumn medicalSickDate2;

  private ACTableColumn medicalSickName3;

  private ACTableColumn medicalSickDate3;

  private ACTableColumn medicalHouseCallProviderName;

  private ACTableColumn medicalAttendProviderName;

  private ACPanel buttons;

  private ACButton aplly;

  private ACButton close;

  //getter

  /**
   * 特定治療費情報を取得します。
   * @return 特定治療費情報
   */
  public ACGroupBox getContents(){
    if(contents==null){

      contents = new ACGroupBox();

      contents.setText("特定治療費情報");

      addContents();
    }
    return contents;

  }

  /**
   * 編集領域を取得します。
   * @return 編集領域
   */
  public ACPanel getEditors(){
    if(editors==null){

      editors = new ACPanel();

      addEditors();
    }
    return editors;

  }

  /**
   * 特定治療費を取得します。
   * @return 特定治療費
   */
  public ACGroupBox getPoints(){
    if(points==null){

      points = new ACGroupBox();

      points.setText("特定治療費");

      points.setAutoWrap(false);

      points.setHgap(0);

      points.setHgrid(300);

      addPoints();
    }
    return points;

  }

  /**
   * リハビリテーション点数を取得します。
   * @return リハビリテーション点数
   */
  public ACTextField getRehavilitationPoint(){
    if(rehavilitationPoint==null){

      rehavilitationPoint = new ACTextField();

      getRehavilitationPointContainer().setText("リハビリテーション点数");

      rehavilitationPoint.setBindPath("401021");

      rehavilitationPoint.setColumns(7);

      rehavilitationPoint.setCharType(VRCharType.ONLY_DIGIT);

      rehavilitationPoint.setHorizontalAlignment(SwingConstants.RIGHT);

      rehavilitationPoint.setIMEMode(InputSubset.LATIN);

      rehavilitationPoint.setMaxLength(7);

      addRehavilitationPoint();
    }
    return rehavilitationPoint;

  }

  /**
   * リハビリテーション点数コンテナを取得します。
   * @return リハビリテーション点数コンテナ
   */
  protected ACLabelContainer getRehavilitationPointContainer(){
    if(rehavilitationPointContainer==null){
      rehavilitationPointContainer = new ACLabelContainer();
      rehavilitationPointContainer.setFollowChildEnabled(true);
      rehavilitationPointContainer.setVAlignment(VRLayout.CENTER);
      rehavilitationPointContainer.add(getRehavilitationPoint(), null);
    }
    return rehavilitationPointContainer;
  }

  /**
   * 処置点数を取得します。
   * @return 処置点数
   */
  public ACTextField getProcessPoint(){
    if(processPoint==null){

      processPoint = new ACTextField();

      getProcessPointContainer().setText("処置点数");

      processPoint.setBindPath("401022");

      processPoint.setColumns(7);

      processPoint.setCharType(VRCharType.ONLY_DIGIT);

      processPoint.setHorizontalAlignment(SwingConstants.RIGHT);

      processPoint.setIMEMode(InputSubset.LATIN);

      processPoint.setMaxLength(7);

      addProcessPoint();
    }
    return processPoint;

  }

  /**
   * 処置点数コンテナを取得します。
   * @return 処置点数コンテナ
   */
  protected ACLabelContainer getProcessPointContainer(){
    if(processPointContainer==null){
      processPointContainer = new ACLabelContainer();
      processPointContainer.setFollowChildEnabled(true);
      processPointContainer.setVAlignment(VRLayout.CENTER);
      processPointContainer.add(getProcessPoint(), null);
    }
    return processPointContainer;
  }

  /**
   * 手術点数を取得します。
   * @return 手術点数
   */
  public ACTextField getOperationPoint(){
    if(operationPoint==null){

      operationPoint = new ACTextField();

      getOperationPointContainer().setText("手術点数");

      operationPoint.setBindPath("401023");

      operationPoint.setColumns(7);

      operationPoint.setCharType(VRCharType.ONLY_DIGIT);

      operationPoint.setHorizontalAlignment(SwingConstants.RIGHT);

      operationPoint.setIMEMode(InputSubset.LATIN);

      operationPoint.setMaxLength(7);

      addOperationPoint();
    }
    return operationPoint;

  }

  /**
   * 手術点数コンテナを取得します。
   * @return 手術点数コンテナ
   */
  protected ACLabelContainer getOperationPointContainer(){
    if(operationPointContainer==null){
      operationPointContainer = new ACLabelContainer();
      operationPointContainer.setFollowChildEnabled(true);
      operationPointContainer.setVAlignment(VRLayout.CENTER);
      operationPointContainer.add(getOperationPoint(), null);
    }
    return operationPointContainer;
  }

  /**
   * 麻酔点数を取得します。
   * @return 麻酔点数
   */
  public ACTextField getAnesthesiaPoint(){
    if(anesthesiaPoint==null){

      anesthesiaPoint = new ACTextField();

      getAnesthesiaPointContainer().setText("麻酔点数");

      anesthesiaPoint.setBindPath("401024");

      anesthesiaPoint.setColumns(7);

      anesthesiaPoint.setCharType(VRCharType.ONLY_DIGIT);

      anesthesiaPoint.setHorizontalAlignment(SwingConstants.RIGHT);

      anesthesiaPoint.setIMEMode(InputSubset.LATIN);

      anesthesiaPoint.setMaxLength(7);

      addAnesthesiaPoint();
    }
    return anesthesiaPoint;

  }

  /**
   * 麻酔点数コンテナを取得します。
   * @return 麻酔点数コンテナ
   */
  protected ACLabelContainer getAnesthesiaPointContainer(){
    if(anesthesiaPointContainer==null){
      anesthesiaPointContainer = new ACLabelContainer();
      anesthesiaPointContainer.setFollowChildEnabled(true);
      anesthesiaPointContainer.setVAlignment(VRLayout.CENTER);
      anesthesiaPointContainer.add(getAnesthesiaPoint(), null);
    }
    return anesthesiaPointContainer;
  }

  /**
   * 放射線治療点数を取得します。
   * @return 放射線治療点数
   */
  public ACTextField getRadiationPoint(){
    if(radiationPoint==null){

      radiationPoint = new ACTextField();

      getRadiationPointContainer().setText("放射線治療点数");

      radiationPoint.setBindPath("401025");

      radiationPoint.setColumns(7);

      radiationPoint.setCharType(VRCharType.ONLY_DIGIT);

      radiationPoint.setHorizontalAlignment(SwingConstants.RIGHT);

      radiationPoint.setIMEMode(InputSubset.LATIN);

      radiationPoint.setMaxLength(7);

      addRadiationPoint();
    }
    return radiationPoint;

  }

  /**
   * 放射線治療点数コンテナを取得します。
   * @return 放射線治療点数コンテナ
   */
  protected ACLabelContainer getRadiationPointContainer(){
    if(radiationPointContainer==null){
      radiationPointContainer = new ACLabelContainer();
      radiationPointContainer.setFollowChildEnabled(true);
      radiationPointContainer.setVAlignment(VRLayout.CENTER);
      radiationPointContainer.add(getRadiationPoint(), null);
    }
    return radiationPointContainer;
  }

  /**
   * レコード領域を取得します。
   * @return レコード領域
   */
  public ACPanel getRecordEditors(){
    if(recordEditors==null){

      recordEditors = new ACPanel();

      recordEditors.setAutoWrap(false);

      recordEditors.setHgap(0);

      recordEditors.setLabelMargin(0);

      addRecordEditors();
    }
    return recordEditors;

  }

  /**
   * 傷病コンテナ1を取得します。
   * @return 傷病コンテナ1
   */
  public ACBackLabelContainer getSicks1(){
    if(sicks1==null){

      sicks1 = new ACBackLabelContainer();

      addSicks1();
    }
    return sicks1;

  }

  /**
   * 緊急時傷病名1を取得します。
   * @return 緊急時傷病名1
   */
  public ACTextField getSickName1(){
    if(sickName1==null){

      sickName1 = new ACTextField();

      getSickName1Container().setText("緊急時傷病名1");

      sickName1.setBindPath("401008");

      sickName1.setColumns(20);

      sickName1.setIMEMode(InputSubset.KANJI);

      sickName1.setMaxLength(20);

      addSickName1();
    }
    return sickName1;

  }

  /**
   * 緊急時傷病名1コンテナを取得します。
   * @return 緊急時傷病名1コンテナ
   */
  protected ACLabelContainer getSickName1Container(){
    if(sickName1Container==null){
      sickName1Container = new ACLabelContainer();
      sickName1Container.setFollowChildEnabled(true);
      sickName1Container.setVAlignment(VRLayout.CENTER);
      sickName1Container.add(getSickName1(), null);
    }
    return sickName1Container;
  }

  /**
   * 緊急時治療開始年月日1を取得します。
   * @return 緊急時治療開始年月日1
   */
  public QkanDateTextField getSickDate1(){
    if(sickDate1==null){

      sickDate1 = new QkanDateTextField();

      getSickDate1Container().setText("緊急時治療開始年月日1");

      sickDate1.setBindPath("401009");

      addSickDate1();
    }
    return sickDate1;

  }

  /**
   * 緊急時治療開始年月日1コンテナを取得します。
   * @return 緊急時治療開始年月日1コンテナ
   */
  protected ACLabelContainer getSickDate1Container(){
    if(sickDate1Container==null){
      sickDate1Container = new ACLabelContainer();
      sickDate1Container.setFollowChildEnabled(true);
      sickDate1Container.setVAlignment(VRLayout.CENTER);
      sickDate1Container.add(getSickDate1(), null);
    }
    return sickDate1Container;
  }

  /**
   * 傷病コンテナ2を取得します。
   * @return 傷病コンテナ2
   */
  public ACBackLabelContainer getSicks2(){
    if(sicks2==null){

      sicks2 = new ACBackLabelContainer();

      addSicks2();
    }
    return sicks2;

  }

  /**
   * 緊急時傷病名2を取得します。
   * @return 緊急時傷病名2
   */
  public ACTextField getSickName2(){
    if(sickName2==null){

      sickName2 = new ACTextField();

      getSickName2Container().setText("緊急時傷病名2");

      sickName2.setBindPath("401010");

      sickName2.setColumns(20);

      sickName2.setIMEMode(InputSubset.KANJI);

      sickName2.setMaxLength(20);

      addSickName2();
    }
    return sickName2;

  }

  /**
   * 緊急時傷病名2コンテナを取得します。
   * @return 緊急時傷病名2コンテナ
   */
  protected ACLabelContainer getSickName2Container(){
    if(sickName2Container==null){
      sickName2Container = new ACLabelContainer();
      sickName2Container.setFollowChildEnabled(true);
      sickName2Container.setVAlignment(VRLayout.CENTER);
      sickName2Container.add(getSickName2(), null);
    }
    return sickName2Container;
  }

  /**
   * 緊急時治療開始年月日2を取得します。
   * @return 緊急時治療開始年月日2
   */
  public QkanDateTextField getSickDate2(){
    if(sickDate2==null){

      sickDate2 = new QkanDateTextField();

      getSickDate2Container().setText("緊急時治療開始年月日2");

      sickDate2.setBindPath("401011");

      addSickDate2();
    }
    return sickDate2;

  }

  /**
   * 緊急時治療開始年月日2コンテナを取得します。
   * @return 緊急時治療開始年月日2コンテナ
   */
  protected ACLabelContainer getSickDate2Container(){
    if(sickDate2Container==null){
      sickDate2Container = new ACLabelContainer();
      sickDate2Container.setFollowChildEnabled(true);
      sickDate2Container.setVAlignment(VRLayout.CENTER);
      sickDate2Container.add(getSickDate2(), null);
    }
    return sickDate2Container;
  }

  /**
   * 傷病コンテナ3を取得します。
   * @return 傷病コンテナ3
   */
  public ACBackLabelContainer getSicks3(){
    if(sicks3==null){

      sicks3 = new ACBackLabelContainer();

      addSicks3();
    }
    return sicks3;

  }

  /**
   * 緊急時傷病名3を取得します。
   * @return 緊急時傷病名3
   */
  public ACTextField getSickName3(){
    if(sickName3==null){

      sickName3 = new ACTextField();

      getSickName3Container().setText("緊急時傷病名3");

      sickName3.setBindPath("401012");

      sickName3.setColumns(20);

      sickName3.setIMEMode(InputSubset.KANJI);

      sickName3.setMaxLength(20);

      addSickName3();
    }
    return sickName3;

  }

  /**
   * 緊急時傷病名3コンテナを取得します。
   * @return 緊急時傷病名3コンテナ
   */
  protected ACLabelContainer getSickName3Container(){
    if(sickName3Container==null){
      sickName3Container = new ACLabelContainer();
      sickName3Container.setFollowChildEnabled(true);
      sickName3Container.setVAlignment(VRLayout.CENTER);
      sickName3Container.add(getSickName3(), null);
    }
    return sickName3Container;
  }

  /**
   * 緊急時治療開始年月日3を取得します。
   * @return 緊急時治療開始年月日3
   */
  public QkanDateTextField getSickDate3(){
    if(sickDate3==null){

      sickDate3 = new QkanDateTextField();

      getSickDate3Container().setText("緊急時治療開始年月日3");

      sickDate3.setBindPath("401013");

      addSickDate3();
    }
    return sickDate3;

  }

  /**
   * 緊急時治療開始年月日3コンテナを取得します。
   * @return 緊急時治療開始年月日3コンテナ
   */
  protected ACLabelContainer getSickDate3Container(){
    if(sickDate3Container==null){
      sickDate3Container = new ACLabelContainer();
      sickDate3Container.setFollowChildEnabled(true);
      sickDate3Container.setVAlignment(VRLayout.CENTER);
      sickDate3Container.add(getSickDate3(), null);
    }
    return sickDate3Container;
  }

  /**
   * 往診医療機関名を取得します。
   * @return 往診医療機関名
   */
  public ACTextField getHouseCallProviderName(){
    if(houseCallProviderName==null){

      houseCallProviderName = new ACTextField();

      getHouseCallProviderNameContainer().setText("往診医療機関名");

      houseCallProviderName.setBindPath("401015");

      houseCallProviderName.setColumns(20);

      houseCallProviderName.setIMEMode(InputSubset.KANJI);

      houseCallProviderName.setMaxLength(20);

      addHouseCallProviderName();
    }
    return houseCallProviderName;

  }

  /**
   * 往診医療機関名コンテナを取得します。
   * @return 往診医療機関名コンテナ
   */
  protected ACLabelContainer getHouseCallProviderNameContainer(){
    if(houseCallProviderNameContainer==null){
      houseCallProviderNameContainer = new ACLabelContainer();
      houseCallProviderNameContainer.setFollowChildEnabled(true);
      houseCallProviderNameContainer.setVAlignment(VRLayout.CENTER);
      houseCallProviderNameContainer.add(getHouseCallProviderName(), null);
    }
    return houseCallProviderNameContainer;
  }

  /**
   * 通院医療機関名を取得します。
   * @return 通院医療機関名
   */
  public ACTextField getAttendProviderName(){
    if(attendProviderName==null){

      attendProviderName = new ACTextField();

      getAttendProviderNameContainer().setText("通院医療機関名");

      attendProviderName.setBindPath("401017");

      attendProviderName.setColumns(20);

      attendProviderName.setIMEMode(InputSubset.KANJI);

      attendProviderName.setMaxLength(20);

      addAttendProviderName();
    }
    return attendProviderName;

  }

  /**
   * 通院医療機関名コンテナを取得します。
   * @return 通院医療機関名コンテナ
   */
  protected ACLabelContainer getAttendProviderNameContainer(){
    if(attendProviderNameContainer==null){
      attendProviderNameContainer = new ACLabelContainer();
      attendProviderNameContainer.setFollowChildEnabled(true);
      attendProviderNameContainer.setVAlignment(VRLayout.CENTER);
      attendProviderNameContainer.add(getAttendProviderName(), null);
    }
    return attendProviderNameContainer;
  }

  /**
   * 隠しフィールドを取得します。
   * @return 隠しフィールド
   */
  public ACPanel getHiddens(){
    if(hiddens==null){

      hiddens = new ACPanel();

      hiddens.setVisible(false);

      addHiddens();
    }
    return hiddens;

  }

  /**
   * 摘要1を取得します。
   * @return 摘要1
   */
  public ACTextField getSummary1(){
    if(summary1==null){

      summary1 = new ACTextField();

      summary1.setBindPath("401026");

      addSummary1();
    }
    return summary1;

  }

  /**
   * 摘要2を取得します。
   * @return 摘要2
   */
  public ACTextField getSummary2(){
    if(summary2==null){

      summary2 = new ACTextField();

      summary2.setBindPath("401027");

      addSummary2();
    }
    return summary2;

  }

  /**
   * 摘要3を取得します。
   * @return 摘要3
   */
  public ACTextField getSummary3(){
    if(summary3==null){

      summary3 = new ACTextField();

      summary3.setBindPath("401028");

      addSummary3();
    }
    return summary3;

  }

  /**
   * 摘要4を取得します。
   * @return 摘要4
   */
  public ACTextField getSummary4(){
    if(summary4==null){

      summary4 = new ACTextField();

      summary4.setBindPath("401029");

      addSummary4();
    }
    return summary4;

  }

  /**
   * 摘要5を取得します。
   * @return 摘要5
   */
  public ACTextField getSummary5(){
    if(summary5==null){

      summary5 = new ACTextField();

      summary5.setBindPath("401030");

      addSummary5();
    }
    return summary5;

  }

  /**
   * 摘要6を取得します。
   * @return 摘要6
   */
  public ACTextField getSummary6(){
    if(summary6==null){

      summary6 = new ACTextField();

      summary6.setBindPath("401031");

      addSummary6();
    }
    return summary6;

  }

  /**
   * 摘要7を取得します。
   * @return 摘要7
   */
  public ACTextField getSummary7(){
    if(summary7==null){

      summary7 = new ACTextField();

      summary7.setBindPath("401032");

      addSummary7();
    }
    return summary7;

  }

  /**
   * 摘要8を取得します。
   * @return 摘要8
   */
  public ACTextField getSummary8(){
    if(summary8==null){

      summary8 = new ACTextField();

      summary8.setBindPath("401033");

      addSummary8();
    }
    return summary8;

  }

  /**
   * 摘要9を取得します。
   * @return 摘要9
   */
  public ACTextField getSummary9(){
    if(summary9==null){

      summary9 = new ACTextField();

      summary9.setBindPath("401034");

      addSummary9();
    }
    return summary9;

  }

  /**
   * 摘要10を取得します。
   * @return 摘要10
   */
  public ACTextField getSummary10(){
    if(summary10==null){

      summary10 = new ACTextField();

      summary10.setBindPath("401035");

      addSummary10();
    }
    return summary10;

  }

  /**
   * 摘要11を取得します。
   * @return 摘要11
   */
  public ACTextField getSummary11(){
    if(summary11==null){

      summary11 = new ACTextField();

      summary11.setBindPath("401036");

      addSummary11();
    }
    return summary11;

  }

  /**
   * 摘要12を取得します。
   * @return 摘要12
   */
  public ACTextField getSummary12(){
    if(summary12==null){

      summary12 = new ACTextField();

      summary12.setBindPath("401037");

      addSummary12();
    }
    return summary12;

  }

  /**
   * 摘要13を取得します。
   * @return 摘要13
   */
  public ACTextField getSummary13(){
    if(summary13==null){

      summary13 = new ACTextField();

      summary13.setBindPath("401038");

      addSummary13();
    }
    return summary13;

  }

  /**
   * 摘要14を取得します。
   * @return 摘要14
   */
  public ACTextField getSummary14(){
    if(summary14==null){

      summary14 = new ACTextField();

      summary14.setBindPath("401039");

      addSummary14();
    }
    return summary14;

  }

  /**
   * 摘要15を取得します。
   * @return 摘要15
   */
  public ACTextField getSummary15(){
    if(summary15==null){

      summary15 = new ACTextField();

      summary15.setBindPath("401040");

      addSummary15();
    }
    return summary15;

  }

  /**
   * 摘要16を取得します。
   * @return 摘要16
   */
  public ACTextField getSummary16(){
    if(summary16==null){

      summary16 = new ACTextField();

      summary16.setBindPath("401041");

      addSummary16();
    }
    return summary16;

  }

  /**
   * 摘要17を取得します。
   * @return 摘要17
   */
  public ACTextField getSummary17(){
    if(summary17==null){

      summary17 = new ACTextField();

      summary17.setBindPath("401042");

      addSummary17();
    }
    return summary17;

  }

  /**
   * 摘要18を取得します。
   * @return 摘要18
   */
  public ACTextField getSummary18(){
    if(summary18==null){

      summary18 = new ACTextField();

      summary18.setBindPath("401043");

      addSummary18();
    }
    return summary18;

  }

  /**
   * 摘要19を取得します。
   * @return 摘要19
   */
  public ACTextField getSummary19(){
    if(summary19==null){

      summary19 = new ACTextField();

      summary19.setBindPath("401044");

      addSummary19();
    }
    return summary19;

  }

  /**
   * 摘要20を取得します。
   * @return 摘要20
   */
  public ACTextField getSummary20(){
    if(summary20==null){

      summary20 = new ACTextField();

      summary20.setBindPath("401045");

      addSummary20();
    }
    return summary20;

  }

  /**
   * 編集領域・ボタンを取得します。
   * @return 編集領域・ボタン
   */
  public ACPanel getMedicalButtons(){
    if(medicalButtons==null){

      medicalButtons = new ACPanel();

      addMedicalButtons();
    }
    return medicalButtons;

  }

  /**
   * クリアを取得します。
   * @return クリア
   */
  public ACButton getMedicalClear(){
    if(medicalClear==null){

      medicalClear = new ACButton();

      medicalClear.setText("クリア");

      medicalClear.setToolTipText("特定治療費情報をクリアします。");

      medicalClear.setIconPath(ACConstants.ICON_PATH_CLEAR_16);

      addMedicalClear();
    }
    return medicalClear;

  }

  /**
   * 追加を取得します。
   * @return 追加
   */
  public ACButton getMedicalInsert(){
    if(medicalInsert==null){

      medicalInsert = new ACButton();

      medicalInsert.setText("追加");

      medicalInsert.setToolTipText("特定治療費情報を追加します。");

      medicalInsert.setIconPath(ACConstants.ICON_PATH_RECORD_DOWNLOAD_16);

      addMedicalInsert();
    }
    return medicalInsert;

  }

  /**
   * 書替を取得します。
   * @return 書替
   */
  public ACButton getMedicalUpdate(){
    if(medicalUpdate==null){

      medicalUpdate = new ACButton();

      medicalUpdate.setText("書替");

      medicalUpdate.setToolTipText("特定治療費情報を書き換えます。");

      medicalUpdate.setIconPath(ACConstants.ICON_PATH_STATE_UPDATE_16);

      addMedicalUpdate();
    }
    return medicalUpdate;

  }

  /**
   * 削除を取得します。
   * @return 削除
   */
  public ACButton getMedicalDelete(){
    if(medicalDelete==null){

      medicalDelete = new ACButton();

      medicalDelete.setText("削除");

      medicalDelete.setToolTipText("特定治療費を削除します。");

      medicalDelete.setIconPath(ACConstants.ICON_PATH_STATE_DELETE_16);

      addMedicalDelete();
    }
    return medicalDelete;

  }

  /**
   * 特定治療費一覧を取得します。
   * @return 特定治療費一覧
   */
  public ACTable getMedicalTable(){
    if(medicalTable==null){

      medicalTable = new ACTable();

      medicalTable.setColumnModel(getMedicalTableColumnModel());

      addMedicalTable();
    }
    return medicalTable;

  }

  /**
   * 特定治療費一覧カラムモデルを取得します。
   * @return 特定治療費一覧カラムモデル
   */
  protected VRTableColumnModel getMedicalTableColumnModel(){
    if(medicalTableColumnModel==null){
      medicalTableColumnModel = new VRTableColumnModel(new TableColumn[]{});
      addMedicalTableColumnModel();
    }
    return medicalTableColumnModel;
  }

  /**
   * No.を取得します。
   * @return No.
   */
  public ACTableColumn getMedicalNo(){
    if(medicalNo==null){

      medicalNo = new ACTableColumn();

      medicalNo.setHeaderValue("No.");

      medicalNo.setColumnName("401008");

      medicalNo.setColumns(3);

      medicalNo.setRendererType(ACTableCellViewer.RENDERER_TYPE_SERIAL_NO);

      medicalNo.setSortable(false);

      addMedicalNo();
    }
    return medicalNo;

  }

  /**
   * 緊急時傷病名1を取得します。
   * @return 緊急時傷病名1
   */
  public ACTableColumn getMedicalSickName1(){
    if(medicalSickName1==null){

      medicalSickName1 = new ACTableColumn();

      medicalSickName1.setHeaderValue("緊急時傷病名1");

      medicalSickName1.setColumnName("401008");

      medicalSickName1.setColumns(15);

      addMedicalSickName1();
    }
    return medicalSickName1;

  }

  /**
   * 緊急時治療開始年月日1を取得します。
   * @return 緊急時治療開始年月日1
   */
  public ACTableColumn getMedicalSickDate1(){
    if(medicalSickDate1==null){

      medicalSickDate1 = new ACTableColumn();

      medicalSickDate1.setHeaderValue("緊急時治療開始年月日1");

      medicalSickDate1.setColumnName("401009");

      medicalSickDate1.setColumns(13);

      medicalSickDate1.setFormat(new ACBorderBlankDateFormat("gggee年MM月dd日"));

      addMedicalSickDate1();
    }
    return medicalSickDate1;

  }

  /**
   * 緊急時傷病名2を取得します。
   * @return 緊急時傷病名2
   */
  public ACTableColumn getMedicalSickName2(){
    if(medicalSickName2==null){

      medicalSickName2 = new ACTableColumn();

      medicalSickName2.setHeaderValue("緊急時傷病名2");

      medicalSickName2.setColumnName("401010");

      medicalSickName2.setColumns(15);

      addMedicalSickName2();
    }
    return medicalSickName2;

  }

  /**
   * 緊急時治療開始年月日2を取得します。
   * @return 緊急時治療開始年月日2
   */
  public ACTableColumn getMedicalSickDate2(){
    if(medicalSickDate2==null){

      medicalSickDate2 = new ACTableColumn();

      medicalSickDate2.setHeaderValue("緊急時治療開始年月日2");

      medicalSickDate2.setColumnName("401011");

      medicalSickDate2.setColumns(13);

      medicalSickDate2.setFormat(new ACBorderBlankDateFormat("gggee年MM月dd日"));

      addMedicalSickDate2();
    }
    return medicalSickDate2;

  }

  /**
   * 緊急時傷病名3を取得します。
   * @return 緊急時傷病名3
   */
  public ACTableColumn getMedicalSickName3(){
    if(medicalSickName3==null){

      medicalSickName3 = new ACTableColumn();

      medicalSickName3.setHeaderValue("緊急時傷病名3");

      medicalSickName3.setColumnName("401012");

      medicalSickName3.setColumns(15);

      addMedicalSickName3();
    }
    return medicalSickName3;

  }

  /**
   * 緊急時治療開始年月日3を取得します。
   * @return 緊急時治療開始年月日3
   */
  public ACTableColumn getMedicalSickDate3(){
    if(medicalSickDate3==null){

      medicalSickDate3 = new ACTableColumn();

      medicalSickDate3.setHeaderValue("緊急時治療開始年月日3");

      medicalSickDate3.setColumnName("401013");

      medicalSickDate3.setColumns(13);

      medicalSickDate3.setFormat(new ACBorderBlankDateFormat("gggee年MM月dd日"));

      addMedicalSickDate3();
    }
    return medicalSickDate3;

  }

  /**
   * 往診医療機関名を取得します。
   * @return 往診医療機関名
   */
  public ACTableColumn getMedicalHouseCallProviderName(){
    if(medicalHouseCallProviderName==null){

      medicalHouseCallProviderName = new ACTableColumn();

      medicalHouseCallProviderName.setHeaderValue("往診医療機関名");

      medicalHouseCallProviderName.setColumnName("401015");

      medicalHouseCallProviderName.setColumns(15);

      addMedicalHouseCallProviderName();
    }
    return medicalHouseCallProviderName;

  }

  /**
   * 通院医療機関名を取得します。
   * @return 通院医療機関名
   */
  public ACTableColumn getMedicalAttendProviderName(){
    if(medicalAttendProviderName==null){

      medicalAttendProviderName = new ACTableColumn();

      medicalAttendProviderName.setHeaderValue("通院医療機関名");

      medicalAttendProviderName.setColumnName("401017");

      medicalAttendProviderName.setColumns(15);

      addMedicalAttendProviderName();
    }
    return medicalAttendProviderName;

  }

  /**
   * ボタン領域を取得します。
   * @return ボタン領域
   */
  public ACPanel getButtons(){
    if(buttons==null){

      buttons = new ACPanel();

      addButtons();
    }
    return buttons;

  }

  /**
   * OKを取得します。
   * @return OK
   */
  public ACButton getAplly(){
    if(aplly==null){

      aplly = new ACButton();

      aplly.setText("OK");

      aplly.setToolTipText("入力された情報で特定治療費情報を更新します。");

      aplly.setMnemonic('O');

      aplly.setIconPath(ACConstants.ICON_PATH_OK_16);

      addAplly();
    }
    return aplly;

  }

  /**
   * キャンセルを取得します。
   * @return キャンセル
   */
  public ACButton getClose(){
    if(close==null){

      close = new ACButton();

      close.setText("キャンセル(C)");

      close.setToolTipText("特定治療費情報の更新は行わず、前の画面に戻ります。");

      close.setMnemonic('C');

      close.setIconPath(ACConstants.ICON_PATH_CANCEL_16);

      addClose();
    }
    return close;

  }

  /**
   * コンストラクタです。
   */
  public QP004001Design() {

    super(ACFrame.getInstance(), true);
    this.getContentPane().setLayout(new VRLayout());
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    try {
      initialize();

      setSize(700, 400);

      // ウィンドウを中央に配置
      Point pos;
      try{
          pos= ACFrame.getInstance().getLocationOnScreen();
      }catch(Exception ex){
          pos = new Point(0,0);
      }
      Dimension screenSize = ACFrame.getInstance().getSize();
      Dimension frameSize = this.getSize();
      if (frameSize.height > screenSize.height) {
          frameSize.height = screenSize.height;
      }
      if (frameSize.width > screenSize.width) {
          frameSize.width = screenSize.width;
      }
      this.setLocation((int)(pos.getX()+(screenSize.width - frameSize.width) / 2),
              (int)(pos.getY()+(screenSize.height - frameSize.height) / 2));

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

    this.getContentPane().add(getContents(), VRLayout.NORTH);

    this.getContentPane().add(getMedicalTable(), VRLayout.CLIENT);

    this.getContentPane().add(getButtons(), VRLayout.SOUTH);
  }

  /**
   * 特定治療費情報に内部項目を追加します。
   */
  protected void addContents(){

    contents.add(getEditors(), VRLayout.CLIENT);

    contents.add(getMedicalButtons(), VRLayout.SOUTH);
  }

  /**
   * 編集領域に内部項目を追加します。
   */
  protected void addEditors(){

    editors.add(getPoints(), VRLayout.NORTH);

    editors.add(getRecordEditors(), VRLayout.CLIENT);

  }

  /**
   * 特定治療費に内部項目を追加します。
   */
  protected void addPoints(){

    points.add(getRehavilitationPointContainer(), VRLayout.FLOW_INSETLINE);

    points.add(getProcessPointContainer(), VRLayout.FLOW_INSETLINE);

    points.add(getOperationPointContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    points.add(getAnesthesiaPointContainer(), VRLayout.FLOW_INSETLINE);

    points.add(getRadiationPointContainer(), VRLayout.FLOW_INSETLINE);

  }

  /**
   * リハビリテーション点数に内部項目を追加します。
   */
  protected void addRehavilitationPoint(){

  }

  /**
   * 処置点数に内部項目を追加します。
   */
  protected void addProcessPoint(){

  }

  /**
   * 手術点数に内部項目を追加します。
   */
  protected void addOperationPoint(){

  }

  /**
   * 麻酔点数に内部項目を追加します。
   */
  protected void addAnesthesiaPoint(){

  }

  /**
   * 放射線治療点数に内部項目を追加します。
   */
  protected void addRadiationPoint(){

  }

  /**
   * レコード領域に内部項目を追加します。
   */
  protected void addRecordEditors(){

    recordEditors.add(getSicks1(), VRLayout.FLOW_INSETLINE_RETURN);

    recordEditors.add(getSicks2(), VRLayout.FLOW_INSETLINE_RETURN);

    recordEditors.add(getSicks3(), VRLayout.FLOW_INSETLINE_RETURN);

    recordEditors.add(getHouseCallProviderNameContainer(), VRLayout.FLOW_INSETLINE);

    recordEditors.add(getAttendProviderNameContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    recordEditors.add(getHiddens(), VRLayout.FLOW_RETURN);

  }

  /**
   * 傷病コンテナ1に内部項目を追加します。
   */
  protected void addSicks1(){

    sicks1.add(getSickName1Container(), VRLayout.FLOW);

    sicks1.add(getSickDate1Container(), VRLayout.FLOW);

  }

  /**
   * 緊急時傷病名1に内部項目を追加します。
   */
  protected void addSickName1(){

  }

  /**
   * 緊急時治療開始年月日1に内部項目を追加します。
   */
  protected void addSickDate1(){

  }

  /**
   * 傷病コンテナ2に内部項目を追加します。
   */
  protected void addSicks2(){

    sicks2.add(getSickName2Container(), VRLayout.FLOW);

    sicks2.add(getSickDate2Container(), VRLayout.FLOW);

  }

  /**
   * 緊急時傷病名2に内部項目を追加します。
   */
  protected void addSickName2(){

  }

  /**
   * 緊急時治療開始年月日2に内部項目を追加します。
   */
  protected void addSickDate2(){

  }

  /**
   * 傷病コンテナ3に内部項目を追加します。
   */
  protected void addSicks3(){

    sicks3.add(getSickName3Container(), VRLayout.FLOW);

    sicks3.add(getSickDate3Container(), VRLayout.FLOW);

  }

  /**
   * 緊急時傷病名3に内部項目を追加します。
   */
  protected void addSickName3(){

  }

  /**
   * 緊急時治療開始年月日3に内部項目を追加します。
   */
  protected void addSickDate3(){

  }

  /**
   * 往診医療機関名に内部項目を追加します。
   */
  protected void addHouseCallProviderName(){

  }

  /**
   * 通院医療機関名に内部項目を追加します。
   */
  protected void addAttendProviderName(){

  }

  /**
   * 隠しフィールドに内部項目を追加します。
   */
  protected void addHiddens(){

    hiddens.add(getSummary1(), VRLayout.FLOW);

    hiddens.add(getSummary2(), VRLayout.FLOW);

    hiddens.add(getSummary3(), VRLayout.FLOW);

    hiddens.add(getSummary4(), VRLayout.FLOW);

    hiddens.add(getSummary5(), VRLayout.FLOW);

    hiddens.add(getSummary6(), VRLayout.FLOW);

    hiddens.add(getSummary7(), VRLayout.FLOW);

    hiddens.add(getSummary8(), VRLayout.FLOW);

    hiddens.add(getSummary9(), VRLayout.FLOW);

    hiddens.add(getSummary10(), VRLayout.FLOW);

    hiddens.add(getSummary11(), VRLayout.FLOW);

    hiddens.add(getSummary12(), VRLayout.FLOW);

    hiddens.add(getSummary13(), VRLayout.FLOW);

    hiddens.add(getSummary14(), VRLayout.FLOW);

    hiddens.add(getSummary15(), VRLayout.FLOW);

    hiddens.add(getSummary16(), VRLayout.FLOW);

    hiddens.add(getSummary17(), VRLayout.FLOW);

    hiddens.add(getSummary18(), VRLayout.FLOW);

    hiddens.add(getSummary19(), VRLayout.FLOW);

    hiddens.add(getSummary20(), VRLayout.FLOW);

  }

  /**
   * 摘要1に内部項目を追加します。
   */
  protected void addSummary1(){

  }

  /**
   * 摘要2に内部項目を追加します。
   */
  protected void addSummary2(){

  }

  /**
   * 摘要3に内部項目を追加します。
   */
  protected void addSummary3(){

  }

  /**
   * 摘要4に内部項目を追加します。
   */
  protected void addSummary4(){

  }

  /**
   * 摘要5に内部項目を追加します。
   */
  protected void addSummary5(){

  }

  /**
   * 摘要6に内部項目を追加します。
   */
  protected void addSummary6(){

  }

  /**
   * 摘要7に内部項目を追加します。
   */
  protected void addSummary7(){

  }

  /**
   * 摘要8に内部項目を追加します。
   */
  protected void addSummary8(){

  }

  /**
   * 摘要9に内部項目を追加します。
   */
  protected void addSummary9(){

  }

  /**
   * 摘要10に内部項目を追加します。
   */
  protected void addSummary10(){

  }

  /**
   * 摘要11に内部項目を追加します。
   */
  protected void addSummary11(){

  }

  /**
   * 摘要12に内部項目を追加します。
   */
  protected void addSummary12(){

  }

  /**
   * 摘要13に内部項目を追加します。
   */
  protected void addSummary13(){

  }

  /**
   * 摘要14に内部項目を追加します。
   */
  protected void addSummary14(){

  }

  /**
   * 摘要15に内部項目を追加します。
   */
  protected void addSummary15(){

  }

  /**
   * 摘要16に内部項目を追加します。
   */
  protected void addSummary16(){

  }

  /**
   * 摘要17に内部項目を追加します。
   */
  protected void addSummary17(){

  }

  /**
   * 摘要18に内部項目を追加します。
   */
  protected void addSummary18(){

  }

  /**
   * 摘要19に内部項目を追加します。
   */
  protected void addSummary19(){

  }

  /**
   * 摘要20に内部項目を追加します。
   */
  protected void addSummary20(){

  }

  /**
   * 編集領域・ボタンに内部項目を追加します。
   */
  protected void addMedicalButtons(){

    medicalButtons.add(getMedicalDelete(), VRLayout.EAST);
    medicalButtons.add(getMedicalUpdate(), VRLayout.EAST);
    medicalButtons.add(getMedicalInsert(), VRLayout.EAST);
    medicalButtons.add(getMedicalClear(), VRLayout.EAST);
  }

  /**
   * クリアに内部項目を追加します。
   */
  protected void addMedicalClear(){

  }

  /**
   * 追加に内部項目を追加します。
   */
  protected void addMedicalInsert(){

  }

  /**
   * 書替に内部項目を追加します。
   */
  protected void addMedicalUpdate(){

  }

  /**
   * 削除に内部項目を追加します。
   */
  protected void addMedicalDelete(){

  }

  /**
   * 特定治療費一覧に内部項目を追加します。
   */
  protected void addMedicalTable(){

  }

  /**
   * 特定治療費一覧カラムモデルに内部項目を追加します。
   */
  protected void addMedicalTableColumnModel(){

    getMedicalTableColumnModel().addColumn(getMedicalNo());

    getMedicalTableColumnModel().addColumn(getMedicalSickName1());

    getMedicalTableColumnModel().addColumn(getMedicalSickDate1());

    getMedicalTableColumnModel().addColumn(getMedicalSickName2());

    getMedicalTableColumnModel().addColumn(getMedicalSickDate2());

    getMedicalTableColumnModel().addColumn(getMedicalSickName3());

    getMedicalTableColumnModel().addColumn(getMedicalSickDate3());

    getMedicalTableColumnModel().addColumn(getMedicalHouseCallProviderName());

    getMedicalTableColumnModel().addColumn(getMedicalAttendProviderName());

  }

  /**
   * No.に内部項目を追加します。
   */
  protected void addMedicalNo(){

  }

  /**
   * 緊急時傷病名1に内部項目を追加します。
   */
  protected void addMedicalSickName1(){

  }

  /**
   * 緊急時治療開始年月日1に内部項目を追加します。
   */
  protected void addMedicalSickDate1(){

  }

  /**
   * 緊急時傷病名2に内部項目を追加します。
   */
  protected void addMedicalSickName2(){

  }

  /**
   * 緊急時治療開始年月日2に内部項目を追加します。
   */
  protected void addMedicalSickDate2(){

  }

  /**
   * 緊急時傷病名3に内部項目を追加します。
   */
  protected void addMedicalSickName3(){

  }

  /**
   * 緊急時治療開始年月日3に内部項目を追加します。
   */
  protected void addMedicalSickDate3(){

  }

  /**
   * 往診医療機関名に内部項目を追加します。
   */
  protected void addMedicalHouseCallProviderName(){

  }

  /**
   * 通院医療機関名に内部項目を追加します。
   */
  protected void addMedicalAttendProviderName(){

  }

  /**
   * ボタン領域に内部項目を追加します。
   */
  protected void addButtons(){

    buttons.add(getClose(), VRLayout.EAST);
    buttons.add(getAplly(), VRLayout.EAST);
  }

  /**
   * OKに内部項目を追加します。
   */
  protected void addAplly(){

  }

  /**
   * キャンセルに内部項目を追加します。
   */
  protected void addClose(){

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

  public void setVisible(boolean visible){
    if(visible){
      try{
        initAffair(null);
      }catch(Throwable ex){
        ACCommon.getInstance().showExceptionMessage(ex);
      }
    }
    super.setVisible(visible);
  }
  public static void main(String[] args) {
    //デフォルトデバッグ起動
    try {
      ACFrame.setVRLookAndFeel();
      ACFrame.getInstance().setFrameEventProcesser(new QkanFrameEventProcesser());
      new QP004001Design().setVisible(true);
      System.exit(0);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QP004001Design getThis() {
    return this;
  }
}
