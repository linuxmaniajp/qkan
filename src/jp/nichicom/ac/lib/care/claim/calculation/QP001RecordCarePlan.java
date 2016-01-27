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
 * �v���O���� �l���掵���R�[�h (QP001RecordCarePlan)
 *
 *****************************************************************
 */

package jp.nichicom.ac.lib.care.claim.calculation;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

import jp.nichicom.ac.bind.ACBindUtilities;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.text.parsers.VRDateParser;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanConstants;
import jp.or.med.orca.qkan.QkanSystemInformation;

/**
 * �l���掵�p���R�[�h
 * ��싋�t������׏��i����T�[�r�X�v���j���
 */
public class QP001RecordCarePlan extends QP001RecordAbstract {
    // ������񎯕ʔԍ�4��
    private String _1001001 = "";
    // ���Ə��ԍ�10��
    private String _1001002 = "";
    // �w��/��Y�������Ə��敪�R�[�h1��
    // 1-�w�莖�Ə� 2-��Y�����Ə� 3-�����T�[�r�X���Ə� 4-���̑�"
    private int _1001003 = 0;
    // �T�[�r�X�񋟔N��6��(YYYYMM)
    private String _1001004 = "";
    // �؋L�ڕی��Ҕԍ�8��
    private String _1001005 = "";
    // �P�ʐ��P��4��
    private double _1001006 = 0;
    // ��ی��Ҕԍ�10��
    private String _1001007 = "";
    // ����S�Ҕԍ�8��
    private String _1001008 = "";
    // ����󋋎Ҕԍ�7��
    private String _1001009 = "";
    // ��ی��Ґ��N����8��(YYYYMMDD)
    private String _1001010 = "";
    // ���ʃR�[�h1�� 1-�j 2-��
    private String _1001011 = "";
    // �v����ԋ敪�R�[�h2��
    // 01-��Y�� 11-�v�x�� 21-�v���1 22-�v���2 23-�v���3 24-�v���4 25-�v���5"
    private String _1001012 = "";
    // �F��L������(�J�n)8��(YYYYMMDD)
    private String _1001013 = "";
    // �F��L������(�I��)8��(YYYYMMDD)
    private String _1001014 = "";
    // ����T�[�r�X�v��쐬�˗��͏o�N����8��(YYYYMMDD)
    private String _1001015 = "";
    // �T�[�r�X�R�[�h6��
    private String _1001016 = "";
    // �P�ʐ�6��
    private int _1001017 = 0;
    // �������z6��
    private int _1001018 = 0;
    //������(KOHI_TYPE)
    private String _1001019 = "";
    //�V�X�e���T�[�r�X��ރR�[�h
    private String _1001020 = "";
    //�V�X�e���T�[�r�X���ڃR�[�h
    private String _1001021 = "";
    //�S�����x�������ԍ�(������񎯕ʔԍ���8122�̏ꍇ�A�K�{)
    private String _1001022 = "";
    //�E�v
    private String _1001023 = "";
    
    //ID:0000447][Shin Fujihara] 2009/02 add begin ����21�N4���@�����Ή�
    //�T�[�r�X�v���׍s�ԍ�
    private int _1001024 = 0;
    //�P�ʐ�
    private int _1001025 = 0;
    //��
    private int _1001026 = 0;
    //�T�[�r�X�P�ʐ����v
    private int _1001027 = 0;
    //�T�[�r�X����
    private String _1001028 = "";
    //ID:0000447][Shin Fujihara] 2009/02 add end ����21�N4���@�����Ή�
    
    //�T�[�r�X�񋟓��@�����̎n�߂ɂ����ꂽ�T�[�r�X�̉��x�������ԍ����̗p���邽�߁A�ޔ�
    private Date serviceDate = null;
    

    /**
     * ������񎯕ʔԍ�4�����擾���܂��B
     * 
     * @return
     */
    protected String get_1001001() {
        return _1001001;
    }
    /**
     * ������񎯕ʔԍ�4����ݒ肵�܂��B
     * @param _1001001
     */
    protected void set_1001001(String _1001001) {
        this._1001001 = _1001001;
    }

    /**
     * ���Ə��ԍ�10�����擾���܂��B
     * 
     * @return
     */
    protected String get_1001002() {
        return _1001002;
    }

    /**
     * ���Ə��ԍ�10����ݒ肵�܂��B
     * 
     * @param _1001002
     */
    protected void set_1001002(String _1001002) {
        this._1001002 = _1001002;
    }

    /**
     * �w��/��Y�������Ə��敪�R�[�h1�� 1-�w�莖�Ə� 2-��Y�����Ə� 3-�����T�[�r�X���Ə� 4-���̑� ���擾���܂��B
     * 
     * @return
     */
    protected int get_1001003() {
        return _1001003;
    }

    /**
     * �w��/��Y�������Ə��敪�R�[�h1�� 1-�w�莖�Ə� 2-��Y�����Ə� 3-�����T�[�r�X���Ə� 4-���̑� ��ݒ肵�܂��B
     * 
     * @param _1001003
     */
    protected void set_1001003(int _1001003) {
        this._1001003 = _1001003;
    }

    /**
     * �T�[�r�X�񋟔N��6��(YYYYMM)���擾���܂��B
     * 
     * @return
     */
    protected String get_1001004() {
        return _1001004;
    }

    /**
     * �T�[�r�X�񋟔N��6��(YYYYMM)��ݒ肵�܂��B
     * 
     * @param _1001004
     */
    protected void set_1001004(String _1001004) {
        this._1001004 = _1001004;
    }

    /**
     * �؋L�ڕی��Ҕԍ�8�����擾���܂��B
     * 
     * @return
     */
    protected String get_1001005() {
        return _1001005;
    }

    /**
     * �؋L�ڕی��Ҕԍ�8����ݒ肵�܂��B
     * 
     * @param _1001005
     */
    protected void set_1001005(String _1001005) {
        this._1001005 = _1001005;
    }

    /**
     * �P�ʐ��P��4�����擾���܂��B
     * 
     * @return
     */
    protected double get_1001006() {
        return _1001006;
    }

    /**
     * �P�ʐ��P��4����ݒ肵�܂��B
     * 
     * @param _1001006
     */
    protected void set_1001006(double _1001006) {
        this._1001006 = _1001006;
    }

    /**
     * ��ی��Ҕԍ�10�����擾���܂��B
     * 
     * @return
     */
    protected String get_1001007() {
        return _1001007;
    }

    /**
     * ��ی��Ҕԍ�10����ݒ肵�܂��B
     * 
     * @param _1001007
     */
    protected void set_1001007(String _1001007) {
        this._1001007 = _1001007;
    }

    /**
     * ����S�Ҕԍ�8�����擾���܂��B
     * 
     * @return
     */
    protected String get_1001008() {
        return _1001008;
    }

    /**
     * ����S�Ҕԍ�8����ݒ肵�܂��B
     * 
     * @param _1001008
     */
    protected void set_1001008(String _1001008) {
        this._1001008 = _1001008;
    }

    /**
     * ����󋋎Ҕԍ�7�����擾���܂��B
     * 
     * @return
     */
    protected String get_1001009() {
        return _1001009;
    }

    /**
     * ����󋋎Ҕԍ�7����ݒ肵�܂��B
     * 
     * @param _1001009
     */
    protected void set_1001009(String _1001009) {
        this._1001009 = _1001009;
    }

    /**
     * ��ی��Ґ��N����8��(YYYYMMDD)���擾���܂��B
     * 
     * @return
     */
    protected String get_1001010() {
        return _1001010;
    }

    /**
     * ��ی��Ґ��N����8��(YYYYMMDD)��ݒ肵�܂��B
     * 
     * @param _1001010
     */
    protected void set_1001010(String _1001010) {
        this._1001010 = _1001010;
    }

    /**
     * ���ʃR�[�h1��1-�j 2-�����擾���܂��B
     * 
     * @return
     */
    protected String get_1001011() {
        return _1001011;
    }

    /**
     * ���ʃR�[�h1��1-�j 2-����ݒ肵�܂��B
     * 
     * @param _1001011
     */
    protected void set_1001011(String _1001011) {
        this._1001011 = _1001011;
    }

    /**
     * �v����ԋ敪�R�[�h2�� 01-��Y�� 11-�v�x�� 21-�v���1 22-�v���2 23-�v���3 24-�v���4 25-�v���5
     * ���擾���܂��B
     * 
     * @return
     */
    protected String get_1001012() {
        return _1001012;
    }

    /**
     * �v����ԋ敪�R�[�h2�� 01-��Y�� 11-�v�x�� 21-�v���1 22-�v���2 23-�v���3 24-�v���4 25-�v���5
     * ��ݒ肵�܂��B
     * 
     * @param _1001012
     */
    protected void set_1001012(String _1001012) {
        this._1001012 = _1001012;
    }

    /**
     * �F��L������(�J�n)8��(YYYYMMDD)���擾���܂��B
     * 
     * @return
     */
    protected String get_1001013() {
        return _1001013;
    }

    /**
     * �F��L������(�J�n)8��(YYYYMMDD)��ݒ肵�܂��B
     * 
     * @param _1001013
     */
    protected void set_1001013(String _1001013) {
        this._1001013 = _1001013;
    }

    /**
     * �F��L������(�I��)8��(YYYYMMDD)���擾���܂��B
     * 
     * @return
     */
    protected String get_1001014() {
        return _1001014;
    }

    /**
     * �F��L������(�I��)8��(YYYYMMDD)��ݒ肵�܂��B
     * 
     * @param _1001014
     */
    protected void set_1001014(String _1001014) {
        this._1001014 = _1001014;
    }

    /**
     * ����T�[�r�X�v��쐬�˗��͏o�N����8��(YYYYMMDD)���擾���܂��B
     * 
     * @return
     */
    protected String get_1001015() {
        return _1001015;
    }

    /**
     * ����T�[�r�X�v��쐬�˗��͏o�N����8��(YYYYMMDD)��ݒ肵�܂��B
     * 
     * @param _1001015
     */
    protected void set_1001015(String _1001015) {
        this._1001015 = _1001015;
    }

    /**
     * �T�[�r�X�R�[�h6�����擾���܂��B
     * 
     * @return
     */
    protected String get_1001016() {
        return _1001016;
    }

    /**
     * �T�[�r�X�R�[�h6����ݒ肵�܂��B
     * 
     * @param _1001016
     */
    protected void set_1001016(String _1001016) {
        this._1001016 = _1001016;
    }

    /**
     * �P�ʐ�6�����擾���܂��B
     * 
     * @return
     */
    protected int get_1001017() {
        return _1001017;
    }

    /**
     * �P�ʐ�6����ݒ肵�܂��B
     * 
     * @param _1001017
     */
    protected void set_1001017(int _1001017) {
        this._1001017 = _1001017;
    }

    /**
     * �������z6�����擾���܂��B
     * 
     * @return
     */
    protected int get_1001018() {
        return _1001018;
    }

    /**
     * �������z6����ݒ肵�܂��B
     * 
     * @param _1001018
     */
    protected void set_1001018(int _1001018) {
        this._1001018 = _1001018;
    }
    
    /**
     * ������(KOHI_TYPE)���擾���܂��B
     * @return
     */
    protected String get_1001019(){
        return _1001019;
    }
    
    /**
     * ������(KOHI_TYPE)��ݒ肵�܂��B
     * @param _1001019
     */
    protected void set_1001019(String _1001019){
        this._1001019 = _1001019;
    }

    /**
     * �V�X�e���T�[�r�X��ރR�[�h���擾���܂��B
     * @return
     */
    protected String get_1001020(){
        return _1001020;
    }
    
    /**
     * �V�X�e���T�[�r�X��ރR�[�h��ݒ肵�܂��B
     * @param _1001020
     */
    protected void set_1001020(String _1001020){
        this._1001020 = _1001020;
    }
    
    /**
     * �V�X�e���T�[�r�X���ڃR�[�h���擾���܂��B
     * @return
     */
    protected String get_1001021(){
        return _1001021;
    }
    
    /**
     * �V�X�e���T�[�r�X���ڃR�[�h��ݒ肵�܂��B
     * @param _1001021
     */
    protected void set_1001021(String _1001021){
        this._1001021 = _1001021;
    }
    
    /**
     * �S�����x�������ԍ�(������񎯕ʔԍ���8122�̏ꍇ�A�K�{)���擾���܂��B
     * @return
     */
    protected String get_1001022() {
        return _1001022;
    }
    
    /**
     * �S�����x�������ԍ�(������񎯕ʔԍ���8122�̏ꍇ�A�K�{)��ݒ肵�܂��B
     * @param _1001022
     */
    protected void set_1001022(String _1001022){
        this._1001022 = _1001022;
    }
    
    /**
     * �E�v���擾���܂��B
     * @return
     */
    protected String get_1001023() {
        return _1001023;
    }
    
    /**
     * �E�v��ݒ肵�܂��B
     * @param _1001023
     */
    protected void set_1001023(String _1001023){
        this._1001023 = _1001023;
    }
    
    //ID:0000447][Shin Fujihara] 2009/02 add begin ����21�N4���@�����Ή�
    /**
     * �T�[�r�X�v���׍s�ԍ����擾���܂��B
     * @return
     */
    protected int get_1001024() {
        return _1001024;
    }
    /**
     * �T�[�r�X�v���׍s�ԍ���ݒ肵�܂��B
     * @param _1001024
     */
    protected void set_1001024(int _1001024){
    	this._1001024 = _1001024;
    }
    /**
     * �P�ʐ����擾���܂��B
     * @return
     */
    protected int get_1001025() {
        return _1001025;
    }
    
    /**
     * �P�ʐ���ݒ肵�܂��B
     * @param _1001025
     */
    protected void set_1001025(int _1001025){
    	this._1001025 = _1001025;
    }
    
    /**
     * �񐔂��擾���܂��B
     * @return
     */
    protected int get_1001026() {
        return _1001026;
    }
    
    /**
     * �񐔂�ݒ肵�܂��B
     * @param _1001026
     */
    protected void set_1001026(int _1001026){
    	this._1001026 = _1001026;
    }
    
    /**
     * �T�[�r�X�P�ʐ����v���擾���܂��B
     * @return
     */
    protected int get_1001027() {
        return _1001027;
    }
    
    /**
     * �T�[�r�X�P�ʐ����v��ݒ肵�܂��B
     * @param _1001027
     */
    protected void set_1001027(int _1001027){
    	this._1001027 = _1001027;
    }
    /**
     * �T�[�r�X���̂��擾���܂��B
     * @return
     */
    protected String get_1001028() {
        return _1001028;
    }
    
    /**
     * �T�[�r�X���̂�ݒ肵�܂��B
     * @param _1001028
     */
    protected void set_1001028(String _1001028){
    	this._1001028 = _1001028;
    }
    //ID:0000447][Shin Fujihara] 2009/02 add add ����21�N4���@�����Ή�
    
    /**
     * �T�[�r�X�񋟓����擾���܂��B
     * @return
     */
    protected Date getServiceDate() {
        return serviceDate;
    }
    /**
     * �T�[�r�X�񋟓���ݒ肵�܂��B
     * @param serviceDate
     */
    protected void setServiceDate(Date serviceDate) {
        this.serviceDate = serviceDate;
    }

    protected String getSerialId() {
        StringBuilder result = new StringBuilder();

        // ������񎯕ʔԍ�4��
        result.append(get_1001001());
        // ���Ə��ԍ�10��
        result.append(get_1001002());
        // �T�[�r�X�񋟔N��6��(YYYYMM)
        result.append(get_1001004());
        // �؋L�ڕی��Ҕԍ�8��
        result.append(get_1001005());

        return result.toString();
    }
    
    //[ID:0000447][Shin Fujihara] 2009/02 edit begin ����21�N4���@�����Ή�
/*    protected static QP001RecordCarePlan getInstance(String identificationNo,
                                                        VRMap serviceDetail,
                                                        QP001PatientState patientState) throws Exception {*/
    protected static QP001RecordCarePlan getInstance(String identificationNo,
            VRMap serviceDetail,
            Date targetDate,
            QP001PatientState patientState,
            VRMap serviceCode,
            Map carePlanMap) throws Exception {
    //[ID:0000447][Shin Fujihara] 2009/02 edit end ����21�N4���@�����Ή�
    	
        QP001RecordCarePlan care = null;
        
        //���R�[�h�̍쐬�ۂ𔻒f
        if(!isMakeRecord(serviceDetail,VRBindPathParser.get("SERVICE_DATE",serviceDetail),patientState)){
            return care;
        }
        
        //[ID:0000447][Shin Fujihara] 2009/02 edit begin ����21�N4���@�����Ή�
        //H21.4�`�̗l���ł���ꍇ
        String serial = "20090331-before";
        if ("8124,8125".indexOf(identificationNo) != -1){
        	serial = getSerialId(identificationNo, targetDate, patientState,serviceCode);
        }
        
    	if (carePlanMap.containsKey(serial)){
    		care = (QP001RecordCarePlan)carePlanMap.get(serial);
    	} else {
    		care = new QP001RecordCarePlan();
    		carePlanMap.put(serial, care);
    	}
        //[ID:0000447][Shin Fujihara] 2009/02 edit end ����21�N4���@�����Ή�
        
        return care;
    }
    
    private static boolean isMakeRecord(VRMap serviceDetail,Object targetServiceDate,QP001PatientState patientState) throws Exception {
        
        // ����T�[�r�X�v��쐬�҂̋敪���擾����B
        // ��ی��҂��쐬���Ă���Ώ������s��Ȃ��B
        if ("2".equals(patientState.getNinteiData(targetServiceDate, "PLANNER"))){
            return false;
        }
        
        //���O�C�����Ə��ƔF�莖�Ə����قȂ��Ă���ꍇ�A�����𒆒f����B
        if(!QkanSystemInformation.getInstance().getLoginProviderID().equals(patientState.getNinteiData(targetServiceDate, "PROVIDER_ID"))){
            return false;
        }
        
        //���O�C�����Ə��ƍ쐬���Ə����قȂ��Ă���ꍇ�A�����𒆒f����B
        if(!QkanSystemInformation.getInstance().getLoginProviderID().equals(String.valueOf(serviceDetail.get("PROVIDER_ID")))){
            return false;
        }
        
        return true;
    }

    //[ID:0000447][Shin Fujihara] 2009/02 edit begin ����21�N4���@�����Ή�
    protected static String getSerialId(String identificationNo,
            Date targetServiceDate, QP001PatientState patientState,
            VRMap serviceCode)
            throws Exception {
    //[ID:0000447][Shin Fujihara] 2009/02 edit end ����21�N4���@�����Ή�

        StringBuilder serial = new StringBuilder();
        // �������ʔԍ�
        serial.append(identificationNo);
        // ���Ə��ԍ�10��
        serial.append(patientState.getNinteiData(targetServiceDate,
                "PROVIDER_ID"));
        // �T�[�r�X�񋟔N����
        serial.append(VRDateParser.format(targetServiceDate, "yyyyMM"));
        // �؋L�ڕی��Ҕԍ�8��
        serial.append(patientState.getInsurerId(targetServiceDate));
        
        //[ID:0000447][Shin Fujihara] 2009/02 add begin ����21�N4���@�����Ή�
        // �T�[�r�X��ރR�[�h
        serial.append(VRBindPathParser.get("SERVICE_CODE_KIND", serviceCode));
        // �T�[�r�X���ڃR�[�h
        serial.append(VRBindPathParser.get("SERVICE_CODE_ITEM", serviceCode));
        //[ID:0000447][Shin Fujihara] 2009/02 add end ����21�N4���@�����Ή�
        
        return serial.toString();
    }

    protected boolean isNew() {
        return ACTextUtilities.isNullText(get_1001002());
    }

    /**
     * �f�[�^�̉�͂��s���B
     * 
     * @param targetServiceDate
     * @param patientState
     * @throws Exception
     */
    protected void parse(VRMap serviceDetail, QP001PatientState patientState,
            VRMap serviceCode,String identificationNo,QP001Manager manager) throws Exception {
        
        // �T�[�r�X�񋟓�
        Date targetServiceDate = ACCastUtilities.toDate(VRBindPathParser.get(
                "SERVICE_DATE", serviceDetail));
        // �T�[�r�X�񋟌�(yyyyMM�^��)
        String targetMonth = VRDateParser.format(targetServiceDate, "yyyyMM");
        
        // ����T�[�r�X�v��쐬�҂̋敪���擾����B
        // ��ی��҂��쐬���Ă���Ώ������s��Ȃ��B
        if ("2".equals(patientState.getNinteiData(targetServiceDate, "PLANNER"))){
            return;
        }
        
        /*
         * [ID:0000702][Shin Fujihara] 2012/04 edit ����21�N4���@�����Ή�
         *  ���Z�̂ݎZ��ǉ��ɔ����A�啝�ɏC��
         */
        
        // �f�[�^�̉�͂�����̏ꍇ
        if (isNew()){
            //������񎯕ʔԍ�4����ݒ肵�܂��B
            set_1001001(identificationNo);
            
            // plan �� KEY : 1001002(���Ə��ԍ�) �� VALUE : 10���t�H�[�}�b�g�������Ə��ԍ���ݒ肷��B
            set_1001002(patientState
                    .getNinteiData(targetServiceDate, "PROVIDER_ID"));

            // plan �� KEY : 1001003(�w��/��Y�������Ə��敪�R�[�h1��) �� VALUE : �Y�����Ə��̎��Ƌ敪��ݒ肷��B
            set_1001003(manager.getProviderJigyouType(get_1001002()));

            // plan �� KEY : 1001004(�T�[�r�X�񋟔N��)�� VALUE :
            // yyyyMM�`���Ƀt�H�[�}�b�g����targetDate��ݒ肷��B
            set_1001004(VRDateParser.format(ACCastUtilities
                    .toDate(targetServiceDate), "yyyyMM"));

            // plan �� KEY : 1001005(�؋L�ڕی��Ҕԍ�)�� VALUE :
            // 8���t�H�[�}�b�g�������p�҂̕ی��Ҕԍ�(patient���擾)��ݒ肷��B
            set_1001005(patientState.getInsurerId(targetServiceDate));

            // plan �� KEY : 1001006(�P�ʐ��P��)�� VALUE : �n��P��(���ʊ֐����擾)��ݒ肷��B
            set_1001006(manager.getAreaUnitPrice(
                    get_1001002(),
                    ACCastUtilities.toString(VRBindPathParser.get(
                            "SYSTEM_SERVICE_KIND_DETAIL", serviceCode)),
                    targetMonth));

            // plan �� KEY : 1001007(��ی��Ҕԍ�)�� VALUE :
            // 10���t�H�[�}�b�g�������p�҂̔�ی��Ҕԍ�(patient���擾)��ݒ肷��B
            set_1001007(patientState.getInsuredId(targetServiceDate));
            
            //���p�҂����ےP�Ƃ̏ꍇ�A����̐ݒ���s���B
            if(patientState.isSeihoOnly(targetServiceDate)){
                VRList list = patientState.getKohiDataFromServiceKind(
                        targetServiceDate,
                        String.valueOf(serviceCode.get("SYSTEM_SERVICE_KIND_DETAIL")),
                        "1",
                        1,
                        manager.getProviderMedicalFlag(get_1001002()),
                        manager);
                
                if((list != null) && (list.size() != 0)){
                    VRMap kohi = (VRMap)list.get(0);
                    set_1001019(String.valueOf(kohi.get("KOHI_TYPE")));
// 2015/5/12 [Yoichiro Kamei] mod - begin ����֘A������
//                    set_1001008(patientState.getKohiData(get_1001019(),"KOHI_PAYER_NO",1));
//                    set_1001009(patientState.getKohiData(get_1001019(),"KOHI_RECIPIENT_NO",1));
                    QP001KohiKey kohiKey = new QP001KohiKey(kohi);
                    set_1001008(patientState.getKohiData(kohiKey,"KOHI_PAYER_NO",1));
                    set_1001009(patientState.getKohiData(kohiKey,"KOHI_RECIPIENT_NO",1));
// 2015/5/12 [Yoichiro Kamei] mod - end
                }
            }

            // plan �� KEY : 1001010(��ی��Ґ��N����)�� VALUE :
            // yyyyMMdd�`���Ƀt�H�[�}�b�g������ی��҂̐��N����(patient���擾)��ݒ肷��B
            set_1001010(patientState.getPatientData("PATIENT_BIRTHDAY").replaceAll(
                    "-", ""));

            // plan �� KEY : 1001011(���ʃR�[�h)�� VALUE : ��ی��҂̐���(patinet���擾)��ݒ肷��B
            set_1001011(patientState.getPatientData("PATIENT_SEX"));

            // plan �� KEY : 1001012(�v����ԋ敪�R�[�h)�� VALUE :
            // ��ی��҂̗v���敪�R�[�h(patient���擾)��ݒ肷��B
            set_1001012(patientState.getNinteiDataLast(get_1001005(), get_1001007(),
                    "JOTAI_CODE"));

            // plan �� KEY : 1001013(�F��L������(�J�n))�� VALUE :
            // yyyyMMdd�`���Ƀt�H�[�}�b�g�����F����Ԃ̊J�n��(patient���擾)��ݒ肷��B
            set_1001013(patientState.getNinteiDataLast(get_1001005(), get_1001007(),
                    "INSURE_VALID_START").replaceAll("-", ""));

            // plan �� KEY : 1001014(�F��L������(�I��))�� VALUE :
            // yyyyMMdd�`���Ƀt�H�[�}�b�g�����F����Ԃ̏I����(patient���擾)��ݒ肷��B
            set_1001014(patientState.getNinteiDataLast(get_1001005(), get_1001007(),
                    "INSURE_VALID_END").replaceAll("-", ""));

            // plan �� KEY : 1001015(����T�[�r�X�v��쐬�˗��͏o�N����)�� VALUE : yyyyMMdd
            // �`���Ƀt�H�[�}�b�g�����F����Ԃ̒�o��(patient)��ݒ肷��B
            //�����ےP�Ƃ̏ꍇ�́A�ݒ肵�Ȃ��Ă悢
            if(!QP001SpecialCase.isSeihoOnly(get_1001007())){
                set_1001015(patientState.getNinteiDataLast(get_1001005(), get_1001007(),
                "REPORTED_DATE").replaceAll("-", ""));
            }


            // plan �� KEY : 1001016(�T�[�r�X�R�[�h)�� VALUE : �T�[�r�X�R�[�h(serviceCode
            // ���擾)��ݒ肷��B
            set_1001016(ACCastUtilities.toString(ACCastUtilities
                    .toString(VRBindPathParser
                            .get("SERVICE_CODE_KIND", serviceCode))
                    + ACCastUtilities.toString(VRBindPathParser.get(
                            "SERVICE_CODE_ITEM", serviceCode))));

            // plan �� KEY : 1001017(�P�ʐ�)�� VALUE : �P�ʐ��P��(serviceCode ���擾)��ݒ肷��B
            set_1001017(manager.getServiceUnit(get_1001002(),
                    serviceCode));

            // plan �� KEY : 1001018(�������z)�� VALUE : �n��P��*�P�ʐ��P����ݒ肷��B
            BigDecimal temp = new BigDecimal(String.valueOf(get_1001006()));
            temp = temp.multiply(new BigDecimal("100"));
            //set_1001018((int) Math.floor((double)get_1001017() * get_1001006()));
            set_1001018((int)Math.floor((double)(get_1001017() * temp.intValue()) / 100d));

            //�V�X�e���T�[�r�X��ރR�[�h
            set_1001020(String.valueOf(serviceCode.get("SYSTEM_SERVICE_KIND_DETAIL")));
            //�V�X�e���T�[�r�X���ڃR�[�h
            set_1001021(String.valueOf(serviceCode.get("SYSTEM_SERVICE_CODE_ITEM")));
            //�S�����x�������ԍ�(������񎯕ʔԍ���8122�̏ꍇ�A�K�{)
            if(!ACTextUtilities.isNullText(serviceDetail.get("1430107"))){
                set_1001022(String.valueOf(serviceDetail.get("1430107")));
            }
            
            //�E�v
            set_1001023("");
            
            //�T�[�r�X�̒񋟓���ݒ肷��B
            setServiceDate(ACCastUtilities.toDate(serviceDetail.get("SERVICE_DATE"),null));
            
            //�P�ʐ�
            set_1001025(manager.getServiceUnit(get_1001002(),serviceCode));
            //��
            set_1001026(1);
            //�T�[�r�X���̂�ݒ肷��
            set_1001028(ACCastUtilities.toString(VRBindPathParser.get("SERVICE_NAME", serviceCode)));
            
        } else {
            
            //�������ʔԍ����l���掵�ŁA�����Z�̂ݎZ��̏ꍇ�́A�񐔂𑝂₷
            if (QP001StyleAbstract.IDENTIFICATION_NO_7_201204.equals(identificationNo)
                && (ACCastUtilities.toInt(VRBindPathParser.get("9", serviceDetail), 0) == 2)) {
                //��
                set_1001026(get_1001026() + 1);
            }
        }

    }
    
    protected void commitRecord() throws Exception {
        //�P�ʐ����v = �P�ʐ� * ��
        set_1001017(get_1001025() * get_1001026());
    }

    /**
     * �f�[�^�쐬
     * 
     * @param style
     * @return
     */
    protected VRMap getRecord(VRMap style) throws Exception {
        VRMap result = copyStyle(style);

        // ������񎯕ʔԍ�4��(8121�Œ�)
        setData(result, "1001001", get_1001001());
        // ���Ə��ԍ�10��
        setData(result, "1001002", get_1001002());
        // �w��/��Y�������Ə��敪�R�[�h1��
        setData(result, "1001003", get_1001003());
        // �T�[�r�X�񋟔N��6��(YYYYMM)
        setData(result, "1001004", get_1001004());
        // �؋L�ڕی��Ҕԍ�8��
        setData(result, "1001005", get_1001005());
        // �P�ʐ��P��4��
        setData(result, "1001006", get_1001006());
        // ��ی��Ҕԍ�10��
        setData(result, "1001007", get_1001007());
        // ����S�Ҕԍ�8��
        setData(result, "1001008", get_1001008());
        // ����󋋎Ҕԍ�7��
        setData(result, "1001009", get_1001009());

        // ��ی��Ґ��N����8��(YYYYMMDD)
        setData(result, "1001010", get_1001010());
        // ���ʃR�[�h1��1-�j 2-��
        setData(result, "1001011", get_1001011());
        // �v����ԋ敪�R�[�h2��
        setData(result, "1001012", get_1001012());
        // �F��L������(�J�n)8��(YYYYMMDD)
        setData(result, "1001013", get_1001013());
        // �F��L������(�I��)8��(YYYYMMDD)
        setData(result, "1001014", get_1001014());
        // ����T�[�r�X�v��쐬�˗��͏o�N����8��(YYYYMMDD)
        setData(result, "1001015", get_1001015());
        // �T�[�r�X�R�[�h6��
        setData(result, "1001016", get_1001016());
        // �P�ʐ�6��
        setData(result, "1001017", get_1001017());
        // �������z6��
        setData(result, "1001018", get_1001018());
        //������(KOHI_TYPE)
        setData(result, "1001019", get_1001019());
        //�V�X�e���T�[�r�X��ރR�[�h
        setData(result, "1001020", get_1001020());
        //�V�X�e���T�[�r�X���ڃR�[�h
        setData(result, "1001021", get_1001021());
        //�S�����x�������ԍ�(������񎯕ʔԍ���8122�̏ꍇ�A�K�{)
        setData(result, "1001022", get_1001022());
        //�E�v
        setData(result, "1001023", get_1001023());
        
		setData(result, "1001024", get_1001024());
		setData(result, "1001025", get_1001025());
		setData(result, "1001026", get_1001026());
		setData(result, "1001027", get_1001027());
		setData(result, "1001028", get_1001028());
		
		return result;
    }

    private VRMap copyStyle(VRMap style) throws Exception {
        VRMap result = new VRHashMap();
        Object key;
        // �f�B�[�v�R�s�[
        Iterator it = style.keySet().iterator();
        while (it.hasNext()) {
            key = it.next();
            result.put(key, style.get(key));
        }
        // ��싋�t������׏�(����T�[�r�X�v���)���
        //result.put("CATEGORY_NO", "10");
        result.put("CATEGORY_NO", QkanConstants.CATEGORY_NO_DETAILED_BENEFIT);
        // ���p�Ҕԍ�(��ی��Ҕԍ�)
        result.put("INSURED_ID", get_1001007());
        // �����̑ΏۂƂȂ�N��(�T�[�r�X�񋟔N��)
        result.put("TARGET_DATE", ACCastUtilities.toDate(get_1001004() + "01"));
        // �ی��Ҕԍ�
        result.put("INSURER_ID", get_1001005());
        // ���������Ə�
        result.put("PROVIDER_ID", get_1001002());

        return result;
    }
}