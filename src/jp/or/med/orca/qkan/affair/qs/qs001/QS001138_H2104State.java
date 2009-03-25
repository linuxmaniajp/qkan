
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
 * �쐬��: 2009/03/09  ���{�R���s���[�^�[������� �c���@���� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �\��Ǘ� (S)
 * �v���Z�X �T�[�r�X�\�� (001)
 * �v���O���� �T�[�r�X�p�^�[�����\�h�Z�������×{���i���V�l�ی��{�݁j (QS001138_H2104)
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
/**
 * �T�[�r�X�p�^�[�����\�h�Z�������×{���i���V�l�ی��{�݁j��Ԓ�`(QS001138_H2104) 
 */
public class QS001138_H2104State extends QS001138_H2104Design {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001138_H2104State(){
  }

  /**
   * �u�a���敪�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_HOSPITAL_ROOM_DIVISION_ENABLE_FALSE() throws Exception {

        getShortStayRecuperationHealthFacilityHospitalRoomDivisionRadio().setEnabled(false);

  }

  /**
   * �u�a���敪�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_HOSPITAL_ROOM_DIVISION_ENABLE_TRUE() throws Exception {

        getShortStayRecuperationHealthFacilityHospitalRoomDivisionRadio().setEnabled(true);

  }

  /**
   * �u���j�b�g�^�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_UNIT_HOSPITAL_ROOM_DIVISION_ENABEL_FALSE() throws Exception {

        getShortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadio().setEnabled(false);

  }

  /**
   * �u���j�b�g�^�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_UNIT_HOSPITAL_ROOM_DIVISION_ENABEL_TRUE() throws Exception {

        getShortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadio().setEnabled(true);

  }

  /**
   * �u���j�b�g�P�A�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_UNIT_CARE_ENABLE_FALSE() throws Exception {

        getShortStayRecuperationHealthUnitCareAddRadio().setEnabled(false);

  }

  /**
   * �u���j�b�g�P�A�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_UNIT_CARE_ENABLE_TRUE() throws Exception {

        getShortStayRecuperationHealthUnitCareAddRadio().setEnabled(true);

  }

  /**
   * �u���n�r���@�\�������Z�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_REHABILITATION_ENABLE_FALSE() throws Exception {

        getShortStayRecuperationHealthFacilityEtcRehabilitation().setEnabled(false);

  }

  /**
   * �u���n�r���@�\�������Z�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_REHABILITATION_ENABLE_TRUE() throws Exception {

        getShortStayRecuperationHealthFacilityEtcRehabilitation().setEnabled(true);

  }

  /**
   * �u�H���e�L�X�g�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_DINNER_COST_ENABLE_FALSE() throws Exception {

        getShortStayRecuperationHealthFacilityDinnerCost().setEnabled(false);

  }

  /**
   * �u�H���e�L�X�g�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_DINNER_COST_ENABLE_TRUE() throws Exception {

        getShortStayRecuperationHealthFacilityDinnerCost().setEnabled(true);

  }

  /**
   * �u�×{�H���Z�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VALID_MEDICAL_EXPENSES() throws Exception {

        getShortStayRecuperationHealthFacilityDieticianMedicalExpensesRadio().setEnabled(true);

  }

  /**
   * �u�×{�H���Z�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_MEDICAL_EXPENSES() throws Exception {

        getShortStayRecuperationHealthFacilityDieticianMedicalExpensesRadio().setEnabled(false);

  }

  /**
   * �u��N���F�m�Ǘ��p�Ҏ�����Z�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VALID_YOUNG_DEMENTIA_PATINET() throws Exception {

        getYoungDementiaPatinetAddRadioGroup().setEnabled(true);

  }

  /**
   * �u��N���F�m�Ǘ��p�Ҏ�����Z�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_YOUNG_DEMENTIA_PATINET() throws Exception {

        getYoungDementiaPatinetAddRadioGroup().setEnabled(false);

  }

  /**
   * �u�F�m�Ǎs���E�S���Ǐ�ً}�Ή����Z�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VALID_DEMENTIA_ACTION() throws Exception {

        getDementiaActionAddRadioGroup().setEnabled(true);

  }

  /**
   * �u�F�m�Ǎs���E�S���Ǐ�ً}�Ή����Z�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_DEMENTIA_ACTION() throws Exception {

        getDementiaActionAddRadioGroup().setEnabled(false);

  }

}
