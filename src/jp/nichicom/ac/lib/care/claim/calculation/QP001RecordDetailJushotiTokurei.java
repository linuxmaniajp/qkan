package jp.nichicom.ac.lib.care.claim.calculation;

import java.util.Date;
import java.util.Iterator;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.text.parsers.VRDateParser;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanConstants;

/**
 * ���ׁi�Z���n����j���R�[�h���
 * 
 */
public class QP001RecordDetailJushotiTokurei  extends QP001RecordDetail {
    // ������񎯕ʔԍ�4��
    private String _1801001 = "";

    // ���R�[�h��ʃR�[�h2��(14�Œ�)
    private static final String _1801002 = "14";

    // �T�[�r�X�񋟔N��6��(YYYYMM)
    private String _1801003 = "";

    // ���Ə��ԍ�10��
    private String _1801004 = "";

    // �؋L�ڕی��Ҕԍ�8��
    private String _1801005 = "";

    // ��ی��Ҕԍ�10��
    private String _1801006 = "";

    // �T�[�r�X��ރR�[�h2��
    private String _1801007 = "";

    // �T�[�r�X���ڃR�[�h4��
    private String _1801008 = "";

    // �P�ʐ�4��
    private int _1801009 = 0;

    // �������2��
    private int _1801010 = 0;

    // ����1�Ώۓ����E��2��
    private int _1801011 = 0;

    // ����2�Ώۓ����E��2��
    private int _1801012 = 0;

    // ����3�Ώۓ����E��2��
    private int _1801013 = 0;

    // �T�[�r�X�P�ʐ�6��
    private int _1801014 = 0;

    // ����1�ΏۃT�[�r�X�P�ʐ�6��
    private int _1801015 = 0;

    // ����2�ΏۃT�[�r�X�P�ʐ�6��
    private int _1801016 = 0;

    // ����3�ΏۃT�[�r�X�P�ʐ�6��
    private int _1801017 = 0;
    
    // �{�ݏ��ݕی��Ҕԍ�6��
    private String _1801018 = "";
    
    // �E�v20��
    private String _1801019 = "";

    // �T�[�r�X����(�T�[�r�X�R�[�h�}�X�^TBL��SERVICE_NAME)
    private String _1801020 = "";

    // ���x�z�Ǘ��Ώۃt���O
    private String _1801021 = "";

    // �V�X�e�����T�[�r�X��ރR�[�h(SYSTEM_SERVICE_KIND_DETAIL)
    private String _1801022 = "";

    // �V�X�e�����T�[�r�X���ڃR�[�h(SYSTEM_SERVICE_CODE_ITEM)
    private String _1801023 = "";

    // ����1����^�C�v
    private String _1801024 = "";

    // ����2����^�C�v
    private String _1801025 = "";

    // ����3����^�C�v
    private String _1801026 = "";

    // ���t����
    private int _1801027 = 0;
    
    /**
     * ������񎯕ʔԍ�4�����擾���܂��B
     * 
     * @return
     */
    protected String get_301001() {
        return _1801001;
    }

    /**
     * ������񎯕ʔԍ�4����ݒ肵�܂��B
     * 
     * @param _301001
     */
    protected void set_301001(String _301001) {
        this._1801001 = _301001;
    }

    /**
     * ���R�[�h��ʃR�[�h2�����擾���܂��B
     * 
     * @return
     */
    protected String get_301002() {
        return _1801002;
    }

    /**
     * �T�[�r�X�񋟔N��6��(YYYYMM)���擾���܂��B
     * 
     * @return
     */
    protected String get_301003() {
        return _1801003;
    }

    /**
     * �T�[�r�X�񋟔N��6��(YYYYMM)��ݒ肵�܂��B
     * 
     * @param _301003
     */
    protected void set_301003(String _301003) {
        this._1801003 = _301003;
    }

    /**
     * ���Ə��ԍ�10�����擾���܂��B
     * 
     * @return
     */
    protected String get_301004() {
        return _1801004;
    }

    /**
     * ���Ə��ԍ�10����ݒ肵�܂��B
     * 
     * @param _301004
     */
    protected void set_301004(String _301004) {
        this._1801004 = _301004;
    }

    /**
     * �؋L�ڕی��Ҕԍ�8�����擾���܂��B
     * 
     * @return
     */
    protected String get_301005() {
        return _1801005;
    }

    /**
     * �؋L�ڕی��Ҕԍ�8����ݒ肵�܂��B
     * 
     * @param _301005
     */
    protected void set_301005(String _301005) {
        this._1801005 = _301005;
    }

    /**
     * ��ی��Ҕԍ�10�����擾���܂��B
     * 
     * @return
     */
    protected String get_301006() {
        return _1801006;
    }

    /**
     * ��ی��Ҕԍ�10����ݒ肵�܂��B
     * 
     * @param _301006
     */
    protected void set_301006(String _301006) {
        this._1801006 = _301006;
    }

    /**
     * �T�[�r�X��ރR�[�h2�����擾���܂��B
     * 
     * @return
     */
    protected String get_301007() {
        return _1801007;
    }

    /**
     * �T�[�r�X��ރR�[�h2����ݒ肵�܂��B
     * 
     * @param _301007
     */
    protected void set_301007(String _301007) {
        this._1801007 = _301007;
    }

    /**
     * �T�[�r�X���ڃR�[�h4�����擾���܂��B
     * 
     * @return
     */
    protected String get_301008() {
        return _1801008;
    }

    /**
     * �T�[�r�X���ڃR�[�h4����ݒ肵�܂��B
     */
    protected void set_301008(String _301008) {
        this._1801008 = _301008;
    }

    /**
     * �P�ʐ�4�����擾���܂��B
     * 
     * @return
     */
    protected int get_301009() {
        return _1801009;
    }

    /**
     * �P�ʐ�4����ݒ肵�܂��B
     * 
     * @param _301009
     */
    protected void set_301009(int _301009) {
        this._1801009 = _301009;
    }

    /**
     * �������2�����擾���܂��B
     * 
     * @return
     */
    protected int get_301010() {
        return _1801010;
    }

    /**
     * �������2����ݒ肵�܂��B
     * 
     * @param _301010
     */
    protected void set_301010(int _301010) {
        this._1801010 = _301010;
    }

    /**
     * ����1�Ώۓ����E��2�����擾���܂��B
     * 
     * @return
     */
    protected int get_301011() {
        return _1801011;
    }

    /**
     * ����1�Ώۓ����E��2����ݒ肵�܂��B
     * 
     * @param _301011
     */
    protected void set_301011(int _301011) {
        this._1801011 = _301011;
    }

    /**
     * ����2�Ώۓ����E��2�����擾���܂��B
     * 
     * @return
     */
    protected int get_301012() {
        return _1801012;
    }

    /**
     * ����2�Ώۓ����E��2����ݒ肵�܂��B
     * 
     * @param _301012
     */
    protected void set_301012(int _301012) {
        this._1801012 = _301012;
    }

    /**
     * ����3�Ώۓ����E��2�����擾���܂��B
     * 
     * @return
     */
    protected int get_301013() {
        return _1801013;
    }

    /**
     * ����3�Ώۓ����E��2����ݒ肵�܂��B
     * 
     * @param _301013
     */
    protected void set_301013(int _301013) {
        this._1801013 = _301013;
    }

    /**
     * �T�[�r�X�P�ʐ�6�����擾���܂��B
     * 
     * @return
     */
    protected int get_301014() {
        return _1801014;
    }

    /**
     * �T�[�r�X�P�ʐ�6����ݒ肵�܂��B
     * 
     * @param _301014
     */
    protected void set_301014(int _301014) {
        this._1801014 = _301014;
    }

    /**
     * ����1�ΏۃT�[�r�X�P�ʐ�6�����擾���܂��B
     * 
     * @return
     */
    protected int get_301015() {
        return _1801015;
    }

    /**
     * ����1�ΏۃT�[�r�X�P�ʐ�6����ݒ肵�܂��B
     * 
     * @param _301015
     */
    protected void set_301015(int _301015) {
        this._1801015 = _301015;
    }

    /**
     * ����2�ΏۃT�[�r�X�P�ʐ�6�����擾���܂��B
     * 
     * @return
     */
    protected int get_301016() {
        return _1801016;
    }

    /**
     * ����2�ΏۃT�[�r�X�P�ʐ�6����ݒ肵�܂��B
     * 
     * @param _301016
     */
    protected void set_301016(int _301016) {
        this._1801016 = _301016;
    }

    /**
     * ����3�ΏۃT�[�r�X�P�ʐ�6�����擾���܂��B
     * 
     * @return
     */
    protected int get_301017() {
        return _1801017;
    }

    /**
     * ����3�ΏۃT�[�r�X�P�ʐ�6����ݒ肵�܂��B
     * 
     * @param _301017
     */
    protected void set_301017(int _301017) {
        this._1801017 = _301017;
    }

    /**
     * �{�ݏ��ݕی��Ҕԍ�6�����擾���܂��B
     * 
     * @return
     */
    protected String get_1801018() {
        return _1801018;
    }

    /**
     * �{�ݏ��ݕی��Ҕԍ�6����ݒ肵�܂��B
     * 
     * @param _1801018
     */
    protected void set_1801018(String _1801018) {
        this._1801018 = _1801018;
    }
    
    /**
     * �E�v20�����擾���܂��B
     * 
     * @return
     */
    protected String get_301018() {
        return _1801019;
    }

    /**
     * �E�v20����ݒ肵�܂��B
     * 
     * @param _301018
     */
    protected void set_301018(String _301018) {
        this._1801019 = _301018;
    }

    /**
     * �T�[�r�X����(�T�[�r�X�R�[�h�}�X�^TBL��SERVICE_NAME)���擾���܂��B
     * 
     * @return
     */
    protected String get_301019() {
        return _1801020;
    }

    /**
     * �T�[�r�X����(�T�[�r�X�R�[�h�}�X�^TBL��SERVICE_NAME)��ݒ肵�܂��B
     * 
     * @param _301019
     */
    protected void set_301019(String _301019) {
        this._1801020 = _301019;
    }

    /**
     * ���x�z�Ǘ��Ώۃt���O���擾���܂��B
     * 
     * @return
     */
    protected String get_301020() {
        return _1801021;
    }

    /**
     * ���x�z�Ǘ��Ώۃt���O��ݒ肵�܂��B
     * 
     * @param _301020
     */
    protected void set_301020(String _301020) {
        this._1801021 = _301020;
    }

    /**
     * �V�X�e�����T�[�r�X��ރR�[�h(SYSTEM_SERVICE_KIND_DETAIL)���擾���܂��B
     * 
     * @return
     */
    protected String get_301021() {
        return _1801022;
    }

    /**
     * �V�X�e�����T�[�r�X��ރR�[�h(SYSTEM_SERVICE_KIND_DETAIL)��ݒ肵�܂��B
     * 
     * @param _301021
     */
    protected void set_301021(String _301021) {
        this._1801022 = _301021;
    }

    /**
     * �V�X�e�����T�[�r�X���ڃR�[�h(SYSTEM_SERVICE_CODE_ITEM)���擾���܂��B
     * 
     * @return
     */
    protected String get_301022() {
        return _1801023;
    }

    /**
     * �V�X�e�����T�[�r�X���ڃR�[�h(SYSTEM_SERVICE_CODE_ITEM)��ݒ肵�܂��B
     * 
     * @param _301022
     */
    protected void set_301022(String _301022) {
        this._1801023 = _301022;
    }

    /**
     * ����1����^�C�v���擾���܂��B
     * 
     * @return
     */
    protected String get_301023() {
        return _1801024;
    }

    /**
     * ����1����^�C�v��ݒ肵�܂��B
     * 
     * @param _301023
     */
    protected void set_301023(String _301023) {
        this._1801024 = _301023;
    }

    /**
     * ����2����^�C�v���擾���܂��B
     * 
     * @return
     */
    protected String get_301024() {
        return _1801025;
    }

    /**
     * ����2����^�C�v��ݒ肵�܂��B
     * 
     * @param _301024
     */
    protected void set_301024(String _301024) {
        this._1801025 = _301024;
    }

    /**
     * ����3����^�C�v���擾���܂��B
     * 
     * @return
     */
    protected String get_301025() {
        return _1801026;
    }

    /**
     * ����3����^�C�v��ݒ肵�܂��B
     * 
     * @param _301025
     */
    protected void set_301025(String _301025) {
        this._1801026 = _301025;
    }

    /**
     * ���t�������擾���܂��B
     * 
     * @return
     */
    protected int get_301026() {
        return _1801027;
    }

    /**
     * ���t������ݒ肵�܂��B
     * 
     * @param _301026
     */
    protected void set_301026(int _301026) {
        this._1801027 = _301026;
    }
    
    protected static QP001RecordDetailJushotiTokurei getInstance(String identificationNo,
            Date targetDate, Object targetServiceDate, VRMap serviceDetail,
            VRMap serviceCode, QP001PatientState patientState,VRMap detailMap,QP001Manager manager) throws Exception {
        
    	QP001RecordDetailJushotiTokurei detail = null;
        
        //���R�[�h�̍쐬�ۂ𔻒f
        if(!isMakeRecord(serviceDetail,serviceCode, patientState, targetServiceDate)){
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
            detail = new QP001RecordDetailJushotiTokurei();
            detailMap.put(serial,detail);
        //�����ɍ��v���郌�R�[�h�����݂���ꍇ
        } else {
            detail = (QP001RecordDetailJushotiTokurei)detailMap.get(serial);
        }
        
        return detail;
    }
    
    //2008/09/03 [Shin Fujihara] edit - begin 30�����̒P�ʐ���PatientState�ɕێ�����悤�ύX
    //private static boolean isMakeRecord(VRMap serviceDetail,VRMap serviceCode) throws Exception {
    private static boolean isMakeRecord(VRMap serviceDetail,VRMap serviceCode, QP001PatientState patientState, Object targetServiceDate) throws Exception {
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
        
       
        //�Z���n����Ώێ҂ŁA�n�斧���^�T�[�r�X�̏ꍇ�́A���R�[�h���쐬����B
        if (!ACTextUtilities.isNullText(patientState.getJushotiTokureiInsurerId(targetServiceDate))) {
            if(QP001SpecialCase.isRegionStickingServiceForJushotiTokurei(ACCastUtilities.toString(VRBindPathParser.get("SERVICE_CODE_KIND", serviceCode)))){
            	return true;
            }
        }

        return false;
    }
    
    private static String getSerialId(String identificationNo,
            Date targetDate, Object targetServiceDate, VRMap serviceDetail,
            VRMap serviceCode, QP001PatientState patientState,QP001Manager manager) throws Exception {
        //���R�[�h�̃V���A��ID���쐬
        StringBuilder serial = new StringBuilder();
        // �������ʔԍ�
        serial.append(identificationNo);
        // ���R�[�h��ʃR�[�h2��(02�Œ�)
        serial.append(_1801002);
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
        
        // �{�ݏ��ݕی��Ҕԍ�6��
        serial.append(patientState.getJushotiTokureiInsurerId(targetServiceDate));
        
        //�����p��Ή�
        if(ACCastUtilities.toInt(serviceCode.get("SERVICE_ADD_FLAG"),0) != 3){
            //serial.append(QP001Manager.getInstance().getServiceUnit(String.valueOf(serviceDetail.get("PROVIDER_ID")),serviceCode));
            serial.append(manager.getServiceUnit(String.valueOf(serviceDetail.get("PROVIDER_ID")),serviceCode));
        } else {
            serial.append(ACCastUtilities.toInt(serviceCode.get("SERVICE_UNIT"),0));
        }
        
        serial.append(QP001SpecialCase.getDetailSerial(serviceDetail,serviceCode));
        
        return serial.toString();
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
    	
    	//���׏��Ɠ���
    	super.parse(serviceDetail, targetDate, patientState, serviceCode, identificationNo, manager);
    	
        Object targetServiceDate = VRBindPathParser.get("SERVICE_DATE",
                serviceDetail);
    	//�{�ݏ��ݕی��Ҕԍ�
    	set_1801018(patientState.getJushotiTokureiInsurerId(targetServiceDate));
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
        setData(result, "1801001", get_301001());
        // ���R�[�h��ʃR�[�h2��(14��ݒ�)
        setData(result, "1801002", get_301002());
        // �T�[�r�X�񋟔N��6��(YYYYMM)
        setData(result, "1801003", get_301003());
        // ���Ə��ԍ�10��
        setData(result, "1801004", get_301004());
        // �؋L�ڕی��Ҕԍ�8��
        setData(result, "1801005", get_301005());
        // ��ی��Ҕԍ�10��
        setData(result, "1801006", get_301006());
        // �T�[�r�X��ރR�[�h2��
        setData(result, "1801007", get_301007());
        // �T�[�r�X���ڃR�[�h4��
        setData(result, "1801008", get_301008());
        // �P�ʐ�4��
        setData(result, "1801009", get_301009());

        //�������2��
        setData(result, "1801010", get_301010());
        //����1�Ώۓ����E��2��
        setData(result, "1801011", get_301011());
        //����2�Ώۓ����E��2��
        setData(result, "1801012", get_301012());
        //����3�Ώۓ����E��2��
        setData(result, "1801013", get_301013());
        //�T�[�r�X�P�ʐ�6��
        setData(result, "1801014", get_301014());
        //����1�ΏۃT�[�r�X�P�ʐ�6��
        setData(result, "1801015", get_301015());
        //����2�ΏۃT�[�r�X�P�ʐ�6��
        setData(result, "1801016", get_301016());
        //����3�ΏۃT�[�r�X�P�ʐ�6��
        setData(result, "1801017", get_301017());
        
        //�{�ݏ��ݕی��Ҕԍ�6��
        setData(result, "1801018", get_1801018());
        //�E�v20��
        setData(result, "1801019", get_301018());
        
        //�T�[�r�X����(�T�[�r�X�R�[�h�}�X�^TBL��SERVICE_NAME)
        setData(result, "1801020", get_301019());

        //���x�z�Ǘ��Ώۃt���O
        setData(result, "1801021", get_301020());
		//�V�X�e�����T�[�r�X��ރR�[�h(SYSTEM_SERVICE_KIND_DETAIL)
		setData(result,"1801022",get_301021());
		//�V�X�e�����T�[�r�X���ڃR�[�h(SYSTEM_SERVICE_CODE_ITEM)
		setData(result,"1801023",get_301022());

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
        //���׏��i�Z���n����j���R�[�h        
        result.put("CATEGORY_NO", QkanConstants.CATEGORY_NO_RECORD_DETAILED_JUSHOTI_TOKUREI);
        return result;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("[1801001=" + get_301001() + "]\n");
        result.append("[1801002=" + get_301002() + "]\n");
        result.append("[1801003=" + get_301003() + "]\n");
        result.append("[1801004=" + get_301004() + "]\n");
        result.append("[1801005=" + get_301005() + "]\n");
        result.append("[1801006=" + get_301006() + "]\n");
        result.append("[1801007=" + get_301007() + "]\n");
        result.append("[1801008=" + get_301008() + "]\n");
        result.append("[1801009=" + get_301009() + "]\n");
        result.append("[1801010=" + get_301010() + "]\n");
        result.append("[1801011=" + get_301011() + "]\n");
        result.append("[1801012=" + get_301012() + "]\n");
        result.append("[1801013=" + get_301013() + "]\n");
        result.append("[1801014=" + get_301014() + "]\n");
        result.append("[1801015=" + get_301015() + "]\n");
        result.append("[1801016=" + get_301016() + "]\n");
        result.append("[1801017=" + get_301017() + "]\n");        
        result.append("[1801018=" + get_1801018() + "]\n");
        result.append("[1801019=" + get_301018() + "]\n");
        result.append("[1801020=" + get_301019() + "]\n");
        result.append("[1801021=" + get_301020() + "]\n");
        result.append("[1801022=" + get_301021() + "]\n");
        result.append("[1801023=" + get_301022() + "]\n");
        result.append("[1801024=" + get_301023() + "]\n");
        result.append("[1801025=" + get_301024() + "]\n");
        result.append("[1801026=" + get_301025() + "]\n");
        result.append("[1801027=" + get_301026() + "]\n");
        //result.append(kohiManager);
        return result.toString();
    }    
    
}
