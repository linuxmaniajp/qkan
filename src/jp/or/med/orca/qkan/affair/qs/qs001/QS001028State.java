
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
 * 作成日: 2006/03/05  日本コンピューター株式会社 田中　統蔵 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 予定管理 (S)
 * プロセス 特定診療費画面 (001)
 * プログラム 特定診療費画面 (QS001028)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
/**
 * 特定診療費画面状態定義(QS001028) 
 */
public class QS001028State extends QS001028Design {
  /**
   * コンストラクタです。
   */
  public QS001028State(){
  }

  /**
   * 「老人性認知症疾患療養病棟」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_OLD_COGNITIVE_WARD() throws Exception {

        if(getParticularInstitutionManagment().getParent()!=null){
          getParticularInstitutionManagment().getParent().remove(getParticularInstitutionManagment());
        }

        if(getParticularInstitutionManagmentPrivateRoom().getParent()!=null){
          getParticularInstitutionManagmentPrivateRoom().getParent().remove(getParticularInstitutionManagmentPrivateRoom());
        }

        if(getParticularInstitutionManagmentPrivateRoom2().getParent()!=null){
          getParticularInstitutionManagmentPrivateRoom2().getParent().remove(getParticularInstitutionManagmentPrivateRoom2());
        }

        if(getHeavySkinManegement().getParent()!=null){
          getHeavySkinManegement().getParent().remove(getHeavySkinManegement());
        }

        if(getCareNutritionDinnerLeading().getParent()!=null){
          getCareNutritionDinnerLeading().getParent().remove(getCareNutritionDinnerLeading());
        }

        if(getMedicineManegementLeading().getParent()!=null){
          getMedicineManegementLeading().getParent().remove(getMedicineManegementLeading());
        }

        if(getSpecialMedicineManagementLeading().getParent()!=null){
          getSpecialMedicineManagementLeading().getParent().remove(getSpecialMedicineManagementLeading());
        }

        if(getMedicalScienceInfo1().getParent()!=null){
          getMedicalScienceInfo1().getParent().remove(getMedicalScienceInfo1());
        }

        if(getMedicalScienceInfo2().getParent()!=null){
          getMedicalScienceInfo2().getParent().remove(getMedicalScienceInfo2());
        }

        if(getScienceTherapy().getParent()!=null){
          getScienceTherapy().getParent().remove(getScienceTherapy());
        }

        if(getWorkTherapyFrame().getParent()!=null){
          getWorkTherapyFrame().getParent().remove(getWorkTherapyFrame());
        }

        if(getEtcFrame().getParent()!=null){
          getEtcFrame().getParent().remove(getEtcFrame());
        }

  }

  /**
   * 「初期入院診療管理・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_BEGINNIGN_GUIDANCE() throws Exception {

        if(getBeginningGuidanceManagement().getParent()!=null){
          getBeginningGuidanceManagement().getParent().remove(getBeginningGuidanceManagement());
        }

  }

  /**
   * 「理学療法（Ｉ）・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_SCIENCE_THERAPY1() throws Exception {

        getScienceTherapy1Combo().setEnabled(false);

  }

  /**
   * 「理学療法（Ｉ）・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_SCIENCE_THERAPY1() throws Exception {

        getScienceTherapy1Combo().setEnabled(true);

  }

  /**
   * 「理学療法（ＩＩ）・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_SCIENCE_THERAPY2() throws Exception {

        getScienceTherapy2Combo().setEnabled(false);

  }

  /**
   * 「理学療法（ＩＩ）・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_SCIENCE_THERAPY2() throws Exception {

        getScienceTherapy2Combo().setEnabled(true);

  }

  /**
   * 「理学療法（ＩＩＩ）・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_SCIENCE_THERAPY3() throws Exception {

        getScienceTherapy3Combo().setEnabled(false);

  }

  /**
   * 「理学療法（ＩＩＩ）・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_SCIENCE_THERAPY3() throws Exception {

        getScienceTherapy3Combo().setEnabled(true);

  }

  /**
   * 「理学療法（ＩＶ）・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_SCIENCE_THERAPY4() throws Exception {

        getScienceTherapy4Combo().setEnabled(false);

  }

  /**
   * 「理学療法（ＩＶ）・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_SCIENCE_THERAPY4() throws Exception {

        getScienceTherapy4Combo().setEnabled(true);

  }

  /**
   * 「理学（Ｉ）・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_SCIENCE1() throws Exception {

        getScience1Combo().setEnabled(false);

  }

  /**
   * 「理学（Ｉ）・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_SCIENCE1() throws Exception {

        getScience1Combo().setEnabled(true);

  }

  /**
   * 「理学（ＩＩ）・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_SCIENCE2() throws Exception {

        getScience2Combo().setEnabled(false);

  }

  /**
   * 「理学（ＩＩ）・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_SCIENCE2() throws Exception {

        getScience2Combo().setEnabled(true);

  }

  /**
   * 「理学（ＩＩＩ）・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_SCIENCE3() throws Exception {

        getScience3Combo().setEnabled(false);

  }

  /**
   * 「理学（ＩＩＩ）・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_SCIENCE3() throws Exception {

        getScience3Combo().setEnabled(true);

  }

  /**
   * 「理学（ＩＶ）・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_SCIENCE4() throws Exception {

        getScience4Combo().setEnabled(false);

  }

  /**
   * 「理学（ＩＶ）・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_SCIENCE4() throws Exception {

        getScience4Combo().setEnabled(true);

  }

  /**
   * 「日常生活活動訓練加算・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_NORMAL_LIFE_() throws Exception {

        getNormalLifeCombo().setEnabled(false);

  }

  /**
   * 「日常生活活動訓練加算・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_NORMAL_LIFE_() throws Exception {

        getNormalLifeCombo().setEnabled(true);

  }

  /**
   * 「作業療法I・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_WORK_THERAPY1() throws Exception {

        getWorkTherapy1Combo().setEnabled(false);

  }

  /**
   * 「作業療法I・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_WORK_THERAPY1() throws Exception {

        getWorkTherapy1Combo().setEnabled(true);

  }

  /**
   * 「作業療法II・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_WORK_THERAPY2() throws Exception {

        getWorkTherapy2Combo().setEnabled(false);

  }

  /**
   * 「作業療法II・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_WORK_THERAPY2() throws Exception {

        getWorkTherapy2Combo().setEnabled(true);

  }

  /**
   * 「作業I・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_WORK1() throws Exception {

        getWork1Combo().setEnabled(false);

  }

  /**
   * 「作業I・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_WORK1() throws Exception {

        getWork1Combo().setEnabled(true);

  }

  /**
   * 「作業II・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_WORK2() throws Exception {

        getWork2Combo().setEnabled(false);

  }

  /**
   * 「作業II・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_WORK2() throws Exception {

        getWork2Combo().setEnabled(true);

  }

  /**
   * 「日常生活活動導加算・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_NORMAL_LIFE2() throws Exception {

        getNormalLife2Combo().setEnabled(false);

  }

  /**
   * 「日常生活活動導加算・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_NORMAL_LIFE2() throws Exception {

        getNormalLife2Combo().setEnabled(true);

  }

  /**
   * 「言語聴覚療法Ｉ・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_LANGUAGE_THERAPY1() throws Exception {

        getLanguageTherapy1Combo().setEnabled(false);

  }

  /**
   * 「言語聴覚療法Ｉ・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_LANGUAGE_THERAPY1() throws Exception {

        getLanguageTherapy1Combo().setEnabled(true);

  }

  /**
   * 「言語聴覚療法ＩＩ・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_LANGUAGE_THERAPY2() throws Exception {

        getLanguageTherapy2Combo().setEnabled(false);

  }

  /**
   * 「言語聴覚療法ＩＩ・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_LANGUAGE_THERAPY2() throws Exception {

        getLanguageTherapy2Combo().setEnabled(true);

  }

  /**
   * 「言語聴覚(I)・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_LANGUAGE1() throws Exception {

        getLanguage1Combo().setEnabled(false);

  }

  /**
   * 「言語聴覚(I)・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_LANGUAGE1() throws Exception {

        getLanguage1Combo().setEnabled(true);

  }

  /**
   * 「言語聴覚(II)・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_LANGUAGE2() throws Exception {

        getLanguage2Combo().setEnabled(false);

  }

  /**
   * 「言語聴覚(II)・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_LANGUAGE2() throws Exception {

        getLanguage2Combo().setEnabled(true);

  }

}
