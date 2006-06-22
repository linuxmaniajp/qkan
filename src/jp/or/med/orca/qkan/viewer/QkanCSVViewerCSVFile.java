package jp.or.med.orca.qkan.viewer;

import jp.nichicom.vr.io.VRCSVFile;

/**
 * ���ǒ�CSV�������ʏo�͗p��CSV�t�@�C���A�N�Z�X�N���X�ł��B
 * <p>
 * Copyright (c) 2005 Nippon Computer Corpration. All Rights Reserved.
 * </p>
 * 
 * @author Kazumi Hirose
 * @version 1.0 2006/04/12
 */
public class QkanCSVViewerCSVFile extends VRCSVFile {
	/**
	 * �R���X�g���N�^�ł��B
	 * 
	 * @param path
	 *            �t�@�C���p�X
	 */
	public QkanCSVViewerCSVFile(String path) {
		super(path);
	}

	/**
	 * �R���X�g���N�^�ł��B
	 * 
	 * @param path
	 *            �t�@�C���p�X
	 * @param encode
	 *            �G���R�[�h
	 */
	public QkanCSVViewerCSVFile(String path, String encode) {
		super(path, encode);
	}

	/**
	 * �u���ے���������`���\�t�g�E�F�A����CSV�ɐ��`�v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */

	protected void appendValue(StringBuffer sb, Object value, int rowIndex, int columnIndex) {
		if (rowIndex == 0) {
			// 1�s�ڂ͕ʏ���
			// �N�H�[�g�����������ɏo��
			sb.append(value);
			// �J���}���Y�ꂸ��
			sb.append(VRCSVFile.COMMA);
		} else {
			// �K���CSV�o�͂��s�Ȃ�
			if (columnIndex <= 1) {
				sb.append(value);
				sb.append(VRCSVFile.COMMA);
			} else {
				super.appendValue(sb, value, rowIndex, columnIndex);
			}
		}
	}
}
