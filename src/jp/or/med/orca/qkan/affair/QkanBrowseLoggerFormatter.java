package jp.or.med.orca.qkan.affair;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

import jp.nichicom.ac.ACConstants;
import jp.nichicom.ac.core.ACAffairInfo;

/**
 * 業務起動ログ出力クラスで使用する、ログレコードのフォーマットクラス
 * <p>
 * Copyright (c) 2012 Nippon Computer Corpration. All Rights Reserved.
 * </p>
 * 
 * @author Shin Fujihara
 * @version 1.0 2012/09/18
 */
public class QkanBrowseLoggerFormatter extends Formatter {
	
	private Date dat = new Date();
	private final static String format = "yyyy/MM/dd HH:mm:ss";
	private SimpleDateFormat formatter;
	
	private static String user = System.getProperty("user.name");
	
	//モードを持つプログラム
	@SuppressWarnings("serial")
	public static final Map<String, String> AFFAIR_MODE = Collections.unmodifiableMap( new HashMap<String, String>(){{
		put("QU001", "NEXT_AFFAIR");	//利用者一覧(帳票)
		put("QP001", "NEXT_AFFAIR");	//利用者一覧(実績集計)
		put("QS001", "PROCESS_TYPE");	//予定・実績
	}});
	
	//個人情報を持つプログラム
	@SuppressWarnings("serial")
	public static final Set<String> AFFAIR_PERSONAL = Collections.unmodifiableSet( new HashSet<String>(){{
		add("QU002");	//利用者情報詳細
		add("QS001");	//サービス予定・実績
		add("QC001");	//訪問看護計画書
		add("QC002");	//訪問看護報告書
		add("QC003");	//訪問看護の情報提供書
		add("QC004");	//訪問看護記録書I
		add("QC005");	//居宅療養管理指導書
		add("QP002");	//帳票（様式）選択（実績確認・修正）
	}});
	
	@Override
	public synchronized String format(LogRecord record) {
		
		StringBuilder sb = new StringBuilder();
		dat.setTime(record.getMillis());
		
		if (formatter == null) {
			formatter = new SimpleDateFormat(format);
		}
		
		sb.append(formatter.format(dat));
		sb.append(" ");
		
		//カスタムメッセージを表示
		ACAffairInfo info = (ACAffairInfo)record.getParameters()[0];
		
		sb.append(user);
		sb.append(" ");
		
		String classFullName = info.getClassName();
		String className = classFullName;
		int lastIndex = classFullName.lastIndexOf('.');
		if (lastIndex != -1) {
			className = classFullName.substring(lastIndex + 1);
		}
		
		sb.append(className);
		
		//モードを持つプログラムの場合は、モードもログに出力
		if (AFFAIR_MODE.containsKey(className)) {
			sb.append(" ");
			sb.append(info.getParameters().get( AFFAIR_MODE.get(className) ));
		}
		
		//個人情報を持つプログラムの場合は、idをログに出力
		if (AFFAIR_PERSONAL.contains(className)) {
			sb.append(" ");
			sb.append(info.getParameters().get("PATIENT_ID"));
		}
		
		sb.append(ACConstants.LINE_SEPARATOR);
		
		return sb.toString();
	}

}
