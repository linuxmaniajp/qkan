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
 * �쐬��: 2009/02/10  ���{�R���s���[�^�[������� ����@��F �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �\��Ǘ� (S)
 * �v���Z�X �T�[�r�X�\�� (001)
 * �v���O���� �T�[�r�X�p�^�[�����\�h�K��Ō� (QS001132_H2104)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;

import java.awt.*;
import java.awt.event.*;
import java.awt.im.*;
import java.io.*;
import java.sql.SQLException;
import java.text.*;
import java.util.*;
import java.util.List;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
import jp.nichicom.ac.*;
import jp.nichicom.ac.bind.*;
import jp.nichicom.ac.component.*;
import jp.nichicom.ac.component.dnd.*;
import jp.nichicom.ac.component.dnd.event.*;
import jp.nichicom.ac.component.event.*;
import jp.nichicom.ac.component.mainmenu.*;
import jp.nichicom.ac.component.table.*;
import jp.nichicom.ac.component.table.event.*;
import jp.nichicom.ac.container.*;
import jp.nichicom.ac.core.*;
import jp.nichicom.ac.filechooser.*;
import jp.nichicom.ac.io.*;
import jp.nichicom.ac.lang.*;
import jp.nichicom.ac.pdf.*;
import jp.nichicom.ac.sql.*;
import jp.nichicom.ac.text.*;
import jp.nichicom.ac.util.*;
import jp.nichicom.ac.util.adapter.*;
import jp.nichicom.vr.*;
import jp.nichicom.vr.bind.*;
import jp.nichicom.vr.bind.event.*;
import jp.nichicom.vr.border.*;
import jp.nichicom.vr.component.*;
import jp.nichicom.vr.component.event.*;
import jp.nichicom.vr.component.table.*;
import jp.nichicom.vr.container.*;
import jp.nichicom.vr.focus.*;
import jp.nichicom.vr.image.*;
import jp.nichicom.vr.io.*;
import jp.nichicom.vr.layout.*;
import jp.nichicom.vr.text.*;
import jp.nichicom.vr.text.parsers.*;
import jp.nichicom.vr.util.*;
import jp.nichicom.vr.util.adapter.*;
import jp.nichicom.vr.util.logging.*;
import jp.or.med.orca.qkan.*;
import jp.or.med.orca.qkan.affair.*;
import jp.or.med.orca.qkan.component.*;
import jp.or.med.orca.qkan.text.*;
import jp.nichicom.ac.lib.care.claim.print.schedule.*;

/**
 * �T�[�r�X�p�^�[�����\�h�K��Ō�(QS001132_H2104) 
 */
public class QS001132_H2104 extends QS001132_H2104Event {
	/**
	 * �R���X�g���N�^�ł��B
	 */
	public QS001132_H2104() {
	}

	//�R���|�[�l���g�C�x���g

	/**
	 * �u�E���敪�I���v�C�x���g�ł��B
	 * @param e �C�x���g���
	 * @throws Exception ������O
	 */
	protected void houmonKangoKaigoClassSelectionChanged(ListSelectionEvent e)
			throws Exception {
        // �E���敪�I��
        // ��ʂ̏�Ԃ�ύX����B
        checkState();

	}

	/**
	 * �u���ԋ敪�I���v�C�x���g�ł��B
	 * @param e �C�x���g���
	 * @throws Exception ������O
	 */
	protected void houmonKangoKaigoTimeActionPerformed(ActionEvent e)
			throws Exception {
        // ���ԋ敪�I��
        // �I�����ԍĐݒ�
        checkEndTime();
        checkState();

	}

	/**
	 * �u�J�n���ԕύX�v�C�x���g�ł��B
	 * @param e �C�x���g���
	 * @throws Exception ������O
	 */
	protected void houmonKangoKaigoBeginTimeActionPerformed(ActionEvent e)
			throws Exception {
        // �J�n���ԕύX
        // �I�����ԍĐݒ�
        checkEndTime();

	}

	/**
	 * �u���ԑѕύX�v�C�x���g�ł��B
	 * @param e �C�x���g���
	 * @throws Exception ������O
	 */
	protected void houmonKangoKaigoTimeZoneSelectionChanged(ListSelectionEvent e)
			throws Exception {
        // ���ԑѕύX
        // �����ԑѕύX���A�J�n���Ԃ��ύX
        // ���ԑޔ�p�̕ϐ�kangoTime�ɁA�K��Ō쎞�ԋ敪����擾�������Ԃ�ݒ肷��B
        // �K��Ō��쎞�ԑ�(houmonKaigoTimeZone)�̒l���`�F�b�N����B
        switch (getHoumonKangoKaigoTimeZone().getSelectedIndex()) {
        case 1:
            // �l���P�i�ʏ�j�̏ꍇ
            // �J�n���Ԃ�9:00�ɂ���B
            getHoumonKangoKaigoBeginTime().setText("09:00");
            break;
        case 2:
            // �l���Q�i�����j�̏ꍇ
            // �J�n���Ԃ�6:00�ɂ���B
            getHoumonKangoKaigoBeginTime().setText("06:00");
            break;
        case 3:
            // �l���R�i��ԁj�̏ꍇ
            // �J�n���Ԃ�18:00�ɂ���B
            getHoumonKangoKaigoBeginTime().setText("18:00");
            break;
        case 4:
            // �l���S�i�[��j�̏ꍇ
            // �J�n���Ԃ�22:00�ɂ���B
            getHoumonKangoKaigoBeginTime().setText("22:00");
            break;
        }
        // �I�����Ԃ��u�J�n���� + �K��Ō쎞��(��)�v�ɐݒ肷��B
        checkEndTime();

	}

	/**
	 * �u�{�݋敪�I���v�C�x���g�ł��B
	 * @param e �C�x���g���
	 * @throws Exception ������O
	 */
	protected void houmonKangoKaigoFacilityTypeSelectionChanged(
			ListSelectionEvent e) throws Exception {
        // �{�݋敪�ύX
        // �{�݋敪�ihoumonKangoKaigoFacilityType�j�̒l���`�F�b�N����B
        switch (getHoumonKangoKaigoFacilityType().getSelectedIndex()) {
        case 1:
            // �l���P�������ꍇ
            // ��ʂ̏�Ԃ�ύX����B�i�E���敪��PT�EOT�EST��Enable��false�ɂ���j
            checkState();
            break;
        case 2:
            // �l��2�������ꍇ
            // ��ʂ̏�Ԃ�ύX����B�i�E���敪��PT�EOT�EST��Enable��true�ɂ���j
            checkState();
            break;
        }

	}

    /**
     * �u���ʊǗ����Z�I���v�C�x���g�ł��B
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void houmonKangoKaigoSpecialManageRadioSelectionChanged(ListSelectionEvent e) throws Exception {
        // ���ʊǗ����Z�ύX
        //��ʏ�Ԑ��䏈�����Ăяo���B
        checkState();
        
    }
    
	public static void main(String[] args) {
		//�f�t�H���g�f�o�b�O�N��
		ACFrame.getInstance().setFrameEventProcesser(
				new QkanFrameEventProcesser());
		QkanCommon.debugInitialize();
		VRMap param = new VRHashMap();
		//param�ɓn��p�����^���l�߂Ď��s���邱�ƂŁA�ȈՃf�o�b�O���\�ł��B
		ACFrame.debugStart(new ACAffairInfo(QS001132_H2104.class.getName(),
				param));
	}

	//�����֐�

	/**
	 * �u�������v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * @throws Exception ������O
	 */
	public void initialize() throws Exception {
        // ����ʓW�J���̏����ݒ�
        // ���R���{�A�C�e���̐ݒ�
        // ������
        // �R���{�A�C�e���ݒ�p�̃��R�[�h comboItemMap �𐶐�����B
        VRMap comboItemMap = new VRHashMap();
        // ���ݒ�
        // ���J�n����
        // �R�[�h�}�X�^�f�[�^���CODE_ID�F23�i�����E�j���̑I�� / ����(�J�n)�j���擾����B
        comboItemMap.setData("3", QkanCommon.getArrayFromMasterCode(23, "3"));
        // �擾�����l���AcomboItemMap�� KEY : 3 �� VALUE �Ƃ��Đݒ肷��B
        // ���I������
        // �R�[�h�}�X�^�f�[�^���CODE_ID�F23�i�����E�j���̑I�� / ����(�J�n)�j���擾����B
        comboItemMap.setData("4", QkanCommon.getArrayFromMasterCode(23, "4"));
        // �擾�����l���AcomboItemMap�� KEY : 4 �� VALUE �Ƃ��Đݒ肷��B
        // ���W�J
        // ���g(this)��comboItemMap�ɐݒ肷��B
        getThis().setModelSource(comboItemMap);
        // �R���{�A�C�e����W�J����B
        getThis().bindModelSource();
        // ���I�����ڂ̏����ݒ�
        // ������
        // �����I��ݒ�p�̃��R�[�h defaultMap �𐶐�����B
        VRMap defaultMap = new VRHashMap();
        // ���ݒ�
        // ��ʂ̃��W�I�̏����l��ݒ肷��B�iselectFirstRadioItem�j
        QkanCommon.selectFirstRadioItem(getThis());
        // ���ԋ敪�����ݒ�
        defaultMap.setData("1630103", new Integer(3));
        // ���W�J
        // ���g(this)��defaultMap�ɐݒ肷��B
        getThis().setSource(defaultMap);
        // �����I�����ڂ�W�J����B
        getThis().bindSource();
        // ��ʂ̏�Ԃ𐧌䂷��B
        checkState();


	}

	/**
	 * �u���Ə��R���{�ύX���֐��v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * @throws Exception ������O
	 */
	public void providerSelected(VRMap provider) throws Exception {
        // �����Ə��R���{�ύX���ɌĂԊ֐�
        if (provider != null) {
            // �I�����Ə����null�łȂ��ꍇ
            // ���ȉ��̓��e�ڍ׍��ڂ́A�I�����Ə��̒l��ݒ肷��B
            // ������
            // ���Ə��A���p�̃��R�[�h defaultMap �𐶐�����B
            VRMap defaultMap = new VRHashMap();
            // ���ݒ�
            // �����Ə��A��
            switch (ACCastUtilities.toInt(VRBindPathParser.get("1630101",
                    provider), 0)) {
            // �{�ݓ��̋敪�i���Ə��p�l���jKEY�F1630101�̒l���`�F�b�N����B
            case 1:
                // �l���P�i�K��Ō�X�e�[�V�����j�������ꍇ
                // �K��Ō�X�e�[�V������I����Ԃɂ��邽�߂̐ݒ���s���B(defaultMap ��KEY�F1630101 VALUE�F1
                // ��ݒ肷��j
                VRBindPathParser.set("1630101", defaultMap, new Integer(1));
                break;
            case 2:
                // �l���Q�i��Ë@�ցj�������ꍇ
                // �a�@���͐f�Ï���I����Ԃɂ��邽�߂̐ݒ���s���B(defaultMap ��KEY�F1630101 VALUE�F2
                // ��ݒ肷��j
                VRBindPathParser.set("1630101", defaultMap, new Integer(2));
                break;
            }
            
            //�T�[�r�X�񋟑̐��������Z�@���Ə���[1630106]���T�[�r�X�p�l����[1630109]�ɐݒ肷��B
            VRBindPathParser.set("1630109", defaultMap, VRBindPathParser.get("1630106", provider));
            
            // ���W�J
            // ���g(this)��defaultMap�ɐݒ肷��B
            getThis().setSource(defaultMap);
            // �����I�����ڂ�W�J����B
            getThis().bindSource();
            // ���ȉ��̓��e�ڍ׍��ڂ́A�I�����Ə��́u�Ȃ��v�u����v�ɂ���āA����/�L����؂�ւ���B
            // ��ʏ�Ԃ𐧌䂷��B
            checkState();
        }

	}

	/**
	 * �u���͓��e�̕s���������v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * @throws Exception ������O
	 */
	public VRMap getValidData() throws Exception {
        // �����͓��e�ɕs�����Ȃ������`�F�b�N���A�T�[�r�X�f�[�^��Ԃ��B
        // ���ԋp�p�̃��R�[�h(data)�𐶐�
        VRMap data = new VRHashMap();
        // ���g(this)�̃\�[�X�Ƃ��Đ������R�[�h��ݒ肷��B
        getThis().setSource(data);
        // ���g(this)��applySource���Ăяo���ăf�[�^�����W����B
        getThis().applySource();
        // ���ԋp�p���R�[�h����s�v�ȃL�[������
        // �����͓��e�ɕs�����Ȃ������`�F�b�N���A�T�[�r�X�f�[�^��Ԃ�
        if (ACTextUtilities
                .isNullText(getHoumonKangoKaigoBeginTime().getText())
                || ACTextUtilities.isNullText(getHoumonKangoKaigoEndTime()
                        .getText())
                || (!getHoumonKangoKaigoBeginTime().isValidDate())
                || (!getHoumonKangoKaigoEndTime().isValidDate())) {
            // �J�n�����R���{(houmonKangoKaigoBeginTime)�ƏI�������R���{(houmonKangoKaigoEndTime)�̂����ꂩ���󗓂��s���̏ꍇ
            // �����̕s�����b�Z�[�W��\������B��ID=QS001_ERROR_OF_NO_TIME
            QkanMessageList.getInstance().QS001_ERROR_OF_NO_TIME();
            // null��Ԃ��B
            return null;
        }
        
        //if (!getHoumonKangoKaigoTime().getSelectedButton().isEnabled()) {
        if (!getHoumonKangoKaigoTime().isSelected() ||
        		!getHoumonKangoKaigoTime().getButton(getHoumonKangoKaigoTime().getSelectedIndex()).isEnabled()){
            // ���ԋ敪�̗L���ȍ��ڂ��I������Ă��Ȃ��ꍇ
            // ���e�̕s�����b�Z�[�W��\������B��ID=QS001_ERROR_OF_NO_CONTENT
            QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
            // null��Ԃ��B
            return null;
        }
        
        
        if (!getHoumonKangoKaigoTimeZone().getSelectedButton().isEnabled()) {
            // ���ԑы敪�ɕs�����������ꍇ
            // ���e�̕s�����b�Z�[�W��\������B��ID=QS001_ERROR_OF_NO_CONTENT
            QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
            // null��Ԃ��B
            return null;
        }
        if (!getHoumonKangoKaigoClass().getSelectedButton().isEnabled()) {
            // �E���敪�ɕs�����������ꍇ
            // ���e�̕s�����b�Z�[�W��\������B��ID=QS001_ERROR_OF_NO_CONTENT
            QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
            // null��Ԃ��B
            return null;
        }
        QkanCommon.removeDisabledBindPath(getThis(), data);
        // ���Ȃ���Εԋp�p���R�[�h(data)��Ԃ��B
        return data;
	}

	/**
	 * �u���Ə����̕K�v�����擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * @throws Exception ������O
	 */
	public boolean isUseProvider() throws Exception {
        // �����Ə���񂪕K�v�ȃT�[�r�X�ł��邩��Ԃ��B
        // true��Ԃ��B
        return true;
	}

	/**
	 * �u�J�n�������͗p�̃R���{�擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * @throws Exception ������O
	 */
	public ACComboBox getBeginTimeCombo() throws Exception {
        // ���J�n�������͗p�̃R���{��Ԃ��B
        // �֐��̕Ԃ�l�Ƃ��ĊJ�n���ԃR���{��Ԃ��B
        return getHoumonKangoKaigoBeginTime();
	}

	/**
	 * �u�I���������͗p�̃R���{�擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * @throws Exception ������O
	 */
	public ACComboBox getEndTimeCombo() throws Exception {
        // ���I���������͗p�̃R���{��Ԃ��B
        // �֐��̕Ԃ�l�Ƃ��ďI�����ԃR���{��Ԃ��B
        return getHoumonKangoKaigoEndTime();
	}

	/**
	 * �u�I�����Ԏ擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * @throws Exception ������O
	 */
	public int checkEndTime() throws Exception {
        // ���J�n���ԕύX���A�I�����Ԃ��ύX
        if (getHoumonKangoKaigoBeginTime().isValidDate()
                && (!ACTextUtilities.isNullText(getHoumonKangoKaigoBeginTime()
                        .getText()))) {
            // �J�n���ԃR���{(houmonKangoKaigoBeginTime)�̒l���󗓂���ѕs���łȂ��ꍇ
            // ���ԑޔ�p�̕ϐ�kangoTime�ɁA�K��Ō쎞�ԋ敪����擾�������Ԃ�ݒ肷��B
            int kangoTime = 0;
            switch (getHoumonKangoKaigoTime().getSelectedIndex()) {
            case 1: // 20������
                kangoTime = 20;
                break;
            case 2: // 30�������̏ꍇ
                // �߂�l�Ƃ���30��Ԃ��B
                kangoTime = 30;
                break;
            case 3:
                // 30���ȏ�A1���Ԗ����̏ꍇ
                // �߂�l�Ƃ���60��Ԃ��B
                kangoTime = 60;
                break;
            case 4:
                // 1���Ԉȏ�A1���Ԕ������̏ꍇ
                // �߂�l�Ƃ���90��Ԃ��B
                kangoTime = 90;
                break;
            }
            // �I�����Ԃ��u�J�n���� + kangoTime(��)�v�ɐݒ肷��B
            getHoumonKangoKaigoEndTime().setDate(
                    ACDateUtilities.addMinute(getHoumonKangoKaigoBeginTime()
                            .getDate(), kangoTime));

        }
        return 0;
	}

	/**
	 * �u��ʂ̏�Ԃ�ύX����B�v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * @throws Exception ������O
	 */
	public void checkState() throws Exception {
        // ����ʏ�Ԃ�ύX����B
        // ���T�[�r�X�A��
        // �{�݋敪�̒l���`�F�b�N����B
        switch (getHoumonKangoKaigoFacilityType().getSelectedIndex()) {
        case 1:
            // �K��Ō�X�e�[�V�����������ꍇ
            switch (getHoumonKangoKaigoClass().getSelectedIndex()) {
            // ���Ŗ��͏y�Ō�w�������ꍇ
            case 1:
            case 2:
                // ���ԋ敪�`�F�b�N
                switch (getHoumonKangoKaigoTime().getSelectedIndex()) {
                // 20�������������ꍇ
                case 1:
                    // ���2
                    setState_STATE_MODE_2();
                    break;
                case 2:
                case 3:
                case 4:
                    // 20�������ȊO�������ꍇ
                    // ���1
                    setState_STATE_MODE_1();
                    break;
                }
                break;
            case 3:
                // ���w�������ꍇ
                // ���3
                setState_STATE_MODE_3();
                break;
            }
            break;
        // ��Ë@�ւ������ꍇ
        case 2:
            switch (getHoumonKangoKaigoClass().getSelectedIndex()) {
            // ���Ŗ��͏y�Ō�w�������ꍇ
            case 1:
            case 2:
                // ���ԋ敪�`�F�b�N
                switch (getHoumonKangoKaigoTime().getSelectedIndex()) {
                // 20�������������ꍇ
                case 1:
                    // ���5
                    setState_STATE_MODE_5();
                    break;
                // 20�������ȊO�������ꍇ
                case 2:
                case 3:
                case 4:
                    // ���4
                    setState_STATE_MODE_4();
                    break;
                }
                break;
            // ���w�Ö@�m�������ꍇ
            case 3:
                // ���6
                setState_STATE_MODE_6();
                break;
            }
            break;
        }
        
        //�����ԖK��Ō���Z�̗L��������`�F�b�N����B
        if (getHoumonKangoKaigoTime().isEnabled()
                && getHoumonKangoKaigoTime().getSelectedIndex() == 4
                && getHoumonKangoKaigoTime().getButton(4).isEnabled()
                && getHoumonKangoKaigoSpecialManageRadio().isEnabled()
                && getHoumonKangoKaigoSpecialManageRadio().getSelectedIndex() == 2) {
            // ���ԋ敪���u1���Ԉȏ�A1���Ԕ������v�ŁA�����ʊǗ����Z���L�����u����v�̏ꍇ
            // �u�����ԖK��Ō���Z�E�L���v��Ԃɂ���B(VALID_LONG_TIME)
            setState_VALID_LONG_TIME();
        } else {
            // ��L�ȊO�̏ꍇ
            // �u�����ԖK��Ō���Z�E�����v��Ԃɂ���B(INVALID_LONG_TIME)
            setState_INVALID_LONG_TIME();
        }
        
        // �����Ə��A��
        // �����ϐ� providerInfoMap �𐶐�����B
        VRMap providerInfoMap;
        // ���Ə��p�l�������擾�� providerInfoMap �Ɋi�[����B
        providerInfoMap = getSelectedProvider();
        // providerInfoMap�� null ���`�F�b�N����B
        // null�i���Ə����I���j�������ꍇ
        // �����s��Ȃ��B
        if (providerInfoMap != null) {
            // null�ȊO�������ꍇ
            // ���ʊǗ��̐��i���Ə��j�̒l���`�F�b�N����B
            switch (ACCastUtilities.toInt(VRBindPathParser.get("1630103",
                    providerInfoMap), 0)) {
            case 1:
                // �l�� 1 �������ꍇ
                // ��ʏ�Ԃ�ύX����B
                setState_SPECIAL_MANAGE_RADIO_FALSE();
                break;
            case 2:
                // �l�� 2 �������ꍇ
                // ��ʏ�Ԃ�ύX����B
                setState_SPECIAL_MANAGE_RADIO_TRUE();
                break;
            }
            // �ً}���K��Ō���Z�̐��i���Ə��j�̒l�����`�F�b�N����B
            switch (ACCastUtilities.toInt(VRBindPathParser.get("1630102",
                    providerInfoMap), 0)) {
            case 1:
                // �l�� 1 �������ꍇ
                // ��ʏ�Ԃ�ύX����B
                setState_URGENT_TIME_RADIO_ENABLE_FALSE();
                break;
            case 2:
                // �l�� 2 �������ꍇ
                // ��ʏ�Ԃ�ύX����B
                setState_URGENT_TIME_RADIO_ENABLE_TRUE();
                break;
            }
        }

	}

    /**
     * �u�T�[�r�X�@�����敪�擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
     *
     * @throws Exception ������O
     * @return int
     */
    public int getServiceLowVersion() throws Exception {
        //�����̃T�[�r�X�p�l���������T�[�r�X�̖@�����敪(M_DETAIL.SYSTEM_BIND_PATH=14)��Ԃ��B 
        //QkanConstants.SERVICE_LOW_VERSION_H2104 ��Ԃ��B
        return QkanConstants.SERVICE_LOW_VERSION_H2104;
    }
}
