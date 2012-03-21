
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
 * �쐬��: 2005/12/19  ���{�R���s���[�^�[������� ����@��F �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���[�Ǘ� (C)
 * �v���Z�X �V�l�K��Ō�E�K��Ō�̏��񋟏� (003)
 * �v���O���� �V�l�K��Ō�E�K��Ō�̏��񋟏� (QC00301)
 *
 *****************************************************************
 */

package jp.or.med.orca.qkan.affair.qc.qc003;

import jp.nichicom.ac.pdf.ACChotarouXMLWriter;
import jp.nichicom.vr.util.VRMap;

/**
 * �V�l�K��Ō�E�K��Ō�̏��񋟏��C�x���g��`(QC00301) 
 * ���[��`�̃t�@�C���� �F QC00301.xml
 */
public abstract class QC003P01Event  {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QC003P01Event(){
  }
  /**
   * ������܂��B
   * @param writer ����Ǘ��N���X
   * @param printParam ����p�����^
   * @throws Exception ������O
   */
  public abstract boolean doPrint(ACChotarouXMLWriter writer, VRMap printParam) throws Exception;

  //�ϐ���`

  //getter/setter

}
