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
 * �J����: �� ����
 * �쐬��: 2006/02/15  ���{�R���s���[�^�[������� �� ���� �V�K�쐬
 * �X�V��: 2014/10/23  MIS��B������� ���� ���̂�
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �\��Ǘ� (S)
 * �v���Z�X �T�[�r�X�\��E���� (001)
 * �v���O���� ���p�E�񋟕[��� (QS001003)
 *
 *****************************************************************
 */

package jp.or.med.orca.qkan.affair.qs.qs001;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

import jp.nichicom.ac.bind.ACBindUtilities;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.lib.care.claim.print.schedule.CareServiceCodeCalcurater;
import jp.nichicom.ac.lib.care.claim.print.schedule.CareServicePrintParameter;
import jp.nichicom.ac.lib.care.claim.print.schedule.CareServiceSchedulePrintManager;
import jp.nichicom.ac.lib.care.claim.servicecode.CareServiceCommon;
import jp.nichicom.ac.pdf.ACChotarouXMLUtilities;
import jp.nichicom.ac.pdf.ACChotarouXMLWriter;
import jp.nichicom.ac.text.ACBorderBlankDateFormat;
import jp.nichicom.ac.text.ACSQLSafeDateFormat;
import jp.nichicom.ac.text.ACSQLSafeIntegerFormat;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.ac.util.ACDateUtilities;
import jp.nichicom.ac.util.ACMessageBox;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.QkanConstants;
import jp.or.med.orca.qkan.QkanSystemInformation;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.affair.QkanMessageList;
import jp.or.med.orca.qkan.text.QkanJotaiCodeUnapplicableFormat;

/**
 * ���p�E�񋟕[���(QS001031)
 */
@SuppressWarnings("serial")
public class QS001003 extends QS001003Event {
	/**
	 * �R���X�g���N�^�ł��B
	 */
	public QS001003() {
	}

	// �R���|�[�l���g�C�x���g

	/**
	 * �u����T�[�r�X�쐬�ҕύX�v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void planManufacturerActionPerformed(ActionEvent e)
			throws Exception {
		// ������T�[�r�X�쐬�ҕύX���A������x�����ƎҎ��Ə����̗L��/������؂�ւ���
		// ������x�����ƎҎ��Ə����̗L��/������ݒ肷��B
		setProviderComponentState();
	}

	/**
	 * �u���Ə����ύX�v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void supportProviderNameActionPerformed(ActionEvent e)
			throws Exception {
		// ��������x�����ƎҎ��Ə����ύX���A���Ə��ԍ��A�y�ђS���҂�؂�ւ���
		// �����Ə��ԍ��̕ύX
		Object obj = getSupportProviderName().getSelectedItem();
		if (obj instanceof VRMap) {
			// ���ƎҔԍ����x��(supportProviderCd)�̒l�Ƃ��āA�I�����ꂽ���Ə��̎��Ə��ԍ���ݒ肷��B(���Ə������I�𓙂̗��R�ɂ��
			getSupportProviderCd().setText(
					ACCastUtilities.toString(
							VRBindPathParser.get("PROVIDER_ID", (VRMap) obj),
							""));
			// ���S���҃R���{�̃A�C�e���ύX
			// �S���҃R���{(personInCharge)�̃A�C�e���Ƃ��āA�I�����ꂽ���Ə��ɓo�^����Ă���S���҂�ݒ肷��B(���Ə������I�𓙂̗��R
			// �ɂ�莖�Ə��ԍ����擾�ł��Ȃ������ꍇ�A�S���҃R���{�̃A�C�e���͂Ȃ��Ƃ���)
			VRList staffs = getDBManager().executeQuery(
					getSQL_GET_STAFF((VRMap) obj));
			Iterator it = staffs.iterator();
			while (it.hasNext()) {
				Map staff = (Map) it.next();
				staff.put("STAFF_NAME", QkanCommon.toFullName(
						staff.get("STAFF_FAMILY_NAME"),
						staff.get("STAFF_FIRST_NAME")));
			}
			setSupporters(staffs);
			getPersonInCharge().setModel(getSupporters());
			// ���S���҃R���{�̏����I��
			// �I�����ꂽ���Ə��ŁA�ŗD��̒S���҂�I������i���Ə��ꗗ��ʂŕ\�������S���҂Ɠ����j�B(�ݒ�ł��Ȃ��ꍇ�͖��I���Ƃ���)
			if (getPersonInCharge().getItemCount() > 0) {
				getPersonInCharge().setSelectedIndex(0);
			}
		} else {
			// ���Ə��ԍ����擾�ł��Ȃ������ꍇ�A���Ə��ԍ��͖��I���Ƃ���)
			getSupportProviderCd().setText("");
			setSupporters(new VRArrayList(
					java.util.Arrays.asList(new Object[] {})));
			getPersonInCharge().setModel(getSupporters());
		}
	}

	/**
	 * �u���p�[/�񋟕[�̈���v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void printActionPerformed(ActionEvent e) throws Exception {
		// �����p�[(�ʕ\)/�񋟕[(�ʕ\)�̈�����s���B
		// �n��p�����[�^ printParam (���R�[�h)�𐶐����A���L�̒l��ݒ肷��B
		VRMap printParam = new VRHashMap();
		// KEY : PATIENT_ID, VALUE : (���p��ID)
		// KEY : TARGET_DATE, VALUE : (�Ώ۔N��)
		// KEY : SERVICE_DATA, VALUE : (���ԕ\���̃��R�[�h�W��)
		// KEY : PROCESS_TYPE, VALUE : (�����ϐ�processType�̒l)
		// KEY : SHORT_STAR_USE_DAY, VALUE : (�O���܂ł̒Z���������p��)
		// KEY : CREATE_DATE_OUTER, VALUE : (�g�O�̍쐬�N����)
		// KEY : CREATE_DATE_INNER, VALUE : (�g���̍쐬�N����)
		// ��������[�̔���
		// ����t���O�̏������̂��߁AprintParam�ɉ��L�̒l��ݒ肷��B
		// KEY : PRINT_MODE_USE, VALUE : 0
		// KEY : PRINT_MODE_USE_ANOTHER, VALUE : 0
		// KEY : PRINT_MODE_OFFER VALUE : 0
		// KEY : PRINT_MODE_OFFER_ANOTHER VALUE : 0
		// �u������钠�[�̑I���v�̒l���`�F�b�N����B
		// �u���p�[�E�ʕ\�v�̏ꍇ
		// printParam�ɉ��L�̒l��ݒ肷��B
		// KEY : PRINT_MODE_USE, VALUE : 1
		// KEY : PRINT_MODE_USE_ANOTHER, VALUE : 1
		// �u�񋟕[�E�ʕ\�v�̏ꍇ
		// printParam�ɉ��L�̒l��ݒ肷��B
		// KEY : PRINT_MODE_OFFER VALUE : 1
		// KEY : PRINT_MODE_OFFER_ANOTHER VALUE : 1
		// �u���p�[�v�̏ꍇ
		// printParam�ɉ��L�̒l��ݒ肷��B
		// KEY : PRINT_MODE_USE, VALUE : 1
		// �u�񋟕[�v�̏ꍇ
		// printParam�ɉ��L�̒l��ݒ肷��B
		// KEY : PRINT_MODE_OFFER VALUE : 1
		// �u�ʕ\�v�̏ꍇ
		// �u���[��ʑI���v�̒l���`�F�b�N����B
		// �u���p�[�v�̏ꍇ
		// printParam�ɉ��L�̒l��ݒ肷��B
		// KEY : PRINT_MODE_USE_ANOTHER, VALUE : 1
		// �u�񋟕[�v�̏ꍇ
		// printParam�ɉ��L�̒l��ݒ肷��B
		// KEY : PRINT_MODE_OFFER_ANOTHER VALUE : 1
		// ���W�v�E����N���X�ւ̒l�n��
		// ���ԕ\�����W�v���A��������s���邽�߂̃N���X�֒l��n���A������J�n����B

		// �ǉ��������W
		getContents().setSource(printParam);
		getContents().applySource();
		if (getSupportProvider().isSelected()
				|| getPreventSupportProvider().isSelected()) {
			// ���x���������P�A�v�������쐬�����ꍇ
			printParam.remove(getDateOfWrittenReport().getBindPath());
		} else {
			// ��ی��Ҏ��g�ŃP�A�v�������쐬�����ꍇ
			printParam.remove(getSupportProviderName().getBindPath());
			printParam.remove(getPersonInCharge().getBindPath());
		}

		// ����I�v�V�������`�F�b�N
		String mainFormat, subFormat;
		boolean printMain, printSub, printBackup, divedProvider;

		switch (getSlitType().getSelectedIndex()) {
		case 1:// ���p�[
			mainFormat = "QS001P02";
			subFormat = "QS001P03";
			printBackup = true;
			divedProvider = false;
			break;
		default: // �񋟕[
			mainFormat = "QS001P04";
			subFormat = "QS001P05";
			printBackup = false;
			divedProvider = true;
			break;
		}

		if (getProcessType() == QkanConstants.PROCESS_TYPE_RESULT) {
			// �\��̏ꍇ
			// �{�[
			printMain = true;
			printSub = false;
		} else {
			switch (getSlitKind().getSelectedIndex()) {
			case 1: // �{�[�ƕʕ\
				printMain = true;
				printSub = true;
				break;
			case 2: // �{�[
				printMain = true;
				printSub = false;
				break;
			default: // �ʕ\
				printMain = false;
				printSub = true;
				break;
			}
		}

		CareServiceSchedulePrintManager mng = new CareServiceSchedulePrintManager();
		mng.initialize(getCalcurater());
		mng.parse(getServiceData());
		mng.setBuildDivedProvider(divedProvider);
		
		// [2014�N�v�]][Shinobu Hitaka] 2014/10/23 add begin �h�̕\��
		switch (getSlitKeisyo().getSelectedIndex()) {
		case 1:
		    mng.setPrintKeisyo("�@�l");
		    break;
		case 2:
		    mng.setPrintKeisyo("�@�a");
		    break;
		default:
		    mng.setPrintKeisyo("");
		    break;
		}
		setProperty("PrintConfig/KeishoRadio", String.valueOf(getSlitKeisyo().getSelectedIndex()));
		saveProperty();
		// [2014�N�v�]][Shinobu Hitaka] 2014/10/23 add end   �h�̕\��

		CareServicePrintParameter buildParam = new CareServicePrintParameter();
		buildParam.setPrintParameter(printParam);

		boolean exists = false;
		List mainInsuredPages = null, subInsuredPages = null;
		ACChotarouXMLWriter writer = new ACChotarouXMLWriter();
		writer.beginPrintEdit();
		if (printMain) {
			// �{�[�����\�z

			if (getProcessType() == QkanConstants.PROCESS_TYPE_RESULT) {
				// ���у��[�h�Ȃ�Γ����̗\����{�[�ɕ��ׂ�
				VRList list = QkanCommon.getServiceDetail(getDBManager(),
						getPatientID(), getTargetDateSource(),
						QkanConstants.SERVICE_DETAIL_GET_PLAN_OF_MONTHLY_ONLY);
				mng.addParse(list, false);
			}

			mainInsuredPages = new ArrayList();
			exists |= mng.buildUserMainTable(buildParam, mainInsuredPages);

			ACChotarouXMLUtilities.addFormat(writer, mainFormat, mainFormat
					+ ".xml");

		}

		if (printSub) {
			// �ʕ\���
			subInsuredPages = new ArrayList();
			ACChotarouXMLUtilities.addFormat(writer, subFormat, subFormat
					+ ".xml");
			exists |= mng.buildUserSubTable(buildParam, subInsuredPages);

		}

		if (!exists) {
			// �󒠕[
			if (buildParam.getPages() == null) {
				QkanMessageList.getInstance().QS001_ERROR_OF_EMPTY_PRINT();
				dispose();
				return;
			}
			if (QkanMessageList.getInstance().QS001_WARNING_OF_BLANK_PAGE() != ACMessageBox.RESULT_OK) {
				dispose();
				return;
			}
		}

		print(writer, buildParam, printMain, mainFormat, mainInsuredPages,
				new HashMap(), printSub, subFormat, subInsuredPages);

		if (printBackup && printMain) {
			// �T����

			// �{�[���
			HashMap allTexts = new HashMap();
			allTexts.put("chohyoType.h1.w1", "������x�����Ǝ�(�T)");

			print(writer, buildParam, printMain, mainFormat, mainInsuredPages,
					allTexts, printSub, subFormat, subInsuredPages);

		}

		writer.endPrintEdit();

		ACChotarouXMLUtilities.openPDF(writer);

		// ���������Ȃ��ꍇ�̓R�����g�A�E�g
		// dispose();
	}

	/**
	 * �u����v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @param writer
	 *            ACChotarouXMLWriter
	 * @param buildParam
	 *            QS001ServicePrintParameter
	 * @param printMain
	 *            , String mainFormat, List mainInsuredPages boolean
	 * @param allTexts
	 *            HashMap
	 * @param printSub
	 *            , String subFormat, List subInsuredPages boolean
	 * @throws Exception
	 *             ������O
	 * 
	 */
	public void print(ACChotarouXMLWriter writer,
			CareServicePrintParameter buildParam, boolean printMain,
			String mainFormat, List mainInsuredPages, HashMap allTexts,
			boolean printSub, String subFormat, List subInsuredPages)
			throws Exception {
		if (printMain) {
			if (printSub) {
				// �{�\�ƕʕ\
				int end = Math.min(mainInsuredPages.size(),
						subInsuredPages.size());
				for (int i = 0; i < end; i++) {
					List mainPages = (List) mainInsuredPages.get(i);
					List subPages = (List) subInsuredPages.get(i);
					Iterator subIt = subPages.iterator();
					while (subIt.hasNext()) {
						// ���C�����Ə��P��
						// �{�[���
						printMainTable(writer, mainFormat, mainPages,
								buildParam.getInvisibles(), allTexts);

						// �ʕ\���
						List prov = (List) subIt.next();
						printSubTable(writer, subFormat, prov);
					}
				}
			} else {
				// �{�\�̂�
				int end = mainInsuredPages.size();
				for (int i = 0; i < end; i++) {
					List mainPages = (List) mainInsuredPages.get(i);

					printMainTable(writer, mainFormat, mainPages,
							buildParam.getInvisibles(), allTexts);
				}
			}
		} else if (printSub) {
			// �ʕ\�̂�
			int end = subInsuredPages.size();
			for (int i = 0; i < end; i++) {
				List subPages = (List) subInsuredPages.get(i);
				// �ʕ\���
				Iterator subIt = subPages.iterator();
				while (subIt.hasNext()) {
					// ���C�����Ə��P��
					List prov = (List) subIt.next();
					printSubTable(writer, subFormat, prov);
				}
			}
		}
	}

	/**
	 * �u�ʕ\����v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @param writer
	 *            ACChotarouXMLWriter
	 * @param mng
	 *            QS001ServicePrintTableManager
	 * @param subFormat
	 *            String
	 * @param pages
	 *            List
	 * @throws Exception
	 *             ������O
	 */
	public void printSubTable(ACChotarouXMLWriter writer, String subFormat,
			List pages) throws Exception {
		// ���ʕ\��������܂��B

		Iterator it = pages.iterator();
		while (it.hasNext()) {
			// �y�[�W�o�͂��J�n����B
			writer.beginPageEdit(subFormat);

			// �y�[�W�P�ʂň󎚓��e���ύX����鍀�ڂ��o�͂���B
			Map texts = (Map) it.next();
			Iterator it2 = texts.entrySet().iterator();
			while (it2.hasNext()) {
				Map.Entry ent = (Map.Entry) it2.next();
				ACChotarouXMLUtilities.setValue(writer,
						ACCastUtilities.toString(ent.getKey()),
						ACCastUtilities.toString(ent.getValue()));

			}
			// �y�[�W�o�͂��I������B
			writer.endPageEdit();
		}
	}

	/**
	 * �u�{�[����v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @param writer
	 *            ACChotarouXMLWriter
	 * @param mng
	 *            QS001ServicePrintTableManager
	 * @param mainFormat
	 *            String
	 * @param pages
	 *            List
	 * @param invisibles
	 *            , Map allTexts List
	 * @throws Exception
	 *             ������O
	 */
	public void printMainTable(ACChotarouXMLWriter writer, String mainFormat,
			List pages, List invisibles, Map allTexts) throws Exception {
		// ���{�[��������܂��B

		Iterator it = pages.iterator();
		while (it.hasNext()) {
			// �y�[�W�o�͂��J�n����B
			writer.beginPageEdit(mainFormat);

			// �S�y�[�W��\���ɂ��鍀�ڂ���������B
			Iterator it2 = invisibles.iterator();
			while (it2.hasNext()) {
				ACChotarouXMLUtilities.setInvisible(writer,
						ACCastUtilities.toString(it2.next()));
			}

			// �y�[�W�P�ʂň󎚓��e���ύX����鍀�ڂ��o�͂���B
			Map texts = (Map) it.next();
			it2 = texts.entrySet().iterator();
			while (it2.hasNext()) {
				Map.Entry ent = (Map.Entry) it2.next();
				ACChotarouXMLUtilities.setValue(writer,
						ACCastUtilities.toString(ent.getKey()),
						ACCastUtilities.toString(ent.getValue()));

			}

			// �S�y�[�W�󎚂��鍀�ڂ��o�͂���B
			it2 = allTexts.entrySet().iterator();
			while (it2.hasNext()) {
				Map.Entry ent = (Map.Entry) it2.next();
				ACChotarouXMLUtilities.setValue(writer,
						ACCastUtilities.toString(ent.getKey()),
						ACCastUtilities.toString(ent.getValue()));
			}

			// �y�[�W�o�͂��I������B
			writer.endPageEdit();
		}
	}

	public static void main(String[] args) {
		// �f�t�H���g�f�o�b�O�N��
		ACFrame.getInstance().setFrameEventProcesser(
				new QkanFrameEventProcesser());
		QkanCommon.debugInitialize();
		VRMap param = new VRHashMap();
		// param�ɓn��p�����^���l�߂Ď��s���邱�ƂŁA�ȈՃf�o�b�O���\�ł��B
		ACFrame.debugStart(new ACAffairInfo(QS001003.class.getName(), param));
	}

	// �����֐�

	/**
	 * �u��ʓW�J���C�x���g�v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @param patientID
	 *            int
	 * @param targetDate
	 *            Date
	 * @param serviceData
	 *            VRList
	 * @param processType
	 *            int
	 * @param patientInsureInfoHistoryList
	 *            VRList
	 * @param inSpecialFacilityFlag
	 *            int
	 * @throws Exception
	 *             ������O
	 */
	public void showModal(CareServiceCodeCalcurater calcurater,
			VRList serviceData, int processType) throws Exception {
		// ���e�평���l�E������Ԃ�ݒ肷��
		// ���n��p�����[�^�̑ޔ�
		// calcurater�ɁA�n��p�����[�^�� calcurater ��ݒ肷��B
		setCalcurater(calcurater);
		// serviceData�ɁA�n��p�����[�^�� serviceData ��ݒ肷��B
		setServiceData(serviceData);
		// processType�ɁA�n��p�����[�^�� processType ��ݒ肷��B
		setProcessType(processType);

		// ���p�Ҏ���
		getPatentName().setText(calcurater.getPatientFullName());
		// �Ώ۔N��
		getServiceYearMonth().setText(calcurater.getTextOfTargetYearMonth());

		// �������l�̐ݒ�
		// ��ʂ̏����l��ݒ肷��B
		setInitValue();

		// ��������Ԃ̐ݒ�
		// ��ʂ̏�����Ԃ�ݒ肷��B
		setInitState();

		setVisible(true);
	}

	/**
	 * �u�����l�ݒ�v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public void setInitValue() throws Exception {
		// �������l�ݒ�
		// ��������
		// �����̗v���x�������i�[�p���R�[�h patientInsureInfoFirst �𐶐�����B
		VRMap patientInsureInfoFirst = null;
		// �����̗v���x�������i�[�p���R�[�h patientInsureInfoLast �𐶐�����B
		VRMap patientInsureInfoLast = null;
		// �ł��d���v���x�������i�[�p���R�[�h patientInsureInfoHeaviest �𐶐�����B
		VRMap patientInsureInfoHeaviest = null;

		if (!getPatientInsureInfoHistoryList().isEmpty()) {
			// patientInsureInfoFirst�ɁApatientInsureInfoHistoryList�̍ŏ��̃��R�[�h��ݒ肷��B
			patientInsureInfoFirst = (VRMap) getPatientInsureInfoHistoryList()
					.get(0);
			// patientInsureInfoLast�ɁApatientInsureInfoHistoryList�̍Ō�̃��R�[�h��ݒ肷��B
			patientInsureInfoLast = (VRMap) getPatientInsureInfoHistoryList()
					.get(getPatientInsureInfoHistoryList().size() - 1);
			// patientInsureInfoHeaviest�ɁA�ł��d���v���x��������ݒ肷��B
			patientInsureInfoHeaviest = QkanCommon
					.getPatientInsureInfoOnMostHeavy(getPatientInsureInfoHistoryList());
		}
		// ���E�B���h�E�^�C�g���̐ݒ�
		// �Ɩ���񃌃R�[�h���擾����B
		// �E�B���h�E�^�C�g���ɁA�擾���R�[�h��KEY : WINDOW_TITLE��VALUE��ݒ肷��B
		setAffairTitle("QS001003");
		// ������T�[�r�X�񋟎�
		// �R���{�̃A�C�e���Ƃ��āA������x�����Ǝ҂�ݒ肷��B
		// [ID:0000724][Masahiko.Higuchi] 2012/04 ����24�N4���@�����Ή� del begin
		// setSupportProviders(QkanCommon.getProviderInfo(getDBManager(), new
		// int[]{14311, 17311}));
		// [ID:0000724][Masahiko.Higuchi] 2012/04 ����24�N4���@�����Ή� del end
		// [ID:0000724][Masahiko.Higuchi] 2012/04 ����24�N4���@�����Ή� add begin
		setSupportProviders(QkanCommon.getProviderInfo(getDBManager(),
				new int[] { 14311, 17311, 17711 }));
		// [ID:0000724][Masahiko.Higuchi] 2012/04 ����24�N4���@�����Ή� add end
		// 2016/8/3 [�������ƑΉ�][Shinobu Hitaka] mod - begin AF:�\�h�P�A�}�l�W�����g��ǉ�
		//setPreventSupportProviders(QkanCommon.getProviderInfo(getDBManager(),
		//		new int[] { 14611, 17511 }));
		setPreventSupportProviders(QkanCommon.getProviderInfo(getDBManager(),
				new int[] { 14611, 17511, 51511 }));
		// 2016/8/3 [�������ƑΉ�][Shinobu Hitaka] mod - end

		getSupportProviderName().setModel(getSupportProviders());
		// �R���{�̑I�����ڂƂ��āA���p�ҏ����擾�����u����T�[�r�X�񋟎ҁv��ݒ肷��B

		VRMap defaultInsurer = patientInsureInfoLast;
		if (defaultInsurer == null) {
			defaultInsurer = patientInsureInfoFirst;
		}

		int planner = 2;
		Object defaultProvider = null;
		if (defaultInsurer != null) {
			defaultProvider = defaultInsurer.get("PROVIDER_ID");
			planner = ACCastUtilities.toInt(defaultInsurer.get("PLANNER"), 2);
			if (planner <= 0) {
				planner = 2;
			}
		}

		// ������x���n�T�[�r�X�𒊏o����
		VRMap careManagementService = null;
		Object supporterID = null;
		Iterator it = getServiceData().iterator();
		while (it.hasNext()) {
			VRMap row = (VRMap) it.next();
			if (CareServiceCommon.isCareManagement(row)
					|| CareServiceCommon.isFacilityVisitMultifunction(row)) {
				// ������x���T�[�r�X���X�V����
				careManagementService = row;
			}
		}
		// ������x������
		if (careManagementService != null) {
			defaultProvider = VRBindPathParser.get("PROVIDER_ID",
					careManagementService);
			if (CareServiceCommon.isPreventService(careManagementService)) {
				// �\�h�T�[�r�X�̏ꍇ
				planner = 3;
				if (CareServiceCommon
						.isFacilityVisitMultifunction(careManagementService)) {
					// ���\�h���K�͑��@�\�^������
					supporterID = VRBindPathParser.get("1750104",
							careManagementService);
				} else {
					// ���\�h�x����
					if (VRBindPathParser.has("1460103", careManagementService)) {
						// �ϑ�������ԍ�����`����Ă���ꍇ
						supporterID = VRBindPathParser.get("1460103",
								careManagementService);
					} else {
						supporterID = VRBindPathParser.get("1430107",
								careManagementService);
					}
					if (VRBindPathParser.has("1460102", careManagementService)) {
						// �ϑ��掖�Ə�����`����Ă���ꍇ
						Object provID = VRBindPathParser.get("1460102",
								careManagementService);
						if (!ACTextUtilities.isNullText(provID)) {
							defaultProvider = provID;
						}
					}
				}
			} else {
				// �\�h�T�[�r�X�ł͂Ȃ��ꍇ
				planner = 1;
				if (CareServiceCommon
						.isFacilityVisitMultifunction(careManagementService)) {
					// ���K�͑��@�\�^
					supporterID = VRBindPathParser.get("1730104",
							careManagementService);
				} else {
					// ������x��
					supporterID = VRBindPathParser.get("1430107",
							careManagementService);
				}
			}
		}

		getPlanManufacturer().setSelectedIndex(planner);
		if (getPatent().isSelected()) {
			// ��ی��Ҏ��g�ŃP�A�v�������쐬�����ꍇ
			// �����̗v���F�藚������͏o�����擾
			VRMap history;
			if (patientInsureInfoLast != null) {
				history = patientInsureInfoLast;
			} else {
				history = patientInsureInfoFirst;
			}
			if (history != null) {
				Date reportDay = ACCastUtilities.toDate(
						history.get("REPORTED_DATE"), null);
				if (reportDay != null) {
					// �͏o�����ݒ肳��Ă���Γ]�L
					getDateOfWrittenReport().setDate(reportDay);
				}
			}
			if (getSupportProviderName().getItemCount() > 0) {
				getSupportProviderName().setSelectedIndex(0);
			}
		}

		if (defaultProvider != null) {
			VRList providers;
			if (getPreventSupportProvider().isSelected()) {
				// �\�h������x��
				providers = getPreventSupportProviders();
			} else {
				// ������x��
				providers = getSupportProviders();
			}
			int index = ACBindUtilities.getMatchIndexFromValue(providers,
					"PROVIDER_ID", defaultProvider);
			getSupportProviderName().setSelectedIndex(index);

			if ((supporterID != null) && (getSupporters() != null)) {
				// ���x�������ԍ�����
				index = ACBindUtilities.getMatchIndexFromValue(getSupporters(),
						"CARE_MANAGER_NO", supporterID);
				if (index > 0) {
					getPersonInCharge().setSelectedIndex(index);
				}
			}
		}

		// ��������x�����ƎҎ��Ə���
		// ���I���Ƃ���B
		// ���쐬�N����(�g�O/�ʕ\)
		// �V�X�e�����t��ݒ肷��B
		getDateOfMakingOutsideFrame().setDate(
				QkanSystemInformation.getInstance().getSystemDate());
		// ���쐬�N����
		// �V�X�e�����t��ݒ肷��B
		getDateOfMaking().setDate(
				QkanSystemInformation.getInstance().getSystemDate());
		// ���͏o�N����
		// �����l�͐ݒ肵�Ȃ��B

//2015/4/15 [H27.04�����Ή�][Yoichiro Kamei] mod - begin �Z�����������̏����l�Ή�
        boolean isShortStayCountZero = false;//�Z����������0�ƕ\�����邩�ǂ���
        
        Date first = ACCastUtilities.toDate(
                patientInsureInfoFirst.get("INSURE_VALID_START"), null);
        Date last = ACCastUtilities.toDate(
                patientInsureInfoLast.get("INSURE_VALID_START"), null);
        
        // ���v����ԋ敪
        // patientInsureInfoFirst���u�v����ԋ敪�v�����擾���A��ʂ�youKaigodoType1�ɐݒ肷��B
        Object firstCode = patientInsureInfoFirst.get("JOTAI_CODE");
        getYouKaigodoType1().setText(
                        QkanJotaiCodeUnapplicableFormat.getInstance().format(firstCode));
        
        //�Ώی��ɕ����̉��ی����̓o�^������ꍇ
        if (patientInsureInfoFirst != patientInsureInfoLast) {
            Object lastCode = patientInsureInfoLast.get("JOTAI_CODE");
            // patientInsureInfoLast���u�v����ԋ敪�v�����擾���A��ʂ�youKaigodoType2�ɐݒ肷��B
            if ((firstCode == null) || (!firstCode.equals(lastCode))) {
                getYouKaigodoType2().setText(
                        QkanJotaiCodeUnapplicableFormat.getInstance().format(lastCode));
                // �v���x���؂�ւ��ꍇ�̒Z������������0
                isShortStayCountZero = true;
            }
            // �F��L������(�J�n)���ς��ꍇ���Z������������0
            if (first != null && last != null) {
               if (ACDateUtilities.compareOnDay(first, last) != 0) {
                   isShortStayCountZero = true;
               }
            }
        }
        
        int shortStayCount = 0;
        //�Ώی��ōŐV�̉��ی����ɂ��āA�Z�����������̏����l���擾
        if (!isShortStayCountZero && last != null) {
            // �F��̗L�����ԊJ�n����Ώ۔N���O�������ς��܂ł̒Z�������T�[�r�X
            VRMap param = new VRHashMap();
            param.setData("TARGET_DATE", getTargetDateSource());
            param.setData("INSURE_VALID_START", last);
            param.setData("PATIENT_ID", new Integer(getPatientID()));
            shortStayCount = getPreviewShortStay(param);

            int initShortStayCount = ACCastUtilities.toInt(
                    patientInsureInfoLast.get("SHORTSTAY_USE_INIT_COUNT"), 0);
            if (initShortStayCount > 0) {
                //���l�Ƃ��ďo��
                String biko = " �i�����l�F" + String.valueOf(initShortStayCount)
                            + " �{ ���ђl�F" + String.valueOf(shortStayCount) + "�j";
                getShortStayUseDayBiko().setText(biko);
                //���ђl�ɏ����l�𑫂�
                shortStayCount += initShortStayCount;
            }
        }
//2015/4/15 [H27.04�����Ή�][Yoichiro Kamei] mod - end
		getShortStayUseDay().setText(String.valueOf(shortStayCount));

		// ���x�����x��z
		// patientInsureInfoHeaviest���u�x�����x��z�v�����擾���A�ݒ肷��B
		getLimitAmountContent().setText(
				ACCastUtilities.toString(
						patientInsureInfoHeaviest.get("LIMIT_RATE"), ""));
		// �����x�z�K�p����
		// patientInsureInfoHeaviest���u���x�z�K�p���ԁv�����擾���A�ݒ肷��B
		ACBorderBlankDateFormat yearMonthFormat = new ACBorderBlankDateFormat(
				"ggge�NMM��");
		getApplicationPeriodBegin().setText(
				yearMonthFormat.format(ACCastUtilities.toDate(
						patientInsureInfoHeaviest.get("INSURE_VALID_START"),
						null)));
		
		
// 2016/7/19 [�������ƑΉ�][Yoichiro Kamei] mod - begin
//		getApplicationPeriodEnd()
//		.setText(
//				yearMonthFormat.format(ACCastUtilities.toDate(
//						patientInsureInfoHeaviest
//								.get("INSURE_VALID_END"), null)));
		Date endDate = ACCastUtilities.toDate(
				patientInsureInfoHeaviest
				.get("INSURE_VALID_END"), null);
		
	    // 9999-12-31�̂Ƃ��͋󗓂�\��
		if (ACCastUtilities.toDate("9999/12/31").equals(endDate)) {
			getApplicationPeriodEnd().setText("");
		} else {
			getApplicationPeriodEnd().setText(yearMonthFormat.format(endDate));
		}
// 2016/7/19 [�������ƑΉ�][Yoichiro Kamei] mod - end

		// ���O���܂ł̒Z���������p����(�v���x�F����Ԓ��̑O���܂ł̒Z�������n�T�[�r�X���щ񐔂��J�E���g)
		// ���v���x�̗L�����Ԃ��擾����B
		// �L�����ԊJ�n���i�[�p�̓����ϐ� insureValidStart �𐶐�����B
		Date insureValidStart = null;
		// �L�����ԏI�����i�[�p�̓����ϐ� insureValidEnd �𐶐�����B
		Date insureValidEnd = null;
		// patientInsureInfoFirst����L�����ԊJ�n(KEY :
		// INSURE_VALID_START)���擾���AinsureValidStart�ɐݒ肷��B
		// insureInvalidEnd�ɁA�Ώ۔N���̑O��������ݒ肷��B(���� = �N��:targetDate�̈��(������) �}�C�i�X
		// 1���Ȃ�)
		// ���L�����ԓ��̃T�[�r�X���я����擾����B
		// �T�[�r�X�ڍ׏��擾�֐��ւ̓n��p�����[�^ params(������)�𐶐����A���L�̒l��ݒ肷��B
		String params = null;
		// params =
		// "PATIENT_ID=" + patientID +
		// "SERVICE_DATE>=" + insureValidStart +
		// "SERVICE_DATE<=" + insureValidEnd
		// "SERVICE_USE_TYPE=6" //�J�n�����Ȏ���
		// �L�����ԓ��̃T�[�r�X���я����擾����B
		// QkanCommon.getServiceDetailCustom(getDBManager(), params);
		// ���O���܂ł̒Z���������p�����̏W�v
		// �擾�������я�񂩂�A�Z���������p�������J�E���g����B
		// �E�T�[�r�X��ނ�21�A22�A23�̃T�[�r�X���J�E���g�ΏۂƂ���
		// �E�u30�����v���ݒ肳��Ă�����̂̓J�E���g���Ȃ�
		// �E��������2�ȏ�̃T�[�r�X���т������Ă��A�u1���v�Ƃ��ăJ�E���g����
		// ��)
		// �񋟓��i�[�p�̃��R�[�h�W�� offerDates �𐶐�����B
		// ���я�񃌃R�[�h�W����n�Ԗڂ̃��R�[�h�ޔ�p�̃��R�[�h rec�𐶐�����B
		// �u30�����v�`�F�b�N�p�̐��l over30 �𐶐�����B
		// �`�F�b�N�Ώۂ̃T�[�r�X���ђ񋟓��i�[�p�̓��t serviceDate�𐶐�����B
		// ���p�����i�[�p�̐��l usedDayCount�𐶐����A0�ŏ���������B
		// �擾�������я�񕪃��[�v����B
		// ���я�񃌃R�[�h�W����n�Ԗڂ̃��R�[�h�� rec �ɑޔ�����B
		// ���T�[�r�X��ނ̃`�F�b�N / �u30�����v�`�F�b�N
		// rec �� KEY : SYSTEM_SERVICE_KIND_DETAIL �� VALUE �ŕ��򂷂�B
		// 12101
		// over30�ɁArec �� KEY : 1210113 �� VALUE ��ݒ肷��B
		// 12201
		// over30�ɁArec �� KEY : 1220114 �� VALUE ��ݒ肷��B
		// 12301
		// over30�ɁArec �� KEY : 1230152 �� VALUE ��ݒ肷��B
		// 12302
		// over30�ɁArec �� KEY : 1230250 �� VALUE ��ݒ肷��B
		// 12303
		// over30�ɁArec �� KEY : 1230349 �� VALUE ��ݒ肷��B
		// 12304
		// over30�ɁArec �� KEY : 1230408 �� VALUE ��ݒ肷��B
		// ��L�ȊO�̏ꍇ
		// ���̃��[�v�֔�ԁB
		// over30�̒l���`�F�b�N����B
		// 0(30�����łȂ�)�̏ꍇ
		// �������p������B
		// 1(30�����ł���)�̏ꍇ
		// ���̃��[�v�֔�ԁB
		// ���J�E���g����
		// serviceDate��rec�� KEY : SERVICE_DATE �� VALUE ��ݒ肷��B
		// ���ɃJ�E���g�������t���ǂ����`�F�b�N���邽�߂ɁAofferDates�̌��������[�v����B
		// serviceDate��offerDates��n�Ԗڂ̓��t�Ƃ��r����B
		// �������ꍇ
		// ����rec�̃��[�v�֔�ԁB
		// �������Ȃ��ꍇ
		// offerDates�̃��[�v���p������B
		// �ǂ�offerDates�Ƃ��d�������Ƀ��[�v�𔲂���serviceDate�Ɋւ��āA���L�̏������s���B
		// usedDayCount��1���₷�B
		// offerDates��serviceDate��ǉ�����B
		// �擾�����T�[�r�X���p��������ʂ́u�Z�L�������p����(shortStayUseDay)�v�ɐݒ肷��B
		// ��������܂񂾋��t���ŕʕ\���쐬
		// ���I���Ƃ���B
		// �����[��ʑI��
		// ��������钠�[�̎��
		getSlitType().setSelectedIndex(1);
		getSlitKind().setSelectedIndex(1);
		
		//[2014�N�v�]][Shinobu Hitaka] 2014/10/23 add begin �h�̂��󎚂���
		// �ݒ�t�@�C����PrintConfig-KeishoRadio��1�̏ꍇ
		int keisyoIndex = 1;
		if (ACFrame.getInstance().hasProperty("PrintConfig/KeishoRadio")) {
			String strKeisyo = getProperty("PrintConfig/KeishoRadio");
			if ("2".equals(strKeisyo)) {
				keisyoIndex = 2;
			} else if ("3".equals(strKeisyo)) {
				keisyoIndex = 3;
			}
		}
		getSlitKeisyo().setSelectedIndex(keisyoIndex);
		//getKeisyo().setVisible(false);
		//[2014�N�v�]][Shinobu Hitaka] 2014/10/23 add end   �h�̂��󎚂���

	}

	/**
	 * �u��ʂ̏�����Ԃ̐ݒ�v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public void setInitState() throws Exception {
		// ����ʂ̏�����Ԃ�ݒ�
		// ��������x�����ƎҎ��Ə����̗L��/�����ݒ�
		// ������x�����ƎҎ��Ə����̗L��/������ݒ肷��B
		// setProviderComponentState();

		// ���\�����Ȃ̂��A���ш���Ȃ̂��ɂ���āA��Ԃ�ݒ�
		// processType�̒l���`�F�b�N����B
		if (getProcessType() == QkanConstants.PROCESS_TYPE_PLAN) {
			// PROCESS_TYPE_PLAN�̏ꍇ
			// �u������܂񂾋��t���ŕʕ\���쐬�v�`�F�b�N�{�b�N�X�A�u���[��ށv�O���[�v��\������B
			setState_PROCESS_TYPE_PLAN();
		} else {
			// PROCESS_TYPE_RESULT�̏ꍇ
			// �u������܂񂾋��t���ŕʕ\���쐬�v�`�F�b�N�{�b�N�X�A�u���[��ށv�O���[�v���\���ɂ���B
			setState_PROCESS_TYPE_RESULT();
		}

	}

	/**
	 * �u������x�����ƎҎ��Ə����̏�Ԑݒ�v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public void setProviderComponentState() throws Exception {
		// ��������x�����ƎҎ��Ə����̗L��/�����̐ؑ�
		// ��������x�����ƎҎ��Ə����̗L��/�����ݒ�
		// planManufacturer�̒l���`�F�b�N����B
		switch (getPlanManufacturer().getSelectedIndex()) {
		case 1:
			// �u������x�����Ǝҁv���I������Ă���ꍇ
			// ������x�����ƎҎ��Ə�����L���ɂ���B
			setState_PROVIDER_MADE();
			// ������x�����ƎҎ��Ə��̌���������x����񋟂��Ă��鎖�Ə��ɕύX����B
			getSupportProviderName().setModel(getSupportProviders());
			if (getSupportProviderName().getItemCount() > 0) {
				getSupportProviderName().setSelectedIndex(0);
			} else {
				getSupportProviderName().setSelectedIndex(-1);
			}
			break;
		case 3:
			// �u�\�h������x�����Ǝҁv���I������Ă���ꍇ
			// ������x�����ƎҎ��Ə�����L���ɂ���B
			setState_PROVIDER_MADE();
			// ������x�����ƎҎ��Ə��̌���\�h������x����񋟂��Ă��鎖�Ə��ɕύX����B
			getSupportProviderName().setModel(getPreventSupportProviders());
			if (getSupportProviderName().getItemCount() > 0) {
				getSupportProviderName().setSelectedIndex(0);
			} else {
				getSupportProviderName().setSelectedIndex(-1);
			}
			break;
		default:
			// �u������x�����Ǝҁv���I������Ă��Ȃ��ꍇ
			// ������x�����ƎҎ��Ə����𖳌��ɂ���B
			setState_SELF_MADE();
			break;
		}

	}

	/**
	 * �u����v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void endActionPerformed(ActionEvent e) throws Exception {
		dispose();
	}

	/**
	 * �u���p��ID�擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 * @return int
	 */
	public int getPatientID() throws Exception {
		return getCalcurater().getPatientID();
	}

	/**
	 * �u��������҃t���O���擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 * @return int
	 */
	public int getInSpecialFacilityFlag() throws Exception {
		return getCalcurater().getInSpecialFacilityFlag();
	}

	/**
	 * �u�Ώ۔N���擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 * @return Date
	 */
	public Date getTargetDateSource() throws Exception {
		return getCalcurater().getTargetDate();
	}

	/**
	 * �u�v���F�藚���擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 * @return VRList
	 */
	public VRList getPatientInsureInfoHistoryList() throws Exception {
		return getCalcurater().getPatientInsureInfoHistoryList();
	}

	/**
	 * �u�T�[�r�X��ޏW���擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 * @return VRList
	 */
	public VRList getServiceKindsList() throws Exception {
		return getCalcurater().getServiceKindsList();
	}

	/**
	 * �u���Ə����n�b�V���擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 * @return VRMap
	 */
	public VRMap getHashedProviders() throws Exception {
		return getCalcurater().getHashedProviders();
	}

	/**
	 * �O���܂ł̒Z���������p���������я����擾���܂��B
	 * ���������A30�����̃T�[�r�X�ɂ��Ă͊܂܂Ȃ��B
	 * 
	 * @author n0158 Masahiko.Higuchi
	 * @since V6.1.4
	 * [ID:0000764] 30�����T�[�r�X�ʕ\�󎚏�Q�Ή��i���킹�ďC���j
	 */
	public int getPreviewShortStay(VRMap sqlParam) throws Exception {

		ACSQLSafeDateFormat dateFormat = new ACSQLSafeDateFormat();
		// �N�x����
		Date startDate = ACCastUtilities.toDate(sqlParam.getData("INSURE_VALID_START"));
		Date endDate = ACCastUtilities.toDate(sqlParam.getData("TARGET_DATE"));
		int startMonth = ACDateUtilities.getMonth(startDate);
		int endMonth = ACDateUtilities.getMonth(endDate);
		int startYear = ACDateUtilities.getYear(startDate);
		int endYear = ACDateUtilities.getYear(endDate);
		int rtnCount = 0;
		// 4�����O�Ȃ�N�x��߂�
		if (startMonth < 4) {
			startYear -= 1;
		}
		if (endMonth < 4) {
			endYear -= 1;
		}
		
		do {
			String tableName = "SERVICE_DETAIL_INTEGER_" + startYear;
			StringBuilder sb = new StringBuilder();
			
			sb.append("SELECT");
			sb.append(" DISTINCT(SERVICE_DATE)");
			sb.append(" FROM ");
			sb.append(tableName + ",");
			sb.append(" SERVICE");
			sb.append(" WHERE");
			sb.append("(");
			sb.append(" SERVICE.SERVICE_ID ");
			sb.append(" = ");
			sb.append(tableName + ".SERVICE_ID");
			sb.append(")");
			sb.append(" AND");
			sb.append(" (");
			sb.append(tableName + ".SYSTEM_BIND_PATH");
			sb.append(" = 5");
			sb.append(")");
			sb.append(" AND");
			sb.append(" (");
			sb.append(tableName + ".DETAIL_VALUE");
			sb.append(" <> 2");
			sb.append(")");
			sb.append(" AND");
			sb.append(" (");
		    sb.append(" SERVICE.PATIENT_ID");
		    sb.append(" =");
		    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PATIENT_ID", sqlParam)));
		    sb.append(")");
		    sb.append("AND");
		    sb.append("(");
		    sb.append(" SERVICE.SERVICE_USE_TYPE");
		    sb.append(" =");
		    sb.append(" 6");
		    sb.append(")");
		    sb.append("AND");
		    sb.append("(");
		    sb.append(" SERVICE.SYSTEM_SERVICE_KIND_DETAIL");
		    sb.append(" >=");
		    sb.append(" 12000");
		    sb.append(")");
		    sb.append("AND");
		    sb.append("(");
		    sb.append(" SERVICE.SYSTEM_SERVICE_KIND_DETAIL");
		    sb.append(" <=");
		    sb.append(" 12999");
		    sb.append(")");
		    sb.append("AND");
		    sb.append("(");
		    sb.append(" SERVICE.SERVICE_DATE");
		    sb.append(" <");
		    sb.append(dateFormat.format(VRBindPathParser.get("TARGET_DATE", sqlParam), "yyyy-MM-01"));
		    sb.append(")");
		    sb.append("AND");
		    sb.append("(");
		    sb.append(" SERVICE.SERVICE_DATE");
		    sb.append(" >=");
		    sb.append(dateFormat.format(VRBindPathParser.get("INSURE_VALID_START", sqlParam), "yyyy-MM-dd"));
		    sb.append(")");
			
		    try {
		    	VRList result =  getDBManager().executeQuery(sb.toString());
			    
		    	rtnCount += result.size();
			} catch (Exception e) {
				// �e�[�u���������ꍇ�̃G���[�̓X���[
			}
		    
			startYear ++;
		}while(startYear <= endYear);

		return rtnCount;
	}



}
