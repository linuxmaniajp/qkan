
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
 * �쐬��: 2016/09/07  ���{�R���s���[�^�[������� ����@��F �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �\��Ǘ� (S)
 * �v���Z�X �T�[�r�X�\�� (001)
 * �v���O���� �v��P�ʐ��ҏW��� (QS001004)
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
 * �v��P�ʐ��ҏW��ʃC�x���g��`(QS001004) 
 */
public abstract class QS001004Event extends QS001004SQL {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001004Event(){
    addEvents();
  }
  /**
   * �C�x���g�����������`���܂��B
   */
  protected void addEvents() {
    getClose().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                closeActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getOk().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                okActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getProvider().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                providerActionPerformed(e);
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
   * �u�j�����ĕ���v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void closeActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u�ۑ����ĕ���v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void okActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u�Ώێ��Ə��I���v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void providerActionPerformed(ActionEvent e) throws Exception;

  //�ϐ���`

  private VRList planUnitModelValue = new VRArrayList();
  private VRMap planUnits = new VRHashMap();
  private boolean applied = false;
  private String selectedProviderID;
  private Date targetDate;
  private VRList targetProviderIds = new VRArrayList();
  private VRList targetServiceCodeKinds = new VRArrayList();
  //getter/setter

  /**
   * planUnitModelValue��Ԃ��܂��B
   * @return planUnitModelValue
   */
  protected VRList getPlanUnitModelValue(){
    return planUnitModelValue;
  }
  /**
   * planUnitModelValue��ݒ肵�܂��B
   * @param planUnitModelValue planUnitModelValue
   */
  protected void setPlanUnitModelValue(VRList planUnitModelValue){
    this.planUnitModelValue = planUnitModelValue;
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

  /**
   * applied��Ԃ��܂��B
   * @return applied
   */
  protected boolean getApplied(){
    return applied;
  }
  /**
   * applied��ݒ肵�܂��B
   * @param applied applied
   */
  protected void setApplied(boolean applied){
    this.applied = applied;
  }

  /**
   * selectedProviderID��Ԃ��܂��B
   * @return selectedProviderID
   */
  protected String getSelectedProviderID(){
    return selectedProviderID;
  }
  /**
   * selectedProviderID��ݒ肵�܂��B
   * @param selectedProviderID selectedProviderID
   */
  protected void setSelectedProviderID(String selectedProviderID){
    this.selectedProviderID = selectedProviderID;
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
   * targetProviderIds��Ԃ��܂��B
   * @return targetProviderIds
   */
  protected VRList getTargetProviderIds(){
    return targetProviderIds;
  }
  /**
   * targetProviderIds��ݒ肵�܂��B
   * @param targetProviderIds targetProviderIds
   */
  protected void setTargetProviderIds(VRList targetProviderIds){
    this.targetProviderIds = targetProviderIds;
  }

  /**
   * targetServiceCodeKinds��Ԃ��܂��B
   * @return targetServiceCodeKinds
   */
  protected VRList getTargetServiceCodeKinds(){
    return targetServiceCodeKinds;
  }
  /**
   * targetServiceCodeKinds��ݒ肵�܂��B
   * @param targetServiceCodeKinds targetServiceCodeKinds
   */
  protected void setTargetServiceCodeKinds(VRList targetServiceCodeKinds){
    this.targetServiceCodeKinds = targetServiceCodeKinds;
  }

  //�����֐�

  /**
   * �u�����ݒ�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @param planUnit VRMap
   * @throws Exception ������O
   * @return boolean
   */
  public abstract boolean showModal(VRMap planUnit) throws Exception;

  /**
   * �u���͒��̌v��P�ʐ��̎擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   * @return VRMap
   */
  public abstract VRMap getSelectedPlanUnits() throws Exception;

  /**
   * �u�m�肵���v��P�ʐ����擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   * @return VRMap
   */
  public abstract VRMap getAppliedValue() throws Exception;

}
