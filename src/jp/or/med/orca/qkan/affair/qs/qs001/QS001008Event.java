
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
 * �쐬��: 2012/08/08  ���{�R���s���[�^�[������� ����@��F �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �T�[�r�X�\�� (S)
 * �v���Z�X �J�����_�[ (001)
 * �v���O���� ����f�Ô�E���ʗ×{��W�v (QS001008)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import jp.nichicom.ac.ACCommon;
import jp.nichicom.ac.util.adapter.ACTableModelAdapter;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;

/**
 * ����f�Ô�E���ʗ×{��W�v�C�x���g��`(QS001008) 
 */
public abstract class QS001008Event extends QS001008State {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001008Event(){
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
    getServiceCombo().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                serviceComboActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getTokubetsuTable().addListSelectionListener(new ListSelectionListener(){
        private boolean lockFlag = false;
        public void valueChanged(ListSelectionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                tokubetsuTableSelectionChanged(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getProviderCombo().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                providerComboActionPerformed(e);
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

  /**
   * �u�T�[�r�X��ރR���{�I���v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void serviceComboActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u����f�Ô�e�[�u���I���v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void tokubetsuTableSelectionChanged(ListSelectionEvent e) throws Exception;

  /**
   * �u���Ə��R���{�I�����v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void providerComboActionPerformed(ActionEvent e) throws Exception;

  //�ϐ���`

  private ACTableModelAdapter mainTableModel;
  private ACTableModelAdapter detailTableModel;
  private VRMap providerService = new VRHashMap();
  private VRMap providerDiagnosis = new VRHashMap();
  private Date targetDate;
  //getter/setter

  /**
   * mainTableModel��Ԃ��܂��B
   * @return mainTableModel
   */
  protected ACTableModelAdapter getMainTableModel(){
    return mainTableModel;
  }
  /**
   * mainTableModel��ݒ肵�܂��B
   * @param mainTableModel mainTableModel
   */
  protected void setMainTableModel(ACTableModelAdapter mainTableModel){
    this.mainTableModel = mainTableModel;
  }

  /**
   * detailTableModel��Ԃ��܂��B
   * @return detailTableModel
   */
  protected ACTableModelAdapter getDetailTableModel(){
    return detailTableModel;
  }
  /**
   * detailTableModel��ݒ肵�܂��B
   * @param detailTableModel detailTableModel
   */
  protected void setDetailTableModel(ACTableModelAdapter detailTableModel){
    this.detailTableModel = detailTableModel;
  }

  /**
   * providerService��Ԃ��܂��B
   * @return providerService
   */
  protected VRMap getProviderService(){
    return providerService;
  }
  /**
   * providerService��ݒ肵�܂��B
   * @param providerService providerService
   */
  protected void setProviderService(VRMap providerService){
    this.providerService = providerService;
  }

  /**
   * providerDiagnosis��Ԃ��܂��B
   * @return providerDiagnosis
   */
  protected VRMap getProviderDiagnosis(){
    return providerDiagnosis;
  }
  /**
   * providerDiagnosis��ݒ肵�܂��B
   * @param providerDiagnosis providerDiagnosis
   */
  protected void setProviderDiagnosis(VRMap providerDiagnosis){
    this.providerDiagnosis = providerDiagnosis;
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
   * �u�����ݒ�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @param Map> diagnosisDateMap Map<String,
   * @param targetDate Date
   * @throws Exception ������O
   *
   */
  public abstract void showModal(Map<String, Map> diagnosisDateMap, Date targetDate) throws Exception;

  /**
   * �u����f�Ô�E���ʗ×{��v�Z�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @param ArrayList<Map>> tokuteiMap Map<String,
   * @throws Exception ������O
   * @return VRList
   */
  public abstract VRList calcDiagnosis(Map<String, ArrayList<Map>> tokuteiMap) throws Exception;

}
