
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
 * �v���O���� �T�[�r�X�p�^�[�����\�h�ʏ����n�r���e�[�V���� (QS001136_H2104)
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
 * �T�[�r�X�p�^�[�����\�h�ʏ����n�r���e�[�V����(QS001136_H2104) 
 */
public class QS001136_H2104 extends QS001136_H2104Event {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001136_H2104(){
  }

  //�R���|�[�l���g�C�x���g

  public static void main(String[] args) {
    //�f�t�H���g�f�o�b�O�N��
    ACFrame.getInstance().setFrameEventProcesser(new QkanFrameEventProcesser());
    QkanCommon.debugInitialize();
    VRMap param = new VRHashMap();
    //param�ɓn��p�����^���l�߂Ď��s���邱�ƂŁA�ȈՃf�o�b�O���\�ł��B
    ACFrame.debugStart(new ACAffairInfo(QS001136_H2104.class.getName(), param));
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
      // �R�[�h�}�X�^�f�[�^���CODE_ID�F23�i�����E�j���̑I�� / ����(�J�n)�j���擾����B
      // �擾�����l���AcomboItemMap�� KEY : 3 �� VALUE �Ƃ��Đݒ肷��B
      comboItemMap.setData("3", QkanCommon.getArrayFromMasterCode(23, "3"));
      // �擾�����l���AcomboItemMap�� KEY : 4 �� VALUE �Ƃ��Đݒ肷��B
      comboItemMap.setData("4", QkanCommon.getArrayFromMasterCode(23, "4"));
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
      // ��ʏ�Ԃ�ݒ肷��B
      checkState();

      // ���W�J
      // ���g(this)��defaultMap�ɐݒ肷��B
      getThis().setSource(defaultMap);
      // �����I�����ڂ�W�J����B
      getThis().bindSource();
      // �@�@��ʂ̃��W�I�̏����l��ݒ肷��B�iselectFirstRadioItem�j
      QkanCommon.selectFirstRadioItem(getThis());

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
          // �E���̌����ɂ�錸�Z�̏󋵁i���Ə��p�l���jKEY�F1660101�̒l���`�F�b�N����B
          switch (ACCastUtilities.toInt(VRBindPathParser.get("1660101",
                  provider), 0)) {
          case 1:
              // �l��1�i�Ȃ��j�������ꍇ
              // defaultMap�� KEY�F1660101 VALUE�F1�i�Ȃ��j��ݒ肷��B
              VRBindPathParser.set("1660101", defaultMap, new Integer(1));
              break;
          case 2:
          case 3:
          case 4:
          case 5:
          case 6:
          case 7:
              // �l��2�i��t�E�Ō�E���E���E���EPT�EOT�EST�j�������ꍇ
              // defaultMap�� KEY�F1660101 VALUE�F3�i��t�EPT�EOT�EST�E�Ō�E���E���������j��ݒ肷��B
              VRBindPathParser.set("1660101", defaultMap, new Integer(3));
              break;
          }
          // �^����@�\����̐��i���Ə��p�l���jKEY�F1660102�̒l���`�F�b�N����B
          switch (ACCastUtilities.toInt(VRBindPathParser.get("1660102",
                  provider), 0)) {
          case 1:
              // �l��1�i�Ȃ��j�������ꍇ
              // defaultMap�� KEY�F1660103 VALUE�F1�i�Ȃ��j��ݒ肷��B
              VRBindPathParser.set("1660103", defaultMap, new Integer(1));
              break;
          case 2:
              // �l��2�i����j�������ꍇ
              // defaultMap�� KEY�F1660103 VALUE�F2�i����j��ݒ肷��B
              VRBindPathParser.set("1660103", defaultMap, new Integer(2));
              break;
          }
          // �h�{���P�̐��i���Ə��p�l���jKEY�F1660103�̒l���`�F�b�N����B
          switch (ACCastUtilities.toInt(VRBindPathParser.get("1660103",
                  provider), 0)) {
          case 1:
              // �l��1�i�Ȃ��j�������ꍇ
              // defaultMap�� KEY�F1660104 VALUE�F1�i�Ȃ��j��ݒ肷��B
              VRBindPathParser.set("1660104", defaultMap, new Integer(1));
              break;
          case 2:
              // �l��2�i����j�������ꍇ
              // defaultMap�� KEY�F1660104 VALUE�F2�i����j��ݒ肷��B
              VRBindPathParser.set("1660104", defaultMap, new Integer(2));
              break;
          }
          // ���o�@�\����̐��i���Ə��p�l���jKEY�F1660104�̒l���`�F�b�N����B
          switch (ACCastUtilities.toInt(VRBindPathParser.get("1660104",
                  provider), 0)) {
          case 1:
              // �l��1�i�Ȃ��j�������ꍇ
              // defaultMap�� KEY�F1660105 VALUE�F1�i�Ȃ��j��ݒ肷��B
              VRBindPathParser.set("1660105", defaultMap, new Integer(1));
              break;
          case 2:
              // �l��2�i����j�������ꍇ
              // defaultMap�� KEY�F1660105 VALUE�F2�i����j��ݒ肷��B
              VRBindPathParser.set("1660105", defaultMap, new Integer(2));
              break;
          }
          // ���Ə��]�����Z�̗L���i���Ə��p�l���jKEY�F1660105�̒l���`�F�b�N����B
          switch (ACCastUtilities.toInt(VRBindPathParser.get("1660105",
                  provider), 0)) {
          case 1:
              // �@�@�@�@�@�l��1�i�Ȃ��j�������ꍇ
              // �@�@�@�@�@�@defaultMap�� KEY�F1660106�@VALUE�F1�i�Ȃ��j��ݒ肷��B
              VRBindPathParser.set("1660106", defaultMap, new Integer(1));
              break;
          case 2:
              // �@�@�@�@�@�l��2�i����j�������ꍇ
              // �@�@�@�@�@�@defaultMap�� KEY�F1660106�@VALUE�F2�i����j��ݒ肷��B
              VRBindPathParser.set("1660106", defaultMap, new Integer(2));
              break;
          }
          
          Object obj;
          
          //��N���F�m�Ǘ��p�Ҏ�����Z�i���Ə��p�l���jKEY�F1660106�̒l���`�F�b�N����B
          obj = VRBindPathParser.get("1660106", provider);
          switch (ACCastUtilities.toInt(obj,0)) {
          //�l�����̂����ꂩ�������ꍇ
          case 2:
              //2�i����j
              //�L���ɂ���B
              setState_VALID_YOUNG_DEMENTIA_PATINET();
              break;
          default:
              //�l����L�ȊO�������ꍇ
              //�����ɂ���B
              setState_INVALID_YOUNG_DEMENTIA_PATINET();
              break;
          }
          //���defaultMap�� KEY�F1660107 VALUE�F1�i�Ȃ��j��ݒ肷��B
          VRBindPathParser.set("1660107", defaultMap, new Integer(1));   
          
          
          //�T�[�r�X�񋟑̐��������Z�@���Ə���[1660107]���T�[�r�X�p�l����[1660108]�ɐݒ肷��B
          VRBindPathParser.set("1660108", defaultMap, VRBindPathParser.get("1660107", provider));
          
          
          // �@�@�@���W�J
          // �@�@�@�@���g(this)��defaultMap��ݒ肷��B
          getThis().setSource(defaultMap);
          // �@�@�@�@�����I�����ڂ�W�J����B
          getThis().bindSource();
          // �@�@���ȉ��̓��e�ڍ׍��ڂ́A�I�����Ə��́u�Ȃ��v�u����v�ɂ���āA����/�L����؂�ւ���B
          // �@�@�@��ʂ̏�Ԃ�ύX����B
          checkState();
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
      // �������R���{�`�F�b�N
      if (!getHoumonKaigoBeginTime().isValidDate()
              || (!getHoumonKaigoEndTime().isValidDate())) {
          // �J�n�����R���{(houmonKaigoBeginTime)�ƏI�������R���{(houmonKaigoEndTime)�̂����ꂩ���󗓂������͕s���̏ꍇ
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
      return getHoumonKaigoBeginTime();
  }

  /**
   * �u�I���������͗p�̃R���{�擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
   * @throws Exception ������O
   */
  public ACComboBox getEndTimeCombo() throws Exception{
      // ���I���������͗p�̃R���{��Ԃ��B
      // �@�֐��̕Ԃ�l�Ƃ��ďI�����ԃR���{��Ԃ��B
      return getHoumonKaigoEndTime();
  }

  /**
   * �u��ʏ�Ԑ���v�Ɋւ��鏈�����s�Ȃ��܂��B
   * @throws Exception ������O
   */
  public void checkState() throws Exception{
      // ����ʏ�Ԑ�����s���܂��B
      // ���������ڂ̐ݒ���s���B
      // �����ϐ� providerInfoMap �𐶐�����B
      VRMap providerInfoMap;
      // ���Ə��p�l�������擾�� providerInfoMap �Ɋi�[����B
      providerInfoMap = getSelectedProvider();

      // providerInfoMap�� null ���`�F�b�N����B
      // null�i���Ə����I���j�������ꍇ
      // �����s��Ȃ��B
      if (providerInfoMap != null) {
          // null�ȊO�������ꍇ
          // �^����@�\����̐��i���Ə��p�l���j�̒l���`�F�b�N����B
          switch (ACCastUtilities.toInt(VRBindPathParser.get("1660102",
                  providerInfoMap), 0)) {
          case 1:
              // �l��1�i�Ȃ��j�������ꍇ
              // �^����@�\������Z�i�T�[�r�X�p�l���j��Enable��false�ɂ���B
              setState_MOVE_FUNCTION_IMPROVEMENT_ENABLE_FALSE();
              break;
          case 2:
              // �l��2�i����j�������ꍇ
              // �^����@�\������Z�i�T�[�r�X�p�l���j��Enable��true�ɂ���B
              setState_MOVE_FUNCTION_IMPROVEMENT_ENABLE_TRUE();
              break;
          }
          // �h�{���P�̐��i���Ə��p�l���j�̒l���`�F�b�N����B
          switch (ACCastUtilities.toInt(VRBindPathParser.get("1660103",
                  providerInfoMap), 0)) {
          case 1:
              // �l��1�i�Ȃ��j�������ꍇ
              // �h�{���P���Z�i�T�[�r�X�p�l���j��Enable��false�ɂ���B
              setState_NOURISHMENT_IMPROVEMENT_ENABLE_FALSE();
              break;
          case 2:
              // �l��2�i����j�������ꍇ
              // �h�{���P���Z�i�T�[�r�X�p�l���j��Enable��true�ɂ���B
              setState_NOURISHMENT_IMPROVEMENT_ENABLE_TRUE();
              break;
          }
          // ���o�@�\����̐��i���Ə��p�l���j�̒l���`�F�b�N����B
          switch (ACCastUtilities.toInt(VRBindPathParser.get("1660104",
                  providerInfoMap), 0)) {
          case 1:
              // �l��1�i�Ȃ��j�������ꍇ
              // ���o�@�\������Z�i�T�[�r�X�p�l���j��Enable��false�ɂ���B
              setState_MOUTH_FUNCTION_IMPROVEMENT_ENABLE_FALSE();
              break;
          case 2:
              // �l��2�i����j�������ꍇ
              // ���o�@�\������Z�i�T�[�r�X�p�l���j��Enable��true�ɂ���B
              setState_MOUTH_FUNCTION_IMPROVEMENT_ENABLE_TRUE();
              break;
          }
          // ���Ə��]�����Z�̗L���i���Ə��p�l���j�̒l���`�F�b�N����B
          switch (ACCastUtilities.toInt(VRBindPathParser.get("1660105",
                  providerInfoMap), 0)) {
          case 1:
              // �@�@�@�@�@�l��1�i�Ȃ��j�������ꍇ
              // �@�@�@�@�@�@���Ə��]�����Z�i�T�[�r�X�p�l���j��Enable��false�ɂ���B
              setState_OFFICE_EVALUATION_ENABLE_FALSE();
              break;
          case 2:
              // �@�@�@�@�@�l��2�i����j�������ꍇ
              // �@�@�@�@�@�@���Ə��]�����Z�i�T�[�r�X�p�l���j��Enable��true�ɂ���B
              setState_OFFICE_EVALUATION_ENABLE_TRUE();
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
