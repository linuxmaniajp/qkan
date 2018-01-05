
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
 * �v���O���� �W�v��񃌃R�[�h (QP001RecordType)
 *
 *****************************************************************
 */

package jp.nichicom.ac.lib.care.claim.calculation;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.Map;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.ac.util.ACDateUtilities;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanConstants;
import jp.nichicom.ac.lib.care.claim.calculation.QP001SjClaimCalc.KohiyusenType;
import jp.nichicom.ac.lib.care.claim.servicecode.CareServiceCommon; //20140210 add
import jp.nichicom.ac.lib.care.claim.servicecode.QkanSjLimitOverUnitException;
import jp.nichicom.ac.lib.care.claim.servicecode.QkanSjServiceCodeManager;
import jp.nichicom.ac.lib.care.claim.servicecode.QkanSjTankaManager;

/**
 * �W�v��񃌃R�[�h
 * @author shin fujihara
 *
 */
public class QP001RecordType extends QP001RecordAbstract {

	//������񎯕ʔԍ�4��
	private String _701001 = "";
	//���R�[�h��ʃR�[�h2��
	private static final String _701002 = "10";
	//�T�[�r�X�񋟔N��6��(YYYYMM)
	private String _701003 = "";
	//���Ə��ԍ�10��
	private String _701004 = "";
	//�؋L�ڕی��Ҕԍ�8��
	private String _701005 = "";
	//��ی��Ҕԍ�10��
	private String _701006 = "";
	//�T�[�r�X��ރR�[�h2��
	private String _701007 = "";
	//�T�[�r�X������2��
	private int _701008 = 0;
	//�v��P�ʐ�6��
	private int _701009 = 0;
	//���x�z�Ǘ��ΏےP�ʐ�6��
	private int _701010 = 0;
	//���x�z�Ǘ��ΏۊO�P�ʐ�6��
	private int _701011 = 0;
	//�Z�������v�����2��
	private int _701012 = 0;
	//�Z������������2��
	private int _701013 = 0;
	//(�ی�)�P�ʐ����v8��
	private int _701014 = 0;
	//(�ی�)�P�ʐ��P��4��
	private double _701015 = 0;
	//(�ی�)�����z9��
	private int _701016 = 0;
	//(�ی�)���p�ҕ��S�z8��
	private int _701017 = 0;
	//(����1)�P�ʐ����v6��
	private int _701018 = 0;
	//(����1)�����z9��
	private int _701019 = 0;
	//(����1)�{�l���S�z6��
	private int _701020 = 0;
	//(����2)�P�ʐ����v6��
	private int _701021 = 0;
	//(����2)�����z9��
	private int _701022 = 0;
	//(����2)�{�l���S�z6��
	private int _701023 = 0;
	//(����3)�P�ʐ����v6��
	private int _701024 = 0;
	//(����3)�����z9��
	private int _701025 = 0;
	//(����3)�{�l���S�z6��
	private int _701026 = 0;
	//(�ی����o������Ô�)�P�ʐ����v8��
	private int _701027 = 0;
	//(�ی����o������Ô�)�����z9��
	private int _701028 = 0;
	//(�ی����o������Ô�)�o������Ô�p�ҕ��S�z8��
	private int _701029 = 0;
	//(����1���o������Ô�)�P�ʐ����v8��
	private int _701030 = 0;
	//(����1���o������Ô�)�����z9��
	private int _701031 = 0;
	//(����1���o������Ô�)�o������Ô�{�l���S�z8��
	private int _701032 = 0;
	//(����2���o������Ô�)�P�ʐ����v8��
	private int _701033 = 0;
	//(����2���o������Ô�)�����z9��
	private int _701034 = 0;
	//(����2���o������Ô�)�o������Ô�{�l���S�z8��
	private int _701035 = 0;
	//(����3���o������Ô�)�P�ʐ����v8��
	private int _701036 = 0;
	//(����3���o������Ô�)�����z9��
	private int _701037 = 0;
	//(����3���o������Ô�)�o������Ô�{�l���S�z8��
	private int _701038 = 0;
	//�T�[�r�X����
	private String _701039 = "";
	//���t����
	private int _701040 = 0;
	//����P����ԍ�
	private String _701041 = "";
	//����Q����ԍ�
	private String _701042 = "";
	//����R����ԍ�
	private String _701043 = "";	
	//�V�X�e�����T�[�r�X��ރR�[�h(SYSTEM_SERVICE_KIND_DETAIL)
	//private String _701044 = "";
    private VRList _701044 = new VRArrayList();
	//�V�X�e�����T�[�r�X���ڃR�[�h(SYSTEM_SERVICE_CODE_ITEM)
	private String _701045 = "";
	
	//[ID:0000525][Shin Fujihara] 2009/07 add begin 2009�N�x�Ή�
	//�\��A�܂��͎��ѓ��͂œ��͂��ꂽ�v��P�ʐ�
	private String _701046 = "";
	//[ID:0000525][Shin Fujihara] 2009/07 add end 2009�N�x�Ή�

	// 2016/10/11 [Yoichiro Kamei] add - begin �������ƑΉ�
	//�������Ƃ̋敪�x�����P�ʐ�
	private String _701047 = "";
	// 2016/10/11 [Yoichiro Kamei] add - end
	
	//�T�[�r�X������
	private VRList serviceRealDays = new VRArrayList();
	//�����T�[�r�X������
	private VRList entranceRealDays = new VRArrayList();
    //�މ@(�ޏ�)������
    private VRList outEntranceRealDays = new VRArrayList();
	//����K�p�p�^��
	private VRMap kohiPattern = new VRHashMap();
    
    //�O�����p�^�g�p�t���O
    private boolean externalUse = false;
    
    /* 2006.06.02 ���v�ۂ���Ƃ̂����ɂ��A�Ή����Ȃ����Ƃ�
    //�O�����p�^���g�p�t���O
    private boolean externalNoUse = false;
    */
    
    //[ID:0000699][Shin Fujihara] 2012/03 add begin 2012�N�x�@�����Ή�
    //�l����Z�̎O�A�l����Z�̎l�̑ޔ�p���x�z�Ǘ��ΏۊO�P�ʐ�
    //���O�����p�^�ȊO�̒P�ʐ��ςݏグ
    private int _701011_temp = 0;
    //[ID:0000699][Shin Fujihara] 2012/03 add end 2012�N�x�@�����Ή�
    
    
    // 2016/10/11 [Yoichiro Kamei] add - begin �������ƑΉ�
    // �Ǝ��E�Ǝ��藦�A�Ǝ���z�p�̌v�Z
    private QP001SjClaimCalc sjClaimCalc;
    
    /**
     * �������Ƃ̓Ǝ��E�Ǝ��藦�E�Ǝ���z���ǂ�����Ԃ��܂��B
     * @return
     */
    protected boolean isDokujiTeiritsuTeigaku() {
		if (QP001StyleAbstract.IDENTIFICATION_NO_2_3_201504.equals(get_701001())
				&& QkanSjServiceCodeManager.dokujiTeiritsuTeigakuKinds.contains(get_701007())) {
			return true;
		}
		return false;
    }

    /**
     * �������Ƃ̓Ǝ����ǂ�����Ԃ��܂��B
     * @return
     */
    protected boolean isDokuji() {
		if (QP001StyleAbstract.IDENTIFICATION_NO_2_3_201504.equals(get_701001())
				&& QkanSjServiceCodeManager.dokujiKinds.contains(get_701007())) {
			return true;
		}
		return false;
    }
    
    /**
     * �������Ƃ̓Ǝ��藦���ǂ�����Ԃ��܂��B
     * @return
     */
    protected boolean isDokujiTeiritsu() {
		if (QP001StyleAbstract.IDENTIFICATION_NO_2_3_201504.equals(get_701001())
				&& QkanSjServiceCodeManager.teiritsuKinds.contains(get_701007())) {
			return true;
		}
		return false;
    }
    
    /**
     * �������Ƃ̓Ǝ���z���ǂ�����Ԃ��܂��B
     * @return 
     */
    protected boolean isDokujiTeigaku() {
		if (QP001StyleAbstract.IDENTIFICATION_NO_2_3_201504.equals(get_701001())
				&& QkanSjServiceCodeManager.teigakuKinds.contains(get_701007())) {
			return true;
		}
		return false;
    }
    // 2016/10/11 [Yoichiro Kamei] add - end
    
	/**
	 * ������񎯕ʔԍ�4�����擾����B
	 * @return
	 */
	protected String get_701001() {
		return _701001;
	}
	/**
	 * ������񎯕ʔԍ�4����ݒ肷��B
	 * @param _701001
	 */
	protected void set_701001(String _701001) {
		this._701001 = _701001;
	}	
	/**
	 * ���R�[�h��ʃR�[�h2�����擾����B
	 * @return
	 */
	protected static String get_701002() {
		return _701002;
	}
	/**
	 * �T�[�r�X�񋟔N��6��(YYYYMM)���擾����B
	 * @return
	 */
	protected String get_701003() {
		return _701003;
	}
	/**
	 * �T�[�r�X�񋟔N��6��(YYYYMM)��ݒ肷��B
	 * @param _701003
	 */
	protected void set_701003(String _701003) {
		this._701003 = _701003;
	}
	/**
	 * ���Ə��ԍ�10�����擾����B
	 * @return
	 */
	protected String get_701004() {
		return _701004;
	}
	/**
	 * ���Ə��ԍ�10����ݒ肷��B
	 * @param _701004
	 */
	protected void set_701004(String _701004) {
		this._701004 = _701004;
	}
	/**
	 * �؋L�ڕی��Ҕԍ�8�����擾����B
	 * @return
	 */
	protected String get_701005() {
		return _701005;
	}
	/**
	 * �؋L�ڕی��Ҕԍ�8����ݒ肷��B
	 * @param _701005
	 */
	protected void set_701005(String _701005) {
		this._701005 = _701005;
	}
	/**
	 * ��ی��Ҕԍ�10�����擾����B
	 * @return
	 */
	protected String get_701006() {
		return _701006;
	}
	/**
	 * ��ی��Ҕԍ�10����ݒ肷��B
	 * @param _701006
	 */
	protected void set_701006(String _701006) {
		this._701006 = _701006;
	}
	/**
	 * �T�[�r�X��ރR�[�h2�����擾����B
	 * @return
	 */
	protected String get_701007() {
		return _701007;
	}
	/**
	 * �T�[�r�X��ރR�[�h2����ݒ肷��B
	 * @param _701007
	 */
	protected void set_701007(String _701007) {
		this._701007 = _701007;
	}
	/**
	 * �T�[�r�X������2�����擾����B
	 * @return
	 */
	protected int get_701008() {
		return _701008;
	}
	/**
	 * �T�[�r�X������2����ݒ肷��B
	 * @param _701008
	 */
	protected void set_701008(int _701008) {
		this._701008 = _701008;
	}
	/**
	 * �v��P�ʐ�6�����擾����B
	 * @return
	 */
	protected int get_701009() {
		return _701009;
	}
	/**
	 * �v��P�ʐ�6����ݒ肷��B
	 * @param _701009
	 */
	protected void set_701009(int _701009) {
		this._701009 = _701009;
	}
	/**
	 * ���x�z�Ǘ��ΏےP�ʐ�6�����擾����B
	 * @return
	 */
	protected int get_701010() {
		return _701010;
	}
	/**
	 * ���x�z�Ǘ��ΏےP�ʐ�6����ݒ肷��B
	 * @param _701010
	 */
	protected void set_701010(int _701010) {
		this._701010 = _701010;
	}
	/**
	 * ���x�z�Ǘ��ΏۊO�P�ʐ�6�����擾����B
	 * @return
	 */
	protected int get_701011() {
		return _701011;
	}
	/**
	 * ���x�z�Ǘ��ΏۊO�P�ʐ�6����ݒ肷��B
	 * @param _701011
	 */
	protected void set_701011(int _701011) {
		this._701011 = _701011;
	}
	/**
	 * �Z�������v�����2�����擾����B
	 * @return
	 */
	protected int get_701012() {
		return _701012;
	}
	/**
	 * �Z�������v�����2����ݒ肷��B
	 * @param _701012
	 */
	protected void set_701012(int _701012) {
		this._701012 = _701012;
	}
	/**
	 * �Z������������2�����擾����B
	 * @return
	 */
	protected int get_701013() {
		return _701013;
	}
	/**
	 * �Z������������2����ݒ肷��B
	 * @param _701013
	 */
	protected void set_701013(int _701013) {
		this._701013 = _701013;
	}
	/**
	 * (�ی�)�P�ʐ����v8�����擾����B
	 * @return
	 */
	protected int get_701014() {
		return _701014;
	}
	/**
	 * (�ی�)�P�ʐ����v8����ݒ肷��B
	 * @param _701014
	 */
	protected void set_701014(int _701014) {
		this._701014 = _701014;
	}
	/**
	 * (�ی�)�P�ʐ��P��4�����擾����B
	 * @return
	 */
	protected double get_701015() {
		return _701015;
	}
	/**
	 * (�ی�)�P�ʐ��P��4����ݒ肷��B
	 * @param _701015
	 */
	protected void set_701015(double _701015) {
		this._701015 = _701015;
	}
	/**
	 * (�ی�)�����z9�����擾����
	 * @return
	 */
	protected int get_701016() {
		return _701016;
	}
	/**
	 * (�ی�)�����z9����ݒ肷��B
	 * @param _701016
	 */
	protected void set_701016(int _701016) {
		this._701016 = _701016;
	}
	/**
	 * (�ی�)���p�ҕ��S�z8�����擾����B
	 * @return
	 */
	protected int get_701017() {
		return _701017;
	}
	/**
	 * (�ی�)���p�ҕ��S�z8����ݒ肷��B
	 * @param _701017
	 */
	protected void set_701017(int _701017) {
		this._701017 = _701017;
	}
	/**
	 * (����1)�P�ʐ����v6�����擾����B
	 * @return
	 */
	protected int get_701018() {
		return _701018;
	}
	/**
	 * (����1)�P�ʐ����v6����ݒ肷��B
	 * @param _701018
	 */
	protected void set_701018(int _701018) {
		this._701018 = _701018;
	}
	/**
	 * (����1)�����z9�����擾����B
	 * @return
	 */
	protected int get_701019() {
		return _701019;
	}
	/**
	 * (����1)�����z9����ݒ肷��B
	 * @param _701019
	 */
	protected void set_701019(int _701019) {
		this._701019 = _701019;
	}
	/**
	 * (����1)�{�l���S�z6�����擾����B
	 * @return
	 */
	protected int get_701020() {
		return _701020;
	}
	/**
	 * (����1)�{�l���S�z6����ݒ肷��B
	 * @param _701020
	 */
	protected void set_701020(int _701020) {
		this._701020 = _701020;
	}
	/**
	 * (����2)�P�ʐ����v6�����擾����B
	 * @return
	 */
	protected int get_701021() {
		return _701021;
	}
	/**
	 * (����2)�P�ʐ����v6����ݒ肷��B
	 * @param _701021
	 */
	protected void set_701021(int _701021) {
		this._701021 = _701021;
	}
	/**
	 * (����2)�����z9�����擾����B
	 * @return
	 */
	protected int get_701022() {
		return _701022;
	}
	/**
	 * (����2)�����z9����ݒ肷��B
	 * @param _701022
	 */
	protected void set_701022(int _701022) {
		this._701022 = _701022;
	}
	/**
	 * (����2)�{�l���S�z6�����擾����B
	 * @return
	 */
	protected int get_701023() {
		return _701023;
	}
	/**
	 * (����2)�{�l���S�z6����ݒ肷��B
	 * @param _701023
	 */
	protected void set_701023(int _701023) {
		this._701023 = _701023;
	}
	/**
	 * (����3)�P�ʐ����v6�����擾����B
	 * @return
	 */
	protected int get_701024() {
		return _701024;
	}
	/**
	 * (����3)�P�ʐ����v6����ݒ肷��B
	 * @param _701024
	 */
	protected void set_701024(int _701024) {
		this._701024 = _701024;
	}
	/**
	 * (����3)�����z9�����擾����B
	 * @return
	 */
	protected int get_701025() {
		return _701025;
	}
	/**
	 * (����3)�����z9����ݒ肷��B
	 * @param _701025
	 */
	protected void set_701025(int _701025) {
		this._701025 = _701025;
	}
	/**
	 * (����3)�{�l���S�z6�����擾����B
	 * @return
	 */
	protected int get_701026() {
		return _701026;
	}
	/**
	 * (����3)�{�l���S�z6����ݒ肷��B
	 * @param _701026
	 */
	protected void set_701026(int _701026) {
		this._701026 = _701026;
	}
	/**
	 * (�ی����o������Ô�)�P�ʐ����v8�����擾����B
	 * @return
	 */
	protected int get_701027() {
		return _701027;
	}
	/**
	 * (�ی����o������Ô�)�P�ʐ����v8����ݒ肷��B
	 * @param _701027
	 */
	protected void set_701027(int _701027) {
		this._701027 = _701027;
	}
	/**
	 * (�ی����o������Ô�)�����z9�����擾����B
	 * @return
	 */
	protected int get_701028() {
		return _701028;
	}
	/**
	 * (�ی����o������Ô�)�����z9����ݒ肷��B
	 * @param _701028
	 */
	protected void set_701028(int _701028) {
		this._701028 = _701028;
	}
	/**
	 * (�ی����o������Ô�)�o������Ô�p�ҕ��S�z8�����擾����B
	 * @return
	 */
	protected int get_701029() {
		return _701029;
	}
	/**
	 * (�ی����o������Ô�)�o������Ô�p�ҕ��S�z8����ݒ肷��B
	 * @param _701029
	 */
	protected void set_701029(int _701029) {
		this._701029 = _701029;
	}
	/**
	 * (����1���o������Ô�)�P�ʐ����v8�����擾����B
	 * @return
	 */
	protected int get_701030() {
		return _701030;
	}
	/**
	 * (����1���o������Ô�)�P�ʐ����v8����ݒ肷��B
	 * @param _701030
	 */
	protected void set_701030(int _701030) {
		this._701030 = _701030;
	}
	/**
	 * (����1���o������Ô�)�����z9�����擾����B
	 * @return
	 */
	protected int get_701031() {
		return _701031;
	}
	/**
	 * (����1���o������Ô�)�����z9����ݒ肷��B
	 * @param _701031
	 */
	protected void set_701031(int _701031) {
		this._701031 = _701031;
	}
	/**
	 * (����1���o������Ô�)�o������Ô�{�l���S�z8�����擾����B
	 * @return
	 */
	protected int get_701032() {
		return _701032;
	}
	/**
	 * (����1���o������Ô�)�o������Ô�{�l���S�z8����ݒ肷��B
	 * @param _701032
	 */
	protected void set_701032(int _701032) {
		this._701032 = _701032;
	}
	/**
	 * (����2���o������Ô�)�P�ʐ����v8�����擾����B
	 * @return
	 */
	protected int get_701033() {
		return _701033;
	}
	/**
	 * (����2���o������Ô�)�P�ʐ����v8����ݒ肷��B
	 * @param _701033
	 */
	protected void set_701033(int _701033) {
		this._701033 = _701033;
	}
	/**
	 * (����2���o������Ô�)�����z9�����擾����B
	 * @return
	 */
	protected int get_701034() {
		return _701034;
	}
	/**
	 * (����2���o������Ô�)�����z9����ݒ肷��B
	 * @param _701034
	 */
	protected void set_701034(int _701034) {
		this._701034 = _701034;
	}
	/**
	 * (����2���o������Ô�)�o������Ô�{�l���S�z8�����擾����B
	 * @return
	 */
	protected int get_701035() {
		return _701035;
	}
	/**
	 * (����2���o������Ô�)�o������Ô�{�l���S�z8����ݒ肷��B
	 * @param _701035
	 */
	protected void set_701035(int _701035) {
		this._701035 = _701035;
	}
	/**
	 * (����3���o������Ô�)�P�ʐ����v8�����擾����B
	 * @return
	 */
	protected int get_701036() {
		return _701036;
	}
	/**
	 * (����3���o������Ô�)�P�ʐ����v8����ݒ肷��B
	 * @param _701036
	 */
	protected void set_701036(int _701036) {
		this._701036 = _701036;
	}
	/**
	 * (����3���o������Ô�)�����z9�����擾����B
	 * @return
	 */
	protected int get_701037() {
		return _701037;
	}
	/**
	 * (����3���o������Ô�)�����z9����ݒ肷��B
	 * @param _701037
	 */
	protected void set_701037(int _701037) {
		this._701037 = _701037;
	}
	/**
	 * (����3���o������Ô�)�o������Ô�{�l���S�z8�����擾����B
	 * @return
	 */
	protected int get_701038() {
		return _701038;
	}
	/**
	 * (����3���o������Ô�)�o������Ô�{�l���S�z8����ݒ肷��B
	 * @param _701038
	 */
	protected void set_701038(int _701038) {
		this._701038 = _701038;
	}
	/**
	 * �T�[�r�X���̂��擾����B
	 * @return
	 */
	protected String get_701039() {
		return _701039;
	}
	/**
	 * �T�[�r�X���̂�ݒ肷��B
	 * @param _701039
	 */
	protected void set_701039(String _701039) {
		this._701039 = _701039;
	}
	/**
	 * ���t�������擾����B
	 * @return
	 */
	protected int get_701040() {
		return _701040;
	}
	/**
	 * ���t������ݒ肷��B
	 * @param _701040
	 */
	protected void set_701040(int _701040) {
		this._701040 = _701040;
	}
	/**
	 * ����P����ԍ����擾����B
	 * @return
	 */
	protected String get_701041() {
		return _701041;
	}
	/**
	 * ����P����ԍ���ݒ肷��B
	 * @param _701041
	 */
	protected void set_701041(String _701041) {
		this._701041 = _701041;
	}	
	/**
	 * ����Q����ԍ����擾����B
	 * @return
	 */
	protected String get_701042() {
		return _701042;
	}
	/**
	 * ����Q����ԍ���ݒ肷��B
	 * @param _701042
	 */
	protected void set_701042(String _701042) {
		this._701042 = _701042;
	}
	/**
	 * ����R����ԍ����擾����B
	 * @return
	 */
	protected String get_701043() {
		return _701043;
	}
	/**
	 * ����R����ԍ���ݒ肷��B
	 * @param _701043
	 */
	protected void set_701043(String _701043) {
		this._701043 = _701043;
	}
	/**
	 * �V�X�e�����T�[�r�X��ރR�[�h(SYSTEM_SERVICE_KIND_DETAIL)���擾����B
	 * @return
	 */
	protected String get_701044() {
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < _701044.size(); i++){
            result.append(String.valueOf(_701044.get(i)));
            result.append(",");
        }
		return result.toString();
	}
	/**
	 *�V�X�e�����T�[�r�X��ރR�[�h(SYSTEM_SERVICE_KIND_DETAIL)��ݒ肷��B
	 * @param _701044
	 */
	protected void set_701044(String _701044) {
        if(!this._701044.contains(_701044)){
            this._701044.add(_701044);
        }
	}
	/**
	 * �V�X�e�����T�[�r�X���ڃR�[�h(SYSTEM_SERVICE_CODE_ITEM)���擾����B
	 * @return
	 */
	protected String get_701045() {
		return _701045;
	}
	/**
	 *�V�X�e�����T�[�r�X���ڃR�[�h(SYSTEM_SERVICE_CODE_ITEM)��ݒ肷��B
	 * @param _701044
	 */
	protected void set_701045(String _701045) {
		this._701045 = _701045;
	}
    
	//[ID:0000525][Shin Fujihara] 2009/07 add begin 2009�N�x�Ή�
	/**
	 * �V�X�e�����T�[�r�X���ڃR�[�h(SYSTEM_SERVICE_CODE_ITEM)���擾����B
	 * @return
	 */
	protected String get_701046() {
		return _701046;
	}
	/**
	 *�V�X�e�����T�[�r�X���ڃR�[�h(SYSTEM_SERVICE_CODE_ITEM)��ݒ肷��B
	 * @param _701044
	 */
	protected void set_701046(String _701046) {
		this._701046 = _701046;
	}
	//[ID:0000525][Shin Fujihara] 2009/07 add end 2009�N�x�Ή�
	
	
	// 2016/10/11 [Yoichiro Kamei] add - begin �������ƑΉ�
	/**
	 * �������� �敪�x�����P�ʐ��̏����擾����B
	 * @return
	 */
	protected String get_701047() {
		return _701047;
	}
	/**
	 * �������� �敪�x�����P�ʐ��̏���ݒ肷��B
	 * @param _701043
	 */
	protected void set_701047(String _701047) {
		this._701047 = _701047;
	}
	// 2016/10/11 [Yoichiro Kamei] add - end
	
	
    protected int get_701015Multiplies100() {
        BigDecimal temp = new BigDecimal(String.valueOf(get_701015()));
        temp = temp.multiply(new BigDecimal("100"));
        return temp.intValue();
    }
    
//    protected int getOutEntranceRealDays(){
//        return outEntranceRealDays.size();
//    }
    
    
    //[ID:0000699][Shin Fujihara] 2012/03 add begin 2012�N�x�@�����Ή�
    //�l����Z�̎O�A�l����Z�̎l�̑ޔ�p���x�z�Ǘ��ΏۊO�P�ʐ�
    //���O�����p�^�ȊO�̒P�ʐ��ςݏグ
    
    /**
     * �O�����p�^�ȊO�̒P�ʐ��i�l����Z�̎O�A�l����Z�̎l�p�j��ݒ肷��B
     * @param _701011_temp
     */
    protected void set_701011_temp(int _701011_temp) {
        this._701011_temp = _701011_temp;
    }
    /**
     * �O�����p�^�ȊO�̒P�ʐ��i�l����Z�̎O�A�l����Z�̎l�p�j���擾����B
     * @return
     */
    protected int get_701011_temp() {
        return _701011_temp;
    }
    //[ID:0000699][Shin Fujihara] 2012/03 add end 2012�N�x�@�����Ή�

	private boolean isNew(){
		//������񃌃R�[�h�ɓo�^��������ΐV�K�Ƃ݂Ȃ��B
		return ((get_701001() == null) || ("".equals(get_701001())));
	}
	/**
	 * �f�[�^�̉�͂����s����B
	 * @param detail
	 * @throws Exception
	 */
	protected void parse(QP001RecordDetail detail,QP001PatientState patientState,QP001Manager manager) throws Exception {
		
		/* 2006.06.02 ���v�ۂ���Ƃ̂����ɂ��A�Ή����Ȃ����Ƃ�
		if(detail.get_301020().equals("1")
				|| detail.get_301020().equals("2")){
			externalNoUse = true;
		}
		*/
		
		//�V�K�o�^�̏ꍇ
		if(isNew()){
			//�������ʔԍ�
			set_701001(detail.get_301001());
			//�T�[�r�X�񋟔N��
			set_701003(detail.get_301003());
			//���Ə��ԍ�
			set_701004(detail.get_301004());
			//�؋L�ڕی��Ҕԍ�
			set_701005(detail.get_301005());
			//��ی��Ҕԍ�
			set_701006(detail.get_301006());
			//�T�[�r�X��ރR�[�h
			set_701007(detail.get_301007());
			
            //���x�z�Ǘ��Ώۃt���O��1(���x�z�Ǘ��Ώ�)�̏ꍇ
			if(detail.get_301020().equals("1")){
                //�v��P�ʐ�
                set_701009(detail.get_301014());
				//���x�z�Ǘ��ΏےP�ʐ�
				set_701010(detail.get_301014());
                
            //���x�z�Ǘ��Ώۃt���O��2(���x�z�Ǘ��ΏۊO)�̏ꍇ
			} else if(detail.get_301020().equals("2")){
			    //[ID:0000699][Shin Fujihara] 2012/03 edit begin 2012�N�x�@�����Ή�
//				//���x�z�Ǘ��ΏۊO�P�ʐ�
//                set_701011(detail.get_301014());
			    
			    // �l����Z�̎O�A�Z�̎l�̗�O����
			    if (QP001StyleAbstract.IDENTIFICATION_NO_6_3_201204.equals(get_701001())
			        || QP001StyleAbstract.IDENTIFICATION_NO_6_4_201204.equals(get_701001())) {
			        set_701011_temp(detail.get_301014());
			        
			    } else {
	               //���x�z�Ǘ��ΏۊO�P�ʐ�
	                set_701011(detail.get_301014());
			    }
                //[ID:0000699][Shin Fujihara] 2012/03 edit end 2012�N�x�@�����Ή�
                
            //���x�z�Ǘ��Ώۃt���O��3(�O�����p�^)�̏ꍇ
			} else if(detail.get_301020().equals("3")){
                //�v��P�ʐ�
                set_701009(ACCastUtilities.toInt(patientState.getNinteiDataHeavy(get_701005(),get_701006(),"EXTERNAL_USE_LIMIT"),0));
                
                //���x�z�Ǘ��ΏےP�ʐ�
                set_701010(detail.get_301014());
                
                //�O�����p�^�t���O��true�ɂ���
                externalUse = true;
                //[ID:0000525][Shin Fujihara] 2009/07 add begin 2009�N�x�Ή�
                set_701046(String.valueOf(get_701009()));
                //[ID:0000525][Shin Fujihara] 2009/07 add end 2009�N�x�Ή�
            }
			
			//�Z�������v�����
			set_701012(0);
			//�Z������������
			set_701013(0);
			
			//�ی��P�ʐ����v
			set_701014(detail.get_301014());
			//�P�ʐ��P��(double)
			set_701015(manager.getAreaUnitPrice(get_701004(),detail.get_301021(),get_701003()));
			
			// 2017/06 [Yoichiro Kamei] add - begin AF�Ή�
			if (QkanSjServiceCodeManager.afKinds.contains(get_701007())) {
				// �ی��Ҕԍ�
				String insurerId;
				if (detail instanceof QP001RecordDetailJushotiTokurei) {
					insurerId = ((QP001RecordDetailJushotiTokurei) detail).get_1801018();
				} else {
					insurerId = ACCastUtilities.toString(detail.get_301005());
				}
				String systemServiceKindDetail = ACCastUtilities.toString(detail.get_301021());
				// �������Ƃ̒P�ʐ��P��
				Double unitPrice = QkanSjTankaManager.getUnitPrice(insurerId,
						systemServiceKindDetail);
				// AF�̕ی��҂̒P�ʐ��P����0�łȂ���΁A��������g�p����
				if (unitPrice != 0.0d) {
					set_701015(unitPrice);
				}
			}
			// 2017/06 [Yoichiro Kamei] add - end
			
			//detail �� KEY : 701018((����1)�P�ʐ����v)��
			//VALUE : type �� KEY :301015(����1�ΏۃT�[�r�X�P�ʐ�)��ݒ肷��B
			set_701018(detail.get_301015());
			
			//detail �� KEY : 701021((����2)�P�ʐ����v)��
			//VALUE : type �� KEY : 301016(����2�ΏۃT�[�r�X�P�ʐ�)��ݒ肷��B
			set_701021(detail.get_301016());
			
			//detail �� KEY : 701024((����3)�P�ʐ����v)��
			//VALUE : type �� KEY : 301017(����3�ΏۃT�[�r�X�P�ʐ�)��ݒ肷��B
			set_701024(detail.get_301017());
			
			//���t������ޔ�����
			set_701040(detail.get_301026());

			// 2016/10/11 [Yoichiro Kamei] add - begin �������ƑΉ�
			// �Ǝ��藦�E�Ǝ���z�̏ꍇ���t���͐ݒ肵�Ȃ�
			if (isDokujiTeiritsu() || isDokujiTeigaku()) {
				set_701040(0);
			}
			// 2016/10/11 [Yoichiro Kamei] add - end
			
//			//�V�X�e�����̃T�[�r�X��ރR�[�h��ޔ�����
//			set_701044(detail.get_301021());
//			set_701045(detail.get_301022());
			
			// 2016/10/11 [Yoichiro Kamei] add - begin �������ƑΉ�
			if (isDokujiTeiritsuTeigaku()) {
				this.sjClaimCalc = new QP001SjClaimCalc(get_701007(), manager.getSogoLimitOverMap());
			}
			// 2016/10/11 [Yoichiro Kamei] add - end

		//������񂪑��݂���ꍇ
		} else {
            //�O�����p�^�T�[�r�X�ł͖����ꍇ
            if(!externalUse){
                //���x�z�Ǘ��Ώۃt���O��1(���x�z�Ǘ��Ώ�)�̏ꍇ
                if(detail.get_301020().equals("1")){
                    //�v��P�ʐ�
                    set_701009(get_701009() + detail.get_301014());
                    //���x�z�Ǘ��ΏےP�ʐ�
                    set_701010(get_701010() + detail.get_301014());
                    
                //���x�z�Ǘ��Ώۃt���O��2(���x�z�Ǘ��ΏۊO)�̏ꍇ
                } else if(detail.get_301020().equals("2")){
                    //[ID:0000699][Shin Fujihara] 2012/03 edit begin 2012�N�x�@�����Ή�
//                    //���x�z�Ǘ��ΏۊO�P�ʐ�
//                    set_701011(get_701011() + detail.get_301014());
                    
                    // �l����Z�̎O�A�Z�̎l�̗�O����
                    if (QP001StyleAbstract.IDENTIFICATION_NO_6_3_201204.equals(get_701001())
                        || QP001StyleAbstract.IDENTIFICATION_NO_6_4_201204.equals(get_701001())) {
                        set_701011_temp(get_701011_temp() + detail.get_301014());
                        
                    } else {
                       //���x�z�Ǘ��ΏۊO�P�ʐ�
                        set_701011(get_701011() + detail.get_301014());
                    }
                    //[ID:0000699][Shin Fujihara] 2012/03 edit end 2012�N�x�@�����Ή�
                    
                //���x�z�Ǘ��Ώۃt���O��3(�O�����p�^)�̏ꍇ
                } else if(detail.get_301020().equals("3")){
                    //�v��P�ʐ�
                    set_701009(ACCastUtilities.toInt(patientState.getNinteiDataHeavy(get_701005(),get_701006(),"EXTERNAL_USE_LIMIT"),0));
                    
                    //���x�z�Ǘ��ΏےP�ʐ�
                    //set_701011(get_701011() + detail.get_301014());
                    set_701010(get_701010() + get_701011() + detail.get_301014());
                    set_701011(0);
                    
                    //�O�����p�^�t���O��true�ɂ���
                    externalUse = true;
                    
                    //[ID:0000525][Shin Fujihara] 2009/07 add begin 2009�N�x�Ή�
                    set_701046(String.valueOf(get_701009()));
                    //[ID:0000525][Shin Fujihara] 2009/07 add end 2009�N�x�Ή�
                }
            } else {
                //[ID:0000699][Shin Fujihara] 2012/03 add begin 2012�N�x�@�����Ή�
//                //���x�z�Ǘ��ΏےP�ʐ�
//                set_701010(get_701010() + detail.get_301014());

// [H27.4�����Ή�][Yoichiro Kamei] 2015/05/14 mod - begin �T�[�r�X�񋟑̐��������Z�͊O�����p�^�O�P�ʐ��ɋL�ڂ���
//                if (detail.isSyoguRecoed()) {
                if (detail.isSyoguRecoed() || detail.get_301020().equals("2")) {
// [H27.4�����Ή�][Yoichiro Kamei] 2015/05/14 mod - end

                    //���x�z�Ǘ��ΏۊO�P�ʐ�(�ȑO�̏����ł̓[���N���A���Ă���̂ŁA�ςݏグ�ł͂Ȃ��ݒ�)
                    set_701011_temp(get_701011_temp() + detail.get_301014());
                    
                } else {
                    //���x�z�Ǘ��ΏےP�ʐ�
                    set_701010(get_701010() + detail.get_301014());
                }
                //[ID:0000699][Shin Fujihara] 2012/03 add end 2012�N�x�@�����Ή�
            }
            
			//�ی��P�ʐ����v
			set_701014(get_701014() + detail.get_301014());
			//detail �� KEY : 701018((����1)�P�ʐ����v)��
			//VALUE : type �� KEY :301015(����1�ΏۃT�[�r�X�P�ʐ�)��ݒ肷��B
			set_701018(get_701018() + detail.get_301015());
			
  		//detail �� KEY : 701021((����2)�P�ʐ����v)��
			//VALUE : type �� KEY : 301016(����2�ΏۃT�[�r�X�P�ʐ�)��ݒ肷��B
			set_701021(get_701021() + detail.get_301016());
			
			//detail �� KEY : 701024((����3)�P�ʐ����v)��
			//VALUE : type �� KEY : 301017(����3�ΏۃT�[�r�X�P�ʐ�)��ݒ肷��B
			set_701024(get_701024() + detail.get_301017());
			
		}
        //�V�X�e�����̃T�[�r�X��ރR�[�h��ޔ�����
        set_701044(detail.get_301021());
        set_701045(detail.get_301022());
        
		//�T�[�r�X��������]��
		for(int i = 0; i < detail.getRealDays().getDataSize(); i++){
			//���o�^�ł����
			if(!this.serviceRealDays.contains(detail.getRealDays().getData(i))){
				this.serviceRealDays.add(detail.getRealDays().getData(i));
			}
		}
        //���@�i�����j��������]��
        for(int i = 0; i < detail.getHospitalizationDays().size(); i++){
            //���o�^�ł����
              if (!this.entranceRealDays.contains(detail.getHospitalizationDays().getData(i))) {
                this.entranceRealDays.add(detail.getHospitalizationDays().getData(i));
            }
        }
        //�މ@(�ޏ�)��������]��
        for(int i = 0; i < detail.getLeavingHospitalDays().size(); i++){
            //���o�^�ł����
              if (!this.outEntranceRealDays.contains(detail.getLeavingHospitalDays().getData(i))) {
                this.outEntranceRealDays.add(detail.getLeavingHospitalDays().getData(i));
            }
        }
        
		//����p�^���̓]��(commit���v�Z�p)
		//key:(����P�ԍ�)(����Q�ԍ�)(����R�ԍ�) value:SERVICE_UNIT,SERVICE_TIMES
		//�����ŕK�p�ȏ��́A�ǂ̌���K�p�p�^���ŁA���P�ʕ��v�Z����΂悢��
		Object key;
		Iterator it = detail.getKohiPattern().keySet().iterator();
		while(it.hasNext()){
			key = it.next();
			QP001RecordSupporterCalc pattern = (QP001RecordSupporterCalc)detail.getKohiPattern().getData(key);
			int value = 0;
			
// [Yoichiro Kamei] [����֘A�C��] 2015/4/27 comment out - begin �g���Ă��Ȃ��������R�����g��
//			//�o�^������ꍇ
//			if(kohiPattern.containsKey(key)){
//				value = ((Integer)kohiPattern.getData(key)).intValue();
//			}
//			value += pattern.getServiceUnitTotal();
// [Yoichiro Kamei] [����֘A�C��] 2015/4/27 comment out - end
			
			kohiPattern.put(key,new Integer(value));
		}
		
		// 2016/10/11 [Yoichiro Kamei] add - begin �������ƑΉ�
		if (isDokujiTeiritsuTeigaku()) {
			this.sjClaimCalc.parseRecordDetail(detail);
		}
		// 2016/10/11 [Yoichiro Kamei] add - end
	}
	
	/**
	 * �f�[�^�̉�͂����s����B
	 * @param diagnosis
	 * @throws Exception
	 */
	//[ID:0000523][Shin Fujihara] 2009/07 edit begin 2009�N�x�Ή�
	//protected void parse(QP001RecordDiagnosis diagnosis,String[] kohi,QP001PatientState patientState) throws Exception {
	protected void parse(QP001RecordDiagnosis diagnosis,QP001KohiKey[] kohi,QP001PatientState patientState, QP001RecordNursing nursing) throws Exception {
	//[ID:0000523][Shin Fujihara] 2009/07 edit begin 2009�N�x�Ή�
		if(diagnosis == null) return;
		//�����ԍ���99������
		if(diagnosis.get_501007() != 99) return;
		
        //detail �� KEY : 701027((�ی����o������Ô�)�P�ʐ����v)��
        //VALUE : diagnosis �̃��R�[�h�����ԍ���99�̃f�[�^�̍��v�P�ʐ���ݒ肷��B
        set_701027(diagnosis.get_501013());
        
        //���p�҂̏�Ԃɂ�菈���𕪊򂷂�
        //����P�Ǝ󋋎҂̏ꍇ
        if(QP001SpecialCase.isSeihoOnly(get_701005())){
            //detail �� KEY :701028((�ی����o������Ô�)�����z)�� VALUE : 0��ݒ肷��B
            set_701028(0);
        } else {
            //(�ی����o������Ô�)�����z���Z�o����B
            set_701028( (int)Math.floor( (double)(get_701027() * 10 * get_701040()) / 100d));
        }
		
		//detail �� KEY : 701030((����1���o������Ô�)�P�ʐ����v) �� VALUE : diagnosis�̌���P���v�P�ʐ���ݒ肷��B
		set_701030(diagnosis.get_501016());
        //detail �� KEY : 701033((����2���o������Ô�)�P�ʐ����v) �� VALUE : diagnosis�̌���Q���v�P�ʐ���ݒ肷��B
		set_701033(diagnosis.get_501019());
        //detail �� KEY : 701036((����3���o������Ô�)�P�ʐ����v) �� VALUE : diagnosis�̌���R���v�P�ʐ���ݒ肷��B
		set_701036(diagnosis.get_501022());
		
		//test change start fujihara
		/*
		int totalRate  = get_701027() * 10;
        
		int kohiRate1 = 0;
		int kohiRate2 = 0;
        int kohiRate3 = 0;
        
        kohiRate1 = ACCastUtilities.toInt(patientState.getKohiData(kohi[0],"BENEFIT_RATE",1),0);
        //����1�̓K�p�����邩�m�F
        if(kohiRate1 != 0){
            //����P���t����100�̏ꍇ
            if(kohiRate1 == 100){
                //detail �� KEY : 701031((����1���o������Ô�)�����z)��
                //VALUE : ���z��Í��v���z-�ی������z��ݒ肷��B
                set_701031(totalRate - get_701028());
            } else {
                set_701031((int)Math.floor(totalRate * (kohiRate1 - get_701040()) / 100));                
            }
        }
        //����̑ΏۂƂȂ鎩�ȕ��S�z���c���Ă��邩�m�F
        if(totalRate >= (get_701028() + get_701031())){
            kohiRate2 = ACCastUtilities.toInt(patientState.getKohiData(kohi[1],"BENEFIT_RATE",1),0);
            //����2�̓K�p�����邩�m�F
            if(kohiRate2 != 0){
                //����Q�̋��t����100�̏ꍇ
                if(kohiRate2 == 100){
                    set_701034(totalRate - get_701028() - get_701031());
                } else {
                    set_701034((int)Math.floor(totalRate * (kohiRate2 - kohiRate1) / 100));
                }
            }
        }
        //����̑ΏۂƂȂ鎩�ȕ��S���c���Ă��邩�m�F
        if(totalRate >= (get_701028() + get_701031()) + get_701034()){
            kohiRate3 = ACCastUtilities.toInt(patientState.getKohiData(kohi[2],"BENEFIT_RATE",1),0);
            if(kohiRate3 != 0){
                if(kohiRate3 == 100){
                    set_701037(totalRate - get_701028() - get_701031() - get_701034());
                    
                } else {
                    set_701037((int)Math.floor(totalRate * (kohiRate3 - kohiRate2) / 100));
                }
            }
        }
        */
		int totalRate  = get_701027() * 10;
        
		int kohiRate1 = 0;
		int kohiRate2 = 0;
        int kohiRate3 = 0;
        int amendsRate = get_701040();
        
        kohiRate1 = ACCastUtilities.toInt(patientState.getKohiData(kohi[0],"BENEFIT_RATE",1),0);
        //����1�̓K�p�����邩�m�F
// 2015/5/12 [Yoichiro Kamei] mod - begin ����֘A������
//        if(kohiRate1 != 0){
        if(kohiRate1 != 0 && get_701030() != 0){
// 2015/5/12 [Yoichiro Kamei] mod - end
        	//���r��������^��
        	if (get_701027() == get_701030()) {
	            //����P���t����100�̏ꍇ
	            if(kohiRate1 == 100){
	                //detail �� KEY : 701031((����1���o������Ô�)�����z)��
	                //VALUE : ���z��Í��v���z-�ی������z��ݒ肷��B
	                set_701031(totalRate - get_701028());
	            } else {
	                set_701031((int)Math.floor(totalRate * (kohiRate1 - get_701040()) / 100));
// 2015/5/12 [Yoichiro Kamei] add - begin ����֘A������
	                amendsRate = kohiRate1;
// 2015/5/12 [Yoichiro Kamei] add - end
	            }
	            
	        //���r������̏ꍇ
        	} else {
        		set_701031((int)Math.floor(get_701030() * 10 * (kohiRate1 - amendsRate) / 100));
        		amendsRate = kohiRate1;
        	}
        }
        //����̑ΏۂƂȂ鎩�ȕ��S�z���c���Ă��邩�m�F
        if(totalRate >= (get_701028() + get_701031())){
            kohiRate2 = ACCastUtilities.toInt(patientState.getKohiData(kohi[1],"BENEFIT_RATE",1),0);
            //����2�̓K�p�����邩�m�F
// 2015/5/12 [Yoichiro Kamei] mod - begin ����֘A������
//            if(kohiRate2 != 0){
            if(kohiRate2 != 0 && get_701033() != 0){
// 2015/5/12 [Yoichiro Kamei] mod - end
            	//���r�����^��
            	if (get_701027() == get_701033()) {
	                //����Q�̋��t����100�̏ꍇ
	                if(kohiRate2 == 100){
	                    set_701034(totalRate - get_701028() - get_701031());
	                } else {
	                    set_701034((int)Math.floor(totalRate * (kohiRate2 - kohiRate1) / 100));
// 2015/5/12 [Yoichiro Kamei] add - begin ����֘A������
	                    amendsRate = kohiRate2;
// 2015/5/12 [Yoichiro Kamei] add - end
	                }
	                
	            //���r���̏ꍇ
            	} else {
            		set_701034((int)Math.floor(get_701033() * 10 * (kohiRate2 - amendsRate) / 100));
            		amendsRate = kohiRate2;
            	}
            }
        }
        //����̑ΏۂƂȂ鎩�ȕ��S���c���Ă��邩�m�F
        if(totalRate >= (get_701028() + get_701031()) + get_701034()){
            kohiRate3 = ACCastUtilities.toInt(patientState.getKohiData(kohi[2],"BENEFIT_RATE",1),0);
// 2015/5/12 [Yoichiro Kamei] mod - begin ����֘A������
//            if(kohiRate3 != 0){
            if(kohiRate3 != 0 && get_701036() != 0){
// 2015/5/12 [Yoichiro Kamei] mod - end
            	//���r�����^��
            	if (get_701027() == get_701036()) {
	                if(kohiRate3 == 100){
	                    set_701037(totalRate - get_701028() - get_701031() - get_701034());
	                    
	                } else {
	                    set_701037((int)Math.floor(totalRate * (kohiRate3 - kohiRate2) / 100));
	                }
            	} else {
            		set_701037((int)Math.floor(get_701036() * 10 * (kohiRate3 - amendsRate) / 100));
            	}
            }
        }
		//test change end fujihara
        
        //����{�l���S�z�̎Z�o���s��
        int selfPay = 0; 
        //����P�̖{�l���S�z���擾
        if(get_701031() != 0){
            
            selfPay = patientState.getKohiSelfPay(kohi[0],1);
            
            if(selfPay != 0){
                
                //�{�̕�V�Ƃ݂Ȃ��Č���ȕ��S���Z�o����悤�C��
            	//[ID:0000523][Shin Fujihara] 2009/07 edit begin 2009�N�x�Ή�
                //selfPay = QP001SpecialCase.getApplicationIndividualPayment(get_701001(),get_701006(),selfPay,get_701020());
            	selfPay = QP001SpecialCase.getApplicationIndividualPayment(
            			get_701001(),
            			get_701006(),
            			selfPay,get_701020(),
            			kohi[0].getKohiType(),
            			nursing);
            	//[ID:0000523][Shin Fujihara] 2009/07 edit end 2009�N�x�Ή�
                
                //����P�����z�Ɩ{�l���S�z���r���A�{�l���S�z���傫���ꍇ
                if (get_701031() < selfPay) {
                    // ����P�{�l���S�z�Ɍ���P�����z��ݒ肷��
                    set_701032(get_701031());
                    // ����P�����z��0�Ƃ���
                    set_701031(0);
                    //�g�p��������ȕ��S�z��ݒ肷��B
                    patientState.setKohiSelfPayUse(kohi[0],get_701032());
                } else {
                    set_701032(selfPay);
                    set_701031(get_701031() - get_701032());
                    //�g�p��������ȕ��S�z��ݒ肷��B
                    patientState.setKohiSelfPayUse(kohi[0],selfPay);
                }
            }

        }
        //����Q�̖{�l���S�z���擾
        if(get_701034() != 0){
            selfPay = patientState.getKohiSelfPay(kohi[1],1);
            
            if(selfPay != 0){
                
                //�{�̕�V�Ƃ݂Ȃ��Č���ȕ��S���Z�o����悤�C��
            	//[ID:0000523][Shin Fujihara] 2009/07 edit begin 2009�N�x�Ή�
                //selfPay = QP001SpecialCase.getApplicationIndividualPayment(get_701001(),get_701006(),selfPay,get_701023());
            	selfPay = QP001SpecialCase.getApplicationIndividualPayment(
            			get_701001(),
            			get_701006(),
            			selfPay,get_701023(), 
            			kohi[1].getKohiType(),
            			nursing);
                //[ID:0000523][Shin Fujihara] 2009/07 edit end 2009�N�x�Ή�
            	
                //����Q�����z�Ɩ{�l���S�z���r���A�{�l���S���傫���ꍇ
                if(get_701034() < selfPay){
                    //����Q�{�l���S�z�Ɍ���Q�����z��ݒ肷��B
                    set_701035(get_701034());
                    //����Q�����z��0�Ƃ���
                    set_701034(0);
                    //�g�p��������ȕ��S�z��ݒ肷��B
                    patientState.setKohiSelfPayUse(kohi[1],get_701035());
                } else {
                    set_701035(selfPay);
                    set_701034(get_701034() - get_701035());
                    //�g�p��������ȕ��S�z��ݒ肷��B
                    patientState.setKohiSelfPayUse(kohi[1],selfPay);
                }
            }
        }
        //����R�̖{�l���S�z���擾
        if(get_701037() != 0){
            selfPay = patientState.getKohiSelfPay(kohi[2],1);
            
            if(selfPay != 0){
                
                //�{�̕�V�Ƃ݂Ȃ��Č���ȕ��S���Z�o����悤�C��
            	//[ID:0000523][Shin Fujihara] 2009/07 edit begin 2009�N�x�Ή�
                //selfPay = QP001SpecialCase.getApplicationIndividualPayment(get_701001(),get_701006(),selfPay,get_701026());
            	selfPay = QP001SpecialCase.getApplicationIndividualPayment(
            			get_701001(),
            			get_701006(),
            			selfPay,
            			get_701026(), 
            			kohi[2].getKohiType(),
            			nursing);
                //[ID:0000523][Shin Fujihara] 2009/07 edit end 2009�N�x�Ή�
            	
                //����R�����z�Ɩ{�l���S�z���r���A�{�l���S�z���傫���ꍇ
                if(get_701037() < selfPay){
                    //����R�{�l���S�z�Ɍ���R�����z��ݒ肷��B
                    set_701038(get_701037());
                    //����R�����z��0�Ƃ���
                    set_701037(0);
                    //�g�p��������ȕ��S�z��ݒ肷��B
                    patientState.setKohiSelfPayUse(kohi[2], get_701038());
                } else {
                    set_701038(selfPay);
                    set_701037(get_701037() - get_701038());
                    //�g�p��������ȕ��S�z��ݒ肷��B
                    patientState.setKohiSelfPayUse(kohi[2], selfPay);
                }
            }
        }
        
        //���p�ҕ��S�z��ݒ肷��B
        set_701029(totalRate - get_701028() - get_701031() - get_701034() - get_701037()
                - get_701032() - get_701035() - get_701038());
        
        if(get_701029() < 0){
            //����K�p���ʂ̒Ⴂ���̂��痘�p�ҕ��S�z������
            if(get_701037() > 0){
                set_701037(get_701037() + get_701029());
            } else {
                if(get_701034() > 0){
                    set_701034(get_701034() + get_701029());
                } else {
                    if(get_701031() > 0){
                        set_701031(get_701031() + get_701029());
                    }
                }
            }
            set_701029(0);
        }

	}
    
    /**
     * �f�[�^�̉�͂����s����B
     * @param diagnosis
     * @throws Exception
     */
    protected void parse(QP001RecordEmergency emergency,QP001KohiKey[] kohi,QP001PatientState patientState) throws Exception {
        if(emergency == null) return;
        //�����ԍ���99������
        if(emergency.get_401007() != 99) return;
        
        //detail �� KEY : 701027((�ی����o������Ô�)�P�ʐ����v)��
        //VALUE : diagnosis �̃��R�[�h�����ԍ���99�̃f�[�^�̍��v�P�ʐ���ݒ肷��B
        set_701027(emergency.get_401046());
        
        //���p�҂̏�Ԃɂ�菈���𕪊򂷂�
        //����P�Ǝ󋋎҂̏ꍇ
        if(QP001SpecialCase.isSeihoOnly(get_701005())){
            //detail �� KEY :701028((�ی����o������Ô�)�����z)�� VALUE : 0��ݒ肷��B
            set_701028(0);
        } else {
            //(�ی����o������Ô�)�����z���Z�o����B
            set_701028( (int)Math.floor( (double)(get_701027() * 10 * get_701040()) / 100d));
        }

    }
    
    /**
     * �f�[�^�̉�͂����s����B
     * @param diagnosis
     * @throws Exception
     */
    protected void parse(QP001RecordEmergencyOwnFacility emergencyOwnFacility,QP001KohiKey[] kohi,QP001PatientState patientState) throws Exception {
        if(emergencyOwnFacility == null) return;
        //�����ԍ���99������
        if(emergencyOwnFacility.get_1701007() != 99) return;
        
        //detail �� KEY : 701027((�ی����o������Ô�)�P�ʐ����v)��
        //VALUE : diagnosis �̃��R�[�h�����ԍ���99�̃f�[�^�̍��v�P�ʐ���ݒ肷��B
        set_701027(emergencyOwnFacility.get_1701046());
        
        //���p�҂̏�Ԃɂ�菈���𕪊򂷂�
        //����P�Ǝ󋋎҂̏ꍇ
        if(QP001SpecialCase.isSeihoOnly(get_701005())){
            //detail �� KEY :701028((�ی����o������Ô�)�����z)�� VALUE : 0��ݒ肷��B
            set_701028(0);
        } else {
            //(�ی����o������Ô�)�����z���Z�o����B
            set_701028( (int)Math.floor( (double)(get_701027() * 10 * get_701040()) / 100d));
        }

    }

	/**
	 * �W�v���m�菈��
	 * @param kohi
	 * @throws Exception
	 */
	protected void commitRecord(QP001KohiKey kohi[],QP001PatientState patientState,VRMap styles,VRMap planUnitMap) throws Exception {
		commitRecord(kohi,patientState,styles,planUnitMap,null);
	}
    
	/**
	 * �W�v���m�菈��
	 * @param kohi
	 * @throws Exception
	 */
	protected void commitRecord(QP001KohiKey kohi[],QP001PatientState patientState,VRMap styles,VRMap planUnitMap,QP001RecordNursing nursing) throws Exception {
		
        //�v��P�ʐ����擾
        int planUnit = getPlanUnit(styles, planUnitMap);
        
        //�v��P�ʐ����擾�ł����ꍇ
        if(planUnit != 0){
            //�v��P�ʐ����㏑������
            set_701009(planUnit);
            //[ID:0000525][Shin Fujihara] 2009/07 add begin 2009�N�x�Ή�
            set_701046(String.valueOf(planUnit));
            //[ID:0000525][Shin Fujihara] 2009/07 add end 2009�N�x�Ή�
        }
        
        // 2016/10 [Yoichiro Kamei] add - begin �������ƓƎ��Ή�
        // �v��P�ʐ��Ƒ������Ƃ̋敪�x�����P�ʐ��̐������`�F�b�N
        if (isDokujiTeiritsuTeigaku()) {
            int gendoTaishoUnit = get_701010();
            int limitOverUnit = this.sjClaimCalc.getTotalLimitOverUnit();
            
            if (planUnit > 0) {
                // ���x�z�Ǘ��ΏےP�ʐ����v��P�ʐ��̂Ƃ�
                if (gendoTaishoUnit > planUnit) {
                    if (gendoTaishoUnit !=  (planUnit + limitOverUnit)) {
                        throw new QkanSjLimitOverUnitException(get_701007(), "�敪�x�����P�ʐ��̕s����");
                    }
                }
            } else if (planUnit == 0) {
                // �v��P�ʐ���0���������z�̂ݐݒ肳��Ă���ꍇ
                if (limitOverUnit > 0) {
                    throw new QkanSjLimitOverUnitException(get_701007(), "�敪�x�����P�ʐ��̕s����");
                }
            }
        }
        // 2016/10 [Yoichiro Kamei] add - end
        
        // �v��P�ʐ��ƌ��x�z�ΏۊǗ����̏��Ȃ��ق����̗p����
        int unit = get_701010();
        if(get_701009() < unit){
            unit = get_701009();
        }
        
        //[ID:0000699][Shin Fujihara] 2012/03 add begin 2012�N�x�@�����Ή�
//        //���t�P�ʐ���ݒ肷��B
//        set_701014(unit + get_701011());
        //���t�P�ʐ���ݒ肷��B
        set_701014(unit + get_701011() + get_701011_temp());
        
        //�O�����p�^�g�p�̏ꍇ�A�������P�P�ʐ���]�L
        if (externalUse) {
            set_701011(get_701011_temp());
        }
        //[ID:0000699][Shin Fujihara] 2012/03 add end 2012�N�x�@�����Ή�
        
        //����ΏےP�ʐ����Z�o���Ȃ���
        //����P
        if(get_701018() > get_701014()){
            set_701018(get_701014());
        }
        //����Q
        if(get_701021() > get_701014()){
            set_701021(get_701014());
        }
        //����R
        if(get_701024() > get_701014()){
            set_701024(get_701014());
        }
        
		//�T�[�r�X�������m��
		set_701008(this.serviceRealDays.getDataSize());
		//�����������m��
        //��{��񃌃R�[�h�Őݒ肷��悤�ύX
//		set_701013(this.entranceRealDays.getDataSize());

        // 2016/10/11 [Yoichiro Kamei] add - begin �������ƑΉ�
        if (isDokujiTeiritsuTeigaku()) {
            // �Ǝ��E�Ǝ��藦�E�Ǝ���z�̌v�Z
            this.sjClaimCalc.calculate();
        }
        // 2016/10/11 [Yoichiro Kamei] add - end
        
		//���Ƃ́A���Z���Ɉꊇ�v�Z(commitRecord)
		//���p�҂̋��t�����ɂ�菈���𕪊򂷂�B
        //���ےP��
        if(get_701006().toUpperCase().startsWith("H")){
            //detail �� KEY : 701016((�ی�)�����z)�� VALUE : 0��ݒ肷��B
            set_701016(0);
        } else {
            //set_701016( (int)Math.floor( Math.floor(get_701014() * get_701015() ) * ((double)get_701040() / 100d)));
            //�ΏےP�ʐ��~�P�ʐ��P��(�����_�ȉ��؎̂�)
            int totalUnit = (int)Math.floor((double)(get_701014() * get_701015Multiplies100()) / 100d);
            //�ی����t��
            totalUnit = (int)Math.floor((totalUnit * get_701040()) / 100d); 
            
            set_701016(totalUnit);
            
            // 2016/10/11 [Yoichiro Kamei] add - begin �������ƑΉ�
            if (isDokuji()) {
                set_701016(this.sjClaimCalc.getDokujiJigyohiSeikyugaku());
            } else if (isDokujiTeiritsu()) {
                set_701016(this.sjClaimCalc.getTeiritsuJigyohiSeikyugaku());
            }
            // 2016/10/11 [Yoichiro Kamei] add - end
        }
		
		//����̎Z�o���s���B
		Iterator it = kohiPattern.keySet().iterator();
		String key = "";
		int value = 0;
		int kohiRate = 0;
		int reduction = 0;
		int kohiClaim = 0;
		
//		//�����ǌ���v�Z�t���O add 2014/03/11
//		//�����ǂ̏ꍇ�{�̂Ɍ���͓K�p����Ȃ����������P���Z�ɂ����͓K�p�ł���
//		//���̌v�Z�������ꍇ�A���ȕ��S�v�Z�͔�΂��K�v������
//		boolean kansenFlg = false;
//		String tmpKohiType = "0";
        
        set_701041("0");
        set_701042("0");
        set_701043("0");
        
// 2015/6/18 [Shinobu Hitaka] mod - begin ����֘A�������i���[�v�͈͕̔ύX�ɂ��R�����g���j
//		while(it.hasNext()){
//		    
//            //[CCCX:1470][Shinobu Hitaka] 2014/03/14 add - start �V���̈ꕔ����Ώۂ̑Ή�
//            tmpKohiType = key.replaceAll("-", "");
//            //[CCCX:1470][Shinobu Hitaka] 2014/03/14 add - end �V���̈ꕔ����Ώۂ̑Ή�
//            
//			key = String.valueOf(it.next());
//			
//			//[CCCX:1592][Shinobu Hitaka] 2014/03/09 edit - start �����ǌ���̏������P���Z�Ή�
//			//del - start
//			//����K�p�Ȃ��Ȃ珈�����s��Ȃ�
//			//if("NONE".equalsIgnoreCase(key)) continue;
//			//del - end
//			//add - start
//			//����K�p�Ȃ���kohi[0]�������ǂ̏ꍇ�A����f�Ô�E���ʗ×{��̏������P���Z����������Ή��Ƃ��Čv�Z����
//            if ("NONE".equalsIgnoreCase(key)) {
//                if (!ACTextUtilities.isNullText(kohi[0])) {
//                    if ("1001".equals(kohi[0].getKohiType()) && ("22".equals(get_701007()) || "23".equals(get_701007()) || "52".equals(get_701007()) || "53".equals(get_701007()) || "25".equals(get_701007()) || "26".equals(get_701007())) && (get_701018() != 0)) {
//                        //����t�����擾
//                        kohiRate = ACCastUtilities.toInt(patientState.getKohiData(kohi[0],"BENEFIT_RATE",1),0);
//                        //������z���v�Z
//                        kohiClaim = getKohiClaim(get_701018(),kohiRate,0,get_701040(), 0);
//                        //detail �� KEY : 701019((����1)�����z)�ɒl��ݒ肷��B
//                        set_701019(get_701019() + kohiClaim);
//                        //�K�p���������ޔ�����B
//                        set_701041(kohi[0].getKohiType());
//                        //�����ǌ���v�Z�t���O��ݒ�
//                        kansenFlg = true;
//                    }
//                }
//                continue;
//            }
//            //
//            if (!("0".equals(tmpKohiType)) && CareServiceCommon.isKouhiService(get_701007(), tmpKohiType)) continue;
//            //add - end
//            //[CCCX:1592][Shinobu Hitaka] 2014/03/09 edit - end   �����ǌ���̏������P���Z�Ή�
//            
//// 2015/5/12 [Yoichiro Kamei] add - begin ����֘A������
//        //�ȉ���kohiPattern��key���Q�Ƃ��ĂȂ��̂Ń��[�v�O�ɂ���
//		}
//// 2015/5/12 [Yoichiro Kamei] add - end
// 2015/6/18 [Shinobu Hitaka] mod - end 
        
        
			//���z��������
			reduction = 0;
			//�K�p�Ώۂ̓_�����擾
// [Yoichiro Kamei] [����֘A�C��] 2015/4/27 comment out - begin �g���Ă��Ȃ��������R�����g��
//			value = ((Integer)kohiPattern.getData(key)).intValue();
//			if(value > get_701014()){
//                value = get_701014();
//            }
// [Yoichiro Kamei] [����֘A�C��] 2015/4/27 comment out - end
            
            //�⏞���ꂽ����
            int usedRate = get_701040();
            
            //�V������K�p�t���O add 2014/02/08
            boolean roukenFlg = false;
            
			//����P���K�p�ΏۂɊ܂܂�Ă���ꍇ
// 2015/5/12 [Yoichiro Kamei] mod - begin ����֘A������
//            if ((!ACTextUtilities.isNullText(kohi[0]) && key.indexOf(kohi[0]) != -1) 
//                    || (get_701018() != 0)){
			if ((!ACTextUtilities.isNullText(kohi[0]) && !"".equals(kohi[0].getKohiType())) 
			        || (get_701018() != 0)){
// 2015/5/12 [Yoichiro Kamei] mod - end
				//kohiRate = QP001Manager.getInstance().getBenefitRate(kohi[0]);
                kohiRate = ACCastUtilities.toInt(patientState.getKohiData(kohi[0],"BENEFIT_RATE",1),0);
                //��������
				//kohiClaim = getKohiClaim(value,kohiRate,0,usedRate);
                kohiClaim = getKohiClaim(get_701018(),kohiRate,0,usedRate, 0);
                
                // 2016/10/11 [Yoichiro Kamei] add - begin �������ƑΉ�
                if (isDokuji()) {
                    kohiClaim = this.sjClaimCalc.calcDokujiKohiSeikyugaku(KohiyusenType.KOHI1,
                            get_701014(), get_701018(), kohiRate, reduction, usedRate, 0);
                } else if (isDokujiTeiritsu()) {
                    //���ےP�Ƃł͂Ȃ��ꍇ
                    if (!get_701006().toUpperCase().startsWith("H")) {
                        usedRate = -1; //�T�[�r�X�̋��t�����g�p���邽��
                    }
                    kohiClaim = this.sjClaimCalc.calcTeiritsuKohiSeikyugaku(KohiyusenType.KOHI1,
                        get_701014(), get_701018(), kohiRate, reduction, usedRate, 0);
                } else if (isDokujiTeigaku()) {
                    kohiClaim = this.sjClaimCalc.getTeigakuKohi1Seikyugaku();
                }
                // 2016/10/11 [Yoichiro Kamei] add - end
                
				reduction += kohiClaim;
				//detail �� KEY : 701019((����1)�����z)�ɒl��ݒ肷��B
				set_701019(get_701019() + kohiClaim);
                //�K�p���������ޔ�����B
                set_701041(kohi[0].getKohiType());
                usedRate = kohiRate;
                
// 2015/6/18 [Shinobu Hitaka] del - begin ����֘A�������i���[�v�͈͕̔ύX�ɂ��R�����g���j
//                //[CCCX:1470][Shinobu Hitaka] 2014/02/07 edit - start �V���̈ꕔ����Ώۂ̑Ή�
//                //�V���ꕔ�K�p����̏ꍇ�͏������I�����Ȃ�
//				//����1�̋��t����100%�̏ꍇ�������I������B
//				//if(kohiRate == 100) continue;
//                roukenFlg = CareServiceCommon.isKouhiService(get_701007(), kohi[0].getKohiType());
//// 2015/5/12 [Yoichiro Kamei] mod - begin ����֘A������
////                if (!roukenFlg && (kohiRate == 100)) continue;
////                if (!roukenFlg && (get_701014() <= get_701018())) continue;
//// 2015/5/12 [Yoichiro Kamei] mod - end
//                //[CCCX:1470][Shinobu Hitaka] 2014/02/07 edit - end �V���̈ꕔ����Ώۂ̑Ή�
// 2015/6/18 [Shinobu Hitaka] del - end

			}
			//����Q���K�p�ΏۂɊ܂܂�Ă���ꍇ
// 2015/5/12 [Yoichiro Kamei] mod - begin ����֘A������
//	         if((!ACTextUtilities.isNullText(kohi[1]) && key.indexOf(kohi[1]) != -1)
//	                    || (get_701021() != 0)){
			if((!ACTextUtilities.isNullText(kohi[1]) && !"".equals(kohi[1].getKohiType())) 
			        || (get_701021() != 0)){
// 2015/5/12 [Yoichiro Kamei] mod - end
				//kohiRate = QP001Manager.getInstance().getBenefitRate(kohi[1]);
                kohiRate = ACCastUtilities.toInt(patientState.getKohiData(kohi[1],"BENEFIT_RATE",1),0);
                
// 2015/6/18 [Shinobu Hitaka] del - begin ����֘A�������i�����̔�������ύX�ɂ��R�����g���j
//                //[CCCX:1470][Shinobu Hitaka] 2014/02/07 add - start �V���̈ꕔ����Ώۂ̑Ή�
//                if(roukenFlg){
//                    //�����͏����l�œn��
//                    kohiClaim = getKohiClaim(get_701021(),kohiRate,reduction,get_701040(), get_701018());
//                    
//                    reduction += kohiClaim;
//                    //detail �� KEY : 701022((����2)�����z)�ɒl��ݒ肷��B
//                    set_701022(get_701022() + kohiClaim);
//                    //�K�p���������ޔ�����B
//                    set_701042(kohi[1].getKohiType());
//                    usedRate = kohiRate;
//                    //�V���ꕔ�K�p����̏ꍇ�͏������I�����Ȃ�
//                    roukenFlg = CareServiceCommon.isKouhiService(get_701007(), kohi[1].getKohiType());
//// 2015/5/12 [Yoichiro Kamei] mod - begin ����֘A������
////                    if (!roukenFlg && (kohiRate == 100)) continue;
////                    if (!roukenFlg && (get_701014() <= get_701018() + get_701021())) continue;
//// 2015/5/12 [Yoichiro Kamei] mod - end
//                }
//                //[CCCX:1470][Shinobu Hitaka] 2014/02/07 add - end �V���̈ꕔ����Ώۂ̑Ή�
// 2015/6/18 [Shinobu Hitaka] del - end
                
                //���肦�Ȃ����A���������������̊������Ⴂ�ꍇ���l��
// 2015/5/12 [Yoichiro Kamei] mod - begin ����֘A������
//                if(kohiRate > usedRate){
                if(kohiRate >= usedRate){
// 2015/5/12 [Yoichiro Kamei] mod - end
                    
                    //[CCCX:1592][Shinobu Hitaka] 2014/03/12 add - start �����ǌ���̏������P���Z�Ή�
                    //����1=10�����ǁA����2=�V���ꕔ����̏ꍇ�A����t��������������
                    //roukenFlg = CareServiceCommon.isKouhiService(get_701007(), kohi[1].getKohiType());
                    roukenFlg = CareServiceCommon.isKouhiService(get_701007(), kohi[0].getKohiType());
                    
// 2015/6/18 [Shinobu Hitaka] mod - begin ����֘A�������i�V���ꕔ����܂���10�����ǂ̏ꍇ�Ɍ���t�����������j
                    //if (roukenFlg && ("1001".equals(kohi[0].getKohiType()))){
                    if (roukenFlg || ("1001".equals(kohi[0].getKohiType()))){
// 2015/6/18 [Shinobu Hitaka] mod - end
                    	usedRate = get_701040();
                    }
                    //[CCCX:1592][Shinobu Hitaka] 2014/03/12 add - end   �����ǌ���̏������P���Z�Ή�
                    
                    //��������
                    //kohiClaim = getKohiClaim(value,kohiRate,reduction,usedRate);
                    kohiClaim = getKohiClaim(get_701021(),kohiRate,reduction,usedRate, get_701018());
                    
                    // 2016/10/11 [Yoichiro Kamei] add - begin �������ƑΉ�
                    if (isDokuji()) {
                        kohiClaim = this.sjClaimCalc.calcDokujiKohiSeikyugaku(KohiyusenType.KOHI2,
                                get_701014(), get_701021(), kohiRate, reduction, usedRate, get_701018());
                    } else if (isDokujiTeiritsu()) {
                        kohiClaim = this.sjClaimCalc.calcTeiritsuKohiSeikyugaku(KohiyusenType.KOHI2,
                            get_701014(), get_701021(), kohiRate, reduction, usedRate, get_701018());
                    } else if (isDokujiTeigaku()) {
                        kohiClaim = this.sjClaimCalc.getTeigakuKohi2Seikyugaku();
                    }
                    // 2016/10/11 [Yoichiro Kamei] add - end
                    
                    reduction += kohiClaim;
                    //detail �� KEY : 701022((����2)�����z)�ɒl��ݒ肷��B
                    set_701022(get_701022() + kohiClaim);
                    //�K�p���������ޔ�����B
                    set_701042(kohi[1].getKohiType());
                    usedRate = kohiRate;

                    //[CCCX:1470][Shinobu Hitaka] 2014/02/07 edit - start �V���̈ꕔ����Ώۂ̑Ή�
                    //�V���ꕔ�K�p����̏ꍇ�͏������I�����Ȃ�
                    //����2�̋��t����100%�̏ꍇ�������I������B
                    //if(kohiRate == 100) continue;
// 2015/5/12 [Yoichiro Kamei] mod - begin ����֘A������
//                    if (!roukenFlg && (kohiRate == 100)) continue;
//                    if (!roukenFlg && (get_701014() <= get_701018() + get_701021())) continue;
// 2015/5/12 [Yoichiro Kamei] mod - end
                    //[CCCX:1470][Shinobu Hitaka] 2014/02/07 edit - end �V���̈ꕔ����Ώۂ̑Ή�

                }

			}
			
			//����R���K�p�ΏۂɊ܂܂�Ă���ꍇ
// 2015/5/12 [Yoichiro Kamei] mod - begin ����֘A������
//	         if((!ACTextUtilities.isNullText(kohi[2]) && key.indexOf(kohi[2]) != -1)
//	                 || (get_701024() != 0)){
			if((!ACTextUtilities.isNullText(kohi[2]) && !"".equals(kohi[2].getKohiType())) 
			    || (get_701024() != 0)){
// 2015/5/12 [Yoichiro Kamei] mod - end
				//kohiRate = QP001Manager.getInstance().getBenefitRate(kohi[2]);
                kohiRate = ACCastUtilities.toInt(patientState.getKohiData(kohi[2],"BENEFIT_RATE",1),0);
                
// 2015/6/18 [Shinobu Hitaka] del - begin ����֘A�������i�����̔�������ύX�ɂ��R�����g���j
//                //[CCCX:1470][Shinobu Hitaka] 2014/02/07 add - start �V���̈ꕔ����Ώۂ̑Ή�
//                if(roukenFlg){
//                    //�����͏����l�œn��
//                    kohiClaim = getKohiClaim(get_701024(),kohiRate,reduction,get_701040(), get_701018() + get_701021());
//                    
//                    reduction += kohiClaim;
//                    //detail �� KEY : 701025((����3)�����z)�ɒl��ݒ肷��B
//                    set_701025(get_701025() + kohiClaim);
//                    //�K�p���������ޔ�����B
//                    set_701043(kohi[2].getKohiType());
//                }
//                //[CCCX:1470][Shinobu Hitaka] 2014/02/07 add - end �V���̈ꕔ����Ώۂ̑Ή�
// 2015/6/18 [Shinobu Hitaka] del - end
                
// 2015/5/12 [Yoichiro Kamei] mod - begin ����֘A������
//                if(kohiRate > usedRate){
                if(kohiRate >= usedRate){
// 2015/5/12 [Yoichiro Kamei] mod - end
                	
// 2015/6/18 [Shinobu Hitaka] add - begin ����֘A�������i�V���̈ꕔ����Ώۂ̑Ή��͂����ōs���j
                	roukenFlg = CareServiceCommon.isKouhiService(get_701007(), kohi[1].getKohiType());
                    if(roukenFlg){
                        usedRate = get_701040();
                    }
// 2015/6/18 [Shinobu Hitaka] add - end
                    
                    //��������
                    kohiClaim = getKohiClaim(get_701024(),kohiRate,reduction,usedRate, get_701018() + get_701021());
                    
                    // 2016/10/11 [Yoichiro Kamei] add - begin �������ƑΉ�
                    if (isDokuji()) {
                        kohiClaim = this.sjClaimCalc.calcDokujiKohiSeikyugaku(KohiyusenType.KOHI3,
                                get_701014(), get_701024(), kohiRate, reduction, usedRate, get_701018() + get_701021());
                    } else if (isDokujiTeiritsu()) {
                        kohiClaim = this.sjClaimCalc.calcTeiritsuKohiSeikyugaku(KohiyusenType.KOHI3,
                            get_701014(), get_701024(), kohiRate, reduction, usedRate, get_701018() + get_701021());
                    } else if (isDokujiTeigaku()) {
                        kohiClaim = this.sjClaimCalc.getTeigakuKohi3Seikyugaku();
                    }
                    // 2016/10/11 [Yoichiro Kamei] add - end
                    
// 2015/6/18 [Shinobu Hitaka] add - begin ����֘A�������i����1=10�����ǂ̏ꍇ�A�����z�𒲐�����j
                    if ("1001".equals(kohi[0].getKohiType()) && kohiClaim > get_701019()){
                    	kohiClaim -= get_701019();
                    }
// 2015/6/18 [Shinobu Hitaka] add - end
                    
                    reduction += kohiClaim;
                    //detail �� KEY : 701025((����3)�����z)�ɒl��ݒ肷��B
                    set_701025(get_701025() + kohiClaim);
                    //�K�p���������ޔ�����B
                    set_701043(kohi[2].getKohiType());
                }
            }
// 2015/5/12 [Yoichiro Kamei] mod - begin ����֘A������
//		}
// 2015/5/12 [Yoichiro Kamei] mod - end
		
        //����{�l���S�z�̎Z�o���s��
        int selfPay = 0;
        int kohiCost = 0;
        //����P�̖{�l���S�z���擾
// 2015/6/18 [Shinobu Hitaka] mod - begin kansenFlg�폜�ɂ�蔻������ɖ߂�
        if(!"0".equals(get_701041())){
        //if(!"0".equals(get_701041()) && !kansenFlg){
// 2015/6/18 [Shinobu Hitaka] mod - end
            
            selfPay = patientState.getKohiSelfPay(kohi[0],1);
            
            if(selfPay != 0){
                //�l���攪�A���A��\�̏ꍇ�Ŋ����ےP�Ǝ҂Ŗ����ꍇ�́A���ȕ��S�z�̎g�p�ɐ�����������
            	kohiCost = 0;
            	if(nursing != null){
            		kohiCost = nursing.get_801026();
            	}
                selfPay = QP001SpecialCase.convertSelfPay(get_701001(),get_701006(),selfPay,kohi[0],kohiCost);
                
                //����P�����z�Ɩ{�l���S�z���r���A�{�l���S�z���傫���ꍇ
                if (get_701019() < selfPay) {
                    // ����P�{�l���S�z�Ɍ���P�����z��ݒ肷��
                    set_701020(get_701019());
                    // ����P�����z��0�Ƃ���
                    set_701019(0);
                    //�g�p��������ȕ��S�z��ݒ肷��B
                    patientState.setKohiSelfPayUse(kohi[0],get_701020());
                } else {
                    set_701020(selfPay);
                    set_701019(get_701019() - get_701020());
                    //�g�p��������ȕ��S�z��ݒ肷��B
                    patientState.setKohiSelfPayUse(kohi[0],selfPay);
                }
            }

        }
        //����Q�̖{�l���S�z���擾
        if(!"0".equals(get_701042())){
            selfPay = patientState.getKohiSelfPay(kohi[1],1);
            
            if(selfPay != 0){
            	kohiCost = 0;
            	if(nursing != null){
            		kohiCost = nursing.get_801029();
            	}
                selfPay = QP001SpecialCase.convertSelfPay(get_701001(),get_701006(),selfPay,kohi[1],kohiCost);
                
                //����Q�����z�Ɩ{�l���S�z���r���A�{�l���S���傫���ꍇ
                if(get_701022() < selfPay){
                    //����Q�{�l���S�z�Ɍ���Q�����z��ݒ肷��B
                    set_701023(get_701022());
                    //����Q�����z��0�Ƃ���
                    set_701022(0);
                    //�g�p��������ȕ��S�z��ݒ肷��B
                    patientState.setKohiSelfPayUse(kohi[1],get_701023());
                } else {
                    set_701023(selfPay);
                    set_701022(get_701022() - get_701023());
                    //�g�p��������ȕ��S�z��ݒ肷��B
                    patientState.setKohiSelfPayUse(kohi[1],selfPay);
                }
            }
        }
        //����R�̖{�l���S�z���擾
        if(!"0".equals(get_701043())){
            selfPay = patientState.getKohiSelfPay(kohi[2],1);
            
            if(selfPay != 0){
            	kohiCost = 0;
            	if(nursing != null){
            		kohiCost = nursing.get_801032();
            	}
                selfPay = QP001SpecialCase.convertSelfPay(get_701001(),get_701006(),selfPay,kohi[2],kohiCost);
                
                //����R�����z�Ɩ{�l���S�z���r���A�{�l���S�z���傫���ꍇ
                if(get_701025() < selfPay){
                    //����R�{�l���S�z�Ɍ���R�����z��ݒ肷��B
                    set_701026(get_701025());
                    //����R�����z��0�Ƃ���
                    set_701025(0);
                    //�g�p��������ȕ��S�z��ݒ肷��B
                    patientState.setKohiSelfPayUse(kohi[2], get_701026());
                } else {
                    set_701026(selfPay);
                    set_701025(get_701025() - get_701026());
                    //�g�p��������ȕ��S�z��ݒ肷��B
                    patientState.setKohiSelfPayUse(kohi[2], selfPay);
                }
            }
        }
        
		//���p�ҕ��S�z�̊m����s���B
		//���z-���ی����S-����P-����Q-����R-����P�{�l���S-����Q�{�l���S-����R�{�l���S
		set_701017((int)Math.floor((double)(get_701014() * get_701015Multiplies100()) / 100d)
		                    - get_701016()
		                    - get_701019()
		                    - get_701022()
                            - get_701025()
                            - get_701020()
                            - get_701023()
                            - get_701026());
        
        // 2016/10/11 [Yoichiro Kamei] add - begin �������ƑΉ�
        if (isDokujiTeiritsuTeigaku()) {
            if (isDokuji()) {
                // �Ǝ�
                // ���p�ҕ��S�z
                set_701017(this.sjClaimCalc.getDokujiTotalSeikyugaku()
                        - get_701016()
                        - get_701019()
                        - get_701022()
                        - get_701025()
                        - get_701020()
                        - get_701023()
                        - get_701026());
            } else if (isDokujiTeiritsu()) {
                // �Ǝ��藦
                // ���p�ҕ��S�z
                set_701017(this.sjClaimCalc.getTeiritsuTotalSeikyugaku()
                        - get_701016()
                        - get_701019()
                        - get_701022()
                        - get_701025()
                        - get_701020()
                        - get_701023()
                        - get_701026());
                
            } else if (isDokujiTeigaku()) {
                // �Ǝ���z
                // ���Ɣ���z
                if (!get_701006().toUpperCase().startsWith("H")) {
                    set_701016(this.sjClaimCalc.getTeigakuJigyohiSeikyugaku(get_701019() + get_701022() + get_701025()
                        , get_701020() + get_701023() + get_701026()));
                }
                // ���p�ҕ��S�z
                set_701017(this.sjClaimCalc.getTeigakuRiyoshaFutangaku());
            }
            
            //�������Ƃ̒P�ʐ��P����ݒ�
            set_701015(this.sjClaimCalc.getUnitPrice());
            //�������Ƃ̋敪���x���P�ʐ�����ݒ�
            set_701047(this.sjClaimCalc.getSogoLimitOverInfo());
        }
        // 2016/10/11 [Yoichiro Kamei] add - end
        
        
        //�O�̂���
        //���p�ҕ��S�z���}�C�i�X�ɂȂ����ꍇ
        if(get_701017() < 0){
            //����K�p���ʂ̒Ⴂ���̂��痘�p�ҕ��S�z������
            if(get_701025() > 0){
                set_701025(get_701025() + get_701017());
            } else {
                if(get_701022() > 0){
                    set_701022(get_701022() + get_701017());
                } else {
                    if(get_701019() > 0){
                        set_701019(get_701019() + get_701017());
                    }
                }
            }
            set_701017(0);
        }
        
        //����×{�Ǘ��w���͌��x�z�Ǘ��ΏۂƂ��Čv�サ�Ȃ���O����
        //���\�h����×{�Ǘ��w���ɂ����l�̏������s�Ȃ��B
        //if(get_701007().equals("31")){
        if(get_701007().equals("31") || get_701007().equals("34")){
            set_701011(0);
        }
        
        //�����p��ł���΁A�񐔂�ύX
        if(get_701007().equals("17") || get_701007().equals("67")){
            set_701008(ACDateUtilities.getLastDayOfMonth(ACCastUtilities.toDate(get_701003() + "01")));
        }
        
        
        //�������W�v���@�l����Z�̎O�A��Z�̎l�̗�O����
        /*
         * �P�D�O�����p�^���t����P�ʐ�
         * ����{�ݓ����Ґ������i���\�h���܂ށj�ɂ����ĊO���T�[�r�X���p�^��
         * �T�[�r�X�����{�����ꍇ�́A�v����ԁE�v�x����Ԃ��Ƃɒ�߂�ꂽ�O��
         * �T�[�r�X���p�^�ɂ�������x�P�ʐ����L�ڂ��邱�ƁB
         * �@��������Ґ������i���\�h���܂ށj�ɂ����Ĉ�ʌ^�̃T�[�r�X�����{����
         * �ꍇ�A�y�ђn�斧���^����{�ݓ����Ґ������̃T�[�r�X�����{�����ꍇ�́A
         * �L�ڕs�v�ł��邱�ƁB
         * 
         * �Q�D�O�����p�^����Ǘ��ΏےP�ʐ�
         * ����{�ݓ����Ґ������i���\�h���܂ށj�ɂ����ĊO���T�[�r�X���p�^��
         * �T�[�r�X�����{�����ꍇ�́A���t��ח��̃T�[�r�X�P�ʐ��̍��v���L��
         * ���邱�ƁB
         * �@��������Ґ������i���\�h���܂ށj�ɂ����Ĉ�ʌ^�̃T�[�r�X�����{����
         * �ꍇ�A�y�ђn�斧���^����{�ݓ����Ґ������̃T�[�r�X�����{�����ꍇ�́A
         * �L�ڕs�v�ł��邱�ƁB
         * 
         * �R�D���t�P�ʐ�
         * ����{�ݓ����Ґ������i���\�h���܂ށj�ɂ����ĊO���T�[�r�X���p�^��
         * �T�[�r�X�����{�����ꍇ�́A�P�D�O�����p�^���t����P�ʐ��ƂQ�D�O�����p�^
         * ����Ǘ��ΏےP�ʐ��̂����ꂩ�Ⴂ�ق��̒P�ʐ����L�ڂ��邱�ƁB
         * �@����{�ݓ����Ґ������i���\�h���܂ށj�ɂ����Ĉ�ʌ^�̃T�[�r�X��
         * ���{�����ꍇ�́A���t�ߖ̗��̃T�[�r�X�P�ʐ��̍��v���L�ڂ��邱�ƁB
         */
        
        /* 2006.06.02 ���v�ۂ���Ƃ̂����ɂ��A�Ή����Ȃ����Ƃ�
        if(QP001StyleAbstract.IDENTIFICATION_NO_6_3.equals(get_701001())
        	|| QP001StyleAbstract.IDENTIFICATION_NO_6_4.equals(get_701001())){
        	
        	//�O�����p�^�ȊO�̃T�[�r�X�𗘗p���Ă���ꍇ
        	if(externalNoUse && externalUse){
        		//���t�P�ʐ�
        		//���x�z�Ǘ��ΏےP�ʐ����R�s�[
        		set_701014(get_701010());
        		//���t����P�ʐ�
                set_701009(0);
                //���x�z�Ǘ��ΏےP�ʐ�
                set_701010(0);
        	}
        }
        */
        
	}
    
    /**
     * �v��P�ʐ����擾����B
     * @param styles
     * @param planUnitMap
     * @return
     * @throws Exception
     */
    private int getPlanUnit(VRMap styles,VRMap planUnitMap) throws Exception {
        int result = 0;
        
        //���ѓo�^��ʂœ��͂��ꂽ�v��P�ʐ����Q�Ƃ���B
        if(planUnitMap != null){
// 2016/7/15 [Yoichiro Kamei] mod - begin �������ƑΉ�
//        	String key = "10" + get_701007();
//        	// 10 + �T�[�r�X��ރR�[�h�̃L�[�����݂��邩�m�F
            String key = CareServiceCommon.getPlanUnitBindPath(get_701007());
// 2016/7/15 [Yoichiro Kamei] mod - end
        	
        	if(planUnitMap.containsKey(key)){
        		result = ACCastUtilities.toInt(planUnitMap.get(key),0);
        		
        		if(result != 0){
        			return result;
        		}
        	}
        }
// 2016/10/18 [Yoichiro Kamei] del - begin �������ƑΉ�
// �\��Ǎ����Ɍv��P�ʐ���ݒ肷��悤�ύX�������߁A�\��̃f�[�^�͌��Ȃ�
//        
//        //���ѓo�^��ʂŌv��P�ʐ��̓��͂������ꍇ�A�\��̃f�[�^�����ɍs��
//        
//        if(styles == null) return result;
//        
//        Iterator it = styles.keySet().iterator();
//        while(it.hasNext()){
//            QP001StyleAbstract style = (QP001StyleAbstract)styles.get(it.next());
//            if(style instanceof QP001Style11){
//                QP001Style11 target = (QP001Style11)style;
//                
//                Map supplyMap = (Map)target.getSupplyMap();
//                
//                Iterator supplyIt = supplyMap.keySet().iterator();
//                while(supplyIt.hasNext()){
//                    QP001RecordSupply supply = (QP001RecordSupply)supplyMap.get(supplyIt.next());
//                  //���Ə��ԍ��ƕی��Ҕԍ�,��ی��Ҕԍ��ƃT�[�r�X��ރR�[�h�����������̂�T��
//                  if(String.valueOf(supply.get_1201017()).equals(get_701004())
//                          && (String.valueOf(supply.get_1201003()).equals(get_701005()))
//                          && (String.valueOf(supply.get_1201009()).equals(get_701006()))
//                          && (String.valueOf(supply.get_1201019()).equals(get_701007()))){
//                      result = supply.get_1201020();
//                      break;
//                  }
//                }
//            }
//        }
// 2016/10/18 [Yoichiro Kamei] del - end
        return result;
        
    }
	
    /**
     * ����(���@)�������Ǘ����X�g���擾���܂��B
     * @return
     */
    protected VRList getEntranceRealDays() {
        return entranceRealDays;
    }
    /**
     * �ޏ�(�މ@)�������Ǘ����X�g���擾���܂��B
     * @return
     */
    protected VRList getOutEntranceRealDays() {
        return outEntranceRealDays;
    }
 
// 2015/5/12 [Yoichiro Kamei] mod - begin ����֘A������
//    /**
//     * ����̐����z���Z�o����B
//     * @param unit
//     * @param ratio
//     * @param reduction
//     * @return
//     */
//    private int getKohiClaim(int unit,int ratio,int reduction,int usedRate){
//        int result = 0;
//        int kyufu = 0;
//        //int total =(int)Math.floor((double)(get_701014() * get_701015Multiplies100()) / 100d);
//        int total =(int)Math.floor((double)(unit * get_701015Multiplies100()) / 100d);
//        
//        kyufu = (int)Math.floor(total * ((double)get_701040() / 100d));
//        //�ی����t����100%�̏ꍇ
////      if(ratio == 100){
//        if((ratio == 100) && (get_701014() == unit)){
//            //���p�Ґ���������ی����S�z������������
//            result = total - kyufu - reduction;
//        } else {
//            //���v���z*(����t��-�ی����t��-)
//            //result = (int)Math.floor((total * (ratio - get_701040()))/100);
//            result = (int)Math.floor((total * (ratio - usedRate))/100);
//        }
//        return result;
//    }
	/**
	 * ����̐����z���Z�o����B
	 * @param unit ����ΏےP�ʐ�
	 * @param ratio ����t���i��F95-100)
	 * @param reduction ��ʗD�揇�̌�����z�Ƃ��Čv��ς̋��z
	 * @param usedRate ��ʗD�揇�̌���t��
	 * @param tumiageUnit ��ʗD�揇�̌���ΏےP�ʐ��Ƃ��Čv��ς̒P�ʐ�
	 * @return
	 */
	private int getKohiClaim(int unit,int ratio,int reduction,int usedRate, int tumiageUnit){
		int result = 0;
		int kyufu = 0;
		int hokenTotal =(int)Math.floor((double)(get_701014() * get_701015Multiplies100()) / 100d);
        int total =(int)Math.floor((double)(unit * get_701015Multiplies100()) / 100d); //�S�̂̐����z
		
        kyufu = (int)Math.floor(total * ((double)get_701040() / 100d));//�ی������z
		//����t����100%�Ō���ΏےP�ʐ����ی��P�ʐ��̏ꍇ
        if((ratio == 100) && (get_701014() == unit)){
			//�S�̂̐����z������ی������z������������
			result = total - kyufu - reduction;
		} else if ((ratio == 100) && (get_701014() == (unit + tumiageUnit))) {
		    //����t����100%�Ō���ΏےP�ʐ���ςݏグ�����ʂ��T�[�r�X�P�ʐ��Ɠ������ꍇ
		    result = hokenTotal - kyufu - reduction;
		}else {
			//���v���z*(����t��-�ی����t��-)
		    if (usedRate != 100) {
		        result = (int)Math.floor((total * (ratio - usedRate))/100);
		    } else {
		        //��ʂ̌����100%���K�p�ς̏ꍇ
		        //���̈ꕔ�̊��Ԃ�����K�p�̏ꍇ�Ȃǂ͂�����
		        result = (int)Math.floor((total * (ratio - get_701040()))/100);
		    }
		}
		return result;
	}
// 2015/5/12 [Yoichiro Kamei] mod - end
	
	/**
	 * ���R�[�h�ŗL�̒l���쐬���܂��B
	 */
	protected String getSerialId() {
		StringBuilder serial = new StringBuilder();
		//������񎯕ʔԍ�4��
		serial.append(get_701001());
		//���R�[�h��ʃR�[�h
		serial.append(get_701002());
		//�T�[�r�X�񋟔N��6��(YYYYMM)
		serial.append(get_701003());
		//���Ə��ԍ�10��
		serial.append(get_701004());
		//�؋L�ڕی��Ҕԍ�8��
		serial.append(get_701005());
		//��ی��Ҕԍ�10��
		serial.append(get_701006());
		//�T�[�r�X��ރR�[�h2��
		serial.append(get_701007());
		return serial.toString();
	}

	/**
	 * ���R�[�h�ŗL�̒l���쐬���܂��B
	 * @param detail
	 * @return
	 * @throws Exception
	 */
	protected static String getSerialId(QP001RecordDetail detail) throws Exception {
		StringBuilder serial = new StringBuilder();
		//������񎯕ʔԍ�4��
		serial.append(detail.get_301001());
		//���R�[�h��ʃR�[�h
		serial.append(get_701002());
		//�T�[�r�X�񋟔N��6��(YYYYMM)
		serial.append(detail.get_301003());
		//���Ə��ԍ�10��
		serial.append(detail.get_301004());
		//�؋L�ڕی��Ҕԍ�8��
		serial.append(detail.get_301005());
		//��ی��Ҕԍ�10��
		serial.append(detail.get_301006());
		//�T�[�r�X��ރR�[�h2��
		serial.append(detail.get_301007());
		return serial.toString();
	}
	
	/**
	 * �f�[�^�쐬
	 * @param style
	 * @return
	 */
	protected VRMap getRecord(VRMap style) throws Exception {
		VRMap result = copyStyle(style);
		
		//������񎯕ʔԍ�4��
		setData(result,"701001",get_701001());
		//���R�[�h��ʃR�[�h2��(10��ݒ�)
		setData(result,"701002",get_701002());
		//�T�[�r�X�񋟔N��6��(YYYYMM)
		setData(result,"701003",get_701003());
		//���Ə��ԍ�10��
		setData(result,"701004",get_701004());
		//�؋L�ڕی��Ҕԍ�8��
		setData(result,"701005",get_701005());
		//��ی��Ҕԍ�10��
		setData(result,"701006",get_701006());
		//�T�[�r�X��ރR�[�h2��
		setData(result,"701007",get_701007());
		//�T�[�r�X������2��
		setData(result,"701008",get_701008());
		//�v��P�ʐ�6��
		setData(result,"701009",get_701009());
		//���x�z�Ǘ��ΏےP�ʐ�6��
		setData(result,"701010",Integer.toString(get_701010()));
		//���x�z�Ǘ��ΏۊO�P�ʐ�6��
		setData(result,"701011",Integer.toString(get_701011()));
		//�Z�������v�����2��
		setData(result,"701012",get_701012());
		//�Z������������2��
		setData(result,"701013",get_701013());
		//(�ی�)�P�ʐ����v8��
		setData(result,"701014",get_701014());
		//(�ی�)�P�ʐ��P��4��
		setData(result,"701015",get_701015());
		//(�ی�)�����z9��
		setData(result,"701016",get_701016());
		//(�ی�)���p�ҕ��S�z8��
		setData(result,"701017",get_701017());
		//(����1)�P�ʐ����v6��
		setData(result,"701018",get_701018());
		//(����1)�����z9��
		setData(result,"701019",get_701019());
		//(����1)�{�l���S�z6��
		setData(result,"701020",get_701020());
		//(����2)�P�ʐ����v6��
		setData(result,"701021",get_701021());
		//(����2)�����z9��
		setData(result,"701022",get_701022());
		//(����2)�{�l���S�z6��
		setData(result,"701023",get_701023());
		//(����3)�P�ʐ����v6��
		setData(result,"701024",get_701024());
		//(����3)�����z9��
		setData(result,"701025",get_701025());
		//(����3)�{�l���S�z6��
		setData(result,"701026",get_701026());
		//(�ی����o������Ô�)�P�ʐ����v8��
		setData(result,"701027",get_701027());
		//(�ی����o������Ô�)�����z9��
		setData(result,"701028",get_701028());
		//(�ی����o������Ô�)�o������Ô�p�ҕ��S�z8��
		setData(result,"701029",get_701029());
		//(����1���o������Ô�)�P�ʐ����v8��
		setData(result,"701030",get_701030());
		//(����1���o������Ô�)�����z9��
		setData(result,"701031",get_701031());
		//(����1���o������Ô�)�o������Ô�{�l���S�z8��
		setData(result,"701032",get_701032());
		//(����2���o������Ô�)�P�ʐ����v8��
		setData(result,"701033",get_701033());
		//(����2���o������Ô�)�����z9��
		setData(result,"701034",get_701034());
		//(����2���o������Ô�)�o������Ô�{�l���S�z8��
		setData(result,"701035",get_701035());
		//(����3���o������Ô�)�P�ʐ����v8��
		setData(result,"701036",get_701036());
		//(����3���o������Ô�)�����z9��
		setData(result,"701037",get_701037());
		//(����3���o������Ô�)�o������Ô�{�l���S�z8��
		setData(result,"701038",get_701038());
		//�T�[�r�X����
//		setData(result,"701039",get_701039());
		
		//[ID:0000525][Shin Fujihara] 2009/07 add begin 2009�N�x�Ή�
		setData(result,"701046",get_701046());
		//[ID:0000525][Shin Fujihara] 2009/07 add end 2009�N�x�Ή�
		
		setData(result,"701047",get_701047()); // 2016/10 add �������ƓƎ��Ή�
		
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
		//�W�v��񃌃R�[�h
		//result.put("CATEGORY_NO","7");
        result.put("CATEGORY_NO",QkanConstants.CATEGORY_NO_RECORD_TOTAL);
		return result;
	}
	
	public String toString(){
		StringBuilder result = new StringBuilder();
		result.append("[701001=" + get_701001() + "]\n");
		result.append("[701002=" + get_701002() + "]\n");
		result.append("[701003=" + get_701003() + "]\n");
		result.append("[701004=" + get_701004() + "]\n");
		result.append("[701005=" + get_701005() + "]\n");
		result.append("[701006=" + get_701006() + "]\n");
		result.append("[701007=" + get_701007() + "]\n");
		result.append("[701008=" + get_701008() + "]\n");
		result.append("[701009=" + get_701009() + "]\n");
		result.append("[701010=" + get_701010() + "]\n");
		result.append("[701011=" + get_701011() + "]\n");
		result.append("[701012=" + get_701012() + "]\n");
		result.append("[701013=" + get_701013() + "]\n");
		result.append("[701014=" + get_701014() + "]\n");
		result.append("[701015=" + get_701015() + "]\n");
		result.append("[701016=" + get_701016() + "]\n");
		result.append("[701017=" + get_701017() + "]\n");
		result.append("[701018=" + get_701018() + "]\n");
		result.append("[701019=" + get_701019() + "]\n");
		result.append("[701020=" + get_701020() + "]\n");
		result.append("[701021=" + get_701021() + "]\n");
		result.append("[701022=" + get_701022() + "]\n");
		result.append("[701023=" + get_701023() + "]\n");
		result.append("[701024=" + get_701024() + "]\n");
		result.append("[701025=" + get_701025() + "]\n");
		result.append("[701026=" + get_701026() + "]\n");
		result.append("[701027=" + get_701027() + "]\n");
		result.append("[701028=" + get_701028() + "]\n");
		result.append("[701029=" + get_701029() + "]\n");
		result.append("[701030=" + get_701030() + "]\n");
		result.append("[701031=" + get_701031() + "]\n");
		result.append("[701032=" + get_701032() + "]\n");
		result.append("[701033=" + get_701033() + "]\n");
		result.append("[701034=" + get_701034() + "]\n");
		result.append("[701035=" + get_701035() + "]\n");
		result.append("[701036=" + get_701036() + "]\n");
		result.append("[701037=" + get_701037() + "]\n");
		result.append("[701038=" + get_701038() + "]\n");
		result.append("[701039=" + get_701039() + "]\n");
		return result.toString();
	}
	
	
}
