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
 * �v���O���� �Љ�����ƃ��R�[�h (QP001RecordReduction)
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
 * �Љ�����ƃ��R�[�h
 * 
 * @author shin fujihara
 * 
 */
public class QP001RecordReduction extends QP001RecordAbstract {

    // ������񎯕ʔԍ�4��
    private String _901001 = "";

    // ���R�[�h��ʃR�[�h2��(12��ݒ�)"
    private static final String _901002 = "12";

    // �T�[�r�X�񋟔N��6��(YYYYMM)"
    private String _901003 = "";

    // ���Ə��ԍ�10��
    private String _901004 = "";

    // ���Ə��ԍ�10��
    private String _901005 = "";

    // ��ی��Ҕԍ�10��
    private String _901006 = "";

    // �y����4��
    private int _901007 = 0;

    // �T�[�r�X��ރR�[�h2��
    private String _901008 = "";

    // ��̂��ׂ����p�ҕ��S�̑��z8��
    private int _901009 = 0;

    // �y���z8��
    private int _901010 = 0;

    // �y���㗘�p�ҕ��S�z8��
    private int _901011 = 0;

    // ���l20��
    private String _901012 = "";

    // �P�ʐ�
    private int _901013 = 0;
    
    //���z
    private int _901014 = 0;

    /**
     * ������񎯕ʔԍ�4�����擾����B
     * 
     * @return
     */
    protected String get_901001() {
        return _901001;
    }

    /**
     * ������񎯕ʔԍ�4����ݒ肷��B
     * 
     * @param _901001
     */
    protected void set_901001(String _901001) {
        this._901001 = _901001;
    }

    /**
     * ���R�[�h��ʃR�[�h2�����擾����B
     */
    protected String get_901002() {
        return _901002;
    }

    /**
     * �T�[�r�X�񋟔N��6�����擾����B
     * 
     * @return
     */
    protected String get_901003() {
        return _901003;
    }

    /**
     * �T�[�r�X�񋟔N��6����ݒ肷��B
     * 
     * @param _901003
     */
    protected void set_901003(String _901003) {
        this._901003 = _901003;
    }

    /**
     * ���Ə��ԍ�10�����擾����B
     * 
     * @return
     */
    protected String get_901004() {
        return _901004;
    }

    /**
     * ���Ə��ԍ�10����ݒ肷��B
     * 
     * @param _901004
     */
    protected void set_901004(String _901004) {
        this._901004 = _901004;
    }

    /**
     * �؋L�ڕی��Ҕԍ�8�����擾����B
     * 
     * @return
     */
    protected String get_901005() {
        return _901005;
    }

    /**
     * �؋L�ڕی��Ҕԍ�8����ݒ肷��B
     * 
     * @param _901005
     */
    protected void set_901005(String _901005) {
        this._901005 = _901005;
    }

    /**
     * ��ی��Ҕԍ�10�����擾����B
     * 
     * @return
     */
    protected String get_901006() {
        return _901006;
    }

    /**
     * ��ی��Ҕԍ�10����ݒ肷��B
     * 
     * @param _901006
     */
    protected void set_901006(String _901006) {
        this._901006 = _901006;
    }

    /**
     * �y����4�����擾����B
     * 
     * @return
     */
    protected int get_901007() {
        return _901007;
    }

    /**
     * �y����4����ݒ肷��B
     * 
     * @param _901007
     */
    protected void set_901007(int _901007) {
        this._901007 = _901007;
    }

    /**
     * �T�[�r�X��ރR�[�h2�����擾����B
     * 
     * @return
     */
    protected String get_901008() {
        return _901008;
    }

    /**
     * �T�[�r�X��ރR�[�h2����ݒ肷��B
     * 
     * @param _901008
     */
    protected void set_901008(String _901008) {
        this._901008 = _901008;
    }

    /**
     * ��̂��ׂ����p�ҕ��S�̑��z8�����擾����B
     * 
     * @return
     */
    protected int get_901009() {
        return _901009;
    }

    /**
     * ��̂��ׂ����p�ҕ��S�̑��z8����ݒ肷��B
     * 
     * @param _901009
     */
    protected void set_901009(int _901009) {
        this._901009 = _901009;
    }

    /**
     * �y���z8�����擾����B
     * 
     * @return
     */
    protected int get_901010() {
        return _901010;
    }

    /**
     * �y���z8����ݒ肷��B
     * 
     * @param _901010
     */
    protected void set_901010(int _901010) {
        this._901010 = _901010;
    }

    /**
     * �y���㗘�p�ҕ��S�z8�����擾����B
     * 
     * @return
     */
    protected int get_901011() {
        return _901011;
    }

    /**
     * �y���㗘�p�ҕ��S�z8����ݒ肷��B
     * 
     * @param _901011
     */
    protected void set_901011(int _901011) {
        this._901011 = _901011;
    }

    /**
     * ���l20�����擾����B
     * 
     * @return
     */
    protected String get_901012() {
        return _901012;
    }

    /**
     * ���l20����ݒ肷��B
     * 
     * @param _901012
     */
    protected void set_901012(String _901012) {
        this._901012 = _901012;
    }

    /**
     * �Е����ƑΏےP�ʐ���ݒ肷��B
     * @param _901013
     */
    protected void set_901013(int _901013) {
        this._901013 = _901013;
    }
    /**
     * �Е����ƑΏےP�ʐ����擾����B
     * @return
     */
    protected int get_901013() {
        return _901013;
    }
    /**
     * �Е����ƑΏۂ̋��z��ݒ肷��B(�H��Ȃ�)
     * @param _901014
     */
    protected void set_901014(int _901014) {
        this._901014 = _901014;
    }
    /**
     * �Е����ƑΏۂ̋��z���擾����B(�H��Ȃ�)
     * @return
     */
    protected int get_901014() {
        return _901014;
    }

    /**
     * ���ɏ�񂪓o�^����Ă��邩�ԋp���܂��B
     * 
     * @return �V�K:true �ǉ�:false
     */
    protected boolean isNew() {
        // ������񃌃R�[�h�ɓo�^��������ΐV�K�Ƃ݂Ȃ��B
        return ((get_901001() == null) || ("".equals(get_901001())));
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
            // reduction �� KEY : 901001(������񎯕ʔԍ�) �� VALUE : ��Z������ݒ肷��B
            set_901001(identificationNo);

            // reduction �� KEY : 901003(�T�[�r�X�񋟔N��) �� VALUE :
            // yyyyMM�`���Ƀt�H�[�}�b�g����targetDate��ݒ肷��B
            set_901003(VRDateParser.format(targetDate, "yyyyMM"));

            // reduction �� KEY : 901004(���Ə��ԍ�) �� VALUE :
            // 10���t�H�[�}�b�g�������Ə��ԍ�(serviceDetail���擾)��ݒ肷��B
            set_901004(ACCastUtilities.toString(VRBindPathParser.get(
                    "PROVIDER_ID", serviceDetail)));

            // reduction �� KEY : 901005(�؋L�ڕی��Ҕԍ�) �� VALUE :
            // 8���t�H�[�}�b�g�������p�҂̕ی��Ҕԍ�(patient���擾)��ݒ肷��B
            set_901005(patientState.getInsurerId(targetServiceDate));

            // reduction �� KEY : 901006(��ی��Ҕԍ�) �� VALUE :
            // 10���t�H�[�}�b�g�������p�҂̔�ی��Ҕԍ�(patient���擾)��ݒ肷��B
            set_901006(patientState.getInsuredId(targetServiceDate));

            // reduction �� KEY : 901007(�y����) �� VALUE : patient �̌y������ݒ肷��B ��050.0
            // �܂��� 025.0
            set_901007(patientState.getReductionRatio(targetServiceDate, String
                    .valueOf(VRBindPathParser.get("SYSTEM_SERVICE_KIND_DETAIL",
                            serviceCode))));

            // reduction �� KEY : 901008(�T�[�r�X��ރR�[�h) �� VALUE :
            // 2���t�H�[�}�b�g�����T�[�r�X��ރR�[�h(serviceCode���擾))��ݒ肷��B
            set_901008(ACCastUtilities.toString(VRBindPathParser.get(
                    "SERVICE_CODE_KIND", serviceCode)));

            // reduction �� KEY : TANI(�ΏےP�ʐ�) �� VALUE :
            // �P�ʐ�(serviceCode���擾)��ݒ肷��B
            set_901013(manager.getServiceUnit(get_901004(),
                    serviceCode));

        } else {
            // reduction �� KEY : TANI(�ΏےP�ʐ�) �̒l�ɒP�ʐ�(serviceCode���擾)��������B
            set_901013(get_901013()
                    + manager.getServiceUnit(get_901004(),
                            serviceCode));
        }
        
        //�H��A���Z��̓��Ꮘ��
        if("59".equals(ACCastUtilities.toString(VRBindPathParser.get(
                "SERVICE_CODE_KIND", serviceCode)))){
            //��p�P��
            int unit = QP001SpecialCase.getUnit(serviceDetail,serviceCode,manager);
            //���p�ҕ��S�z
            int userUnit = QP001SpecialCase.getRiyosyaFutan(serviceCode,patientState);
            //��p�P���������p�ҕ��S�z���傫���ꍇ
            if(unit < userUnit){
                //��p�P���𗘗p�ҕ��S�Ƃ��Đݒ肷��B
                set_901014(unit);
            } else {
                //���p�ҕ��S�z��ݒ肷��B
                set_901014(userUnit);
            }
        }

    }

    /**
     * ���R�[�h�ŗL�̒l���擾����B
     */
    protected String getSerialId() {

        StringBuilder serial = new StringBuilder();
        // ������񎯕ʔԍ�4��
        serial.append(get_901001());
        // ���R�[�h��ʃR�[�h2��
        serial.append(get_901002());
        // �T�[�r�X�񋟔N��6��
        serial.append(get_901003());
        // ���Ə��ԍ�10��
        serial.append(get_901004());
        // �؋L�ڕی��Ҕԍ�8��
        serial.append(get_901005());
        // ��ی��Ҕԍ�10��
        serial.append(get_901006());
        // �y����4��
        serial.append(get_901007());
        // �T�[�r�X��ރR�[�h2��
        serial.append(get_901008());

        return serial.toString();
    }
    
    /**
     * 
     * @param identificationNo
     * @param targetDate
     * @param targetServiceDate
     * @param serviceDetail
     * @param serviceCode
     * @param patientState
     * @param reductionMap
     * @return
     * @throws Exception
     */
    protected static QP001RecordReduction getInstance(String identificationNo,
            Date targetDate, Object targetServiceDate, VRMap serviceDetail,
            VRMap serviceCode, QP001PatientState patientState,VRMap reductionMap,QP001Manager manager) throws Exception {
        
        QP001RecordReduction reduction = null;
        
        //���R�[�h�̍쐬�ۂ𔻒f
        if(!isMakeRecord(targetDate, targetServiceDate,serviceDetail,serviceCode,patientState,manager)){
            return reduction;
        }
        
        String serial = getSerialId(identificationNo,
                                    targetDate,
                                    targetServiceDate,
                                    serviceDetail,
                                    serviceCode,
                                    patientState);
        
        //�����ɍ��v���郌�R�[�h�����݂��Ȃ��ꍇ
        if(!reductionMap.containsKey(serial)){
            reduction = new QP001RecordReduction();
            reductionMap.put(serial,reduction);
        //�����ɍ��v���郌�R�[�h�����݂���ꍇ
        } else {
            reduction = (QP001RecordReduction)reductionMap.get(serial);
        }
        
        return reduction;
    }

    protected static boolean isMakeRecord(Date targetDate,
            Object targetServiceDate, VRMap serviceDetail, VRMap serviceCode,
            QP001PatientState patientState,QP001Manager manager) throws Exception {
        
        //�T�[�r�X�񋟎��A�Љ���@�l�y���z�̑ΏۂłȂ��ꍇ�B
        if(patientState.getReductionRatio(targetServiceDate,String.valueOf(serviceCode.get("SYSTEM_SERVICE_KIND_DETAIL"))) == 0){
            //�������I������B
            return false;
        }
        
        //���Ə����Y���̃T�[�r�X���Е����ƂƂ��ĔF�߂Ă��Ȃ��ꍇ�B        
//        if(!QP001Manager.getInstance().isReduction(String.valueOf(serviceDetail.get("PROVIDER_ID")),String.valueOf(serviceCode.get("SYSTEM_SERVICE_KIND_DETAIL")))){
        if(!manager.isReduction(String.valueOf(serviceDetail.get("PROVIDER_ID")),String.valueOf(serviceCode.get("SYSTEM_SERVICE_KIND_DETAIL")))){
            //�������I������B
            return false;
        }
        
        //�T�[�r�X�񋟎��Apatient �̕ی����S�z��100%�̏ꍇ�B
//        if (patientState.getKohiRatio(targetDate,
//                                      String.valueOf(serviceCode.get("SYSTEM_SERVICE_KIND_DETAIL")),
//                                      "1",1,
//                                      QP001Manager.getInstance().getProviderMedicalFlag(String.valueOf(serviceDetail.get("PROVIDER_ID")))) == 100) {

        
        //�Е����ƑΏۂ̃T�[�r�X�Ŗ����ꍇ
        // [H27.4�����Ή�][Shinobu Hitaka] 2015/1/20 edit - begin �T�[�r�X�R�[�h�p����
        /*
        //�l�����
        int code_kind =ACCastUtilities.toInt(serviceCode.get("SERVICE_CODE_KIND"));
        switch(code_kind){
        case 11: //�l��2-1
        case 15: //�l��2-1
        case 21: //�l��3-1
        case 24: //�l��3-2
        case 51: //�l��8
        case 54: //�l��8
        case 61: //�l��2-2
        case 65: //�l��2-2
        case 71: //�l��2-1
        case 72: //�l��2-1
        case 73: //�l��2-1(���K�͑��@�\�^������)
        case 74: //�l��2-2
        case 75: //�l��2-2
        
        case 76: //�l��2-1(�������)
        case 77: //�l��2-1(�����^)
            if (patientState.getKohiRatio(targetDate,
                    String.valueOf(serviceCode.get("SYSTEM_SERVICE_KIND_DETAIL")),
                    "1",1,
                    manager.getProviderMedicalFlag(String.valueOf(serviceDetail.get("PROVIDER_ID"))),manager) == 100) {
                //�������I������B
                return false;
            }
            return true;
        
//        case 59: //�H��E���Z��E�E�E
//            //���ȕ��S�z�����݂��邩�Ŕ��f
//            if(QP001SpecialCase.getRiyosyaFutan(serviceCode,patientState) != 0){
//                return true;
//            }
//            break;
        }
        */
        String serviceCodeKind =ACCastUtilities.toString(serviceCode.get("SERVICE_CODE_KIND"));
        if ("11".equals(serviceCodeKind) || 	//�l��2-1
        	"15".equals(serviceCodeKind) || 	//�l��2-1
        	"21".equals(serviceCodeKind) || 	//�l��3-1
        	"24".equals(serviceCodeKind) || 	//�l��3-2
        	"51".equals(serviceCodeKind) || 	//�l��8
        	"54".equals(serviceCodeKind) || 	//�l��8
        	"61".equals(serviceCodeKind) || 	//�l��2-2
        	"65".equals(serviceCodeKind) || 	//�l��2-2
        	"68".equals(serviceCodeKind) || 	//�l��2-1(���K�͑��@�\�^������E�Z��) H27.4����
        	"69".equals(serviceCodeKind) || 	//�l��2-2(�\�h���K�͑��@�\�^������E�Z��) H27.4����
        	"71".equals(serviceCodeKind) || 	//�l��2-1
        	"72".equals(serviceCodeKind) || 	//�l��2-1
        	"73".equals(serviceCodeKind) || 	//�l��2-1(���K�͑��@�\�^������)
        	"74".equals(serviceCodeKind) || 	//�l��2-2
        	"75".equals(serviceCodeKind) || 	//�l��2-2
        	"76".equals(serviceCodeKind) || 	//�l��2-1(�������)
        	"77".equals(serviceCodeKind) || 	//�l��2-1(�����^)
        	"79".equals(serviceCodeKind) || 	//�l��2-1(�����^�E�Z��) H27.4����
        	"78".equals(serviceCodeKind) || 	//�l��2-1(�n�斧���^�ʏ�) H28.4����
        	"A1".equals(serviceCodeKind) || 	//�l��2-3(�������ƁF�K��^) H27.4���� add 2016.7.22
        	"A5".equals(serviceCodeKind)    	//�l��2-3(�������ƁF�ʏ��^) H27.4���� add 2016.7.22
        	) {
            if (patientState.getKohiRatio(targetDate,
                    String.valueOf(serviceCode.get("SYSTEM_SERVICE_KIND_DETAIL")),
                    "1",1,
                    manager.getProviderMedicalFlag(String.valueOf(serviceDetail.get("PROVIDER_ID"))),manager) == 100) {
                //�������I������B
                return false;
            }
            return true;
        }
        // [H27.4�����Ή�][Shinobu Hitaka] 2015/1/20 edit - end   �T�[�r�X�R�[�h�p����
        
        return false;
    }
    
    private static String getSerialId(String identificationNo,
            Date targetDate, Object targetServiceDate, VRMap serviceDetail,
            VRMap serviceCode, QP001PatientState patientState) throws Exception {

        StringBuilder serial = new StringBuilder();
        // �������ʔԍ�
        serial.append(identificationNo);
        // ���R�[�h��ʃR�[�h2��(02�Œ�)
        serial.append(_901002);
        // �T�[�r�X�񋟔N��6��(YYYYMM)
        serial.append(VRDateParser.format(targetDate, "yyyyMM"));
        // ���Ə��ԍ�10��
        serial.append(VRBindPathParser.get("PROVIDER_ID", serviceDetail));
        // �؋L�ڕی��Ҕԍ�8��
        serial.append(patientState.getInsurerId(targetServiceDate));
        // ��ی��Ҕԍ�10��
        serial.append(patientState.getInsuredId(targetServiceDate));
        // �y����
        serial.append(patientState.getReductionRatio(targetServiceDate, String
                .valueOf(VRBindPathParser.get("SYSTEM_SERVICE_KIND_DETAIL",
                        serviceCode))));
        // �T�[�r�X��ރR�[�h
        serial.append(VRBindPathParser.get("SERVICE_CODE_KIND", serviceCode));

        return serial.toString();
    }

    /**
     * ���R�[�h���e�̊m����s���B
     */
    protected void commitRecord(int patientBurden) throws Exception {

        // ��̂��ׂ����p�ҕ��S�̑��z8�������p�ҕ��S�z
        // �W�v��񂪊m�肵�Ȃ��Ƃ킩��Ȃ����́B
        set_901009(patientBurden);

        // �y���z8�������p�ҕ��S�z*�y����
        //�y�����͓��͂��ꂽ�l��10�{��ԋp����̂ŁA1000�Ŋ���
        set_901010((int) Math.floor((patientBurden * get_901007()) / (100 * 10)));

        // �y���㗘�p�ҕ��S�z8�������p�ҕ��S�z-�y���z
        set_901011(patientBurden - get_901010());

        // ���l20��
        set_901012("");
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
        setData(result, "901001", get_901001());
        // ���R�[�h��ʃR�[�h2��(12��ݒ�)
        setData(result, "901002", get_901002());
        // �T�[�r�X�񋟔N��6��(YYYYMM)
        setData(result, "901003", get_901003());
        // ���Ə��ԍ�10��
        setData(result, "901004", get_901004());
        // �؋L�ڕی��Ҕԍ�8��
        setData(result, "901005", get_901005());
        // ��ی��Ҕԍ�10��
        setData(result, "901006", get_901006());
        // �y����4��
        setData(result, "901007", get_901007());
        // �T�[�r�X��ރR�[�h2��
        setData(result, "901008", get_901008());
        // ��̂��ׂ����p�ҕ��S�̑��z8��
        setData(result, "901009", get_901009());

        // �y���z8��
        setData(result, "901010", get_901010());
        //�y���㗘�p�ҕ��S�z8��
        setData(result, "901011", get_901011());
        //���l20��
        setData(result, "901012", get_901012());
        //		//�ΏےP�ʐ�
        //		setData(result,style,"901013",get_901013());

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
        //�Љ���@�l�y���z��񃌃R�[�h
        //result.put("CATEGORY_NO", "9");
        result.put("CATEGORY_NO", QkanConstants.CATEGORY_NO_SOCIAL_WELFARE_REDUCE);
        return result;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("[901001=" + get_901001() + "]\n");
        result.append("[901002=" + get_901002() + "]\n");
        result.append("[901003=" + get_901003() + "]\n");
        result.append("[901004=" + get_901004() + "]\n");
        result.append("[901005=" + get_901005() + "]\n");
        result.append("[901006=" + get_901006() + "]\n");
        result.append("[901007=" + get_901007() + "]\n");
        result.append("[901008=" + get_901008() + "]\n");
        result.append("[901009=" + get_901009() + "]\n");
        result.append("[901010=" + get_901010() + "]\n");
        result.append("[901011=" + get_901011() + "]\n");
        result.append("[901012=" + get_901012() + "]\n");
        result.append("[901013=" + get_901013() + "]\n");
        return result.toString();
    }

}
