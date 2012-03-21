
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
 * �쐬��: 2006/03/20  ���{�R���s���[�^�[������� �� ���� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �\��Ǘ� (S)
 * �v���Z�X �T�[�r�X�\�� (001)
 * �v���O���� �T�ԕ\ (QS001001)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.util.Date;

import javax.swing.ListCellRenderer;
import javax.swing.event.ListSelectionListener;

import jp.nichicom.ac.ACCommon;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;

/**
 * �T�ԕ\�C�x���g��`(QS001001) 
 */
public abstract class QS001001Event extends QS001001State {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001001Event(){
    addEvents();
  }
  /**
   * �C�x���g�����������`���܂��B
   */
  protected void addEvents() {
    getTimeButton().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                timeButtonActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getExceptionButton().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                exceptionButtonActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getEverydayButton().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                everydayButtonActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getExpansionButton().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                expansionButtonActionPerformed(e);
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
   * �u�T�[�r�X�̐ݒ�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void timeButtonActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u�T�[�r�X�̐ݒ�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void exceptionButtonActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u�T�[�r�X�̐ݒ�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void everydayButtonActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u���ԕ\�ւ̓W�J�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void expansionButtonActionPerformed(ActionEvent e) throws Exception;

  //�ϐ���`

  private QS001 ownerAffair;
  public static final String SERVICE_SPAN_BIND_PATH = "101";
  //getter/setter

  /**
   * ownerAffair��Ԃ��܂��B
   * @return ownerAffair
   */
  protected QS001 getOwnerAffair(){
    return ownerAffair;
  }
  /**
   * ownerAffair��ݒ肵�܂��B
   * @param ownerAffair ownerAffair
   */
  protected void setOwnerAffair(QS001 ownerAffair){
    this.ownerAffair = ownerAffair;
  }

  //�����֐�

  /**
   * �u��ʏ������v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @param ownerAffair QS001
   * @throws Exception ������O
   *
   */
  public abstract void initialize(QS001 ownerAffair) throws Exception;

  /**
   * �u����`�F�b�N�{�b�N�X��Enabled�ݒ�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @param enabled boolean
   * @throws Exception ������O
   *
   */
  public abstract void setDailylifeCheckEnabled(boolean enabled) throws Exception;

  /**
   * �u�쐬�N�����̎擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   * @return Date
   */
  public abstract Date getCreateDateValue() throws Exception;

  /**
   * �u�Ώ۔N����ݒ�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @param targetDate Date
   * @throws Exception ������O
   *
   */
  public abstract void setTargetDate(Date targetDate) throws Exception;

  /**
   * �u�T�[�r�X�`��p�̃Z�������_���ݒ�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @param renderer ListCellRenderer
   * @throws Exception ������O
   *
   */
  public abstract void setCellRenderer(ListCellRenderer renderer) throws Exception;

  /**
   * �u�T�[�r�X�}�X�^�ݒ�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @param serviceMaster VRMap
   * @throws Exception ������O
   *
   */
  public abstract void setMasterService(VRMap serviceMaster) throws Exception;

  /**
   * �u�X�P�W���[���S�̂�ݒ�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @param schedules VRList
   * @throws Exception ������O
   *
   */
  public abstract void setSchedule(VRList schedules) throws Exception;

  /**
   * �u�X�P�W���[���S�̂��擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   * @return VRList
   */
  public abstract VRList getSchedule() throws Exception;

  /**
   * �u���X�g�I���C�x���g���X�i��ǉ��v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @param listener ListSelectionListener   *
   */
  public abstract void addListSelectionListener(ListSelectionListener listener);

  /**
   * �u���X�g�I���C�x���g���X�i��ǉ��v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @param listener KeyListener   *
   */
  public abstract void addKeyListener(KeyListener listener);

  /**
   * �u�X�P�W���[���������擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   * @return int
   */
  public abstract int getScheduleCount() throws Exception;

  /**
   * �u�X�P�W���[�����������v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   *
   */
  public abstract void clearSchedule() throws Exception;

  /**
   * �u�J�n���Ɗ��Ԃ�ݒ�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @param service VRMap
   * @throws Exception ������O
   *
   */
  public abstract void setServiceSpan(VRMap service) throws Exception;

  /**
   * �u�T�P�ʈȊO�̃T�[�r�X��ݒ�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @param schedules VRList
   * @throws Exception ������O
   *
   */
  public abstract void setFreedaySchedule(VRList schedules) throws Exception;

  /**
   * �u�T�P�ʈȊO�̃T�[�r�X���擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   * @return VRList
   */
  public abstract VRList getAllFreedaySchedule() throws Exception;

  /**
   * �u�T�P�ʂ̃T�[�r�X���擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   * @return VRList
   */
  public abstract VRList getAllWeeklySchedule() throws Exception;

  /**
   * �u�T�ԕ\�̃��X�g�ł��邩�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @param list QS001DaySchedule
   * @throws Exception ������O
   * @return boolean
   */
  public abstract boolean isWeeklyServiceList(QS001DaySchedule list) throws Exception;

  /**
   * �u��ȓ��퐶����̊�����\�����X�g�ł��邩�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @param list QS001DaySchedule
   * @throws Exception ������O
   * @return boolean
   */
  public abstract boolean isDailyServiceList(QS001DaySchedule list) throws Exception;

}
