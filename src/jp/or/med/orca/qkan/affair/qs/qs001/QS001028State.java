
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
 * �쐬��: 2006/03/05  ���{�R���s���[�^�[������� �c���@���� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �\��Ǘ� (S)
 * �v���Z�X ����f�Ô��� (001)
 * �v���O���� ����f�Ô��� (QS001028)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
/**
 * ����f�Ô��ʏ�Ԓ�`(QS001028) 
 */
public class QS001028State extends QS001028Design {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001028State(){
  }

  /**
   * �u�V�l���F�m�ǎ����×{�a���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_OLD_COGNITIVE_WARD() throws Exception {

        if(getParticularInstitutionManagment().getParent()!=null){
          getParticularInstitutionManagment().getParent().remove(getParticularInstitutionManagment());
        }

        if(getParticularInstitutionManagmentPrivateRoom().getParent()!=null){
          getParticularInstitutionManagmentPrivateRoom().getParent().remove(getParticularInstitutionManagmentPrivateRoom());
        }

        if(getParticularInstitutionManagmentPrivateRoom2().getParent()!=null){
          getParticularInstitutionManagmentPrivateRoom2().getParent().remove(getParticularInstitutionManagmentPrivateRoom2());
        }

        if(getHeavySkinManegement().getParent()!=null){
          getHeavySkinManegement().getParent().remove(getHeavySkinManegement());
        }

        if(getCareNutritionDinnerLeading().getParent()!=null){
          getCareNutritionDinnerLeading().getParent().remove(getCareNutritionDinnerLeading());
        }

        if(getMedicineManegementLeading().getParent()!=null){
          getMedicineManegementLeading().getParent().remove(getMedicineManegementLeading());
        }

        if(getSpecialMedicineManagementLeading().getParent()!=null){
          getSpecialMedicineManagementLeading().getParent().remove(getSpecialMedicineManagementLeading());
        }

        if(getMedicalScienceInfo1().getParent()!=null){
          getMedicalScienceInfo1().getParent().remove(getMedicalScienceInfo1());
        }

        if(getMedicalScienceInfo2().getParent()!=null){
          getMedicalScienceInfo2().getParent().remove(getMedicalScienceInfo2());
        }

        if(getScienceTherapy().getParent()!=null){
          getScienceTherapy().getParent().remove(getScienceTherapy());
        }

        if(getWorkTherapyFrame().getParent()!=null){
          getWorkTherapyFrame().getParent().remove(getWorkTherapyFrame());
        }

        if(getEtcFrame().getParent()!=null){
          getEtcFrame().getParent().remove(getEtcFrame());
        }

  }

  /**
   * �u�������@�f�ÊǗ��E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_BEGINNIGN_GUIDANCE() throws Exception {

        if(getBeginningGuidanceManagement().getParent()!=null){
          getBeginningGuidanceManagement().getParent().remove(getBeginningGuidanceManagement());
        }

  }

  /**
   * �u���w�Ö@�i�h�j�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_SCIENCE_THERAPY1() throws Exception {

        getScienceTherapy1Combo().setEnabled(false);

  }

  /**
   * �u���w�Ö@�i�h�j�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VALID_SCIENCE_THERAPY1() throws Exception {

        getScienceTherapy1Combo().setEnabled(true);

  }

  /**
   * �u���w�Ö@�i�h�h�j�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_SCIENCE_THERAPY2() throws Exception {

        getScienceTherapy2Combo().setEnabled(false);

  }

  /**
   * �u���w�Ö@�i�h�h�j�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VALID_SCIENCE_THERAPY2() throws Exception {

        getScienceTherapy2Combo().setEnabled(true);

  }

  /**
   * �u���w�Ö@�i�h�h�h�j�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_SCIENCE_THERAPY3() throws Exception {

        getScienceTherapy3Combo().setEnabled(false);

  }

  /**
   * �u���w�Ö@�i�h�h�h�j�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VALID_SCIENCE_THERAPY3() throws Exception {

        getScienceTherapy3Combo().setEnabled(true);

  }

  /**
   * �u���w�Ö@�i�h�u�j�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_SCIENCE_THERAPY4() throws Exception {

        getScienceTherapy4Combo().setEnabled(false);

  }

  /**
   * �u���w�Ö@�i�h�u�j�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VALID_SCIENCE_THERAPY4() throws Exception {

        getScienceTherapy4Combo().setEnabled(true);

  }

  /**
   * �u���w�i�h�j�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_SCIENCE1() throws Exception {

        getScience1Combo().setEnabled(false);

  }

  /**
   * �u���w�i�h�j�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VALID_SCIENCE1() throws Exception {

        getScience1Combo().setEnabled(true);

  }

  /**
   * �u���w�i�h�h�j�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_SCIENCE2() throws Exception {

        getScience2Combo().setEnabled(false);

  }

  /**
   * �u���w�i�h�h�j�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VALID_SCIENCE2() throws Exception {

        getScience2Combo().setEnabled(true);

  }

  /**
   * �u���w�i�h�h�h�j�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_SCIENCE3() throws Exception {

        getScience3Combo().setEnabled(false);

  }

  /**
   * �u���w�i�h�h�h�j�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VALID_SCIENCE3() throws Exception {

        getScience3Combo().setEnabled(true);

  }

  /**
   * �u���w�i�h�u�j�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_SCIENCE4() throws Exception {

        getScience4Combo().setEnabled(false);

  }

  /**
   * �u���w�i�h�u�j�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VALID_SCIENCE4() throws Exception {

        getScience4Combo().setEnabled(true);

  }

  /**
   * �u���퐶�������P�����Z�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_NORMAL_LIFE_() throws Exception {

        getNormalLifeCombo().setEnabled(false);

  }

  /**
   * �u���퐶�������P�����Z�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VALID_NORMAL_LIFE_() throws Exception {

        getNormalLifeCombo().setEnabled(true);

  }

  /**
   * �u��ƗÖ@I�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_WORK_THERAPY1() throws Exception {

        getWorkTherapy1Combo().setEnabled(false);

  }

  /**
   * �u��ƗÖ@I�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VALID_WORK_THERAPY1() throws Exception {

        getWorkTherapy1Combo().setEnabled(true);

  }

  /**
   * �u��ƗÖ@II�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_WORK_THERAPY2() throws Exception {

        getWorkTherapy2Combo().setEnabled(false);

  }

  /**
   * �u��ƗÖ@II�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VALID_WORK_THERAPY2() throws Exception {

        getWorkTherapy2Combo().setEnabled(true);

  }

  /**
   * �u���I�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_WORK1() throws Exception {

        getWork1Combo().setEnabled(false);

  }

  /**
   * �u���I�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VALID_WORK1() throws Exception {

        getWork1Combo().setEnabled(true);

  }

  /**
   * �u���II�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_WORK2() throws Exception {

        getWork2Combo().setEnabled(false);

  }

  /**
   * �u���II�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VALID_WORK2() throws Exception {

        getWork2Combo().setEnabled(true);

  }

  /**
   * �u���퐶�����������Z�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_NORMAL_LIFE2() throws Exception {

        getNormalLife2Combo().setEnabled(false);

  }

  /**
   * �u���퐶�����������Z�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VALID_NORMAL_LIFE2() throws Exception {

        getNormalLife2Combo().setEnabled(true);

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
   * �u���꒮�o�Ö@�h�h�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_LANGUAGE_THERAPY2() throws Exception {

        getLanguageTherapy2Combo().setEnabled(false);

  }

  /**
   * �u���꒮�o�Ö@�h�h�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VALID_LANGUAGE_THERAPY2() throws Exception {

        getLanguageTherapy2Combo().setEnabled(true);

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
   * �u���꒮�o(II)�E�����v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_INVALID_LANGUAGE2() throws Exception {

        getLanguage2Combo().setEnabled(false);

  }

  /**
   * �u���꒮�o(II)�E�L���v�̏�Ԃɐݒ肵�܂��B
   * @throws Exception ������O
   */
  public void setState_VALID_LANGUAGE2() throws Exception {

        getLanguage2Combo().setEnabled(true);

  }

}
