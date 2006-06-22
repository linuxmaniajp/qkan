
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
 * �쐬��: 2006/01/16  ���{�R���s���[�^�[������� ����@��F �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���[�Ǘ� (C)
 * �v���Z�X �K��Ō�L�^���T (004)
 * �v���O���� �K��Ō�L�^���T NO.1 (QC00401)
 *
 *****************************************************************
 */

package jp.or.med.orca.qkan.affair.qc.qc004;

import jp.nichicom.ac.pdf.ACChotarouXMLWriter;
import jp.nichicom.vr.util.VRMap;

/**
 * �K��Ō�L�^���T NO.1�C�x���g��`(QC00401) 
 * ���[��`�̃t�@�C���� �F QC00401.xml
 */
public abstract class QC004P01Event  {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QC004P01Event(){
  }
  /**
   * ������܂��B
   * @param writer ����Ǘ��N���X
   * @param printParam ����p�����^
   * @throws Exception ������O
   */
  public abstract boolean doPrint(ACChotarouXMLWriter writer, VRMap printParam) throws Exception;

  //�ϐ���`
  public static final int MALE=1;
  public static final int FEMALE=2;
  //getter/setter

}
