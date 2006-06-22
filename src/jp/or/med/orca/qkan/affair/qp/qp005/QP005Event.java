
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
 * �쐬��: 2006/03/16  ���{�R���s���[�^�[������� ��i�@�a�P �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���уf�[�^�쐬 (P)
 * �v���Z�X �m�F�E�C�� (005)
 * �v���O���� ���׏��ڍוҏW (QP005)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qp.qp005;
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
 * ���׏��ڍוҏW�C�x���g��`(QP005) 
 */
public abstract class QP005Event extends QP005SQL {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QP005Event(){
    addEvents();
  }
  /**
   * �C�x���g�����������`���܂��B
   */
  protected void addEvents() {
    getRenewal().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                renewalActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getBasicInfoTable().addListSelectionListener(new ListSelectionListener(){
        private boolean lockFlag = false;
        public void valueChanged(ListSelectionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                basicInfoTableSelectionChanged(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getDetailsInfoTable().addListSelectionListener(new ListSelectionListener(){
        private boolean lockFlag = false;
        public void valueChanged(ListSelectionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                detailsInfoTableSelectionChanged(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getKyotakuDetailsInfoTable().addListSelectionListener(new ListSelectionListener(){
        private boolean lockFlag = false;
        public void valueChanged(ListSelectionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                kyotakuDetailsInfoTableSelectionChanged(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getParticularInfoTable().addListSelectionListener(new ListSelectionListener(){
        private boolean lockFlag = false;
        public void valueChanged(ListSelectionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                particularInfoTableSelectionChanged(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getSpecialClinicInfoTable().addListSelectionListener(new ListSelectionListener(){
        private boolean lockFlag = false;
        public void valueChanged(ListSelectionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                specialClinicInfoTableSelectionChanged(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getTotalInfoTable().addListSelectionListener(new ListSelectionListener(){
        private boolean lockFlag = false;
        public void valueChanged(ListSelectionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                totalInfoTableSelectionChanged(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getNyushoInfoTable().addListSelectionListener(new ListSelectionListener(){
        private boolean lockFlag = false;
        public void valueChanged(ListSelectionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                nyushoInfoTableSelectionChanged(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getShahukuInfoTable().addListSelectionListener(new ListSelectionListener(){
        private boolean lockFlag = false;
        public void valueChanged(ListSelectionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                shahukuInfoTableSelectionChanged(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getBasicInfoRevisionCheck().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                basicInfoRevisionCheckActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getDetailsInfoRevisionCheck().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                detailsInfoRevisionCheckActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getParticularInfoRevisionCheck().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                particularInfoRevisionCheckActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getTotalInfoRevisionCheck().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                totalInfoRevisionCheckActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getNyushoInfoRevisionCheck().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                nyushoInfoRevisionCheckActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getShahukuInfoRevisionCheck().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                shahukuInfoRevisionCheckActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getBasicInfoRevisionTablecolumn2().addCellEditorListener(new CellEditorListener(){
        private boolean lockFlag = false;
        public void editingStopped(ChangeEvent e) {
          cellEditing(e);
        }
        public void editingCanceled(ChangeEvent e) {
          cellEditing(e);
        }
        public void cellEditing(ChangeEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                basicInfoRevisionTablecolumn2CellEditing(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getDetailsInfoRevisionTablecolumn2().addCellEditorListener(new CellEditorListener(){
        private boolean lockFlag = false;
        public void editingStopped(ChangeEvent e) {
          cellEditing(e);
        }
        public void editingCanceled(ChangeEvent e) {
          cellEditing(e);
        }
        public void cellEditing(ChangeEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                detailsInfoRevisionTablecolumn2CellEditing(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getParticularInfoRevisionTablecolumn2().addCellEditorListener(new CellEditorListener(){
        private boolean lockFlag = false;
        public void editingStopped(ChangeEvent e) {
          cellEditing(e);
        }
        public void editingCanceled(ChangeEvent e) {
          cellEditing(e);
        }
        public void cellEditing(ChangeEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                particularInfoRevisionTablecolumn2CellEditing(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getTotalInfoRevisionTablecolumn2().addCellEditorListener(new CellEditorListener(){
        private boolean lockFlag = false;
        public void editingStopped(ChangeEvent e) {
          cellEditing(e);
        }
        public void editingCanceled(ChangeEvent e) {
          cellEditing(e);
        }
        public void cellEditing(ChangeEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                totalInfoRevisionTablecolumn2CellEditing(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getNyushoInfoRevisionTablecolumn2().addCellEditorListener(new CellEditorListener(){
        private boolean lockFlag = false;
        public void editingStopped(ChangeEvent e) {
          cellEditing(e);
        }
        public void editingCanceled(ChangeEvent e) {
          cellEditing(e);
        }
        public void cellEditing(ChangeEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                nyushoInfoRevisionTablecolumn2CellEditing(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getShahukuInfoRevisionTablecolumn2().addCellEditorListener(new CellEditorListener(){
        private boolean lockFlag = false;
        public void editingStopped(ChangeEvent e) {
          cellEditing(e);
        }
        public void editingCanceled(ChangeEvent e) {
          cellEditing(e);
        }
        public void cellEditing(ChangeEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                shahukuInfoRevisionTablecolumn2CellEditing(e);
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
   * �u�X�V�����v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void renewalActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u�f�[�^�\�������v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void basicInfoTableSelectionChanged(ListSelectionEvent e) throws Exception;

  /**
   * �u�f�[�^�\�������v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void detailsInfoTableSelectionChanged(ListSelectionEvent e) throws Exception;

  /**
   * �u�f�[�^�\�������v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void kyotakuDetailsInfoTableSelectionChanged(ListSelectionEvent e) throws Exception;

  /**
   * �u�f�[�^�\�������v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void particularInfoTableSelectionChanged(ListSelectionEvent e) throws Exception;

  /**
   * �u�f�[�^�\�������v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void specialClinicInfoTableSelectionChanged(ListSelectionEvent e) throws Exception;

  /**
   * �u�f�[�^�\�������v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void totalInfoTableSelectionChanged(ListSelectionEvent e) throws Exception;

  /**
   * �u�f�[�^�\�������v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void nyushoInfoTableSelectionChanged(ListSelectionEvent e) throws Exception;

  /**
   * �u�f�[�^�\�������v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void shahukuInfoTableSelectionChanged(ListSelectionEvent e) throws Exception;

  /**
   * �u�f�[�^�؂�ւ������v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void basicInfoRevisionCheckActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u�f�[�^�؂�ւ������v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void detailsInfoRevisionCheckActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u�f�[�^�؂�ւ������v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void particularInfoRevisionCheckActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u�f�[�^�؂�ւ������v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void totalInfoRevisionCheckActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u�f�[�^�؂�ւ������v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void nyushoInfoRevisionCheckActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u�f�[�^�؂�ւ������v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void shahukuInfoRevisionCheckActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u�f�[�^�ύX�������v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void basicInfoRevisionTablecolumn2CellEditing(ChangeEvent e) throws Exception;

  /**
   * �u�f�[�^�ύX�������v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void detailsInfoRevisionTablecolumn2CellEditing(ChangeEvent e) throws Exception;

  /**
   * �u�f�[�^�ύX�������v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void particularInfoRevisionTablecolumn2CellEditing(ChangeEvent e) throws Exception;

  /**
   * �u�f�[�^�ύX�������v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void totalInfoRevisionTablecolumn2CellEditing(ChangeEvent e) throws Exception;

  /**
   * �u�f�[�^�ύX�������v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void nyushoInfoRevisionTablecolumn2CellEditing(ChangeEvent e) throws Exception;

  /**
   * �u�f�[�^�ύX�������v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void shahukuInfoRevisionTablecolumn2CellEditing(ChangeEvent e) throws Exception;

  //�ϐ���`

  private ACPassiveKey PASSIVE_CHECK_KEY;
  public static final int ON = 1;
  public static final int OFF = 0;
  public static final int CATEGORY_NO2 = 2;
  public static final int CATEGORY_NO3 = 3;
  public static final int CATEGORY_NO4 = 4;
  public static final int CATEGORY_NO5 = 5;
  public static final int CATEGORY_NO6 = 6;
  public static final int CATEGORY_NO7 = 7;
  public static final int CATEGORY_NO8 = 8;
  public static final int CATEGORY_NO9 = 9;
  public static final int CATEGORY_NO10 = 10;
  public static final int FORMAT_STYLE2 = 10211;
  public static final int FORMAT_STYLE3 = 10311;
  public static final int FORMAT_STYLE4 = 10411;
  public static final int FORMAT_STYLE5 = 10511;
  public static final int FORMAT_STYLE6 = 10611;
  public static final int FORMAT_STYLE6_3 = 10613;
  public static final int FORMAT_STYLE6_5 = 10615;
  public static final int FORMAT_STYLE7 = 10711;
  public static final int FORMAT_STYLE8 = 10811;
  public static final int FORMAT_STYLE9 = 10911;
  public static final int FORMAT_STYLE10 = 11011;
  public static final String QP002 = "jp.or.med.orca.qkan.affair.qp.qp002.QP002";
  public static final String QP004 = "jp.or.med.orca.qkan.affair.qp.qp004.QP004";
  private int patientId;
  private Date targetDate;
  private Date claimDate;
  private Integer listIndex;
  private String providerId;
  private int claimStyleType;
  private String insuredId;
  private int tableChangeFlg;
  private int checkBoxFlg;
  private VRMap masterCode = new VRHashMap();
  private VRList claimList = new VRArrayList();
  private VRList detailCommentList = new VRArrayList();
  private VRList tableClaimList1 = new VRArrayList();
  private VRList tableClaimList2 = new VRArrayList();
  private VRList tableClaimList3 = new VRArrayList();
  private VRList tableClaimList4 = new VRArrayList();
  private VRList tableClaimList5 = new VRArrayList();
  private VRList tableClaimList6 = new VRArrayList();
  private VRList detailList1 = new VRArrayList();
  private VRList detailList2 = new VRArrayList();
  private VRList detailList3 = new VRArrayList();
  private VRList detailList4 = new VRArrayList();
  private VRList detailList5 = new VRArrayList();
  private VRList detailList6 = new VRArrayList();
  private VRList columnList1Name = new VRArrayList();
  private VRList columnList1Value = new VRArrayList();
  private VRList columnList1Comment = new VRArrayList();
  private VRList columnList2Name = new VRArrayList();
  private VRList columnList2Value = new VRArrayList();
  private VRList columnList2Comment = new VRArrayList();
  private VRList columnList3Name = new VRArrayList();
  private VRList columnList3Value = new VRArrayList();
  private VRList columnList3Comment = new VRArrayList();
  private VRList columnList4Name = new VRArrayList();
  private VRList columnList4Value = new VRArrayList();
  private VRList columnList4Comment = new VRArrayList();
  private VRList columnList5Name = new VRArrayList();
  private VRList columnList5Value = new VRArrayList();
  private VRList columnList5Comment = new VRArrayList();
  private VRList columnList6Name = new VRArrayList();
  private VRList columnList6Value = new VRArrayList();
  private VRList columnList6Comment = new VRArrayList();
  private VRList columnList1NameSimple = new VRArrayList();
  private VRList columnList1ValueSimple = new VRArrayList();
  private VRList columnList1CommentSimple = new VRArrayList();
  private VRList columnList2NameSimple = new VRArrayList();
  private VRList columnList2ValueSimple = new VRArrayList();
  private VRList columnList2CommentSimple = new VRArrayList();
  private VRList columnList3NameSimple = new VRArrayList();
  private VRList columnList3ValueSimple = new VRArrayList();
  private VRList columnList3CommentSimple = new VRArrayList();
  private VRList columnList4NameSimple = new VRArrayList();
  private VRList columnList4ValueSimple = new VRArrayList();
  private VRList columnList4CommentSimple = new VRArrayList();
  private VRList columnList5NameSimple = new VRArrayList();
  private VRList columnList5ValueSimple = new VRArrayList();
  private VRList columnList5CommentSimple = new VRArrayList();
  private VRList columnList6NameSimple = new VRArrayList();
  private VRList columnList6ValueSimple = new VRArrayList();
  private VRList columnList6CommentSimple = new VRArrayList();
  private ACTableModelAdapter tableModelList1;
  private ACTableModelAdapter tableModelList2;
  private ACTableModelAdapter tableModelList3;
  private ACTableModelAdapter tableModelList4;
  private ACTableModelAdapter tableModelList5;
  private ACTableModelAdapter tableModelList6;
  private ACTableModelAdapter tableModelDetail1;
  private ACTableModelAdapter tableModelDetail2;
  private ACTableModelAdapter tableModelDetail3;
  private ACTableModelAdapter tableModelDetail4;
  private ACTableModelAdapter tableModelDetail5;
  private ACTableModelAdapter tableModelDetail6;
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
   * listIndex��Ԃ��܂��B
   * @return listIndex
   */
  protected Integer getListIndex(){
    return listIndex;
  }
  /**
   * listIndex��ݒ肵�܂��B
   * @param listIndex listIndex
   */
  protected void setListIndex(Integer listIndex){
    this.listIndex = listIndex;
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
   * claimStyleType��Ԃ��܂��B
   * @return claimStyleType
   */
  protected int getClaimStyleType(){
    return claimStyleType;
  }
  /**
   * claimStyleType��ݒ肵�܂��B
   * @param claimStyleType claimStyleType
   */
  protected void setClaimStyleType(int claimStyleType){
    this.claimStyleType = claimStyleType;
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
   * tableChangeFlg��Ԃ��܂��B
   * @return tableChangeFlg
   */
  protected int getTableChangeFlg(){
    return tableChangeFlg;
  }
  /**
   * tableChangeFlg��ݒ肵�܂��B
   * @param tableChangeFlg tableChangeFlg
   */
  protected void setTableChangeFlg(int tableChangeFlg){
    this.tableChangeFlg = tableChangeFlg;
  }

  /**
   * checkBoxFlg��Ԃ��܂��B
   * @return checkBoxFlg
   */
  protected int getCheckBoxFlg(){
    return checkBoxFlg;
  }
  /**
   * checkBoxFlg��ݒ肵�܂��B
   * @param checkBoxFlg checkBoxFlg
   */
  protected void setCheckBoxFlg(int checkBoxFlg){
    this.checkBoxFlg = checkBoxFlg;
  }

  /**
   * masterCode��Ԃ��܂��B
   * @return masterCode
   */
  protected VRMap getMasterCode(){
    return masterCode;
  }
  /**
   * masterCode��ݒ肵�܂��B
   * @param masterCode masterCode
   */
  protected void setMasterCode(VRMap masterCode){
    this.masterCode = masterCode;
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
   * detailCommentList��Ԃ��܂��B
   * @return detailCommentList
   */
  protected VRList getDetailCommentList(){
    return detailCommentList;
  }
  /**
   * detailCommentList��ݒ肵�܂��B
   * @param detailCommentList detailCommentList
   */
  protected void setDetailCommentList(VRList detailCommentList){
    this.detailCommentList = detailCommentList;
  }

  /**
   * tableClaimList1��Ԃ��܂��B
   * @return tableClaimList1
   */
  protected VRList getTableClaimList1(){
    return tableClaimList1;
  }
  /**
   * tableClaimList1��ݒ肵�܂��B
   * @param tableClaimList1 tableClaimList1
   */
  protected void setTableClaimList1(VRList tableClaimList1){
    this.tableClaimList1 = tableClaimList1;
  }

  /**
   * tableClaimList2��Ԃ��܂��B
   * @return tableClaimList2
   */
  protected VRList getTableClaimList2(){
    return tableClaimList2;
  }
  /**
   * tableClaimList2��ݒ肵�܂��B
   * @param tableClaimList2 tableClaimList2
   */
  protected void setTableClaimList2(VRList tableClaimList2){
    this.tableClaimList2 = tableClaimList2;
  }

  /**
   * tableClaimList3��Ԃ��܂��B
   * @return tableClaimList3
   */
  protected VRList getTableClaimList3(){
    return tableClaimList3;
  }
  /**
   * tableClaimList3��ݒ肵�܂��B
   * @param tableClaimList3 tableClaimList3
   */
  protected void setTableClaimList3(VRList tableClaimList3){
    this.tableClaimList3 = tableClaimList3;
  }

  /**
   * tableClaimList4��Ԃ��܂��B
   * @return tableClaimList4
   */
  protected VRList getTableClaimList4(){
    return tableClaimList4;
  }
  /**
   * tableClaimList4��ݒ肵�܂��B
   * @param tableClaimList4 tableClaimList4
   */
  protected void setTableClaimList4(VRList tableClaimList4){
    this.tableClaimList4 = tableClaimList4;
  }

  /**
   * tableClaimList5��Ԃ��܂��B
   * @return tableClaimList5
   */
  protected VRList getTableClaimList5(){
    return tableClaimList5;
  }
  /**
   * tableClaimList5��ݒ肵�܂��B
   * @param tableClaimList5 tableClaimList5
   */
  protected void setTableClaimList5(VRList tableClaimList5){
    this.tableClaimList5 = tableClaimList5;
  }

  /**
   * tableClaimList6��Ԃ��܂��B
   * @return tableClaimList6
   */
  protected VRList getTableClaimList6(){
    return tableClaimList6;
  }
  /**
   * tableClaimList6��ݒ肵�܂��B
   * @param tableClaimList6 tableClaimList6
   */
  protected void setTableClaimList6(VRList tableClaimList6){
    this.tableClaimList6 = tableClaimList6;
  }

  /**
   * detailList1��Ԃ��܂��B
   * @return detailList1
   */
  protected VRList getDetailList1(){
    return detailList1;
  }
  /**
   * detailList1��ݒ肵�܂��B
   * @param detailList1 detailList1
   */
  protected void setDetailList1(VRList detailList1){
    this.detailList1 = detailList1;
  }

  /**
   * detailList2��Ԃ��܂��B
   * @return detailList2
   */
  protected VRList getDetailList2(){
    return detailList2;
  }
  /**
   * detailList2��ݒ肵�܂��B
   * @param detailList2 detailList2
   */
  protected void setDetailList2(VRList detailList2){
    this.detailList2 = detailList2;
  }

  /**
   * detailList3��Ԃ��܂��B
   * @return detailList3
   */
  protected VRList getDetailList3(){
    return detailList3;
  }
  /**
   * detailList3��ݒ肵�܂��B
   * @param detailList3 detailList3
   */
  protected void setDetailList3(VRList detailList3){
    this.detailList3 = detailList3;
  }

  /**
   * detailList4��Ԃ��܂��B
   * @return detailList4
   */
  protected VRList getDetailList4(){
    return detailList4;
  }
  /**
   * detailList4��ݒ肵�܂��B
   * @param detailList4 detailList4
   */
  protected void setDetailList4(VRList detailList4){
    this.detailList4 = detailList4;
  }

  /**
   * detailList5��Ԃ��܂��B
   * @return detailList5
   */
  protected VRList getDetailList5(){
    return detailList5;
  }
  /**
   * detailList5��ݒ肵�܂��B
   * @param detailList5 detailList5
   */
  protected void setDetailList5(VRList detailList5){
    this.detailList5 = detailList5;
  }

  /**
   * detailList6��Ԃ��܂��B
   * @return detailList6
   */
  protected VRList getDetailList6(){
    return detailList6;
  }
  /**
   * detailList6��ݒ肵�܂��B
   * @param detailList6 detailList6
   */
  protected void setDetailList6(VRList detailList6){
    this.detailList6 = detailList6;
  }

  /**
   * columnList1Name��Ԃ��܂��B
   * @return columnList1Name
   */
  protected VRList getColumnList1Name(){
    return columnList1Name;
  }
  /**
   * columnList1Name��ݒ肵�܂��B
   * @param columnList1Name columnList1Name
   */
  protected void setColumnList1Name(VRList columnList1Name){
    this.columnList1Name = columnList1Name;
  }

  /**
   * columnList1Value��Ԃ��܂��B
   * @return columnList1Value
   */
  protected VRList getColumnList1Value(){
    return columnList1Value;
  }
  /**
   * columnList1Value��ݒ肵�܂��B
   * @param columnList1Value columnList1Value
   */
  protected void setColumnList1Value(VRList columnList1Value){
    this.columnList1Value = columnList1Value;
  }

  /**
   * columnList1Comment��Ԃ��܂��B
   * @return columnList1Comment
   */
  protected VRList getColumnList1Comment(){
    return columnList1Comment;
  }
  /**
   * columnList1Comment��ݒ肵�܂��B
   * @param columnList1Comment columnList1Comment
   */
  protected void setColumnList1Comment(VRList columnList1Comment){
    this.columnList1Comment = columnList1Comment;
  }

  /**
   * columnList2Name��Ԃ��܂��B
   * @return columnList2Name
   */
  protected VRList getColumnList2Name(){
    return columnList2Name;
  }
  /**
   * columnList2Name��ݒ肵�܂��B
   * @param columnList2Name columnList2Name
   */
  protected void setColumnList2Name(VRList columnList2Name){
    this.columnList2Name = columnList2Name;
  }

  /**
   * columnList2Value��Ԃ��܂��B
   * @return columnList2Value
   */
  protected VRList getColumnList2Value(){
    return columnList2Value;
  }
  /**
   * columnList2Value��ݒ肵�܂��B
   * @param columnList2Value columnList2Value
   */
  protected void setColumnList2Value(VRList columnList2Value){
    this.columnList2Value = columnList2Value;
  }

  /**
   * columnList2Comment��Ԃ��܂��B
   * @return columnList2Comment
   */
  protected VRList getColumnList2Comment(){
    return columnList2Comment;
  }
  /**
   * columnList2Comment��ݒ肵�܂��B
   * @param columnList2Comment columnList2Comment
   */
  protected void setColumnList2Comment(VRList columnList2Comment){
    this.columnList2Comment = columnList2Comment;
  }

  /**
   * columnList3Name��Ԃ��܂��B
   * @return columnList3Name
   */
  protected VRList getColumnList3Name(){
    return columnList3Name;
  }
  /**
   * columnList3Name��ݒ肵�܂��B
   * @param columnList3Name columnList3Name
   */
  protected void setColumnList3Name(VRList columnList3Name){
    this.columnList3Name = columnList3Name;
  }

  /**
   * columnList3Value��Ԃ��܂��B
   * @return columnList3Value
   */
  protected VRList getColumnList3Value(){
    return columnList3Value;
  }
  /**
   * columnList3Value��ݒ肵�܂��B
   * @param columnList3Value columnList3Value
   */
  protected void setColumnList3Value(VRList columnList3Value){
    this.columnList3Value = columnList3Value;
  }

  /**
   * columnList3Comment��Ԃ��܂��B
   * @return columnList3Comment
   */
  protected VRList getColumnList3Comment(){
    return columnList3Comment;
  }
  /**
   * columnList3Comment��ݒ肵�܂��B
   * @param columnList3Comment columnList3Comment
   */
  protected void setColumnList3Comment(VRList columnList3Comment){
    this.columnList3Comment = columnList3Comment;
  }

  /**
   * columnList4Name��Ԃ��܂��B
   * @return columnList4Name
   */
  protected VRList getColumnList4Name(){
    return columnList4Name;
  }
  /**
   * columnList4Name��ݒ肵�܂��B
   * @param columnList4Name columnList4Name
   */
  protected void setColumnList4Name(VRList columnList4Name){
    this.columnList4Name = columnList4Name;
  }

  /**
   * columnList4Value��Ԃ��܂��B
   * @return columnList4Value
   */
  protected VRList getColumnList4Value(){
    return columnList4Value;
  }
  /**
   * columnList4Value��ݒ肵�܂��B
   * @param columnList4Value columnList4Value
   */
  protected void setColumnList4Value(VRList columnList4Value){
    this.columnList4Value = columnList4Value;
  }

  /**
   * columnList4Comment��Ԃ��܂��B
   * @return columnList4Comment
   */
  protected VRList getColumnList4Comment(){
    return columnList4Comment;
  }
  /**
   * columnList4Comment��ݒ肵�܂��B
   * @param columnList4Comment columnList4Comment
   */
  protected void setColumnList4Comment(VRList columnList4Comment){
    this.columnList4Comment = columnList4Comment;
  }

  /**
   * columnList5Name��Ԃ��܂��B
   * @return columnList5Name
   */
  protected VRList getColumnList5Name(){
    return columnList5Name;
  }
  /**
   * columnList5Name��ݒ肵�܂��B
   * @param columnList5Name columnList5Name
   */
  protected void setColumnList5Name(VRList columnList5Name){
    this.columnList5Name = columnList5Name;
  }

  /**
   * columnList5Value��Ԃ��܂��B
   * @return columnList5Value
   */
  protected VRList getColumnList5Value(){
    return columnList5Value;
  }
  /**
   * columnList5Value��ݒ肵�܂��B
   * @param columnList5Value columnList5Value
   */
  protected void setColumnList5Value(VRList columnList5Value){
    this.columnList5Value = columnList5Value;
  }

  /**
   * columnList5Comment��Ԃ��܂��B
   * @return columnList5Comment
   */
  protected VRList getColumnList5Comment(){
    return columnList5Comment;
  }
  /**
   * columnList5Comment��ݒ肵�܂��B
   * @param columnList5Comment columnList5Comment
   */
  protected void setColumnList5Comment(VRList columnList5Comment){
    this.columnList5Comment = columnList5Comment;
  }

  /**
   * columnList6Name��Ԃ��܂��B
   * @return columnList6Name
   */
  protected VRList getColumnList6Name(){
    return columnList6Name;
  }
  /**
   * columnList6Name��ݒ肵�܂��B
   * @param columnList6Name columnList6Name
   */
  protected void setColumnList6Name(VRList columnList6Name){
    this.columnList6Name = columnList6Name;
  }

  /**
   * columnList6Value��Ԃ��܂��B
   * @return columnList6Value
   */
  protected VRList getColumnList6Value(){
    return columnList6Value;
  }
  /**
   * columnList6Value��ݒ肵�܂��B
   * @param columnList6Value columnList6Value
   */
  protected void setColumnList6Value(VRList columnList6Value){
    this.columnList6Value = columnList6Value;
  }

  /**
   * columnList6Comment��Ԃ��܂��B
   * @return columnList6Comment
   */
  protected VRList getColumnList6Comment(){
    return columnList6Comment;
  }
  /**
   * columnList6Comment��ݒ肵�܂��B
   * @param columnList6Comment columnList6Comment
   */
  protected void setColumnList6Comment(VRList columnList6Comment){
    this.columnList6Comment = columnList6Comment;
  }

  /**
   * columnList1NameSimple��Ԃ��܂��B
   * @return columnList1NameSimple
   */
  protected VRList getColumnList1NameSimple(){
    return columnList1NameSimple;
  }
  /**
   * columnList1NameSimple��ݒ肵�܂��B
   * @param columnList1NameSimple columnList1NameSimple
   */
  protected void setColumnList1NameSimple(VRList columnList1NameSimple){
    this.columnList1NameSimple = columnList1NameSimple;
  }

  /**
   * columnList1ValueSimple��Ԃ��܂��B
   * @return columnList1ValueSimple
   */
  protected VRList getColumnList1ValueSimple(){
    return columnList1ValueSimple;
  }
  /**
   * columnList1ValueSimple��ݒ肵�܂��B
   * @param columnList1ValueSimple columnList1ValueSimple
   */
  protected void setColumnList1ValueSimple(VRList columnList1ValueSimple){
    this.columnList1ValueSimple = columnList1ValueSimple;
  }

  /**
   * columnList1CommentSimple��Ԃ��܂��B
   * @return columnList1CommentSimple
   */
  protected VRList getColumnList1CommentSimple(){
    return columnList1CommentSimple;
  }
  /**
   * columnList1CommentSimple��ݒ肵�܂��B
   * @param columnList1CommentSimple columnList1CommentSimple
   */
  protected void setColumnList1CommentSimple(VRList columnList1CommentSimple){
    this.columnList1CommentSimple = columnList1CommentSimple;
  }

  /**
   * columnList2NameSimple��Ԃ��܂��B
   * @return columnList2NameSimple
   */
  protected VRList getColumnList2NameSimple(){
    return columnList2NameSimple;
  }
  /**
   * columnList2NameSimple��ݒ肵�܂��B
   * @param columnList2NameSimple columnList2NameSimple
   */
  protected void setColumnList2NameSimple(VRList columnList2NameSimple){
    this.columnList2NameSimple = columnList2NameSimple;
  }

  /**
   * columnList2ValueSimple��Ԃ��܂��B
   * @return columnList2ValueSimple
   */
  protected VRList getColumnList2ValueSimple(){
    return columnList2ValueSimple;
  }
  /**
   * columnList2ValueSimple��ݒ肵�܂��B
   * @param columnList2ValueSimple columnList2ValueSimple
   */
  protected void setColumnList2ValueSimple(VRList columnList2ValueSimple){
    this.columnList2ValueSimple = columnList2ValueSimple;
  }

  /**
   * columnList2CommentSimple��Ԃ��܂��B
   * @return columnList2CommentSimple
   */
  protected VRList getColumnList2CommentSimple(){
    return columnList2CommentSimple;
  }
  /**
   * columnList2CommentSimple��ݒ肵�܂��B
   * @param columnList2CommentSimple columnList2CommentSimple
   */
  protected void setColumnList2CommentSimple(VRList columnList2CommentSimple){
    this.columnList2CommentSimple = columnList2CommentSimple;
  }

  /**
   * columnList3NameSimple��Ԃ��܂��B
   * @return columnList3NameSimple
   */
  protected VRList getColumnList3NameSimple(){
    return columnList3NameSimple;
  }
  /**
   * columnList3NameSimple��ݒ肵�܂��B
   * @param columnList3NameSimple columnList3NameSimple
   */
  protected void setColumnList3NameSimple(VRList columnList3NameSimple){
    this.columnList3NameSimple = columnList3NameSimple;
  }

  /**
   * columnList3ValueSimple��Ԃ��܂��B
   * @return columnList3ValueSimple
   */
  protected VRList getColumnList3ValueSimple(){
    return columnList3ValueSimple;
  }
  /**
   * columnList3ValueSimple��ݒ肵�܂��B
   * @param columnList3ValueSimple columnList3ValueSimple
   */
  protected void setColumnList3ValueSimple(VRList columnList3ValueSimple){
    this.columnList3ValueSimple = columnList3ValueSimple;
  }

  /**
   * columnList3CommentSimple��Ԃ��܂��B
   * @return columnList3CommentSimple
   */
  protected VRList getColumnList3CommentSimple(){
    return columnList3CommentSimple;
  }
  /**
   * columnList3CommentSimple��ݒ肵�܂��B
   * @param columnList3CommentSimple columnList3CommentSimple
   */
  protected void setColumnList3CommentSimple(VRList columnList3CommentSimple){
    this.columnList3CommentSimple = columnList3CommentSimple;
  }

  /**
   * columnList4NameSimple��Ԃ��܂��B
   * @return columnList4NameSimple
   */
  protected VRList getColumnList4NameSimple(){
    return columnList4NameSimple;
  }
  /**
   * columnList4NameSimple��ݒ肵�܂��B
   * @param columnList4NameSimple columnList4NameSimple
   */
  protected void setColumnList4NameSimple(VRList columnList4NameSimple){
    this.columnList4NameSimple = columnList4NameSimple;
  }

  /**
   * columnList4ValueSimple��Ԃ��܂��B
   * @return columnList4ValueSimple
   */
  protected VRList getColumnList4ValueSimple(){
    return columnList4ValueSimple;
  }
  /**
   * columnList4ValueSimple��ݒ肵�܂��B
   * @param columnList4ValueSimple columnList4ValueSimple
   */
  protected void setColumnList4ValueSimple(VRList columnList4ValueSimple){
    this.columnList4ValueSimple = columnList4ValueSimple;
  }

  /**
   * columnList4CommentSimple��Ԃ��܂��B
   * @return columnList4CommentSimple
   */
  protected VRList getColumnList4CommentSimple(){
    return columnList4CommentSimple;
  }
  /**
   * columnList4CommentSimple��ݒ肵�܂��B
   * @param columnList4CommentSimple columnList4CommentSimple
   */
  protected void setColumnList4CommentSimple(VRList columnList4CommentSimple){
    this.columnList4CommentSimple = columnList4CommentSimple;
  }

  /**
   * columnList5NameSimple��Ԃ��܂��B
   * @return columnList5NameSimple
   */
  protected VRList getColumnList5NameSimple(){
    return columnList5NameSimple;
  }
  /**
   * columnList5NameSimple��ݒ肵�܂��B
   * @param columnList5NameSimple columnList5NameSimple
   */
  protected void setColumnList5NameSimple(VRList columnList5NameSimple){
    this.columnList5NameSimple = columnList5NameSimple;
  }

  /**
   * columnList5ValueSimple��Ԃ��܂��B
   * @return columnList5ValueSimple
   */
  protected VRList getColumnList5ValueSimple(){
    return columnList5ValueSimple;
  }
  /**
   * columnList5ValueSimple��ݒ肵�܂��B
   * @param columnList5ValueSimple columnList5ValueSimple
   */
  protected void setColumnList5ValueSimple(VRList columnList5ValueSimple){
    this.columnList5ValueSimple = columnList5ValueSimple;
  }

  /**
   * columnList5CommentSimple��Ԃ��܂��B
   * @return columnList5CommentSimple
   */
  protected VRList getColumnList5CommentSimple(){
    return columnList5CommentSimple;
  }
  /**
   * columnList5CommentSimple��ݒ肵�܂��B
   * @param columnList5CommentSimple columnList5CommentSimple
   */
  protected void setColumnList5CommentSimple(VRList columnList5CommentSimple){
    this.columnList5CommentSimple = columnList5CommentSimple;
  }

  /**
   * columnList6NameSimple��Ԃ��܂��B
   * @return columnList6NameSimple
   */
  protected VRList getColumnList6NameSimple(){
    return columnList6NameSimple;
  }
  /**
   * columnList6NameSimple��ݒ肵�܂��B
   * @param columnList6NameSimple columnList6NameSimple
   */
  protected void setColumnList6NameSimple(VRList columnList6NameSimple){
    this.columnList6NameSimple = columnList6NameSimple;
  }

  /**
   * columnList6ValueSimple��Ԃ��܂��B
   * @return columnList6ValueSimple
   */
  protected VRList getColumnList6ValueSimple(){
    return columnList6ValueSimple;
  }
  /**
   * columnList6ValueSimple��ݒ肵�܂��B
   * @param columnList6ValueSimple columnList6ValueSimple
   */
  protected void setColumnList6ValueSimple(VRList columnList6ValueSimple){
    this.columnList6ValueSimple = columnList6ValueSimple;
  }

  /**
   * columnList6CommentSimple��Ԃ��܂��B
   * @return columnList6CommentSimple
   */
  protected VRList getColumnList6CommentSimple(){
    return columnList6CommentSimple;
  }
  /**
   * columnList6CommentSimple��ݒ肵�܂��B
   * @param columnList6CommentSimple columnList6CommentSimple
   */
  protected void setColumnList6CommentSimple(VRList columnList6CommentSimple){
    this.columnList6CommentSimple = columnList6CommentSimple;
  }

  /**
   * tableModelList1��Ԃ��܂��B
   * @return tableModelList1
   */
  protected ACTableModelAdapter getTableModelList1(){
    return tableModelList1;
  }
  /**
   * tableModelList1��ݒ肵�܂��B
   * @param tableModelList1 tableModelList1
   */
  protected void setTableModelList1(ACTableModelAdapter tableModelList1){
    this.tableModelList1 = tableModelList1;
  }

  /**
   * tableModelList2��Ԃ��܂��B
   * @return tableModelList2
   */
  protected ACTableModelAdapter getTableModelList2(){
    return tableModelList2;
  }
  /**
   * tableModelList2��ݒ肵�܂��B
   * @param tableModelList2 tableModelList2
   */
  protected void setTableModelList2(ACTableModelAdapter tableModelList2){
    this.tableModelList2 = tableModelList2;
  }

  /**
   * tableModelList3��Ԃ��܂��B
   * @return tableModelList3
   */
  protected ACTableModelAdapter getTableModelList3(){
    return tableModelList3;
  }
  /**
   * tableModelList3��ݒ肵�܂��B
   * @param tableModelList3 tableModelList3
   */
  protected void setTableModelList3(ACTableModelAdapter tableModelList3){
    this.tableModelList3 = tableModelList3;
  }

  /**
   * tableModelList4��Ԃ��܂��B
   * @return tableModelList4
   */
  protected ACTableModelAdapter getTableModelList4(){
    return tableModelList4;
  }
  /**
   * tableModelList4��ݒ肵�܂��B
   * @param tableModelList4 tableModelList4
   */
  protected void setTableModelList4(ACTableModelAdapter tableModelList4){
    this.tableModelList4 = tableModelList4;
  }

  /**
   * tableModelList5��Ԃ��܂��B
   * @return tableModelList5
   */
  protected ACTableModelAdapter getTableModelList5(){
    return tableModelList5;
  }
  /**
   * tableModelList5��ݒ肵�܂��B
   * @param tableModelList5 tableModelList5
   */
  protected void setTableModelList5(ACTableModelAdapter tableModelList5){
    this.tableModelList5 = tableModelList5;
  }

  /**
   * tableModelList6��Ԃ��܂��B
   * @return tableModelList6
   */
  protected ACTableModelAdapter getTableModelList6(){
    return tableModelList6;
  }
  /**
   * tableModelList6��ݒ肵�܂��B
   * @param tableModelList6 tableModelList6
   */
  protected void setTableModelList6(ACTableModelAdapter tableModelList6){
    this.tableModelList6 = tableModelList6;
  }

  /**
   * tableModelDetail1��Ԃ��܂��B
   * @return tableModelDetail1
   */
  protected ACTableModelAdapter getTableModelDetail1(){
    return tableModelDetail1;
  }
  /**
   * tableModelDetail1��ݒ肵�܂��B
   * @param tableModelDetail1 tableModelDetail1
   */
  protected void setTableModelDetail1(ACTableModelAdapter tableModelDetail1){
    this.tableModelDetail1 = tableModelDetail1;
  }

  /**
   * tableModelDetail2��Ԃ��܂��B
   * @return tableModelDetail2
   */
  protected ACTableModelAdapter getTableModelDetail2(){
    return tableModelDetail2;
  }
  /**
   * tableModelDetail2��ݒ肵�܂��B
   * @param tableModelDetail2 tableModelDetail2
   */
  protected void setTableModelDetail2(ACTableModelAdapter tableModelDetail2){
    this.tableModelDetail2 = tableModelDetail2;
  }

  /**
   * tableModelDetail3��Ԃ��܂��B
   * @return tableModelDetail3
   */
  protected ACTableModelAdapter getTableModelDetail3(){
    return tableModelDetail3;
  }
  /**
   * tableModelDetail3��ݒ肵�܂��B
   * @param tableModelDetail3 tableModelDetail3
   */
  protected void setTableModelDetail3(ACTableModelAdapter tableModelDetail3){
    this.tableModelDetail3 = tableModelDetail3;
  }

  /**
   * tableModelDetail4��Ԃ��܂��B
   * @return tableModelDetail4
   */
  protected ACTableModelAdapter getTableModelDetail4(){
    return tableModelDetail4;
  }
  /**
   * tableModelDetail4��ݒ肵�܂��B
   * @param tableModelDetail4 tableModelDetail4
   */
  protected void setTableModelDetail4(ACTableModelAdapter tableModelDetail4){
    this.tableModelDetail4 = tableModelDetail4;
  }

  /**
   * tableModelDetail5��Ԃ��܂��B
   * @return tableModelDetail5
   */
  protected ACTableModelAdapter getTableModelDetail5(){
    return tableModelDetail5;
  }
  /**
   * tableModelDetail5��ݒ肵�܂��B
   * @param tableModelDetail5 tableModelDetail5
   */
  protected void setTableModelDetail5(ACTableModelAdapter tableModelDetail5){
    this.tableModelDetail5 = tableModelDetail5;
  }

  /**
   * tableModelDetail6��Ԃ��܂��B
   * @return tableModelDetail6
   */
  protected ACTableModelAdapter getTableModelDetail6(){
    return tableModelDetail6;
  }
  /**
   * tableModelDetail6��ݒ肵�܂��B
   * @param tableModelDetail6 tableModelDetail6
   */
  protected void setTableModelDetail6(ACTableModelAdapter tableModelDetail6){
    this.tableModelDetail6 = tableModelDetail6;
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
   * �u���[�l�����̎擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   * @return String
   */
  public abstract String getClaimStyleName() throws Exception;

  /**
   * �u��ʂ�Visible����EEnable����E�L���v�V��������v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   *
   */
  public abstract void doControlWindow() throws Exception;

  /**
   * �u�}�X�^�f�[�^�擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   *
   */
  public abstract void doFindComment() throws Exception;

  /**
   * �u�����f�[�^�擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   *
   */
  public abstract void doFindClaim() throws Exception;

  /**
   * �u��ʃe�[�u���̐ݒ�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   *
   */
  public abstract void doSetTable() throws Exception;

  /**
   * �u���R�[�h�̊i�[�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @param claimDataMap VRMap
   * @throws Exception ������O
   *
   */
  public abstract void doMoveRecord(VRMap claimDataMap) throws Exception;

  /**
   * �u�e�[�u�����f���̐ݒ�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @param firstArg int
   * @throws Exception ������O
   *
   */
  public abstract void doSetTableModel(int firstArg) throws Exception;

  /**
   * �u�e�[�u���̊e�s�̐ݒ�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @param firstArg int
   * @throws Exception ������O
   *
   */
  public abstract void doSetTableRow(int firstArg) throws Exception;

  /**
   * �u�e�s�̃R���|�[�l���g�𐶐��v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @param categoryNo int
   * @param detailList VRList
   * @param columnListName VRList
   * @param columnListValue VRList
   * @param columnListComment VRList
   * @throws Exception ������O
   *
   */
  public abstract void doMakeComponent(int categoryNo, VRList detailList, VRList columnListName, VRList columnListValue, VRList columnListComment, VRList columnListNameSimple, VRList columnListValueSimple, VRList columnListCommentSimple) throws Exception;

  /**
   * �u�����f�[�^����ʃe�[�u���ɐݒ�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   *
   */
  public abstract void doSetClaimData() throws Exception;

  /**
   * �u�ڍ׃e�[�u���\���p�f�[�^�쐬�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @param claimData VRMap
   * @param detailList VRList
   * @throws Exception ������O
   *
   */
  public abstract void doMakeDetailTableList(VRMap claimData, VRList detailList) throws Exception;

  /**
   * �u�ڍ׃e�[�u���\���v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @param recordDataType String
   * @throws Exception ������O
   *
   */
  public abstract void doShowClaimDetail(String recordDataType) throws Exception;

  /**
   * �u�ۑ������v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   * @return boolean
   */
  public abstract boolean doSave() throws Exception;

}
