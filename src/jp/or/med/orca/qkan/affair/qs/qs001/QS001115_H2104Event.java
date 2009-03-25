
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
 * �J����: �c���@����
 * �쐬��: 2009/03/07  ���{�R���s���[�^�[������� �c���@���� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �T�[�r�X�\��쐬/�ύX (S)
 * �v���Z�X �T�[�r�X�\�� (001)
 * �v���O���� �T�[�r�X�p�^�[������{�ݓ����Ґ������ (QS001115_H2104)
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
 * �T�[�r�X�p�^�[������{�ݓ����Ґ������C�x���g��`(QS001115_H2104) 
 */
public abstract class QS001115_H2104Event extends QS001115_H2104State implements QS001Service {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001115_H2104Event(){
    addEvents();
  }
  /**
   * �C�x���g�����������`���܂��B
   */
  protected void addEvents() {
    getOutsideServiceRadio().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                outsideServiceRadioActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getFacilitiesDivisionRadio().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                facilitiesDivisionRadioActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getSpecificFacilityBeginTime().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                specificFacilityBeginTimeActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getVisitCareCombo().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                visitCareComboActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getVisitNursingCombo().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                visitNursingComboActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getExpertPlaceNursingCombo().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                expertPlaceNursingComboActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getExpertPlaceRehabiliCombo().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                expertPlaceRehabiliComboActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getVisitNursingFacilitiesDivisionRadio().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                visitNursingFacilitiesDivisionRadioActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getVisitNursingStaffDivisionRadio().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                visitNursingStaffDivisionRadioActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getExpertPlaceNursingRadio().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                expertPlaceNursingRadioActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getProviderDivisionRadio().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                providerDivisionRadioActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getTimeDivisionRadio().addListSelectionListener(new ListSelectionListener(){
        private boolean lockFlag = false;
        public void valueChanged(ListSelectionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                timeDivisionRadioSelectionChanged(e);
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
   * �u�敪�I���v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void outsideServiceRadioActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u�{�݋敪�I���v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void facilitiesDivisionRadioActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u�J�n�����I���v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void specificFacilityBeginTimeActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u�K���쎞�ԋ敪�I���v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void visitCareComboActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u�K��Ō쎞�ԋ敪�I���v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void visitNursingComboActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u�ʏ���쎞�ԋ敪�I���v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void expertPlaceNursingComboActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u�ʏ����n���ԋ敪�I���v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void expertPlaceRehabiliComboActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u�K��Ō�{�݋敪�I���v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void visitNursingFacilitiesDivisionRadioActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u�K��Ō�E���敪�I���v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void visitNursingStaffDivisionRadioActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u�ʏ����{�݋敪�I���v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void expertPlaceNursingRadioActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u�F�m�ǑΉ��ʏ����{�݋敪�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void providerDivisionRadioActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u�F�m�ǑΉ��^�ʏ���쎞�ԋ敪�I���v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void timeDivisionRadioSelectionChanged(ListSelectionEvent e) throws Exception;

  //�ϐ���`

  private boolean functionTrainingFlag;
  private boolean nightNurseFlag;
  //getter/setter

  /**
   * functionTrainingFlag��Ԃ��܂��B
   * @return functionTrainingFlag
   */
  protected boolean getFunctionTrainingFlag(){
    return functionTrainingFlag;
  }
  /**
   * functionTrainingFlag��ݒ肵�܂��B
   * @param functionTrainingFlag functionTrainingFlag
   */
  protected void setFunctionTrainingFlag(boolean functionTrainingFlag){
    this.functionTrainingFlag = functionTrainingFlag;
  }

  /**
   * nightNurseFlag��Ԃ��܂��B
   * @return nightNurseFlag
   */
  protected boolean getNightNurseFlag(){
    return nightNurseFlag;
  }
  /**
   * nightNurseFlag��ݒ肵�܂��B
   * @param nightNurseFlag nightNurseFlag
   */
  protected void setNightNurseFlag(boolean nightNurseFlag){
    this.nightNurseFlag = nightNurseFlag;
  }

  //�����֐�

  /**
   * �u�������v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   *
   */
  public abstract void initialize() throws Exception;

  /**
   * �u���Ə��R���{�ύX���֐��v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @param provider VRMap
   * @throws Exception ������O
   *
   */
  public abstract void providerSelected(VRMap provider) throws Exception;

  /**
   * �u���͓��e�̕s���������v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   * @return VRMap
   */
  public abstract VRMap getValidData() throws Exception;

  /**
   * �u���Ə����̕K�v�����擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   * @return boolean
   */
  public abstract boolean isUseProvider() throws Exception;

  /**
   * �u�J�n�������͗p�̃R���{�擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   * @return ACComboBox
   */
  public abstract ACComboBox getBeginTimeCombo() throws Exception;

  /**
   * �u�I���������͗p�̃R���{�擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   * @return ACComboBox
   */
  public abstract ACComboBox getEndTimeCombo() throws Exception;

  /**
   * �u�I�����Ԑݒ菈���v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   *
   */
  public abstract void checkEndTime() throws Exception;

  /**
   * �u�K��Ō쎞�Ԏ擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   * @return int
   */
  public abstract int getHoumonKangoTime() throws Exception;

  /**
   * �u�K��Ō쎞�Ԏ擾_�w��K��Ō�X�e�[�V�����v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   * @return int
   */
  public abstract int getHoumonKangoTimeSpecial() throws Exception;

  /**
   * �u�K���쎞�Ԏ擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   * @return int
   */
  public abstract int getKangoTime() throws Exception;

  /**
   * �u�F�m�ǑΉ��^�ʏ���쎞�Ԏ擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   * @return int
   */
  public abstract int getNintiTaiouTusyoKaigoTime() throws Exception;

  /**
   * �u�ʏ���쎞�Ԏ擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   * @return int
   */
  public abstract int getTuusyoKaigoTime() throws Exception;

  /**
   * �u�ʏ���쎞�Ԏ擾_2�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   * @return int
   */
  public abstract int getTuusyoKaigoTimeSpecial() throws Exception;

  /**
   * �u�ʏ����n���Ԏ擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   * @return int
   */
  public abstract int getTuusyoRihaTime() throws Exception;

  /**
   * �u�T�[�r�X�@�����敪�擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   * @return int
   */
  public abstract int getServiceLowVersion() throws Exception;

}
