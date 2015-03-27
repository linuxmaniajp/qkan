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
 * 作成日: 2005/12/16  日本コンピューター株式会社 堤 瑞樹 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 帳票管理 (C)
 * プロセス 在宅療養生活のポイント (005)
 * プログラム 在宅療養生活のポイント (QC005)
 *
 *****************************************************************
 */

package jp.or.med.orca.qkan.affair.qc.qc005;

import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.text.Format;
import java.util.Date;

import jp.nichicom.ac.ACCommon;
import jp.nichicom.ac.component.ACTextField;
import jp.nichicom.ac.container.ACLabelContainer;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.pdf.ACChotarouXMLUtilities;
import jp.nichicom.ac.pdf.ACChotarouXMLWriter;
import jp.nichicom.ac.sql.ACDBManager;
import jp.nichicom.ac.sql.ACPassiveKey;
import jp.nichicom.ac.text.ACSQLSafeDateFormat;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.ac.util.ACDateUtilities;
import jp.nichicom.ac.util.ACMessageBox;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.text.VRDateFormat;
import jp.nichicom.vr.text.parsers.VRDateParser;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.QkanConstants;
import jp.or.med.orca.qkan.QkanSystemInformation;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.affair.QkanMessageList;

/**
 * 在宅療養生活のポイント(QC005)
 */
public class QC005 extends QC005Event {

	/**
	 * 対象年月に認定有効期間があるかないかの判定
	 */
	private boolean NoNinteiHistory;

	/**
	 * 今月、来月の訪問日のBindPathの配列格納変数
	 */
	private static String[] VisitDayKey = { "VISIT_THIS_MONTH_NO1",
			"VISIT_THIS_MONTH_NO2", "VISIT_THIS_MONTH_NO3",
			"VISIT_THIS_MONTH_NO4", "VISIT_THIS_MONTH_NO5",
			"VISIT_THIS_MONTH_NO6", "VISIT_NEXT_MONTH_NO1",
			"VISIT_NEXT_MONTH_NO2", "VISIT_NEXT_MONTH_NO3",
			"VISIT_NEXT_MONTH_NO4", "VISIT_NEXT_MONTH_NO5",
			"VISIT_NEXT_MONTH_NO6" };

	/**
	 * コンストラクタです。
	 */
	public QC005() {
	}

	public void initAffair(ACAffairInfo affair) throws Exception {
		super.initAffair(affair);
		initAction(affair);
	}

	/**
	 * 初期化処理を行ないます。
	 * 
	 * @param affair
	 *            業務情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void initAction(ACAffairInfo affair) throws Exception {
		// 認定有効期間フラグの初期化
		NoNinteiHistory = false;

		// 渡りデータの取得/前画面「利用者一覧」から渡されたパラメータを退避する。
		// this.patientID = PATIENT_ID(利用者ID)
		// this.targetDate = TARGET_DATE(対象年月)
		VRMap parameters = affair.getParameters();

		// データが存在しているかをチェック
		if (VRBindPathParser.has("PATIENT_ID", parameters)
				&& VRBindPathParser.has("TARGET_DATE", parameters)) {

			// int型に型変換し利用者IDを退避
			setPatientID(Integer.parseInt(String.valueOf(VRBindPathParser.get(
					"PATIENT_ID", parameters))));
			// Date型に型変換し対象年月を退避
			setTargetDate((Date) VRBindPathParser
					.get("TARGET_DATE", parameters));

        }
		
		// ※初期状態の設定
		// 画面の初期状態を設定する。
		
		// 画面の初期化を行う。
		doInitialize();

		// スナップショットの撮影対象を指定する。
		getSnapshot().setRootContainer(getContents());

		// DBからデータを取得する。
		doFind();
	}

	public boolean canBack(VRMap parameters) throws Exception {
		if (!super.canBack(parameters)) {
			return false;
		}

		// 認定期間の判定フラグが真のとき
		if (NoNinteiHistory == true) {
			return true;
		}

		// [2014年要望][Shinobu Hitaka] 2014/12/02 add begin 居宅療養管理指導書の対象年月に複数登録対応
		parameters.setData("PATIENT_ID", getPatientID());
		parameters.setData("TARGET_DATE", getTargetDate());
		// [2014年要望][Shinobu Hitaka] 2014/12/02 add end
		
		// ※スナップショットチェック
		// スナップショットの更新チェックを行う。
		if (!getSnapshot().isModified()) {
			// 更新されていない場合
			// 前画面に戻る。
			// [2014年要望][Shinobu Hitaka] 2014/12/02 edit begin 居宅療養管理指導書の対象年月に複数登録対応
			//parameters.setData("QU001.class", parameters);
			parameters.setData("QC006.class", this.getClass().getName());
			// [2014年要望][Shinobu Hitaka] 2014/12/02 edit end

			// 前画面に遷移してもよければtrueを返す
			return true;
		}
		// 更新されている場合
		// 処理を継続する。
		// ※保存確認
		// ※表示メッセージの決定
		// 表示メッセージID格納用の数値型変数 msgID を定義する。
		int msgID = 0;
		// processModeの値をチェックする。
		if (getProcessMode() == QkanConstants.PROCESS_MODE_INSERT) {
			// PROCESS_MODE_INSERT(登録)の場合
			// msgIDに、WARNING_OF_INSERT_ON_MODIFIEDを設定する。
			msgID = QkanMessageList.getInstance()
					.WARNING_OF_INSERT_ON_MODIFIED();
		} else {
			// PROCESS_MODE_UPDATE(更新)の場合
			// msgIDに、WARNING_OF_UPDATE_ON_MODIFIEDを設定する。
			msgID = QkanMessageList.getInstance()
					.WARNING_OF_UPDATE_ON_MODIFIED();
		}
		// ※確認メッセージの表示
		// 保存確認のメッセージを表示する。※メッセージIDはmsgIDの値
		switch (msgID) {
		case ACMessageBox.RESULT_YES:
			// 「更新して戻る」選択時
			// 処理を継続する。
			break;

		case ACMessageBox.RESULT_NO:
			// 「破棄して戻る」選択時
			// 戻り用渡りパラメータに、下記の値を設定する。
			// KEY : NEXT_AFFAIR, VALUE : QC005
			parameters.setData("NEXT_AFFAIR", "QC005");
			// 前画面に戻る。
			return true;

		case ACMessageBox.RESULT_CANCEL:
			// 「キャンセル」選択時
			// 処理を中断する。
			return false;
		}

		// [2014年要望][Shinobu Hitaka] 2015/01/05 edit begin 居宅療養管理指導書の対象年月に複数登録対応
		//--del begin
//		// ※入力チェック
//		// 入力チェックを行う。
//		if (!checkValidInput()) {
//			// エラーがある場合
//			// 処理を中断する。
//			return false;
//		}
//		
//		// 2007/12/25 [Masahiko Higuchi] add - begin Ver 5.4.1対応
//		 印刷対象のものを確認する
//		if(isPrintFinish()){
//		    msgID = QkanMessageList.getInstance().QC005_WARNING_OF_PRINTED_KYOTAKU_RYOYO("居宅療養管理指導書");
//		    // 更新しない場合
//		    if(msgID != ACMessageBox.RESULT_YES){
//		        return false;
//		    }
//		}
//		// 2007/12/25 [Masahiko Higuchi] add - end        
//		
//		// エラーがない場合
//		// 処理を継続する。
//		// ※保存処理
//		// 保存処理を行う。
//		boolean saveState = false;
//		
//		if (getProcessMode() == QkanConstants.PROCESS_MODE_INSERT) {
//			saveState = doInsert();
//		} else {
//			saveState = doUpdate();
//		}
		//--del end
		//--add begin
		boolean saveState = doInsertOrUpdate(false);
		//--add end
		// [2014年要望][Shinobu Hitaka] 2015/01/05 edit end   居宅療養管理指導書の対象年月に複数登録対応
		
		if (!saveState) {
			// 保存処理が異常終了した場合
			// 処理を中断する。
			return false;
			// 保存処理が正常終了した場合
		} else {
			// 戻り用渡りパラメータに、下記の値を設定する。
			// KEY : NEXT_AFFAIR
			parameters.setData("NEXT_AFFAIR");
			// 前画面に戻る。

			// 前画面への遷移を許可するならばtrueを返す。
			return true;
		}
	}

	public boolean canClose() throws Exception {
		if (!super.canClose()) {
			return false;
		}

		// ※スナップショットチェック
		// スナップショットの更新チェックを行う。
		if (!getSnapshot().isModified()) {
			// 更新されていない場合
			// システムを終了する。
			return true;
		}

		// 更新されている場合
		// 処理を継続する。
		// ※終了確認
		// 終了確認のメッセージを表示する。
		// ※メッセージID = WARNING_OF_CLOSE_ON_MODIFIED
		int msgID = QkanMessageList.getInstance()
				.WARNING_OF_CLOSE_ON_MODIFIED();
		if (msgID == ACMessageBox.RESULT_OK) {
			// 「OK」選択時
			// システムを終了する。
			return true;
		} else {
			// 「キャンセル」選択時
			// 処理を中断する。
			return false;
		}
	}

	// コンポーネントイベント

	/**
	 * 「印刷処理」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void printActionPerformed(ActionEvent e) throws Exception {
		// ※スナップショットチェック
		// スナップショットの更新チェックを行う。
		if (getSnapshot().isModified()) {
			int msgID = 0;
			if (getProcessMode() == QkanConstants.PROCESS_MODE_INSERT) {
				msgID = QkanMessageList.getInstance().WARNING_OF_DO_PRINT("登録",
						"居宅療養管理指導書");
			} else {
				msgID = QkanMessageList.getInstance().WARNING_OF_DO_PRINT("更新",
						"居宅療養管理指導書");
			}

			switch (msgID) {
			case ACMessageBox.RESULT_OK:
				// 「OK」選択時
				// 処理を継続する。
				break;
			case ACMessageBox.RESULT_CANCEL:
				// 「キャンセル」選択時
				return;
			// 処理を中断する。
			}
        // 2007/12/25 [Masahiko Higuchi] add - begin Ver 5.4.1対応
        }
        boolean isPrinted = isPrintFinish();
        // 2007/12/25 [Masahiko Higuchi] add - end
        
			// [2014年要望][Shinobu Hitaka] 2015/01/05 edit begin 居宅療養管理指導書の対象年月に複数登録対応
			//--del begin
//			// ※入力チェック
//			// 入力チェックを行う。
//			if (!checkValidInput()) {
//				// エラーがある場合
//				// 処理を中断する。
//				return;
//			}
//			
//			// エラーがない場合
//			// 処理を継続する。
//			// ※保存処理
//			// 保存処理を行う。
//			boolean saveState = false;
//			
//			if (getProcessMode() == QkanConstants.PROCESS_MODE_INSERT) {
//				saveState = doInsert();
//			} else {
//				saveState = doUpdate();
//			}
			//--del end
			//--add begin
			// 完了メッセージを表示しない
        	boolean saveState = true;
			if (getSnapshot().isModified()) {
				saveState = doInsertOrUpdate(false);
				isPrinted = false;
	        }
			//--add end
			// [2014年要望][Shinobu Hitaka] 2015/01/05 edit end   居宅療養管理指導書の対象年月に複数登録対応

			if (!saveState) {
				// 保存処理が異常終了した場合
				// 処理を中断する。
				return;
			}
            
        // 2007/12/25 [Masahiko Higuchi] del - begin Ver 5.4.1対応
		//}
        // 2007/12/25 [Masahiko Higuchi] del - end            

		// ※印刷処理
		// kyotakuDataに、画面から抽出した情報を格納する。
		VRMap kyotakuData = getKyotakuData();

		getContents().setSource(kyotakuData);
		getContents().applySource();

        ACTextField[] shiftFields = new ACTextField[]{
               getVisitThisMonth1(),
               getVisitThisMonth2(),
               getVisitThisMonth3(),
               getVisitThisMonth4(),
               getVisitThisMonth5(),
               getVisitThisMonth6(),
        };
        int end = shiftFields.length;
        for(int i=0; i<end; i++){
            if(ACTextUtilities.isNullText(
                    VRBindPathParser.get(shiftFields[i].getBindPath(), kyotakuData))){
                //空欄があれば右方向へ走査
                boolean find=false;
                for(int j=i+1; j<end; j++){
                    Object obj =VRBindPathParser.get(shiftFields[j].getBindPath(), kyotakuData); 
                    if(!ACTextUtilities.isNullText(obj)){
                        //空欄以外データが見つかれば左へ転記
                        VRBindPathParser.set(shiftFields[i].getBindPath(), kyotakuData, obj);
                        VRBindPathParser.set(shiftFields[j].getBindPath(), kyotakuData, "");
                        find = true;
                        break;
                    }
                }
                if(!find){
                    //右方向に新規データがなければ処理終了
                    break;
                }
            }
        }
        shiftFields = new ACTextField[]{
                getVisitNextMonth1(),
                getVisitNextMonth2(),
                getVisitNextMonth3(),
                getVisitNextMonth4(),
                getVisitNextMonth5(),
                getVisitNextMonth6(),
         };
        end = shiftFields.length;
        for(int i=0; i<end; i++){
            if(ACTextUtilities.isNullText(
                    VRBindPathParser.get(shiftFields[i].getBindPath(), kyotakuData))){
                //空欄があれば右方向へ走査
                boolean find=false;
                for(int j=i+1; j<end; j++){
                    Object obj =VRBindPathParser.get(shiftFields[j].getBindPath(), kyotakuData); 
                    if(!ACTextUtilities.isNullText(obj)){
                        //空欄以外データが見つかれば左へ転記
                        VRBindPathParser.set(shiftFields[i].getBindPath(), kyotakuData, obj);
                        VRBindPathParser.set(shiftFields[j].getBindPath(), kyotakuData, "");
                        find = true;
                        break;
                    }
                }
                if(!find){
                    //右方向に新規データがなければ処理終了
                    break;
                }
            }
        }
        
		// 印刷クラスへの渡りパラメータ(レコード) printParamを生成する。
		VRMap printParam = null;

		// printParamに、kyotakuDataの値をコピーする。
		printParam = kyotakuData;

		// 印刷管理クラスを生成
		ACChotarouXMLWriter writer = new ACChotarouXMLWriter();

		// 印刷開始を宣言
		writer.beginPrintEdit();
		// printParam.setData()
		QC005P01 qc00501 = new QC005P01();
		// 印刷する。
		// doPrint(printParam);
		if (qc00501.doPrint(writer, printParam)) {
			// 生成された場合

		} else {
			// 生成されなかった場合
			return;
		}

        QC005P02 qc00502 = new QC005P02();
		if (qc00502.doPrint(writer, printParam)) {
			// 生成された場合
			// 印刷終了を制限
			writer.endPrintEdit();
			// PDFファイルを生成して開く
			ACChotarouXMLUtilities.openPDF(writer);

		} else {
			// 生成されなかった場合
			return;
		}
        
        
		//  2008/01/07 [Masahiko Higuchi] add - begin 居宅療養管理指導書一括印刷
        int msgID = ACMessageBox.RESULT_YES;
        // 登録時に印刷済みフラグの値がクリアされるので退避した設定値でチェックする。
        if(!isPrinted){
            // 印刷履歴の確定有無を確認
            msgID = QkanMessageList.getInstance().QP001_PRINT_COMMIT();
        }
        // 『はい』以外は処理終了
        if(msgID != ACMessageBox.RESULT_YES){
            return;
        }
        
        try{
            // トランザクションの開始
            getDBManager().beginTransaction();
            // パラメーターの設定
            VRMap sqlParam = new VRHashMap();
            sqlParam.setData("PATIENT_ID",ACCastUtilities.toInteger(getPatientID()));
            sqlParam.setData("TARGET_DATE",getTargetDate());
            sqlParam.setData("FINISH_FLAG",new Integer(1));
            // 印刷履歴の確定
            getDBManager().executeUpdate(getSQL_UPDATE_FINISH_FLAG(sqlParam));
            // コミット
            getDBManager().commitTransaction();
        }catch(Exception ex){
            ex.printStackTrace();
            // エラーの場合はロールバック
            getDBManager().rollbackTransaction();
            throw ex;
        }
        		//  2008/01/07 [Masahiko Higuchi] add - end
	}

	/**
	 * 「直近の居宅療養管理指導書情報の読込」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void openActionPerformed(ActionEvent e) throws Exception {
		// ※処理実行確認
		// 処理実行の確認のため、メッセージを表示する。※メッセージID =
		// QC001_WARNING_ON_READ_OF_MOST_NEW_DATA
		int msgID = QkanMessageList.getInstance()
				.QC001_WARNING_ON_READ_OF_MOST_NEW_DATA();

		switch (msgID) {
		case ACMessageBox.RESULT_OK:
			// 「OK」選択時
			// 処理を継続する。
			break;
		case ACMessageBox.RESULT_CANCEL:
			// 「キャンセル」選択時
			return;
		// 処理を中断する。
		}

		// ※過去の直近の情報を取得
		// SQL文取得関数への渡りパラメータ(レコード) sqlParamに下記パラメータを設定する。
		VRMap sqlParam = null;
		sqlParam = new VRHashMap();

		// KEY : PATIENT_ID, VALUE : patientID (退避した渡りパラメータ)
		sqlParam.setData("PATIENT_ID", new Integer(getPatientID()));
		// KEY : TARGET_DATE, VALUE : targetDate (退避した渡りパラメータ)
		// [2014年要望][Shinobu Hitaka] 2014/12/02 edit begin 居宅療養管理指導書の対象年月に複数登録対応
		//sqlParam.setData("TARGET_DATE", getTargetDate());
		sqlParam.setData("TARGET_DATE", ACDateUtilities.toLastDayOfMonth(getTargetDate()));
		// [2014年要望][Shinobu Hitaka] 2014/12/02 edit end   居宅療養管理指導書の対象年月に複数登録対応
		
		// 過去の直近の情報を取得するためのSQL文を取得する。
		// 取得したSQL文を発行する。
		VRList lastKyotakuData = getDBManager().executeQuery(
				getSQL_GET_LAST_KYOTAKU_RYOYO(sqlParam));

		// 取得件数が0件より多い場合
		if (lastKyotakuData.size() > 0) {
			// 取得レコード集合の1件目のレコードを退避する。
			VRMap lastKyotakuDataMap = new VRHashMap();
            
            // ※利用者情報をDBから取得
            // 対象利用者(利用者一覧で選択された利用者)の基本情報を取得する。
            VRList patientInfoList = QkanCommon.getPatientInfo(getDBManager(),
                    getPatientID());

            // 取得できなかった場合
            if (patientInfoList.size() <= 0) {
                // エラーメッセージを表示する。※メッセージID = ERROR_OF_PASSIVE_CHECK_ON_FIND
                QkanMessageList.getInstance().ERROR_OF_PASSIVE_CHECK_ON_FIND();
                // 「QU001 利用者一覧」画面に戻る。(処理を抜ける)
                // OKボタン押下時のイベント
                NoNinteiHistory = true;
                ACFrame.getInstance().back();
                return;
            } else {
                // 取得できた場合
                // 処理を継続する。
                // 取得したレコードをkyotakuDataに設定する。

                lastKyotakuDataMap.putAll((VRMap) patientInfoList.getData());

                // ※利用者氏名の取得
                // 利用者の姓・名を連結し、利用者のフルネームを取得する。
                // toFullName((kyotakuDataのKEY:PATIENT_FAMILY_NAMEのVALUE),
                // (kyotakuDataのKEY:PATIENT_FIRST_NAMEのVALUE);
                // kyotakuDataに下記の値を設定する。
                // KEY : PATIENT_NAME, VALUE : (取得した利用者フルネーム)

                lastKyotakuDataMap.setData("PATIENT_NAME", QkanCommon
                        .toFullName(VRBindPathParser.get("PATIENT_FAMILY_NAME",
                                lastKyotakuDataMap), VRBindPathParser.get(
                                "PATIENT_FIRST_NAME", lastKyotakuDataMap)));
            }

            // kyotakuDataの件数をチェックする。
            // 0件の場合
            // 要介護度の認定チェック
            VRList patientNinteiHistory = QkanCommon
                    .getPatientInsureInfoOnEndOfMonth(getDBManager(),
                            getTargetDate(), getPatientID());
            // [ID:0000508][Masahiko Higuchi] 2010/01 edit begin 2009年度対応
            if(patientNinteiHistory != null && patientNinteiHistory.size() >= 1){
                VRMap history = (VRMap)patientNinteiHistory.getData(0);
                // ※要介護度の取得
                Integer jotaiCode = ACCastUtilities.toInteger(history.getData("JOTAI_CODE"),0);
                // 利用者情報を優先するため利用者情報で上書き
                ((VRMap)lastKyotakuData.getData()).setData("JOTAI_CODE",jotaiCode);
                // [ID:0000508][Masahiko Higuchi] 2010/01 edit end
            } else {
                // [ID:0000508][Masahiko Higuchi] 2009/07 add begin 2009年度対応
                ((VRMap)lastKyotakuData.getData()).setData("JOTAI_CODE",new Integer(1));
                // [ID:0000508][Masahiko Higuchi] 2009/07 add end
            }
            
            
            //利用者情報取得後に上書きする形で取得する
            lastKyotakuDataMap = (VRMap) lastKyotakuData.getData();
            
            // [ID:0000595][Masahiko Higuchi] 2010/01 edit begin 2009年度対応
            //全てのテキストボックスが未入力である場合
            if (ACTextUtilities.isNullText(getVisitThisMonth1().getText())
            	&& ACTextUtilities.isNullText(getVisitThisMonth2().getText())
                && ACTextUtilities.isNullText(getVisitThisMonth3().getText())
                && ACTextUtilities.isNullText(getVisitThisMonth4().getText())
                && ACTextUtilities.isNullText(getVisitThisMonth5().getText())
                && ACTextUtilities.isNullText(getVisitThisMonth6().getText())) {
            	
    			// 来月の訪問予定の日付を今月の訪問日に設定する。
    			for (int i = 6; i < 12; i++) {
    				if (VRBindPathParser.get(VisitDayKey[i], lastKyotakuDataMap) != null) {
    					lastKyotakuDataMap.setData(
    						VisitDayKey[i - 6],
    						String.valueOf(ACDateUtilities.getDayOfMonth(ACCastUtilities.toDate(VRBindPathParser.get(VisitDayKey[i],lastKyotakuDataMap))))
    					);
    				} else {
    					lastKyotakuDataMap.setData(VisitDayKey[i - 6], "");
    				}
    			}
    			
    		//登録されている場合は、設定値を残す
            } else {
            	lastKyotakuDataMap.setData(VisitDayKey[0], getVisitThisMonth1().getText());
            	lastKyotakuDataMap.setData(VisitDayKey[1], getVisitThisMonth2().getText());
            	lastKyotakuDataMap.setData(VisitDayKey[2], getVisitThisMonth3().getText());
            	lastKyotakuDataMap.setData(VisitDayKey[3], getVisitThisMonth4().getText());
            	lastKyotakuDataMap.setData(VisitDayKey[4], getVisitThisMonth5().getText());
            	lastKyotakuDataMap.setData(VisitDayKey[5], getVisitThisMonth6().getText());
            }
            
            
            if (ACTextUtilities.isNullText(getVisitNextMonth1().getText())
                && ACTextUtilities.isNullText(getVisitNextMonth2().getText())
                && ACTextUtilities.isNullText(getVisitNextMonth3().getText())
                && ACTextUtilities.isNullText(getVisitNextMonth4().getText())
                && ACTextUtilities.isNullText(getVisitNextMonth5().getText())
                && ACTextUtilities.isNullText(getVisitNextMonth6().getText())) {
    			// 訪問日のキーに空を登録
    			for (int i = 6; i < 12; i++) {
    				lastKyotakuDataMap.setData(VisitDayKey[i], "");
    			}
            } else {
            	lastKyotakuDataMap.setData(VisitDayKey[6], getVisitNextMonth1().getText());
            	lastKyotakuDataMap.setData(VisitDayKey[7], getVisitNextMonth2().getText());
            	lastKyotakuDataMap.setData(VisitDayKey[8], getVisitNextMonth3().getText());
            	lastKyotakuDataMap.setData(VisitDayKey[9], getVisitNextMonth4().getText());
            	lastKyotakuDataMap.setData(VisitDayKey[10], getVisitNextMonth5().getText());
            	lastKyotakuDataMap.setData(VisitDayKey[11], getVisitNextMonth6().getText());
            }
            // [ID:0000595][Masahiko Higuchi] 2010/01 edit end

			// 対象年月を和暦に変換
			lastKyotakuDataMap.setData("TARGET_DATE", VRDateParser.format(
					getTargetDate(), "ggge年M月"));

			// ※○月のアドバイスの初期値の設定
			// lastKyotakuDataMapに下記の値を設定する。
			// KEY : ADVICE_MONTH, VALUE : targetDate (M)
			lastKyotakuDataMap.setData("ADVICE_MONTH", VRDateParser.format(
					getTargetDate(), "M"));
            
            //主治医氏名をラベルに印字
            if(lastKyotakuDataMap.getData("DOCTOR_NAME") != null){
                String doctorName = ACCastUtilities.toString(lastKyotakuDataMap
                        .getData("DOCTOR_NAME"));
                //主治医氏名を設定
                getYourDoctor().setText(doctorName);
            }
            
            
            //データ移行対応
            //法改正前のデータについては利用者情報のバインドを行わない。
            Date defaultDate = ACCastUtilities.toDate("2006/05/01");
            if(ACDateUtilities.compareOnDay(getTargetDate(),defaultDate) < 0){
                lastKyotakuDataMap.removeData("PATIENT_ADDRESS");
                lastKyotakuDataMap.removeData("PATIENT_TEL_FIRST");
                lastKyotakuDataMap.removeData("PATIENT_TEL_SECOND");
                lastKyotakuDataMap.removeData("PATIENT_TEL_THIRD");
            }
            

			// contentsパネルのsourceとして、退避したレコードを設定する。
			getContents().setSource(lastKyotakuDataMap);

			// bindSourceを実行し、退避したレコードの値をcontentsパネルに展開する。
			getContents().bindSource();
            
			// 取得件数が0件の場合
			// 過去情報が存在しなかったことを通知するメッセージを表示する。
		} else {
			QkanMessageList.getInstance().QC001_NOTICE_HAS_NO_LAST_DATA();
			// データの上書は行わない。
		}
	}

	/**
	 * 「登録処理」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void insertActionPerformed(ActionEvent e) throws Exception {
		// [2014年要望][Shinobu Hitaka] 2015/01/05 edit begin 居宅療養管理指導書の対象年月に複数登録対応
		//--del begin
//		// ※データをDBに登録
//		// ※入力チェック
//		// 入力チェックを行う。
//		if (!checkValidInput()) {
//			// エラーがある場合
//			// 処理を中断する。
//			return;
//		}
//		// エラーがない場合
//		// 処理を継続する。
//		// ※登録処理
//		// 登録処理を行う。
//        //処理が正常終了した場合
//		if(doInsert()){
//            // 処理完了通知メッセージを表示する。※メッセージID = UPDATE_SUCCESSED
//            QkanMessageList.getInstance().INSERT_SUCCESSED();
//        }else{
//            return;
//        }
		//--del end
		//--add begin
		doInsertOrUpdate(true);
		//--add end
		// [2014年要望][Shinobu Hitaka] 2015/01/05 edit end   居宅療養管理指導書の対象年月に複数登録対応

	}

	/**
	 * 「更新処理」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void updateActionPerformed(ActionEvent e) throws Exception {
		// [2014年要望][Shinobu Hitaka] 2015/01/05 edit begin 居宅療養管理指導書の対象年月に複数登録対応
		//--del begin
//		// ※データをDBに更新
//		// ※入力チェック
//		// 入力チェックを行う。
//		if (!checkValidInput()) {
//
//			// エラーがある場合
//			// 処理を中断する。
//			return;
//		}
//        
//        // 2007/12/25 [Masahiko Higuchi] add - begin Ver 5.4.1対応
//        // 印刷対象のものを確認する
//        if(isPrintFinish()){
//            int msgID = QkanMessageList.getInstance().QC005_WARNING_OF_PRINTED_KYOTAKU_RYOYO("居宅療養管理指導書");
//            // 更新しない場合
//            if(msgID != ACMessageBox.RESULT_YES){
//                return;
//            }
//        }
//        // 2007/12/25 [Masahiko Higuchi] add - end
//        
//		// エラーがない場合
//		// 処理を継続する。
//		// ※更新処理
//		// 更新処理を行う。
//        //正常に終了した場合
//		if(doUpdate()){
//            // 処理完了通知メッセージを表示する。※メッセージID = UPDATE_SUCCESSED
//            QkanMessageList.getInstance().UPDATE_SUCCESSED();
//        }else{
//            return;
//        }
		//--del end
		//--add begin
		doInsertOrUpdate(true);
		//--add end
		// [2014年要望][Shinobu Hitaka] 2015/01/05 edit end   居宅療養管理指導書の対象年月に複数登録対応

	}

	/**
	 * 「「あなたの主治医」の設定」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void doctorNameFocusLost(FocusEvent e) throws Exception {
		// 画面の「あなたの主治医(yourDoctorName)」に、doctorNameの値を設定する。
		getYourDoctor().setText(getDoctorName().getText());
	}

	public static void main(String[] args) {
		// デフォルトデバッグ起動
		try {
			VRHashMap param = new VRHashMap();
			param.setData("PATIENT_ID", "1");
			param.setData("TARGET_DATE", new Date(106, 02, 01));
			ACFrame.setVRLookAndFeel();
			ACFrame.getInstance().setFrameEventProcesser(
					new QkanFrameEventProcesser());
			QkanCommon.debugInitialize();
			ACAffairInfo affair = new ACAffairInfo(QC005.class.getName(), param);
			ACFrame.debugStart(affair);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 内部関数

	/**
	 * 「ウィンドウタイトルの設定」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public void doInitialize() throws Exception {
		// ※ウィンドウタイトルの設定
		// 業務情報レコードを取得する。
		// ウィンドウタイトルに、取得レコードのKEY : WINDOW_TITLEのVALUEを設定する。
		// 業務ボタンバーのテキストに、取得レコードのKEY : AFFAIR_TITLEのVALUEを設定する。
		setAffairTitle("QC005", "0", getButtons());
		setPASSIVE_CHECK_KEY(new ACPassiveKey("KYOTAKU_RYOYO", new String[] {
				"PATIENT_ID", "TARGET_DATE" }, new Format[] { null,
				new ACSQLSafeDateFormat("yyyy/M/d") }, "LAST_TIME", "LAST_TIME"));
        
		// [ID:0000547][Masahiko Higuchi] 2009/08 add begin 2009年度要望対応
        Object obj = getCreateDateZaitaku().getParent();
        // 親がラベルコンテナなら子の有効状態と連動する
        if(obj instanceof ACLabelContainer) {
            ((ACLabelContainer)obj).setVisible(getCreateDateZaitaku().isVisible());
        }
        // [ID:0000547][Masahiko Higuchi] 2009/08 add begin 2009年度要望対応

		// 要介護度に初期値設定
		getJotaiCode().setSelectedIndex(1);
		
		// ※コンボのアイテムの初期設定
		// コンボアイテム設定用のレコード comboItemMap を生成する。
		VRMap comboItemMap = new VRHashMap();

		// ※医療機関名(medicalInstitusion)
		// 医療機関取得用のSQL文を取得する。
		// 取得したSQL文を発行する。
		VRList ListMedicalInstitusion = getDBManager().executeQuery(
				getSQL_GET_MEDICAL_FACIRITY(null));

		// 取得したレコード集合を、comboItemMap の KEY : MEDICAL_INSTITUSIONS の VALUE
		// として設定する。
		comboItemMap.setData("MEDICAL_INSTITUSIONS", ListMedicalInstitusion);

		// ※事業所名
		// 事業所情報を取得する。
		VRList ListProvider = QkanCommon.getProviderInfo(getDBManager());

		// 取得したレコード集合を、comboItemMap の KEY : PROVIDER_NAMES の VALUE として設定する。
		comboItemMap.setData("PROVIDER_NAMES", ListProvider);

        
        VRMap sqlParam = new VRHashMap();
        sqlParam.setData("PATIENT_ID",new Integer(getPatientID()));

        
		// ※modelの展開
		// 「ステーション情報領域(stations)」のmodelとして、comboItemMapを設定する。
		getContents().setModelSource(comboItemMap);

		// 「ステーション情報領域(stations)」にmodelを展開する。
		getContents().bindModelSource();
        //バインド用のMap
        VRMap bindMap = new VRHashMap();

        //ログイン事業所とコンボ内の選択肢で一致しているレコードを取得する
		VRMap providerMap = ACCommon.getInstance().getMatchRowFromValue(ListProvider,
                "PROVIDER_ID",
                QkanSystemInformation.getInstance().getLoginProviderID());
        //コンボ選択肢の選択候補を
        int index = ACCommon.getInstance().getMatchIndexFromValue(ListProvider,
                "PROVIDER_ID",
                QkanSystemInformation.getInstance().getLoginProviderID());
        
        // [ID:0000519][Masahiko Higuchi] 2009/07 add begin 2009年度対応
        // ※利用者情報をDBから取得
        // 対象利用者(利用者一覧で選択された利用者)の基本情報を取得する。
        VRList patientInfoList = QkanCommon.getPatientInfo(getDBManager(),
                getPatientID());
        // 格納用変数
        VRMap patientMap = new VRHashMap();
        patientMap = (VRMap)patientInfoList.getData();
        // 住所を個別設定する。
        bindMap.put("PATIENT_ADDRESS", ACCastUtilities.toString(patientMap.getData("PATIENT_ADDRESS"),""));
        // [ID:0000519][Masahiko Higuchi] 2009/07 add end
        
        if(providerMap != null){
            bindMap.putAll(providerMap);
        }
        getContents().setSource(bindMap);
        getContents().bindSource();
        
        if(index >= 0){
            getProviderName().setSelectedIndex(index);
        }
        
	}

	/**
	 * 「居宅療養管理指導書情報の設定」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public void doFind() throws Exception {
		// ※DBから居宅療養管理指導書情報を取得
		// sqlへの渡りパラメータ(レコード) sqlParamを生成する。
		VRMap sqlParam = new VRHashMap();
		VRMap kyotakuDataMap = new VRHashMap();
		VRMap bindMap = new VRHashMap();
        
        // ※利用者情報をDBから取得
        // 対象利用者(利用者一覧で選択された利用者)の基本情報を取得する。
        VRList patientInfoList = QkanCommon.getPatientInfo(getDBManager(),
                getPatientID());
        
        VRMap patientMap = new VRHashMap();
        patientMap = (VRMap)patientInfoList.getData();
        
        // 取得できなかった場合
        if (patientInfoList.size() <= 0) {
            // エラーメッセージを表示する。※メッセージID = ERROR_OF_PASSIVE_CHECK_ON_FIND
            QkanMessageList.getInstance().ERROR_OF_PASSIVE_CHECK_ON_FIND();
            // 「QU001 利用者一覧」画面に戻る。(処理を抜ける)
            // OKボタン押下時のイベント
            NoNinteiHistory = true;
            ACFrame.getInstance().back();
            return;
        } else {
            // 取得できた場合
            // 処理を継続する。
            // 取得したレコードをkyotakuDataに設定する。

            bindMap.putAll(patientMap);

            // ※利用者氏名の取得
            // 利用者の姓・名を連結し、利用者のフルネームを取得する。
            // toFullName((kyotakuDataのKEY:PATIENT_FAMILY_NAMEのVALUE),
            // (kyotakuDataのKEY:PATIENT_FIRST_NAMEのVALUE);
            // kyotakuDataに下記の値を設定する。
            // KEY : PATIENT_NAME, VALUE : (取得した利用者フルネーム)

            bindMap.setData("PATIENT_NAME", QkanCommon
                    .toFullName(VRBindPathParser.get("PATIENT_FAMILY_NAME",
                            patientMap), VRBindPathParser.get(
                            "PATIENT_FIRST_NAME", patientMap)));
        }

        // kyotakuDataの件数をチェックする。
        // 0件の場合
        // 要介護度の認定チェック
        VRList patientNinteiHistory = QkanCommon
                .getPatientInsureInfoOnEndOfMonth(getDBManager(),
                        getTargetDate(), getPatientID());
            
        if(!(patientNinteiHistory == null || patientNinteiHistory.size() == 0)){
            // ※要介護度の取得
            // 利用者情報レコードのKEY:JOTAI_CODEのVALUEを、要介護度を表す文字列に変換する。
            // kyotakuDataに下記の値を設定する。
            // KEY : YOKAIGODO
            patientMap.putAll((VRMap)patientNinteiHistory.getData());
            bindMap.setData("JOTAI_CODE",patientMap.getData("JOTAI_CODE"));
            
        }
        
        
        
		// sqlParamに下記の値を設定する。
		// KEY : PATIENT_ID, VALUE : patientID (退避した値)
		// KEY : TARGET_DATE, VALUE : targetDate (退避した値)
		sqlParam.setData("PATIENT_ID", String.valueOf(getPatientID()));
		sqlParam.setData("TARGET_DATE", getTargetDate());

		// 居宅療養管理指導書情報取得用のSQL文を取得する。
		// 取得したSQL文を発行し、結果をkyotakuDataに追加する。
		VRList kyotakuList = getDBManager().executeQuery(
				getSQL_GET_KYOTAKU_RYOYO(sqlParam));

		// kyotakuDataの件数をチェックする。
		// 0件の場合
		if (kyotakuList.size() <= 0) {
			// processModeにPROCESS_MODE_INSERTを設定する。(登録モード)
			setProcessMode(QkanConstants.PROCESS_MODE_INSERT);
			// 登録ボタンを表示する。
			setState_PROCESS_MODE_INSERT();
			// kyotakuDataをcontentsパネルに設定し、createSourceを実行する。
			// kyotakuDataの初期値を設定する。
			setKyotakuData((VRMap) getContents().createSource());
            //初期値を取得
			setInitValue();
            
			kyotakuDataMap.putAll(getKyotakuData());

			// 0件より多い場合
		} else {
			// processModeにPROCESS_MODE_UPDATEを設定する。(更新モード)
			setProcessMode(QkanConstants.PROCESS_MODE_UPDATE);
			// 更新ボタンを表示する。
			setState_PROCESS_MODE_UPDATE();
			// resultDataに、取得したレコード集合の1件目のレコードの値を追加する。
			kyotakuDataMap.putAll((VRMap) kyotakuList.getData());

			// 対象年月を和暦に変換
			kyotakuDataMap.setData("TARGET_DATE", VRDateParser.format(
					ACCastUtilities.toDate(VRBindPathParser.get("TARGET_DATE",
							kyotakuDataMap)), "ggge年M月"));

			// 医師名ラベルに貼付
			kyotakuDataMap.setData("YOUR_DOCTOR_NAME", VRBindPathParser.get(
					"DOCTOR_NAME", kyotakuDataMap));

			// 今月の訪問日と来月の訪問予定の日付を取得する。
			for (int i = 0; i < 12; i++) {
				if (VRBindPathParser.get(VisitDayKey[i], kyotakuDataMap) != null) {
					kyotakuDataMap.setData(VisitDayKey[i], String
							.valueOf(ACDateUtilities
									.getDayOfMonth(ACCastUtilities
											.toDate(VRBindPathParser.get(
													VisitDayKey[i],
													kyotakuDataMap)))));
				}
			}
			
			// パッシブキーを登録する。
			// reservedPassive(PASSIVE_CHECK_KEY, (取得したレコード集合));
			getPassiveChecker().clearReservedPassive();

			getPassiveChecker().reservedPassive(getPASSIVE_CHECK_KEY(),
					kyotakuList);

		}
        
        //バインド用のMapとマージする
        bindMap.putAll(kyotakuDataMap);
		// contentsパネルのsourceとして、kyotakuDataを設定する。
		getContents().setSource(bindMap);
		// bindSourceを実行し、kyotakuDataの値をcontentsパネルに展開する。
		getContents().bindSource();

		// スナップショットを撮影する。
		getSnapshot().snapshot();
	}

	/**
	 * 「初期値の設定」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public void setInitValue() throws Exception {
		// ※作成年月の初期値の設定
		// kyotakuDataに下記の値を設定する。
		// KEY : CREATE_DATE_ZAITAKU, VALUE : targetDate (ggge年M月)
		VRMap kyotakuDataMap = null;
		kyotakuDataMap = new VRHashMap();

		kyotakuDataMap.setData("TARGET_DATE", VRDateParser.format(
				getTargetDate(), "ggge年M月"));
		kyotakuDataMap.setData("CREATE_DATE_ZAITAKU", getTargetDate());

		// ※○月のアドバイスの初期値の設定
		// kyotakuDataに下記の値を設定する。
		// KEY : ADVICE_MONTH, VALUE : targetDate (M)
		kyotakuDataMap.setData("ADVICE_MONTH", VRDateParser.format(
				getTargetDate(), "M"));


		// ※作成年月日の初期値の設定
		// システムから、「システム日付」を取得する。
		Date systemDate = QkanSystemInformation.getInstance().getSystemDate();

		// kyotakuDataに下記の値を設定する。
		// KEY : CREATE_DATE_KYOTAKU, VALUE : (取得したシステム日付)
		kyotakuDataMap.setData("CREATE_DATE_KYOTAKU", systemDate);

		// ※事業所コンボの初期選択値の設定
		// ログイン事業所IDを取得する。
		String loginProvider = QkanSystemInformation.getInstance()
				.getLoginProviderID();

		// ログイン事業所情報を設定する。
		VRList loginProviderName = QkanCommon.getProviderInfo(getDBManager(),
				loginProvider);

		// 画面の事業所名(providerName)に、ログイン事業所名を設定する。
		kyotakuDataMap.setData("PROVIDER_NAME", VRBindPathParser.get(
				"PROVIDER_NAME", (VRMap) loginProviderName.getData()));
        
        // [ID:0000431][Masahiko Higuchi] 2009/07 add begin 実績読込(V5.4.9)
        // サービス実績より提供日を取得
        VRMap serviceResult = getKyotakuResult();
        // 初期値として設定
        kyotakuDataMap.putAll(serviceResult);
        // [ID:0000431][Masahiko Higuchi] 2009/07 add end
        
		setKyotakuData(kyotakuDataMap);
	}

	/**
	 * 「保存処理」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public boolean doInsert() throws Exception {
		// ※パッシブチェック
		// ※パッシブチェックのための準備
		// kyotakuDataに、画面から抽出した情報を格納する。
		VRMap kyotakuDataMap = null;
		kyotakuDataMap = new VRHashMap();
		kyotakuDataMap = getKyotakuData();

		// DBマネージャー定義
		ACDBManager dbm = getDBManager();

		try {
			// トランザクション開始
			dbm.beginTransaction();

			getContents().setSource(kyotakuDataMap);
			getContents().applySource();

			// kyotakuDataに下記の値を設定する。
			// KEY : PATIENT_ID, VALUE : patientID (退避した渡りパラメータ)
			// KEY : TARGET_DATE, VALUE : targetDate (退避した渡りパラメータ)
			kyotakuDataMap
					.setData("PATIENT_ID", String.valueOf(getPatientID()));
			kyotakuDataMap.setData("TARGET_DATE", getTargetDate());

			// 訪問日のHashMap変換
			if (!getVisitThisMonth1().getText().equals("")) {
				kyotakuDataMap.setData("VISIT_THIS_MONTH_NO1", ACCastUtilities
						.toDate(VRDateParser.format(getTargetDate(), "yyyy/MM")
								+ "/" + getVisitThisMonth1().getText()));
			}
			if (!getVisitThisMonth2().getText().equals("")) {
				kyotakuDataMap.setData("VISIT_THIS_MONTH_NO2", ACCastUtilities
						.toDate(VRDateParser.format(getTargetDate(), "yyyy/MM")
								+ "/" + getVisitThisMonth2().getText()));
			}
			if (!getVisitThisMonth3().getText().equals("")) {
				kyotakuDataMap.setData("VISIT_THIS_MONTH_NO3", ACCastUtilities
						.toDate(VRDateParser.format(getTargetDate(), "yyyy/MM")
								+ "/" + getVisitThisMonth3().getText()));
			}
			if (!getVisitThisMonth4().getText().equals("")) {
				kyotakuDataMap.setData("VISIT_THIS_MONTH_NO4", ACCastUtilities
						.toDate(VRDateParser.format(getTargetDate(), "yyyy/MM")
								+ "/" + getVisitThisMonth4().getText()));
			}
			if (!getVisitThisMonth5().getText().equals("")) {
				kyotakuDataMap.setData("VISIT_THIS_MONTH_NO5", ACCastUtilities
						.toDate(VRDateParser.format(getTargetDate(), "yyyy/MM")
								+ "/" + getVisitThisMonth5().getText()));
			}
			if (!getVisitThisMonth6().getText().equals("")) {
				kyotakuDataMap.setData("VISIT_THIS_MONTH_NO6", ACCastUtilities
						.toDate(VRDateParser.format(getTargetDate(), "yyyy/MM")
								+ "/" + getVisitThisMonth6().getText()));
			}

			// 来月の訪問日のHashMap変換
			// 来月の値
			Date nextMonth = ACDateUtilities.addMonth(getTargetDate(), 1);
			
			if (!getVisitNextMonth1().getText().equals("")) {
				kyotakuDataMap.setData("VISIT_NEXT_MONTH_NO1", ACCastUtilities
						.toDate(VRDateParser.format(nextMonth, "yyyy/MM") + "/"
								+ getVisitNextMonth1().getText()));
			}
			if (!getVisitNextMonth2().getText().equals("")) {
				kyotakuDataMap.setData("VISIT_NEXT_MONTH_NO2", ACCastUtilities
						.toDate(VRDateParser.format(nextMonth, "yyyy/MM") + "/"
								+ getVisitNextMonth2().getText()));
			}
			if (!getVisitNextMonth3().getText().equals("")) {
				kyotakuDataMap.setData("VISIT_NEXT_MONTH_NO3", ACCastUtilities
						.toDate(VRDateParser.format(nextMonth, "yyyy/MM") + "/"
								+ getVisitNextMonth3().getText()));
			}
			if (!getVisitNextMonth4().getText().equals("")) {
				kyotakuDataMap.setData("VISIT_NEXT_MONTH_NO4", ACCastUtilities
						.toDate(VRDateParser.format(nextMonth, "yyyy/MM") + "/"
								+ getVisitNextMonth4().getText()));
			}
			if (!getVisitNextMonth5().getText().equals("")) {
				kyotakuDataMap.setData("VISIT_NEXT_MONTH_NO5", ACCastUtilities
						.toDate(VRDateParser.format(nextMonth, "yyyy/MM") + "/"
								+ getVisitNextMonth5().getText()));
			}
			if (!getVisitNextMonth6().getText().equals("")) {
				kyotakuDataMap.setData("VISIT_NEXT_MONTH_NO6", ACCastUtilities
						.toDate(VRDateParser.format(nextMonth, "yyyy/MM") + "/"
								+ getVisitNextMonth6().getText()));
			}

			// SQL取得関数への渡しパラメータ(レコード) sqlParamを生成する。
			// VRMap sqlParam = null;

			// パッシブタスクをクリアする。
			getPassiveChecker().clearPassiveTask();

			// ※パッシブタスクの登録
			// processModeの値をチェックする。

			// レコード集合 kyotakuDataList を生成し、レコード kyotakuData を追加する。
			VRList kyotakuDataList = null;
			kyotakuDataList = new VRArrayList();

			kyotakuDataList.add(getKyotakuData());

			// 居宅療養管理指導書情報のパッシブキーを登録する。
			// パッシブキーを登録する。
			// reservedPassive(PASSIVE_CHECK_KEY, (取得したレコード集合));
			// 居宅療養管理指導書情報追加用のパッシブタスクを登録する。
			getPassiveChecker().addPassiveInsertTask(getPASSIVE_CHECK_KEY(),
					kyotakuDataList);

			// ※パッシブチェックの実行
			// パッシブチェックを実行する。
			if (!getPassiveChecker().passiveCheck(dbm)) {
				// パッシブエラーがある場合
				// パッシブエラーメッセージを表示する。※メッセージID = ERROR_OF_PASSIVE_CHECK_ON_UPDATE
				QkanMessageList.getInstance()
						.ERROR_OF_PASSIVE_CHECK_ON_UPDATE();

				// 処理をロールバックする。
				dbm.rollbackTransaction();
				// 処理を中断する。(異常終了)
				return false;
			}

			// パッシブエラーがない場合
			// 処理を継続する。
			// ※在宅療養生活のポイント・居宅療養管理指導書情報の登録
			// processModeの値をチェックする。
			// 居宅療養管理指導書情報登録用のSQL文を取得する。
			// 取得したSQL文を発行する。
			dbm.executeUpdate(getSQL_INSERT_KYOTAKU_RYOYO(kyotakuDataMap));

			// ※コミット/ロールバック
			// 上記一連のSQL発行処理でエラーがなかった場合
			dbm.commitTransaction();
			// 処理をコミットする。
			// 画面の初期化を行う。
			doInitialize();

			// 検索処理を行う。
			doFind();

			// 処理を終了する。(正常終了)
			return true;

		} catch (Exception sqlEx) {
			// SQL発行処理でエラーがあった場合
			// 処理をロールバックする。
			sqlEx.printStackTrace();

			dbm.rollbackTransaction();
			// 処理を中断する。(異常終了)
			throw sqlEx;
		}
	}

	/**
	 * 「保存処理」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public boolean doUpdate() throws Exception {
		// ※パッシブチェック
		// ※パッシブチェックのための準備
		// kyotakuDataに、画面から抽出した情報を格納する。
		VRMap kyotakuDataMap = null;
		kyotakuDataMap = new VRHashMap();
		kyotakuDataMap = getKyotakuData();

		// DBマネージャー定義
		ACDBManager dbm = getDBManager();

		try {
			// トランザクション開始
			dbm.beginTransaction();

			getContents().setSource(kyotakuDataMap);
			getContents().applySource();

			// kyotakuDataに下記の値を設定する。
			// KEY : PATIENT_ID, VALUE : patientID (退避した渡りパラメータ)
			// KEY : TARGET_DATE, VALUE : targetDate (退避した渡りパラメータ)
			kyotakuDataMap
					.setData("PATIENT_ID", String.valueOf(getPatientID()));
			kyotakuDataMap.setData("TARGET_DATE", getTargetDate());

			// 訪問日のHashMap変換
			if (!getVisitThisMonth1().getText().equals("")) {
				kyotakuDataMap.setData("VISIT_THIS_MONTH_NO1", ACCastUtilities
						.toDate(VRDateParser.format(getTargetDate(), "yyyy/MM")
								+ "/" + getVisitThisMonth1().getText()));
			}
			if (!getVisitThisMonth2().getText().equals("")) {
				kyotakuDataMap.setData("VISIT_THIS_MONTH_NO2", ACCastUtilities
						.toDate(VRDateParser.format(getTargetDate(), "yyyy/MM")
								+ "/" + getVisitThisMonth2().getText()));
			}
			if (!getVisitThisMonth3().getText().equals("")) {
				kyotakuDataMap.setData("VISIT_THIS_MONTH_NO3", ACCastUtilities
						.toDate(VRDateParser.format(getTargetDate(), "yyyy/MM")
								+ "/" + getVisitThisMonth3().getText()));
			}
			if (!getVisitThisMonth4().getText().equals("")) {
				kyotakuDataMap.setData("VISIT_THIS_MONTH_NO4", ACCastUtilities
						.toDate(VRDateParser.format(getTargetDate(), "yyyy/MM")
								+ "/" + getVisitThisMonth4().getText()));
			}
			if (!getVisitThisMonth5().getText().equals("")) {
				kyotakuDataMap.setData("VISIT_THIS_MONTH_NO5", ACCastUtilities
						.toDate(VRDateParser.format(getTargetDate(), "yyyy/MM")
								+ "/" + getVisitThisMonth5().getText()));
			}
			if (!getVisitThisMonth6().getText().equals("")) {
				kyotakuDataMap.setData("VISIT_THIS_MONTH_NO6", ACCastUtilities
						.toDate(VRDateParser.format(getTargetDate(), "yyyy/MM")
								+ "/" + getVisitThisMonth6().getText()));
			}

			// 来月の訪問日のHashMap変換
			if (!getVisitNextMonth1().getText().equals("")) {
				kyotakuDataMap.setData("VISIT_NEXT_MONTH_NO1", ACCastUtilities
						.toDate(VRDateParser.format(ACDateUtilities.addMonth(
								getTargetDate(), 1), "yyyy/MM")
								+ "/" + getVisitNextMonth1().getText()));
			}
			if (!getVisitNextMonth2().getText().equals("")) {
				kyotakuDataMap.setData("VISIT_NEXT_MONTH_NO2", ACCastUtilities
						.toDate(VRDateParser.format(ACDateUtilities.addMonth(
								getTargetDate(), 1), "yyyy/MM")
								+ "/" + getVisitNextMonth2().getText()));
			}
			if (!getVisitNextMonth3().getText().equals("")) {
				kyotakuDataMap.setData("VISIT_NEXT_MONTH_NO3", ACCastUtilities
						.toDate(VRDateParser.format(ACDateUtilities.addMonth(
								getTargetDate(), 1), "yyyy/MM")
								+ "/" + getVisitNextMonth3().getText()));
			}
			if (!getVisitNextMonth4().getText().equals("")) {
				kyotakuDataMap.setData("VISIT_NEXT_MONTH_NO4", ACCastUtilities
						.toDate(VRDateParser.format(ACDateUtilities.addMonth(
								getTargetDate(), 1), "yyyy/MM")
								+ "/" + getVisitNextMonth4().getText()));
			}
			if (!getVisitNextMonth5().getText().equals("")) {
				kyotakuDataMap.setData("VISIT_NEXT_MONTH_NO5", ACCastUtilities
						.toDate(VRDateParser.format(ACDateUtilities.addMonth(
								getTargetDate(), 1), "yyyy/MM")
								+ "/" + getVisitNextMonth5().getText()));
			}
			if (!getVisitNextMonth6().getText().equals("")) {
				kyotakuDataMap.setData("VISIT_NEXT_MONTH_NO6", ACCastUtilities
						.toDate(VRDateParser.format(ACDateUtilities.addMonth(
								getTargetDate(), 1), "yyyy/MM")
								+ "/" + getVisitNextMonth6().getText()));
			}

			// SQL取得関数への渡しパラメータ(レコード) sqlParamを生成する。
			// VRMap sqlParam = new VRHashMap();
			// パッシブタスクをクリアする。
			getPassiveChecker().clearPassiveTask();
			// ※パッシブタスクの登録
			// processModeの値をチェックする。
			// 居宅療養管理指導書情報更新用のパッシブタスクを登録する。
			getPassiveChecker().addPassiveUpdateTask(getPASSIVE_CHECK_KEY());

			// ※パッシブチェックの実行
			// パッシブチェックを実行する。
			if (!getPassiveChecker().passiveCheck(dbm)) {
				// パッシブエラーがある場合
				// パッシブエラーメッセージを表示する。※メッセージID = ERROR_OF_PASSIVE_CHECK_ON_UPDATE
				QkanMessageList.getInstance()
						.ERROR_OF_PASSIVE_CHECK_ON_UPDATE();

				// 処理をロールバックする。
				dbm.rollbackTransaction();
				// 処理を中断する。(異常終了)
				return false;
			}

			// パッシブエラーがない場合
			// 処理を継続する。
			// ※在宅療養生活のポイント・居宅療養管理指導書情報の登録
			// 居宅療養管理指導書情報更新用のSQL文を取得する。
			// 取得したSQL文を発行する。
			dbm.executeUpdate(getSQL_UPDATE_KYOTAKU_RYOYO(kyotakuDataMap));

			// ※コミット/ロールバック
			// 上記一連のSQL発行処理でエラーがなかった場合
			// 処理をコミットする。
			dbm.commitTransaction();
			// 画面の初期化を行う。
			doInitialize();

			// 検索処理を行う。
			doFind();

			// 処理を終了する。(正常終了)
			return true;
		} catch (Exception sqlEx) {
			// SQL発行処理でエラーがあった場合
			// 処理をロールバックする。
			sqlEx.printStackTrace();

			dbm.rollbackTransaction();
			// 処理を中断する。(異常終了)
			throw sqlEx;
		}
	}

	/**
	 * 「入力チェック」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public boolean checkValidInput() throws Exception {
		// ※入力チェック

        // [ID:0000547][Masahiko Higuchi] 2009/08 del begin 2009年度要望対応
//		// ※作成年月・未入力チェック
//		// 画面の「作成年月(createDateZaitaku)」の値をチェックする。
//		if (!ACTextUtilities.isNullText(getCreateDateZaitaku().getText())) {
//			// 入力されている場合
//			// 処理を継続する。
//		} else {
//			// 未入力の場合
//			// エラーメッセージを表示する。
//			QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT("作成年月");
//			// createDateZaitakuにフォーカスを当てる。
//            getTabsArea().setSelectedIndex(1);
//			getCreateDateZaitaku().requestFocus();
//
//			// 戻り値としてfalseを返し、処理を中断する。
//			return false;
//		}
//
//		// ※作成年月・不正チェック
//		// 画面の「作成年月(createDateZaitaku)」の値をチェックする。
//		if (getCreateDateZaitaku().isValidDate()) {
//			// 正常値の場合
//			// 処理を継続する。
//		} else {
//			// 異常値の場合
//			// エラーメッセージを表示する。
//			QkanMessageList.getInstance().ERROR_OF_WRONG_DATE("作成年月の");
//			// createDateZaitakuにフォーカスを当てる。
//            getTabsArea().setSelectedIndex(1);
//			getCreateDateZaitaku().requestFocus();
//			// 戻り値としてfalseを返し、処理を中断する。
//			return false;
//		}
        // [ID:0000547][Masahiko Higuchi] 2009/08 del end

		// ※作成年月日・未入力チェック
		// 画面の「作成年月日(createDateKyotaku)」の値をチェックする。
		if (!ACTextUtilities.isNullText(getCreateDateKyotaku().getText())) {
			// 入力されている場合
			// 処理を継続する。
		} else {
			// 未入力の場合
			// エラーメッセージを表示する。
			QkanMessageList.getInstance()
					.ERROR_OF_NEED_CHECK_FOR_INPUT("作成年月日");

			// createDateKyotakuにフォーカスを当てる。
            getTabsArea().setSelectedIndex(2);
            getKyotakuPoints().setSelectedIndex(0);
			getCreateDateKyotaku().requestFocus();
			// 戻り値としてfalseを返し、処理を中断する。
			return false;
		}

		// ※作成年月日・不正チェック
		// 画面の「作成年月日(createDateKyotaku)」の値をチェックする。
		if (getCreateDateKyotaku().isValidDate()) {
			// 正常値の場合
			// 処理を継続する。
		} else {
			// 異常値の場合
			// エラーメッセージを表示する。
			QkanMessageList.getInstance().ERROR_OF_WRONG_DATE("作成年月日の");

			// createDateKyotakuにフォーカスを当てる。
            getTabsArea().setSelectedIndex(2);
            getKyotakuPoints().setSelectedIndex(0);
			getCreateDateKyotaku().requestFocus();
			// 戻り値としてfalseを返し、処理を中断する。
			return false;
		}

		// [2014年要望][Shinobu Hitaka] 2015/01/05 add begin 居宅療養管理指導書の対象年月に複数登録対応
		// ※作成年月日・不正チェック（対象年月と異なる作成年月の場合）
		// 画面の「作成年月日(createDateKyotaku)」の値をチェックする。
		String strCreateDateYM = VRDateParser.format(getCreateDateKyotaku().getDate(), "yyyy/MM");
		String strTargetDateYM = VRDateParser.format(getTargetDate(), "yyyy/MM");
		if (strCreateDateYM.compareTo(strTargetDateYM) == 0) {
			// 正常値の場合
			// 処理を継続する。
		} else {
			// 異常値の場合
			// ワーニングメッセージを表示する。
		    if (QkanMessageList.getInstance().QC005_WARNING_OF_CREATE_DATE() != ACMessageBox.RESULT_OK) {
				// createDateKyotakuにフォーカスを当てる。
	            getTabsArea().setSelectedIndex(2);
	            getKyotakuPoints().setSelectedIndex(0);
				getCreateDateKyotaku().requestFocus();
				// 戻り値としてfalseを返し、処理を中断する。
				return false;
		    }
		}
		// [2014年要望][Shinobu Hitaka] 2015/01/05 add end   居宅療養管理指導書の対象年月に複数登録対応
		
		// ※今月の訪問日1・不正チェック
		// 画面の「今月の訪問日1(visitThisMonth1)」の値が入力されているかチェックする。
		if (ACTextUtilities.isNullText(getVisitThisMonth1().getText())) {
			// 入力されていない場合
			// 何も行わない。
		} else {
			// 入力されている場合

			// 画面の「今月の訪問日1(visitThisMonth1)」を日、対象年月を年、及び月とした日付を作成する。
			if (VRDateParser.isValid(VRDateParser.format(getTargetDate(),
					"yyyy/MM")
					+ "/" + getVisitThisMonth1().getText())) {
				// 正常値の場合
				// 処理を継続する。
			} else {
				// 異常値の場合
				// エラーメッセージを表示する。
				QkanMessageList.getInstance().ERROR_OF_WRONG_DATE("今月の訪問日の");
				// visitThisMonth1にフォーカスを当てる。
                getTabsArea().setSelectedIndex(1);
				getVisitThisMonth1().requestFocus();
				// 戻り値としてfalseを返し、処理を中断する。
				return false;
			}
		}
		// ※今月の訪問日2～6・不正チェック
		// 「今月の訪問日1」と同様のチェックを、「今月の訪問日2～6」に対して行う。
		if (ACTextUtilities.isNullText(getVisitThisMonth2().getText())) {
			// 入力されていない場合 何も行わない。
		} else {
			// 入力されている場合
			if (VRDateParser.isValid(VRDateParser.format(getTargetDate(),
					"yyyy/MM")
					+ "/" + getVisitThisMonth2().getText())) {
				// 正常値の場合 処理を継続する。
			} else {
				// 異常値の場合 エラーメッセージを表示する。
				QkanMessageList.getInstance().ERROR_OF_WRONG_DATE("今月の訪問日の");
                getTabsArea().setSelectedIndex(1);
				getVisitThisMonth2().requestFocus();
				return false;
			}
		}
		if (ACTextUtilities.isNullText(getVisitThisMonth3().getText())) {
			// 入力されていない場合 何も行わない。
		} else {
			// 入力されている場合
			if (VRDateParser.isValid(VRDateParser.format(getTargetDate(),
					"yyyy/MM")
					+ "/" + getVisitThisMonth3().getText())) {
				// 正常値の場合 処理を継続する。
			} else {
				// 異常値の場合
				QkanMessageList.getInstance().ERROR_OF_WRONG_DATE("今月の訪問日の");
                getTabsArea().setSelectedIndex(1);
                getVisitThisMonth3().requestFocus();
				return false;
			}
		}
		if (ACTextUtilities.isNullText(getVisitThisMonth4().getText())) {
			// 入力されていない場合
		} else {
			// 入力されている場合
			if (VRDateParser.isValid(VRDateParser.format(getTargetDate(),
					"yyyy/MM")
					+ "/" + getVisitThisMonth4().getText())) {
				// 正常値の場合
			} else {
				// 異常値の場合
				QkanMessageList.getInstance().ERROR_OF_WRONG_DATE("今月の訪問日の");
                getTabsArea().setSelectedIndex(1);
                getVisitThisMonth4().requestFocus();
				return false;
			}
		}
		if (ACTextUtilities.isNullText(getVisitThisMonth5().getText())) {
			// 入力されていない場合
		} else {
			// 入力されている場合
			if (VRDateParser.isValid(VRDateParser.format(getTargetDate(),
					"yyyy/MM")
					+ "/" + getVisitThisMonth5().getText())) {
				// 正常値の場合
			} else {
				// 異常値の場合
				QkanMessageList.getInstance().ERROR_OF_WRONG_DATE("今月の訪問日の");
                getTabsArea().setSelectedIndex(1);
                getVisitThisMonth5().requestFocus();
				return false;
			}
		}
		if (ACTextUtilities.isNullText(getVisitThisMonth6().getText())) {
			// 入力されていない場合
		} else {
			// 入力されている場合
			if (VRDateParser.isValid(VRDateParser.format(getTargetDate(),
					"yyyy/MM")
					+ "/" + getVisitThisMonth6().getText())) {
				// 正常値の場合
			} else {
				// 異常値の場合
				QkanMessageList.getInstance().ERROR_OF_WRONG_DATE("今月の訪問日の");
                getTabsArea().setSelectedIndex(1);
                getVisitThisMonth6().requestFocus();
				return false;
			}
		}
		// ※来月の訪問予定1・不正チェック
		// 画面の「来月の訪問予定1(visitNextMonth1)」の値が入力されているかチェックする。
		if (ACTextUtilities.isNullText(getVisitNextMonth1().getText())) {
			// 入力されていない場合
			// 何も行わない。
		} else {
			// 入力されている場合
			// 画面の「来月の訪問予定1(visitNextMonth1)」を日、対象年月の翌月を年、及び月とした日付を作成する。

			if (VRDateParser.isValid(VRDateParser.format(ACDateUtilities
					.addMonth(getTargetDate(), 1), "yyyy/MM")
					+ "/" + getVisitNextMonth1().getText())) {
				// 正常値の場合
				// 処理を継続する。
			} else {
				// 異常値の場合
				// エラーメッセージを表示する。
				QkanMessageList.getInstance().ERROR_OF_WRONG_DATE("来月の訪問予定の");
				// visitNextMonth1にフォーカスを当てる。
                getTabsArea().setSelectedIndex(1);
                getVisitNextMonth1().requestFocus();
				// 戻り値としてfalseを返し、処理を中断する。
				return false;
			}
		}

		// ※来月の訪問予定2～6・不正チェック
		// 「来月の訪問予定1」と同様のチェックを、「来月の訪問予定2～6」に対して行う。
		if (ACTextUtilities.isNullText(getVisitNextMonth2().getText())) {
			// 入力されていない場合
		} else {
			if (VRDateParser.isValid(VRDateParser.format(ACDateUtilities
					.addMonth(getTargetDate(), 1), "yyyy/MM")
					+ "/" + getVisitNextMonth2().getText())) {
				// 正常値の場合 処理を継続する。
			} else {
				// 異常値の場合 エラーメッセージを表示する。
				QkanMessageList.getInstance().ERROR_OF_WRONG_DATE("来月の訪問予定の");
                getTabsArea().setSelectedIndex(1);
                getVisitNextMonth2().requestFocus();
				return false;
			}
		}
		if (ACTextUtilities.isNullText(getVisitNextMonth3().getText())) {
			// 入力されていない場合
		} else {
			if (VRDateParser.isValid(VRDateParser.format(ACDateUtilities
					.addMonth(getTargetDate(), 1), "yyyy/MM")
					+ "/" + getVisitNextMonth3().getText())) {
				// 正常値の場合 処理を継続する。
			} else {
				// 異常値の場合 エラーメッセージを表示する。
				QkanMessageList.getInstance().ERROR_OF_WRONG_DATE("来月の訪問予定の");
                getTabsArea().setSelectedIndex(1);
                getVisitNextMonth3().requestFocus();
				return false;
			}
		}
		if (ACTextUtilities.isNullText(getVisitNextMonth4().getText())) {
			// 入力されていない場合
		} else {
			if (VRDateParser.isValid(VRDateParser.format(ACDateUtilities
					.addMonth(getTargetDate(), 1), "yyyy/MM")
					+ "/" + getVisitNextMonth4().getText())) {
				// 正常値の場合 処理を継続する。
			} else {
				// 異常値の場合 エラーメッセージを表示する。
				QkanMessageList.getInstance().ERROR_OF_WRONG_DATE("来月の訪問予定の");
                getTabsArea().setSelectedIndex(1);
                getVisitNextMonth4().requestFocus();
				return false;
			}
		}
		if (ACTextUtilities.isNullText(getVisitNextMonth5().getText())) {
			// 入力されていない場合
		} else {
			if (VRDateParser.isValid(VRDateParser.format(ACDateUtilities
					.addMonth(getTargetDate(), 1), "yyyy/MM")
					+ "/" + getVisitNextMonth5().getText())) {
				// 正常値の場合 処理を継続する。
			} else {
				// 異常値の場合 エラーメッセージを表示する。
				QkanMessageList.getInstance().ERROR_OF_WRONG_DATE("来月の訪問予定の");
                getTabsArea().setSelectedIndex(1);
                getVisitNextMonth5().requestFocus();
				return false;
			}
		}
		if (ACTextUtilities.isNullText(getVisitNextMonth6().getText())) {
			// 入力されていない場合
		} else {
			// if (VRDateParser.isValid(VRDateParser.format(getTargetDate(),
			// "yyyy/MM")
			// + "/" + getVisitNextMonth6().getText())) {
			// // 正常値の場合 処理を継続する。
			// } else {
			// // 異常値の場合 エラーメッセージを表示する。
			// QkanMessageList.getInstance().ERROR_OF_WRONG_DATE("来月の訪問予定の");
			// getVisitNextMonth6().requestFocus();
			// return false;
			// }
			// 入力されている場合
			if (VRDateParser.isValid(VRDateParser.format(ACDateUtilities
					.addMonth(getTargetDate(), 1), "yyyy/MM")
					+ "/" + getVisitNextMonth6().getText())) {
				// 正常値の場合 処理を継続する。
			} else {
				// 異常値の場合 エラーメッセージを表示する。
				QkanMessageList.getInstance().ERROR_OF_WRONG_DATE("来月の訪問予定の");
                getTabsArea().setSelectedIndex(1);
                getVisitNextMonth6().requestFocus();
				return false;
			}
		}
		return true;
	}
	
    /**
     * 医療機関情報連動表示に関する処理
     */
    protected void medicalInstitusionActionPerformed(ActionEvent e) throws Exception {
        // 内部変数 medicalMapを生成する
        VRMap medicalMap = new VRHashMap();
        // 選択された医療機関情報のレコードを取得する。
        Object obj = getMedicalInstitusion().getSelectedModelItem();
        // 取得したレコードを medicalMap に格納する
        if(obj != null){
            medicalMap = (VRMap)obj;
        // medicalMap を providerAndMedicaiInfoArea(医療機関情報領域）に設定する。
            getProviderAndMedicaiInfoArea().setSource(medicalMap);
        //      設定した情報を画面に展開する。
            getProviderAndMedicaiInfoArea().bindSource();
        }
    }
    
    /**
     * 事業所コンボ選択時の処理
     */
    protected void providerNameActionPerformed(ActionEvent e) throws Exception {
        //Mapを生成
        VRMap comboItemMap = new VRHashMap();
        //現在選択中のコンボからレコードを取得
        comboItemMap = (VRMap)getProviderName().getSelectedModelItem();
        
        if(comboItemMap != null){
            //介護支援専門員を取得
            VRList senmoninList = getDBManager().executeQuery(
                    getSQL_GET_CARE_MANAGER(comboItemMap));
            
            if(senmoninList != null && senmoninList.size() > 0){
                for(int i = 0; i < senmoninList.size(); i++){
                    VRMap map = new VRHashMap();
                    map = (VRMap)senmoninList.getData(i);
                    //専門員の名前を取得し姓名を結合する。
                    map.setData("STAFF_NAME", QkanCommon.toFullName(
                            ACCastUtilities.toString(map
                                    .getData("STAFF_FAMILY_NAME")),
                            ACCastUtilities.toString(map
                                    .getData("STAFF_FIRST_NAME"))));
                }
            }
            //バインドパスを設定
            comboItemMap.setData("SENMONIN",senmoninList);
            //画面に展開
            getSenmonin().setModelSource(comboItemMap);
            getSenmonin().bindModelSource();
        }
        
    }
    /**
     * データの印刷済みの有無をチェックして返します。
     * 
     * @return True：印刷済み
     * @author Masahiko Higuchi
     * @since Ver 5.4.1  
     */
    public boolean isPrintFinish() throws Exception {
        // パラメーターの設定
        VRMap sqlParam = new VRHashMap();
        VRBindPathParser.set("PATIENT_ID",sqlParam,ACCastUtilities.toInteger(getPatientID()));
        VRBindPathParser.set("TARGET_DATE",sqlParam,getTargetDate());
        // SQL発行
        VRList resultList = getDBManager().executeQuery(getSQL_GET_FINISH_FLAG(sqlParam));
        
        if(resultList != null && !resultList.isEmpty()){
            VRMap result = (VRMap)resultList.getData(0);
            // 取得する。
            int index = ACCastUtilities.toInt(result.getData("FINISH_FLAG"),0);
            // 印刷済みの場合
            if(index == 1){
                return true;
            }
        }

        return false;
    }

    /**
     * 当月の居宅療養管理指導の実績データを読み込み画面展開用に整形します。
     * 
     * [ID:0000431]
     * @return 画面展開用実績データ
     * @author Masahiko Higuchi
     * @since Ver.5.4.9
     */
    public VRMap getKyotakuResult() throws Exception {
        // 返却用のマップ
        VRMap returnResult = new VRHashMap();
        // SQL文用の値を設定する。
        Date firstDate =  ACDateUtilities.toFirstDayOfMonth(getTargetDate());
        Date lastDate =  ACDateUtilities.toLastDayOfMonth(getTargetDate());
        VRMap sqlParam = new VRHashMap();
        VRBindPathParser.set("PATIENT_ID", sqlParam, ACCastUtilities.toInteger(getPatientID()));
        VRBindPathParser.set("TARGET_DATE_START", sqlParam, firstDate);
        VRBindPathParser.set("TARGET_DATE_END", sqlParam, lastDate);
        // 実績取得
        VRList resultList = getDBManager().executeQuery(getSQL_GET_SERVICE_RESULT_DATA(sqlParam));
        
        if(resultList != null && !resultList.isEmpty()){
            // ループしつつ展開用のデータに整形する
            for(int i=0; i < resultList.size(); i++){
                VRMap map = (VRMap)resultList.getData(i);
                // 6個以上は設定不能なのでスキップ
                if(i==6) {
                    break;
                }
                // 整形処理
                VRBindPathParser.set("VISIT_THIS_MONTH_NO"
                        + ACCastUtilities.toString(i + 1), returnResult, map.getData("EXTRACT_SERVICE_DAY"));                
            }
            // 取得できたデータ以外は空でレコードを生成
            for (int j = 1; j <= 6; j++) {
                String bindKey = "VISIT_THIS_MONTH_NO"
                        + ACCastUtilities.toString(j);
                if (!returnResult.containsKey(bindKey)) {
                    VRBindPathParser.set(bindKey, returnResult, "");
                }
            }
        }
        // 値の返却
        return returnResult;
    }

    /**
     * 実績読込みボタン押下時の処理
     * 
     * [ID:0000431]
     * @author Masahiko Higuchi
     * @since Ver.5.4.9
     */
    protected void resultReadButtonActionPerformed(ActionEvent e) throws Exception {

        VRDateFormat vf = new VRDateFormat("ggge年M月");
        // メッセージ構築
        String message = String.valueOf(vf.format(getTargetDate()) + "度");
        String serviceName = "居宅療養管理指導";
        // メッセージ取得
        int msgID = QkanMessageList.getInstance().WARNING_OF_RESULT_SERVICE(
                message, serviceName);
        if (msgID == ACMessageBox.RESULT_YES) {
            // 実績取得
            VRMap result = getKyotakuResult();
            // 取得できない場合はメッセージ
            if(result == null || result.isEmpty()) {
                QkanMessageList.getInstance().ERROR_OF_RESULT_READ_NOTHING(serviceName);
                return;
            }
            // 画面展開処理
            getContents().setSource(result);
            getContents().bindSource();
        }
        
    }

    /**
     * 「居宅療養管理指導書情報取得」に関する処理を行ないます。
     * 利用者と対象年月から入力した作成年月日情報が存在するかをチェックします。
     * @throws Exception
     *             処理例外
     * @author Shinobu Hitaka
     * @since Ver.6.2.3
     */
    protected Date getUpdateTargetDate() throws Exception {
    	
    	Date targetDate = null;
    	
        // 居宅療養管理指導履歴情報取得を行う。

        // 取得のためにHashMap：paramを生成し、以下のKEY/VALUEを設定する。
        VRMap sqlParam = new VRHashMap();

        // KEY：PATIENT_ID　VALUE：patientId
        VRBindPathParser.set("PATIENT_ID", sqlParam,
                new Integer(getPatientID()));
        // KEY：TARGET_DATE_START VALUE：targetDate の月初
        sqlParam.setData("TARGET_DATE_START",
                ACDateUtilities.toFirstDayOfMonth(getTargetDate()));
        // KEY：TARGET_DATE_START VALUE：targetDate の月末
        sqlParam.setData("TARGET_DATE_END",
                ACDateUtilities.toLastDayOfMonth(getTargetDate()));

		// kyotakuDataに、画面から抽出した情報を格納する。
        VRMap kyotakuData = getKyotakuData();
		getContents().setSource(kyotakuData);
		getContents().applySource();
		
        // CREATE_DATE_KYOTAKU VALUE：createDate
        sqlParam.setData("CREATE_DATE_KYOTAKU",
        		kyotakuData.getData("CREATE_DATE_KYOTAKU"));

        // 居宅療養管理指導履歴情報を取得し存在有無を返す。
        String strSql = getSQL_GET_KYOTAKU_RYOYO_CREATEDATE(sqlParam);
        VRList kyotakuList = getDBManager().executeQuery(strSql);
        
        if(kyotakuList != null && kyotakuList.size() > 0){
            for(int i = 0; i < kyotakuList.size(); i++){
                VRMap map = new VRHashMap();
                map = (VRMap)kyotakuList.getData(i);
                //キーとなる対象年月日を取得する
                targetDate = ACCastUtilities.toDate(map.getData("TARGET_DATE"));
            }
            if (getProcessMode() == QkanConstants.PROCESS_MODE_INSERT) {
    			// パッシブキーを登録する。
    			// reservedPassive(PASSIVE_CHECK_KEY, (取得したレコード集合));
    			getPassiveChecker().clearReservedPassive();
    			getPassiveChecker().reservedPassive(getPASSIVE_CHECK_KEY(), kyotakuList);
            }
        }
        
        return targetDate;
    }
    
    /**
     * 「居宅療養管理指導書情報取得」に関する処理を行ないます。
     * 利用者と対象年月から入力した作成年月日情報が存在するかをチェックします。
     * @throws Exception
     *             処理例外
     * @author Shinobu Hitaka
     * @since Ver.6.2.3
     */
    protected Date getInsertTargetDate() throws Exception {
        // 新規登録用の対象年月日を取得する
    	
        // 居宅療養管理指導履歴情報取得を行う。

        // 取得のためにHashMap：paramを生成し、以下のKEY/VALUEを設定する。
        VRMap sqlParam = new VRHashMap();

        // KEY：PATIENT_ID　VALUE：patientId
        VRBindPathParser.set("PATIENT_ID", sqlParam,
                new Integer(getPatientID()));
        // KEY：TARGET_DATE_START VALUE：targetDate の月初
        sqlParam.setData("TARGET_DATE_START",
                ACDateUtilities.toFirstDayOfMonth(getTargetDate()));
        // KEY：TARGET_DATE_START VALUE：targetDate の月末
        sqlParam.setData("TARGET_DATE_END",
                ACDateUtilities.toLastDayOfMonth(getTargetDate()));

        // 居宅療養管理指導履歴情報を取得し存在有無を返す。
        String strSql = getSQL_GET_KYOTAKU_RYOYO_CREATEDATE(sqlParam);
        VRList kyotakuList = getDBManager().executeQuery(strSql);
        
        // 登録されていない日付を取得する。
        int maxDay = ACDateUtilities.getDayOfMonth(ACDateUtilities.toLastDayOfMonth(getTargetDate()));
        int targetDay = 1;
        int cnt = 0;
        
        // 対象年月日の最大＋１を取得する
        if(kyotakuList != null && kyotakuList.size() > 0){
            for(int i = 0; i < kyotakuList.size(); i++){
                //キーとなる対象年月日を取得する
                int listDay = ACDateUtilities.getDayOfMonth(
                        ACCastUtilities.toDate(VRBindPathParser.get("TARGET_DATE", (VRMap) kyotakuList.getData(i))));
                if (listDay > targetDay) {
                	targetDay = listDay;
                }
            }
	        targetDay = targetDay + 1;
	    	
	    	// 月末を超えたら途中の登録されていない日を探す
	    	if (targetDay > maxDay) {
		    	targetDay = 1;
		    	cnt = 0;
		        for (cnt = 1; cnt <= maxDay; cnt++) {
		        	boolean findFlg = false;
		        	for(int i = 0; i < kyotakuList.size(); i++){
		                int listDay = ACDateUtilities.getDayOfMonth(
		                        ACCastUtilities.toDate(VRBindPathParser.get("TARGET_DATE", (VRMap) kyotakuList.getData(i))));
		                if (listDay == cnt) {
		                	findFlg = true;
		                    break;
		                }
		            }
		        	if (!findFlg) {
		        		break;
		        	}
		        }
		        targetDay = cnt;
	    	}
        }
        
        // 対象月の日数分を最大登録可能件数とするため、それ以上は新規登録できない。
        if (targetDay > maxDay) {
            return null;
        } else {
        	Date targetDate = ACDateUtilities.createDate(
                    ACDateUtilities.getYear(getTargetDate()), ACDateUtilities.getMonth(getTargetDate()), targetDay);
        	return targetDate;
        }

    }

    /**
     * 「居宅療養管理指導書情報登録または更新」に関する処理を行ないます。
     * 利用者と対象年月から入力した作成年月日情報が存在するかをチェックします。
     * 　存在する場合　：更新確認画面を表示し、更新処理を行います。
     * 　存在しない場合：新規登録処理を行います。
     * ※一覧から遷移した時の状態に関わらず、作成年月日の有無で処理を決定します。
	 * @param bDispMsg 完了メッセージ表示有無（true:表示／false:非表示）
     * @throws Exception
     *             処理例外
     * @author Shinobu Hitaka
     * @since Ver.6.2.3
     */
    protected boolean doInsertOrUpdate(boolean bDispMsg) throws Exception {
    	
		// ※データをDBに更新
		// ※入力チェック
		// 入力チェックを行う。
		if (!checkValidInput()) {

			// エラーがある場合
			// 処理を中断する。
			return false;
		}
        
		//同じ対象年月、作成年月日の情報存在チェック
		Date wkTargetDate = getUpdateTargetDate();
		if(wkTargetDate != null) {
			//現在編集中の情報は確認画面を表示しない
			if(ACDateUtilities.compareOnDay(getTargetDate(),wkTargetDate) != 0) {
				//更新
				//更新確認画面を表示する。
				int msgID = QkanMessageList.getInstance().QC005_WARNING_OF_HISTORY_KYOTAKU_RYOYO();
				if(msgID != ACMessageBox.RESULT_YES){
					// 更新しない場合
					return false;
				}
				
				//対象年月日を更新用に設定する
				setTargetDate(wkTargetDate);
				setProcessMode(QkanConstants.PROCESS_MODE_UPDATE);
				
			}
			// 印刷完了を確認する
			if(isPrintFinish()){
				int msgID = QkanMessageList.getInstance().QC005_WARNING_OF_PRINTED_KYOTAKU_RYOYO("居宅療養管理指導書");
				// 更新しない場合
				if(msgID != ACMessageBox.RESULT_YES){
					return false;
				}
			}
		} else {
			//新規
			//対象年月日を新規用に設定する
			wkTargetDate = getInsertTargetDate();
			if (wkTargetDate != null) {
				setTargetDate(wkTargetDate);
				setProcessMode(QkanConstants.PROCESS_MODE_INSERT);
			}else{
				QkanMessageList.getInstance().QC005_ERROR_OF_MAX_KYOTAKU_RYOYO();
				return false;
			}
		}
		
		// エラーがない場合
		// 処理を継続する。
		// ※更新処理
		// 更新処理を行う。
        //正常に終了した場合
		if (getProcessMode() == QkanConstants.PROCESS_MODE_INSERT) {
			if(doInsert()){
				// 処理完了通知メッセージを表示する。※メッセージID = UPDATE_SUCCESSED
				if (bDispMsg == true) {
					QkanMessageList.getInstance().INSERT_SUCCESSED();
				}
			}else{
				return false;
			}
		} else {
			if(doUpdate()){
				// 処理完了通知メッセージを表示する。※メッセージID = UPDATE_SUCCESSED
				if (bDispMsg == true) {
					QkanMessageList.getInstance().UPDATE_SUCCESSED();
				}
			}else{
				return false;
			}
		}
		
		return true;
    }
    

}
