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
 * 開発者: 堤 瑞樹
 * 作成日: 2006/02/02  日本コンピューター株式会社 堤 瑞樹 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 予定管理 (S)
 * プロセス 特定診療費画面 (001)
 * プログラム 特定診療費画面 (QS001028)
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
 * 特定診療費画面(QS001028)
 */
public class QS001028 extends QS001028Event {
    /**
     * コンストラクタです。
     */
    public QS001028() {
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
        // 理学療法（Ｉ）コンボ(scienceTherapy1Combo)が無効ならば、理学療法（Ｉ）コンボ(scienceTherapy1Combo)のbindPathを削除する。
        if (!getScienceTherapy1Combo().isEnabled()) {
            getValues().remove(getScienceTherapy1Combo().getBindPath());
        }
        // 理学療法（ＩＩ）コンボ(scienceTherapy2Combo)が無効ならば、理学療法（ＩＩ）コンボ(scienceTherapy2Combo)のbindPathを削除する。
        if (!getScienceTherapy2Combo().isEnabled()) {
            getValues().remove(getScienceTherapy2Combo().getBindPath());
        }
        // 理学療法（ＩＩＩ）コンボ(scienceTherapy3Combo)が無効ならば、理学療法（ＩＩＩ）コンボ(scienceTherapy3Combo)のbindPathを削除する。
        if (!getScienceTherapy3Combo().isEnabled()) {
            getValues().remove(getScienceTherapy3Combo().getBindPath());
        }
        // 理学療法（ＩＶ）コンボ(scienceTherapy4Combo)が無効ならば、理学療法（ＩＶ）コンボ(scienceTherapy4Combo)のbindPathを削除する。
        if (!getScienceTherapy4Combo().isEnabled()) {
            getValues().remove(getScienceTherapy4Combo().getBindPath());
        }
        // 理学（Ｉ）コンボ(science1Combo)が無効ならば、理学（Ｉ）コンボ(science1Combo)のbindPathを削除する。
        if (!getScience1Combo().isEnabled()) {
            getValues().remove(getScience1Combo().getBindPath());
        }
        // 理学（ＩＩ）コンボ(science2Combo)が無効ならば、理学（ＩＩ）コンボ(science2Combo)のbindPathを削除する。
        if (!getScience2Combo().isEnabled()) {
            getValues().remove(getScience2Combo().getBindPath());
        }
        // 理学（ＩＩＩ）コンボ(science3Combo)が無効ならば、理学（ＩＩＩ）コンボ(science3Combo)のbindPathを削除する。
        if (!getScience3Combo().isEnabled()) {
            getValues().remove(getScience3Combo().getBindPath());
        }
        // 理学（ＩＶ）コンボ(science4Combo)が無効ならば、理学（ＩＶ）コンボ(science4Combo)のbindPathを削除する。
        if (!getScience4Combo().isEnabled()) {
            getValues().remove(getScience4Combo().getBindPath());
        }
        // 日常生活活動訓練加算コンボ(normalLifeCombo)が無効ならば、日常生活活動訓練加算コンボ(normalLifeCombo)のbindPathを削除する。
        if (!getNormalLifeCombo().isEnabled()) {
            getValues().remove(getNormalLifeCombo().getBindPath());
        }
        // 作業療法Iコンボ(workTherapy1Combo)が無効ならば、作業療法Iコンボ(workTherapy1Combo)のbindPathを削除する。
        if (!getWorkTherapy1Combo().isEnabled()) {
            getValues().remove(getWorkTherapy1Combo().getBindPath());
        }
        // 作業療法IIコンボ(workTherapy2Combo)が無効ならば、作業療法IIコンボ(workTherapy2Combo)のbindPathを削除する。
        if (!getWorkTherapy2Combo().isEnabled()) {
            getValues().remove(getWorkTherapy2Combo().getBindPath());
        }
        // 作業（I）コンボ(work1Combo)が無効ならば、作業（I）コンボ(work1Combo)のbindPathを削除する。
        if (!getWork1Combo().isEnabled()) {
            getValues().remove(getWork1Combo().getBindPath());
        }
        // 作業（II）コンボ(work2Combo)が無効ならば、作業（II）コンボ(work2Combo)のbindPathを削除する。
        if (!getWork2Combo().isEnabled()) {
            getValues().remove(getWork2Combo().getBindPath());
        }
        // 日常生活活動導加算コンボ(normalLife2Combo)が無効ならば、日常生活活動導加算コンボ(normalLife2Combo)のbindPathを削除する。
        if (!getNormalLife2Combo().isEnabled()) {
            getValues().remove(getNormalLife2Combo().getBindPath());
        }
        // 言語聴覚療法Ｉコンボ(languageTherapy1Combo)が無効ならば、言語聴覚療法Ｉコンボ(languageTherapy1Combo)のbindPathを削除する。
        if (!getLanguageTherapy1Combo().isEnabled()) {
            getValues().remove(getLanguageTherapy1Combo().getBindPath());
        }
        // 言語聴覚療法IIコンボ(languageTherapy2Combo)が無効ならば、言語聴覚療法IIコンボ(languageTherapy2Combo)のbindPathを削除する。
        if (!getLanguageTherapy2Combo().isEnabled()) {
            getValues().remove(getLanguageTherapy2Combo().getBindPath());
        }
        // 言語聴覚（I）コンボ(language1Combo)が無効ならば、言語聴覚（I）コンボ(language1Combo)のbindPathを削除する。
        if (!getLanguage1Combo().isEnabled()) {
            getValues().remove(getLanguage1Combo().getBindPath());
        }
        // 言語聴覚（II）コンボ(language2Combo)が無効ならば、言語聴覚（II）コンボ(language2Combo)のbindPathを削除する。
        if (!getLanguage2Combo().isEnabled()) {
            getValues().remove(getLanguage2Combo().getBindPath());
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
        // 介護栄養食事指導(careNutritionDinnerLeading)が未選択ならば、介護栄養食事指導(careNutritionDinnerLeading)のbindPathを削除する。
        if (!getCareNutritionDinnerLeading().isSelected()) {
            getValues().remove(getCareNutritionDinnerLeading().getBindPath());
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

        // ※設定済みとして閉じる。

        // 設定ボタンを押したかフラグをtrueにする。
        setApplied(true);
        // 画面を閉じる。
        dispose();
    }

    /**
     * 「キャンセル」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void closeActionPerformed(ActionEvent e) throws Exception {
        // ※画面の状態を破棄する
        // (valuesの更新は行わない)
        dispose();
    }

    /**
     * 「理学療法（Ｉ）の有効状態変更」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void scienceTherapy1ActionPerformed(ActionEvent e)
            throws Exception {
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
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void scienceTherapy2ActionPerformed(ActionEvent e)
            throws Exception {
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
     * 「理学療法（ＩＩＩ）の有効状態変更」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void scienceTherapy3ActionPerformed(ActionEvent e)
            throws Exception {
        // ※理学療法（ＩＩＩ）のチェック有無に応じてコンボの有効状態を変更
        if (getScienceTherapy3().isSelected()) {
            // 理学療法（ＩＩＩ）チェック(scienceTherapy3)が選択されている場合
            // 理学療法（ＩＩＩ）コンボ(scienceTherapy3Combo)を有効にする。
            setState_VALID_SCIENCE_THERAPY3();
            // 理学療法（ＩＩＩ）コンボ(scienceTherapy3Combo)の1つ目の項目を選択する。
            getScienceTherapy3Combo().setSelectedIndex(0);
        } else {
            // 理学療法（ＩＩＩ）チェック(scienceTherapy3)が選択されていない場合
            // 理学療法（ＩＩＩ）コンボ(scienceTherapy3Combo)を無効にする。
            setState_INVALID_SCIENCE_THERAPY3();
            // 理学療法（ＩＩＩ）コンボ(scienceTherapy3Combo)を未選択状態にする。
            getScienceTherapy3Combo().clearSelection();
        }

    }

    /**
     * 「理学療法（ＩＶ）の有効状態変更」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void scienceTherapy4ActionPerformed(ActionEvent e)
            throws Exception {
        // ※理学療法（ＩＶ）のチェック有無に応じてコンボの有効状態を変更
        if (getScienceTherapy4().isSelected()) {
            // 理学療法（ＩＶ）チェック(scienceTherapy4)が選択されている場合
            // 理学療法（ＩＶ）コンボ(scienceTherapy4Combo)を有効にする。
            setState_VALID_SCIENCE_THERAPY4();
            // 理学療法（ＩＶ）コンボ(scienceTherapy4Combo)の1つ目の項目を選択する。
            getScienceTherapy4Combo().setSelectedIndex(0);
        } else {
            // 理学療法（ＩＶ）チェック(scienceTherapy4)が選択されていない場合
            // 理学療法（ＩＶ）コンボ(scienceTherapy4Combo)を無効にする。
            setState_INVALID_SCIENCE_THERAPY4();
            // 理学療法（ＩＶ）コンボ(scienceTherapy4Combo)を未選択状態にする。
            getScienceTherapy4Combo().clearSelection();
        }

    }

    /**
     * 「理学（Ｉ）の有効状態変更」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void science1ActionPerformed(ActionEvent e) throws Exception {
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
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void science2ActionPerformed(ActionEvent e) throws Exception {
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
     * 「理学（ＩＩＩ）の有効状態変更」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void science3ActionPerformed(ActionEvent e) throws Exception {
        // ※理学（ＩＩＩ）のチェック有無に応じてコンボの有効状態を変更
        if (getScience3().isSelected()) {
            // 理学（ＩＩＩ）チェック(science3)が選択されている場合
            // 理学（ＩＩＩ）コンボ(science3Combo)を有効にする。
            setState_VALID_SCIENCE3();
            // 理学（ＩＩＩ）コンボ(science3Combo)の1つ目の項目を選択する。
            getScience3Combo().setSelectedIndex(0);
        } else {
            // 理学（ＩＩＩ）チェック(science3)が選択されていない場合
            // 理学（ＩＩＩ）コンボ(science3Combo)を無効にする。
            setState_INVALID_SCIENCE3();
            // 理学（ＩＩＩ）コンボ(science3Combo)を未選択状態にする。
            getScience3Combo().clearSelection();
        }

    }

    /**
     * 「理学（ＩＶ）の有効状態変更」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void science4ActionPerformed(ActionEvent e) throws Exception {
        // ※理学（ＩＶ）のチェック有無に応じてコンボの有効状態を変更
        if (getScience4().isSelected()) {
            // 理学（ＩＶ）チェック(science4)が選択されている場合
            // 理学（ＩＶ）コンボ(science4Combo)を有効にする。
            setState_VALID_SCIENCE4();
            // 理学（ＩＶ）コンボ(science4Combo)の1つ目の項目を選択する。
            getScience4Combo().setSelectedIndex(0);
        } else {
            // 理学（ＩＶ）チェック(science4)が選択されていない場合
            // 理学（ＩＶ）コンボ(science4Combo)を無効にする。
            setState_INVALID_SCIENCE4();
            // 理学（ＩＶ）コンボ(science4Combo)を未選択状態にする。
            getScience4Combo().clearSelection();
        }

    }

    /**
     * 「日常生活活動訓練加算の有効状態変更」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void normalLifeActionPerformed(ActionEvent e) throws Exception {
        // ※日常生活活動訓練加算のチェック有無に応じてコンボの有効状態を変更
        if (getNormalLife().isSelected()) {
            // 日常生活活動訓練加算チェック(normalLife)が選択されている場合
            // 日常生活活動訓練加算コンボ(normalLifeCombo)を有効にする。
            setState_VALID_NORMAL_LIFE_();
            // 日常生活活動訓練加算コンボ(normalLifeCombo)の1つ目の項目を選択する。
            getNormalLifeCombo().setSelectedIndex(0);
        } else {
            // 日常生活活動訓練加算チェック(normalLife)が選択されていない場合
            // 日常生活活動訓練加算コンボ(normalLifeCombo)を無効にする。
            setState_INVALID_NORMAL_LIFE_();
            // 日常生活活動訓練加算コンボ(normalLifeCombo)を未選択状態にする。
            getNormalLifeCombo().clearSelection();
        }

    }

    /**
     * 「作業療法Iの有効状態変更」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void workTherapy1ActionPerformed(ActionEvent e) throws Exception {
        // ※作業療法Iのチェック有無に応じてコンボの有効状態を変更
        if (getWorkTherapy1().isSelected()) {
            // 作業療法Iチェック(workTherapy1)が選択されている場合
            // 作業療法Iコンボ(workTherapy1Combo)を有効にする。
            setState_VALID_WORK_THERAPY1();
            // 作業療法Iコンボ(workTherapy1Combo)の1つ目の項目を選択する。
            getWorkTherapy1Combo().setSelectedIndex(0);
        } else {
            // 作業療法Iチェック(workTherapy1)が選択されていない場合
            // 作業療法Iコンボ(workTherapy1Combo)を無効にする。
            setState_INVALID_WORK_THERAPY1();
            // 作業療法Iコンボ(workTherapy1Combo)を未選択状態にする。
            getWorkTherapy1Combo().clearSelection();
        }

    }

    /**
     * 「作業療法IIの有効状態変更」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void workTherapy2ActionPerformed(ActionEvent e) throws Exception {
        // ※作業療法IIのチェック有無に応じてコンボの有効状態を変更
        if (getWorkTherapy2().isSelected()) {
            // 作業療法IIチェック(workTherapy2)が選択されている場合
            // 作業療法IIコンボ(workTherapy2Combo)を有効にする。
            setState_VALID_WORK_THERAPY2();
            // 作業療法IIコンボ(workTherapy2Combo)の1つ目の項目を選択する。
            getWorkTherapy2Combo().setSelectedIndex(0);
        } else {
            // 作業療法IIチェック(workTherapy2)が選択されていない場合
            // 作業療法IIコンボ(workTherapy2Combo)を無効にする。
            setState_INVALID_WORK_THERAPY2();
            // 作業療法IIコンボ(workTherapy2Combo)を未選択状態にする。
            getWorkTherapy2Combo().clearSelection();
        }

    }

    /**
     * 「作業(I)の有効状態変更」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void work1ActionPerformed(ActionEvent e) throws Exception {
        // ※作業(I)のチェック有無に応じてコンボの有効状態を変更
        if (getWork1().isSelected()) {
            // 作業(I)チェック(work1)が選択されている場合
            // 作業(I)コンボ(work1Combo)を有効にする。
            setState_VALID_WORK1();
            // 作業（I）コンボ(work1Combo)の1つ目の項目を選択する。
            getWork1Combo().setSelectedIndex(0);
        } else {
            // 作業(I)チェック(work1)が選択されていない場合
            // 作業(I)コンボ(work1Combo)を無効にする。
            setState_INVALID_WORK1();
            // 作業(I)コンボ(work1Combo)を未選択状態にする。
            getWork1Combo().clearSelection();
        }

    }

    /**
     * 「作業(II)の有効状態変更」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void work2ActionPerformed(ActionEvent e) throws Exception {
        // ※作業(II)のチェック有無に応じてコンボの有効状態を変更
        if (getWork2().isSelected()) {
            // 作業(II)チェック(work2)が選択されている場合
            // 作業(II)コンボ(work2Combo)を有効にする。
            setState_VALID_WORK2();
            // 作業（II）コンボ(work2Combo)の1つ目の項目を選択する。
            getWork2Combo().setSelectedIndex(0);
        } else {
            // 作業(II)チェック(work2)が選択されていない場合
            // 作業(II)コンボ(work2Combo)を無効にする。
            setState_INVALID_WORK2();
            // 作業(II)コンボ(work2Combo)を未選択状態にする。
            getWork2Combo().clearSelection();
        }

    }

    /**
     * 「日常生活活動導加算の有効状態変更」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void normalLife2ActionPerformed(ActionEvent e) throws Exception {
        // ※日常生活活動導加算のチェック有無に応じてコンボの有効状態を変更
        if (getNormalLife2().isSelected()) {
            // 日常生活活動導加算チェック(normalLife2)が選択されている場合
            // 日常生活活動導加算コンボ(normalLife2Combo)を有効にする。
            setState_VALID_NORMAL_LIFE2();
            // 日常生活活動導加算コンボ(normalLife2Combo)の1つ目の項目を選択する。
            getNormalLife2Combo().setSelectedIndex(0);
        } else {
            // 日常生活活動導加算チェック(normalLife2)が選択されていない場合
            // 日常生活活動導加算コンボ(normalLife2Combo)を無効にする。
            setState_INVALID_NORMAL_LIFE2();
            // 日常生活活動導加算コンボ(normalLife2Combo)を未選択状態にする。
            getNormalLife2Combo().clearSelection();
        }
    }

    /**
     * 「言語聴覚療法Ｉの有効状態変更」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void languageTherapy1ActionPerformed(ActionEvent e)
            throws Exception {
        // ※言語聴覚療法Ｉのチェック有無に応じてコンボの有効状態を変更
        if (getLanguageTherapy1().isSelected()) {
            // 言語聴覚療法Ｉチェック(languageTherapy1)が選択されている場合
            // 言語聴覚療法Ｉコンボ(languageTherapy1Combo)を有効にする。
            setState_VALID_LANGUAGE_THERAPY1();
            // 言語聴覚療法Ｉコンボ(languageTherapy1Combo)の1つ目の項目を選択する。
            getLanguageTherapy1Combo().setSelectedIndex(0);
        } else {
            // 言語聴覚療法Ｉチェック(languageTherapy1)が選択されていない場合
            // 言語聴覚療法Ｉコンボ(languageTherapy1Combo)を無効にする。
            setState_INVALID_LANGUAGE_THERAPY1();
            // 言語聴覚療法Ｉコンボ(languageTherapy1Combo)を未選択状態にする。
            getLanguageTherapy1Combo().clearSelection();
        }

    }

    /**
     * 「言語聴覚療法ＩIの有効状態変更」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void languageTherapy2ActionPerformed(ActionEvent e)
            throws Exception {
        // ※言語聴覚療法ＩIのチェック有無に応じてコンボの有効状態を変更
        if (getLanguageTherapy2().isSelected()) {
            // 言語聴覚療法ＩIチェック(languageTherapy2)が選択されている場合
            // 言語聴覚療法ＩIコンボ(languageTherapy2Combo)を有効にする。
            setState_VALID_LANGUAGE_THERAPY2();
            // 言語聴覚療法ＩIコンボ(languageTherapy2Combo)の1つ目の項目を選択する。
            getLanguageTherapy2Combo().setSelectedIndex(0);
        } else {
            // 言語聴覚療法ＩIチェック(languageTherapy2)が選択されていない場合
            // 言語聴覚療法ＩIコンボ(languageTherapy2Combo)を無効にする。
            setState_INVALID_LANGUAGE_THERAPY2();
            // 言語聴覚療法ＩIコンボ(languageTherapy2Combo)を未選択状態にする。
            getLanguageTherapy2Combo().clearSelection();
        }

    }

    /**
     * 「言語聴覚(I)の有効状態変更」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void language1ActionPerformed(ActionEvent e) throws Exception {
        // ※言語聴覚(I)のチェック有無に応じてコンボの有効状態を変更
        if (getLanguage1().isSelected()) {
            // 言語聴覚(I)チェック(language1)が選択されている場合
            // 言語聴覚(I)コンボ(language1Combo)を有効にする。
            setState_VALID_LANGUAGE1();
            // 言語聴覚（I）コンボ(language1Combo)の1つ目の項目を選択する。
            getLanguage1Combo().setSelectedIndex(0);
        } else {
            // 言語聴覚(I)チェック(language1)が選択されていない場合
            // 言語聴覚(I)コンボ(language1Combo)を無効にする。
            setState_INVALID_LANGUAGE1();
            // 言語聴覚(I)コンボ(language1Combo)を未選択状態にする。
            getLanguage1Combo().clearSelection();
        }

    }

    /**
     * 「言語聴覚(II)の有効状態変更」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void language2ActionPerformed(ActionEvent e) throws Exception {
        // ※言語聴覚(II)のチェック有無に応じてコンボの有効状態を変更
        if (getLanguage2().isSelected()) {
            // 言語聴覚(II)チェック(language2)が選択されている場合
            // 言語聴覚(II)コンボ(language2Combo)を有効にする。
            setState_VALID_LANGUAGE2();
            // 言語聴覚（II）コンボ(language2Combo)の1つ目の項目を選択する。
            getLanguage2Combo().setSelectedIndex(0);
        } else {
            // 言語聴覚(II)チェック(language2)が選択されていない場合
            // 言語聴覚(II)コンボ(language2Combo)を無効にする。
            setState_INVALID_LANGUAGE2();
            // 言語聴覚(II)コンボ(language2Combo)を未選択状態にする。
            getLanguage2Combo().clearSelection();
        }

    }

    public static void main(String[] args) {
        // デフォルトデバッグ起動
        ACFrame.getInstance().setFrameEventProcesser(
                new QkanFrameEventProcesser());
        QkanCommon.debugInitialize();
        VRMap param = new VRHashMap();
        // paramに渡りパラメタを詰めて実行することで、簡易デバッグが可能です。
        ACFrame.debugStart(new ACAffairInfo(QS001028.class.getName(), param));
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

        setAffairTitle("QS001028");
        
        // ※コンボアイテムの設定
        // ※準備
        // コンボアイテム設定用のレコード comboItemMap を生成する。
        VRMap comboItemMap = new VRHashMap();

        // ※食事提供
        // コードマスタデータよりCODE_ID：109（理学療法(I)）を取得する。
        // 取得した値を、comboItemMapの KEY : 109 の VALUE として設定する。
        VRList codes = QkanCommon.getArrayFromMasterCode(109, "3010114");
        ACBindUtilities.copyBindPath(codes, "CONTENT_KEY", "3010115");
        ACBindUtilities.copyBindPath(codes, "CONTENT_KEY", "3010116");
        ACBindUtilities.copyBindPath(codes, "CONTENT_KEY", "3010117");
        ACBindUtilities.copyBindPath(codes, "CONTENT_KEY", "3010118");
        ACBindUtilities.copyBindPath(codes, "CONTENT_KEY", "3010119");
        ACBindUtilities.copyBindPath(codes, "CONTENT_KEY", "3010120");
        ACBindUtilities.copyBindPath(codes, "CONTENT_KEY", "3010121");
        ACBindUtilities.copyBindPath(codes, "CONTENT_KEY", "3010122");
        ACBindUtilities.copyBindPath(codes, "CONTENT_KEY", "3010125");
        ACBindUtilities.copyBindPath(codes, "CONTENT_KEY", "3010126");
        ACBindUtilities.copyBindPath(codes, "CONTENT_KEY", "3010127");
        ACBindUtilities.copyBindPath(codes, "CONTENT_KEY", "3010128");
        ACBindUtilities.copyBindPath(codes, "CONTENT_KEY", "3010129");
        ACBindUtilities.copyBindPath(codes, "CONTENT_KEY", "3010132");
        ACBindUtilities.copyBindPath(codes, "CONTENT_KEY", "3010133");
        ACBindUtilities.copyBindPath(codes, "CONTENT_KEY", "3010134");
        ACBindUtilities.copyBindPath(codes, "CONTENT_KEY", "3010135");
        comboItemMap.setData("109", codes);
        // ※コンボアイテムの設定
        // 自身(specificConsultationFeePattern)にcomboItemMapに設定する。
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
            // 「初期入院診療管理・無効」状態にする。
            setState_INVALID_BEGINNIGN_GUIDANCE();
            break;
        }
        switch (systemServiceKindDetail) {
        // 引数systemServiceKindDetailの値が以下の老人性認知症疾患療養病棟サービスの場合
        case 12303:
        case 12313:
        // ・12303：短期入所療養介護(老人性認知症疾患療養病棟を有する病院)
        case 15303:
        case 15313:
            // ・15303：介護療養型医療施設(老人性認知症疾患療養病棟を有する病院)
            // 「老人性認知症疾患療養病棟」状態にする。
            setState_OLD_COGNITIVE_WARD();
            break;
        }

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
        // 理学療法（ＩＩＩ）コンボ(scienceTherapy3Combo)が選択されていれば、理学療法（ＩＩＩ）チェック(scienceTherapy3)を選択する。
        getScienceTherapy3()
                .setSelected(getScienceTherapy3Combo().isSelected());
        if(getScienceTherapy3().isSelected()){
            setState_VALID_SCIENCE_THERAPY3();
        }
        // 理学療法（ＩＶ）コンボ(scienceTherapy4Combo)が選択されていれば、理学療法（ＩＶ）チェック(scienceTherapy4)を選択する。
        getScienceTherapy4()
                .setSelected(getScienceTherapy4Combo().isSelected());
        if(getScienceTherapy4().isSelected()){
            setState_VALID_SCIENCE_THERAPY4();
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
        // 理学（ＩＩＩ）コンボ(science3Combo)が選択されていれば、理学（ＩＩＩ）チェック(science3)を選択する。
        getScience3().setSelected(getScience3Combo().isSelected());
        if(getScience3().isSelected()){
            setState_VALID_SCIENCE3();
        }
        // 理学（ＩＶ）コンボ(science4Combo)が選択されていれば、理学（ＩＶ）チェック(science4)を選択する。
        getScience4().setSelected(getScience4Combo().isSelected());
        if(getScience4().isSelected()){
            setState_VALID_SCIENCE4();
        }
        // 日常生活活動訓練加算コンボ(normalLifeCombo)が選択されていれば、日常生活活動訓練加算チェック(normalLife)を選択する。
        getNormalLife().setSelected(getNormalLifeCombo().isSelected());
        if(getNormalLife().isSelected()){
            setState_VALID_NORMAL_LIFE_();
        }
        // 作業療法Iコンボ(workTherapy1Combo)が選択されていれば、作業療法Iチェック(workTherapy1)を選択する。
        getWorkTherapy1().setSelected(getWorkTherapy1Combo().isSelected());
        if(getWorkTherapy1().isSelected()){
            setState_VALID_WORK_THERAPY1();
        }
        // 作業療法IIコンボ(workTherapy2Combo)が選択されていれば、作業療法IIチェック(workTherapy2)を選択する。
        getWorkTherapy2().setSelected(getWorkTherapy2Combo().isSelected());
        if(getWorkTherapy2().isSelected()){
            setState_VALID_WORK_THERAPY2();
        }
        // 作業(I)コンボ(work1Combo)が選択されていれば、作業(I)チェック(work1)を選択する。
        getWork1().setSelected(getWork1Combo().isSelected());
        if(getWork1().isSelected()){
            setState_VALID_WORK1();
        }
        // 作業(II)コンボ(work2Combo)が選択されていれば、作業(II)チェック(work2)を選択する。
        getWork2().setSelected(getWork2Combo().isSelected());
        if(getWork2().isSelected()){
            setState_VALID_WORK2();
        }
        // 日常生活活動導加算コンボ(normalLife2Combo)が選択されていれば、日常生活活動導加算チェック(normalLife2)を選択する。
        getNormalLife2().setSelected(getNormalLife2Combo().isSelected());
        if(getNormalLife2().isSelected()){
            setState_VALID_NORMAL_LIFE2();
        }
        // 言語聴覚療法Ｉコンボ(languageTherapy1Combo)が選択されていれば、言語聴覚療法Ｉチェック(languageTherapy1)を選択する。
        getLanguageTherapy1().setSelected(
                getLanguageTherapy1Combo().isSelected());
        if(getLanguageTherapy1().isSelected()){
            setState_VALID_LANGUAGE_THERAPY1();
        }
        // 言語聴覚療法ＩIコンボ(languageTherapy2Combo)が選択されていれば、言語聴覚療法ＩIチェック(languageTherapy2)を選択する。
        getLanguageTherapy2().setSelected(
                getLanguageTherapy2Combo().isSelected());
        if(getLanguageTherapy2().isSelected()){
            setState_VALID_LANGUAGE_THERAPY2();
        }
        // 言語聴覚(I)コンボ(language1Combo)が選択されていれば、言語聴覚(I)チェック(language1)を選択する。
        getLanguage1().setSelected(getLanguage1Combo().isSelected());
        if(getLanguage1().isSelected()){
            setState_VALID_LANGUAGE1();
        }
        // 言語聴覚(II)コンボ(language2Combo)が選択されていれば、言語聴覚(II)チェック(language2)を選択する。
        getLanguage2().setSelected(getLanguage2Combo().isSelected());
        if(getLanguage2().isSelected()){
            setState_VALID_LANGUAGE2();
        }

        // 画面を表示する。
        setVisible(true);

        return getApplied();
    }

    public static String[] getTargetBindPathes(int systemServiceKindDetail)
            throws Exception {
        switch (systemServiceKindDetail) {
        // 引数systemServiceKindDetailの値が以下の短期入所療養介護サービスの場合
        case 12201://短期入所療養介護(老健)
        case 12211:
        case 12301:// 短期入所療養介護（病院療養）
        case 12311:
        case 12302:// 短期入所療養介護（診療所療養）
        case 12312:
        case 12304://短期入所療養介護(基準適合診療所)
        case 12314:
            return new String[] { "3010101", "3010102", "3010104", "3010105",
                    "3010106", "3010107", "3010108", "3010109","3010110",
                    "3010111", "3010112", "3010113", "3010114", "3010115",
                    "3010116", "3010117", "3010118", "3010119", "3010120",
                    "3010121", "3010122", "3010123", "3010124", "3010125",
                    "3010126", "3010127", "3010128", "3010129", "3010130",
                    "3010131", "3010132", "3010133", "3010134", "3010135",
                    "3010136", "3010137", "3010138", };
        // 引数systemServiceKindDetailの値が以下の短期入所療養介護かつ老人性認知症疾患療養病棟サービスの場合
        case 12303:// 短期入所療養介護(老人性認知症疾患療養病棟を有する病院)
        case 12313:
            return new String[] { "3010101", "3010102", "3010104", "3010137",
                    "3010138", };
        // 引数systemServiceKindDetailの値が以下の老人性認知症疾患療養病棟サービスの場合
        case 15303:// 介護療養型医療施設(老人性認知症疾患療養病棟を有する病院)
        case 15313:
            return new String[] { "3010101", "3010102", "3010103", "3010104",
                    "3010137", "3010138", };
        default:
            return new String[] { "3010101", "3010102", "3010103", "3010104",
                    "3010105", "3010106", "3010107", "3010108","3010109",
                    "3010110", "3010111", "3010112", "3010113", "3010114",
                    "3010115", "3010116", "3010117", "3010118", "3010119",
                    "3010120", "3010121", "3010122", "3010123", "3010124",
                    "3010125", "3010126", "3010127", "3010128", "3010129",
                    "3010130", "3010131", "3010132", "3010133", "3010134",
                    "3010135", "3010136", "3010137", "3010138", };
        }
    }

}
