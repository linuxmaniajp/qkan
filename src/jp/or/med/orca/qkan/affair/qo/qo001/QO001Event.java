
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
 * �쐬��: 2006/01/22  ���{�R���s���[�^�[������� ����@��F �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���̑��@�\ (O)
 * �v���Z�X �ی��ҊǗ� (001)
 * �v���O���� �ی��҈ꗗ (QO001)
 *
 *****************************************************************
 */

package jp.or.med.orca.qkan.affair.qo.qo001;

import java.awt.*;
import java.awt.event.*;
import java.awt.im.*;
import java.io.*;
import java.sql.SQLException;
import java.text.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
import jp.nichicom.ac.*;
import jp.nichicom.ac.bind.*;
import jp.nichicom.ac.component.*;
import jp.nichicom.ac.component.dnd.*;
import jp.nichicom.ac.component.dnd.event.*;
import jp.nichicom.ac.component.event.*;
import jp.nichicom.ac.component.mainmenu.*;
import jp.nichicom.ac.component.table.*;
import jp.nichicom.ac.container.*;
import jp.nichicom.ac.core.*;
import jp.nichicom.ac.filechooser.*;
import jp.nichicom.ac.io.*;
import jp.nichicom.ac.lang.*;
import jp.nichicom.ac.pdf.*;
import jp.nichicom.ac.sql.*;
import jp.nichicom.ac.text.*;
import jp.nichicom.ac.util.*;
import jp.nichicom.ac.util.adapter.*;
import jp.nichicom.vr.*;
import jp.nichicom.vr.bind.*;
import jp.nichicom.vr.bind.event.*;
import jp.nichicom.vr.border.*;
import jp.nichicom.vr.component.*;
import jp.nichicom.vr.component.event.*;
import jp.nichicom.vr.component.table.*;
import jp.nichicom.vr.container.*;
import jp.nichicom.vr.focus.*;
import jp.nichicom.vr.image.*;
import jp.nichicom.vr.io.*;
import jp.nichicom.vr.layout.*;
import jp.nichicom.vr.text.*;
import jp.nichicom.vr.text.parsers.*;
import jp.nichicom.vr.util.*;
import jp.nichicom.vr.util.adapter.*;
import jp.nichicom.vr.util.logging.*;
import jp.or.med.orca.qkan.*;
import jp.or.med.orca.qkan.affair.*;
import jp.or.med.orca.qkan.component.*;
import jp.or.med.orca.qkan.lib.*;

/**
 * �ی��҈ꗗ�C�x���g��`(QO001) 
 */
public abstract class QO001Event extends QO001SQL {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QO001Event(){
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
            }catch(Exception ex){
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
            }catch(Exception ex){
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
            }catch(Exception ex){
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
            }catch(Exception ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getInsurerInfoTable().addListSelectionListener(new ListSelectionListener(){
        private boolean lockFlag = false;
        public void valueChanged(ListSelectionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                insurerInfoTableSelectionChanged(e);
            }catch(Exception ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getInsurerInfoTable().addMouseListener(new MouseAdapter(){
        private boolean lockFlag = false;
        public void mouseClicked(MouseEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                if (e.getClickCount() == 2) {
                    insurerInfoTableMouseClicked(e);
                }
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
   * �u���������v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void findActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u�ی��ғo�^��ʂɑJ�ځi�X�V�j�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void detailActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u�ی��ғo�^��ʂɑJ�ځi�V�K�j�v�C�x���g�ł��B
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
   * �u��ʐ���v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void insurerInfoTableSelectionChanged(ListSelectionEvent e) throws Exception;

  /**
   * �u��ʑJ�ڏ����v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void insurerInfoTableMouseClicked(MouseEvent e) throws Exception;

  //�ϐ���`

  private ACPassiveKey INSURER_INFO_PASSIVE_CHECK_KEY;
  private int PROCESS_MODE;
  private String insurerId;
  private VRMap affairMap = new VRHashMap();
  private VRList insurerInfoList = new VRArrayList();
  private VRList insurerLimitRateList = new VRArrayList();
  private VRList insurerLImitRateDetailList = new VRArrayList();
  private ACTableModelAdapter insurerInfoTableModel;
  //getter/setter

  /**
   * INSURER_INFO_PASSIVE_CHECK_KEY��Ԃ��܂��B
   * @return INSURER_INFO_PASSIVE_CHECK_KEY
   */
  protected ACPassiveKey getINSURER_INFO_PASSIVE_CHECK_KEY(){
    return INSURER_INFO_PASSIVE_CHECK_KEY;
  }
  /**
   * INSURER_INFO_PASSIVE_CHECK_KEY��ݒ肵�܂��B
   * @param INSURER_INFO_PASSIVE_CHECK_KEY INSURER_INFO_PASSIVE_CHECK_KEY
   */
  protected void setINSURER_INFO_PASSIVE_CHECK_KEY(ACPassiveKey INSURER_INFO_PASSIVE_CHECK_KEY){
    this.INSURER_INFO_PASSIVE_CHECK_KEY = INSURER_INFO_PASSIVE_CHECK_KEY;
  }

  /**
   * PROCESS_MODE��Ԃ��܂��B
   * @return PROCESS_MODE
   */
  protected int getPROCESS_MODE(){
    return PROCESS_MODE;
  }
  /**
   * PROCESS_MODE��ݒ肵�܂��B
   * @param PROCESS_MODE PROCESS_MODE
   */
  protected void setPROCESS_MODE(int PROCESS_MODE){
    this.PROCESS_MODE = PROCESS_MODE;
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
   * insurerInfoList��Ԃ��܂��B
   * @return insurerInfoList
   */
  protected VRList getInsurerInfoList(){
    return insurerInfoList;
  }
  /**
   * insurerInfoList��ݒ肵�܂��B
   * @param insurerInfoList insurerInfoList
   */
  protected void setInsurerInfoList(VRList insurerInfoList){
    this.insurerInfoList = insurerInfoList;
  }

  /**
   * insurerLimitRateList��Ԃ��܂��B
   * @return insurerLimitRateList
   */
  protected VRList getInsurerLimitRateList(){
    return insurerLimitRateList;
  }
  /**
   * insurerLimitRateList��ݒ肵�܂��B
   * @param insurerLimitRateList insurerLimitRateList
   */
  protected void setInsurerLimitRateList(VRList insurerLimitRateList){
    this.insurerLimitRateList = insurerLimitRateList;
  }

  /**
   * insurerLImitRateDetailList��Ԃ��܂��B
   * @return insurerLImitRateDetailList
   */
  protected VRList getInsurerLImitRateDetailList(){
    return insurerLImitRateDetailList;
  }
  /**
   * insurerLImitRateDetailList��ݒ肵�܂��B
   * @param insurerLImitRateDetailList insurerLImitRateDetailList
   */
  protected void setInsurerLImitRateDetailList(VRList insurerLImitRateDetailList){
    this.insurerLImitRateDetailList = insurerLImitRateDetailList;
  }

  /**
   * insurerInfoTableModel��Ԃ��܂��B
   * @return insurerInfoTableModel
   */
  protected ACTableModelAdapter getInsurerInfoTableModel(){
    return insurerInfoTableModel;
  }
  /**
   * insurerInfoTableModel��ݒ肵�܂��B
   * @param insurerInfoTableModel insurerInfoTableModel
   */
  protected void setInsurerInfoTableModel(ACTableModelAdapter insurerInfoTableModel){
    this.insurerInfoTableModel = insurerInfoTableModel;
  }

  //�����֐�

  /**
   * �u���R�[�h���擾����ʂɐݒ肷��B�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   *
   */
  public abstract void doFind() throws Exception;

  /**
   * �u�S�ی��ҏ��擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   *
   */
  public abstract void doFindInsurerInfo() throws Exception;

  /**
   * �u�I��ی��ҍ폜�����v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   * @return boolean
   */
  public abstract boolean doDelete() throws Exception;

  /**
   * �u�����������s���B�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   *
   */
  public abstract void doFindData() throws Exception;

  /**
   * �u�ی��Ҕԍ����g�p����Ă��邩�`�F�b�N����v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   * @return boolean
   */
  public abstract boolean checkInsurerId() throws Exception;

}
