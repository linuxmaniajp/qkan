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
 */

package jp.or.med.orca.qkan.affair.qm.qm001;

import java.util.Date;

import sun.nio.cs.HistoricallyNamedCharset;

import com.sun.org.apache.xpath.internal.compiler.OpCodes;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.sql.ACDBManager;
import jp.nichicom.ac.util.ACDateUtilities;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.QkanSystemInformation;

/**
 * �V�X�e������o�^�\�ȃ}�X�^�̕␳�p�^�X�N�N���X
 * 
 */
public class QM001UpdateMasterTask {
	// �}�X�^�o�[�W����
	public String version = "";

	/**
	 * �R���X�g���N�^
	 */
	public QM001UpdateMasterTask() {
	}

	/**
	 * �R���X�g���N�^
	 */
	public QM001UpdateMasterTask(String version) {
		setVersion(version);
	}

	/**
	 * �o�[�W�����␳�^�X�N�Ǘ�
	 * 
	 * @param dbm
	 * @throws Exception
	 */
	public void adjustTask(ACDBManager dbm) throws Exception {

		try {
			// �\�h�Ń^�X�N
			task1(dbm);
			
			// [ID:0000749][Masahiko.Higuchi] add - begin 2012�N�x�Ή� �{�ݏ��̗����Ǘ��Ɋւ���f�[�^�␳
			task2(dbm);
			// [ID:0000749][Masahiko.Higuchi] add - end
			
		} catch (Exception ex) {
			throw ex;
		}
	}

	/**
	 * �X�֔ԍ��e�[�u����PRIMARY KEY�폜
	 * 
	 * @param dbm
	 *            DBManager
	 * @throws Exception
	 */
	public void task1(ACDBManager dbm) throws Exception {

		try {
			QM001UpdateMasterOperation op = new QM001UpdateMasterOperation();

			// �X�֔ԍ��e�[�u����PRIMARY KEY�폜���s
			op.dropPostPrimaryKey(dbm);

			// �R�~�b�g
			dbm.commitTransaction();

		} catch (Exception ex) {
			dbm.rollbackTransaction();
			throw ex;
		}
	}

	/**
	 * �{�ݏ�񗚗��Ǘ��ɔ����f�[�^�␳
	 * 
	 * @param dbm
	 *            DBManager
	 * @throws Exception
	 * @since V6.1.2
	 */
	public void task2(ACDBManager dbm) throws Exception {

		VRList historyList = new VRArrayList();
		QM001UpdateMasterOperation op = new QM001UpdateMasterOperation();

		// ���s���菈��
		try {
			// �s�v�ȃ��R�[�h�̕␳�폜
			dbm.executeUpdate(op.getSQL_DELETE_SHISETSU_HISTORY());
			// �R�~�b�g
			dbm.commitTransaction();
			
			historyList = dbm.executeQuery(op.getSQL_GET_SHISETSU_HISTORY());
			// �J�n�I���̓��t��NULL���R�[�h���擾�o���Ȃ��ꍇ�͏������f
			if (historyList.size() == 0) {
				return;
			}

		} catch (Exception ex) {
			// ���[���o�b�N
			dbm.rollbackTransaction();
		}

		// ���O�C���V�X�e�����t���擾
		Date systemDate = QkanSystemInformation.getInstance().getSystemDate();

		int startYear = ACDateUtilities.getYear(systemDate);
		int endYear = ACDateUtilities.getYear(systemDate);

		// 7�������E�ɂ��ĔN�x��؂�ւ���
		if (ACDateUtilities.getMonth(systemDate) < 7) {
			// 1�`6��
			startYear -= 1;
		} else {
			// 7�`12��
			endYear += 1;
		}
		// �J�n�ƏI���𐶐�
		Date validStartDate = ACDateUtilities.createDate(startYear, 7, 1);
		Date validEndTemp = ACDateUtilities.createDate(endYear, 6, 1);
		Date validEndDate = ACDateUtilities.toLastDayOfMonth(validEndTemp);

		// SQL�p�����[�^�̐ݒ�
		VRMap sqlParam = new VRHashMap();
		sqlParam.setData("SHISETSU_VALID_START", validStartDate);
		sqlParam.setData("SHISETSU_VALID_END", validEndDate);
		try {

			for (int i = 0; i < historyList.size(); i++) {
				VRMap historyData = (VRMap)historyList.get(i);
				sqlParam.setData("SHISETSU_HISTORY_ID",historyData.getData("SHISETSU_HISTORY_ID"));
				sqlParam.setData("PATIENT_ID",historyData.getData("PATIENT_ID"));
				// �A�b�v�f�[�g����
				dbm.executeUpdate(op
						.getSQL_UPDATE_SHISETSU_HISTORY_DATE(sqlParam));
			}
			
			// �R�~�b�g
			dbm.commitTransaction();

		} catch (Exception e) {
			dbm.rollbackTransaction();
			throw e;
		}

	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getVersion() {
		return this.version;
	}

}
