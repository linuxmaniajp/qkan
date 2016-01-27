
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
 * �v���O���� ��{��񃌃R�[�h (QP001RecordBase)
 *
 *****************************************************************
 */

package jp.nichicom.ac.lib.care.claim.calculation;

import java.util.Date;
import java.util.Iterator;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.ac.util.ACDateUtilities;
import jp.nichicom.vr.text.parsers.VRDateParser;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanConstants;

/**
 * ��{��񃌃R�[�h
 *
 */
public class QP001RecordBase extends QP001RecordAbstract {

	//������񎯕ʔԍ�4��
	private String _201001 = "";
	//���R�[�h��ʃR�[�h2��(01��ݒ�)
	private static final String _201002 = "01";
	//�T�[�r�X�񋟔N��6��(YYYYMM)
	private String _201003 = "";
	//���Ə��ԍ�10��
	private String _201004 = "";
	//�؋L�ڕی��Ҕԍ�8��
	private String _201005 = "";
	//��ی��Ҕԍ�10��
	private String _201006 = "";
	//(����1)���S�Ҕԍ�8��
	private String _201007 = "";
	//(����1)�󋋎Ҕԍ�7��
	private String _201008 = "";
	//(����2)���S�Ҕԍ�8��
	private String _201009 = "";
	//(����2)�󋋎Ҕԍ�7��
	private String _201010 = "";
	//(����3)���S�Ҕԍ�8��
	private String _201011 = "";
	//(����3)�󋋎Ҕԍ�7��
	private String _201012 = "";
	//(��ی��ҏ��)���N����8��YYYYMMDD
	private String _201013 = "";
	//(��ی��ҏ��)���ʃR�[�h1��1-�j 2-��
	private String _201014 = "";
	//(��ی��ҏ��)�v����ԋ敪�R�[�h2��01-��Y�� 11-�v�x�� 21-�v���1 22-�v���2 23-�v���3 24-�v���4 25-�v���5
	private String _201015 = "";
	//(��ی��ҏ��)���[�u�����ғ���R�[�h1��1-�Ȃ� 2-����
	private String _201016 = "";
	//(��ی��ҏ��)�F��L������ �J�n�N����8��(YYYYMMDD)
	private String _201017 = "";
	//(��ی��ҏ��)�F��L������ �I���N����8��(YYYYMMDD)
	private String _201018 = "";
	//(����T�[�r�X�v��)����T�[�r�X�v��쐬�敪�R�[�h1��1-������x�����Ə��쐬 2-���ȍ쐬
	private int _201019 = 0;
	//(����T�[�r�X�v��)���Ə��ԍ�10��(������x�����Ə�)
	private String _201020 = "";
	//�J�n�N����8��(YYYYMMDD)
	private String _201021 = "";
	//���~�N����8��(YYYYMMDD)
	private String _201022 = "";
	//���~���R�R�[�h1��1-��Y�� 2-���{�� 3-��Ë@�֓��@ 4-���S 5-���̑�
	private int _201023 = 0;
	//����(�@)�N����8��(YYYYMMDD)
	private String _201024 = "";
	//�ޏ�(�@)�N����8��(YYYYMMDD)
	private String _201025 = "";
	//����(�@)������2��
	private String _201026 = "";
	//�O������2��
	private String _201027 = "";
	//�ޏ�(�@)��̏�ԃR�[�h1��1-���� 2-���{�� 3-��Ë@�֓��@ 4-���S 5-���̑�
	private int _201028 = 0;
	//�ی����t��3��
	private int _201029 = 0;
	//����1���t��
	private int _201030 = 0;
	//����2���t��
	private int _201031 = 0;
	//����3���t��
	private int _201032 = 0;
	//(���v��� �ی�)�T�[�r�X�P�ʐ�8��
	private int _201033 = 0;
	//(���v��� �ی�)�����z9��
	private int _201034 = 0;
	//(���v��� �ی�)���p�ҕ��S�z8��
	private int _201035 = 0;
	//(���v��� �ی�)�ً}���{�ݗ×{����z9��
	private int _201036 = 0;
	//(���v��� �ی�)����f�Ô���z9��
	private int _201037 = 0;
	//(���v��� �ی�)��������҉��T�[�r�X������z8��
	private int _201038 = 0;
	//(���v��� ����1)�T�[�r�X�P�ʐ�8��
	private int _201039 = 0;
	//(���v��� ����1)�����z8��
	private int _201040 = 0;
	//(���v��� ����1)�{�l���S�z8��
	private int _201041 = 0;
	//(���v��� ����1)�ً}���{�ݗ×{����z8��
	private int _201042 = 0;
	//(���v��� ����1)����f�Ô���z8��
	private int _201043 = 0;
	//(���v��� ����1)��������҉��T�[�r�X������z8��
	private int _201044 = 0;
	//(���v��� ����2)�T�[�r�X�P�ʐ�8��
	private int _201045 = 0;
	//(���v��� ����2)�����z8��
	private int _201046 = 0;
	//(���v��� ����2)�{�l���S�z8��
	private int _201047 = 0;
	//(���v��� ����2)�ً}���{�ݗ×{����z8��
	private int _201048 = 0;
	//(���v��� ����2)����f�Ô���z8��
	private int _201049 = 0;
	//(���v��� ����2)��������҉��T�[�r�X������z8��
	private int _201050 = 0;
	//(���v��� ����3)�T�[�r�X�P�ʐ�8��
	private int _201051 = 0;
	//(���v��� ����3)�����z8��
	private int _201052 = 0;
	//(���v��� ����3)�{�l���S�z8��
	private int _201053 = 0;
	//(���v��� ����3)�ً}���{�ݗ×{����z8��
	private int _201054 = 0;
	//(���v��� ����3)����f�Ô���z8��
	private int _201055 = 0;
	//(���v��� ����3)��������҉��T�[�r�X������z8��
	private int _201056 = 0;
	//����T�[�r�X�v��Ҏ��Ə���
	private String _201057 = "";
	//����1 ������(KOHI_TYPE)
	private String _201058 = "";
	//����2 ������(KOHI_TYPE)
	private String _201059 = "";
	//����3 ������(KOHI_TYPE)
	private String _201060 = "";
	//�叝�a��
	private String _201061 = "";
	
	protected String getSerialId() {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		return null;
	}

	/**
	 * ������񎯕ʔԍ�4�����擾����B
	 */
	protected String get_201001() {
		return _201001;
	}
	/**
	 * ������񎯕ʔԍ�4����ݒ肷��B
	 * @param _201001
	 */
	protected void set_201001(String _201001) {
		this._201001 = _201001;
	}
	/**
	 * ���R�[�h��ʃR�[�h2��(01��ݒ�)���擾����B
	 * @return
	 */
	protected String get_201002() {
		return _201002;
	}
	/**
	 * �T�[�r�X�񋟔N��6��(YYYYMM)���擾����B
	 * @return
	 */
	protected String get_201003() {
		return _201003;
	}
	/**
	 * �T�[�r�X�񋟔N��6��(YYYYMM)��ݒ肷��B
	 * @param _201003
	 */
	protected void set_201003(String _201003) {
		this._201003 = _201003;
	}
	/**
	 * ���Ə��ԍ�10�����擾����B
	 * @return
	 */
	protected String get_201004() {
		return _201004;
	}
	/**
	 * ���Ə��ԍ�10����ݒ肷��B
	 * @param _201004
	 */
	protected void set_201004(String _201004) {
		this._201004 = _201004;
	}
	/**
	 * �؋L�ڕی��Ҕԍ�8�����擾����B
	 * @return
	 */
	protected String get_201005() {
		return _201005;
	}
	/**
	 * �؋L�ڕی��Ҕԍ�8����ݒ肷��B
	 * @param _201005
	 */
	protected void set_201005(String _201005) {
		this._201005 = _201005;
	}
	/**
	 * ��ی��Ҕԍ�10�����擾����B
	 * @return
	 */
	protected String get_201006() {
		return _201006;
	}
	/**
	 * ��ی��Ҕԍ�10����ݒ肷��B
	 * @param _201006
	 */
	protected void set_201006(String _201006) {
		this._201006 = _201006;
	}
	/**
	 * (����1)���S�Ҕԍ�8�����擾����B
	 * @return
	 */
	protected String get_201007() {
		return _201007;
	}
	/**
	 * (����1)���S�Ҕԍ�8����ݒ肷��B
	 * @param _201007
	 */
	protected void set_201007(String _201007) {
		this._201007 = _201007;
	}
	/**
	 * (����1)�󋋎Ҕԍ�7�����擾����B
	 * @return
	 */
	protected String get_201008() {
		return _201008;
	}
	/**
	 * (����1)�󋋎Ҕԍ�7����ݒ肷��B
	 * @param _201008
	 */
	protected void set_201008(String _201008) {
		this._201008 = _201008;
	}
	/**
	 * (����2)���S�Ҕԍ�8�����擾����B
	 * @return
	 */
	protected String get_201009() {
		return _201009;
	}
	/**
	 * (����2)���S�Ҕԍ�8����ݒ肷��B
	 * @param _201009
	 */
	protected void set_201009(String _201009) {
		this._201009 = _201009;
	}
	/**
	 * (����2)�󋋎Ҕԍ�7�����擾����B
	 * @return
	 */
	protected String get_201010() {
		return _201010;
	}
	/**
	 * (����2)�󋋎Ҕԍ�7����ݒ肷��B
	 * @param _201010
	 */
	protected void set_201010(String _201010) {
		this._201010 = _201010;
	}
	/**
	 * (����3)���S�Ҕԍ�8�����擾����B
	 * @return
	 */
	protected String get_201011() {
		return _201011;
	}
	/**
	 * (����3)���S�Ҕԍ�8����ݒ肷��B
	 * @param _201011
	 */
	protected void set_201011(String _201011) {
		this._201011 = _201011;
	}
	/**
	 * (����3)�󋋎Ҕԍ�7�����擾����B
	 * @return
	 */
	protected String get_201012() {
		return _201012;
	}
	/**
	 * (����3)�󋋎Ҕԍ�7����ݒ肷��B
	 * @param _201012
	 */
	protected void set_201012(String _201012) {
		this._201012 = _201012;
	}
	/**
	 * (��ی��ҏ��)���N����8��YYYYMMDD���擾����B
	 * @return
	 */
	protected String get_201013() {
		return _201013;
	}
	/**
	 * (��ی��ҏ��)���N����8��YYYYMMDD��ݒ肷��B
	 * @param _201013
	 */
	protected void set_201013(String _201013) {
		this._201013 = _201013;
	}
	/**
	 * (��ی��ҏ��)���ʃR�[�h1�����擾����B
	 * @return 1-�j 2-��
	 */
	protected String get_201014() {
		return _201014;
	}
	/**
	 * (��ی��ҏ��)���ʃR�[�h1����ݒ肷��B
	 * @param _201014 1-�j 2-��
	 */
	protected void set_201014(String _201014) {
		this._201014 = _201014;
	}
	/**
	 * (��ی��ҏ��)�v����ԋ敪�R�[�h2�����擾����B
	 * @return 01-��Y�� 11-�v�x�� 21-�v���1 22-�v���2 23-�v���3 24-�v���4 25-�v���5
	 */
	protected String get_201015() {
		return _201015;
	}
	/**
	 * (��ی��ҏ��)�v����ԋ敪�R�[�h2����ݒ肷��B
	 * @param _201015 01-��Y�� 11-�v�x�� 21-�v���1 22-�v���2 23-�v���3 24-�v���4 25-�v���5
	 */
	protected void set_201015(String _201015) {
		this._201015 = _201015;
	}
	/**
	 * (��ی��ҏ��)���[�u�����ғ���R�[�h1�����擾����B
	 * @return 1-�Ȃ� 2-����
	 */
	protected String get_201016() {
		return _201016;
	}
	/**
	 * (��ی��ҏ��)���[�u�����ғ���R�[�h1�����擾����B
	 * @param _201016 1-�Ȃ� 2-����
	 */
	protected void set_201016(String _201016) {
		this._201016 = _201016;
	}
	/**
	 * (��ی��ҏ��)�F��L������ �J�n�N����8��(YYYYMMDD)���擾����B
	 * @return
	 */
	protected String get_201017() {
		return _201017;
	}
	/**
	 * (��ی��ҏ��)�F��L������ �J�n�N����8��(YYYYMMDD)��ݒ肷��B
	 * @param _201017
	 */
	protected void set_201017(String _201017) {
		this._201017 = _201017;
	}
	/**
	 * (��ی��ҏ��)�F��L������ �I���N����8��(YYYYMMDD)���擾����B
	 * @return
	 */
	protected String get_201018() {
		return _201018;
	}
	/**
	 * (��ی��ҏ��)�F��L������ �I���N����8��(YYYYMMDD)��ݒ肷��B
	 * @param _201018
	 */
	protected void set_201018(String _201018) {
		this._201018 = _201018;
	}
	/**
	 * (����T�[�r�X�v��)����T�[�r�X�v��쐬�敪�R�[�h1�����擾����B
	 * @return 1-������x�����Ə��쐬 2-���ȍ쐬
	 */
	protected int get_201019() {
		return _201019;
	}
	/**
	 * (����T�[�r�X�v��)����T�[�r�X�v��쐬�敪�R�[�h1����ݒ肷��B
	 * @param _201019 1-������x�����Ə��쐬 2-���ȍ쐬
	 */
	protected void set_201019(int _201019) {
		this._201019 = _201019;
	}
	/**
	 * (����T�[�r�X�v��)���Ə��ԍ�10��(������x�����Ə�)���擾����B
	 * @return
	 */
	protected String get_201020() {
		return _201020;
	}
	/**
	 * (����T�[�r�X�v��)���Ə��ԍ�10��(������x�����Ə�)��ݒ肷��B
	 * @param _201020
	 */
	protected void set_201020(String _201020) {
		this._201020 = _201020;
	}
	/**
	 * �J�n�N����8��(YYYYMMDD)���擾����B
	 * @return
	 */
	protected String get_201021() {
		return _201021;
	}
	/**
	 * �J�n�N����8��(YYYYMMDD)��ݒ肷��B
	 * @param _201021
	 */
	protected void set_201021(String _201021) {
		this._201021 = _201021;
	}
	/**
	 * ���~�N����8��(YYYYMMDD)���擾����B
	 * @return
	 */
	protected String get_201022() {
		return _201022;
	}
	/**
	 * ���~�N����8��(YYYYMMDD)��ݒ肷��B
	 * @param _201022
	 */
	protected void set_201022(String _201022) {
		this._201022 = _201022;
	}
	/**
	 * ���~���R�R�[�h1�����擾����B
	 * @return 1-��Y�� 2-���{�� 3-��Ë@�֓��@ 4-���S 5-���̑�
	 */
	protected int get_201023() {
		return _201023;
	}
	/**
	 * ���~���R�R�[�h1����ݒ肷��B
	 * @param _201023 1-��Y�� 2-���{�� 3-��Ë@�֓��@ 4-���S 5-���̑�
	 */
	protected void set_201023(int _201023) {
		this._201023 = _201023;
	}
	/**
	 * ����(�@)�N����8��(YYYYMMDD)���擾����B
	 * @return
	 */
	protected String get_201024() {
		return _201024;
	}
	/**
	 * ����(�@)�N����8��(YYYYMMDD)��ݒ肷��B
	 * @param _201024
	 */
	protected void set_201024(String _201024) {
		this._201024 = _201024;
	}
	/**
	 * �ޏ�(�@)�N����8��(YYYYMMDD)���擾����B
	 * @return
	 */
	protected String get_201025() {
		return _201025;
	}
	/**
	 * �ޏ�(�@)�N����8��(YYYYMMDD)��ݒ肷��B
	 * @param _201025
	 */
	protected void set_201025(String _201025) {
		this._201025 = _201025;
	}
	/**
	 * ����(�@)������2�����擾����B
	 * @return
	 */
	protected String get_201026() {
		return _201026;
	}
	/**
	 * ����(�@)������2����ݒ肷��B
	 * @param _201026
	 */
	protected void set_201026(String _201026) {
		this._201026 = _201026;
	}
	/**
	 * �O������2�����擾����B
	 * @return
	 */
	protected String get_201027() {
		return _201027;
	}
	/**
	 * �O������2����ݒ肷��B
	 * @param _201027
	 */
	protected void set_201027(String _201027) {
		this._201027 = _201027;
	}
	/**
	 * �ޏ�(�@)��̏�ԃR�[�h1�����擾����B
	 * @return 1-���� 2-���{�� 3-��Ë@�֓��@ 4-���S 5-���̑�
	 */
	protected int get_201028() {
		return _201028;
	}
	/**
	 * �ޏ�(�@)��̏�ԃR�[�h1����ݒ肷��B
	 * @param _201028 1-���� 2-���{�� 3-��Ë@�֓��@ 4-���S 5-���̑�
	 */
	protected void set_201028(int _201028) {
		this._201028 = _201028;
	}
	/**
	 * �ی����t��3�����擾����B
	 * @return
	 */
	protected int get_201029() {
		return _201029;
	}
	/**
	 * �ی����t��3����ݒ肷��B
	 * @param _201029
	 */
	protected void set_201029(int _201029) {
		this._201029 = _201029;
	}
	/**
	 * ����1���t�����擾����B
	 * @return
	 */
	protected int get_201030() {
		return _201030;
	}
	/**
	 * ����1���t����ݒ肷��B
	 * @param _201030
	 */
	protected void set_201030(int _201030) {
		this._201030 = _201030;
	}
	/**
	 * ����2���t�����擾����B
	 * @return
	 */
	protected int get_201031() {
		return _201031;
	}
	/**
	 * ����2���t����ݒ肷��B
	 * @param _201031
	 */
	protected void set_201031(int _201031) {
		this._201031 = _201031;
	}
	/**
	 * ����3���t�����擾����B
	 * @return
	 */
	protected int get_201032() {
		return _201032;
	}
	/**
	 * ����3���t����ݒ肷��B
	 * @param _201032
	 */
	protected void set_201032(int _201032) {
		this._201032 = _201032;
	}
	/**
	 * (���v��� �ی�)�T�[�r�X�P�ʐ�8�����擾����B
	 * @return
	 */
	protected int get_201033() {
		return _201033;
	}
	/**
	 * (���v��� �ی�)�T�[�r�X�P�ʐ�8����ݒ肷��B
	 * @param _201033
	 */
	protected void set_201033(int _201033) {
		this._201033 = _201033;
	}
	/**
	 * (���v��� �ی�)�����z9�����擾����B
	 * @return
	 */
	protected int get_201034() {
		return _201034;
	}
	/**
	 * (���v��� �ی�)�����z9����ݒ肷��B
	 * @param _201034
	 */
	protected void set_201034(int _201034) {
		this._201034 = _201034;
	}
	/**
	 * (���v��� �ی�)���p�ҕ��S�z8�����擾����B
	 * @return
	 */
	protected int get_201035() {
		return _201035;
	}
	/**
	 * (���v��� �ی�)���p�ҕ��S�z8����ݒ肷��B
	 * @param _201035
	 */
	protected void set_201035(int _201035) {
		this._201035 = _201035;
	}
	/**
	 * (���v��� �ی�)�ً}���{�ݗ×{����z9�����擾����B
	 * @return
	 */
	protected int get_201036() {
		return _201036;
	}
	/**
	 * (���v��� �ی�)�ً}���{�ݗ×{����z9����ݒ肷��B
	 * @param _201036
	 */
	protected void set_201036(int _201036) {
		this._201036 = _201036;
	}
	/**
	 * (���v��� �ی�)����f�Ô���z9�����擾����B
	 * @return
	 */
	protected int get_201037() {
		return _201037;
	}
	/**
	 * (���v��� �ی�)����f�Ô���z9����ݒ肷��B
	 * @param _201037
	 */
	protected void set_201037(int _201037) {
		this._201037 = _201037;
	}
	/**
	 * (���v��� �ی�)��������҉��T�[�r�X������z8�����擾����B
	 * @return
	 */
	protected int get_201038() {
		return _201038;
	}
	/**
	 * (���v��� �ی�)��������҉��T�[�r�X������z8����ݒ肷��B
	 * @param _201038
	 */
	protected void set_201038(int _201038) {
		this._201038 = _201038;
	}
	/**
	 * (���v��� ����1)�T�[�r�X�P�ʐ�8�����擾����B
	 * @return
	 */
	protected int get_201039() {
		return _201039;
	}
	/**
	 * (���v��� ����1)�T�[�r�X�P�ʐ�8����ݒ肷��B
	 * @param _201039
	 */
	protected void set_201039(int _201039) {
		this._201039 = _201039;
	}
	/**
	 * (���v��� ����1)�����z8�����擾����B
	 * @return
	 */
	protected int get_201040() {
		return _201040;
	}
	/**
	 * (���v��� ����1)�����z8����ݒ肷��B
	 * @param _201040
	 */
	protected void set_201040(int _201040) {
		this._201040 = _201040;
	}
	/**
	 * (���v��� ����1)�{�l���S�z8�����擾����B
	 * @return
	 */
	protected int get_201041() {
		return _201041;
	}
	/**
	 * (���v��� ����1)�{�l���S�z8����ݒ肷��B
	 * @param _201041
	 */
	protected void set_201041(int _201041) {
		this._201041 = _201041;
	}
	/**
	 * (���v��� ����1)�ً}���{�ݗ×{����z8�����擾����B
	 * @return
	 */
	protected int get_201042() {
		return _201042;
	}
	/**
	 * (���v��� ����1)�ً}���{�ݗ×{����z8����ݒ肷��B
	 * @param _201042
	 */
	protected void set_201042(int _201042) {
		this._201042 = _201042;
	}
	/**
	 * (���v��� ����1)����f�Ô���z8�����擾����B
	 * @return
	 */
	protected int get_201043() {
		return _201043;
	}
	/**
	 * (���v��� ����1)����f�Ô���z8����ݒ肷��B
	 * @param _201043
	 */
	protected void set_201043(int _201043) {
		this._201043 = _201043;
	}
	/**
	 * (���v��� ����1)��������҉��T�[�r�X������z8�����擾����B
	 * @return
	 */
	protected int get_201044() {
		return _201044;
	}
	/**
	 * (���v��� ����1)��������҉��T�[�r�X������z8����ݒ肷��B
	 * @param _201044
	 */
	protected void set_201044(int _201044) {
		this._201044 = _201044;
	}
	/**
	 * (���v��� ����2)�T�[�r�X�P�ʐ�8�����擾����B
	 * @return
	 */
	protected int get_201045() {
		return _201045;
	}
	/**
	 * (���v��� ����2)�T�[�r�X�P�ʐ�8����ݒ肷��B
	 * @param _201045
	 */
	protected void set_201045(int _201045) {
		this._201045 = _201045;
	}
	/**
	 * (���v��� ����2)�����z8�����擾����B
	 * @return
	 */
	protected int get_201046() {
		return _201046;
	}
	/**
	 * (���v��� ����2)�����z8����ݒ肷��B
	 * @param _201046
	 */
	protected void set_201046(int _201046) {
		this._201046 = _201046;
	}
	/**
	 * (���v��� ����2)�{�l���S�z8�����擾����B
	 * @return
	 */
	protected int get_201047() {
		return _201047;
	}
	/**
	 * (���v��� ����2)�{�l���S�z8����ݒ肷��B
	 * @param _201047
	 */
	protected void set_201047(int _201047) {
		this._201047 = _201047;
	}
	/**
	 * (���v��� ����2)�ً}���{�ݗ×{����z8�����擾����B
	 * @return
	 */
	protected int get_201048() {
		return _201048;
	}
	/**
	 * (���v��� ����2)�ً}���{�ݗ×{����z8����ݒ肷��B
	 * @param _201048
	 */
	protected void set_201048(int _201048) {
		this._201048 = _201048;
	}
	/**
	 * (���v��� ����2)����f�Ô���z8�����擾����B
	 * @return
	 */
	protected int get_201049() {
		return _201049;
	}
	/**
	 * (���v��� ����2)����f�Ô���z8����ݒ肷��B
	 * @param _201049
	 */
	protected void set_201049(int _201049) {
		this._201049 = _201049;
	}
	/**
	 * (���v��� ����2)��������҉��T�[�r�X������z8�����擾����B
	 * @return
	 */
	protected int get_201050() {
		return _201050;
	}
	/**
	 * (���v��� ����2)��������҉��T�[�r�X������z8����ݒ肷��B
	 * @param _201050
	 */
	protected void set_201050(int _201050) {
		this._201050 = _201050;
	}
	/**
	 * (���v��� ����3)�T�[�r�X�P�ʐ�8�����擾����B
	 * @return
	 */
	protected int get_201051() {
		return _201051;
	}
	/**
	 * (���v��� ����3)�T�[�r�X�P�ʐ�8����ݒ肷��B
	 * @param _201051
	 */
	protected void set_201051(int _201051) {
		this._201051 = _201051;
	}
	/**
	 * (���v��� ����3)�����z8�����擾����B
	 * @return
	 */
	protected int get_201052() {
		return _201052;
	}
	/**
	 * (���v��� ����3)�����z8����ݒ肷��B
	 * @param _201052
	 */
	protected void set_201052(int _201052) {
		this._201052 = _201052;
	}
	/**
	 * (���v��� ����3)�{�l���S�z8�����擾����B
	 * @return
	 */
	protected int get_201053() {
		return _201053;
	}
	/**
	 * (���v��� ����3)�{�l���S�z8����ݒ肷��B
	 * @param _201053
	 */
	protected void set_201053(int _201053) {
		this._201053 = _201053;
	}
	/**
	 * (���v��� ����3)�ً}���{�ݗ×{����z8�����擾����B
	 * @return
	 */
	protected int get_201054() {
		return _201054;
	}
	/**
	 * (���v��� ����3)�ً}���{�ݗ×{����z8����ݒ肷��B
	 * @param _201054
	 */
	protected void set_201054(int _201054) {
		this._201054 = _201054;
	}
	/**
	 * (���v��� ����3)����f�Ô���z8�����擾����B
	 * @return
	 */
	protected int get_201055() {
		return _201055;
	}
	/**
	 * (���v��� ����3)����f�Ô���z8����ݒ肷��B
	 * @param _201055
	 */
	protected void set_201055(int _201055) {
		this._201055 = _201055;
	}
	/**
	 * (���v��� ����3)��������҉��T�[�r�X������z8�����擾����B
	 * @return
	 */
	protected int get_201056() {
		return _201056;
	}
	/**
	 * (���v��� ����3)��������҉��T�[�r�X������z8����ݒ肷��B
	 * @param _201056
	 */
	protected void set_201056(int _201056) {
		this._201056 = _201056;
	}
	/**
	 * ����T�[�r�X�v��Ҏ��Ə������擾����B
	 * @return
	 */
	protected String get_201057() {
		return _201057;
	}
	/**
	 * ����T�[�r�X�v��Ҏ��Ə�����ݒ肷��B
	 * @param _201057
	 */
	protected void set_201057(String _201057) {
		this._201057 = _201057;
	}
	/**
	 * ����1 ������(KOHI_TYPE)���擾����B
	 * @return
	 */
	protected String get_201058() {
		return _201058;
	}
	/**
	 * ����1 ������(KOHI_TYPE)��ݒ肷��B
	 * @param _201058
	 */
	protected void set_201058(String _201058) {
		this._201058 = _201058;
	}
	/**
	 * ����2 ������(KOHI_TYPE)���擾����B
	 * @return
	 */
	protected String get_201059() {
		return _201059;
	}
	/**
	 * ����2 ������(KOHI_TYPE)��ݒ肷��B
	 * @param _201059
	 */
	protected void set_201059(String _201059) {
		this._201059 = _201059;
	}
	/**
	 * ����3 ������(KOHI_TYPE)���擾����B
	 * @return
	 */
	protected String get_201060() {
		return _201060;
	}
	/**
	 * ����3 ������(KOHI_TYPE)��ݒ肷��B
	 * @param _201060
	 */
	protected void set_201060(String _201060) {
		this._201060 = _201060;
	}
	/**
	 * �叝�a�����擾����B
	 * @return
	 */
	protected String get_201061() {
		return _201061;
	}
	/**
	 * �叝�a����ݒ肷��B
	 * @param _201061
	 */
	protected void set_201061(String _201061) {
		this._201061 = _201061;
	}
	
	private boolean isNew(){
		//������񃌃R�[�h�ɓo�^��������ΐV�K�Ƃ݂Ȃ��B
		return ((get_201001() == null) || ("".equals(get_201001())));
	}
	
	/**
	 * ���̊m�菈�����s���B
	 * @param type
	 * @throws Exception
	 */
	protected void parse(QP001RecordType type,QP001PatientState patientState,QP001KohiKey[] kohiTypes,QP001Manager manager) throws Exception {
        
		//[ID:0000567][Shin Fujihara] 2009/12/10 del begin 2009�N�x�Ή�
		/*
        int history_id = 0;
        String history_id_temp = "";
        
        history_id_temp = patientState.getChangeData(type.get_701044(),"1","CHANGES_HISTORY_ID","1");
        
        if(!ACTextUtilities.isNullText(history_id_temp)){
            history_id = ACCastUtilities.toInt(history_id_temp);
        }
        //���ݕێ����Ă���ID�����傫���ꍇ
        if(history_id > _201021_id){
            //�J�n�N����8��(YYYYMMDD)
            set_201021(patientState.getChangeData(type.get_701044(),"1","CHANGES_DATE","1").replaceAll("-",""));
            _201021_id = history_id;
        }
        
        history_id = 0;
        history_id_temp = patientState.getChangeData(type.get_701044(),"2","CHANGES_HISTORY_ID","1");
        if(!ACTextUtilities.isNullText(history_id_temp)){
            history_id = ACCastUtilities.toInt(history_id_temp);
        }
        if(history_id > _201022_id){
            //���~�N����8��(YYYYMMDD)
            set_201022(patientState.getChangeData(type.get_701044(),"2","CHANGES_DATE","1").replaceAll("-",""));
            //���~���R�R�[�h1��1-��Y�� 2-���{�� 3-��Ë@�֓��@ 4-���S 5-���̑�
            set_201023(patientState.getChangeDatatoInt(type.get_701044(),"2","CHANGES_REASON","1"));
            _201022_id = history_id;
        }
        */
        //[ID:0000567][Shin Fujihara] 2009/12/10 del end 2009�N�x�Ή�
		
		//[ID:0000567][Shin Fujihara] 2009/12/10 add begin 2009�N�x�Ή�
		//�ٓ����̍ŐV�f�[�^�̗p�Ƃ����d�l����A�o�^����Ă���
		//���t���Ⴂ�҂��J�n�N�����Ƃ��č̗p����d�l�ɕύX
		//�I�����́A���t�̌Â��ق����̗p
		
		//�J�n�N�����̃f�[�^���m�F
		int value_temp = ACCastUtilities.toInt(
				patientState.getChangeData(type.get_701044(),"1","CHANGES_DATE","1").replaceAll("-",""), Integer.MAX_VALUE);
		
		if (value_temp < ACCastUtilities.toInt(get_201021(), Integer.MAX_VALUE)) {
			// �J�n�N����8��(YYYYMMDD)
			set_201021(ACCastUtilities.toString(value_temp));
		}
		
		//���~�N�����̃f�[�^���m�F
		value_temp = ACCastUtilities.toInt(
				patientState.getChangeData(type.get_701044(),"2","CHANGES_DATE","1").replaceAll("-",""), Integer.MIN_VALUE);
		
		
		if (ACCastUtilities.toInt(get_201022(), Integer.MIN_VALUE) < value_temp) {
			// ���~�N����8��(YYYYMMDD)
			set_201022(ACCastUtilities.toString(value_temp));
			//���~���R�R�[�h1��1-��Y�� 2-���{�� 3-��Ë@�֓��@ 4-���S 5-���̑�
			set_201023(patientState.getChangeDatatoInt(type.get_701044(),"2","CHANGES_REASON","1"));
		}
		//[ID:0000567][Shin Fujihara] 2009/12/10 add end 2009�N�x�Ή�
        
        
        //[ID:0000447][Shin Fujihara] 2009/02 add begin ����21�N4���@�����Ή�
        //����(�@)�O�̏�ԃR�[�h�@�O������p��
        //�l������Z�`�Z�̎l�A���A��A�\�Ɍ���
		if (QP001SpecialCase.isAdmissionStatusCodeTakeover(type.get_701001())) {
	        Object _201023temp = patientState.getLastDataCategory2(type.get_701001(), "201023");
	        if ((_201023temp != null) && (ACCastUtilities.toInt(_201023temp, 0) != 0)) {
	        	set_201023(ACCastUtilities.toInt(_201023temp, 0));
	        } else {
	        	//[ID:0000567][Shin Fujihara] 2009/12/10 del begin 2009�N�x�Ή�
	        	/*
	            history_id = 0;
	            history_id_temp = patientState.getChangeData(type.get_701044(),"1","CHANGES_HISTORY_ID","2,3,5");
	            if(!ACTextUtilities.isNullText(history_id_temp)){
	                history_id = ACCastUtilities.toInt(history_id_temp);
	            }
	            if(history_id > _201022_id){
	                //���~���R�E�����i�@�j�O�̏󋵃R�[�h
	            	//1:���� 2:��Ë@�� 3:���V�l�����{�� 4:���V�l�ی��{��
	            	//5:���×{�^��Î{�� 6:�F�m�ǑΉ��^��������� 7:����{�ݓ����Ґ������ 8:���̑� 
	                set_201023(patientState.getChangeDatatoInt(type.get_701044(),"1","CHANGES_REASON","2,3,5"));
	                _201022_id = history_id;
	            }
	            */
	            //[ID:0000567][Shin Fujihara] 2009/12/10 del end 2009�N�x�Ή�
	        	
	        	//[ID:0000567][Shin Fujihara] 2009/12/10 add begin 2009�N�x�Ή�
	    		value_temp = ACCastUtilities.toInt(
	    				patientState.getChangeData(type.get_701044(),"1","CHANGES_DATE","2,3,5").replaceAll("-",""), Integer.MIN_VALUE);
	        	
	    		if (ACCastUtilities.toInt(get_201022(), Integer.MIN_VALUE) < value_temp) {
	                //���~���R�E�����i�@�j�O�̏󋵃R�[�h
	            	//1:���� 2:��Ë@�� 3:���V�l�����{�� 4:���V�l�ی��{��
	            	//5:���×{�^��Î{�� 6:�F�m�ǑΉ��^��������� 7:����{�ݓ����Ґ������ 8:���̑�
	    			set_201023(patientState.getChangeDatatoInt(type.get_701044(),"1","CHANGES_REASON","2,3,5"));
	    		} 
                //[ID:0000567][Shin Fujihara] 2009/12/10 add end 2009�N�x�Ή�
	        }
        }
        //[ID:0000447][Shin Fujihara] 2009/02 add end ����21�N4���@�����Ή�
        
        //�ޏ��N�����A�ޏ���̏�ԃR�[�h�͖�������d�l�ɕύX
        //��]�A�Q�Ƃ���d�l�ɕύX
        set_201025("");
        set_201028(0);
        
        //�����N���������肷��
        setHospitalization(patientState, type);
        
		if(isNew()){
			//������񎯕ʔԍ�
			set_201001(type.get_701001());
			//�T�[�r�X�񋟔N��6��(YYYYMM)
			set_201003(type.get_701003());
			//���Ə��ԍ�10��
			set_201004(type.get_701004());
			//�؋L�ڕی��Ҕԍ�8��
			set_201005(type.get_701005());
			//��ی��Ҕԍ�
			set_201006(type.get_701006());

            if(!ACTextUtilities.isNullText(kohiTypes[0])){
                //(����1)���S�Ҕԍ�8��
                set_201007(patientState.getKohiData(kohiTypes[0],"KOHI_PAYER_NO",1));
                //(����1)�󋋎Ҕԍ�7��
                set_201008(patientState.getKohiData(kohiTypes[0],"KOHI_RECIPIENT_NO",1));
            }
            if(!ACTextUtilities.isNullText(kohiTypes[1])){
                //(����2)���S�Ҕԍ�8��
                set_201009(patientState.getKohiData(kohiTypes[1],"KOHI_PAYER_NO",1));
                //(����2)�󋋎Ҕԍ�7��
                set_201010(patientState.getKohiData(kohiTypes[1],"KOHI_RECIPIENT_NO",1));
            }
            if(!ACTextUtilities.isNullText(kohiTypes[2])){
                //(����3)���S�Ҕԍ�8��
                set_201011(patientState.getKohiData(kohiTypes[2],"KOHI_PAYER_NO",1));
                //(����3)�󋋎Ҕԍ�7��
                set_201012(patientState.getKohiData(kohiTypes[2],"KOHI_RECIPIENT_NO",1));
            }
			
			//(��ی��ҏ��)���N����8��YYYYMMDD
			set_201013(patientState.getPatientData("PATIENT_BIRTHDAY").replaceAll("-",""));
			//(��ی��ҏ��)���ʃR�[�h1��1-�j 2-��
			set_201014(patientState.getPatientData("PATIENT_SEX"));
			//(��ی��ҏ��)�v����ԋ敪�R�[�h2��01-��Y�� 11-�v�x�� 21-�v���1 22-�v���2 23-�v���3 24-�v���4 25-�v���5
			set_201015(patientState.getNinteiDataLast(get_201005(),get_201006(),"JOTAI_CODE"));
			//(��ی��ҏ��)���[�u�����ғ���R�[�h1��1-�Ȃ� 2-����
            set_201016(patientState.getShisetsuData("KYUSOCHI_FLAG"));
			//(��ی��ҏ��)�F��L������ �J�n�N����8��(YYYYMMDD)
			set_201017(patientState.getNinteiDataLast(get_201005(),get_201006(),"INSURE_VALID_START").replaceAll("-",""));
			//(��ی��ҏ��)�F��L������ �I���N����8��(YYYYMMDD)
			set_201018(patientState.getNinteiDataLast(get_201005(),get_201006(),"INSURE_VALID_END").replaceAll("-",""));
            
            //������x�������ԍ����K�p�ȗl���ł���ΐݒ肷��B
            if(QP001SpecialCase.isServicePlanMakerLiving(get_201001())){
                //(����T�[�r�X�v��)����T�[�r�X�v��쐬�敪�R�[�h1��1-������x�����Ə��쐬 2-���ȍ쐬
                if(!ACTextUtilities.isNullText(patientState.getNinteiDataLast(get_201005(),get_201006(),"PLANNER"))){
                    set_201019(ACCastUtilities.toInt(patientState.getNinteiDataLast(get_201005(),get_201006(),"PLANNER")));
                }
                //(����T�[�r�X�v��)���Ə��ԍ�10��(������x�����Ə�)
                set_201020(patientState.getNinteiDataLast(get_201005(),get_201006(),"PROVIDER_ID"));
            }
            
			//�ی����t��3��
			set_201029(type.get_701040());
			
			//����T�[�r�X�v��Ҏ��Ə���
			//set_201057(QP001Manager.getInstance().getProviderName(get_201004()));
			// edit sta 2006.5.17 fujihara.shin
			// �ꗥ���O�C�����Ə����\������Ă����B�v�掖�Ə��̖��̂�ݒ肷��悤�ύX
            //set_201057(manager.getProviderName(get_201004()));
			if(!ACTextUtilities.isNullText(get_201020()) && !"null".equalsIgnoreCase(get_201020())){
				set_201057(manager.getProviderName(get_201020()));
			}
            // edit end 2006.5.17 fujihara.shin
            

			//�叝�a��
			set_201061(patientState.getShisetsuData("DISEASE"));

		}
        
        //(���v��� �ی�)�T�[�r�X�P�ʐ�8��
        set_201033(get_201033() + type.get_701014());
        //(���v��� �ی�)�����z9��
        set_201034(get_201034() + type.get_701016());
        //(���v��� �ی�)���p�ҕ��S�z8��
        set_201035(get_201035() + type.get_701017());
        
        //(���v��� ����1)�T�[�r�X�P�ʐ�8��
        set_201039(get_201039() + type.get_701018());
        //(���v��� ����1)�����z8��
        set_201040(get_201040() + type.get_701019());
        //(���v��� ����1)�{�l���S�z8��
        set_201041(get_201041() + type.get_701020());
        
        //(���v��� ����2)�T�[�r�X�P�ʐ�8��
        set_201045(get_201045() + type.get_701021());
        //(���v��� ����2)�����z8��
        set_201046(get_201046() + type.get_701022());
        //(���v��� ����2)�{�l���S�z8��
        set_201047(get_201047() + type.get_701023());
        
        //(���v��� ����3)�T�[�r�X�P�ʐ�8��
        set_201051(get_201051() + type.get_701024());
        //(���v��� ����3)�����z8��
        set_201052(get_201052() + type.get_701025());
        //(���v��� ����3)�{�l���S�z8��
        set_201053(get_201053() + type.get_701026());
        
        
        //�l���̎�ʂɂ��A�ݒ肷��l��ύX����B
     if(QP001SpecialCase.isIncludingDiagnosis(get_201001())) {
            //�l����܁A��\�̏ꍇ�͓���f�Ô���Ƃ��Ĉ���
            //(���v��� �ی�)����f�Ô���z9��
            set_201037(get_201037() + type.get_701028());
            //(���v��� ����1)����f�Ô���z8��
            set_201043(get_201043() + type.get_701031());
            //(���v��� ����2)����f�Ô���z8��
            set_201049(get_201049() + type.get_701034());
            //(���v��� ����3)����f�Ô���z8��
            set_201055(get_201055() + type.get_701037());
            //(���v��� ����3)�{�l���S�z8��
        }
        
        
        //����g�p�̊m��
        //����P���g�p���Ă���Βl��ݒ肷��B
        if(get_201039() > 0){
            if(!ACTextUtilities.isNullText(kohiTypes[0])){
                //����1���t��
                set_201030(ACCastUtilities.toInt(patientState.getKohiData(kohiTypes[0],"BENEFIT_RATE",1),0));
                //����1 ������(KOHI_TYPE)
                set_201058(kohiTypes[0].getKohiType());
            }
        }
        //����Q���g�p���Ă���Βl��ݒ肷��B
        if(get_201045() > 0){
            if(!ACTextUtilities.isNullText(kohiTypes[1])){
                //����2���t��
                set_201031(ACCastUtilities.toInt(patientState.getKohiData(kohiTypes[1],"BENEFIT_RATE",1),0));
                //����2 ������(KOHI_TYPE)
                set_201059(kohiTypes[1].getKohiType());
            }
        }
        //����R���g�p���Ă���Βl��ݒ肷��B
        if(get_201051() > 0){
            if(!ACTextUtilities.isNullText(kohiTypes[2])){
                //����3���t��
                set_201032(ACCastUtilities.toInt(patientState.getKohiData(kohiTypes[2],"BENEFIT_RATE",1),0));
                //����3 ������(KOHI_TYPE)
                set_201060(kohiTypes[2].getKohiType());
            }
        }
        
        
        //�����P�W�N�S�����x�����ɂ����鐿�����׏��E���t�Ǘ��[�̋L�ڗ�ɂ���
        //�v���x���ύX����Ă���ꍇ�́A�ύX���̑O���i�V�X�e���I�ɂ͕ύX�O�̗v���x�̏I�����j
        //���I�����Ƃ��Đݒ肷��B
        setStopDate(patientState);
        
	}
    
    /**
     * ����f�Ô��񃌃R�[�h�̔�p��ݒ肷��B
     * @param diagnosis
     * @throws Exception
     */
    protected void parse(QP001RecordDiagnosis diagnosis,QP001PatientState patientState, QP001KohiKey[] kohiTypes) throws Exception {
        
        if(diagnosis == null) return;
        
        //����g�p�̊m��
        //����P���g�p���Ă���Βl��ݒ肷��B
        if((diagnosis.get_501016() > 0) && (get_201030() == 0)){
            if(!ACTextUtilities.isNullText(kohiTypes[0])){
                //����1���t��
                set_201030(ACCastUtilities.toInt(patientState.getKohiData(kohiTypes[0],"BENEFIT_RATE",1),0));
                //����1 ������(KOHI_TYPE)
                set_201058(kohiTypes[0].getKohiType());
            }
        }
        //����Q���g�p���Ă���Βl��ݒ肷��B
        if((diagnosis.get_501019() > 0) && (get_201031() == 0)){
            if(!ACTextUtilities.isNullText(kohiTypes[1])){
                //����2���t��
                set_201031(ACCastUtilities.toInt(patientState.getKohiData(kohiTypes[1],"BENEFIT_RATE",1),0));
                //����2 ������(KOHI_TYPE)
                set_201059(kohiTypes[1].getKohiType());
            }
        }
        //����R���g�p���Ă���Βl��ݒ肷��B
        if((diagnosis.get_501022() > 0) && (get_201032() == 0)){
            if(!ACTextUtilities.isNullText(kohiTypes[2])){
                //����3���t��
                set_201032(ACCastUtilities.toInt(patientState.getKohiData(kohiTypes[2],"BENEFIT_RATE",1),0));
                //����3 ������(KOHI_TYPE)
                set_201060(kohiTypes[2].getKohiType());
            }
        }
        
        //����f�Ô��񃌃R�[�h���g�p���������̊g���p
    }
    
    
    /**
     * �ً}����񃌃R�[�h�̔�p��ݒ肷��B
     * @param emergency
     * @throws Exception
     */
    protected void parse(QP001RecordEmergency emergency) throws Exception {
        
        if(emergency == null) return;
        //�ً}����񃌃R�[�h��ΏۂƂ��������̊g���p
        // add sta 2006.05.20 fujihara.shin
        // �ً}����񃌃R�[�h���󔒂̏ꍇ�A�l��ݒ肷�鏈����ǉ�
        // �������ʔԍ����󔒂̏ꍇ�A��{��񃌃R�[�h�̒l���R�s�[����
        if(ACTextUtilities.isNullText(emergency.get_401001())){
        	//�������ʔԍ�
        	emergency.set_401001(get_201001());
        	//�T�[�r�X�񋟔N��6��(YYYYMM)
        	emergency.set_401003(get_201003());
        	//���Ə��ԍ�
        	emergency.set_401004(get_201004());
        	//�؋L�ڕی��Ҕԍ�8��
        	emergency.set_401005(get_201005());
        	//��ی��Ҕԍ�10��
        	emergency.set_401006(get_201006());
        }
        // add end 2006.05.20 fujihara.shin
        
    }
    
    
    /**
     * �ً}����񃌃R�[�h�̔�p��ݒ肷��B
     * @param emergency
     * @throws Exception
     */
    protected void parse(QP001RecordEmergencyOwnFacility emergencyOwnFacility) throws Exception {
        
        if(emergencyOwnFacility == null) return;
        //�ً}����񃌃R�[�h��ΏۂƂ��������̊g���p
        // �ً}����񃌃R�[�h���󔒂̏ꍇ�A�l��ݒ肷�鏈����ǉ�
        // �������ʔԍ����󔒂̏ꍇ�A��{��񃌃R�[�h�̒l���R�s�[����
        if(ACTextUtilities.isNullText(emergencyOwnFacility.get_1701001())){
            //�������ʔԍ�
            emergencyOwnFacility.set_1701001(get_201001());
            //�T�[�r�X�񋟔N��6��(YYYYMM)
            emergencyOwnFacility.set_1701003(get_201003());
            //���Ə��ԍ�
            emergencyOwnFacility.set_1701004(get_201004());
            //�؋L�ڕی��Ҕԍ�8��
            emergencyOwnFacility.set_1701005(get_201005());
            //��ی��Ҕԍ�10��
            emergencyOwnFacility.set_1701006(get_201006());
        }
        
    }
    
    /**
     * ��������҂̔�p��ݒ肷��B
     * @param nursing
     * @throws Exception
     */
    protected void parse(QP001RecordNursing nursing,QP001PatientState patientState, QP001KohiKey[] kohiTypes) throws Exception {
        if(nursing == null) return;
        
        //(���v��� �ی�)��������҉��T�[�r�X������z8��
        set_201038(get_201038() + nursing.get_801023());
        
        //(���v��� ����1)��������҉��T�[�r�X������z8��
        if((nursing.get_801025()) > 0){
            set_201044(get_201044() + nursing.get_801026());
            if(get_201030() == 0){
                if(!ACTextUtilities.isNullText(kohiTypes[0])){
                    //����1���t��
                    set_201030(ACCastUtilities.toInt(patientState.getKohiData(kohiTypes[0],"BENEFIT_RATE",1),0));
                    //����1 ������(KOHI_TYPE)
                    set_201058(kohiTypes[0].getKohiType());
                }
            }
        }
        //(���v��� ����2)��������҉��T�[�r�X������z8��
        if(nursing.get_801028() > 0){
            set_201050(get_201050() + nursing.get_801029());
            if(get_201031() == 0){
                if(!ACTextUtilities.isNullText(kohiTypes[1])){
                    //����2���t��
                    set_201031(ACCastUtilities.toInt(patientState.getKohiData(kohiTypes[1],"BENEFIT_RATE",1),0));
                    //����2 ������(KOHI_TYPE)
                    set_201059(kohiTypes[1].getKohiType());
                }
            }
        }
        //(���v��� ����3)��������҉��T�[�r�X������z8��
        if(nursing.get_801031() > 0){
            set_201056(get_201056() + nursing.get_801032());
            if(get_201032() == 0){
                if(!ACTextUtilities.isNullText(kohiTypes[2])){
                    //����3���t��
                    set_201032(ACCastUtilities.toInt(patientState.getKohiData(kohiTypes[2],"BENEFIT_RATE",1),0));
                    //����3 ������(KOHI_TYPE)
                    set_201060(kohiTypes[2].getKohiType());
                }
            }
        }
        
        
    }
    
    /**
     * �����i���@�j������ݒ肷��B
     * @param patientState
     * @param type
     * @throws Exception
     */
	private void setHospitalization(QP001PatientState patientState,QP001RecordType type) throws Exception {
        
        /*
         * ���l����O�A��l�A��܁A��Z�̌܂̏ꍇ
         * ���\�h�Ή�
         * �l����Z�̘Z
         * �y�������z
         * �Ώی��̈�ԏ��߂Ɏ��т����͂���Ă�������������Ƃ���B
         * 
         * �y�ޏ����z
         * ��������������̎��т��r�؂ꂽ����ޏ����Ƃ���B
         * 
         * ���ٓ����͎Q�Ƃ����A���т݂̂Ŕ��肷��B
         */
	    if (QP001SpecialCase.isShortStay(type.get_701001())) {
            //�ٓ����R�͖�������B
            
            //���t�i�[�p
            int dayMap = 0;
            Date temp = null;
            boolean hit = false;
//            int days = 0;
            
            //���т̓��t�f�[�^��W�J
            for (int i = 0; i < type.getEntranceRealDays().size(); i++) {
                temp = (Date) type.getEntranceRealDays().get(i);
                dayMap = dayMap | (1 << (ACDateUtilities.getDayOfMonth(temp) - 1));
            }
            for(int i = 0; i < 31; i++){
                //�r�b�g�������Ă���
                if((dayMap & 1) == 1){
                    //���q�b�g�Ȃ�A�������Ƃ���B
                    if(!hit){
                        if(i < 9){
                            set_201024(type.get_701003() + "0" + (i + 1));
                        } else {
                            set_201024(type.get_701003() + (i + 1));
                        }
                        hit = true;
                    }
                    //�����������J�E���g
//                    days++;
                //�r�b�g�������Ă��Ȃ�
                } else {
                    //����hit���Ă���ΏI������
                    if(hit){
                        //�I������Ƃ����ޏ���
                        if(i < 10){
                            set_201025(type.get_701003() + "0" + i);
                        } else {
                            set_201025(type.get_701003() + i);
                        }
                        break;
                    }
                }
                //�r�b�g���E�ɃV�t�g
                dayMap = dayMap >>> 1;
            }
            //�������͎��тɓ\��t�������Ƃ���
            //set_201026(String.valueOf(days));
            //set_201026(String.valueOf(type.getEntranceRealDays().size()));
            //��{��񃌃R�[�h�̓�����������0�Ƃ���B
            set_201026("0");
            //�W�v��񃌃R�[�h�̒Z�������������ɐݒ肷��B
            type.set_701013(type.getEntranceRealDays().size());
            //�O��������0�Ƃ���
            set_201027("0");
        }
        /*
         * ���l����Z�Ƒ�Z�̎O�A�l��������\�̏ꍇ
         * �@���\�h�Ή�
         * �@�l����Z�̓�A�Z�̎l��ǉ�
         * �y�������z
         * �Ώی��̒��O�̓����N�������擾����B
         *  �擾�ł����ꍇ
         *      �擾�������t��������Ƃ���B
         *  �擾�ł��Ȃ������ꍇ
         *      �Ώی��̈�ԏ��߂Ɏ��т����͂���Ă������������Ƃ���B
         * 
         * �y�ޏ����z
         * �擾�����������ƌ����̊Ԃɂ���ޏ��̈ړ������擾����B
         *  �擾�ł����ꍇ
         *      �擾�������t��ޏ����Ƃ���B
         *  ���ޏ����������ȍ~�ɑ��݂���ꍇ�ɂ́A�ޏ�����ݒ肵�Ȃ��B
         *      ���A�����͓������Ƃ݂Ȃ�
         *      
         *  �ޏ��������݂��Ȃ��ꍇ
         *  �����т̏I�����ޏ���
         *  �����Ɏ��т����݂���ꍇ�́A�ޏ�����ݒ肵�Ȃ��B
         *  
         *  ���ޏ������擾�ł����ꍇ�ɂ́A�ޏ���̏���f������B
         */
        else if(QP001SpecialCase.isLongStay(type.get_701001())){
            //�����Ώی�
            Date nowDate = ACCastUtilities.toDate(type.get_701003() + "01");
            
            //������
            Date entryDate = null;
            //�ޏ���
            Date endDate = null;
            //���т̍ŏI��
            Date realEndDate = null;
            //���t�e���|�����̈�
            Date temp = null;
            //�ޏ����m��t���O
            boolean commitOut = false;
            
            //============�������m��X�^�[�g================
            //�ٓ����R�f�[�^�����������擾����B
            //[ID:0000750][Shin Fujihara] 2012/09 edit 2012�N�x�Ή� �ٓ���񂩂���E�މ@���̎擾���@�ύX
            //�啝�C���ׁ̈A�ߋ��R�����g���폜���C���@������CVS�Q��
            
            VRMap entry = patientState.getChangeDataAll(type.get_701044(), type.get_701003());
            VRMap in = (VRMap)entry.get("IN");
            VRMap out = (VRMap)entry.get("OUT");
            
            
            //���������擾�ł����ꍇ�A�����N�����Ɠ������R���m�肷��B
            if (in != null) {
            	entryDate = ACCastUtilities.toDate(in.get("CHANGES_DATE"),null);
                set_201023(ACCastUtilities.toInt(in.get("CHANGES_REASON"),0));
            }
            
            //�O����̓�������ݒ肷��B
            if ((entryDate == null)
            	&& ACTextUtilities.isNullText(patientState.getLastDataCategory2(type.get_701001(), "201025"))) {
            	Object _201024 = patientState.getLastDataCategory2(type.get_701001(), "201024");
            	if (!ACTextUtilities.isNullText(_201024)) {
            		entryDate = ACCastUtilities.toDate(_201024);
            	}
            }
            
            //���������Ȃ���΁A���т����ɍs��
            if (entryDate == null) {
                for (int i = 0; i < type.getEntranceRealDays().size(); i++) {
                    if (entryDate == null) {
                        entryDate = (Date) type.getEntranceRealDays().get(i);
                    }
                    if (ACDateUtilities.compareOnDay((Date) type.getEntranceRealDays().get(i), entryDate) < 0) {
                        entryDate = (Date) type.getEntranceRealDays().get(i);
                    }
                }
            }
            
            //��������ݒ肷��B
            if(entryDate != null){
                set_201024(VRDateParser.format(entryDate,"yyyyMMdd"));
            }
            //============�������m��G���h================
            
            //============�ޏ����m��X�^�[�g================
            //���т̍ŏI�����擾����B
            temp = null;
            //���т̓��t�f�[�^��W�J���A���т̓��͂���Ă���ŏI�����擾����B
            for (int i = 0; i < type.getEntranceRealDays().size(); i++) {
                temp = (Date) type.getEntranceRealDays().get(i);
                if(realEndDate == null){
                    realEndDate = temp;
                }
                if(ACDateUtilities.compareOnDay(realEndDate,temp) < 0){
                    realEndDate = temp;
                }
            }
            //�O���f�[�^���W�J
            for(int i = 0; i < type.getOutEntranceRealDays().size(); i++){
                temp = (Date) type.getOutEntranceRealDays().get(i);
                if(realEndDate == null){
                    realEndDate = temp;
                }
                if(ACDateUtilities.compareOnDay(realEndDate,temp) < 0){
                    realEndDate = temp;
                }
            }
            
            //�ޏ������擾�ł����ꍇ
            if(out != null){
                //�ޏ����Ƒޏ����R���m�肷��B
                temp = ACCastUtilities.toDate(out.get("CHANGES_DATE"),null);
                if(temp != null){
                    //�������ȍ~�ł��邱�Ƃ��m�F
                    if(ACDateUtilities.compareOnDay(entryDate,temp) < 0){
                        //�����ł��邱�Ƃ��m�F
                        if(ACDateUtilities.compareOnMonth(ACCastUtilities.toDate(type.get_701003() + "01"),temp) == 0){
                            //��U�A�ޏ������m��Ƃ���B(���т�����K�v�Ȃ�)
                            commitOut = true;
                            //�ݒ肳��Ă���ޏ��������т̍ŏI���ȍ~�ł��邱�Ƃ��m�F����B
                            if(ACDateUtilities.compareOnDay(realEndDate,temp) <= 0){
                                //�ޏ����Ƃ��Ċm�肷��B
                                endDate = temp;
                                set_201025(VRDateParser.format(endDate,"yyyyMMdd"));
                                //�ٓ����R��ݒ肷��B
                                set_201028(ACCastUtilities.toInt(out.get("CHANGES_REASON"),0));
                            } else{
                                //�ٓ����̑ޏ����ȍ~�Ɏ��т����݂���ꍇ�́A���т��̗p����
                                //���т��̗p���邽�߁A�t���O��߂�
                                commitOut = false;
                            }
                        }
                    }
                }
            }
            //�ޏ������m��̏ꍇ�́A���т̍ŏI����ޏ����Ƃ��č̗p����
            if(!commitOut && realEndDate != null){
                //���т̍ŏI���������łȂ���΁A�ޏ����Ƃ��Ċm�肷��B
                if(ACDateUtilities.getLastDayOfMonth(nowDate) != ACDateUtilities.getDayOfMonth(realEndDate)){
                    endDate = realEndDate;
                    set_201025(VRDateParser.format(endDate,"yyyyMMdd"));
                    
                 //���т̍ŏI���������ł���΁A�p�������Ƃ݂Ȃ��B
                } else {
                    endDate = null;
                }                
            }
            //============�ޏ����m��G���h================
            
            
            //�����i���@�j�������̐ݒ�
            int dateCount = 0;
            for (int i = 0; i < type.getEntranceRealDays().size(); i++) {
                //�������ȍ~�̓������т��J�E���g
                if(ACDateUtilities.compareOnDay(entryDate,(Date) type.getEntranceRealDays().get(i)) <= 0){
                    dateCount++;
                }
            }
            type.set_701013(dateCount);
            set_201026(String.valueOf(dateCount));
            
            
            //�O���̎��������p�~�@�O�����Z���Z�肳��Ă�����݂̂��O���Ƃ��Ĉ���
//            //null�`�F�b�N
//            if(entryDate != null){
//                //�������������ȑO�ł����
//                if(ACDateUtilities.compareOnMonth(entryDate,nowDate) < 0){
//                    if(endDate == null){
//                        set_201027(String.valueOf(ACDateUtilities.getLastDayOfMonth(nowDate) - dateCount));
//                    } else {
//                        set_201027(String.valueOf(ACDateUtilities.getDifferenceOnTotalDay(endDate,nowDate) - dateCount + 1));
//                    }
//                    
//                } else {
//                    //�O������2��
//                    if(endDate == null){
//                        set_201027(String.valueOf(ACDateUtilities.getLastDayOfMonth(entryDate) - ACDateUtilities.getDayOfMonth(entryDate) - dateCount + 1));
//                    } else {
//                        set_201027(String.valueOf(ACDateUtilities.getDifferenceOnTotalDay(endDate,entryDate) - dateCount + 1));
//                    }
//                }
//            } else {
//                //�O�������͐ݒ肳��Ă���l���Q�Ƃ���B
//                set_201027(String.valueOf(type.getOutEntranceRealDays().size()));
//            }
            
            //[CCCX:1456][Shinobu Hitaka] 2014/01/21 edit - begin GH�̊O�������擾�Ή�
            //GH�O���͉��Z���Ȃ��̂ŊO���������W�v����Ă��Ȃ�����
            //----- del - begin
            //�O�������͐ݒ肳��Ă���l���Q�Ƃ���B
            //set_201027(String.valueOf(type.getOutEntranceRealDays().size()));
            //----- del - end
            //----- add - begin
            //�l���Z�@�@�i32�F�F�m�ǑΉ��^�����������_�Z�����p�ȊO�j
            //�l���Z�̓�i37�F�F�m�ǑΉ��^�����������_�Z�����p�ȊO�j
            //�l���Z�̎O�i33�F����{�ݓ����Ґ������_�Z�����p�ȊO�C36�F�n�斧���^����{�ݓ����Ґ������_�Z�����p�ȊO�j
            //�l���Z�̎l�i35�F���\�h����{�ݓ����Ґ������j
            if (QP001StyleAbstract.IDENTIFICATION_NO_6_201204.equals(type.get_701001()) 
                    || QP001StyleAbstract.IDENTIFICATION_NO_6_2_201204.equals(type.get_701001())
                    || QP001StyleAbstract.IDENTIFICATION_NO_6_3_201204.equals(type.get_701001())
                    || QP001StyleAbstract.IDENTIFICATION_NO_6_4_201204.equals(type.get_701001())
                    ) {
                //null�`�F�b�N
                if(entryDate != null){
                    //�������������ȑO�ł����
                    if(ACDateUtilities.compareOnMonth(entryDate,nowDate) < 0){
                        if(endDate == null){
                            set_201027(String.valueOf(ACDateUtilities.getLastDayOfMonth(nowDate) - dateCount));
                        } else {
                            set_201027(String.valueOf(ACDateUtilities.getDifferenceOnTotalDay(endDate,nowDate) - dateCount + 1));
                        }
                    } else {
                        //�O������2��
                        if(endDate == null){
                            set_201027(String.valueOf(ACDateUtilities.getLastDayOfMonth(entryDate) - ACDateUtilities.getDayOfMonth(entryDate) - dateCount + 1));
                        } else {
                            set_201027(String.valueOf(ACDateUtilities.getDifferenceOnTotalDay(endDate,entryDate) - dateCount + 1));
                        }
                    }
                } else {
                    //�O�������͐ݒ肳��Ă���l���Q�Ƃ���B
                    set_201027(String.valueOf(type.getOutEntranceRealDays().size()));
                }
            } else {
                //�O�������͐ݒ肳��Ă���l���Q�Ƃ���B
                set_201027(String.valueOf(type.getOutEntranceRealDays().size()));
            }
            //----- add - end
            //[CCCX:1456][Shinobu Hitaka] 2014/01/21 edit - end GH�̊O�������擾�Ή��iGH�O���͉��Z���Ȃ��̂ŊO���������W�v����Ă��Ȃ������j
        }
    }
	
	/**
	 * ���~�N������ݒ肷��B
	 * @param patientState ���p�ҏ�ԃI�u�W�F�N�g
	 * @throws Exception
	 */
	private void setStopDate(QP001PatientState patientState) throws Exception {

		//[ID:0000539][Shin Fujihara] 2009/08 add begin 2009�N�x��Q�Ή�
		//�l�����A���̓�ȊO�̗l���ł���΁A�����𒆒f����
		if (!QP001StyleAbstract.IDENTIFICATION_NO_2_201204.equals(get_201001())
			&& !QP001StyleAbstract.IDENTIFICATION_NO_2_2_201204.equals(get_201001())) {
			return;
		}
		//[ID:0000539][Shin Fujihara] 2009/08 add end 2009�N�x��Q�Ή�
		
		/*
		 * ���ɒ��~�N�������ݒ肳��Ă���ꍇ�͏��������s���f����B
		 */
		if(!ACTextUtilities.isNullText(get_201022())){
			return;
		}
		
		/*
		 * �l�����A�l�����̓�̏ꍇ�ŁA�����܂�����Ȃ����[�̏ꍇ�̂�
		 * ���~�N�����̐ݒ���s���B
		 */
		
		//�l�����
		if(QP001StyleAbstract.IDENTIFICATION_NO_2_201204.equals(get_201001())){
			//�v����ԋ敪
			//�v�x���P�A�v�x���Q�ł͂Ȃ��ꍇ�͐���Ȓ��[�Ƃ݂Ȃ�
			if(!"12".equals(get_201015()) && !"13".equals(get_201015())){
				return;
			}
		}
		
		//�l�����̓�
		if(QP001StyleAbstract.IDENTIFICATION_NO_2_2_201204.equals(get_201001())){
			//�v����ԋ敪
			//�v�x���P�A�v�x���Q�̏ꍇ�͐���Ȓ��[�Ƃ݂Ȃ�
			if("12".equals(get_201015()) || "13".equals(get_201015())){
				return;
			}
		}
		
		Date startDate = ACCastUtilities.toDate(patientState.getNinteiDataLast(get_201005(),get_201006(),"INSURE_VALID_START"),null);
		
		if(startDate == null){
			return;
		}
		
		Date endDate = ACDateUtilities.setDayOfMonth(startDate,ACDateUtilities.getDayOfMonth(startDate) - 1);
		
		//�Z�o�������t�ƁA�F�藚����񂩂�擾�������t�̌������ƂȂ�΁A�ݒ���s��Ȃ�
		//(���͒l�̃G���[)
		if(ACDateUtilities.getMonth(startDate) != ACDateUtilities.getMonth(endDate)){
			return;
		}
		
		//���~�N����8��(YYYYMMDD)
		set_201022(VRDateParser.format(endDate,"yyyyMMdd"));
		//���~���R�R�[�h1��1-��Y�� 2-���{�� 3-��Ë@�֓��@ 4-���S 5-���̑�
		//�����~���R�R�[�h��5�Œ�
		set_201023(5);
		
	}
    
	/**
	 * �f�[�^�쐬
	 * @param style
	 * @return
	 */
	protected VRMap getRecord(VRMap style) throws Exception {
		VRMap result = copyStyle(style);
		
		//������񎯕ʔԍ�4��
		setData(result,"201001",get_201001());
		//���R�[�h��ʃR�[�h2��(01��ݒ�)
		setData(result,"201002",get_201002());
		//�T�[�r�X�񋟔N��6��(YYYYMM)
		setData(result,"201003",get_201003());
		//���Ə��ԍ�10��
		setData(result,"201004",get_201004());
		//�؋L�ڕی��Ҕԍ�8��
		setData(result,"201005",get_201005());
		//��ی��Ҕԍ�10��
		setData(result,"201006",get_201006());
		//(����1)���S�Ҕԍ�8��
		setData(result,"201007",get_201007());
		//(����1)�󋋎Ҕԍ�7��
		setData(result,"201008",get_201008());
		//(����2)���S�Ҕԍ�8��
		setData(result,"201009",get_201009());
		
		//(����2)�󋋎Ҕԍ�7��
		setData(result,"201010",get_201010());
		//(����3)���S�Ҕԍ�8��
		setData(result,"201011",get_201011());
		//(����3)�󋋎Ҕԍ�7��
		setData(result,"201012",get_201012());
		//(��ی��ҏ��)���N����8��YYYYMMDD
		setData(result,"201013",get_201013());
		//(��ی��ҏ��)���ʃR�[�h1��1-�j 2-��
		setData(result,"201014",get_201014());
		//(��ی��ҏ��)�v����ԋ敪�R�[�h2��01-��Y�� 11-�v�x�� 21-�v���1 22-�v���2 23-�v���3 24-�v���4 25-�v���5
		setData(result,"201015",get_201015());
		//(��ی��ҏ��)���[�u�����ғ���R�[�h1��1-�Ȃ� 2-����
		setData(result,"201016",get_201016());
		//(��ی��ҏ��)�F��L������ �J�n�N����8��(YYYYMMDD)
		setData(result,"201017",get_201017());
		//(��ی��ҏ��)�F��L������ �I���N����8��(YYYYMMDD)
		setData(result,"201018",get_201018());
		//(����T�[�r�X�v��)����T�[�r�X�v��쐬�敪�R�[�h1��1-������x�����Ə��쐬 2-���ȍ쐬
		setData(result,"201019",get_201019());
		
		//(����T�[�r�X�v��)���Ə��ԍ�10��(������x�����Ə�)
		setData(result,"201020",get_201020());
		//�J�n�N����8��(YYYYMMDD)
		setData(result,"201021",get_201021());
		//���~�N����8��(YYYYMMDD)
		setData(result,"201022",get_201022());
		//���~���R�R�[�h1��1-��Y�� 2-���{�� 3-��Ë@�֓��@ 4-���S 5-���̑�
		setData(result,"201023",get_201023());
		//����(�@)�N����8��(YYYYMMDD)
		setData(result,"201024",get_201024());
		//�ޏ�(�@)�N����8��(YYYYMMDD)
		setData(result,"201025",get_201025());
		//����(�@)������2��
		setData(result,"201026",get_201026());
		//�O������2��
		setData(result,"201027",get_201027());
		//�ޏ�(�@)��̏�ԃR�[�h1��1-���� 2-���{�� 3-��Ë@�֓��@ 4-���S 5-���̑�
		setData(result,"201028",get_201028());
		//�ی����t��3��
		setData(result,"201029",get_201029());
		
		//����1���t��
		setData(result,"201030",get_201030());
		//����2���t��
		setData(result,"201031",get_201031());
		//����3���t��
		setData(result,"201032",get_201032());
		//(���v��� �ی�)�T�[�r�X�P�ʐ�8��
		setData(result,"201033",get_201033());
		//(���v��� �ی�)�����z9��
		setData(result,"201034",get_201034());
		//(���v��� �ی�)���p�ҕ��S�z8��
		setData(result,"201035",get_201035());
		//(���v��� �ی�)�ً}���{�ݗ×{����z9��
		setData(result,"201036",get_201036());
		//(���v��� �ی�)����f�Ô���z9��
		setData(result,"201037",get_201037());
		//(���v��� �ی�)��������҉��T�[�r�X������z8��
		setData(result,"201038",get_201038());
		//(���v��� ����1)�T�[�r�X�P�ʐ�8��
		setData(result,"201039",get_201039());
		
		//(���v��� ����1)�����z8��
		setData(result,"201040",get_201040());
		//(���v��� ����1)�{�l���S�z8��
		setData(result,"201041",get_201041());
		//(���v��� ����1)�ً}���{�ݗ×{����z8��
		setData(result,"201042",get_201042());
		//(���v��� ����1)����f�Ô���z8��
		setData(result,"201043",get_201043());
		//(���v��� ����1)��������҉��T�[�r�X������z8��
		setData(result,"201044",get_201044());
		//(���v��� ����2)�T�[�r�X�P�ʐ�8��
		setData(result,"201045",get_201045());
		//(���v��� ����2)�����z8��
		setData(result,"201046",get_201046());
		//(���v��� ����2)�{�l���S�z8��
		setData(result,"201047",get_201047());
		//(���v��� ����2)�ً}���{�ݗ×{����z8��
		setData(result,"201048",get_201048());
		//(���v��� ����2)����f�Ô���z8��
		setData(result,"201049",get_201049());
		
		//(���v��� ����2)��������҉��T�[�r�X������z8��
		setData(result,"201050",get_201050());
		//(���v��� ����3)�T�[�r�X�P�ʐ�8��
		setData(result,"201051",get_201051());
		//(���v��� ����3)�����z8��
		setData(result,"201052",get_201052());
		//(���v��� ����3)�{�l���S�z8��
		setData(result,"201053",get_201053());
		//(���v��� ����3)�ً}���{�ݗ×{����z8��
		setData(result,"201054",get_201054());
		//(���v��� ����3)����f�Ô���z8��
		setData(result,"201055",get_201055());
		//(���v��� ����3)��������҉��T�[�r�X������z8��
		setData(result,"201056",get_201056());
		//����T�[�r�X�v��Ҏ��Ə���
		setData(result,"201057",get_201057());
		//����1 ������(KOHI_TYPE)
		setData(result,"201058",get_201058());
		//����2 ������(KOHI_TYPE)
		setData(result,"201059",get_201059());
		
		//����3 ������(KOHI_TYPE)
		setData(result,"201060",get_201060());
		//�叝�a��
		setData(result,"201061",get_201061());
		
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
		//��{��񃌃R�[�h
		result.put("CATEGORY_NO",QkanConstants.CATEGORY_NO_RECORD_BASIC_INFOMATION);
        
		return result;
	}
	
	public String toString(){
		StringBuilder result = new StringBuilder();
		result.append("[201001=" + get_201001() + "]\n");
		result.append("[201002=" + get_201002() + "]\n");
		result.append("[201003=" + get_201003() + "]\n");
		result.append("[201004=" + get_201004() + "]\n");
		result.append("[201005=" + get_201005() + "]\n");
		result.append("[201006=" + get_201006() + "]\n");
		result.append("[201007=" + get_201007() + "]\n");
		result.append("[201008=" + get_201008() + "]\n");
		result.append("[201009=" + get_201009() + "]\n");
		result.append("[201010=" + get_201010() + "]\n");
		result.append("[201011=" + get_201011() + "]\n");
		result.append("[201012=" + get_201012() + "]\n");
		result.append("[201013=" + get_201013() + "]\n");
		result.append("[201014=" + get_201014() + "]\n");
		result.append("[201015=" + get_201015() + "]\n");
		result.append("[201016=" + get_201016() + "]\n");
		result.append("[201017=" + get_201017() + "]\n");
		result.append("[201018=" + get_201018() + "]\n");
		result.append("[201019=" + get_201019() + "]\n");
		result.append("[201020=" + get_201020() + "]\n");
		result.append("[201021=" + get_201021() + "]\n");
		result.append("[201022=" + get_201022() + "]\n");
		result.append("[201023=" + get_201023() + "]\n");
		result.append("[201024=" + get_201024() + "]\n");
		result.append("[201025=" + get_201025() + "]\n");
		result.append("[201026=" + get_201026() + "]\n");
		result.append("[201027=" + get_201027() + "]\n");
		result.append("[201028=" + get_201028() + "]\n");
		result.append("[201029=" + get_201029() + "]\n");
		result.append("[201030=" + get_201030() + "]\n");
		result.append("[201031=" + get_201031() + "]\n");
		result.append("[201032=" + get_201032() + "]\n");
		result.append("[201033=" + get_201033() + "]\n");
		result.append("[201034=" + get_201034() + "]\n");
		result.append("[201035=" + get_201035() + "]\n");
		result.append("[201036=" + get_201036() + "]\n");
		result.append("[201037=" + get_201037() + "]\n");
		result.append("[201038=" + get_201038() + "]\n");
		result.append("[201039=" + get_201039() + "]\n");
		result.append("[201040=" + get_201040() + "]\n");
		result.append("[201041=" + get_201041() + "]\n");
		result.append("[201042=" + get_201042() + "]\n");
		result.append("[201043=" + get_201043() + "]\n");
		result.append("[201044=" + get_201044() + "]\n");
		result.append("[201045=" + get_201045() + "]\n");
		result.append("[201046=" + get_201046() + "]\n");
		result.append("[201047=" + get_201047() + "]\n");
		result.append("[201048=" + get_201048() + "]\n");
		result.append("[201049=" + get_201049() + "]\n");
		result.append("[201050=" + get_201050() + "]\n");
		result.append("[201051=" + get_201051() + "]\n");
		result.append("[201052=" + get_201052() + "]\n");
		result.append("[201053=" + get_201053() + "]\n");
		result.append("[201054=" + get_201054() + "]\n");
		result.append("[201055=" + get_201055() + "]\n");
		result.append("[201056=" + get_201056() + "]\n");
		result.append("[201057=" + get_201057() + "]\n");
		result.append("[201058=" + get_201058() + "]\n");
		result.append("[201059=" + get_201059() + "]\n");
		result.append("[201060=" + get_201060() + "]\n");
		result.append("[201061=" + get_201061() + "]\n");
		return result.toString();
	}
	
}
