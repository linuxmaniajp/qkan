
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
 * �쐬��: 2006/03/29  ���{�R���s���[�^�[������� �� ���� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �\��Ǘ� (S)
 * �v���Z�X �T�[�r�X�\�� (001)
 * �v���O���� �T�[�r�X�\�� (QS001)
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
 * �T�[�r�X�\���Ԓ�`(QS001) 
 */
public class QS001State extends QS001Design {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001State(){
  }

  /**
   * �u�X�V���[�h�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_PROCESS_MODE_INSERT() throws Exception {

        getInsert().setVisible(true);

        getUpdate().setVisible(false);

  }

  /**
   * �u�o�^���[�h�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_PROCESS_MODE_UPDATE() throws Exception {

        getInsert().setVisible(false);

        getUpdate().setVisible(true);

  }

  /**
   * �u�T�ԃT�[�r�X�v��[����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_PRINT_WEEKLY() throws Exception {

        getPrintWeekly().setVisible(true);

        getPrintMonthly().setVisible(false);

        getOpenPlan().setEnabled(true);

  }

  /**
   * �u���p�[�E�񋟕[����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_PRINT_MONTHLY() throws Exception {

        getPrintWeekly().setVisible(false);

        getPrintMonthly().setVisible(true);

        getOpenPlan().setEnabled(false);

  }

  /**
   * �u�T�[�r�X�p�^�[���I���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_SERVICE_PATTERN_SELECTED() throws Exception {

        getPatternDelete().setEnabled(true);

        getServiceDelete().setEnabled(false);

  }

  /**
   * �u�T�[�r�X�p�^�[�����I���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_SERVICE_PATTERN_UNSELECTED() throws Exception {

        getPatternDelete().setEnabled(false);

  }

  /**
   * �u�\�胂�[�h�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_AFFIR_MODE_PLAN() throws Exception {

        getClearPlan().setVisible(true);

        getOpenPlan().setVisible(true);

        getClearResult().setVisible(false);

        getOpenResult().setVisible(false);

  }

  /**
   * �u���у��[�h�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_AFFIR_MODE_RESULT() throws Exception {

        getPrintWeekly().setVisible(false);

        getClearPlan().setVisible(false);

        getOpenPlan().setVisible(false);

        getClearResult().setVisible(true);

        getOpenResult().setVisible(true);

  }

  /**
   * �u���Ə����g�p�T�[�r�X�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_USE_PROVIDER_SERVICE() throws Exception {

        getServiceOfferEntrepreneur().setEnabled(true);

  }

  /**
   * �u���Ə���񖢎g�p�T�[�r�X�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_NOT_USE_PROVIDER_SERVICE() throws Exception {

        getServiceOfferEntrepreneur().setEnabled(false);

  }

  /**
   * �u�T�[�r�X�I�𒆁v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_SERVICE_SELECTED() throws Exception {

        getServiceSet().setEnabled(true);

        getServiceDelete().setEnabled(true);

  }

  /**
   * �u�T�[�r�X���I�𒆁v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_SERVICE_UNSELECTED() throws Exception {

        getServiceSet().setEnabled(false);

        getServiceDelete().setEnabled(false);

  }

  /**
   * �u�����Ə�������x�����񋟁v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_NOT_PROVIDE_CARE_MANAGEMENT() throws Exception {

        getOpenResult().setVisible(false);

  }

  /**
   * �u�����Ə�������x���񋟁v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_PROVIDE_CARE_MANAGEMENT() throws Exception {

        getOpenResult().setVisible(true);

  }

}
