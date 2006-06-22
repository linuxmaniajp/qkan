package jp.or.med.orca.qkan.viewer;

import jp.nichicom.vr.io.VRCSVFile;

/**
 * 給管鳥CSV結合結果出力用のCSVファイルアクセスクラスです。
 * <p>
 * Copyright (c) 2005 Nippon Computer Corpration. All Rights Reserved.
 * </p>
 * 
 * @author Kazumi Hirose
 * @version 1.0 2006/04/12
 */
public class QkanCSVViewerCSVFile extends VRCSVFile {
	/**
	 * コンストラクタです。
	 * 
	 * @param path
	 *            ファイルパス
	 */
	public QkanCSVViewerCSVFile(String path) {
		super(path);
	}

	/**
	 * コンストラクタです。
	 * 
	 * @param path
	 *            ファイルパス
	 * @param encode
	 *            エンコード
	 */
	public QkanCSVViewerCSVFile(String path, String encode) {
		super(path, encode);
	}

	/**
	 * 「国保中央会向け伝送ソフトウェア向けCSVに整形」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */

	protected void appendValue(StringBuffer sb, Object value, int rowIndex, int columnIndex) {
		if (rowIndex == 0) {
			// 1行目は別処理
			// クォート処理をせずに出力
			sb.append(value);
			// カンマも忘れずに
			sb.append(VRCSVFile.COMMA);
		} else {
			// 規定のCSV出力を行なう
			if (columnIndex <= 1) {
				sb.append(value);
				sb.append(VRCSVFile.COMMA);
			} else {
				super.appendValue(sb, value, rowIndex, columnIndex);
			}
		}
	}
}
