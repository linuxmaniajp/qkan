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
 * 作成日: 2006/01/23  日本コンピューター株式会社 堤 瑞樹 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム メニュー (M)
 * プロセス ログイン画面 (001)
 * プログラム ログイン画面 (QM001)
 *
 *****************************************************************
 */

package jp.or.med.orca.qkan.affair.qm.qm001;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

import jp.nichicom.ac.ACConstants;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.core.version.ACVersionAdjuster;
import jp.nichicom.ac.io.ACPropertyXML;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.sql.ACDBManager;
import jp.nichicom.ac.sql.ACLoggerDBManager;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.bridge.sql.BridgeFirebirdDBManager;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.nichicom.vr.util.logging.VRLogger;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.QkanConstants;
import jp.or.med.orca.qkan.QkanSystemInformation;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.affair.QkanMessageList;
import jp.or.med.orca.qkan.affair.QkanVersionAdjustmentListener;
import jp.or.med.orca.qkan.affair.qm.qm002.QM002;
import jp.or.med.orca.qkan.affair.qo.qo002.QO002;
import jp.or.med.orca.qkan.affair.qo.qo004.QO004;
import jp.or.med.orca.qkan.affair.qo.qo005.QO005;
import jp.or.med.orca.qkan.affair.qu.qu002.QU002;
import jp.or.med.orca.qkan.affair.qv.qv001.QV001;

/**
 * ログイン画面(QM001)
 */
public class QM001 extends QM001Event {

	/**
	 * コンストラクタです。
	 */
	public QM001() {
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
		// エラーなし
		final int NO_ERROR = 0;
		// DB接続エラー
		final int DB_ERROR = 1;
		// 自事業所なし
		final int NO_PROVIDER = 2;
		// 保険者なし
		final int NO_INSURER = 4;
		// 利用者なし
		final int NO_PATIENT = 8;
		// PDFビューワなし
		final int NOT_FOUND_PDF_VIEWER = 16;
		// システムバージョン不正
		final int SYSTEM_VERSION_ERROR = 32;
		// DBMSバージョン不正
		final int DBMS_VERSION_ERROR = 64;
		// DBバージョン不正
		final int DB_MASTER_VERSION_ERROR = 128;
		int errorFlag = NO_ERROR;

		//メインメニューキャッシュをクリア
        QkanSystemInformation.getInstance().setMenuTree(null);
        
		// システム日付をセット
		Date systemDate = QkanSystemInformation.getInstance().getSystemDate();
		VRMap map = new VRHashMap();
		map.setData("SYSTEM_DATE", systemDate);
		getCombos().setSource(map);
		getCombos().bindSource();

        boolean properityReloaded = false; 
        ACPropertyXML xml=ACFrame.getInstance().getPropertyXML();
        if(xml!=null){
            //設定ファイルを再読み込みする。
            try{
                xml.read();
                properityReloaded = true;
            }catch(Exception ex){
                VRLogger.info(ex);
            }
        }
		String systemVersion = "取得失敗";
		// 設定ファイル(QkanPropertyXML.xml)のプロパティ「Version/no」を取得する。
		if (properityReloaded && ACFrame.getInstance().hasProperty("Version/no")) {
			// 取得できた場合
			// システムの「システムバージョン」に、取得した値を設定する。
			systemVersion = getProperty("Version/no");
			setState_VALID_VERSION();
		} else {
			// 取得できなかった場合
			errorFlag |= SYSTEM_VERSION_ERROR;
			setState_INVALID_VERSION();
		}
        // システムの「システムバージョン」に、「取得失敗」を設定する。
        QkanSystemInformation.getInstance().setSystemVersion(systemVersion);

		String dbmsVersion = "unknown";
		String schemeVersion = "取得失敗";
		String masterDataVersion = "取得失敗";
		if (errorFlag == NO_ERROR) {
			// DBの接続チェックを行う。
			if (getDBManager().canConnect()) {
				// 成功した場合
				// 次処理へ。

				ACDBManager dbm = getDBManager();
				if (dbm instanceof ACLoggerDBManager) {
					dbm = ((ACLoggerDBManager) dbm).getAdaptee();
				}
				if (dbm instanceof BridgeFirebirdDBManager) {
					try {
						dbmsVersion = ((BridgeFirebirdDBManager) dbm)
								.getDBMSVersion();
					} catch (Exception ex) {
					}
				}
				if (("unknown".equals(dbmsVersion))
						|| (dbmsVersion.indexOf("Firebird 1.0") >= 0)) {
					errorFlag |= DBMS_VERSION_ERROR;
					setState_INVALID_DBMS();
				} else {
					setState_VALID_DB();
				}
			} else {
				// 失敗した場合
				errorFlag |= DB_ERROR;
				setState_INVALID_DB_CONNECTION();
			}

			if (errorFlag == NO_ERROR) {
                //モジュールの対象バージョンに合わせてデータベースを整形する。
                try{
                    new ACVersionAdjuster().adjustment(getDBManager(),
                        "version/update.xml",
                        new QkanVersionAdjustmentListener(getDBManager()));
                    systemVersion = QkanSystemInformation.getInstance().getSystemVersion();
                }catch(Exception ex){
                    VRLogger.info(ex);
                }
                
                
				// 給付管理台帳システムバージョン情報取得用のSQL文を取得する。
				// getSQL_GET_QKAN_VERSION(null);
				// 取得したSQL文を発行する。
				VRList versionList = getDBManager().executeQuery(
						getSQL_GET_QKAN_VERSION(null));

				// 取得件数が0件より多い場合
				if (versionList.size() > 0) {
					// システムの「マスタデータバージョン」に、取得したマスタデータバージョンを設定する。
					// setMasterDataVersion((マスターデータバージョン));
					masterDataVersion = ACCastUtilities
							.toString(VRBindPathParser.get(
									"MASTER_DATA_VERSION", (VRMap) versionList
											.getData()));

					// システムにマスタデータバージョンを退避する。
					// setSchemeVersion((スキーマバージョン));
					schemeVersion = ACCastUtilities.toString(VRBindPathParser
							.get("SCHEME_VERSION", (VRMap) versionList
									.getData()));

				} else {
					// 取得件数が0件の場合
					errorFlag |= DB_MASTER_VERSION_ERROR;
					setState_INVALID_MASTER_VERSION();
				}
			}
		}

        // 画面の「システムバージョン(systemVersion)」に、「取得失敗」を設定する。
        getSystemVersion().setText(systemVersion);
		// システムの「マスタデータバージョン」に、取得したマスタデータバージョンを設定する。
		// setMasterDataVersion((マスターデータバージョン));
		QkanSystemInformation.getInstance().setMasterDataVersion(
				masterDataVersion);
		// システムにマスタデータバージョンを退避する。
		// setSchemeVersion((スキーマバージョン));
		QkanSystemInformation.getInstance().setSchemeVersion(schemeVersion);

		if (errorFlag == NO_ERROR) {
			// コードマスタ取得用のSQL文を取得する。
			// getSQL_GET_MASTER_CODE(null);
			// 取得したSQL文を発行する。
			VRList masterCodeList = getDBManager().executeQuery(
					getSQL_GET_MASTER_CODE(null));
			// 取得件数が0件より多い場合
			if (masterCodeList.size() > 0) {
				// システムの「コードマスタ」に設定するための形式に変換する。
				// ・CODE_ID毎にArrayListに格納する。
				// ・KEY : CODE_ID, VALUE : CODE_ID毎のレコード集合
				// として、レコードに格納する。
				// システムの「コードマスタ」に、変換したレコードを格納する。
				// setCodeMaster((変換したレコード));
				VRMap fullCodeM = new VRHashMap();
				Integer lastKey = null;
				VRList codeM = null;
				Iterator it = masterCodeList.iterator();
				while (it.hasNext()) {
					VRMap row = (VRMap) it.next();
					Integer key = Integer.valueOf(String
							.valueOf(VRBindPathParser.get("CODE_ID", row)));
					if (key != null) {
						if (!key.equals(lastKey)) {
							codeM = new VRArrayList();
							fullCodeM.setData(key, codeM);
							lastKey = key;
						}
						codeM.addData(row);
					}
				}
				// コードマスタをシステム共通に設定
				QkanSystemInformation.getInstance().setMasterCode(fullCodeM);

			} else {
				// 取得件数が0件の場合
				// システムの「コードマスタ」に、空のレコードを格納する。
				// setCodeMaster((空のレコード));
				QkanSystemInformation.getInstance().setMasterCode(null);
			}

			// 業務情報レコードを取得する。
			// ウィンドウタイトルに、取得レコードのKEY : WINDOW_TITLEのVALUEを設定する。
			// 業務ボタンバーのテキストに、取得レコードのKEY : AFFAIR_TITLEのVALUEを設定する。
			setAffairTitle("QM001");

			// 「事業所一覧(providerList)」に設定する自事業所一覧取得用のSQL文を取得する。
			// getSQL_GET_MY_PROVIDER(null);
			// 取得したSQL文を発行する。
			VRList providerList = getDBManager().executeQuery(
					getSQL_GET_MY_PROVIDER(null));

			// レコード数が0件より多い場合
			if (providerList.size() > 0) {
				// コンボアイテム設定用のレコード comboItemMap を生成する。
				VRMap comboItemMap = new VRHashMap();
				// 取得したレコード集合を、comboItemMap の KEY : PROVIDER_LISTS の
				// VALUE
				// として設定する。
				comboItemMap.setData("PROVIDER_LISTS", providerList);

				// 「コンボ領域(combos)」のmodelとして、comboItemMapを設定する。
				getContents().setModelSource(comboItemMap);

				// 「コンボ領域(combos)」にmodelを展開する。
				getContents().bindModelSource();

				// 取得したリストの一番上を選択状態にする。
				getProviderList().setSelectedIndex(0);

				setState_VALID_PROVIDER();
			} else {
				// レコード数が0件の場合

				setState_INVALID_PROVIDER();
				errorFlag |= NO_PROVIDER;
			}

			if (errorFlag == NO_ERROR) {
				if (QkanCommon.getInsurerInfo(getDBManager()).isEmpty()) {
					// 保険者がない場合
					setState_INVALID_INSURER();
					errorFlag |= NO_INSURER;
				} else {
					// 保険者が有る場合
					setState_VALID_INSURER();
				}
				if (QkanCommon.getPatientInfo(getDBManager()).isEmpty()) {
					// 利用者がない場合
					setState_INVALID_PATIENT();
					errorFlag |= NO_PATIENT;
				} else {
					// 利用者が有る場合
					setState_VALID_PATIENT();
				}

                if (String.valueOf(System.getProperty("os.name")).toLowerCase()
                        .indexOf("mac") < 0) {
                    //Mac以外
                    if (hasProperty("Acrobat/Path")
                            && new File(getProperty("Acrobat/Path")).exists()) {
                        setState_VALID_PDF_VIEWER();
                    } else {
                        setState_INVALID_PDF_VIEWER();
                        errorFlag |= NOT_FOUND_PDF_VIEWER;
                    }
                } else {
                    //Macの場合
                    setState_VALID_PDF_VIEWER();
                }

				// 印刷用PDFファイル格納用フォルダが存在するかチェックする。
				File pdfFile = new File("pdf");

				// 存在する場合
				if (pdfFile.exists()) {
					// 印刷用PDFファイル格納用フォルダ内の全てのPDFファイルを削除する。
					String[] fileList = pdfFile.list();
					for (int i = 0; i < fileList.length; i++) {
						File deleteFile = new File(pdfFile, fileList[i]);
						deleteFile.delete();
					}
				}
                
                
			}

            //番号管理テーブルの再採番
            
            getDBManager().beginTransaction();
            try{
                getDBManager().executeUpdate(getSQL_UPDATE_NO_OF_SERVICE(null));
                getDBManager().executeUpdate(getSQL_UPDATE_NO_OF_PROVIDER_SERVICE(null));
                getDBManager().executeUpdate(getSQL_UPDATE_NO_OF_CLAIM(null));
                getDBManager().commitTransaction();
            }catch(Exception ex){
                getDBManager().rollbackTransaction();
                VRLogger.info(ex);
            }
            
        }

		StringBuffer sb = new StringBuffer();
		sb.append("OS : ");
		sb.append(System.getProperty("os.name", "unknown"));
		String patch = System.getProperty("sun.os.patch.level", "");
		if (!patch.equalsIgnoreCase("unknown")) {
			sb.append(" ");
			sb.append(patch);
		}
		sb.append(ACConstants.LINE_SEPARATOR);
		sb.append("VM : ");
		sb.append(System.getProperty("java.vendor", "unknown"));
		sb.append(" ");
		sb.append(System.getProperty("java.version", "-"));
		sb.append(ACConstants.LINE_SEPARATOR);
		sb.append("Firebird : ");
		sb.append(dbmsVersion);
		sb.append(ACConstants.LINE_SEPARATOR);
		sb.append("システムversion : ");
		sb.append(systemVersion);
		sb.append(ACConstants.LINE_SEPARATOR);
		sb.append("データversion : ");
		sb.append(masterDataVersion);
		sb.append(ACConstants.LINE_SEPARATOR);
		sb.append("スキーマversion : ");
		sb.append(schemeVersion);

		getEnvironment().setText(sb.toString());


        //画面最大化
        ACFrame.getInstance().setExtendedState(Frame.MAXIMIZED_BOTH);
                
        try{
            //設定ファイル変更対応
            if(!ACFrame.getInstance().hasProperty("Claim/Cleaned")){
                if(ACFrame.getInstance().hasProperty("Claim/Folder")){
                    Object m=ACFrame.getInstance().getPropertyXML().getData("Claim");
                    if(m instanceof Map){
                        ((Map)m).remove("Folder");
                    }
                }
                if(ACFrame.getInstance().hasProperty("Claim/Info")){
                    Object m=ACFrame.getInstance().getPropertyXML().getData("Claim");
                    if(m instanceof Map){
                        ((Map)m).remove("Info");
                    }
                }
                ACFrame.getInstance().getPropertyXML().setForceValueAt("Claim/Cleaned", "true");
                ACFrame.getInstance().getPropertyXML().write();
            }
        }catch(Exception ex){
            
        }
        
		if ((affair.getParameters() != null)
				&& (affair.getParameters().get("STOP_AUTO_LOGIN") != null)) {
			// メインメニューの明示的なログアウトでは自動ログインを禁止
			affair.getParameters().remove("STOP_AUTO_LOGIN");
		} else {
			if ((errorFlag == NO_ERROR) && getProviderList().isSelected()
					&& getProviderList().getItemCount() == 1) {
				// 自動ログイン
				startActionPerformed(null);
			}
		}
        
	}

	// コンポーネントイベント

	/**
	 * 「バージョン情報表示」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void showVersionActionPerformed(ActionEvent e) throws Exception {
		// ※バージョン情報画面への遷移
		// 画面渡り用のパラメータ affair (NCAffairInfo)を生成し、下記パラメータを設定する。
		// affair(NCAffairInfo);
		// className : QV001.class.getName(), parameters : null
		// 「QV001 バージョン情報画面」を表示する。
		// next(affair);
		new QV001().setVisible(true);

	}

	/**
	 * 「ログイン処理」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void startActionPerformed(ActionEvent e) throws Exception {
		// 事業所が選択されていないとき
		if (!getProviderList().isSelected()) {
			// エラーメッセージ表示
			QkanMessageList.getInstance().QM001_ERROR_OF_PROVIDER();
			return;
		}

		// 「システム日付(systemDate)」のエラーチェックを行う。
		if (!getSystemDate().isValidDate()
				|| ACTextUtilities.isNullText(getSystemDate().getText())) {
			// 値が不正な場合
			// エラーメッセージを表示する。※メッセージID = ERROR_OF_WRONG_DATE
			QkanMessageList.getInstance().ERROR_OF_WRONG_DATE("システム");
			// 「システム日付(systemDate)」にフォーカスを当てる。
			getSystemDate().requestFocus();
			// 処理を抜ける。
			return;
		} else {
			// 値が正常な場合
			// 画面の「システム日付(systemDate)」を取得する。
			// システムの「システム日付」に、取得した日付を設定する。
			// setSystemDate((取得したシステム日付));
			QkanSystemInformation.getInstance().setSystemDate(
					ACCastUtilities.toDate(getSystemDate().getText()));

			// 「自事業所一覧(providerList)」で選択されている自事業所の事業所番号を、「自事業所一覧(providerList)」から取得する。
			// システムの「ログイン事業所番号」に、取得した事業所の事業所番号を設定する。
			// setLoginProviderID((取得した自事業所番号));
			QkanSystemInformation.getInstance().setLoginProviderID(
					ACCastUtilities.toString(VRBindPathParser.get(
							"PROVIDER_ID", (VRMap) getProviderList()
									.getSelectedModelItem())));

			// 渡りパラメータ用のレコード paramに下記パラメータを設定する。
			VRMap params = new VRHashMap();
			// ・ KEY : FROM_AFFAIR
			params.setData("FROM_AFFAIR", null);
			// 下記パラメータにてNCAffairInfo affairを生成する。
			// affair(NCAffairInfo);
			ACAffairInfo affair = null;
			// className : QM002.class.getName()
			affair = new ACAffairInfo(QM002.class.getName(), params, "メインメニュー", true);
			// 「QM002 メインメニュー」に遷移する。
			// next(affair);
			ACFrame.getInstance().next(affair);

		}
	}

	/**
	 * 「終了処理」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void endActionPerformed(ActionEvent e) throws Exception {
		// システムを終了する。
		System.exit(0);

	}

	public static void main(String[] args) {
		// デフォルトデバッグ起動
		ACFrame.getInstance().setFrameEventProcesser(
				new QkanFrameEventProcesser());
		// ログイン日付
		QkanCommon.debugInitialize();
		VRMap param = new VRHashMap();
		// paramに渡りパラメタを詰めて実行することで、簡易デバッグが可能です。
		ACFrame
				.debugStart(new ACAffairInfo(QM001.class.getName(), param, "ログイン画面", true));
	}

	/**
	 * 「設定変更画面遷移」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void goSetting1ActionPerformed(ActionEvent e) throws Exception {
		ACFrame.getInstance().next(new ACAffairInfo(QO005.class.getName()));
	}

	/**
	 * 「設定変更画面遷移」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void goSetting2ActionPerformed(ActionEvent e) throws Exception {
		ACFrame.getInstance().next(new ACAffairInfo(QO005.class.getName()));
	}

	/**
	 * 「事業所登録画面遷移」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void goProviderActionPerformed(ActionEvent e) throws Exception {
		// 渡りパラメータ用レコード params を生成し、下記の値を設定する。
		VRMap params = new VRHashMap();
		// KEY : PROCESS_MODE, VALUE : PROCESS_MODE_INSERT (共通定数)
		params.setData("PROCESS_MODE", new Integer(
				QkanConstants.PROCESS_MODE_INSERT));
		// 画面渡り用パラメータ affair (NCAffairInfo)を下記パラメータで生成する。
		// className : QO004.class.getName(), parameters : params
		ACAffairInfo affair = new ACAffairInfo(QO004.class.getName(), params);

		// 「QO004 事業所情報登録」画面に遷移する。モードは「新規作成」とする。
		// next(affair);
		ACFrame.getInstance().next(affair);
	}

	/**
	 * 「保険者登録画面遷移」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void goInsurerActionPerformed(ActionEvent e) throws Exception {
		ACAffairInfo affair = null;
		VRMap param = new VRHashMap();
		// className : QO002.class.getName(), parameters : null
		affair = new ACAffairInfo(QO002.class.getName(), param);
		// 「QO002 保険者一覧・登録画面」に遷移する。
		// next(affair);
		ACFrame.getInstance().next(affair);
	}

	/**
	 * 「利用者登録画面遷移」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected void goPatientActionPerformed(ActionEvent e) throws Exception {
		ACAffairInfo affair = null;
		VRMap param = new VRHashMap();
		// className : QU002.class.getName(), parameters : null
		affair = new ACAffairInfo(QU002.class.getName(), param);

		// 「QU002 利用者登録画面」に遷移する。
		// next(affair);
		ACFrame.getInstance().next(affair);
	}

      /**
       * 「設定変更画面遷移」イベントです。
       * @param e イベント情報
       * @throws Exception 処理例外
       */
    protected void goSetting3ActionPerformed(ActionEvent e) throws Exception {
        ACFrame.getInstance().next(new ACAffairInfo(QO005.class.getName()));
    }

}
