
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
 * �쐬��: 2006/08/28  ���{�R���s���[�^�[������� ��i�@�a�P �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���̑��@�\ (O)
 * �v���Z�X ��^���ҏW (008)
 * �v���O���� ��^���ҏW (QO008)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qo.qo008;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import jp.nichicom.ac.ACCommon;
import jp.nichicom.ac.sql.ACPassiveKey;
import jp.nichicom.ac.util.adapter.ACTableModelAdapter;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;

/**
 * ��^���ҏW�C�x���g��`(QO008) 
 */
public abstract class QO008Event extends QO008SQL {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QO008Event(){
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
    getFixedFormTable().addListSelectionListener(new ListSelectionListener(){
        private boolean lockFlag = false;
        public void valueChanged(ListSelectionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                fixedFormTableSelectionChanged(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getFixedFormEditItemTable().addListSelectionListener(new ListSelectionListener(){
        private boolean lockFlag = false;
        public void valueChanged(ListSelectionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                fixedFormEditItemTableSelectionChanged(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getFixedFormEditInsert().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                fixedFormEditInsertActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getFixedFormEditUpdate().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                fixedFormEditUpdateActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getFixedFormEditDelete().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                fixedFormEditDeleteActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getFixedFormEditCancelDelete().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                fixedFormEditCancelDeleteActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getFixedFormEditItemManipulateButtonUp().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                fixedFormEditItemManipulateButtonUpActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getFixedFormEditItemManipulateButtonDown().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                fixedFormEditItemManipulateButtonDownActionPerformed(e);
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
  protected abstract void updateActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u�\���f�[�^�؂�ւ������v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void fixedFormTableSelectionChanged(ListSelectionEvent e) throws Exception;

  /**
   * �u��^���\�������v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void fixedFormEditItemTableSelectionChanged(ListSelectionEvent e) throws Exception;

  /**
   * �u��^���ǉ������v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void fixedFormEditInsertActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u��^���X�V�����v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void fixedFormEditUpdateActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u��^���폜�����v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void fixedFormEditDeleteActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u��^���폜��������v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void fixedFormEditCancelDeleteActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u���ԌJ��グ�����v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void fixedFormEditItemManipulateButtonUpActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u���ԌJ�艺�������v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void fixedFormEditItemManipulateButtonDownActionPerformed(ActionEvent e) throws Exception;

  //�ϐ���`

  private ACPassiveKey PASSIVE_CHECK_KEY;
  private int dataChangeFlag;
  private int tableType;
  private int fixedFormId;
  public static final String AFFAIR_ID = "QO008";
  public static final int TABLE_TYPE_FIXED_FORM = 1;
  public static final int SQL_MODE_DEFAULT = 0;
  public static final int SQL_MODE_INSERT = 1;
  public static final int SQL_MODE_UPDATE = 2;
  public static final int SQL_MODE_INSERT_TO_UPDATE = 3;
  public static final int SQL_MODE_DELETE = 4;
  public static final int SQL_MODE_UPDATE_TO_DELETE = 6;
  private VRMap listGroupMap = new VRHashMap();
  private VRList fixedFormList = new VRArrayList();
  private ACTableModelAdapter fixedFormGroupTableModel;
  private ACTableModelAdapter fixedFormTableModel;
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
   * dataChangeFlag��Ԃ��܂��B
   * @return dataChangeFlag
   */
  protected int getDataChangeFlag(){
    return dataChangeFlag;
  }
  /**
   * dataChangeFlag��ݒ肵�܂��B
   * @param dataChangeFlag dataChangeFlag
   */
  protected void setDataChangeFlag(int dataChangeFlag){
    this.dataChangeFlag = dataChangeFlag;
  }

  /**
   * tableType��Ԃ��܂��B
   * @return tableType
   */
  protected int getTableType(){
    return tableType;
  }
  /**
   * tableType��ݒ肵�܂��B
   * @param tableType tableType
   */
  protected void setTableType(int tableType){
    this.tableType = tableType;
  }

  /**
   * fixedFormId��Ԃ��܂��B
   * @return fixedFormId
   */
  protected int getFixedFormId(){
    return fixedFormId;
  }
  /**
   * fixedFormId��ݒ肵�܂��B
   * @param fixedFormId fixedFormId
   */
  protected void setFixedFormId(int fixedFormId){
    this.fixedFormId = fixedFormId;
  }

  /**
   * listGroupMap��Ԃ��܂��B
   * @return listGroupMap
   */
  protected VRMap getListGroupMap(){
    return listGroupMap;
  }
  /**
   * listGroupMap��ݒ肵�܂��B
   * @param listGroupMap listGroupMap
   */
  protected void setListGroupMap(VRMap listGroupMap){
    this.listGroupMap = listGroupMap;
  }

  /**
   * fixedFormList��Ԃ��܂��B
   * @return fixedFormList
   */
  protected VRList getFixedFormList(){
    return fixedFormList;
  }
  /**
   * fixedFormList��ݒ肵�܂��B
   * @param fixedFormList fixedFormList
   */
  protected void setFixedFormList(VRList fixedFormList){
    this.fixedFormList = fixedFormList;
  }

  /**
   * fixedFormGroupTableModel��Ԃ��܂��B
   * @return fixedFormGroupTableModel
   */
  protected ACTableModelAdapter getFixedFormGroupTableModel(){
    return fixedFormGroupTableModel;
  }
  /**
   * fixedFormGroupTableModel��ݒ肵�܂��B
   * @param fixedFormGroupTableModel fixedFormGroupTableModel
   */
  protected void setFixedFormGroupTableModel(ACTableModelAdapter fixedFormGroupTableModel){
    this.fixedFormGroupTableModel = fixedFormGroupTableModel;
  }

  /**
   * fixedFormTableModel��Ԃ��܂��B
   * @return fixedFormTableModel
   */
  protected ACTableModelAdapter getFixedFormTableModel(){
    return fixedFormTableModel;
  }
  /**
   * fixedFormTableModel��ݒ肵�܂��B
   * @param fixedFormTableModel fixedFormTableModel
   */
  protected void setFixedFormTableModel(ACTableModelAdapter fixedFormTableModel){
    this.fixedFormTableModel = fixedFormTableModel;
  }

  //�����֐�

  /**
   * �u��ʏ������v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   *
   */
  public abstract void initialize() throws Exception;

  /**
   * �u���������v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   *
   */
  public abstract void doFind() throws Exception;

  /**
   * �u���̓`�F�b�N�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   * @return boolean
   */
  public abstract boolean isValidInput() throws Exception;

  /**
   * �u�ۑ������v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   * @return boolean
   */
  public abstract boolean doSave() throws Exception;

  /**
   * �u�O���[�v���Ƃɂ܂Ƃ߂�Map���쐬����B�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @param list VRList
   * @throws Exception ������O
   *
   */
  public abstract void createGroupMap(VRList list) throws Exception;

}
