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
 * �v���O���� ���׏W�v���R�[�h (QP001RecordDetail)
 *
 *****************************************************************
 */

package jp.nichicom.ac.lib.care.claim.calculation;

import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.lib.care.claim.servicecode.CareServiceCommon;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.ac.util.ACDateUtilities;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.text.parsers.VRDateParser;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanConstants;

/**
 * ���׏W�v���R�[�h���
 * 
 * @author shin fujihara
 * 
 */
public class QP001RecordDetail extends QP001RecordAbstract {

    // ������񎯕ʔԍ�4��
    private String _301001 = "";

    // ���R�[�h��ʃR�[�h2��(02�Œ�)
    private static final String _301002 = "02";

    // �T�[�r�X�񋟔N��6��(YYYYMM)
    private String _301003 = "";

    // ���Ə��ԍ�10��
    private String _301004 = "";

    // �؋L�ڕی��Ҕԍ�8��
    private String _301005 = "";

    // ��ی��Ҕԍ�10��
    private String _301006 = "";

    // �T�[�r�X��ރR�[�h2��
    private String _301007 = "";

    // �T�[�r�X���ڃR�[�h4��
    private String _301008 = "";

    // �P�ʐ�4��
    private int _301009 = 0;

    // �������2��
    private int _301010 = 0;

    // ����1�Ώۓ����E��2��
    private int _301011 = 0;

    // ����2�Ώۓ����E��2��
    private int _301012 = 0;

    // ����3�Ώۓ����E��2��
    private int _301013 = 0;

    // �T�[�r�X�P�ʐ�6��
    private int _301014 = 0;

    // ����1�ΏۃT�[�r�X�P�ʐ�6��
    private int _301015 = 0;

    // ����2�ΏۃT�[�r�X�P�ʐ�6��
    private int _301016 = 0;

    // ����3�ΏۃT�[�r�X�P�ʐ�6��
    private int _301017 = 0;

    // �E�v20��
    private String _301018 = "";

    // �T�[�r�X����(�T�[�r�X�R�[�h�}�X�^TBL��SERVICE_NAME)
    private String _301019 = "";

    // ���x�z�Ǘ��Ώۃt���O
    private String _301020 = "";

    // �V�X�e�����T�[�r�X��ރR�[�h(SYSTEM_SERVICE_KIND_DETAIL)
    private String _301021 = "";

    // �V�X�e�����T�[�r�X���ڃR�[�h(SYSTEM_SERVICE_CODE_ITEM)
    private String _301022 = "";

    // ����1����^�C�v
    private String _301023 = "";

    // ����2����^�C�v
    private String _301024 = "";

    // ����3����^�C�v
    private String _301025 = "";

    // ���t����
    private int _301026 = 0;
    
    // �W�v�^�C�v
    private int totalGroupintType = 0;
    
    //���ʒn����Z�p
    private VRMap serviceUnitMap = new VRHashMap();

    // ����ʌ���I�u�W�F�N�g
    private QP001RecordSupporter kohiManager = new QP001RecordSupporter();
    
    // �E�v�L�ڎ����쐬�I�u�W�F�N�g
    private QP001Recapitulation recapitulation = new QP001Recapitulation();
    
    //[ID:0000467][Shin Fujihara] 2009/04 add begin ����21�N4���@�����Ή�
    //���R�Ԓn����Z�Z��I�u�W�F�N�g
    private QP001MountainousAreaAdder mountainousAreaAdder = new QP001MountainousAreaAdder();
    //[ID:0000467][Shin Fujihara] 2009/04 add end ����21�N4���@�����Ή�
    
    //[ID:0000682][Shin Fujihara] add begin �y�@�����Ή��z���E���������P���Z
    //�������P�P�ʐ��̌v�Z�Ɏg�p���銄��
    private int serviceUnit = 0;
    private int serviceStaffUnit = 0;
    //���R�[�h��� 3-���ʒn�� 6-���R�� 8-�������P
    private int serviceAddFlag = 0;
    //[ID:0000682][Shin Fujihara] add end �y�@�����Ή��z���E���������P���Z
    
    //[ID:0000730][Shin Fujihara] add begin  �y�T�[�r�X���p�[�ʕ\�E���яW�v�z���ȕ��S�������́��n���Z�̌v�Z�ɂ���
    //���ʒn��A���R�ԉ��Z�̍����ƂȂ�P�ʐ�
    private int additionBasisUnit = 0;
    //[ID:0000730][Shin Fujihara] add end
    /**
     * ������񎯕ʔԍ�4�����擾���܂��B
     * 
     * @return
     */
    protected String get_301001() {
        return _301001;
    }

    /**
     * ������񎯕ʔԍ�4����ݒ肵�܂��B
     * 
     * @param _301001
     */
    protected void set_301001(String _301001) {
        this._301001 = _301001;
    }

    /**
     * ���R�[�h��ʃR�[�h2�����擾���܂��B
     * 
     * @return
     */
    protected String get_301002() {
        return _301002;
    }

    /**
     * �T�[�r�X�񋟔N��6��(YYYYMM)���擾���܂��B
     * 
     * @return
     */
    protected String get_301003() {
        return _301003;
    }

    /**
     * �T�[�r�X�񋟔N��6��(YYYYMM)��ݒ肵�܂��B
     * 
     * @param _301003
     */
    protected void set_301003(String _301003) {
        this._301003 = _301003;
    }

    /**
     * ���Ə��ԍ�10�����擾���܂��B
     * 
     * @return
     */
    protected String get_301004() {
        return _301004;
    }

    /**
     * ���Ə��ԍ�10����ݒ肵�܂��B
     * 
     * @param _301004
     */
    protected void set_301004(String _301004) {
        this._301004 = _301004;
    }

    /**
     * �؋L�ڕی��Ҕԍ�8�����擾���܂��B
     * 
     * @return
     */
    protected String get_301005() {
        return _301005;
    }

    /**
     * �؋L�ڕی��Ҕԍ�8����ݒ肵�܂��B
     * 
     * @param _301005
     */
    protected void set_301005(String _301005) {
        this._301005 = _301005;
    }

    /**
     * ��ی��Ҕԍ�10�����擾���܂��B
     * 
     * @return
     */
    protected String get_301006() {
        return _301006;
    }

    /**
     * ��ی��Ҕԍ�10����ݒ肵�܂��B
     * 
     * @param _301006
     */
    protected void set_301006(String _301006) {
        this._301006 = _301006;
    }

    /**
     * �T�[�r�X��ރR�[�h2�����擾���܂��B
     * 
     * @return
     */
    protected String get_301007() {
        return _301007;
    }

    /**
     * �T�[�r�X��ރR�[�h2����ݒ肵�܂��B
     * 
     * @param _301007
     */
    protected void set_301007(String _301007) {
        this._301007 = _301007;
    }

    /**
     * �T�[�r�X���ڃR�[�h4�����擾���܂��B
     * 
     * @return
     */
    protected String get_301008() {
        return _301008;
    }

    /**
     * �T�[�r�X���ڃR�[�h4����ݒ肵�܂��B
     */
    protected void set_301008(String _301008) {
        this._301008 = _301008;
    }

    /**
     * �P�ʐ�4�����擾���܂��B
     * 
     * @return
     */
    protected int get_301009() {
        return _301009;
    }

    /**
     * �P�ʐ�4����ݒ肵�܂��B
     * 
     * @param _301009
     */
    protected void set_301009(int _301009) {
        this._301009 = _301009;
    }

    /**
     * �������2�����擾���܂��B
     * 
     * @return
     */
    protected int get_301010() {
        return _301010;
    }

    /**
     * �������2����ݒ肵�܂��B
     * 
     * @param _301010
     */
    protected void set_301010(int _301010) {
        this._301010 = _301010;
    }

    /**
     * ����1�Ώۓ����E��2�����擾���܂��B
     * 
     * @return
     */
    protected int get_301011() {
        return _301011;
    }

    /**
     * ����1�Ώۓ����E��2����ݒ肵�܂��B
     * 
     * @param _301011
     */
    protected void set_301011(int _301011) {
        this._301011 = _301011;
    }

    /**
     * ����2�Ώۓ����E��2�����擾���܂��B
     * 
     * @return
     */
    protected int get_301012() {
        return _301012;
    }

    /**
     * ����2�Ώۓ����E��2����ݒ肵�܂��B
     * 
     * @param _301012
     */
    protected void set_301012(int _301012) {
        this._301012 = _301012;
    }

    /**
     * ����3�Ώۓ����E��2�����擾���܂��B
     * 
     * @return
     */
    protected int get_301013() {
        return _301013;
    }

    /**
     * ����3�Ώۓ����E��2����ݒ肵�܂��B
     * 
     * @param _301013
     */
    protected void set_301013(int _301013) {
        this._301013 = _301013;
    }

    /**
     * �T�[�r�X�P�ʐ�6�����擾���܂��B
     * 
     * @return
     */
    protected int get_301014() {
        return _301014;
    }

    /**
     * �T�[�r�X�P�ʐ�6����ݒ肵�܂��B
     * 
     * @param _301014
     */
    protected void set_301014(int _301014) {
        this._301014 = _301014;
    }

    /**
     * ����1�ΏۃT�[�r�X�P�ʐ�6�����擾���܂��B
     * 
     * @return
     */
    protected int get_301015() {
        return _301015;
    }

    /**
     * ����1�ΏۃT�[�r�X�P�ʐ�6����ݒ肵�܂��B
     * 
     * @param _301015
     */
    protected void set_301015(int _301015) {
        this._301015 = _301015;
    }

    /**
     * ����2�ΏۃT�[�r�X�P�ʐ�6�����擾���܂��B
     * 
     * @return
     */
    protected int get_301016() {
        return _301016;
    }

    /**
     * ����2�ΏۃT�[�r�X�P�ʐ�6����ݒ肵�܂��B
     * 
     * @param _301016
     */
    protected void set_301016(int _301016) {
        this._301016 = _301016;
    }

    /**
     * ����3�ΏۃT�[�r�X�P�ʐ�6�����擾���܂��B
     * 
     * @return
     */
    protected int get_301017() {
        return _301017;
    }

    /**
     * ����3�ΏۃT�[�r�X�P�ʐ�6����ݒ肵�܂��B
     * 
     * @param _301017
     */
    protected void set_301017(int _301017) {
        this._301017 = _301017;
    }

    /**
     * �E�v20�����擾���܂��B
     * 
     * @return
     */
    protected String get_301018() {
        return _301018;
    }

    /**
     * �E�v20����ݒ肵�܂��B
     * 
     * @param _301018
     */
    protected void set_301018(String _301018) {
        this._301018 = _301018;
    }

    /**
     * �T�[�r�X����(�T�[�r�X�R�[�h�}�X�^TBL��SERVICE_NAME)���擾���܂��B
     * 
     * @return
     */
    protected String get_301019() {
        return _301019;
    }

    /**
     * �T�[�r�X����(�T�[�r�X�R�[�h�}�X�^TBL��SERVICE_NAME)��ݒ肵�܂��B
     * 
     * @param _301019
     */
    protected void set_301019(String _301019) {
        this._301019 = _301019;
    }

    /**
     * ���x�z�Ǘ��Ώۃt���O���擾���܂��B
     * 
     * @return
     */
    protected String get_301020() {
        return _301020;
    }

    /**
     * ���x�z�Ǘ��Ώۃt���O��ݒ肵�܂��B
     * 
     * @param _301020
     */
    protected void set_301020(String _301020) {
        this._301020 = _301020;
    }

    /**
     * �V�X�e�����T�[�r�X��ރR�[�h(SYSTEM_SERVICE_KIND_DETAIL)���擾���܂��B
     * 
     * @return
     */
    protected String get_301021() {
        return _301021;
    }

    /**
     * �V�X�e�����T�[�r�X��ރR�[�h(SYSTEM_SERVICE_KIND_DETAIL)��ݒ肵�܂��B
     * 
     * @param _301021
     */
    protected void set_301021(String _301021) {
        this._301021 = _301021;
    }

    /**
     * �V�X�e�����T�[�r�X���ڃR�[�h(SYSTEM_SERVICE_CODE_ITEM)���擾���܂��B
     * 
     * @return
     */
    protected String get_301022() {
        return _301022;
    }

    /**
     * �V�X�e�����T�[�r�X���ڃR�[�h(SYSTEM_SERVICE_CODE_ITEM)��ݒ肵�܂��B
     * 
     * @param _301022
     */
    protected void set_301022(String _301022) {
        this._301022 = _301022;
    }

    /**
     * ����1����^�C�v���擾���܂��B
     * 
     * @return
     */
    protected String get_301023() {
        return _301023;
    }

    /**
     * ����1����^�C�v��ݒ肵�܂��B
     * 
     * @param _301023
     */
    protected void set_301023(String _301023) {
        this._301023 = _301023;
    }

    /**
     * ����2����^�C�v���擾���܂��B
     * 
     * @return
     */
    protected String get_301024() {
        return _301024;
    }

    /**
     * ����2����^�C�v��ݒ肵�܂��B
     * 
     * @param _301024
     */
    protected void set_301024(String _301024) {
        this._301024 = _301024;
    }

    /**
     * ����3����^�C�v���擾���܂��B
     * 
     * @return
     */
    protected String get_301025() {
        return _301025;
    }

    /**
     * ����3����^�C�v��ݒ肵�܂��B
     * 
     * @param _301025
     */
    protected void set_301025(String _301025) {
        this._301025 = _301025;
    }

    /**
     * ���t�������擾���܂��B
     * 
     * @return
     */
    protected int get_301026() {
        return _301026;
    }

    /**
     * ���t������ݒ肵�܂��B
     * 
     * @param _301026
     */
    protected void set_301026(int _301026) {
        this._301026 = _301026;
    }
    
    /**
     * ���n���Z�Z�o�p��Map���擾����B
     * @return
     */
    protected VRMap getServiceUnitMap(){
    	return serviceUnitMap;
    }
    
    /**
     * ���n���Z�Z�o�p��Map��ݒ肷��B
     * @param serviceUnitMap
     */
    protected void setServiceUnitMap(VRMap serviceUnitMap){
    	this.serviceUnitMap = serviceUnitMap;
    }
    
    
    //[ID:0000682][Shin Fujihara] add begin �y�@�����Ή��z���E���������P���Z
    /**
     * ���ʒn��A���R�Ԃ̉��Z�����i���j
     * �������P�̉��Z�����i��j
     * @return
     */
    public int getServiceUnit() {
        return serviceUnit;
    }
    /**
     * �������P�̃L�����A�p�X�v�����̓K���󋵂ɉ�������t���i���j
     * @return
     */
    public int getServiceStaffUnit() {
        return serviceStaffUnit;
    }
    
    /**
     * �T�[�r�X�̉��Z�t���O
     * 3-���ʒn����Z 6-���R�� 8-�������P
     * @return
     */
    public int getServiceAddFlag() {
        return serviceAddFlag;
    }
    
    /**
     * �������P���R�[�h�ł��邩
     * @return
     */
    public boolean isSyoguRecoed() {
        return serviceAddFlag == 8;
    }
    
    /**
     * ���n���Z���R�[�h�ł��邩
     * @return
     */
    public boolean isTokuchi() {
        return serviceAddFlag == 3;
    }
    
    /**
     * ���R�ԉ��Z���R�[�h�ł��邩
     * @return
     */
    public boolean isMountainsArea() {
        return serviceAddFlag == 6;
    }
    //[ID:0000682][Shin Fujihara] add end �y�@�����Ή��z���E���������P���Z
    //[ID:0000730][Shin Fujihara] add begin  �y�T�[�r�X���p�[�ʕ\�E���яW�v�z���ȕ��S�������́��n���Z�̌v�Z�ɂ���
    /**
     * ���ʒn��A���R�ԁA�������P���Z�̍����ƂȂ�P�ʐ�
     * @return
     */
    public int getAdditionBasisUnit() {
        return additionBasisUnit;
    }
    
    /**
     * ���ʒn��A���R�ԁA�������P���Z�̍����ƂȂ�P�ʐ�
     * @return
     */
    public void setAdditionBasisUnit(int additionBasisUnit) {
        this.additionBasisUnit = additionBasisUnit;
    }
    //[ID:0000730][Shin Fujihara] add end
    

    /**
     * ���ɏ�񂪓o�^����Ă��邩�ԋp���܂��B
     * 
     * @return �V�K:true �ǉ�:false
     */
    private boolean isNew() {
        // ������񃌃R�[�h�ɓo�^��������ΐV�K�Ƃ݂Ȃ��B
        return ((get_301001() == null) || ("".equals(get_301001())));
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
        
        // �f�[�^�ݒ�̉ۂ𔻒肷��B
        if(!isSetData(targetServiceDate,serviceCode)){
            //���t�̐ݒ�̂ݍs���B
        	//[ID:0000586][Shin Fujihara] 2010/01 edit begin 2009�N�x�Ή�
        	//�T�[�r�X�R�[�h�̏����K�v�ɂȂ邽�߁A�����ɒǉ�
            //kohiManager.setDate(targetServiceDate,serviceDetail);
        	kohiManager.setDate(targetServiceDate,serviceDetail,serviceCode);
            //[ID:0000586][Shin Fujihara] 2010/01 edit end 2009�N�x�Ή�
            return;
        }
        
        int serviceCount = 1;
        
        // ���R�[�h���V�K�쐬�ł��邩�m�F
        if (isNew()) {
            
            // type �� KEY : 301001(������񎯕ʔԍ�4��) �� VALUE : ��U������ݒ肷��B
            set_301001(identificationNo);

            // type �� KEY : 301003(�T�[�r�X�񋟔N��) ��
            // VALUE : yyyyMM�`���Ƀt�H�[�}�b�g����targetDate��ݒ肷��B
            set_301003(VRDateParser.format(targetDate, "yyyyMM"));

            // type �� KEY : 301004(���Ə��ԍ�) ��
            // VALUE : 10���t�H�[�}�b�g�������Ə��ԍ�(serviceDetail���擾)��ݒ肷��B
            set_301004(ACCastUtilities.toString(VRBindPathParser.get(
                    "PROVIDER_ID", serviceDetail)));

            // type �� KEY : 301005(�؋L�ڕی��Ҕԍ�) ��
            // VALUE : 8���t�H�[�}�b�g�������p�҂̕ی��Ҕԍ�(patient���擾)��ݒ肷��B
            set_301005(patientState.getInsurerId(targetServiceDate));

            // type �� KEY : 301006(��ی��Ҕԍ�) ��
            // VALUE : 10���t�H�[�}�b�g�������p�҂̔�ی��Ҕԍ�(patient���擾)��ݒ肷��B
            set_301006(patientState.getInsuredId(targetServiceDate));

            // type �� KEY : 301007(�T�[�r�X��ރR�[�h) ��
            // VALUE : 2���t�H�[�}�b�g�����T�[�r�X��ރR�[�h(serviceCode���擾)��ݒ肷��B
            set_301007(ACCastUtilities.toString(VRBindPathParser.get(
                    "SERVICE_CODE_KIND", serviceCode)));

            // type �� KEY : 301008(�T�[�r�X���ڃR�[�h) ��
            // VALUE : 4���t�H�[�}�b�g�����T�[�r�X���ڃR�[�h(serviceCode���擾)��ݒ肷��B
            set_301008(ACCastUtilities.toString(VRBindPathParser.get(
                    "SERVICE_CODE_ITEM", serviceCode)));

            // type �� KEY : 301009(�P�ʐ�) ��
            // VALUE : 4���t�H�[�}�b�g�����P�ʐ�(serviceDetail���擾)��ݒ肷��B
            // set_301009(ACCastUtilities.toInt(VRBindPathParser.get("SERVICE_UNIT",serviceCode)));
            //[ID:0000682][Shin Fujihara] delete begin �y�@�����Ή��z���E���������P���Z
//            //���Z���m�F
//            if(ACCastUtilities.toInt(serviceCode.get("SERVICE_ADD_FLAG"),0) != 3){
//                set_301009(manager.getServiceUnit(get_301004(),
//                        serviceCode));
//            } else {
//                set_301009(ACCastUtilities.toInt(serviceCode.get("SERVICE_UNIT"),0));
//            }
            //[ID:0000682][Shin Fujihara] delete end �y�@�����Ή��z���E���������P���Z
            
            //[ID:0000682][Shin Fujihara] add begin �y�@�����Ή��z���E���������P���Z
            serviceAddFlag = ACCastUtilities.toInt(serviceCode.get("SERVICE_ADD_FLAG"),0);
            //���Z���m�F
            if(serviceAddFlag != 3){
                set_301009(manager.getServiceUnit(get_301004(), serviceCode));
            } else {
                set_301009(ACCastUtilities.toInt(serviceCode.get("SERVICE_UNIT"),0));
            }
            //[ID:0000682][Shin Fujihara] add end �y�@�����Ή��z���E���������P���Z

            // type �� KEY : 301019(�T�[�r�X����) ��
            // VALUE : �T�[�r�X�R�[�h�}�X�^TBL��SERVICE_NAME��ݒ肷��B
            set_301019(ACCastUtilities.toString(VRBindPathParser.get(
                    "SERVICE_NAME", serviceCode)));

            // type �� KEY : 301020(���x�z�Ǘ��Ώۃt���O) ��
            // VALUE : ���x�z�Ǘ��Ώۃt���O(serviceCode���擾)��ݒ肷��B
            set_301020(ACCastUtilities.toString(VRBindPathParser.get(
                    "LIMIT_AMOUNT_OBJECT", serviceCode)));

            // tyep �� KEY : 301021(�V�X�e�����T�[�r�X��ރR�[�h)��
            // VALUE �V�X�e�����T�[�r�X��ރR�[�h(serviceCode���擾)��ݒ肷��B
            set_301021(ACCastUtilities.toString(VRBindPathParser.get(
                    "SYSTEM_SERVICE_KIND_DETAIL", serviceCode)));

            // type �� KEY : 301022(�V�X�e�����T�[�r�X���ڃR�[�h)��
            // VALUE �V�X�e�����T�[�r�X���ڃR�[�h(serviceCode���擾)��ݒ肷��B
            set_301022(ACCastUtilities.toString(VRBindPathParser.get(
                    "SYSTEM_SERVICE_CODE_ITEM", serviceCode)));

            // ���t������ݒ肷��B
            if(!ACTextUtilities.isNullText(patientState.getNinteiData(targetServiceDate,"INSURE_RATE"))){
                set_301026(Integer.parseInt(patientState.getNinteiData(targetServiceDate,
                "INSURE_RATE")));
            } else {
                set_301026(0);
            }
            
            //�T�[�r�X�̉񐔂�ݒ�(�����Ō���Z�Ή�)
            //[ID:0000720][Shin Fujihara] 2012/04 delete start 2012�N�x�Ή�
            // QP001SpecialCase�ɏ������ړ�
//            if("Z6276".equals(get_301022()) || "Z6277".equals(get_301022())){
//                if("51".equals(get_301007())){
//                    serviceCount = ACCastUtilities.toInt(serviceDetail.get("1510132"),1);
//                } else if("54".equals(get_301007())){
//                    serviceCount = ACCastUtilities.toInt(serviceDetail.get("1540128"),1);
//                }
//            }
            //[ID:0000720][Shin Fujihara] 2012/04 delete end 2012�N�x�Ή�
            //[ID:0000720][Shin Fujihara] 2012/04 add start 2012�N�x�Ή�
            serviceCount = QP001SpecialCase.getServiceCount(get_301007(), get_301008(), serviceDetail);
            //[ID:0000720][Shin Fujihara] 2012/04 delete end 2012�N�x�Ή�
            
            set_301010(serviceCount);
            
            //[ID:0000561][Shin Fujihara] 2010/01 del begin 2009�N�x�Ή�
            // �E�v�L�ڎ����̃f�[�^�쐬���s��
            //recapitulation.setRecapitulation(serviceDetail,serviceCode,manager);
            //[ID:0000561][Shin Fujihara] 2010/01 del begin 2009�N�x�Ή�
            
            //�����p��̓K�p�ݒ�
            //�V���A�������̂��߁A�b��I�ɓ���Ă���
            //���R�[�h�m�莞�Ƀf�[�^��{���̓E�v�ɕύX����B
            if(serviceDetail.containsKey("1170104")){
                //��ʏ�̕����p��E�v���ɓ��͂�����ꍇ
                if(!ACTextUtilities.isNullText(serviceDetail.get("1170104"))){
                    //�E�v���ɕ����p��̓E�v���ɓ��͂��ꂽ�l����͂���B
                    set_301018(ACCastUtilities.toString(serviceDetail.get("1170104")));
                }
            }

        } else {
            //�����Ō���Z�Ή�
            // type �� KEY : 301010(�����E��) �� VALUE : ��1��������B
            //set_301010(get_301010() + 1);
            //[ID:0000720][Shin Fujihara] 2012/04 delete start 2012�N�x�Ή�
            //QP001SpecialCase�ɏ������ړ�
//            if("Z6276".equals(get_301022()) || "Z6277".equals(get_301022())){
//                if("51".equals(get_301007())){
//                    serviceCount = ACCastUtilities.toInt(serviceDetail.get("1510132"),1);
//                } else if("54".equals(get_301007())){
//                    serviceCount = ACCastUtilities.toInt(serviceDetail.get("1540128"),1);
//                }
//            }
            //[ID:0000720][Shin Fujihara] 2012/04 delete end 2012�N�x�Ή�
            //[ID:0000720][Shin Fujihara] 2012/04 add start 2012�N�x�Ή�
            serviceCount = QP001SpecialCase.getServiceCount(get_301007(), get_301008(), serviceDetail);
            //[ID:0000720][Shin Fujihara] 2012/04 delete end 2012�N�x�Ή�
            
            set_301010(get_301010() + serviceCount);
            
        }
        
        //[ID:0000561][Shin Fujihara] 2010/01 edit begin 2009�N�x�Ή�
        // �E�v�L�ڎ����̃f�[�^�쐬���s��
        recapitulation.setRecapitulation(serviceDetail,serviceCode,manager);
        //[ID:0000561][Shin Fujihara] 2010/01 edit end 2009�N�x�Ή�
        
        //[ID:0000467][Shin Fujihara] 2009/04 edit begin ����21�N4���@�����Ή�
        //if(ACCastUtilities.toInt(serviceCode.get("SERVICE_ADD_FLAG"),0) == 3){
        //[ID:0000682][Shin Fujihara] edit begin �y�@�����Ή��z���E���������P���Z
        //switch (ACCastUtilities.toInt(serviceCode.get("SERVICE_ADD_FLAG"),0)) {
        switch (serviceAddFlag) {
        //[ID:0000682][Shin Fujihara] edit end �y�@�����Ή��z���E���������P���Z
        //���ʒn����Z�Ή�
        case 3:
            //[ID:0000682][Shin Fujihara] add begin �y�@�����Ή��z���E���������P���Z
            serviceUnit = ACCastUtilities.toInt(serviceCode.get("SERVICE_UNIT"), 0);
            //[ID:0000682][Shin Fujihara] add end �y�@�����Ή��z���E���������P���Z
            //���X�g��ێ����Ă��Ȃ��ꍇ�͏����I��
            if(!serviceCode.containsKey("SERVICE_UNIT_MAP")){
                break;
            }
            
            VRMap unitMap = (VRMap)serviceCode.get("SERVICE_UNIT_MAP");
            Iterator it = unitMap.keySet().iterator();
            String key = "";
            String offer = VRDateParser.format(ACCastUtilities.toDate(targetServiceDate), "yyyyMMdd");
            
            //���ʒn����Z�̒P�ʐ��A�񐔂�ޔ�����B
            //���R�[�h�m�莞�Ɉꊇ�W�v
            while(it.hasNext()){
                key = String.valueOf(it.next());
                VRMap map = null;
                Integer times = null;
                Set<String> offerDay = null;
                
                //�o�^�ς݂̃T�[�r�X�̏ꍇ
                if(serviceUnitMap.containsKey(key)){
                    map = (VRMap)serviceUnitMap.get(key);
                    times = (Integer)map.get("TIMES");
                    offerDay = (Set)map.get("OFFER");
                } else {
                    map = new VRHashMap();
                    map.put("UNIT",unitMap.get(key));
                    serviceUnitMap.put(key,map);
                    times = new Integer(0);
                    offerDay = new HashSet<String>();
                }
                
                //�O���[�v���t���O���Q��
                //���P��
                if (key.endsWith("2")) {
                    //���ɒ񋟍ςł���΃X�L�b�v
                    if (offerDay.contains(offer)) {
                        continue;
                    }
                    
                //���P��
                } else if (key.endsWith("3")) {
                    //���ɒ񋟍ςł���΃X�L�b�v
                    if (!offerDay.isEmpty()) {
                        continue;
                    }
                }
                
                //�񋟓���ݒ�
                offerDay.add(offer);
                times = new Integer(times.intValue() + 1);
                map.put("TIMES",times);
                map.put("OFFER",offerDay);
            }
            break;
        //���R�Ԓn����Z�Ή�
        case 6:
            //[ID:0000682][Shin Fujihara] add begin �y�@�����Ή��z���E���������P���Z
            serviceUnit = ACCastUtilities.toInt(serviceCode.get("SERVICE_UNIT"), 0);
            //[ID:0000682][Shin Fujihara] add end �y�@�����Ή��z���E���������P���Z
        	mountainousAreaAdder.parse(serviceCode, targetServiceDate);
        	break;
        	
        //[ID:0000682][Shin Fujihara] add begin �y�@�����Ή��z���E���������P���Z
        //�������P
        case 8:
            //������ޔ�
            serviceUnit = ACCastUtilities.toInt(serviceCode.get("SERVICE_UNIT"), 0);
            serviceStaffUnit = ACCastUtilities.toInt(serviceCode.get("SERVICE_STAFF_UNIT"), 0);
            break;
        //[ID:0000682][Shin Fujihara] add end �y�@�����Ή��z���E���������P���Z        	
        }
        //[ID:0000467][Shin Fujihara] 2009/04 edit end ����21�N4���@�����Ή�
        
        
        // ����ʂ̓o�^���s���B
        kohiManager.setExtraData(targetServiceDate,serviceDetail, patientState, serviceCode,
                "1", get_301009(),manager.getProviderMedicalFlag(get_301004()),serviceCount,manager);

    }

    //�f�[�^�ݒ�̉ۂ𔻒肷��B
    private boolean isSetData(Object targetServiceDate,VRMap serviceCode) throws Exception {
        
        boolean result = true;
        
        //�V�K�쐬���R�[�h�ł���ΏW�v��������B
        if(isNew()){
            totalGroupintType = ACCastUtilities.toInt(serviceCode.get("TOTAL_GROUPING_TYPE"),0); 
            return result;
        }
        
        //���ʒn����Z�A���R�Ԓn����Z�ł���΁A�ꗥture
        switch(ACCastUtilities.toInt(serviceCode.get("SERVICE_ADD_FLAG"),0)) {
        case 3: //���ʒn����Z
        case 6: //���R�Ԓn����Z
            return result;
        }
        
        //�Z�胂�[�h�̊m�F
        switch(totalGroupintType){
            //1-�񐔒P��
            case 1:
                break;
            //2-���P��
            case 2:
                //���Ɍv�サ�Ă���΁A���R�[�h�̍쐬���s��Ȃ��B
            	//edit start fujihara.shin 2008.6.23 ����������W�J�Ή�
            	/*
                if(kohiManager.getRealDays().contains(targetServiceDate)){
                    result = false;
                }
                */
                if(kohiManager.getOfferDays().contains(targetServiceDate)){
                    result = false;
                }
                //edit end fujihara.shin 2008.6.23
                break;
            //3-���P��
            case 3:
                //�T�[�r�X�R�[�h�̊m�F
                //�K��Ō�A�ً}���K��Ō���Z�A���ʊǗ����Z�ł��邩�m�F
                switch(ACCastUtilities.toInt(serviceCode.get("SERVICE_CODE_KIND"),0)){
                //�K��Ō�
                case 13:
                //���\�h�K��Ō�
                case 63:
                	//�T�[�r�X���ڃR�[�h�̊m�F
                	switch(ACCastUtilities.toInt(serviceCode.get("SERVICE_CODE_ITEM"),0)){
                	//�ً}���K��Ō���Z�P
                	case 3100:
                	//�ً}���K��Ō���Z�Q
                	case 3200:
                	//���ʊǗ����Z
                	case 4000:
                        //�ݒ�t�@�C���̒l���m�F����B
                        if(ACFrame.getInstance().hasProperty("PrintConfig/OncePerMonth")){
                        	if(ACCastUtilities.toInt(ACFrame.getInstance().getProperty("PrintConfig/OncePerMonth"),1) == 0){
                        		result = true;
                        		return result;
                        	}
                        }
                		break;
                	}
                	break;
                
                }
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
        serial.append(get_301001());
        // ���R�[�h��ʃR�[�h2��(02�Œ�)
        serial.append(get_301002());
        // �T�[�r�X�񋟔N��6��(YYYYMM)
        serial.append(get_301003());
        // ���Ə��ԍ�10��
        serial.append(get_301004());
        // �؋L�ڕی��Ҕԍ�8��
        serial.append(get_301005());
        // ��ی��Ҕԍ�10��
        serial.append(get_301006());
        // �V�X�e�����T�[�r�X��ރR�[�h
        serial.append(get_301021());
        // �V�X�e�����T�[�r�X���ڃR�[�h
        serial.append(get_301022());
        
//        //�����p��Ή�
//        serial.append(get_301009());
//        serial.append(get_301018());
        
        return serial.toString();
    }
    
    protected static QP001RecordDetail getInstance(String identificationNo,
            Date targetDate, Object targetServiceDate, VRMap serviceDetail,
            VRMap serviceCode, QP001PatientState patientState,VRMap detailMap,QP001Manager manager) throws Exception {
        
        QP001RecordDetail detail = null;
        
        //���R�[�h�̍쐬�ۂ𔻒f
        //2008/09/03 [Shin Fujihara] edit - begin 30�����̒P�ʐ���PatientState�ɕێ�����悤�ύX
        //if(!isMakeRecord(serviceDetail,serviceCode)){
        if(!isMakeRecord(serviceDetail,serviceCode, patientState)){
        //2008/09/03 [Shin Fujihara] edit - end 30�����̒P�ʐ���PatientState�ɕێ�����悤�ύX
            return detail;
        }
        
        String serial = getSerialId(identificationNo,
                                    targetDate,
                                    targetServiceDate,
                                    serviceDetail,
                                    serviceCode,
                                    patientState,
                                    manager);
        
        //�����ɍ��v���郌�R�[�h�����݂��Ȃ��ꍇ
        if(!detailMap.containsKey(serial)){
            detail = new QP001RecordDetail();
            detailMap.put(serial,detail);
        //�����ɍ��v���郌�R�[�h�����݂���ꍇ
        } else {
            detail = (QP001RecordDetail)detailMap.get(serial);
        }
        
        return detail;
    }
    
    //2008/09/03 [Shin Fujihara] edit - begin 30�����̒P�ʐ���PatientState�ɕێ�����悤�ύX
    //private static boolean isMakeRecord(VRMap serviceDetail,VRMap serviceCode) throws Exception {
    private static boolean isMakeRecord(VRMap serviceDetail,VRMap serviceCode, QP001PatientState patientState) throws Exception {
    //2008/09/03 [Shin Fujihara] edit - end 30�����̒P�ʐ���PatientState�ɕێ�����悤�ύX
        
        //���t�Ǘ����x�z�Ώۃt���O���m�F����B
        //�t���O��0(�H��A�P�ʐ��ŊǗ����Ȃ��T�[�r�X)�̏ꍇ�́A���R�[�h�̍쐬�𒆒f����B
        if(String.valueOf(serviceCode.get("LIMIT_AMOUNT_OBJECT")).equals("0")){
            return false;
        }
        //30�����ł���΃��R�[�h�̍쐬�𒆒f����B
        if(ACCastUtilities.toInt(serviceDetail.get("5"),0) == 2){
        	//2008/09/03 [Shin Fujihara] add - begin 30�����̒P�ʐ���PatientState�ɕێ�����悤�ύX
        	patientState.putAbandonedUnit(serviceDetail, serviceCode);
        	//2008/09/03 [Shin Fujihara] add - end 30�����̒P�ʐ���PatientState�ɕێ�����悤�ύX
            return false;
        }
        return true;
    }
    
    private static String getSerialId(String identificationNo,
            Date targetDate, Object targetServiceDate, VRMap serviceDetail,
            VRMap serviceCode, QP001PatientState patientState,QP001Manager manager) throws Exception {
        //���R�[�h�̃V���A��ID���쐬
        StringBuilder serial = new StringBuilder();
        // �������ʔԍ�
        serial.append(identificationNo);
        // ���R�[�h��ʃR�[�h2��(02�Œ�)
        serial.append(_301002);
        // �T�[�r�X�񋟔N��6��(YYYYMM)
        serial.append(VRDateParser.format(targetDate, "yyyyMM"));
        // ���Ə��ԍ�10��
        serial.append(serviceDetail.get("PROVIDER_ID"));
        // �؋L�ڕی��Ҕԍ�8��
        serial.append(patientState.getInsurerId(targetServiceDate));
        // ��ی��Ҕԍ�10��
        serial.append(patientState.getInsuredId(targetServiceDate));
        // �V�X�e�����T�[�r�X��ރR�[�h
        serial.append(serviceCode.get("SYSTEM_SERVICE_KIND_DETAIL"));
        //�T�[�r�X��ރR�[�h
        serial.append(serviceCode.get("SERVICE_CODE_KIND"));
        //�T�[�r�X���ڃR�[�h
        serial.append(serviceCode.get("SERVICE_CODE_ITEM"));
        
        //�����p��Ή�
        if(ACCastUtilities.toInt(serviceCode.get("SERVICE_ADD_FLAG"),0) != 3){
            //serial.append(QP001Manager.getInstance().getServiceUnit(String.valueOf(serviceDetail.get("PROVIDER_ID")),serviceCode));
            serial.append(manager.getServiceUnit(String.valueOf(serviceDetail.get("PROVIDER_ID")),serviceCode));
        } else {
            serial.append(ACCastUtilities.toInt(serviceCode.get("SERVICE_UNIT"),0));
        }
        
        serial.append(QP001SpecialCase.getDetailSerial(serviceDetail,serviceCode));
        
        
//        // �T�[�r�X��ރR�[�h
//        String serviceCodeKind = ACCastUtilities.toString(VRBindPathParser.get("SERVICE_CODE_KIND", serviceCode),"");
//        //�V�X�e�����T�[�r�X���ڃR�[�h
//        String systemServiceCodeItem = ACCastUtilities.toString(VRBindPathParser.get("SYSTEM_SERVICE_CODE_ITEM", serviceCode),"");
//        
//        //�����p��̓K�p�ݒ�
//        if("17".equals(serviceCodeKind) || "67".equals(serviceCodeKind)){
//	        if(serviceDetail.containsKey("1170104")){
//	            //�V�X�e�����T�[�r�X��ރR�[�h��2����n�܂��Ă���ꍇ�́A
//	            //���ʒn����Z�̃��R�[�h
//	            if(!systemServiceCodeItem.startsWith("2")){
//	                //��ʏ�̕����p��E�v���ɓ��͂�����ꍇ
//	                if(!ACTextUtilities.isNullText(serviceDetail.get("1170104"))){
//	                    //�E�v���ɕ����p��̓E�v���ɓ��͂��ꂽ�l����͂���B
//	                	serial.append(ACCastUtilities.toString(serviceDetail.get("1170104")));
//	                }
//	            }
//	        }
//        }
//        
//        /*
//         * ������{�ݓ����Ґ������A���\�h����{�ݓ����Ґ������
//         * �E�O���T�[�r�X���p�^�ɂ����镟���p��ݗ^�A���\�h�����p��ݗ^
//         * �y�v���O�������̉��߁z
//         * ��ʏ�ɓ��͂��ꂽ�l���Q��
//         */
//        //�T�[�r�X��ރR�[�h��33�ł���
//        if("33".equals(serviceCodeKind)){
//            //�V�X�e�����T�[�r�X��ރR�[�h��27����n�܂�
//            if(systemServiceCodeItem.startsWith("27")){
//                //�E�v���ɓ��͂���Ă��鍀�ڂ�����ꍇ
//                if(serviceDetail.containsKey("1330120")){
//                    //�E�v���ɊO�����p�����p��̓E�v���ɓ��͂��ꂽ�l��ݒ肷��B
//                	serial.append(ACCastUtilities.toString(serviceDetail.get("1330120")));
//                }
//            }
//        }
//        
//        //�T�[�r�X��ރR�[�h��35�ł���
//        if("35".equals(serviceCodeKind)){
//            //�V�X�e�����T�[�r�X��ރR�[�h��27����n�܂�
//            if(systemServiceCodeItem.startsWith("27")){
//                //�E�v���ɓ��͂���Ă��鍀�ڂ�����ꍇ
//                if(serviceDetail.containsKey("1170104")){
//                    //�E�v���ɊO�����p�����p��̓E�v���ɓ��͂��ꂽ�l��ݒ肷��B
//                	serial.append(ACCastUtilities.toString(serviceDetail.get("1170104")));
//                }
//            }
//        }
        
        return serial.toString();
    }

    /**
     * ���R�[�h���e�̊m����s���B
     */
    protected void commitRecord(String[] kohi, QP001PatientState patientState) throws Exception {
        
        //�E�v���̓��e���m��
        set_301018(recapitulation.getRecapitulation(getRealDays(),patientState));
        
        //���ʒn����Z���R�[�h�̏���
        if(serviceUnitMap.size() > 0){
            int specialUnit = 0;
            int ratio = get_301009();
            
            Iterator it = serviceUnitMap.keySet().iterator();
            while(it.hasNext()){
                String key = String.valueOf(it.next());
                //�P�ʐ�-��
                VRMap map = (VRMap)serviceUnitMap.get(key);
                Integer unit = (Integer)map.get("UNIT");
                Integer times = (Integer)map.get("TIMES");
                
                //�l�̌ܓ�
                //���Z���l�̌ܓ�����悤�ύX
                //specialUnit += (int)Math.round((double)(unit.intValue() * times.intValue() * ratio) / 100d);
                specialUnit += unit.intValue() * times.intValue();
            }
            
            //set_301009(specialUnit);
            set_301009((int)Math.round((double)(specialUnit * ratio) / 100d));
            set_301010(1);
            
            kohiManager.replaceCalcRate(specialUnit);
            
            //[ID:0000730][Shin Fujihara] add begin  �y�T�[�r�X���p�[�ʕ\�E���яW�v�z���ȕ��S�������́��n���Z�̌v�Z�ɂ���
            //�����ƂȂ�P�ʐ���ޔ�
            setAdditionBasisUnit(specialUnit);
            //[ID:0000730][Shin Fujihara] add end   
        }
        
        //[ID:0000467][Shin Fujihara] 2009/04 add begin ����21�N4���@�����Ή�
        if (mountainousAreaAdder.hasData()){
        	int specialUnit = mountainousAreaAdder.getUnit();
            set_301009((int)Math.round((double)(specialUnit * get_301009()) / 100d));
            set_301010(1);
            kohiManager.replaceCalcRate(specialUnit);
            
            //[ID:0000730][Shin Fujihara] add begin  �y�T�[�r�X���p�[�ʕ\�E���яW�v�z���ȕ��S�������́��n���Z�̌v�Z�ɂ���
            //�����ƂȂ�P�ʐ���ޔ�
            setAdditionBasisUnit(specialUnit);
            //[ID:0000730][Shin Fujihara] add end
        }
        //[ID:0000467][Shin Fujihara] 2009/04 add end ����21�N4���@�����Ή�
        
        //����̋��t����100%�ɂȂ������̔���t���O
        boolean kohiLimit = false; 
        
        // �T�[�r�X�P�ʐ�
        set_301014(get_301009() * get_301010());
        
        // ����P�̓K�p�����邩�m�F
        if ((kohi[0] != null) && (!"".equals(kohi[0]))) {
            // �K�p������ꍇ
            // ����1�Ώۓ����E��2����ݒ肷��B
            set_301011(kohiManager.getKohiCount(kohi[0]));
            
            //���ʒn����Z�Ή��ɂ��A�񐔂��ύX���ꂽ�ꍇ���l�����Č���E�v�񐔂Ƃ̔�r���s�Ȃ�
            if(get_301010() < get_301011()){
                set_301011(get_301010());
            }
            
            // ����1�ΏۃT�[�r�X�P�ʐ�6��(�P�ʐ�*����P�K�p��)
            set_301015(get_301009() * get_301011());
            // ����1����^�C�v
            set_301023(kohi[0]);
            // ���t����100%�ɂȂ����珈�����I������B
            if(ACCastUtilities.toInt(patientState.getKohiData(kohi[0],"BENEFIT_RATE",1)) == 100){
                //����P�őS�P�ʐ��ł܂��Ȃ���Ό���v�Z���I��
                if(get_301014() <= get_301015()){
                    kohiLimit = true;
                }
            }
            
        }
        // ����Q�̓K�p�����邩�m�F
        if ((!kohiLimit) && (kohi[1] != null) && (!"".equals(kohi[1]))) {
            // �K�p������ꍇ
            // ����2�Ώۓ����E��2����ݒ肷��B
            set_301012(kohiManager.getKohiCount(kohi[1]));
            
            //���ʒn����Z�Ή��ɂ��A�񐔂��ύX���ꂽ�ꍇ���l�����Č���E�v�񐔂Ƃ̔�r���s�Ȃ�
            if(get_301010() < get_301012()){
                set_301012(get_301010());
            }
            
            // ����2�ΏۃT�[�r�X�P�ʐ�6��(�P�ʐ�*����Q�K�p��)
            set_301016(get_301009() * get_301012());
            // ����2����^�C�v
            set_301024(kohi[1]);
            // ���t����100%�ɂȂ����珈�����I������B
            if(ACCastUtilities.toInt(patientState.getKohiData(kohi[1],"BENEFIT_RATE",1)) == 100){
                //����Q�őS�P�ʐ��ł܂��Ȃ���Ό���v�Z���I��
                if(get_301014() <= get_301016()){
                    kohiLimit = true;
                }
            }
        }
        // ����R�̓K�p�����邩�m�F
        if ((!kohiLimit) && (kohi[2] != null) && (!"".equals(kohi[2]))) {
            // �K�p������ꍇ
            // ����3�Ώۓ����E��2����ݒ肷��B
            set_301013(kohiManager.getKohiCount(kohi[2]));
            
            //���ʒn����Z�Ή��ɂ��A�񐔂��ύX���ꂽ�ꍇ���l�����Č���E�v�񐔂Ƃ̔�r���s�Ȃ�
            if(get_301010() < get_301013()){
                set_301013(get_301010());
            }
            
            // ����3�ΏۃT�[�r�X�P�ʐ�6��(�P�ʐ�*����R�K�p��)
            set_301017(get_301009() * get_301013());
            // ����3����^�C�v
            set_301025(kohi[2]);
            // ���t����100%�ɂȂ����珈�����I������B
//            if (ACCastUtilities.toInt(patientState.getKohiData(kohi[0],"BENEFIT_RATE",2)) == 100)
//                return;
        }
        
        //���Z�ł���Ώ������I������B
        if(serviceUnitMap.size() > 0){
            return;
        }
        
        //����̃T�[�r�X�̂ݒP�ʐ���0��ɕύX����B
        if(QP001SpecialCase.isUnitNoCountService(get_301007(),get_301008())){
            //�P�ʐ���0��ɕύX
            set_301009(0);
        }
        if(QP001SpecialCase.isMaxCountService(get_301007(),get_301008())){
            int count = ACDateUtilities.getLastDayOfMonth(ACCastUtilities.toDate(get_301003() + "01"));
            //�񐔂͓����̓����ɕύX
            set_301010(count);
            //����񐔂��ύX
            if(get_301011() > 0){
                set_301011(count);
            }
            if(get_301012() > 0){
                set_301012(count);
            }
            if(get_301013() > 0){
                set_301013(count);
            }
        }
        
        //���K�͑��@�\�^�̗�O
        //���P�ʏW�v�ŉ��Z�E���Z�n�ȊO�ŉ񐔂�1��Ƃ���T�[�r�X�ł��邩�B
        if(QP001SpecialCase.isSingleCountService(get_301007(),get_301008())){
            //�񐔂�1��ɕύX
            set_301010(1);
            //����񐔂��ύX
            if(get_301011() > 0){
                set_301011(1);
            }
            if(get_301012() > 0){
                set_301012(1);
            }
            if(get_301013() > 0){
                set_301013(1);
            }
        }
        
    }

    /**
     * ����X�g���擾����B
     * @return
     */
    protected VRMap getKohiList() {
        return this.kohiManager.getKohiList();
    }
    /**
     * �T�[�r�X���������X�g���擾����B
     * @return
     */
    protected VRList getRealDays() {
        return this.kohiManager.getRealDays();
    }
    /**
     * ���@(����)���������X�g���擾����B
     * @return
     */
    protected VRList getHospitalizationDays(){
        return this.kohiManager.getHospitalizationDays();
    }
    /**
     * �މ@(�ޏ�)���������X�g���擾����B
     * @return
     */
    protected VRList getLeavingHospitalDays(){
        return this.kohiManager.getLeavingHospitalDays();
    }
    /**
     * ����̃p�^�����擾����B
     * @return
     */
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
        setData(result, "301001", get_301001());
        // ���R�[�h��ʃR�[�h2��(02��ݒ�)
        setData(result, "301002", get_301002());
        // �T�[�r�X�񋟔N��6��(YYYYMM)
        setData(result, "301003", get_301003());
        // ���Ə��ԍ�10��
        setData(result, "301004", get_301004());
        // �؋L�ڕی��Ҕԍ�8��
        setData(result, "301005", get_301005());
        // ��ی��Ҕԍ�10��
        setData(result, "301006", get_301006());
        // �T�[�r�X��ރR�[�h2��
        setData(result, "301007", get_301007());
        // �T�[�r�X���ڃR�[�h4��
        setData(result, "301008", get_301008());
        // �P�ʐ�4��
        setData(result, "301009", get_301009());

        //�������2��
        setData(result, "301010", get_301010());
        //����1�Ώۓ����E��2��
        setData(result, "301011", get_301011());
        //����2�Ώۓ����E��2��
        setData(result, "301012", get_301012());
        //����3�Ώۓ����E��2��
        setData(result, "301013", get_301013());
        //�T�[�r�X�P�ʐ�6��
        setData(result, "301014", get_301014());
        //����1�ΏۃT�[�r�X�P�ʐ�6��
        setData(result, "301015", get_301015());
        //����2�ΏۃT�[�r�X�P�ʐ�6��
        setData(result, "301016", get_301016());
        //����3�ΏۃT�[�r�X�P�ʐ�6��
        setData(result, "301017", get_301017());
        //�E�v20��
        setData(result, "301018", get_301018());
        //�T�[�r�X����(�T�[�r�X�R�[�h�}�X�^TBL��SERVICE_NAME)
        setData(result, "301019", get_301019());

        //���x�z�Ǘ��Ώۃt���O
        setData(result, "301020", get_301020());
		//�V�X�e�����T�[�r�X��ރR�[�h(SYSTEM_SERVICE_KIND_DETAIL)
		setData(result,"301021",get_301021());
		//�V�X�e�����T�[�r�X���ڃR�[�h(SYSTEM_SERVICE_CODE_ITEM)
		setData(result,"301022",get_301022());

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
        //���׏�񃌃R�[�h
        //result.put("CATEGORY_NO", "3");
        result.put("CATEGORY_NO", QkanConstants.CATEGORY_NO_RECORD_DETAILED);
        return result;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("[301001=" + get_301001() + "]\n");
        result.append("[301002=" + get_301002() + "]\n");
        result.append("[301003=" + get_301003() + "]\n");
        result.append("[301004=" + get_301004() + "]\n");
        result.append("[301005=" + get_301005() + "]\n");
        result.append("[301006=" + get_301006() + "]\n");
        result.append("[301007=" + get_301007() + "]\n");
        result.append("[301008=" + get_301008() + "]\n");
        result.append("[301009=" + get_301009() + "]\n");
        result.append("[301010=" + get_301010() + "]\n");
        result.append("[301011=" + get_301011() + "]\n");
        result.append("[301012=" + get_301012() + "]\n");
        result.append("[301013=" + get_301013() + "]\n");
        result.append("[301014=" + get_301014() + "]\n");
        result.append("[301015=" + get_301015() + "]\n");
        result.append("[301016=" + get_301016() + "]\n");
        result.append("[301017=" + get_301017() + "]\n");
        result.append("[301018=" + get_301018() + "]\n");
        result.append("[301019=" + get_301019() + "]\n");
        result.append("[301020=" + get_301020() + "]\n");
        result.append("[301021=" + get_301021() + "]\n");
        result.append("[301022=" + get_301022() + "]\n");
        result.append("[301023=" + get_301023() + "]\n");
        result.append("[301024=" + get_301024() + "]\n");
        result.append("[301025=" + get_301025() + "]\n");
        result.append(kohiManager);
        return result.toString();
    }
}
