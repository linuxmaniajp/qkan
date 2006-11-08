
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
 * �쐬��: 2006/03/04  ���{�R���s���[�^�[������� ��i�@�a�P �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���p�ҊǗ� (U)
 * �v���Z�X ���p�ғo�^ (004)
 * �v���O���� ����E���Ə�� (QU004)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qu.qu004;
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

/**
 * ����E���Ə��C�x���g��`(QU004) 
 */
public abstract class QU004Event extends QU004SQL {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QU004Event(){
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
            }catch(Exception ex){
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
            }catch(Exception ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getKaigoInfoButtonClear().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                kaigoInfoButtonClearActionPerformed(e);
            }catch(Exception ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getKaigoInfoButtonInsert().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                kaigoInfoButtonInsertActionPerformed(e);
            }catch(Exception ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getKaigoInfoButtonConpile().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                kaigoInfoButtonConpileActionPerformed(e);
            }catch(Exception ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getKaigoInfoButtonDelete().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                kaigoInfoButtonDeleteActionPerformed(e);
            }catch(Exception ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getIryoInfoButtonClear().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                iryoInfoButtonClearActionPerformed(e);
            }catch(Exception ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getIryoInfoButtonInsert().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                iryoInfoButtonInsertActionPerformed(e);
            }catch(Exception ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getIryoInfoButtonConpile().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                iryoInfoButtonConpileActionPerformed(e);
            }catch(Exception ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getIryoInfoButtonDelete().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                iryoInfoButtonDeleteActionPerformed(e);
            }catch(Exception ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getKaigoInfoTable().addListSelectionListener(new ListSelectionListener(){
        private boolean lockFlag = false;
        public void valueChanged(ListSelectionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                kaigoInfoTableSelectionChanged(e);
            }catch(Exception ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getIryoInfoTable().addListSelectionListener(new ListSelectionListener(){
        private boolean lockFlag = false;
        public void valueChanged(ListSelectionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                iryoInfoTableSelectionChanged(e);
            }catch(Exception ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getKaigoInfoInsurerNo().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                kaigoInfoInsurerNoFocusLost(e);
            }catch(Exception ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getKaigoInfoBearName().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                kaigoInfoBearNameActionPerformed(e);
            }catch(Exception ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getIryoInfoInsurerNo().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                iryoInfoInsurerNoFocusLost(e);
            }catch(Exception ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getIryoInfoBearName().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                iryoInfoBearNameActionPerformed(e);
            }catch(Exception ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getKaigoInfoPublicExpense().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                kaigoInfoPublicExpenseActionPerformed(e);
            }catch(Exception ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getIryoInfoPublicExpense().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                iryoInfoPublicExpenseActionPerformed(e);
            }catch(Exception ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getShahukuInfoButtonClear().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                shahukuInfoButtonClearActionPerformed(e);
            }catch(Exception ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getShahukuInfoButtonInsert().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                shahukuInfoButtonInsertActionPerformed(e);
            }catch(Exception ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getShahukuInfoButtonConpile().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                shahukuInfoButtonConpileActionPerformed(e);
            }catch(Exception ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getShahukuInfoButtonDelete().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                shahukuInfoButtonDeleteActionPerformed(e);
            }catch(Exception ex){
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
   * �uDB�o�^�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void insertActionPerformed(ActionEvent e) throws Exception;

  /**
   * �uDB�X�V�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void updateActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u��������N���A�����v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void kaigoInfoButtonClearActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u��������ǉ������v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void kaigoInfoButtonInsertActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u��������ҏW�����v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void kaigoInfoButtonConpileActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u��������폜�����v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void kaigoInfoButtonDeleteActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u��Ì�����N���A�����v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void iryoInfoButtonClearActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u��Ì�����ǉ������v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void iryoInfoButtonInsertActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u��Ì�����ҏW�����v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void iryoInfoButtonConpileActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u��Ì�����폜�����v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void iryoInfoButtonDeleteActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u��������W�J�����v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void kaigoInfoTableSelectionChanged(ListSelectionEvent e) throws Exception;

  /**
   * �u��Ì�����W�J�����v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void iryoInfoTableSelectionChanged(ListSelectionEvent e) throws Exception;

  /**
   * �u���S�Ҕԍ����͎������v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void kaigoInfoInsurerNoFocusLost(FocusEvent e) throws Exception;

  /**
   * �u���S�Җ��I���������v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void kaigoInfoBearNameActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u���S�Ҕԍ����͎������v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void iryoInfoInsurerNoFocusLost(FocusEvent e) throws Exception;

  /**
   * �u���S�Җ��I���������v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void iryoInfoBearNameActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u������I���������v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void kaigoInfoPublicExpenseActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u������I���������v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void iryoInfoPublicExpenseActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u�N���A�����v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void shahukuInfoButtonClearActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u�ǉ������v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void shahukuInfoButtonInsertActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u�ҏW�����v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void shahukuInfoButtonConpileActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u�폜�����v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void shahukuInfoButtonDeleteActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u�Љ�����Ə��W�J�����v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void shahukuInfoTableSelectionChanged(ListSelectionEvent e) throws Exception;

  //�ϐ���`

  private ACPassiveKey PASSIVE_CHECK_KEY;
  public static final int INSURE_TYPE_KAIGO = 1;
  public static final int INSURE_TYPE_IRYO = 2;
  public static final int INSURE_TYPE_SHAHUKU = 3;
  public static final int CHECK_MODE_INSERT = 1;
  public static final int CHECK_MODE_UPDATE = 2;
  public static final int TYPE_SHAHUKU = 7701;
  public static final int KAIGO_OTHER_KOHI = 9999;
  public static final int IRYO_OTHER_KOHI = 9998;
  public static final Date MAX_DATE = ACCastUtilities.toDate("9999/12/31", null);
  public static final Date MIN_DATE = ACCastUtilities.toDate("0001/01/01", null);
  private int patientId;
  private int systemDate;
  private int processMode = QkanConstants.PROCESS_MODE_INSERT;
  private int kaigoTableChangeFlg;
  private int iryoTableChangeFlg;
  private int shahukuTableChangeFlg;
  private int kohiDataFlg;
  private int kohiServiceDataFlg;
  private int compulsoryBackFlg;
  private String processStart;
  public static final String AFFAIR_ID = "QU004";
  private VRList masterKohiServiceList = new VRArrayList();
  private VRList patientKohiServiceList = new VRArrayList();
  private VRList patientKohiList = new VRArrayList();
  private VRList insurerList = new VRArrayList();
  private VRList masterKohiList = new VRArrayList();
  private VRMap masterService = new VRHashMap();
  private ACTableModelAdapter kaigoTableModel;
  private ACTableModelAdapter iryoTableModel;
  private ACTableModelAdapter shahukuTableModel;
  private ACTableModelAdapter kaigoServiceTableModel;
  private ACTableModelAdapter iryoServiceTableModel;
  private ACTableModelAdapter shahukuServiceTableModel;
  private ACSnapshot snapShotKaigo = new ACSnapshot();
  private ACSnapshot snapShotIryo = new ACSnapshot();
  private ACSnapshot snapShotShahuku = new ACSnapshot();
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
   * systemDate��Ԃ��܂��B
   * @return systemDate
   */
  protected int getSystemDate(){
    return systemDate;
  }
  /**
   * systemDate��ݒ肵�܂��B
   * @param systemDate systemDate
   */
  protected void setSystemDate(int systemDate){
    this.systemDate = systemDate;
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
   * kaigoTableChangeFlg��Ԃ��܂��B
   * @return kaigoTableChangeFlg
   */
  protected int getKaigoTableChangeFlg(){
    return kaigoTableChangeFlg;
  }
  /**
   * kaigoTableChangeFlg��ݒ肵�܂��B
   * @param kaigoTableChangeFlg kaigoTableChangeFlg
   */
  protected void setKaigoTableChangeFlg(int kaigoTableChangeFlg){
    this.kaigoTableChangeFlg = kaigoTableChangeFlg;
  }

  /**
   * iryoTableChangeFlg��Ԃ��܂��B
   * @return iryoTableChangeFlg
   */
  protected int getIryoTableChangeFlg(){
    return iryoTableChangeFlg;
  }
  /**
   * iryoTableChangeFlg��ݒ肵�܂��B
   * @param iryoTableChangeFlg iryoTableChangeFlg
   */
  protected void setIryoTableChangeFlg(int iryoTableChangeFlg){
    this.iryoTableChangeFlg = iryoTableChangeFlg;
  }

  /**
   * shahukuTableChangeFlg��Ԃ��܂��B
   * @return shahukuTableChangeFlg
   */
  protected int getShahukuTableChangeFlg(){
    return shahukuTableChangeFlg;
  }
  /**
   * shahukuTableChangeFlg��ݒ肵�܂��B
   * @param shahukuTableChangeFlg shahukuTableChangeFlg
   */
  protected void setShahukuTableChangeFlg(int shahukuTableChangeFlg){
    this.shahukuTableChangeFlg = shahukuTableChangeFlg;
  }

  /**
   * kohiDataFlg��Ԃ��܂��B
   * @return kohiDataFlg
   */
  protected int getKohiDataFlg(){
    return kohiDataFlg;
  }
  /**
   * kohiDataFlg��ݒ肵�܂��B
   * @param kohiDataFlg kohiDataFlg
   */
  protected void setKohiDataFlg(int kohiDataFlg){
    this.kohiDataFlg = kohiDataFlg;
  }

  /**
   * kohiServiceDataFlg��Ԃ��܂��B
   * @return kohiServiceDataFlg
   */
  protected int getKohiServiceDataFlg(){
    return kohiServiceDataFlg;
  }
  /**
   * kohiServiceDataFlg��ݒ肵�܂��B
   * @param kohiServiceDataFlg kohiServiceDataFlg
   */
  protected void setKohiServiceDataFlg(int kohiServiceDataFlg){
    this.kohiServiceDataFlg = kohiServiceDataFlg;
  }

  /**
   * compulsoryBackFlg��Ԃ��܂��B
   * @return compulsoryBackFlg
   */
  protected int getCompulsoryBackFlg(){
    return compulsoryBackFlg;
  }
  /**
   * compulsoryBackFlg��ݒ肵�܂��B
   * @param compulsoryBackFlg compulsoryBackFlg
   */
  protected void setCompulsoryBackFlg(int compulsoryBackFlg){
    this.compulsoryBackFlg = compulsoryBackFlg;
  }

  /**
   * processStart��Ԃ��܂��B
   * @return processStart
   */
  protected String getProcessStart(){
    return processStart;
  }
  /**
   * processStart��ݒ肵�܂��B
   * @param processStart processStart
   */
  protected void setProcessStart(String processStart){
    this.processStart = processStart;
  }

  /**
   * masterKohiServiceList��Ԃ��܂��B
   * @return masterKohiServiceList
   */
  protected VRList getMasterKohiServiceList(){
    return masterKohiServiceList;
  }
  /**
   * masterKohiServiceList��ݒ肵�܂��B
   * @param masterKohiServiceList masterKohiServiceList
   */
  protected void setMasterKohiServiceList(VRList masterKohiServiceList){
    this.masterKohiServiceList = masterKohiServiceList;
  }

  /**
   * patientKohiServiceList��Ԃ��܂��B
   * @return patientKohiServiceList
   */
  protected VRList getPatientKohiServiceList(){
    return patientKohiServiceList;
  }
  /**
   * patientKohiServiceList��ݒ肵�܂��B
   * @param patientKohiServiceList patientKohiServiceList
   */
  protected void setPatientKohiServiceList(VRList patientKohiServiceList){
    this.patientKohiServiceList = patientKohiServiceList;
  }

  /**
   * patientKohiList��Ԃ��܂��B
   * @return patientKohiList
   */
  protected VRList getPatientKohiList(){
    return patientKohiList;
  }
  /**
   * patientKohiList��ݒ肵�܂��B
   * @param patientKohiList patientKohiList
   */
  protected void setPatientKohiList(VRList patientKohiList){
    this.patientKohiList = patientKohiList;
  }

  /**
   * insurerList��Ԃ��܂��B
   * @return insurerList
   */
  protected VRList getInsurerList(){
    return insurerList;
  }
  /**
   * insurerList��ݒ肵�܂��B
   * @param insurerList insurerList
   */
  protected void setInsurerList(VRList insurerList){
    this.insurerList = insurerList;
  }

  /**
   * masterKohiList��Ԃ��܂��B
   * @return masterKohiList
   */
  protected VRList getMasterKohiList(){
    return masterKohiList;
  }
  /**
   * masterKohiList��ݒ肵�܂��B
   * @param masterKohiList masterKohiList
   */
  protected void setMasterKohiList(VRList masterKohiList){
    this.masterKohiList = masterKohiList;
  }

  /**
   * masterService��Ԃ��܂��B
   * @return masterService
   */
  protected VRMap getMasterService(){
    return masterService;
  }
  /**
   * masterService��ݒ肵�܂��B
   * @param masterService masterService
   */
  protected void setMasterService(VRMap masterService){
    this.masterService = masterService;
  }

  /**
   * kaigoTableModel��Ԃ��܂��B
   * @return kaigoTableModel
   */
  protected ACTableModelAdapter getKaigoTableModel(){
    return kaigoTableModel;
  }
  /**
   * kaigoTableModel��ݒ肵�܂��B
   * @param kaigoTableModel kaigoTableModel
   */
  protected void setKaigoTableModel(ACTableModelAdapter kaigoTableModel){
    this.kaigoTableModel = kaigoTableModel;
  }

  /**
   * iryoTableModel��Ԃ��܂��B
   * @return iryoTableModel
   */
  protected ACTableModelAdapter getIryoTableModel(){
    return iryoTableModel;
  }
  /**
   * iryoTableModel��ݒ肵�܂��B
   * @param iryoTableModel iryoTableModel
   */
  protected void setIryoTableModel(ACTableModelAdapter iryoTableModel){
    this.iryoTableModel = iryoTableModel;
  }

  /**
   * shahukuTableModel��Ԃ��܂��B
   * @return shahukuTableModel
   */
  protected ACTableModelAdapter getShahukuTableModel(){
    return shahukuTableModel;
  }
  /**
   * shahukuTableModel��ݒ肵�܂��B
   * @param shahukuTableModel shahukuTableModel
   */
  protected void setShahukuTableModel(ACTableModelAdapter shahukuTableModel){
    this.shahukuTableModel = shahukuTableModel;
  }

  /**
   * kaigoServiceTableModel��Ԃ��܂��B
   * @return kaigoServiceTableModel
   */
  protected ACTableModelAdapter getKaigoServiceTableModel(){
    return kaigoServiceTableModel;
  }
  /**
   * kaigoServiceTableModel��ݒ肵�܂��B
   * @param kaigoServiceTableModel kaigoServiceTableModel
   */
  protected void setKaigoServiceTableModel(ACTableModelAdapter kaigoServiceTableModel){
    this.kaigoServiceTableModel = kaigoServiceTableModel;
  }

  /**
   * iryoServiceTableModel��Ԃ��܂��B
   * @return iryoServiceTableModel
   */
  protected ACTableModelAdapter getIryoServiceTableModel(){
    return iryoServiceTableModel;
  }
  /**
   * iryoServiceTableModel��ݒ肵�܂��B
   * @param iryoServiceTableModel iryoServiceTableModel
   */
  protected void setIryoServiceTableModel(ACTableModelAdapter iryoServiceTableModel){
    this.iryoServiceTableModel = iryoServiceTableModel;
  }

  /**
   * shahukuServiceTableModel��Ԃ��܂��B
   * @return shahukuServiceTableModel
   */
  protected ACTableModelAdapter getShahukuServiceTableModel(){
    return shahukuServiceTableModel;
  }
  /**
   * shahukuServiceTableModel��ݒ肵�܂��B
   * @param shahukuServiceTableModel shahukuServiceTableModel
   */
  protected void setShahukuServiceTableModel(ACTableModelAdapter shahukuServiceTableModel){
    this.shahukuServiceTableModel = shahukuServiceTableModel;
  }

  /**
   * snapShotKaigo��Ԃ��܂��B
   * @return snapShotKaigo
   */
  protected ACSnapshot getSnapShotKaigo(){
    return snapShotKaigo;
  }
  /**
   * snapShotKaigo��ݒ肵�܂��B
   * @param snapShotKaigo snapShotKaigo
   */
  protected void setSnapShotKaigo(ACSnapshot snapShotKaigo){
    this.snapShotKaigo = snapShotKaigo;
  }

  /**
   * snapShotIryo��Ԃ��܂��B
   * @return snapShotIryo
   */
  protected ACSnapshot getSnapShotIryo(){
    return snapShotIryo;
  }
  /**
   * snapShotIryo��ݒ肵�܂��B
   * @param snapShotIryo snapShotIryo
   */
  protected void setSnapShotIryo(ACSnapshot snapShotIryo){
    this.snapShotIryo = snapShotIryo;
  }

  /**
   * snapShotShahuku��Ԃ��܂��B
   * @return snapShotShahuku
   */
  protected ACSnapshot getSnapShotShahuku(){
    return snapShotShahuku;
  }
  /**
   * snapShotShahuku��ݒ肵�܂��B
   * @param snapShotShahuku snapShotShahuku
   */
  protected void setSnapShotShahuku(ACSnapshot snapShotShahuku){
    this.snapShotShahuku = snapShotShahuku;
  }

  //�����֐�

  /**
   * �u���R�[�h�擾�E��ʐݒ�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   *
   */
  public abstract void doFind() throws Exception;

  /**
   * �u���p�Ҍ�����擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   *
   */
  public abstract void doFindPatientKohi() throws Exception;

  /**
   * �u���p�Ҍ���T�[�r�X���擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   *
   */
  public abstract void doFindPatientKohiService() throws Exception;

  /**
   * �u���S�Җ������v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @param insureType int
   * @throws Exception ������O
   *
   */
  public abstract void doFindInsurerName(int insureType) throws Exception;

  /**
   * �u���S�Ҕԍ������v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @param insureType int
   * @throws Exception ������O
   *
   */
  public abstract void doFindInsurerId(int insureType) throws Exception;

  /**
   * �u���t�ΏۃT�[�r�X�����v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @param kohiType int
   * @param insureType int
   * @throws Exception ������O
   *
   */
  public abstract void doFindTargetService(int kohiType, int insureType) throws Exception;

  /**
   * �u���̓`�F�b�N�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @param insureType int
   * @param checkMode int
   * @throws Exception ������O
   * @return boolean
   */
  public abstract boolean isValidInput(int insureType, int checkMode) throws Exception;

  /**
   * �u������̃`�F�b�N�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @param checkMode int
   * @throws Exception ������O
   * @return boolean
   */
  public abstract boolean doCheckKaigoKohi(int checkMode) throws Exception;

  /**
   * �u��Ì���̃`�F�b�N�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @param checkMode int
   * @throws Exception ������O
   * @return boolean
   */
  public abstract boolean doCheckIryoKohi(int checkMode) throws Exception;

  /**
   * �u�ۑ������v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   * @return boolean
   */
  public abstract boolean doSave() throws Exception;

  /**
   * �u���p�Ҍ���T�[�r�X���W�J�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @param kohiId int
   * @param insureType int
   * @throws Exception ������O
   *
   */
  public abstract void setPatientKohiService(int kohiId, int insureType) throws Exception;

  /**
   * �u���t�Ώۂ̃T�[�r�X�̔���v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @param kohiId int
   * @param systemServiceKindDetail int
   * @throws Exception ������O
   * @return boolean
   */
  public abstract boolean doCheckUseService(int kohiId, int systemServiceKindDetail) throws Exception;

  /**
   * �u���p�Ҍ���T�[�r�X������ʂ��擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @param kohiId int
   * @param insureType int
   * @throws Exception ������O
   * @return VRList
   */
  public abstract VRList getPatientKohiService(int kohiId, int insureType) throws Exception;

  /**
   * �u��ʏ������v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   *
   */
  public abstract void initialize() throws Exception;

  /**
   * �u��ʐݒ�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   *
   */
  public abstract void casualInitialize() throws Exception;

  /**
   * �u�f�[�^�ҏW�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @param list VRList
   * @throws Exception ������O
   * @return VRList
   */
  public abstract VRList toKohiTableList(VRList list) throws Exception;

  /**
   * �u�f�[�^�ҏW�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @param map VRMap
   * @throws Exception ������O
   * @return VRMap
   */
  public abstract VRMap toKohiTableList(VRMap map) throws Exception;

  /**
   * �u�e�ی��̃f�[�^�擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @param list VRList
   * @param insureType int
   * @throws Exception ������O
   * @return VRList
   */
  public abstract VRList getListToSetTable(VRList list, int insureType) throws Exception;

}
