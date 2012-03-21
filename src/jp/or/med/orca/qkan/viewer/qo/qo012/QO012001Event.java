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
 * 開発者: 廣瀬 一海
 * 作成日: 2006/04/11  日本コンピューター株式会社 廣瀬 一海 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム CSVビューア (O)
 * プロセス CSVビューア (012)
 * プログラム CSV結合画面 (QO012001)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.viewer.qo.qo012;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import jp.nichicom.ac.ACCommon;
import jp.nichicom.vr.io.VRCSVFile;

/**
 * CSV結合画面イベント定義(QO012001)
 */
public abstract class QO012001Event extends QO012001Design {
	/**
	 * コンストラクタです。
	 */
	public QO012001Event() {
		addEvents();
	}

	/**
	 * イベント発生条件を定義します。
	 */
	protected void addEvents() {
		getUnitButton().addActionListener(new ActionListener() {
			private boolean lockFlag = false;

			public void actionPerformed(ActionEvent e) {
				if (lockFlag) {
					return;
				}
				lockFlag = true;
				try {
					unitButtonActionPerformed(e);
				} catch (Throwable ex) {
					ACCommon.getInstance().showExceptionMessage(ex);
				} finally {
					lockFlag = false;
				}
			}
		});
		getFile1Button().addActionListener(new ActionListener() {
			private boolean lockFlag = false;

			public void actionPerformed(ActionEvent e) {
				if (lockFlag) {
					return;
				}
				lockFlag = true;
				try {
					file1ButtonActionPerformed(e);
				} catch (Throwable ex) {
					ACCommon.getInstance().showExceptionMessage(ex);
				} finally {
					lockFlag = false;
				}
			}
		});
		getFile2Button().addActionListener(new ActionListener() {
			private boolean lockFlag = false;

			public void actionPerformed(ActionEvent e) {
				if (lockFlag) {
					return;
				}
				lockFlag = true;
				try {
					file2ButtonActionPerformed(e);
				} catch (Throwable ex) {
					ACCommon.getInstance().showExceptionMessage(ex);
				} finally {
					lockFlag = false;
				}
			}
		});

		getFile3Button().addActionListener(new ActionListener() {
			private boolean lockFlag = false;

			public void actionPerformed(ActionEvent e) {
				if (lockFlag) {
					return;
				}
				lockFlag = true;
				try {
					file3ButtonActionPerformed(e);
				} catch (Throwable ex) {
					ACCommon.getInstance().showExceptionMessage(ex);
				} finally {
					lockFlag = false;
				}
			}
		});
		
		getCloseButton().addActionListener(new ActionListener() {
			private boolean lockFlag = false;

			public void actionPerformed(ActionEvent e) {
				if (lockFlag) {
					return;
				}
				lockFlag = true;
				try {
					closeButtonActionPerformed(e);
				} catch (Throwable ex) {
					ACCommon.getInstance().showExceptionMessage(ex);
				} finally {
					lockFlag = false;
				}
			}
		});

	}

	// コンポーネントイベント

	/**
	 * 「CSVファイル結合を終了」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected abstract void closeButtonActionPerformed(ActionEvent e) throws Exception;

	/**
	 * 「CSVファイル結合」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected abstract void unitButtonActionPerformed(ActionEvent e) throws Exception;

	/**
	 * 「CSV1ファイルダイアログ」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected abstract void file1ButtonActionPerformed(ActionEvent e) throws Exception;

	/**
	 * 「CSV2ファイルダイアログ」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected abstract void file2ButtonActionPerformed(ActionEvent e) throws Exception;

	/**
	 * 「CSV3ファイルダイアログ」イベントです。
	 * 
	 * @param e
	 *            イベント情報
	 * @throws Exception
	 *             処理例外
	 */
	protected abstract void file3ButtonActionPerformed(ActionEvent e) throws Exception;

	// 変数定義

	private VRCSVFile inputCSVFile1;

	private VRCSVFile inputCSVFile2;

	private VRCSVFile outputCSVFile;
    
    private String lastOpenDir;

	public static final String[] CSV_FILE_EXTENSIONS = { "csv" };

	public static final String ERROR_RECORD_COUNT_NOT_FOUND = "レコード件数が存在しませんでした、処理を中断します";

	public static final String ERROR_NOT_SAME_TARGET_DATE = "二つのCSVの処理対象年月が一致しませんでした、処理を中断します";

	public static final String ERROR_NOT_SAME_FILE_DATA_TYPE = "二つのCSVのファイル種別が一致しませんでした、処理を中断します";

	public static final String ERROR_CAN_NOT_OUTPUT_SELECTED_FOLDER = "指定のフォルダには出力できません、再度出力先のフォルダを選択してください";

	public static final String MESSAGE_PLEASE_CSV_OUTPUT_FOLDER = "結合したCSVの出力先を指定してください";

	public static final String ERROR_CAN_NOT_READ_CSV = "CSVファイルの読み込みに失敗しました";

	public static final String ERROR_NON_CORRESPONDENCE_DATA_RECORD_TYPE = "介護給付費請求や居宅サービス計画費を格納したCSVではありません";

	public static final String ERROR_CONTROL_RECORD_NOT_FOUND = "コントロールレコードが存在しません";

	public static final String ERROR_DATA_NOT_FOUND = "データが存在しません";

	public static final String ERROR_FILE_NOT_FOUND = "選択されたファイルは存在しませんでした";

	public static final String MESSAGE_PLEASE_SELECT_CSV_FILE = "CSVファイルを指定して下さい";

	public static final String MESSAGE_CSV_UNITING_OVER = "CSVファイルの結合が完了しました";

	public static final String ERROR_OUTPUT_FOLDER_EMPTY = "出力先のフォルダが指定されていません";

	public static final String ERROR_OUTPUT_FILE_EXSISTS = "出力先に同名のファイルがあります、上書きしますか？";

	public static final String MESSAGE_WINDOW_TITLE = "介護給付費請求書・給付管理票情報CSVファイル結合";

	public static final String CSV_FILE_TYPE_812 = "介護給付費請求明細書（居宅サービス計画費）情報";

	public static final String CSV_FILE_TYPE_711 = "介護給付費請求書情報";

	public static final String CSV_FILE_TYPE_821 = "給付管理票情報";

	public static final int CONTROL_RECORD_INDEX = 0;

	public static final int CONTROL_RECORD_FORMAT_11_TARGET_YEAR_AND_MONTH = 10; // 処理対象年月

	public static final int CONTROL_RECORD_FORMAT_5_DATA_TYPE = 4; // データ種別

	public static final int CONTROL_RECORD_FORMAT_4_RECORD_COUNT = 3; // データ件数

	// getter/setter

	/**
	 * inputCSVFile1を返します。
	 * 
	 * @return inputCSVFile1
	 */
	protected VRCSVFile getInputCSVFile1() {
		return inputCSVFile1;
	}

	/**
	 * inputCSVFile1を設定します。
	 * 
	 * @param inputCSVFile1
	 *            inputCSVFile1
	 */
	protected void setInputCSVFile1(VRCSVFile inputCSVFile1) {
		this.inputCSVFile1 = inputCSVFile1;
	}

	/**
	 * inputCSVFile2を返します。
	 * 
	 * @return inputCSVFile2
	 */
	protected VRCSVFile getInputCSVFile2() {
		return inputCSVFile2;
	}

	/**
	 * inputCSVFile2を設定します。
	 * 
	 * @param inputCSVFile2
	 *            inputCSVFile2
	 */
	protected void setInputCSVFile2(VRCSVFile inputCSVFile2) {
		this.inputCSVFile2 = inputCSVFile2;
	}

	/**
	 * outputCSVFileを返します。
	 * 
	 * @return outputCSVFile
	 */
	protected VRCSVFile getOutputCSVFile() {
		return outputCSVFile;
	}

	/**
	 * outputCSVFileを設定します。
	 * 
	 * @param outputCSVFile
	 *            outputCSVFile
	 */
	protected void setOutputCSVFile(VRCSVFile outputCSVFile) {
		this.outputCSVFile = outputCSVFile;
	}
    

    /**
     * lastOpenDirを返します。
     * 
     * @return lastOpenDir
     */
    protected String getLastOpenDir() {
        return lastOpenDir;
    }

    /**
     * lastOpenDirを設定します。
     * 
     * @param lastOpenDir
     *            lastOpenDir
     */
    protected void setLastOpenDir(String lastOpenDir) {
        this.lastOpenDir = lastOpenDir;
    }
    
}
