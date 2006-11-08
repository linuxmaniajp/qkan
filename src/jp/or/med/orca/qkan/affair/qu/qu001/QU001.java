
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
 * 作成日: 2005/12/15  日本コンピューター株式会社 堤 瑞樹 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 利用者管理 (U)
 * プロセス 利用者一覧 (001)
 * プログラム 利用者一覧 (QU001)
 *
 *****************************************************************
 */

package jp.or.med.orca.qkan.affair.qu.qu001;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.text.Format;
import java.util.Date;

import javax.swing.event.ListSelectionEvent;

import jp.nichicom.ac.ACCommon;
import jp.nichicom.ac.bind.ACBindUtilities;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.pdf.ACChotarouXMLUtilities;
import jp.nichicom.ac.pdf.ACChotarouXMLWriter;
import jp.nichicom.ac.sql.ACDBManager;
import jp.nichicom.ac.sql.ACPassiveKey;
import jp.nichicom.ac.text.ACHashMapFormat;
import jp.nichicom.ac.util.ACDateUtilities;
import jp.nichicom.ac.util.ACMessageBox;
import jp.nichicom.ac.util.adapter.ACTableModelAdapter;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.QkanConstants;
import jp.or.med.orca.qkan.QkanSystemInformation;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.affair.QkanMessageList;
import jp.or.med.orca.qkan.affair.qc.qc001.QC001;
import jp.or.med.orca.qkan.affair.qc.qc002.QC002;
import jp.or.med.orca.qkan.affair.qc.qc003.QC003;
import jp.or.med.orca.qkan.affair.qc.qc004.QC004;
import jp.or.med.orca.qkan.affair.qc.qc005.QC005;
import jp.or.med.orca.qkan.affair.qs.qs001.QS001;
import jp.or.med.orca.qkan.affair.qu.qu002.QU002;

/**
 * 利用者一覧(QU001) 
 */
public class QU001 extends QU001Event {

  /**
   * コンストラクタです。
   */
  public QU001(){
  }
  
  public void initAffair(ACAffairInfo affair) throws Exception  {
    super.initAffair(affair);
    initAction(affair);  
  }
  
  /**
   * 初期化処理を行ないます。
   * @param affair 業務情報
   * @throws Exception 処理例外
   */
  protected void initAction(ACAffairInfo affair) throws Exception {
    
    // 渡りパラメータを退避する。
    // this.nextAffair = NEXT_AFFAIR (次に遷移する業務ID)
    VRMap param = affair.getParameters();
    
    // データが存在しているかチェックする。
    // NEXT_AFFAIRの退避
    if(VRBindPathParser.has("NEXT_AFFAIR", param)){
    	setNextAffair(ACCastUtilities.toString(VRBindPathParser.get("NEXT_AFFAIR", param)));
    }
    
    // データが存在しているかチェックする。
    // PATIENT_IDの退避
    if(VRBindPathParser.has("PATIENT_ID", param)){
    	setPatientId(ACCastUtilities.toInt(
    			VRBindPathParser.get("PATIENT_ID", param)));
    }
    
    // データが存在しているかチェックする。
    // TARGET_DATEの退避
    if(VRBindPathParser.has("TARGET_DATE", param)){
    	setFindTargetDate((Date)VRBindPathParser.get("TARGET_DATE", param));
    }
    
    // 渡りパラメータの削除
    param.clear();
    
  	// 初期化を行う。
    initialize();

    // テーブルモデルを定義する。
    ACTableModelAdapter model = new ACTableModelAdapter();

    model.setColumns(new String[]{
    		"SHOW_FLAG",
			"PATIENT_CODE",
			"PATIENT_FAMILY_NAME+'　'+PATIENT_FIRST_NAME",
			"PATIENT_FAMILY_KANA+'　'+PATIENT_FIRST_KANA",
			"PATIENT_SEX",
			"PATIENT_BIRTHDAY",
			"PATIENT_ZIP_FIRST+'-'+PATIENT_ZIP_SECOND",
			"PATIENT_ADDRESS",
			"PATIENT_TEL_FIRST+'-'+PATIENT_TEL_SECOND+'-'+PATIENT_TEL_THIRD",
			"PATIENT_FAMILY_NAME",
			"PATIENT_FIRST_NAME",
			"PATIENT_FAMILY_KANA",
			"PATIENT_FIRST_KANA",
			"PATIENT_ZIP_FIRST",
			"PATIENT_ZIP_SECOND",
			"PATIENT_TEL_FIRST",
			"PATIENT_TEL_SECOND",
			"PATIENT_TEL_THIRD",
    });
    
    setPatientTableModel(model);
    
    // アダプタをテーブルのモデルとして設定する。
    getPatients().setModel(getPatientTableModel());
 
    // テーブルカラムにフォーマッタを設定する。
		getPatientEnabledColumn().setFormat(
				new ACHashMapFormat(new String[] {
						"jp/nichicom/ac/images/icon/pix16/btn_080.png",
						"jp/nichicom/ac/images/icon/pix16/btn_079.png" },
						new Integer[] { new Integer(0), new Integer(1), }));
  
    // 検索を行う。
    doFind();
    
  }

  public boolean canBack(VRMap parameters) throws Exception {
    if(!super.canBack(parameters)){
      return false;
    }
    
    // 前画面に戻る。
    // 前画面への遷移を許可するならばtrueを返す。
    return true;
  }

  public boolean canClose() throws Exception {
    if(!super.canClose()){
      return false;
    }
    
    // システムを終了する。
    // 終了を許可するならばtrueを返す。
    return true;
  }

  //コンポーネントイベント

  /**
   * 「検索」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected void findActionPerformed(ActionEvent e) throws Exception{
    // 検索を行う。
    doFind();
  }

  /**
   * 「詳細画面に遷移」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected void detailActionPerformed(ActionEvent e) throws Exception{
  	
    //PATIENT_IDを格納するpatientIdを定義する。
  	int patientId;
    
    // ※入力チェック
    // 入力チェックを行う。
  	if(!checkValue()){
  		return;
  	}
  	
    // 画面の「利用者一覧(patients)」の行が選択されているかどうかチェックする。
    if(!getPatients().isSelected()){
    	// 選択されていない場合
    	// 何もしない。
    	return;
    }else{
	    // 選択されている場合
	    // 選択されている利用者の「利用者ID(PATIENT_ID)」を取得する。
    	patientId = ACCastUtilities.toInt(
    			VRBindPathParser.get("PATIENT_ID", (VRMap)getPatients().getSelectedModelRowValue()));
    	
    }
    
    // 次画面に遷移する。
    transferNext(patientId);
  }

  /**
   * 「詳細画面に遷移」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected void insertActionPerformed(ActionEvent e) throws Exception{
    // ※次画面に遷移
  	
    // 次画面への渡りパラメータ格納用にレコード paramを生成する。
    VRMap param = new VRHashMap();    

    // 次画面遷移のためのパラメータ ACAffairInfo affair を定義する。
    ACAffairInfo affair = null;
  	
    if("QU002".equals(getNextAffair())){
	    // 「QU002」の場合
    	
	    // paramに下記パラメータを設定する。
	    // KEY : PROCESS_MODE, VALUE : PROCESS_MODE_INSERT
	    VRBindPathParser.set("PROCESS_MODE", param, new Integer(QkanConstants.PROCESS_MODE_INSERT));
	        	
	    // 下記パラメータにてaffairを生成する。
	    affair = new ACAffairInfo(QU002.class.getName(), param);
	    
    }
    
	//NEXT_AFFAIRを画面遷移前にフレームに退避しておく。
	ACFrame.getInstance().addNowAffairParameter("NEXT_AFFAIR", getNextAffair());
    
    // ※渡り処理
    // 次画面に遷移する。
    ACFrame.getInstance().next(affair);

  }

  /**
   * 「サービス予定に遷移」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected void planInsertActionPerformed(ActionEvent e) throws Exception {
		// ※サービス予定に遷移

		// PATIENT_IDを格納するpatientIdを定義する。
		int patientId;

		// ※次画面に渡す値の取得
		// 入力チェックを行う。
		if (!checkValue()) {
			return;
		}

		// 画面の「利用者一覧(patients)」の行が選択されているかどうかチェックする。
		if (!getPatients().isSelected()) {
			// 選択されていない場合

			// 処理を中断する。
			return;

		} else {
			// 選択されている場合

			// 選択されている利用者の「利用者ID(PATIENT_ID)」を取得する。
			patientId = ACCastUtilities.toInt(VRBindPathParser.get(
					"PATIENT_ID", (VRMap) getPatients()
							.getSelectedModelRowValue()));

		}

		if (!checkInsureInfo(patientId)) {
			// 利用者の要介護情報をチェックする。
			return;
		}

		// 次画面に遷移する。
		transferNext(patientId);

	}

  /**
	 * 「サービス実績に遷移」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
  protected void resultInsertActionPerformed(ActionEvent e) throws Exception{
    // ※サービス実績に遷移
    
    // PATIENT_IDを格納するpatientIdを定義する。
    int patientId;
    
    // 入力チェックを行う。
    if(!checkValue()){
    	return;
    }

    // 画面の「利用者一覧(patients)」の行が選択されているかどうかチェックする。
    if(!getPatients().isSelected()){
	    // 選択されていない場合
    	
	    // 処理を中断する。
    	return;
    	
    }else{
	    // 選択されている場合
    	
    	// 選択されている利用者の「利用者ID(PATIENT_ID)」を取得する。
    	patientId = ACCastUtilities.toInt(VRBindPathParser
    			.get("PATIENT_ID", (VRMap)getPatients().getSelectedModelRowValue()));
    	
    }
    
    // 利用者の要介護情報をチェックする。
    if(!checkInsureInfo(patientId)){
    	return;
    } 
    
    // 次画面に遷移する。
    transferNext(patientId);

  }

  /**
   * 「利用者削除」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected void deleteActionPerformed(ActionEvent e) throws Exception{
    // ※画面で選択された利用者の削除
    
  	// 選択されているレコードのモデルのインデックスを格納するmodelRowを定義する。
  	int modelRow;
  	
  	// 選択されているレコードの画面上のインデックスを格納するsortedRowを定義する。
  	int sortedRow;
  	
  	// ※入力チェック
    // 画面の「利用者一覧(patients)」の行が選択されているかどうかチェックする。
  	if(!getPatients().isSelected()){
  	    // 選択されていない場合
  		
  	    // 処理を中断する。
  		return;
  	
  	}else{
  		// 選択されている場合
  		
  		// 選択行のインデックス(モデルではなく画面上)を取得する。
  		modelRow = getPatients().getSelectedModelRow();
  		sortedRow = getPatients().getSelectedSortedRow();
  	}
  	
  	// ※処理確認
    // 削除確認メッセージを表示する。※メッセージID = WARNING_OF_DELETE
    if(QkanMessageList.getInstance().
    		WARNING_OF_DELETE("選択中の利用者情報") == ACMessageBox.RESULT_CANCEL){
	    // 「キャンセル」を選択した場合(削除中断)
	    // 処理を中断する。
    	return;    	
    }
    
    try{
    	
    	// トランザクション開始
    	getDBManager().beginTransaction();
    	
	    // ※パッシブチェック
	    // パッシブタスクをクリアする。
	    getPassiveChecker().clearPassiveTask();
	    
	    // パッシブタスクを登録する。
	    getPassiveChecker().addPassiveUpdateTask(getPASSIVE_CHECK_KEY(), modelRow);    
	
	    // パッシブチェックを実行する。
	    if(!(getPassiveChecker().passiveCheck(getDBManager()))){
		    // パッシブエラーがある場合
	    	
		    // パッシブエラーメッセージを表示する。※メッセージID = ERROR_OF_PASSIVE_CHECK_ON_UPDATE
		    QkanMessageList.getInstance().ERROR_OF_PASSIVE_CHECK_ON_UPDATE();
		    
		    // トランザクション解除
		    getDBManager().rollbackTransaction();
		    
		    // 処理を中断する。(異常終了)
		    return;
	    }
	    
	    // パッシブエラーがない場合
	    // 処理を続行する。
	    // ※削除
	    // 選択行の「利用者ID(PATIENT_ID)」を取得する。
	    int patientId = ACCastUtilities.toInt(
	    		VRBindPathParser.get("PATIENT_ID", (VRMap)getPatientData().get(modelRow)));
	    
	    // SQL文取得関数に渡すレコード sqlParamを生成する。
	    VRMap sqlParam = new VRHashMap();
	    
	    // sqlParamに下記の値を設定する。
	    // KEY : PATIENT_ID, VALUE : (取得した利用者ID)
	    VRBindPathParser.set("PATIENT_ID", sqlParam, new Integer(patientId));
	    
	    // 利用者情報削除用のSQL文を取得する。
	    String strSql = getSQL_DELETE_PATIENT(sqlParam);
	    
	    // 取得したSQL文を発行する。
	    getDBManager().executeUpdate(strSql);
	    
	    // 上記のSQL発行処理でエラーがなかった場合
	    // 処理をコミットする。
	    getDBManager().commitTransaction();

	    // 再検索して、最新のデータを取得する。
	    doFind();
	    
	    // 削除した行の1行上の行を選択する。
	    getPatients().setSelectedSortedRowOnAfterDelete(sortedRow);
	    
//	    // 処理完了通知メッセージを表示する。※メッセージID = DELETE_SUCCESSED
//	    QkanMessageList.getInstance().DELETE_SUCCESSED();
	       
    }catch(Exception ex){
        // エラーがあった場合
        // 処理をロールバックする。
        // 処理を中断する。(異常終了)
    	getDBManager().rollbackTransaction();
    	
    	//上位クラスに例外を返す。
    	throw ex;
    }

  }

  /**
   * 「セル選択」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected void patientsSelectionChanged(ListSelectionEvent e) throws Exception {
  	
  	// 画面の「利用者一覧(patients)」の行が選択されているかどうかチェックする。
    if(!getPatients().isSelected()){
    	//選択されていない場合
    	
    	//業務ボタンの状態を変更する。
    	 setState_UNSELECTED();
    	
    }else{
	    // 選択されている場合
    	// 業務ボタンの状態を変更する。
    	 setState_SELECTED();
    	 
    }  	
  }
  
  /**
   * 「ダブルクリック」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected void patientsMouseClicked(MouseEvent e) throws Exception{
  	
    //PATIENT_IDを格納するpatientIdを定義する。
  	int patientId;
    
    // ※入力チェック
    // 　入力チェックを行う。
  	if(!checkValue()){
  		return;
  	}
  	
    // 画面の「利用者一覧(patients)」の行が選択されているかどうかチェックする。
    if(!getPatients().isSelected()){
    	// 選択されていない場合
    	// 何もしない。
    	return;
    }else{
	    // 選択されている場合
	    // 選択されている利用者の「利用者ID(PATIENT_ID)」を取得する。
    	patientId = ACCastUtilities.toInt(VRBindPathParser
    			.get("PATIENT_ID", (VRMap)getPatients().getSelectedModelRowValue()));
    }
    
    if("QS001".equals(getNextAffair()) || "QR001".equals(getNextAffair())){
	    // 予定・実績画面へ遷移する場合
    	// 利用者の要介護情報をチェックする。
	    if(!checkInsureInfo(patientId)){
	    	return;
	    }
    }
    
    // 次画面に遷移する。
    transferNext(patientId);
  	  	
  }
  
  
  /**
   * 「利用者一覧印刷」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected void printActionPerformed(ActionEvent e) throws Exception{
    // ※利用者一覧の印刷
    
  	// ※前準備
    // 印刷クラスに渡すレコード printParamを生成する。
    VRMap printParam = new VRHashMap();
    
    // ※渡すパラメータの取得
    // patientDataの件数分ループする。
    for(int i = 0; i < getPatientData().size(); i++){   
    
	    // PATIENT_ID格納用変数を定義する。
    	int patientId;
    	// 利用者情報格納用Mapを定義する。
    	VRMap patientMap = new VRHashMap();
    	// 要介護報格納用Listを定義する。
    	VRList patientInsureList;
    	// 事業所情報格納用Mapを定義する。
    	VRMap providerMap = new VRHashMap();
    	// SQL文格納用Stringを定義する。
    	String strSql;
    	// sqlParamの生成
	    VRMap sqlParam = new VRHashMap();	    
    	    	
    	// patientDataのKEY : PATIENT_IDのVALUEを取得する(利用者ID)。
	    patientMap = (VRMap)getPatientData().get(i);
	    patientId = ACCastUtilities.toInt(VRBindPathParser.get("PATIENT_ID", patientMap));	
	   
	    // sqlParamの設定
	    // 利用者ID追加
	    VRBindPathParser.set("PATIENT_ID", sqlParam, new Integer(patientId));
	    // 現在日付追加
	    VRBindPathParser.set("NOW_DATE", sqlParam, new Date());
	    
	    // 現在日付時点の要介護情報を取得する。
	    // SQL文の取得
	    strSql = getSQL_GET_NINTEI_NOW(sqlParam);
	    	
	    // SQL文の実行
	    patientInsureList = getDBManager().executeQuery(strSql);
	    
	    // 現在日付時点の要介護情報が0件の場合
	    if(patientInsureList.size() == 0){
	    	
	    	// 現在日付より未来の要介護情報のうち直近の情報を取得する。
		    // SQL文の取得
		    strSql = getSQL_GET_NINTEI_FUTURE(sqlParam);
		    	
		    // SQL文の実行
		    patientInsureList = getDBManager().executeQuery(strSql);
		    
		    if(patientInsureList.size() == 0){
		    	
		    	// 現在日付より過去の要介護情報のうち直近の情報を取得する。
			    // SQL文の取得
			    strSql = getSQL_GET_NINTEI_PAST(sqlParam);
			    	
			    // SQL文の実行
			    patientInsureList = getDBManager().executeQuery(strSql);	    	
		    	
		    }	    	
	    }
	    
	    // 取得した要介護情報が1件以上の場合
	    if(patientInsureList.size() > 0){
	    	
	    	//要介護情報レコードを取り出す。
	    	VRMap map = (VRMap)patientInsureList.get(0);
	    	
	    	// 利用者情報に以下の値を追加する。
	    	// 被保険者番号
	    	VRBindPathParser.set("INSURED_ID", patientMap, VRBindPathParser.get("INSURED_ID", map));
	    	// 要介護度
	    	VRBindPathParser.set("JOTAI_CODE", patientMap, VRBindPathParser.get("JOTAI_CODE", map));
	    	// 有効期間終了
	    	VRBindPathParser.set("INSURE_VALID_END", patientMap, VRBindPathParser.get("INSURE_VALID_END", map));
	    	
		    // 居宅介護支援事業所IDを取得する。
		    String providerId = ACCastUtilities.toString(VRBindPathParser.get("PROVIDER_ID", map));
		    
		    if(!(providerId == null || "".equals(providerId))){
			    // 事業所情報を取得する。
			    VRList providerList = (VRList)QkanCommon.getProviderInfo(getDBManager(), providerId);
			    
		    	if(providerList.size() > 0){
		    		providerMap = (VRMap)(providerList).get(0);
		    	}		    
			    
			    // 利用者情報に居宅介護支援事業所名を加える。
		    	VRBindPathParser.set("PROVIDER_NAME", patientMap, providerMap.get("PROVIDER_NAME"));
		    }
	    }
    }
    
    // 利用者情報を、printParamのKEY : PARAMのVALUEとして設定する。
    VRBindPathParser.set("PARAM", printParam, getPatientData());
    
    // ※印刷
    // 印刷する。
    QU001P01 qu001p01 = new QU001P01();
    ACChotarouXMLWriter writer = new ACChotarouXMLWriter();
    
    // 印刷開始を宣言
    writer.beginPrintEdit();
    
    // 印刷クラスへ処理を渡す。
    qu001p01.doPrint(writer, printParam);
    
    // 印刷終了を宣言
    writer.endPrintEdit();

    // PDFファイルを生成して開く。
    ACChotarouXMLUtilities.openPDF(writer);
    
  }


  public static void main(String[] args) {
    // デフォルトデバッグ起動
    ACFrame.getInstance().setFrameEventProcesser(new QkanFrameEventProcesser());
    QkanCommon.debugInitialize();
    
    // 仮起動
    VRHashMap param = new VRHashMap();
    param.setData("NEXT_AFFAIR", "QU002");
//    Date date = new Date();
//    param.setData("PATIENT_ID", new Integer(111));
//    param.setData("PATIENT_ID", date);
    ACFrame.debugStart(new ACAffairInfo(QU001.class.getName(), param));
//    ACFrame.debugStart(new ACAffairInfo(QU001.class.getName()));
  }

  /**
   * 「初期化処理」に関する処理を行ないます。
   * @throws Exception 処理例外
   */
  public void initialize() throws Exception{
    // ※初期化処理
  	
    // ※ウィンドウタイトル・業務ボタンバーの設定
  	setAffairTitle(AFFAIR_ID, getNextAffair(), getButtons());
  	
  	// 画面の初期状態を設定する。nextAffairの値によって、設定が分岐する。

  	if("QU002".equals(getNextAffair())){
  	  	//「QU002」の場合
  		
  		// パッシブキーの定義
  		setPASSIVE_CHECK_KEY(new ACPassiveKey("PATIENT",
				new String[] { "PATIENT_ID" },
				new Format[] { null },
				"LAST_TIME", "LAST_TIME"));
  		
  		// QU002用の設定を行う。
  		setState_INIT_PATIENT();
  		
  	}else if("QS001".equals(getNextAffair())){
  		//「QS001」の場合
  		
	    // QS001用の設定を行う。
	    setState_INIT_SERVICE_PLAN();
	    
	}else if("QR001".equals(getNextAffair())){
	    //「QR001」の場合
		
	    // QR001用の設定を行う。
	    setState_INIT_SERVICE_RESULT();
	    	    
    }else if("QC001".equals(getNextAffair())){
    	//「QC001」の場合
    	
	    // QC001用の設定を行う。
	    setState_INIT_HOMONKANGO_PLAN();
	    
    }else if("QC002".equals(getNextAffair())){
        //「QC002」の場合
    	
    	// QC002用の設定を行う。
	    setState_INIT_HOMONKANGO_RESULT();
	    
    }else if("QC003".equals(getNextAffair())){
        //「QC003」の場合
    	
	    // QC003用の設定を行う。
	    setState_INIT_HOMONKANGO_JOHO_TEIKYOSHO();
	    
    }else if("QC004".equals(getNextAffair())){
        //「QC004」の場合
    	
    	// QC004用の設定を行う。
	    setState_INIT_HOMONKANGO_KIROKUSHO();
	    
    }else if("QC005".equals(getNextAffair())){
        //「QC005」の場合
    	
    	// QC005用の設定を行う。
	    setState_INIT_KYOTAKU();
	    
    }
      	
    // ※対象年月の設定
    // システムから、「システム日付」を取得する。
    if(getFindTargetDate() == null){    
    	// 渡りパラメータとして、TARGET_DATEが渡されていない場合
	
    	Date sysDate = QkanSystemInformation.getInstance().getSystemDate();
    	
    	if(ACDateUtilities.compareOnDay(sysDate, TARGET_DATE_20060401) < 0){
        	// システム日付が平成18年4月以前の日付の場合
    		getTargetDate().setDate(TARGET_DATE_20060401);
    	}else{
        	// システム日付が平成18年4月以降の日付の場合
	    	// 画面の「対象年月(targetDate)」に、取得したシステム日付を設定する。
		    getTargetDate().setDate(sysDate);
    	}
	    
    }else{
    	// 渡りパラメータとして、TARGET_DATEが渡されている場合
    	
    	// 渡されたTARGET_DATEを画面の「対象年月(targetDate)」に設定する。
    	getTargetDate().setDate(getFindTargetDate());
    	
    	// 二重に使用されないよう削除する。
    	setFindTargetDate(null);
    	
    }   
  }

  /**
   * 「検索」に関する処理を行ないます。
   * @throws Exception 処理例外
   */
  public void doFind() throws Exception{
    // ※DBから利用者一覧を取得、画面に設定
  	
    // ※検索準備
  	// SQL文取得関数に渡すレコード sqlParamを生成する。
    VRMap sqlParam = new VRHashMap();

    // 検索条件の取得
    VRMap selectKey = new VRHashMap();
    
    getFindConditions().setSource(selectKey);
    getFindConditions().applySource();
    
    // ※利用者コードの取得
    String patientCode = ACCastUtilities.toString(selectKey.get("PATIENT_CODE"));
    
    // 画面の「利用者コード(patientCode)」のTextを取得し、危険文字の置換を行う。
	patientCode = QkanCommon.toFindString(patientCode);

	if(patientCode.length() > 0){
		// 取得した文字列が存在する場合(文字列長が0より大きい場合)
		
		// 取得した文字列をsqlParamの KEY : PATIENT_CODE の VALUE として設定する。
		VRBindPathParser.set("PATIENT_CODE", sqlParam, patientCode);
		
	}
    
    // ※ふりがなの取得
    String patientKana = ACCastUtilities.toString(selectKey.get("PATIENT_KANA"));
    
    // 画面の「ふりがな(patientKana)」のTextを取得し、危険文字の置換を行う。
	patientKana = QkanCommon.toFindString(patientKana);
	
	if(patientKana.length() > 0){    
		// 取得した文字列が存在する場合(文字列長が0より大きい場合)
		// 取得した文字列をsqlParamの KEY : PATIENT_KANA の VALUE として設定する。
		VRBindPathParser.set("PATIENT_KANA", sqlParam, patientKana);
		
	}
    
    // ※生年月日の取得   	
    if(getBirthday().isValidDate()){  
    	// 存在する日付が入力されている場合
    
	    if(selectKey.get("PATIENT_BIRTHDAY") instanceof Date){   	 
		       	
		        // 画面の「生年月日(birthday)」の値を取得する。
		    	Date birthDay = (Date)selectKey.get("PATIENT_BIRTHDAY");
	    	
			    // 取得した値をsqlParamの KEY : PATIENT_BIRTHDAY の VALUE として設定する。
		    	VRBindPathParser.set("PATIENT_BIRTHDAY", sqlParam, birthDay);
	    		
	    }
	    
    }else{
    	// 存在しない日付が入力されている場合
    	
    	//フォーカスをあてる。
    	getBirthday().requestFocus();
    	
    	// エラーメッセージ
    	QkanMessageList.getInstance().ERROR_OF_WRONG_DATE("生年月日の");
    	
    	return;
    	
    }
    
	// ※「現在有効でない利用者を含めて検索」フラグの取得
    // 画面の「現在有効でない利用者も含めて検索(nowNotEnabledPatientIncludeFind)」の値を取得する。
    if(!(selectKey.get("HIDE_FLAG") == null)){
    	
    	int hideFlag = ACCastUtilities.toInt(selectKey.get("HIDE_FLAG"));
    
	    if(hideFlag == 0){
		    // 0の場合(未選択の場合)
	    	// sqlParamに KEY : HIDE_FLAG, VALUE : null を設定する。
	        VRBindPathParser.set("HIDE_FLAG", sqlParam, null);
	        
	    }
    }
    
    // ※DBからデータを取得
    // 検索用SQL文を取得する。
	String strSql = getSQL_GET_PATIENT(sqlParam);
    
	// 取得したSQL文を発行し、結果をpatientDataに格納する。
    VRList patientData = new VRArrayList();    
    patientData = getDBManager().executeQuery(strSql);
    
    // patientDataを退避する。
    setPatientData(patientData);
    
    // ※取得したデータを画面に展開
    getPatientTableModel().setAdaptee(patientData);
    
    // patientDataの件数をチェックする。
    if(patientData.size() > 0){
	    
    	// 退避した利用者IDをチェックする。
    	if(getPatientId() == 0){
    		// 利用者IDが渡されていなかった場合
    		
	    	// 画面の「利用者一覧(patients)」の1行目を選択する。
	    	getPatients().setSelectedSortedFirstRow();
	    	
    	}else{
    		// 利用者IDが渡されていた場合
    		
    		// 渡された利用者IDを持つ利用者を選択する。
    		int index = ACCommon.getInstance().getMatchIndexFromValue(
    				getPatientData(), "PATIENT_ID", new Integer(getPatientId()));
    		
    		if(index == -1){
    			
    			// 該当する利用者がいなかった場合、1行目を選択する。
    			getPatients().setSelectedSortedFirstRow();
    			
    		}else{
    			
    			// 該当する利用者がいた場合、該当利用者を選択する。
    			getPatients().setSelectedModelRow(index);
                getPatients().scrollSelectedToVisible();
    		}
    			
    		// 二重に使用されないように削除する。
    		setPatientId(0);
    		
    	}    	
    }else{
    	// 業務ボタンの状態を変更する。
    	setState_UNSELECTED();
    }
    
    // ※パッシブキーの再登録
    // パッシブキーをクリアする。
    getPassiveChecker().clearReservedPassive();
    
    // パッシブキーを登録する。
    getPassiveChecker().reservedPassive(getPASSIVE_CHECK_KEY(), getPatientData());
    
    // ステータスバー
//    setStatusText("");
    
    // フォーカス
    if(getTargetDate().getParent().isVisible()){
    	getTargetDate().requestFocus();
    }else{
    	getPatientCode().requestFocus();
    }
    
  }
  
  /**
   * 「画面遷移処理」に関する処理を行います。
   * @param 一覧テーブルで選択されている利用者の利用者ID
   * @throws Exception 処理例外
   */
  public void transferNext(int patientId) throws Exception{
  	
	// ステータスバーに選択された利用者の名前を表示する。
	VRMap patientData = ACBindUtilities.getMatchRowFromValue(
			getPatientData(), "PATIENT_ID", new Integer(patientId));
	String familyName = ACCastUtilities.toString(
			VRBindPathParser.get("PATIENT_FAMILY_NAME", patientData));
	String firstName = ACCastUtilities.toString(
			VRBindPathParser.get("PATIENT_FIRST_NAME", patientData));
	setStatusText(QkanCommon.toFullName(familyName, firstName) + "さんが選択されました。");
	
	
    // 次画面への渡りパラメータ格納用にレコード paramを生成する。
    VRMap param = new VRHashMap();
        
    // ※渡りパラメータの設定
    // 次画面遷移のためのパラメータ NCAffairInfo affair を定義する。
    // affair(new ACAffair());
    ACAffairInfo affair = null;

    if("QU002".equals(getNextAffair())){
	    // 「QU002」の場合

	    // paramに下記パラメータを設定する。
	    // KEY : PROCESS_MODE, VALUE : PROCESS_MODE_UPDATE
	    // KEY : PATIENT_ID, VALUE : (取得した利用者ID)
    	VRBindPathParser.set("PROCESS_MODE", param, new Integer(QkanConstants.PROCESS_MODE_UPDATE));
    	VRBindPathParser.set("PATIENT_ID", param, new Integer(patientId));
    	
	    // 下記パラメータにてaffairを生成する。
	    // className : QU002.class.getName(), parameters : param
    	affair = new ACAffairInfo(QU002.class.getName(), param); 
    	
    }else if("QC001".equals(getNextAffair())){
	    // 「QC001」の場合
    	
	    // paramに下記パラメータを設定する。
	    // KEY : PATIENT_ID, VALUE : (取得した利用者ID)
	    // KEY : TARGET_DATE, VALUE : (画面「対象年月(targetDate)」の値)
    	VRBindPathParser.set("PATIENT_ID", param, new Integer(patientId));
    	VRBindPathParser.set("TARGET_DATE", param, getTargetDate().getDate());
    	
	    // 下記パラメータにてaffairを生成する。
	    // className : QC001.class.getName(), parameters : param
    	affair = new ACAffairInfo(QC001.class.getName(), param); 
    	
    }else if("QC002".equals(getNextAffair())){    	
	    // 「QC002」の場合
    	
	    // paramに下記パラメータを設定する。
	    // KEY : PATIENT_ID, VALUE : (取得した利用者ID)
	    // KEY : TARGET_DATE, VALUE : (画面「対象年月(targetDate)」の値)
    	VRBindPathParser.set("PATIENT_ID", param, new Integer(patientId));
    	VRBindPathParser.set("TARGET_DATE", param, getTargetDate().getDate());
    	
	    // 下記パラメータにてaffairを生成する。
	    // className : QC002.class.getName(), parameters : param
    	affair = new ACAffairInfo(QC002.class.getName(), param);
    	
    }else if("QC003".equals(getNextAffair())){
	    // 「QC003」の場合
    	
	    // paramに下記パラメータを設定する。
	    // KEY : PATIENT_ID, VALUE : (取得した利用者ID)
	    // KEY : TARGET_DATE, VALUE : (画面「対象年月(targetDate)」の値)
    	VRBindPathParser.set("PATIENT_ID", param, new Integer(patientId));
    	VRBindPathParser.set("TARGET_DATE", param, getTargetDate().getDate());
    	
	    // 下記パラメータにてaffairを生成する。
	    // className : QC003.class.getName(), parameters : param
    	affair = new ACAffairInfo(QC003.class.getName(), param);
    	
    }else if("QC004".equals(getNextAffair())){
	    // 「QC004」の場合
    	
	    // paramに下記パラメータを設定する。
	    // KEY : PATIENT_ID, VALUE : (取得した利用者ID)
	    // KEY : TARGET_DATE, VALUE : (画面「対象年月(targetDate)」の値)
    	VRBindPathParser.set("PATIENT_ID", param, new Integer(patientId));
    	VRBindPathParser.set("TARGET_DATE", param, getTargetDate().getDate());
    	
	    // 下記パラメータにてaffairを生成する。
	    // className : QC004.class.getName(), parameters : param
    	affair = new ACAffairInfo(QC004.class.getName(), param);
    	
    }else if("QC005".equals(getNextAffair())){
	    // 「QC005」の場合
    	
	    // paramに下記パラメータを設定する。
	    // KEY : PATIENT_ID, VALUE : (取得した利用者ID)
	    // KEY : TARGET_DATE, VALUE : (画面「対象年月(targetDate)」の値)
    	VRBindPathParser.set("PATIENT_ID", param, new Integer(patientId));
    	VRBindPathParser.set("TARGET_DATE", param, getTargetDate().getDate());
    	
	    // 下記パラメータにてaffairを生成する。
	    // className : QC005.class.getName(), parameters : param
    	affair = new ACAffairInfo(QC005.class.getName(), param);
    	
    }else if("QS001".equals(getNextAffair())){
	    // 「QS001」の場合
    	
	    // paramに下記パラメータを設定する。
    	// KEY : PATIENT_ID, VALUE : 利用者ID
	    // KEY : TARGET_DATE, VALUE : (画面「対象年月(targetDate)」の値)
    	// KEY : PROCESS_TYPE, VALUE : PROCESS_TYPE_PLAN
    	VRBindPathParser.set("PATIENT_ID", param, new Integer(patientId));
    	VRBindPathParser.set("TARGET_DATE", param, getTargetDate().getDate());
    	VRBindPathParser.set("PROCESS_TYPE", param, new Integer(QkanConstants.PROCESS_TYPE_PLAN));
    	
    	// 上記パラメータにてaffairを生成する。
	    // className : QS001.class.getName(), parameters : param
	    affair = new ACAffairInfo(QS001.class.getName(), param, true);
	    
    }else if("QR001".equals(getNextAffair())){
        // 「QR001」の場合
    	
	    // paramに下記パラメータを設定する。
	    // KEY : PATIENT_ID, VALUE : (取得した利用者ID)
	    // KEY : TARGET_DATE, VALUE : (画面「対象年月(targetDate)」の値)
    	// KEY : PROCESS_TYPE, VALUE : PROCESS_TYPE_RESULT
    	VRBindPathParser.set("PATIENT_ID", param, new Integer(patientId));
    	VRBindPathParser.set("TARGET_DATE", param, getTargetDate().getDate());
    	VRBindPathParser.set("PROCESS_TYPE", param, new Integer(QkanConstants.PROCESS_TYPE_RESULT));
    	
	    // 下記パラメータにてaffairを生成する。
	    // className : QR001.class.getName(), parameters : param
    	affair = new ACAffairInfo(QS001.class.getName(), param, true);
    	
    }
    
	// NEXT_AFFAIR, TARGET_DATEを画面遷移前にフレームに退避しておく。
	ACFrame.getInstance().addNowAffairParameter("NEXT_AFFAIR", getNextAffair());
	ACFrame.getInstance().addNowAffairParameter("TARGET_DATE", getTargetDate().getDate());
	ACFrame.getInstance().addNowAffairParameter("PATIENT_ID", new Integer(patientId));
    
    // ※遷移処理
    // 次画面に遷移する。
    ACFrame.getInstance().next(affair);
  	
  }
  
  /**
   * 「入力チェック」に関する処理を行ないます。
   * @return エラーがない場合true エラーがある場合false
   * @throws Exception 処理例外
   */
  public boolean checkValue() throws Exception{
    // ※入力チェック
    // 画面の「対象年月(targetDate)」に値が入力されているかどうかチェックする。

  	if("".equals(getTargetDate().getText())){
  		// 入力されていない場合  		
  		// フォーカスをあてる。
  		getTargetDate().requestFocus();
  		
  		// メッセージを表示する。※メッセージID = ERROR_OF_NEED_CHECK_FOR_INPUT
  		QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT("対象年月");
  	
  		return false;
  	}
  	
	if(!getTargetDate().isValidDate()){
  		// 存在しない日付が入力されている場合	
  		// フォーカスをあてる。
  		getTargetDate().requestFocus();
  		
  		// メッセージを表示する。※メッセージID = ERROR_OF_WRONG_DATE 		
  		QkanMessageList.getInstance().ERROR_OF_WRONG_DATE("対象年月の");
  		
  		return false;
  		
  	}
	
	if(ACDateUtilities.compareOnDay(getTargetDate().getDate(), TARGET_DATE_20060401) < 0){
		// 平成18年4月以前の日付が入力されている場合
  		// フォーカスをあてる。
  		getTargetDate().requestFocus();

  		// メッセージを表示する。※メッセージID = ERROR_OF_WRONG_DATE 		
  		QkanMessageList.getInstance().QU001_ERROR_OF_DATE_BEFORE_LAW_CHANGE();
  		
  		return false;
  		
	}
	
    return true;
    
  }

  /**
   * 「利用者の要介護情報チェック」に関する処理を行います。
   * @param チェックを行う対象利用者の利用者ID
   * @return 要介護度を持っている場合true 持っていない場合false
   * @throws Exception 処理例外
   */
  public boolean checkInsureInfo(int patientId) throws Exception {
		// 選択された利用者の情報(基本情報・要介護度情報)を取得する。
	  	Date targetDate = getTargetDate().getDate();
		VRList list = QkanCommon.getPatientInsureInfoOnEndOfMonth(
				getDBManager(), targetDate, patientId);

		if ((list.size() == 0)
				|| !(QkanCommon.isFullDecisionPatientInsureInfo(getDBManager(),
						targetDate, patientId))) {
			// 要介護度情報が取得できなかった場合
			// もしくは申請中の要介護情報が存在する場合

			// 処理続行確認メッセージを表示する。※メッセージID = QU001_HAS_NO_YOKAIGODO
			if (QkanMessageList.getInstance().QU001_HAS_NO_YOKAIGODO() == ACMessageBox.RESULT_CANCEL) {
				// キャンセル選択時(処理中断時)

				// 処理を中断する。
				return false;

			}
		}

		return true;

	}

  public Component getFirstFocusComponent() {

		if (getTargetDate().getParent().isVisible()) {
			return getTargetDate();
		} else {
			return getPatientCode();
		}

	}
}
