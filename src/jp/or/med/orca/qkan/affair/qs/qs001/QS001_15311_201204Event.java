
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
 * 作成日: 2012/02/16  日本コンピューター株式会社 樋口　雅彦 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 予定管理 (S)
 * プロセス サービス予定 (001)
 * プログラム サービスパターン介護療養型医療施設（病院） (QS001_15311_201204)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import jp.nichicom.ac.ACCommon;
import jp.nichicom.ac.component.ACComboBox;
import jp.nichicom.vr.util.VRMap;

/**
 * サービスパターン介護療養型医療施設（病院）イベント定義(QS001_15311_201204) 
 */
public abstract class QS001_15311_201204Event extends QS001_15311_201204State implements QS001Service {
  /**
   * コンストラクタです。
   */
  public QS001_15311_201204Event(){
    addEvents();
  }
  /**
   * イベント発生条件を定義します。
   */
  protected void addEvents() {
    getMedicalFacilityHospitalInstitutionDivisionRadio().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                medicalFacilityHospitalInstitutionDivisionRadioActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getMedicalFacilityHospitalSubstraction().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                medicalFacilityHospitalSubstractionActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getMedicalFacilityHospitalConsultationFee().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                medicalFacilityHospitalConsultationFeeActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getMedicalFacilityDinnerOffer().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                medicalFacilityDinnerOfferActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getMedicalFacilityHospitalOralSwitchRadio().addListSelectionListener(new ListSelectionListener(){
        private boolean lockFlag = false;
        public void valueChanged(ListSelectionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                medicalFacilityHospitalOralSwitchRadioSelectionChanged(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getOralMaintenanceRadio().addListSelectionListener(new ListSelectionListener(){
        private boolean lockFlag = false;
        public void valueChanged(ListSelectionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                oralMaintenanceRadioSelectionChanged(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getMedicalFacilityHospitalMedicalExaminationRadio().addListSelectionListener(new ListSelectionListener(){
        private boolean lockFlag = false;
        public void valueChanged(ListSelectionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                medicalFacilityHospitalMedicalExaminationRadioSelectionChanged(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getMedicalFacilityHospitalStayRadio().addListSelectionListener(new ListSelectionListener(){
        private boolean lockFlag = false;
        public void valueChanged(ListSelectionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                medicalFacilityHospitalStayRadioSelectionChanged(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getTrialHijoRadio().addListSelectionListener(new ListSelectionListener(){
        private boolean lockFlag = false;
        public void valueChanged(ListSelectionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                trialHijoRadioSelectionChanged(e);
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
  protected abstract void medicalFacilityHospitalInstitutionDivisionRadioActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「人員減算コンボ選択」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void medicalFacilityHospitalSubstractionActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「特定診療費の設定」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void medicalFacilityHospitalConsultationFeeActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「食事提供選択」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void medicalFacilityDinnerOfferActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「経口移行加算の変更」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void medicalFacilityHospitalOralSwitchRadioSelectionChanged(ListSelectionEvent e) throws Exception;

  /**
   * 「経口維持加算の変更」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void oralMaintenanceRadioSelectionChanged(ListSelectionEvent e) throws Exception;

  /**
   * 「他科受信の有無」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void medicalFacilityHospitalMedicalExaminationRadioSelectionChanged(ListSelectionEvent e) throws Exception;

  /**
   * 「外泊加算の有無」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void medicalFacilityHospitalStayRadioSelectionChanged(ListSelectionEvent e) throws Exception;

  /**
   * 「試行的退院サービス費の有無」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void trialHijoRadioSelectionChanged(ListSelectionEvent e) throws Exception;

  /**
   * 「口腔機能維持管理体制加算の変更」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void oralKeepStructureAddRadioGroupSelectionChanged(ListSelectionEvent e) throws Exception;

  //変数定義

  public static final int SYSTEM_SERVICE_KIND_DETAIL = 15311;
  private boolean unitCareFlag;
  private boolean personSubstraction;
  //getter/setter

  /**
   * unitCareFlagを返します。
   * @return unitCareFlag
   */
  protected boolean getUnitCareFlag(){
    return unitCareFlag;
  }
  /**
   * unitCareFlagを設定します。
   * @param unitCareFlag unitCareFlag
   */
  protected void setUnitCareFlag(boolean unitCareFlag){
    this.unitCareFlag = unitCareFlag;
  }

  /**
   * personSubstractionを返します。
   * @return personSubstraction
   */
  protected boolean getPersonSubstraction(){
    return personSubstraction;
  }
  /**
   * personSubstractionを設定します。
   * @param personSubstraction personSubstraction
   */
  protected void setPersonSubstraction(boolean personSubstraction){
    this.personSubstraction = personSubstraction;
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
   * 「人員配置区分制御処理」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   *
   */
  public abstract void changeStaffDivisionState() throws Exception;

  /**
   * 「画面制御」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   *
   */
  public abstract void checkState() throws Exception;

}
