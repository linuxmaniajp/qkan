
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
 * �쐬��: 2009/04/03  ���{�R���s���[�^�[������� ��i�@�a�P �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �����f�[�^�쐬 (P)
 * �v���Z�X �m�F�E�C�� (004)
 * �v���O���� ���׏���{���ҏW (QP004)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qp.qp004;
import java.awt.Container;
/**
 * ���׏���{���ҏW��Ԓ�`(QP004) 
 */
public class QP004State extends QP004Design {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QP004State(){
  }

  /**
   * �u��ԃR���g���[���l�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_STATE_TYPE_2() throws Exception {

        getTekiyos().setVisible(true);

        getShinryos().setVisible(false);

        getKyotakuIdouGroup().setVisible(true);

        getShisetsuIdouGroup().setVisible(false);

  }

  /**
   * �u��ԃR���g���[���l�����̎O�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_STATE_TYPE_23() throws Exception {

        getTekiyos().setVisible(true);

        getShinryos().setVisible(false);

        getKyotakuIdouGroup().setVisible(true);

        getShisetsuIdouGroup().setVisible(false);

        if(getContentsStopReasons().getParent()!=null){
          Container parentContainer = getContentsStopReasons().getParent();
          if(parentContainer.getParent()!=null){
            parentContainer.getParent().remove(parentContainer);
          }
        }

  }

  /**
   * �u��ԃR���g���[���l����O�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_STATE_TYPE_3() throws Exception {

        getContentsNyushoDays().getParent().setVisible(false);

        getContentsTankiNyushoDays().getParent().setVisible(true);

        getContentsGaihakuDays().getParent().setVisible(false);

        getContentsTaishoJotais().getParent().setVisible(false);

        getTekiyos().setVisible(true);

        getShinryos().setVisible(false);

        getKyotakuIdouGroup().setVisible(false);

        getShisetsuIdouGroup().setVisible(true);

  }

  /**
   * �u��ԃR���g���[���l����l�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_STATE_TYPE_4() throws Exception {

        getContentsNyushoDays().getParent().setVisible(false);

        getContentsTankiNyushoDays().getParent().setVisible(true);

        getContentsGaihakuDays().getParent().setVisible(false);

        getContentsTaishoJotais().getParent().setVisible(false);

        getTekiyos().setVisible(true);

        getShinryos().setVisible(false);

        getKyotakuIdouGroup().setVisible(false);

        getShisetsuIdouGroup().setVisible(true);

  }

  /**
   * �u��ԃR���g���[���l����܁v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_STATE_TYPE_5() throws Exception {

        getContentsNyushoDays().getParent().setVisible(false);

        getContentsTankiNyushoDays().getParent().setVisible(true);

        getContentsGaihakuDays().getParent().setVisible(false);

        getContentsTaishoJotais().getParent().setVisible(false);

        getTekiyos().setVisible(true);

        getShinryos().setVisible(true);

        getKyotakuIdouGroup().setVisible(false);

        getShisetsuIdouGroup().setVisible(true);

  }

  /**
   * �u��ԃR���g���[���l����Z�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_STATE_TYPE_6() throws Exception {

        getContentsNyushoDays().getParent().setVisible(true);

        getContentsTankiNyushoDays().getParent().setVisible(false);

        getTekiyos().setVisible(true);

        getShinryos().setVisible(false);

        getKyotakuIdouGroup().setVisible(false);

        getShisetsuIdouGroup().setVisible(true);

  }

  /**
   * �u��ԃR���g���[���l���攪�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_STATE_TYPE_8() throws Exception {

        getContentsNyushoDays().getParent().setVisible(true);

        getContentsTankiNyushoDays().getParent().setVisible(false);

        getTekiyos().setVisible(true);

        getShinryos().setVisible(false);

        getKyotakuIdouGroup().setVisible(false);

        getShisetsuIdouGroup().setVisible(true);

  }

  /**
   * �u��ԃR���g���[���l�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_STATE_TYPE_9() throws Exception {

        getContentsNyushoDays().getParent().setVisible(true);

        getContentsTankiNyushoDays().getParent().setVisible(false);

        getTekiyos().setVisible(true);

        getShinryos().setVisible(false);

        getKyotakuIdouGroup().setVisible(false);

        getShisetsuIdouGroup().setVisible(true);

  }

  /**
   * �u��ԃR���g���[���l����\�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_STATE_TYPE_10() throws Exception {

        getContentsNyushoDays().getParent().setVisible(true);

        getContentsTankiNyushoDays().getParent().setVisible(false);

        getTekiyos().setVisible(true);

        getShinryos().setVisible(true);

        getKyotakuIdouGroup().setVisible(false);

        getShisetsuIdouGroup().setVisible(true);

  }

  /**
   * �u��ԃR���g���[���l����Z�̌܋y�јZ�̘Z�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_STATE_TYPE_65() throws Exception {

        getContentsNyushoDays().getParent().setVisible(false);

        getContentsTankiNyushoDays().getParent().setVisible(true);

        getContentsGaihakuDays().getParent().setVisible(false);

        getContentsTaishoJotais().getParent().setVisible(false);

        getTekiyos().setVisible(true);

        getShinryos().setVisible(false);

        getKyotakuIdouGroup().setVisible(false);

        getShisetsuIdouGroup().setVisible(true);

  }

  /**
   * �u��ԃR���g���[�������O��\���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_STATE_NYUSYO_HIDE() throws Exception {

        if(getContentsNyushoJotais().getParent()!=null){
          Container parentContainer = getContentsNyushoJotais().getParent();
          if(parentContainer.getParent()!=null){
            parentContainer.getParent().remove(parentContainer);
          }
        }

  }

  /**
   * �u��ԃR���g���[�������O�\���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_STATE_NYUSYO_SHOW() throws Exception {

        getContentsNyushoJotais().setVisible(true);

  }

}
