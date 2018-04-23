
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
 * 作成日: 2018/04/20  日本コンピューター株式会社 藤原　伸 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 請求データ作成 (P)
 * プロセス 確認・修正 (004)
 * プログラム 明細書基本情報編集画面 (QP004)
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
 * 明細書基本情報編集画面画面項目デザイン(QP004) 
 */
public class QP004Design extends QkanAffairContainer implements ACAffairable {
  //GUIコンポーネント

  private ACAffairButtonBar buttons;

  private ACAffairButton tekiyoHelp;

  private ACAffairButton detail;

  private ACAffairButton update;

  private ACPanel contents;

  private ACPanel patientNames;

  private ACLabel patinetNameLabel;

  private ACTextField patientName;

  private ACLabel patientNoLabel1;

  private ACTextField patientNo;

  private ACLabel PatientNoLabel2;

  private ACGroupBox kyotakuIdouGroup;

  private QkanDateTextField contentsStartDate;

  private ACLabelContainer contentsStartDateContainer;

  private QkanDateTextField contentsStopDate;

  private ACLabelContainer contentsStopDateContainer;

  private ACValueArrayRadioButtonGroup contentsStopReasons;

  private ACLabelContainer contentsStopReasonsContainer;

  private ACListModelAdapter contentsStopReasonsModel;

  private ACRadioButtonItem contentsStopReaseonHigaito;

  private ACRadioButtonItem contentsStopReaseonNyuin;

  private ACRadioButtonItem contentsStopReaseonDeath;

  private ACRadioButtonItem contentsStopReaseonEtc;

  private ACRadioButtonItem contentsStopReaseonTokuyo;

  private ACRadioButtonItem contentsStopReaseonRouken;

  private ACRadioButtonItem contentsStopReaseonRyoyo;

  private ACRadioButtonItem contentsStopReaseonIryoin;

  private ACGroupBox shisetsuIdouGroup;

  private QkanDateTextField contentsNyushoDate;

  private ACLabelContainer contentsNyushoDateContainer;

  private QkanDateTextField contentsTaishoDate;

  private ACLabelContainer contentsTaishoDateContainer;

  private ACTextField contentsNyushoDays;

  private ACLabelContainer contentsNyushoDaysContainer;

  private ACTextField contentsTankiNyushoDays;

  private ACLabelContainer contentsTankiNyushoDaysContainer;

  private ACTextField contentsGaihakuDays;

  private ACLabelContainer contentsGaihakuDaysContainer;

  private ACValueArrayRadioButtonGroup contentsNyushoJotais;

  private ACLabelContainer contentsNyushoJotaisContainer;

  private ACListModelAdapter contentsNyushoJotaisModel;

  private ACRadioButtonItem contentsNyushoZaitaku;

  private ACRadioButtonItem contentsNyushoIryo;

  private ACRadioButtonItem contentsNyushoFukushi;

  private ACRadioButtonItem contentsNyushoHoken;

  private ACRadioButtonItem contentsNyushoRyoyo;

  private ACRadioButtonItem contentsNyushoNinchi;

  private ACRadioButtonItem contentsNyushoTokutei;

  private ACRadioButtonItem contentsNyushoEtc;

  private ACRadioButtonItem contentsNyushoIryoin;

  private ACValueArrayRadioButtonGroup contentsTaishoJotais;

  private ACLabelContainer contentsTaishoJotaisContainer;

  private ACListModelAdapter contentsTaishoJotaisModel;

  private ACRadioButtonItem contentsTaishoJotaiZaitaku;

  private ACRadioButtonItem contentsTaishoJotaiNyuin;

  private ACRadioButtonItem contentsTaishoJotaiDeath;

  private ACRadioButtonItem contentsTaishoJotaiEtc;

  private ACRadioButtonItem contentsTaishoJotaiTokuyo;

  private ACRadioButtonItem contentsTaishoJotaiRouken;

  private ACRadioButtonItem contentsTaishoJotaiRyoyo;

  private ACRadioButtonItem contentsTaishoJotaiIryoin;

  private ACPanel editTekiyoPanel;

  private ACGroupBox baseSummaryArea;

  private ACTextField baseSummaryText;

  private ACTable baseSummaryTable;

  private VRTableColumnModel baseSummaryTableColumnModel;

  private ACTableColumn baseSummaryNoColumn;

  private ACTableColumn baseSummaryKindCodeColumn;

  private ACTableColumn baseSummaryNameColumn;

  private ACTableColumn baseSummaryNaiyoColumn;

  private ACGroupBox tekiyos;

  private ACTextField tekiyoText;

  private ACTable tekiyoTable;

  private VRTableColumnModel tekiyoTableColumnModel;

  private ACTableColumn tekiyoNoColumn;

  private ACTableColumn tekiyoServiceCodeColumn;

  private ACTableColumn tekiyoServiceNameColumn;

  private ACTableColumn tekiyoTimesColumn;

  private ACTableColumn tekiyoServiceUnitColumn;

  private ACTableColumn tekiyoTekiyoColumn;

  private ACGroupBox shinryos;

  private ACTextField shinryoDeseaseText;

  private ACLabelContainer shinryoDeseaseTextContainer;

  private ACTextField shinryoText;

  private ACTable sinryoTable;

  private VRTableColumnModel sinryoTableColumnModel;

  private ACTableColumn sinryoNoColumn;

  private ACTableColumn sinryoShikibetsuColumn;

  private ACTableColumn sinryoNameColumn;

  private ACTableColumn sinryoTimesColumn;

  private ACTableColumn sinryoUnitColumn;

  private ACTableColumn sinryoTekiyoColumn;

  //getter

  /**
   * ボタンバーを取得します。
   * @return ボタンバー
   */
  public ACAffairButtonBar getButtons(){
    if(buttons==null){

      buttons = new ACAffairButtonBar();

      buttons.setText("明細書基本情報編集");

      addButtons();
    }
    return buttons;

  }

  /**
   * 摘要表示ボタン(H)を取得します。
   * @return 摘要表示ボタン(H)
   */
  public ACAffairButton getTekiyoHelp(){
    if(tekiyoHelp==null){

      tekiyoHelp = new ACAffairButton();

      tekiyoHelp.setText("摘要記載(H)");

      tekiyoHelp.setToolTipText("摘要欄記載事項についての説明を表示します。");

      tekiyoHelp.setMnemonic('H');

      tekiyoHelp.setIconPath(ACConstants.ICON_PATH_QUESTION_24);

      addTekiyoHelp();
    }
    return tekiyoHelp;

  }

  /**
   * 詳細ボタン(E)を取得します。
   * @return 詳細ボタン(E)
   */
  public ACAffairButton getDetail(){
    if(detail==null){

      detail = new ACAffairButton();

      detail.setText("詳細(E)");

      detail.setToolTipText("さらに詳細な内容を確認・修正します。");

      detail.setMnemonic('E');

      detail.setIconPath(ACConstants.ICON_PATH_DETAIL_24);

      addDetail();
    }
    return detail;

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

      addContents();
    }
    return contents;

  }

  /**
   * 利用者名領域を取得します。
   * @return 利用者名領域
   */
  public ACPanel getPatientNames(){
    if(patientNames==null){

      patientNames = new ACPanel();

      patientNames.setHgap(3);

      patientNames.setVgap(3);

      addPatientNames();
    }
    return patientNames;

  }

  /**
   * 利用者名・ラベルを取得します。
   * @return 利用者名・ラベル
   */
  public ACLabel getPatinetNameLabel(){
    if(patinetNameLabel==null){

      patinetNameLabel = new ACLabel();

      patinetNameLabel.setText("利用者名");

      addPatinetNameLabel();
    }
    return patinetNameLabel;

  }

  /**
   * 利用者名を取得します。
   * @return 利用者名
   */
  public ACTextField getPatientName(){
    if(patientName==null){

      patientName = new ACTextField();

      patientName.setBindPath("PATIENT_NAME");

      patientName.setEditable(false);

      patientName.setColumns(35);

      patientName.setMaxLength(34);

      addPatientName();
    }
    return patientName;

  }

  /**
   * 利用者コード・ラベル1を取得します。
   * @return 利用者コード・ラベル1
   */
  public ACLabel getPatientNoLabel1(){
    if(patientNoLabel1==null){

      patientNoLabel1 = new ACLabel();

      patientNoLabel1.setText("（利用者コード");

      addPatientNoLabel1();
    }
    return patientNoLabel1;

  }

  /**
   * 利用者コードを取得します。
   * @return 利用者コード
   */
  public ACTextField getPatientNo(){
    if(patientNo==null){

      patientNo = new ACTextField();

      patientNo.setBindPath("PATIENT_CODE");

      patientNo.setEditable(false);

      patientNo.setColumns(15);

      patientNo.setMaxLength(20);

      addPatientNo();
    }
    return patientNo;

  }

  /**
   * 利用者コード・ラベル2を取得します。
   * @return 利用者コード・ラベル2
   */
  public ACLabel getPatientNoLabel2(){
    if(PatientNoLabel2==null){

      PatientNoLabel2 = new ACLabel();

      PatientNoLabel2.setText("）");

      addPatientNoLabel2();
    }
    return PatientNoLabel2;

  }

  /**
   * 居宅系異動情報を取得します。
   * @return 居宅系異動情報
   */
  public ACGroupBox getKyotakuIdouGroup(){
    if(kyotakuIdouGroup==null){

      kyotakuIdouGroup = new ACGroupBox();

      kyotakuIdouGroup.setText("異動情報");

      kyotakuIdouGroup.setAutoWrap(true);

      kyotakuIdouGroup.setFollowChildEnabled(true);

      kyotakuIdouGroup.setHgrid(200);

      addKyotakuIdouGroup();
    }
    return kyotakuIdouGroup;

  }

  /**
   * 開始年月日を取得します。
   * @return 開始年月日
   */
  public QkanDateTextField getContentsStartDate(){
    if(contentsStartDate==null){

      contentsStartDate = new QkanDateTextField();

      getContentsStartDateContainer().setText("開始年月日");

      contentsStartDate.setBindPath("201021");

      addContentsStartDate();
    }
    return contentsStartDate;

  }

  /**
   * 開始年月日コンテナを取得します。
   * @return 開始年月日コンテナ
   */
  protected ACLabelContainer getContentsStartDateContainer(){
    if(contentsStartDateContainer==null){
      contentsStartDateContainer = new ACLabelContainer();
      contentsStartDateContainer.setFollowChildEnabled(true);
      contentsStartDateContainer.setVAlignment(VRLayout.CENTER);
      contentsStartDateContainer.add(getContentsStartDate(), null);
    }
    return contentsStartDateContainer;
  }

  /**
   * 中止年月日を取得します。
   * @return 中止年月日
   */
  public QkanDateTextField getContentsStopDate(){
    if(contentsStopDate==null){

      contentsStopDate = new QkanDateTextField();

      getContentsStopDateContainer().setText("中止年月日");

      contentsStopDate.setBindPath("201022");

      addContentsStopDate();
    }
    return contentsStopDate;

  }

  /**
   * 中止年月日コンテナを取得します。
   * @return 中止年月日コンテナ
   */
  protected ACLabelContainer getContentsStopDateContainer(){
    if(contentsStopDateContainer==null){
      contentsStopDateContainer = new ACLabelContainer();
      contentsStopDateContainer.setFollowChildEnabled(true);
      contentsStopDateContainer.setVAlignment(VRLayout.CENTER);
      contentsStopDateContainer.add(getContentsStopDate(), null);
    }
    return contentsStopDateContainer;
  }

  /**
   * 中止理由コードを取得します。
   * @return 中止理由コード
   */
  public ACValueArrayRadioButtonGroup getContentsStopReasons(){
    if(contentsStopReasons==null){

      contentsStopReasons = new ACValueArrayRadioButtonGroup();

      getContentsStopReasonsContainer().setText("中止理由コード");

      contentsStopReasons.setBindPath("201023");

      contentsStopReasons.setNoSelectIndex(0);

      contentsStopReasons.setUseClearButton(true);

      contentsStopReasons.setModel(getContentsStopReasonsModel());

      contentsStopReasons.setValues(new int[]{1,3,4,5,6,7,8,9});

      addContentsStopReasons();
    }
    return contentsStopReasons;

  }

  /**
   * 中止理由コードコンテナを取得します。
   * @return 中止理由コードコンテナ
   */
  protected ACLabelContainer getContentsStopReasonsContainer(){
    if(contentsStopReasonsContainer==null){
      contentsStopReasonsContainer = new ACLabelContainer();
      contentsStopReasonsContainer.setFollowChildEnabled(true);
      contentsStopReasonsContainer.setVAlignment(VRLayout.CENTER);
      contentsStopReasonsContainer.add(getContentsStopReasons(), null);
    }
    return contentsStopReasonsContainer;
  }

  /**
   * 中止理由コードモデルを取得します。
   * @return 中止理由コードモデル
   */
  protected ACListModelAdapter getContentsStopReasonsModel(){
    if(contentsStopReasonsModel==null){
      contentsStopReasonsModel = new ACListModelAdapter();
      addContentsStopReasonsModel();
    }
    return contentsStopReasonsModel;
  }

  /**
   * 1.非該当を取得します。
   * @return 1.非該当
   */
  public ACRadioButtonItem getContentsStopReaseonHigaito(){
    if(contentsStopReaseonHigaito==null){

      contentsStopReaseonHigaito = new ACRadioButtonItem();

      contentsStopReaseonHigaito.setText("1.非該当");

      contentsStopReaseonHigaito.setGroup(getContentsStopReasons());

      contentsStopReaseonHigaito.setConstraints(VRLayout.FLOW);

      addContentsStopReaseonHigaito();
    }
    return contentsStopReaseonHigaito;

  }

  /**
   * 3.医療機関入院を取得します。
   * @return 3.医療機関入院
   */
  public ACRadioButtonItem getContentsStopReaseonNyuin(){
    if(contentsStopReaseonNyuin==null){

      contentsStopReaseonNyuin = new ACRadioButtonItem();

      contentsStopReaseonNyuin.setText("3.医療機関入院");

      contentsStopReaseonNyuin.setGroup(getContentsStopReasons());

      contentsStopReaseonNyuin.setConstraints(VRLayout.FLOW);

      addContentsStopReaseonNyuin();
    }
    return contentsStopReaseonNyuin;

  }

  /**
   * 4.死亡を取得します。
   * @return 4.死亡
   */
  public ACRadioButtonItem getContentsStopReaseonDeath(){
    if(contentsStopReaseonDeath==null){

      contentsStopReaseonDeath = new ACRadioButtonItem();

      contentsStopReaseonDeath.setText("4.死亡");

      contentsStopReaseonDeath.setGroup(getContentsStopReasons());

      contentsStopReaseonDeath.setConstraints(VRLayout.FLOW);

      addContentsStopReaseonDeath();
    }
    return contentsStopReaseonDeath;

  }

  /**
   * 5.その他を取得します。
   * @return 5.その他
   */
  public ACRadioButtonItem getContentsStopReaseonEtc(){
    if(contentsStopReaseonEtc==null){

      contentsStopReaseonEtc = new ACRadioButtonItem();

      contentsStopReaseonEtc.setText("5.その他");

      contentsStopReaseonEtc.setGroup(getContentsStopReasons());

      contentsStopReaseonEtc.setConstraints(VRLayout.FLOW_RETURN);

      addContentsStopReaseonEtc();
    }
    return contentsStopReaseonEtc;

  }

  /**
   * 6.介護老人福祉施設入所を取得します。
   * @return 6.介護老人福祉施設入所
   */
  public ACRadioButtonItem getContentsStopReaseonTokuyo(){
    if(contentsStopReaseonTokuyo==null){

      contentsStopReaseonTokuyo = new ACRadioButtonItem();

      contentsStopReaseonTokuyo.setText("6.介護老人福祉施設入所");

      contentsStopReaseonTokuyo.setGroup(getContentsStopReasons());

      contentsStopReaseonTokuyo.setConstraints(VRLayout.FLOW);

      addContentsStopReaseonTokuyo();
    }
    return contentsStopReaseonTokuyo;

  }

  /**
   * 7.介護老人保健施設入所を取得します。
   * @return 7.介護老人保健施設入所
   */
  public ACRadioButtonItem getContentsStopReaseonRouken(){
    if(contentsStopReaseonRouken==null){

      contentsStopReaseonRouken = new ACRadioButtonItem();

      contentsStopReaseonRouken.setText("7.介護老人保健施設入所");

      contentsStopReaseonRouken.setGroup(getContentsStopReasons());

      contentsStopReaseonRouken.setConstraints(VRLayout.FLOW);

      addContentsStopReaseonRouken();
    }
    return contentsStopReaseonRouken;

  }

  /**
   * 8.介護療養型医療施設入院を取得します。
   * @return 8.介護療養型医療施設入院
   */
  public ACRadioButtonItem getContentsStopReaseonRyoyo(){
    if(contentsStopReaseonRyoyo==null){

      contentsStopReaseonRyoyo = new ACRadioButtonItem();

      contentsStopReaseonRyoyo.setText("8.介護療養型医療施設入院");

      contentsStopReaseonRyoyo.setGroup(getContentsStopReasons());

      contentsStopReaseonRyoyo.setConstraints(VRLayout.FLOW);

      addContentsStopReaseonRyoyo();
    }
    return contentsStopReaseonRyoyo;

  }

  /**
   * 9.介護医療院入所を取得します。
   * @return 9.介護医療院入所
   */
  public ACRadioButtonItem getContentsStopReaseonIryoin(){
    if(contentsStopReaseonIryoin==null){

      contentsStopReaseonIryoin = new ACRadioButtonItem();

      contentsStopReaseonIryoin.setText("9.介護医療院入所");

      contentsStopReaseonIryoin.setGroup(getContentsStopReasons());

      contentsStopReaseonIryoin.setConstraints(VRLayout.FLOW);

      addContentsStopReaseonIryoin();
    }
    return contentsStopReaseonIryoin;

  }

  /**
   * 施設系異動情報を取得します。
   * @return 施設系異動情報
   */
  public ACGroupBox getShisetsuIdouGroup(){
    if(shisetsuIdouGroup==null){

      shisetsuIdouGroup = new ACGroupBox();

      shisetsuIdouGroup.setText("異動情報");

      shisetsuIdouGroup.setAutoWrap(true);

      shisetsuIdouGroup.setFollowChildEnabled(true);

      shisetsuIdouGroup.setHgrid(200);

      addShisetsuIdouGroup();
    }
    return shisetsuIdouGroup;

  }

  /**
   * 入所(院)年月日を取得します。
   * @return 入所(院)年月日
   */
  public QkanDateTextField getContentsNyushoDate(){
    if(contentsNyushoDate==null){

      contentsNyushoDate = new QkanDateTextField();

      getContentsNyushoDateContainer().setText("入所（院・居）年月日");

      contentsNyushoDate.setBindPath("201024");

      addContentsNyushoDate();
    }
    return contentsNyushoDate;

  }

  /**
   * 入所(院)年月日コンテナを取得します。
   * @return 入所(院)年月日コンテナ
   */
  protected ACLabelContainer getContentsNyushoDateContainer(){
    if(contentsNyushoDateContainer==null){
      contentsNyushoDateContainer = new ACLabelContainer();
      contentsNyushoDateContainer.setFollowChildEnabled(true);
      contentsNyushoDateContainer.setVAlignment(VRLayout.CENTER);
      contentsNyushoDateContainer.add(getContentsNyushoDate(), null);
    }
    return contentsNyushoDateContainer;
  }

  /**
   * 退所(院)年月日を取得します。
   * @return 退所(院)年月日
   */
  public QkanDateTextField getContentsTaishoDate(){
    if(contentsTaishoDate==null){

      contentsTaishoDate = new QkanDateTextField();

      getContentsTaishoDateContainer().setText("退所（院・居）年月日");

      contentsTaishoDate.setBindPath("201025");

      addContentsTaishoDate();
    }
    return contentsTaishoDate;

  }

  /**
   * 退所(院)年月日コンテナを取得します。
   * @return 退所(院)年月日コンテナ
   */
  protected ACLabelContainer getContentsTaishoDateContainer(){
    if(contentsTaishoDateContainer==null){
      contentsTaishoDateContainer = new ACLabelContainer();
      contentsTaishoDateContainer.setFollowChildEnabled(true);
      contentsTaishoDateContainer.setVAlignment(VRLayout.CENTER);
      contentsTaishoDateContainer.add(getContentsTaishoDate(), null);
    }
    return contentsTaishoDateContainer;
  }

  /**
   * 入所(院)実日数を取得します。
   * @return 入所(院)実日数
   */
  public ACTextField getContentsNyushoDays(){
    if(contentsNyushoDays==null){

      contentsNyushoDays = new ACTextField();

      getContentsNyushoDaysContainer().setText("入所(院・居)実日数");

      contentsNyushoDays.setBindPath("201026");

      contentsNyushoDays.setColumns(5);

      contentsNyushoDays.setCharType(VRCharType.ONLY_DIGIT);

      contentsNyushoDays.setHorizontalAlignment(SwingConstants.RIGHT);

      contentsNyushoDays.setIMEMode(InputSubset.LATIN);

      contentsNyushoDays.setMaxLength(3);

      addContentsNyushoDays();
    }
    return contentsNyushoDays;

  }

  /**
   * 入所(院)実日数コンテナを取得します。
   * @return 入所(院)実日数コンテナ
   */
  protected ACLabelContainer getContentsNyushoDaysContainer(){
    if(contentsNyushoDaysContainer==null){
      contentsNyushoDaysContainer = new ACLabelContainer();
      contentsNyushoDaysContainer.setFollowChildEnabled(true);
      contentsNyushoDaysContainer.setVAlignment(VRLayout.CENTER);
      contentsNyushoDaysContainer.add(getContentsNyushoDays(), null);
    }
    return contentsNyushoDaysContainer;
  }

  /**
   * 入所実日数を取得します。
   * @return 入所実日数
   */
  public ACTextField getContentsTankiNyushoDays(){
    if(contentsTankiNyushoDays==null){

      contentsTankiNyushoDays = new ACTextField();

      getContentsTankiNyushoDaysContainer().setText("入所実日数");

      contentsTankiNyushoDays.setBindPath("701008");

      contentsTankiNyushoDays.setColumns(5);

      contentsTankiNyushoDays.setCharType(VRCharType.ONLY_DIGIT);

      contentsTankiNyushoDays.setHorizontalAlignment(SwingConstants.RIGHT);

      contentsTankiNyushoDays.setIMEMode(InputSubset.LATIN);

      contentsTankiNyushoDays.setMaxLength(3);

      addContentsTankiNyushoDays();
    }
    return contentsTankiNyushoDays;

  }

  /**
   * 入所実日数コンテナを取得します。
   * @return 入所実日数コンテナ
   */
  protected ACLabelContainer getContentsTankiNyushoDaysContainer(){
    if(contentsTankiNyushoDaysContainer==null){
      contentsTankiNyushoDaysContainer = new ACLabelContainer();
      contentsTankiNyushoDaysContainer.setFollowChildEnabled(true);
      contentsTankiNyushoDaysContainer.setVAlignment(VRLayout.CENTER);
      contentsTankiNyushoDaysContainer.add(getContentsTankiNyushoDays(), null);
    }
    return contentsTankiNyushoDaysContainer;
  }

  /**
   * 外泊日数を取得します。
   * @return 外泊日数
   */
  public ACTextField getContentsGaihakuDays(){
    if(contentsGaihakuDays==null){

      contentsGaihakuDays = new ACTextField();

      getContentsGaihakuDaysContainer().setText("外泊日数");

      contentsGaihakuDays.setBindPath("201027");

      contentsGaihakuDays.setColumns(5);

      contentsGaihakuDays.setCharType(VRCharType.ONLY_DIGIT);

      contentsGaihakuDays.setHorizontalAlignment(SwingConstants.RIGHT);

      contentsGaihakuDays.setIMEMode(InputSubset.LATIN);

      contentsGaihakuDays.setMaxLength(3);

      addContentsGaihakuDays();
    }
    return contentsGaihakuDays;

  }

  /**
   * 外泊日数コンテナを取得します。
   * @return 外泊日数コンテナ
   */
  protected ACLabelContainer getContentsGaihakuDaysContainer(){
    if(contentsGaihakuDaysContainer==null){
      contentsGaihakuDaysContainer = new ACLabelContainer();
      contentsGaihakuDaysContainer.setFollowChildEnabled(true);
      contentsGaihakuDaysContainer.setVAlignment(VRLayout.CENTER);
      contentsGaihakuDaysContainer.add(getContentsGaihakuDays(), null);
    }
    return contentsGaihakuDaysContainer;
  }

  /**
   * 入所（院）前の状況コードを取得します。
   * @return 入所（院）前の状況コード
   */
  public ACValueArrayRadioButtonGroup getContentsNyushoJotais(){
    if(contentsNyushoJotais==null){

      contentsNyushoJotais = new ACValueArrayRadioButtonGroup();

      getContentsNyushoJotaisContainer().setText("入所（院）前の状況コード");

      contentsNyushoJotais.setBindPath("201023");

      contentsNyushoJotais.setUseClearButton(false);

      contentsNyushoJotais.setModel(getContentsNyushoJotaisModel());

      contentsNyushoJotais.setValues(new int[]{1,2,3,4,5,6,7,8,9});

      addContentsNyushoJotais();
    }
    return contentsNyushoJotais;

  }

  /**
   * 入所（院）前の状況コードコンテナを取得します。
   * @return 入所（院）前の状況コードコンテナ
   */
  protected ACLabelContainer getContentsNyushoJotaisContainer(){
    if(contentsNyushoJotaisContainer==null){
      contentsNyushoJotaisContainer = new ACLabelContainer();
      contentsNyushoJotaisContainer.setFollowChildEnabled(true);
      contentsNyushoJotaisContainer.setVAlignment(VRLayout.CENTER);
      contentsNyushoJotaisContainer.add(getContentsNyushoJotais(), null);
    }
    return contentsNyushoJotaisContainer;
  }

  /**
   * 入所（院）前の状況コードモデルを取得します。
   * @return 入所（院）前の状況コードモデル
   */
  protected ACListModelAdapter getContentsNyushoJotaisModel(){
    if(contentsNyushoJotaisModel==null){
      contentsNyushoJotaisModel = new ACListModelAdapter();
      addContentsNyushoJotaisModel();
    }
    return contentsNyushoJotaisModel;
  }

  /**
   * 1.居宅を取得します。
   * @return 1.居宅
   */
  public ACRadioButtonItem getContentsNyushoZaitaku(){
    if(contentsNyushoZaitaku==null){

      contentsNyushoZaitaku = new ACRadioButtonItem();

      contentsNyushoZaitaku.setText("1.居宅");

      contentsNyushoZaitaku.setGroup(getContentsNyushoJotais());

      contentsNyushoZaitaku.setConstraints(VRLayout.FLOW);

      addContentsNyushoZaitaku();
    }
    return contentsNyushoZaitaku;

  }

  /**
   * 2.医療機関を取得します。
   * @return 2.医療機関
   */
  public ACRadioButtonItem getContentsNyushoIryo(){
    if(contentsNyushoIryo==null){

      contentsNyushoIryo = new ACRadioButtonItem();

      contentsNyushoIryo.setText("2.医療機関");

      contentsNyushoIryo.setGroup(getContentsNyushoJotais());

      contentsNyushoIryo.setConstraints(VRLayout.FLOW);

      addContentsNyushoIryo();
    }
    return contentsNyushoIryo;

  }

  /**
   * 3.介護老人福祉施設を取得します。
   * @return 3.介護老人福祉施設
   */
  public ACRadioButtonItem getContentsNyushoFukushi(){
    if(contentsNyushoFukushi==null){

      contentsNyushoFukushi = new ACRadioButtonItem();

      contentsNyushoFukushi.setText("3.介護老人福祉施設");

      contentsNyushoFukushi.setGroup(getContentsNyushoJotais());

      contentsNyushoFukushi.setConstraints(VRLayout.FLOW);

      addContentsNyushoFukushi();
    }
    return contentsNyushoFukushi;

  }

  /**
   * 4.介護老人保健施設を取得します。
   * @return 4.介護老人保健施設
   */
  public ACRadioButtonItem getContentsNyushoHoken(){
    if(contentsNyushoHoken==null){

      contentsNyushoHoken = new ACRadioButtonItem();

      contentsNyushoHoken.setText("4.介護老人保健施設");

      contentsNyushoHoken.setGroup(getContentsNyushoJotais());

      contentsNyushoHoken.setConstraints(VRLayout.FLOW_RETURN);

      addContentsNyushoHoken();
    }
    return contentsNyushoHoken;

  }

  /**
   * 5.介護療養型医療施設を取得します。
   * @return 5.介護療養型医療施設
   */
  public ACRadioButtonItem getContentsNyushoRyoyo(){
    if(contentsNyushoRyoyo==null){

      contentsNyushoRyoyo = new ACRadioButtonItem();

      contentsNyushoRyoyo.setText("5.介護療養型医療施設");

      contentsNyushoRyoyo.setGroup(getContentsNyushoJotais());

      contentsNyushoRyoyo.setConstraints(VRLayout.FLOW);

      addContentsNyushoRyoyo();
    }
    return contentsNyushoRyoyo;

  }

  /**
   * 6.認知症対応型共同生活介護を取得します。
   * @return 6.認知症対応型共同生活介護
   */
  public ACRadioButtonItem getContentsNyushoNinchi(){
    if(contentsNyushoNinchi==null){

      contentsNyushoNinchi = new ACRadioButtonItem();

      contentsNyushoNinchi.setText("6.認知症対応型共同生活介護");

      contentsNyushoNinchi.setGroup(getContentsNyushoJotais());

      contentsNyushoNinchi.setConstraints(VRLayout.FLOW);

      addContentsNyushoNinchi();
    }
    return contentsNyushoNinchi;

  }

  /**
   * 7.特定施設入居者生活介護を取得します。
   * @return 7.特定施設入居者生活介護
   */
  public ACRadioButtonItem getContentsNyushoTokutei(){
    if(contentsNyushoTokutei==null){

      contentsNyushoTokutei = new ACRadioButtonItem();

      contentsNyushoTokutei.setText("7.特定施設入居者生活介護");

      contentsNyushoTokutei.setGroup(getContentsNyushoJotais());

      contentsNyushoTokutei.setConstraints(VRLayout.FLOW);

      addContentsNyushoTokutei();
    }
    return contentsNyushoTokutei;

  }

  /**
   * 8.その他を取得します。
   * @return 8.その他
   */
  public ACRadioButtonItem getContentsNyushoEtc(){
    if(contentsNyushoEtc==null){

      contentsNyushoEtc = new ACRadioButtonItem();

      contentsNyushoEtc.setText("8.その他");

      contentsNyushoEtc.setGroup(getContentsNyushoJotais());

      contentsNyushoEtc.setConstraints(VRLayout.FLOW);

      addContentsNyushoEtc();
    }
    return contentsNyushoEtc;

  }

  /**
   * 9.介護医療院を取得します。
   * @return 9.介護医療院
   */
  public ACRadioButtonItem getContentsNyushoIryoin(){
    if(contentsNyushoIryoin==null){

      contentsNyushoIryoin = new ACRadioButtonItem();

      contentsNyushoIryoin.setText("9.介護医療院");

      contentsNyushoIryoin.setGroup(getContentsNyushoJotais());

      contentsNyushoIryoin.setConstraints(VRLayout.FLOW);

      addContentsNyushoIryoin();
    }
    return contentsNyushoIryoin;

  }

  /**
   * 退所(院)後の状態コードを取得します。
   * @return 退所(院)後の状態コード
   */
  public ACValueArrayRadioButtonGroup getContentsTaishoJotais(){
    if(contentsTaishoJotais==null){

      contentsTaishoJotais = new ACValueArrayRadioButtonGroup();

      getContentsTaishoJotaisContainer().setText("退所（院・居）後の状態コード");

      contentsTaishoJotais.setBindPath("201028");

      contentsTaishoJotais.setNoSelectIndex(0);

      contentsTaishoJotais.setUseClearButton(true);

      contentsTaishoJotais.setModel(getContentsTaishoJotaisModel());

      contentsTaishoJotais.setValues(new int[]{1,3,4,5,6,7,8,9});

      addContentsTaishoJotais();
    }
    return contentsTaishoJotais;

  }

  /**
   * 退所(院)後の状態コードコンテナを取得します。
   * @return 退所(院)後の状態コードコンテナ
   */
  protected ACLabelContainer getContentsTaishoJotaisContainer(){
    if(contentsTaishoJotaisContainer==null){
      contentsTaishoJotaisContainer = new ACLabelContainer();
      contentsTaishoJotaisContainer.setFollowChildEnabled(true);
      contentsTaishoJotaisContainer.setVAlignment(VRLayout.CENTER);
      contentsTaishoJotaisContainer.add(getContentsTaishoJotais(), null);
    }
    return contentsTaishoJotaisContainer;
  }

  /**
   * 退所(院)後の状態コードモデルを取得します。
   * @return 退所(院)後の状態コードモデル
   */
  protected ACListModelAdapter getContentsTaishoJotaisModel(){
    if(contentsTaishoJotaisModel==null){
      contentsTaishoJotaisModel = new ACListModelAdapter();
      addContentsTaishoJotaisModel();
    }
    return contentsTaishoJotaisModel;
  }

  /**
   * 1.居宅を取得します。
   * @return 1.居宅
   */
  public ACRadioButtonItem getContentsTaishoJotaiZaitaku(){
    if(contentsTaishoJotaiZaitaku==null){

      contentsTaishoJotaiZaitaku = new ACRadioButtonItem();

      contentsTaishoJotaiZaitaku.setText("1.居宅");

      contentsTaishoJotaiZaitaku.setGroup(getContentsTaishoJotais());

      contentsTaishoJotaiZaitaku.setConstraints(VRLayout.FLOW);

      addContentsTaishoJotaiZaitaku();
    }
    return contentsTaishoJotaiZaitaku;

  }

  /**
   * 3.医療機関入院を取得します。
   * @return 3.医療機関入院
   */
  public ACRadioButtonItem getContentsTaishoJotaiNyuin(){
    if(contentsTaishoJotaiNyuin==null){

      contentsTaishoJotaiNyuin = new ACRadioButtonItem();

      contentsTaishoJotaiNyuin.setText("3.医療機関入院");

      contentsTaishoJotaiNyuin.setGroup(getContentsTaishoJotais());

      contentsTaishoJotaiNyuin.setConstraints(VRLayout.FLOW);

      addContentsTaishoJotaiNyuin();
    }
    return contentsTaishoJotaiNyuin;

  }

  /**
   * 4.死亡を取得します。
   * @return 4.死亡
   */
  public ACRadioButtonItem getContentsTaishoJotaiDeath(){
    if(contentsTaishoJotaiDeath==null){

      contentsTaishoJotaiDeath = new ACRadioButtonItem();

      contentsTaishoJotaiDeath.setText("4.死亡");

      contentsTaishoJotaiDeath.setGroup(getContentsTaishoJotais());

      contentsTaishoJotaiDeath.setConstraints(VRLayout.FLOW);

      addContentsTaishoJotaiDeath();
    }
    return contentsTaishoJotaiDeath;

  }

  /**
   * 5.その他を取得します。
   * @return 5.その他
   */
  public ACRadioButtonItem getContentsTaishoJotaiEtc(){
    if(contentsTaishoJotaiEtc==null){

      contentsTaishoJotaiEtc = new ACRadioButtonItem();

      contentsTaishoJotaiEtc.setText("5.その他");

      contentsTaishoJotaiEtc.setGroup(getContentsTaishoJotais());

      contentsTaishoJotaiEtc.setConstraints(VRLayout.FLOW_RETURN);

      addContentsTaishoJotaiEtc();
    }
    return contentsTaishoJotaiEtc;

  }

  /**
   * 6.介護老人福祉施設入所を取得します。
   * @return 6.介護老人福祉施設入所
   */
  public ACRadioButtonItem getContentsTaishoJotaiTokuyo(){
    if(contentsTaishoJotaiTokuyo==null){

      contentsTaishoJotaiTokuyo = new ACRadioButtonItem();

      contentsTaishoJotaiTokuyo.setText("6.介護老人福祉施設入所");

      contentsTaishoJotaiTokuyo.setGroup(getContentsTaishoJotais());

      contentsTaishoJotaiTokuyo.setConstraints(VRLayout.FLOW);

      addContentsTaishoJotaiTokuyo();
    }
    return contentsTaishoJotaiTokuyo;

  }

  /**
   * 7.介護老人保健施設入所を取得します。
   * @return 7.介護老人保健施設入所
   */
  public ACRadioButtonItem getContentsTaishoJotaiRouken(){
    if(contentsTaishoJotaiRouken==null){

      contentsTaishoJotaiRouken = new ACRadioButtonItem();

      contentsTaishoJotaiRouken.setText("7.介護老人保健施設入所");

      contentsTaishoJotaiRouken.setGroup(getContentsTaishoJotais());

      contentsTaishoJotaiRouken.setConstraints(VRLayout.FLOW);

      addContentsTaishoJotaiRouken();
    }
    return contentsTaishoJotaiRouken;

  }

  /**
   * 8.介護療養型医療施設入院を取得します。
   * @return 8.介護療養型医療施設入院
   */
  public ACRadioButtonItem getContentsTaishoJotaiRyoyo(){
    if(contentsTaishoJotaiRyoyo==null){

      contentsTaishoJotaiRyoyo = new ACRadioButtonItem();

      contentsTaishoJotaiRyoyo.setText("8.介護療養型医療施設入院");

      contentsTaishoJotaiRyoyo.setGroup(getContentsTaishoJotais());

      contentsTaishoJotaiRyoyo.setConstraints(VRLayout.FLOW);

      addContentsTaishoJotaiRyoyo();
    }
    return contentsTaishoJotaiRyoyo;

  }

  /**
   * 9.介護医療院入所を取得します。
   * @return 9.介護医療院入所
   */
  public ACRadioButtonItem getContentsTaishoJotaiIryoin(){
    if(contentsTaishoJotaiIryoin==null){

      contentsTaishoJotaiIryoin = new ACRadioButtonItem();

      contentsTaishoJotaiIryoin.setText("9.介護医療院入所");

      contentsTaishoJotaiIryoin.setGroup(getContentsTaishoJotais());

      contentsTaishoJotaiIryoin.setConstraints(VRLayout.FLOW);

      addContentsTaishoJotaiIryoin();
    }
    return contentsTaishoJotaiIryoin;

  }

  /**
   * 摘要欄編集領域を取得します。
   * @return 摘要欄編集領域
   */
  public ACPanel getEditTekiyoPanel(){
    if(editTekiyoPanel==null){

      editTekiyoPanel = new ACPanel();

      addEditTekiyoPanel();
    }
    return editTekiyoPanel;

  }

  /**
   * 基本摘要表示領域を取得します。
   * @return 基本摘要表示領域
   */
  public ACGroupBox getBaseSummaryArea(){
    if(baseSummaryArea==null){

      baseSummaryArea = new ACGroupBox();

      baseSummaryArea.setText("基本摘要");

      addBaseSummaryArea();
    }
    return baseSummaryArea;

  }

  /**
   * 基本摘要コメントを取得します。
   * @return 基本摘要コメント
   */
  public ACTextField getBaseSummaryText(){
    if(baseSummaryText==null){

      baseSummaryText = new ACTextField();

      baseSummaryText.setBindPath("BASE_SUMMARY_MEMO");

      baseSummaryText.setEditable(false);

      addBaseSummaryText();
    }
    return baseSummaryText;

  }

  /**
   * 基本摘要一覧を取得します。
   * @return 基本摘要一覧
   */
  public ACTable getBaseSummaryTable(){
    if(baseSummaryTable==null){

      baseSummaryTable = new ACTable();

      baseSummaryTable.setColumnModel(getBaseSummaryTableColumnModel());

      baseSummaryTable.setColumnSort(false);

      addBaseSummaryTable();
    }
    return baseSummaryTable;

  }

  /**
   * 基本摘要一覧カラムモデルを取得します。
   * @return 基本摘要一覧カラムモデル
   */
  protected VRTableColumnModel getBaseSummaryTableColumnModel(){
    if(baseSummaryTableColumnModel==null){
      baseSummaryTableColumnModel = new VRTableColumnModel(new TableColumn[]{});
      addBaseSummaryTableColumnModel();
    }
    return baseSummaryTableColumnModel;
  }

  /**
   * No.を取得します。
   * @return No.
   */
  public ACTableColumn getBaseSummaryNoColumn(){
    if(baseSummaryNoColumn==null){

      baseSummaryNoColumn = new ACTableColumn(0, 40);

      baseSummaryNoColumn.setHeaderValue("No.");

      baseSummaryNoColumn.setColumns(4);

      baseSummaryNoColumn.setRendererType(ACTableCellViewer.RENDERER_TYPE_SERIAL_NO);

      baseSummaryNoColumn.setSortable(false);

      addBaseSummaryNoColumn();
    }
    return baseSummaryNoColumn;

  }

  /**
   * 摘要種別コードを取得します。
   * @return 摘要種別コード
   */
  public ACTableColumn getBaseSummaryKindCodeColumn(){
    if(baseSummaryKindCodeColumn==null){

      baseSummaryKindCodeColumn = new ACTableColumn(0, 100);

      baseSummaryKindCodeColumn.setHeaderValue("摘要種別コード");

      baseSummaryKindCodeColumn.setColumns(9);

      addBaseSummaryKindCodeColumn();
    }
    return baseSummaryKindCodeColumn;

  }

  /**
   * 名称を取得します。
   * @return 名称
   */
  public ACTableColumn getBaseSummaryNameColumn(){
    if(baseSummaryNameColumn==null){

      baseSummaryNameColumn = new ACTableColumn(1);

      baseSummaryNameColumn.setHeaderValue("名称");

      baseSummaryNameColumn.setColumns(20);

      addBaseSummaryNameColumn();
    }
    return baseSummaryNameColumn;

  }

  /**
   * 摘要内容を取得します。
   * @return 摘要内容
   */
  public ACTableColumn getBaseSummaryNaiyoColumn(){
    if(baseSummaryNaiyoColumn==null){

      baseSummaryNaiyoColumn = new ACTableColumn(2, 400);

      baseSummaryNaiyoColumn.setHeaderValue("摘要内容");

      baseSummaryNaiyoColumn.setEditable(true);

      addBaseSummaryNaiyoColumn();
    }
    return baseSummaryNaiyoColumn;

  }

  /**
   * 摘要欄記載事項表示領域を取得します。
   * @return 摘要欄記載事項表示領域
   */
  public ACGroupBox getTekiyos(){
    if(tekiyos==null){

      tekiyos = new ACGroupBox();

      tekiyos.setText("摘要欄記載事項");

      addTekiyos();
    }
    return tekiyos;

  }

  /**
   * 摘要欄記載事項コメントを取得します。
   * @return 摘要欄記載事項コメント
   */
  public ACTextField getTekiyoText(){
    if(tekiyoText==null){

      tekiyoText = new ACTextField();

      tekiyoText.setBindPath("DETAIL_SUMMARY_MEMO");

      tekiyoText.setEditable(false);

      addTekiyoText();
    }
    return tekiyoText;

  }

  /**
   * 摘要欄記載事項一覧を取得します。
   * @return 摘要欄記載事項一覧
   */
  public ACTable getTekiyoTable(){
    if(tekiyoTable==null){

      tekiyoTable = new ACTable();

      tekiyoTable.setColumnModel(getTekiyoTableColumnModel());

      tekiyoTable.setColumnSort(false);

      addTekiyoTable();
    }
    return tekiyoTable;

  }

  /**
   * 摘要欄記載事項一覧カラムモデルを取得します。
   * @return 摘要欄記載事項一覧カラムモデル
   */
  protected VRTableColumnModel getTekiyoTableColumnModel(){
    if(tekiyoTableColumnModel==null){
      tekiyoTableColumnModel = new VRTableColumnModel(new TableColumn[]{});
      addTekiyoTableColumnModel();
    }
    return tekiyoTableColumnModel;
  }

  /**
   * No.を取得します。
   * @return No.
   */
  public ACTableColumn getTekiyoNoColumn(){
    if(tekiyoNoColumn==null){

      tekiyoNoColumn = new ACTableColumn(0, 40);

      tekiyoNoColumn.setHeaderValue("No.");

      tekiyoNoColumn.setColumns(4);

      tekiyoNoColumn.setRendererType(ACTableCellViewer.RENDERER_TYPE_SERIAL_NO);

      tekiyoNoColumn.setSortable(false);

      addTekiyoNoColumn();
    }
    return tekiyoNoColumn;

  }

  /**
   * サービスコードを取得します。
   * @return サービスコード
   */
  public ACTableColumn getTekiyoServiceCodeColumn(){
    if(tekiyoServiceCodeColumn==null){

      tekiyoServiceCodeColumn = new ACTableColumn(0, 100);

      tekiyoServiceCodeColumn.setHeaderValue("サービスコード");

      tekiyoServiceCodeColumn.setColumns(9);

      addTekiyoServiceCodeColumn();
    }
    return tekiyoServiceCodeColumn;

  }

  /**
   * サービス名称を取得します。
   * @return サービス名称
   */
  public ACTableColumn getTekiyoServiceNameColumn(){
    if(tekiyoServiceNameColumn==null){

      tekiyoServiceNameColumn = new ACTableColumn(1, 200);

      tekiyoServiceNameColumn.setHeaderValue("サービス名称");

      tekiyoServiceNameColumn.setColumns(20);

      addTekiyoServiceNameColumn();
    }
    return tekiyoServiceNameColumn;

  }

  /**
   * 回数を取得します。
   * @return 回数
   */
  public ACTableColumn getTekiyoTimesColumn(){
    if(tekiyoTimesColumn==null){

      tekiyoTimesColumn = new ACTableColumn(2);

      tekiyoTimesColumn.setHeaderValue("回数");

      tekiyoTimesColumn.setColumns(4);

      tekiyoTimesColumn.setHorizontalAlignment(SwingConstants.RIGHT);

      addTekiyoTimesColumn();
    }
    return tekiyoTimesColumn;

  }

  /**
   * 単位数を取得します。
   * @return 単位数
   */
  public ACTableColumn getTekiyoServiceUnitColumn(){
    if(tekiyoServiceUnitColumn==null){

      tekiyoServiceUnitColumn = new ACTableColumn(3);

      tekiyoServiceUnitColumn.setHeaderValue("単位数");

      tekiyoServiceUnitColumn.setColumns(6);

      tekiyoServiceUnitColumn.setHorizontalAlignment(SwingConstants.RIGHT);

      addTekiyoServiceUnitColumn();
    }
    return tekiyoServiceUnitColumn;

  }

  /**
   * 摘要を取得します。
   * @return 摘要
   */
  public ACTableColumn getTekiyoTekiyoColumn(){
    if(tekiyoTekiyoColumn==null){

      tekiyoTekiyoColumn = new ACTableColumn(4, 400);

      tekiyoTekiyoColumn.setHeaderValue("摘要");

      tekiyoTekiyoColumn.setEditable(true);

      addTekiyoTekiyoColumn();
    }
    return tekiyoTekiyoColumn;

  }

  /**
   * 特定診療費表示領域を取得します。
   * @return 特定診療費表示領域
   */
  public ACGroupBox getShinryos(){
    if(shinryos==null){

      shinryos = new ACGroupBox();

      shinryos.setText("特定診療費");

      addShinryos();
    }
    return shinryos;

  }

  /**
   * 傷病名を取得します。
   * @return 傷病名
   */
  public ACTextField getShinryoDeseaseText(){
    if(shinryoDeseaseText==null){

      shinryoDeseaseText = new ACTextField();

      getShinryoDeseaseTextContainer().setText("傷病名");

      shinryoDeseaseText.setBindPath("501008");

      shinryoDeseaseText.setConvertToCharacter(ACCharacterConverter.TO_WIDE_CHAR);

      shinryoDeseaseText.setIMEMode(InputSubset.KANJI);

      shinryoDeseaseText.setMaxLength(50);

      addShinryoDeseaseText();
    }
    return shinryoDeseaseText;

  }

  /**
   * 傷病名コンテナを取得します。
   * @return 傷病名コンテナ
   */
  protected ACLabelContainer getShinryoDeseaseTextContainer(){
    if(shinryoDeseaseTextContainer==null){
      shinryoDeseaseTextContainer = new ACLabelContainer();
      shinryoDeseaseTextContainer.setFollowChildEnabled(true);
      shinryoDeseaseTextContainer.setVAlignment(VRLayout.CENTER);
      shinryoDeseaseTextContainer.add(getShinryoDeseaseText(), VRLayout.CLIENT);
    }
    return shinryoDeseaseTextContainer;
  }

  /**
   * 特定診療費コメントを取得します。
   * @return 特定診療費コメント
   */
  public ACTextField getShinryoText(){
    if(shinryoText==null){

      shinryoText = new ACTextField();

      shinryoText.setBindPath("SPECIAL_CLINIC_SUMMARY_MEMO");

      shinryoText.setEditable(false);

      addShinryoText();
    }
    return shinryoText;

  }

  /**
   * 特定診療費一覧を取得します。
   * @return 特定診療費一覧
   */
  public ACTable getSinryoTable(){
    if(sinryoTable==null){

      sinryoTable = new ACTable();

      sinryoTable.setColumnModel(getSinryoTableColumnModel());

      sinryoTable.setColumnSort(false);

      sinryoTable.setPreferredSize(new Dimension(100,100));

      addSinryoTable();
    }
    return sinryoTable;

  }

  /**
   * 特定診療費一覧カラムモデルを取得します。
   * @return 特定診療費一覧カラムモデル
   */
  protected VRTableColumnModel getSinryoTableColumnModel(){
    if(sinryoTableColumnModel==null){
      sinryoTableColumnModel = new VRTableColumnModel(new TableColumn[]{});
      addSinryoTableColumnModel();
    }
    return sinryoTableColumnModel;
  }

  /**
   * No.を取得します。
   * @return No.
   */
  public ACTableColumn getSinryoNoColumn(){
    if(sinryoNoColumn==null){

      sinryoNoColumn = new ACTableColumn(0, 40);

      sinryoNoColumn.setHeaderValue("No.");

      sinryoNoColumn.setColumns(4);

      sinryoNoColumn.setRendererType(ACTableCellViewer.RENDERER_TYPE_SERIAL_NO);

      sinryoNoColumn.setSortable(false);

      addSinryoNoColumn();
    }
    return sinryoNoColumn;

  }

  /**
   * 識別番号を取得します。
   * @return 識別番号
   */
  public ACTableColumn getSinryoShikibetsuColumn(){
    if(sinryoShikibetsuColumn==null){

      sinryoShikibetsuColumn = new ACTableColumn(0, 100);

      sinryoShikibetsuColumn.setHeaderValue("識別番号");

      sinryoShikibetsuColumn.setColumns(6);

      addSinryoShikibetsuColumn();
    }
    return sinryoShikibetsuColumn;

  }

  /**
   * 名称を取得します。
   * @return 名称
   */
  public ACTableColumn getSinryoNameColumn(){
    if(sinryoNameColumn==null){

      sinryoNameColumn = new ACTableColumn(1, 200);

      sinryoNameColumn.setHeaderValue("名称");

      sinryoNameColumn.setColumns(20);

      addSinryoNameColumn();
    }
    return sinryoNameColumn;

  }

  /**
   * 回数を取得します。
   * @return 回数
   */
  public ACTableColumn getSinryoTimesColumn(){
    if(sinryoTimesColumn==null){

      sinryoTimesColumn = new ACTableColumn(2);

      sinryoTimesColumn.setHeaderValue("回数");

      sinryoTimesColumn.setColumns(4);

      sinryoTimesColumn.setHorizontalAlignment(SwingConstants.RIGHT);

      addSinryoTimesColumn();
    }
    return sinryoTimesColumn;

  }

  /**
   * 単位数を取得します。
   * @return 単位数
   */
  public ACTableColumn getSinryoUnitColumn(){
    if(sinryoUnitColumn==null){

      sinryoUnitColumn = new ACTableColumn(3);

      sinryoUnitColumn.setHeaderValue("単位数");

      sinryoUnitColumn.setColumns(6);

      sinryoUnitColumn.setHorizontalAlignment(SwingConstants.RIGHT);

      addSinryoUnitColumn();
    }
    return sinryoUnitColumn;

  }

  /**
   * 摘要を取得します。
   * @return 摘要
   */
  public ACTableColumn getSinryoTekiyoColumn(){
    if(sinryoTekiyoColumn==null){

      sinryoTekiyoColumn = new ACTableColumn(4, 400);

      sinryoTekiyoColumn.setHeaderValue("摘要");

      sinryoTekiyoColumn.setEditable(true);

      sinryoTekiyoColumn.setEditorType(VRTableCellViewer.EDITOR_TYPE_TEXT_FIELD);

      addSinryoTekiyoColumn();
    }
    return sinryoTekiyoColumn;

  }

  /**
   * コンストラクタです。
   */
  public QP004Design() {

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

    this.add(getContents(), VRLayout.NORTH);

    this.add(getEditTekiyoPanel(), VRLayout.CLIENT);

  }

  /**
   * ボタンバーに内部項目を追加します。
   */
  protected void addButtons(){

    buttons.add(getUpdate(), VRLayout.EAST);
    buttons.add(getDetail(), VRLayout.EAST);
    buttons.add(getTekiyoHelp(), VRLayout.EAST);
  }

  /**
   * 摘要表示ボタン(H)に内部項目を追加します。
   */
  protected void addTekiyoHelp(){

  }

  /**
   * 詳細ボタン(E)に内部項目を追加します。
   */
  protected void addDetail(){

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

    contents.add(getPatientNames(), VRLayout.NORTH);

    contents.add(getKyotakuIdouGroup(), VRLayout.NORTH);

    contents.add(getShisetsuIdouGroup(), VRLayout.NORTH);

  }

  /**
   * 利用者名領域に内部項目を追加します。
   */
  protected void addPatientNames(){

    patientNames.add(getPatinetNameLabel(), VRLayout.FLOW);

    patientNames.add(getPatientName(), VRLayout.FLOW);

    patientNames.add(getPatientNoLabel1(), VRLayout.FLOW);

    patientNames.add(getPatientNo(), VRLayout.FLOW);

    patientNames.add(getPatientNoLabel2(), VRLayout.FLOW);

  }

  /**
   * 利用者名・ラベルに内部項目を追加します。
   */
  protected void addPatinetNameLabel(){

  }

  /**
   * 利用者名に内部項目を追加します。
   */
  protected void addPatientName(){

  }

  /**
   * 利用者コード・ラベル1に内部項目を追加します。
   */
  protected void addPatientNoLabel1(){

  }

  /**
   * 利用者コードに内部項目を追加します。
   */
  protected void addPatientNo(){

  }

  /**
   * 利用者コード・ラベル2に内部項目を追加します。
   */
  protected void addPatientNoLabel2(){

  }

  /**
   * 居宅系異動情報に内部項目を追加します。
   */
  protected void addKyotakuIdouGroup(){

    kyotakuIdouGroup.add(getContentsStartDateContainer(), VRLayout.FLOW_INSETLINE);

    kyotakuIdouGroup.add(getContentsStopDateContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    kyotakuIdouGroup.add(getContentsStopReasonsContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * 開始年月日に内部項目を追加します。
   */
  protected void addContentsStartDate(){

  }

  /**
   * 中止年月日に内部項目を追加します。
   */
  protected void addContentsStopDate(){

  }

  /**
   * 中止理由コードに内部項目を追加します。
   */
  protected void addContentsStopReasons(){

  }

  /**
   * 中止理由コードモデルに内部項目を追加します。
   */
  protected void addContentsStopReasonsModel(){

    getContentsStopReaseonHigaito().setButtonIndex(1);

    getContentsStopReasonsModel().add(getContentsStopReaseonHigaito());

    getContentsStopReaseonNyuin().setButtonIndex(3);

    getContentsStopReasonsModel().add(getContentsStopReaseonNyuin());

    getContentsStopReaseonDeath().setButtonIndex(4);

    getContentsStopReasonsModel().add(getContentsStopReaseonDeath());

    getContentsStopReaseonEtc().setButtonIndex(5);

    getContentsStopReasonsModel().add(getContentsStopReaseonEtc());

    getContentsStopReaseonTokuyo().setButtonIndex(6);

    getContentsStopReasonsModel().add(getContentsStopReaseonTokuyo());

    getContentsStopReaseonRouken().setButtonIndex(7);

    getContentsStopReasonsModel().add(getContentsStopReaseonRouken());

    getContentsStopReaseonRyoyo().setButtonIndex(8);

    getContentsStopReasonsModel().add(getContentsStopReaseonRyoyo());

    getContentsStopReaseonIryoin().setButtonIndex(9);

    getContentsStopReasonsModel().add(getContentsStopReaseonIryoin());

  }

  /**
   * 1.非該当に内部項目を追加します。
   */
  protected void addContentsStopReaseonHigaito(){

  }

  /**
   * 3.医療機関入院に内部項目を追加します。
   */
  protected void addContentsStopReaseonNyuin(){

  }

  /**
   * 4.死亡に内部項目を追加します。
   */
  protected void addContentsStopReaseonDeath(){

  }

  /**
   * 5.その他に内部項目を追加します。
   */
  protected void addContentsStopReaseonEtc(){

  }

  /**
   * 6.介護老人福祉施設入所に内部項目を追加します。
   */
  protected void addContentsStopReaseonTokuyo(){

  }

  /**
   * 7.介護老人保健施設入所に内部項目を追加します。
   */
  protected void addContentsStopReaseonRouken(){

  }

  /**
   * 8.介護療養型医療施設入院に内部項目を追加します。
   */
  protected void addContentsStopReaseonRyoyo(){

  }

  /**
   * 9.介護医療院入所に内部項目を追加します。
   */
  protected void addContentsStopReaseonIryoin(){

  }

  /**
   * 施設系異動情報に内部項目を追加します。
   */
  protected void addShisetsuIdouGroup(){

    shisetsuIdouGroup.add(getContentsNyushoDateContainer(), VRLayout.FLOW_INSETLINE);

    shisetsuIdouGroup.add(getContentsTaishoDateContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    shisetsuIdouGroup.add(getContentsNyushoDaysContainer(), VRLayout.FLOW_INSETLINE);

    shisetsuIdouGroup.add(getContentsTankiNyushoDaysContainer(), VRLayout.FLOW_INSETLINE);

    shisetsuIdouGroup.add(getContentsGaihakuDaysContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    shisetsuIdouGroup.add(getContentsNyushoJotaisContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    shisetsuIdouGroup.add(getContentsTaishoJotaisContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * 入所(院)年月日に内部項目を追加します。
   */
  protected void addContentsNyushoDate(){

  }

  /**
   * 退所(院)年月日に内部項目を追加します。
   */
  protected void addContentsTaishoDate(){

  }

  /**
   * 入所(院)実日数に内部項目を追加します。
   */
  protected void addContentsNyushoDays(){

  }

  /**
   * 入所実日数に内部項目を追加します。
   */
  protected void addContentsTankiNyushoDays(){

  }

  /**
   * 外泊日数に内部項目を追加します。
   */
  protected void addContentsGaihakuDays(){

  }

  /**
   * 入所（院）前の状況コードに内部項目を追加します。
   */
  protected void addContentsNyushoJotais(){

  }

  /**
   * 入所（院）前の状況コードモデルに内部項目を追加します。
   */
  protected void addContentsNyushoJotaisModel(){

    getContentsNyushoZaitaku().setButtonIndex(1);

    getContentsNyushoJotaisModel().add(getContentsNyushoZaitaku());

    getContentsNyushoIryo().setButtonIndex(2);

    getContentsNyushoJotaisModel().add(getContentsNyushoIryo());

    getContentsNyushoFukushi().setButtonIndex(3);

    getContentsNyushoJotaisModel().add(getContentsNyushoFukushi());

    getContentsNyushoHoken().setButtonIndex(4);

    getContentsNyushoJotaisModel().add(getContentsNyushoHoken());

    getContentsNyushoRyoyo().setButtonIndex(5);

    getContentsNyushoJotaisModel().add(getContentsNyushoRyoyo());

    getContentsNyushoNinchi().setButtonIndex(6);

    getContentsNyushoJotaisModel().add(getContentsNyushoNinchi());

    getContentsNyushoTokutei().setButtonIndex(7);

    getContentsNyushoJotaisModel().add(getContentsNyushoTokutei());

    getContentsNyushoEtc().setButtonIndex(8);

    getContentsNyushoJotaisModel().add(getContentsNyushoEtc());

    getContentsNyushoIryoin().setButtonIndex(9);

    getContentsNyushoJotaisModel().add(getContentsNyushoIryoin());

  }

  /**
   * 1.居宅に内部項目を追加します。
   */
  protected void addContentsNyushoZaitaku(){

  }

  /**
   * 2.医療機関に内部項目を追加します。
   */
  protected void addContentsNyushoIryo(){

  }

  /**
   * 3.介護老人福祉施設に内部項目を追加します。
   */
  protected void addContentsNyushoFukushi(){

  }

  /**
   * 4.介護老人保健施設に内部項目を追加します。
   */
  protected void addContentsNyushoHoken(){

  }

  /**
   * 5.介護療養型医療施設に内部項目を追加します。
   */
  protected void addContentsNyushoRyoyo(){

  }

  /**
   * 6.認知症対応型共同生活介護に内部項目を追加します。
   */
  protected void addContentsNyushoNinchi(){

  }

  /**
   * 7.特定施設入居者生活介護に内部項目を追加します。
   */
  protected void addContentsNyushoTokutei(){

  }

  /**
   * 8.その他に内部項目を追加します。
   */
  protected void addContentsNyushoEtc(){

  }

  /**
   * 9.介護医療院に内部項目を追加します。
   */
  protected void addContentsNyushoIryoin(){

  }

  /**
   * 退所(院)後の状態コードに内部項目を追加します。
   */
  protected void addContentsTaishoJotais(){

  }

  /**
   * 退所(院)後の状態コードモデルに内部項目を追加します。
   */
  protected void addContentsTaishoJotaisModel(){

    getContentsTaishoJotaiZaitaku().setButtonIndex(1);

    getContentsTaishoJotaisModel().add(getContentsTaishoJotaiZaitaku());

    getContentsTaishoJotaiNyuin().setButtonIndex(3);

    getContentsTaishoJotaisModel().add(getContentsTaishoJotaiNyuin());

    getContentsTaishoJotaiDeath().setButtonIndex(4);

    getContentsTaishoJotaisModel().add(getContentsTaishoJotaiDeath());

    getContentsTaishoJotaiEtc().setButtonIndex(5);

    getContentsTaishoJotaisModel().add(getContentsTaishoJotaiEtc());

    getContentsTaishoJotaiTokuyo().setButtonIndex(6);

    getContentsTaishoJotaisModel().add(getContentsTaishoJotaiTokuyo());

    getContentsTaishoJotaiRouken().setButtonIndex(7);

    getContentsTaishoJotaisModel().add(getContentsTaishoJotaiRouken());

    getContentsTaishoJotaiRyoyo().setButtonIndex(8);

    getContentsTaishoJotaisModel().add(getContentsTaishoJotaiRyoyo());

    getContentsTaishoJotaiIryoin().setButtonIndex(9);

    getContentsTaishoJotaisModel().add(getContentsTaishoJotaiIryoin());

  }

  /**
   * 1.居宅に内部項目を追加します。
   */
  protected void addContentsTaishoJotaiZaitaku(){

  }

  /**
   * 3.医療機関入院に内部項目を追加します。
   */
  protected void addContentsTaishoJotaiNyuin(){

  }

  /**
   * 4.死亡に内部項目を追加します。
   */
  protected void addContentsTaishoJotaiDeath(){

  }

  /**
   * 5.その他に内部項目を追加します。
   */
  protected void addContentsTaishoJotaiEtc(){

  }

  /**
   * 6.介護老人福祉施設入所に内部項目を追加します。
   */
  protected void addContentsTaishoJotaiTokuyo(){

  }

  /**
   * 7.介護老人保健施設入所に内部項目を追加します。
   */
  protected void addContentsTaishoJotaiRouken(){

  }

  /**
   * 8.介護療養型医療施設入院に内部項目を追加します。
   */
  protected void addContentsTaishoJotaiRyoyo(){

  }

  /**
   * 9.介護医療院入所に内部項目を追加します。
   */
  protected void addContentsTaishoJotaiIryoin(){

  }

  /**
   * 摘要欄編集領域に内部項目を追加します。
   */
  protected void addEditTekiyoPanel(){

    editTekiyoPanel.add(getBaseSummaryArea(), VRLayout.NORTH);

    editTekiyoPanel.add(getTekiyos(), VRLayout.NORTH);

    editTekiyoPanel.add(getShinryos(), VRLayout.CLIENT);

  }

  /**
   * 基本摘要表示領域に内部項目を追加します。
   */
  protected void addBaseSummaryArea(){

    baseSummaryArea.add(getBaseSummaryText(), VRLayout.NORTH);

    baseSummaryArea.add(getBaseSummaryTable(), VRLayout.CLIENT);

  }

  /**
   * 基本摘要コメントに内部項目を追加します。
   */
  protected void addBaseSummaryText(){

  }

  /**
   * 基本摘要一覧に内部項目を追加します。
   */
  protected void addBaseSummaryTable(){

  }

  /**
   * 基本摘要一覧カラムモデルに内部項目を追加します。
   */
  protected void addBaseSummaryTableColumnModel(){

    getBaseSummaryTableColumnModel().addColumn(getBaseSummaryNoColumn());

    getBaseSummaryTableColumnModel().addColumn(getBaseSummaryKindCodeColumn());

    getBaseSummaryTableColumnModel().addColumn(getBaseSummaryNameColumn());

    getBaseSummaryTableColumnModel().addColumn(getBaseSummaryNaiyoColumn());

  }

  /**
   * No.に内部項目を追加します。
   */
  protected void addBaseSummaryNoColumn(){

  }

  /**
   * 摘要種別コードに内部項目を追加します。
   */
  protected void addBaseSummaryKindCodeColumn(){

  }

  /**
   * 名称に内部項目を追加します。
   */
  protected void addBaseSummaryNameColumn(){

  }

  /**
   * 摘要内容に内部項目を追加します。
   */
  protected void addBaseSummaryNaiyoColumn(){

  }

  /**
   * 摘要欄記載事項表示領域に内部項目を追加します。
   */
  protected void addTekiyos(){

    tekiyos.add(getTekiyoText(), VRLayout.NORTH);

    tekiyos.add(getTekiyoTable(), VRLayout.CLIENT);

  }

  /**
   * 摘要欄記載事項コメントに内部項目を追加します。
   */
  protected void addTekiyoText(){

  }

  /**
   * 摘要欄記載事項一覧に内部項目を追加します。
   */
  protected void addTekiyoTable(){

  }

  /**
   * 摘要欄記載事項一覧カラムモデルに内部項目を追加します。
   */
  protected void addTekiyoTableColumnModel(){

    getTekiyoTableColumnModel().addColumn(getTekiyoNoColumn());

    getTekiyoTableColumnModel().addColumn(getTekiyoServiceCodeColumn());

    getTekiyoTableColumnModel().addColumn(getTekiyoServiceNameColumn());

    getTekiyoTableColumnModel().addColumn(getTekiyoTimesColumn());

    getTekiyoTableColumnModel().addColumn(getTekiyoServiceUnitColumn());

    getTekiyoTableColumnModel().addColumn(getTekiyoTekiyoColumn());

  }

  /**
   * No.に内部項目を追加します。
   */
  protected void addTekiyoNoColumn(){

  }

  /**
   * サービスコードに内部項目を追加します。
   */
  protected void addTekiyoServiceCodeColumn(){

  }

  /**
   * サービス名称に内部項目を追加します。
   */
  protected void addTekiyoServiceNameColumn(){

  }

  /**
   * 回数に内部項目を追加します。
   */
  protected void addTekiyoTimesColumn(){

  }

  /**
   * 単位数に内部項目を追加します。
   */
  protected void addTekiyoServiceUnitColumn(){

  }

  /**
   * 摘要に内部項目を追加します。
   */
  protected void addTekiyoTekiyoColumn(){

  }

  /**
   * 特定診療費表示領域に内部項目を追加します。
   */
  protected void addShinryos(){

    shinryos.add(getShinryoDeseaseTextContainer(), VRLayout.NORTH);

    shinryos.add(getShinryoText(), VRLayout.NORTH);

    shinryos.add(getSinryoTable(), VRLayout.CLIENT);

  }

  /**
   * 傷病名に内部項目を追加します。
   */
  protected void addShinryoDeseaseText(){

  }

  /**
   * 特定診療費コメントに内部項目を追加します。
   */
  protected void addShinryoText(){

  }

  /**
   * 特定診療費一覧に内部項目を追加します。
   */
  protected void addSinryoTable(){

  }

  /**
   * 特定診療費一覧カラムモデルに内部項目を追加します。
   */
  protected void addSinryoTableColumnModel(){

    getSinryoTableColumnModel().addColumn(getSinryoNoColumn());

    getSinryoTableColumnModel().addColumn(getSinryoShikibetsuColumn());

    getSinryoTableColumnModel().addColumn(getSinryoNameColumn());

    getSinryoTableColumnModel().addColumn(getSinryoTimesColumn());

    getSinryoTableColumnModel().addColumn(getSinryoUnitColumn());

    getSinryoTableColumnModel().addColumn(getSinryoTekiyoColumn());

  }

  /**
   * No.に内部項目を追加します。
   */
  protected void addSinryoNoColumn(){

  }

  /**
   * 識別番号に内部項目を追加します。
   */
  protected void addSinryoShikibetsuColumn(){

  }

  /**
   * 名称に内部項目を追加します。
   */
  protected void addSinryoNameColumn(){

  }

  /**
   * 回数に内部項目を追加します。
   */
  protected void addSinryoTimesColumn(){

  }

  /**
   * 単位数に内部項目を追加します。
   */
  protected void addSinryoUnitColumn(){

  }

  /**
   * 摘要に内部項目を追加します。
   */
  protected void addSinryoTekiyoColumn(){

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
      ACFrame.debugStart(new ACAffairInfo(QP004Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QP004Design getThis() {
    return this;
  }
}
