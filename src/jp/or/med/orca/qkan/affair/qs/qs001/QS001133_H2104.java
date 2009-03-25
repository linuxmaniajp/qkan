
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
 * �v���O���� �T�[�r�X�p�^�[�����\�h�K�⃊�n�r���e�[�V���� (QS001133_H2104)
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
 * �T�[�r�X�p�^�[�����\�h�K�⃊�n�r���e�[�V����(QS001133_H2104) 
 */
public class QS001133_H2104 extends QS001133_H2104Event {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001133_H2104(){
  }

  //�R���|�[�l���g�C�x���g

  public static void main(String[] args) {
    //�f�t�H���g�f�o�b�O�N��
    ACFrame.getInstance().setFrameEventProcesser(new QkanFrameEventProcesser());
    QkanCommon.debugInitialize();
    VRMap param = new VRHashMap();
    //param�ɓn��p�����^���l�߂Ď��s���邱�ƂŁA�ȈՃf�o�b�O���\�ł��B
    ACFrame.debugStart(new ACAffairInfo(QS001133_H2104.class.getName(), param));
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
      // ���W�J
      // ���g(this)��defaultMap�ɐݒ肷��B
      getThis().setSource(defaultMap);
      // �@�@�����I�����ڂ�W�J����B
      getThis().bindSource();

  }

  /**
   * �u���Ə��R���{�ύX���֐��v�Ɋւ��鏈�����s�Ȃ��܂��B
   * @throws Exception ������O
   */
  public void providerSelected(VRMap provider) throws Exception{
      // �����Ə��R���{�ύX���ɌĂԊ֐�
      if (provider != null) {
          // �I�����Ə����null�łȂ��ꍇ
          // ���ȉ��̓��e�ڍ׍��ڂ́A�I�����Ə��̒l��ݒ肷��B
          // ������
          // ���Ə��A���p�̃��R�[�h defaultMap �𐶐�����B
          VRMap defaultMap = new VRHashMap();
          // ���ݒ�
          // �{�݋敪�i���Ə��p�l���jKEY�F1640101�̒l���`�F�b�N����B
          switch (ACCastUtilities.toInt(VRBindPathParser.get("1640101",
                  provider), 0)) {
          case 1:
              // �l��1�i�a�@���͐f�Ï��jKEY�F1640101�������ꍇ
              // �{�݋敪�i�T�[�r�X�p�l���j�̕a�@���͐f�Ï���I����Ԃɂ���B
              VRBindPathParser.set("1640101", defaultMap, new Integer(1));
              break;
          case 2:
              // �l��2�i���V�l�ی��{�݁j�������ꍇ
              // �{�݋敪�i�T�[�r�X�p�l���j�̉��V�l�ی��{�݂�I����Ԃɂ���B
              VRBindPathParser.set("1640101", defaultMap, new Integer(2));
              break;
          }
          
          //�T�[�r�X�񋟑̐��������Z
          VRBindPathParser.set("1640104", defaultMap, VRBindPathParser.get("1640102", provider));
          
          // �@�@�@���W�J
          // �@�@�@�@���g(this)��defaultMap�ɐݒ肷��B
          getThis().setSource(defaultMap);
          // �@�@�@�@�����I�����ڂ�W�J����B
          getThis().bindSource();
          // �@�@���ȉ��̓��e�ڍ׍��ڂ́A�I�����Ə��́u�Ȃ��v�u����v�ɂ���āA����/�L����؂�ւ���B
      }

  }

  /**
   * �u���͓��e�̕s���������v�Ɋւ��鏈�����s�Ȃ��܂��B
   * @throws Exception ������O
   */
  public VRMap getValidData() throws Exception{
      // �����͓��e�ɕs�����Ȃ������`�F�b�N���A�T�[�r�X�f�[�^��Ԃ��B
      // ���ԋp�p�̃��R�[�h(data)�𐶐�
      VRMap data = new VRHashMap();
      // ���g(this)�̃\�[�X�Ƃ��Đ������R�[�h��ݒ肷��B
      getThis().setSource(data);
      // ���g(this)��applySource���Ăяo���ăf�[�^�����W����B
      getThis().applySource();
      // ���ԋp�p���R�[�h����s�v�ȃL�[������
      // �����͓��e�ɕs�����Ȃ������`�F�b�N���A�T�[�r�X�f�[�^��Ԃ�
      if (!getHoumonRehabilitationBeginTime().isValidDate()
              || (!getHoumonRehabilitationEndTime().isValidDate())) {
          // �J�n�����R���{(houmonRehabilitationBeginTime)�ƏI�������R���{(houmonRehabilitationEndTime)�̂����ꂩ���󗓂��s���̏ꍇ
          // �����̕s�����b�Z�[�W��\������B��ID=QS001_ERROR_OF_NO_TIME
          QkanMessageList.getInstance().QS001_ERROR_OF_NO_TIME();
          // �@�@null��Ԃ��B
          return null;
      }
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
      // true��Ԃ��B
      return true;
  }

  /**
   * �u�J�n�������͗p�̃R���{�擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
   * @throws Exception ������O
   */
  public ACComboBox getBeginTimeCombo() throws Exception{
      // ���J�n�������͗p�̃R���{��Ԃ��B
      // �֐��̕Ԃ�l�Ƃ��ĊJ�n���ԃR���{��Ԃ��B
      return getHoumonRehabilitationBeginTime();
  }

  /**
   * �u�I���������͗p�̃R���{�擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
   * @throws Exception ������O
   */
  public ACComboBox getEndTimeCombo() throws Exception{
      // ���I���������͗p�̃R���{��Ԃ��B
      // �@�֐��̕Ԃ�l�Ƃ��ďI�����ԃR���{��Ԃ��B
      return getHoumonRehabilitationEndTime();
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
