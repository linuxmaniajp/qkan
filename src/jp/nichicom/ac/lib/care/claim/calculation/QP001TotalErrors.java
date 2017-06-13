package jp.nichicom.ac.lib.care.claim.calculation;

import java.awt.Dimension;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JScrollPane;
import javax.swing.JViewport;
import javax.swing.UIManager;

import jp.nichicom.ac.ACConstants;
import jp.nichicom.ac.component.ACLabel;
import jp.nichicom.ac.container.ACGroupBox;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.core.ACFrameEventProcesser;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.lib.care.claim.servicecode.CareServiceCommon;
import jp.nichicom.ac.util.ACMessageBox;
import jp.nichicom.vr.layout.VRLayout;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;

public class QP001TotalErrors {

	
	/** �F��\�����̃G���[��� */
	private VRList applyingErrors = new VRArrayList();
	/** �Ώێ҂��v�x���Ȃ̂ɗv���̃T�[�r�X�Z�� */
	private VRList serviceErrorsYobo = new VRArrayList();
	/** �Ώێ҂��v���Ȃ̂ɗv�x���̃T�[�r�X�Z�� */
	private VRList serviceErrorsKaigo = new VRArrayList();
	/** �F����ԊO�G���[ */
	private VRList outOfTermError = new VRArrayList();
	/** ������x�����Ə����{�l�ŗl���掵�Z��G���[ */
	private VRList selfPlanStyle7 = new VRArrayList();
	/** �v�x���Q�̂ݎZ��\�G���[ */
	private VRList neededSupport2Only = new VRArrayList();
	
	// 2016/10/13 [Yoichiro Kamei] add - begin �������ƑΉ�
	private VRList sjTankaNotFound = new VRArrayList();
	private Set<String> insurerIds = new HashSet<String>();
	/**
	 * �ی��҂̒P�ʐ��P�����ݒ�̃G���[��o�^����B
	 * @param patient
	 */
	public void addSjTankaNotFound(VRMap patient, String insurerId) {
		addErrorArray(getFullName(patient), sjTankaNotFound);
		insurerIds.add(insurerId);
	}
	//�ی��҂̒P�ʐ��P�����ݒ�̃G���[���b�Z�[�W���擾
	private String getSjTankaNotFoundMessage() {
		StringBuilder sb = new StringBuilder();
		sb.append("�ی��Ҕԍ�[");
		boolean first = true;
		for (String insurerId : insurerIds) {
			if (!first) {
				sb.append(",");
			}
			sb.append(insurerId);
			first = false;
		}
		sb.append("]�̒P�ʐ��P�����ݒ肳��Ă��܂���B");
		sb.append(ACConstants.LINE_SEPARATOR);
		sb.append("�u�ی��ҏ��ڍ׉�ʁv�Łu�������ƒP�ʐ��P���v��ݒ肵�Ă��������B");
		sb.append(ACConstants.LINE_SEPARATOR);
		return sb.toString();
	}
	// 2016/10/13 [Yoichiro Kamei] add - end
	
	
	// 2016/10/25 [Yoichiro Kamei] add - begin �������ƑΉ�
	private VRList sjIncorrectInsurers = new VRArrayList();
	/**
	 * �����o���Ȃ��ی��҂̃R�[�h�ݒ�G���[��o�^����B
	 * @param patient
	 */
	public void addSjIncorrectInsurers(VRMap patient) {
		addErrorArray(getFullName(patient), sjIncorrectInsurers);
	}
	
	private VRList sjIncorrectLimitOverUnits = new VRArrayList();
	
	/**
	 * �敪�x�����x���P�ʐ��̕s�����G���[��o�^����B
	 * @param patient
	 */
	public void addSjIncorrectLimitOverUnits (VRMap patient) {
		addErrorArray(getFullName(patient), sjIncorrectLimitOverUnits);
	}
	
	// 2016/10/25 [Yoichiro Kamei] add - end
	
	//private ACDateFormat errorDateFormat = new ACDateFormat("MM��dd��");
	
	/**
	 * �F��\�����̃G���[��o�^����
	 */
	public void addApplyingError(VRMap patient) {
		addErrorArray(getFullName(patient), applyingErrors);
	}
	
	/**
	 * ���x�ƒ񋟃T�[�r�X���s��v�̏ꍇ�̃G���[�o�^
	 * @param patient
	 * @param service
	 * @param masterService
	 */
	public void addServiceError(VRMap patient, VRMap service, VRMap masterService) {
		
		Integer serviceKind = ACCastUtilities.toInteger(service.get("SYSTEM_SERVICE_KIND_DETAIL"), 0);
		if (!masterService.containsKey(serviceKind)) {
			return;
		}
		
		//����
		/*
		StringBuilder msg = new StringBuilder();
		msg.append(getFullName(patient));
		
		switch (ACCastUtilities.toInt(serviceKind, 0)) {
		//��×{�Ǘ��w��
		case 13111:
		//���\�h����×{�Ǘ��w��
		case 13411:
			msg.append("�@�@");
			msg.append("�@�@" + errorDateFormat.format(service.get("SERVICE_DATE")));
			msg.append("�@�@");
			msg.append("�@�@" + ((VRMap)masterService.get(serviceKind)).get("SERVICE_NAME"));
			break;
		}
		*/
		
		String fullName = getFullName(patient);
		
        switch (ACCastUtilities.toInt(service.get("1"), 0)) {
        case 12: //�v�x���P
        	//�v�x���F��A�v�x���̃T�[�r�X�񋟂̂Ƃ�
        	if (CareServiceCommon.isPreventService(serviceKind.intValue())){
        		addErrorArray(fullName, neededSupport2Only);
        	} else {
        		addErrorArray(fullName, serviceErrorsYobo);
        	}
        	break;
        case 13: //�v�x���Q
        	addErrorArray(fullName, serviceErrorsYobo);
        	break;
        case 11: //�o�ߓI�v���
        case 21: // �v���x�P
        case 22: // �v���x�Q
        case 23: // �v���x�R
        case 24: // �v���x�S
        case 25: // �v���x�T
        	addErrorArray(fullName, serviceErrorsKaigo);
            break;
        }
		
		
	}
	
	
	/**
	 * �v���F�肪�F����ԊO
	 * @param patient
	 */
	public void addOutOfTermError(VRMap patient) {
		addErrorArray(getFullName(patient), outOfTermError);
	}
	
	/**
	 * ������x�����Ə����{�l�ŗl���掵�Z��G���[
	 * @param patient
	 */
	public void addSelfPlanStyle7(VRMap patient) {
		addErrorArray(getFullName(patient), selfPlanStyle7);
	}
	
	
	private void addErrorArray(String msg, VRList target) {
		String addMsg = "�@�@" + msg;
		if (target.contains(addMsg)) {
			return;
		}
		target.add(addMsg);
	}
	
	/**
	 * �G���[�����݂�����
	 * @return
	 */
	public boolean hasError() {
		if (applyingErrors.size() != 0) return true;
		if (serviceErrorsYobo.size() != 0) return true;
		if (serviceErrorsKaigo.size() != 0) return true;
		if (outOfTermError.size() != 0) return true;
		if (selfPlanStyle7.size() != 0) return true;
		if (neededSupport2Only.size() != 0) return true;
		if (sjTankaNotFound.size() != 0) return true; // add 2016.10 �������ƓƎ��Ή�
		if (sjIncorrectInsurers.size() != 0) return true; // add 2016.10 �������ƓƎ��Ή�
		if (sjIncorrectLimitOverUnits.size() != 0) return true; // add 2016.10 �������ƓƎ��Ή�
		
		return false;
	}
	
	private String getErrorMessage() {
		StringBuilder msg = new StringBuilder();
		
		makeErrorMessage("�v���F���񂪐\�����Ɠo�^����Ă��܂��B", applyingErrors, msg);
		makeErrorMessage("�v�x���҂ɉ��T�[�r�X�̎��т��쐬����Ă��܂��B", serviceErrorsYobo, msg);
		makeErrorMessage("�v���҂ɗ\�h�T�[�r�X�̎��т��쐬����Ă��܂��B", serviceErrorsKaigo, msg);
		
		makeErrorMessage("�v���F����̔F����ԊO�ɃT�[�r�X�̎��т��쐬����Ă��܂��B", outOfTermError, msg);
		makeErrorMessage("���p�ҏ��̋���T�[�r�X�v��쐬�҂̐ݒ肪�s���ł��B", selfPlanStyle7, msg);
		makeErrorMessage("�v�x��1�ł͎󋋂ł��Ȃ��T�[�r�X���ݒ肳��Ă��܂��B", neededSupport2Only, msg);
		
		makeErrorMessage(getSjTankaNotFoundMessage(), sjTankaNotFound, msg);// add 2016.10 �������ƓƎ��Ή�
		makeErrorMessage("�������ƂŐ����ł��Ȃ��ی��҂̃T�[�r�X���ݒ肳��Ă��܂��B", sjIncorrectInsurers, msg);// add 2016.10 �������ƓƎ��Ή�
		makeErrorMessage("�敪�x�����P�ʐ����s���ł��B���ъǗ���[�������� �敪�x�����P�ʐ�����]���s���Ă��������B", sjIncorrectLimitOverUnits, msg);// add 2016.10 �������ƓƎ��Ή�
		
		return msg.toString();
	}
	
	private void makeErrorMessage(String title, VRList list, StringBuilder msg) {
		
		if (list.size() == 0) {
			return;
		}
		
		msg.append(title + ACConstants.LINE_SEPARATOR);
		for (int i = 0; i < list.size(); i++) {
			msg.append(list.get(i) + ACConstants.LINE_SEPARATOR);
		}
		msg.append(ACConstants.LINE_SEPARATOR);
		
	}
	
	/**
	 * �ێ����Ă���G���[�̏ڍ׏����_�C�A���O�ŕ\������
	 *
	 */
	public void show() {
		ACGroupBox details = new ACGroupBox("�ڍ׏��");
		ACLabel lbl = new ACLabel();
		JViewport view = new JViewport();
		JScrollPane pane = new JScrollPane(view);
		view.add(lbl);
		details.add(pane, VRLayout.CLIENT);
		lbl.setVerticalTextPosition(ACLabel.TOP);
        lbl.setVerticalAlignment(ACLabel.TOP);
		lbl.setText(getErrorMessage());
		lbl.setRows(lbl.getText().split(ACConstants.LINE_SEPARATOR).length + 1);
		pane.setPreferredSize(new Dimension(200,100));
		
		ACMessageBox.show(getDefaultTitle(), "���т̏W�v���ł��܂���ł����B", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK, details, true);
		if (details.getParent() != null) {
			details.getParent().remove(pane);
		}
		pane = null;
	}
	
    private String getDefaultTitle() {
        ACFrameEventProcesser eventProcesser = ACFrame.getInstance()
                .getFrameEventProcesser();
        if (eventProcesser instanceof ACFrameEventProcesser) {
            // ��ʑJ�ڑO�Ƀ��b�Z�[�W�{�b�N�X�̃f�t�H���g�^�C�g����ݒ肷��
            return eventProcesser.getDefaultMessageBoxTitle();
        }
        return "���b�Z�[�W";
    }
    
    private String getFullName(VRMap patient) {
    	return QkanCommon.toFullName(patient.get("PATIENT_FAMILY_NAME"), patient.get("PATIENT_FIRST_NAME"));
    }
    
	
	//�f�o�b�O�p
	public static void main(String[] arts) {
		try {
			UIManager.setLookAndFeel("jp.nichicom.vr.plaf.metal.VRLookAndFeel");
		} catch (Exception e){
			
		}
		
		QP001TotalErrors e = new QP001TotalErrors();
		
		//e.addServiceError("�@�@����@����", 12);
		//e.addServiceError("�@�@�y��@����", 11);
		
		e.show();
	}	
	
}
