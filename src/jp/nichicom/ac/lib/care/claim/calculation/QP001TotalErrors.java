package jp.nichicom.ac.lib.care.claim.calculation;

import java.awt.Dimension;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JScrollPane;
import javax.swing.JViewport;
import javax.swing.UIManager;

import jp.nichicom.ac.ACConstants;
import jp.nichicom.ac.component.ACLabel;
import jp.nichicom.ac.container.ACGroupBox;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.core.ACFrameEventProcesser;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.lib.care.claim.servicecode.CareServiceCommon;
import jp.nichicom.ac.util.ACMessageBox;
import jp.nichicom.vr.layout.VRLayout;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;

public class QP001TotalErrors {

	
	/** 認定申請中のエラー情報 */
	private VRList applyingErrors = new VRArrayList();
	/** 対象者が要支援なのに要介護のサービス算定 */
	private VRList serviceErrorsYobo = new VRArrayList();
	/** 対象者が要介護なのに要支援のサービス算定 */
	private VRList serviceErrorsKaigo = new VRArrayList();
	/** 認定期間外エラー */
	private VRList outOfTermError = new VRArrayList();
	/** 居宅介護支援事業所が本人で様式第七算定エラー */
	private VRList selfPlanStyle7 = new VRArrayList();
	/** 要支援２のみ算定可能エラー */
	private VRList neededSupport2Only = new VRArrayList();
	
	// 2016/10/13 [Yoichiro Kamei] add - begin 総合事業対応
	private VRList sjTankaNotFound = new VRArrayList();
	private Set<String> insurerIds = new HashSet<String>();
	/**
	 * 保険者の単位数単価未設定のエラーを登録する。
	 * @param patient
	 */
	public void addSjTankaNotFound(VRMap patient, String insurerId) {
		addErrorArray(getFullName(patient), sjTankaNotFound);
		insurerIds.add(insurerId);
	}
	//保険者の単位数単価未設定のエラーメッセージを取得
	private String getSjTankaNotFoundMessage() {
		StringBuilder sb = new StringBuilder();
		sb.append("保険者番号[");
		boolean first = true;
		for (String insurerId : insurerIds) {
			if (!first) {
				sb.append(",");
			}
			sb.append(insurerId);
			first = false;
		}
		sb.append("]の単位数単価が設定されていません。");
		sb.append(ACConstants.LINE_SEPARATOR);
		sb.append("「保険者情報詳細画面」で「総合事業単位数単価」を設定してください。");
		sb.append(ACConstants.LINE_SEPARATOR);
		return sb.toString();
	}
	// 2016/10/13 [Yoichiro Kamei] add - end
	
	
	// 2016/10/25 [Yoichiro Kamei] add - begin 総合事業対応
	private VRList sjIncorrectInsurers = new VRArrayList();
	/**
	 * 請求出来ない保険者のコード設定エラーを登録する。
	 * @param patient
	 */
	public void addSjIncorrectInsurers(VRMap patient) {
		addErrorArray(getFullName(patient), sjIncorrectInsurers);
	}
	
	private VRList sjIncorrectLimitOverUnits = new VRArrayList();
	
	/**
	 * 区分支給限度超単位数の不整合エラーを登録する。
	 * @param patient
	 */
	public void addSjIncorrectLimitOverUnits (VRMap patient) {
		addErrorArray(getFullName(patient), sjIncorrectLimitOverUnits);
	}
	
	// 2016/10/25 [Yoichiro Kamei] add - end
	
	//private ACDateFormat errorDateFormat = new ACDateFormat("MM月dd日");
	
	/**
	 * 認定申請中のエラーを登録する
	 */
	public void addApplyingError(VRMap patient) {
		addErrorArray(getFullName(patient), applyingErrors);
	}
	
	/**
	 * 介護度と提供サービスが不一致の場合のエラー登録
	 * @param patient
	 * @param service
	 * @param masterService
	 */
	public void addServiceError(VRMap patient, VRMap service, VRMap masterService) {
		
		Integer serviceKind = ACCastUtilities.toInteger(service.get("SYSTEM_SERVICE_KIND_DETAIL"), 0);
		if (!masterService.containsKey(serviceKind)) {
			return;
		}
		
		//封印
		/*
		StringBuilder msg = new StringBuilder();
		msg.append(getFullName(patient));
		
		switch (ACCastUtilities.toInt(serviceKind, 0)) {
		//宅療養管理指導
		case 13111:
		//介護予防居宅療養管理指導
		case 13411:
			msg.append("　　");
			msg.append("　　" + errorDateFormat.format(service.get("SERVICE_DATE")));
			msg.append("　　");
			msg.append("　　" + ((VRMap)masterService.get(serviceKind)).get("SERVICE_NAME"));
			break;
		}
		*/
		
		String fullName = getFullName(patient);
		
        switch (ACCastUtilities.toInt(service.get("1"), 0)) {
        case 12: //要支援１
        	//要支援認定、要支援のサービス提供のとき
        	if (CareServiceCommon.isPreventService(serviceKind.intValue())){
        		addErrorArray(fullName, neededSupport2Only);
        	} else {
        		addErrorArray(fullName, serviceErrorsYobo);
        	}
        	break;
        case 13: //要支援２
        	addErrorArray(fullName, serviceErrorsYobo);
        	break;
        case 11: //経過的要介護
        case 21: // 要介護度１
        case 22: // 要介護度２
        case 23: // 要介護度３
        case 24: // 要介護度４
        case 25: // 要介護度５
        	addErrorArray(fullName, serviceErrorsKaigo);
            break;
        }
		
		
	}
	
	
	/**
	 * 要介護認定が認定期間外
	 * @param patient
	 */
	public void addOutOfTermError(VRMap patient) {
		addErrorArray(getFullName(patient), outOfTermError);
	}
	
	/**
	 * 居宅介護支援事業所が本人で様式第七算定エラー
	 * @param patient
	 */
	public void addSelfPlanStyle7(VRMap patient) {
		addErrorArray(getFullName(patient), selfPlanStyle7);
	}
	
	
	private void addErrorArray(String msg, VRList target) {
		String addMsg = "　　" + msg;
		if (target.contains(addMsg)) {
			return;
		}
		target.add(addMsg);
	}
	
	/**
	 * エラーが存在したか
	 * @return
	 */
	public boolean hasError() {
		if (applyingErrors.size() != 0) return true;
		if (serviceErrorsYobo.size() != 0) return true;
		if (serviceErrorsKaigo.size() != 0) return true;
		if (outOfTermError.size() != 0) return true;
		if (selfPlanStyle7.size() != 0) return true;
		if (neededSupport2Only.size() != 0) return true;
		if (sjTankaNotFound.size() != 0) return true; // add 2016.10 総合事業独自対応
		if (sjIncorrectInsurers.size() != 0) return true; // add 2016.10 総合事業独自対応
		if (sjIncorrectLimitOverUnits.size() != 0) return true; // add 2016.10 総合事業独自対応
		
		return false;
	}
	
	private String getErrorMessage() {
		StringBuilder msg = new StringBuilder();
		
		makeErrorMessage("要介護認定情報が申請中と登録されています。", applyingErrors, msg);
		makeErrorMessage("要支援者に介護サービスの実績が作成されています。", serviceErrorsYobo, msg);
		makeErrorMessage("要介護者に予防サービスの実績が作成されています。", serviceErrorsKaigo, msg);
		
		makeErrorMessage("要介護認定情報の認定期間外にサービスの実績が作成されています。", outOfTermError, msg);
		makeErrorMessage("利用者情報の居宅サービス計画作成者の設定が不正です。", selfPlanStyle7, msg);
		makeErrorMessage("要支援1では受給できないサービスが設定されています。", neededSupport2Only, msg);
		
		makeErrorMessage(getSjTankaNotFoundMessage(), sjTankaNotFound, msg);// add 2016.10 総合事業独自対応
		makeErrorMessage("総合事業で請求できない保険者のサービスが設定されています。", sjIncorrectInsurers, msg);// add 2016.10 総合事業独自対応
		makeErrorMessage("区分支給超単位数が不正です。実績管理で[総合事業 区分支給超単位数調整]を行ってください。", sjIncorrectLimitOverUnits, msg);// add 2016.10 総合事業独自対応
		
		return msg.toString();
	}
	
	private void makeErrorMessage(String title, VRList list, StringBuilder msg) {
		
		if (list.size() == 0) {
			return;
		}
		
		msg.append(title + ACConstants.LINE_SEPARATOR);
		for (int i = 0; i < list.size(); i++) {
			msg.append(list.get(i) + ACConstants.LINE_SEPARATOR);
		}
		msg.append(ACConstants.LINE_SEPARATOR);
		
	}
	
	/**
	 * 保持しているエラーの詳細情報をダイアログで表示する
	 *
	 */
	public void show() {
		ACGroupBox details = new ACGroupBox("詳細情報");
		ACLabel lbl = new ACLabel();
		JViewport view = new JViewport();
		JScrollPane pane = new JScrollPane(view);
		view.add(lbl);
		details.add(pane, VRLayout.CLIENT);
		lbl.setVerticalTextPosition(ACLabel.TOP);
        lbl.setVerticalAlignment(ACLabel.TOP);
		lbl.setText(getErrorMessage());
		lbl.setRows(lbl.getText().split(ACConstants.LINE_SEPARATOR).length + 1);
		pane.setPreferredSize(new Dimension(200,100));
		
		ACMessageBox.show(getDefaultTitle(), "実績の集計ができませんでした。", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK, details, true);
		if (details.getParent() != null) {
			details.getParent().remove(pane);
		}
		pane = null;
	}
	
    private String getDefaultTitle() {
        ACFrameEventProcesser eventProcesser = ACFrame.getInstance()
                .getFrameEventProcesser();
        if (eventProcesser instanceof ACFrameEventProcesser) {
            // 画面遷移前にメッセージボックスのデフォルトタイトルを設定する
            return eventProcesser.getDefaultMessageBoxTitle();
        }
        return "メッセージ";
    }
    
    private String getFullName(VRMap patient) {
    	return QkanCommon.toFullName(patient.get("PATIENT_FAMILY_NAME"), patient.get("PATIENT_FIRST_NAME"));
    }
    
	
	//デバッグ用
	public static void main(String[] arts) {
		try {
			UIManager.setLookAndFeel("jp.nichicom.vr.plaf.metal.VRLookAndFeel");
		} catch (Exception e){
			
		}
		
		QP001TotalErrors e = new QP001TotalErrors();
		
		//e.addServiceError("　　酒井　忠世", 12);
		//e.addServiceError("　　土井　利勝", 11);
		
		e.show();
	}	
	
}
