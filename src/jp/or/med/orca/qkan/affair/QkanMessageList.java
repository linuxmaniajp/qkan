
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
 * �J����: �c���@����
 * �쐬��: 2008/01/15  ���{�R���s���[�^�[������� �c���@���� �V�K�쐬
 * �X�V��: ----/--/--
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair;
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
/**
 * ���b�Z�[�W�ꗗ(QkanMessageList) 
 */
public class QkanMessageList {
  private static QkanMessageList singleton;
  /**
   * �R���X�g���N�^�ł��B
   * singleton pattern
   */
  private QkanMessageList() {
  }
  /**
   * �C���X�^���X��Ԃ��܂��B
   * @return �C���X�^���X
   */
  public static QkanMessageList getInstance(){
    if(singleton==null){
      singleton = new QkanMessageList();
    }
    return singleton;
  }

  /**
   * ���b�Z�[�W�u���͓��e��o�^���܂����H�v��\�����܂��B
   * <p>
   * �߂�{�^��������
   * �o�^���[�h
   * �X�i�b�v�V���b�g�`�F�b�N�Ɉ������������ꍇ
   * </p>
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int WARNING_OF_INSERT_ON_MODIFIED() throws Exception{

    return ACMessageBox.showYesNoCancel("���͓��e��o�^���܂����H", "�o�^���Ė߂�(I)", 'I', "�j�����Ė߂�(R)", 'R', ACMessageBox.FOCUS_CANCEL);

  }

  /**
   * ���b�Z�[�W�u�ύX����Ă��܂��B�����s���X�V���܂����H�v��\�����܂��B
   * <p>
   * �߂�{�^��������
   * �X�V���[�h
   * �X�i�b�v�V���b�g�`�F�b�N�Ɉ������������ꍇ
   * </p>
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int WARNING_OF_UPDATE_ON_MODIFIED() throws Exception{

    return ACMessageBox.showYesNoCancel("�ύX����Ă��܂��B" + ACConstants.LINE_SEPARATOR + "�X�V���܂����H", "�X�V���Ė߂�(U)", 'U', "�j�����Ė߂�(R)", 'R', ACMessageBox.FOCUS_CANCEL);

  }

  /**
   * ���b�Z�[�W�u�ύX���ꂽ���e�͔j������܂��B�����s���I�����Ă���낵���ł����H�v��\�����܂��B
   * <p>
   * �~�{�^��������
   * �X�i�b�v�V���b�g�`�F�b�N�Ɉ������������ꍇ
   * </p>
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int WARNING_OF_CLOSE_ON_MODIFIED() throws Exception{

    return ACMessageBox.show("�ύX���ꂽ���e�͔j������܂��B" + ACConstants.LINE_SEPARATOR + "�I�����Ă���낵���ł����H", ACMessageBox.BUTTON_OK | ACMessageBox.BUTTON_CANCEL, ACMessageBox.ICON_QUESTION, ACMessageBox.FOCUS_CANCEL);

  }

  /**
   * ���b�Z�[�W�u�����ɓ����f�[�^��ҏW���悤�Ƃ��܂����B�����s���Ó����m�ۂׁ̈A�����𒆎~���܂��B�v��\�����܂��B
   * <p>
   * �p�b�V�u�`�F�b�N�ŃG���[�����������ꍇ
   * </p>
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int ERROR_OF_PASSIVE_CHECK_ON_UPDATE() throws Exception{

    return ACMessageBox.show("�����ɓ����f�[�^��ҏW���悤�Ƃ��܂����B" + ACConstants.LINE_SEPARATOR + "�Ó����m�ۂׁ̈A�����𒆎~���܂��B", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * ���b�Z�[�W�u[���ږ�]����͂��Ă��������B�v��\�����܂��B
   * <p>
   * ���̓`�F�b�N
   * �K�{���͍��ڂ������͂̏ꍇ
   * [���ږ�]�͍��ږ�
   * �@��[���ږ�] = ���p�Ҏ���
   * </p>
   * @param param �p�����^
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int ERROR_OF_NEED_CHECK_FOR_INPUT(VRMap param) throws Exception {
    return ERROR_OF_NEED_CHECK_FOR_INPUT(

      VRBindPathParser.get("���ږ�", param)

           );
  }
  /**
   * ���b�Z�[�W�u[���ږ�]����͂��Ă��������B�v��\�����܂��B
   * <p>
   * ���̓`�F�b�N
   * �K�{���͍��ڂ������͂̏ꍇ
   * [���ږ�]�͍��ږ�
   * �@��[���ږ�] = ���p�Ҏ���
   * </p>
   * @param arg1 ���ږ�
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int ERROR_OF_NEED_CHECK_FOR_INPUT(

      Object arg1
                        ) throws Exception{
    StringBuffer sb = new StringBuffer();

    sb.append(arg1);

    sb.append("����͂��Ă��������B");

    return ACMessageBox.show(sb.toString(), ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * ���b�Z�[�W�u[���ږ�]��I�����Ă��������B�v��\�����܂��B
   * <p>
   * ���̓`�F�b�N
   * �K�{�I�����ڂ����I���̏ꍇ
   * [���ږ�]�͍��ږ�
   * �@��[���ږ�] = �v���F��
   * </p>
   * @param param �p�����^
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int ERROR_OF_NEED_CHECK_FOR_SELECT(VRMap param) throws Exception {
    return ERROR_OF_NEED_CHECK_FOR_SELECT(

      VRBindPathParser.get("���ږ�", param)

           );
  }
  /**
   * ���b�Z�[�W�u[���ږ�]��I�����Ă��������B�v��\�����܂��B
   * <p>
   * ���̓`�F�b�N
   * �K�{�I�����ڂ����I���̏ꍇ
   * [���ږ�]�͍��ږ�
   * �@��[���ږ�] = �v���F��
   * </p>
   * @param arg1 ���ږ�
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int ERROR_OF_NEED_CHECK_FOR_SELECT(

      Object arg1
                        ) throws Exception{
    StringBuffer sb = new StringBuffer();

    sb.append(arg1);

    sb.append("��I�����Ă��������B");

    return ACMessageBox.show(sb.toString(), ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * ���b�Z�[�W�u[���ږ�]���t�Ɍ�肪����܂��B�v��\�����܂��B
   * <p>
   * ���̓`�F�b�N
   * ���t���ڂɕs���Ȓl�����͂���Ă���ꍇ
   * [���ږ�]�͍��ږ���\������ꍇ�Ɏg�p
   * �@����F[���ږ�] = ���N������
   * </p>
   * @param param �p�����^
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int ERROR_OF_WRONG_DATE(VRMap param) throws Exception {
    return ERROR_OF_WRONG_DATE(

      VRBindPathParser.get("���ږ�", param)

           );
  }
  /**
   * ���b�Z�[�W�u[���ږ�]���t�Ɍ�肪����܂��B�v��\�����܂��B
   * <p>
   * ���̓`�F�b�N
   * ���t���ڂɕs���Ȓl�����͂���Ă���ꍇ
   * [���ږ�]�͍��ږ���\������ꍇ�Ɏg�p
   * �@����F[���ږ�] = ���N������
   * </p>
   * @param arg1 ���ږ�
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int ERROR_OF_WRONG_DATE(

      Object arg1
                        ) throws Exception{
    StringBuffer sb = new StringBuffer();

    sb.append(arg1);

    sb.append("���t�Ɍ�肪����܂��B");

    return ACMessageBox.show(sb.toString(), ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * ���b�Z�[�W�u[���ږ�]�����̓��t�����͂���Ă��܂��B�v��\�����܂��B
   * <p>
   * ���̓`�F�b�N
   * �������t���֎~����Ă�����t���ڂɁA�������t�����͂���Ă���ꍇ
   * �@����F[���ږ�] = �쐬�N������
   * </p>
   * @param param �p�����^
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int ERROR_OF_FUTURE_DATE(VRMap param) throws Exception {
    return ERROR_OF_FUTURE_DATE(

      VRBindPathParser.get("���ږ�", param)

           );
  }
  /**
   * ���b�Z�[�W�u[���ږ�]�����̓��t�����͂���Ă��܂��B�v��\�����܂��B
   * <p>
   * ���̓`�F�b�N
   * �������t���֎~����Ă�����t���ڂɁA�������t�����͂���Ă���ꍇ
   * �@����F[���ږ�] = �쐬�N������
   * </p>
   * @param arg1 ���ږ�
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int ERROR_OF_FUTURE_DATE(

      Object arg1
                        ) throws Exception{
    StringBuffer sb = new StringBuffer();

    sb.append(arg1);

    sb.append("�����̓��t�����͂���Ă��܂��B");

    return ACMessageBox.show(sb.toString(), ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * ���b�Z�[�W�u[���ږ�][�J�n��] �� [�I����] �Ƃ��Ă��������B�v��\�����܂��B
   * <p>
   * ���̓`�F�b�N
   * ���t���ڂ̑O��֌W������Ă���ꍇ
   * [���ږ�]�͍��ږ���\������ꍇ�Ɏg�p
   * �@����F[���ږ�] = �L�����Ԃ�
   * �@�@�@�@�@[�J�n��] = �J�n
   * �@�@�@�@�@[�I����] = �I��
   * </p>
   * @param param �p�����^
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int ERROR_OF_GREATER_DATE_RELATION(VRMap param) throws Exception {
    return ERROR_OF_GREATER_DATE_RELATION(

      VRBindPathParser.get("���ږ�", param)

      , VRBindPathParser.get("�J�n��", param)

      , VRBindPathParser.get("�I����", param)

           );
  }
  /**
   * ���b�Z�[�W�u[���ږ�][�J�n��] �� [�I����] �Ƃ��Ă��������B�v��\�����܂��B
   * <p>
   * ���̓`�F�b�N
   * ���t���ڂ̑O��֌W������Ă���ꍇ
   * [���ږ�]�͍��ږ���\������ꍇ�Ɏg�p
   * �@����F[���ږ�] = �L�����Ԃ�
   * �@�@�@�@�@[�J�n��] = �J�n
   * �@�@�@�@�@[�I����] = �I��
   * </p>
   * @param arg1 ���ږ�
   * @param arg2 �J�n��
   * @param arg3 �I����
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int ERROR_OF_GREATER_DATE_RELATION(

      Object arg1
      , Object arg2
      , Object arg3
                        ) throws Exception{
    StringBuffer sb = new StringBuffer();

    sb.append(arg1);

    sb.append(arg2);

    sb.append(" �� ");

    sb.append(arg3);

    sb.append(" �Ƃ��Ă��������B");

    return ACMessageBox.show(sb.toString(), ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * ���b�Z�[�W�u[���ږ�][�J�n��] �� [�I����] �Ƃ��Ă��������B�v��\�����܂��B
   * <p>
   * ���̓`�F�b�N
   * ���t���ڂ̑O��֌W������Ă���ꍇ
   * %S%�͍��ږ���\������ꍇ�Ɏg�p
   * �@����F
   * </p>
   * @param param �p�����^
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int ERROR_OF_LESSER_DATE_RELATION(VRMap param) throws Exception {
    return ERROR_OF_LESSER_DATE_RELATION(

      VRBindPathParser.get("���ږ�", param)

      , VRBindPathParser.get("�J�n��", param)

      , VRBindPathParser.get("�I����", param)

           );
  }
  /**
   * ���b�Z�[�W�u[���ږ�][�J�n��] �� [�I����] �Ƃ��Ă��������B�v��\�����܂��B
   * <p>
   * ���̓`�F�b�N
   * ���t���ڂ̑O��֌W������Ă���ꍇ
   * %S%�͍��ږ���\������ꍇ�Ɏg�p
   * �@����F
   * </p>
   * @param arg1 ���ږ�
   * @param arg2 �J�n��
   * @param arg3 �I����
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int ERROR_OF_LESSER_DATE_RELATION(

      Object arg1
      , Object arg2
      , Object arg3
                        ) throws Exception{
    StringBuffer sb = new StringBuffer();

    sb.append(arg1);

    sb.append(arg2);

    sb.append(" �� ");

    sb.append(arg3);

    sb.append(" �Ƃ��Ă��������B");

    return ACMessageBox.show(sb.toString(), ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * ���b�Z�[�W�u����Ǝv����[���ږ�]�����ɓo�^����Ă��܂��B�����s���o�^���܂����H�v��\�����܂��B
   * <p>
   * �ۑ��O�̊m�F
   * ����̃f�[�^�̓o�^�͋������A�O�̂��ߊm�F����ꍇ
   * �@����F%S% = ���p��
   * </p>
   * @param param �p�����^
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int WARNING_OF_SAME_DATA_FOUND(VRMap param) throws Exception {
    return WARNING_OF_SAME_DATA_FOUND(

      VRBindPathParser.get("���ږ�", param)

           );
  }
  /**
   * ���b�Z�[�W�u����Ǝv����[���ږ�]�����ɓo�^����Ă��܂��B�����s���o�^���܂����H�v��\�����܂��B
   * <p>
   * �ۑ��O�̊m�F
   * ����̃f�[�^�̓o�^�͋������A�O�̂��ߊm�F����ꍇ
   * �@����F%S% = ���p��
   * </p>
   * @param arg1 ���ږ�
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int WARNING_OF_SAME_DATA_FOUND(

      Object arg1
                        ) throws Exception{
    StringBuffer sb = new StringBuffer();

    sb.append("����Ǝv����");

    sb.append(arg1);

    sb.append("�����ɓo�^����Ă��܂��B" + ACConstants.LINE_SEPARATOR + "�o�^���܂����H");

    return ACMessageBox.show(sb.toString(), ACMessageBox.BUTTON_OK | ACMessageBox.BUTTON_CANCEL, ACMessageBox.ICON_QUESTION, ACMessageBox.FOCUS_CANCEL);

  }

  /**
   * ���b�Z�[�W�u�����[���ږ�]�����ɓo�^����Ă��܂��B�v��\�����܂��B
   * <p>
   * �ۑ��O�̊m�F
   * ����̃f�[�^�̓o�^�������Ȃ��ꍇ
   * �@����F%S% = �ی���
   * </p>
   * @param param �p�����^
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int ERROR_OF_SAME_DATA_FOUND(VRMap param) throws Exception {
    return ERROR_OF_SAME_DATA_FOUND(

      VRBindPathParser.get("���ږ�", param)

           );
  }
  /**
   * ���b�Z�[�W�u�����[���ږ�]�����ɓo�^����Ă��܂��B�v��\�����܂��B
   * <p>
   * �ۑ��O�̊m�F
   * ����̃f�[�^�̓o�^�������Ȃ��ꍇ
   * �@����F%S% = �ی���
   * </p>
   * @param arg1 ���ږ�
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int ERROR_OF_SAME_DATA_FOUND(

      Object arg1
                        ) throws Exception{
    StringBuffer sb = new StringBuffer();

    sb.append("�����");

    sb.append(arg1);

    sb.append("�����ɓo�^����Ă��܂��B");

    return ACMessageBox.show(sb.toString(), ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * ���b�Z�[�W�u�I�������f�[�^���폜���܂��B�����s����낵���ł����H�v��\�����܂��B
   * <p>
   * �폜�O�̊m�F
   * �폜�O�Ƀ��b�Z�[�W���o�����Ƃ͕K�{
   * </p>
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int WARNING_OF_DELETE_SELECTION() throws Exception{

    return ACMessageBox.show("�I�������f�[�^���폜���܂��B" + ACConstants.LINE_SEPARATOR + "��낵���ł����H", ACMessageBox.BUTTON_OK | ACMessageBox.BUTTON_CANCEL, ACMessageBox.ICON_QUESTION, ACMessageBox.FOCUS_CANCEL);

  }

  /**
   * ���b�Z�[�W�u[���ږ�]���폜���܂��B�����s����낵���ł����H�v��\�����܂��B
   * <p>
   * �폜�O�̊m�F
   * �폜�O�Ƀ��b�Z�[�W���o�����Ƃ͕K�{
   * </p>
   * @param param �p�����^
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int WARNING_OF_DELETE(VRMap param) throws Exception {
    return WARNING_OF_DELETE(

      VRBindPathParser.get("���ږ�", param)

           );
  }
  /**
   * ���b�Z�[�W�u[���ږ�]���폜���܂��B�����s����낵���ł����H�v��\�����܂��B
   * <p>
   * �폜�O�̊m�F
   * �폜�O�Ƀ��b�Z�[�W���o�����Ƃ͕K�{
   * </p>
   * @param arg1 ���ږ�
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int WARNING_OF_DELETE(

      Object arg1
                        ) throws Exception{
    StringBuffer sb = new StringBuffer();

    sb.append(arg1);

    sb.append("���폜���܂��B" + ACConstants.LINE_SEPARATOR + "��낵���ł����H");

    return ACMessageBox.show(sb.toString(), ACMessageBox.BUTTON_OK | ACMessageBox.BUTTON_CANCEL, ACMessageBox.ICON_QUESTION, ACMessageBox.FOCUS_CANCEL);

  }

  /**
   * ���b�Z�[�W�u�I�������f�[�^��������܂��B�����s����낵���ł����H�v��\�����܂��B
   * <p>
   * ����O�̊m�F
   * ����O�Ƀ��b�Z�[�W���o�����Ƃ͔C��
   * </p>
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int WARNING_OF_PRINT_SELECTION() throws Exception{

    return ACMessageBox.show("�I�������f�[�^��������܂��B" + ACConstants.LINE_SEPARATOR + "��낵���ł����H", ACMessageBox.BUTTON_OK | ACMessageBox.BUTTON_CANCEL, ACMessageBox.ICON_QUESTION, ACMessageBox.FOCUS_CANCEL);

  }

  /**
   * ���b�Z�[�W�u[���ږ�]��������܂��B�����s����낵���ł����H�v��\�����܂��B
   * <p>
   * ����O�̊m�F
   * ����O�Ƀ��b�Z�[�W���o�����Ƃ͔C��
   * </p>
   * @param param �p�����^
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int WARNING_OF_PRINT(VRMap param) throws Exception {
    return WARNING_OF_PRINT(

      VRBindPathParser.get("���ږ�", param)

           );
  }
  /**
   * ���b�Z�[�W�u[���ږ�]��������܂��B�����s����낵���ł����H�v��\�����܂��B
   * <p>
   * ����O�̊m�F
   * ����O�Ƀ��b�Z�[�W���o�����Ƃ͔C��
   * </p>
   * @param arg1 ���ږ�
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int WARNING_OF_PRINT(

      Object arg1
                        ) throws Exception{
    StringBuffer sb = new StringBuffer();

    sb.append(arg1);

    sb.append("��������܂��B" + ACConstants.LINE_SEPARATOR + "��낵���ł����H");

    return ACMessageBox.show(sb.toString(), ACMessageBox.BUTTON_OK | ACMessageBox.BUTTON_CANCEL, ACMessageBox.ICON_QUESTION, ACMessageBox.FOCUS_CANCEL);

  }

  /**
   * ���b�Z�[�W�u�o�^���܂����B�v��\�����܂��B
   * <p>
   * ���������ʒm
   * �o�^(INSERT)������I�������ꍇ
   * </p>
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int INSERT_SUCCESSED() throws Exception{

    return ACMessageBox.show("�o�^���܂����B", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_INFOMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * ���b�Z�[�W�u�X�V���܂����B�v��\�����܂��B
   * <p>
   * ���������ʒm
   * �X�V(UPDATE)������I�������ꍇ
   * </p>
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int UPDATE_SUCCESSED() throws Exception{

    return ACMessageBox.show("�X�V���܂����B", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_INFOMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * ���b�Z�[�W�u�폜���܂����B�v��\�����܂��B
   * <p>
   * ���������ʒm
   * �폜(DELTE)������I�������ꍇ
   * </p>
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int DELETE_SUCCESSED() throws Exception{

    return ACMessageBox.show("�폜���܂����B", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_INFOMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * ���b�Z�[�W�u�����ɍ��v����u[���ږ�]�v��������܂���ł����B�v��\�����܂��B
   * <p>
   * �����Ɩ�
   * �������ʂ�0���̏ꍇ
   * </p>
   * @param param �p�����^
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int NOT_FOUND(VRMap param) throws Exception {
    return NOT_FOUND(

      VRBindPathParser.get("���ږ�", param)

           );
  }
  /**
   * ���b�Z�[�W�u�����ɍ��v����u[���ږ�]�v��������܂���ł����B�v��\�����܂��B
   * <p>
   * �����Ɩ�
   * �������ʂ�0���̏ꍇ
   * </p>
   * @param arg1 ���ږ�
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int NOT_FOUND(

      Object arg1
                        ) throws Exception{
    StringBuffer sb = new StringBuffer();

    sb.append("�����ɍ��v����u");

    sb.append(arg1);

    sb.append("�v��������܂���ł����B");

    return ACMessageBox.show(sb.toString(), ACMessageBox.BUTTON_OK, ACMessageBox.ICON_INFOMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * ���b�Z�[�W�u�����������ύX����Ă��܂��B�����s�����������ɖ߂����A�ēx�������Ă��������B�v��\�����܂��B
   * <p>
   * ���������ƌ������ʂ�1��ʓ��ɂ��錟���Ɩ�
   * ������A���������݂̂�ύX���Ĉ�����悤�Ƃ����ꍇ
   * �i�\������Ă�������ƁA�\������Ă��錋�ʂ��قȂ�ꍇ�j
   * </p>
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int ERROR_OF_FIND_CONDITION_ON_MODIFIED() throws Exception{

    return ACMessageBox.show("�����������ύX����Ă��܂��B" + ACConstants.LINE_SEPARATOR + "���������ɖ߂����A�ēx�������Ă��������B", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * ���b�Z�[�W�u[���ږ�]�������m�肳���܂����H�v��\�����܂��B
   * <p>
   * �����A�t���O�𗧂Ă�ꍇ
   * �@����F���
   * �@����FCSV�쐬
   * </p>
   * @param param �p�����^
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int WARNING_OF_DECISION_HISTORY(VRMap param) throws Exception {
    return WARNING_OF_DECISION_HISTORY(

      VRBindPathParser.get("���ږ�", param)

           );
  }
  /**
   * ���b�Z�[�W�u[���ږ�]�������m�肳���܂����H�v��\�����܂��B
   * <p>
   * �����A�t���O�𗧂Ă�ꍇ
   * �@����F���
   * �@����FCSV�쐬
   * </p>
   * @param arg1 ���ږ�
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int WARNING_OF_DECISION_HISTORY(

      Object arg1
                        ) throws Exception{
    StringBuffer sb = new StringBuffer();

    sb.append(arg1);

    sb.append("�������m�肳���܂����H");

    return ACMessageBox.show(sb.toString(), ACMessageBox.BUTTON_OK | ACMessageBox.BUTTON_CANCEL, ACMessageBox.ICON_QUESTION, ACMessageBox.FOCUS_CANCEL);

  }

  /**
   * ���b�Z�[�W�u�����ɓ����f�[�^���폜���悤�Ƃ��܂����B�����s���Ó����m�ۂׁ̈A�����𒆎~���܂��B�v��\�����܂��B
   * <p>
   * ��ʑJ�ڎ��ɊY�����R�[�h���擾�ł��Ȃ������ꍇ
   * </p>
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int ERROR_OF_PASSIVE_CHECK_ON_FIND() throws Exception{

    return ACMessageBox.show("�����ɓ����f�[�^���폜���悤�Ƃ��܂����B" + ACConstants.LINE_SEPARATOR + "�Ó����m�ۂׁ̈A�����𒆎~���܂��B", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * ���b�Z�[�W�u�I�𒆂̗��p�ҁ@[���ږ�]���폜���܂����H�v��\�����܂��B
   * 
   * @param param �p�����^
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int QU001_WARNING_ON_DELETE_OF_SELECTED_PATIENT(VRMap param) throws Exception {
    return QU001_WARNING_ON_DELETE_OF_SELECTED_PATIENT(

      VRBindPathParser.get("���ږ�", param)

           );
  }
  /**
   * ���b�Z�[�W�u�I�𒆂̗��p�ҁ@[���ږ�]���폜���܂����H�v��\�����܂��B
   * 
   * @param arg1 ���ږ�
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int QU001_WARNING_ON_DELETE_OF_SELECTED_PATIENT(

      Object arg1
                        ) throws Exception{
    StringBuffer sb = new StringBuffer();

    sb.append("�I�𒆂̗��p�ҁ@");

    sb.append(arg1);

    sb.append("���폜���܂����H");

    return ACMessageBox.show(sb.toString(), ACMessageBox.BUTTON_OK | ACMessageBox.BUTTON_CANCEL, ACMessageBox.ICON_QUESTION, ACMessageBox.FOCUS_CANCEL);

  }

  /**
   * ���b�Z�[�W�u���ݕ\������Ă��闘�p�҂̈ꗗ�\��������܂��B�����s����낵���ł����H�v��\�����܂��B
   * 
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int QU001_WARNING_ON_PRINT_OF_PATIENT() throws Exception{

    return ACMessageBox.show("���ݕ\������Ă��闘�p�҂̈ꗗ�\��������܂��B" + ACConstants.LINE_SEPARATOR + "��낵���ł����H", ACMessageBox.BUTTON_OK | ACMessageBox.BUTTON_CANCEL, ACMessageBox.ICON_QUESTION, ACMessageBox.FOCUS_CANCEL);

  }

  /**
   * ���b�Z�[�W�u�v���x�̗L�����Ԃ��؂�Ă��邩�A�o�^����Ă��܂���B�����s���L�����ԊO�̃T�[�r�X�͏W�v�ł��܂���B�����s���V�����v���x�����܂��Ă���΁A���p�ҏ��ڍ׉�ʂœo�^���Ă��������B�v��\�����܂��B
   * <p>
   * ���p�҈ꗗ��ʂ���T�[�r�X�\��/���щ�ʂɑJ�ڂ���ۂɁA���ԓ��̗v���x���Ȃ���Ε\���B
   * </p>
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int QU001_HAS_NO_YOKAIGODO() throws Exception{

    return ACMessageBox.show("�v���x�̗L�����Ԃ��؂�Ă��邩�A�o�^����Ă��܂���B" + ACConstants.LINE_SEPARATOR + "�L�����ԊO�̃T�[�r�X�͏W�v�ł��܂���B" + ACConstants.LINE_SEPARATOR + "�V�����v���x�����܂��Ă���΁A���p�ҏ��ڍ׉�ʂœo�^���Ă��������B", ACMessageBox.BUTTON_OK | ACMessageBox.BUTTON_CANCEL, ACMessageBox.ICON_QUESTION, ACMessageBox.FOCUS_CANCEL);

  }

  /**
   * ���b�Z�[�W�u[S]��[I]��ڂ���͂��Ă��������B�v��\�����܂��B
   * 
   * @param param �p�����^
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int QP005_ERROR_ON_NEED_CHECK_OF_INPUT(VRMap param) throws Exception {
    return QP005_ERROR_ON_NEED_CHECK_OF_INPUT(

      VRBindPathParser.get("S", param)

      , VRBindPathParser.get("I", param)

           );
  }
  /**
   * ���b�Z�[�W�u[S]��[I]��ڂ���͂��Ă��������B�v��\�����܂��B
   * 
   * @param arg1 S
   * @param arg2 I
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int QP005_ERROR_ON_NEED_CHECK_OF_INPUT(

      Object arg1
      , Object arg2
                        ) throws Exception{
    StringBuffer sb = new StringBuffer();

    sb.append(arg1);

    sb.append("��");

    sb.append(arg2);

    sb.append("��ڂ���͂��Ă��������B");

    return ACMessageBox.show(sb.toString(), ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * ���b�Z�[�W�u�ۑ�����Ă���f�[�^�̒��ŁA�ŐV�̃f�[�^��ǂݍ��݂܂��B�����s���i���ݓ��͂���Ă���f�[�^�͏����Ă��܂��܂��B�j�����s����낵���ł����H�v��\�����܂��B
   * <p>
   * �ŐV�̉ߋ��f�[�^��ǂݍ��ލۂ̊m�F���b�Z�[�W�B
   * </p>
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int QC001_WARNING_ON_READ_OF_MOST_NEW_DATA() throws Exception{

    return ACMessageBox.show("�ۑ�����Ă���f�[�^�̒��ŁA�ŐV�̃f�[�^��ǂݍ��݂܂��B" + ACConstants.LINE_SEPARATOR + "�i���ݓ��͂���Ă���f�[�^�͏����Ă��܂��܂��B�j" + ACConstants.LINE_SEPARATOR + "��낵���ł����H", ACMessageBox.BUTTON_OK | ACMessageBox.BUTTON_CANCEL, ACMessageBox.ICON_QUESTION, ACMessageBox.FOCUS_CANCEL);

  }

  /**
   * ���b�Z�[�W�u�ߋ��̃f�[�^�����݂��܂���ł����B�����s���Ǎ������͍s���܂���B�v��\�����܂��B
   * <p>
   * �ŐV�̉ߋ��f�[�^��ǂݍ������Ƃ������A�ߋ��f�[�^�����݂��Ȃ������ꍇ�B
   * </p>
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int QC001_NOTICE_HAS_NO_LAST_DATA() throws Exception{

    return ACMessageBox.show("�ߋ��̃f�[�^�����݂��܂���ł����B" + ACConstants.LINE_SEPARATOR + "�Ǎ������͍s���܂���B", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_INFOMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * ���b�Z�[�W�u���׏��Ɉ󎚂ł������͍ő�[num]���̂��߁A���꒠�[�l���́����s���T�[�r�X�ɂ����������A�Ђƌ���[num]���܂łƂ��Ă��������B�v��\�����܂��B
   * <p>
   * �������ɁA���꒠�[�l���̃T�[�r�X��I�����Ă��������4���ȏ�i��ÂȂ�3���ȏ�j����ꍇ�B
   * �������F��num���@3��
   * </p>
   * @param param �p�����^
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int QU004_ERROR_ON_KOHI_OVER_LIMIT(VRMap param) throws Exception {
    return QU004_ERROR_ON_KOHI_OVER_LIMIT(

      VRBindPathParser.get("num", param)

           );
  }
  /**
   * ���b�Z�[�W�u���׏��Ɉ󎚂ł������͍ő�[num]���̂��߁A���꒠�[�l���́����s���T�[�r�X�ɂ����������A�Ђƌ���[num]���܂łƂ��Ă��������B�v��\�����܂��B
   * <p>
   * �������ɁA���꒠�[�l���̃T�[�r�X��I�����Ă��������4���ȏ�i��ÂȂ�3���ȏ�j����ꍇ�B
   * �������F��num���@3��
   * </p>
   * @param arg1 num
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int QU004_ERROR_ON_KOHI_OVER_LIMIT(

      Object arg1
                        ) throws Exception{
    StringBuffer sb = new StringBuffer();

    sb.append("���׏��Ɉ󎚂ł������͍ő�");

    sb.append(arg1);

    sb.append("���̂��߁A���꒠�[�l����" + ACConstants.LINE_SEPARATOR + "�T�[�r�X�ɂ����������A�Ђƌ���");

    sb.append(arg1);

    sb.append("���܂łƂ��Ă��������B");

    return ACMessageBox.show(sb.toString(), ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * ���b�Z�[�W�u�L�����Ԃ��A�o�^����Ă���[target]�̗L�����ԂƏd�Ȃ��Ă��܂��B�����s���d�Ȃ��Ă���[target]�̗L�����ԏI������ύX���Ă���낵���ł����H�v��\�����܂��B
   * <p>
   * [target]�̗L�����Ԃ��d�������ꍇ�ɕ\������BOK���I�����ꂽ�ꍇ�A�d�Ȃ��Ă���[target]�̗L�����ԏI�������A�o�^���悤�Ƃ��Ă���[target]�̗L�����ԊJ�n���̑O���ɐݒ肷��B
   * </p>
   * @param param �p�����^
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int WARNING_OF_DUPLICATE_TERM(VRMap param) throws Exception {
    return WARNING_OF_DUPLICATE_TERM(

      VRBindPathParser.get("target", param)

           );
  }
  /**
   * ���b�Z�[�W�u�L�����Ԃ��A�o�^����Ă���[target]�̗L�����ԂƏd�Ȃ��Ă��܂��B�����s���d�Ȃ��Ă���[target]�̗L�����ԏI������ύX���Ă���낵���ł����H�v��\�����܂��B
   * <p>
   * [target]�̗L�����Ԃ��d�������ꍇ�ɕ\������BOK���I�����ꂽ�ꍇ�A�d�Ȃ��Ă���[target]�̗L�����ԏI�������A�o�^���悤�Ƃ��Ă���[target]�̗L�����ԊJ�n���̑O���ɐݒ肷��B
   * </p>
   * @param arg1 target
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int WARNING_OF_DUPLICATE_TERM(

      Object arg1
                        ) throws Exception{
    StringBuffer sb = new StringBuffer();

    sb.append("�L�����Ԃ��A�o�^����Ă���");

    sb.append(arg1);

    sb.append("�̗L�����ԂƏd�Ȃ��Ă��܂��B" + ACConstants.LINE_SEPARATOR + "�d�Ȃ��Ă���");

    sb.append(arg1);

    sb.append("�̗L�����ԏI������ύX���Ă���낵���ł����H");

    return ACMessageBox.show(sb.toString(), ACMessageBox.BUTTON_OK | ACMessageBox.BUTTON_CANCEL, ACMessageBox.ICON_QUESTION, ACMessageBox.FOCUS_CANCEL);

  }

  /**
   * ���b�Z�[�W�u�L�����Ԃ��A�o�^����Ă����Õی��̗L�����ԂƏd�Ȃ��Ă��܂��B�v��\�����܂��B
   * <p>
   * ��Õی��̗L�����Ԃ��d�������ꍇ�B
   * </p>
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int QU003_ERROR_OF_DUPLICATE_IRYO() throws Exception{

    return ACMessageBox.show("�L�����Ԃ��A�o�^����Ă����Õی��̗L�����ԂƏd�Ȃ��Ă��܂��B", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * ���b�Z�[�W�u������Ƀ`�F�b�N�����Ă��܂���B�����s���\������Ă���S�Ă̒��[��������܂����H�v��\�����܂��B
   * <p>
   * ���p�҈ꗗ�Ƀ`�F�b�N�������Ɉ���{�^�����������ꂽ�ꍇ�B
   * </p>
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int QP001_WARGNING_PRINT() throws Exception{

    return ACMessageBox.show("������Ƀ`�F�b�N�����Ă��܂���B" + ACConstants.LINE_SEPARATOR + "�\������Ă���S�Ă̒��[��������܂����H", ACMessageBox.BUTTON_OK | ACMessageBox.BUTTON_CANCEL, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * ���b�Z�[�W�u�W�v���Ƀ`�F�b�N�̂��Ă��闘�p�҂̎��т��m�肵�A�W�v�������s�Ȃ��܂��B�v��\�����܂��B
   * 
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int QP001_CONFIRMATION_PRINT() throws Exception{

    return ACMessageBox.show("�W�v���Ƀ`�F�b�N�̂��Ă��闘�p�҂̎��т��m�肵�A�W�v�������s�Ȃ��܂��B", ACMessageBox.BUTTON_OK | ACMessageBox.BUTTON_CANCEL, ACMessageBox.ICON_INFOMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * ���b�Z�[�W�u�W�v���I�����܂����B�v��\�����܂��B
   * <p>
   * ���яW�v�������ɕ\�����郁�b�Z�[�W
   * </p>
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int QP001_INSERT_SUCCESSED() throws Exception{

    return ACMessageBox.show("�W�v���I�����܂����B", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_INFOMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * ���b�Z�[�W�u�L�����Ԃ��A�o�^����Ă���x�����x�z�̗L�����ԂƏd�Ȃ��Ă��܂��B�v��\�����܂��B
   * <p>
   * �x�����x�z�̗L�����Ԃ��d�������ꍇ
   * </p>
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int QO002_ERROR_OF_DUPLICATE_LIMIT_RATE() throws Exception{

    return ACMessageBox.show("�L�����Ԃ��A�o�^����Ă���x�����x�z�̗L�����ԂƏd�Ȃ��Ă��܂��B", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * ���b�Z�[�W�u����������m�肵�܂����H�v��\�����܂��B
   * 
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int QP001_PRINT_COMMIT() throws Exception{

    return ACMessageBox.show("����������m�肵�܂����H", ACMessageBox.BUTTON_YES | ACMessageBox.BUTTON_NO, ACMessageBox.ICON_QUESTION, ACMessageBox.FOCUS_YES);

  }

  /**
   * ���b�Z�[�W�u�X�V���܂����H�v��\�����܂��B
   * <p>
   * DB�o�^���̊m�F���b�Z�[�W�B
   * </p>
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int QP005_WARNING_OF_UPDATE() throws Exception{

    return ACMessageBox.show("�X�V���܂����H", ACMessageBox.BUTTON_OK | ACMessageBox.BUTTON_CANCEL, ACMessageBox.ICON_QUESTION, ACMessageBox.FOCUS_OK);

  }

  /**
   * ���b�Z�[�W�u[S]([I])�̐������܂��͗̎������o�͂��܂����H�v��\�����܂��B
   * <p>
   * ���p�Ґ������o�͂��鎖�Ǝ҂̊m�F���b�Z�[�W
   * </p>
   * @param param �p�����^
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int QP001_PROVIDER_CHECK(VRMap param) throws Exception {
    return QP001_PROVIDER_CHECK(

      VRBindPathParser.get("S", param)

      , VRBindPathParser.get("I", param)

           );
  }
  /**
   * ���b�Z�[�W�u[S]([I])�̐������܂��͗̎������o�͂��܂����H�v��\�����܂��B
   * <p>
   * ���p�Ґ������o�͂��鎖�Ǝ҂̊m�F���b�Z�[�W
   * </p>
   * @param arg1 S
   * @param arg2 I
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int QP001_PROVIDER_CHECK(

      Object arg1
      , Object arg2
                        ) throws Exception{
    StringBuffer sb = new StringBuffer();

    sb.append(arg1);

    sb.append("(");

    sb.append(arg2);

    sb.append(")�̐������܂��͗̎������o�͂��܂����H");

    return ACMessageBox.show(sb.toString(), ACMessageBox.BUTTON_OK | ACMessageBox.BUTTON_CANCEL, ACMessageBox.ICON_QUESTION, ACMessageBox.FOCUS_OK);

  }

  /**
   * ���b�Z�[�W�u����Ώۂ̎��Ə����Ȃ����߈���𒆎~���܂����B�v��\�����܂��B
   * <p>
   * �o�͑Ώۂ̎��Ə����I������Ȃ������ꍇ�̃��b�Z�[�W
   * </p>
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int QP001_PROVIDER_NOSELECT() throws Exception{

    return ACMessageBox.show("����Ώۂ̎��Ə����Ȃ����߈���𒆎~���܂����B", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_INFOMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * ���b�Z�[�W�u���Ə� [S]([I]) �́����s��[S2]���̐�����CSV���쐬���܂��B�v��\�����܂��B
   * 
   * @param param �p�����^
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int QP001_CSV_PROVIDER_CHECK(VRMap param) throws Exception {
    return QP001_CSV_PROVIDER_CHECK(

      VRBindPathParser.get("S", param)

      , VRBindPathParser.get("I", param)

      , VRBindPathParser.get("S2", param)

           );
  }
  /**
   * ���b�Z�[�W�u���Ə� [S]([I]) �́����s��[S2]���̐�����CSV���쐬���܂��B�v��\�����܂��B
   * 
   * @param arg1 S
   * @param arg2 I
   * @param arg3 S2
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int QP001_CSV_PROVIDER_CHECK(

      Object arg1
      , Object arg2
      , Object arg3
                        ) throws Exception{
    StringBuffer sb = new StringBuffer();

    sb.append("���Ə� ");

    sb.append(arg1);

    sb.append("(");

    sb.append(arg2);

    sb.append(") ��" + ACConstants.LINE_SEPARATOR + "");

    sb.append(arg3);

    sb.append("���̐�����CSV���쐬���܂��B");

    return ACMessageBox.show(sb.toString(), ACMessageBox.BUTTON_OK | ACMessageBox.BUTTON_CANCEL, ACMessageBox.ICON_QUESTION, ACMessageBox.FOCUS_OK);

  }

  /**
   * ���b�Z�[�W�u�b�r�u�쐬���I�����܂����B�����s������������m�肵�܂����H�v��\�����܂��B
   * 
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int QP001_CSV_COMMIT() throws Exception{

    return ACMessageBox.show("�b�r�u�쐬���I�����܂����B" + ACConstants.LINE_SEPARATOR + "����������m�肵�܂����H", ACMessageBox.BUTTON_OK | ACMessageBox.BUTTON_CANCEL, ACMessageBox.ICON_QUESTION, ACMessageBox.FOCUS_OK);

  }

  /**
   * ���b�Z�[�W�u[S]�Ƃ��ēo�^����Ă��邽�ߍ폜�ł��܂���B�v��\�����܂��B
   * <p>
   * ���Ɩ��Ŏg�p����Ă��鎖�Ə���ی��҂��폜���悤�Ƃ����ꍇ�̃��b�Z�[�W
   * </p>
   * @param param �p�����^
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int ERROR_OF_DELETE_USED(VRMap param) throws Exception {
    return ERROR_OF_DELETE_USED(

      VRBindPathParser.get("S", param)

           );
  }
  /**
   * ���b�Z�[�W�u[S]�Ƃ��ēo�^����Ă��邽�ߍ폜�ł��܂���B�v��\�����܂��B
   * <p>
   * ���Ɩ��Ŏg�p����Ă��鎖�Ə���ی��҂��폜���悤�Ƃ����ꍇ�̃��b�Z�[�W
   * </p>
   * @param arg1 S
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int ERROR_OF_DELETE_USED(

      Object arg1
                        ) throws Exception{
    StringBuffer sb = new StringBuffer();

    sb.append(arg1);

    sb.append("�Ƃ��ēo�^����Ă��邽�ߍ폜�ł��܂���B");

    return ACMessageBox.show(sb.toString(), ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * ���b�Z�[�W�u���̃R���s���[�^�̃f�[�^�x�[�X���g�p���Ă���ꍇ�́A���̋@�\�𗘗p���邱�Ƃ��ł��܂���B�v��\�����܂��B
   * <p>
   * DB�ޔ�/�������A�T�[�o���ʂ̃R���s���[�^�������ꍇ�̃��b�Z�[�W
   * </p>
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int QO005_ERROR_OF_USER_OTHER_COMPUTER() throws Exception{

    return ACMessageBox.show("���̃R���s���[�^�̃f�[�^�x�[�X���g�p���Ă���ꍇ�́A���̋@�\�𗘗p���邱�Ƃ��ł��܂���B", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * ���b�Z�[�W�u�����ȃp�X���ł��B�����s��(�ޔ��̃t�@�C�������݂̃f�[�^�x�[�X�t�@�C���Ɠ����ł�)�v��\�����܂��B
   * <p>
   * DB�ޔ����A���ݎg�p����FDB�t�@�C����ޔ��Ƃ��Ďw�肵���ꍇ�̃��b�Z�[�W
   * </p>
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int QO005_ERROR_OF_BACKUP_SAME_TO_USED() throws Exception{

    return ACMessageBox.show("�����ȃp�X���ł��B" + ACConstants.LINE_SEPARATOR + "(�ޔ��̃t�@�C�������݂̃f�[�^�x�[�X�t�@�C���Ɠ����ł�)", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * ���b�Z�[�W�u�����ȃp�X���ł��B�����s��(�������̃t�@�C�������݂̃f�[�^�x�[�X�t�@�C���Ɠ����ł�)�v��\�����܂��B
   * <p>
   * DB�������A���ݎg�p����FDB�t�@�C���𕜌����Ƃ��Ďw�肵���ꍇ�̃��b�Z�[�W
   * </p>
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int QO005_ERROR_OF_RESTORE_SAME_TO_USED() throws Exception{

    return ACMessageBox.show("�����ȃp�X���ł��B" + ACConstants.LINE_SEPARATOR + "(�������̃t�@�C�������݂̃f�[�^�x�[�X�t�@�C���Ɠ����ł�)", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * ���b�Z�[�W�u�����ȃp�X���ł��B�����s��(�ޔ��̃t�@�C�����������t�@�C���Ɠ����ł�)�v��\�����܂��B
   * <p>
   * DB�������A�ޔ��FDB�����sFDB�̑ޔ��Ƃ��Ďw�肵���ꍇ�̃��b�Z�[�W
   * </p>
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int QO005_ERROR_OF_BACKUP_SAME_TO_RESTORE() throws Exception{

    return ACMessageBox.show("�����ȃp�X���ł��B" + ACConstants.LINE_SEPARATOR + "(�ޔ��̃t�@�C�����������t�@�C���Ɠ����ł�)", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * ���b�Z�[�W�u�������O�̃t�@�C�������݂��Ă��܂��B�����s���㏑���Ă���낵���ł����H�v��\�����܂��B
   * <p>
   * DB�ޔ�/�������A�w�肳�ꂽ�ޔ��t�@�C�������ɑ��݂���ꍇ�̃��b�Z�[�W
   * </p>
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int QO005_QUESTION_OF_EXIST_SELECTED_FDB() throws Exception{

    return ACMessageBox.show("�������O�̃t�@�C�������݂��Ă��܂��B" + ACConstants.LINE_SEPARATOR + "�㏑���Ă���낵���ł����H", ACMessageBox.BUTTON_OK | ACMessageBox.BUTTON_CANCEL, ACMessageBox.ICON_QUESTION, ACMessageBox.FOCUS_OK);

  }

  /**
   * ���b�Z�[�W�u�f�[�^�̑ޔ�(�o�b�N�A�b�v)�������J�n���܂��B�����s�����΂炭���Ԃ�������܂����A��낵���ł����H�v��\�����܂��B
   * <p>
   * DB�ޔ������J�n�m�F���b�Z�[�W
   * </p>
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int QO005_QUESTION_OF_TO_START_BACKUP() throws Exception{

    return ACMessageBox.show("�f�[�^�̑ޔ�(�o�b�N�A�b�v)�������J�n���܂��B" + ACConstants.LINE_SEPARATOR + "���΂炭���Ԃ�������܂����A��낵���ł����H", ACMessageBox.BUTTON_OK | ACMessageBox.BUTTON_CANCEL, ACMessageBox.ICON_QUESTION, ACMessageBox.FOCUS_OK);

  }

  /**
   * ���b�Z�[�W�u�f�[�^�̕���(���X�g�A)�������J�n���܂��B�����s�����΂炭���Ԃ�������܂����A��낵���ł����H�v��\�����܂��B
   * <p>
   * DB���������J�n�m�F���b�Z�[�W
   * </p>
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int QO005_QUESTION_OF_TO_START_RESTORE() throws Exception{

    return ACMessageBox.show("�f�[�^�̕���(���X�g�A)�������J�n���܂��B" + ACConstants.LINE_SEPARATOR + "���΂炭���Ԃ�������܂����A��낵���ł����H", ACMessageBox.BUTTON_OK | ACMessageBox.BUTTON_CANCEL, ACMessageBox.ICON_QUESTION, ACMessageBox.FOCUS_OK);

  }

  /**
   * ���b�Z�[�W�u�f�[�^�̑ޔ�(�o�b�N�A�b�v)���I�����܂����B�v��\�����܂��B
   * <p>
   * DB�ޔ����A�ޔ������ɐ��������ꍇ�̃��b�Z�[�W
   * </p>
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int QO005_BACKUP_SUCCESSED() throws Exception{

    return ACMessageBox.show("�f�[�^�̑ޔ�(�o�b�N�A�b�v)���I�����܂����B", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_INFOMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * ���b�Z�[�W�u�f�[�^�̑ޔ�(�o�b�N�A�b�v)�Ɏ��s���܂����B�v��\�����܂��B
   * <p>
   * DB�ޔ����A�ޔ������Ɏ��s�����ꍇ�̃��b�Z�[�W
   * </p>
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int QO005_BACKUP_FAILED() throws Exception{

    return ACMessageBox.show("�f�[�^�̑ޔ�(�o�b�N�A�b�v)�Ɏ��s���܂����B", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * ���b�Z�[�W�u�f�[�^�̕���(���X�g�A)���I�����܂����B�v��\�����܂��B
   * <p>
   * DB�������A���������ɐ��������ꍇ�̃��b�Z�[�W
   * </p>
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int QO005_RESTORE_SUCCESSED() throws Exception{

    return ACMessageBox.show("�f�[�^�̕���(���X�g�A)���I�����܂����B", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_INFOMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * ���b�Z�[�W�u�f�[�^�̕���(���X�g�A)�Ɏ��s���܂����B�����s���f�[�^�x�[�X�ɑ��̒[���₻�̑��̃\�t�g�E�F�A���A�N�Z�X���łȂ����m�F���Ă��������B�v��\�����܂��B
   * <p>
   * DB�������A���������Ɏ��s�����ꍇ�̃��b�Z�[�W
   * </p>
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int QO005_RESTORE_FAILED_FILEIO() throws Exception{

    return ACMessageBox.show("�f�[�^�̕���(���X�g�A)�Ɏ��s���܂����B" + ACConstants.LINE_SEPARATOR + "�f�[�^�x�[�X�ɑ��̒[���₻�̑��̃\�t�g�E�F�A���A�N�Z�X���łȂ����m�F���Ă��������B", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * ���b�Z�[�W�u�I�����ꂽ�t�@�C��([RESTORE])����S�f�[�^�̕��������s���܂��B�����s�����݂̃f�[�^�͕ʃt�@�C��([BACKUP])�ɕۑ�����܂��B�����s�����s���Ă���낵���ł����H�v��\�����܂��B
   * <p>
   * DB�ޔ����A���sDB�̑ޔ����m�F����Ƃ��̃��b�Z�[�W
   * </p>
   * @param param �p�����^
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int QO005_QUESTION_OF_BACKUP_FILENAME(VRMap param) throws Exception {
    return QO005_QUESTION_OF_BACKUP_FILENAME(

      VRBindPathParser.get("RESTORE", param)

      , VRBindPathParser.get("BACKUP", param)

           );
  }
  /**
   * ���b�Z�[�W�u�I�����ꂽ�t�@�C��([RESTORE])����S�f�[�^�̕��������s���܂��B�����s�����݂̃f�[�^�͕ʃt�@�C��([BACKUP])�ɕۑ�����܂��B�����s�����s���Ă���낵���ł����H�v��\�����܂��B
   * <p>
   * DB�ޔ����A���sDB�̑ޔ����m�F����Ƃ��̃��b�Z�[�W
   * </p>
   * @param arg1 RESTORE
   * @param arg2 BACKUP
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int QO005_QUESTION_OF_BACKUP_FILENAME(

      Object arg1
      , Object arg2
                        ) throws Exception{
    StringBuffer sb = new StringBuffer();

    sb.append("�I�����ꂽ�t�@�C��(");

    sb.append(arg1);

    sb.append(")����S�f�[�^�̕��������s���܂��B" + ACConstants.LINE_SEPARATOR + "���݂̃f�[�^�͕ʃt�@�C��(");

    sb.append(arg2);

    sb.append(")�ɕۑ�����܂��B" + ACConstants.LINE_SEPARATOR + "���s���Ă���낵���ł����H");

    return ACMessageBox.show(sb.toString(), ACMessageBox.BUTTON_OK | ACMessageBox.BUTTON_CANCEL, ACMessageBox.ICON_QUESTION, ACMessageBox.FOCUS_OK);

  }

  /**
   * ���b�Z�[�W�u[���ږ�]�����Ɍ�肪����܂��B�v��\�����܂��B
   * <p>
   * ���̓`�F�b�N
   * �������ڂɑ��݂��Ȃ����������͂���Ă���ꍇ
   * [���ږ�]�͍��ږ���\������ꍇ�Ɏg�p
   * �@����F[���ږ�] = �K��I����
   * </p>
   * @param param �p�����^
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int QP006_ERROR_OF_WRONG_TIME(VRMap param) throws Exception {
    return QP006_ERROR_OF_WRONG_TIME(

      VRBindPathParser.get("���ږ�", param)

           );
  }
  /**
   * ���b�Z�[�W�u[���ږ�]�����Ɍ�肪����܂��B�v��\�����܂��B
   * <p>
   * ���̓`�F�b�N
   * �������ڂɑ��݂��Ȃ����������͂���Ă���ꍇ
   * [���ږ�]�͍��ږ���\������ꍇ�Ɏg�p
   * �@����F[���ږ�] = �K��I����
   * </p>
   * @param arg1 ���ږ�
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int QP006_ERROR_OF_WRONG_TIME(

      Object arg1
                        ) throws Exception{
    StringBuffer sb = new StringBuffer();

    sb.append(arg1);

    sb.append("�����Ɍ�肪����܂��B");

    return ACMessageBox.show(sb.toString(), ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * ���b�Z�[�W�u����×{�Ǘ��w���̉񐔂����x�𒴂��Ă���\��������܂��B�����s�����̂܂ܓo�^���Ă���낵���ł����H�����s��[S]�v��\�����܂��B
   * <p>
   * �T�[�r�X�\��o�^���A����×{�Ǘ��w���̉񐔂����x�񐔂𒴂��Ă���ꍇ�ɕ\���B[S]�͍��ڂƉ񐔁B(��:�Ǘ��h�{�m 3��)
   * </p>
   * @param param �p�����^
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int QS001_LIMIT_OVER_KYOTAKU_RYOYO_KANRI_SHIDO(VRMap param) throws Exception {
    return QS001_LIMIT_OVER_KYOTAKU_RYOYO_KANRI_SHIDO(

      VRBindPathParser.get("S", param)

           );
  }
  /**
   * ���b�Z�[�W�u����×{�Ǘ��w���̉񐔂����x�𒴂��Ă���\��������܂��B�����s�����̂܂ܓo�^���Ă���낵���ł����H�����s��[S]�v��\�����܂��B
   * <p>
   * �T�[�r�X�\��o�^���A����×{�Ǘ��w���̉񐔂����x�񐔂𒴂��Ă���ꍇ�ɕ\���B[S]�͍��ڂƉ񐔁B(��:�Ǘ��h�{�m 3��)
   * </p>
   * @param arg1 S
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int QS001_LIMIT_OVER_KYOTAKU_RYOYO_KANRI_SHIDO(

      Object arg1
                        ) throws Exception{
    StringBuffer sb = new StringBuffer();

    sb.append("����×{�Ǘ��w���̉񐔂����x�𒴂��Ă���\��������܂��B" + ACConstants.LINE_SEPARATOR + "���̂܂ܓo�^���Ă���낵���ł����H" + ACConstants.LINE_SEPARATOR + "");

    sb.append(arg1);

    return ACMessageBox.show(sb.toString(), ACMessageBox.BUTTON_OK | ACMessageBox.BUTTON_CANCEL, ACMessageBox.ICON_QUESTION, ACMessageBox.FOCUS_OK);

  }

  /**
   * ���b�Z�[�W�u�ύX���ꂽ���e�͔j������܂��B�����s���N���A���Ă���낵���ł����H�v��\�����܂��B
   * <p>
   * �������s�m�F���b�Z�[�W�B
   * �N���A�{�^���������A��ʂ��ύX����Ă���ꍇ�ɕ\���B
   * </p>
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int WARNING_OF_CLEAR_ON_MODIFIED() throws Exception{

    return ACMessageBox.show("�ύX���ꂽ���e�͔j������܂��B" + ACConstants.LINE_SEPARATOR + "�N���A���Ă���낵���ł����H", ACMessageBox.BUTTON_OK | ACMessageBox.BUTTON_CANCEL, ACMessageBox.ICON_QUESTION, ACMessageBox.FOCUS_CANCEL);

  }

  /**
   * ���b�Z�[�W�u�񋟃T�[�r�X�̃}�X�^���̎擾�Ɏ��s���܂����B�v��\�����܂��B
   * <p>
   * �񋟃T�[�r�X�̃}�X�^��񂪎擾�ł��Ȃ������ꍇ�ɕ\�����郁�b�Z�[�W
   * </p>
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int QO004_ERROR_OF_SERVICE_MASTER() throws Exception{

    return ACMessageBox.show("�񋟃T�[�r�X�̃}�X�^���̎擾�Ɏ��s���܂����B", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * ���b�Z�[�W�u[��]���Ƀ`�F�b�N�����Ă��܂���B�����s���\������Ă���S����[����]���܂����H�v��\�����܂��B
   * <p>
   * ���p�҈ꗗ�Ƀ`�F�b�N�������ɏW�v�{�^�����������ꂽ�ꍇ�B
   * </p>
   * @param param �p�����^
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int QP001_WARGNING_TOTAL(VRMap param) throws Exception {
    return QP001_WARGNING_TOTAL(

      VRBindPathParser.get("��", param)

      , VRBindPathParser.get("����", param)

           );
  }
  /**
   * ���b�Z�[�W�u[��]���Ƀ`�F�b�N�����Ă��܂���B�����s���\������Ă���S����[����]���܂����H�v��\�����܂��B
   * <p>
   * ���p�҈ꗗ�Ƀ`�F�b�N�������ɏW�v�{�^�����������ꂽ�ꍇ�B
   * </p>
   * @param arg1 ��
   * @param arg2 ����
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int QP001_WARGNING_TOTAL(

      Object arg1
      , Object arg2
                        ) throws Exception{
    StringBuffer sb = new StringBuffer();

    sb.append(arg1);

    sb.append("���Ƀ`�F�b�N�����Ă��܂���B" + ACConstants.LINE_SEPARATOR + "�\������Ă���S����");

    sb.append(arg2);

    sb.append("���܂����H");

    return ACMessageBox.show(sb.toString(), ACMessageBox.BUTTON_OK | ACMessageBox.BUTTON_CANCEL, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * ���b�Z�[�W�u�Ђƌ��ɁA�قȂ��ی��Ҕԍ���2�܂ł����o�^�ł��܂���B�����s��3�ȏ�o�^����ꍇ�́A�����̐V�������p�҂��쐬���Ă��������B�v��\�����܂��B
   * <p>
   * �v���F����̒ǉ��E�ҏW���A1���ɈقȂ��ی��Ҕԍ���3�ȏ㑶�݂��邱�ƂɂȂ�ꍇ�B
   * </p>
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int QP002_ERROR_OF_INSURED_ID() throws Exception{

    return ACMessageBox.show("�Ђƌ��ɁA�قȂ��ی��Ҕԍ���2�܂ł����o�^�ł��܂���B" + ACConstants.LINE_SEPARATOR + "3�ȏ�o�^����ꍇ�́A�����̐V�������p�҂��쐬���Ă��������B", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * ���b�Z�[�W�u���т̑S�����Ɨ\��̓Ǎ����s���܂��B�����s����낵���ł����H�v��\�����܂��B
   * <p>
   * �\����捞���B
   * </p>
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int QS001_READ_PLAN() throws Exception{

    return ACMessageBox.show("���т̑S�����Ɨ\��̓Ǎ����s���܂��B" + ACConstants.LINE_SEPARATOR + "��낵���ł����H", ACMessageBox.BUTTON_OK | ACMessageBox.BUTTON_CANCEL, ACMessageBox.ICON_QUESTION, ACMessageBox.FOCUS_OK);

  }

  /**
   * ���b�Z�[�W�u�񋟃T�[�r�X��񂪕ύX����Ă��܂��B�����s���ύX�𔽉f���Ă���낵���ł����H�v��\�����܂��B
   * <p>
   * �񋟃T�[�r�X�ύX���Ƀp�l����؂�ւ����s�����ꍇ
   * </p>
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int QO004_WARNING_OF_SERVICE_INSERT() throws Exception{

    return ACMessageBox.show("�񋟃T�[�r�X��񂪕ύX����Ă��܂��B" + ACConstants.LINE_SEPARATOR + "�ύX�𔽉f���Ă���낵���ł����H", ACMessageBox.BUTTON_YES | ACMessageBox.BUTTON_NO | ACMessageBox.BUTTON_CANCEL, ACMessageBox.ICON_QUESTION, ACMessageBox.FOCUS_OK);

  }

  /**
   * ���b�Z�[�W�u���j���[�}�X�^���̎擾�Ɏ��s���܂����B�v��\�����܂��B
   * <p>
   * ���j���[�}�X�^�̏��̎擾�Ɏ��s�����ꍇ
   * </p>
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int QO004_ERROR_OF_MASTER_MENU() throws Exception{

    return ACMessageBox.show("���j���[�}�X�^���̎擾�Ɏ��s���܂����B", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * ���b�Z�[�W�u�L�����ԓ��t[TIME]�Ɍ�肪����܂��B�����s��[MONTH]�̓��t����͂��Ă��������B�v��\�����܂��B
   * <p>
   * �ی��ғo�^�̎x�����x�z�L�����Ԃɕs���ȓ��t�����͂��ꂽ�ꍇ
   * ��������[TIME]
   * ��������[MONTH]
   * </p>
   * @param param �p�����^
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int ERROR_OF_VALID_PERIOD(VRMap param) throws Exception {
    return ERROR_OF_VALID_PERIOD(

      VRBindPathParser.get("TIME", param)

      , VRBindPathParser.get("MONTH", param)

           );
  }
  /**
   * ���b�Z�[�W�u�L�����ԓ��t[TIME]�Ɍ�肪����܂��B�����s��[MONTH]�̓��t����͂��Ă��������B�v��\�����܂��B
   * <p>
   * �ی��ғo�^�̎x�����x�z�L�����Ԃɕs���ȓ��t�����͂��ꂽ�ꍇ
   * ��������[TIME]
   * ��������[MONTH]
   * </p>
   * @param arg1 TIME
   * @param arg2 MONTH
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int ERROR_OF_VALID_PERIOD(

      Object arg1
      , Object arg2
                        ) throws Exception{
    StringBuffer sb = new StringBuffer();

    sb.append("�L�����ԓ��t");

    sb.append(arg1);

    sb.append("�Ɍ�肪����܂��B" + ACConstants.LINE_SEPARATOR + "");

    sb.append(arg2);

    sb.append("�̓��t����͂��Ă��������B");

    return ACMessageBox.show(sb.toString(), ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * ���b�Z�[�W�u[FIELD]��[LENGTH]���œ��͂��Ă��������B�v��\�����܂��B
   * <p>
   * �����`�F�b�N�ŃG���[�����������ۂɕ\������B
   * ��������[FIELD]
   * ��������[LENGTH]
   * </p>
   * @param param �p�����^
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int ERROR_OF_LENGTH(VRMap param) throws Exception {
    return ERROR_OF_LENGTH(

      VRBindPathParser.get("FIELD", param)

      , VRBindPathParser.get("LENGTH", param)

           );
  }
  /**
   * ���b�Z�[�W�u[FIELD]��[LENGTH]���œ��͂��Ă��������B�v��\�����܂��B
   * <p>
   * �����`�F�b�N�ŃG���[�����������ۂɕ\������B
   * ��������[FIELD]
   * ��������[LENGTH]
   * </p>
   * @param arg1 FIELD
   * @param arg2 LENGTH
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int ERROR_OF_LENGTH(

      Object arg1
      , Object arg2
                        ) throws Exception{
    StringBuffer sb = new StringBuffer();

    sb.append(arg1);

    sb.append("��");

    sb.append(arg2);

    sb.append("���œ��͂��Ă��������B");

    return ACMessageBox.show(sb.toString(), ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * ���b�Z�[�W�u�ύX����Ă��܂��B�����s��[PROCESS]����[PRINTNAME]��������Ă���낵���ł����H�v��\�����܂��B
   * <p>
   * ����O�ɉ�ʂ��ύX����Ă���ꍇ�ɕ\��
   * ��������[PROCESS]�@��F�o�^�A�X�V
   * ��������[PRINTNAME]�@��F�K��Ō�v�揑
   * </p>
   * @param param �p�����^
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int WARNING_OF_DO_PRINT(VRMap param) throws Exception {
    return WARNING_OF_DO_PRINT(

      VRBindPathParser.get("PROCESS", param)

      , VRBindPathParser.get("PRINTNAME", param)

           );
  }
  /**
   * ���b�Z�[�W�u�ύX����Ă��܂��B�����s��[PROCESS]����[PRINTNAME]��������Ă���낵���ł����H�v��\�����܂��B
   * <p>
   * ����O�ɉ�ʂ��ύX����Ă���ꍇ�ɕ\��
   * ��������[PROCESS]�@��F�o�^�A�X�V
   * ��������[PRINTNAME]�@��F�K��Ō�v�揑
   * </p>
   * @param arg1 PROCESS
   * @param arg2 PRINTNAME
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int WARNING_OF_DO_PRINT(

      Object arg1
      , Object arg2
                        ) throws Exception{
    StringBuffer sb = new StringBuffer();

    sb.append("�ύX����Ă��܂��B" + ACConstants.LINE_SEPARATOR + "");

    sb.append(arg1);

    sb.append("����");

    sb.append(arg2);

    sb.append("��������Ă���낵���ł����H");

    return ACMessageBox.show(sb.toString(), ACMessageBox.BUTTON_OK | ACMessageBox.BUTTON_CANCEL, ACMessageBox.ICON_QUESTION, ACMessageBox.FOCUS_OK);

  }

  /**
   * ���b�Z�[�W�u�v���x�̔F��L�����Ԃ��߂��Ă��邩�A�������͓o�^����Ă��܂���B�����s�����p�ҏ��ڍ׉�ʂŔF�����o�^���Ă��������B�v��\�����܂��B
   * <p>
   * ���p�҈ꗗ�����ʑJ�ڎ��ɑΏ۔N�����ɔF�藚���̂Ȃ��Ƃ��A�g�p���܂��B
   * </p>
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int ERROR_OF_NO_NINTEI_HISTORY() throws Exception{

    return ACMessageBox.show("�v���x�̔F��L�����Ԃ��߂��Ă��邩�A�������͓o�^����Ă��܂���B" + ACConstants.LINE_SEPARATOR + "���p�ҏ��ڍ׉�ʂŔF�����o�^���Ă��������B", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * ���b�Z�[�W�u[AFFAIR]�ҏW�̑O�ɗ��p�ҏ���[PROCESS]����K�v������܂��B�����s��[PROCESS]���Ă���낵���ł����H�v��\�����܂��B
   * <p>
   * ��ʑJ�ڑO�ɉ�ʂ��ύX����Ă���ꍇ�ɕ\��
   * ��������[AFFAIR]�@��F����E�y�����A��ÊŌ���
   * ��j������[PROCESS]�@��F�o�^�A�X�V
   * ��O������[PROCESS]�@��F�o�^�A�X�V
   * </p>
   * @param param �p�����^
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int QU002_WARNING_OF_TRANSFER(VRMap param) throws Exception {
    return QU002_WARNING_OF_TRANSFER(

      VRBindPathParser.get("AFFAIR", param)

      , VRBindPathParser.get("PROCESS", param)

           );
  }
  /**
   * ���b�Z�[�W�u[AFFAIR]�ҏW�̑O�ɗ��p�ҏ���[PROCESS]����K�v������܂��B�����s��[PROCESS]���Ă���낵���ł����H�v��\�����܂��B
   * <p>
   * ��ʑJ�ڑO�ɉ�ʂ��ύX����Ă���ꍇ�ɕ\��
   * ��������[AFFAIR]�@��F����E�y�����A��ÊŌ���
   * ��j������[PROCESS]�@��F�o�^�A�X�V
   * ��O������[PROCESS]�@��F�o�^�A�X�V
   * </p>
   * @param arg1 AFFAIR
   * @param arg2 PROCESS
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int QU002_WARNING_OF_TRANSFER(

      Object arg1
      , Object arg2
                        ) throws Exception{
    StringBuffer sb = new StringBuffer();

    sb.append(arg1);

    sb.append("�ҏW�̑O�ɗ��p�ҏ���");

    sb.append(arg2);

    sb.append("����K�v������܂��B" + ACConstants.LINE_SEPARATOR + "");

    sb.append(arg2);

    sb.append("���Ă���낵���ł����H");

    return ACMessageBox.show(sb.toString(), ACMessageBox.BUTTON_OK | ACMessageBox.BUTTON_CANCEL, ACMessageBox.ICON_QUESTION, ACMessageBox.FOCUS_OK);

  }

  /**
   * ���b�Z�[�W�u�\���ł�����т�����܂���B�����s���\���\�����܂����H�v��\�����܂��B
   * 
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int QS001_QUESTION_OF_NO_RESULT() throws Exception{

    return ACMessageBox.show("�\���ł�����т�����܂���B" + ACConstants.LINE_SEPARATOR + "�\���\�����܂����H", ACMessageBox.BUTTON_YES | ACMessageBox.BUTTON_NO, ACMessageBox.ICON_QUESTION, ACMessageBox.FOCUS_OK);

  }

  /**
   * ���b�Z�[�W�u���Ə����I������Ă��܂���B�v��\�����܂��B
   * 
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int QS001_EROOR_OF_UNSELECTED_PROVIDER() throws Exception{

    return ACMessageBox.show("���Ə����I������Ă��܂���B", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * ���b�Z�[�W�u���e�ڍׂɕs��������܂��B�v��\�����܂��B
   * 
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int QS001_ERROR_OF_NO_CONTENT() throws Exception{

    return ACMessageBox.show("���e�ڍׂɕs��������܂��B", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * ���b�Z�[�W�u�����ɕs��������܂��B�v��\�����܂��B
   * 
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int QS001_ERROR_OF_NO_TIME() throws Exception{

    return ACMessageBox.show("�����ɕs��������܂��B", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * ���b�Z�[�W�u[�Ώۗ��p��]�����邽�ߕύX���邱�Ƃ��ł��܂���B�v��\�����܂��B
   * <p>
   * ���Ə����o�^���ɒ񋟃T�[�r�X�����폜�g�p�Ƃ����ꍇ
   * ��1������[�Ώۗ��p��]�@��F�T�[�r�X���󂯂Ă��闘�p��
   * </p>
   * @param param �p�����^
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int WARNING_OF_DELETE_PROVIDER(VRMap param) throws Exception {
    return WARNING_OF_DELETE_PROVIDER(

      VRBindPathParser.get("�Ώۗ��p��", param)

           );
  }
  /**
   * ���b�Z�[�W�u[�Ώۗ��p��]�����邽�ߕύX���邱�Ƃ��ł��܂���B�v��\�����܂��B
   * <p>
   * ���Ə����o�^���ɒ񋟃T�[�r�X�����폜�g�p�Ƃ����ꍇ
   * ��1������[�Ώۗ��p��]�@��F�T�[�r�X���󂯂Ă��闘�p��
   * </p>
   * @param arg1 �Ώۗ��p��
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int WARNING_OF_DELETE_PROVIDER(

      Object arg1
                        ) throws Exception{
    StringBuffer sb = new StringBuffer();

    sb.append(arg1);

    sb.append("�����邽�ߕύX���邱�Ƃ��ł��܂���B");

    return ACMessageBox.show(sb.toString(), ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * ���b�Z�[�W�u�����J���ȋK��̎x�����x�z�ɕύX���Ă���낵���ł����H�����s���i���ݓ��͂���Ă���f�[�^�͏����Ă��܂��܂��B�j�v��\�����܂��B
   * 
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int QO002_WARNING_OF_LIMIT_RATE_REGULAR() throws Exception{

    return ACMessageBox.show("�����J���ȋK��̎x�����x�z�ɕύX���Ă���낵���ł����H" + ACConstants.LINE_SEPARATOR + "�i���ݓ��͂���Ă���f�[�^�͏����Ă��܂��܂��B�j", ACMessageBox.BUTTON_OK | ACMessageBox.BUTTON_CANCEL, ACMessageBox.ICON_QUESTION, ACMessageBox.FOCUS_OK);

  }

  /**
   * ���b�Z�[�W�u���ԕ\���N���A���Ă���낵���ł����H�v��\�����܂��B
   * 
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int QS001_WARNING_OF_CLEAR_MONTHLY() throws Exception{

    return ACMessageBox.show("���ԕ\���N���A���Ă���낵���ł����H", ACMessageBox.BUTTON_OK | ACMessageBox.BUTTON_CANCEL, ACMessageBox.ICON_QUESTION, ACMessageBox.FOCUS_CANCEL);

  }

  /**
   * ���b�Z�[�W�u�T�ԕ\���N���A���Ă���낵���ł����H�v��\�����܂��B
   * 
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int QS001_WARNING_OF_CLEAR_WEEKLY() throws Exception{

    return ACMessageBox.show("�T�ԕ\���N���A���Ă���낵���ł����H", ACMessageBox.BUTTON_OK | ACMessageBox.BUTTON_CANCEL, ACMessageBox.ICON_QUESTION, ACMessageBox.FOCUS_CANCEL);

  }

  /**
   * ���b�Z�[�W�u���̔F�藚����[mode]����ƁA�L�����ԊO�ɂȂ�T�[�r�X�����݂��܂��B�����s��[mode]���Ă���낵���ł����H�v��\�����܂��B
   * <p>
   * �v���F����ҏW�E�폜���A�L�����ԊO�ƂȂ�T�[�r�X�����݂���ꍇ
   * �������F��[mode]�@��F�ҏW
   * </p>
   * @param param �p�����^
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int QU002_WARNING_OF_OUT_OF_VALID(VRMap param) throws Exception {
    return QU002_WARNING_OF_OUT_OF_VALID(

      VRBindPathParser.get("mode", param)

           );
  }
  /**
   * ���b�Z�[�W�u���̔F�藚����[mode]����ƁA�L�����ԊO�ɂȂ�T�[�r�X�����݂��܂��B�����s��[mode]���Ă���낵���ł����H�v��\�����܂��B
   * <p>
   * �v���F����ҏW�E�폜���A�L�����ԊO�ƂȂ�T�[�r�X�����݂���ꍇ
   * �������F��[mode]�@��F�ҏW
   * </p>
   * @param arg1 mode
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int QU002_WARNING_OF_OUT_OF_VALID(

      Object arg1
                        ) throws Exception{
    StringBuffer sb = new StringBuffer();

    sb.append("���̔F�藚����");

    sb.append(arg1);

    sb.append("����ƁA�L�����ԊO�ɂȂ�T�[�r�X�����݂��܂��B" + ACConstants.LINE_SEPARATOR + "");

    sb.append(arg1);

    sb.append("���Ă���낵���ł����H");

    return ACMessageBox.show(sb.toString(), ACMessageBox.BUTTON_OK | ACMessageBox.BUTTON_CANCEL, ACMessageBox.ICON_QUESTION, ACMessageBox.FOCUS_CANCEL);

  }

  /**
   * ���b�Z�[�W�u�L�����Ԃ��A�o�^����Ă���v���F��̗L�����ԂƏd�Ȃ��Ă��܂��B�v��\�����܂��B
   * <p>
   * �v���F��̗L�����Ԃ��d�������ꍇ�ɕ\������B�i�L�����Ԃ������Œ����ł��Ȃ��ꍇ�j
   * </p>
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int QU002_ERROR_OF_DUPLICATE_KAIGO() throws Exception{

    return ACMessageBox.show("�L�����Ԃ��A�o�^����Ă���v���F��̗L�����ԂƏd�Ȃ��Ă��܂��B", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * ���b�Z�[�W�u����E�Е��y������ʂŐ��ۂ̏���o�^���Ă��������B�v��\�����܂��B
   * <p>
   * ��ی��Ҕԍ����uH�v�Ŏn�܂�ꍇ
   * </p>
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int QU002_REQUEST_TO_INSERT_SEIHO() throws Exception{

    return ACMessageBox.show("����E�Е��y������ʂŐ��ۂ̏���o�^���Ă��������B", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * ���b�Z�[�W�u[����]�̖K��Ō�̎��т�Ǎ��݂܂��B�����s���i���ݓ��͂���Ă���f�[�^�͏����Ă��܂��܂��B�j�����s����낵���ł����H�v��\�����܂��B
   * <p>
   * �K��Ō�񍐏��ŖK��Ō�̎��т�Ǎ��ޏꍇ
   * </p>
   * @param param �p�����^
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int QC002_WARNING_OF_RESULT(VRMap param) throws Exception {
    return QC002_WARNING_OF_RESULT(

      VRBindPathParser.get("����", param)

           );
  }
  /**
   * ���b�Z�[�W�u[����]�̖K��Ō�̎��т�Ǎ��݂܂��B�����s���i���ݓ��͂���Ă���f�[�^�͏����Ă��܂��܂��B�j�����s����낵���ł����H�v��\�����܂��B
   * <p>
   * �K��Ō�񍐏��ŖK��Ō�̎��т�Ǎ��ޏꍇ
   * </p>
   * @param arg1 ����
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int QC002_WARNING_OF_RESULT(

      Object arg1
                        ) throws Exception{
    StringBuffer sb = new StringBuffer();

    sb.append(arg1);

    sb.append("�̖K��Ō�̎��т�Ǎ��݂܂��B" + ACConstants.LINE_SEPARATOR + "�i���ݓ��͂���Ă���f�[�^�͏����Ă��܂��܂��B�j" + ACConstants.LINE_SEPARATOR + "��낵���ł����H");

    return ACMessageBox.show(sb.toString(), ACMessageBox.BUTTON_OK | ACMessageBox.BUTTON_CANCEL, ACMessageBox.ICON_QUESTION, ACMessageBox.FOCUS_CANCEL);

  }

  /**
   * ���b�Z�[�W�u�K��Ō�̎��уf�[�^�����݂��܂���ł����B�����s���Ǎ������͍s���܂���B�v��\�����܂��B
   * <p>
   * �K��Ō�̎��т��Ǎ��߂Ȃ������ꍇ
   * </p>
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int QC002_ERROR_OF_RESULT() throws Exception{

    return ACMessageBox.show("�K��Ō�̎��уf�[�^�����݂��܂���ł����B" + ACConstants.LINE_SEPARATOR + "�Ǎ������͍s���܂���B", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * ���b�Z�[�W�u�u���������v�ł́u30�������v�͑I���ł��܂���B�����s���u30���ȏ�1���Ԗ����v�ɐݒ肵�܂��B�v��\�����܂��B
   * <p>
   * �K����̖K���ʂƂ��āu���������v��I�����A�񋟎��ԂɁu30�������v���w�肵���ꍇ
   * </p>
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int QS001_ERROR_OF_LIFE_ASSIST_TIME() throws Exception{

    return ACMessageBox.show("�u���������v�ł́u30�������v�͑I���ł��܂���B" + ACConstants.LINE_SEPARATOR + "�u30���ȏ�1���Ԗ����v�ɐݒ肵�܂��B", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * ���b�Z�[�W�u���łɓ����[item]��񂪗L�����ԓ��ɓo�^����Ă��܂��B�v��\�����܂��B
   * <p>
   * �I����������Ɠ�������A���͂����L�����ԓ��ɓo�^����Ă���ꍇ
   * ��������[item]�@��F����
   * </p>
   * @param param �p�����^
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int QU004_ERROR_OF_DUPLICATE_KOHI_TERM(VRMap param) throws Exception {
    return QU004_ERROR_OF_DUPLICATE_KOHI_TERM(

      VRBindPathParser.get("item", param)

           );
  }
  /**
   * ���b�Z�[�W�u���łɓ����[item]��񂪗L�����ԓ��ɓo�^����Ă��܂��B�v��\�����܂��B
   * <p>
   * �I����������Ɠ�������A���͂����L�����ԓ��ɓo�^����Ă���ꍇ
   * ��������[item]�@��F����
   * </p>
   * @param arg1 item
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int QU004_ERROR_OF_DUPLICATE_KOHI_TERM(

      Object arg1
                        ) throws Exception{
    StringBuffer sb = new StringBuffer();

    sb.append("���łɓ����");

    sb.append(arg1);

    sb.append("��񂪗L�����ԓ��ɓo�^����Ă��܂��B");

    return ACMessageBox.show(sb.toString(), ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * ���b�Z�[�W�u�������w�肳��Ă��܂���B�v��\�����܂��B
   * <p>
   * �T�[�r�X�\��̏T�ԕ\�ɂ����āA�\��t���������w�肹���ɓ\��t���{�^�������������ꍇ
   * </p>
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int QS001_ERROR_OF_NO_PASTE_DAY() throws Exception{

    return ACMessageBox.show("�������w�肳��Ă��܂���B", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * ���b�Z�[�W�u�\��t���悪�w�肳��Ă��܂���B�v��\�����܂��B
   * <p>
   * �T�[�r�X�\��̏T�ԕ\�ɂ����āA�\��t���j�����w�肹���ɓ\��t���{�^�������������ꍇ
   * </p>
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int QS001_ERROR_OF_NO_PASTE_WEEK() throws Exception{

    return ACMessageBox.show("�\��t���悪�w�肳��Ă��܂���B", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * ���b�Z�[�W�u���t���ɂ́A91�ȏ�100�ȉ��̒l����͂��Ă��������B�v��\�����܂��B
   * <p>
   * ���t���̒l���A90������������101�ȏ�ł������ꍇ
   * </p>
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int QU004_ERROR_OF_BENEFIT_RATE_VALUE() throws Exception{

    return ACMessageBox.show("���t���ɂ́A91�ȏ�100�ȉ��̒l����͂��Ă��������B", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * ���b�Z�[�W�u���p�ҕ��S�P�ʐ��������͂ł��B�v��\�����܂��B
   * <p>
   * ���ȕ��S������ʂɂė��p�ҕ��S�P�ʐ����󗓂ɂ����ꍇ
   * </p>
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int QS001_ERROR_OF_BLANK_ADJUST_UNIT() throws Exception{

    return ACMessageBox.show("���p�ҕ��S�P�ʐ��������͂ł��B", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * ���b�Z�[�W�u�������ɂ́A100�ȉ��̒l����͂��Ă��������B�v��\�����܂��B
   * <p>
   * ��������100�𒴂���l����͂��ꂽ�ꍇ
   * </p>
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int QO004_ERROR_OF_REDUCT_RATE() throws Exception{

    return ACMessageBox.show("�������ɂ́A100�ȉ��̒l����͂��Ă��������B", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * ���b�Z�[�W�u[item]���d�����Ă��܂��B�v��\�����܂��B
   * <p>
   * ���ږ����d�����Ă����ꍇ�B
   * </p>
   * @param param �p�����^
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int QO008_ERROR_OF_OVERLAP(VRMap param) throws Exception {
    return QO008_ERROR_OF_OVERLAP(

      VRBindPathParser.get("item", param)

           );
  }
  /**
   * ���b�Z�[�W�u[item]���d�����Ă��܂��B�v��\�����܂��B
   * <p>
   * ���ږ����d�����Ă����ꍇ�B
   * </p>
   * @param arg1 item
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int QO008_ERROR_OF_OVERLAP(

      Object arg1
                        ) throws Exception{
    StringBuffer sb = new StringBuffer();

    sb.append(arg1);

    sb.append("���d�����Ă��܂��B");

    return ACMessageBox.show(sb.toString(), ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * ���b�Z�[�W�u[count]���ڂ̃t���b�s�[��}�����ĉ������B�v��\�����܂��B
   * <p>
   * �t���b�s�[���������ɂ킽��ꍇ�B
   * </p>
   * @param param �p�����^
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int QP001_NEXT_FD(VRMap param) throws Exception {
    return QP001_NEXT_FD(

      VRBindPathParser.get("count", param)

           );
  }
  /**
   * ���b�Z�[�W�u[count]���ڂ̃t���b�s�[��}�����ĉ������B�v��\�����܂��B
   * <p>
   * �t���b�s�[���������ɂ킽��ꍇ�B
   * </p>
   * @param arg1 count
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int QP001_NEXT_FD(

      Object arg1
                        ) throws Exception{
    StringBuffer sb = new StringBuffer();

    sb.append(arg1);

    sb.append("���ڂ̃t���b�s�[��}�����ĉ������B");

    return ACMessageBox.show(sb.toString(), ACMessageBox.BUTTON_OK, ACMessageBox.ICON_INFOMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * ���b�Z�[�W�u���O�C�����Ə���I�����ĉ������B�v��\�����܂��B
   * 
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int QM001_ERROR_OF_PROVIDER() throws Exception{

    return ACMessageBox.show("���O�C�����Ə���I�����ĉ������B", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * ���b�Z�[�W�u�敪�x�����x��z�𒴂��Ă��܂��B�����s�����p�ҕ��S�P�ʐ��𒲐���Ɉ�����Ă��������B�v��\�����܂��B
   * <p>
   * �敪�x�����x�z�𒴂�����Ԃŗ��p�[�E�񋟕[��������悤�Ƃ����ꍇ�B
   * </p>
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int QS001_ERROR_OF_LIMIT_RATE_OVER() throws Exception{

    return ACMessageBox.show("�敪�x�����x��z�𒴂��Ă��܂��B" + ACConstants.LINE_SEPARATOR + "���p�ҕ��S�P�ʐ��𒲐���Ɉ�����Ă��������B", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * ���b�Z�[�W�u�����̗v���F�藚�������݂��܂���B�����s�������ɗL���ȗv���F�藚�����쐬��A������Ă��������B�v��\�����܂��B
   * <p>
   * �����̗v���F�藚�����Ȃ���Ԃŗ��p�[�E�񋟕[��������悤�Ƃ����ꍇ�B
   * </p>
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int QS001_ERROR_OF_NO_INSURE_INFO() throws Exception{

    return ACMessageBox.show("�����̗v���F�藚�������݂��܂���B" + ACConstants.LINE_SEPARATOR + "�����ɗL���ȗv���F�藚�����쐬��A������Ă��������B", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * ���b�Z�[�W�u30�����̃T�[�r�X�́A�S�z���ȕ��S�����ł��B�v��\�����܂��B
   * <p>
   * 30�����̃T�[�r�X�ɑ΂��Ď��ȕ��S�������s�����Ƃ����ꍇ�B
   * </p>
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int QS001_ERROR_OF_EDIT_ON_30_DAY_OVER_SERVICE() throws Exception{

    return ACMessageBox.show("30�����̃T�[�r�X�́A�S�z���ȕ��S�����ł��B", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * ���b�Z�[�W�u[item]��[value]�ȉ��̒l����͂��Ă��������B�v��\�����܂��B
   * <p>
   * ���͂��ꂽ�l���傫������ꍇ
   * ��������[item]�@��F���t��
   * ��������[value]�@��F100
   * </p>
   * @param param �p�����^
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int ERROR_OF_VALUE_TOO_MUCH(VRMap param) throws Exception {
    return ERROR_OF_VALUE_TOO_MUCH(

      VRBindPathParser.get("item", param)

      , VRBindPathParser.get("value", param)

           );
  }
  /**
   * ���b�Z�[�W�u[item]��[value]�ȉ��̒l����͂��Ă��������B�v��\�����܂��B
   * <p>
   * ���͂��ꂽ�l���傫������ꍇ
   * ��������[item]�@��F���t��
   * ��������[value]�@��F100
   * </p>
   * @param arg1 item
   * @param arg2 value
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int ERROR_OF_VALUE_TOO_MUCH(

      Object arg1
      , Object arg2
                        ) throws Exception{
    StringBuffer sb = new StringBuffer();

    sb.append(arg1);

    sb.append("��");

    sb.append(arg2);

    sb.append("�ȉ��̒l����͂��Ă��������B");

    return ACMessageBox.show(sb.toString(), ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * ���b�Z�[�W�u�Ώ۔N���ɂ́A�u����18�N4���v�ȍ~�̓��t����͂��Ă��������B�v��\�����܂��B
   * <p>
   * ����18�N4���ȑO�̓��t�����͂��ꂽ�ꍇ
   * </p>
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int QU001_ERROR_OF_DATE_BEFORE_LAW_CHANGE() throws Exception{

    return ACMessageBox.show("�Ώ۔N���ɂ́A�u����18�N4���v�ȍ~�̓��t����͂��Ă��������B", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * ���b�Z�[�W�u���͂��ꂽ[key]�́A�ߋ��ɍ폜���ꂽ[item]��[key]�ƈ�v���܂��B�����s���폜�ς݂�[item]���𕜌����܂����H�v��\�����܂��B
   * <p>
   * �ߋ��ɍ폜���ꂽ�f�[�^�̒��ɁAKEY�̈�v����f�[�^���������ꍇ�B
   * ��������[key]�@��F���Ə��ԍ�
   * ��������[item]�@��F���Ə�
   * </p>
   * @param param �p�����^
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int WARNING_OF_RESTORATION_OF_DELETE_DATA(VRMap param) throws Exception {
    return WARNING_OF_RESTORATION_OF_DELETE_DATA(

      VRBindPathParser.get("key", param)

      , VRBindPathParser.get("item", param)

           );
  }
  /**
   * ���b�Z�[�W�u���͂��ꂽ[key]�́A�ߋ��ɍ폜���ꂽ[item]��[key]�ƈ�v���܂��B�����s���폜�ς݂�[item]���𕜌����܂����H�v��\�����܂��B
   * <p>
   * �ߋ��ɍ폜���ꂽ�f�[�^�̒��ɁAKEY�̈�v����f�[�^���������ꍇ�B
   * ��������[key]�@��F���Ə��ԍ�
   * ��������[item]�@��F���Ə�
   * </p>
   * @param arg1 key
   * @param arg2 item
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int WARNING_OF_RESTORATION_OF_DELETE_DATA(

      Object arg1
      , Object arg2
                        ) throws Exception{
    StringBuffer sb = new StringBuffer();

    sb.append("���͂��ꂽ");

    sb.append(arg1);

    sb.append("�́A�ߋ��ɍ폜���ꂽ");

    sb.append(arg2);

    sb.append("��");

    sb.append(arg1);

    sb.append("�ƈ�v���܂��B" + ACConstants.LINE_SEPARATOR + "�폜�ς݂�");

    sb.append(arg2);

    sb.append("���𕜌����܂����H");

    return ACMessageBox.show(sb.toString(), ACMessageBox.BUTTON_OK | ACMessageBox.BUTTON_CANCEL, ACMessageBox.ICON_QUESTION, ACMessageBox.FOCUS_CANCEL);

  }

  /**
   * ���b�Z�[�W�u���Ə��o�^���L�����Z�����ꂽ���߁A���ǒ����I�����܂��B�v��\�����܂��B
   * 
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int QM001_END_OF_SYSTEM() throws Exception{

    return ACMessageBox.show("���Ə��o�^���L�����Z�����ꂽ���߁A���ǒ����I�����܂��B", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * ���b�Z�[�W�u�����͂̍��ڂ�����܂��B�v��\�����܂��B
   * <p>
   * ���͂��ׂ����ڂ��󗓂ŏ������悤�Ƃ����Ƃ��B
   * </p>
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int QS001_ERROR_OF_BLANK_TEXT() throws Exception{

    return ACMessageBox.show("�����͂̍��ڂ�����܂��B", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * ���b�Z�[�W�u�I�����ꂽ�t�@�C���͗L���ȃf�[�^�x�[�X�t�@�C���ł͂���܂���B�v��\�����܂��B
   * <p>
   * �I�������t�@�C����DB�łȂ������ꍇ�A�������͑��݂��Ȃ��ꍇ
   * </p>
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int QO005_ERROR_OF_NOT_A_DATABASE() throws Exception{

    return ACMessageBox.show("�I�����ꂽ�t�@�C���͗L���ȃf�[�^�x�[�X�t�@�C���ł͂���܂���B", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * ���b�Z�[�W�u�f�[�^�x�[�X�̕ۑ��ꏊ�ɓ��{����܂ގ��͂ł��܂���B�f�[�^�x�[�X���ړ����邩�A�ʂ̃f�[�^�x�[�X���w�肵�Ă��������B�v��\�����܂��B
   * <p>
   * �f�[�^�x�[�X�̏ꏊ�ɓ��{��L�����N�^�[���܂܂�Ă����ꍇ
   * </p>
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int QO005_ERROR_OF_DBPATH_INCLUDE_JAPANESE_CHAR() throws Exception{

    return ACMessageBox.show("�f�[�^�x�[�X�̕ۑ��ꏊ�ɓ��{����܂ގ��͂ł��܂���B�f�[�^�x�[�X���ړ����邩�A�ʂ̃f�[�^�x�[�X���w�肵�Ă��������B", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * ���b�Z�[�W�u�f�[�^�x�[�X�̃t�@�C�������ύX����Ă��܂��A�ݒ���X�V���čēx���s���Ă��������B�v��\�����܂��B
   * <p>
   * �f�[�^�x�[�X�̃o�b�N�A�b�v�E���X�g�A���s���O�ɁA������ɂȂ�DB�p�X����ʂŕύX����Ă���ꍇ
   * </p>
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int QO005_ERROR_OF_NOT_SAME_PROPERTY_DBPATH() throws Exception{

    return ACMessageBox.show("�f�[�^�x�[�X�̃t�@�C�������ύX����Ă��܂��A�ݒ���X�V���čēx���s���Ă��������B", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * ���b�Z�[�W�u�ڑ��m�F�p�e���|�����̈�ւ�DB�t�@�C���R�s�[�Ɏ��s���܂����B�������t�@�C�����m�F���Ă��������B�v��\�����܂��B
   * <p>
   * �ڑ����ؗp�e���|�����Ɏw�肳�ꂽ�t�@�C�����R�s�[����ۂɃG���[�����������ꍇ
   * </p>
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int QO005_ERROR_OF_COPY_DBFILE_TEMP_FAILED() throws Exception{

    return ACMessageBox.show("�ڑ��m�F�p�e���|�����̈�ւ�DB�t�@�C���R�s�[�Ɏ��s���܂����B�������t�@�C�����m�F���Ă��������B", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * ���b�Z�[�W�u�������̃f�[�^�x�[�X��F���ł��܂���B�����s�������Firebird�̃f�[�^�x�[�X�t�@�C���ł��邩�m�F���Ă��������B�v��\�����܂��B
   * <p>
   * �����w�肵��DB�t�@�C���̐ڑ����؂�DB�Ƃ��Đڑ��ł��Ȃ������ꍇ
   * </p>
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int QO005_ERROR_OF_NOT_FIREBIRD_DB() throws Exception{

    return ACMessageBox.show("�������̃f�[�^�x�[�X��F���ł��܂���B" + ACConstants.LINE_SEPARATOR + "�����Firebird�̃f�[�^�x�[�X�t�@�C���ł��邩�m�F���Ă��������B", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * ���b�Z�[�W�u�I�����ꂽ�t�@�C���͎��s�\�ȃt�@�C���ł͂���܂���B�v��\�����܂��B
   * <p>
   * PDF�r���A�[�Ɏw�肵���t�@�C�������s�\�Ȋg���q�Ŗ��������ꍇ�A�܂��͑��݂��Ȃ��ꍇ
   * </p>
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int QO005_ERROR_OF_NOT_EXECUTE_FILE() throws Exception{

    return ACMessageBox.show("�I�����ꂽ�t�@�C���͎��s�\�ȃt�@�C���ł͂���܂���B", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * ���b�Z�[�W�uIP�A�h���X�܂��̓z�X�g���������͂ł��B�v��\�����܂��B
   * <p>
   * ���W�I�{�^���������[�g�ɂȂ��Ă���ɂ��ւ�炸�AIP�A�h���X���z�X�g�������͂���Ă��Ȃ������ꍇ
   * </p>
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int QO005_ERROR_OF_EMPTY_IP_OR_HOST() throws Exception{

    return ACMessageBox.show("IP�A�h���X�܂��̓z�X�g���������͂ł��B", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * ���b�Z�[�W�u�f�[�^�x�[�X�̐ݒ�t�@�C���������͂���Ă��܂���B�v��\�����܂��B
   * <p>
   * �f�[�^�x�[�X�̃t�@�C���̏ꏊ�������͂ɂȂ��Ă����ꍇ
   * </p>
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int QO005_ERROR_OF_EMPTY_DBFILE_PATH() throws Exception{

    return ACMessageBox.show("�f�[�^�x�[�X�̐ݒ�t�@�C���������͂���Ă��܂���B", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * ���b�Z�[�W�uPDF�t�@�C���r���A�[�̐ݒ肪����Ă��܂���B�v��\�����܂��B
   * <p>
   * PDF�t�@�C���{���\�t�g�̎��s�p�X�������͂ɂȂ��Ă����ꍇ
   * </p>
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int QO005_ERROR_OF_EMPTY_PDF_VIEWER_PATH() throws Exception{

    return ACMessageBox.show("PDF�t�@�C���r���A�[�̐ݒ肪����Ă��܂���B", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * ���b�Z�[�W�u�f�[�^�x�[�X���I�[�v���ł��܂���B�f�[�^�x�[�X�̐ݒ���������Ă��������B�����s������Ƃ��āA�ȉ��̍��ڂ����m�F���������B�����s���y������z�����s���EMac�̏ꍇ�AJava���s��(JRE)�ɁuJava 1.4.2 Update 2�v��K�p�ς݂ł����H�����s���y�Z�L�����e�B�\�t�g�ɂ�鐧���z�����s���E�E�B���X�΍�\�t�g��A�Z�L�����e�B�֌W�̃\�t�g�E�F�A���C���X�g�[�����Ă��܂����H�����Y�\�t�g�̐ݒ��ύX���A�|�[�g3050�ł̒ʐM�������邩�AFirebird �Ɏ��s������t�^���Ă��������B�����s���E Windows XP�̏ꍇ�A�u�t�@�C�A�E�H�[���v�@�\���g�p����Ă��܂����H���t�@�C�A�E�H�[���̐ݒ��ύX���A�u���b�N���Ȃ���O�v���O������ Firebird ��ǉ����Ă��������B�����s����Windows�ŕW���ݒ�̂܂� Firebird ���C���X�g�[�������ꍇ�AC:\\Program Files\\Firebird\\bin\\fbguard.exe ��C:\\Program Files\\Firebird\\bin\\fbserver.exe �̎��s��������ݒ�ɂ��Ă��������B�����s�����e�\�t�g�E�F�A�̐ݒ���@�̏ڍׂɂ��܂��ẮA�\�t�g�E�F�A�̃��[�J�[�ɂ��₢���킹���������B�v��\�����܂��B
   * <p>
   * �ݒ���i�[����O��FB�ɐڑ��\�����O�Ƀ`�F�b�N���s���ۂɁA�ڑ����ł��Ȃ�������\������G���[
   * </p>
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int QO005_ERROR_OF_NOT_CONNECT_FIREBIRD() throws Exception{

    return ACMessageBox.show("�f�[�^�x�[�X���I�[�v���ł��܂���B�f�[�^�x�[�X�̐ݒ���������Ă��������B" + ACConstants.LINE_SEPARATOR + "����Ƃ��āA�ȉ��̍��ڂ����m�F���������B" + ACConstants.LINE_SEPARATOR + "�y������z" + ACConstants.LINE_SEPARATOR + "�EMac�̏ꍇ�AJava���s��(JRE)�ɁuJava 1.4.2 Update 2�v��K�p�ς݂ł����H" + ACConstants.LINE_SEPARATOR + "�y�Z�L�����e�B�\�t�g�ɂ�鐧���z" + ACConstants.LINE_SEPARATOR + "�E�E�B���X�΍�\�t�g��A�Z�L�����e�B�֌W�̃\�t�g�E�F�A���C���X�g�[�����Ă��܂����H�����Y�\�t�g�̐ݒ��ύX���A�|�[�g3050�ł̒ʐM�������邩�AFirebird �Ɏ��s������t�^���Ă��������B" + ACConstants.LINE_SEPARATOR + "�E Windows XP�̏ꍇ�A�u�t�@�C�A�E�H�[���v�@�\���g�p����Ă��܂����H���t�@�C�A�E�H�[���̐ݒ��ύX���A�u���b�N���Ȃ���O�v���O������ Firebird ��ǉ����Ă��������B" + ACConstants.LINE_SEPARATOR + "��Windows�ŕW���ݒ�̂܂� Firebird ���C���X�g�[�������ꍇ�AC:\\Program Files\\Firebird\\bin\\fbguard.exe ��C:\\Program Files\\Firebird\\bin\\fbserver.exe �̎��s��������ݒ�ɂ��Ă��������B" + ACConstants.LINE_SEPARATOR + "���e�\�t�g�E�F�A�̐ݒ���@�̏ڍׂɂ��܂��ẮA�\�t�g�E�F�A�̃��[�J�[�ɂ��₢���킹���������B", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * ���b�Z�[�W�u�󎚉\�ȃT�[�r�X���ݒ肳��Ă��܂���B�����s��������܂����H�v��\�����܂��B
   * 
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int QS001_WARNING_OF_BLANK_PAGE() throws Exception{

    return ACMessageBox.show("�󎚉\�ȃT�[�r�X���ݒ肳��Ă��܂���B" + ACConstants.LINE_SEPARATOR + "������܂����H", ACMessageBox.BUTTON_OK | ACMessageBox.BUTTON_CANCEL, ACMessageBox.ICON_QUESTION, ACMessageBox.FOCUS_CANCEL);

  }

  /**
   * ���b�Z�[�W�u���t�Ǘ��ΏۊO�̃T�[�r�X�͎��ȕ��S�����ł��܂���B�v��\�����܂��B
   * 
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int QS001_ERROR_OF_INVALID_UNIT_ADJUST() throws Exception{

    return ACMessageBox.show("���t�Ǘ��ΏۊO�̃T�[�r�X�͎��ȕ��S�����ł��܂���B", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * ���b�Z�[�W�u[info]���ύX����Ă��܂��B�m�肵�Ă��Ȃ��ύX�͔j������܂��B�����s����낵���ł����H�����s�������s�����ύX�𔽉f����ꍇ�A�ǉ��������͏��փ{�^�����������Ă��������B�v��\�����܂��B
   * <p>
   * �v���F�藚���Ȃǂ̃e�[�u���ҏW�Ɩ��ɂ����āA�ǉ��E�ҏW�{�^���ɂăf�[�^���m�肳��Ă��Ȃ��ꍇ
   * ��������[info] ��F�v���F����������͈ٓ����
   * </p>
   * @param param �p�����^
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int WARNING_OF_CANCELLATION_UNSETTLED_DATA(VRMap param) throws Exception {
    return WARNING_OF_CANCELLATION_UNSETTLED_DATA(

      VRBindPathParser.get("info", param)

           );
  }
  /**
   * ���b�Z�[�W�u[info]���ύX����Ă��܂��B�m�肵�Ă��Ȃ��ύX�͔j������܂��B�����s����낵���ł����H�����s�������s�����ύX�𔽉f����ꍇ�A�ǉ��������͏��փ{�^�����������Ă��������B�v��\�����܂��B
   * <p>
   * �v���F�藚���Ȃǂ̃e�[�u���ҏW�Ɩ��ɂ����āA�ǉ��E�ҏW�{�^���ɂăf�[�^���m�肳��Ă��Ȃ��ꍇ
   * ��������[info] ��F�v���F����������͈ٓ����
   * </p>
   * @param arg1 info
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int WARNING_OF_CANCELLATION_UNSETTLED_DATA(

      Object arg1
                        ) throws Exception{
    StringBuffer sb = new StringBuffer();

    sb.append(arg1);

    sb.append("���ύX����Ă��܂��B�m�肵�Ă��Ȃ��ύX�͔j������܂��B" + ACConstants.LINE_SEPARATOR + "��낵���ł����H" + ACConstants.LINE_SEPARATOR + "" + ACConstants.LINE_SEPARATOR + "���ύX�𔽉f����ꍇ�A�ǉ��������͏��փ{�^�����������Ă��������B");

    return ACMessageBox.show(sb.toString(), ACMessageBox.BUTTON_OK | ACMessageBox.BUTTON_CANCEL, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_CANCEL);

  }

  /**
   * ���b�Z�[�W�u���łɁA����̉��x�������ԍ������S���҂��o�^����Ă��܂��B�v��\�����܂��B
   * <p>
   * ���x�������ԍ����d������ꍇ
   * </p>
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int QO004_ERROR_OF_DUPLICATE_CARE_MANAGER_NO() throws Exception{

    return ACMessageBox.show("���łɁA����̉��x�������ԍ������S���҂��o�^����Ă��܂��B", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * ���b�Z�[�W�u[item]���d�����Ă��܂��B�v��\�����܂��B
   * <p>
   * ���ږ����d�����Ă����ꍇ�B
   * </p>
   * @param param �p�����^
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int QO002_ERROR_OF_OVERLAP(VRMap param) throws Exception {
    return QO002_ERROR_OF_OVERLAP(

      VRBindPathParser.get("item", param)

           );
  }
  /**
   * ���b�Z�[�W�u[item]���d�����Ă��܂��B�v��\�����܂��B
   * <p>
   * ���ږ����d�����Ă����ꍇ�B
   * </p>
   * @param arg1 item
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int QO002_ERROR_OF_OVERLAP(

      Object arg1
                        ) throws Exception{
    StringBuffer sb = new StringBuffer();

    sb.append(arg1);

    sb.append("���d�����Ă��܂��B");

    return ACMessageBox.show(sb.toString(), ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * ���b�Z�[�W�u����T�[�r�X�v����쐬���鎖�Ə����I������Ă��܂���B�����s�������s��������T�[�r�X�v����쐬���鎖�Ə����o�^����Ă��Ȃ��ꍇ�́A���Ə��o�^��ʂɂā����s���@�ȉ��̂����ꂩ�̃T�[�r�X��񋟂��鎖�Ə���o�^���Ă��������B�����s���@�@�@�E������x�������s���@�@�@�E���\�h�x�������s���@�@�@�E���K�͑��@�\�^�����쁃���s���@�@�@�E���\�h���K�͑��@�\�^������v��\�����܂��B
   * <p>
   * �v���F�藚���̋�����x�����Ə����I������Ă��Ȃ������ꍇ
   * </p>
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int QU002_ERROR_OF_NO_DATA_SHIEN_PROVIDER() throws Exception{

    return ACMessageBox.show("����T�[�r�X�v����쐬���鎖�Ə����I������Ă��܂���B" + ACConstants.LINE_SEPARATOR + "" + ACConstants.LINE_SEPARATOR + "������T�[�r�X�v����쐬���鎖�Ə����o�^����Ă��Ȃ��ꍇ�́A���Ə��o�^��ʂɂ�" + ACConstants.LINE_SEPARATOR + "�@�ȉ��̂����ꂩ�̃T�[�r�X��񋟂��鎖�Ə���o�^���Ă��������B" + ACConstants.LINE_SEPARATOR + "�@�@�@�E������x��" + ACConstants.LINE_SEPARATOR + "�@�@�@�E���\�h�x��" + ACConstants.LINE_SEPARATOR + "�@�@�@�E���K�͑��@�\�^������" + ACConstants.LINE_SEPARATOR + "�@�@�@�E���\�h���K�͑��@�\�^������", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * ���b�Z�[�W�u�폜���܂����B�����s�����O�C�����Ə����đI�����邽�߁A�߂�{�^�������������ۂɎ����Ń��O�A�E�g���܂��B�v��\�����܂��B
   * <p>
   * ���Ə��ꗗ�Ń��O�C�����Ə����폜�����ꍇ
   * </p>
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int QO003_DELETE_SUCCESSED_AND_MUST_LOGOUT() throws Exception{

    return ACMessageBox.show("�폜���܂����B" + ACConstants.LINE_SEPARATOR + "���O�C�����Ə����đI�����邽�߁A�߂�{�^�������������ۂɎ����Ń��O�A�E�g���܂��B", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_INFOMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * ���b�Z�[�W�u���p�ҕ��S�P�ʐ������t�Ǘ��ΏےP�ʐ��𒴂��Ă��܂��B�����s�����p�ҕ��S�P�ʐ��𒲐���Ɉ�����Ă��������B�v��\�����܂��B
   * <p>
   * ���p�ҕ��S������̒P�ʐ���0�����ň�������ꍇ
   * </p>
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int QS001_ERROR_OF_MINIMUM_OVER() throws Exception{

    return ACMessageBox.show("���p�ҕ��S�P�ʐ������t�Ǘ��ΏےP�ʐ��𒴂��Ă��܂��B" + ACConstants.LINE_SEPARATOR + "���p�ҕ��S�P�ʐ��𒲐���Ɉ�����Ă��������B", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * ���b�Z�[�W�uCSV�o�͉\�ȃt�H���_���w�肳��Ă��܂���B�����s���u�C�ӂ̃t�H���_�v���������ďo�͐���w�肵�Ă��������B�v��\�����܂��B
   * <p>
   * CSV�o�͐�Ƃ��ėL���ȃt�H���_�ȊO���w�肵���ꍇ
   * </p>
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int QP008_ERROR_OF_INVALID_FOLDER() throws Exception{

    return ACMessageBox.show("CSV�o�͉\�ȃt�H���_���w�肳��Ă��܂���B" + ACConstants.LINE_SEPARATOR + "�u�C�ӂ̃t�H���_�v���������ďo�͐���w�肵�Ă��������B", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * ���b�Z�[�W�u��ی��Ҕԍ����uH�v�Ŏn�܂��Ă��邽�߁A���ےP�ƂƂ݂Ȃ������s�����ی����t����0%�ɂ��܂��B�����s����낵���ł����H�v��\�����܂��B
   * <p>
   * �v���F�藚��o�^�E�ҏW���A��ی��Ҕԍ����uH�v�Ŏn�܂��Ă���ꍇ
   * </p>
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int QU002_WARNING_OF_CHANGE_RATE_FOR_SEIHO_TANDOKU() throws Exception{

    return ACMessageBox.show("��ی��Ҕԍ����uH�v�Ŏn�܂��Ă��邽�߁A���ےP�ƂƂ݂Ȃ�" + ACConstants.LINE_SEPARATOR + "���ی����t����0%�ɂ��܂��B" + ACConstants.LINE_SEPARATOR + "��낵���ł����H", ACMessageBox.BUTTON_OK | ACMessageBox.BUTTON_CANCEL, ACMessageBox.ICON_QUESTION, ACMessageBox.FOCUS_OK);

  }

  /**
   * ���b�Z�[�W�u���O�C�����Ə������݂��܂���B���O�A�E�g���ă��O�C�����Ə���I�����Ă��������B�v��\�����܂��B
   * <p>
   * ���p�҈ꗗ�i�����j�ɂă��O�C�����Ə������擾�ł��Ȃ������ꍇ
   * </p>
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int QP001_ERROR_OF_NO_LOGIN_PROVIDER() throws Exception{

    return ACMessageBox.show("���O�C�����Ə������݂��܂���B���O�A�E�g���ă��O�C�����Ə���I�����Ă��������B", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * ���b�Z�[�W�u�f�[�^�x�[�X�̕ύX�m�F�̂��߁A�����Ń��O�A�E�g���܂��B�v��\�����܂��B
   * 
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int QO005_AUTO_LOGOUT() throws Exception{

    return ACMessageBox.show("�f�[�^�x�[�X�̕ύX�m�F�̂��߁A�����Ń��O�A�E�g���܂��B", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_INFOMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * ���b�Z�[�W�u�ڑ��m�F�p�̃f�[�^�x�[�X�t�@�C���̍폜�Ɏ��s���܂����B�v��\�����܂��B
   * <p>
   * �ڑ����ؗp�e���|��������t�@�C�����폜����ۂɃG���[�����������ꍇ
   * </p>
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int QO005_ERROR_OF_DELETE_DBFILE_TEMP_FAILED() throws Exception{

    return ACMessageBox.show("�ڑ��m�F�p�̃f�[�^�x�[�X�t�@�C���̍폜�Ɏ��s���܂����B", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * ���b�Z�[�W�u�f�[�^�̕���(���X�g�A)�Ɏ��s���܂����B�����s�����݂̃f�[�^�x�[�X�̑ޔ��Ƀt�@�C�����������ގ����ł��܂���B�v��\�����܂��B
   * <p>
   * DB�������A���������Ɏ��s�����ꍇ�̃��b�Z�[�W
   * </p>
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int QO005_RESTORE_FAILED_COPY() throws Exception{

    return ACMessageBox.show("�f�[�^�̕���(���X�g�A)�Ɏ��s���܂����B" + ACConstants.LINE_SEPARATOR + "���݂̃f�[�^�x�[�X�̑ޔ��Ƀt�@�C�����������ގ����ł��܂���B", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * ���b�Z�[�W�u�L���ȗv���F�藚�������݂��܂���B�����s�����p�ҏ����m�F���Ă��������B�v��\�����܂��B
   * <p>
   * �ی��Ҕԍ��̌��@�����F�藚���ň�����悤�Ƃ����ꍇ
   * </p>
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int QS001_ERROR_OF_EMPTY_PRINT() throws Exception{

    return ACMessageBox.show("�L���ȗv���F�藚�������݂��܂���B" + ACConstants.LINE_SEPARATOR + "���p�ҏ����m�F���Ă��������B", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * ���b�Z�[�W�u���ےP�Ƃł͂Ȃ����߁A0%�ȊO�̋��t������͂���K�v������܂��B�v��\�����܂��B
   * <p>
   * ��ی��Ҕԍ����uH�v�Ŏn�܂�Ȃ��ꍇ�ɁA���t�����u0%�v�ɐݒ肳��Ă����ꍇ
   * </p>
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int QU002_ERROR_OF_RATE_FOR_NOT_SEIHO_TANDOKU() throws Exception{

    return ACMessageBox.show("���ےP�Ƃł͂Ȃ����߁A0%�ȊO�̋��t������͂���K�v������܂��B", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * ���b�Z�[�W�u�W�v�ł��Ȃ����т�����܂����B�v��\�����܂��B
   * <p>
   * ���\�h�Ή��܂ŗv�x���P�A�v�x���Q�̏ꍇ�͍쐬����Ȃ����[�т����[�ǂ����邽�߁A�G���[���b�Z�[�W��\�����W�v�𒆒f����B
   * </p>
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int QP001_ERROR_OF_NURSING_NECESSARY_LEVEL() throws Exception{

    return ACMessageBox.show("�W�v�ł��Ȃ����т�����܂����B", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * ���b�Z�[�W�u[target]��[limit]�Ƃ��Ă��������B�v��\�����܂��B
   * <p>
   * ���ԑѓ��͈̔͊O�G���[�̏ꍇ
   * </p>
   * @param param �p�����^
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int QS001_ERROR_OF_RANGE_OVER(VRMap param) throws Exception {
    return QS001_ERROR_OF_RANGE_OVER(

      VRBindPathParser.get("target", param)

      , VRBindPathParser.get("limit", param)

           );
  }
  /**
   * ���b�Z�[�W�u[target]��[limit]�Ƃ��Ă��������B�v��\�����܂��B
   * <p>
   * ���ԑѓ��͈̔͊O�G���[�̏ꍇ
   * </p>
   * @param arg1 target
   * @param arg2 limit
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int QS001_ERROR_OF_RANGE_OVER(

      Object arg1
      , Object arg2
                        ) throws Exception{
    StringBuffer sb = new StringBuffer();

    sb.append(arg1);

    sb.append("��");

    sb.append(arg2);

    sb.append("�Ƃ��Ă��������B");

    return ACMessageBox.show(sb.toString(), ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * ���b�Z�[�W�u���x�������ԍ��������͂̃T�[�r�X������܂��B�v��\�����܂��B
   * <p>
   * ���x�������ԍ������͂������ꍇ
   * </p>
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int QS001_WARNING_OF_SENMONIN_NO() throws Exception{

    return ACMessageBox.show("���x�������ԍ��������͂̃T�[�r�X������܂��B", ACMessageBox.BUTTON_OK | ACMessageBox.BUTTON_CANCEL, ACMessageBox.ICON_QUESTION, ACMessageBox.FOCUS_OK);

  }

  /**
   * ���b�Z�[�W�u�ڑ���̐ݒ肪�s���ł��B�����s���ڑ���z�X�g��|�[�g�ԍ����������Ă��������B�v��\�����܂��B
   * <p>
   * �ڑ����G���[
   * </p>
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int QO013_ERROR_OF_CONECT() throws Exception{

    return ACMessageBox.show("�ڑ���̐ݒ肪�s���ł��B" + ACConstants.LINE_SEPARATOR + "�ڑ���z�X�g��|�[�g�ԍ����������Ă��������B", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * ���b�Z�[�W�u���ׂĂ̊��҂��������܂��B��낵���ł����H�����s����100��������5�b���x������܂��B�v��\�����܂��B
   * <p>
   * ������
   * </p>
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int QO013_QUESTION_OF_FIND() throws Exception{

    return ACMessageBox.show("���ׂĂ̊��҂��������܂��B��낵���ł����H" + ACConstants.LINE_SEPARATOR + "��100��������5�b���x������܂��B", ACMessageBox.BUTTON_OK | ACMessageBox.BUTTON_CANCEL, ACMessageBox.ICON_QUESTION, ACMessageBox.FOCUS_CANCEL);

  }

  /**
   * ���b�Z�[�W�u[State]�Ɏ��s���܂����B[Item]�v��\�����܂��B
   * <p>
   * �ڑ��G���[�i�J�X�^���j
   * </p>
   * @param param �p�����^
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int QO013_ERROR_OF_CONECT_CUSTOM(VRMap param) throws Exception {
    return QO013_ERROR_OF_CONECT_CUSTOM(

      VRBindPathParser.get("State", param)

      , VRBindPathParser.get("Item", param)

           );
  }
  /**
   * ���b�Z�[�W�u[State]�Ɏ��s���܂����B[Item]�v��\�����܂��B
   * <p>
   * �ڑ��G���[�i�J�X�^���j
   * </p>
   * @param arg1 State
   * @param arg2 Item
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int QO013_ERROR_OF_CONECT_CUSTOM(

      Object arg1
      , Object arg2
                        ) throws Exception{
    StringBuffer sb = new StringBuffer();

    sb.append(arg1);

    sb.append("�Ɏ��s���܂����B");

    sb.append(arg2);

    return ACMessageBox.show(sb.toString(), ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * ���b�Z�[�W�uDBS�̃o�[�W�������قȂ�܂��B�v��\�����܂��B
   * <p>
   * �ڑ��G���[�iDBS�j
   * </p>
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int QO013_ERROR_OF_CONECT_DATA_BASE_VERSION() throws Exception{

    return ACMessageBox.show("DBS�̃o�[�W�������قȂ�܂��B", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * ���b�Z�[�W�u�ݒ�t�@�C���ւ̏������݂Ɏ��s���܂����B�����s�������𒆒f���܂��B�v��\�����܂��B
   * <p>
   * �v���p�e�B�t�@�C���ւ̏������ݎ��s��
   * </p>
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int QO013_ERROR_OF_WRITE_PROPERTY() throws Exception{

    return ACMessageBox.show("�ݒ�t�@�C���ւ̏������݂Ɏ��s���܂����B" + ACConstants.LINE_SEPARATOR + "�����𒆒f���܂��B", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * ���b�Z�[�W�u���ҏ�񂪑��݂��܂���B�v��\�����܂��B
   * <p>
   * ���ҏ��擾���s��
   * </p>
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int QO013_NO_PATIENT() throws Exception{

    return ACMessageBox.show("���ҏ�񂪑��݂��܂���B", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * ���b�Z�[�W�u���ҏ����擾���܂����B�v��\�����܂��B
   * <p>
   * ���ҏ��擾������
   * </p>
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int QO013_SUCCESS_PATIENT() throws Exception{

    return ACMessageBox.show("���ҏ����擾���܂����B", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_INFOMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * ���b�Z�[�W�u���ҏ�����荞�݂܂����B�v��\�����܂��B
   * <p>
   * ���ҏ���荞�ݐ�����
   * </p>
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int QO013_SUCCESS_INSERT() throws Exception{

    return ACMessageBox.show("���ҏ�����荞�݂܂����B", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_INFOMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * ���b�Z�[�W�u2���ȏ�̕ی���񂪍��݂����̎����͍쐬�ł��܂���B�����s�����p�ҏ����m�F���A�ی��̗L�����Ԃ��Ƃɕ����ė̎������쐬���Ă��������B�v��\�����܂��B
   * <p>
   * 2���ȏ�̕ی��̗L�����Ԃ��܂����������Ԃ��w�肵���ꍇ
   * </p>
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int QP011_ERROR_OF_MULTIPLE_INSURE_SPAN() throws Exception{

    return ACMessageBox.show("2���ȏ�̕ی���񂪍��݂����̎����͍쐬�ł��܂���B" + ACConstants.LINE_SEPARATOR + "���p�ҏ����m�F���A�ی��̗L�����Ԃ��Ƃɕ����ė̎������쐬���Ă��������B", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * ���b�Z�[�W�u�������ԂɗL���ȕی���񂪑��݂��܂���B�����s���S�z���p�ҕ��S�Ƃ��č쐬���܂����H�v��\�����܂��B
   * <p>
   * �L���ȕی���񂪑��݂��Ȃ��ꍇ
   * </p>
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int QP011_WARNING_OF_INVALID_INSURE_SPAN() throws Exception{

    return ACMessageBox.show("�������ԂɗL���ȕی���񂪑��݂��܂���B" + ACConstants.LINE_SEPARATOR + "�S�z���p�ҕ��S�Ƃ��č쐬���܂����H", ACMessageBox.BUTTON_OK | ACMessageBox.BUTTON_CANCEL, ACMessageBox.ICON_QUESTION, ACMessageBox.FOCUS_CANCEL);

  }

  /**
   * ���b�Z�[�W�u����ŗ����Đݒ肵�܂��B��낵���ł����H�v��\�����܂��B
   * <p>
   * �K��Ō�×{��̎����ҏW�ɂĐŗ��Đݒ���s���ꍇ
   * </p>
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int QP012_QUESTION_OF_TAX_CHANGE() throws Exception{

    return ACMessageBox.show("����ŗ����Đݒ肵�܂��B��낵���ł����H", ACMessageBox.BUTTON_OK | ACMessageBox.BUTTON_CANCEL, ACMessageBox.ICON_QUESTION, ACMessageBox.FOCUS_CANCEL);

  }

  /**
   * ���b�Z�[�W�u�f�[�^�x�[�X�̐ݒ肪�������Ă��܂���B�����s���ݒ���X�V��A��������O��ʂɖ߂�A�ēx�{��ʂ�\�����Ă��������B�v��\�����܂��B
   * <p>
   * ����ŗ���ݒ�s�\�ȏ�ԂŐŗ��ύX���s�����Ƃ����ꍇ
   * </p>
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int QO005_ERROR_OF_DB_FAILED() throws Exception{

    return ACMessageBox.show("�f�[�^�x�[�X�̐ݒ肪�������Ă��܂���B" + ACConstants.LINE_SEPARATOR + "�ݒ���X�V��A��������O��ʂɖ߂�A�ēx�{��ʂ�\�����Ă��������B", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * ���b�Z�[�W�u�ی���񂪕ύX���ꂽ���߁A�������Ԃ̎��т�ǂݍ��߂܂���B�����s���i2���ȏ�̕ی���񂪍��݂����̎����͍쐬�ł��܂���B�j�v��\�����܂��B
   * <p>
   * 2���ȏ�̕ی��̗L�����Ԃ��܂����������Ԃ��w�肵���ꍇ
   * </p>
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int QP012_ERROR_OF_MULTIPLE_INSURE_SPAN() throws Exception{

    return ACMessageBox.show("�ی���񂪕ύX���ꂽ���߁A�������Ԃ̎��т�ǂݍ��߂܂���B" + ACConstants.LINE_SEPARATOR + "�i2���ȏ�̕ی���񂪍��݂����̎����͍쐬�ł��܂���B�j", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * ���b�Z�[�W�u�������ԂɗL���ȕی���񂪑��݂��܂���B�����s���S�z���p�ҕ��S�Ƃ��Ď��т�ǂݍ��݂܂����H�v��\�����܂��B
   * <p>
   * �L���ȕی���񂪑��݂��Ȃ��ꍇ
   * </p>
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int QP012_WARNING_OF_INVALID_INSURE_SPAN() throws Exception{

    return ACMessageBox.show("�������ԂɗL���ȕی���񂪑��݂��܂���B" + ACConstants.LINE_SEPARATOR + "�S�z���p�ҕ��S�Ƃ��Ď��т�ǂݍ��݂܂����H", ACMessageBox.BUTTON_OK | ACMessageBox.BUTTON_CANCEL, ACMessageBox.ICON_QUESTION, ACMessageBox.FOCUS_CANCEL);

  }

  /**
   * ���b�Z�[�W�u�������Ԃɂ�����K��Ō�̎��т�ǂݍ��݂܂��B�����s���i���ݓ��͂���Ă���񋟓��E�ی��K�p���S�͏����Ă��܂��܂��B�j�����s����낵���ł����H�v��\�����܂��B
   * <p>
   * �K��Ō�×{��̎����ҏW�ŖK��Ō�̎��т�Ǎ��ޏꍇ
   * </p>
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int QP012_WARNING_OF_OPEN_RESULT() throws Exception{

    return ACMessageBox.show("�������Ԃɂ�����K��Ō�̎��т�ǂݍ��݂܂��B" + ACConstants.LINE_SEPARATOR + "�i���ݓ��͂���Ă���񋟓��E�ی��K�p���S�͏����Ă��܂��܂��B�j" + ACConstants.LINE_SEPARATOR + "��낵���ł����H", ACMessageBox.BUTTON_OK | ACMessageBox.BUTTON_CANCEL, ACMessageBox.ICON_QUESTION, ACMessageBox.FOCUS_CANCEL);

  }

  /**
   * ���b�Z�[�W�u����������m�肵�܂����H�v��\�����܂��B
   * <p>
   * ����ς݂ɂ��邩�̊m�F
   * </p>
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int QP012_QUESTION_OF_PRINT_COMMIT() throws Exception{

    return ACMessageBox.show("����������m�肵�܂����H", ACMessageBox.BUTTON_YES | ACMessageBox.BUTTON_NO, ACMessageBox.ICON_QUESTION, ACMessageBox.FOCUS_YES);

  }

  /**
   * ���b�Z�[�W�u�̎��z���v��999,999,999�܂łƂ��Ă��������B�v��\�����܂��B
   * <p>
   * �ُ�ȍ��z��̎��z���v�Ƃ����ꍇ
   * </p>
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int QP012_ERROR_OF_TOTAL_LIMIT_OVER() throws Exception{

    return ACMessageBox.show("�̎��z���v��999,999,999�܂łƂ��Ă��������B", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * ���b�Z�[�W�uCSV�o�͂Ɏ��s���܂����B�����s���������I�����܂��B�v��\�����܂��B
   * <p>
   * FD�e�ʂ�����Ȃ��ȂǁACSV�o�͂Ɏ��s�����ꍇ
   * </p>
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int QP001_ERROR_OF_CSV_OUTPUT() throws Exception{

    return ACMessageBox.show("CSV�o�͂Ɏ��s���܂����B" + ACConstants.LINE_SEPARATOR + "�������I�����܂��B", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * ���b�Z�[�W�u����7/8�̎w��Ɍ�肪����܂��B�����s����������s���܂���?�v��\�����܂��B
   * <p>
   * H18.9���ȑO�ɘV�l�V���̃f�[�^�����݁A��������H18.10�ȍ~�ɘV�l�W���̃f�[�^�����݂����ꍇ
   * </p>
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int QP001_WARNING_OF_INJUSTICE_CLAIM() throws Exception{

    return ACMessageBox.show("����7/8�̎w��Ɍ�肪����܂��B" + ACConstants.LINE_SEPARATOR + "��������s���܂���?", ACMessageBox.BUTTON_OK | ACMessageBox.BUTTON_CANCEL, ACMessageBox.ICON_QUESTION, ACMessageBox.FOCUS_CANCEL);

  }

  /**
   * ���b�Z�[�W�u���p�ҕ��S�̔������闘�p�҂��I������Ă��܂���B�����s������𒆎~���܂��B�v��\�����܂��B
   * <p>
   * ���p�ҕ��S�z�̔������Ȃ����p�҂݂̂��I������Ă���ꍇ
   * </p>
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int QP001_ERROR_OF_PATIENT_SELF_NO_PRICE() throws Exception{

    return ACMessageBox.show("���p�ҕ��S�̔������闘�p�҂��I������Ă��܂���B" + ACConstants.LINE_SEPARATOR + "����𒆎~���܂��B", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_INFOMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * ���b�Z�[�W�u�I������Ă��闘�p�҂�[reportName]�̏�񂪑��݂��܂���B�����s������𒆎~���܂��B�v��\�����܂��B
   * <p>
   * ����Ώۂ̒��[�f�[�^��1�������݂��Ȃ��ꍇ
   * </p>
   * @param param �p�����^
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int QU001_ERROR_OF_EMPTY_DATA_REPORT_ONLY(VRMap param) throws Exception {
    return QU001_ERROR_OF_EMPTY_DATA_REPORT_ONLY(

      VRBindPathParser.get("reportName", param)

           );
  }
  /**
   * ���b�Z�[�W�u�I������Ă��闘�p�҂�[reportName]�̏�񂪑��݂��܂���B�����s������𒆎~���܂��B�v��\�����܂��B
   * <p>
   * ����Ώۂ̒��[�f�[�^��1�������݂��Ȃ��ꍇ
   * </p>
   * @param arg1 reportName
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int QU001_ERROR_OF_EMPTY_DATA_REPORT_ONLY(

      Object arg1
                        ) throws Exception{
    StringBuffer sb = new StringBuffer();

    sb.append("�I������Ă��闘�p�҂�");

    sb.append(arg1);

    sb.append("�̏�񂪑��݂��܂���B" + ACConstants.LINE_SEPARATOR + "����𒆎~���܂��B");

    return ACMessageBox.show(sb.toString(), ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * ���b�Z�[�W�u[reportName]�̏�񂪑��݂��Ȃ����p�҂��܂܂�Ă��܂��B�����s��������Ă���낵���ł����H�v��\�����܂��B
   * <p>
   * ����Ώۂɒ��[�f�[�^�̑��݂��Ȃ��Ώێ҂��܂܂��ꍇ
   * </p>
   * @param param �p�����^
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int QU001_WARNING_OF_EMPTY_DATA_REPORT_MIXED(VRMap param) throws Exception {
    return QU001_WARNING_OF_EMPTY_DATA_REPORT_MIXED(

      VRBindPathParser.get("reportName", param)

           );
  }
  /**
   * ���b�Z�[�W�u[reportName]�̏�񂪑��݂��Ȃ����p�҂��܂܂�Ă��܂��B�����s��������Ă���낵���ł����H�v��\�����܂��B
   * <p>
   * ����Ώۂɒ��[�f�[�^�̑��݂��Ȃ��Ώێ҂��܂܂��ꍇ
   * </p>
   * @param arg1 reportName
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int QU001_WARNING_OF_EMPTY_DATA_REPORT_MIXED(

      Object arg1
                        ) throws Exception{
    StringBuffer sb = new StringBuffer();

    sb.append(arg1);

    sb.append("�̏�񂪑��݂��Ȃ����p�҂��܂܂�Ă��܂��B" + ACConstants.LINE_SEPARATOR + "������Ă���낵���ł����H");

    return ACMessageBox.show(sb.toString(), ACMessageBox.BUTTON_YES | ACMessageBox.BUTTON_NO, ACMessageBox.ICON_QUESTION, ACMessageBox.FOCUS_YES);

  }

  /**
   * ���b�Z�[�W�u����\��[reportName]���I������Ă��܂���B�����s���\������Ă��闘�p�҂̈���\��[reportName]��������Ă���낵���ł����H�v��\�����܂��B
   * <p>
   * ����ΏۂɃ`�F�b�N�����Ă��Ȃ��ꍇ
   * </p>
   * @param param �p�����^
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int QU001_WARNING_OF_PRINT_TARGET_NO_SELECT(VRMap param) throws Exception {
    return QU001_WARNING_OF_PRINT_TARGET_NO_SELECT(

      VRBindPathParser.get("reportName", param)

           );
  }
  /**
   * ���b�Z�[�W�u����\��[reportName]���I������Ă��܂���B�����s���\������Ă��闘�p�҂̈���\��[reportName]��������Ă���낵���ł����H�v��\�����܂��B
   * <p>
   * ����ΏۂɃ`�F�b�N�����Ă��Ȃ��ꍇ
   * </p>
   * @param arg1 reportName
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int QU001_WARNING_OF_PRINT_TARGET_NO_SELECT(

      Object arg1
                        ) throws Exception{
    StringBuffer sb = new StringBuffer();

    sb.append("����\��");

    sb.append(arg1);

    sb.append("���I������Ă��܂���B" + ACConstants.LINE_SEPARATOR + "�\������Ă��闘�p�҂̈���\��");

    sb.append(arg1);

    sb.append("��������Ă���낵���ł����H");

    return ACMessageBox.show(sb.toString(), ACMessageBox.BUTTON_YES | ACMessageBox.BUTTON_NO, ACMessageBox.ICON_QUESTION, ACMessageBox.FOCUS_NO);

  }

  /**
   * ���b�Z�[�W�u����Ɏ��s���܂����B�v��\�����܂��B
   * <p>
   * ��������Ɏ��s�����ꍇ�A�����o�邱�Ƃ͂Ȃ�
   * </p>
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int ERROR_OF_PRINT() throws Exception{

    return ACMessageBox.show("����Ɏ��s���܂����B", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_INFOMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * ���b�Z�[�W�u���p�ҕ��S�̔������Ȃ����p�҂��܂܂�Ă��܂��B�����s��������Ă���낵���ł����H�v��\�����܂��B
   * <p>
   * ���p�Ҍ����������I���o�[�W�����̈��
   * </p>
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int QP001_WARNING_OF_CUSTOM_PRINT() throws Exception{

    return ACMessageBox.showYesNoCancel("���p�ҕ��S�̔������Ȃ����p�҂��܂܂�Ă��܂��B" + ACConstants.LINE_SEPARATOR + "������Ă���낵���ł����H", "�������(�S��)(O)", 'O', "�������(��������)(N)", 'N', ACMessageBox.FOCUS_NO);

  }

  /**
   * ���b�Z�[�W�u���p�ҕ��S�̔������Ȃ����p�҂��I������Ă��܂��B�����s��������Ă���낵���ł����H�v��\�����܂��B
   * <p>
   * ����Ώۂ����݂��Ȃ����������ꍇ
   * </p>
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int QU001_WARNING_OF_EMPTY_DATA_REPORT_ONLY() throws Exception{

    return ACMessageBox.show("���p�ҕ��S�̔������Ȃ����p�҂��I������Ă��܂��B" + ACConstants.LINE_SEPARATOR + "������Ă���낵���ł����H", ACMessageBox.BUTTON_YES | ACMessageBox.BUTTON_NO, ACMessageBox.ICON_QUESTION, ACMessageBox.FOCUS_YES);

  }

  /**
   * ���b�Z�[�W�u����ς݂�[reportName]�ł��B�����s���X�V����ƈ���ς݂łȂ��Ȃ�܂��B�����s���X�V���Ă���낵���ł����H�����s���i����ς݂ɂ���ꍇ�͍ēx������s���K�v������܂��B�j�v��\�����܂��B
   * <p>
   * ���Ɉ���ς݂̋���ʊǗ��w������ۑ�����ꍇ
   * </p>
   * @param param �p�����^
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int QC005_WARNING_OF_PRINTED_KYOTAKU_RYOYO(VRMap param) throws Exception {
    return QC005_WARNING_OF_PRINTED_KYOTAKU_RYOYO(

      VRBindPathParser.get("reportName", param)

           );
  }
  /**
   * ���b�Z�[�W�u����ς݂�[reportName]�ł��B�����s���X�V����ƈ���ς݂łȂ��Ȃ�܂��B�����s���X�V���Ă���낵���ł����H�����s���i����ς݂ɂ���ꍇ�͍ēx������s���K�v������܂��B�j�v��\�����܂��B
   * <p>
   * ���Ɉ���ς݂̋���ʊǗ��w������ۑ�����ꍇ
   * </p>
   * @param arg1 reportName
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int QC005_WARNING_OF_PRINTED_KYOTAKU_RYOYO(

      Object arg1
                        ) throws Exception{
    StringBuffer sb = new StringBuffer();

    sb.append("����ς݂�");

    sb.append(arg1);

    sb.append("�ł��B" + ACConstants.LINE_SEPARATOR + "�X�V����ƈ���ς݂łȂ��Ȃ�܂��B" + ACConstants.LINE_SEPARATOR + "�X�V���Ă���낵���ł����H" + ACConstants.LINE_SEPARATOR + "�i����ς݂ɂ���ꍇ�͍ēx������s���K�v������܂��B�j");

    return ACMessageBox.show(sb.toString(), ACMessageBox.BUTTON_YES | ACMessageBox.BUTTON_NO, ACMessageBox.ICON_QUESTION, ACMessageBox.FOCUS_NO);

  }

  /**
   * ���b�Z�[�W�u����\��[reportName]���I������Ă��܂���B�����s��[reportName]�̏���ۑ����邱�Ƃň�����邱�Ƃ��\�ł��B�v��\�����܂��B
   * <p>
   * ����s�\�ȏꍇ
   * </p>
   * @param param �p�����^
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int QU001_ERROR_OF_NO_PRINT_DATA(VRMap param) throws Exception {
    return QU001_ERROR_OF_NO_PRINT_DATA(

      VRBindPathParser.get("reportName", param)

           );
  }
  /**
   * ���b�Z�[�W�u����\��[reportName]���I������Ă��܂���B�����s��[reportName]�̏���ۑ����邱�Ƃň�����邱�Ƃ��\�ł��B�v��\�����܂��B
   * <p>
   * ����s�\�ȏꍇ
   * </p>
   * @param arg1 reportName
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int QU001_ERROR_OF_NO_PRINT_DATA(

      Object arg1
                        ) throws Exception{
    StringBuffer sb = new StringBuffer();

    sb.append("����\��");

    sb.append(arg1);

    sb.append("���I������Ă��܂���B" + ACConstants.LINE_SEPARATOR + "");

    sb.append(arg1);

    sb.append("�̏���ۑ����邱�Ƃň�����邱�Ƃ��\�ł��B");

    return ACMessageBox.show(sb.toString(), ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * ���b�Z�[�W�u�T�[�r�X�p�^�[�����������͂ł��B�v��\�����܂��B
   * <p>
   * �T�[�r�X�p�^�[���������͂���Ă��Ȃ��ꍇ
   * </p>
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int QS001_ERROR_OF_SERVICE_PATTERN_NAME() throws Exception{

    return ACMessageBox.show("�T�[�r�X�p�^�[�����������͂ł��B", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * ���b�Z�[�W�u�E�v���ɒl��ݒ肷��ꍇ�́A����6����ݒ肵�Ă��������B�v��\�����܂��B
   * <p>
   * �E�v���ɐ��l6���ȊO�����͂���Ă���ꍇ
   * </p>
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int QS001_ERROR_OF_TEKIYOU_INPUT() throws Exception{

    return ACMessageBox.show("�E�v���ɒl��ݒ肷��ꍇ�́A����6����ݒ肵�Ă��������B", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * ���b�Z�[�W�u���͂��ꂽ�p�X���[�h�ɋ󔒕������܂܂�Ă��܂��B�����s���󔒕������܂񂾃p�X���[�h�͎g�p�ł��܂���B�v��\�����܂��B
   * <p>
   * �����Z�A�W���ɋ󔒂��܂ރp�X���[�h���ݒ肳��Ă����ꍇ
   * </p>
   * @throws Exception ������O
   * @return �I�������{�^��ID
   */
  public int QO013_ERROR_OF_BLANK_IN_PASSWORD() throws Exception{

    return ACMessageBox.show("���͂��ꂽ�p�X���[�h�ɋ󔒕������܂܂�Ă��܂��B" + ACConstants.LINE_SEPARATOR + "�󔒕������܂񂾃p�X���[�h�͎g�p�ł��܂���B", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

}
