
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
 * �쐬��: 2006/03/11  ���{�R���s���[�^�[������� �� ���� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �\��Ǘ� (S)
 * �v���Z�X �T�[�r�X�\��E���� (001)
 * �v���O���� ���p�E�񋟕[��� (QS001031)
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
import jp.nichicom.ac.container.*;
import jp.nichicom.ac.core.*;
import jp.nichicom.ac.filechooser.*;
import jp.nichicom.ac.io.*;
import jp.nichicom.ac.lang.*;
import jp.nichicom.ac.lib.care.claim.print.schedule.CareServiceCodeCalcurater;
import jp.nichicom.ac.lib.care.claim.print.schedule.CareServicePrintParameter;
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
import jp.or.med.orca.qkan.text.*;

/**
 * ���p�E�񋟕[����C�x���g��`(QS001031) 
 */
public abstract class QS001031Event extends QS001031SQL {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001031Event(){
    addEvents();
  }
  /**
   * �C�x���g�����������`���܂��B
   */
  protected void addEvents() {
    getPlanManufacturer().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                planManufacturerActionPerformed(e);
            }catch(Throwable ex){
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
    getEnd().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                endActionPerformed(e);
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

  /**
   * �u����v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void endActionPerformed(ActionEvent e) throws Exception;

  //�ϐ���`

  private int processType;
  private VRList serviceData = new VRArrayList();
  private CareServiceCodeCalcurater calcurater;
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

  //�����֐�

  /**
   * �u��ʓW�J���C�x���g�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @param calcurater QS001ServiceCodeCalcurater
   * @param serviceData VRList
   * @param processType int
   * @throws Exception ������O
   *
   */
  public abstract void showModal(CareServiceCodeCalcurater calcurater, VRList serviceData, int processType) throws Exception;

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

  /**
   * �u���p��ID�擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   * @return int
   */
  public abstract int getPatientID() throws Exception;

  /**
   * �u��������҃t���O���擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   * @return int
   */
  public abstract int getInSpecialFacilityFlag() throws Exception;

  /**
   * �u�Ώ۔N���擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   * @return Date
   */
  public abstract Date getTargetDateSource() throws Exception;

  /**
   * �u�v���F�藚���擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   * @return VRList
   */
  public abstract VRList getPatientInsureInfoHistoryList() throws Exception;

  /**
   * �u�T�[�r�X��ޏW���擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   * @return VRList
   */
  public abstract VRList getServiceKindsList() throws Exception;

  /**
   * �u���Ə����n�b�V���擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   * @return VRMap
   */
  public abstract VRMap getHashedProviders() throws Exception;

  /**
   * �u�{�\����v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @param writer ACChotarouXMLWriter
   * @param mainFormat String
   * @param pages List
   * @param invisibles List
   * @param allTexts Map
   * @throws Exception ������O
   *
   */
  public abstract void printMainTable(ACChotarouXMLWriter writer, String mainFormat, List pages, List invisibles, Map allTexts) throws Exception;

  /**
   * �u�ʕ\����v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @param writer ACChotarouXMLWriter
   * @param subFormat String
   * @param pages List
   * @throws Exception ������O
   *
   */
  public abstract void printSubTable(ACChotarouXMLWriter writer, String subFormat, List pages) throws Exception;

  /**
   * �u����v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @param writer ACChotarouXMLWriter
   * @param buildParam QS001ServicePrintParameter
   * @param printMain, String mainFormat, List mainInsuredPages boolean
   * @param allTexts HashMap
   * @param printSub, String subFormat, List subInsuredPages boolean
   * @throws Exception ������O
   *
   */
  public abstract void print(ACChotarouXMLWriter writer, CareServicePrintParameter buildParam, boolean printMain, String mainFormat, List mainInsuredPages, HashMap allTexts, boolean printSub, String subFormat, List subInsuredPages) throws Exception;

}
