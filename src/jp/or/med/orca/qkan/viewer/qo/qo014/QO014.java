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
 * �쐬��: 2012/09/19  ���{�R���s���[�^�[������� �����@�L �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���̑��@�\ (O)
 * �v���Z�X ���O�r���[�A (014)
 * �v���O���� ���O�r���[�A (QO014)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.viewer.qo.qo014;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import jp.nichicom.ac.component.ACAffairButton;
import jp.nichicom.ac.component.ACAffairButtonBar;
import jp.nichicom.ac.container.ACBackLabelContainer;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.core.ACFrameEventProcesser;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.ac.util.ACMessageBox;
import jp.nichicom.ac.util.adapter.ACTableModelAdapter;
import jp.nichicom.vr.plaf.metal.VRLookAndFeel;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.nichicom.vr.util.logging.VRLogger;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.QkanConstants;
import jp.or.med.orca.qkan.affair.QkanBrowseLogger;
import jp.or.med.orca.qkan.affair.QkanBrowseLoggerFormatter;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;

/**
 * ���O�r���[�A(QO014)
 */
@SuppressWarnings("serial")
public class QO014 extends QO014Event {
	/**
	 * �R���X�g���N�^�ł��B
	 */
	public QO014() {
	}
	
	@Override
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
		// ��ʂ�W�J����
		getSnapshot().setRootContainer(getContents());
		
		// DB�ڑ��m�F DB�ڑ��\���ǂ���
        if (getDBManager().canConnect()) {
        	//DB�ڑ����\�ł���΁AcanDBConnect��true
            setCanDBConnect(true);
            
        	//canDBConnect��true�̏ꍇ�A�f�[�^�x�[�X����Ɩ����̂��擾����
        	initAffairNameMap();
        	
        } else {
        	//�s�\�ł����canDBConnect��false
            setCanDBConnect(false);
        }
        
		// ���O�t�@�C���̃��X�g���擾����
        initLogFileNameList();
        
		// ���O�t�@�C�������݂��Ȃ��ꍇ
        if (getLogFileList().getDataSize() == 0) {
        	// �{�^���������Ȃ���ԂɕύX
        	setState_MOVE_NONE();
        	
        	// ���O�t�@�C�������݂��Ȃ����b�Z�[�W��\�����A�����𒆒f����B
        	ACMessageBox.show(MESSAGE_LOG_NOT_FOUND, ACMessageBox.BUTTON_OK , ACMessageBox.ICON_INFOMATION);
        	return;
        }
        
        //readLogFileNumber��0�ɂ���B
        setReadLogFileNumber(0);
        
		// ���O�t�@�C�����̕\����ύX����
        getHeaderMap().setData(FILE_COUNT, ACCastUtilities.toString(getLogFileList().getDataSize()));
        
		// ��ʏ�̃��O�t�@�C��������L�����Ŏ擾�������ōX�V����B
        getFileInfoGroup().setSource(getHeaderMap());
        getFileInfoGroup().bindSource();
        
        // ���O�\���e�[�u���̏�����
        String[] logDataTableSchema = new String[] {
    		LOG_DATETIME,
    		USER_NAME,
    		AFFAIR_ID,
    		AFFAIR_NAME,
    		PATIENT_NAME,
    		PATIENT_NAME_KANA
        };

        // �i�[
        ACTableModelAdapter logDataTableModel = new ACTableModelAdapter();
        logDataTableModel.setColumns(logDataTableSchema);

        // csvDataTable��csvDataTableModel���Z�b�g����
        getLogDataTable().setModel(logDataTableModel);

        // ���f���Ƀf�[�^���Z�b�g����
        logDataTableModel.setAdaptee(getLogFileContentList());
        
		// �e�[�u���փ��O�t�@�C���̕\�����s���B
		readLogFile();

	}
	
	
	@Override
	public boolean canClose() throws Exception {
		if (!super.canClose()) {
			return false;
		}
        // ���I������
        // �I���m�F�̃��b�Z�[�W��\������BCSV�r���[�A���I�����Ă���낵���ł����H
        if (ACMessageBox.showOkCancel(MESSAGE_PROGRAM_EXIT) == ACMessageBox.RESULT_OK) {
            // �uOK�v�I����
            // �v���O�������I������B�i��Ղ�true��Ԃ��j
            return true;
        }
        // �u�L�����Z���v�I����
        // �����𒆒f����B(��Ղ�false��Ԃ�)
        return false;
	}

	// �R���|�[�l���g�C�x���g

	/**
	 * �u�ЂƂO�̃��O�t�@�C�����J���v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	@Override
	protected void prevButtonActionPerformed(ActionEvent e) throws Exception {
		// readLogFileNumber��-1����B
		setReadLogFileNumber(getReadLogFileNumber() - 1);
		
		// �e�[�u���փ��O�t�@�C���̕\�����s���B
		readLogFile();

	}

	/**
	 * �u���̃��O�t�@�C�����J���v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	@Override
	protected void nextButtonActionPerformed(ActionEvent e) throws Exception {
		// readLogFileNumber��+1����B
		setReadLogFileNumber(getReadLogFileNumber() + 1);
		
		// �e�[�u���փ��O�t�@�C���̕\�����s���B
		readLogFile();

	}

	// �����֐�

	/**
	 * �u���O�f�[�^�擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void readLogFile() throws Exception {
		
		// logFileContentList�̓��e���N���A
		getLogFileContentList().clear();
		
		// logFileList����readLogFileNumber�Ԗڂ̃t�@�C�����̂��擾����B
		File log = (File)getLogFileList().getData(getReadLogFileNumber());
		
		BufferedReader br = null;
		String line = null;
		
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(log), "UTF-8"));
			
			String[] ary = null;
			int length = 0;
			while((line = br.readLine()) != null) {
				
				//��s���X�y�[�X�ŕ���
				ary = line.split(" ");
				
				//�ؒ萔�����̕����s�͕s���Ƃ݂Ȃ��X�L�b�v
				length = ary.length;
				if (length < 4) {
					continue;
				}
				
				//VRMap�I�u�W�F�N�g�𐶐�
				VRMap row = new VRHashMap();
				
				// Array[0] + " " + Array[1]���L�[LOG_DATETIME�ŁAVRMap�ɐݒ肷��B
				row.put(LOG_DATETIME, ary[0] + " " + ary[1]);
				// Array[2]���L�[USER_NAME�ŁAVRMap�ɐݒ肷��B
				row.put(USER_NAME, ary[2]);
				// Array[3]���L�[AFFAIR_ID�ŁAVRMap�ɐݒ肷��B
				row.put(AFFAIR_ID, ary[3]);
				
				// canDBConnect��false�̏ꍇ�͏����I��
				if (!getCanDBConnect()) {
					continue;
				}
				
				
				// canDBConnect��true�̏ꍇ�̏���
				String key = ary[3];
				// QkanBrowseLoggerFormatter.AFFAIR_MODE��AFFAIR_ID�����݂���ꍇ(���[�h�����݂���ꍇ)
				if (QkanBrowseLoggerFormatter.AFFAIR_MODE.containsKey(ary[3])) {
					if (5 <= length) {
						// �L�[�Ƀ��[�h��ǉ�����
						key += "-" + ary[4];
					}
				}
				
				// arrairMap����Y���̋Ɩ����̂��擾���A�L�[AFFAIR_NAME��VRMap�ɐݒ肷��B
				row.put(AFFAIR_NAME, getAffairMap().get(key));
				
				// QkanBrowseLoggerFormatter.AFFAIR_PERSONAL��AFFAIR_ID�����݂���ꍇ(�l�����{������Ɩ��̏ꍇ))
				if (QkanBrowseLoggerFormatter.AFFAIR_PERSONAL.contains(ary[3])) {
					
					//���p�҂̏���ݒ肷��
					setUserInfo(row, ary[length - 1]);
					
				// QkanBrowseLoggerFormatter.AFFAIR_PERSONAL��AFFAIR_ID�����݂��Ȃ��ꍇ
				} else {
					// �󔒂��L�[PATIENT_NAME�ŁAVRMap�ɐݒ肷��B
					row.put(PATIENT_NAME, "");
					// �󔒂��L�[INSURED_ID�ŁAVRMap�ɐݒ肷��B
					row.put(PATIENT_NAME_KANA, "");
				}
				
				//�쐬����VRMap��logFileContentList�֒ǉ�
				getLogFileContentList().add(row);
			}
			
			
		} catch (Exception e) {
			System.out.println(line);
			throw e;
		} finally {
			if (br != null) {
				br.close();
			}
		}
		
		// ���O�t�@�C�����̕\����ύX����
        getHeaderMap().setData(VIEW_FILE_NUMBER, ACCastUtilities.toString(getReadLogFileNumber() + 1) + "�Ԗ�");
        getFileInfoGroup().bindSource();

		// logFileList�̃T�C�Y��1�̏ꍇ
		if (getLogFileList().size() == 1) {
			// �{�^����ԕύX
			setState_MOVE_NONE();
			return;
		}
		
		// readLogFileNumber��0�̏ꍇ
		if (getReadLogFileNumber() == 0) {
			// �{�^����ԕύX
			setState_MOVE_NEXT_ONLY();
			return;
		}
		
		// readLogFileNumber��logFileList�̃T�C�Y-1�̏ꍇ
		if (getLogFileList().size() - 1 <= getReadLogFileNumber()) {
			// �{�^����ԕύX
			setState_MOVE_PREV_ONLY();
			return;
		}
		
		// �{�^����ԕύX
		setState_MOVE_ALL();
		
	}
	
	
	/**
	 * �Ɩ����̂��f�[�^�x�[�X����擾����
	 * 
	 * @throws Exception�@������O
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void initAffairNameMap() throws Exception {
		
		//�Ɩ����̈ꗗ�擾��SQL�����擾 �f�[�^�x�[�X����Ɩ����̂��擾����
    	VRList affairList = getDBManager().executeQuery(getSQL_GET_AFFAIR_INFO(null));
    	VRMap map = new VRHashMap();
    	
    	for (Object obj : affairList) {
    		VRMap row = (VRMap)obj;
    		
    		String key = ACTextUtilities.trim(ACCastUtilities.toString(row.get("AFFAIR_ID")));
    		//���[�h�����v���O����ID�̏ꍇ�A���[�h���܂߂ăL�[�ɂ���
    		if(QkanBrowseLoggerFormatter.AFFAIR_MODE.containsKey(key)) {
    			key += "-" + ACTextUtilities.trim(ACCastUtilities.toString(row.get("MODE")));
    		}
    		
    		map.put(key,  ACTextUtilities.trim(ACCastUtilities.toString(row.get("WINDOW_TITLE"))));
    	}
    	
    	//affairMap�ɑޔ�����
    	setAffairMap(map);
	}

	/**
	 * �o�͂���Ă��郍�O�t�@�C���̖��̂��擾����
	 * 
	 * @throws Exception�@������O
	 * 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void initLogFileNameList() throws Exception {
		
		// QkanBrowseLogger.LOG_FILE + ".[���l]"�`���ŕ����̃��O�t�@�C�����o�͂���Ă���
		// ���O�t�@�C���̖��̂����ׂĎ擾���AlogFileList�ɐݒ肷��B
		
		File baseLog = new File(QkanBrowseLogger.LOG_FILE);
		File logDir = baseLog.getParentFile();
		
		if (!logDir.isDirectory()) {
			VRLogger.warning("���O�o�̓t�H���_�̎擾�Ɏ��s���܂����B");
			return;
		}
		
		VRList list = new VRArrayList();
		String baseLogName = baseLog.getName();
		for (File f : logDir.listFiles()) {
			
			String fileName = f.getName();
			
			//�w��̃��O�t�@�C�����Ŏn�܂��Ă��邩
			if (!fileName.startsWith(baseLogName)) {
				continue;
			}
			
			//lck�t�@�C���͏��O����
			if (fileName.endsWith("lck")) {
				continue;
			}
			
			//�Y�����O�t�@�C����ޔ�
			list.add(f);
		}
		
		setLogFileList(list);
	}

	
	
	/**
	 * ���[�U�[����ݒ肷��
	 * 
	 * @throws Exception�@������O
	 * 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void setUserInfo(VRMap row, String patient_id) throws Exception {
		
		VRMap info = null;
		
		//patientMap�Ɋ��ɑޔ�����patient_id�̏�񂪂���ꍇ
		if (getPatientMap().containsKey(patient_id)) {
			//Map�̓��e��ݒ肷��
			info = (VRMap)getPatientMap().get(patient_id);
			row.putAll(info);
			return;
		}
		
		//patientMap�Ɋ��ɑޔ�����patient_id�̏�񂪂Ȃ��ꍇ
		//patient_id�����l�ł��邩�m�F�@���l�ł͖����ꍇ�͏����I��
		if (!ACCastUtilities.isInt(patient_id)) {
			return;
		}
		
		//���ʊ֐�QkanCommon.getPatientInfo()���g�p���āA�l�����擾����B
		VRList list = QkanCommon.getPatientInfo(getDBManager(), ACCastUtilities.toInt(patient_id));
		info = new VRHashMap();
		
		//�f�[�^���擾�ł��Ȃ��ꍇ�́A"�s��"��ݒ�
		if (list.size() == 0) {
			info.put(PATIENT_NAME, "�s��");
			info.put(PATIENT_NAME_KANA, "�s��");
			
		} else {
			VRMap map = (VRMap)list.get(0);
			info.put(PATIENT_NAME, QkanCommon.toFullName(map.get("PATIENT_FAMILY_NAME"), map.get("PATIENT_FIRST_NAME")));
			info.put(PATIENT_NAME_KANA, QkanCommon.toFullName(map.get("PATIENT_FAMILY_KANA"), map.get("PATIENT_FIRST_KANA")));
		}
		
		getPatientMap().put(patient_id, info);
		row.putAll(info);
	}
	
	
	//�v���O�����N���|�C���g
	public static void main(String[] args) {
		
        VRLookAndFeel.getCurrentVRTheme().setPrimary1(
                QkanConstants.COLOR_RESOURCE_QKAN_PRIMARY_1);
        VRLookAndFeel.getCurrentVRTheme().setPrimary2(
                QkanConstants.COLOR_RESOURCE_QKAN_PRIMARY_2);
        VRLookAndFeel.getCurrentVRTheme().setPrimary3(
                QkanConstants.COLOR_RESOURCE_QKAN_PRIMARY_3);

        ACAffairButtonBar.setThemaColor(QkanConstants.COLOR_QKAN_THEMA);
        ACAffairButton.setThemaColor(QkanConstants.COLOR_QKAN_THEMA);
        ACBackLabelContainer
                .setThemaColor(QkanConstants.COLOR_BACK_LABEL_CONTAINER);

        try {
            ACFrame.setVRLookAndFeel();
            ACFrameEventProcesser processer = new QkanFrameEventProcesser();
            ACFrame.getInstance().setFrameEventProcesser(processer);
            ACFrame.getInstance().next(new ACAffairInfo(QO014.class.getName()));
            ACFrame.getInstance().setTitle(MESSAGE_PROGRAM_TITLE);
            ACFrame.getInstance().setExtendedState(Frame.MAXIMIZED_BOTH);
            ACFrame.getInstance().setVisible(true);
        } catch (Exception ex) {
            VRLogger.info(ex);
        }
	}

}
