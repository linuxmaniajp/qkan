
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
 * �J����: �����@���̂�
 * �쐬��: 2018/03/03  ���{�R���s���[�^�[������� �����@���̂� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �\��Ǘ� (S)
 * �v���Z�X �T�[�r�X�\�� (001)
 * �v���O���� �T�[�r�X�p�^�[���n�斧���^�ʏ���� (QS001_17811_201804)
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
 * �T�[�r�X�p�^�[���n�斧���^�ʏ�����Ԓ�`(QS001_17811_201804) 
 */
public class QS001_17811_201804State extends QS001_17811_201804Design {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001_17811_201804State(){
  }

  /**
   * �u�ʋ@�\�P���E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VALID_FUNCTION_TRAINING() throws Exception {

        getTsuusyoKaigoAdditionFunctionTrainingRadio().setEnabled(true);

  }

  /**
   * �u�ʋ@�\�P���E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_FUNCTION_TRAINING() throws Exception {

        getTsuusyoKaigoAdditionFunctionTrainingRadio().setEnabled(false);

  }

  /**
   * �u�������Z�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VALID_ADD_BATH() throws Exception {

        getTsuusyoKaigoAdditionFunctionBathRadio().setEnabled(true);
        getTsuusyoKaigoAdditionFunctionBathRadio().getParent().setEnabled(true);

  }

  /**
   * �u�������Z�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_ADD_BATH() throws Exception {

        getTsuusyoKaigoAdditionFunctionBathRadio().setEnabled(false);
        getTsuusyoKaigoAdditionFunctionBathRadio().getParent().setEnabled(false);

  }

  /**
   * �u�h�{�}�l�W�����g�̐��E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VALID_NOURISHMENT_MANAGEMENT() throws Exception {

        getTsuusyoKaigoNourishmentManagementAddRadio().setEnabled(true);
        getTsuusyoKaigoNourishmentManagementAddRadio().getParent().setEnabled(true);

  }

  /**
   * �u�h�{�}�l�W�����g�̐��E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_NOURISHMENT_MANAGEMENT() throws Exception {

        getTsuusyoKaigoNourishmentManagementAddRadio().setEnabled(false);
        getTsuusyoKaigoNourishmentManagementAddRadio().getParent().setEnabled(false);

  }

  /**
   * �u���o�@�\������Z�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VALID_MOUTH_FUNCTION() throws Exception {

        getTsuusyoKaigoMouthFunctionAddRadio().setEnabled(true);
        getTsuusyoKaigoMouthFunctionAddRadio().getParent().setEnabled(true);

  }

  /**
   * �u���o�@�\������Z�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_MOUTH_FUNCTION() throws Exception {

        getTsuusyoKaigoMouthFunctionAddRadio().setEnabled(false);
        getTsuusyoKaigoMouthFunctionAddRadio().getParent().setEnabled(false);

  }

  /**
   * �u�×{�ʏ��I�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_STATE_RYOYO() throws Exception {

        getTsuusyoKaigoAdditionFunctionTrainingRadio().setEnabled(false);

        getTsuusyoKaigoAdditionFunctionBathRadio().setEnabled(false);
        getTsuusyoKaigoAdditionFunctionBathRadio().getParent().setEnabled(false);

        getTsuusyoKaigoNourishmentManagementAddRadio().setEnabled(false);
        getTsuusyoKaigoNourishmentManagementAddRadio().getParent().setEnabled(false);

        getTsuusyoKaigoMouthFunctionAddRadio().setEnabled(false);
        getTsuusyoKaigoMouthFunctionAddRadio().getParent().setEnabled(false);

        getYoungDementiaPatinetAddRadioGroup().setEnabled(false);
        getYoungDementiaPatinetAddRadioGroup().getParent().setEnabled(false);

        getDementiaElderlyAccepted().setEnabled(false);
        getDementiaElderlyAccepted().getParent().setEnabled(false);

        getSevereCareRecipientsAccepted().setEnabled(false);
        getSevereCareRecipientsAccepted().getParent().setEnabled(false);

        getIndividualPickupSystem().setEnabled(true);
        getIndividualPickupSystem().getParent().setEnabled(true);

        getBathingAssistanceSystem().setEnabled(true);
        getBathingAssistanceSystem().getParent().setEnabled(true);

  }

  /**
   * �u�n�斧���^�ʏ��I�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_STATE_SMALL() throws Exception {

        getTsuusyoKaigoAdditionFunctionTrainingRadio().setEnabled(true);

        getTsuusyoKaigoAdditionFunctionBathRadio().setEnabled(true);
        getTsuusyoKaigoAdditionFunctionBathRadio().getParent().setEnabled(true);

        getTsuusyoKaigoNourishmentManagementAddRadio().setEnabled(true);
        getTsuusyoKaigoNourishmentManagementAddRadio().getParent().setEnabled(true);

        getTsuusyoKaigoMouthFunctionAddRadio().setEnabled(true);
        getTsuusyoKaigoMouthFunctionAddRadio().getParent().setEnabled(true);

        getYoungDementiaPatinetAddRadioGroup().setEnabled(true);
        getYoungDementiaPatinetAddRadioGroup().getParent().setEnabled(true);

        getDementiaElderlyAccepted().setEnabled(true);
        getDementiaElderlyAccepted().getParent().setEnabled(true);

        getSevereCareRecipientsAccepted().setEnabled(true);
        getSevereCareRecipientsAccepted().getParent().setEnabled(true);

        getIndividualPickupSystem().setEnabled(false);
        getIndividualPickupSystem().getParent().setEnabled(false);

        getBathingAssistanceSystem().setEnabled(false);
        getBathingAssistanceSystem().getParent().setEnabled(false);

  }

  /**
   * �u��N���F�m�Ǘ��p�Ҏ�����Z�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VALID_YOUNG_DEMENTIA_PATINET() throws Exception {

        getYoungDementiaPatinetAddRadioGroup().setEnabled(true);
        getYoungDementiaPatinetAddRadioGroup().getParent().setEnabled(true);

  }

  /**
   * �u��N���F�m�Ǘ��p�Ҏ�����Z�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_YOUNG_DEMENTIA_PATINET() throws Exception {

        getYoungDementiaPatinetAddRadioGroup().setEnabled(false);
        getYoungDementiaPatinetAddRadioGroup().getParent().setEnabled(false);

  }

  /**
   * �u�ʋ@�\�P��II�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VALID_FUNCTION_TRAINING2() throws Exception {

        getTsuusyoKaigoAdditionFunctionTrainingRadio().setEnabled(true);

        getTsuusyoKaigoAdditionFunctionTrainingRadioItem1().setEnabled(false);

        getTsuusyoKaigoAdditionFunctionTrainingRadioItem2().setEnabled(true);

  }

  /**
   * �u�ʋ@�\�P��II�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_FUNCTION_TRAINING2() throws Exception {

        getTsuusyoKaigoAdditionFunctionTrainingRadio().setEnabled(false);

        getTsuusyoKaigoAdditionFunctionTrainingRadioItem1().setEnabled(false);

        getTsuusyoKaigoAdditionFunctionTrainingRadioItem2().setEnabled(false);

  }

  /**
   * �u�ʋ@�\�P��I�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VALID_FUNCTION_TRAINING1() throws Exception {

        getTsuusyoKaigoAdditionFunctionTrainingRadio().setEnabled(true);

        getTsuusyoKaigoAdditionFunctionTrainingRadioItem1().setEnabled(true);

        getTsuusyoKaigoAdditionFunctionTrainingRadioItem2().setEnabled(false);

  }

  /**
   * �u�ʋ@�\�P��I�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_FUNCTION_TRAINING1() throws Exception {

        getTsuusyoKaigoAdditionFunctionTrainingRadio().setEnabled(false);

        getTsuusyoKaigoAdditionFunctionTrainingRadioItem1().setEnabled(false);

        getTsuusyoKaigoAdditionFunctionTrainingRadioItem2().setEnabled(false);

  }

}
