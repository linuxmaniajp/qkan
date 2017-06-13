package jp.nichicom.ac.lib.care.claim.print.schedule;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

import jp.nichicom.ac.ACConstants;
import jp.nichicom.ac.core.ACDBManagerCreatable;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.lib.care.claim.calculation.QP001SpecialCase;
import jp.nichicom.ac.lib.care.claim.servicecode.CareServiceCommon;
import jp.nichicom.ac.lib.care.claim.servicecode.QkanValidServiceCommon;
import jp.nichicom.ac.lib.care.claim.servicecode.QkanValidServiceManager;
import jp.nichicom.ac.sql.ACDBManager;
import jp.nichicom.ac.text.ACBorderBlankDateFormat;
import jp.nichicom.ac.text.ACKanaConvert;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.ac.util.ACDateUtilities;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.text.parsers.VRDateParser;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.QkanConstants;
import jp.or.med.orca.qkan.text.QkanJotaiCodeUnapplicableFormat;

/**
 * �T�[�r�X�\��E���т̒��[����Ǘ��N���X�ł��B
 * <p>
 * Copyright (c) 2005 Nippon Computer Corpration. All Rights Reserved.
 * </p>
 * 
 * @author Tozo Tanaka
 * @version 1.0 2006/03/31
 */
public class CareServiceSchedulePrintManager extends HashMap {

    /**
     * �ی����t�z������킷�Y���萔�ł��B
     */
    public final static int INDEX_OF_INSURE_COST = 6;
    /**
     * �敪�x�����x����P�ʐ�������킷�Y���萔�ł��B
     */
    public final static int INDEX_OF_LIMIT_IN_UNIT = 4;
    /**
     * �敪�x�����x��𒴂���P�ʐ�������킷�Y���萔�ł��B
     */
    public final static int INDEX_OF_LIMIT_OVER_UNIT = 3;
    /**
     * �敪�x�����x��𒴂���P�ʐ��̓��e�ʏ��v������킷�Y���萔�ł��B
     */
    public final static int INDEX_OF_LIMIT_OVER_UNIT_FOR_DETAIL = 2;
    /**
     * �T�[�r�X�P��/���z������킷�Y���萔�ł��B
     */
    public final static int INDEX_OF_SERVICE_UNIT = 1;
    /**
     * �T�[�r�X�P��/���z�̓��e�ʏ��v������킷�Y���萔�ł��B
     */
    public final static int INDEX_OF_SERVICE_UNIT_FOR_DETAIL = 0;
    /**
     * 30�����ƂȂ闘�p�Ҏ��ȕ��S������킷�Y���萔�ł��B
     */
    public final static int INDEX_OF_USER_COST_ON_30OVER = 9;
    /**
     * �ʕ\�p�̔z����萔�ł��B
     */
    public final static int INDEX_OF_TOTAL_ARRAY_SIZE = 10;
    /**
     * ��p���z������킷�Y���萔�ł��B
     */
    public final static int INDEX_OF_TOTAL_COST = 5;
    /**
     * ���p�ҕ��S�i�S�z�Ώە��j������킷�Y���萔�ł��B
     */
    public final static int INDEX_OF_USER_COST_ON_FULL = 8;
    /**
     * ���p�ҕ��S�i�ی��Ώە��j������킷�Y���萔�ł��B
     */
    public final static int INDEX_OF_USER_COST_ON_INSURE = 7;
    /**
     * ����ɏ��v���o�͂��ׂ����ׂ�����킷�T�[�r�X���e��Ԓ萔�ł��B
     */
    public final static int ITEM_STATE_MULTI_LAST = 3;
    /**
     * ���ׂ�����킷�T�[�r�X���e��Ԓ萔�ł��B
     */
    public final static int ITEM_STATE_MULTI_NOT_LAST = 2;
    /**
     * ���t�Ǘ��Ώی��x�z�O������킷�T�[�r�X���e��Ԓ萔�ł��B
     */
    public final static int ITEM_STATE_OUT_LIMIT_AMOUNT = 4;
    /**
     * ���v���܂ޖ��ׂ�����킷�T�[�r�X���e��Ԓ萔�ł��B
     */
    public final static int ITEM_STATE_SINGLE = 1;

    private CareServiceCodeCalcurater calcurater;

    /**
     * ���Ə��P�ʂɕ������ďo�͂��邩
     */
    private boolean buildDivedProvider = true;
    /**
     * �{�݌n�T�[�r�X��{�\�Ɉ�����邩
     */
    private boolean printFacilities;
    /**
     * �O���[�v�z�[��/����{�݌n�T�[�r�X��{�\�Ɉ�����邩
     */
    private boolean printLifeCare;
    /**
     * �{�[�̎���Ɂ����L�ڂ��邩
     */
    private boolean printTriangle;
    /**
     * ����×{�Ǘ��w����{�\�Ɉ�����邩
     */
    private boolean printHomeMedicalAdvice = false;
    // [H27.4�����Ή�][Shinobu Hitaka] 2015/3/16 add - begin
    /**
     * ���ʒn����Z�E���K�͎��Ə����Z��{�\�Ɉ�����邩
     */
    private boolean printSpecialArea = false;
    /**
     * ���R�Ԓn�擙�񋟉��Z��{�\�Ɉ�����邩
     */
    private boolean printChusankanArea = false;
    /**
     * ���E���������P���Z��{�\�Ɉ�����邩
     */
    private boolean printSyoguKaizen = false;
    // [H27.4�����Ή�][Shinobu Hitaka] 2015/3/16 add - end

    private boolean subParse = true;

    private int targetDayShortStayCount;

    private int userMainTableRowCount = 14;
    
    // [ID:0000745][Masahiko.Higuchi] �������P���Z���܂ތv�Z�Ή� add - begin
    // �O�����疳����f�o�b�O���[�h�ɐݒ肷��t���O
    private boolean ultimateDebugFlag = false;
    // [ID:0000745][Masahiko.Higuchi] add - end

    //2006/06/09 tozo TANAKA begin-replace �ʕ\�@�����̂���
    //private int userSubTableRowCount = 17;
    //2006/06/09 tozo TANAKA end-replace �ʕ\�@�����̂���
    
    // [H27.4�����Ή�][Shinobu Hitaka] 2015/1/23 edit - begin �ʕ\�l���ύX
    private int userSubTableRowCount = 19;
    // [H27.4�����Ή�][Shinobu Hitaka] 2015/1/23 edit - end    
    
    // [ID:0000682] 2012/01 start ���E���������P���Z�̒ǉ�����
    private Map<String,Integer> regulationHash = null; // ���ȕ��S�z
    private Map<String,Integer> diagnosisHash = null; //����f�Ô�E���ʗ×{��
    // [ID:0000682] 2012/01 end
    // [ID:0000734][Masahiko.Higuchi] 2012/04 ����24�N4���@�����Ή� add begin
    private VRMap over30UnitSyoguHash = null; //30�����̏������P�ΏےP�ʐ��n�b�V��
    // [ID:0000734][Masahiko.Higuchi] 2012/04 ����24�N4���@�����Ή� add end
    
    // [2014�N�v�]][Shinobu Hitaka] 2014/10/23 add begin �h�̕\��
    private String printKeisyo = "";
    // [2014�N�v�]][Shinobu Hitaka] 2014/10/23 add end   �h�̕\��
    
    private ACBorderBlankDateFormat yearMonthFormat = new ACBorderBlankDateFormat(
            "ggge�NMM��");

    // [H27.4�����Ή�][Yoichiro Kamei] 2015/4/3 add - begin �T�[�r�X�񋟑̐����Z�̎��ȕ��S�Ή�
    private SelfPaymentNumberCalcurater selfPaymentNumberCalcurater;
    // [H27.4�����Ή�][Yoichiro Kamei] 2015/4/3 add - end
    
// 2016/7/19 [�������ƑΉ�][Yoichiro Kamei] add - begin
    private int jigyotaishoLimitRate; // ���ƑΏێ҂̂Ƃ��ɕ\������敪�x�����x�z
    private static final Date MAX_DATE = ACCastUtilities.toDate("9999/12/31", null);
    
    // ���ƑΏێ҂̍���̋敪�x�����x�z���擾���܂�
    private int getJigyotaishoLimitRate() throws Exception {
        if (jigyotaishoLimitRate > 0) {
            return jigyotaishoLimitRate;
        }
        Date targetDate = getCalcurater().getTargetDate();
        jigyotaishoLimitRate = QkanCommon.getOfficialLimitRate(getCalcurater().getDBManager(),
                targetDate, new Integer(1), String.valueOf(QkanConstants.YOUKAIGODO_JIGYOTAISHO));
        
        return jigyotaishoLimitRate;
    }
// 2016/7/19 [�������ƑΉ�][Yoichiro Kamei] add - end
    
    /**
     * �{�[�̎���Ɂ����L�ڂ��邩 ��Ԃ��܂��B
     * 
     * @return �{�[�̎���Ɂ����L�ڂ��邩
     */
    protected boolean isPrintTriangle() {
        return printTriangle;
    }

    /**
     * �{�[�̎���Ɂ����L�ڂ��邩 ��ݒ肵�܂��B
     * 
     * @param printTriangle �{�[�̎���Ɂ����L�ڂ��邩
     */
    protected void setPrintTriangle(boolean printTriangle) {
        this.printTriangle = printTriangle;
    }

    /**
     * �R���X�g���N�^�ł��B
     */
    public CareServiceSchedulePrintManager() {
        super();
    }

    /**
     * �T�[�r�X��ǉ���͂��܂��B
     * 
     * @param services �T�[�r�X
     * @param subParse �ʕ\���Ƃ��Ă���͂��邩
     * @throws Exception ������O
     */
    public int addParse(List services, boolean subParse) throws Exception {
        setSubParse(subParse);

        // 2008/06/01 [Masahiko.Higuchi] add - begin 2007�N�x�Ή�
        /*  
         * ���r���ŗv�x�����v���̏ꍇ��
         * ��z��V�T�[�r�X�������T�[�r�X�ւ̕ϊ�����
         **/
        QkanValidServiceCommon parser = new QkanValidServiceCommon();
        // �f�[�^�x�[�X�}�l�[�W���𐶐�����B
        ACDBManager dbm = ((ACDBManagerCreatable)ACFrame.getInstance().getFrameEventProcesser()).createDBManager();
        // �f�[�^�̃N���[�����쐬����B
        VRList cloneServices = new VRArrayList();
        cloneServices.addAll(services);
        services = new ArrayList();
        if(cloneServices != null && !cloneServices.isEmpty()){
            // �Ώۓ��t
            Date targetDate = getCalcurater().getTargetDate();
            // �ϊ���͏���
            services = parser.createValidService(dbm, targetDate,
                    cloneServices, getCalcurater().getPatientID());
        }
        // 2008/06/01 [Masahiko.Higuchi] add - end 
        
        
        // [ID:0000734][Masahiko.Higuchi] 2012/04 ����24�N4���@�����Ή� add begin
        // 30�����̃T�[�r�X�͌��Ɏ����Ă���
        ArrayList<VRMap> baseList = new ArrayList<VRMap>();
        ArrayList<VRMap> over30List = new ArrayList<VRMap>();
        for(int i=0; i < services.size(); i++) {
            VRMap service = (VRMap)services.get(i);
            if(CareServiceCommon.is30DayOver(service)) {
                over30List.add(service);
            } else {
                baseList.add(service);
            }
        }
        services = new ArrayList();
        services.addAll(baseList);
        services.addAll(over30List);
        // [ID:0000734][Masahiko.Higuchi] 2012/04 add end
        
        // [H27.4�����Ή�][Yoichiro Kamei] 2015/4/3 add - begin �T�[�r�X�񋟑̐����Z�̎��ȕ��S�Ή�
        this.selfPaymentNumberCalcurater = new SelfPaymentNumberCalcurater(getCalcurater(), services);
        // [H27.4�����Ή�][Yoichiro Kamei] 2015/4/3 add - end
        
        int shortStayCount = 0;
        // �ی��Ҕԍ�-��ی��Ҕԍ��̊K�w�ȉ��ɃT�[�r�X���̊K�w���\�z����B
        // �T�[�r�X��0���Ȃ�΁A�v���F�藚���̊K�w�������\�z�����B
        Iterator it = services.iterator();
        while (it.hasNext()) {
            VRMap service = (VRMap) it.next();

            // TODO �f�o�b�O���[�h begin ����������������������������������
            if(isDebugMode()){
               
            }else{
            //TODO �f�o�b�O���[�h end ������������������������������������
            
            if (CareServiceCommon.isFacility(service)
                    && !isPrintFacilityService()) {
                // �{�݌n���o�͂��Ȃ��ݒ�Ȃ�΃X�L�b�v
                continue;
            }
            if (CareServiceCommon.isLifeCare(service) && !isPrintLifeCare()) {
                // �O���[�v�z�[���ƃP�A�n�E�X���o�͂��Ȃ��ݒ�Ȃ�΃X�L�b�v
                continue;
            }
            if (CareServiceCommon.isCareManagement(service)) {
                // ������x���̓X�L�b�v
                continue;
            }
            if (CareServiceCommon.isHomeMedicalAdvice(service)&& !isPrintHomeMedicalAdvice()) {
                // ����×{�Ǘ��w�����o�͂��Ȃ��ݒ�Ȃ�΃X�L�b�v
                continue;
            }
            
            // TODO �f�o�b�O���[�h begin ����������������������������������
            }
            //TODO �f�o�b�O���[�h end ������������������������������������

            Date date = ACCastUtilities.toDate(service.get("SERVICE_DATE"),
                    null);
            if (date != null) {
                // �T�[�r�X�񋟓��͕K�{
                // �T�[�r�X�Ώ۔N��������Y������v���F�藚�����擾����B
                VRMap insureInfo = getCalcurater()
                        .getPatientInsureInfoOnTargetDay(date);
                if (insureInfo != null) {
                    Object key = insureInfo.get("INSURER_ID");
                    if (ACTextUtilities.isNullText(key)) {
                        // �ی��Ҕԍ��Ȃ��Ȃ疳��
                        continue;
                    }
                    Object val = CareServiceSchedulePrintManager.this.get(key);
                    DivedInsurer page;
                    // �ی��Ҕԍ��ŕ���
                    if (val instanceof DivedInsurer) {
                        page = (DivedInsurer) val;
                    } else {
                        page = new DivedInsurer();
                        CareServiceSchedulePrintManager.this.put(key, page);
                    }
                    // ����ی��Ҕԍ����ŕ���
                    page.parse(service, insureInfo);
                }

                // [ID:0000764][Masahiko.Higuchi] edit - begin 30�����̕ʕ\�󎚏�Q�Ή�
                if (CareServiceCommon.isShortStay(service) && !CareServiceCommon.is30DayOver(service)) {
                // [ID:0000764][Masahiko.Higuchi] edit - end
                    shortStayCount++;
                }
            }
        }
        //2�����
        parseSubSecond();
        setSubParse(true);
        return shortStayCount;
    }
    
    /**
     * %���Z���ɑΉ����邽�߁A�ʕ\�p��2�i�K��͂��s���܂��B
     * @throws Exception ������O
     */
    protected void parseSubSecond() throws Exception{
        Iterator it = CareServiceSchedulePrintManager.this.entrySet().iterator();
        while (it.hasNext()) {
            ((DivedInsurer) ((Map.Entry) it.next()).getValue()).parseSubSecond();
        }
    }

    /**
     * ���p�[�{�\���\�z���܂��B
     * 
         * @param buildParam �󎚓��e�W��
     * @param insuredPageList ��ی��ҕʃy�[�W�W��
     * @throws Exception ������O
     * @return 1���ȏ�f�[�^�����邩
     */
    public boolean buildUserMainTable(CareServicePrintParameter buildParam, List insuredPageList)
            throws Exception {
        
        VRMap formPage = createUserMainTablePageFormat(buildParam);
        buildParam.setFormPage(formPage);

        boolean exists = false;
        Iterator it = CareServiceSchedulePrintManager.this.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry ent = (Map.Entry) it.next();
            DivedInsurer services = (DivedInsurer) ent.getValue();
            // ���ʏ��\�z
            exists |= services.buildUserMainTable(buildParam, insuredPageList);
        }
        return exists;
    }

    /**
     * ���p�[�ʕ\���\�z���܂��B
     * 
         * @param buildParam �󎚓��e�W��
     * @param insuredPageList ��ی��ҕʃy�[�W�W��
     * @throws Exception ������O
     * @return 1���ȏ�f�[�^�����邩
     */
    public boolean buildUserSubTable(CareServicePrintParameter buildParam, List insuredPageList) throws Exception {
        VRMap formPage = createUserSubTablePageFormat(buildParam);
        buildParam.setFormPage(formPage);

        boolean exists = false;
        Iterator it = CareServiceSchedulePrintManager.this.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry ent = (Map.Entry) it.next();
            DivedInsurer services = (DivedInsurer) ent.getValue();
            // ���ʏ��\�z
            exists |= services.buildUserSubTable(buildParam, insuredPageList);
        }
        return exists;
    }

    /**
     * 1�߂̃T�[�r�X����Ԃ��܂��B
     * 
     * @return 1�߂̃T�[�r�X���
     */
    public VRMap getFirstService() {
        if (CareServiceSchedulePrintManager.this.size() > 0) {
            return ((DivedInsurer) CareServiceSchedulePrintManager.this.values()
                    .iterator().next()).getFirstService();
        }
        return null;
    }

    /**
     * �K�p�������������܂��B
     * 
     * @param calcurater �T�[�r�X�P�ʌv�Z�N���X
     * @throws Exception ������O
     */
    public void initialize(CareServiceCodeCalcurater calcurater)
            throws Exception {
        setCalcurater(calcurater);
        CareServiceSchedulePrintManager.this.clear();

        // �O���[�v�z�[��/����{�݂�{�\�ɋL�ڂ��邩�̐ݒ���`�F�b�N
        if (ACFrame.getInstance().hasProperty(
                "PrintConfig/NinchishoTokuteiShisetsu")) {
            setPrintLifeCare(!"0".equals(ACFrame.getInstance().getProperty(
                    "PrintConfig/NinchishoTokuteiShisetsu")));
        } else {
            setPrintLifeCare(true);
        }

        // �{�݌n��{�\�ɋL�ڂ��邩�̐ݒ���`�F�b�N
        if (ACFrame.getInstance().hasProperty("PrintConfig/ShisetsuService")) {
            setPrintFacilities(!"0".equals(ACFrame.getInstance().getProperty(
                    "PrintConfig/ShisetsuService")));
        } else {
            setPrintFacilities(true);
        }

        // ����×{�Ǘ��w����{�\�ɋL�ڂ��邩�̐ݒ���`�F�b�N
        if (ACFrame.getInstance().hasProperty("PrintConfig/HomeMedicalAdvice")) {
            setPrintHomeMedicalAdvice(!"0".equals(ACFrame.getInstance().getProperty(
                    "PrintConfig/HomeMedicalAdvice")));
        } else {
            setPrintHomeMedicalAdvice(false);
        }

        // ���ʒn����Z�E���K�͎��Ə����Z��{�\�ɋL�ڂ��邩�̐ݒ���`�F�b�N
        if (ACFrame.getInstance().hasProperty("PrintConfig/PrintSpecialArea")) {
            setPrintSpecialArea(!"0".equals(ACFrame.getInstance().getProperty(
                    "PrintConfig/PrintSpecialArea")));
        } else {
            setPrintHomeMedicalAdvice(false);
        }
        
        // ���R�Ԓn�擙�񋟉��Z��{�\�ɋL�ڂ��邩�̐ݒ���`�F�b�N
        if (ACFrame.getInstance().hasProperty("PrintConfig/PrintChusankanArea")) {
            setPrintChusankanArea(!"0".equals(ACFrame.getInstance().getProperty(
                    "PrintConfig/PrintChusankanArea")));
        } else {
            setPrintHomeMedicalAdvice(false);
        }
        
        // ���E���������P���Z��{�\�ɋL�ڂ��邩�̐ݒ���`�F�b�N
        if (ACFrame.getInstance().hasProperty("PrintConfig/PrintSyoguKaizen")) {
            setPrintSyoguKaizen(!"0".equals(ACFrame.getInstance().getProperty(
                    "PrintConfig/PrintSyoguKaizen")));
        } else {
            setPrintHomeMedicalAdvice(false);
        }
        
        // �{�[�̎���Ɂ����L�ڂ��邩�̐ݒ���`�F�b�N
        if (ACFrame.getInstance().hasProperty("PrintConfig/PrivateExpenses")) {
            setPrintTriangle(!"0".equals(ACFrame.getInstance().getProperty(
                    "PrintConfig/PrivateExpenses")));
        } else {
            setPrintTriangle(false);
        }

        // �ً}���K��Ō���Z�E���ʊǗ����Z�͌�1��Z��Ƃ��邩 �̐ݒ���`�F�b�N
        if (ACFrame.getInstance().hasProperty("PrintConfig/OncePerMonth")) {
            getCalcurater()
                    .setOncePerMonthOfAddEmergencyNursingAndSpecialManagement(
                            !"0".equals(ACFrame.getInstance().getProperty(
                                    "PrintConfig/OncePerMonth")));
        } else {
            getCalcurater()
                    .setOncePerMonthOfAddEmergencyNursingAndSpecialManagement(
                            true);
        }
    }

    /**
     * ���Ə��P�ʂɕ������ďo�͂��邩��Ԃ��܂��B
     * 
     * @return ���Ə��P�ʂɕ������ďo�͂��邩
     */
    public boolean isBuildDivedProvider() {
        return buildDivedProvider;
    }

    /**
     * �T�[�r�X����͂��܂��B
     * 
     * @param services �T�[�r�X
     * @throws Exception ������O
     */
    public void parse(List services) throws Exception {
        // [ID:0000682] 2012/01 start ���E���������P���Z�̒ǉ�����
        // ����f�Ô�E���ʗ×{��̒P�ʐ��̍����p�ɑޔ�����
        ACDBManager dbm = ((ACDBManagerCreatable)ACFrame.getInstance().getFrameEventProcesser()).createDBManager();
        CareServicePrecomputed diagnoClass = new CareServicePrecomputed();
        regulationHash = new HashMap<String, Integer>();
        diagnosisHash = new HashMap<String, Integer>();
        diagnoClass.setPrecomputedResult(dbm, services, regulationHash, diagnosisHash);
        // [ID:0000682] 2012/01 end
        // [ID:0000734][Masahiko.Higuchi] 2012/04 ����24�N4���@�����Ή� add begin
        over30UnitSyoguHash = new VRHashMap();
        // [ID:0000734][Masahiko.Higuchi] 2012/04 add end
        
        // �v���F�藚������ی��Ҕԍ�-��ی��Ҕԍ��̊K�w���\�z����B
        parseInsureInfo();

        int shortStayCount = addParse(services, true);
        setTargetDayShortStayCount(shortStayCount);
    }

    /**
     * ���Ə��P�ʂɕ������ďo�͂��邩��ݒ肵�܂��B
     * 
     * @param divedProvider ���Ə��P�ʂɕ������ďo�͂��邩
     */
    public void setBuildDivedProvider(boolean divedProvider) {
        this.buildDivedProvider = divedProvider;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Iterator it = CareServiceSchedulePrintManager.this.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry ent = (Map.Entry) it.next();
            sb.append(ACConstants.LINE_SEPARATOR);
            sb.append("�ی��Ҕԍ��F");
            sb.append(ent.getKey());
            sb.append(ACConstants.LINE_SEPARATOR);
            sb.append(ent.getValue());
        }
        return sb.toString();
    }

    /**
     * ���p�[�{�\�̐��`�𐶐����܂��B
     * 
         * @param buildParam �󎚓��e�W��
     * @return ���p�[�{�\�̐��`
     * @throws Exception ������O
     */
    protected VRMap createUserMainTablePageFormat(CareServicePrintParameter buildParam)
            throws Exception {
        VRMap formPage = new VRHashMap();

        VRMap patient = getCalcurater().getPatientInfo();
        if (patient != null) {
            // [2014�N�v�]][Shinobu Hitaka] 2014/10/23 add begin �h�̕\��
            // ��ی��Ҏ���
            //formPage.put("upper.h5.w15", QkanCommon.toFullName(patient
            //        .get("PATIENT_FAMILY_NAME"), patient
            //        .get("PATIENT_FIRST_NAME")));
            formPage.put("upper.h5.w15", QkanCommon.toFullName(patient
                    .get("PATIENT_FAMILY_NAME"), patient
                    .get("PATIENT_FIRST_NAME")) + this.printKeisyo);
            // [2014�N�v�]][Shinobu Hitaka] 2014/10/23 add end   �h�̕\��
            
            // �J�i����
            formPage.put("upper.h4.w15", ACKanaConvert.toKatakana(QkanCommon
                    .toFullName(patient.get("PATIENT_FAMILY_KANA"), patient
                            .get("PATIENT_FIRST_KANA"))));
            // ����
            formPage.put("upper.h6.w12", QkanConstants.FORMAT_SEX
                    .format(patient.get("PATIENT_SEX")));
            // ���N����
            Date birth = ACCastUtilities
                    .toDate(patient.get("PATIENT_BIRTHDAY"));
            formPage.put("patientBirthDay", VRDateParser
                    .format(birth, "e�NM��d��"));
            formPage.put("patientBirthDayEra", ACDateUtilities
                    .getEraFull(birth));
        }

        Object obj;
        // �Ώ۔N��
        formPage.put("targetDate", getCalcurater().getTextOfTargetYearMonth());

        //2006/06/09 tozo TANAKA begin-delete �@�����ɂ��g�O�폜
//        // �쐬�N����(�g�O)
//        String createDate =ACConstants.FORMAT_FULL_ERA_YMD.format(buildParam.getPrintParameter()
//                .get("CREATE_DATE_OUTER")); 
//        if(ACTextUtilities.isNullText(createDate)){
//            createDate = "�@�@�@�@�@�@�@�@";
//        }
//        formPage.put("createDateOuter", "�쐬�N�����F " + createDate);
        //2006/06/09 tozo TANAKA end-delete
        
        // �쐬�N����
        formPage.put("upper.h1.w28", ACConstants.FORMAT_FULL_ERA_YMD
                .format(buildParam.getPrintParameter().get("CREATE_DATE_INNER")));
        // �͏o�N����
        obj = buildParam.getPrintParameter().get("DATE_OF_WRITTEN_REPORT");
        if (!ACTextUtilities.isNullText(obj)) {
            formPage.put("upper.h4.w28", ACConstants.FORMAT_FULL_ERA_YMD
                    .format(obj));
        }
        // �O���܂ł̒Z���������p����
        formPage.put("shortStayUseDay", buildParam.getPrintParameter().get("SHORT_STAY_USE_DAY"));

        // ���Ǝ҂��쐬�����ꍇ
        Map provider = getCalcurater().getProvider(buildParam.getPrintParameter());
        if (provider != null) {
            StringBuilder sb = new StringBuilder();

            // ������x�����ƎҎ��Ə���
            sb.append(provider.get("PROVIDER_NAME"));
            // ������x�����ƎҎ��A����
            String fax = QkanCommon.toTel(provider.get("PROVIDER_FAX_FIRST"),
                    provider.get("PROVIDER_FAX_SECOND"), provider
                            .get("PROVIDER_FAX_THIRD"));
            if (!"".equals(fax)) {
                fax = "FAX:" + fax;
            }
            String tel = QkanCommon.toTel(provider.get("PROVIDER_TEL_FIRST"),
                    provider.get("PROVIDER_TEL_SECOND"), provider
                            .get("PROVIDER_TEL_THIRD"));
            if (!"".equals(tel)) {
                tel += " ";
            }
            if ((tel.length() > 0) || (fax.length() > 0)) {
                sb.append(ACConstants.LINE_SEPARATOR);
                sb.append(tel);
                sb.append(fax);
            }
            // ������x�����ƎҒS���Җ�
            obj = buildParam.getPrintParameter().get("STAFF_NAME");
            if (obj != null) {
                String staffName = ACCastUtilities.toString(obj);
                if (staffName.length() > 0) {
                    sb.append(ACConstants.LINE_SEPARATOR);
                    sb.append(staffName);
                }
            }

            formPage.put("upper.h1.w23", sb.toString());
        }

        // �j���̓��ȊO�͊ۂ��͂���
        final String[] wdays = new String[] { "��", "��", "��", "��", "��", "��", "�y" };
        Date last = getCalcurater().getLastDayOfMonth();
        int lastDay = ACDateUtilities.getDayOfMonth(last);
        int wday = getCalcurater().getDayOfWeekOnTargetFirstDay() - 1;
        for (int i = 1; i <= lastDay; i++) {
            formPage.put("lowerValue.y.x" + i, wdays[wday]);
            if (wday == 0) {
                formPage.put("lowerValueTriangle.y.x" + i, "��");
            }
            wday = (wday + 1) % 7;
        }
        // �s�v�ȓ��t������
        for (int i = lastDay + 1; i <= 31; i++) {
            formPage.put("lowerValue.d.x" + i, "");
        }

        return formPage;
    }

    /**
     * ���p�[�ʕ\�̐��`�𐶐����܂��B
     * 
         * @param buildParam �󎚓��e�W��
     * @return ���p�[�ʕ\�̐��`
     * @throws Exception ������O
     */
    protected VRMap createUserSubTablePageFormat(CareServicePrintParameter buildParam) throws Exception {
        VRMap formPage = new VRHashMap();
        VRMap patient = getCalcurater().getPatientInfo();
        if (patient != null) {
            // [2014�N�v�]][Shinobu Hitaka] 2014/10/23 add begin �h�̕\��
            // ��ی��Ҏ���
            //formPage.put("insured.h1.insuredName", QkanCommon.toFullName(
            //        patient.get("PATIENT_FAMILY_NAME"), patient
            //                .get("PATIENT_FIRST_NAME")));
            formPage.put("insured.h1.insuredName", QkanCommon.toFullName(
                    patient.get("PATIENT_FAMILY_NAME"), patient
                            .get("PATIENT_FIRST_NAME")) + this.printKeisyo);
            // [2014�N�v�]][Shinobu Hitaka] 2014/10/23 add end   �h�̕\��
        }

        // �Ώ۔N��
        formPage.put("targetDate", "("
                + getCalcurater().getTextOfTargetYearMonth() + ")");

        String createDate =ACConstants.FORMAT_FULL_ERA_YMD.format(buildParam.getPrintParameter()
                .get("CREATE_DATE_OUTER")); 
        if(ACTextUtilities.isNullText(createDate)){
            createDate = "�@�@�@�@�@�@�@�@";
        }
        // �쐬�N����(�g�O)
        formPage.put("createDateOuter", "�쐬�N�����F " + createDate);

        // �Z���������p����
        // �O���܂ł̒Z���������p����
        Object obj = buildParam.getPrintParameter().get("SHORT_STAY_USE_DAY");
        formPage.put("shortStay.h2.pastMonth", obj);
        int prevShortStay = ACCastUtilities.toInt(obj, 0);
        // �����̌v�旘�p����
        formPage.put("shortStay.h2.thisMonth", new Integer(
                getTargetDayShortStayCount()));
        // �ݐϗ��p����
        formPage.put("shortStay.h2.totalDays", new Integer(
                getTargetDayShortStayCount() + prevShortStay));

        // ����t�����܂߂Čv�Z���邩
        obj = buildParam.getPrintParameter().getData("WITH_PUBLIC_EXPENSE");
        if ("1".equals(ACCastUtilities.toString(obj))
                || Boolean.TRUE.equals(obj)) {
            getCalcurater().setCalcWithPublicExpense(true);
        } else {
            getCalcurater().setCalcWithPublicExpense(false);
        }

        return formPage;
    }

    /**
     * �T�[�r�X�P�ʌv�Z�N���X ��Ԃ��܂��B
     * 
     * @return �T�[�r�X�P�ʌv�Z�N���X
     */
    protected CareServiceCodeCalcurater getCalcurater() {
        return calcurater;
    }

    /**
     * �����̒Z���������p���� ��Ԃ��܂��B
     * 
     * @return �����̒Z���������p����
     */
    protected int getTargetDayShortStayCount() {
        return targetDayShortStayCount;
    }

    /**
     * �{�\1��������̃T�[�r�X�L�ڌ�����Ԃ��܂��B
     * 
     * @return �{�\1��������̃T�[�r�X�L�ڌ���
     */
    public int getUserMainTableRowCount() {
        return userMainTableRowCount;
    }

    /**
     * �ʕ\1��������̃T�[�r�X�L�ڌ��� ��Ԃ��܂��B
     * 
     * @return �ʕ\1��������̃T�[�r�X�L�ڌ���
     */
    public int getUserSubTableRowCount() {
        return userSubTableRowCount;
    }

    /**
     * �{�݌n�T�[�r�X��{�\�Ɉ�����邩 ��Ԃ��܂��B
     * 
     * @return �{�݌n�T�[�r�X��{�\�Ɉ�����邩
     */
    protected boolean isPrintFacilityService() {
        return printFacilities;
    }

    /**
     * �O���[�v�z�[��/����{�݌n�T�[�r�X��{�\�Ɉ�����邩 ��Ԃ��܂��B
     * 
     * @return �O���[�v�z�[��/����{�݌n�T�[�r�X��{�\�Ɉ�����邩
     */
    protected boolean isPrintLifeCare() {
        return printLifeCare;
    }

    /**
     * ����×{�Ǘ��w����{�\�Ɉ�����邩 ��Ԃ��܂��B
     * @return ����×{�Ǘ��w����{�\�Ɉ�����邩
     */
    protected boolean isPrintHomeMedicalAdvice() {
        return printHomeMedicalAdvice;
    }

    /**
     * ����×{�Ǘ��w����{�\�Ɉ�����邩 ��Ԃ��܂��B
     * @param printHomeMedicalAdvice ����×{�Ǘ��w����{�\�Ɉ�����邩
     */
    protected void setPrintHomeMedicalAdvice(boolean printHomeMedicalAdvice) {
        this.printHomeMedicalAdvice = printHomeMedicalAdvice;
    }

    // [H27.4�����Ή�][Shinobu Hitaka] 2015/3/10 add - begin 
    /**
     * ���ʒn����Z�E���K�͎��Ə����Z��{�\�Ɉ�����邩 ��Ԃ��܂��B
     * @return ���ʒn����Z�E���K�͎��Ə����Z��{�\�Ɉ�����邩
     */
    protected boolean isPrintSpecialArea() {
        return printSpecialArea;
    }

    /**
     * ���ʒn����Z�E���K�͎��Ə����Z��{�\�Ɉ�����邩 ��Ԃ��܂��B
     * @param printSpecialArea ���ʒn����Z�E���K�͎��Ə����Z��{�\�Ɉ�����邩
     */
    protected void setPrintSpecialArea(boolean printSpecialArea) {
        this.printSpecialArea = printSpecialArea;
    }
    /**
     * ���R�Ԓn�擙�񋟉��Z��{�\�Ɉ�����邩 ��Ԃ��܂��B
     * @return ���R�Ԓn�擙�񋟉��Z��{�\�Ɉ�����邩
     */
    protected boolean isPrintChusankanArea() {
        return printChusankanArea;
    }

    /**
     * ���R�Ԓn�擙�񋟉��Z��{�\�Ɉ�����邩 ��Ԃ��܂��B
     * @param printChusankanArea ���R�Ԓn�擙�񋟉��Z��{�\�Ɉ�����邩
     */
    protected void setPrintChusankanArea(boolean printChusankanArea) {
        this.printChusankanArea = printChusankanArea;
    }
    /**
     * ���E���������P���Z��{�\�Ɉ�����邩 ��Ԃ��܂��B
     * @return ���E���������P���Z��{�\�Ɉ�����邩
     */
    protected boolean isPrintSyoguKaizen() {
        return printSyoguKaizen;
    }

    /**
     * ���E���������P���Z��{�\�Ɉ�����邩 ��Ԃ��܂��B
     * @param printSyoguKaizen ���E���������P���Z��{�\�Ɉ�����邩
     */
    protected void setPrintSyoguKaizen(boolean printSyoguKaizen) {
        this.printSyoguKaizen = printSyoguKaizen;
    }
    // [H27.4�����Ή�][Shinobu Hitaka] 2015/3/10 add - end
    
    /**
     * �ʕ\���Ƃ��Ă���͂��邩 ��Ԃ��܂��B
     * 
     * @return �ʕ\���Ƃ��Ă���͂��邩
     */
    protected boolean isSubParse() {
        return subParse;
    }

    /**
     * �v���F�藚������͂��܂��B
     * 
     * @throws Exception ������O
     */
    protected void parseInsureInfo() throws Exception {
        Iterator it = getCalcurater().getPatientInsureInfoHistoryList()
                .iterator();
        while (it.hasNext()) {
            VRMap insureInfo = (VRMap) it.next();
            Object key = insureInfo.get("INSURER_ID");
            if (ACTextUtilities.isNullText(key)) {
                // �ی��Ҕԍ��Ȃ�
                continue;
            }
            Object val = CareServiceSchedulePrintManager.this.get(key);
            DivedInsurer page;
            // �ی��Ҕԍ��ŕ���
            if (val instanceof DivedInsurer) {
                page = (DivedInsurer) val;
            } else {
                page = new DivedInsurer();
                CareServiceSchedulePrintManager.this.put(key, page);
            }
            // ����ی��Ҕԍ����ŕ���
            page.parseInsureInfo(insureInfo);
        }
    }

    /**
     * �T�[�r�X�P�ʌv�Z�N���X ��ݒ肵�܂��B
     * 
     * @param calcurater �T�[�r�X�P�ʌv�Z�N���X
     */
    protected void setCalcurater(CareServiceCodeCalcurater calcurater) {
        this.calcurater = calcurater;
    }

    /**
     * �{�݌n�T�[�r�X��{�\�Ɉ�����邩 ��ݒ肵�܂��B
     * 
     * @param printFacilities �{�݌n�T�[�r�X��{�\�Ɉ�����邩
     */
    protected void setPrintFacilities(boolean printFacilities) {
        this.printFacilities = printFacilities;
    }

    /**
     * �O���[�v�z�[��/����{�݌n�T�[�r�X��{�\�Ɉ�����邩 ��ݒ肵�܂��B
     * 
     * @param printGroupHome �O���[�v�z�[��/����{�݌n�T�[�r�X��{�\�Ɉ�����邩
     */
    protected void setPrintLifeCare(boolean printGroupHome) {
        this.printLifeCare = printGroupHome;
    }

    /**
     * �ʕ\���Ƃ��Ă���͂��邩 ��ݒ肵�܂��B
     * 
     * @param subParse �ʕ\���Ƃ��Ă���͂��邩
     */
    protected void setSubParse(boolean subParse) {
        this.subParse = subParse;
    }

    /**
     * �����̒Z���������p���� ��ݒ肵�܂��B
     * 
     * @param targetDayShortStayCount �����̒Z���������p����
     */
    protected void setTargetDayShortStayCount(int targetDayShortStayCount) {
        this.targetDayShortStayCount = targetDayShortStayCount;
    }

    /**
     * �{�\1��������̃T�[�r�X�L�ڌ�����Ԃ��܂��B
     * 
     * @param userMainTableRowCount �{�\1��������̃T�[�r�X�L�ڌ���
     */
    public void setUserMainTableRowCount(int userMainTableRowCount) {
        this.userMainTableRowCount = userMainTableRowCount;
    }

    /**
     * �ʕ\1��������̃T�[�r�X�L�ڌ�����Ԃ��܂��B
     * 
     * @param userSubTableRowCount �ʕ\1��������̃T�[�r�X�L�ڌ���
     */
    public void setUserSubTableRowCount(int userSubTableRowCount) {
        this.userSubTableRowCount = userSubTableRowCount;
    }
    public boolean isDebugMode(){
    // TODO �f�o�b�O���[�h begin ����������������������������������
    	
        // [ID:0000745][Masahiko.Higuchi] �������P���Z���܂ތv�Z�Ή� add - begin
    	if(ultimateDebugFlag) {
    		return true;
    	}
        // [ID:0000745][Masahiko.Higuchi] add - end
    	
	    try {
	        if (ACFrame.getInstance().hasProperty("FullServicePrint")
	                && "true".equalsIgnoreCase(ACCastUtilities
	                        .toString(ACFrame.getInstance().getProperty(
	                                "FullServicePrint")))) {
	            return true;
	        }
	    } catch (Exception ex) {
	    }
	    return false;
    //TODO �f�o�b�O���[�h end ������������������������������������
    }

    /**
     * �����f�o�b�O���[�h�t���O��ݒ肵�܂��B
     * @since 6.1.1
     * @param ultimateDebugFlag �����f�o�b�O���[�h���g�p���邩
     */
    public void setUltimateDebugFlag(boolean ultimateDebugFlag) {
		this.ultimateDebugFlag = ultimateDebugFlag;
	}

	/**
     * ��ی��Ҕԍ��P�ʂŐ؂�ւ��y�[�W�f�[�^�ł��B
     * <p>
     * Copyright (c) 2005 Nippon Computer Corpration. All Rights Reserved.
     * </p>
     * 
     * @author Tozo Tanaka
     * @version 1.0 2006/02/15
     */
    protected class DivedInsured extends TreeMap {
        private List insureInfos = new ArrayList();
        private TreeMap mainParseMap = new TreeMap();

        /**
         * ���p�[�{�\���\�z���܂��B
         * 
         * @param buildParam �󎚓��e�W��
         * @throws Exception ������O
         * @return 1���ȏ�f�[�^�����邩
         */
        public boolean buildUserMainTable(CareServicePrintParameter buildParam)
                throws Exception {
            buildParam.setTargetPage((VRMap) buildParam.getFormPage().clone());
            buildParam.setCurrentRow(1);
            Iterator it = DivedInsured.this.mainParseMap.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry ent = (Map.Entry) it.next();
                DivedServiceTime services = (DivedServiceTime) ent.getValue();
                // ���ʏ��\�z
                buildParam.setCurrentRow(services
                        .buildUserMainTable(buildParam));
            }

            if (buildParam.getFormPage().size() < buildParam.getTargetPage()
                    .size()) {
                // �ŏI�y�[�W�ǉ�����o�^
                buildParam.getPages().add(buildParam.getTargetPage());
            } else if (buildParam.getPages().isEmpty()) {
                // �󒠕[
                buildParam.getPages().add(buildParam.getTargetPage());
                return false;
            }
            
            return true;
        }

        /**
         * %���Z���ɑΉ����邽�߁A�ʕ\�p��2�i�K��͂��s���܂��B
         * @throws Exception ������O
         */
        public void parseSubSecond() throws Exception{
            Iterator it = DivedInsured.this.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry ent = (Map.Entry) it.next();
                ((DivedProvider) ent.getValue()).parseSubSecond(ACCastUtilities.toString(ent.getKey()));
            }
        }
        /**
         * ���p�[�ʕ\���\�z���܂��B
         * 
         * @param buildParam �󎚓��e�W��
         * @return ���̏o�͑Ώۍs
         * @throws Exception ������O
         * @return 1���ȏ�f�[�^�����邩
         */
        public boolean buildUserSubTable(CareServicePrintParameter buildParam)
                throws Exception {

            // �y�[�W�ǉ��O�̌�����ޔ�
            int oldSize = buildParam.getPages().size();

            // �ی����t�����擾
            int insureRate = 0;
            VRMap ins = getMostHeavyInsureInfo();
            if (ins != null) {
                insureRate = ACCastUtilities.toInt(ins.get("INSURE_RATE"), 0);
            }

            int[] totals = new int[INDEX_OF_TOTAL_ARRAY_SIZE];

            if (isBuildDivedProvider()) {
                // ���Ə��P�ʂɏo��(�񋟕[)
                int provSize = DivedInsured.this.size();
                int[][] otherTotals = new int[provSize][INDEX_OF_TOTAL_ARRAY_SIZE];
                int[] endPoses = new int[provSize];

                // �S�̃y�[�W�W����ޔ�
                List masterPages = buildParam.getPages();
                int provPos = 0;
                Iterator it = DivedInsured.this.entrySet().iterator();
                while (it.hasNext()) {
                    // ���Ə��ʃy�[�W�W����S�̃y�[�W�W���ƋU������
                    buildParam.setPages(new ArrayList());
                    buildParam.setCurrentRow(1);
                    buildParam.setTargetPage((VRMap) buildParam.getFormPage()
                            .clone());

                    Map.Entry ent = (Map.Entry) it.next();
                    DivedProvider services = (DivedProvider) ent.getValue();
                    // ���ʏ��\�z
                    Map provider = getCalcurater().getProvider(
                            ACCastUtilities.toString(ent
                                    .getKey()));
                    // ���t�Ǘ��Ώ�
                    buildParam.setCurrentRow(services
                            .buildUserSubTableInLimitAmount(buildParam,
                                    provider, insureRate,
                                    otherTotals[provPos]));
                    // ���t�Ǘ��ΏۊO
                    buildParam.setCurrentRow(services
                            .buildUserSubTableOutLimitAmount(buildParam,
                                    provider, insureRate,
                                    otherTotals[provPos]));
                    //30����
                    buildParam.setCurrentRow(services
                            .buildUserSubTable30Over(buildParam,
                                    provider, insureRate,
                                    otherTotals[provPos]));
                    endPoses[provPos] = buildParam.getCurrentRow()-1;

                    if (buildParam.getFormPage().size() < buildParam
                            .getTargetPage().size()) {
                        // �ŏI�y�[�W�ǉ�����o�^
                        buildParam.getPages().add(buildParam.getTargetPage());
                    }
                    if (!buildParam.getPages().isEmpty()) {
                        // �󒠕[�łȂ���Ύ��Ə��ʒ��[�Ƃ��Ēǉ�
                        masterPages.add(buildParam.getPages());
                    } else {
                        // �󒠕[
                        endPoses[provPos] = -1;
                    }
                    provPos++;
                }
                // �S�̃y�[�W�W���𕜋A
                buildParam.setPages(masterPages);

                // �ŏI�I�ȍ��v�ɑ����Ə��������Z
                for (int j = 0; j < provSize; j++) {
                    for (int i = 0; i < INDEX_OF_TOTAL_ARRAY_SIZE; i++) {
                        totals[i] += otherTotals[j][i];
                    }
                }
                // �����Ə����v��ǋL
                provPos = 0;
                int end = provSize;
                for (int j = 0; j < end; j++) {
                     int endPos = endPoses[j] + 1;
                     if (endPos > 0) {
                        // �o�͉\�Ȏ��Ə�
                        List provPages = (List) buildParam.getPages().get(
                                oldSize + provPos);
                        int size = provPages.size();
                        if (size > 0) {
                            int unit = totals[INDEX_OF_SERVICE_UNIT]
                                    - otherTotals[j][INDEX_OF_SERVICE_UNIT];
                            if (unit > 0) {
                                // �����Ə��̃T�[�r�X�P�ʐ���0���傫���ꍇ

                                Map targetPage = (Map) provPages.get(size - 1);
                                
                                // [CCCX:1959][Shinobu Hitaka] 2014/08/22 add begin �T�[�r�X�ŏI�s��MAX�s�����x�̏ꍇ�͂P�s�ڂɏ㏑������̂ŁA���y�[�W����
                                if (endPos == 1){
                                    provPages.add(buildParam.getFormPage().clone());
                                    targetPage = (Map) provPages.get(size);
                                }
                                // [CCCX:1959][Shinobu Hitaka] 2014/08/22 add begin �T�[�r�X�ŏI�s��MAX�s�����x�̏ꍇ�͂P�s�ڂɏ㏑������̂ŁA���y�[�W����
                                
                                // ���Ə���
                                targetPage.put("main.y" + endPos + ".x1",
                                        "�����Ə�");
                                // �T�[�r�X���e/���
                                targetPage.put("main.y" + endPos + ".x3",
                                        "�����Ə����v");
                                // �T�[�r�X�P��/���z
                                targetPage.put("main.y" + endPos + ".x9",
                                        new Integer(unit));
                                int overUnit = totals[INDEX_OF_USER_COST_ON_FULL]
                                        - otherTotals[j][INDEX_OF_USER_COST_ON_FULL];
                                if (overUnit > 0) {

                                    // �敪�x�����x��𒴂���P�ʐ����ݒ肳��Ă���Ƃ�
                                    // [ID:0000587][Tozo TANAKA] 2010/01/22 replace begin �񋟕\�ʕ\�ɂ����闘�p�ҕ��S���P�ʐ��̒n��P���̖��l��
//                                    targetPage.put("main.y" + endPos + ".x12",
//                                            new Integer(overUnit / 10));
                                    targetPage.put("main.y" + endPos + ".x12",
                                            new Integer(totals[INDEX_OF_LIMIT_OVER_UNIT]
                                                               - otherTotals[j][INDEX_OF_LIMIT_OVER_UNIT]));
                                    // [ID:0000587][Tozo TANAKA] 2010/01/22 replace end �񋟕\�ʕ\�ɂ����闘�p�ҕ��S���P�ʐ��̒n��P���̖��l��

                                    // ���p�ҕ��S�i�S�z���S���j
                                    // �敪�x�����x��𒴂���P�ʐ�*�P�ʐ��P��
                                    targetPage.put("main.y" + endPos + ".x19",
                                            new Integer(overUnit));

                                }
                                // �敪�x�����x����P�ʐ�
                                targetPage
                                        .put(
                                                "main.y" + endPos + ".x13",
                                                new Integer(
                                                        totals[INDEX_OF_LIMIT_IN_UNIT]
                                                                - otherTotals[j][INDEX_OF_LIMIT_IN_UNIT]));

                                // ��p���z
                                targetPage
                                        .put(
                                                "main.y" + endPos + ".x15",
                                                new Integer(
                                                        totals[INDEX_OF_TOTAL_COST]
                                                                - otherTotals[j][INDEX_OF_TOTAL_COST]));

                                // �ی����t�z(�؎̂�)
                                targetPage
                                        .put(
                                                "main.y" + endPos + ".x17",
                                                new Integer(
                                                        totals[INDEX_OF_INSURE_COST]
                                                                - otherTotals[j][INDEX_OF_INSURE_COST]));

                                // ���p�ҕ��S�i�ی��Ώە��j
                                targetPage
                                        .put(
                                                "main.y" + endPos + ".x18",
                                                new Integer(
                                                        totals[INDEX_OF_USER_COST_ON_INSURE]
                                                                - otherTotals[j][INDEX_OF_USER_COST_ON_INSURE]));
                            }
                        }
                        provPos++;
                    }
                }

            } else {
                // �ꊇ�o��(���p�[)
                buildParam.setTargetPage((VRMap) buildParam.getFormPage()
                        .clone());

                // �S�̃y�[�W�W����ޔ�
                List masterPages = buildParam.getPages();
                // ���Ə��ʃy�[�W�W����S�̃y�[�W�W���ƋU������
                buildParam.setPages(new ArrayList());
                buildParam.setCurrentRow(1);
                Iterator it;
                // ���t�Ǘ��Ώ�
                it = DivedInsured.this.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry ent = (Map.Entry) it.next();
                    DivedProvider services = (DivedProvider) ent.getValue();
                    // ���ʏ��\�z
                    buildParam.setCurrentRow(services
                            .buildUserSubTableInLimitAmount(buildParam,
                                    getCalcurater().getProvider(
                                            ACCastUtilities.toString(ent
                                                    .getKey())), insureRate,
                                    totals));
                }
                // ���t�Ǘ��ΏۊO
                it = DivedInsured.this.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry ent = (Map.Entry) it.next();
                    DivedProvider services = (DivedProvider) ent.getValue();
                    // ���ʏ��\�z
                    buildParam.setCurrentRow(services
                            .buildUserSubTableOutLimitAmount(buildParam,
                                    getCalcurater().getProvider(
                                            ACCastUtilities.toString(ent
                                                    .getKey())), insureRate,
                                    totals));
                }
                //30����
                it = DivedInsured.this.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry ent = (Map.Entry) it.next();
                    DivedProvider services = (DivedProvider) ent.getValue();
                    // ���ʏ��\�z
                    buildParam.setCurrentRow(services
                            .buildUserSubTable30Over(buildParam,
                                    getCalcurater().getProvider(
                                            ACCastUtilities.toString(ent
                                                    .getKey())), insureRate,
                                    totals));
                  }
                
                if (buildParam.getFormPage().size() < buildParam
                        .getTargetPage().size()) {
                    // �ŏI�y�[�W�ǉ�����o�^
                    buildParam.getPages().add(buildParam.getTargetPage());
                }
                if (!buildParam.getPages().isEmpty()) {
                    // �󒠕[�łȂ���Ύ��Ə��ʒ��[�Ƃ��Ēǉ�
                    masterPages.add(buildParam.getPages());
                }
                // �S�̃y�[�W�W���𕜋A
                buildParam.setPages(masterPages);
            }

            // �y�[�W�ǉ���̌������擾���A�{��ی��Ҕԍ��ɂ����鍇�v��o�^
            int newSize = buildParam.getPages().size();
            for (int i = oldSize; i < newSize; i++) {
                // ���Ə��P�ʂł����Ă����ׂĂɍ��v��t��
                Iterator provIt = ((List) buildParam.getPages().get(i))
                        .iterator();
                while (provIt.hasNext()) {
                    Map page = (Map) provIt.next();
                    // ���v����ǉ�
                    // �T�[�r�X�P��/���z
                    page.put("main.total.x9", new Integer(
                            totals[INDEX_OF_SERVICE_UNIT]));
                    // �敪�x�����x��𒴂���P�ʐ�
                    if (totals[INDEX_OF_LIMIT_OVER_UNIT] > 0) {
                        page.put("main.total.x12", new Integer(
                                totals[INDEX_OF_LIMIT_OVER_UNIT]));
                    }
                    // �敪�x�����x����P�ʐ�
                    page.put("main.total.x13", new Integer(
                            totals[INDEX_OF_LIMIT_IN_UNIT]));
                    // ��p���z�i�ی��Ώە��j
                    page.put("main.total.x15", new Integer(
                            totals[INDEX_OF_TOTAL_COST]));
                    // �ی����t�z
                    page.put("main.total.x17", new Integer(
                            totals[INDEX_OF_INSURE_COST]));
                    // ���p�ҕ��S�i�ی��Ώە��j
                    page.put("main.total.x18", new Integer(
                            totals[INDEX_OF_USER_COST_ON_INSURE]));
                    // ���p�ҕ��S�i�S�z���S���j
                    if (totals[INDEX_OF_USER_COST_ON_FULL] > 0) {
                        page.put("main.total.x19", new Integer(
                                totals[INDEX_OF_USER_COST_ON_FULL]));
                    }
                }
            }

            if (buildParam.getPages().isEmpty()) {
                // �󒠕[
                List provPages = new ArrayList();
                provPages.add(buildParam.getFormPage().clone());
                buildParam.getPages().add(provPages);
                return false;
            }
            return true;

        }

        /**
         * �������̍ŏ��̗v���F�����Ԃ��܂��B
         * 
         * @return �v���F����
         */
        public VRMap getFirstInsureInfo() {
            if (getInsureInfos().isEmpty()) {
                return null;
            }
            return (VRMap) getInsureInfos().get(0);
        }

        /**
         * 1�߂̃T�[�r�X����Ԃ��܂��B
         * 
         * @return 1�߂̃T�[�r�X���
         */
        public VRMap getMainFormatFirstService() {
            if (DivedInsured.this.size() > 0) {
                Iterator it = DivedInsured.this.mainParseMap.values().iterator();
                while (it.hasNext()) {
                    VRMap result = ((DivedServiceTime) it.next())
                            .getFirstService();
                    if (result != null) {
                        return result;
                    }
                }
            }
            return null;
        }
        /**
         * 1�߂̃T�[�r�X����Ԃ��܂��B
         * 
         * @return 1�߂̃T�[�r�X���
         */
        public VRMap getSubFormatFirstService() {
            if (DivedInsured.this.size() > 0) {
                Iterator it = DivedInsured.this.values().iterator();
                while (it.hasNext()) {
                    VRMap result = ((DivedProvider) it.next())
                            .getSubFormatFirstService();
                    if (result != null) {
                        return result;
                    }
                }
            }
            return null;
        }

        /**
         * �v���F���� ��Ԃ��܂��B
         * 
         * @return �v���F����
         */
        public List getInsureInfos() {
            return insureInfos;
        }

        /**
         * �������̍Ō�ɒǉ����ꂽ�v���F�����Ԃ��܂��B
         * <p>
         * �v���F�藚����1���ȉ��̏ꍇ��null��Ԃ��܂��B
         * </p>
         * 
         * @return �������̍Ō�ɒǉ����ꂽ�v���F����
         */
        public VRMap getLastChangeInsureInfo() {
            if (getInsureInfos().size() < 2) {
                return null;
            }
            return (VRMap) getInsureInfos().get(getInsureInfos().size() - 1);
        }

        /**
         * �������̍ł��x�����x�z�̑傫���v���F�����Ԃ��܂��B
         * 
         * @return �������̍ł��x�����x�z�̑傫���v���F����
         */
        public VRMap getMostHeavyInsureInfo() {
            if (getInsureInfos().isEmpty()) {
                return null;
            }
            int max = -1;
            VRMap maxInfo = null;
            Iterator it = getInsureInfos().iterator();
            while (it.hasNext()) {
                VRMap row = (VRMap) it.next();
                int rate = ACCastUtilities.toInt(row.get("LIMIT_RATE"), 0);
                if (rate > max) {
                    // �ő�̎x�����x�z���X�V
                    max = rate;
                    maxInfo = row;
                }
            }
            return maxInfo;
        }

        /**
         * �T�[�r�X����͂��܂��B
         * 
         * @param services �T�[�r�X
         * @throws Exception ������O
         */
        public void parse(VRMap service) throws Exception {

            //�ʕ\�͎��Ə��ԍ��ŕ���
            parseSub(service);
            //�{�\�͎��ԑтŕ���
            parseMain(service);
            
        }
        
        /**
         * �{�\�p�ɉ�͂��܂��B
         * 
         * @param services �T�[�r�X
         * @param code �T�[�r�X�R�[�h
         * @throws Exception ������O
         */
        protected void parseMain(VRMap service) throws Exception {

                  Date begin = ACCastUtilities.toDate(service.get("3"), null);
                  Date end = ACCastUtilities.toDate(service.get("4"), null);
                  String key = "";
                  if (begin != null) {
                      key += VRDateParser.format(begin, "HH:mm");
                  }
                  if (end != null) {
                      key += VRDateParser.format(end, "-HH:mm");
                  }
                  if("".equals(key)){
                      //�\�[�g���ʂ𖖔��Ƃ���
                      key = "99:99-99:99";
                  }

                  Object val = mainParseMap.get(key);
                  DivedServiceTime page;
                  // �񋟎��ԒP�ʂŕ���
                  if (val instanceof DivedServiceTime) {
                      page = (DivedServiceTime) val;
                  } else {
                      page = new DivedServiceTime();
                      mainParseMap.put(key, page);
                  }

                  // ����񋟎��ԒP�ʂŏW����
                  page.parseMainTable(service);
        }
        
        /**
         * �ʕ\�p�ɉ�͂��܂��B
         * 
         * @param services �T�[�r�X
         * @param code �T�[�r�X�R�[�h
         * @throws Exception ������O
         */
        protected void parseSub(VRMap service) throws Exception {

            Object key = service.get("PROVIDER_ID");
            if (key == null) {
                key = "";
            }
            Object val = DivedInsured.this.get(key);
            DivedProvider page;
            // ���Ə��ԍ��ŕ���
            if (val instanceof DivedProvider) {
                page = (DivedProvider) val;
            } else {
                page = new DivedProvider();
                DivedInsured.this.put(key, page);
            }
            // ���ꎖ�Ə��ԍ����ŕ���
            page.parseSubTable(service, ACCastUtilities.toString(key));

        }
        
        /**
         * �v���F�藚������͂��܂��B
         * 
         * @param insureInfo �v���F����
         * @throws Exception ������O
         */
        public void parseInsureInfo(VRMap insureInfo) throws Exception {
            getInsureInfos().add(insureInfo);
        }

        /**
         * �v���F���� ��ݒ肵�܂��B
         * 
         * @param insureInfo �v���F����
         */
        public void setInsureInfos(List insureInfo) {
            this.insureInfos = insureInfo;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            Iterator it = DivedInsured.this.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry ent = (Map.Entry) it.next();
                sb.append("�������ƎҔԍ��F");
                sb.append(ent.getKey());
                sb.append(ent.getValue());
            }
            return sb.toString();
        }
    }
    
    // === �����胍�W�b�N�ύX�ɔ����A�폜 ===
//    /**
//     * �ʕ\�ŉ�͂��邩�𔻒f���܂��B
//     * ��z��V�T�[�r�X�������T�[�r�X�ւ̕ϊ�����p
//     * 
//     * @param service ���f�Ώۂ̃T�[�r�X
//     * @return True:��͑Ώ� False:��͑ΏۊO
//     * @throws ������O
//     * @since Version 5.4.1
//     * @author Masahiko Higuchi
//     */
//    public boolean isSubParseCustom(VRMap service) throws Exception{
//       
//        if(service == null) return false;
//        // �ϊ��ΏۂƂȂ����T�[�r�X�͑ΏۊO
//        if (QkanValidServiceManager.getInstance().containsAnalyzeKey(service,
//                "ORIGINAL")) {
//            return false;
//        }
//        // �L�����ԊO�ϊ��ΏۂƂȂ����T�[�r�X���ΏۊO
//        // �����݂͉�͏������R�����g�A�E�g���Ȃ̂ł�����͎g���Ȃ��͂�
//        if (QkanValidServiceManager.getInstance().containsAnalyzeKey(service,
//                "NON_ORIGINAL")) {
//            return false;
//        }
//        
//        return true;
//    }
    
    /**
     * �{�[�ŉ�͂��邩�𔻒f���܂��B
     * 
     * @param service ���f�Ώۂ̃T�[�r�X
     * @return True:��͑Ώ� False:��͑ΏۊO 
     * @throws ������O
     * @since Version 5.4.1
     * @author Masahiko Higuchi
     */
    public boolean isParseCustom(VRMap service) throws Exception{
        
        if(service == null) return false;
        
        // === �����胍�W�b�N�ύX�ɔ����A�����ύX ===
//        // �ϊ���̃T�[�r�X�ł���ꍇ�͉�͑ΏۊO
//        if (QkanValidServiceManager.getInstance().containsAnalyzeKey(service,
//        "DUMMY")) {
//            return false;
//        }
        
        // �ϊ���̃T�[�r�X�ł���ꍇ�͉�͑ΏۊO
        if (service.containsKey("DUMMY")) {
            return false;
        }
        
        return true;
    }
    
    

    /**
     * �ی��Ҕԍ��P�ʂŐ؂�ւ��y�[�W�f�[�^�ł��B
     * <p>
     * Copyright (c) 2005 Nippon Computer Corpration. All Rights Reserved.
     * </p>
     * 
     * @author Tozo Tanaka
     * @version 1.0 2006/02/15
     */
    protected class DivedInsurer extends TreeMap {
        /**
         * ���p�[�{�\���\�z���܂��B
         * 
         * @param buildParam �󎚓��e�W��
         * @param insuredPageList �ǉ����ی��ҕʃy�[�W�W��
         * @throws Exception ������O
         * @return 1���ȏ�f�[�^�����邩
         */
        public boolean buildUserMainTable(CareServicePrintParameter buildParam, List insuredPageList)
                throws Exception {
            boolean exists = false;
            Iterator it = DivedInsurer.this.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry ent = (Map.Entry) it.next();
                DivedInsured services = (DivedInsured) ent.getValue();

                // �Ώ۔F�藚���̕ύX
                buildUserMainTableInsureInfo(services, buildParam);

                // ���ʏ��\�z
                buildParam.setPages(new ArrayList());
                exists |= services.buildUserMainTable(buildParam);
                insuredPageList.add(buildParam.getPages());
            }
            return exists;
        }

        /**
         * ���p�[�ʕ\���\�z���܂��B
         * 
         * @param buildParam �󎚓��e�W��
         * @param insuredPageList �ǉ����ی��ҕʃy�[�W�W��
         * @return ���̏o�͑Ώۍs
         * @throws Exception ������O
         * @return 1���ȏ�f�[�^�����邩
         */
        public boolean buildUserSubTable(CareServicePrintParameter buildParam, List insuredPageList)
                throws Exception {
            boolean exists = false;
            Iterator it = DivedInsurer.this.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry ent = (Map.Entry) it.next();
                DivedInsured services = (DivedInsured) ent.getValue();

                // �Ώ۔F�藚���̕ύX
                buildUserSubTableInsureInfo(services, buildParam);

                // ���ʏ��\�z
                buildParam.setPages(new ArrayList());
                exists |= services.buildUserSubTable(buildParam);
                insuredPageList.add(buildParam.getPages());
            }
            return exists;
        }
        
        /**
         * %���Z���ɑΉ����邽�߁A�ʕ\�p��2�i�K��͂��s���܂��B
         * @throws Exception ������O
         */
        public void parseSubSecond() throws Exception{
            Iterator it = DivedInsurer.this.entrySet().iterator();
            while (it.hasNext()) {
                ((DivedInsured) ((Map.Entry) it.next()).getValue()).parseSubSecond();
            }
        }

        /**
         * 1�߂̃T�[�r�X����Ԃ��܂��B
         * 
         * @return 1�߂̃T�[�r�X���
         */
        public VRMap getFirstService() {
            if (DivedInsurer.this.size() > 0) {
                return ((DivedInsured) DivedInsurer.this.values().iterator()
                        .next()).getSubFormatFirstService();
            }
            return null;
        }
        /**
         * �T�[�r�X����͂��܂��B
         * 
         * @param services �T�[�r�X
         * @throws Exception ������O
         */
        public void parse(VRMap service, VRMap insureInfo) throws Exception {
            Object key = insureInfo.get("INSURED_ID");
            if (ACTextUtilities.isNullText(key)) {
                // ��ی��Ҕԍ��Ȃ��Ȃ疳��
                return;
            }
            Object val = DivedInsurer.this.get(key);
            DivedInsured page;
            // ��ی��Ҕԍ��ŕ���
            if (val instanceof DivedInsured) {
                page = (DivedInsured) val;
            } else {
                page = new DivedInsured();
                DivedInsurer.this.put(key, page);
            }
            // �����ی��Ҕԍ����ŕ���
            page.parse(service);
        }

        /**
         * �v���F�藚������͂��܂��B
         * 
         * @param insureInfo �v���F����
         * @throws Exception ������O
         */
        public void parseInsureInfo(VRMap insureInfo) throws Exception {
            Object key = insureInfo.get("INSURED_ID");
            if (ACTextUtilities.isNullText(key)) {
                // ��ی��Ҕԍ��Ȃ�
                return;
            }
            Object val = DivedInsurer.this.get(key);
            DivedInsured page;
            // ��ی��Ҕԍ��ŕ���
            if (val instanceof DivedInsured) {
                page = (DivedInsured) val;
            } else {
                page = new DivedInsured();
                DivedInsurer.this.put(key, page);
            }
            // �����ی��Ҕԍ����ŕ���
            page.parseInsureInfo(insureInfo);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            Iterator it = DivedInsurer.this.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry ent = (Map.Entry) it.next();
                sb.append("����ی��Ҕԍ��F");
                sb.append(ent.getKey());
                sb.append(ACConstants.LINE_SEPARATOR);
                sb.append(ent.getValue());
            }
            return sb.toString();
        }

        /**
         * �{�\���`�ɗv���F�����ݒ肵�܂��B
         * 
         * @param target �v���F����ێ��N���X
         * @param formPage �{�\���`
         * @param invisibles �S�y�[�W��\��������ID�W��
         */
        protected void buildUserMainTableInsureInfo(DivedInsured target,
                CareServicePrintParameter buildParam) throws Exception {
            // �����̔F�藚��
            VRMap firstInsureInfo = target.getFirstInsureInfo();
            if (firstInsureInfo != null) {

                // �ی��Ҕԍ�
                String insurerID = ACCastUtilities.toString(firstInsureInfo
                        .get("INSURER_ID"));
                buildParam.getFormPage().put("insurerNo", insurerID);
                // �ی��Җ�
                Map insurer = getCalcurater().getInsurerInfo(insurerID);
                if (insurer != null) {
                    buildParam.getFormPage().put("upper.h1.w15",
                            insurer.get("INSURER_NAME"));
                }

                // ��ی��Ҕԍ�
                buildParam.getFormPage().put("insuredNo",
                        firstInsureInfo.get("INSURED_ID"));
                // �v����ԋ敪
                Object firstCode = firstInsureInfo.get("JOTAI_CODE");
                buildParam.getFormPage().put(
                        "upper.h6.w15",
                        QkanJotaiCodeUnapplicableFormat.getInstance().format(
                                firstCode));

                VRMap insureInfo = firstInsureInfo;

                // �ύX��̗v���x
                VRMap lastInsureInfo = target.getLastChangeInsureInfo();
                if (lastInsureInfo != null) {
                    // �ύX��v����ԋ敪
                    Object lastCode = lastInsureInfo.get("JOTAI_CODE");
                    if ((firstCode == null) || !firstCode.equals(lastCode)) {
                        buildParam.getFormPage().put(
                                "upper.h7.w15",
                                QkanJotaiCodeUnapplicableFormat.getInstance()
                                        .format(lastCode));

                        // �ύX��
                        buildParam.getFormPage().put(
                                "upper.h9.w19",
                                ACConstants.FORMAT_FULL_ERA_YMD
                                        .format(lastInsureInfo
                                                .get("INSURE_VALID_START")));
                    }
                    insureInfo = lastInsureInfo;
                }

                // �����̗v���x���m��
                if ("0".equals(ACCastUtilities.toString(insureInfo
                        .get("CHANGE_CODE")))) {
                    // �F�茈��ς�
                    buildParam.getInvisibles().add("requesting");
                } else {
                    // �F��\����
                    buildParam.getInvisibles().add("authorized");
                }
            }

            // �ł��d���v���x
            VRMap insureInfo = target.getMostHeavyInsureInfo();
            if (insureInfo != null) {

// 2016/7/19 [�������ƑΉ�][Yoichiro Kamei] mod - begin
//              // �敪�x�����x��z
//              buildParam.getFormPage().put(
//                      "limitAmountContent",
//                      NumberFormat.getIntegerInstance().format(
//                              ACCastUtilities.toInt(insureInfo
//                                      .get("LIMIT_RATE"), 0)));
                // ���ƑΏێ҂ŗv�x���P�̊�z�𒴂���ꍇ�́A����̊z��\������
                int limitRate = ACCastUtilities.toInt(insureInfo.get("LIMIT_RATE"), 0);
                int jotaiCode = ACCastUtilities.toInt(insureInfo.get("JOTAI_CODE"), 0);
                if (jotaiCode == QkanConstants.YOUKAIGODO_JIGYOTAISHO) {
                    if (limitRate > getJigyotaishoLimitRate()) {
                        limitRate = getJigyotaishoLimitRate();
                    }
                }
                // �敪�x�����x��z
                buildParam.getFormPage().put(
                        "limitAmountContent",
                        NumberFormat.getIntegerInstance().format(limitRate));
// 2016/7/19 [�������ƑΉ�][Yoichiro Kamei] mod - end


                // ���x�z�K�p���ԊJ�n
                buildParam.getFormPage().put(
                        "validDateStart",
                        yearMonthFormat.format(ACCastUtilities
                                .toDate(insureInfo.get("INSURE_VALID_START"))));
                
// 2016/7/19 [�������ƑΉ�][Yoichiro Kamei] mod - begin
//                // ���x�z�K�p���ԏI��
//                buildParam.getFormPage().put(
//                        "validDateEnd",
//                        yearMonthFormat.format(ACCastUtilities
//                                .toDate(insureInfo.get("INSURE_VALID_END"))));
                
                Date end = ACCastUtilities.toDate(insureInfo.get("INSURE_VALID_END"));
                if (MAX_DATE.equals(end)) {
                    // 9999-12-31�̏ꍇ�͋�
                    buildParam.getFormPage().put("validDateEnd", "");
                } else {
                  buildParam.getFormPage().put(
                  "validDateEnd",
                  yearMonthFormat.format(ACCastUtilities
                          .toDate(insureInfo.get("INSURE_VALID_END"))));
                }
// 2016/7/19 [�������ƑΉ�][Yoichiro Kamei] mod - end
            }
        }

        /**
         * �{�\���`�ɗv���F�����ݒ肵�܂��B
         * 
         * @param target �v���F����ێ��N���X
         * @param formPage �{�\���`
         * @param invisibles �S�y�[�W��\��������ID�W��
         */
        protected void buildUserSubTableInsureInfo(DivedInsured target,
                CareServicePrintParameter buildParam) throws Exception {
            // �����̗v���x
            VRMap insureInfo = target.getFirstInsureInfo();
            if (insureInfo != null) {

                // ��ی��Ҕԍ�
                buildParam.getFormPage().put("insured.h1.insuredID",
                        insureInfo.get("INSURED_ID"));

            }

            // �ł��d���v���x
            insureInfo = target.getMostHeavyInsureInfo();
            if (insureInfo != null) {
// 2016/7/19 [�������ƑΉ�][Yoichiro Kamei] mod - begin
//                // �敪�x�����x��z
//                buildParam.getFormPage().put("main.total.x5",
//                        insureInfo.get("LIMIT_RATE"));
                // ���ƑΏێ҂ŗv�x���P�̊�z�𒴂���ꍇ�́A����̊z��\������
                int limitRate = ACCastUtilities.toInt(insureInfo.get("LIMIT_RATE"), 0);
                int jotaiCode = ACCastUtilities.toInt(insureInfo.get("JOTAI_CODE"), 0);
                if (jotaiCode == QkanConstants.YOUKAIGODO_JIGYOTAISHO) {
                    if (limitRate > getJigyotaishoLimitRate()) {
                        limitRate = getJigyotaishoLimitRate();
                    }
                }
                // �敪�x�����x��z
                buildParam.getFormPage().put("main.total.x5",limitRate);
// 2016/7/19 [�������ƑΉ�][Yoichiro Kamei] mod - end
            }
        }
    }

    /**
     * ���Ə��ԍ��P�ʂŐ؂�ւ��y�[�W�f�[�^�ł��B
     * <p>
     * Copyright (c) 2005 Nippon Computer Corpration. All Rights Reserved.
     * </p>
     * 
     * @author Tozo Tanaka
     * @version 1.0 2006/02/15
     */
    protected class DivedProvider extends TreeMap {
        private Map[] totalGroupingCache = new Map[] { new HashMap(),
                new HashMap() };
        private TreeMap mainParseOver30DaysMap = new TreeMap();

        /**
         * ���p�[�{�\���\�z���܂��B
         * 
         * @param pages �y�[�W�W��
         * @param formPage ��{����ݒ肵�����`�y�[�W
         * @param targetPage �o�͑Ώۃy�[�W
         * @param beginRow �o�͑ΏۊJ�n�s
         * @throws Exception ������O
         */
        public int buildUserMainTable(CareServicePrintParameter buildParam) throws Exception {
            buildUserMainTableImpl(buildParam, false);
            buildUserMainTableImpl(buildParam, true);
            return buildParam.getCurrentRow();
        }
        /**
         * ���p�[�{�\���\�z���܂��B
         * 
         * @param buildParam �󎚓��e�W��
         * @param isOver30Days 30�����̃T�[�r�X�Ƃ��ďo�͂��邩 
         * @return ���̏o�͑Ώۍs
         * @throws Exception ������O
         */
        protected int buildUserMainTableImpl(CareServicePrintParameter buildParam, boolean isOver30Days) throws Exception {
            //2006/08/30 begin-add Tozo TANAKA �{�\��30�����Ή��̂���
            TreeMap tableMap;
            if(isOver30Days){
                //30�����̏ꍇ��
                tableMap = mainParseOver30DaysMap;
            }else{
                tableMap = DivedProvider.this;
            }
            //2006/08/30 end-add Tozo TANAKA �{�\��30�����Ή��̂���
            
            Iterator it = tableMap.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry ent = (Map.Entry) it.next();
                DivedServiceKind services = (DivedServiceKind) ent.getValue();
                // ���ʏ��\�z
                buildParam.setCurrentRow(services
                        .buildUserMainTable(buildParam, isOver30Days));
            }
            return buildParam.getCurrentRow();
        }

        /**
         * ���p�[�ʕ\(���t�Ǘ��Ώ�)���\�z���܂��B
         * 
         * @param buildParam �󎚓��e�W��
         * @param provider ���Ə����
         * @param insureRate �ی����t��
         * @param totals �W�v���
         * @return ���̏o�͑Ώۍs
         * @throws Exception ������O
         */
        public int buildUserSubTableInLimitAmount(CareServicePrintParameter buildParam,
                Map provider, int insureRate, int[] totals) throws Exception {
            Iterator it;
            // ���t�Ǘ����x�z�Ώ�
            it = DivedProvider.this.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry ent = (Map.Entry) it.next();
                DivedServiceKind services = (DivedServiceKind) ent.getValue();
                // ���ʏ��\�z
                buildParam.setCurrentRow(services.buildUserSubTable(buildParam,
                        provider, insureRate, totals, true, false));
            }

            return buildParam.getCurrentRow();
        }

        /**
         * ���p�[�ʕ\(30����)���\�z���܂��B
         * 
         * @param buildParam �󎚓��e�W��
         * @param provider ���Ə����
         * @param insureRate �ی����t��
         * @param totals �W�v���
         * @return ���̏o�͑Ώۍs
         * @throws Exception ������O
         */
        public int buildUserSubTable30Over(CareServicePrintParameter buildParam,
                Map provider, int insureRate, int[] totals) throws Exception {
            Iterator it;
            // ���t�Ǘ����x�z�Ώ�
            it = DivedProvider.this.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry ent = (Map.Entry) it.next();
                DivedServiceKind services = (DivedServiceKind) ent.getValue();
                // ���ʏ��\�z
                buildParam.setCurrentRow(services.buildUserSubTable(buildParam,
                        provider, insureRate, totals, true, true));
            }

            return buildParam.getCurrentRow();
        }

        /**
         * %���Z���ɑΉ����邽�߁A�ʕ\�p��2�i�K��͂��s���܂��B
         * @param providerID ���Ə�ID
         * @throws Exception ������O
         */
        public void parseSubSecond(String providerID) throws Exception{
            Iterator it = DivedProvider.this.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry ent = (Map.Entry) it.next();
                ((DivedServiceKind) ent.getValue()).parseSubSecond(providerID, ACCastUtilities.toInt(ent.getKey(),0));
            }
        }
        /**
         * ���p�[�ʕ\(���t�Ǘ��ΏۊO)���\�z���܂��B
         * 
         * @param buildParam �󎚓��e�W��
         * @param provider ���Ə����
         * @param insureRate �ی����t��
         * @param totals �W�v���
         * @return ���̏o�͑Ώۍs
         * @throws Exception ������O
         */
        public int buildUserSubTableOutLimitAmount(CareServicePrintParameter buildParam,
                Map provider, int insureRate, int[] totals) throws Exception {
            Iterator it;
            // ���t�Ǘ����x�z�ΏۊO
            int[] dummyTotal = new int[totals.length];
            it = DivedProvider.this.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry ent = (Map.Entry) it.next();
                DivedServiceKind services = (DivedServiceKind) ent.getValue();
                // ���ʏ��\�z
                buildParam.setCurrentRow(services.buildUserSubTable(buildParam,
                        provider, insureRate, dummyTotal, false, false));
            }
            //��p���z�A�ی����t�z�A���p�ҕ��S�i�ی��Ώە��j�͋��t�Ǘ��ΏۊO�ł����Z����
            totals[INDEX_OF_TOTAL_COST] += dummyTotal[INDEX_OF_TOTAL_COST];
            totals[INDEX_OF_INSURE_COST] += dummyTotal[INDEX_OF_INSURE_COST];
            totals[INDEX_OF_USER_COST_ON_INSURE] += dummyTotal[INDEX_OF_USER_COST_ON_INSURE];
            // ���p�ҕ��S�i�S�z���S���j�����Z����
            totals[INDEX_OF_USER_COST_ON_FULL] += dummyTotal[INDEX_OF_USER_COST_ON_FULL];
           
            return buildParam.getCurrentRow();
        }

        /**
         * �{�\�ɂ�����1�߂̃T�[�r�X����Ԃ��܂��B
         * 
         * @return 1�߂̃T�[�r�X���
         */
        public VRMap getMainFormatFirstService() {
            VRMap result = getMainFormatFirstServiceImpl(DivedProvider.this);
            if(result==null){
                result = getMainFormatFirstServiceImpl(mainParseOver30DaysMap);
            }
            return result;
        }
        
        /**
         * �{�\�ɂ�����1�߂̃T�[�r�X����Ԃ��܂��B
         *
         * @param map ��������
         * @return 1�߂̃T�[�r�X���
         */
        protected VRMap getMainFormatFirstServiceImpl(Map map) {
            if (map.size() > 0) {
                Iterator it = map.values().iterator();
                while (it.hasNext()) {
                    VRMap result = ((DivedServiceKind) it.next())
                            .getMainFormatFirstService();
                    if (result != null) {
                        return result;
                    }
                }
            }
            return null;
        } 
        
        /**
         * �ʕ\�ɂ�����1�߂̃T�[�r�X����Ԃ��܂��B
         * 
         * @return 1�߂̃T�[�r�X���
         */
        public VRMap getSubFormatFirstService() {
            if (DivedProvider.this.size() > 0) {
                Iterator it = DivedProvider.this.values().iterator();
                while (it.hasNext()) {
                    VRMap result = ((DivedServiceKind) it.next())
                            .getSubFormatFirstService();
                    if (result != null) {
                        return result;
                    }
                }
            }
            return null;
        }

        /**
         * �T�[�r�X����͂��܂��B
         * 
         * @param services �T�[�r�X
         * @param providerID ���Ə�ID
         * @throws Exception ������O
         */
        public void parseMainTable(VRMap service, String providerID) throws Exception {
            //2006/08/30 begin-add Tozo TANAKA �{�\��30�����Ή��̂���
            TreeMap tableMap;
            if(CareServiceCommon.is30DayOver(service)){
                //30�����̏ꍇ��
                tableMap = mainParseOver30DaysMap;
            }else{
                tableMap = DivedProvider.this;
            }
            //2006/08/30 end-add Tozo TANAKA �{�\��30�����Ή��̂���
            
            
            Object key = service.get("SYSTEM_SERVICE_KIND_DETAIL");
            if (key == null) {
                key = "";
            }
            Object val = tableMap.get(key);
            DivedServiceKind page;
            // �T�[�r�X��ނŕ���
            if (val instanceof DivedServiceKind) {
                page = (DivedServiceKind) val;
            } else {
                // ���������v�Z���A�ޔ�������
                page = new DivedServiceKind(getCalcurater().getReductRate(
                        providerID, service));
                tableMap.put(key, page);
            }
            // ����T�[�r�X��ޓ��ŕ���
            page.parseMainTable(service, totalGroupingCache);
        }

        /**
         * �T�[�r�X����͂��܂��B
         * 
         * @param services �T�[�r�X
         * @param providerID ���Ə�ID
         * @throws Exception ������O
         */
        public void parseSubTable(VRMap service, String providerID) throws Exception {

            Object key = service.get("SYSTEM_SERVICE_KIND_DETAIL");
            if (key == null) {
                key = "";
            }
            Object val = DivedProvider.this.get(key);
            DivedServiceKind page;
            // �T�[�r�X��ނŕ���
            if (val instanceof DivedServiceKind) {
                page = (DivedServiceKind) val;
            } else {
                // ���������v�Z���A�ޔ�������
                page = new DivedServiceKind(getCalcurater().getReductRate(
                        providerID, service));
                DivedProvider.this.put(key, page);
            }
            // ����T�[�r�X��ޓ��ŕ���
            page.parseSubTable(service, totalGroupingCache);
        }
        
        public String toString() {
            StringBuilder sb = new StringBuilder();
            Iterator it = DivedProvider.this.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry ent = (Map.Entry) it.next();
                sb.append(ACConstants.LINE_SEPARATOR);
                sb.append("�������T�[�r�X��ށF");
                sb.append(ent.getKey());
                sb.append(ACConstants.LINE_SEPARATOR);
                sb.append(ent.getValue());
            }
            it = mainParseOver30DaysMap.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry ent = (Map.Entry) it.next();
                sb.append(ACConstants.LINE_SEPARATOR);
                sb.append("�������T�[�r�X��ށF");
                sb.append(ent.getKey());
                sb.append(ACConstants.LINE_SEPARATOR);
                sb.append(ent.getValue());
            }
            return sb.toString();
        }
    }

    /**
     * �T�[�r�X���e�P�ʂŐ؂�ւ��y�[�W�f�[�^�ł��B
     * <p>
     * Copyright (c) 2005 Nippon Computer Corpration. All Rights Reserved.
     * </p>
     * 
     * @author Tozo Tanaka
     * @version 1.0 2006/02/15
     */
    protected class DivedServiceItem {
        private Map mainFormatCode;
        private Map subFormatCode;
        private TreeMap inInsureUnits = new TreeMap();
        private TreeMap outInsureUnits = new TreeMap();
        private TreeMap inInsureOver30Units = new TreeMap();
        private TreeMap outInsureOver30Units = new TreeMap();
        private TreeMap plan = new TreeMap();
        private TreeMap result = new TreeMap();

        /**
         * ���p�[�{�\���\�z���܂��B
         * 
         * @param texts �󎚓��e�W��
         * @param row �o�͑Ώۍs
         * @param isOver30Days 30�����̃T�[�r�X�Ƃ��ďo�͂��邩 
         * @throws Exception ������O
         */
        public void buildUserMainTable(Map texts, int row, boolean isOver30Days) throws Exception {
            buildUserMainTable(texts, row, plan, "y");
            texts.put("lower.y" + row + ".w13", "�\��");
            buildUserMainTable(texts, row, result, "j");
            texts.put("lower.j" + row + ".w13", "����");

            // �T�[�r�X�R�[�h��
            if (mainFormatCode != null) {
                String serviceItemName ="";
                if(isOver30Days){
                    serviceItemName ="30����";
                }
                serviceItemName += ACCastUtilities.toString(
                        mainFormatCode.get("SERVICE_NAME"), "");
                
                //[H27.4�����Ή�][Shinobu Hitaka] 2015/4/2 add - begin
                // 11:�K����20�������̕p��\���Ή�
                if ("11".equals(ACCastUtilities.toString(mainFormatCode.get("SERVICE_CODE_KIND")))
                		&& "1".equals(ACCastUtilities.toString(mainFormatCode.get("SERVICE_MAIN_FLAG")))) {
                	
                	// �V�X�e���T�[�r�X�R�[�h�̍Ō�̕������p��t���O=2�̏ꍇ�Ɂy�p��z��t������B
                	String tmpSystemServiceCodeItem = ACCastUtilities.toString(mainFormatCode.get("SYSTEM_SERVICE_CODE_ITEM"));
                	if ("2".equals(tmpSystemServiceCodeItem.substring(tmpSystemServiceCodeItem.length() - 1))) {
                		serviceItemName += "�y�p��z";
                	}
                }
                //[H27.4�����Ή�][Shinobu Hitaka] 2015/4/2 add - end
                
                // �T�[�r�X���e
                texts.put("lowerHeader.row" + row + "Upper.service",
                        serviceItemName);
            }

        }

        /**
         * ���p�[�{�\���\�z���܂��B
         * 
         * @param texts �󎚓��e�W��
         * @param row �o�͑Ώۍs
         * @param targetMap �ΏۂƂ���}�b�v
         * @param rowType �s�`��
         * @throws Exception ������O
         */
        protected void buildUserMainTable(Map texts, int row, Map targetMap,
                String rowType) throws Exception {
            int total = 0;
            Iterator it = targetMap.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry ent = (Map.Entry) it.next();
                // �w����Ɉ󎚂���񐔂�ǉ�
                List services = (List) ent.getValue();
                String path = rowType + row + ".x" + ent.getKey();
                texts.put("lowerValue." + path, ACCastUtilities.toString(
                        services.size(), ""));
                total += services.size();

                if (isPrintTriangle()) {
                    Iterator sit = services.iterator();
                    while (sit.hasNext()) {
                        if (ACCastUtilities.toInt(((Map) sit.next())
                                .get("REGULATION_RATE"), 0) > 0) {
                            // ������L��
                            texts.put("lowerValueTriangle." + path, "��");
                            break;
                        }
                    }
                }
            }
            // ���v
            if (total > 0) {
                texts.put("lower." + rowType + row + ".g", ACCastUtilities
                        .toString(total, ""));
            }

            // �T�[�r�X�̒񋟎��ԑ�
            VRMap service = getMainFormatFirstService();

            boolean lowerOut = false;
            Date begin = ACCastUtilities.toDate(service.get("3"), null);
            Date end = ACCastUtilities.toDate(service.get("4"), null);
            if (end != null) {
                // �񋟏I����������
                String lowerTime = VRDateParser.format(end, "HH:mm");
                texts.put("lowerHeader.row" + row + "Lower.time", lowerTime);
                lowerOut = true;
            }

            if (begin != null) {
                // �񋟊J�n��������
                String upperTime = VRDateParser.format(begin, "HH:mm") + " ����";
                texts.put("lowerHeader.row" + row + "Upper.time", upperTime);
            } else if (lowerOut) {
                // �񋟏I�������݂̂���
                texts.put("lowerHeader.row" + row + "Upper.time", "     �@����");
            }
        }

        // [ID:0000444][Tozo TANAKA] 2009/03/20 remove begin ����21�N4���@�����Ή�
//        /**
//         * %���Z�̑ΏۂƂȂ�P�ʐ���Ԃ��܂��B
//         * @param providerID ���Ə�ID
//         * @return %���Z�̑ΏۂƂȂ�P�ʐ�
//         * @throws Exception ������O
//         */
//        public int getSubPersentageUnit(String providerID) throws Exception{
//            int units = 0;
//            Iterator it = DivedServiceItem.this.inInsureUnits.entrySet().iterator();
//            while (it.hasNext()) {
//                Map.Entry ent = (Map.Entry) it.next();
//                DivedServiceUnit item = (DivedServiceUnit) ent.getValue();
//                
//                if(CareServiceCommon.isSimpleUnit(item.code)){
//                    units += getCalcurater().getReductedUnit(providerID,
//                            item.code, ACCastUtilities.toInt(ent.getKey(), 0))
//                            * item.size();
//                }
//            }
//            return units;
//        }
        // [ID:0000444][Tozo TANAKA] 2009/03/18 remove end
        /**
         * %���Z�̒P�ʐ���ݒ肵�܂��B
         * @param units %���Z�̒P�ʐ�
         * @throws Exception ������O
         */
        public void setSubPersentageUnit(int units) throws Exception{
            Object removeKey = null;
            Object replaceValue = null;
            String serviceAddFlag = "";
            String findKey = "";
            Iterator it = DivedServiceItem.this.outInsureUnits.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry ent = (Map.Entry) it.next();
                DivedServiceUnit item = (DivedServiceUnit) ent.getValue();
                VRMap rec = (VRHashMap)item.get(0);
                findKey = ACCastUtilities.toString(rec.getData("PROVIDER_ID")) + "-" + ACCastUtilities.toString(rec.getData("SYSTEM_SERVICE_KIND_DETAIL"));
                if(CareServiceCommon.isAddPercentage(item.code)){
                    // �������P���Z�̎��ȕ��S�����v�Z����
                    serviceAddFlag = ACCastUtilities.toString((item.code.get("SERVICE_ADD_FLAG")),"");
                    removeKey = ent.getKey();
                    replaceValue = item;
                    break;
                }
            }
            if(removeKey!=null){
                int per=ACCastUtilities.toInt(removeKey, 0);
                DivedServiceItem.this.outInsureUnits.remove(removeKey);
                //%���Z
                DivedServiceItem.this.outInsureUnits.put(new Integer((int)Math.round(units*per/100.0)), replaceValue);
                
                // ���ʒn��E���K�͂̏ꍇ�̎��ȕ��S�z��ޔ�
                int regulationUnit = 0;
                // [ID:0000728][Masahiko.Higuchi] 2012/04 ����24�N4���@�����Ή� add begin
                int adjustUnit = 0;
                int calcUnit = 0;
                int totalUnit = 0;
                int result = 0;
                // [ID:0000728][Masahiko.Higuchi] 2012/04 ����24�N4���@�����Ή� add end
                if("3".equals(serviceAddFlag) && regulationHash.containsKey(findKey)) {
                    regulationUnit = ACCastUtilities.toInt(regulationHash.get(findKey), 0);
                    // [ID:0000728][Masahiko.Higuchi] 2012/04 ����24�N4���@�����Ή� edit begin
                    adjustUnit = units - regulationUnit;
                    calcUnit = new Integer((int)Math.round(adjustUnit*per/100.0));
                    totalUnit = new Integer((int)Math.round(units*per/100.0));
                    result = totalUnit - calcUnit;
                    regulationHash.put(findKey + "_" + serviceAddFlag, new Integer(result));
                    // [ID:0000728][Masahiko.Higuchi] 2012/04 ����24�N4���@�����Ή� edit end
                }
                
                if("6".equals(serviceAddFlag)) {
                    regulationUnit = ACCastUtilities.toInt(regulationHash.get(findKey), 0);
                    // ���ʒn����Z�̎��ȕ��S�����v����
                    regulationUnit += ACCastUtilities.toInt(regulationHash.get(findKey + "_3"),0);
                    // [ID:0000728][Masahiko.Higuchi] 2012/04 ����24�N4���@�����Ή� edit begin
                    adjustUnit = units - regulationUnit;
                    calcUnit = new Integer((int)Math.round(adjustUnit*per/100.0));
                    totalUnit = new Integer((int)Math.round(units*per/100.0));
                    result = totalUnit - calcUnit;
                    regulationHash.put(findKey + "_" + serviceAddFlag, new Integer(result));
                    // [ID:0000728][Masahiko.Higuchi] 2012/04 ����24�N4���@�����Ή� edit end
                }
            }
        }
        

        /**
         * ���p�[�ʕ\���\�z���܂��B
         * 
         * @param buildParam �󎚓��e�W��
         * @param provider ���Ə����
         * @param insureRate �ی����t��
         * @param totals �W�v���
         * @param itemState �T�[�r�X���e���
         * @param isOver30Days 30����
         * @return ���̏o�͑Ώۍs
         * @throws Exception ������O
         */
        public void buildUserSubTableOver30Days(
                CareServicePrintParameter buildParam, Map provider,
                int insureRate, int[] totals) throws Exception {

            // [ID:0000734][Masahiko.Higuchi] 2012/04 ����24�N4���@�����Ή� add begin
            // 30�����̈󎚒��O�ɒP�ʐ���������v�Z��̌��ʂɍ����ւ���
            // ���t���x�z�Ǘ��Ώۓ��̒P�ʐ�����Ώۂ��擾
            String systemServiceKindDetail = "";
            int totalUnit = 0;
            Iterator itInsurerOver = inInsureOver30Units.entrySet().iterator();
            while (itInsurerOver.hasNext()) {
                Map.Entry ent = (Map.Entry) itInsurerOver.next();
                int unit = ACCastUtilities.toInt(ent.getKey());
                if (unit == 0) {
                    continue;
                }
                DivedServiceUnit services = (DivedServiceUnit) ent.getValue();
                int count = ((DivedServiceUnit) ent.getValue()).size();
                // �񐔂��܂߂Čv�Z
                int units = unit * count;
                VRMap service = (VRMap)services.code;
                systemServiceKindDetail = ACCastUtilities.toString(service.getData("SYSTEM_SERVICE_KIND_DETAIL"),"");
                // %�n���Z�����O����
                if(!CareServiceCommon.isAddPercentage(service)) {
                    totalUnit = ACCastUtilities.toInt(over30UnitSyoguHash.getData(systemServiceKindDetail),0);
                    totalUnit+=units;
                    over30UnitSyoguHash.setData(systemServiceKindDetail, totalUnit);
                }
            }
            
            // ���t���x�z�Ǘ��ΏۊO�̒P�ʐ�����Ώۂ��擾
            itInsurerOver = outInsureOver30Units.entrySet().iterator();
            while (itInsurerOver.hasNext()) {
                Map.Entry ent = (Map.Entry) itInsurerOver.next();
                int unit = ACCastUtilities.toInt(ent.getKey());
                if (unit == 0) {
                    continue;
                }
                DivedServiceUnit services = (DivedServiceUnit) ent.getValue();
                int count = ((DivedServiceUnit) ent.getValue()).size();
                // �񐔂��܂߂Čv�Z
                int units = unit * count;
                VRMap service = (VRMap)services.code;
                systemServiceKindDetail = ACCastUtilities.toString(service.getData("SYSTEM_SERVICE_KIND_DETAIL"),"");
                // %�n���Z�����O����
                if(!CareServiceCommon.isAddPercentage(service)) {
                    totalUnit = ACCastUtilities.toInt(over30UnitSyoguHash.getData(systemServiceKindDetail),0);
                    totalUnit+=units;
                    over30UnitSyoguHash.setData(systemServiceKindDetail, totalUnit);
                }
            }
            
            // �P�ʐ������ւ��悤�̃��[�v
            itInsurerOver = inInsureOver30Units.entrySet().iterator();
            while (itInsurerOver.hasNext()) {
                Map.Entry ent = (Map.Entry) itInsurerOver.next();
                int unit = ACCastUtilities.toInt(ent.getKey());
                if (unit == 0) {
                    continue;
                }
                DivedServiceUnit services = (DivedServiceUnit) ent.getValue();
                VRMap code = (VRMap)services.code;
                systemServiceKindDetail = ACCastUtilities.toString(code.getData("SYSTEM_SERVICE_KIND_DETAIL"),"");
                // �������P���Z�̏ꍇ
                if(CareServiceCommon.isAddPercentageForSyogu(code)) {
                    int serviceUnit = ACCastUtilities.toInt(code.get("SERVICE_UNIT"),0);
                    // �������P����
                    int serviceStaffUnit = ACCastUtilities.toInt(code.get("SERVICE_STAFF_UNIT"),0);
                    totalUnit = ACCastUtilities.toInt(over30UnitSyoguHash.getData(systemServiceKindDetail),0);
                    // �Ǘ��p�}�b�v�����x�폜
                    inInsureOver30Units.remove(ent.getKey());
                     // �v�Z�����{��
                    unit = CareServiceCommon.calcSyogu(totalUnit, serviceUnit, serviceStaffUnit);
                    inInsureOver30Units.put(unit, (DivedServiceUnit) ent.getValue());
                }
            }
            // [ID:0000734][Masahiko.Higuchi] 2012/04 add end

            
            // �x�����x�z�O��30�����R�[�h�͗��p�ґS�z���S���Ƃ��čŏ��ɍ��Z
            Iterator it = outInsureOver30Units.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry ent = (Map.Entry) it.next();
                int unit = ACCastUtilities.toInt(ent.getKey());
                if (unit == 0) {
                    // �P��0�͖���
                    continue;
                }
                DivedServiceUnit services = (DivedServiceUnit) ent.getValue();
                services.buildUserSubTableDetailRow(buildParam, provider, unit,
                        totals, true);
            }
        }

        /**
         * ���p�[�ʕ\���\�z���܂��B
         * 
         * @param buildParam �󎚓��e�W��
         * @param provider ���Ə����
         * @param insureRate �ی����t��
         * @param totals �W�v���
         * @param itemState �T�[�r�X���e���
         * @param isOver30Days 30����
         * @return ���̏o�͑Ώۍs
         * @throws Exception ������O
         */
        public int buildUserSubTable(CareServicePrintParameter buildParam, Map provider,
                int insureRate, int[] totals, int itemState, Set regulationCache, boolean isOver30Days) throws Exception {

            Map targetMap;
            if (itemState != ITEM_STATE_OUT_LIMIT_AMOUNT) {
                if(isOver30Days){
                    targetMap = inInsureOver30Units;
                }else{
                    targetMap = inInsureUnits;
                }
                //2006/6/20 Tozo TANAKA ���T�[�r�X�R�[�h�ْP�ʐ��̕����p��ݗ^�̑Ή�-begin
                if(itemState == ITEM_STATE_SINGLE) {
                    //�P��s�Ǝw�肳�ꂽ���A�T�[�r�X�R�[�h�͓���ł��P�ʐ���2��ނƂ����P�[�X���l��
                    if(targetMap.size()>1){
                        itemState = ITEM_STATE_MULTI_LAST;
                    }
                }
                //2006/6/20 Tozo TANAKA ���T�[�r�X�R�[�h�ْP�ʐ��̕����p��ݗ^�̂������Ή�-end
            } else {
                targetMap = outInsureUnits;
            }
            DivedServiceUnit services = null;
            boolean totalPrinted = false;
            boolean canTotalPrint = (itemState == ITEM_STATE_MULTI_LAST)
                    && CareServiceCommon.isInLimitAmount(subFormatCode);

            // [ID:0000734][Masahiko.Higuchi] 2012/04 ����24�N4���@�����Ή� add begin
            if(isOver30Days && !canTotalPrint) {
                canTotalPrint =  (itemState == ITEM_STATE_MULTI_LAST)
                        && CareServiceCommon.isOutLimitAmount(subFormatCode);
            }
            // [ID:0000734][Masahiko.Higuchi] 2012/04 ����24�N4���@�����Ή� add end

            // �y�[�W��{����o�^
            Iterator it = targetMap.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry ent = (Map.Entry) it.next();
                int unit = ACCastUtilities.toInt(ent.getKey());
                if (unit == 0) {
                    // �P��0�͖���
                    continue;
                }
                
                services = (DivedServiceUnit) ent.getValue();
                
                // ���ʒn����Z�Ə������P���Z�̎��ȕ��S�����ꎞ�I�ɏ㏑�����Ă���ēx�����߂�
                int mainRegulationRate = 0;
                int etcRegulationRate = 0;
                VRMap rec = (VRHashMap)services.get(0);
                String findKey = "";
                mainRegulationRate = ACCastUtilities.toInt(rec.getData("REGULATION_RATE"),0);
                
                // �������@�Đݒ肷�邱�ƂŁAObject�̎Q�Ƃ��Œ肷��@������
                // �������Ă����Ȃ��ƁAaddRedulationRate���ł̔�r�Ɏ��s����
                rec.setData("REGULATION_RATE", mainRegulationRate);
                
                if(CareServiceCommon.isAddPercentage(services.code)) {
                    // �����Ŏ��ȕ��S����}������
                    findKey = ACCastUtilities.toString(rec.getData("PROVIDER_ID")) + "-" + ACCastUtilities.toString(rec.getData("SYSTEM_SERVICE_KIND_DETAIL"));
                    String serviceAddFlag = ACCastUtilities.toString(services.code.get("SERVICE_ADD_FLAG"));
                    if("3".equals(serviceAddFlag) || "6".equals(serviceAddFlag) || "8".equals(serviceAddFlag)) {
                        findKey += "_" + serviceAddFlag;
                        etcRegulationRate = ACCastUtilities.toInt(regulationHash.get(findKey),0);
                        rec.setData("REGULATION_RATE",etcRegulationRate);
                    }
                }
                
                // [H27.4�����Ή�][Yoichiro Kamei] 2015/4/3 add - begin �T�[�r�X�񋟑̐����Z�̎��ȕ��S�Ή�
                boolean teikyoAddFlg = false;
                if (SelfPaymentNumberCalcurater.isTaisho(services.code)) {
                    findKey = ACCastUtilities.toString(rec.getData("PROVIDER_ID")) + "-" + ACCastUtilities.toString(rec.getData("SYSTEM_SERVICE_KIND_DETAIL"));
                    String serviceAddFlag = ACCastUtilities.toString(services.code.get("SERVICE_ADD_FLAG"));
                    findKey += "_" + serviceAddFlag;
                    etcRegulationRate = ACCastUtilities.toInt(regulationHash.get(findKey),0);
                    teikyoAddFlg = true;
                    totals[INDEX_OF_LIMIT_OVER_UNIT_FOR_DETAIL] += etcRegulationRate;
                    totals[INDEX_OF_LIMIT_OVER_UNIT] += etcRegulationRate;
                }
                // [H27.4�����Ή�][Yoichiro Kamei] 2015/4/3 add - end
                
                // [ID:0000764][Masahiko.Higuchi] edit - begin 30�����̕ʕ\�󎚏�Q�Ή�
                
                // [H27.4�����Ή�][Yoichiro Kamei] 2015/4/3 mod - begin �T�[�r�X�񋟑̐����Z�̎��ȕ��S�Ή�
                //if(!isOver30Days)
                if(!isOver30Days && !teikyoAddFlg) {
                // [H27.4�����Ή�][Yoichiro Kamei] 2015/4/3 mod - end
                // ������������Z
                	addRedulationRate(totals, services, regulationCache);
                }
                // [ID:0000764][Masahiko.Higuchi] edit - end
                
                // ���ʒn����Z�Ə������P���Z�ŕύX����Ă���̂Ŏ��ȕ��S�����ēx�����߂�
                rec.setData("REGULATION_RATE", mainRegulationRate);

                if (itemState == ITEM_STATE_SINGLE) {
                    // �P��s�Ŗ��ׂƏ��v
                    services.buildUserSubTableTotalDetailRow(buildParam,
                            provider, insureRate, unit, totals, false, false, isOver30Days);
                } else if (itemState == ITEM_STATE_OUT_LIMIT_AMOUNT) {
                    // ���t�Ǘ����x�z�ΏۊO
                	
                	// [H27.4�����Ή�][Yoichiro Kamei] 2015/4/3 add - begin �T�[�r�X�񋟑̐����Z�̎��ȕ��S�Ή�
                	// �Ώۂ̉��Z�ł���Έ�
                	if (etcRegulationRate > 0 && (SelfPaymentNumberCalcurater.isTaisho(services.code))) {
                        services.buildUserSubTableTotalDetailRow(buildParam,
                                provider, insureRate, unit, totals, true, false, isOver30Days);
                	} else //����if���ւÂÂ�(else if)
                	// [H27.4�����Ή�][Yoichiro Kamei] 2015/4/3 add - end
                	
                    // ���ʒn��E���R�Ԓn��Ə������P���Z�n�Ŏ��ȕ��S������ꍇ�̂ݏ��v�Ɉ󎚂���
                    if(etcRegulationRate > 0 && CareServiceCommon.isAddPercentage(services.code)) {
                        services.buildUserSubTableTotalDetailRow(buildParam,
                                provider, insureRate, unit, totals, true, false, isOver30Days);
                    } else {
                        services.buildUserSubTableTotalDetailRow(buildParam,
                                provider, insureRate, unit, totals, true, true, isOver30Days);                        
                    }
                    // ��
                    if(CareServiceCommon.isCountPrintableServiceCode(services.code)){
                        buildParam.getTargetPage().put(
                            "main.y" + buildParam.getCurrentRow() + ".x8",
                            new Integer(services.size()));
                    }
                } else {

                    // ���׍s
                    services.buildUserSubTableDetailRow(buildParam, provider,
                            unit, totals, isOver30Days);
                }

                buildParam.setCurrentRow(buildParam.getCurrentRow() + 1);
                if (buildParam.getCurrentRow() >= getUserSubTableRowCount()) {
                    // �y�[�W����
                    if ((!it.hasNext()) && canTotalPrint) {
                        // �y�[�W�̐܂�Ԃ��n�_�ł��傤�ǍŌ�̍��ڂƂȂ�A
                        // ����ނ̃T�[�r�X�Ƃ��Ă͍Ō�̍��ڂŁA
                        // ���v�s�̒ǉ��������ꍇ
                        // �����s�ɏ��v��\��                        
                        services.buildUserSubTableTotalRow(buildParam,
                                provider, insureRate, totals, isOver30Days);
                        totalPrinted = true;
                    }
                    buildParam.getPages().add(buildParam.getTargetPage());
                    buildParam.setTargetPage((VRMap) buildParam.getFormPage()
                            .clone());
                    buildParam.setCurrentRow(1);
                }
                
            }
            if ((services != null) && (!totalPrinted) && canTotalPrint) {
                // ���v�s���o��
                services.buildUserSubTableTotalRow(buildParam, provider,
                        insureRate, totals, isOver30Days);
                buildParam.setCurrentRow(buildParam.getCurrentRow() + 1);
                if (buildParam.getCurrentRow() >= getUserSubTableRowCount()) {
                    // �y�[�W����
                    buildParam.getPages().add(buildParam.getTargetPage());
                    buildParam.setTargetPage((VRMap) buildParam.getFormPage()
                            .clone());
                    buildParam.setCurrentRow(1);
                }
            }

            return buildParam.getCurrentRow();
        }
        /**
         * ������������Z���܂��B
         * @param totals �W�v���
         * @param services �P�ʐ��ʃT�[�r�X�W��
         */
        protected void addRedulationRate(int[] totals, DivedServiceUnit services, Set regulationCache){
            // ������������Z
            Iterator it = services.iterator();
            while (it.hasNext()) {
                Map service = (Map) it.next();
                if(!regulationCache.contains(service)){
                    int over = ACCastUtilities.toInt(service
                        .get("REGULATION_RATE"), 0);
                    totals[INDEX_OF_LIMIT_OVER_UNIT_FOR_DETAIL] += over;
                    totals[INDEX_OF_LIMIT_OVER_UNIT] += over;
                    regulationCache.add(service);
                }
            }            
        }

        /**
         * �{�\�ɂ�����1�߂̃T�[�r�X����Ԃ��܂��B
         * 
         * @return �{�\�ɂ�����1�߂̃T�[�r�X���
         */
        public VRMap getMainFormatFirstService() {
            if (result.size() > 0) {
                List list = (List) result.values().iterator().next();
                if ((list instanceof List) && (!((List) list).isEmpty())) {
                    return (VRMap) ((List) list).get(0);
                }
            }
            if (plan.size() > 0) {
                List list = (List) plan.values().iterator().next();
                if ((list instanceof List) && (!((List) list).isEmpty())) {
                    return (VRMap) ((List) list).get(0);
                }
            }
            return null;
        }

        /**
         * �ʕ\�ɂ�����1�߂̃T�[�r�X����Ԃ��܂��B
         * 
         * @return �ʕ\�ɂ�����1�߂̃T�[�r�X���
         */
        public VRMap getSubFormatFirstService() {
            if (inInsureUnits.size() > 0) {
                List list = (List) inInsureUnits.values().iterator().next();
                if ((list instanceof List) && (!((List) list).isEmpty())) {
                    return (VRMap) ((List) list).get(0);
                }
            }
            if (outInsureUnits.size() > 0) {
                List list = (List) outInsureUnits.values().iterator().next();
                if ((list instanceof List) && (!((List) list).isEmpty())) {
                    return (VRMap) ((List) list).get(0);
                }
            }
            return null;
        }

        /**
         * �ʕ\�ֈ󎚉\�ȃT�[�r�X�ł��邩��Ԃ��܂��B
         * 
         * @return �ʕ\�ֈ󎚉\�ȃT�[�r�X�ł��邩
         */
        public boolean isSubFormatPrintable() {
            // �{�݌n/���{�݌n�T�[�r�X�ł͂Ȃ���Εʕ\�Ɉ󎚂���B

            // TODO �f�o�b�O���[�h begin ����������������������������������
            if(isDebugMode()){
                return true;
            }
            //TODO �f�o�b�O���[�h end ������������������������������������
            
            VRMap service = DivedServiceItem.this.getSubFormatFirstService();

            // �{�݌n/���{�݌n�T�[�r�X/����×{�Ǘ��w���͕ʕ\�Ɉ󎚂��Ȃ��B
            return CareServiceCommon.isServiceUseTablePrintable(service);
        }

        /**
         * �T�[�r�X����͂��܂��B
         * 
         * @param services �T�[�r�X
         * @param code �T�[�r�X�R�[�h
         * @param totalGroupingCache ��/���P�ʎZ��L���V��
         * @param calcurateUnit �����܂ł̌v�Z�P�ʐ�
         * @param reductRate ������
         * @throws Exception ������O
         * @return ���Y�T�[�r�X�R�[�h���Z��̒P�ʐ�
         */
        public void parseMain(VRMap service, Map code) throws Exception {
            Date date = ACCastUtilities.toDate(service.get("SERVICE_DATE"),
                    null);
            if (date != null) {
                mainFormatCode = code;
                // �T�[�r�X�̒񋟓����擾
                Integer key = new Integer(ACDateUtilities.getDayOfMonth(date));

                // �\�肩���т�
                Map targetMap;
                if (QkanConstants.SERVICE_USE_TYPE_RESULT_MONTHLY_DAY
                        .equals(service.get("SERVICE_USE_TYPE"))) {
                    targetMap = result;
                } else {
                    targetMap = plan;
                }

                Object val = targetMap.get(key);
                List services;
                if (val instanceof List) {
                    services = (List) val;
                } else {
                    services = new ArrayList();
                    targetMap.put(key, services);
                }
                // ����񋟓��̃f�[�^��ǉ�
                services.add(service);
            }
        }

        /**
         * �T�[�r�X����͂��܂��B
         * 
         * @param services �T�[�r�X
         * @param code �T�[�r�X�R�[�h
         * @param totalGroupingCache ��/���P�ʎZ��L���V��
         * @param calcurateUnit �����܂ł̌v�Z�P�ʐ�
         * @param reductRate ������
         * @throws Exception ������O
         * @return ���Y�T�[�r�X�R�[�h���Z��̒P�ʐ�
         */
        public int parseSub(VRMap service, Map code, Map[] totalGroupingCache,
                int calcurateUnit, int reductRate) throws Exception {
            
            // 2008/01/07 [Masahiko Higuchi] edit - begin ��z��V�T�[�r�X�����Ή�
            // === �����胍�W�b�N�ύX�ɔ����A�����ύX
            //if (isSubParse() && isSubParseCustom(service)) {
            if (isSubParse()) {
            // 2008/01/07 [Masahiko Higuchi] edit -end
                // �ʕ\���Ƃ��Ă���͂���ꍇ
                subFormatCode = code;
                int unit;
                
                int IN_TARGET_FLAG =  CareServiceCodeCalcurater.CALC_MODE_IN_LIMIT_AMOUNT;
                // TODO �f�o�b�O���[�h begin ����������������������������������
                if(isDebugMode()){
                    IN_TARGET_FLAG = CareServiceCodeCalcurater.CALC_MODE_IN_LIMIT_AMOUNT_OR_OUTER_SERVICE;
                }
                // TODO �f�o�b�O���[�h end ����������������������������������
                
                Map targetMap = null;

                // ���t�Ǘ��Ώ�
                unit = getCalcurater().getServiceCodeUnitField(service, true,
                        code,
                        IN_TARGET_FLAG,
                        totalGroupingCache);
                if (unit != 0) {
                    targetMap = inInsureUnits;
                } else {
                    // ���t�Ǘ��ΏۊO
                    unit = getCalcurater()
                            .getServiceCodeUnitField(
                                    service,
                                    true,
                                    code,
                                    CareServiceCodeCalcurater.CALC_MODE_OUT_LIMIT_AMOUNT,
                                    totalGroupingCache);

                    if (unit != 0) {
                        targetMap = outInsureUnits;
                    } else {
                        // 30�������t�Ǘ��Ώ�
                        unit = getCalcurater()
                                .getServiceCodeUnitField(
                                        service,
                                        false,
                                        code,
                                        IN_TARGET_FLAG,
                                        totalGroupingCache);
                        if (unit != 0) {
                            targetMap = inInsureOver30Units;
                        } else {
                            // 30�������t�Ǘ��ΏۊO
                            unit = getCalcurater()
                                    .getServiceCodeUnitField(
                                            service,
                                            false,
                                            code,
                                            CareServiceCodeCalcurater.CALC_MODE_OUT_LIMIT_AMOUNT,
                                            totalGroupingCache);

                            if (unit != 0) {
                                
                                // [ID:0000734][Masahiko.Higuchi] 2012/04 ����24�N4���@�����Ή� add begin
                                if(CareServiceCommon.isAddPercentageForSyogu(code) && CareServiceCommon.is30DayOver(service)){
                                    targetMap = inInsureOver30Units;
                                } else {
                                    targetMap = outInsureOver30Units;
                                }
                                // [ID:0000734][Masahiko.Higuchi] 2012/04 add end
                            }
                        }
                    }

                }
                if (targetMap != null) {
                    // �����܂ł̍��Z�����Ƃɉ��Z�`���ɉ����������ςݒP�ʐ��ɕϊ�
                    Object key = new Integer(unit);

                    unit = getCalcurater().getReductedServiceCodeUnit(code,
                            unit, calcurateUnit, reductRate);
                    calcurateUnit += unit;

                    Object val = targetMap.get(key);
                    DivedServiceUnit page;
                    // �񋟒P�ʂŕ���
                    if (val instanceof DivedServiceUnit) {
                        page = (DivedServiceUnit) val;
                    } else {
                        page = new DivedServiceUnit();
                        targetMap.put(key, page);
                    }

// [H27.4�����Ή�][Yoichiro Kamei] 2015/3/19 mod - begin �Ŏ����Z�����̑Ή�
//                  // ����񋟒P�ʂŏW����
//                  page.parse(service, code);                    
                    String serviceCodeKind = ACCastUtilities.toString(code.get("SERVICE_CODE_KIND"));
                    String serviceCodeItem = ACCastUtilities.toString(code.get("SERVICE_CODE_ITEM"));
                    int serviceCount = QP001SpecialCase.getServiceCount(serviceCodeKind
                        , serviceCodeItem
                        , service);
                    for (int i = 1; i <= serviceCount; i++) {
                        page.parse(service, code);
                    }
// [H27.4�����Ή�][Yoichiro Kamei] 2015/3/19 mod - end
                }
            }
            return calcurateUnit;

        }
        
        protected void checkAddPercentage(Map code) throws Exception{
            if(CareServiceCommon.isAddPercentage(code)){
                //%���Z�͒P�ʕʂŕ����Ȃ�
                addPercentages.add(this);
            }            
        }
        //%���Z�n�̓T�[�r�X��ޒP�ʂœ�������
        
        private Set addPercentages = new HashSet();

        public String toString() {
            StringBuilder sb = new StringBuilder();
            Iterator it = result.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry ent = (Map.Entry) it.next();
                sb.append("�������������T�[�r�X�񋟓��F");
                sb.append(ent.getKey());
                sb.append(ACConstants.LINE_SEPARATOR);
                sb.append("���������������T�[�r�X�F");
                sb.append(ent.getValue());
            }
            return sb.toString();
        }

    }

    /**
     * �T�[�r�X��ޒP�ʂŐ؂�ւ��y�[�W�f�[�^�ł��B
     * <p>
     * Copyright (c) 2005 Nippon Computer Corpration. All Rights Reserved.
     * </p>
     * 
     * @author Tozo Tanaka
     * @version 1.0 2006/02/15
     */
    protected class DivedServiceKind {
        private List codes;
        private int reductRate;
        private int limitAmoutSize;
        
        private int limitAmoutSizeOver30;
        private HashSet hadItemSet = new HashSet();
        
        private TreeMap mainParseMap = new TreeMap();
        private TreeMap subParseMap = new TreeMap();
        // [ID:0000444][Tozo TANAKA] 2009/03/18 add begin ����21�N4���@�����Ή�
        private Map addPersentageTargetCounts = new HashMap();
        // [ID:0000444][Tozo TANAKA] 2009/03/18 add end
        // [ID:0000734][Masahiko.Higuchi] 2012/04 ����24�N4���@�����Ή� add begin
        private Map syoguMap = new HashMap();
        // [ID:0000734][Masahiko.Higuchi] 2012/04 add end

        /**
         * �R���X�g���N�^�ł��B
         * 
         * @param reductRate ������
         */
        public DivedServiceKind(int reductRate) {
            this.reductRate = reductRate;
        }

        /**
         * ���p�[�{�\���\�z���܂��B
         * 
         * @param buildParam �󎚓��e�W��
         * @param isOver30Days 30�����̃T�[�r�X�Ƃ��ďo�͂��邩 
         * @return ���̏o�͑Ώۍs
         * @throws Exception ������O
         */
        public int buildUserMainTable(CareServicePrintParameter buildParam, boolean isOver30Days) throws Exception {
            // �s�̕����P�ʂȂ̂ŉ��y�[�W���l������
            // �{�[�ɂ͊Ǘ��Ώۓ��̃R�[�h�̂݌f��
            VRMap service = DivedServiceKind.this.getMainFormatFirstService();
            if (service != null) {
                String providerName = getCalcurater().getProviderName(service);
                // �y�[�W��{����o�^
                Iterator it = DivedServiceKind.this.mainParseMap.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry ent = (Map.Entry) it.next();
                    DivedServiceItem services = (DivedServiceItem) ent
                            .getValue();

                    services.buildUserMainTable(buildParam.getTargetPage(),
                            buildParam.getCurrentRow(), isOver30Days);

                    // ���Ǝ�
                    buildParam.getTargetPage().put(
                            "lowerHeader.row" + buildParam.getCurrentRow()
                                    + "Upper.provider", providerName);

                    buildParam.setCurrentRow(buildParam.getCurrentRow() + 1);
                    if (buildParam.getCurrentRow() > getUserMainTableRowCount()) {
                        // �y�[�W����
                        buildParam.getPages().add(buildParam.getTargetPage());
                        buildParam.setTargetPage((VRMap) buildParam
                                .getFormPage().clone());
                        buildParam.setCurrentRow(1);
                    }
                }
            }
            return buildParam.getCurrentRow();
        }
        /**
         * %���Z���ɑΉ����邽�߁A�ʕ\�p��2�i�K��͂��s���܂��B
         * @param providerID ���Ə�ID
         * @param systemServiceKindDetail �T�[�r�X���
         * @throws Exception ������O
         */
        public void parseSubSecond(String providerID, int systemServiceKindDetail) throws Exception{
            //2006/06/21 Tozo TANAKA edit-begin �\�h�K����3���Ή��̂���
            if(CareServiceCommon.isHomeVisitCare(systemServiceKindDetail)&&
                // 2016/7/21 [Yoichiro Kamei] mod - begin �������ƑΉ�
                    //CareServiceCommon.isPreventService(systemServiceKindDetail)){
                   (CareServiceCommon.isPreventService(systemServiceKindDetail)
                    || CareServiceCommon.isSogojigyoService(systemServiceKindDetail))){
                // 2016/7/21 [Yoichiro Kamei] mod - begin �������ƑΉ�
                
                //�\�h�K����̏ꍇ
                int minUnit = 9999999;
                Object minKey=null;
                List removeKeys = new ArrayList();
                Iterator it = DivedServiceKind.this.subParseMap.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry ent = (Map.Entry) it.next();
                    Map code = ((DivedServiceItem) ent.getValue()).subFormatCode;
                    if((code!=null)&&(CareServiceCommon.isAddPreventHomeVisitNotDailyBasicCode(code))){
                        //�\�h�K����̓����łȂ������P�ʂ��Ӗ�����T�[�r�X�R�[�h
                        int unit=ACCastUtilities.toInt(code.get("SERVICE_UNIT"),0);
                        if(unit>0){
                            if(unit<minUnit){
                                //�ŏ��P�ʐ����X�V
                                if(minKey!=null){
                                    //����܂ōŏ��Ɩڂ���Ă����R�[�h�����O
                                    removeKeys.add(minKey);
                                }
                                minKey = ent.getKey();
                                minUnit = unit;
                            }else{
                                //�ŏ��łȂ��R�[�h�����O
                                removeKeys.add(ent.getKey());
                            }
                        }
                    }
                }
                it = removeKeys.iterator();
                while (it.hasNext()) {
                    //���O�Ώۂ̃R�[�h���Ȃ�
                    DivedServiceKind.this.subParseMap.remove(it.next());
                 // 2016/7/30 [CCCX:2865][Yoichiro Kamei] add - begin 
                 // ���O�����R�[�h�̏W�v�񂪕\������Ă��Ȃ��̂��C��
                    DivedServiceKind.this.limitAmoutSize--;
                 // 2016/7/30 [CCCX:2865] add - end
                }
            }
            //2006/06/21 Tozo TANAKA edit-end �\�h�K����3���Ή��̂���

            // [ID:0000444][Tozo TANAKA] 2009/03/17 replace begin ����21�N4���@�����Ή�
            Iterator it;
            it = DivedServiceKind.this.subParseMap.entrySet().iterator();
            //��{�P���̃T�[�r�X�R�[�h����A�R�[�h�ƒP�ʐ����Q�Ƃ���n�b�V�����\�z����B
            Map simpleUnitHash = new HashMap(); 
            
            while (it.hasNext()) {
                Iterator it2 = ((DivedServiceItem) ((Map.Entry) it.next()).getValue()).inInsureUnits.entrySet().iterator();
                while(it2.hasNext()){
                    Map.Entry ent = (Map.Entry)it2.next();
                    Map code = ((DivedServiceUnit) ent.getValue()).code;
                    if(CareServiceCommon.isSimpleUnit(code)){
                        //��{�P����SERVICE_CODE_ITEM : {�R�[�h,�P�ʐ�}
                        simpleUnitHash.put(ACCastUtilities.toString(code.get("SERVICE_CODE_ITEM")), new Object[]{code, ent.getKey()});
                    }
                }
            }            
            //��{�P���փT�[�r�X�R�[�h���ƂɏW�v����%���Z�Ώۉ񐔂��悶�����̂�%���Z�ΏےP�ʐ��Ƃ��Đݒ肷��B
            it = DivedServiceKind.this.subParseMap.entrySet().iterator();
            while (it.hasNext()) {
                DivedServiceItem item = (DivedServiceItem) ((Map.Entry) it.next()).getValue();
                int units = 0;
                //���t�Ǘ��ΏۊO�̉��ʃR�[�h��S����
                Iterator it2 = item.outInsureUnits.entrySet().iterator();
                while (it2.hasNext()) {
                    Map.Entry ent = (Map.Entry) it2.next();
                    Map code = ((DivedServiceUnit) ent.getValue()).code;
                    if(CareServiceCommon.isAddPercentage(code)){
                        //%���Z�̑Ώۉ񐔃n�b�V������A%���Z�̃R�[�h�Ńn�b�V������
                        String addServiceCodeItem = ACCastUtilities.toString(code.get("SERVICE_CODE_ITEM"));
                        Object obj;
                        //���Z�T�[�r�X�R�[�h : �񐔓��n�b�V��
                        obj = addPersentageTargetCounts.get(addServiceCodeItem);
                        if(obj instanceof Map){
                            //���o��%���Z�R�[�h
                            Iterator it3 = ((Map)obj).entrySet().iterator();
                            while (it3.hasNext()) {
                                Map.Entry ent3 = (Map.Entry) it3.next();
                                //��{�P�ʂ�SERVICE_CODE_ITEM : {��, �n��n%���Z�n�b�V�� }
                                String simpleCodeItem = ACCastUtilities.toString(ent3.getKey());
                                //{��, �n��n%���Z�n�b�V��}
                                Object[] unitParam = (Object[])ent3.getValue();
                                int addCount = ACCastUtilities.toInt(unitParam[0], 0);
                                Map addAreaHash =(Map)unitParam[1];
                                
                                //��{�P����SERVICE_CODE_ITEM : {�R�[�h,�P�ʐ�}
                                obj = simpleUnitHash.get(simpleCodeItem);
                                if(obj instanceof Object[]){
                                    //��{�P�����擾����B
                                    //{�R�[�h,�P�ʐ�}
                                    Object[] simpleUnitParams = (Object[])obj;
                                    Map simpleCode = (Map)simpleUnitParams[0];
                                    int simpleUnit = ACCastUtilities.toInt(simpleUnitParams[1], 0);
                                    
                                    int targetUnit = getCalcurater().getReductedUnit(providerID, simpleCode, simpleUnit);
                                    units += targetUnit * addCount;
                                    
                                    if(CareServiceCommon.isAddPercentageForArea(code)){
                                        //����P�ʁ{�n��n%���Z��ΏۂƂ���%���Z�̏ꍇ
                                        int areaTargetUnit = targetUnit;
                                        targetUnit = 0;
                                        Iterator it4 = addAreaHash.entrySet().iterator();
                                        while (it4.hasNext()) {
                                            Map.Entry ent4 = (Map.Entry) it4.next();
                                            //�n��n%���ZSERVICE_CODE_ITEM : {�R�[�h,��}
                                            Object[] forAreaTargetCodeParam = (Object[])ent4.getValue();
                                            Map forAreaTargetCode = (Map)forAreaTargetCodeParam[0];
                                            int forAreaTargetCodeCount = ((Integer)forAreaTargetCodeParam[1]).intValue();

                                            int per = ACCastUtilities.toInt(forAreaTargetCode.get("SERVICE_UNIT"),0);
                                            // [ID:0000485][Tozo TANAKA] 2009/04/16 replace begin ���p�[�E�ʕ\�ɂ����Ē��R�Ԓn����Z���ΏۂƂ���P�ʂ̏W�����敪�l��
                                            //����P���{�n��n%���Z�ɂȂ�悤�A�n��n%���Z�������Z����B
                                            targetUnit += (int)Math.round(areaTargetUnit*forAreaTargetCodeCount*per/100.0);
                                            // [ID:0000485][Tozo TANAKA] 2009/04/16 replace end
                                            
                                        }
                                        //����P�ʂ݂̂�ΏۂƂ���%���Z�̏ꍇ�́A�V���ɉ����邱�Ƃ͂��Ȃ��B
                                        units += targetUnit;
                                    }
                                }
                            }
                        }
                    }
                    // [ID:0000682] 2012/01 start ���E���������P���Z�̒ǉ�����
                    if(CareServiceCommon.isAddPercentageForSyogu(code)){
                        // �������P�͒P�ʐ��o�^���Ȃ�
                        continue;
                    }
                    // [ID:0000682] 2012/01 end
                }
                item.setSubPersentageUnit(units);
                // [H27.4�����Ή�][Yoichiro Kamei] 2015/4/3 add - begin �T�[�r�X�񋟑̐����Z�̎��ȕ��S�Ή�
                it2 = item.outInsureUnits.entrySet().iterator();
                while (it2.hasNext()) {
                    Map.Entry ent = (Map.Entry) it2.next();
                    Map code = ((DivedServiceUnit) ent.getValue()).code;
                    VRMap rec = (VRHashMap)((DivedServiceUnit) ent.getValue()).get(0);
                    
                    String providerId = ACCastUtilities.toString(rec.getData("PROVIDER_ID"));
                    String findKey = providerId + "-" + ACCastUtilities.toString(rec.getData("SYSTEM_SERVICE_KIND_DETAIL"));
                    
                    if (regulationHash.containsKey(findKey) && SelfPaymentNumberCalcurater.isTaisho(code)) {
                        String serviceAddFlag = ACCastUtilities.toString((code.get("SERVICE_ADD_FLAG")),"");
                        //���ȕ��S���̒P�ʐ������߂�
                        int limitOverUnit = ACCastUtilities.toInt(regulationHash.get(findKey));
                        selfPaymentNumberCalcurater.parseServiceCode(code, providerId, limitOverUnit);
                        int selfPayUnit = selfPaymentNumberCalcurater.getSelfPayUnit();
                        regulationHash.put(findKey + "_" + serviceAddFlag, new Integer(selfPayUnit));
                    }
                }
                // [H27.4�����Ή�][Yoichiro Kamei] 2015/4/3 add - end
            
            }
            // [ID:0000444][Tozo TANAKA] 2009/03/17 replace end
            
            // [ID:0000682] 2012/01 start ���E���������P���Z�̒ǉ�����
            // �@���t�Ǘ��Ώۓ��{���t�Ǘ��ΏۊO�܂߂Ă��ׂĂ̒P�ʐ������v�����l���쐬����B
            //   �����Z�A�����Z�܂߂Čv�Z��̒l���g�p����
            // �A�������P���Z�����݂���ꍇ�̂ݏ�L�̍��v�P�ʐ��𗘗p�{����f�Ô�̒l�����v���ė��p����
            // �������P���Z�̑ΏۃT�[�r�X��ێ�����
            Map syoguUnitHash = new HashMap();
            syoguUnitHash.put(ACCastUtilities.toString(systemServiceKindDetail), 0);
            it = DivedServiceKind.this.subParseMap.entrySet().iterator();
            while (it.hasNext()) {
                DivedServiceItem item = (DivedServiceItem) ((Map.Entry) it.next()).getValue();
                int units = 0;
                int count = 0;
                // �Ǘ��Ώۓ�
                Iterator it10 = item.inInsureUnits.entrySet().iterator();
                while (it10.hasNext()) {
                    Map.Entry ent = (Map.Entry) it10.next();
                    count = ((DivedServiceUnit) ent.getValue()).size();
                    Map code = ((DivedServiceUnit) ent.getValue()).code;
                    units = ACCastUtilities.toInt(ent.getKey());
                    int reductRate = getCalcurater()
                            .getReductRate(providerID, code);
                    if (reductRate < 100){
                        //��������Ă���ꍇ
                        if(!CareServiceCommon.isAddPercentage(code)) {
                            units = getCalcurater().toReductedUnit(units, reductRate);
                        }
                    }
                    // �񐔂��܂߂Čv�Z
                    units = units * count;
                    if(!CareServiceCommon.isAddPercentageForSyogu(code)){
                      int calcUnit = ACCastUtilities.toInt(syoguUnitHash.get(ACCastUtilities.toString(systemServiceKindDetail)));
                      syoguUnitHash.put(ACCastUtilities.toString(code.get("SYSTEM_SERVICE_KIND_DETAIL")), calcUnit + units);
                    }
                }
                //���t�Ǘ��ΏۊO�̉��ʃR�[�h��S����
                Iterator it20 = item.outInsureUnits.entrySet().iterator();
                while (it20.hasNext()) {
                    Map.Entry ent = (Map.Entry) it20.next();
                    Map code = ((DivedServiceUnit) ent.getValue()).code;
                    units = ACCastUtilities.toInt(ent.getKey());
                    count = ((DivedServiceUnit) ent.getValue()).size();
                    int reductRate = getCalcurater()
                            .getReductRate(providerID, code);
                    if (reductRate < 100){
                        //��������Ă���ꍇ
                        if(!CareServiceCommon.isAddPercentage(code)) {
                            units = getCalcurater().toReductedUnit(units, reductRate);
                        }
                    }
                    // �񐔂��܂߂Čv�Z
                    units = units * count;
                    if(!CareServiceCommon.isAddPercentageForSyogu(code)){
                        int calcUnit = ACCastUtilities.toInt(syoguUnitHash.get(ACCastUtilities.toString(systemServiceKindDetail)));
                        syoguUnitHash.put(ACCastUtilities.toString(code.get("SYSTEM_SERVICE_KIND_DETAIL")), calcUnit + units);                        
                    }
                }
            }
            
            // ���T�[�r�X�R�[�h���������������ōēx�v�Z���J�n����
            ConcurrentHashMap copySubParseMap = new ConcurrentHashMap(DivedServiceKind.this.subParseMap);
            it = copySubParseMap.entrySet().iterator();
            while (it.hasNext()) {
                DivedServiceItem item = (DivedServiceItem) ((Map.Entry) it.next()).getValue();
                int units = 0;
                //���t�Ǘ��ΏۊO�̉��ʃR�[�h��S����
                //����������O���ł�̂�HashMap��ύX
                ConcurrentHashMap copyOutInsureUnits = new ConcurrentHashMap(item.outInsureUnits);
                Iterator it2 = copyOutInsureUnits.entrySet().iterator();
                while (it2.hasNext()) {
                    Map.Entry ent = (Map.Entry) it2.next();
                    Map code = ((DivedServiceUnit) ent.getValue()).code;
                    // ���̏������P���Z����������
                    if(CareServiceCommon.isAddPercentageForSyogu(code)){
                        int totalUnit = ACCastUtilities.toInt(syoguUnitHash.get(ACCastUtilities.toString(systemServiceKindDetail)));
                        int totalRegulation = 0;
                        // ��
                        int serviceUnit = ACCastUtilities.toInt(code.get("SERVICE_UNIT"),0);
                        // �������P����
                        int serviceStaffUnit = ACCastUtilities.toInt(code.get("SERVICE_STAFF_UNIT"),0);
                        // ����f�Ô�E���ʗ×{��̒P�ʐ������v
                        // �v�Z�����N���X����l���擾 "���Ə��ԍ�-�����T�[�r�X��ރR�[�h" 
                        String serchKey = providerID + "-" + ACCastUtilities.toString(systemServiceKindDetail);
                        if(diagnosisHash.containsKey(serchKey)) {
                            // Debug �f�o�b�O
                            System.out.println("����f�Ô�E���ʗ×{�� = " + diagnosisHash.get(serchKey));
                            // Debug �f�o�b�O
                            totalUnit += diagnosisHash.get(serchKey);
                        }
                        // ���ȕ��S�v�Z
                        if(regulationHash.containsKey(serchKey)) {
                            // �T�[�r�X�ݒ莩�ȕ��S��
                            totalRegulation = regulationHash.get(serchKey);
                            // ���ʒn����Z
                            if(regulationHash.containsKey(serchKey + "_3")) {
                                totalRegulation += regulationHash.get(serchKey + "_3");
                            }
                            // ���R�Ԓn����Z
                            if(regulationHash.containsKey(serchKey + "_6")) {
                                totalRegulation += regulationHash.get(serchKey + "_6");
                            }
                            // [H27.4�����Ή�][Yoichiro Kamei] 2015/4/3 add - begin �T�[�r�X�񋟑̐����Z�̎��ȕ��S�Ή�
                            if (regulationHash.containsKey(serchKey + "_2")) {
                                totalRegulation += regulationHash.get(serchKey + "_2");
                            }
                            if (regulationHash.containsKey(serchKey + "_4")) {
                                totalRegulation += regulationHash.get(serchKey + "_4");
                            }
                            // [H27.4�����Ή�][Yoichiro Kamei] 2015/4/3 add - end
                            
                            // [ID:0000728][Masahiko.Higuchi] 2012/04 ����24�N4���@�����Ή� edit begin
                            int result = CareServiceCommon.calcSyoguPatientSelf(totalUnit, totalRegulation, serviceUnit, serviceStaffUnit);
                            regulationHash.put(serchKey + "_8", result);
                            // [ID:0000728][Masahiko.Higuchi] 2012/04 ����24�N4���@�����Ή� edit end
                        }
                        units = CareServiceCommon.calcSyogu(totalUnit, serviceUnit, serviceStaffUnit);
                        // �v�Z��̒P�ʐ���o�^����
                        item.outInsureUnits.put(units, ((DivedServiceUnit) ent.getValue()));

                    }
                }
            }
            
            // [ID:0000682] 2012/01 end
            
        }
        /**
         * ���p�[�ʕ\���\�z���܂��B
         * 
         * @param buildParam �󎚓��e�W��
         * @param provider ���Ə����
         * @param insureRate �ی����t��
         * @param totals �W�v���
         * @param inLimitAmount ���t�Ǘ����x�z�Ώۂ��o�͂��邩
         * @param isOver30Days 30����
         * @return ���̏o�͑Ώۍs
         * @throws Exception ������O
         */
        public int buildUserSubTable(CareServicePrintParameter buildParam, Map provider,
                int insureRate, int[] totals, boolean inLimitAmount, boolean isOver30Days)
                throws Exception {

            int limitAmount = isOver30Days? getLimitAmountSizeOver30(): getLimitAmountSize();
            
            Set regulationCache = new HashSet();
            int itemState;
            if (!inLimitAmount) {
                itemState = ITEM_STATE_OUT_LIMIT_AMOUNT;
            } else if (limitAmount > 1) {
                itemState = ITEM_STATE_MULTI_NOT_LAST;
            } else {
                itemState = ITEM_STATE_SINGLE;
            }

            // [ID:0000734][Masahiko.Higuchi] 2012/04 ����24�N4���@�����Ή� add begin
            int over30Count = 0;
            int temp30Count = 0;
            // [ID:0000734][Masahiko.Higuchi] 2012/04 add end
            // 30���������t�Ǘ��ΏۊO���v��
            if (isOver30Days) {
                Iterator it = subParseMap.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry ent = (Map.Entry) it.next();
                    
                    // [ID:0000734][Masahiko.Higuchi] 2012/04 ����24�N4���@�����Ή� add begin
                    // �������P�͈�x�͂���
                    if(syoguMap.containsKey(ent.getKey())){
                        over30Count = temp30Count+1;
                        continue;
                    }
                    // [ID:0000734][Masahiko.Higuchi] 2012/04 add end
                    
                    DivedServiceItem services = (DivedServiceItem) ent
                            .getValue();
                    if (!services.isSubFormatPrintable()) {
                        continue;
                    }
                    // ���ʏ��\�z
                    services.buildUserSubTableOver30Days(buildParam, provider,
                            insureRate, totals);
                    temp30Count++;
                }
                // [ID:0000734][Masahiko.Higuchi] 2012/04 ����24�N4���@�����Ή� add begin
                // �������P���Ō�ɏ����������̂ŁA��x�͂����Ă���ŏI�I�ɏ�������
                it = syoguMap.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry ent = (Map.Entry) it.next();
                    DivedServiceItem services = (DivedServiceItem) ent
                            .getValue();
                    if (!services.isSubFormatPrintable()) {
                        continue;
                    }
                    // ���ʏ��\�z
                    services.buildUserSubTableOver30Days(buildParam, provider,
                            insureRate, totals);
                }
                // [ID:0000734][Masahiko.Higuchi] 2012/04 add end
            }
            
            // [ID:0000734][Masahiko.Higuchi] 2012/04 ����24�N4���@�����Ή� add begin
            temp30Count = 0;
            // [ID:0000734][Masahiko.Higuchi] 2012/04 ����24�N4���@�����Ή� add end
            //���C���R�[�h
            int buildIndex = 0;
            Iterator it = subParseMap.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry ent = (Map.Entry) it.next();
                DivedServiceItem services = (DivedServiceItem) ent.getValue();
                if (!services.isSubFormatPrintable()) {
                    continue;
                }
                
                if (itemState == ITEM_STATE_MULTI_NOT_LAST) {
                    // ���v�o�͑Ώۂ̏ꍇ
                    if (++buildIndex >= limitAmount) {
                        // ���t�Ǘ��ΏۂƂ��Ă͍Ō�̃T�[�r�X�̏ꍇ�͏o�̓��[�h��ύX
                        itemState = ITEM_STATE_MULTI_LAST;

                    }
                }
                
                // [ID:0000734][Masahiko.Higuchi] 2012/04 ����24�N4���@�����Ή� add begin
                if(isOver30Days) {
                    temp30Count++;
                }
                if(temp30Count >= subParseMap.size()) {
                    if(over30Count == temp30Count) {
                        itemState = ITEM_STATE_MULTI_LAST;
                    }
                }
                // [ID:0000734][Masahiko.Higuchi] 2012/04 ����24�N4���@�����Ή� add end
                
                // ���ʏ��\�z
                int beforeIndex = buildParam.getCurrentRow();
                int afterIndex = services.buildUserSubTable(buildParam,
                        provider, insureRate, totals, itemState, regulationCache, isOver30Days);
                if(beforeIndex!=afterIndex){
                    buildParam.setCurrentRow(afterIndex);
                }else{
                    buildIndex--;
                }
//                buildParam.setCurrentRow(services.buildUserSubTable(buildParam,
//                        provider, insureRate, totals, itemState, regulationCache, isOver30Days));
                
                //[H27.4�����Ή�][Shinobu Hitaka] 2015/3/30 add - begin
                //30�����̏ꍇ�Ɏx�����x�z�ΏۊO�̍��ڂ��o�͂���i�T�[�r�X�񋟑̐��������Z�����x�z�Ǘ��O�ɂȂ������߁j
            	if (isOver30Days){
	                int[] dummyTotal = new int[totals.length];
	                Map outMap = ((DivedServiceItem) ent.getValue()).outInsureOver30Units;
	                Iterator outIt = outMap.entrySet().iterator();
	                while (outIt.hasNext()) {
	                    Map.Entry outEnt = (Map.Entry) outIt.next();
	                    DivedServiceUnit outService = (DivedServiceUnit)outEnt.getValue();
	                    outService.buildUserSubTableDetailRow(buildParam, provider,
	                        0, dummyTotal, isOver30Days);
	                    buildParam.setCurrentRow(buildParam.getCurrentRow() + 1);
	                }
                }
            	//[H27.4�����Ή�][Shinobu Hitaka] 2015/3/30 add - end
            }
        	
            return buildParam.getCurrentRow();
        }

        /**
         * �x���Ǘ����x�z���̃T�[�r�X����Ԃ��܂��B
         * 
         * @return �x���Ǘ����x�z���̃T�[�r�X��
         */
        protected int getLimitAmountSize() {
            return limitAmoutSize;
        }

        /**
         * 30�����̎x���Ǘ����x�z���̃T�[�r�X����Ԃ��܂��B
         * 
         * @return 30�����̎x���Ǘ����x�z���̃T�[�r�X��
         */
        protected int getLimitAmountSizeOver30() {
            return limitAmoutSizeOver30;
        }

        /**
         * 1�߂̃T�[�r�X����Ԃ��܂��B
         * 
         * @return 1�߂̃T�[�r�X���
         */
        public VRMap getMainFormatFirstService() {
            if (mainParseMap.size() > 0) {
                Iterator it = mainParseMap.values().iterator();
                while (it.hasNext()) {
                    VRMap result = ((DivedServiceItem) it.next())
                            .getMainFormatFirstService();
                    if (result != null) {
                        return result;
                    }
                }
            }
            return null;
        }

        /**
         * 1�߂̃T�[�r�X����Ԃ��܂��B
         * 
         * @return 1�߂̃T�[�r�X���
         */
        public VRMap getSubFormatFirstService() {
            if (subParseMap.size() > 0) {
                Iterator it = subParseMap.values().iterator();
                while (it.hasNext()) {
                    VRMap result = ((DivedServiceItem) it.next())
                            .getSubFormatFirstService();
                    if (result != null) {
                        return result;
                    }
                }
            }
            return null;
        }

        /**
         * �T�[�r�X����͂��܂��B
         * 
         * @param services �T�[�r�X
         * @param totalGroupingCache ��/���P�ʎZ��L���V��
         * @throws Exception ������O
         */
        public void parseMainTable(VRMap service, Map[] totalGroupingCache)
                throws Exception {
            // �T�[�r�X�R�[�h�擾
            codes = getCalcurater().getServiceCodes(service);


            Iterator it = codes.iterator();
            while (it.hasNext()) {
                Map code = (Map) it.next();
                if (getCalcurater().isInSpecialFacility(code)) {
                    // [ID:0000627][Masahiko Higuchi] 2011/03 replace begin ���Ȏ�f�E�O�����Z���̖{�[�ւ̈�
                    // ����{�ݓ����҂Ɋւ���R�[�h�͏��O
                    continue;
                    // [ID:0000627][Masahiko Higuchi] 2011/03 replace end
                }

                if (isMainFormatPrintable(service, code)) {
                    // �{�\�Ɉ󎚉\�ȃT�[�r�X�R�[�h�̂ݒǉ�
                    Object key = code.get("SERVICE_CODE_ITEM");
                    if (key == null) {
                        key = "";
                    }
                    Object val = DivedServiceKind.this.mainParseMap.get(key);
                    DivedServiceItem page;
                    // �T�[�r�X���e�ŕ���
                    if (val instanceof DivedServiceItem) {
                        page = (DivedServiceItem) val;
                    } else {
                        page = new DivedServiceItem();
                        DivedServiceKind.this.mainParseMap.put(key, page);
                    }

                    // ����T�[�r�X���e���ŕ���
                    page.parseMain(service, code);
                }

            }
        }
        /**
         * �{�\�ֈ󎚉\�ȃT�[�r�X�ł��邩��Ԃ��܂��B
         * 
         * @return �{�\�ֈ󎚉\�ȃT�[�r�X�ł��邩
         */
        protected boolean isMainFormatPrintable(VRMap service, Map code)
        		throws Exception {
            
            // [ID:0000532][Masahiko Higuchi] 2009/08 add begin 2009�N�x�Ή�
            boolean isNotPrint = false;
            // �{�[�Ɉ󎚂���̃L�[���Ȃ��ꍇ�̓T�[�r�X�񋟃f�[�^�Ƃ��Ĉ���
            // �\�h��������Ґ������݈̂قȂ�o�C���h�p�X
            String[] checkBindPath = { "15", "1350129", "1350130", "1350131" };
            
            for (int i = 0; i < checkBindPath.length; i++) {
                // �{�[�Ɉ󎚂���`�F�b�N�����݂���ꍇ
                if (ACCastUtilities.toInt(service.getData(checkBindPath[i]), 0) == 1) {
                    // �`�F�b�N���Ȃ��ꍇ�̂ݒ񋟓��ȊO�̃f�[�^�Ƃ���
                    isNotPrint = true;
                    break;
                }   
            }
            
            if(isNotPrint) {
                return false;
            }
            // [ID:0000532][Masahiko Higuchi] 2009/08 add end
            
            // TODO
            // [H27.4�����Ή�][Shinobu Hitaka] 2015/3/10 edit - begin �敪�x������x�z�Ǘ��ΏۊO�̈�ON/OFF�ɑΉ��B
            // �{�݌n/���{�݌n�T�[�r�X�����t�Ǘ����x�z�Ώۓ��̏ꍇ�͖{�\�Ɉ󎚂���B
            // ���{�݌n�⋏��×{�Ǘ��w�����󎚂��Ȃ��ꍇ�́Aparse�̎��_�ō���Ă���B
            // del - begin
            //return CareServiceCommon.isServiceUseTableMainFormatPrintableCode(code)
            //        || CareServiceCommon.isFacility(service)
            //        || CareServiceCommon.isLifeCare(service)
            //        || CareServiceCommon.isHomeMedicalAdvice(service)
            //        ;
            // del - end
            // add - start
            // �ȉ�������ΏۂƂ���B
            // �x�����x�z�Ǘ��ΏۊO�E�ً}���K��Ō���Z�E���ʊǗ����Z�E�^�[�~�i���P�A���Z�E�ً}�����ÊǗ�
            // �������A�ȉ��͐ݒ��ʂ�ON/OFF�ɏ]��
            // ���ʒn����Z�E���K�͎��Ə����Z�A���R�Ԓn��񋟉��Z�A���E���������P���Z
            return (!CareServiceCommon.isAddSpecialAreaOfWelfareEquipment(code)	// �����p��̓��ʒn����Z�ȊO
                    && !CareServiceCommon.isAddPercentageForSimple(code)		// ���ʒn����Z�E���K�͎��Ə����Z�ȊO
                    && !CareServiceCommon.isAddPercentageForArea(code))			// ���R�Ԓn��񋟉��Z�ȊO
                    && !CareServiceCommon.isAddPercentageForSyogu(code)			// ���E���������P���Z�ȊO
                    || (CareServiceCommon.isAddSpecialAreaOfWelfareEquipment(code) && isPrintSpecialArea())	// �����p��̓��ʒn����Z
                    || (CareServiceCommon.isAddPercentageForSimple(code) && isPrintSpecialArea())			// ���ʒn����Z�E���K�͎��Ə����Z
                    || (CareServiceCommon.isAddPercentageForArea(code) && isPrintChusankanArea())			// ���R�Ԓn��񋟉��Z
                    || (CareServiceCommon.isAddPercentageForSyogu(code) && isPrintSyoguKaizen())			// ���E���������P���Z
                    || CareServiceCommon.isFacility(service)			// �{��
                    || CareServiceCommon.isLifeCare(service)			// ���{��
                    || CareServiceCommon.isHomeMedicalAdvice(service)	// ����×{�Ǘ��w��
                    ;
            // add - end
            // [H27.4�����Ή�][Shinobu Hitaka] 2015/3/10 edit - end 
        }

        /**
         * �T�[�r�X����͂��܂��B
         * 
         * @param services �T�[�r�X
         * @param totalGroupingCache ��/���P�ʎZ��L���V��
         * @throws Exception ������O
         */
        public void parseSubTable(VRMap service, Map[] totalGroupingCache)
                throws Exception {
            VRMap serviceAddFlagMap = new VRHashMap();
            
            // �T�[�r�X�R�[�h�擾
            codes = getCalcurater().getServiceCodes(service);

            // [ID:0000444][Tozo TANAKA] 2009/03/18 add begin ����21�N4���@�����Ή�
            List simpleServiceCodeItems = new ArrayList();
            // [ID:0000444][Tozo TANAKA] 2009/03/18 add end
            // ���Z�P��
            int calcurateUnit = 0;
            Iterator it = codes.iterator();
            while (it.hasNext()) {
                Map code = (Map) it.next();
                if (getCalcurater().isInSpecialFacility(code)) {
                    // ����{�ݓ����҂Ɋւ���R�[�h�͏��O
                    // [CCCX:1647][Shinobu Hitaka] 2014/05/08 replace begin ���Ȏ�f�E�O�����Z���̌v��
                    //return;
                    continue;
                    // [CCCX:1647][Shinobu Hitaka] 2014/05/08 replace end   ���Ȏ�f�E�O�����Z���̌v��
                }

                // �ʕ\�p�K�w���
                calcurateUnit = parseSub(service, totalGroupingCache, code,
                        calcurateUnit);

                // [ID:0000444][Tozo TANAKA] 2009/03/18 add begin ����21�N4���@�����Ή�
                if(CareServiceCommon.isSimpleUnit(code)){
                    //���̃T�[�r�X�̊�{�P��
                    simpleServiceCodeItems.add(ACCastUtilities.toString(code.get("SERVICE_CODE_ITEM")));
                    serviceAddFlagMap.setData(ACCastUtilities.toString(code.get("SERVICE_CODE_ITEM")), code.get("TOTAL_GROUPING_TYPE"));
                }
                // [ID:0000444][Tozo TANAKA] 2009/03/18 add end
            }
            
            // [ID:0000444][Tozo TANAKA] 2009/03/18 add begin ����21�N4���@�����Ή�
            //�R�[�h���ƂɊ�{�P�����悶�����̂�ݐς��Ă���
            
            //�y�d�l�����z
            //�u���R�Ԓn�擙�ł̃T�[�r�X�񋟉��Z�v�́A%���Z�̃T�[�r�X�R�[�h�ł���B
            //���l��%���Z�̃T�[�r�X�R�[�h�Ƃ��āA�u���ʒn����Z�v��(���R�Ԓn�擙��)�u���K�͎��Ə����Z�v������B
            //��҂͎��Ə��̐��̈��ł���A�u����P�ʐ�(��{�P�ʐ�)�v�ɑ΂��ĔC�ӂ�%�����Z������̂ŁA���̉��Z�̗L���ɂ͉e�����󂯂Ȃ��B
            //�������O�҂͗��p�҂̏󋵂Ɉˑ�����񋟉��Z�ł���A�u����P�ʐ�(��{�P�ʐ�)�{�n��n%���Z�v�ɑ΂��ĔC�ӂ�%�����Z������̂ł���B
            //�����ł́A�O�҂��u%���Z(�Ώۂɒn��n���Z���܂�)�v�Ə̂���B
            //��҂́u%���Z(�Ώۂɒn��n���Z���܂܂Ȃ�)�v�́A���̂Ƃ���u���ʒn����Z�v��(���R�Ԓn�擙��)�u���K�͎��Ə����Z�v�݂̂ł��邪�A
            //���̗������u�n��n%���Z�v�Ə̂���B
            //���|�C���g1��
            //�@�u%���Z(�Ώۂɒn��n���Z���܂�)�v���ΏۂƂ���P�ʐ��́A�u�n��n%���Z�v�����߂���łȂ��ƌv�Z�ł��Ȃ��B
            //
            //�񋟉��Z�́A��ʏ�A���W�I�ł���E�Ȃ���؂�ւ��邱�Ƃ������A�������E�����p�ҁE�����Ə��ł����Ă��A�Z�肷��Ƃ��ƎZ�肵�Ȃ��Ƃ�������B
            //���������āA�u%���Z(�Ώۂɒn��n���Z���܂�)�v���ΏۂƂ����{�P�ʂ́A�����Z��񋟂����Ƃ��̊�{�P�ʂɌ���˂΂Ȃ�Ȃ��B
            //�܂��A���Ə��̐��ł���u�n��n%���Z�v�́A�ʏ�A���ꎖ�Ə��ł���Β񋟕����ׂĂ��ΏۂɂȂ���Z�����A
            //�u%���Z(�Ώۂɒn��n���Z���܂�)�v���ΏۂƂ���u�n��n%���Z�v�́A���̂��������Z��񋟂����Ƃ��́u�n��n%���Z�v�Ɍ���˂΂Ȃ�Ȃ��B
            //���|�C���g2��
            //�@�u%���Z(�Ώۂɒn��n���Z���܂�)�v���ΏۂƂ���u�n��n%���Z�v�́A�񋟕����ׂĂɂ�����u�n��n%���Z�v�Ƃ͕ʂɁA
            //�@�u%���Z(�Ώۂɒn��n���Z���܂�)�v��񋟂����Ƃ��Ɍ����ďW�v���˂΂Ȃ�Ȃ��B
            //
            //�ʕ\�p�̉�͏����uparseSub�`�v�́A�T�[�r�X�̒񋟏�����͂��A�T�[�r�X�R�[�h�P�ʂɂ΂炷�������s���B
            //�΂炵�I��������Ƃ́u���ZA��񋟂����Ƃ��ɉ��ZB��񋟂������v�Ƃ����T�[�r�X�R�[�h���m�̊֘A����H�邱�Ƃ͂ł��Ȃ��B
            //���̂��߁A�T�[�r�X�R�[�h�P�ʂɂ΂炷�����Ɠ����ɁA%���Z�̑ΏۂƂȂ�u����P�ʐ�(��{�P�ʐ�)�v�₻�̃T�[�r�X�R�[�h���A
            //%���Z�̃T�[�r�X�R�[�h�Ɗ֘A�t���đޔ����Ă����˂΂Ȃ�Ȃ��B
            //�����̊֘A�t����ޔ��������̂��A�N���X���ϐ�addPersentageTargetCounts�ł���B
            //
            //�֘A�t���̑ޔ��́A�ȉ��̎菇�Ŏ��������B
            //(1)�܂��ŏ��Ɂu%���Z(�Ώۂɒn��n���Z���܂�)�v�̃T�[�r�X�R�[�h�����邩�𑖍�����B
            //�@(2)�u%���Z(�Ώۂɒn��n���Z���܂�)�v���ΏۂƂ��ׂ��u��{�P��(����P��)�v�̃T�[�r�X�R�[�h�ƒ񋟉񐔂�~�ς���B
            //�@(3)�u�n��n%���Z�v�Ɗ֘A�t����ׂ��u%���Z(�Ώۂɒn��n���Z���܂�)�v�Ƃ��ăX�g�b�N����B
            //(4)�����āu%���Z(�Ώۂɒn��n���Z���܂܂Ȃ�)�v�̃T�[�r�X�R�[�h�����邩�𑖍�����B
            //�@(5)�u%���Z(�Ώۂɒn��n���Z���܂܂Ȃ�)�v���ΏۂƂ��ׂ��u��{�P��(����P��)�v�̃T�[�r�X�R�[�h�ƒ񋟉񐔂�~�ς���B
            //�@(6)�֘A�t����ׂ��u%���Z(�Ώۂɒn��n���Z���܂�)�v���X�g�b�N����Ă��邩���m�F����B
            //�@�@(7)�u%���Z(�Ώۂɒn��n���Z���܂�)�v���ΏۂƂ��ׂ��u�n��n%���Z�v�̃T�[�r�X�R�[�h�ƒ񋟉񐔂�~�ς���B
            //
            
            // [ID:0000485][Tozo TANAKA] 2009/04/15 add begin ���p�[�E�ʕ\�ɂ����Ē��R�Ԓn����Z���ΏۂƂ���P�ʂ̏W�����敪�l��
            int serviceDayOfMonth = 100;
            Date serviceDate = ACCastUtilities.toDate(VRBindPathParser.get(
                    "SERVICE_DATE", service), null);
            if (serviceDate != null) {
                serviceDayOfMonth = ACDateUtilities
                        .getDayOfMonth((Date) serviceDate);
            }
            // [ID:0000485][Tozo TANAKA] 2009/04/15 add end
            
            //(1)�܂��ŏ��Ɂu%���Z(�Ώۂɒn��n���Z���܂�)�v�̃T�[�r�X�R�[�h�����邩�𑖍�����B
            Map forAreaCodes = new HashMap();
            it = codes.iterator();
            while (it.hasNext()) {
                Map code = (Map) it.next();
                if(CareServiceCommon.isAddPercentageForArea(code)){
                    //%���Z�̃T�[�r�X�R�[�h�̏ꍇ
                    
                    //%���Z�̑Ώۉ񐔃n�b�V������A%���Z�̃R�[�h�Ńn�b�V������
                    String addServiceCodeItem = ACCastUtilities.toString(code.get("SERVICE_CODE_ITEM"));

                    Object obj;
                    Map simpleUnits;
                    obj = addPersentageTargetCounts.get(addServiceCodeItem);
                    if(obj instanceof Map){
                        //���o��%���Z�R�[�h
                        simpleUnits = (Map)obj;
                    }else{
                        //�V�K��%���Z�R�[�h
                        simpleUnits = new HashMap();
                        addPersentageTargetCounts.put(addServiceCodeItem, simpleUnits);
                    }
                    //���Y%���Z�R�[�h���ΏۂƂ����{�P�ʃR�[�h�ŉ��ʃn�b�V������
                    Iterator it2 = simpleServiceCodeItems.iterator();
                    while(it2.hasNext()){
                        //(2)�u%���Z(�Ώۂɒn��n���Z���܂�)�v���ΏۂƂ��ׂ��u��{�P��(����P��)�v�̃T�[�r�X�R�[�h�ƒ񋟉񐔂�~�ς���B
                        String simpleServiceCodeItem = ACCastUtilities.toString(it2.next());
                        
                        int totalGroupingType = ACCastUtilities.toInt(serviceAddFlagMap.get(simpleServiceCodeItem), 0);
                        
                        //��{SERVICE_CODE_ITEM : {��, �n��n%���Z�n�b�V��} 
                        obj = simpleUnits.get(simpleServiceCodeItem);
                        Object[] unitParam;
                        if(obj instanceof Object[]){
                            //����%���Z�R�[�h�ɂ����āA���o�̊�{�P�ʃR�[�h
                            unitParam = (Object[])obj;

                            // [ID:0000485][Tozo TANAKA] 2009/04/15 replace begin ���p�[�E�ʕ\�ɂ����Ē��R�Ԓn����Z���ΏۂƂ���P�ʂ̏W�����敪�l��
                            //unitParam[0] = new Integer( ((Integer)unitParam[0]).intValue() +1);
                            boolean canCountUp = true;
                            switch(totalGroupingType){
                            case 2:
                                //���P�ʎZ��
                                boolean[] groupingFlags = (boolean[])unitParam[2];
                                if(groupingFlags.length > serviceDayOfMonth){
                                    if(groupingFlags[serviceDayOfMonth]){
                                        //���Y�T�[�r�X�񋟓��̃t���O��true�Ȃ�΁A�����񋟍ς݂Ȃ̂ŃJ�E���g�A�b�v��������continue����B
                                        canCountUp = false;
                                    }else{
                                        //���Y�T�[�r�X�񋟓��̃t���O��true�ɂ���B
                                        groupingFlags[serviceDayOfMonth] = true;
                                    }
                                }
                                break;
                            case 3:
                                //���P�ʎZ��
                                //���P�ʂŊ��o�Ƃ������Ƃ̓J�E���g�A�b�v��������continue����B
                                canCountUp = false;
                                break;
                            }
                            if(canCountUp){
                                unitParam[0] = new Integer( ((Integer)unitParam[0]).intValue() +1);
                            }
                            // [ID:0000485][Tozo TANAKA] 2009/04/15 replace end

                        }else{
                            // [ID:0000485][Tozo TANAKA] 2009/04/15 replace begin ���p�[�E�ʕ\�ɂ����Ē��R�Ԓn����Z���ΏۂƂ���P�ʂ̏W�����敪�l��
                            //unitParam = new Object[]{new Integer(1), new HashMap()};
                            unitParam = new Object[]{new Integer(1), new HashMap(), new boolean[33]};
                            switch(totalGroupingType){
                            case 2:
                                //���P�ʎZ��
                                boolean[] groupingFlags = (boolean[])unitParam[2];
                                if(groupingFlags.length > serviceDayOfMonth){
                                    //���Y�T�[�r�X�񋟓��̃t���O��true�ɂ��Ă����B
                                    groupingFlags[serviceDayOfMonth] = true;
                                }
                                break;
                            }
                            // [ID:0000485][Tozo TANAKA] 2009/04/15 add end
                        }
                        //����%���Z�R�[�h�ɂ����āA���Y��{�P�ʃR�[�h���ΏۂƂȂ����񐔂��X�V����B
                        simpleUnits.put(simpleServiceCodeItem, unitParam);
                        
                        //(3)�u�n��n%���Z�v�Ɗ֘A�t����ׂ��u%���Z(�Ώۂɒn��n���Z���܂�)�v�Ƃ��ăX�g�b�N����B
                        //����P�ʁ{�n�擙���Z��Ώۂɂ���%���Z�̃n�b�V���ɒǉ�����B
                        forAreaCodes.put(simpleServiceCodeItem, unitParam);
                    }
                    
                }
            }
            
            //(4)�����āu%���Z(�Ώۂɒn��n���Z���܂܂Ȃ�)�v�̃T�[�r�X�R�[�h�����邩�𑖍�����B
            it = codes.iterator();
            while (it.hasNext()) {
                Map code = (Map) it.next();
                if(CareServiceCommon.isAddPercentageForSimple(code)){
                    //%���Z�̃T�[�r�X�R�[�h�̏ꍇ
                    
                    //%���Z�̑Ώۉ񐔃n�b�V������A%���Z�̃R�[�h�Ńn�b�V������
                    String addServiceCodeItem = ACCastUtilities.toString(code.get("SERVICE_CODE_ITEM"));
                    
                    Object obj;
                    //���Z�T�[�r�X�R�[�h : �񐔓��n�b�V��
                    Map simpleUnits;
                    obj = addPersentageTargetCounts.get(addServiceCodeItem);
                    if(obj instanceof Map){
                        //���o��%���Z�R�[�h
                        simpleUnits = (Map)obj;
                    }else{
                        //�V�K��%���Z�R�[�h
                        simpleUnits = new HashMap();
                        addPersentageTargetCounts.put(addServiceCodeItem, simpleUnits);
                    }
                    //���Y%���Z�R�[�h���ΏۂƂ����{�P�ʃR�[�h�ŉ��ʃn�b�V������
                    Iterator it2 = simpleServiceCodeItems.iterator();
                    while(it2.hasNext()){
                        //(5)�u%���Z(�Ώۂɒn��n���Z���܂܂Ȃ�)�v���ΏۂƂ��ׂ��u��{�P��(����P��)�v�̃T�[�r�X�R�[�h�ƒ񋟉񐔂�~�ς���B
                        String simpleServiceCodeItem = ACCastUtilities.toString(it2.next());
                        
                        int totalGroupingType = ACCastUtilities.toInt(serviceAddFlagMap.get(simpleServiceCodeItem), 0);
                        
                        //��{SERVICE_CODE_ITEM : {��, �n��n%���Z�n�b�V��} 
                        obj = simpleUnits.get(simpleServiceCodeItem);
                        Object[] unitParam;
                        if(obj instanceof Object[]){
                            //����%���Z�R�[�h�ɂ����āA���o�̊�{�P�ʃR�[�h
                            unitParam = (Object[])obj;
                            
                            // [ID:0000485][Tozo TANAKA] 2009/04/15 replace begin ���p�[�E�ʕ\�ɂ����Ē��R�Ԓn����Z���ΏۂƂ���P�ʂ̏W�����敪�l��
                            //unitParam[0] = new Integer( ((Integer)unitParam[0]).intValue() +1);
                            boolean canCountUp = true;
                            switch(totalGroupingType){
                            case 2:
                                //���P�ʎZ��
                                boolean[] groupingFlags = (boolean[])unitParam[2];
                                if(groupingFlags.length > serviceDayOfMonth){
                                    if(groupingFlags[serviceDayOfMonth]){
                                        //���Y�T�[�r�X�񋟓��̃t���O��true�Ȃ�΁A�����񋟍ς݂Ȃ̂ŃJ�E���g�A�b�v��������continue����B
                                        canCountUp = false;
                                    }else{
                                        //���Y�T�[�r�X�񋟓��̃t���O��true�ɂ���B
                                        groupingFlags[serviceDayOfMonth] = true;
                                    }
                                }
                                break;
                            case 3:
                                //���P�ʎZ��
                                //���P�ʂŊ��o�Ƃ������Ƃ̓J�E���g�A�b�v��������continue����B
                                canCountUp = false;
                                break;
                            }
                            if(canCountUp){
                                unitParam[0] = new Integer( ((Integer)unitParam[0]).intValue() +1);
                            }
                            // [ID:0000485][Tozo TANAKA] 2009/04/15 replace end
                            
                        }else{
                            // [ID:0000485][Tozo TANAKA] 2009/04/15 replace begin ���p�[�E�ʕ\�ɂ����Ē��R�Ԓn����Z���ΏۂƂ���P�ʂ̏W�����敪�l��
                            //unitParam = new Object[]{new Integer(1), new HashMap()};
                            unitParam = new Object[]{new Integer(1), new HashMap(), new boolean[33]};
                            switch(totalGroupingType){
                            case 2:
                                //���P�ʎZ��
                                boolean[] groupingFlags = (boolean[])unitParam[2];
                                if(groupingFlags.length > serviceDayOfMonth){
                                    //���Y�T�[�r�X�񋟓��̃t���O��true�ɂ��Ă����B
                                    groupingFlags[serviceDayOfMonth] = true;
                                }
                                break;
                            }
                            // [ID:0000485][Tozo TANAKA] 2009/04/15 replace end
                        }
                        //����%���Z�R�[�h�ɂ����āA���Y��{�P�ʃR�[�h���ΏۂƂȂ����񐔂��X�V����B
                        simpleUnits.put(simpleServiceCodeItem, unitParam);
                        
                        //����Ɂu�n��n%���Z�v�ł����邩���m�F����B
                        if(CareServiceCommon.isAddPercentageForAreaTarget(code)){
                            //�n��n���Z�T�[�r�X�R�[�h(���ʒn��A���R�ԓ����K��)�̏ꍇ
                            //(6)�֘A�t����ׂ��u%���Z(�Ώۂɒn��n���Z���܂�)�v���X�g�b�N����Ă��邩���m�F����B
                            obj = forAreaCodes.get(simpleServiceCodeItem);
                            if (obj instanceof Object[]) {
                                Object[] forAreaCodeParam = (Object[]) obj;
                                if ((forAreaCodeParam.length >= 2)
                                        && (forAreaCodeParam[1] instanceof Map)) {
                                    //(7)�u%���Z(�Ώۂɒn��n���Z���܂�)�v���ΏۂƂ��ׂ��u�n��n%���Z�v�̃T�[�r�X�R�[�h�ƒ񋟉񐔂�~�ς���B
                                    //�u%���Z(�Ώۂɒn��n���Z���܂�)�v�̑Ώ�
                                    
                                    // ����P�ʁ{�n�擙���Z��Ώۂɂ���%���Z���w�肳��Ă���ꍇ
                                    // ����P�ʁ{�n�擙���Z��Ώۂɂ���%���Z�ɑ΂��A�Ή�����n��n���Z�̎w��񐔂�~�ς���B
                                    Map forAreaTargetCodes = (Map) forAreaCodeParam[1];
                                    Object[] forAreaTargetCodeParam;
                                    //�n��n%���ZSERVICE_CODE_ITEM : {�R�[�h,��}
                                    obj = forAreaTargetCodes
                                            .get(addServiceCodeItem);
                                    if (obj instanceof Object[]) {
                                        forAreaTargetCodeParam = (Object[])obj;

                                        // [ID:0000485][Tozo TANAKA] 2009/04/16 replace begin ���p�[�E�ʕ\�ɂ����Ē��R�Ԓn����Z���ΏۂƂ���P�ʂ̏W�����敪�l��
                                        //forAreaTargetCodeParam[1] = new Integer(((Integer) forAreaTargetCodeParam[1]).intValue() + 1);
                                        boolean canCountUp = true;
                                        switch(totalGroupingType){
                                        case 2:
                                            //���P�ʎZ��
                                            boolean[] groupingFlags = (boolean[])forAreaTargetCodeParam[2];
                                            if(groupingFlags.length > serviceDayOfMonth){
                                                if(groupingFlags[serviceDayOfMonth]){
                                                    //���Y�T�[�r�X�񋟓��̃t���O��true�Ȃ�΁A�����񋟍ς݂Ȃ̂ŃJ�E���g�A�b�v��������continue����B
                                                    canCountUp = false;
                                                }else{
                                                    //���Y�T�[�r�X�񋟓��̃t���O��true�ɂ���B
                                                    groupingFlags[serviceDayOfMonth] = true;
                                                }
                                            }
                                            break;
                                        case 3:
                                            //���P�ʎZ��
                                            //���P�ʂŊ��o�Ƃ������Ƃ̓J�E���g�A�b�v��������continue����B
                                            canCountUp = false;
                                            break;
                                        }
                                        if(canCountUp){
                                            forAreaTargetCodeParam[1] = new Integer(((Integer) forAreaTargetCodeParam[1]).intValue() + 1);
                                        }
                                        // [ID:0000485][Tozo TANAKA] 2009/04/16 replace end
                                    } else {
                                        
                                        // [ID:0000485][Tozo TANAKA] 2009/04/16 replace begin ���p�[�E�ʕ\�ɂ����Ē��R�Ԓn����Z���ΏۂƂ���P�ʂ̏W�����敪�l��
                                        //forAreaTargetCodeParam = new Object[]{code, new Integer(1)};
                                        forAreaTargetCodeParam = new Object[]{code, new Integer(1), new boolean[33]};
                                        switch(totalGroupingType){
                                        case 2:
                                            //���P�ʎZ��
                                            boolean[] groupingFlags = (boolean[])forAreaTargetCodeParam[2];
                                            if(groupingFlags.length > serviceDayOfMonth){
                                                //���Y�T�[�r�X�񋟓��̃t���O��true�ɂ��Ă����B
                                                groupingFlags[serviceDayOfMonth] = true;
                                            }
                                            break;
                                        }
                                        // [ID:0000485][Tozo TANAKA] 2009/04/16 replace end
                                        forAreaTargetCodes.put(addServiceCodeItem, forAreaTargetCodeParam);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            // [ID:0000444][Tozo TANAKA] 2009/03/18 add end
            
        }
        
        /**
         * �ʕ\�p�ɉ�͂��܂��B
         * 
         * @param services �T�[�r�X
         * @param totalGroupingCache ��/���P�ʎZ��L���V��
         * @param code �T�[�r�X�R�[�h
         * @param calcurateUnit �����܂ł̌v�Z�P�ʐ�
         * @return ���Y�T�[�r�X�R�[�h���Z��̒P�ʐ�
         * @throws Exception ������O
         */
        protected int parseSub(VRMap service, Map[] totalGroupingCache,
                Map code, int calcurateUnit) throws Exception {

            // === �����胍�W�b�N�ύX�ɔ����폜
//            // 2008/06/19 [Masahiko Higuchi] add - begin ��z��V�T�[�r�X�����Ή�
//            // ��͌�̃T�[�r�X�ƌ���Map�̓��������
//            if (QkanValidServiceManager.getInstance().containsAnalyzeKey(
//                    service, "ORIGINAL")) {
//                // ��͂��s���Ă��菮�����[�U�[���ݒ肵���f�[�^�͉�͑ΏۊO�ɂ���B
//                return calcurateUnit;
//            }
//            // 2008/06/19 [Masahiko Higuchi] add - end
            
            Object key = code.get("SERVICE_CODE_ITEM");
            if (key == null) {
                key = "";
            }
            Object val = subParseMap.get(key);
            DivedServiceItem page;
            // �T�[�r�X���e�ŕ���
            if (val instanceof DivedServiceItem) {
                //���o
                if(CareServiceCommon.isAddPercentage(code)){
                    // [ID:0000734][Masahiko.Higuchi] 2012/04 ���n���Z��30�����Ή� edit begin
                    // 30�����̏ꍇ�̓X�L�b�v����������
                    if(!CareServiceCommon.is30DayOver(service)) {
                        //%���Z��1�񂾂��v�シ��̂ŃX�L�b�v
                        return calcurateUnit;
                    }
                    // [ID:0000734][Masahiko.Higuchi] 2012/04 edit end
                }                
                page = (DivedServiceItem) val;
            } else {
                //�V�K
                page = new DivedServiceItem();
                subParseMap.put(key, page);
                // [ID:0000734][Masahiko.Higuchi] 2012/04 ����24�N4���@�����Ή� add begin
                // �������P���Z��ޔ�
                if(CareServiceCommon.isAddPercentageForSyogu(code)) {
                    syoguMap.put(key, page);
                }
                // [ID:0000734][Masahiko.Higuchi] 2012/04 add end
            }

            if (CareServiceCommon.isInLimitAmount(code)) {
                //���t�Ǘ����x�z�Ώۂ̃R�[�h�̏ꍇ
                //30�����Ƃ���ȊO����ʂ��A���t�Ǘ����x�z�Ώۂ̍��ڐ����d���Ȃ��v�Z����B
                String hadImteSetKey = ACCastUtilities.toString(key);
                if(CareServiceCommon.is30DayOver(service)){
                    //30�����Ȃ�΃L�[��A�����ĕʂ̃R�[�h�Ƃ݂Ȃ��B
                    hadImteSetKey = hadImteSetKey+"&30";
                    if(!hadItemSet.contains(hadImteSetKey)){
                        //�V�K�ȍ��ڂł����30�����̋��t�Ǘ����x�z�Ώۂ̍��ڐ������Z����B
                        hadItemSet.add(hadImteSetKey);
                        limitAmoutSizeOver30++;
                    }
                }else{
                    // 2008/01/07 [Masahiko Higuchi] edit - begin ��z��V�T�[�r�X�����Ή�
                    // === �����胍�W�b�N�ύX�ɔ����A�����ύX ===
                    //if(!hadItemSet.contains(hadImteSetKey) && isSubParseCustom(service)){
                    if(!hadItemSet.contains(hadImteSetKey)){
                    // 2008/01/07 [Masahiko Higuchi] edit - end
                        //�V�K�ȍ��ڂł���΋��t�Ǘ����x�z�Ώۂ̍��ڐ������Z����B
                        hadItemSet.add(hadImteSetKey);
                        limitAmoutSize++;
                    }
                }
            } else {
                // [ID:0000734][Masahiko.Higuchi] 2012/04 30�����������P���Z�Ή� add begin
                String hadImteSetKey = ACCastUtilities.toString(key);
                if(CareServiceCommon.is30DayOver(service) && CareServiceCommon.isAddPercentageForSyogu(code)){
                    //30�����Ȃ�΃L�[��A�����ĕʂ̃R�[�h�Ƃ݂Ȃ��B
                    hadImteSetKey = hadImteSetKey+"&30";
                    if(!hadItemSet.contains(hadImteSetKey)){
                        //�V�K�ȍ��ڂł����30�����̋��t�Ǘ����x�z�Ώۂ̍��ڐ������Z����B
                        hadItemSet.add(hadImteSetKey);
                        limitAmoutSizeOver30++;
                    }
                }
                // [ID:0000734][Masahiko.Higuchi] 2012/04 add end
            }

            // ����T�[�r�X���e���ŕ���
            return page.parseSub(service, code, totalGroupingCache,
                    calcurateUnit, reductRate);
        }
        
        public String toString() {
            StringBuilder sb = new StringBuilder();
            Iterator it = subParseMap.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry ent = (Map.Entry) it.next();
                sb.append("���������T�[�r�X���e�F");
                sb.append(ent.getKey());
                sb.append(ACConstants.LINE_SEPARATOR);
                sb.append(ent.getValue());
            }
            sb.append(ACConstants.LINE_SEPARATOR);
            sb.append("�����������T�[�r�X�R�[�h�F");
            sb.append(codes);
            return sb.toString();
        }

    }

    /**
     * �T�[�r�X�񋟎��ԒP�ʂŐ؂�ւ��y�[�W�f�[�^�ł��B
     * <p>
     * Copyright (c) 2005 Nippon Computer Corpration. All Rights Reserved.
     * </p>
     * 
     * @author Tozo Tanaka
     * @version 1.0 2006/02/15
     */
    protected class DivedServiceTime extends TreeMap {
        
        /**
         * �V�K�ɃT�[�r�X��ǉ����܂��B
         * 
         * @param service �T�[�r�X
         * @throws Exception ������O
         */
        public void parseMainTable(VRMap service) throws Exception {
            Object key = service.get("PROVIDER_ID");
            if (key == null) {
                key = "";
            }
            
            // 2008/01/07 [Masahiko Higuchi] edit - begin ��z��V�T�[�r�X�����Ή�
            if(isParseCustom(service)){
            // 2008/01/07 [Masahiko Higuchi] edit - end
            
                Object val = DivedServiceTime.this.get(key);
                DivedProvider page;
                // ���Ə��ԍ��ŕ���
                if (val instanceof DivedProvider) {
                    page = (DivedProvider) val;
                } else {
                    page = new DivedProvider();
                    DivedServiceTime.this.put(key, page);
                }
                // ���ꎖ�Ə��ԍ����ŕ���
                page.parseMainTable(service, ACCastUtilities.toString(key));
                
            }

        }

      /**
      * ���p�[�{�\���\�z���܂��B
      * 
         * @param buildParam �󎚓��e�W��
         * @return ���̏o�͑Ώۍs
      * @throws Exception ������O
      */
     public int buildUserMainTable(CareServicePrintParameter buildParam) throws Exception {
         Iterator it = DivedServiceTime.this.entrySet().iterator();
         while (it.hasNext()) {
             Map.Entry ent = (Map.Entry) it.next();
             DivedProvider services = (DivedProvider) ent.getValue();

             // ���ʏ��\�z
             buildParam.setCurrentRow(services
                     .buildUserMainTable(buildParam));
         }
         return buildParam.getCurrentRow();
     }

        /**
         * 1�߂̃T�[�r�X����Ԃ��܂��B
         * 
         * @return 1�߂̃T�[�r�X���
         */
        public VRMap getFirstService() {
            if (DivedServiceTime.this.size() > 0) {
                Iterator it = DivedServiceTime.this.values().iterator();
                while (it.hasNext()) {
                    VRMap result = ((DivedProvider) it.next())
                            .getMainFormatFirstService();
                    if (result != null) {
                        return result;
                    }
                }
            }
            return null;
        }
                
        public String toString() {
            StringBuilder sb = new StringBuilder();
            Iterator it = DivedServiceTime.this.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry ent = (Map.Entry) it.next();
                sb.append("�����������T�[�r�X�񋟎����F");
                sb.append(ent.getKey());
                sb.append(ACConstants.LINE_SEPARATOR);
                sb.append(ent.getValue());
            }
            return sb.toString();
        }
    }

    /**
     * �T�[�r�X�P�ʂŐ؂�ւ��y�[�W�f�[�^�ł��B
     * <p>
     * Copyright (c) 2005 Nippon Computer Corpration. All Rights Reserved.
     * </p>
     * 
     * @author Tozo Tanaka
     * @version 1.0 2006/02/15
     */
    protected class DivedServiceUnit extends ArrayList {
        private Map code;

        /**
         * ���p�[�ʕ\���\�z���܂��B
         * <p>
         * ���v���܂܂Ȃ����׍s���\�z���܂��B
         * </p>
         * 
         * @param buildParam �󎚓��e�W��
         * @param provider ���Ə�
         * @param unit �P��
         * @param totals �W�v���
         * @param isOver30Days 30����
         * @throws Exception ������O
         */
        public void buildUserSubTableDetailRow(CareServicePrintParameter buildParam,
                Map provider, int unit, int[] totals, boolean isOver30Days) throws Exception {
            // ���Ə������\�z
            String providerID = buildUserSubTableProviderFields(buildParam,
                    provider);
            buildUserSubTableDetailFields(buildParam, unit, totals, providerID, isOver30Days);
        }

        /**
         * ���p�[�ʕ\���\�z���܂��B
         * <p>
         * ���v���܂ޖ��׍s���\�z���܂��B
         * </p>
         * 
         * @param buildParam �󎚓��e�W��
         * @param provider ���Ə�
         * @param insureRate �ی����t��
         * @param unit �P��
         * @param totals �W�v���
         * @param addHesesOnName ���ʂ�t���ĕ\�����邩
         * @param outOfLimitAmount ���t�Ǘ����x�z�ΏۊO��
         * @throws Exception ������O
         */
        public void buildUserSubTableTotalDetailRow(CareServicePrintParameter buildParam,
                Map provider, int insureRate, int unit, int[] totals,
                boolean addHesesOnName, boolean outOfLimitAmount, boolean isOver30Days)
                throws Exception {

            // ���Ə������\�z
            String providerID = buildUserSubTableProviderFields(buildParam,
                    provider);
            // ���ח���\�z
            buildUserSubTableDetailFields(buildParam, unit, totals, providerID,isOver30Days);

            if (outOfLimitAmount) {
                // ���t�Ǘ��ΏۊO�ȂǂŎ�����𖳎�����ꍇ
                totals[INDEX_OF_LIMIT_OVER_UNIT_FOR_DETAIL] = 0;
            }
            // ���v����\�z
            buildUserSubTableTotalFields(buildParam, provider, insureRate,
                    totals, addHesesOnName, isOver30Days);

            // �T�[�r�X�P��/���z
            String unitText = String
                    .valueOf(totals[INDEX_OF_SERVICE_UNIT_FOR_DETAIL]);
            if (addHesesOnName) {
                unitText = "(" + unitText + ")";
            }
            printCell(buildParam, 9, unitText, isOver30Days);
            totals[INDEX_OF_SERVICE_UNIT_FOR_DETAIL] = 0;
        }

        /**
         * ���p�[�ʕ\���\�z���܂��B
         * <p>
         * ���v�s���\�z���܂��B
         * </p>
         * 
         * @param buildParam �󎚓��e�W��
         * @param provider ���Ə�
         * @param insureRate �ی����t��
         * @param unit �P��
         * @param totals �W�v���
         * @param isOver30Days 30����
         * @throws Exception ������O
         */
        public void buildUserSubTableTotalRow(CareServicePrintParameter buildParam,
                Map provider, int insureRate, int[] totals, boolean isOver30Days) throws Exception {
            // ���Ə������\�z
            buildUserSubTableProviderFields(buildParam, provider);

            String serviceName = getCalcurater().getServiceKindName(
                    getFirstService())
                    + "�v";
            if(isOver30Days){
                serviceName = "30����"+ serviceName;
            }
            // �T�[�r�X���e/���
            buildParam.getTargetPage()
                    .put(
                            "main.y" + buildParam.getCurrentRow() + ".x3",
                            serviceName);

            // �T�[�r�X�P��/���z
            printCell(buildParam, 9, "(" + totals[INDEX_OF_SERVICE_UNIT_FOR_DETAIL] + ")", isOver30Days);

            // ���v��
            buildUserSubTableTotalFields(buildParam, provider, insureRate,
                    totals, true, isOver30Days);

            totals[INDEX_OF_SERVICE_UNIT_FOR_DETAIL] = 0;
        }

        /**
         * 1�߂̃T�[�r�X����Ԃ��܂��B
         * 
         * @return 1�߂̃T�[�r�X���
         */
        public VRMap getFirstService() {
            if (!DivedServiceUnit.this.isEmpty()) {
                return (VRMap) DivedServiceUnit.this.get(0);
            }
            return null;
        }

        /**
         * �T�[�r�X����͂��܂��B
         * 
         * @param service �T�[�r�X
         * @param code �T�[�r�X�R�[�h
         */
        public void parse(VRMap service, Map code) {
            DivedServiceUnit.this.add(service);
            this.code = code;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            Iterator it = DivedServiceUnit.this.iterator();
            while (it.hasNext()) {
                Map.Entry ent = (Map.Entry) it.next();
                sb.append("�������������T�[�r�X�P�ʐ��F");
                sb.append(ent.getKey());
                sb.append(ACConstants.LINE_SEPARATOR);
                sb.append("���������������T�[�r�X�F");
                sb.append(ent.getValue());
            }
            return sb.toString();
        }

        /**
         * ���p�[�ʕ\���\�z���܂��B
         * <p>
         * ���ח���\�z���܂��B
         * </p>
         * 
         * @param buildParam �󎚓��e�W��
         * @param unit �P��
         * @param totals �W�v���
         * @param providerID ���Ə�ID
         * @throws Exception ������O
         */
        protected void buildUserSubTableDetailFields(CareServicePrintParameter buildParam,
                int unit, int[] totals, String providerID, boolean isOver30Days) throws Exception {

            if (code != null) {
                String serviceName = ACCastUtilities.toString(code.get("SERVICE_NAME")); 
                if(isOver30Days){
                    //30�����Ȃ疼�̂�30����������
                    serviceName = "30����" + serviceName;
                }
                // 2016/7/30 [CCCX:2865][Yoichiro Kamei] add - begin
                // �W�v���ׂ�ʕ\�̃f�[�^�����Ƃɏo�͂��邽�߂ɃT�[�r�X��ނ�ǉ�
                // �T�[�r�X���
                String skind = ACTextUtilities.trim(ACCastUtilities.toString(code
                        .get("SYSTEM_SERVICE_KIND_DETAIL")));
                buildParam.getTargetPage().put(
                        "main.y" + buildParam.getCurrentRow() + ".skind",
                        skind);
                // 2016/7/30 [CCCX:2865] add - end
                
                // �T�[�r�X���e/���
                buildParam.getTargetPage().put(
                        "main.y" + buildParam.getCurrentRow() + ".x3",
                        serviceName);
                // �T�[�r�X�R�[�h
                printCell(buildParam, 4, getCalcurater().getTextOfServiceCode(code), isOver30Days);
                // �P��
                printCell(buildParam, 5, ACCastUtilities.toString(unit), isOver30Days);

                int reducted = unit;
                int reductRate = getCalcurater()
                        .getReductRate(providerID, code);
                if (reductRate < 100){
                    //��������Ă���ꍇ
                    if(!CareServiceCommon.isAddPercentage(code)) {
                        //%���Z(���n���Z)�ł͂Ȃ��ꍇ
                        if(CareServiceCommon.isAddSpecialAreaOfWelfareEquipment(code)){
                            //�����p��ݗ^�̓��n���Z�̏ꍇ�́A������P�ʂ�P�ʐ��ɋL��
                            reducted = getCalcurater().toReductedUnit(unit, reductRate);
                            printCell(buildParam, 5, new Integer(reducted), isOver30Days);
                        }else{
                            // ������
                            printCell(buildParam, 6, new Integer(reductRate), isOver30Days);
                            reducted = getCalcurater().toReductedUnit(unit, reductRate);
                            //������P�ʐ�
                            printCell(buildParam, 7, new Integer(reducted), isOver30Days);
                        }
                    }
                }

                // ��
                int count = DivedServiceUnit.this.size();
                // [ID:0000734][Masahiko.Higuchi] 2012/04 30�����������P���Z�Ή� del begin
                //if(CareServiceCommon.isCountPrintableServiceCode(code)){
                // [ID:0000734][Masahiko.Higuchi] 2012/04 30�����������P���Z�Ή� del end
                // [ID:0000734][Masahiko.Higuchi] 2012/04 30�����������P���Z�Ή� add begin
                // 30�����������P���Z���l�����ăt���O��TRUE�Ȃ�񐔂��󎚂���
                if(CareServiceCommon.isCountPrintableServiceCode(code) || isOver30Days){
                // [ID:0000734][Masahiko.Higuchi] 2012/04 30�����������P���Z�Ή� add end
                    buildParam.getTargetPage().put(
                        "main.y" + buildParam.getCurrentRow() + ".x8",
                        new Integer(count));
                }

                // �T�[�r�X�P��/���z
                int reducedCost = reducted * count;
                printCell(buildParam, 9, new Integer(reducedCost), isOver30Days);

                if(isOver30Days){
                    //30�����͕ی����t�P�ʐ��ɂ͍��Z�����S�z����Ƃ��Čv��
                    totals[INDEX_OF_USER_COST_ON_30OVER] += reducedCost;
                }else{
                    totals[INDEX_OF_SERVICE_UNIT_FOR_DETAIL] += reducedCost;
                    totals[INDEX_OF_SERVICE_UNIT] += reducedCost;
                }
                
            }

        }
        /**
         * 30�������l�����ăZ���̒l���󎚂��܂��B
         * @param buildParam �󎚓��e�W��
         * @param x �Z��X�ʒu
         * @param value �󎚒l
         * @param is30OverDays 30����(�󎚑ΏۊO)�ł��邩
         */
        protected void printCell(CareServicePrintParameter buildParam, int x, Object value, boolean is30OverDays){
            if(!is30OverDays){
                buildParam.getTargetPage().put(
                        "main.y" + buildParam.getCurrentRow() + ".x" + x,
                        value);
            }
        }

        /**
         * ���p�[�ʕ\���\�z���܂��B
         * <p>
         * ���Ə�������\�z���܂��B
         * </p>
         * 
         * @param buildParam �󎚓��e�W��
         * @param provider ���Ə�
         * @return ���Ə�ID
         * @throws Exception ������O
         */
        protected String buildUserSubTableProviderFields(CareServicePrintParameter buildParam,
                Map provider) throws Exception {
            if (provider == null) {
                return "";
            }
            String providerID = ACCastUtilities.toString(provider
                    .get("PROVIDER_ID"));
            // ���Ə���
            buildParam.getTargetPage().put(
                    "main.y" + buildParam.getCurrentRow() + ".x1",
                    provider.get("PROVIDER_NAME"));
            // ���Ə��ԍ�
            buildParam.getTargetPage().put(
                    "main.y" + buildParam.getCurrentRow() + ".x2", providerID);
            return providerID;
        }

        /**
         * ���p�[�ʕ\���\�z���܂��B
         * <p>
         * ���v����\�z���܂��B
         * </p>
         * 
         * @param buildParam �󎚓��e�W��
         * @param provider ���Ə�
         * @param insureRate �ی����t��
         * @param totals �W�v���
         * @param addHesesOnUnit �敪�x�����x����P�ʐ������ʂŊ��邩
         * @throws Exception ������O
         */
        protected void buildUserSubTableTotalFields(CareServicePrintParameter buildParam,
                Map provider, int insureRate, int[] totals,
                boolean addHesesOnUnit, boolean isOver30Days) throws Exception {

            if (code != null) {
                // 2016/7/30 [CCCX:2865][Yoichiro Kamei] add - begin
                // �W�v���ׂ�ʕ\�̃f�[�^�����Ƃɏo�͂��邽�߂ɃT�[�r�X��ނ�ǉ�
                // �T�[�r�X���
                String skind = ACTextUtilities.trim(ACCastUtilities.toString(code
                        .get("SYSTEM_SERVICE_KIND_DETAIL")));
                buildParam.getTargetPage().put(
                        "main.y" + buildParam.getCurrentRow() + ".skind",
                        skind);
                // 2016/7/30 [CCCX:2865] add - end
                
                // �敪�x�����x��𒴂���P�ʐ�
                int overUnit = totals[INDEX_OF_LIMIT_OVER_UNIT_FOR_DETAIL];

                // [ID:0000764][Masahiko.Higuchi] add - begin 30�����T�[�r�X�̈󎚏�Q
                if(isOver30Days) {
                    //30�����̏ꍇ�͒��ߒP�ʐ�������������
                    overUnit = 0;
                }
                // [ID:0000764][Masahiko.Higuchi] add - end
                
                // �敪�x�����x����P�ʐ�
                int totalUnit = totals[INDEX_OF_SERVICE_UNIT_FOR_DETAIL]
                        - overUnit;
                String totalUnitText = String.valueOf(totalUnit);
                if (addHesesOnUnit) {
                    totalUnitText = "(" + totalUnitText + ")";
                }
                printCell(buildParam, 13, totalUnitText, isOver30Days);

                totals[INDEX_OF_LIMIT_IN_UNIT] += totalUnit;

                // �P�ʐ��P��
                Object serviceKind = code.get("SYSTEM_SERVICE_KIND_DETAIL");
                double unitPrice = getCalcurater().getUnitPrice(serviceKind,
                        provider);
                buildParam.getTargetPage().put(
                        "main.y" + buildParam.getCurrentRow() + ".x14",
                        getCalcurater().getTextOfUnitPrice(unitPrice));

                // 2008/09/03 [Masahiko Higuchi] add - begin �S�z���ȕ��S�v�Z����Q�iV5.4.3�j
                // �����ۂߌv�Z�����������̂Ő����Ɠ��l�̌v�Z���ɕύX����
                BigDecimal bigDeci = new BigDecimal(String.valueOf(unitPrice));
                bigDeci = bigDeci.multiply(new BigDecimal("100"));
                // 2008/09/03 [Masahiko Higuchi] add - end
                
                // ��p���z
                // �؎̂�
                // [ID:0000441][Masahiko Higuchi] del begin ��p���z�̊ۂߌv�Z��Q�Ή�
                //int cost = (int) Math.floor(unitPrice * totalUnit);
                // [ID:0000441][Masahiko Higuchi] del end
                // [ID:0000441][Masahiko Higuchi] add begin ��p���z�̊ۂߌv�Z��Q�Ή�
                int cost = (int) Math.floor((double) ((totalUnit * bigDeci
                        .intValue()) / 100d));
                // [ID:0000441][Masahiko Higuchi] add end
                printCell(buildParam, 15, new Integer(cost), isOver30Days);
                totals[INDEX_OF_TOTAL_COST] += cost;

                // ���t��
                insureRate = getCalcurater().checkPublicExpense(insureRate,
                        serviceKind, provider);
                printCell(buildParam, 16, new Integer(insureRate), isOver30Days);

                // �ی����t�z(�؎̂�)
                int insureCost = (int) Math.floor(cost * insureRate / 100.0);
                printCell(buildParam, 17, new Integer(insureCost), isOver30Days);
                totals[INDEX_OF_INSURE_COST] += insureCost;

                // ���p�ҕ��S�i�ی��Ώە��j
                int userCost = cost - insureCost;
                printCell(buildParam, 18, new Integer(userCost), isOver30Days);
                totals[INDEX_OF_USER_COST_ON_INSURE] += userCost;

                // [ID:0000441][Masahiko Higuchi] del begin ��p���z�̊ۂߌv�Z��Q�Ή�
                // 2008/09/03 [Masahiko Higuchi] add - begin �S�z���ȕ��S�v�Z����Q�iV5.4.3�j
                // �����ۂߌv�Z�����������̂Ő����Ɠ��l�̌v�Z���ɕύX����
                // BigDecimal bigDeci = new BigDecimal(String.valueOf(unitPrice));
                // bigDeci = bigDeci.multiply(new BigDecimal("100"));
                // 2008/09/03 [Masahiko Higuchi] add - end
                // [ID:0000441][Masahiko Higuchi] del end
                
                int overCost = 0;
                // [ID:0000764][Masahiko.Higuchi] del - begin�@30�����T�[�r�X�̈󎚏�Q
                // [ID:0000734][Masahiko.Higuchi] 2012/04 30�����������P���Z�Ή� add begin
                //if(isOver30Days) {
                //    //30�����̏ꍇ�͒��ߒP�ʐ�������������
                //    overUnit = 0;
                //}
                // [ID:0000734][Masahiko.Higuchi] 2012/04 30�����������P���Z�Ή� add end
                // [ID:0000764][Masahiko.Higuchi] del - end
                if (overUnit > 0) {

                    // �敪�x�����x��𒴂���P�ʐ����ݒ肳��Ă���Ƃ�
                    printCell(buildParam, 12, new Integer(overUnit), isOver30Days);

                    // 2008/09/03 [Masahiko Higuchi] del - begin �S�z���ȕ��S�v�Z����Q�iV5.4.3�j
                    // �T�[�r�X�v���p���z=�v��P�ʐ�*�P�ʐ��P��
                    //int planCost = (int) Math.floor((overUnit + totalUnit)
                    //* unitPrice);
                    // ���p�ҕ��S�i�S�z���S���j=�T�[�r�X�v���p���z-��p���z�i�ی��Ώە��j
                    //overCost += planCost - cost;
                    // 2008/09/03 [Masahiko Higuchi] del - end
                    // 2008/09/03 [Masahiko Higuchi] add - begin �S�z���ȕ��S�v�Z����Q�iV5.4.3�j
                    // 30�����łȂ��ꍇ�̂ݒʂ邩��30�����̒l�����Z����邱�Ƃ͂Ȃ��B
                    overCost = (int) Math.floor((double) ((overUnit * bigDeci
                            .intValue()) / 100d));
                    // 2008/09/03 [Masahiko Higuchi] add - end
                    // ���v�����N���A
                    totals[INDEX_OF_LIMIT_OVER_UNIT_FOR_DETAIL] = 0;
                }
                // 2008/09/03 [Masahiko Higuchi] del - begin �S�z���ȕ��S�v�Z����Q�iV5.4.3�j
                //overCost += (int) Math.floor(totals[INDEX_OF_USER_COST_ON_30OVER]*unitPrice);
                // 2008/09/03 [Masahiko Higuchi] del - end
                // 2008/09/03 [Masahiko Higuchi] add - begin �S�z���ȕ��S�v�Z����Q�iV5.4.3�j
                // �ۂߌv�Z�̖��ɑΉ�
                overCost += (int) Math
                        .floor((double) ((totals[INDEX_OF_USER_COST_ON_30OVER] * bigDeci
                                .intValue()) / 100d));
                // �O�̂��ߖ����I�ɊJ������
                bigDeci = null;
                // 2008/09/03 [Masahiko Higuchi] add - end
                if(overCost>0){
                    //// ���p�ҕ��S�i�S�z���S���j
                    buildParam.getTargetPage().put(
                        "main.y" + buildParam.getCurrentRow() + ".x19",
                        new Integer(overCost));
                    totals[INDEX_OF_USER_COST_ON_FULL] += overCost;
                    totals[INDEX_OF_USER_COST_ON_30OVER] = 0;
                }
            }

        }

    }
    
    // [2014�N�v�]][Shinobu Hitaka] 2014/10/23 add begin �h�̕\��
    /**
     * ��ی��Җ��̌h�̂�ݒ肵�܂��B
     * 
     * @param printKeisyo �h�́i�l�A�a�@�Ȃǁj
     */
    public void setPrintKeisyo(String printKeisyo) {
        this.printKeisyo = printKeisyo;
    }
    // [2014�N�v�]][Shinobu Hitaka] 2014/10/23 add end �h�̕\��

}
