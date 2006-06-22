
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
 * �쐬��: 2006/03/09  ���{�R���s���[�^�[������� �� ���� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���̑� (O)
 * �v���Z�X �ݒ�ύX�E�����e�i���X (005)
 * �v���O���� �ݒ�ύX�E�����e�i���X (QO005)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qo.qo005;
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
import jp.or.med.orca.qkan.lib.*;
import jp.or.med.orca.qkan.text.*;

/**
 * �ݒ�ύX�E�����e�i���X�C�x���g��`(QO005) 
 */
public abstract class QO005Event extends QO005State {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QO005Event(){
    addEvents();
  }
  /**
   * �C�x���g�����������`���܂��B
   */
  protected void addEvents() {
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
    getServerSelectRadios().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                serverSelectRadiosActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getDbFileSelectFileCompareButton().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                dbFileSelectFileCompareButtonActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getBackup().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                backupActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getRestore().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                restoreActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getPdfFileSelectFileCompareButton().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                pdfFileSelectFileCompareButtonActionPerformed(e);
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
   * �u�ݒ�t�@�C���̍X�V�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void updateActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u��ʂ̏�Ԑݒ�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void serverSelectRadiosActionPerformed(ActionEvent e) throws Exception;

  /**
   * �uDB�t�@�C���Q�Ɓv�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void dbFileSelectFileCompareButtonActionPerformed(ActionEvent e) throws Exception;

  /**
   * �uFDB�t�@�C���o�b�N�A�b�v�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void backupActionPerformed(ActionEvent e) throws Exception;

  /**
   * �uFDB�t�@�C�����X�g�A�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void restoreActionPerformed(ActionEvent e) throws Exception;

  /**
   * �uPDF�t�@�C���Q�Ɓv�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void pdfFileSelectFileCompareButtonActionPerformed(ActionEvent e) throws Exception;

  //�ϐ���`

  public static final int SERVER_RADIO_LOCAL = 1;
  public static final int SERVER_RADIO_REMOTE = 2;
  public static final int SELECT_OK = 1;
  public static final int SELECT_CANCEL = 2;
  public static final int CHECKBOX_ON = 1;
  public static final int CHECKBOX_OFF = 0;
  public static final String[] FB_FILE_EXTENSIONS = {"old", "fdb"};
  public static final String[] PDF_FILE_EXTENSIONS = {"exe"};
  private boolean updateSuccessed;
  //getter/setter

  /**
   * updateSuccessed��Ԃ��܂��B
   * @return updateSuccessed
   */
  protected boolean getUpdateSuccessed(){
    return updateSuccessed;
  }
  /**
   * updateSuccessed��ݒ肵�܂��B
   * @param updateSuccessed updateSuccessed
   */
  protected void setUpdateSuccessed(boolean updateSuccessed){
    this.updateSuccessed = updateSuccessed;
  }

  //�����֐�

  /**
   * �u��Ԃ̐ؑցv�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   *
   */
  public abstract void setServerSelectIpTextState() throws Exception;

  /**
   * �u�ݒ���捞�����v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   *
   */
  public abstract void doLoad() throws Exception;

  /**
   * �u�ݒ���t�@�C������Ǎ��v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   * @return VRMap
   */
  public abstract VRMap loadSettingFile() throws Exception;

  /**
   * �u�ݒ���ۑ������v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   * @return boolean
   */
  public abstract boolean doSave() throws Exception;

  /**
   * �u�ݒ���t�@�C���ɕۑ��v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @param params VRMap
   * @throws Exception ������O
   * @return boolean
   */
  public abstract boolean saveSettingFile(VRMap params) throws Exception;

  /**
   * �u��ʏ����l�̐ݒ�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   *
   */
  public abstract void setInitValue() throws Exception;

  /**
   * �u�t�@�C���̃R�s�[�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @param orgFile String
   * @param newFile String
   * @throws Exception ������O
   *
   */
  public abstract void fileCpy(String orgFile, String newFile) throws Exception;

  /**
   * �u�g���q�t���t�@�C�������擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @param fileName String
   * @param defaultExtensionIndex int
   * @param extensions String[]
   * @throws Exception ������O
   * @return String
   */
  public abstract String getFBFilePathWithExtension(String fileName, int defaultExtensionIndex, String[] extensions) throws Exception;

  /**
   * �u�g���q�t���t�@�C�������擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @param fileName String
   * @param defaultExtensionIndex int
   * @param extensions String[]
   * @throws Exception ������O
   * @return String
   */
  public abstract String getPDFFilePathWithExtension(String fileName, int defaultExtensionIndex, String[] extensions) throws Exception;

  /**
   * �uDB�̐ڑ������v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @param params VRMap
   * @throws Exception ������O
   * @return boolean
   */
  public abstract boolean checkDBConnect(VRMap params) throws Exception;

	/**
	 * �f�t�H���g�̃t�@�C�������擾���܂��B
	 * 
	 * @param fileExtension
	 *            �g���q
	 * @return �t�@�C����
	 */
	public abstract String getDefaultFileName(String fileExtension) throws Exception;
}
