package jp.or.med.orca.qkan;

import java.awt.Component;
import java.awt.Container;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import jp.nichicom.ac.ACConstants;
import jp.nichicom.ac.bind.ACBindUtilities;
import jp.nichicom.ac.core.ACDBManagerCreatable;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.core.ACFrameEventProcesser;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.sql.ACDBManager;
import jp.nichicom.ac.sql.ACSeparateTableManager;
import jp.nichicom.ac.text.ACNowAgeFormat;
import jp.nichicom.ac.text.ACSQLSafeDateFormat;
import jp.nichicom.ac.text.ACSQLSafeIntegerFormat;
import jp.nichicom.ac.text.ACSQLSafeNullToZeroIntegerFormat;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.ac.util.ACDateUtilities;
import jp.nichicom.bridge.sql.BridgeFirebirdSeparateTable;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.bind.VRBindable;
import jp.nichicom.vr.component.AbstractVRCheckBox;
import jp.nichicom.vr.component.AbstractVRComboBox;
import jp.nichicom.vr.component.AbstractVRTextField;
import jp.nichicom.vr.component.VRRadioButtonGroup;
import jp.nichicom.vr.container.VRLabelContainer;
import jp.nichicom.vr.text.parsers.VRDateParser;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRLinkedHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.nichicom.vr.util.logging.VRLogger;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;

/**
 * ���ǒ��V�X�e���S�̂��痘�p�\�ȋ��ʊ֐��Q�ł��B
 * <p>
 * Copyright (c) 2005 Nippon Computer Corpration. All Rights Reserved.
 * </p>
 * 
 * @author Tozo Tanaka
 * @version 1.0 2005/12/01
 */
public class QkanCommon {
    /**
     * ���ׂĂ̕ی��҂�ΏۂƂ��錟�����[�h�萔�ł��B
     */
    public static final int INSURER_FIND_ALL = 0;
    /**
     * ���ی��������͎w��Ȃ��̕ی��҂�ΏۂƂ��錟�����[�h�萔�ł��B
     */
    public static final int INSURER_FIND_CARE_ONLY = 1;

    /**
     * ��Õی��������͎w��Ȃ��̕ی��҂�ΏۂƂ��錟�����[�h�萔�ł��B
     */
    public static final int INSURER_FIND_MEDICAL_ONLY = 2;

    private static ACNowAgeFormat ageFormat = new ACNowAgeFormat();

    private static ACSeparateTableManager separateTableManager;

    /**
     * ���O�C�����t����Ƃ��āA�a�������猻�ݔN���Ԃ��܂��B
     * 
     * @param birthDay �a����
     * @return ���ݔN��
     */
    public static int calcAge(Date birthDay) {
        ageFormat.setBaseDate(QkanSystemInformation.getInstance()
                .getSystemDate());
        return Integer.parseInt(ageFormat.format(birthDay));
    }

    /**
     * �����̓��t����Ƃ��āA�a�������猻�ݔN���Ԃ��܂��B
     * 
     * @param birthDay �a����
     * @param baseDate ���
     * @return ���ݔN��
     */
    public static int calcAge(Date birthDay, Date baseDate) {
        ageFormat.setBaseDate(baseDate);
        return Integer.parseInt(ageFormat.format(birthDay));
    }

    /**
     * �w���ʍ��ڈȉ��̃��W�I�O���[�v/�e�L�X�g/�`�F�b�N��Enabled��Ԃ�������Map�ɑޔ����܂��B
     * 
     * @param target �Ώ�
     * @param map �o�b�N�A�b�v��}�b�v
     */
    public static void captureEnabled(Component target, Map map) {
        if ((target instanceof VRRadioButtonGroup)
                || (target instanceof JTextField)
                || (target instanceof JCheckBox)
                || (target instanceof JComboBox)) {
            map.put(target, new Boolean(target.isEnabled()));
        } else if (target instanceof Container) {
            if (target instanceof VRLabelContainer) {
                // ���x���R���e�i
                map.put(target, new Boolean(target.isEnabled()));
            }
            int end = ((Container) target).getComponentCount();
            for (int i = 0; i < end; i++) {
                // �ċA
                captureEnabled(((Container) target).getComponent(i), map);
            }
        }

    }

    /**
     * �u�w��L�[�̃f�[�^�^��String����Integer�ɕϊ��v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public static void convertValueFromStringToInteger(VRMap map, Object[] keys)
            throws Exception {
        // �w��KEY�̃f�[�^�^�̕ϊ��֐�
        if ((map != null) && (keys != null)) {
            int end = keys.length;
            for (int i = 0; i < end; i++) {
                Object targetKey = keys[i];
                Object targetData = VRBindPathParser.get(targetKey, map);
                VRBindPathParser.set(targetKey, map,
                        ACCastUtilities.toInteger(targetData, null));
            }
        }
    }

    /**
     * �f�o�b�O���s�p�ɍŒ���̏��������s�Ȃ��܂��B
     */
    public static void debugInitialize() {
        try {
            ACDBManager dbm;
            // 2006/10/04 replace-begin Tozo TANAKA �V�X�e���v���Z�b�T��DB�����������Ϗ�
            // dbm = new BridgeFirebirdDBManager();
            dbm = ((ACDBManagerCreatable) ACFrame.getInstance()
                    .getFrameEventProcesser()).createDBManager();
            // 2006/10/04 replace-end Tozo TANAKA �V�X�e���v���Z�b�T��DB�����������Ϗ�
            VRList list;

            // �R�[�h�}�X�^�̎擾�ƕϊ�
            list = dbm
                    .executeQuery("SELECT * FROM M_CODE ORDER BY CODE_ID, CONTENT_SORT");
            if (list != null) {
                VRMap fullCodeM = new VRHashMap();
                Integer lastKey = null;
                VRList codeM = null;
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    VRMap row = (VRMap) it.next();
                    Integer key = Integer.valueOf(String
                            .valueOf(VRBindPathParser.get("CODE_ID", row)));
                    if (key != null) {
                        if (!key.equals(lastKey)) {
                            codeM = new VRArrayList();
                            fullCodeM.setData(key, codeM);
                            lastKey = key;
                        }
                        codeM.addData(row);
                    }
                }
                // �R�[�h�}�X�^���V�X�e�����ʂɐݒ�
                QkanSystemInformation.getInstance().setMasterCode(fullCodeM);
            }

            // �o�[�W����
            QkanSystemInformation.getInstance().setMasterDataVersion("4.5");
            QkanSystemInformation.getInstance().setSchemeVersion("4.5");
            QkanSystemInformation.getInstance().setSystemVersion("4.5");

            // ���O�C�����t
            QkanSystemInformation.getInstance().setSystemDate(new Date());

            // ���O�C�����Ǝ�ID
            QkanSystemInformation.getInstance()
                    .setLoginProviderID("9999999999");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * �F�藚�������Y�����t�B���^�����O���܂��B
     * 
     * @param list �F�藚��
     * @return �t�B���^�����O����
     */
    public static VRList filterNotCorrespond(VRList list) {
        int size = list.size();
        if (size > 1) {
            // ��Y�����܂߂ĔF�藚����2���ȏ㑶�݂���ꍇ
            VRList dest = new VRArrayList(size);

            // �F�藚����S�������A��Y���ȊO�𒊏o����E
            for (int i = 0; i < size; i++) {
                Map map = (Map) list.get(i);
                if (!"1".equals(ACCastUtilities.toString(map.get("JOTAI_CODE"),
                        ""))) {
                    // ��Y���łȂ���Βǉ�
                    dest.add(map);
                }
            }
            if (!dest.isEmpty()) {
                // �v���F�肪1���ȏ゠��Ηv��엚���݂̂�Ԃ��B
                return dest;
            }
        }
        return list;
    }

    /**
     * �Ɩ����擾�֐��ł��B
     * <p>
     * �E�B���h�E�^�C�g�����̏����Ǘ�����}�X�^�������Ԃ��܂��B
     * </p>
     * 
     * @param dbm DBManager
     * @param affairID �Ɩ�ID
     * @return �Ɩ����
     * @throws Exception ������O
     */
    public static VRMap getAffairInfo(ACDBManager dbm, String affairID)
            throws Exception {
        return getAffairInfo(dbm, affairID, null);
    }

    /**
     * �Ɩ����擾�֐��ł��B
     * <p>
     * �E�B���h�E�^�C�g�����̏����Ǘ�����}�X�^�������Ԃ��܂��B
     * </p>
     * 
     * @param dbm DBManager
     * @param affairID �Ɩ�ID
     * @param mode ���[�h
     * @return �Ɩ����
     * @throws Exception ������O
     */
    public static VRMap getAffairInfo(ACDBManager dbm, String affairID,
            String mode) throws Exception {
        StringBuilder sb;

        sb = new StringBuilder();
        sb.append("SELECT");
        sb.append(" M_AFFAIR_INFO.AFFAIR_ID,");
        sb.append(" M_AFFAIR_INFO.MODE,");
        sb.append(" M_AFFAIR_INFO.WINDOW_TITLE,");
        sb.append(" M_AFFAIR_INFO.AFFAIR_TITLE,");
        sb.append(" M_AFFAIR_INFO.LAST_TIME");
        sb.append(" FROM");
        sb.append(" M_AFFAIR_INFO");
        sb.append(" WHERE");
        sb.append(" (M_AFFAIR_INFO.AFFAIR_ID = '" + affairID + "')");
        if (mode != null) {
            sb.append(" AND(M_AFFAIR_INFO.MODE = '" + mode + "')");
        }

        if (dbm != null) {
            VRList list = dbm.executeQuery(sb.toString());
            if ((list != null) && (!list.isEmpty())) {
                return (VRMap) list.getData();
            }
        }
        return new VRHashMap();
    }

    /**
     * �n��P���擾�֐��ł��B
     * <p>
     * ���p�[�E�񋟕[�A���яW�v���ɁA���z�v�Z�̂��߂ɒn��P�����擾���܂��B
     * </p>
     * 
     * @param dbm DBManager
     * @param serviceKind �Ǝ��T�[�r�X��ރR�[�h
     * @param area �n��敪
     * @param targetDate �Ώ۔N����
     * @return �n��P��
     * @throws Exception ������O
     */
    public static double getAreaUnitPrice(ACDBManager dbm, int serviceKind,
            int area, Date targetDate) throws Exception {
        Calendar cal = Calendar.getInstance();
        cal.setTime(targetDate);
        String ym = VRDateParser.format(cal, "yyyy/MM/dd");

        StringBuilder sb;

        sb = new StringBuilder();
        sb.append("SELECT");
        sb.append(" M_AREA_UNIT_PRICE.UNIT_PRICE_VALUE");
        sb.append(" FROM");
        sb.append(" M_AREA_UNIT_PRICE");
        sb.append(" WHERE");
        sb.append(" (M_AREA_UNIT_PRICE.SERVICE_TYPE = '" + serviceKind + "')");
        sb.append(" AND(UNIT_PRICE_TYPE = " + area + ")");
        sb.append(" AND(M_AREA_UNIT_PRICE.UNIT_VALID_START <= '" + ym + "')");
        sb.append(" AND(M_AREA_UNIT_PRICE.UNIT_VALID_END >= '" + ym + "')");

        if (dbm != null) {
            VRList ret = dbm.executeQuery(sb.toString());
            if (ret.getDataSize() > 0) {
                return Double.parseDouble(String.valueOf(VRBindPathParser.get(
                        "UNIT_PRICE_VALUE", (VRMap) ret.getData())));
            }
        }
        return 0;
    }

    /**
     * �R�[�h�}�X�^�f�[�^�擾�֐��ł��B
     * <p>
     * �{���R���e���cID�̃t�B�[���h����CONTENTS_ID�ɌŒ�ł����A���̃t�B�[���h����ʂ̃t�B�[���h���ɒu������VRArrayList��Ԃ��܂�
     * �B
     * </p>
     * 
     * @param codeID �R�[�hID
     * @param newContentsID �R���e���cID�̖|��L�[��
     * @return �R�[�h�}�X�^�f�[�^
     * @throws Exception ������O
     */
    public static VRList getArrayFromMasterCode(int codeID, String newContentsID)
            throws Exception {
        Object contents = QkanSystemInformation.getInstance().getMasterCode()
                .getData(new Integer(codeID));

        if (contents instanceof VRList) {
            ACBindUtilities.copyBindPath((VRList) contents, "CONTENT_KEY",
                    newContentsID);
            return (VRList) contents;
        }
        return new VRArrayList();
    }

    /**
     * �ԍ��\��֐��ł��B
     * <p>
     * �f�[�^�o�^�Ɏg�p����ԍ����擾���A�o�^�f�[�^�����ԍ����X�V���܂��B <br/>
     * ���T�[�r�X�␿���Ȃǈ�x�ɑ����̃f�[�^��o�^����ꍇ�ɔԍ��̗\��Ƃ��Ďg�p���܂��B
     * </p>
     * <p>
     * ���s�����ꍇ�A-1(0����) �������͗�O���Ԃ�܂��B
     * </p>
     * 
     * @param dbm DBManager
     * @param table �ԍ��Ǘ��e�[�u����
     * @param field �ԍ��t�B�[���h��
     * @param count �m�ی���
     * @return �g�p�\�ȊJ�n�ԍ�
     * @throws Exception ������O
     */
    public static int getBookingNumber(ACDBManager dbm, String table,
            String field, int count) throws Exception {
        StringBuilder sb;

        sb = new StringBuilder();
        sb.append("UPDATE");
        sb.append(" M_NO_CONTROL");
        sb.append(" SET");
        sb.append(" CONTROL_NO = (");
        sb.append(" SELECT");
        sb.append(" MAX(CONTROL_NO) + " + count);
        sb.append(" FROM");
        sb.append(" M_NO_CONTROL");
        sb.append(" WHERE");
        sb.append(" (TABLE_NAME = '" + table + "')");
        sb.append(" AND(FIELD_NAME = '" + field + "')");
        sb.append(" )");
        sb.append(" WHERE");
        sb.append(" (TABLE_NAME = '" + table + "')");
        sb.append(" AND(FIELD_NAME = '" + field + "')");

        if (dbm == null) {
            return -1;
        }

        int maxNo = 0;
        dbm.executeUpdate(sb.toString());

        sb = new StringBuilder();
        sb.append("SELECT");
        sb.append(" CONTROL_NO");
        sb.append(" FROM");
        sb.append(" M_NO_CONTROL");
        sb.append(" WHERE");
        sb.append(" (TABLE_NAME = '" + table + "')");
        sb.append(" AND(FIELD_NAME = '" + field + "')");
        VRList nos = dbm.executeQuery(sb.toString());
        if (nos.getDataSize() > 0) {
            maxNo = Integer.parseInt(String.valueOf(VRBindPathParser.get(
                    "CONTROL_NO", (VRMap) nos.getData())));
        }

        int beginNo = maxNo - count;
        if (beginNo < 0) {
            return -1;
        }
        return beginNo;
    }

    /**
     * �����ڍ׏��擾�֐��ł��B
     * <p>
     * ���[�o�͎��ɁA�����e�[�u���̏ڍ׏����擾���܂��B�w�萿���N�����ɂ�����S���p�҂̐��������擾���܂��B
     * </p>
     * <p>
     * �����L�[�͐�����(CLAIM_DATE)�ł��B
     * </p>
     * <p>
     * �Ԃ�l <br />
     * <code>List{ <br />
     * Map(�����e���E�ڍ׏��) <br />
     * key:�t�B�[���h���E�ڍ׎�� <br />
     * val:�l <br />
     * }</code><br />
     * ASC ���p��ID
     * </p>
     * <p>
     * �����Ǘ��e�[�u�����X�V����\�������邽�߁A�g�����U�N�V�����̒��Ŏ��s���Ă��������B
     * </p>
     * 
     * @param dbm DBManager
     * @param claimDate �����N����
     * @return �����ڍ׏�(���p��ID��)
     * @throws Exception ������O
     */
    public static VRList getClaimDetail(ACDBManager dbm, Date claimDate)
            throws Exception {
        return getClaimDetail(dbm, claimDate, -1);
    }

    /**
     * �����ڍ׏��擾�֐��ł��B
     * <p>
     * ���[�o�͎��ɁA�����e�[�u���̏ڍ׏����擾���܂��B
     * </p>
     * <p>
     * �����L�[�͐�����(CLAIM_DATE)�ł��B
     * </p>
     * <p>
     * �Ԃ�l <br />
     * <code>List{ <br />
     * Map(�����e���E�ڍ׏��) <br />
     * key:�t�B�[���h���E�ڍ׎�� <br />
     * val:�l <br />
     * }</code><br />
     * ASC ���p��ID
     * </p>
     * <p>
     * �����Ǘ��e�[�u�����X�V����\�������邽�߁A�g�����U�N�V�����̒��Ŏ��s���Ă��������B
     * </p>
     * 
     * @param dbm DBManager
     * @param claimDate �����N����
     * @param patientID ���p��ID
     * @return �����ڍ׏�(���p��ID��)
     * @throws Exception ������O
     */
    public static VRList getClaimDetail(ACDBManager dbm, Date claimDate,
            int patientID) throws Exception {
        StringBuilder sb = new StringBuilder();
        sb.append(" AND(CLAIM.CLAIM_DATE = '"
                + VRDateParser.format(claimDate, "yyyy/MM/dd") + "')");
        if (patientID >= 0) {
            // ���p��ID���w�肵�Ă���Ȃ�Γ���̗��p�҂̂݁B���w��Ȃ�ΑS���p�҂�ΏۂƂ���B
            sb.append(" AND(CLAIM.PATIENT_ID = " + patientID + ")");
        }
        return getClaimDetailCustom(dbm, claimDate, sb.toString());

    }

    /**
     * �����ڍ׏��擾�֐��ł��B
     * <p>
     * ���[�o�͎��ɁA�����e�[�u���̏ڍ׏����擾���܂��B
     * </p>
     * <p>
     * �Ԃ�l <br />
     * <code>List{ <br />
     * Map(�����e���E�ڍ׏��) <br />
     * key:�t�B�[���h���E�ڍ׎�� <br />
     * val:�l <br />
     * }</code><br />
     * ASC ���p��ID
     * </p>
     * <p>
     * �����Ǘ��e�[�u�����X�V����\�������邽�߁A�g�����U�N�V�����̒��Ŏ��s���Ă��������B
     * </p>
     * 
     * @param dbm DBManager
     * @param claimDate �����N����
     * @param where �e����where��
     * @throws Exception ������O
     */
    public static VRList getClaimDetailCustom(ACDBManager dbm, Date claimDate,
            String where) throws Exception {

        if (dbm == null) {
            return new VRArrayList();
        }
        where = appendFrontWhere(where);

        // �e�[�u��������̏C������擾
        int modify = getSeparateTableManager().getTableModifyFromDate(dbm,
                "CLAIM_DETAIL", claimDate);
        if (modify < 0) {
            return new VRArrayList();
        }
        // �쐬�����e�[�u�����́u���̃e�[�u����_�N�x�v�ƂȂ�
        String tableSaffix = "_" + modify;
        StringBuilder sb;

        TreeMap result = new TreeMap();
        final String[] shareFields = new String[] { "CLAIM_ID",
                "CLAIM_STYLE_TYPE", "CATEGORY_NO", "PATIENT_ID", "INSURED_ID",
                "TARGET_DATE", "CLAIM_DATE", "INSURER_ID", "PROVIDER_ID",
                "CLAIM_FINISH_FLAG", "LAST_TIME", };
        // ������^�A���l�^�A���t�^
        String[] tableNames = new String[] { "CLAIM_DETAIL_TEXT",
                "CLAIM_DETAIL_INTEGER", "CLAIM_DETAIL_DATE" };
        // SQL���̋��ʕ������\�z
        sb = new StringBuilder();
        sb.append("SELECT");
        sb.append(" CLAIM.CLAIM_ID,");
        sb.append(" CLAIM.CLAIM_STYLE_TYPE,");
        sb.append(" CLAIM.CATEGORY_NO,");
        sb.append(" CLAIM.PATIENT_ID,");
        sb.append(" CLAIM.INSURED_ID,");
        sb.append(" CLAIM.TARGET_DATE,");
        sb.append(" CLAIM.CLAIM_DATE,");
        sb.append(" CLAIM.INSURER_ID,");
        sb.append(" CLAIM.PROVIDER_ID,");
        sb.append(" CLAIM.CLAIM_FINISH_FLAG,");
        sb.append(" CLAIM.LAST_TIME,");
        String header = sb.toString();
        int end = tableNames.length;
        for (int i = 0; i < end; i++) {
            String tableName = tableNames[i] + tableSaffix;
            sb = new StringBuilder(header);
            sb.append(" " + tableName + ".SYSTEM_BIND_PATH,");
            sb.append(" " + tableName + ".DETAIL_VALUE");
            sb.append(" FROM");
            sb.append(" CLAIM");
            sb.append(" LEFT JOIN ");
            sb.append(tableName);
            sb.append(" ON");
            sb.append(" (CLAIM.CLAIM_ID = " + tableName + ".CLAIM_ID)");
            // sb.append("," + tableName);
            // sb.append(" WHERE");
            // sb.append(" (CLAIM.CLAIM_ID = " + tableName + ".CLAIM_ID)");
            sb.append(where);

            // ���ʕ����̍��v���郌�R�[�h���}�[�W
            restractureDetail(result, dbm.executeQuery(sb.toString()),
                    "CLAIM_ID", shareFields);
        }
        return new VRArrayList(result.values());

    }

    /**
     * �R�[�h�}�X�^�����̎擾�֐��ł��B
     * <p>
     * �V�X�e�����ʗ̈�̃R�[�h�}�X�^����w��R�[�hID�A�R���e���cID�ɑΉ��������e(CONTENT)��Ԃ��܂��B
     * </p>
     * <p>
     * �Y�����Ȃ���΋󕶎�""��Ԃ��܂��B
     * </p>
     * 
     * @param codeID �R�[�hID
     * @param contentID �R���e���cID
     * @return ���e
     * @throws Exception ������O
     */
    public static String getContentFromMasterCode(int codeID, int contentID)
            throws Exception {
        Object contents = QkanSystemInformation.getInstance().getMasterCode()
                .getData(new Integer(codeID));
        if (contents instanceof ArrayList) {
            String contentIDText = String.valueOf(contentID);
            Iterator it = ((ArrayList) contents).iterator();
            while (it.hasNext()) {
                VRMap row = (VRMap) it.next();
                if (contentIDText.equals(String.valueOf(VRBindPathParser.get(
                        "CONTENT_KEY", row)))) {
                    return String.valueOf(VRBindPathParser.get("CONTENT", row));
                }
            }
        }
        return "";

    }

    /**
     * �R�[�h�}�X�^��ID�擾�֐��ł��B
     * <p>
     * �V�X�e�����ʗ̈�̃R�[�h�}�X�^����w��R�[�hID�A���e(CONTENT)�ɑΉ������R���e���cID��Ԃ��܂��B
     * </p>
     * <p>
     * �Y�����Ȃ����-1��Ԃ��܂��B
     * </p>
     * 
     * @param codeID �R�[�hID
     * @param content ���e
     * @return �R���e���cID
     * @throws Exception ������O
     */
    public static int getContentIDFromMasterCode(int codeID, String content)
            throws Exception {
        Object contents = QkanSystemInformation.getInstance().getMasterCode()
                .getData(new Integer(codeID));
        if (contents instanceof ArrayList) {
            Iterator it = ((ArrayList) contents).iterator();
            while (it.hasNext()) {
                VRMap row = (VRMap) it.next();
                if (content.equals(String.valueOf(VRBindPathParser.get(
                        "CONTENT", row)))) {
                    return Integer.parseInt(String.valueOf(VRBindPathParser
                            .get("CONTENT_KEY", row)));
                }
            }
        }
        return -1;

    }

    /**
     * �ی��Ҋ�{���擾�֐��ł��B
     * <p>
     * �ی��Ҋ�{�����擾���܂��B
     * </p>
     * <p>
     * �Ԃ�l <br />
     * <code>List{ <br />
     * Map(�ی��ҏ��) <br />
     * key:�t�B�[���h�� <br />
     * val:�l <br />
     * }</code><br />
     * ASC �ی��Ҕԍ�
     * </p>
     * 
     * @param dbm DBManager
     * @return �ی��ҏ��(�ی��Ҕԍ���)
     * @throws Exception ������O
     */
    public static VRList getInsurerInfo(ACDBManager dbm) throws Exception {
        return getInsurerInfo(dbm, null);
    }

    /**
     * �ی��Ҋ�{���擾�֐��ł��B
     * <p>
     * mode�ɉ������ی��Ҋ�{�����擾���܂��B
     * </p>
     * <p>
     * mode�̒l�͈ȉ��̂����ꂩ�����܂��B<br/>
     * <br/>
     * <br/>
     * <br/>
     * </p>
     * <p>
     * �Ԃ�l <br />
     * <code>List{ <br />
     * Map(�ی��ҏ��) <br />
     * key:�t�B�[���h�� <br />
     * val:�l <br />
     * }</code><br />
     * ASC �ی��Ҕԍ�
     * </p>
     * 
     * @param dbm DBManager
     * @param mode �����Ώ�
     * @return �ی��ҏ��(�ی��Ҕԍ���)
     * @throws Exception ������O
     */
    public static VRList getInsurerInfo(ACDBManager dbm, int mode)
            throws Exception {
        switch (mode) {
        case INSURER_FIND_CARE_ONLY:
            return getInsurerInfoCareOnly(dbm);
        case INSURER_FIND_MEDICAL_ONLY:
            return getInsurerInfoMedicalOnly(dbm);
        }
        return getInsurerInfo(dbm);
    }

    /**
     * �ی��Ҋ�{���擾�֐��ł��B
     * <p>
     * �ی��Ҋ�{�����擾���܂��B
     * </p>
     * <p>
     * �Ԃ�l <br />
     * <code>List{ <br />
     * Map(�ی��ҏ��) <br />
     * key:�t�B�[���h�� <br />
     * val:�l <br />
     * }</code><br />
     * ASC �ی��Ҕԍ�
     * </p>
     * 
     * @param dbm DBManager
     * @param insurerID �ی��Ҕԍ�
     * @return �ی��ҏ��(�ی��Ҕԍ���)
     * @throws Exception ������O
     */
    public static VRList getInsurerInfo(ACDBManager dbm, String insurerID)
            throws Exception {
        return getInsurerInfo(dbm, insurerID, "");
    }

    /**
     * �ی��Ҋ�{���擾�֐��ł��B
     * <p>
     * �ی��Ҋ�{�����擾���܂��B
     * </p>
     * <p>
     * �Ԃ�l <br />
     * <code>List{ <br />
     * Map(�ی��ҏ��) <br />
     * key:�t�B�[���h�� <br />
     * val:�l <br />
     * }</code><br />
     * ASC �ی��Ҕԍ�
     * </p>
     * 
     * @param dbm DBManager
     * @param insurerID �ی��Ҕԍ�
     * @param where �ǉ��̌�������
     * @return �ی��ҏ��(�ی��Ҕԍ���)
     * @throws Exception ������O
     */
    public static VRList getInsurerInfo(ACDBManager dbm, String insurerID,
            String where) throws Exception {
        StringBuilder sb;

        sb = new StringBuilder();
        sb.append("SELECT");
        sb.append(" INSURER.INSURER_ID,");
        // del sta shin fujihara 2005.12.7
        // INSURER.INSURER_KANA�͑��݂��Ȃ����߁A���ʃZ�b�g����폜
        // sb.append(" INSURER.INSURER_KANA,");
        // del end shin fujihara 2005.12.7
        sb.append(" INSURER.INSURER_NAME,");
        sb.append(" INSURER.INSURER_TYPE,");
        sb.append(" INSURER.INSURER_ZIP_FIRST,");
        sb.append(" INSURER.INSURER_ZIP_SECOND,");
        sb.append(" INSURER.INSURER_ADDRESS,");
        sb.append(" INSURER.INSURER_TEL_FIRST,");
        sb.append(" INSURER.INSURER_TEL_SECOND,");
        sb.append(" INSURER.INSURER_TEL_THIRD,");
        sb.append(" INSURER.LAST_TIME");
        sb.append(" FROM");
        sb.append(" INSURER");
        // edit sta shin fujihara 2005.12.7
        // null �̂Ƃ��ł͂Ȃ��A!null�̂Ƃ��Awhere��t������B
        // if (NCCommon.getInstance().isNullText(insurerID)) {
        sb.append(" WHERE");
        if (!ACTextUtilities.isNullText(insurerID)) {
            // edit end shin fujihara 2005.12.7
            sb.append(" (INSURER.INSURER_ID = '" + insurerID + "')");
        } else {
            sb.append(" (INSURER.DELETE_FLAG = 0)");
        }
        if ((where != null) && (!"".equals(where))) {
            // �ǉ��̌�������
            sb.append(where);
        }
        sb.append(" ORDER BY");
        sb.append(" INSURER.INSURER_ID ASC");

        if (dbm == null) {
            return new VRArrayList();
        }
        return dbm.executeQuery(sb.toString());
    }

    /**
     * �ی��Ҋ�{���擾�֐��ł��B
     * <p>
     * ���ی��������͎w��Ȃ��̕ی��Ҋ�{�����擾���܂��B
     * </p>
     * <p>
     * �Ԃ�l <br />
     * <code>List{ <br />
     * Map(�ی��ҏ��) <br />
     * key:�t�B�[���h�� <br />
     * val:�l <br />
     * }</code><br />
     * ASC �ی��Ҕԍ�
     * </p>
     * 
     * @param dbm DBManager
     * @param insurerID �ی��Ҕԍ�
     * @return �ی��ҏ��(�ی��Ҕԍ���)
     * @throws Exception ������O
     */
    public static VRList getInsurerInfoCareOnly(ACDBManager dbm)
            throws Exception {
        return getInsurerInfo(dbm, null,
                " AND((INSURER.INSURER_TYPE IS NULL)OR(INSURER.INSURER_TYPE IN(0,1)))");
    }

    // /**
    // * ���p�җv�����擾�֐��ł��B
    // * <p>
    // * ���ׂĂ̗��p�҂̗v�������擾���܂��B
    // * </p>
    // * <p>
    // * ���p�҂̊�{���͎擾���܂���B
    // * </p>
    // * <p>
    // * ���������ɗv�����2�ȏ㑶�݂���ꍇ�A�����ɋ߂��ł��傫������ԍ����V�������̂��擾���܂��B
    // * </p>
    // * <p>
    // * �Ԃ�l <br />
    // * <code>List{ <br />
    // * Map(���p�җv�����) <br />
    // * key:�t�B�[���h�� <br />
    // * val:�l <br />
    // * }</code><br />
    // * ASC ���p��ID
    // * </p>
    // *
    // * @param dbm DBManager
    // * @param targetMonth �Ώ۔N��
    // * @param patientID ���p�Ҕԍ�
    // * @return ��������
    // * @throws Exception ������O
    // */
    // public static VRList getPatientInsureInfoOnEndOfMonth(ACDBManager dbm,
    // Date targetMonth) throws Exception {
    // // ������ԓ��ŊJ�n���̈�ԑ傫������
    // return getPatientInsureInfoImpl(
    // dbm,
    // targetMonth,
    // -1,
    // " AND(PATIENT_NINTEI_HISTORY.INSURE_VALID_START = (SELECT
    // MAX(PATIENT_NINTEI_HISTORY.INSURE_VALID_START)",
    // "))");
    // }

    /**
     * �ی��Ҋ�{���擾�֐��ł��B
     * <p>
     * ��Õی��������͎w��Ȃ��̕ی��Ҋ�{�����擾���܂��B
     * </p>
     * <p>
     * �Ԃ�l <br />
     * <code>List{ <br />
     * Map(�ی��ҏ��) <br />
     * key:�t�B�[���h�� <br />
     * val:�l <br />
     * }</code><br />
     * ASC �ی��Ҕԍ�
     * </p>
     * 
     * @param dbm DBManager
     * @param insurerID �ی��Ҕԍ�
     * @return �ی��ҏ��(�ی��Ҕԍ���)
     * @throws Exception ������O
     */
    public static VRList getInsurerInfoMedicalOnly(ACDBManager dbm)
            throws Exception {
        return getInsurerInfo(dbm, null,
                " AND((INSURER.INSURER_TYPE IS NULL)OR(INSURER.INSURER_TYPE IN(0,2)))");
    }

    /**
     * �T�[�r�X�R�[�h�}�X�^�擾�֐��ł��B
     * <p>
     * �Ώ۔N����n�����ꍇ�F������Ԃɂ����ėL���ȃT�[�r�X���擾���܂��B<br/>
     * �Ώ۔N�����ȗ������ꍇ�F���ԂɊ֌W�Ȃ��S�ẴT�[�r�X��ނ��擾���܂��B
     * </p>
     * 
     * @param dbm DBManager
     * @return �T�[�r�X��ނ��L�[�A�T�[�r�X��`���W����l�ɂ����}�b�v
     * @throws Exception ������O
     */
    public static VRMap getMasterService(ACDBManager dbm) throws Exception {
        return getMasterService(dbm, null);
    }

    /**
     * �T�[�r�X�R�[�h�}�X�^�擾�֐��ł��B
     * <p>
     * �Ώ۔N����n�����ꍇ�F������Ԃɂ����ėL���ȃT�[�r�X���擾���܂��B<br/>
     * �Ώ۔N�����ȗ������ꍇ�F���ԂɊ֌W�Ȃ��S�ẴT�[�r�X��ނ��擾���܂��B
     * </p>
     * 
     * @param dbm DBManager
     * @param targetDate �Ώ۔N��
     * @return �T�[�r�X��ނ��L�[�A�T�[�r�X��`���W����l�ɂ����}�b�v
     * @throws Exception ������O
     */
    public static VRMap getMasterService(ACDBManager dbm, Date targetDate)
            throws Exception {
        StringBuilder sb;

        sb = new StringBuilder();
        sb.append("SELECT");
        sb.append(" M_SERVICE.SYSTEM_SERVICE_KIND_DETAIL,");
        sb.append(" M_SERVICE.SERVICE_VALID_START,");
        sb.append(" M_SERVICE.SERVICE_VALID_END,");
        sb.append(" M_SERVICE.SERVICE_CODE_KIND,");
        sb.append(" M_SERVICE.SERVICE_NAME,");
        sb.append(" M_SERVICE.SERVICE_ABBREVIATION,");
        sb.append(" M_SERVICE.SERVICE_KIND_NAME,");
        sb.append(" M_SERVICE.SERVICE_CALENDAR_ABBREVIATION,");
        sb.append(" M_SERVICE.CLAIM_STYLE_TYPE,");
        sb.append(" M_SERVICE.BUSINESS_TYPE,");
        sb.append(" M_SERVICE.CALENDAR_PASTE_FLAG,");
        sb.append(" M_SERVICE.CHANGES_CONTENT_TYPE,");
        sb.append(" M_SERVICE.CLAIM_LAYER,");
        sb.append(" M_SERVICE.SERVICE_SORT");
        sb.append(" FROM");
        sb.append(" M_SERVICE");
        sb.append(" WHERE");
        sb.append(" (M_SERVICE.SYSTEM_SERVICE_KIND_DETAIL IN(");
        sb.append(" SELECT DISTINCT");
        sb.append(" M_SERVICE.SYSTEM_SERVICE_KIND_DETAIL");
        sb.append(" FROM");
        sb.append(" M_SERVICE");
        if (targetDate != null) {
            String date = VRDateParser.format(targetDate, "yyyy/MM/dd");
            sb.append(" WHERE");
            sb.append(" (M_SERVICE.SERVICE_VALID_START<='" + date + "')");
            sb.append(" AND (M_SERVICE.SERVICE_VALID_END>='" + date + "')");
        }
        sb.append(" )");
        sb.append(" )");
        sb.append(" ORDER BY");
        sb.append(" M_SERVICE.SERVICE_SORT ASC");

        VRMap map = new VRLinkedHashMap();
        if (dbm != null) {
            VRList list = dbm.executeQuery(sb.toString());
            // SYSTEM_SERVICE_KIND_DETAIL���L�[��List��Map�ɕϊ�
            ACBindUtilities.setMapFromArray(list, map,
                    "SYSTEM_SERVICE_KIND_DETAIL");
        }
        return map;
    }

    /**
     * ���p�Ҋ�{���擾�֐��ł��B
     * <p>
     * �S���p�҂̗��p�҂̊�{�����擾���܂��B
     * </p>
     * <p>
     * �Ԃ�l <br />
     * <code>List{ <br />
     * Map(���p�Ҋ�{���) <br />
     * key:�t�B�[���h�� <br />
     * val:�l <br />
     * }</code><br />
     * ASC ���p��ID
     * </p>
     * 
     * @param dbm DBManager
     * @return ��������
     * @throws Exception ������O
     */
    public static VRList getPatientInfo(ACDBManager dbm) throws Exception {
        return getPatientInfo(dbm, -1);
    }

    /**
     * ���p�Ҋ�{���擾�֐��ł��B
     * <p>
     * �w��̗��p�҂̊�{�����擾���܂��B
     * </p>
     * <p>
     * �Ԃ�l <br />
     * <code>List{ <br />
     * Map(���p�Ҋ�{���) <br />
     * key:�t�B�[���h�� <br />
     * val:�l <br />
     * }</code><br />
     * ASC ���p��ID
     * </p>
     * 
     * @param dbm DBManager
     * @param patientID ���p�Ҕԍ�
     * @return ��������
     * @throws Exception ������O
     */
    public static VRList getPatientInfo(ACDBManager dbm, int patientID)
            throws Exception {
        StringBuilder sb;

        sb = new StringBuilder();
        sb.append("SELECT");
        sb.append(" PATIENT.PATIENT_ID,");
        sb.append(" PATIENT.PATIENT_CODE,");
        sb.append(" PATIENT.PATIENT_FAMILY_NAME,");
        sb.append(" PATIENT.PATIENT_FIRST_NAME,");
        sb.append(" PATIENT.PATIENT_FAMILY_KANA,");
        sb.append(" PATIENT.PATIENT_FIRST_KANA,");
        sb.append(" PATIENT.PATIENT_SEX,");
        sb.append(" PATIENT.PATIENT_BIRTHDAY,");
        sb.append(" PATIENT.PATIENT_TEL_FIRST,");
        sb.append(" PATIENT.PATIENT_TEL_SECOND,");
        sb.append(" PATIENT.PATIENT_TEL_THIRD,");
        sb.append(" PATIENT.PATIENT_ZIP_FIRST,");
        sb.append(" PATIENT.PATIENT_ZIP_SECOND,");
        sb.append(" PATIENT.PATIENT_ADDRESS,");
        sb.append(" PATIENT.SHOW_FLAG,");
        sb.append(" PATIENT.BELONG_TYPE,");
        sb.append(" PATIENT.AREA_TYPE,");
        sb.append(" PATIENT.LAST_TIME");
        sb.append(" FROM");
        sb.append(" PATIENT");
        sb.append(" WHERE");
        if (patientID >= 0) {
            sb.append(" (PATIENT.PATIENT_ID = " + patientID + ")");
        } else {
            sb.append(" (PATIENT.DELETE_FLAG = 0)");
        }
        sb.append(" ORDER BY");
        sb.append(" PATIENT_ID ASC");

        if (dbm == null) {
            return new VRArrayList();
        }
        return dbm.executeQuery(sb.toString());
    }

    /**
     * ���p�҂̗v����񗚗��擾�֐��ł��B
     * <p>
     * �w��̗��p�҂̗v�����̗��������ׂĎ擾���܂��B
     * </p>
     * <p>
     * �Ԃ�l <br />
     * <code>List{ <br />
     * Map(���p�җv�����) <br />
     * key:�t�B�[���h�� <br />
     * val:�l <br />
     * }</code><br />
     * ASC �L�����ԊJ�n��
     * </p>
     * 
     * @param dbm DBManager
     * @param targetMonth �Ώ۔N��
     * @param patientID ���p�Ҕԍ�
     * @return ��������
     * @throws Exception ������O
     */
    public static VRList getPatientInsureInfoHistory(ACDBManager dbm,
            Date targetMonth, int patientID) throws Exception {

        StringBuilder sb;

        // ���C��SQL�����\�z
        sb = new StringBuilder();
        sb.append("SELECT");
        sb.append(" PATIENT_NINTEI_HISTORY.PATIENT_ID,");
        sb.append(" PATIENT_NINTEI_HISTORY.NINTEI_HISTORY_ID,");
        sb.append(" PATIENT_NINTEI_HISTORY.INSURER_ID,");
        sb.append(" PATIENT_NINTEI_HISTORY.INSURED_ID,");
        sb.append(" PATIENT_NINTEI_HISTORY.INSURE_RATE,");
        sb.append(" PATIENT_NINTEI_HISTORY.PLANNER,");
        sb.append(" PATIENT_NINTEI_HISTORY.PROVIDER_ID,");
        sb.append(" PATIENT_NINTEI_HISTORY.SHUBETSU_CODE,");
        sb.append(" PATIENT_NINTEI_HISTORY.CHANGE_CODE,");
        sb.append(" PATIENT_NINTEI_HISTORY.JOTAI_CODE,");
        sb.append(" PATIENT_NINTEI_HISTORY.SHINSEI_DATE,");
        sb.append(" PATIENT_NINTEI_HISTORY.NINTEI_DATE,");
        sb.append(" PATIENT_NINTEI_HISTORY.INSURE_VALID_START,");
        sb.append(" PATIENT_NINTEI_HISTORY.INSURE_VALID_END,");
// 2014/12/17 [Yoichiro Kamei] add - begin �V�X�e���L�����ԑΉ�
        sb.append(" PATIENT_NINTEI_HISTORY.SYSTEM_INSURE_VALID_START,");
        sb.append(" PATIENT_NINTEI_HISTORY.SYSTEM_INSURE_VALID_END,");
// 2014/12/17 [Yoichiro Kamei] add - end
        sb.append(" PATIENT_NINTEI_HISTORY.STOP_DATE,");
        sb.append(" PATIENT_NINTEI_HISTORY.STOP_REASON,");
        sb.append(" PATIENT_NINTEI_HISTORY.REPORTED_DATE,");
        sb.append(" PATIENT_NINTEI_HISTORY.LIMIT_RATE,");
        sb.append(" PATIENT_NINTEI_HISTORY.EXTERNAL_USE_LIMIT,");
// 2015/4/15 [H27.04�����Ή�][Yoichiro Kamei] add - begin �Z�����������̏����l�Ή�
        sb.append(" PATIENT_NINTEI_HISTORY.SHORTSTAY_USE_INIT_COUNT,");
// 2015/4/15 [H27.04�����Ή�][Yoichiro Kamei] add - end
        sb.append(" PATIENT_NINTEI_HISTORY.LAST_TIME");
        sb.append(" FROM");
        sb.append(" PATIENT_NINTEI_HISTORY");
        sb.append(" WHERE");
        sb.append(createWhereStatementOfNinteiHistory(targetMonth));
        sb.append(" AND(PATIENT_NINTEI_HISTORY.PATIENT_ID = " + patientID + ")");
        sb.append(" ORDER BY");
// 2014/12/17 [Yoichiro Kamei] mod - begin �V�X�e���L�����ԑΉ�
//        sb.append(" PATIENT_NINTEI_HISTORY.INSURE_VALID_START ASC");
        sb.append(" PATIENT_NINTEI_HISTORY.SYSTEM_INSURE_VALID_START ASC");
// 2014/12/17 [Yoichiro Kamei] mod - end

        if (dbm == null) {
            return new VRArrayList();
        }

        //2014/01/24 [Shinobu Hitaka] edit - begin �y2014.4 �敪�x�����x�z����Ή��z
        //���p�Җ��̌��x�z���A�Ώ۔N���̌����J���ȋK��̋敪�x�����x�z�ɍ����ւ���
        //del - begin
        //return filterNotCorrespond(dbm.executeQuery(sb.toString()));
        //del - end
        VRList list = dbm.executeQuery(sb.toString());
        for (int j = 0; j < list.size(); j++) {
            VRMap record = (VRMap) list.get(j);
            int limitRate = -1;
            
            // �����J���ȋK��̋敪�x�����x�z���擾����B
            limitRate = getOfficialLimitRate(dbm, targetMonth, new Integer(1), record.getData("JOTAI_CODE").toString());
            if (limitRate > 0) {
                record.setData("LIMIT_RATE", limitRate);
            }
            // �����J���ȋK��̊O�����p�^���t����P�ʐ����擾����B
            limitRate = getOfficialLimitRate(dbm, targetMonth, new Integer(2), record.getData("JOTAI_CODE").toString());
            if (limitRate > 0) {
                record.setData("EXTERNAL_USE_LIMIT", limitRate);
            }
        }
        return filterNotCorrespond(list);
        //2014/01/24 [Shinobu Hitaka] edit - end �y2014.4 �敪�x�����x�z����Ή��z

    }

    /**
     * ���p�җv�����擾�֐��ł��B
     * <p>
     * �w��̗��p�҂̗v�������擾���܂��B
     * </p>
     * <p>
     * ���p�҂̊�{���͎擾���܂���B
     * </p>
     * <p>
     * ���������ɗv�����2�ȏ㑶�݂���ꍇ�A�����ɋ߂��ł��傫������ԍ����V�������̂��擾���܂��B
     * </p>
     * <p>
     * �Ԃ�l <br />
     * <code>List{ <br />
     * Map(���p�җv�����) <br />
     * key:�t�B�[���h�� <br />
     * val:�l <br />
     * }</code><br />
     * ASC ���p��ID
     * </p>
     * 
     * @param dbm DBManager
     * @param targetMonth �Ώ۔N��
     * @param patientID ���p�Ҕԍ�
     * @return ��������
     * @throws Exception ������O
     */
    public static VRList getPatientInsureInfoOnEndOfMonth(ACDBManager dbm,
            Date targetMonth, int patientID) throws Exception {
        // ������ԓ��ŊJ�n���̈�ԑ傫������
        // return getPatientInsureInfoImpl(
        // dbm,
        // targetMonth,
        // patientID,
        // " AND(PATIENT_NINTEI_HISTORY.INSURE_VALID_START = (SELECT
        // MAX(PATIENT_NINTEI_HISTORY.INSURE_VALID_START)",
        // "))");

        if (dbm == null) {
            return new VRArrayList();
        }

        StringBuilder sb;

        // ���C��SQL�����\�z
        sb = new StringBuilder();
        sb.append("SELECT");
        sb.append(" PATIENT_NINTEI_HISTORY.PATIENT_ID,");
        sb.append(" PATIENT_NINTEI_HISTORY.NINTEI_HISTORY_ID,");
        sb.append(" PATIENT_NINTEI_HISTORY.INSURER_ID,");
        sb.append(" PATIENT_NINTEI_HISTORY.INSURED_ID,");
        sb.append(" PATIENT_NINTEI_HISTORY.INSURE_RATE,");
        sb.append(" PATIENT_NINTEI_HISTORY.PLANNER,");
        sb.append(" PATIENT_NINTEI_HISTORY.PROVIDER_ID,");
        sb.append(" PATIENT_NINTEI_HISTORY.SHUBETSU_CODE,");
        sb.append(" PATIENT_NINTEI_HISTORY.CHANGE_CODE,");
        sb.append(" PATIENT_NINTEI_HISTORY.JOTAI_CODE,");
        sb.append(" PATIENT_NINTEI_HISTORY.SHINSEI_DATE,");
        sb.append(" PATIENT_NINTEI_HISTORY.NINTEI_DATE,");
        sb.append(" PATIENT_NINTEI_HISTORY.INSURE_VALID_START,");
        sb.append(" PATIENT_NINTEI_HISTORY.INSURE_VALID_END,");
        sb.append(" PATIENT_NINTEI_HISTORY.STOP_DATE,");
        sb.append(" PATIENT_NINTEI_HISTORY.STOP_REASON,");
        sb.append(" PATIENT_NINTEI_HISTORY.REPORTED_DATE,");
        sb.append(" PATIENT_NINTEI_HISTORY.LIMIT_RATE,");
        sb.append(" PATIENT_NINTEI_HISTORY.EXTERNAL_USE_LIMIT,");
        sb.append(" PATIENT_NINTEI_HISTORY.LAST_TIME");
        sb.append(" FROM");
        sb.append(" PATIENT_NINTEI_HISTORY");
        sb.append(" WHERE");
        sb.append(createWhereStatementOfNinteiHistory(targetMonth));
        sb.append(" AND(PATIENT_NINTEI_HISTORY.PATIENT_ID = " + patientID + ")");
        sb.append(" ORDER BY");
// 2014/12/17 [Yoichiro Kamei] mod - begin �V�X�e���L�����ԑΉ�
//        sb.append(" PATIENT_NINTEI_HISTORY.INSURE_VALID_START DESC");
        sb.append(" PATIENT_NINTEI_HISTORY.SYSTEM_INSURE_VALID_START DESC");
// 2014/12/17 [Yoichiro Kamei] mod - end

        //2014/01/24 [Shinobu Hitaka] edit - begin �y2014.4 �敪�x�����x�z����Ή��z
        //���p�Җ��̌��x�z���A�Ώ۔N���̌����J���ȋK��̋敪�x�����x�z�ɍ����ւ���
        //del - begin
        //return filterNotCorrespond(dbm.executeQuery(sb.toString()));
        //del - end
        VRList list = dbm.executeQuery(sb.toString());
        for (int j = 0; j < list.size(); j++) {
            VRMap record = (VRMap) list.get(j);
            int limitRate = -1;
            
            // �����J���ȋK��̋敪�x�����x�z���擾����B
            limitRate = getOfficialLimitRate(dbm, targetMonth, new Integer(1), record.getData("JOTAI_CODE").toString());
            if (limitRate > 0) {
                record.setData("LIMIT_RATE", limitRate);
            }
            // �����J���ȋK��̊O�����p�^���t����P�ʐ����擾����B
            limitRate = getOfficialLimitRate(dbm, targetMonth, new Integer(2), record.getData("JOTAI_CODE").toString());
            if (limitRate > 0) {
                record.setData("EXTERNAL_USE_LIMIT", limitRate);
            }
        }
        return filterNotCorrespond(list);
        //2014/01/24 [Shinobu Hitaka] edit - end �y2014.4 �敪�x�����x�z����Ή��z
    }

    /**
     * �v���F����擾�֐��ł��B
     * <p>
     * �w��̗v���F�藚������ł��x�����x�z�̑傫�����F�����Ԃ��܂��B
     * </p>
     * <p>
     * �v���F�藚��(history) <br />
     * <code>List{ <br />
     * Map(���p�җv�����) <br />
     * key:�t�B�[���h�� <br />
     * val:�l <br />
     * }</code>
     * </p>
     * <p>
     * �Y�����Ȃ��ꍇ�Anull��Ԃ��܂��B
     * </p>
     * 
     * @param history �v���F�藚��
     * @return �v���F����
     * @throws Exception ������O
     */
    public static VRMap getPatientInsureInfoOnMostHeavy(VRList history)
            throws Exception {
        int maxVal = 0;
        VRMap maxRow = null;
        Iterator it = history.iterator();
        while (it.hasNext()) {
            VRMap row = (VRMap) it.next();
            Object obj = VRBindPathParser.get("LIMIT_RATE", row);
            if (obj instanceof Integer) {
                int val = ((Integer) obj).intValue();
                if (val > maxVal) {
                    // �x�����x�z�̍ő�l���X�V
                    maxRow = row;
                    maxVal = val;
                }
            }
        }
        return maxRow;
    }

    /**
     * �v���F����擾�֐��ł��B
     * <p>
     * �w��̗v���F�藚������w����̗v���F�����Ԃ��܂��B
     * </p>
     * <p>
     * �v���F�藚��(history) <br />
     * <code>List{ <br />
     * Map(���p�җv�����) <br />
     * key:�t�B�[���h�� <br />
     * val:�l <br />
     * }</code>
     * </p>
     * <p>
     * �Y�����Ȃ��ꍇ�Anull��Ԃ��܂��B
     * </p>
     * 
     * @param history �v���F�藚��
     * @param targetDay �Ώ۔N����
     * @return �v���F����
     * @throws Exception ������O
     */
    public static VRMap getPatientInsureInfoOnTargetDay(VRList history,
            Date targetDay) throws Exception {
        Calendar cal = Calendar.getInstance();
        cal.setTime(targetDay);
        int targetDate = cal.get(Calendar.YEAR) * 1000
                + cal.get(Calendar.DAY_OF_YEAR);

        Iterator it = history.iterator();
        while (it.hasNext()) {
            VRMap row = (VRMap) it.next();
// 2014/12/17 [Yoichiro Kamei] mod - begin �V�X�e���L�����ԑΉ�
//            Object obj = VRBindPathParser.get("INSURE_VALID_START", row);
            Object obj = VRBindPathParser.get("SYSTEM_INSURE_VALID_START", row);
// 2014/12/17 [Yoichiro Kamei] mod - end
            if (obj instanceof Date) {
                Calendar cmp = Calendar.getInstance();
                cmp.setTime((Date) obj);
                int beginDate = cmp.get(Calendar.YEAR) * 1000
                        + cmp.get(Calendar.DAY_OF_YEAR);
                if (targetDate >= beginDate) {
                    // �J�n���Ȍ�
// 2014/12/17 [Yoichiro Kamei] mod - begin �V�X�e���L�����ԑΉ�
//                    obj = VRBindPathParser.get("INSURE_VALID_END", row);
                    obj = VRBindPathParser.get("SYSTEM_INSURE_VALID_END", row);
// 2014/12/17 [Yoichiro Kamei] mod - end
                    if (obj instanceof Date) {
                        cmp.setTime((Date) obj);
                        int endDate = cmp.get(Calendar.YEAR) * 1000
                                + cmp.get(Calendar.DAY_OF_YEAR);
                        if (targetDate <= endDate) {
                            // �I�����ȑO
                            return row;
                        }
                    }
                }
            }
        }

        return null;
    }

    // /**
    // * ���Ə����擾�֐��ł��B
    // * <p>
    // * ���Ə��T�[�r�X��񂩂玖�Ə��̒񋟂��Ă���T�[�r�X�����擾����B <br />
    // * <code>��F�\����͉�ʂ́u�T�[�r�X�̑I���v���X�g�ɃT�[�r�X���Z�b�g<br />
    // * ��������x�����Ə��̏ꍇ�A�{�݌n�T�[�r�X�ȊO��S�Ď擾����B<br />
    // * ����Ƃ��Ē񋟎��Ǝ҂Ń��O�C�������ꍇ�Ɏg���B</code>
    // * </p>
    // * <p>
    // * �Ԃ�l <br />
    // * <code>List{ <br />
    // * Map(�T�[�r�X���) <br />
    // * key:�t�B�[���h�� <br />
    // * val:�l <br />
    // * }</code><br />
    // * ASC �T�[�r�X���
    // * </p>
    // *
    // * @param dbm DBManager
    // * @return ���Ə����(�T�[�r�X���)
    // * @throws Exception ������O
    // */
    // public static VRList getProviderServiceType(ACDBManager dbm)
    // throws Exception {
    //
    // return getProviderServiceType(dbm, QkanSystemInformation.getInstance()
    // .getLoginProviderID());
    // }

    /**
     * ���Ə����擾�֐��ł��B
     * <p>
     * ���Ə����ҏW���A�I�����Ə������擾���܂��B
     * </p>
     * <p>
     * �Ԃ�l <br />
     * <code>List{ <br />
     * Map(���Ə����) <br />
     * key:�t�B�[���h�� <br />
     * val:�l <br />
     * }</code><br />
     * ASC ���Ə��ԍ�
     * </p>
     * 
     * @param dbm DBManager
     * @return ���Ə����(���Ə��ԍ���)
     * @throws Exception ������O
     */
    public static VRList getProviderInfo(ACDBManager dbm) throws Exception {
        return getProviderInfoImpl(dbm, " WHERE (PROVIDER.DELETE_FLAG = 0)");
    }

    /**
     * ���Ə����擾�֐��ł��B
     * <p>
     * �w�肵���T�[�r�X��񋟂��Ă��鎖�Ə��̏����擾���܂��B <br />
     * <code>��F������x�����Ə��݂̂��R���{�ɃZ�b�g</code>
     * </p>
     * <p>
     * �Ԃ�l <br />
     * <code>List{ <br />
     * Map(���Ə����) <br />
     * key:�t�B�[���h�� <br />
     * val:�l <br />
     * }</code><br />
     * ASC ���Ə��ԍ�
     * </p>
     * 
     * @param dbm DBManager
     * @param serviceKind �Ǝ��T�[�r�X��ރR�[�h
     * @return ���Ə����(���Ə��ԍ���)
     * @throws Exception ������O
     */
    public static VRList getProviderInfo(ACDBManager dbm, int serviceKind)
            throws Exception {
        return getProviderInfo(dbm, new int[] { serviceKind });
    }

    /**
     * ���Ə����擾�֐��ł��B
     * <p>
     * �w�肵���T�[�r�X��񋟂��Ă��鎖�Ə��̏����擾���܂��B <br />
     * <code>��F������x�����Ə��݂̂��R���{�ɃZ�b�g</code>
     * </p>
     * <p>
     * �Ԃ�l <br />
     * <code>List{ <br />
     * Map(���Ə����) <br />
     * key:�t�B�[���h�� <br />
     * val:�l <br />
     * }</code><br />
     * ASC ���Ə��ԍ�
     * </p>
     * 
     * @param dbm DBManager
     * @param serviceKind �Ǝ��T�[�r�X��ރR�[�h
     * @return ���Ə����(���Ə��ԍ���)
     * @throws Exception ������O
     */
    public static VRList getProviderInfo(ACDBManager dbm, int[] serviceKind)
            throws Exception {
        StringBuilder sb = new StringBuilder();
        sb.append(" ,PROVIDER_SERVICE");
        sb.append(" WHERE");
        sb.append(" (PROVIDER.PROVIDER_ID = PROVIDER_SERVICE.PROVIDER_ID)");
        if (serviceKind != null) {
            int end = serviceKind.length;
            if (end > 0) {
                sb.append(" AND(PROVIDER_SERVICE.SYSTEM_SERVICE_KIND_DETAIL IN(");
                sb.append(serviceKind[0]);
                for (int i = 1; i < end; i++) {
                    sb.append(",");
                    sb.append(serviceKind[i]);
                }
                sb.append("))");
            }
        }
        sb.append(" AND(PROVIDER.DELETE_FLAG = 0)");
        return getProviderInfoImpl(dbm, sb.toString());

    }

    /**
     * ���Ə����擾�֐��ł��B
     * <p>
     * �w�肵���T�[�r�X��񋟂��Ă��鎖�Ə��̏����擾���܂��B <br />
     * <code>��F������x�����Ə��̃T�[�r�X�\���ʂ̎��Ə��R���{�ɃZ�b�g</code>
     * </p>
     * <p>
     * �Ԃ�l <br />
     * <code>List{ <br />
     * Map(���Ə����) <br />
     * key:�t�B�[���h�� <br />
     * val:�l <br />
     * }</code><br />
     * ASC ���Ə��ԍ�
     * </p>
     * 
     * @param dbm DBManager
     * @param serviceKind �Ǝ��T�[�r�X��ރR�[�h�W��
     * @return ���Ə����(���Ə��ԍ���)
     * @throws Exception ������O
     */
    public static VRList getProviderInfo(ACDBManager dbm, List serviceKinds)
            throws Exception {
        StringBuilder sb = new StringBuilder();
        sb.append(" ,PROVIDER_SERVICE");
        sb.append(" WHERE");
        sb.append(" (PROVIDER.PROVIDER_ID = PROVIDER_SERVICE.PROVIDER_ID)");
        int last = serviceKinds.size() - 1;
        if (last >= 0) {
            sb.append(" AND(PROVIDER_SERVICE.SYSTEM_SERVICE_KIND_DETAIL IN(");
            for (int i = 0; i < last; i++) {
                sb.append(String.valueOf(serviceKinds.get(i)) + ",");
            }
            sb.append(String.valueOf(serviceKinds.get(last)) + "))");
        }
        sb.append(" AND(PROVIDER.DELETE_FLAG = 0)");
        return getProviderInfoImpl(dbm, sb.toString());
    }

    /**
     * ���Ə����擾�֐��ł��B
     * <p>
     * ���Ə����ҏW���A�I�����Ə������擾���܂��B
     * </p>
     * <p>
     * �Ԃ�l <br />
     * <code>List{ <br />
     * Map(���Ə����) <br />
     * key:�t�B�[���h�� <br />
     * val:�l <br />
     * }</code><br />
     * ASC ���Ə��ԍ�
     * </p>
     * 
     * @param dbm DBManager
     * @param providerID ���Ə��ԍ�
     * @return ���Ə����(���Ə��ԍ���)
     * @throws Exception ������O
     */
    public static VRList getProviderInfo(ACDBManager dbm, String providerID)
            throws Exception {
        if (ACTextUtilities.isNullText(providerID)) {
            return getProviderInfoImpl(dbm, null);
        }
        return getProviderInfoImpl(dbm, " WHERE (PROVIDER.PROVIDER_ID = '"
                + providerID + "')");
    }

    // /**
    // * ���p�җv�����擾�֐��ł��B
    // * <p>
    // * �w��̗��p�҂̗v�������擾���܂��B
    // * </p>
    // * <p>
    // * ���p�҂̊�{���͎擾���܂���B
    // * </p>
    // * <p>
    // * ���������ɗv�����2�ȏ㑶�݂���ꍇ�A�x�����x�z���ł��傫������ԍ����V�������̂��擾���܂��B
    // * </p>
    // * <p>
    // * �Ԃ�l <br />
    // * <code>List{ <br />
    // * Map(���p�җv�����) <br />
    // * key:�t�B�[���h�� <br />
    // * val:�l <br />
    // * }</code><br />
    // * ASC ���p��ID
    // * </p>
    // *
    // * @param dbm DBManager
    // * @param targetMonth �Ώ۔N��
    // * @param patientID ���p�Ҕԍ�
    // * @param filterSubQueryBegin �i���ݏ����̃T�u�N�G����WHERE��܂ł�SQL��
    // * @param filterSubQueryEnd �i���ݏ����̃T�u�N�G����WHERE��ȍ~��SQL��
    // * @return ��������
    // * @throws Exception ������O
    // */
    // protected static VRList getPatientInsureInfoImpl(ACDBManager dbm,
    // Date targetMonth, int patientID, String filterSubQueryBegin,
    // String filterSubQueryEnd) throws Exception {
    // if (dbm == null) {
    // return new VRArrayList();
    // }
    //
    // StringBuilder sb;
    //
    // // FROM�`�v���x�ȊO��WHERE��܂�
    // sb = new StringBuilder();
    // sb.append(" FROM");
    // sb.append(" PATIENT_NINTEI_HISTORY");
    // sb.append(" WHERE");
    //
    // // �L�����Ԃ��`�F�b�N����SQL��
    // sb.append(createWhereStatementOfNinteiHistory(targetMonth));
    //
    // if (patientID >= 0) {
    // // ���p�҂ōi�荞�ޏꍇ
    // sb.append(" AND(PATIENT_NINTEI_HISTORY.PATIENT_ID = " + patientID
    // + ")");
    // }
    // String fromWhere = sb.toString();
    //
    // // ���C��SQL�����\�z
    // sb = new StringBuilder();
    // sb.append("SELECT");
    // sb.append(" PATIENT_NINTEI_HISTORY.PATIENT_ID,");
    // sb.append(" PATIENT_NINTEI_HISTORY.NINTEI_HISTORY_ID,");
    // sb.append(" PATIENT_NINTEI_HISTORY.INSURER_ID,");
    // sb.append(" PATIENT_NINTEI_HISTORY.INSURED_ID,");
    // sb.append(" PATIENT_NINTEI_HISTORY.INSURE_RATE,");
    // sb.append(" PATIENT_NINTEI_HISTORY.PLANNER,");
    // sb.append(" PATIENT_NINTEI_HISTORY.PROVIDER_ID,");
    // sb.append(" PATIENT_NINTEI_HISTORY.SHUBETSU_CODE,");
    // sb.append(" PATIENT_NINTEI_HISTORY.CHANGE_CODE,");
    // sb.append(" PATIENT_NINTEI_HISTORY.JOTAI_CODE,");
    // sb.append(" PATIENT_NINTEI_HISTORY.SHINSEI_DATE,");
    // sb.append(" PATIENT_NINTEI_HISTORY.NINTEI_DATE,");
    // sb.append(" PATIENT_NINTEI_HISTORY.INSURE_VALID_START,");
    // sb.append(" PATIENT_NINTEI_HISTORY.INSURE_VALID_END,");
    // sb.append(" PATIENT_NINTEI_HISTORY.STOP_DATE,");
    // sb.append(" PATIENT_NINTEI_HISTORY.STOP_REASON,");
    // sb.append(" PATIENT_NINTEI_HISTORY.REPORTED_DATE,");
    // sb.append(" PATIENT_NINTEI_HISTORY.LIMIT_RATE,");
    // sb.append(" PATIENT_NINTEI_HISTORY.EXTERNAL_USE_LIMIT");
    // sb.append(fromWhere);
    //
    // if (!ACTextUtilities.isNullText(filterSubQueryBegin)) {
    // // �T�u�N�G���ɂ��i����
    // // ��Ɏx�����x�z�⌎������ɂ���
    // sb.append(filterSubQueryBegin);
    // sb.append(fromWhere);
    // if (filterSubQueryEnd != null) {
    // sb.append(filterSubQueryEnd);
    // }
    //
    // }
    //
    // sb.append(" ORDER BY");
    // sb.append(" PATIENT_NINTEI_HISTORY.PATIENT_ID ASC,");
    // sb.append(" PATIENT_NINTEI_HISTORY.NINTEI_HISTORY_ID DESC");
    //
    // VRList result = dbm.executeQuery(sb.toString());
    //
    // // �O��F��D����l�����������ʂ���Ώی��̗����ƌ������ꂽ���p�ҏ��𒊏o����
    // VRList filteredResult = new VRArrayList();
    // boolean mustNextPatient = false;
    // VRMap targetRow = null;
    // Object processPatientID = null;
    // Iterator it = result.iterator();
    // while (it.hasNext()) {
    // VRMap row = (VRMap) it.next();
    // Object obj = VRBindPathParser.get("PATIENT_ID", row);
    // // ���p�Ҕԍ��̕ω����r
    // if (!obj.equals(processPatientID)) {
    // if (processPatientID == null) {
    // // ����
    // processPatientID = obj;
    // } else {
    // // ���̗��p�҂ɐ؂�ւ�����̂Ŋ����̗��p�҂��m��
    // filteredResult.addData(targetRow);
    // }
    // mustNextPatient = false;
    // } else if (mustNextPatient) {
    // // �K�p����F�肪�m��ς݂ɂ����̗��p�҂�T��
    // continue;
    // }
    // targetRow = row;
    // // ���ꗘ�p�ҁE���ԁE�v���x�̂����A�ŏ��̍s(�ŐV�̔F�藚��)�𓖊Y�D��F�藚���Ƃ���
    // mustNextPatient = true;
    //
    // }
    //
    // if (targetRow != null) {
    // // �Ō�ɔ����������p�҂��m�肷��
    // filteredResult.addData(targetRow);
    // }
    //
    // return filteredResult;
    // }
    /**
     * ���Ə����擾�֐��ł��B
     * <p>
     * ���Ə����ҏW���A�I�����Ə������擾���܂��B
     * </p>
     * <p>
     * �Ԃ�l <br />
     * <code>List{ <br />
     * Map(���Ə����) <br />
     * key:�t�B�[���h�� <br />
     * val:�l <br />
     * }</code><br />
     * ASC ���Ə��ԍ�
     * </p>
     * 
     * @param dbm DBManager
     * @param where �i���݋�
     * @return ���Ə����(���Ə��ԍ���)
     * @throws Exception ������O
     */
    public static VRList getProviderInfoCustom(ACDBManager dbm, String where)
            throws Exception {
        return getProviderInfoImpl(dbm, where);
    }

    /**
     * ���Ə������ڍ׏��擾�֐��ł��B
     * <p>
     * ���Ə����ҏW��ʁA���p�[�E�񋟕[�A���яW�v���ɁA���Ə��̒񋟃T�[�r�X�̏ڍ׏����擾���܂��B
     * </p>
     * <p>
     * �Ԃ�l <br />
     * <code>List{ <br />
     * Map(���Ɛ����e���E���Ɛ����ڍ׏��) <br />
     * key:�t�B�[���h���E�ڍ׎�� <br />
     * val:�l <br />
     * }</code><br />
     * ASC �T�[�r�X���
     * </p>
     * 
     * @param dbm DBManager
     * @param providerID ���Ə��ԍ�
     * @return ���Ə������ڍ׏��(�T�[�r�X��ޏ�)
     * @throws Exception ������O
     */
    public static VRList getProviderServiceDetail(ACDBManager dbm,
            String providerID) throws Exception {
        StringBuilder sb = new StringBuilder();
        // sb.append(" AND(PROVIDER_SERVICE.PROVIDER_ID = '" + providerID +
        // "')");
        sb.append(" (PROVIDER_SERVICE.PROVIDER_ID = '" + providerID + "')");
        return getProviderServiceDetailCustom(dbm, sb.toString());
    }

    /**
     * ���Ə������ڍ׏��擾�֐��ł��B
     * <p>
     * ���Ə����ҏW��ʁA���p�[�E�񋟕[�A���яW�v���ɁA���Ə��̒񋟃T�[�r�X�̏ڍ׏����擾���܂��B
     * </p>
     * <p>
     * �Ԃ�l <br />
     * <code>List{ <br />
     * Map(���Ɛ����e���E���Ɛ����ڍ׏��) <br />
     * key:�t�B�[���h���E�ڍ׎�� <br />
     * val:�l <br />
     * }</code><br />
     * ASC �T�[�r�X���
     * </p>
     * 
     * @param dbm DBManager
     * @param providerID ���Ə��ԍ�
     * @param serviceKind �Ǝ��T�[�r�X��ރR�[�h
     * @return ���Ə������ڍ׏��(�T�[�r�X��ޏ�)
     * @throws Exception ������O
     */
    public static VRList getProviderServiceDetail(ACDBManager dbm,
            String providerID, int serviceKind) throws Exception {
        StringBuilder sb = new StringBuilder();
        // sb.append(" AND(PROVIDER_SERVICE.PROVIDER_ID = '" + providerID +
        // "')");
        sb.append(" (PROVIDER_SERVICE.PROVIDER_ID = '" + providerID + "')");
        sb.append(" AND(PROVIDER_SERVICE.SYSTEM_SERVICE_KIND_DETAIL = "
                + serviceKind + ")");
        return getProviderServiceDetailCustom(dbm, sb.toString());
    }

    /**
     * ���Ə������ڍ׏��擾�֐��ł��B
     * <p>
     * ���Ə����ҏW��ʁA���p�[�E�񋟕[�A���яW�v���ɁA���Ə��̒񋟃T�[�r�X�̏ڍ׏����擾���܂��B
     * </p>
     * <p>
     * �Ԃ�l <br />
     * <code>List{ <br />
     * Map(���Ɛ����e���E���Ɛ����ڍ׏��) <br />
     * key:�t�B�[���h���E�ڍ׎�� <br />
     * val:�l <br />
     * }</code><br />
     * ASC �T�[�r�X���
     * </p>
     * 
     * @param dbm DBManager
     * @param where �e����where��
     * @return ���Ə������ڍ׏��(�T�[�r�X��ޏ�)
     * @throws Exception ������O
     */
    public static VRArrayList getProviderServiceDetailCustom(ACDBManager dbm,
            String where) throws Exception {
        if (dbm == null) {
            return new VRArrayList();
        }

        // where = appendFrontAnd(where);
        if (ACTextUtilities.isNullText(where)) {
            where = "";
        } else {
            where = " WHERE" + where;
        }

        StringBuilder sb;

        TreeMap result = new TreeMap();
        final String[] shareFields = new String[] { "PROVIDER_ID",
                "PROVIDER_SERVICE_ID", "SYSTEM_SERVICE_KIND_DETAIL",
                "REDUCT_RATE", "LAST_TIME" };

        // ������^�A���l�^�A���t�^
        // �������͕K�����݂��邽�߁A�e����INT�e�[�u������̂ݎ擾
        String[] tableNames = new String[] { "PROVIDER_SERVICE_DETAIL_INTEGER",
                "PROVIDER_SERVICE_DETAIL_TEXT", "PROVIDER_SERVICE_DETAIL_DATE" };

        // SQL���̋��ʕ������\�z
        sb = new StringBuilder();
        sb.append("SELECT");
        sb.append(" PROVIDER_SERVICE.PROVIDER_SERVICE_ID,");
        sb.append(" PROVIDER_SERVICE.PROVIDER_ID,");
        sb.append(" PROVIDER_SERVICE.SYSTEM_SERVICE_KIND_DETAIL,");
        sb.append(" PROVIDER_SERVICE.REDUCT_RATE,");
        sb.append(" PROVIDER_SERVICE.LAST_TIME,");
        String header = sb.toString();
        int end = tableNames.length;
        for (int i = 0; i < end; i++) {
            String tableName = tableNames[i];
            sb = new StringBuilder(header);
            sb.append(" " + tableName + ".SYSTEM_BIND_PATH,");
            sb.append(" " + tableName + ".DETAIL_VALUE");
            sb.append(" FROM");
            sb.append(" PROVIDER_SERVICE");
            sb.append(" LEFT JOIN ");
            sb.append(tableName);
            sb.append(" ON");
            sb.append(" (PROVIDER_SERVICE.PROVIDER_SERVICE_ID = " + tableName
                    + ".PROVIDER_SERVICE_ID)");
            // sb.append("," + tableName);
            // sb.append(" WHERE");
            // sb.append(" (PROVIDER_SERVICE.PROVIDER_SERVICE_ID = " + tableName
            // + ".PROVIDER_SERVICE_ID)");
            sb.append(where);

            // ���ʕ����̍��v���郌�R�[�h���}�[�W
            restractureDetail(result, dbm.executeQuery(sb.toString()),
                    "PROVIDER_SERVICE_ID", shareFields);
        }
        return new VRArrayList(result.values());

    }

    /**
     * ���Ə����擾�֐��ł��B
     * <p>
     * ���Ə��T�[�r�X��񂩂玖�Ə��̒񋟂��Ă���T�[�r�X�����擾����B <br />
     * <code>��F�\����͉�ʂ́u�T�[�r�X�̑I���v���X�g�ɃT�[�r�X���Z�b�g<br />
     * ��������x�����Ə��̏ꍇ�A�{�݌n�T�[�r�X�ȊO��S�Ď擾����B<br />
     * ����Ƃ��Ē񋟎��Ǝ҂Ń��O�C�������ꍇ�Ɏg���B</code>
     * </p>
     * <p>
     * �Ԃ�l <br />
     * <code>List{ <br />
     * Map(�T�[�r�X���) <br />
     * key:�t�B�[���h�� <br />
     * val:�l <br />
     * }</code><br />
     * ASC �T�[�r�X���
     * </p>
     * 
     * @param dbm DBManager
     * @param providerID ���Ə��ԍ�
     * @return ���Ə����(�T�[�r�X���)
     * @throws Exception ������O
     */
    public static VRList getProviderServiceType(ACDBManager dbm,
            String providerID) throws Exception {
        StringBuilder sb;

        sb = new StringBuilder();
        sb.append("SELECT");
        sb.append(" PROVIDER.PROVIDER_ID,");
        sb.append(" PROVIDER.PROVIDER_TYPE,");
        sb.append(" PROVIDER.MEDICAL_FLAG,");
        // sb.append(" PROVIDER.PROVIDER_KANA,");
        sb.append(" PROVIDER.PROVIDER_NAME,");
        sb.append(" PROVIDER.PROVIDER_ZIP_FIRST,");
        sb.append(" PROVIDER.PROVIDER_ZIP_SECOND,");
        sb.append(" PROVIDER.PROVIDER_ADDRESS,");
        sb.append(" PROVIDER.PROVIDER_TEL_FIRST,");
        sb.append(" PROVIDER.PROVIDER_TEL_SECOND,");
        sb.append(" PROVIDER.PROVIDER_TEL_THIRD,");
        sb.append(" PROVIDER.PROVIDER_FAX_FIRST,");
        sb.append(" PROVIDER.PROVIDER_FAX_SECOND,");
        sb.append(" PROVIDER.PROVIDER_FAX_THIRD,");
        sb.append(" PROVIDER.PROVIDER_JIJIGYOUSHO_TYPE,");
        sb.append(" PROVIDER.PROVIDER_JIGYOU_TYPE,");
        sb.append(" PROVIDER.PROVIDER_AREA_TYPE,");
        sb.append(" PROVIDER.SPECIAL_AREA_FLAG,");
        sb.append(" PROVIDER.SHAFUKU_GENMEN_FLAG,");
        sb.append(" PROVIDER.PROVIDER_OWNER_NAME,");
        sb.append(" PROVIDER.BANK_NAME,");
        sb.append(" PROVIDER.BANK_BRANCH_NAME,");
        sb.append(" PROVIDER.ACCOUNT_NUMBER,");
        sb.append(" PROVIDER.ACCOUNT_TYPE,");
        sb.append(" PROVIDER.ACCOUNT_HOLDER,");
        sb.append(" PROVIDER_SERVICE.PROVIDER_SERVICE_ID,");
        sb.append(" PROVIDER_SERVICE.SYSTEM_SERVICE_KIND_DETAIL,");
        sb.append(" PROVIDER_SERVICE.REDUCT_RATE");
        sb.append(" FROM");
        sb.append(" PROVIDER_SERVICE,");
        sb.append(" PROVIDER");
        sb.append(" WHERE");
        sb.append(" (PROVIDER_SERVICE.PROVIDER_ID = '" + providerID + "')");
        sb.append(" AND(PROVIDER_SERVICE.PROVIDER_ID = PROVIDER.PROVIDER_ID)");
        sb.append(" ORDER BY");
        sb.append(" SYSTEM_SERVICE_KIND_DETAIL ASC");

        if (dbm == null) {
            return new VRArrayList();
        }
        return dbm.executeQuery(sb.toString());
    }

    /**
     * �T�[�r�X�ڍ׏��擾�֐��ł��B
     * <p>
     * ���O�C�����Ə��̃T�[�r�X�\��E���щ�ʕ\�����ɁA�T�[�r�X�̏ڍ׏����擾���܂��B
     * </p>
     * <p>
     * �Ԃ�l <br />
     * �T�[�r�XID{ <br />
     * Map(�T�[�r�X�e���E�ڍ׏��) <br />
     * key:�t�B�[���h���E�ڍ׎�� <br />
     * val:�l</code><br />
     * ASC �T�[�r�XID
     * </p>
     * <p>
     * �����u�擾�敪�v�ɂ͈ȉ��̒l���w�肵�܂��B <br />
     * 101-�\��(SERVICE_DETAIL_GET_PLAN) <br />
     * 102-����(SERVICE_DETAIL_GET_RESULT)<br/>
     * 103-�\��̌��ԕ����̂�(SERVICE_DETAIL_GET_PLAN_OF_MONTHLY_ONLY)
     * </p>
     * <p>
     * �����Ǘ��e�[�u�����X�V����\�������邽�߁A�g�����U�N�V�����̒��Ŏ��s���Ă��������B
     * </p>
     * 
     * @param dbm DBManager
     * @param patientID ���p��ID
     * @param targetMonth �Ώ۔N��
     * @param useType �擾�敪
     * @return �T�[�r�X�ڍ׏��(�T�[�r�XID��)
     * @throws Exception ������O
     */
    public static VRList getServiceDetail(ACDBManager dbm, int patientID,
            Date targetMonth, int useType) throws Exception {
        return getServiceDetail(dbm, patientID, targetMonth, useType,
                QkanSystemInformation.getInstance().getLoginProviderID());
    }

    /**
     * �T�[�r�X�ڍ׏��擾�֐��ł��B
     * <p>
     * �T�[�r�X�\��E���щ�ʕ\�����ɁA�T�[�r�X�̏ڍ׏����擾���܂��B
     * </p>
     * <p>
     * �Ԃ�l <br />
     * �T�[�r�XID{ <br />
     * Map(�T�[�r�X�e���E�ڍ׏��) <br />
     * key:�t�B�[���h���E�ڍ׎�� <br />
     * val:�l</code><br />
     * ASC �T�[�r�XID
     * </p>
     * <p>
     * �����u�擾�敪�v�ɂ͈ȉ��̒l���w�肵�܂��B <br />
     * 101-�\��(SERVICE_DETAIL_GET_PLAN) <br />
     * 102-����(SERVICE_DETAIL_GET_RESULT)<br/>
     * 103-�\��̌��ԕ����̂�(SERVICE_DETAIL_GET_PLAN_OF_MONTHLY_ONLY)
     * </p>
     * <p>
     * �����Ǘ��e�[�u�����X�V����\�������邽�߁A�g�����U�N�V�����̒��Ŏ��s���Ă��������B
     * </p>
     * 
     * @param dbm DBManager
     * @param patientID ���p��ID
     * @param targetMonth �Ώ۔N��
     * @param useType �擾�敪
     * @param providerID ���Ə��ԍ�
     * @return �T�[�r�X�ڍ׏��(�T�[�r�XID��)
     * @throws Exception ������O
     */
    public static VRList getServiceDetail(ACDBManager dbm, int patientID,
            Date targetMonth, int useType, String providerID) throws Exception {
        Calendar cal = Calendar.getInstance();
        cal.setTime(targetMonth);
        String ym = VRDateParser.format(cal, "yyyy/MM");

        StringBuilder sb = new StringBuilder();
        // sb.append(" AND(SERVICE.LOGIN_PROVIDER_ID = '" + providerID + "')");
        sb.append(" AND(SERVICE.PATIENT_ID = " + patientID + ")");
        sb.append(" AND(SERVICE.SERVICE_DATE >= '" + ym + "/01')");
        sb.append(" AND(SERVICE.SERVICE_DATE <= '" + ym + "/"
                + cal.getActualMaximum(Calendar.DAY_OF_MONTH) + "')");

        sb.append(" AND");
        sb.append(getServiceUseTypeSQLWithoutAnd(useType));

        return getServiceDetailCustom(dbm, targetMonth, sb.toString());
    }

    /**
     * �w���WHERE��������Ɍ��������T�[�r�X�ڍ׏���Ԃ��܂��B
     * <p>
     * �Ԃ�l <br />
     * �T�[�r�XID{ <br />
     * Map(�T�[�r�X�e���E�ڍ׏��) <br />
     * key:�t�B�[���h���E�ڍ׎�� <br />
     * val:�l</code><br />
     * ASC �T�[�r�XID
     * </p>
     * <p>
     * �����Ǘ��e�[�u�����X�V����\�������邽�߁A�g�����U�N�V�����̒��Ŏ��s���Ă��������B
     * </p>
     * 
     * @param dbm DBManager
     * @param where ��������
     * @return ��������
     * @throws Exception ������O
     */
    public static VRList getServiceDetailCustom(ACDBManager dbm,
            Date targetMonth, String where) throws Exception {
        StringBuilder sb;

        if (dbm == null) {
            return new VRArrayList();
        }
        where = appendFrontWhere(where);

        String tableSaffix;
        // �e�[�u��������̏C������擾
        if (targetMonth == null) {
            targetMonth = ACDateUtilities.createDate(2006, 4);
        }
        int modify = getSeparateTableManager().getTableModifyFromDate(dbm,
                "SERVICE_DETAIL", targetMonth);
        // �Ǘ��e�[�u���̍X�V�����肤��̂Ńg�����U�N�V�������R�~�b�g
        if (modify < 0) {
            return new VRArrayList();
        }
        // �쐬�����e�[�u�����́u���̃e�[�u����_�N�x�v�ƂȂ�
        tableSaffix = "_" + modify;

        TreeMap result = new TreeMap();
        // 3�e�[�u���̒l���擾���A���ʕ����̍��v���郌�R�[�h���}�[�W
        final String[] shareFields = new String[] {
                "SERVICE_ID",
                // "LOGIN_PROVIDER_ID",
                "SERVICE_USE_TYPE", "PATIENT_ID", "PROVIDER_ID",
                "SYSTEM_SERVICE_KIND_DETAIL", "SERVICE_DATE", "WEEK_DAY",
                "LAST_TIME",
                // "SERVICE_CODE_ITEM",
                // "EXPENSES_FLAG",
                "REGULATION_RATE" };
        // ������^�A���l�^�A���t�^
        String[] tableNames = new String[] { "SERVICE_DETAIL_TEXT",
                "SERVICE_DETAIL_INTEGER", "SERVICE_DETAIL_DATE" };
        // SQL���̋��ʕ������\�z
        sb = new StringBuilder();
        sb.append("SELECT");
        sb.append(" SERVICE.SERVICE_ID,");
        // sb.append(" SERVICE.LOGIN_PROVIDER_ID,");
        sb.append(" SERVICE.SERVICE_USE_TYPE,");
        sb.append(" SERVICE.PATIENT_ID,");
        sb.append(" SERVICE.PROVIDER_ID,");
        sb.append(" SERVICE.SYSTEM_SERVICE_KIND_DETAIL,");
        sb.append(" SERVICE.SERVICE_DATE,");
        sb.append(" SERVICE.WEEK_DAY,");
        // sb.append(" SERVICE.EXPENSES_FLAG,");
        sb.append(" SERVICE.REGULATION_RATE,");
        // sb.append(" SERVICE.LAST_TIME,");
        // sb.append(" SERVICE_EXPENSES.SERVICE_CODE_ITEM,");
        // sb.append(" SERVICE_EXPENSES.EXPENSES_FLAG,");
        // sb.append(" SERVICE_EXPENSES.REGULATION_RATE,");
        String header = sb.toString();
        int end = tableNames.length;
        for (int i = 0; i < end; i++) {
            String tableName = tableNames[i] + tableSaffix;
            sb = new StringBuilder(header);
            sb.append(" " + tableName + ".SYSTEM_BIND_PATH,");
            sb.append(" " + tableName + ".DETAIL_VALUE");
            sb.append(" FROM");
            sb.append(" SERVICE");
            // sb.append(",SERVICE_EXPENSES");
            sb.append(" LEFT JOIN ");
            sb.append(tableName);
            sb.append(" ON (SERVICE.SERVICE_ID = " + tableName + ".SERVICE_ID)");
            // sb.append(" WHERE");
            // sb.append(" AND(SERVICE.SERVICE_ID =
            // SERVICE_EXPENSES.SERVICE_ID)");
            sb.append(where);
            // ���ʕ����̍��v���郌�R�[�h���}�[�W
            restractureDetail(result, dbm.executeQuery(sb.toString()),
                    "SERVICE_ID", shareFields);
        }

        return new VRArrayList(result.values());
    }

    /**
     * �T�[�r�X�p�^�[���ڍ׏��擾�֐��ł��B
     * <p>
     * ���O�C�����Ə��̃T�[�r�X�\��E���щ�ʕ\�����ɁA�T�[�r�X�p�^�[���̏ڍ׏����擾���܂��B
     * </p>
     * <p>
     * �Ԃ�l <br />
     * <code>List{ <br />
     * Map(�T�[�r�X�p�^�[���e���E�ڍ׏��) <br />
     * key:�t�B�[���h���E�ڍ׎�� <br />
     * val:�l<br />
     * }</code><br />
     * ASC �T�[�r�XID
     * </p>
     * <p>
     * �����Ǘ��e�[�u�����X�V����\�������邽�߁A�g�����U�N�V�����̒��Ŏ��s���Ă��������B
     * </p>
     * 
     * @param dbm DBManager
     * @return �T�[�r�X�p�^�[���ڍ׏��(�T�[�r�XID��)
     * @throws Exception ������O
     */
    public static VRList getServicePatternDetail(ACDBManager dbm)
            throws Exception {
        StringBuilder sb = new StringBuilder();
        sb.append(" AND(SERVICE.SERVICE_USE_TYPE = "
                + QkanConstants.SERVICE_USE_TYPE_PATTERN + ")");
        // sb.append(" AND(SERVICE.LOGIN_PROVIDER_ID = '"
        // + QkanSystemInformation.getInstance().getLoginProviderID()
        // + "')");

        return getServiceDetailCustom(dbm, null, sb.toString());
    }

    /**
     * �T�[�r�X�p�^�[���ڍ׏��擾�֐��ł��B
     * <p>
     * ���O�C�����Ə��̃T�[�r�X�\��E���щ�ʕ\�����ɁA�T�[�r�X�p�^�[���̏ڍ׏����擾���܂��B
     * </p>
     * <p>
     * �Ԃ�l <br />
     * <code>List{ <br />
     * Map(�T�[�r�X�p�^�[���e���E�ڍ׏��) <br />
     * key:�t�B�[���h���E�ڍ׎�� <br />
     * val:�l<br />
     * }</code><br />
     * ASC �T�[�r�XID
     * </p>
     * <p>
     * �����Ǘ��e�[�u�����X�V����\�������邽�߁A�g�����U�N�V�����̒��Ŏ��s���Ă��������B
     * </p>
     * 
     * @param dbm DBManager
     * @param serviceKind �Ǝ��T�[�r�X��ރR�[�h
     * @return �T�[�r�X�p�^�[���ڍ׏��(�T�[�r�XID��)
     * @throws Exception ������O
     */
    public static VRList getServicePatternDetail(ACDBManager dbm,
            int serviceKind) throws Exception {
        StringBuilder sb = new StringBuilder();
        sb.append(" AND(SERVICE.SERVICE_USE_TYPE = "
                + QkanConstants.SERVICE_USE_TYPE_PATTERN + ")");
        // sb.append(" AND(SERVICE.LOGIN_PROVIDER_ID = '"
        // + QkanSystemInformation.getInstance().getLoginProviderID()
        // + "')");
        sb.append(" AND(SERVICE.SYSTEM_SERVICE_KIND_DETAIL = " + serviceKind
                + ")");
        return getServiceDetailCustom(dbm, null, sb.toString());
    }

    /**
     * �T�[�r�X�p�^�[���ڍ׏��擾�֐��ł��B
     * <p>
     * �T�[�r�X�\��E���щ�ʕ\�����ɁA�T�[�r�X�p�^�[���̏ڍ׏����擾���܂��B
     * </p>
     * <p>
     * �Ԃ�l <br />
     * <code>List{ <br />
     * Map(�T�[�r�X�p�^�[���e���E�ڍ׏��) <br />
     * key:�t�B�[���h���E�ڍ׎�� <br />
     * val:�l<br />
     * }</code><br />
     * ASC �T�[�r�XID
     * </p>
     * <p>
     * �����Ǘ��e�[�u�����X�V����\�������邽�߁A�g�����U�N�V�����̒��Ŏ��s���Ă��������B
     * </p>
     * 
     * @param dbm DBManager
     * @param where �e���ɑ΂���where��
     * @return �T�[�r�X�p�^�[���ڍ׏��(�T�[�r�XID��)
     * @throws Exception ������O
     */
    public static VRList getServicePatternDetailCustom(ACDBManager dbm,
            String where) throws Exception {
        StringBuilder sb = new StringBuilder();
        sb.append(" AND(SERVICE.SERVICE_USE_TYPE = "
                + QkanConstants.SERVICE_USE_TYPE_PATTERN + ")");
        sb.append(where);
        return getServiceDetailCustom(dbm, null, sb.toString());
    }

    /**
     * �w���ʍ��ڈȉ��̖����ȃ��W�I�O���[�v/�e�L�X�g/�`�F�b�N�̃o�C���h�p�X��������Map���珜�O���܂��B
     * 
     * @param target �Ώ�
     * @param map �L�[�}�b�v
     */
    public static void removeDisabledBindPath(Component target, Map map) {
        if ((target instanceof VRRadioButtonGroup)
                || (target instanceof AbstractVRTextField)
                || (target instanceof AbstractVRCheckBox)
                || (target instanceof AbstractVRComboBox)) {
            if (!target.isEnabled()) {
                map.remove(((VRBindable) target).getBindPath());
            }
        } else if (target instanceof Container) {
            int end = ((Container) target).getComponentCount();
            for (int i = 0; i < end; i++) {
                // �ċA
                removeDisabledBindPath(((Container) target).getComponent(i),
                        map);
            }
        }

    }

    /**
     * [key=Component,value=Boolean]�`����Map�����ʍ��ڂ�Enabled��Ԃ𕜌����܂��B
     * 
     * @param map ���X�g�A���}�b�v
     */
    public static void restoreEnabled(Map map) {
        if (map != null) {
            Iterator it = map.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry ent = (Map.Entry) it.next();
                if (ent.getKey() instanceof Component) {
                    if (ent.getValue() instanceof Boolean) {
                        ((Component) ent.getKey()).setEnabled(((Boolean) ent
                                .getValue()).booleanValue());
                    }
                }
            }
        }
    }

    /**
     * �w���ʍ��ڈȉ��̃��W�I�O���[�v�ɑ΂��A���ׂčŏ��̃��W�I��I�������܂��B
     * 
     * @param target �Ώ�
     */
    public static void selectFirstRadioItem(Component target) {
        if (target instanceof VRRadioButtonGroup) {
            // ��ڂ̍��ڂ�I������
            if (((VRRadioButtonGroup) target).getButtonCount() > 0) {
                ((VRRadioButtonGroup) target).getButton(1).setSelected(true);
            }
        } else if (target instanceof JCheckBox) {
            ((JCheckBox) target).setSelected(false);
        } else if (target instanceof Container) {
            int end = ((Container) target).getComponentCount();
            for (int i = 0; i < end; i++) {
                // �ċA
                selectFirstRadioItem(((Container) target).getComponent(i));
            }
        }

    }

    /**
     * �ꗗ�̌��������ƂȂ镶�����Trim���̏������s�Ȃ��ĕԂ��܂��B
     * <p>
     * �V�X�e���S�̂Ƃ��ē���̋����������邽�߂ɒʂ��֐��ł��B�����_�ł͂��̂܂ܕԂ��܂��B
     * </p>
     * 
     * @param text �ϊ���
     * @return �ϊ�����
     */
    public static String toFindString(String text) {
        return text;
    }

    /**
     * ������" "�ŘA�����ĕԂ��܂��B
     * <p>
     * ���������ׂ�null�������͋󕶎��̏ꍇ�͋󕶎���Ԃ��܂��B
     * </p>
     * 
     * @param firstName ��
     * @param secondName ��
     * @return �A������
     */
    public static String toFullName(Object firstName, Object secondName) {
        if (ACTextUtilities.isNullText(firstName)) {
            if (ACTextUtilities.isNullText(secondName)) {
                return "";
            }
            return "�@" + secondName;
        }
        if (ACTextUtilities.isNullText(secondName)) {
            return firstName + "�@";
        }
        return firstName + "�@" + secondName;
    }

    /**
     * �d�b�ԍ���"-"�ŘA�����ĕԂ��܂��B
     * <p>
     * ���������ׂ�null�������͋󕶎��̏ꍇ�͋󕶎���Ԃ��܂��B
     * </p>
     * 
     * @param tel1 �s�O�ǔ�
     * @param tel2 �s���ǔ�
     * @param tel3 �����Ҕԍ�
     * @return �A������
     */
    public static String toTel(Object tel1, Object tel2, Object tel3) {
        if (ACTextUtilities.isNullText(tel1)) {
            if (ACTextUtilities.isNullText(tel2)) {
                if (ACTextUtilities.isNullText(tel3)) {
                    return "";
                }
                return "--" + tel3;
            }
            if (ACTextUtilities.isNullText(tel3)) {
                return "-" + tel2 + "-";
            }
            return "-" + tel2 + "-" + tel3;
        }
        if (ACTextUtilities.isNullText(tel2)) {
            if (ACTextUtilities.isNullText(tel3)) {
                return tel1 + "--";
            }
            return tel1 + "--" + tel3;
        }
        if (ACTextUtilities.isNullText(tel3)) {
            return tel1 + "-" + tel2 + "-";
        }
        return tel1 + "-" + tel2 + "-" + tel3;
    }

    /**
     * �X�֔ԍ���"-"�ŘA�����ĕԂ��܂��B
     * <p>
     * ���������ׂ�null�������͋󕶎��̏ꍇ�͋󕶎���Ԃ��܂��B
     * </p>
     * 
     * @param zip1 �z�B�ǔԍ�
     * @param zip2 ����ԍ�
     * @return �A������
     */
    public static String toZip(Object zip1, Object zip2) {
        if (ACTextUtilities.isNullText(zip1)) {
            if (ACTextUtilities.isNullText(zip2)) {
                return "";
            }
            return "-" + zip2;
        }
        if (ACTextUtilities.isNullText(zip2)) {
            return zip1 + "-";
        }
        return zip1 + "-" + zip2;
    }

    /**
     * �����ڍ׏��X�V�֐��ł��B
     * <p>
     * ���[�o�͗p�ɁA�����e�[�u���̏ڍ׏���o�^�E�X�V���܂��B
     * </p>
     * <p>
     * �g�����U�N�V�����̊J�n�E�R�~�b�g�E���[���o�b�N�͌Ăяo�����Ƃōs�Ȃ��Ă��������B
     * </p>
     * <p>
     * �����L�[�͑Ώ۔N��(TARGET_DATE)�ł��B
     * </p>
     * <p>
     * ����details <br />
     * <code>List{ <br />
     * Map(�����e���E�ڍ׏��) <br />
     * key:�t�B�[���h���E�ڍ׎�� <br />
     * val:�l <br />
     * }</code><br />
     * �����CLAIM_ID����Ȃ郌�R�[�h�͘A�����Ĕz�u���Ă��������B�܂��A
     * �S�Ẵ��R�[�h�������͘A������CLAIM_ID�̍ŏ��̃��R�[�h�ɂ͏ڍ׏�񂾂��łȂ��e�����i�[���Ă��������B
     * </p>
     * 
     * @param dbm DBManager
     * @param details �o�^�f�[�^
     * @param targetDate �Ώ۔N��
     * @param patientID ���p��ID
     * @return �X�V���R�[�h��
     * @throws Exception ������O
     */
    public static int updateClaimDetail(ACDBManager dbm, VRList details,
            Date targetDate, int patientID) throws Exception {
        return updateClaimDetail(dbm, details, targetDate, patientID, null);
    }

    /**
     * �����ڍ׏��X�V�֐��ł��B
     * <p>
     * ���[�o�͗p�ɁA�����e�[�u���̏ڍ׏���o�^�E�X�V���܂��B
     * </p>
     * <p>
     * �g�����U�N�V�����̊J�n�E�R�~�b�g�E���[���o�b�N�͌Ăяo�����Ƃōs�Ȃ��Ă��������B
     * </p>
     * <p>
     * �����L�[�͑Ώ۔N��(TARGET_DATE)�ł��B
     * </p>
     * <p>
     * ����details <br />
     * <code>List{ <br />
     * Map(�����e���E�ڍ׏��) <br />
     * key:�t�B�[���h���E�ڍ׎�� <br />
     * val:�l <br />
     * }</code><br />
     * �����CLAIM_ID����Ȃ郌�R�[�h�͘A�����Ĕz�u���Ă��������B�܂��A
     * �S�Ẵ��R�[�h�������͘A������CLAIM_ID�̍ŏ��̃��R�[�h�ɂ͏ڍ׏�񂾂��łȂ��e�����i�[���Ă��������B
     * </p>
     * 
     * @param dbm DBManager
     * @param details �o�^�f�[�^
     * @param targetDate �Ώ۔N��
     * @param patientID ���p��ID
     * @param providerId ���Ə�ID
     * @return �X�V���R�[�h��
     * @throws Exception ������O
     */
    public static int updateClaimDetail(ACDBManager dbm, VRList details,
            Date targetDate, int patientID, String providerId) throws Exception {
        Calendar cal = Calendar.getInstance();
        cal.setTime(targetDate);
        String ym = VRDateParser.format(cal, "yyyy/MM");
        // �e������̂��߂�SQL��

        StringBuilder sb;
        sb = new StringBuilder();
        sb.append(" (CLAIM.TARGET_DATE >= '" + ym + "/01')");
        sb.append(" AND(CLAIM.TARGET_DATE <= '" + ym + "/"
                + cal.getActualMaximum(Calendar.DAY_OF_MONTH) + "')");
        sb.append(" AND(CLAIM.PATIENT_ID = " + patientID + ")");
        if (!ACTextUtilities.isNullText(providerId)) {
            sb.append(" AND(CLAIM.PROVIDER_ID = '" + providerId + "')");
        }
        return updateClaimDetailCustom(dbm, details, targetDate, sb.toString());
    }

    /**
     * �����ڍ׏��X�V�֐��ł��B
     * <p>
     * ���[�o�͗p�ɁA�����e�[�u���̏ڍ׏���o�^�E�X�V���܂��B
     * </p>
     * <p>
     * �g�����U�N�V�����̊J�n�E�R�~�b�g�E���[���o�b�N�͌Ăяo�����Ƃōs�Ȃ��Ă��������B
     * </p>
     * <p>
     * ����details <br />
     * <code>List{ <br />
     * Map(�����e���E�ڍ׏��) <br />
     * key:�t�B�[���h���E�ڍ׎�� <br />
     * val:�l <br />
     * }</code><br />
     * �����CLAIM_ID����Ȃ郌�R�[�h�͘A�����Ĕz�u���Ă��������B�܂��A
     * �S�Ẵ��R�[�h�������͘A������CLAIM_ID�̍ŏ��̃��R�[�h�ɂ͏ڍ׏�񂾂��łȂ��e�����i�[���Ă��������B
     * </p>
     * 
     * @param dbm DBManager
     * @param details �o�^�f�[�^
     * @param targetDate �Ώ۔N��
     * @param where �e���ɑ΂���where��
     * @return �X�V���R�[�h��
     * @throws Exception ������O
     */
    public static int updateClaimDetailCustom(ACDBManager dbm, VRList details,
            Date targetDate, String where) throws Exception {

        if (dbm == null) {
            return 0;
        }
        int updateCount = 0;
        // �e�[�u��������̏C������擾
        if (targetDate == null) {
            targetDate = ACDateUtilities.createDate(2006, 4);
        }

        // 2006/06/06 tozo TANAKA begin edit �����e�[�u���̔N�x�ʐ����Ή��̂���
        StringBuilder sb;
        if ((where == null) || ("".equals(where))) {
            where = "";
        } else {
            where = appendFrontWhere(where);
        }

        // 2007/03/19 tozo TANAKA begin move-to �N�x�܂����Ή��̂���
        // �e������̂��߂�SQL��
        sb = new StringBuilder();
        sb.append("SELECT");
        sb.append(" CLAIM.CLAIM_ID");
        sb.append(" FROM");
        sb.append(" CLAIM");
        sb.append(where);
        VRList ids = dbm.executeQuery(sb.toString());

        int end = ids.size();
        if (end > 0) {
            // �����̐eID��IN��Ƃ��ĘA��
            sb = new StringBuilder();
            sb.append(".CLAIM_ID IN (");
            sb.append(((Map) ids.get(0)).get("CLAIM_ID"));
            for (int i = 1; i < end; i++) {
                sb.append(",");
                sb.append(((Map) ids.get(i)).get("CLAIM_ID"));
            }
            sb.append(")");
            String parentIDSQL = sb.toString();
            // 2007/03/19 tozo TANAKA end move-to �N�x�܂����Ή��̂���

            // �e������̂��߂�SQL��
            sb = new StringBuilder();
            sb.append("SELECT");
            sb.append(" DISTINCT");
            sb.append(" CLAIM.CLAIM_DATE");
            sb.append(" FROM");
            sb.append(" CLAIM");
            sb.append(" WHERE");
            sb.append("(TARGET_DATE = '");
            sb.append(VRDateParser.format(targetDate, "yyyy-MM-dd"));
            sb.append("')");
            VRList claimDates = dbm.executeQuery(sb.toString());
            Iterator it = claimDates.iterator();
            while (it.hasNext()) {
                // �Ώ۔N������v��������f�[�^�̐����N����S�������A�ڍ׃f�[�^�̎��e�[�u�������o����
                int modify = getSeparateTableManager().getTableModifyFromDate(
                        dbm,
                        "CLAIM_DETAIL",
                        ACCastUtilities.toDate(VRBindPathParser.get(
                                "CLAIM_DATE", (VRMap) it.next())));
                if (modify < 0) {
                    continue;
                }

                // �쐬�����e�[�u�����́u���̃e�[�u����_�N�x�v�ƂȂ�
                String tableSaffix = "_" + modify;

                // �ꊇ�폜 �J�n ====================================================
                // // �e������̂��߂�SQL��
                // sb = new StringBuilder();
                // sb.append("SELECT");
                // sb.append(" CLAIM.CLAIM_ID");
                // sb.append(" FROM");
                // sb.append(" CLAIM");
                // sb.append(where);
                // VRList ids = dbm.executeQuery(sb.toString());
                //
                // int end = ids.size();
                // if (end > 0) {
                // // �����̐eID��IN��Ƃ��ĘA��
                // sb = new StringBuilder();
                // sb.append(".CLAIM_ID IN (");
                // sb.append(((Map) ids.get(0)).get("CLAIM_ID"));
                // for (int i = 1; i < end; i++) {
                // sb.append(",");
                // sb.append(((Map) ids.get(i)).get("CLAIM_ID"));
                // }
                // sb.append(")");
                // String parentIDSQL = sb.toString();

                // �ڍו�����/���l/���t���
                String[] tableNames = new String[] { "CLAIM_DETAIL_TEXT",
                        "CLAIM_DETAIL_INTEGER", "CLAIM_DETAIL_DATE" };
                for (int i = 0; i < tableNames.length; i++) {
                    String tableName = tableNames[i] + tableSaffix;
                    sb = new StringBuilder();
                    sb.append("DELETE FROM ");
                    sb.append(tableName);
                    sb.append(" WHERE ");
                    sb.append(tableName);
                    sb.append(parentIDSQL);
                    dbm.executeUpdate(sb.toString());
                }

                // // �e���
                // sb = new StringBuilder();
                // sb.append("DELETE FROM");
                // sb.append(" CLAIM");
                // sb.append(" WHERE ");
                // sb.append(" CLAIM");
                // sb.append(parentIDSQL);
                // //add sta 2006.05.25 fujihara.shin
                // //�ďW�v���A���p�Ҍ��������̏��������Ȃ��悤�C��
                // sb.append(" AND CLAIM.CATEGORY_NO <> 16");
                // //add end 2006.05.25 fujihara.shin
                // dbm.executeUpdate(sb.toString());
                // }
            }
            // 2007/03/19 tozo TANAKA begin move-to �N�x�܂����Ή��̂���
            // �e���
            sb = new StringBuilder();
            sb.append("DELETE FROM");
            sb.append(" CLAIM");
            sb.append(" WHERE ");
            sb.append(" CLAIM");
            sb.append(parentIDSQL);
            // add sta 2006.05.25 fujihara.shin
            // �ďW�v���A���p�Ҍ��������̏��������Ȃ��悤�C��
            sb.append(" AND CLAIM.CATEGORY_NO <> 16");
            // add end 2006.05.25 fujihara.shin
            dbm.executeUpdate(sb.toString());
            // 2007/03/19 tozo TANAKA end move-to �N�x�܂����Ή��̂���
        }
        // �ꊇ�폜 �I�� ====================================================
        // 2006/06/06 tozo TANAKA end edit �����e�[�u���̔N�x�ʐ����Ή��̂���

        if (!details.isEmpty()) {

            // �o�^�Ɏg��ID�́A�V���ɐU��Ȃ�����Booking�h�~��ID
            int uniqueID = getDetailParentBookingID(dbm, details, "CLAIM",
                    "CLAIM_ID");
            if (uniqueID < 0) {
                throw new IllegalAccessError("�ԍ��Ǘ��}�X�^����̔ԍ��擾�Ɏ��s");
            }

            Set exclusiveKeys = new HashSet();
            exclusiveKeys.addAll(Arrays.asList(new String[] { "CLAIM_ID",
                    "CLAIM_STYLE_TYPE", "CATEGORY_NO", "PATIENT_ID",
                    "INSURED_ID", "TARGET_DATE", "CLAIM_DATE", "INSURER_ID",
                    "PROVIDER_ID", "CLAIM_FINISH_FLAG", "LAST_TIME", }));

            VRMap detailMaster = getDetailMaster(dbm,
                    QkanConstants.DETAIL_MASTER_CLAIM);

            // 2006/06/06 tozo TANAKA begin add �����e�[�u���̔N�x�ʐ����Ή��̂���
            // �o�^�f�[�^�̐����N�������Ƃɏڍ׏��̎��e�[�u�������߂�
            int modify = getSeparateTableManager().getTableModifyFromDate(
                    dbm,
                    "CLAIM_DETAIL",
                    ACCastUtilities.toDate(VRBindPathParser.get("CLAIM_DATE",
                            (VRMap) details.getData())));
            if (modify < 0) {
                return 0;
            }

            // �쐬�����e�[�u�����́u���̃e�[�u����_�N�x�v�ƂȂ�
            String tableSaffix = "_" + modify;
            // 2006/06/06 tozo TANAKA end add �����e�[�u���̔N�x�ʐ����Ή��̂���

            Iterator it = details.iterator();
            while (it.hasNext()) {
                VRMap row = (VRMap) it.next();
                // ��L�[�̑��݊m�F
                Object idVal = VRBindPathParser.get("CLAIM_ID", row);
                String id;
                if (idVal != null) {
                    id = String.valueOf(idVal);
                } else {
                    Integer newID = new Integer(uniqueID++);
                    VRBindPathParser.set("CLAIM_ID", row, newID);
                    id = String.valueOf(newID);
                }

                // ��{���̓o�^
                sb = new StringBuilder();
                sb.append("INSERT INTO");
                sb.append(" CLAIM");
                sb.append(" (");
                sb.append(" CLAIM_ID");
                sb.append(" ,CLAIM_STYLE_TYPE");
                sb.append(" ,CATEGORY_NO");
                sb.append(" ,PATIENT_ID");
                sb.append(" ,INSURED_ID");
                sb.append(" ,TARGET_DATE");
                sb.append(" ,CLAIM_DATE");
                sb.append(" ,INSURER_ID");
                sb.append(" ,PROVIDER_ID");
                sb.append(" ,CLAIM_FINISH_FLAG");
                sb.append(" ,LAST_TIME");
                sb.append(" )VALUES(");
                sb.append(id);
                sb.append(" ," + VRBindPathParser.get("CLAIM_STYLE_TYPE", row));
                sb.append(" ," + VRBindPathParser.get("CATEGORY_NO", row));
                sb.append(" ," + VRBindPathParser.get("PATIENT_ID", row));
                sb.append(" ,'" + VRBindPathParser.get("INSURED_ID", row) + "'");
                sb.append(" ,'"
                        + VRDateParser.format(
                                (Date) VRBindPathParser.get("TARGET_DATE", row),
                                "yyyy/MM") + "/01'");
                sb.append(" ,'"
                        + VRDateParser.format(
                                (Date) VRBindPathParser.get("CLAIM_DATE", row),
                                "yyyy/MM/dd") + "'");
                sb.append(" ,'" + VRBindPathParser.get("INSURER_ID", row) + "'");
                sb.append(" ,'" + VRBindPathParser.get("PROVIDER_ID", row)
                        + "'");
                sb.append(" ," + VRBindPathParser.get("CLAIM_FINISH_FLAG", row));
                sb.append(" ,CURRENT_TIMESTAMP");
                sb.append(")");
                dbm.executeUpdate(sb.toString());

                // �ڍ׏��̓o�^

                String detailValue;
                Iterator rowIt = row.entrySet().iterator();
                while (rowIt.hasNext()) {
                    java.util.Map.Entry ent = (java.util.Map.Entry) rowIt
                            .next();
                    String key = String.valueOf(ent.getKey());
                    if (exclusiveKeys.contains(key)) {
                        // �e�e�[�u���̃L�[�͏������Ȃ�
                        continue;
                    }
                    Object val = ent.getValue();

                    sb = new StringBuilder();
                    sb.append("INSERT INTO");

                    int mode = Integer.MAX_VALUE;

                    try {
                        if ((key != null) && (!"".equals(key))
                                && (key.replaceAll("[0-9]", "").length() == 0)) {
                            mode = Integer.parseInt(String.valueOf(detailMaster
                                    .getData(new Integer(key))));
                        } else {
                            continue;
                        }

                    } catch (Exception e) {
                        throw new IllegalArgumentException(
                                "���Ή��̃f�[�^�^���w�肷��o�C���h�p�X�u" + key + "�v���w�肳��܂����B");
                    }

                    // �^�ɂ���ĐU�蕪����
                    switch (mode) {
                    case QkanConstants.DETAIL_DATA_INTEGER:
                        sb.append(" CLAIM_DETAIL_INTEGER" + tableSaffix);
                        detailValue = ACConstants.FORMAT_SQL_INTEGER
                                .format(val);
                        break;
                    case QkanConstants.DETAIL_DATA_STRING:
                        sb.append(" CLAIM_DETAIL_TEXT" + tableSaffix);
                        detailValue = ACConstants.FORMAT_SQL_STRING.format(val);
                        break;
                    case QkanConstants.DETAIL_DATA_DATE:
                        sb.append(" CLAIM_DETAIL_DATE" + tableSaffix);
                        detailValue = ACConstants.FORMAT_SQL_FULL_YMD_HMS
                                .format(val);
                        break;
                    default:
                        throw new IllegalArgumentException(
                                "���Ή��̃f�[�^�^���w�肷��o�C���h�p�X�u" + key + "�v���w�肳��܂����B");

                    }
                    sb.append(" (");
                    sb.append(" CLAIM_ID");
                    sb.append(" ,SYSTEM_BIND_PATH");
                    sb.append(" ,DETAIL_VALUE");
                    sb.append(" ,LAST_TIME");
                    sb.append(" )VALUES(");
                    sb.append(id);
                    sb.append(" ," + key);
                    sb.append(" ," + detailValue);
                    sb.append(" ,CURRENT_TIMESTAMP");
                    sb.append(")");
                    updateCount += dbm.executeUpdate(sb.toString());
                }
            }
        }

        return updateCount;
    }

    /**
     * ���Ə��񋟃T�[�r�X�ڍ׏��X�V�֐��ł��B
     * <p>
     * ���Ə���ʕۑ����ɁA���Ə��񋟃T�[�r�X�̏ڍ׏���o�^�E�X�V���܂��B
     * </p>
     * <p>
     * �g�����U�N�V�����̊J�n�E�R�~�b�g�E���[���o�b�N�͌Ăяo�����Ƃōs�Ȃ��Ă��������B
     * </p>
     * <p>
     * ����details <br />
     * <code>List{ <br />
     * Map(���Ə��񋟃T�[�r�X�e���E�ڍ׏��) <br />
     * key:�t�B�[���h���E�ڍ׎�� <br />
     * val:�l <br />
     * }</code><br />
     * �����PROVIDER_SERVICE_ID����Ȃ郌�R�[�h�͘A�����Ĕz�u���Ă��������B�܂��A
     * �S�Ẵ��R�[�h�������͘A������PROVIDER_SERVICE_ID�̍ŏ��̃��R�[�h�ɂ͏ڍ׏�񂾂��łȂ��e�����i�[���Ă��������B
     * </p>
     * 
     * @param dbm DBManager
     * @param details �o�^�f�[�^
     * @param providerID ���Ə�ID
     * @return �X�V���R�[�h��
     * @throws Exception ������O
     */
    public static int updateProviderServiceDetail(ACDBManager dbm,
            VRList details, String providerID) throws Exception {
        StringBuilder sb;
        sb = new StringBuilder();
        sb.append(" (PROVIDER_SERVICE.PROVIDER_ID = '" + providerID + "')");
        return updateProviderServiceDetailCustom(dbm, details, sb.toString());
    }

    /**
     * ���Ə��񋟃T�[�r�X�ڍ׏��X�V�֐��ł��B
     * <p>
     * ���Ə���ʕۑ����ɁA���Ə��񋟃T�[�r�X�̏ڍ׏���o�^�E�X�V���܂��B
     * </p>
     * <p>
     * �g�����U�N�V�����̊J�n�E�R�~�b�g�E���[���o�b�N�͌Ăяo�����Ƃōs�Ȃ��Ă��������B
     * </p>
     * <p>
     * ����details <br />
     * <code>List{ <br />
     * Map(���Ə��񋟃T�[�r�X�e���E�ڍ׏��) <br />
     * key:�t�B�[���h���E�ڍ׎�� <br />
     * val:�l <br />
     * }</code><br />
     * �����PROVIDER_SERVICE_ID����Ȃ郌�R�[�h�͘A�����Ĕz�u���Ă��������B�܂��A
     * �S�Ẵ��R�[�h�������͘A������PROVIDER_SERVICE_ID�̍ŏ��̃��R�[�h�ɂ͏ڍ׏�񂾂��łȂ��e�����i�[���Ă��������B
     * </p>
     * 
     * @param dbm DBManager
     * @param details �o�^�f�[�^
     * @param where �e����where��
     * @return �X�V���R�[�h��
     * @throws Exception ������O
     */
    public static int updateProviderServiceDetailCustom(ACDBManager dbm,
            VRList details, String where) throws Exception {

        if (dbm == null) {
            return 0;
        }
        int updateCount = 0;

        StringBuilder sb;

        // �ꊇ�폜 �J�n ====================================================
        // �e������̂��߂�SQL��
        sb = new StringBuilder();
        sb.append("SELECT");
        sb.append(" PROVIDER_SERVICE.PROVIDER_SERVICE_ID");
        sb.append(" FROM");
        sb.append(" PROVIDER_SERVICE");
        sb.append(" WHERE");
        sb.append(where);
        VRList ids = dbm.executeQuery(sb.toString());

        int end = ids.size();
        if (end > 0) {
            // �����̐eID��IN��Ƃ��ĘA��
            sb = new StringBuilder();
            sb.append(".PROVIDER_SERVICE_ID IN (");
            sb.append(((Map) ids.get(0)).get("PROVIDER_SERVICE_ID"));
            for (int i = 1; i < end; i++) {
                sb.append(",");
                sb.append(((Map) ids.get(i)).get("PROVIDER_SERVICE_ID"));
            }
            sb.append(")");
            String parentIDSQL = sb.toString();

            // �ڍו�����/���l/���t���
            String[] tableNames = new String[] {
                    "PROVIDER_SERVICE_DETAIL_TEXT",
                    "PROVIDER_SERVICE_DETAIL_INTEGER",
                    "PROVIDER_SERVICE_DETAIL_DATE" };
            for (int i = 0; i < tableNames.length; i++) {
                String tableName = tableNames[i];
                sb = new StringBuilder();
                sb.append("DELETE FROM ");
                sb.append(tableName);
                sb.append(" WHERE ");
                sb.append(tableName);
                sb.append(parentIDSQL);
                dbm.executeUpdate(sb.toString());
            }

            // �e���
            sb = new StringBuilder();
            sb.append("DELETE FROM");
            sb.append(" PROVIDER_SERVICE");
            sb.append(" WHERE ");
            sb.append("PROVIDER_SERVICE");
            sb.append(parentIDSQL);
            dbm.executeUpdate(sb.toString());
        }
        // �ꊇ�폜 �I�� ====================================================

        if (!details.isEmpty()) {

            // �o�^�Ɏg��ID�́A�V���ɐU��Ȃ�����Booking�h�~��ID
            int uniqueID = getDetailParentBookingID(dbm, details,
                    "PROVIDER_SERVICE", "PROVIDER_SERVICE_ID");
            if (uniqueID < 0) {
                throw new IllegalAccessException("�ԍ��Ǘ��}�X�^����̔ԍ��擾�Ɏ��s");
            }

            Set exclusiveKeys = new HashSet();
            exclusiveKeys.addAll(Arrays
                    .asList(new String[] { "PROVIDER_SERVICE_ID",
                            "PROVIDER_ID", "SYSTEM_SERVICE_KIND_DETAIL",
                            "REDUCT_RATE", "LAST_TIME", }));
            VRMap detailMaster = getDetailMaster(dbm,
                    QkanConstants.DETAIL_MASTER_PROVIDER);

            Iterator it = details.iterator();
            while (it.hasNext()) {
                VRMap row = (VRMap) it.next();
                // ��L�[�̑��݊m�F
                Object idVal = VRBindPathParser.get("PROVIDER_SERVICE_ID", row);
                String id;
                if (idVal != null) {
                    id = String.valueOf(idVal);
                } else {
                    Integer newID = new Integer(uniqueID++);
                    VRBindPathParser.set("PROVIDER_SERVICE_ID", row, newID);
                    id = String.valueOf(newID);
                }
                // ��{���̓o�^
                sb = new StringBuilder();
                sb.append("INSERT INTO");
                sb.append(" PROVIDER_SERVICE");
                sb.append(" (");
                sb.append(" PROVIDER_SERVICE_ID");
                sb.append(" ,PROVIDER_ID");
                sb.append(" ,SYSTEM_SERVICE_KIND_DETAIL");
                sb.append(" ,REDUCT_RATE");
                sb.append(" ,LAST_TIME");
                sb.append(" )VALUES(");
                sb.append(id);
                sb.append(" ,'" + VRBindPathParser.get("PROVIDER_ID", row)
                        + "'");
                sb.append(" ,"
                        + VRBindPathParser.get("SYSTEM_SERVICE_KIND_DETAIL",
                                row));
                sb.append(" ," + VRBindPathParser.get("REDUCT_RATE", row));
                sb.append(" ,CURRENT_TIMESTAMP");
                sb.append(")");
                dbm.executeUpdate(sb.toString());

                // �ڍ׏��̓o�^

                Iterator rowIt = row.entrySet().iterator();
                while (rowIt.hasNext()) {
                    java.util.Map.Entry ent = (java.util.Map.Entry) rowIt
                            .next();
                    String key = String.valueOf(ent.getKey());
                    if (exclusiveKeys.contains(key)) {
                        // �e�e�[�u���̃L�[�͏������Ȃ�
                        continue;
                    }
                    Object val = ent.getValue();

                    String detailValue;

                    sb = new StringBuilder();
                    sb.append("INSERT INTO");
                    // �^�ɂ���ĐU�蕪����
                    int type = -1;
                    Object obj = detailMaster.getData(Integer.valueOf(key));
                    if (obj != null) {
                        type = Integer.parseInt(String.valueOf(obj));
                    }
                    switch (type) {
                    case QkanConstants.DETAIL_DATA_INTEGER:
                        sb.append(" PROVIDER_SERVICE_DETAIL_INTEGER");
                        detailValue = ACConstants.FORMAT_SQL_INTEGER
                                .format(val);
                        break;
                    case QkanConstants.DETAIL_DATA_STRING:
                        sb.append(" PROVIDER_SERVICE_DETAIL_TEXT");
                        detailValue = ACConstants.FORMAT_SQL_STRING.format(val);
                        break;
                    case QkanConstants.DETAIL_DATA_DATE:
                        sb.append(" PROVIDER_SERVICE_DETAIL_DATE");
                        detailValue = ACConstants.FORMAT_SQL_FULL_YMD_HMS
                                .format(val);
                        break;
                    default:
                        VRLogger.info("���Ή��̃f�[�^�^���w�肷��o�C���h�p�X�u" + key
                                + "�v���w�肳��܂����B");
                        continue;
                        // throw new IllegalArgumentException(
                        // "���Ή��̃f�[�^�^���w�肷��o�C���h�p�X�u"
                        // + VRBindPathParser.get(
                        // "SYSTEM_BIND_PATH", row)
                        // + "�v���w�肳��܂����B");

                    }
                    sb.append(" (");
                    sb.append(" PROVIDER_SERVICE_ID");
                    sb.append(" ,SYSTEM_BIND_PATH");
                    sb.append(" ,DETAIL_VALUE");
                    sb.append(" ,LAST_TIME");
                    sb.append(" )VALUES(");
                    sb.append(id);
                    sb.append(" ," + key);
                    sb.append(" ," + detailValue);
                    sb.append(" ,CURRENT_TIMESTAMP");
                    sb.append(")");
                    updateCount += dbm.executeUpdate(sb.toString());

                }
            }
        }

        return updateCount;
    }

    /**
     * �T�[�r�X�ڍ׏��X�V�֐��ł��B
     * <p>
     * �T�[�r�X�\��E���щ�ʕۑ����ɁA�T�[�r�X�̏ڍ׏���o�^�E�X�V���܂��B
     * </p>
     * <p>
     * �g�����U�N�V�����̊J�n�E�R�~�b�g�E���[���o�b�N�͌Ăяo�����Ƃōs�Ȃ��Ă��������B
     * </p>
     * <p>
     * �p�b�V�u�`�F�b�N�e�[�u��(SERVICE_PASSIVE_CHECK)�̍X�V�͌Ăяo�����Ƃōs�Ȃ��Ă��������B
     * </p>
     * <p>
     * ����details <br />
     * <code>List{ <br />
     * Map(�T�[�r�X�e���E�ڍ׏��) <br />
     * key:�t�B�[���h���E�ڍ׎�� <br />
     * val:�l <br />
     * }</code><br />
     * �����SERVICE_ID����Ȃ郌�R�[�h�͘A�����Ĕz�u���Ă��������B�܂��A
     * �S�Ẵ��R�[�h�������͘A������SERVICE_ID�̍ŏ��̃��R�[�h�ɂ͏ڍ׏�񂾂��łȂ��e�����i�[���Ă��������B
     * </p>
     * <p>
     * �����u�擾�敪�v�ɂ͈ȉ��̒l���w�肵�܂��B <br />
     * 101-�\��(SERVICE_DETAIL_GET_PLAN) <br />
     * 102-����(SERVICE_DETAIL_GET_RESULT)
     * </p>
     * 
     * @param dbm DBManager
     * @param details �o�^�f�[�^
     * @param patientID ���p��ID
     * @param targetDate �Ώ۔N��
     * @param useType �擾�敪
     * @return �X�V���R�[�h��
     * @throws Exception ������O
     */
    public static int updateServiceDetail(ACDBManager dbm, VRList details,
            int patientID, Date targetDate, int useType) throws Exception {

        // �ꊇ�폜����
        StringBuilder sb;
        Calendar cal = Calendar.getInstance();
        cal.setTime(targetDate);
        String ym = VRDateParser.format(cal, "yyyy/MM");

        // �e��񌟍�����
        sb = new StringBuilder();
        sb.append(" (SERVICE.SERVICE_DATE >= '" + ym + "/01')");
        sb.append(" AND(SERVICE.SERVICE_DATE <= '" + ym + "/"
                + cal.getActualMaximum(Calendar.DAY_OF_MONTH) + "')");
        sb.append(" AND(SERVICE.PATIENT_ID = " + patientID + ")");
        sb.append(" AND");
        sb.append(getServiceUseTypeSQLWithoutAnd(useType));

        return updateServiceDetailCustom(dbm, details, targetDate,
                sb.toString());
    }

    /**
     * �T�[�r�X�ڍ׏��X�V�֐��ł��B
     * <p>
     * �T�[�r�X�\��E���щ�ʕۑ����ɁA�T�[�r�X�̏ڍ׏���o�^�E�X�V���܂��B
     * </p>
     * <p>
     * �g�����U�N�V�����̊J�n�E�R�~�b�g�E���[���o�b�N�͌Ăяo�����Ƃōs�Ȃ��Ă��������B
     * </p>
     * <p>
     * �p�b�V�u�`�F�b�N�e�[�u��(SERVICE_PASSIVE_CHECK)�̍X�V�͌Ăяo�����Ƃōs�Ȃ��Ă��������B
     * </p>
     * <p>
     * ����details <br />
     * <code>List{ <br />
     * Map(�T�[�r�X�e���E�ڍ׏��) <br />
     * key:�t�B�[���h���E�ڍ׎�� <br />
     * val:�l <br />
     * }</code><br />
     * �����SERVICE_ID����Ȃ郌�R�[�h�͘A�����Ĕz�u���Ă��������B�܂��A
     * �S�Ẵ��R�[�h�������͘A������SERVICE_ID�̍ŏ��̃��R�[�h�ɂ͏ڍ׏�񂾂��łȂ��e�����i�[���Ă��������B
     * </p>
     * 
     * @param dbm DBManager
     * @param details �o�^�f�[�^
     * @param targetDate �Ώ۔N��
     * @param where �e����where��
     * @return �X�V���R�[�h��
     * @throws Exception ������O
     */
    public static int updateServiceDetailCustom(ACDBManager dbm,
            VRList details, Date targetDate, String where) throws Exception {
        if (dbm == null) {
            return 0;
        }
        int updateCount = 0;
        // �e�[�u��������̏C������擾
        if (targetDate == null) {
            targetDate = ACDateUtilities.createDate(2006, 4);
        }
        int modify = getSeparateTableManager().getTableModifyFromDate(dbm,
                "SERVICE_DETAIL", targetDate);
        if (modify < 0) {
            return 0;
        }
        String tableSaffix = "_" + modify;

        StringBuilder sb;

        // �ꊇ�폜 �J�n ====================================================
        if ((where == null) || ("".equals(where))) {
            where = "";
        } else {
            where = " WHERE " + where;
        }
        // �e��񌟍�SQL��
        sb = new StringBuilder();
        sb.append("SELECT");
        sb.append(" SERVICE.SERVICE_ID");
        sb.append(" FROM");
        sb.append(" SERVICE");
        sb.append(where);
        VRList ids = dbm.executeQuery(sb.toString());

        int end = ids.size();
        if (end > 0) {
            // �����̐eID��IN��Ƃ��ĘA��
            sb = new StringBuilder();
            sb.append(".SERVICE_ID IN (");
            sb.append(((Map) ids.get(0)).get("SERVICE_ID"));
            for (int i = 1; i < end; i++) {
                sb.append(",");
                sb.append(((Map) ids.get(i)).get("SERVICE_ID"));
            }
            sb.append(")");
            String parentIDSQL = sb.toString();

            // �ڍו�����/���l/���t���
            String[] tableNames = new String[] { "SERVICE_DETAIL_TEXT",
                    "SERVICE_DETAIL_INTEGER", "SERVICE_DETAIL_DATE", };
            for (int i = 0; i < tableNames.length; i++) {
                String tableName = tableNames[i] + tableSaffix;
                sb = new StringBuilder();
                sb.append("DELETE FROM ");
                sb.append(tableName);
                sb.append(" WHERE ");
                sb.append(tableName);
                sb.append(parentIDSQL);
                dbm.executeUpdate(sb.toString());
            }

            // �e��� �폜
            sb = new StringBuilder();
            sb.append("DELETE FROM");
            sb.append(" SERVICE");
            sb.append(" WHERE ");
            sb.append("SERVICE");
            sb.append(parentIDSQL);
            dbm.executeUpdate(sb.toString());
        }

        // �ꊇ�폜 �I�� ====================================================

        if (!details.isEmpty()) {
            // �o�^�Ɏg��ID�́A�V���ɐU��Ȃ�����Booking�h�~��ID
            int uniqueID = getDetailParentBookingID(dbm, details, "SERVICE",
                    "SERVICE_ID");
            if (uniqueID < 0) {
                throw new IllegalAccessError("�ԍ��Ǘ��}�X�^����̔ԍ��擾�Ɏ��s");
            }

            Set exclusiveKeys = new HashSet();
            exclusiveKeys.addAll(Arrays.asList(new String[] { "SERVICE_ID",
                    // "LOGIN_PROVIDER_ID",
                    "SERVICE_USE_TYPE", "PATIENT_ID", "PROVIDER_ID",
                    "SYSTEM_SERVICE_KIND_DETAIL", "SERVICE_DATE", "WEEK_DAY",
                    // "EXPENSES_FLAG",
                    "REGULATION_RATE", "LAST_TIME", }));

            VRMap detailMaster = getDetailMaster(dbm,
                    QkanConstants.DETAIL_MASTER_SERVICE);

            Iterator it = details.iterator();
            while (it.hasNext()) {
                VRMap row = (VRMap) it.next();
                // ��L�[�̑��݊m�F
                Object idVal = row.get("SERVICE_ID");
                String id;
                if (idVal != null) {
                    id = String.valueOf(idVal);
                } else {
                    Integer newID = new Integer(uniqueID++);
                    try {
                        row.put("SERVICE_ID", newID);
                    } catch (java.util.ConcurrentModificationException ex) {
                        // �C�e���[�V�����̓�����O�͖���
                    }
                    id = String.valueOf(newID);
                }
                // ��{���̓o�^
                sb = new StringBuilder();
                sb.append("INSERT INTO");
                sb.append(" SERVICE");
                sb.append(" (");
                sb.append(" SERVICE_ID");
                // sb.append(" ,LOGIN_PROVIDER_ID");
                sb.append(" ,SERVICE_USE_TYPE");
                sb.append(" ,PATIENT_ID");
                sb.append(" ,PROVIDER_ID");
                sb.append(" ,SYSTEM_SERVICE_KIND_DETAIL");
                sb.append(" ,SERVICE_DATE");
                sb.append(" ,WEEK_DAY");
                // sb.append(" ,EXPENSES_FLAG");
                sb.append(" ,REGULATION_RATE");
                sb.append(" ,LAST_TIME");
                sb.append(" )VALUES(");
                sb.append(id);
                // sb.append(" ,'"
                // + VRBindPathParser.get("LOGIN_PROVIDER_ID", row) + "'");
                sb.append(" ," + row.get("SERVICE_USE_TYPE"));
                sb.append(" ," + row.get("PATIENT_ID"));
                sb.append(" ,'" + row.get("PROVIDER_ID") + "'");
                sb.append(" ," + row.get("SYSTEM_SERVICE_KIND_DETAIL"));
                Object serviceData = row.get("SERVICE_DATE");
                if (serviceData instanceof Date) {
                    sb.append(" ,'"
                            + VRDateParser.format((Date) serviceData,
                                    "yyyy/MM/dd") + "'");
                } else {
                    sb.append(" ,NULL");
                }
                sb.append(" ,"
                        + ACSQLSafeNullToZeroIntegerFormat.getInstance()
                                .format(row.get("WEEK_DAY")));
                // sb.append(" ,"
                // + ACSQLSafeNullToZeroIntegerFormat.getInstance()
                // .format(
                // VRBindPathParser.get("EXPENSES_FLAG",
                // row)));
                sb.append(" ,"
                        + ACSQLSafeNullToZeroIntegerFormat.getInstance()
                                .format(row.get("REGULATION_RATE")));
                sb.append(" ,CURRENT_TIMESTAMP");
                sb.append(")");
                dbm.executeUpdate(sb.toString());

                // �ڍ׏��̓o�^

                Iterator rowIt = row.entrySet().iterator();
                while (rowIt.hasNext()) {
                    java.util.Map.Entry ent = (java.util.Map.Entry) rowIt
                            .next();
                    String key = String.valueOf(ent.getKey());
                    if (exclusiveKeys.contains(key)) {
                        // �e�e�[�u���̃L�[�͏������Ȃ�
                        continue;
                    }
                    Object val = ent.getValue();

                    String detailValue;
                    sb = new StringBuilder();
                    sb.append("INSERT INTO");
                    // �^�ɂ���ĐU�蕪����
                    int type = -1;
                    Object obj = detailMaster.getData(ACCastUtilities
                            .toInteger(key, null));
                    if (obj != null) {
                        type = ACCastUtilities.toInt(obj, 0);
                    }
                    switch (type) {
                    case QkanConstants.DETAIL_DATA_INTEGER:
                        sb.append(" SERVICE_DETAIL_INTEGER" + tableSaffix);
                        detailValue = ACSQLSafeIntegerFormat.getInstance()
                                .format(val);
                        break;
                    case QkanConstants.DETAIL_DATA_STRING:
                        sb.append(" SERVICE_DETAIL_TEXT" + tableSaffix);
                        detailValue = ACConstants.FORMAT_SQL_STRING.format(val);
                        break;
                    case QkanConstants.DETAIL_DATA_DATE:
                        sb.append(" SERVICE_DETAIL_DATE" + tableSaffix);
                        detailValue = ACConstants.FORMAT_SQL_FULL_YMD_HMS
                                .format(val);
                        break;
                    default:
                        VRLogger.info("���Ή��̃f�[�^�^���w�肷��o�C���h�p�X�u" + key
                                + "�v���w�肳��܂����B");
                        continue;
                        // throw new IllegalArgumentException(
                        // "���Ή��̃f�[�^�^���w�肷��o�C���h�p�X�u"
                        // + key
                        // + "�v���w�肳��܂����B");

                    }
                    sb.append(" (");
                    sb.append(" SERVICE_ID");
                    sb.append(" ,SYSTEM_BIND_PATH");
                    sb.append(" ,DETAIL_VALUE");
                    sb.append(" ,LAST_TIME");
                    sb.append(" )VALUES(");
                    sb.append(id);
                    sb.append(" ," + key);
                    sb.append(" ," + detailValue);
                    sb.append(" ,CURRENT_TIMESTAMP");
                    sb.append(")");
                    updateCount += dbm.executeUpdate(sb.toString());

                }

            }
        }

        return updateCount;
    }

    /**
     * �T�[�r�X�p�^�[���ڍ׏��X�V�֐��ł��B
     * <p>
     * �T�[�r�X�p�^�[���ۑ����ɁA�T�[�r�X�p�^�[���̏ڍ׏���o�^�E�X�V���܂��B
     * </p>
     * <p>
     * �g�����U�N�V�����̊J�n�E�R�~�b�g�E���[���o�b�N�͌Ăяo�����Ƃōs�Ȃ��Ă��������B
     * </p>
     * <p>
     * �p�b�V�u�`�F�b�N�e�[�u��(SERVICE_PASSIVE_CHECK)�̍X�V�͌Ăяo�����Ƃōs�Ȃ��Ă��������B
     * </p>
     * <p>
     * ����details <br />
     * <code>List{ <br />
     * Map(�T�[�r�X�p�^�[���e���E�ڍ׏��) <br />
     * key:�t�B�[���h���E�ڍ׎�� <br />
     * val:�l <br />
     * }</code><br />
     * �����SERVICE_ID����Ȃ郌�R�[�h�͘A�����Ĕz�u���Ă��������B�܂��A
     * �S�Ẵ��R�[�h�������͘A������SERVICE_ID�̍ŏ��̃��R�[�h�ɂ͏ڍ׏�񂾂��łȂ��e�����i�[���Ă��������B
     * </p>
     * 
     * @param dbm DBManager
     * @param serviceKind �Ǝ��T�[�r�X��ރR�[�h
     * @param details �o�^�f�[�^
     * @return �X�V���R�[�h��
     * @throws Exception ������O
     */
    public static int updateServicePatternDetail(ACDBManager dbm,
            int serviceKind, VRList details) throws Exception {
        return updateServicePatternDetailCustom(dbm, details,
                " (SERVICE.SYSTEM_SERVICE_KIND_DETAIL = " + serviceKind + ")");
    }

    /**
     * �T�[�r�X�p�^�[���ڍ׏��X�V�֐��ł��B
     * <p>
     * �T�[�r�X�p�^�[���ۑ����ɁA�T�[�r�X�p�^�[���̏ڍ׏���o�^�E�X�V���܂��B
     * </p>
     * <p>
     * �g�����U�N�V�����̊J�n�E�R�~�b�g�E���[���o�b�N�͌Ăяo�����Ƃōs�Ȃ��Ă��������B
     * </p>
     * <p>
     * �p�b�V�u�`�F�b�N�e�[�u��(SERVICE_PASSIVE_CHECK)�̍X�V�͌Ăяo�����Ƃōs�Ȃ��Ă��������B
     * </p>
     * <p>
     * ����details <br />
     * <code>List{ <br />
     * Map(�T�[�r�X�p�^�[���e���E�ڍ׏��) <br />
     * key:�t�B�[���h���E�ڍ׎�� <br />
     * val:�l <br />
     * }</code><br />
     * �����SERVICE_ID����Ȃ郌�R�[�h�͘A�����Ĕz�u���Ă��������B�܂��A
     * �S�Ẵ��R�[�h�������͘A������SERVICE_ID�̍ŏ��̃��R�[�h�ɂ͏ڍ׏�񂾂��łȂ��e�����i�[���Ă��������B
     * </p>
     * 
     * @param dbm DBManager
     * @param details �o�^�f�[�^
     * @return �X�V���R�[�h��
     * @throws Exception ������O
     */
    public static int updateServicePatternDetail(ACDBManager dbm, VRList details)
            throws Exception {
        return updateServicePatternDetailCustom(dbm, details, null);
    }

    /**
     * �T�[�r�X�p�^�[���ڍ׏��X�V�֐��ł��B
     * <p>
     * �T�[�r�X�p�^�[���ۑ����ɁA�T�[�r�X�p�^�[���̏ڍ׏���o�^�E�X�V���܂��B
     * </p>
     * <p>
     * �g�����U�N�V�����̊J�n�E�R�~�b�g�E���[���o�b�N�͌Ăяo�����Ƃōs�Ȃ��Ă��������B
     * </p>
     * <p>
     * �p�b�V�u�`�F�b�N�e�[�u��(SERVICE_PASSIVE_CHECK)�̍X�V�͌Ăяo�����Ƃōs�Ȃ��Ă��������B
     * </p>
     * <p>
     * ����details <br />
     * <code>List{ <br />
     * Map(�T�[�r�X�p�^�[���e���E�ڍ׏��) <br />
     * key:�t�B�[���h���E�ڍ׎�� <br />
     * val:�l <br />
     * }</code><br />
     * �����SERVICE_ID����Ȃ郌�R�[�h�͘A�����Ĕz�u���Ă��������B�܂��A
     * �S�Ẵ��R�[�h�������͘A������SERVICE_ID�̍ŏ��̃��R�[�h�ɂ͏ڍ׏�񂾂��łȂ��e�����i�[���Ă��������B
     * </p>
     * 
     * @param dbm DBManager
     * @param details �o�^�f�[�^
     * @param where �e����where��
     * @return �X�V���R�[�h��
     * @throws Exception ������O
     */
    public static int updateServicePatternDetailCustom(ACDBManager dbm,
            VRList details, String where) throws Exception {
        StringBuilder sb;
        sb = new StringBuilder();
        if (!ACTextUtilities.isNullText(where)) {
            sb.append(where);
            sb.append(" AND");
        }
        sb.append(" (SERVICE.SERVICE_USE_TYPE = "
                + QkanConstants.SERVICE_USE_TYPE_PATTERN + ")");
        return updateServiceDetailCustom(dbm, details, null, sb.toString());
    }

    /**
     * ������WHERE���̐擪��AND���t�����ĕԂ��܂��B
     * 
     * @param where �ϊ���
     * @return �ϊ�����
     */
    protected static String appendFrontAnd(String where) {
        if (where.startsWith(" AND") || where.startsWith("AND")
                || where.startsWith(" OR") || where.startsWith("OR")) {
            return where;
        }
        return " AND" + where;
    }

    /**
     * �����̏������̐擪��WHERE���t�����ĕԂ��܂��B
     * 
     * @param where �ϊ���
     * @return �ϊ�����
     */
    protected static String appendFrontWhere(String where) {
        if (ACTextUtilities.isNullText(where)) {
            return where;
        }
        if (where.startsWith(" AND")) {
            where = where.substring(4);
        } else if (where.startsWith(" OR")) {
            where = where.substring(3);
        } else if (where.startsWith("AND")) {
            where = where.substring(3);
        } else if (where.startsWith("OR")) {
            where = where.substring(2);
        } else if ((where.startsWith(" WHERE")) || (where.startsWith("WHERE"))) {
            return where;
        }
        return " WHERE " + where;
    }

    /**
     * ����N���ɂ��Ԃ�v���F�藚���𒊏o����WHERE������Ԃ��܂��B
     * <p>
     * "WHERE"��A������ۂ�"AND"�͊܂݂܂���B
     * </p>
     * 
     * @param targetDate �Ώ۔N��
     * @return SQL������
     * @throws Exception ������O
     */
    protected static String createWhereStatementOfNinteiHistory(Date targetDate)
            throws Exception {

        Calendar cal = Calendar.getInstance();
        cal.setTime(targetDate);
        String ym = VRDateParser.format(cal, "yyyy/MM");

        StringBuilder sb = new StringBuilder();

        // -- �L�����Ԃ��`�F�b�N����SQL�� �J�n----------------------------------------
        // �L�����ԓ��������͂��Ԃ��Ă���p�^�[���͕�������A���̂����ꂩ��ɊY������΋��e����
        sb.append(" (");

        String targetDateBegin = ym + "/01";
        String targetDateEnd = ym + "/"
                + cal.getActualMaximum(Calendar.DAY_OF_MONTH);

        sb.append(" (");
        // 1.�L�����ԊJ�n�����Ώ۔N���ȑO�̏ꍇ
// 2014/12/17 [Yoichiro Kamei] mod - begin �V�X�e���L�����ԑΉ�
//        sb.append(" (PATIENT_NINTEI_HISTORY.INSURE_VALID_START <= '"
//                + targetDateEnd + "')");
        sb.append(" (PATIENT_NINTEI_HISTORY.SYSTEM_INSURE_VALID_START <= '"
                + targetDateEnd + "')");
// 2014/12/17 [Yoichiro Kamei] mod - end
        // 1-1.���L�����ԏI�����͑Ώ۔N���̏����Ɠ����������Ă���Ȃ�Ί��Ԃ����Ԃ�̂�OK
// 2014/12/17 [Yoichiro Kamei] mod - begin �V�X�e���L�����ԑΉ�
//        sb.append(" AND(PATIENT_NINTEI_HISTORY.INSURE_VALID_END >= '"
//                + targetDateBegin + "')");
        sb.append(" AND(PATIENT_NINTEI_HISTORY.SYSTEM_INSURE_VALID_END >= '"
                + targetDateBegin + "')");
// 2014/12/17 [Yoichiro Kamei] mod - end
        sb.append(" )OR(");

        // 2.�L�����ԊJ�n�����Ώ۔N�����Ȃ�Ί��Ԃ����Ԃ�̂�OK
// 2014/12/17 [Yoichiro Kamei] mod - begin �V�X�e���L�����ԑΉ�
//        sb.append(" (PATIENT_NINTEI_HISTORY.INSURE_VALID_START <= '"
//                + targetDateBegin + "')");
//      sb.append(" AND(PATIENT_NINTEI_HISTORY.INSURE_VALID_START >= '"
//      + targetDateEnd + "')");
        sb.append(" (PATIENT_NINTEI_HISTORY.SYSTEM_INSURE_VALID_START <= '"
                + targetDateBegin + "')");
        sb.append(" AND(PATIENT_NINTEI_HISTORY.SYSTEM_INSURE_VALID_START >= '"
                + targetDateEnd + "')");
// 2014/12/17 [Yoichiro Kamei] mod - end
        sb.append(" )");

        sb.append(" )");
        // -- �L�����Ԃ��`�F�b�N����SQL�� �I��----------------------------------------

        return sb.toString();
    }

    /**
     * �ڍ׃}�X�^�n�b�V����Ԃ��܂��B
     * <p>
     * �o�C���h�p�X���L�[�Ƀf�[�^�^�C�v���Q�Ƃ���n�b�V����Ԃ��܂��B
     * </p>
     * 
     * @param dbm DBManager
     * @param type �ڍ׃}�X�^�^�C�v
     * @return �ڍ׃}�X�^�n�b�V��
     * @throws Exception ������O
     * @see QkanConstants.DETAIL_MASTER_SERVICE
     * @see QkanConstants.DETAIL_MASTER_PROVIDER
     * @see QkanConstants.DETAIL_MASTER_STAFF
     * @see QkanConstants.DETAIL_MASTER_CLAIM
     */
    protected static VRMap getDetailMaster(ACDBManager dbm, int type)
            throws Exception {
        StringBuilder sb;

        sb = new StringBuilder();
        sb.append("SELECT");
        sb.append(" M_DETAIL.SYSTEM_BIND_PATH,");
        sb.append(" M_DETAIL.DATA_TYPE");
        sb.append(" FROM");
        sb.append(" M_DETAIL");
        sb.append(" WHERE");
        sb.append(" (M_DETAIL.DETAIL_PROPERTY = " + type + ")");

        VRList detailMasterArray = dbm.executeQuery(sb.toString());
        VRMap detailMaster = new VRHashMap();
        Iterator it = detailMasterArray.iterator();
        while (it.hasNext()) {
            VRMap row = (VRMap) it.next();
            detailMaster.setData(VRBindPathParser.get("SYSTEM_BIND_PATH", row),
                    VRBindPathParser.get("DATA_TYPE", row));
        }
        return detailMaster;
    }

    /**
     * �ڍׂ̐e���R�[�h�����v�Z���A�Փ˂��Ȃ�Booking�h�~�ϊJ�n�ԍ���Ԃ��܂��B
     * 
     * @param dbm DBManager
     * @param details �ڍ׃��R�[�h�W��
     * @param tableName �e�[�u����
     * @param fieldName �L�[�t�B�[���h��
     * @return Booking�h�~�ϊJ�n�ԍ�
     * @throws Exception
     */
    protected static int getDetailParentBookingID(ACDBManager dbm,
            VRList details, String tableName, String fieldName)
            throws Exception {
        // �e���R�[�h�����v��
        // ����̔�r�ŕK����v����悤�A���݂��Ȃ�ID�ŏ�����
        // String nowID = "";
        int detailParentCount = 0;
        Iterator it = details.iterator();
        while (it.hasNext()) {
            VRMap row = (VRMap) it.next();
            if (!VRBindPathParser.has(fieldName, row)) {
                detailParentCount++;
            }
        }

        // �o�^�Ɏg��ID�́A�V���ɐU��Ȃ�����Booking�h�~�ϊJ�n�ԍ���Ԃ��܂��B
        return QkanCommon.getBookingNumber(dbm, tableName, fieldName,
                detailParentCount);
    }


    /**
     * ���Ə����擾�֐��ł��B
     * <p>
     * ���Ə����ҏW���A�I�����Ə������擾���܂��B
     * </p>
     * <p>
     * �Ԃ�l <br />
     * <code>List{ <br />
     * Map(���Ə����) <br />
     * key:�t�B�[���h�� <br />
     * val:�l <br />
     * }</code><br />
     * ASC ���Ə��ԍ�
     * </p>
     * 
     * @param dbm DBManager
     * @param where �i���݋�
     * @return ���Ə����(���Ə��ԍ���)
     * @throws Exception ������O
     */
    protected static VRList getProviderInfoImpl(ACDBManager dbm, String where)
            throws Exception {
        StringBuilder sb;

        sb = new StringBuilder();
        sb.append("SELECT");
        sb.append(" DISTINCT PROVIDER.PROVIDER_ID,");
        sb.append(" PROVIDER.PROVIDER_TYPE,");
        sb.append(" PROVIDER.MEDICAL_FLAG,");
        sb.append(" PROVIDER.PROVIDER_TYPE,");
        sb.append(" PROVIDER.PROVIDER_NAME,");
        sb.append(" PROVIDER.PROVIDER_ZIP_FIRST,");
        sb.append(" PROVIDER.PROVIDER_ZIP_SECOND,");
        sb.append(" PROVIDER.PROVIDER_ADDRESS,");
        sb.append(" PROVIDER.PROVIDER_TEL_FIRST,");
        sb.append(" PROVIDER.PROVIDER_TEL_SECOND,");
        sb.append(" PROVIDER.PROVIDER_TEL_THIRD,");
        sb.append(" PROVIDER.PROVIDER_FAX_FIRST,");
        sb.append(" PROVIDER.PROVIDER_FAX_SECOND,");
        sb.append(" PROVIDER.PROVIDER_FAX_THIRD,");
        sb.append(" PROVIDER.PROVIDER_JIJIGYOUSHO_TYPE,");
        sb.append(" PROVIDER.PROVIDER_JIGYOU_TYPE,");
        sb.append(" PROVIDER.PROVIDER_AREA_TYPE,");
        sb.append(" PROVIDER.SPECIAL_AREA_FLAG,");
        // sb.append(" PROVIDER.SHAFUKU_GENMEN_FLAG,");
        sb.append(" PROVIDER.PROVIDER_OWNER_NAME,");
        sb.append(" PROVIDER.BANK_NAME,");
        sb.append(" PROVIDER.BANK_BRANCH_NAME,");
        sb.append(" PROVIDER.ACCOUNT_NUMBER,");
        sb.append(" PROVIDER.ACCOUNT_TYPE,");
        sb.append(" PROVIDER.ACCOUNT_HOLDER,");
        sb.append(" PROVIDER.LAST_TIME");
        sb.append(" FROM");
        sb.append(" PROVIDER");
        // edit sta shin.fujihara 2005.12.13
        // null�̏ꍇ�͏�����t�����Ȃ��B
        // if (ACTextUtilities.isNullText(where)) {
        if (!ACTextUtilities.isNullText(where)) {
            // edit end shin.fujihara 2005.12.13
            sb.append(where);
        }
        sb.append(" ORDER BY");
        sb.append(" PROVIDER.PROVIDER_ID ASC");

        if (dbm == null) {
            return new VRArrayList();
        }
        return dbm.executeQuery(sb.toString());
    }

    /**
     * �e�[�u�������Ǘ��N���X��Ԃ��܂��B
     * 
     * @return �e�[�u�������Ǘ��N���X
     */
    protected static ACSeparateTableManager getSeparateTableManager() {
        if (separateTableManager == null) {
            separateTableManager = new ACSeparateTableManager();

            separateTableManager.setManageTableName("M_DETAIL_CONTROL");
            separateTableManager.setManagedTableNameFieldName("TABLE_NAME");
            separateTableManager.setMaximumModifierFieldName("MAXIMUM_YEAR");
            separateTableManager.setMinimumModifierFieldName("MINIMUM_YEAR");
            separateTableManager.setTimeStampFieldName("LAST_TIME");
            separateTableManager.setUseManagementTable(true);
            separateTableManager.setUseTimestampField(true);
            separateTableManager.setFiscalYear(true);

            ArrayList tables;
            // �T�[�r�X
            tables = new ArrayList();
            tables.add(new BridgeFirebirdSeparateTable(
                    "SERVICE_DETAIL_INTEGER", "SERVICE_ID INTEGER NOT NULL"
                            + ", SYSTEM_BIND_PATH INTEGER NOT NULL"
                            + ", DETAIL_VALUE INTEGER"
                            + ", LAST_TIME TIMESTAMP"
                            + ", PRIMARY KEY(SERVICE_ID ,SYSTEM_BIND_PATH)"));
            tables.add(new BridgeFirebirdSeparateTable("SERVICE_DETAIL_DATE",
                    "SERVICE_ID INTEGER NOT NULL"
                            + ", SYSTEM_BIND_PATH INTEGER NOT NULL"
                            + ", DETAIL_VALUE TIMESTAMP"
                            + ", LAST_TIME TIMESTAMP"
                            + ", PRIMARY KEY(SERVICE_ID ,SYSTEM_BIND_PATH)"));
            tables.add(new BridgeFirebirdSeparateTable("SERVICE_DETAIL_TEXT",
                    "SERVICE_ID INTEGER NOT NULL"
                            + ", SYSTEM_BIND_PATH INTEGER NOT NULL"
                            + ", DETAIL_VALUE VARCHAR(600)"
                            + ", LAST_TIME TIMESTAMP"
                            + ", PRIMARY KEY(SERVICE_ID ,SYSTEM_BIND_PATH)"));
            separateTableManager.addSeparateTable("SERVICE_DETAIL", tables);

            // ����
            tables = new ArrayList();
            tables.add(new BridgeFirebirdSeparateTable("CLAIM_DETAIL_INTEGER",
                    "CLAIM_ID INTEGER NOT NULL"
                            + ", SYSTEM_BIND_PATH INTEGER NOT NULL"
                            + ", DETAIL_VALUE INTEGER"
                            + ", LAST_TIME TIMESTAMP"
                            + ", PRIMARY KEY(CLAIM_ID ,SYSTEM_BIND_PATH)"));
            tables.add(new BridgeFirebirdSeparateTable("CLAIM_DETAIL_DATE",
                    "CLAIM_ID INTEGER NOT NULL"
                            + ", SYSTEM_BIND_PATH INTEGER NOT NULL"
                            + ", DETAIL_VALUE TIMESTAMP"
                            + ", LAST_TIME TIMESTAMP"
                            + ", PRIMARY KEY(CLAIM_ID ,SYSTEM_BIND_PATH)"));
            tables.add(new BridgeFirebirdSeparateTable("CLAIM_DETAIL_TEXT",
                    "CLAIM_ID INTEGER NOT NULL"
                            + ", SYSTEM_BIND_PATH INTEGER NOT NULL"
                            + ", DETAIL_VALUE VARCHAR(600)"
                            + ", LAST_TIME TIMESTAMP"
                            + ", PRIMARY KEY(CLAIM_ID ,SYSTEM_BIND_PATH)"));
            separateTableManager.addSeparateTable("CLAIM_DETAIL", tables);

        }
        return separateTableManager;
    }

    /**
     * �T�[�r�X�擾�敪�ɉ�����SERVICE_USE_TYPE����肷��SQL����Ԃ��܂��B
     * <p>
     * �����u�擾�敪�v�ɂ͈ȉ��̒l���w�肵�܂��B <br />
     * 101-�\��(SERVICE_DETAIL_GET_PLAN) <br />
     * 102-����(SERVICE_DETAIL_GET_RESULT)<br/>
     * 103-�\��̌��ԕ����̂�(SERVICE_DETAIL_GET_PLAN_OF_MONTHLY_ONLY)
     * </p>
     * 
     * @param useType �擾�敪
     * @return SERVICE_USE_TYPE����肷��SQL��
     */
    protected static String getServiceUseTypeSQLWithoutAnd(int useType) {
        switch (useType) {
        case QkanConstants.SERVICE_DETAIL_GET_PLAN:
            return " (SERVICE.SERVICE_USE_TYPE IN("
                    + QkanConstants.SERVICE_USE_TYPE_PLAN_MONTHLY_DAY + ", "
                    + QkanConstants.SERVICE_USE_TYPE_PLAN_MONTHLY_FREE_DAY
                    + ", " + QkanConstants.SERVICE_USE_TYPE_PLAN_WEEKLY_DAY
                    + ", "
                    + QkanConstants.SERVICE_USE_TYPE_PLAN_WEEKLY_FREE_DAY
                    + "))";
        case QkanConstants.SERVICE_DETAIL_GET_RESULT:
            return " (SERVICE.SERVICE_USE_TYPE IN("
                    + QkanConstants.SERVICE_USE_TYPE_RESULT_MONTHLY_DAY + ", "
                    + QkanConstants.SERVICE_USE_TYPE_RESULT_MONTHLY_FREE_DAY
                    + ", " + QkanConstants.SERVICE_USE_TYPE_RESULT_WEEKLY_DAY
                    + ", "
                    + QkanConstants.SERVICE_USE_TYPE_RESULT_WEEKLY_FREE_DAY
                    + "))";
        case QkanConstants.SERVICE_DETAIL_GET_PLAN_OF_MONTHLY_ONLY:
            return " (SERVICE.SERVICE_USE_TYPE IN("
                    + QkanConstants.SERVICE_USE_TYPE_PLAN_MONTHLY_DAY + ", "
                    + QkanConstants.SERVICE_USE_TYPE_PLAN_MONTHLY_FREE_DAY
                    + "))";
        case QkanConstants.SERVICE_DETAIL_GET_PLAN_OF_WEEKLY_ONLY:
            return " (SERVICE.SERVICE_USE_TYPE IN("
                    + QkanConstants.SERVICE_USE_TYPE_PLAN_WEEKLY_DAY + ", "
                    + QkanConstants.SERVICE_USE_TYPE_PLAN_WEEKLY_FREE_DAY
                    + "))";
        default:
            return " (SERVICE.SERVICE_USE_TYPE = " + useType + ")";
        }

    }

    /**
     * ����f�Ô���擾�֐��ł��B
     * <p>
     * �ڍ׏�񂪁A����f�Ô�Ȃ̂��ǂ����𔻕ʂ��邽�߂Ɏg�p���܂��B <br />
     * �����݂���ꍇ�͓���f�Ô�}�X�^���环�ʔԍ��Ɠ���f�Ô�A�P�ʐ��Ȃǂ��擾����B
     * </p>
     * 
     * @param dbm DBManager
     * @param systemBindPath �ڍ׎��
     * @param targetDate �Ώ۔N����
     * @return ����f�Ô���B��Y���Ȃ��null
     * @throws Exception ������O
     */
    protected static VRMap getSpecialClinicInfo(ACDBManager dbm,
            int systemBindPath, Date targetDate) throws Exception {
        Calendar cal = Calendar.getInstance();
        cal.setTime(targetDate);
        String ym = VRDateParser.format(cal, "yyyy/MM/dd");

        StringBuilder sb;

        sb = new StringBuilder();
        sb.append("SELECT");
        sb.append(" M_SPECIAL_CLINIC.SPECIAL_CLINIC_TYPE,");
        sb.append(" M_SPECIAL_CLINIC.SPECIAL_CLINIC_HISTORY_ID,");
        sb.append(" M_SPECIAL_CLINIC.SPECIAL_CLINIC_NAME,");
        sb.append(" M_SPECIAL_CLINIC.SPECIAL_CLINIC_UNIT,");
        sb.append(" M_SPECIAL_CLINIC.SPECIAL_CLINIC_VALID_START,");
        sb.append(" M_SPECIAL_CLINIC.SPECIAL_CLINIC_VALID_END");
        sb.append(" FROM");
        sb.append(" M_SPECIAL_CLINIC,");
        sb.append(" M_SPECIAL_CLINIC_CONNECTION");
        sb.append(" WHERE");
        sb.append(" (M_SPECIAL_CLINIC_CONNECTION.DETAIL_PROPERTY = "
                + QkanConstants.SPECIAL_CLINIC_TYPE_SERVICE + ")");
        sb.append(" AND(M_SPECIAL_CLINIC_CONNECTION.SYSTEM_BIND_PATH = "
                + systemBindPath + ")");
        sb.append(" AND(M_SPECIAL_CLINIC.SPECIAL_CLINIC_TYPE = M_SPECIAL_CLINIC_CONNECTION.SPECIAL_CLINIC_TYPE)");
        sb.append(" AND(M_SPECIAL_CLINIC.SPECIAL_CLINIC_VALID_START <= '" + ym
                + "')");
        sb.append(" AND(M_SPECIAL_CLINIC.SPECIAL_CLINIC_VALID_END >= '" + ym
                + "')");

        if (dbm != null) {
            VRList ret = dbm.executeQuery(sb.toString());
            if (ret.getDataSize() > 0) {
                return (VRMap) ret.getData();
            }
        }
        return null;
    }

    /**
     * SQL���s���ʂ̏ڍ׏����c�r���牡�r�ɕϊ����ăc���[�}�b�v�Ɋi�[���܂��B
     * 
     * @param result �i�[��
     * @param src SQL���̌���
     * @param orderField ���ёւ��̊�ƂȂ�t�B�[���h��
     * @param shareFields ���ʂ���e���t�B�[���h���̔z��
     * @throws Exception ������O
     */
    protected static void restractureDetail(TreeMap result, VRList src,
            final String orderField, final String[] shareFields)
            throws Exception {
        Iterator it = src.iterator();
        while (it.hasNext()) {
            VRMap row = (VRMap) it.next();
            Object typeObj = VRBindPathParser.get(orderField, row);
            String type = String.valueOf(typeObj);

            // ��{���
            VRMap adder;
            Object map = result.get(type);
            if (map == null) {
                adder = new VRHashMap();
                result.put(type, adder);
                VRBindPathParser.set(orderField, adder, typeObj);
                int end = shareFields.length;
                for (int i = 0; i < end; i++) {
                    VRBindPathParser.set(shareFields[i], adder,
                            VRBindPathParser.get(shareFields[i], row));
                }
            } else {
                adder = (VRMap) map;
            }

            Object path = VRBindPathParser.get("SYSTEM_BIND_PATH", row);
            if (path != null) {
                // SYSTEM_BIND_PATH��null�łȂ��ꍇ
                // �L�[+�l
                VRBindPathParser.set(String.valueOf(path), adder,
                        VRBindPathParser.get("DETAIL_VALUE", row));
            }
        }
    }

    /**
     * �u���p�҂̓����̔F�藚���̂����A�\�����̗������Ȃ����`�F�b�N���܂��B�v�Ɋւ��鏈�����s���܂��B
     * 
     * @param ACDBManager dbm
     * @param Date targetDate �Ώ۔N��
     * @param int patientId ���p��ID
     * @return �\�����̗��������݂��Ȃ��ꍇtrue ���݂���ꍇfalse
     * @throws Exception ������O
     */
    public static boolean isFullDecisionPatientInsureInfo(ACDBManager dbm,
            Date targetDate, int patientId) throws Exception {

        // �����̗v���F�藚�����擾����B
        VRList list = QkanCommon.getPatientInsureInfoHistory(dbm, targetDate,
                patientId);

        if (list == null || list.size() < 1) {
            return false;
        }

        for (int i = 0; i < list.size(); i++) {
            VRMap record = (VRMap) list.get(i);
            int changeFlag = ACCastUtilities
                    .toInt(record.get("CHANGE_CODE"), 1);
            // �\�����̗������������ꍇ��false��Ԃ��B
            if (changeFlag == 1) {
                return false;
            }
        }

        // �\�����̗��������݂��Ȃ��ꍇ��true��Ԃ��B
        return true;

    }

    /**
     * ����ŗ��擾�֐��ł��B
     * <p>
     * �擾�Ɏ��s�����ꍇ�A-1���Ԃ�܂��B
     * </p>
     * 
     * @param dbm DBManager
     * @return ����ŗ�
     * @throws Exception ������O
     */
    public static double getTax(ACDBManager dbm) throws Exception {
        try {
            VRList list = dbm.executeQuery("SELECT TAX FROM TAX");
            if (!list.isEmpty()) {
                return ACCastUtilities
                        .toDouble(
                                VRBindPathParser.get("TAX",
                                        (VRMap) list.getData()), -1);
            }
        } catch (SQLException ex) {
        }
        return -1;
    }

    /**
     * ����ŗ��ݒ�֐��ł��B
     * 
     * @param dbm DBManager
     * @return ����ŗ�
     * @throws Exception ������O
     */
    public static void setTax(ACDBManager dbm, double val) throws Exception {
        dbm.executeUpdate("UPDATE TAX SET TAX=" + val
                + ", LAST_TIME=CURRENT_TIMESTAMP");
    }


    /**
     * �O���A�g�p�Ƀv���p�e�B�t�@�C���t�H���_��ݒ肵�ď��������܂��B
     * 
     * @param propertyXMLDir �v���p�e�B�t�@�C���t�H���_
     */
    public static void initializeForBackgroundCall(String propertyXMLDir) {
        QkanFrameEventProcesser fp = new QkanFrameEventProcesser();
        fp.setPropertyXMLPath(propertyXMLDir + "property.xml");
        ACFrame.getInstance().setFrameEventProcesser(fp);
        QkanCommon.debugInitialize();
    }

    /**
     * �O���A�g�p��DB�}�l�[�W����Ԃ��܂��B
     * 
     * @return DB�}�l�[�W��
     * @throws Exception ������O
     */
    public static ACDBManager createDBManagerForBackgroundCall()
            throws Exception {
        return ((ACDBManagerCreatable) ACFrame.getInstance()
                .getFrameEventProcesser()).createDBManager();
    }

    /**
     * �O���A�g�p�̃V�X�e���C�x���g�����N���X��Ԃ��܂��B
     * 
     * @return �V�X�e���C�x���g�����N���X
     */
    public static ACFrameEventProcesser getFrameEventProcesserForBackgroundCall() {
        return ACFrame.getInstance().getFrameEventProcesser();
    }

    /**
     * �@�����敪����p�̕������ԋp���܂��B
     * 
     * @param systemServiceKindDetail
     * @param targetDate
     * @param dbm
     * @author Masahiko.Higuchi
     * @since V6.0.0
     * @return
     */
    public static String getServiceLowVersion(String systemServiceKindDetail,
            Date targetDate, ACDBManager dbm) throws Exception {
        String lowVersion = QkanCommon.getAffairLowVersion("", targetDate);

        switch (ACCastUtilities.toInt(systemServiceKindDetail)) {
        case 11111:// �K����
            return lowVersion;
        case 11211:// �K��������
            return lowVersion;
        case 11311:// �K��Ō�(���ی�)
            return lowVersion;
        case 11411:// �K�⃊�n�r���e�[�V����
            return lowVersion;
        case 11511:// �ʏ����
            return lowVersion;
        case 11611:// �ʏ����n�r���e�[�V����
            return lowVersion;
        case 11711:// �����p��ݗ^
            return lowVersion;
        case 12111:// �Z�������������
            return lowVersion;
        case 12211:// �Z�������×{���(�V��)
            return lowVersion;
        case 12311:// �Z�������×{���(�×{�a����L����a�@)
            return lowVersion;
        case 12312:// �Z�������×{���(�×{�a����L����f�Ï�)
            return lowVersion;
        case 12313:// �Z�������×{���(�V�l���F�m�ǎ����×{�a����L����a�@)
            return lowVersion;
        case 12314:// �Z�������×{���(��K���f�Ï�)
            return lowVersion;
        case 13111:// ����×{�Ǘ��w��
            return lowVersion;
        case 13211:// �F�m�ǑΉ��^�����������(�Z�����p�ȊO)
            return lowVersion;
        case 13311:// ����{�ݓ����Ґ������
            return lowVersion;
        case 13611:// �n�斧���^����{�ݓ����Ґ������
            return lowVersion;
        case 13811:// �F�m�ǑΉ��^�����������(�Z�����p)
            return lowVersion;
        case 14311:// ������x��
            return lowVersion;
        case 15111:// ���V�l�����{��
            return lowVersion;
        case 15211:// ���V�l�ی��{��
            return lowVersion;
        case 15311:// ���×{�^��Î{��(�×{�a����L����a�@)
            return lowVersion;
        case 15312:// ���×{�^��Î{��(�×{�a����L����f�Ï�)
            return lowVersion;
        case 15313:// ���×{�^��Î{��(�V�l���F�m�ǎ����×{�a����L����a�@)
            return lowVersion;
        case 15411:// �n�斧���^��앟���{��
            return lowVersion;
        case 17111:// ��ԑΉ��^�K����
            return lowVersion;
        case 17211:// �F�m�ǑΉ��^�ʏ����
            return lowVersion;
        case 17311:// ���K�͑��@�\�^������i�Z�����p�ȊO�j
            return lowVersion;
        case 16811:// ���K�͑��@�\�^������i�Z�����p�j[H27.4�@�����Ή�] add
            return lowVersion;
        case 90101:// ���̑�
            return lowVersion;
        case 90201:// ��ȓ��퐶����̊���
            return lowVersion;
        case 16111: // ���\�h�K����
            return lowVersion;
        case 16211: // ���\�h�K��������
            return lowVersion;
        case 16311: // ���\�h�K��Ō�
            return lowVersion;
        case 16411: // ���\�h�K�⃊�n
            return lowVersion;
        case 16511: // ���\�h�ʏ����
            return lowVersion;
        case 16611: // ���\�h�ʏ����n
            return lowVersion;
        case 16711: // ���\�h�����p��ݗ^
            return lowVersion;
        case 12411: // ���\�h�Z�������������
            return lowVersion;
        case 12511: // ���\�h�Z�������×{���i�V���j
            return lowVersion;
        case 12611: // ���\�h�Z�������×{���i�a�@�j
            return lowVersion;
        case 12612: // ���\�h�Z�������×{���i�f�Ï��j
            return lowVersion;
        case 12613: // ���\�h�Z�������×{���i�F�m�ǎ����^�j
            return lowVersion;
        case 12614: // ���\�h�Z�������×{���i��K���^�f�Ï��j
            return lowVersion;
        case 13411: // ���\�h����×{�Ǘ��w��
            return lowVersion;
        case 13511: // ���\�h����{�ݓ����Ґ������
            return lowVersion;
        case 14611: // ���\�h�x��
            return lowVersion;
        case 17411: // ���\�h�F�m�ǑΉ��^�ʏ����
            return lowVersion;
        case 17511: // ���\�h���K�͑��@�\�^������i�Z�����p�ȊO�j
            return lowVersion;
        case 16911: // ���\�h���K�͑��@�\�^������i�Z�����p�j[H27.4�@�����Ή�] add
            return lowVersion;
        case 13711: // ���\�h�F�m�ǑΉ��^�����������i�Z�����p�ȊO�j
            return lowVersion;
        case 13911: // ���\�h�F�m�ǑΉ��^�����������i�Z�����p�j
            return lowVersion;
        case 12711: // ����{�ݓ����Ґ������i�Z�����p�j
            return lowVersion;
        case 17611: // �������E�����Ή��^�K����Ō�
            return lowVersion;
        case 12811: // �n�斧���^����{�ݓ����Ґ������i�Z�����p�j
            return lowVersion;
        case 17711: // �����^�T�[�r�X�i�Z�����p�ȊO�j
            return lowVersion;
        case 17911: // �����^�T�[�r�X�i�Z�����p�j[H27.4�@�����Ή�] add
            return lowVersion;
        }

        return lowVersion;
    }

    /**
     * �Ɩ���p�l���Ȃǂ̖@�����敪�𔻒肵�擾���܂��B
     * 
     * @param className
     * @param targetDate
     * @return
     * @throws Exception
     */
    public static String getAffairLowVersion(String className, Date targetDate)
            throws Exception {
        // �p�l���Ŏg�p���镶�����ԋp����
        // �p�l���ɉ����ĕԋp���镶�����ύX�ł���悤�ɕ��򂳂���
// 2014/1/9 [Yoichiro Kamei] edit - begin H27.4�����Ή���
        //int lowVersion = QkanConstants.SERVICE_LOW_VERSION_H2404;
        int lowVersion = QkanConstants.SERVICE_LOW_VERSION_H2704;
// �����͐ؑփe�X�g�p
//        if (targetDate != null && ACDateUtilities.getDifferenceOnDay(QkanConstants.H2704, targetDate) < 1) {
//            lowVersion = QkanConstants.SERVICE_LOW_VERSION_H2704;
//        }
// 2014/1/9 [Yoichiro Kamei] edit - end
        String lowVersionString = ACCastUtilities.toString(lowVersion, "");
        lowVersionString = lowVersionString.substring(0, 6);

        if ("QS001S01".equals(className)) {
            return lowVersionString;
        } else if ("QS001S02".equals(className)) {
            return lowVersionString;
        }

        return lowVersionString;
    }
    
    /**
     * �Ó��ȃf�[�^�x�[�X�X�L�[�}�̃o�[�W�����ł��邩���肵�܂��B
     * @param version M_QKAN_VERSION.SCHEME_VERSION
     * @return �V�X�e���̉^�p�ɖ��Ȃ��X�L�[�}�o�[�W�����ł���ꍇtrue
     * @throws Exception
     */
    public static boolean isValidSchemaVersion(String version) throws Exception {
        
        if (ACTextUtilities.isNullText(version)){
            return false;
        }
        
        String[] ary = version.split("\\.");
        
        if (ary.length < 3) {
            return false;
        }
// 2015/4/17 [H27.4�����Ή�][Yoichiro Kamei] edit - begin
//        //���W���[�o�[�W������6�����͕s���ȃX�L�[�}
//        if (ACCastUtilities.toInt(ary[0], 0) < 6) {
        //���W���[�o�[�W������7�����͕s���ȃX�L�[�}
        if (ACCastUtilities.toInt(ary[0], 0) < 7) {
// 2015/4/17 [H27.4�����Ή�][Yoichiro Kamei] edit - end
            return false;
        }
        
        return true;
    }
    
    /**
     * ���J�ȋK��̎x�����x�z�E�O�����p�^���t����P�ʐ����擾����
     * @param dbm
     * @param targetDate    �Ώ۔N��
     * @param limitRateType �x�����x�z�敪�i1:�x�����x�z�A2:�O�����p�^�j
     * @param jotaiCode     ���x
     * @throws Exception ������O
     * @return SQL��
     * 2014/01/24 [Shinobu Hitaka] �y2014.4 �敪�x�����x�z����Ή��z�̂��ߒǉ�
     */
    public static int getOfficialLimitRate(ACDBManager dbm, Date targetDate, int limitRateType, String jotaiCode) throws Exception{
        
        Calendar cal = Calendar.getInstance();
        cal.setTime(targetDate);
        String ym = VRDateParser.format(cal, "yyyy/MM");

        StringBuilder sb = new StringBuilder();

        //�Ώ۔N���̊J�n�I������ݒ�
        String targetDateBegin = ym + "/01";
        String targetDateEnd = ym + "/" + cal.getActualMaximum(Calendar.DAY_OF_MONTH);

        //SQL�쐬
        sb.append("SELECT");
        sb.append(" LIMIT_RATE_VALUE");
        sb.append(" FROM");
        sb.append(" M_LIMIT_RATE_DETAIL");
        sb.append(" WHERE");
        sb.append("     (M_LIMIT_RATE_DETAIL.JOTAI_CODE = " + jotaiCode + ")");
        sb.append(" AND (M_LIMIT_RATE_DETAIL.LIMIT_RATE_TYPE = " + ACCastUtilities.toString(limitRateType) + ")");
        sb.append(" AND (M_LIMIT_RATE_DETAIL.LIMIT_RATE_HISTORY_ID = ");
        sb.append(" (SELECT");
        sb.append("  MAX(M_LIMIT_RATE.LIMIT_RATE_HISTORY_ID)");
        sb.append("  FROM");
        sb.append("  M_LIMIT_RATE");
        sb.append("  WHERE");
        sb.append("      (M_LIMIT_RATE.LIMIT_RATE_TYPE =" + ACCastUtilities.toString(limitRateType) + ")");
        sb.append("  AND (M_LIMIT_RATE.LIMIT_RATE_VALID_START <='" + targetDateEnd + "')");
        sb.append("  AND (M_LIMIT_RATE.LIMIT_RATE_VALID_END >='" + targetDateBegin + "')");
        sb.append(" ))");
        
        VRList limitList = dbm.executeQuery(sb.toString());
        int limitRate = -1;
        if (!(limitList == null || limitList.size() == 0)) {
            limitRate = ACCastUtilities.toInt(VRBindPathParser.get(
                    "LIMIT_RATE_VALUE", (VRMap) limitList.get(0)));
        }
        return limitRate;
    }
    
// 2015/4/13 [H27.04�����Ή�][Yoichiro Kamei] add - begin �Z���n����Ή�
	private static final Integer JUSHOTI_TOKUREI_CATEGORY_NO = new Integer(18);
    /**
     * ���׏��i�Z���n����j�̃o�C���h�p�X�𖾍׏��̃p�X�ɃR�s�[����
     * 
     * @param claimDataMap �����Ώۂ̃}�b�v
     * @throws Exception ������O
     */
	public static void convertPathJushotiTokureiToDetail(VRMap claimDataMap) throws Exception {
		// ���׏��i�Z���n����j�̃o�C���h�p�X�𖾍׏��̃p�X�ɃR�s�[
		if (JUSHOTI_TOKUREI_CATEGORY_NO.equals(claimDataMap.getData("CATEGORY_NO"))) {
			VRBindPathParser.set("301001", claimDataMap, VRBindPathParser.get("1801001", claimDataMap));
			VRBindPathParser.set("301002", claimDataMap, VRBindPathParser.get("1801002", claimDataMap));
			VRBindPathParser.set("301003", claimDataMap, VRBindPathParser.get("1801003", claimDataMap));
			VRBindPathParser.set("301004", claimDataMap, VRBindPathParser.get("1801004", claimDataMap));
			VRBindPathParser.set("301005", claimDataMap, VRBindPathParser.get("1801005", claimDataMap));
			VRBindPathParser.set("301006", claimDataMap, VRBindPathParser.get("1801006", claimDataMap));
			VRBindPathParser.set("301007", claimDataMap, VRBindPathParser.get("1801007", claimDataMap));
			VRBindPathParser.set("301008", claimDataMap, VRBindPathParser.get("1801008", claimDataMap));
			VRBindPathParser.set("301009", claimDataMap, VRBindPathParser.get("1801009", claimDataMap));
			VRBindPathParser.set("301010", claimDataMap, VRBindPathParser.get("1801010", claimDataMap));
			VRBindPathParser.set("301011", claimDataMap, VRBindPathParser.get("1801011", claimDataMap));
			VRBindPathParser.set("301012", claimDataMap, VRBindPathParser.get("1801012", claimDataMap));
			VRBindPathParser.set("301013", claimDataMap, VRBindPathParser.get("1801013", claimDataMap));
			VRBindPathParser.set("301014", claimDataMap, VRBindPathParser.get("1801014", claimDataMap));
			VRBindPathParser.set("301015", claimDataMap, VRBindPathParser.get("1801015", claimDataMap));
			VRBindPathParser.set("301016", claimDataMap, VRBindPathParser.get("1801016", claimDataMap));
			VRBindPathParser.set("301017", claimDataMap, VRBindPathParser.get("1801017", claimDataMap));
			VRBindPathParser.set("301018", claimDataMap, VRBindPathParser.get("1801019", claimDataMap));
			VRBindPathParser.set("301019", claimDataMap, VRBindPathParser.get("1801020", claimDataMap));
			VRBindPathParser.set("301020", claimDataMap, VRBindPathParser.get("1801021", claimDataMap));
			VRBindPathParser.set("301021", claimDataMap, VRBindPathParser.get("1801022", claimDataMap));
			VRBindPathParser.set("301022", claimDataMap, VRBindPathParser.get("1801023", claimDataMap));
		}
	}
	
    /**
     * ���׏��i�Z���n����j���R�[�h�ɂ��āA�ϊ����Ă���o�C���h�p�X�����ɖ߂�
     * 
     * @param claimDataMap �����Ώۂ̃}�b�v
     * @throws Exception ������O
     */
	public static void convertPathJushotiTokureiToOriginal(VRMap claimDataMap) throws Exception {
		
		if (JUSHOTI_TOKUREI_CATEGORY_NO.equals(claimDataMap.getData("CATEGORY_NO"))) {
			//���׏��i�Z���n����j���R�[�h�ɂ��āA�ϊ����Ă���o�C���h�p�X�����ɖ߂�
			VRBindPathParser.set("1801001", claimDataMap, VRBindPathParser.get("301001", claimDataMap));
			VRBindPathParser.set("1801002", claimDataMap, VRBindPathParser.get("301002", claimDataMap));
			VRBindPathParser.set("1801003", claimDataMap, VRBindPathParser.get("301003", claimDataMap));
			VRBindPathParser.set("1801004", claimDataMap, VRBindPathParser.get("301004", claimDataMap));
			VRBindPathParser.set("1801005", claimDataMap, VRBindPathParser.get("301005", claimDataMap));
			VRBindPathParser.set("1801006", claimDataMap, VRBindPathParser.get("301006", claimDataMap));
			VRBindPathParser.set("1801007", claimDataMap, VRBindPathParser.get("301007", claimDataMap));
			VRBindPathParser.set("1801008", claimDataMap, VRBindPathParser.get("301008", claimDataMap));
			VRBindPathParser.set("1801009", claimDataMap, VRBindPathParser.get("301009", claimDataMap));
			VRBindPathParser.set("1801010", claimDataMap, VRBindPathParser.get("301010", claimDataMap));
			VRBindPathParser.set("1801011", claimDataMap, VRBindPathParser.get("301011", claimDataMap));
			VRBindPathParser.set("1801012", claimDataMap, VRBindPathParser.get("301012", claimDataMap));
			VRBindPathParser.set("1801013", claimDataMap, VRBindPathParser.get("301013", claimDataMap));
			VRBindPathParser.set("1801014", claimDataMap, VRBindPathParser.get("301014", claimDataMap));
			VRBindPathParser.set("1801015", claimDataMap, VRBindPathParser.get("301015", claimDataMap));
			VRBindPathParser.set("1801016", claimDataMap, VRBindPathParser.get("301016", claimDataMap));
			VRBindPathParser.set("1801017", claimDataMap, VRBindPathParser.get("301017", claimDataMap));
			VRBindPathParser.set("1801019", claimDataMap, VRBindPathParser.get("301018", claimDataMap));
			VRBindPathParser.set("1801020", claimDataMap, VRBindPathParser.get("301019", claimDataMap));
			VRBindPathParser.set("1801021", claimDataMap, VRBindPathParser.get("301020", claimDataMap));
			VRBindPathParser.set("1801022", claimDataMap, VRBindPathParser.get("301021", claimDataMap));
			VRBindPathParser.set("1801023", claimDataMap, VRBindPathParser.get("301022", claimDataMap));
			
			// ���׏�񃌃R�[�h�̃o�C���h�p�X������
			claimDataMap.removeData("301001");
			claimDataMap.removeData("301002");
			claimDataMap.removeData("301003");
			claimDataMap.removeData("301004");
			claimDataMap.removeData("301005");
			claimDataMap.removeData("301006");
			claimDataMap.removeData("301007");
			claimDataMap.removeData("301008");
			claimDataMap.removeData("301009");
			claimDataMap.removeData("301010");
			claimDataMap.removeData("301011");
			claimDataMap.removeData("301012");
			claimDataMap.removeData("301013");
			claimDataMap.removeData("301014");
			claimDataMap.removeData("301015");
			claimDataMap.removeData("301016");
			claimDataMap.removeData("301017");
			claimDataMap.removeData("301018");
			claimDataMap.removeData("301019");
			claimDataMap.removeData("301020");
			claimDataMap.removeData("301021");
			claimDataMap.removeData("301022");
		}
	}
// 2015/4/13 [H27.04�����Ή�] add - end
	

}