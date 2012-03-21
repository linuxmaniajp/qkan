
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
 * �쐬��: 2010/11/05  ���{�R���s���[�^�[������� ����@��F �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �\��Ǘ� (S)
 * �v���Z�X �T�[�r�X�\�� (001)
 * �v���O���� ����f�Ô��� (QS001199_H2104)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import jp.nichicom.ac.ACCommon;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRMap;

/**
 * ����f�Ô��ʃC�x���g��`(QS001199_H2104) 
 */
@SuppressWarnings("serial")
public abstract class QS001S01_201204Event extends QS001S01_201204State {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001S01_201204Event(){
    addEvents();
  }
  /**
   * �C�x���g�����������`���܂��B
   */
  protected void addEvents() {
    getApply().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                applyActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getScienceTherapy1().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                scienceTherapy1ActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getScienceTherapy2().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                scienceTherapy2ActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getScience1().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                science1ActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getScience2().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                science2ActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getRehabilitationSystem1().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                rehabilitationSystem1ActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getWorkTherapy1().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                workTherapy1ActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getWork1().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                work1ActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getRehabilitationSystem2().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                rehabilitationSystem2ActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getLanguageTherapy1().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                languageTherapy1ActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getLanguage1().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                language1ActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getRehabilitationSystem3().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                rehabilitationSystem3ActionPerformed(e);
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
   * �u�ݒ�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void applyActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u���w�Ö@�i�h�j�̗L����ԕύX�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void scienceTherapy1ActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u���w�Ö@�i�h�h�j�̗L����ԕύX�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void scienceTherapy2ActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u���w�i�h�j�̗L����ԕύX�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void science1ActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u���w�i�h�h�j�̗L����ԕύX�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void science2ActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u���n�r���̐��������Z�̗L����ԕύX�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void rehabilitationSystem1ActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u��ƗÖ@I�̗L����ԕύX�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void workTherapy1ActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u���(I)�̗L����ԕύX�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void work1ActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u���n�r���̐��������Z�̗L����ԕύX�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void rehabilitationSystem2ActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u���꒮�o�Ö@�h�̗L����ԕύX�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void languageTherapy1ActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u���꒮�o(I)�̗L����ԕύX�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void language1ActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u���n�r���̐��������Z�̗L����ԕύX�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void rehabilitationSystem3ActionPerformed(ActionEvent e) throws Exception;

  //�ϐ���`

  private VRMap values = new VRHashMap();
  private boolean applied = false;
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
   * applied��Ԃ��܂��B
   * @return applied
   */
  protected boolean getApplied(){
    return applied;
  }
  /**
   * applied��ݒ肵�܂��B
   * @param applied applied
   */
  protected void setApplied(boolean applied){
    this.applied = applied;
  }

  //�����֐�

  /**
   * �u�������v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @param systemServiceKindDetail int
   * @param param VRMap
   * @throws Exception ������O
   * @return boolean
   */
  public abstract boolean showModal(int systemServiceKindDetail, VRMap param) throws Exception;

}
