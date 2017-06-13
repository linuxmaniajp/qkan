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
 * �������ƃT�[�r�X�p�l���p�̊��p�l���N���X�ł��B
 * 
 * @author Y.Kamei
 * @version 1.0 2016/08/25
 * 
 */
public class QS001ServicePanelSogo extends QS001ServicePanel {
	protected final int SJ_HOKENSHA_NO_BIND_PATH = 500;
	protected final int SJ_SERVICE_CODE_BIND_PATH_ST = 501;
	protected final int SJ_SERVICE_CODE_BIND_PATH_ED = 510;
	protected final int DOKUJI_TEIRITSU_SVCODE_SELECT_MAX = 10; // �Ǝ��藦�őI���\�ȃT�[�r�X�R�[�h�̍ő吔
	protected final int DOKUJI_TEIGAKU_SVCODE_SELECT_MAX = 1; // �Ǝ���z�őI���\�ȃT�[�r�X�R�[�h�̍ő吔
	private String systemServiceKindDetail;
	
	private VRList svCodeList = new VRArrayList(); // �I�𒆂̃T�[�r�X�R�[�h�̃��X�g

	/**
	 * �Ǝ��T�[�r�X��ރR�[�h��Ԃ��܂��B
	 * 
	 * @return �Ǝ��T�[�r�X��ރR�[�h
	 */
	public String getSystemServiceKindDetail() {
		return systemServiceKindDetail;
	}

	/**
	 * �Ǝ��T�[�r�X��ރR�[�h��ݒ肵�܂��B
	 * 
	 * @param systemServiceKindDetail
	 */
	public void setSystemServiceKindDetail(String systemServiceKindDetail) {
		this.systemServiceKindDetail = systemServiceKindDetail;
	}
	
	/**
	 * svCodeList��Ԃ��܂��B
	 * 
	 * @return svCodeList
	 */
	public VRList getSvCodeList() {
		return svCodeList;
	}

	/**
	 * svCodeList��ݒ肵�܂��B
	 * 
	 * @param svCodeList
	 *            svCodeList
	 */
	public void setSvCodeList(VRList svCodeList) {
		this.svCodeList = svCodeList;
	}

	private ACTableModelAdapter svCodeTableModel;

	/**
	 * svCodeTableModel��Ԃ��܂��B
	 * 
	 * @return svCodeTableModel
	 */
	protected ACTableModelAdapter getSvCodeTableModel() {
		return this.svCodeTableModel;
	}

	/**
	 * svCodeTableModel��ݒ肵�܂��B
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
	 * �l�o�C���h�㏈��
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public void binded() throws Exception {
		// �T�[�r�X�p�l���f�[�^�o�C���h����̃p�l���f�[�^�̕ҏW����
		if (this.getParent() instanceof ACPanel) {
			ACPanel panel = (ACPanel) this.getParent();
			// Map����ꂽ�ꍇ
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
		// ��ʏ�Ԑ���
		checkState();
	}
	
	/**
	 * �R�[�h����}�X�^���Q�Ƃ��A�ꗗ�֒ǉ�
	 * @param insurerId �ی��Ҕԍ�
	 * @param itemCode �T�[�r�X���ڃR�[�h
	 * @return �ꗗ�֒ǉ������ꍇtrue�A�����łȂ����false
	 * @throws Exception
	 */
	protected boolean findCodeToList(String insurerId, String itemCode) throws Exception {
		String key = QkanSjServiceCodeManager.createSjServiceCodeKey(insurerId,
				getSystemServiceKindDetail(), itemCode);
		VRMap ret = QkanSjServiceCodeManager.getSjServiceCodeByKey(getDBManager(), key,
				getCalculater().getTargetDate());
		if (ret.isEmpty()) {
			QkanMessageList.getInstance().NOT_FOUND("�R�[�h");
			return false;
		}
		// �ǉ����`�F�b�N����
		if (checkAddCode(ret)) {
			// �ꗗ�ɒǉ�
			getSvCodeList().add(ret);
			getSvCodeTableModel().setAdaptee(getSvCodeList());
			// ��ʏ�Ԑ���
			checkState();
			return true;
		}
		return false;
	}
	
	/**
	 * �R�[�h�I���_�C�A���O���N�����A�I���R�[�h���ꗗ�֒ǉ�
	 * @param insurerId �ی��Ҕԍ�
	 * @return �ꗗ�֒ǉ������ꍇtrue�A�����łȂ����false
	 * @throws Exception
	 */
	protected boolean selectCodeToList(String insurerId) throws Exception {
		// �R�[�h�I���_�C�A���O���N�����āA�I�����R�[�h��ret�Ɋi�[
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
		// �ǉ����`�F�b�N����
		if (checkAddCode(ret)) {
			// �ꗗ�ɒǉ�
			getSvCodeList().add(ret);
			getSvCodeTableModel().setAdaptee(getSvCodeList());
			// ��ʏ�Ԑ���
			checkState();
			return true;
		}
		return false;
	}

	// �T�[�r�X�R�[�h�ꗗ�f�[�^���o�C���h�p�X�Ƃ��ăT�[�r�X�ɒǉ�
	protected void addSvCodeToData(VRMap data) throws Exception {
		// ��U�폜����
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

	// �T�[�r�X�R�[�h�ꗗ�ɒǉ�����ۂ̃`�F�b�N
	protected boolean checkAddCode(VRMap target) throws Exception {
		Iterator it = getSvCodeList().iterator();
		while (it.hasNext()) {
			Map row = (Map) it.next();
			// �ی��҂��قȂ�
			if (!ACCastUtilities.toString(target.get("INSURER_ID")).equals(
					ACCastUtilities.toString(row.get("INSURER_ID")))) {
				QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(
						"�ی��҂��قȂ�R�[�h�͓����ɓo�^�ł��܂���B" + ACConstants.LINE_SEPARATOR
								+ "�ʂ̃T�[�r�X�Ƃ��ăR�[�h");
				return false;
			}
			// ���t�����قȂ�
			if (!ACCastUtilities.toString(target.get("KYUFURITSU")).equals(
					ACCastUtilities.toString(row.get("KYUFURITSU")))) {
				QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(
						"���t�����قȂ�R�[�h�͓����ɓo�^�ł��܂���B" + ACConstants.LINE_SEPARATOR
								+ "�ʂ̃T�[�r�X�Ƃ��ăR�[�h");
				return false;
			}
			// ���ɒǉ�����Ă���R�[�h
			if (ACCastUtilities.toString(target.get("SERVICE_CODE_ITEM"))
					.equals(ACCastUtilities.toString(row
							.get("SERVICE_CODE_ITEM")))) {
				QkanMessageList.getInstance().ERROR_OF_SAME_DATA_FOUND("�R�[�h");
				return false;
			}
		}
		return true;
	}
	
	// �ی��҃R���{�̏����l���擾
	protected String getInitialInsurerId() throws Exception {
		// ���p�҂̊Y�����̗v���F�藚������ی��҂��擾����B
		Date targetDate = getCalculater().getTargetDate();
		VRMap map = getCalculater().getPatientInsureInfoOnTargetDay(targetDate);
		if (map == null) {
			return null;
		}
		String insurerId = ACCastUtilities.toString(map.get("INSURER_ID"));

		// �Z���n����̏ꍇ�́A������̕ی��҂�I������
		String jushotiTokureiInsurerId = getCalculater()
				.getJushotiTokureiInsurerId(getCalculater().getTargetDate());
		if (!ACTextUtilities.isNullText(jushotiTokureiInsurerId)) {
			insurerId = jushotiTokureiInsurerId;
		}
		return insurerId;
	}

	/**
	 * �u��ʏ�Ԑ���v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	protected void checkState() throws Exception {
		//�q�N���X�ɂĎ���
	}

}
