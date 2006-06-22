
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
 * �쐬��: 2005/12/22  ���{�R���s���[�^�[������� �� ���� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �\��Ǘ� (S)
 * �v���Z�X ���p�E�񋟕[��� (003)
 * �v���O���� ���p�E�񋟕[��� (QS003)
 *
 *****************************************************************
 */

package jp.or.med.orca.qkan.affair.qs.qs003;

import java.awt.*;
import java.awt.event.*;
import java.awt.im.*;
import java.io.*;
import java.text.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
import jp.nichicom.ac.*;
import jp.nichicom.ac.bind.*;
import jp.nichicom.ac.component.*;
import jp.nichicom.ac.component.event.*;
import jp.nichicom.ac.component.mainmenu.*;
import jp.nichicom.ac.component.table.*;
import jp.nichicom.ac.container.*;
import jp.nichicom.ac.core.*;
import jp.nichicom.ac.filechooser.*;
import jp.nichicom.ac.io.*;
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
 * ���p�E�񋟕[����C�x���g��`(QS003) 
 */
public abstract class QS003Event extends QS003State {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QS003Event(){
  }
  public void initAffair(ACAffairInfo affair) throws Exception  {
    super.initAffair(affair);
    addEvents();
  }
  /**
   * �C�x���g�����������`���܂��B
   * @throws Exception ������O
   */
  protected void addEvents() throws Exception {
    getPlanManufacturer().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                planManufacturerActionPerformed(e);
            }catch(Exception ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getSupportProviderName().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                supportProviderNameActionPerformed(e);
            }catch(Exception ex){
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
   * �u����T�[�r�X�쐬�ҕύX�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void planManufacturerActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u���Ə����ύX�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void supportProviderNameActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u���p�[/�񋟕[�̈���v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void printActionPerformed(ActionEvent e) throws Exception;

  //�ϐ���`

  public static final int PROCESS_TYPE_PLAN = 1;
  public static final int PROCESS_TYPE_RESULT = 2;
  private int processType;
  private int patientID;
  private Date targetDateSource;
  private VRList serviceData = new VRArrayList();
  //getter/setter

  /**
   * processType��Ԃ��܂��B
   * @return processType
   */
  protected int getProcessType(){
    return processType;
  }
  /**
   * processType��ݒ肵�܂��B
   * @param processType processType
   */
  protected void setProcessType(int processType){
    this.processType = processType;
  }

  /**
   * patientID��Ԃ��܂��B
   * @return patientID
   */
  protected int getPatientID(){
    return patientID;
  }
  /**
   * patientID��ݒ肵�܂��B
   * @param patientID patientID
   */
  protected void setPatientID(int patientID){
    this.patientID = patientID;
  }

  /**
   * targetDateSource��Ԃ��܂��B
   * @return targetDateSource
   */
  protected Date getTargetDateSource(){
    return targetDateSource;
  }
  /**
   * targetDateSource��ݒ肵�܂��B
   * @param targetDateSource targetDateSource
   */
  protected void setTargetDateSource(Date targetDateSource){
    this.targetDateSource = targetDateSource;
  }

  /**
   * serviceData��Ԃ��܂��B
   * @return serviceData
   */
  protected VRList getServiceData(){
    return serviceData;
  }
  /**
   * serviceData��ݒ肵�܂��B
   * @param serviceData serviceData
   */
  protected void setServiceData(VRList serviceData){
    this.serviceData = serviceData;
  }

  //�����֐�

  /**
   * �u�����l�ݒ�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   *
   */
  public abstract void setInitValue() throws Exception;

  /**
   * �u��ʂ̏�����Ԃ̐ݒ�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   *
   */
  public abstract void setInitState() throws Exception;

  /**
   * �u������x�����ƎҎ��Ə����̏�Ԑݒ�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   *
   */
  public abstract void setProviderComponentState() throws Exception;

}
