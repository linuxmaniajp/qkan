
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
 * �v���O���� �T�[�r�X�p�^�[�����×{�^��Î{�݁i�a�@�j (QS001120)
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
 * �T�[�r�X�p�^�[�����×{�^��Î{�݁i�a�@�j(QS001120) 
 */
public class QS001120 extends QS001120Event {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001120(){
  }

  //�R���|�[�l���g�C�x���g

  /**
   * �u�{�݋敪�I�����C�x���g�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected void medicalFacilityHospitalInstitutionDivisionRadioActionPerformed(
            ActionEvent e) throws Exception {
        // ���u�{�݋敪�v�I�����́u�a���敪�v�̏�Ԑؑ�
        // �u�{�݋敪�v�̒l���`�F�b�N����B
        switch (getMedicalFacilityHospitalInstitutionDivisionRadio()
                .getSelectedIndex()) {
        case 1:
            // �u�a�@�v�̏ꍇ
            // �u�a���敪(�ʏ�)�v��L���ɂ��A�u�a���敪(���j�b�g�^)�v�𖳌��ɂ���B
            setState_CONVENTIONAL_FORM();
            break;
        case 2:
            // �u���j�b�g�^�a�@�v�̏ꍇ
            // �u�a���敪(�ʏ�)�v�𖳌��ɂ��A�u�a���敪(���j�b�g�^)�v��L���ɂ���B
            setState_UNIT_FORM();
            // ���j�b�g�P�A�̐����Ȃ������ꍇ
            if (!getUnitCareFlag()) {
                setState_INVALID_UNIT_CARE();
            }
            break;
        case 3:
        	// �u�o�ߌ^�v�̏ꍇ
        	setState_PASSAGE_FORM();
        	break;
        }
        //�l���z�u�敪�𐧌䂷��
        changeStaffDivisionState();	
        
    }


  public void binded() throws Exception{
      if (getMedicalFacilityHospitalConsultationFee()
              .getDataModel().isEmpty()) {
          // ����f�Ô�{�^���̃f�[�^����̏ꍇ
          // ����f�Ô�x���Ɂu�ݒ�Ȃ��v�ƕ\������B
          getMedicalFacilityHospitalConsultationFeeLabel()
                  .setText("�ݒ�Ȃ�");
      } else {
          // ����f�Ô�{�^���̃f�[�^����ł͂Ȃ��ꍇ
          // ����f�Ô�x���Ɂu�ݒ肠��v�ƕ\������B
          getMedicalFacilityHospitalConsultationFeeLabel()
                  .setText("�ݒ肠��");
      }

  }
  /**
   * �u����f�Ô�̐ݒ�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected void medicalFacilityHospitalConsultationFeeActionPerformed(ActionEvent e) throws Exception{
      // ������f�Ô�̕ҏW
      // ����f�Ô�ҏW���(QS001028)�𐶐�����B
      // ����f�Ô�{�^���̃f�[�^�������ɐ�����������f�Ô�ҏW���(QS001028)��shoModal�����s����B
      if (new QS001199().showModal(SYSTEM_SERVICE_KIND_DETAIL,
              getMedicalFacilityHospitalConsultationFee()
                      .getDataModel())) {
          // ����f�Ô��ύX�����ꍇ
          if (getMedicalFacilityHospitalConsultationFee()
                  .getDataModel().isEmpty()) {
              // ����f�Ô�{�^���̃f�[�^����̏ꍇ
              // ����f�Ô�x���Ɂu�ݒ�Ȃ��v�ƕ\������B
              getMedicalFacilityHospitalConsultationFeeLabel()
                      .setText("�ݒ�Ȃ�");
          } else {
              // ����f�Ô�{�^���̃f�[�^����ł͂Ȃ��ꍇ
              // ����f�Ô�x���Ɂu�ݒ肠��v�ƕ\������B
              getMedicalFacilityHospitalConsultationFeeLabel()
                      .setText("�ݒ肠��");
          }
      }

  }
  /**
   * �u�H���񋟑I���v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected void medicalFacilityDinnerOfferActionPerformed(ActionEvent e) throws Exception {
      // ���u�H���񋟁v�I�����Ɂu�H��v�̏�Ԑؑ�
      if (getMedicalFacilityDinnerOffer().getSelectedIndex() < 1) {
          // �u�H���񋟁v���u�Ȃ��v�̏ꍇ
          // �H��𖳌��ɂ���B
          setState_NOT_USE_MEAT();
      } else {
          // �u�H���񋟁v���u�Ȃ��v�ȊO�̏ꍇ
          // �H���L���ɂ���B
          setState_USE_MEAT();
              // �H����p(medicalFacilityDinnerCost)��ݒ肷��B
              getMedicalFacilityDinnerCost().setText(
                      getMeatCost(getMedicalFacilityDinnerOffer()
                              .getSelectedIndex()));
      }
      
  }
  public static void main(String[] args) {
    //�f�t�H���g�f�o�b�O�N��
    ACFrame.getInstance().setFrameEventProcesser(new QkanFrameEventProcesser());
    QkanCommon.debugInitialize();
    VRMap param = new VRHashMap();
    //param�ɓn��p�����^���l�߂Ď��s���邱�ƂŁA�ȈՃf�o�b�O���\�ł��B
    ACFrame.debugStart(new ACAffairInfo(QS001120.class.getName(), param));
  }

  //�����֐�

  /**
     * �u�������v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public void initialize() throws Exception {
        // ����ʓW�J���̏����ݒ�
        getMedicalFacilityHospitalConsultationFee().clearDataModel();
        //QS001028(����f�Ô�)���T�[�r�X���(SYSTEM_SERVICE_KIND_DETAIL)�ɉ�����bindPath�z����擾���A����f�Ô�{�^���ɐݒ肷��B
        getMedicalFacilityHospitalConsultationFee()
                .setBindPathes(QS001199.getTargetBindPathes(SYSTEM_SERVICE_KIND_DETAIL));
        // ���R���{�A�C�e���̐ݒ�
        // ������
        // �R���{�A�C�e���ݒ�p�̃��R�[�h comboItemMap �𐶐�����B
        VRMap comboItemMap = new VRHashMap();
        // ���ݒ�
        // �H����
        comboItemMap.setData("1530159", QkanCommon.getArrayFromMasterCode(191,
                "1530159"));
        // �l�����Z
        comboItemMap.setData("1530158", QkanCommon.getArrayFromMasterCode(107,
                "1530158"));
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
        VRBindPathParser.set("1530159", defaultMap, new Integer(1));
        // �l�����Z
        VRBindPathParser.set("1530158", defaultMap, new Integer(1));
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
        setSelectedProvider(provider);
        // �I�����Ə����null�łȂ��ꍇ
        if (provider != null) {
            // ���ȉ��̓��e�ڍ׍��ڂ́A�I�����Ə��̒l��ݒ肷��B
            // ������
            // ���Ə��A���p�̃��R�[�h defaultMap �𐶐�����B
            VRMap defaultMap = new VRHashMap();
            // ���ݒ�
            Object obj;
            // �l���z�u�敪
            obj = VRBindPathParser.get("1530102", provider);
            if (obj != null) {
                defaultMap.setData("1530102", obj);
            }
            // �{�݋敪
            obj = VRBindPathParser.get("1530101", provider);
            if (obj != null) {
                defaultMap.setData("1530101", obj);
            }
            // ��ԋΖ������
            obj = VRBindPathParser.get("1530103", provider);
            if (obj != null) {
                defaultMap.setData("1530105", obj);
            }
            // �×{���
            obj = VRBindPathParser.get("1530104", provider);
            if (obj != null) {
                defaultMap.setData("1530106", obj);
            }
            // ��t�̔z�u�
            obj = VRBindPathParser.get("1530105", provider);
            if (obj != null) {
                defaultMap.setData("1530107", obj);
            }
            // �h�{�Ǘ��̐����Z
            obj = VRBindPathParser.get("1530106", provider);
            if (obj != null) {
                if(new Integer(2).equals(ACCastUtilities.toInteger(obj))){
                    VRBindPathParser.set("1530111",defaultMap,new Integer(3));
                }else if(new Integer(3).equals(ACCastUtilities.toInteger(obj))){
                    VRBindPathParser.set("1530111",defaultMap,new Integer(2));
                }
//                switch (ACCastUtilities.toInt(obj)) {
//                case 4:
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
            // �h�{�}�l�W�����g���Z
            obj = VRBindPathParser.get("1530107", provider);
            if (obj != null) {
                switch (ACCastUtilities.toInt(obj)) {
                case 1:
                    // �̐��Ȃ��������ꍇ
                    setState_INVALID_MANAGE();
                    break;
                case 2:
                    // �̐����肾�����ꍇ
                    setState_VALID_MANAGE();
                    defaultMap.setData("1530112", obj);
                    break;
                }
            }
            // �o���ڍs���Z
            obj = VRBindPathParser.get("1530108", provider);
            if (obj != null) {
                switch (ACCastUtilities.toInt(obj)) {
                case 1:
                    // �̐��Ȃ��������ꍇ
                    setState_INVALID_NUTRITION();
                    break;
                case 2:
                    // �̐����肾�����ꍇ
                    setState_VALID_NUTRITION();
                    defaultMap.setData("1530113", obj);
                    break;
                }
            }
            // �×{�H���Z
            obj = VRBindPathParser.get("1530109", provider);
            if (obj != null) {
                switch (ACCastUtilities.toInt(obj)) {
                case 1:
                    // �̐��Ȃ��������ꍇ
                    setState_INVALID_MEDICAL_EXPENSES();
                    break;
                case 2:
                    // �̐����肾�����ꍇ
                    setState_VALID_MEDICAL_EXPENSES();
                    defaultMap.setData("1530114", obj);
                    break;
                }
            }
            // ���j�b�g�P�A�̐���
            obj = VRBindPathParser.get("1530119", provider);
            if (obj != null) {
                switch (ACCastUtilities.toInt(obj)) {
                case 1:
                    // �̐��Ȃ��������ꍇ
                    setState_INVALID_UNIT_CARE();
                    setUnitCareFlag(false);
                    break;
                case 2:
                    // �̐����肾�����ꍇ
                    setState_VALID_UNIT_CARE();
                    setUnitCareFlag(true);
                    defaultMap.setData("1530116", obj);
                    break;
                }
            }else{
                //���Ə��o�^�œo�^����Ă��Ȃ������ꍇ�͈ꗥ�����ɂ���B
                setUnitCareFlag(false);
            }
            
            // �g�̍S�������{���Z
            obj = VRBindPathParser.get("1530120", provider);
            if (obj != null) {
                //�g�̍S�������{��g�݂Ȃ��������ꍇ
                if(ACCastUtilities.toInt(obj) == 1){
                    defaultMap.setData("1530117", new Integer(2));
                }else if(ACCastUtilities.toInt(obj) == 2){
                    //�g�̍S�������{��g�݂��肾�����ꍇ
                    defaultMap.setData("1530117", new Integer(1));
                }
            }
            //�l�����Z
            obj = VRBindPathParser.get("1530110",provider);
            if (obj != null) {
                //���Ə��o�^�̌��Z���ڂɍ��킹�����l�𒲐�
                switch(ACCastUtilities.toInt(obj)){
                case 1: //�Ȃ��������ꍇ
                case 2: //��t�������ꍇ
                    VRBindPathParser.set("1530158", defaultMap, new Integer(1));
                    break;
                case 3: //�Ō�E���������ꍇ
                case 4: //���E���������ꍇ
                    VRBindPathParser.set("1530158", defaultMap, new Integer(3));
                    break;
                case 5: //���x�������������ꍇ
                    VRBindPathParser.set("1530158", defaultMap, new Integer(4));
                    break;
                }
            }
            // ���W�J
            // ���g(this)��defaultMap�ɐݒ肷��B
            getThis().setSource(defaultMap);
            // �����I�����ڂ�W�J����B
            getThis().bindSource();
            // ���ȉ��̓��e�ڍ׍��ڂ́A�I�����Ə��́u�Ȃ��v�u����v�ɂ���āA����/�L����؂�ւ���B
            
            if(getMedicalFacilityDinnerOffer().getSelectedIndex()==0){
                //�H��Ȃ��̏ꍇ�ɂ̂ݒ�����ɂ���B
                getMedicalFacilityDinnerOffer().setSelectedIndex(1);
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
        //�l���z�u�敪���L���łȂ����I�����ڂ������ł���ꍇ
        if (getMedicalFacilityHospitalHospitalDivision().isEnabled()
                && !getMedicalFacilityHospitalHospitalDivision()
                        .getSelectedButton().isEnabled()) {
            //���e�̕s�����b�Z�[�W��\������B��ID=QS001_ERROR_OF_NO_CONTENT
            QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
            //�����𒆒f����B
            return null;
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
                      .get("1530111", getSelectedProvider()),0));
          case 2:
              // �H���������u���̂݁v�̏ꍇ
              // �u���v�̐H���Ԃ��B
              return String.valueOf(ACCastUtilities.toInt(VRBindPathParser
                      .get("1530112", getSelectedProvider()),0));
          case 3:
              // �H���������u���̂݁v�̏ꍇ
              // �u���v�̐H���Ԃ��B
              return String.valueOf(ACCastUtilities.toInt(VRBindPathParser
                      .get("1530113", getSelectedProvider()),0));
          case 4:
              // �H���������u��̂݁v�̏ꍇ
              // �u��v�̐H���Ԃ��B
              return String.valueOf(ACCastUtilities.toInt(VRBindPathParser
                      .get("1530114", getSelectedProvider()),0));
          case 5:
              // �H���������u�����v�̏ꍇ
              // �u���v�̐H��A�u���v�̐H��̐H��̍��Z��Ԃ��B
              return String.valueOf(ACCastUtilities.toInt(VRBindPathParser
                      .get("1530112", getSelectedProvider()),0)
                      + ACCastUtilities.toInt(VRBindPathParser.get("1530113",
                              getSelectedProvider()),0));
          case 6:
              // �H���������u����v�̏ꍇ
              // �u���v�̐H��A�u��v�̐H��̐H��̍��Z��Ԃ��B
              return String.valueOf(ACCastUtilities.toInt(VRBindPathParser
                      .get("1530113", getSelectedProvider()),0)
                      + ACCastUtilities.toInt(VRBindPathParser.get("1530114",
                              getSelectedProvider()),0));
          case 7:
              // �H���������u�钩�v�̏ꍇ
              // �u��v�̐H��A�u���v�̐H��̐H��̍��Z��Ԃ��B
              return String.valueOf(ACCastUtilities.toInt(VRBindPathParser
                      .get("1530114", getSelectedProvider()),0)
                      + ACCastUtilities.toInt(VRBindPathParser.get("1530112",
                              getSelectedProvider()),0));
          }
      }
      // �󕶎���Ԃ��B
      return "";
  }
      
  /**
   * �l�����Z�R���{�I���C�x���g
   */
    protected void medicalFacilityHospitalSubstractionActionPerformed(
            ActionEvent e) throws Exception {
        //��Ō�E�Ō�E���������̏ꍇ�����Ŕ䗦��20%�����̏ꍇ���ƒn�͏o���
        if (getMedicalFacilityHospitalSubstraction().getSelectedIndex() == 2
                || getMedicalFacilityHospitalSubstraction().getSelectedIndex() == 4
                || getMedicalFacilityHospitalSubstraction().getSelectedIndex() == 6) {
            //�����ɂ���
            setPersonSubstraction(false);
        }else{
            //�L���ɂ���
            setPersonSubstraction(true);
        }
        //�l���z�u�敪�𐧌䂷��
        changeStaffDivisionState();
    }
    
    /**
     * �l���z�u�敪��Enable���䏈��
     */
    protected void changeStaffDivisionState() throws Exception{
        //�{�݋敪���`�F�b�N����
        //�a�@���I������Ă����ꍇ
        if(getMedicalFacilityHospitalHospitalInstitutionDivisionRadioItem1().isSelected()){
            //�l�����Z�̒l���l������Ԃ�ύX����B
            if(getPersonSubstraction()){
                setState_VALID_SUBTRACTION();
            }else{
                setState_INVALID_SUBTRACTION();
            }
            
        }else if(getMedicalFacilityHospitalHospitalInstitutionDivisionRadioItem2().isSelected()) {
            //���j�b�g�^���I������Ă����ꍇ
            setState_UNIT_FORM();
            if(!getUnitCareFlag()){
                setState_INVALID_UNIT_CARE();
            }
        }
        
        
    }

    /**
     * �u�o���ڍs���Z�̕ύX�v�C�x���g�ł��B
     * @param e �C�x���g���
     * @throws Exception ������O
     */
   protected void medicalFacilityHospitalOralSwitchRadioSelectionChanged(ListSelectionEvent e) throws Exception {
       //�o���ڍs���Z
       if(getMedicalFacilityHospitalOralSwitchRadioItem1().isSelected()){
           setState_VALID_KEEP_NUTRITION();
       }else{
           setState_INVALID_KEEP_NUTRITION();
       }
    }

    /**
     * �u�o���ێ����Z�̕ύX�v�C�x���g�ł��B
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void oralMaintenanceRadioSelectionChanged(ListSelectionEvent e) throws Exception {
//      �o���ێ����Z
        if(getOralMaintenanceRadioItem1().isSelected()){
            setState_VALID_NUTRITION();
        }else{
            setState_INVALID_NUTRITION();
        }
    }

    /**
     * ���Ȏ�M�̗L��
     */
    protected void medicalFacilityHospitalMedicalExaminationRadioSelectionChanged(
			ListSelectionEvent e) throws Exception {
		// ���肾�����ꍇ
		int facilityDivision = getMedicalFacilityHospitalInstitutionDivisionRadio()
				.getSelectedIndex();

		if (getMedicalFacilityHospitalMedicalExaminationRadioItem2()
				.isSelected()) {
			// �O���𖳌��ɂ���
			setState_INVALID_GAIHAKU();
			// �O���̂Ȃ���I����Ԃɂ���
			getMedicalFacilityHospitalStayRadioItem1().setSelected(true);
			// ���s�I�މ@�T�[�r�X��𖳌��ɂ���B
			setState_INVALID_TRIAL_HIJO();
			// ���s�I�މ@�T�[�r�X��̂Ȃ���I����Ԃɂ���B
			getTrialHijoRadioItem1().setSelected(true);
		} else {
			// �O����L���ɂ���
			setState_VALID_GAIHAKU();
			if (facilityDivision == 3) {
				// �o�ߌ^�̏ꍇ�̂�
				// ���s�I�މ@�T�[�r�X���L���ɂ���B
				setState_VALID_TRIAL_HIJO();
			}
		}

	}

    /**
	 * �O�����Z�̗L��
	 */
    protected void medicalFacilityHospitalStayRadioSelectionChanged(ListSelectionEvent e) throws Exception {
        //���肾�����ꍇ
    	int facilityDivision = getMedicalFacilityHospitalInstitutionDivisionRadio().getSelectedIndex();
    	
        if(getMedicalFacilityHospitalStayRadioItem2().isSelected()){
            //���Ȏ�M�𖳌��ɂ���
            setState_INVALID_TAKAJYUSIN();
            //���Ȏ�M�̂Ȃ���I����Ԃɂ���
            getMedicalFacilityHospitalMedicalExaminationRadioItem1().setSelected(true);
            // ���s�I�މ@�T�[�r�X��𖳌��ɂ���B
            setState_INVALID_TRIAL_HIJO();
            // ���s�I�މ@�T�[�r�X��̂Ȃ���I����Ԃɂ���B
            getTrialHijoRadioItem1().setSelected(true);
        }else{
            //���Ȏ�M��L���ɂ���
            setState_VALID_TAKAJYUSIN();
            if(facilityDivision == 3){
            	// �o�ߌ^�̏ꍇ�̂�
	            //���s�I�މ@�T�[�r�X���L���ɂ���B
	            setState_VALID_TRIAL_HIJO();
            }
        }
        
    }

    /**
     * �u���s�I�މ@�T�[�r�X��̗L���v�C�x���g�ł��B
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void trialHijoRadioSelectionChanged(ListSelectionEvent e) throws Exception{

        //���肾�����ꍇ
        if(getTrialHijoRadioItem2().isSelected()){
            //���Ȏ�M�𖳌��ɂ���
            setState_INVALID_TAKAJYUSIN();
            //���Ȏ�M�̂Ȃ���I����Ԃɂ���
            getMedicalFacilityHospitalMedicalExaminationRadioItem1().setSelected(true);
            //�O���𖳌��ɂ���
            setState_INVALID_GAIHAKU();
            //�O���̂Ȃ���I����Ԃɂ���
            getMedicalFacilityHospitalStayRadioItem1().setSelected(true);
        }else{
            //���Ȏ�M��L���ɂ���
            setState_VALID_TAKAJYUSIN();
            //�O����L���ɂ���
            setState_VALID_GAIHAKU();
        }
        
    }

}
