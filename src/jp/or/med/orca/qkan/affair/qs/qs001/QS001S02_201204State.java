
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
 * �쐬��: 2010/11/05  ���{�R���s���[�^�[������� ����@��F �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �\��Ǘ� (S)
 * �v���Z�X ���ʗ×{���� (001)
 * �v���O���� ���ʗ×{���� (QS001200)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
/**
 * ���ʗ×{���ʏ�Ԓ�`(QS001200) 
 */
@SuppressWarnings("serial")
public class QS001S02_201204State extends QS001S02_201204Design {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001S02_201204State(){
  }

  /**
   * �u���������f�ÊǗ��E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_BEGINNIGN_GUIDANCE() throws Exception {

        if(getBeginningGuidanceManagement().getParent()!=null){
          getBeginningGuidanceManagement().getParent().remove(getBeginningGuidanceManagement());
        }

  }

  /**
   * �u���꒮�o�Ö@�h�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_LANGUAGE_THERAPY1() throws Exception {

        getLanguageTherapy1Combo().setEnabled(false);

  }

  /**
   * �u���꒮�o�Ö@�h�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VALID_LANGUAGE_THERAPY1() throws Exception {

        getLanguageTherapy1Combo().setEnabled(true);

  }

  /**
   * �u���꒮�o(I)�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_LANGUAGE1() throws Exception {

        getLanguage1Combo().setEnabled(false);

  }

  /**
   * �u���꒮�o(I)�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VALID_LANGUAGE1() throws Exception {

        getLanguage1Combo().setEnabled(true);

  }

  /**
   * �u�V�l�ی��{�݊֘A�v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_HEALTH_FACILITIES_WARD() throws Exception {

        getInfectionGuidanceManagement().setVisible(true);

        getBedGuidanceManagement().setVisible(true);

        getBeginningGuidanceManagement().setVisible(true);

        getHeavyRecuperateGuidanceManagement().setVisible(true);

        getParticularInstitutionManagment().setVisible(true);

        getParticularInstitutionManagmentPrivateRoom().setVisible(true);

        getParticularInstitutionManagmentPrivateRoom2().setVisible(true);

        getHeavySkinManegement().setVisible(true);

        getMedicineManegementLeading().setVisible(true);

        getRehabilitationManegement().setVisible(true);

        getSpecialMedicineManagementLeading().setVisible(true);

        getMedicalScienceInfo().setVisible(true);

        getLanguageTherapy1Combo().setVisible(true);

        getLanguage1Combo().setVisible(true);

        getMindTherapy().setVisible(true);

        getCognitive().setVisible(true);

        getEtcFrame().setVisible(true);

        getRehabilitationSystemCombo().setVisible(true);

  }

  /**
   * �u���n�r���e�[�V�����w���Ǘ��E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_REHABILITATION_MANEGEMENT() throws Exception {

        if(getRehabilitationManegement().getParent()!=null){
          getRehabilitationManegement().getParent().remove(getRehabilitationManegement());
        }

  }

  /**
   * �u�d�x�×{�Ǘ��E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_HEAVY_RECUPERATE() throws Exception {

        if(getHeavyRecuperateGuidanceManagement().getParent()!=null){
          getHeavyRecuperateGuidanceManagement().getParent().remove(getHeavyRecuperateGuidanceManagement());
        }

  }

  /**
   * �u���n�r���̐��������Z�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_RIHABIRI_SYSTEM() throws Exception {

        getRehabilitationSystemCombo().setEnabled(false);

  }

  /**
   * �u���n�r���̐��������Z�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VALID_RIHABIRI_SYSTEM() throws Exception {

        getRehabilitationSystemCombo().setEnabled(true);

  }

}
