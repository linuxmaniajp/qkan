
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
 * �쐬��: 2012/02/17  ���{�R���s���[�^�[������� ����@��F �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �\��Ǘ� (S)
 * �v���Z�X �T�[�r�X�\�� (001)
 * �v���O���� �T�[�r�X�p�^�[�����\�h�K��Ō� (QS001_16311_201504)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
/**
 * �T�[�r�X�p�^�[�����\�h�K��Ō��Ԓ�`(QS001_16311_201504) 
 */
public class QS001_16311_201504State extends QS001_16311_201504Design {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001_16311_201504State(){
  }

  /**
   * �u��ʏ��1�E�K��Ō�X�e�[�V����-���ŁE�y��-���ԋ敪-20�������ȊO�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_STATE_MODE_1() throws Exception {

        getHoumonKangoKaigoClass3().setEnabled(true);

        getHoumonKangoKaigoTime().setEnabled(true);

        getTwoOrMoreTimesCheck().setEnabled(false);

  }

  /**
   * �u��ʏ��2�E�K��Ō�X�e�[�V����-���ŁE�y��-���ԋ敪-20�������v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_STATE_MODE_2() throws Exception {

        getHoumonKangoKaigoClass3().setEnabled(true);

        getHoumonKangoKaigoTime().setEnabled(true);

        getTwoOrMoreTimesCheck().setEnabled(false);

  }

  /**
   * �u��ʏ��3�E�K��Ō�X�e�[�V����-���w�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_STATE_MODE_3() throws Exception {

        getHoumonKangoKaigoClass3().setEnabled(true);

        getHoumonKangoKaigoTime().setEnabled(false);

        getTwoOrMoreTimesCheck().setEnabled(true);

  }

  /**
   * �u��ʏ��4�E��Ë@��-���ŁE�y��-���ԋ敪-20�������ȊO�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_STATE_MODE_4() throws Exception {

        getHoumonKangoKaigoClass3().setEnabled(false);

        getHoumonKangoKaigoTime().setEnabled(true);

        getTwoOrMoreTimesCheck().setEnabled(false);

  }

  /**
   * �u��ʏ��5�E��Ë@��-���ŁE�y��-���ԋ敪-20�������v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_STATE_MODE_5() throws Exception {

        getHoumonKangoKaigoClass3().setEnabled(false);

        getHoumonKangoKaigoTime().setEnabled(true);

        getTwoOrMoreTimesCheck().setEnabled(false);

  }

  /**
   * �u��ʏ��6�E��Ë@��-���w�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_STATE_MODE_6() throws Exception {

        getHoumonKangoKaigoClass3().setEnabled(false);

        getHoumonKangoKaigoTime().setEnabled(false);

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

}
