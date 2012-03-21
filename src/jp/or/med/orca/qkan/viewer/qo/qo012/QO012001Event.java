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
 * �쐬��: 2006/04/11  ���{�R���s���[�^�[������� �A�� ��C �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� CSV�r���[�A (O)
 * �v���Z�X CSV�r���[�A (012)
 * �v���O���� CSV������� (QO012001)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.viewer.qo.qo012;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import jp.nichicom.ac.ACCommon;
import jp.nichicom.vr.io.VRCSVFile;

/**
 * CSV������ʃC�x���g��`(QO012001)
 */
public abstract class QO012001Event extends QO012001Design {
	/**
	 * �R���X�g���N�^�ł��B
	 */
	public QO012001Event() {
		addEvents();
	}

	/**
	 * �C�x���g�����������`���܂��B
	 */
	protected void addEvents() {
		getUnitButton().addActionListener(new ActionListener() {
			private boolean lockFlag = false;

			public void actionPerformed(ActionEvent e) {
				if (lockFlag) {
					return;
				}
				lockFlag = true;
				try {
					unitButtonActionPerformed(e);
				} catch (Throwable ex) {
					ACCommon.getInstance().showExceptionMessage(ex);
				} finally {
					lockFlag = false;
				}
			}
		});
		getFile1Button().addActionListener(new ActionListener() {
			private boolean lockFlag = false;

			public void actionPerformed(ActionEvent e) {
				if (lockFlag) {
					return;
				}
				lockFlag = true;
				try {
					file1ButtonActionPerformed(e);
				} catch (Throwable ex) {
					ACCommon.getInstance().showExceptionMessage(ex);
				} finally {
					lockFlag = false;
				}
			}
		});
		getFile2Button().addActionListener(new ActionListener() {
			private boolean lockFlag = false;

			public void actionPerformed(ActionEvent e) {
				if (lockFlag) {
					return;
				}
				lockFlag = true;
				try {
					file2ButtonActionPerformed(e);
				} catch (Throwable ex) {
					ACCommon.getInstance().showExceptionMessage(ex);
				} finally {
					lockFlag = false;
				}
			}
		});

		getFile3Button().addActionListener(new ActionListener() {
			private boolean lockFlag = false;

			public void actionPerformed(ActionEvent e) {
				if (lockFlag) {
					return;
				}
				lockFlag = true;
				try {
					file3ButtonActionPerformed(e);
				} catch (Throwable ex) {
					ACCommon.getInstance().showExceptionMessage(ex);
				} finally {
					lockFlag = false;
				}
			}
		});
		
		getCloseButton().addActionListener(new ActionListener() {
			private boolean lockFlag = false;

			public void actionPerformed(ActionEvent e) {
				if (lockFlag) {
					return;
				}
				lockFlag = true;
				try {
					closeButtonActionPerformed(e);
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
	 * �uCSV�t�@�C���������I���v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected abstract void closeButtonActionPerformed(ActionEvent e) throws Exception;

	/**
	 * �uCSV�t�@�C�������v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected abstract void unitButtonActionPerformed(ActionEvent e) throws Exception;

	/**
	 * �uCSV1�t�@�C���_�C�A���O�v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected abstract void file1ButtonActionPerformed(ActionEvent e) throws Exception;

	/**
	 * �uCSV2�t�@�C���_�C�A���O�v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected abstract void file2ButtonActionPerformed(ActionEvent e) throws Exception;

	/**
	 * �uCSV3�t�@�C���_�C�A���O�v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected abstract void file3ButtonActionPerformed(ActionEvent e) throws Exception;

	// �ϐ���`

	private VRCSVFile inputCSVFile1;

	private VRCSVFile inputCSVFile2;

	private VRCSVFile outputCSVFile;
    
    private String lastOpenDir;

	public static final String[] CSV_FILE_EXTENSIONS = { "csv" };

	public static final String ERROR_RECORD_COUNT_NOT_FOUND = "���R�[�h���������݂��܂���ł����A�����𒆒f���܂�";

	public static final String ERROR_NOT_SAME_TARGET_DATE = "���CSV�̏����Ώ۔N������v���܂���ł����A�����𒆒f���܂�";

	public static final String ERROR_NOT_SAME_FILE_DATA_TYPE = "���CSV�̃t�@�C����ʂ���v���܂���ł����A�����𒆒f���܂�";

	public static final String ERROR_CAN_NOT_OUTPUT_SELECTED_FOLDER = "�w��̃t�H���_�ɂ͏o�͂ł��܂���A�ēx�o�͐�̃t�H���_��I�����Ă�������";

	public static final String MESSAGE_PLEASE_CSV_OUTPUT_FOLDER = "��������CSV�̏o�͐���w�肵�Ă�������";

	public static final String ERROR_CAN_NOT_READ_CSV = "CSV�t�@�C���̓ǂݍ��݂Ɏ��s���܂���";

	public static final String ERROR_NON_CORRESPONDENCE_DATA_RECORD_TYPE = "��싋�t����⋏��T�[�r�X�v�����i�[����CSV�ł͂���܂���";

	public static final String ERROR_CONTROL_RECORD_NOT_FOUND = "�R���g���[�����R�[�h�����݂��܂���";

	public static final String ERROR_DATA_NOT_FOUND = "�f�[�^�����݂��܂���";

	public static final String ERROR_FILE_NOT_FOUND = "�I�����ꂽ�t�@�C���͑��݂��܂���ł���";

	public static final String MESSAGE_PLEASE_SELECT_CSV_FILE = "CSV�t�@�C�����w�肵�ĉ�����";

	public static final String MESSAGE_CSV_UNITING_OVER = "CSV�t�@�C���̌������������܂���";

	public static final String ERROR_OUTPUT_FOLDER_EMPTY = "�o�͐�̃t�H���_���w�肳��Ă��܂���";

	public static final String ERROR_OUTPUT_FILE_EXSISTS = "�o�͐�ɓ����̃t�@�C��������܂��A�㏑�����܂����H";

	public static final String MESSAGE_WINDOW_TITLE = "��싋�t������E���t�Ǘ��[���CSV�t�@�C������";

	public static final String CSV_FILE_TYPE_812 = "��싋�t������׏��i����T�[�r�X�v���j���";

	public static final String CSV_FILE_TYPE_711 = "��싋�t��������";

	public static final String CSV_FILE_TYPE_821 = "���t�Ǘ��[���";

	public static final int CONTROL_RECORD_INDEX = 0;

	public static final int CONTROL_RECORD_FORMAT_11_TARGET_YEAR_AND_MONTH = 10; // �����Ώ۔N��

	public static final int CONTROL_RECORD_FORMAT_5_DATA_TYPE = 4; // �f�[�^���

	public static final int CONTROL_RECORD_FORMAT_4_RECORD_COUNT = 3; // �f�[�^����

	// getter/setter

	/**
	 * inputCSVFile1��Ԃ��܂��B
	 * 
	 * @return inputCSVFile1
	 */
	protected VRCSVFile getInputCSVFile1() {
		return inputCSVFile1;
	}

	/**
	 * inputCSVFile1��ݒ肵�܂��B
	 * 
	 * @param inputCSVFile1
	 *            inputCSVFile1
	 */
	protected void setInputCSVFile1(VRCSVFile inputCSVFile1) {
		this.inputCSVFile1 = inputCSVFile1;
	}

	/**
	 * inputCSVFile2��Ԃ��܂��B
	 * 
	 * @return inputCSVFile2
	 */
	protected VRCSVFile getInputCSVFile2() {
		return inputCSVFile2;
	}

	/**
	 * inputCSVFile2��ݒ肵�܂��B
	 * 
	 * @param inputCSVFile2
	 *            inputCSVFile2
	 */
	protected void setInputCSVFile2(VRCSVFile inputCSVFile2) {
		this.inputCSVFile2 = inputCSVFile2;
	}

	/**
	 * outputCSVFile��Ԃ��܂��B
	 * 
	 * @return outputCSVFile
	 */
	protected VRCSVFile getOutputCSVFile() {
		return outputCSVFile;
	}

	/**
	 * outputCSVFile��ݒ肵�܂��B
	 * 
	 * @param outputCSVFile
	 *            outputCSVFile
	 */
	protected void setOutputCSVFile(VRCSVFile outputCSVFile) {
		this.outputCSVFile = outputCSVFile;
	}
    

    /**
     * lastOpenDir��Ԃ��܂��B
     * 
     * @return lastOpenDir
     */
    protected String getLastOpenDir() {
        return lastOpenDir;
    }

    /**
     * lastOpenDir��ݒ肵�܂��B
     * 
     * @param lastOpenDir
     *            lastOpenDir
     */
    protected void setLastOpenDir(String lastOpenDir) {
        this.lastOpenDir = lastOpenDir;
    }
    
}
