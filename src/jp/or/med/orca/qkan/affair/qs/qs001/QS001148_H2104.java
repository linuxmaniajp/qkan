
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
 * �v���O���� �T�[�r�X�p�^�[�����\�h�F�m�ǑΉ��^�����������i�Z�����p�ȊO�j (QS001148_H2104)
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
 * �T�[�r�X�p�^�[�����\�h�F�m�ǑΉ��^�����������i�Z�����p�ȊO�j(QS001148_H2104) 
 */
public class QS001148_H2104 extends QS001148_H2104Event {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001148_H2104(){
  }

  //�R���|�[�l���g�C�x���g

  public static void main(String[] args) {
    //�f�t�H���g�f�o�b�O�N��
    ACFrame.getInstance().setFrameEventProcesser(new QkanFrameEventProcesser());
    QkanCommon.debugInitialize();
    VRMap param = new VRHashMap();
    //param�ɓn��p�����^���l�߂Ď��s���邱�ƂŁA�ȈՃf�o�b�O���\�ł��B
    ACFrame.debugStart(new ACAffairInfo(QS001148_H2104.class.getName(), param));
  }

  //�����֐�

  /**
   * �u�������v�Ɋւ��鏈�����s�Ȃ��܂��B
   * @throws Exception ������O
   */
  public void initialize() throws Exception{
      // ����ʓW�J���̏����ݒ�
      // ��ʂ̃��W�I�̏����l��ݒ肷��B�iselectFirstRadioItem�j
      QkanCommon.selectFirstRadioItem(getThis());

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
          // �E���̌����ɂ�錸�Z�i���Ə��p�l���jKEY�F1370102�̒l���`�F�b�N����B
          switch (ACCastUtilities.toInt(VRBindPathParser.get("1370102",
                  provider),0)) {
          case 1:
              // �l��1�i�Ȃ��j�������ꍇ
              // defaultMap�� KEY�F1370102 VALUE�F1�i�Ȃ��j��ݒ肷��B
              VRBindPathParser.set("1370102", defaultMap, new Integer(1));
              break;
          case 2:
              // �l��2�i���]�Ǝҁj�������ꍇ
              // defaultMap�� KEY�F1370102 VALUE�F3�i���]�Ǝ҂������j��ݒ肷��B
              VRBindPathParser.set("1370102", defaultMap, new Integer(3));
              break;
          }
          // ��ԋΖ�������i���Ə��p�l���jKEY�F1370101�̒l���`�F�b�N����B
          switch (ACCastUtilities.toInt(VRBindPathParser.get("1370101",
                  provider),0)) {
          case 1:
              // �l��1�i��^�j�������ꍇ
              // defaultMap�� KEY�F1370103 VALUE�F1�i�������Ă���j��ݒ肷��B
              VRBindPathParser.set("1370103", defaultMap, new Integer(1));
              break;
          case 2:
              // �l��2�i���Z�^�j�������ꍇ
              // defaultMap�� KEY�F1370103 VALUE�F2�i�������Ă��Ȃ��j��ݒ肷��B
              VRBindPathParser.set("1370103", defaultMap, new Integer(2));
              break;
          }
          

          Object obj;
          // ��ԃP�A���Z
          obj = VRBindPathParser.get("1370103", provider);
          if (obj != null) {
              VRBindPathParser.set("1370104", defaultMap, obj);
          }
          //��N���F�m�Ǘ��p�Ҏ�����Z�i���Ə��p�l���jKEY�F1370104�̒l���`�F�b�N����B
          obj = VRBindPathParser.get("1370104", provider);
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
          //���defaultMap�� KEY�F1370105 VALUE�F1�i�Ȃ��j��ݒ肷��B
          VRBindPathParser.set("1370105", defaultMap, new Integer(1));   
          
          //�F�m�ǐ��P�A���Z�i���Ə��p�l���jKEY�F1370105�̒l���`�F�b�N����B
          obj = VRBindPathParser.get("1370105", provider);
          switch (ACCastUtilities.toInt(obj,0)) {
          //�l�����̂����ꂩ�������ꍇ
          case 2:
              //2�i���ZI�j
          case 3:
              //3�i���ZII�j
              //�L���ɂ���B
              setState_VALID_DEMENTIA_PRO_CARE();
              break;
          default:
              //�l����L�ȊO�������ꍇ
              //�����ɂ���B
              setState_INVALID_DEMENTIA_PRO_CARE();
              break;
          }
          //���defaultMap�� KEY�F1370106 VALUE�F1�i�Ȃ��j��ݒ肷��B
          VRBindPathParser.set("1370106", defaultMap, new Integer(1));   
          
          //�T�[�r�X�񋟑̐��������Z
          obj = VRBindPathParser.get("1370106", provider);
          if (obj != null) {
              VRBindPathParser.set("1370107", defaultMap, obj);
          }              
          
          // ���W�J
          // ���g(this)��defaultMap�ɐݒ肷��B
          getThis().setSource(defaultMap);
          // �����I�����ڂ�W�J����B
          getThis().bindSource();
          // ���ȉ��̓��e�ڍ׍��ڂ́A�I�����Ə��́u�Ȃ��v�u����v�ɂ���āA����/�L����؂�ւ���B
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
