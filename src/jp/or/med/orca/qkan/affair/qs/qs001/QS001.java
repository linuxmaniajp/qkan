
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
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.lowagie.text.pdf.hyphenation.TernaryTree;

import jp.nichicom.ac.ACCommon;
import jp.nichicom.ac.ACConstants;
import jp.nichicom.ac.bind.ACBindUtilities;
import jp.nichicom.ac.component.dnd.event.ACDraggableListener;
import jp.nichicom.ac.component.dnd.event.ACDropEvent;
import jp.nichicom.ac.container.ACPanel;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.core.ACFrameEventProcesser;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.lib.care.claim.print.schedule.CareServiceCodeCalcurater;
import jp.nichicom.ac.lib.care.claim.servicecode.CareServiceCommon;
import jp.nichicom.ac.lib.care.claim.servicecode.Qkan10011_ServiceCodeManager;
import jp.nichicom.ac.lib.care.claim.servicecode.QkanValidServiceManager;
import jp.nichicom.ac.pdf.ACChotarouXMLUtilities;
import jp.nichicom.ac.pdf.ACChotarouXMLWriter;
import jp.nichicom.ac.sql.ACDBManager;
import jp.nichicom.ac.sql.ACPassiveKey;
import jp.nichicom.ac.text.ACDateFormat;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.ac.util.ACDateUtilities;
import jp.nichicom.ac.util.ACMessageBox;
import jp.nichicom.ac.util.adapter.ACListModelAdapter;
import jp.nichicom.ac.util.splash.ACSplashChaine;
import jp.nichicom.ac.util.splash.ACSplashable;
import jp.nichicom.vr.bind.VRBindPathParser;
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
public class QS001 extends QS001Event {
    /**
     * �R���X�g���N�^�ł��B
     */
    public QS001() {
    }
    
    // 2008/01/24 [Masahiko_Higuchi] add - begin �T�[�r�X�p�^�[���ݒ�{�^��������s���G���[�Ή�
    private int correctKey = 0;
    // 2008/01/24 [Masahiko_Higuchi] add - end
    
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
        VRList specialFacilities = getDBManager().executeQuery(
                getSQL_GET_PATIENT_FACILITY_FLAG(getPatientInfo()));
        if (!specialFacilities.isEmpty()) {
            // �{�ݗ������̓�������҃t���O������ϐ�(inSpecialFacilityFlag)�ɑޔ�����B
            Object obj = ((Map) specialFacilities.getData())
                    .get("TOKUTEI_NYUSHO_FLAG");
            setInSpecialFacilityFlag(ACCastUtilities.toInt(obj, 0));
            obj = ((Map) specialFacilities.getData()).get("KYUSOCHI_FLAG");
            setOldFacilityUserFlag(ACCastUtilities.toInt(obj, 0));
        }

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
            param.setData("PATIENT_ID", ACCastUtilities.toInteger(getPatientID()));
            VRList list=getDBManager().executeQuery(getSQL_CHECK_NINTEI_HISTORY_EXISTS(sqlParam));
            if((list==null)||(list.isEmpty())){
                getYokaigodo().setText("�F�藚���Ȃ�");
            }else{
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
            getYokaigodo().setText(
                    QkanJotaiCodeUnapplicableFormat.getInstance().format(
                            VRBindPathParser.get("JOTAI_CODE",
                                    patientInsureInfoFirst))
                            + "��"
                            + QkanJotaiCodeUnapplicableFormat.getInstance()
                                    .format(
                                            VRBindPathParser.get("JOTAI_CODE",
                                                    patientInsureInfoLast)));
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
        getYokaigodo().setColumns(getYokaigodo().getText().length()+1);

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
        
        //��Ìn��\���Ή� fujihara.shin 2009.1.13 add start
        if (!QkanCommon.isShowOldIryo()){
	        for (int i = 0; i < services.size(); i++){
	        	VRMap row = (VRMap)services.get(i);
	        	if (ACCastUtilities.toInt(row.get("SYSTEM_SERVICE_KIND_DETAIL"), 0) == 20101){
	        		services.remove(i);
	        		break;
	        	}
	        }
        }
        //��Ìn��\���Ή� fujihara.shin 2009.1.13 add end
        
        // [ID:0000444][Masahiko Higuchi] 2009/02 add begin ����21�N4���@�����Ή�
        if(ACDateUtilities.getDifferenceOnDay(QkanConstants.H2104, getTargetDate())<1){
            // ��K���f�Ï��͏��O����B
            // 12314 : �Z�������×{���(��K���f�Ï�)
            // 13411 : ���\�h�Z�������×{���(��K���f�Ï�)
            int[] h2104RemoveServices = { 12314, 12614 };
            for (int i = 0; i < services.size(); i++){
                VRMap row = (VRMap)services.get(i);
                for(int j=0; j < h2104RemoveServices.length;j++) {
                    int removeSystemServiceKindDetail = h2104RemoveServices[j];
                    if (ACCastUtilities.toInt(row.get("SYSTEM_SERVICE_KIND_DETAIL"), 0) == removeSystemServiceKindDetail){
                        services.remove(i);
                        break;
                    }
                }
            }            
        }
        // [ID:0000444][Masahiko Higuchi] 2009/02 add end
        
        setServiceKindsList(services);
        getServiceKindList().setModel(new ACListModelAdapter(services));
        getServiceKindList().setCellRenderer(
                new QS001ServiceKindListCellRenderer());

        // �����[�U�o�^�ς݃T�[�r�X�p�^�[�����擾
        services = QkanCommon.getServicePatternDetail(getDBManager());
        VRMap patterns = new VRHashMap();
        Iterator it = services.iterator();
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
            //TODO �p�^�[���ԍ����̔ԍς݂ł��邩���ׂ�
            if(!isExistingData){
                for(int i = 0;i<((VRList)targetPatterns).size();i++){
                    // Map�Ɋi�[����
                    VRMap map = (VRMap)((VRList)targetPatterns).getData(i);
                    if (VRBindPathParser.has(ACCastUtilities.toString(QkanConstants.INTERNAL_SERVICE_PATTERN_NO_BIND_PATH),map)){
                        // ��x�ł��Y������Έȍ~�͒ʂ�Ȃ�
                        isExistingData = true;
                        break;
                    }
                }
            }
        }
        setServicePatternHash(patterns);
        
        if(!isExistingData){
            // �̔ԍς݂łȂ������ꍇ
            //  �p�^�[���ԍ����̔Ԃ���B
            it = patterns.values().iterator();
            while (it.hasNext()) {
                Object row = it.next();
                if (row instanceof VRList) {
                    VRList targetPatterns = (VRList)row;
                    for(int i = 0;i<((VRList)targetPatterns).size();i++){
                        VRMap inMap = new VRHashMap();
                        inMap = (VRMap)((VRList)targetPatterns).getData(i);
                        // �폜�Ώۂɒǉ�
                        getDeleteReseveServicePatterns().add(inMap);
                        // �ǉ��Ώۂɒǉ�
                        getInsertReserveServicePatterns().add(inMap);                        
                        // ���݂��Ȃ������ꍇ�i�����f�[�^�j
                        VRBindPathParser.set(ACCastUtilities.toString(QkanConstants.INTERNAL_SERVICE_PATTERN_NO_BIND_PATH),inMap,ACCastUtilities.toInteger(i+1));
                    }
                }
            }
            
        }else{
            // �̔ԍς݂������ꍇ
            // �p�^�[���ԍ����̔Ԃ���B
            it = patterns.values().iterator();
            while (it.hasNext()) {
                //�T�[�r�X��ޒP�ʂŃp�^�[�����\�[�g����B
                Object row = it.next();
                if (row instanceof VRList) {
                    VRList targetPatterns = (VRList)row;
                    Map treeMap = new TreeMap();
                    ArrayList keyNullList = new ArrayList();
                    
                    //�p�^�[���ԍ����L�[�ɂ��ă\�[�g����B
                    Iterator it2= targetPatterns.iterator();
                    while(it2.hasNext()){
                        VRMap  inMap = (VRMap)it2.next();
                        //�p�^�[���ԍ����L�[�ɂ���TreeMap�ɓ����B�����I�Ƀ\�[�g��������B
                        Object key = inMap.get(ACCastUtilities.toString(QkanConstants.INTERNAL_SERVICE_PATTERN_NO_BIND_PATH));
                        if(key==null){
                            //�Ȃ����T�[�r�X�p�^�[���ԍ������݂��Ȃ������ꍇ
                            keyNullList.add(inMap);
                            // �폜�Ώۂɒǉ�
                            getDeleteReseveServicePatterns().add(inMap);
                            // �ǉ��Ώۂɒǉ�
                            getInsertReserveServicePatterns().add(inMap);                        
                        }else{
                            treeMap.put(key,inMap);
                        }
                    }
                    //�T�[�r�X�p�^�[���ԍ������݂��Ȃ��������̂ɍ̔Ԃ���B
                    it2= keyNullList.iterator();
                    while(it2.hasNext()){
                        VRMap  inMap = (VRMap)it2.next();
                        //���݂̓o�^��+1���̔Ԃ���B
                        Integer key = ACCastUtilities
                                .toInteger(treeMap.size() + 1);
                        VRBindPathParser
                                .set(
                                        ACCastUtilities
                                                .toString(QkanConstants.INTERNAL_SERVICE_PATTERN_NO_BIND_PATH),
                                        inMap, key);
                        treeMap.put(key,inMap);
                    }
                    
                    
                    //�\�[�g���ʂɍ����ւ���B
                    targetPatterns.clear();
                    targetPatterns.addAll(treeMap.values());
                }
            }
        }

        // �T�[�r�X�P�ʌv�Z�N���X�𐶐�����B
        VRMap hashedProviders = new VRHashMap();
        // PROVIDER_ID���L�[�Ƀn�b�V�������A�����ϐ�(hashedProviders)�ɑޔ�����B
        ACBindUtilities.setMapFromArray(QkanCommon
                .getProviderInfo(getDBManager()), hashedProviders,
                "PROVIDER_ID");
        setCalcurater(new CareServiceCodeCalcurater());
        getCalcurater().initialize(getTargetDate(), getPatientInfo(),
                patientInsureInfoHistoryList, hashedProviders, getDBManager(),
                getServiceKindsList(), getInSpecialFacilityFlag(),
                getOldFacilityUserFlag());

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
        setSharedFocusCellRenderer(cellRenderer);
        // �p�^�[���p�l���փZ�������_����ݒ肷��B
        getPatternList().setCellRenderer(cellRenderer);
        getPatternList().setMasterService(masterService);
        cellRenderer.setPatternList(getPatternList());
        // ���ԕ\�փZ�������_����ݒ肷��B
        getMonthlyPanel().setCellRenderer(cellRenderer);
        getMonthlyPanel().setMasterService(masterService);
        
        QkanServiceAbbreviationFormat.getInstance().setMasterService(masterService);
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
                        modifiedFlag = getMonthlyPanel().getScheduleCount()>0;
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

        //�T�[�r�X�p�^�[���̒ǉ��폜�����s����B
        saveServicePattern();

        // �I����������Ȃ��true��Ԃ��B
        return true;
    }

  //�R���|�[�l���g�C�x���g

  /**
   * �u��������v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected void printWeeklyActionPerformed(ActionEvent e) throws Exception{
    // ���T�ԃT�[�r�X�v��\���
    // �@���T�ԃT�[�r�X�v��\���������B
    // �@�@�n��p�p�����[�^ printParam(���R�[�h)�𐶐����A���L�̒l��ݒ肷��B
    VRMap printParam = new VRHashMap();
    // �@�@�@KEY : PATIENT_NAME, VALUE : ���p�Ҏ���
    VRBindPathParser.set("PATIENT_NAME",printParam, getPatientName().getText());
    // �@�@�@KEY : PATIENT_ID, VALUE : ���p�Ҕԍ�(�n��p�����[�^ KEY : PATIENT_ID��VALUE)
    VRBindPathParser.set("PATIENT_CODE",printParam, getPatientInfo().get("PATIENT_CODE"));
    // �@�@�@KEY : CREATE_DATE, VALUE : �쐬�N����(�T�ԕ\����擾)
    // �@�@�@KEY : TARGET_DATE, VALUE : �Ώ۔N��(�n��p�����[�^ KEY : TARGET_DATE��VALUE)
    VRBindPathParser.set("TARGET_DATE",printParam, getTargetDate());
    // �@�@�@KEY : WEEKLY_SERVICE, VALUE : �T�ԕ\�E�T�P�ʂ̃T�[�r�X(���R�[�h�W��)
    VRBindPathParser.set("WEEKLY_SERVICE",printParam, getWeeklyPanel().getAllWeeklySchedule());
    // �@�@�@KEY : NON_WEEKLY_SERVICE, VALUE : �T�ԕ\�E�T�P�ʈȊO�̃T�[�r�X�i���R�[�h�W��)
    VRBindPathParser.set("NON_WEEKLY_SERVICE",printParam, getWeeklyPanel().getAllFreedaySchedule());
    
    Date date=null;
    if((!ACTextUtilities.isNullText(getWeeklyPanel().getCreateDate().getText()))&&  
            getWeeklyPanel().getCreateDate().isValidDate()){
        date = getWeeklyPanel().getCreateDate().getDate();
    }
    VRBindPathParser.set("CREATE_DATE",printParam, date);
    
    VRBindPathParser.set("M_SERVICE",printParam, QkanCommon.getMasterService(getDBManager(), getTargetDate()));
    // �@�@������s���B
    //     doPrint(QS00101, printParam);
    ACChotarouXMLWriter writer=new ACChotarouXMLWriter();
    writer.beginPrintEdit();
    new QS001P01().doPrint(writer, printParam);
    writer.endPrintEdit();
    ACChotarouXMLUtilities.openPDF(writer);
   
  }

  /**
   * �u��������v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected void printMonthlyActionPerformed(ActionEvent e) throws Exception{
    // �����p�[�E�v��[���

      if(!getMonthlyPanel().checkPrintable()){
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
      if(getProcessType()==QkanConstants.PROCESS_TYPE_PLAN){
          mode = QkanConstants.SERVICE_DETAIL_GET_PLAN;
      }else{
          mode = QkanConstants.SERVICE_DETAIL_GET_RESULT;
      }
    new QS001031().showModal(getCalcurater(), 
                getMonthlyPanel().getSchedule(mode, false),
                getProcessType());

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
        if(doInsert()){
            //�o�^�����̃��b�Z�[�W��\������B��ID=INSERT_SUCCESSED
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
        if(doUpdate()){
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
//        VRBindPathParser.set("LOGIN_PROVIDER_ID", param, QkanSystemInformation
//                .getInstance().getLoginProviderID());
        VRBindPathParser.set("TARGET_DATE", param, getTargetDate());
        VRList schedules = null;
        ACDBManager dbm = getDBManager();
        try {
            dbm.beginTransaction();
            VRList list = dbm.executeQuery(getSQL_GET_LAST_PLAN_DATE(param));
            if (list.size() > 0) {
                Object obj = VRBindPathParser.get("TARGET_DATE", (VRMap) list
                        .getData());
                if (obj instanceof Date) {
                    schedules = QkanCommon.getServiceDetail(dbm,
                            getPatientID(), (Date) obj,
                            QkanConstants.SERVICE_DETAIL_GET_PLAN_OF_WEEKLY_ONLY);
                    //���j�[�N�L�[�̍폜
                    Iterator it=schedules.iterator();
                    while(it.hasNext()){
                        Map service=(Map)it.next();
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
//            getMonthlyPanel().setSchedule(schedules);
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
//        if (QkanMessageList.getInstance().QS001_WARNING_OF_CLEAR_MONTHLY() == ACMessageBox.RESULT_OK) {
//            getMonthlyPanel().clearSchedule();
//        }
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
        if(idx>=0){
            getServiceKindList().ensureIndexIsVisible(idx);
        }
        //�ő�p�l�����̈ێ�
        Dimension newDM=getServiceContentSettings().getPreferredSize();
        if(newDM!=null){
            Dimension oldDM=getServicePreferredSize();
            if((oldDM==null)||(oldDM.getWidth()<newDM.getWidth())){
                    //���傫�ȕ���v�����ꂽ
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
            service = (VRMap)service.clone();
            service.setData("SERVICE_USE_TYPE",
                    QkanConstants.SERVICE_USE_TYPE_PATTERN);
            
            // �\�h���Ή��i�v�]�Ή��j
            // 2006/05 TODO
            boolean isEmptyNo = false;
            Object obj = getPatternList().getModelAtBindSource(); 
            while(obj instanceof VRListModelAdapter){
                obj = ((VRListModelAdapter)obj).getAdaptee();
            }
            if(obj instanceof VRList){                
                // ���X�g�̐����[�v����
                VRList list = ((VRList)obj);
                VRMap inMap = new VRHashMap();
                // ���X�g���̓����ԍ���inMap�Ɋi�[����B
                for(int k= 0; k<list.size();k++ ){
                    VRMap map = new VRHashMap();
                    map = (VRMap)list.getData(k);
                    if(VRBindPathParser.has(ACCastUtilities.toString(QkanConstants.INTERNAL_SERVICE_PATTERN_NO_BIND_PATH),map)){
                        inMap.put(ACCastUtilities.toString(map.getData(ACCastUtilities.toString(QkanConstants.INTERNAL_SERVICE_PATTERN_NO_BIND_PATH))),"");
                    }else{
                        inMap.put(ACCastUtilities.toString(k+1),"");
                    }
                }
                
                // �̔ԂɎg���ԍ����擾����
                int count = 0;
                for(int j = 0;j<list.size()+1;j++){
                    count++;
                    if(!VRBindPathParser.has(ACCastUtilities.toString(j+1),inMap)){
                        // �󂫔ԍ�
                        emptyNo = j+1;
                        break;
                    }
                }
                // �󂫔ԍ�������̂�
                if(count <= list.size()){
                    isEmptyNo = true;
                }
                
                service.setData(ACCastUtilities.toString(QkanConstants.INTERNAL_SERVICE_PATTERN_NO_BIND_PATH),new Integer(emptyNo));
            }
            
            service.setData("REGULATION_RATE", new Integer(0));
            
            // �ݒ���e�ŃT�[�r�X�p�^�[����ǉ�
            if(isEmptyNo){
                getNowServicePatterns().add(emptyNo-1,service);
            }else{
                getNowServicePatterns().add(service);
            }
            //���j�[�N�L�[�̍폜
            service.remove("SERVICE_ID");
            
            // 2008/01/24 [Masahiko_Higuchi] add - begin version 5.3.8
            service.remove("CORRECT_KEY");
            service.setData("CORRECT_KEY",new Integer(correctKey));
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
        if(pattern.containsKey("CORRECT_KEY")){
        	// ���C���̃L�[
        	String mainKey = ACCastUtilities.toString(pattern.getData("CORRECT_KEY"),"");
        	
        	for(int i=getInsertReserveServicePatterns().size(); i>0;i--){
        		// �`�F�b�N�p�̃L�[���
        		Map checkMap = (Map)getInsertReserveServicePatterns().getData(i-1);
        		
        		if(checkMap.containsKey("CORRECT_KEY")){
        			// �p�^�[���ǉ��ő��₵��������邽�߂̃L�[
        			String delKey = ACCastUtilities.toString(checkMap.get("CORRECT_KEY"),"-1");
        			
        			if(delKey.equals(mainKey)){
        				// ��v�����ꍇ�͓o�^�p�̃f�[�^�W����������
        				getInsertReserveServicePatterns().remove(i-1);
        				
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
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void serviceOfferEntrepreneurActionPerformed(ActionEvent e)
            throws Exception {
        // �����Ə��R���{�I�����C�x���g
        // ���I���������Ə����ɉ������A�T�[�r�X���e�̍��ڂ̏�Ԑݒ�
        // �@���ݐݒ肳��Ă���u�ڍ׍���(�T�[�r�X�̃p�l��)�v�ɑ΂��A�I���������Ə��ɉ�������Ԑݒ���s���B(providerSelected)
        if (getServiceOfferEntrepreneur().isSelected()) {
            QS001Service service =  getSelectedServiceClass();
            if (service != null) {
                if (service.isUseProvider()) {
                    VRMap provider =(VRMap) getServiceOfferEntrepreneur()
                    .getSelectedModelItem(); 
                    if(service instanceof QS001ServicePanel){
                        ((QS001ServicePanel)service).setSelectedProvider(provider);
                    }
//                    getSelectedServiceClass().initialize();
                    getSelectedServiceClass().providerSelected(provider);
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
                if(CareServiceCommon.isOtherService(data)){
                    //���̑��̃T�[�r�X�̏ꍇ
                    if ((!getWeeklyPanel().isWeeklyServiceList(
                            getSelectedServiceListBox()))
                            || (getWeeklyPanel()
                                    .isDailyServiceList(getSelectedServiceListBox()))) {
                        //�T�Ԃ̃��X�g�ł͂Ȃ��A�܂��͓��퐶����̊������X�g�̏ꍇ
                        //�������Ȃ��B
                        return;
                    }
                }
                if(CareServiceCommon.isDailyAction(data)){
                    //��ȓ��퐶����̊����̏ꍇ
                    if (!getWeeklyPanel().isDailyServiceList(
                            getSelectedServiceListBox())) {
                        //���퐶����̊������X�g�ł͂Ȃ��ꍇ
                        //�������Ȃ��B
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
                    data
                            .setData(
                                    QkanConstants.SERVICE_SYSTEM_BIND_PATH_SPAN,
                                    VRBindPathParser
                                            .get(
                                                    QkanConstants.SERVICE_SYSTEM_BIND_PATH_SPAN,
                                                    service));
                } else if (getSelectedServiceListBox() == getPatternList()) {
                    // �\�h���Ή��i�v�]�Ή��j 
                    // 2005/06
                    data
                            .setData(
                                    ACCastUtilities.toString(QkanConstants.INTERNAL_SERVICE_PATTERN_NO_BIND_PATH),
                                    VRBindPathParser
                                            .get(
                                                    ACCastUtilities.toString(QkanConstants.INTERNAL_SERVICE_PATTERN_NO_BIND_PATH),
                                                    service));
                    
                    // 2008/01/25 [Masahiko_Higuchi] add - begin �T�[�r�X�p�^�[���ݒ�{�^��������s���G���[�Ή�
                    if(service.containsKey("SERVICE_USE_TYPE")){
                        Integer useType = ACCastUtilities.toInteger(service.getData("SERVICE_USE_TYPE"),-1);
                        // �T�[�r�X�p�^�[���̋敪�͕ێ�����
                       if(!new Integer(-1).equals(useType)){
                    	   data.setData("SERVICE_USE_TYPE",useType);
                       }
                       // �T�[�r�XID������������̂ŕێ�����
                       if(service.containsKey("SERVICE_ID")){
                    	   data.setData("SERVICE_ID",service.getData("SERVICE_ID"));
                           
                    	   // ��r�p�̃T�[�r�XID���擾����
                           String mainServiceID = ACCastUtilities.toString(service.getData("SERVICE_ID"),"");
                           // �T�[�r�X�p�^�[���ǉ��p�̃f�[�^�W����S�ă`�F�b�N����B
                           for (int i = getInsertReserveServicePatterns().size(); i > 0; i--) {
                        	   Map serviceIDCheckMap = (Map)getInsertReserveServicePatterns().get(i-1);
                        	   // �i�[����Ă���L�[���擾����
                        	   int idCheckKey = ACCastUtilities.toInt(serviceIDCheckMap.get("SERVICE_ID"),-2);
                        	   
                        	   String checkKey = ACCastUtilities.toString(idCheckKey);
                               // KEY�����ɓo�^����Ă���ꍇ
                               if(checkKey.equals(mainServiceID)){
                            	   // �N���A����
                            	   getInsertReserveServicePatterns().remove(i-1);
                               }                        	   
                           }
                       }
                       
                       // �ǉ������T�[�r�X�p�^�[���ύX�ɔ��������ŐU����KEY�����ɓo�^�f�[�^�̏d����h��
                       if(service.containsKey("CORRECT_KEY")){
                    	   
	                       data.setData("CORRECT_KEY",service.getData("CORRECT_KEY"));
	                       // �폜���Ēǉ��Ώ̂ɂ���
	                       String serviceInKey = ACCastUtilities.toString(service.getData("CORRECT_KEY"),""); 
	
	                       for(int j=getInsertReserveServicePatterns().size();j>0;j--){
	                    	   Map maps = (Map)getInsertReserveServicePatterns().getData(j-1);
	                    	   // �L�[�����o��
	                           int checkKey = ACCastUtilities.toInt(maps.get("CORRECT_KEY"),-1);
	                           
	                           String strKey = ACCastUtilities.toString(checkKey);
	                           // KEY�����ɓo�^����Ă���ꍇ
	                           if(strKey.equals(serviceInKey)){
	                        	   // �N���A����
	                        	   getInsertReserveServicePatterns().remove(j-1);
	                           }
	                       }
                       }
                       
                       getDeleteReseveServicePatterns().add(service);
                	   // �Ēǉ�
                	   getInsertReserveServicePatterns().add(service);
                    } 
                    // �T�[�r�X�p�^�[���̍Đݒ菈��
                    if(service.containsKey("11")){
                        String patternName = ACCastUtilities.toString(service.getData("11"),"");
                        if(!"".equals(patternName)){
                            data.setData("11",patternName);
                        }
                    }
                    // 2008/01/25 [Masahiko_Higuchi] add - End
                }
                
                int selectedIndex=-1;
                if(getSelectedServiceListBox()!=null){
                    selectedIndex=getSelectedServiceListBox().getSelectedIndex();
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
                    }else{
                        service.put("REGULATION_RATE", new Integer(rate));
                    }
                }
                // 2008/01/25 [Masahiko_Higuchi] del - begin �T�[�r�X�p�^�[���ݒ�{�^��������s���G���[�Ή�
                //setServiceModify(true);
                // 2008/01/25 [Masahiko_Higuchi] del - end
                
                if(getSelectedServiceListBox()!=null){
                    getSelectedServiceListBox().setSelectedIndex(selectedIndex);
                    // 2008/01/25 [Masahiko_Higuchi] add - begin �T�[�r�X�p�^�[���ݒ�{�^��������s���G���[�Ή�
                    if(getSelectedServiceListBox() != getPatternList()){
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
  protected void serviceDeleteActionPerformed(ActionEvent e) throws Exception{
    // ���T�ԕ\�E���ԕ\��̃T�[�r�X���̍폜
    // ���T�ԕ\�E���ԕ\��őI������Ă���A�T�[�r�X�����폜����B
      removeSelectedService();
  }

  /**
   * �u�T�ԕ\�E���ԕ\�̐ؑցv�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected void changeChartActionPerformed(ActionEvent e) throws Exception{
    // ���T�ԕ\�E���ԕ\�̕\���ؑ�
      if(getWeeklyPanel().isVisible()){
    // �@���ݕ\������Ă���̂��T�ԕ\�̏ꍇ
    // �@�@���ԕ\�\���������s���B
    showMonthly();
      }else{
    // �@���ݕ\������Ă���̂����ԕ\�̏ꍇ
    // �@�@�T�ԕ\�\���������s���B
    showWeekly();
      }
      clearServiceSelection();
  }

  public static void main(String[] args) {
    //�f�t�H���g�f�o�b�O�N��
    ACFrame.getInstance().setFrameEventProcesser(new QkanFrameEventProcesser());
    QkanCommon.debugInitialize();

    //�e�X�g�p�����^
    VRMap param = new VRHashMap();
//    param.setData("TARGET_DATE", new Date(106,0,8));
    QkanSystemInformation.getInstance().setLoginProviderID("5555555555");
    param.setData("TARGET_DATE", new Date(106,3,1));
//    param.setData("PATIENT_ID", new Integer(38));
    param.setData("PATIENT_ID", new Integer(51));
    param.setData("PROCESS_TYPE", new Integer(QkanConstants.PROCESS_TYPE_PLAN));
//    param.setData("PROCESS_TYPE", new Integer(QkanConstants.PROCESS_TYPE_RESULT));
    
    ACFrame.debugStart(new ACAffairInfo(QS001.class.getName(), param));
  }

  //�����֐�

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
        
        // 2008/03/21 [Masahiko_Higuchi] add - begin ����20�N�x4���@�����Ή��i���×{�^�V�l�ی��{�݁j
        // �o�C���h�p�X�̕ύX�ɂ��ǉ�
        // �×{�����Z�o�C���h�p�X�S
        final String[] RYOYO_TYPE = new String[] {"1230205","1260205","1530205"};
        // �ݔ���o�C���h�o�X�S
        final String[] SETUBI_BASE_TYPE = new String[] {"1230252","1260212","1530260"};
        // H20�N4���ȍ~���Ώ۔N���̏����ł��邩
        boolean isH2004 = false;
        if (ACDateUtilities.getDifferenceOnDay(QkanConstants.H2004,
                getCalcurater().getTargetDate()) < 1) {
            isH2004 = true;
        }
        // 2008/03/21 [Masahiko_Higuchi] add - end
        
        // 2008/04/21 [Masahiko_Higuchi] add - begin ����20�N�x5���@�����Ή��i���×{�^�V�l�ی��{�݁j
        boolean isH2005 = false;
        if (ACDateUtilities.getDifferenceOnDay(QkanConstants.H2005,
                getCalcurater().getTargetDate()) < 1) {
            isH2005 = true;
        }
        final String[] SHISETUKUBUN_TAISEI = new String[] {"1220120","1520132","1250113"};
        final String[] RYOYOTAISEIIJI = new String[] {"1220121","1520134","1250114"};
        final String[] TERMINAlCARE = new String[] {"1520133"};
        // 2008/04/21 [Masahiko_Higuchi] add - end
        
        // [ID:0000444][Masahiko Higuchi] 2009/03 add begin ����21�N4���@�����Ή�
        boolean isH2104  =false;
        if (ACDateUtilities.getDifferenceOnDay(QkanConstants.H2104,
                getCalcurater().getTargetDate()) < 1) {
            isH2104 = true;
        }
        // [ID:0000444][Masahiko Higuchi] 2009/03 add end        
        
        // �����̓`�F�b�N
        final String[] SENMONIN_NO_TYPE = new String[] { "1430107", "1730104",
                "1750104","1460103" };
        // �\�h���Ή��i�v�]�j
        // 2005/05/31
        // �����x�������ԍ��������͂̏ꍇ�̖����̓`�F�b�N
        while (it.hasNext()) {
            VRMap row = (VRMap) it.next();
            if(CareServiceCommon.isCareManagement(row)||CareServiceCommon.isFacilityVisitMultifunction(row)){
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
                if(!isInputSenmoninNo){
                    // �G���[���b�Z�[�W��\������B
                    if(QkanMessageList.getInstance().QS001_WARNING_OF_SENMONIN_NO()==ACMessageBox.RESULT_OK){
                        // 1�x���b�Z�[�W���o����������o���Ȃ�
                        break;
                    }else{
                        // OK�ȊO�͏����𒆎~
                        return false;
                    }

                }
            }
            
            // [ID:0000456][Masahiko Higuchi] 2009/03 edit begin ����21�N4���@�����Ή�
            // ����21�N4���ȍ~�̏����͕��򂳂���
            int lowVer = CareServiceCommon.getServiceLowVersion(row);
            if(isH2104) {
                //����21�N4���ȍ~�̏ꍇ
                // �@�����敪�ɂ��ߋ��f�[�^�̔���
                if(lowVer != QkanConstants.SERVICE_LOW_VERSION_H2104){
                    //�@�����敪��20090401�ȊO�̃T�[�r�X�̏ꍇ
                    Date serviceDate = ACCastUtilities.toDate(VRBindPathParser
                            .get("SERVICE_DATE", row), null);
                    String dayOfMonth = "";
                    if (serviceDate != null) {
                        dayOfMonth = ACDateUtilities.getDayOfMonth(serviceDate)
                                + "����";
                    }
                    VRMap serviceKind = ACBindUtilities.getMatchRowFromValue(
                            getServiceKindsList(),
                            "SYSTEM_SERVICE_KIND_DETAIL", row
                                    .get("SYSTEM_SERVICE_KIND_DETAIL"));
                    String serviceKindName = "�T�[�r�X";
                    if (serviceKind != null) {
                        serviceKindName = ACCastUtilities.toString(serviceKind
                                .get("SERVICE_ABBREVIATION"));
                    }
                    // �G���[���b�Z�[�W
                    QkanMessageList.getInstance().QS001_ERROR_OF_INVALID_SERVICE_LOW_VERSION(dayOfMonth, serviceKindName);
                    return false;
                } 
            } else {
                //����21�N4�����O�̏ꍇ
                // �@�����敪�ɂ��ߋ��f�[�^�̔���
                if(lowVer == QkanConstants.SERVICE_LOW_VERSION_H2104) {
                    //�@�����敪��20090401�̃T�[�r�X�̏ꍇ
                    Date serviceDate = ACCastUtilities.toDate(VRBindPathParser
                            .get("SERVICE_DATE", row), null);
                    String dayOfMonth = "";
                    if (serviceDate != null) {
                        dayOfMonth = ACDateUtilities.getDayOfMonth(serviceDate)
                                + "����";
                    }
                    VRMap serviceKind = ACBindUtilities.getMatchRowFromValue(
                            getServiceKindsList(),
                            "SYSTEM_SERVICE_KIND_DETAIL", row
                                    .get("SYSTEM_SERVICE_KIND_DETAIL"));
                    String serviceKindName = "�T�[�r�X";
                    if (serviceKind != null) {
                        serviceKindName = ACCastUtilities.toString(serviceKind
                                .get("SERVICE_ABBREVIATION"));
                    }
                    // �G���[���b�Z�[�W
                    QkanMessageList.getInstance().QS001_ERROR_OF_INVALID_SERVICE_LOW_VERSION(dayOfMonth, serviceKindName);
                    return false;
                } 
                
                // 2008/03/21 [Masahiko_Higuchi] add - begin ����20�N�x4���@�����Ή��i���×{�^�V�l�ی��{�݁j
                // �ߋ��f�[�^����̕s���f�[�^���c���Ȃ��悤�Ƀ`�F�b�N����
                if(isH2004){
                    // �×{�a����L����f�Ï��̃T�[�r�X�ł��邩
                    if(CareServiceCommon.isPracticeToHealthFacilityServices(row)){
                        // �×{�����Z�����݂��邩�B
                        boolean isRyoyoGensan = false;
                        boolean isSetubiGensan = false;
                        for(int j=0; j< RYOYO_TYPE.length; j++){
                            // �×{�����Z���ݒ肳��Ă��邩�B
                            Object obj = VRBindPathParser.get(RYOYO_TYPE[j], row);
                            // ���ݒ�A���Z�^�T�ȊO�̏ꍇ�͐���
                            if (obj != null && ACCastUtilities.toInt(obj) != 2
                                    && ACCastUtilities.toInt(obj) != 0) {
                                isRyoyoGensan = true;
                                break;
                            }
                        }
                        // �ݔ�����Z�����݂��邩�B
                        for(int k=0; k< SETUBI_BASE_TYPE.length; k++){
                            // �ݔ�����Z���ݒ肳��Ă��邩�B
                            Object obj = VRBindPathParser.get(SETUBI_BASE_TYPE[k], row);
                            // �ݔ���ɒl���ݒ肳��Ă���ꍇ��
                            if(ACCastUtilities.toInt(obj,0) != 0){
                                isSetubiGensan = true;
                                break;                            
                            }
                        }
                        // �ǂ��炩����ł��s���f�[�^�ł���ꍇ
                        if(!(isRyoyoGensan && isSetubiGensan)){
                            QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
                            return false;
                        }
                    }
                }
                // 2008/03/21 [Masahiko_Higuchi] add - end
                // 2008/04/21 [Masahiko_Higuchi] add - begin ����20�N�x5���@�����Ή��i���×{�^�V�l�ی��{�݁j
                if(isH2005){
                    // �V���{�݂̃T�[�r�X�ł���ꍇ
                    if(CareServiceCommon.isElderlyToHealthFacilityServices(row)){
                        boolean isShisetuTaisei = false;
                        boolean isRyoyoTaisei = false;
                        isRyoyoTaisei = checkValidSysteBindPath(RYOYOTAISEIIJI, row);
                        // ���A��V���[�g�X�e�C�I�����͎{�ݓ��̋敪�̃`�F�b�N�̓X���[
                        if(row != null && ACCastUtilities.toInt(row.getData("1220101"),0) == 3){
                            isShisetuTaisei = true;
                        }else{
                            // �{�ݓ��̋敪�i�̐��j�̃`�F�b�N����
                            isShisetuTaisei = checkValidSysteBindPath(SHISETUKUBUN_TAISEI, row);
                        }
                        // �G���[���b�Z�[�W
                        if(!isShisetuTaisei && !isRyoyoTaisei){
                            QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
                            return false;
                        }
                        
                    }
                    // �ʂɎ��o��
                    int code = -1;
                    if(row==null){
                        code = -1;
                    }else{
                        code = ACCastUtilities.toInt(row.get("SYSTEM_SERVICE_KIND_DETAIL"),-1);
                    }
                    // ���V�l�ی��{�݂ł��邩
                    switch(code){
                    case 15211:
                        boolean isTerminalAdd = false;
                        isTerminalAdd = checkValidSysteBindPath(TERMINAlCARE, row);
                        // �^�[�~�i���P�A���Z�̂݌ʃ`�F�b�N
                        if(!isTerminalAdd){
                            QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
                            return false;
                        }
                        
                        int index = ACCastUtilities.toInt(row.getData("1520101"), 0);
                        if (index != 1 && index != 3) {
                            // �{�ݓ��̋敪�ŏ��K�͂̃f�[�^�o�^���s�����Ƃ����ꍇ
                            QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
                            return false;
                        }
                        break;
                    }
                    
                }
                // 2008/04/21 [Masahiko_Higuchi] add - end            
                
            }
            // [ID:0000456][Masahiko Higuchi] 2009/03 edit end
        }

        // [ID:0000456][Tozo TANAKA] 2009/03/12 add begin ����21�N4���@�����Ή�
        //���񐔃`�F�b�N
        if (isH2104) {
            //�Ώ۔N�����A����21�N4���ȍ~�̏ꍇ
            //��������x���E�񐔃`�F�b�N
            
            //������x���̌��o�񐔂�\�����l�ϐ�countOf14311���`���A0�ŏ���������B
            int countOf14311 = 0;
            //���\�h�x���̌��o�񐔂�\�����l�ϐ�countOf14611���`���A0�ŏ���������B
            int countOf14611 = 0;
            final String BIND_PATH_OF_SYSTEM_SERVICE_KIND_DETAIL = "SYSTEM_SERVICE_KIND_DETAIL";
    
            //���ԕ\��̃T�[�r�X��S��������B
            it = list.iterator();
            while (it.hasNext()) {
                VRMap row = (VRMap) it.next();
                //�G���[�ƂȂ����T�[�r�X����\��������ϐ�errorService���`���Anull�ŏ���������B
                String errorService=null;
                switch (ACCastUtilities.toInt(VRBindPathParser.get(
                        BIND_PATH_OF_SYSTEM_SERVICE_KIND_DETAIL, row), 0)) {
                case 14311:
                    //�T�[�r�X��������x���̏ꍇ
                    //countOf14311��1�����Z����B
                    if(++countOf14311>=2){
                        //countOf14311��2�ȏ�̏ꍇ
                        //errorService��"������x��"��������B
                        errorService = "������x��";
                    }
                    break;
                case 14611:
                    //�T�[�r�X�����\�h�x���̏ꍇ
                    //countOf14611��1�����Z����B
                    if(++countOf14611>=2){
                        //countOf14611��2�ȏ�̏ꍇ
                        //errorService��"���\�h�x��"��������B
                        errorService = "���\�h�x��";
                    }
                    break;
                }
                if(errorService!=null){
                    //errorService��null�ł͂Ȃ��ꍇ
                    //����񐔂𒴂��Ă���|�̃G���[(ERROR_OF_SERVICE_COUNT_OVER)��\������B
                    QkanMessageList.getInstance().QS001_ERROR_OF_SERVICE_COUNT_OVER(errorService, new Integer(1));
                    //�߂�lfalse��Ԃ��ď������I������B
                    return false;
                }
            }
            
            //�����̑��̉񐔒��ߌx���`�F�b�N

            //��n�������Ƃ�����Z
            String[][] monthlyAddCountChecks = new String[][]{
                    //SERVICE_NAME,SYSTEM_SERVICE_KIND_DETAIL,���Z��,SYSTEM_BIND_PATH,�v�シ��l,���
                    //���ʏ����E�ʏ����n
                    //�h�{���P���Z�F��2��
                    //���o�@�\�F��2��
                    {"�ʏ����","11511","�h�{���P���Z","1150116","2","2",},
                    {"�ʏ����","11511","���o�@�\������Z","1150112","2","2",},
                    {"�ʏ����n","11611","�h�{���P���Z","1160114","2","2",},
                    {"�ʏ����n","11611","���o�@�\������Z","1160115","2","2",},
                    {"�F�m�ǑΉ��^�ʏ����","17211","�h�{���P���Z","1720105","2","2",},
                    {"�F�m�ǑΉ��^�ʏ����","17211","���o�@�\������Z","1720108","2","2",},
                    //���ʏ����n
                    //�ʃ��n���Z�F��13��
                    {"�ʏ����n","11611","�ʃ��n�r�����{���Z","1160118","2","13",},
                    //��������x��
                    //��ØA�g���Z�F��1��(������x�����́A�Ђƌ���2�z�u������G���[�ɂȂ�)
                    //{"������x��","14311","��Ë@�֘A�g���Z","1430109","2","1",},
            };
            //�Tn�������Ƃ���T�[�r�X
            String[][] weeklyServiceCountChecks = new String[][]{
                    //SERVICE_NAME,SYSTEM_SERVICE_KIND_DETAIL,���
                    //���K�⃊�n
                    //1�T�Ԃ�6��
                    {"�K�⃊�n","11411","6",},
            };
            
            //��n��������Ƃ�����Z
            String[][] monthlyDayAddCountChecks = new String[][]{
                    //SERVICE_NAME,SYSTEM_SERVICE_KIND_DETAIL,���Z��,SYSTEM_BIND_PATH,�v�シ��l,���
                    //�����{�E�V���E�×{�^
                    //�O���F��6��
                    {"���V�l�����{��","15111","�O�����Z","1510111","2","6",},
                    {"���V�l�ی��{��","15211","�O�����Z","1520107","2","6",},
                    {"���×{�^��Î{��(�a�@�×{�^)","15311","�O�����Z","1530108","2","6",},
                    {"���×{�^��Î{��(�f�Ï��^)","15312","�O�����Z","1530206","2","6",},
                    {"���×{�^��Î{��(�F�m�ǎ����^)","15313","�O�����Z","1530305","2","6",},
            };
            int[] monthlyAddCountResults = new int[monthlyAddCountChecks.length];
            int[][] weeklyServiceCountResults = new int[weeklyServiceCountChecks.length][6];
            int[] monthlyDayAddCountResults = new int[monthlyDayAddCountChecks.length];
            boolean[][] monthlyDayAddFindFlags = new boolean[monthlyDayAddCountChecks.length][32];

            int end;
            end = monthlyAddCountChecks.length;
            for(int i=0; i<end; i++){
                monthlyAddCountResults[i] = ACCastUtilities.toInt(monthlyAddCountChecks[i][5]);
            }
            end = weeklyServiceCountChecks.length;
            for(int i=0; i<end; i++){
                int limit = ACCastUtilities.toInt(weeklyServiceCountChecks[i][2]);
                for(int j=0; j<6; j++){
                    weeklyServiceCountResults[i][j] = limit;
                }
            }
            end = monthlyDayAddCountChecks.length;
            for(int i=0; i<end; i++){
                monthlyDayAddCountResults[i] = ACCastUtilities.toInt(monthlyDayAddCountChecks[i][5]);
            }
            
            //���ԕ\��̃T�[�r�X��S��������B
            it = list.iterator();
            while (it.hasNext()) {
                VRMap row = (VRMap) it.next();
                
                String systemServiceKindDetail = ACCastUtilities.toString(VRBindPathParser.get("SYSTEM_SERVICE_KIND_DETAIL", row));
                Date visitDay = ACCastUtilities.toDate(VRBindPathParser.get("SERVICE_DATE", row), null);

                //�x�����b�Z�[�W�̗v�f�Ƃ��Ĉȉ��̕�����ϐ����`��null�ŏ���������B
                //warningTargetName
                String warningTargetName = null;
                //warningTargetSpan
                String warningTargetSpan = null;
                //warningTargetLimit
                String warningTargetLimit = null;
                
                //��n�������Ƃ�����Z���`�F�b�N����B
                end = monthlyAddCountChecks.length;
                for(int i=0; i<end; i++){
                    if(monthlyAddCountChecks[i][1].equals(systemServiceKindDetail)){
                        //�V�X�e���T�[�r�X��ނ��Y�������ꍇ
                        Object val=VRBindPathParser.get(monthlyAddCountChecks[i][3], row);
                        if(val != null){
                            //BindPath���Y�������ꍇ
                            if(monthlyAddCountChecks[i][4].equals(ACCastUtilities.toString(val))){
                                //�v�シ�ׂ��l���Y�������ꍇ
                                //���P�ʉ��Z�c�񐔂�1�����Z����B
                                monthlyAddCountResults[i]--;
                                if(monthlyAddCountResults[i]==-1){
                                    //���P�ʉ��Z�c�񐔂�0����������ꍇ
                                    
                                    //�x�����b�Z�[�W�̗v�f�Ƃ��Ĉȉ��̕ϐ���������B
                                    //warningTargetName = SERVICE_NAME+"��"+���Z��
                                    warningTargetName = monthlyAddCountChecks[i][0]+"��"+monthlyAddCountChecks[i][2];
                                    //warningTargetName = "�Ђƌ���"
                                    warningTargetSpan = "�Ђƌ���";
                                    //warningTargetLimit = ���+"��܂�"
                                    warningTargetLimit = monthlyAddCountChecks[i][5]+"��܂�";

                                    //�x�����b�Z�[�WQS001_WARNING_OF_SERVICE_COUNT_OVER��\������B
                                    if (QkanMessageList.getInstance()
                                            .QS001_WARNING_OF_SERVICE_COUNT_OVER(
                                                    warningTargetName, warningTargetSpan,
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

                //�Tn�������Ƃ���T�[�r�X���`�F�b�N����B
                end = weeklyServiceCountChecks.length;
                for(int i=0; i<end; i++){
                    if(weeklyServiceCountChecks[i][1].equals(systemServiceKindDetail)){
                        //�V�X�e���T�[�r�X��ނ��Y�������ꍇ
                        if (visitDay != null) {
                            //�T�P�ʉ��Z�c�񐔂̓��Y�T�ڂ�1�����Z����B
                            int week = ACDateUtilities.getWeekOfMonth(visitDay);
                            weeklyServiceCountResults[i][week]--;
                            if(weeklyServiceCountResults[i][week]==-1){
                                //�T�P�ʎc�񐔂�0����������ꍇ
                                
                                //�x�����b�Z�[�W�̗v�f�Ƃ��Ĉȉ��̕ϐ���������B
                                //warningTargetName = SERVICE_NAME
                                warningTargetName = weeklyServiceCountChecks[i][0];
                                //warningTargetName = "�e�T��"
                                warningTargetSpan = "�e�T��";
                                //warningTargetLimit = ���+"��܂�"
                                warningTargetLimit = weeklyServiceCountChecks[i][2]+"��܂�";

                                //�x�����b�Z�[�WQS001_WARNING_OF_SERVICE_COUNT_OVER��\������B
                                if (QkanMessageList.getInstance()
                                        .QS001_WARNING_OF_SERVICE_COUNT_OVER(
                                                warningTargetName, warningTargetSpan,
                                                warningTargetLimit) != ACMessageBox.RESULT_OK) {
                                    // �uOK�v�ȊO�I����
                                    // �߂�l�Ƃ���false��Ԃ��B
                                    return false;
                                }
                            }
                        }
                    }
                }
                
                //��n��������Ƃ�����Z���`�F�b�N����B
                end = monthlyDayAddCountChecks.length;
                for(int i=0; i<end; i++){
                    if(monthlyDayAddCountChecks[i][1].equals(systemServiceKindDetail)){
                        //�V�X�e���T�[�r�X��ނ��Y�������ꍇ
                        Object val=VRBindPathParser.get(monthlyDayAddCountChecks[i][3], row);
                        if(val != null){
                            //BindPath���Y�������ꍇ
                            if(monthlyDayAddCountChecks[i][4].equals(ACCastUtilities.toString(val))){
                                //�v�シ�ׂ��l���Y�������ꍇ
                                int mday = ACDateUtilities.getDayOfMonth(visitDay);
                                if (!monthlyDayAddFindFlags[i][mday]) {
                                    //���P�ʓ��ʉ��Z�����t���O�̓��Y�����U(������)�̏ꍇ
                                    //���P�ʓ��ʉ��Z�����t���O�̓��Y����^(������)�ɂ���B
                                    monthlyDayAddFindFlags[i][mday] = true;
                                    //���P�ʓ��ʉ��Z�c�񐔂�1�����Z����B
                                    monthlyDayAddCountResults[i]--;
                                    if(monthlyDayAddCountResults[i]==-1){
                                        //���P�ʓ��ʉ��Z�c�񐔂�0����������ꍇ
                                        
                                        //�x�����b�Z�[�W�̗v�f�Ƃ��Ĉȉ��̕ϐ���������B
                                        //warningTargetName = SERVICE_NAME+"��"+���Z��
                                        warningTargetName = monthlyDayAddCountChecks[i][0]+"��"+monthlyDayAddCountChecks[i][2];
                                        //warningTargetName = "�Ђƌ���"
                                        warningTargetSpan = "�Ђƌ���";
                                        //warningTargetLimit = ���+"���܂�"
                                        warningTargetLimit = monthlyDayAddCountChecks[i][5]+"���܂�";

                                        //�x�����b�Z�[�WQS001_WARNING_OF_SERVICE_COUNT_OVER��\������B
                                        if (QkanMessageList.getInstance()
                                                .QS001_WARNING_OF_SERVICE_COUNT_OVER(
                                                        warningTargetName, warningTargetSpan,
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
                
            }
        }
        // [ID:0000456][Tozo TANAKA] 2009/03/12 add end
        
        
        it = list.iterator();

        // [ID:0000456][Masahiko Higuchi] 2009/03 edit begin ����21�N4���@�����Ή�
        int overFlowCount = 0;
        int overflowIndex = -1;
        
        if (isH2104) {
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
    
                    Date visitDay = ACCastUtilities.toDate(VRBindPathParser.get(
                            "SERVICE_DATE", row), null);
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
            int end = visitCounts.length;
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
            
        } else {
                
            // ������×{�Ǘ��w���E�񐔃`�F�b�N
            // ����×{�Ǘ��w���T�[�r�X�̃T�[�r�X�񐔂��`�F�b�N����(���ԕ\)�B���ꂼ��̏���񐔂͉��L�̂Ƃ���Ƃ���B
            // ��t�E���Ȉ�t : 2��
            // ��܎t(��Ë@��) : 2��
            // ��܎t(���) : 4��
            // �Ǘ��h�{�m : 2��
            // ���ȉq���m�� : 4��
            // H18�N4���@�����ɂ��A�K�������̏ꍇ�͈ȉ�������Ƃ���B
            // ��܎t(��Ë@��)�K������ : 8��
            // ��܎t(���)�K������ : 8��
            // ���T2��܂�
    
            final Integer VISITOR_TYPE_PATH = new Integer(1310103);
            final Integer GAN_PATH = new Integer(1310110);
    
            final int VISITOR_TYPE_COUNT = 7;
            // [�E���敪][��n�T]�̖K���
            int[][] weeklyCounts = new int[VISITOR_TYPE_COUNT][7];
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
    
                    Date visitDay = ACCastUtilities.toDate(VRBindPathParser.get(
                            "SERVICE_DATE", row), null);
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
                    }, {// �K���������܂ޏꍇ
                    0,// �_�~�[
                            2, // ��t
                            2, // ���Ȉ�t
                            8, // ��܎t(��Ë@��)
                            8, // ��܎t(���)
                            2, // �Ǘ��h�{�m
                            4, // ���ȉq���m��
                    } };
            int end = visitCounts.length;
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
        }
        // [ID:0000456][Masahiko Higuchi] 2009/03 edit end
        
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
            String[] names = {""};
            if(isH2104) {
                // ����21�N4���ȍ~�͋敪���ǉ������
                names = new String[] {"", "��t", "���Ȉ�t", "��܎t(��Ë@��)",
                        "��܎t(���)", "�Ǘ��h�{�m", "���ȉq���m��", "�Ō�E��" , };                
            } else { 
                names = new String[] {"", "��t", "���Ȉ�t", "��܎t(��Ë@��)",
                    "��܎t(���)", "�Ǘ��h�{�m", "���ȉq���m��", };
            }
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
                    Object obj  = VRBindPathParser.get("PROVIDER_ID", row);
                    if(obj != null){
                        //���Ə��ԍ���null�łȂ��ꍇ
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
                // ���ԕ\����details�����
                details.addAll(getWeeklyPanel().getSchedule());
                details.addAll(getMonthlyPanel().getSchedule(
                        QkanConstants.SERVICE_DETAIL_GET_RESULT, true));
                
                // �v��P�ʐ���ۑ�����B
                Iterator it = getMonthlyPanel().getServicePlanUnits().values().iterator();
                while (it.hasNext()) {
                    VRMap planUnits = (VRMap) it.next();
                    if ((planUnits != null) && (!planUnits.isEmpty())) {
                        final Integer zero = new Integer(0);
                        VRMap systemService = new VRHashMap();
                        VRBindPathParser
                                .set(
                                        "SERVICE_USE_TYPE",
                                        systemService,
                                        QkanConstants.SERVICE_USE_TYPE_RESULT_MONTHLY_DAY);
                        VRBindPathParser.set("PROVIDER_ID", systemService, "");
                        VRBindPathParser
                                .set(
                                        "SYSTEM_SERVICE_KIND_DETAIL",
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
            Iterator it = details.iterator();
            while (it.hasNext()) {
                VRMap row = (VRMap) it.next();
                try{
                    VRBindPathParser.set("PATIENT_ID", row, new Integer(
                        getPatientID()));
                }catch(java.util.ConcurrentModificationException ex){
                    //�C�e���[�V�����̓�����O�͖���
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
                
                // 2007/12/25 [Masahiko_Higuchi] add - begin Version 5.3.8�@2007�N�x�Ή�
                for(int i=0;i<details.size();i++){
                    VRMap delMap = (VRMap)details.getData(i);
                    // 2008/06/24 [Masahiko.Higuchi] V5.4.1 edit - begin ������O���������邱�Ƃ�����悤�Ȃ̂őΉ�
                    try{
                        // ��͗p�̃L�[�͏���
                        delMap.remove("ANALYZE");
                        delMap.remove("CORRECT_KEY");
                    }catch(java.util.ConcurrentModificationException ex){
                        //������O�͖���                        
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
                    dbm
                            .executeUpdate(getSQL_INSERT_PASSIVE_CHECK_RECORD(getPassiveCheckSQLParam()));
                } else {
                    // �X�V���[�h�̏ꍇ
                    dbm
                            .executeUpdate(getSQL_UPDATE_PASSIVE_CHECK_RECORD(getPassiveCheckSQLParam()));
                    //���ъm����̔j��
                    QkanCommon.updateClaimDetail(dbm, new VRArrayList(), getTargetDate(), getPatientID());
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
        Iterator it = plans.iterator();
        while (it.hasNext()) {
            // USE_TYPE���\��̂��̂ɂȂ��Ă���̂ŁA���тɍ����ւ���
            VRMap row = (VRMap) it.next();
            Integer useType = new Integer(ACCastUtilities
                    .toString(VRBindPathParser.get("SERVICE_USE_TYPE", row)));
            if (QkanConstants.SERVICE_USE_TYPE_PLAN_MONTHLY_DAY.equals(useType)) {
                VRBindPathParser.set("SERVICE_USE_TYPE", row,
                        QkanConstants.SERVICE_USE_TYPE_RESULT_MONTHLY_DAY);
            } else if (QkanConstants.SERVICE_USE_TYPE_PLAN_MONTHLY_FREE_DAY
                    .equals(useType)) {
                VRBindPathParser.set("SERVICE_USE_TYPE", row,
                        QkanConstants.SERVICE_USE_TYPE_RESULT_MONTHLY_FREE_DAY);
            }
            //�L�[���폜
            row.remove("SERVICE_ID");
        }
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
        //���T�[�r�X�p�^�[���̏���W�J 
        //�T�[�r�X���e�o�^�E�I��̈�(servuceDetails)�ɑI�������p�^�[���̏����o�C���h����B
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
    // 2008/03/18 [Masahiko_Higuchi] edit - end
        // �����ݑI�𒆂̓Ǝ��T�[�r�X��ރR�[�h�ɑΉ�����T�[�r�X�p�^�[���N���X�𐶐�
        // �����ݑI�𒆂̓Ǝ��T�[�r�X��ރR�[�h(selectedServiceKind)�����ƂɃT�[�r�X�p�^�[���N���X(QS001003�`)�𐶐����ĕԂ��B
        switch (getSelectedServiceKind()) {
        //����18�N4��������
        case 11111://�K����
            // [ID:0000444][Masahiko Higuchi] 2009/02 add begin ����21�N4���@�����Ή�
            if (ACDateUtilities.getDifferenceOnDay(QkanConstants.H2104, targetDate) < 1) {
                return new QS001101_H2104();
            }
            // [ID:0000444][Masahiko Higuchi] add end
            
            return new QS001101();
            
        case 11211://�K��������
            // [ID:0000444][Masahiko Higuchi] 2009/02 add begin ����21�N4���@�����Ή�
            if (ACDateUtilities.getDifferenceOnDay(QkanConstants.H2104, targetDate) < 1) {
                return new QS001102_H2104();
            }
            // [ID:0000444][Masahiko Higuchi] add end
            
            return new QS001102();
            
        case 11311://�K��Ō�(���ی�)
            // [ID:0000444][Masahiko Higuchi] 2009/02 add begin ����21�N4���@�����Ή�
            if (ACDateUtilities.getDifferenceOnDay(QkanConstants.H2104, targetDate) < 1) {
                return new QS001103_H2104();
            }
            // [ID:0000444][Masahiko Higuchi] add end
            
            return new QS001103();
            
//        case 20101://�K��Ō�(��Õی�)
//            return new QS001104();  
        case 11411://�K�⃊�n�r���e�[�V����
            // [ID:0000444][Masahiko Higuchi] 2009/02 add begin ����21�N4���@�����Ή�
            if (ACDateUtilities.getDifferenceOnDay(QkanConstants.H2104, targetDate) < 1) {
                return new QS001105_H2104();
            }
            // [ID:0000444][Masahiko Higuchi] add end
            
            return new QS001105();
            
        case 11511://�ʏ����
            // [ID:0000444][Masahiko Higuchi] 2009/02 add begin ����21�N4���@�����Ή�
            if (ACDateUtilities.getDifferenceOnDay(QkanConstants.H2104, targetDate) < 1) {
                return new QS001107_H2104();
            }
            // [ID:0000444][Masahiko Higuchi] add end
            
            return new QS001107();  
            
        case 11611://�ʏ����n�r���e�[�V����
            // [ID:0000444][Masahiko Higuchi] 2009/02 add begin ����21�N4���@�����Ή�
            if (ACDateUtilities.getDifferenceOnDay(QkanConstants.H2104, targetDate) < 1) {
                return new QS001108_H2104();
            }
            // [ID:0000444][Masahiko Higuchi] add end
            
            return new QS001108();  
        case 11711://�����p��ݗ^
            // [ID:0000444][Masahiko Higuchi] 2009/02 add begin ����21�N4���@�����Ή�
            if (ACDateUtilities.getDifferenceOnDay(QkanConstants.H2104, targetDate) < 1) {
                return new QS001116_H2104();
            }
            // [ID:0000444][Masahiko Higuchi] add end
            
            return new QS001116();  
        case 12111://�Z�������������
            // [ID:0000444][Masahiko Higuchi] 2009/02 add begin ����21�N4���@�����Ή�
            if (ACDateUtilities.getDifferenceOnDay(QkanConstants.H2104, targetDate) < 1) {
                return new QS001109_H2104();
            }
            // [ID:0000444][Masahiko Higuchi] add end
            
            return new QS001109();
            
        case 12211://�Z�������×{���(�V��)
            // [ID:0000444][Masahiko Higuchi] edit begin ����21�N4���@�����Ή�
            if (ACDateUtilities.getDifferenceOnDay(QkanConstants.H2104, targetDate) < 1) {
                return new QS001110_H2104();
                
            } else if(ACDateUtilities.getDifferenceOnDay(QkanConstants.H2005, targetDate)<1){
                // 2008/04/14 [Masahiko_Higuchi] edit - begin ����20�N5���@�����Ή�
                return new QS001110_H2005();
                
            }else{
                return new QS001110();
            }
            // 2008/04/14 [Masahiko_Higuchi] edit - end
            // [ID:0000444][Masahiko Higuchi] edit end
            
        case 12311://�Z�������×{���(�×{�a����L����a�@)
            // [ID:0000444][Masahiko Higuchi] 2009/02 add begin ����21�N4���@�����Ή�
            if (ACDateUtilities.getDifferenceOnDay(QkanConstants.H2104, targetDate) < 1) {
                return new QS001111_H2104();
            }
            // [ID:0000444][Masahiko Higuchi] add end
            return new QS001111();
            
        case 12312://�Z�������×{���(�×{�a����L����f�Ï�)
            // [ID:0000444][Masahiko Higuchi] edit begin ����21�N4���@�����Ή�
            if (ACDateUtilities.getDifferenceOnDay(QkanConstants.H2104, targetDate) < 1) {
                return new QS001112_H2104();
                
            } else if(ACDateUtilities.getDifferenceOnDay(QkanConstants.H2004, targetDate)<1){
                // 2008/03/18 [Masahiko_Higuchi] edit - begin ����20�N4���@�����Ή�
                // ����20�N4���ȍ~�͐������ύX����
        		return new QS001112_H2004();
                
        	}else{
        		return new QS001112();
        	}
        	// 2008/03/18 [Masahiko_Higuchi] edit - end
            // [ID:0000444][Masahiko Higuchi] edit end
            
        case 12313://�Z�������×{���(�V�l���F�m�ǎ����×{�a����L����a�@)
            // [ID:0000444][Masahiko Higuchi] 2009/02 add begin ����21�N4���@�����Ή�
            if (ACDateUtilities.getDifferenceOnDay(QkanConstants.H2104, targetDate) < 1) {
                return new QS001113_H2104();
            }
            // [ID:0000444][Masahiko Higuchi] add end            
            return new QS001113();
            
        case 12314://�Z�������×{���(��K���f�Ï�)
            return new QS001114();  
            
        case 13111:// ����×{�Ǘ��w��
            // [ID:0000444][Masahiko Higuchi] 2009/02 add begin ����21�N4���@�����Ή�
            if(ACDateUtilities.getDifferenceOnDay(QkanConstants.H2104, targetDate)<1){
                return new QS001106_H2104();
            }
            // [ID:0000444][Masahiko Higuchi] add end            
            return new QS001106();
            
        case 13211://�F�m�ǑΉ��^�����������(�Z�����p�ȊO)
            // [ID:0000444][Masahiko Higuchi] 2009/02 add begin ����21�N4���@�����Ή�
            if(ACDateUtilities.getDifferenceOnDay(QkanConstants.H2104, targetDate)<1){
                return new QS001126_H2104();
            }
            // [ID:0000444][Masahiko Higuchi] add end
            return new QS001126();  
            
        case 13311://����{�ݓ����Ґ������
            // [ID:0000444][Masahiko Higuchi] 2009/02 add begin ����21�N4���@�����Ή�
            if(ACDateUtilities.getDifferenceOnDay(QkanConstants.H2104, targetDate)<1){
                return new QS001115_H2104();
            }
            // [ID:0000444][Masahiko Higuchi] add end
            return new QS001115();
            
        case 13611://�n�斧���^����{�ݓ����Ґ������
            // [ID:0000444][Masahiko Higuchi] 2009/02 add begin ����21�N4���@�����Ή�
            if(ACDateUtilities.getDifferenceOnDay(QkanConstants.H2104, targetDate)<1){
                return new QS001128_H2104();
            }
            // [ID:0000444][Masahiko Higuchi] add end
            return new QS001128();
            
        case 13811://�F�m�ǑΉ��^�����������(�Z�����p)
            // [ID:0000444][Masahiko Higuchi] 2009/02 add begin ����21�N4���@�����Ή�
            if(ACDateUtilities.getDifferenceOnDay(QkanConstants.H2104, targetDate)<1){
                return new QS001127_H2104();
            }
            // [ID:0000444][Masahiko Higuchi] add end
            return new QS001127();  
            
        case 14311://������x��
            // [ID:0000444][Masahiko Higuchi] 2009/02 add begin ����21�N4���@�����Ή�
            if(ACDateUtilities.getDifferenceOnDay(QkanConstants.H2104, targetDate)<1){
                return new QS001117_H2104();
            }
            // [ID:0000444][Masahiko Higuchi] add end
            return new QS001117();
            
        case 15111://���V�l�����{��
            // [ID:0000444][Masahiko Higuchi] 2009/02 add begin ����21�N4���@�����Ή�
            if(ACDateUtilities.getDifferenceOnDay(QkanConstants.H2104, targetDate)<1){
                return new QS001118_H2104();
            }
            // [ID:0000444][Masahiko Higuchi] add end
            return new QS001118();  
            
        case 15211://���V�l�ی��{��
            // [ID:0000444][Masahiko Higuchi] 2009/02 add begin ����21�N4���@�����Ή�
            if(ACDateUtilities.getDifferenceOnDay(QkanConstants.H2104, targetDate)<1){
                return new QS001119_H2104();
                
            } else if(ACDateUtilities.getDifferenceOnDay(QkanConstants.H2005, targetDate)<1){
                // 2008/04/14 [Masahiko_Higuchi] edit - begin ����20�N5���@�����Ή�
                return new QS001119_H2005();
            }else{
                return new QS001119();
            }
            // 2008/04/14 [Masahiko_Higuchi] edit - end
            // [ID:0000444][Masahiko Higuchi] add end
            
        case 15311://���×{�^��Î{��(�×{�a����L����a�@)
            // [ID:0000444][Masahiko Higuchi] 2009/02 add begin ����21�N4���@�����Ή�
            if(ACDateUtilities.getDifferenceOnDay(QkanConstants.H2104, targetDate)<1){
                return new QS001120_H2104();
            }
            // [ID:0000444][Masahiko Higuchi] add end
            return new QS001120();  
            
        case 15312://���×{�^��Î{��(�×{�a����L����f�Ï�)
            // [ID:0000444][Masahiko Higuchi] 2009/02 add begin ����21�N4���@�����Ή�
            if(ACDateUtilities.getDifferenceOnDay(QkanConstants.H2104, targetDate)<1){
                return new QS001121_H2104();
            } else if(ACDateUtilities.getDifferenceOnDay(QkanConstants.H2004, targetDate)<1){
                // 2008/03/18 [Masahiko_Higuchi] edit - begin ����20�N4���@�����Ή�
                // ����20�N4���ȍ~�͐������ύX����
        		return new QS001121_H2004();
        	}else{
        		return new QS001121();
        	}
        	// 2008/03/18 [Masahiko_Higuchi] edit - end
            // [ID:0000444][Masahiko Higuchi] add end
        	
        case 15313://���×{�^��Î{��(�V�l���F�m�ǎ����×{�a����L����a�@)
            // [ID:0000444][Masahiko Higuchi] 2009/02 add begin ����21�N4���@�����Ή�
            if(ACDateUtilities.getDifferenceOnDay(QkanConstants.H2104, targetDate)<1){
                return new QS001122_H2104();
            }
            // [ID:0000444][Masahiko Higuchi] add end
            return new QS001122();
            
        case 15411://�n�斧���^��앟���{��
            // [ID:0000444][Masahiko Higuchi] 2009/02 add begin ����21�N4���@�����Ή�
            if(ACDateUtilities.getDifferenceOnDay(QkanConstants.H2104, targetDate)<1){
                return new QS001129_H2104();
            }
            // [ID:0000444][Masahiko Higuchi] add end
            return new QS001129();  
            
        case 17111://��ԑΉ��^�K����
            // [ID:0000444][Masahiko Higuchi] 2009/02 add begin ����21�N4���@�����Ή�
            if(ACDateUtilities.getDifferenceOnDay(QkanConstants.H2104, targetDate)<1){
                return new QS001123_H2104();
            }
            // [ID:0000444][Masahiko Higuchi] add end
            return new QS001123();  
            
        case 17211://�F�m�ǑΉ��^�ʏ����
            // [ID:0000444][Masahiko Higuchi] 2009/02 add begin ����21�N4���@�����Ή�
            if(ACDateUtilities.getDifferenceOnDay(QkanConstants.H2104, targetDate)<1){
                return new QS001124_H2104();
            }
            // [ID:0000444][Masahiko Higuchi] add end
            return new QS001124();  
            
        case 17311://���K�͑��@�\�^������
            // [ID:0000444][Masahiko Higuchi] 2009/02 add begin ����21�N4���@�����Ή�
            if(ACDateUtilities.getDifferenceOnDay(QkanConstants.H2104, targetDate)<1){
                return new QS001125_H2104();
            }
            // [ID:0000444][Masahiko Higuchi] add end
            return new QS001125();  
            
        case 90101:// ���̑�
            return new QS001026(); 
        case 90201:// ��ȓ��퐶����̊���
            return new QS001027(); 
            //����18�N4���\�h
        case 16111: //���\�h�K����
            // [ID:0000444][Masahiko Higuchi] 2009/02 add begin ����21�N4���@�����Ή�
            if(ACDateUtilities.getDifferenceOnDay(QkanConstants.H2104, targetDate)<1){
                return new QS001130_H2104();
            }
            // [ID:0000444][Masahiko Higuchi] add end
            return new QS001130();
            
        case 16211: //���\�h�K��������
            // [ID:0000444][Masahiko Higuchi] 2009/02 add begin ����21�N4���@�����Ή�
            if(ACDateUtilities.getDifferenceOnDay(QkanConstants.H2104, targetDate)<1){
                return new QS001131_H2104();
            }
            // [ID:0000444][Masahiko Higuchi] add end
            return new QS001131();
            
        case 16311: //���\�h�K��Ō�
            // [ID:0000444][Masahiko Higuchi] 2009/02 add begin ����21�N4���@�����Ή�
            if(ACDateUtilities.getDifferenceOnDay(QkanConstants.H2104, targetDate)<1){
                return new QS001132_H2104();
            }
            // [ID:0000444][Masahiko Higuchi] add end
            return new QS001132();
            
        case 16411: //���\�h�K�⃊�n
            // [ID:0000444][Masahiko Higuchi] 2009/02 add begin ����21�N4���@�����Ή�
            if(ACDateUtilities.getDifferenceOnDay(QkanConstants.H2104, targetDate)<1){
                return new QS001133_H2104();
            }
            // [ID:0000444][Masahiko Higuchi] add end
            return new QS001133();
            
        case 16511: //���\�h�ʏ����
            // [ID:0000444][Masahiko Higuchi] 2009/02 add begin ����21�N4���@�����Ή�
            if(ACDateUtilities.getDifferenceOnDay(QkanConstants.H2104, targetDate)<1){
                return new QS001135_H2104();
            }
            // [ID:0000444][Masahiko Higuchi] add end
            return new QS001135();
            
        case 16611: //���\�h�ʏ����n
            // [ID:0000444][Masahiko Higuchi] 2009/02 add begin ����21�N4���@�����Ή�
            if(ACDateUtilities.getDifferenceOnDay(QkanConstants.H2104, targetDate)<1){
                return new QS001136_H2104();
            }
            // [ID:0000444][Masahiko Higuchi] add end
            return new QS001136();
            
        case 16711: //���\�h�����p��ݗ^
            // [ID:0000444][Masahiko Higuchi] 2009/02 add begin ����21�N4���@�����Ή�
            if(ACDateUtilities.getDifferenceOnDay(QkanConstants.H2104, targetDate)<1){
                return new QS001144_H2104();
            }
            // [ID:0000444][Masahiko Higuchi] add end
            return new QS001144();
            
        case 12411: //���\�h�Z�������������
            // [ID:0000444][Masahiko Higuchi] 2009/02 add begin ����21�N4���@�����Ή�
            if(ACDateUtilities.getDifferenceOnDay(QkanConstants.H2104, targetDate)<1){
                return new QS001137_H2104();
            }
            // [ID:0000444][Masahiko Higuchi] add end
            return new QS001137();
            
        case 12511: //���\�h�Z�������×{���i�V���j
            // [ID:0000444][Masahiko Higuchi] 2009/02 edit begin ����21�N4���@�����Ή�
            if(ACDateUtilities.getDifferenceOnDay(QkanConstants.H2104, targetDate)<1){
                return new QS001138_H2104();
                
            }
            if(ACDateUtilities.getDifferenceOnDay(QkanConstants.H2005, targetDate)<1){
                // 2008/04/14 [Masahiko_Higuchi] edit - begin ����20�N5���@�����Ή�
                return new QS001138_H2005();
                
            }else{
                return new QS001138();
            }
            // 2008/04/14 [Masahiko_Higuchi] edit - end
            // [ID:0000444][Masahiko Higuchi] edit end
            
        case 12611: //���\�h�Z�������×{���i�a�@�j
            // [ID:0000444][Masahiko Higuchi] 2009/02 add begin ����21�N4���@�����Ή�
            if(ACDateUtilities.getDifferenceOnDay(QkanConstants.H2104, targetDate)<1){
                return new QS001139_H2104();
            }
            // [ID:0000444][Masahiko Higuchi] add end
            return new QS001139();
            
        case 12612: //���\�h�Z�������×{���i�f�Ï��j
            // [ID:0000444][Masahiko Higuchi] 2009/02 edit begin ����21�N4���@�����Ή�
            if(ACDateUtilities.getDifferenceOnDay(QkanConstants.H2104, targetDate)<1){
                return new QS001140_H2104();
                
            } else if(ACDateUtilities.getDifferenceOnDay(QkanConstants.H2004, targetDate)<1){
                // 2008/03/18 [Masahiko_Higuchi] edit - begin ����20�N4���@�����Ή�
                // ����20�N4���ȍ~�͐������ύX����
        		return new QS001140_H2004();
                
        	}else{
        		return new QS001140();
        	}
        	// 2008/03/18 [Masahiko_Higuchi] edit - end
            // [ID:0000444][Masahiko Higuchi] edit end
        	
        case 12613: //���\�h�Z�������×{���i�F�m�ǎ����^�j
            // [ID:0000444][Masahiko Higuchi] 2009/02 add begin ����21�N4���@�����Ή�
            if(ACDateUtilities.getDifferenceOnDay(QkanConstants.H2104, targetDate)<1){
                return new QS001141_H2104();
            }
            // [ID:0000444][Masahiko Higuchi] add end
            return new QS001141();
            
        case 12614: //���\�h�Z�������×{���i��K���^�f�Ï��j
            return new QS001142();
        case 13411: //���\�h����×{�Ǘ��w��
            // [ID:0000444][Masahiko Higuchi] 2009/02 add begin ����21�N4���@�����Ή�
            if(ACDateUtilities.getDifferenceOnDay(QkanConstants.H2104, targetDate)<1){
                return new QS001134_H2104();
            }
            // [ID:0000444][Masahiko Higuchi] add end
            return new QS001134();
            
        case 13511: //���\�h����{�ݓ����Ґ������
            // [ID:0000444][Masahiko Higuchi] 2009/02 add begin ����21�N4���@�����Ή�
            if(ACDateUtilities.getDifferenceOnDay(QkanConstants.H2104, targetDate)<1){
                return new QS001143_H2104();
            }
            // [ID:0000444][Masahiko Higuchi] add end
            return new QS001143();
            
        case 14611: //���\�h�x��
            // [ID:0000444][Tozo TANAKA] 2009/03/02 add begin ����21�N4���@�����Ή�
            if(ACDateUtilities.getDifferenceOnDay(QkanConstants.H2104, targetDate)<1){
                return new QS001145_H2104();
            }
            // [ID:0000444][Tozo TANAKA] add end
            return new QS001145();
        case 17411: //���\�h�F�m�ǑΉ��^�ʏ����
            // [ID:0000444][Masahiko Higuchi] 2009/02 add begin ����21�N4���@�����Ή�
            if(ACDateUtilities.getDifferenceOnDay(QkanConstants.H2104, targetDate)<1){
                return new QS001146_H2104();
            }
            // [ID:0000444][Masahiko Higuchi] add end
            return new QS001146();
            
        case 17511: //���\�h���K�͑��@�\�^������
            // [ID:0000444][Masahiko Higuchi] 2009/02 add begin ����21�N4���@�����Ή�
            if(ACDateUtilities.getDifferenceOnDay(QkanConstants.H2104, targetDate)<1){
                return new QS001147_H2104();
            }
            // [ID:0000444][Masahiko Higuchi] add end
            return new QS001147();
            
        case 13711: //���\�h�F�m�ǑΉ��^�����������i�Z�����p�ȊO�j
            // [ID:0000444][Masahiko Higuchi] 2009/02 add begin ����21�N4���@�����Ή�
            if(ACDateUtilities.getDifferenceOnDay(QkanConstants.H2104, targetDate)<1){
                return new QS001148_H2104();
            }
            // [ID:0000444][Masahiko Higuchi] add end
            return new QS001148();
            
        case 13911: //���\�h�F�m�ǑΉ��^�����������i�Z�����p�j
            // [ID:0000444][Masahiko Higuchi] 2009/02 add begin ����21�N4���@�����Ή�
            if(ACDateUtilities.getDifferenceOnDay(QkanConstants.H2104, targetDate)<1){
                return new QS001149_H2104();
            }
            // [ID:0000444][Masahiko Higuchi] add end
            return new QS001149();
            
            //����17�N10��������
        case 11101:// �K����
            return new QS001003(); 
        case 11201:// �K��������
            return new QS001004(); 
        case 11301:// �K��Ō�(���ی�)
            return new QS001005(); 
        case 20101:// �K��Ō�(��Õی�)
            return new QS001006(); 
        case 11401:// �K�⃊�n�r���e�[�V����
            return new QS001007(); 
        case 11501:// �ʏ����
            return new QS001008(); 
        case 11601:// �ʏ����n�r���e�[�V����
            return new QS001009(); 
        case 11701:// �����p��ݗ^
            return new QS001010(); 
        case 12101:// �Z�������������
            return new QS001011(); 
        case 12201:// �Z�������×{���(�V��)
            return new QS001012(); 
        case 12301:// �Z�������×{���(�×{�a����L����a�@)
            return new QS001013(); 
        case 12302:// �Z�������×{���(�×{�a����L����f�Ï�)
            return new QS001014(); 
        case 12303:// �Z�������×{���(�V�l���F�m�ǎ����×{�a����L����a�@)
            return new QS001015(); 
        case 12304:// �Z�������×{���(��K���f�Ï�)
            return new QS001016(); 
        case 13101:// ����×{�Ǘ��w��
            return new QS001017(); 
        case 13201:// �F�m�ǑΉ��^�����������
            return new QS001018(); 
        case 13301:// ����{�ݓ����Ґ������
            return new QS001019(); 
        case 14301:// ������x��
            return new QS001020(); 
        case 15101:// ���V�l�����{��
            return new QS001021(); 
        case 15201:// ���V�l�ی��{��
            return new QS001022(); 
        case 15301:// ���×{�^��Î{��(�×{�a����L����a�@)
            return new QS001023(); 
        case 15302:// ���×{�^��Î{��(�×{�a����L����f�Ï�)
            return new QS001024(); 
        case 15303:// ���×{�^��Î{��(�V�l���F�m�ǎ����×{�a����L����a�@)
            return new QS001025(); 
        }

        return null;
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
            
            if(getSelectedServiceClass().isUseProvider()){
                // ���ݑI�����Ă���T�[�r�X�N���X(selectedServiceClass)�����Ə�����K�v�Ƃ���(isUseProvider)�ꍇ

                if(!getServiceOfferEntrepreneur().isSelected()){
                    // ���Ə���I�����ĂȂ��ꍇ
                    // ���Ə����I���̃G���[���b�Z�[�W��\������B��ID=QS001_EROOR_OF_UNSELECTED_PROVIDER
                    QkanMessageList.getInstance().QS001_EROOR_OF_UNSELECTED_PROVIDER();
                    // ���͂ɕs�����������ƌ��Ȃ��Anull��Ԃ��B
                    return null;
                }
            }

            VRMap data =getSelectedServiceClass().getValidData();
            if (data!=null) {
                // ���ݑI�����Ă���T�[�r�X�N���X(selectedServiceClass)�̃G���[�`�F�b�N(getValidData)��null�ȊO���Ԃ��Ă����ꍇ
                // ���ݕ\�����Ă���T�[�r�X�N���X���܂ރT�[�r�X���e�ݒ�̈�(serviceContentSettings)����������W���ĕԂ��B

//                VRBindPathParser.set("LOGIN_PROVIDER_ID", data, QkanSystemInformation.getInstance().getLoginProviderID());
                VRBindPathParser.set("PATIENT_ID", data, new Integer(getPatientID()));
                Object provider = getServiceOfferEntrepreneur().getSelectedModelItem();
                if(provider instanceof VRMap){
                    VRBindPathParser.set("PROVIDER_ID", data, VRBindPathParser.get("PROVIDER_ID", (VRMap)provider));
                }else{
                    VRBindPathParser.set("PROVIDER_ID", data, "");
                }
                VRBindPathParser.set("SYSTEM_SERVICE_KIND_DETAIL", data, new Integer(getSelectedServiceKind()));
                // SERVICE_USE_TYPE�Ȃǂ̏��͕K�v�ɉ����ČĂяo�����Őݒ肷�邱�ƁB
                

                // [ID:0000444][Tozo TANAKA] 2009/03/07 add begin ����21�N4���@�����Ή�
                if(getSelectedServiceClass() instanceof QS001ServicePanel){
                    //�T�[�r�X�̖@�����敪��ݒ肵�܂��B
                    VRBindPathParser
                            .set(
                                    QkanConstants.SERVICE_SYSTEM_BIND_PATH_LOW_VERSION,
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
        if(getServiceListLockFlag()){
            //���d�ċA�h�~
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
                setState_SERVICE_SELECTED();
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
            //            �T�[�r�X�I�𒆂̃��X�g(serviceSelectedListBox)�ɑI���T�[�r�X�̍폜���w������B
            Component oldSelectCmp=null;
            if(getSharedFocusCellRenderer()!=null){
                oldSelectCmp = getSharedFocusCellRenderer().getSharedFocusedOwner();
            }
            getSelectedServiceListBox().removeSelectedSchedule();
            //                �T�[�r�X���I����Ԃɂ���B   
            if((!getSelectedServiceListBox().isSelected())||(getSelectedServiceListBox().getSelectedValue()==null)){
                setState_SERVICE_UNSELECTED();
            }else{
                if(oldSelectCmp!=null){
                    getSharedFocusCellRenderer().setSharedFocusedOwner(oldSelectCmp);
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
                Iterator it=getDeleteReseveServicePatterns().iterator();
                while(it.hasNext()){
                    Map service=(Map)it.next();
                    Object obj = service.get("SERVICE_ID");
                    if(obj != null){
                        String id=ACCastUtilities.toString(obj);
                        
                        int end = pattenrs.size();
                        for(int i=0; i<end; i++){
                            if(id.equals(ACCastUtilities.toString(((Map)pattenrs.get(i)).get("SERVICE_ID")))){
                                pattenrs.remove(i);
                                break;
                            }
                        }
                    }
                }
//                pattenrs.removeAll(getDeleteReseveServicePatterns());
                // �ǉ��\��̃T�[�r�X�p�^�[�����擾���ʂɒǉ�����B
                it=getInsertReserveServicePatterns().iterator();
                while(it.hasNext()){
                    Map service=(Map)it.next();
                    service.remove("SERVICE_ID");
                }
                pattenrs.addAll(getInsertReserveServicePatterns());
                //�O�̂��߃��j�[�N�L�[�̏d���`�F�b�N���s���B
                Set keySet = new HashSet();
                it=pattenrs.iterator();
                while (it.hasNext()) {
                    Map row = (Map) it.next();
                    Object key = row.get("SERVICE_ID");
                    // 2008/01/24 [Masahiko_Higuchi] add - begin �T�[�r�X�p�^�[���ݒ�{�^��������s���G���[�Ή�
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
        // 2008/03/18 [Masahiko_Higuchi] edit - begin ����20�N4���@�����Ή��i���×{�^�V�l�ی��{�ݑΉ��j
        ACPanel serviceClass = createServicePatternClass(getCalcurater().getTargetDate());
        // 2008/03/18 [Masahiko_Higuchi] edit - end
        if(serviceClass instanceof QS001ServicePanel){
            ((QS001ServicePanel)serviceClass).setDBManager(getDBManager());
            ((QS001ServicePanel)serviceClass).setOldFacilityUser(getOldFacilityUserFlag()==2);
            ((QS001ServicePanel)serviceClass).setPlanMode(getProcessType()==QkanConstants.PROCESS_TYPE_PLAN);
            ((QS001ServicePanel)serviceClass).setCalculater(getCalcurater());
        }
        // �T�[�r�X���e�ݒ�̈�(serviceContentSettings)�̎q���ڂ�j�����A���������T�[�r�X�p�^�[���N���X���q���ڂƂ��Ēǉ�����B
        getServiceContentSettings().removeAll();
        if (serviceClass != null) {
            setSelectedServiceClass((QS001Service) serviceClass);
            
            if(getBeginTimeFollowListener()!=null){
                getBeginTimeFollowListener().setB(getSelectedServiceClass().getBeginTimeCombo());
                getEndTimeFollowListener().setB(getSelectedServiceClass().getEndTimeCombo());
            }
            getSelectedServiceClass().initialize();
            getServiceContentSettings().add(serviceClass, VRLayout.CLIENT);
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

            if(CareServiceCommon.isWelfareEquipment(service)){
                //�����p��ݗ^�̏ꍇ
                //���Ԃ͏��1���Ƃ��A���ԃR���{�𑀍�s�Ƃ���B
                getWeeklyPanel().getExceptionEndCombo().setSelectedIndex(1);
                getWeeklyPanel().setState_WELFARE_EQUIPMENT_SELECTED();
            }else{
                //�����p��ݗ^�ȊO�̏ꍇ
                //���ԃR���{�𑀍�\�Ƃ���B
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
        
        if(getBeginTimeFollowListener()!=null){
            QS001FollowTimeComboDocumentListener.followValue(getBeginTimeFollowListener().getB(), getBeginTimeFollowListener().getA());
        }
        if(getEndTimeFollowListener()!=null){
            QS001FollowTimeComboDocumentListener.followValue(getEndTimeFollowListener().getB(), getEndTimeFollowListener().getA());
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
        //�Z�������_���̕\�����X�V
        Component cmp=getSharedFocusCellRenderer().getSharedFocusedOwner();
        if(cmp!=null){
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
            
            //TODO ��
            int mode;
            if(getProcessType()==QkanConstants.PROCESS_TYPE_PLAN){
                mode = QkanConstants.SERVICE_DETAIL_GET_PLAN_OF_WEEKLY_ONLY;
            }else{
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
            //���j�[�N�L�[���폜
            Iterator it=schedules.iterator();
            while(it.hasNext()){
                Map map=(Map)it.next();
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
        for(int i=0;i<bindPaths.length;i++){
            obj = VRBindPathParser.get(bindPaths[i], service);
            // ��r����
            if(ACCastUtilities.toInt(obj,0)!=0){
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
    protected void patternNameChangeActionPerformed(ActionEvent e) throws Exception {
        // VRMap�ȊO�͏����ΏۊO�ɂ���B
        if (!(getPatternList().getSelectedValue() instanceof VRMap)) {
            return;
        }
        VRMap pattern = (VRMap) getPatternList().getSelectedValue();
        QS001033 qs001033 = new QS001033();
        // �p�^�[���_�C�A���O�̕\��
        qs001033.showModel(pattern,getDBManager());
        // �p�^�[�����̂��ύX����Ă���ꍇ
        if(qs001033.isPatternNameChange()){
            // �����o�^�T�[�r�X�p�^�[���ł��邩
            if(pattern.containsKey("SERVICE_ID")){
                // �����̃T�[�r�X�p�^�[���ł���ꍇ��Delete - Insert�ŏ�������B
                getDeleteReseveServicePatterns().add(pattern);
                // �T�[�r�XID�̎擾
                int serviceID = ACCastUtilities.toInt(pattern.getData("SERVICE_ID"),-1);
                // �o�^�\�胊�X�g���Ɋ��ɓ���̃f�[�^���Ȃ�����������
                for (int i = getInsertReserveServicePatterns().size(); i > 0 ; i--) {
                    VRMap insertPattern = (VRMap)getInsertReserveServicePatterns().get(i-1);
                    int insertPatternServiceID = ACCastUtilities.toInt(insertPattern.getData("SERVICE_ID"),-2);
                    // ���d�o�^�h�~�i����̃f�[�^�ł���ꍇ�͍���Ă��瑫���j
                    if(serviceID == insertPatternServiceID){
                        getInsertReserveServicePatterns().remove(i-1);
                    }
                }
                // �Ō�ɒǉ�
                getInsertReserveServicePatterns().add(pattern);
            }
        }
    }

}
