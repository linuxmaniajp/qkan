/*
 * Project code name "ORCA"
 * ���t�Ǘ��䒠�\�t�g QKAACHO�iJMA care benefit management software�j
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
 * �쐬��: 2005/12/06  ���{�R���s���[�^�[������� �����@�L �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���ъm��/�������o�� (P)
 * �v���Z�X �������� (001)
 * �v���O���� ������i���䃂�W���[�� (QP001CSVCreator)
 *
 *****************************************************************
 */

package jp.nichicom.ac.lib.care.claim.calculation;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import jp.nichicom.ac.bind.ACBindUtilities;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.pdf.ACChotarouXMLWriter;
import jp.nichicom.ac.sql.ACDBManager;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.ac.util.ACDateUtilities;
import jp.nichicom.ac.util.ACMessageBox;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.text.parsers.VRDateParser;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRLinkedHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.nichicom.vr.util.logging.VRLogger;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.QkanConstants;
import jp.or.med.orca.qkan.QkanSystemInformation;
import jp.or.med.orca.qkan.affair.QkanMessageList;

public class QP001PrintControl {

    /**
     * DB�ڑ��}�l�[�W��
     */
    private ACDBManager dbm = null;
    /**
     * PDF�������C�u����
     */
    private ACChotarouXMLWriter writer = null;
    /**
     * �Ɩ��N�����[�h
     */
    private String affair = null;
    /**
     * �o�͑Ώۗ��p�҈ꗗ
     */
    private VRList patientList = null;
    /**
     * ���Ə��ꗗ
     */
    private VRMap providerMap = null;
    /**
     * ����I�v�V����
     */
    private String yoshikiBango = "0";

    /**
     * ��������҂̗��p�ҕ��S�z��0�~�̏ꍇ�ɖ��׏��Ɉ󎚂���I�v�V����
     */
    private String printNursingZero = "0";

    /**
     * ��������҂̕��S���x�z��0�~�̏ꍇ�ɖ��׏��Ɉ󎚂���I�v�V����
     */
    private String printNursingLimitZero = "0";

    /**
     * ������������t
     */
    private Date printDate = null;

    private QP001Manager manager = null;

    // ���p�ҕ��S�������҃X�L�b�v�p�t���O
    private int patientClaimPdfCount = 0;
    private int patientClaimPdfEmptyCount = 0;
    
    // ���p�Ҍ������������i���ȕ��S���O�~�j���X�L�b�v���邩
    private boolean skipEmptyPatientClaim = true;
    // ���p�ҕ��S�̔������Ȃ����p�ҊǗ��p
    private ArrayList noPatientSelfList = new VRArrayList();
    

    //���r���ŔF���񂪕ω�����ꍇ�̋��t�Ǘ��[�ŁA���v�ƍ��v���z�̃`�F�b�N
    private QP001ErrorControl errorControl = null;

    /**
     * �f�t�H���g�R���X�g���N�^
     * 
     */
    public QP001PrintControl() {
    }

    /**
     * �g�p����DB�}�l�[�W����ݒ肷��B
     * 
     * @param dbm
     * @throws Exception
     */
    public void setDBManager(ACDBManager dbm) throws Exception {
        this.dbm = dbm;
    }

    /**
     * �g�p����PDF�������C�u������ݒ肷��B
     * 
     * @param writer
     * @throws Exception
     */
    public void setWriter(ACChotarouXMLWriter writer) throws Exception {
        this.writer = writer;
    }

    /**
     * �Ɩ��̋N�����[�h��ݒ肷��B
     * 
     * @param affair
     * @throws Exception
     */
    public void setAffair(String affair) throws Exception {
        this.affair = affair;
    }

    /**
     * �����Ɏg�p���闘�p�҂̈ꗗ��o�^����B
     * 
     * @param patientList
     * @throws Exception
     */
    public void setPatientList(VRList patientList) throws Exception {
        this.patientList = patientList;
    }

    /**
     * ���Ə��̈ꗗ��ݒ肷��B
     * 
     * @param providerMap
     * @throws Exception
     */
    public void setProviderMap(VRMap providerMap) throws Exception {
        this.providerMap = providerMap;
    }

    /**
     * ����I�v�V�����i�l���ԍ��̈󎚁j��\������B
     * 
     * @param yoshikiBango
     * @throws Exception
     */
    public void setPrintOption(String yoshikiBango) throws Exception {
        this.yoshikiBango = yoshikiBango;
    }

    /**
     * ��������҂̗��p�ҕ��S�z��0�~�̏ꍇ�ɖ��׏��Ɉ󎚂���I�v�V������ݒ肷��
     * 
     * @param printNursingZero
     * @throws Exception
     */
    public void setPrintNursingZero(String printNursingZero) throws Exception {
        this.printNursingZero = printNursingZero;
    }

    /**
     * ��������҂̕��S���x�z��0�~�̏ꍇ�ɖ��׏��Ɉ󎚂���I�v�V������ݒ肷��
     * 
     * @param printNursingLimitZero
     * @throws Exception
     */
    public void setPrintNursingLimitZero(String printNursingLimitZero)
            throws Exception {
        this.printNursingLimitZero = printNursingLimitZero;
    }

    /**
     * �������̈������ݒ肵�܂��B
     * 
     * @param printDate
     * @throws Exception
     */
    public void setPrintDate(Date printDate) throws Exception {
        this.printDate = printDate;
    }

    public void setManager(QP001Manager manager) throws Exception {
        this.manager = manager;
    }

    private boolean isInit() throws Exception {

        if (dbm == null) {
            VRLogger.warning("DB�ڑ��}�l�[�W�����o�^����Ă��܂���B");
            return false;
        }
        if (writer == null) {
            VRLogger.warning("PDF�������C�u�������o�^����Ă��܂���B");
            return false;
        }
        if (affair == null) {
            VRLogger.warning("�Ɩ��N�����[�h���o�^����Ă��܂���B");
            return false;
        }
        if (patientList == null) {
            VRLogger.warning("�o�͑Ώۗ��p�҈ꗗ���o�^����Ă��܂���B");
            return false;
        }
        if (providerMap == null) {
            VRLogger.warning("���Ə��ꗗ���o�^����Ă��܂���B");
            return false;
        }

        if (manager == null) {
            VRLogger.warning("�}�X�^�f�[�^�I�u�W�F�N�g���o�^����Ă��܂���B");
            return false;
        }

        return true;
    }

    /**
     * ���[��������s����B
     * 
     * @param param
     *            ����p�����^
     * @return
     * @throws Exception
     */
    public boolean doPrint(VRMap param) throws Exception {

        if (!isInit()) {
            throw new Exception("�����ݒ肪�s���Ă��܂���B");
        }
        
        boolean printResult = false;
        
        // ����N���X�ֈ����n�����̋��ʕ������`
        VRHashMap printParam = new VRHashMap();
        
        // ���Ə����
        printParam.put("PROVIDERS", providerMap);
        // �l���ԍ�����I�v�V����
        printParam.put("YOSHIKI_BANGO", yoshikiBango);
        // ��������҂̗��p�ҕ��S�z��0�~�̏ꍇ�ɖ��׏��Ɉ󎚂���I�v�V����
        printParam.put("PRINT_NURSING_ZERO", printNursingZero);
        // ��������҂̕��S���x�z��0�~�̏ꍇ�ɖ��׏��Ɉ󎚂���I�v�V����
        printParam.put("PRINT_NURSING_LIMIT_ZERO", printNursingLimitZero);
        // �f�[�^�L���b�V��
        printParam.put("MANAGER", manager);
        
        // �u02�v�̏ꍇ �����p�҈ꗗ�i���t�Ǘ��[�@�l����\��j
        if ("02".equals(affair)) {
            printResult = doPrintMode02(printParam);
            
        // �u03�v�̏ꍇ �����p�҈ꗗ�i�ݑ�T�[�r�X�x�����Ə������@�l���掵�j
        } else if ("03".equals(affair)) {
            printResult = doPrintMode03(printParam);

        // �u04�v�̏ꍇ �����p�҈ꗗ�i�ݑ�T�[�r�X�񋟎��Ə������@�l�����`�Z�A���`�\�j
        } else if ("04".equals(affair)) {

            // �T�[�r�X�̖��̂�t��
            printParam.put("SERVICE_NAME", manager.getServices());
            
            printResult = doPrintMode04(printParam);

        // �u05�v�͌���
        // �u06�v�͈�Â��������p�~

        // �u07�v�̏ꍇ �����p�҈ꗗ(���p�Ҍ������)
        } else if ("07".equals(affair)) {
            printResult = doPrintMode07(printParam, param);

        // �u08�v�̏ꍇ �����p�҈ꗗ(��싋�t��׏�����@�l�����)
        } else if ("08".equals(affair)) {
            printResult = doPrintMode08(printParam);
            
        }
        
        printParam.clearData();
        printParam = null;
        
        return printResult;
    }
    
    
    // ���[�h���u02�v�̏ꍇ�̈������ �����p�҈ꗗ�i���t�Ǘ��[�@�l����\��j
    private boolean doPrintMode02(VRHashMap printParam) throws Exception {
        
        errorControl = new QP001ErrorControl();
        
        // patientData�̌��������[�v����B
        for (int i = 0; i < patientList.size(); i++) {
            VRMap map = (VRMap) patientList.getData(i);

            // ���I���̏ꍇ�������X�L�b�v����B
            if (!isCheckedRow(map)) {
                continue;
            }
            
            // �����N��
            Date claimDate = ACCastUtilities.toDate(map.get("CLAIM_DATE"));
            // ���p��ID�ޔ�p��int patient_id �𐶐����ApatientData�� KEY : PATIENT_ID ��ݒ肷��B
            int patient_id = ACCastUtilities.toInt(VRBindPathParser.get("PATIENT_ID", map));
            // �l���ԍ����擾����B
            int claimStyleType = ACCastUtilities.toInt(VRBindPathParser.get("CLAIM_STYLE_TYPE", map), 0);

            // �����ڍ׏����擾���AVRArrayList claimList �Ɋi�[����B
            StringBuilder sb = getClaimDetailWhere(map, patient_id, claimDate);
            sb.append(" AND(CLAIM.CLAIM_STYLE_TYPE = " + claimStyleType + ")");

            VRList claimList = QkanCommon.getClaimDetailCustom(dbm, claimDate, sb.toString());

            if ((claimList == null) || (claimList.size() == 0)) {
                VRLogger.warning("�W�v�f�[�^�擾�G���[:" + sb.toString());
                continue;
            }

            // �����Ώۓ�
            printParam.put("SEIKYU_DATE", claimDate);
            // ���[�f�[�^
            printParam.put("STYLE_DATA", claimList);
            // ���p�ҏ��
            VRMap patient = (VRLinkedHashMap) QkanCommon.getPatientInfo(dbm, patient_id).get(0);
            printParam.put("PATIENT", patient);
            // �l���ԍ�
            printParam.put("CLAIM_STYLE_TYPE", String.valueOf(claimStyleType));

            // ���t�Ǘ��[�̈�����s��
            if (QkanConstants.CLAIM_STYLE_BENEFIT_MANAGEMENT == claimStyleType) {
                // ����21�N4���@�����Ή� �����őÓ����𔻒f
                if (!errorControl.isValidBenefitManagement(claimList, patient)) {
                    continue;
                }

                new QP001P11_201204().doPrint(writer, printParam);
            }
            
        }
        
        errorControl.showBenefitManagementError();
        if (errorControl.isAllError()) {
            return false;
        }
        
        return true;
    }
    
    
    
    
    // ���[�h���u03�v�̏ꍇ �����p�҈ꗗ�i�ݑ�T�[�r�X�x�����Ə������@�l���掵�j
    @SuppressWarnings("unchecked")
    private boolean doPrintMode03(VRHashMap printParam) throws Exception {
        
        // �l���掵����I�u�W�F�N�g
        Map<String, VRList> style7 = new TreeMap<String, VRList>();
        
        for (int i = 0; i < patientList.size(); i++) {
            VRMap map = (VRMap) patientList.getData(i);

            // ���I���̏ꍇ�������X�L�b�v����B
            if (!isCheckedRow(map)) {
                continue;
            }

            // �����N��
            Date claimDate = ACCastUtilities.toDate(map.get("CLAIM_DATE"));
            // ���p��ID�ޔ�p��int patient_id �𐶐����ApatientData�� KEY : PATIENT_ID ��ݒ肷��B
            int patient_id = ACCastUtilities.toInt(VRBindPathParser.get("PATIENT_ID", map));
            // �l���ԍ����擾����B
            int claimStyleType = ACCastUtilities.toInt(VRBindPathParser.get("CLAIM_STYLE_TYPE", map), 0);

            // �����ڍ׏����擾���AVRArrayList claimList �Ɋi�[����B
            StringBuilder sb = getClaimDetailWhere(map, patient_id, claimDate);
            sb.append(" AND(CLAIM.CLAIM_STYLE_TYPE = " + claimStyleType + ")");

            VRList claimList = QkanCommon.getClaimDetailCustom(dbm, claimDate, sb.toString());

            if ((claimList == null) || (claimList.size() == 0)) {
                VRLogger.warning("�W�v�f�[�^�擾�G���[:" + sb.toString());
                continue;
            }

            // ���p�ҏ��
            VRMap patient = (VRLinkedHashMap) QkanCommon.getPatientInfo(dbm, patient_id).get(0);

            // �ݑ���x����싋�t��׏�-�l���掵(QP00108)�̈�����s���B
            // �l���掵�͍Ō�ɂ܂Ƃ߂ďo�͂���K�p������B
            VRMap style7Map = (VRMap) claimList.get(0);

            // ���Ə��ԍ� + �Ώ۔N�� + �ی��Ҕԍ� + ����S�Ҕԍ�+�Ώ۔N�����L�[�ɂ���
            String key = String.valueOf(style7Map.get("1001002")) + "-"
                    + String.valueOf(style7Map.get("1001004")) + "-"
                    + String.valueOf(style7Map.get("1001005")) + "-";

            if (!ACTextUtilities.isNullText(style7Map.get("1001008"))) {
                key += String.valueOf(style7Map.get("1001008"));
            }

            // �\�h�Ή��J�n
            key += String.valueOf(claimStyleType);
            // �\�h�Ή��I��

            // �l���掵���������R�[�h��ێ�����悤�ɂȂ����̂ŁA
            // ���W�b�N��啝�ɕύX
            VRMap style7DataMap = new VRHashMap();

            style7DataMap.put("PATIENT_FAMILY_KANA", patient.get("PATIENT_FAMILY_KANA"));
            style7DataMap.put("PATIENT_FIRST_KANA", patient.get("PATIENT_FIRST_KANA"));
            style7DataMap.put("PATIENT_FAMILY_NAME", patient.get("PATIENT_FAMILY_NAME"));
            style7DataMap.put("PATIENT_FIRST_NAME",patient.get("PATIENT_FIRST_NAME"));
            style7DataMap.put("CLAIM_DATA", claimList);

            VRList style7List = null;
            if (style7.containsKey(key)) {
                style7List = style7.get(key);
            } else {
                style7List = new VRArrayList();
                style7.put(key, style7List);
            }
            style7List.add(style7DataMap);
        }
        
        
        Iterator<String> it = style7.keySet().iterator();
        while (it.hasNext()) {
            
            // �\�h�Ή�
            String key =it.next();
            // ���[�f�[�^
            printParam.put("STYLE_DATA", style7.get(key));

            // �l���掵
            if (key.endsWith(String
                    .valueOf(QkanConstants.CLAIM_STYLE_FORMAT_7))) {
                new QP001P071_201204().doPrint(writer, printParam);
                // �l���掵�̓�
            } else if (key.endsWith(String
                    .valueOf(QkanConstants.CLAIM_STYLE_FORMAT_7_2))) {
                new QP001P072_201204().doPrint(writer, printParam);
            }
        }
        
        return true;
    }
    
    
    
    
    // �������[�h���u04�v�̏ꍇ �����p�҈ꗗ�i�ݑ�T�[�r�X�񋟎��Ə������@�l�����`�Z�A���`�\�j
    private boolean doPrintMode04(VRHashMap printParam) throws Exception {
        // patientData�̌��������[�v����B
        for (int i = 0; i < patientList.size(); i++) {
            VRMap map = (VRMap) patientList.getData(i);

            // ���I���̏ꍇ�������X�L�b�v����B
            if (!isCheckedRow(map)) {
                continue;
            }

            // �����N��
            Date claimDate = ACCastUtilities.toDate(map.get("CLAIM_DATE"));
            // ���p��ID�ޔ�p��int patient_id �𐶐����ApatientData�� KEY : PATIENT_ID ��ݒ肷��B
            int patient_id = ACCastUtilities.toInt(VRBindPathParser.get("PATIENT_ID", map));
            // �l���ԍ����擾����B
            int claimStyleType = ACCastUtilities.toInt(VRBindPathParser.get("CLAIM_STYLE_TYPE", map), 0);

            // �����ڍ׏����擾���AVRArrayList claimList �Ɋi�[����B
            StringBuilder sb = getClaimDetailWhere(map, patient_id, claimDate);
            sb.append(" AND(CLAIM.CLAIM_STYLE_TYPE = " + claimStyleType + ")");

            VRList claimList = QkanCommon.getClaimDetailCustom(dbm, claimDate, sb.toString());

            if ((claimList == null) || (claimList.size() == 0)) {
                VRLogger.warning("�W�v�f�[�^�擾�G���[:" + sb.toString());
                continue;
            }

            // �����Ώۓ�
            printParam.put("SEIKYU_DATE", claimDate);
            // ���[�f�[�^
            printParam.put("STYLE_DATA", claimList);
            // ���p�ҏ��
            VRMap patient = (VRLinkedHashMap) QkanCommon.getPatientInfo(dbm, patient_id).get(0);
            printParam.put("PATIENT", patient);
            // �l���ԍ�
            printParam.put("CLAIM_STYLE_TYPE", String.valueOf(claimStyleType));

            switch (claimStyleType) {
            // �ݑ�T�[�r�X��싋�t��׏��i����j(QP001P021)�̈�����s���B
            case QkanConstants.CLAIM_STYLE_FORMAT_2:
                new QP001P021_201204().doPrint(writer, printParam);
                break;

            // �ݑ�T�[�r�X��싋�t��׏��i����j(QP001P022)�̈�����s���B
            case QkanConstants.CLAIM_STYLE_FORMAT_2_2:
                new QP001P022_201204().doPrint(writer, printParam);
                break;

            // ���\�h�E���퐶���x���������Ɣ�׏��i�K��^�E�ʏ��^�E���̑��̐����x���j(QP001P023)�̈�����s���B
            case QkanConstants.CLAIM_STYLE_FORMAT_2_3:
                new QP001P023_201504().doPrint(writer, printParam);
                break;

            // �ݑ�T�[�r�X��싋�t��׏��i�Z�������������j(QP001P031)�̈�����s���B
            case QkanConstants.CLAIM_STYLE_FORMAT_3:
                new QP001P031_201204().doPrint(writer, printParam);
                break;

            // �ݑ�T�[�r�X��싋�t��׏��i�Z�������������j(QP001P032)�̈�����s���B
            case QkanConstants.CLAIM_STYLE_FORMAT_3_2:
                new QP001P032_201204().doPrint(writer, printParam);
                break;

            // �ݑ�T�[�r�X��싋�t��׏��i���V�l�ی��{�݁j(QP001P041)�̈�����s���B
            case QkanConstants.CLAIM_STYLE_FORMAT_4:
                new QP001P041_201204().doPrint(writer, printParam);
                break;

            // �ݑ�T�[�r�X��싋�t��׏��i���V�l�ی��{�݁j(QP001P042)�̈�����s���B
            case QkanConstants.CLAIM_STYLE_FORMAT_4_2:
                new QP001P042_201204().doPrint(writer, printParam);
                break;

            // �ݑ�T�[�r�X��싋�t��׏��i�a�@���͐f�Ï��j(QP001P051)�̈�����s���B
            case QkanConstants.CLAIM_STYLE_FORMAT_5:
                new QP001P051_201204().doPrint(writer, printParam);
                break;

            // �ݑ�T�[�r�X��싋�t��׏��i�a�@���͐f�Ï��j(QP001P052)�̈�����s���B
            case QkanConstants.CLAIM_STYLE_FORMAT_5_2:
                new QP001P052_201204().doPrint(writer, printParam);
                break;

            // �ݑ�T�[�r�X��싋�t��׏��i�F�m�ǑΉ��^�E����{�ݓ����ҁj(QP001P061)�̈�����s���B
            case QkanConstants.CLAIM_STYLE_FORMAT_6:
                new QP001P061_201204().doPrint(writer, printParam);
                break;

            // �ݑ�T�[�r�X��싋�t��׏��i�F�m�ǑΉ��^�E����{�ݓ����ҁj(QP001P062)�̈�����s���B
            case QkanConstants.CLAIM_STYLE_FORMAT_6_2:
                new QP001P062_201204().doPrint(writer, printParam);
                break;

            // �ݑ�T�[�r�X��싋�t��׏��i�F�m�ǑΉ��^�E����{�ݓ����ҁj(QP001P063)�̈�����s���B
            case QkanConstants.CLAIM_STYLE_FORMAT_6_3:
                new QP001P063_201204().doPrint(writer, printParam);
                break;

            // �ݑ�T�[�r�X��싋�t��׏��i�F�m�ǑΉ��^�E����{�ݓ����ҁj(QP001P064)�̈�����s���B
            case QkanConstants.CLAIM_STYLE_FORMAT_6_4:
                new QP001P064_201204().doPrint(writer, printParam);
                break;

            // �ݑ�T�[�r�X��싋�t��׏��i�F�m�ǑΉ��^�E����{�ݓ����ҁj(QP001P065)�̈�����s���B
            case QkanConstants.CLAIM_STYLE_FORMAT_6_5:
                new QP001P065_201204().doPrint(writer, printParam);
                break;

            // �ݑ�T�[�r�X��싋�t��׏��i�F�m�ǑΉ��^�E����{�ݓ����ҁj(QP001P066)�̈�����s���B
            case QkanConstants.CLAIM_STYLE_FORMAT_6_6:
                new QP001P066_201204().doPrint(writer, printParam);
                break;
                
            // �ݑ�T�[�r�X��싋�t��׏��i�F�m�ǑΉ��^�E����{�ݓ����ҁj(QP001P067)�̈�����s���B
            case QkanConstants.CLAIM_STYLE_FORMAT_6_7:
                new QP001P067_201204().doPrint(writer, printParam);
                break;

            // �{�݃T�[�r�X����싋�t��׏��i��앟���{�݁j(QP001P08)�̈�����s���B
            case QkanConstants.CLAIM_STYLE_FORMAT_8:
                new QP001P08_201204().doPrint(writer, printParam);
                break;

            // �ݑ�T�[�r�X��싋�t��׏��i���V�l�ی��{�݁j(QP001P09)�̈�����s���B
            case QkanConstants.CLAIM_STYLE_FORMAT_9:
                new QP001P09_201204().doPrint(writer, printParam);
                break;

            // �{�݃T�[�r�X����싋�t��׏��i���×{�{�݁j(QP001P10)�̈�����s���B
            case QkanConstants.CLAIM_STYLE_FORMAT_10:
                new QP001P10_201204().doPrint(writer, printParam);
                break;

            }
        }
        
        return true;
        
    }
    
    
    
    
    // �������[�h���u07�v�̏ꍇ �����p�҈ꗗ(���p�Ҍ������)
    private boolean doPrintMode07(VRHashMap printParam, VRMap param) throws Exception {
        
        // ���p�ҕ��S�������҃X�L�b�v�@�\�ϐ��̏�����
        patientClaimPdfCount = 0;
        patientClaimPdfEmptyCount = 0;
        noPatientSelfList = new VRArrayList();
        
        // patientData�̌��������[�v����B
        for (int i = 0; i < patientList.size(); i++) {
            VRMap map = (VRMap) patientList.getData(i);

            // ���I���̏ꍇ�������X�L�b�v����B
            if (!isCheckedRow(map)) {
                continue;
            }

            // �����N��
            Date claimDate = ACCastUtilities.toDate(map.get("CLAIM_DATE"));
            // ���p��ID�ޔ�p��int patient_id �𐶐����ApatientData�� KEY : PATIENT_ID ��ݒ肷��B
            int patient_id = ACCastUtilities.toInt(VRBindPathParser.get("PATIENT_ID", map));
            // �l���ԍ����擾����B
            int claimStyleType = ACCastUtilities.toInt(VRBindPathParser.get("CLAIM_STYLE_TYPE", map), 0);

            // �����ڍ׏����擾���AVRArrayList claimList �Ɋi�[����B
            StringBuilder sb = getClaimDetailWhere(map, patient_id, claimDate);

            VRList claimList = QkanCommon.getClaimDetailCustom(dbm, claimDate, sb.toString());

            if ((claimList == null) || (claimList.size() == 0)) {
                VRLogger.warning("�W�v�f�[�^�擾�G���[:" + sb.toString());
                continue;
            }

            // [2015�N1������][Shinobu Hitaka] 2015/02/04 add start ����54�ǉ��ɔ����l���C���ɑΉ�
            // �P�s�ڂ̑Ώ۔N���Ń}�X�^�擾���Ă���̂ňقȂ�Ώ۔N���ɂȂ�����Ď擾����
            Date targetDate = ACCastUtilities.toDate(map.get("TARGET_DATE"));
            if (ACDateUtilities.compareOnDay(manager.getTargetDate(), targetDate) != 0){
                manager = new QP001Manager(dbm, targetDate);
            }
            // [2015�N1������][Shinobu Hitaka] 2015/02/04 add end   ����54�ǉ��ɔ����l���C���ɑΉ�
            
            // �����Ώۓ�
            printParam.put("SEIKYU_DATE", claimDate);
            // ���[�f�[�^
            printParam.put("STYLE_DATA", claimList);
            // ���p�ҏ��
            VRMap patient = (VRLinkedHashMap) QkanCommon.getPatientInfo(dbm, patient_id).get(0);
            printParam.put("PATIENT", patient);
            // �l���ԍ�
            printParam.put("CLAIM_STYLE_TYPE", String.valueOf(claimStyleType));

            doPrintAffair07Selecter(patient, claimList, param, claimDate,
                    ACCastUtilities.toDate(map.get("TARGET_DATE")));
        }
        
        
        // �Ĉ���������s�����𔻒�
        boolean isAllPrintRetry = false;
        // ���p�ҕ��S�z�̑��݂��Ȃ����[�݈̂�����悤�Ƃ����ꍇ�͊m�F
        if (patientClaimPdfEmptyCount >= patientClaimPdfCount) {
            int msgID = QkanMessageList.getInstance().QU001_WARNING_OF_EMPTY_DATA_REPORT_ONLY();
            // �u�͂��v���I�����ꂽ�ꍇ
            if (msgID == ACMessageBox.RESULT_YES) {
                // �S���[���
                isAllPrintRetry = true;
            } else {
                // �u�������v���I�����ꂽ�ꍇ
                return false;
            }

        }
        // ���p�ҕ��S�z�̑��݂��Ȃ����[���܂܂�Ă���ꍇ
        // �S�Ă����p�ҕ��S�z�Ȃ��̒��[�ł͂Ȃ� ���� 1���ȏ㗘�p�ҕ��S�z�Ȃ��̒��[�����݂���ꍇ
        if (patientClaimPdfEmptyCount < patientClaimPdfCount
                && patientClaimPdfEmptyCount >= 1) {
            int msgID = QkanMessageList.getInstance().QP001_WARNING_OF_CUSTOM_PRINT();
            // ���b�Z�[�W�I���ɂ�镪��
            if (msgID == ACMessageBox.RESULT_YES) {
                // �S���[���
                isAllPrintRetry = true;
            } else if (msgID == ACMessageBox.RESULT_NO) {
                // ���̂܂܈��
                // ���p�ҕ��S�������̂��͈̂���ς݂Ƃ��Ȃ�
                for (int i = 0; i < noPatientSelfList.size(); i++) {
                    // ���p�ҕ��S�������̗��p�҂����
                    Integer noPatientSelfId = ACCastUtilities.toInteger(
                            noPatientSelfList.get(i), new Integer(-1));
                    // ���X�g�����[�v����
                    for (int j = 0; j < patientList.size(); j++) {
                        VRMap map = (VRMap) patientList.getData(j);
                        if (noPatientSelfId.equals(ACCastUtilities
                                .toInteger(map.getData("PATIENT_ID"),
                                        new Integer(0)))) {
                            // ����ΏۊO�Ȃ̂ň�����Ă��Ȃ����Ƃ��Ĉ���
                            map.setData("CHOISE", new Boolean(false));
                            break;
                        }
                    }
                }
            } else {
                // �L�����Z���{�^���������͈�����Ȃ�
                return false;
            }
        }

        // �Ĉ���������s���ꍇ
        if (isAllPrintRetry) {
            // �S�Ă�������邽�ߍĐ���
            ACChotarouXMLWriter newWriter = new ACChotarouXMLWriter();
            // writer���Đݒ�
            setWriter(newWriter);
            // ������e�̕ҏW�J�n��錾
            newWriter.beginPrintEdit();
            // setWriter(null);
            // �X�L�b�v�֎~
            setSkipEmptyPatientClaim(false);
            // ���p�Ҍ����������f�[�^�̍Đ���
            buildPatientClaim(patientList, param);
            // ������
            setSkipEmptyPatientClaim(true);
        }
        
        return true;

    }
    
    
    
    // �u08�v�̏ꍇ �����p�҈ꗗ(��싋�t��׏����)
    private boolean doPrintMode08(VRHashMap printParam) throws Exception {
        
        // ��싋�t���������p
        Map<String, QP001Style1> style1Sorter = new TreeMap<String, QP001Style1>();
        
// 2016/7/11 [Yoichiro Kamei] add - begin �������ƑΉ�
        // ��싋�t������i�l���P�|�Q�j����p
        Map<String, QP001Style1> style1_2Sorter = new TreeMap<String, QP001Style1>();
// 2016/7/11 [Yoichiro Kamei] add - end
        
        // patientData�̌��������[�v����B
        for (int i = 0; i < patientList.size(); i++) {
            VRMap map = (VRMap) patientList.getData(i);

            // ���I���̏ꍇ�������X�L�b�v����B
            if (!isCheckedRow(map)) {
                continue;
            }

            // �����N��
            Date claimDate = ACCastUtilities.toDate(map.get("CLAIM_DATE"));
            // ���p��ID�ޔ�p��int patient_id �𐶐����ApatientData�� KEY : PATIENT_ID ��ݒ肷��B
            int patient_id = ACCastUtilities.toInt(VRBindPathParser.get("PATIENT_ID", map));

            // �����ڍ׏����擾���AVRArrayList claimList �Ɋi�[����B
            StringBuilder sb = getClaimDetailWhere(map, patient_id, claimDate);

            VRList claimList = QkanCommon.getClaimDetailCustom(dbm, claimDate, sb.toString());

            if ((claimList == null) || (claimList.size() == 0)) {
                VRLogger.warning("�W�v�f�[�^�擾�G���[:" + sb.toString());
                continue;
            }
            
            // [2015�N1������][Shinobu Hitaka] 2014/12/11 add start ����54�ǉ��ɔ����l���C���ɑΉ�
            // �P�s�ڂ̑Ώ۔N���Ń}�X�^�擾���Ă���̂ňقȂ�Ώ۔N���ɂȂ�����Ď擾����
            Date targetDate = ACCastUtilities.toDate(map.get("TARGET_DATE"));
            if (ACDateUtilities.compareOnDay(manager.getTargetDate(), targetDate) != 0){
                manager = new QP001Manager(dbm, targetDate);
            }
            // [2015�N1������][Shinobu Hitaka] 2014/12/11 add end   ����54�ǉ��ɔ����l���C���ɑΉ�
            
            
            
            
            // ��싋�t�����(QP00102)�̃f�[�^��ݒ肷��B
            String style1Target = QP001Style1.getSerialId(claimList);
            
// 2016/7/11 [Yoichiro Kamei] add - begin �������ƑΉ�
            //�������ƑΏۗp�̐����ɕ�����
            VRList claimListTmp = new VRArrayList();
            VRList claimListSogo = new VRArrayList();
            for (int k = 0; k < claimList.size(); k++) {
            	VRMap row = (VRMap)claimList.get(k);
            	int claimStypeType = ACCastUtilities.toInt(row.get("CLAIM_STYLE_TYPE"), 0);
            	if (QkanConstants.CLAIM_STYLE_BILL_FOR_PATIENT == claimStypeType ||
            		QkanConstants.CLAIM_STYLE_BENEFIT_MANAGEMENT == claimStypeType) {
            		// ���p�Ҍ��������E���t�Ǘ��[�̃f�[�^�͕s�v�Ȃ̂ŃX�L�b�v
            		continue;
            	}
            	if (QkanConstants.CLAIM_STYLE_FORMAT_2_3 == claimStypeType) {
            		claimListSogo.add(row);
            	} else {
            		claimListTmp.add(row);
            	}
            }
            claimList = claimListTmp; //�������Ƃ���������
            
// 2016/7/11 [Yoichiro Kamei] add - end
// 2016/7/11 [Yoichiro Kamei] mod - begin �������ƑΉ�
//            // ���ɐݒ肵�Ă���ꍇ
//            if (style1Sorter.containsKey(style1Target)) {
//                ((QP001Style1) style1Sorter.get(style1Target))
//                        .parse(claimList);
//            } else {
//                QP001Style1 style1 = new QP001Style1(manager);
//                style1.parse(claimList);
//                style1Sorter.put(style1Target, style1);
//            }
            if (claimList.size() > 0) {
                // ���ɐݒ肵�Ă���ꍇ
                if (style1Sorter.containsKey(style1Target)) {
                    ((QP001Style1) style1Sorter.get(style1Target))
                            .parse(claimList);
                } else {
                    QP001Style1 style1 = new QP001Style1(QkanConstants.CLAIM_STYLE_BENEFIT_BILL, manager);
                    style1.parse(claimList);
                    style1Sorter.put(style1Target, style1);
                }
            }
            
            // �l���P�|�Q�̕�
            if (claimListSogo.size() > 0) {
                if (style1_2Sorter.containsKey(style1Target)) {
                    ((QP001Style1) style1_2Sorter.get(style1Target))
                            .parse(claimListSogo);
                } else {
                    QP001Style1 style1 = new QP001Style1(QkanConstants.CLAIM_STYLE_BENEFIT_BILL_2, manager);
                    style1.parse(claimListSogo);
                    style1_2Sorter.put(style1Target, style1);
                }
            }
// 2016/7/11 [Yoichiro Kamei] mod - end
        }
        
        
        
        Iterator<String> it = style1Sorter.keySet().iterator();
        while (it.hasNext()) {
            // ���[�f�[�^
            printParam.put("STYLE_DATA", style1Sorter.get(it.next()).getRecords());
            printParam.put("SEIKYU_DATE", printDate);
            
            new QP001P01_201204().doPrint(writer, printParam);
        }
        
// 2016/7/11 [Yoichiro Kamei] add - begin �������ƑΉ�
        it = style1_2Sorter.keySet().iterator();
        while (it.hasNext()) {
            // ���[�f�[�^
            printParam.put("STYLE_DATA", style1_2Sorter.get(it.next()).getRecords());
            printParam.put("SEIKYU_DATE", printDate);
            
            new QP001P012_201504().doPrint(writer, printParam);
        }
// 2016/7/11 [Yoichiro Kamei] add - end
        
        return true;
    }
    
    
    
    // �񋟓��e���擾����SQL����Where��쐬
    private StringBuilder getClaimDetailWhere(VRMap row, int patient_id, Date claimDate) throws Exception {
        
        StringBuilder sb = new StringBuilder();
        
        sb.append(" AND(CLAIM.CLAIM_DATE = '" + VRDateParser.format(claimDate, "yyyy/MM/dd") + "')");
        sb.append(" AND(CLAIM.TARGET_DATE = '" + VRDateParser.format(ACCastUtilities.toDate(row.get("TARGET_DATE")), "yyyy/MM/dd") + "')");
        // ���p��ID���w�肵�Ă���Ȃ�Γ���̗��p�҂̂݁B���w��Ȃ�ΑS���p�҂�ΏۂƂ���B
        sb.append(" AND(CLAIM.PATIENT_ID = " + patient_id + ")");

        // �ی��Ҕԍ��A��ی��Ҕԍ��̌���������ǉ�����B
        sb.append(" AND(CLAIM.INSURER_ID = '" + VRBindPathParser.get("INSURER_ID", row) + "')");

        if (VRBindPathParser.get("INSURED_ID", row) != null) {
            sb.append(" AND(CLAIM.INSURED_ID = '" + VRBindPathParser.get("INSURED_ID", row) + "')");
        } else {
            sb.append(" AND(CLAIM.INSURED_ID = '')");
        }

        sb.append(" AND(CLAIM.PROVIDER_ID = '" + QkanSystemInformation.getInstance().getLoginProviderID() + "')");
        
        return sb;
    }
    
    
    
    // �Ώۍs�Ƀ`�F�b�N�����Ă��邩���肷��
    private boolean isCheckedRow(VRMap row) throws Exception {
        return "TRUE".equalsIgnoreCase(ACCastUtilities.toString(VRBindPathParser.get("CHOISE", row)));
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

    // [ID:0000612][Shin Fujihara] 2010/11 add begin 2010�N�x�Ή�
    private void doPrintAffair07Selecter(VRMap patient, VRList claimList,
            VRMap printSetting, Date claimDate, Date targetDate)
            throws Exception {

        doPrintAffair07(patient, claimList, printSetting, claimDate, targetDate);
        /*
         * FIXME [0000612] if (printSetting.get("PROVIDER_NAMES") == null) {
         * doPrintAffair07(patient, claimList, printSetting, claimDate,
         * targetDate); } else { doPrintAffair07Service(patient, claimList,
         * printSetting, claimDate, targetDate); }
         */
    }

    // [ID:0000612][Shin Fujihara] 2010/11 add end 2010�N�x�Ή�

    /**
     * ���p�Ҍ��������@����̐ݒ���s���B
     * 
     * @param writer
     * @param patient
     * @param claimList
     * @param providerMap
     * @param printSetting
     * @throws Exception
     */
    private void doPrintAffair07(VRMap patient, VRList claimList, VRMap printSetting, Date claimDate, Date targetDate) throws Exception {
        
        VRMap printParam = new VRHashMap();
        // SQL���s�p�Ƀf�[�^���쐬����B
        VRMap sqlParam = new VRHashMap();
        sqlParam.put("PATIENT_ID", patient.get("PATIENT_ID"));
        sqlParam.put("CLAIM_DATE", VRDateParser.format(claimDate, "yyyy/MM/dd"));
        sqlParam.put("PROVIDER_ID", QkanSystemInformation.getInstance().getLoginProviderID());
        // �P���ɍi�荞�߂�悤�Ώ۔N���������������ɒǉ�
        sqlParam.put("TARGET_DATE", VRDateParser.format(targetDate, "yyyy/MM/dd"));

        // SQL���𔭍s���A�f�[�^���擾����B
        VRList detailList = dbm.executeQuery(getSQL_GET_CLAIM_DETAIL_PATIENT(sqlParam));
        VRMap detail = null;
        if (detailList.size() > 0) {
            detail = (VRMap) detailList.get(0);
        }

        // �f�[�^���p�[�X���A���p�\�t�H�[�}�b�g�𓾂�
        // [���p�Ҍ����������E�̎����@�ڍהőΉ�] fujihara edit start
        // ���[����X�L�b�v����p
        // ���p��
        int riyousya = 0;

        VRMap useClaimMap = null;
        switch (ACCastUtilities.toInt(printSetting.get("DETAILS_CHECK"), 0)) {
        // �ڍהŏo�͂Ƀ`�F�b�N�Ȃ�
        case 0:
            QP001RecordUserClaim userClaim = new QP001RecordUserClaim();
            // [2014�N�v�]][Shinobu Hitaka] 2015/04/15 add begin ���p�ҕ��S�z0�~������\�ɂ���
            userClaim.setZeroPrint(ACCastUtilities.toInt(printSetting.get("ZERO_CHECK"), 0));
            // [2014�N�v�]][Shinobu Hitaka] 2015/04/15 add end
            userClaim.parse(claimList, manager);
            // ���p�Ҏx�������z���擾
            riyousya = userClaim.getClaimTotal();
            useClaimMap = userClaim.getRecord();
            // ���t��
            useClaimMap.put("FUTAN_WARIAI", calc_futanwariai(userClaim.get_kyufuritsu(), userClaim.get_dokujiFlag()));
            break;
        // �ڍהŏo�͂Ƀ`�F�b�N����
        case 1:
            QP001RecordUserClaimDetails userClaimDetails = new QP001RecordUserClaimDetails();
            // [2014�N�v�]][Shinobu Hitaka] 2015/04/15 add begin ���p�ҕ��S�z0�~������\�ɂ���
            userClaimDetails.setZeroPrint(ACCastUtilities.toInt(printSetting.get("ZERO_CHECK"), 0));
            // [2014�N�v�]][Shinobu Hitaka] 2015/04/15 add end
            userClaimDetails.parse(claimList, manager);
            // ���p�Ҏx�������z���擾
            riyousya = userClaimDetails.getClaimTotal();
            useClaimMap = userClaimDetails.getRecord();
            // ���t��
            useClaimMap.put("FUTAN_WARIAI", calc_futanwariai(userClaimDetails.get_kyufuritsu(), userClaimDetails.get_dokujiFlag()));
            break;
        }

        if (ACTextUtilities.isNullText(useClaimMap.get("TARGET_DATE"))) {
            useClaimMap.put("TARGET_DATE", targetDate);
        }

        // ����N���X�p�ɓ]������f�[�^��ݒ肷��B
        printParam.put("STYLE_DATA", useClaimMap);

        if (detail != null) {
            printParam.put("CLAIM_PATIENT_DETAIL", detail);
            riyousya += ACCastUtilities.toInt(detail.get("SELF_PAY_NO1"), 0);
            riyousya += ACCastUtilities.toInt(detail.get("SELF_PAY_NO2"), 0);
            riyousya += ACCastUtilities.toInt(detail.get("SELF_PAY_NO3"), 0);
            riyousya += ACCastUtilities.toInt(detail.get("OTHER_PAY_NO1"), 0);
            riyousya += ACCastUtilities.toInt(detail.get("OTHER_PAY_NO2"), 0);
            riyousya += ACCastUtilities.toInt(detail.get("OTHER_PAY_NO3"), 0);
            riyousya += ACCastUtilities.toInt(detail.get("OTHER_PAY_NO4"), 0);
            riyousya += ACCastUtilities.toInt(detail.get("OTHER_PAY_NO5"), 0);
            riyousya += ACCastUtilities.toInt(detail.get("OTHER_PAY_NO6"), 0);
        }

        // ����Ώۂ̒��[��
        patientClaimPdfCount++;

        if ((riyousya) == 0) {
            // ����X�L�b�v�Ώۂ̒��[��
            patientClaimPdfEmptyCount++;
            // �X�L�b�v��������Ă���ꍇ�̂�
            if (isSkipEmptyPatientClaim()) {
                // ���݂̏����Ώۂƃ��C���̃��X�g��ˍ�����
                int patientId = ACCastUtilities.toInt(
                        patient.getData("PATIENT_ID"), -1);
                // ���p�ҕ��S�̔������Ȃ����p�҂Ƃ��ă��X�g�o�^
                if (patientId != -1) {
                    noPatientSelfList.add(new Integer(patientId));
                }
                return;
            }
        }

        //

        printParam.put("PATIENT_NAME", QkanCommon.toFullName(
                patient.get("PATIENT_FAMILY_NAME"),
                patient.get("PATIENT_FIRST_NAME")));
        printParam.put("SEIKYU_DATE", claimDate);
        printParam.put("PROVIDER", providerMap.get(QkanSystemInformation
                .getInstance().getLoginProviderID()));
        printParam.put("PRINT_SETTING", printSetting);
        // �l���ԍ�����I�v�V����
        printParam.put("YOSHIKI_BANGO", yoshikiBango);

        // ������x�����Ə�
        VRList careProvider = dbm
                .executeQuery(getSQL_GET_CARE_PROVIDER(sqlParam));
        if (careProvider != null && careProvider.size() > 0) {
            String careProviderId = String
                    .valueOf(((VRMap) careProvider.get(0)).get("PROVIDER_ID"));
            printParam.put("CARE_PROVIDER", providerMap.get(careProviderId));
        }

        boolean isPrintableInnerTax = false;
        final Date innerTaxStart = ACCastUtilities.toDate("2007/04/01", null);
        if (ACDateUtilities.compareOnDay(innerTaxStart, claimDate) <= 0) {
            isPrintableInnerTax = true;
        }

        // �啝���C
        // �o�͂��钠�[�𔻕�
        int target_radio = ACCastUtilities.toInt(
                printSetting.get("TARGET_RADIO"), 0);

        // �������Ƀ`�F�b�N����
        if ((target_radio & 1) == 1) {
            // �U����Ȃ�
            if (ACCastUtilities.toInt(printSetting.get("PRINT_CHECK"), 0) == 0) {
                if (isPrintableInnerTax) {
                    if (ACCastUtilities.toInt(
                            printSetting.get("DETAILS_CHECK"), 0) == 0) {
                        QP001P211 qp00123 = new QP001P211();
                        qp00123.doPrint(writer, printParam);
                    } else {
                        QP001P221 qp00123_1 = new QP001P221();
                        qp00123_1.doPrint(writer, printParam);
                    }
                } else {
                    // [Masahiko Higuchi] edit - start �ڍהłɊւ��Ă͂�������łȂ������l�̈�
                    if (ACCastUtilities.toInt(
                            printSetting.get("DETAILS_CHECK"), 0) == 0) {
                        QP001P201 qp00115 = new QP001P201();
                        qp00115.doPrint(writer, printParam);
                    } else {
                        QP001P221 qp00123_1 = new QP001P221();
                        qp00123_1.doPrint(writer, printParam);
                    }
                    // [Masahiko Higuchi] edit - end
                }
                // �U����Ȃ�
            } else {
                if (isPrintableInnerTax) {
                    if (ACCastUtilities.toInt(
                            printSetting.get("DETAILS_CHECK"), 0) == 0) {
                        QP001P212 qp00124 = new QP001P212();
                        qp00124.doPrint(writer, printParam);
                    } else {
                        QP001P222 qp00124_1 = new QP001P222();
                        qp00124_1.doPrint(writer, printParam);
                    }
                } else {
                    // [Masahiko Higuchi] edit - start �ڍהłɊւ��Ă͂�������łȂ������l�̈�
                    if (ACCastUtilities.toInt(
                            printSetting.get("DETAILS_CHECK"), 0) == 0) {
                        QP001P202 qp00116 = new QP001P202();
                        qp00116.doPrint(writer, printParam);
                    } else {
                        QP001P222 qp00124_1 = new QP001P222();
                        qp00124_1.doPrint(writer, printParam);
                    }
                    // [Masahiko Higuchi] edit - end
                }
            }
        }

        // �̎����Ƀ`�F�b�N����
        if ((target_radio & 2) == 2) {
            // ��Ô�T���Ή��łȂ�
            if (ACCastUtilities.toInt(printSetting.get("STYLE_CHECK"), 0) == 0) {
                // �U����Ȃ�
                if (ACCastUtilities.toInt(printSetting.get("PRINT_CHECK"), 0) == 0) {
                    if (isPrintableInnerTax) {
                        if (ACCastUtilities.toInt(
                                printSetting.get("DETAILS_CHECK"), 0) == 0) {
                            QP001P213 qp00125 = new QP001P213();
                            qp00125.doPrint(writer, printParam);
                        } else {
                            QP001P223 qp00125_1 = new QP001P223();
                            qp00125_1.doPrint(writer, printParam);
                        }
                    } else {
                        // [Masahiko Higuchi] edit - start �ڍהłɊւ��Ă͂�������łȂ������l�̈�
                        if (ACCastUtilities.toInt(
                                printSetting.get("DETAILS_CHECK"), 0) == 0) {
                            QP001P203 qp00117 = new QP001P203();
                            qp00117.doPrint(writer, printParam);
                        } else {
                            QP001P223 qp00125_1 = new QP001P223();
                            qp00125_1.doPrint(writer, printParam);
                        }
                        // [Masahiko Higuchi] edit - end
                    }
                    // �U����L
                } else {
                    if (isPrintableInnerTax) {
                        if (ACCastUtilities.toInt(
                                printSetting.get("DETAILS_CHECK"), 0) == 0) {
                            QP001P214 qp00126 = new QP001P214();
                            qp00126.doPrint(writer, printParam);
                        } else {
                            QP001P224 qp00126_1 = new QP001P224();
                            qp00126_1.doPrint(writer, printParam);
                        }
                    } else {
                        // [Masahiko Higuchi] edit - start �ڍהłɊւ��Ă͂�������łȂ������l�̈�
                        if (ACCastUtilities.toInt(
                                printSetting.get("DETAILS_CHECK"), 0) == 0) {
                            QP001P204 qp00118 = new QP001P204();
                            qp00118.doPrint(writer, printParam);
                        } else {
                            QP001P224 qp00126_1 = new QP001P224();
                            qp00126_1.doPrint(writer, printParam);
                        }
                        // [Masahiko Higuchi] edit - end
                    }
                }
                // ��Ô�T���Ή��ł���
            } else {
                if (isPrintableInnerTax) {
                    if (ACCastUtilities.toInt(
                            printSetting.get("DETAILS_CHECK"), 0) == 0) {
                        QP001P215 qp00127 = new QP001P215();
                        qp00127.doPrint(writer, printParam);
                    } else {
                        QP001P225 qp00127_1 = new QP001P225();
                        qp00127_1.doPrint(writer, printParam);
                    }
                } else {
                    // [Masahiko Higuchi] edit - start �ڍהłɊւ��Ă͂�������łȂ������l�̈�
                    if (ACCastUtilities.toInt(
                            printSetting.get("DETAILS_CHECK"), 0) == 0) {
                        QP001P205 qp00119 = new QP001P205();
                        qp00119.doPrint(writer, printParam);
                    } else {
                        QP001P225 qp00127_1 = new QP001P225();
                        qp00127_1.doPrint(writer, printParam);
                    }
                    // [Masahiko Higuchi] edit - end
                }
            }
        }

    }

    // [ID:0000612][Shin Fujihara] 2010/11 add begin 2010�N�x�Ή�
    private void doPrintAffair07Service(VRMap patient, VRList claimList,
            VRMap printSetting, Date claimDate, Date targetDate)
            throws Exception {

        // ------ �󎚂ɕK�v�ȃf�[�^�̏���

        // SQL���s�p�Ƀf�[�^���쐬����B
        VRMap sqlParam = new VRHashMap();
        sqlParam.put("PATIENT_ID", patient.get("PATIENT_ID"));
        sqlParam.put("CLAIM_DATE", VRDateParser.format(claimDate, "yyyy/MM/dd"));
        sqlParam.put("PROVIDER_ID", QkanSystemInformation.getInstance()
                .getLoginProviderID());
        sqlParam.put("TARGET_DATE",
                VRDateParser.format(targetDate, "yyyy/MM/dd"));

        // SQL���𔭍s���A���p�Ҍ��������ʂ̃f�[�^���擾�B���[�т���ރR�[�h���L�[��HashMap�Ɋi�[
        VRMap detailMap = new VRHashMap();
        ACBindUtilities.setMapFromArray(
                dbm.executeQuery(getSQL_GET_CLAIM_DETAIL_PATIENT(sqlParam)),
                detailMap, "SERVICE_CODE_KIND");

        VRMap printParam = new VRHashMap();
        printParam.put("PATIENT_NAME", QkanCommon.toFullName(
                patient.get("PATIENT_FAMILY_NAME"),
                patient.get("PATIENT_FIRST_NAME")));
        printParam.put("SEIKYU_DATE", claimDate);
        printParam.put("PROVIDER", providerMap.get(QkanSystemInformation
                .getInstance().getLoginProviderID()));
        printParam.put("PRINT_SETTING", printSetting);
        // �l���ԍ�����I�v�V����
        printParam.put("YOSHIKI_BANGO", yoshikiBango);

        // ������x�����Ə�
        VRList careProvider = dbm
                .executeQuery(getSQL_GET_CARE_PROVIDER(sqlParam));
        if (careProvider != null && careProvider.size() > 0) {
            String careProviderId = String
                    .valueOf(((VRMap) careProvider.get(0)).get("PROVIDER_ID"));
            printParam.put("CARE_PROVIDER", providerMap.get(careProviderId));
        }

        boolean isPrintableInnerTax = false;
        final Date innerTaxStart = ACCastUtilities.toDate("2007/04/01", null);
        if (ACDateUtilities.compareOnDay(innerTaxStart, claimDate) <= 0) {
            isPrintableInnerTax = true;
        }

        // ���O�C�����Ə������擾
        String defaultProviderName = ACCastUtilities
                .toString(((VRMap) printParam.get("PROVIDER"))
                        .get("PROVIDER_NAME"));

        // �ϊ����鎖�Ə������擾
        VRMap providerNames = new VRHashMap();
        ACBindUtilities.setMapFromArray(
                (VRList) printSetting.get("PROVIDER_NAMES"), providerNames,
                "SERVICE_CODE_KIND");

        // ------ �󎚒��[���ƂɃf�[�^�𕪊�

        Map claimMap = new TreeMap();
        VRMap baseMap = new VRHashMap();
        VRMap diagnosisMap = new VRHashMap();
        VRMap nursingMap = new VRHashMap();
        VRMap claim = null;

        for (int i = 0; i < claimList.size(); i++) {
            claim = (VRMap) claimList.get(i);

            // �L�[�̑��݃`�F�b�N
            if (!claim.containsKey("CATEGORY_NO")) {
                continue;
            }

            switch (ACCastUtilities.toInt(claim.get("CATEGORY_NO"), 0)) {
            // ��{��񃌃R�[�h
            case 2:
                baseMap.put(claim.get("201001"), claim);
                break;

            // ���׏�񃌃R�[�h
            case 3:
                pushClaimMap(claimMap, claim.get("301001"),
                        claim.get("301007"), claim);

                // ����f�Ô��񃌃R�[�h
            case 5:
                // ����f�Ô��񃌃R�[�h�����ԍ���99�̏ꍇ�̂ݗL��
                if ("99".equals(ACCastUtilities.toString(claim.get("501007"),
                        ""))) {
                    diagnosisMap.put(claim.get("501001"), claim);
                }
                break;

            // �W�v��񃌃R�[�h
            case 7:
                pushClaimMap(claimMap, claim.get("701001"),
                        claim.get("701007"), claim);
                break;

            // ��������҉��T�[�r�X��p��񃌃R�[�h
            case 8:
                // pushClaimMap(claimMap, claim.get("801001"),
                // claim.get("801008"), claim);
                VRList nursingList = null;
                if (nursingMap.containsKey(claim.get("801001"))) {
                    nursingList = (VRList) nursingMap.get(claim.get("801001"));
                } else {
                    nursingList = new VRArrayList();
                    nursingMap.put(claim.get("801001"), nursingList);
                }
                nursingList.add(claim);
                break;

            // �Љ���@�l�y���z��񃌃R�[�h
            case 9:
                pushClaimMap(claimMap, claim.get("901001"),
                        claim.get("901008"), claim);
                break;
            }
        }

        // �T�[�r�X��ނ��ƂɃ��[�v���Ȃ炪�Ăяo��
        Iterator it = claimMap.keySet().iterator();
        while (it.hasNext()) {
            VRMap detail = null;

            String key = it.next().toString();
            VRList list = (VRList) claimMap.get(key);

            // �L�[����������ʔԍ��ƃT�[�r�X��ރR�[�h���擾
            String[] keys = key.split("-");

            // ��{�����擾
            if (baseMap.containsKey(keys[0])) {
                list.add(baseMap.get(keys[0]));
            }

            // ����f�Ô�����擾
            if (diagnosisMap.containsKey(keys[0])) {
                list.add(diagnosisMap.get(keys[0]));
            }

            // �H��E���Z��̏����擾
            if (nursingMap.containsKey(keys[0])) {
                list.addAll((VRList) nursingMap.get(keys[0]));
            }

            // �ʂ̗��p�Ҍ��������ݒ���擾
            if (detailMap.containsKey(keys[1])) {
                detail = (VRMap) detailMap.get(keys[1]);
            }

            // �ϊ��Ώۂ̎��Ə����̂����݂��邩�m�F
            if (providerNames.containsKey(new Integer(keys[1]))) {
                VRMap convertProviderName = (VRMap) providerNames
                        .get(new Integer(keys[1]));
                ((VRMap) printParam.get("PROVIDER")).put("PROVIDER_NAME",
                        convertProviderName.get("PROVIDER_NAME"));
            } else {
                ((VRMap) printParam.get("PROVIDER")).put("PROVIDER_NAME",
                        defaultProviderName);
            }

            // �ϓ����ڂ�������
            printParam.put("STYLE_DATA", null);
            printParam.put("CLAIM_PATIENT_DETAIL", null);
            doPrintAffair07ServiceDetail(patient, list, printSetting,
                    targetDate, detail, printParam, isPrintableInnerTax);
        }

    }

    private void pushClaimMap(Map claimMap, Object key1, Object key2, VRMap map)
            throws Exception {
        VRList list = null;
        String key = String.valueOf(key1) + "-" + String.valueOf(key2);
        if (claimMap.containsKey(key)) {
            list = (VRList) claimMap.get(key);
        } else {
            list = new VRArrayList();
            claimMap.put(key, list);
        }
        list.add(map);
    }

    private void doPrintAffair07ServiceDetail(VRMap patient, VRList claimList,
            VRMap printSetting, Date targetDate, VRMap detail,
            VRMap printParam, boolean isPrintableInnerTax) throws Exception {

        // �f�[�^���p�[�X���A���p�\�t�H�[�}�b�g�𓾂�
        // [���p�Ҍ����������E�̎����@�ڍהőΉ�] fujihara edit start
        // ���[����X�L�b�v����p
        // ���p��
        int riyousya = 0;

        VRMap useClaimMap = null;
        switch (ACCastUtilities.toInt(printSetting.get("DETAILS_CHECK"), 0)) {
        // �ڍהŏo�͂Ƀ`�F�b�N�Ȃ�
        case 0:
            QP001RecordUserClaim userClaim = new QP001RecordUserClaim();
            // [2014�N�v�]][Shinobu Hitaka] 2015/04/15 add begin ���p�ҕ��S�z0�~������\�ɂ���
            userClaim.setZeroPrint(ACCastUtilities.toInt(printSetting.get("ZERO_CHECK"), 0));
            // [2014�N�v�]][Shinobu Hitaka] 2015/04/15 add end
            userClaim.parse(claimList, manager);
            // ���p�Ҏx�������z���擾
            riyousya = userClaim.getClaimTotal();
            useClaimMap = userClaim.getRecord();
            // ���t��
            useClaimMap.put("FUTAN_WARIAI", calc_futanwariai(userClaim.get_kyufuritsu(), userClaim.get_dokujiFlag()));
            break;
        // �ڍהŏo�͂Ƀ`�F�b�N����
        case 1:
            QP001RecordUserClaimDetails userClaimDetails = new QP001RecordUserClaimDetails();
            // [2014�N�v�]][Shinobu Hitaka] 2015/04/15 add begin ���p�ҕ��S�z0�~������\�ɂ���
            userClaimDetails.setZeroPrint(ACCastUtilities.toInt(printSetting.get("ZERO_CHECK"), 0));
            // [2014�N�v�]][Shinobu Hitaka] 2015/04/15 add end
            userClaimDetails.parse(claimList, manager);
            // ���p�Ҏx�������z���擾
            riyousya = userClaimDetails.getClaimTotal();
            useClaimMap = userClaimDetails.getRecord();
            // ���t��
            useClaimMap.put("FUTAN_WARIAI", calc_futanwariai(userClaimDetails.get_kyufuritsu(), userClaimDetails.get_dokujiFlag()));
            break;
        }

        if (ACTextUtilities.isNullText(useClaimMap.get("TARGET_DATE"))) {
            useClaimMap.put("TARGET_DATE", targetDate);
        }

        // ����N���X�p�ɓ]������f�[�^��ݒ肷��B
        printParam.put("STYLE_DATA", useClaimMap);

        if (detail != null) {
            printParam.put("CLAIM_PATIENT_DETAIL", detail);
            riyousya += ACCastUtilities.toInt(detail.get("SELF_PAY_NO1"), 0);
            riyousya += ACCastUtilities.toInt(detail.get("SELF_PAY_NO2"), 0);
            riyousya += ACCastUtilities.toInt(detail.get("SELF_PAY_NO3"), 0);
            riyousya += ACCastUtilities.toInt(detail.get("OTHER_PAY_NO1"), 0);
            riyousya += ACCastUtilities.toInt(detail.get("OTHER_PAY_NO2"), 0);
            riyousya += ACCastUtilities.toInt(detail.get("OTHER_PAY_NO3"), 0);
            riyousya += ACCastUtilities.toInt(detail.get("OTHER_PAY_NO4"), 0);
            riyousya += ACCastUtilities.toInt(detail.get("OTHER_PAY_NO5"), 0);
            riyousya += ACCastUtilities.toInt(detail.get("OTHER_PAY_NO6"), 0);
        }

        // ����Ώۂ̒��[��
        patientClaimPdfCount++;

        if ((riyousya) == 0) {
            // ����X�L�b�v�Ώۂ̒��[��
            patientClaimPdfEmptyCount++;
            // �X�L�b�v��������Ă���ꍇ�̂�
            if (isSkipEmptyPatientClaim()) {
                // ���݂̏����Ώۂƃ��C���̃��X�g��ˍ�����
                int patientId = ACCastUtilities.toInt(
                        patient.getData("PATIENT_ID"), -1);
                // ���p�ҕ��S�̔������Ȃ����p�҂Ƃ��ă��X�g�o�^
                if (patientId != -1) {
                    noPatientSelfList.add(new Integer(patientId));
                }
                return;
            }
        }

        // �o�͂��钠�[�𔻕�
        int target_radio = ACCastUtilities.toInt(
                printSetting.get("TARGET_RADIO"), 0);

        // �������Ƀ`�F�b�N����
        if ((target_radio & 1) == 1) {
            // �U����Ȃ�
            if (ACCastUtilities.toInt(printSetting.get("PRINT_CHECK"), 0) == 0) {
                if (isPrintableInnerTax) {
                    if (ACCastUtilities.toInt(
                            printSetting.get("DETAILS_CHECK"), 0) == 0) {
                        QP001P211 qp00123 = new QP001P211();
                        qp00123.doPrint(writer, printParam);
                    } else {
                        QP001P221 qp00123_1 = new QP001P221();
                        qp00123_1.doPrint(writer, printParam);
                    }
                } else {
                    if (ACCastUtilities.toInt(
                            printSetting.get("DETAILS_CHECK"), 0) == 0) {
                        QP001P201 qp00115 = new QP001P201();
                        qp00115.doPrint(writer, printParam);
                    } else {
                        QP001P221 qp00123_1 = new QP001P221();
                        qp00123_1.doPrint(writer, printParam);
                    }
                }
                // �U����Ȃ�
            } else {
                if (isPrintableInnerTax) {
                    if (ACCastUtilities.toInt(
                            printSetting.get("DETAILS_CHECK"), 0) == 0) {
                        QP001P212 qp00124 = new QP001P212();
                        qp00124.doPrint(writer, printParam);
                    } else {
                        QP001P222 qp00124_1 = new QP001P222();
                        qp00124_1.doPrint(writer, printParam);
                    }
                } else {
                    if (ACCastUtilities.toInt(
                            printSetting.get("DETAILS_CHECK"), 0) == 0) {
                        QP001P202 qp00116 = new QP001P202();
                        qp00116.doPrint(writer, printParam);
                    } else {
                        QP001P222 qp00124_1 = new QP001P222();
                        qp00124_1.doPrint(writer, printParam);
                    }
                }
            }
        }

        // �̎����Ƀ`�F�b�N����
        if ((target_radio & 2) == 2) {
            // ��Ô�T���Ή��łȂ�
            if (ACCastUtilities.toInt(printSetting.get("STYLE_CHECK"), 0) == 0) {
                // �U����Ȃ�
                if (ACCastUtilities.toInt(printSetting.get("PRINT_CHECK"), 0) == 0) {
                    if (isPrintableInnerTax) {
                        if (ACCastUtilities.toInt(
                                printSetting.get("DETAILS_CHECK"), 0) == 0) {
                            QP001P213 qp00125 = new QP001P213();
                            qp00125.doPrint(writer, printParam);
                        } else {
                            QP001P223 qp00125_1 = new QP001P223();
                            qp00125_1.doPrint(writer, printParam);
                        }
                    } else {
                        if (ACCastUtilities.toInt(
                                printSetting.get("DETAILS_CHECK"), 0) == 0) {
                            QP001P203 qp00117 = new QP001P203();
                            qp00117.doPrint(writer, printParam);
                        } else {
                            QP001P223 qp00125_1 = new QP001P223();
                            qp00125_1.doPrint(writer, printParam);
                        }
                    }
                    // �U����L
                } else {
                    if (isPrintableInnerTax) {
                        if (ACCastUtilities.toInt(
                                printSetting.get("DETAILS_CHECK"), 0) == 0) {
                            QP001P214 qp00126 = new QP001P214();
                            qp00126.doPrint(writer, printParam);
                        } else {
                            QP001P224 qp00126_1 = new QP001P224();
                            qp00126_1.doPrint(writer, printParam);
                        }
                    } else {
                        if (ACCastUtilities.toInt(
                                printSetting.get("DETAILS_CHECK"), 0) == 0) {
                            QP001P204 qp00118 = new QP001P204();
                            qp00118.doPrint(writer, printParam);
                        } else {
                            QP001P224 qp00126_1 = new QP001P224();
                            qp00126_1.doPrint(writer, printParam);
                        }
                    }
                }
                // ��Ô�T���Ή��ł���
            } else {
                if (isPrintableInnerTax) {
                    if (ACCastUtilities.toInt(
                            printSetting.get("DETAILS_CHECK"), 0) == 0) {
                        QP001P215 qp00127 = new QP001P215();
                        qp00127.doPrint(writer, printParam);
                    } else {
                        QP001P225 qp00127_1 = new QP001P225();
                        qp00127_1.doPrint(writer, printParam);
                    }
                } else {
                    if (ACCastUtilities.toInt(
                            printSetting.get("DETAILS_CHECK"), 0) == 0) {
                        QP001P205 qp00119 = new QP001P205();
                        qp00119.doPrint(writer, printParam);
                    } else {
                        QP001P225 qp00127_1 = new QP001P225();
                        qp00127_1.doPrint(writer, printParam);
                    }
                }
            }
        }
    }

    // [ID:0000612][Shin Fujihara] 2010/11 add end 2010�N�x�Ή�

    /**
     * ���p�Ґ����@���p�ҕ��S�z�����擾���邽�߂�SQL���擾���܂��B
     * 
     * @param sqlParam
     * @return
     * @throws Exception
     */
    public String getSQL_GET_CLAIM_DETAIL_PATIENT(VRMap sqlParam)
            throws Exception {
        StringBuilder sb = new StringBuilder();
        sb.append(" SELECT");
        sb.append(" CLAIM.TARGET_DATE,");
        sb.append(" CLAIM_PATIENT_DETAIL.*");
        sb.append(" FROM");
        sb.append(" CLAIM,");
        sb.append(" CLAIM_PATIENT_DETAIL");
        sb.append(" WHERE");
        sb.append(" (CLAIM.CLAIM_ID = CLAIM_PATIENT_DETAIL.CLAIM_ID)");
        sb.append(" AND(CLAIM.CLAIM_STYLE_TYPE = 30101)");
        sb.append(" AND(CLAIM.CATEGORY_NO = 16)");

        sb.append(" AND(CLAIM.PATIENT_ID = " + sqlParam.get("PATIENT_ID") + ")");
        sb.append(" AND(CLAIM.CLAIM_DATE = '" + sqlParam.get("CLAIM_DATE")
                + "')");
        // �P���ɍi�荞�ނ��߁A������ǉ�
        sb.append(" AND(CLAIM.TARGET_DATE = '" + sqlParam.get("TARGET_DATE")
                + "')");

        sb.append(" AND(CLAIM.PROVIDER_ID = '" + sqlParam.get("PROVIDER_ID")
                + "')");

        return sb.toString();
    }

    /**
     * ���p�҂̋�����x�����Ə�ID���擾����B
     * 
     * @param sqlParam
     * @return
     * @throws Exception
     */
    public String getSQL_GET_CARE_PROVIDER(VRMap sqlParam) throws Exception {
        StringBuilder sb = new StringBuilder();

        // �����N���ł͂Ȃ��Ώ۔N���ŋ�����x�����Ə����擾����悤�ύX
        Date target = ACCastUtilities.toDate(sqlParam.get("TARGET_DATE"), null);

        sb.append(" SELECT PROVIDER_ID FROM PATIENT_NINTEI_HISTORY");
        sb.append(" WHERE");
        sb.append(" (PATIENT_ID = " + sqlParam.get("PATIENT_ID") + ")");
        if (target != null) {
// 2014/12/17 [Yoichiro Kamei] mod - begin �V�X�e���L�����ԑΉ�
//            sb.append(" AND(INSURE_VALID_START <= '"
            sb.append(" AND(SYSTEM_INSURE_VALID_START <= '"
// 2014/12/17 [Yoichiro Kamei] mod - end
                    + VRDateParser.format(
                            ACDateUtilities.toLastDayOfMonth(target),
                            "yyyy/MM/dd") + "')");
// 2014/12/17 [Yoichiro Kamei] mod - begin �V�X�e���L�����ԑΉ�
//            sb.append(" AND(INSURE_VALID_END >= '"
            sb.append(" AND(SYSTEM_INSURE_VALID_END >= '"
//2014/12/17 [Yoichiro Kamei] mod - end
                    + VRDateParser.format(
                            ACDateUtilities.toFirstDayOfMonth(target),
                            "yyyy/MM/dd") + "')");
        }
// 2014/12/17 [Yoichiro Kamei] mod - begin �V�X�e���L�����ԑΉ�
//        sb.append(" ORDER BY INSURE_VALID_END DESC");
        sb.append(" ORDER BY SYSTEM_INSURE_VALID_END DESC");
//2014/12/17 [Yoichiro Kamei] mod - end
        return sb.toString();
    }

    /*
     * // 2007/12/4 [Masahiko Higuchi] add - begin
     */
    /**
     * �X�L�b�v�������邩��ԋp���܂��B
     * 
     * @return True:�X�L�b�v���� False:�X�L�b�v�s����
     * @author Masahiko Higuchi
     * @since Ver 5.4.1
     */
    public boolean isSkipEmptyPatientClaim() {
        return skipEmptyPatientClaim;
    }

    /**
     * �X�L�b�v�̗L����ݒ肵�܂��B
     * 
     * @param skipEmptyPatientClaim
     * @author Masahiko Higuchi
     * @since Ver 5.4.1
     */
    public void setSkipEmptyPatientClaim(boolean skipEmptyPatientClaim) {
        this.skipEmptyPatientClaim = skipEmptyPatientClaim;
    }

    /**
     * XMLWriter���擾���܂��B
     * 
     * @return
     * @author Masahiko Higuchi
     * @since Ver 5.4.1
     */
    public ACChotarouXMLWriter getWriter() {
        return writer;
    }

    private void buildPatientClaim(VRList patientList, VRMap param)
            throws Exception {
        Date claimDate = null;

        // patientData�̌��������[�v����B
        for (int j = 0; j < patientList.size(); j++) {
            // �ďW�v���W�b�N��ʂ�
            VRMap map = (VRMap) patientList.getData(j);
            // ���I���̏ꍇ�������X�L�b�v����B
            if (!"TRUE".equalsIgnoreCase(ACCastUtilities
                    .toString(VRBindPathParser.get("CHOISE", map)))) {
                continue;
            }
            claimDate = ACCastUtilities.toDate(map.get("CLAIM_DATE"));
            // ���p��ID�ޔ�p��int patient_id �𐶐����ApatientData�� KEY : PATIENT_ID ��ݒ肷��B
            int patient_id = ACCastUtilities.toInt(VRBindPathParser.get(
                    "PATIENT_ID", map));
            // �l���ԍ����擾����B
            int claimStyleType = ACCastUtilities.toInt(
                    VRBindPathParser.get("CLAIM_STYLE_TYPE", map), 0);

            // �����ڍ׏����擾���AVRArrayList claimList �Ɋi�[����B
            StringBuilder sb = new StringBuilder();
            sb.append(" AND(CLAIM.CLAIM_DATE = '"
                    + VRDateParser.format(claimDate, "yyyy/MM/dd") + "')");
            sb.append(" AND(CLAIM.TARGET_DATE = '"
                    + VRDateParser.format(
                            ACCastUtilities.toDate(map.get("TARGET_DATE")),
                            "yyyy/MM/dd") + "')");
            // ���p��ID���w�肵�Ă���Ȃ�Γ���̗��p�҂̂݁B���w��Ȃ�ΑS���p�҂�ΏۂƂ���B
            sb.append(" AND(CLAIM.PATIENT_ID = " + patient_id + ")");

            // �ی��Ҕԍ��A��ی��Ҕԍ��̌���������ǉ�����B
            sb.append(" AND(CLAIM.INSURER_ID = '"
                    + VRBindPathParser.get("INSURER_ID", map) + "')");

            if (VRBindPathParser.get("INSURED_ID", map) != null) {
                sb.append(" AND(CLAIM.INSURED_ID = '"
                        + VRBindPathParser.get("INSURED_ID", map) + "')");
            } else {
                sb.append(" AND(CLAIM.INSURED_ID = '')");
            }

            sb.append(" AND(CLAIM.PROVIDER_ID = '"
                    + QkanSystemInformation.getInstance().getLoginProviderID()
                    + "')");

            if (!"07".equals(affair) && !"08".equals(affair)) {
                sb.append(" AND(CLAIM.CLAIM_STYLE_TYPE = " + claimStyleType
                        + ")");
            }

            VRList claimList = QkanCommon.getClaimDetailCustom(dbm, claimDate,
                    sb.toString());

            if ((claimList == null) || (claimList.size() == 0)) {
                VRLogger.warning("�W�v�f�[�^�擾�G���[:" + sb.toString());
                continue;
            }

            // ������
            VRHashMap printParam = new VRHashMap();
            // �����Ώۓ�
            printParam.put("SEIKYU_DATE", claimDate);
            // ���[�f�[�^
            printParam.put("STYLE_DATA", claimList);
            // ���p�ҏ��
            VRMap patient = (VRLinkedHashMap) QkanCommon.getPatientInfo(dbm,
                    patient_id).get(0);
            printParam.put("PATIENT", patient);
            // ���Ə����
            printParam.put("PROVIDERS", providerMap);
            // �l���ԍ�
            printParam.put("CLAIM_STYLE_TYPE", String.valueOf(claimStyleType));
            // �l���ԍ�����I�v�V����
            printParam.put("YOSHIKI_BANGO", yoshikiBango);

            printParam.put("MANAGER", manager);

            // [ID:0000612][Shin Fujihara] 2010/11 edit begin 2010�N�x�Ή�
            // doPrintAffair07(patient,claimList,param,claimDate,ACCastUtilities.toDate(map.get("TARGET_DATE")));
            doPrintAffair07Selecter(patient, claimList, param, claimDate,
                    ACCastUtilities.toDate(map.get("TARGET_DATE")));
            // [ID:0000612][Shin Fujihara] 2010/11 edit end 2010�N�x�Ή�

            if (!"06".equals(affair)) {
                // �����I�ɉ��
                printParam.clear();
                printParam = null;
            }
        }
    }
    // 2007/12/4 [Masahiko Higuchi] add - end
    
    //[2016�N�v�]][Shinobu Hitaka] 2016/12/02 add begin ���S�����̕\����������擾���܂�
    /**
     * ���S�����̕\����������擾����B
     * @return
     */
    public String calc_futanwariai(int kyufuritsu, int dokujiFlag) {
        int wariai = 100 - kyufuritsu;
        String strWariai = "";
        if (wariai > 0) {
            if (wariai == 100) {
                if (dokujiFlag == 1) {
                    strWariai = "�Ǝ�/�藦";
                } else if (dokujiFlag == 2) {
                    strWariai = "�Ǝ�/��z";
                } else if (dokujiFlag == 3) {
                    strWariai = "�Ǝ�/�藦��z";
                }
            } else {
                strWariai = "���S����:" + ACCastUtilities.toString(wariai, "") + "%";
            }
        }
        return strWariai;
    }
    //[2016�N�v�]][Shinobu Hitaka] 2016/12/02 add end

}
