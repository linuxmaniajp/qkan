
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
 * �J����: ��i�@�a�P
 * �쐬��: 2016/12/08  ���{�R���s���[�^�[������� ��i�@�a�P �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �����f�[�^�쐬 (P)
 * �v���Z�X �m�F�E�C�� (003)
 * �v���O���� ���p�Ҍ��������ڍוҏW (QP003)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qp.qp003;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.Date;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import jp.nichicom.ac.ACCommon;
import jp.nichicom.ac.component.ACComboBox;
import jp.nichicom.ac.component.ACTextField;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.sql.ACPassiveKey;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;

/**
 * ���p�Ҍ��������ڍוҏW�C�x���g��`(QP003) 
 */
public abstract class QP003Event extends QP003SQL {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QP003Event(){
    addEvents();
  }
  /**
   * �C�x���g�����������`���܂��B
   */
  protected void addEvents() {
    getInsert().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                insertActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getUpdate().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                updateActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getOpen().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                openActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getContentJikohutanUse1().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                contentJikohutanUse1FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getContentJikohutanUse2().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                contentJikohutanUse2FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getContentJikohutanUse3().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                contentJikohutanUse3FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getContentEtcUse1().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                contentEtcUse1FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getContentEtcUse2().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                contentEtcUse2FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getContentEtcUse3().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                contentEtcUse3FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getContentEtcUse4().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                contentEtcUse4FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getContentEtcUse5().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                contentEtcUse5FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getContentEtcUse6().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                contentEtcUse6FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getContentEtcUnit1().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                contentEtcUnit1FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getContentEtcCount1().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                contentEtcCount1FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getContentEtcUnit2().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                contentEtcUnit2FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getContentEtcCount2().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                contentEtcCount2FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getContentEtcUnit3().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                contentEtcUnit3FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getContentEtcCount3().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                contentEtcCount3FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getContentEtcUnit4().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                contentEtcUnit4FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getContentEtcCount4().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                contentEtcCount4FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getContentEtcUnit5().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                contentEtcUnit5FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getContentEtcCount5().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                contentEtcCount5FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getContentEtcUnit6().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                contentEtcUnit6FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getContentEtcCount6().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                contentEtcCount6FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getTabs().addChangeListener(new ChangeListener(){
        private boolean lockFlag = false;
        public void stateChanged(ChangeEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                tabsStateChanged(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getKoujoDispCheck().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                koujoDispCheckActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getContentHokenIryoUse().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                contentHokenIryoUseFocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getContentHokenFukushiUse().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                contentHokenFukushiUseFocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getContentHokenIryoKoujoCheck().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                contentHokenIryoKoujoCheckActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getContentHokenFukushiKoujoCheck().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                contentHokenFukushiKoujoCheckActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getContentJikohutanKoujoCheck1().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                contentJikohutanKoujoCheck1ActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getContentJikohutanKoujoCheck2().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                contentJikohutanKoujoCheck2ActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getContentJikohutanKoujoCheck3().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                contentJikohutanKoujoCheck3ActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getContentEtcKoujoCheck1().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                contentEtcKoujoCheck1ActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getContentEtcKoujoCheck2().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                contentEtcKoujoCheck2ActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getContentEtcKoujoCheck3().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                contentEtcKoujoCheck3ActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getContentEtcKoujoCheck4().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                contentEtcKoujoCheck4ActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getContentEtcKoujoCheck5().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                contentEtcKoujoCheck5ActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getContentEtcKoujoCheck6().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                contentEtcKoujoCheck6ActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getReflection().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                reflectionActionPerformed(e);
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
   * �uDB�o�^�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void insertActionPerformed(ActionEvent e) throws Exception;

  /**
   * �uDB�o�^�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void updateActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u���߂̖K��Ō�v�揑���̓Ǎ��v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void openActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u���v���z�̌v�Z�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void contentJikohutanUse1FocusLost(FocusEvent e) throws Exception;

  /**
   * �u���v���z�̌v�Z�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void contentJikohutanUse2FocusLost(FocusEvent e) throws Exception;

  /**
   * �u���v���z�̌v�Z�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void contentJikohutanUse3FocusLost(FocusEvent e) throws Exception;

  /**
   * �u���v���z�̌v�Z�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void contentEtcUse1FocusLost(FocusEvent e) throws Exception;

  /**
   * �u���v���z�̌v�Z�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void contentEtcUse2FocusLost(FocusEvent e) throws Exception;

  /**
   * �u���v���z�̌v�Z�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void contentEtcUse3FocusLost(FocusEvent e) throws Exception;

  /**
   * �u���v���z�̌v�Z�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void contentEtcUse4FocusLost(FocusEvent e) throws Exception;

  /**
   * �u���v���z�̌v�Z�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void contentEtcUse5FocusLost(FocusEvent e) throws Exception;

  /**
   * �u���v���z�̌v�Z�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void contentEtcUse6FocusLost(FocusEvent e) throws Exception;

  /**
   * �u���z�Z�o�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void contentEtcUnit1FocusLost(FocusEvent e) throws Exception;

  /**
   * �u���z�Z�o�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void contentEtcCount1FocusLost(FocusEvent e) throws Exception;

  /**
   * �u���z�Z�o�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void contentEtcUnit2FocusLost(FocusEvent e) throws Exception;

  /**
   * �u���z�Z�o�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void contentEtcCount2FocusLost(FocusEvent e) throws Exception;

  /**
   * �u���z�Z�o�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void contentEtcUnit3FocusLost(FocusEvent e) throws Exception;

  /**
   * �u���z�Z�o�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void contentEtcCount3FocusLost(FocusEvent e) throws Exception;

  /**
   * �u���z�Z�o�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void contentEtcUnit4FocusLost(FocusEvent e) throws Exception;

  /**
   * �u���z�Z�o�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void contentEtcCount4FocusLost(FocusEvent e) throws Exception;

  /**
   * �u���z�Z�o�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void contentEtcUnit5FocusLost(FocusEvent e) throws Exception;

  /**
   * �u���z�Z�o�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void contentEtcCount5FocusLost(FocusEvent e) throws Exception;

  /**
   * �u���z�Z�o�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void contentEtcUnit6FocusLost(FocusEvent e) throws Exception;

  /**
   * �u���z�Z�o�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void contentEtcCount6FocusLost(FocusEvent e) throws Exception;

  /**
   * �u�T�[�r�X�񋟓��^�u�N���b�N�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void tabsStateChanged(ChangeEvent e) throws Exception;

  /**
   * �u��Ô�T���⏕�̐���v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void koujoDispCheckActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u��Ô�T�����z�Z�o�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void contentHokenIryoUseFocusLost(FocusEvent e) throws Exception;

  /**
   * �u��Ô�T�����z�Z�o�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void contentHokenFukushiUseFocusLost(FocusEvent e) throws Exception;

  /**
   * �u��Ô�T�����z�Z�o�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void contentHokenIryoKoujoCheckActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u��Ô�T�����z�Z�o�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void contentHokenFukushiKoujoCheckActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u��Ô�T�����z�Z�o�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void contentJikohutanKoujoCheck1ActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u��Ô�T�����z�Z�o�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void contentJikohutanKoujoCheck2ActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u��Ô�T�����z�Z�o�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void contentJikohutanKoujoCheck3ActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u��Ô�T�����z�Z�o�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void contentEtcKoujoCheck1ActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u��Ô�T�����z�Z�o�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void contentEtcKoujoCheck2ActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u��Ô�T�����z�Z�o�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void contentEtcKoujoCheck3ActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u��Ô�T�����z�Z�o�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void contentEtcKoujoCheck4ActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u��Ô�T�����z�Z�o�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void contentEtcKoujoCheck5ActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u��Ô�T�����z�Z�o�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void contentEtcKoujoCheck6ActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u��Ô�T�����z���f�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void reflectionActionPerformed(ActionEvent e) throws Exception;

  //�ϐ���`

  private ACPassiveKey PASSIVE_CHECK_KEY;
  public static final int STYLE_TYPE_CLAIM_FOR_PATIENT = 30101;
  public static final int CATEGORY_NO_CLAIM_FOR_PATIENT = 16;
  public static final Date DATE_20070401 = ACCastUtilities.toDate("2007/04/01", null);
  private int patientId;
  private int listIndex;
  private int sum;
  private int claimId;
  private int dataFlg;
  private int processMode;
  private String providerId;
  private String insurerId;
  private String insuredId;
  private String serviceKind;
  private Date targetDate;
  private Date claimDate;
  private VRList claimList = new VRArrayList();
  private VRList comboSet1 = new VRArrayList();
  private VRList comboSet2 = new VRArrayList();
  private VRMap modelMap = new VRHashMap();
  private VRMap sourceMap = new VRHashMap();
  private VRMap snapShotMap = new VRHashMap();
  //getter/setter

  /**
   * PASSIVE_CHECK_KEY��Ԃ��܂��B
   * @return PASSIVE_CHECK_KEY
   */
  protected ACPassiveKey getPASSIVE_CHECK_KEY(){
    return PASSIVE_CHECK_KEY;
  }
  /**
   * PASSIVE_CHECK_KEY��ݒ肵�܂��B
   * @param PASSIVE_CHECK_KEY PASSIVE_CHECK_KEY
   */
  protected void setPASSIVE_CHECK_KEY(ACPassiveKey PASSIVE_CHECK_KEY){
    this.PASSIVE_CHECK_KEY = PASSIVE_CHECK_KEY;
  }

  /**
   * patientId��Ԃ��܂��B
   * @return patientId
   */
  protected int getPatientId(){
    return patientId;
  }
  /**
   * patientId��ݒ肵�܂��B
   * @param patientId patientId
   */
  protected void setPatientId(int patientId){
    this.patientId = patientId;
  }

  /**
   * listIndex��Ԃ��܂��B
   * @return listIndex
   */
  protected int getListIndex(){
    return listIndex;
  }
  /**
   * listIndex��ݒ肵�܂��B
   * @param listIndex listIndex
   */
  protected void setListIndex(int listIndex){
    this.listIndex = listIndex;
  }

  /**
   * sum��Ԃ��܂��B
   * @return sum
   */
  protected int getSum(){
    return sum;
  }
  /**
   * sum��ݒ肵�܂��B
   * @param sum sum
   */
  protected void setSum(int sum){
    this.sum = sum;
  }

  /**
   * claimId��Ԃ��܂��B
   * @return claimId
   */
  protected int getClaimId(){
    return claimId;
  }
  /**
   * claimId��ݒ肵�܂��B
   * @param claimId claimId
   */
  protected void setClaimId(int claimId){
    this.claimId = claimId;
  }

  /**
   * dataFlg��Ԃ��܂��B
   * @return dataFlg
   */
  protected int getDataFlg(){
    return dataFlg;
  }
  /**
   * dataFlg��ݒ肵�܂��B
   * @param dataFlg dataFlg
   */
  protected void setDataFlg(int dataFlg){
    this.dataFlg = dataFlg;
  }

  /**
   * processMode��Ԃ��܂��B
   * @return processMode
   */
  protected int getProcessMode(){
    return processMode;
  }
  /**
   * processMode��ݒ肵�܂��B
   * @param processMode processMode
   */
  protected void setProcessMode(int processMode){
    this.processMode = processMode;
  }

  /**
   * providerId��Ԃ��܂��B
   * @return providerId
   */
  protected String getProviderId(){
    return providerId;
  }
  /**
   * providerId��ݒ肵�܂��B
   * @param providerId providerId
   */
  protected void setProviderId(String providerId){
    this.providerId = providerId;
  }

  /**
   * insurerId��Ԃ��܂��B
   * @return insurerId
   */
  protected String getInsurerId(){
    return insurerId;
  }
  /**
   * insurerId��ݒ肵�܂��B
   * @param insurerId insurerId
   */
  protected void setInsurerId(String insurerId){
    this.insurerId = insurerId;
  }

  /**
   * insuredId��Ԃ��܂��B
   * @return insuredId
   */
  protected String getInsuredId(){
    return insuredId;
  }
  /**
   * insuredId��ݒ肵�܂��B
   * @param insuredId insuredId
   */
  protected void setInsuredId(String insuredId){
    this.insuredId = insuredId;
  }

  /**
   * serviceKind��Ԃ��܂��B
   * @return serviceKind
   */
  protected String getServiceKind(){
    return serviceKind;
  }
  /**
   * serviceKind��ݒ肵�܂��B
   * @param serviceKind serviceKind
   */
  protected void setServiceKind(String serviceKind){
    this.serviceKind = serviceKind;
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

  /**
   * claimDate��Ԃ��܂��B
   * @return claimDate
   */
  protected Date getClaimDate(){
    return claimDate;
  }
  /**
   * claimDate��ݒ肵�܂��B
   * @param claimDate claimDate
   */
  protected void setClaimDate(Date claimDate){
    this.claimDate = claimDate;
  }

  /**
   * claimList��Ԃ��܂��B
   * @return claimList
   */
  protected VRList getClaimList(){
    return claimList;
  }
  /**
   * claimList��ݒ肵�܂��B
   * @param claimList claimList
   */
  protected void setClaimList(VRList claimList){
    this.claimList = claimList;
  }

  /**
   * comboSet1��Ԃ��܂��B
   * @return comboSet1
   */
  protected VRList getComboSet1(){
    return comboSet1;
  }
  /**
   * comboSet1��ݒ肵�܂��B
   * @param comboSet1 comboSet1
   */
  protected void setComboSet1(VRList comboSet1){
    this.comboSet1 = comboSet1;
  }

  /**
   * comboSet2��Ԃ��܂��B
   * @return comboSet2
   */
  protected VRList getComboSet2(){
    return comboSet2;
  }
  /**
   * comboSet2��ݒ肵�܂��B
   * @param comboSet2 comboSet2
   */
  protected void setComboSet2(VRList comboSet2){
    this.comboSet2 = comboSet2;
  }

  /**
   * modelMap��Ԃ��܂��B
   * @return modelMap
   */
  protected VRMap getModelMap(){
    return modelMap;
  }
  /**
   * modelMap��ݒ肵�܂��B
   * @param modelMap modelMap
   */
  protected void setModelMap(VRMap modelMap){
    this.modelMap = modelMap;
  }

  /**
   * sourceMap��Ԃ��܂��B
   * @return sourceMap
   */
  protected VRMap getSourceMap(){
    return sourceMap;
  }
  /**
   * sourceMap��ݒ肵�܂��B
   * @param sourceMap sourceMap
   */
  protected void setSourceMap(VRMap sourceMap){
    this.sourceMap = sourceMap;
  }

  /**
   * snapShotMap��Ԃ��܂��B
   * @return snapShotMap
   */
  protected VRMap getSnapShotMap(){
    return snapShotMap;
  }
  /**
   * snapShotMap��ݒ肵�܂��B
   * @param snapShotMap snapShotMap
   */
  protected void setSnapShotMap(VRMap snapShotMap){
    this.snapShotMap = snapShotMap;
  }

  //�����֐�

  /**
   * �u�f�[�^�擾�A��ʓW�J�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   *
   */
  public abstract void doFind() throws Exception;

  /**
   * �u���p�Ҍ��������ڍ׏����擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   *
   */
  public abstract void doFindClaimForPatient() throws Exception;

  /**
   * �u���v���z�̌v�Z�����v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   *
   */
  public abstract void calcSum() throws Exception;

  /**
   * �u�ۑ������v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   * @return boolean
   */
  public abstract boolean doSave() throws Exception;

  /**
   * �u��ʃf�[�^�`�F�b�N�E�ҏW�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   *
   */
  public abstract void doCheckInput() throws Exception;

  /**
   * �u���̓f�[�^�̒l���`�F�b�N����B�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @param himokuCombo ACComboBox
   * @param jikohutanText ACTextField
   * @param unitText ACTextField
   * @param countText ACTextField
   * @throws Exception ������O
   *
   */
  public abstract void checkValue(ACComboBox himokuCombo, ACTextField jikohutanText, ACTextField unitText, ACTextField countText) throws Exception;

  /**
   * �u�R���{����ݒ肷��B�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   *
   */
  public abstract void comboInitialize() throws Exception;

  /**
   * �u���ڒP�ʂ̌v�Z�����v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @param unit ACTextField
   * @param count ACTextField
   * @param price ACTextField
   * @throws Exception ������O
   *
   */
  public abstract void doCalcUnitPrice(ACTextField unit, ACTextField count, ACTextField price) throws Exception;

  /**
   * �u�J�����_�[�����擾���܂��B�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   * @return VRMap
   */
  public abstract VRMap getCalenderBitData() throws Exception;

  /**
   * �u�J�����_�[�X�i�b�v�V���b�g�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   *
   */
  public abstract void calenderSnapShot() throws Exception;

  /**
   * �u�J�����_�[�ύX�`�F�b�N�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   * @return boolean
   */
  public abstract boolean calenderIsModified() throws Exception;

  /**
   * �u��Ô�T���v�Z�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   *
   */
  public abstract void calcKoujoPrice() throws Exception;

}
