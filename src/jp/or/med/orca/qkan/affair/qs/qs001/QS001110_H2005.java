
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
 * �쐬��: 2008/04/14  ���{�R���s���[�^�[������� ����@��F �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �\��Ǘ� (S)
 * �v���Z�X �T�[�r�X�\�� (001)
 * �v���O���� �T�[�r�X�p�^�[���Z�������×{���(���V�l�ی��{��) (QS001110_H2005)
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
 * �T�[�r�X�p�^�[���Z�������×{���(���V�l�ی��{��)(QS001110_H2005) 
 */
public class QS001110_H2005 extends QS001110_H2005Event {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001110_H2005(){
  }

  //�R���|�[�l���g�C�x���g

  /**
   * �u�{�݋敪�I�����C�x���g�v�C�x���g�ł��B
   * 
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected void shortStayRecuperationHealthFacilityInstitutionDivisionRadioActionPerformed(
          ActionEvent e) throws Exception {
      // ���u�{�݋敪�v�I�����́u�a���敪�v�̏�Ԑؑ�
      // �u�{�݋敪�v�̒l���`�F�b�N����B
      //�F��
      setState_VALID_NINCHI_CARE();
      switch (getShortStayRecuperationHealthFacilityInstitutionDivisionRadio()
              .getSelectedIndex()) {
      case 1:
          // �u���V�l�ی��{�ݣ�̏ꍇ
          // �u�a���敪(�ʏ�)�v��L���ɂ��A�u�a���敪(���j�b�g�^)�v�𖳌��ɂ���B
          setState_CONVENTIONAL_FORM();
          //���A��V���[�g��p���W�I�O���[�v��Visible���� //20060411
          setState_SHORT_STAY_UNSELECT();
          break;
      case 2:
          // �u���j�b�g�^���V�l�ی��{�ݣ�̏ꍇ
          // �u�a���敪(�ʏ�)�v�𖳌��ɂ��A�u�a���敪(���j�b�g�^)�v��L���ɂ���B
          setState_UNIT_FORM();
          //���j�b�g�P�A�̐����Ȃ��ꍇ�͍Đݒ�
          if(!getUnitCareFlag()){
              setState_INVALID_UNIT_CARE();
          }
          setState_INVALID_NINCHI_CARE();
          //���A��V���[�g��p���W�I�O���[�v��Visible���� //20060411
          setState_SHORT_STAY_UNSELECT();
          break;
      case 3:
          // ����A��V���[�g�X�e�C��̏ꍇ
          setState_SELECT_SHORT_STAY_STATE();
          //�F�m�ǑΉ��P�A���Z
          setState_INVALID_NINCHI_CARE();
          //���A��V���[�g��p���W�I�O���[�v��Visible���� //20060411
          setState_SHORT_STAY_SELECT();
      }
  }

  /**
   * �u�H���񋟑I���v�C�x���g�ł��B
   * 
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected void shortStayRecuperationHealthFacilityDinnerOfferActionPerformed(
          ActionEvent e) throws Exception {
      // ���u�H���񋟁v�I�����Ɂu�H��v�̏�Ԑؑ�
      if (getShortStayRecuperationHealthFacilityDinnerOffer()
              .getSelectedIndex() < 1) {
          // �u�H���񋟁v���u�Ȃ��v�̏ꍇ
          // �H��𖳌��ɂ���B
          setState_NOT_USE_MEAT();
      } else {
          // �u�H���񋟁v���u�Ȃ��v�ȊO�̏ꍇ
          // �H���L���ɂ���B
          setState_USE_MEAT();
          // �H����p(shortStayRecuperationHealthFacilityDinnerCost)��ݒ肷��B
          getShortStayRecuperationHealthFacilityDinnerCost()
                  .setText(
                          getMeatCost(getShortStayRecuperationHealthFacilityDinnerOffer()
                                  .getSelectedIndex()));
      }

  }

  // �R���|�[�l���g�C�x���g

  public static void main(String[] args) {
      // �f�t�H���g�f�o�b�O�N��
      ACFrame.getInstance().setFrameEventProcesser(
              new QkanFrameEventProcesser());
      QkanCommon.debugInitialize();
      VRMap param = new VRHashMap();
      // param�ɓn��p�����^���l�߂Ď��s���邱�ƂŁA�ȈՃf�o�b�O���\�ł��B
      ACFrame.debugStart(new ACAffairInfo(QS001110.class.getName(), param));
  }

  // �����֐�

  /**
   * �u�������v�Ɋւ��鏈�����s�Ȃ��܂��B
   * 
   * @throws Exception ������O
   */
  public void initialize() throws Exception {
      // ����ʓW�J���̏����ݒ�
      getShortStayRecuperationHealthFacilitySpecialMedicalExpense().clearDataModel();
      //QS001200(���ʗ×{��)���T�[�r�X���(SYSTEM_SERVICE_KIND_DETAIL)�ɉ�����bindPath�z����擾���A���ʗ×{��{�^���ɐݒ肷��B
      getShortStayRecuperationHealthFacilitySpecialMedicalExpense()
              .setBindPathes(QS001200.getTargetBindPathes(SYSTEM_SERVICE_KIND_DETAIL));
      // ���R���{�A�C�e���̐ݒ�
      // ������
      // �R���{�A�C�e���ݒ�p�̃��R�[�h comboItemMap �𐶐�����B
      VRMap comboItemMap = new VRHashMap();
      // ���ݒ�
      // ���H����
      // �R�[�h�}�X�^�f�[�^���CODE_ID�F191�i�H���񋟁j���擾����B
      // �擾�����l���AcomboItemMap�� KEY : 1220112 �� VALUE �Ƃ��Đݒ肷��B
      comboItemMap.setData("1220112", QkanCommon.getArrayFromMasterCode(191,
              "1220112"));
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
      // �H����
      VRBindPathParser.set("1220112",defaultMap,new Integer(1));
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
          int index;
          // �{�݋敪
          obj = VRBindPathParser.get("1220101", provider);
          if (obj != null) {
              VRBindPathParser.set("1220101", defaultMap, obj);
          }
          
          // �{�݋敪�i�̐��j
          index = ACCastUtilities.toInt(VRBindPathParser.get("1220120", provider),0);
          // ���̂܂ܔ��f����
          VRBindPathParser.set("1220120", defaultMap, new Integer(index));
          
          // ��ԋΖ������
          obj = VRBindPathParser.get("1220102", provider);
          if (obj != null) {
              VRBindPathParser.set("1220104", defaultMap, obj);
          }
          // �l�����Z
          obj = VRBindPathParser.get("1220108", provider);
          if (obj != null) {
              //���Ə��o�^�̌��Z���ڂɍ��킹�����l�𒲐�
              switch(ACCastUtilities.toInt(obj)){
              case 1: //�Ȃ��������ꍇ
                  VRBindPathParser.set("1220111", defaultMap, new Integer(1));
                  break;
              case 2: //��t�������ꍇ
              case 3: //�Ō�E���������ꍇ
              case 4: //���E���������ꍇ
              case 5: //���w�Ö@�m�������ꍇ
              case 6: //��ƗÖ@�m�������ꍇ
                  VRBindPathParser.set("1220111", defaultMap, new Integer(3));
                  break;
              }
          }
          
          // ���}
          obj = VRBindPathParser.get("1220105", provider);
          if (obj != null) {
              switch (ACCastUtilities.toInt(obj)) {
              case 2:
                  // �u����v�̏ꍇ
                  // ���}�敪(shortStayRecuperationHealthFacilityMeetingAndSendingOff)��3�Ԗڂ̃{�^����I���ɂ���B
                  VRBindPathParser.set("6", defaultMap, new Integer(3));
                  break;
              case 1:
                  // �u�Ȃ��v�̏ꍇ
                  // ���}�敪(shortStayRecuperationHealthFacilityMeetingAndSendingOff)��1�Ԗڂ̃{�^����I���ɂ���B
                  VRBindPathParser.set("6", defaultMap, new Integer(1));
                  break;
              }
          }
          // ���ȉ��̓��e�ڍ׍��ڂ́A�I�����Ə��́u�Ȃ��v�u����v�ɂ���āA����/�L����؂�ւ���B
          // ���n�r���@�\����
          obj = VRBindPathParser.get("1220103", provider);
          if (obj != null) {
              switch (ACCastUtilities.toInt(obj)) {
              case 2:
                  // �u����v�̏ꍇ
                  // �L���ɂ���B
                  setState_VALID_REHABILITATION();
                  VRBindPathParser.set("1220105", defaultMap, obj);
                  break;
              case 1:
                  // �u�Ȃ��v�̏ꍇ
                  // �����ɂ���B
                  setState_INVALID_REHABILITATION();
                  VRBindPathParser.set("1220105", defaultMap, obj);
                  break;
              }
          }
          // �h�{�Ǘ��̐�
          obj = VRBindPathParser.get("1220106", provider);
          if (obj != null) {
              if(new Integer(2).equals(ACCastUtilities.toInteger(obj))){
                  VRBindPathParser.set("1220109",defaultMap,new Integer(3));
              }else if(new Integer(3).equals(ACCastUtilities.toInteger(obj))){
                  VRBindPathParser.set("1220109",defaultMap,new Integer(2));
              }
          }
          
          // �×{���ێ����ʉ��Z
          index = ACCastUtilities.toInt(VRBindPathParser.get("1220121", provider),0);
          // ���̂܂ܔ��f����
          VRBindPathParser.set("1220121", defaultMap, new Integer(index));
          
          // �×{�H
          obj = VRBindPathParser.get("1220107", provider);
          if (obj != null) {
              switch (ACCastUtilities.toInt(obj)) {
              case 2:
                  // �u����v�̏ꍇ
                  // �L���ɂ���B
                  setState_VALID_MEDICAL_EXPENSES();
                  VRBindPathParser.set("1220110", defaultMap, obj);
                  break;
              case 1:
                  // �u�Ȃ��v�̏ꍇ
                  // �����ɂ���B
                  setState_INVALID_MEDICAL_EXPENSES();
                  VRBindPathParser.set("1220110", defaultMap, obj);
                  break;
              }
          }
          // ���j�b�g�P�A�̐���
          obj = VRBindPathParser.get("1220117", provider);
          if (obj != null) {
              switch (ACCastUtilities.toInt(obj)) {
              case 1:
                  // �Ȃ��̏ꍇ
                  VRBindPathParser.set("1220117",defaultMap,obj);
                  setState_INVALID_UNIT_CARE();
                  setUnitCareFlag(false);
                  break;
              case 2:
                  // ����̏ꍇ
                  VRBindPathParser.set("1220117",defaultMap,obj);
                  setState_VALID_UNIT_CARE();
                  setUnitCareFlag(true);
                  break;
              }

          }else{
              //���Ə��o�^�œo�^����Ă��Ȃ������ꍇ�͈ꗥ�����ɂ���B
              setUnitCareFlag(false);
          }
          // �ً}�Z�������l�b�g���[�N���Z
          obj = VRBindPathParser.get("1220118", provider);
          if (obj != null) {
              switch (ACCastUtilities.toInt(obj)) {
              case 1:
                  // �Ȃ��������ꍇ
                  VRBindPathParser.set("1220118", defaultMap, obj);
                  setState_INVALID_SHORT_NETWORK();
                  break;
              case 2:
                  // ���肾�����ꍇ
//                  VRBindPathParser.set("1220118", defaultMap, obj);
                  setState_VALID_SHORT_NETWORK();
                  break;
              }
          }

          // ���W�J
          // ���g(this)��defaultMap�ɐݒ肷��B
          getThis().setSource(defaultMap);
          // �����I�����ڂ�W�J����B
          getThis().bindSource();

          if(getShortStayRecuperationHealthFacilityDinnerOffer().getSelectedIndex()==0){
              //�H��Ȃ��̏ꍇ�ɂ̂ݒ�����ɂ���B
              getShortStayRecuperationHealthFacilityDinnerOffer().setSelectedIndex(1);
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
      // �{�ݓ��̋敪�i�̐��j�@
      // ���A��V���[�g�X�e�C�̏ꍇ�̓G���[�ɂ��Ȃ�
      if (getShortStayRecuperationHealthFacilityInstitutionDivisionRadio()
                .getSelectedIndex() != 3
                && getShortStayRecuperationHealthFacilityDivision()
                        .getSelectedIndex() < 1) {
          QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
          return null;
      }
      // �×{�̐��ێ����ʉ��Z
      if(getShortStayRecuperationHealthFacilityRecuperationRadio().getSelectedIndex() < 1){
          QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
          return null;
      }
      
      if (getShortStayRecuperationHealthFacilityDinnerOffer()
              .getSelectedIndex() > 0) {
          // �H���񋟁ishortStayRecuperationHealthFacilityDinnerOffer)���u�Ȃ��v�ȊO��I�����Ă���ꍇ
          if (ACTextUtilities
                  .isNullText(getShortStayRecuperationHealthFacilityDinnerCost()
                          .getText())) {
              // �H����p(shortStayRecuperationHealthFacilityDinnerCost)���󗓂̏ꍇ
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
                      .get("1220109", getSelectedProvider()), 0));
          case 2:
              // �H���������u���̂݁v�̏ꍇ
              // �u���v�̐H���Ԃ��B
              return String.valueOf(ACCastUtilities.toInt(VRBindPathParser
                      .get("1220110", getSelectedProvider()), 0));
          case 3:
              // �H���������u���̂݁v�̏ꍇ
              // �u���v�̐H���Ԃ��B
              return String.valueOf(ACCastUtilities.toInt(VRBindPathParser
                      .get("1220111", getSelectedProvider()), 0));
          case 4:
              // �H���������u��̂݁v�̏ꍇ
              // �u��v�̐H���Ԃ��B
              return String.valueOf(ACCastUtilities.toInt(VRBindPathParser
                      .get("1220112", getSelectedProvider()), 0));
          case 5:
              // �H���������u�����v�̏ꍇ
              // �u���v�̐H��A�u���v�̐H��̐H��̍��Z��Ԃ��B
              return String.valueOf(ACCastUtilities.toInt(VRBindPathParser
                      .get("1220110", getSelectedProvider()),0)
                      + ACCastUtilities.toInt(VRBindPathParser.get("1220111",
                              getSelectedProvider()), 0));
          case 6:
              // �H���������u����v�̏ꍇ
              // �u���v�̐H��A�u��v�̐H��̐H��̍��Z��Ԃ��B
              return String.valueOf(ACCastUtilities.toInt(VRBindPathParser
                      .get("1220111", getSelectedProvider()),0)
                      + ACCastUtilities.toInt(VRBindPathParser.get("1220112",
                              getSelectedProvider()), 0));
          case 7:
              // �H���������u�钩�v�̏ꍇ
              // �u��v�̐H��A�u���v�̐H��̐H��̍��Z��Ԃ��B
              return String.valueOf(ACCastUtilities.toInt(VRBindPathParser
                      .get("1220112", getSelectedProvider()),0)
                      + ACCastUtilities.toInt(VRBindPathParser.get("1220110",
                              getSelectedProvider()), 0));
          }
      }
      // �󕶎���Ԃ��B
      return "";
  }

    protected void shortStayRecuperationHealthFacilitySpecialMedicalExpenseActionPerformed(
            ActionEvent e) throws Exception {
        // �����ʗ×{��̕ҏW
        // ���ʗ×{��ҏW���(QS001200)�𐶐�����B
        // ���ʗ×{��{�^���̃f�[�^�������ɐ����������ʗ×{��ҏW���(QS001200)��shoModal�����s����B
        if (new QS001200().showModal(SYSTEM_SERVICE_KIND_DETAIL,
                getShortStayRecuperationHealthFacilitySpecialMedicalExpense()
                        .getDataModel())) {
            // ���ʗ×{���ύX�����ꍇ
            if (getShortStayRecuperationHealthFacilitySpecialMedicalExpense()
                    .getDataModel().isEmpty()) {
                // ���ʗ×{��{�^���̃f�[�^����̏ꍇ
                // ���ʗ×{��x���Ɂu�ݒ�Ȃ��v�ƕ\������B
                getShortStayRecuperationHealthFacilitySpecialMedicalExpenseLabel()
                        .setText("�ݒ�Ȃ�");
            } else {
                // ���ʗ×{��{�^���̃f�[�^����ł͂Ȃ��ꍇ
                // ���ʗ×{��x���Ɂu�ݒ肠��v�ƕ\������B
                getShortStayRecuperationHealthFacilitySpecialMedicalExpenseLabel()
                        .setText("�ݒ肠��");
            }
        }

    }
    
    public void binded() throws Exception{
        if (getShortStayRecuperationHealthFacilitySpecialMedicalExpense()
                .getDataModel().isEmpty()) {
            // ���ʗ×{��{�^���̃f�[�^����̏ꍇ
            // ���ʗ×{��x���Ɂu�ݒ�Ȃ��v�ƕ\������B
            getShortStayRecuperationHealthFacilitySpecialMedicalExpenseLabel()
                    .setText("�ݒ�Ȃ�");
        } else {
            // ���ʗ×{��{�^���̃f�[�^����ł͂Ȃ��ꍇ
            // ���ʗ×{��x���Ɂu�ݒ肠��v�ƕ\������B
            getShortStayRecuperationHealthFacilitySpecialMedicalExpenseLabel()
                    .setText("�ݒ肠��");
        }
    }

}
