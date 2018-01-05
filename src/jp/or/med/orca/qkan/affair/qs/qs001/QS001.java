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
 * �J����: ���}�@�M�u
 * �쐬��: 2006/01/08  ���{�R���s���[�^�[������� ���}�@�M�u �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �\��Ǘ� (S)
 * �v���Z�X �T�[�r�X�\�� (001)
 * �v���O���� �T�[�r�X�\�� (QS001)
 *
 *****************************************************************
 */

package jp.or.med.orca.qkan.affair.qs.qs001;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.dnd.DragGestureEvent;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.Format;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import jp.nichicom.ac.ACCommon;
import jp.nichicom.ac.ACConstants;
import jp.nichicom.ac.bind.ACBindUtilities;
import jp.nichicom.ac.component.dnd.event.ACDraggableListener;
import jp.nichicom.ac.component.dnd.event.ACDropEvent;
import jp.nichicom.ac.container.ACPanel;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.core.ACFrameEventProcesser;
import jp.nichicom.ac.core.debugger.ACStaticDebugger;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.lib.care.claim.print.schedule.CareServiceCodeCalcurater;
import jp.nichicom.ac.lib.care.claim.print.schedule.CareServiceSummaryManager;
import jp.nichicom.ac.lib.care.claim.print.schedule.QkanSjAfChecker;
import jp.nichicom.ac.lib.care.claim.print.schedule.QkanSjAfException;
import jp.nichicom.ac.lib.care.claim.print.schedule.QkanSjInsurerChecker;
import jp.nichicom.ac.lib.care.claim.print.schedule.QkanSjInsurerException;
import jp.nichicom.ac.lib.care.claim.servicecode.CareServiceCommon;
import jp.nichicom.ac.lib.care.claim.servicecode.Qkan10011_ServiceCodeManager;
import jp.nichicom.ac.lib.care.claim.servicecode.Qkan10011_ServiceUnitGetter;
import jp.nichicom.ac.lib.care.claim.servicecode.QkanSjServiceCodeManager;
import jp.nichicom.ac.lib.care.claim.servicecode.QkanSjTankaManager;
import jp.nichicom.ac.lib.care.claim.servicecode.QkanSjTankaNotFoundException;
import jp.nichicom.ac.lib.care.claim.servicecode.QkanValidServiceCommon;
import jp.nichicom.ac.pdf.ACChotarouXMLUtilities;
import jp.nichicom.ac.pdf.ACChotarouXMLWriter;
import jp.nichicom.ac.sql.ACDBManager;
import jp.nichicom.ac.sql.ACPassiveKey;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.ac.util.ACDateUtilities;
import jp.nichicom.ac.util.ACMessageBox;
import jp.nichicom.ac.util.adapter.ACListModelAdapter;
import jp.nichicom.ac.util.splash.ACSplashChaine;
import jp.nichicom.ac.util.splash.ACSplashable;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.bind.VRBindSource;
import jp.nichicom.vr.layout.VRLayout;
import jp.nichicom.vr.text.parsers.VRDateParser;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.nichicom.vr.util.adapter.VRListModelAdapter;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.QkanConstants;
import jp.or.med.orca.qkan.QkanSystemInformation;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.affair.QkanMessageList;
import jp.or.med.orca.qkan.text.QkanJotaiCodeUnapplicableFormat;
import jp.or.med.orca.qkan.text.QkanServiceAbbreviationFormat;
import jp.or.med.orca.qkan.text.QkanServiceKindNameFormat;

/**
 * �T�[�r�X�\��(QS001)
 */
@SuppressWarnings("serial")
public class QS001 extends QS001Event {
    /**
     * �R���X�g���N�^�ł��B
     */
    public QS001() {
    }

    private int correctKey = 0;

    public void initAffair(ACAffairInfo affair) throws Exception {
        super.initAffair(affair);
        initAction(affair);
    }

    /**
     * �������������s�Ȃ��܂��B
     * 
     * @param affair �Ɩ����
     * @throws Exception ������O
     */
    protected void initAction(ACAffairInfo affair) throws Exception {
        getPatternList().setHeaderVisible(false);

        Qkan10011_ServiceCodeManager.getInstance().clearServiceCodeCache();

        // ���e������擾�E�ݒ�
        // �n��p�����[�^�� KEY : PROCESS_TYPE �� VALUE ���擾����B
        // �擾�����l�͏����^�C�v(processType)�ɑޔ�����B
        setProcessType(ACCastUtilities.toInt(VRBindPathParser.get(
                "PROCESS_TYPE", affair.getParameters())));

        // �n��p�����[�^�� KEY : PATIENT_ID �� VALUE ���擾����B
        // �擾�����l�͗��p��ID(patientID)�ɑޔ�����B
        setPatientID(ACCastUtilities.toInt(VRBindPathParser.get("PATIENT_ID",
                affair.getParameters())));
        // �n��p�����[�^�� KEY : TARGET_DATE �� VALUE ���擾����B
        // �擾�����l�͑Ώ۔N��(targetDate)�ɑޔ�����B
        setTargetDate(ACCastUtilities.toDate(VRBindPathParser.get(
                "TARGET_DATE", affair.getParameters())));

        // ���p�b�V�u�`�F�b�N�p�̃L�[�𐶐�����B
        // �ȉ��̐ݒ�Ńp�b�V�u�`�F�b�N�L�[�𐶐�����B
        // �e�[�u�����F SERVICE_PASSIVE_CHECK
        // �t�B�[���h���F
        // PATIENT_ID
        // LOGIN_PROVIDER_ID
        // TARGET_DATE
        // CHECK_TYPE
        // �t�H�[�}�b�g�F
        // �Ȃ�
        // ������
        // ���t(yyyy-MM-dd)
        // �Ȃ�
        // �ޔ��f�[�^�ɂ�����^�C���X�^���v�t�B�[���h���F LAST_TIME
        // DB�f�[�^�ɂ�����^�C���X�^���v�t�B�[���h���F LAST_TIME
        // ���������p�b�V�u�`�F�b�N�L�[���T�[�r�X�p�b�V�u�`�F�b�N�e�[�u���p�̃p�b�V�u�L�[(ERVICE_PASSIVE_CHECK_KEY)�ɑޔ�����B
        setSERVICE_PASSIVE_CHECK_KEY(new ACPassiveKey("SERVICE_PASSIVE_CHECK",
                new String[] { "PATIENT_ID",
                        // "LOGIN_PROVIDER_ID",
                        "TARGET_DATE", "CHECK_TYPE", }, new Format[] { null,
                        // ACConstants.FORMAT_SQL_STRING,
                        ACConstants.FORMAT_SQL_FULL_YMD, null, }, "LAST_TIME",
                "LAST_TIME"));
        // �p�b�V�u�`�F�b�N�e�[�u���p��SQL�p�����^�𐶐����A�p�b�V�u�`�F�b�N�e�[�u���p��SQL�p�����^(passiveCheckSQLParam)�ɑޔ�����B
        VRMap sqlParam = new VRHashMap();
        VRBindPathParser.set("PATIENT_ID", sqlParam,
                new Integer(getPatientID()));
        // VRBindPathParser.set("LOGIN_PROVIDER_ID", sqlParam,
        // QkanSystemInformation.getInstance().getLoginProviderID());
        VRBindPathParser.set("TARGET_DATE", sqlParam, getTargetDate());
        VRBindPathParser.set("CHECK_TYPE", sqlParam, new Integer(
                getProcessType()));
        setPassiveCheckSQLParam(sqlParam);

        // ���������R�[�h�̗L������ɁA�X�V���[�h���o�^���[�h���𔻒f
        // ���������R�[�h�̗L������ɁA�X�V���[�h���o�^���[�h���𔻒f����B
        checkProcessMode();

        // ���Ώ۔N���̐ݒ�
        // �u���p�ҏ��v���̓��t���ڂɑΏ۔N��(targetDate)��ݒ肷��B
        getTargetYearMonth().setText(
                VRDateParser.format(getTargetDate(), "ggge�NM��"));
        // �����p�ҏ��(��{���)�̐ݒ�
        // ���p��ID(patientID) �����ɁA���p�҂̊�{�����擾����B
        // �擾�����l�͗��p�ҏ��(patientInfo)�ɐݒ肷��B
        VRList patients = QkanCommon.getPatientInfo(getDBManager(),
                getPatientID());
        if (patients.isEmpty()) {
            // ���p�ҏ�񂪑��݂��Ȃ��ꍇ
            // �߂�
            ACFrame.getInstance().back();
            return;
        }
        setPatientInfo((VRMap) patients.getData());
        // ���p�ҏ����u���p�ҏ��v���ɐݒ肷��B
        getPatientName().setText(
                QkanCommon.toFullName(VRBindPathParser.get(
                        "PATIENT_FAMILY_NAME", getPatientInfo()),
                        VRBindPathParser.get("PATIENT_FIRST_NAME",
                                getPatientInfo())));

        // �����p�ҏ��(�{�ݗ������)�̐ݒ�
        // ���p��ID(patientID) �����ɁA���p�҂̎{�ݗ��������擾����B
        // [ID:0000749][Masahiko.Higuchi] del - begin 2012�N�x�Ή� �{�ݏ��̗����Ǘ��Ɋւ���C��
//        VRList specialFacilities = getDBManager().executeQuery(
//                getSQL_GET_PATIENT_FACILITY_FLAG(getPatientInfo()));
//        if (!specialFacilities.isEmpty()) {
//            // �{�ݗ������̓�������҃t���O������ϐ�(inSpecialFacilityFlag)�ɑޔ�����B
//            Object obj = ((Map) specialFacilities.getData())
//                    .get("TOKUTEI_NYUSHO_FLAG");
//            setInSpecialFacilityFlag(ACCastUtilities.toInt(obj, 0));
//            obj = ((Map) specialFacilities.getData()).get("KYUSOCHI_FLAG");
//            setOldFacilityUserFlag(ACCastUtilities.toInt(obj, 0));
//        }
        // [ID:0000749][Masahiko.Higuchi] del - end
        // [ID:0000749][Masahiko.Higuchi] add - begin 2012�N�x�Ή� �{�ݏ��̗����Ǘ��Ɋւ���C��
        VRMap facilityParam = new VRHashMap();
        facilityParam.setData("PATIENT_ID",getPatientInfo().getData("PATIENT_ID"));
        facilityParam.setData("TARGET_DATE",getTargetDate());
        
        VRList specialFacilities = getDBManager().executeQuery(
        		getSQL_GET_PATIENT_FACILITY_FLAG(facilityParam));
        if (!specialFacilities.isEmpty()) {
            // �{�ݗ������̓�������҃t���O������ϐ�(inSpecialFacilityFlag)�ɑޔ�����B
            Object obj = ((Map) specialFacilities.getData())
                    .get("TOKUTEI_NYUSHO_FLAG");
            setInSpecialFacilityFlag(ACCastUtilities.toInt(obj, 1));
            obj = ((Map) specialFacilities.getData()).get("KYUSOCHI_FLAG");
            setOldFacilityUserFlag(ACCastUtilities.toInt(obj, 1));

        } else {
        	// ��������҃t���O�Ƌ��[�u�t���O�̏����l��ݒ�
        	setInSpecialFacilityFlag(1);
        	setOldFacilityUserFlag(1);

        }
        // [ID:0000749][Masahiko.Higuchi] add - end

        // �����p�ҏ��(�v���x���)�̐ݒ�
        // �v���x�������i�[�p�̃��R�[�h�W�� patientInsureInfoHistoryList��錾����B
        VRList patientInsureInfoHistoryList;
        // �Ώ۔N�����̗��p�җv���x�F�藚�����R�[�h�W�����擾���ApatientInsureInfoHistoryList�ɐݒ肷��B
        // patientInsurerInfoHistory(DBManager, targetDateSource, patinetID);
        patientInsureInfoHistoryList = QkanCommon.getPatientInsureInfoHistory(
                getDBManager(), getTargetDate(), getPatientID());

        // �Ώ۔N�����̗��p�җv���x�F�藚�����R�[�h�W����1���̏ꍇ
        if (patientInsureInfoHistoryList.size() == 1) {
            // �擾����������񂩂�A�v���x(�t�B�[���hJOTAI_CODE)���擾���A���{�ꖼ�ɕϊ�����B
            // �ϊ������v���x�����A��ʂ́u�v���x(yokaigodo)�v�ɐݒ肷��B
            VRMap patientInsurereInfo = (VRMap) patientInsureInfoHistoryList
                    .getData();
            getYokaigodo().setText(
                    QkanJotaiCodeUnapplicableFormat.getInstance().format(
                            VRBindPathParser.get("JOTAI_CODE",
                                    patientInsurereInfo)));
            // ��ʂ́u��ی��Ҕԍ�(patientInsuredID)�v�ɁA�擾�����������̔�ی��Ҕԍ�(�t�B�[���hINSURED_ID)��ݒ肷��B
            getPatientInsuredID().setText(
                    ACCastUtilities.toString(VRBindPathParser.get("INSURED_ID",
                            patientInsurereInfo)));
        } else if (patientInsureInfoHistoryList.isEmpty()) {
            VRMap param = new VRHashMap();
            param.setData("PATIENT_ID",
                    ACCastUtilities.toInteger(getPatientID()));
            VRList list = getDBManager().executeQuery(
                    getSQL_CHECK_NINTEI_HISTORY_EXISTS(sqlParam));
            if ((list == null) || (list.isEmpty())) {
                getYokaigodo().setText("�F�藚���Ȃ�");
            } else {
                getYokaigodo().setText("�L�����ԊO");
            }
            getPatientInsuredID().setText("");
        } else {
            // �Ώ۔N�����̗��p�җv���x�F�藚�����R�[�h�W��������������ꍇ
            // �����̗v���x�������i�[�p���R�[�h patientInsureInfoFirst ��錾����B
            VRMap patientInsureInfoFirst;
            // �����̗v���x�������i�[�p���R�[�h patientInsureInfoLast ��錾����B
            VRMap patientInsureInfoLast;

            // patientInsureInfoFirst�ɁApatientInsureInfoHistoryList�̍ŏ��̃��R�[�h��ݒ肷��B
            patientInsureInfoFirst = (VRMap) patientInsureInfoHistoryList
                    .getData(0);
            // patientInsureInfoLast�ɁApatientInsureInfoHistoryList�̍Ō�̃��R�[�h��ݒ肷��B
            patientInsureInfoLast = (VRMap) patientInsureInfoHistoryList
                    .getData(patientInsureInfoHistoryList.size() - 1);
            // �����A�������ɁA�������R�[�h����v���x(�t�B�[���hJOTAI_CODE)���擾���A���{�ꖼ�ɕϊ�����B
            // ��ʂ́u�v���x(yokaigodo)�v�ɂ́A�u(�����̗v���x��)��(�����̗v���x��)�v��ݒ肷��B
            
// 2015/03/06 [Yoichiro Kamei] mod - begin �V�X�e���L�����ԑΉ� 
// �����ƌ����̗v���x�����Ⴄ�ꍇ�̂݁u(�����̗v���x��)��(�����̗v���x��)�v��ݒ�
//          getYokaigodo().setText(
//          QkanJotaiCodeUnapplicableFormat.getInstance().format(
//                  VRBindPathParser.get("JOTAI_CODE",
//                          patientInsureInfoFirst))
//                  + "��"
//                  + QkanJotaiCodeUnapplicableFormat.getInstance()
//                          .format(VRBindPathParser.get("JOTAI_CODE",
//                                  patientInsureInfoLast)));
            
            String beginYokaigodo = ACCastUtilities.toString(VRBindPathParser.get(
                    "JOTAI_CODE", patientInsureInfoFirst));
            String endYokaigodo = ACCastUtilities.toString(VRBindPathParser.get(
                    "JOTAI_CODE", patientInsureInfoLast));
            if (ACTextUtilities.isNullText(endYokaigodo) || beginYokaigodo.equals(endYokaigodo)) {
                getYokaigodo().setText(
                        QkanJotaiCodeUnapplicableFormat.getInstance().format(
                                VRBindPathParser.get("JOTAI_CODE",
                                		patientInsureInfoFirst)));
            } else {
                getYokaigodo().setText(
                QkanJotaiCodeUnapplicableFormat.getInstance().format(
                        VRBindPathParser.get("JOTAI_CODE",
                            patientInsureInfoFirst))
                    + "��"
                    + QkanJotaiCodeUnapplicableFormat.getInstance()
                            .format(VRBindPathParser.get("JOTAI_CODE",
                                    patientInsureInfoLast)));
            }
// 2015/03/06 [Yoichiro Kamei] mod - end

            // ��ʂ́u��ی��Ҕԍ�(patientInsuredID)�v�ɂ́A�u(�����̔�ی��Ҕԍ�)��(�����̔�ی��Ҕԍ�)�v��ݒ肷��B
            String beginID = ACCastUtilities.toString(VRBindPathParser.get(
                    "INSURED_ID", patientInsureInfoFirst));
            String endID = ACCastUtilities.toString(VRBindPathParser.get(
                    "INSURED_ID", patientInsureInfoLast));
            if (ACTextUtilities.isNullText(beginID)) {
                beginID = "�Ȃ�";
            }
            if (ACTextUtilities.isNullText(endID) || beginID.equals(endID)) {
                getPatientInsuredID().setText(beginID);
            } else {
                getPatientInsuredID().setText(beginID + "��" + endID);
            }

        }
        getYokaigodo().setColumns(getYokaigodo().getText().length() + 1);

        // �����Ǝ҂��񋟂���T�[�r�X��ނ̐ݒ�
        // �o�^����Ă��鎖�Ə����񋟂���T�[�r�X���u�T�[�r�X��ށv�ɐݒ肷��B(�ǂ̎��Ə����񋟂��Ȃ��T�[�r�X�͕\�����Ȃ�)
        VRList services;
        sqlParam = new VRHashMap();
        sqlParam.setData("TARGET_DATE", getTargetDate());
        if (getProcessType() == QkanConstants.PROCESS_TYPE_PLAN) {
            // �����^�C�v(processType)��PROCESS_TYPE_PLAN�̏ꍇ
            // �T�[�r�X��ނɁu���̑��v�Ɓu��ȓ��퐶����̊����v��ǉ�����B
            services = getDBManager()
                    .executeQuery(
                            getSQL_GET_USED_PROVIDER_SERVICE_WITH_WEEKLY_SERVICE(sqlParam));
        } else {
            services = getDBManager()
                    .executeQuery(
                            getSQL_GET_USED_PROVIDER_SERVICE_WITHOUT_WEEKLY_SERVICE(sqlParam));
        }

// 2016/7/5 [Yoichiro Kamei] add - begin �������ƑΉ�

//���L�͕s�v�Ȃ̂ŃR�����g�A�E�g�iver7�ȍ~�ł͊���M_SERVICE�ɊY���f�[�^���������߁j
//        // ����21�N4���@�����Ή�
//        if (ACDateUtilities.getDifferenceOnDay(QkanConstants.H2104,
//                getTargetDate()) < 1) {
//            // ��K���f�Ï��͏��O����B
//            // 12314 : �Z�������×{���(��K���f�Ï�)
//            // 13411 : ���\�h�Z�������×{���(��K���f�Ï�)
//            int[] h2104RemoveServices = { 12314, 12614 };
//            for (int i = 0; i < services.size(); i++) {
//                VRMap row = (VRMap) services.get(i);
//                for (int j = 0; j < h2104RemoveServices.length; j++) {
//                    int removeSystemServiceKindDetail = h2104RemoveServices[j];
//                    if (ACCastUtilities.toInt(
//                            row.get("SYSTEM_SERVICE_KIND_DETAIL"), 0) == removeSystemServiceKindDetail) {
//                        services.remove(i);
//                        break;
//                    }
//                }
//            }
//        }

// 2017/6/19 [Yoichiro Kamei] mod - begin ���\�h�P�A�}�l�W�����g�Ή�
//        // AF:���\�h�P�A�}�l�W�����g�ɂ͑Ή����Ă��Ȃ��̂ŏ��O
//        for (int i = 0; i < services.size(); i++) {
//            VRMap row = (VRMap) services.get(i);
//            if (ACCastUtilities.toInt(
//                    row.get("SYSTEM_SERVICE_KIND_DETAIL"), 0) == 51511) {
//                services.remove(i);
//                break;
//            }
//        }
// 2017/6/19 [Yoichiro Kamei] mod - end
// 2016/7/5 [Yoichiro Kamei] add - end 
        
        
        // 2016/01/28 [Shinobu Hitaka] add - begin �T�[�r�X��ޔԍ����ꗗ�ɕ\��
        for (int i = 0; i < services.size(); i++) {
            VRMap row = (VRMap) services.get(i);
            if (row.get("SERVICE_CODE_KIND") != null) {
            	row.setData("SERVICE_ABBREVIATION", row.get("SERVICE_CODE_KIND") + ":" + row.get("SERVICE_ABBREVIATION"));
            }
        }
        // 2016/01/28 [Shinobu Hitaka] add - end 
        
        setServiceKindsList(services);
        getServiceKindList().setModel(new ACListModelAdapter(services));
        getServiceKindList().setCellRenderer(
                new QS001ServiceKindListCellRenderer());

        // �����[�U�o�^�ς݃T�[�r�X�p�^�[�����擾
        services = QkanCommon.getServicePatternDetail(getDBManager());
        VRMap patterns = new VRHashMap();
        Iterator<Object> it = services.iterator();
        boolean isExistingData = false;
        while (it.hasNext()) {
            VRMap row = (VRMap) it.next();
            Object kind = VRBindPathParser.get("SYSTEM_SERVICE_KIND_DETAIL",
                    row);
            Object targetPatterns = patterns.get(kind);
            if (!(targetPatterns instanceof VRList)) {
                // �ŏ��̃p�^�[��
                targetPatterns = new VRArrayList();
                patterns.put(kind, targetPatterns);
            }
            ((VRList) targetPatterns).add(row);
            // �\�h���Ή��i�v�]�Ή��j
            // TODO �p�^�[���ԍ����̔ԍς݂ł��邩���ׂ�
            if (!isExistingData) {
                for (int i = 0; i < ((VRList) targetPatterns).size(); i++) {
                    // Map�Ɋi�[����
                    VRMap map = (VRMap) ((VRList) targetPatterns).getData(i);
                    if (VRBindPathParser
                            .has(ACCastUtilities
                                    .toString(QkanConstants.INTERNAL_SERVICE_PATTERN_NO_BIND_PATH),
                                    map)) {
                        // ��x�ł��Y������Έȍ~�͒ʂ�Ȃ�
                        isExistingData = true;
                        break;
                    }
                }
            }
        }
        setServicePatternHash(patterns);

        if (!isExistingData) {
            // �̔ԍς݂łȂ������ꍇ
            // �p�^�[���ԍ����̔Ԃ���B
            it = patterns.values().iterator();
            while (it.hasNext()) {
                Object row = it.next();
                if (row instanceof VRList) {
                    VRList targetPatterns = (VRList) row;
                    for (int i = 0; i < ((VRList) targetPatterns).size(); i++) {
                        VRMap inMap = new VRHashMap();
                        inMap = (VRMap) ((VRList) targetPatterns).getData(i);
                        // �폜�Ώۂɒǉ�
                        getDeleteReseveServicePatterns().add(inMap);
                        // �ǉ��Ώۂɒǉ�
                        getInsertReserveServicePatterns().add(inMap);
                        // ���݂��Ȃ������ꍇ�i�����f�[�^�j
                        VRBindPathParser
                                .set(ACCastUtilities
                                        .toString(QkanConstants.INTERNAL_SERVICE_PATTERN_NO_BIND_PATH),
                                        inMap, ACCastUtilities.toInteger(i + 1));
                    }
                }
            }

        } else {
            // �̔ԍς݂������ꍇ
            // �p�^�[���ԍ����̔Ԃ���B
            it = patterns.values().iterator();
            while (it.hasNext()) {
                // �T�[�r�X��ޒP�ʂŃp�^�[�����\�[�g����B
                Object row = it.next();
                if (row instanceof VRList) {
                    VRList targetPatterns = (VRList) row;
                    Map<Object, VRMap> treeMap = new TreeMap<Object, VRMap>();
                    ArrayList<VRMap> keyNullList = new ArrayList<VRMap>();

                    // �p�^�[���ԍ����L�[�ɂ��ă\�[�g����B
                    Iterator<VRMap> it2 = targetPatterns.iterator();
                    while (it2.hasNext()) {
                        VRMap inMap = it2.next();
                        // �p�^�[���ԍ����L�[�ɂ���TreeMap�ɓ����B�����I�Ƀ\�[�g��������B
                        Object key = inMap
                                .get(ACCastUtilities
                                        .toString(QkanConstants.INTERNAL_SERVICE_PATTERN_NO_BIND_PATH));
                        if (key == null) {
                            // �Ȃ����T�[�r�X�p�^�[���ԍ������݂��Ȃ������ꍇ
                            keyNullList.add(inMap);
                            // �폜�Ώۂɒǉ�
                            getDeleteReseveServicePatterns().add(inMap);
                            // �ǉ��Ώۂɒǉ�
                            getInsertReserveServicePatterns().add(inMap);
                        } else {
                            treeMap.put(key, inMap);
                        }
                    }
                    // �T�[�r�X�p�^�[���ԍ������݂��Ȃ��������̂ɍ̔Ԃ���B
                    it2 = keyNullList.iterator();
                    while (it2.hasNext()) {
                        VRMap inMap = it2.next();
                        // ���݂̓o�^��+1���̔Ԃ���B
                        Integer key = ACCastUtilities
                                .toInteger(treeMap.size() + 1);
                        VRBindPathParser
                                .set(ACCastUtilities
                                        .toString(QkanConstants.INTERNAL_SERVICE_PATTERN_NO_BIND_PATH),
                                        inMap, key);
                        treeMap.put(key, inMap);
                    }

                    // �\�[�g���ʂɍ����ւ���B
                    targetPatterns.clear();
                    targetPatterns.addAll(treeMap.values());
                }
            }
        }

        // �T�[�r�X�P�ʌv�Z�N���X�𐶐�����B
        VRMap hashedProviders = new VRHashMap();
        // PROVIDER_ID���L�[�Ƀn�b�V�������A�����ϐ�(hashedProviders)�ɑޔ�����B
        ACBindUtilities.setMapFromArray(
                QkanCommon.getProviderInfo(getDBManager()), hashedProviders,
                "PROVIDER_ID");
        setCalcurater(new CareServiceCodeCalcurater());
        getCalcurater().initialize(getTargetDate(), getPatientInfo(),
                patientInsureInfoHistoryList, hashedProviders, getDBManager(),
                getServiceKindsList(), getInSpecialFacilityFlag(),
                getOldFacilityUserFlag());

        // 2016/9/27 [�������ƑΉ�][Yoichiro Kamei] add - begin
        QkanSjTankaManager.initialize(getDBManager(), getTargetDate());
        QkanSjServiceCodeManager.clearCacheIfUpdated(getDBManager());
        // 2016/9/27 [�������ƑΉ�][Yoichiro Kamei] add - end
        
        // ���E�B���h�E�^�C�g���̐ݒ�
        // �Ɩ���񃌃R�[�h���擾����B
        // �E�B���h�E�^�C�g���ɁA�擾���R�[�h��KEY : WINDOW_TITLE��VALUE��ݒ肷��B
        // �Ɩ��{�^���o�[�̃e�L�X�g�ɁA�擾���R�[�h��KEY : AFFAIR_TITLE��VALUE��ݒ肷��B
        setAffairTitle("QS001", ACCastUtilities.toString(getProcessType()),
                getButtons());

        // ���I�����ꂽ���p�҂́A�Ώ۔N�����̗\��܂��͎��я��̐ݒ�
        // ���ԕ\�iQS001002�j�𐶐�����monthlyPanel�Ƃ��Đݒ肷��B
        setMonthlyPanel(new QS001002());
        getCharts().add(getMonthlyPanel(), VRLayout.CLIENT);
        getMonthlyPanel().setTargetDate(getTargetDate());
        getMonthlyPanel().setOwnerAffair(this);

        // �T�[�r�X�`��p�̃Z�������_��(QS001ServicePatternListCellRenderer)��錾�E��������B
        QS001ServicePatternListCellRenderer cellRenderer = new QS001ServicePatternListCellRenderer();
        VRMap masterService = QkanCommon.getMasterService(getDBManager(),
                getTargetDate());
        cellRenderer.setMasterService(masterService);
        // [ID:0000444][Tozo TANAKA] 2009/03/14 add begin ����21�N4���@�����Ή�
        cellRenderer.setTargetDate(getTargetDate());
        // [ID:0000444][Tozo TANAKA] 2009/03/14 add end
        // [ID:0000472][Masahiko Higuchi] 2009/04 edit begin ����21�N4���@�����Ή�
        cellRenderer.setProcessType(getProcessType());
        // [ID:0000472][Masahiko Higuchi] 2009/04 edit end
        setSharedFocusCellRenderer(cellRenderer);
        // �p�^�[���p�l���փZ�������_����ݒ肷��B
        getPatternList().setCellRenderer(cellRenderer);
        getPatternList().setMasterService(masterService);
        cellRenderer.setPatternList(getPatternList());
        // ���ԕ\�փZ�������_����ݒ肷��B
        getMonthlyPanel().setCellRenderer(cellRenderer);
        getMonthlyPanel().setMasterService(masterService);

        QkanServiceAbbreviationFormat.getInstance().setMasterService(
                masterService);
        QkanServiceKindNameFormat.getInstance().setMasterService(masterService);

        // �u��v�{�^���Ƀh���b�O�C�x���g���֘A�t����B
        getPicture().addDraggableListener(new ACDraggableListener() {
            public void beginDrag(DragGestureEvent event) {
                try {
                    pictureDragAndDrop();
                } catch (Throwable ex) {
                    ACCommon.getInstance().showExceptionMessage(ex);
                }
            }

        });

        // ���T�ԕ\/���ԕ\�̐���
        // �T�ԕ\�iQS001001�j�𐶐�����weeklyPanel�Ƃ��Đݒ肷��B
        setWeeklyPanel(new QS001001());
        getCharts().add(getWeeklyPanel(), VRLayout.CLIENT);
        // �T�ԕ\�փZ�������_����ݒ肷��B
        getWeeklyPanel().setCellRenderer(cellRenderer);
        getWeeklyPanel().setTargetDate(getTargetDate());
        getWeeklyPanel().setMasterService(masterService);
        // �T�ԕ\�̊J�n�����������Ƃ��āA�J�n�����̘A�����X�i�𐶐����A��`�ϐ�beginTimeFollowListener�ɑޔ��B
        setBeginTimeFollowListener(new QS001FollowTimeComboDocumentListener(
                getWeeklyPanel().getBeginCombo(), null));
        // �T�ԕ\�̏I�������������Ƃ��āA�I�������̘A�����X�i�𐶐����A��`�ϐ�endTimeFollowListener�ɑޔ��B
        setEndTimeFollowListener(new QS001FollowTimeComboDocumentListener(
                getWeeklyPanel().getEndCombo(), null));
        getWeeklyPanel().initialize(this);

        if (getProcessType() == QkanConstants.PROCESS_TYPE_PLAN) {
            // �����^�C�v(processType)���\��iPROCESS_TYPE_PLAN�j�̏ꍇ
            // ���\��/���тɊ֌W����Ɩ��{�^���̐؂�ւ�
            // �\��p�̋Ɩ��{�^����\�����A���їp�̋Ɩ��{�^�����\���ɂ���B
            setState_AFFIR_MODE_PLAN();
        } else if (getProcessType() == QkanConstants.PROCESS_TYPE_RESULT) {
            // �����^�C�v(processType)�����сiPROCESS_TYPE_RESULT�j�̏ꍇ
            // ���\��/���тɊ֌W����Ɩ��{�^���̐؂�ւ�
            // ���їp�̋Ɩ��{�^����\�����A�\��p�̋Ɩ��{�^�����\���ɂ���B
            setState_AFFIR_MODE_RESULT();

        }
        // ������/�T�ԕ\�̃C�x���g���֘A�t����B
        // ����/�T�ԕ\�̃T�[�r�X�I���C�x���g��serviceListSelectionChanged�Ɋ֘A�t����B
        // ����/�T�ԕ\�̃L�[�����C�x���g��serviceListKeyDown�Ɋ֘A�t����B
        ListSelectionListener selListener;
        selListener = new ListSelectionListener() {
            private boolean lockFlag = false;

            public void valueChanged(ListSelectionEvent e) {
                if (lockFlag) {
                    return;
                }
                lockFlag = true;
                try {
                    serviceListSelectionChanged(e);
                } catch (Throwable ex) {
                    ACCommon.getInstance().showExceptionMessage(ex);
                } finally {
                    lockFlag = false;
                }
            }
        };
        KeyAdapter keyListener;
        keyListener = new KeyAdapter() {
            private boolean lockFlag = false;

            public void keyPressed(KeyEvent e) {
                if (lockFlag) {
                    return;
                }
                lockFlag = true;
                try {
                    serviceListKeyDown(e);
                } catch (Throwable ex) {
                    ACCommon.getInstance().showExceptionMessage(ex);
                } finally {
                    lockFlag = false;
                }
            }
        };
        getMonthlyPanel().addListSelectionListener(selListener);
        getMonthlyPanel().addKeyListener(keyListener);
        if (getWeeklyPanel() != null) {
            getWeeklyPanel().addListSelectionListener(selListener);
            getWeeklyPanel().addKeyListener(keyListener);
        }

        // �������\���f�[�^���擾
        // �����������s�Ȃ��B
        doFind();

        getMonthlyPanel().initialize(this);
        if (getServiceKindList().getItemCount() > 0) {
            getServiceKindList().setSelectedIndex(0);
        }

        boolean modifiedFlag = false;

        // ���T�ԕ\/���ԕ\�̕\���ؑ�
        if (getProcessType() == QkanConstants.PROCESS_TYPE_PLAN) {
            // �����^�C�v(processType)���\��iPROCESS_TYPE_PLAN�j�̏ꍇ
            // ���ԕ\���̌������`�F�b�N����B
            if (getMonthlyPanel().getScheduleCount() <= 0) {
                // 0���̏ꍇ
                // �T�ԕ\��\������B
                showWeekly();

                if (getProcessMode() == QkanConstants.PROCESS_MODE_INSERT) {
                    // �o�^���[�h�̏ꍇ
                    doOpenPlan();
                }
            } else {
                // 0����葽���ꍇ
                // ���ԕ\��\������B
                showMonthly();
            }
        } else if (getProcessType() == QkanConstants.PROCESS_TYPE_RESULT) {
            // �����^�C�v(processType)�����сiPROCESS_TYPE_RESULT�j�̏ꍇ

            // ���ԕ\��\������B
            showMonthly();
            if (getProcessMode() == QkanConstants.PROCESS_MODE_INSERT) {
                // �o�^���[�h�̏ꍇ
                doOpenPlan();
            }

            VRMap splParam = new VRHashMap();
            splParam.setData("PROVIDER_ID", QkanSystemInformation.getInstance()
                    .getLoginProviderID());
            VRList list = getDBManager().executeQuery(
                    getSQL_GET_LOGIN_PROVIDER_CARE_MANAGEMENT(splParam));
            if (list.isEmpty()) {
                // ������x���͒񋟂��Ă��Ȃ�
                setState_NOT_PROVIDE_CARE_MANAGEMENT();
            } else {
                // ������x����񋟂��Ă���
                setState_PROVIDE_CARE_MANAGEMENT();

                // ���ԕ\���̌������`�F�b�N����B
                if (getMonthlyPanel().getScheduleCount() <= 0) {
                    // 0���̏ꍇ
                    // �\��ǂݍ��݂��s�Ȃ����̊m�F���b�Z�[�W��\������B�����b�Z�[�WID = QS001_NO_RESULT
                    if (QkanMessageList.getInstance()
                            .QS001_QUESTION_OF_NO_RESULT() == ACMessageBox.RESULT_YES) {
                        // �u�͂��v�I����
                        // �\��f�[�^�Ǎ����s�Ȃ��B
                        doOpenResult();
                        modifiedFlag = getMonthlyPanel().getScheduleCount() > 0;
                    }
                }
            }

            // �\�h���Ή�
            // �T�Ԍv��\����{�^���𖳌��ɂ���B
            setState_RESULT_PRINT_WEEKLY();
        }

        setServiceModify(modifiedFlag);
    }

    public boolean canBack(VRMap parameters) throws Exception {
        if (!super.canBack(parameters)) {
            return false;
        }
        // ���߂菈��
        // ���X�i�b�v�V���b�g�`�F�b�N(�Ώۂ́u���ԕ\/�T�ԕ\(charts�p�l��)�v)
        if (getServiceModify()) {
            // ���߂菈���m�F(ID = WARNING_OF_UPDATE_ON_MODIFIED)
            switch (QkanMessageList.getInstance()
                    .WARNING_OF_UPDATE_ON_MODIFIED()) {
            case ACMessageBox.RESULT_YES:
                // ���ۑ�����

                // [ID:0000456][Tozo TANAKA] 2009/03/12 add begin ����21�N4���@�����Ή�
                // �����̓`�F�b�N
                // ���̓`�F�b�N���s���B
                if (!checkValidInput()) {
                    // �߂�l��false�̏ꍇ
                    // �߂�l�Ƃ���false��Ԃ��A�����𒆒f����B
                    return false;
                }
                // [ID:0000456][Tozo TANAKA] 2009/03/12 add end

                if (getProcessMode() == QkanConstants.PROCESS_MODE_INSERT) {
                    doInsert();
                } else {
                    doUpdate();
                }
                break;
            case ACMessageBox.RESULT_NO:
                break;
            default:
                return false;
            }
        }
        // �T�[�r�X�p�^�[���̒ǉ��폜�����s����B
        saveServicePattern();
        // ���߂菈��

        Qkan10011_ServiceCodeManager.getInstance().clearServiceCodeCache();

        // �O��ʂւ̑J�ڂ�������Ȃ��true��Ԃ��B
        return true;
    }

    public boolean canClose() throws Exception {
        if (!super.canClose()) {
            return false;
        }
        // ���Ɩ��I�����̃C�x���g
        // ���X�i�b�v�V���b�g�`�F�b�N(�Ώۂ́u���ԕ\/�T�ԕ\(charts�p�l��)�v)
        // �X�i�b�v�V���b�g�̍X�V�`�F�b�N���s���B
        // �X�V����Ă��Ȃ��ꍇ
        // �T�[�r�X�p�^�[���̒ǉ��폜�����s����B
        // �V�X�e�����I������B
        if (getServiceModify()) {
            // �X�V����Ă���ꍇ
            // �������p������B

            // ���I���m�F
            // �I���m�F�̃��b�Z�[�W��\������B�����b�Z�[�WID = WARNING_OF_CLOSE_ON_MODIFIED
            // �uOK�v�I����
            // �������p������B
            if (QkanMessageList.getInstance().WARNING_OF_CLOSE_ON_MODIFIED() != ACMessageBox.RESULT_OK) {
                // �u�L�����Z���v�I����
                // �����𒆒f����B
                return false;
            }
        }

        // �T�[�r�X�p�^�[���̒ǉ��폜�����s����B
        saveServicePattern();

        // �I����������Ȃ��true��Ԃ��B
        return true;
    }

    // �R���|�[�l���g�C�x���g

    /**
     * �u��������v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void printWeeklyActionPerformed(ActionEvent e) throws Exception {
        // ���T�ԃT�[�r�X�v��\���
        // �@���T�ԃT�[�r�X�v��\���������B
        // �@�@�n��p�p�����[�^ printParam(���R�[�h)�𐶐����A���L�̒l��ݒ肷��B
        VRMap printParam = new VRHashMap();
        // �@�@�@KEY : PATIENT_NAME, VALUE : ���p�Ҏ���
        VRBindPathParser.set("PATIENT_NAME", printParam, getPatientName()
                .getText());
        // �@�@�@KEY : PATIENT_ID, VALUE : ���p�Ҕԍ�(�n��p�����[�^ KEY : PATIENT_ID��VALUE)
        VRBindPathParser.set("PATIENT_CODE", printParam,
                getPatientInfo().get("PATIENT_CODE"));
        // �@�@�@KEY : CREATE_DATE, VALUE : �쐬�N����(�T�ԕ\����擾)
        // �@�@�@KEY : TARGET_DATE, VALUE : �Ώ۔N��(�n��p�����[�^ KEY : TARGET_DATE��VALUE)
        VRBindPathParser.set("TARGET_DATE", printParam, getTargetDate());
        // �@�@�@KEY : WEEKLY_SERVICE, VALUE : �T�ԕ\�E�T�P�ʂ̃T�[�r�X(���R�[�h�W��)
        VRBindPathParser.set("WEEKLY_SERVICE", printParam, getWeeklyPanel()
                .getAllWeeklySchedule());
        // �@�@�@KEY : NON_WEEKLY_SERVICE, VALUE : �T�ԕ\�E�T�P�ʈȊO�̃T�[�r�X�i���R�[�h�W��)
        VRBindPathParser.set("NON_WEEKLY_SERVICE", printParam, getWeeklyPanel()
                .getAllFreedaySchedule());

        Date date = null;
        if ((!ACTextUtilities.isNullText(getWeeklyPanel().getCreateDate()
                .getText())) && getWeeklyPanel().getCreateDate().isValidDate()) {
            date = getWeeklyPanel().getCreateDate().getDate();
        }
        VRBindPathParser.set("CREATE_DATE", printParam, date);

        VRBindPathParser.set("M_SERVICE", printParam,
                QkanCommon.getMasterService(getDBManager(), getTargetDate()));
        // �@�@������s���B
        // doPrint(QS00101, printParam);
        ACChotarouXMLWriter writer = new ACChotarouXMLWriter();
        writer.beginPrintEdit();
        new QS001P01().doPrint(writer, printParam);
        writer.endPrintEdit();
        ACChotarouXMLUtilities.openPDF(writer);

    }

    /**
     * �u��������v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void printMonthlyActionPerformed(ActionEvent e) throws Exception {
        // �����p�[�E�v��[���

        if (!getMonthlyPanel().checkPrintable()) {
            return;
        }

        // ���uQS001031:���p�E�񋟕[����v��ʂ��J���B
        // �@�n��p�p�����[�^�Ƃ��ĉ��L�̒l���擾����B
        // �@�@�����^�C�v�iprocessType�j
        // �@���̑��Aparam�ɉ��L�̏���ݒ肷��B
        // �@�@���p�ҏ��(PATIENT_ID�A�����Ȃ�)
        // �@�@���p�җv���x���(�v���x�A���x�z�Ȃ�)
        // �v���x���i���́H�����H�j
        // �@�@�Ώ۔N��(TARGET_DATE)
        // �@�@���ԕ\���(���R�[�h�W��)
        // �@�uQS001031:���p�E�񋟕[����v��ʂ𐶐����Aaffair�ŏ�������ɕ\������B
        int mode;
        if (getProcessType() == QkanConstants.PROCESS_TYPE_PLAN) {
            mode = QkanConstants.SERVICE_DETAIL_GET_PLAN;
        } else {
            mode = QkanConstants.SERVICE_DETAIL_GET_RESULT;
        }
        new QS001003().showModal(getCalcurater(), getMonthlyPanel()
                .getSchedule(mode, false), getProcessType());

    }

    /**
     * �uDB�ւ̓o�^�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void insertActionPerformed(ActionEvent e) throws Exception {
        // ����ʂ̏���DB�ɓo�^����
        // �����̓`�F�b�N
        // ���̓`�F�b�N���s���B
        // �߂�l��true�̏ꍇ
        // �������p������B
        if (!checkValidInput()) {
            // �߂�l��false�̏ꍇ
            // �����𒆒f����B
            return;
        }
        // ���o�^����
        // �T�ԕ\�E���ԕ\�̏���DB�ɓo�^����B
        if (doInsert()) {
            // �o�^�����̃��b�Z�[�W��\������B��ID=INSERT_SUCCESSED
            QkanMessageList.getInstance().INSERT_SUCCESSED();
            if (getProcessType() == QkanConstants.PROCESS_TYPE_PLAN) {
                // �T�[�r�X�\��̏ꍇ
                getMonthlyPanel().recalcServiceTotal();
            }
        }

    }

    /**
     * �uDB�ւ̍X�V�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void updateActionPerformed(ActionEvent e) throws Exception {
        // ����ʂ̏���DB�ɍX�V����
        // �����̓`�F�b�N
        // ���̓`�F�b�N���s���B

        // �߂�l��true�̏ꍇ
        // �������p������B
        if (!checkValidInput()) {
            // �߂�l��false�̏ꍇ
            // �@�@�@�����𒆒f����B
            return;
        }
        // ���X�V����
        // �@�T�ԕ\�E���ԕ\�̏���DB�ɍX�V����B
        if (doUpdate()) {
            // �o�^�����̃��b�Z�[�W��\������B��ID=INSERT_SUCCESSED
            QkanMessageList.getInstance().UPDATE_SUCCESSED();
            if (getProcessType() == QkanConstants.PROCESS_TYPE_PLAN) {
                // �T�[�r�X�\��̏ꍇ
                getMonthlyPanel().recalcServiceTotal();
            }
        }
    }

    /**
     * �u�ߋ��f�[�^�Ǎ��v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void openPlanActionPerformed(ActionEvent e) throws Exception {
        // ���ߋ��f�[�^�̒��ōŐV�̃f�[�^����ʂɓW�J
        // ���������s�m�F
        // �������s�̊m�F�̂��߁A���b�Z�[�W��\������B�����b�Z�[�WID =
        // QC001_WARNING_ON_READ_OF_MOST_NEW_DATA
        // �uOK�v�I����
        // �������p������B
        if (QkanMessageList.getInstance()
                .QC001_WARNING_ON_READ_OF_MOST_NEW_DATA() != ACMessageBox.RESULT_OK) {
            // �u�L�����Z���v�I����
            // �����𒆒f����B
            return;
        }
        // ���ߋ��̒��߂̏����擾
        VRMap param = new VRHashMap();
        VRBindPathParser.set("PATIENT_ID", param, new Integer(getPatientID()));
        // VRBindPathParser.set("LOGIN_PROVIDER_ID", param,
        // QkanSystemInformation
        // .getInstance().getLoginProviderID());
        VRBindPathParser.set("TARGET_DATE", param, getTargetDate());
        VRList schedules = null;
        ACDBManager dbm = getDBManager();
        try {
            dbm.beginTransaction();
            VRList list = dbm.executeQuery(getSQL_GET_LAST_PLAN_DATE(param));
            if (list.size() > 0) {
                Object obj = VRBindPathParser.get("TARGET_DATE",
                        (VRMap) list.getData());
                if (obj instanceof Date) {
                    schedules = QkanCommon
                            .getServiceDetail(
                                    dbm,
                                    getPatientID(),
                                    (Date) obj,
                                    QkanConstants.SERVICE_DETAIL_GET_PLAN_OF_WEEKLY_ONLY);
                    // ���j�[�N�L�[�̍폜
                    Iterator it = schedules.iterator();
                    while (it.hasNext()) {
                        Map service = (Map) it.next();
                        service.remove("SERVICE_ID");
                    }
                }
            }
            dbm.commitTransaction();
        } catch (Exception ex) {
            dbm.rollbackTransaction();
            throw ex;
        }
        if (schedules != null) {
            // getMonthlyPanel().setSchedule(schedules);
            getWeeklyPanel().setSchedule(schedules);
        }
    }

    /**
     * �u��ʃN���A�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void clearPlanActionPerformed(ActionEvent e) throws Exception {
        // ���T�ԕ\�E���ԕ\�̏����N���A(removeAll)
        // �T�ԕ\�E���ԕ\�̂����A�\������Ă�����̏����N���A����B
        if (getMonthlyPanel().isVisible()) {
            if (QkanMessageList.getInstance().QS001_WARNING_OF_CLEAR_MONTHLY() == ACMessageBox.RESULT_OK) {
                getMonthlyPanel().clearSchedule();
            }
        } else {
            if (QkanMessageList.getInstance().QS001_WARNING_OF_CLEAR_WEEKLY() == ACMessageBox.RESULT_OK) {
                getWeeklyPanel().clearSchedule();
            }
        }
    }

    /**
     * �u�\��f�[�^�Ǎ��v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void openResultActionPerformed(ActionEvent e) throws Exception {
        // ������Ώ۔N���̗\�������ʂɓW�J
        // ���������s�m�F
        // �������s�̊m�F�̂��߁A���b�Z�[�W��\������B�����b�Z�[�WID = QR001_READ_PLAN

        // �uOK�v�I����
        // �������p������B
        if (QkanMessageList.getInstance().QS001_READ_PLAN() != ACMessageBox.RESULT_OK) {
            // �u�L�����Z���v�I����
            // �����𒆒f����B
            return;
        }
        // �\��f�[�^�Ǎ����s�Ȃ��B
        doOpenResult();
    }

    /**
     * �u��ʃN���A�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void clearResultActionPerformed(ActionEvent e) throws Exception {
        // �����ԕ\�̏����N���A
        // ���ԕ\�̏����N���A����B
        // if (QkanMessageList.getInstance().QS001_WARNING_OF_CLEAR_MONTHLY() ==
        // ACMessageBox.RESULT_OK) {
        // getMonthlyPanel().clearSchedule();
        // }
        if (getMonthlyPanel().isVisible()) {
            if (QkanMessageList.getInstance().QS001_WARNING_OF_CLEAR_MONTHLY() == ACMessageBox.RESULT_OK) {
                getMonthlyPanel().clearSchedule();
                
                // [CCCX: 03987][Shinobu Hitaka] 2017/07/25 add begin �v��P�ʐ��N���A
                getMonthlyPanel().getPlanUnits().clear();
                // [CCCX: 03987][Shinobu Hitaka] 2017/07/25 add end
            }
        } else {
            if (QkanMessageList.getInstance().QS001_WARNING_OF_CLEAR_WEEKLY() == ACMessageBox.RESULT_OK) {
                getWeeklyPanel().clearSchedule();
            }
        }
    }

    /**
     * �u�T�[�r�X��ޑI�����C�x���g�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void serviceKindListSelectionChanged(ListSelectionEvent e)
            throws Exception {
        // ���T�[�r�X�p�^�[���E���Ə��R���{�̐ݒ�
        if (e.getValueIsAdjusting()) {
            return;
        }
        // ���T�[�r�X�p�^�[���̐ݒ�
        refleshServiceKind();
        int idx = getServiceKindList().getSelectedIndex();
        if (idx >= 0) {
            getServiceKindList().ensureIndexIsVisible(idx);
        }
        // �ő�p�l�����̈ێ�
        Dimension newDM = getServiceContentSettings().getPreferredSize();
        if (newDM != null) {
            Dimension oldDM = getServicePreferredSize();
            if ((oldDM == null) || (oldDM.getWidth() < newDM.getWidth())) {
                // ���傫�ȕ���v�����ꂽ
                getServuceDetails().setPreferredSize(newDM);
                setServicePreferredSize(newDM);
            }
        }
    }

    /**
     * �u�T�[�r�X�p�^�[���o�^�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void patternAddActionPerformed(ActionEvent e) throws Exception {
        // ���T�[�r�X�p�^�[���̓o�^
        VRMap service = createServiceData();
        int emptyNo = -1;
        if (service != null) {
            service = (VRMap) service.clone();
            service.setData("SERVICE_USE_TYPE",
                    QkanConstants.SERVICE_USE_TYPE_PATTERN);

            // �\�h���Ή��i�v�]�Ή��j
            // 2006/05 TODO
            boolean isEmptyNo = false;
            Object obj = getPatternList().getModelAtBindSource();
            while (obj instanceof VRListModelAdapter) {
                obj = ((VRListModelAdapter) obj).getAdaptee();
            }
            if (obj instanceof VRList) {
                // ���X�g�̐����[�v����
                VRList list = ((VRList) obj);
                VRMap inMap = new VRHashMap();
                // ���X�g���̓����ԍ���inMap�Ɋi�[����B
                for (int k = 0; k < list.size(); k++) {
                    VRMap map = new VRHashMap();
                    map = (VRMap) list.getData(k);
                    if (VRBindPathParser
                            .has(ACCastUtilities
                                    .toString(QkanConstants.INTERNAL_SERVICE_PATTERN_NO_BIND_PATH),
                                    map)) {
                        inMap.put(
                                ACCastUtilities
                                        .toString(map.getData(ACCastUtilities
                                                .toString(QkanConstants.INTERNAL_SERVICE_PATTERN_NO_BIND_PATH))),
                                "");
                    } else {
                        inMap.put(ACCastUtilities.toString(k + 1), "");
                    }
                }

                // �̔ԂɎg���ԍ����擾����
                int count = 0;
                for (int j = 0; j < list.size() + 1; j++) {
                    count++;
                    if (!VRBindPathParser.has(ACCastUtilities.toString(j + 1),
                            inMap)) {
                        // �󂫔ԍ�
                        emptyNo = j + 1;
                        break;
                    }
                }
                // �󂫔ԍ�������̂�
                if (count <= list.size()) {
                    isEmptyNo = true;
                }

                service.setData(
                        ACCastUtilities
                                .toString(QkanConstants.INTERNAL_SERVICE_PATTERN_NO_BIND_PATH),
                        new Integer(emptyNo));
            }

            service.setData("REGULATION_RATE", new Integer(0));

            // �ݒ���e�ŃT�[�r�X�p�^�[����ǉ�
            if (isEmptyNo) {
                getNowServicePatterns().add(emptyNo - 1, service);
            } else {
                getNowServicePatterns().add(service);
            }
            // ���j�[�N�L�[�̍폜
            service.remove("SERVICE_ID");

            // 2008/01/24 [Masahiko_Higuchi] add - begin version 5.3.8
            service.remove("CORRECT_KEY");
            service.setData("CORRECT_KEY", new Integer(correctKey));
            correctKey++;
            // 2008/01/24 [Masahiko_Higuchi] add - end
            getInsertReserveServicePatterns().add(service);

            // �T�[�r�X�p�^�[�����X�g���X�V����B
            getPatternList().setModel(
                    new ACListModelAdapter(getNowServicePatterns()));
            // �T�[�r�X�p�^�[���̑I��/���I���`�F�b�N���s���B
            checkServicePatternSelected();
        }

    }

    /**
     * �u�T�[�r�X�p�^�[���폜�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void patternDeleteActionPerformed(ActionEvent e) throws Exception {
        // ���T�[�r�X�p�^�[���̍폜
        if (!(getPatternList().getSelectedValue() instanceof VRMap)) {
            return;
        }
        VRMap pattern = (VRMap) getPatternList().getSelectedValue();
        getNowServicePatterns().remove(pattern);
        getDeleteReseveServicePatterns().add(pattern);
        // �ǉ��Ώۂ�����
        getInsertReserveServicePatterns().remove(pattern);

        // 2008/01/24 [Masahiko_Higuchi] add - begin �T�[�r�X�p�^�[���ݒ�{�^��������s���G���[�Ή�
        if (pattern.containsKey("CORRECT_KEY")) {
            // ���C���̃L�[
            String mainKey = ACCastUtilities.toString(
                    pattern.getData("CORRECT_KEY"), "");

            for (int i = getInsertReserveServicePatterns().size(); i > 0; i--) {
                // �`�F�b�N�p�̃L�[���
                Map checkMap = (Map) getInsertReserveServicePatterns().getData(
                        i - 1);

                if (checkMap.containsKey("CORRECT_KEY")) {
                    // �p�^�[���ǉ��ő��₵��������邽�߂̃L�[
                    String delKey = ACCastUtilities.toString(
                            checkMap.get("CORRECT_KEY"), "-1");

                    if (delKey.equals(mainKey)) {
                        // ��v�����ꍇ�͓o�^�p�̃f�[�^�W����������
                        getInsertReserveServicePatterns().remove(i - 1);

                    }
                }
            }
        }
        // 2008/01/24 [Masahiko_Higuchi] add - end

        // �T�[�r�X�p�^�[�����X�g���X�V����B
        getPatternList().setModel(
                new ACListModelAdapter(getNowServicePatterns()));

        // �T�[�r�X�p�^�[���̑I��/���I���`�F�b�N���s���B
        checkServicePatternSelected();

    }

    /**
     * �u�T�[�r�X���e�̐ݒ�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void serviceOfferEntrepreneurActionPerformed(ActionEvent e)
            throws Exception {
        // �����Ə��R���{�I�����C�x���g
        // ���I���������Ə����ɉ������A�T�[�r�X���e�̍��ڂ̏�Ԑݒ�
        // �@���ݐݒ肳��Ă���u�ڍ׍���(�T�[�r�X�̃p�l��)�v�ɑ΂��A�I���������Ə��ɉ�������Ԑݒ���s���B(providerSelected)
        if (getServiceOfferEntrepreneur().isSelected()) {
            QS001Service service = getSelectedServiceClass();
            QS001ServicePanel servicePanel = (QS001ServicePanel) service;
            if (service != null) {
                if (service.isUseProvider()) {
                    VRMap provider = (VRMap) getServiceOfferEntrepreneur()
                            .getSelectedModelItem();
                    if (service instanceof QS001ServicePanel) {
                        // �p�l���S�̂�L����
                        servicePanel.setFollowChildEnabled(true);
                        servicePanel.setEnabled(true);

                        if (servicePanel.checkProvider(provider)) {
                            servicePanel.setSelectedProvider(provider);
                            // getSelectedServiceClass().initialize();
                            service.providerSelected(provider);

                            // �ݒ�{�^������L����
                            setState_USABLE_PROVIDER();

                            // ���p�ł��鎖�Ə��t���O
                            setUsableProvider(true);
                        } else {
                            // �����Ȏ��Ə����I�����ꂽ�ꍇ�̓p�l���̒l�����ׂăN���A
                            service.initialize();
                            servicePanel.setSource((VRBindSource) servicePanel
                                    .createSource());
                            servicePanel.bindSource();
                            QkanCommon.selectFirstRadioItem(servicePanel);

                            // �p�l���S�̂𖳌���
                            servicePanel.setFollowChildEnabled(true);
                            servicePanel.setEnabled(false);

                            // �ݒ�{�^�����𖳌���
                            setState_NOT_USABLE_PROVIDER();
                            // ���p�ł��Ȃ����Ə��t���O
                            setUsableProvider(false);
                            return;
                        }
                    }
                }
            }
        }
    }

    /**
     * �u�T�[�r�X���㏑�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void serviceSetActionPerformed(ActionEvent e) throws Exception {
        // ���T�ԕ\�E���ԕ\��̃T�[�r�X���̏㏑
        // ���T�ԕ\�E���ԕ\��őI������Ă���A�T�[�r�X�����㏑����B
        VRMap service = getNowSelectedService();
        if (service != null) {
            // �I���T�[�r�X�̍X�V
            VRMap data = createServiceData();
            if (data != null) {
                if (CareServiceCommon.isOtherService(data)) {
                    // ���̑��̃T�[�r�X�̏ꍇ
                    if ((!getWeeklyPanel().isWeeklyServiceList(
                            getSelectedServiceListBox()))
                            || (getWeeklyPanel()
                                    .isDailyServiceList(getSelectedServiceListBox()))) {
                        // �T�Ԃ̃��X�g�ł͂Ȃ��A�܂��͓��퐶����̊������X�g�̏ꍇ
                        // �������Ȃ��B
                        return;
                    }
                }
                if (CareServiceCommon.isDailyAction(data)) {
                    // ��ȓ��퐶����̊����̏ꍇ
                    if (!getWeeklyPanel().isDailyServiceList(
                            getSelectedServiceListBox())) {
                        // ���퐶����̊������X�g�ł͂Ȃ��ꍇ
                        // �������Ȃ��B
                        return;
                    }
                }

                if (getSelectedServiceListBox() == getWeeklyPanel()
                        .getFreedayServices()) {
                    // �T�P�ʈȊO�̃T�[�r�X�̏ꍇ

                    // �T�[�r�X�̊��Ԃ̖����͂��`�F�b�N����B
                    if ((!getWeeklyPanel().getExceptionEndCombo().isSelected())
                            || (!(getWeeklyPanel().getExceptionEndCombo()
                                    .getSelectedModelItem() instanceof VRMap))) {
                        QkanMessageList.getInstance()
                                .QS001_ERROR_OF_NO_PASTE_DAY();
                        return;
                    }

                    // �T�[�r�X�̊J�n���Ɗ��Ԃ��X�V����B
                    Object obj = getWeeklyPanel().getExceptionBeginCombo()
                            .getSelectedModelItem();
                    if (obj instanceof VRMap) {
                        // �J�n��
                        data.setData("WEEK_DAY", VRBindPathParser.get(
                                "CONTENT_KEY", (VRMap) obj));
                        // ����
                        data.setData(
                                QkanConstants.SERVICE_SYSTEM_BIND_PATH_SPAN,
                                VRBindPathParser.get("CONTENT_KEY",
                                        (VRMap) getWeeklyPanel()
                                                .getExceptionEndCombo()
                                                .getSelectedModelItem()));
                    }
                } else if (getSelectedServiceListBox() == getMonthlyPanel()
                        .getDayFreeServices()) {
                    // �J�n���̓��肳��Ȃ��T�[�r�X�̏ꍇ
                    // ���Ԃ��ێ�����
                    // ����
                    data.setData(
                            QkanConstants.SERVICE_SYSTEM_BIND_PATH_SPAN,
                            VRBindPathParser
                                    .get(QkanConstants.SERVICE_SYSTEM_BIND_PATH_SPAN,
                                            service));
                } else if (getSelectedServiceListBox() == getPatternList()) {
                    // �\�h���Ή��i�v�]�Ή��j
                    // 2005/06
                    data.setData(
                            ACCastUtilities
                                    .toString(QkanConstants.INTERNAL_SERVICE_PATTERN_NO_BIND_PATH),
                            VRBindPathParser.get(
                                    ACCastUtilities
                                            .toString(QkanConstants.INTERNAL_SERVICE_PATTERN_NO_BIND_PATH),
                                    service));

                    // 2008/01/25 [Masahiko_Higuchi] add - begin
                    // �T�[�r�X�p�^�[���ݒ�{�^��������s���G���[�Ή�
                    if (service.containsKey("SERVICE_USE_TYPE")) {
                        Integer useType = ACCastUtilities.toInteger(
                                service.getData("SERVICE_USE_TYPE"), -1);
                        // �T�[�r�X�p�^�[���̋敪�͕ێ�����
                        if (!new Integer(-1).equals(useType)) {
                            data.setData("SERVICE_USE_TYPE", useType);
                        }
                        // �T�[�r�XID������������̂ŕێ�����
                        if (service.containsKey("SERVICE_ID")) {
                            data.setData("SERVICE_ID",
                                    service.getData("SERVICE_ID"));

                            // ��r�p�̃T�[�r�XID���擾����
                            String mainServiceID = ACCastUtilities.toString(
                                    service.getData("SERVICE_ID"), "");
                            // �T�[�r�X�p�^�[���ǉ��p�̃f�[�^�W����S�ă`�F�b�N����B
                            for (int i = getInsertReserveServicePatterns()
                                    .size(); i > 0; i--) {
                                Map serviceIDCheckMap = (Map) getInsertReserveServicePatterns()
                                        .get(i - 1);
                                // �i�[����Ă���L�[���擾����
                                int idCheckKey = ACCastUtilities
                                        .toInt(serviceIDCheckMap
                                                .get("SERVICE_ID"), -2);

                                String checkKey = ACCastUtilities
                                        .toString(idCheckKey);
                                // KEY�����ɓo�^����Ă���ꍇ
                                if (checkKey.equals(mainServiceID)) {
                                    // �N���A����
                                    getInsertReserveServicePatterns().remove(
                                            i - 1);
                                }
                            }
                        }

                        // �ǉ������T�[�r�X�p�^�[���ύX�ɔ��������ŐU����KEY�����ɓo�^�f�[�^�̏d����h��
                        if (service.containsKey("CORRECT_KEY")) {

                            data.setData("CORRECT_KEY",
                                    service.getData("CORRECT_KEY"));
                            // �폜���Ēǉ��Ώ̂ɂ���
                            String serviceInKey = ACCastUtilities.toString(
                                    service.getData("CORRECT_KEY"), "");

                            for (int j = getInsertReserveServicePatterns()
                                    .size(); j > 0; j--) {
                                Map maps = (Map) getInsertReserveServicePatterns()
                                        .getData(j - 1);
                                // �L�[�����o��
                                int checkKey = ACCastUtilities.toInt(
                                        maps.get("CORRECT_KEY"), -1);

                                String strKey = ACCastUtilities
                                        .toString(checkKey);
                                // KEY�����ɓo�^����Ă���ꍇ
                                if (strKey.equals(serviceInKey)) {
                                    // �N���A����
                                    getInsertReserveServicePatterns().remove(
                                            j - 1);
                                }
                            }
                        }

                        getDeleteReseveServicePatterns().add(service);
                        // �Ēǉ�
                        getInsertReserveServicePatterns().add(service);
                    }
                    // �T�[�r�X�p�^�[���̍Đݒ菈��
                    if (service.containsKey("11")) {
                        String patternName = ACCastUtilities.toString(
                                service.getData("11"), "");
                        if (!"".equals(patternName)) {
                            data.setData("11", patternName);
                        }
                    }
                    // 2008/01/25 [Masahiko_Higuchi] add - End
                }

                int selectedIndex = -1;
                if (getSelectedServiceListBox() != null) {
                    selectedIndex = getSelectedServiceListBox()
                            .getSelectedIndex();
                }

                int rate = ACCastUtilities.toInt(
                        service.get("REGULATION_RATE"), 0);
                Object oldDate = service.get("SERVICE_DATE");

                setServiceListLockFlag(true);
                service.clear();
                service.putAll(data);
                setServiceListLockFlag(false);

                service.put("SERVICE_DATE", oldDate);

                // �ύX��̊�����P�ʐ���������z�𒴂���ꍇ�A������z��������P�ʐ��ɂ���B
                if (rate > 0) {
                    // 1����1���P�ʂ̎Z�荀�ځi��{��ԑΉ��^�K�����Ȃǁj��������̑Ώ�
                    int limit = getCalcurater()
                            .getReductedUnit(
                                    service,
                                    true,
                                    CareServiceCodeCalcurater.CALC_MODE_IN_LIMIT_AMOUNT_OR_OUTER_SERVICE,
                                    null);
                    if (rate > limit) {
                        service.put("REGULATION_RATE", new Integer(limit));
                    } else {
                        service.put("REGULATION_RATE", new Integer(rate));
                    }
                }
                
                
                // 2013/10/12 [Shinobu_Hitaka] add - begin
                // �������T�[�r�X�����X�g�̉��ɂ��鎞�ASERVICE_ID���N���A���ď��ʂ�ێ�����i�o�^����ID��U��Ȃ�������ׁj
                if (getSelectedServiceListBox() != null) {
	                VRList selServices = getSelectedServiceListBox().getSchedule();
	                if (selectedIndex >= 0){
	                	Object selDate = service.get("SERVICE_DATE");
	                	if (selDate != null) {
			                Date srcDate = ACCastUtilities.toDate(selDate);
			                String srcSystemServiceKindDetail = ACCastUtilities.toString(service.get("SYSTEM_SERVICE_KIND_DETAIL"), "");
			                // �z��̌��������
			                for (int i = selectedIndex+1; i < selServices.size(); i++) {
			                    VRMap destService = (VRMap) selServices.get(i);
			                    Object destServiceDate = destService.get("SERVICE_DATE"); // 2017/06/26 add
			                    if (destServiceDate == null) continue; // 2017/06/26 add
			                    Date destDate = ACCastUtilities.toDate(destServiceDate);
			                    String destSystemServiceKindDetail = ACCastUtilities.toString(destService.get("SYSTEM_SERVICE_KIND_DETAIL"), "");
			                    // ���t�ƃT�[�r�X��ރR�[�h�������ꍇ
			                    if (srcDate.equals(destDate) && srcSystemServiceKindDetail.equals(destSystemServiceKindDetail)){
			                    	// �T�[�r�XID���폜
			                    	destService.remove("SERVICE_ID");
			                    }
			                }
	                	}
	                }
                }
                // 2013/10/12 [Shinobu_Hitaka] add - end
                
                
                // 2008/01/25 [Masahiko_Higuchi] del - begin
                // �T�[�r�X�p�^�[���ݒ�{�^��������s���G���[�Ή�
                // setServiceModify(true);
                // 2008/01/25 [Masahiko_Higuchi] del - end

                if (getSelectedServiceListBox() != null) {
                    getSelectedServiceListBox().setSelectedIndex(selectedIndex);
                    // 2008/01/25 [Masahiko_Higuchi] add - begin
                    // �T�[�r�X�p�^�[���ݒ�{�^��������s���G���[�Ή�
                    if (getSelectedServiceListBox() != getPatternList()) {
                        setServiceModify(true);
                    }
                    // 2008/01/25 [Masahiko_Higuchi] add - end
                }

                if (getWeeklyPanel() != null) {
                    getWeeklyPanel().invalidate();
                    getWeeklyPanel().repaint();
                }
                if (getMonthlyPanel() != null) {
                    getMonthlyPanel().invalidate();
                    getMonthlyPanel().repaint();
                }
                if (getPatternList() != null) {
                    getPatternList().invalidate();
                    getPatternList().repaint();
                }

            }
        }

    }

    /**
     * �u�T�[�r�X���폜�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void serviceDeleteActionPerformed(ActionEvent e) throws Exception {
        // ���T�ԕ\�E���ԕ\��̃T�[�r�X���̍폜
        // ���T�ԕ\�E���ԕ\��őI������Ă���A�T�[�r�X�����폜����B
        removeSelectedService();
    }

    /**
     * �u�T�ԕ\�E���ԕ\�̐ؑցv�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void changeChartActionPerformed(ActionEvent e) throws Exception {
        // ���T�ԕ\�E���ԕ\�̕\���ؑ�
        if (getWeeklyPanel().isVisible()) {
            // �@���ݕ\������Ă���̂��T�ԕ\�̏ꍇ
            // �@�@���ԕ\�\���������s���B
            showMonthly();
        } else {
            // �@���ݕ\������Ă���̂����ԕ\�̏ꍇ
            // �@�@�T�ԕ\�\���������s���B
            showWeekly();
        }
        clearServiceSelection();
    }

    public static void main(String[] args) {
        // �f�t�H���g�f�o�b�O�N��
        ACFrame.getInstance().setFrameEventProcesser(
                new QkanFrameEventProcesser());
        QkanCommon.debugInitialize();

        // �e�X�g�p�����^
        VRMap param = new VRHashMap();
        // param.setData("TARGET_DATE", new Date(106,0,8));
        QkanSystemInformation.getInstance().setLoginProviderID("5555555555");
        param.setData("TARGET_DATE", new Date(106, 3, 1));
        // param.setData("PATIENT_ID", new Integer(38));
        param.setData("PATIENT_ID", new Integer(51));
        param.setData("PROCESS_TYPE", new Integer(
                QkanConstants.PROCESS_TYPE_PLAN));
        // param.setData("PROCESS_TYPE", new
        // Integer(QkanConstants.PROCESS_TYPE_RESULT));

        ACFrame.debugStart(new ACAffairInfo(QS001.class.getName(), param));
    }

    // �����֐�

    /**
     * �u���̓`�F�b�N�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public boolean checkValidInput() throws Exception {
        VRList list = new VRArrayList();
        list.addAll(getMonthlyPanel().getSchedule(
                QkanConstants.SERVICE_DETAIL_GET_RESULT, false));
        Iterator it = list.iterator();

        // �����̓`�F�b�N
        final String[] SENMONIN_NO_TYPE = new String[] { "1430107", "1730104",
                "1750104", "1460103", "1770116" };
        
        // ������`�F�b�N�̖h�~
        boolean doubleCheck_15111 = false;
        boolean doubleCheck_15411 = false;
        
        
        // 2016/10 [Yoichiro Kamei] add - begin �������ƓƎ��Ή�
        QkanSjInsurerChecker sjInsurerChecker = new QkanSjInsurerChecker(getCalcurater());
        boolean isSogoAdjudtUnitCheck = false; //�������Ƃ̒����z�̃`�F�b�N���s�����ǂ���
        // 2016/10 [Yoichiro Kamei] add - begin �������ƓƎ��Ή�
        
        // 2017/06 [Yoichiro Kamei] add - begin AF�Ή�
        boolean isAfExists = false; //AF���o�^����Ă��邩�ǂ���
        boolean isGendogakuYoboSvExists = false; //���x�z�Ǘ��Ώۂ̗\�h�T�[�r�X���o�^����Ă��邩�ǂ���
        // 2017/06 [Yoichiro Kamei] add - end AF�Ή�
        
        // �\�h���Ή��i�v�]�j
        // 2005/05/31
        // �����x�������ԍ��������͂̏ꍇ�̖����̓`�F�b�N
        while (it.hasNext()) {
            // [ID:0000483][Masahiko Higuchi] 2009/04 edit begin ����21�N4���@�����Ή�
            Object loopObj = it.next();
            // �s���f�[�^�`�F�b�N
            if (!(loopObj instanceof VRMap)) {
                continue;
            }
            // VRMap�Ŏ擾
            VRMap row = (VRMap) loopObj;
            // [ID:0000483][Masahiko Higuchi] 2009/04 edit end
            if (CareServiceCommon.isCareManagement(row)
                    || CareServiceCommon.isFacilityVisitMultifunction(row)) {
                // �������{�錾
                boolean isInputSenmoninNo = false;
                // ���x�������ԍ��̐��������[�v����
                for (int i = 0; i < SENMONIN_NO_TYPE.length; i++) {
                    Object obj = VRBindPathParser.get(SENMONIN_NO_TYPE[i], row);
                    // ���x�������ԍ��e�L�X�g�̏�Ԃ𑖍�
                    if (!ACTextUtilities.isNullText(obj)) {
                        isInputSenmoninNo = true;
                        // �����𔲂���
                        break;
                    }
                }
                // �����ԍ������͂���Ă��Ȃ������ꍇ
                if (!isInputSenmoninNo) {
                    // �G���[���b�Z�[�W��\������B
                    if (QkanMessageList.getInstance()
                            .QS001_WARNING_OF_SENMONIN_NO() == ACMessageBox.RESULT_OK) {
                        // 1�x���b�Z�[�W���o����������o���Ȃ�
                        break;
                    } else {
                        // OK�ȊO�͏����𒆎~
                        return false;
                    }

                }
            }
            int lowVer = CareServiceCommon.getServiceLowVersion(row);
            
// 2014/1/9 [Yoichiro Kamei] mod - begin H27.4�����Ή�
//            // ����24�N4���ȍ~�̏ꍇ
//            // �@�����敪�ɂ��ߋ��f�[�^�̔���
//            if (lowVer != QkanConstants.SERVICE_LOW_VERSION_H2404) {
//                // �@�����敪��20090401�ȊO�̃T�[�r�X�̏ꍇ
            // ����27�N4���ȍ~�̏ꍇ
            // �@�����敪�ɂ��ߋ��f�[�^�̔���
            if (lowVer != QkanConstants.SERVICE_LOW_VERSION_H2704) {
                // �@�����敪��20150401�ȊO�̃T�[�r�X�̏ꍇ
// 2014/1/9 [Yoichiro Kamei] mod - end
                Date serviceDate = ACCastUtilities.toDate(
                        VRBindPathParser.get("SERVICE_DATE", row), null);
                String dayOfMonth = "";
                if (serviceDate != null) {
                    dayOfMonth = ACDateUtilities.getDayOfMonth(serviceDate)
                            + "����";
                }
                VRMap serviceKind = ACBindUtilities.getMatchRowFromValue(
                        getServiceKindsList(), "SYSTEM_SERVICE_KIND_DETAIL",
                        row.get("SYSTEM_SERVICE_KIND_DETAIL"));
                String serviceKindName = "�T�[�r�X";
                if (serviceKind != null) {
                    serviceKindName = ACCastUtilities.toString(serviceKind
                            .get("SERVICE_ABBREVIATION"));
                }
                // �G���[���b�Z�[�W
                QkanMessageList.getInstance()
                        .QS001_ERROR_OF_INVALID_SERVICE_LOW_VERSION(dayOfMonth,
                                serviceKindName);
                return false;
            }

            // ���V�l�����{�݂̏ꍇ
            if ("15111".equals(ACCastUtilities.toString(VRBindPathParser.get(
                    "SYSTEM_SERVICE_KIND_DETAIL", row)))) {
                // ���퐶���p���x��
                if (ACCastUtilities.toInt(row.getData("1510133"), 0) > 1 && !doubleCheck_15111) {
                    // �T�[�r�X�񋟑̐��������Z���Z�肳��Ă���
                    if (ACCastUtilities.toInt(row.getData("1510141"), 0) > 1) {
                        if (QkanMessageList.getInstance()
                                .QO004_WARNING_OF_DOUBLE_CHECK(
                                        "���퐶���p���x�����Z�ƃT�[�r�X�񋟑̐��������Z�̗���") != ACMessageBox.RESULT_OK) {
                            // �G���[
                            return false;

                        }
                        doubleCheck_15111 = true;
                    }
                }
            } else if ("15411".equals(ACCastUtilities.toString(VRBindPathParser
                    .get("SYSTEM_SERVICE_KIND_DETAIL", row)))) {
                // �n�斧���^���V�l�����{��
                // ���퐶���p���x��
                if (ACCastUtilities.toInt(row.getData("1540129"), 0) > 1 && !doubleCheck_15411) {
                    // �T�[�r�X�񋟑̐��������Z���Z�肳��Ă���
                    if (ACCastUtilities.toInt(row.getData("1540136"), 0) > 1) {
                        if (QkanMessageList.getInstance()
                                .QO004_WARNING_OF_DOUBLE_CHECK(
                                        "���퐶���p���x�����Z�ƃT�[�r�X�񋟑̐��������Z�̗���") != ACMessageBox.RESULT_OK) {
                            // �G���[
                            return false;

                        }
                        doubleCheck_15411 = true;
                    }
                }
            }
            // [H28.4�@�����Ή�][Shinobu Hitaka] 2016/01/29 add begin 
            // �Ώ۔N����H28.4�ȍ~�́A���L�T�[�r�X��ނɂ� 1:���K�͌^,5:�×{ ��NG�Ƃ���
            // 15:�ʏ����̎{�݋敪(115113), 33:�O�����p�ʏ����̎{�݋敪(1330126)
            if (ACDateUtilities.getDifferenceOnMonth(getTargetDate(),ACDateUtilities.createDate(2016, 4)) >= 0) {
                int kubun = 0;
                if ("11511".equals(ACCastUtilities.toString(VRBindPathParser
                        .get("SYSTEM_SERVICE_KIND_DETAIL", row)))) {
                    kubun = ACCastUtilities.toInt(row.getData("1150113"), 0);
                }
                if ("13311".equals(ACCastUtilities.toString(VRBindPathParser
                        .get("SYSTEM_SERVICE_KIND_DETAIL", row)))) {
                    kubun = ACCastUtilities.toInt(row.getData("1330126"), 0);
                }

                // �{�݋敪���u1:���K�͌^�v�u5:�×{�v�͐ݒ�s��
                if (kubun == 1 || kubun == 5) {
                    Date serviceDate = ACCastUtilities.toDate(
                    	    VRBindPathParser.get("SERVICE_DATE", row), null);
                    String dayOfMonth = "";
                    if (serviceDate != null) {
                        dayOfMonth = ACDateUtilities.getDayOfMonth(serviceDate) + "����";
                    }
                    VRMap serviceKind = ACBindUtilities.getMatchRowFromValue(
                            getServiceKindsList(), "SYSTEM_SERVICE_KIND_DETAIL",
                            row.get("SYSTEM_SERVICE_KIND_DETAIL"));
                    String serviceKindName = "�T�[�r�X";
                    if (serviceKind != null) {
                        serviceKindName = ACCastUtilities.toString(serviceKind
                                .get("SERVICE_ABBREVIATION"));
                        }
                    // �G���[���b�Z�[�W
                    QkanMessageList.getInstance()
                        .QS001_ERROR_OF_INVALID_SERVICE_LOW_VERSION(dayOfMonth,
                                serviceKindName);
                    return false;
                    }
            }
            // [H28.4�@�����Ή�][Shinobu Hitaka] 2016/01/29 add end 
            
            // 2016/10 [Yoichiro Kamei] add - begin �������ƓƎ��Ή�
            String skind = ACCastUtilities.toString(row.get("SYSTEM_SERVICE_KIND_DETAIL"), "");
            if (QkanSjServiceCodeManager.dokujiTeiritsuTeigakuCodes.contains(skind)) {
                // �Z��\�ȕی��҂̃R�[�h���`�F�b�N
                try {
                    sjInsurerChecker.checkCodes(row);
                } catch (QkanSjInsurerException e) {
                    Date serviceDate = ACCastUtilities.toDate(row.get("SERVICE_DATE"), null);
                    String dayOfMonth = "";
                    if (serviceDate != null) {
                        dayOfMonth = ACDateUtilities.getDayOfMonth(serviceDate) + "����";
                    }
                    // �T�[�r�X�R�[�h
                    Map code = e.getCode();
                    String svCode = 
                    ACCastUtilities.toString(code.get("SERVICE_CODE_KIND"), "") + "-" +
                    ACCastUtilities.toString(code.get("SERVICE_CODE_ITEM"), "");

                    String svCodedName = "�R�[�h: [" + svCode+ "] ";
                    String addMsg =  "���e���m�F���Ă��������B";
                    if (e.isTukitotyuJushotiTokurei()) {
                        if ("3".equals(ACCastUtilities.toString(code.get("TOTAL_GROUPING_TYPE"), ""))) {
                            addMsg = "���r���Z���n����̏ꍇ�A���z�T�[�r�X�́A�������_�̕ی��҂̃T�[�r�X��ݒ肵�Ă��������B";
                        }
                    }
                    // �G���[���b�Z�[�W
                    QkanMessageList.getInstance().QS001_ERROR_OF_INVALID_INSURER_ID(dayOfMonth, svCodedName, addMsg);
                    return false;
                }
                // �Ǝ��E�Ǝ��藦�E�Ǝ���z�T�[�r�X�̓o�^�������āA
                // �v��P�ʐ������͂���Ă���ꍇ�A���ѕۑ����ɒ����z�̃`�F�b�N���s��
                VRMap planUnits = getMonthlyPanel().getPlanUnits();
                if ((planUnits != null) && (!planUnits.isEmpty())) {
                    isSogoAdjudtUnitCheck = true;
                }
            }
            // 2016/10 [Yoichiro Kamei] add - end
            
            
            // 2017/06 [Yoichiro Kamei] add - begin AF�Ή�
            // AF���o�^����Ă���ꍇ
            if (QkanSjServiceCodeManager.afCodes.contains(skind)) {
            	isAfExists = true;
            }            
            // 2017/06 [Yoichiro Kamei] add - end
            
        }

        // ���񐔃`�F�b�N
        // �Ώ۔N�����A����21�N4���ȍ~�̏ꍇ
        // ��������x���E�񐔃`�F�b�N

        // ������x���̌��o�񐔂�\�����l�ϐ�countOf14311���`���A0�ŏ���������B
        int countOf14311 = 0;
        // ���\�h�x���̌��o�񐔂�\�����l�ϐ�countOf14611���`���A0�ŏ���������B
        int countOf14611 = 0;
        final String BIND_PATH_OF_SYSTEM_SERVICE_KIND_DETAIL = "SYSTEM_SERVICE_KIND_DETAIL";

        // ���ԕ\��̃T�[�r�X��S��������B
        it = list.iterator();
        while (it.hasNext()) {
            VRMap row = (VRMap) it.next();
            // �G���[�ƂȂ����T�[�r�X����\��������ϐ�errorService���`���Anull�ŏ���������B
            String errorService = null;
            switch (ACCastUtilities.toInt(VRBindPathParser.get(
                    BIND_PATH_OF_SYSTEM_SERVICE_KIND_DETAIL, row), 0)) {
            case 14311:
                // [ID:0000702][Masahiko.Higuchi] 2012/03 ����24�N4���@�����Ή� edit begin
                // �T�[�r�X��������x���̏ꍇ ���� ��{�Z��̏ꍇ
                // countOf14311��1�����Z����B
                if ((ACCastUtilities.toInt(row.getData("9"),1) == 1) && ++countOf14311 >= 2) {
                    // countOf14311��2�ȏ�̏ꍇ
                    // errorService��"������x��"��������B
                    errorService = "������x��";
                }
                // [ID:0000702][Masahiko.Higuchi] 2012/03 edit end
                break;
            case 14611:
                // �T�[�r�X�����\�h�x���̏ꍇ
                // countOf14611��1�����Z����B
                if (++countOf14611 >= 2) {
                    // countOf14611��2�ȏ�̏ꍇ
                    // errorService��"���\�h�x��"��������B
                    errorService = "���\�h�x��";
                }
                break;
            }
            if (errorService != null) {
                // errorService��null�ł͂Ȃ��ꍇ
                // ����񐔂𒴂��Ă���|�̃G���[(ERROR_OF_SERVICE_COUNT_OVER)��\������B
                QkanMessageList.getInstance()
                        .QS001_ERROR_OF_SERVICE_COUNT_OVER(errorService,
                                new Integer(1));
                // �߂�lfalse��Ԃ��ď������I������B
                return false;
            }
        }

        // �����̑��̉񐔒��ߌx���`�F�b�N
        int[] countOf50111 = {0, 0, 0, 0};
        int[] countOf50211 = {0, 0, 0, 0};
        int[] countOf50511 = {0, 0};
        int[] countOf50611 = {0, 0};
        String sogoErrorService = null;

        // ��n�������Ƃ�����Z
        String[][] monthlyAddCountChecks = new String[][] {
                // SERVICE_NAME,SYSTEM_SERVICE_KIND_DETAIL,���Z��,SYSTEM_BIND_PATH,�v�シ��l,���
                // ���ʏ����E�ʏ����n�E�F�m�ǑΉ��^�ʏ����E�n�斧���^�ʏ����iH28.4 �����j
                // �h�{���P���Z�F��2��
                // ���o�@�\�F��2��
                { "�ʏ����", "11511", "�h�{���P���Z", "1150116", "2", "2", },
                { "�ʏ����", "11511", "���o�@�\������Z", "1150112", "2", "2", },
                { "�ʏ����n", "11611", "�h�{���P���Z", "1160114", "2", "2", },
                { "�ʏ����n", "11611", "���o�@�\������Z", "1160115", "2", "2", },
                { "�F�m�ǑΉ��^�ʏ����", "17211", "�h�{���P���Z", "1720105", "2", "2", },
                { "�F�m�ǑΉ��^�ʏ����", "17211", "���o�@�\������Z", "1720108", "2", "2", },
                { "�n�斧���^�ʏ����", "17811", "�h�{���P���Z", "1780110", "2", "2", },
                { "�n�斧���^�ʏ����", "17811", "���o�@�\������Z", "1780111", "2", "2", },
                // ���ʏ����n
                // �ʃ��n���Z�F��13��
                { "�ʏ����n", "11611", "�ʃ��n�r�����{���Z", "1160118", "2", "13", },
        // ��������x��
        // ��ØA�g���Z�F��1��(������x�����́A�Ђƌ���2�z�u������G���[�ɂȂ�)
        // {"������x��","14311","��Ë@�֘A�g���Z","1430109","2","1",},
        };
        // �Tn�������Ƃ���T�[�r�X
        String[][] weeklyServiceCountChecks = new String[][] {
        // SERVICE_NAME,SYSTEM_SERVICE_KIND_DETAIL,���
        // ���K�⃊�n
        // 1�T�Ԃ�6��
        { "�K�⃊�n", "11411", "6", }, };

        // ��n��������Ƃ�����Z
        String[][] monthlyDayAddCountChecks = new String[][] {
                // SERVICE_NAME,SYSTEM_SERVICE_KIND_DETAIL,���Z��,SYSTEM_BIND_PATH,�v�シ��l,���
                // �����{�E�V���E�×{�^
                // �O���F��6��
                { "���V�l�����{��", "15111", "�O�����Z", "1510111", "2", "6", },
                { "���V�l�ی��{��", "15211", "�O�����Z", "1520107", "2", "6", },
                { "���×{�^��Î{��(�a�@�×{�^)", "15311", "�O�����Z", "1530108", "2", "6", },
                { "���×{�^��Î{��(�f�Ï��^)", "15312", "�O�����Z", "1530206", "2", "6", },
                { "���×{�^��Î{��(�F�m�ǎ����^)", "15313", "�O�����Z", "1530305", "2", "6", }, };
        int[] monthlyAddCountResults = new int[monthlyAddCountChecks.length];
        int[][] weeklyServiceCountResults = new int[weeklyServiceCountChecks.length][7];
        int[] monthlyDayAddCountResults = new int[monthlyDayAddCountChecks.length];
        boolean[][] monthlyDayAddFindFlags = new boolean[monthlyDayAddCountChecks.length][32];

        int end;
        end = monthlyAddCountChecks.length;
        for (int i = 0; i < end; i++) {
            monthlyAddCountResults[i] = ACCastUtilities
                    .toInt(monthlyAddCountChecks[i][5]);
        }
        end = weeklyServiceCountChecks.length;
        for (int i = 0; i < end; i++) {
            int limit = ACCastUtilities.toInt(weeklyServiceCountChecks[i][2]);
            for (int j = 0; j < 7; j++) {
                weeklyServiceCountResults[i][j] = limit;
            }
        }
        end = monthlyDayAddCountChecks.length;
        for (int i = 0; i < end; i++) {
            monthlyDayAddCountResults[i] = ACCastUtilities
                    .toInt(monthlyDayAddCountChecks[i][5]);
        }

        // ���ԕ\��̃T�[�r�X��S��������B
        it = list.iterator();
        while (it.hasNext()) {
            VRMap row = (VRMap) it.next();

            String systemServiceKindDetail = ACCastUtilities
                    .toString(VRBindPathParser.get(
                            "SYSTEM_SERVICE_KIND_DETAIL", row));
            Date visitDay = ACCastUtilities.toDate(
                    VRBindPathParser.get("SERVICE_DATE", row), null);

            // �x�����b�Z�[�W�̗v�f�Ƃ��Ĉȉ��̕�����ϐ����`��null�ŏ���������B
            // warningTargetName
            String warningTargetName = null;
            // warningTargetSpan
            String warningTargetSpan = null;
            // warningTargetLimit
            String warningTargetLimit = null;

            // ��n�������Ƃ�����Z���`�F�b�N����B
            end = monthlyAddCountChecks.length;
            for (int i = 0; i < end; i++) {
                if (monthlyAddCountChecks[i][1].equals(systemServiceKindDetail)) {
                    // �V�X�e���T�[�r�X��ނ��Y�������ꍇ
                    Object val = VRBindPathParser.get(
                            monthlyAddCountChecks[i][3], row);
                    if (val != null) {
                        // BindPath���Y�������ꍇ
                        if (monthlyAddCountChecks[i][4].equals(ACCastUtilities
                                .toString(val))) {
                            // �v�シ�ׂ��l���Y�������ꍇ
                            // ���P�ʉ��Z�c�񐔂�1�����Z����B
                            monthlyAddCountResults[i]--;
                            if (monthlyAddCountResults[i] == -1) {
                                // ���P�ʉ��Z�c�񐔂�0����������ꍇ

                                // �x�����b�Z�[�W�̗v�f�Ƃ��Ĉȉ��̕ϐ���������B
                                // warningTargetName = SERVICE_NAME+"��"+���Z��
                                warningTargetName = monthlyAddCountChecks[i][0]
                                        + "��" + monthlyAddCountChecks[i][2];
                                // warningTargetName = "�Ђƌ���"
                                warningTargetSpan = "�Ђƌ���";
                                // warningTargetLimit = ���+"��܂�"
                                warningTargetLimit = monthlyAddCountChecks[i][5]
                                        + "��܂�";

                                // �x�����b�Z�[�WQS001_WARNING_OF_SERVICE_COUNT_OVER��\������B
                                if (QkanMessageList.getInstance()
                                        .QS001_WARNING_OF_SERVICE_COUNT_OVER(
                                                warningTargetName,
                                                warningTargetSpan,
                                                warningTargetLimit) != ACMessageBox.RESULT_OK) {
                                    // �uOK�v�ȊO�I����
                                    // �߂�l�Ƃ���false��Ԃ��B
                                    return false;
                                }
                            }
                        }
                    }
                }
            }

            // �Tn�������Ƃ���T�[�r�X���`�F�b�N����B
            end = weeklyServiceCountChecks.length;
            for (int i = 0; i < end; i++) {
                if (weeklyServiceCountChecks[i][1]
                        .equals(systemServiceKindDetail)) {
                    // �V�X�e���T�[�r�X��ނ��Y�������ꍇ
                    if (visitDay != null) {
                        // �T�P�ʉ��Z�c�񐔂̓��Y�T�ڂ�1�����Z����B
                        int week = ACDateUtilities.getWeekOfMonth(visitDay);
                        weeklyServiceCountResults[i][week]--;
                        if (weeklyServiceCountResults[i][week] == -1) {
                            // �T�P�ʎc�񐔂�0����������ꍇ

                            // �x�����b�Z�[�W�̗v�f�Ƃ��Ĉȉ��̕ϐ���������B
                            // warningTargetName = SERVICE_NAME
                            warningTargetName = weeklyServiceCountChecks[i][0];
                            // warningTargetName = "�e�T��"
                            warningTargetSpan = "�e�T��";
                            // warningTargetLimit = ���+"��܂�"
                            warningTargetLimit = weeklyServiceCountChecks[i][2]
                                    + "��܂�";

                            // �x�����b�Z�[�WQS001_WARNING_OF_SERVICE_COUNT_OVER��\������B
                            if (QkanMessageList.getInstance()
                                    .QS001_WARNING_OF_SERVICE_COUNT_OVER(
                                            warningTargetName,
                                            warningTargetSpan,
                                            warningTargetLimit) != ACMessageBox.RESULT_OK) {
                                // �uOK�v�ȊO�I����
                                // �߂�l�Ƃ���false��Ԃ��B
                                return false;
                            }
                        }
                    }
                }
            }

            // ��n��������Ƃ�����Z���`�F�b�N����B
            end = monthlyDayAddCountChecks.length;
            for (int i = 0; i < end; i++) {
                if (monthlyDayAddCountChecks[i][1]
                        .equals(systemServiceKindDetail)) {
                    // �V�X�e���T�[�r�X��ނ��Y�������ꍇ
                    Object val = VRBindPathParser.get(
                            monthlyDayAddCountChecks[i][3], row);
                    if (val != null) {
                        // BindPath���Y�������ꍇ
                        if (monthlyDayAddCountChecks[i][4]
                                .equals(ACCastUtilities.toString(val))) {
                            // �v�シ�ׂ��l���Y�������ꍇ
                            int mday = ACDateUtilities.getDayOfMonth(visitDay);
                            if (!monthlyDayAddFindFlags[i][mday]) {
                                // ���P�ʓ��ʉ��Z�����t���O�̓��Y�����U(������)�̏ꍇ
                                // ���P�ʓ��ʉ��Z�����t���O�̓��Y����^(������)�ɂ���B
                                monthlyDayAddFindFlags[i][mday] = true;
                                // ���P�ʓ��ʉ��Z�c�񐔂�1�����Z����B
                                monthlyDayAddCountResults[i]--;
                                if (monthlyDayAddCountResults[i] == -1) {
                                    // ���P�ʓ��ʉ��Z�c�񐔂�0����������ꍇ

                                    // �x�����b�Z�[�W�̗v�f�Ƃ��Ĉȉ��̕ϐ���������B
                                    // warningTargetName =
                                    // SERVICE_NAME+"��"+���Z��
                                    warningTargetName = monthlyDayAddCountChecks[i][0]
                                            + "��"
                                            + monthlyDayAddCountChecks[i][2];
                                    // warningTargetName = "�Ђƌ���"
                                    warningTargetSpan = "�Ђƌ���";
                                    // warningTargetLimit = ���+"���܂�"
                                    warningTargetLimit = monthlyDayAddCountChecks[i][5]
                                            + "���܂�";

                                    // �x�����b�Z�[�WQS001_WARNING_OF_SERVICE_COUNT_OVER��\������B
                                    if (QkanMessageList
                                            .getInstance()
                                            .QS001_WARNING_OF_SERVICE_COUNT_OVER(
                                                    warningTargetName,
                                                    warningTargetSpan,
                                                    warningTargetLimit) != ACMessageBox.RESULT_OK) {
                                        // �uOK�v�ȊO�I����
                                        // �߂�l�Ƃ���false��Ԃ��B
                                        return false;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            
            // [H27.4�@�����Ή�][Shinobu Hitaka] 2016/07/19 add begin �������Ɓi�݂Ȃ��E�Ǝ��j�Ή�
            if ("50111".equals(systemServiceKindDetail)) {
                // �K��^�T�[�r�X�i�݂Ȃ��j�̉񐔃`�F�b�N
                if (ACCastUtilities.toInt(row.getData("5010101"),1) == 4) {
                    countOf50111[0]++;
                    if (countOf50111[0] > 4) {
                        warningTargetName = "�K��^�T�[�r�XIV ";
                        warningTargetSpan = "�Ђƌ���";
                        warningTargetLimit = "4��܂�";
                    }
                } else if (ACCastUtilities.toInt(row.getData("5010101"),1) == 5) {
                    countOf50111[1]++;
                    if (countOf50111[1] > 8) {
                        warningTargetName = "�K��^�T�[�r�XV ";
                        warningTargetSpan = "�Ђƌ���";
                        warningTargetLimit = "5�񂩂�8��܂�";
                    }
                } else if (ACCastUtilities.toInt(row.getData("5010101"),1) == 6) {
                    countOf50111[2]++;
                    if (countOf50111[2] > 12) {
                        warningTargetName = "�K��^�T�[�r�XVI ";
                        warningTargetSpan = "�Ђƌ���";
                        warningTargetLimit = "9�񂩂�12��܂�";
                    }
                } else if (ACCastUtilities.toInt(row.getData("5010101"),1) == 7) {
                    countOf50111[3]++;
                    if (countOf50111[3] > 22) {
                        warningTargetName = "�K��^�Z���ԃT�[�r�X";
                        warningTargetSpan = "�Ђƌ���";
                        warningTargetLimit = "22��܂�";
                    }
                }
            } else if ("50211".equals(systemServiceKindDetail)) {
                // �K��^�T�[�r�X�i�Ǝ��j�̉񐔃`�F�b�N
                // �Z��敪�F�ʏ�
                if (ACCastUtilities.toInt(row.getData("9"),1) == 1) {
                    if (ACCastUtilities.toInt(row.getData("5020101"),1) == 4) {
                        countOf50211[0]++;
                        if (countOf50211[0] > 4) {
                            warningTargetName = "�K��^�Ǝ��T�[�r�XIV ";
                            warningTargetSpan = "�Ђƌ���";
                            warningTargetLimit = "4��܂�";
                        }
                    } else if (ACCastUtilities.toInt(row.getData("5020101"),1) == 5) {
                        countOf50211[1]++;
                        if (countOf50211[1] > 8) {
                            warningTargetName = "�K��^�Ǝ��T�[�r�XV ";
                            warningTargetSpan = "�Ђƌ���";
                            warningTargetLimit = "5�񂩂�8��܂�";
                        }
                    } else if (ACCastUtilities.toInt(row.getData("5020101"),1) == 6) {
                        countOf50211[2]++;
                        if (countOf50211[2] > 12) {
                            warningTargetName = "�K��^�Ǝ��T�[�r�XVI ";
                            warningTargetSpan = "�Ђƌ���";
                            warningTargetLimit = "9�񂩂�12��܂�";
                        }
                    } else if (ACCastUtilities.toInt(row.getData("5020101"),1) == 7) {
                        countOf50211[3]++;
                        if (countOf50211[3] > 22) {
                            warningTargetName = "�K��^�Ǝ��Z���ԃT�[�r�X";
                            warningTargetSpan = "�Ђƌ���";
                            warningTargetLimit = "22��܂�";
                        }
                    }
                }
            } else if ("50511".equals(systemServiceKindDetail)) {
                // �ʏ��^�T�[�r�X�i�݂Ȃ��j�̉񐔃`�F�b�N
                // �Z��敪�F�ʏ� �� ��
                if (ACCastUtilities.toInt(row.getData("9"),1) == 1 && ACCastUtilities.toInt(row.getData("5050102"),1) == 2) {
                    if (ACCastUtilities.toInt(row.getData("5050101"),1) == 1) {
                        // �T�[�r�X�P
                        countOf50511[0]++;
                        if (countOf50511[0] > 4) {
                            warningTargetName = "�ʏ��^�T�[�r�X�P��";
                            warningTargetSpan = "�Ђƌ���";
                            warningTargetLimit = "4��܂�";
                        }
                    } else if (ACCastUtilities.toInt(row.getData("5050101"),1) == 2) {
                        // �T�[�r�X�Q
                        countOf50511[1]++;
                        if (countOf50511[1] > 8) {
                            warningTargetName = "�ʏ��^�T�[�r�X�Q��";
                            warningTargetSpan = "�Ђƌ���";
                            warningTargetLimit = "5�񂩂�8��܂�";
                        }
                    }
                }
            } else if ("50611".equals(systemServiceKindDetail)) {
                // �ʏ��^�T�[�r�X�i�Ǝ��j�̉񐔃`�F�b�N
                // �Z��敪�F�ʏ� �� ��
                if (ACCastUtilities.toInt(row.getData("9"),1) == 1 && ACCastUtilities.toInt(row.getData("5060102"),1) == 2) {
                    if (ACCastUtilities.toInt(row.getData("5060101"),1) == 1) {
                        // �T�[�r�X�P
                        countOf50611[0]++;
                        if (countOf50611[0] > 4) {
                            warningTargetName = "�ʏ��^�Ǝ��T�[�r�X�P��";
                            warningTargetSpan = "�Ђƌ���";
                            warningTargetLimit = "4��܂�";
                        }
                    } else if (ACCastUtilities.toInt(row.getData("5060101"),1) == 2) {
                        // �T�[�r�X�Q
                        countOf50611[1]++;
                        if (countOf50611[1] > 8) {
                            warningTargetName = "�ʏ��^�Ǝ��T�[�r�X�Q��";
                            warningTargetSpan = "�Ђƌ���";
                            warningTargetLimit = "5�񂩂�8��܂�";
                        }
                    }
                }
            }
            // �x�����b�Z�[�WQS001_WARNING_OF_SERVICE_COUNT_OVER��\������B
            if  (warningTargetName != null) {
                if (QkanMessageList.getInstance()
                        .QS001_WARNING_OF_SERVICE_COUNT_OVER(
                                warningTargetName,
                                warningTargetSpan,
                                warningTargetLimit) != ACMessageBox.RESULT_OK) {
                    // �uOK�v�ȊO�I����
                    // �߂�l�Ƃ���false��Ԃ��B
                    return false;
                }
            }
            // [H27.4�@�����Ή�][Shinobu Hitaka] 2016/07/19 add end
        }

        // �񐔊֘A�̃`�F�b�N���S�ďI�������ɔF�藚���̗��ރ`�F�b�N
        VRList patientInsureInfoHistory = null;
        // �v���F�藚���̎擾
        patientInsureInfoHistory = QkanCommon.getPatientInsureInfoHistory(
                getDBManager(), getTargetDate(), getPatientID());
        // �������ɕ������𑶍݂��Ȃ��ꍇ�͏����I��
        if (patientInsureInfoHistory.size() >= 2) {
            VRList checkList = new VRArrayList();
            for (int i = 0; i < patientInsureInfoHistory.size(); i++) {
                // �������擾����
                VRMap history = (VRMap) patientInsureInfoHistory.getData(i);
                // �v���F�藚�����i�[���ēˍ�����
                checkList.add(ACCastUtilities.toString(
                        history.getData("JOTAI_CODE"), ""));
            }
            // �v���x�ω��̃`�F�b�N
            boolean isCheck = false;
            // ���[�v����
            for (int i = 1; i < checkList.size(); i++) {
                int beforeHistory = ACCastUtilities.toInt(checkList.get(i - 1),
                        0);
                int afterHistory = ACCastUtilities.toInt(checkList.get(i), 0);
                switch (beforeHistory) {
                case 12: // �v�x���P
                    switch (afterHistory) {
                    case 13: // �v�x���Q
                        isCheck = true;
                        break;
                    }
                    break;

                case 13: // �v�x���Q
                    switch (afterHistory) {
                    case 12: // �v�x���P
                        isCheck = true;
                        break;
                    }
                }
            }
            // �v���x�̕ω����m�肵���i�K�ŗ����擾
            if (isCheck) {
                VRMap history = (VRMap) patientInsureInfoHistory.getData(0);
                Date dayEndInsurer = null;
                Date dayEnd = ACCastUtilities.toDate(history
                        .getData("INSURE_VALID_END"));
                // �I�����̎擾
                if (ACDateUtilities.getMonth(getTargetDate()) == ACDateUtilities
                        .getMonth(dayEnd)) {
                    // �����̏ꍇ�͍̗p����
                    dayEndInsurer = ACCastUtilities.toDate(dayEnd);
                } else {
                    // �ŏI���ɕϊ�
                    dayEndInsurer = ACDateUtilities
                            .toLastDayOfMonth(getTargetDate());
                }

                boolean yoboTsukai[][] = new boolean[1][3];
                boolean yoboTsuri[][] = new boolean[1][3];
                // ���ԕ\��̃T�[�r�X��S��������B
                it = list.iterator();
                while (it.hasNext()) {
                    VRMap row = (VRMap) it.next();

                    String systemServiceKindDetail = ACCastUtilities
                            .toString(VRBindPathParser.get(
                                    "SYSTEM_SERVICE_KIND_DETAIL", row));
                    Date visitDay = ACCastUtilities.toDate(
                            VRBindPathParser.get("SERVICE_DATE", row), null);
                    // �\�h�ʏ����
                    if ("16511".equals(systemServiceKindDetail)
                            && !yoboTsukai[0][2]) {
                        // 1650109 �T�[�r�X�񋟑̐��������Z������̏ꍇ
                        if (ACCastUtilities.toInt(row.getData("1650109"), 0) > 1) {
                            if (ACDateUtilities.getDifferenceOnDay(visitDay,
                                    dayEndInsurer) <= 0) {
                                // �������ŏ��̗���
                                yoboTsukai[0][0] = true;
                            } else {
                                // ����������̗���
                                yoboTsukai[0][1] = true;
                            }
                        }
                        // �x���o��
                        if (yoboTsukai[0][0] && yoboTsukai[0][1]) {
                            if (QkanMessageList.getInstance()
                                    .QS001_WARNING_OF_NINTEI_SERVICE("�v�x��",
                                            "�T�[�r�X�񋟑̐��������Z") == ACMessageBox.RESULT_OK) {
                                // OK�������͉��x���o�Ȃ��悤�ɂ���B
                                yoboTsukai[0][2] = true;
                            } else {
                                // �L�����Z���E�~�{�^��������
                                return false;
                            }
                        }
                    } else if ("16611".equals(systemServiceKindDetail)
                            && !yoboTsuri[0][2]) {
                        // �\�h�ʏ����n
                        // 1660108 �T�[�r�X�񋟑̐��������Z������̏ꍇ
                        if (ACCastUtilities.toInt(row.getData("1660108"), 0) > 1) {
                            if (ACDateUtilities.getDifferenceOnDay(visitDay,
                                    dayEndInsurer) <= 0) {
                                // �������ŏ��̗���
                                yoboTsuri[0][0] = true;
                            } else {
                                // ����������̗���
                                yoboTsuri[0][1] = true;
                            }
                        }
                        // �x���o��
                        if (yoboTsuri[0][0] && yoboTsuri[0][1]) {
                            if (QkanMessageList.getInstance()
                                    .QS001_WARNING_OF_NINTEI_SERVICE("�v�x��",
                                            "�T�[�r�X�񋟑̐��������Z") == ACMessageBox.RESULT_OK) {
                                // OK�������͉��x���o�Ȃ��悤�ɂ���B
                                yoboTsuri[0][2] = true;
                            } else {
                                // �L�����Z���E�~�{�^��������
                                return false;
                            }
                        }
                    }
                }
            }
        }
        
        // [H27.4�@�����Ή�][Shinobu Hitaka] 2015/02/27 add begin 68,69,79�̃T�[�r�X��ނ�5,6�������s�� --> 2017/06/16 del
        // �Ώ۔N����4���E5���A���A�V�X�e�����t��7�����O�̏ꍇ�`�F�b�N����
//        if ((ACDateUtilities.getDifferenceOnMonth(getTargetDate(),ACDateUtilities.createDate(2015, 6)) < 0)
//        		&& ACDateUtilities.getDifferenceOnMonth(QkanSystemInformation.getInstance().getSystemDate(), ACDateUtilities.createDate(2015, 7)) < 0) {
//	        // ���ԕ\��̃T�[�r�X��S��������B
//	        it = list.iterator();
//	        int errorServiceKind = 0;
//	        while (it.hasNext()) {
//	            VRMap row = (VRMap) it.next();
//	            // �G���[�ƂȂ����ꍇ�t���O�����Ă�B
//	            switch (ACCastUtilities.toInt(VRBindPathParser.get(
//	                    BIND_PATH_OF_SYSTEM_SERVICE_KIND_DETAIL, row), 0)) {
//	            case 16811:
//	            case 16911:
//	            case 17911:
//	            	errorServiceKind = 1;
//	            	break;
//	            }
//	        }
//	        if (errorServiceKind != 0) {
//		        if (QkanMessageList.getInstance()
//		                .QS001_WARNING_OF_CLAIM_STARTDATE() == ACMessageBox.RESULT_OK) {
//		        	// OK�������͏������s
//		        } else {
//		            // �L�����Z���E�~�{�^��������
//		            return false;
//		        }
//	        }
//        }
        // [H27.4�@�����Ή�][Shinobu Hitaka] 2015/02/27 add end

        // 2017/06 [Yoichiro Kamei] add - begin AF�Ή�
        // AF���o�^����Ă���ꍇ
        if (isAfExists) {
        	QkanSjAfChecker afChecker = new QkanSjAfChecker(getCalcurater(), QkanSjAfChecker.Mode.SERVICE_UPDATE);
        	it = list.iterator();

        	try {
            	while (it.hasNext()) {
                    VRMap row = (VRMap) it.next();
                    afChecker.checkCodes(row);
            	}
        	} catch (QkanSjAfException e) {
        		if (QkanSjAfException.Type.YOBO_GENDOGAKU_SV.equals(e.getType())) {
        	        // �G���[���b�Z�[�W��\������B
        	        if (QkanMessageList.getInstance()
        	                .QS001_WARNING_OF_SJ_AF_YOBO_GENDOGAKU_SV() != ACMessageBox.RESULT_OK) {
        	            // OK�ȊO�͏����𒆎~
        	            return false;
        	        }      			
        		} else if (QkanSjAfException.Type.YOBO_SHIEN_SV.equals(e.getType())) {
        	        // �G���[���b�Z�[�W��\������B
        	        if (QkanMessageList.getInstance()
        	                .QS001_ERROR_OF_SJ_AF_YOBO_SHIEN_SV() == ACMessageBox.RESULT_OK) {
        	            // �����𒆎~
        	            return false;
        	        }
        		}
        	}
        }            
        // 2017/06 [Yoichiro Kamei] add - end
        
        // 2016/10 [Yoichiro Kamei] add - begin �������ƓƎ��Ή�
        // ���ѕۑ����Ɍv��P�ʐ������͂���Ă���ꍇ
        if ((getProcessType() == QkanConstants.PROCESS_TYPE_RESULT) 
            && isSogoAdjudtUnitCheck) {
            try {
                // �����z��ݒ肷�邽�߂̈ꎞ�I��ID��t����
                Map<String, Object> updateKeyMap = new HashMap<String, Object>();
                for (int i = 0; i < list.size(); i++) {
                    VRMap service = (VRMap) list.get(i);
                    String id = String.valueOf(i); //ID�͘A��
                    service.put(QS001009Event.QS001009_UPDATE_KEY, id);
                    //��ōX�V�Ώۂ̃T�[�r�X��ID����擾���邽�߂Ɋi�[
                    updateKeyMap.put(id, service);
                }
                
                // �������� �Ǝ��E�Ǝ��藦�E�Ǝ���z�T�[�r�X�̒����z�ƌv��P�ʐ��̐������`�F�b�N
                CareServiceSummaryManager summary = new CareServiceSummaryManager(
                        getCalcurater(), getMonthlyPanel().getPatientInsureInfoHeaviest(),
                        getMonthlyPanel().getMonthlySchedule().getMasterService());
                
                // �f�[�^�̃N���[�����쐬����B
                VRList cloneServices = new VRArrayList();
                cloneServices.addAll(QkanValidServiceCommon.deepCopyVRList(list));
                summary.initialize(getCalcurater(), cloneServices);
                summary.parsePlanUnits(getMonthlyPanel().getPlanUnits());
                List<Map<String, Object>> ret = summary.checkAndAdjustUnits();
                if (!ret.isEmpty()) {
                    if (ACMessageBox.RESULT_OK == QkanMessageList.getInstance().QS001_WARNING_OF_SJ_LIMIT_OVER_UNIT_INCONSISTENT()) {
                        for (Map item : ret) {
                            Map source = (Map) item.get("PARSED_ROW");
                            int planUnit = ACCastUtilities.toInt(item.get("PLAN_UNIT"), 0);
                            summary.applyPlanUnit(source, planUnit);
                        }
                    } else {
                        QkanMessageList.getInstance().QS001_WARNING_OF_INPUT_SJ_LIMIT_OVER_UNIT();
                        return false;
                    }
                }
                Map<String, Integer> results = summary.getAdjustResults();
                // �T�[�r�X���X�V���ꂽ�ꍇ
                if (!results.isEmpty()) {
                    // ���͂��ꂽ�����z���T�[�r�X�ɔ��f������
                    for (String id : results.keySet()) {
                        int adjust = results.get(id);
                        VRMap service = (VRMap) updateKeyMap.get(id);
                        service.put("REGULATION_RATE", adjust);
                    }
                }
            } finally {
                // �����z��ݒ肷�邽�߂̈ꎞ�I��ID���폜����
                for (int i = 0; i < list.size(); i++) {
                    VRMap service = (VRMap) list.get(i);
                    service.remove(QS001009Event.QS001009_UPDATE_KEY);
                }
            }
        }
        // 2016/10 [Yoichiro Kamei] add - end
        
        it = list.iterator();

        // [ID:0000456][Masahiko Higuchi] 2009/03 edit begin ����21�N4���@�����Ή�
        int overFlowCount = 0;
        int overflowIndex = -1;

        // ������×{�Ǘ��w���E�񐔃`�F�b�N
        // ����×{�Ǘ��w���T�[�r�X�̃T�[�r�X�񐔂��`�F�b�N����(���ԕ\)�B���ꂼ��̏���񐔂͉��L�̂Ƃ���Ƃ���B
        // ��t�E���Ȉ�t : 2��
        // ��܎t(��Ë@��) : 2��
        // ��܎t(���) : 2��
        // �Ǘ��h�{�m : 2��
        // ���ȉq���m�� : 4��
        // �Ō�E���F1��
        // �K�������̏ꍇ�͈ȉ�������Ƃ���B
        // ��܎t(��Ë@��)�K������ : 4��
        // ��܎t(���)�K������ : 8��
        // ���T2��܂�

        final Integer VISITOR_TYPE_PATH = new Integer(1310111);
        final Integer GAN_PATH = new Integer(1310110);

        final int VISITOR_TYPE_COUNT = 8;
        // [�E���敪][��n�T]�̖K���
        int[][] weeklyCounts = new int[VISITOR_TYPE_COUNT][8];
        // [�E���敪]�̌��ԖK���
        int[] visitCounts = new int[VISITOR_TYPE_COUNT];
        // [�E���敪]�̂��񖖊��t���O
        int[] ganFlags = new int[VISITOR_TYPE_COUNT];

        while (it.hasNext()) {
            VRMap row = (VRMap) it.next();
            // ����×{�Ǘ��w���̐E���敪���擾
            Object obj = VRBindPathParser.get(VISITOR_TYPE_PATH, row);
            if (obj != null) {
                int idx = ACCastUtilities.toInt(obj, 0);
                // ���P�ʂ̖K���
                visitCounts[idx]++;

                Object gan = VRBindPathParser.get(GAN_PATH, row);
                if ("2".equals(ACCastUtilities.toString(gan))) {
                    // �K������
                    ganFlags[idx] = 1;
                }

                Date visitDay = ACCastUtilities.toDate(
                        VRBindPathParser.get("SERVICE_DATE", row), null);
                if (visitDay != null) {
                    // ��n�T�̖K���
                    weeklyCounts[idx][ACDateUtilities.getWeekOfMonth(visitDay)]++;
                }
            }
        }

        int[][] limits = new int[][] { {// �K���������܂܂Ȃ��ꍇ
                0,// �_�~�[
                        2, // ��t
                        2, // ���Ȉ�t
                        2, // ��܎t(��Ë@��)
                        4, // ��܎t(���)
                        2, // �Ǘ��h�{�m
                        4, // ���ȉq���m��
                        1, // �Ō�E��
                }, {// �K���������܂ޏꍇ
                0,// �_�~�[
                        2, // ��t
                        2, // ���Ȉ�t
                        2, // ��܎t(��Ë@��)
                        8, // ��܎t(���)
                        2, // �Ǘ��h�{�m
                        4, // ���ȉq���m��
                        1, // �Ō�E��
                } };
        end = visitCounts.length;
        for (int i = 1; i < end; i++) {
            if ((visitCounts[i] > limits[ganFlags[i]][i])) {
                // �����̏���K��񐔂𒴂����T�[�r�X
                overFlowCount = visitCounts[i];
                overflowIndex = i;
                break;
            } else {
                // �T�P�ʂŃ`�F�b�N
                int end2 = weeklyCounts[i].length;
                for (int j = 1; j < end2; j++) {
                    if (weeklyCounts[i][j] > 2) {
                        // �T�P�ʂ̏���K��񐔂𒴂����T�[�r�X
                        overFlowCount = visitCounts[i];
                        overflowIndex = i;
                        break;
                    }
                }
            }
        }

        if (overflowIndex < 0) {
            // ����𒴂������̂��Ȃ��ꍇ
            // �߂�l�Ƃ���true��Ԃ��B
            return true;
        } else {
            // ����𒴂������̂�����ꍇ
            // �����b�Z�[�W��\������B
            // ���b�Z�[�W��\������B(��)�Ǘ��h�{�m(���2��)���A3��ݒ肳��Ă���ꍇ�AVALUE�́u�Ǘ��h�{�m 3��v�ƂȂ�B)
            // showMsg(QS001_LIMIT_OVER_KYOTAKU_RYOYO_KANRI_SHIDO,
            // ((����񐔂𒴂������ږ�) + (��) + ��));
            // [ID:0000456][Masahiko Higuchi] 2009/03 edit begin ����21�N4���@�����Ή�
            String[] names = { "" };
            // ����21�N4���ȍ~�͋敪���ǉ������
            names = new String[] { "", "��t", "���Ȉ�t", "��܎t(��Ë@��)", "��܎t(���)",
                    "�Ǘ��h�{�m", "���ȉq���m��", "�Ō�E��", };

            // [ID:0000456][Masahiko Higuchi] 2009/03 edit end
            if (QkanMessageList.getInstance()
                    .QS001_LIMIT_OVER_KYOTAKU_RYOYO_KANRI_SHIDO(
                            names[overflowIndex] + " " + overFlowCount + "��") == ACMessageBox.RESULT_OK) {
                // �uOK�v�I����
                // �߂�l�Ƃ���true��Ԃ��B
                return true;
            } else {
                // �u�L�����Z���v�I����
                // �߂�l�Ƃ���false��Ԃ��B
                return false;
            }
        }
        
    }

    /**
     * �u���������v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public void doFind() throws Exception {
        // ��DB����T�ԕ\�E���ԕ\�����擾

        if (getProcessType() == QkanConstants.PROCESS_TYPE_PLAN) {
            // �����^�C�v(processType)���\��iPROCESS_TYPE_PLAN�j�̏ꍇ
            // ���I�����ꂽ���p�҂́A�Ώ۔N�����̗\����̐ݒ�
            // �I�����ꂽ���p�҂́A�Ώ۔N�����̗\������擾����B
            ACDBManager dbm = getDBManager();
            VRList schedules;
            try {
                dbm.beginTransaction();
                schedules = QkanCommon.getServiceDetail(dbm, getPatientID(),
                        getTargetDate(), QkanConstants.SERVICE_DETAIL_GET_PLAN);
                dbm.commitTransaction();
            } catch (Exception ex) {
                dbm.rollbackTransaction();
                throw ex;
            }
            // �擾���������u�T�ԕ\�v�u���ԕ\�v�ɐݒ肷��B
            getMonthlyPanel().setSchedule(schedules);
            getWeeklyPanel().setSchedule(schedules);
        } else if (getProcessType() == QkanConstants.PROCESS_TYPE_RESULT) {
            // �����^�C�v(processType)�����сiPROCESS_TYPE_RESULT�j�̏ꍇ
            // ���I�����ꂽ���p�҂́A�Ώ۔N�����̎��я��̐ݒ�
            // �I�����ꂽ���p�҂́A�Ώ۔N�����̎��я����擾����B
            ACDBManager dbm = getDBManager();
            VRList schedules;
            try {
                dbm.beginTransaction();
                schedules = QkanCommon.getServiceDetail(dbm, getPatientID(),
                        getTargetDate(),
                        QkanConstants.SERVICE_DETAIL_GET_RESULT);
                dbm.commitTransaction();
            } catch (Exception ex) {
                dbm.rollbackTransaction();
                throw ex;
            }
            // �擾���������u���ԕ\�v�ɐݒ肷��B

            getMonthlyPanel().setSchedule(schedules);
            getWeeklyPanel().setSchedule(schedules);

            // ���v��P�ʐ����擾
            VRMap planUnits = new VRHashMap();
            Iterator it = schedules.iterator();
            while (it.hasNext()) {
                // �擾�������𑖍����A�V�X�e���Ǘ��T�[�r�X���܂ނ��𒲂ׂ�B
                VRMap row = (VRMap) it.next();
                if (CareServiceCommon.isPlanUnitService(row)) {
                    // �V�X�e���Ǘ��T�[�r�X�𔭌������ꍇ
                    Object obj = VRBindPathParser.get("PROVIDER_ID", row);
                    if (obj != null) {
                        // ���Ə��ԍ���null�łȂ��ꍇ
                        planUnits.setData(obj, row);
                    }
                }
            }
            getMonthlyPanel().setServicePlanUnits(planUnits);
        }
    }

    /**
     * �u�o�^�����v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     * @return boolean
     */
    public boolean doInsert() throws Exception {
        return doUpdateImpl(true);
    }

    /**
     * �u�f�[�^�X�V�����v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @param isInsert boolean
     * @throws Exception ������O
     * @return boolean
     */
    public boolean doUpdateImpl(boolean insertMode) throws Exception {
        // ���T�ԕ\�E���ԕ\����DB�ɓo�^

        try {
            ACFrameEventProcesser processer = ACFrame.getInstance()
                    .getFrameEventProcesser();
            ACSplashable splash;
            if (processer != null) {
                splash = processer.createSplash("�ۑ�����");
            }

            VRList details = new VRArrayList();
            int insertUseType = 0;
            if (getProcessType() == QkanConstants.PROCESS_TYPE_PLAN) {
                insertUseType = QkanConstants.SERVICE_DETAIL_GET_PLAN;
                // ���ԕ\�E�T�ԕ\����details�����
                details.addAll(getWeeklyPanel().getSchedule());
                details.addAll(getMonthlyPanel().getSchedule(
                        QkanConstants.SERVICE_DETAIL_GET_PLAN, true));
            } else if (getProcessType() == QkanConstants.PROCESS_TYPE_RESULT) {
                insertUseType = QkanConstants.SERVICE_DETAIL_GET_RESULT;

                // [CCCX: 03987][Shinobu Hitaka] 2017/07/25 add begin
                // ���т��Ȃ��Ă��v��P�ʐ����N���A����Ȃ��Ǝ��яW�v�ꗗ�ɗ��p�Җ����\������� 
                VRList monthlyList = getMonthlyPanel().getSchedule(QkanConstants.SERVICE_DETAIL_GET_RESULT, true);

                // ���Ԏ��т��Ȃ��ꍇ�͌v��P�ʐ����N���A
                if (monthlyList.size() == 0) {
                    getMonthlyPanel().getPlanUnits().clear();
                }
                // [CCCX: 03987] add end

                // ���ԕ\����details�����
                details.addAll(getWeeklyPanel().getSchedule());
//                details.addAll(getMonthlyPanel().getSchedule(
//                        QkanConstants.SERVICE_DETAIL_GET_RESULT, true));
                details.addAll(monthlyList);

                // �v��P�ʐ���ۑ�����B
                Iterator it = getMonthlyPanel().getServicePlanUnits().values()
                        .iterator();
                while (it.hasNext()) {
                    VRMap planUnits = (VRMap) it.next();
                    if ((planUnits != null) && (!planUnits.isEmpty())) {
                        final Integer zero = new Integer(0);
                        VRMap systemService = new VRHashMap();
                        VRBindPathParser
                                .set("SERVICE_USE_TYPE",
                                        systemService,
                                        QkanConstants.SERVICE_USE_TYPE_RESULT_MONTHLY_DAY);
                        VRBindPathParser.set("PROVIDER_ID", systemService, "");
                        VRBindPathParser
                                .set("SYSTEM_SERVICE_KIND_DETAIL",
                                        systemService,
                                        QkanConstants.SERVICE_KIND_DETAIL_SYSTEM_SERVICE);
                        VRBindPathParser.set("SERVICE_DATE", systemService,
                                getTargetDate());
                        VRBindPathParser.set("WEEK_DAY", systemService, zero);
                        VRBindPathParser.set("REGULATION_RATE", systemService,
                                zero);
                        systemService.putAll(planUnits);
                        details.add(systemService);
                    }
                }
            }

            // ���ʃp�����^��ݒ肷��B
            Iterator<VRMap> it = details.iterator();
            while (it.hasNext()) {
                VRMap row = it.next();
                try {
                    VRBindPathParser.set("PATIENT_ID", row, new Integer(
                            getPatientID()));
                } catch (java.util.ConcurrentModificationException ex) {
                    // �C�e���[�V�����̓�����O�͖���
                }
            }

            ACDBManager dbm = getDBManager();
            try {
                dbm.beginTransaction();
                getPassiveChecker().clearPassiveTask();
                if (insertMode) {
                    // �o�^���[�h�̏ꍇ
                    getPassiveChecker().addPassiveInsertTask(
                            getSERVICE_PASSIVE_CHECK_KEY(),
                            getPassiveCheckSQLParam());
                } else {
                    // �X�V���[�h�̏ꍇ
                    getPassiveChecker().addPassiveUpdateTask(
                            getSERVICE_PASSIVE_CHECK_KEY());
                }
                if (!getPassiveChecker().passiveCheck(dbm)) {
                    QkanMessageList.getInstance()
                            .ERROR_OF_PASSIVE_CHECK_ON_UPDATE();
                    dbm.rollbackTransaction();
                    return false;
                }

                // 2007/12/25 [Masahiko_Higuchi] add - begin Version
                // 5.3.8�@2007�N�x�Ή�
                for (int i = 0; i < details.size(); i++) {
                    VRMap delMap = (VRMap) details.getData(i);
                    // 2008/06/24 [Masahiko.Higuchi] V5.4.1 edit - begin
                    // ������O���������邱�Ƃ�����悤�Ȃ̂őΉ�
                    try {
                        // ��͗p�̃L�[�͏���
                        delMap.remove("ANALYZE");
                        delMap.remove("CORRECT_KEY");
                    } catch (java.util.ConcurrentModificationException ex) {
                        // ������O�͖���
                    }
                    // 2008/06/24 [Masahiko.Higuchi] edit - end
                }
                // 2007/12/25 [Masahiko_Higuchi] add - End

                QkanCommon.updateServiceDetail(dbm, details, getPatientID(),
                        getTargetDate(), insertUseType);
                // �p�b�V�u�`�F�b�N�p�e�[�u���ɏ����Ώۂ̗��p�ҁE�N���̃��R�[�h��o�^����B��SQL
                // ID=INSERT_PASSIVE_CHECK_RECORD
                if (insertMode) {
                    // �o�^���[�h�̏ꍇ
                    dbm.executeUpdate(getSQL_INSERT_PASSIVE_CHECK_RECORD(getPassiveCheckSQLParam()));
                } else {
                    // �X�V���[�h�̏ꍇ
                    dbm.executeUpdate(getSQL_UPDATE_PASSIVE_CHECK_RECORD(getPassiveCheckSQLParam()));
                    // [ID:0000491][Masahiko Higuchi] 2009/07 edit begin
                    // �ďW�v���ɏ��������p���@�\
                    // ���ъm����̔j��
                    // QkanCommon.updateClaimDetail(dbm, new VRArrayList(),
                    // getTargetDate(), getPatientID());
                    VRMap sqlParam = new VRHashMap();
                    sqlParam.setData("PATIENT_ID",
                            ACCastUtilities.toInteger(getPatientID()));
                    sqlParam.setData("TARGET_DATE_FIRST",
                            ACDateUtilities.toFirstDayOfMonth(getTargetDate()));
                    sqlParam.setData("TARGET_DATE_LAST",
                            ACDateUtilities.toLastDayOfMonth(getTargetDate()));
                    // �����ԍ��擾
                    VRList claimList = dbm
                            .executeQuery(getSQL_GET_CLAIM_ID(sqlParam));
                    if (!claimList.isEmpty()) {
                        // ������񐔃��[�v����
                        for (int i = 0; i < claimList.size(); i++) {
                            VRMap claim = (VRMap) claimList.getData(i);
                            Integer claimID = ACCastUtilities.toInteger(claim
                                    .getData("CLAIM_ID"));
                            // ��U�N���A
                            sqlParam = new VRHashMap();
                            sqlParam.setData("CLAIM_ID", claimID);
                            // �����e�[�u���̍X�V����
                            dbm.executeUpdate(getSQL_UPDATE_CLAIM_ID(sqlParam));
                        }
                    }
                    // [ID:0000491][Masahiko Higuchi] 2009/07 edit end
                }
                dbm.commitTransaction();
            } catch (Exception ex) {
                dbm.rollbackTransaction();
                throw ex;
            }
            setServiceModify(false);

            // �����[�h�Ċm�F
            // �������R�[�h�̗L������ɁA�X�V���[�h���o�^���[�h���𔻒f����B
            checkProcessMode();

        } finally {
            ACSplashChaine.getInstance().closeAll();
        }
        return true;
    }

    /**
     * �u�X�V�����v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     * @return boolean
     */
    public boolean doUpdate() throws Exception {
        return doUpdateImpl(false);
    }

    /**
     * �u�T�ԕ\�\���v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public void showWeekly() throws Exception {
        // ���T�ԕ\��\��
        // �T�ԕ\��\������B
        getMonthlyPanel().setVisible(false);
        getWeeklyPanel().setVisible(true);
        // �T�ԃT�[�r�X�v��\����{�^����\������B
        setState_PRINT_WEEKLY();
        // changeChart�̃L���v�V�������u���ԕ\���v�ɂ���B
        getChangeChart().setText("���ԕ\��");
    }

    /**
     * �u���ԕ\�\���v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public void showMonthly() throws Exception {
        // �����ԕ\��\��
        // ���ԕ\��\������B
        getMonthlyPanel().setVisible(true);
        if (getWeeklyPanel() != null) {
            getWeeklyPanel().setVisible(false);
        }
        // ���p�[�E�񋟕[����{�^����\������B
        setState_PRINT_MONTHLY();
        // changeChart�̃L���v�V�������u�T�ԕ\���v�ɂ���B
        getChangeChart().setText("�T�ԕ\��");

    }

    /**
     * �u�T�[�r�X�p�^�[���I��/���I���`�F�b�N�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public void checkServicePatternSelected() throws Exception {
        // ���T�[�r�X�p�^�[���̑I��/���I���`�F�b�N
        // �u�T�[�r�X�p�^�[��(patternList)�v���̍��ڂ��I������Ă��邩�ǂ������`�F�b�N����B
        if ((!getPatternList().isSelectionEmpty())
                && (getSelectedServiceListBox() == getPatternList())) {
            // �I������Ă���ꍇ
            // �u�T�[�r�X�p�^�[���폜(patternDelete)�v��L���ɂ���B
            setState_SERVICE_PATTERN_SELECTED();
        } else {
            // �I������Ă��Ȃ��ꍇ
            // �u�T�[�r�X�p�^�[���폜(patternDelete)�v�𖳌��ɂ���B
            setState_SERVICE_PATTERN_UNSELECTED();
        }
    }

    /**
     * �u�ڍד��eD&D�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public void pictureDragAndDrop() throws Exception {
        // ����A�C�R���ɂ��h���b�O���h���b�v����
        // ���h���b�v��(�T�ԕ\�A���ԕ\)�ɁA���e�ڍ׏���ݒ�
        getPicture().setDragData(createServiceData());
    }

    /**
     * �u�\��f�[�^�Ǎ��v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public void doOpenResult() throws Exception {
        // ������Ώ۔N���̗\�������ʂɓW�J

        // ������Ώ۔N���̗\�������ʂɓW�J
        ACDBManager dbm = getDBManager();
        dbm.beginTransaction();
        VRList plans = QkanCommon.getServiceDetail(dbm, getPatientID(),
                getTargetDate(),
                QkanConstants.SERVICE_DETAIL_GET_PLAN_OF_MONTHLY_ONLY);
        dbm.commitTransaction();
        
        // 2016/9/14 [Yoichiro Kamei] mod - begin �������ƑΉ�
        // �����z�����ƂɌv��P�ʐ���ݒ�
        boolean existsRegulationRate = false;
        // 2016/9/14 [Yoichiro Kamei] mod - end
        Iterator it = plans.iterator();
        while (it.hasNext()) {
            // USE_TYPE���\��̂��̂ɂȂ��Ă���̂ŁA���тɍ����ւ���
            VRMap row = (VRMap) it.next();
            Integer useType = new Integer(
                    ACCastUtilities.toString(VRBindPathParser.get(
                            "SERVICE_USE_TYPE", row)));
            if (QkanConstants.SERVICE_USE_TYPE_PLAN_MONTHLY_DAY.equals(useType)) {
                VRBindPathParser.set("SERVICE_USE_TYPE", row,
                        QkanConstants.SERVICE_USE_TYPE_RESULT_MONTHLY_DAY);
            } else if (QkanConstants.SERVICE_USE_TYPE_PLAN_MONTHLY_FREE_DAY
                    .equals(useType)) {
                VRBindPathParser.set("SERVICE_USE_TYPE", row,
                        QkanConstants.SERVICE_USE_TYPE_RESULT_MONTHLY_FREE_DAY);
            }
            // �L�[���폜
            row.remove("SERVICE_ID");
            
            // 2016/9/14 [Yoichiro Kamei] mod - begin �������ƑΉ�
            // �����z���ݒ肳��Ă��邩�m�F
            int rate = ACCastUtilities.toInt(row.get("REGULATION_RATE"), 0);
            if (rate > 0) {
                existsRegulationRate = true;
            }
            // 2016/9/14 [Yoichiro Kamei] mod - end
        }
        
        // 2016/12/08 [Shinobu Hitaka] add �o�^�ς݂̌v��P�ʐ����N���A 
        getMonthlyPanel().getPlanUnits().clear();
        
        // 2016/9/14 [Yoichiro Kamei] mod - begin �������ƑΉ�
        if (existsRegulationRate) {
            // �����z�����ƂɌv��P�ʐ��̐ݒ���s���܂����H
            if (QkanMessageList.getInstance().QS001_READ_PLAN_SAVE_PLAN_UNITS() == ACMessageBox.RESULT_OK) {
                // �uOK�v�I����
                // �����z�����ƂɌv��P�ʐ��̓o�^���s��
                CareServiceSummaryManager summary = new CareServiceSummaryManager(
                    getCalcurater(), getMonthlyPanel().getPatientInsureInfoHeaviest(),
                    getMonthlyPanel().getMonthlySchedule().getMasterService());
                
                // �f�[�^�̃N���[�����쐬����B
                VRList cloneServices = new VRArrayList();
                cloneServices.addAll(QkanValidServiceCommon.deepCopyVRList(plans));
                
                // �o�^�ς݂̌v��P�ʐ���ݒ�
                summary.initialize(getCalcurater(), cloneServices);
                summary.setupPlanUnitsFromAdjusts(getMonthlyPanel().getPlanUnits());
            } else {
                // �u�L�����Z���v�I����
                // �\��Őݒ肳�ꂽ�����z���N���A����
                it = plans.iterator();
                while (it.hasNext()) {
                    VRMap row = (VRMap) it.next();
                    row.put("REGULATION_RATE", 0);
                }
            }
        }
        // 2016/9/14 [Yoichiro Kamei] add - end
        
        // ����Ώ۔N���̗\�������ʂɓW�J
        getMonthlyPanel().setSchedule(plans);

    }

    /**
     * �u�T�[�r�X�p�^�[���I���C�x���g�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void patternListSelectionChanged(ListSelectionEvent e)
            throws Exception {
        // ���T�[�r�X�p�^�[���̏���W�J
        // �T�[�r�X���e�o�^�E�I��̈�(servuceDetails)�ɑI�������p�^�[���̏����o�C���h����B
        serviceListSelectionChanged(e);
    }

    /**
     * �u�T�[�r�X�N���X�̐����v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     * @return ACPanel
     */
    // 2008/03/18 [Masahiko_Higuchi] edit - begin ����20�N�x�f�Õ�V�P���ύX�Ή�
    public ACPanel createServicePatternClass(Date targetDate) throws Exception {

        // �N���X�����\�z����
        Class<QS001ServicePanel> serviceClass = null;
        String serviceKindDetailVal = ACCastUtilities
                .toString(getSelectedServiceKind());
        ACPanel servicePanel = null;
        StringBuilder sb = new StringBuilder();
        sb.append("jp.or.med.orca.qkan.affair.qs.qs001.");
        sb.append("QS001_");
        sb.append(serviceKindDetailVal);
        sb.append("_");
        sb.append(QkanCommon.getServiceLowVersion(serviceKindDetailVal,
                targetDate, getDBManager()));

        try {
            // �N���X����
            serviceClass = (Class<QS001ServicePanel>) Class.forName(sb
                    .toString());
            // �N���X�擾
            if (serviceClass != null) {
                servicePanel = (QS001ServicePanel) serviceClass.newInstance();
            }
            // 2016/8/23 [Yoichiro Kamei] add - begin �������ƑΉ�
            if (servicePanel != null) {
                if (servicePanel instanceof QS001ServicePanelSogo) {
                    ((QS001ServicePanelSogo) servicePanel).setSystemServiceKindDetail(serviceKindDetailVal);
                }
            }
            // 2016/8/23 [Yoichiro Kamei] add - end
        } catch (ClassNotFoundException e) { // by Class.forName
            // �w�肵�����̂̃N���X���݂��Ȃ������ꍇ
            e.printStackTrace();

        } catch (InstantiationException e) { // by newInstance()
            // �C���X�^���X�쐬�s�̏ꍇ�i�p�����[�^�Ȃ��̃R���X�g���N�^���݂��Ȃ��ꍇ - new Xxxx()�ŃG���[�̏ꍇ�j
            e.printStackTrace();

        } catch (IllegalAccessException e) { // by newInstance()
            // �����͂Ȃ��Ƃ�
            e.printStackTrace();

        }

        return servicePanel;

    }

    /**
     * �u�T�[�r�X�p�l���̃f�[�^�擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public VRMap createServiceData() throws Exception {
        // ���I�����Ă���T�[�r�X�̏����擾
        if (getSelectedServiceClass() != null) {
            // ���ݑI�����Ă���T�[�r�X�N���X(selectedServiceClass)��null�łȂ��ꍇ

            if (getSelectedServiceClass().isUseProvider()) {
                // ���ݑI�����Ă���T�[�r�X�N���X(selectedServiceClass)�����Ə�����K�v�Ƃ���(isUseProvider)�ꍇ

                if (!getServiceOfferEntrepreneur().isSelected()) {
                    // ���Ə���I�����ĂȂ��ꍇ
                    // ���Ə����I���̃G���[���b�Z�[�W��\������B��ID=QS001_EROOR_OF_UNSELECTED_PROVIDER
                    QkanMessageList.getInstance()
                            .QS001_EROOR_OF_UNSELECTED_PROVIDER();
                    // ���͂ɕs�����������ƌ��Ȃ��Anull��Ԃ��B
                    return null;
                }
            }

            VRMap data = getSelectedServiceClass().getValidData();
            if (data != null) {
                // ���ݑI�����Ă���T�[�r�X�N���X(selectedServiceClass)�̃G���[�`�F�b�N(getValidData)��null�ȊO���Ԃ��Ă����ꍇ
                // ���ݕ\�����Ă���T�[�r�X�N���X���܂ރT�[�r�X���e�ݒ�̈�(serviceContentSettings)����������W���ĕԂ��B

                // VRBindPathParser.set("LOGIN_PROVIDER_ID", data,
                // QkanSystemInformation.getInstance().getLoginProviderID());
                VRBindPathParser.set("PATIENT_ID", data, new Integer(
                        getPatientID()));
                Object provider = getServiceOfferEntrepreneur()
                        .getSelectedModelItem();
                if (provider instanceof VRMap) {
                    VRBindPathParser.set("PROVIDER_ID", data, VRBindPathParser
                            .get("PROVIDER_ID", (VRMap) provider));
                } else {
                    VRBindPathParser.set("PROVIDER_ID", data, "");
                }
                VRBindPathParser.set("SYSTEM_SERVICE_KIND_DETAIL", data,
                        new Integer(getSelectedServiceKind()));
                // SERVICE_USE_TYPE�Ȃǂ̏��͕K�v�ɉ����ČĂяo�����Őݒ肷�邱�ƁB

                // [ID:0000444][Tozo TANAKA] 2009/03/07 add begin ����21�N4���@�����Ή�
                if (getSelectedServiceClass() instanceof QS001ServicePanel) {
                    // �T�[�r�X�̖@�����敪��ݒ肵�܂��B
                    VRBindPathParser
                            .set(QkanConstants.SERVICE_SYSTEM_BIND_PATH_LOW_VERSION,
                                    data,
                                    new Integer(
                                            ((QS001ServicePanel) getSelectedServiceClass())
                                                    .getServiceLowVersion()));
                }
                // [ID:0000444][Tozo TANAKA] 2009/03/07 add end

                return data;
            }
        }
        // ���͂ɕs�����������ƌ��Ȃ��Anull��Ԃ��B
        return null;
    }

    /**
     * �u�������[�h�̊m�F�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public void checkProcessMode() throws Exception {
        // ���p�b�V�u�`�F�b�N�p�̃e�[�u�����m�F���A���݂̏������[�h��ݒ�

        // �p�b�V�u�`�F�b�N�p�e�[�u���ɏ����Ώۂ̗��p�ҁE�N���̃��R�[�h�����݂��邩���m�F����B��SQL
        // ID=GET_PASSIVE_CHECK_RECORD
        VRList passive = getDBManager().executeQuery(
                getSQL_GET_PASSIVE_CHECK_RECORD(getPassiveCheckSQLParam()));
        if (!passive.isEmpty()) {
            // ���R�[�h�����݂���ꍇ
            // �������[�h���X�V���[�h�Ƃ���B
            setProcessMode(QkanConstants.PROCESS_MODE_UPDATE);
            // �Ɩ��{�^���̍X�V�{�^����\�����A�o�^�{�^�����\���ɂ���B
            setState_PROCESS_MODE_UPDATE();
            // �p�b�V�u�`�F�b�N�p�̃��R�[�h�Ƃ��ăp�b�V�u�`�F�b�J�[�ɑޔ�����B
            getPassiveChecker().reservedPassive(getSERVICE_PASSIVE_CHECK_KEY(),
                    passive);
        } else {
            // ���R�[�h�����݂��Ȃ��ꍇ
            // �������[�h��o�^���[�h�Ƃ���B
            setProcessMode(QkanConstants.PROCESS_MODE_INSERT);
            // �Ɩ��{�^���̓o�^�{�^����\�����A�X�V�{�^�����\���ɂ���B
            setState_PROCESS_MODE_INSERT();
        }

    }

    /**
     * �u�T�ԃT�[�r�X���X�g�I���v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void weeklyPanelSelectionChanged(ListSelectionEvent e)
            throws Exception {
        // ���T�ԕ\�̃T�[�r�X�I���C�x���g
        // ����/�T�ԕ\�̃T�[�r�X�I���C�x���g����������B
        serviceListSelectionChanged(e);
    }

    /**
     * �u���ԃT�[�r�X���X�g�I���v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void monthlyPanelSelectionChanged(ListSelectionEvent e)
            throws Exception {
        // �����ԕ\�̃T�[�r�X�I���C�x���g
        // ����/�T�ԕ\�̃T�[�r�X�I���C�x���g����������B
        serviceListSelectionChanged(e);
    }

    /**
     * �u�T�ԃT�[�r�X���X�g�L�[�����v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void weeklyPanelKeyPressed(KeyEvent e) throws Exception {
        // ���T�ԕ\�̃L�[�����C�x���g
        // ����/�T�ԕ\�̃L�[�����C�x���g����������B
        serviceListKeyDown(e);
    }

    /**
     * �u���ԃT�[�r�X���X�g�L�[�����v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void monthlyPanelKeyPressed(KeyEvent e) throws Exception {
        // �����ԕ\�̃T�[�r�X�I���C�x���g
        // ����/�T�ԕ\�̃L�[�����C�x���g����������B
        serviceListKeyDown(e);

    }

    /**
     * �u����/�T�ԃT�[�r�X���X�g�I��ύX�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @param e ListSelectionEvent
     * @throws Exception ������O
     */
    public void serviceListSelectionChanged(ListSelectionEvent e)
            throws Exception {
        // �C�x���g�������Ƃ̃��X�g���T�[�r�X�I�𒆂̃��X�g(serviceSelectedListBox)�ɑޔ�����B
        if (e.getValueIsAdjusting()) {
            return;
        }
        if (getServiceListLockFlag()) {
            // ���d�ċA�h�~
            return;
        }
        QS001DaySchedule oldSelectedList = getSelectedServiceListBox();
        Object lock = oldSelectedList;
        if (lock == null) {
            lock = new Integer(0);
        }
        synchronized (lock) {
            setSelectedServiceListBox((QS001DaySchedule) e.getSource());

            if ((getSelectedServiceListBox() != null)
                    && (getSelectedServiceListBox().isSelected())) {
                // �T�[�r�X��I�����Ă���ꍇ
                // �T�[�r�X�I����Ԃɂ���B
                if (getUsableProvider()) {
                    // ���p�ł��Ȃ����Ə����I������Ă���ꍇ�̓X�L�b�v
                    setState_SERVICE_SELECTED();
                }
                VRMap service = getSelectedServiceListBox()
                        .getSelectedService();
                if (service != null) {
                    Object selectedKind = VRBindPathParser.get(
                            "SYSTEM_SERVICE_KIND_DETAIL", service);
                    if (selectedKind != null) {
                        int end = getServiceKindList().getItemCount();
                        for (int i = 0; i < end; i++) {
                            Object kindItem = getServiceKindList().getItemAt(i);
                            if (kindItem instanceof VRMap) {
                                if (selectedKind.equals(VRBindPathParser.get(
                                        "SYSTEM_SERVICE_KIND_DETAIL",
                                        (VRMap) kindItem))) {
                                    setNowSelectedService(service);
                                    getServiceKindList().setSelectedIndex(i);
                                    getSelectedServiceClass().initialize();

                                    // ��Ɏ��Ə����o�C���h����B
                                    getServiceOfferEntrepreneur().setSource(
                                            service);
                                    getServiceOfferEntrepreneur().bindSource();

                                    // ���Ƃŏڍ׃p�l���Ƀo�C���h����B
                                    getServiceContentSettings().setSource(
                                            service);
                                    getServiceContentSettings().bindSource();
                                    if (getSelectedServiceClass() instanceof QS001ServicePanel) {
                                        ((QS001ServicePanel) getSelectedServiceClass())
                                                .binded();
                                    }
                                    break;
                                }
                            }
                        }

                        // for debug
                        try {
                            debugService(service);
                        } catch (Exception ex) {
                        }
                        // for dbuug
                    }
                    // �T�ԕ\�ɂ�����T�[�r�X�̊J�n���Ɗ��Ԃ�ݒ肷��B
                    getWeeklyPanel().setServiceSpan(service);
                }

                // ���ԕ\�ɑI�����ꂽ�T�[�r�X�p�l����ݒ肷��B
                getMonthlyPanel().setSelectedService(getSelectedServiceClass(),
                        getSelectedServiceListBox());
            } else {
                // �T�[�r�X��I�����Ă��Ȃ��ꍇ
                // �T�[�r�X���I����Ԃɂ���B
                clearServiceSelection();
            }
            if (oldSelectedList != null) {
                if (oldSelectedList != getSelectedServiceListBox()) {
                    if (oldSelectedList.isSelected()) {
                        // �ߋ��ɑI�����Ă������X�g�̑I������������B
                        setServiceListLockFlag(true);
                        oldSelectedList.clearSelection();
                        setServiceListLockFlag(false);
                    }
                }
            }
        }

        // �p�^�[���̑I����Ԃ��`�F�b�N����B
        checkServicePatternSelected();

    }

    /**
     * �u����/�T�ԃT�[�r�X���X�g�L�[�����v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @param e KeyEventListener *
     * @throws Exception ������O *
     */
    public void serviceListKeyDown(KeyEvent e) throws Exception {
        // ������/�T�ԕ\�̃T�[�r�X���X�g�L�[����
        if (e.getKeyCode() == KeyEvent.VK_DELETE) {
            // ���������L�[��Delete�L�[�̏ꍇ
            // �T�[�r�X�I�𒆂̃��X�g(serviceSelectedListBox)�ɑI���T�[�r�X�̍폜���w������B
            removeSelectedService();
        }
    }

    /**
     * �u�I���T�[�r�X�̍폜�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public void removeSelectedService() throws Exception {
        // ���I���T�[�r�X�̍폜
        if (getSelectedServiceListBox() != null) {
            // �T�[�r�X�I�𒆂̃��X�g(serviceSelectedListBox)��null�łȂ��ꍇ
            // �T�[�r�X�I�𒆂̃��X�g(serviceSelectedListBox)�ɑI���T�[�r�X�̍폜���w������B
            Component oldSelectCmp = null;
            if (getSharedFocusCellRenderer() != null) {
                oldSelectCmp = getSharedFocusCellRenderer()
                        .getSharedFocusedOwner();
            }
            getSelectedServiceListBox().removeSelectedSchedule();
            // �T�[�r�X���I����Ԃɂ���B
            if ((!getSelectedServiceListBox().isSelected())
                    || (getSelectedServiceListBox().getSelectedValue() == null)) {
                setState_SERVICE_UNSELECTED();
            } else {
                if (oldSelectCmp != null) {
                    getSharedFocusCellRenderer().setSharedFocusedOwner(
                            oldSelectCmp);
                }
            }
            setServiceModify(true);
        }
    }

    /**
     * �u�T�[�r�X�p�^�[���̒ǉ��폜�����s�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public void saveServicePattern() throws Exception {
        // ���T�[�r�X�p�^�[���̒ǉ��폜�����s
        // �\�񂵂��T�[�r�X�p�^�[���̒ǉ��폜�����s����B
        if ((!getDeleteReseveServicePatterns().isEmpty())
                || (!getInsertReserveServicePatterns().isEmpty())) {
            ACDBManager dbm = getDBManager();
            try {
                dbm.beginTransaction();
                // �ŐV�̃T�[�r�X�p�^�[�����擾����B
                VRList pattenrs = QkanCommon.getServicePatternDetail(dbm);
                // �폜�\��̃T�[�r�X�p�^�[�����擾���ʂ��珜�O����B
                Iterator<Object> it = getDeleteReseveServicePatterns()
                        .iterator();
                while (it.hasNext()) {
                    Map service = (Map) it.next();
                    Object obj = service.get("SERVICE_ID");
                    if (obj != null) {
                        String id = ACCastUtilities.toString(obj);

                        int end = pattenrs.size();
                        for (int i = 0; i < end; i++) {
                            if (id.equals(ACCastUtilities
                                    .toString(((Map) pattenrs.get(i))
                                            .get("SERVICE_ID")))) {
                                pattenrs.remove(i);
                                break;
                            }
                        }
                    }
                }
                // pattenrs.removeAll(getDeleteReseveServicePatterns());
                // �ǉ��\��̃T�[�r�X�p�^�[�����擾���ʂɒǉ�����B
                it = getInsertReserveServicePatterns().iterator();
                while (it.hasNext()) {
                    Map service = (Map) it.next();
                    service.remove("SERVICE_ID");
                }
                pattenrs.addAll(getInsertReserveServicePatterns());
                // �O�̂��߃��j�[�N�L�[�̏d���`�F�b�N���s���B
                Set<Object> keySet = new HashSet<Object>();
                it = pattenrs.iterator();
                while (it.hasNext()) {
                    Map row = (Map) it.next();
                    Object key = row.get("SERVICE_ID");
                    // 2008/01/24 [Masahiko_Higuchi] add - begin
                    // �T�[�r�X�p�^�[���ݒ�{�^��������s���G���[�Ή�
                    // �����p�̃L�[�����폜����
                    row.remove("CORRECT_KEY");
                    // 2008/01/24 [Masahiko_Higuchi] add - end
                    if (key != null) {
                        if (keySet.contains(key)) {
                            // �L�[�̏Փ�
                            row.remove("SERVICE_ID");
                        } else {
                            keySet.add(key);
                        }
                    }
                }
                // �}�[�W��̃T�[�r�X�p�^�[����DB�ɍēo�^����B
                QkanCommon.updateServicePatternDetail(dbm, pattenrs);
                dbm.commitTransaction();
            } catch (Exception ex) {
                dbm.rollbackTransaction();
                throw ex;
            }
        }

    }

    /**
     * �u�T�[�r�X��ނ̑I��ݒ�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     * 
     */
    public void refleshServiceKind() throws Exception {
        // ���T�[�r�X�p�^�[���̐ݒ�
        if (!(getServiceKindList().getSelectedValue() instanceof VRMap)) {
            return;
        }
        VRMap service = (VRMap) getServiceKindList().getSelectedValue();
        int serviceKind = ACCastUtilities.toInt(VRBindPathParser.get(
                "SYSTEM_SERVICE_KIND_DETAIL", service));
        // �I�𒆂̓Ǝ��T�[�r�X��ރR�[�h(selectedServiceKind)�ɑI�����ꂽ�T�[�r�X��
        // KEY:SYSTEM_SERVICE_KIND_DETAIL �̒l��ݒ肷��B
        setSelectedServiceKind(serviceKind);

        // �I�𒆂̓Ǝ��T�[�r�X��ރR�[�h(selectedServiceKind)�ɑΉ������T�[�r�X�p�^�[���N���X�𐶐�����B
        // 2008/03/18 [Masahiko_Higuchi] edit - begin
        // ����20�N4���@�����Ή��i���×{�^�V�l�ی��{�ݑΉ��j
        ACPanel serviceClass = createServicePatternClass(getCalcurater()
                .getTargetDate());
        // 2008/03/18 [Masahiko_Higuchi] edit - end
        if (serviceClass instanceof QS001ServicePanel) {
            ((QS001ServicePanel) serviceClass).setDBManager(getDBManager());
            ((QS001ServicePanel) serviceClass)
                    .setOldFacilityUser(getOldFacilityUserFlag() == 2);
            ((QS001ServicePanel) serviceClass)
                    .setPlanMode(getProcessType() == QkanConstants.PROCESS_TYPE_PLAN);
            ((QS001ServicePanel) serviceClass).setCalculater(getCalcurater());
        }
        // �T�[�r�X���e�ݒ�̈�(serviceContentSettings)�̎q���ڂ�j�����A���������T�[�r�X�p�^�[���N���X���q���ڂƂ��Ēǉ�����B
        getServiceContentSettings().removeAll();
        if (serviceClass != null) {
            setSelectedServiceClass((QS001Service) serviceClass);

            if (getBeginTimeFollowListener() != null) {
                getBeginTimeFollowListener().setB(
                        getSelectedServiceClass().getBeginTimeCombo());
                getEndTimeFollowListener().setB(
                        getSelectedServiceClass().getEndTimeCombo());
            }
            getSelectedServiceClass().initialize();
            getServiceContentSettings().add(serviceClass, VRLayout.CLIENT);
            // 2016/10/13 [Yoichiro Kamei] add - begin �������ƑΉ�
            if (serviceClass instanceof QS001ServicePanelSogo) {
                try {
                    // �������Ƃ̒P�ʐ��P�����ݒ肳��Ă��Ȃ���΁A�x���_�C�A���O��\��
                    String insurerId = ((QS001ServicePanelSogo) serviceClass).getInitialInsurerId();
                    QkanSjTankaManager.getUnitPrice(insurerId, String.valueOf(serviceKind));
                } catch (QkanSjTankaNotFoundException e) {
                    QkanMessageList.getInstance().QS001_SJ_TANKA_NOT_FOUND();
                }
            }
            // 2016/10/13 [Yoichiro Kamei] add - end
        } else {
            setSelectedServiceClass(null);
        }

        if (serviceKind == DAYLY_LIFE_SERVICE) {
            // �擾���ꂽ�T�[�r�X���u��ȓ��퐶����̊����v�ł���ꍇ
            // �u�T�ԕ\�v�́u���v�`�u���v�̃`�F�b�N�{�b�N�X���\���ɁA�u�T�P�ʈȊO�̃T�[�r�X�v�ȉ��𖳌��ɂ���B
            // setDailylifeCheckEnabled(true);
            getWeeklyPanel().setDailylifeCheckEnabled(true);
        } else {
            // �擾���ꂽ�T�[�r�X���u��ȓ��퐶����̊����v�ȊO�̏ꍇ
            // �u�T�ԕ\�v�́u���v�`�u���v�̃`�F�b�N�{�b�N�X��\�����A�u�T�P�ʈȊO�̃T�[�r�X�v�ȉ���L���ɂ���B
            // setDailylifeCheckEnabled(false);
            getWeeklyPanel().setDailylifeCheckEnabled(false);

            if (CareServiceCommon.isWelfareEquipment(service)) {
                // �����p��ݗ^�̏ꍇ
                // ���Ԃ͏��1���Ƃ��A���ԃR���{�𑀍�s�Ƃ���B
                getWeeklyPanel().getExceptionEndCombo().setSelectedIndex(1);
                getWeeklyPanel().setState_WELFARE_EQUIPMENT_SELECTED();
            } else {
                // �����p��ݗ^�ȊO�̏ꍇ
                // ���ԃR���{�𑀍�\�Ƃ���B
                getWeeklyPanel().getExceptionEndCombo().setSelectedIndex(0);
                getWeeklyPanel().setState_WELFARE_EQUIPMENT_UNSELECTED();
            }
        }

        // ���o�^�ς݃p�^�[���̐ݒ�
        // �I�����ꂽ�T�[�r�X�́A�o�^�ς݃p�^�[�����擾�E�ݒ肷��B
        Object patterns = getServicePatternHash().get(
                new Integer(getSelectedServiceKind()));
        if (!(patterns instanceof VRList)) {
            patterns = new VRArrayList();
            getServicePatternHash().put(new Integer(getSelectedServiceKind()),
                    patterns);
        }
        setNowServicePatterns((VRList) patterns);
        getPatternList().setModel(
                new ACListModelAdapter(getNowServicePatterns()));

        // �����Ə��R���{�̃A�C�e���ݒ�
        // ���Ə��̑I���ς݃t���O��錾����B
        boolean providerSelected = false;
        // ���ݑI�����Ă���T�[�r�X�N���X(selectedServiceClass)�����Ə�����K�v�Ƃ���(isUseProvider=true)�ꍇ
        if ((getSelectedServiceClass() != null)
                && getSelectedServiceClass().isUseProvider()) {
            // ���Ə��R���{��L���ɂ���B
            setState_USE_PROVIDER_SERVICE();

            // �I�����ꂽ�T�[�r�X��񋟂��鎖�Ə����A���Ə��R���{�̃A�C�e���ɐݒ肷��B
            VRList providers = QkanCommon.getProviderInfo(getDBManager(),
                    serviceKind);

            // �i�荞�܂ꂽ���Ə��̏ڍ׃T�[�r�X�������Ŏ擾����B
            // ���ʐM�ɂ�郌�X�|���X�ቺ���C�ɂȂ�悤�ł���΁A��ʓW�J����1�񂾂����ׂĂ̎��Ə��E�ڍׂ��擾���Ă����A
            // �i���݂̓L���b�V���������X�g����s�Ȃ��������l������B
            Iterator it = providers.iterator();
            while (it.hasNext()) {
                VRMap row = (VRMap) it.next();
                VRList details = QkanCommon.getProviderServiceDetail(
                        getDBManager(), ACCastUtilities
                                .toString(VRBindPathParser.get("PROVIDER_ID",
                                        row)), serviceKind);
                if (details.size() > 0) {
                    // �ڍׂ��}�[�W
                    row.putAll((VRMap) details.getData());
                }
            }

            getServiceOfferEntrepreneur().setModel(providers);
            // �����Ə��R���{�̑I��
            it = providers.iterator();
            while (it.hasNext()) {
                VRMap row = (VRMap) it.next();
                if (QkanSystemInformation.getInstance().getLoginProviderID()
                        .equals(VRBindPathParser.get("PROVIDER_ID", row))) {
                    // ���O�C�����Ə����R���{���ɂ���ꍇ�́A���O�C�����Ə���I������B
                    getServiceOfferEntrepreneur().setSelectedItem(row);
                    // ���Ə��̑I���ς݃t���O��true�ɂ���B
                    providerSelected = true;
                    break;
                }
            }
            // ���O�C�����Ə����R���{���ɂȂ��ꍇ�́A���I���Ƃ���B
            // * ���@�\�Ƃ��ăf�o�b�O���I���Ȃ珉���I��
            if (ACStaticDebugger.getInstance().isVisible()) {
                if (!providerSelected) {
                    getServiceOfferEntrepreneur().setSelectedIndex(0);
                    providerSelected = true;
                }
            }

        } else {
            // ���ݑI�����Ă���T�[�r�X�N���X(selectedServiceClass)�����Ə�����K�v�Ƃ��Ȃ�(isUseProvider=false)�ꍇ
            // ���Ə��R���{�𖳌��ɂ���B
            setState_NOT_USE_PROVIDER_SERVICE();
            // ���Ə��R���{�̑I��������ɂ���B
            getServiceOfferEntrepreneur().setModel(new VRArrayList());
        }

        if (!providerSelected) {
            // ���Ə��̑I���ς݃t���O��false�̏ꍇ
            if (getSelectedServiceClass() != null) {
                // ���T�[�r�X���e��������Ԃɂ���
                // �I�����Ă���T�[�r�X�N���X(selectedServiceClass)�Ɏ��Ə����Ƃ���null�𑗂�B
                getSelectedServiceClass().providerSelected(null);
            }
        }

        // ���T�[�r�X�p�^�[���̑I��/���I���`�F�b�N
        // �T�[�r�X�p�^�[���̑I��/���I���`�F�b�N���s���B
        checkServicePatternSelected();

        if (getBeginTimeFollowListener() != null) {
            QS001FollowTimeComboDocumentListener.followValue(
                    getBeginTimeFollowListener().getB(),
                    getBeginTimeFollowListener().getA());
        }
        if (getEndTimeFollowListener() != null) {
            QS001FollowTimeComboDocumentListener.followValue(
                    getEndTimeFollowListener().getB(),
                    getEndTimeFollowListener().getA());
        }
    }

    /**
     * �u�T�[�r�X���I����Ԑݒ�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     * 
     */
    public void clearServiceSelection() throws Exception {
        setNowSelectedService(null);
        setState_SERVICE_UNSELECTED();
        // �Z�������_���̕\�����X�V
        Component cmp = getSharedFocusCellRenderer().getSharedFocusedOwner();
        if (cmp != null) {
            getSharedFocusCellRenderer().setSharedFocusedOwner(null);
            cmp.repaint();
        }
        getMonthlyPanel().setState_SERVICE_UNSELECTED();
    }

    public void dropSuccess(ACDropEvent e) {
        setServiceModify(true);
    }

    public void dropReject(ACDropEvent e) {
    }

    /**
     * �u�ŐV�T�ԗ\��ǂݍ��݁v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     * 
     */
    public void doOpenPlan() throws Exception {

        // ���ߋ��̒��߂̏����擾
        VRList schedules = null;
        ACDBManager dbm = getDBManager();
        try {
            dbm.beginTransaction();

            // TODO ��
            int mode;
            if (getProcessType() == QkanConstants.PROCESS_TYPE_PLAN) {
                mode = QkanConstants.SERVICE_DETAIL_GET_PLAN_OF_WEEKLY_ONLY;
            } else {
                mode = QkanConstants.SERVICE_DETAIL_GET_RESULT;
            }

            schedules = QkanCommon.getServiceDetail(dbm, getPatientID(),
                    ACDateUtilities.addMonth(getTargetDate(), -1), mode);

            dbm.commitTransaction();
        } catch (Exception ex) {
            dbm.rollbackTransaction();
            throw ex;
        }
        if (schedules != null) {
            // ���j�[�N�L�[���폜
            Iterator it = schedules.iterator();
            while (it.hasNext()) {
                Map map = (Map) it.next();
                map.remove("SERVICE_ID");
            }
            getWeeklyPanel().setSchedule(schedules);
        }

    }

    /**
     * �Y��Map���ɊY���o�C���h�p�X�̒l�����݂��邩�`�F�b�N���܂��B
     * 
     * @return �T�[�r�X�̗L��
     * 
     * @author Masahiko Higuchi
     * @since V5.4.0
     * 
     */
    public boolean checkValidSysteBindPath(String[] bindPaths, VRMap service)
            throws Exception {
        Object obj = null;
        // �����̐����[�v
        for (int i = 0; i < bindPaths.length; i++) {
            obj = VRBindPathParser.get(bindPaths[i], service);
            // ��r����
            if (ACCastUtilities.toInt(obj, 0) != 0) {
                return true;
            }
        }

        return false;
    }

    /**
     * ���̃{�^���������̏���
     * 
     * @since Version 5.4.1
     * @author Masahiko Higuchi
     */
    protected void patternNameChangeActionPerformed(ActionEvent e)
            throws Exception {
        // VRMap�ȊO�͏����ΏۊO�ɂ���B
        if (!(getPatternList().getSelectedValue() instanceof VRMap)) {
            return;
        }
        VRMap pattern = (VRMap) getPatternList().getSelectedValue();
        QS001007 qs001007 = new QS001007();
        // �p�^�[���_�C�A���O�̕\��
        qs001007.showModel(pattern, getDBManager());
        // �p�^�[�����̂��ύX����Ă���ꍇ
        if (qs001007.isPatternNameChange()) {
            // �����o�^�T�[�r�X�p�^�[���ł��邩
            if (pattern.containsKey("SERVICE_ID")) {
                // �����̃T�[�r�X�p�^�[���ł���ꍇ��Delete - Insert�ŏ�������B
                getDeleteReseveServicePatterns().add(pattern);
                // �T�[�r�XID�̎擾
                int serviceID = ACCastUtilities.toInt(
                        pattern.getData("SERVICE_ID"), -1);
                // �o�^�\�胊�X�g���Ɋ��ɓ���̃f�[�^���Ȃ�����������
                for (int i = getInsertReserveServicePatterns().size(); i > 0; i--) {
                    VRMap insertPattern = (VRMap) getInsertReserveServicePatterns()
                            .get(i - 1);
                    int insertPatternServiceID = ACCastUtilities.toInt(
                            insertPattern.getData("SERVICE_ID"), -2);
                    // ���d�o�^�h�~�i����̃f�[�^�ł���ꍇ�͍���Ă��瑫���j
                    if (serviceID == insertPatternServiceID) {
                        getInsertReserveServicePatterns().remove(i - 1);
                    }
                }
                // �Ō�ɒǉ�
                getInsertReserveServicePatterns().add(pattern);
            }
        }
    }

    private void debugService(VRMap service) throws Exception {
        // �f�o�b�K���\������Ă��Ȃ��Ƃ��́A�������s��Ȃ�
        if (!ACStaticDebugger.getInstance().isVisible()) {
            return;
        }

        VRMap row = new VRHashMap(service);
        // �T�[�r�X�Ώ۔N�������擾����B
        Date serviceDate = ACCastUtilities.toDate(row.getData("SERVICE_DATE"),
                null);
        if (serviceDate == null) {
            return;
        }
        // �T�[�r�X�Ώ۔N��������Y������v���F�藚�����擾����B
        VRMap history = getCalcurater().getPatientInsureInfoOnTargetDay(
                serviceDate);
        if ((history == null) || (history.isEmpty())) {
            return;
        }
        // �Y������v���x���擾����B
        Object jotaiCode = history.getData("JOTAI_CODE");
        if (ACCastUtilities.toInt(jotaiCode, 1) == 1) {
            // ��Y���̏ꍇ�̓T�[�r�X�R�[�h��Ԃ��Ȃ�
            return;
        }
        row.setData(Qkan10011_ServiceUnitGetter.YOKAIGODO, jotaiCode);

        // ���Ə��ԍ�����Ή����鎖�Ə����擾����B
        Object provider = getCalcurater().getHashedProviders().get(
                row.getData("PROVIDER_ID"));
        if (provider instanceof VRMap) {
            // �Y�����鎖�Ə��̓��ʒn��L�����擾����B
            row.setData(Qkan10011_ServiceUnitGetter.TOKUCHI_KASAN,
                    ((VRMap) provider).getData("SPECIAL_AREA_FLAG"));
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
                }
            }
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
        java.util.List serviceCodes = Qkan10011_ServiceCodeManager
                .getInstance().getServiceCode(kind, (HashMap) row, serviceDate,
                        getDBManager());
        VRList list = new VRArrayList();

        for (int i = 0; i < serviceCodes.size(); i++) {
            Map tmp = (Map) serviceCodes.get(i);
            VRMap map = new VRHashMap();
            map.put("SERVICE_CODE",
                    String.valueOf(tmp.get("SERVICE_CODE_KIND"))
                            + String.valueOf(tmp.get("SERVICE_CODE_ITEM")));
            map.put("SERVICE_NAME", tmp.get("SERVICE_NAME"));
            map.put("SERVICE_UNIT", tmp.get("SERVICE_UNIT"));
            list.add(map);
        }

        String[] fields = new String[] { "SERVICE_CODE", "SERVICE_UNIT",
                "SERVICE_NAME" };
        ACStaticDebugger.getInstance().setResultTable("", fields, list);

    }

}
