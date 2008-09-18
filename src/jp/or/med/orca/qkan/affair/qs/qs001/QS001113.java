
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
 * �v���O���� �T�[�r�X�p�^�[���Z�������×{���i�F�m�ǎ����j (QS001113)
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
import jp.or.med.orca.qkan.lib.*;
import jp.or.med.orca.qkan.text.*;

/**
 * �T�[�r�X�p�^�[���Z�������×{���i�F�m�ǎ����j(QS001113) 
 */
public class QS001113 extends QS001113Event {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001113(){
  }

  //�R���|�[�l���g�C�x���g
  /**
   * �u�{�݋敪�I�����C�x���g�v�C�x���g�ł��B
   * 
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected void shortStayDementiaRecuperationInstitutionDivisionRadioActionPerformed(
			ActionEvent e) throws Exception {
		// ���u�{�݋敪�v�I�����́u�a���敪�v�̏�Ԑؑ�
		// �u�{�݋敪�v�̒l���`�F�b�N����B
		switch (getShortStayDementiaRecuperationInstitutionDivisionRadio()
				.getSelectedIndex()) {
		case 1:
			// �u�F�m�ǎ����^�v�̏ꍇ
			setState_CONVENTIONAL_FORM();
			// �l�����Z���ݒ�ς݂������ꍇ
			if (getStaffAssignmentFlag()) {
				setState_INVALID_STAFF_ASSIGNMENT();
			}
			// ���A��V���[�g��p���W�I�O���[�v��Visible���� //20060411
			setState_SHORT_STAY_UNSELECT();
			break;
		case 2:
			// ����j�b�g�^�F�m�ǎ����^��̏ꍇ
			setState_UNIT_FORM();
			// ���j�b�g�P�A�̐��������������ꍇ
			if (!getUnitCareFlag()) {
				setState_INVALID_UNIT_CARE();
			}
			// ���A��V���[�g��p���W�I�O���[�v��Visible���� //20060411
			setState_SHORT_STAY_UNSELECT();
			break;
		case 3:
			// ����A��V���[�g�X�e�C�
			setState_SELECT_SHORT_STAY();
			// ���A��V���[�g��p���W�I�O���[�v��Visible���� //20060411
			setState_SHORT_STAY_SELECT();
			break;
		case 4:
			// �u�o�ߌ^�v�̏ꍇ
			setState_PASSAGE_FORM();
			// ���A��V���[�g��p���W�I�O���[�v��Visible���� //20060411
			setState_SHORT_STAY_UNSELECT();
			break;
		}
		changeState();
  }
  
  /**
	 * �u����f�Ô�̐ݒ�v�C�x���g�ł��B
	 * 
	 * @param e
	 *            �C�x���g���
	 * @throws Exception
	 *             ������O
	 */
  protected void shortStayDementiaRecuperationSpecificConsultationFeeActionPerformed(
          ActionEvent e) throws Exception {
      // ������f�Ô�̕ҏW
      // ����f�Ô�ҏW���(QS001028)�𐶐�����B
      // ����f�Ô�{�^���̃f�[�^�������ɐ�����������f�Ô�ҏW���(QS001028)��shoModal�����s����B
      if (new QS001199().showModal(SYSTEM_SERVICE_KIND_DETAIL,
              getShortStayDementiaRecuperationSpecificConsultationFee()
                      .getDataModel())) {
          // ����f�Ô��ύX�����ꍇ
          if (getShortStayDementiaRecuperationSpecificConsultationFee()
                  .getDataModel().isEmpty()) {
              // ����f�Ô�{�^���̃f�[�^����̏ꍇ
              // ����f�Ô�x���Ɂu�ݒ�Ȃ��v�ƕ\������B
              getShortStayDementiaRecuperationSpecificConsultationFeeOutline()
                      .setText("�ݒ�Ȃ�");
          } else {
              // ����f�Ô�{�^���̃f�[�^����ł͂Ȃ��ꍇ
              // ����f�Ô�x���Ɂu�ݒ肠��v�ƕ\������B
              getShortStayDementiaRecuperationSpecificConsultationFeeOutline()
                      .setText("�ݒ肠��");
          }
      }
  }
  
  /**
   * �u�H���񋟑I���v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected void shortStayDementiaRecuperationDinnerOfferActionPerformed(ActionEvent e) throws Exception {
      // ���u�H���񋟁v�I�����Ɂu�H��v�̏�Ԑؑ�
      if (getShortStayDementiaRecuperationDinnerOffer().getSelectedIndex() < 1) {
          // �u�H���񋟁v���u�Ȃ��v�̏ꍇ
          // �H��𖳌��ɂ���B
          setState_NOT_USE_MEAT();
      } else {
          // �u�H���񋟁v���u�Ȃ��v�ȊO�̏ꍇ
          // �H���L���ɂ���B
          setState_USE_MEAT();
              // �H����p(shortStayDementiaRecuperationDinnerCost)��ݒ肷��B
              getShortStayDementiaRecuperationDinnerCost().setText(
                      getMeatCost(getShortStayDementiaRecuperationDinnerOffer()
                              .getSelectedIndex()));
      }
      
  }
  
  /**
   * 
   */
  protected void shortStayDementiaRecuperationPersonSubtractionActionPerformed(ActionEvent e) throws Exception {
      //�l�����Z�敪�u�Ō�E���E���������̏ꍇ�v�u���Ŕ䗦��20%�����̏ꍇ�v�u�ƒn�͏o���v��I�������ꍇ
      if (getShortStayDementiaRecuperationPersonSubtraction()
              .getSelectedIndex() == 2
              || getShortStayDementiaRecuperationPersonSubtraction()
                      .getSelectedIndex() == 3
              || getShortStayDementiaRecuperationPersonSubtraction()
                      .getSelectedIndex() == 5) {
          //��ʏ��ύX����B
          setState_INVALID_STAFF_ASSIGNMENT();
          //�ݒ肠��ɐݒ�
          setStaffAssignmentFlag(true);
      }else{
          setState_VALID_STAFF_ASSIGNMENT();
          //�ݒ�Ȃ��ɐݒ�
          setStaffAssignmentFlag(false);
      }
      
      changeState();
  }
  
  public static void main(String[] args) {
    //�f�t�H���g�f�o�b�O�N��
    ACFrame.getInstance().setFrameEventProcesser(new QkanFrameEventProcesser());
    QkanCommon.debugInitialize();
    VRMap param = new VRHashMap();
    //param�ɓn��p�����^���l�߂Ď��s���邱�ƂŁA�ȈՃf�o�b�O���\�ł��B
    ACFrame.debugStart(new ACAffairInfo(QS001113.class.getName(), param));
  }

  //�����֐�

  /**
   * �u�������v�Ɋւ��鏈�����s�Ȃ��܂��B
   * @throws Exception ������O
   */
  public void initialize() throws Exception {
        // ����ʓW�J���̏����ݒ�
      getShortStayDementiaRecuperationSpecificConsultationFee().clearDataModel();
      //QS001028(����f�Ô�)���T�[�r�X���(SYSTEM_SERVICE_KIND_DETAIL)�ɉ�����bindPath�z����擾���A����f�Ô�{�^���ɐݒ肷��B
      getShortStayDementiaRecuperationSpecificConsultationFee()
              .setBindPathes(QS001199.getTargetBindPathes(SYSTEM_SERVICE_KIND_DETAIL));
        // ���R���{�A�C�e���̐ݒ�
        // ������
        // �R���{�A�C�e���ݒ�p�̃��R�[�h comboItemMap �𐶐�����B
        VRMap comboItemMap = new VRHashMap();
        // ���ݒ�
        // ���H����
        // �R�[�h�}�X�^�f�[�^���CODE_ID�F191�i�H���񋟁j���擾����B
        // �擾�����l���AcomboItemMap�� KEY : 1230347 �� VALUE �Ƃ��Đݒ肷��B
        comboItemMap.setData("1230347", QkanCommon.getArrayFromMasterCode(191,
                "1230347"));
        // ���l�����Z
        // �R�[�h�}�X�^�f�[�^���CODE_ID�F77�i�l�����Z�j���擾����B
        // �擾�����l���AcomboItemMap�� KEY : 1230346 �� VALUE �Ƃ��Đݒ肷��B
        comboItemMap.setData("1230346", QkanCommon.getArrayFromMasterCode(66,
                "1230346"));
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
        VRBindPathParser.set("1230347",defaultMap,new Integer(1));
        // �l�����Z
        VRBindPathParser.set("1230346",defaultMap,new Integer(1));
        // ���W�J
        // ���g(this)��defaultMap�ɐݒ肷��B
        getThis().setSource(defaultMap);
        // �����I�����ڂ�W�J����B
        getThis().bindSource();

        
    }

  /**
     * �u���Ə��R���{�ύX���֐��v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public void providerSelected(VRMap provider) throws Exception {
        // �����Ə��R���{�ύX���ɌĂԊ֐�
        // �I�����Ə����null�łȂ��ꍇ
        setSelectedProvider(provider);
        
        if (provider != null) {
            // ���ȉ��̓��e�ڍ׍��ڂ́A�I�����Ə��̒l��ݒ肷��B
            // ������
            // ���Ə��A���p�̃��R�[�h defaultMap �𐶐�����B
            VRMap defaultMap = new VRHashMap();
            // ���ݒ�
            Object obj;
            // �{�݋敪
            obj = VRBindPathParser.get("1230301", provider);
            if (obj != null) {
            	if(ACCastUtilities.toInt(obj) == 3){
            		// �u�o�ߌ^�v�̏ꍇ
            		defaultMap.setData("1230301", new Integer(4));
            	}else{
            		// �u�o�ߌ^�v�ȊO�̏ꍇ
            		defaultMap.setData("1230301", obj);
            	}
            }
            // �l���z�u�敪
            obj = VRBindPathParser.get("1230302", provider);
            if (obj != null) {
                defaultMap.setData("1230302", obj);
            }
            // �l�����Z
            obj = VRBindPathParser.get("1230306", provider);
            if (obj != null) {
                //���Ə��o�^�̌��Z���ڂɍ��킹�����l�𒲐�
                switch(ACCastUtilities.toInt(obj)){
                case 1: //�Ȃ��������ꍇ
                case 2: //��t�������ꍇ
                    VRBindPathParser.set("1230346", defaultMap, new Integer(1));
                    break;
                case 3: //�Ō�E���������ꍇ
                case 4: //���E���������ꍇ
                    VRBindPathParser.set("1230346", defaultMap, new Integer(3));
                    break;
                }
            }
            // ���}
            obj = VRBindPathParser.get("1230303", provider);
            if (obj != null) {
                switch (ACCastUtilities.toInt(obj)) {
                case 2:
                    // �u����v�̏ꍇ
                    // ���}�敪(shortStayDementiaRecuperationMeetingAndSendingOff)��3�Ԗڂ̃{�^����I���ɂ���B
                    defaultMap.setData("6", new Integer(3));
                    break;
                case 1:
                    // �u�Ȃ��v�̏ꍇ
                    // ���}�敪(shortStayDementiaRecuperationMeetingAndSendingOff)��1�Ԗڂ̃{�^����I���ɂ���B
                    defaultMap.setData("6", new Integer(1));
                    break;
                }
            }
            // ���ȉ��̓��e�ڍ׍��ڂ́A�I�����Ə��́u�Ȃ��v�u����v�ɂ���āA����/�L����؂�ւ���B
            // �h�{�Ǘ��̐�
            obj = VRBindPathParser.get("1230304", provider);
            if (obj != null) {
                if(new Integer(2).equals(ACCastUtilities.toInteger(obj))){
                    VRBindPathParser.set("1230306",defaultMap,new Integer(3));
                }else if(new Integer(3).equals(ACCastUtilities.toInteger(obj))){
                    VRBindPathParser.set("1230306",defaultMap,new Integer(2));
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
            obj = VRBindPathParser.get("1230305", provider);
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
            // ���j�b�g�P�A���Z
            obj = VRBindPathParser.get("1230315", provider);
            if (obj != null) {
                switch (ACCastUtilities.toInt(obj)) {
                case 2:
                    // �u����v�̏ꍇ
                    // �L���ɂ���B
                    setState_VALID_UNIT_CARE();
                    defaultMap.setData("1230309", obj);
                    setUnitCareFlag(true);
                    break;
                case 1:
                    // �u�Ȃ��v�̏ꍇ
                    // �����ɂ���B
                    setState_INVALID_UNIT_CARE();
                    defaultMap.setData("1230309", obj);
                    setUnitCareFlag(false);
                    break;
                }
            }else{
                //���Ə��o�^�œo�^����Ă��Ȃ������ꍇ�͈ꗥ�����ɂ���B
                setUnitCareFlag(false);
            }
            
            // �ً}�Z�������l�b�g���[�N���Z
            obj = VRBindPathParser.get("1230316", provider);
            if (obj != null) {
                switch (ACCastUtilities.toInt(obj)) {
                case 2:
                    // �u����v�̏ꍇ
                    // �L���ɂ���B
                    setState_VALID_NETWORK_ADD();
//                    defaultMap.setData("1230310", obj);
                    break;
                case 1:
                    // �u�Ȃ��v�̏ꍇ
                    // �����ɂ���B
                    setState_INVALID_NETWORK_ADD();
                    defaultMap.setData("1230310", obj);
                    break;
                }
            }
            // ���W�J
            // ���g(this)��defaultMap�ɐݒ肷��B
            getThis().setSource(defaultMap);
            // �����I�����ڂ�W�J����B
            getThis().bindSource();
            
            if(getShortStayDementiaRecuperationDinnerOffer().getSelectedIndex()==0){
                //�H��Ȃ��̏ꍇ�ɂ̂ݒ�����ɂ���B
                getShortStayDementiaRecuperationDinnerOffer().setSelectedIndex(1);
            }
            
        }
    }

  /**
     * �u���͓��e�̕s���������v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public VRMap getValidData() throws Exception {
        // �����͓��e�ɕs�����Ȃ������`�F�b�N���A�T�[�r�X�f�[�^��Ԃ��B
        if (getShortStayDementiaRecuperationDinnerOffer().getSelectedIndex() > 0) {
            // �H���񋟁ishortStayDementiaRecuperationDinnerOffer)���u�Ȃ��v�ȊO��I�����Ă���ꍇ
            if (ACTextUtilities.isNullText(getShortStayDementiaRecuperationDinnerCost().getText())) {
                // �H����p(shortStayDementiaRecuperationDinnerCost)���󗓂̏ꍇ
                // ���e�ڍׂ̕s�����b�Z�[�W��\������B��ID=QS001_ERROR_OF_NO_CONTENT
                QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
                // null��Ԃ��B
                return null;
            }
        }
        //�l���z�u�敪���L���ł���ꍇ
        if(getShortStayDementiaRecuperationDivision().isEnabled()){
            //���ݑI�𒆂̃{�^���������ł������ꍇ
            if(!getShortStayDementiaRecuperationDivision().getSelectedButton().isEnabled()){
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
     * @throws Exception ������O
     */
    public boolean isUseProvider() throws Exception {
        // �����Ə���񂪕K�v�ȃT�[�r�X�ł��邩��Ԃ��B
        // true��Ԃ��B
        return true;
    }

  /**
     * �u�J�n�������͗p�̃R���{�擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public ACComboBox getBeginTimeCombo() throws Exception {
        // ���J�n�������͗p�̃R���{��Ԃ��B
        // �֐��̕Ԃ�l�Ƃ��ĊJ�n���ԃR���{��Ԃ��B
        return null;
    }

    /**
     * �u�I���������͗p�̃R���{�擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public ACComboBox getEndTimeCombo() throws Exception {
        // ���I���������͗p�̃R���{��Ԃ��B
        // �֐��̕Ԃ�l�Ƃ��ďI�����ԃR���{��Ԃ��B
        return null;
    }

  
  /**
   * �u�H����p���擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
   * 
   * @param meatType int
   * @throws Exception ������O
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
                      .get("1230307", getSelectedProvider()), 0));
          case 2:
              // �H���������u���̂݁v�̏ꍇ
              // �u���v�̐H���Ԃ��B
              return String.valueOf(ACCastUtilities.toInt(VRBindPathParser
                      .get("1230308", getSelectedProvider()), 0));
          case 3:
              // �H���������u���̂݁v�̏ꍇ
              // �u���v�̐H���Ԃ��B
              return String.valueOf(ACCastUtilities.toInt(VRBindPathParser
                      .get("1230309", getSelectedProvider()), 0));
          case 4:
              // �H���������u��̂݁v�̏ꍇ
              // �u��v�̐H���Ԃ��B
              return String.valueOf(ACCastUtilities.toInt(VRBindPathParser
                      .get("1230310", getSelectedProvider()), 0));
          case 5:
              // �H���������u�����v�̏ꍇ
              // �u���v�̐H��A�u���v�̐H��̐H��̍��Z��Ԃ��B
              return String.valueOf(ACCastUtilities.toInt(VRBindPathParser
                      .get("1230308", getSelectedProvider()),0)
                      + ACCastUtilities.toInt(VRBindPathParser.get("1230309",
                              getSelectedProvider()), 0));
          case 6:
              // �H���������u����v�̏ꍇ
              // �u���v�̐H��A�u��v�̐H��̐H��̍��Z��Ԃ��B
              return String.valueOf(ACCastUtilities.toInt(VRBindPathParser
                      .get("1230309", getSelectedProvider()),0)
                      + ACCastUtilities.toInt(VRBindPathParser.get("1230310",
                              getSelectedProvider()), 0));
          case 7:
              // �H���������u�钩�v�̏ꍇ
              // �u��v�̐H��A�u���v�̐H��̐H��̍��Z��Ԃ��B
              return String.valueOf(ACCastUtilities.toInt(VRBindPathParser
                      .get("1230310", getSelectedProvider()),0)
                      + ACCastUtilities.toInt(VRBindPathParser.get("1230308",
                              getSelectedProvider()), 0));
          }
      }
      // �󕶎���Ԃ��B
      return "";
  }
  
  /**
     * �l���z�u�敪�Ɋւ��鐧����s���܂��B
     */
    public void changeState() throws Exception {
        // �{�݋敪 �F�m�ǎ����^���I������Ă����ꍇ
        if (getShortStayDementiaRecuperationInstitutionDivisionRadioItem1()
                .isSelected()) {
            // �l���z�u�敪��L���ɂ���B
            setState_VALID_STAFF();
            // ��w�a�@���I������Ă����ꍇ
            // �T�^��\����Ԃɂ���B
            if (getShortStayDementiaRecuperationHospitalDivisionRadioItem1()
                    .isSelected()) {
                setState_SELECT_HOSPITAL();
            } else {
                // �a�@���I������Ă����ꍇ
                // �l�����Z�敪�u�Ō�E���E���������̏ꍇ�v�u���Ŕ䗦��20%�����̏ꍇ�v�u�ƒn�͏o���v���I������Ă��邩�`�F�b�N����B
                if (getStaffAssignmentFlag()) {
                    // �W�E�X�^��I���\�ɂ���B
                    setState_UNSELECT_HOSPITAL();
                } else {
                    // �T�^�ȊO��I���\�ɂ���B
                    setState_INVALID_STAFF_DIVISION1();
                }
            }
        } else {
            //�l���z�u�敪�𖳌��ɂ���B
            setState_INVALID_STAFF();
        }
    }

protected void shortStayDementiaRecuperationHospitalDivisionRadioActionPerformed(ActionEvent e) throws Exception {
    changeState();
}


    public void binded() throws Exception{
        if (getShortStayDementiaRecuperationSpecificConsultationFee()
                .getDataModel().isEmpty()) {
            // ����f�Ô�{�^���̃f�[�^����̏ꍇ
            // ����f�Ô�x���Ɂu�ݒ�Ȃ��v�ƕ\������B
            getShortStayDementiaRecuperationSpecificConsultationFeeOutline()
                    .setText("�ݒ�Ȃ�");
        } else {
            // ����f�Ô�{�^���̃f�[�^����ł͂Ȃ��ꍇ
            // ����f�Ô�x���Ɂu�ݒ肠��v�ƕ\������B
            getShortStayDementiaRecuperationSpecificConsultationFeeOutline()
                    .setText("�ݒ肠��");
        }
    }
}
