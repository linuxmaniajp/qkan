
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
 * �J����: 
 * �쐬��: 2016/09/09  ���{�R���s���[�^�[�������  �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���̑��@�\ (O)
 * �v���Z�X �������ƃT�[�r�X�R�[�h�捞 (015)
 * �v���O���� �������ƃT�[�r�X�R�[�h�捞 (QO015)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qo.qo015;
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
 * �������ƃT�[�r�X�R�[�h�捞�C�x���g��`(QO015) 
 */
public abstract class QO015Event extends QO015SQL {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QO015Event(){
    addEvents();
  }
  /**
   * �C�x���g�����������`���܂��B
   */
  protected void addEvents() {
    getCsvFileSelectFileCompareButton().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                csvFileSelectFileCompareButtonActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getImportButton().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                importButtonActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getEditButton().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                editButtonActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getHistoryInfoTable().addMouseListener(new MouseAdapter(){
        private boolean lockFlag = false;
        public void mouseClicked(MouseEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                if (e.getClickCount() == 2) {
                    historyInfoTableMouseClicked(e);
                }
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
   * �uCSV�t�@�C���Q�Ɓv�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void csvFileSelectFileCompareButtonActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u�捞�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void importButtonActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u�ҏW�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void editButtonActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u��ʑJ�ڏ����v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void historyInfoTableMouseClicked(MouseEvent e) throws Exception;

  //�ϐ���`

  public static final String[] CSV_FILE_EXTENSIONS = {"csv"};
  public static final String MESSAGE_FILE_OPEN_DIALOG_TITLE = "CSV�t�@�C�����w�肵�ĉ�����";
  public static final String ERROR_CSV_FILE_CAN_NOT_READ = "CSV�t�@�C���̓ǂݍ��݂Ɏ��s���܂���";
  public static final String ERROR_FILE_NOT_SELECTED = "CSV�t�@�C�����w�肵�ĉ�����";
  public static final String ERROR_SELECTED_FILE_NOT_FOUND = "�I�����ꂽ�t�@�C���͑��݂��܂���ł���";
  public static final String ERROR_DATA_NOT_FOUND = "�f�[�^�����݂��܂���B";
  public static final String ERROR_DATA_NOT_FOUND_INSURERID = "�ی��Ҕԍ����擾�ł��Ă��܂���B";
  public static final String MESSAGE_SPLASH_TEXT1 = "CSV�t�@�C����񃌃R�[�h��͒�";
  public static final String MESSAGE_SPLASH_TEXT2 = "CSV�t�@�C���ۑ���";
  public static final int CSV_REC_CNT = 19;
  public static final int COMMON_RECORD_FORMAT_INSURERID = 0;
  public static final int COMMON_RECORD_FORMAT_SERVICE_CODE_KIND = 1;
  private ACPassiveKey M_SJ_SERVICE_CODE_INFO_PASSIVE_CHECK_KEY;
  private String inputCSVFilePath;
  private VRCSVFile inputCSVFile;
  private VRList outputTableList = new VRArrayList();
  private VRList historyInfoList = new VRArrayList();
  private ACTableModelAdapter historyInfoTableModel;
  //getter/setter

  /**
   * M_SJ_SERVICE_CODE_INFO_PASSIVE_CHECK_KEY��Ԃ��܂��B
   * @return M_SJ_SERVICE_CODE_INFO_PASSIVE_CHECK_KEY
   */
  protected ACPassiveKey getM_SJ_SERVICE_CODE_INFO_PASSIVE_CHECK_KEY(){
    return M_SJ_SERVICE_CODE_INFO_PASSIVE_CHECK_KEY;
  }
  /**
   * M_SJ_SERVICE_CODE_INFO_PASSIVE_CHECK_KEY��ݒ肵�܂��B
   * @param M_SJ_SERVICE_CODE_INFO_PASSIVE_CHECK_KEY M_SJ_SERVICE_CODE_INFO_PASSIVE_CHECK_KEY
   */
  protected void setM_SJ_SERVICE_CODE_INFO_PASSIVE_CHECK_KEY(ACPassiveKey M_SJ_SERVICE_CODE_INFO_PASSIVE_CHECK_KEY){
    this.M_SJ_SERVICE_CODE_INFO_PASSIVE_CHECK_KEY = M_SJ_SERVICE_CODE_INFO_PASSIVE_CHECK_KEY;
  }

  /**
   * inputCSVFilePath��Ԃ��܂��B
   * @return inputCSVFilePath
   */
  protected String getInputCSVFilePath(){
    return inputCSVFilePath;
  }
  /**
   * inputCSVFilePath��ݒ肵�܂��B
   * @param inputCSVFilePath inputCSVFilePath
   */
  protected void setInputCSVFilePath(String inputCSVFilePath){
    this.inputCSVFilePath = inputCSVFilePath;
  }

  /**
   * inputCSVFile��Ԃ��܂��B
   * @return inputCSVFile
   */
  protected VRCSVFile getInputCSVFile(){
    return inputCSVFile;
  }
  /**
   * inputCSVFile��ݒ肵�܂��B
   * @param inputCSVFile inputCSVFile
   */
  protected void setInputCSVFile(VRCSVFile inputCSVFile){
    this.inputCSVFile = inputCSVFile;
  }

  /**
   * outputTableList��Ԃ��܂��B
   * @return outputTableList
   */
  protected VRList getOutputTableList(){
    return outputTableList;
  }
  /**
   * outputTableList��ݒ肵�܂��B
   * @param outputTableList outputTableList
   */
  protected void setOutputTableList(VRList outputTableList){
    this.outputTableList = outputTableList;
  }

  /**
   * historyInfoList��Ԃ��܂��B
   * @return historyInfoList
   */
  protected VRList getHistoryInfoList(){
    return historyInfoList;
  }
  /**
   * historyInfoList��ݒ肵�܂��B
   * @param historyInfoList historyInfoList
   */
  protected void setHistoryInfoList(VRList historyInfoList){
    this.historyInfoList = historyInfoList;
  }

  /**
   * historyInfoTableModel��Ԃ��܂��B
   * @return historyInfoTableModel
   */
  protected ACTableModelAdapter getHistoryInfoTableModel(){
    return historyInfoTableModel;
  }
  /**
   * historyInfoTableModel��ݒ肵�܂��B
   * @param historyInfoTableModel historyInfoTableModel
   */
  protected void setHistoryInfoTableModel(ACTableModelAdapter historyInfoTableModel){
    this.historyInfoTableModel = historyInfoTableModel;
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
   * �u�������ƃT�[�r�X�R�[�h�捞�������擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   *
   */
  public abstract void doFindHistoryInfo() throws Exception;

  /**
   * �uCSV�f�[�^�擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   * @return boolean
   */
  public abstract boolean csvReader() throws Exception;

  /**
   * �u���R�[�h��́v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   * @return boolean
   */
  public abstract boolean setImportInfo() throws Exception;

  /**
   * �u�捞�\�ȃt�@�C�����`�F�b�N����v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   * @return boolean
   */
  public abstract boolean checkControlRecord() throws Exception;

  /**
   * �u�R���g���[�����R�[�h��́v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   * @return boolean
   */
  public abstract boolean controlRecordParser() throws Exception;

  /**
   * �u�ۑ������v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   * @return boolean
   */
  public abstract boolean doSave() throws Exception;

  /**
   * �uCSV�t�@�C���g���q�⊮�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @param fileName String
   * @param defaultExtensionIndex int
   * @param extensions String[]
   * @throws Exception ������O
   * @return String
   */
  public abstract String getCSVFilePathWithExtension(String fileName, int defaultExtensionIndex, String[] extensions) throws Exception;

  /**
   * �u������i�N���j����t�^�ɕϊ�����v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @param filed String
   * @param mode String
   * @throws Exception ������O
   * @return Date
   */
  public abstract Date convYmToDate(String filed, String mode) throws Exception;

  /**
   * �u������i�N�����j����t�^�ɕϊ�����v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @param filed String
   * @throws Exception ������O
   * @return Date
   */
  public abstract Date convYmdToDate(String filed) throws Exception;

  /**
   * �u�@��ˑ�������u������v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @param str String
   * @throws Exception ������O
   * @return String
   */
  public abstract String convCharacters(String str) throws Exception;

}
