
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
 * �T�u�V�X�e�� �T�[�r�X�\�� (S)
 * �v���Z�X �T�[�r�X�p�^�[���Z������������� (001)
 * �v���O���� �T�[�r�X�p�^�[���Z������������� (QS001109_H2104)
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
 * �T�[�r�X�p�^�[���Z��������������Ԓ�`(QS001109_H2104) 
 */
public class QS001109_H2104State extends QS001109_H2104Design {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001109_H2104State(){
  }

  /**
   * �u�@�\�P���E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VALID_FUNCTION_TRAINING() throws Exception {

        getShortStayLifeAdditionFunctionTrainingRadio().setEnabled(true);

  }

  /**
   * �u�@�\�P���E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_FUNCTION_TRAINING() throws Exception {

        getShortStayLifeAdditionFunctionTrainingRadio().setEnabled(false);

  }

  /**
   * �u�×{�H���Z�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VALID_MEDICAL_EXPENSES() throws Exception {

        getShortStayLifeMedicalExpensesRadio().setEnabled(true);

  }

  /**
   * �u�×{�H���Z�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_MEDICAL_EXPENSES() throws Exception {

        getShortStayLifeMedicalExpensesRadio().setEnabled(false);

  }

  /**
   * �u�]���^�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_CONVENTIONAL_FORM() throws Exception {

        getShortStayLifeHospitalRoomDivisionRadio().setEnabled(true);

        getShortStayLifeUnitHospitalRoomDivisionRadio().setEnabled(false);

        getShortStayLifeUnitCareAddRadio().setEnabled(false);

  }

  /**
   * �u���j�b�g�^�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_UNIT_FORM() throws Exception {

        getShortStayLifeHospitalRoomDivisionRadio().setEnabled(false);

        getShortStayLifeUnitHospitalRoomDivisionRadio().setEnabled(true);

        getShortStayLifeUnitCareAddRadio().setEnabled(true);

  }

  /**
   * �u�H���񋟁E����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_USE_MEAT() throws Exception {

        getShortStayLifeDinnerCost().setEnabled(true);

  }

  /**
   * �u�H���񋟁E�Ȃ��v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_NOT_USE_MEAT() throws Exception {

        getShortStayLifeDinnerCost().setEnabled(false);

  }

  /**
   * �u�ً}�Z�������l�b�g���[�N���Z�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VALID_SHORT_NETWORK() throws Exception {

        getShortStayLifeEmergencyShortNetworkAddRadio().setEnabled(true);

  }

  /**
   * �u�ً}�Z�������l�b�g���[�N���Z�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_SHORT_NETWORK() throws Exception {

        getShortStayLifeEmergencyShortNetworkAddRadio().setEnabled(false);

  }

  /**
   * �u���j�b�g�P�A�̐����E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VALID_UNIT_CARE() throws Exception {

        getShortStayLifeUnitCareAddRadio().setEnabled(true);

  }

  /**
   * �u���j�b�g�P�A�̐����E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_UNIT_CARE() throws Exception {

        getShortStayLifeUnitCareAddRadio().setEnabled(false);

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
