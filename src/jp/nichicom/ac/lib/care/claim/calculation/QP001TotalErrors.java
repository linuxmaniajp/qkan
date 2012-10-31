package jp.nichicom.ac.lib.care.claim.calculation;

import java.awt.Dimension;

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
