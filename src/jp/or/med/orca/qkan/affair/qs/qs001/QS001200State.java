
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
 * 作成日: 2010/11/05  日本コンピューター株式会社 樋口　雅彦 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 予定管理 (S)
 * プロセス 特別療養費画面 (001)
 * プログラム 特別療養費画面 (QS001200)
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
 * 特別療養費画面状態定義(QS001200) 
 */
public class QS001200State extends QS001200Design {
  /**
   * コンストラクタです。
   */
  public QS001200State(){
  }

  /**
   * 「初期入所診療管理・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_BEGINNIGN_GUIDANCE() throws Exception {

        if(getBeginningGuidanceManagement().getParent()!=null){
          getBeginningGuidanceManagement().getParent().remove(getBeginningGuidanceManagement());
        }

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
   * 「老人保健施設関連」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_HEALTH_FACILITIES_WARD() throws Exception {

        getInfectionGuidanceManagement().setVisible(true);

        getBedGuidanceManagement().setVisible(true);

        getBeginningGuidanceManagement().setVisible(true);

        getHeavyRecuperateGuidanceManagement().setVisible(true);

        getParticularInstitutionManagment().setVisible(true);

        getParticularInstitutionManagmentPrivateRoom().setVisible(true);

        getParticularInstitutionManagmentPrivateRoom2().setVisible(true);

        getHeavySkinManegement().setVisible(true);

        getMedicineManegementLeading().setVisible(true);

        getRehabilitationManegement().setVisible(true);

        getSpecialMedicineManagementLeading().setVisible(true);

        getMedicalScienceInfo().setVisible(true);

        getLanguageTherapy1Combo().setVisible(true);

        getLanguage1Combo().setVisible(true);

        getMindTherapy().setVisible(true);

        getCognitive().setVisible(true);

        getEtcFrame().setVisible(true);

        getRehabilitationSystemCombo().setVisible(true);

  }

  /**
   * 「リハビリテーション指導管理・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_REHABILITATION_MANEGEMENT() throws Exception {

        if(getRehabilitationManegement().getParent()!=null){
          getRehabilitationManegement().getParent().remove(getRehabilitationManegement());
        }

  }

  /**
   * 「重度療養管理・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_HEAVY_RECUPERATE() throws Exception {

        if(getHeavyRecuperateGuidanceManagement().getParent()!=null){
          getHeavyRecuperateGuidanceManagement().getParent().remove(getHeavyRecuperateGuidanceManagement());
        }

  }

  /**
   * 「リハビリ体制強化加算・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_RIHABIRI_SYSTEM() throws Exception {

        getRehabilitationSystemCombo().setEnabled(false);

  }

  /**
   * 「リハビリ体制強化加算・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_RIHABIRI_SYSTEM() throws Exception {

        getRehabilitationSystemCombo().setEnabled(true);

  }

}
