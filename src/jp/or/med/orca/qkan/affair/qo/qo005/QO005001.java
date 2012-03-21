
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
 * �쐬��: 2006/08/22  ���{�R���s���[�^�[������� �c���@���� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���̑��@�\ (O)
 * �v���Z�X �V�X�e���ݒ� (005)
 * �v���O���� �K��Ō�×{��̎����ҏW (QO005001)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qo.qo005;
import java.awt.event.ActionEvent;

import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.affair.QkanMessageList;

/**
 * �K��Ō�×{��̎����ҏW(QO005001) 
 */
public class QO005001 extends QO005001Event {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QO005001(){
  }

  //�R���|�[�l���g�C�x���g

  /**
   * �u�j�����ĕ���v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected void closeActionPerformed(ActionEvent e) throws Exception{
    // ���͓��e��j�����ĉ�ʂ����
    // �@��ʂ�j������B
      dispose();
  }

  /**
   * �u�ۑ����ĕ���v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected void okActionPerformed(ActionEvent e) throws Exception{
    // ���͓��e��ۑ����ĉ�ʂ����
      double val=ACCastUtilities.toDouble(getTax().getText(), -1);
      if(val<0){
    // �@����ŗ�(Tax)�������͂̏ꍇ
    // �@�@����ŗ��̖����̓��b�Z�[�W��\������B�����b�Z�[�WID = ERROR_OF_NEED_CHECK_FOR_INPUT
          QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT("����ŗ�");
    // �@�@�����𒆒f����B
          return;
      }
    // �@�m�肵������ŗ�(value)�ɏ���ŗ�(Tax)�̓��e��ݒ肷��B
      setValue(val);
    // �@��ʂ�j������B
      dispose();

  }

  public static void main(String[] args) {
    //�f�t�H���g�f�o�b�O�N��
    ACFrame.getInstance().setFrameEventProcesser(new QkanFrameEventProcesser());
    QkanCommon.debugInitialize();
    VRMap param = new VRHashMap();
    //param�ɓn��p�����^���l�߂Ď��s���邱�ƂŁA�ȈՃf�o�b�O���\�ł��B
    ACFrame.debugStart(new ACAffairInfo(QO005001.class.getName(), param));
  }

  //�����֐�

  /**
   * �u�����ݒ�v�Ɋւ��鏈�����s�Ȃ��܂��B
   * @throws Exception ������O
   */
  public double showModal(double nowValue) throws Exception{
    // ��ʂ�\������B
    // �@�E�B���h�E�^�C�g����ݒ肷��B
      setAffairTitle("QO005001");
    // �@�����̏���ŗ�������ϐ�value�ɑޔ�����B
      setValue(nowValue);
    // �@����ŗ�(Tax)�ɓ����ϐ�value�̒l��ݒ肷��B
      getTax().setText(ACCastUtilities.toString(nowValue));
    // �@��ʂ����[�_���\������B
      setVisible(true);
    // �@�m�肵������ŗ�(value)��Ԃ��B
return getValue();
  }

}
