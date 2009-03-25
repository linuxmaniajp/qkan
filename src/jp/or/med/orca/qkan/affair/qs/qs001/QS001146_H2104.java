
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
 * �T�u�V�X�e�� �T�[�r�X�\��쐬/�ύX (S)
 * �v���Z�X �T�[�r�X�\�� (001)
 * �v���O���� �T�[�r�X�p�^�[�����\�h�F�m�ǑΉ��^�ʏ���� (QS001146_H2104)
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
 * �T�[�r�X�p�^�[�����\�h�F�m�ǑΉ��^�ʏ����(QS001146_H2104) 
 */
public class QS001146_H2104 extends QS001146_H2104Event {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001146_H2104(){
  }

  //�R���|�[�l���g�C�x���g

  /**
   * �u�J�n���ԑI���v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected void beginTimeActionPerformed(ActionEvent e) throws Exception{
    // �J�n���ԑI��
    // �@�I�����Ԑݒ菈��
    checkEndTime();


  }

  /**
   * �u�����敪�I���v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected void timeDivisionRadioSelectionChanged(ListSelectionEvent e) throws Exception{
    // �����敪�I��
    // �@�I�����ԍĐݒ菈��
    checkEndTime();


  }

  /**
   * �u�{�݋敪1,2�̘A���v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected void providerDivisionRadioSelectionChanged(ListSelectionEvent e) throws Exception{
    // ���{�݋敪1�̏�Ԃɉ����Ď{�݋敪2�̗L����Ԃ�؂�ւ���B
    // �@�{�݋敪1�̏�Ԃɉ����Ď{�݋敪2�̗L����Ԃ�؂�ւ���B
    checkState();


  }

  public static void main(String[] args) {
    //�f�t�H���g�f�o�b�O�N��
    ACFrame.getInstance().setFrameEventProcesser(new QkanFrameEventProcesser());
    QkanCommon.debugInitialize();
    VRMap param = new VRHashMap();
    //param�ɓn��p�����^���l�߂Ď��s���邱�ƂŁA�ȈՃf�o�b�O���\�ł��B
    ACFrame.debugStart(new ACAffairInfo(QS001146_H2104.class.getName(), param));
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
      // �擾�����l���AcomboItemMap�� KEY : 3 �� VALUE �Ƃ��Đݒ肷��B
      comboItemMap.setData("3", QkanCommon.getArrayFromMasterCode(23, "4"));
      // ���I������
      // �R�[�h�}�X�^�f�[�^���CODE_ID�F23�i�����E�j���̑I�� / ����(�J�n)�j���擾����B
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
      // ��ʂ̃��W�I�̏����l��ݒ肷��B�iselectFirstRadioItem�j
      QkanCommon.selectFirstRadioItem(getThis());
      // ���W�J
      // ���g(this)��defaultMap�ɐݒ肷��B
      getThis().setSource(defaultMap);
      // �����I�����ڂ�W�J����B
      getThis().bindSource();
      // ��ʏ�Ԑ���
      checkState();

  }

  /**
   * �u���Ə��R���{�ύX���֐��v�Ɋւ��鏈�����s�Ȃ��܂��B
   * @throws Exception ������O
   */
  public void providerSelected(VRMap provider) throws Exception{
      // �����Ə��R���{�ύX���ɌĂԊ֐�
      // �I�����Ə����null�łȂ��ꍇ
      if (provider != null) {
          // ���ȉ��̓��e�ڍ׍��ڂ́A�I�����Ə��̒l��ݒ肷��B
          // ������
          // ���Ə��A���p�̃��R�[�h defaultMap �𐶐�����B
          VRMap defaultMap = new VRHashMap();
          // ���ݒ�
          // �{�ݓ��̋敪�i���Ə��p�l���jKEY�F1740101�̒l���`�F�b�N����B
          switch (ACCastUtilities.toInt(VRBindPathParser.get("1740101",
                  provider),0)) {
          case 1:
          // 2008/06/06 [Masahiko Higuchi] del - begin �d�l��Q�Ή��i���Ɠ���ɈႢ�����������ߓ���j
          //case 3:
          // 2008/06/06 [Masahiko Higuchi] del - end
              // �l��1�i�P�ƌ^�j�������ꍇ
              // defaultMap�� KEY�F1740101 VALUE�F1�i�Ȃ��j��ݒ肷��B
              VRBindPathParser.set("1740101", defaultMap, new Integer(1));
              break;
          case 2:
          // 2008/06/06 [Masahiko Higuchi] add - begin �d�l��Q�Ή��i���Ɠ���ɈႢ�����������ߓ���j
          case 3:
          // 2008/06/06 [Masahiko Higuchi] add - end
              // �l��2�i���݌^�j�������ꍇ
              // defaultMap�� KEY�F1740101 VALUE�F2�i����j��ݒ肷��B
              VRBindPathParser.set("1740101", defaultMap, new Integer(2));
              break;
          }
          // �E���̌����ɂ�錸�Z�̏󋵁i���Ə��p�l���jKEY�F1740102�̒l���`�F�b�N����B
          switch (ACCastUtilities.toInt(VRBindPathParser.get("1740102",
                  provider),0)) {
          case 1:
              // �l��1�i�Ȃ��j�������ꍇ
              // defaultMap�� KEY�F1740104 VALUE�F1�i�Ȃ��j��ݒ肷��B
              VRBindPathParser.set("1740104", defaultMap, new Integer(1));
              break;
          case 2:
          case 3:
              // �l��2����3�������ꍇ�i�Ō�E���E���E���j�������ꍇ
              // defaultMap�� KEY�F1740104 VALUE�F3�i�Ō�E���E���������j��ݒ肷��B
              VRBindPathParser.set("1740104", defaultMap, new Integer(3));
              break;
          }
          // �ʋ@�\�P���̐��i���Ə��p�l���jKEY�F1740104�̒l���`�F�b�N����B
          switch (ACCastUtilities.toInt(VRBindPathParser.get("1740104",
                  provider),0)) {
          case 1:
              // �l��1�i�Ȃ��j�������ꍇ
              // defaultMap�� KEY�F1740106 VALUE�F1�i�Ȃ��j��ݒ肷��B
              VRBindPathParser.set("1740106", defaultMap, new Integer(1));
              break;
          case 2:
              // �l��2�i����j�������ꍇ
              // defaultMap�� KEY�F1740106 VALUE�F2�i����j��ݒ肷��B
              VRBindPathParser.set("1740106", defaultMap, new Integer(2));
              break;
          }
          // ��������Z�i���Ə��p�l���jKEY�F1740105�̒l���`�F�b�N����B
          switch (ACCastUtilities.toInt(VRBindPathParser.get("1740105",
                  provider),0)) {
          case 1:
              // �l��1�i�Ȃ��j�������ꍇ
              // defaultMap�� KEY�F1740105 VALUE�F1�i�Ȃ��j��ݒ肷��B
              VRBindPathParser.set("1740105", defaultMap, new Integer(1));
              break;
          case 2:
              // �l��2�i����j�������ꍇ
              // defaultMap�� KEY�F1740105 VALUE�F2�i����j��ݒ肷��B
              VRBindPathParser.set("1740105", defaultMap, new Integer(2));
              break;
          }
          // �h�{���P�̐��i���Ə��p�l���jKEY�F1740106�̒l���`�F�b�N����B
          switch (ACCastUtilities.toInt(VRBindPathParser.get("1740106",
                  provider),0)) {
          case 1:
              // �l��1�i�Ȃ��j�������ꍇ
              // defaultMap�� KEY�F1740107 VALUE�F1�i�Ȃ��j��ݒ肷��B
              VRBindPathParser.set("1740107", defaultMap, new Integer(1));
              break;
          case 2:
              // �l��2�i����j�������ꍇ
              // defaultMap�� KEY�F1740107 VALUE�F2�i����j��ݒ肷��B
              VRBindPathParser.set("1740107", defaultMap, new Integer(2));
              break;
          }
          // ���o�@�\����̐��i���Ə��p�l���jKEY�F1740107�̒l���`�F�b�N����B
          switch (ACCastUtilities.toInt(VRBindPathParser.get("1740107",
                  provider),0)) {
          case 1:
              // �l��1�i�Ȃ��j�������ꍇ
              // defaultMap�� KEY�F1740108 VALUE�F1�i�Ȃ��j��ݒ肷��B
              VRBindPathParser.set("1740108", defaultMap, new Integer(1));
              break;
          case 2:
              // �l��2�i����j�������ꍇ
              // defaultMap�� KEY�F1740108 VALUE�F2�i����j��ݒ肷��B
              VRBindPathParser.set("1740108", defaultMap, new Integer(2));
              break;
          }
          
          Object obj;

          //��N���F�m�Ǘ��p�Ҏ�����Z�i���Ə��p�l���jKEY�F1740108�̒l���`�F�b�N����B
          obj = VRBindPathParser.get("1740108", provider);
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
          //���defaultMap�� KEY�F1740109 VALUE�F1�i�Ȃ��j��ݒ肷��B
          VRBindPathParser.set("1740109", defaultMap, new Integer(1));   

          // �T�[�r�X�񋟑̐��������Z
          obj = VRBindPathParser.get("1740109", provider);
          if (obj != null) {
              defaultMap.setData("1740110", obj);
          }          
          
          // ���W�J
          // ���g(this)��defaultMap�ɐݒ肷��B
          getThis().setSource(defaultMap);
          // �����I�����ڂ�W�J����B
          getThis().bindSource();
          // ���ȉ��̓��e�ڍ׍��ڂ́A�I�����Ə��́u�Ȃ��v�u����v�ɂ���āA����/�L����؂�ւ���B
          // ��ʏ�Ԑ���
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
      if (ACTextUtilities.isNullText(getBeginTime().getText())
              || ACTextUtilities.isNullText(getEndTime().getText())
              || (!getBeginTime().isValidDate())
              || (!getEndTime().isValidDate())) {
          // �J�n�����R���{(houmonKangoIryoBeginTime)�ƏI�������R���{(houmonKangoIryoEndTime)�̂����ꂩ���󗓂��s���̏ꍇ
          // �����̕s�����b�Z�[�W��\������B��ID=QS001_ERROR_OF_NO_TIME
          QkanMessageList.getInstance().QS001_ERROR_OF_NO_TIME();
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
return getBeginTime();
  }

  /**
   * �u�I���������͗p�̃R���{�擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
   * @throws Exception ������O
   */
  public ACComboBox getEndTimeCombo() throws Exception{
    // ���I���������͗p�̃R���{��Ԃ��B
    // �@�֐��̕Ԃ�l�Ƃ��ďI�����ԃR���{��Ԃ��B
return getEndTime();
  }

  /**
   * �u��ʏ�Ԑ���v�Ɋւ��鏈�����s�Ȃ��܂��B
   * @throws Exception ������O
   */
  public void checkState() throws Exception{
      // ����ʏ�Ԑ��䏈��
      // ���T�[�r�X�A��
      // �{�ݓ��̋敪�P�iproviderDivisionRadio�j�̒l���`�F�b�N����B
      switch (getProviderDivisionRadio().getSelectedIndex()) {
      case 1:
          // �l���P�i�T�^�j�������ꍇ
          // ��ʏ�Ԃ��ʏ�ԂP��ɕύX����B
          setState_STATE_MODE_2();
          break;
      case 2:
          // �l���Q�i�U�^�j�������ꍇ
          // ��ʂ̏�Ԃ��ʏ�ԂQ��ɕύX����B
          setState_STATE_MODE_1();
          break;
      }
      // �����Ə��A��
      // �����ϐ� providerInfoMap �𐶐�����B
      VRMap providerInfoMap = new VRHashMap();
      // ���Ə��p�l�������擾�� providerInfoMap �Ɋi�[����B
      // getSelectedProvider();
      providerInfoMap = getSelectedProvider();
      // providerInfoMap�� null ���`�F�b�N����B
      if (providerInfoMap != null) {
          // null�i���Ə����I���j�������ꍇ
          // �����s��Ȃ��B
          // null�ȊO�������ꍇ
          // �ʋ@�\�P���̐��i���Ə��p�l���j�̒l���`�F�b�N����B
          switch (ACCastUtilities.toInt(VRBindPathParser.get("1740104",
                  providerInfoMap))) {
          // �l��1�i�Ȃ��j�������ꍇ
          case 1:
              // �ʋ@�\�P�����Z�i�T�[�r�X�p�l���j��Enable��false�ɂ���B
              setState_FUNCTION_TRAINING_ENABLE_FALSE();
              break;
          // �l��2�i����j�������ꍇ
          case 2:
              // �ʋ@�\�P�����Z�i�T�[�r�X�p�l���j��Enable��true�ɂ���B
              setState_FUNCTION_TRAINING_ENABLE_TRUE();
              break;
          }
          // ������̐��i���Ə��p�l���j�̒l���`�F�b�N����B
          switch (ACCastUtilities.toInt(VRBindPathParser.get("1740105",
                  providerInfoMap))) {
          case 1:
              // �l��1�i�Ȃ��j�������ꍇ
              // ��������Z�i�T�[�r�X�p�l���j��Enable��false�ɂ���B
              setState_BATH_CARE_ENABLE_FALSE();
              break;
          case 2:
              // �l��2�i����j�������ꍇ
              // ��������Z�i�T�[�r�X�p�l���j��Enable��true�ɂ���B
              setState_BATH_CARE_ENABLE_TRUE();
              break;
          }
          // �h�{���P�̐��i���Ə��p�l���j�̒l���`�F�b�N����B
          switch (ACCastUtilities.toInt(VRBindPathParser.get("1740106",
                  providerInfoMap))) {
          case 1:
              // �l��1�i�Ȃ��j�������ꍇ
              // �h�{���P���Z�i�T�[�r�X�p�l���j��Enable��false�ɂ���B
              setState_NOURISHMENT_MANAGEMENT_ENABLE_FALSE();
              break;
          case 2:
              // �l��2�i����j�������ꍇ
              // �h�{���P���Z�i�T�[�r�X�p�l���j��Enable��true�ɂ���B
              setState_NOURISHMENT_MANAGEMENT_ENABLE_TRUE();
              break;
          }
          // ���o�@�\����̐��i���Ə��p�l���j�̒l���`�F�b�N����B
          switch (ACCastUtilities.toInt(VRBindPathParser.get("1740107",
                  providerInfoMap))) {
          case 1:
              // �l��1�i�Ȃ��j�������ꍇ
              // ���o�@�\������Z�i�T�[�r�X�p�l���j��Enable��false�ɂ���B
              setState_ORAL_FUNCTION_ENABLE_FALSE();
              break;
          case 2:
              // �l��2�i����j�������ꍇ
              // ���o�@�\������Z�i�T�[�r�X�p�l���j��Enable��true�ɂ���B
              setState_ORAL_FUNCTION_ENABLE_TRUE();
              break;
          }
      }

  }

  /**
   * �u���ԋ敪�擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
   * @throws Exception ������O
   */
  public int getNintiTusyoTime() throws Exception{
      // �����ԋ敪(gtimeDivisionRadio)�̎��Ԃ��擾
      switch (getTimeDivisionRadio().getSelectedIndex()) {
      // ���ԋ敪(timeDivisionRadio)�̒l���`�F�b�N����B
      case 1:
          // �l��1�i�Q���Ԉȏ�R���Ԗ����j�̏ꍇ
          // �߂�l�Ƃ���180��Ԃ��B
          return 180;
      case 2:
          // �l��2�i�R���Ԉȏ�S���Ԗ����j�̏ꍇ
          // �߂�l�Ƃ���240��Ԃ��B
          return 240;
      case 3:
          // �l��3�i�S���Ԉȏ�U���Ԗ����j�̏ꍇ
          // �߂�l�Ƃ���360��Ԃ��B
          return 360;
      case 4:
          // �l��4�i�U���Ԉȏ�W���Ԗ����j�̏ꍇ
          // �߂�l�Ƃ���480��Ԃ��B
          return 480;
      case 5:
          // �l��5�i�W���Ԉȏ�X���Ԗ����j�̏ꍇ
          // �߂�l�Ƃ���540��Ԃ��B
          return 540;
      case 6:
          // �l��6�i�X���Ԉȏ�P�O���Ԗ����j�̏ꍇ
          // �߂�l�Ƃ���600��Ԃ��B
          return 600;
      default:
          // �Y�����ڂ����݂��Ȃ��ꍇ
          // �߂�l�Ƃ���0��Ԃ��B
          return 0;
      }
  }

  /**
   * �u�J�n�E�I�����Ԑݒ�v�Ɋւ��鏈�����s�Ȃ��܂��B
   * @throws Exception ������O
   */
  public void checkEndTime() throws Exception{
      // ���J�n�E�I�����ԍĐݒ�
      // �����ϐ� kaigoTime �𐶐�����B
      // �J�n���ԃR���{(beginTime)�̒l�����`�F�b�N����B
      if (getBeginTime().isValidDate()
              && !ACTextUtilities.isNullText(getBeginTime().getText())) {
          // �s���łȂ��ꍇ
          // ���ԑޔ�p�̕ϐ�kaigoTime�ɁA���ԋ敪����擾�������Ԃ�ݒ肷��B
          int kaigoTime = getNintiTusyoTime();
          // �I�����Ԃ��u�J�n���� + kaigoTime(��)�v�ɐݒ肷��B
          getEndTime().setDate(
                  ACDateUtilities.addMinute(getBeginTime().getDate(),
                          kaigoTime));
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
