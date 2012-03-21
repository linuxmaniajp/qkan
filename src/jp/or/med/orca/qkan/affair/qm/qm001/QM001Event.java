
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
 * �쐬��: 2006/03/11  ���{�R���s���[�^�[������� �� ���� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���j���[ (M)
 * �v���Z�X ���O�C����� (001)
 * �v���O���� ���O�C����� (QM001)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qm.qm001;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import jp.nichicom.ac.ACCommon;

/**
 * ���O�C����ʃC�x���g��`(QM001) 
 */
public abstract class QM001Event extends QM001SQL {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QM001Event(){
    addEvents();
  }
  /**
   * �C�x���g�����������`���܂��B
   */
  protected void addEvents() {
    getShowVersion().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                showVersionActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getStart().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                startActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getEnd().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                endActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getGoSetting1().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                goSetting1ActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getGoSetting2().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                goSetting2ActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getGoProvider().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                goProviderActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getGoInsurer().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                goInsurerActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getGoPatient().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                goPatientActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getGoSetting3().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                goSetting3ActionPerformed(e);
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
   * �u�o�[�W�������\���v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void showVersionActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u���O�C�������v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void startActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u�I�������v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void endActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u�ݒ�ύX��ʑJ�ځv�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void goSetting1ActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u�ݒ�ύX��ʑJ�ځv�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void goSetting2ActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u���Ə��o�^��ʑJ�ځv�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void goProviderActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u�ی��ғo�^��ʑJ�ځv�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void goInsurerActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u���p�ғo�^��ʑJ�ځv�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void goPatientActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u�ݒ�ύX��ʑJ�ځv�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void goSetting3ActionPerformed(ActionEvent e) throws Exception;

  //�ϐ���`

  //getter/setter

}
