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
 * �J����: ����@��F
 * �쐬��: 2009/07/09  ���{�R���s���[�^�[������� ����@��F �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���уf�[�^�쐬 (P)
 * �v���Z�X ���׏��ڍוҏW (005)
 * �v���O���� ����f�Ô�R�[�h�ǉ� (QP005001)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qp.qp005;

import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.util.Date;
import java.util.Map;

import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.affair.QkanMessageList;

/**
 * ����f�Ô�R�[�h�ǉ�(QP005001) 
 */
public class QP005001 extends QP005001Event {
	/**
	 * �R���X�g���N�^�ł��B
	 */
	public QP005001() {
	}

	//�R���|�[�l���g�C�x���g

	/**
	 * �u�ǉ��v�C�x���g�ł��B
	 * @param e �C�x���g���
	 * @throws Exception ������O
	 */
	protected void addButtonActionPerformed(ActionEvent e) throws Exception {
		// �����̓`�F�b�N���s���܂��B
		// �����֐���p���ē��̓`�F�b�N���s���B
		if (!checkServiceCode(true)) {
			// �ُ�̏ꍇ
			// �G���[���b�Z�[�W���o�͂��������I������B
			return;
		}
		
		// ����̏ꍇ
		// �����𑱍s����B

		// ����ʂ̏�Ԃ��Ăяo�����ɕԂ�
		// values�ɉ�ʂ̒l���i�[����B
		getContents().setSource(getValues());
		getContents().applySource();
		// ���ݒ�ς݂Ƃ��ĕ���B
		// �ݒ�{�^�������������t���O��true�ɂ���B
		setIsAdd(true);
		// ��ʂ����B
		this.dispose();
	}

	/**
	 * �u�L�����Z���v�C�x���g�ł��B
	 * @param e �C�x���g���
	 * @throws Exception ������O
	 */
	protected void cancelButtonActionPerformed(ActionEvent e) throws Exception {
		// ���l�̏������{��ʂ����
		// values��null���i�[����B
		setValues(null);
		setIsAdd(false);
		// ��ʂ����
		this.dispose();
	}

	/**
	 * �u�T�[�r�X�R�[�h�ϊ��v�C�x���g�ł��B
	 * @param e �C�x���g���
	 * @throws Exception ������O
	 */
	protected void serviceCodeDetailTextFocusLost(FocusEvent e) throws Exception {
		//�T�[�r�X�R�[�h�̃`�F�b�N���s��
		checkServiceCode(false);
	}

	public static void main(String[] args) {
		//�f�t�H���g�f�o�b�O�N��
		ACFrame.getInstance().setFrameEventProcesser(
				new QkanFrameEventProcesser());
		QkanCommon.debugInitialize();
		VRMap param = new VRHashMap();
		//param�ɓn��p�����^���l�߂Ď��s���邱�ƂŁA�ȈՃf�o�b�O���\�ł��B
		ACFrame.debugStart(new ACAffairInfo(QP005001.class.getName(), param));
	}

	//�����֐�

	/**
	 * �u�������v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * @throws Exception ������O
	 */
	public void showModal(Date targetDate) throws Exception {
		// ����ʂ̏�����
		// �T�[�r�X�R�[�h�����[�V�����N���X�𐶐�����B
        setAffairTitle("QP005001");
		// targetDate�Ɉ�����ݒ肷��B
		//setTargetDate(ACCastUtilities.toDate(VRBindPathParser.get("TARGET_DATE", params)));
		setTargetDate(targetDate);
		
		// �@�����ϐ��Fvalues�Ƀ_�C�A���O���̃f�[�^���W�߂�
		// �@values�̒l��S�ď���������B
		// �@�_�C�A���O�ɑ΂���values��ݒ肷��B
		getContents().setSource(getValues());
		// �@�l���o�C���h����B�i�������j
		getContents().bindSource();
		
		this.setVisible(true);
	}
	
	
	public boolean checkServiceCode(boolean isMessageShow) throws Exception {
		// ���̓`�F�b�N���s���B
		if (!isValidData()){
			// �ُ�̏ꍇ
			// �T�[�r�X���̂ɋ󔒂�ݒ肷��B�i�������j
			getServiceNameText().setText("");
			// �G���[���b�Z�[�W��\������B
			if (isMessageShow) {
				QkanMessageList.getInstance().QP005_ERROR_OF_SERVICE_KIND();
			}
			// �����𒆒f����B
			return false;
		}
		// ����̏ꍇ
		// �����𑱍s����

		// �T�[�r�X�R�[�h���̒u���������s���B
		if (!setServiceCode()){
			// �ُ�̏ꍇ
			// �G���[���b�Z�[�W��\������B
			if (isMessageShow) {
				QkanMessageList.getInstance().QP005_ERROR_OF_SERVICE_NAME();
			}
			// �����𒆒f����B
			return false;
		}
		return true;
	}

	/**
	 * �u���̓`�F�b�N�v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * @throws Exception ������O
	 */
	public boolean isValidData() throws Exception {
		// �����̓`�F�b�N���s���܂��B
		// �T�[�r�X�R�[�h���ڔԍ��̃`�F�b�N
		// ������4���ȊO�̏ꍇ
		// false��Ԃ��B
		
		if (getServiceCodeDetailText().getText().length() != 4){
			return false;
		}
		return true;
	}

	/**
	 * �u�T�[�r�X�R�[�h���̒u�������v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * @throws Exception ������O
	 */
	public boolean setServiceCode() throws Exception {
		// ���T�[�r�X�R�[�h���̒u������
		// ���R�[�h sqlParam �ɉ��L��KEY�FVALUE��SQL�ɓn���ϐ���ݒ肷��B
		VRMap sqlParam = new VRHashMap();

		// KEY�FSERVICE_CODE_KIND�@VALUE�FserviceCodeKindLabel�̒l
		VRBindPathParser.set("SERVICE_CODE_KIND", sqlParam,
				getServiceCodeKindLabel().getText());

		// KEY�FSERVICE_CODE_ITEM�@VALUE�FserviceCodeDetailText�̒l
		VRBindPathParser.set("SERVICE_CODE_ITEM", sqlParam,
				getServiceCodeDetailText().getText());

		// KEY�FSERVICE_VALID_START�@VALUE�FtargetDate
		VRBindPathParser.set("TARGET_DATE", sqlParam, getTargetDate());

		// �T�[�r�X�R�[�h���̎擾�p��SQL���擾����B
		String query = getSQL_GET_SPECIAL_CLINIC_SERVICE_CODE(sqlParam);

		// SQL�𔭍s����B
		// SQL����擾�����f�[�^�����R�[�h�W���ɔ��f����B
		VRList lastInfoList = getDBManager().executeQuery(query);

		// �擾�������ʂ��ꌏ�ȏ�̏ꍇ
		if ((lastInfoList != null) && (lastInfoList.size() > 0)) {
			//serviceNameText �Ɏ擾�������̂�ݒ肷��B
			String serviceName = ((Map) lastInfoList.get(0)).get("SERVICE_NAME").toString();
			getServiceNameText().setText(serviceName);
			//true ��Ԃ��B
			return true;
		}

		// ���s�����ꍇ
		// �e�L�X�g������
		getServiceNameText().setText("");
		// false ��Ԃ��B
		return false;
	}

}
