
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
 * �v���O���� �T�[�r�X�p�^�[�����K�͑��@�\�^��� (QS001125)
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
 * �T�[�r�X�p�^�[�����K�͑��@�\�^���(QS001125) 
 */
public class QS001125 extends QS001125Event {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001125(){
  }

  //�R���|�[�l���g�C�x���g

  /**
   * �u���x�������ԍ��̕\���v�C�x���g�ł��B
   * 
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected void kaigoSupportSpecialMemberNameActionPerformed(ActionEvent e)
          throws Exception {
      if (getKaigoSupportSpecialMemberName().isSelected()) {
          // �R���{�őI������Ă���f�[�^���擾
          VRMap data = (VRMap) getKaigoSupportSpecialMemberName()
                  .getSelectedModelItem();

          // �擾�f�[�^�����x�������ԍ����擾���A�\��
          getKaigoSupportSpecialMemberNumber().setText(
                  ACCastUtilities.toString(VRBindPathParser.get(
                          "CARE_MANAGER_NO", data)));
      }
  }

  public static void main(String[] args) {
    //�f�t�H���g�f�o�b�O�N��
    ACFrame.getInstance().setFrameEventProcesser(new QkanFrameEventProcesser());
    QkanCommon.debugInitialize();
    VRMap param = new VRHashMap();
    //param�ɓn��p�����^���l�߂Ď��s���邱�ƂŁA�ȈՃf�o�b�O���\�ł��B
    ACFrame.debugStart(new ACAffairInfo(QS001125.class.getName(), param));
  }

  //�����֐�

  /**
   * �u�������v�Ɋւ��鏈�����s�Ȃ��܂��B
   * @throws Exception ������O
   */
  public void initialize() throws Exception{
    // ����ʓW�J���̏����ݒ�
    // ���R���{�A�C�e���̐ݒ�
    // �@������
    // �@�@�R���{�A�C�e���ݒ�p�̃��R�[�h comboItemMap �𐶐�����B
    VRMap comboItemMap = new VRHashMap();
    // �@���ݒ�
    // �@���W�J
    // �@�@���g(this)��comboItemMap�ɐݒ肷��B
    getThis().setModelSource(comboItemMap);
    // �@�@�R���{�A�C�e����W�J����B
    getThis().bindModelSource();
    // ���I�����ڂ̏����ݒ�
    QkanCommon.selectFirstRadioItem(getThis());
    // �@������
    // �@�@�����I��ݒ�p�̃��R�[�h defaultMap �𐶐�����B
    VRMap defaultMap = new VRHashMap();
    // �@���ݒ�
    // 2008/06/12 [Masahiko Higuchi] add - begin 2007�N�x�Ή��i�E�v���ݒ�@�\�j�@�@�@�@�@�@
    // �o�[�W�����A�b�v��ꔭ�ڂ̓o���h�p�X�����݂��Ȃ����ߒl������������B
    getTekiyouText().setText("");
    // 2008/06/12 [Masahiko Higuchi] add - end
    // �@���W�J
    // �@�@���g(this)��defaultMap�ɐݒ肷��B
    getThis().setSource(defaultMap);
    // �@�@�����I�����ڂ�W�J����B
    getThis().bindSource();

  }

  public void binded()throws Exception{
      super.binded();
      ComboBoxModel mdl = getKaigoSupportSpecialMemberName().getModel();
      VRBindSource src=null;
      if(mdl instanceof VRComboBoxModelAdapter){
          src = ((VRComboBoxModelAdapter)mdl).getAdaptee();
      }
      if (src instanceof VRList) {
          int idx = ACBindUtilities.getMatchIndexFromValue(
                  (VRList)src, "CARE_MANAGER_NO",
                  getKaigoSupportSpecialMemberNumber().getText());
          if(idx>=0){
              getKaigoSupportSpecialMemberName().setSelectedIndex(idx);
          }
      }
  }

  /**
   * �u���Ə��R���{�ύX���֐��v�Ɋւ��鏈�����s�Ȃ��܂��B
   * @throws Exception ������O
   */
  public void providerSelected(VRMap provider) throws Exception{
    // �����Ə��R���{�ύX���ɌĂԊ֐�
	  if(provider != null){
        // �I�����Ə����null�łȂ��ꍇ
        // ���ȉ��̓��e�ڍ׍��ڂ́A�I�����Ə��̒l��ݒ肷��B
        // ������
        // ���Ə��A���p�̃��R�[�h defaultMap �𐶐�����B
        VRMap defaultMap = new VRHashMap();
        // ���ݒ�
        // �l�����Z
        Object obj;
        obj = VRBindPathParser.get("1730101", provider);
        if(obj != null){
               //���Ə��o�^�̌��Z���ڂɍ��킹�����l�𒲐�
            switch(ACCastUtilities.toInt(obj)){
            case 1: //�Ȃ��������ꍇ
                VRBindPathParser.set("1730102", defaultMap, new Integer(1));
                break;
            case 2: //��t�������ꍇ
            case 3: //�Ō�E���������ꍇ
                VRBindPathParser.set("1730102", defaultMap, new Integer(3));
                break;
            }
        }

        // ���x�������R���{
        VRMap sqlParam = new VRHashMap();
        VRBindPathParser.set("PROVIDER_ID", sqlParam, VRBindPathParser.get(
                "PROVIDER_ID", provider));

        VRList staffs =getDBManager().executeQuery(
                getSQL_GET_CARE_MANAGER(sqlParam)); 
        Iterator it=staffs.iterator();
        while(it.hasNext()){
            Map staff=(Map)it.next();
            staff.put("STAFF_NAME", QkanCommon.toFullName(staff
                    .get("STAFF_FAMILY_NAME"), staff
                    .get("STAFF_FIRST_NAME")));
        }
        
        getKaigoSupportSpecialMemberName().setModel(
                staffs);
        
        // ���W�J
        // ���g(this)��defaultMap�ɐݒ肷��B
        getThis().setSource(defaultMap);
        // �����I�����ڂ�W�J����B
        getThis().bindSource();
        // ���ȉ��̓��e�ڍ׍��ڂ́A�I�����Ə��́u�Ȃ��v�u����v�ɂ���āA����/�L����؂�ւ���B

        if (staffs instanceof VRList) {
            int idx = ACBindUtilities.getMatchIndexFromValue(
                    staffs, "CARE_MANAGER_NO",
                    getKaigoSupportSpecialMemberNumber().getText());
            if(idx>=0){
                getKaigoSupportSpecialMemberName().setSelectedIndex(idx);
            }
        }
	  }
  }

  /**
   * �u���͓��e�̕s���������v�Ɋւ��鏈�����s�Ȃ��܂��B
   * @throws Exception ������O
   */
  public VRMap getValidData() throws Exception{
    // �����͓��e�ɕs�����Ȃ������`�F�b�N���A�T�[�r�X�f�[�^��Ԃ��B
    // �E�v���̓��̓`�F�b�N
    if(!"".equals(getTekiyouText().getText())){
        String val = getTekiyouText().getText();
        // 6���ȊO�̏ꍇ
        if(val != null && val.length() != 6){
            QkanMessageList.getInstance().QS001_ERROR_OF_TEKIYOU_INPUT();
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
    // �@�֐��̕Ԃ�l�Ƃ��ĊJ�n���ԃR���{��Ԃ��B
return null;
  }

  /**
   * �u�I���������͗p�̃R���{�擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
   * @throws Exception ������O
   */
  public ACComboBox getEndTimeCombo() throws Exception{
    // ���I���������͗p�̃R���{��Ԃ��B
    // �@�֐��̕Ԃ�l�Ƃ��ďI�����ԃR���{��Ԃ��B
return null;
  }

}
