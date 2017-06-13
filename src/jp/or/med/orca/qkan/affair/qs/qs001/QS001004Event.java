
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
 * �쐬��: 2006/06/05  ���{�R���s���[�^�[������� �c���@���� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �\��Ǘ� (S)
 * �v���Z�X �T�[�r�X�\�� (001)
 * �v���O���� �v��P�ʐ��ҏW��� (QS001032)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import jp.nichicom.ac.ACCommon;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;

/**
 * �v��P�ʐ��ҏW��ʃC�x���g��`(QS001032) 
 */
@SuppressWarnings("serial")
public abstract class QS001004Event extends QS001004SQL {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001004Event(){
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
    getProvider().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                providerActionPerformed(e);
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
   * �u�j�����ĕ���v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void closeActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u�ۑ����ĕ���v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void okActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u�Ώێ��Ə��I���v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void providerActionPerformed(ActionEvent e) throws Exception;

  //�ϐ���`

  private VRList planUnitModelValue = new VRArrayList();
  private VRMap planUnits = new VRHashMap();
  private boolean applied = false;
  private String selectedProviderID;
  private Date targetDate; // H28.4�����Ή� add
  //getter/setter

  /**
   * planUnitModelValue��Ԃ��܂��B
   * @return planUnitModelValue
   */
  protected VRList getPlanUnitModelValue(){
    return planUnitModelValue;
  }
  /**
   * planUnitModelValue��ݒ肵�܂��B
   * @param planUnitModelValue planUnitModelValue
   */
  protected void setPlanUnitModelValue(VRList planUnitModelValue){
    this.planUnitModelValue = planUnitModelValue;
  }

  /**
   * planUnits��Ԃ��܂��B
   * @return planUnits
   */
  protected VRMap getPlanUnits(){
    return planUnits;
  }
  /**
   * planUnits��ݒ肵�܂��B
   * @param planUnits planUnits
   */
  protected void setPlanUnits(VRMap planUnits){
    this.planUnits = planUnits;
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
   * selectedProviderID��Ԃ��܂��B
   * @return selectedProviderID
   */
  protected String getSelectedProviderID(){
    return selectedProviderID;
  }
  /**
   * selectedProviderID��ݒ肵�܂��B
   * @param selectedProviderID selectedProviderID
   */
  protected void setSelectedProviderID(String selectedProviderID){
    this.selectedProviderID = selectedProviderID;
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
  public void setTargetDate(Date targetDate){
    this.targetDate = targetDate;
  }

  //�����֐�

  /**
   * �u�����ݒ�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @param planUnit VRMap
   * @throws Exception ������O
   * @return boolean
   */
  public abstract boolean showModal(VRMap planUnit) throws Exception;

  /**
   * �u���͒��̌v��P�ʐ��̎擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   * @return VRMap
   */
  public abstract VRMap getSelectedPlanUnits() throws Exception;

  /**
   * �u�m�肵���v��P�ʐ����擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   * @return VRMap
   */
  public abstract VRMap getAppliedValue() throws Exception;

}
