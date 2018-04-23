
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
 * �쐬��: 2018/02/23  ���{�R���s���[�^�[������� ����@��F �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �\��Ǘ� (S)
 * �v���Z�X �T�[�r�X�\�� (001)
 * �v���O���� �T�[�r�X�p�^�[���K��Ō�(���) (QS001_11311_201804)
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
 * �T�[�r�X�p�^�[���K��Ō�(���)��Ԓ�`(QS001_11311_201804) 
 */
public class QS001_11311_201804State extends QS001_11311_201804Design {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001_11311_201804State(){
  }

  /**
   * �u�{�݋敪�E�X�e�[�V�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_TYPE_STATION() throws Exception {

        getHoumonKangoKaigoClass().setEnabled(true);
        getHoumonKangoKaigoClass().getParent().setEnabled(true);

        getHoumonKangoKaigoClass3().setEnabled(true);

        getHoumonKangoKaigoLongTime().setEnabled(true);
        getHoumonKangoKaigoLongTime().getParent().setEnabled(true);

        getHoumonKangoNumberOfPeopleTime().setEnabled(true);
        getHoumonKangoNumberOfPeopleTime().getParent().setEnabled(true);

        getHoumonKangoKaigoTimeZone().setEnabled(true);
        getHoumonKangoKaigoTimeZone().getParent().setEnabled(true);

        getHoumonKangoNumberOfPeople().setEnabled(true);
        getHoumonKangoNumberOfPeople().getParent().setEnabled(true);

        getHoumonKangoKaigoTime().setEnabled(true);
        getHoumonKangoKaigoTime().getParent().setEnabled(true);

        getHoumonNissuReduceRadio().setEnabled(false);
        getHoumonNissuReduceRadio().getParent().setEnabled(false);

        getHoumonKangoKaigoUrgentTimeRadio().getParent().setVisible(true);

        getHoumonKangoKaigoUrgentTime2Radio().getParent().setVisible(false);

        getCrackOnDayCheck().setEnabled(false);

        getPrintable().setEnabled(false);

        getHoumonNeededRadio().setEnabled(true);
        getHoumonNeededRadio().getParent().setEnabled(true);

        getCareSupportSystem().setEnabled(true);
        getCareSupportSystem().getParent().setEnabled(true);

  }

  /**
   * �u�{�݋敪�E��Ë@�ցv�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_TYPE_HOSPITAL() throws Exception {

        getHoumonKangoKaigoClass().setEnabled(true);
        getHoumonKangoKaigoClass().getParent().setEnabled(true);

        getHoumonKangoKaigoClass3().setEnabled(false);

        getHoumonKangoKaigoLongTime().setEnabled(true);
        getHoumonKangoKaigoLongTime().getParent().setEnabled(true);

        getHoumonKangoNumberOfPeopleTime().setEnabled(true);
        getHoumonKangoNumberOfPeopleTime().getParent().setEnabled(true);

        getHoumonKangoKaigoTimeZone().setEnabled(true);
        getHoumonKangoKaigoTimeZone().getParent().setEnabled(true);

        getHoumonKangoNumberOfPeople().setEnabled(true);
        getHoumonKangoNumberOfPeople().getParent().setEnabled(true);

        getHoumonKangoKaigoTime().setEnabled(true);
        getHoumonKangoKaigoTime().getParent().setEnabled(true);

        getHoumonNissuReduceRadio().setEnabled(false);
        getHoumonNissuReduceRadio().getParent().setEnabled(false);

        getHoumonKangoKaigoUrgentTimeRadio().getParent().setVisible(true);

        getHoumonKangoKaigoUrgentTime2Radio().getParent().setVisible(false);

        getCrackOnDayCheck().setEnabled(false);

        getPrintable().setEnabled(false);

        getHoumonNeededRadio().setEnabled(true);
        getHoumonNeededRadio().getParent().setEnabled(true);

        getCareSupportSystem().setEnabled(true);
        getCareSupportSystem().getParent().setEnabled(true);

  }

  /**
   * �u�{�݋敪�E�������v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_TYPE_TEIKIJUNKAI() throws Exception {

        getHoumonKangoKaigoClass().setEnabled(true);
        getHoumonKangoKaigoClass().getParent().setEnabled(true);

        getHoumonKangoKaigoClass3().setEnabled(false);

        getHoumonKangoKaigoLongTime().setEnabled(false);
        getHoumonKangoKaigoLongTime().getParent().setEnabled(false);

        getHoumonKangoNumberOfPeopleTime().setEnabled(false);
        getHoumonKangoNumberOfPeopleTime().getParent().setEnabled(false);

        getHoumonKangoKaigoTimeZone().setEnabled(false);
        getHoumonKangoKaigoTimeZone().getParent().setEnabled(false);

        getHoumonKangoNumberOfPeople().setEnabled(false);
        getHoumonKangoNumberOfPeople().getParent().setEnabled(false);

        getHoumonKangoKaigoTime().setEnabled(false);
        getHoumonKangoKaigoTime().getParent().setEnabled(false);

        getHoumonNissuReduceRadio().setEnabled(true);
        getHoumonNissuReduceRadio().getParent().setEnabled(true);

        getHoumonKangoKaigoUrgentTimeRadio().getParent().setVisible(false);

        getHoumonKangoKaigoUrgentTime2Radio().getParent().setVisible(true);

        getCrackOnDayCheck().setEnabled(true);

        getHoumonNeededRadio().setEnabled(false);
        getHoumonNeededRadio().getParent().setEnabled(false);

        getCareSupportSystem().setEnabled(false);
        getCareSupportSystem().getParent().setEnabled(false);

  }

  /**
   * �u���w�Ö@�m�̏ꍇ�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_WORKER_IS_PTOT() throws Exception {

        getHoumonKangoKaigoTime().setEnabled(false);
        getHoumonKangoKaigoTime().getParent().setEnabled(false);

        getTwoOrMoreTimesCheck().setEnabled(true);

  }

  /**
   * �u���w�Ö@�m�ȊO�̏ꍇ�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_WORKER_IS_NOT_PTOT() throws Exception {

        getHoumonKangoKaigoTime().setEnabled(true);
        getHoumonKangoKaigoTime().getParent().setEnabled(true);

        getTwoOrMoreTimesCheck().setEnabled(false);

  }

  /**
   * �u�����ԖK��Ō���Z�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VALID_LONG_TIME() throws Exception {

        getHoumonKangoKaigoLongTime().setEnabled(true);
        getHoumonKangoKaigoLongTime().getParent().setEnabled(true);

  }

  /**
   * �u�����ԖK��Ō���Z�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_LONG_TIME() throws Exception {

        getHoumonKangoKaigoLongTime().setEnabled(false);
        getHoumonKangoKaigoLongTime().getParent().setEnabled(false);

  }

  /**
   * �u2�l�ڂ̖K�⎞�ԁE�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VALID_NUMBER_OF_PEOPLE_TIME() throws Exception {

        getHoumonKangoNumberOfPeopleTime().setEnabled(true);
        getHoumonKangoNumberOfPeopleTime().getParent().setEnabled(true);

  }

  /**
   * �u2�l�ڂ̖K�⎞�ԁE�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_NUMBER_OF_PEOPLE_TIME() throws Exception {

        getHoumonKangoNumberOfPeopleTime().setEnabled(false);
        getHoumonKangoNumberOfPeopleTime().getParent().setEnabled(false);

  }

  /**
   * �u�����`�F�b�N�L��v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_DAY_CHECK_ON() throws Exception {

        getPrintable().setEnabled(true);

  }

  /**
   * �u�����`�F�b�N�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_DAY_CHECK_OFF() throws Exception {

        getPrintable().setEnabled(false);

  }

}
