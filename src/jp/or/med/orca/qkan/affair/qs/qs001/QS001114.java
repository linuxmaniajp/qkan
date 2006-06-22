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
 * �쐬��: 2006/02/23  ���{�R���s���[�^�[������� �� ���� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �\��Ǘ� (S)
 * �v���Z�X �T�[�r�X�\�� (001)
 * �v���O���� �T�[�r�X�p�^�[���Z�������×{���i��K���f�Ï��j (QS001114)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;

import java.awt.event.ActionEvent;

import jp.nichicom.ac.component.ACComboBox;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.affair.QkanMessageList;

/**
 * �T�[�r�X�p�^�[���Z�������×{���i��K���f�Ï��j(QS001114)
 */
public class QS001114 extends QS001114Event {
	/**
	 * �R���X�g���N�^�ł��B
	 */
	public QS001114() {
	}

	// �R���|�[�l���g�C�x���g

	public static void main(String[] args) {
		// �f�t�H���g�f�o�b�O�N��
		ACFrame.getInstance().setFrameEventProcesser(
				new QkanFrameEventProcesser());
		QkanCommon.debugInitialize();
		VRMap param = new VRHashMap();
		// param�ɓn��p�����^���l�߂Ď��s���邱�ƂŁA�ȈՃf�o�b�O���\�ł��B
		ACFrame.debugStart(new ACAffairInfo(QS001114.class.getName(), param));
	}

	// �����֐�

	/**
	 * �u�������v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public void initialize() throws Exception {
		// ����ʓW�J���̏����ݒ�
		// ���R���{�A�C�e���̐ݒ�
		// ������
		// �R���{�A�C�e���ݒ�p�̃��R�[�h comboItemMap �𐶐�����B
		VRMap comboItemMap = new VRHashMap();
		// ���H����
		// �R�[�h�}�X�^�f�[�^���CODE_ID�F191�i�H���񋟁j���擾����B
		// �擾�����l���AcomboItemMap�� KEY : 1230406 �� VALUE �Ƃ��Đݒ肷��B
		comboItemMap.setData("1230406", QkanCommon.getArrayFromMasterCode(191,
				"1230406"));
		// ���ݒ�
		// ���W�J
		// ���g(this)��comboItemMap�ɐݒ肷��B
		getThis().setModelSource(comboItemMap);
		// �R���{�A�C�e����W�J����B
		getThis().bindModelSource();
		// ���I�����ڂ̏����ݒ�
        QkanCommon.selectFirstRadioItem(getThis());
		// ������
		// �����I��ݒ�p�̃��R�[�h defaultMap �𐶐�����B
		VRMap defaultMap = new VRHashMap();
		// ���ݒ�
        // �H����
        VRBindPathParser.set("1230406",defaultMap,new Integer(1));
		// ���W�J
		// ���g(this)��defaultMap�ɐݒ肷��B
		getThis().setSource(defaultMap);
		// �����I�����ڂ�W�J����B
		getThis().bindSource();

	}

	/**
	 * �u���Ə��R���{�ύX���֐��v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public void providerSelected(VRMap provider) throws Exception {
		// �����Ə��R���{�ύX���ɌĂԊ֐�
		// �I�����Ă��鎖�Ə����(selectedProvider)��ޔ�����B
		setSelectedProvider(provider);
		if (provider != null) {
			// ���ȉ��̓��e�ڍ׍��ڂ́A�I�����Ə��̒l��ݒ肷��B
			Object obj;
			// �l�����Z
			obj = VRBindPathParser.get("1230404", provider);
			if (obj != null) {
				getShortStayStandardRecuperationEtcShiftSubtractionRadio()
						.setSelectedIndex(ACCastUtilities.toInt(obj));
			}
			// ���}
			obj = VRBindPathParser.get("1230401", provider);
			if (obj != null) {
				switch (ACCastUtilities.toInt(obj)) {
				case 2:
					// �u����v�̏ꍇ
					// ���}�敪(shortStayStandardRecuperationMeetingAndSendingOff)��3�Ԗڂ̃{�^����I���ɂ���B
					getShortStayStandardRecuperationMeetingAndSendingOff()
							.setSelectedIndex(3);
					break;
				case 1:
					// �u�Ȃ��v�̏ꍇ
					// ���}�敪(shortStayStandardRecuperationMeetingAndSendingOff)��1�Ԗڂ̃{�^����I���ɂ���B
					getShortStayStandardRecuperationMeetingAndSendingOff()
							.setSelectedIndex(1);
					break;
				}
			}
			// ���ȉ��̓��e�ڍ׍��ڂ́A�I�����Ə��́u�Ȃ��v�u����v�ɂ���āA����/�L����؂�ւ���B
			// �h�{�Ǘ��̐�
            VRMap defaultMap = new VRHashMap();
			obj = VRBindPathParser.get("1230402", provider);
			if (obj != null) {
                if(new Integer(2).equals(ACCastUtilities.toInteger(obj))){
                    VRBindPathParser.set("1230403",defaultMap,new Integer(3));
                }else if(new Integer(3).equals(ACCastUtilities.toInteger(obj))){
                    VRBindPathParser.set("1230403",defaultMap,new Integer(2));
                }
//                switch (ACCastUtilities.toInt(obj)) {
//                case 3:
//                    //�u�Ǘ��h�{�m�v�̏ꍇ
//                    // �L���ɂ���B
//                    setState_VALID_DIETICIAN_MANAGE();
//                    break;
//                case 2:
//                    // �u�h�{�m�v�̏ꍇ
//                    // �L���ɂ���B
//                    setState_VALID_DIETICIAN_MANAGE();
//                    break;
//                case 1:
//                    // �u�Ȃ��v�̏ꍇ
//                    // �����ɂ���B
//                    setState_INVALID_DIETICIAN_MANAGE();
//                    break;
//                }
			}
			// �×{�H
			obj = VRBindPathParser.get("1230403", provider);
			if (obj != null) {
				switch (ACCastUtilities.toInt(obj)) {
				case 2:
					// �u����v�̏ꍇ
					// �L���ɂ���B
					setState_VALID_MEDICAL_EXPENSES();
					break;
				case 1:
					// �u�Ȃ��v�̏ꍇ
					// �����ɂ���B
					setState_INVALID_MEDICAL_EXPENSES();
					break;
				}
			}
            
            // ���W�J
            // ���g(this)��defaultMap�ɐݒ肷��B
            getThis().setSource(defaultMap);
            // �����I�����ڂ�W�J����B
            getThis().bindSource();

            
            if(getShortStayStandardRecuperationDinnerOffer().getSelectedIndex()==0){
                //�H��Ȃ��̏ꍇ�ɂ̂ݒ�����ɂ���B
                getShortStayStandardRecuperationDinnerOffer().setSelectedIndex(1);
            }
		}
	}

	/**
	 * �u���͓��e�̕s���������v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public VRMap getValidData() throws Exception {
		// �����͓��e�ɕs�����Ȃ������`�F�b�N���A�T�[�r�X�f�[�^��Ԃ��B
		if (!getShortStayStandardRecuperationHospitalRoomDivisionRadio()
				.isSelected()) {
			// �a���敪(shortStayStandardRecuperationHospitalRoomDivisionRadio)�����I���̏ꍇ
			// ���e�ڍׂ̕s�����b�Z�[�W��\������B��ID=QS001_ERROR_OF_NO_CONTENT
			QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
			// null��Ԃ��B
			return null;
		}

		if (getShortStayStandardRecuperationDinnerOffer().getSelectedIndex() > 0) {
			// �H���񋟁ishortStayStandardRecuperationDinnerOffer)���u�Ȃ��v�ȊO��I�����Ă���ꍇ
			if (ACTextUtilities
					.isNullText(getShortStayStandardRecuperationDinnerCost()
							.getText())) {
				// �H����p(shortStayStandardRecuperationDinnerCost)���󗓂̏ꍇ
				// ���e�ڍׂ̕s�����b�Z�[�W��\������B��ID=QS001_ERROR_OF_NO_CONTENT
				QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
				// null��Ԃ��B
				return null;
			}
		}

		// ���ԋp�p�̃��R�[�h(data)�𐶐�
		VRMap data = new VRHashMap();
		// ���g(this)�̃\�[�X�Ƃ��Đ������R�[�h��ݒ肷��B
		getThis().setSource(data);
		// ���g(this)��applySource���Ăяo���ăf�[�^�����W����B
		getThis().applySource();

		// ���ԋp�p���R�[�h����s�v�ȃL�[������
          QkanCommon.removeDisabledBindPath(getThis(), data);
		// ���Ȃ���Εԋp�p���R�[�h(data)��Ԃ��B
		return data;
	}

	/**
	 * �u���Ə����̕K�v�����擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public boolean isUseProvider() throws Exception {
		// �����Ə���񂪕K�v�ȃT�[�r�X�ł��邩��Ԃ��B
		// true��Ԃ��B
		return true;
	}

	/**
	 * �u�H����p���擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @param meatType
	 *            int
	 * @throws Exception
	 *             ������O
	 * @return String
	 */
	public String getMeatCost(int meatType) throws Exception {
		// ���H�����������ƂɑI�����Ə��ɂ�����H����p��Ԃ��B
		if (getSelectedProvider() != null) {
			// ���Ə���I�����Ă���ꍇ
			switch (meatType) {
			case 1:
				// �H���������u������v�̏ꍇ
				// �u���v�̐H��A�u���v�̐H��A�u��v�̐H��̍��Z��Ԃ��B
				return String.valueOf(ACCastUtilities.toInt(VRBindPathParser
						.get("1230405", getSelectedProvider()), 0));
			case 2:
				// �H���������u���̂݁v�̏ꍇ
				// �u���v�̐H���Ԃ��B
				return String.valueOf(ACCastUtilities.toInt(VRBindPathParser
						.get("1230406", getSelectedProvider()), 0));
			case 3:
				// �H���������u���̂݁v�̏ꍇ
				// �u���v�̐H���Ԃ��B
				return String.valueOf(ACCastUtilities.toInt(VRBindPathParser
						.get("1230407", getSelectedProvider()), 0));
			case 4:
				// �H���������u��̂݁v�̏ꍇ
				// �u��v�̐H���Ԃ��B
				return String.valueOf(ACCastUtilities.toInt(VRBindPathParser
						.get("1230408", getSelectedProvider()), 0));
			case 5:
				// �H���������u�����v�̏ꍇ
				// �u���v�̐H��A�u���v�̐H��̐H��̍��Z��Ԃ��B
				return String.valueOf(ACCastUtilities.toInt(VRBindPathParser
						.get("1230406", getSelectedProvider()),0)
						+ ACCastUtilities.toInt(VRBindPathParser.get("1230407",
								getSelectedProvider()), 0));
			case 6:
				// �H���������u����v�̏ꍇ
				// �u���v�̐H��A�u��v�̐H��̐H��̍��Z��Ԃ��B
				return String.valueOf(ACCastUtilities.toInt(VRBindPathParser
						.get("1230407", getSelectedProvider()),0)
						+ ACCastUtilities.toInt(VRBindPathParser.get("1230408",
								getSelectedProvider()), 0));
			case 7:
				// �H���������u�钩�v�̏ꍇ
				// �u��v�̐H��A�u���v�̐H��̐H��̍��Z��Ԃ��B
				return String.valueOf(ACCastUtilities.toInt(VRBindPathParser
						.get("1230408", getSelectedProvider()),0)
						+ ACCastUtilities.toInt(VRBindPathParser.get("1230406",
								getSelectedProvider()), 0));
			}
		}
		// �󕶎���Ԃ��B
		return "";
	}

	/**
	 * �u�J�n�������͗p�̃R���{�擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public ACComboBox getBeginTimeCombo() throws Exception {
		// ���J�n�������͗p�̃R���{��Ԃ��B
		// �֐��̕Ԃ�l�Ƃ��ĊJ�n���ԃR���{��Ԃ��B
		return null;
	}

	/**
	 * �u�I���������͗p�̃R���{�擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
	 * 
	 * @throws Exception
	 *             ������O
	 */
	public ACComboBox getEndTimeCombo() throws Exception {
		// ���I���������͗p�̃R���{��Ԃ��B
		// �֐��̕Ԃ�l�Ƃ��ďI�����ԃR���{��Ԃ��B
		return null;
	}

	protected void shortStayStandardRecuperationProviderDivisionActionPerformed(
			ActionEvent e) throws Exception {
	      // ���u�{�݋敪�v�I�����́u�a���敪�v�̏�Ԑؑ�
	      // �u�{�݋敪�v�̒l���`�F�b�N����B
	      switch (getShortStayStandardRecuperationProviderDivision().getSelectedIndex()) {
	      case 1:
	    	  //�u��K���f�Ï��v�̏ꍇ�A�u�a���敪�v��L���ɂ���B
	    	  setState_VALID_HOSPITAL_ROOM_DIVISION();
	    	  //���A��V���[�g��p���W�I�O���[�v��Visible���� //20060411
    	      setState_SHORT_STAY_UNSELECT();
	    	  break;
	      case 2:
	    	  //�u���A��V���[�g�X�e�C�v�̏ꍇ�A�u�a���敪�v�𖳌��ɂ���B
	    	  setState_INVALID_HOSPITAL_ROOM_DIVISION();
              //���A��V���[�g��p���W�I�O���[�v��Visible���� //20060411
              setState_SHORT_STAY_SELECT();
	    	  break;
	      }

	}

	protected void shortStayStandardRecuperationDinnerOfferActionPerformed(
			ActionEvent e) throws Exception {
		// ���u�H���񋟁v�I�����Ɂu�H��v�̏�Ԑؑ�
		if (getShortStayStandardRecuperationDinnerOffer().getSelectedIndex() < 1) {
			// �u�H���񋟁v���u�Ȃ��v�̏ꍇ
			// �H��𖳌��ɂ���B
			setState_NOT_USE_MEAT();
		} else {
			// �u�H���񋟁v���u�Ȃ��v�ȊO�̏ꍇ
			// �H���L���ɂ���B
			setState_USE_MEAT();
			// �H����p(shortStayStandardRecuperationDinnerCost)��ݒ肷��B
			getShortStayStandardRecuperationDinnerCost().setText(
					getMeatCost(getShortStayStandardRecuperationDinnerOffer()
							.getSelectedIndex()));
		}

	}

}
