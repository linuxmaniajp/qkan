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

package jp.nichicom.ac.lib.care.claim.calculation;

import java.util.Date;
import java.util.Iterator;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.text.parsers.VRDateParser;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanConstants;

/**
 * ��{�E�v��񃌃R�[�h
 *
 */
public class QP001RecordBaseSummary extends QP001RecordAbstract {
	//������񎯕ʔԍ�4��
	private String _1901001 = "";
	//���R�[�h��ʃR�[�h2��
	private static final String _1901002 = "16";
	//�T�[�r�X�񋟔N��6��(YYYYMM)
	private String _1901003 = "";
	//���Ə��ԍ�10��
	private String _1901004 = "";
	//�؋L�ڕی��Ҕԍ�8��
	private String _1901005 = "";
	//��ی��Ҕԍ�10��
	private String _1901006 = "";
	//�E�v��ރR�[�h2��
	private String _1901007 = "";
	//���e 20��
	private String _1901008 = "";
	

	protected String getSerialId() {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		return null;
	}

	/**
	 * ���R�[�h��ʃR�[�h2�����擾����B
	 * @return
	 */
	protected static String get_1901002() {
		return _1901002;
	}
	/**
	 * ������񎯕ʔԍ�4�����擾����B
	 * @return
	 */
	protected String get_1901001() {
		return _1901001;
	}
	/**
	 * ������񎯕ʔԍ�4����ݒ肷��B
	 * @param _401001
	 */
	protected void set_1901001(String _1901001) {
		this._1901001 = _1901001;
	}
	/**
	 * �T�[�r�X�񋟔N��6��(YYYYMM)���擾����B
	 * @return
	 */
	protected String get_1901003() {
		return _1901003;
	}
	/**
	 * �T�[�r�X�񋟔N��6��(YYYYMM)��ݒ肷��B
	 * @param _1901003
	 */
	protected void set_1901003(String _1901003) {
		this._1901003 = _1901003;
	}
	/**
	 * ���Ə��ԍ�10�����擾����B
	 * @return
	 */
	protected String get_1901004() {
		return _1901004;
	}
	/**
	 * ���Ə��ԍ�10����ݒ肷��B
	 * @param _1901004
	 */
	protected void set_1901004(String _1901004) {
		this._1901004 = _1901004;
	}
	/**
	 * �؋L�ڕی��Ҕԍ�8�����擾����B
	 */
	protected String get_1901005() {
		return _1901005;
	}
	/**
	 * �؋L�ڕی��Ҕԍ�8����ݒ肷��B
	 * @param _1901005
	 */
	protected void set_1901005(String _1901005) {
		this._1901005 = _1901005;
	}
	/**
	 * ��ی��Ҕԍ�10�����擾����B
	 * @return
	 */
	protected String get_1901006() {
		return _1901006;
	}
	/**
	 * ��ی��Ҕԍ�10����ݒ肷��B
	 * @param _1901006
	 */
	protected void set_1901006(String _1901006) {
		this._1901006 = _1901006;
	}
	/**
	 * �E�v��ރR�[�h2��
	 * @return
	 */
	protected String get_1901007() {
		return _1901007;
	}
	/**
	 * �E�v��ރR�[�h2����ݒ肷��B
	 * @param _1901007
	 */
	protected void set_1901007(String _1901007) {
		this._1901007 = _1901007;
	}
	/**
	 * ���e 20�����擾����B
	 * @return
	 */
	protected String get_1901008() {
		return _1901008;
	}
	/**
	 * ���e 20����ݒ肷��B
	 * @param _1901008
	 */
	protected void set_1901008(String _1901008) {
		this._1901008 = _1901008;
	}
	
	/**
	 * ���ɏ�񂪓o�^����Ă��邩�ԋp���܂��B
	 * @return �V�K:true �ǉ�:false
	 */
	private boolean isNew(){
		//������񃌃R�[�h�ɓo�^��������ΐV�K�Ƃ݂Ȃ��B
		return ((get_1901001() == null) || ("".equals(get_1901001())));
	}

	/**
	 * �f�[�^�̃p�[�X�����s���܂��B
	 * @param serviceDetail
	 * @param targetDate
	 * @param patientState
	 * @param serviceCode
	 * @param identificationNo
	 * @param manager
	 * @param baseSummaryKind
	 * @throws Exception
	 */
	protected void parse(
			VRMap serviceDetail,
			Date targetDate,
			QP001PatientState patientState,
            VRMap serviceCode,
			String identificationNo,
            QP001Manager manager,
            String baseSummaryKind) throws Exception {
		
		Object targetServiceDate = VRBindPathParser.get("SERVICE_DATE",serviceDetail);
		if (isNew()) {
			// ������񎯕ʔԍ�4��
			set_1901001(identificationNo);

			// �T�[�r�X�񋟔N��
			set_1901003(VRDateParser.format(targetDate, "yyyyMM"));

			// ���Ə��ԍ�
			set_1901004(ACCastUtilities.toString(VRBindPathParser.get("PROVIDER_ID", serviceDetail)));

			// �؋L�ڕی��Ҕԍ�
			set_1901005(patientState.getInsurerId(targetServiceDate));

			// ��ی��Ҕԍ�
			set_1901006(patientState.getInsuredId(targetServiceDate));
			
			// �E�v��ރR�[�h
			set_1901007(baseSummaryKind);
			
			// ���e 20��
			set_1901008("");
		}
		
	}
	
	/**
	 * ���R�[�h���e�̊m����s���B
	 */
	protected void commitRecord(QP001PatientState patientState) throws Exception {
        // ��{�E�v���e�̑O�����p������
		String lastNaiyo = patientState.getLastRecapitulationCategory19(get_1901001(), get_1901007());
		if (!"".equals(lastNaiyo)) {
			set_1901008(lastNaiyo);
		}		
	}
	
	/**
	 * �f�[�^�쐬
	 * @param style
	 * @return
	 */
	protected VRMap getRecord(VRMap style) throws Exception {
		VRMap result = copyStyle(style);
		
		setData(result,"1901001", get_1901001());
		setData(result,"1901002", get_1901002());
		setData(result,"1901003", get_1901003());
		setData(result,"1901004", get_1901004());
		setData(result,"1901005", get_1901005());
		setData(result,"1901006", get_1901006());
		setData(result,"1901007", get_1901007());
		setData(result,"1901008", get_1901008());
		
		return result;
	}
	
	private VRMap copyStyle(VRMap style){
		VRMap result = new VRHashMap();
		Object key;
		//�f�B�[�v�R�s�[
		Iterator it = style.keySet().iterator();
		while(it.hasNext()){
			key = it.next();
			result.put(key,style.get(key));
		}
        result.put("CATEGORY_NO", QkanConstants.CATEGORY_NO_RECORD_BASE_SUMMARY);
		return result;
	}
	
	public String toString(){
		StringBuilder result = new StringBuilder();
		result.append("[1901001=" + get_1901001() + "]\n");
		result.append("[1901002=" + get_1901002() + "]\n");
		result.append("[1901003=" + get_1901003() + "]\n");
		result.append("[1901004=" + get_1901004() + "]\n");
		result.append("[1901005=" + get_1901005() + "]\n");
		result.append("[1901006=" + get_1901006() + "]\n");
		result.append("[1901007=" + get_1901007() + "]\n");
		result.append("[1901008=" + get_1901008() + "]\n");
		
		return result.toString();
		
	}
}
