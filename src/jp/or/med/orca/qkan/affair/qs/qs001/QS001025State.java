
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
 * �쐬��: 2006/02/26  ���{�R���s���[�^�[������� �� ���� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �\��Ǘ� (S)
 * �v���Z�X �T�[�r�X�p�^�[�����×{�^��Î{�݁i�F�m�ǁj (001)
 * �v���O���� �T�[�r�X�p�^�[�����×{�^��Î{�݁i�F�m�ǁj (QS001025)
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
 * �T�[�r�X�p�^�[�����×{�^��Î{�݁i�F�m�ǁj��Ԓ�`(QS001025) 
 */
public class QS001025State extends QS001025Design {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001025State(){
  }

  /**
   * �u�h�{�Ǘ��E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VALID_DIETICIAN_MANAGE() throws Exception {

        getMedicalFacilityCognitiveHospitalNutritionManageRadio().setEnabled(true);

  }

  /**
   * �u�h�{�Ǘ��E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_DIETICIAN_MANAGE() throws Exception {

        getMedicalFacilityCognitiveHospitalNutritionManageRadio().setEnabled(false);

  }

  /**
   * �u�h�{�}�l�W�����g�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VALID_MANAGE() throws Exception {

        getMedicalFacilityCognitiveHospitalNutritionRadio().setEnabled(true);

  }

  /**
   * �u�h�{�}�l�W�����g�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_MANAGE() throws Exception {

        getMedicalFacilityCognitiveHospitalNutritionRadio().setEnabled(false);

  }

  /**
   * �u�o���ڍs�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VALID_NUTRITION() throws Exception {

        getMedicalFacilityCognitiveHospitalOralSwitchRadio().setEnabled(true);

  }

  /**
   * �u�o���ڍs�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_NUTRITION() throws Exception {

        getMedicalFacilityCognitiveHospitalOralSwitchRadio().setEnabled(false);

  }

  /**
   * �u�×{�H�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VALID_MEDICAL_EXPENSES() throws Exception {

        getMedicalFacilityCognitiveHospitalRecuperateDinnerRadio().setEnabled(true);

  }

  /**
   * �u�×{�H�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_MEDICAL_EXPENSES() throws Exception {

        getMedicalFacilityCognitiveHospitalRecuperateDinnerRadio().setEnabled(false);

  }

  /**
   * �u�]���^�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_CONVENTIONAL_FORM() throws Exception {

        getMedicalFacilityCognitiveHospitalHospitalRoomRadio().setEnabled(true);

        getMedicalFacilityCognitiveHospitalUnitHospitalRoomRadio().setEnabled(false);

  }

  /**
   * �u���j�b�g�^�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_UNIT_FORM() throws Exception {

        getMedicalFacilityCognitiveHospitalHospitalRoomRadio().setEnabled(false);

        getMedicalFacilityCognitiveHospitalUnitHospitalRoomRadio().setEnabled(true);

  }

  /**
   * �u�H���񋟁E����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_USE_MEAT() throws Exception {

        getMedicalFacilityCognitiveHospitalDinnerCost().setEnabled(true);

  }

  /**
   * �u�H���񋟁E�Ȃ��v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_NOT_USE_MEAT() throws Exception {

        getMedicalFacilityCognitiveHospitalDinnerCost().setEnabled(false);

  }

}
