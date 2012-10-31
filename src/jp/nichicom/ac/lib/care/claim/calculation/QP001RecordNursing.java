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
 * �v���O���� ��������҉��T�[�r�X��p��񃌃R�[�h (QP001RecordNursing)
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
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanConstants;

/**
 * ��������҉��T�[�r�X��p��񃌃R�[�h
 * 
 */
public class QP001RecordNursing extends QP001RecordAbstract {

    // ������񎯕ʔԍ�4��
    private String _801001 = "";

    // ���R�[�h��ʃR�[�h2��(11��ݒ�)
    private static final String _801002 = "11";

    // �T�[�r�X�񋟔N��6��(YYYYMM)
    private String _801003 = "";

    // ���Ə��ԍ�10��
    private String _801004 = "";

    // �؋L�ڕی��Ҕԍ�8��
    private String _801005 = "";

    // ��ی��Ҕԍ�10��
    private String _801006 = "";

    // ��������҉��T�[�r�X��p��񃌃R�[�h�����ԍ�2��
    private int _801007 = 0;

    // �T�[�r�X��ރR�[�h2��
    private String _801008 = "";

    // �T�[�r�X���ڃR�[�h4��
    private String _801009 = "";

    // ��p�P��4��
    private int _801010 = 0;

    // ���S���x�z4��
    private int _801011 = 0;

    // ����2��
    private int _801012 = 0;

    // ����1����2��
    private int _801013 = 0;

    // ����2����2��
    private int _801014 = 0;

    // ����3����2��
    private int _801015 = 0;

    // ��p�z6��
    private int _801016 = 0;

    // �ی��������z6��
    private int _801017 = 0;

    // ����1���S�z(����)6��
    private int _801018 = 0;

    // ����2���S�z(����)6��
    private int _801019 = 0;

    // ����3���S�z(����)6��
    private int _801020 = 0;

    // ���p�ҕ��S�z5��
    private int _801021 = 0;

    // ��p�z���v6��
    private int _801022 = 0;

    // �ی��������z���v6��
    private int _801023 = 0;

    // ���p�ҕ��S�z���v6��
    private int _801024 = 0;

    // (����1)���S�z���v6��
    private int _801025 = 0;

    // (����1)�����z6��
    private int _801026 = 0;

    // (����1)�{�l���S�z5��
    private int _801027 = 0;

    // (����2)���S�z���v6��
    private int _801028 = 0;

    // (����2)�����z6��
    private int _801029 = 0;

    // (����2)�{�l���S�z5��
    private int _801030 = 0;

    // (����3)���S�z���v6��
    private int _801031 = 0;

    // (����3)�����z6��
    private int _801032 = 0;

    // (����3)�{�l���S�z5��
    private int _801033 = 0;

    // �T�[�r�X����(�T�[�r�X�R�[�h�}�X�^TBL��SERVICE_NAME)
    private String _801034 = "";

    // �V�X�e�����T�[�r�X��ރR�[�h(SYSTEM_SERVICE_KIND_DETAIL)
    private String _801035 = "";

    // �V�X�e�����T�[�r�X���ڃR�[�h(SYSTEM_SERVICE_CODE_ITEM)
    private String _801036 = "";
    
    // �񋟃T�[�r�X�敪 1-�H�� 2-���j�b�g�^�� 3-���j�b�g�^���� 4-�]���^��(���{��) 5-�]���^��(�V���E�×{��) 6-������
    private int _801037 = 0;

    // ����ʌ���I�u�W�F�N�g
    private QP001RecordSupporter kohiManager = new QP001RecordSupporter();

    protected String getSerialId() {
        // TODO �����������ꂽ���\�b�h�E�X�^�u
        return null;
    }

    /**
     * ���R�[�h��ʃR�[�h2��(11��ݒ�)���擾����B
     * 
     * @return
     */
    protected static String get_801002() {
        return _801002;
    }

    /**
     * ������񎯕ʔԍ�4�����擾����B
     * 
     * @return
     */
    protected String get_801001() {
        return _801001;
    }

    /**
     * ������񎯕ʔԍ�4����ݒ肷��B
     * 
     * @param _801001
     */
    protected void set_801001(String _801001) {
        this._801001 = _801001;
    }

    /**
     * �T�[�r�X�񋟔N��6��(YYYYMM)���擾����B
     * 
     * @return
     */
    protected String get_801003() {
        return _801003;
    }

    /**
     * �T�[�r�X�񋟔N��6��(YYYYMM)��ݒ肷��B
     * 
     * @param _801003
     */
    protected void set_801003(String _801003) {
        this._801003 = _801003;
    }

    /**
     * ���Ə��ԍ�10�����擾����B
     * 
     * @return
     */
    protected String get_801004() {
        return _801004;
    }

    /**
     * ���Ə��ԍ�10����ݒ肷��B
     * 
     * @param _801004
     */
    protected void set_801004(String _801004) {
        this._801004 = _801004;
    }

    /**
     * �؋L�ڕی��Ҕԍ�8�����擾����B
     * 
     * @return
     */
    protected String get_801005() {
        return _801005;
    }

    /**
     * �؋L�ڕی��Ҕԍ�8����ݒ肷��B
     * 
     * @param _801005
     */
    protected void set_801005(String _801005) {
        this._801005 = _801005;
    }

    /**
     * ��ی��Ҕԍ�10�����擾����B
     * 
     * @return
     */
    protected String get_801006() {
        return _801006;
    }

    /**
     * ��ی��Ҕԍ�10����ݒ肷��B
     * 
     * @param _801006
     */
    protected void set_801006(String _801006) {
        this._801006 = _801006;
    }

    /**
     * ��������҉��T�[�r�X��p��񃌃R�[�h�����ԍ�2�����擾����B
     * 
     * @return
     */
    protected int get_801007() {
        return _801007;
    }

    /**
     * ��������҉��T�[�r�X��p��񃌃R�[�h�����ԍ�2����ݒ肷��B
     * 
     * @param _801007
     */
    protected void set_801007(int _801007) {
        this._801007 = _801007;
    }

    /**
     * �T�[�r�X��ރR�[�h2�����擾����B
     * 
     * @return
     */
    protected String get_801008() {
        return _801008;
    }

    /**
     * �T�[�r�X��ރR�[�h2����ݒ肷��B
     * 
     * @param _801008
     */
    protected void set_801008(String _801008) {
        this._801008 = _801008;
    }

    /**
     * �T�[�r�X���ڃR�[�h4��
     * 
     * @return
     */
    protected String get_801009() {
        return _801009;
    }

    /**
     * �T�[�r�X���ڃR�[�h4����ݒ肷��B
     * 
     * @param _801009
     */
    protected void set_801009(String _801009) {
        this._801009 = _801009;
    }

    /**
     * ��p�P��4�����擾����B
     * 
     * @return
     */
    protected int get_801010() {
        return _801010;
    }

    /**
     * ��p�P��4����ݒ肷��B
     * 
     * @param _801010
     */
    protected void set_801010(int _801010) {
        this._801010 = _801010;
    }

    /**
     * ���S���x�z4�����擾����B
     * 
     * @return
     */
    protected int get_801011() {
        return _801011;
    }

    /**
     * ���S���x�z4����ݒ肷��B
     * 
     * @param _801011
     */
    protected void set_801011(int _801011) {
        this._801011 = _801011;
    }

    /**
     * ����2�����擾����B
     * 
     * @return
     */
    protected int get_801012() {
        return _801012;
    }

    /**
     * ����2����ݒ肷��B
     */
    protected void set_801012(int _801012) {
        this._801012 = _801012;
    }

    /**
     * ����1����2�����擾����B
     * 
     * @return
     */
    protected int get_801013() {
        return _801013;
    }

    /**
     * ����1����2����ݒ肷��B
     * 
     * @param _801013
     */
    protected void set_801013(int _801013) {
        this._801013 = _801013;
    }

    /**
     * ����2����2�����擾����B
     * 
     * @return
     */
    protected int get_801014() {
        return _801014;
    }

    /**
     * ����2����2����ݒ肷��B
     * 
     * @param _801014
     */
    protected void set_801014(int _801014) {
        this._801014 = _801014;
    }

    /**
     * ����3����2�����擾����B
     * 
     * @return
     */
    protected int get_801015() {
        return _801015;
    }

    /**
     * ����3����2����ݒ肷��B
     * 
     * @param _801015
     */
    protected void set_801015(int _801015) {
        this._801015 = _801015;
    }

    /**
     * ��p�z6�����擾����B
     * 
     * @return
     */
    protected int get_801016() {
        return _801016;
    }

    /**
     * ��p�z6����ݒ肷��B
     * 
     * @param _801016
     */
    protected void set_801016(int _801016) {
        this._801016 = _801016;
    }

    /**
     * �ی��������z6�����擾����B
     * 
     * @return
     */
    protected int get_801017() {
        return _801017;
    }

    /**
     * �ی��������z6����ݒ肷��B
     * 
     * @param _801017
     */
    protected void set_801017(int _801017) {
        this._801017 = _801017;
    }

    /**
     * ����1���S�z(����)6�����擾����B
     * 
     * @return
     */
    protected int get_801018() {
        return _801018;
    }

    /**
     * ����1���S�z(����)6����ݒ肷��B
     * 
     * @param _801018
     */
    protected void set_801018(int _801018) {
        this._801018 = _801018;
    }

    /**
     * ����2���S�z(����)6�����擾����B
     * 
     * @return
     */
    protected int get_801019() {
        return _801019;
    }

    /**
     * ����2���S�z(����)6����ݒ肷��B
     * 
     * @param _801019
     */
    protected void set_801019(int _801019) {
        this._801019 = _801019;
    }

    /**
     * ����3���S�z(����)6�����擾����B
     * 
     * @return
     */
    protected int get_801020() {
        return _801020;
    }

    /**
     * ����3���S�z(����)6����ݒ肷��B
     * 
     * @param _801020
     */
    protected void set_801020(int _801020) {
        this._801020 = _801020;
    }

    /**
     * ���p�ҕ��S�z5�����擾����B
     * 
     * @return
     */
    protected int get_801021() {
        return _801021;
    }

    /**
     * ���p�ҕ��S�z5����ݒ肷��B
     * 
     * @param _801021
     */
    protected void set_801021(int _801021) {
        this._801021 = _801021;
    }

    /**
     * ��p�z���v6�����擾����B
     * 
     * @return
     */
    protected int get_801022() {
        return _801022;
    }

    /**
     * ��p�z���v6����ݒ肷��B
     * 
     * @param _801022
     */
    protected void set_801022(int _801022) {
        this._801022 = _801022;
    }

    /**
     * �ی��������z���v6�����擾����B
     * 
     * @return
     */
    protected int get_801023() {
        return _801023;
    }

    /**
     * �ی��������z���v6����ݒ肷��B
     * 
     * @param _801023
     */
    protected void set_801023(int _801023) {
        this._801023 = _801023;
    }

    /**
     * ���p�ҕ��S�z���v6�����擾����B
     * 
     * @return
     */
    protected int get_801024() {
        return _801024;
    }

    /**
     * ���p�ҕ��S�z���v6����ݒ肷��B
     * 
     * @param _801024
     */
    protected void set_801024(int _801024) {
        this._801024 = _801024;
    }

    /**
     * (����1)���S�z���v6�����擾����B
     * 
     * @return
     */
    protected int get_801025() {
        return _801025;
    }

    /**
     * (����1)���S�z���v6����ݒ肷��B
     * 
     * @param _801025
     */
    protected void set_801025(int _801025) {
        this._801025 = _801025;
    }

    /**
     * (����1)�����z6�����擾����B
     * 
     * @return
     */
    protected int get_801026() {
        return _801026;
    }

    /**
     * (����1)�����z6����ݒ肷��B
     * 
     * @param _801026
     */
    protected void set_801026(int _801026) {
        this._801026 = _801026;
    }

    /**
     * (����1)�{�l���S�z5�����擾����B
     * 
     * @return
     */
    protected int get_801027() {
        return _801027;
    }

    /**
     * (����1)�{�l���S�z5����ݒ肷��B
     * 
     * @param _801027
     */
    protected void set_801027(int _801027) {
        this._801027 = _801027;
    }

    /**
     * (����2)���S�z���v6�����擾����B
     * 
     * @return
     */
    protected int get_801028() {
        return _801028;
    }

    /**
     * (����2)���S�z���v6����ݒ肷��B
     * 
     * @param _801028
     */
    protected void set_801028(int _801028) {
        this._801028 = _801028;
    }

    /**
     * (����2)�����z6�����擾����B
     * 
     * @return
     */
    protected int get_801029() {
        return _801029;
    }

    /**
     * (����2)�����z6����ݒ肷��B
     * 
     * @param _801029
     */
    protected void set_801029(int _801029) {
        this._801029 = _801029;
    }

    /**
     * (����2)�{�l���S�z5�����擾����B
     * 
     * @return
     */
    protected int get_801030() {
        return _801030;
    }

    /**
     * (����2)�{�l���S�z5����ݒ肷��B
     * 
     * @param _801030
     */
    protected void set_801030(int _801030) {
        this._801030 = _801030;
    }

    /**
     * (����3)���S�z���v6�����擾����B
     * 
     * @return
     */
    protected int get_801031() {
        return _801031;
    }

    /**
     * (����3)���S�z���v6����ݒ肷��B
     * 
     * @param _801031
     */
    protected void set_801031(int _801031) {
        this._801031 = _801031;
    }

    /**
     * (����3)�����z6�����擾����B
     * 
     * @return
     */
    protected int get_801032() {
        return _801032;
    }

    /**
     * (����3)�����z6����ݒ肷��B
     * 
     * @param _801032
     */
    protected void set_801032(int _801032) {
        this._801032 = _801032;
    }

    /**
     * (����3)�{�l���S�z5�����擾����B
     * 
     * @return
     */
    protected int get_801033() {
        return _801033;
    }

    /**
     * (����3)�{�l���S�z5����ݒ肷��B
     * 
     * @param _801033
     */
    protected void set_801033(int _801033) {
        this._801033 = _801033;
    }

    /**
     * �T�[�r�X����(�T�[�r�X�R�[�h�}�X�^TBL��SERVICE_NAME)���擾����B
     * 
     * @return
     */
    protected String get_801034() {
        return _801034;
    }

    /**
     * �T�[�r�X����(�T�[�r�X�R�[�h�}�X�^TBL��SERVICE_NAME)��ݒ肷��B
     * 
     * @param _801034
     */
    protected void set_801034(String _801034) {
        this._801034 = _801034;
    }

    /**
     * �V�X�e�����T�[�r�X��ރR�[�h(SYSTEM_SERVICE_KIND_DETAIL)���擾����B
     * 
     * @return
     */
    protected String get_801035() {
        return _801035;
    }

    /**
     * �V�X�e�����T�[�r�X��ރR�[�h(SYSTEM_SERVICE_KIND_DETAIL)��ݒ肷��B
     * 
     * @param _801035
     */
    protected void set_801035(String _801035) {
        this._801035 = _801035;
    }

    /**
     * �V�X�e�����T�[�r�X���ڃR�[�h(SYSTEM_SERVICE_CODE_ITEM)���擾����B
     * 
     * @return
     */
    protected String get_801036() {
        return _801036;
    }

    /**
     * �V�X�e�����T�[�r�X���ڃR�[�h(SYSTEM_SERVICE_CODE_ITEM)��ݒ肷��B
     * 
     * @param _801036
     */
    protected void set_801036(String _801036) {
        this._801036 = _801036;
    }

    /**
     * �񋟃T�[�r�X�敪���擾����B
     * 1-�H�� 2-���j�b�g�^�� 3-���j�b�g�^���� 4-�]���^��(���{��) 5-�]���^��(�V���E�×{��) 6-������
     * 
     * @return
     */
    protected int get_801037() {
        return _801037;
    }

    /**
     * �񋟃T�[�r�X�敪��ݒ肷��B
     * 1-�H�� 2-���j�b�g�^�� 3-���j�b�g�^���� 4-�]���^��(���{��) 5-�]���^��(�V���E�×{��) 6-������
     * 
     * @param _801037
     */
    protected void set_801037(int _801037) {
        this._801037 = _801037;
    }
    
    
    protected static QP001RecordNursing getInstance(String identificationNo,
            Date targetDate, Object targetServiceDate, VRMap serviceDetail,
            VRMap serviceCode, QP001PatientState patientState,VRMap nursingMap,QP001Manager manager) throws Exception {
        
        QP001RecordNursing nursing = null;
        
        //���R�[�h�̍쐬�ۂ𔻒f
        if(!isMakeRecord(identificationNo,serviceCode,patientState,targetServiceDate,serviceDetail)){
            return nursing;
        }
        
        String serial = getSerialId(identificationNo,
                                    targetDate,
                                    targetServiceDate,
                                    serviceDetail,
                                    serviceCode,
                                    patientState,
                                    manager);
        
        //�����ɍ��v���郌�R�[�h�����݂��Ȃ��ꍇ
        if(!nursingMap.containsKey(serial)){
            nursing = new QP001RecordNursing();
            nursingMap.put(serial,nursing);
        //�����ɍ��v���郌�R�[�h�����݂���ꍇ
        } else {
            nursing = (QP001RecordNursing)nursingMap.get(serial);
        }
        
        return nursing;
    }
    
    /**
     * ���R�[�h�쐬�̉ۂ𔻒f����B
     * @param identificationNo
     * @param serviceCode
     * @param patientState
     * @param targetServiceDate
     * @return
     * @throws Exception
     */
    protected static boolean isMakeRecord(String identificationNo,VRMap serviceCode,QP001PatientState patientState,Object targetServiceDate,VRMap serviceDetail) throws Exception {
        String shotokuDankai = patientState.getShisetsuData("TOKUTEI_NYUSHO_FLAG");
        // patient �� �����i�K���I������Ă��Ȃ��ꍇ�A�������s��Ȃ��B
        if (("".equals(shotokuDankai)) || ("0".equals(shotokuDankai))) {
            return false;
        }
        // �T�[�r�X��ރR�[�h��59(��������҉��T�[�r�X��)�Ŗ����ꍇ�A�������s��Ȃ��B
        if (!"59".equals(ACCastUtilities.toString(VRBindPathParser.get(
                "SERVICE_CODE_KIND", serviceCode)))) {
            return false;
        }
        
        //30�����ł���΃��R�[�h�̍쐬�𒆒f����B
        if(ACCastUtilities.toInt(serviceDetail.get("5"),0) == 2){
            return false;
        }
        
        //���ےP�Ɨ��p�҂̏ꍇ
        //if(patientState.isSeihoOnly(patientState.getInsuredId(targetServiceDate))){
        if(patientState.isSeihoOnly(targetServiceDate)){
            //�l����O�܂��͎l�̏ꍇ���R�[�h�̍쐬���s��Ȃ�
            if(identificationNo.equals(QP001StyleAbstract.IDENTIFICATION_NO_3_201204)
               || identificationNo.equals(QP001StyleAbstract.IDENTIFICATION_NO_3_2_201204)
               || identificationNo.equals(QP001StyleAbstract.IDENTIFICATION_NO_4_201204)
               || identificationNo.equals(QP001StyleAbstract.IDENTIFICATION_NO_4_2_201204)
               || identificationNo.equals(QP001StyleAbstract.IDENTIFICATION_NO_5_201204)
               || identificationNo.equals(QP001StyleAbstract.IDENTIFICATION_NO_5_2_201204)
            	){
                return false;
            }
            
            //�H��A�������ȊO�̃T�[�r�X�̏ꍇ�A�L�ڂ��s��Ȃ��B
            switch(QP001SpecialCase.getServiceKind(serviceCode)){
            //�H��
            case 1:
            //������
            case 6:
                return true;
            default:
                return false;
            }
        }
        
        return true;
    }
    
    
    private static String getSerialId(String identificationNo,
            Date targetDate, Object targetServiceDate, VRMap serviceDetail,
            VRMap serviceCode, QP001PatientState patientState,QP001Manager manager) throws Exception {

        StringBuilder serial = new StringBuilder();
        // �������ʔԍ�
        serial.append(identificationNo);
        // ���R�[�h��ʃR�[�h2��(11�Œ�)
        serial.append(_801002);
        // �T�[�r�X�񋟔N��6��(YYYYMM)
        serial.append(VRDateParser.format(targetDate, "yyyyMM"));
        // ���Ə��ԍ�10��
        serial.append(VRBindPathParser.get("PROVIDER_ID", serviceDetail));
        // �؋L�ڕی��Ҕԍ�8��
        serial.append(patientState.getInsurerId(targetServiceDate));
        // ��ی��Ҕԍ�10��
        serial.append(patientState.getInsuredId(targetServiceDate));
//        // �V�X�e�����T�[�r�X��ރR�[�h
//        serial.append(VRBindPathParser.get("SYSTEM_SERVICE_KIND_DETAIL",
//                serviceCode));
//        // �V�X�e�����T�[�r�X���ڃR�[�h
//        serial.append(VRBindPathParser.get("SYSTEM_SERVICE_CODE_ITEM",
//                serviceCode));
        
        // �T�[�r�X��ރR�[�h
        serial.append(VRBindPathParser.get("SERVICE_CODE_KIND", serviceCode));
        // �T�[�r�X���ڃR�[�h
        serial.append(VRBindPathParser.get("SERVICE_CODE_ITEM", serviceCode));
        
        // ��p�P��
        serial.append(QP001SpecialCase.getUnit(serviceDetail,serviceCode,manager));

        return serial.toString();
    }

    /**
     * ���ɏ�񂪓o�^����Ă��邩�ԋp���܂��B
     * 
     * @return �V�K:true �ǉ�:false
     */
    private boolean isNew() {
        // ������񃌃R�[�h�ɓo�^��������ΐV�K�Ƃ݂Ȃ��B
        return ((get_801001() == null) || ("".equals(get_801001())));
    }

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
            String identificationNo,QP001Manager manager) throws Exception {

        Object targetServiceDate = VRBindPathParser.get("SERVICE_DATE",
                serviceDetail);

        if (isNew()) {
            // nursing �� KEY : 801001(������񎯕ʔԍ�) �� VALUE : ��Z������ݒ肷��B
            set_801001(identificationNo);
            // nursing �� KEY : 801003(�T�[�r�X�񋟔N��) ��
            // VALUE : yyyyMM�`���Ƀt�H�[�}�b�g����targetDate��ݒ肷��B
            set_801003(VRDateParser.format(targetDate, "yyyyMM"));
            // nursing �� KEY : 801004(���Ə��ԍ�) ��
            // VALUE : 10���t�H�[�}�b�g�������Ə��ԍ�(serviceDetail���擾)��ݒ肷��B
            set_801004(ACCastUtilities.toString(VRBindPathParser.get(
                    "PROVIDER_ID", serviceDetail)));
            // nursing �� KEY : 801005(�؋L�ڕی��Ҕԍ�) ��
            // VALUE : 8���t�H�[�}�b�g�������p�҂̕ی��Ҕԍ�(patient���擾)��ݒ肷��B
            set_801005(patientState.getInsurerId(targetServiceDate));
            // nursing �� KEY : 801006(��ی��Ҕԍ�) ��
            // VALUE : 10���t�H�[�}�b�g�������p�҂̔�ی��Ҕԍ�(patient���擾)��ݒ肷��B
            set_801006(patientState.getInsuredId(targetServiceDate));

            // nursing �� KEY : 801008(�T�[�r�X��ރR�[�h) ��
            // VALUE : 2���t�H�[�}�b�g�����T�[�r�X��ރR�[�h(serviceCode���擾))��ݒ肷��B
            // (59�Œ�ƂȂ�͂�)
            set_801008(ACCastUtilities.toString(VRBindPathParser.get(
                    "SERVICE_CODE_KIND", serviceCode)));
            // nursing �� KEY : 801009(�T�[�r�X���ڃR�[�h) ��
            // VALUE : 4���t�H�[�}�b�g�����T�[�r�X���ڃR�[�h(serviceCode���擾����)��ݒ肷��B
            set_801009(ACCastUtilities.toString(VRBindPathParser.get(
                    "SERVICE_CODE_ITEM", serviceCode)));

            // nursing �� KEY : 801010(��p�P��) ��
            // VALUE : ���p�ҏ���� - ���p�҂̏����i�K�ɂ�茈�肵����p�P����ݒ肷��B
            set_801010(QP001SpecialCase.getUnit(serviceDetail,serviceCode,manager));

            // nursing �� KEY : 801011(���S���x�z) ��
            // VALUE : ���p�҂̕��S���x�z��ݒ肷��B(���p�ҏ���� - ���p�҂̏����i�K�ɂ�茈�肵����p�P����ݒ肷��B)
            set_801011(QP001SpecialCase.getRiyosyaFutan(serviceCode,patientState));

            // nursing �� KEY : 801012(����) ��
            // VALUE : 1 ��ݒ肷��B
            set_801012(1);

            // �T�[�r�X�R�[�h�}�X�^TBL��SERVICE_NAME��ݒ肷��B
            set_801034(ACCastUtilities.toString(VRBindPathParser.get(
                    "SERVICE_NAME", serviceCode)));
            // �V�X�e�����T�[�r�X��ރR�[�h(SYSTEM_SERVICE_KIND_DETAIL)��ݒ肷��B
            set_801035(ACCastUtilities.toString(VRBindPathParser.get(
                    "SYSTEM_SERVICE_KIND_DETAIL", serviceCode)));
            // �V�X�e�����T�[�r�X���ڃR�[�h(SYSTEM_SERVICE_CODE_ITEM)
            set_801036(ACCastUtilities.toString(VRBindPathParser.get(
                    "SYSTEM_SERVICE_CODE_ITEM", serviceCode)));
            // �񋟃T�[�r�X�敪
            set_801037(QP001SpecialCase.getServiceKind(serviceCode));

        } else {
            // nursing �� KEY : 801012(����) �̒l��1��������B
            set_801012(get_801012() + 1);
        }

        // ����ʂ̓o�^���s���B
//        kohiManager.setExtraData(targetServiceDate,serviceDetail, patientState, get_801035(),
//                "4", get_801010(),QP001Manager.getInstance().getProviderMedicalFlag(get_801004()));
//        kohiManager.setExtraData(targetServiceDate,serviceDetail, patientState, serviceCode,
//                "4", get_801010(),QP001Manager.getInstance().getProviderMedicalFlag(get_801004()));
        kohiManager.setExtraData(targetServiceDate,serviceDetail, patientState, serviceCode,
                "4", get_801010(),manager.getProviderMedicalFlag(get_801004()),manager);

    }
    


    /**
     * ���R�[�h���e�̊m����s���B
     */
    protected void commitRecord(String[] kohi,QP001PatientState patientState,QP001Manager manager) throws Exception {
        //���ےP�ƃt���O
        boolean seihoOnly = QP001SpecialCase.isSeihoOnly(get_801006());
        //��ގ��(1.�H��)
        int serviceKind = get_801037();    
    
        // ��p�z
        set_801016(get_801010() * get_801012());
        
//        //���ےP�Ƃł���΁A�ی����������s�킸�A�S�z����S�Ƃ���B
//        if(seihoOnly){
//            //�ی��������z��0�ɐݒ�
//            set_801017(0);
//            //����P�����z�ɔ�p�z�̑S�z��ݒ肷��B
//            set_801018(get_801016());
//            //���p�ҕ��S�z��0��ݒ肷��B
//            set_801021(0);
//            //�������I��
//            return;
//            
//        //���ےP�ƂłȂ���΁A�ی����̐������z��ݒ肷��B
//        } else {
//            //�ی��������z ��p�z-(���S���x�z*����)
//            set_801017(get_801016() - (get_801011() * get_801012()));
//            
//            //�����ɂȂ�����(���p�Ґ����̂ق����������)0�ɖ߂��B
//            if(get_801017() < 0){
//                set_801017(0);
//            }
//        }
        //�ی��������z ��p�z-(���S���x�z*����)
        set_801017(get_801016() - (get_801011() * get_801012()));
        
        //�����ɂȂ�����(���p�Ґ����̂ق����������)0�ɖ߂��B
        if(get_801017() < 0){
            set_801017(0);
        }
        
        // �l���W�C�X�C�P�O�łȂ��ƌ���̓K�p�͍s���Ȃ��B
        if(QP001SpecialCase.isShisetsuDiscriminationNo(get_801001())){
            
            //���ےP�Ƃł���΁A�ی����������s�킸�A�S�z����S�Ƃ���B
            if(seihoOnly){
                //�ی��������z��0�ɐݒ�
                set_801017(0);
                //����P�����z�ɔ�p�z�̑S�z��ݒ肷��B
                set_801018(get_801016());
                //���p�ҕ��S�z��0��ݒ肷��B
                set_801021(0);
                
                // add sta 2006.05.18 fujihara.shin
                if(isUsingKohi(kohi[0],manager) && kohi[0].startsWith("12")){
                	set_801013(kohiManager.getKohiCount(kohi[0]));
                } else if(isUsingKohi(kohi[1],manager) && kohi[1].startsWith("12")){
                	set_801013(kohiManager.getKohiCount(kohi[1]));
                } else if(isUsingKohi(kohi[2],manager) && kohi[2].startsWith("12")){
                	set_801013(kohiManager.getKohiCount(kohi[2]));
                }
                // add end 2006.05.18 fujihara.shin
                
                //�������I��
                return;
            }
            
            // ����P�̓K�p�����邩�m�F
            //if ((kohi[0] != null) && (!"".equals(kohi[0]))) {
            if(isUsingKohi(kohi[0],manager)){
                
                int kohiRate = ACCastUtilities.toInt(patientState.getKohiData(kohi[0],"BENEFIT_RATE",1),0);
                //����̋��t�L
                if(kohiRate != 0){
                    // ����P�Ώۓ�����ݒ肷��B
                    set_801013(kohiManager.getKohiCount(kohi[0]));
                    //�H��񋟁A�܂��͑������ł���ꍇ�̂݌����K�p����B
                    //(�����͐ݒ���s��)
                    if((serviceKind == 1) || (serviceKind == 6)){
                        // ����1���S�z(����)6����ݒ肷��B(���S���x�z*����1����)
                        set_801018(get_801011() * get_801013());
                        //����P����p�z�ƕی����̍��Z�𒴂���ꍇ
                        if(get_801018() > (get_801016() + get_801017())){
                            //����ɔ�p�z����ی������������l��K�p����B
                            set_801018(get_801016() - get_801017()); 
                        }
                        
                        // add sta 2006.05.18 fujihara.shin
                        //����P�̋��z��0�̏ꍇ�A����Ώۓ�����0�Ƃ���
                        if(get_801018() == 0){
                        	set_801013(0);
                        }
                        // add end 2006.05.18 fujihara.shin
                    } else {
                        //�H��A�������ȊO�͌��������0�Ƃ��Čv��
                        set_801013(0);
                    }
                }
                // �S�z���t�����珈�����I��
                if (get_801016() == (get_801017() + get_801018()))
                    return;
            }
            // ����Q�̓K�p�����邩�m�F
            //if ((kohi[1] != null) && (!"".equals(kohi[1]))) {
            if(isUsingKohi(kohi[1],manager)){
                //����Q�̓K�p�����邩�m�F
                int kohiRate = ACCastUtilities.toInt(patientState.getKohiData(kohi[1],"BENEFIT_RATE",1),0);
                //����̋��t�L
                if(kohiRate != 0){
                    //����Q�̑Ώۓ���ݒ肷��B
                    set_801014(kohiManager.getKohiCount(kohi[1]));
                    //�H��񋟁A�܂��͑������ł���ꍇ�̂݌����K�p����B
                    if((serviceKind == 1) || (serviceKind == 6)){
                        //����Q���S�z(����)6����ݒ肷��B�i���S���x�z*����2�����j
                        set_801019(get_801011() * get_801014());
                        //����Q����p�z�ƕی����̍��Z�𒴂���ꍇ
                        if(get_801019() > (get_801016() + get_801017())){
                            //����ɔ�p�z����ی������������l��K�p����B
                            set_801019(get_801016() - get_801017()); 
                        }
                        
                        // add sta 2006.05.18 fujihara.shin
                        //����P�̋��z��0�̏ꍇ�A����Ώۓ�����0�Ƃ���
                        if(get_801019() == 0){
                        	set_801014(0);
                        }
                        // add end 2006.05.18 fujihara.shin
                    } else {
                        set_801014(0);
                    }
                        
                }
                // �S�z���t�����珈�����I��
                if (get_801016() == (get_801017() + get_801018() + get_801019()))
                    return;
            }
            // ����R�̓K�p�����邩�m�F
            //if ((kohi[2] != null) && (!"".equals(kohi[2]))) {
            if(isUsingKohi(kohi[2],manager)){
                //����R�̓K�p�����邩�m�F
                int kohiRate = ACCastUtilities.toInt(patientState.getKohiData(kohi[2],"BENEFIT_RATE",1),0);
                //����̋��t�L
                if(kohiRate != 0){
                    //����R�̑Ώۓ���ݒ肷��B
                    set_801015(kohiManager.getKohiCount(kohi[2]));
                    //�H��񋟁A�܂��͑������ł���ꍇ�̂݌����K�p����B
                    if((serviceKind == 1) || (serviceKind == 6)){
                        //����R���S�z(����)6����ݒ肷��B
                        set_801020(get_801011() * get_801015());
                        //����R����p�z�ƕی����̍��Z�𒴂���ꍇ
                        if(get_801020() > (get_801016() + get_801017())){
                            //����ɔ�p�z����ی������������l��K�p����B
                            set_801020(get_801016() - get_801017());
                        }
                        // add sta 2006.05.18 fujihara.shin
                        //����P�̋��z��0�̏ꍇ�A����Ώۓ�����0�Ƃ���
                        if(get_801020() == 0){
                        	set_801015(0);
                        }
                        // add end 2006.05.18 fujihara.shin
                    } else {
                        set_801015(0);
                    }
                }
                
            }
        }
        // ���p�ҕ��S�z��ݒ肷��B
        set_801021(get_801016() - get_801017() - get_801018() - get_801019() - get_801020());

    }

    private boolean isUsingKohi(String kohi, QP001Manager manager) throws Exception {
        
        if((kohi == null) || "".equals(kohi)){
            return false;
        }
        
        VRMap map = (VRMap)manager.getKohiMatchData(kohi,get_801035(),"4");
        if(map == null){
            return false;
        }
        
        if(ACCastUtilities.toInt(map.get("APPLICATION_TYPE"),0) != 4){
            return false;
        }
        
        return true;
    }
    
    /**
     * ���R�[�h�����ԍ�99�̏W�v���s���B
     * 
     * @param nursingMap
     * @throws Exception
     */
    protected void commitRecord(VRMap nursingMap) throws Exception {
        QP001RecordNursing nursing = null;
        Iterator it = nursingMap.keySet().iterator();
        int count = 1;
        while (it.hasNext()) {
            nursing = (QP001RecordNursing) nursingMap.get(it.next());
            
            //2006.04.28 �S�z���ȕ��S�Ή�
            //�ی��E����̕��S�������ꍇ�ɂ́A���[�Ɍv�サ�Ȃ��B
            if((nursing.get_801017() + nursing.get_801018() + nursing.get_801019() + nursing.get_801020()) <= 0){
                continue;
            }
            
            //���R�[�h�����ԍ���ݒ肷��B
            nursing.set_801007(count);
            
            // ��p�z���v6��
            set_801022(get_801022() + nursing.get_801016());
            // �ی��������z���v6��
            set_801023(get_801023() + nursing.get_801017());
            // ���p�ҕ��S�z���v6��
            set_801024(get_801024() + nursing.get_801021());
            // (����1)���S�z���v6��
            set_801025(get_801025() + nursing.get_801018());
            // (����1)�����z6��
            set_801026(get_801026() + nursing.get_801018());
            // (����1)�{�l���S�z5��
            set_801027(0);
            // (����2)���S�z���v6��
            set_801028(get_801028() + nursing.get_801019());
            // (����2)�����z6��
            set_801029(get_801029() + nursing.get_801019());
            // (����2)�{�l���S�z5��
            set_801030(0);
            // (����3)���S�z���v6��
            set_801031(get_801031() + nursing.get_801020());
            // (����3)�����z6��
            set_801032(get_801032() + nursing.get_801020());
            // (����3)�{�l���S�z5��
            set_801033(0);
            count++;
        }
        // �������g�̃��R�[�h�����ԍ���99�ɕύX����B
        set_801007(99);
    }
    
    /**
     * ���R�[�h�����ԍ���99�̃��R�[�h�ɑ΂��A����ȕ��S�z�̊m����s���B
     * ���W�v��񃌃R�[�h�̊m��������Ȃ��A����ȕ��S�z�̎c�z���m�肷��K�v������B
     * @param kohi ����ԍ�
     * @param patientState ���p�ҏ��
     * @throws Exception
     */
    protected void commitRecordKohiSelfPay(String[] kohi,QP001PatientState patientState) throws Exception{
        //���R�[�h�����ԍ����m�F���A99�łȂ���Ώ����𒆒f����B
        if(get_801007() != 99){
            return;
        }
        //�l���攪�A���A��\�ȊO�̏ꍇ�͏����𒆒f����B
        if(!QP001SpecialCase.isShisetsuDiscriminationNo(get_801001())){
            return;
        }
        
        // ����P�̓K�p�����邩�m�F
        if ((kohi[0] != null) && (!"".equals(kohi[0]))) {
            int kohiRate = ACCastUtilities.toInt(patientState.getKohiData(kohi[0],"BENEFIT_RATE",1),0);
            //����̋��t�L
            if(kohiRate != 0){
                //����P���ȕ��S�z�̐ݒ���s���B
                int selfPay = patientState.getKohiSelfPay(kohi[0],1);
                //����ȕ��S�z�̕����傫�����
                if(get_801026() < selfPay){
                    //(����1)�{�l���S�z5���ɐ����z��ݒ肷��B
                    set_801027(get_801026());
                    //����1�����z��0�ɐݒ肷��B
                    set_801026(0);
                    //�g�p�������ȕ��S��񍐂���B
                    patientState.setKohiSelfPayUse(kohi[0],get_801027());
                    
                } else {
                    //����P�����z�������ȕ��S�������Z����
                    set_801026(get_801026() - selfPay);
                    //����P���ȕ��S�z��ݒ肷��B
                    set_801027(selfPay);
                    //�g�p�������ȕ��S��񍐂���B
                    patientState.setKohiSelfPayUse(kohi[0],selfPay);
                }
            }
        }
        // ����Q�̓K�p�����邩�m�F
        if ((kohi[1] != null) && (!"".equals(kohi[1]))) {
            //����Q�̓K�p�����邩�m�F
            int kohiRate = ACCastUtilities.toInt(patientState.getKohiData(kohi[1],"BENEFIT_RATE",1),0);
            //����̋��t�L
            if(kohiRate != 0){
                //����Q���ȕ��S�z�̐ݒ���s���B
                int selfPay = patientState.getKohiSelfPay(kohi[1],1);
                //����ȕ��S�z�̕����傫�����
                if(get_801029() < selfPay){
                    //(����2)�{�l���S�z5���ɐ����z��ݒ肷��B
                    set_801030(get_801029());
                    //����2�����z��0�ɐݒ肷��B
                    set_801029(0);
                    //�g�p�������ȕ��S��񍐂���B
                    patientState.setKohiSelfPayUse(kohi[1],get_801030());
                    
                } else {
                    //����2�����z�������ȕ��S�������Z����
                    set_801029(get_801029() - selfPay);
                    //����2���ȕ��S�z��ݒ肷��B
                    set_801030(selfPay);
                    //�g�p�������ȕ��S��񍐂���B
                    patientState.setKohiSelfPayUse(kohi[1],selfPay);
                }
            }
        }
        // ����R�̓K�p�����邩�m�F
        if ((kohi[2] != null) && (!"".equals(kohi[2]))) {
            //����R�̓K�p�����邩�m�F
            int kohiRate = ACCastUtilities.toInt(patientState.getKohiData(kohi[2],"BENEFIT_RATE",1),0);
            //����̋��t�L
            if(kohiRate != 0){
                //����R���ȕ��S�z�̐ݒ���s���B
                int selfPay = patientState.getKohiSelfPay(kohi[2],1);
                //[ID:0000538][Shin Fujihara] 2009/07 edit begin 2009�N�x�Ή�
                //����ȕ��S�z�̕����傫�����
                if(get_801032() < selfPay){
                    //(����1)�{�l���S�z5���ɐ����z��ݒ肷��B
                    set_801033(get_801032());
                    //����1�����z��0�ɐݒ肷��B
                    set_801032(0);
                    //�g�p�������ȕ��S��񍐂���B
                    patientState.setKohiSelfPayUse(kohi[2],get_801033());
                    
                } else {
                    //����P�����z�������ȕ��S�������Z����
                    set_801032(get_801032() - selfPay);
                    //����P���ȕ��S�z��ݒ肷��B
                    set_801033(selfPay);
                    //�g�p�������ȕ��S��񍐂���B
                    patientState.setKohiSelfPayUse(kohi[2],selfPay);
                }
                /*
                //����ȕ��S�z�̕����傫�����
                if(get_801032() < selfPay){
                    //(����1)�{�l���S�z5���ɐ����z��ݒ肷��B
                    set_801032(get_801031());
                    //����1�����z��0�ɐݒ肷��B
                    set_801031(0);
                    //�g�p�������ȕ��S��񍐂���B
                    patientState.setKohiSelfPayUse(kohi[2],get_801032());
                    
                } else {
                    //����P�����z�������ȕ��S�������Z����
                    set_801031(get_801031() - selfPay);
                    //����P���ȕ��S�z��ݒ肷��B
                    set_801032(selfPay);
                    //�g�p�������ȕ��S��񍐂���B
                    patientState.setKohiSelfPayUse(kohi[2],selfPay);
                }
                */
                //[ID:0000538][Shin Fujihara] 2009/07 edit end 2009�N�x�Ή�
            }
        }
    }

    protected VRMap getKohiList() {
        return this.kohiManager.getKohiList();
    }

    protected VRList getRealDays() {
        return this.kohiManager.getRealDays();
    }

    protected VRMap getKohiPattern() {
        return this.kohiManager.getKohiPattern();
    }

    /**
     * �f�[�^�쐬
     * 
     * @param style
     * @return
     */
    protected VRMap getRecord(VRMap style) throws Exception {
        VRMap result = copyStyle(style);

        // ������񎯕ʔԍ�4��
        setData(result, "801001", get_801001());
        // ���R�[�h��ʃR�[�h2��(11��ݒ�)
        setData(result, "801002", get_801002());
        // �T�[�r�X�񋟔N��6��(YYYYMM)
        setData(result, "801003", get_801003());
        // ���Ə��ԍ�10��
        setData(result, "801004", get_801004());
        // �؋L�ڕی��Ҕԍ�8��
        setData(result, "801005", get_801005());
        // ��ی��Ҕԍ�10��
        setData(result, "801006", get_801006());
        // ��������҉��T�[�r�X��p��񃌃R�[�h�����ԍ�2��
        setData(result, "801007", get_801007());
        // �T�[�r�X��ރR�[�h2��
        setData(result, "801008", get_801008());
        // �T�[�r�X���ڃR�[�h4��
        setData(result, "801009", get_801009());

        // ��p�P��4��
        setData(result, "801010", get_801010());
        // ���S���x�z4��
        setData(result, "801011", get_801011());
        // ����2��
        setData(result, "801012", get_801012());
        // ����1����2��
        setData(result, "801013", get_801013());
        // ����2����2��
        setData(result, "801014", get_801014());
        //����3����2��
        setData(result, "801015", get_801015());
        //��p�z6��
        setData(result, "801016", get_801016());
        //�ی��������z6��
        setData(result, "801017", get_801017());
        //����1���S�z(����)6��
        setData(result, "801018", get_801018());
        //����2���S�z(����)6��
        setData(result, "801019", get_801019());

        //����3���S�z(����)6��
        setData(result, "801020", get_801020());
        //���p�ҕ��S�z5��
        setData(result, "801021", get_801021());
        //��p�z���v6��
        setData(result, "801022", get_801022());
        //�ی��������z���v6��
        setData(result, "801023", get_801023());
        //���p�ҕ��S�z���v6��
        setData(result, "801024", get_801024());
        //(����1)���S�z���v6��
        setData(result, "801025", get_801025());
        //(����1)�����z6��
        setData(result, "801026", get_801026());
        //(����1)�{�l���S�z5��
        setData(result, "801027", get_801027());
        //(����2)���S�z���v6��
        setData(result, "801028", get_801028());
        //(����2)�����z6��
        setData(result, "801029", get_801029());

        //(����2)�{�l���S�z5��
        setData(result, "801030", get_801030());
        //(����3)���S�z���v6��
        setData(result, "801031", get_801031());
        //(����3)�����z6��
        setData(result, "801032", get_801032());
        //(����3)�{�l���S�z5��
        setData(result, "801033", get_801033());
        //�T�[�r�X����(�T�[�r�X�R�[�h�}�X�^TBL��SERVICE_NAME)
        setData(result, "801034", get_801034());

        //		setData(result,style,"801035",get_801035());
        //		setData(result,style,"801036",get_801036());
        setData(result, "801037", get_801037());

        return result;
    }

    private VRMap copyStyle(VRMap style) {
        VRMap result = new VRHashMap();
        Object key;
        //�f�B�[�v�R�s�[
        Iterator it = style.keySet().iterator();
        while (it.hasNext()) {
            key = it.next();
            result.put(key, style.get(key));
        }
        //��������҉��T�[�r�X��p��񃌃R�[�h
        //result.put("CATEGORY_NO", "8");
        result.put("CATEGORY_NO", QkanConstants.CATEGORY_NO_RECODE_SPECIAL_ENTER_SERVICE);
        return result;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();

        result.append("[801001=" + get_801001() + "]\n");
        result.append("[801002=" + get_801002() + "]\n");
        result.append("[801003=" + get_801003() + "]\n");
        result.append("[801004=" + get_801004() + "]\n");
        result.append("[801005=" + get_801005() + "]\n");
        result.append("[801006=" + get_801006() + "]\n");
        result.append("[801007=" + get_801007() + "]\n");
        result.append("[801008=" + get_801008() + "]\n");
        result.append("[801009=" + get_801009() + "]\n");

        result.append("[801010=" + get_801010() + "]\n");
        result.append("[801011=" + get_801011() + "]\n");
        result.append("[801012=" + get_801012() + "]\n");
        result.append("[801013=" + get_801013() + "]\n");
        result.append("[801014=" + get_801014() + "]\n");
        result.append("[801015=" + get_801015() + "]\n");
        result.append("[801016=" + get_801016() + "]\n");
        result.append("[801017=" + get_801017() + "]\n");
        result.append("[801018=" + get_801018() + "]\n");
        result.append("[801019=" + get_801019() + "]\n");

        result.append("[801020=" + get_801020() + "]\n");
        result.append("[801021=" + get_801021() + "]\n");
        result.append("[801022=" + get_801022() + "]\n");
        result.append("[801023=" + get_801023() + "]\n");
        result.append("[801024=" + get_801024() + "]\n");
        result.append("[801025=" + get_801025() + "]\n");
        result.append("[801026=" + get_801026() + "]\n");
        result.append("[801027=" + get_801027() + "]\n");
        result.append("[801028=" + get_801028() + "]\n");
        result.append("[801029=" + get_801029() + "]\n");

        result.append("[801030=" + get_801030() + "]\n");
        result.append("[801031=" + get_801031() + "]\n");
        result.append("[801032=" + get_801032() + "]\n");
        result.append("[801033=" + get_801033() + "]\n");
        result.append("[801034=" + get_801034() + "]\n");
        result.append("[801035=" + get_801035() + "]\n");
        result.append("[801036=" + get_801036() + "]\n");
        result.append("[801037=" + get_801037() + "]\n");

        return result.toString();
    }

}
