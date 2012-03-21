
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
 * �쐬��: 2007/12/19  ���{�R���s���[�^�[������� �� ���� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���p�ҊǗ� (U)
 * �v���Z�X ���p�҈ꗗ (001)
 * �v���O����  (QU001)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qu.qu001;
/**
 * ��Ԓ�`(QU001) 
 */
public class QU001State extends QU001Design {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QU001State(){
  }

  /**
   * �u���p�ғo�^�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INIT_PATIENT() throws Exception {

        getFind().setVisible(true);

        getDetail().setVisible(true);

        getInsert().setVisible(true);

        getDelete().setVisible(true);

        getPrint().setVisible(true);

        getPlanInsert().setVisible(false);

        getResultInsert().setVisible(false);

        getTargetDate().getParent().setVisible(false);

        getPatientFinishFlagColumn().setVisible(false);

        getPatientChoiseColumn().setVisible(false);

        getPatientReportColumn().setVisible(false);

        getPrintReport().setVisible(false);

        getProviderFindContents().setVisible(false);

  }

  /**
   * �u�T�[�r�X�\��v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INIT_SERVICE_PLAN() throws Exception {

        getFind().setVisible(true);

        getDetail().setVisible(false);

        getInsert().setVisible(false);

        getDelete().setVisible(false);

        getPrint().setVisible(false);

        getPlanInsert().setVisible(true);

        getResultInsert().setVisible(false);

        getTargetDate().setVisible(true);

        getPatientFinishFlagColumn().setVisible(false);

        getPatientChoiseColumn().setVisible(false);

        getPatientReportColumn().setVisible(false);

        getPrintReport().setVisible(false);

        getProviderFindContents().setVisible(false);

  }

  /**
   * �u�T�[�r�X���сv�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INIT_SERVICE_RESULT() throws Exception {

        getFind().setVisible(true);

        getDetail().setVisible(false);

        getInsert().setVisible(false);

        getDelete().setVisible(false);

        getPrint().setVisible(false);

        getPlanInsert().setVisible(false);

        getResultInsert().setVisible(true);

        getTargetDate().setVisible(true);

        getPatientFinishFlagColumn().setVisible(false);

        getPatientChoiseColumn().setVisible(false);

        getPatientReportColumn().setVisible(false);

        getPrintReport().setVisible(false);

        getProviderFindContents().setVisible(false);

  }

  /**
   * �u�K��Ō�v�揑�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INIT_HOMONKANGO_PLAN() throws Exception {

        getFind().setVisible(true);

        getDetail().setVisible(true);

        getInsert().setVisible(false);

        getDelete().setVisible(false);

        getPrint().setVisible(false);

        getPlanInsert().setVisible(false);

        getResultInsert().setVisible(false);

        getTargetDate().setVisible(true);

        getPatientFinishFlagColumn().setVisible(false);

        getPatientChoiseColumn().setVisible(false);

        getPatientReportColumn().setVisible(false);

        getPrintReport().setVisible(false);

        getProviderFindContents().setVisible(false);

  }

  /**
   * �u�K��Ō�񍐏��v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INIT_HOMONKANGO_RESULT() throws Exception {

        getFind().setVisible(true);

        getDetail().setVisible(true);

        getInsert().setVisible(false);

        getDelete().setVisible(false);

        getPrint().setVisible(false);

        getPlanInsert().setVisible(false);

        getResultInsert().setVisible(false);

        getTargetDate().setVisible(true);

        getPatientFinishFlagColumn().setVisible(false);

        getPatientChoiseColumn().setVisible(false);

        getPatientReportColumn().setVisible(false);

        getPrintReport().setVisible(false);

        getProviderFindContents().setVisible(false);

  }

  /**
   * �u�K��Ō���񋟏��v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INIT_HOMONKANGO_JOHO_TEIKYOSHO() throws Exception {

        getFind().setVisible(true);

        getDetail().setVisible(true);

        getInsert().setVisible(false);

        getDelete().setVisible(false);

        getPrint().setVisible(false);

        getPlanInsert().setVisible(false);

        getResultInsert().setVisible(false);

        getTargetDate().setVisible(true);

        getPatientFinishFlagColumn().setVisible(false);

        getPatientChoiseColumn().setVisible(false);

        getPatientReportColumn().setVisible(false);

        getPrintReport().setVisible(false);

        getProviderFindContents().setVisible(false);

  }

  /**
   * �u�K��Ō�L�^���T�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INIT_HOMONKANGO_KIROKUSHO() throws Exception {

        getFind().setVisible(true);

        getDetail().setVisible(true);

        getInsert().setVisible(false);

        getDelete().setVisible(false);

        getPrint().setVisible(false);

        getPlanInsert().setVisible(false);

        getResultInsert().setVisible(false);

        getTargetDate().setVisible(true);

        getPatientFinishFlagColumn().setVisible(false);

        getPatientChoiseColumn().setVisible(false);

        getPatientReportColumn().setVisible(false);

        getPrintReport().setVisible(false);

        getProviderFindContents().setVisible(false);

  }

  /**
   * �u����K��Ō�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INIT_KYOTAKU() throws Exception {

        getFind().setVisible(true);

        getDetail().setVisible(true);

        getInsert().setVisible(false);

        getDelete().setVisible(false);

        getPrint().setVisible(false);

        getPlanInsert().setVisible(false);

        getResultInsert().setVisible(false);

        getTargetDate().setVisible(true);

        getPatientFinishFlagColumn().setVisible(true);

        getPatientChoiseColumn().setVisible(true);

        getPatientReportColumn().setVisible(true);

        getPrintReport().setVisible(true);

        getProviderFindContents().setVisible(true);

  }

  /**
   * �u�e�[�u���s�I����ԁv�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_SELECTED() throws Exception {

        getDetail().setEnabled(true);

        getDelete().setEnabled(true);

        getPrint().setEnabled(true);

        getPlanInsert().setEnabled(true);

        getResultInsert().setEnabled(true);

        getPrintReport().setEnabled(true);

  }

  /**
   * �u�e�[�u���s���I����ԁv�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_UNSELECTED() throws Exception {

        getDetail().setEnabled(false);

        getDelete().setEnabled(false);

        getPlanInsert().setEnabled(false);

        getResultInsert().setEnabled(false);

  }

}
