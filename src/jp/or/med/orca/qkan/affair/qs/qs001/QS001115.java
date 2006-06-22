
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
 * �J����: ���}�@�M�u
 * �쐬��: 2006/02/23  ���{�R���s���[�^�[������� ���}�@�M�u �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �T�[�r�X�\��쐬/�ύX (S)
 * �v���Z�X �T�[�r�X�\�� (001)
 * �v���O���� �T�[�r�X�p�^�[������{�ݓ����Ґ������ (QS001115)
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
 * �T�[�r�X�p�^�[������{�ݓ����Ґ������(QS001115) 
 */
public class QS001115 extends QS001115Event {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001115(){
  }

  //�R���|�[�l���g�C�x���g

  public static void main(String[] args) {
    //�f�t�H���g�f�o�b�O�N��
    ACFrame.getInstance().setFrameEventProcesser(new QkanFrameEventProcesser());
    QkanCommon.debugInitialize();
    VRMap param = new VRHashMap();
    //param�ɓn��p�����^���l�߂Ď��s���邱�ƂŁA�ȈՃf�o�b�O���\�ł��B
    ACFrame.debugStart(new ACAffairInfo(QS001115.class.getName(), param));
  }
  
  /**
     * �{�݋敪�I�����̃C�x���g
     */
    protected void facilitiesDivisionRadioActionPerformed(ActionEvent e)
            throws Exception {
        if (getFacilitiesDivisionRadio().getSelectedIndex() == 1) {
            // ����{��
            setState_SELECT_SPECIAL();
            if(!getFunctionTrainingFlag()){
                setState_INVALID_TRAINING();
            }

        } else if (getFacilitiesDivisionRadio().getSelectedIndex() == 2) {
            // �O���T�[�r�X���p�^
            setState_SELECT_OUT();
            VRMap comboItemMap = new VRHashMap();
            switch (getOutsideServiceRadio().getSelectedIndex()) {
            case 1:
                // �K����
                setState_SELECT_VISIT();
                
                
                break;
            case 2:
                // �K��������
                setState_SELECT_VISIT_BATH();
                break;
            case 3:
                // �K��Ō�I�����ɢ�E���敪�PT�EOT�EST���I�΂ꂽ�ꍇ
                if (getVisitNursingStaffDivisionRadio().getSelectedIndex() == 2) {
                    // �����ԋ敪
                    // �R�[�h�}�X�^�f�[�^���CODE_ID�F34 �ʏ����n�i���ԋ敪�j���擾����B
                    // �擾�����l���AcomboItemMap�� KEY : 1330112 �� VALUE �Ƃ��Đݒ肷��B
                    comboItemMap.setData("1330112", QkanCommon
                            .getArrayFromMasterCode(34, "1330112"));
                    // ���W�J
                    // ���g(this)��comboItemMap�ɐݒ肷��B
                    getThis().setModelSource(comboItemMap);
                    // �R���{�A�C�e����W�J����B
                    getThis().bindModelSource();
                }
                setState_SELECT_VISIT_NURSING();
                break;
            case 4:
                // �K�⃊�n
                setState_SELECT_VISIT_REHABILI();
                break;
            case 5:
                // �ʏ����
                // �O���T�[�r�X���p�^���I�΂�Ă����ꍇ
                setState_SELECT_EXPERTPLACE_NURSING();
                break;
            case 6:
                // �ʏ����n
                // �O���T�[�r�X���p�^���I�΂�Ă����ꍇ
                setState_SELECT_EXPERTPLACE_REHABILI();
                break;
            case 7:
                // �����p��ݗ^
                // �O���T�[�r�X���p�^���I�΂�Ă����ꍇ
                setState_SELECT_WELFARE_TOOLS();
                break;
            case 8:
                //�F�m�ǑΉ��^�ʏ����
                //�O���T�[�r�X���p�^���I�΂�Ă����ꍇ
                setState_SELECT_NINTITUUSHO();
                break;
            case 9:
                //�Ȃ�
                //�O���T�[�r�X���p�^���I�΂�Ă����ꍇ
                setState_SELECT_ONLY_BASE();
                break;
            }
        }
    }

  /**
     * �O���T�[�r�X�I�����̃C�x���g
     */
    protected void outsideServiceRadioActionPerformed(ActionEvent e)
            throws Exception {
        VRMap comboItemMap = new VRHashMap();
        switch (getOutsideServiceRadio().getSelectedIndex()) {
        case 1:
            // �K����
            // �O���T�[�r�X���p�^���I�΂�Ă����ꍇ
            if (getOutsideServiceRadio().isEnabled()) {
                setState_SELECT_VISIT();
            }
            break;
        case 2:
            // �K��������
            setState_SELECT_VISIT_BATH();
            break;
        case 3:
            // �K��Ō�I�����ɢ�E���敪�PT�EOT�EST���I�΂ꂽ�ꍇ
            // �O���T�[�r�X���p�^���I�΂�Ă����ꍇ
            if (getOutsideServiceRadio().isEnabled()) {
                if (getVisitNursingStaffDivisionRadio().getSelectedIndex() == 2) {
                    // �����ԋ敪
                    // �R�[�h�}�X�^�f�[�^���CODE_ID�F34 �ʏ����n�i���ԋ敪�j���擾����B
                    // �擾�����l���AcomboItemMap�� KEY : 1330112 �� VALUE �Ƃ��Đݒ肷��B
                    comboItemMap.setData("1330112", QkanCommon
                            .getArrayFromMasterCode(34, "1330112"));
                    // ���W�J
                    // ���g(this)��comboItemMap�ɐݒ肷��B
                    getThis().setModelSource(comboItemMap);
                    // �R���{�A�C�e����W�J����B
                    getThis().bindModelSource();
                }
                setState_SELECT_VISIT_NURSING();
            }
            break;
        case 4:
            // �K�⃊�n
            // �O���T�[�r�X���p�^���I�΂�Ă����ꍇ
            if (getOutsideServiceRadio().isEnabled()) {
                setState_SELECT_VISIT_REHABILI();
            }
            break;
        case 5:
            // �ʏ����
            // �O���T�[�r�X���p�^���I�΂�Ă����ꍇ
            if (getOutsideServiceRadio().isEnabled()) {
                setState_SELECT_EXPERTPLACE_NURSING();
            }
            break;
        case 6:
            // �ʏ����n
            // �O���T�[�r�X���p�^���I�΂�Ă����ꍇ
            if (getOutsideServiceRadio().isEnabled()) {
                setState_SELECT_EXPERTPLACE_REHABILI();
            }
            break;
        case 7:
            // �����p��ݗ^
            // �O���T�[�r�X���p�^���I�΂�Ă����ꍇ
            if (getOutsideServiceRadio().isEnabled()) {
                setState_SELECT_WELFARE_TOOLS();
            }
            break;
        case 8:
            //�F�m�ǑΉ��^�ʏ����
            //�O���T�[�r�X���p�^���I�΂�Ă����ꍇ
            if (getOutsideServiceRadio().isEnabled()) {
                setState_SELECT_NINTITUUSHO();
            }
            break;
        case 9:
            //�Ȃ�
            //�O���T�[�r�X���p�^���I�΂�Ă����ꍇ
            if (getOutsideServiceRadio().isEnabled()) {
                setState_SELECT_ONLY_BASE();
            }
            break;
        }

    }
  //�����֐�

  /**
     * �u�������v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
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
        // �擾�����l���AcomboItemMap�� KEY : 3 �� VALUE �Ƃ��Đݒ肷��B
        comboItemMap.setData("3", QkanCommon.getArrayFromMasterCode(23, "3"));
        // ���I������
        // �R�[�h�}�X�^�f�[�^���CODE_ID�F23�i�����E�j���̑I�� / ����(�J�n)�j���擾����B
        // �擾�����l���AcomboItemMap�� KEY : 4 �� VALUE �Ƃ��Đݒ肷��B
        comboItemMap.setData("4", QkanCommon.getArrayFromMasterCode(23, "4"));
        // �����ԋ敪
        // �R�[�h�}�X�^�f�[�^���CODE_ID�F223 �K����i���ԋ敪�j���擾����B
        // �擾�����l���AcomboItemMap�� KEY : 1330114 �� VALUE �Ƃ��Đݒ肷��B
        comboItemMap.setData("1330109", QkanCommon.getArrayFromMasterCode(239,
                "1330109"));
        // �����ԋ敪
        // �R�[�h�}�X�^�f�[�^���CODE_ID�F207 �K��Ō�i���ԋ敪�j���擾����B
        // �擾�����l���AcomboItemMap�� KEY : 1330112 �� VALUE �Ƃ��Đݒ肷��B
        comboItemMap.setData("1330112", QkanCommon.getArrayFromMasterCode(207,
                "1330112"));
        // �����ԋ敪
        // �R�[�h�}�X�^�f�[�^���CODE_ID�F40 �ʏ����i���ԋ敪�j���擾����B
        // �擾�����l���AcomboItemMap�� KEY : 1330115 �� VALUE �Ƃ��Đݒ肷��B
        comboItemMap.setData("1330115", QkanCommon.getArrayFromMasterCode(240,
                "1330115"));
        // �����ԋ敪
        // �R�[�h�}�X�^�f�[�^���CODE_ID�F40 �ʏ����n�i���ԋ敪�j���擾����B
        // �擾�����l���AcomboItemMap�� KEY : 1330117 �� VALUE �Ƃ��Đݒ肷��B
        comboItemMap.setData("1330117", QkanCommon.getArrayFromMasterCode(241,
                "1330117"));
        // �����p��
        comboItemMap.setData("1330118", QkanCommon.getArrayFromMasterCode(47,
                "1330118"));
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
        QkanCommon.selectFirstRadioItem(getThis());
        defaultMap.setData("1330107", new Integer(9));
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
        if (provider != null) {
            // ���ȉ��̓��e�ڍ׍��ڂ́A�I�����Ə��̒l��ݒ肷��B
            // ������
            // ���Ə��A���p�̃��R�[�h defaultMap �𐶐�����B
            VRMap defaultMap = new VRHashMap();
            // ���ݒ�
            // ���ȉ��̓��e�ڍ׍��ڂ́A�I�����Ə��́u�Ȃ��v�u����v�ɂ���āA����/�L����؂�ւ���B
            Object obj = VRBindPathParser.get("1330103", provider);
            // �{�݋敪
            if (obj != null) {
                switch (ACCastUtilities.toInt(obj)) {
                case 1:
                    // ����{��
                    defaultMap.setData("1330105", obj);
                    break;
                case 2:
                    // �O���T�[�r�X
                    defaultMap.setData("1330105", obj);
                    break;
                }
            }
            // �ʋ@�\�P���w�����Z
            obj = VRBindPathParser.get("1330101", provider);
            if (obj != null) {
                switch (ACCastUtilities.toInt(obj)) {
                case 1:
                    // �Ȃ�
                    setState_INVALID_TRAINING();
                    setFunctionTrainingFlag(false);
                    defaultMap.setData("1330103", obj);
                    break;
                case 2:
                    // ����
                    //����{�݂��I����Ԃł���ꍇ
                    if(getFacilitiesDivisionRadioItem1().isSelected()){
                        setState_VALID_TRAINING();
                        
                    }
                    setFunctionTrainingFlag(true);
                    defaultMap.setData("1330103", obj);
                    break;
                }
            }
            // ��ԊŌ�̐����Z
            obj = VRBindPathParser.get("1330104", provider);
            if (obj != null) {
                switch (ACCastUtilities.toInt(obj)) {
                case 1:
                    // �Ȃ�
//                    setState_INVALID_NIGHT_NURSING();
                    defaultMap.setData("1330106", obj);
                    break;
                case 2:
                    // ����
                    //����{�݂��I����Ԃł���ꍇ
//                    if(getFacilitiesDivisionRadioItem1().isSelected()){
//                        setState_VALID_NIGHT_NURSING();
//                    }
                    defaultMap.setData("1330106", obj);
                    break;
                }
            }
            // �l�����Z
            obj = VRBindPathParser.get("1330102", provider);
            if (obj != null) {
               //���Ə��o�^�̌��Z���ڂɍ��킹�����l�𒲐�
                switch(ACCastUtilities.toInt(obj)){
                case 1: //�Ȃ��������ꍇ
                    VRBindPathParser.set("1330104", defaultMap, new Integer(1));
                    break;
                case 2: //�Ō�E���������ꍇ
                case 3: //���E���������ꍇ
                    VRBindPathParser.set("1330104", defaultMap, new Integer(2));
                    break;
                }
            }
            // ���W�J
            // ���g(this)��defaultMap�ɐݒ肷��B
            getThis().setSource(defaultMap);
            // �����I�����ڂ�W�J����B
            getThis().bindSource();

        }
    }

  /**
   * �u���͓��e�̕s���������v�Ɋւ��鏈�����s�Ȃ��܂��B
   * @throws Exception ������O
   */
  public VRMap getValidData() throws Exception{
    // �����͓��e�ɕs�����Ȃ������`�F�b�N���A�T�[�r�X�f�[�^��Ԃ��B
      //�J�n�����敪���L���ȏꍇ
      if (getSpecificFacilityBeginTime().isEnabled()) {
          //�K�⃊�n�E�K��������E�����p��ݗ^�̏ꍇ�͎��ԃ`�F�b�N���s��Ȃ��B
            if (!getOutsideServiceRadioItem4().isSelected()
                    && !getOutsideServiceRadioItem2().isSelected()
                    && !getOutsideServiceRadioItem7().isSelected()
                    &&!getOutsideServiceRadioItem0().isSelected()) {
                if (ACTextUtilities.isNullText(getSpecificFacilityBeginTime()
                        .getText())
                        || ACTextUtilities
                                .isNullText(getSpecificFacilityEndTime()
                                        .getText())
                        || (!getSpecificFacilityBeginTime().isValidDate())
                        || (!getSpecificFacilityEndTime().isValidDate())) {
                    // �J�n�����R���{(houmonRehabilitationTimeContenaBeginTime)���󗓂��s���̏ꍇ
                    // �������͏I�������R���{(houmonRehabilitationTimeContenaEndTime)���󗓂��s���̏ꍇ
                    // �����̕s�����b�Z�[�W��\������B��ID=QS001_ERROR_OF_NO_TIME
                    QkanMessageList.getInstance().QS001_ERROR_OF_NO_TIME();
                    // null��Ԃ��B
                    return null;
                }
            }
        }
      //�K����{�݋敪���L���ł���ꍇ
      if(getVisitCareCombo().isEnabled()){
          //�����R���{�̒l���`�F�b�N����
          if(!getVisitCareCombo().isSelected()){
              //���e�̕s�����b�Z�[�W��\������B��ID=QS001_ERROR_OF_NO_CONTENT
              QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
              // null��Ԃ��B
              return null;
          }

      }
      //�K��Ō�@�����R���{���L���ȏꍇ
      if(getVisitNursingFacilitiesDivisionRadio().isEnabled()){
          if(!getVisitNursingCombo().isSelected()){
              //���e�̕s�����b�Z�[�W��\������B��ID=QS001_ERROR_OF_NO_CONTENT
              QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
              // null��Ԃ��B
              return null;
          }
          //�E���敪���`�F�b�N����B
          if(!getVisitNursingStaffDivisionRadio().getSelectedButton().isEnabled()){
              //���e�̕s�����b�Z�[�W��\������B��ID=QS001_ERROR_OF_NO_CONTENT
              QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
              // null��Ԃ��B
              return null;              
          }
      }
      //�ʏ����@�����R���{���L���ȏꍇ
      if(getExpertPlaceNursingCombo().isEnabled()){
          if(!getExpertPlaceNursingCombo().isSelected()){
              //���e�̕s�����b�Z�[�W��\������B��ID=QS001_ERROR_OF_NO_CONTENT
              QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
              // null��Ԃ��B
              return null;
          }
      }
      //�ʏ����n�@�����R���{���L���ȏꍇ
      if(getExpertPlaceRehabiliCombo().isEnabled()){
          if(!getExpertPlaceRehabiliCombo().isSelected()){
              //���e�̕s�����b�Z�[�W��\������B��ID=QS001_ERROR_OF_NO_CONTENT
              QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
              // null��Ԃ��B
              return null;
          }
      }
      
      //�����p��@�����p��̎�ނ��I������Ă��邩�`�F�b�N����B
      if(getWelfareToolsCombo().isEnabled()){
          //�p���ނ��I������Ă��Ȃ������ꍇ
          if(!getWelfareToolsCombo().isSelected()){
              //���e�̕s�����b�Z�[�W��\������B��ID=QS001_ERROR_OF_NO_CONTENT
              QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
              // null��Ԃ��B
              return null;              
          }
          //�P�ʐ������͂���Ă��Ȃ������ꍇ
          if("".equals(getWelfarePointText().getText())){
              //���e�̕s�����b�Z�[�W��\������B��ID=QS001_ERROR_OF_NO_CONTENT
              QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
              // null��Ԃ��B
              return null;
          }
          //�E�v�������͂���Ă��Ȃ������ꍇ
          if("".equals(getWelfareTekiyoText().getText())){
              //���e�̕s�����b�Z�[�W��\������B��ID=QS001_ERROR_OF_NO_CONTENT
              QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
              // null��Ԃ��B
              return null;              
          }
          
      }
      
    // ���ԋp�p�̃��R�[�h(data)�𐶐�
    VRMap data = new VRHashMap();
    // �@���g(this)�̃\�[�X�Ƃ��Đ������R�[�h��ݒ肷��B
    getThis().setSource(data);
    // �@���g(this)��applySource���Ăяo���ăf�[�^�����W����B
    getThis().applySource();
    // ���ԋp�p���R�[�h����s�v�ȃL�[������
    QkanCommon.removeDisabledBindPath(getThis(), data);
    // �@���Ȃ���Εԋp�p���R�[�h(data)��Ԃ��B
return data;
  }

  /**
   * �u���Ə����̕K�v�����擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
   * @throws Exception ������O
   */
  public boolean isUseProvider() throws Exception{
    // �����Ə���񂪕K�v�ȃT�[�r�X�ł��邩��Ԃ��B
    // �@true��Ԃ��B
return true;
  }

  /**
   * �u�J�n�������͗p�̃R���{�擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
   * @throws Exception ������O
   */
  public ACComboBox getBeginTimeCombo() throws Exception{
    // ���J�n�������͗p�̃R���{��Ԃ��B
      if(getFacilitiesDivisionRadio().getSelectedIndex() == 1){
          return null;
      }
      //�O�����p�^�������ꍇ
      // �@�֐��̕Ԃ�l�Ƃ��ĊJ�n���ԃR���{��Ԃ��B
      return getSpecificFacilityBeginTime();
  }

  /**
   * �u�I���������͗p�̃R���{�擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
   * @throws Exception ������O
   */
  public ACComboBox getEndTimeCombo() throws Exception{
    // ���I���������͗p�̃R���{��Ԃ��B

      if(getFacilitiesDivisionRadio().getSelectedIndex() == 1){
          return null;
      }
      //�O�����p�^�������ꍇ
      // �@�֐��̕Ԃ�l�Ƃ��ďI�����ԃR���{��Ԃ��B
      return getSpecificFacilityEndTime();
  }

  /**
   * �u���ԋ敪�̎��Ԏ擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
   * 
   * @throws Exception ������O
   */
  public int getKangoTime() throws Exception {
      // �����ԋ敪(VisitCareCombo)�̎��Ԃ��擾
      // ���ԋ敪(VisitCareCombo)�̒l���`�F�b�N����B
      switch (getVisitCareCombo().getSelectedIndex()) {
      case 0:
          // 15�������̏ꍇ
          // �߂�l�Ƃ���180��Ԃ��B
          return 15;
      case 1:
          // 30�������̏ꍇ
          // �߂�l�Ƃ���240��Ԃ��B
          return 30;
      case 2:
          // 45�������̏ꍇ
          // �߂�l�Ƃ���360��Ԃ��B
          return 45;
      case 3:
          // 1���Ԗ����̏ꍇ
          // �߂�l�Ƃ���480��Ԃ��B
          return 60;
      case 4:
          // 1����15�������̏ꍇ
          // �߂�l�Ƃ���540��Ԃ��B
          return 75;
      case 5:
      case 6:
          // 1����30�������̏ꍇ
//        1����30���ȏ�̏ꍇ
          // �߂�l�Ƃ���600��Ԃ��B
          return 90;
      }
      return 0;
  }
  
  
  /**
   * �u���ԋ敪�̎��Ԏ擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
   * 
   * @throws Exception ������O
   */
  public int getTuusyoKaigoTime() throws Exception {
      // �����ԋ敪(VisitCareCombo)�̎��Ԃ��擾
      // ���ԋ敪(VisitCareCombo)�̒l���`�F�b�N����B
      switch (getExpertPlaceNursingCombo().getSelectedIndex()) {
      case 0:
          // �Q���Ԉȏ�R���Ԗ����̏ꍇ
          // �߂�l�Ƃ���180��Ԃ��B
          return 180;
      case 1:
          // �R���Ԉȏ�S���Ԗ����̏ꍇ
          // �߂�l�Ƃ���240��Ԃ��B
          return 240;
      case 2:
          // �S���Ԉȏ�U���Ԗ����̏ꍇ
          // �߂�l�Ƃ���360��Ԃ��B
          return 360;
      case 3:
          // �U���Ԉȏ�W���Ԗ����̏ꍇ
          // �߂�l�Ƃ���480��Ԃ��B
          return 480;
      case 4:
          // �W���Ԉȏ�X���Ԗ����̏ꍇ
          // �߂�l�Ƃ���540��Ԃ��B
          return 540;
      case 5:
          // �X���Ԉȏ�P�O���Ԗ����̏ꍇ
          // �߂�l�Ƃ���600��Ԃ��B
          return 600;
      }
      return 0;
  }
  
  /**
   * �u���ԋ敪�̎��Ԏ擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
   * 
   * @throws Exception ������O
   */
  public int getTuusyoKaigoTimeSpecial() throws Exception {
      // �����ԋ敪(VisitCareCombo)�̎��Ԃ��擾
      // ���ԋ敪(VisitCareCombo)�̒l���`�F�b�N����B
      switch (getExpertPlaceNursingCombo().getSelectedIndex()) {
      case 0:
          // 2���Ԉȏ�6���Ԗ����̏ꍇ
          // �߂�l�Ƃ���180��Ԃ��B
          return 360;
      case 1:
          // 6���Ԉȏ�8���Ԗ����̏ꍇ
          // �߂�l�Ƃ���240��Ԃ��B
          return 480;
      }
      return 0;
  }
  /**
   * �u�K��Ō쎞�ԋ敪�̎��Ԏ擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
   * 
   * @throws Exception ������O
   */
  public int getHoumonKangoTimeSpecial() throws Exception {
      // �����ԋ敪(VisitCareCombo)�̎��Ԃ��擾
      // ���ԋ敪(VisitCareCombo)�̒l���`�F�b�N����B
      switch (getVisitNursingCombo().getSelectedIndex()) {
      case 0:
          // 30�������̏ꍇ
          return 30;
      case 1:
          // 1���Ԕ������̏ꍇ
          return 90;
      }
      return 0;
  }
  
  /**
   * �u�K��Ō쎞�ԋ敪�̎��Ԏ擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
   * 
   * @throws Exception ������O
   */
  public int getHoumonKangoTime() throws Exception {
      // �����ԋ敪(VisitCareCombo)�̎��Ԃ��擾
      // ���ԋ敪(VisitCareCombo)�̒l���`�F�b�N����B
      switch (getVisitNursingCombo().getSelectedIndex()) {
      case 0:
          // 20���ȏ�̏ꍇ
          // �߂�l�Ƃ���180��Ԃ��B
          return 20;
      case 1:
          // 30���ȏ�̏ꍇ
          // �߂�l�Ƃ���240��Ԃ��B
          return 30;
      case 2:
          //1���Ԉȏ�̏ꍇ
          return 60;
      case 3:
          //1����30���ȏ�̏ꍇ
          return 90;
      }
      return 0;
  }
  
  /**
   * �u�ʏ����n���ԋ敪�̎��Ԏ擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
   * 
   * @throws Exception ������O
   */
  public int getTuusyoRihaTime() throws Exception {
      // �����ԋ敪(VisitCareCombo)�̎��Ԃ��擾
      // ���ԋ敪(VisitCareCombo)�̒l���`�F�b�N����B
      switch (getExpertPlaceRehabiliCombo().getSelectedIndex()) {
      case 0:
          // 3���Ԗ����̏ꍇ
          // �߂�l�Ƃ���180��Ԃ��B
          return 120;
      case 1:
          // 4���Ԗ����̏ꍇ
          // �߂�l�Ƃ���240��Ԃ��B
          return 180;
      case 2:
          //4���Ԉȏ�̏ꍇ
          return 240;
      case 3:
          //6���Ԉȏ�̏ꍇ
          return 360;
      }
      return 0;
  }
  
  /**
   * �u�F�m�ǑΉ��ʏ����̎��ԋ敪�̎��Ԏ擾�v�Ɋւ��鏈�����s���܂��B
   * @return
   * @throws Exception
   */
  public int getNintiTaiouTusyoKaigoTime() throws Exception{
      // �����ԋ敪(timeDivisionRadio)�̎��Ԃ��擾
      // ���ԋ敪(timeDivisionRadio)�̒l���`�F�b�N����B
      switch (getTimeDivisionRadio().getSelectedIndex()) {
      case 1:
          // 3���Ԗ����̏ꍇ
          // �߂�l�Ƃ���180��Ԃ��B
          return 180;
      case 2:
          // 4���Ԗ����̏ꍇ
          // �߂�l�Ƃ���240��Ԃ��B
          return 240;
      case 3:
          //6���Ԉȏ�̏ꍇ
          return 360;
      case 4:
          //8���Ԉȏ�̏ꍇ
          return 480;
      }
      
      
      return 0;
  }
  
  /**
   * �u�I�����Ԃ̃`�F�b�N�v�Ɋւ��鏈�����s�Ȃ��܂��B
   * 
   * @throws Exception ������O
   */
  public void checkEndTime() throws Exception {
      // �����ԑѕύX���A�I�����Ԃ��ύX
      // �J�n���ԃR���{(houmonRehabilitationTimeContenaBeginTime)�̒l���󗓂���ѕs���łȂ��ꍇ
      // ���ԑޔ�p�̕ϐ�kangoTime�ɁA���ԋ敪����擾�������Ԃ�ݒ肷��B

      // �I�����Ԃ��u�J�n���� + kangoTime(��)�v�ɐݒ肷��B
      if (getSpecificFacilityBeginTime().isValidDate()
              && (!ACTextUtilities
                      .isNullText(getSpecificFacilityBeginTime()
                              .getText()))) {
          // �J�n���ԃR���{(houmonKangoKaigoBeginTime)�̒l���󗓂���ѕs���łȂ��ꍇ
          // ���ԑޔ�p�̕ϐ�kangoTime�ɁA�K��Ō쎞�ԋ敪����擾�������Ԃ�ݒ肷��B
          int addTime = 0;
          switch(getOutsideServiceRadio().getSelectedIndex()){
          case 1:
              //�K����
              addTime = getKangoTime();
              break;
          case 3:
                // �K��Ō�
                // �K��Ō�X�e�[�V�����łȂ�����PT�EOT�EST�������ꍇ
                if (getVisitNursingStaffDivisionRadioItem2().isSelected()
                        && getVisitNursingFacilitiesDivisionRadioItem1()
                                .isSelected()) {
                    addTime = getHoumonKangoTimeSpecial();
                } else {
                    addTime = getHoumonKangoTime();
                }
                break;
            case 5:
              //�ʏ����
                if(getExpertPlaceNursingRadioItem3().isSelected()){
                    addTime = getTuusyoKaigoTimeSpecial();
                }else{
                    addTime = getTuusyoKaigoTime();
                }
              break;
          case 6://�ʏ����n
              addTime = getTuusyoRihaTime();
              break;
              
          case 8://�F�m�ǑΉ��^�ʏ����
              addTime = getNintiTaiouTusyoKaigoTime();
              break;
              
          default:
                  return;
          }

          // �I�����Ԃ��u�J�n���� + kangoTime(��)�v�ɐݒ肷��B
          getSpecificFacilityEndTime().setDate(
                  ACDateUtilities.addMinute(
                          getSpecificFacilityBeginTime()
                                  .getDate(), addTime));
      }

  }

  /**
   * �����R���{�i�J�n�j�I�����̃C�x���g
   */
    protected void specificFacilityBeginTimeActionPerformed(ActionEvent e) throws Exception {
        checkEndTime();
    }

    /**
     * �K����@���ԋ敪
     */
    protected void visitCareComboActionPerformed(ActionEvent e) throws Exception {
        checkEndTime();
    }
    /**
     * �K��Ō�@���ԋ敪�R���{
     */
    protected void visitNursingComboActionPerformed(ActionEvent e) throws Exception {
        checkEndTime();
        
    }
    /**
     * �ʏ���쎞�ԋ敪�I��
     */
    protected void expertPlaceNursingComboActionPerformed(ActionEvent e) throws Exception {
        checkEndTime();
    }
    /**
     * �ʏ����n���ԋ敪�I��
     */
    protected void expertPlaceRehabiliComboActionPerformed(ActionEvent e) throws Exception {
        checkEndTime();
    }

    /**
     * �ʏ����{�݋敪�I��
     */
    protected void expertPlaceNursingRadioActionPerformed(ActionEvent e) throws Exception {
        //�×{�ʏ����I������Ă����ꍇ
        VRMap comboItemMap = new VRHashMap();
        switch(getExpertPlaceNursingRadio().getSelectedIndex()){
        case 1:
            //���K�͌^�ʏ����
        case 2:
            //�ʏ�K�͌^�ʏ����
            // �����ԋ敪
            // �R�[�h�}�X�^�f�[�^���CODE_ID�F40�@�ʏ����i���ԋ敪�j���擾����B
            // �擾�����l���AcomboItemMap�� KEY : 1330115 �� VALUE �Ƃ��Đݒ肷��B
            comboItemMap.setData("1330115", QkanCommon.getArrayFromMasterCode(240,
                    "1330115"));
            // ���W�J
            // ���g(this)��comboItemMap�ɐݒ肷��B
            getThis().setModelSource(comboItemMap);
            // �R���{�A�C�e����W�J����B
            getThis().bindModelSource();
            break;
        case 3:
            //�×{�ʏ��I����
            // �����ԋ敪
            // �R�[�h�}�X�^�f�[�^���CODE_ID�F40�@�ʏ����i���ԋ敪�j���擾����B
            // �擾�����l���AcomboItemMap�� KEY : 1330115 �� VALUE �Ƃ��Đݒ肷��B
            comboItemMap.setData("1330115", QkanCommon.getArrayFromMasterCode(238,
                    "1330115"));
            // ���W�J
            // ���g(this)��comboItemMap�ɐݒ肷��B
            getThis().setModelSource(comboItemMap);
            // �R���{�A�C�e����W�J����B
            getThis().bindModelSource();
            break;
        }
        
    }
    
    /**
     * �K��Ō�{�݋敪�I��
     */
    protected void visitNursingFacilitiesDivisionRadioActionPerformed(ActionEvent e) throws Exception {
        //�K��Ō�X�e�[�V�������I������Ă��ĂȂ�����PT�EOT�EST�������ꍇ
        if(getVisitNursingFacilitiesDivisionRadioItem1().isSelected()){
            if(getVisitNursingStaffDivisionRadioItem2().isSelected()){
                VRMap comboItemMap = new VRHashMap();
                comboItemMap.setData("1330112", QkanCommon
                        .getArrayFromMasterCode(237, "1330112"));
                // ���W�J
                // ���g(this)��comboItemMap�ɐݒ肷��B
                getThis().setModelSource(comboItemMap);
                // �R���{�A�C�e����W�J����B
                getThis().bindModelSource();
            }
            //�K��Ō삪�I������Ă����ꍇ
            if(getOutsideServiceRadioItem3().isSelected()){
                setState_VALID_STAFF_DIVISION_();
            }
        }else {
            
            VRMap comboItemMap = new VRHashMap();
            comboItemMap.setData("1330112", QkanCommon
                    .getArrayFromMasterCode(207, "1330112"));
            // ���W�J
            // ���g(this)��comboItemMap�ɐݒ肷��B
            getThis().setModelSource(comboItemMap);
            // �R���{�A�C�e����W�J����B
            getThis().bindModelSource();
            //�K��Ō�@�a�@���I������Ă����ꍇ
            if(getVisitNursingFacilitiesDivisionRadioItem2().isSelected()){
                setState_INVALID_STAFF_DIVISION_();
            }
        }
        
    }


    /**
     * �K��Ō�E���敪�I��
     */
    protected void visitNursingStaffDivisionRadioActionPerformed(ActionEvent e) throws Exception {
        //PT�EOT�EST�������ꍇ
        if(getVisitNursingStaffDivisionRadioItem2().isSelected()&&getVisitNursingFacilitiesDivisionRadioItem1().isSelected()){
            //�K��Ō�X�e�[�V�������I������Ă����ꍇ
                VRMap comboItemMap = new VRHashMap();
                comboItemMap.setData("1330112", QkanCommon
                        .getArrayFromMasterCode(237, "1330112"));
                // ���W�J
                // ���g(this)��comboItemMap�ɐݒ肷��B
                getThis().setModelSource(comboItemMap);
                // �R���{�A�C�e����W�J����B
                getThis().bindModelSource();
        }else{

            VRMap comboItemMap = new VRHashMap();
            comboItemMap.setData("1330112", QkanCommon
                    .getArrayFromMasterCode(207, "1330112"));
            // ���W�J
            // ���g(this)��comboItemMap�ɐݒ肷��B
            getThis().setModelSource(comboItemMap);
            // �R���{�A�C�e����W�J����B
            getThis().bindModelSource();
        }
        
    }
    
    /**
     * �F�m�ǑΉ��ʏ����{�݋敪�I����
     */
    protected void providerDivisionRadioActionPerformed(ActionEvent e) throws Exception {
        //�U�^���I�����ꂽ�ꍇ
        if(getProviderDivisionRadio().getSelectedIndex()==2){
            //�{�݋敪�Q�𖳌��ɂ���B
            setState_INVALID_NINTI_DIVISION();
        }else{
            //�{�݋敪��I���\�ɂ���B
            //�F�m�ǑΉ��ʏ���삪�I������Ă����ꍇ�̂�
            if(getOutsideServiceRadioItem8().isSelected()){
                setState_VALID_NINTI_DIVISION();
            }
        }
        
        
    }

    /**
     * �F�m�ǑΉ��^�ʏ���쎞�ԋ敪�I����
     */
    protected void timeDivisionRadioSelectionChanged(ListSelectionEvent e) throws Exception {
        checkEndTime();
        
    }


}
