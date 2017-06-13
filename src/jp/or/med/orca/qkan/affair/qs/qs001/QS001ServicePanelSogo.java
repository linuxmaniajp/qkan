package jp.or.med.orca.qkan.affair.qs.qs001;

import java.awt.LayoutManager;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

import jp.nichicom.ac.ACConstants;
import jp.nichicom.ac.container.ACPanel;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.lib.care.claim.calculation.QP001PatientState;
import jp.nichicom.ac.lib.care.claim.servicecode.QkanSjServiceCodeManager;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.ac.util.adapter.ACTableModelAdapter;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.affair.QkanMessageList;

/**
 * 総合事業サービスパネル用の基底パネルクラスです。
 * 
 * @author Y.Kamei
 * @version 1.0 2016/08/25
 * 
 */
public class QS001ServicePanelSogo extends QS001ServicePanel {
	protected final int SJ_HOKENSHA_NO_BIND_PATH = 500;
	protected final int SJ_SERVICE_CODE_BIND_PATH_ST = 501;
	protected final int SJ_SERVICE_CODE_BIND_PATH_ED = 510;
	protected final int DOKUJI_TEIRITSU_SVCODE_SELECT_MAX = 10; // 独自定率で選択可能なサービスコードの最大数
	protected final int DOKUJI_TEIGAKU_SVCODE_SELECT_MAX = 1; // 独自定額で選択可能なサービスコードの最大数
	private String systemServiceKindDetail;
	
	private VRList svCodeList = new VRArrayList(); // 選択中のサービスコードのリスト

	/**
	 * 独自サービス種類コードを返します。
	 * 
	 * @return 独自サービス種類コード
	 */
	public String getSystemServiceKindDetail() {
		return systemServiceKindDetail;
	}

	/**
	 * 独自サービス種類コードを設定します。
	 * 
	 * @param systemServiceKindDetail
	 */
	public void setSystemServiceKindDetail(String systemServiceKindDetail) {
		this.systemServiceKindDetail = systemServiceKindDetail;
	}
	
	/**
	 * svCodeListを返します。
	 * 
	 * @return svCodeList
	 */
	public VRList getSvCodeList() {
		return svCodeList;
	}

	/**
	 * svCodeListを設定します。
	 * 
	 * @param svCodeList
	 *            svCodeList
	 */
	public void setSvCodeList(VRList svCodeList) {
		this.svCodeList = svCodeList;
	}

	private ACTableModelAdapter svCodeTableModel;

	/**
	 * svCodeTableModelを返します。
	 * 
	 * @return svCodeTableModel
	 */
	protected ACTableModelAdapter getSvCodeTableModel() {
		return this.svCodeTableModel;
	}

	/**
	 * svCodeTableModelを設定します。
	 * 
	 * @param svCodeTableModel
	 *            svCodeTableModel
	 */
	protected void setSvCodeTableModel(ACTableModelAdapter svCodeTableModel) {
		this.svCodeTableModel = svCodeTableModel;
	}



	/**
	 * Creates a new <code>JPanel</code> with a double buffer and a flow layout.
	 */
	public QS001ServicePanelSogo() {
		super();
	}

	/**
	 * Creates a new <code>JPanel</code> with <code>FlowLayout</code> and the
	 * specified buffering strategy. If <code>isDoubleBuffered</code> is true,
	 * the <code>JPanel</code> will use a double buffer.
	 * 
	 * @param isDoubleBuffered
	 *            a boolean, true for double-buffering, which uses additional
	 *            memory space to achieve fast, flicker-free updates
	 */
	public QS001ServicePanelSogo(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
	}

	/**
	 * Create a new buffered JPanel with the specified layout manager
	 * 
	 * @param layout
	 *            the LayoutManager to use
	 */
	public QS001ServicePanelSogo(LayoutManager layout) {
		super(layout);
	}

	/**
	 * Creates a new JPanel with the specified layout manager and buffering
	 * strategy.
	 * 
	 * @param layout
	 *            the LayoutManager to use
	 * @param isDoubleBuffered
	 *            a boolean, true for double-buffering, which uses additional
	 *            memory space to achieve fast, flicker-free updates
	 */
	public QS001ServicePanelSogo(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
	}

	/**
	 * 値バインド後処理
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	public void binded() throws Exception {
		// サービスパネルデータバインド直後のパネルデータの編集処理
		if (this.getParent() instanceof ACPanel) {
			ACPanel panel = (ACPanel) this.getParent();
			// Mapが取れた場合
			if (panel.getSource() instanceof VRMap) {
				VRMap source = (VRMap) panel.getSource();

				getSvCodeList().clear();

				for (int key = SJ_SERVICE_CODE_BIND_PATH_ST; key <= SJ_SERVICE_CODE_BIND_PATH_ED; key++) {
					String codeKey = ACCastUtilities.toString(
							source.get(String.valueOf(key)), "");
					if (ACTextUtilities.isNullText(codeKey)) {
						break;
					}
					VRMap ret = QkanSjServiceCodeManager.getSjServiceCodeByKey(
							getDBManager(), codeKey, getCalculater()
									.getTargetDate());
					getSvCodeList().add(ret);
				}
				getSvCodeTableModel().setAdaptee(getSvCodeList());
			}
		}
		// 画面状態制御
		checkState();
	}
	
	/**
	 * コードからマスタを参照し、一覧へ追加
	 * @param insurerId 保険者番号
	 * @param itemCode サービス項目コード
	 * @return 一覧へ追加した場合true、そうでなければfalse
	 * @throws Exception
	 */
	protected boolean findCodeToList(String insurerId, String itemCode) throws Exception {
		String key = QkanSjServiceCodeManager.createSjServiceCodeKey(insurerId,
				getSystemServiceKindDetail(), itemCode);
		VRMap ret = QkanSjServiceCodeManager.getSjServiceCodeByKey(getDBManager(), key,
				getCalculater().getTargetDate());
		if (ret.isEmpty()) {
			QkanMessageList.getInstance().NOT_FOUND("コード");
			return false;
		}
		// 追加時チェック処理
		if (checkAddCode(ret)) {
			// 一覧に追加
			getSvCodeList().add(ret);
			getSvCodeTableModel().setAdaptee(getSvCodeList());
			// 画面状態制御
			checkState();
			return true;
		}
		return false;
	}
	
	/**
	 * コード選択ダイアログを起動し、選択コードを一覧へ追加
	 * @param insurerId 保険者番号
	 * @return 一覧へ追加した場合true、そうでなければfalse
	 * @throws Exception
	 */
	protected boolean selectCodeToList(String insurerId) throws Exception {
		// コード選択ダイアログを起動して、選択レコードをretに格納
		VRMap param = new VRHashMap();
		param.put("INSURER_ID", insurerId);
		Map insurer = getCalculater().getInsurerInfo(insurerId);
        if (insurer != null) {
        	param.put("INSURER_NAME", insurer.get("INSURER_NAME"));
        }
		param.put("SYSTEM_SERVICE_CODE_KIND", getSystemServiceKindDetail());
        param.put("TARGET_DATE", getCalculater().getTargetDate());
        VRMap serviceMap = QkanCommon.getMasterService(getDBManager(), getCalculater().getTargetDate());
        VRMap service = (VRMap) serviceMap.get(ACCastUtilities.toInt(getSystemServiceKindDetail()));
        if (service != null) {
            param.put("SERVICE_CODE_KIND", ACCastUtilities.toString(VRBindPathParser.get(
    				"SERVICE_CODE_KIND", service)));
            param.put("SERVICE_NAME", ACCastUtilities.toString(VRBindPathParser.get(
    				"SERVICE_NAME", service)));
        }
        VRList ninteiList = getCalculater().getPatientInsureInfoHistoryList();
        for (int i = 0; i < ninteiList.size(); i++) {
    		param.put("JOTAI_CODE", ACCastUtilities.toInt(
                    VRBindPathParser.get("JOTAI_CODE", (VRMap) ninteiList.get(i)), 0));
        }
		VRMap ret = new QS001013().showModal(param);
		if (ret == null) {
			return false;
		}
		// 追加時チェック処理
		if (checkAddCode(ret)) {
			// 一覧に追加
			getSvCodeList().add(ret);
			getSvCodeTableModel().setAdaptee(getSvCodeList());
			// 画面状態制御
			checkState();
			return true;
		}
		return false;
	}

	// サービスコード一覧データをバインドパスとしてサービスに追加
	protected void addSvCodeToData(VRMap data) throws Exception {
		// 一旦削除する
		for (int key = SJ_SERVICE_CODE_BIND_PATH_ST; key <= SJ_SERVICE_CODE_BIND_PATH_ED; key++) {
			data.removeData(String.valueOf(key));
		}
		Iterator it = getSvCodeList().iterator();
		for (int key = SJ_SERVICE_CODE_BIND_PATH_ST; key <= SJ_SERVICE_CODE_BIND_PATH_ED; key++) {
			if (!it.hasNext()) {
				break;
			}
			Map row = (Map) it.next();
			String value = ACCastUtilities.toString(row
					.get("SYSTEM_SERVICE_CODE_ITEM"));
			data.put(String.valueOf(key), value);
		}
	}

	// サービスコード一覧に追加する際のチェック
	protected boolean checkAddCode(VRMap target) throws Exception {
		Iterator it = getSvCodeList().iterator();
		while (it.hasNext()) {
			Map row = (Map) it.next();
			// 保険者が異なる
			if (!ACCastUtilities.toString(target.get("INSURER_ID")).equals(
					ACCastUtilities.toString(row.get("INSURER_ID")))) {
				QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(
						"保険者が異なるコードは同時に登録できません。" + ACConstants.LINE_SEPARATOR
								+ "別のサービスとしてコード");
				return false;
			}
			// 給付率が異なる
			if (!ACCastUtilities.toString(target.get("KYUFURITSU")).equals(
					ACCastUtilities.toString(row.get("KYUFURITSU")))) {
				QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(
						"給付率が異なるコードは同時に登録できません。" + ACConstants.LINE_SEPARATOR
								+ "別のサービスとしてコード");
				return false;
			}
			// 既に追加されているコード
			if (ACCastUtilities.toString(target.get("SERVICE_CODE_ITEM"))
					.equals(ACCastUtilities.toString(row
							.get("SERVICE_CODE_ITEM")))) {
				QkanMessageList.getInstance().ERROR_OF_SAME_DATA_FOUND("コード");
				return false;
			}
		}
		return true;
	}
	
	// 保険者コンボの初期値を取得
	protected String getInitialInsurerId() throws Exception {
		// 利用者の該当月の要介護認定履歴から保険者を取得する。
		Date targetDate = getCalculater().getTargetDate();
		VRMap map = getCalculater().getPatientInsureInfoOnTargetDay(targetDate);
		if (map == null) {
			return null;
		}
		String insurerId = ACCastUtilities.toString(map.get("INSURER_ID"));

		// 住所地特例の場合は、こちらの保険者を選択する
		String jushotiTokureiInsurerId = getCalculater()
				.getJushotiTokureiInsurerId(getCalculater().getTargetDate());
		if (!ACTextUtilities.isNullText(jushotiTokureiInsurerId)) {
			insurerId = jushotiTokureiInsurerId;
		}
		return insurerId;
	}

	/**
	 * 「画面状態制御」に関する処理を行ないます。
	 * 
	 * @throws Exception
	 *             処理例外
	 */
	protected void checkState() throws Exception {
		//子クラスにて実装
	}

}
