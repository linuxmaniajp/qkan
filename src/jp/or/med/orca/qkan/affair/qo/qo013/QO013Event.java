
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
 * �쐬��: 2008/09/18  ���{�R���s���[�^�[������� ����@��F �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���̑��@�\ (O)
 * �v���Z�X ����W�����Z�v�g�\�t�g�A�g (013)
 * �v���O���� ����W�����Z�v�g�\�t�g�A�g (QO013)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qo.qo013;
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
import jp.nichicom.ac.util.splash.ACSplashable;
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
 * ����W�����Z�v�g�\�t�g�A�g�C�x���g��`(QO013) 
 */
public abstract class QO013Event extends QO013SQL {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QO013Event(){
    addEvents();
  }
  /**
   * �C�x���g�����������`���܂��B
   */
  protected void addEvents() {
    getConnect().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                connectActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getImportPatient().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                importPatientActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getPreviewPage().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                previewPageActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getNextPage().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                nextPageActionPerformed(e);
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
   * �u�ʐM�����v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void connectActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u��荞�ݏ����v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void importPatientActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u�O�փ{�^�������v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void previewPageActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u���փ{�^�������v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void nextPageActionPerformed(ActionEvent e) throws Exception;

  //�ϐ���`

  private String port;
  private String ip;
  private String user;
  private String pass;
  private String dbsVer;
  private String toHiraganaConvert;
  private String receiptVersion;
  public static final int PAGE_COUNT = 100;
  public static final int CODE_RECEIPT_VERSION = 271;
  public static final int DEFAULT_RECEIPT_VERSION_INDEX = 1;
  private int nowPage;
  private Integer hospNum;
  private ACTableModelAdapter receiptTableModel;
  private VRList receiptDataList = new VRArrayList();
  //getter/setter

  /**
   * port��Ԃ��܂��B
   * @return port
   */
  protected String getPort(){
    return port;
  }
  /**
   * port��ݒ肵�܂��B
   * @param port port
   */
  protected void setPort(String port){
    this.port = port;
  }

  /**
   * ip��Ԃ��܂��B
   * @return ip
   */
  protected String getIp(){
    return ip;
  }
  /**
   * ip��ݒ肵�܂��B
   * @param ip ip
   */
  protected void setIp(String ip){
    this.ip = ip;
  }

  /**
   * user��Ԃ��܂��B
   * @return user
   */
  protected String getUser(){
    return user;
  }
  /**
   * user��ݒ肵�܂��B
   * @param user user
   */
  protected void setUser(String user){
    this.user = user;
  }

  /**
   * pass��Ԃ��܂��B
   * @return pass
   */
  protected String getPass(){
    return pass;
  }
  /**
   * pass��ݒ肵�܂��B
   * @param pass pass
   */
  protected void setPass(String pass){
    this.pass = pass;
  }

  /**
   * dbsVer��Ԃ��܂��B
   * @return dbsVer
   */
  protected String getDbsVer(){
    return dbsVer;
  }
  /**
   * dbsVer��ݒ肵�܂��B
   * @param dbsVer dbsVer
   */
  protected void setDbsVer(String dbsVer){
    this.dbsVer = dbsVer;
  }

  /**
   * toHiraganaConvert��Ԃ��܂��B
   * @return toHiraganaConvert
   */
  protected String getToHiraganaConvert(){
    return toHiraganaConvert;
  }
  /**
   * toHiraganaConvert��ݒ肵�܂��B
   * @param toHiraganaConvert toHiraganaConvert
   */
  protected void setToHiraganaConvert(String toHiraganaConvert){
    this.toHiraganaConvert = toHiraganaConvert;
  }

  /**
   * receiptVersion��Ԃ��܂��B
   * @return receiptVersion
   */
  protected String getReceiptVersion(){
    return receiptVersion;
  }
  /**
   * receiptVersion��ݒ肵�܂��B
   * @param receiptVersion receiptVersion
   */
  protected void setReceiptVersion(String receiptVersion){
    this.receiptVersion = receiptVersion;
  }

  /**
   * nowPage��Ԃ��܂��B
   * @return nowPage
   */
  protected int getNowPage(){
    return nowPage;
  }
  /**
   * nowPage��ݒ肵�܂��B
   * @param nowPage nowPage
   */
  protected void setNowPage(int nowPage){
    this.nowPage = nowPage;
  }

  /**
   * hospNum��Ԃ��܂��B
   * @return hospNum
   */
  protected Integer getHospNum(){
    return hospNum;
  }
  /**
   * hospNum��ݒ肵�܂��B
   * @param hospNum hospNum
   */
  protected void setHospNum(Integer hospNum){
    this.hospNum = hospNum;
  }

  /**
   * receiptTableModel��Ԃ��܂��B
   * @return receiptTableModel
   */
  protected ACTableModelAdapter getReceiptTableModel(){
    return receiptTableModel;
  }
  /**
   * receiptTableModel��ݒ肵�܂��B
   * @param receiptTableModel receiptTableModel
   */
  protected void setReceiptTableModel(ACTableModelAdapter receiptTableModel){
    this.receiptTableModel = receiptTableModel;
  }

  /**
   * receiptDataList��Ԃ��܂��B
   * @return receiptDataList
   */
  protected VRList getReceiptDataList(){
    return receiptDataList;
  }
  /**
   * receiptDataList��ݒ肵�܂��B
   * @param receiptDataList receiptDataList
   */
  protected void setReceiptDataList(VRList receiptDataList){
    this.receiptDataList = receiptDataList;
  }

  //�����֐�

  /**
   * �u�����ݒ�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   *
   */
  public abstract void initialize() throws Exception;

  /**
   * �u�ʐM�ݒ�Ǎ��݁v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   *
   */
  public abstract void readProperty() throws Exception;

  /**
   * �u�ʐM�ݒ菑�����݁v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   *
   */
  public abstract void saveProperty() throws Exception;

  /**
   * �u�d�����Җ��`�F�b�N�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @param list VRList
   * @throws Exception ������O
   * @return VRList
   */
  public abstract VRList checkSameName(VRList list) throws Exception;

  /**
   * �u�����Z�f�[�^�ϊ������v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @param list VRList
   * @throws Exception ������O
   * @return VRList
   */
  public abstract VRList convertQkanData(VRList list) throws Exception;

  /**
   * �u��荞�݊��҃f�[�^��荞�ݏ����v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   * @return boolean
   */
  public abstract boolean doInsert() throws Exception;

  /**
   * �u��荞�݊��Ҏ擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   * @return VRList
   */
  public abstract VRList getInsertCheckedRows() throws Exception;

  /**
   * �u�����Z�f�[�^�擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   *
   */
  public abstract void doFind() throws Exception;

  /**
   * �u�X�v���b�V�������v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @param splash ACSplashable
   * @throws Exception ������O
   * @return ACSplashable
   */
  public abstract ACSplashable closeSplash(ACSplashable splash) throws Exception;

  /**
   * �u�ꎞ�̈悩�犳�҂��擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @param begin int
   * @param end int
   * @throws Exception ������O
   * @return VRList
   */
  public abstract VRList readFromAccessSpace(int begin, int end) throws Exception;

  /**
   * �u�ݒ蕜���v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   *
   */
  public abstract void setRestoration() throws Exception;

  /**
   * �u�d�b�ԍ��ϊ��v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @param src String
   * @throws Exception ������O
   * @return String
   */
  public abstract String toNotTelCharReplace(String src) throws Exception;

  /**
   * �u�y�[�W����{�^����Ԑ���v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   *
   */
  public abstract void pageButtonState() throws Exception;

  /**
   * �u1�ŕ��̃f�[�^�擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @param begin int
   * @param end int
   * @throws Exception ������O
   * @return VRList
   */
  public abstract VRList getPageData(int begin, int end) throws Exception;

}
