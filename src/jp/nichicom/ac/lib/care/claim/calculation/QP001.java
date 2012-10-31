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
 * �v���O���� ���p�҈ꗗ�i�����j (QP001)
 *
 *****************************************************************
 */
package jp.nichicom.ac.lib.care.claim.calculation;

import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import jp.nichicom.ac.bind.ACBindUtilities;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.lib.care.claim.servicecode.Qkan10011_ServiceCodeManager;
import jp.nichicom.ac.lib.care.claim.servicecode.Qkan10011_ServiceUnitGetter;
import jp.nichicom.ac.lib.care.claim.servicecode.QkanValidServiceCommon;
import jp.nichicom.ac.pdf.ACChotarouXMLUtilities;
import jp.nichicom.ac.pdf.ACChotarouXMLWriter;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.ac.util.ACDateUtilities;
import jp.nichicom.ac.util.ACMessageBox;
import jp.nichicom.ac.util.adapter.ACComboBoxModelAdapter;
import jp.nichicom.ac.util.adapter.ACTableModelAdapter;
import jp.nichicom.ac.util.splash.ACSplash;
import jp.nichicom.ac.util.splash.ACSplashable;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.component.table.VRSortableTableModelar;
import jp.nichicom.vr.text.parsers.VRDateParser;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRLinkedHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.nichicom.vr.util.adapter.VRHashMapArrayToConstKeyArrayAdapter;
import jp.nichicom.vr.util.logging.VRLogger;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.QkanConstants;
import jp.or.med.orca.qkan.QkanSystemInformation;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.affair.QkanMessageList;
import jp.or.med.orca.qkan.affair.qp.qp002.QP002;
import jp.or.med.orca.qkan.affair.qp.qp007.QP007;
import jp.or.med.orca.qkan.affair.qp.qp008.QP008;
import jp.or.med.orca.qkan.text.QkanClaimStateFormat;
import jp.or.med.orca.qkan.text.QkanClaimStyleFormat;
import jp.or.med.orca.qkan.text.QkanInsureTypeFormat;
import jp.or.med.orca.qkan.text.QkanJotaiCodeFormat;

/**
 * ���p�҈ꗗ�i�����j(QP001)
 */
@SuppressWarnings("serial")
public class QP001 extends QP001Event {
    
    QP001CSVCreator creator = new QP001CSVCreator();

    /**
     * �R���X�g���N�^�ł��B
     */
    public QP001() {
    }

    public void initAffair(ACAffairInfo affair) throws Exception {
        super.initAffair(affair);
        initAction(affair);
    }

    /**
     * �������������s�Ȃ��܂��B
     * 
     * @param affair
     *            �Ɩ����
     * @throws Exception
     *             ������O
     */
    protected void initAction(ACAffairInfo affair) throws Exception {
        VRList loginProviderInfo= QkanCommon.getProviderInfo(getDBManager(), QkanSystemInformation.getInstance().getLoginProviderID());
        if((loginProviderInfo==null)||(loginProviderInfo.isEmpty())){
            QkanMessageList.getInstance().QP001_ERROR_OF_NO_LOGIN_PROVIDER();
            ACFrame.getInstance().back();
            return;
        }else{
            Map map = (Map)loginProviderInfo.getData();
            getLoginProviderInfo()
                    .setText("�u" + map.get("PROVIDER_NAME") + "�v�Ɋւ���W�v�E�����������s�Ȃ��܂��B���̎��Ə���ΏۂƂ���ꍇ�́A���O�A�E�g���s�����Ə���I�����Ȃ����Ă��������B");
        }
        

        setAffair(ACCastUtilities.toString(affair.getParameters().get("NEXT_AFFAIR")));
        // �Ɩ��̃E�B���h�E�^�C�g�����̏����i�[���邽�߂�VRHashMap affairInfoMap���`����B
        VRMap affairInfoMap = null;
        // ��ʂ̏�����Ԃ�ݒ肷��Baffair�̒l�ɂ���āA�ݒ肪���򂷂�B
        // �u01�v�̏ꍇ
        if ("01".equals(getAffair())) {
            // ���p�҈ꗗ�i���ъm��E�����f�[�^�쐬�j�p�̐ݒ���s���B
            setState_INIT_01();
            getInfoTableColumn2().setHeaderValue("�m��");
            // �Ɩ������擾���AaffairInfoMap�Ɋi�[����B
            affairInfoMap = QkanCommon.getAffairInfo(getDBManager(), "QP001",
                    "01");
            
            // [ID:0000612][Shin Fujihara] 2010/11 add begin 2010�N�x�Ή�
            // �T�[�r�X��ނ��Ƃɐ������E�̎����𔭍s���邩�̃t���O��ݒ�
            //FIXME [0000612]
            setServiceByReceipt(false);
            /*
            if (ACFrame.getInstance().hasProperty("PrintConfig/ServiceByReceipt")
                	&& ACCastUtilities.toInt(getProperty("PrintConfig/ServiceByReceipt")) == 1) {
            	setServiceByReceipt(true);
            } else {
            	setServiceByReceipt(false);
            }
            */
            // [ID:0000612][Shin Fujihara] 2010/11 add end 2010�N�x�Ή�
            
            setState_CLAIM_DATE_DISABLE();
        }
        // �u02�v�̏ꍇ
        else if ("02".equals(getAffair())) {
            // ���p�҈ꗗ�i���t�Ǘ��[�j�p�̐ݒ���s���B
            setState_INIT_02();
            // �Ɩ������擾���AaffairInfoMap�Ɋi�[����B
            affairInfoMap = QkanCommon.getAffairInfo(getDBManager(), "QP001", "02");
        }
        // �u03�v�̏ꍇ
        else if ("03".equals(getAffair())) {
            // ���p�҈ꗗ�i�ݑ�T�[�r�X�x�����Ə������j�p�̐ݒ���s���B
            setState_INIT_03();
            // �Ɩ������擾���AaffairInfoMap�Ɋi�[����B
            affairInfoMap = QkanCommon.getAffairInfo(getDBManager(), "QP001", "03");
        }
        // �u04�v�̏ꍇ
        else if ("04".equals(getAffair())) {
            // ���p�҈ꗗ�i�ݑ�T�[�r�X�񋟎��Ə������j�p�̐ݒ���s���B
            setState_INIT_04();
            // �Ɩ������擾���AaffairInfoMap�Ɋi�[����B
            affairInfoMap = QkanCommon.getAffairInfo(getDBManager(), "QP001", "04");
        }
        // �u05�v�̏ꍇ
        else if ("05".equals(getAffair())) {
            //�o�ג��O�̎d�l�ύX�ɔ������g�p����
            // ���p�҈ꗗ�i�{�݃T�[�r�X�񋟎��ƎҐ����j�p�̐ݒ���s���B
            setState_INIT_05();
            // �Ɩ������擾���AaffairInfoMap�Ɋi�[����B
            affairInfoMap = QkanCommon.getAffairInfo(getDBManager(), "QP001", "05");
        }
        // �u06�v�̏ꍇ
        else if ("06".equals(getAffair())) {
            // ���p�҈ꗗ�i��Ð����j�p�̐ݒ���s���B
            setState_INIT_06();
            // �Ɩ������擾���AaffairInfoMap�Ɋi�[����B
            affairInfoMap = QkanCommon.getAffairInfo(getDBManager(), "QP001", "06");
        }
        // �u07�v�̏ꍇ
        else if ("07".equals(getAffair())) {
            // ���p�҈ꗗ(���p�Ҍ������)�p�̐ݒ���s���B
            setState_INIT_07();
            // �Ɩ������擾���AaffairInfoMap�Ɋi�[����B
            affairInfoMap = QkanCommon.getAffairInfo(getDBManager(), "QP001", "07");
        }
        // �u08�v�̏ꍇ
        else if ("08".equals(getAffair())) {
            // ���p�҈ꗗ�i��싋�t������j�p�̐ݒ���s���B
            setState_INIT_08();
            // �Ɩ������擾���AaffairInfoMap�Ɋi�[����B
            affairInfoMap = QkanCommon.getAffairInfo(getDBManager(), "QP001", "08");
        }
        
        // �E�B���h�E�^�C�g���Ƃ��āAaffairInfoMap�� KEY : WINDOW_TITLE �� VALUE ��ݒ肷��B
        setTitle(ACCastUtilities.toString(affairInfoMap.get("WINDOW_TITLE")));
        // �V�X�e������A�u�V�X�e�����t�v���擾����B
        // ��ʂ́u�Ώ۔N��(targetDate)�v�ɁA�擾�����V�X�e�����t�̑O����ݒ肷��B
        getTargetDate().setDate(ACDateUtilities.addMonth(QkanSystemInformation.getInstance().getSystemDate(),-1));
        

        // �ی��ҏ����擾���A�ȉ���KEY��this.map�ɐݒ肷��B�i�p�����[�^�ȗ��j
        setInsureData( QkanCommon.getInsurerInfo(getDBManager()));

        if ((getInsureData() != null) && (getInsureData().size() > 0)) {
            //�擪�ɋ󔒂�����B
            VRMap insurerTemp = new VRHashMap();
            insurerTemp.put("INSURER_NAME","");
            insurerTemp.put("INSURER_ID","");
            getInsureData().add(0,insurerTemp);
            getInsurerNoConbo().setModel(
                    new ACComboBoxModelAdapter(
                            new VRHashMapArrayToConstKeyArrayAdapter(
                                    getInsureData(), "INSURER_NAME")));
        }

        // �J�����̃t�H�[�}�b�g���w�肷��B
        // ������
        //getInfoTableColumn2().setFormat(QkanClaimStateFormat.getInstance());
        getInfoTableColumn2().setFormat(new QkanClaimStateFormat(getAffair()));
        // �l��
        getInfoTableColumn14().setFormat(QkanClaimStyleFormat.getInstance());
        // �v���x
        getInfoTableColumn15().setFormat(QkanJotaiCodeFormat.getInstance());
        // �ی��敪
        getInfoTableColumn16().setFormat(QkanInsureTypeFormat.getInstance());
        // �v��P�ʐ�
        getInfoTableColumn17().setFormat(NumberFormat.getInstance());
        // �T�[�r�X�P�ʐ�
        getInfoTableColumn18().setFormat(NumberFormat.getInstance());
        //�T�[�r�X���v���z
        getInfoTableColumn19().setFormat(NumberFormat.getInstance());
        //�ی������z
        getInfoTableColumn20().setFormat(NumberFormat.getInstance());
        //����S�z
        getInfoTableColumn21().setFormat(NumberFormat.getInstance());
        //���p�ҕ��S�z
        getInfoTableColumn22().setFormat(NumberFormat.getInstance());
        
        //�敪�J�����̐ݒ�
        VRList kubun = new VRArrayList();
        kubun.add("�V�K");
        kubun.add("�C��");
        kubun.add("���");
        getInfoTableColumn23().setEditorModel(kubun);

        
        //�`�F�b�N��L���ɂ���
        getNotOutputDistinction().setSelected(true);

        setPatientTableModel(new ACTableModelAdapter(new String[] { "NO",// No
                "PRINT",// ���
                "CHOISE",// �I��
                "DELETE",// �폜
                "KUBUN",// �敪
                "TARGET_DATE",// �N���x
                "CLAIM_STYLE_TYPE",// �l��
                "INSURER_ID",// �ی��Ҕԍ�
                "INSURER_NAME",// �ی��Җ���
                "PATIENT_CODE",// ���p�҃R�[�h
                "INSURED_ID",// ��ی��Ҕԍ�
                "PATIENT_NAME",// ���p�Ҏ���
                "PATIENT_KANA",// �ӂ肪��
                "PATIENT_SEX",// ����
                "PATIENT_BIRTHDAY",// �N��
                
                "JOTAI_CODE",// �v���x
                "INSURE_TYPE",// �ی��敪
                "PLAN_RATE",// �v��P��
                "SERVICE_UNIT",// �T�[�r�X�P��
                "SERVICE_TOTAL",// �T�[�r�X���v���z
                "HOKEN",// �ی������z
                "KOUHI",// ����S�z
                "RIYOUSYA"// ���p�ҕ��S�z
        }));
        // �f�[�^�̐ݒ���s���B
        getInfoTable().setModel(getPatientTableModel());
        
        // [ID:0000630][Shin Fujihara] 2011/02 add begin 2010�N�x�Ή�
        // �ی��҂̗���\����
        getInfoTableColumn16().setVisible(false);
        // [ID:0000630][Shin Fujihara] 2011/02 add end 2010�N�x�Ή�
        
        // [ID:0000599][Shin Fujihara] 2010/11 edit begin 2010�N�x�Ή�
        /*
        //�����Ώۓ��t�����O�C�����t�ɂ���
        getTargetDate().setDate(ACDateUtilities.addMonth(QkanSystemInformation.getInstance().getSystemDate(),-1));
        //�������̓��t��ݒ肷��B
        getClaimDate().setDate(QkanSystemInformation.getInstance().getSystemDate());
        getClaimDateUpdate().setDate(QkanSystemInformation.getInstance().getSystemDate());
        */
        
        /*
			�����N���̏����\���Ɋւ���C��
			�V�X�e�����t��20���ȑO(20�����܂�)�ł���΁A�����N�����V�X�e�����t�̔N��
			�V�X�e�����t��21���ȍ~�ł���΁A�����N�����V�X�e�����t�̗����̔N��
			�ɐݒ肷��B
			�܂��A�Ώ۔N���͏�L���[���Ŕ��肵�������N���̑O���Ƃ���B
		*/
        
        Date initSeikyuDate = QkanSystemInformation.getInstance().getSystemDate();
        // 21���ȍ~�ł���΁A�����ɂ���
        if (21 <= ACDateUtilities.getDayOfMonth(QkanSystemInformation.getInstance().getSystemDate())) {
        	initSeikyuDate = ACDateUtilities.addMonth(initSeikyuDate, 1);
        }
        
        // �����N���֘A�̐ݒ�
        getClaimDate().setDate(initSeikyuDate);
        getClaimDateUpdate().setDate(initSeikyuDate);
        
        // [ID:0000727][Masahiko.Higuchi] 2012/04 ����24�N4���@�����Ή� edit begin
        // 2012�N4�������ɂȂ�ꍇ�͂��̂܂܂Ƃ���
        if(ACDateUtilities.compareOnMonth(initSeikyuDate, ACDateUtilities.createDate(2012, 4)) <= 0) {
            getTargetDate().setDate(initSeikyuDate);
        } else {
            // �Ώ۔N���̐ݒ�
            getTargetDate().setDate(ACDateUtilities.addMonth(initSeikyuDate, -1));
        }
        // [ID:0000727][Masahiko.Higuchi] 2012/04 ����24�N4���@�����Ή� edit end
        // [ID:0000599][Shin Fujihara] 2010/11 edit end 2010�N�x�Ή�
        
        
        //���������t�����O�C�����t�ɂ���B
        getClaimDatePrint().setDate(QkanSystemInformation.getInstance().getSystemDate());
        
        //�ڍוҏW��ʂ���߂��Ă����ꍇ�̍ĕ`�揈��
        VRMap param = affair.getParameters();
        if( VRBindPathParser.has("QP001_DATA", param) ){
            VRMap memory = (VRMap)VRBindPathParser.get("QP001_DATA", param);
            this.setSource( memory );
            this.bindSource();
            param.removeData("QP001_DATA");
            
            doFind();
            
            String patient_id = ACCastUtilities.toString(param.get("PATIENT_ID"));
            
            for(int i = 0; i < getPatientData().size(); i++){
                VRMap map = (VRMap)getPatientData().get(i);
                if(ACCastUtilities.toString(map.get("PATIENT_ID")).equals(patient_id)){
                    getPatientTableModel().setAdaptee(getPatientData());
                    getInfoTable().setSelectedModelRow(
                            ((VRSortableTableModelar) getInfoTable().getModel())
                                    .getReverseTranslateIndex(i));
                    getInfoTable().scrollSelectedToVisible();
                    break;
                }
            }
        } else {
            //�N�����Ɍ�������悤�C��
            doFind();
        }
    }

    // �R���|�[�l���g�C�x���g


    /**
     * �u�`�F�b�N�t���v�C�x���g�ł��B
     * 
     * @param e
     *            �C�x���g���
     * @throws Exception
     *             ������O
     */
    protected void allSelectActionPerformed(ActionEvent e) throws Exception {
        // ��ʂ́u���p�҈ꗗ(infoTable)�v�ɕ\�����Ă��闘�p�҂́u�I��(��(infoTableColumn3)�v�̃`�F�b�N������B
        for (int i = 0; i < getPatientData().getDataSize(); i++) {
            ((VRLinkedHashMap) getPatientData().get(i)).setData("CHOISE",
                    new Boolean(true));
        }
        infoTableSelectionChanged(null);
        getPatientTableModel().setAdaptee(getPatientData());
        getInfoTable().setSelectedModelRow(
                ((VRSortableTableModelar) getInfoTable().getModel())
                        .getReverseTranslateIndex(0));
        getInfoTable().requestFocus();
    }


    /**
     * �e�[�u�����_�u���N���b�N���ꂽ���̃C�x���g�ł��B
     * @param e
     */
    protected void infoTableSelectionchangedDouble(MouseEvent e) throws Exception {
        moveQP002();
    }
    
    /**
     * �u���[�i�l���j�E���Ə��I���ɑJ�ځv�C�x���g�ł��B
     * 
     * @param e
     *            �C�x���g���
     * @throws Exception
     *             ������O
     */
    protected void entryActionPerformed(ActionEvent e) throws Exception {
        moveQP002();
    }
    
    private void moveQP002() throws Exception {
        
        //�ڍוҏW�{�^���̕\�����m�F
        if(!getEntry().isVisible() || !getEntry().isEnabled()){
            return;
        }
        
        //��ʏ��̑ޔ�
        VRHashMap memory = new VRHashMap();
        this.setSource( memory );
        this.applySource();
        ACFrame.getInstance().addNowAffairParameter("QP001_DATA", memory);
        
        // ����ʂւ̓n��p�����[�^�i�[�p�Ƀ��R�[�h param�𐶐�����B
        VRMap param = new VRHashMap();

        // ����ʑJ�ڂ̂��߂̃p�����[�^ ACAffairInfo affair ���`����B
        ACAffairInfo affair = null;
        
        //�I���ԍ����擾
        int select = getInfoTable().getSelectedModelRow();
        //���I���ł���Ώ����𒆒f
        if(select < 0){
            return;
        }
        //�I���̃f�[�^���擾
        VRMap map = (VRMap)getPatientData().get(select);
        
        // param�ɉ��L�p�����[�^��ݒ肷��B
        // KEY : PATIENT_ID
        param.put("PATIENT_ID", map.get("PATIENT_ID"));
        // KEY :
        param.put("CLAIM_DATE", map.get("CLAIM_DATE"));

        // ���L�p�����[�^�ɂ�affair�𐶐�����B
        //className : QP002.class.getName();
        affair = new ACAffairInfo(QP002.class.getName(), param);
        // ���n�菈��
        // ����ʂɑJ�ڂ���B
        ACFrame.getInstance().next(affair);
    }

    /**
     * �u�����v�C�x���g�ł��B
     * 
     * @param e
     *            �C�x���g���
     * @throws Exception
     *             ������O
     */
    protected void findActionPerformed(ActionEvent e) throws Exception {
        
        // �������s���Ă悢���m�F���s���B
        if (!checkFind()) {
            return;
        }

        // �������s���B
        doFind();
    }

    /**
     * �u�폜�v�C�x���g�ł��B
     * 
     * @param e
     *            �C�x���g���
     * @throws Exception
     *             ������O
     */
    protected void deleteActionPerformed(ActionEvent e) throws Exception {
        // �폜�m�F���b�Z�[�W��\������B
        if (QkanMessageList.getInstance().WARNING_OF_DELETE_SELECTION() == ACMessageBox.RESULT_OK) {
            // �I�����ꂽ���p�҂̏W�v�f�[�^���폜����B
            String choise;
            Date targetDate = getTargetDate().getDate();
            VRMap map;
            
            //[ID:0000612][Shin Fujihara] 2010/11 add begin 2010�N�x�Ή�
            /* FIXME [0000612]
            VRMap sqlParam = new VRHashMap();
            VRDateParser.format(ACDateUtilities.toFirstDayOfMonth(targetDate), "yyyy/MM/dd");
            VRDateParser.format(ACDateUtilities.toLastDayOfMonth(targetDate), "yyyy/MM/dd");
            sqlParam.put("TARGET_DATE_START", VRDateParser.format(ACDateUtilities.toFirstDayOfMonth(targetDate), "yyyy/MM/dd"));
            sqlParam.put("TARGET_DATE_END", VRDateParser.format(ACDateUtilities.toLastDayOfMonth(targetDate), "yyyy/MM/dd"));
            sqlParam.put("PROVIDER_ID", QkanSystemInformation.getInstance().getLoginProviderID());
            */
            //[ID:0000612][Shin Fujihara] 2010/11 add end 2010�N�x�Ή�
            
            for (int i = 0; i < getPatientData().getDataSize(); i++) {
                map = (VRMap) getPatientData().get(i);
                choise = String.valueOf(VRBindPathParser.get("DELETE", map));
                // �I������Ă���΍폜���s
                if ("TRUE".equalsIgnoreCase(choise)) {
                    // �R���ō폜
                    QkanCommon.updateClaimDetail(getDBManager(),
                            new VRArrayList(), targetDate, ACCastUtilities
                                    .toInt(VRBindPathParser.get("PATIENT_ID",map)),QkanSystemInformation.getInstance().getLoginProviderID());
                    
                    
                    //[ID:0000612][Shin Fujihara] 2010/11 add begin 2010�N�x�Ή�
                    //�폜�{�^���������ꂽ�Ƃ��́A�����Ɨ��p�Ҍ��������̃f�[�^���폜����B
                    /* FIXME [0000612]
                    sqlParam.put("PATIENT_ID", VRBindPathParser.get("PATIENT_ID",map));
                    VRList list = getDBManager().executeQuery(getSQL_GET_CLAIM_ID(sqlParam));
                    for (int j = 0; j < list.size(); j++) {
                    	VRMap row = (VRMap)list.get(j);
                    	row.put("MODE", "ALL");
                    	getDBManager().executeUpdate(getSQL_GET_CLAIM_PATIENT_DETAIL_DELETE(row));
                    	getDBManager().executeUpdate(getSQL_DELETE_CLAIM(row));
                    }
                    */
                    //[ID:0000612][Shin Fujihara] 2010/11 add end 2010�N�x�Ή�
                }
            }

            // �Č���
            doFind();
        }
    }

    /**
     * �u����v�C�x���g�ł��B
     * 
     * @param e
     *            �C�x���g���
     * @throws Exception
     *             ������O
     */
    protected void printActionPerformed(ActionEvent e) throws Exception {
        // ���̓`�F�b�N���s�Ȃ��B
        if (!checkSelect("�I��", "���[�����")) {
            return;
        }
        
        //2006/05/01 add-begin Tozo TANAKA
        VRMap printParam = null;
        // ���p�Ґ���������͈���I�v�V�������擾
        if ("07".equals(getAffair())) {
            QP007 qp007 = new QP007();
            qp007.setVisible(true);
            
            printParam = qp007.getResult(); 
            if(printParam== null){
                return;
            }
        }
        //2006/05/01 add-end Tozo TANAKA

        
        //����f�[�^�쐬�܂ŃX�v���b�V����\��
        ACSplash splash = (ACSplash)ACFrame.getInstance().getFrameEventProcesser().createSplash("����f�[�^");
        
        try{
            // ���Ə������擾����B
            VRMap providerMap = new VRHashMap();
            ACBindUtilities.setMapFromArray(QkanCommon
                    .getProviderInfo(getDBManager()), providerMap, "PROVIDER_ID");
            
            
            //[H20.5 �@�����Ή�] fujihara add start
            //TODO
            //�b��I�ɕ\������Ă���f�[�^�̐擪�̑Ώ۔N�����擾���A
            //�}�X�^�f�[�^�̎擾���s���Ă���B
            //�����ɂ́A�o�͂��钠�[���Ƃɓ��t��ύX����K�v������B
            //[H20.5 �@�����Ή�] fujihara add end
            Date target = ACCastUtilities.toDate(((VRMap)getPatientData().get(0)).get("TARGET_DATE"));
            // �f�[�^�}�l�[�W���̏�����
            QP001Manager manager = new QP001Manager(getDBManager(), target);
            

            // ����p�N���X��錾
            ACChotarouXMLWriter writer = new ACChotarouXMLWriter();
            
            //������e�̕ҏW�J�n��錾
            writer.beginPrintEdit();
            

            QP001PrintControl printer = new QP001PrintControl();
            //�K�p�ȃI�u�W�F�N�g��ݒ�
            printer.setDBManager(getDBManager());
            printer.setWriter(writer);
            printer.setAffair(getAffair());
            
            //2009/1/6 fujihara edit start
            //���p�Ҍ��������̏ꍇ�́A��ʂɕ\������Ă��鏇�ň󎚂���
            if ("07".equals(getAffair())){
            	printer.setPatientList(getSortedTableList());
            
            //����ȊO�͒ʏ�ʂ�
            } else {
            	printer.setPatientList(getPatientData());
            }
            //printer.setPatientList(getPatientData());
            //2009/1/6 fujihara edit end
            
            printer.setPrintDate(getClaimDatePrint().getDate());
            
            if(hasProperty("PrintConfig/YoshikiBango")){
                printer.setPrintOption(getProperty("PrintConfig/YoshikiBango"));
            }
            
            if(hasProperty("PrintConfig/printNursingZero")){
                printer.setPrintNursingZero(getProperty("PrintConfig/printNursingZero"));
            }
            
            if(hasProperty("PrintConfig/printNursingLimitZero")){
                printer.setPrintNursingLimitZero(getProperty("PrintConfig/printNursingLimitZero"));
            }
            
            //��ʏ�̐������ł͂Ȃ��A�\�����Ă�����f�[�^���琿�����t���擾����悤�ύX
//            printer.setClaimDate(getClaimDate().getDate());
            printer.setProviderMap(providerMap);
            printer.setManager(manager);
            
            // ������s
            if (!printer.doPrint(printParam)) {
                return;
            }
            
            // ����I����錾
            printer.getWriter().endPrintEdit();
            
            if (splash != null) {
                splash.close();
                splash = null;
            }
            
            // PDF�t�@�C���𐶐����ĊJ���B
            ACChotarouXMLUtilities.openPDF(printer.getWriter());
            
        } finally {
            // �E�F�C�e�B���O�t�H�[�����I������B
            if (splash != null) {
                splash.close();
                splash = null;
            }
        }

        // 2008/06/13 [Masahiko Higuchi] add - begin Version 5.4.1�Ή� ���p�Ҍ������������
        // ����Ώۃ`�F�b�N�̉�ʕ`�揈�����s��
        getInfoTable().revalidate();
        getInfoTable().repaint();
        // 2008/06/13 [Masahiko Higuchi] add - end
        
        // ��������m��m�F���b�Z�[�W��\������B�B
        // �u�͂��v���I�����ꂽ�ꍇ
        if (QkanMessageList.getInstance().QP001_PRINT_COMMIT() == ACMessageBox.RESULT_OK) {
            // �g�����U�N�V�������J�n����B
            getDBManager().beginTransaction();
            // getSQL_GET_PATIENT(param);
            // SQL�������s����B
            try {
                for(int i = 0; i < getPatientData().size(); i++){
                    VRMap map = (VRMap)getPatientData().get(i);
                    if (!"TRUE".equalsIgnoreCase(ACCastUtilities
                            .toString(VRBindPathParser.get("CHOISE", map)))){
                        continue;
                    }
                    
                    //����t���O�X�V�ΏۂƂȂ�f�[�^���擾����B
                    VRList printFlagList = getDBManager().executeQuery(getSQL_GET_UPDATE_TARGET_CLAIMSTATE(map));
                    
                    for(int j = 0; j < printFlagList.size(); j++){
                        VRMap printFlag = (VRMap)printFlagList.get(j);
                        printFlag.put("PRINT",QkanClaimStateFormat.getPrintedCode(getAffair(),printFlag.get("CLAIM_FINISH_FLAG")));
                        printFlag.put("PROVIDER_ID",QkanSystemInformation.getInstance().getLoginProviderID());
                        //��������̍X�V�p��SQL�����擾����B
                        //SQL�������s����B
                        getDBManager().executeUpdate(getSQL_GET_UPDATE_CLAIMSTATE(printFlag));
                    }
                    
                    //�t���O������ςɕύX
                    map.put("PRINT",QkanClaimStateFormat.getPrintedCode(getAffair(),map.get("PRINT")));
                }

                // �X�V�����������ꍇ�A�R�~�b�g�����s����B
                getDBManager().commitTransaction();
            } catch (Exception sqlEx) {
                // �X�V�����s�����ꍇ�A���[���o�b�N�����s����B
                getDBManager().rollbackTransaction();
            }

        }

        

        //�e�[�u���̍ĕ`����s��
        getInfoTable().repaint();

        //�C���X�^���X��j��
//        QP001Manager.dispose();
    }
    
    /**
     * �u���яW�v�����v�C�x���g�ł��B
     * 
     * @param e
     *            �C�x���g���
     * @throws Exception
     *             ������O
     */
    protected void commitActionPerformed(ActionEvent e) throws Exception {
        // ���̓`�F�b�N���s���B
        if (!checkSelect("�W�v", "���т��m��E�W�v")) {
            return;
        }

        // ���яW�v���s�Ȃ��B
        doTotal();

    }

    /**
     * �uCSV�t�@�C���o�́v�C�x���g�ł��B
     * 
     * @param e
     *            �C�x���g���
     * @throws Exception
     *             ������O
     */
    protected void csvOutActionPerformed(ActionEvent e) throws Exception {
        // ���̓`�F�b�N���s�Ȃ��B
        if (!checkSelect("�I��", "CSV���o��")) {
            return;
        }
        
        // �t�H���_�I�����(QP008)��\������B
        QP008 qp008 = new QP008(this);
        qp008.setVisible(true);

    }
    private void setPrintInfoPanel() throws Exception {
        int[] printCount = new int[18];
        // ���v�P�ʐ�
        int service_unit = 0;
        // ���v���z
        int service_total = 0;
        // �ی������z
        int hoken = 0;
        // ���p�Ґ����z
        int kouhi = 0;
        // ������z
        int riyousya = 0;

        String choise;
        for (int i = 0; i < getPatientData().getDataSize(); i++) {
            choise = String.valueOf(VRBindPathParser.get("CHOISE",
                    (VRLinkedHashMap) getPatientData().get(i)));
            // ���I���̏ꍇ�������X�L�b�v����B
            if (!"TRUE".equalsIgnoreCase(choise))
                continue;

            VRMap map = (VRMap) getPatientData().get(i);
            int claimStyleType = ACCastUtilities.toInt(VRBindPathParser.get(
                    "CLAIM_STYLE_TYPE", map),0);
            
            
            switch(claimStyleType){
                case QkanConstants.CLAIM_STYLE_BENEFIT_BILL:
                    printCount[1]++;
                    break;
                case QkanConstants.CLAIM_STYLE_FORMAT_2:
                case QkanConstants.CLAIM_STYLE_FORMAT_2_2:
                    printCount[2]++;
                    printCount[1] = 1;
                    break;
                case QkanConstants.CLAIM_STYLE_FORMAT_3:
                case QkanConstants.CLAIM_STYLE_FORMAT_3_2:
                    printCount[3]++;
                    printCount[1] = 1;
                    break;
                case QkanConstants.CLAIM_STYLE_FORMAT_4:
                case QkanConstants.CLAIM_STYLE_FORMAT_4_2:
                    printCount[4]++;
                    printCount[1] = 1;
                    break;
                case QkanConstants.CLAIM_STYLE_FORMAT_5:
                case QkanConstants.CLAIM_STYLE_FORMAT_5_2:
                    printCount[5]++;
                    printCount[1] = 1;
                    break;
                case QkanConstants.CLAIM_STYLE_FORMAT_6:
                case QkanConstants.CLAIM_STYLE_FORMAT_6_2:
                case QkanConstants.CLAIM_STYLE_FORMAT_6_3:
                case QkanConstants.CLAIM_STYLE_FORMAT_6_4:
                case QkanConstants.CLAIM_STYLE_FORMAT_6_5:
                case QkanConstants.CLAIM_STYLE_FORMAT_6_6:
                    printCount[6]++;
                    printCount[1] = 1;
                    break;
                case QkanConstants.CLAIM_STYLE_FORMAT_7:
                //[ID:0000476][Shin Fujihara] 2009/04 add begin ����21�N4���@�����Ή�
                //������Q�@�l���掵�̓��I�����Ă��A���[�������J�E���g�A�b�v����Ȃ�
                case QkanConstants.CLAIM_STYLE_FORMAT_7_2:
                //[ID:0000476][Shin Fujihara] 2009/04 add end ����21�N4���@�����Ή�
                    printCount[7]++;
                    printCount[1] = 1;
                    break;
                case QkanConstants.CLAIM_STYLE_FORMAT_8:
                    printCount[8]++;
                    printCount[1] = 1;
                    break;
                case QkanConstants.CLAIM_STYLE_FORMAT_9:
                    printCount[9]++;
                    printCount[1] = 1;
                    break;
                case QkanConstants.CLAIM_STYLE_FORMAT_10:
                    printCount[10]++;
                    printCount[1] = 1;
                    break;
                case QkanConstants.CLAIM_STYLE_BENEFIT_SUMMARY:
                case QkanConstants.CLAIM_STYLE_BENEFIT_MANAGEMENT:
                    printCount[11]++;
                    break;
                case QkanConstants.CLAIM_STYLE_VISIT_DETAILED_SOCIAL_INSURANCE:
                    printCount[13]++;
                    printCount[15] = 1;
                    break;
                case QkanConstants.CLAIM_STYLE_VISIT_DETAILE_NATIONAL_INSURANCE:
                    printCount[13]++;
                    printCount[16] = 1;
                    break;
                case QkanConstants.CLAIM_STYLE_VISIT_BILL_SOCIAL_INSURANCE:
                    printCount[15]++;
                    printCount[16] = 1;
                    break;
                case QkanConstants.CLAIM_STYLE_VISIT_BILL_NATIONAL_INSURANCE:
                    printCount[16]++;
                    break;
            }
            //���p�\�̖���
            printCount[17]++;
    
            if (!ACTextUtilities.isNullText(VRBindPathParser.get(
                    "SERVICE_UNIT", map))) {
                // ���v�P�ʐ�
                service_unit += ACCastUtilities.toDouble(VRBindPathParser.get(
                        "SERVICE_UNIT", map));
            }

            if (!ACTextUtilities.isNullText(VRBindPathParser.get(
                    "SERVICE_TOTAL", map))) {
                // ���v���z
                service_total += ACCastUtilities.toDouble(VRBindPathParser.get(
                        "SERVICE_TOTAL", map));
            }

            if (!ACTextUtilities.isNullText(VRBindPathParser.get("HOKEN", map))) {
                // �ی������z
                hoken += ACCastUtilities.toDouble(VRBindPathParser.get("HOKEN",
                        map));
            }

            if (!ACTextUtilities.isNullText(VRBindPathParser.get("KOUHI", map))) {
                // ���p�Ґ����z
                kouhi += ACCastUtilities.toDouble(VRBindPathParser.get("KOUHI",
                        map));
            }

            if (!ACTextUtilities.isNullText(VRBindPathParser.get("RIYOUSYA",
                    map))) {
                // ������z
                riyousya += ACCastUtilities.toDouble(VRBindPathParser.get(
                        "RIYOUSYA", map));
            }

        }

        getNursingCount().setText(ACCastUtilities.toString(printCount[1]));
        getType2Count().setText(ACCastUtilities.toString(printCount[2]));
        getType3Count().setText(ACCastUtilities.toString(printCount[3]));
        getType4Count().setText(ACCastUtilities.toString(printCount[4]));
        getType5Count().setText(ACCastUtilities.toString(printCount[5]));
        getType6Count().setText(ACCastUtilities.toString(printCount[6]));
        getType7Count().setText(ACCastUtilities.toString(printCount[7]));
        getType8Count().setText(ACCastUtilities.toString(printCount[8]));
        getType9Count().setText(ACCastUtilities.toString(printCount[9]));
        getType10Count().setText(ACCastUtilities.toString(printCount[10]));
        getSupplyCount().setText(ACCastUtilities.toString(printCount[11]));
        getVisitCount().setText(ACCastUtilities.toString(printCount[13]));
        
        getSyahoCount().setText(ACCastUtilities.toString(printCount[15]));
        getKokuhoCount().setText(ACCastUtilities.toString(printCount[16]));
        getServiceCount().setText(ACCastUtilities.toString(printCount[17]));

        getTotalDenominationText().setText(NumberFormat.getInstance().format(service_unit));
        getTotalMoneyText().setText(NumberFormat.getInstance().format(service_total));
        getDemandMoneyInsuranceMoneyText().setText(
                NumberFormat.getInstance().format(hoken));
        getDemandMoneyPatientMoneyText().setText(
                NumberFormat.getInstance().format(riyousya));
        getTotalDenominationPublicExpenseMoneyText().setText(
                NumberFormat.getInstance().format(kouhi));

    }

    /**
     * �u�ی��Җ��̃R���{�{�b�N�X�I�����̏����v�C�x���g�ł��B
     * 
     * @param e
     *            �C�x���g���
     * @throws Exception
     *             ������O
     */
    protected void insurerNoConboActionPerformed(ActionEvent e)
            throws Exception {
        // �I�����ꂽ�R���{�̃C���f�b�N�X
        int index = getInsurerNoConbo().getSelectedIndex();

        if (index < 0)
            return;

        // �ޔ����Ă���ی��ҏ�񂩂�ی���ID���擾����B
        String insureNo = (String) ((VRMap) getInsureData().getData(index))
                .get("INSURER_ID");
        if (insureNo == null)
            return;

        // ��ʏ�ɐݒ肷��B
        getInsurerNoText().setText(insureNo);
    }

    // �����֐�

    /**
     * �u���������̎擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception
     *             ������O
     */
    public void doFind() throws Exception {
        ACSplashable splash = ACFrame.getInstance().getFrameEventProcesser().createSplash("��������");

        // SQL���擾�֐��ɓn��VRHashMap param�𐶐�����B
        VRMap param = new VRHashMap();
        
        //SQL�������N���X�ɓn���p�����[�^��ݒ肷��B
        setSQLParams(param);

        // �����pSQL�����擾����B
        String query = getSQL_GET_PATIENT(param);

        // �擾����SQL���𔭍s���A���ʂ�patientData�Ɋi�[����B
        setPatientData(getDBManager().executeQuery(query));

        //�擾�����f�[�^��\���p�ɉ��H����B
        editSelectData(param);

        // ��ʂ́u���p�҈ꗗ(infoTable)�v�ɁApatientData��ݒ肷��B
        getPatientTableModel().setAdaptee(getPatientData());
        
        getStatusBar().setText(getPatientData().size() + " �����o����܂����B");

        // patientData�̌�����0����葽���ꍇ
        if (getPatientData().size() > 0) {
            // ��ʂ́u���p�҈ꗗ(infoTable)�v��1�s�ڂ�I������B
            // �擪�s��I����Ԃ�
            getPatientTableModel().setAdaptee(getPatientData());
            getInfoTable().setSelectedModelRow(
                    ((VRSortableTableModelar) getInfoTable().getModel())
                            .getReverseTranslateIndex(0));
            getInfoTable().requestFocus();
            
            //�Ɩ��{�^���̏�Ԃ�ύX����B
            setButtonState();
            
        } else {
            // patientData�̌�����0���̏ꍇ
            // ��ʂ́u���p�҈ꗗ(infoTable)�v�̍s�͖��I���Ƃ���B
            // �Ɩ��{�^���̏�Ԃ�ύX����B
            setState_UNSELECTED();
        }

        if (!"01".equals(getAffair())) {
            setPrintInfoPanel();
        }

        // �p�b�V�u�f�[�^���N���A����B
        getPassiveChecker().clearReservedPassive();

        // �p�b�V�u�f�[�^��o�^����B
        getPassiveChecker().reservedPassive(getPASSIVE_CHECK_KEY(), getPatientData());

        if(splash!=null){
            splash.close();
            splash = null;
        }
        
        //[ID:0000455][Shin Fujihara] 2009/02 add begin ����21�N4���@�����Ή�
        //40���ȏ�v�������쐬���Ă���l�����݂��邩�`�F�b�N
        checkOver40Plan();
        //[ID:0000455][Shin Fujihara] 2009/02 add end ����21�N4���@�����Ή�
    }
    
    //[ID:0000455][Shin Fujihara] 2009/02 add begin ����21�N4���@�����Ή�
    /**
     * 40���ȏ�v�������쐬���Ă���l�����݂��邩�`�F�b�N����
     * @throws Exception
     */
    private void checkOver40Plan() throws Exception {
        
    	VRMap optionParam = new VRHashMap();
    	optionParam.put("START", VRDateParser.format(getTargetDate().getDate(), "yyyy/MM/dd"));
    	optionParam.put("END", VRDateParser.format(ACDateUtilities.toLastDayOfMonth(getTargetDate().getDate()), "yyyy/MM/dd"));
    	
    	//�e�[�u���̃v���t�B�b�N�X�͔N�ł͂Ȃ��A�N�x�Ŕ���
    	//optionParam.put("YEAR", VRDateParser.format(getTargetDate().getDate(), "yyyy"));
    	optionParam.put("YEAR", VRDateParser.format(ACDateUtilities.addMonth(getTargetDate().getDate(), -3), "yyyy"));
    	
    	String query = getSQL_MAKE_OVER_40_PLAN_STAFF(optionParam);
    	
    	VRList over40list = null;
    	
    	try {
    		over40list = getDBManager().executeQuery(query);
    	} catch (Exception e) {
    		//�f�[�^�̑��݂��Ȃ��������������A�K���G���[�ɂȂ�B
    		//�I�}�P�@�\�Ȃ̂ŁA�G���[�͖�������
    		VRLogger.warning(e);
    	}
    	
    	//����0���̏ꍇ�͏������f
		if ((over40list == null) || (over40list.size() == 0)) {
			return;
		}
		
		StringBuilder msg = new StringBuilder();
		for (int i = 0; i < over40list.size(); i++){
			VRMap map = (VRMap)over40list.get(i);
			msg.append(map.get("CARE_MANAGER_NO"));
			msg.append("�F");
			msg.append(QkanCommon.toFullName(map.get("STAFF_FAMILY_NAME"),map.get("STAFF_FIRST_NAME")));
			msg.append("\n");
		}
		
		//�x�����b�Z�[�W��\������
		QkanMessageList.getInstance().QP001_WARNING_OVER_40_PLAN(msg.toString());
    	
    }
    //[ID:0000455][Shin Fujihara] 2009/02 add end ����21�N4���@�����Ή�
    
    /**
     * SQL�������N���X�ɑ���p�����[�^��ݒ肷��B
     * @param param
     * @throws Exception
     */
    private void setSQLParams(VRMap param) throws Exception {

        // ��ʂ́u�Ώ۔N��(targetDate)�v�ɓ��͂��ꂽ���t���A�uyyyyMMdd�v�`���̐��l�ɕϊ�����B
        param.put("TARGET_DATE_VALUE", VRDateParser.format(getTargetDate().getDate(), "yyyyMMdd"));

        // ��ʂ́u���o�̗͂��p�҂�����\��(notOutputDistinction)�v�̒l���擾����B
        // �I������Ă���ꍇ(�L�[���܂܂�Ă��邩�ۂ��Ŕ��f)
        if (getNotOutputDistinction().isSelected()) {
            // param�� KEY : OUTPUT_FLG, VALUE : null ��ݒ肷��B
            param.put("OUTPUT_FLG", null);
        }

        // ��ʏ�́u���p�҃R�[�h(patienCodeText)�v��Text���擾���A�S�p�X�y�[�X�Ɣ��p�X�y�[�X�𔲂��Ă����B
        // �擾���������񂪑��݂���ꍇ(�����񒷂�0���傫���ꍇ)
        if (!ACTextUtilities.isNullText(getPatientCodeText().getText())) {
            // �擾�����������param�� KEY : PATIENT_ID �� VALUE �Ƃ��Đݒ肷��B
            param.put("PATIENT_CODE", getPatientCodeText().getText());
        }

        if (!ACTextUtilities.isNullText(
                getPatientFuriganaText().getText())) {
            param.put("PATIENT_KANA", getPatientFuriganaText().getText());
        }

        // ��ʏ�̍��ۏ�������yyyyMMdd�^���� param �� KEY : SEIKYU_DATE �ɐݒ肷��B
        param.put("SEIKYU_DATE", VRDateParser.format(getClaimDate().getDate(),
                "yyyyMMdd"));

        // �������[�h��ǉ�����B
        param.put("AFFAIR", getAffair());
    }
    
    /**
     * �擾�����f�[�^��\���p�ɉ��H����B
     * @param param SQL���s�Ɏg�p�����p�����[�^
     * @throws Exception
     */
    private void editSelectData(VRMap param) throws Exception {
        // �v��P�ʐ��i�[�p
        VRMap planMap = new VRHashMap();
        // �T�[�r�X�P��
        VRMap serviceUnitMap = new VRHashMap();
        // ���v���z
        VRMap serviceTotalMap = new VRHashMap();
        // �ی������z
        VRMap hokenUnitMap = new VRHashMap();
        // ������z
        VRMap kohiUnitMap = new VRHashMap();
        // ���p�ҕ��S�z
        VRMap riyousyaUnitMap = new VRHashMap();
        // �����e�[�u�����
        VRMap claimMap = new VRHashMap();
        
        //�ی��敪
        VRMap insureTypeMap = new VRHashMap();
        
        //�ی��҂̖���
        VRMap insurerMap = new VRHashMap();
        ACBindUtilities.setMapFromArray(QkanCommon.getInsurerInfo(getDBManager()), insurerMap, "INSURER_ID");
        
        //����σt���O�m�F�p
        int printed = (QkanClaimStateFormat.getPrintedCode(getAffair()) | QkanClaimStateFormat.getCSVOutCode(getAffair()));
        
        // ���яW�v�ȊO�̃��[�h�ł���΁A�ʃf�[�^�̎擾���s���B
        if (!"01".equals(getAffair())) {
            if(getPatientData().size() > 0){
                try{
                    Date target = ACCastUtilities.toDate(((VRMap)getPatientData().get(0)).get("TARGET_DATE"));
                    param.put("TARGET_DATE_VALUE",target);
                } catch(Exception e){}

            }
            //�e�[�u�����쐬����Ă��Ȃ����Ƃ��l�����A1�e�[�u������try-catch
            //�v��P�ʐ����擾����B
            try{
                ACBindUtilities.setMapFromArray(getDBManager().executeQuery(
                        getSQL_GET_PLAN_UNIT(param)), planMap, "CODE");
            } catch (Exception e){
                VRLogger.warning(e);
            }
            //�T�[�r�X�P�ʐ����擾����B
            try{
                ACBindUtilities.setMapFromArray(getDBManager().executeQuery(
                        getSQL_GET_SERVICE_UNIT(param)), serviceUnitMap, "CODE");
            } catch(Exception e) {
                VRLogger.warning(e);
            }
            //�T�[�r�X���v���z���擾����B
            try {
                ACBindUtilities.setMapFromArray(getDBManager().executeQuery(
                        getSQL_GET_SERVICE_TOTAL(param)), serviceTotalMap, "CODE");
            } catch(Exception e) {
                VRLogger.warning(e);
            }
            //�ی������z���擾����B
            try{
                ACBindUtilities.setMapFromArray(getDBManager().executeQuery(
                        getSQL_GET_HOKEN_UNIT(param)), hokenUnitMap, "CODE");
            } catch(Exception e) {
                VRLogger.warning(e);
            }
            //����S�z���擾����B
            try{
                ACBindUtilities.setMapFromArray(getDBManager().executeQuery(
                        getSQL_GET_KOHI_UNIT(param)), kohiUnitMap, "CODE");
            } catch(Exception e) {
                VRLogger.warning(e);
            }
            //���p�ҕ��S�z���擾����B
            try{
                ACBindUtilities.setMapFromArray(getDBManager().executeQuery(
                        getSQL_GET_RIYOUSYA_UNIT(param)), riyousyaUnitMap, "CODE");
            } catch(Exception e){
                VRLogger.warning(e);
            }
            
            //�ی��敪���擾����B
            try{
                ACBindUtilities.setMapFromArray(getDBManager().executeQuery(
                        getSQL_GET_INSURE_TYPE(param)), insureTypeMap, "CODE");
            } catch(Exception e){
                VRLogger.warning(e);
            }
        }
        //����σt���O�̎擾
        try{
            param.put("CLAIM_DATE",getClaimDate().getDate());
            ACBindUtilities.setMapFromArray(getDBManager().executeQuery(
                    getSQL_GET_CLAIM(param)), claimMap, "CODE");
        } catch(Exception e){
            VRLogger.warning(e);
        }

        // �ǂ����Ă�SQL�ōi��Ȃ������̂ŁB
        // �ی��Ҕԍ��`�F�b�N
        boolean insurerCheck = !ACTextUtilities.isNullText(
                getInsurerNoText().getText());
        // ���p�҂��Ȏ����`�F�b�N
        boolean patientKanaCheck = !ACTextUtilities.isNullText(
                getPatientFuriganaText().getText());
        // ��ی��Ҕԍ��`�F�b�N
        boolean insureredCheck = !ACTextUtilities.isNullText(
                getInsuredNoText().getText());

        String insurer = getInsurerNoText().getText();
        String patient = getPatientFuriganaText().getText();
        String insurered = getInsuredNoText().getText();

        VRMap record = null;
        String comp = null;

        for (int i = getPatientData().getDataSize() - 1; i >= 0; i--) {
            record = (VRMap) getPatientData().getData(i);
            // �ی��Ҕԍ��`�F�b�N���s���B
            if (insurerCheck) {
                comp = String.valueOf(VRBindPathParser
                        .get("INSURER_ID", record));
                // DB�擾�����񂪌����Ώە�����Ŏn�܂��Ă��Ȃ���A�f�[�^�𔲂�
                if("06".equals(getAffair())){
                    if (!comp.endsWith(insurer)) {
                        getPatientData().removeData(i);
                        continue;
                    }
                } else {
                    if (!comp.startsWith(insurer)) {
                        getPatientData().removeData(i);
                        continue;
                    }
                }

            }
            // ���Ȏ����`�F�b�N���s���B
            if (patientKanaCheck) {
//                comp = String.valueOf(VRBindPathParser.get("PATIENT_KANA",record));
                comp = QkanCommon.toFullName(record.get("PATIENT_FAMILY_KANA"),record.get("PATIENT_FIRST_KANA"));
                
                if (!comp.startsWith(patient)) {
                    getPatientData().removeData(i);
                    continue;
                }

            }
            // ��ی��Ҕԍ��`�F�b�N
            if (insureredCheck) {
                comp = String.valueOf(VRBindPathParser.get("INSURED_ID", record));
                if (!comp.startsWith(insurered)) {
                    getPatientData().removeData(i);
                    continue;
                }

            }
            
            //����ς݃t���O�̊m�F�Ɖ���
            String printKey = ACCastUtilities.toString(VRBindPathParser.get("PATIENT_ID", record)) + "-"
                    + QkanSystemInformation.getInstance().getLoginProviderID() + "-";
                
                
            if("01".equals(getAffair())){
                printKey += VRDateParser.format(getTargetDate().getDate(),"yyyy-MM-dd");
            } else {
                //printKey += VRDateParser.format(getClaimDate().getDate(),"yyyy-MM-dd");
                printKey += VRDateParser.format(ACCastUtilities.toDate(VRBindPathParser.get("TARGET_DATE", record)),"yyyy-MM-dd");
                printKey += "-" + ACCastUtilities.toString(VRBindPathParser.get("INSURER_ID", record));
                printKey += "-" + ACCastUtilities.toString(VRBindPathParser.get("INSURED_ID", record));
            }
            
            if("01".equals(getAffair()) || "07".equals(getAffair()) || "08".equals(getAffair())){
                //�S�������n�̃I�v�V����
            } else {
                //�ʌ����n�̃I�v�V����
                printKey += "-" + ACCastUtilities.toString(VRBindPathParser.get("CLAIM_STYLE_TYPE", record));
            }
            
            if("01".equals(getAffair())){
            	//[ID:0000491][Shin Fujihara] 2009/07 edit begin 2009�N�x�Ή�
                //if(claimMap.containsKey(printKey)){
            	if((claimMap.containsKey(printKey))
            			&& (((VRMap)claimMap.get(printKey)).get("CLAIM_FINISH_FLAG") != null)){
                //[ID:0000491][Shin Fujihara] 2009/07 edit end 2009�N�x�Ή�
                    //���o�͂̃`�F�b�N
                    if(getNotOutputDistinction().isSelected()){
                        getPatientData().removeData(i);
                        continue;
                    } else {
                        VRMap claimData = (VRMap)claimMap.get(printKey);
                        record.put("TARGET_DATE",claimData.get("TARGET_DATE"));
                        record.put("PRINT",claimData.get("CLAIM_FINISH_FLAG"));
                        record.put("CLAIM_DATE",claimData.get("CLAIM_DATE"));
                    }

                } else {
                    record.put("TARGET_DATE",null);
                    record.put("PRINT",null);
                }
                //����ʑJ�ڂɎg�p���鐿���N����
                //record.put("CLAIM_DATE",getClaimDateUpdate().getDate());
                
            } else {
                if(claimMap.containsKey(printKey)){
                    VRMap claimData = (VRMap)claimMap.get(printKey);
                    //[ID:0000491][Shin Fujihara] 2009/07 edit begin 2009�N�x�Ή�
                    //CLAIM_FINISH_FLAG��null�̏ꍇ�́A���W�v�Ƃ��Ĉ���
                    if (claimData.get("CLAIM_FINISH_FLAG") == null){
                    	getPatientData().removeData(i);
                    	continue;
                    }
                    //[ID:0000491][Shin Fujihara] 2009/07 edit end 2009�N�x�Ή�
                    //���o�͂̃`�F�b�N
                    if(getNotOutputDistinction().isSelected()){
                        if((ACCastUtilities.toInt(claimData.get("CLAIM_FINISH_FLAG"),0) & printed) > 0 ){
                            getPatientData().removeData(i);
                            continue;
                        }
                    }
//                    record.put("TARGET_DATE",claimData.get("TARGET_DATE"));
                    record.put("PRINT",claimData.get("CLAIM_FINISH_FLAG"));
                } else {
                    //����t���O���擾�ł��Ȃ��ꍇ�̓��R�[�h�𔲂�
                    VRLogger.warning("����i���t���O�擾�G���[:" + record);
                    getPatientData().removeData(i);
                    continue;
                }
            }
            
            //�ی��Җ��̂�����
            String insurerId = ACCastUtilities.toString(record.get("INSURER_ID"));
            //�擾�����ی��Ҕԍ���6���ȏ�(��Õی�)�̏ꍇ�́A�㔼6�����̗p����B
            if(insurerId.length() > 6){
                insurerId = insurerId.substring(insurerId.length() - 6);
            }
            VRMap insureNameMap = (VRMap)insurerMap.get(insurerId);
            if(insureNameMap != null){
                record.put("INSURER_NAME", insureNameMap.get("INSURER_NAME"));
            }
            
            if (!"01".equals(getAffair())) {
                
                //�P�ʐ����ASQL���Ŏ擾�ł��Ȃ������f�[�^���}�b�s���O
                String key = ACCastUtilities.toString(VRBindPathParser.get("PATIENT_ID", record))
                        + "-"
                        + ACCastUtilities.toString(VRBindPathParser.get("INSURED_ID", record))
                        + "-"
                        + ACCastUtilities.toString(VRBindPathParser.get("CLAIM_STYLE_TYPE", record))
                        + "-"
                        + ACCastUtilities.toString(VRBindPathParser.get("TARGET_DATE", record));
                
                if(planMap.containsKey(key)){
                    record.put("PLAN_RATE", new Double(ACCastUtilities.toDouble(((VRMap)planMap.get(key)).get("UNIT"),0)));
                } else {
                    record.put("PLAN_RATE", new Double(0));
                }
                
                if(serviceUnitMap.containsKey(key)){
                    record.put("SERVICE_UNIT",new Double(ACCastUtilities.toDouble (((VRMap)serviceUnitMap.get(key)).get("UNIT"),0)));
                } else {
                    record.put("SERVICE_UNIT",new Double(0));
                }
                
                if(serviceTotalMap.containsKey(key)){
                    record.put("SERVICE_TOTAL",new Double(ACCastUtilities.toDouble(((VRMap)serviceTotalMap.get(key)).get("UNIT"),0)));
                } else {
                    record.put("SERVICE_TOTAL",new Double(0));
                }
                
                if(hokenUnitMap.containsKey(key)){
                    record.put("HOKEN",new Double(ACCastUtilities.toDouble (((VRMap)hokenUnitMap.get(key)).get("UNIT"),0)));
                } else {
                    record.put("HOKEN",new Double(0));
                }
                
                
                if(kohiUnitMap.containsKey(key)){
                    record.put("KOUHI",new Double(ACCastUtilities.toDouble (((VRMap)kohiUnitMap.get(key)).get("UNIT"),0)));
                } else {
                    record.put("KOUHI",new Double(0));
                }
                
                
                if(riyousyaUnitMap.containsKey(key)){
                    record.put("RIYOUSYA",new Double(ACCastUtilities.toDouble (((VRMap)riyousyaUnitMap.get(key)).get("UNIT"),0)));
                } else {
                    record.put("RIYOUSYA",new Double(0));
                }
                
                if(insureTypeMap.containsKey(key)){
                    record.put("INSURE_TYPE",((VRMap)insureTypeMap.get(key)).get("INSURE_TYPE"));
                }
            }
            
            //�����A���Ȏ������������\���p�ɕϊ�����
            record.put("PATIENT_NAME",QkanCommon.toFullName(record.get("PATIENT_FAMILY_NAME"),record.get("PATIENT_FIRST_NAME")));
            record.put("PATIENT_KANA",QkanCommon.toFullName(record.get("PATIENT_FAMILY_KANA"),record.get("PATIENT_FIRST_KANA")));
            
            record.put("KUBUN","�V�K");
            record.put("CHOISE",new Boolean(false));
            record.put("DELETE",new Boolean(false));
        }
    }

    private void setButtonState() throws Exception {
        //�I���ԍ����擾
        int select = getInfoTable().getSelectedModelRow();
        //���I���ł���Ώ����𒆒f
        if(select < 0){
            return;
        }
        //�I���̃f�[�^���擾
        VRMap map = (VRMap)getPatientData().get(select);
        
        //�W�v��̗񂪑I������Ă����
        if(!ACTextUtilities.isNullText(map.get("PRINT"))){
            setState_SELECTED_CLAIM();
        } else {
            setState_SELECTED_NO_CLAIM();
        }
        
        if ("01".equals(getAffair())) {
            if(getPatientData() == null) return;
            String choise;
            for (int i = 0; i < getPatientData().getDataSize(); i++) {
                choise = String.valueOf(VRBindPathParser.get("DELETE",
                        (VRLinkedHashMap) getPatientData().get(i)));
                // �I������Ă���Ή����\
                if ("TRUE".equalsIgnoreCase(choise)) {
                    getDelete().setEnabled(true);
                    return;
                }
            }
            getDelete().setEnabled(false);

        }
    }
    
    /**
     * �u���уf�[�^�̎擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception
     *             ������O
     */
    public void doTotal() throws Exception {

        // �W�v�̊m�F���b�Z�[�W��\������B
        if (QkanMessageList.getInstance().QP001_CONFIRMATION_PRINT() == ACMessageBox.RESULT_CANCEL) {
            return;
        }
        // �������ł��邱�Ƃ������E�F�C�e�B���O�t�H�[����\������B
        ACSplash splash = (ACSplash)ACFrame.getInstance().getFrameEventProcesser().createSplash("���яW�v");

        // �g�����U�N�V�������J�n����B
        getDBManager().beginTransaction();

        // targetDate�Ɍ����Ώی���ݒ肷��B
        getTargetDate().setDate( getTargetDate().getDate());

        // �f�[�^�}�l�[�W���̏�����
        QP001Manager manager = new QP001Manager(getDBManager(), getTargetDate().getDate());

        String choise;
        int patient_id;
        
        //[ID:0000561][Shin Fujihara] 2009/12/14 edit begin 2009�N�x�Ή�
        //�G���[�̏ڍו\���Ή��ɔ����A����t���O��ύX
        //boolean allCommit = true;
        QP001TotalErrors errors = new QP001TotalErrors();
        
        //�T�[�r�X���̃}�X�^�̎擾�ʒu��ύX
        setMasterServiceCache(QkanCommon.getMasterService(getDBManager(),getTargetDate().getDate()));
        //[ID:0000561][Shin Fujihara] 2009/12/14 edit end 2009�N�x�Ή�

        try {
            // patientData�̌��������[�v����B
            for (int i = 0; i < getPatientData().getDataSize(); i++) {
                VRMap map = (VRMap)getPatientData().get(i);
                
                choise = String.valueOf(VRBindPathParser.get("CHOISE",map));
                // ���I���̏ꍇ�������X�L�b�v����B
                if (!"TRUE".equalsIgnoreCase(choise))
                    continue;

                // ���p��ID�ޔ�p��int patient_id �𐶐����ApatientData�� KEY : PATIENT_ID
                // ��ݒ肷��B
                patient_id = Integer.parseInt(String.valueOf(VRBindPathParser
                        .get("PATIENT_ID", map)));
                
                // �����ɐ\�����̗��������݂���ꍇ�͏W�v�������s��Ȃ��B
                //[ID:0000561][Shin Fujihara] 2010/01 edit begin 2009�N�x�Ή�
                //���ʊ֐�QkanCommon.isFullDecisionPatientInsureInfo�ł�
                //����ł��Ȃ��̂ŁA�Ǝ������̗p
                VRList patientHistory = QkanCommon.getPatientInsureInfoHistory(getDBManager(), getTargetDate().getDate(), patient_id);
                
        		if (patientHistory == null || patientHistory.size() < 1) {
                    map.put("PRINT",null);
                    map.put("TARGET_DATE", null);
                    errors.addOutOfTermError(map);
                    continue;
        		}

        		for (int j = 0; j < patientHistory.size(); j++) {
        			VRMap record = (VRMap) patientHistory.get(j);
        			int changeFlag = ACCastUtilities.toInt(record.get("CHANGE_CODE"), 1);
        			// �\�����̗������������ꍇ��false��Ԃ��B
        			if (changeFlag == 1) {
                        map.put("PRINT",null);
                        map.put("TARGET_DATE", null);
                        errors.addApplyingError(map);
        				continue;
        			}
        		}
                //[ID:0000561][Shin Fujihara] 2010/01 edit end 2009�N�x�Ή�
                
                // ���p�ҏ��ڍ׎擾�p��VRArrayList patient �𐶐����A���ʊ֐����g�p���ė��p�ҏ��ڍׂ��擾����B
                VRMap patient = (VRLinkedHashMap) QkanCommon.getPatientInfo(
                        getDBManager(), patient_id).get(0);

                // �����\��f�[�^�ޔ�p�� VRArrayList servicePlanList
                // �����Ώۂ̗��p�҂̌������\��f�[�^���擾����B
                VRList servicePlanList = QkanCommon.getServiceDetail(
                        getDBManager(), patient_id, getTargetDate().getDate(),
                        QkanConstants.SERVICE_USE_TYPE_PLAN_MONTHLY_DAY.intValue());
                

                // �������уf�[�^�ޔ�p�� VRArrayList serviceDetailList
                // �����Ώۂ̗��p�҂̌��������уf�[�^���擾����B
                VRList serviceDetailList = QkanCommon.getServiceDetail(
                        getDBManager(), patient_id, getTargetDate().getDate(),
                        QkanConstants.SERVICE_USE_TYPE_RESULT_MONTHLY_DAY.intValue());
                
                // 2008/01/07 [Masahiko Higuchi] add - begin �����ϊ��Ή� (V5.4.1)
                // �ϊ��N���X�̐���
                QkanValidServiceCommon parser = new QkanValidServiceCommon();
                // �\��f�[�^�R�s�[�p
                VRList cloneServicePlanList = new VRArrayList();
                cloneServicePlanList.addAll(QkanValidServiceCommon.deepCopyVRList(servicePlanList));
                // ���уf�[�^�R�s�[�p
                VRList cloneServiceDetailList = new VRArrayList();
                cloneServiceDetailList.addAll(QkanValidServiceCommon.deepCopyVRList(serviceDetailList));
                
                servicePlanList = parser
                        .createValidService(getDBManager(), getTargetDate().getDate(),cloneServicePlanList,
                                patient_id);
                serviceDetailList = parser
                .createValidService(getDBManager(), getTargetDate().getDate(),cloneServiceDetailList,
                        patient_id);
                // 2008/01/07 [Masahiko Higuchi] add - end

                
                //�T�[�r�X�񋟓��ŕ��ёւ�
                Collections.sort(serviceDetailList, new DateComparator());
                
                //[ID:0000561][Shin Fujihara] 2009/12/14 edit begin 2009�N�x�Ή�
                //int result = doTotalDetail(patient, servicePlanList, serviceDetailList,manager);
                int result = doTotalDetail(patient, servicePlanList, serviceDetailList,manager, errors);
                //[ID:0000561][Shin Fujihara] 2009/12/14 edit end 2009�N�x�Ή�
                
                // ���ی����̎��яW�v���s�Ȃ��B
                if(result == 0){
                    //�W�v�ςɃt���O��ύX����B
                    map.put("PRINT","0");
                    map.put("TARGET_DATE", getTargetDate().getDate());
                    map.put("CLAIM_DATE", getClaimDateUpdate().getDate());
                } else if(result == 1){
                    //�W�v�ςɃt���O��ύX����B
                    map.put("PRINT","0");
                    map.put("TARGET_DATE", getTargetDate().getDate());
                    map.put("CLAIM_DATE", getClaimDateUpdate().getDate());
                    //[ID:0000561][Shin Fujihara] 2009/12/14 delete begin 2009�N�x�Ή�
                    //allCommit = false;
                    //[ID:0000561][Shin Fujihara] 2009/12/14 delete end 2009�N�x�Ή�
                } else if(result == 2){
                    //�W�v�Ɏ��s�����ꍇ�́A�\������������B
                    map.put("PRINT",null);
                    map.put("TARGET_DATE", null);
                    //[ID:0000561][Shin Fujihara] 2009/12/14 delete begin 2009�N�x�Ή�
                    //allCommit = false;
                    //[ID:0000561][Shin Fujihara] 2009/12/14 delete end 2009�N�x�Ή�
                }
            }

            // �g�����U�N�V�������I������B
            getDBManager().commitTransaction();

        } catch (Exception e) {
            getDBManager().rollbackTransaction();
            throw e;

        } finally {
            // �E�F�C�e�B���O�t�H�[�����I������B
            if (splash != null) {
                splash.close();
                splash = null;
            }
        }
        
        //�W�v�ł��Ȃ���񂪑��݂���ꍇ�A���b�Z�[�W��\������B
        //[ID:0000561][Shin Fujihara] 2009/12/14 edit begin 2009�N�x�Ή�
        //if(!allCommit){
        //	QkanMessageList.getInstance().QP001_ERROR_OF_NURSING_NECESSARY_LEVEL();
        if (errors.hasError()) {
        	errors.show();
        }
        //[ID:0000561][Shin Fujihara] 2009/12/14 edit end 2009�N�x�Ή�
        
        // �W�v���I���������Ƃ��������b�Z�[�W��\������B
        QkanMessageList.getInstance().QP001_INSERT_SUCCESSED();
        //�e�[�u���̍ĕ`����s��
        getInfoTable().repaint();
        //�{�^���̕\����ύX
        setButtonState();
        
    }

    /**
     * �u���ƎҖ��̎��яW�v�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @return 0:����I�� 1:�s���ȃT�[�r�X�R�[�h�𓾂����A�o�^�͎��s 2:�T�[�r�X�R�[�h�s���œo�^�������s
     * @throws Exception
     *             ������O
     */
    public int doTotalDetail(VRMap patient, VRList servicePlanList,
            VRList serviceDetailList,QP001Manager manager, QP001TotalErrors errors) throws Exception {
        
        //�W�v���ʕ񍐗p
        int update = 0;
        
        // �l���f�[�^�i�[�p
        VRMap styles = new VRHashMap();
        String serial = "";
        boolean firstRecord = false;
        
        // ���уf�[�^
        VRMap serviceDetail = null;
        // �T�[�r�X�R�[�h�W��
        List serviceCodeList = null;
        // �T�[�r�X�R�[�h
        VRMap serviceCode = null;
        // �l�����ʃI�u�W�F�N�g
        VRMap checkType = null;
        
        // ���щ�ʂœ��͂��ꂽ�v��P�ʐ�
        VRMap planUnitMap = null;
        
        // �񋟓�����p
        QP001OfferCalc offerCalc = new QP001OfferCalc();
        
        // ���p�҂̏����擾����B
        QP001PatientState patientState = new QP001PatientState(getDBManager(), patient, getTargetDate().getDate());
        
        //�T�[�r�X�R�[�h�������W�b�N�̃L���b�V�����N���A����B
        Qkan10011_ServiceCodeManager.getInstance().clearServiceCodeCache();

        // �����\��f�[�^�����[�v����
        for(int i = 0; i < servicePlanList.size(); i++){
            serviceDetail = (VRMap)servicePlanList.get(i);
            // �T�[�r�X���ޔ�p��VRArrayList serviceCode �𐶐����A
            // ���уf�[�^����T�[�r�X�����擾����B
            //[H20.4 �@�����Ή�] fujihara edit start
            Qkan10011_ServiceUnitGetter ug = Qkan10011_ServiceCodeManager.getInstance()
                    .getService(
                            String.valueOf(VRBindPathParser
                                    .get("SYSTEM_SERVICE_KIND_DETAIL",
                                            serviceDetail)),getTargetDate().getDate());
            //[H20.4 �@�����Ή�] fujihara edit end
            
            //�T�[�r�X�R�[�h�擾���i��NULL�ŋA���Ă�����A�������X�L�b�v����B
            if(ug == null){
                VRLogger.info("����ID:" + patientState.getPatientId() + "�@�\��f�[�^�̃T�[�r�X�R�[�h�擾�Ɏ��s���܂����B");
                continue;
            }
            
            // �T�[�r�X���{����ݒ�
            ug.setSysYmd(ACCastUtilities.toDate(VRBindPathParser.get("SERVICE_DATE", serviceDetail)));
            
            String jotaiCode = patientState.getJotaiCode(VRBindPathParser.get("SERVICE_DATE",serviceDetail));
            //�v���x�̃`�F�b�N
            if(ACTextUtilities.isNullText(jotaiCode) || "1".equals(jotaiCode)){
                continue;
            }

            // �v���x
            VRBindPathParser.set("1", serviceDetail, patientState.getJotaiCode(VRBindPathParser.get("SERVICE_DATE",serviceDetail)));
            // ���ʒn����Z
            VRBindPathParser.set("2", serviceDetail, manager
                    .getSpecialAreaFlag(
                            ACCastUtilities.toString(VRBindPathParser.get(
                                    "PROVIDER_ID", serviceDetail))));
            
            //���������
            VRBindPathParser.set("7",serviceDetail,patientState.getShisetsuData("TOKUTEI_NYUSHO_FLAG"));
            
            //���[�u������
            if(!serviceDetail.containsKey("8")){
                VRBindPathParser.set("8",serviceDetail,patientState.getShisetsuData("KYUSOCHI_FLAG"));
            }
            
            //���R�Ԓn��
            VRBindPathParser.set("13",serviceDetail, manager.getChusankanChiikiCode(serviceDetail));
            
            //[ID:0000682][Shin Fujihara] add begin �y�@�����Ή��z���E���������P���Z
            VRBindPathParser.set(Qkan10011_ServiceUnitGetter.SYOGUKAIZEN_KASAN, serviceDetail, manager.getSyoguFlag(serviceDetail));
            //[ID:0000682][Shin Fujihara] add end �y�@�����Ή��z���E���������P���Z
            
            if(!isProcessingTotal(patientState, serviceDetail)){
                continue;
            }

            // �T�[�r�X�R�[�h���擾����
            serviceCodeList = ug.getServiceCode(serviceDetail, getDBManager());
            
            boolean first = true;
            // �T�[�r�X��񕪃��[�v����B
            for (int j = 0; j < serviceCodeList.size(); j++) {
                serviceCode = (VRMap) serviceCodeList.get(j);
                
                //�T�[�r�X�R�[�h�擾�`�F�b�N
                if((serviceCode == null) || (serviceCode.size() == 0)){
                    continue;
                }
                
                QP001Style11 style11 = null;
                serial = QP001Style11.getSerialId(getTargetDate().getDate(), serviceDetail,patientState);
                
                if (!styles.containsKey(serial)) {
                    style11 = new QP001Style11();
                    styles.put(serial, style11);
                } else {
                    style11 = (QP001Style11) styles.getData(serial);
                }
                
                //2007.2.8 fujihara.shin ��ԖK��^�̏�Q�Ή�
                first = style11.parse(serviceDetail, getTargetDate().getDate(), patientState,
                        serviceCode,first,manager);
                
                //first = false;
            }
        }
        
        // ��U�A�\��f�[�^�̊m����s��
        Iterator<String> it = styles.keySet().iterator();
        while (it.hasNext()) {
            ((QP001Style11) styles.getData(it.next())).commitRecords();
        }
        
        
        // �������уf�[�^�����[�v����B
        for (int i = 0; i < serviceDetailList.getDataSize(); i++) {
            // �T�[�r�X���̎��уf�[�^�ޔ�p�� VRHashMap serviceDetail
            // �𐶐����A�f�[�^��ޔ�����B
            serviceDetail = (VRMap) serviceDetailList.getData(i);
            
            //���уf�[�^�����O�C�����Ə��̂��̂ł��邩�m�F����B
            if(!QkanSystemInformation.getInstance().getLoginProviderID().equals(String.valueOf(serviceDetail.get("PROVIDER_ID")))){
                continue;
            }
            
            //�v��P�ʐ������Ə����Ƃɕێ�����悤�ύX
            //���ѓo�^��ʂœ��͂��ꂽ�v��P�ʐ��̃f�[�^�ł��邩�m�F
            if(ACCastUtilities.toString(serviceDetail.get("SYSTEM_SERVICE_KIND_DETAIL"),"").equals("1")){
                planUnitMap = serviceDetail;
                continue;
            }

            // �T�[�r�X���ޔ�p��VRArrayList serviceCode �𐶐����A
            // ���уf�[�^����T�[�r�X�����擾����B
            //[H20.4 �@�����Ή�] fujihara edit start
            Qkan10011_ServiceUnitGetter ug = Qkan10011_ServiceCodeManager.getInstance()
                    .getService(
                            String.valueOf(VRBindPathParser
                                    .get("SYSTEM_SERVICE_KIND_DETAIL",
                                            serviceDetail)),getTargetDate().getDate());
            //[H20.4 �@�����Ή�] fujihara edit end
            
            //�T�[�r�X�R�[�h�擾���i��NULL�ŋA���Ă�����A���̏W�v���s��
            if(ug == null){
                continue;
            }
            
            String jotaiCode = patientState.getJotaiCode(VRBindPathParser.get("SERVICE_DATE",serviceDetail));
            //�v���x�̃`�F�b�N
            if(ACTextUtilities.isNullText(jotaiCode) || "1".equals(jotaiCode)){
            	//[ID:0000561][Shin Fujihara] 2010/01 edit begin 2009�N�x�Ή�
            	errors.addOutOfTermError(patient);
            	//[ID:0000561][Shin Fujihara] 2010/01 edit end 2009�N�x�Ή�
                continue;
            }
            
            // �T�[�r�X���{����ݒ�
            ug.setSysYmd(ACCastUtilities.toDate(VRBindPathParser.get(
                    "SERVICE_DATE", serviceDetail)));

            // �v���x
            VRBindPathParser.set("1", serviceDetail, patientState
                    .getJotaiCode(VRBindPathParser.get("SERVICE_DATE",
                            serviceDetail)));
            
            // ���ʒn����Z
            VRBindPathParser.set("2", serviceDetail, manager
                    .getSpecialAreaFlag(
                            ACCastUtilities.toString(VRBindPathParser.get(
                                    "PROVIDER_ID", serviceDetail))));
            
            //���������
            VRBindPathParser.set("7",serviceDetail,patientState.getShisetsuData("TOKUTEI_NYUSHO_FLAG"));
            
            //���[�u������
            if(!serviceDetail.containsKey("8")){
                VRBindPathParser.set("8",serviceDetail,patientState.getShisetsuData("KYUSOCHI_FLAG"));
            }
            
            //���R�Ԓn��
            VRBindPathParser.set("13",serviceDetail, manager.getChusankanChiikiCode(serviceDetail));
            
            //[ID:0000682][Shin Fujihara] add begin �y�@�����Ή��z���E���������P���Z
            VRBindPathParser.set(Qkan10011_ServiceUnitGetter.SYOGUKAIZEN_KASAN, serviceDetail, manager.getSyoguFlag(serviceDetail));
            //[ID:0000682][Shin Fujihara] add end �y�@�����Ή��z���E���������P���Z
            
            if(!isProcessingTotal(patientState, serviceDetail)){
                continue;
            }

            // �T�[�r�X�R�[�h���擾����
            serviceCodeList = ug.getServiceCode(serviceDetail, getDBManager());

            firstRecord = true;
            
            //�T�[�r�X�R�[�h�̕ϊ����s���B
            if(!serviceCodeConvert(serviceCodeList,manager,serviceDetail)){
                update = 1;
                //[ID:0000561][Shin Fujihara] 2009/12/14 add begin 2009�N�x�Ή�
                errors.addServiceError(patient, serviceDetail, getMasterServiceCache());
                //[ID:0000561][Shin Fujihara] 2009/12/14 add end 2009�N�x�Ή�
                continue;
            }
            
            // �T�[�r�X��񕪃��[�v����B
            lbl:for (int j = 0; j < serviceCodeList.size(); j++) {
                serviceCode = (VRMap) serviceCodeList.get(j);
                
                //�T�[�r�X�R�[�h�擾�`�F�b�N
                if((serviceCode == null) || (serviceCode.size() == 0)){
                	//[ID:0000561][Shin Fujihara] 2009/12/14 add begin 2009�N�x�Ή�
                	errors.addServiceError(patient, serviceDetail, getMasterServiceCache());
                	//[ID:0000561][Shin Fujihara] 2009/12/14 add end 2009�N�x�Ή�
                    continue;
                }

                // �l�����ʃf�[�^�ޔ�p�� VRArrayList checkType �𐶐����A�T�[�r�X�l�������擾����B
                //[ID:0000561][Shin Fujihara] 2009/12/14 edit begin 2009�N�x�Ή�
                //�L���b�V�������T�[�r�X���̃}�X�^���疼�̂��擾����悤�ɕύX
                //checkType = (VRMap)QkanCommon.getMasterService(getDBManager(),getTargetDate().getDate()).get(new Integer(String.valueOf(serviceCode.get("SYSTEM_SERVICE_KIND_DETAIL"))));
                checkType = (VRMap)getMasterServiceCache().get(new Integer(String.valueOf(serviceCode.get("SYSTEM_SERVICE_KIND_DETAIL"))));
                //[ID:0000561][Shin Fujihara] 2009/12/14 edit end 2009�N�x�Ή�

                int type = ACCastUtilities.toInt(VRBindPathParser.get("CLAIM_STYLE_TYPE", checkType));
                
                switch(type){
                    //(�l����2)�̏ꍇ
                    case QkanConstants.CLAIM_STYLE_FORMAT_2:
                    case QkanConstants.CLAIM_STYLE_FORMAT_2_2:
                        QP001Style2 style2 = null;
                        serial = QP001Style2.getSerialId(getTargetDate().getDate(), serviceDetail,
                                patientState,type);
                        if (!styles.containsKey(serial)) {
                            style2 = new QP001Style2(type,manager);
                            styles.put(serial, style2);
                        } else {
                            style2 = (QP001Style2) styles.getData(serial);
                        }
                        // �l�����̉��
                        style2.parse(serviceDetail, getTargetDate().getDate(), patientState,
                                serviceCode);
                        break;
                        
                    //(�l����3)�̏ꍇ
                    case QkanConstants.CLAIM_STYLE_FORMAT_3:
                    case QkanConstants.CLAIM_STYLE_FORMAT_3_2:
                        QP001Style3 style3 = null;
                        serial = QP001Style3.getSerialId(getTargetDate().getDate(), serviceDetail,
                                patientState,type);
                        if (!styles.containsKey(serial)) {
                            style3 = new QP001Style3(type,manager);
                            styles.put(serial, style3);
                        } else {
                            style3 = (QP001Style3) styles.getData(serial);
                        }
                        // �l����O�̉��
                        style3.parse(serviceDetail, getTargetDate().getDate(), patientState,
                                serviceCode);
                        break;
                    
                    //(�l����4)�̏ꍇ
                    case QkanConstants.CLAIM_STYLE_FORMAT_4:
                    case QkanConstants.CLAIM_STYLE_FORMAT_4_2:
                        QP001Style4 style4 = null;
                        serial = QP001Style4.getSerialId(getTargetDate().getDate(), serviceDetail,
                                patientState,type);
                        if (!styles.containsKey(serial)) {
                            style4 = new QP001Style4(type,manager);
                            styles.put(serial, style4);
                        } else {
                            style4 = (QP001Style4) styles.getData(serial);
                        }
                        // �l����l�̉��
                        //[H20.5 �@�����Ή�] fujihara edit start
//                        style4.parse(serviceDetail, getTargetDate().getDate(), patientState,
//                                serviceCode);
                        style4.parse(serviceDetail, getTargetDate().getDate(), patientState,
                                serviceCode,firstRecord);
                        //[H20.5 �@�����Ή�] fujihara edit end
                        break;
                        
                    //(�l����5)�̏ꍇ
                    case QkanConstants.CLAIM_STYLE_FORMAT_5:
                    case QkanConstants.CLAIM_STYLE_FORMAT_5_2:
                        QP001Style5 style5 = null;
                        serial = QP001Style5.getSerialId(getTargetDate().getDate(), serviceDetail,
                                patientState,type);
                        if (!styles.containsKey(serial)) {
                            style5 = new QP001Style5(type,manager);
                            styles.put(serial, style5);
                        } else {
                            style5 = (QP001Style5) styles.getData(serial);
                        }
                        // �l����܂̉��
                        style5.parse(serviceDetail, getTargetDate().getDate(), patientState,
                                serviceCode,firstRecord);
                        break;
                    
                    //(�l����6)�̏ꍇ
                    case QkanConstants.CLAIM_STYLE_FORMAT_6:
                    case QkanConstants.CLAIM_STYLE_FORMAT_6_2:
                    case QkanConstants.CLAIM_STYLE_FORMAT_6_3:
                    case QkanConstants.CLAIM_STYLE_FORMAT_6_4:
                    case QkanConstants.CLAIM_STYLE_FORMAT_6_5:
                    case QkanConstants.CLAIM_STYLE_FORMAT_6_6:
                    case QkanConstants.CLAIM_STYLE_FORMAT_6_7:
                        QP001Style6 style6 = null;
                        serial = QP001Style6.getSerialId(getTargetDate().getDate(), serviceDetail,
                                patientState,type);
                        if (!styles.containsKey(serial)) {
                            style6 = new QP001Style6(type,manager);
                            styles.put(serial, style6);
                        } else {
                            style6 = (QP001Style6) styles.getData(serial);
                        }
                        // �l����Z�̉��
                        style6.parse(serviceDetail, getTargetDate().getDate(), patientState,
                                serviceCode);
                        break;
                        
                    //(�l����7)�̏ꍇ
                    case QkanConstants.CLAIM_STYLE_FORMAT_7:
                    case QkanConstants.CLAIM_STYLE_FORMAT_7_2:
                        //��O����
                        //�l���掵�̏ꍇ�́A�����̃T�[�r�X�R�[�h���擾����K�v�����邽�߁A
                        //�T�[�r�X�R�[�h���擾���Ȃ����B
                        Date targetServiceDate = ACCastUtilities.toDate(VRBindPathParser.get("SERVICE_DATE", serviceDetail));
                        VRBindPathParser.set("1",
                                serviceDetail,
                                patientState.getNinteiDataLast(patientState.getInsurerId(targetServiceDate), patientState.getInsuredId(targetServiceDate),"JOTAI_CODE"));
                        List serviceCodeListTemp = ug.getServiceCode(serviceDetail, getDBManager());
                        if((serviceCodeListTemp == null) || (serviceCodeListTemp.size() == 0)){
                            break;
                        }
                        //[ID:0000447][Shin Fujihara] 2009/02 delete begin ����21�N4���@�����Ή�
                        //serviceCode = (VRMap) serviceCodeListTemp.get(0);
                        //[ID:0000447][Shin Fujihara] 2009/02 delete end ����21�N4���@�����Ή�
                        
                        QP001Style7 style7 = null;
                        //[H20.4 �@�����Ή�] fujihara edit start
                        if (styles.containsKey(QP001Style7.getSerialId(type,getTargetDate().getDate()))) {
                            style7 = (QP001Style7) styles.getData(QP001Style7.getSerialId(type,getTargetDate().getDate()));
                        } else {
                            style7 = new QP001Style7(type,manager);
                            styles.put(QP001Style7.getSerialId(type,getTargetDate().getDate()), style7);
                        }
                        //[H20.4 �@�����Ή�] fujihara edit end
                        
                        //[ID:0000447][Shin Fujihara] 2009/02 edit begin ����21�N4���@�����Ή�
                        for (int k = 0; k < serviceCodeListTemp.size(); k++) {
                            serviceCode = (VRMap) serviceCodeListTemp.get(k);
                            style7.parse(serviceDetail, getTargetDate().getDate(), patientState,
                                    serviceCode,manager);
                        }
                        break lbl;
                        //[ID:0000447][Shin Fujihara] 2009/02 edit end ����21�N4���@�����Ή�
                        
                    //(�l����8)�̏ꍇ
                    case QkanConstants.CLAIM_STYLE_FORMAT_8:
                        QP001Style8 style8 = null;
                        serial = QP001Style8.getSerialId(getTargetDate().getDate(), serviceDetail,
                                patientState,type);
                        if (!styles.containsKey(serial)) {
                            style8 = new QP001Style8(type,manager);
                            styles.put(serial, style8);
                        } else {
                            style8 = (QP001Style8) styles.getData(serial);
                        }
                        // �l���攪�̉��
                        style8.parse(serviceDetail, getTargetDate().getDate(), patientState,
                                serviceCode);
                        break;
                        
                    //(�l����9)�̏ꍇ
                    case QkanConstants.CLAIM_STYLE_FORMAT_9:
                        QP001Style9 style9 = null;
                        serial = QP001Style9.getSerialId(getTargetDate().getDate(), serviceDetail,
                                patientState,type);
                        if (!styles.containsKey(serial)) {
                            style9 = new QP001Style9(type,manager);
                            styles.put(serial, style9);
                        } else {
                            style9 = (QP001Style9) styles.getData(serial);
                        }
                        // �l�����̉��
                        //[H20.5 �@�����Ή�] fujihara edit start
//                        style9.parse(serviceDetail, getTargetDate().getDate(), patientState,
//                                serviceCode);
                        style9.parse(serviceDetail, getTargetDate().getDate(), patientState,
                                serviceCode,firstRecord);
                        //[H20.5 �@�����Ή�] fujihara edit end
                        break;
                        
                    //10(�l����10)�̏ꍇ
                    case QkanConstants.CLAIM_STYLE_FORMAT_10:
                        QP001Style10 style10 = null;
                        serial = QP001Style10.getSerialId(getTargetDate().getDate(),
                                serviceDetail, patientState,type);
                        if (!styles.containsKey(serial)) {
                            style10 = new QP001Style10(type,manager);
                            styles.put(serial, style10);
                        } else {
                            style10 = (QP001Style10) styles.getData(serial);
                        }
                        // �l����\�̉��
                        style10.parse(serviceDetail, getTargetDate().getDate(), patientState,
                                serviceCode,firstRecord);
                        break;
                        
                }
                //[ID:0000435][Shin Fujihara] 2009/07 add begin 2009�N�x�Ή�
                offerCalc.analize(serviceDetail, serviceCode);
                //[ID:0000435][Shin Fujihara] 2009/07 add end 2009�N�x�Ή�
                firstRecord = false;
            }
            
            //���t�Ǘ��[�Ɏx�������ԍ��̐ݒ���s��
            serial = QP001Style11.getSerialId(getTargetDate().getDate(), serviceDetail,patientState);
            if (styles.containsKey(serial)) {
                QP001Style11 style11 = (QP001Style11) styles.getData(serial);
                style11.parse(serviceDetail);
            }
        }

        // �f�[�^�̊m����s��
        it = styles.keySet().iterator();
        while (it.hasNext()) {
            
            QP001StyleAbstract commitData = (QP001StyleAbstract) styles.getData(it.next());
            if(commitData instanceof QP001Style2){
                //�l�����̏ꍇ�A�s�v�ȃ��R�[�h���Ȃ����m�F����B
                ((QP001Style2)commitData).arrangement();
            }
            commitData.commitRecords(patientState,styles,planUnitMap);
        }
        
        // �f�[�^�̓o�^���s
        it = styles.keySet().iterator();
        VRList updateList = new VRArrayList();
        while (it.hasNext()) {
            QP001StyleAbstract updateData = (QP001StyleAbstract) styles.getData(it.next());
            //���t�Ǘ��f�[�^�̏ꍇ
            if(updateData instanceof QP001Style11){
                //���������Ə��ԍ��ƃ��O�C�����Ə��ԍ����������Ȃ���΍X�V�������s��Ȃ��B
                if(!QkanSystemInformation.getInstance().getLoginProviderID().equals(((QP001Style11)updateData).getProviderId())){
                    continue;
                }
            //[ID:0000561][Shin Fujihara] 2010/01 edit begin 2009�N�x�Ή�
            //�l���掵�f�[�^�̏ꍇ
            } else if (updateData instanceof QP001Style7) {
            	VRList updateListTemp = updateData.getRecords(patientState.getPatientId(), getClaimDateUpdate().getDate()); 
            	if (updateListTemp.size() == 0){
            		errors.addSelfPlanStyle7(patient);
            	} else {
            		updateList.addAll(updateListTemp);
            	}
            	continue;
            }
            //[ID:0000561][Shin Fujihara] 2010/01 edit end 2009�N�x�Ή�
            updateList.addAll(updateData.getRecords(patientState.getPatientId(), getClaimDateUpdate().getDate()));
        }
        
        //[ID:0000491][Shin Fujihara] 2009/07 add begin 2009�N�x�Ή�
        QP001InformationProcessing hold = new QP001InformationProcessing(getDBManager(), patientState, getTargetDate().getDate());
        hold.reflect(updateList);
        hold = null;
        //[ID:0000491][Shin Fujihara] 2009/07 add end 2009�N�x�Ή�
        
        QkanCommon.updateClaimDetail(getDBManager(), updateList, getTargetDate().getDate(),
                patientState.getPatientId(),QkanSystemInformation.getInstance().getLoginProviderID());
        
        
        // 2008/01/07 [Masahiko Higuchi] add - begin �S�z���ȕ��S���̎Z�o����
        //[ID:0000435][Shin Fujihara] 2009/07 edit begin 2009�N�x�Ή�
        //doTotalDetailPatientSelf(updateList,manager,patientState);
        
        //[ID:0000612][Shin Fujihara] 2010/11 edit begin 2010�N�x�Ή�
        //�T�[�r�X��ނ��Ƃɗ��p�҂ւ̐������E�̎������s�Ή�
        //�d�����鏈�����e�����邪�A���������͂��̂܂܎c���A�V���ȃ��W�b�N���쐬����B
        
        if (isServiceByReceipt()){
        	//�V�K����(�񋟂����T�[�r�X��ނ��ƂɁACLAIM_PATIENT_DETAIL�փ��R�[�h���쐬)
        	doTotalDetailPatientSelfService(updateList,manager,patientState, offerCalc);
        	
        } else {
        	//��������
            doTotalDetailPatientSelf(updateList,manager,patientState, offerCalc);
            
        }
        offerCalc = null;
        
        //[ID:0000612][Shin Fujihara] 2010/11 edit end 2010�N�x�Ή�
        
        //[ID:0000435][Shin Fujihara] 2009/07 edit end 2009�N�x�Ή�
        // 2008/01/07 [Masahiko Higuchi] add - end
        
        if((updateList == null) || (updateList.size() <= 0)){
            update = 2;
        }
        
        return update;
    }
    
    // add sta 2006.05.20 fujihara.shin
    
    // 2008/01/07 [Masahiko Higuchi] add - begin �S�z���ȕ��S�����W�v�@�\
    /**
     * �����_�ȉ����l�����������Ȋz��Ԃ��܂�
     * 
     * @author Masahiko Higuchi
     * @since Ver 5.4.1
     */
    protected int get_701015Multiplies100(double _701015) {
        BigDecimal temp = new BigDecimal(String.valueOf(_701015));
        temp = temp.multiply(new BigDecimal("100"));
        return temp.intValue();
    }
    // 2008/01/07 [Masahiko Higuchi] add - end
    
    /**
     * �W�v���s���Ă悢���̔��f���s���B
     * @param patientState
     * @param serviceDetail
     * @return
     * @throws Exception
     */
    private boolean isProcessingTotal(QP001PatientState patientState, VRMap serviceDetail) throws Exception {
        
        Date targetDate = ACCastUtilities.toDate(VRBindPathParser.get("SERVICE_DATE", serviceDetail));
        
        //���ےP�Ǝ҂łȂ���΁A�����̑��s��������
        if(!QP001SpecialCase.isSeihoOnly(patientState.getInsuredId(targetDate))){
            return true;
        }
        
        //�Ώۓ��̌���ꗗ���擾
        VRList list = patientState.getKohiData(targetDate,1,ACCastUtilities.toString(VRBindPathParser.get("SYSTEM_SERVICE_KIND_DETAIL", serviceDetail)));
        
        //������Ă��Ȃ��ꍇ�́A�����𒆒f����
        if((list == null) || (list.size() == 0)){
            return false;
        }
        
        for(int i = 0; i < list.size(); i++){
            VRMap map = (VRMap)list.get(i);
            if(map != null){
                String kohi = ACCastUtilities.toString(map.get("KOHI_LAW_NO"));
                if("12".equals(kohi)){
                    return true;
                }
            }
        }
        
        return false;
    }
    // add end 2006.05.20 fujihara.shin
    
    /**
     * �T�[�r�X�R�[�h�̕ϊ����s���B
     * @param serviceCode
     * @return true:�R���o�[�g���� false:�R���o�[�g���s�i���Z�݂̂̃`�F�b�N�������̂ɁA���Z�݂̂̃��R�[�h�ō\������Ă���etc�j
     * @throws Exception
     */
    private boolean serviceCodeConvert(List serviceCodeList,QP001Manager manager, VRMap serviceDetail) throws Exception {
        
        // H24.04 ���ʒn����Z�A���R�Ԓn����Z�̌v�Z���@�����P
        
        boolean result = false;
        Integer unit = null;
        VRMap addMap = null;
        VRMap chusanAddMap = null;
        VRMap unitMap = new VRHashMap();
        
        for (int j = 0; j < serviceCodeList.size(); j++) {
            VRMap serviceCode = (VRMap) serviceCodeList.get(j);
            
            //�{�̕�V�ł���΁A�P�ʐ���ޔ�
            if (ACCastUtilities.toInt(serviceCode.get("SERVICE_MAIN_FLAG"),0) == 1) {
                
                //�L�[�̍Ō��
                String key = String.valueOf(serviceCode.get("SYSTEM_SERVICE_KIND_DETAIL")) + "-"
                + String.valueOf(serviceCode.get("SYSTEM_SERVICE_CODE_ITEM")) + "-"
                + String.valueOf(serviceCode.get("TOTAL_GROUPING_TYPE"));
                
                unit = new Integer(manager.getServiceUnit(String.valueOf(serviceDetail.get("PROVIDER_ID")),serviceCode));
                unitMap.put(key,unit);
                result = true;
                continue;
            }
            
            switch(ACCastUtilities.toInt(serviceCode.get("SERVICE_ADD_FLAG"),0)){
            case 1: //�ʏ퐿��
                result = true;
                break;
            case 3: //���ʒn����Z
                addMap = (VRMap) serviceCodeList.get(j);
                break;
            case 6: //���R�Ԓn����Z
            	chusanAddMap = (VRMap) serviceCodeList.get(j);
            	break;
            }
        }
        
        if(addMap != null){
            addMap.put("SERVICE_UNIT_MAP",unitMap);
        }
        
        if (chusanAddMap != null) {
        	chusanAddMap.put("SERVICE_UNIT_MAP",unitMap);
        	if(addMap != null){
        		chusanAddMap.put("SERVICE_UNIT_ADD_MAP",addMap);
        	}
        }
        
        if(!result){
            //���Z�݂̂̃`�F�b�N���m�F
            if(serviceDetail.containsKey("9")){
                if(ACCastUtilities.toInt(serviceDetail.get("9"),0) == 2){
                    result = true;
                }
            }
        }
        
        return result;
    }

    /**
     * �u���������̃`�F�b�N�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception
     *             ������O
     */
    public boolean checkFind() throws Exception {
        // �������t�����̓`�F�b�N
        if (ACTextUtilities.isNullText(getTargetDate().getText())) {
            QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT("�Ώ۔N��");
            getTargetDate().requestFocus();
            return false;
        }
        // �������t�Ó����`�F�b�N
        if (!getTargetDate().isValidDate()) {
            QkanMessageList.getInstance().ERROR_OF_WRONG_DATE("�Ώ۔N����");
            getTargetDate().requestFocus();
            return false;
        }

        // �����N���������̓`�F�b�N
        if (ACTextUtilities.isNullText(getClaimDateUpdate().getText())) {
            QkanMessageList.getInstance()
                    .ERROR_OF_NEED_CHECK_FOR_INPUT("�����N����");
            getClaimDateUpdate().requestFocus();
            return false;
        }
        // �������t�Ó����`�F�b�N
        if (!getClaimDateUpdate().isValidDate()) {
            QkanMessageList.getInstance().ERROR_OF_WRONG_DATE("�����N������");
            getClaimDateUpdate().requestFocus();
            return false;
        }
        
        //�����p�����N���������̓`�F�b�N
        if (ACTextUtilities.isNullText(getClaimDate().getText())) {
            QkanMessageList.getInstance()
                    .ERROR_OF_NEED_CHECK_FOR_INPUT("�����N����");
            getClaimDate().requestFocus();
            return false;
        }
        
        //�����p�����N�����Ó����`�F�b�N
        if (!getClaimDate().isValidDate()) {
            QkanMessageList.getInstance().ERROR_OF_WRONG_DATE("�����N������");
            getClaimDate().requestFocus();
            return false;
        }

        return true;

    }

    /**
     * �u���p�ґI���̊m�F�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception
     *             ������O
     */
    public boolean checkSelect(String fieldName, String processName) throws Exception {
        // �������t�����̓`�F�b�N
        if (ACTextUtilities.isNullText(getTargetDate().getText())) {
            QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT("�Ώ۔N��");
            getTargetDate().requestFocus();
            return false;
        }
        // �������t�Ó����`�F�b�N
        if (!getTargetDate().isValidDate()) {
            QkanMessageList.getInstance().ERROR_OF_WRONG_DATE("�Ώ۔N����");
            getTargetDate().requestFocus();
            return false;
        }

        // �����N���������̓`�F�b�N
        if (ACTextUtilities.isNullText(getClaimDateUpdate().getText())) {
            QkanMessageList.getInstance()
                    .ERROR_OF_NEED_CHECK_FOR_INPUT("�����N����");
            getClaimDateUpdate().requestFocus();
            return false;
        }
        // �������t�Ó����`�F�b�N
        if (!getClaimDateUpdate().isValidDate()) {
            QkanMessageList.getInstance().ERROR_OF_WRONG_DATE("�����N������");
            getClaimDateUpdate().requestFocus();
            return false;
        }
        
        // [ID:0000599][Shin Fujihara] 2010/11 edit begin 2010�N�x�Ή�
        // �Ώ۔N���Ɛ����N���̑Ó����`�F�b�N
        //[ID:0000727][Masahiko.Higuchi] 2012/04 ����24�N4���@�����Ή� edit begin
        // ���яW�v�̎��̂݃`�F�b�N���s���悤�C��
        //if (ACDateUtilities.getDifferenceOnMonth(getClaimDateUpdate().getDate(), getTargetDate().getDate()) <= 0) {
        if ("01".equals(getAffair()) && ACDateUtilities.getDifferenceOnMonth(getClaimDateUpdate().getDate(), getTargetDate().getDate()) <= 0) {
        //[ID:0000727][Masahiko.Higuchi] 2012/04 ����24�N4���@�����Ή� edit end
        	//[ID:0000629]���яW�v�̃��b�Z�[�W�\�����ɂ��Ēǉ�
        	String targetMonth = getTargetDate().getText();
        	String claimMonthUsually = VRDateParser.format(ACDateUtilities.addMonth(getTargetDate().getDate(), 1), "ggge�NM��");
        	
            if (QkanMessageList.getInstance().QP001_WARNING_CLAIMDATE_COMP(
            		targetMonth,
            		claimMonthUsually) == ACMessageBox.RESULT_CANCEL) {
            	return false;
            }
        }
        // [ID:0000599][Shin Fujihara] 2010/11 edit end 2010�N�x�Ή�
        
        
        String choise;
        boolean select = false;
        // patientData�̌��������[�v����B
        for (int i = 0; i < getPatientData().getDataSize(); i++) {
            choise = String.valueOf(VRBindPathParser.get("CHOISE",
                    (VRLinkedHashMap) getPatientData().get(i)));
            if ("TRUE".equalsIgnoreCase(choise)) {
                select = true;
                break;
            }
        }
        if (!select) {
            if (QkanMessageList.getInstance().QP001_WARGNING_TOTAL(fieldName,processName) == ACMessageBox.RESULT_CANCEL) {
                return false;
            }
            // �S�I��
            allSelectActionPerformed(null);
        }
        return true;
    }


    /**
     * �uCSV�t�@�C���̍쐬�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception
     *             ������O
     */
    public String makeCSV(VRMap settings) throws Exception {
        String result = "";
        // �������ł��邱�Ƃ������E�F�C�e�B���O�t�H�[����\������B
        ACSplash splash = (ACSplash)ACFrame.getInstance().getFrameEventProcesser().createSplash("CSV�f�[�^");
        
        try{
            QP001Manager manager = new QP001Manager(getDBManager(), getTargetDate().getDate());
            result = creator.create(getDBManager(),getAffair(),getPatientData(),getClaimDate().getDate(),settings,QkanSystemInformation.getInstance().getSystemDate(),manager);
        } finally {
            // �E�F�C�e�B���O�t�H�[�����I������B
            if (splash != null) {
                splash.close();
                splash = null;
            }
        }
        
        // 2006/08/28 add begin kamitsukasa
        // �K��Ō�×{��̎����Ή�
        if(result == null){
            return null;
        }
        // 2006/08/28 add end kamitsukasa
        
        
        // CSV�����m��m�F���b�Z�[�W��\������B
        if(QkanMessageList.getInstance().QP001_CSV_COMMIT() == ACMessageBox.RESULT_OK){
            splash = (ACSplash)ACFrame.getInstance().getFrameEventProcesser().createSplash("�t���O�X�V����");
            //�u�͂��v���I�����ꂽ�ꍇ
            try{
                //�g�����U�N�V�������J�n����B
                getDBManager().beginTransaction();
                
                for(int i = 0; i < getPatientData().size(); i++){
                    VRMap map = (VRMap)getPatientData().get(i);
                    if (!"TRUE".equalsIgnoreCase(ACCastUtilities
                            .toString(VRBindPathParser.get("CHOISE", map)))){
                        continue;
                    }
                    
                    //����t���O�X�V�ΏۂƂȂ�f�[�^���擾����B
                    VRList printFlagList = getDBManager().executeQuery(getSQL_GET_UPDATE_TARGET_CLAIMSTATE(map));
                    
                    
                    for(int j = 0; j < printFlagList.size(); j++){
                        VRMap printFlag = (VRMap)printFlagList.get(j);
                        printFlag.put("PRINT",QkanClaimStateFormat.getCSVOutCode(getAffair(),printFlag.get("CLAIM_FINISH_FLAG")));
                        printFlag.put("PROVIDER_ID",QkanSystemInformation.getInstance().getLoginProviderID());
                        //��������̍X�V�p��SQL�����擾����B
                        //SQL�������s����B
                        getDBManager().executeUpdate(getSQL_GET_UPDATE_CLAIMSTATE(printFlag));
                    }
                    
                    //�t���O��CSV�ɕύX
                    map.put("PRINT",QkanClaimStateFormat.getCSVOutCode(getAffair(),map.get("PRINT")));
                    
                }
                
                //�X�V�����������ꍇ
                //�R�~�b�g�����s����B
                getDBManager().commitTransaction();
            } catch(Exception e){
                //�X�V�����s�����ꍇ
                //���[���o�b�N�����s����B
                getDBManager().rollbackTransaction();
                
                throw e;
            } finally {
                // �E�F�C�e�B���O�t�H�[�����I������B
                if (splash != null) {
                    splash.close();
                    splash = null;
                }
            }
            
        }
        
        //�e�[�u���̍ĕ`����s��
        getInfoTable().repaint();
        
        return result;
    }
    
    public static void main(String[] args) {
        VRMap param = new VRHashMap();

        /*
        Object[] selection = { "01", "02", "03", "04", "05", "06", "07"};
        Object answer = JOptionPane.showInputDialog(null, "�N�����[�h��I��", "���[�h�I��",
                JOptionPane.QUESTION_MESSAGE, null, selection, selection[6]);

        if (answer == null) {
            System.exit(0);
            return;
        }
        */ 
        
        Object answer = "07";
        //���[�h��ݒ�
        param.setData("AFFAIR", answer);
        //���O�C�����t��ݒ�(�b��I�ɖ{�����t)
        QkanSystemInformation.getInstance().setSystemDate(new Date());
        //�f�t�H���g�f�o�b�O�N��
        ACFrame.getInstance().setFrameEventProcesser(
                new QkanFrameEventProcesser());
        QkanCommon.debugInitialize();
        QkanSystemInformation.getInstance().setLoginProviderID("0000000001");
        ACFrame.debugStart(new ACAffairInfo(QP001.class.getName(), param));
    }
    /**
     * �u�e�[�u���I�����̏����v�C�x���g�ł��B
     * 
     * @param e
     *            �C�x���g���
     * @throws Exception
     *             ������O
     */
    protected void infoTableSelectionChanged(MouseEvent e) throws Exception {
        
        setButtonState();

//      if ("01".equals(getAffair())) {
//      if(getPatientData() == null) return;
//          String choise;
//          for (int i = 0; i < getPatientData().getDataSize(); i++) {
//              choise = String.valueOf(VRBindPathParser.get("DELETE",
//                  (VRLinkedHashMap) getPatientData().get(i)));
//              // �I������Ă���Ή����\
//              if ("TRUE".equalsIgnoreCase(choise)) {
//                  getDelete().setEnabled(true);
//                  return;
//              }
//          }
//          getDelete().setEnabled(false);
//
//      } else if ("02".equals(getAffair())) {
        if ("02".equals(getAffair())) {
            setPrintInfoPanel();
        } else if ("03".equals(getAffair())) {
            setPrintInfoPanel();
        } else if ("04".equals(getAffair())) {
            setPrintInfoPanel();
        } else if ("05".equals(getAffair())) {
            setPrintInfoPanel();
        } else if ("06".equals(getAffair())) {
            setPrintInfoPanel();
        }
    }

    protected void insurerNoTextFocusLost(FocusEvent e) throws Exception {
        // TODO �����������ꂽ���\�b�h�E�X�^�u
        
    }

    

    protected void infoTableColumn3CheckMenuActionPerformed(ActionEvent e) throws Exception {
        infoTableSelectionChanged(null);
        
    }

    protected void infoTableColumn4CheckMenuActionPerformed(ActionEvent e) throws Exception {
        infoTableSelectionChanged(null);
    }
    
    /**
     * ���t�Ŏ��т��\�[�g����B
     */
    private class DateComparator implements java.util.Comparator {
        public int compare(Object object1, Object object2) {
            //���t�ŕ��ёւ���N���X
            Date date1 = ACCastUtilities.toDate(((Map)object1).get("SERVICE_DATE"), null);
            Date date2 = ACCastUtilities.toDate(((Map)object2).get("SERVICE_DATE"), null);
            if(date1==null){
                if(date2==null){
                    return 0;
                }
                return -1;
            }else if(date2==null){
                return 1;
            }
            return date1.compareTo(date2);
        }
    }

    /**
     * ���p�Ҍ����������̑S�z���ȕ��S�����Z�o���܂��B
     * 
     * @param updateList �����f�[�^�Q
     * @param manager QP001Manager�i�Ǘ��N���X�j
     * @param patientState�@QP001PatientState�i���p�ҏ��Ǘ��N���X�j
     * @throws Exception ������O
     * 
     * @author Masahiko Higuchi
     * @since Ver 5.4.1
     */
    //[ID:0000435][Shin Fujihara] 2009/07 edit begin 2009�N�x�Ή�
    //���p�Ҍ��������̎d�l�ύX�ɔ����C��
    //���ύX�����̃R�����g���������ă\�[�X���ǂ��Ȃ��̂ŁA�폜���܂����B
    //�����̓\�[�X�R�[�h�Ǘ��c�[���ŎQ�Ƃ��Ă��������B
    protected void doTotalDetailPatientSelf(VRList updateList,QP001Manager manager,QP001PatientState patientState, QP001OfferCalc offerCalc) throws Exception{
        
        //���p�Ҍ����������̍쐬����
        // �R�~�b�g�A���[���o�b�N�͏�ʂ�doTotal�ōs�����ߓ����\�b�h���ł͍s�킸
        if(updateList == null){
        	return;
        }
        
        VRMap patientClaimMap = new VRHashMap();
        
        // �S�z���ȕ��S�̌v�Z
        // �v�Z���ʂ́A������patientClaimMap�ɑ}�������
        boolean isCalcSelfPay = clacPatientSelf(updateList,patientClaimMap,manager,patientState);
        
        //���p�Ҍ��������o�^�p�f�[�^�ɁA�T�[�r�X�̒񋟏��f�[�^���}�[�W����
        offerCalc.marge(getDBManager(), getTargetDate().getDate(), patientClaimMap);
        
        VRMap sqlParam = new VRHashMap();
        Date targetDate = getTargetDate().getDate();
        Date claimDate = getClaimDateUpdate().getDate();
        
        VRBindPathParser.set("PATIENT_ID", sqlParam,new Integer(patientState.getPatientId()));
        VRBindPathParser.set("TARGET_DATE", sqlParam, targetDate);
        VRBindPathParser.set("CLAIM_DATE", sqlParam, claimDate);
        VRBindPathParser.set("PROVIDER_ID", sqlParam,QkanSystemInformation.getInstance().getLoginProviderID());
        VRBindPathParser.set("CLAIM_STYLE_TYPE", sqlParam, new Integer(QkanConstants.CLAIM_STYLE_BILL_FOR_PATIENT));
        VRBindPathParser.set("CATEGORY_NO", sqlParam,QkanConstants.CATEGORY_NO_BILL_FOR_PATIENT);
        
        // CLAIM�e�[�u���Ƀf�[�^�����݂��邩(�ďW�v�ł��邩)�`�F�b�N����B
        VRList claimCheckList = getDBManager().executeQuery(getSQL_GET_NEW_CLAIM_PATIENT_DETAIL(sqlParam));
        
        int claimId = 0;
        // ���o�^�̏ꍇ�ACLAIM�e�[�u���ɐe�f�[�^���쐬����
        if (claimCheckList.isEmpty()) {
            // �o�^�p��CLAIM_ID���擾����B
            claimId = QkanCommon.getBookingNumber(getDBManager(), "CLAIM", "CLAIM_ID", 1);
            VRMap claimInsertSqlParam = new VRHashMap();
            // �����Ɏg�p�����L�[����S������
            claimInsertSqlParam.putAll(sqlParam);
            // �������ԍ�
            claimInsertSqlParam.setData("CLAIM_ID", new Integer(claimId));
            // ��ی��Ҕԍ�
            claimInsertSqlParam.setData("INSURED_ID", patientState.getInsuredId(targetDate));
            // �ی��Ҕԍ�
            claimInsertSqlParam.setData("INSURER_ID", patientState.getInsurerId(targetDate));
            // �����t���O
            claimInsertSqlParam.setData("CLAIM_FINISH_FLAG", new Integer(0));
            // CLAIM�e�[�u���Ƀf�[�^���쐬����
            getDBManager().executeUpdate(getSQL_INSERT_CLAIM(claimInsertSqlParam));
            
        }else{
            VRMap claimData = (VRMap)claimCheckList.getData(0);
            claimId = ACCastUtilities.toInt(claimData.getData("CLAIM_ID"),0);
            //CLAIM.CLAIM_FINISH_FLAG��0�ŃA�b�v�f�[�g
            sqlParam.put("PRINT", "0");
            getDBManager().executeUpdate(getSQL_GET_UPDATE_CLAIMSTATE(sqlParam));
        }
        
        // CLAIM_ID�̐ݒ�
        VRBindPathParser.set("CLAIM_ID",patientClaimMap,ACCastUtilities.toInteger(claimId));
        
        
        //[ID:0000612][Shin Fujihara] 2010/11 add begin 2010�N�x�Ή�
        //���[�h���r���ŕύX���ꂽ���Ƃ��l��
        //��U�s�v���R�[�h('00'�ȊO)���폜����
        /* FIXME [0000612]
        VRBindPathParser.set("MODE",patientClaimMap, "MULTI");
        getDBManager().executeUpdate(getSQL_GET_CLAIM_PATIENT_DETAIL_DELETE(patientClaimMap));
        */
        //[ID:0000612][Shin Fujihara] 2010/11 add end 2010�N�x�Ή�
        
        
        // ���p�Ҍ����������f�[�^�̑��݃`�F�b�N
        VRList claimPatientCheckList = getDBManager().executeQuery(getSQL_GET_CLAIM_PATIENT_TARGET_DATA_COUNT(patientClaimMap));

        if(claimPatientCheckList.isEmpty()){
            // CLAIM_PATIENT_DETAIL Insert����
            getDBManager().executeUpdate(getSQL_INSERT_CLAIM_PATIENT_DETAIL_ONLY_SELF(patientClaimMap));
            
        }else{
            // CLAIM_PATIENT_DETAIL Update����
            getDBManager().executeUpdate(getSQL_UPDATE_CLAIM_PATIENT_DETAIL_ONLY_SELF(patientClaimMap));
        }
        
        // �S�z���ȕ��S���������Ă��Ȃ���Ώ����I��
        if(!isCalcSelfPay){
        	return;
        }
        	
        // �S�z���ȕ��S���������Ă���ꍇ��
        // ��^���o�^���������s����
        VRMap fixedParam = new VRHashMap();
        VRList fixedList = new VRArrayList();
        for (int i = 1; i <= 3; i++) {
            // �S�z���ȕ��S�Ώۂ̖��̂��擾����B
            String fixedKey = ACCastUtilities.toString(
            		patientClaimMap.get("SELF_SERVICE_NO" + ACCastUtilities.toString(i))
            		);
            // null�Ƌ󔒂̏ꍇ�͖���
            if (ACTextUtilities.isNullText(fixedKey)) {
                continue;
            }
            fixedParam.setData("FIXED_FORM_ID", new Integer(1));
            fixedParam.setData("CONTENT", fixedKey);
            
            // �o�^�p��CONTENT_KEY���擾����
            fixedList = (VRList) getDBManager().executeQuery(getSQL_GET_COUNT_SELF_PAY(fixedParam));
            
            VRMap contentKeyMap = (VRMap) fixedList.getData(0);
            // �擾����������0���̏ꍇ
            if (ACCastUtilities.toInt(contentKeyMap.getData("CONTENT_SELF_PAY")) == 0) {
                fixedParam = new VRHashMap();
                // �EKEY�FFIXED_FORM_ID VALUE�F1
                fixedParam.setData("FIXED_FORM_ID", new Integer(1));
                // �o�^�Ɏg�p����CONTENT_KEY���擾���邽�߂�SQL�����擾����B
                // SQL�������s����B
                fixedList = getDBManager().executeQuery(getSQL_GET_NEW_CONTENT_KEY(fixedParam));

                contentKeyMap = (VRMap) fixedList.getData(0);
                
                // �o�^�Ɏg�p����CONTENT_SORT���擾���邽�߂�SQL�����擾����B
                // SQL�������s����B
                fixedList = getDBManager().executeQuery(getSQL_GET_NEW_CONTENT_SORT(fixedParam));
                
                VRMap contentSortMap = (VRMap) fixedList.getData(0);

                // param�����������A�ȉ���KEY/VALUE��ݒ肷��B
                // �EKEY�FTABLE_TYPE VALUE�F1
                // �EKEY�FFIXED_FORM_ID VALUE�F1
                // �EKEY�FCONTENT_KEY VALUE�F�i�擾�����V����CONTENT_KEY�j
                // �EKEY�FCONTENT VALUE�F�i�I�����j
                // �EKEY�FCONTENT_SORT VALUE�F�i�擾�����V����CONTENT_SORT�j
                fixedParam = new VRHashMap();
                fixedParam.setData("TABLE_TYPE", new Integer(1));
                fixedParam.setData("FIXED_FORM_ID", new Integer(1));
                fixedParam.setData("CONTENT_KEY", contentKeyMap.getData("NEW_CONTENT_KEY"));
                fixedParam.setData("CONTENT", fixedKey);
                fixedParam.setData("CONTENT_SORT", contentSortMap.getData("NEW_CONTENT_SORT"));

                // ��^���o�^�pSQL�����擾����B
                // SQL�������s����B
                getDBManager().executeUpdate(getSQL_INSERT_FIXED_FORM(fixedParam));
            }
        }
    }
    //[ID:0000435][Shin Fujihara] 2009/07 edit end 2009�N�x�Ή�
    
    /**
     * �S�z���ȕ��S�̌v�Z����
     * @param updateList �W�v�f�[�^�Q
     * @param patientClaimMap ���ʊi�[�v�ϐ�
     * @param manager QP001Manager�i�Ǘ��N���X�j
     * @param isDetailCalc �ȈՔŌv�Z�A�ڍהŌv�Z���ʗv�t���O
     * @param patientState ���p�ҏ��Ǘ��N���X
     * @return int �S�z���ȕ��S�ΏۃT�[�r�X��
     * 
     * @throws Exception ������O
     * @since 5.4.1 
     * @author Masahiko Higuchi
     */
    // 2008/09/03 [Masahiko Higuchi] replace - begin �S�z���ȕ��S�v�Z����Q�iV5.4.3�j ������patientState��ǉ�
    public boolean clacPatientSelf(VRList updateList,VRMap patientClaimMap,QP001Manager manager, QP001PatientState patientState)throws Exception{
    // 2008/09/03 [Masahiko Higuchi] replace - end
        // ��Œl�𐶐����Ă���
        for(int i=1;i<=3;i++){
            patientClaimMap.setData("SELF_PAY_NO" + Integer.toString(i),null);
            patientClaimMap.setData("SELF_SERVICE_NO" + Integer.toString(i),"");
        }
        
        // �S�z���ȕ��S�J�E���g�p
        int serviceCount = 1;
        
        try{
            for(int i=0;i<updateList.size();i++){
                VRMap claimMap = new VRHashMap();
                claimMap = (VRMap)updateList.getData(i);
                // 701009   �v��P�ʐ�6��
                // 701010   ���x�z�Ǘ��ΏےP�ʐ�6��
                // 701015   �P�ʐ��P��
                // 701007   �T�[�r�X��ރR�[�h
                // �W�v��񃌃R�[�h�ł���ꍇ
                if (claimMap.getData("CATEGORY_NO") != null
                        && QkanConstants.CATEGORY_NO_RECORD_TOTAL.equals(claimMap
                                .getData("CATEGORY_NO"))) {
                    // ���x�z�Ǘ��ΏےP�ʐ�
                    int gendogakuTani = ACCastUtilities.toInt(claimMap.getData("701010"),0);
                    // �v��P�ʐ�
                    int keikakuTani = ACCastUtilities.toInt(claimMap.getData("701009"),0);
                    // ���ߒP�ʐ�
                    int overTani = gendogakuTani - keikakuTani;
                    // 2008/09/03 [Masahiko Higuchi] add - begin �S�z���ȕ��S�v�Z����Q�iV5.4.3�j
                    // �T�[�r�X��ރR�[�h
                    String serviceCodeKind = ACCastUtilities.toString(claimMap
                            .getData("701007"));
                    int over30Tani = patientState.getAbandonedUnit(serviceCodeKind);
                    
                    //[ID:0000682][Shin Fujihara] add begin �y�@�����Ή��z���E���������P���Z
                    overTani += patientState.getAddSelfpay(serviceCodeKind);
                    //[ID:0000682][Shin Fujihara] add end �y�@�����Ή��z���E���������P���Z
                    
                    // 2008/09/03 [Masahiko Higuchi] add - end
                    // ���߂��Ă��Ȃ��ꍇ�͎��̃��[�v��
                    // 2008/09/03 [Masahiko Higuchi] replace - begin �S�z���ȕ��S�v�Z����Q�iV5.4.3�j
                    // 30��������r���ɍl������
                    if(overTani + over30Tani <= 0){
                    // 2008/09/03 [Masahiko Higuchi] replace - end
                        continue;
                    }
                    // 2008/09/03 [Masahiko Higuchi] del - begin �S�z���ȕ��S�v�Z����Q�iV5.4.3�j
                    /*
                    // �P�ʐ������O�̑��z
                    int gendogakuTotal = (int) Math
                    .floor((double) (gendogakuTani * get_701015Multiplies100(ACCastUtilities
                            .toDouble(claimMap.getData("701015")))) / 100d);
                    // ������P�ʐ��ł̑��z
                    int tyoseiTotal = (int) Math
                    .floor((double) (keikakuTani * get_701015Multiplies100(ACCastUtilities
                            .toDouble(claimMap.getData("701015")))) / 100d);
                    // �����O�̑��z���璲����̋��z���������l�𗘗p�҂̑S�z���ȕ��S�Ƃ���B
                    int zengakuJikofutan = gendogakuTotal - tyoseiTotal;
                     */
                    // 2008/09/03 [Masahiko Higuchi] del - end
                    // 2008/09/03 [Masahiko Higuchi] add - begin �S�z���ȕ��S�v�Z����Q�iV5.4.3�j
                    // ���ߕ��P�ʐ� * �P�ʐ��P���i�~�����؎̂āj
                    int zengakuJikofutan = (int) Math
                            .floor((double) (overTani * get_701015Multiplies100(ACCastUtilities
                                    .toDouble(claimMap.getData("701015")))) / 100d);
                    // 30�����̋��z�͌ʌv�Z
                    int over30ZengakuJikofutan = (int) Math
                            .floor((double) (over30Tani * get_701015Multiplies100(ACCastUtilities
                                    .toDouble(claimMap.getData("701015")))) / 100d);
                    // ���ߕ��̋��z + 30�����̋��z�����Z����
                    zengakuJikofutan += over30ZengakuJikofutan;
                    // 2008/09/03 [Masahiko Higuchi] add - end
                    
                    // �S�z���ȕ��S��3�𒴂����ꍇ�̑Ή��i�}�[�W�����j
                    if(serviceCount >= 4){
                        // ���v����
                        zengakuJikofutan = ACCastUtilities
                                .toInt(patientClaimMap.getData("SELF_PAY_NO3"))
                                + zengakuJikofutan;
                        patientClaimMap.setData("SELF_SERVICE_NO3","���̑�");
                        // ���̑��Ƃ��č��v�l�ɕύX����
                        patientClaimMap.setData("SELF_PAY_NO3",ACCastUtilities.toString(zengakuJikofutan));
                    }else{
                        // ���ʏ폈��
                        // �T�[�r�X��ރR�[�h
                        // 2008/09/03 [Masahiko Higuchi] del - begin �S�z���ȕ��S�v�Z����Q�iV5.4.3�j
                        //String serviceCodeKind = ACCastUtilities.toString(claimMap
                        //        .getData("701007"));
                        // 2008/09/03 [Masahiko Higuchi] del - end
                        // �T�[�r�X��ޖ��̂ɖ|�󂵂Ċi�[
                        patientClaimMap.setData("SELF_SERVICE_NO"
                                + ACCastUtilities.toString(serviceCount), manager
                                .getServiceName(serviceCodeKind));
                        // �S�z���ȕ��S���i�[
                        patientClaimMap.setData("SELF_PAY_NO"
                                + ACCastUtilities.toString(serviceCount),ACCastUtilities.toString(zengakuJikofutan));
                    }
                    // �S�z���ȕ��S���ڃJ�E���g�A�b�v
                    serviceCount++;
                }
            }
        }catch(Exception e){
            e.printStackTrace();
            return false;
            
        }
        
        // �S�z���ȕ��S����ԋp
        if(serviceCount >= 2){
            return true;
        }else{
            return false;
        }
    }
    
    
    //2009/1/6 fujihara add start
    private VRList getSortedTableList(){
    	VRList result = new VRArrayList();
    	VRList targetList = getPatientData();
    	
    	jp.nichicom.vr.component.table.VRSortableTableModel sorterModel;
    	//�\�[�^�ł��邩�`�F�b�N����
    	if(getInfoTable().getModel() instanceof jp.nichicom.vr.component.table.VRSortableTableModel){
    		result = new VRArrayList();
    		sorterModel = (jp.nichicom.vr.component.table.VRSortableTableModel)getInfoTable().getModel();
    		for(int j=0; j < targetList.getDataSize(); j++){
    			//�\�[�^�[�𗘗p���ă��f�������ʏ�̏��Ƀf�[�^�i�[���Ȃ���
    			int row = sorterModel.getTranslateIndex(j);
    			//�\�[�g������בւ���
    			result.add(getPatientTableModel().getData(row));
    		}
    	}
    	return result;
    }
    //2009/1/6 fujihara add end
    
    // [ID:0000614][Shin Fujihara] 2010/11 add begin 2010�N�x�Ή�
    // �ꗗ�������
	protected void printListActionPerformed(ActionEvent e) throws Exception {

		// ���̓`�F�b�N���s���B
        if (!checkSelect("�I��", "���[�����")) {
            return;
        }
        
        // ����f�[�^�쐬
        VRMap printParam = new VRHashMap();
        
        // �t�H�[�}�b�g�ς݃V�X�e�����t��ݒ�
        //VRBindPathParser.set("DATE", printParam, VRDateParser.format(QkanSystemInformation.getInstance().getSystemDate(), "ggge�NMM��dd��"));
        VRBindPathParser.set("DATE", printParam, VRDateParser.format(new Date(), "ggge�NMM��dd��"));
        
        //�ǉ��v�]�ŁA��ʏ�ɕ\�����Ă��鍇�v�P�ʐ�������
        //���v�P�ʐ�
        VRBindPathParser.set("SERVICE_UNIT", printParam, getTotalDenominationText().getText());
        //���v���z
        VRBindPathParser.set("SERVICE_TOTAL", printParam, getTotalMoneyText().getText());
        //�ی������z
        VRBindPathParser.set("HOKEN", printParam, getDemandMoneyInsuranceMoneyText().getText());
        //����
        VRBindPathParser.set("KOUHI", printParam, getTotalDenominationPublicExpenseMoneyText().getText());
        //���p��
        VRBindPathParser.set("RIYOUSYA", printParam, getDemandMoneyPatientMoneyText().getText());
        
        int service_count = 0;
        
        // �\�����Ń��X�g�����
        VRList sortedPatientList = getSortedTableList();
        VRList list = new VRArrayList();
        VRMap row = null;
        
        for (int i = 0; i < sortedPatientList.size(); i++) {
        	row = (VRMap)sortedPatientList.get(i);
        	
        	// �`�F�b�N����Ă���s�ł��邩�m�F
        	if(ACCastUtilities.toBoolean(VRBindPathParser.get("CHOISE", row))){
        		list.add(row);
        		service_count++;
        	}
        }
        
        VRBindPathParser.set("LIST", printParam, list);
        
        //���v����
        VRBindPathParser.set("SERVICE_COUNT", printParam, NumberFormat.getInstance().format(service_count));
        
        
        // �����
        // �������B
        QP001P300 qp001p083 = new QP001P300();
        ACChotarouXMLWriter writer = new ACChotarouXMLWriter();
        
        // ����J�n��錾
        writer.beginPrintEdit();
        
        // ����N���X�֏�����n���B
        qp001p083.doPrint(writer, printParam);
        
        // ����I����錾
        writer.endPrintEdit();

        // PDF�t�@�C���𐶐����ĊJ���B
        ACChotarouXMLUtilities.openPDF(writer);
	}
	// [ID:0000614][Shin Fujihara] 2010/11 add end 2010�N�x�Ή�
	
	
	// [ID:0000612][Shin Fujihara] 2010/11 add begin 2010�N�x�Ή�
    protected void doTotalDetailPatientSelfService(VRList updateList,QP001Manager manager,QP001PatientState patientState, QP001OfferCalc offerCalc) throws Exception{
        
        //���p�Ҍ����������̍쐬����
        if(updateList == null){
        	return;
        }
        
        //CLAIM_PATIENT_DETAIL�ւ̓o�^�Ɏg�p����g���擾
        //�����ɒ񋟓����̏��͐ݒ�ς݂̏�ԁB���ȕ��S�z��ݒ肷��΂悢�B
        VRList claimDetailList = offerCalc.getOfferServiceList(getDBManager(), getTargetDate().getDate());
        
        //�쐬��̃��R�[�h�ɑ΂��A�S�z���ȕ��S�z���Z�o���ݒ肷��B
        VRList updateWordList = clacPatientSelfService(updateList, claimDetailList, manager, patientState);
        
        
        
        VRMap sqlParam = new VRHashMap();
        Date targetDate = getTargetDate().getDate();
        Date claimDate = getClaimDateUpdate().getDate();
        
        sqlParam.put("PATIENT_ID", new Integer(patientState.getPatientId()));
        sqlParam.put("TARGET_DATE", targetDate);
        sqlParam.put("CLAIM_DATE", claimDate);
        sqlParam.put("PROVIDER_ID", QkanSystemInformation.getInstance().getLoginProviderID());
        sqlParam.put("CLAIM_STYLE_TYPE", new Integer(QkanConstants.CLAIM_STYLE_BILL_FOR_PATIENT));
        sqlParam.put("CATEGORY_NO", QkanConstants.CATEGORY_NO_BILL_FOR_PATIENT);
        
        // CLAIM�e�[�u���Ƀf�[�^�����݂��邩(�ďW�v�ł��邩)�`�F�b�N����B
        VRList claimCheckList = getDBManager().executeQuery(getSQL_GET_NEW_CLAIM_PATIENT_DETAIL(sqlParam));
        int claimId = 0;
        // ���o�^�̏ꍇ�ACLAIM�e�[�u���ɐe�f�[�^���쐬����
        if (claimCheckList.isEmpty()) {
            // �o�^�p��CLAIM_ID���擾����B
            claimId = QkanCommon.getBookingNumber(getDBManager(), "CLAIM", "CLAIM_ID", 1);
            // �������ԍ�
            sqlParam.put("CLAIM_ID", new Integer(claimId));
            // ��ی��Ҕԍ�
            sqlParam.put("INSURED_ID", patientState.getInsuredId(targetDate));
            // �ی��Ҕԍ�
            sqlParam.put("INSURER_ID", patientState.getInsurerId(targetDate));
            // �����t���O
            sqlParam.put("CLAIM_FINISH_FLAG", new Integer(0));
            // CLAIM�e�[�u���Ƀf�[�^���쐬����
            getDBManager().executeUpdate(getSQL_INSERT_CLAIM(sqlParam));
            
        }else{
            VRMap claimData = (VRMap)claimCheckList.getData(0);
            claimId = ACCastUtilities.toInt(claimData.getData("CLAIM_ID"), 0);
            //CLAIM.CLAIM_FINISH_FLAG��0�ŃA�b�v�f�[�g
            sqlParam.put("CLAIM_ID", new Integer(claimId));
            sqlParam.put("PRINT", "0");
            getDBManager().executeUpdate(getSQL_GET_UPDATE_CLAIMSTATE(sqlParam));
        }
        
        
        //��U�A�s�v���R�[�h�̍폜
        sqlParam.put("MODE", "SINGLE");
        getDBManager().executeUpdate(getSQL_GET_CLAIM_PATIENT_DETAIL_DELETE(sqlParam));
        
        //�o�^�ςݏ��̎擾
        VRMap claimPatientCheckMap = new VRHashMap();
        VRList list = getDBManager().executeQuery(getSQL_GET_CLAIM_PATIENT_TARGET_DATA_KIND(sqlParam));
        ACBindUtilities.setMapFromArray(list, claimPatientCheckMap, "SERVICE_CODE_KIND");
        
        // ��s���A�b�v�f�[�g�E�C���T�[�g�𔻒�
        for (int i = 0; i < claimDetailList.size(); i++) {
        	VRMap map = (VRMap)claimDetailList.get(i);
        	map.put("CLAIM_ID", new Integer(claimId));
        	
        	// UPDATE
        	if (claimPatientCheckMap.containsKey(map.get("SERVICE_CODE_KIND"))) {
                // CLAIM_PATIENT_DETAIL Update����
                getDBManager().executeUpdate(getSQL_UPDATE_CLAIM_PATIENT_DETAIL_ONLY_SELF(map));
        	
        	// INSERT
        	} else {
                // CLAIM_PATIENT_DETAIL Insert����
                getDBManager().executeUpdate(getSQL_INSERT_CLAIM_PATIENT_DETAIL_ONLY_SELF(map));
                
        	}
        }
        
        // �S�z���ȕ��S�Ƃ��ēo�^�����������A��^���e�[�u���ɓo�^
        VRMap fixedParam = new VRHashMap();
        VRList fixedList = new VRArrayList();
        
        fixedParam.put("FIXED_FORM_ID", new Integer(1));
        fixedParam.setData("TABLE_TYPE", new Integer(1));
        
        for (int i = 0; i < updateWordList.size(); i++) {
        	
            fixedParam.put("CONTENT", updateWordList.get(i));
            // �o�^�p��CONTENT_KEY���擾����
            fixedList = (VRList) getDBManager().executeQuery(getSQL_GET_COUNT_SELF_PAY(fixedParam));
            
            VRMap contentKeyMap = (VRMap) fixedList.getData(0);
            // �擾����������0���ł͏ꍇ�́A���ɓo�^�ς�
            if (ACCastUtilities.toInt(contentKeyMap.getData("CONTENT_SELF_PAY")) != 0) {
            	continue;
            }
            
            // �o�^�Ɏg�p����CONTENT_KEY���擾���邽�߂�SQL�����擾����B
            // SQL�������s����B
            fixedList = getDBManager().executeQuery(getSQL_GET_NEW_CONTENT_KEY(fixedParam));
            contentKeyMap = (VRMap) fixedList.getData(0);
            
            // �o�^�Ɏg�p����CONTENT_SORT���擾���邽�߂�SQL�����擾����B
            // SQL�������s����B
            fixedList = getDBManager().executeQuery(getSQL_GET_NEW_CONTENT_SORT(fixedParam));
            VRMap contentSortMap = (VRMap) fixedList.getData(0);
            
            fixedParam.setData("CONTENT_KEY", contentKeyMap.getData("NEW_CONTENT_KEY"));
            fixedParam.setData("CONTENT_SORT", contentSortMap.getData("NEW_CONTENT_SORT"));

            // ��^���o�^�pSQL�����擾����B
            // SQL�������s����B
            getDBManager().executeUpdate(getSQL_INSERT_FIXED_FORM(fixedParam));
        }
    }
    
    
    public VRList clacPatientSelfService(
    		VRList updateList,
    		VRList claimDetailList,
    		QP001Manager manager,
    		QP001PatientState patientState) throws Exception{
    	
    	
    	
        // �S�z���ȕ��S�Z��t���O
        VRList updateWordList = new VRArrayList();
    	
        lbl:for(int i=0;i<updateList.size();i++){
            VRMap claimMap = (VRMap)updateList.getData(i);
            /*
             701009   �v��P�ʐ�6��
             701010   ���x�z�Ǘ��ΏےP�ʐ�6��
             701015   �P�ʐ��P��
             701007   �T�[�r�X��ރR�[�h
            */
            
            // �W�v��񃌃R�[�h�ȊO�ł���΁A�������s�Ȃ�Ȃ�
            if (!QkanConstants.CATEGORY_NO_RECORD_TOTAL.equals(claimMap.getData("CATEGORY_NO"))) {
            	continue;
            }
            
            // ���x�z�Ǘ��ΏےP�ʐ�
            int gendogakuTani = ACCastUtilities.toInt(claimMap.getData("701010"), 0);
            // �v��P�ʐ�
            int keikakuTani = ACCastUtilities.toInt(claimMap.getData("701009"), 0);
            // ���ߒP�ʐ�
            int overTani = gendogakuTani - keikakuTani;
            
            // �T�[�r�X��ރR�[�h
            String serviceCodeKind = ACCastUtilities.toString(claimMap.getData("701007"));
            int over30Tani = patientState.getAbandonedUnit(serviceCodeKind);
            
            //[ID:0000682][Shin Fujihara] add begin �y�@�����Ή��z���E���������P���Z
            overTani += patientState.getAddSelfpay(serviceCodeKind);
            //[ID:0000682][Shin Fujihara] add end �y�@�����Ή��z���E���������P���Z
            
            // 30��������r���ɍl������
            if(overTani + over30Tani <= 0){
                continue;
            }
            
            double _701015 = get_701015Multiplies100(ACCastUtilities.toDouble(claimMap.getData("701015")));
            // ���ߕ��P�ʐ� * �P�ʐ��P���i�~�����؎̂āj
            int zengakuJikofutan = (int) Math.floor((double) (overTani * _701015) / 100d);
            // 30�����̋��z�͌ʌv�Z
            int over30ZengakuJikofutan = (int) Math.floor((double) (over30Tani * _701015) / 100d);
            // ���ߕ��̋��z + 30�����̋��z�����Z����
            zengakuJikofutan += over30ZengakuJikofutan;
            
            
            VRMap targetMap = null;
            //�ΏۂƂȂ�}�b�v��T��
            for (int j = 0; j < claimDetailList.size(); j++) {
            	targetMap = (VRMap)claimDetailList.get(j);
            	if (serviceCodeKind.equals(targetMap.get("SERVICE_CODE_KIND")) ){
            		break;
            	}
            	targetMap = null;
            }
            
            if (targetMap == null) {
            	continue;
            }
            
            //�l��ݒ�ł���ӏ���T��
            for (int j = 1; j <= 3; j++) {
            	if (targetMap.get("SELF_SERVICE_NO" + j) == null) {
            		targetMap.put("SELF_SERVICE_NO" + j, manager.getServiceName(serviceCodeKind));
            		targetMap.put("SELF_PAY_NO" + j, String.valueOf(zengakuJikofutan));
            		
            		updateWordList.add(manager.getServiceName(serviceCodeKind));
            		continue lbl;
            	}
            }
            
            //���̂����̑��ɕύX
            targetMap.setData("SELF_SERVICE_NO3", "���̑�");
            int etcSelfPay = ACCastUtilities.toInt(targetMap.get("SELF_PAY_NO3"), 0);
            targetMap.put("SELF_PAY_NO3", String.valueOf(etcSelfPay + zengakuJikofutan));
        }
        
        // �S�z���ȕ��S�ɓo�^�����������X�g�����^�[��
        return updateWordList;
    }
	// [ID:0000612][Shin Fujihara] 2010/11 add end 2010�N�x�Ή�
    
    // [ID:0000629][Shin Fujihara] 2011/02 add start 2010�N�x�Ή�
    //�����N����ύX����(C)�`�F�b�N�ύX���̃C�x���g
	protected void claimDateChangePermitPerformed(ActionEvent e) throws Exception {
		if (getClaimDateUpdateChangePermit().isSelected()) {
			setState_CLAIM_DATE_ENABLE();
		} else {
			setState_CLAIM_DATE_DISABLE();
		}
	}
	// [ID:0000629][Shin Fujihara] 2011/02 add end 2010�N�x�Ή�
	
}
