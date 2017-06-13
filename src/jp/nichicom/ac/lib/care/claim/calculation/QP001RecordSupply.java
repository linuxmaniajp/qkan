
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
 * �v���O���� ���t�Ǘ��[���R�[�h (QP001RecordSupply)
 *
 *****************************************************************
 */

package jp.nichicom.ac.lib.care.claim.calculation;

import java.util.Date;
import java.util.Iterator;
import java.util.Map;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.lib.care.claim.servicecode.CareServiceCommon;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.text.parsers.VRDateParser;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanConstants;

public class QP001RecordSupply extends QP001RecordAbstract {
    
    // ������񎯕ʔԍ�4��(����18�N4���ȑO8221�Œ�@����18�N4���ȍ~8222�Œ�)
    private String _1201001 = "";
    // �Ώ۔N��6��(YYYYMM)
    private String _1201002 = "";
    // �؋L�ڕی��Ҕԍ�8��
    private String _1201003 = "";
    //���Ə��ԍ�10��(������x�����Ə��A�������͉��\�h�x�����Ə�)
    private String _1201004 = "";
    // ���t�Ǘ��[���쐬�敪�R�[�h1���@1-�V�K 2-�C�� 3-���
    private int _1201005 = 0;
    // ���t�Ǘ��[�쐬�N����8��(YYYYMMDD)
    private String _1201006 = "";
    // ���t�Ǘ��[��ʋ敪�R�[�h1���@1-�K��ʏ��T�[�r�X���t�Ǘ��[ 2-�Z�������T�[�r�X���t�Ǘ��[ 3-����T�[�r�X�敪���t�Ǘ��[
    private int _1201007 = 0;
    // ���t�Ǘ��[���׍s�ԍ�2��
    private int _1201008 = 0;
    // ��ی��Ҕԍ�10��
    private String _1201009 = "";
    // ��ی��Ґ��N����8��(YYYYMMDD)
    private String _1201010 = "";
    // ���ʃR�[�h1���@1-�j 2-��
    private String _1201011 = "";
    // �v����ԋ敪�R�[�h2���@01-��Y�� 11-�v�x��(�o�ߓI�v���) 12-�v�x��1 13-�v�x��2 21-�v���1 22-�v���2 23-�v���3 24-�v���4 25-�v���5
    private String _1201012 = "";
    // ���x�z�K�p����(�J�n)6��(YYYYMM)
    private String _1201013 = "";
    // ���x�z�K�p����(�I��)6��(YYYYMM)
    private String _1201014 = "";
    // ����E���\�h�x�����x�z6��
    private String _1201015 = "";
    // ����T�[�r�X�v��쐬�敪�R�[�h1���@1-������x�����Ə��쐬�@2-���ȍ쐬�@3-���\�h�x�����Ə��쐬
    private int _1201016 = 0;
    // ���Ə��ԍ�(�T�[�r�X���Ə�)10��
    private String _1201017 = "";
    // �w��/��Y�������Ə��敪�R�[�h1���@1-�w�莖�Ə� 2-��Y�����Ə� 3-�����T�[�r�X���Ə� 4-���̑� 5-�n�斧���^�T�[�r�X
    private int _1201018 = 0;
    // �T�[�r�X��ރR�[�h2��
    private String _1201019 = "";
    // ���t�v��P�ʐ�/����6��
    private int _1201020 = 0;
    // ���x�z�Ǘ����Ԃɂ�����O���܂ł̋��t�v�����3��
    private String _1201021 = "";
    // �w��T�[�r�X�����v6��
    private String _1201022 = "";
    // ��Y���T�[�r�X�����v6��
    private String _1201023 = "";
    // ���t�v�捇�v�P�ʐ�/����6��
    private int _1201024 = 0;
    // �S�����x�������ԍ�
    private String _1201025 = "";
    // �ϑ���̋�����x�����Ə��ԍ�
    private String _1201026 = "";
    // �ϑ���̒S�����x�������ԍ�
    private String _1201027 = "";
    // �ی��Җ�
    private String _1201028 = "";
    // �T�[�r�X��ޖ�
    private String _1201029 = "";
    
    // �W�v�^�C�v
    //private int totalGroupintType = 0;
    private VRMap totalGroupintType = new VRHashMap();
    // �W�v�����t���O
    private boolean commited = false;
    
    //������z
    private int individualPayment = 0;

    /**
     * ������񎯕ʔԍ�4��(����18�N4���ȑO8221�Œ�@����18�N4���ȍ~8222�Œ�)���擾���܂��B
     * @return
     */
    protected String get_1201001() {
        return _1201001;
    }

    /**
     * ������񎯕ʔԍ�4��(����18�N4���ȑO8221�Œ�@����18�N4���ȍ~8222�Œ�)��ݒ肵�܂��B
     * @param _1201001
     */
    protected void set_1201001(String _1201001) {
        this._1201001 = _1201001;
    }

    /**
     * �Ώ۔N��6��(YYYYMM)���擾���܂��B
     * @return
     */
    protected String get_1201002() {
        return _1201002;
    }
    
    /**
     * �Ώ۔N��6��(YYYYMM)��ݒ肵�܂��B
     * @param _1201002
     */
    protected void set_1201002(String _1201002) {
        this._1201002 = _1201002;
    }

    /**
     * �؋L�ڕی��Ҕԍ�8�����擾���܂��B
     * @return
     */
    protected String get_1201003() {
        return _1201003;
    }

    /**
     * �؋L�ڕی��Ҕԍ�8����ݒ肵�܂��B
     * @param _1201003
     */
    protected void set_1201003(String _1201003) {
        this._1201003 = _1201003;
    }

    /**
     * ���Ə��ԍ�10��(������x�����Ə��A�������͉��\�h�x�����Ə�)���擾���܂��B
     * @return
     */
    protected String get_1201004() {
        return _1201004;
    }
    
    /**
     * ���Ə��ԍ�10��(������x�����Ə��A�������͉��\�h�x�����Ə�)��ݒ肵�܂��B
     * @param _1201004
     */
    protected void set_1201004(String _1201004) {
        this._1201004 = _1201004;
    }

    /**
     * ���t�Ǘ��[���쐬�敪�R�[�h1���@1-�V�K 2-�C�� 3-������擾���܂��B
     * @return
     */
    protected int get_1201005() {
        return _1201005;
    }

    /**
     * ���t�Ǘ��[���쐬�敪�R�[�h1���@1-�V�K 2-�C�� 3-�����ݒ肵�܂��B
     * @param _1201005
     */
    protected void set_1201005(int _1201005) {
        this._1201005 = _1201005;
    }

    /**
     * ���t�Ǘ��[�쐬�N����8��(YYYYMMDD)���擾���܂��B
     * @return
     */
    protected String get_1201006() {
        return _1201006;
    }

    /**
     * ���t�Ǘ��[�쐬�N����8��(YYYYMMDD)��ݒ肵�܂��B
     * @param _1201006
     */
    protected void set_1201006(String _1201006) {
        this._1201006 = _1201006;
    }

    /**
     * ���t�Ǘ��[��ʋ敪�R�[�h1��
     * 1-�K��ʏ��T�[�r�X���t�Ǘ��[ 2-�Z�������T�[�r�X���t�Ǘ��[ 3-����T�[�r�X�敪���t�Ǘ��[
     * ���擾���܂��B
     * @return
     */
    protected int get_1201007() {
        return _1201007;
    }

    /**
     * ���t�Ǘ��[��ʋ敪�R�[�h1��
     * 1-�K��ʏ��T�[�r�X���t�Ǘ��[ 2-�Z�������T�[�r�X���t�Ǘ��[ 3-����T�[�r�X�敪���t�Ǘ��[
     * ��ݒ肵�܂��B
     * @param _1201007
     */
    protected void set_1201007(int _1201007) {
        this._1201007 = _1201007;
    }

    /**
     * ���t�Ǘ��[���׍s�ԍ�2�����擾���܂��B
     * @return
     */
    protected int get_1201008() {
        return _1201008;
    }

    /**
     * ���t�Ǘ��[���׍s�ԍ�2����ݒ肵�܂��B
     * @param _1201008
     */
    protected void set_1201008(int _1201008) {
        this._1201008 = _1201008;
    }

    /**
     * ��ی��Ҕԍ�10�����擾���܂��B
     * @return
     */
    protected String get_1201009() {
        return _1201009;
    }

    /**
     * ��ی��Ҕԍ�10����ݒ肵�܂��B
     * @param _1201009
     */
    protected void set_1201009(String _1201009) {
        this._1201009 = _1201009;
    }

    /**
     * ��ی��Ґ��N����8��(YYYYMMDD)���擾���܂��B
     * @return
     */
    protected String get_1201010() {
        return _1201010;
    }

    /**
     * ��ی��Ґ��N����8��(YYYYMMDD)��ݒ肵�܂��B
     * @param _1201010
     */
    protected void set_1201010(String _1201010) {
        this._1201010 = _1201010;
    }

    /**
     * ���ʃR�[�h1���@1-�j 2-�����擾���܂��B
     * @return
     */
    protected String get_1201011() {
        return _1201011;
    }

    /**
     * ���ʃR�[�h1���@1-�j 2-����ݒ肵�܂��B
     * @param _1201011
     */
    protected void set_1201011(String _1201011) {
        this._1201011 = _1201011;
    }

    /**
     *  �v����ԋ敪�R�[�h2��
     * 01-��Y�� 11-�v�x��(�o�ߓI�v���) 12-�v�x��1 13-�v�x��2 21-�v���1 22-�v���2 23-�v���3 24-�v���4 25-�v���5
     * ���擾���܂��B
     * @return
     */
    protected String get_1201012() {
        return _1201012;
    }

    /**
     *  �v����ԋ敪�R�[�h2��
     * 01-��Y�� 11-�v�x��(�o�ߓI�v���) 12-�v�x��1 13-�v�x��2 21-�v���1 22-�v���2 23-�v���3 24-�v���4 25-�v���5
     * ��ݒ肵�܂��B
     * @param _1201012
     */
    protected void set_1201012(String _1201012) {
        this._1201012 = _1201012;
    }

    /**
     * ���x�z�K�p����(�J�n)6��(YYYYMM)���擾���܂��B
     * @return
     */
    protected String get_1201013() {
        return _1201013;
    }

    /**
     * ���x�z�K�p����(�J�n)6��(YYYYMM)��ݒ肵�܂��B
     * @param _1201013
     */
    protected void set_1201013(String _1201013) {
        this._1201013 = _1201013;
    }

    /**
     * ���x�z�K�p����(�I��)6��(YYYYMM)���擾���܂��B
     * @return
     */
    protected String get_1201014() {
        return _1201014;
    }

    /**
     * ���x�z�K�p����(�I��)6��(YYYYMM)��ݒ肵�܂��B
     * @param _1201014
     */
    protected void set_1201014(String _1201014) {
        this._1201014 = _1201014;
    }

    /**
     * ����E���\�h�x�����x�z6�����擾���܂��B
     * @return
     */
    protected String get_1201015() {
        return _1201015;
    }

    /**
     * ����E���\�h�x�����x�z6����ݒ肵�܂��B
     * @param _1201015
     */
    protected void set_1201015(String _1201015) {
        this._1201015 = _1201015;
    }

    /**
     * ����T�[�r�X�v��쐬�敪�R�[�h1��
     * 1-������x�����Ə��쐬�@2-���ȍ쐬�@3-���\�h�x�����Ə��쐬
     * ���擾���܂��B
     * @return
     */
    protected int get_1201016() {
        return _1201016;
    }

    /**
     * ����T�[�r�X�v��쐬�敪�R�[�h1��
     * 1-������x�����Ə��쐬�@2-���ȍ쐬�@3-���\�h�x�����Ə��쐬
     * ��ݒ肵�܂��B
     * @param _1201016
     */
    protected void set_1201016(int _1201016) {
        this._1201016 = _1201016;
    }

    /**
     * ���Ə��ԍ�(�T�[�r�X���Ə�)10�����擾���܂��B
     * @return
     */
    protected String get_1201017() {
        return _1201017;
    }

    /**
     *���Ə��ԍ�(�T�[�r�X���Ə�)10����ݒ肵�܂��B 
     * @param _1201017
     */
    protected void set_1201017(String _1201017) {
        this._1201017 = _1201017;
    }

    /**
     * �w��/��Y�������Ə��敪�R�[�h1��
     * 1-�w�莖�Ə� 2-��Y�����Ə� 3-�����T�[�r�X���Ə� 4-���̑� 5-�n�斧���^�T�[�r�X
     * ���擾���܂��B
     * @return
     */
    protected int get_1201018() {
        return _1201018;
    }

    /**
     * �w��/��Y�������Ə��敪�R�[�h1��
     * 1-�w�莖�Ə� 2-��Y�����Ə� 3-�����T�[�r�X���Ə� 4-���̑� 5-�n�斧���^�T�[�r�X
     * ��ݒ肵�܂��B
     * @param _1201018
     */
    protected void set_1201018(int _1201018) {
        this._1201018 = _1201018;
    }

    /**
     * �T�[�r�X��ރR�[�h2�����擾���܂��B
     * @return
     */
    protected String get_1201019() {
        return _1201019;
    }

    /**
     * �T�[�r�X��ރR�[�h2����ݒ肵�܂��B
     * @param _1201019
     */
    protected void set_1201019(String _1201019) {
        this._1201019 = _1201019;
    }

    /**
     * ���t�v��P�ʐ�/����6�����擾���܂��B
     * @return
     */
    protected int get_1201020() {
        return _1201020;
    }

    /**
     * ���t�v��P�ʐ�/����6����ݒ肵�܂��B
     * @param _1201020
     */
    protected void set_1201020(int _1201020) {
        this._1201020 = _1201020;
    }

    /**
     * ���x�z�Ǘ����Ԃɂ�����O���܂ł̋��t�v�����3�����擾���܂��B
     * @return
     */
    protected String get_1201021() {
        return _1201021;
    }

    /**
     * ���x�z�Ǘ����Ԃɂ�����O���܂ł̋��t�v�����3����ݒ肵�܂��B
     * @param _1201021
     */
    protected void set_1201021(String _1201021) {
        this._1201021 = _1201021;
    }

    /**
     * �w��T�[�r�X�����v6�����擾���܂��B
     * @return
     */
    protected String get_1201022() {
        return _1201022;
    }

    /**
     * �w��T�[�r�X�����v6����ݒ肵�܂��B
     * @param _1201022
     */
    protected void set_1201022(String _1201022) {
        this._1201022 = _1201022;
    }

    /**
     * ��Y���T�[�r�X�����v6�����擾���܂��B
     * @return
     */
    protected String get_1201023() {
        return _1201023;
    }

    /**
     * ��Y���T�[�r�X�����v6����ݒ肵�܂��B
     * @param _1201023
     */
    protected void set_1201023(String _1201023) {
        this._1201023 = _1201023;
    }

    /**
     * ���t�v�捇�v�P�ʐ�/����6�����擾���܂��B
     * @return
     */
    protected int get_1201024() {
        return _1201024;
    }

    /**
     * ���t�v�捇�v�P�ʐ�/����6����ݒ肵�܂��B
     * @param _1201024
     */
    protected void set_1201024(int _1201024) {
        this._1201024 = _1201024;
    }

    /**
     * �S�����x�������ԍ����擾���܂��B
     * @return
     */
    protected String get_1201025() {
        return _1201025;
    }

    /**
     * �S�����x�������ԍ���ݒ肵�܂��B
     * @param _1201025
     */
    protected void set_1201025(String _1201025) {
        this._1201025 = _1201025;
    }

    /**
     * �ϑ���̋�����x�����Ə��ԍ����擾���܂��B
     * @return
     */
    protected String get_1201026() {
        return _1201026;
    }

    /**
     * �ϑ���̋�����x�����Ə��ԍ���ݒ肵�܂��B
     * @param _1201026
     */
    protected void set_1201026(String _1201026) {
        this._1201026 = _1201026;
    }

    /**
     * �ϑ���̒S�����x�������ԍ����擾����B
     * @return
     */
    protected String get_1201027() {
        return _1201027;
    }

    /**
     * �ϑ���̒S�����x�������ԍ���ݒ肷��B
     * @param _1201027
     */
    protected void set_1201027(String _1201027) {
        this._1201027 = _1201027;
    }
    
    /**
     * �ی��Җ����擾���܂��B
     * @return
     */
    protected String get_1201028(){
        return _1201028;
    }
    
    /**
     * �ی��Җ���ݒ肵�܂��B
     * @param _1201028
     */
    protected void set_1201028(String _1201028){
        this._1201028 = _1201028;
    }
    
    /**
     * �T�[�r�X��ޖ����擾���܂��B
     * @return
     */
    protected String get_1201029(){
        return _1201029;
    }
    
    /**
     * �T�[�r�X��ޖ���ݒ肵�܂��B
     * @param _1201029
     */
    protected void set_1201029(String _1201029){
        this._1201029 = _1201029;
    }
    
    /**
     * ���ɏ�񂪓o�^����Ă��邩�ԋp���܂��B
     * 
     * @return �V�K:true �ǉ�:false
     */
    protected boolean isNew() {
        // ������񃌃R�[�h�ɓo�^��������ΐV�K�Ƃ݂Ȃ��B
        return ((get_1201001() == null) || ("".equals(get_1201001())));
    }
    /**
     * �������{���R�[�h�ɔ��f���������t���O
     */
    private boolean individualPaymentFlag = false;
    
    /**
     * �f�[�^�̃p�[�X�����s���܂��B
     * 
     * @param serviceDetail
     * @param targetDate
     * @param patientState
     * @param serviceCode
     * @throws Exception
     */
    //2007.2.8 fujihara.shin ��ԖK��^�̏�Q�Ή�
//    protected void parse(VRMap serviceDetail, Date targetDate,
//            QP001PatientState patientState, VRMap serviceCode,
//            String identificationNo,boolean first,QP001Manager manager) throws Exception {
    protected boolean parse(VRMap serviceDetail, Date targetDate,
            QP001PatientState patientState, VRMap serviceCode,
            String identificationNo,boolean first,QP001Manager manager) throws Exception {
    	
    	boolean result = first;

        Object targetServiceDate = VRBindPathParser.get("SERVICE_DATE",serviceDetail);
        
        // �f�[�^�ݒ�̉ۂ𔻒肷��B
        if(!isSetData(targetServiceDate,serviceCode)){
            return result;
        }
        
        //���x�z�K�p���Ԃ��擾�\�ł��邩�`�F�b�N���s���B
        //�J�n��
        if(ACTextUtilities.isNullText(patientState.getNinteiDataLast(patientState.getInsurerId(targetServiceDate), patientState.getInsuredId(targetServiceDate),"INSURE_VALID_START"))){
            return result;
        }
        //�I����
        if(ACTextUtilities.isNullText(patientState.getNinteiDataLast(patientState.getInsurerId(targetServiceDate), patientState.getInsuredId(targetServiceDate),"INSURE_VALID_END"))){
            return result;
        }
        
// [H27.4�����Ή�][Yoichiro Kamei] �Ŏ����Z�֘A�̉��Z�����ɑΉ� 2015/3/19 mod - begin
        // [CCCX:2915][Shinobu Hitaka] 2015/10/7 edit - begin  1��ڂ̊��������v�Z����Ȃ�
        //int reducedUnit = manager.getServiceUnit(get_1201017(),serviceCode);
        String providerID = get_1201017();
        if (ACTextUtilities.isNullText(providerID)) {
        	providerID = ACCastUtilities.toString(VRBindPathParser.get("PROVIDER_ID", serviceDetail));
        }
        int reducedUnit = manager.getServiceUnit(providerID,serviceCode);
        // [CCCX:2915][Shinobu Hitaka] 2015/10/7 edit - end  1��ڂ̊��������v�Z����Ȃ�
        
        String serviceCodeKind = ACCastUtilities.toString(serviceCode.get("SERVICE_CODE_KIND"));
        String serviceCodeItem = ACCastUtilities.toString(serviceCode.get("SERVICE_CODE_ITEM"));
        //�Ŏ��֘A�̉��Z�R�[�h�ł���΁A�P�ʐ��~���Z�����Ƃ���
        int serviceCount = QP001SpecialCase.getServiceCount(serviceCodeKind
            , serviceCodeItem
            , serviceDetail);                                                
        if (serviceCount > 1) {
            reducedUnit = reducedUnit * serviceCount;
        }
// [H27.4�����Ή�][Yoichiro Kamei] �Ŏ����Z�֘A�̉��Z�����ɑΉ� 2015/3/19 mod - end
        
        if (isNew()) {
            // �������ʔԍ���ݒ肷��B
            set_1201001(identificationNo);
            
            // �Ώ۔N������ݒ肷��B
            set_1201002(VRDateParser.format(targetDate, "yyyyMM"));
            
            // �؋L�ڕی��Ҕԍ�8����ݒ肵�܂��B
            set_1201003(patientState.getInsurerId(targetServiceDate));
            
            //��ی��Ҕԍ�10��
            set_1201009(patientState.getInsuredId(targetServiceDate));
            
            //���Ə��ԍ�10��(������x�����Ə��A�������͉��\�h�x�����Ə�)��ݒ肵�܂��B
            //set_1201004(patientState.getNinteiData(targetServiceDate, "PROVIDER_ID"));
            set_1201004(patientState.getNinteiDataLast(get_1201003(),get_1201009(),"PROVIDER_ID"));
            
            //���t�Ǘ��[���쐬�敪�R�[�h1���@1-�V�K 2-�C�� 3-�����ݒ肵�܂��B
            set_1201005(1);
            
            //���t�Ǘ��[�쐬�N����8��(YYYYMMDD)��ݒ肵�܂��B
            //������ECSV�o�͎��Ɍ���
            set_1201006("");
            
            //���t�Ǘ��[��ʋ敪�R�[�h1���@1-�K��ʏ��T�[�r�X���t�Ǘ��[ 2-�Z�������T�[�r�X���t�Ǘ��[ 3-����T�[�r�X�敪���t�Ǘ��[
            //3�Œ�
            set_1201007(3);
            
            //���t�Ǘ��[���׍s�ԍ�2��
            set_1201008(0);
            
//            //��ی��Ҕԍ�10��
//            set_1201009(patientState.getInsuredId(targetServiceDate));
            
            //��ی��Ґ��N����8��(YYYYMMDD)
            set_1201010(patientState.getPatientData("PATIENT_BIRTHDAY").replaceAll("-", ""));
            
            //���ʃR�[�h1���@1-�j 2-��
            set_1201011(patientState.getPatientData("PATIENT_SEX"));
            
            //�v����ԋ敪�R�[�h2���@01-��Y�� 06-���ƑΏێ� 11-�v�x��(�o�ߓI�v���) 12-�v�x��1 13-�v�x��2 21-�v���1 22-�v���2 23-�v���3 24-�v���4 25-�v���5
            //set_1201012(patientState.getNinteiDataLast(get_1201003(), get_1201009(),"JOTAI_CODE"));
            //�v���x�͓����̈�ԏd�����̂��̗p����B
            set_1201012(patientState.getNinteiDataHeavy(get_1201003(), get_1201009(),"JOTAI_CODE"));
                        
            //���x�z�K�p����(�J�n)6��(YYYYMM)
            //Date start = ACCastUtilities.toDate(patientState.getNinteiDataLast(get_1201003(), get_1201009(),"INSURE_VALID_START"));
            // [H27.4�����Ή�][Shinobu Hitaka] 2016/7/27 edit �����̈�ԏd�����̂��̗p����B
            Date start = ACCastUtilities.toDate(patientState.getNinteiDataHeavy(get_1201003(), get_1201009(),"INSURE_VALID_START"));
            set_1201013(VRDateParser.format(start, "yyyyMM"));
            
            //���x�z�K�p����(�I��)6��(YYYYMM)
            //Date end = ACCastUtilities.toDate(patientState.getNinteiDataLast(get_1201003(), get_1201009(),"INSURE_VALID_END"));
            // [H27.4�����Ή�][Shinobu Hitaka] 2016/7/27 edit �����̈�ԏd�����̂��̗p����B
            Date end = ACCastUtilities.toDate(patientState.getNinteiDataHeavy(get_1201003(), get_1201009(),"INSURE_VALID_END"));
            if (ACCastUtilities.toDate("9999/12/31").equals(end)) {
                // 9999-12-31�̏ꍇ�͋�
            	set_1201014("");
            } else {
                set_1201014(VRDateParser.format(end, "yyyyMM"));
            }
            
            // [H27.4�����Ή�][Shinobu Hitaka] 2016/7/26 del - begin �������ƑΉ��ɂ��R�����g��
            // [H27.4�����Ή�][Shinobu Hitaka] 2015/3/31 add - begin ���ƑΏێ҂���v�x���P�֕ύX���̑Ή�
            // �v�x���P
            //if (get_1201012().equals("12")) {
            //    // �Ώ۔N���ƌ��x�z�K�p����(�J�n)�N��������
            //    if (get_1201002().equals(get_1201013())) {
            //        // ���r��
            //        String tmpDay = VRDateParser.format(start, "dd");
            //        if (!"01".equals(tmpDay)) {
            //            String tmpJigyoFlg = patientState.getNinteiDataLast(get_1201003(), get_1201009(), "JIGYOTAISYO_FLAG");
            //            // ���ƑΏێ҃t���O��ON
            //            if ("2".equals(tmpJigyoFlg)) {
            //                // �v����ԋ敪�� 06-���ƑΏێ� �ɍ��ւ���
            //                set_1201012("06");
            //            }
            //        }
            //    }
            //}
            // [H27.4�����Ή�][Shinobu Hitaka] ���ƑΏێ҂���v�x���P�֕ύX���̑Ή� 2015/3/31 add - end
            // [H27.4�����Ή�][Shinobu Hitaka] 2016/7/26 del - end �������ƑΉ��ɂ��R�����g��
            
            //����E���\�h�x�����x�z6��
            //set_1201015(patientState.getNinteiDataLast(get_1201003(), get_1201009(),"LIMIT_RATE"));
            //���x�z�͓����̈�ԏd�����̂��̗p����B
            set_1201015(patientState.getNinteiDataHeavy(get_1201003(), get_1201009(),"LIMIT_RATE"));
            
            
// 2016/8/16 [�������ƑΉ�][Yoichiro Kamei] add - begin
            // ���ƑΏێ҂ŗv�x���P�̊�z�𒴂���ꍇ�́A����̗v�x���P�̊�z��ݒ肷��
            int limitRate = ACCastUtilities.toInt(get_1201015(), 0);
            int jotaiCode = ACCastUtilities.toInt(get_1201012(), 0);
            if (jotaiCode == QkanConstants.YOUKAIGODO_JIGYOTAISHO) {
                int jigyoTaishoLimitRate = manager.getJigyotaishoLimitRate();
                if (limitRate > jigyoTaishoLimitRate) {
                    //����E���\�h�x�����x�z6��
                    set_1201015(String.valueOf(jigyoTaishoLimitRate));
                }
            }
//2016/8/16 [�������ƑΉ�][Yoichiro Kamei] add - end
            
            //����T�[�r�X�v��쐬�敪�R�[�h1���@1-������x�����Ə��쐬�@2-���ȍ쐬�@3-���\�h�x�����Ə��쐬
            set_1201016(ACCastUtilities.toInt(patientState.getNinteiDataLast(get_1201003(), get_1201009(),"PLANNER")));
            
            //���Ə��ԍ�(�T�[�r�X���Ə�)10��
            set_1201017(ACCastUtilities.toString(VRBindPathParser.get("PROVIDER_ID", serviceDetail)));
            
            //�w��/��Y�������Ə��敪�R�[�h1���@1-�w�莖�Ə� 2-��Y�����Ə� 3-�����T�[�r�X���Ə� 4-���̑� 5-�n�斧���^�T�[�r�X
            //�n�斧���̃T�[�r�X�ł��邩�m�F����B
            if(QP001SpecialCase.isRegionStickingService(ACCastUtilities.toString(VRBindPathParser.get("SERVICE_CODE_KIND", serviceCode)))){
                //�n�斧���̃T�[�r�X�ł���΁A5-�n�斧���^�T�[�r�X���o�͂���B
                set_1201018(5);
            } else if (CareServiceCommon.isSogojigyoService(ACCastUtilities.toInt(VRBindPathParser.get("SYSTEM_SERVICE_KIND_DETAIL", serviceCode)))) {
                //�������Ƃ̃T�[�r�X�ł���΁A6-�������Ƃ��o�͂���B
                set_1201018(6);
            } else {
                set_1201018(manager.getProviderJigyouType(get_1201017()));
            }
            
            //�T�[�r�X��ރR�[�h2��
            set_1201019(ACCastUtilities.toString(VRBindPathParser.get("SERVICE_CODE_KIND", serviceCode)));
            
            //���t�v��P�ʐ�/����6��
            //set_1201020(QP001Manager.getInstance().getServiceUnit(get_1201017(),serviceCode) - ACCastUtilities.toInt(serviceDetail.get("REGULATION_RATE"),0));
// [H27.4�����Ή�][Yoichiro Kamei] �Ŏ����Z�֘A�̉��Z�����ɑΉ� 2015/3/19 mod - begin
//            set_1201020(manager.getServiceUnit(get_1201017(),serviceCode));
            set_1201020(reducedUnit);
// [H27.4�����Ή�][Yoichiro Kamei] �Ŏ����Z�֘A�̉��Z�����ɑΉ� 2015/3/19 mod - end
            
            //���x�z�Ǘ����Ԃɂ�����O���܂ł̋��t�v�����3��
            set_1201021("");
            //�w��T�[�r�X�����v6��
            set_1201022("");
            //��Y���T�[�r�X�����v6��
            set_1201023("");
            //���t�v�捇�v�P�ʐ�/����6��
            set_1201024(0);
            
            // �ی��Җ���
            set_1201028(manager.getInsurerName(get_1201003()));
            
            // �T�[�r�X��ޖ�
            set_1201029(manager.getServiceName(get_1201019()));


        } else {
// [H27.4�����Ή�][Yoichiro Kamei] �Ŏ����Z�֘A�̉��Z�����ɑΉ� 2015/3/19 mod - begin
//            set_1201020(get_1201020() + (manager.getServiceUnit(get_1201017(),serviceCode)));
        set_1201020(get_1201020() + reducedUnit);
// [H27.4�����Ή�][Yoichiro Kamei] �Ŏ����Z�֘A�̉��Z�����ɑΉ� 2015/3/19 mod - end
        }
        
        //������𔽉f������B
        if(first){
            individualPayment += ACCastUtilities.toInt(serviceDetail.get("REGULATION_RATE"),0);
            result = false;
        }
        
        return result;
    }
    
    //�f�[�^�ݒ�̉ۂ𔻒肷��B
    private boolean isSetData(Object targetServiceDate,VRMap serviceCode) throws Exception {
        
        boolean result = true;
        
        int type = ACCastUtilities.toInt(serviceCode.get("TOTAL_GROUPING_TYPE"),0);
        
        String key = String.valueOf(serviceCode.get("SYSTEM_SERVICE_KIND_DETAIL")) + "-"
                   + String.valueOf(serviceCode.get("SERVICE_CODE_KIND")) + "-"
                   + String.valueOf(serviceCode.get("SERVICE_CODE_ITEM"));
        
        //���o�^�̃T�[�r�X�ł���΃f�[�^��ݒ肷��B
        if(!totalGroupintType.containsKey(key)){
            VRList days = new VRArrayList();
            days.add(targetServiceDate);
            totalGroupintType.put(key,days);
            return result;
        }
        
        //�Z�胂�[�h�̊m�F
        switch(type){
            //1-�񐔒P��
            case 1:
                break;
            //2-���P��
            case 2:
                //���ɓ������ɓ��͂���Ă��邩�m�F
                VRList days = (VRList)totalGroupintType.get(key);
                if(days.contains(targetServiceDate)){
                    result = false;
                } else {
                    days.add(targetServiceDate);
                    totalGroupintType.put(key,days);
                }
                break;
            //3-���P��
            case 3:
                result = false;
                break;
            default:
                result = false;
                break;
        }
        
        return result;
    }

    /**
     * ���R�[�h�̃��j�[�N�ȃL�[��ԋp���܂��B
     */
    protected String getSerialId() {
        StringBuilder serial = new StringBuilder();
        // ������񎯕ʔԍ�4��
        serial.append(get_1201001());
        // �T�[�r�X�񋟔N��6��(YYYYMM)
        serial.append(get_1201002());
        // ���Ə��ԍ�10��
        serial.append(get_1201004());
        // �񋟎��Ə��ԍ�
        serial.append(get_1201017());
        // �T�[�r�X��ރR�[�h
        serial.append(get_1201019());
        return serial.toString();
    }
    
    /**
     * ���R�[�h�쐬�̉ۂ𔻒f����
     * @param identificationNo
     * @param targetDate
     * @param targetServiceDate
     * @param serviceDetail
     * @param serviceCode
     * @param patientState
     * @param supplyMap
     * @return
     * @throws Exception
     */
    protected static QP001RecordSupply getInstance(String identificationNo,
            Date targetDate, Object targetServiceDate, VRMap serviceDetail,
            VRMap serviceCode, QP001PatientState patientState,Map supplyMap) throws Exception {
        
        QP001RecordSupply supply = null;
        
        //���R�[�h�̍쐬�ۂ𔻒f
        if(!isMakeRecord(serviceCode,serviceDetail)){
            return supply;
        }
        
        String serial = getSerialId(identificationNo,
                                    targetDate,
                                    targetServiceDate,
                                    serviceDetail,
                                    patientState,
                                    serviceCode);
        
        //�����ɍ��v���郌�R�[�h�����݂��Ȃ��ꍇ
        if(!supplyMap.containsKey(serial)){
            supply = new QP001RecordSupply();
            supplyMap.put(serial,supply);
        //�����ɍ��v���郌�R�[�h�����݂���ꍇ
        } else {
            supply = (QP001RecordSupply)supplyMap.get(serial);
        }
        
        return supply;
    }
    
    private static boolean isMakeRecord(VRMap serviceCode,VRMap serviceDetail) throws Exception {
        
        //���t�Ǘ����x�z�Ώۃt���O���m�F����B
        //�t���O��1(���t�Ǘ����x�z�Ώ�)�ȊO�̏ꍇ�́A���R�[�h�̍쐬�𒆒f����B
        if(!String.valueOf(serviceCode.get("LIMIT_AMOUNT_OBJECT")).equals("1")){
            return false;
        }
        //30�����ł���΃��R�[�h�̍쐬�𒆒f����B
        if(ACCastUtilities.toInt(serviceDetail.get("5"),0) == 2){
            return false;
        }
        return true;
    }
    
    private static String getSerialId(String identificationNo,
            Date targetDate, Object targetServiceDate, VRMap serviceDetail,
            QP001PatientState patientState,VRMap serviceCode) throws Exception {
        //���R�[�h�̃V���A��ID���쐬
        StringBuilder serial = new StringBuilder();
//        // �������ʔԍ�
//        serial.append(identificationNo);
//        // �T�[�r�X�񋟔N��6��(YYYYMM)
//        serial.append(VRDateParser.format(targetDate, "yyyyMM"));
//        // ���Ə��ԍ�10��
//        serial.append(patientState.getNinteiData(targetServiceDate, "PROVIDER_ID"));
//        // �񋟎��Ə��ԍ�10��
//        serial.append(serviceDetail.get("PROVIDER_ID"));
//        // �T�[�r�X��ރR�[�h
//        serial.append(serviceCode.get("SERVICE_CODE_KIND"));
        
        // �������ʔԍ�
        serial.append(identificationNo);
        // �T�[�r�X�񋟔N��6��(YYYYMM)
        serial.append(VRDateParser.format(targetDate, "yyyyMM"));
        // �T�[�r�X��ރR�[�h
        serial.append(serviceCode.get("SERVICE_CODE_KIND"));
        // �񋟎��Ə��ԍ�10��
        serial.append(serviceDetail.get("PROVIDER_ID"));
        // ���Ə��ԍ�10��
        serial.append(patientState.getNinteiData(targetServiceDate, "PROVIDER_ID"));
        
        return serial.toString();
    }

    /**
     * ���R�[�h���e�̊m����s���B
     */
    protected void commitRecord() throws Exception {
        //������z�𔽉f���������m�F����B
        if(!individualPaymentFlag){
            //��������z�𔽉f
            set_1201020(get_1201020() - individualPayment);
            individualPaymentFlag = true;
        }
    }
    
    /**
     * ���R�[�h�ԍ�99�̌�����s���B
     * @param supplyMap
     * @throws Exception
     */
    protected void commitRecord(Map supplyMap) throws Exception {
        
        if(!commited){
            QP001RecordSupply supply = null;
            Iterator it = supplyMap.keySet().iterator();
            int count = 1;
            while(it.hasNext()){
                supply = (QP001RecordSupply)supplyMap.get(it.next());
                
                //���񃋁[�v���A�K�p�ȃf�[�^���R�s�[����B
                if(count == 1){
                    //�������ʔԍ�
                    set_1201001(supply.get_1201001());
                    //�Ώ۔N��
                    set_1201002(supply.get_1201002());
                    //�؋L�ڕی��Ҕԍ�
                    set_1201003(supply.get_1201003());
                    //���Ə��ԍ�
                    set_1201004(supply.get_1201004());
                    //���t�Ǘ��[�쐬�敪�R�[�h
                    set_1201005(supply.get_1201005());
                    //���t�Ǘ��[�쐬�N����
                    set_1201006(supply.get_1201006());
                    //���t�Ǘ��[��ʃR�[�h
                    set_1201007(supply.get_1201007());
                    //���t�Ǘ��[���׍s�ԍ�
                    set_1201008(99);
                    //��ی��Ҕԍ�
                    set_1201009(supply.get_1201009());
                    //��ی��Ґ��N����
                    set_1201010(supply.get_1201010());
                    //���ʃR�[�h
                    set_1201011(supply.get_1201011());
                    //�v����ԋ敪�R�[�h
                    set_1201012(supply.get_1201012());
                    //���x�z�E�v����(�J�n)
                    set_1201013(supply.get_1201013());
                    //���x�z�K�p����(�I��)
                    set_1201014(supply.get_1201014());
                    //����E���\�h�x�����x�z
                    set_1201015(supply.get_1201015());
                    //����T�[�r�X�v��쐬�敪�R�[�h
                    set_1201016(supply.get_1201016());
                    //�S�����x�������ԍ�
                    set_1201025(supply.get_1201025());
                    //�ϑ���̋�����x�����Ə��ԍ�
                    set_1201026(supply.get_1201026());
                    //�ϑ���̒S�����x�������ԍ�
                    set_1201027(supply.get_1201027());
                    
                    //�ی��Җ���
                    set_1201028(supply.get_1201028());
                    
                    
                }
                //�ݒ�l
                //���׏��s�ԍ���ݒ�
                supply.set_1201008(count);
                //���t�v�捇�v�P�ʐ�/����6��
                set_1201024(get_1201024() + supply.get_1201020());
                
                //�s�v�l
                //����E���\�h�x�����x�z
                supply.set_1201015("");
                //�S�����x�������ԍ�
                supply.set_1201025("");
                //�ϑ���̋�����x�����Ə��ԍ�
                supply.set_1201026("");
                //�ϑ���̒S�����x�������ԍ�
                supply.set_1201027("");
                
                
                count++;
            }
            
            commited = true;
        }

    }
    
    /**
     * �f�[�^�쐬
     * 
     * @param style
     * @return
     */
    protected VRMap getRecord(VRMap style) throws Exception {
        VRMap result = copyStyle(style);
        
        //������񎯕ʔԍ�4��(����18�N4���ȑO8221�Œ�@����18�N4���ȍ~8222�Œ�)
        setData(result, "1201001", get_1201001());
        //�Ώ۔N��6��(YYYYMM)
        setData(result, "1201002", get_1201002());
        //�؋L�ڕی��Ҕԍ�8��
        setData(result, "1201003", get_1201003());
        //���Ə��ԍ�10��(������x�����Ə��A�������͉��\�h�x�����Ə�)
        setData(result, "1201004", get_1201004());
        //���t�Ǘ��[���쐬�敪�R�[�h1���@1-�V�K 2-�C�� 3-���
        setData(result, "1201005", get_1201005());
        //���t�Ǘ��[�쐬�N����8��(YYYYMMDD)
        setData(result, "1201006", get_1201006());
        //���t�Ǘ��[��ʋ敪�R�[�h1���@1-�K��ʏ��T�[�r�X���t�Ǘ��[ 2-�Z�������T�[�r�X���t�Ǘ��[ 3-����T�[�r�X�敪���t�Ǘ��[
        setData(result, "1201007", get_1201007());
        //���t�Ǘ��[���׍s�ԍ�2��
        setData(result, "1201008", get_1201008());
        //��ی��Ҕԍ�10��
        setData(result, "1201009", get_1201009());
        
        //��ی��Ґ��N����8��(YYYYMMDD)
        setData(result, "1201010", get_1201010());
        //���ʃR�[�h1���@1-�j 2-��
        setData(result, "1201011", get_1201011());
        //�v����ԋ敪�R�[�h2���@01-��Y�� 11-�v�x��(�o�ߓI�v���) 12-�v�x��1 13-�v�x��2 21-�v���1 22-�v���2 23-�v���3 24-�v���4 25-�v���5
        setData(result, "1201012", get_1201012());
        //���x�z�K�p����(�J�n)6��(YYYYMM)
        setData(result, "1201013", get_1201013());
        //���x�z�K�p����(�I��)6��(YYYYMM)
        setData(result, "1201014", get_1201014());
        //����E���\�h�x�����x�z6��
        setData(result, "1201015", get_1201015());
        //����T�[�r�X�v��쐬�敪�R�[�h1���@1-������x�����Ə��쐬�@2-���ȍ쐬�@3-���\�h�x�����Ə��쐬
        setData(result, "1201016", get_1201016());
        //���Ə��ԍ�(�T�[�r�X���Ə�)10��
        setData(result, "1201017", get_1201017());
        //�w��/��Y�������Ə��敪�R�[�h1���@1-�w�莖�Ə� 2-��Y�����Ə� 3-�����T�[�r�X���Ə� 4-���̑� 5-�n�斧���^�T�[�r�X
        setData(result, "1201018", get_1201018());
        //�T�[�r�X��ރR�[�h2��
        setData(result, "1201019", get_1201019());
        
        //���t�v��P�ʐ�/����6��
        setData(result, "1201020", get_1201020());
        //���x�z�Ǘ����Ԃɂ�����O���܂ł̋��t�v�����3��
        setData(result, "1201021", get_1201021());
        //�w��T�[�r�X�����v6��
        setData(result, "1201022", get_1201022());
        //��Y���T�[�r�X�����v6��
        setData(result, "1201023", get_1201023());
        //���t�v�捇�v�P�ʐ�/����6��
        setData(result, "1201024", get_1201024());
        //�S�����x�������ԍ�
        setData(result, "1201025", get_1201025());
        //�ϑ���̋�����x�����Ə��ԍ�
        setData(result, "1201026", get_1201026());
        //�ϑ���̒S�����x�������ԍ�
        setData(result, "1201027", get_1201027());
        setData(result, "1201028", get_1201028());
        setData(result, "1201029", get_1201029());
        
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
        //���t�Ǘ��[��񃌃R�[�h
        //result.put("CATEGORY_NO", "12");
        result.put("CATEGORY_NO", QkanConstants.CATEGORY_NO_MANAGEMENT);
        return result;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        
        //������񎯕ʔԍ�4��(����18�N4���ȑO8221�Œ�@����18�N4���ȍ~8222�Œ�)
        result.append("[1201001=" + get_1201001() + "]\n");
        //�Ώ۔N��6��(YYYYMM)
        result.append("[1201002=" + get_1201002() + "]\n");
        //�؋L�ڕی��Ҕԍ�8��
        result.append("[1201003=" + get_1201003() + "]\n");
        //���Ə��ԍ�10��(������x�����Ə��A�������͉��\�h�x�����Ə�)
        result.append("[1201004=" + get_1201004() + "]\n");
        //���t�Ǘ��[���쐬�敪�R�[�h1���@1-�V�K 2-�C�� 3-���
        result.append("[1201005=" + get_1201005() + "]\n");
        //���t�Ǘ��[�쐬�N����8��(YYYYMMDD)
        result.append("[1201006=" + get_1201006() + "]\n");
        //���t�Ǘ��[��ʋ敪�R�[�h1���@1-�K��ʏ��T�[�r�X���t�Ǘ��[ 2-�Z�������T�[�r�X���t�Ǘ��[ 3-����T�[�r�X�敪���t�Ǘ��[
        result.append("[1201007=" + get_1201007() + "]\n");
        //���t�Ǘ��[���׍s�ԍ�2��
        result.append("[1201008=" + get_1201008() + "]\n");
        //��ی��Ҕԍ�10��
        result.append("[1201009=" + get_1201009() + "]\n");
        
        //��ی��Ґ��N����8��(YYYYMMDD)
        result.append("[1201010=" + get_1201010() + "]\n");
        //���ʃR�[�h1���@1-�j 2-��
        result.append("[1201011=" + get_1201011() + "]\n");
        //�v����ԋ敪�R�[�h2���@01-��Y�� 11-�v�x��(�o�ߓI�v���) 12-�v�x��1 13-�v�x��2 21-�v���1 22-�v���2 23-�v���3 24-�v���4 25-�v���5
        result.append("[1201012=" + get_1201012() + "]\n");
        //���x�z�K�p����(�J�n)6��(YYYYMM)
        result.append("[1201013=" + get_1201013() + "]\n");
        //���x�z�K�p����(�I��)6��(YYYYMM)
        result.append("[1201014=" + get_1201014() + "]\n");
        //����E���\�h�x�����x�z6��
        result.append("[1201015=" + get_1201015() + "]\n");
        //����T�[�r�X�v��쐬�敪�R�[�h1���@1-������x�����Ə��쐬�@2-���ȍ쐬�@3-���\�h�x�����Ə��쐬
        result.append("[1201016=" + get_1201016() + "]\n");
        //���Ə��ԍ�(�T�[�r�X���Ə�)10��
        result.append("[1201017=" + get_1201017() + "]\n");
        //�w��/��Y�������Ə��敪�R�[�h1���@1-�w�莖�Ə� 2-��Y�����Ə� 3-�����T�[�r�X���Ə� 4-���̑� 5-�n�斧���^�T�[�r�X
        result.append("[1201018=" + get_1201018() + "]\n");
        //�T�[�r�X��ރR�[�h2��
        result.append("[1201019=" + get_1201019() + "]\n");

        //���t�v��P�ʐ�/����6��
        result.append("[1201020=" + get_1201020() + "]\n");
        //���x�z�Ǘ����Ԃɂ�����O���܂ł̋��t�v�����3��
        result.append("[1201021=" + get_1201021() + "]\n");
        //�w��T�[�r�X�����v6��
        result.append("[1201022=" + get_1201022() + "]\n");
        //��Y���T�[�r�X�����v6��
        result.append("[1201023=" + get_1201023() + "]\n");
        //���t�v�捇�v�P�ʐ�/����6��
        result.append("[1201024=" + get_1201024() + "]\n");
        //�S�����x�������ԍ�
        result.append("[1201025=" + get_1201025() + "]\n");
        //�ϑ���̋�����x�����Ə��ԍ�
        result.append("[1201026=" + get_1201026() + "]\n");
        //�ϑ���̒S�����x�������ԍ�
        result.append("[1201027=" + get_1201027() + "]\n");
        result.append("[1201028=" + get_1201028() + "]\n");
        result.append("[1201029=" + get_1201029() + "]\n");
        
        return result.toString();
    }
    
}
