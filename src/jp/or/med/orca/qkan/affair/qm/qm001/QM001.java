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
 * �쐬��: 2006/01/23  ���{�R���s���[�^�[������� �� ���� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���j���[ (M)
 * �v���Z�X ���O�C����� (001)
 * �v���O���� ���O�C����� (QM001)
 *
 *****************************************************************
 */

package jp.or.med.orca.qkan.affair.qm.qm001;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

import jp.nichicom.ac.ACConstants;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.core.version.ACVersionAdjuster;
import jp.nichicom.ac.io.ACPropertyXML;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.sql.ACDBManager;
import jp.nichicom.ac.sql.ACLoggerDBManager;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.bridge.sql.BridgeFirebirdDBManager;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.nichicom.vr.util.logging.VRLogger;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.QkanConstants;
import jp.or.med.orca.qkan.QkanSystemInformation;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.affair.QkanMessageList;
import jp.or.med.orca.qkan.affair.QkanVersionAdjustmentListener;
import jp.or.med.orca.qkan.affair.qm.qm002.QM002;
import jp.or.med.orca.qkan.affair.qo.qo002.QO002;
import jp.or.med.orca.qkan.affair.qo.qo004.QO004;
import jp.or.med.orca.qkan.affair.qo.qo005.QO005;
import jp.or.med.orca.qkan.affair.qu.qu002.QU002;
import jp.or.med.orca.qkan.affair.qv.qv001.QV001;

/**
 * ���O�C�����(QM001)
 */
public class QM001 extends QM001Event {

	/**
	 * �R���X�g���N�^�ł��B
	 */
	public QM001() {
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
		// �G���[�Ȃ�
		final int NO_ERROR = 0;
		// DB�ڑ��G���[
		final int DB_ERROR = 1;
		// �����Ə��Ȃ�
		final int NO_PROVIDER = 2;
		// �ی��҂Ȃ�
		final int NO_INSURER = 4;
		// ���p�҂Ȃ�
		final int NO_PATIENT = 8;
		// PDF�r���[���Ȃ�
		final int NOT_FOUND_PDF_VIEWER = 16;
		// �V�X�e���o�[�W�����s��
		final int SYSTEM_VERSION_ERROR = 32;
		// DBMS�o�[�W�����s��
		final int DBMS_VERSION_ERROR = 64;
		// DB�o�[�W�����s��
		final int DB_MASTER_VERSION_ERROR = 128;
		int errorFlag = NO_ERROR;

		//���C�����j���[�L���b�V�����N���A
        QkanSystemInformation.getInstance().setMenuTree(null);
        
		// �V�X�e�����t���Z�b�g
		Date systemDate = QkanSystemInformation.getInstance().getSystemDate();
		VRMap map = new VRHashMap();
		map.setData("SYSTEM_DATE", systemDate);
		getCombos().setSource(map);
		getCombos().bindSource();

        boolean properityReloaded = false; 
        ACPropertyXML xml=ACFrame.getInstance().getPropertyXML();
        if(xml!=null){
            //�ݒ�t�@�C�����ēǂݍ��݂���B
            try{
                xml.read();
                properityReloaded = true;
            }catch(Exception ex){
                VRLogger.info(ex);
            }
        }
		String systemVersion = "�擾���s";
		// �ݒ�t�@�C��(QkanPropertyXML.xml)�̃v���p�e�B�uVersion/no�v���擾����B
		if (properityReloaded && ACFrame.getInstance().hasProperty("Version/no")) {
			// �擾�ł����ꍇ
			// �V�X�e���́u�V�X�e���o�[�W�����v�ɁA�擾�����l��ݒ肷��B
			systemVersion = getProperty("Version/no");
			setState_VALID_VERSION();
		} else {
			// �擾�ł��Ȃ������ꍇ
			errorFlag |= SYSTEM_VERSION_ERROR;
			setState_INVALID_VERSION();
		}
        // �V�X�e���́u�V�X�e���o�[�W�����v�ɁA�u�擾���s�v��ݒ肷��B
        QkanSystemInformation.getInstance().setSystemVersion(systemVersion);

		String dbmsVersion = "unknown";
		String schemeVersion = "�擾���s";
		String masterDataVersion = "�擾���s";
		if (errorFlag == NO_ERROR) {
			// DB�̐ڑ��`�F�b�N���s���B
			if (getDBManager().canConnect()) {
				// ���������ꍇ
				// �������ցB

				ACDBManager dbm = getDBManager();
				if (dbm instanceof ACLoggerDBManager) {
					dbm = ((ACLoggerDBManager) dbm).getAdaptee();
				}
				if (dbm instanceof BridgeFirebirdDBManager) {
					try {
						dbmsVersion = ((BridgeFirebirdDBManager) dbm)
								.getDBMSVersion();
					} catch (Exception ex) {
					}
				}
				if (("unknown".equals(dbmsVersion))
						|| (dbmsVersion.indexOf("Firebird 1.0") >= 0)) {
					errorFlag |= DBMS_VERSION_ERROR;
					setState_INVALID_DBMS();
				} else {
					setState_VALID_DB();
				}
			} else {
				// ���s�����ꍇ
				errorFlag |= DB_ERROR;
				setState_INVALID_DB_CONNECTION();
			}

			if (errorFlag == NO_ERROR) {
                //���W���[���̑Ώۃo�[�W�����ɍ��킹�ăf�[�^�x�[�X�𐮌`����B
                try{
                    new ACVersionAdjuster().adjustment(getDBManager(),
                        "version/update.xml",
                        new QkanVersionAdjustmentListener(getDBManager()));
                    systemVersion = QkanSystemInformation.getInstance().getSystemVersion();
                }catch(Exception ex){
                    VRLogger.info(ex);
                }
                
                
				// ���t�Ǘ��䒠�V�X�e���o�[�W�������擾�p��SQL�����擾����B
				// getSQL_GET_QKAN_VERSION(null);
				// �擾����SQL���𔭍s����B
				VRList versionList = getDBManager().executeQuery(
						getSQL_GET_QKAN_VERSION(null));

				// �擾������0����葽���ꍇ
				if (versionList.size() > 0) {
					// �V�X�e���́u�}�X�^�f�[�^�o�[�W�����v�ɁA�擾�����}�X�^�f�[�^�o�[�W������ݒ肷��B
					// setMasterDataVersion((�}�X�^�[�f�[�^�o�[�W����));
					masterDataVersion = ACCastUtilities
							.toString(VRBindPathParser.get(
									"MASTER_DATA_VERSION", (VRMap) versionList
											.getData()));

					// �V�X�e���Ƀ}�X�^�f�[�^�o�[�W������ޔ�����B
					// setSchemeVersion((�X�L�[�}�o�[�W����));
					schemeVersion = ACCastUtilities.toString(VRBindPathParser
							.get("SCHEME_VERSION", (VRMap) versionList
									.getData()));

				} else {
					// �擾������0���̏ꍇ
					errorFlag |= DB_MASTER_VERSION_ERROR;
					setState_INVALID_MASTER_VERSION();
				}
			}
		}

        // ��ʂ́u�V�X�e���o�[�W����(systemVersion)�v�ɁA�u�擾���s�v��ݒ肷��B
        getSystemVersion().setText(systemVersion);
		// �V�X�e���́u�}�X�^�f�[�^�o�[�W�����v�ɁA�擾�����}�X�^�f�[�^�o�[�W������ݒ肷��B
		// setMasterDataVersion((�}�X�^�[�f�[�^�o�[�W����));
		QkanSystemInformation.getInstance().setMasterDataVersion(
				masterDataVersion);
		// �V�X�e���Ƀ}�X�^�f�[�^�o�[�W������ޔ�����B
		// setSchemeVersion((�X�L�[�}�o�[�W����));
		QkanSystemInformation.getInstance().setSchemeVersion(schemeVersion);

		if (errorFlag == NO_ERROR) {
			// �R�[�h�}�X�^�擾�p��SQL�����擾����B
			// getSQL_GET_MASTER_CODE(null);
			// �擾����SQL���𔭍s����B
			VRList masterCodeList = getDBManager().executeQuery(
					getSQL_GET_MASTER_CODE(null));
			// �擾������0����葽���ꍇ
			if (masterCodeList.size() > 0) {
				// �V�X�e���́u�R�[�h�}�X�^�v�ɐݒ肷�邽�߂̌`���ɕϊ�����B
				// �ECODE_ID����ArrayList�Ɋi�[����B
				// �EKEY : CODE_ID, VALUE : CODE_ID���̃��R�[�h�W��
				// �Ƃ��āA���R�[�h�Ɋi�[����B
				// �V�X�e���́u�R�[�h�}�X�^�v�ɁA�ϊ��������R�[�h���i�[����B
				// setCodeMaster((�ϊ��������R�[�h));
				VRMap fullCodeM = new VRHashMap();
				Integer lastKey = null;
				VRList codeM = null;
				Iterator it = masterCodeList.iterator();
				while (it.hasNext()) {
					VRMap row = (VRMap) it.next();
					Integer key = Integer.valueOf(String
							.valueOf(VRBindPathParser.get("CODE_ID", row)));
					if (key != null) {
						if (!key.equals(lastKey)) {
							codeM = new VRArrayList();
							fullCodeM.setData(key, codeM);
							lastKey = key;
						}
						codeM.addData(row);
					}
				}
				// �R�[�h�}�X�^���V�X�e�����ʂɐݒ�
				QkanSystemInformation.getInstance().setMasterCode(fullCodeM);

			} else {
				// �擾������0���̏ꍇ
				// �V�X�e���́u�R�[�h�}�X�^�v�ɁA��̃��R�[�h���i�[����B
				// setCodeMaster((��̃��R�[�h));
				QkanSystemInformation.getInstance().setMasterCode(null);
			}

			// �Ɩ���񃌃R�[�h���擾����B
			// �E�B���h�E�^�C�g���ɁA�擾���R�[�h��KEY : WINDOW_TITLE��VALUE��ݒ肷��B
			// �Ɩ��{�^���o�[�̃e�L�X�g�ɁA�擾���R�[�h��KEY : AFFAIR_TITLE��VALUE��ݒ肷��B
			setAffairTitle("QM001");

			// �u���Ə��ꗗ(providerList)�v�ɐݒ肷�鎩���Ə��ꗗ�擾�p��SQL�����擾����B
			// getSQL_GET_MY_PROVIDER(null);
			// �擾����SQL���𔭍s����B
			VRList providerList = getDBManager().executeQuery(
					getSQL_GET_MY_PROVIDER(null));

			// ���R�[�h����0����葽���ꍇ
			if (providerList.size() > 0) {
				// �R���{�A�C�e���ݒ�p�̃��R�[�h comboItemMap �𐶐�����B
				VRMap comboItemMap = new VRHashMap();
				// �擾�������R�[�h�W�����AcomboItemMap �� KEY : PROVIDER_LISTS ��
				// VALUE
				// �Ƃ��Đݒ肷��B
				comboItemMap.setData("PROVIDER_LISTS", providerList);

				// �u�R���{�̈�(combos)�v��model�Ƃ��āAcomboItemMap��ݒ肷��B
				getContents().setModelSource(comboItemMap);

				// �u�R���{�̈�(combos)�v��model��W�J����B
				getContents().bindModelSource();

				// �擾�������X�g�̈�ԏ��I����Ԃɂ���B
				getProviderList().setSelectedIndex(0);

				setState_VALID_PROVIDER();
			} else {
				// ���R�[�h����0���̏ꍇ

				setState_INVALID_PROVIDER();
				errorFlag |= NO_PROVIDER;
			}

			if (errorFlag == NO_ERROR) {
				if (QkanCommon.getInsurerInfo(getDBManager()).isEmpty()) {
					// �ی��҂��Ȃ��ꍇ
					setState_INVALID_INSURER();
					errorFlag |= NO_INSURER;
				} else {
					// �ی��҂��L��ꍇ
					setState_VALID_INSURER();
				}
				if (QkanCommon.getPatientInfo(getDBManager()).isEmpty()) {
					// ���p�҂��Ȃ��ꍇ
					setState_INVALID_PATIENT();
					errorFlag |= NO_PATIENT;
				} else {
					// ���p�҂��L��ꍇ
					setState_VALID_PATIENT();
				}

                if (String.valueOf(System.getProperty("os.name")).toLowerCase()
                        .indexOf("mac") < 0) {
                    //Mac�ȊO
                    if (hasProperty("Acrobat/Path")
                            && new File(getProperty("Acrobat/Path")).exists()) {
                        setState_VALID_PDF_VIEWER();
                    } else {
                        setState_INVALID_PDF_VIEWER();
                        errorFlag |= NOT_FOUND_PDF_VIEWER;
                    }
                } else {
                    //Mac�̏ꍇ
                    setState_VALID_PDF_VIEWER();
                }

				// ����pPDF�t�@�C���i�[�p�t�H���_�����݂��邩�`�F�b�N����B
				File pdfFile = new File("pdf");

				// ���݂���ꍇ
				if (pdfFile.exists()) {
					// ����pPDF�t�@�C���i�[�p�t�H���_���̑S�Ă�PDF�t�@�C�����폜����B
					String[] fileList = pdfFile.list();
					for (int i = 0; i < fileList.length; i++) {
						File deleteFile = new File(pdfFile, fileList[i]);
						deleteFile.delete();
					}
				}
                
                
			}

            //�ԍ��Ǘ��e�[�u���̍č̔�
            
            getDBManager().beginTransaction();
            try{
                getDBManager().executeUpdate(getSQL_UPDATE_NO_OF_SERVICE(null));
                getDBManager().executeUpdate(getSQL_UPDATE_NO_OF_PROVIDER_SERVICE(null));
                getDBManager().executeUpdate(getSQL_UPDATE_NO_OF_CLAIM(null));
                getDBManager().commitTransaction();
            }catch(Exception ex){
                getDBManager().rollbackTransaction();
                VRLogger.info(ex);
            }
            
        }

		StringBuffer sb = new StringBuffer();
		sb.append("OS : ");
		sb.append(System.getProperty("os.name", "unknown"));
		String patch = System.getProperty("sun.os.patch.level", "");
		if (!patch.equalsIgnoreCase("unknown")) {
			sb.append(" ");
			sb.append(patch);
		}
		sb.append(ACConstants.LINE_SEPARATOR);
		sb.append("VM : ");
		sb.append(System.getProperty("java.vendor", "unknown"));
		sb.append(" ");
		sb.append(System.getProperty("java.version", "-"));
		sb.append(ACConstants.LINE_SEPARATOR);
		sb.append("Firebird : ");
		sb.append(dbmsVersion);
		sb.append(ACConstants.LINE_SEPARATOR);
		sb.append("�V�X�e��version : ");
		sb.append(systemVersion);
		sb.append(ACConstants.LINE_SEPARATOR);
		sb.append("�f�[�^version : ");
		sb.append(masterDataVersion);
		sb.append(ACConstants.LINE_SEPARATOR);
		sb.append("�X�L�[�}version : ");
		sb.append(schemeVersion);

		getEnvironment().setText(sb.toString());


        //��ʍő剻
        ACFrame.getInstance().setExtendedState(Frame.MAXIMIZED_BOTH);
                
        try{
            //�ݒ�t�@�C���ύX�Ή�
            if(!ACFrame.getInstance().hasProperty("Claim/Cleaned")){
                if(ACFrame.getInstance().hasProperty("Claim/Folder")){
                    Object m=ACFrame.getInstance().getPropertyXML().getData("Claim");
                    if(m instanceof Map){
                        ((Map)m).remove("Folder");
                    }
                }
                if(ACFrame.getInstance().hasProperty("Claim/Info")){
                    Object m=ACFrame.getInstance().getPropertyXML().getData("Claim");
                    if(m instanceof Map){
                        ((Map)m).remove("Info");
                    }
                }
                ACFrame.getInstance().getPropertyXML().setForceValueAt("Claim/Cleaned", "true");
                ACFrame.getInstance().getPropertyXML().write();
            }
        }catch(Exception ex){
            
        }
        
		if ((affair.getParameters() != null)
				&& (affair.getParameters().get("STOP_AUTO_LOGIN") != null)) {
			// ���C�����j���[�̖����I�ȃ��O�A�E�g�ł͎������O�C�����֎~
			affair.getParameters().remove("STOP_AUTO_LOGIN");
		} else {
			if ((errorFlag == NO_ERROR) && getProviderList().isSelected()
					&& getProviderList().getItemCount() == 1) {
				// �������O�C��
				startActionPerformed(null);
			}
		}
        
	}

	// �R���|�[�l���g�C�x���g

	/**
	 * �u�o�[�W�������\���v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void showVersionActionPerformed(ActionEvent e) throws Exception {
		// ���o�[�W��������ʂւ̑J��
		// ��ʓn��p�̃p�����[�^ affair (NCAffairInfo)�𐶐����A���L�p�����[�^��ݒ肷��B
		// affair(NCAffairInfo);
		// className : QV001.class.getName(), parameters : null
		// �uQV001 �o�[�W��������ʁv��\������B
		// next(affair);
		new QV001().setVisible(true);

	}

	/**
	 * �u���O�C�������v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void startActionPerformed(ActionEvent e) throws Exception {
		// ���Ə����I������Ă��Ȃ��Ƃ�
		if (!getProviderList().isSelected()) {
			// �G���[���b�Z�[�W�\��
			QkanMessageList.getInstance().QM001_ERROR_OF_PROVIDER();
			return;
		}

		// �u�V�X�e�����t(systemDate)�v�̃G���[�`�F�b�N���s���B
		if (!getSystemDate().isValidDate()
				|| ACTextUtilities.isNullText(getSystemDate().getText())) {
			// �l���s���ȏꍇ
			// �G���[���b�Z�[�W��\������B�����b�Z�[�WID = ERROR_OF_WRONG_DATE
			QkanMessageList.getInstance().ERROR_OF_WRONG_DATE("�V�X�e��");
			// �u�V�X�e�����t(systemDate)�v�Ƀt�H�[�J�X�𓖂Ă�B
			getSystemDate().requestFocus();
			// �����𔲂���B
			return;
		} else {
			// �l������ȏꍇ
			// ��ʂ́u�V�X�e�����t(systemDate)�v���擾����B
			// �V�X�e���́u�V�X�e�����t�v�ɁA�擾�������t��ݒ肷��B
			// setSystemDate((�擾�����V�X�e�����t));
			QkanSystemInformation.getInstance().setSystemDate(
					ACCastUtilities.toDate(getSystemDate().getText()));

			// �u�����Ə��ꗗ(providerList)�v�őI������Ă��鎩���Ə��̎��Ə��ԍ����A�u�����Ə��ꗗ(providerList)�v����擾����B
			// �V�X�e���́u���O�C�����Ə��ԍ��v�ɁA�擾�������Ə��̎��Ə��ԍ���ݒ肷��B
			// setLoginProviderID((�擾���������Ə��ԍ�));
			QkanSystemInformation.getInstance().setLoginProviderID(
					ACCastUtilities.toString(VRBindPathParser.get(
							"PROVIDER_ID", (VRMap) getProviderList()
									.getSelectedModelItem())));

			// �n��p�����[�^�p�̃��R�[�h param�ɉ��L�p�����[�^��ݒ肷��B
			VRMap params = new VRHashMap();
			// �E KEY : FROM_AFFAIR
			params.setData("FROM_AFFAIR", null);
			// ���L�p�����[�^�ɂ�NCAffairInfo affair�𐶐�����B
			// affair(NCAffairInfo);
			ACAffairInfo affair = null;
			// className : QM002.class.getName()
			affair = new ACAffairInfo(QM002.class.getName(), params, "���C�����j���[", true);
			// �uQM002 ���C�����j���[�v�ɑJ�ڂ���B
			// next(affair);
			ACFrame.getInstance().next(affair);

		}
	}

	/**
	 * �u�I�������v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void endActionPerformed(ActionEvent e) throws Exception {
		// �V�X�e�����I������B
		System.exit(0);

	}

	public static void main(String[] args) {
		// �f�t�H���g�f�o�b�O�N��
		ACFrame.getInstance().setFrameEventProcesser(
				new QkanFrameEventProcesser());
		// ���O�C�����t
		QkanCommon.debugInitialize();
		VRMap param = new VRHashMap();
		// param�ɓn��p�����^���l�߂Ď��s���邱�ƂŁA�ȈՃf�o�b�O���\�ł��B
		ACFrame
				.debugStart(new ACAffairInfo(QM001.class.getName(), param, "���O�C�����", true));
	}

	/**
	 * �u�ݒ�ύX��ʑJ�ځv�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void goSetting1ActionPerformed(ActionEvent e) throws Exception {
		ACFrame.getInstance().next(new ACAffairInfo(QO005.class.getName()));
	}

	/**
	 * �u�ݒ�ύX��ʑJ�ځv�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void goSetting2ActionPerformed(ActionEvent e) throws Exception {
		ACFrame.getInstance().next(new ACAffairInfo(QO005.class.getName()));
	}

	/**
	 * �u���Ə��o�^��ʑJ�ځv�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void goProviderActionPerformed(ActionEvent e) throws Exception {
		// �n��p�����[�^�p���R�[�h params �𐶐����A���L�̒l��ݒ肷��B
		VRMap params = new VRHashMap();
		// KEY : PROCESS_MODE, VALUE : PROCESS_MODE_INSERT (���ʒ萔)
		params.setData("PROCESS_MODE", new Integer(
				QkanConstants.PROCESS_MODE_INSERT));
		// ��ʓn��p�p�����[�^ affair (NCAffairInfo)�����L�p�����[�^�Ő�������B
		// className : QO004.class.getName(), parameters : params
		ACAffairInfo affair = new ACAffairInfo(QO004.class.getName(), params);

		// �uQO004 ���Ə����o�^�v��ʂɑJ�ڂ���B���[�h�́u�V�K�쐬�v�Ƃ���B
		// next(affair);
		ACFrame.getInstance().next(affair);
	}

	/**
	 * �u�ی��ғo�^��ʑJ�ځv�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void goInsurerActionPerformed(ActionEvent e) throws Exception {
		ACAffairInfo affair = null;
		VRMap param = new VRHashMap();
		// className : QO002.class.getName(), parameters : null
		affair = new ACAffairInfo(QO002.class.getName(), param);
		// �uQO002 �ی��҈ꗗ�E�o�^��ʁv�ɑJ�ڂ���B
		// next(affair);
		ACFrame.getInstance().next(affair);
	}

	/**
	 * �u���p�ғo�^��ʑJ�ځv�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
	protected void goPatientActionPerformed(ActionEvent e) throws Exception {
		ACAffairInfo affair = null;
		VRMap param = new VRHashMap();
		// className : QU002.class.getName(), parameters : null
		affair = new ACAffairInfo(QU002.class.getName(), param);

		// �uQU002 ���p�ғo�^��ʁv�ɑJ�ڂ���B
		// next(affair);
		ACFrame.getInstance().next(affair);
	}

      /**
       * �u�ݒ�ύX��ʑJ�ځv�C�x���g�ł��B
       * @param e �C�x���g���
       * @throws Exception ������O
       */
    protected void goSetting3ActionPerformed(ActionEvent e) throws Exception {
        ACFrame.getInstance().next(new ACAffairInfo(QO005.class.getName()));
    }

}
