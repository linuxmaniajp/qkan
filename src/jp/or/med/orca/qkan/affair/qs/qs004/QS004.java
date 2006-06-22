
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
 * �쐬��: 2005/12/13  ���{�R���s���[�^�[������� �� ���� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �\��Ǘ� (S)
 * �v���Z�X ����E������� (004)
 * �v���O���� ����E������� (QS004)
 *
 *****************************************************************
 */

package jp.or.med.orca.qkan.affair.qs.qs004;

import java.awt.*;
import java.awt.event.*;
import java.awt.im.*;
import java.io.*;
import java.text.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
import jp.nichicom.ac.*;
import jp.nichicom.ac.bind.*;
import jp.nichicom.ac.component.*;
import jp.nichicom.ac.component.event.*;
import jp.nichicom.ac.component.mainmenu.*;
import jp.nichicom.ac.component.table.*;
import jp.nichicom.ac.container.*;
import jp.nichicom.ac.core.*;
import jp.nichicom.ac.filechooser.*;
import jp.nichicom.ac.io.*;
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

/**
 * ����E�������(QS004) 
 */
public class QS004 extends QS004Event {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QS004(){
  }
  public void initAffair(ACAffairInfo affair) throws Exception  {
    super.initAffair(affair);
    initAction(affair);
  }
  /**
   * �������������s�Ȃ��܂��B
   * @param affair �Ɩ����
   * @throws Exception ������O
   */
  protected void initAction(ACAffairInfo affair) throws Exception {
    // ����ʓW�J���̏����ݒ�
    // ���n��l�̐ݒ�
    // �@�n��p�����[�^�����ɁA���L�̒l��ݒ肷��B
    // �@�@���t
    // �@�@�J�n����
    // �@�@�I������
    // �@�@�T�[�r�X����
    // �@�@�P�ʐ�
    // �@�@�����z
    // ���l�̌v�Z
    // �@�u������P�ʐ��v�� (�P�ʐ�) - (�����z) ��ݒ肷��B
    // ����Ԑݒ�
    // �@������Ԃ̐ݒ���s���B
    setState_INIT_STATE();
    // �@�u�P�ʐ��v�Ɓu�����z�v�̒l���`�F�b�N����B
    // �@�@(�P�ʐ�) > (�����z)�̏ꍇ
    // �@�@�@�u����(adjust)�v�̃`�F�b�N���O���B
    // �@�@(�P�ʐ�) = (�����z)�̏ꍇ
    // �@�@�@�u����(adjust)�v�̃`�F�b�N��t����B
    // ���E�B���h�E�^�C�g���̐ݒ�
    // �@�Ɩ���񃌃R�[�h���擾����B
    QkanCommon.getAffairInfo(getDBManager(), "QS004", "0");
    // �@�E�B���h�E�^�C�g���ɁA�擾���R�[�h��KEY : WINDOW_TITLE��VALUE��ݒ肷��B

  }

  //�R���|�[�l���g�C�x���g

  /**
   * �u����/�����ύX�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected void serviceIndependenceActionPerformed(ActionEvent e) throws Exception{
    // ������/�����̕ύX����
    // �@�u����(serviceIndependence)�v�̒l���`�F�b�N����B
    // �@�@�`�F�b�N���t���Ă���ꍇ
    // �@�@�@�u�����z�v�Ɂu�P�ʐ��v�̒l��ݒ肷��B
    // �@�@�`�F�b�N���O��Ă���ꍇ
    // �@�@�@�������Ȃ�(�l�̕ύX�͍s��Ȃ�)�B
    // �@����/�����ύX���̏�Ԑݒ���s���B
    setExpenceState();


  }

  /**
   * �u�����z�ύX���`�F�b�N�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected void serviceAdjustUnitFocusLost(FocusEvent e) throws Exception{
    // �������z�ύX���̓��̓`�F�b�N�A�y�я�Ԑݒ�
    // �����̓`�F�b�N
    // �@�u�P�ʐ��v�Ɓu�����z�v�̒l���`�F�b�N����B
    // �@�@(�P�ʐ�) < (�����z)�̏ꍇ
    // �@�@�@�����ϐ�unitValue�𐶐����A�P�ʐ���ݒ肷��B
    String unitValue = null;
    // �@�@�@�����ϐ�choseiValue�𐶐����A�����z��ݒ肷��B
    String choseiValue = null;
    // �@�@�@�G���[���b�Z�[�W��\������BID = ERROR_OF_LESSER_DATE_RELATION
    QkanMessageList.getInstance().ERROR_OF_LESSER_DATE_RELATION("", unitValue, choseiValue);
    // �@�@�@serviceAdjustUnit�Ƀt�H�[�J�X�𓖂Ă�B
    // �@�@�@�����𔲂���B
    // �@�@(�P�ʐ�) > (�����z)�̏ꍇ
    // �@�@�@�u����(adjust)�v�̃`�F�b�N���O���B
    // �@�@�@�������p������B
    // �@�@(�P�ʐ�) = (�����z)�̏ꍇ
    // �@�@�@�u����(adjust)�v�̃`�F�b�N��t����B
    // �@�@�@�������p������B

  }

  /**
   * �u���菈���v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected void submitActionPerformed(ActionEvent e) throws Exception{
    // ���������菈��
    // �@���_�C�A���O�Ăяo�����ɁA�u�����z�v�u����t���O�v��Ԃ��A�_�C�A���O�����B

  }

  /**
   * �u�L�����Z���v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected void closeActionPerformed(ActionEvent e) throws Exception{
    // �������L�����Z������
    // �@���_�C�A���O�Ăяo�����ɁA�u�����z�v�u����t���O�v�͕Ԃ����A�_�C�A���O�����B

  }

  public static void main(String[] args) {
    //�f�t�H���g�f�o�b�O�N��
    ACFrame.getInstance().setFrameEventProcesser(new QkanFrameEventProcesser());
    ACFrame.debugStart(new ACAffairInfo(QS004.class.getName()));
  }

  //�����֐�

  /**
   * �u����/�����ύX���̏�Ԑݒ�v�Ɋւ��鏈�����s�Ȃ��܂��B
   * @throws Exception ������O
   */
  public void setExpenceState() throws Exception{
    // ������/�����ύX���̏�Ԑݒ�
    // �@�u�P�ʐ��v�Ɓu�����z�v�̒l���`�F�b�N����B
    // �@�@�������ꍇ
    // �@�@�@����p�̏�Ԑݒ���s���B
    setState_EXPENCE();
    // �@�@�������Ȃ��ꍇ
    // �@�@�@�����p�̏�Ԑݒ���s���B
    setState_ADJUST();

  }

}
