
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
 * �J����: �����@�L
 * �쐬��: 2006/03/19  ���{�R���s���[�^�[������� �����@�L �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �������o�� (P)
 * �v���Z�X CSV�o�� (009)
 * �v���O���� �`���m�F (QP009)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qp.qp009;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import jp.nichicom.ac.ACCommon;

/**
 * �`���m�F�C�x���g��`(QP009) 
 */
public abstract class QP009Event extends QP009Design {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QP009Event(){
    addEvents();
  }
  /**
   * �C�x���g�����������`���܂��B
   */
  protected void addEvents() {
    getOk().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                okActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });

  }
  //�R���|�[�l���g�C�x���g

  /**
   * �uOK�������̏����v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void okActionPerformed(ActionEvent e) throws Exception;

  //�ϐ���`

  //getter/setter

  //�����֐�

  /**
   * �u�N�����C�x���g�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   *
   */
  public abstract void showModal() throws Exception;

}
