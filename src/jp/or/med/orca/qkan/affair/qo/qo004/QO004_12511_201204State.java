
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
 * �J����: �A�� ��C
 * �쐬��: 2012/02/01  ���{�R���s���[�^�[������� �A�� ��C �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���̑��@�\ (O)
 * �v���Z�X ���Ə��o�^ (004)
 * �v���O���� ���\�h�Z�������×{���(���V�l�ی��{��) (QO004_12511_201204)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qo.qo004;
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
/**
 * ���\�h�Z�������×{���(���V�l�ی��{��)��Ԓ�`(QO004_12511_201204) 
 */
public class QO004_12511_201204State extends QO004_12511_201204Design {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QO004_12511_201204State(){
  }

  /**
   * �u�p�l���S�̗L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_SET_PANEL_TRUE() throws Exception {

        getMainGroup().setEnabled(true);

  }

  /**
   * �u�p�l���S�̖����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_SET_PANEL_FALSE() throws Exception {

        getMainGroup().setEnabled(false);

  }

  /**
   * �u���V�l�ی��{�݁iI�j�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_FACILITY_TYPE_1() throws Exception {

        getUnitCareMaintenance().setEnabled(false);
        getUnitCareMaintenance().getParent().setEnabled(false);

        getStaffAssignment1Division().setEnabled(true);

        getStaffAssignment2Division().setEnabled(false);

        getMedicalSystemUpkeep().setEnabled(false);
        getMedicalSystemUpkeep().getParent().setEnabled(false);

        getRehabilitationDetailsContainer().setEnabled(false);

        getSpecialMedicalDetailsContaine().setEnabled(false);

  }

  /**
   * �u���j�b�g�^���V�l�ی��{�݁iI�j�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_FACILITY_TYPE_2() throws Exception {

        getUnitCareMaintenance().setEnabled(true);
        getUnitCareMaintenance().getParent().setEnabled(true);

        getStaffAssignment1Division().setEnabled(true);

        getStaffAssignment2Division().setEnabled(false);

        getMedicalSystemUpkeep().setEnabled(false);
        getMedicalSystemUpkeep().getParent().setEnabled(false);

        getRehabilitationDetailsContainer().setEnabled(false);

        getSpecialMedicalDetailsContaine().setEnabled(false);

  }

  /**
   * �u���V�l�ی��{�݁iII�j�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_FACILITY_TYPE_3() throws Exception {

        getUnitCareMaintenance().setEnabled(false);
        getUnitCareMaintenance().getParent().setEnabled(false);

        getStaffAssignment1Division().setEnabled(false);

        getStaffAssignment2Division().setEnabled(true);

        getMedicalSystemUpkeep().setEnabled(true);
        getMedicalSystemUpkeep().getParent().setEnabled(true);

        getRehabilitationDetailsContainer().setEnabled(true);

        getSpecialMedicalDetailsContaine().setEnabled(true);

  }

  /**
   * �u���j�b�g�^���V�l�ی��{�݁iII�j�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_FACILITY_TYPE_4() throws Exception {

        getUnitCareMaintenance().setEnabled(true);
        getUnitCareMaintenance().getParent().setEnabled(true);

        getStaffAssignment1Division().setEnabled(false);

        getStaffAssignment2Division().setEnabled(true);

        getMedicalSystemUpkeep().setEnabled(true);
        getMedicalSystemUpkeep().getParent().setEnabled(true);

        getRehabilitationDetailsContainer().setEnabled(true);

        getSpecialMedicalDetailsContaine().setEnabled(true);

  }

  /**
   * �u���V�l�ی��{�݁iIII�j�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_FACILITY_TYPE_5() throws Exception {

        getUnitCareMaintenance().setEnabled(false);
        getUnitCareMaintenance().getParent().setEnabled(false);

        getStaffAssignment1Division().setEnabled(false);

        getStaffAssignment2Division().setEnabled(true);

        getMedicalSystemUpkeep().setEnabled(true);
        getMedicalSystemUpkeep().getParent().setEnabled(true);

        getRehabilitationDetailsContainer().setEnabled(true);

        getSpecialMedicalDetailsContaine().setEnabled(true);

  }

  /**
   * �u���j�b�g�^���V�l�ی��{�݁iIII�j�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_FACILITY_TYPE_6() throws Exception {

        getUnitCareMaintenance().setEnabled(true);
        getUnitCareMaintenance().getParent().setEnabled(true);

        getStaffAssignment1Division().setEnabled(false);

        getStaffAssignment2Division().setEnabled(true);

        getMedicalSystemUpkeep().setEnabled(true);
        getMedicalSystemUpkeep().getParent().setEnabled(true);

        getRehabilitationDetailsContainer().setEnabled(true);

        getSpecialMedicalDetailsContaine().setEnabled(true);

  }

}
