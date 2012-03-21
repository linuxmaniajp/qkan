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
 * �J����: �A�� ��C
 * �쐬��: 2006/04/10  ���{�R���s���[�^�[������� �A�� ��C �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� CSV�r���A�[ (O)
 * �v���Z�X CSV�r���A�[ (012)
 * �v���O���� CSV�r���A�[ (QO012)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.viewer.qo.qo012;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import jp.nichicom.ac.ACCommon;
import jp.nichicom.vr.io.VRCSVFile;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;

/**
 * CSV�r���A�[�C�x���g��`(QO012)
 */
public abstract class QO012Event extends QO012SQL {
	/**
	 * �R���X�g���N�^�ł��B
	 */
	public QO012Event() {
		addEvents();
	}

	/**
	 * �C�x���g�����������`���܂��B
	 */
	protected void addEvents() {
		getOpenButton().addActionListener(new ActionListener() {
			private boolean lockFlag = false;

			public void actionPerformed(ActionEvent e) {
				if (lockFlag) {
					return;
				}
				lockFlag = true;
				try {
					openButtonActionPerformed(e);
				} catch (Throwable ex) {
					ACCommon.getInstance().showExceptionMessage(ex);
				} finally {
					lockFlag = false;
				}
			}
		});
		getUnitingButton().addActionListener(new ActionListener() {
			private boolean lockFlag = false;

			public void actionPerformed(ActionEvent e) {
				if (lockFlag) {
					return;
				}
				lockFlag = true;
				try {
					unitingButtonActionPerformed(e);
				} catch (Throwable ex) {
					ACCommon.getInstance().showExceptionMessage(ex);
				} finally {
					lockFlag = false;
				}
			}
		});

	}

	// �R���|�[�l���g�C�x���g

	/**
	 * �uCSV�t�@�C�����J���v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected abstract void openButtonActionPerformed(ActionEvent e) throws Exception;

	/**
	 * �uCSV�t�@�C�������v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected abstract void unitingButtonActionPerformed(ActionEvent e) throws Exception;

	// �ϐ���`

	private VRMap headerMap = new VRHashMap();

	private VRMap providerMap = new VRHashMap();

	private VRList outputTableList = new VRArrayList();

	private VRList totalInfoTableList = new VRArrayList();
	
	private VRList claimInfoTableList = new VRArrayList();

	private String inputCSVFilePath;

	private VRCSVFile inputCSVFile;
	
	private boolean canDBConnect;

	public static final String[] CSV_FILE_EXTENSIONS = { "csv" };

	public static final Integer ON = new Integer(1);

	// �萔��`
	public static final String MATRIX_ON = "��";

	public static final String MEDIA_TYPE4 = "�e�c";

	public static final String MEDIA_TYPE3 = "�l�s";

	public static final String MEDIA_TYPE2 = "�l�n";

	public static final String MEDIA_TYPE1 = "�`��";

	public static final String CSV_FILE_TYPE_821 = "���t�Ǘ��\���";
	
	public static final String CSV_FILE_TYPE_812 = "��싋�t������׏��i����T�[�r�X�v���j���";

	public static final String CSV_FILE_TYPE_711 = "��싋�t��������";

	public static final String NURSING_NECESSARY_LEVEL25 = "�v���5";

	public static final String NURSING_NECESSARY_LEVEL24 = "�v���4";

	public static final String NURSING_NECESSARY_LEVEL23 = "�v���3";

	public static final String NURSING_NECESSARY_LEVEL22 = "�v���2";

	public static final String NURSING_NECESSARY_LEVEL21 = "�v���1";

	public static final String NURSING_NECESSARY_LEVEL13 = "�v�x��2";

	public static final String NURSING_NECESSARY_LEVEL12 = "�v�x��1";

	public static final String NURSING_NECESSARY_LEVEL11 = "�o�ߓI�v���";

	public static final String NURSING_NECESSARY_LEVEL01 = "��Y��";

	public static final String NAME_LESS = "";

	public static final String PROVIDER_LESS = "";

	// �G���[���b�Z�[�W
	public static final String ERROR_TARGET_DATE_NOT_FOUND = "�����Ώ۔N�����擾�ł��܂���ł���";

	public static final String ERROR_PROVIDER_NUMBER_NOT_FOUND = "���Ə��ԍ����擾�ł��܂���ł���";

	public static final String ERROR_MEDIA_TYPE_NOT_FOUND = "�}�̋敪���擾�ł��܂���ł���";
	
	public static final String ERROR_SERVICE_PROVIDE_YEAR_AND_MONTH_NOT_FOUND = "�T�[�r�X�񋟔N�����擾�ł��܂���ł���";
	
	public static final String ERROR_NON_CORRESPONDENCE_DATA_RECORD_TYPE = "��싋�t����⋏��T�[�r�X�v�����i�[����CSV�ł͂���܂���";

	public static final String ERROR_CONTROL_RECORD_NOT_FOUND = "�R���g���[�����R�[�h�����݂��܂���";

	public static final String ERROR_DATA_NOT_FOUND = "�f�[�^�����݂��܂���";

	public static final String ERROR_CSV_FILE_CAN_NOT_READ = "CSV�t�@�C���̓ǂݍ��݂Ɏ��s���܂���";

	public static final String ERROR_SELECTED_FILE_NOT_FOUND = "�I�����ꂽ�t�@�C���͑��݂��܂���ł���";

	public static final String MESSAGE_FILE_OPEN_DIALOG_TITLE = "CSV�t�@�C�����w�肵�ĉ�����";

	public static final String MESSAGE_SPLASH_TEXT1 = "CSV�t�@�C���R���g���[�����R�[�h��͒�";
	public static final String MESSAGE_SPLASH_TEXT2 = "CSV�t�@�C����񃌃R�[�h��͒�";
	public static final String MESSAGE_SPLASH_TEXT4 = "CSV�t�@�C���W�v��͒�";

	public static final String MESSAGE_PROGRAM_EXIT = "���t�Ǘ�/����V���� CSV�t�@�C���r���[�A���I�����Ă���낵���ł����H";

	public static final String MESSAGE_PROGRAM_TITLE = "���t�Ǘ�/����V���� CSV�t�@�C���r���[�A";

	// CONTROL RECORD��͏�����CSV�C���f�b�N�X
	public static final int CONTROL_RECORD_FORMAT_5_DATA_TYPE = 4; // �f�[�^���

	public static final int CONTROL_RECORD_FORMAT_8_PROVIDER_NUMBER = 7; // ���Ə��ԍ�

	public static final int CONTROL_RECORD_FORMAT_10_MEDIA_TYPE = 9; // �}�̋敪

	public static final int CONTROL_RECORD_FORMAT_11_TARGET_YEAR_AND_MONTH = 10; // �����Ώ۔N��

	// �eCSV�t�H�[�}�b�g���ʂ�CSV�C���f�b�N�X
	public static final int COMMON_RECORD_FORMAT_1_RECORD_TYPE = 0; // ���R�[�h���

	public static final int COMMON_RECORD_FORMAT_3_EXCHANGE_TYPE = 2; // �������ʔԍ�(�f�[�^���R�[�h�̃t�H�[�}�b�g�Ƃ��Ă͒ʂ���3�Ԗ�)

	// �f�[�^���R�[�h����
	public static final int DATA_RECORD_FORMAT_711TYPE_2_RECORD_TYPE_CODE = 3; // 711�n�������[���R�[�h��ʃR�[�h

	// ��{���R�[�h�i711�n�j��CSV�C���f�b�N�X
	public static final int BASIC_RECORD_3_SERVICE_PROVIDE_YEAR_AND_MONTH = 4; // �T�[�r�X�񋟔N��

	public static final int BASIC_RECORD_6_INSURED_ID = 7; // ��ی��Ҕԍ�

	public static final int BASIC_RECORD_15_CARE_LEVEL = 16; // �v���x��ԋ敪�R�[�h

	public static final int BASIC_RECORD_18_INSURED_END_DATE = 19; // �F��L�����ԊJ�n�N����

	public static final int BASIC_RECORD_17_INSURED_START_DATE = 18; // �F��L�����ԏI���N����

	// ���׃��R�[�h(711�n)��CSV�C���f�b�N�X
	public static final int DETAIL_RECORD_3_SERVICE_PROVIDE_YEAR_AND_MONTH = 4; // �T�[�r�X�񋟔N��

	public static final int DETAIL_RECORD_6_INSURED_ID = 7; // ��ی��Ҕԍ�
	
	public static final int DETAIL_RECORD_7_SERVICE_TYPE_CODE = 8; // �T�[�r�X��ރR�[�h

	// ����f�Ô�R�[�h(711�n)��CSV�C���f�b�N�X
	public static final int SPECIAL_CLINIC_RECORD_3_SERVICE_PROVIDE_YEAR_AND_MONTH = 4; // �T�[�r�X�񋟔N��

	public static final int SPECIAL_CLINIC_RECORD_6_INSURED_ID = 7; // ��ی��Ҕԍ�
	
	public static final int SPECIAL_CLINIC_RECORD_7_SEQUENCE_CODE = 8; // ���R�[�h�����ԍ�
	
	public static final int SPECIAL_CLINIC_RECORD_13_UNIT_TOTAL = 14; // �ی����v�P�ʐ�	
	
	
	// �W�v���R�[�h(711�n)��CSV�C���f�b�N�X
	public static final int TOTAL_RECORD_3_SERVICE_PROVIDE_YEAR_AND_MONTH = 4; // �T�[�r�X�񋟔N��
	
	public static final int TOTAL_RECORD_6_INSURED_ID = 7; // ��ی��Ҕԍ�

	public static final int TOTAL_RECORD_14_UNIT_TOTAL = 15; // �ی��P�ʐ����v

	public static final int TOTAL_RECORD_27_MEDICAL_UNIT_TOTAL = 28; // �ی����o������Ô�P�ʐ�

	public static final int TOTAL_RECORD_16_AMOUNT_TOTAL = 17; // �����z

	public static final int TOTAL_RECORD_28_MEDICAL_AMOUNT_TOTAL = 29; // �ی����o������Ô���z

	// �P�A�v�������R�[�h(812�n)��CSV�C���f�b�N�X
	public static final int CAREPLAN_RECORD_4_SERVICE_PROVIDE_YEAR_AND_MONTH = 5; // �T�[�r�X�񋟔N��

	public static final int CAREPLAN_RECORD_7_INSURED_ID = 8; // ��ی��Ҕԍ�

	public static final int CAREPLAN_RECORD_12_CARE_LEVEL = 13; // �v���x�敪�R�[�h

	public static final int CAREPLAN_RECORD_13_INSURED_START_DATE = 14; // �F��L�����ԊJ�n�N����

	public static final int CAREPLAN_RECORD_14_INSURED_END_DATE = 15; // �F��L�����ԏI���N����

	public static final int CAREPLAN_RECORD_17_UNIT_TOTAL = 18; // �P�ʐ�

	public static final int CAREPLAN_RECORD_19_AMOUNT_TOTAL = 19; // �����z
	
	//[ID:0000448][Shin Fujihara] 2009/02 add begin ����21�N4���@�����Ή�
	public static final int CAREPLAN_RECORD_21_UNIT_TOTAL = 21; // �P�ʐ�
	public static final int CAREPLAN_RECORD_22_AMOUNT_TOTAL = 22; // �����z
	//[ID:0000448][Shin Fujihara] 2009/02 add end ����21�N4���@�����Ή�
	
	// ���t�Ǘ����̃C���f�b�N�X

	public static final int MANAGEMENT_RECORD_2_SERVICE_PROVIDE_YEAR_AND_MONTH = 3; // �T�[�r�X�񋟔N��
	
	public static final int MANAGEMENT_RECORD_10_INSURED_ID = 10; // ��ی��Ҕԍ�
	
	public static final int MANAGEMENT_RECORD_12_CARE_LEVEL = 13; // �v���x��ԋ敪
	
	public static final int MANAGEMENT_RECORD_20_UNIT_TOTAL = 21; // �P�ʐ�
	
	public static final int MANAGEMENT_RECORD_19_SERVICE_TYPE_CODE = 20; // �T�[�r�X��ʃR�[�h
	
	public static final int MANAGEMENT_RECORD_13_INSURED_END_DATE = 14; // �F��L�����ԊJ�n�N����

	public static final int MANAGEMENT_RECORD_14_INSURED_START_DATE = 15; // �F��L�����ԏI���N����

	
	// 7111��CSV�C���f�b�N�X
	public static final int CLAIM_RECORD_2_SERVICE_PROVIDE_YEAR_AND_MONTH = 3; // �T�[�r�X�񋟔N��

	public static final int CLAIM_RECORD_3_PROVIDER_ID = 4; // ���ƎҔԍ�
	
	public static final int CLAIM_RECORD_4_CARE_OR_PUBLIC_EXPENCE_ID = 5; // �ی��E����敪

	public static final int CLAIM_RECORD_6_CLAIM_STATUS = 7; // ������ԋ敪

	public static final int CLAIM_RECORD_7_TOTAL_COUNTS = 8; // ���v����

	public static final int CLAIM_RECORD_8_TOTAL_UNITS = 9; // ���v�P�ʐ�

	public static final int CLAIM_RECORD_10_TOTAL_AMOUNT = 11; // ���v�ی������z
	
	// [ID:0000623][Shin Fujihara] 2010/11 add begin 2010�N�x�Ή�
	// �f�[�^���R�[�h711�n
	public static final int BASIC_RECORD_5_INSURER_ID = 6; // ��{��񃌃R�[�h�� �ی��Ҕԍ��C���f�b�N�X
	public static final int DETAIL_RECORD_5_INSURER_ID = 6; //���׏�񃌃R�[�h�� �ی��Ҕԍ��C���f�b�N�X
	public static final int SPECIAL_CLINIC_RECORD_5_INSURER_ID = 6; // ����f�Ô�R�[�h�� �ی��Ҕԍ��C���f�b�N�X
	public static final int TOTAL_RECORD_5_INSURER_ID = 6;  // �W�v���R�[�h�� �ی��Ҕԍ��C���f�b�N�X
	
	// �f�[�^���R�[�h812�n �ی��Ҕԍ��C���f�b�N�X
	public static final int CAREPLAN_RECORD_5_INSURER_ID = 6; // �ی��Ҕԍ��C���f�b�N�X
	
	// �f�[�^���R�[�h822�n �ی��Ҕԍ��C���f�b�N�X
	public static final int MANAGEMENT_RECORD_3_INSURER_ID = 4; // �ی��Ҕԍ��C���f�b�N�X
	// [ID:0000623][Shin Fujihara] 2010/11 add end 2010�N�x�Ή�

	
	// getter/setter

	/**
	 * headerMap��Ԃ��܂��B
	 * 
	 * @return headerMap
	 */
	protected VRMap getHeaderMap() {
		return headerMap;
	}

	/**
	 * headerMap��ݒ肵�܂��B
	 * 
	 * @param headerMap
	 *            headerMap
	 */
	protected void setHeaderMap(VRMap headerMap) {
		this.headerMap = headerMap;
	}

	/**
	 * canDBConnect��Ԃ��܂��B
	 * 
	 * @return headerMap
	 */
	protected boolean getCanDBConnect() {
		return canDBConnect;
	}

	/**
	 * canDBConnect��ݒ肵�܂��B
	 * 
	 * @param headerMap
	 *            headerMap
	 */
	protected void setCanDBConnect(boolean canDBConnect) {
		this.canDBConnect = canDBConnect;
	}

	
	/**
	 * providerMap��Ԃ��܂��B
	 * 
	 * @return providerMap
	 */
	protected VRMap getProviderMap() {
		return providerMap;
	}

	/**
	 * providerMap��ݒ肵�܂��B
	 * 
	 * @param providerMap
	 *            providerMap
	 */
	protected void setProviderMap(VRMap providerMap) {
		this.providerMap = providerMap;
	}

	/**
	 * outputTableList��Ԃ��܂��B
	 * 
	 * @return outputTableList
	 */
	protected VRList getOutputTableList() {
		return outputTableList;
	}

	/**
	 * outputTableList��ݒ肵�܂��B
	 * 
	 * @param outputTableList
	 *            outputTableList
	 */
	protected void setOutputTableList(VRList outputTableList) {
		this.outputTableList = outputTableList;
	}

	/**
	 * totalInfoTableList��Ԃ��܂��B
	 * 
	 * @return totalInfoTableList
	 */
	protected VRList getTotalInfoTableList() {
		return totalInfoTableList;
	}

	/**
	 * totalInfoTableList��ݒ肵�܂��B
	 * 
	 * @param totalInfoTableList
	 *            totalInfoTableList
	 */
	protected void setTotalInfoTableList(VRList totalInfoTableList) {
		this.totalInfoTableList = totalInfoTableList;
	}

	/**
	 * claimInfoTableList��Ԃ��܂��B
	 * 
	 * @return claimInfoTableList
	 */
	protected VRList getClaimInfoTableList() {
		return claimInfoTableList;
	}

	/**
	 * claimInfoTableList��ݒ肵�܂��B
	 * 
	 * @param claimInfoTableList
	 *            claimInfoTableList
	 */
	protected void setClaimInfoTableList(VRList claimInfoTableList) {
		this.claimInfoTableList = claimInfoTableList;
	}
	
	/**
	 * inputCSVFilePath��Ԃ��܂��B
	 * 
	 * @return inputCSVFilePath
	 */
	protected String getInputCSVFilePath() {
		return inputCSVFilePath;
	}

	/**
	 * inputCSVFilePath��ݒ肵�܂��B
	 * 
	 * @param inputCSVFilePath
	 *            inputCSVFilePath
	 */
	protected void setInputCSVFilePath(String inputCSVFilePath) {
		this.inputCSVFilePath = inputCSVFilePath;
	}

	/**
	 * inputCSVFile��Ԃ��܂��B
	 * 
	 * @return inputCSVFile
	 */
	protected VRCSVFile getInputCSVFile() {
		return inputCSVFile;
	}

	/**
	 * inputCSVFile��ݒ肵�܂��B
	 * 
	 * @param inputCSVFile
	 *            inputCSVFile
	 */
	protected void setInputCSVFile(VRCSVFile inputCSVFile) {
		this.inputCSVFile = inputCSVFile;
	}

	// �����֐�

	/**
	 * �uCSV�f�[�^�擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 * @return boolean
	 */
	public abstract boolean csvReader() throws Exception;

	/**
	 * �u�R���g���[�����R�[�h��́v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 * @return boolean
	 */
	public abstract boolean controlRecordParser() throws Exception;

	/**
	 * �u�f�[�^���R�[�h��́v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 * @return boolean
	 */
	public abstract boolean dataRecordPaser() throws Exception;

	 /**
	 * �u711�n��{��񃌃R�[�h�̉�́v�Ɋւ��鏈�����s�Ȃ��܂��B
	 *
	 * @throws Exception
	 * ������O
	 */
	public abstract boolean dataType711Paser01(int rowIndex, VRMap returnDataMap) throws Exception;

	 /**
	 * �u711�n���׏�񃌃R�[�h�̉�́v�Ɋւ��鏈�����s�Ȃ��܂��B
	 *
	 * @throws Exception
	 * ������O
	 */
	public abstract boolean dataType711Paser02(int rowIndex, VRMap returnDataMap) throws Exception;

	 /**
	 * �u711�n�W�v��񃌃R�[�h�̉�́v�Ɋւ��鏈�����s�Ȃ��܂��B
	 *
	 * @throws Exception
	 * ������O
	 */
	public abstract boolean dataType711Paser10(int rowIndex, VRMap returnDataMap) throws Exception;

	/**
	 * �u��͂����s�f�[�^�̌��������v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public abstract boolean dataRecordMerge(VRList dataRecordList) throws Exception;

	/**
	 * �u711�n����f�Ô�R�[�h�̉�́v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public abstract boolean dataType711Paser04(int rowIndex, VRMap returnDataMap) throws Exception;

	/**
	 * �u822�n�������ʏ���{��́v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public abstract boolean dataRecord822Parser(int rowIndex, VRMap returnDataMap) throws Exception;

	/**
	 * �u7111�n�l����ꃌ�R�[�h�̉�́v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public abstract boolean dataRecord7111Parser(int rowIndex) throws Exception;

	
}
