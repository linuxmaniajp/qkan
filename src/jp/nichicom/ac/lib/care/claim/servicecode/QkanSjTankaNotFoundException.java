/*
 * Project code name "ORCA"
 * ���t�Ǘ��䒠�\�t�g QKANCHO�iJMA care benefit management software�j
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
package jp.nichicom.ac.lib.care.claim.servicecode;

/**
 * �������Ƃ̒P�ʐ��P�����擾�o���Ȃ��ꍇ�ɃX���[�����Exception
 *
 */
public class QkanSjTankaNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;
	
	private String insurerId;
	private String systemServiceKindDetail;
	
	public QkanSjTankaNotFoundException(String insurerId, String systemServiceKindDetail, String message) {
		super(message);
		this.insurerId = insurerId;
		this.systemServiceKindDetail = systemServiceKindDetail;
	}

	public String getInsurerId() {
		return insurerId;
	}

	public String getSystemServiceKindDetail() {
		return systemServiceKindDetail;
	}
	
}
