package jp.nichicom.ac.lib.care.claim.print.schedule;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import jp.nichicom.ac.ACConstants;
import jp.nichicom.ac.bind.ACBindUtilities;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.lib.care.claim.servicecode.CareServiceCommon;
import jp.nichicom.ac.lib.care.claim.servicecode.Qkan10011_ServiceCodeManager;
import jp.nichicom.ac.lib.care.claim.servicecode.Qkan10011_ServiceUnitGetter;
import jp.nichicom.ac.lib.care.claim.servicecode.QkanValidServiceCommon;
import jp.nichicom.ac.sql.ACDBManager;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.ac.util.ACDateUtilities;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.text.parsers.VRDateParser;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.nichicom.vr.util.logging.VRLogger;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.QkanConstants;
import jp.or.med.orca.qkan.text.QkanServiceAbbreviationFormat;

/**
 * �T�[�r�X�P�ʌv�Z�N���X�ł��B
 * <p>
 * Copyright (c) 2005 Nippon Computer Corpration. All Rights Reserved.
 * </p>
 * 
 * @author Tozo Tanaka
 * @version 1.0 2006/02/21
 */
public class CareServiceCodeCalcurater {

    /**
     * ���t�Ǘ��Ώۂ�\���v�Z���[�h�萔�ł��B
     */
    public static final int CALC_MODE_IN_LIMIT_AMOUNT = 1;

    /**
     * ���t�Ǘ��ΏۊO��\���v�Z���[�h�萔�ł��B
     */
    public static final int CALC_MODE_OUT_LIMIT_AMOUNT = 2;

    /**
     * �O�����p�^��\���v�Z���[�h�萔�ł��B
     */
    public static final int CALC_MODE_OUTER_SERVICE_LIMIT_AMOUNT = 3;

    /**
     * ���t�Ǘ��Ώۂ������͊O�����p�^��\���v�Z���[�h�萔�ł��B
     */
    public static final int CALC_MODE_IN_LIMIT_AMOUNT_OR_OUTER_SERVICE = 4;

    /**
     * �����Ȃ���\���v�Z���[�h�萔�ł��B
     */
    public static final int CALC_MODE_FREE = 0;

    private boolean calcWithPublicExpense;

    private ACDBManager dbm;

    private VRMap hashedAreaUnitPrices;

    private VRMap hashedProviders;

    private Map hashedProviderServices = new HashMap();

    private VRMap hashedServiceKinds;

    private int inSpecialFacilityFlag;

    private int patientID;

    private VRMap patientInfo;

    private VRList patientInsureInfoHistoryList;

    private HashMap publicExpenseMap = new HashMap();

    private VRList serviceKindsList;

    private Date targetDate;

    private final DecimalFormat UNIT_PRICE_FORMAT = new DecimalFormat("##.00");

    private boolean oncePerMonthOfAddEmergencyNursingAndSpecialManagement = true;

    /**
     * �Ώۂ̗��p�҂����[�u�����҂ł��邩������킷�t���O ��Ԃ��܂��B
     * 
     * @return �Ώۂ̗��p�҂����[�u������
     */
    public int getOldFacilityUserFlag() {
        return oldFacilityUserFlag;
    }

    /**
     * �Ώۂ̗��p�҂����[�u�����҂ł��邩������킷�t���O ��ݒ肵�܂��B
     * 
     * @param oldFacilityUserFlag �Ώۂ̗��p�҂����[�u�����҂ł��邩������킷�t���O
     */
    public void setOldFacilityUserFlag(int oldFacilityUserFlag) {
        this.oldFacilityUserFlag = oldFacilityUserFlag;
    }

    /**
     * �ً}���K��Ō���Z�E���ʊǗ����Z�͌�1��Z��Ƃ��邩 ��Ԃ��܂��B
     * <p>
     * �f�t�H���g��true�ł��B
     * </p>
     * 
     * @return �ً}���K��Ō���Z�E���ʊǗ����Z�͌�1��Z��Ƃ��邩
     */
    public boolean isOncePerMonthOfAddEmergencyNursingAndSpecialManagement() {
        return oncePerMonthOfAddEmergencyNursingAndSpecialManagement;
    }

    /**
     * �ً}���K��Ō���Z�E���ʊǗ����Z�͌�1��Z��Ƃ��邩 ��ݒ肵�܂��B
     * <p>
     * �f�t�H���g��true�ł��B
     * </p>
     * 
     * @param oncePerMonthOfAddEmergencyNursingAndSpecialManagement
     *            �ً}���K��Ō���Z�E���ʊǗ����Z�͌�1��Z��Ƃ��邩
     */
    public void setOncePerMonthOfAddEmergencyNursingAndSpecialManagement(
            boolean oncePerMonthOfAddEmergencyNursingAndSpecialManagement) {
        this.oncePerMonthOfAddEmergencyNursingAndSpecialManagement = oncePerMonthOfAddEmergencyNursingAndSpecialManagement;
    }

    /**
     * �R���X�g���N�^�ł��B
     */
    public CareServiceCodeCalcurater() {
        super();
    }

    /**
     * �T�[�r�X�R�[�h�̃}�X�^��Ń��j�[�N�ȃL�[�𕶎���\���ŕԂ��܂��B
     * 
     * @param code �T�[�r�X�R�[�h
     * @param mode �x�����x�z����ΏۂƂ����L���b�V���L�[��
     * @return ���j�[�N�L�[
     * @throws Exception ������O
     */
    // [ID:0000615][Shin Fujihara] 2010/08/18 edit begin
    // public String getServiceCodeUniqueKey(Map code, int mode) throws
    // Exception{
    public String getServiceCodeUniqueKey(Map code, int mode, Map service)
            throws Exception {
        return ACCastUtilities.toString(mode)
                + " "
                + ACCastUtilities.toString(code
                        .get("SYSTEM_SERVICE_KIND_DETAIL"))
                + " "
                + ACCastUtilities
                        .toString(code.get("SYSTEM_SERVICE_CODE_ITEM"))
                + " "
                + ACCastUtilities.toString(service.get("PROVIDER_ID")
                        // [ID:0000734][Masahiko.Higuchi] 2012/04 ����24�N4���@�����Ή� add begin
                        + " "
                        + ACCastUtilities.toString(CareServiceCommon
                                .is30DayOver((VRMap) service))
                        // [ID:0000734][Masahiko.Higuchi] 2012/04 ����24�N4���@�����Ή� add end
                        );

        // + ACCastUtilities.toString(code.get("SERVICE_CODE_KIND")) + " "
        // + ACCastUtilities.toString(code.get("SERVICE_CODE_ITEM"));
    }

    // [ID:0000615][Shin Fujihara] 2010/08/18 edit end
    /**
     * �u�T�[�r�X�P�ʌv�Z�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @param code �T�[�r�X�R�[�h
     * @param mode ���O���[�h
     * @param service �T�[�r�X
     * @param totalGroupingCache ��/���P�ʎZ��L���V��
     * @throws Exception ������O
     * @return int �P�ʐ�
     */
    public int getServiceUnit(Map code, int mode, Map service,
            Map[] totalGroupingCache) throws Exception {
        if (code != null) {

            String group = ACCastUtilities.toString(
                    code.get("TOTAL_GROUPING_TYPE"), "1");
            if (!isOncePerMonthOfAddEmergencyNursingAndSpecialManagement()) {
                // �ً}���K��Ō���Z����ѓ��ʊǗ����Z��1���Z��Ƃ��Ȃ��ꍇ
                if (CareServiceCommon.isAddEmergencyNursing(code)
                        || CareServiceCommon.isAddSpecialManagement(code)) {
                    // �ً}���K��Ō���Z�������͓��ʊǗ����Z�̏ꍇ
                    // ��P�ʂ̎Z��Ƃ���B
                    group = "1";
                }
            }

            if ("2".equals(group)) {
                // ���P��
                if ((totalGroupingCache != null)
                        && (totalGroupingCache.length >= 1)
                        && (totalGroupingCache[0] != null)) {
                    Object date = service.get("SERVICE_DATE");
                    if (date instanceof Date) {
                        // [ID:0000615][Shin Fujihara] 2010/08/18 edit begin
                        // Object key = getServiceCodeUniqueKey(code, mode);
                        Object key = getServiceCodeUniqueKey(code, mode,
                                service);
                        // [ID:0000615][Shin Fujihara] 2010/08/18 edit end
                        Object obj = totalGroupingCache[0].get(key);
                        if (obj instanceof Date) {
                            if (ACDateUtilities.getDifferenceOnDay((Date) obj,
                                    (Date) date) == 0) {
                                // �������o�ɂ��Z�肵�Ȃ�
                                return 0;
                            }
                        }
                        // key:�T�[�r�X�R�[�h�Aval:�񋟓�
                        totalGroupingCache[0].put(key, date);
                    }
                }
            } else if ("3".equals(group)) {
                // ���P��
                if ((totalGroupingCache != null)
                        && (totalGroupingCache.length >= 2)
                        && (totalGroupingCache[1] != null)) {
                    // [ID:0000615][Shin Fujihara] 2010/08/18 edit begin
                    // Object key = getServiceCodeUniqueKey(code, mode);
                    Object key = getServiceCodeUniqueKey(code, mode, service);
                    // [ID:0000615][Shin Fujihara] 2010/08/18 edit end
                    Object obj = totalGroupingCache[1].get(key);
                    if (obj instanceof Date) {
                        // ���o�ɂ��Z�肵�Ȃ�
                        return 0;
                    } else {
                        // key:�T�[�r�X�R�[�h�Aval:�񋟓�
                        totalGroupingCache[1].put(key,
                                service.get("SERVICE_DATE"));
                    }
                }
            }

            // �Ǘ����x�Ώۂ�����킷�萔
            if (!QkanConstants.SERVICE_KIND_LIFE_CARE_AT_SPECIAL_FACILITIY
                    .equals(ACCastUtilities.toString(code
                            .get("SERVICE_CODE_KIND")))) {
                // ����{�ݓ����҂Ɋւ���R�[�h�͏��O

                // ���t�Ǘ����x�z�Ώۃt���O���擾����B
                // 0�F�H��A�P�ʐ��ŊǗ����Ȃ��T�[�r�X
                // 1�F���t�Ǘ����x�z�Ώ�
                // 2�F���t�Ǘ����x�z�ΏۊO

                switch (mode) {
                case CALC_MODE_IN_LIMIT_AMOUNT:
                    // ���t�Ǘ����x�z�ΏۂɌ��肷��ꍇ
                    if (!CareServiceCommon.isInLimitAmount(code)) {
                        // ���t�Ǘ����x�z�Ώۂł͂Ȃ��ꍇ
                        return 0;
                    }
                    break;
                case CALC_MODE_OUT_LIMIT_AMOUNT:
                    // ���t�Ǘ����x�z�ΏۊO�Ɍ��肷��ꍇ
                    if (!CareServiceCommon.isOutLimitAmount(code)) {
                        // ���t�Ǘ����x�z�Ώۂ̏ꍇ
                        return 0;
                    }
                    break;
                case CALC_MODE_OUTER_SERVICE_LIMIT_AMOUNT:
                    // �O�����p�^�Ɍ��肷��ꍇ
                    if (!CareServiceCommon.isOuterServiceLimitAmount(code)) {
                        // ���t�Ǘ����x�z�Ώۂ̏ꍇ
                        return 0;
                    }
                    break;
                case CALC_MODE_IN_LIMIT_AMOUNT_OR_OUTER_SERVICE:
                    // ���t�Ǘ����x�Ώۂ������͊O�����p�^�Ɍ��肷��ꍇ
                    if (!(CareServiceCommon.isInLimitAmount(code) || CareServiceCommon
                            .isOuterServiceLimitAmount(code))) {
                        // ���t�Ǘ����x�z�Ώۂ̏ꍇ
                        return 0;
                    }
                    break;
                }

                // �Ǘ��ΏۃT�[�r�X�R�[�h�Ɍ��肵�Ă��Ȃ����������͋��t�Ǘ����x�z�Ώۂ̃T�[�r�X�R�[�h�̏ꍇ
                // �Y���T�[�r�X�񋟂ɂ�苋�t�����P�ʐ����擾����B
                return ACCastUtilities.toInt(code.get("SERVICE_UNIT"), 0);
            }
        }
        // ���Z��Ԃ��B
        return 0;
    }

    /**
     * �u�T�[�r�X�P�ʌv�Z�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @param codes List �T�[�r�X�R�[�h�W��
     * @param mode �v�Z���[�h
     * @param reductRate ������
     * @param service �T�[�r�X
     * @param totalGroupingCache ��/���P�ʎZ��L���V��
     * @throws Exception ������O
     * @return int
     */
    public int getServiceUnit(List codes, int mode, int reductRate,
            Map service, Map[] totalGroupingCache) throws Exception {
        // ���Z��0�ŏ���������B
        int total = 0;
        // �Ǘ����x�Ώۂ�����킷�萔

        if (codes != null) {
            Iterator it = codes.iterator();
            while (it.hasNext()) {
                // �T�[�r�X�R�[�h�̒P�ʎZ�荀�ڂ�S��������B
                VRMap code = (VRMap) it.next();

                int unit = getServiceUnit(code, mode, service,
                        totalGroupingCache);
                total += getReductedServiceCodeUnit(code, unit, total,
                        reductRate);
            }
        }
        // ���Z��Ԃ��B
        return (int) total;
    }

    /**
     * �T�[�r�X�R�[�h�̉��Z���ʂ�Ԃ��܂��B
     * 
     * @param code �Ώۂ̃T�[�r�X�R�[�h
     * @param codeUnit �ΏۃT�[�r�X�R�[�h�̒P�ʃt�B�[���h�̒l
     * @param total �����܂ł̍��Z
     * @return ���Z��̍��Z
     * @throws Exception ������O
     */
    public int getServiceCodeUnit(Map code, int codeUnit, long total)
            throws Exception {

        if (code != null) {
            // �Y���T�[�r�X�񋟂ɂ�苋�t�����P�ʐ����擾����B

            // �T�[�r�X���Z�t���O���擾����B
            Object add = code.get("SERVICE_ADD_FLAG");

            // �T�[�r�X���Z�t���O���`�F�b�N����B
            switch (ACCastUtilities.toInt(add, 0)) {
            case 1: // 1:�P�ʂ̏ꍇ
            case 2:// 2:�P�ʉ��Z�̏ꍇ
                   // ���Z�ɒP�ʐ������Z����B
                return codeUnit;
            case 3:// 3:�����Z�̏ꍇ
                   // ���Z�ɒP�ʐ�����Z���A100�Ŋ������P�ʐ�%�����Z����B
                return (int) Math.round(total * codeUnit / 100.0);
            case 4:// 4:�P�ʌ��Z�̏ꍇ
                   // ���Z�ɒP�ʐ������Z����B
                   // ���}�X�^��ɕ��̒l�Ŋi�[����Ă���
                return codeUnit;
            case 5:// 5:�����Z�̏ꍇ
                   // ���Z�ɒP�ʐ�����Z���A100�Ŋ������P�ʐ�%�����Z����B
                return (int) -Math.round(total * codeUnit / 100.0);
            case 9:// 9:�~�̏ꍇ
                   // �~�̉��Z�͔F�߂Ȃ�
                return 0;
            }
        }
        return codeUnit;
    }

    /**
     * �T�[�r�X�R�[�h�̉��Z���ʂɊ������������ĕԂ��܂��B
     * 
     * @param code �Ώۂ̃T�[�r�X�R�[�h
     * @param codeUnit �ΏۃT�[�r�X�R�[�h�̒P�ʃt�B�[���h�̒l
     * @param total �����܂ł̍��Z
     * @param reductRate ������
     * @return ���Z��̍��Z
     * @throws Exception ������O
     */
    public int getReductedServiceCodeUnit(Map code, int codeUnit, long total,
            int reductRate) throws Exception {
        return toReductedUnit(getServiceCodeUnit(code, codeUnit, total),
                reductRate);
    }

    /**
     * �u�T�[�r�X�P�ʌv�Z�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @param service �T�[�r�X
     * @param check30Over 30������0�P�ʂƌ��Ȃ���
     * @param totalGroupingCache ��/���P�ʎZ��L���V��
     * @throws Exception ������O
     * @return int �P��
     */
    public int getServiceUnit(VRMap service, boolean check30Over,
            Map[] totalGroupingCache) throws Exception {
        if (check30Over && CareServiceCommon.is30DayOver(service)) {
            // ������30�������O(remove30Over)���^�ł������̃T�[�r�X��30�����ɊY�����Ă���΁A0��Ԃ��B
            return 0;
        }
        // �����̊֐����ԐړI�ɌĂяo���ăT�[�r�X�P�ʂ�Ԃ��B

        return getServiceUnit(getServiceCodes(service),
                CALC_MODE_IN_LIMIT_AMOUNT,
                getReductRate(getProviderID(service), service), service,
                totalGroupingCache);
    }

    /**
     * �u�T�[�r�X�P�ʌv�Z�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @param service �T�[�r�X
     * @param check30Over 30������0�P�ʂƌ��Ȃ���
     * @param code �T�[�r�X�R�[�h
     * @param mode �v�Z���[�h
     * @throws Exception ������O
     * @return int �P��
     */
    public int getServiceCodeUnitField(VRMap service, boolean check30Over,
            Map code, int mode, Map[] totalGroupingCache) throws Exception {
        if (check30Over && CareServiceCommon.is30DayOver(service)) {
            // ������30�������O(remove30Over)���^�ł������̃T�[�r�X��30�����ɊY�����Ă���΁A0��Ԃ��B
            return 0;
        }
        // �����̊֐����ԐړI�ɌĂяo���ăT�[�r�X�P�ʂ�Ԃ��B

        return getServiceUnit(code, mode, service, totalGroupingCache);
    }

    /**
     * �u�T�[�r�X�P�ʌv�Z�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @param service �T�[�r�X
     * @param check30Over 30������0�P�ʂƌ��Ȃ���
     * @param code �T�[�r�X�R�[�h
     * @throws Exception ������O
     * @return int �P��
     */
    public int getServiceUnit(VRMap service, boolean check30Over, Map code,
            Map[] totalGroupingCache) throws Exception {
        return getServiceCodeUnitField(service, check30Over, code,
                CALC_MODE_IN_LIMIT_AMOUNT, totalGroupingCache);
    }

    /**
     * �T�[�r�X��ނ����ƂɁA�ی����t�ƌ���̂����K�؂ȋ��t����Ԃ��܂��B
     * 
     * @param insureRate �ی����t��
     * @param serviceKind �T�[�r�X���
     * @param provider ���Ə�
     * @return ���t��
     * @throws Exception ������O
     */
    public int checkPublicExpense(int insureRate, Object serviceKind,
            Map provider) throws Exception {
        if (isCalcWithPublicExpense()) {
            int pe = getPublicExpense(ACCastUtilities.toInt(serviceKind, 0),
                    provider);
            if (pe > 0) {
                // ����Ŏx����
                insureRate = pe;
            }
        }
        return insureRate;
    }

    /**
     * �Ώۂ̗��p�҂���������҂ł��邩������킷�t���O ��Ԃ��܂��B
     * 
     * @return �Ώۂ̗��p�҂���������҂ł��邩������킷�t���O
     */
    public int getInSpecialFacilityFlag() {
        return inSpecialFacilityFlag;
    }

    private int oldFacilityUserFlag;

    /**
     * �ی��ҏ���Ԃ��܂��B
     * 
     * @param insurerID �ی��Ҕԍ�
     * @return �ی��ҏ��
     * @throws Exception ������O
     */
    public Map getInsurerInfo(String insurerID) throws Exception {
        VRList insurers = QkanCommon.getInsurerInfo(getDBManager(), insurerID);
        if (!insurers.isEmpty()) {
            return (VRMap) insurers.getData();
        }
        return null;
    }

    /**
     * �����̍ŏI���t��Ԃ��܂��B
     * 
     * @return �����̍ŏI���t
     */
    public Date getLastDayOfMonth() {
        return ACDateUtilities.toLastDayOfMonth(getTargetDate());
    }

    /**
     * ���������̗j����Ԃ��܂��B
     * 
     * @return ���������̗j��
     */
    public int getDayOfWeekOnTargetFirstDay() {
        return ACDateUtilities.getDayOfWeek(ACDateUtilities
                .toFirstDayOfMonth(getTargetDate()));
    }

    /**
     * ���p�҂̃t���l�[����Ԃ��܂��B
     * 
     * @return ���p�҂̃t���l�[��
     * @throws Exception ������O
     */
    public String getPatientFullName() throws Exception {
        return QkanCommon.toFullName(
                ACCastUtilities.toString(getPatientInfo().get(
                        "PATIENT_FAMILY_NAME")),
                ACCastUtilities.toString(getPatientInfo().get(
                        "PATIENT_FIRST_NAME")));
    }

    /**
     * ���p�ҏ���Ԃ��܂��B
     * 
     * @return ���p�ҏ��
     * @throws Exception ������O
     */
    public VRMap getPatientInfo() throws Exception {
        if (patientInfo == null) {
            VRList list = QkanCommon.getPatientInfo(getDBManager(),
                    getPatientID());
            if (!list.isEmpty()) {
                patientInfo = (VRMap) list.getData();
            }
        }
        return patientInfo;
    }

    /**
     * �����̗v���F�藚�� ��Ԃ��܂��B
     * 
     * @return �����̗v���F�藚��
     */
    public VRList getPatientInsureInfoHistoryList() {
        return patientInsureInfoHistoryList;
    }

    /**
     * �Ώ۔N��������Y������v���F�藚����Ԃ��܂��B
     * 
     * @param date �Ώ۔N��
     * @return �v���F�藚��
     * @throws Exception ������O
     */
    public VRMap getPatientInsureInfoOnTargetDay(Date date) throws Exception {
        return QkanCommon.getPatientInsureInfoOnTargetDay(
                getPatientInsureInfoHistoryList(), date);
    }

    /**
     * ���Ə�����Ԃ��܂��B
     * 
     * @param providerID ���Ə��ԍ�
     * @return ���Ə����
     * @throws Exception ������O
     */
    public Map getProvider(String providerID) throws Exception {
        Object obj = getHashedProviders().get(providerID);
        if (obj instanceof Map) {
            return (Map) obj;
        }
        return null;
    }

    /**
     * ���Ə�����Ԃ��܂��B
     * 
     * @param service �T�[�r�X
     * @return ���Ə����
     * @throws Exception ������O
     */
    public Map getProvider(VRMap service) throws Exception {
        return getProvider(getProviderID(service));
    }

    /**
     * ���Ə�ID��Ԃ��܂��B
     * 
     * @param service �T�[�r�X
     * @return ���Ə�ID
     * @throws Exception ������O
     */
    public String getProviderID(Map service) throws Exception {
        return ACCastUtilities.toString(service.get("PROVIDER_ID"));
    }

    /**
     * ���Ə�����Ԃ��܂��B
     * 
     * @param service �T�[�r�X
     * @return ���Ə���
     * @throws Exception ������O
     */
    public String getProviderName(VRMap service) throws Exception {
        Map val = getProvider(service);
        if (val != null) {
            return ACCastUtilities.toString((val).get("PROVIDER_NAME"));
        }
        return "";
    }

    /**
     * ���Ə��񋟃T�[�r�X��Ԃ��܂��B
     * 
     * @param providerID ���Ə�ID
     * @param service �T�[�r�X
     * @return ���Ə��񋟃T�[�r�X
     * @throws Exception ������O
     */
    public Map getProviderService(String providerID, Map service)
            throws Exception {
        return getProviderService(providerID,
                service.get("SYSTEM_SERVICE_KIND_DETAIL"));
    }

    /**
     * ���Ə��񋟃T�[�r�X��Ԃ��܂��B
     * 
     * @param providerID ���Ə�ID
     * @param serviceKind �T�[�r�X���
     * @return ���Ə��񋟃T�[�r�X
     * @throws Exception ������O
     */
    public Map getProviderService(String providerID, Object serviceKind)
            throws Exception {
        // ���Ə��񋟃T�[�r�X���L���b�V������擾
        String key = providerID + "-" + ACCastUtilities.toString(serviceKind);
        Map providerService = null;
        Object val = getHashedProviderServices().get(key);
        if (val instanceof Map) {
            providerService = (Map) val;
        } else {
            // �L���b�V���ɂȂ���Ύ擾
            List list = QkanCommon.getProviderServiceDetail(getDBManager(),
                    providerID, ACCastUtilities.toInt(serviceKind, 0));
            if (!list.isEmpty()) {
                providerService = (Map) list.get(0);
                getHashedProviderServices().put(key, providerService);
            }
        }
        return providerService;
    }

    /**
     * ���Ə��񋟃T�[�r�X��Ԃ��܂��B
     * 
     * @param service �T�[�r�X
     * @return ���Ə��񋟃T�[�r�X
     * @throws Exception ������O
     */
    public Map getProviderService(VRMap service) throws Exception {
        Map provider = getProvider(service);
        if (provider != null) {
            return getProviderService(getProviderID(provider), service);
        }
        return null;
    }

    /**
     * ���������Z��̃T�[�r�X�P�ʂ�Ԃ��܂��B
     * 
     * @param service �T�[�r�X
     * @param check30Over 30������0�P�ʂƌ��Ȃ���
     * @param totalGroupingCache ��/���P�ʎZ��L���b�V��
     * @param �v�Z���[�h
     * @throws Exception ������O
     * @return int ���������Z��̃T�[�r�X�P��
     */
    public int getReductedUnit(VRMap service, boolean check30Over, int mode,
            Map[] totalGroupingCache) throws Exception {
        if (check30Over && CareServiceCommon.is30DayOver(service)) {
            // ������30�������O(remove30Over)���^�ł������̃T�[�r�X��30�����ɊY�����Ă���΁A0��Ԃ��B
            return 0;
        }
        // ������
        int reductRate = getReductRate(getProviderService(service));
        if (reductRate > 0) {
            List codes = getServiceCodes(service);
            return getServiceUnit(codes, mode, reductRate, service,
                    totalGroupingCache);
        }
        return 0;
    }

    /**
     * �T�[�r�X��ނ��ƂɏW�v�������ʂ�Ԃ��܂��B
     * 
     * @param services �T�[�r�X�W��
     * @param mode �v�Z���[�h
     * @return �W�v����
     * @throws Exception
     */
    public CareServiceUnitCalcurateResult getServiceUnitCalcurateResult(
            VRList services, int mode) throws Exception {

        VRMap serviceMaster = QkanServiceAbbreviationFormat.getInstance()
                .getMasterService();
        TreeMap sorter = new TreeMap();

        Map[] totalGroupingCache = new Map[] { new HashMap(), new HashMap() };
        Iterator it = services.iterator();
        while (it.hasNext()) {
            // �T�[�r�X�R�[�h�f�[�^���擾
            VRMap service = (VRMap) it.next();
            int reductedUnit = getReductedUnit(service, true, mode,
                    totalGroupingCache);
            
            // [CCCX:1626][Shinobu Hitaka] 2014/05/08 replace begin ���Z�̒P�ʐ��Ή��i�������ʏ����p���Z�E�����^�K��Ō�Ȃǁj
            //if (reductedUnit > 0) {
            if (reductedUnit != 0) {
            // [CCCX:1626][Shinobu Hitaka] 2014/05/08 replace begin ���Z�̒P�ʐ��Ή�

                // �Ǘ��Ώۓ��̃T�[�r�X�݈̂ȍ~�̏��������s����
                Object key = service.getData("SYSTEM_SERVICE_KIND_DETAIL");
                Object order = key;
                if (serviceMaster != null) {
                    Object obj = serviceMaster.get(ACCastUtilities.toInteger(
                            key, 0));
                    if (obj instanceof Map) {
                        // �T�[�r�X�̃\�[�g���ɒu��
                        obj = ((Map) obj).get("SERVICE_SORT");
                        if (obj != null) {
                            order = obj;
                        }
                    }
                }
                Object obj = sorter.get(order);
                VRMap val;
                int adjustPoint = 0;
                if (obj instanceof VRMap) {
                    // ���o�Ȃ���芮��
                    val = (VRMap) obj;
                    reductedUnit += ACCastUtilities.toInt(val.getData("UNIT"),
                            0);
                    adjustPoint += ACCastUtilities.toInt(val.getData("ADJUST"),
                            0);
                } else {
                    // �V�K�Ȃ琶�����đ��
                    val = new VRHashMap();
                    sorter.put(order, val);
                    val.setData("SYSTEM_SERVICE_KIND_DETAIL", key);
                }

                adjustPoint += ACCastUtilities.toInt(
                        service.getData("REGULATION_RATE"), 0);
                val.setData("UNIT", new Integer(reductedUnit));
                val.setData("ADJUST", new Integer(adjustPoint));
                val.setData("RESULT", new Integer(reductedUnit - adjustPoint));
            }
        }

        return new CareServiceUnitCalcurateResult(sorter.values());
    }

    /**
     * ���Ə��񋟃T�[�r�X�̊�������Ԃ��܂��B
     * <p>
     * ���������ݒ肳��Ă��Ȃ����0���Ԃ�܂��B
     * </p>
     * 
     * @param providerService ���Ə��񋟃T�[�r�X
     * @return ������
     */
    public int getReductRate(Map providerService) {
        if (providerService != null) {
            // ������
            return 100 - ACCastUtilities.toInt(
                    providerService.get("REDUCT_RATE"), 0);
        }
        return 0;
    }

    /**
     * ���Ə��񋟃T�[�r�X�̊�������Ԃ��܂��B
     * <p>
     * ���������ݒ肳��Ă��Ȃ����0���Ԃ�܂��B
     * </p>
     * 
     * @param providerID ���Ə�ID
     * @param service �T�[�r�X
     * @throws Exception ������O
     * @return ������
     */
    public int getReductRate(String providerID, Map service) throws Exception {
        return getReductRate(getProviderService(providerID, service));
    }

    /**
     * ��������̒P�ʐ���Ԃ��܂��B
     * 
     * @param providerID ���Ə�ID
     * @param code �T�[�r�X�R�[�h
     * @param unit
     * @throws Exception ������O
     * @return ������
     */
    public int getReductedUnit(String providerID, Map code, int unit)
            throws Exception {
        int reductRate = getReductRate(providerID, code);
        if (reductRate < 100) {
            unit = toReductedUnit(unit, reductRate);
        }
        return unit;
    }

    /**
     * �T�[�r�X��ޖ���Ԃ��܂��B
     * 
     * @param service �T�[�r�X
     * @return �T�[�r�X��ޖ�
     */
    public String getServiceKindName(VRMap service) {
        if (service != null) {
            Object kind = getHashedServiceKinds().get(
                    service.get("SYSTEM_SERVICE_KIND_DETAIL"));
            if (kind instanceof Map) {
                return ACCastUtilities.toString(
                        ((Map) kind).get("SERVICE_KIND_NAME"), "");
            }
        }
        return "";
    }

    /**
     * ���[�Ɉ󎚂���T�[�r�X�R�[�h�𕶎���\���ŕԂ��܂��B
     * 
     * @param serviceCode �T�[�r�X�R�[�h
     * @return �T�[�r�X�R�[�h
     * @throws Exception ������O
     */
    public String getTextOfServiceCode(Map serviceCode) throws Exception {
        return ACTextUtilities.trim(ACCastUtilities.toString(serviceCode
                .get("SERVICE_CODE_KIND")))
                + ACTextUtilities.trim(ACCastUtilities.toString(serviceCode
                        .get("SERVICE_CODE_ITEM")));
    }

    /**
     * �Ώ۔N�����u�`�����v�ɏ���������������\����Ԃ��܂��B
     * 
     * @return �Ώ۔N��
     * @throws Exception ������O
     */
    public String getTextOfTargetYearMonth() throws Exception {
        return ACConstants.FORMAT_FULL_ERA_YM.format(getTargetDate()) + "��";
    }

    /**
     * ���[�󎚗p�̒P�ʐ��P���̕�����\����Ԃ��܂��B
     * 
     * @param unitPrice �P�ʐ��P��
     * @return �P�ʐ��P��
     */
    public String getTextOfUnitPrice(double unitPrice) {
        return UNIT_PRICE_FORMAT.format(unitPrice);
    }

    /**
     * �n��P����Ԃ��܂��B
     * 
     * @param serviceKindDetail �T�[�r�X���
     * @param provider ���Ə�
     * @return �n��P��
     * @throws Exception ������O
     */
    public double getUnitPrice(Object serviceKindDetail, Map provider)
            throws Exception {
        Object val = getHashedAreaUnitPrices().get(serviceKindDetail);
        if (val instanceof Map) {
            val = ((Map) val).get(provider.get("PROVIDER_AREA_TYPE"));
            if ((val instanceof List) && (!((List) val).isEmpty())) {
                val = ((List) val).get(0);
                if (val instanceof Map) {
                    return ACCastUtilities.toDouble(((Map) val)
                            .get("UNIT_PRICE_VALUE"));
                }
            }
        }
        VRLogger.info("�Y������n��P�������݂��܂���B[" + serviceKindDetail + "-"
                + provider.get("PROVIDER_AREA_TYPE") + "]");
        // �f�t�H���g��10.0��ԋp����B
        return 10.0;
    }

    /**
     * �K�p�������������܂��B
     * 
     * @param targetDate �Ώ۔N��
     * @param patientInfo ���p�ҏ��
     * @param patientInsureInfoHistoryList �����̗v���F�藚��
     * @param hashedProviders ���Ǝ�ID�Ńn�b�V�����������ƎҏW��
     * @param dbm DBManager
     * @param serviceKinds �T�[�r�X��ޏW��
     * @param inSpecialFacilityFlag ��������҂ł��邩������킷�t���O
     * @parm oldFaclityUserFlag ���[�u�����҂ł��邩������킷�t���O
     * @throws Exception ������O
     */
    public void initialize(Date targetDate, VRMap patientInfo,
            VRList patientInsureInfoHistoryList, VRMap hashedProviders,
            ACDBManager dbm, VRList serviceKinds, int inSpecialFacilityFlag,
            int oldFacilityUserFlag) throws Exception {
        setTargetDate(targetDate);
        setDBManager(dbm);
        setPatientInfo(patientInfo);
        setPatientID(ACCastUtilities.toInt(patientInfo.get("PATIENT_ID")));
        setPatientInsureInfoHistoryList(patientInsureInfoHistoryList);
        setHashedProviders(hashedProviders);
        setInSpecialFacilityFlag(inSpecialFacilityFlag);
        setOldFacilityUserFlag(oldFacilityUserFlag);
        setServiceKindsList(serviceKinds);
        VRMap map = new VRHashMap();
        ACBindUtilities.setMapFromArray(serviceKinds, map,
                "SYSTEM_SERVICE_KIND_DETAIL");
        setHashedServiceKinds(map);
        getHashedProviderServices().clear();
    }

    /**
     * ����t�����܂߂Čv�Z���邩 ��Ԃ��܂��B
     * 
     * @return ����t�����܂߂Čv�Z���邩
     */
    public boolean isCalcWithPublicExpense() {
        return calcWithPublicExpense;
    }

    /**
     * ����{�ݓ����҂Ɋւ���R�[�h�ł��邩��Ԃ��܂��B
     * 
     * @param code �T�[�r�X�R�[�h
     * @return ����{�ݓ����҂Ɋւ���R�[�h�ł��邩
     * @throws Exception ������O
     */
    public boolean isInSpecialFacility(Map code) throws Exception {
        if (QkanConstants.SERVICE_KIND_LIFE_CARE_AT_SPECIAL_FACILITIY
                .equals(ACCastUtilities.toString(code.get("SERVICE_CODE_KIND")))) {
            // ����{�ݓ����҂Ɋւ���R�[�h�͏��O
            return true;
        }
        return false;
    }

    /**
     * ����{�ݓ����҂Ɋւ���R�[�h���������͋�ł��邩��Ԃ��܂��B
     * 
     * @param codes �T�[�r�X�R�[�h�W��
     * @return ����{�ݓ����҂Ɋւ���R�[�h���������͋�ł��邩
     * @throws Exception ������O
     */
    public boolean isInSpecialFacilityOrBlank(List codes) throws Exception {
        if (codes.isEmpty()) {
            // ��
            return true;
        }
        return isInSpecialFacility((Map) codes.get(0));
    }

    /**
     * �Ώۂ̗��p�҂���������҂ł��邩������킷�t���O ��ݒ肵�܂��B
     * 
     * @param inSpecialFacilityFlag �Ώۂ̗��p�҂���������҂ł��邩������킷�t���O
     */
    public void setInSpecialFacilityFlag(int inSpecialFacilityFlag) {
        this.inSpecialFacilityFlag = inSpecialFacilityFlag;
    }

    /**
     * ���p�ҏ�� ��ݒ肵�܂��B
     * 
     * @param patientInfo ���p�ҏ��
     */
    public void setPatientInfo(VRMap patientInfo) {
        this.patientInfo = patientInfo;
    }

    /**
     * ������̒P�ʐ���Ԃ��܂��B
     * 
     * @param unit �P��
     * @param reductRate ������
     * @return ������̒P�ʐ�
     */
    public int toReductedUnit(int unit, int reductRate) {
        if (reductRate < 100) {
            if (unit > 0) {
                // �P�ʐ������̒l(���Z)�͊�������Ȃ�

                // ������̗�%��100��菬����(�������)
                reductRate = Math.max(reductRate, 0);
                // �l�̌ܓ�
                return (int) Math.round(unit * reductRate / 100.0);
            }
        }
        return unit;
    }

    /**
     * DBManager ��Ԃ��܂��B
     * 
     * @return DBManager
     */
    public ACDBManager getDBManager() {
        return dbm;
    }

    /**
     * �n�b�V�������ꂽ�n��敪�ʒP�ʒP����� ��Ԃ��܂��B
     * 
     * @return �n�b�V�������ꂽ�n��敪�ʒP�ʒP�����
     * @throws Exception ������O
     */
    protected Map getHashedAreaUnitPrices() throws Exception {
        if (hashedAreaUnitPrices == null) {

            StringBuilder sb = new StringBuilder();
            // �n��P�����n�b�V�������Ď擾
            sb.append("SELECT");
            sb.append(" M_AREA_UNIT_PRICE.SYSTEM_SERVICE_KIND_DETAIL");
            sb.append(",M_AREA_UNIT_PRICE.UNIT_PRICE_TYPE");
            sb.append(",M_AREA_UNIT_PRICE.UNIT_PRICE_VALUE");
            sb.append(" FROM");
            sb.append(" M_AREA_UNIT_PRICE");
            sb.append(" WHERE");
            String targetDateText = ACConstants.FORMAT_SQL_FULL_YMD
                    .format(getTargetDate());
            sb.append(" (M_AREA_UNIT_PRICE.UNIT_VALID_START <= "
                    + targetDateText + ")");
            sb.append(" AND(M_AREA_UNIT_PRICE.UNIT_VALID_END >= "
                    + targetDateText + ")");
            sb.append(" ORDER BY");
            sb.append(" SYSTEM_SERVICE_KIND_DETAIL");
            sb.append(",UNIT_PRICE_TYPE");
            VRList list = getDBManager().executeQuery(sb.toString());
            // �T�[�r�X��ނŃn�b�V����
            VRMap fullMap = new VRHashMap();
            ACBindUtilities.setHashListFromArray(list, fullMap,
                    "SYSTEM_SERVICE_KIND_DETAIL");
            // �n��敪�Ńn�b�V����
            VRMap convedMap = new VRHashMap();
            Iterator it = fullMap.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry ent = (Map.Entry) it.next();
                VRMap map = new VRHashMap();
                ACBindUtilities.setHashListFromArray((VRList) ent.getValue(),
                        map, "UNIT_PRICE_TYPE");
                convedMap.put(ent.getKey(), map);
            }
            // �����ϐ��ɓ]�L
            hashedAreaUnitPrices = convedMap;

        }
        return hashedAreaUnitPrices;
    }

    /**
     * ���Ə��ԍ��Ńn�b�V�����������Ə��W�� ��Ԃ��܂��B
     * 
     * @return ���Ə��ԍ��Ńn�b�V�����������Ə��W��
     */
    public VRMap getHashedProviders() {
        return hashedProviders;
    }

    /**
     * "���Ə�ID"+"�T�[�r�X���"�Ńn�b�V�������ꂽ���Ə��񋟃T�[�r�X ��Ԃ��܂��B
     * 
     * @return �n�b�V�������ꂽ���Ə��񋟃T�[�r�X�W��
     */
    protected Map getHashedProviderServices() {
        return hashedProviderServices;
    }

    /**
     * �T�[�r�X��ނŃn�b�V���������T�[�r�X��ޏW�� ��Ԃ��܂��B
     * 
     * @return �T�[�r�X��ޏW��
     */
    protected VRMap getHashedServiceKinds() {
        return hashedServiceKinds;
    }

    /**
     * patientID ��Ԃ��܂��B
     * 
     * @return patientID
     */
    public int getPatientID() {
        return patientID;
    }

    /**
     * �w��T�[�r�X�ɓK�p��������x������Ԃ��܂��B
     * 
     * @param serviceKind �T�[�r�X���
     * @param provider ���Ə�
     * @return ����x����
     * @throws Exception ������O
     */
    protected int getPublicExpense(int serviceKind, Map provider)
            throws Exception {
        Integer key = new Integer(serviceKind);
        Object val = publicExpenseMap.get(key);
        if (val instanceof Integer) {
            return ((Integer) val).intValue();
        }

        // boolean filterMedicalProvider = (provider != null)
        // && ("0".equals(ACCastUtilities.toString(provider
        // .get("MEDICAL_FLAG"))));

        StringBuilder sb = new StringBuilder();
        sb.append("SELECT");
        sb.append(" PATIENT_KOHI.BENEFIT_RATE");
        sb.append(" FROM");
        sb.append(" PATIENT_KOHI");
        sb.append(" LEFT JOIN");
        sb.append(" M_KOHI_SERVICE");
        sb.append(" ON");
        sb.append(" (M_KOHI_SERVICE.KOHI_TYPE=PATIENT_KOHI.KOHI_TYPE)");
        sb.append(" AND(M_KOHI_SERVICE.SYSTEM_SERVICE_KIND_DETAIL=M_KOHI_SERVICE.SYSTEM_SERVICE_KIND_DETAIL)");

        sb.append(" WHERE");
        sb.append(" (PATIENT_KOHI.PATIENT_ID = ");
        sb.append(getPatientID());
        sb.append(")");
        sb.append(" AND(M_KOHI_SERVICE.SYSTEM_SERVICE_KIND_DETAIL=");
        sb.append(serviceKind);
        sb.append(")");
        sb.append(" AND(PATIENT_KOHI.INSURE_TYPE = 1) ");

        // -- �L�����Ԃ��`�F�b�N����SQL�� �J�n----------------------------------------
        // �L�����ԓ��������͂��Ԃ��Ă���p�^�[���͕�������A���̂����ꂩ��ɊY������΋��e����
        sb.append(" AND(");

        String targetDateBegin = VRDateParser.format(getTargetDate(),
                "yyyy-MM-01");
        String targetDateEnd = VRDateParser
                .format(ACDateUtilities.toLastDayOfMonth(getTargetDate()),
                        "yyyy-MM-dd");

        sb.append(" (");
        // 1.�L�����ԊJ�n�����Ώ۔N���ȑO�̏ꍇ
        sb.append(" (PATIENT_KOHI.KOHI_VALID_START <= '" + targetDateEnd + "')");
        // 1-1.���L�����ԏI�����͑Ώ۔N���̏����Ɠ����������Ă���Ȃ�Ί��Ԃ����Ԃ�̂�OK
        sb.append(" AND(PATIENT_KOHI.KOHI_VALID_END >= '" + targetDateBegin
                + "')");

        sb.append(" )OR(");

        // 2.�L�����ԊJ�n�����Ώ۔N�����Ȃ�Ί��Ԃ����Ԃ�̂�OK
        sb.append(" (PATIENT_KOHI.KOHI_VALID_START <= '" + targetDateBegin
                + "')");
        sb.append(" AND(PATIENT_KOHI.KOHI_VALID_START >= '" + targetDateEnd
                + "')");
        sb.append(" )");

        sb.append(" )");
        // -- �L�����Ԃ��`�F�b�N����SQL�� �I��----------------------------------------

        // [ID:0000469][Tozo TANAKA] 2009/03/27 add begin ����21�N4���@�����Ή�(����)
        sb.append(" AND(");
        // 1.����}�X�^�̗L�����ԊJ�n�����Ώ۔N���ȑO�̏ꍇ
        sb.append(" (M_KOHI_SERVICE.KOHI_SERVICE_VALID_START <= '"
                + targetDateEnd + "')");
        // 1-1.������}�X�^�̗L�����ԏI�����͑Ώ۔N���̏����Ɠ����������Ă���ꍇ
        sb.append(" AND(M_KOHI_SERVICE.KOHI_SERVICE_VALID_END >= '"
                + targetDateBegin + "')");
        sb.append(" )");
        // �ʕ\�ɋL�ڂ����T�[�r�X�񋟔�Ƌً}���{�ݗ×{�Ǘ���ΏۂƂ�������̏ꍇ
        sb.append(" AND(M_KOHI_SERVICE.APPLICATION_TYPE IN(1,2))");
        // [ID:0000469][Tozo TANAKA] 2009/03/27 add end

        sb.append(" ORDER BY");
        sb.append(" BENEFIT_RATE");
        sb.append(" DESC");
        VRList list = getDBManager().executeQuery(sb.toString());

        int result = 0;
        if (!list.isEmpty()) {
            Object obj = ((Map) list.getData()).get("BENEFIT_RATE");
            if (obj instanceof Integer) {
                result = ((Integer) obj).intValue();
            }
        }
        publicExpenseMap.put(key, new Integer(result));
        return result;
    }

    /**
     * �T�[�r�X��ނŃn�b�V������������t���}�b�v ��Ԃ��܂��B
     * 
     * @return �T�[�r�X��ނŃn�b�V������������t���}�b�v
     */
    protected HashMap getPublicExpenseMap() {
        return publicExpenseMap;
    }

    /**
     * �u�T�[�r�X�R�[�h�����v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @param service VRMap
     * @throws Exception ������O
     * @return List
     */
    protected List getServiceCodes(VRMap service) throws Exception {
        VRMap row = new VRHashMap(service);
        // �T�[�r�X�Ώ۔N�������擾����B
        Date serviceDate = ACCastUtilities.toDate(row.getData("SERVICE_DATE"),
                null);
        if (serviceDate == null) {
            return new ArrayList();
        }
        // �T�[�r�X�Ώ۔N��������Y������v���F�藚�����擾����B
        VRMap history = QkanCommon.getPatientInsureInfoOnTargetDay(
                getPatientInsureInfoHistoryList(), serviceDate);
        if ((history == null) || (history.isEmpty())) {
            return new ArrayList();
        }
        // �Y������v���x���擾����B
        Object jotaiCode = history.getData("JOTAI_CODE");
        if (ACCastUtilities.toInt(jotaiCode, 1) == 1) {
            // ��Y���̏ꍇ�̓T�[�r�X�R�[�h��Ԃ��Ȃ�
            return new ArrayList();
        }
        row.setData(Qkan10011_ServiceUnitGetter.YOKAIGODO, jotaiCode);
        // ���Ə��ԍ�����Ή����鎖�Ə����擾����B
        Object provider = getHashedProviders().get(row.getData("PROVIDER_ID"));
        if (provider instanceof VRMap) {
            // �Y�����鎖�Ə��̓��ʒn��L�����擾����B
            row.setData(Qkan10011_ServiceUnitGetter.TOKUCHI_KASAN,
                    ((VRMap) provider).getData("SPECIAL_AREA_FLAG"));
            // [ID:0000445][Masahiko Higuchi] 2009/02 add begin ����21�N4���@�����Ή�
            String providerID = ACCastUtilities.toString(
                    ((VRMap) provider).getData("PROVIDER_ID"), "");
            VRList serviceInfo = QkanCommon.getProviderServiceDetail(
                    getDBManager(),
                    providerID,
                    ACCastUtilities.toInt(
                            service.getData("SYSTEM_SERVICE_KIND_DETAIL"), 0));
            // �����͒��R�Ԃł͂Ȃ�
            row.setData(Qkan10011_ServiceUnitGetter.CHUSANKANCHIIKI_KASAN, "1");
            if (serviceInfo != null) {
                if (serviceInfo.getData(0) instanceof VRMap) {
                    VRMap providerServiceInfo = (VRMap) serviceInfo.getData(0);
                    if (CareServiceCommon
                            .isMountainousArea(providerServiceInfo)) {
                        // ���R�Ԓn��̏��K�͎��Ə��ł���B
                        row.setData(
                                Qkan10011_ServiceUnitGetter.CHUSANKANCHIIKI_KASAN,
                                "2");
                    }
                    // [ID:0000682] 2012/01 start ���E���������P���Z�̒ǉ�����
                    if (CareServiceCommon.getProviderSyogukaizenValue(providerServiceInfo) > 1) {
                        // ���E���������P���Z����
                        row.setData(
                                Qkan10011_ServiceUnitGetter.SYOGUKAIZEN_KASAN,
                                CareServiceCommon
                                        .getProviderSyogukaizenValue(providerServiceInfo));
                    }
                    // [ID:0000682] 2012/01 end
                }
            }
            // [ID:0000445][Masahiko Higuchi] 2009/02 add end

        }

        // ���������
        row.setData(QkanConstants.SERVICE_SYSTEM_KIND_DETAIL_SPECIAL_FACILITIY,
                new Integer(getInSpecialFacilityFlag()));

        // ���[�u������
        if (!VRBindPathParser.has(
                QkanConstants.SERVICE_SYSTEM_KIND_DETAIL_OLD_FACILITIY_USER,
                row)) {
            // �T�[�r�X�̏��Ƃ��Đݒ肳��Ă��Ȃ��ꍇ�͗��p�҂̏����g�p����B
            row.setData(
                    QkanConstants.SERVICE_SYSTEM_KIND_DETAIL_OLD_FACILITIY_USER,
                    new Integer(getOldFacilityUserFlag()));
        }

        // �Z�荀�ڂƎ擾������񂩂�T�[�r�X�R�[�h�f�[�^���擾���ĕԂ��B
        String kind = ACCastUtilities.toString(row
                .getData("SYSTEM_SERVICE_KIND_DETAIL"));

        // [ID:0000734][Masahiko.Higuchi] 2012/04 ����24�N4���@�����Ή� add begin
        // ��x�R�s�[���ĎQ�Ə�Ԃ�؂�
        ArrayList<VRMap> baseCodeList = Qkan10011_ServiceCodeManager.getInstance()
                .getServiceCode(kind, (HashMap) row, serviceDate,
                        getDBManager());
        ArrayList<VRMap> result = new ArrayList<VRMap>();
        for (int i = 0; i < baseCodeList.size(); i++) {
            VRMap rec = baseCodeList.get(i);
            result.add(QkanValidServiceCommon.deepCopyVRMap(rec));
        }
        // [ID:0000734][Masahiko.Higuchi] 2012/04 add end

        return result;
    }

    /**
     * �T�[�r�X��ޏW����Ԃ��܂��B
     * 
     * @return �T�[�r�X��ޏW��
     */
    public VRList getServiceKindsList() {
        return serviceKindsList;
    }

    /**
     * targetDate ��Ԃ��܂��B
     * 
     * @return targetDate
     */
    public Date getTargetDate() {
        return targetDate;
    }

    /**
     * ����t�����܂߂Čv�Z���邩 ��ݒ肵�܂��B
     * 
     * @param calcWithPublicExpense ����t�����܂߂Čv�Z���邩
     */
    protected void setCalcWithPublicExpense(boolean calcWithPublicExpense) {
        this.calcWithPublicExpense = calcWithPublicExpense;
    }

    /**
     * DBManager ��ݒ肵�܂��B
     * 
     * @param dbm DBManager
     */
    protected void setDBManager(ACDBManager dbm) {
        this.dbm = dbm;
    }

    /**
     * �n�b�V�������ꂽ�n��敪�ʒP�ʒP����� ��ݒ肵�܂��B
     * 
     * @param hashedAreaUnitPrices �n�b�V�������ꂽ�n��敪�ʒP�ʒP�����
     */
    protected void setHashedAreaUnitPrices(VRMap hashedAreaUnitPrices) {
        this.hashedAreaUnitPrices = hashedAreaUnitPrices;
    }

    /**
     * ���Ə��ԍ��Ńn�b�V�����������Ə��W�� ��ݒ肵�܂��B
     * 
     * @param hashedProviders ���Ə��ԍ��Ńn�b�V�����������Ə��W��
     */
    protected void setHashedProviders(VRMap hashedProviders) {
        this.hashedProviders = hashedProviders;
    }

    /**
     * "���Ə�ID"+"�T�[�r�X���"�Ńn�b�V�������ꂽ���Ə��񋟃T�[�r�X ��ݒ肵�܂��B
     * 
     * @param hashedProviderServices �n�b�V�������ꂽ���Ə��񋟃T�[�r�X�W��
     */
    protected void setHashedProviderServices(HashMap hashedProviderServices) {
        this.hashedProviderServices = hashedProviderServices;
    }

    /**
     * �T�[�r�X��ނŃn�b�V���������T�[�r�X��ޏW�� ��ݒ肵�܂��B
     * 
     * @param hashedServiceKinds �T�[�r�X��ޏW��
     */
    protected void setHashedServiceKinds(VRMap hashedServiceKinds) {
        this.hashedServiceKinds = hashedServiceKinds;
    }

    /**
     * patientID ��ݒ肵�܂��B
     * 
     * @param patientID patientID
     */
    protected void setPatientID(int patientID) {
        this.patientID = patientID;
    }

    /**
     * �����̗v���F�藚�� ��ݒ肵�܂��B
     * 
     * @param patientInsureInfoHistoryList �����̗v���F�藚��
     */
    protected void setPatientInsureInfoHistoryList(
            VRList patientInsureInfoHistoryList) {
        this.patientInsureInfoHistoryList = patientInsureInfoHistoryList;
    }

    /**
     * �T�[�r�X��ނŃn�b�V������������t���}�b�v ��ݒ肵�܂��B
     * 
     * @param publicExpenseMap �T�[�r�X��ނŃn�b�V������������t���}�b�v
     */
    protected void setPublicExpenseMap(HashMap publicExpenseMap) {
        this.publicExpenseMap = publicExpenseMap;
    }

    /**
     * �T�[�r�X��ޏW����ݒ肵�܂��B
     * 
     * @param serviceKindsList �T�[�r�X��ޏW��
     */
    protected void setServiceKindsList(VRList serviceKindsList) {
        this.serviceKindsList = serviceKindsList;
    }

    /**
     * �Ώ۔N�� ��ݒ肵�܂��B
     * 
     * @param targetDate �Ώ۔N��
     */
    protected void setTargetDate(Date targetDate) {
        this.targetDate = targetDate;
    }

}
