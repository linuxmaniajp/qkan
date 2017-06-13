
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
 * 開発者: 上司　和善
 * 作成日: 2006/03/14  日本コンピューター株式会社 上司　和善 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 請求データ作成 (P)
 * プロセス 確認・修正 (004)
 * プログラム 明細書基本情報編集 (QP004)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qp.qp004;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import jp.nichicom.ac.ACCommon;
import jp.nichicom.ac.sql.ACPassiveKey;
import jp.nichicom.ac.util.adapter.ACTableModelAdapter;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.component.QkanDateTextField;

/**
 * 明細書基本情報編集イベント定義(QP004) 
 */
public abstract class QP004Event extends QP004SQL {
  /**
   * コンストラクタです。
   */
  public QP004Event(){
    addEvents();
  }
  /**
   * イベント発生条件を定義します。
   */
  protected void addEvents() {
    getUpdate().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                updateActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getDetail().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                detailActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getTekiyoTable().addListSelectionListener(new ListSelectionListener(){
        private boolean lockFlag = false;
        public void valueChanged(ListSelectionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                tekiyoTableSelectionChanged(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getSinryoTable().addListSelectionListener(new ListSelectionListener(){
        private boolean lockFlag = false;
        public void valueChanged(ListSelectionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                sinryoTableSelectionChanged(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getTekiyoTekiyoColumn().addCellEditorListener(new CellEditorListener(){
        private boolean lockFlag = false;
        public void editingStopped(ChangeEvent e) {
          cellEditing(e);
        }
        public void editingCanceled(ChangeEvent e) {
          cellEditing(e);
        }
        public void cellEditing(ChangeEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                tekiyoTekiyoColumnCellEditing(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getSinryoTekiyoColumn().addCellEditorListener(new CellEditorListener(){
        private boolean lockFlag = false;
        public void editingStopped(ChangeEvent e) {
          cellEditing(e);
        }
        public void editingCanceled(ChangeEvent e) {
          cellEditing(e);
        }
        public void cellEditing(ChangeEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                sinryoTekiyoColumnCellEditing(e);
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
   * 「DB登録」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void updateActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「詳細」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void detailActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「摘要欄説明を表示」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void tekiyoTableSelectionChanged(ListSelectionEvent e) throws Exception;

  /**
   * 「摘要欄説明を表示」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void sinryoTableSelectionChanged(ListSelectionEvent e) throws Exception;

  /**
   * 「変更フラグを立てる」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void tekiyoTekiyoColumnCellEditing(ChangeEvent e) throws Exception;

  /**
   * 「変更フラグを立てる」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void sinryoTekiyoColumnCellEditing(ChangeEvent e) throws Exception;

  //変数定義

  private ACPassiveKey PASSIVE_CHECK_KEY;
  public static final int FLAG_ON = 1;
  public static final int FLAG_OFF = 0;
  public static final Integer FLAG_START = new Integer(1);
  public static final Integer FLAG_END = new Integer(99);
  public static final int TEXT = 1;
  public static final int COMBO = 2;
  
   // 帳票様式
  
  
  public static final int CLAIM_STYLE_TYPE21 = 10211;
  public static final int CLAIM_STYLE_TYPE22	= 10212;
  public static final int CLAIM_STYLE_TYPE23	= 10213;	// 2016.7.8 add
  public static final int CLAIM_STYLE_TYPE31	= 10311;
  public static final int CLAIM_STYLE_TYPE32	= 10312;
  public static final int CLAIM_STYLE_TYPE41	= 10411;
  public static final int CLAIM_STYLE_TYPE42	= 10412;
  public static final int CLAIM_STYLE_TYPE51	= 10511;
  public static final int CLAIM_STYLE_TYPE52	= 10512;
  public static final int CLAIM_STYLE_TYPE61	= 10611;
  public static final int CLAIM_STYLE_TYPE62	= 10612;
  public static final int CLAIM_STYLE_TYPE63	= 10613;
  public static final int CLAIM_STYLE_TYPE64	= 10614;
  public static final int CLAIM_STYLE_TYPE65	= 10615;
  public static final int CLAIM_STYLE_TYPE66	= 10616;
  public static final int CLAIM_STYLE_TYPE67    = 10617;
  public static final int CLAIM_STYLE_TYPE8	= 10811;
  public static final int CLAIM_STYLE_TYPE9	= 10911;
  public static final int CLAIM_STYLE_TYPE10	= 11011;

  public static final int CATEGORY_NO2 = 2;
  public static final int CATEGORY_NO3 = 3;
  public static final int CATEGORY_NO5 = 5;
  public static final int CATEGORY_NO7 = 7;
  public static final int CATEGORY_NO18 = 18;
  
  // システムサービス種類コード(5桁)
  public static final String SYSTEM_SERVICE_KIND_CODE = "301021"; 
  public static final String SYSTEM_SERVICE_ITEM_CODE = "301022"; 
  public static final String SPECIAL_CLINIC_FLAG_CODE = "501009";
  public static final String TEKIYOU100_FLAG_CODE = "501023";
  
  public static final int HEAVY_RECUPERATION_MANAGEMENT = 35;
  private int patientId;
  private Date targetDate = new Date();
  private Date claimDate = new Date();
  private int listIndex;
  private String providerId;
  private int claimStyleType;
  private String insuredId;
  private int tableChangedFlg;
  public static final String FIRST_SUMMARY_MEMO = "下のサービスを選ぶと、摘要欄に記載する内容についての説明が表示されます。";
  private VRMap masterCodeData = new VRHashMap();
  private VRList claimListBasic = new VRArrayList();
  private VRList claimListDetail = new VRArrayList();
  private VRList claimListHideDetail = new VRArrayList();
  private VRList claimListSpecialClinic = new VRArrayList();
  private VRList claimListTotal = new VRArrayList();
  private VRList columnListDetail = new VRArrayList();
  private VRList columnListSpecialClinic = new VRArrayList();
  private VRList snapList = new VRArrayList();
  private ACTableModelAdapter tableModelDetail;
  private ACTableModelAdapter tableModelSpecialClinic;
  //getter/setter

  /**
   * PASSIVE_CHECK_KEYを返します。
   * @return PASSIVE_CHECK_KEY
   */
  protected ACPassiveKey getPASSIVE_CHECK_KEY(){
    return PASSIVE_CHECK_KEY;
  }
  /**
   * PASSIVE_CHECK_KEYを設定します。
   * @param PASSIVE_CHECK_KEY PASSIVE_CHECK_KEY
   */
  protected void setPASSIVE_CHECK_KEY(ACPassiveKey PASSIVE_CHECK_KEY){
    this.PASSIVE_CHECK_KEY = PASSIVE_CHECK_KEY;
  }

  /**
   * patientIdを返します。
   * @return patientId
   */
  protected int getPatientId(){
    return patientId;
  }
  /**
   * patientIdを設定します。
   * @param patientId patientId
   */
  protected void setPatientId(int patientId){
    this.patientId = patientId;
  }

  /**
   * targetDateを返します。
   * @return targetDate
   */
  protected Date getTargetDate(){
    return targetDate;
  }
  /**
   * targetDateを設定します。
   * @param targetDate targetDate
   */
  protected void setTargetDate(Date targetDate){
    this.targetDate = targetDate;
  }

  /**
   * claimDateを返します。
   * @return claimDate
   */
  protected Date getClaimDate(){
    return claimDate;
  }
  /**
   * claimDateを設定します。
   * @param claimDate claimDate
   */
  protected void setClaimDate(Date claimDate){
    this.claimDate = claimDate;
  }

  /**
   * listIndexを返します。
   * @return listIndex
   */
  protected int getListIndex(){
    return listIndex;
  }
  /**
   * listIndexを設定します。
   * @param listIndex listIndex
   */
  protected void setListIndex(int listIndex){
    this.listIndex = listIndex;
  }

  /**
   * providerIdを返します。
   * @return providerId
   */
  protected String getProviderId(){
    return providerId;
  }
  /**
   * providerIdを設定します。
   * @param providerId providerId
   */
  protected void setProviderId(String providerId){
    this.providerId = providerId;
  }

  /**
   * claimStyleTypeを返します。
   * @return claimStyleType
   */
  protected int getClaimStyleType(){
    return claimStyleType;
  }
  /**
   * claimStyleTypeを設定します。
   * @param claimStyleType claimStyleType
   */
  protected void setClaimStyleType(int claimStyleType){
    this.claimStyleType = claimStyleType;
  }

  /**
   * insuredIdを返します。
   * @return insuredId
   */
  protected String getInsuredId(){
    return insuredId;
  }
  /**
   * insuredIdを設定します。
   * @param insuredId insuredId
   */
  protected void setInsuredId(String insuredId){
    this.insuredId = insuredId;
  }

  /**
   * tableChangedFlgを返します。
   * @return tableChangedFlg
   */
  protected int getTableChangedFlg(){
    return tableChangedFlg;
  }
  /**
   * tableChangedFlgを設定します。
   * @param tableChangedFlg tableChangedFlg
   */
  protected void setTableChangedFlg(int tableChangedFlg){
    this.tableChangedFlg = tableChangedFlg;
  }

  /**
   * masterCodeDataを返します。
   * @return masterCodeData
   */
  protected VRMap getMasterCodeData(){
    return masterCodeData;
  }
  /**
   * masterCodeDataを設定します。
   * @param masterCodeData masterCodeData
   */
  protected void setMasterCodeData(VRMap masterCodeData){
    this.masterCodeData = masterCodeData;
  }

  /**
   * claimListBasicを返します。
   * @return claimListBasic
   */
  protected VRList getClaimListBasic(){
    return claimListBasic;
  }
  /**
   * claimListBasicを設定します。
   * @param claimListBasic claimListBasic
   */
  protected void setClaimListBasic(VRList claimListBasic){
    this.claimListBasic = claimListBasic;
  }

  /**
   * claimListDetailを返します。
   * @return claimListDetail
   */
  protected VRList getClaimListDetail(){
    return claimListDetail;
  }
  /**
   * claimListDetailを設定します。
   * @param claimListDetail claimListDetail
   */
  protected void setClaimListDetail(VRList claimListDetail){
    this.claimListDetail = claimListDetail;
  }

  /**
   * claimListHideDetailを返します。
   * @return claimListHideDetail
   */
  protected VRList getClaimListHideDetail(){
    return claimListHideDetail;
  }
  /**
   * claimListHideDetailを設定します。
   * @param claimListHideDetail claimListHideDetail
   */
  protected void setClaimListHideDetail(VRList claimListHideDetail){
    this.claimListHideDetail = claimListHideDetail;
  }

  /**
   * claimListSpecialClinicを返します。
   * @return claimListSpecialClinic
   */
  protected VRList getClaimListSpecialClinic(){
    return claimListSpecialClinic;
  }
  /**
   * claimListSpecialClinicを設定します。
   * @param claimListSpecialClinic claimListSpecialClinic
   */
  protected void setClaimListSpecialClinic(VRList claimListSpecialClinic){
    this.claimListSpecialClinic = claimListSpecialClinic;
  }

  /**
   * claimListTotalを返します。
   * @return claimListTotal
   */
  protected VRList getClaimListTotal(){
    return claimListTotal;
  }
  /**
   * claimListTotalを設定します。
   * @param claimListTotal claimListTotal
   */
  protected void setClaimListTotal(VRList claimListTotal){
    this.claimListTotal = claimListTotal;
  }

  /**
   * columnListDetailを返します。
   * @return columnListDetail
   */
  protected VRList getColumnListDetail(){
    return columnListDetail;
  }
  /**
   * columnListDetailを設定します。
   * @param columnListDetail columnListDetail
   */
  protected void setColumnListDetail(VRList columnListDetail){
    this.columnListDetail = columnListDetail;
  }

  /**
   * columnListSpecialClinicを返します。
   * @return columnListSpecialClinic
   */
  protected VRList getColumnListSpecialClinic(){
    return columnListSpecialClinic;
  }
  /**
   * columnListSpecialClinicを設定します。
   * @param columnListSpecialClinic columnListSpecialClinic
   */
  protected void setColumnListSpecialClinic(VRList columnListSpecialClinic){
    this.columnListSpecialClinic = columnListSpecialClinic;
  }

  /**
   * snapListを返します。
   * @return snapList
   */
  protected VRList getSnapList(){
    return snapList;
  }
  /**
   * snapListを設定します。
   * @param snapList snapList
   */
  protected void setSnapList(VRList snapList){
    this.snapList = snapList;
  }
  
  /**
   * tableModelDetailを返します。
   * @return tableModelDetail
   */
  protected ACTableModelAdapter getTableModelDetail(){
    return tableModelDetail;
  }
  /**
   * tableModelDetailを設定します。
   * @param tableModelDetail tableModelDetail
   */
  protected void setTableModelDetail(ACTableModelAdapter tableModelDetail){
    this.tableModelDetail = tableModelDetail;
  }

  /**
   * tableModelSpecialClinicを返します。
   * @return tableModelSpecialClinic
   */
  protected ACTableModelAdapter getTableModelSpecialClinic(){
    return tableModelSpecialClinic;
  }
  /**
   * tableModelSpecialClinicを設定します。
   * @param tableModelSpecialClinic tableModelSpecialClinic
   */
  protected void setTableModelSpecialClinic(ACTableModelAdapter tableModelSpecialClinic){
    this.tableModelSpecialClinic = tableModelSpecialClinic;
  }

  //内部関数

  /**
   * 「データの取得・画面設定」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   *
   */
  public abstract void doFind() throws Exception;

  /**
   * 「各レコード集合の抽出」に関する処理を行ないます。
   *
   * @param list VRList
   * @throws Exception 処理例外
   *
   */
  public abstract void doFindCategory(VRList list) throws Exception;

  /**
   * 「画面の状態設定」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   *
   */
  public abstract void doControlState() throws Exception;

  /**
   * 「入力チェック」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   *
   */
  public abstract boolean isValidInput() throws Exception;

  /**
   * 「保存処理」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   *
   */
  public abstract boolean doSave() throws Exception;

  /**
   * 「画面表示用にデータ変換」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   * @return VRMap
   */
  public abstract VRMap doChangeTekiyoForDisplay(VRMap claimDataMap) throws Exception;

  /**
   * 「DB更新用にデータ変換」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   * @return VRMap
   */
  public abstract VRMap doChangeTekiyoForUpdate(VRMap claimDataMap) throws Exception;

  /**
   * 「摘要欄記載事項一覧テーブルの各行の設定処理」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   *
   */
  public abstract void doSetTableRow(VRMap claimDataMap, VRList colomListDetail, int categoryType) throws Exception;

  /**
   * 「初期化」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   *
   */
  public abstract void initialize() throws Exception;

	/**
	 * 「妥当な日付の入力チェック」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
  public abstract boolean checkValidDate(QkanDateTextField dateParam, String errMsg) throws Exception;
  
	/**
	 * 「未来日付の入力チェック」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public abstract boolean checkFutureDate(QkanDateTextField dateParam, String errMsg) throws Exception; 

	/**
	 * 「日付の開始日と終了日のチェック」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public abstract boolean checkRelationDate(QkanDateTextField firstDateParam,
			QkanDateTextField secondDateParam, String errMsg1, String errMsg2, String errMsg3) throws Exception;

}
