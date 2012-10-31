
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
 *****************************************************************
 * �A�v��: QKANCHO
 * �J����: �����@�L
 * �쐬��: 2006/01/24  ���{�R���s���[�^�[������� �����@�L �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �������o�� (P)
 * �v���Z�X �������� (001)
 * �v���O���� �ً}���{�ݗ×{���R�[�h (QP001RecordEmergency)
 *
 *****************************************************************
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
 * �ً}���{�ݗ×{���R�[�h
 *
 */
public class QP001RecordEmergency extends QP001RecordAbstract {
	//������񎯕ʔԍ�4��
	private String _401001 = "";
	//���R�[�h��ʃR�[�h2��
	private static final String _401002 = "03";
	//�T�[�r�X�񋟔N��6��(YYYYMM)
	private String _401003 = "";
	//���Ə��ԍ�10��
	private String _401004 = "";
	//�؋L�ڕی��Ҕԍ�8��
	private String _401005 = "";
	//��ی��Ҕԍ�10��
	private String _401006 = "";
	//�ً}���{�ݗ×{��񃌃R�[�h�����ԍ�2��
	private int _401007 = 0;
	//�ً}�����a��1 40��
	private String _401008 = "";
	//�ً}�����a��2 40��
	private String _401009 = "";
	//�ً}�����a��3 40��
	private String _401010 = "";
	//�ً}�����ÊJ�n�N����1 8��(YYYYMMDD)
	private String _401011 = "";
	//�ً}�����ÊJ�n�N����2 8��(YYYYMMDD)
	private String _401012 = "";
	//�ً}�����ÊJ�n�N����3 8��(YYYYMMDD)
	private String _401013 = "";
	//���f����2��
	private int _401014 = 0;
	//���f��Ë@�֖�40��
	private String _401015 = "";
	//�ʉ@����2��
	private int _401016 = 0;
	//�ʉ@��Ë@�֖�40��
	private String _401017 = "";
	//�ً}�����ÊǗ��P�ʐ�6��
	private int _401018 = 0;
	//�ً}�����ÊǗ�����2��
	private int _401019 = 0;
	//�ً}�����ÊǗ����v7��
	private int _401020 = 0;
	//���n�r���e�[�V�����_��7��
	private int _401021 = 0;
	//���u�_��7��
	private int _401022 = 0;
	//��p�_��7��
	private int _401023 = 0;
	//�����_��7��
	private int _401024 = 0;
	//���ː����Ó_��7��
	private int _401025 = 0;
	//�E�v1 64��
	private String _401026 = "";
	//�E�v2 64��
	private String _401027 = "";
	//�E�v3 64��
	private String _401028	= "";
	//�E�v4 64��
	private String _401029 = "";
	//�E�v5 64��
	private String _401030 = "";
	//�E�v6 64��
	private String _401031 = "";
	//�E�v7 64��
	private String _401032 = "";
	//�E�v8 64��
	private String _401033 = "";
	//�E�v9 64��
	private String _401034 = "";
	//�E�v10 64��
	private String _401035 = "";
	//�E�v11 64��
	private String _401036 = "";
	//�E�v12 64��
	private String _401037 = "";
	//�E�v13 64��
	private String _401038 = "";
	//�E�v14 64��
	private String _401039 = "";
	//�E�v15 64��
	private String _401040 = "";
	//�E�v16 64��
	private String _401041 = "";
	//�E�v17 64��
	private String _401042 = "";
	//�E�v18 64��
	private String _401043 = "";
	//�E�v19 64��
	private String _401044 = "";
	//�E�v20 64��
	private String _401045 = "";
	//�ً}���{�ݗ×{��v�_��8��
	private int _401046 = 0;


	protected String getSerialId() {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		return null;
	}

	/**
	 * ���R�[�h��ʃR�[�h2�����擾����B
	 * @return
	 */
	protected static String get_401002() {
		return _401002;
	}
	/**
	 * ������񎯕ʔԍ�4�����擾����B
	 * @return
	 */
	protected String get_401001() {
		return _401001;
	}
	/**
	 * ������񎯕ʔԍ�4����ݒ肷��B
	 * @param _401001
	 */
	protected void set_401001(String _401001) {
		this._401001 = _401001;
	}
	/**
	 * �T�[�r�X�񋟔N��6��(YYYYMM)���擾����B
	 * @return
	 */
	protected String get_401003() {
		return _401003;
	}
	/**
	 * �T�[�r�X�񋟔N��6��(YYYYMM)��ݒ肷��B
	 * @param _401003
	 */
	protected void set_401003(String _401003) {
		this._401003 = _401003;
	}
	/**
	 * ���Ə��ԍ�10�����擾����B
	 * @return
	 */
	protected String get_401004() {
		return _401004;
	}
	/**
	 * ���Ə��ԍ�10����ݒ肷��B
	 * @param _401004
	 */
	protected void set_401004(String _401004) {
		this._401004 = _401004;
	}
	/**
	 * �؋L�ڕی��Ҕԍ�8�����擾����B
	 */
	protected String get_401005() {
		return _401005;
	}
	/**
	 * �؋L�ڕی��Ҕԍ�8����ݒ肷��B
	 * @param _401005
	 */
	protected void set_401005(String _401005) {
		this._401005 = _401005;
	}
	/**
	 * ��ی��Ҕԍ�10�����擾����B
	 * @return
	 */
	protected String get_401006() {
		return _401006;
	}
	/**
	 * ��ی��Ҕԍ�10����ݒ肷��B
	 * @param _401006
	 */
	protected void set_401006(String _401006) {
		this._401006 = _401006;
	}
	/**
	 * �ً}���{�ݗ×{��񃌃R�[�h�����ԍ�2�����擾����B
	 * @return
	 */
	protected int get_401007() {
		return _401007;
	}
	/**
	 * �ً}���{�ݗ×{��񃌃R�[�h�����ԍ�2����ݒ肷��B
	 * @param _401007
	 */
	protected void set_401007(int _401007) {
		this._401007 = _401007;
	}
	/**
	 * �ً}�����a��1 40�����擾����B
	 * @return
	 */
	protected String get_401008() {
		return _401008;
	}
	/**
	 * �ً}�����a��1 40����ݒ肷��B
	 * @param _401008
	 */
	protected void set_401008(String _401008) {
		this._401008 = _401008;
	}
	/**
	 * �ً}�����a��2 40�����擾����B
	 * @return
	 */
	protected String get_401009() {
		return _401009;
	}
	/**
	 * �ً}�����a��2 40����ݒ肷��B
	 * @param _401009
	 */
	protected void set_401009(String _401009) {
		this._401009 = _401009;
	}
	/**
	 * �ً}�����a��3 40�����擾����B
	 * @return
	 */
	protected String get_401010() {
		return _401010;
	}
	/**
	 * �ً}�����a��3 40����ݒ肷��B
	 * @param _401010
	 */
	protected void set_401010(String _401010) {
		this._401010 = _401010;
	}
	/**
	 * �ً}�����ÊJ�n�N����1 8��(YYYYMMDD)���擾����B
	 * @return
	 */
	protected String get_401011() {
		return _401011;
	}
	/**
	 * �ً}�����ÊJ�n�N����1 8��(YYYYMMDD)��ݒ肷��B
	 * @param _401011
	 */
	protected void set_401011(String _401011) {
		this._401011 = _401011;
	}
	/**
	 * �ً}�����ÊJ�n�N����2 8��(YYYYMMDD)���擾����B
	 * @return
	 */
	protected String get_401012() {
		return _401012;
	}
	/**
	 * �ً}�����ÊJ�n�N����2 8��(YYYYMMDD)��ݒ肷��B
	 * @param _401012
	 */
	protected void set_401012(String _401012) {
		this._401012 = _401012;
	}
	/**
	 * �ً}�����ÊJ�n�N����3 8��(YYYYMMDD)���擾����B
	 * @return
	 */
	protected String get_401013() {
		return _401013;
	}
	/**
	 * �ً}�����ÊJ�n�N����3 8��(YYYYMMDD)��ݒ肷��B
	 * @param _401013
	 */
	protected void set_401013(String _401013) {
		this._401013 = _401013;
	}
	/**
	 * ���f����2�����擾����B
	 * @return
	 */
	protected int get_401014() {
		return _401014;
	}
	/**
	 * ���f����2����ݒ肷��B
	 * @param _401014
	 */
	protected void set_401014(int _401014) {
		this._401014 = _401014;
	}
	/**
	 * ���f��Ë@�֖�40�����擾����B
	 * @return
	 */
	protected String get_401015() {
		return _401015;
	}
	/**
	 * ���f��Ë@�֖�40����ݒ肷��B
	 * @param _401015
	 */
	protected void set_401015(String _401015) {
		this._401015 = _401015;
	}
	/**
	 * �ʉ@����2�����擾����B
	 * @return
	 */
	protected int get_401016() {
		return _401016;
	}
	/**
	 * �ʉ@����2����ݒ肷��B
	 * @param _401016
	 */
	protected void set_401016(int _401016) {
		this._401016 = _401016;
	}
	/**
	 * �ʉ@��Ë@�֖�40�����擾����B
	 * @return
	 */
	protected String get_401017() {
		return _401017;
	}
	/**
	 * �ʉ@��Ë@�֖�40����ݒ肷��B
	 * @param _401017
	 */
	protected void set_401017(String _401017) {
		this._401017 = _401017;
	}
	/**
	 * �ً}�����ÊǗ��P�ʐ�6�����擾����B
	 * @return
	 */
	protected int get_401018() {
		return _401018;
	}
	/**
	 * �ً}�����ÊǗ��P�ʐ�6����ݒ肷��B
	 * @param _401018
	 */
	protected void set_401018(int _401018) {
		this._401018 = _401018;
	}
	/**
	 * �ً}�����ÊǗ�����2�����擾����B
	 * @return
	 */
	protected int get_401019() {
		return _401019;
	}
	/**
	 * �ً}�����ÊǗ�����2����ݒ肷��B
	 * @param _401019
	 */
	protected void set_401019(int _401019) {
		this._401019 = _401019;
	}
	/**
	 * �ً}�����ÊǗ����v7�����擾����B
	 * @return
	 */
	protected int get_401020() {
		return _401020;
	}
	/**
	 * �ً}�����ÊǗ����v7����ݒ肷��B
	 * @param _401020
	 */
	protected void set_401020(int _401020) {
		this._401020 = _401020;
	}
	/**
	 * ���n�r���e�[�V�����_��7�����擾����B
	 * @return
	 */
	protected int get_401021() {
		return _401021;
	}
	/**
	 * ���n�r���e�[�V�����_��7����ݒ肷��B
	 * @param _401021
	 */
	protected void set_401021(int _401021) {
		this._401021 = _401021;
	}
	/**
	 * ���u�_��7�����擾����B
	 * @return
	 */
	protected int get_401022() {
		return _401022;
	}
	/**
	 * ���u�_��7����ݒ肷��B
	 * @param _401022
	 */
	protected void set_401022(int _401022) {
		this._401022 = _401022;
	}
	/**
	 * ��p�_��7�����擾����B
	 * @return
	 */
	protected int get_401023() {
		return _401023;
	}
	/**
	 * ��p�_��7����ݒ肷��B
	 * @param _401023
	 */
	protected void set_401023(int _401023) {
		this._401023 = _401023;
	}
	/**
	 * �����_��7�����擾����B
	 * @return
	 */
	protected int get_401024() {
		return _401024;
	}
	/**
	 * �����_��7����ݒ肷��B
	 * @param _401024
	 */
	protected void set_401024(int _401024) {
		this._401024 = _401024;
	}
	/**
	 * ���ː����Ó_��7�����擾����B
	 */
	protected int get_401025() {
		return _401025;
	}
	/**
	 * ���ː����Ó_��7����ݒ肷��B
	 * @param _401025
	 */
	protected void set_401025(int _401025) {
		this._401025 = _401025;
	}
	/**
	 * �E�v1 64�����擾����B
	 * @return
	 */
	protected String get_401026() {
		return _401026;
	}
	/**
	 * �E�v1 64����ݒ肷��B
	 * @param _401026
	 */
	protected void set_401026(String _401026) {
		this._401026 = _401026;
	}
	/**
	 * �E�v2 64�����擾����B
	 * @return
	 */
	protected String get_401027() {
		return _401027;
	}
	/**
	 * �E�v2 64����ݒ肷��B
	 * @param _401027
	 */
	protected void set_401027(String _401027) {
		this._401027 = _401027;
	}
	/**
	 * �E�v3 64�����擾����B
	 * @return
	 */
	protected String get_401028() {
		return _401028;
	}
	/**
	 * �E�v3 64����ݒ肷��B
	 * @param _401028
	 */
	protected void set_401028(String _401028) {
		this._401028 = _401028;
	}
	/**
	 * �E�v4 64�����擾����B
	 * @return
	 */
	protected String get_401029() {
		return _401029;
	}
	/**
	 * �E�v4 64����ݒ肷��B
	 * @param _401029
	 */
	protected void set_401029(String _401029) {
		this._401029 = _401029;
	}
	/**
	 * �E�v5 64�����擾����B
	 * @return
	 */
	protected String get_401030() {
		return _401030;
	}
	/**
	 * �E�v5 64����ݒ肷��B
	 * @param _401030
	 */
	protected void set_401030(String _401030) {
		this._401030 = _401030;
	}
	/**
	 * �E�v6 64�����擾����B
	 * @return
	 */
	protected String get_401031() {
		return _401031;
	}
	/**
	 * �E�v6 64����ݒ肷��B
	 * @param _401031
	 */
	protected void set_401031(String _401031) {
		this._401031 = _401031;
	}
	/**
	 * �E�v7 64�����擾����B
	 * @return
	 */
	protected String get_401032() {
		return _401032;
	}
	/**
	 * �E�v7 64����ݒ肷��B
	 * @param _401032
	 */
	protected void set_401032(String _401032) {
		this._401032 = _401032;
	}
	/**
	 * �E�v8 64�����擾����B
	 * @return
	 */
	protected String get_401033() {
		return _401033;
	}
	/**
	 * �E�v8 64����ݒ肷��B
	 * @param _401033
	 */
	protected void set_401033(String _401033) {
		this._401033 = _401033;
	}
	/**
	 * �E�v9 64�����擾����B
	 * @return
	 */
	protected String get_401034() {
		return _401034;
	}
	/**
	 * �E�v9 64����ݒ肷��B
	 * @param _401034
	 */
	protected void set_401034(String _401034) {
		this._401034 = _401034;
	}
	/**
	 * �E�v10 64�����擾����B
	 * @return
	 */
	protected String get_401035() {
		return _401035;
	}
	/**
	 * �E�v10 64����ݒ肷��B
	 * @param _401035
	 */
	protected void set_401035(String _401035) {
		this._401035 = _401035;
	}
	/**
	 * �E�v11 64�����擾����B
	 * @return
	 */
	protected String get_401036() {
		return _401036;
	}
	/**
	 * �E�v11 64����ݒ肷��B
	 * @param _401036
	 */
	protected void set_401036(String _401036) {
		this._401036 = _401036;
	}
	/**
	 * �E�v12 64�����擾����B
	 * @return
	 */
	protected String get_401037() {
		return _401037;
	}
	/**
	 * �E�v12 64����ݒ肷��B
	 * @param _401037
	 */
	protected void set_401037(String _401037) {
		this._401037 = _401037;
	}
	/**
	 * �E�v13 64�����擾����B
	 * @return
	 */
	protected String get_401038() {
		return _401038;
	}
	/**
	 * �E�v13 64����ݒ肷��B
	 * @param _401038
	 */
	protected void set_401038(String _401038) {
		this._401038 = _401038;
	}
	/**
	 * �E�v14 64�����擾����B
	 * @return
	 */
	protected String get_401039() {
		return _401039;
	}
	/**
	 * �E�v14 64����ݒ肷��B
	 * @param _401039
	 */
	protected void set_401039(String _401039) {
		this._401039 = _401039;
	}
	/**
	 * �E�v15 64�����擾����B
	 * @return
	 */
	protected String get_401040() {
		return _401040;
	}
	/**
	 * �E�v15 64����ݒ肷��B
	 * @param _401040
	 */
	protected void set_401040(String _401040) {
		this._401040 = _401040;
	}
	/**
	 * �E�v16 64�����擾����B
	 * @return
	 */
	protected String get_401041() {
		return _401041;
	}
	/**
	 * �E�v16 64����ݒ肷��B
	 * @param _401041
	 */
	protected void set_401041(String _401041) {
		this._401041 = _401041;
	}
	/**
	 * �E�v17 64�����擾����B
	 * @return
	 */
	protected String get_401042() {
		return _401042;
	}
	/**
	 * �E�v17 64����ݒ肷��B
	 * @param _401042
	 */
	protected void set_401042(String _401042) {
		this._401042 = _401042;
	}
	/**
	 * �E�v18 64�����擾����B
	 * @return
	 */
	protected String get_401043() {
		return _401043;
	}
	/**
	 * �E�v18 64����ݒ肷��B
	 * @param _401043
	 */
	protected void set_401043(String _401043) {
		this._401043 = _401043;
	}
	/**
	 * �E�v19 64�����擾����B
	 * @return
	 */
	protected String get_401044() {
		return _401044;
	}
	/**
	 * �E�v19 64����ݒ肷��B
	 * @param _401044
	 */
	protected void set_401044(String _401044) {
		this._401044 = _401044;
	}
	/**
	 * �E�v20 64�����擾����B
	 * @return
	 */
	protected String get_401045() {
		return _401045;
	}
	/**
	 * �E�v20 64����ݒ肷��B
	 * @param _401045
	 */
	protected void set_401045(String _401045) {
		this._401045 = _401045;
	}
	/**
	 * �ً}���{�ݗ×{��v�_��8�����擾����B
	 * @return
	 */
	protected int get_401046() {
		return _401046;
	}
	/**
	 * �ً}���{�ݗ×{��v�_��8����ݒ肷��B
	 * @param _401046
	 */
	protected void set_401046(int _401046) {
		this._401046 = _401046;
	}
	/**
	 * ���ɏ�񂪓o�^����Ă��邩�ԋp���܂��B
	 * @return �V�K:true �ǉ�:false
	 */
	private boolean isNew(){
		//������񃌃R�[�h�ɓo�^��������ΐV�K�Ƃ݂Ȃ��B
		return ((get_401001() == null) || ("".equals(get_401001())));
	}

	/**
	 * �f�[�^�̃p�[�X�����s���܂��B
	 * @param serviceDetail
	 * @param targetDate
	 * @param patientState
	 * @param serviceCode
	 * @throws Exception
	 */
	protected void parse(
			VRMap serviceDetail,
			Date targetDate,
			QP001PatientState patientState,
            VRMap serviceCode,
			String identificationNo,
            QP001Manager manager) throws Exception {
		
		Object targetServiceDate = VRBindPathParser.get("SERVICE_DATE",serviceDetail);
		if(isNew()){
			//type �� KEY : 401001(������񎯕ʔԍ�4��) �� VALUE : ��U������ݒ肷��B
			set_401001(identificationNo);
  		
			
			//type �� KEY : 401003(�T�[�r�X�񋟔N��) ��
			//VALUE : yyyyMM�`���Ƀt�H�[�}�b�g����targetDate��ݒ肷��B
			set_401003(VRDateParser.format(targetDate,"yyyyMM"));
  		
			//type �� KEY : 401004(���Ə��ԍ�) ��
			//VALUE : 10���t�H�[�}�b�g�������Ə��ԍ�(serviceDetail���擾)��ݒ肷��B
			set_401004(ACCastUtilities.toString(VRBindPathParser.get("PROVIDER_ID",serviceDetail)));
  		
			//type �� KEY : 401005(�؋L�ڕی��Ҕԍ�) ��
			//VALUE : 8���t�H�[�}�b�g�������p�҂̕ی��Ҕԍ�(patient���擾)��ݒ肷��B
			set_401005(patientState.getInsurerId(targetServiceDate));
  		
			//type �� KEY : 401006(��ی��Ҕԍ�) ��
			//VALUE : 10���t�H�[�}�b�g�������p�҂̔�ی��Ҕԍ�(patient���擾)��ݒ肷��B
			set_401006(patientState.getInsuredId(targetServiceDate));
			//���R�[�h�����ԍ�
			set_401007(99);
			//�ً}���ÊǗ��P�ʐ�
			//set_401018(QP001Manager.getInstance().getServiceUnit(get_401004(),serviceCode));
            set_401018(manager.getServiceUnit(get_401004(),serviceCode));
			//�ً}�����ÊǗ�����
			set_401019(1);

			
		} else {
			//�ً}�����ÊǗ������ɂP��������B
			set_401019(get_401019() + 1);
		}
		
	}
	
	/**
	 * ���R�[�h���e�̊m����s���B
	 */
	protected void commitRecord() throws Exception {
        set_401007(99);
		//���v���Z�o����B
		set_401020(get_401018() * get_401019());
        
        //�����v���Z�o����B
//        set_401046(get_401020()
//                + get_401021()
//                + get_401022()
//                + get_401023()
//                + get_401024()
//                + get_401025());
        //401020�͍Čf�Ȃ̂ō��v�Ɋ܂߂Ă͂����Ȃ��B
        set_401046(get_401021()
                + get_401022()
                + get_401023()
                + get_401024()
                + get_401025());
        
	}
	
	/**
	 * �f�[�^�쐬
	 * @param style
	 * @return
	 */
	protected VRMap getRecord(VRMap style) throws Exception {
		VRMap result = copyStyle(style);
		
		setData(result,"401001",get_401001());
		setData(result,"401002",get_401002());
		setData(result,"401003",get_401003());
		setData(result,"401004",get_401004());
		setData(result,"401005",get_401005());
		setData(result,"401006",get_401006());
		setData(result,"401007",get_401007());
		setData(result,"401008",get_401008());
		setData(result,"401009",get_401009());
		
		setData(result,"401010",get_401010());
		setData(result,"401011",get_401011());
		setData(result,"401012",get_401012());
		setData(result,"401013",get_401013());
		setData(result,"401014",get_401014());
		setData(result,"401015",get_401015());
		setData(result,"401016",get_401016());
		setData(result,"401017",get_401017());
		setData(result,"401018",get_401018());
		setData(result,"401019",get_401019());

		setData(result,"401020",get_401020());
		setData(result,"401021",get_401021());
		setData(result,"401022",get_401022());
		setData(result,"401023",get_401023());
		setData(result,"401024",get_401024());
		setData(result,"401025",get_401025());
		setData(result,"401026",get_401026());
		setData(result,"401027",get_401027());
		setData(result,"401028",get_401028());
		setData(result,"401029",get_401029());
		
		setData(result,"401030",get_401030());
		setData(result,"401031",get_401031());
		setData(result,"401032",get_401032());
		setData(result,"401033",get_401033());
		setData(result,"401034",get_401034());
		setData(result,"401035",get_401035());
		setData(result,"401036",get_401036());
		setData(result,"401037",get_401037());
		setData(result,"401038",get_401038());
		setData(result,"401039",get_401039());
		
		setData(result,"401040",get_401040());
		setData(result,"401041",get_401041());
		setData(result,"401042",get_401042());
		setData(result,"401043",get_401043());
		setData(result,"401044",get_401044());
		setData(result,"401045",get_401045());
		setData(result,"401046",get_401046());
		
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
		//�ً}���{�ݗ×{��񃌃R�[�h
		//result.put("CATEGORY_NO","4");
        result.put("CATEGORY_NO",QkanConstants.CATEGORY_NO_RECORD_EMERGENCY_INSTITUTION);
		return result;
	}
	
	public String toString(){
		StringBuilder result = new StringBuilder();
		result.append("[401001=" + get_401001() + "]\n");
		result.append("[401002=" + get_401002() + "]\n");
		result.append("[401003=" + get_401003() + "]\n");
		result.append("[401004=" + get_401004() + "]\n");
		result.append("[401005=" + get_401005() + "]\n");
		result.append("[401006=" + get_401006() + "]\n");
		result.append("[401007=" + get_401007() + "]\n");
		result.append("[401008=" + get_401008() + "]\n");
		result.append("[401009=" + get_401009() + "]\n");
		
		result.append("[401010=" + get_401010() + "]\n");
		result.append("[401011=" + get_401011() + "]\n");
		result.append("[401012=" + get_401012() + "]\n");
		result.append("[401013=" + get_401013() + "]\n");
		result.append("[401014=" + get_401014() + "]\n");
		result.append("[401015=" + get_401015() + "]\n");
		result.append("[401016=" + get_401016() + "]\n");
		result.append("[401017=" + get_401017() + "]\n");
		result.append("[401018=" + get_401018() + "]\n");
		result.append("[401019=" + get_401019() + "]\n");

		result.append("[401020=" + get_401020() + "]\n");
		result.append("[401021=" + get_401021() + "]\n");
		result.append("[401022=" + get_401022() + "]\n");
		result.append("[401023=" + get_401023() + "]\n");
		result.append("[401024=" + get_401024() + "]\n");
		result.append("[401025=" + get_401025() + "]\n");
		result.append("[401026=" + get_401026() + "]\n");
		result.append("[401027=" + get_401027() + "]\n");
		result.append("[401028=" + get_401028() + "]\n");
		result.append("[401029=" + get_401029() + "]\n");
		
		result.append("[401030=" + get_401030() + "]\n");
		result.append("[401031=" + get_401031() + "]\n");
		result.append("[401032=" + get_401032() + "]\n");
		result.append("[401033=" + get_401033() + "]\n");
		result.append("[401034=" + get_401034() + "]\n");
		result.append("[401035=" + get_401035() + "]\n");
		result.append("[401036=" + get_401036() + "]\n");
		result.append("[401037=" + get_401037() + "]\n");
		result.append("[401038=" + get_401038() + "]\n");
		result.append("[401039=" + get_401039() + "]\n");
		
		result.append("[401040=" + get_401040() + "]\n");
		result.append("[401041=" + get_401041() + "]\n");
		result.append("[401042=" + get_401042() + "]\n");
		result.append("[401043=" + get_401043() + "]\n");
		result.append("[401044=" + get_401044() + "]\n");
		result.append("[401045=" + get_401045() + "]\n");
		result.append("[401046=" + get_401046() + "]\n");
		
		return result.toString();
		
	}
}
