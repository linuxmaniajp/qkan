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
 * �쐬��: 2006/02/15  ���{�R���s���[�^�[������� �����@�L �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �������o�� (P)
 * �v���Z�X ���p�Ҍ������ (007)
 * �v���O���� ���p�Ҍ�����������ݒ� (QP007)
 *
 *****************************************************************
 */

package jp.or.med.orca.qkan.affair.qp.qp007;

import java.awt.event.*;
import java.awt.im.InputSubset;
import java.util.HashSet;
import java.util.Set;

import javax.swing.event.*;
import javax.swing.table.TableCellEditor;

import jp.nichicom.ac.bind.ACBindUtilities;
import jp.nichicom.ac.component.ACTextField;
import jp.nichicom.ac.component.table.ACTableCellViewer;
import jp.nichicom.ac.component.table.ACTableCellViewerCustomCell;
import jp.nichicom.ac.core.*;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.util.adapter.ACTableModelAdapter;
import jp.nichicom.vr.util.*;
import jp.or.med.orca.qkan.*;
import jp.or.med.orca.qkan.affair.*;
import jp.or.med.orca.qkan.text.QkanServiceKindNameFormat;

/**
 * ���p�Ҍ�����������ݒ�(QP007)
 */
public class QP007 extends QP007Event {
    
    //�ݒ�l�ԋp�p
    VRMap result = null;
    
    /**
     * �R���X�g���N�^�ł��B
     */
    public QP007() {
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
        VRMap affairInfoMap = QkanCommon.getAffairInfo(getDBManager(), "QP007");
        setTitle((String) affairInfoMap.get("WINDOW_TITLE"));
        
        VRMap settings = new VRHashMap();
        settings.put("TARGET_RADIO",new Integer(1));

        // �ݒ�t�@�C����ǂݍ��݁A��ʂ̏�����Ԃ�ݒ肷��B
        if (ACFrame.getInstance().hasProperty("Claim/TargetRadio")) {
            String targetRadio = getProperty("Claim/TargetRadio");
            //�ݒ�t�@�C����Claim-TargetRadio��1�̏ꍇ
            if("1".equals(targetRadio)){
                //�u���������W�I�{�^��(patientBillSetupPapersRadioItem1)�v�Ƀ`�F�b�N��t����B
                settings.put("TARGET_RADIO",new Integer(1));
            //�ݒ�t�@�C����Claim-TargetRadio��2�̏ꍇ
            } else if("2".equals(targetRadio)){
                //�u�̎������W�I�{�^��(patientBillSetupPapersRadioItem2)�v�Ƀ`�F�b�N��t����B
                settings.put("TARGET_RADIO",new Integer(2));
            //�ݒ�t�@�C����Claim-TargetRadio��3�̏ꍇ
            } else if("3".equals(targetRadio)){
                //�u�������E�̎������W�I�{�^��(patientBillSetupPapersRadioItem3)�v�Ƀ`�F�b�N��t����B
                settings.put("TARGET_RADIO",new Integer(3));
            }
        }
        
        if (ACFrame.getInstance().hasProperty("Claim/TotalCheck")) {
            //�ݒ�t�@�C����Claim-TotalCheck��0�̏ꍇ
            //�u���v�E���v���������(patientBillSetupBillAndReceiptDate)�v�̃`�F�b�N���͂����B
            //�ݒ�t�@�C����Claim-TotalCheck��1�̏ꍇ
            //�u���v�E���v���������(patientBillSetupBillAndReceiptDate)�v�̃`�F�b�N��t����B
            settings.put("TOTAL_CHECK",getProperty("Claim/TotalCheck"));
        } else {
            settings.put("TOTAL_CHECK",new Integer(0));
        }
        
        if (ACFrame.getInstance().hasProperty("Claim/PrintCheck")) {
            //�ݒ�t�@�C����Claim-PrintCheck��0�̏ꍇ
            //�u�������ɐU����̘g���������(patientBillSetupUnderPrintOn)�v�̃`�F�b�N���͂����B
            //�ݒ�t�@�C����Claim-PrintCheck��1�̏ꍇ
            //�u�������ɐU����̘g���������(patientBillSetupUnderPrintOn)�v�̃`�F�b�N��t����B
            settings.put("PRINT_CHECK",getProperty("Claim/PrintCheck"));
        } else {
            settings.put("PRINT_CHECK",new Integer(0));
        }
        
        if (ACFrame.getInstance().hasProperty("Claim/StyleCheck")) {
            //�ݒ�t�@�C����Claim-StyleCheck��0�̏ꍇ
            //�u��Ô�T���Ή��łŏo�͂���(patientBillSetupMedicalTreatmentOn)�v�̃`�F�b�N���͂����B
            //�ݒ�t�@�C����Claim-StyleCheck��1�̏ꍇ
            //�u��Ô�T���Ή��łŏo�͂���(patientBillSetupMedicalTreatmentOn)�v�̃`�F�b�N��t����B
            settings.put("STYLE_CHECK",getProperty("Claim/StyleCheck"));
        } else {
            settings.put("STYLE_CHECK",new Integer(0));
        }
        
        // [���p�Ҍ����������E�̎����@�ڍהőΉ�] fujihara add start
        if (ACFrame.getInstance().hasProperty("Claim/DetailsCheck")) {
			//�ݒ�t�@�C����Claim-DetailsCheck��0�̏ꍇ	
			//�u�ڍהłň������(patientBillSetupDetailsPrintOn)�v�̃`�F�b�N���͂����B
			//�ݒ�t�@�C����Claim-DetailsCheck��0�̏ꍇ	
			//�u�ڍהłň������(patientBillSetupDetailsPrintOn)�v�̃`�F�b�N��t����B
            settings.put("DETAILS_CHECK",getProperty("Claim/DetailsCheck"));
        } else {
            settings.put("DETAILS_CHECK",new Integer(0));
        }
        // [���p�Ҍ����������E�̎����@�ڍהőΉ�] fujihara add end
        
        
        //[ID:0000612][Shin Fujihara] 2010/11 add begin 2010�N�x�Ή�
        //�u�T�[�r�X���Ƃɐ������E�̎������o�͂���v�̃`�F�b�N���t���Ă���ꍇ�A
        //�T�[�r�X���̈ꗗ�̃O���b�h��\������
        if (ACFrame.getInstance().hasProperty("PrintConfig/ServiceByReceipt")
        	&& ACCastUtilities.toInt(getProperty("PrintConfig/ServiceByReceipt")) == 1) {
        	//�T�[�r�X����-���Ə����̃O���b�h��\��
            setState_BY_RECEIPT_ON();
            
            //�󎚂Ɏg�p���鎖�Ə����̂��擾���A�O���b�h�ɕ\������
            getProviderNames();
            
            //IME���[�h���������͂�
            VRList list = new VRArrayList();
            for (int i = 0; i < getProviderNameList().size(); i++) {
                ACTextField cellTextField = new ACTextField();
                ACTableCellViewerCustomCell cell = new ACTableCellViewerCustomCell();
                cell.setEditor(cellTextField);
                cellTextField.setIMEMode(InputSubset.KANJI);
                cellTextField.setMaxLength(100);
                cell.setEditable(true);
                list.add(cell);
            }
            getProviderNameColumn().setCustomCells(list);

        } else {
        	setState_BY_RECEIPT_OFF();
        }
        
        //��ʔz�u���œK��
        pack();
        //[ID:0000612][Shin Fujihara] 2010/11 add end 2010�N�x�Ή�
        
        
        // �u���������t(patientBillSetupBillDate)�v�Ƀ��O�C�����t��ݒ肷��B
        settings.put("TARGET_DATE",QkanSystemInformation.getInstance().getSystemDate());
        // �u�̎������t(patientBillSetupReceiptDate)�v�Ƀ��O�C�����t��ݒ肷��B
        settings.put("GET_DATE",QkanSystemInformation.getInstance().getSystemDate());
        getContents().setSource(settings);
        getContents().bindSource();
    }

    // �R���|�[�l���g�C�x���g

    /**
     * �u�������Enabled�ύX�v�C�x���g�ł��B
     * 
     * @param e
     *            �C�x���g���
     * @throws Exception
     *             ������O
     */
    protected void patientBillSetupPapersRadioSelectionChanged(
            ListSelectionEvent e) throws Exception {
        
        //������I�v�V�����`�F�b�N�̕ύX����
        switch(getPatientBillSetupPapersRadio().getSelectedIndex()){
            //���������I������Ă���ꍇ
            case 1:
                //�u��Ô�T���Ή��łŏo��(patientBillSetupMedicalTreatmentOn)�v�̃`�F�b�N���͂����B
                getPatientBillSetupMedicalTreatmentOn().setValue(0);
                // ���������W�I�{�^���N���b�N���̉�ʐݒ���s���B
                setState_RADIO_1();
                break;
            //�̎������I������Ă���ꍇ
            case 2:
                //�u�������ɐU����̘g���������(patientBillSetupUnderPrintOn)�v�̃`�F�b�N���͂����B
                getPatientBillSetupUnderPrintOn().setValue(0);
                // �̎������W�I�{�^���N���b�N���̉�ʐݒ���s���B
                setState_RADIO_2();
                break;
                
            //�������E�̎������I������Ă���ꍇ
            case 3:
                // �������E�̎������W�I�{�^���N���b�N���̉�ʐݒ���s���B
                setState_RADIO_3();
                break;
        }
    }

    /**
     * �u����������̏����v�C�x���g�ł��B
     * 
     * @param e
     *            �C�x���g���
     * @throws Exception
     *             ������O
     */
    protected void printActionPerformed(ActionEvent e) throws Exception {
        VRMap settings = new VRHashMap();
        // contents�̃o�C���h�\�[�X�Ƃ���settings���w�肷��B
        getContents().setSource(settings);
        // ��ʂ̏���settings�Ɋi�[����B
        getContents().applySource();
        
        
        // ���ݑI������Ă���l��ݒ�t�@�C���ɕۑ�����B
        // �u���������W�I�{�^��(patientBillSetupPapersRadioItem1)�v�Ƀ`�F�b�N���t���Ă���ꍇ�B
        // �ݒ�t�@�C����Claim-TargetRadio��1��ݒ肷��B
        // �u�̎������W�I�{�^��(patientBillSetupPapersRadioItem2)�v�Ƀ`�F�b�N���t���Ă���ꍇ�B
        // �ݒ�t�@�C����Claim-TargetRadio��2��ݒ肷��B
        // �u�������E�̎������W�I�{�^��(patientBillSetupPapersRadioItem3)�v�Ƀ`�F�b�N���t���Ă���ꍇ�B
        // �ݒ�t�@�C����Claim-TargetRadio��3��ݒ肷��B
        setProperty("Claim/TargetRadio", String.valueOf(settings.getData("TARGET_RADIO")));
        
        setProperty("Claim/TotalCheck",String.valueOf(settings.getData("TOTAL_CHECK")));
        
        // �u�������ɐU����̘g���������(patientBillSetupUnderPrintOn)�v���`�F�b�N����Ă��Ȃ��ꍇ�B
        // �ݒ�t�@�C����Claim-PrintCheck��0��ݒ肷��B
        // �u�������ɐU����̘g���������(patientBillSetupUnderPrintOn)�v���`�F�b�N����Ă���ꍇ�B
        // �ݒ�t�@�C����Claim-PrintCheck��1��ݒ肷��B
        setProperty("Claim/PrintCheck", String.valueOf(settings.getData("PRINT_CHECK")));
        
        // �u��Ô�T���Ή��łŏo�͂���(patientBillSetupMedicalTreatmentOn)�v���`�F�b�N����Ă��Ȃ��ꍇ�B
        // �ݒ�t�@�C����Claim-StyleCheck��0��ݒ肷��B
        // �u��Ô�T���Ή��łŏo�͂���(patientBillSetupMedicalTreatmentOn)�v���`�F�b�N����Ă���ꍇ�B
        // �ݒ�t�@�C����Claim-StyleCheck��1��ݒ肷��B
        setProperty("Claim/StyleCheck", String.valueOf(settings.getData("STYLE_CHECK")));
        
        // [���p�Ҍ����������E�̎����@�ڍהőΉ�] fujihara add start
        //�u�ڍהłň������(patientBillSetupDetailsPrintOn)�v���`�F�b�N����Ă��Ȃ��ꍇ�B	
        //�ݒ�t�@�C����Claim-DetailsCheck��0�ɐݒ肷��B
        //�u�ڍהłň������(patientBillSetupDetailsPrintOn)�v���`�F�b�N����Ă���ꍇ�B	
        //�ݒ�t�@�C����Claim-DetailsCheck��1�ɐݒ肷��B
        setProperty("Claim/DetailsCheck", String.valueOf(settings.getData("DETAILS_CHECK")));
        // [���p�Ҍ����������E�̎����@�ڍהőΉ�] fujihara add end
        
        saveProperty();
        
        // ���_�C�A���O�Ăяo�����ɁA�u����Ώہv�u���������t�v�u�̎������t�v�u���v�E���v���������v�u�������ɐU����̘g���������v
        // �u��Ô�T���Ή��łŏo�́v�ɐݒ肳�ꂽ�l��Ԃ��A�_�C�A���O�����B
        
        result = settings;
        result.put("PRINT","TRUE");
        
        //[ID:0000612][Shin Fujihara] 2010/11 add begin 2010�N�x�Ή�
        //�ύX���ꂽ���Ə����̂̕ۑ�����
        if (getTablePanel().isVisible()) {
	        saveProviderNames();
	        result.put("PROVIDER_NAMES",getProviderNameList());
        }
        //[ID:0000612][Shin Fujihara] 2010/11 add end 2010�N�x�Ή�
        
        //�E�C���h�E�����B
        dispose();
    }

    /**
     * �u���鉟�����̏����v�C�x���g�ł��B
     * 
     * @param e
     *            �C�x���g���
     * @throws Exception
     *             ������O
     */
    protected void closeActionPerformed(ActionEvent e) throws Exception {
        result = null;
        // ���_�C�A���O�Ăяo�����ɒl�͕Ԃ����A�_�C�A���O�����B
        dispose();
    }
    
    public VRMap getResult() throws Exception {
        return result;
    }

    public static void main(String[] args) {
        // �f�t�H���g�f�o�b�O�N��
        ACFrame.getInstance().setFrameEventProcesser(
                new QkanFrameEventProcesser());
        QkanCommon.debugInitialize();
        VRMap param = new VRHashMap();
        //param�ɓn��p�����^���l�߂Ď��s���邱�ƂŁA�ȈՃf�o�b�O���\�ł��B
        ACFrame.debugStart(new ACAffairInfo(QP007.class.getName(), param));
    }

    
    //[ID:0000612][Shin Fujihara] 2010/11 add begin 2010�N�x�Ή�
	public void getProviderNames() throws Exception {
		
		// ���O�C�����Ə����̂��擾
		String loginProviderName = "";
        VRList providerData = QkanCommon.getProviderInfo(getDBManager(), QkanSystemInformation.getInstance().getLoginProviderID());
        if (!providerData.isEmpty()) {
        	loginProviderName = ACCastUtilities.toString(((VRMap)providerData.get(0)).get("PROVIDER_NAME"), "");
        }
        
		
        // �񋟂��Ă���T�[�r�X�̈ꗗ���擾
		VRList providerServiceList = QkanCommon.getProviderServiceDetail(getDBManager(), QkanSystemInformation.getInstance().getLoginProviderID());
		
		// �T�[�r�X���̂̈ꗗ���擾
		VRMap serviceMap = QkanCommon.getMasterService(getDBManager());
		
		// �O�������Ɏg�p�������Ə����̂̏����擾
		VRMap sqlParam = new VRHashMap();
		sqlParam.put("PROVIDER_ID", QkanSystemInformation.getInstance().getLoginProviderID());
		VRMap prePrintProviderNames = new VRHashMap();
		ACBindUtilities.setMapFromArray(
				getDBManager().executeQuery(getSQL_GET_FIXED_FORM(sqlParam)),
				prePrintProviderNames,
				"CONTENT_KEY");
		
		// FIXED_FORM_ID��ޔ����Ă���
		if (prePrintProviderNames.isEmpty()) { 
			setProviderFixedFormId(0);
		} else {
			setProviderFixedFormId(ACCastUtilities.toInt(((VRMap)prePrintProviderNames.getData(0)).get("FIXED_FORM_ID"), 0));
		}
		
		
		Set offerServiceKind = new HashSet();
		VRList showList = new VRArrayList();
		
		for (int i = 0; i < providerServiceList.size(); i++) {

			VRMap provider = (VRMap)providerServiceList.get(i);
			VRMap master = (VRMap)serviceMap.get(provider.get("SYSTEM_SERVICE_KIND_DETAIL"));
			
			//�}�X�^�ɃT�[�r�X��ރR�[�h���ݒ肳��Ă��Ȃ��ꍇ�́A�ݒ�L�����Z��
			if (master.get("SERVICE_CODE_KIND") == null) {
				continue;
			}
			
			//���Ƀ��X�g�ɒǉ��ς݂̃T�[�r�X�̏ꍇ�̓L�����Z��
			if (offerServiceKind.contains(master.get("SERVICE_CODE_KIND"))) {
				continue;
			}
			
			//�f�[�^�ɒǉ�
			VRMap row = new VRHashMap();
			row.put("SERVICE_CODE_KIND", new Integer(ACCastUtilities.toInt(master.get("SERVICE_CODE_KIND"), 0) + 1000));
			
			// prePrintProviderNames�̓��e���m�F
			Integer kind = ACCastUtilities.toInteger(master.get("SERVICE_CODE_KIND"), 0);
			if (prePrintProviderNames.containsKey(kind)) {
				VRMap t = (VRMap)prePrintProviderNames.get(kind);
				row.put("PROVIDER_NAME", t.get("CONTENT"));
				prePrintProviderNames.remove(kind);
			} else {
				row.put("PROVIDER_NAME", loginProviderName);
			}
			
			
			showList.add(row);
			
			offerServiceKind.add(master.get("SERVICE_CODE_KIND"));
		}
		
		// prePrintProviderNames�Ɏc���Ă���f�[�^��ǉ�
		// �i�ȑO�񋟂��Ă������A���݂͒񋟂��Ă��Ȃ��T�[�r�X�j
		for (int i = 0; i < prePrintProviderNames.size(); i++) {
			VRMap row = new VRHashMap();
			VRMap t = (VRMap)prePrintProviderNames.getData(i);
			row.put("SERVICE_CODE_KIND", new Integer(ACCastUtilities.toInt(t.get("CONTENT_KEY"), 0) + 1000));
			row.put("PROVIDER_NAME", t.get("CONTENT"));
			showList.add(row);
		}
		
		setProviderNameList(showList);
		
		// ��̖|��f�[�^�Ƃ��āA�T�[�r�X�R�[�h�̃f�[�^��ݒ�
		((QkanServiceKindNameFormat)getServiceNameColumn().getFormat()).setMasterService(serviceMap);
		
		// �쐬�����f�[�^���e�[�u���ɕ\������
        String[] ada = { "SERVICE_CODE_KIND", "PROVIDER_NAME" };
		ACTableModelAdapter tableModel = new ACTableModelAdapter();
		tableModel.setColumns(ada);
		getServiceByProviderName().setModel(tableModel);
		
		tableModel.setAdaptee(getProviderNameList());
	}

	// ���Ə����̕ۑ�����
	public void saveProviderNames() throws Exception {
		
		//FIXED_FORM�ɓo�^����Ă������O�̂��ߍĎ擾
		VRMap sqlParam = new VRHashMap();
		sqlParam.put("PROVIDER_ID", QkanSystemInformation.getInstance().getLoginProviderID());
		VRMap prePrintProviderNames = new VRHashMap();
		ACBindUtilities.setMapFromArray(
				getDBManager().executeQuery(getSQL_GET_FIXED_FORM(sqlParam)),
				prePrintProviderNames,
				"CONTENT_KEY");
		
		//id���m��
		if (getProviderFixedFormId() == 0) {
			
			VRList result = getDBManager().executeQuery(getSQL_GET_MAX_FIXED_FORM_ID(null));
			if (result.isEmpty()) {
				throw new Exception("getSQL_GET_MAX_FIXED_FORM_ID�̌��ʂ�0���ł��B");
			}
			setProviderFixedFormId(ACCastUtilities.toInt(((VRMap)result.get(0)).get("MAX_FIXED_FORM_ID")));
		}
		
		
		sqlParam.put("FIXED_FORM_ID", Integer.toString(getProviderFixedFormId()));
		
		VRMap row = null;
		for (int i = 0; i < getProviderNameList().size(); i++) {
			row = (VRMap)getProviderNameList().get(i);
			row.put("SERVICE_CODE_KIND", new Integer(ACCastUtilities.toInt(row.get("SERVICE_CODE_KIND"), 0) - 1000));
			
			// �o�^�ς݃f�[�^
			if (prePrintProviderNames.containsKey(row.get("SERVICE_CODE_KIND"))) {
				VRMap t =(VRMap)prePrintProviderNames.get(row.get("SERVICE_CODE_KIND"));
				
				//���Ə����̕ύX�`�F�b�N
				if (!t.get("CONTENT").equals(row.get("PROVIDER_NAME"))) {
					sqlParam.put("CONTENT_KEY", row.get("SERVICE_CODE_KIND"));
					sqlParam.put("CONTENT", row.get("PROVIDER_NAME"));
					getDBManager().executeUpdate(getSQL_UPDATE_FIXED_FORM(sqlParam));
				}
				
			// ���o�^�f�[�^
			} else {
				sqlParam.put("CONTENT_KEY", row.get("SERVICE_CODE_KIND"));
				sqlParam.put("CONTENT", row.get("PROVIDER_NAME"));
				getDBManager().executeUpdate(getSQL_INSERT_FIXED_FORM(sqlParam));
			}
		}
		
	}
	//[ID:0000612][Shin Fujihara] 2010/11 add end 2010�N�x�Ή�

}
