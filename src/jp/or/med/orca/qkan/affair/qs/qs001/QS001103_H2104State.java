
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
 * �v���O���� �T�[�r�X�p�^�[���K��Ō�(���) (QS001103_H2104)
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
 * �T�[�r�X�p�^�[���K��Ō�(���)��Ԓ�`(QS001103_H2104) 
 */
public class QS001103_H2104State extends QS001103_H2104Design {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001103_H2104State(){
  }

  /**
   * �u���w�Ö@�m���͍�ƗÖ@�m�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VALID_HOMON_KANGO_PTOT() throws Exception {

        getHoumonKangoKaigoClass3().setEnabled(true);

  }

  /**
   * �u���w�Ö@�m���͍�ƗÖ@�m�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_HOMON_KANGO_PTOT() throws Exception {

        getHoumonKangoKaigoClass3().setEnabled(false);

  }

  /**
   * �u�ً}���K��Ō���Z�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VALID_URGENT_TIME_RADIO() throws Exception {

        getHoumonKangoKaigoUrgentTimeRadio().setEnabled(true);

  }

  /**
   * �u�ً}���K��Ō���Z�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_URGENT_TIME_RADIO() throws Exception {

        getHoumonKangoKaigoUrgentTimeRadio().setEnabled(false);

  }

  /**
   * �u���ʊǗ��̐��E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VALID_SPECIAL_MANAGE_RADIO() throws Exception {

        getHoumonKangoKaigoSpecialManageRadio().setEnabled(true);

  }

  /**
   * �u���ʊǗ��̐��E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_SPECIAL_MANAGE_RADIO() throws Exception {

        getHoumonKangoKaigoSpecialManageRadio().setEnabled(false);

  }

  /**
   * �u���ԋ敪�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_HOUMONKANGO_KAIGOTIME_ENABLE_FALSE() throws Exception {

        getHoumonKangoKaigoTime4().setEnabled(false);

        getHoumonKangoKaigoTime3().setEnabled(false);

  }

  /**
   * �u���ԋ敪�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_HOUMONKANGO_KAIGOTIME_ENABLE_TRUE() throws Exception {

        getHoumonKangoKaigoTime4().setEnabled(true);

        getHoumonKangoKaigoTime3().setEnabled(true);

  }

  /**
   * �u���ԑ�20�������E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_TIME_UNDER20_ENABLE_FALSE() throws Exception {

        getHoumonKangoKaigoTimeZoneNormal().setEnabled(false);

  }

  /**
   * �u���ԑ�20�������E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_TIME_UNDER20_ENABLE_TRUE() throws Exception {

        getHoumonKangoKaigoTimeZoneNormal().setEnabled(true);

  }

  /**
   * �u�����ԖK��Ō���Z�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VALID_LONG_TIME() throws Exception {

        getHoumonKangoKaigoLongTime().setEnabled(true);

  }

  /**
   * �u�����ԖK��Ō���Z�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_LONG_TIME() throws Exception {

        getHoumonKangoKaigoLongTime().setEnabled(false);

  }

}
