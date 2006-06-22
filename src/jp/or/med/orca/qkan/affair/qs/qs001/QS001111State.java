
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
 * �쐬��: 2006/04/11  ���{�R���s���[�^�[������� �� ���� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �\��Ǘ� (S)
 * �v���Z�X �T�[�r�X�p�^�[���Z�������×{���i�a�@�×{�j (001)
 * �v���O���� �T�[�r�X�p�^�[���Z�������×{���i�a�@�×{�j (QS001111)
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
 * �T�[�r�X�p�^�[���Z�������×{���i�a�@�×{�j��Ԓ�`(QS001111) 
 */
public class QS001111State extends QS001111Design {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001111State(){
  }

  /**
   * �u�H���񋟁E����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_USE_MEAT() throws Exception {

        getShortStayRecuperationHealthFacilityDinnerCost().setEnabled(true);

  }

  /**
   * �u�H���񋟁E�Ȃ��v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_NOT_USE_MEAT() throws Exception {

        getShortStayRecuperationHealthFacilityDinnerCost().setEnabled(false);

  }

  /**
   * �u�h�{�Ǘ��̐����Z�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VALID_DIETICIAN_MANAGE() throws Exception {

        getShortStayHospitalRecuperationDieticianManageRadio().setEnabled(true);

  }

  /**
   * �u�h�{�Ǘ��̐����Z�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_DIETICIAN_MANAGE() throws Exception {

        getShortStayHospitalRecuperationDieticianManageRadio().setEnabled(false);

  }

  /**
   * �u�×{�H���Z�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VALID_MEDICAL_EXPENSES() throws Exception {

        getShortStayHospitalRecuperationMedicalExpensesRadio().setEnabled(true);

  }

  /**
   * �u�×{�H���Z�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_MEDICAL_EXPENSES() throws Exception {

        getShortStayHospitalRecuperationMedicalExpensesRadio().setEnabled(false);

  }

  /**
   * �u�]���^�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_CONVENTIONAL_FORM() throws Exception {

        getShortStayHospitalRecuperationHospitalRoomRadio().setEnabled(true);

        getShortStayHospitalRecuperationUnitHospitalRoomRadio().setEnabled(false);

        getShortStayHospitalRecuperationUnitCareMaintenanceRadio().setEnabled(false);

        getShortStayHospitalRecuperationDivision().setEnabled(true);

  }

  /**
   * �u���j�b�g�^�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_UNIT_FORM() throws Exception {

        getShortStayHospitalRecuperationHospitalRoomRadio().setEnabled(false);

        getShortStayHospitalRecuperationUnitHospitalRoomRadio().setEnabled(true);

        getShortStayHospitalRecuperationUnitCareMaintenanceRadio().setEnabled(true);

        getShortStayHospitalRecuperationDivision().setEnabled(false);

  }

  /**
   * �u���A��V���[�g�X�e�C�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_SELECT_SHORT_STAY_STATE() throws Exception {

        getShortStayHospitalRecuperationHospitalRoomRadio().setEnabled(false);

        getShortStayHospitalRecuperationUnitHospitalRoomRadio().setEnabled(false);

        getShortStayHospitalRecuperationUnitCareMaintenanceRadio().setEnabled(false);

        getShortStayHospitalRecuperationDivision().setEnabled(false);

  }

  /**
   * �u�l���z�u�T�E�U�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_PERSON_SUBTRACTION() throws Exception {

        getShortStayHospitalRecuperationType1().setEnabled(false);

        getShortStayHospitalRecuperationType2().setEnabled(false);

  }

  /**
   * �u�l���z�u�T�E�U�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VALID_PERSON_SUBTRACTION() throws Exception {

        getShortStayHospitalRecuperationType1().setEnabled(true);

        getShortStayHospitalRecuperationType2().setEnabled(true);

  }

  /**
   * �u�ً}�Z�������l�b�g���[�N�̐��E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VALID_SHORT_NETWORK() throws Exception {

        getShortStayHospitalRecuperationEmergencyNetworkAddRadio().setEnabled(true);

  }

  /**
   * �u�ً}�Z�������l�b�g���[�N�̐��E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_SHORT_NETWORK() throws Exception {

        getShortStayHospitalRecuperationEmergencyNetworkAddRadio().setEnabled(false);

  }

  /**
   * �u���j�b�g�P�A�̐��E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VALID_UNIT_CARE() throws Exception {

        getShortStayHospitalRecuperationUnitCareMaintenanceRadio().setEnabled(true);

  }

  /**
   * �u���j�b�g�P�A�̐��E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_UNIT_CARE() throws Exception {

        getShortStayHospitalRecuperationUnitCareMaintenanceRadio().setEnabled(false);

  }

  /**
   * �u���A��V���[�g�X�e�C�E�I�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_SHORT_STAY_SELECT() throws Exception {

        getShortStayHospitalRecuperationSickroomDivisionRadio().getParent().setVisible(true);

        getShortStayHospitalRecuperationHospitalRoomContena().setVisible(false);

  }

  /**
   * �u���A��V���[�g�X�e�C�E��I�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_SHORT_STAY_UNSELECT() throws Exception {

        getShortStayHospitalRecuperationSickroomDivisionRadio().getParent().setVisible(false);

        getShortStayHospitalRecuperationHospitalRoomContena().setVisible(true);

  }

}
