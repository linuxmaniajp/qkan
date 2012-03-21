
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
 * �쐬��: 2006/02/01  ���{�R���s���[�^�[������� ����@��F �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �o�[�W������� (V)
 * �v���Z�X �o�[�W������� (001)
 * �v���O���� �o�[�W������� (QV001)
 *
 *****************************************************************
 */

package jp.or.med.orca.qkan.affair.qv.qv001;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import jp.nichicom.ac.ACCommon;

/**
 * �o�[�W�������C�x���g��`(QV001) 
 */
public abstract class QV001Event extends QV001Design {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QV001Event(){
    addEvents();
  }
  /**
   * �C�x���g�����������`���܂��B
   */
  protected void addEvents() {
    getClose().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                closeActionPerformed(e);
            }catch(Exception ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });

  }
  //�R���|�[�l���g�C�x���g

  /**
   * �u�I�������v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void closeActionPerformed(ActionEvent e) throws Exception;

  //�ϐ���`

  private String dataVersion;
  //getter/setter

  /**
   * dataVersion��Ԃ��܂��B
   * @return dataVersion
   */
  protected String getDataVersion(){
    return dataVersion;
  }
  /**
   * dataVersion��ݒ肵�܂��B
   * @param dataVersion dataVersion
   */
  protected void setDataVersion(String dataVersion){
    this.dataVersion = dataVersion;
  }

}
