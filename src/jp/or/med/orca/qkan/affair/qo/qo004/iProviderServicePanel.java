/**
 * 事業所サービスパネルのインタフェースです。<br>
 * 事業所登録(QO004)で使用します。
 * <p>
 * Copyright (c) 2005 Nippon Computer Corporation. All Rights Reserved.
 * </p>
 * 
 * @author Kazuyoshi Kamitsukasa
 * @version 1.0 2006/02/10
 */
package jp.or.med.orca.qkan.affair.qo.qo004;

import jp.nichicom.vr.util.VRMap;

public interface iProviderServicePanel {

	void initialize() throws Exception;
	
	boolean isValidInput() throws Exception;
	
	void stateManager(boolean state) throws Exception;
	
	void getDetails(VRMap map) throws Exception;
	
}
