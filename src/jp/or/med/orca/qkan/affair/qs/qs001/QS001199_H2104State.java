
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
 * 作成日: 2009/04/30  日本コンピューター株式会社 田中　統蔵 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 予定管理 (S)
 * プロセス 特定診療費画面 (001)
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
/**
 * 特定診療費画面状態定義(QS001199_H2104) 
 */
public class QS001199_H2104State extends QS001199_H2104Design {
  /**
   * コンストラクタです。
   */
  public QS001199_H2104State(){
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
   * 「集団コミュニケーション・非表示」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_NOT_DISPLAY_GROUP() throws Exception {

        getGroupCommunication().setVisible(false);

  }

  /**
   * 「集団コミュニケーション・表示」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_DISPLAY_GROUP() throws Exception {

        getGroupCommunication().setVisible(true);

  }

  /**
   * 「認知症短期集中リハビリ加算・非表示」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_NOT_DISPLAY_DEMENTIA_SHORT_REHA() throws Exception {

        getDementiaShortRehabilitation().setVisible(false);

  }

  /**
   * 「認知症短期集中リハビリ加算・表示」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_DISPLAY_DEMENTIA_SHORT_REHA() throws Exception {

        getDementiaShortRehabilitation().setVisible(true);

  }

  /**
   * 「重度療養管理・非表示」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_NOT_DISPLAY_HEAVY_RECUPERATE_GUIDANCE() throws Exception {

        getHeavyRecuperateGuidanceManagement().setVisible(false);

  }

  /**
   * 「重度療養管理・表示」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_DISPLAY_HEAVY_RECUPERATE_GUIDANCE() throws Exception {

        getHeavyRecuperateGuidanceManagement().setVisible(true);

  }

  /**
   * 「介護療養型医療施設（認知症）・表示」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_DISPLAY_MEDICAL_OLD_COGNITIVE_STATE() throws Exception {

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

        if(getGroupCommunication().getParent()!=null){
          getGroupCommunication().getParent().remove(getGroupCommunication());
        }

        getDementiaShortRehabilitation().setVisible(true);

        if(getLanguageTherapy1Conteiner().getParent()!=null){
          getLanguageTherapy1Conteiner().getParent().remove(getLanguageTherapy1Conteiner());
        }

        if(getLanguage1Conteiner().getParent()!=null){
          getLanguage1Conteiner().getParent().remove(getLanguage1Conteiner());
        }

        if(getRehabilitationSystem3().getParent()!=null){
          getRehabilitationSystem3().getParent().remove(getRehabilitationSystem3());
        }

        if(getDinner().getParent()!=null){
          getDinner().getParent().remove(getDinner());
        }

        if(getConcentratedRehabilitation().getParent()!=null){
          getConcentratedRehabilitation().getParent().remove(getConcentratedRehabilitation());
        }

  }

}
