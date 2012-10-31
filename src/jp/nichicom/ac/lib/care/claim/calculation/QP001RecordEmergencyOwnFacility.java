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
 * �쐬��: 2012/01/17  ���{�R���s���[�^�[������� �����@�L �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �������o�� (P)
 * �v���Z�X �������� (001)
 * �v���O���� �ً}���{�ݗ×{�E���莾���ݗ×{���񃌃R�[�h (QP001RecordEmergencyOwnFacility)
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
public class QP001RecordEmergencyOwnFacility extends QP001RecordAbstract {
    // ������񎯕ʔԍ�4��
    private String _1701001 = "";
    // ���R�[�h��ʃR�[�h2��
    private static final String _1701002 = "13";
    // �T�[�r�X�񋟔N��6��(YYYYMM)
    private String _1701003 = "";
    // ���Ə��ԍ�10��
    private String _1701004 = "";
    // �؋L�ڕی��Ҕԍ�8��
    private String _1701005 = "";
    // ��ی��Ҕԍ�10��
    private String _1701006 = "";
    // �ً}���{�ݗ×{��񃌃R�[�h�����ԍ�2��
    private int _1701007 = 0;
    // �ً}�����a��1 40��
    private String _1701008 = "";
    // �ً}�����a��2 40��
    private String _1701009 = "";
    // �ً}�����a��3 40��
    private String _1701010 = "";
    // �ً}�����ÊJ�n�N����1 8��(YYYYMMDD)
    private String _1701011 = "";
    // �ً}�����ÊJ�n�N����2 8��(YYYYMMDD)
    private String _1701012 = "";
    // �ً}�����ÊJ�n�N����3 8��(YYYYMMDD)
    private String _1701013 = "";
    // ���f����2��
    private int _1701014 = 0;
    // ���f��Ë@�֖�40��
    private String _1701015 = "";
    // �ʉ@����2��
    private int _1701016 = 0;
    // �ʉ@��Ë@�֖�40��
    private String _1701017 = "";
    // �ً}�����ÊǗ��P�ʐ�6��
    private int _1701018 = 0;
    // �ً}�����ÊǗ�����2��
    private int _1701019 = 0;
    // �ً}�����ÊǗ����v7��
    private int _1701020 = 0;
    // ���n�r���e�[�V�����_��7��
    private int _1701021 = 0;
    // ���u�_��7��
    private int _1701022 = 0;
    // ��p�_��7��
    private int _1701023 = 0;
    // �����_��7��
    private int _1701024 = 0;
    // ���ː����Ó_��7��
    private int _1701025 = 0;
    // �E�v1 64��
    private String _1701026 = "";
    // �E�v2 64��
    private String _1701027 = "";
    // �E�v3 64��
    private String _1701028 = "";
    // �E�v4 64��
    private String _1701029 = "";
    // �E�v5 64��
    private String _1701030 = "";
    // �E�v6 64��
    private String _1701031 = "";
    // �E�v7 64��
    private String _1701032 = "";
    // �E�v8 64��
    private String _1701033 = "";
    // �E�v9 64��
    private String _1701034 = "";
    // �E�v10 64��
    private String _1701035 = "";
    // �E�v11 64��
    private String _1701036 = "";
    // �E�v12 64��
    private String _1701037 = "";
    // �E�v13 64��
    private String _1701038 = "";
    // �E�v14 64��
    private String _1701039 = "";
    // �E�v15 64��
    private String _1701040 = "";
    // �E�v16 64��
    private String _1701041 = "";
    // �E�v17 64��
    private String _1701042 = "";
    // �E�v18 64��
    private String _1701043 = "";
    // �E�v19 64��
    private String _1701044 = "";
    // �E�v20 64��
    private String _1701045 = "";
    // �ً}���{�ݗ×{��v�_��8��
    private int _1701046 = 0;

    // ���莾���ݗ×{��a��1 40��
    private String _1701047 = "";
    // ���莾���ݗ×{��a��2 40��
    private String _1701048 = "";
    // ���莾���ݗ×{��a��3 40��
    private String _1701049 = "";
    // ���莾���ݗ×{��J�n�N����1 8��(YYYYMMDD)
    private String _1701050 = "";
    // ���莾���ݗ×{��J�n�N����2 8��(YYYYMMDD)
    private String _1701051 = "";
    // ���莾���ݗ×{��J�n�N����3 8��(YYYYMMDD)
    private String _1701052 = "";
    // ���莾���ݗ×{��P�ʐ�6��
    private int _1701053 = 0;
    // ���莾���ݗ×{�����2��
    private int _1701054 = 0;
    // ���莾���ݗ×{��v7��
    private int _1701055 = 0;

    protected String getSerialId() {
        return null;
    }

    /**  @return ���R�[�h��ʃR�[�h2�� */
    protected static String get_1701002() {
        return _1701002;
    }

    /**  @return ������񎯕ʔԍ�4�� */
    protected String get_1701001() {
        return _1701001;
    }
    /**  @param _1701001 ������񎯕ʔԍ�4�� */
    protected void set_1701001(String _1701001) {
        this._1701001 = _1701001;
    }
    /** @return �T�[�r�X�񋟔N��6��(YYYYMM) */
    protected String get_1701003() {
        return _1701003;
    }
    /** @param _1701003 �T�[�r�X�񋟔N��6��(YYYYMM) */
    protected void set_1701003(String _1701003) {
        this._1701003 = _1701003;
    }
    /** @return ���Ə��ԍ�10�� */
    protected String get_1701004() {
        return _1701004;
    }
    /** @param _1701004 ���Ə��ԍ�10�� */
    protected void set_1701004(String _1701004) {
        this._1701004 = _1701004;
    }
    /** @return �؋L�ڕی��Ҕԍ�8�� */
    protected String get_1701005() {
        return _1701005;
    }
    /** @param _1701005 �؋L�ڕی��Ҕԍ�8�� */
    protected void set_1701005(String _1701005) {
        this._1701005 = _1701005;
    }
    /** @return ��ی��Ҕԍ�10�� */
    protected String get_1701006() {
        return _1701006;
    }
    /** @param _1701006 ��ی��Ҕԍ�10�� */
    protected void set_1701006(String _1701006) {
        this._1701006 = _1701006;
    }
    /** @return �ً}���{�ݗ×{��񃌃R�[�h�����ԍ�2�� */
    protected int get_1701007() {
        return _1701007;
    }
    /** @param _1701007 �ً}���{�ݗ×{��񃌃R�[�h�����ԍ�2�� */
    protected void set_1701007(int _1701007) {
        this._1701007 = _1701007;
    }
    /** @return �ً}�����a��1 40�� */
    protected String get_1701008() {
        return _1701008;
    }
    /** @param _1701008 �ً}�����a��1 40�� */
    protected void set_1701008(String _1701008) {
        this._1701008 = _1701008;
    }
    /** @return �ً}�����a��2 40�� */
    protected String get_1701009() {
        return _1701009;
    }
    /** @param _1701009 �ً}�����a��2 40�� */
    protected void set_1701009(String _1701009) {
        this._1701009 = _1701009;
    }
    /** @return �ً}�����a��3 40�� */
    protected String get_1701010() {
        return _1701010;
    }
    /** @param _1701010 �ً}�����a��3 40�� */
    protected void set_1701010(String _1701010) {
        this._1701010 = _1701010;
    }
    /** @return �ً}�����ÊJ�n�N����1 8��(YYYYMMDD) */
    protected String get_1701011() {
        return _1701011;
    }
    /** @param _1701011 �ً}�����ÊJ�n�N����1 8��(YYYYMMDD) */
    protected void set_1701011(String _1701011) {
        this._1701011 = _1701011;
    }
    /** @return  �ً}�����ÊJ�n�N����2 8��(YYYYMMDD) */
    protected String get_1701012() {
        return _1701012;
    }
    /** @param _1701012 �ً}�����ÊJ�n�N����2 8��(YYYYMMDD) */
    protected void set_1701012(String _1701012) {
        this._1701012 = _1701012;
    }
    /** @return �ً}�����ÊJ�n�N����3 8��(YYYYMMDD) */
    protected String get_1701013() {
        return _1701013;
    }
    /** @param _1701013 �ً}�����ÊJ�n�N����3 8��(YYYYMMDD) */
    protected void set_1701013(String _1701013) {
        this._1701013 = _1701013;
    }
    /** @return ���f����2�� */
    protected int get_1701014() {
        return _1701014;
    }
    /** @param _1701014 ���f����2�� */
    protected void set_1701014(int _1701014) {
        this._1701014 = _1701014;
    }
    /** @return ���f��Ë@�֖�40�� */
    protected String get_1701015() {
        return _1701015;
    }
    /** @param _1701015 ���f��Ë@�֖�40�� */
    protected void set_1701015(String _1701015) {
        this._1701015 = _1701015;
    }
    /** @return �ʉ@����2�� */
    protected int get_1701016() {
        return _1701016;
    }
    /** @param _1701016 �ʉ@����2�� */
    protected void set_1701016(int _1701016) {
        this._1701016 = _1701016;
    }
    /** @return �ʉ@��Ë@�֖�40�� */
    protected String get_1701017() {
        return _1701017;
    }
    /** @param _1701017 �ʉ@��Ë@�֖�40�� */
    protected void set_1701017(String _1701017) {
        this._1701017 = _1701017;
    }
    /** @return �ً}�����ÊǗ��P�ʐ�6�� */
    protected int get_1701018() {
        return _1701018;
    }
    /** @param _1701018 �ً}�����ÊǗ��P�ʐ�6�� */
    protected void set_1701018(int _1701018) {
        this._1701018 = _1701018;
    }
    /** @return �ً}�����ÊǗ�����2�� */
    protected int get_1701019() {
        return _1701019;
    }
    /** @param _1701019 �ً}�����ÊǗ�����2�� */
    protected void set_1701019(int _1701019) {
        this._1701019 = _1701019;
    }
    /** @return �ً}�����ÊǗ����v7�� */
    protected int get_1701020() {
        return _1701020;
    }
    /** @param _1701020 �ً}�����ÊǗ����v7�� */
    protected void set_1701020(int _1701020) {
        this._1701020 = _1701020;
    }
    /** @return ���n�r���e�[�V�����_��7�� */
    protected int get_1701021() {
        return _1701021;
    }
    /** @param _1701021 ���n�r���e�[�V�����_��7�� */
    protected void set_1701021(int _1701021) {
        this._1701021 = _1701021;
    }
    /** @return ���u�_��7�� */
    protected int get_1701022() {
        return _1701022;
    }
    /** @param _1701022 ���u�_��7�� */
    protected void set_1701022(int _1701022) {
        this._1701022 = _1701022;
    }
    /** @return ��p�_��7�� */
    protected int get_1701023() {
        return _1701023;
    }
    /** @param _1701023 ��p�_��7�� */
    protected void set_1701023(int _1701023) {
        this._1701023 = _1701023;
    }
    /** @return �����_��7�� */
    protected int get_1701024() {
        return _1701024;
    }
    /** @param _1701024 �����_��7�� */
    protected void set_1701024(int _1701024) {
        this._1701024 = _1701024;
    }
    /** @return ���ː����Ó_��7�� */
    protected int get_1701025() {
        return _1701025;
    }
    /** @param _1701025 ���ː����Ó_��7�� */
    protected void set_1701025(int _1701025) {
        this._1701025 = _1701025;
    }
    /** @return �E�v1 64�� */
    protected String get_1701026() {
        return _1701026;
    }
    /** @param _1701026 �E�v1 64�� */
    protected void set_1701026(String _1701026) {
        this._1701026 = _1701026;
    }
    /** @return �E�v2 64�� */
    protected String get_1701027() {
        return _1701027;
    }
    /** @param _1701027 �E�v2 64�� */
    protected void set_1701027(String _1701027) {
        this._1701027 = _1701027;
    }
    /** @return �E�v3 64�� */
    protected String get_1701028() {
        return _1701028;
    }
    /** @param _1701028 �E�v3 64 */
    protected void set_1701028(String _1701028) {
        this._1701028 = _1701028;
    }
    /** @return �E�v4 64�� */
    protected String get_1701029() {
        return _1701029;
    }
    /** @param _1701029 �E�v4 64�� */
    protected void set_1701029(String _1701029) {
        this._1701029 = _1701029;
    }
    /** @return �E�v5 64�� */
    protected String get_1701030() {
        return _1701030;
    }
    /** @param _1701030 �E�v5 64�� */
    protected void set_1701030(String _1701030) {
        this._1701030 = _1701030;
    }
    /** @return �E�v6 64�� */
    protected String get_1701031() {
        return _1701031;
    }
    /** @param _1701031 �E�v6 64�� */
    protected void set_1701031(String _1701031) {
        this._1701031 = _1701031;
    }
    /** @return �E�v7 64�� */
    protected String get_1701032() {
        return _1701032;
    }
    /** @param _1701032 �E�v7 64�� */
    protected void set_1701032(String _1701032) {
        this._1701032 = _1701032;
    }
    /** @return �E�v8 64�� */
    protected String get_1701033() {
        return _1701033;
    }
    /** @param _1701033 �E�v8 64�� */
    protected void set_1701033(String _1701033) {
        this._1701033 = _1701033;
    }
    /** @return �E�v9 64�� */
    protected String get_1701034() {
        return _1701034;
    }
    /** @param _1701034 �E�v9 64�� */
    protected void set_1701034(String _1701034) {
        this._1701034 = _1701034;
    }
    /** @return �E�v10 64�� */
    protected String get_1701035() {
        return _1701035;
    }
    /** @param _1701035 �E�v10 64��*/
    protected void set_1701035(String _1701035) {
        this._1701035 = _1701035;
    }
    /** @return �E�v11 64�� */
    protected String get_1701036() {
        return _1701036;
    }
    /** @param _1701036 �E�v11 64�� */
    protected void set_1701036(String _1701036) {
        this._1701036 = _1701036;
    }
    /** @return �E�v12 64�� */
    protected String get_1701037() {
        return _1701037;
    }
    /** @param _1701037 �E�v12 64�� */
    protected void set_1701037(String _1701037) {
        this._1701037 = _1701037;
    }
    /** @return �E�v13 64�� */
    protected String get_1701038() {
        return _1701038;
    }
    /** @param _1701038 �E�v13 64�� */
    protected void set_1701038(String _1701038) {
        this._1701038 = _1701038;
    }
    /** @return �E�v14 64�� */
    protected String get_1701039() {
        return _1701039;
    }
    /** @param _1701039 �E�v14 64�� */
    protected void set_1701039(String _1701039) {
        this._1701039 = _1701039;
    }
    /** @return �E�v15 64�� */
    protected String get_1701040() {
        return _1701040;
    }
    /** @param _1701040 �E�v15 64�� */
    protected void set_1701040(String _1701040) {
        this._1701040 = _1701040;
    }
    /** @return �E�v16 64�� */
    protected String get_1701041() {
        return _1701041;
    }
    /** @param _1701041 �E�v16 64�� */
    protected void set_1701041(String _1701041) {
        this._1701041 = _1701041;
    }
    /** @return �E�v17 64�� */
    protected String get_1701042() {
        return _1701042;
    }
    /** @param _1701042 �E�v17 64�� */
    protected void set_1701042(String _1701042) {
        this._1701042 = _1701042;
    }
    /** @return �E�v18 64�� */
    protected String get_1701043() {
        return _1701043;
    }
    /** @param _1701043 �E�v18 64�� */
    protected void set_1701043(String _1701043) {
        this._1701043 = _1701043;
    }
    /** @return �E�v19 64�� */
    protected String get_1701044() {
        return _1701044;
    }
    /** @param _1701044 �E�v19 64�� */
    protected void set_1701044(String _1701044) {
        this._1701044 = _1701044;
    }
    /** @return �E�v20 64�� */
    protected String get_1701045() {
        return _1701045;
    }
    /** @param _1701045 �E�v20 64�� */
    protected void set_1701045(String _1701045) {
        this._1701045 = _1701045;
    }
    /** @return �ً}���{�ݗ×{��v�_��8�� */
    protected int get_1701046() {
        return _1701046;
    }
    /** @param _1701046 �ً}���{�ݗ×{��v�_��8�� */
    protected void set_1701046(int _1701046) {
        this._1701046 = _1701046;
    }
    /** @return ���莾���ݗ×{��a��1 40�� */
    protected String get_1701047() {
        return _1701047;
    }
    /** @param _1701047 ���莾���ݗ×{��a��1 40�� */
    protected void set__1701047(String _1701047) {
        this._1701047 = _1701047;
    }
    /** @return ���莾���ݗ×{��a��2 40�� */
    protected String get_1701048() {
        return _1701048;
    }
    /** @param _1701048 ���莾���ݗ×{��a��2 40�� */
    protected void set_1701048(String _1701048) {
        this._1701048 = _1701048;
    }
    /**  @return ���莾���ݗ×{��a��3 40�� */
    protected String get_1701049() {
        return _1701049;
    }
    /** @param _1701049 ���莾���ݗ×{��a��3 40�� */
    protected void set_1701049(String _1701049) {
        this._1701049 = _1701049;
    }
    /** @return ���莾���ݗ×{��J�n�N����1 8��(YYYYMMDD) */
    protected String get_1701050() {
        return _1701050;
    }
    /** @param _1701050 ���莾���ݗ×{��J�n�N����1 8��(YYYYMMDD) */
    protected void set_1701050(String _1701050) {
        this._1701050 = _1701050;
    }
    /** @return ���莾���ݗ×{��J�n�N����2 8��(YYYYMMDD) */
    protected String get_1701051() {
        return _1701051;
    }
    /** @param _1701051 ���莾���ݗ×{��J�n�N����2 8��(YYYYMMDD) */
    protected void set_1701051(String _1701051) {
        this._1701051 = _1701051;
    }
    /** @return ���莾���ݗ×{��J�n�N����3 8��(YYYYMMDD) */
    protected String get_1701052() {
        return _1701052;
    }
    /** @param _1701052���莾���ݗ×{��J�n�N����3 8��(YYYYMMDD) */
    protected void set_1701052(String _1701052) {
        this._1701052 = _1701052;
    }
    /** @return ���莾���ݗ×{��P�ʐ�6�� */
    protected int get_1701053() {
        return _1701053;
    }
    /** @param _1701053 ���莾���ݗ×{��P�ʐ�6�� */
    protected void set_1701053(int _1701053) {
        this._1701053 = _1701053;
    }
    /** @return ���莾���ݗ×{�����2�� */
    protected int get_1701054() {
        return _1701054;
    }
    /** @param _1701054 ���莾���ݗ×{�����2�� */
    protected void set_1701054(int _1701054) {
        this._1701054 = _1701054;
    }
    /** @return ���莾���ݗ×{��v7�� */
    protected int get_1701055() {
        return _1701055;
    }
    /** @param _1701055 ���莾���ݗ×{��v7�� */
    protected void set_1701055(int _1701055) {
        this._1701055 = _1701055;
    }

    /**
     * ���ɏ�񂪓o�^����Ă��邩�ԋp���܂��B
     * @return �V�K:true �ǉ�:false
     */
    private boolean isNew() {
        // ������񃌃R�[�h�ɓo�^��������ΐV�K�Ƃ݂Ȃ��B
        return ((get_1701001() == null) || ("".equals(get_1701001())));
    }
    
    // �ً}���p�^�[��
    private static final int TYPE_EMERGENCY = 1;
    // ���莾���p�^�[��
    private static final int TYPE_PRESCRIBED = 2;

    /**
     * �f�[�^�̃p�[�X�����s���܂��B
     * 
     * @param serviceDetail
     * @param targetDate
     * @param patientState
     * @param serviceCode
     * @throws Exception
     */
    protected void parse(VRMap serviceDetail, Date targetDate,
            QP001PatientState patientState, VRMap serviceCode,
            String identificationNo, QP001Manager manager) throws Exception {
        
        
        int mode = 0;
        
        String systemServiceCode = String.valueOf(serviceCode.get("SYSTEM_SERVICE_CODE_ITEM"));
        // �ی��{�݋ً}�����ÊǗ��P�A�ی��{�݋ً}�����ÊǗ��Q�̏ꍇ�ً͋}�����ÊǗ�
        if("Z9000".equals(systemServiceCode)|| "Z6000".equals(systemServiceCode)){
            mode = TYPE_EMERGENCY;
            
        // �ی��{�ݏ��莾���{�ݗ×{��P�A�ی��{�ݏ��莾���{�ݗ×{��Q�̏ꍇ�͏��莾��
        } else if ("Z9100".equals(systemServiceCode)|| "Z6100".equals(systemServiceCode)) {
            mode = TYPE_PRESCRIBED;
            
        // ��L���Z�ȊO�̏ꍇ
        } else {
            return;
        }

        Object targetServiceDate = VRBindPathParser.get("SERVICE_DATE",
                serviceDetail);
        if (isNew()) {
            // type �� KEY : 401001(������񎯕ʔԍ�4��) �� VALUE : ��U������ݒ肷��B
            set_1701001(identificationNo);

            // type �� KEY : 401003(�T�[�r�X�񋟔N��) ��
            // VALUE : yyyyMM�`���Ƀt�H�[�}�b�g����targetDate��ݒ肷��B
            set_1701003(VRDateParser.format(targetDate, "yyyyMM"));

            // type �� KEY : 401004(���Ə��ԍ�) ��
            // VALUE : 10���t�H�[�}�b�g�������Ə��ԍ�(serviceDetail���擾)��ݒ肷��B
            set_1701004(ACCastUtilities.toString(VRBindPathParser.get(
                    "PROVIDER_ID", serviceDetail)));

            // type �� KEY : 401005(�؋L�ڕی��Ҕԍ�) ��
            // VALUE : 8���t�H�[�}�b�g�������p�҂̕ی��Ҕԍ�(patient���擾)��ݒ肷��B
            set_1701005(patientState.getInsurerId(targetServiceDate));

            // type �� KEY : 401006(��ی��Ҕԍ�) ��
            // VALUE : 10���t�H�[�}�b�g�������p�҂̔�ی��Ҕԍ�(patient���擾)��ݒ肷��B
            set_1701006(patientState.getInsuredId(targetServiceDate));
            // ���R�[�h�����ԍ�
            set_1701007(99);
            
            
            if (mode == TYPE_EMERGENCY) {
                // �ً}���ÊǗ��P�ʐ�
                set_1701018(manager.getServiceUnit(get_1701004(), serviceCode));
                // �ً}�����ÊǗ�����
                set_1701019(1);
                
            } else if (mode == TYPE_PRESCRIBED) {
                //���莾���ݗ×{��P�ʐ�
                set_1701053(manager.getServiceUnit(get_1701004(), serviceCode));
                //���莾���ݗ×{�����
                set_1701054(1);
            }

        } else {
            if (mode == TYPE_EMERGENCY) {
                // �ً}���̒P�ʐ��������Ă��Ȃ��ꍇ�͐ݒ肷�� 
                if (get_1701019() == 0) {
                    // �ً}���ÊǗ��P�ʐ�
                    set_1701018(manager.getServiceUnit(get_1701004(), serviceCode));
                }
                // �ً}�����ÊǗ������ɂP��������B
                set_1701019(get_1701019() + 1);
                
            } else if (mode == TYPE_PRESCRIBED) {
                //���莾���̒P�ʐ��������Ă��Ȃ��ꍇ�͐ݒ肷��
                if (get_1701053() == 0) {
                    //���莾���ݗ×{��P�ʐ�
                    set_1701053(manager.getServiceUnit(get_1701004(), serviceCode));
                }
                //���莾���ݗ×{�����
                set_1701054(get_1701054() + 1);
                
            }
        }

    }

    /**
     * ���R�[�h���e�̊m����s���B
     */
    protected void commitRecord() throws Exception {
        set_1701007(99);
        // �ً}���̍��v���Z�o����B
        set_1701020(get_1701018() * get_1701019());
        
        // ���莾���̍��v���z���Z�o����
        set_1701055(get_1701053() * get_1701054());
        
        // �����v���Z�o����B
        // 1701020�͍Čf�Ȃ̂ō��v�Ɋ܂߂Ă͂����Ȃ��B
        set_1701046(get_1701021() + get_1701022() + get_1701023()
                + get_1701024() + get_1701025());

    }

    /**
     * �f�[�^�쐬
     * 
     * @param style
     * @return
     */
    protected VRMap getRecord(VRMap style) throws Exception {
        VRMap result = copyStyle(style);

        setData(result, "1701001", get_1701001());
        setData(result, "1701002", get_1701002());
        setData(result, "1701003", get_1701003());
        setData(result, "1701004", get_1701004());
        setData(result, "1701005", get_1701005());
        setData(result, "1701006", get_1701006());
        setData(result, "1701007", get_1701007());
        setData(result, "1701008", get_1701008());
        setData(result, "1701009", get_1701009());

        setData(result, "1701010", get_1701010());
        setData(result, "1701011", get_1701011());
        setData(result, "1701012", get_1701012());
        setData(result, "1701013", get_1701013());
        setData(result, "1701014", get_1701014());
        setData(result, "1701015", get_1701015());
        setData(result, "1701016", get_1701016());
        setData(result, "1701017", get_1701017());
        setData(result, "1701018", get_1701018());
        setData(result, "1701019", get_1701019());

        setData(result, "1701020", get_1701020());
        setData(result, "1701021", get_1701021());
        setData(result, "1701022", get_1701022());
        setData(result, "1701023", get_1701023());
        setData(result, "1701024", get_1701024());
        setData(result, "1701025", get_1701025());
        setData(result, "1701026", get_1701026());
        setData(result, "1701027", get_1701027());
        setData(result, "1701028", get_1701028());
        setData(result, "1701029", get_1701029());

        setData(result, "1701030", get_1701030());
        setData(result, "1701031", get_1701031());
        setData(result, "1701032", get_1701032());
        setData(result, "1701033", get_1701033());
        setData(result, "1701034", get_1701034());
        setData(result, "1701035", get_1701035());
        setData(result, "1701036", get_1701036());
        setData(result, "1701037", get_1701037());
        setData(result, "1701038", get_1701038());
        setData(result, "1701039", get_1701039());

        setData(result, "1701040", get_1701040());
        setData(result, "1701041", get_1701041());
        setData(result, "1701042", get_1701042());
        setData(result, "1701043", get_1701043());
        setData(result, "1701044", get_1701044());
        setData(result, "1701045", get_1701045());
        setData(result, "1701046", get_1701046());
        setData(result, "1701047", get_1701047());
        setData(result, "1701048", get_1701048());
        setData(result, "1701049", get_1701049());
        
        setData(result, "1701050", get_1701050());
        setData(result, "1701051", get_1701051());
        setData(result, "1701052", get_1701052());
        setData(result, "1701053", get_1701053());
        setData(result, "1701054", get_1701054());
        setData(result, "1701055", get_1701055());

        return result;
    }

    private VRMap copyStyle(VRMap style) {
        VRMap result = new VRHashMap();
        Object key;
        // �f�B�[�v�R�s�[
        Iterator it = style.keySet().iterator();
        while (it.hasNext()) {
            key = it.next();
            result.put(key, style.get(key));
        }
        // �ً}���{�ݗ×{�E���莾���ݗ×{���񃌃R�[�h
        result.put("CATEGORY_NO", QkanConstants.CATEGORY_NO_RECORD_EMERGENCY_OWN_FACILITY_INSTITUTION);
        
        return result;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("[1701001=" + get_1701001() + "]\n");
        result.append("[1701002=" + get_1701002() + "]\n");
        result.append("[1701003=" + get_1701003() + "]\n");
        result.append("[1701004=" + get_1701004() + "]\n");
        result.append("[1701005=" + get_1701005() + "]\n");
        result.append("[1701006=" + get_1701006() + "]\n");
        result.append("[1701007=" + get_1701007() + "]\n");
        result.append("[1701008=" + get_1701008() + "]\n");
        result.append("[1701009=" + get_1701009() + "]\n");

        result.append("[1701010=" + get_1701010() + "]\n");
        result.append("[1701011=" + get_1701011() + "]\n");
        result.append("[1701012=" + get_1701012() + "]\n");
        result.append("[1701013=" + get_1701013() + "]\n");
        result.append("[1701014=" + get_1701014() + "]\n");
        result.append("[1701015=" + get_1701015() + "]\n");
        result.append("[1701016=" + get_1701016() + "]\n");
        result.append("[1701017=" + get_1701017() + "]\n");
        result.append("[1701018=" + get_1701018() + "]\n");
        result.append("[1701019=" + get_1701019() + "]\n");

        result.append("[1701020=" + get_1701020() + "]\n");
        result.append("[1701021=" + get_1701021() + "]\n");
        result.append("[1701022=" + get_1701022() + "]\n");
        result.append("[1701023=" + get_1701023() + "]\n");
        result.append("[1701024=" + get_1701024() + "]\n");
        result.append("[1701025=" + get_1701025() + "]\n");
        result.append("[1701026=" + get_1701026() + "]\n");
        result.append("[1701027=" + get_1701027() + "]\n");
        result.append("[1701028=" + get_1701028() + "]\n");
        result.append("[1701029=" + get_1701029() + "]\n");

        result.append("[1701030=" + get_1701030() + "]\n");
        result.append("[1701031=" + get_1701031() + "]\n");
        result.append("[1701032=" + get_1701032() + "]\n");
        result.append("[1701033=" + get_1701033() + "]\n");
        result.append("[1701034=" + get_1701034() + "]\n");
        result.append("[1701035=" + get_1701035() + "]\n");
        result.append("[1701036=" + get_1701036() + "]\n");
        result.append("[1701037=" + get_1701037() + "]\n");
        result.append("[1701038=" + get_1701038() + "]\n");
        result.append("[1701039=" + get_1701039() + "]\n");

        result.append("[1701040=" + get_1701040() + "]\n");
        result.append("[1701041=" + get_1701041() + "]\n");
        result.append("[1701042=" + get_1701042() + "]\n");
        result.append("[1701043=" + get_1701043() + "]\n");
        result.append("[1701044=" + get_1701044() + "]\n");
        result.append("[1701045=" + get_1701045() + "]\n");
        result.append("[1701046=" + get_1701046() + "]\n");
        result.append("[1701047=" + get_1701047() + "]\n");
        result.append("[1701048=" + get_1701048() + "]\n");
        result.append("[1701049=" + get_1701049() + "]\n");
        
        result.append("[1701050=" + get_1701050() + "]\n");
        result.append("[1701051=" + get_1701051() + "]\n");
        result.append("[1701052=" + get_1701052() + "]\n");
        result.append("[1701053=" + get_1701053() + "]\n");
        result.append("[1701054=" + get_1701054() + "]\n");
        result.append("[1701055=" + get_1701055() + "]\n");

        return result.toString();

    }
}
