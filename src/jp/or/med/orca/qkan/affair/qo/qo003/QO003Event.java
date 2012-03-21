
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
 * �쐬��: 2006/06/01  ���{�R���s���[�^�[������� ����@��F �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���̑��@�\ (O)
 * �v���Z�X ���Ə��ꗗ (003)
 * �v���O���� ���Ə��ꗗ (QO003)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qo.qo003;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import jp.nichicom.ac.ACCommon;
import jp.nichicom.ac.sql.ACPassiveKey;
import jp.nichicom.ac.util.adapter.ACTableModelAdapter;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;

/**
 * ���Ə��ꗗ�C�x���g��`(QO003) 
 */
public abstract class QO003Event extends QO003SQL {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QO003Event(){
    addEvents();
  }
  /**
   * �C�x���g�����������`���܂��B
   */
  protected void addEvents() {
    getFind().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                findActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getDetail().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                detailActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
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
    getDelete().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                deleteActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getProviderTable().addMouseListener(new MouseAdapter(){
        private boolean lockFlag = false;
        public void mouseClicked(MouseEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                if (e.getClickCount() == 2) {
                    providerTableMouseClicked(e);
                }
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getPrint().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                printActionPerformed(e);
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
   * �u���������v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void findActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u���Ə��o�^��ʂɑJ�ځi�X�V�j�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void detailActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u���Ə��o�^��ʂɑJ�ځi�o�^�j�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void insertActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u�폜�����v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void deleteActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u�ڍ׉�ʑJ�ځv�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void providerTableMouseClicked(MouseEvent e) throws Exception;

  /**
   * �u����v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void printActionPerformed(ActionEvent e) throws Exception;

  //�ϐ���`

  private ACPassiveKey PROVIDER_PASSIVE_CHECK_KEY;
  private int providerDeleteFlg = 0;
  private String providerId;
  private String deleteErrorMsg;
  private VRMap affairMap = new VRHashMap();
  private VRMap staffMap = new VRHashMap();
  private VRList providerList = new VRArrayList();
  private ACTableModelAdapter providerTableModel;
  //getter/setter

  /**
   * PROVIDER_PASSIVE_CHECK_KEY��Ԃ��܂��B
   * @return PROVIDER_PASSIVE_CHECK_KEY
   */
  protected ACPassiveKey getPROVIDER_PASSIVE_CHECK_KEY(){
    return PROVIDER_PASSIVE_CHECK_KEY;
  }
  /**
   * PROVIDER_PASSIVE_CHECK_KEY��ݒ肵�܂��B
   * @param PROVIDER_PASSIVE_CHECK_KEY PROVIDER_PASSIVE_CHECK_KEY
   */
  protected void setPROVIDER_PASSIVE_CHECK_KEY(ACPassiveKey PROVIDER_PASSIVE_CHECK_KEY){
    this.PROVIDER_PASSIVE_CHECK_KEY = PROVIDER_PASSIVE_CHECK_KEY;
  }

  /**
   * providerDeleteFlg��Ԃ��܂��B
   * @return providerDeleteFlg
   */
  protected int getProviderDeleteFlg(){
    return providerDeleteFlg;
  }
  /**
   * providerDeleteFlg��ݒ肵�܂��B
   * @param providerDeleteFlg providerDeleteFlg
   */
  protected void setProviderDeleteFlg(int providerDeleteFlg){
    this.providerDeleteFlg = providerDeleteFlg;
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
   * deleteErrorMsg��Ԃ��܂��B
   * @return deleteErrorMsg
   */
  protected String getDeleteErrorMsg(){
    return deleteErrorMsg;
  }
  /**
   * deleteErrorMsg��ݒ肵�܂��B
   * @param deleteErrorMsg deleteErrorMsg
   */
  protected void setDeleteErrorMsg(String deleteErrorMsg){
    this.deleteErrorMsg = deleteErrorMsg;
  }

  /**
   * affairMap��Ԃ��܂��B
   * @return affairMap
   */
  protected VRMap getAffairMap(){
    return affairMap;
  }
  /**
   * affairMap��ݒ肵�܂��B
   * @param affairMap affairMap
   */
  protected void setAffairMap(VRMap affairMap){
    this.affairMap = affairMap;
  }

  /**
   * staffMap��Ԃ��܂��B
   * @return staffMap
   */
  protected VRMap getStaffMap(){
    return staffMap;
  }
  /**
   * staffMap��ݒ肵�܂��B
   * @param staffMap staffMap
   */
  protected void setStaffMap(VRMap staffMap){
    this.staffMap = staffMap;
  }

  /**
   * providerList��Ԃ��܂��B
   * @return providerList
   */
  protected VRList getProviderList(){
    return providerList;
  }
  /**
   * providerList��ݒ肵�܂��B
   * @param providerList providerList
   */
  protected void setProviderList(VRList providerList){
    this.providerList = providerList;
  }

  /**
   * providerTableModel��Ԃ��܂��B
   * @return providerTableModel
   */
  protected ACTableModelAdapter getProviderTableModel(){
    return providerTableModel;
  }
  /**
   * providerTableModel��ݒ肵�܂��B
   * @param providerTableModel providerTableModel
   */
  protected void setProviderTableModel(ACTableModelAdapter providerTableModel){
    this.providerTableModel = providerTableModel;
  }

  //�����֐�

  /**
   * �u���Ə����擾�����v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   *
   */
  public abstract void doFind() throws Exception;

  /**
   * �u�X�^�b�t�����擾����v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   *
   */
  public abstract void doFindStaff() throws Exception;

  /**
   * �u�폜�����ۊm�F�����v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   * @return boolean
   */
  public abstract boolean doDeleteCheck() throws Exception;

  /**
   * �u�폜�����v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   * @return boolean
   */
  public abstract boolean doDelete() throws Exception;

  /**
   * �u���������v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   *
   */
  public abstract void doFindProvider() throws Exception;

  /**
   * �u���������ޔ��v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   *
   */
  public abstract void createFindState() throws Exception;

}
