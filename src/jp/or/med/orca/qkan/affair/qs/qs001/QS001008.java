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
 * �쐬��: 2012/08/07  ���{�R���s���[�^�[������� ����@��F �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �T�[�r�X�\�� (S)
 * �v���Z�X �J�����_�[ (001)
 * �v���O���� ����f�Ô�E���ʗ×{��W�v (QS001008)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.event.ListSelectionEvent;

import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.util.adapter.ACTableModelAdapter;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;

/**
 * ����f�Ô�E���ʗ×{��W�v(QS001008)
 */
public class QS001008 extends QS001008Event {
	/**
	 * �R���X�g���N�^�ł��B
	 */
	public QS001008() {
	}

	// �R���|�[�l���g�C�x���g

	/**
	 * �u����v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void closeActionPerformed(ActionEvent e) throws Exception {
		// ����ʂ����
		// �@��ʂ�j�����܂��B
		dispose();
	}

	/**
	 * �u�T�[�r�X��ރR���{�I���v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void serviceComboActionPerformed(ActionEvent e) throws Exception {
		// ���T�[�r�X��ރR���{�I��
		if (!getServiceCombo().isSelected() || !getProviderCombo().isSelected()) {
			return;
		}

		VRMap providerMap = (VRMap) getProviderCombo().getSelectedModelItem();
		VRMap serviceMap = (VRMap) getServiceCombo().getSelectedModelItem();
		VRList list = new VRArrayList();

		// key���̐���
		String providerID = ACCastUtilities.toString(
				providerMap.getData("PROVIDER_ID"), "");
		String systemServiceKindDetailValue = ACCastUtilities.toString(
				serviceMap.getData("SYSTEM_SERVICE_KIND_DETAIL"), "");
		String key = providerID + "-" + systemServiceKindDetailValue;

		// �L�[�m�F
		if (!getProviderDiagnosis().containsKey(key)) {
			return;
		}

		// ���X�g�Ɏ��o��
		list = (VRArrayList) getProviderDiagnosis().getData(key);

		// �e�[�u���Z�b�g
		getMainTableModel().setAdaptee(list);

		if (list.size() > 0) {
			getTokubetsuTable().setSelectedSortedFirstRow();
		}

	}

	/**
	 * �u����f�Ô�e�[�u���I���v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void tokubetsuTableSelectionChanged(ListSelectionEvent e)
			throws Exception {
		// ������f�Ô�e�[�u���I��
		// �@�I���s�̓���f�Ô�E���ʗ×{��̓����\�����܂��B

		VRMap selectMap = new VRHashMap();

		if (getTokubetsuTable().isSelected()) {
			selectMap = (VRMap) getTokubetsuTable().getSelectedModelRowValue();

			if (selectMap != null) {
				// �e�[�u���ɐݒ�
				getDetailTableModel().setAdaptee(
						(VRArrayList) selectMap.getData("DETAIL"));
			}
		}

	}

	public static void main(String[] args) {
		// �f�t�H���g�f�o�b�O�N��
		ACFrame.getInstance().setFrameEventProcesser(
				new QkanFrameEventProcesser());
		QkanCommon.debugInitialize();
		VRMap param = new VRHashMap();
		// param�ɓn��p�����^���l�߂Ď��s���邱�ƂŁA�ȈՃf�o�b�O���\�ł��B
		ACFrame.debugStart(new ACAffairInfo(QS001008.class.getName(), param));
	}

	// �����֐�

	/**
	 * �u�����ݒ�v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public void showModal(Map<String, Map> diagnosisDateMap, Date targetDate)
			throws Exception {
		// ����ʓW�J���̏����ݒ�
		// �@�擾���������e�[�u���ɐݒ肷��B
		// �@���E�B���h�E�^�C�g���̐ݒ�
		setAffairTitle("QS001008");

		setTargetDate(targetDate);

		VRList service = new VRArrayList();
		VRMap masterService = QkanCommon.getMasterService(getDBManager(),
				getTargetDate());

		String[] cuts = null;
		VRList providerList = new VRArrayList();
		VRMap providerMap = new VRHashMap();
		VRList providerTempList = new VRArrayList();

		for (Entry<String, Map> entry : diagnosisDateMap.entrySet()) {
			// [���Ə��ԍ�-�T�[�r�X��ރR�[�h]
			String key = entry.getKey();
			cuts = key.split("-");

			if (cuts.length != 2) {
				continue;
			}

			String providerID = cuts[0];
			Integer systemServiceKindDetail = ACCastUtilities.toInteger(
					cuts[1], 0);

			if (!getProviderService().containsKey(providerID)) {
				// �V�K
				service = new VRArrayList();
				service.add(masterService.getData(systemServiceKindDetail));
				getProviderService().setData(providerID, service);
				// ���Ə��̑ޔ�
				providerTempList = QkanCommon.getProviderInfo(getDBManager(),
						providerID);
				providerMap = (VRMap) providerTempList.get(0);
				providerList.add(providerMap);

			} else {
				service = (VRArrayList) getProviderService()
						.getData(providerID);
				service.add(masterService.getData(systemServiceKindDetail));
			}

			// �e�[�u���W�J���̐ݒ�
			// ����f�Ô�E���ʗ×{����
			Map<String, ArrayList<Map>> tokuteiMap = entry.getValue();
			// �ޔ�
			getProviderDiagnosis().setData(key, calcDiagnosis(tokuteiMap));

		}

		// �e�[�u�����f�����`����B
		ACTableModelAdapter mainTableModel = new ACTableModelAdapter();
		mainTableModel
				.setColumns(new String[] { "NAME", "NAME", "TOTAL_COUNT" });
		setMainTableModel(mainTableModel);

		// �ڍ׃e�[�u��
		ACTableModelAdapter detailTableModel = new ACTableModelAdapter();
		detailTableModel.setColumns(new String[] { "SERVICE_DATE",
				"DAY_IN_COUNT" });
		setDetailTableModel(detailTableModel);

		getTokubetsuTable().setModel(getMainTableModel());
		getDayDetailTable().setModel(getDetailTableModel());

		// ��ʓW�J�f�[�^�̐ݒ�
		VRMap modelMap = new VRHashMap();

		modelMap.setData("PROVIDER", providerList);
		getContents().setModelSource(modelMap);
		getContents().bindModelSource();

		if (getProviderService().size() > 0) {
			// 1�s�ڂ̑I��
			getProviderCombo().setSelectedIndex(0);
			// ��ʏ�Ԑ���
			setState_ENABLE_DIALOG_TRUE();

		} else {
			// ��ʏ�Ԑ���
			setState_ENABLE_DIALOG_FALSE();

		}

		// �\��
		setVisible(true);

	}

	/**
	 * �u���Ə��R���{�I�����v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void providerComboActionPerformed(ActionEvent e) throws Exception {

		VRList serviceList = new VRArrayList();
		VRMap modelMap = new VRHashMap();

		if (!getProviderCombo().isSelected()) {
			// ���I���Ȃ珈�����f
			return;
		}

		// �I�����Ə�����ΏۃT�[�r�X���擾
		VRMap providerInfo = (VRMap) getProviderCombo().getSelectedModelItem();
		String providerID = ACCastUtilities.toString(
				providerInfo.getData("PROVIDER_ID"), "");

		// �I������Ă��鎖�Ə��̃T�[�r�X���X�g��ݒ�
		serviceList = (VRArrayList) getProviderService().getData(providerID);

		// ��ʓW�J
		modelMap.setData("SERVICE", serviceList);
		getContents().setModelSource(modelMap);
		getContents().bindModelSource();

		if (serviceList.size() > 0) {
			getServiceCombo().setSelectedIndex(0);
		}

	}

	/**
	 * �u����f�Ô�E���ʗ×{��v�Z�v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @param ArrayList
	 *            <Map>> tokuteiMap Map<String,
	 * @throws Exception
	 *             ������O
	 * @return VRList
	 */
	public VRList calcDiagnosis(Map<String, ArrayList<Map>> tokuteiMap)
			throws Exception {

		VRMap detail = new VRHashMap();

		// ���C���e�[�u���f�[�^
		VRMap resultMap = new VRHashMap();
		VRList resultList = new VRArrayList();
		// �ڍ׃e�[�u���f�[�^
		VRMap resultDetailMap = new VRHashMap();
		VRList resultDetailList = new VRArrayList();

		for (Entry<String, ArrayList<Map>> tokuteiEntry : tokuteiMap.entrySet()) {

			String name = "";
			int count = 0;
			resultDetailList = new VRArrayList();

			// �W�v���ʂ̃��[�v
			ArrayList<Map> tokuteiList = (ArrayList) tokuteiEntry.getValue();
			for (int i = 0; i < tokuteiList.size(); i++) {
				detail = (VRHashMap) tokuteiList.get(i);
				count += ACCastUtilities.toInt(detail.getData("COUNT"), 0);
				name = ACCastUtilities.toString(detail.getData("NAME"), "");

				// �ڍ�
				resultDetailMap = new VRHashMap();
				resultDetailMap.setData("SERVICE_DATE",
						detail.getData("SERVICE_DATE"));
				resultDetailMap.setData("DAY_IN_COUNT",
						ACCastUtilities.toInt(detail.getData("COUNT"), 0));
				resultDetailList.add(resultDetailMap);

			}
			// ���ʂ̊i�[
			resultMap = new VRHashMap();
			resultMap.setData("NAME", name);
			resultMap.setData("TOTAL_COUNT", count);
			resultMap.setData("DETAIL", resultDetailList);

			resultList.add(resultMap);

		}

		return resultList;
	}

}
