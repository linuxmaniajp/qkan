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
 */
package jp.nichicom.ac.lib.care.claim.print.schedule;

import java.util.Map;

/**
 * 総合事業のAFサービスで一緒に算定できないサービスが算定されている場合にスローされるException
 *
 */
public class QkanSjAfException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public enum Type {
		YOBO_GENDOGAKU_SV, //予防の限度額管理対象サービスが算定されている場合
		YOBO_SHIEN_SV //予防支援サービスが算定されている場合
	};
	
	private Type type;
	private Map code;

	public QkanSjAfException(Map code, Type type) {		
		this.code = code;
		this.type = type;
	}
	
	public Map getCode() {
		return code;
	}
	
	public Type getType() {
		return type;
	}

}
