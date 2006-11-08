
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
 * �쐬��: 2006/06/05  ���{�R���s���[�^�[������� �� ���� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �\��Ǘ� (S)
 * �v���Z�X �T�[�r�X�\�� (001)
 * �v���O���� ���ԕ\ (QS001002)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
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
 * ���ԕ\�C�x���g��`(QS001002) 
 */
public abstract class QS001002Event extends QS001002State {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001002Event(){
    addEvents();
  }
  /**
   * �C�x���g�����������`���܂��B
   */
  protected void addEvents() {
    getCoordinatePrivateExpenses().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                coordinatePrivateExpensesActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getDetailsbutton().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                detailsbuttonActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getCalcurate().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                calcurateActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getPlanUnit().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                planUnitActionPerformed(e);
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
   * �u������v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void coordinatePrivateExpensesActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u�W�v���ׁv�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void detailsbuttonActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u�P�ʏW�v�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void calcurateActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u�v��P�ʐ��ҏW�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void planUnitActionPerformed(ActionEvent e) throws Exception;

  //�ϐ���`

  private QS001 ownerAffair;
  private int processType;
  private QS001DaySchedule selectedServiceListBox;
  private QS001Service selectedServiceClass;
  public static final int CALC_MODE_IN_LIMIT_AMOUNT = 1;
  private CareServiceCodeCalcurater calcurater;
  private VRMap patientInsureInfoHeaviest = new VRHashMap();
  private VRMap planUnits = new VRHashMap();
  //getter/setter

  /**
   * ownerAffair��Ԃ��܂��B
   * @return ownerAffair
   */
  protected QS001 getOwnerAffair(){
    return ownerAffair;
  }
  /**
   * ownerAffair��ݒ肵�܂��B
   * @param ownerAffair ownerAffair
   */
  protected void setOwnerAffair(QS001 ownerAffair){
    this.ownerAffair = ownerAffair;
  }

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
   * selectedServiceListBox��Ԃ��܂��B
   * @return selectedServiceListBox
   */
  protected QS001DaySchedule getSelectedServiceListBox(){
    return selectedServiceListBox;
  }
  /**
   * selectedServiceListBox��ݒ肵�܂��B
   * @param selectedServiceListBox selectedServiceListBox
   */
  protected void setSelectedServiceListBox(QS001DaySchedule selectedServiceListBox){
    this.selectedServiceListBox = selectedServiceListBox;
  }

  /**
   * selectedServiceClass��Ԃ��܂��B
   * @return selectedServiceClass
   */
  protected QS001Service getSelectedServiceClass(){
    return selectedServiceClass;
  }
  /**
   * selectedServiceClass��ݒ肵�܂��B
   * @param selectedServiceClass selectedServiceClass
   */
  protected void setSelectedServiceClass(QS001Service selectedServiceClass){
    this.selectedServiceClass = selectedServiceClass;
  }

  /**
   * calcurater��Ԃ��܂��B
   * @return calcurater
   */
  protected CareServiceCodeCalcurater getCalcurater(){
    return calcurater;
  }
  /**
   * calcurater��ݒ肵�܂��B
   * @param calcurater calcurater
   */
  protected void setCalcurater(CareServiceCodeCalcurater calcurater){
    this.calcurater = calcurater;
  }

  /**
   * patientInsureInfoHeaviest��Ԃ��܂��B
   * @return patientInsureInfoHeaviest
   */
  protected VRMap getPatientInsureInfoHeaviest(){
    return patientInsureInfoHeaviest;
  }
  /**
   * patientInsureInfoHeaviest��ݒ肵�܂��B
   * @param patientInsureInfoHeaviest patientInsureInfoHeaviest
   */
  protected void setPatientInsureInfoHeaviest(VRMap patientInsureInfoHeaviest){
    this.patientInsureInfoHeaviest = patientInsureInfoHeaviest;
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

  //�����֐�

  /**
   * �u��ʓW�J���C�x���g�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @param ownerAffair QS001
   * @throws Exception ������O
   *
   */
  public abstract void initialize(QS001 ownerAffair) throws Exception;

  /**
   * �u���ԕ\�X�V���C�x���g�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   *
   */
  public abstract void recalcServiceTotal() throws Exception;

  /**
   * �u�Ώ۔N����ݒ�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @param targetDate Date
   * @throws Exception ������O
   *
   */
  public abstract void setTargetDate(Date targetDate) throws Exception;

  /**
   * �u�T�[�r�X�`��p�̃Z�������_���ݒ�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @param renderer ListCellRenderer
   * @throws Exception ������O
   *
   */
  public abstract void setCellRenderer(ListCellRenderer renderer) throws Exception;

  /**
   * �u�T�[�r�X�}�X�^�ݒ�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @param serviceMaster VRMap
   * @throws Exception ������O
   *
   */
  public abstract void setMasterService(VRMap serviceMaster) throws Exception;

  /**
   * �u�X�P�W���[���S�̂�ݒ�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @param schedules VRList
   * @throws Exception ������O
   *
   */
  public abstract void setSchedule(VRList schedules) throws Exception;

  /**
   * �u�X�P�W���[���S�̂��擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @param useType int
   * @param includeFreeday boolean
   * @throws Exception ������O
   * @return VRList
   */
  public abstract VRList getSchedule(int useType, boolean includeFreeday) throws Exception;

  /**
   * �u���X�g�I���C�x���g���X�i��ǉ��v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @param listener ListSelectionListener   *
   */
  public abstract void addListSelectionListener(ListSelectionListener listener);

  /**
   * �u���X�g�I���C�x���g���X�i��ǉ��v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @param listener KeyListener   *
   */
  public abstract void addKeyListener(KeyListener listener);

  /**
   * �u�X�P�W���[���������擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   * @return int
   */
  public abstract int getScheduleCount() throws Exception;

  /**
   * �u�X�P�W���[�����������v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   *
   */
  public abstract void clearSchedule() throws Exception;

  /**
   * �u�X�P�W���[�����������v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @param clearBegin Date
   * @throws Exception ������O
   *
   */
  public abstract void clearSchedule(Date clearBegin) throws Exception;

  /**
   * �u�X�P�W���[����ǉ��v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @param schedules VRList
   * @throws Exception ������O
   *
   */
  public abstract void addSchedule(VRList schedules) throws Exception;

  /**
   * �u�T�[�r�X�̑I���v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @param service QS001Service
   * @param selectedServiceListBox QS001DaySchedule
   * @throws Exception ������O
   *
   */
  public abstract void setSelectedService(QS001Service service, QS001DaySchedule selectedServiceListBox) throws Exception;

  /**
   * �u�W�v���ׂ̕\���X�V�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @param managementTotal int
   * @param adjustTotal int
   * @throws Exception ������O
   *
   */
  public abstract void updateTotal(int managementTotal, int adjustTotal) throws Exception;

  /**
   * �u����\�v���`�F�b�N�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   * @return boolean
   */
  public abstract boolean checkPrintable() throws Exception;

  /**
   * �uDB�}�l�[�W���擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   * @return ACDBManager
   */
  public abstract ACDBManager getDBManager() throws Exception;

  /**
   * �u�v���F�藚���擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   * @return VRList
   */
  public abstract VRList getPatientInsureInfoHistoryList() throws Exception;

  /**
   * �u���Ə����n�b�V���擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   * @return VRMap
   */
  public abstract VRMap getHashedProviders() throws Exception;

  /**
   * �u�J�n���̓���ł��Ȃ��T�[�r�X���X�g�擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   * @return QS001DaySchedule
   */
  public abstract QS001DaySchedule getDayFreeServices() throws Exception;

  /**
   * �u�v��P�ʐ����擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   * @return VRMap
   */
  public abstract VRMap getServicePlanUnits() throws Exception;

  /**
   * �u�v��P�ʐ���ݒ�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @param services VRMap
   * @throws Exception ������O
   *
   */
  public abstract void setServicePlanUnits(VRMap services) throws Exception;

}
