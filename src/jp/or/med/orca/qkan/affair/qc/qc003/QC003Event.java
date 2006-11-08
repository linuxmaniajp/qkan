
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
 * �쐬��: 2006/05/11  ���{�R���s���[�^�[������� ����@��F �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���[�Ǘ� (C)
 * �v���Z�X �V�l�K��Ō�E�K��Ō���񋟏� (003)
 * �v���O���� �V�l�K��Ō�E�K��Ō�̏��񋟏� (QC003)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qc.qc003;
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
 * �V�l�K��Ō�E�K��Ō�̏��񋟏��C�x���g��`(QC003) 
 */
public abstract class QC003Event extends QC003SQL {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QC003Event(){
    addEvents();
  }
  /**
   * �C�x���g�����������`���܂��B
   */
  protected void addEvents() {
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
    getProviderName().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                providerNameActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getHomonkaisuResultReadButton().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                homonkaisuResultReadButtonActionPerformed(e);
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
   * �u�Ǎ��ݏ����v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void openActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u�o�^�����v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void insertActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u�X�V�����v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void updateActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u��������v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void printActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u��ʏ����v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void providerNameActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u�K��Ō���ѓǍ��v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void homonkaisuResultReadButtonActionPerformed(ActionEvent e) throws Exception;

  //�ϐ���`

  private ACPassiveKey PASSIVE_CHECK_JOHO_TEIKYOSHO;
  private boolean forciblyBackCheckFlag;
  private int patientId;
  private int homonkangoInfoemation;
  private int processMode;
  private int homonkango;
  private Date targetDate;
  private VRList providerList = new VRArrayList();
  //getter/setter

  /**
   * PASSIVE_CHECK_JOHO_TEIKYOSHO��Ԃ��܂��B
   * @return PASSIVE_CHECK_JOHO_TEIKYOSHO
   */
  protected ACPassiveKey getPASSIVE_CHECK_JOHO_TEIKYOSHO(){
    return PASSIVE_CHECK_JOHO_TEIKYOSHO;
  }
  /**
   * PASSIVE_CHECK_JOHO_TEIKYOSHO��ݒ肵�܂��B
   * @param PASSIVE_CHECK_JOHO_TEIKYOSHO PASSIVE_CHECK_JOHO_TEIKYOSHO
   */
  protected void setPASSIVE_CHECK_JOHO_TEIKYOSHO(ACPassiveKey PASSIVE_CHECK_JOHO_TEIKYOSHO){
    this.PASSIVE_CHECK_JOHO_TEIKYOSHO = PASSIVE_CHECK_JOHO_TEIKYOSHO;
  }

  /**
   * forciblyBackCheckFlag��Ԃ��܂��B
   * @return forciblyBackCheckFlag
   */
  protected boolean getForciblyBackCheckFlag(){
    return forciblyBackCheckFlag;
  }
  /**
   * forciblyBackCheckFlag��ݒ肵�܂��B
   * @param forciblyBackCheckFlag forciblyBackCheckFlag
   */
  protected void setForciblyBackCheckFlag(boolean forciblyBackCheckFlag){
    this.forciblyBackCheckFlag = forciblyBackCheckFlag;
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
   * homonkangoInfoemation��Ԃ��܂��B
   * @return homonkangoInfoemation
   */
  protected int getHomonkangoInfoemation(){
    return homonkangoInfoemation;
  }
  /**
   * homonkangoInfoemation��ݒ肵�܂��B
   * @param homonkangoInfoemation homonkangoInfoemation
   */
  protected void setHomonkangoInfoemation(int homonkangoInfoemation){
    this.homonkangoInfoemation = homonkangoInfoemation;
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
   * homonkango��Ԃ��܂��B
   * @return homonkango
   */
  protected int getHomonkango(){
    return homonkango;
  }
  /**
   * homonkango��ݒ肵�܂��B
   * @param homonkango homonkango
   */
  protected void setHomonkango(int homonkango){
    this.homonkango = homonkango;
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

  //�����֐�

  /**
   * �u�p�b�V�u�`�F�b�N���o�^�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   *
   */
  public abstract void doFindPassive() throws Exception;

  /**
   * �u�o�^�����v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   * @return boolean
   */
  public abstract boolean doInsert() throws Exception;

  /**
   * �u�X�V�����v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   * @return boolean
   */
  public abstract boolean doUpdate() throws Exception;

  /**
   * �u���̓`�F�b�N�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   * @return boolean
   */
  public abstract boolean doCheck() throws Exception;

  /**
   * �u�n���p�����[�^�[�쐬�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   *
   */
  public abstract void setParameter() throws Exception;

  /**
   * �u�K��Ō�̏��񋟏������擾���鏈���v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   * @return VRList
   */
  public abstract VRList getJohoteikyoshoInfo() throws Exception;

  /**
   * �u�K��Ō�̎��{�񐔂��擾���鏈���v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   * @return int
   */
  public abstract int getResultCount() throws Exception;

  /**
   * �u�K��Ō�̎��{�������擾���鏈���v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   * @return int
   */
  public abstract int getResultDayCount() throws Exception;

  /**
   * �u���񋟐���擾���܂��v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   * @return String
   */
  public abstract String getJohoteikyosaki() throws Exception;

}
