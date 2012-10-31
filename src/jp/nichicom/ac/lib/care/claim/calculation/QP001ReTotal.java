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
 * �쐬��: 2009/07/10  ���{�R���s���[�^�[������� �����@�L �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �������o�� (P)
 * �v���Z�X �������� (001)
 * �v���O���� �ďW�v�@�\ (QP001ReTotal)
 *
 *****************************************************************
 */

package jp.nichicom.ac.lib.care.claim.calculation;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.lib.care.claim.servicecode.CareServiceCommon;
import jp.nichicom.ac.sql.ACDBManager;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.vr.text.parsers.VRDateParser;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.QkanSystemInformation;

public class QP001ReTotal {

    /** ��{��񃌃R�[�h(2) */
    private VRList base = new VRArrayList();

    /** ���׏�񃌃R�[�h(3) */
    private VRList detail = new VRArrayList();

    /** �ً}���{�ݗ×{��񃌃R�[�h(4) */
    private VRList emergency = new VRArrayList();

    /** �ً}���{�ݗ×{��񃌃R�[�h(17) */
    private VRList emergencyOwnFacility = new VRArrayList();

    /** ����f�Ô��񃌃R�[�h(5) */
    private VRList diagnosis = new VRArrayList();

    /** �W�v��񃌃R�[�h(7) */
    private VRList type = new VRArrayList();

    /** ��������҉��T�[�r�X��p��񃌃R�[�h(8) */
    private VRList nursing = new VRArrayList();

    /** �Љ���@�l�y���z��񃌃R�[�h(9) */
    private VRList reduction = new VRArrayList();

    /** ��������҉�쑍�v���R�[�h */
    private VRMap nursingTotal = null;

    /** ��싋�t������׏��i����T�[�r�X�v���j��� */
    private VRList careplan = new VRArrayList();

    /** ���t�� */
    private int rate = Integer.MIN_VALUE;
    /** ����t�� */
    private int[] kohiRate = new int[] { Integer.MIN_VALUE, Integer.MIN_VALUE,
            Integer.MIN_VALUE };
    /** ������ */
    private String[] kohiType = new String[] { null, null, null };
    /** �ً}�����ÓK�p���� */
    private VRList emergencyKohi = new VRArrayList();

    /** ���p�ҏ�� */
    private QP001PatientState patientState = null;

    /** ��{��񃌃R�[�h�ɐݒ肷��ً}���A����f�Ô��� */
    private VRMap baseCache = new VRHashMap();

    /** �v��P�ʐ��㏑���t���O **/
    private boolean isPlanOverwrite = false;
    
    private Date targetDate = null;
    private ACDBManager dbm = null;

    public void calc(VRList[] list, ACDBManager dbm, int patient_id,
            boolean isPlanOverwrite) throws Exception {
        if (list == null) {
            throw new NullPointerException("�����̃��X�g��null���ݒ肳��Ă��܂��B");
        }
        
        this.dbm = dbm;
        // �v��P�ʐ��㏑���t���O��ݒ�
        this.isPlanOverwrite = isPlanOverwrite;

        // ���R�[�h�U�蕪��
        parseRecord(list);

        VRMap patient = new VRHashMap();
        patient.put("PATIENT_ID", String.valueOf(patient_id));

        String target = null;
        String style = null;

        if (base.size() > 0) {
            target = ((VRMap) base.get(0)).get("201003") + "01";
            style = toString(((VRMap) base.get(0)), "201001");
        } else if (careplan.size() > 0) {
            target = ((VRMap) careplan.get(0)).get("1001004") + "01";
        } else {
            return;
        }
        targetDate = ACCastUtilities.toDate(target);

        // ���p�ҏ��擾
        patientState = new QP001PatientState(dbm, patient, targetDate);

        initUsedKohi(dbm, patientState, targetDate, style);

        // �ďW�v���s
        doTotal();
    }

    /**
     * �g�p�ς݌���ȕ��S�z���Z�肷��
     * 
     * @param dbm
     * @param patientState
     * @param targetDate
     * @param style
     * @throws Exception
     */
    private void initUsedKohi(ACDBManager dbm, QP001PatientState patientState,
            Date targetDate, String style) throws Exception {

        if (style == null) {
            return;
        }

        // �����ڍ׏����擾���AVRArrayList claimList �Ɋi�[����B
        StringBuilder sb = new StringBuilder();

        // ���������擾
        sb.append(" SELECT");
        sb.append(" DISTINCT");
        sb.append(" CLAIM_DATE");
        sb.append(" FROM");
        sb.append(" CLAIM");
        sb.append(" WHERE");
        sb.append(" (CLAIM.PATIENT_ID = " + patientState.getPatientId() + ")");
        sb.append(" AND (CLAIM.TARGET_DATE = '"
                + VRDateParser.format(targetDate, "yyyy/MM/dd") + "')");
        sb.append(" AND (CLAIM.PROVIDER_ID = '"
                + QkanSystemInformation.getInstance().getLoginProviderID()
                + "')");

        VRList list = dbm.executeQuery(sb.toString());

        if ((list == null) || (list.size() == 0)) {
            return;
        }

        Date claimDate = ACCastUtilities.toDate(
                ((VRMap) list.get(0)).get("CLAIM_DATE"), null);

        if (claimDate == null) {
            return;
        }

        sb = new StringBuilder();

        sb.append(" AND(CLAIM.TARGET_DATE = '"
                + VRDateParser.format(targetDate, "yyyy/MM/dd") + "')");
        sb.append(" AND(CLAIM.PATIENT_ID = " + patientState.getPatientId()
                + ")");
        sb.append(" AND(CLAIM.PROVIDER_ID = '"
                + QkanSystemInformation.getInstance().getLoginProviderID()
                + "')");
        sb.append(" AND (CLAIM.CATEGORY_NO IN (2))");

        // �������擾
        VRList claim = QkanCommon.getClaimDetailCustom(dbm, claimDate,
                sb.toString());

        for (int i = 0; i < claim.size(); i++) {
            VRMap map = (VRMap) claim.get(i);

            // �ďW�v�Ώۂ̃f�[�^�ƌ������ʔԍ������Ȃ����̂̓X�L�b�v
            if (toString(map, "201001").equals(style)) {
                continue;
            }

            String kohiType = null;

            // ����1 ������(KOHI_TYPE)
            kohiType = toString(map, "201058");
            if (!"".equals(kohiType)) {
                patientState.getKohiSelfPay(kohiType, 1);
                // (���v��� ����1)�{�l���S�z����������
                patientState.setKohiSelfPayUse(kohiType, toInt(map, "201041"));
            }

            // ����2 ������(KOHI_TYPE)
            kohiType = toString(map, "201059");
            if (!"".equals(kohiType)) {
                patientState.getKohiSelfPay(kohiType, 1);
                // (���v��� ����2)�{�l���S�z����������
                patientState.setKohiSelfPayUse(kohiType, toInt(map, "201047"));
            }

            // ����3 ������(KOHI_TYPE)
            kohiType = toString(map, "201060");
            if (!"".equals(kohiType)) {
                patientState.getKohiSelfPay(kohiType, 1);
                // (���v��� ����3)�{�l���S�z����������
                patientState.setKohiSelfPayUse(kohiType, toInt(map, "201053"));
            }

        }

        // �ً}�����ÂɓK�p����������擾����
        // �������ʔԍ�����A�V�X�e�����T�[�r�X��ރR�[�h�𔻒�
        // �����@�n�[�h�R�[�e�B���O
        String systemServiceKind = null;

        // �l����l�@�Z�������×{���(�V��)
        if (QP001StyleAbstract.IDENTIFICATION_NO_4_201204.equals(style)) {
            systemServiceKind = "12211";

            // �l����l�̓�@���\�h�Z�������×{���(�V��)
        } else if (QP001StyleAbstract.IDENTIFICATION_NO_4_2_201204
                .equals(style)) {
            systemServiceKind = "12511";

            // �l�����@���V�l�ی��{��
        } else if (QP001StyleAbstract.IDENTIFICATION_NO_9_201204.equals(style)) {
            systemServiceKind = "15211";
        }

        if (ACTextUtilities.isNullText(systemServiceKind)) {
            return;
        }

        // ����-�T�[�r�X�}�X�^�擾
        sb = new StringBuilder();

        sb.append(" SELECT");
        sb.append(" KOHI_TYPE");
        sb.append(" FROM");
        sb.append(" M_KOHI_SERVICE");
        sb.append(" WHERE");
        // 2:�ً}���{�ݗ×{�Ǘ�
        sb.append(" (APPLICATION_TYPE = 2)");
        sb.append(" AND (SYSTEM_SERVICE_KIND_DETAIL = " + systemServiceKind
                + ")");
        // 2-��Ë@�ւ��܂ߑS�Ă̎��Ə�
        sb.append(" AND (BY_MEDICAL_FLAG = 2)");
        sb.append(" AND (KOHI_SERVICE_VALID_START  <='"
                + VRDateParser.format(targetDate, "yyyy/MM/dd") + "')");
        sb.append(" AND (KOHI_SERVICE_VALID_END  >= '"
                + VRDateParser.format(targetDate, "yyyy/MM/dd") + "')");

        list = dbm.executeQuery(sb.toString());

        for (int i = 0; i < list.size(); i++) {
            VRMap map = (VRMap) list.get(i);
            emergencyKohi.add(ACCastUtilities.toString(map.get("KOHI_TYPE")));
        }

    }

    /**
     * ��������͂��āA�U�蕪����
     * 
     * @param list
     */
    private void parseRecord(VRList[] list) {

        // ���������Ă��邩�s���Ȃ̂ŁA�e���X�g�̐擪��map��
        // �J�e�S������U�蕪����𔻒f
        for (int i = 0; i < list.length; i++) {
            if (list[i].size() <= 0) {
                continue;
            }
            VRMap map = (VRMap) list[i].get(0);
            switch (toInt(map, "CATEGORY_NO")) {
            // ��{��񃌃R�[�h
            case 2:
                base = list[i];
                break;
            // ���׏�񃌃R�[�h
            case 3:
                detail = list[i];
                break;
            // �ً}���{�ݗ×{��񃌃R�[�h
            case 4:
                emergency = list[i];
                break;
            // ����f�Ô��񃌃R�[�h
            case 5:
                diagnosis = list[i];
                break;
            // �W�v��񃌃R�[�h
            case 7:
                type = list[i];
                break;
            // ��������҉��T�[�r�X��p��񃌃R�[�h
            case 8:
                nursing = list[i];
                break;
            // �Љ���@�l�y���z��񃌃R�[�h
            case 9:
                reduction = list[i];
                break;
            // �l���掵
            case 10:
                careplan = list[i];
                break;
            // �ً}���{�ݗ×{�E���{�ݗ×{���񃌃R�[�h
            case 17:
                emergencyOwnFacility = list[i];
                break;
            }
        }
    }

    private void doTotal() throws Exception {

        // ���׏�񃌃R�[�h�̏W�v����
        parseDetail();

        // �ً}�����Ã��R�[�h�̏W�v����
        parseEmergency();

        // �ً}�����ÊǗ��E���{�ݗ×{��
        parseEmergencyOwnFacility();

        // ����f�ÁE���ʗ×{���񃌃R�[�h
        parseDiagnosis();

        // ��������҉��T�[�r�X��p��񃌃R�[�h
        parseNursing();

        // �W�v��񃌃R�[�h
        parseType();
        
        //[ID:0000726][Shin Fujihara] 2012/04 add begin �������P���Z�̍ďW�v�Ή�
        parseImproveTheTreatment();
        //[ID:0000726][Shin Fujihara] 2012/04 add end

        // ��{��񃌃R�[�h
        parseBase();

        // �Е����R�[�h
        parseReduction();

        // ����T�[�r�X�v���
        parseCarePlan();
    }

    /**
     * ���׏�񃌃R�[�h�̏W�v����
     * 
     * @throws Exception
     */
    private void parseDetail() throws Exception {

        VRMap map = null;

        for (int i = 0; i < detail.size(); i++) {
            map = (VRMap) detail.get(i);

            if (toInt(map, "301009") == 0) {
                continue;
            }

            // �T�[�r�X�P�ʐ� = �P�ʐ� * ��
            mul(map, "301014", "301009", "301010");
            // ����P�ΏۃT�[�r�X�P�ʐ� = �P�ʐ� * ����P�����E��
            mul(map, "301015", "301009", "301011");
            // ����Q�ΏۃT�[�r�X�P�ʐ� = �P�ʐ� * ����Q�����E��
            mul(map, "301016", "301009", "301012");
            // ����R�ΏۃT�[�r�X�P�ʐ� = �P�ʐ� * ����R�����E��
            mul(map, "301017", "301009", "301013");
        }
    }

    /**
     * �ً}�����Ã��R�[�h�̏W�v����
     * 
     * @throws Exception
     */
    private void parseEmergency() throws Exception {

        VRMap map = null;

        for (int i = 0; i < emergency.size(); i++) {
            map = (VRMap) emergency.get(i);
            // �ً}�����ÊǗ����v = �ً}�����ÊǗ��P�ʐ� * �ً}�����ÊǗ�����
            mul(map, "401020", "401018", "401019");
            // �ً}���{�ݗ×{��v�_�� =
            // ���n�r���e�[�V�����_�� + ���u�_�� + ��p�_�� + �����_�� + ���ː����Ó_��
            add(map, "401046", new String[] { "401021", "401022", "401023",
                    "401024", "401025" });
        }
    }

    /**
     * �ً}�����ÊǗ��E���{�ݗ×{��R�[�h�̏W�v����
     * 
     * @throws Exception
     */
    private void parseEmergencyOwnFacility() throws Exception {

        VRMap map = null;

        for (int i = 0; i < emergencyOwnFacility.size(); i++) {
            map = (VRMap) emergencyOwnFacility.get(i);
            // �ً}�����ÊǗ����v = �ً}�����ÊǗ��P�ʐ� * �ً}�����ÊǗ�����
            mul(map, "1701020", "1701018", "1701019");
            
            // ���{�ݗ×{��v = ���{�ݗ×{��P�ʐ� * ���{�ݗ×{�����
            mul(map, "1701055", "1701053", "1701054");
            
            // �ً}���{�ݗ×{��v�_�� =
            // ���n�r���e�[�V�����_�� + ���u�_�� + ��p�_�� + �����_�� + ���ː����Ó_��
            add(map, "1701046", new String[] { "1701021", "1701022", "1701023",
                    "1701024", "1701025" });
        }
    }

    /**
     * ����f�ÁE���ʗ×{���񃌃R�[�h
     * 
     * @throws Exception
     */
    private void parseDiagnosis() throws Exception {

        VRMap map = null;
        int total = 0;
        int total_kohi1 = 0;
        int total_kohi2 = 0;
        int total_kohi3 = 0;

        for (int i = 0; i < diagnosis.size(); i++) {
            map = (VRMap) diagnosis.get(i);
            // �ی��T�[�r�X�P�ʐ� = �P�ʐ� * �ی���
            total += mul(map, "501012", "501010", "501011");
            // ����1�T�[�r�X�P�ʐ� = �P�ʐ� * ����1��
            total_kohi1 += mul(map, "501015", "501010", "501014");
            // ����2�T�[�r�X�P�ʐ� = �P�ʐ� * ����2��
            total_kohi2 += mul(map, "501018", "501010", "501017");
            // ����3�T�[�r�X�P�ʐ� = �P�ʐ� * ����3��
            total_kohi3 += mul(map, "501021", "501010", "501020");
        }
        // �e���v�P�ʐ���ݒ肷��
        if (map != null) {
            map.put("501013", String.valueOf(total));
            map.put("501016", String.valueOf(total_kohi1));
            map.put("501019", String.valueOf(total_kohi2));
            map.put("501022", String.valueOf(total_kohi3));
        }
    }

    /**
     * ��������҉��T�[�r�X��p��񃌃R�[�h
     * 
     * @throws Exception
     */
    private void parseNursing() throws Exception {
        // ���ёւ��͕ۗ�
        // ���Ƃ��ƕ��ёւ��Ă��Ȃ��͗l
        /*
         * Collections.sort(nursing, new Comparator() { public int
         * compare(Object obj1, Object obj2) { //�T�[�r�X�R�[�h�Ń\�[�g���� VRMap map1 =
         * ((VRMap)obj1); VRMap map2 = ((VRMap)obj2);
         * 
         * String serviceCode1 = ACCastUtilities.toString(map1.get("801008"),
         * ""); serviceCode1 += ACCastUtilities.toString(map1.get("801009"),
         * ""); String serviceCode2 =
         * ACCastUtilities.toString(map2.get("801008"), ""); serviceCode2 +=
         * ACCastUtilities.toString(map2.get("801009"), "");
         * 
         * if (serviceCode1.compareTo(serviceCode2) < 0) { return -1; } else if
         * (serviceCode1.compareTo(serviceCode2) > 0) { return 1; } return 0; }
         * });
         */
        VRMap map = null;
        int _801022 = 0;
        int _801023 = 0;
        int _801024 = 0;
        int _801025 = 0;
        int _801026 = 0;
        int _801028 = 0;
        int _801029 = 0;
        int _801031 = 0;
        int _801032 = 0;

        // [ID:0000605][Shin Fujihara] 2010/05 edit begin 2009�N�x��Q�Ή�
        int count_801007 = 1;
        // [ID:0000605][Shin Fujihara] 2010/05 edit end 2009�N�x��Q�Ή�

        for (int i = 0; i < nursing.size(); i++) {
            map = (VRMap) nursing.get(i);

            // ������
            map.put("801016", "0");
            map.put("801017", "0");
            map.put("801018", "0");
            map.put("801019", "0");
            map.put("801020", "0");
            map.put("801021", "0");

            // [ID:0000605][Shin Fujihara] 2010/05 del begin 2009�N�x��Q�Ή�
            // �ԍ��̐U��ւ����㔼�Ɉړ�
            // �����ԍ��U��ւ�
            // map.put("801007", String.valueOf(i + 1));
            // [ID:0000605][Shin Fujihara] 2010/05 del end 2009�N�x��Q�Ή�

            // ��p�z = ��p�P�� * ����
            mul(map, "801016", "801010", "801012");
            // �ی��������z = ��p�z�@- (���S���x�z * ����)
            mul(map, "801017", "801011", "801012");
            sub(map, "801017", new String[] { "801016", "801017" });

            // �����ɂȂ�����(���p�Ґ����̂ق����������)0�ɖ߂��B
            if (toInt(map, "801017") < 0) {
                map.put("801017", "0");
            }

            // �l���攪�`�\�̏ꍇ�A����̎Z����s��
            if (QP001SpecialCase.isShisetsuDiscriminationNo(toString(map,
                    "801001"))) {

                boolean kohiEnd = false;

                // ���ےP�Ƃ̏ꍇ
                if (QP001SpecialCase.isSeihoOnly(toString(map, "801006"))) {
                    // �ی��������z��0�ɐݒ�
                    map.put("801017", "0");
                    // ����P�����z�ɔ�p�z�̑S�z��ݒ肷��B
                    map.put("801018", map.get("801016"));
                    // ���p�ҕ��S�z��0��ݒ肷��B
                    map.put("801021", "0");
                } else {
                    // ��ގ��(1.�H��@6.������)
                    int serviceKind = toInt(map, "801037");
                    // 1.�H��@6.�������ȊO�͎Z�肵�Ȃ�
                    if ((serviceKind == 1) || (serviceKind == 6)) {
                        // ����P�̓K�p������ꍇ(��������Ƌ��t���Ŕ��f)
                        if ((toInt(map, "801013") != 0)
                                && (getKohiRate(1) != 0)) {
                            // ����1���S�z(����)6����ݒ肷��B(���S���x�z*����1����)
                            mul(map, "801018", "801011", "801013");
                            // ����P����p�z�ƕی����̍��Z�𒴂���ꍇ
                            if (toInt(map, "801018") > (toInt(map, "801016") + toInt(
                                    map, "801017"))) {
                                // ����ɔ�p�z����ی������������l��K�p����B
                                sub(map, "801018", new String[] { "801016",
                                        "801017" });
                            }
                            // �S�z���t�����珈�����I��
                            if (toInt(map, "801016") == (toInt(map, "801017") + toInt(
                                    map, "801018"))) {
                                kohiEnd = true;
                            }
                        }
                        // ����Q�̓K�p������ꍇ(�������f)
                        if (!kohiEnd && (toInt(map, "801014") != 0)
                                && (getKohiRate(2) != 0)) {
                            // ����Q���S�z(����)6����ݒ肷��B(���S���x�z*����Q����)
                            mul(map, "801019", "801011", "801014");
                            // ����Q����p�z�ƕی����̍��Z�𒴂���ꍇ
                            if (toInt(map, "801019") > (toInt(map, "801016") + toInt(
                                    map, "801017"))) {
                                // ����ɔ�p�z����ی������������l��K�p����B
                                sub(map, "801019", new String[] { "801016",
                                        "801017" });
                            }
                            // �S�z���t�����珈�����I��
                            if (toInt(map, "801016") == (toInt(map, "801017")
                                    + toInt(map, "801018") + toInt(map,
                                        "801019"))) {
                                kohiEnd = true;
                            }
                        }
                        // ����R�̓K�p������ꍇ(�������f)
                        if (!kohiEnd && (toInt(map, "801015") != 0)
                                && (getKohiRate(3) != 0)) {
                            // ����R���S�z(����)6����ݒ肷��B(���S���x�z*����R����)
                            mul(map, "801020", "801011", "801015");
                            // ����R����p�z�ƕی����̍��Z�𒴂���ꍇ
                            if (toInt(map, "801020") > (toInt(map, "801016") + toInt(
                                    map, "801017"))) {
                                // ����ɔ�p�z����ی������������l��K�p����B
                                sub(map, "801020", new String[] { "801016",
                                        "801017" });
                            }
                        }
                    }
                }
            }

            // ���p�ҕ��S�z��ݒ肷��B
            sub(map, "801021", new String[] { "801016", "801017", "801018",
                    "801019", "801020" });

            map.put("801022", "0");
            map.put("801023", "0");
            map.put("801024", "0");
            map.put("801025", "0");
            map.put("801026", "0");
            map.put("801028", "0");
            map.put("801029", "0");
            map.put("801031", "0");
            map.put("801032", "0");

            // [ID:0000605][Shin Fujihara] 2010/05 add begin 2009�N�x��Q�Ή�
            // �S�z���ȕ��S�̏ꍇ�́A���R�[�h�����ԍ���0�Ƃ��A
            // ���v���z�ւ̍��Z���s�Ȃ�Ȃ�
            if (toInt(map, "801017") + toInt(map, "801018")
                    + toInt(map, "801019") + toInt(map, "801020") <= 0) {
                map.put("801007", "0");
                continue;
            }
            map.put("801007", String.valueOf(count_801007));
            count_801007 += 1;

            // ��U�A���R�[�h�����ԍ�99�̃f�[�^�Ƃ��đޔ�
            nursingTotal = map;
            // [ID:0000605][Shin Fujihara] 2010/05 add end 2009�N�x��Q�Ή�

            // �W�v
            // ��p�z���v
            _801022 += toInt(map, "801016");
            // �ی��������z���v
            _801023 += toInt(map, "801017");
            // ���p�ҕ��S�z���v
            _801024 += toInt(map, "801021");

            // (����1)���S�z���v
            _801025 += toInt(map, "801018");
            // (����1)�����z
            _801026 += toInt(map, "801018");

            // (����2)���S�z���v
            _801028 += toInt(map, "801019");
            // (����2)�����z
            _801029 += toInt(map, "801019");

            // (����3)���S�z���v
            _801031 += toInt(map, "801020");
            // (����3)�����z
            _801032 += toInt(map, "801020");
        }

        // [ID:0000605][Shin Fujihara] 2010/05 edit begin 2009�N�x��Q�Ή�
        // map�ł͂Ȃ��AnursingTotal���g�p����悤�ύX
        // �W�v�����{���Ă��Ȃ���΁A�����I��
        if (nursingTotal == null) {
            return;
        }

        // ���R�[�h�����ԍ���99�ɐU��ւ�
        nursingTotal.put("801007", "99");

        // �e�X�̑��v��ݒ肷��
        nursingTotal.put("801022", String.valueOf(_801022));
        nursingTotal.put("801023", String.valueOf(_801023));
        nursingTotal.put("801024", String.valueOf(_801024));
        nursingTotal.put("801025", String.valueOf(_801025));
        nursingTotal.put("801026", String.valueOf(_801026));
        nursingTotal.put("801028", String.valueOf(_801028));
        nursingTotal.put("801029", String.valueOf(_801029));
        nursingTotal.put("801031", String.valueOf(_801031));
        nursingTotal.put("801032", String.valueOf(_801032));
        // [ID:0000605][Shin Fujihara] 2010/05 edit end 2009�N�x��Q�Ή�
    }
    
    
    //[ID:0000726][Shin Fujihara] 2012/04 add begin �������P���Z�̍ďW�v�Ή�
    /**
     * �������P���Z�̍ďW�v����
     * @throws Exception
     */
    private void parseImproveTheTreatment() throws Exception {
        
        List<VRMap> syogu = new ArrayList<VRMap>();
        VRMap map = null;

        for (int i = 0; i < detail.size(); i++) {
            map = (VRMap) detail.get(i);
            
            //�T�[�r�X���̂��擾
            String serviceName = ACCastUtilities.toString(map.get("301019"), "");
            
            //�u�u�������P�v�Ƃ��������񂪂�������A�������P���Z�Ƃ݂Ȃ��B
            if (serviceName.indexOf("�������P") != -1) {
                syogu.add(map);
            }
        }
        
        //�������P���Z�����݂��Ȃ��ꍇ�͏����I��
        if (syogu.isEmpty()) {
            return;
        }
        
        //�������P���Z�̌v�Z
        for (VRMap row : syogu) {
            
            //���Z�����擾
            VRMap servcie = getServcieCode(row);
            if (servcie == null) {
                continue;
            }
            
            String servcieCodeKind = ACCastUtilities.toString(row.get("301007"), "");
            
            //�Ή�����W�v��񃌃R�[�h���擾
            map = getType(servcieCodeKind);
            
            //�擾�Ɏ��s�����ꍇ�͏����I��
            if (map == null) {
                continue;
            }
            
            int[] unitArray = new int[4];
            //�K�v�Ȓl�𒊏o
            // (�ی�)�P�ʐ����v + (�ی����o������Ô�)�P�ʐ����v
            unitArray[0] = ACCastUtilities.toInt(map.get("701014"), 0) + ACCastUtilities.toInt(map.get("701027"), 0);
            //(����1)�P�ʐ����v + (����1���o������Ô�)�P�ʐ����v
            unitArray[1] = ACCastUtilities.toInt(map.get("701018"), 0) + ACCastUtilities.toInt(map.get("701030"), 0);
            //(����2)�P�ʐ����v + (����2���o������Ô�)�P�ʐ����v
            unitArray[2] = ACCastUtilities.toInt(map.get("701021"), 0) + ACCastUtilities.toInt(map.get("701033"), 0);
            //(����3)�P�ʐ����v + (����3���o������Ô�)�P�ʐ����v
            unitArray[3] = ACCastUtilities.toInt(map.get("701024"), 0) + ACCastUtilities.toInt(map.get("701036"), 0);
            
            
            //���ݏ������P���R�[�h�ɐݒ肳��Ă���l������
            //���ꂪ�A�������P���Z�Z��̌��ƂȂ�P�ʐ�
            // �T�[�r�X�P�ʐ�
            unitArray[0] -= ACCastUtilities.toInt(row.get("301014"), 0);
            //����1�ΏۃT�[�r�X�P�ʐ�
            unitArray[1] -= ACCastUtilities.toInt(row.get("301015"), 0);
            //����2�ΏۃT�[�r�X�P�ʐ�
            unitArray[2] -= ACCastUtilities.toInt(row.get("301016"), 0);
            //����3�ΏۃT�[�r�X�P�ʐ�
            unitArray[3] -= ACCastUtilities.toInt(row.get("301017"), 0);
            
            
            //�������P���Z���Čv�Z���A�ݒ�
            int serviceUnit = ACCastUtilities.toInt(servcie.get("SERVICE_UNIT"), 0);
            int serviceStaffUnit = ACCastUtilities.toInt(servcie.get("SERVICE_STAFF_UNIT"), 0);
            
            int _301014 = CareServiceCommon.calcSyogu(unitArray[0], serviceUnit, serviceStaffUnit);
            int _301015 = CareServiceCommon.calcSyogu(unitArray[1], serviceUnit, serviceStaffUnit);
            int _301016 = CareServiceCommon.calcSyogu(unitArray[2], serviceUnit, serviceStaffUnit);
            int _301017 = CareServiceCommon.calcSyogu(unitArray[3], serviceUnit, serviceStaffUnit);
            
            //�P�ʐ��̍Đݒ�
            row.put("301014", _301014);
            row.put("301009", _301014);
            
            row.put("301015", _301015);
            row.put("301016", _301016);
            row.put("301017", _301017);
            
            //����1��
            setSyoguKohiCount(row, _301015, "301011");
            //����2��
            setSyoguKohiCount(row, _301016, "301012");
            //����3��
            setSyoguKohiCount(row, _301017, "301013");
            
        }
        
        // �������P�̒l��ҏW�����̂ŁA�W�v��񃌃R�[�h���č쐬
        parseType();
        
    }
    
    private VRMap getType(String servcieCodeKind) throws Exception {
        
        if (type.isEmpty()) {
            return null;
        }
        
        VRMap map = null;
        
        for (Object row : type) {
            map = (VRMap)row;
            //�T�[�r�X��ރR�[�h���r
            //��v����ꍇ�͏����I��
            if (servcieCodeKind.equals(ACCastUtilities.toString(map.get("701007"), ""))) {
                return map;
            }
        }
        
        return null;
    }
    
    
    private VRMap getServcieCode(VRMap row) throws Exception {
        
        String systemServiceKind = ACCastUtilities.toString(row.get("301021"), "");
        String systemServiceItem = ACCastUtilities.toString(row.get("301022"), "");
        String target = VRDateParser.format(targetDate, "yyyy/MM/dd");
        
        StringBuilder sql = new StringBuilder();
        
        sql.append("SELECT * FROM M_SERVICE_CODE WHERE");
        sql.append("(SYSTEM_SERVICE_KIND_DETAIL = ");
        sql.append(systemServiceKind);
        sql.append(") AND (SYSTEM_SERVICE_CODE_ITEM = '");
        sql.append(systemServiceItem);
        sql.append("') AND (SERVICE_VALID_START <= '");
        sql.append(target);
        sql.append("') AND (SERVICE_VALID_END >= '");
        sql.append(target);
        sql.append("')");
        
        VRList list = dbm.executeQuery(sql.toString());
        if (list.isEmpty()) {
            return null;
        }
        
        return (VRMap)list.get(0);
    }
    
    private void setSyoguKohiCount(VRMap detail, int kohiUnit, String bindPath) throws Exception {
        if (0 < kohiUnit) {
            detail.put(bindPath, 1);
        } else {
            detail.put(bindPath, 0);
        }
    }
    
    //[ID:0000726][Shin Fujihara] 2012/04 add end
    

    /**
     * �W�v��񃌃R�[�h�̏W�v����
     * 
     * @throws Exception
     */
    private void parseType() throws Exception {

        // �W�v���̍��v���z����U�N���A
        for (int i = 0; i < type.size(); i++) {
            VRMap map = (VRMap) type.get(i);
            // �v��P�ʐ�
            // map.put("701009", "0");
            // ���x�z�Ǘ��ΏےP�ʐ�
            map.put("701010", "0");
            // ���x�z�Ǘ��ΏۊO�P�ʐ�
            map.put("701011", "0");
            // �ی��P�ʐ����v
            map.put("701014", "0");
            // (����1)�P�ʐ����v
            map.put("701018", "0");
            // ����P�����z
            map.put("701019", "0");
            // ����P�{�l���S�z
            map.put("701020", "0");
            // (����2)�P�ʐ����v
            map.put("701021", "0");
            // ����Q�����z
            map.put("701022", "0");
            // ����Q�{�l���S�z
            map.put("701023", "0");
            // (����3)�P�ʐ����v
            map.put("701024", "0");
            // ����R�����z��0�Ƃ���
            map.put("701025", "0");
            // ����R�{�l���S�z
            map.put("701026", "0");
            // (�ی����o������Ô�)�P�ʐ����v
            map.put("701027", "0");
            // (�ی����o������Ô�)�����z9��
            map.put("701028", "0");
            // (�ی����o������Ô�)�o������Ô�p�ҕ��S�z8��
            map.put("701029", "0");
            // (����1���o������Ô�)�P�ʐ����v8��
            map.put("701030", "0");
            // (����1���o������Ô�)�����z9��
            map.put("701031", "0");
            // (����1���o������Ô�)�o������Ô�{�l���S�z8��
            map.put("701032", "0");
            // (����2���o������Ô�)�P�ʐ����v8��
            map.put("701033", "0");
            // (����2���o������Ô�)�����z9��
            map.put("701034", "0");
            // (����2���o������Ô�)�o������Ô�{�l���S�z8��
            map.put("701035", "0");
            // (����3���o������Ô�)�P�ʐ����v8��
            map.put("701036", "0");
            // (����3���o������Ô�)�����z9��
            map.put("701037", "0");
            // (����3���o������Ô�)�o������Ô�{�l���S�z8��
            map.put("701038", "0");

        }

        /* ====================================================== */
        // ���׏����W�v���ɂ܂Ƃ߂�
        /* ====================================================== */
        int toolsTotalDay = Integer.MIN_VALUE;
        int toolsTotalDayYobo = Integer.MIN_VALUE;
        //�O�����p�^�g�p�t���O
        boolean externalUse = false;
        for (int i = 0; i < detail.size(); i++) {
            VRMap map = (VRMap) detail.get(i);
            VRMap tmap = getTypeMap(toString(map, "301007"));
            if (tmap == null) {
                continue;
            }

            // ���x�z�Ǘ��Ώۃt���O
            switch (toInt(map, "301020")) {
            // 1(���x�z�Ǘ��Ώ�)�̏ꍇ
            case 1:
                // �v��P�ʐ�
                // addAppend(tmap, "701009", map, "301014");
                // ���x�z�Ǘ��ΏےP�ʐ�
                addAppend(tmap, "701010", map, "301014");
                break;
            // 2(���x�z�Ǘ��ΏۊO)�̏ꍇ
            case 2:
                // ���x�z�Ǘ��ΏۊO�P�ʐ�
                addAppend(tmap, "701011", map, "301014");
                break;
            // 3(�O�����p�^)�̏ꍇ
            case 3:
                // �v��P�ʐ�(�����Ƃ��Ă����H)
                // set_701009(ACCastUtilities.toInt(patientState.getNinteiDataHeavy(get_701005(),get_701006(),"EXTERNAL_USE_LIMIT"),0));
                // ���x�z�Ǘ��ΏےP�ʐ�
                addAppend(tmap, "701010", map, "301014");
                externalUse = true;
                break;
            }

            // �ی��P�ʐ����v
            addAppend(tmap, "701014", map, "301014");
            // (����1)�P�ʐ����v
            addAppend(tmap, "701018", map, "301015");
            // (����2)�P�ʐ����v
            addAppend(tmap, "701021", map, "301016");
            // (����3)�P�ʐ����v
            addAppend(tmap, "701024", map, "301017");

            // �����p���O����
            switch (toInt(map, "301007")) {
            // �����p��
            case 17:
                if (toolsTotalDay < toInt(map, "301010")) {
                    tmap.put("701008", map.get("301010"));
                    toolsTotalDay = toInt(map, "301010");
                }
                break;
            // �\�h�����p��
            case 67:
                if (toolsTotalDayYobo < toInt(map, "301010")) {
                    tmap.put("701008", map.get("301010"));
                    toolsTotalDayYobo = toInt(map, "301010");
                }
                break;
            }
        }
        

        /* ====================================================== */
        // �W�v��񃌃R�[�h���g�̊m��
        /* ====================================================== */

        for (int i = 0; i < type.size(); i++) {
            VRMap map = (VRMap) type.get(i);

            // ���x�z�Ǘ��ΏےP�ʐ��ƌ��x�z�Ǘ��ΏۊO�P�ʐ���0�Ȃ�A�W�v���R�[�h���̂��폜
            if ((toInt(map, "701010") == 0) && (toInt(map, "701011") == 0)) {
                type.remove(i);
                i--;
                continue;
            }
            
            // [ID:0000576]�v��P�ʐ��㏑���t���O���m�F
            // �m�肵�Ă���v��P�ʐ��Ƃ��āA���x�z�Ǘ��ΏےP�ʐ���ݒ肷��
            // ���������Ă����Ȃ��ƁA
            // ���׃��R�[�h�폜=>�����ďW�v�Ō��x�z�ΏےP�ʐ����̗p
            // �i�ł��A701046�̃f�[�^�͎c��j
            // ��ʂ��J���Ȃ����āA�ďW�v�{�^��������
            // 701046�̃f�[�^���c���Ă���̂ŁA�ȑO�̌v��P�ʐ����̗p����Ă��܂�
            if (isPlanOverwrite) {
                map.put("701046", map.get("701010"));
            }

            // �v��P�ʐ�
            // ���яW�v���A�m�肵�Ă���v��P�ʐ������݂��Ȃ��ꍇ
            if (ACTextUtilities.isNullText(map.get("701046"))) {
                // ���x�z�Ǘ��ΏےP�ʐ����v��P�ʐ��Ƃ���
                map.put("701009", map.get("701010"));
            } else {
                map.put("701009", map.get("701046"));
            }

            // �v��P�ʐ��ƌ��x�z�ΏۊǗ����̏��Ȃ��ق����̗p����
            if (toInt(map, "701009") < toInt(map, "701010")) {
                map.put("701014",
                        String.valueOf(toInt(map, "701009")
                                + toInt(map, "701011")));
            } else {
                map.put("701014",
                        String.valueOf(toInt(map, "701010")
                                + toInt(map, "701011")));
            }

            // ���ےP��
            if (QP001SpecialCase.isSeihoOnly(toString(map, "701006"))) {
                map.put("701016", "0");
            } else {
                // �ΏےP�ʐ��~�P�ʐ��P��(�����_�ȉ��؎̂�)
                int totalUnit = (int) Math
                        .floor((double) (toInt(map, "701014") * getMultiplies100(
                                map, "701015")) / 100d);
                // �ی����t��
                totalUnit = (int) Math.floor((totalUnit * getRate()) / 100d);
                map.put("701016", String.valueOf(totalUnit));
            }

            // ����̒P�ʐ��m��
            // �v��P�ʐ� < ���x�z�Ǘ��ΏےP�ʐ��̏ꍇ�A�ی��P�ʐ� < ����P�ʐ���
            // �Ȃ��Ă��܂����߁A�␳���s��
            int _701014 = ACCastUtilities.toInt(map.get("701014"), 0);

            // ����P�P�ʐ��m�F
            if (_701014 < ACCastUtilities.toInt(map.get("701018"), 0)) {
                map.put("701018", map.get("701014"));
            }
            // ����Q�P�ʐ��m�F
            if (_701014 < ACCastUtilities.toInt(map.get("701021"), 0)) {
                map.put("701021", map.get("701014"));
            }
            // ����R�P�ʐ��m�F
            if (_701014 < ACCastUtilities.toInt(map.get("701024"), 0)) {
                map.put("701024", map.get("701014"));
            }

            // ����Z��
            int kohiClaim = 0;
            int reduction = 0;
            // ���t���擾
            int usedRate = getRate();

            boolean kohiEnd = false;

            // ����P�̓K�p����
            if ((getKohiRate(1) != 0) && (toInt(map, "701018") != 0)) {
                kohiClaim = getKohiClaim(map, toInt(map, "701018"),
                        getKohiRate(1), 0, usedRate);
                reduction += kohiClaim;
                // ((����1)�����z)�ɒl��ݒ肷��B
                map.put("701019",
                        String.valueOf(toInt(map, "701019") + kohiClaim));
                // �K�p���������ޔ�����B
                usedRate = getKohiRate(1);
                // ����1�̋��t����100%�̏ꍇ�������I������B
                if (getKohiRate(1) == 100)
                    kohiEnd = true;
            }
            // ����Q�̓K�p����
            if (!kohiEnd && (getKohiRate(2) != 0)
                    && (toInt(map, "701021") != 0)) {
                if (getKohiRate(2) > usedRate) {
                    kohiClaim = getKohiClaim(map, toInt(map, "701021"),
                            getKohiRate(2), reduction, usedRate);
                    reduction += kohiClaim;
                    // ((����2)�����z)�ɒl��ݒ肷��B
                    map.put("701022",
                            String.valueOf(toInt(map, "701022") + kohiClaim));
                    // �K�p���������ޔ�����B
                    usedRate = getKohiRate(2);
                    if (getKohiRate(2) == 100)
                        kohiEnd = true;
                }
            }

            // ����R�̓K�p����
            if (!kohiEnd && (getKohiRate(3) != 0)
                    && (toInt(map, "701024") != 0)) {
                if (getKohiRate(3) > usedRate) {
                    kohiClaim = getKohiClaim(map, toInt(map, "701024"),
                            getKohiRate(3), reduction, usedRate);
                    reduction += kohiClaim;
                    // ((����3)�����z)�ɒl��ݒ肷��B
                    map.put("701025",
                            String.valueOf(toInt(map, "701025") + kohiClaim));
                }
            }

            // ����{�l���S�z�̎Z��
            int selfPay = 0;
            int kohiCost = 0;
            // ����P�̓K�p����
            if (getKohiRate(1) != 0) {
                selfPay = patientState.getKohiSelfPay(getKohiType(1), 1);
                if (selfPay != 0) {
                    // �l���攪�A���A��\�̏ꍇ�Ŋ����ےP�Ǝ҂Ŗ����ꍇ�́A���ȕ��S�z�̎g�p�ɐ�����������
                    kohiCost = 0;
                    if (nursingTotal != null) {
                        kohiCost = toInt(nursingTotal, "801026");
                    }

                    selfPay = QP001SpecialCase.convertSelfPay(
                            toString(map, "701001"), toString(map, "701006"),
                            selfPay, getKohiType(1), kohiCost);

                    // ����P�����z�Ɩ{�l���S�z���r���A�{�l���S�z���傫���ꍇ
                    if (toInt(map, "701019") < selfPay) {
                        // ����P�{�l���S�z�Ɍ���P�����z��ݒ肷��
                        map.put("701020", map.get("701019"));
                        // ����P�����z��0�Ƃ���
                        map.put("701019", "0");
                        // �g�p��������ȕ��S�z��ݒ肷��B
                        patientState.setKohiSelfPayUse(getKohiType(1),
                                toInt(map, "701020"));
                    } else {
                        map.put("701020", String.valueOf(selfPay));
                        sub(map, "701019", new String[] { "701019", "701020" });
                        // �g�p��������ȕ��S�z��ݒ肷��B
                        patientState.setKohiSelfPayUse(getKohiType(1), selfPay);
                    }

                }
            }

            // ����Q�̖{�l���S�z���擾
            if (getKohiRate(2) != 0) {
                selfPay = patientState.getKohiSelfPay(getKohiType(2), 1);
                if (selfPay != 0) {
                    kohiCost = 0;
                    if (nursingTotal != null) {
                        kohiCost = toInt(nursingTotal, "801029");
                    }

                    selfPay = QP001SpecialCase.convertSelfPay(
                            toString(map, "701001"), toString(map, "701006"),
                            selfPay, getKohiType(2), kohiCost);

                    // ����Q�����z�Ɩ{�l���S�z���r���A�{�l���S���傫���ꍇ
                    if (toInt(map, "701022") < selfPay) {
                        // ����Q�{�l���S�z�Ɍ���Q�����z��ݒ肷��B
                        map.put("701023", map.get("701022"));
                        // ����Q�����z��0�Ƃ���
                        map.put("701022", "0");
                        // �g�p��������ȕ��S�z��ݒ肷��B
                        patientState.setKohiSelfPayUse(getKohiType(2),
                                toInt(map, "701023"));

                    } else {
                        map.put("701023", String.valueOf(selfPay));
                        sub(map, "701022", new String[] { "701022", "701023" });
                        // �g�p��������ȕ��S�z��ݒ肷��B
                        patientState.setKohiSelfPayUse(getKohiType(2), selfPay);
                    }
                }

                // ����R�̖{�l���S�z���擾
                if (getKohiRate(3) != 0) {
                    selfPay = patientState.getKohiSelfPay(getKohiType(3), 1);
                    if (selfPay != 0) {
                        kohiCost = 0;
                        if (nursingTotal != null) {
                            kohiCost = toInt(nursingTotal, "801032");
                        }

                        selfPay = QP001SpecialCase.convertSelfPay(
                                toString(map, "701001"),
                                toString(map, "701006"), selfPay,
                                getKohiType(3), kohiCost);

                        // ����R�����z�Ɩ{�l���S�z���r���A�{�l���S���傫���ꍇ
                        if (toInt(map, "701025") < selfPay) {
                            // ����R�{�l���S�z�Ɍ���R�����z��ݒ肷��B
                            map.put("701026", map.get("701025"));
                            // ����R�����z��0�Ƃ���
                            map.put("701025", "0");
                            // �g�p��������ȕ��S�z��ݒ肷��B
                            patientState.setKohiSelfPayUse(getKohiType(3),
                                    toInt(map, "701026"));

                        } else {
                            map.put("701026", String.valueOf(selfPay));
                            sub(map, "701025", new String[] { "701025",
                                    "701026" });
                            // �g�p��������ȕ��S�z��ݒ肷��B
                            patientState.setKohiSelfPayUse(getKohiType(3),
                                    selfPay);
                        }
                    }
                }

            }

            // ���p�ҕ��S�z�̊m����s���B
            // ���z-���ی����S-����P-����Q-����R-����P�{�l���S-����Q�{�l���S-����R�{�l���S
            map.put("701017", String.valueOf((int) Math.floor((double) (toInt(
                    map, "701014") * getMultiplies100(map, "701015")) / 100d)));
            sub(map, "701017", new String[] { "701017", "701016", "701019",
                    "701022", "701025", "701020", "701023", "701026" });
            
            
            // �l����Z�̎O�A�l����Z�̎l�̗�O����
            String identificationNo = ACCastUtilities.toString(map.get("701001"), ""); 
            if (QP001StyleAbstract.IDENTIFICATION_NO_6_3_201204.equals(identificationNo)
                || QP001StyleAbstract.IDENTIFICATION_NO_6_4_201204.equals(identificationNo)) {
                
                //�O�����p�^���g�p�̏ꍇ
                if (!externalUse) {
                    //���x�z�Ǘ��ΏۊO�P�ʐ���0�ɂ���
                    map.put("701011", "0");
                }
            }
        }

        /* ====================================================== */
        // ����f�Ô��񃌃R�[�h���W�v���ɂ܂Ƃ߂�
        /* ====================================================== */
        for (int i = 0; i < diagnosis.size(); i++) {
            VRMap map = (VRMap) diagnosis.get(i);
            // ���R�[�h�����ԍ���99�̂��̂��̗p
            if (toInt(map, "501007") != 99) {
                continue;
            }
            // �m�菈��
            commitDiagnosis(map);
            break;
        }

        /* ====================================================== */
        // �ً}����񃌃R�[�h�̌�����W�v���ɂ܂Ƃ߂�
        /* ====================================================== */
        if (type.size() == 1) {
            VRMap map = (VRMap) type.get(0);

            String identity = toString(map, "701001");
            // ���̏����ɓ���ꍇ�́A�W�v��񃌃R�[�h��1���R�[�h�̏ꍇ�̂�
            if (QP001StyleAbstract.IDENTIFICATION_NO_4_201204.equals(identity)
                    || QP001StyleAbstract.IDENTIFICATION_NO_4_2_201204.equals(identity)) {
                // �l����l�A
                // �m�菈�����s
                commitEmergency(map);
                
            
            } else if (QP001StyleAbstract.IDENTIFICATION_NO_9_201204.equals(identity)) {
                // ���̏ꍇ�A�ً}�����ÊǗ��E���{�ݗ×{��̊m�菈��
                commitEmergencyOwnFacility(map);
                
            }
        }

        /* ====================================================== */
        // ����ȕ��S�z�m��
        /* ====================================================== */
        for (int i = 0; i < type.size(); i++) {
            VRMap map = (VRMap) type.get(i);
            commitSeflPay(map);
        }

        // ����ȕ��S�z�̎Z��
        if (nursingTotal == null) {
            return;
        }

        // �l���攪�A���A��\�ȊO�̏ꍇ�͏����𒆒f����B
        if (!QP001SpecialCase.isShisetsuDiscriminationNo(toString(nursingTotal,
                "801001"))) {
            return;
        }

        // ����P�̓K�p�����邩�m�F
        if (getKohiRate(1) != 0) {
            // ����P���ȕ��S�z�̐ݒ���s���B
            int selfPay = patientState.getKohiSelfPay(getKohiType(1), 1);
            // ����ȕ��S�z�̕����傫�����
            if (toInt(nursingTotal, "801026") < selfPay) {
                // (����1)�{�l���S�z5���ɐ����z��ݒ肷��B
                nursingTotal.put("801027", nursingTotal.get("801026"));
                // ����1�����z��0�ɐݒ肷��B
                nursingTotal.put("801026", "0");
                // �g�p�������ȕ��S��񍐂���B
                patientState.setKohiSelfPayUse(getKohiType(1),
                        toInt(nursingTotal, "801027"));

            } else {
                // ����P�����z�������ȕ��S�������Z����
                nursingTotal
                        .put("801026",
                                String.valueOf(toInt(nursingTotal, "801026")
                                        - selfPay));
                // ����P���ȕ��S�z��ݒ肷��B
                nursingTotal.put("801027", String.valueOf(selfPay));
                // �g�p�������ȕ��S��񍐂���B
                patientState.setKohiSelfPayUse(getKohiType(1), selfPay);
            }
        }

        // ����Q�̓K�p�����邩�m�F
        if (getKohiRate(2) != 0) {
            // ����Q���ȕ��S�z�̐ݒ���s���B
            int selfPay = patientState.getKohiSelfPay(getKohiType(2), 1);
            // ����ȕ��S�z�̕����傫�����
            if (toInt(nursingTotal, "801029") < selfPay) {
                // (����2)�{�l���S�z5���ɐ����z��ݒ肷��B
                nursingTotal.put("801030", nursingTotal.get("801029"));
                // ����2�����z��0�ɐݒ肷��B
                nursingTotal.put("801029", "0");
                // �g�p�������ȕ��S��񍐂���B
                patientState.setKohiSelfPayUse(getKohiType(2),
                        toInt(nursingTotal, "801030"));

            } else {
                // ����Q�����z�������ȕ��S�������Z����
                nursingTotal
                        .put("801029",
                                String.valueOf(toInt(nursingTotal, "801029")
                                        - selfPay));
                // ����Q���ȕ��S�z��ݒ肷��B
                nursingTotal.put("801030", String.valueOf(selfPay));
                // �g�p�������ȕ��S��񍐂���B
                patientState.setKohiSelfPayUse(getKohiType(2), selfPay);
            }
        }

        // ����R�̓K�p�����邩�m�F
        if (getKohiRate(3) != 0) {
            // ����R���ȕ��S�z�̐ݒ���s���B
            int selfPay = patientState.getKohiSelfPay(getKohiType(3), 1);
            // ����ȕ��S�z�̕����傫�����
            if (toInt(nursingTotal, "801032") < selfPay) {
                // (����3)�{�l���S�z5���ɐ����z��ݒ肷��B
                nursingTotal.put("801033", nursingTotal.get("801032"));
                // ����3�����z��0�ɐݒ肷��B
                nursingTotal.put("801032", "0");
                // �g�p�������ȕ��S��񍐂���B
                patientState.setKohiSelfPayUse(getKohiType(3),
                        toInt(nursingTotal, "801031"));

            } else {
                // ����R�����z�������ȕ��S�������Z����
                nursingTotal
                        .put("801032",
                                String.valueOf(toInt(nursingTotal, "801032")
                                        - selfPay));
                // ����R���ȕ��S�z��ݒ肷��B
                nursingTotal.put("801033", String.valueOf(selfPay));
                // �g�p�������ȕ��S��񍐂���B
                patientState.setKohiSelfPayUse(getKohiType(3), selfPay);
            }
        }
    }

    /**
     * ����f�Ô��񃌃R�[�h�̓��e���A�W�v��񃌃R�[�h�ɔ��f����B
     * 
     * @param map
     * @throws Exception
     */
    private void commitDiagnosis(VRMap map) throws Exception {

        VRMap tmap = (VRMap) type.get(0);

        // (�ی����o������Ô�)�P�ʐ����v
        tmap.put("701027", map.get("501013"));

        // ���ےP�Ƃ̏ꍇ
        if (QP001SpecialCase.isSeihoOnly(toString(tmap, "701005"))) {
            tmap.put("701028", "0");
            baseCache.put("201037", "0");
        } else {
            tmap.put("701028", String.valueOf((int) Math.floor((double) (toInt(
                    tmap, "701027") * 10 * getRate()) / 100d)));
            baseCache.put("201037", tmap.get("701028"));
        }
        // (����1���o������Ô�)�P�ʐ����v
        tmap.put("701030", map.get("501016"));
        // (����2���o������Ô�)�P�ʐ����v
        tmap.put("701033", map.get("501019"));
        // (����3���o������Ô�)�P�ʐ����v
        tmap.put("701036", map.get("501022"));

        // �����p�v�Z
        int totalRate = toInt(tmap, "701027") * 10;
        int amendsRate = getRate();

        // ����1�̓K�p����
        if (getKohiRate(1) != 0) {
            // ���r��������^��
            if (toInt(tmap, "701027") == toInt(tmap, "701030")) {
                // ���r������Ȃ�
                // ���t��100
                if (getKohiRate(1) == 100) {
                    // ���z��Í��v���z-�ی������z
                    // sub(tmap, "701031", new String[]{"701027", "701028"});
                    tmap.put("701031",
                            String.valueOf(totalRate - toInt(tmap, "701028")));

                } else {
                    tmap.put(
                            "701031",
                            String.valueOf((int) Math.floor(totalRate
                                    * (getKohiRate(1) - getRate()) / 100)));
                }

            } else {
                // ���r�������
                tmap.put(
                        "701031",
                        String.valueOf((int) Math.floor(toInt(tmap, "701030")
                                * 10 * (getKohiRate(1) - amendsRate) / 100)));
                amendsRate = getKohiRate(1);
            }
            baseCache.put("201043", tmap.get("701031"));
        }

        // ����̑ΏۂƂȂ鎩�ȕ��S�z���c���Ă��邩�m�F
        if (totalRate >= (toInt(tmap, "701028") + toInt(tmap, "701031"))) {
            // ����2�̓K�p������ꍇ
            if (getKohiRate(2) != 0) {
                // ���r��������^��
                if (toInt(tmap, "701027") == toInt(tmap, "701033")) {
                    // ���r������Ȃ�
                    // ���t��100
                    if (getKohiRate(2) == 100) {
                        tmap.put(
                                "701034",
                                String.valueOf(totalRate
                                        - toInt(tmap, "701028")
                                        - toInt(tmap, "701031")));
                    } else {
                        tmap.put(
                                "701034",
                                String.valueOf((int) Math.floor(totalRate
                                        * (getKohiRate(2) - getKohiRate(1))
                                        / 100)));
                    }

                } else {
                    // ���r�������
                    tmap.put("701034", String.valueOf((int) Math.floor(toInt(
                            tmap, "701033")
                            * 10
                            * (getKohiRate(2) - amendsRate) / 100)));
                    amendsRate = getKohiRate(2);
                }
                baseCache.put("201049", tmap.get("701034"));
            }
        }
        // ����̑ΏۂƂȂ鎩�ȕ��S���c���Ă��邩�m�F
        if (totalRate >= (toInt(tmap, "701028") + toInt(tmap, "701031") + toInt(
                tmap, "701034"))) {
            // ����2�̓K�p������ꍇ
            if (getKohiRate(3) != 0) {
                // ���r��������^��
                if (toInt(tmap, "701027") == toInt(tmap, "701036")) {
                    // ���r������Ȃ�
                    // ���t��100
                    if (getKohiRate(3) == 100) {
                        tmap.put(
                                "701037",
                                String.valueOf(totalRate
                                        - toInt(tmap, "701028")
                                        - toInt(tmap, "701031")
                                        - toInt(tmap, "701034")));
                    } else {
                        tmap.put(
                                "701037",
                                String.valueOf((int) Math.floor(totalRate
                                        * (getKohiRate(3) - getKohiRate(2))
                                        / 100)));
                    }

                } else {
                    // ���r�������
                    tmap.put("701037", String.valueOf((int) Math.floor(toInt(
                            tmap, "701036")
                            * 10
                            * (getKohiRate(3) - amendsRate) / 100)));
                }
                baseCache.put("201055", tmap.get("701037"));
            }
        }
    }

    /**
     * �ً}�����Êm�菈��
     * 
     * @param tmap
     *            ��{��񃌃R�[�h
     * @throws Exception
     */
    private void commitEmergency(VRMap tmap) throws Exception {

        VRMap map = null;

        for (int i = 0; i < emergency.size(); i++) {
            map = (VRMap) emergency.get(i);
            // ���R�[�h�����ԍ���99�̂��̂��̗p
            if (toInt(map, "401007") == 99) {
                break;
            }
        }

        // ���R�[�h�����ԍ�99�̃��R�[�h�����݂��Ȃ�
        // �����I��
        if (map == null) {
            return;
        }

        int _701028 = 0;
        // (�ی����o������Ô�)�P�ʐ����v
        addAppend(tmap, "701027", map, "401046");

        // ����P�Ǝ󋋎҂̏ꍇ
        if (QP001SpecialCase.isSeihoOnly(toString(tmap, "701005"))) {
            // (�ی����o������Ô�)�����z 0��ݒ肷��B
            baseCache.put("201036", "0");
        } else {
            // (�ی����o������Ô�)�����z���Z�o����B
            _701028 = (int) Math
                    .floor((double) (toInt(map, "401046") * 10 * getRate()) / 100d);
            baseCache.put("201036", String.valueOf(_701028));
        }
        addAppend(tmap, "701028", baseCache, "201036");

        // �����p�v�Z
        // �ی����o������ÒP�ʐ����v
        int totalRate = toInt(map, "401046") * 10;
        int amendsRate = getRate();

        // �����r������͍l�����Ȃ�
        // ����1�̓K�p����
        if ((getKohiRate(1) != 0) && emergencyKohi.contains(getKohiType(1))) {

            // (����1���o������Ô�)�P�ʐ����v
            addAppend(tmap, "701030", map, "401046");
            // ���t��100
            if (getKohiRate(1) == 100) {
                baseCache.put("201042", String.valueOf(totalRate - _701028));
            } else {
                baseCache.put(
                        "201042",
                        String.valueOf((int) Math.floor(totalRate
                                * (getKohiRate(1) - getRate()) / 100)));
            }
            addAppend(tmap, "701031", baseCache, "201042");
            amendsRate = getKohiRate(1);
        }

        // ����2�̓K�p����
        if ((getKohiRate(2) != 0) && (amendsRate < getKohiRate(2))
                && emergencyKohi.contains(getKohiType(2))) {

            // (����2���o������Ô�)�P�ʐ����v
            addAppend(tmap, "701033", map, "401046");
            // ���t��100
            if (getKohiRate(2) == 100) {
                baseCache.put(
                        "201048",
                        String.valueOf(totalRate - _701028
                                - toInt(baseCache, "201042")));
            } else {
                baseCache.put(
                        "201048",
                        String.valueOf((int) Math.floor(totalRate
                                * (getKohiRate(2) - amendsRate) / 100)));
            }
            addAppend(tmap, "701034", baseCache, "201048");
            amendsRate = getKohiRate(2);
        }

        // ����3�̓K�p����
        if ((getKohiRate(3) != 0) && (amendsRate < getKohiRate(3))
                && emergencyKohi.contains(getKohiType(3))) {

            // (����3���o������Ô�)�P�ʐ����v
            addAppend(tmap, "701036", map, "401046");
            // ���t��100
            if (getKohiRate(3) == 100) {
                baseCache.put(
                        "201054",
                        String.valueOf(totalRate - _701028
                                - toInt(baseCache, "201042")
                                - toInt(baseCache, "201048")));
            } else {
                baseCache.put(
                        "201054",
                        String.valueOf((int) Math.floor(totalRate
                                * (getKohiRate(3) - amendsRate) / 100)));
            }
            addAppend(tmap, "701037", baseCache, "201054");
            amendsRate = getKohiRate(1);
        }

    }
    
    
    
    /**
     * �ً}�����ÁE���{�ݗ×{��m�菈��
     * 
     * @param tmap
     *            ��{��񃌃R�[�h
     * @throws Exception
     */
    private void commitEmergencyOwnFacility(VRMap tmap) throws Exception {

        VRMap map = null;

        for (int i = 0; i < emergencyOwnFacility.size(); i++) {
            map = (VRMap) emergencyOwnFacility.get(i);
            // ���R�[�h�����ԍ���99�̂��̂��̗p
            if (toInt(map, "1701007") == 99) {
                break;
            }
        }

        // ���R�[�h�����ԍ�99�̃��R�[�h�����݂��Ȃ�
        // �����I��
        if (map == null) {
            return;
        }

        int _701028 = 0;
        // (�ی����o������Ô�)�P�ʐ����v
        addAppend(tmap, "701027", map, "1701046");

        // ����P�Ǝ󋋎҂̏ꍇ
        if (QP001SpecialCase.isSeihoOnly(toString(tmap, "701005"))) {
            // (�ی����o������Ô�)�����z 0��ݒ肷��B
            baseCache.put("201036", "0");
        } else {
            // (�ی����o������Ô�)�����z���Z�o����B
            _701028 = (int) Math
                    .floor((double) (toInt(map, "1701046") * 10 * getRate()) / 100d);
            baseCache.put("201036", String.valueOf(_701028));
        }
        addAppend(tmap, "701028", baseCache, "201036");

        // �����p�v�Z
        // �ی����o������ÒP�ʐ����v
        int totalRate = toInt(map, "1701046") * 10;
        int amendsRate = getRate();

        // �����r������͍l�����Ȃ�
        // ����1�̓K�p����
        if ((getKohiRate(1) != 0) && emergencyKohi.contains(getKohiType(1))) {

            // (����1���o������Ô�)�P�ʐ����v
            addAppend(tmap, "701030", map, "1701046");
            // ���t��100
            if (getKohiRate(1) == 100) {
                baseCache.put("201042", String.valueOf(totalRate - _701028));
            } else {
                baseCache.put(
                        "201042",
                        String.valueOf((int) Math.floor(totalRate
                                * (getKohiRate(1) - getRate()) / 100)));
            }
            addAppend(tmap, "701031", baseCache, "201042");
            amendsRate = getKohiRate(1);
        }

        // ����2�̓K�p����
        if ((getKohiRate(2) != 0) && (amendsRate < getKohiRate(2))
                && emergencyKohi.contains(getKohiType(2))) {

            // (����2���o������Ô�)�P�ʐ����v
            addAppend(tmap, "701033", map, "1701046");
            // ���t��100
            if (getKohiRate(2) == 100) {
                baseCache.put(
                        "201048",
                        String.valueOf(totalRate - _701028
                                - toInt(baseCache, "201042")));
            } else {
                baseCache.put(
                        "201048",
                        String.valueOf((int) Math.floor(totalRate
                                * (getKohiRate(2) - amendsRate) / 100)));
            }
            addAppend(tmap, "701034", baseCache, "201048");
            amendsRate = getKohiRate(2);
        }

        // ����3�̓K�p����
        if ((getKohiRate(3) != 0) && (amendsRate < getKohiRate(3))
                && emergencyKohi.contains(getKohiType(3))) {

            // (����3���o������Ô�)�P�ʐ����v
            addAppend(tmap, "701036", map, "1701046");
            // ���t��100
            if (getKohiRate(3) == 100) {
                baseCache.put(
                        "201054",
                        String.valueOf(totalRate - _701028
                                - toInt(baseCache, "201042")
                                - toInt(baseCache, "201048")));
            } else {
                baseCache.put(
                        "201054",
                        String.valueOf((int) Math.floor(totalRate
                                * (getKohiRate(3) - amendsRate) / 100)));
            }
            addAppend(tmap, "701037", baseCache, "201054");
            amendsRate = getKohiRate(1);
        }

    }

    /**
     * ����ȕ��S�z�̎Z��
     * 
     * @param tmap
     * @throws Exception
     */
    private void commitSeflPay(VRMap tmap) throws Exception {

        // ����{�l���S�z�̎Z�o���s��
        int selfPay = 0;
        // ����P�̖{�l���S�z
        if (toInt(tmap, "701031") != 0) {
            selfPay = patientState.getKohiSelfPay(getKohiType(1), 1);
            if (selfPay != 0) {
                selfPay = QP001SpecialCase.getApplicationIndividualPayment(
                        toString(tmap, "701001"), toString(tmap, "701006"),
                        selfPay, toInt(tmap, "701020"), getKohiType(1),
                        nursingTotal);

                // ����P�����z�Ɩ{�l���S�z���r���A�{�l���S�z���傫���ꍇ
                if (toInt(tmap, "701031") < selfPay) {
                    // ����P�{�l���S�z�Ɍ���P�����z��ݒ肷��
                    tmap.put("701032", tmap.get("701031"));
                    // ����P�����z��0�Ƃ���
                    tmap.put("701031", "0");
                    // �g�p��������ȕ��S�z��ݒ肷��B
                    patientState.setKohiSelfPayUse(getKohiType(1),
                            toInt(tmap, "701032"));

                } else {
                    tmap.put("701032", String.valueOf(selfPay));
                    sub(tmap, "701031", new String[] { "701031", "701032" });
                    // �g�p��������ȕ��S�z��ݒ肷��B
                    patientState.setKohiSelfPayUse(getKohiType(1), selfPay);
                }

                // �����z���痘�p�ҕ��S�z����������
                subAmountClaimed("701032", selfPay);
            }
        }

        // ����Q�̖{�l���S�z���擾
        if (toInt(tmap, "701034") != 0) {
            selfPay = patientState.getKohiSelfPay(getKohiType(2), 1);
            if (selfPay != 0) {
                selfPay = QP001SpecialCase.getApplicationIndividualPayment(
                        toString(tmap, "701001"), toString(tmap, "701006"),
                        selfPay, toInt(tmap, "701023"), getKohiType(2),
                        nursingTotal);

                // ����Q�����z�Ɩ{�l���S�z���r���A�{�l���S�z���傫���ꍇ
                if (toInt(tmap, "701034") < selfPay) {
                    // ����Q�{�l���S�z�Ɍ���Q�����z��ݒ肷��
                    tmap.put("701035", tmap.get("701034"));
                    // ����Q�����z��0�Ƃ���
                    tmap.put("701034", "0");
                    // �g�p��������ȕ��S�z��ݒ肷��B
                    patientState.setKohiSelfPayUse(getKohiType(2),
                            toInt(tmap, "701035"));

                } else {
                    tmap.put("701035", String.valueOf(selfPay));
                    sub(tmap, "701034", new String[] { "701034", "701035" });
                    // �g�p��������ȕ��S�z��ݒ肷��B
                    patientState.setKohiSelfPayUse(getKohiType(2), selfPay);
                }

                // �����z���痘�p�ҕ��S�z����������
                subAmountClaimed("701035", selfPay);
            }
        }

        // ����R�̖{�l���S�z���擾
        if (toInt(tmap, "701037") != 0) {
            selfPay = patientState.getKohiSelfPay(getKohiType(3), 1);
            if (selfPay != 0) {
                selfPay = QP001SpecialCase.getApplicationIndividualPayment(
                        toString(tmap, "701001"), toString(tmap, "701006"),
                        selfPay, toInt(tmap, "701026"), getKohiType(3),
                        nursingTotal);

                // ����R�����z�Ɩ{�l���S�z���r���A�{�l���S�z���傫���ꍇ
                if (toInt(tmap, "701037") < selfPay) {
                    // ����R�{�l���S�z�Ɍ���R�����z��ݒ肷��
                    tmap.put("701038", tmap.get("701037"));
                    // ����R�����z��0�Ƃ���
                    tmap.put("701037", "0");
                    // �g�p��������ȕ��S�z��ݒ肷��B
                    patientState.setKohiSelfPayUse(getKohiType(3),
                            toInt(tmap, "701038"));

                } else {
                    tmap.put("701038", String.valueOf(selfPay));
                    sub(tmap, "701037", new String[] { "701037", "701038" });
                    // �g�p��������ȕ��S�z��ݒ肷��B
                    patientState.setKohiSelfPayUse(getKohiType(3), selfPay);
                }

                // �����z���痘�p�ҕ��S�z����������
                subAmountClaimed("701038", selfPay);
            }
        }

        // ���p�ҕ��S�z��ݒ肷��B
        tmap.put("701029", String.valueOf(toInt(tmap, "701027") * 10));
        sub(tmap, "701029", new String[] { "701029", "701028", "701031",
                "701034", "701037", "701032", "701035", "701038" });
    }

    /**
     * �����z���痘�p�ҕ��S���̋��z����������
     * 
     * @param key
     * @param selfPay
     * @throws Exception
     */
    private void subAmountClaimed(String key, int selfPay) throws Exception {

        String[] keys = null;

        // ���p�ҕ��S�P
        if ("701032".equals(key)) {
            keys = new String[] { "201042", "201043" };

            // ���p�ҕ��S�Q
        } else if ("701035".equals(key)) {
            keys = new String[] { "201048", "201049" };

            // ���p�ҕ��S�R
        } else if ("701038".equals(key)) {
            keys = new String[] { "201054", "201055" };

        }

        if (keys == null) {
            return;
        }

        for (int i = 0; i < keys.length; i++) {

            if (!baseCache.containsKey(keys[i])) {
                continue;
            }

            int claim = ACCastUtilities.toInt(baseCache.get(keys[i]), 0);

            // �����z�������p�ҕ��S�z���傫���ꍇ
            if (claim <= selfPay) {
                // �S�z�S�ۉ\�Ȃ̂ŁAMap����L�[���폜
                baseCache.remove(keys[i]);
                // �g�p�\���p�ҕ��S�z����������
                selfPay -= claim;

                // ���p�ҕ��S�z�����Ȃ��ꍇ
            } else {
                // �����z���Đݒ�
                baseCache.put(keys[i], String.valueOf(claim - selfPay));
                return;
            }
        }
    }

    private VRMap getTypeMap(String code) throws Exception {
        VRMap result = null;

        for (int i = 0; i < type.size(); i++) {
            VRMap map = (VRMap) type.get(i);
            if (code.equals(toString(map, "701007"))) {
                result = map;
                break;
            }
        }

        return result;
    }

    /**
     * ��{��񃌃R�[�h�̏W�v����
     * 
     * @throws Exception
     */
    private void parseBase() throws Exception {

        if (base.size() != 1) {
            return;
        }

        VRMap bmap = (VRMap) base.get(0);

        // ������
        // (���v��� �ی�)�T�[�r�X�P�ʐ�8��
        bmap.put("201033", "0");
        // (���v��� �ی�)�����z9��
        bmap.put("201034", "0");
        // (���v��� �ی�)���p�ҕ��S�z8��
        bmap.put("201035", "0");

        // (���v��� ����1)�T�[�r�X�P�ʐ�8��
        bmap.put("201039", "0");
        // (���v��� ����1)�����z8��
        bmap.put("201040", "0");
        // (���v��� ����1)�{�l���S�z8��
        bmap.put("201041", "0");

        // (���v��� ����2)�T�[�r�X�P�ʐ�8��
        bmap.put("201045", "0");
        // (���v��� ����2)�����z8��
        bmap.put("201046", "0");
        // (���v��� ����2)�{�l���S�z8��
        bmap.put("201047", "0");

        // (���v��� ����3)�T�[�r�X�P�ʐ�8��
        bmap.put("201051", "0");
        // (���v��� ����3)�����z8��
        bmap.put("201052", "0");
        // (���v��� ����3)�{�l���S�z8��
        bmap.put("201053", "0");

        // (���v��� �ی�)����f�Ô���z9��
        bmap.put("201037", "0");
        // (���v��� ����1)����f�Ô���z8��
        bmap.put("201043", "0");
        // (���v��� ����2)����f�Ô���z8��
        bmap.put("201049", "0");
        // (���v��� ����3)����f�Ô���z8��
        bmap.put("201055", "0");

        // (���v��� �ی�)�ً}���{�ݗ×{����z9��
        bmap.put("201036", "0");
        // (���v��� ����1)�ً}���{�ݗ×{����z8��
        bmap.put("201042", "0");
        // (���v��� ����2)�ً}���{�ݗ×{����z8��
        bmap.put("201048", "0");
        // (���v��� ����3)�ً}���{�ݗ×{����z8��
        bmap.put("201054", "0");

        for (int i = 0; i < type.size(); i++) {
            VRMap map = (VRMap) type.get(i);

            // (���v��� �ی�)�T�[�r�X�P�ʐ�8��
            addAppend(bmap, "201033", map, "701014");
            // (���v��� �ی�)�����z9��
            addAppend(bmap, "201034", map, "701016");
            // (���v��� �ی�)���p�ҕ��S�z8��
            addAppend(bmap, "201035", map, "701017");

            // (���v��� ����1)�T�[�r�X�P�ʐ�8��
            addAppend(bmap, "201039", map, "701018");
            // (���v��� ����1)�����z8��
            addAppend(bmap, "201040", map, "701019");
            // (���v��� ����1)�{�l���S�z8��
            addAppend(bmap, "201041", map, "701020");

            // (���v��� ����2)�T�[�r�X�P�ʐ�8��
            addAppend(bmap, "201045", map, "701021");
            // (���v��� ����2)�����z8��
            addAppend(bmap, "201046", map, "701022");
            // (���v��� ����2)�{�l���S�z8��
            addAppend(bmap, "201047", map, "701023");

            // (���v��� ����3)�T�[�r�X�P�ʐ�8��
            addAppend(bmap, "201051", map, "701024");
            // (���v��� ����3)�����z8��
            addAppend(bmap, "201052", map, "701025");
            // (���v��� ����3)�{�l���S�z8��
            addAppend(bmap, "201053", map, "701026");
        }

        // �ً}���A����f�Ô�̃f�[�^������
        Iterator it = baseCache.keySet().iterator();
        while (it.hasNext()) {
            String key = it.next().toString();
            bmap.put(key, baseCache.get(key));
        }

        // ��������ҏ�񏉊���
        if (nursingTotal == null) {
            // (���v��� �ی�)��������҉��T�[�r�X������z8��
            bmap.put("201038", "0");
            // (���v��� ����1)��������҉��T�[�r�X������z8��
            bmap.put("201044", "0");
            // (���v��� ����2)��������҉��T�[�r�X������z8��
            bmap.put("201050", "0");
            // (���v��� ����3)��������҉��T�[�r�X������z8��
            bmap.put("201056", "0");

            // ��������ҏ��R�s�[
        } else {
            // (���v��� �ی�)��������҉��T�[�r�X������z8��
            bmap.put("201038", nursingTotal.get("801023"));
            // (���v��� ����1)��������҉��T�[�r�X������z8��
            bmap.put("201044", nursingTotal.get("801026"));
            // (���v��� ����2)��������҉��T�[�r�X������z8��
            bmap.put("201050", nursingTotal.get("801029"));
            // (���v��� ����3)��������҉��T�[�r�X������z8��
            bmap.put("201056", nursingTotal.get("801032"));
        }

    }

    /**
     * �Е����R�[�h�̏W�v����
     * 
     * @throws Exception
     */
    private void parseReduction() throws Exception {

        for (int i = 0; i < reduction.size(); i++) {
            VRMap map = (VRMap) reduction.get(i);

            // �Ώۂ̏W�v��񃌃R�[�h�𓾂�
            VRMap tmap = null;
            for (int j = 0; j < type.size(); j++) {
                VRMap tmp = (VRMap) type.get(j);
                if (toString(map, "901008").equals(toString(tmp, "701007"))) {
                    tmap = tmp;
                    break;
                }
            }
            if (tmap == null) {
                continue;
            }

            // ��̂��ׂ����p�ҕ��S�̑��z
            map.put("901009", tmap.get("701017"));

            // 901010�y���z
            map.put("901010", String.valueOf((int) Math.floor((toInt(map,
                    "901009") * toInt(map, "901007")) / (100 * 10))));

            // 901011�y���㗘�p�ҕ��S�z
            sub(map, "901011", new String[] { "901009", "901010" });
        }
    }

    /**
     * ������x����
     * 
     * @throws Exception
     */
    private void parseCarePlan() throws Exception {

        VRMap map = null;
        VRMap lastmap = null;
        int total = 0;

        if (careplan.size() <= 0) {
            return;
        }

        map = (VRMap) careplan.get(0);
        // ���l���͏W�v���s��Ȃ�(�s���Ȃ�)
        if ("8124,8125"
                .indexOf(ACCastUtilities.toString(map.get("1001001"), "")) == -1) {
            return;
        }

        for (int i = 0; i < careplan.size(); i++) {
            map = (VRMap) careplan.get(i);
            // �P�ʐ����v = �P�ʐ� * ��
            total += mul(map, "1001017", "1001025", "1001026");

            if (ACCastUtilities.toInt(map.get("1001024"), 0) == 99) {
                lastmap = map;
            }
        }

        if (lastmap == null) {
            return;
        }

        // �P�ʐ��P��
        BigDecimal _1001006 = new BigDecimal(toString(map, "1001006"));
        _1001006 = _1001006.multiply(new BigDecimal("100"));

        // �T�[�r�X�P�ʐ����v
        lastmap.put("1001027", String.valueOf(total));
        // �������z
        map.put("1001018",
                String.valueOf((int) (Math.floor((double) total
                        * _1001006.intValue()) / 100d)));
    }

    /**
     * ���t�����擾����
     * 
     * @return
     */
    private int getRate() {

        // ��{��񃌃R�[�h�������̋��t�����擾����
        if (base.size() <= 0) {
            return 0;
        }

        // ���t�������擾�̏ꍇ�A�擾���s
        if (rate == Integer.MIN_VALUE) {
            initBaseData();
        }
        return rate;
    }

    /**
     * ����̋��t�����擾����
     * 
     * @param kohiNo
     *            ����ԍ�(1�`3)
     * @return ���t��
     */
    private int getKohiRate(int kohiNo) {
        if ((kohiNo < 1) || (3 < kohiNo)) {
            return 0;
        }

        // ��{��񃌃R�[�h�������̋��t�����擾����
        if (base.size() <= 0) {
            return 0;
        }

        // ���t�������擾�̏ꍇ�A�擾���s
        if (kohiRate[kohiNo - 1] == Integer.MIN_VALUE) {
            initBaseData();
        }
        return kohiRate[kohiNo - 1];
    }

    private String getKohiType(int kohiNo) {
        if ((kohiNo < 1) || (3 < kohiNo)) {
            return "";
        }

        // ��{��񃌃R�[�h�������̋��t�����擾����
        if (base.size() <= 0) {
            return "";
        }

        // ���t�������擾�̏ꍇ�A�擾���s
        if (kohiType[kohiNo - 1] == null) {
            initBaseData();
        }
        return kohiType[kohiNo - 1];
    }

    private void initBaseData() {
        VRMap map = (VRMap) base.get(0);
        rate = toInt(map, "201029");

        kohiRate[0] = toInt(map, "201030");
        kohiRate[1] = toInt(map, "201031");
        kohiRate[2] = toInt(map, "201032");

        kohiType[0] = toString(map, "201058");
        kohiType[1] = toString(map, "201059");
        kohiType[2] = toString(map, "201060");
    }

    /**
     * ����t�z���Z�肷��
     * 
     * @param unit
     * @param ratio
     * @param reduction
     * @param usedRate
     * @return
     */
    private int getKohiClaim(VRMap map, int unit, int ratio, int reduction,
            int usedRate) {
        int result = 0;
        int kyufu = 0;

        int total = (int) Math.floor((double) (unit * getMultiplies100(map,
                "701015")) / 100d);

        kyufu = (int) Math.floor(total * ((double) getRate() / 100d));
        // �ی����t����100%�̏ꍇ

        if ((ratio == 100) && (toInt(map, "701014") == unit)) {
            // ���p�Ґ���������ی����S�z������������
            result = total - kyufu - reduction;
        } else {
            // ���v���z*(����t��-�ی����t��-)
            result = (int) Math.floor((total * (ratio - usedRate)) / 100);
        }
        return result;
    }

    /**
     * �|���Z
     * 
     * @param map
     *            �l�̓����Ă���map
     * @param code
     *            ���Z���ʂ�������L�[
     * @param code1
     *            ���Z�ΏۂP
     * @param code2
     *            ���Z�ΏۂQ
     * @return ���Z����
     */
    private int mul(VRMap map, String code, String code1, String code2) {
        int v = ACCastUtilities.toInt(map.get(code1), 0)
                * ACCastUtilities.toInt(map.get(code2), 0);
        map.put(code, String.valueOf(v));
        return v;
    }

    /**
     * �����Z(��map�Q��)
     * 
     * @param map1
     * @param code1
     * @param map2
     * @param code2
     */
    private void addAppend(VRMap map1, String code1, VRMap map2, String code2) {
        map1.put(code1, String.valueOf(toInt(map1, code1) + toInt(map2, code2)));
    }

    /**
     * �����Z(map����)
     * 
     * @param map
     *            �l�̓����Ă���map
     * @param code
     *            ���Z���ʂ�������L�[
     * @param codes
     *            ���Z�Ώ�
     * @return ���Z����
     */
    private int add(VRMap map, String code, String[] codes) {
        int v = 0;
        for (int i = 0; i < codes.length; i++) {
            v += ACCastUtilities.toInt(map.get(codes[i]), 0);
        }
        map.put(code, String.valueOf(v));
        return v;
    }

    /**
     * �����Z
     * 
     * @param map
     *            �l�̓����Ă���map
     * @param code
     *            ���Z���ʂ�������L�[
     * @param codes
     *            ���Z�Ώ�
     * @return ���Z����
     */
    private int sub(VRMap map, String code, String[] codes) {
        int v = ACCastUtilities.toInt(map.get(codes[0]), 0);
        for (int i = 1; i < codes.length; i++) {
            v -= ACCastUtilities.toInt(map.get(codes[i]), 0);
        }
        map.put(code, String.valueOf(v));
        return v;
    }

    /**
     * �w��L�[�̒l��100�{�����l���擾����
     * 
     * @param map
     * @param key
     * @return
     */
    private int getMultiplies100(VRMap map, String key) {
        BigDecimal temp = new BigDecimal(toString(map, key));
        temp = temp.multiply(new BigDecimal("100"));
        return temp.intValue();
    }

    /**
     * int�ϊ�
     * 
     * @param map
     *            VRMap
     * @param key
     *            �ϊ��ΏۃL�[
     * @return �ϊ���̒l(���G���[����0��ԋp)
     */
    private int toInt(VRMap map, String key) {
        return ACCastUtilities.toInt(map.get(key), 0);
    }

    /**
     * String�ϊ�
     * 
     * @param map
     *            VRMap
     * @param key
     *            �ϊ��ΏۃL�[
     * @return �ϊ���̒l(���G���[���͋󔒂�ԋp)
     */
    private String toString(VRMap map, String key) {
        return ACCastUtilities.toString(map.get(key), "");
    }
}
