
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
 * �쐬��: 2009/03/27  ���{�R���s���[�^�[������� �c���@���� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �\��Ǘ� (S)
 * �v���Z�X �T�[�r�X�\�� (001)
 * �v���O���� �W�v���׉�� (QS001030)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import jp.nichicom.ac.ACCommon;
import jp.nichicom.ac.lib.care.claim.print.schedule.CareServiceCodeCalcurater;
import jp.nichicom.ac.lib.care.claim.print.schedule.CareServiceUnitCalcurateResult;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;

/**
 * �W�v���׉�ʃC�x���g��`(QS001030) 
 */
@SuppressWarnings("serial")
public abstract class QS001005Event extends QS001005SQL {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001005Event(){
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
   * �u����v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void closeActionPerformed(ActionEvent e) throws Exception;

  //�ϐ���`

  //getter/setter

  //�����֐�

  /**
   * �u�����ݒ�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @param inLimitAmout CareServiceUnitCalcurateResult
   * @param insureInfo VRMap
   * @param procesType int
   * @param calcurater, VRList services CareServiceCodeCalcurater
   * @throws Exception ������O
   *
   */
  public abstract void showModal(CareServiceUnitCalcurateResult inLimitAmout, VRMap insureInfo, int procesType, CareServiceCodeCalcurater calcurater, VRList services) throws Exception;

  /**
   * �u���p�ҕ��S�z�T�Z�Z�o�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @param calcurater CareServiceCodeCalcurater
   * @param services VRList
   * @param inLimitAmout CareServiceUnitCalcurateResult
   * @param outLimitAmout CareServiceUnitCalcurateResult
   * @throws Exception ������O
   *
   */
  public abstract void checkInLimitAmount(CareServiceCodeCalcurater calcurater, VRList services, CareServiceUnitCalcurateResult inLimitAmout, CareServiceUnitCalcurateResult outLimitAmout) throws Exception;

}
