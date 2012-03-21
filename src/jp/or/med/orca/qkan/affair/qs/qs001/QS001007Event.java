
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
 * �쐬��: 2007/12/17  ���{�R���s���[�^�[������� ����@��F �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �\��Ǘ� (S)
 * �v���Z�X �T�[�r�X�\�� (001)
 * �v���O���� �T�[�r�X�\�� (QS001033)
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
import jp.nichicom.ac.sql.ACDBManager;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRMap;

/**
 * �T�[�r�X�\��C�x���g��`(QS001033) 
 */
@SuppressWarnings("serial")
public abstract class QS001007Event extends QS001007Design {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001007Event(){
    addEvents();
  }
  /**
   * �C�x���g�����������`���܂��B
   */
  protected void addEvents() {
    getOkButton().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                okButtonActionPerformed(e);
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
    getAfterServiceText().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                afterServiceTextFocusLost(e);
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
   * �uok�{�^���������̏����v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void okButtonActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u�L�����Z���{�^���������̏����v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void cancelButtonActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u���X�g�t�H�[�J�X�C�x���g�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void afterServiceTextFocusLost(FocusEvent e) throws Exception;

  //�ϐ���`

  private VRMap changeData = new VRHashMap();
  private boolean entryType;
  private ACFollowContainerFormatEventListener afterServiceTextBackgroundChanger;
  //getter/setter

  /**
   * changeData��Ԃ��܂��B
   * @return changeData
   */
  protected VRMap getChangeData(){
    return changeData;
  }
  /**
   * changeData��ݒ肵�܂��B
   * @param changeData changeData
   */
  protected void setChangeData(VRMap changeData){
    this.changeData = changeData;
  }

  /**
   * entryType��Ԃ��܂��B
   * @return entryType
   */
  protected boolean getEntryType(){
    return entryType;
  }
  /**
   * entryType��ݒ肵�܂��B
   * @param entryType entryType
   */
  protected void setEntryType(boolean entryType){
    this.entryType = entryType;
  }

  /**
   * afterServiceTextBackgroundChanger��Ԃ��܂��B
   * @return afterServiceTextBackgroundChanger
   */
  protected ACFollowContainerFormatEventListener getAfterServiceTextBackgroundChanger(){
    return afterServiceTextBackgroundChanger;
  }
  /**
   * afterServiceTextBackgroundChanger��ݒ肵�܂��B
   * @param afterServiceTextBackgroundChanger afterServiceTextBackgroundChanger
   */
  protected void setAfterServiceTextBackgroundChanger(ACFollowContainerFormatEventListener afterServiceTextBackgroundChanger){
    this.afterServiceTextBackgroundChanger = afterServiceTextBackgroundChanger;
  }

  //�����֐�

  /**
   * �u��ʓW�J�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @param baseData VRMap
   * @param dbm ACDBManager
   * @throws Exception ������O
   *
   */
  public abstract void showModel(VRMap baseData, ACDBManager dbm) throws Exception;

  /**
   * �u���̓`�F�b�N�����v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   * @return boolean
   */
  public abstract boolean checkInputData() throws Exception;

  /**
   * �u�߂��ԕԋp�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   * @return boolean
   */
  public abstract boolean isPatternNameChange() throws Exception;

}
