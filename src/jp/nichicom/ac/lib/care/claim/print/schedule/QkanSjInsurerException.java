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
 * 総合事業の独自サービスで算定できない保険者番号が設定されている場合にスローされるException
 *
 */
public class QkanSjInsurerException extends Exception {

	private static final long serialVersionUID = 1L;
	
	private boolean isTukitotyuJushotiTokurei;
	private Map code;
	private String sjInsureId;

	public QkanSjInsurerException(String sjInsureId, Map code, boolean isTukitotyuJushotiTokurei) {
		//super(message);
		this.isTukitotyuJushotiTokurei = isTukitotyuJushotiTokurei;
		this.sjInsureId = sjInsureId;
		this.code = code;
	}

	public String getSjInsurerId() {
		return sjInsureId;
	}

	
	public Map getCode() {
		return code;
	}

	public boolean isTukitotyuJushotiTokurei() {
		return isTukitotyuJushotiTokurei;
	}


}
