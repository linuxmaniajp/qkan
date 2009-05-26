
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
 * 作成日: 2009/03/03  日本コンピューター株式会社 樋口　雅彦 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 予定管理 (S)
 * プロセス サービス予定 (001)
 * プログラム 特定診療費画面 (QS001199_H2104)
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
import jp.nichicom.ac.lib.care.claim.print.schedule.*;

/**
 * 特定診療費画面(QS001199_H2104) 
 */
public class QS001199_H2104 extends QS001199_H2104Event {
  /**
   * コンストラクタです。
   */
  public QS001199_H2104(){
  }

  //コンポーネントイベント

  /**
   * 「設定」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected void applyActionPerformed(ActionEvent e) throws Exception{
      // ※画面の状態を呼び出し元に返す
      // valuesに画面の値を格納する。
      getSpecificConsultationFeePattern().setSource(getValues());
      getValues().clear();
      getSpecificConsultationFeePattern().applySource();

      // ※無効なコンボの値を削除する。
      // 理学療法（Ｉ）コンボ(scienceTherapy1Combo)が無効ならば、理学療法（Ｉ）コンボ(scienceTherapy1Combo)のbindPathを削除する。
      if (!getScienceTherapy1Combo().isEnabled()) {
          getValues().remove(getScienceTherapy1Combo().getBindPath());
      }
      // 理学療法（ＩＩ）コンボ(scienceTherapy2Combo)が無効ならば、理学療法（ＩＩ）コンボ(scienceTherapy2Combo)のbindPathを削除する。
      if (!getScienceTherapy2Combo().isEnabled()) {
          getValues().remove(getScienceTherapy2Combo().getBindPath());
      }
      // 理学（Ｉ）コンボ(science1Combo)が無効ならば、理学（Ｉ）コンボ(science1Combo)のbindPathを削除する。
      if (!getScience1Combo().isEnabled()) {
          getValues().remove(getScience1Combo().getBindPath());
      }
      // 理学（ＩＩ）コンボ(science2Combo)が無効ならば、理学（ＩＩ）コンボ(science2Combo)のbindPathを削除する。
      if (!getScience2Combo().isEnabled()) {
          getValues().remove(getScience2Combo().getBindPath());
      }
      // 作業療法コンボ(workTherapy1Combo)が無効ならば、作業療法コンボ(workTherapy1Combo)のbindPathを削除する。
      if (!getWorkTherapy1Combo().isEnabled()) {
          getValues().remove(getWorkTherapy1Combo().getBindPath());
      }
      // 作業コンボ(work1Combo)が無効ならば、作業（I）コンボ(work1Combo)のbindPathを削除する。
      if (!getWork1Combo().isEnabled()) {
          getValues().remove(getWork1Combo().getBindPath());
      }
      // 言語聴覚療法コンボ(languageTherapy1Combo)が無効ならば、言語聴覚療法コンボ(languageTherapy1Combo)のbindPathを削除する。
      if (!getLanguageTherapy1Combo().isEnabled()) {
          getValues().remove(getLanguageTherapy1Combo().getBindPath());
      }
      // 言語聴覚コンボ(language1Combo)が無効ならば、言語聴覚（I）コンボ(language1Combo)のbindPathを削除する。
      if (!getLanguage1Combo().isEnabled()) {
          getValues().remove(getLanguage1Combo().getBindPath());
      }

      // ※未選択なチェックの値を削除する。
      // 感染対策指導管理(infectionGuidanceManagement)が未選択ならば、感染対策指導管理(infectionGuidanceManagement)のbindPathを削除する。
      if (!getInfectionGuidanceManagement().isSelected()) {
          getValues().remove(getInfectionGuidanceManagement().getBindPath());
      }
      // 褥瘡対策指導管理(bedGuidanceManagement)が未選択ならば、褥瘡対策指導管理(bedGuidanceManagement)のbindPathを削除する。
      if (!getBedGuidanceManagement().isSelected()) {
          getValues().remove(getBedGuidanceManagement().getBindPath());
      }
      // 初期入院診療管理(beginningGuidanceManagement)が未選択ならば、初期入院診療管理(beginningGuidanceManagement)のbindPathを削除する。
      if (!getBeginningGuidanceManagement().isSelected()) {
          getValues().remove(getBeginningGuidanceManagement().getBindPath());
      }
      // 重度療養管理(heavyRecuperateGuidanceManagement)が未選択ならば、重度療養管理(heavyRecuperateGuidanceManagement)のbindPathを削除する。
      if (!getHeavyRecuperateGuidanceManagement().isSelected()) {
          getValues().remove(
                  getHeavyRecuperateGuidanceManagement().getBindPath());
      }
      // 特定施設管理(particularInstitutionManagment)が未選択ならば、特定施設管理(particularInstitutionManagment)のbindPathを削除する。
      if (!getParticularInstitutionManagment().isSelected()) {
          getValues().remove(
                  getParticularInstitutionManagment().getBindPath());
      }
      // 特定施設管理個室加算(particularInstitutionManagmentPrivateRoom)が未選択ならば、特定施設管理個室加算(particularInstitutionManagmentPrivateRoom)のbindPathを削除する。
      if (!getParticularInstitutionManagmentPrivateRoom().isSelected()) {
          getValues().remove(
                  getParticularInstitutionManagmentPrivateRoom()
                          .getBindPath());
      }
      // 特定施設管理2人部屋加算(particularInstitutionManagmentPrivateRoom2)が未選択ならば、特定施設管理2人部屋加算(particularInstitutionManagmentPrivateRoom2)のbindPathを削除する。
      if (!getParticularInstitutionManagmentPrivateRoom2().isSelected()) {
          getValues().remove(
                  getParticularInstitutionManagmentPrivateRoom2()
                          .getBindPath());
      }
      // 重症皮膚潰瘍管理指導(heavySkinManegement)が未選択ならば、重症皮膚潰瘍管理指導(heavySkinManegement)のbindPathを削除する。
      if (!getHeavySkinManegement().isSelected()) {
          getValues().remove(getHeavySkinManegement().getBindPath());
      }
      // 薬剤管理指導(medicineManegementLeading)が未選択ならば、薬剤管理指導(medicineManegementLeading)のbindPathを削除する。
      if (!getMedicineManegementLeading().isSelected()) {
          getValues().remove(getMedicineManegementLeading().getBindPath());
      }
      // 特別薬剤管理指導加算(specialMedicineManagementLeading)が未選択ならば、特別薬剤管理指導加算(specialMedicineManagementLeading)のbindPathを削除する。
      if (!getSpecialMedicineManagementLeading().isSelected()) {
          getValues().remove(
                  getSpecialMedicineManagementLeading().getBindPath());
      }
      // 医学情報提供（Ｉ）(medicalScienceInfo1)が未選択ならば、医学情報提供（Ｉ）(medicalScienceInfo1)のbindPathを削除する。
      if (!getMedicalScienceInfo1().isSelected()) {
          getValues().remove(getMedicalScienceInfo1().getBindPath());
      }
      // 医学情報提供（ＩＩ）(medicalScienceInfo2)が未選択ならば、医学情報提供（ＩＩ）(medicalScienceInfo2)のbindPathを削除する。
      if (!getMedicalScienceInfo2().isSelected()) {
          getValues().remove(getMedicalScienceInfo2().getBindPath());
      }
      // リハビリ計画加算(rehabilitationPlan)が未選択ならば、リハビリ計画加算(rehabilitationPlan)のbindPathを削除する。
      if (!getRehabilitationPlan().isSelected()) {
          getValues().remove(getRehabilitationPlan().getBindPath());
      }
      // 日常動作訓練指導加算(normalAction)が未選択ならば、日常動作訓練指導加算(normalAction)のbindPathを削除する。
      if (!getNormalAction().isSelected()) {
          getValues().remove(getNormalAction().getBindPath());
      }
      // リハビリ計画加算(rehabilitationPlan2)が未選択ならば、リハビリ計画加算(rehabilitationPlan2)のbindPathを削除する。
      if (!getRehabilitationPlan2().isSelected()) {
          getValues().remove(getRehabilitationPlan2().getBindPath());
      }
      // 日常動作訓練指導加算(normalActionTraning)が未選択ならば、日常動作訓練指導加算(normalActionTraning)のbindPathを削除する。
      if (!getNormalActionTraning().isSelected()) {
          getValues().remove(getNormalActionTraning().getBindPath());
      }
      // 摂食機能療法(dinner)が未選択ならば、摂食機能療法(dinner)のbindPathを削除する。
      if (!getDinner().isSelected()) {
          getValues().remove(getDinner().getBindPath());
      }
      // 精神科作業療法(mindTherapy)が未選択ならば、精神科作業療法(mindTherapy)のbindPathを削除する。
      if (!getMindTherapy().isSelected()) {
          getValues().remove(getMindTherapy().getBindPath());
      }
      // 認知症老人入院精神療法(cognitive)が未選択ならば、認知症老人入院精神療法(cognitive)のbindPathを削除する。
      if (!getCognitive().isSelected()) {
          getValues().remove(getCognitive().getBindPath());
      }
      //リハビリ体制強化加算(rehabilitationSystem)が未選択ならば、リハビリ体制強化加算(rehabilitationSystem)のbindPathを削除する。
      if (!getRehabilitationSystem().isSelected()) {
          getValues().remove(getRehabilitationSystem().getBindPath());
      }
      //リハビリ体制強化加算(rehabilitationSystem2)が未選択ならば、リハビリ体制強化加算(rehabilitationSystem2)のbindPathを削除する。
      if (!getRehabilitationSystem2().isSelected()) {
          getValues().remove(getRehabilitationSystem2().getBindPath());
      }
      //リハビリ体制強化加算(rehabilitationSystem3)が未選択ならば、リハビリ体制強化加算(rehabilitationSystem3)のbindPathを削除する。
      if (!getRehabilitationSystem3().isSelected()) {
          getValues().remove(getRehabilitationSystem3().getBindPath());
      }
      //短期集中リハビリ加算(concentratedRehabilitation)が未選択ならば、短期集中リハビリ加算(concentratedRehabilitation)のbindPathを削除する。
      if (!getConcentratedRehabilitation().isSelected()) {
          getValues().remove(getConcentratedRehabilitation().getBindPath());
      }
      // 集団コミュニケーション療法
      if(!getGroupCommunication().isSelected()) {
          getValues().remove(getGroupCommunication().getBindPath());
      }
      
      // 認知症短期集中リハビリ加算
      if(!getDementiaShortRehabilitation().isSelected()) {
          getValues().remove(getDementiaShortRehabilitation().getBindPath());
      }
      

      // ※設定済みとして閉じる。

      // 設定ボタンを押したかフラグをtrueにする。
      setApplied(true);
      // 画面を閉じる。
      dispose();
  }

  /**
   * 「理学療法（Ｉ）の有効状態変更」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected void scienceTherapy1ActionPerformed(ActionEvent e) throws Exception{
      // ※理学療法（Ｉ）のチェック有無に応じてコンボの有効状態を変更
      if (getScienceTherapy1().isSelected()) {
          // 理学療法（Ｉ）チェック(scienceTherapy1)が選択されている場合
          // 理学療法（Ｉ）コンボ(scienceTherapy1Combo)を有効にする。
          setState_VALID_SCIENCE_THERAPY1();
          // 理学療法（Ｉ）コンボ(scienceTherapy1Combo)の1つ目の項目を選択する。
          getScienceTherapy1Combo().setSelectedIndex(0);
      } else {
          // 理学療法（Ｉ）チェック(scienceTherapy1)が選択されていない場合
          // 理学療法（Ｉ）コンボ(scienceTherapy1Combo)を無効にする。
          setState_INVALID_SCIENCE_THERAPY1();
          // 理学療法（Ｉ）コンボ(scienceTherapy1Combo)を未選択状態にする。
          getScienceTherapy1Combo().clearSelection();
      }
  }

  /**
   * 「理学療法（ＩＩ）の有効状態変更」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected void scienceTherapy2ActionPerformed(ActionEvent e) throws Exception{
      // ※理学療法（ＩＩ）のチェック有無に応じてコンボの有効状態を変更
      if (getScienceTherapy2().isSelected()) {
          // 理学療法（ＩＩ）チェック(scienceTherapy2)が選択されている場合
          // 理学療法（ＩＩ）コンボ(scienceTherapy2Combo)を有効にする。
          setState_VALID_SCIENCE_THERAPY2();
          // 理学療法（ＩＩ）コンボ(scienceTherapy2Combo)の1つ目の項目を選択する。
          getScienceTherapy2Combo().setSelectedIndex(0);
      } else {
          // 理学療法（ＩＩ）チェック(scienceTherapy2)が選択されていない場合
          // 理学療法（ＩＩ）コンボ(scienceTherapy2Combo)を無効にする。
          setState_INVALID_SCIENCE_THERAPY2();
          // 理学療法（ＩＩ）コンボ(scienceTherapy2Combo)を未選択状態にする。
          getScienceTherapy2Combo().clearSelection();
      }

  }

  /**
   * 「理学（Ｉ）の有効状態変更」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected void science1ActionPerformed(ActionEvent e) throws Exception{
      // ※理学（Ｉ）のチェック有無に応じてコンボの有効状態を変更
      if (getScience1().isSelected()) {
          // 理学（Ｉ）チェック(science1)が選択されている場合
          // 理学（Ｉ）コンボ(science1Combo)を有効にする。
          setState_VALID_SCIENCE1();
          // 理学（Ｉ）コンボ(science1Combo)の1つ目の項目を選択する。
          getScience1Combo().setSelectedIndex(0);
      } else {
          // 理学（Ｉ）チェック(science1)が選択されていない場合
          // 理学（Ｉ）コンボ(science1Combo)を無効にする。
          setState_INVALID_SCIENCE1();
          // 理学（Ｉ）コンボ(science1Combo)を未選択状態にする。
          getScience1Combo().clearSelection();
      }
  }

  /**
   * 「理学（ＩＩ）の有効状態変更」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected void science2ActionPerformed(ActionEvent e) throws Exception{
      // ※理学（ＩＩ）のチェック有無に応じてコンボの有効状態を変更
      if (getScience2().isSelected()) {
          // 理学（ＩＩ）チェック(science2)が選択されている場合
          // 理学（ＩＩ）コンボ(science2Combo)を有効にする。
          setState_VALID_SCIENCE2();
          // 理学（ＩＩ）コンボ(science2Combo)の1つ目の項目を選択する。
          getScience2Combo().setSelectedIndex(0);
      } else {
          // 理学（ＩＩ）チェック(science2)が選択されていない場合
          // 理学（ＩＩ）コンボ(science2Combo)を無効にする。
          setState_INVALID_SCIENCE2();
          // 理学（ＩＩ）コンボ(science2Combo)を未選択状態にする。
          getScience2Combo().clearSelection();
      }

  }

  /**
   * 「作業療法Iの有効状態変更」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected void workTherapy1ActionPerformed(ActionEvent e) throws Exception{
      // ※作業療法のチェック有無に応じてコンボの有効状態を変更
      if (getWorkTherapy1().isSelected()) {
          // 作業療法チェック(workTherapy1)が選択されている場合
          // 作業療法コンボ(workTherapy1Combo)を有効にする。
          setState_VALID_WORK_THERAPY1();
          // 作業療法コンボ(workTherapy1Combo)の1つ目の項目を選択する。
          getWorkTherapy1Combo().setSelectedIndex(0);
      } else {
          // 作業療法チェック(workTherapy1)が選択されていない場合
          // 作業療法コンボ(workTherapy1Combo)を無効にする。
          setState_INVALID_WORK_THERAPY1();
          // 作業療法コンボ(workTherapy1Combo)を未選択状態にする。
          getWorkTherapy1Combo().clearSelection();
      }
  }

  /**
   * 「作業(I)の有効状態変更」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected void work1ActionPerformed(ActionEvent e) throws Exception{
      // ※作業のチェック有無に応じてコンボの有効状態を変更
      if (getWork1().isSelected()) {
          // 作業チェック(work1)が選択されている場合
          // 作業コンボ(work1Combo)を有効にする。
          setState_VALID_WORK1();
          // 作業コンボ(work1Combo)の1つ目の項目を選択する。
          getWork1Combo().setSelectedIndex(0);
      } else {
          // 作業チェック(work1)が選択されていない場合
          // 作業コンボ(work1Combo)を無効にする。
          setState_INVALID_WORK1();
          // 作業コンボ(work1Combo)を未選択状態にする。
          getWork1Combo().clearSelection();
      }

  }

  /**
   * 「言語聴覚療法Ｉの有効状態変更」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected void languageTherapy1ActionPerformed(ActionEvent e) throws Exception{
      // ※言語聴覚療法のチェック有無に応じてコンボの有効状態を変更
      if (getLanguageTherapy1().isSelected()) {
          // 言語聴覚療法チェック(languageTherapy1)が選択されている場合
          // 言語聴覚療法コンボ(languageTherapy1Combo)を有効にする。
          setState_VALID_LANGUAGE_THERAPY1();
          // 言語聴覚療法コンボ(languageTherapy1Combo)の1つ目の項目を選択する。
          getLanguageTherapy1Combo().setSelectedIndex(0);
      } else {
          // 言語聴覚療法チェック(languageTherapy1)が選択されていない場合
          // 言語聴覚療法コンボ(languageTherapy1Combo)を無効にする。
          setState_INVALID_LANGUAGE_THERAPY1();
          // 言語聴覚療法コンボ(languageTherapy1Combo)を未選択状態にする。
          getLanguageTherapy1Combo().clearSelection();
      }

  }

  /**
   * 「言語聴覚(I)の有効状態変更」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected void language1ActionPerformed(ActionEvent e) throws Exception{
      // ※言語聴覚のチェック有無に応じてコンボの有効状態を変更
      if (getLanguage1().isSelected()) {
          // 言語聴覚チェック(language1)が選択されている場合
          // 言語聴覚コンボ(language1Combo)を有効にする。
          setState_VALID_LANGUAGE1();
          // 言語聴覚コンボ(language1Combo)の1つ目の項目を選択する。
          getLanguage1Combo().setSelectedIndex(0);
      } else {
          // 言語聴覚チェック(language1)が選択されていない場合
          // 言語聴覚コンボ(language1Combo)を無効にする。
          setState_INVALID_LANGUAGE1();
          // 言語聴覚コンボ(language1Combo)を未選択状態にする。
          getLanguage1Combo().clearSelection();
      }

  }

  public static void main(String[] args) {
    //デフォルトデバッグ起動
    ACFrame.getInstance().setFrameEventProcesser(new QkanFrameEventProcesser());
    QkanCommon.debugInitialize();
    VRMap param = new VRHashMap();
    //paramに渡りパラメタを詰めて実行することで、簡易デバッグが可能です。
    ACFrame.debugStart(new ACAffairInfo(QS001199_H2104.class.getName(), param));
  }

  //内部関数

  /**
   * 「初期化」に関する処理を行ないます。
   * @throws Exception 処理例外
   */
  public boolean showModal(int systemServiceKindDetail, VRMap param) throws Exception{
      // ■画面の初期化

      setAffairTitle("QS001028");
      
      // ※コンボアイテムの設定
      // ※準備
      // コンボアイテム設定用のレコード comboItemMap を生成する。
      VRMap comboItemMap = new VRHashMap();

      // ※食事提供
      // コードマスタデータよりCODE_ID：109（理学療法(I)）を取得する。
      // 取得した値を、comboItemMapの KEY : 109 の VALUE として設定する。
      VRList codes = QkanCommon.getArrayFromMasterCode(109, "3010116");
      ACBindUtilities.copyBindPath(codes, "CONTENT_KEY", "3010117");
      ACBindUtilities.copyBindPath(codes, "CONTENT_KEY", "3010120");
      ACBindUtilities.copyBindPath(codes, "CONTENT_KEY", "3010121");
      ACBindUtilities.copyBindPath(codes, "CONTENT_KEY", "3010126");
      ACBindUtilities.copyBindPath(codes, "CONTENT_KEY", "3010128");
      ACBindUtilities.copyBindPath(codes, "CONTENT_KEY", "3010133");
      ACBindUtilities.copyBindPath(codes, "CONTENT_KEY", "3010135");
      comboItemMap.setData("109", codes);
      // ※コンボアイテムの設定
      getSpecificConsultationFeePattern().setModelSource(comboItemMap);
      // コンボアイテムを展開する。
      getSpecificConsultationFeePattern().bindModelSource();

      // ※サービスの種類に応じて表示項目を制限する。

      switch (systemServiceKindDetail) {
      // 引数systemServiceKindDetailの値が以下の短期入所療養介護サービスの場合
      // ・12201：短期入所療養介護(老健)
      case 12201:
      case 12211:
      // ・12301：短期入所療養介護(療養病床を有する病院)
      case 12301:
      case 12311:
      // ・12302：短期入所療養介護(療養病床を有する診療所)
      case 12302:
      case 12312:
      // ・12303：短期入所療養介護(老人性認知症疾患療養病棟を有する病院)
      case 12303:
      case 12313:
      // ・12304：短期入所療養介護(基準適合診療所)
      case 12304:
      case 12314:
      case 12511: //介護予防短期入所療養介護（老健）
      case 12611: //介護予防短期入所療養介護（病院）
      case 12612: //介護予防短期入所療養介護（診療所）
      case 12613: //介護予防短期入所療養介護（認知症疾患型）
          // 「初期入院診療管理・無効」状態にする。
          setState_INVALID_BEGINNIGN_GUIDANCE();
          break;
      }
      
      switch(systemServiceKindDetail) {
      // ・12301：短期入所療養介護(療養病床を有する病院)
      case 12301:
      case 12311:
      // ・12302：短期入所療養介護(療養病床を有する診療所)
      case 12302:
      case 12312:
      case 12611: // 介護予防短期入所療養介護（病院）
      case 12612: // 介護予防短期入所療養介護（診療所）
      case 15311: // 介護療養型医療施設(療養病床を有する病院)
      case 15312: // 介護療養型医療施設(療養病床を有する診療所)
          setState_DISPLAY_DEMENTIA_SHORT_REHA();
          setState_DISPLAY_GROUP();
          break;
      default:
          setState_NOT_DISPLAY_DEMENTIA_SHORT_REHA();
          setState_NOT_DISPLAY_GROUP();
          break;
      }
      boolean sizeDown = false;
      // [ID:0000499][Masahiko Higuchi] 2009/04/30 add begin 【特定診療費】平成21年4月以降の認知症短期集中リハの表示
      boolean sizeDownMedicalNinchi = false;
      // [ID:0000499][Masahiko Higuchi] 2009/04/30 add end
      switch (systemServiceKindDetail) {
      // 引数systemServiceKindDetailの値が以下の老人性認知症疾患療養病棟サービスの場合
      case 12303:
      case 12313:
      // ・12303：短期入所療養介護(老人性認知症疾患療養病棟を有する病院)
      case 15303:
      case 15313:
          // ・15303：介護療養型医療施設(老人性認知症疾患療養病棟を有する病院)
      case 12613: //介護予防短期入所療養介護（認知症疾患型）
          // [ID:0000499][Masahiko Higuchi] 2009/04/30 replace begin 【特定診療費】平成21年4月以降の認知症短期集中リハの表示
          // 介護療養型医療施設（認知症疾患型）個別制御
          switch(systemServiceKindDetail){
          case 15303:
          case 15313:
              setState_DISPLAY_MEDICAL_OLD_COGNITIVE_STATE();
              // 専用の画面制御フラグを有効にする
              sizeDownMedicalNinchi = true;
              break;
          default:
              // 「老人性認知症疾患療養病棟」状態にする。
              setState_OLD_COGNITIVE_WARD();
              sizeDown = true;
          }
          // [ID:0000499][Masahiko Higuchi] 2009/04/30 replace end
          break;
      }

      // [ID:0000495][Tozo TANAKA] 2009/04/28 add begin 【特定診療費】平成21年4月以降の重度療養管理の削除
      // [ID:0000499][Masahiko Higuchi] 2009/04/30 add begin 【特定診療費】平成21年4月以降の認知症短期集中リハの表示
      switch (systemServiceKindDetail) {
      // 引数systemServiceKindDetailの値が以下の介護療養型医療施設サービスの場合
      case 15311:
            // ・15311：介護療養型医療施設(療養病床を有する病院)
      case 15312:
            // ・15312：介護療養型医療施設(療養病床を有する診療所)
      case 15303:
      case 15313:
            // ・15313：介護療養型医療施設(老人性認知症疾患療養病棟を有する病院);
          //「重度療養管理非表示」状態にする。
          setState_NOT_DISPLAY_HEAVY_RECUPERATE_GUIDANCE();
          // 認知症短期集中リハの表示
          setState_DISPLAY_DEMENTIA_SHORT_REHA();
      }
      // [ID:0000495][Tozo TANAKA] 2009/04/28 add end 【特定診療費】平成21年4月以降の重度療養管理の削除
      // [ID:0000499][Masahiko Higuchi] 2009/04/30 add end
      
      // ※引数で渡された特定診療費情報を画面に展開する。
      // 引数param を内部変数valuesに設定する。
      setValues(param);
      // valuesの値を画面に展開する。
      getSpecificConsultationFeePattern().setSource(getValues());
      getSpecificConsultationFeePattern().bindSource();

      // ※コンボの選択状態からチェックの選択状態とコンボの有効状を求める。


      // 理学療法（Ｉ）コンボ(scienceTherapy1Combo)が選択されていれば、理学療法（Ｉ）チェック(scienceTherapy1)を選択する。
      getScienceTherapy1()
              .setSelected(getScienceTherapy1Combo().isSelected());
      if(getScienceTherapy1().isSelected()){
          setState_VALID_SCIENCE_THERAPY1();
      }
      // 理学療法（ＩＩ）コンボ(scienceTherapy2Combo)が選択されていれば、理学療法（ＩＩ）チェック(scienceTherapy2)を選択する。
      getScienceTherapy2()
              .setSelected(getScienceTherapy2Combo().isSelected());
      if(getScienceTherapy2().isSelected()){
          setState_VALID_SCIENCE_THERAPY2();
      }
      // 理学（Ｉ）コンボ(science1Combo)が選択されていれば、理学（Ｉ）チェック(science1)を選択する。
      getScience1().setSelected(getScience1Combo().isSelected());
      if(getScience1().isSelected()){
          setState_VALID_SCIENCE1();
      }
      // 理学（ＩＩ）コンボ(science2Combo)が選択されていれば、理学（ＩＩ）チェック(science2)を選択する。
      getScience2().setSelected(getScience2Combo().isSelected());
      if(getScience2().isSelected()){
          setState_VALID_SCIENCE2();
      }
      // 作業療法コンボ(workTherapy1Combo)が選択されていれば、作業療法チェック(workTherapy1)を選択する。
      getWorkTherapy1().setSelected(getWorkTherapy1Combo().isSelected());
      if(getWorkTherapy1().isSelected()){
          setState_VALID_WORK_THERAPY1();
      }
      // 作業コンボ(work1Combo)が選択されていれば、作業チェック(work1)を選択する。
      getWork1().setSelected(getWork1Combo().isSelected());
      if(getWork1().isSelected()){
          setState_VALID_WORK1();
      }
      // 言語聴覚療法コンボ(languageTherapy1Combo)が選択されていれば、言語聴覚療法チェック(languageTherapy1)を選択する。
      getLanguageTherapy1().setSelected(
              getLanguageTherapy1Combo().isSelected());
      if(getLanguageTherapy1().isSelected()){
          setState_VALID_LANGUAGE_THERAPY1();
      }
      // 言語聴覚コンボ(language1Combo)が選択されていれば、言語聴覚チェック(language1)を選択する。
      getLanguage1().setSelected(getLanguage1Combo().isSelected());
      if(getLanguage1().isSelected()){
          setState_VALID_LANGUAGE1();
      }
      
      if(sizeDown){
          setSize(600, 280);
      }else{
          setSize(800, 605);
      }

      // [ID:0000499][Masahiko Higuchi] 2009/04/30 add begin 【特定診療費】平成21年4月以降の認知症短期集中リハの表示
      // 介護療養型医療施設（認知症疾患型）の場合
      if(sizeDownMedicalNinchi) {
          setSize(600, 385);
      }
      // [ID:0000499][Masahiko Higuchi] 2009/04/30 add end

      // 画面を表示する。
      setVisible(true);
      
      return getApplied();
  }

  /**
   * 「対象バインドパス取得」に関する処理を行ないます。
   * @throws Exception 処理例外
   */
  public static String[] getTargetBindPathes(int systemServiceKindDetail) throws Exception{
    // ※サービスごとに対象とするバインドパスを取得
      switch (systemServiceKindDetail) {
      // 引数systemServiceKindDetailの値が以下の短期入所療養介護サービスの場合
      case 12201:// 短期入所療養介護(老健)
      case 12211:
      case 12301:// 短期入所療養介護（病院療養）
      case 12311:
      case 12302:// 短期入所療養介護（診療所療養）
      case 12312:
      case 12304:// 短期入所療養介護(基準適合診療所)
      case 12314:
      case 12511: //介護予防短期入所療養介護（老健）
      case 12611: //介護予防短期入所療養介護（病院）
      case 12612: //介護予防短期入所療養介護（診療所）
          return new String[] { "3010101", "3010102", "3010104", "3010105",
                    "3010106", "3010107", "3010108", "3010110", "3010111",
                    "3010112", "3010113", "3010116", "3010117", "3010120",
                    "3010121", "3010123", "3010124", "3010126", "3010128",
                    "3010130", "3010131", "3010133", "3010135", "3010136",
                    "3010137", "3010138", "3010139", "3010140", "3010141",
                    "3010143", "3010150" , "3010151" };
      // 引数systemServiceKindDetailの値が以下の短期入所療養介護かつ老人性認知症疾患療養病棟サービスの場合
      case 12303:// 短期入所療養介護(老人性認知症疾患療養病棟を有する病院)
      case 12313:
      case 12613: //介護予防短期入所療養介護（認知症疾患型）
          return new String[] { "3010101", "3010102", "3010104", "3010137",
                  "3010138", };
      // 引数systemServiceKindDetailの値が以下の老人性認知症疾患療養病棟サービスの場合
      case 15303:// 介護療養型医療施設(老人性認知症疾患療養病棟を有する病院)
      case 15313:
          // [ID:0000495][Tozo TANAKA] 2009/04/28 replace begin 【特定診療費】平成21年4月以降の重度療養管理の削除
          // [ID:0000499][Masahiko Higuchi] 2009/04/30 replace begin 【特定診療費】平成21年4月以降の認知症短期集中リハの表示
//          return new String[] { "3010101", "3010102", "3010103", "3010104",
//                  "3010137", "3010138", };
          return new String[] { "3010101", "3010102", "3010103", 
                  "3010137", "3010138", "3010151" };
          // [ID:0000499][Masahiko Higuchi] 2009/04/30 replace end
      case 15311:
          //介護療養型医療施設(療養病床を有する病院)
      case 15312:
          //介護療養型医療施設(療養病床を有する診療所)
          return new String[] { "3010101", "3010102", "3010103", 
                  "3010105", "3010106", "3010107", "3010108", "3010110",
                  "3010111", "3010112", "3010113", "3010116", "3010117",
                  "3010120", "3010121", "3010123", "3010124", "3010126",
                  "3010128", "3010130", "3010131", "3010133", "3010135",
                  "3010136", "3010137", "3010138", "3010139", "3010140",
                  "3010141", "3010143", "3010150" , "3010151" };
          // [ID:0000495][Tozo TANAKA] 2009/04/28 replace end 【特定診療費】平成21年4月以降の重度療養管理の削除
      default:
          return new String[] { "3010101", "3010102", "3010103", "3010104",
                    "3010105", "3010106", "3010107", "3010108", "3010110",
                    "3010111", "3010112", "3010113", "3010116", "3010117",
                    "3010120", "3010121", "3010123", "3010124", "3010126",
                    "3010128", "3010130", "3010131", "3010133", "3010135",
                    "3010136", "3010137", "3010138", "3010139", "3010140",
                    "3010141", "3010143", "3010150" , "3010151" };
      }
  }

}
