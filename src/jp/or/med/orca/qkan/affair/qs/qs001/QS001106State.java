
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
 * �쐬��: 2006/03/07  ���{�R���s���[�^�[������� �� ���� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �\��Ǘ� (S)
 * �v���Z�X �T�[�r�X�p�^�[������×{�Ǘ��w�� (001)
 * �v���O���� �T�[�r�X�p�^�[������×{�Ǘ��w�� (QS001106)
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
import jp.or.med.orca.qkan.lib.*;
/**
 * �T�[�r�X�p�^�[������×{�Ǘ��w����Ԓ�`(QS001106) 
 */
public class QS001106State extends QS001106Design {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001106State(){
  }

  /**
   * �u��t�I�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_DOCTOR() throws Exception {

        getRecuperationManagementGuidanceOccupationalCategoryZaiSouShinRadio().setEnabled(true);

        getRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadio().setEnabled(false);

        getRecuperationManagementGuidanceInfoAddRadio().setEnabled(true);

        getRecuperationManagementGuidanceTimesHospitalRadio().setEnabled(false);

        getRecuperationManagementGuidanceTimesDrugstoreRadio().setEnabled(false);

        getRecuperationManagementGuidanceTimesCancerEndCheck().setEnabled(false);

  }

  /**
   * �u��܎t�i��Ë@�ցj�I�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_CHEMIST_HOSPITAL() throws Exception {

        getRecuperationManagementGuidanceOccupationalCategoryZaiSouShinRadio().setEnabled(false);

        getRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadio().setEnabled(true);

        getRecuperationManagementGuidanceInfoAddRadio().setEnabled(false);

        getRecuperationManagementGuidanceTimesHospitalRadio().setEnabled(true);

        getRecuperationManagementGuidanceTimesDrugstoreRadio().setEnabled(false);

        getRecuperationManagementGuidanceTimesCancerEndCheck().setEnabled(true);

  }

  /**
   * �u��܎t�i��ǁj�I�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_CHEMIST_PHARMACY() throws Exception {

        getRecuperationManagementGuidanceOccupationalCategoryZaiSouShinRadio().setEnabled(false);

        getRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadio().setEnabled(true);

        getRecuperationManagementGuidanceInfoAddRadio().setEnabled(false);

        getRecuperationManagementGuidanceTimesHospitalRadio().setEnabled(false);

        getRecuperationManagementGuidanceTimesDrugstoreRadio().setEnabled(true);

        getRecuperationManagementGuidanceTimesCancerEndCheck().setEnabled(true);

  }

  /**
   * �u�h�{�m�E���ȉq���m���I�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_DIETICIAN() throws Exception {

        getRecuperationManagementGuidanceOccupationalCategoryZaiSouShinRadio().setEnabled(false);

        getRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadio().setEnabled(false);

        getRecuperationManagementGuidanceInfoAddRadio().setEnabled(false);

        getRecuperationManagementGuidanceTimesHospitalRadio().setEnabled(false);

        getRecuperationManagementGuidanceTimesDrugstoreRadio().setEnabled(false);

        getRecuperationManagementGuidanceTimesCancerEndCheck().setEnabled(false);

  }

  /**
   * �u���񋟁E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INFO_TRUE() throws Exception {

        getRecuperationManagementGuidanceInfoAddRadio().setEnabled(true);

  }

  /**
   * �u���񋟁E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INFO_FALSE() throws Exception {

        getRecuperationManagementGuidanceInfoAddRadio().setEnabled(false);

  }

}
