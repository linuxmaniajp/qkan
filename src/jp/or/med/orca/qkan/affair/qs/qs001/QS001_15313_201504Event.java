
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
 * 作成日: 2015/02/19  日本コンピューター株式会社 樋口　雅彦 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 予定管理 (S)
 * プロセス サービス予定 (001)
 * プログラム サービスパターン介護療養型医療施設（認知症） (QS001_15313_201504)
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
 * サービスパターン介護療養型医療施設（認知症）イベント定義(QS001_15313_201504) 
 */
public abstract class QS001_15313_201504Event extends QS001_15313_201504State implements QS001Service {
  /**
   * コンストラクタです。
   */
  public QS001_15313_201504Event(){
    addEvents();
  }
  /**
   * イベント発生条件を定義します。
   */
  protected void addEvents() {
    getMedicalFacilityCognitiveHospitalInstitutionDivisionRadio().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                medicalFacilityCognitiveHospitalInstitutionDivisionRadioActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getMedicalFacilityCognitiveHospitalConsultationFee().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                medicalFacilityCognitiveHospitalConsultationFeeActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getMedicalFacilityCognitiveHospitalDinnerOffer().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                medicalFacilityCognitiveHospitalDinnerOfferActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getHospitalDivisionRadio().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                hospitalDivisionRadioActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getMedicalFacilityCognitiveHospitalSubstraction().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                medicalFacilityCognitiveHospitalSubstractionActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getMedicalFacilityCognitiveHospitalNutritionRadio().addListSelectionListener(new ListSelectionListener(){
        private boolean lockFlag = false;
        public void valueChanged(ListSelectionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                medicalFacilityCognitiveHospitalNutritionRadioSelectionChanged(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getMedicalFacilityCognitiveHospitalOralSwitchRadio().addListSelectionListener(new ListSelectionListener(){
        private boolean lockFlag = false;
        public void valueChanged(ListSelectionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                medicalFacilityCognitiveHospitalOralSwitchRadioSelectionChanged(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getOralMaintenanceAdd().addListSelectionListener(new ListSelectionListener(){
        private boolean lockFlag = false;
        public void valueChanged(ListSelectionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                oralMaintenanceAddSelectionChanged(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getMedicalFacilityCognitiveHospitalMedicalExaminationRadio().addListSelectionListener(new ListSelectionListener(){
        private boolean lockFlag = false;
        public void valueChanged(ListSelectionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                medicalFacilityCognitiveHospitalMedicalExaminationRadioSelectionChanged(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getMedicalFacilityCognitiveHospitalStayRadio().addListSelectionListener(new ListSelectionListener(){
        private boolean lockFlag = false;
        public void valueChanged(ListSelectionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                medicalFacilityCognitiveHospitalStayRadioSelectionChanged(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getOralKeepStructureAddRadioGroup().addListSelectionListener(new ListSelectionListener(){
        private boolean lockFlag = false;
        public void valueChanged(ListSelectionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                oralKeepStructureAddRadioGroupSelectionChanged(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });

  }
  //コンポーネントイベント

  /**
   * 「施設区分選択時イベント」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void medicalFacilityCognitiveHospitalInstitutionDivisionRadioActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「特定診療費の設定」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void medicalFacilityCognitiveHospitalConsultationFeeActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「食事提供選択」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void medicalFacilityCognitiveHospitalDinnerOfferActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「病院区分」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void hospitalDivisionRadioActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「人員減算選択」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void medicalFacilityCognitiveHospitalSubstractionActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「栄養マネジメント加算の変更」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void medicalFacilityCognitiveHospitalNutritionRadioSelectionChanged(ListSelectionEvent e) throws Exception;

  /**
   * 「経口移行加算の変更」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void medicalFacilityCognitiveHospitalOralSwitchRadioSelectionChanged(ListSelectionEvent e) throws Exception;

  /**
   * 「経口維持加算に伴う画面状態設定」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void oralMaintenanceAddSelectionChanged(ListSelectionEvent e) throws Exception;

  /**
   * 「他科受信変更時」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void medicalFacilityCognitiveHospitalMedicalExaminationRadioSelectionChanged(ListSelectionEvent e) throws Exception;

  /**
   * 「外泊加算変更時」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void medicalFacilityCognitiveHospitalStayRadioSelectionChanged(ListSelectionEvent e) throws Exception;

  /**
   * 「口腔機能維持管理体制加算の変更」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void oralKeepStructureAddRadioGroupSelectionChanged(ListSelectionEvent e) throws Exception;

  //変数定義

  public static final int SYSTEM_SERVICE_KIND_DETAIL = 15313;
  private boolean invalidUnitCareProvider;
  private boolean useHumanCostDown;
  //getter/setter

  /**
   * invalidUnitCareProviderを返します。
   * @return invalidUnitCareProvider
   */
  protected boolean getInvalidUnitCareProvider(){
    return invalidUnitCareProvider;
  }
  /**
   * invalidUnitCareProviderを設定します。
   * @param invalidUnitCareProvider invalidUnitCareProvider
   */
  protected void setInvalidUnitCareProvider(boolean invalidUnitCareProvider){
    this.invalidUnitCareProvider = invalidUnitCareProvider;
  }

  /**
   * useHumanCostDownを返します。
   * @return useHumanCostDown
   */
  protected boolean getUseHumanCostDown(){
    return useHumanCostDown;
  }
  /**
   * useHumanCostDownを設定します。
   * @param useHumanCostDown useHumanCostDown
   */
  protected void setUseHumanCostDown(boolean useHumanCostDown){
    this.useHumanCostDown = useHumanCostDown;
  }

  //内部関数

  /**
   * 「初期化」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   *
   */
  public abstract void initialize() throws Exception;

  /**
   * 「事業所コンボ変更時関数」に関する処理を行ないます。
   *
   * @param provider VRMap
   * @throws Exception 処理例外
   *
   */
  public abstract void providerSelected(VRMap provider) throws Exception;

  /**
   * 「入力内容の不備を検査」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   * @return VRMap
   */
  public abstract VRMap getValidData() throws Exception;

  /**
   * 「事業所情報の必要性を取得」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   * @return boolean
   */
  public abstract boolean isUseProvider() throws Exception;

  /**
   * 「開始時刻入力用のコンボ取得」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   * @return ACComboBox
   */
  public abstract ACComboBox getBeginTimeCombo() throws Exception;

  /**
   * 「終了時刻入力用のコンボ取得」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   * @return ACComboBox
   */
  public abstract ACComboBox getEndTimeCombo() throws Exception;

  /**
   * 「食事費用を取得」に関する処理を行ないます。
   *
   * @param meatType int
   * @throws Exception 処理例外
   * @return String
   */
  public abstract String getMeatCost(int meatType) throws Exception;

  /**
   * 「画面状態制御」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   *
   */
  public abstract void changeState() throws Exception;

}
