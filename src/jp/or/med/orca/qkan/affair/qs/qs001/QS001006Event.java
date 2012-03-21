
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
 * �쐬��: 2006/02/14  ���{�R���s���[�^�[������� �� ���� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �\��Ǘ� (S)
 * �v���Z�X �T�[�r�X�\�� (001)
 * �v���O���� ����E������� (QS001029)
 *
 *****************************************************************
 */

package jp.or.med.orca.qkan.affair.qs.qs001;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import jp.nichicom.ac.ACCommon;
import jp.nichicom.ac.component.event.ACFollowContainerFormatEventListener;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRMap;

/**
 * ����E������ʃC�x���g��`(QS001029) 
 */
@SuppressWarnings("serial")
public abstract class QS001006Event extends QS001006State {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001006Event(){
    addEvents();
  }
  /**
   * �C�x���g�����������`���܂��B
   */
  protected void addEvents() {
    getServiceIndependence().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                serviceIndependenceActionPerformed(e);
            }catch(Exception ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getServiceAdjustUnit().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                serviceAdjustUnitFocusLost(e);
            }catch(Exception ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getSubmit().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                submitActionPerformed(e);
            }catch(Exception ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
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
   * �u����/�����ύX�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void serviceIndependenceActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u�����z�ύX���`�F�b�N�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void serviceAdjustUnitFocusLost(FocusEvent e) throws Exception;

  /**
   * �u���菈���v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void submitActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u�L�����Z���v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void closeActionPerformed(ActionEvent e) throws Exception;

  //�ϐ���`

  private VRMap values = new VRHashMap();
  private boolean applied = false;
  private ACFollowContainerFormatEventListener adjustUnitBackgroundChanger;
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

  /**
   * adjustUnitBackgroundChanger��Ԃ��܂��B
   * @return adjustUnitBackgroundChanger
   */
  protected ACFollowContainerFormatEventListener getAdjustUnitBackgroundChanger(){
    return adjustUnitBackgroundChanger;
  }
  /**
   * adjustUnitBackgroundChanger��ݒ肵�܂��B
   * @param adjustUnitBackgroundChanger adjustUnitBackgroundChanger
   */
  protected void setAdjustUnitBackgroundChanger(ACFollowContainerFormatEventListener adjustUnitBackgroundChanger){
    this.adjustUnitBackgroundChanger = adjustUnitBackgroundChanger;
  }

  //�����֐�

  /**
   * �u�����ݒ�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @param serviceData VRMap
   * @param serviceMaster VRMap
   * @param provider VRMap
   * @param managementTotal int
   * @throws Exception ������O
   * @return boolean
   */
  public abstract boolean showModal(VRMap serviceData, VRMap serviceMaster, VRMap provider, int managementTotal) throws Exception;

  /**
   * �u����/�����ύX���̏�Ԑݒ�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   *
   */
  public abstract void setExpenceState() throws Exception;

  /**
   * �u�������ʔ���v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   * @return int
   */
  public abstract int getAdjustResult() throws Exception;

}
