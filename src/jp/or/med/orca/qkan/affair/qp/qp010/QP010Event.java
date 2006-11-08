
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
 * �쐬��: 2006/09/04  ���{�R���s���[�^�[������� �c���@���� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �����f�[�^�쐬 (P)
 * �v���Z�X ���p�҈ꗗ(�K��Ō�×{��̎���) (010)
 * �v���O���� ���p�҈ꗗ(�K��Ō�×{��̎���) (QP010)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qp.qp010;
import java.awt.*;
import java.awt.event.*;
import java.awt.im.*;
import java.io.*;
import java.sql.SQLException;
import java.text.*;
import java.util.*;
import java.util.List;
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
import jp.nichicom.ac.component.table.event.*;
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
import jp.or.med.orca.qkan.text.*;
import jp.nichicom.ac.lib.care.claim.print.schedule.*;

/**
 * ���p�҈ꗗ(�K��Ō�×{��̎���)�C�x���g��`(QP010) 
 */
public abstract class QP010Event extends QP010SQL {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QP010Event(){
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
    getPatients().addListSelectionListener(new ListSelectionListener(){
        private boolean lockFlag = false;
        public void valueChanged(ListSelectionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                patientsSelectionChanged(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getPatients().addMouseListener(new MouseAdapter(){
        private boolean lockFlag = false;
        public void mouseClicked(MouseEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                if (e.getClickCount() == 2) {
                    patientsMouseClicked(e);
                }
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getInsurerName().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                insurerNameActionPerformed(e);
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
   * �u�����v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void findActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u�ڍ׉�ʂɑJ�ځv�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void detailActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u��ʐ���v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void patientsSelectionChanged(ListSelectionEvent e) throws Exception;

  /**
   * �u��ʑJ�ڏ����v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void patientsMouseClicked(MouseEvent e) throws Exception;

  /**
   * �u�ی��Ҕԍ��ƕی��Җ��̘A���v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void insurerNameActionPerformed(ActionEvent e) throws Exception;

  //�ϐ���`

  private Date findTargetDate;
  private VRList patientData = new VRArrayList();
  private VRList insurers = new VRArrayList();
  private ACTableModelAdapter patientTableModel;
  private VRMap findedParam = new VRHashMap();
  //getter/setter

  /**
   * findTargetDate��Ԃ��܂��B
   * @return findTargetDate
   */
  protected Date getFindTargetDate(){
    return findTargetDate;
  }
  /**
   * findTargetDate��ݒ肵�܂��B
   * @param findTargetDate findTargetDate
   */
  protected void setFindTargetDate(Date findTargetDate){
    this.findTargetDate = findTargetDate;
  }

  /**
   * patientData��Ԃ��܂��B
   * @return patientData
   */
  protected VRList getPatientData(){
    return patientData;
  }
  /**
   * patientData��ݒ肵�܂��B
   * @param patientData patientData
   */
  protected void setPatientData(VRList patientData){
    this.patientData = patientData;
  }

  /**
   * insurers��Ԃ��܂��B
   * @return insurers
   */
  protected VRList getInsurers(){
    return insurers;
  }
  /**
   * insurers��ݒ肵�܂��B
   * @param insurers insurers
   */
  protected void setInsurers(VRList insurers){
    this.insurers = insurers;
  }

  /**
   * patientTableModel��Ԃ��܂��B
   * @return patientTableModel
   */
  protected ACTableModelAdapter getPatientTableModel(){
    return patientTableModel;
  }
  /**
   * patientTableModel��ݒ肵�܂��B
   * @param patientTableModel patientTableModel
   */
  protected void setPatientTableModel(ACTableModelAdapter patientTableModel){
    this.patientTableModel = patientTableModel;
  }

  /**
   * findedParam��Ԃ��܂��B
   * @return findedParam
   */
  protected VRMap getFindedParam(){
    return findedParam;
  }
  /**
   * findedParam��ݒ肵�܂��B
   * @param findedParam findedParam
   */
  protected void setFindedParam(VRMap findedParam){
    this.findedParam = findedParam;
  }

  //�����֐�

  /**
   * �u�����v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   *
   */
  public abstract void doFind() throws Exception;

  /**
   * �u��ʑJ�ڏ����v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   *
   */
  public abstract void doNext() throws Exception;

}
