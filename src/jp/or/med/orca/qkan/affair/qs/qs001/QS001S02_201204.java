
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
 * 作成日: 2008/04/14  日本コンピューター株式会社 樋口　雅彦 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 予定管理 (S)
 * プロセス サービス予定 (001)
 * プログラム 特別療養費画面 (QS001200)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
import java.awt.event.ActionEvent;

import jp.nichicom.ac.bind.ACBindUtilities;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;

/**
 * 特別療養費画面(QS001200) 
 */
@SuppressWarnings("serial")
public class QS001S02_201204 extends QS001S02_201204Event {
  /**
   * コンストラクタです。
   */
  public QS001S02_201204(){
  }

  // コンポーネントイベント
  /**
   * 「設定」イベントです。
   * 
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected void applyActionPerformed(ActionEvent e) throws Exception {
      // ※画面の状態を呼び出し元に返す
      // valuesに画面の値を格納する。
      getSpecificConsultationFeePattern().setSource(getValues());
      getValues().clear();
      getSpecificConsultationFeePattern().applySource();

      // ※無効なコンボの値を削除する。
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
      // 医学情報提供(medicalScienceInfo)が未選択ならば、医学情報提供（Ｉ）(medicalScienceInfo)のbindPathを削除する。
      if (!getMedicalScienceInfo().isSelected()) {
          getValues().remove(getMedicalScienceInfo().getBindPath());
      }
      // 摂食機能療法(dinner)が未選択ならば、摂食機能療法(dinner)のbindPathを削除する。
      if (!getDinner().isSelected()) {
          getValues().remove(getDinner().getBindPath());
      }
      // 精神科作業療法(mindTherapy)が未選択ならば、精神科作業療法(mindTherapy)のbindPathを削除する。
      if (!getMindTherapy().isSelected()) {
          getValues().remove(getMindTherapy().getBindPath());
      }
      // 認知症入所精神療法(cognitive)が未選択ならば、認知症老人入院精神療法(cognitive)のbindPathを削除する。
      if (!getCognitive().isSelected()) {
          getValues().remove(getCognitive().getBindPath());
      }
      // リハビリ提供指導加算が未選択ならば削除
      if(!getRehabilitationManegement().isSelected()){
          getValues().remove(getRehabilitationManegement().getBindPath());
      }
      // リハビリ体制強化加算コンボ(rehabilitationSystemCombo)が無効ならば、リハビリ体制強化加算コンボ(rehabilitationSystemCombo)のbindPathを削除する。
      if (!getRehabilitationSystemCombo().isEnabled()) {
          getValues().remove(getRehabilitationSystemCombo().getBindPath());
      }

      // ※設定済みとして閉じる。

      // 設定ボタンを押したかフラグをtrueにする。
      setApplied(true);
      // 画面を閉じる。
      dispose();
  }

  /**
   * 「言語聴覚療法の有効状態変更」イベントです。
   * 
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected void languageTherapy1ActionPerformed(ActionEvent e)
          throws Exception {
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
   * 「言語聴覚の有効状態変更」イベントです。
   * 
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected void language1ActionPerformed(ActionEvent e) throws Exception {
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

  /**
   * 「リハビリ体制強化加算の有効状態変更」イベントです。
   * 
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected void rehabilitationSystemActionPerformed(ActionEvent e)
          throws Exception {
      // ※リハビリ体制強化加算のチェック有無に応じてコンボの有効状態を変更
      if (getRehabilitationSystem().isSelected()) {
          // リハビリ体制強化加算チェック(rehabilitationSystem)が選択されている場合
          // リハビリ体制強化加算コンボ(rehabilitationSystemCombo)を有効にする。
    	  setState_VALID_RIHABIRI_SYSTEM();
          // リハビリ体制強化加算コンボ(rehabilitationSystemCombo)の1つ目の項目を選択する。
    	  getRehabilitationSystemCombo().setSelectedIndex(0);
      } else {
          // リハビリ体制強化加算チェック(rehabilitationSystem)が選択されていない場合
          // リハビリ体制強化加算コンボ(rehabilitationSystemCombo)を無効にする。
    	  setState_INVALID_RIHABIRI_SYSTEM();
          // リハビリ体制強化加算コンボ(rehabilitationSystemCombo)を未選択状態にする。
    	  getRehabilitationSystemCombo().clearSelection();
      }

  }
 
  public static void main(String[] args) {
      // デフォルトデバッグ起動
      ACFrame.getInstance().setFrameEventProcesser(
              new QkanFrameEventProcesser());
      QkanCommon.debugInitialize();
      VRMap param = new VRHashMap();
      // paramに渡りパラメタを詰めて実行することで、簡易デバッグが可能です。
      ACFrame.debugStart(new ACAffairInfo(QS001S02_201204.class.getName(), param));
  }

  // 内部関数

  /**
   * 「初期化」に関する処理を行ないます。
   * 
   * @param systemServiceKindDetail int
   * @param param VRMap
   * @throws Exception 処理例外
   * @return boolean
   */
  public boolean showModal(int systemServiceKindDetail, VRMap param)
          throws Exception {
      // ■画面の初期化

      setAffairTitle("QS001S02");
      
      // ※コンボアイテムの設定
      // ※準備
      // コンボアイテム設定用のレコード comboItemMap を生成する。
      VRMap comboItemMap = new VRHashMap();

      // ※食事提供
      // コードマスタデータよりCODE_ID：109（理学療法(I)）を取得する。
      // 取得した値を、comboItemMapの KEY : 109 の VALUE として設定する。
      VRList codes = QkanCommon.getArrayFromMasterCode(109, "3010115");
      ACBindUtilities.copyBindPath(codes, "CONTENT_KEY", "3010147");
      ACBindUtilities.copyBindPath(codes, "CONTENT_KEY", "3010148");
      ACBindUtilities.copyBindPath(codes, "CONTENT_KEY", "3010141");
      
      comboItemMap.setData("109", codes);
      // ※コンボアイテムの設定
      // 自身(specificConsultationFeePattern)にcomboItemMapに設定する。
      getSpecificConsultationFeePattern().setModelSource(comboItemMap);
      // コンボアイテムを展開する。
      getSpecificConsultationFeePattern().bindModelSource();

      // ※サービスの種類に応じて表示項目を制限する。
      switch (systemServiceKindDetail) {
      case 12211:// 短期入所療養介護(老健)
          setState_HEALTH_FACILITIES_WARD();
          // 初期入所診療管理を無効状態にする
          setState_INVALID_BEGINNIGN_GUIDANCE();
          // リハビリテーション指導管理を無効状態にする。
          setState_INVALID_REHABILITATION_MANEGEMENT();
          break;
          
      case 12511:// 介護予防短期入所療養介護（老健）
          setState_HEALTH_FACILITIES_WARD();
          // 初期入所診療管理を無効状態にする
          setState_INVALID_BEGINNIGN_GUIDANCE();
          // リハビリテーション指導管理を無効状態にする。
          setState_INVALID_REHABILITATION_MANEGEMENT();
          // 重度療養管理を無効状態にする。
          setState_INVALID_HEAVY_RECUPERATE();
          break;
          
      case 15211:// 老人保健施設
          // 老人保健施設関連の特別療養費状態に設定する
          setState_HEALTH_FACILITIES_WARD();
          break;
      }

      // ※引数で渡された特定診療費情報を画面に展開する。
      // 引数param を内部変数valuesに設定する。
      setValues(param);
      // valuesの値を画面に展開する。
      getSpecificConsultationFeePattern().setSource(getValues());
      getSpecificConsultationFeePattern().bindSource();

      // ※コンボの選択状態からチェックの選択状態とコンボの有効状を求める。

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
      // リハビリ体制強化加算コンボ(rehabilitationSystemCombo)が選択されていれば、リハビリ体制強化加算チェック(rehabilitationSystem)を選択する。
      getRehabilitationSystem().setSelected(
    		  getRehabilitationSystemCombo().isSelected());
      if(getRehabilitationSystem().isSelected()){
    	  setState_VALID_RIHABIRI_SYSTEM();
      }
      // 画面を表示する。
      setVisible(true);
      
      return getApplied();
  }

  public static String[] getTargetBindPathes(int systemServiceKindDetail)
          throws Exception {
      switch (systemServiceKindDetail) {
      // 引数systemServiceKindDetailの値が以下の短期入所療養介護サービスの場合
      case 12211:// 短期入所療養介護(老健)
          // リハビリテーション指導管理は対象外
          return new String[] { "3010101", "3010102", "3010104", "3010105",
                  "3010106", "3010107", "3010108", "3010110", "3010111",
                  "3010136", "3010137", "3010138", "3010141","3010145",
                  "3010147", "3010148", "3010149" };
      case 12511:// 介護予防短期入所療養介護（老健）
          // リハビリテーション指導管理は対象外
          // 重度療養管理は対象外
          return new String[] { "3010101", "3010102", "3010105", "3010106",
                    "3010107", "3010108", "3010110", "3010111", "3010136",
                    "3010137", "3010138", "3010141", "3010145", "3010147",
                    "3010148", "3010149" };
      case 15211:// 老人保健施設
          return new String[] { "3010101", "3010102", "3010104", "3010105",
                    "3010106", "3010107", "3010108", "3010110", "3010111",
                    "3010136", "3010137", "3010138", "3010141", "3010144",
                    "3010145", "3010146", "3010147", "3010148", "3010149" };
      default:
          return new String[] { "3010101", "3010102", "3010104", "3010105",
              "3010106", "3010107", "3010108", "3010110", "3010111",
              "3010136", "3010137", "3010138", "3010141", "3010145",
              "3010146", "3010147", "3010148", "3010149" };
      }
  }
}
