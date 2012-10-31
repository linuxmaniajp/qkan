
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
 * �J����: ��i�@�a�P
 * �쐬��: 2012/08/03  ���{�R���s���[�^�[������� ��i�@�a�P �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���p�ҊǗ� (U)
 * �v���Z�X ���p�ғo�^ (002)
 * �v���O���� ���p�ғo�^ (QU002)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qu.qu002;
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
 * ���p�ғo�^��Ԓ�`(QU002) 
 */
public class QU002State extends QU002Design {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QU002State(){
  }

  /**
   * �u�����ҏW�s�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_ENABLE_KAIGO_BUTTON_FALSE() throws Exception {

        getKaigoInfoButtonEdit().setEnabled(false);

        getKaigoInfoDelete().setEnabled(false);

  }

  /**
   * �u�����ҏW�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_ENABLE_KAIGO_BUTTON_TRUE() throws Exception {

        getKaigoInfoButtonEdit().setEnabled(true);

        getKaigoInfoDelete().setEnabled(true);

  }

  /**
   * �u�ٓ����ҏW�s�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_ENABLE_IDOU_BUTTON_FALSE() throws Exception {

        getIdouInfoButtonEdit().setEnabled(false);

        getIdouInfoButtonDelete().setEnabled(false);

  }

  /**
   * �u�ٓ����ҏW�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_ENABLE_IDOU_BUTTON_TRUE() throws Exception {

        getIdouInfoButtonEdit().setEnabled(true);

        getIdouInfoButtonDelete().setEnabled(true);

  }

  /**
   * �u�ٓ������L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_ENABLE_TIME_TRUE() throws Exception {

        getIdouInfoTime().setEnabled(true);
        getIdouInfoTime().getParent().setEnabled(true);

  }

  /**
   * �u�ٓ������L���s�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_ENABLE_TIME_FALSE() throws Exception {

        getIdouInfoTime().setEnabled(false);
        getIdouInfoTime().getParent().setEnabled(false);

  }

  /**
   * �u�x�����Ə��R���{�L���s�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_ENABLE_SHIEN_FALSE() throws Exception {

        getKaigoInfoKyotakuServicePlanCombo().setEnabled(false);

  }

  /**
   * �u�x�����Ə��R���{�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_ENABLE_SHIEN_TRUE() throws Exception {

        getKaigoInfoKyotakuServicePlanCombo().setEnabled(true);

  }

  /**
   * �u���̑����e��\���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VISIBLE_REASON_MEMO_FALSE() throws Exception {

        getIdouInfoReasonMemo().getParent().setVisible(false);

  }

  /**
   * �u���̑����e�\���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VISIBLE_REASON_MEMO_TRUE() throws Exception {

        getIdouInfoReasonMemo().getParent().setVisible(true);

  }

  /**
   * �u�Ɩ��{�^���ݒ�i�o�^���[�h��ԂɕύX�j�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INSERT_MODE() throws Exception {

        getInsert().setVisible(true);

        getUpdate().setVisible(false);

        getClearInsertMode().setVisible(true);

        getClearUpdateMode().setVisible(false);

  }

  /**
   * �u�Ɩ��{�^���ݒ�i�X�V���[�h��ԂɕύX�j�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_UPDATE_MODE() throws Exception {

        getInsert().setVisible(false);

        getUpdate().setVisible(true);

        getClearInsertMode().setVisible(false);

        getClearUpdateMode().setVisible(true);

  }

  /**
   * �u�ٓ��̈揉�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_IDOU_INIT() throws Exception {

        getIdouInfoChangeContent().setEnabled(false);
        getIdouInfoChangeContent().getParent().setEnabled(false);

        getIdouInfoTime().setEnabled(false);
        getIdouInfoTime().getParent().setEnabled(false);

        getIdouInfoReason().setEnabled(false);
        getIdouInfoReason().getParent().setEnabled(false);

        getIdouInfoReasonMemo().getParent().setVisible(false);

  }

  /**
   * �u�ٓ����R�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_ENABLE_REASON_TRUE() throws Exception {

        getIdouInfoReason().setEnabled(true);
        getIdouInfoReason().getParent().setEnabled(true);

  }

  /**
   * �u�ٓ����R�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_ENABLE_REASON_FALSE() throws Exception {

        getIdouInfoReason().setEnabled(false);
        getIdouInfoReason().getParent().setEnabled(false);

  }

  /**
   * �u�ٓ����R�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_ENABLE_CONTENT_TRUE() throws Exception {

        getIdouInfoChangeContent().setEnabled(true);
        getIdouInfoChangeContent().getParent().setEnabled(true);

  }

  /**
   * �u�ٓ����R�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_ENABLE_CONTENT_FALSE() throws Exception {

        getIdouInfoChangeContent().setEnabled(false);
        getIdouInfoChangeContent().getParent().setEnabled(false);

  }

  /**
   * �u���S���x�z�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_ENABLE_TOKUTEI_NYUSHO_FALSE() throws Exception {

        getShisetsuInfoDinnerBearLimitMoneyText().setEnabled(false);

        getShisetsuInfoUnitRoomLimitMoneyText().setEnabled(false);

        getShisetsuInfoUnitSemiRoomLimitMoneyText().setEnabled(false);

        getShisetsuInfoNormalRoomLimitMoneyText().setEnabled(false);

        getShisetsuInfoNormalRoomLimitMoneyText2().setEnabled(false);

        getShisetsuInfoTasyoRoomLimitMoneyText().setEnabled(false);

        getShisetsuInfoDinnerBearLimitMoneyContena().setEnabled(false);

        getShisetsuInfoDinnerBearLimitMoneyLabel().setEnabled(false);

        getShisetsuInfoUnitRoomLimitMoneyContena().setEnabled(false);

        getShisetsuInfoUnitRoomLimitMoneyLabel().setEnabled(false);

        getShisetsuInfoUnitSemiRoomLimitMoneyContena().setEnabled(false);

        getShisetsuInfoUnitSemiRoomLimitMoneyLabel().setEnabled(false);

        getShisetsuInfoNormalRoomLimitMoneyContena().setEnabled(false);

        getShisetsuInfoNormalRoomLimitMoneyLabel().setEnabled(false);

        getShisetsuInfoNormalRoomLimitMoneyContena2().setEnabled(false);

        getShisetsuInfoNormalRoomLimitMoneyLabel2().setEnabled(false);

        getShisetsuInfoTasyoRoomLimitMoneyContena().setEnabled(false);

        getShisetsuInfoTasyoRoomLimitMoneyLabel().setEnabled(false);

  }

  /**
   * �u���S���x�z�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_ENABLE_TOKUTEI_NYUSHO_TRUE() throws Exception {

        getShisetsuInfoDinnerBearLimitMoneyText().setEnabled(true);

        getShisetsuInfoUnitRoomLimitMoneyText().setEnabled(true);

        getShisetsuInfoUnitSemiRoomLimitMoneyText().setEnabled(true);

        getShisetsuInfoNormalRoomLimitMoneyText().setEnabled(true);

        getShisetsuInfoNormalRoomLimitMoneyText2().setEnabled(true);

        getShisetsuInfoTasyoRoomLimitMoneyText().setEnabled(true);

        getShisetsuInfoDinnerBearLimitMoneyContena().setEnabled(true);

        getShisetsuInfoDinnerBearLimitMoneyLabel().setEnabled(true);

        getShisetsuInfoUnitRoomLimitMoneyContena().setEnabled(true);

        getShisetsuInfoUnitRoomLimitMoneyLabel().setEnabled(true);

        getShisetsuInfoUnitSemiRoomLimitMoneyContena().setEnabled(true);

        getShisetsuInfoUnitSemiRoomLimitMoneyLabel().setEnabled(true);

        getShisetsuInfoNormalRoomLimitMoneyContena().setEnabled(true);

        getShisetsuInfoNormalRoomLimitMoneyLabel().setEnabled(true);

        getShisetsuInfoNormalRoomLimitMoneyContena2().setEnabled(true);

        getShisetsuInfoNormalRoomLimitMoneyLabel2().setEnabled(true);

        getShisetsuInfoTasyoRoomLimitMoneyContena().setEnabled(true);

        getShisetsuInfoTasyoRoomLimitMoneyLabel().setEnabled(true);

  }

  /**
   * �u�{�ݏ��ҏW�s�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_ENABLE_SHISETSU_BUTTON_FALSE() throws Exception {

        getShisetsuInfoButtonEdit().setEnabled(false);

        getShisetsuInfoButtonDelete().setEnabled(false);

  }

  /**
   * �u�{�ݏ��ҏW�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_ENABLE_SHISETSU_BUTTON_TRUE() throws Exception {

        getShisetsuInfoButtonEdit().setEnabled(true);

        getShisetsuInfoButtonDelete().setEnabled(true);

  }

}
