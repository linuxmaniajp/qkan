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
 * �v���O���� ����f�Ô��񃌃R�[�h (QP001RecordDiagnosis)
 *
 *****************************************************************
 */

package jp.nichicom.ac.lib.care.claim.calculation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.util.ACDateUtilities;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.text.parsers.VRDateParser;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanConstants;
import jp.nichicom.ac.lib.care.claim.servicecode.CareServiceCommon;//add 20140210

/**
 * ����f�Ô��񃌃R�[�h
 * 
 */
public class QP001RecordDiagnosis extends QP001RecordAbstract {

    // ������񎯕ʔԍ�4��
    private String _501001 = "";

    // ���R�[�h��ʃR�[�h2��
    private static final String _501002 = "04";

    // �T�[�r�X�񋟔N��6��(YYYYMM)
    private String _501003 = "";

    // ���Ə��ԍ�10��
    private String _501004 = "";

    // �؋L�ڕی��Ҕԍ�8��
    private String _501005 = "";

    // ��ی��Ҕԍ�10��
    private String _501006 = "";

    // ����f�Ô��񃌃R�[�h�����ԍ�2��
    private int _501007 = 0;

    // ���a��40��
    private String _501008 = "";

    // ���ʔԍ�2��-����f�Ô�̎��ʔԍ�
    private String _501009 = "";

    // �P�ʐ�4��
    private int _501010 = 0;

    // (�ی�)��2��
    private int _501011 = 0;

    // (�ی�)�T�[�r�X�P�ʐ�6��
    private int _501012 = 0;

    // (�ی�)���v�P�ʐ�8��
    private int _501013 = 0;

    // (����1)��2��
    private int _501014 = 0;

    // (����1)�T�[�r�X�P�ʐ�6��
    private int _501015 = 0;

    // (����1)���v�P�ʐ�8��
    private int _501016 = 0;

    // (����2)��2��
    private int _501017 = 0;

    // (����2)�T�[�r�X�P�ʐ�6��
    private int _501018 = 0;

    // (����2)���v�P�ʐ�8��
    private int _501019 = 0;

    // (����3)��2��
    private int _501020 = 0;

    // (����3)�T�[�r�X�P�ʐ�6��
    private int _501021 = 0;

    // (����3)���v�P�ʐ�8��
    private int _501022 = 0;

    // �E�v100��
    private String _501023 = "";

    // ����P����^�C�v
    private String _501024 = "";

    // ����Q����^�C�v
    private String _501025 = "";

    // ����R����^�C�v
    private String _501026 = "";

    // �V�X�e�����T�[�r�X��ރR�[�h
    private String _501027 = "";

    // ����ʌ���I�u�W�F�N�g
    private QP001RecordSupporter kohiManager = new QP001RecordSupporter();

    protected String getSerialId() {
        // TODO �����������ꂽ���\�b�h�E�X�^�u
        return null;
    }

    /**
     * ���R�[�h��ʃR�[�h2�����擾����B
     * 
     * @return
     */
    protected static String get_501002() {
        return _501002;
    }

    /**
     * ������񎯕ʔԍ�4�����擾����B
     * 
     * @return
     */
    protected String get_501001() {
        return _501001;
    }

    /**
     * ������񎯕ʔԍ�4����ݒ肷��B
     * 
     * @param _501001
     */
    protected void set_501001(String _501001) {
        this._501001 = _501001;
    }

    /**
     * �T�[�r�X�񋟔N��6��(YYYYMM)���擾����B
     * 
     * @return
     */
    protected String get_501003() {
        return _501003;
    }

    /**
     * �T�[�r�X�񋟔N��6��(YYYYMM)��ݒ肷��B
     * 
     * @param _501003
     */
    protected void set_501003(String _501003) {
        this._501003 = _501003;
    }

    /**
     * ���Ə��ԍ�10�����擾����B
     * 
     * @return
     */
    protected String get_501004() {
        return _501004;
    }

    /**
     * ���Ə��ԍ�10����ݒ肷��B
     * 
     * @param _501004
     */
    protected void set_501004(String _501004) {
        this._501004 = _501004;
    }

    /**
     * �؋L�ڕی��Ҕԍ�8�����擾����B
     * 
     * @return
     */
    protected String get_501005() {
        return _501005;
    }

    /**
     * �؋L�ڕی��Ҕԍ�8����ݒ肷��B
     * 
     * @param _501005
     */
    protected void set_501005(String _501005) {
        this._501005 = _501005;
    }

    /**
     * ��ی��Ҕԍ�10�����擾����B
     * 
     * @return
     */
    protected String get_501006() {
        return _501006;
    }

    /**
     * ��ی��Ҕԍ�10����ݒ肷��B
     * 
     * @param _501006
     */
    protected void set_501006(String _501006) {
        this._501006 = _501006;
    }

    /**
     * ����f�Ô��񃌃R�[�h�����ԍ�2�����擾����B
     */
    protected int get_501007() {
        return _501007;
    }

    /**
     * ����f�Ô��񃌃R�[�h�����ԍ�2����ݒ肷��B
     * 
     * @param _501007
     */
    protected void set_501007(int _501007) {
        this._501007 = _501007;
    }

    /**
     * ���a��40�����擾����B
     * 
     * @return
     */
    protected String get_501008() {
        return _501008;
    }

    /**
     * ���a��40����ݒ肷��B
     * 
     * @param _501008
     */
    protected void set_501008(String _501008) {
        this._501008 = _501008;
    }

    /**
     * ���ʔԍ�2��-����f�Ô�̎��ʔԍ����擾����B
     * 
     * @return
     */
    protected String get_501009() {
        return _501009;
    }

    /**
     * ���ʔԍ�2��-����f�Ô�̎��ʔԍ���ݒ肷��B
     * 
     * @param _501009
     */
    protected void set_501009(String _501009) {
        this._501009 = _501009;
    }

    /**
     * �P�ʐ�4�����擾����B
     * 
     * @return
     */
    protected int get_501010() {
        return _501010;
    }

    /**
     * �P�ʐ�4����ݒ肷��B
     * 
     * @param _501010
     */
    protected void set_501010(int _501010) {
        this._501010 = _501010;
    }

    /**
     * (�ی�)��2�����擾����B
     * 
     * @return
     */
    protected int get_501011() {
        return _501011;
    }

    /**
     * (�ی�)��2����ݒ肷��B
     * 
     * @param _501011
     */
    protected void set_501011(int _501011) {
        this._501011 = _501011;
    }

    /**
     * (�ی�)�T�[�r�X�P�ʐ�6�����擾����B
     * 
     * @return
     */
    protected int get_501012() {
        return _501012;
    }

    /**
     * (�ی�)�T�[�r�X�P�ʐ�6����ݒ肷��B
     * 
     * @param _501012
     */
    protected void set_501012(int _501012) {
        this._501012 = _501012;
    }

    /**
     * (�ی�)���v�P�ʐ�8�����擾����B
     * 
     * @return
     */
    protected int get_501013() {
        return _501013;
    }

    /**
     * (�ی�)���v�P�ʐ�8����ݒ肷��B
     * 
     * @param _501013
     */
    protected void set_501013(int _501013) {
        this._501013 = _501013;
    }

    /**
     * (����1)��2�����擾����B
     * 
     * @return
     */
    protected int get_501014() {
        return _501014;
    }

    /**
     * (����1)��2����ݒ肷��B
     */
    protected void set_501014(int _501014) {
        this._501014 = _501014;
    }

    /**
     * (����1)�T�[�r�X�P�ʐ�6�����擾����B
     * 
     * @return
     */
    protected int get_501015() {
        return _501015;
    }

    /**
     * (����1)�T�[�r�X�P�ʐ�6����ݒ肷��B
     * 
     * @param _501015
     */
    protected void set_501015(int _501015) {
        this._501015 = _501015;
    }

    /**
     * (����1)���v�P�ʐ�8�����擾����B
     * 
     * @return
     */
    protected int get_501016() {
        return _501016;
    }

    /**
     * (����1)���v�P�ʐ�8����ݒ肷��B
     * 
     * @param _501016
     */
    protected void set_501016(int _501016) {
        this._501016 = _501016;
    }

    /**
     * (����2)��2�����擾����B
     * 
     * @return
     */
    protected int get_501017() {
        return _501017;
    }

    /**
     * (����2)��2����ݒ肷��B
     * 
     * @param _501017
     */
    protected void set_501017(int _501017) {
        this._501017 = _501017;
    }

    /**
     * (����2)�T�[�r�X�P�ʐ�6�����擾����B
     * 
     * @return
     */
    protected int get_501018() {
        return _501018;
    }

    /**
     * (����2)�T�[�r�X�P�ʐ�6����ݒ肷��B
     * 
     * @param _501018
     */
    protected void set_501018(int _501018) {
        this._501018 = _501018;
    }

    /**
     * (����2)���v�P�ʐ�8�����擾����B
     * 
     * @return
     */
    protected int get_501019() {
        return _501019;
    }

    /**
     * (����2)���v�P�ʐ�8����ݒ肷��B
     */
    protected void set_501019(int _501019) {
        this._501019 = _501019;
    }

    /**
     * (����3)��2�����擾����B
     * 
     * @return
     */
    protected int get_501020() {
        return _501020;
    }

    /**
     * (����3)��2����ݒ肷��B
     * 
     * @param _501020
     */
    protected void set_501020(int _501020) {
        this._501020 = _501020;
    }

    /**
     * (����3)�T�[�r�X�P�ʐ�6�����擾����B
     * 
     * @return
     */
    protected int get_501021() {
        return _501021;
    }

    /**
     * (����3)�T�[�r�X�P�ʐ�6����ݒ肷��B
     * 
     * @param _501021
     */
    protected void set_501021(int _501021) {
        this._501021 = _501021;
    }

    /**
     * (����3)���v�P�ʐ�8�����擾����B
     * 
     * @return
     */
    protected int get_501022() {
        return _501022;
    }

    /**
     * (����3)���v�P�ʐ�8����ݒ肷��B
     * 
     * @param _501022
     */
    protected void set_501022(int _501022) {
        this._501022 = _501022;
    }

    /**
     * �E�v100�����擾����B
     * 
     * @return
     */
    protected String get_501023() {
        return _501023;
    }

    /**
     * �E�v100����ݒ肷��B
     * 
     * @param _501023
     */
    protected void set_501023(String _501023) {
        this._501023 = _501023;
    }

    /**
     * ����P����^�C�v���擾����B
     * 
     * @return
     */
    protected String get_501024() {
        return _501024;
    }

    /**
     * ����P����^�C�v��ݒ肷��B
     * 
     * @param _501024
     */
    protected void set_501024(String _501024) {
        this._501024 = _501024;
    }

    /**
     * ����Q����^�C�v���擾����B
     * 
     * @return
     */
    protected String get_501025() {
        return _501025;
    }

    /**
     * ����Q����^�C�v��ݒ肷��B
     * 
     * @param _501025
     */
    protected void set_501025(String _501025) {
        this._501025 = _501025;
    }

    /**
     * ����R����^�C�v���擾����B
     * 
     * @return
     */
    protected String get_501026() {
        return _501026;
    }

    /**
     * ����R����^�C�v��ݒ肷��B
     * 
     * @param _501026
     */
    protected void set_501026(String _501026) {
        this._501026 = _501026;
    }

    /**
     * �V�X�e�����T�[�r�X��ރR�[�h���擾����B
     * 
     * @return
     */
    protected String get_501027() {
        return _501027;
    }

    /**
     * �V�X�e�����T�[�r�X��ރR�[�h��ݒ肷��B
     * 
     * @param _501026
     */
    protected void set_501027(String _501027) {
        this._501027 = _501027;
    }

    protected VRMap getKohiList() {
        return this.kohiManager.getKohiList();
    }

    protected VRList getRealDays() {
        return this.kohiManager.getRealDays();
    }

// 2015/5/12 [Yoichiro Kamei] mod - begin ����֘A�������F�g�p���Ă��Ȃ��̂ŃR�����g��
//    protected VRMap getKohiPattern() {
//        return this.kohiManager.getKohiPattern();
//    }
// 2015/5/12 [Yoichiro Kamei] mod - end
    /**
     * ���ɏ�񂪓o�^����Ă��邩�ԋp���܂��B
     * 
     * @return �V�K:true �ǉ�:false
     */
    private boolean isNew() {
        // ������񃌃R�[�h�ɓo�^��������ΐV�K�Ƃ݂Ȃ��B
        return ((get_501001() == null) || ("".equals(get_501001())));
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
    //
    /*[H20.5 �@�����Ή�] fujihara edit start
    protected void parse(VRMap serviceDetail, Date targetDate,
            QP001PatientState patientState, VRMap serviceCode,
            String identificationNo, String specialClinicType,int count,QP001Manager manager) throws Exception {
    */
    protected void parse(VRMap serviceDetail, Date targetDate,
            QP001PatientState patientState, VRMap serviceCode,
            String identificationNo, String specialClinicType,int count,QP001Manager manager, int recordType) throws Exception {
    //[H20.5 �@�����Ή�] fujihara edit end

        Object targetServiceDate = VRBindPathParser.get("SERVICE_DATE",
                serviceDetail);

        if (isNew()) {
            // diagnosis �� KEY : 501001(������񎯕ʔԍ�) �� VALUE : ��U������ݒ肷��B
            set_501001(identificationNo);

            // diagnosis �� KEY : 501003(�T�[�r�X�񋟔N��) ��
            // VALUE : yyyyMM�`���Ƀt�H�[�}�b�g����targetDate��ݒ肷��B
            set_501003(VRDateParser.format(targetDate, "yyyyMM"));

            // diagnosis �� KEY : 501004(���Ə��ԍ�) ��
            // VALUE : 10���t�H�[�}�b�g�������Ə��ԍ�(serviceDetail���擾)��ݒ肷��B
            set_501004(ACCastUtilities.toString(VRBindPathParser.get(
                    "PROVIDER_ID", serviceDetail)));

            // diagnosis �� KEY : 501005(�؋L�ڕی��Ҕԍ�) ��
            // VALUE : 8���t�H�[�}�b�g�������p�҂̕ی��Ҕԍ�(patient���擾)��ݒ肷��B
            set_501005(patientState.getInsurerId(targetServiceDate));

            // diagnosis �� KEY : 501006(��ی��Ҕԍ�) ��
            // VALUE : 10���t�H�[�}�b�g�������p�҂̔�ی��Ҕԍ�(patient���擾)��ݒ肷��B
            set_501006(patientState.getInsuredId(targetServiceDate));

            // diagnosis �� KEY : 501010(�P�ʐ�) �� VALUE :
            // ���ʊ֐�(getSpecialClinicInfo)�Ŏ擾�����l��ݒ肷��B
            //[ID:0000454][Shin Fujihara] 2009/05/01 edit begin ��Q�Ή�
            //set_501010(QP001Manager.getInstance().getSpecialClinicUnit(specialClinicType));
            //[H20.5 �@�����Ή�] fujihara edit start
            //set_501010(manager.getSpecialClinicUnit(specialClinicType));
            //set_501010(manager.getSpecialClinicUnit(specialClinicType,recordType));
            //[H20.5 �@�����Ή�] fujihara edit end
            set_501010(manager.getSpecialClinicUnit(specialClinicType,recordType,get_501003()));
            //[ID:0000454][Shin Fujihara] 2009/05/01 edit end ��Q�Ή�
            
            // diagnosis �� KEY : 501011((�ی�)��) �ɃJ�E���g��ݒ肷��B
            set_501011(count);

            // �V�X�e�����T�[�r�X��ރR�[�h��ݒ肷��B
            set_501027(ACCastUtilities.toString(VRBindPathParser.get(
                    "SYSTEM_SERVICE_KIND_DETAIL", serviceCode)));

        } else {
            set_501011(get_501011() + count);
        }

        // ����ʂ̓o�^���s���B
//        kohiManager.setExtraData(targetServiceDate,serviceDetail, patientState, get_501027(),
//                "3", get_501010(),QP001Manager.getInstance().getProviderMedicalFlag(get_501004()),count);
//        kohiManager.setExtraData(targetServiceDate,serviceDetail, patientState, serviceCode,
//                "3", get_501010(),QP001Manager.getInstance().getProviderMedicalFlag(get_501004()),count);
        kohiManager.setExtraData(targetServiceDate,serviceDetail, patientState, serviceCode,
                "3", get_501010(),manager.getProviderMedicalFlag(get_501004()),count,manager);

    }
    
    
    /**
     * �V�X�e�����T�[�r�X��ރR�[�h�ʂł̉��W�v���s
     * @param kohi
     * @param patientState
     * @throws Exception
     */
    protected void commitRecord(QP001KohiKey[] kohi, QP001PatientState patientState) throws Exception {
        
        boolean kohiLimit = false;
        
        // (�ی�)�T�[�r�X�P�ʐ�6��(�P�ʐ�*��)
        set_501012(get_501010() * get_501011());
        // ����P����^�C�v
        if ((kohi[0] != null) && (!"".equals(kohi[0].getKohiType()))) {
            set_501024(kohi[0].getKohiType());
        }
        
        // ����Q����^�C�v
        if ((kohi[1] != null) && (!"".equals(kohi[1].getKohiType()))) {
            set_501025(kohi[1].getKohiType());
        }
        
        // ����R����^�C�v
        if ((kohi[2] != null) && (!"".equals(kohi[2].getKohiType()))) {
            set_501026(kohi[2].getKohiType());
        }
        

        // ����P�̓K�p�����邩�m�F
        if ((kohi[0] != null) && (!"".equals(kohi[0].getKohiType()))) {
            
            //[CCCX:1470][Shinobu Hitaka] 2014/02/10 edit - start �V���̈ꕔ����Ώۂ̑Ή�
            //�V���̈ꕔ����Ώہi88,87,66�j�̏ꍇ�͌���ݒ�����Ȃ�
            //�ȉ�IF����ǉ�
            if (!CareServiceCommon.isKouhiSystemService(get_501027(), kohi[0].getKohiType())) {
            //[CCCX:1470][Shinobu Hitaka] 2014/02/10 edit - end   �V���̈ꕔ����Ώۂ̑Ή�
                
                // �K�p������ꍇ
                // ����P�Ώۓ�����ݒ肷��B
                set_501014(kohiManager.getKohiCount(kohi[0]));
                // (����1)�T�[�r�X�P�ʐ�6��
                set_501015(get_501010() * get_501014());
                
                // ���t����100%�ɂȂ����珈�����I������B
                kohiLimit = (ACCastUtilities.toInt(patientState.getKohiData(kohi[0],"BENEFIT_RATE",1)) == 100);
            
            }
        }
        // ����Q�̓K�p�����邩�m�F
        if ((!kohiLimit) && (kohi[1] != null) && (!"".equals(kohi[1].getKohiType()))) {
            
            //[CCCX:1470][Shinobu Hitaka] 2014/02/10 edit - start �V���̈ꕔ����Ώۂ̑Ή�
            //�V���̈ꕔ����Ώہi88,87,66�j�̏ꍇ�͌���ݒ�����Ȃ�
            //�ȉ�IF����ǉ�
            if (!CareServiceCommon.isKouhiSystemService(get_501027(), kohi[1].getKohiType())) {
            //[CCCX:1470][Shinobu Hitaka] 2014/02/10 edit - end   �V���̈ꕔ����Ώۂ̑Ή�
                
                // �K�p������ꍇ
                // ����Q�Ώۓ�����ݒ肷��B
                set_501017(kohiManager.getKohiCount(kohi[1]));
                // (����2)�T�[�r�X�P�ʐ�6��
                set_501018(get_501010() * get_501017());
                
                // ���t����100%�ɂȂ����珈�����I������B
                kohiLimit = (ACCastUtilities.toInt(patientState.getKohiData(kohi[1],"BENEFIT_RATE",1)) == 100);
            
            }
            
        }
        // ����R�̓K�p�����邩�m�F
        if ((!kohiLimit) && (kohi[2] != null) && (!"".equals(kohi[2].getKohiType()))) {
            
            //[CCCX:1470][Shinobu Hitaka] 2014/02/10 edit - start �V���̈ꕔ����Ώۂ̑Ή�
            //�V���̈ꕔ����Ώہi88,87,66�j�̏ꍇ�͌���ݒ�����Ȃ�
            //�ȉ�IF����ǉ�
            if (!CareServiceCommon.isKouhiSystemService(get_501027(), kohi[2].getKohiType())) {
            //[CCCX:1470][Shinobu Hitaka] 2014/02/10 edit - end   �V���̈ꕔ����Ώۂ̑Ή�
                
                // �K�p������ꍇ
                // ����R�Ώۓ�����ݒ肷��B
                set_501020(kohiManager.getKohiCount(kohi[2]));
                // (����3)�T�[�r�X�P�ʐ�6��
                set_501021(get_501010() * get_501020());
                
            }
        }
        
    }

    /**
     * ���R�[�h���e�̊m����s���B
     */
    protected void commitRecord(QP001KohiKey[] kohi, int count,QP001PatientState patientState) throws Exception {
        boolean kohiLimit = false;
        
        set_501007(count);
        
        // (�ی�)�T�[�r�X�P�ʐ�6��(�P�ʐ�*��)
        set_501012(get_501010() * get_501011());
        // ����P����^�C�v
        if ((kohi[0] != null) && (!"".equals(kohi[0].getKohiType()))) {
            set_501024(kohi[0].getKohiType());
        }
        
        // ����Q����^�C�v
        if ((kohi[1] != null) && (!"".equals(kohi[1].getKohiType()))) {
            set_501025(kohi[1].getKohiType());
        }
        
        // ����R����^�C�v
        if ((kohi[2] != null) && (!"".equals(kohi[2].getKohiType()))) {
            set_501026(kohi[2].getKohiType());
        }
        

        // ����P�̓K�p�����邩�m�F
        if ((kohi[0] != null) && (!"".equals(kohi[0].getKohiType()))) {
            
            //[CCCX:1470][Shinobu Hitaka] 2014/02/10 edit - start �V���̈ꕔ����Ώۂ̑Ή�
            //�V���̈ꕔ����Ώہi88,87,66�j�̏ꍇ�͌���ݒ�����Ȃ�
            //�ȉ�IF����ǉ�
            if (!CareServiceCommon.isKouhiSystemService(get_501027(), kohi[0].getKohiType())) {
            //[CCCX:1470][Shinobu Hitaka] 2014/02/10 edit - end   �V���̈ꕔ����Ώۂ̑Ή�
                
                // �K�p������ꍇ
                // (����1)�T�[�r�X�P�ʐ�6��
                set_501015(get_501010() * get_501014());
                
                // ���t����100%�ɂȂ����珈�����I������B
                kohiLimit = (ACCastUtilities.toInt(patientState.getKohiData(kohi[0],"BENEFIT_RATE",1)) == 100);

            }
        }
        // ����Q�̓K�p�����邩�m�F
        if ((!kohiLimit) && (kohi[1] != null) && (!"".equals(kohi[1].getKohiType()))) {

            //[CCCX:1470][Shinobu Hitaka] 2014/02/10 edit - start �V���̈ꕔ����Ώۂ̑Ή�
            //�V���̈ꕔ����Ώہi88,87,66�j�̏ꍇ�͌���ݒ�����Ȃ�
            //�ȉ�IF����ǉ�
            if (!CareServiceCommon.isKouhiSystemService(get_501027(), kohi[1].getKohiType())) {
            //[CCCX:1470][Shinobu Hitaka] 2014/02/10 edit - end   �V���̈ꕔ����Ώۂ̑Ή�
                
                // �K�p������ꍇ
                // (����2)�T�[�r�X�P�ʐ�6��
                set_501018(get_501010() * get_501017());
                
                // ���t����100%�ɂȂ����珈�����I������B
                kohiLimit = (ACCastUtilities.toInt(patientState.getKohiData(kohi[1],"BENEFIT_RATE",1)) == 100);
            
            }
        }
        // ����R�̓K�p�����邩�m�F
        if ((!kohiLimit) && (kohi[2] != null) && (!"".equals(kohi[2].getKohiType()))) {

            //[CCCX:1470][Shinobu Hitaka] 2014/02/10 edit - start �V���̈ꕔ����Ώۂ̑Ή�
            //�V���̈ꕔ����Ώہi88,87,66�j�̏ꍇ�͌���ݒ�����Ȃ�
            //�ȉ�IF����ǉ�
            if (!CareServiceCommon.isKouhiSystemService(get_501027(), kohi[2].getKohiType())) {
            //[CCCX:1470][Shinobu Hitaka] 2014/02/10 edit - end   �V���̈ꕔ����Ώۂ̑Ή�
                
                // �K�p������ꍇ
                // (����3)�T�[�r�X�P�ʐ�6��
                set_501021(get_501010() * get_501020());
                
            }
        }
        
        //�E�v���̐ݒ���s���B
        //��܊Ǘ��w���̏ꍇ
        if("09".equals(get_501009()) || "9".equals(get_501009())){
            
            //���t����ׂȂ���
            ArrayList ary = new ArrayList();
            for(int i = 0; i < kohiManager.getRealDays().size(); i++){
                Integer day = new Integer(ACDateUtilities.getDayOfMonth(ACCastUtilities.toDate(kohiManager.getRealDays().get(i))));
                if(!ary.contains(day)){
                    ary.add(day);
                }
            }
            
            Object[] oa = ary.toArray();
            Arrays.sort(oa);
            StringBuilder tekiyoTemp = new StringBuilder();
            
            for(int i = 0; i < oa.length; i++){
                if(tekiyoTemp.length() != 0){
                	//�ȈՓ��͂ɂ��킹��
                    //tekiyoTemp.append("�A");
                	tekiyoTemp.append("�C");
                }
                //�S�p�Őݒ肵�Ȃ��ƕԗ�ɂȂ�B
                //tekiyoTemp.append(String.valueOf(oa[i]));
                tekiyoTemp.append(QP001Util.toWideNumber(oa[i]));
            }
            set_501023(tekiyoTemp.toString());
        }
        
        //���a�����p���Ή�
        //���R�[�h�����ԍ���1�̏ꍇ�͏��a����ݒ肷��B
        if(get_501007() == 1){
        	set_501008(patientState.getLastRecapitulationCategory5(get_501001()));
        }
        //�E�v�����p���Ή�
        //�d�x�f�ÊǗ��E�Z���W�����n�r�����Z
        if("35".equals(get_501009()) || "52".equals(get_501009())){
        	set_501023(patientState.getLastRecapitulationCategory5(get_501001(),get_501009()));
        }
    }

    /**
     * ���R�[�h�����ԍ�99�̏W�v���s���B
     * 
     * @param diagnosisMap
     * @throws Exception
     */
    protected void commitRecord(Map diagnosisMap,QP001PatientState patientState) throws Exception {
        QP001RecordDiagnosis diagnosis = null;
        // ���ʃ��R�[�h��99�ɕύX
        set_501007(99);
        Iterator it = diagnosisMap.keySet().iterator();
        while (it.hasNext()) {
            diagnosis = (QP001RecordDiagnosis) diagnosisMap.get(it.next());
            // (�ی�)���v�P�ʐ�8��
            set_501013(get_501013() + diagnosis.get_501012());
            // (����1)���v�P�ʐ�8��
            set_501016(get_501016() + diagnosis.get_501015());
            // (����2)���v�P�ʐ�8��
            set_501019(get_501019() + diagnosis.get_501018());
            // (����3)���v�P�ʐ�8��
            set_501022(get_501022() + diagnosis.get_501021());
        }
    }
    
    protected void merge(QP001RecordDiagnosis target) throws Exception {
        
        // (�ی�)��2��
        set_501011(get_501011() + target.get_501011());
        // (����1)��2��
        set_501014(get_501014() + target.get_501014());
        // (����2)��2��
        set_501017(get_501017() + target.get_501017());
        //(����3)��2��
        set_501020(get_501020() + target.get_501020());
        
        //������̃}�[�W
        kohiManager.getRealDays().addAll(target.getRealDays());
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
        setData(result, "501001", get_501001());
        // ���R�[�h��ʃR�[�h2��(04��ݒ�)
        setData(result, "501002", get_501002());
        // �T�[�r�X�񋟔N��6��(YYYYMM)
        setData(result, "501003", get_501003());
        // ���Ə��ԍ�10��
        setData(result, "501004", get_501004());
        // �؋L�ڕی��Ҕԍ�8��
        setData(result, "501005", get_501005());
        // ��ی��Ҕԍ�10��
        setData(result, "501006", get_501006());
        // ����f�Ô��񃌃R�[�h�����ԍ�2��
        setData(result, "501007", get_501007());
        // ���a��40��
        setData(result, "501008", get_501008());
        // ���ʔԍ�2������f�Ô�̎��ʔԍ�
        setData(result, "501009", get_501009());

        // �P�ʐ�4��
        setData(result, "501010", get_501010());
        // (�ی�)��2��
        setData(result, "501011", get_501011());
        // (�ی�)�T�[�r�X�P�ʐ�6��
        setData(result, "501012", get_501012());
        // (�ی�)���v�P�ʐ�8��
        setData(result, "501013", get_501013());
        // (����1)��2��
        setData(result, "501014", get_501014());
        // (����1)�T�[�r�X�P�ʐ�6��
        setData(result, "501015", get_501015());
        // (����1)���v�P�ʐ�8��
        setData(result, "501016", get_501016());
        // (����2)��2��
        setData(result, "501017", get_501017());
        // (����2)�T�[�r�X�P�ʐ�6��
        setData(result, "501018", get_501018());
        //(����2)���v�P�ʐ�8��
        setData(result, "501019", get_501019());

        //(����3)��2��
        setData(result, "501020", get_501020());
        //(����3)�T�[�r�X�P�ʐ�6��
        setData(result, "501021", get_501021());
        //(����3)���v�P�ʐ�8��
        setData(result, "501022", get_501022());
        //�E�v100��
        setData(result, "501023", get_501023());
        /*
         //����P����^�C�v
         setData(result,"501024",get_501024());
         //����Q����^�C�v
         setData(result,"501025",get_501025());
         //����R����^�C�v
         setData(result,"501026",get_501026());
         */
        //		setData(result,style,"501027",get_501027());
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
        //����f�Ô��񃌃R�[�h
        //result.put("CATEGORY_NO", "5");
        result.put("CATEGORY_NO", QkanConstants.CATEGORY_NO_RECORD_SPECIAL_TREATMENT);
        return result;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();

        result.append("[501001=" + get_501001() + "]\n");
        result.append("[501002=" + get_501002() + "]\n");
        result.append("[501003=" + get_501003() + "]\n");
        result.append("[501004=" + get_501004() + "]\n");
        result.append("[501005=" + get_501005() + "]\n");
        result.append("[501006=" + get_501006() + "]\n");
        result.append("[501007=" + get_501007() + "]\n");
        result.append("[501008=" + get_501008() + "]\n");
        result.append("[501009=" + get_501009() + "]\n");

        result.append("[501010=" + get_501010() + "]\n");
        result.append("[501011=" + get_501011() + "]\n");
        result.append("[501012=" + get_501012() + "]\n");
        result.append("[501013=" + get_501013() + "]\n");
        result.append("[501014=" + get_501014() + "]\n");
        result.append("[501015=" + get_501015() + "]\n");
        result.append("[501016=" + get_501016() + "]\n");
        result.append("[501017=" + get_501017() + "]\n");
        result.append("[501018=" + get_501018() + "]\n");
        result.append("[501019=" + get_501019() + "]\n");

        result.append("[501020=" + get_501020() + "]\n");
        result.append("[501021=" + get_501021() + "]\n");
        result.append("[501022=" + get_501022() + "]\n");
        result.append("[501023=" + get_501023() + "]\n");
        result.append("[501024=" + get_501024() + "]\n");
        result.append("[501025=" + get_501025() + "]\n");
        result.append("[501026=" + get_501026() + "]\n");

        return result.toString();
    }

}
