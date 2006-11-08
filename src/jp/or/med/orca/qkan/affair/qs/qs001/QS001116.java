
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
 * �v���O���� �T�[�r�X�p�^�[�������p�� (QS001116)
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
import jp.or.med.orca.qkan.text.*;

/**
 * �T�[�r�X�p�^�[�������p��(QS001116) 
 */
public class QS001116 extends QS001116Event {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001116(){
  }

  //�R���|�[�l���g�C�x���g

  public static void main(String[] args) {
    //�f�t�H���g�f�o�b�O�N��
    ACFrame.getInstance().setFrameEventProcesser(new QkanFrameEventProcesser());
    QkanCommon.debugInitialize();
    VRMap param = new VRHashMap();
    //param�ɓn��p�����^���l�߂Ď��s���邱�ƂŁA�ȈՃf�o�b�O���\�ł��B
    ACFrame.debugStart(new ACAffairInfo(QS001116.class.getName(), param));
  }

  //�����֐�

  /**
   * �u�������v�Ɋւ��鏈�����s�Ȃ��܂��B
   * @throws Exception ������O
   */
  public void initialize() throws Exception{
      // ����ʓW�J���̏����ݒ�
      // ���R���{�A�C�e���̐ݒ�
      // ������
      // �R���{�A�C�e���ݒ�p�̃��R�[�h comboItemMap �𐶐�����B
      VRMap comboItemMap = new VRHashMap();
      // �������p��X�g
      // �R�[�h�}�X�^�f�[�^���CODE_ID�F47(�p��j���擾����B
      // �擾�����l���AcomboItemMap�� KEY : 1170101 �� VALUE �Ƃ��Đݒ肷��B
      comboItemMap.setData("1170101", QkanCommon.getArrayFromMasterCode(47,
              "1170101"));
      // ���R���{�A�C�e���̐ݒ�
      // ���g(this)��comboItemMap�ɐݒ肷��B
      getThis().setModelSource(comboItemMap);
      // �R���{�A�C�e����W�J����B
      getThis().bindModelSource();

  }

  /**
   * �u���Ə��R���{�ύX���֐��v�Ɋւ��鏈�����s�Ȃ��܂��B
   * @throws Exception ������O
   */
  public void providerSelected(VRMap provider) throws Exception{
      // �����Ə��R���{�ύX���ɌĂԊ֐�
      if (provider != null) {
          Object obj;
          // ���ȉ��̓��e�ڍ׍��ڂ́A�I�����Ə��́u�Ȃ��v�u����v�ɂ���āA����/�L����؂�ւ���B

          // ���ʒn����Z
          obj = VRBindPathParser.get("SPECIAL_AREA_FLAG", provider);
          if (obj != null) {
              if (ACCastUtilities.toInt(obj) == 1) {
                  // �u�Ȃ��v�̏ꍇ
                  // �����ɂ���B
                  setState_INVALID_ADD_SPECIAL_ARE();
              } else {
                  // �u����v�̏ꍇ
                  // �L���ɂ���B
                  setState_VALID_ADD_SPECIAL_ARE();
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
      if (!getWelfareTools().isSelected()) {
          // �p��R���{(welfareTools)�����I���̏ꍇ
          // ���e�ڍׂ̕s�����b�Z�[�W��\������B��ID=QS001_ERROR_OF_NO_CONTENT
          QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
          // null��Ԃ��B
          return null;
      }
      if (ACTextUtilities.isNullText(getWelfarePoint().getText())) {
          // �P�ʐ��e�L�X�g(welfarePoint)���󗓂̏ꍇ
          // ���e�ڍׂ̕s�����b�Z�[�W��\������B��ID=QS001_ERROR_OF_NO_CONTENT
          QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
          // null��Ԃ��B
          return null;
      }
//      if (ACTextUtilities.isNullText(getWelfareTekiyo().getText())) {
//          // �E�v�e�L�X�g(welfareTekiyo)���󗓂̏ꍇ
//          // ���e�ڍׂ̕s�����b�Z�[�W��\������B��ID=QS001_ERROR_OF_NO_CONTENT
//          QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
//          // null��Ԃ��B
//          return null;
//      }
      // ���ԋp�p�̃��R�[�h(data)�𐶐�
      VRMap data = new VRHashMap();
      // ���g(this)�̃\�[�X�Ƃ��Đ������R�[�h��ݒ肷��B
      getThis().setSource(data);
      // ���g(this)��applySource���Ăяo���ăf�[�^�����W����B
      getThis().applySource();

      // ���ԋp�p���R�[�h����s�v�ȃL�[������
      QkanCommon.removeDisabledBindPath(getThis(), data);
      if (getWelfareTokuchiPoint().isEnabled()) {
          // ���n���Z�e�L�X�g(welfareTokuchiPoint)���L���̏ꍇ
          String val = getWelfareTokuchiPoint().getText();
          if (ACTextUtilities.isNullText(val) || (ACCastUtilities.toInt(val,0) == 0)) {
              // ���n���Z�e�L�X�g(welfareTokuchiPoint)���󗓂��l��0�̏ꍇ
              // �ԋp�p���R�[�h����A���n���Z�e�L�X�g(welfareTokuchiPoint)��bindPath����������B
              data.remove(getWelfareTokuchiPoint().getBindPath());
          }
      }

      // ���Ȃ���Εԋp�p���R�[�h(data)��Ԃ��B
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
