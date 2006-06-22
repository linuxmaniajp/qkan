
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
 * �쐬��: 2006/06/02  ���{�R���s���[�^�[������� �� ���� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �\��Ǘ� (S)
 * �v���Z�X �T�[�r�X�p�^�[������{�ݓ����Ґ������ (001)
 * �v���O���� �T�[�r�X�p�^�[������{�ݓ����Ґ������ (QS001115)
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
 * �T�[�r�X�p�^�[������{�ݓ����Ґ�������Ԓ�`(QS001115) 
 */
public class QS001115State extends QS001115Design {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001115State(){
  }

  /**
   * �u����{�ݓ����ґI�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_SELECT_SPECIAL() throws Exception {

        getSpecificFacilityFunctionTrainingRadio().setEnabled(true);

        getNightNursingSystemRadio().setEnabled(true);

        getVisitCareGroup().setEnabled(false);

        getVisitNursingRadioGroup().setEnabled(false);

        getVisitRehabiliGroup().setEnabled(false);

        getExpertPlaceNursingGroup().setEnabled(false);

        getExpertPlaceRehabiliGroup().setEnabled(false);

        getWelfareToolsGroup().setEnabled(false);

        getSpecificFacilityBeginTime().setEnabled(false);

        getSpecificFacilityEndTime().setEnabled(false);

        getOutsideServiceRadio().setEnabled(false);

        getNinchishoTaioTsushoGroup().setEnabled(false);

  }

  /**
   * �u�O���T�[�r�X���p�^�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_SELECT_OUT() throws Exception {

        getSpecificFacilityFunctionTrainingRadio().setEnabled(false);

        getNightNursingSystemRadio().setEnabled(false);

        getVisitCareGroup().setEnabled(true);

        getVisitNursingRadioGroup().setEnabled(true);

        getVisitRehabiliGroup().setEnabled(true);

        getExpertPlaceNursingGroup().setEnabled(true);

        getExpertPlaceRehabiliGroup().setEnabled(true);

        getWelfareToolsGroup().setEnabled(true);

        getSpecificFacilityBeginTime().setEnabled(true);

        getSpecificFacilityEndTime().setEnabled(true);

        getOutsideServiceRadio().setEnabled(true);

        getNinchishoTaioTsushoGroup().setEnabled(true);

  }

  /**
   * �u�K����I�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_SELECT_VISIT() throws Exception {

        getVisitCareGroup().setEnabled(true);

        getVisitNursingRadioGroup().setEnabled(false);

        getVisitRehabiliGroup().setEnabled(false);

        getExpertPlaceNursingGroup().setEnabled(false);

        getExpertPlaceRehabiliGroup().setEnabled(false);

        getWelfareToolsGroup().setEnabled(false);

        getNinchishoTaioTsushoGroup().setEnabled(false);

  }

  /**
   * �u�K��Ō�I�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_SELECT_VISIT_NURSING() throws Exception {

        getVisitCareGroup().setEnabled(false);

        getVisitNursingRadioGroup().setEnabled(true);

        getVisitRehabiliGroup().setEnabled(false);

        getExpertPlaceNursingGroup().setEnabled(false);

        getExpertPlaceRehabiliGroup().setEnabled(false);

        getWelfareToolsGroup().setEnabled(false);

        getNinchishoTaioTsushoGroup().setEnabled(false);

  }

  /**
   * �u�K�⃊�n�I�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_SELECT_VISIT_REHABILI() throws Exception {

        getVisitCareGroup().setEnabled(false);

        getVisitNursingRadioGroup().setEnabled(false);

        getVisitRehabiliGroup().setEnabled(true);

        getExpertPlaceNursingGroup().setEnabled(false);

        getExpertPlaceRehabiliGroup().setEnabled(false);

        getWelfareToolsGroup().setEnabled(false);

        getNinchishoTaioTsushoGroup().setEnabled(false);

  }

  /**
   * �u�ʏ����I�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_SELECT_EXPERTPLACE_NURSING() throws Exception {

        getVisitCareGroup().setEnabled(false);

        getVisitNursingRadioGroup().setEnabled(false);

        getVisitRehabiliGroup().setEnabled(false);

        getExpertPlaceNursingGroup().setEnabled(true);

        getExpertPlaceRehabiliGroup().setEnabled(false);

        getWelfareToolsGroup().setEnabled(false);

        getNinchishoTaioTsushoGroup().setEnabled(false);

  }

  /**
   * �u�ʏ����n�I�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_SELECT_EXPERTPLACE_REHABILI() throws Exception {

        getVisitCareGroup().setEnabled(false);

        getVisitNursingRadioGroup().setEnabled(false);

        getVisitRehabiliGroup().setEnabled(false);

        getExpertPlaceNursingGroup().setEnabled(false);

        getExpertPlaceRehabiliGroup().setEnabled(true);

        getWelfareToolsGroup().setEnabled(false);

        getNinchishoTaioTsushoGroup().setEnabled(false);

  }

  /**
   * �u�����p��ݗ^�I�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_SELECT_WELFARE_TOOLS() throws Exception {

        getVisitCareGroup().setEnabled(false);

        getVisitNursingRadioGroup().setEnabled(false);

        getVisitRehabiliGroup().setEnabled(false);

        getExpertPlaceNursingGroup().setEnabled(false);

        getExpertPlaceRehabiliGroup().setEnabled(false);

        getWelfareToolsGroup().setEnabled(true);

        getNinchishoTaioTsushoGroup().setEnabled(false);

  }

  /**
   * �u�K��������I���㎞�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_SELECT_VISIT_BATH() throws Exception {

        getVisitCareGroup().setEnabled(false);

        getVisitNursingRadioGroup().setEnabled(false);

        getVisitRehabiliGroup().setEnabled(false);

        getExpertPlaceNursingGroup().setEnabled(false);

        getExpertPlaceRehabiliGroup().setEnabled(false);

        getWelfareToolsGroup().setEnabled(false);

        getNinchishoTaioTsushoGroup().setEnabled(false);

  }

  /**
   * �u�ʋ@�\�P���w�����Z�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VALID_TRAINING() throws Exception {

        getSpecificFacilityFunctionTrainingRadio().setEnabled(true);

  }

  /**
   * �u�ʋ@�\�P���w�����Z�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_TRAINING() throws Exception {

        getSpecificFacilityFunctionTrainingRadio().setEnabled(false);

  }

  /**
   * �u��ԊŌ�̐����Z�E���L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VALID_NIGHT_NURSING() throws Exception {

        getNightNursingSystemRadio().setEnabled(true);

  }

  /**
   * �u��ԊŌ�̐��E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_NIGHT_NURSING() throws Exception {

        getNightNursingSystemRadio().setEnabled(false);

  }

  /**
   * �uPT�EOT�EST�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VALID_STAFF_DIVISION_() throws Exception {

        getVisitNursingStaffDivisionRadioItem2().setEnabled(true);

  }

  /**
   * �uPT�EOT�EST�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_STAFF_DIVISION_() throws Exception {

        getVisitNursingStaffDivisionRadioItem2().setEnabled(false);

  }

  /**
   * �u�F�m�ǑΉ��ʏ����E�{�݋敪�Q�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VALID_NINTI_DIVISION() throws Exception {

        getDivisionRadion().setEnabled(true);

  }

  /**
   * �u�F�m�ǑΉ��ʏ����E�{�݋敪�Q�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_NINTI_DIVISION() throws Exception {

        getDivisionRadion().setEnabled(false);

  }

  /**
   * �u�F�m�ǑΉ��ʏ����I�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_SELECT_NINTITUUSHO() throws Exception {

        getVisitCareGroup().setEnabled(false);

        getVisitNursingRadioGroup().setEnabled(false);

        getVisitRehabiliGroup().setEnabled(false);

        getExpertPlaceNursingGroup().setEnabled(false);

        getExpertPlaceRehabiliGroup().setEnabled(false);

        getWelfareToolsGroup().setEnabled(false);

        getNinchishoTaioTsushoGroup().setEnabled(true);

  }

  /**
   * �u��{�P�ʂ̂ݑI�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_SELECT_ONLY_BASE() throws Exception {

        getVisitCareGroup().setEnabled(false);

        getVisitNursingRadioGroup().setEnabled(false);

        getVisitRehabiliGroup().setEnabled(false);

        getExpertPlaceNursingGroup().setEnabled(false);

        getExpertPlaceRehabiliGroup().setEnabled(false);

        getWelfareToolsGroup().setEnabled(false);

        getNinchishoTaioTsushoGroup().setEnabled(false);

  }

}
