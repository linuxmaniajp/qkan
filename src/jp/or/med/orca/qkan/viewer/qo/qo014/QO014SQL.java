
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
 * �J����: 
 * �쐬��: 2012/09/19  ���{�R���s���[�^�[�������  �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e��  (O)
 * �v���Z�X  (014)
 * �v���O����  (QO014)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.viewer.qo.qo014;
import jp.nichicom.vr.util.VRMap;

/**
 * SQL��`(QO014) 
 */
@SuppressWarnings("serial")
public class QO014SQL extends QO014State {
  
  /**
   * �R���X�g���N�^�ł��B
   */
  public QO014SQL() {
  }

  /**
   * �u�Ɩ������擾����v�̂��߂�SQL��Ԃ��܂��B
   * @param sqlParam SQL�\�z�ɕK�v�ȃp�����^���i�[�����n�b�V���}�b�v
   * @throws Exception ������O
   * @return SQL��
   */
  public String getSQL_GET_AFFAIR_INFO(VRMap sqlParam) throws Exception{
    StringBuilder sb = new StringBuilder();

    sb.append("SELECT");

    sb.append(" AFFAIR_ID");

    sb.append(",MODE");

    sb.append(",WINDOW_TITLE");

    sb.append(" FROM");

    sb.append(" M_AFFAIR_INFO");

    return sb.toString();
  }

}
