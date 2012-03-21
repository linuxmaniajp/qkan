
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
 * �쐬��: 2009/07/09  ���{�R���s���[�^�[������� ����@��F �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���уf�[�^�쐬 (P)
 * �v���Z�X ���׏��ڍוҏW (005)
 * �v���O���� ����f�Ô�R�[�h�ǉ� (QP005001)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qp.qp005;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.Date;

import jp.nichicom.ac.ACCommon;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRMap;

/**
 * ����f�Ô�R�[�h�ǉ��C�x���g��`(QP005001) 
 */
public abstract class QP005001Event extends QP005001SQL {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QP005001Event(){
    addEvents();
  }
  /**
   * �C�x���g�����������`���܂��B
   */
  protected void addEvents() {
    getAddButton().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                addButtonActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getCancelButton().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                cancelButtonActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getServiceCodeDetailText().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                serviceCodeDetailTextFocusLost(e);
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
   * �u�ǉ��v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void addButtonActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u�L�����Z���v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void cancelButtonActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u�T�[�r�X�R�[�h�ϊ��v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void serviceCodeDetailTextFocusLost(FocusEvent e) throws Exception;

  //�ϐ���`

  private VRMap values = new VRHashMap();
  private boolean isAdd = false;
  private Date targetDate;
  //getter/setter

  /**
   * values��Ԃ��܂��B
   * @return values
   */
  protected VRMap getValues(){
    return values;
  }
  /**
   * values��ݒ肵�܂��B
   * @param values values
   */
  protected void setValues(VRMap values){
    this.values = values;
  }

  /**
   * isAdd��Ԃ��܂��B
   * @return isAdd
   */
  protected boolean getIsAdd(){
    return isAdd;
  }
  /**
   * isAdd��ݒ肵�܂��B
   * @param isAdd isAdd
   */
  protected void setIsAdd(boolean isAdd){
    this.isAdd = isAdd;
  }

  /**
   * targetDate��Ԃ��܂��B
   * @return targetDate
   */
  protected Date getTargetDate(){
    return targetDate;
  }
  /**
   * targetDate��ݒ肵�܂��B
   * @param targetDate targetDate
   */
  protected void setTargetDate(Date targetDate){
    this.targetDate = targetDate;
  }

  //�����֐�

  /**
   * �u�������v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @param targetDate Date
   * @throws Exception ������O
   *
   */
  public abstract void showModal(Date targetDate) throws Exception;

  /**
   * �u���̓`�F�b�N�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   * @return boolean
   */
  public abstract boolean isValidData() throws Exception;

  /**
   * �u�T�[�r�X�R�[�h���̒u�������v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   * @return boolean
   */
  public abstract boolean setServiceCode() throws Exception;

  /**
   * �u�T�[�r�X�R�[�h�`�F�b�N�����v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @param isMessageShow boolean
   * @throws Exception ������O
   * @return boolean
   */
  public abstract boolean checkServiceCode(boolean isMessageShow) throws Exception;

}
